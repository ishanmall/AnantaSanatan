package com.sanatangyansagar.ui.screens.upnishad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// Data Model
data class AmritabinduShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmritabinduUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                if (shlokaNumber != null && shlokaNumber in 1..22) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-22)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(amritabinduShlokasList) { _, shloka ->
                AmritabinduShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AmritabinduShlokaCard(shloka: AmritabinduShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Shloka ${shloka.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFD84315)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = shloka.sanskrit,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

val amritabinduShlokasList: List<AmritabinduShloka> = listOf(
    AmritabinduShloka(
        id = 1,
        sanskrit = "मनो हि द्विविधं प्रोक्तं शुद्धं चाशुद्धमेव च । अशुद्धं कामसंकल्पं शुद्धं कामविवर्जितम् ॥ १ ॥",
        hindi = """
            यह मन निश्चित रूप से दो प्रकार का कहा गया है—एक शुद्ध और दूसरा अशुद्ध।
            अशुद्ध मन वह है जो सांसारिक इच्छाओं और संकल्पों (काम) में पूरी तरह फँसा रहता है।
            शुद्ध मन वह है जो सभी प्रकार की भौतिक कामनाओं और वासनाओं से पूरी तरह रहित होता है।
            यह उपनिषद का सबसे प्रसिद्ध और क्रांतिकारी सूत्र है जो मन की प्रकृति को समझाता है।
            मन स्वयं में बुरा नहीं है, केवल उसकी दिशा (Attachment) उसे बुरा या अच्छा बनाती है।
            जब मन बाहर की वस्तुओं में सुख ढूँढता है, तो वह अशुद्ध और अशांत हो जाता है।
            परंतु जब वही मन विषयों को छोड़कर शांति की ओर मुड़ता है, तो वह शुद्ध हो जाता है।
            अशुद्धता का अर्थ केवल पाप नहीं, बल्कि भविष्य की व्यर्थ चिंताओं का संकल्प भी है।
            शुद्धता का अर्थ है मन का बिल्कुल शांत, निर्विकार और वर्तमान में स्थिर होना।
            यहीं से आत्मज्ञान की यात्रा शुरू होती है, जहाँ हमें अपने मन को पहचानना होता है।
        """.trimIndent(),
        english = """
            The mind is indeed stated to be of two kinds—the pure and the impure.
            The impure mind is that which is deeply possessed by desires and resolves (Kama).
            The pure mind is that which is completely free from all material cravings and lusts.
            This is the most famous and revolutionary verse explaining the dual nature of mind.
            The mind is not inherently evil; only its direction and attachment define its quality.
            When the mind seeks happiness in external objects, it becomes impure and restless.
            However, when the same mind turns away from objects toward peace, it becomes pure.
            Impurity does not mean just sin; it also refers to the constant resolve for future desires.
            Purity implies a state where the mind is absolutely calm, detached, and still in the Now.
            The journey to Self-realization begins here by identifying the current state of our mind.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 2,
        sanskrit = "मन एव मनुष्याणां कारणं बन्धमोक्षयोः । बन्धाय विषयासक्तं मुक्त्यै निर्विषयं स्मृतम् ॥ २ ॥",
        hindi = """
            मन ही मनुष्यों के बंधन (गुलामी) और मोक्ष (आज़ादी) का एकमात्र वास्तविक कारण है।
            विषयों (भोगों) में आसक्त मन मनुष्य को संसार के दुखों और जन्म-मरण में बाँध देता है।
            परंतु विषयों से रहित और विरक्त मन ही मनुष्य को परम मुक्ति और शांति प्रदान करता है।
            यह श्लोक संपूर्ण मनोविज्ञान और अध्यात्म का महा-सिद्धांत (Grand Theory) प्रस्तुत करता है।
            हम सोचते हैं कि परिस्थितियां हमें दुखी करती हैं, पर वास्तव में हमारा मन ही जिम्मेदार है।
            यदि मन किसी चीज़ को पकड़ ले, तो वह बंधन बन जाता है; यदि छोड़ दे, तो वही मुक्ति है।
            मुक्ति कहीं बाहर नहीं है; यह मन की एक ऐसी अवस्था है जहाँ कोई 'लालच' शेष नहीं रहता।
            एक ही मन नर्क की आग बना सकता है और वही मन स्वर्ग का आनंद भी दे सकता है।
            सारा खेल 'आसक्ति' (Attachment) का है; आसक्ति ही बेड़ी है और अनासक्ति ही कुल्हाड़ी है।
            जो व्यक्ति अपने मन को वश में कर लेता है, वह पूरे ब्रह्मांड का विजेता बन जाता है।
        """.trimIndent(),
        english = """
            The mind alone is the cause of bondage and liberation for all human beings.
            The mind attached to sense-objects leads to bondage and the cycle of birth and death.
            The mind that is free from sense-objects is considered the means for absolute liberation.
            This verse presents the Grand Theory of all spiritual and psychological sciences.
            We falsely believe external circumstances cause us grief, but the mind is the sole culprit.
            If the mind clings to an object, it creates a chain; if it lets go, that is freedom.
            Liberation is not a distant place; it is a mental state where no 'craving' remains.
            The same mind can create the fires of hell or the supreme joys of heaven.
            The entire game is of attachment; attachment is the shackle, and detachment is the axe.
            One who successfully masters his own mind becomes the true conqueror of the universe.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 3,
        sanskrit = "यतो निर्विषयस्यास्य मनसो मुक्तिरिष्यते । अतो निर्विषयं नित्यं मनः कार्यं मुमुक्षुणा ॥ ३ ॥",
        hindi = """
            चूंकि विषयों से रहित मन ही मुक्ति का साधन है, इसलिए मुमुक्षु को सदा प्रयत्न करना चाहिए।
            मोक्ष की इच्छा रखने वाले साधक को अपने मन को हमेशा विषयों से हटाकर निर्विषय बनाना चाहिए।
            बिना मन की शुद्धि और विरक्ति के, मुक्ति की कल्पना करना भी व्यर्थ और असंभव है।
            यहाँ 'मुमुक्षु' के लिए एक अत्यंत सक्रिय और व्यावहारिक निर्देश (Direction) दिया गया है।
            मुक्ति कोई एक्सीडेंट नहीं है; इसके लिए मन पर लगातार काम करना पड़ता है (कार्यं)।
            जैसे शरीर को साफ रखने के लिए रोज नहाना पड़ता है, वैसे ही मन को रोज निर्विषय करना पड़ता है।
            निर्विषय होने का अर्थ दुनिया को छोड़ना नहीं, बल्कि दुनिया की 'पकड़' से आज़ाद होना है।
            साधक को हर पल जागरूक रहना चाहिए कि उसका मन कहीं किसी वासना में तो नहीं उलझ रहा।
            जब मन किसी भी बाहरी सहारे के बिना अकेले खड़ा रह सके, तभी वह बुद्धत्व को प्राप्त होता है।
            यह श्लोक निरंतर अभ्यास (Abhyasa) और सजगता के महत्व को बहुत गहराई से रेखांकित करता है।
        """.trimIndent(),
        english = """
            Since liberation is desired through a mind free from objects, one must act accordingly.
            Therefore, the seeker of liberation (Mumukshu) should always keep the mind free from objects.
            Without the purification and detachment of the mind, liberation is entirely impossible.
            Here, a very active and practical direction is provided for the seeker (Mumukshu).
            Liberation is not an accident; it requires consistent work (Karyam) on the internal mind.
            Just as the body needs daily bathing, the mind needs daily cleansing from sensory objects.
            Being 'Nirvishaya' doesn't mean leaving the world, but becoming free from the 'grip' of objects.
            A seeker must be alert every moment, ensuring the mind isn't tangled in some latent craving.
            When the mind can stand alone without any external support, it attains the state of Buddha.
            This verse deeply underlines the vital importance of consistent practice and mindfulness.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 4,
        sanskrit = "निरस्तविषयासङ्गं सन्निरुद्धं मनो हृदि । यदाऽऽयात्यात्मनो भावं तदा तत्परमं पदम् ॥ ४ ॥",
        hindi = """
            जब मन विषयों की आसक्ति को पूरी तरह त्याग देता है और हृदय में पूरी तरह स्थिर हो जाता है।
            और जब वह अपनी चंचलता छोड़कर उस परम आत्मा के भाव (स्वरूप) को पूरी तरह प्राप्त कर लेता है।
            तब वह मन अपनी परम अवस्था को पहुँच जाता है, जिसे 'परम पद' (सर्वोच्च स्थिति) कहा जाता है।
            यह ध्यान (Meditation) की उस चरम गहराई का वर्णन है जहाँ मन 'अमन' हो जाता है।
            हृदय में निरोध का अर्थ है कि मन अब बाहर नहीं भाग रहा, वह अपने स्रोत (Source) पर लौट आया है।
            जैसे नदी समुद्र में मिलकर समुद्र हो जाती है, वैसे ही मन आत्मा में मिलकर आत्मा हो जाता है।
            परम पद कोई भौगोलिक स्थान नहीं है, बल्कि यह वह शांति है जो शब्दों के पार है।
            यहाँ पहुँचकर ज्ञाता, ज्ञान और ज्ञेय का सारा भेद पूरी तरह से मिटकर एक हो जाता है।
            जब मन को अपनी असली पहचान मिल जाती है, तो उसे दुनिया के किसी भी खिलौने की जरूरत नहीं रहती।
            यही वह अंतिम लक्ष्य है जिसके लिए सभी योग और तपस्याएं सदियों से की जा रही हैं।
        """.trimIndent(),
        english = """
            When the mind has completely cast off all attachment to objects and is restrained in the heart.
            When it abandons its restlessness and attains the very nature and state of the Self (Atman).
            At that moment, the mind reaches its highest state, which is known as the 'Supreme Abode'.
            This describes that ultimate depth of meditation where the mind becomes 'No-mind' (Amana).
            Restraint in the heart means the mind no longer runs outward; it has returned to its Source.
            Just as a river merging into the ocean becomes the ocean, the mind merging in Atman becomes Atman.
            The Supreme Abode is not a geographical location, but that peace which is beyond all words.
            Upon reaching here, the distinctions between knower, knowledge, and known dissolve completely.
            When the mind discovers its true identity, it no longer needs any of the world's trivial toys.
            This is the final destination for which all yogas and austerities have been practiced for ages.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 5,
        sanskrit = "तावदेव निरोद्धव्यं यावद्धृदि गतं क्षयम् । एतज्ज्ञानं च ध्यानं च शेषो न्यायविस्तरः ॥ ५ ॥",
        hindi = """
            मन को तब तक रोककर रखना (निरोध करना) चाहिए जब तक कि वह हृदय में पूरी तरह लीन न हो जाए।
            बस, यही वास्तविक ज्ञान है और यही सच्चा ध्यान है; इसके अलावा जो कुछ है वह सब कोरा तर्क है।
            अन्य सभी शास्त्र और विस्तार केवल बौद्धिक बोझ हैं, असली काम तो मन को शांत करना ही है।
            यह श्लोक अध्यात्म की सभी फालतू बहसों और पांडित्य पर एक बहुत बड़ा प्रहार करता है।
            हजारों किताबें पढ़ने से कुछ नहीं होगा अगर मन अभी भी इच्छाओं के पीछे पागलों की तरह भाग रहा है।
            ध्यान का अर्थ केवल आँखें बंद करना नहीं, बल्कि मन का उसके मूल (हृदय) में पूरी तरह 'लय' होना है।
            'न्याय-विस्तर' का अर्थ है लंबी-चौड़ी बहसें; उपनिषद कहता है कि ये सब केवल समय की बर्बादी हैं।
            असली 'पीएचडी' वही है जिसने अपने मन की लहरों को पूरी तरह शांत करना सीख लिया है।
            सत्य बहुत सरल है: मन को भीतर ले जाओ और उसे वहीं स्थिर कर दो, यही मोक्ष का सार है।
            बाकी सब कुछ केवल तैयारी है, अंतिम परिणाम तो केवल उस मौन (Silence) की अनुभूति में है।
        """.trimIndent(),
        english = """
            The mind must be restrained and controlled until it completely dissolves and vanishes in the heart.
            This alone is true knowledge and this alone is true meditation; all else is mere logical expansion.
            All other scriptures and details are just intellectual burdens; the real task is only to still the mind.
            This verse strikes a massive blow to all useless spiritual debates and hollow scholarship.
            Reading thousands of books achieves nothing if the mind still runs like a maniac after desires.
            Meditation is not just closing eyes, but the absolute 'dissolution' of the mind into its origin (heart).
            'Nyaya-vistara' refers to lengthy arguments; the Upanishad claims these are just a waste of time.
            The real 'Ph.D.' is the one who has mastered the art of silencing the ripples of his own mind.
            Truth is simple: take the mind inward and establish it there; this is the core essence of liberation.
            Everything else is merely preparation; the final result lies only in the experience of absolute Silence.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 6,
        sanskrit = "नैव चिन्त्यं न चाचिन्त्यं न चिन्त्यं चिन्त्यमेव च । पक्षपातविनिर्मुक्तं ब्रह्म सम्पद्यते तदा ॥ ६ ॥",
        hindi = """
            वह परब्रह्म न तो चिंतन (सोचने) का विषय है और न ही वह अचिन्त्य (बिल्कुल न सोचा जा सकने वाला) है।
            वह न तो केवल सोचने योग्य है और न ही वह किसी प्रकार के चिंतन की सीमा में आने वाला पदार्थ है।
            जब साधक का मन इन सभी मानसिक पक्षों और धारणाओं से पूरी तरह मुक्त (पक्षपात विनिर्मुक्त) हो जाता है।
            तभी वह उस निर्गुण और निराकार ब्रह्म के साथ पूरी तरह से एकरूपता (सम्पद्यते) प्राप्त कर लेता है।
            ब्रह्म को हम दिमाग से नहीं सोच सकते, क्योंकि दिमाग खुद ब्रह्म का एक बहुत छोटा सा हिस्सा है।
            हम जिसे 'भगवान' कहकर सोचते हैं, वह हमारी कल्पना है, असली भगवान हमारी कल्पना से परे है।
            पर वह इतना भी दूर नहीं है कि उसे जाना न जा सके; वह हमारे होने के अहसास के रूप में मौजूद है।
            पक्षपात विनिर्मुक्त का अर्थ है—मेरा-तेरा, सही-गलत, है-नहीं है—इन सभी द्वंद्वों से मन का ऊपर उठ जाना।
            जब मन की कोई भी राय (Opinion) बाकी नहीं रहती, तभी सत्य साक्षात् प्रकट होता है।
            परमात्मा को पकड़ने के लिए नहीं, बल्कि खुद को 'छोड़ने' के लिए तैयार होना ही सच्ची साधना है।
        """.trimIndent(),
        english = """
            Brahman is neither a subject of thought, nor is it something that cannot be thought of at all.
            It is not merely thinkable, nor does it fall within the boundaries of any mental contemplation.
            When the seeker's mind becomes entirely free from all such mental biases and partialities.
            At that very moment, he successfully attains and merges with that Supreme Brahman.
            We cannot think of Brahman with the brain, because the brain itself is a tiny fragment of Brahman.
            What we think of as 'God' is just our imagination; the real God is beyond all our imaginations.
            Yet He is not so distant that He cannot be known; He exists as the very sense of our being.
            Being 'free from partiality' means the mind rising above dualities like mine-yours, right-wrong, is-is not.
            Only when the mind has no lingering opinion left does the absolute Truth manifest itself directly.
            True practice is not about 'grasping' God, but about being ready to completely 'let go' of oneself.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 7,
        sanskrit = "स्वरेण सन्धिमेद्योगमस्वरं भावयेत्परम् । अस्वरेण हि भावेन भावो नाभाव इष्यते ॥ ७ ॥",
        hindi = """
            साधक को पहले 'स्वर' (ॐकार की ध्वनि) के सहारे उस परमात्मा के साथ योग (सन्धि) करना चाहिए।
            फिर उस ध्वनि के समाप्त होने पर उस 'अस्वर' (मौन/निराकार) परम पद का निरंतर ध्यान करना चाहिए।
            उस अस्वर (ध्वनि-रहित) भाव के द्वारा ही उस परम तत्व का अनुभव होता है, जो न तो है और न ही नहीं है।
            यह ध्यान की एक अत्यंत तकनीकी विधि (Technical Method) है जिसे 'नादयोग' कहा जाता है।
            शुरुआत में मन बहुत चंचल होता है, इसलिए उसे ॐ की गूँज (स्वर) का एक सहारा दिया जाता है।
            पर ॐ का जप केवल रास्ता है, मंजिल वह 'सन्नाटा' है जो ॐ के खत्म होने के बाद पैदा होता है।
            असली ईश्वर उस मौन (Silence) में छिपा है जहाँ कोई शब्द, कोई भाषा और कोई ध्वनि काम नहीं करती।
            वहाँ न तो कोई 'भाव' (अस्तित्व) बचता है और न ही 'अभाव' (शून्यता); वहाँ केवल शुद्ध होना बचता है।
            जो शब्द के पार चला गया, वही वास्तव में अमर हो गया, क्योंकि शब्द ही दुनिया के बंधन बनाते हैं।
            यह श्लोक साधक को स्थूल ध्वनि से हटाकर अत्यंत सूक्ष्म मौन की गहराइयों में ले जाने का निर्देश देता है।
        """.trimIndent(),
        english = """
            One should first effect Yoga (union) through the 'Svara' (the sound of the syllable OM).
            After the sound ceases, one should then meditate on that 'Asvara' (soundless/formless) Supreme.
            By that soundless contemplation alone is attained that reality which is neither being nor non-being.
            This is a highly technical method of meditation known as 'Nada Yoga' or the Yoga of Sound.
            In the beginning, the mind is restless, so it is provided the support of the echo of OM (Svara).
            But chanting OM is just the path; the destination is that 'Silence' produced once the OM ends.
            The real God is hidden in that Silence where no word, no language, and no sound can operate.
            There, neither 'being' (existence) remains nor 'non-being' (void); only pure Awareness remains.
            He who has gone beyond the word has truly become immortal, for words alone create worldly bonds.
            This verse instructs the seeker to move from gross sound into the profound depths of subtle silence.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 8,
        sanskrit = "तदेव निष्कलं ब्रह्म निर्विकल्पं निरञ्जनम् । तद्ब्रह्माहमिति ज्ञात्वा ब्रह्म सम्पद्यते ध्रुवम् ॥ ८ ॥",
        hindi = """
            वही वास्तव में निष्कल (बिना अंगों वाला), निर्विकल्प (बिना किसी भेद वाला) और निरंजन (पवित्र) ब्रह्म है।
            "मैं ही वह परब्रह्म हूँ" (अहं ब्रह्मास्मि)—इस महान सत्य को जब साधक गहराई से जान लेता है।
            तब वह निश्चित रूप से (ध्रुवम्) उस अविनाशी और शाश्वत ब्रह्म के साथ पूरी तरह से एक हो जाता है।
            यहाँ 'सोऽहम्' या 'अद्वैत' के अनुभव की सबसे सीधी और सरल घोषणा की गई है।
            ब्रह्म निष्कल है, यानी उसके टुकड़े नहीं किए जा सकते; वह कल और आज एक ही अखंड ऊर्जा है।
            वह निरंजन है, जिसका अर्थ है कि दुनिया की कोई भी गंदगी या पाप उस चेतना को गंदा नहीं कर सकते।
            साधना का सबसे ऊँचा शिखर यही है कि इंसान अपनी छोटी पहचान छोड़कर कहे: "मैं ही वह ईश्वर हूँ।"
            यह घमंड नहीं है, बल्कि अपनी छोटी 'अहंकार की जेल' से बाहर निकलकर अनंत आकाश हो जाना है।
            जब यह ज्ञान केवल शब्दों में नहीं बल्कि अनुभव में उतरता है, तो इंसान का पूरा व्यक्तित्व बदल जाता है।
            जो इस एकता को जान लेता है, उसके लिए फिर दुनिया में कोई डर और कोई परायापन नहीं बचता।
        """.trimIndent(),
        english = """
            That indeed is the partless (Nishkala) Brahman, free from all doubt (Nirvikalpa) and spotless (Niranjana).
            By realizing deeply "I am that very Brahman," the seeker truly and certainly becomes Brahman.
            This is the most direct and simple declaration of the 'So-ham' or Non-dual Self-experience.
            Brahman is 'Nishkala', meaning It cannot be fragmented; It is one unbroken energy yesterday and today.
            It is 'Niranjana', implying that no worldly filth or sin can ever pollute that supreme Consciousness.
            The absolute peak of Sadhana is when a human drops his petty identity and says: "I am that God."
            This is not arrogance, but stepping out of the tiny 'prison of ego' to become the infinite sky.
            When this wisdom descends into direct experience and not just words, the entire personality transforms.
            For one who realizes this unity, no fear and no sense of 'otherness' remains in the entire world.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 9,
        sanskrit = "निर्विकल्पमनन्तं च हेतुदृष्टान्तवर्जितम् । अप्रमेयमनादिं च यज्ज्ञात्वा मुच्यते बुधः ॥ ९ ॥",
        hindi = """
            वह ब्रह्म निर्विकल्प, अनंत, और किसी भी भौतिक कारण (हेतु) या उदाहरण (दृष्टान्त) से पूरी तरह रहित है।
            वह अप्रमेय (जिसे नापा न जा सके) और अनादि (शुरुआत-रहित) है; जिसे जानकर ज्ञानी मनुष्य मुक्त हो जाता है।
            संसार की हर चीज़ का कोई न कोई कारण होता है, पर ब्रह्म सबका कारण है और उसका अपना कोई कारण नहीं है।
            दुनिया में हम किसी भी चीज़ को उदाहरण देकर समझा सकते हैं, पर ब्रह्म के जैसा दूसरा कुछ है ही नहीं।
            वह 'अनंत' है, जिसका अर्थ है कि वह स्पेस (Space) और टाइम (Time) की किसी भी सीमा में नहीं बंधता।
            'अप्रमेय' होने का मतलब है कि बुद्धि की कोई भी तराजू या विज्ञान का कोई यंत्र उसे कभी नाप नहीं सकता।
            जो चीज़ अनादि है, वह कभी खत्म भी नहीं हो सकती; इसलिए उसे जानने वाला भी मौत के पार चला जाता है।
            ज्ञानी (बुधः) वह नहीं है जिसके पास बहुत सारी जानकारी है, बल्कि वह है जिसने इस असीम को जान लिया है।
            मुक्त होने का अर्थ है उन सभी सीमाओं और परिभाषाओं को तोड़ देना जिन्होंने हमें अब तक बाँध रखा था।
            यह श्लोक ईश्वर की उस 'एब्सोल्यूट' (Absolute) स्थिति को बताता है जहाँ मन के सभी लॉजिक फेल हो जाते हैं।
        """.trimIndent(),
        english = """
            Brahman is without doubt, infinite, and entirely devoid of any cause (Hetu) or illustration (Drishtanta).
            It is immeasurable (Aprameya) and beginningless; knowing which the wise man is completely liberated.
            Every object in the world has a cause, but Brahman is the cause of all and has no cause of its own.
            In the world, we can explain anything through examples, but there is nothing else like Brahman.
            It is 'Infinite', meaning It is not bound by any limitation of physical Space or linear Time.
            Being 'Aprameya' means no scale of the intellect or instrument of science can ever measure It.
            That which is beginningless can never end; therefore, he who knows It also goes beyond death.
            The wise (Budha) is not one who possesses information, but one who has realized this boundlessness.
            To be liberated means to shatter all the limitations and definitions that have bound us until now.
            This verse describes that 'Absolute' state of God where all human logic and reasoning fail completely.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 10,
        sanskrit = "न निरोधो न चोत्पत्तिर्न बद्धो न च साधकः । न मुमुक्षुर्न वै मुक्त इत्येषा परमार्थता ॥ १० ॥",
        hindi = """
            परमार्थ (अंतिम सत्य) की स्थिति में न तो कहीं विनाश है और न ही कहीं किसी नई वस्तु की उत्पत्ति है।
            वहाँ न तो कोई बंधन में बँधा हुआ जीव है, न ही मोक्ष के लिए अभ्यास करने वाला कोई साधक है।
            वहाँ न तो कोई मुक्ति की इच्छा रखने वाला मुमुक्षु है और न ही कोई मुक्त पुरुष है; यही अंतिम सत्य है।
            यह श्लोक 'अजातवाद' (Non-creation) का चरम शिखर है, जो हमारी बुद्धि को पूरी तरह हिला देता है।
            व्यावहारिक दुनिया में जन्म और मृत्यु सच लगते हैं, पर ईश्वर की नज़रों में कुछ भी नया पैदा नहीं हुआ।
            जैसे समुद्र में लहरें उठती और गिरती हैं, पर समुद्र में न कुछ बढ़ा और न कुछ कम हुआ, वह वैसा ही है।
            जब 'अहंकार' ही नहीं बचा, तो कौन बँधा हुआ है और कौन आज़ाद होने की कोशिश कर रहा है?
            साधक और मुमुक्षु केवल तब तक हैं जब तक अज्ञान का पर्दा है; ज्ञान होने पर केवल ब्रह्म ही बचता है।
            यह श्लोक बताता है कि हम पहले से ही मुक्त हैं, हम बस अपनी ही बनाई एक काल्पनिक जेल में बैठे हैं।
            इस 'परमार्थता' को समझ लेना ही अध्यात्म की सबसे ऊँची उड़ान है जहाँ पहुँचकर सब कुछ शांत हो जाता है।
        """.trimIndent(),
        english = """
            In the ultimate truth, there is neither destruction nor any fresh creation (origination).
            There is neither anyone in bondage, nor is there any seeker practicing for liberation.
            There is neither any aspirant for salvation nor any liberated soul; this alone is the final Truth.
            This verse is the absolute peak of 'Ajatavada' (Non-creation), which completely shakes our intellect.
            In the practical world, birth and death seem real, but in God's eyes, nothing new has ever been born.
            Just as waves rise and fall in the ocean, yet nothing increases or decreases in the ocean itself.
            When the 'Ego' itself no longer exists, who is bound and who is struggling to become free?
            The seeker and the aspirant exist only as long as the veil of ignorance lasts; in wisdom, only Brahman is.
            This verse reveals that we are already free; we are just sitting in a self-created imaginary prison.
            Understanding this 'Paramarthata' is the highest flight of spirituality where everything becomes silent.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 11,
        sanskrit = "एक एवात्मा मन्तव्यो जाग्रत्स्वप्नसुषुप्तिषु । स्थानत्रयव्यतीतस्य पुनर्जन्म न विद्यते ॥ ११ ॥",
        hindi = """
            जाग्रत (जागना), स्वप्न (सपना) और सुषुप्ति (गहरी नींद)—इन तीनों अवस्थाओं में एक ही आत्मा को मानना चाहिए।
            जो महापुरुष इन तीनों अवस्थाओं से पूरी तरह परे चला जाता है, उसका इस संसार में पुनर्जन्म नहीं होता।
            हमारा अनुभव तीन भागों में बँटा है, पर इन तीनों को अनुभव करने वाली चेतना केवल एक ही है।
            जब हम जागते हैं, तो शरीर सच लगता है; जब हम सपना देखते हैं, तो सपना सच लगता है।
            पर गहरी नींद में न शरीर रहता है न सपना, फिर भी हमें सुबह याद रहता है कि "मैं गहरी नींद में था।"
            वह 'मैं' जो गहरी नींद में भी जाग रहा था, वही हमारी असली आत्मा (तुरीय) है।
            जो व्यक्ति खुद को इन बदलती हुई अवस्थाओं से अलग कर लेता है, वह समय के चक्र से आज़ाद हो जाता है।
            पुनर्जन्म शरीर का होता है; आत्मा तो पहले से ही अचल है और उसने कभी जन्म लिया ही नहीं।
            तीनों स्थानों (स्थानत्रय) से पार जाने का अर्थ है—अपने साक्षी भाव (Witnessing) में स्थिर हो जाना।
            यही वह महान विद्या है जो इंसान को एक नश्वर जीव से अविनाशी परमात्मा में बदल देती है।
        """.trimIndent(),
        english = """
            The Atman should be known as being only one in the waking, dreaming, and deep sleep states.
            For one who has transcended these three states of being, there is absolutely no rebirth.
            Our experience is divided into three parts, but the consciousness experiencing them is only one.
            When we are awake, the body seems real; when we dream, the dream seems absolutely real.
            But in deep sleep, neither exists, yet we remember in the morning: "I was in deep sleep."
            That 'I' which was awake even during the deep sleep is our true Soul (the Turiya state).
            One who successfully detaches himself from these shifting states becomes free from the cycle of time.
            Rebirth is of the physical body; the Soul is already unmoving and has never truly taken birth.
            Transcending the three states means becoming firmly established in the state of the silent Witness.
            This is the great science that transforms a mortal creature into the indestructible Supreme Lord.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 12,
        sanskrit = "एक एव हि भूतात्मा भूते भूते व्यवस्थितः । एकधा बहुधा चैव दृश्यते जलचन्द्रवत् ॥ १२ ॥",
        hindi = """
            निश्चित रूप से सभी प्राणियों की अंतरात्मा केवल 'एक' ही है, जो हर एक प्राणी के भीतर स्थित है।
            वही एक आत्मा अपनी माया से एक रूप में और अनेक रूपों में वैसे ही दिखाई देती है जैसे 'जल-चंद्र'।
            जिस प्रकार आकाश में चंद्रमा एक ही है, पर अगर नीचे सौ घड़े पानी के रखे हों, तो सबमें अलग चाँद दिखता है।
            अगर घड़ा फूट जाए या पानी हिल जाए, तो चाँद नहीं टूटता, केवल उसकी परछाईं गायब या चंचल होती है।
            ठीक वैसे ही, करोड़ों शरीरों में जो 'मैं' की भावना है, वह उस एक ही परमात्मा की परछाईं मात्र है।
            इंसान, जानवर, ऊँच-नीच—ये सब केवल पानी के अलग-अलग बर्तनों की तरह हैं, अंदर का प्रकाश एक ही है।
            अज्ञान के कारण हम परछाईं (शरीर) को सच मान लेते हैं और असली चंद्रमा (ईश्वर) को भूल जाते हैं।
            यह श्लोक अद्वैत दर्शन की सबसे प्रसिद्ध और सुंदर उपमा (Metaphor) प्रस्तुत करता है।
            जब 'अहंकार' का घड़ा टूट जाता है, तो जीव को अहसास होता है कि वह हमेशा से वही एक पूर्ण चंद्रमा था।
            सच्चा प्रेम और दया तभी संभव है जब हम हर दूसरे व्यक्ति में अपना ही ईश्वरीय अक्स देखने लगें।
        """.trimIndent(),
        english = """
            Indeed, the Soul of all beings is only one, dwelling perfectly within every single living creature.
            Being one, it appears as many, just like the reflection of the single moon in various vessels of water.
            Just as the moon in the sky is only one, but if a hundred pots of water are kept below, a moon appears in each.
            If the pot breaks or the water ripples, the moon doesn't break; only its reflection disappears or wavers.
            Exactly like that, the sense of 'I' in millions of bodies is merely a reflection of that one Supreme Lord.
            Humans, animals, high or low—these are just different vessels of water; the internal light is identical.
            Due to ignorance, we mistake the reflection (body) for reality and forget the actual Moon (God).
            This verse provides the most famous and beautiful metaphor in the entire philosophy of Advaita.
            When the 'pot of ego' finally shatters, the soul realizes it was always that one complete, radiant Moon.
            True love and compassion are possible only when we begin to see our own divine reflection in every other person.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 13,
        sanskrit = "घटसंवृतमाकाशं नीयमाने घटे यथा । घटो नीयेत नाकाशस्तद्वज्जीवो नभोपमः ॥ १३ ॥",
        hindi = """
            जिस प्रकार एक घड़े के भीतर का आकाश (स्पेस), घड़े को एक जगह से दूसरी जगह ले जाने पर नहीं बदलता।
            जब घड़ा चलता है तो केवल घड़ा चलता है, उसके अंदर का आकाश बिल्कुल भी गति नहीं करता।
            ठीक उसी प्रकार, यह जीवात्मा भी आकाश के समान ही अचल है; केवल शरीर ही आता-जाता और जन्म लेता है।
            यह श्लोक आत्मा की स्थिरता और शरीर की गतिशीलता के बीच के अंतर को वैज्ञानिक रूप से समझाता है।
            हम सोचते हैं कि "मैं दिल्ली गया" या "मैं यहाँ से वहाँ गया", पर वास्तव में केवल शरीर (घड़ा) चला है।
            आत्मा तो आकाश की तरह हर जगह पहले से ही मौजूद है, तो वह कहीं 'जा' कैसे सकती है?
            जन्म और मृत्यु भी केवल घड़े के बनने और टूटने जैसी घटनाएँ हैं, आकाश कभी नहीं टूटता।
            हमारा शरीर ब्रह्मांड में एक जगह से दूसरी जगह जा रहा है, पर हमारी चेतना हमेशा स्थिर और अखंड है।
            जब हम खुद को घड़ा (शरीर) मानते हैं, तो हमें मौत का डर सताता है; पर जब हम खुद को आकाश मानते हैं, तो हम मुक्त हैं।
            यह ज्ञान हमें सिखाता है कि जीवन की सभी भागदौड़ केवल सतह पर है, गहराई में हम हमेशा शांत और अचल हैं।
        """.trimIndent(),
        english = """
            Just as the space enclosed within a pot does not move when the pot is carried from one place to another.
            When the pot is moved, only the pot moves; the space inside it does not travel at all.
            Exactly like that, the individual soul is like space; only the physical body comes, goes, and takes birth.
            This verse scientifically explains the difference between the stillness of the Soul and the motion of the body.
            We think "I went to Delhi" or "I moved from here to there," but in reality, only the body (the pot) has moved.
            The Soul, like space, is already present everywhere; so how can it possibly 'go' anywhere?
            Birth and death are merely events like the making and breaking of a pot; space itself never breaks.
            Our body is moving from one place to another in the cosmos, but our consciousness is eternally still and unbroken.
            When we identify as the pot (body), fear of death haunts us; but when we identify as the space, we are free.
            This wisdom teaches us that all life's rushing is only on the surface; in the depths, we are always still.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 14,
        sanskrit = "घटवद्विविधाकारं भिद्यमानं पुनः पुनः । तद्भेदे न च जानाति स जानाति च नित्यशः ॥ १४ ॥",
        hindi = """
            घड़े के समान यह शरीर भी अनेक प्रकार के रूपों और आकारों में बार-बार बनता और टूटता रहता है।
            जब ये शरीर (घड़े) नष्ट होते हैं, तो वे अज्ञान के कारण अपने अविनाशी स्वरूप को बिल्कुल नहीं जान पाते।
            परंतु वह परमात्मा हमेशा (नित्यशः) जागृत रहता है और वह सब कुछ पूरी तरह से जानता है।
            सृष्टि में करोड़ों प्रजातियां हैं, जो अलग-अलग डिज़ाइन के घड़ों (शरीरों) की तरह लगातार बदल रही हैं।
            इंसान का बच्चा बड़ा होता है, बूढ़ा होता है और मर जाता है—यह घड़े का बार-बार 'भिद्यमान' (बदलना) होना है।
            मरने वाला जीव अक्सर अज्ञान में ही मर जाता है, उसे पता ही नहीं चलता कि वह वास्तव में कौन था।
            परंतु वह शुद्ध चेतना (आत्मा) इन करोड़ों जन्मों और मौतों की साक्षी है; वह कभी सोती नहीं है।
            शरीर को नहीं पता कि वह कल क्या था, पर आत्मा को करोड़ों सालों का इतिहास पूरी तरह याद है।
            सच्चा ज्ञान वही है जहाँ जीव अपने इस 'नित्य' और सब कुछ जानने वाले स्वरूप के साथ जुड़ जाए।
            जब तक हम खुद को मिटने वाला शरीर मानेंगे, हम अपनी ही महानता से अनजान और अंधे बने रहेंगे।
        """.trimIndent(),
        english = """
            Like a pot, the physical body assuming various forms and shapes is broken and recreated again and again.
            When these bodies (pots) are destroyed, they do not know their indestructible nature due to ignorance.
            But that Supreme Lord remains eternally awake and perfectly knows everything at all times.
            There are millions of species in creation, constantly changing like pots of various designs (bodies).
            A human child grows, ages, and dies—this is the continuous 'breaking' and changing of the pot.
            The dying creature often dies in sheer ignorance, never realizing who he actually and truly was.
            But that pure Consciousness (Soul) is the witness to these millions of births and deaths; It never sleeps.
            The body doesn't know what it was yesterday, but the Soul remembers the history of millions of years perfectly.
            True wisdom is when the individual soul connects with this 'eternal' and all-knowing aspect of itself.
            As long as we consider ourselves a perishable body, we remain ignorant and blind to our own greatness.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 15,
        sanskrit = "शब्दमायावृतो नैव जायते पुष्करे स्थितः । तस्मिँस्तमसि भिन्ने तु एक एवानुपश्यति ॥ १५ ॥",
        hindi = """
            जब तक जीव शब्दों और माया के जाल (शब्दमाया) से ढका रहता है, तब तक वह उस हृदय-कमल (पुष्कर) को नहीं देख पाता।
            अज्ञान के अंधेरे और शब्दों के शोर के कारण उसे अपने भीतर छिपे हुए परमात्मा का साक्षात् प्रकाश नहीं मिलता।
            परंतु जब ज्ञान के द्वारा वह अज्ञान रूपी अंधकार (तमस) पूरी तरह कट जाता है और पर्दा हट जाता है।
            तब वह साधक केवल उस 'एक' अद्वितीय परम सत्य को ही सब जगह और अपने भीतर प्रत्यक्ष देखता है।
            'शब्दमाया' का अर्थ है—नाम, परिभाषाएं, सिद्धांत और कोरी बातें जिनमें हमारा दिमाग हमेशा उलझा रहता है।
            हम भगवान के बारे में बहुत बातें करते हैं, पर वही बातें पर्दा (Veil) बन जाती हैं जो उसे देखने नहीं देतीं।
            हृदय-कमल (पुष्कर) हमारे भीतर का वह शांत स्थान है जहाँ ईश्वर हमेशा से शांति के साथ विराजमान है।
            अंधकार (तमस) केवल अज्ञान है; जैसे बिजली आने पर अंधेरा गायब हो जाता है, वैसे ही ज्ञान से माया मिट जाती है।
            एकता का दर्शन (एक एवानुपश्यति) ही साधना का अंतिम फल है, जहाँ परायापन हमेशा के लिए खत्म हो जाता है।
            जब शोर खत्म होता है, तभी संगीत सुनाई देता है; जब माया हटती है, तभी साक्षात् ब्रह्म दिखाई देता है।
        """.trimIndent(),
        english = """
            As long as one is enveloped by the illusion of words (Shabdamaya), one does not see the lotus of the heart.
            Due to the darkness of ignorance and the noise of words, one doesn't perceive the light of God within.
            But when that darkness of ignorance (Tamas) is finally pierced and the veil is removed by wisdom.
            Then the seeker directly perceives only that 'One' non-dual Supreme Truth everywhere and within.
            'Shabdamaya' refers to names, definitions, theories, and mere talk in which our minds are constantly tangled.
            We talk extensively about God, but those very words become a veil preventing us from actually seeing Him.
            The heart-lotus (Pushkara) is that silent space within us where God has always resided in perfect peace.
            Darkness (Tamas) is merely ignorance; just as darkness vanishes when light arrives, Maya vanishes through wisdom.
            The vision of Oneness (Eka evanupashyati) is the final fruit of practice, where 'otherness' ends forever.
            Only when the noise ceases is the music heard; only when Maya is removed is Brahman directly seen.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 16,
        sanskrit = "शब्दाक्षरं परं ब्रह्म तस्मिन् क्षीणे यदक्षरम् । तद्विद्वानक्षरं ध्यायेद्यदीच्छेच्छान्तिमात्मनः ॥ १६ ॥",
        hindi = """
            शब्द-ब्रह्म (ॐकार) वह अविनाशी अक्षर है जिसके सहारे उस 'परम ब्रह्म' तक पहुँचने का मार्ग खुलता है।
            परंतु जब उस ध्वनि (शब्द) का भी लय हो जाता है, तब जो शेष बचता है, वही वास्तव में अंतिम 'अक्षर' (अविनाशी) है।
            जो विद्वान अपने मन की शांति (आत्मनः शांति) चाहता है, उसे उस सर्वोच्च और शब्द-रहित अक्षर का ध्यान करना चाहिए।
            यह मंत्र ॐकार साधना की गहराई को बताता है—ॐ भी एक मानसिक आलंबन (सहारा) मात्र है।
            अंतिम सत्य ॐ शब्द के भी पार है; वह वह 'मौन' है जो ॐ की गूँज के शांत होने पर महसूस होता है।
            असली शांति किसी आवाज़ में नहीं, बल्कि उस स्थान पर है जहाँ सारी आवाज़ें और विचार विलीन हो जाते हैं।
            'विद्वान' यहाँ उसे कहा गया है जो केवल किताबी नहीं है, बल्कि जो मौन की भाषा को अच्छी तरह समझता है।
            हमें सीढ़ी (शब्द) की जरूरत तब तक है जब तक हम छत (शांति) पर नहीं पहुँच जाते; पहुँचने पर सीढ़ी छोड़नी पड़ती है।
            अविनाशी का अर्थ है—वह जो समय, स्थान और परिस्थिति के बदलने पर भी कभी नहीं मिटता या बदलता।
            यह श्लोक साधक को गहरे मौन (Deep Silence) में उतरने के लिए अत्यंत मधुर और स्पष्ट निमंत्रण देता है।
        """.trimIndent(),
        english = """
            The Word-Brahman (OM) is the imperishable syllable that leads the way to the 'Supreme Brahman'.
            But when that sound (word) also dissolves, what remains is the truly ultimate Imperishable (Akshara).
            The wise one who intensely desires the peace of the soul should meditate on that highest, wordless syllable.
            This verse explains the depth of OM practice—even OM is merely a mental support or an initial anchor.
            The ultimate Truth is beyond the word OM; It is that 'Silence' felt once the echo of OM has subsided.
            Real peace is not found in any sound, but in that state where all sounds and thoughts merge and vanish.
            The 'wise' here is not one with information, but one who profoundly understands the language of silence.
            We need the ladder (the word) only until we reach the roof (peace); once there, the ladder must be left.
            Imperishable means that which never disappears or changes despite shifts in time, space, or circumstance.
            This verse offers a sweet and clear invitation to the seeker to descend into the depths of Deep Silence.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 17,
        sanskrit = "द्वे विद्ये वेदितव्ये तु शब्दब्रह्म परं च यत् । शब्दब्रह्मणि निष्णातः परं ब्रह्माधिगच्छति ॥ १७ ॥",
        hindi = """
            जानने योग्य दो प्रकार की विद्याएं (ज्ञान) हैं—एक 'शब्द-ब्रह्म' (वेदों का ज्ञान) और दूसरा 'पर-ब्रह्म' (अनुभव का ज्ञान)।
            जो साधक शब्द-ब्रह्म (शास्त्रों और मंत्रों के मर्म) में पूरी तरह निपुण और कुशल (निष्णात) हो जाता है।
            वह बहुत आसानी से उस 'पर-ब्रह्म' (सर्वोच्च ईश्वर) को प्रत्यक्ष अनुभव करने में सफल हो जाता है।
            यह श्लोक थ्योरी (Theory) और प्रैक्टिकल (Practical) के बीच के सुंदर संतुलन को बहुत ही स्पष्ट रूप से बताता है।
            शब्द-ब्रह्म का अर्थ है शास्त्रों का गहरा अध्ययन और ॐकार जैसे मंत्रों का विधिवत और निरंतर अभ्यास।
            पर-ब्रह्म का अर्थ है वह साक्षात् अनुभव जहाँ भगवान और भक्त के बीच का पर्दा हमेशा के लिए गिर जाता है।
            बिना शास्त्रों के ज्ञान के साधक अक्सर भटक जाता है, इसलिए 'शब्द-ब्रह्म' की अपनी एक बड़ी महत्ता है।
            परंतु केवल शास्त्रों को रट लेना भी काफी नहीं है; शास्त्रों का असली उद्देश्य 'पर-ब्रह्म' तक पहुँचाना है।
            जैसे नक्शा (Map) मंजिल नहीं होता, पर नक्शा ही हमें सही रास्ते से मंजिल तक पहुँचाने में मदद करता है।
            जो शास्त्रों के मर्म को जी लेता है, उसके लिए परमात्मा का साक्षात् दर्शन अब बहुत ज्यादा दूर नहीं रह जाता।
        """.trimIndent(),
        english = """
            There are two kinds of knowledge to be known—the 'Word-Brahman' and that which is the 'Supreme-Brahman'.
            One who is thoroughly expert and well-versed (Nishnata) in the Word-Brahman successfully attains the Supreme.
            This verse very clearly explains the beautiful balance between Theory (Shastra) and Practical (Experience).
            'Word-Brahman' refers to the deep study of scriptures and the systematic, continuous practice of mantras like OM.
            'Supreme-Brahman' refers to the direct realization where the veil between God and devotee falls forever.
            Without scriptural knowledge, a seeker often loses his way; hence, Word-Brahman has its own great value.
            However, merely memorizing scriptures is not enough; their true purpose is to lead one to the Supreme-Brahman.
            Just as a map is not the destination, but the map itself helps us reach the destination via the right path.
            He who lives the essence of the scriptures finds that the direct vision of God is no longer far away.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 18,
        sanskrit = "ग्रन्थमभ्यस्य मेधावी ज्ञानविज्ञानतत्परः । पलालमिव धान्यार्थी त्यजेद्ग्रन्थमशेषतः ॥ १८ ॥",
        hindi = """
            बुद्धिमान (मेधावी) साधक को चाहिए कि वह पहले ग्रंथों का अच्छी तरह अभ्यास करे और ज्ञान-विज्ञान में तत्पर रहे।
            परंतु ज्ञान प्राप्त कर लेने के बाद, उसे उन ग्रंथों को पूरी तरह से वैसे ही त्याग (त्यजेत्) देना चाहिए।
            जैसे अनाज (धान्य) की इच्छा रखने वाला व्यक्ति अनाज निकालने के बाद भूसे (पलाल) को पूरी तरह छोड़ देता है।
            यह श्लोक अध्यात्म की सबसे ऊंची और कड़वी सच्चाई को एक बहुत ही सरल और ग्रामीण उदाहरण से समझाता है।
            ग्रंथ (किताबें) केवल छिलके की तरह हैं, उनके अंदर छिपा हुआ 'अनुभव' ही असली और कीमती अनाज है।
            जब तक भूख है तब तक हम अनाज खोजते हैं, पर अनाज मिलने के बाद भूसे को ढोना केवल बेवकूफी और बोझ है।
            अक्सर लोग शास्त्रों के शब्दों (भूसे) को ही पकड़ कर बैठ जाते हैं और असली सत्य (अनाज) को भूल जाते हैं।
            असली 'मेधावी' वह है जो शब्दों के पार जाकर उस परम सत्य का स्वाद ले लेता है और फिर मौन हो जाता है।
            ज्ञान होने के बाद गुरु और ग्रंथ भी पीछे छूट जाते हैं, क्योंकि अब परमात्मा आपके अपने भीतर से बोल रहा है।
            यह श्लोक हमें सिखाता है कि साधनों (Tools) का उपयोग करो, पर उनके गुलाम मत बनो और उन्हें पकड़ कर मत बैठो।
        """.trimIndent(),
        english = """
            The wise seeker should study the scriptures well and be intent on attaining knowledge and wisdom.
            But after gaining the knowledge, he should discard those scriptures completely and move beyond them.
            Just as a person desiring the grain (Dhanya) discards the husk (Palala) after extracting the grain.
            This verse explains the highest and bitterest truth of spirituality using a very simple, rural example.
            Scriptures (books) are merely like the husk; the 'experience' hidden within them is the real, precious grain.
            As long as we are hungry, we seek grain; but once obtained, carrying the husk is pure folly and a burden.
            People often cling to the words (husk) of scriptures and completely miss the ultimate Truth (the grain).
            A truly 'wise' person is one who goes beyond words, tastes the Supreme Truth, and then becomes silent.
            Once enlightened, even the Guru and scriptures are left behind, for God now speaks from within you.
            This verse teaches us to use tools (scriptures), but not to become their slaves or cling to them forever.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 19,
        sanskrit = "गवामनेकवर्णानां क्षीरस्याप्येकवर्णता । क्षीरवत्पश्यते ज्ञानं लिङ्गिनस्तु गवां यथा ॥ १९ ॥",
        hindi = """
            जिस प्रकार अलग-अलग रंगों की गायों (काली, सफेद, लाल) का दूध हमेशा सफेद और एक ही रंग का होता है।
            उसी प्रकार, अनेक प्रकार के भेदों वाले इन प्राणियों में छिपे हुए ज्ञान (आत्मा) को भी 'एक' ही मानना चाहिए।
            विभिन्न शरीरों को गायों के समान समझो और उनके भीतर की चेतना को उस एक समान 'दूध' की तरह जानो।
            यह श्लोक अद्वैत दर्शन का सबसे प्यारा और प्रभावशाली उदाहरण है जो जाति और रूप के भेद को मिटाता है।
            बाहर से गाय का रंग कुछ भी हो, उसका सार (दूध) कभी नहीं बदलता और वह सबको समान पोषण देता है।
            ठीक वैसे ही, इंसान का रंग, धर्म, भाषा या शरीर का आकार कुछ भी हो, उसके अंदर की 'मैं' (आत्मा) वही है।
            हम अक्सर डिब्बे (शरीर) को देखकर लड़ते हैं, पर डिब्बे के अंदर की जो असली चीज़ है, उसे भूल जाते हैं।
            ज्ञानी वही है जो 'लिङ्गिन' (बाहरी चिह्नों/लिंगों) को छोड़कर उस 'क्षीर' (दूध/सत्य) पर अपनी दृष्टि टिकाता है।
            जब हम सबमें एक ही ईश्वर का सफेद और पवित्र प्रकाश देखते हैं, तो नफरत और भेदभाव हमेशा के लिए मिट जाते हैं।
            यह श्लोक पूरी मानवता को एक सूत्र में पिरोने वाला एक महान वैश्विक (Universal) उपदेश है।
        """.trimIndent(),
        english = """
            Though cows are of manifold colors (black, white, red), the color of their milk is uniquely one (white).
            Similarly, the knowledge (Soul) hidden within diverse beings should be perceived as absolutely one.
            Consider the various bodies to be like the cows, and the consciousness within them to be like the uniform milk.
            This is the most beloved and impactful metaphor of Advaita, erasing all distinctions of caste and form.
            Whatever the color of the cow on the outside, its essence (milk) never changes and provides equal nutrition.
            Exactly similarly, whatever be a human's color, religion, language, or body shape, the internal 'I' is identical.
            We often fight over the container (body) while completely forgetting the actual content inside the container.
            The wise is one who ignores the 'Lingin' (external marks) and focuses strictly on the 'Kshira' (milk/Truth).
            When we see the same white, sacred light of God in everyone, hatred and discrimination vanish forever.
            This verse is a great universal teaching that binds all of humanity into a single, divine thread of unity.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 20,
        sanskrit = "घृतमिव पयसि निगूढं भूते भूते च वसति विज्ञानम् । सततं मन्थयितव्यं मनसा मन्थानभूतेन ॥ २० ॥",
        hindi = """
            जिस प्रकार दूध (पयसि) के भीतर घी (घृत) अत्यंत गुप्त रूप से छिपा रहता है और ऊपर से दिखाई नहीं देता।
            ठीक उसी प्रकार, प्रत्येक प्राणी के भीतर वह 'विज्ञान' (शुद्ध आत्म-चैतन्य) गहराई से निवास करता है।
            उस परमात्मा को प्रकट करने के लिए साधक को मन रूपी मथानी (Churning stick) से निरंतर मंथन करना चाहिए।
            दूध में घी है, यह हम जानते हैं, पर केवल घूरने से घी नहीं मिलेगा; उसके लिए मेहनत करनी पड़ती है।
            मंथन (Churning) का अर्थ है—निरंतर विचार करना, ध्यान करना और सत्य की गहराई में बार-बार गोता लगाना।
            अगर आप दूध को मथना छोड़ देंगे, तो मक्खन ऊपर नहीं आएगा; वैसे ही साधना में 'सातत्य' (Consistency) जरूरी है।
            हमारा मन ही वह मथानी है जिसे दुनिया से हटाकर आत्मा के ऊपर बार-बार घुमाना (Focus करना) पड़ता है।
            यह श्लोक बताता है कि ईश्वर कोई बाहर से आने वाली चीज़ नहीं है, वह हमारे भीतर ही 'निगूढ़' (छिपा) है।
            परिश्रम (साधना) के बिना वह छिपा हुआ सत्य कभी भी साक्षात् अनुभव (Realization) में नहीं बदल सकता।
            यह उपनिषद हमें आलस्य छोड़कर अपने ही भीतर छिपे उस अमृत (घी) को निकालने की प्रेरणा देता है।
        """.trimIndent(),
        english = """
            Just as clarified butter (Ghee) is subtly hidden within milk, so does Pure Consciousness dwell in all beings.
            That Supreme Lord should be continuously churned out using the mind as the churning-stick.
            We know ghee is present in milk, but merely staring at the milk won't yield ghee; it requires effort.
            'Churning' means continuous contemplation, deep meditation, and repeatedly diving into the depths of Truth.
            If you stop churning the milk, the butter won't rise; similarly, 'consistency' is vital in spiritual practice.
            Our mind itself is the churning-stick that must be withdrawn from the world and focused repeatedly on the Soul.
            This verse reveals that God is not something arriving from outside; He is deeply 'Nigudha' (hidden) within us.
            Without strenuous practice (Sadhana), that hidden Truth can never transform into direct, firsthand realization.
            The Upanishad inspires us to abandon laziness and extract that hidden Nectar (Ghee) from within ourselves.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 21,
        sanskrit = "ज्ञाननेत्रं समाधाय चोद्धरेद्वह्निवत्परम् । निष्कलं निश्चलं शान्तं तद्ब्रह्माहमिति स्मृतम् ॥ २१ ॥",
        hindi = """
            ज्ञान रूपी नेत्र (दृष्टि) को एकाग्र करके, साधक को उस परम तत्व को वैसे ही निकालना चाहिए जैसे लकड़ी से आग।
            वह परम तत्व निष्कल (अखंड), निश्चल (अचल) और परम शांत है; "मैं वही ब्रह्म हूँ"—ऐसा निरंतर स्मरण करना चाहिए।
            जिस प्रकार सूखी लकड़ी के अंदर आग छिपी होती है पर उसे घर्षण से ही निकाला जाता है, आत्मा भी वैसे ही प्रकट होती है।
            'ज्ञाननेत्र' का अर्थ है वह अंतर्दृष्टि जो बाहरी रूप को छोड़कर केवल आंतरिक तत्व को देख पाती है।
            जब हम समाधि में पूरी तरह स्थिर होते हैं, तभी हमें अपने 'निष्कलं' (अविभाज्य) स्वरूप का अहसास होता है।
            ईश्वर कोई ऐसा व्यक्ति नहीं है जिससे हम डरे रहें; वह तो हमारी अपनी ही सबसे शांत और गहरी परत (Layer) है।
            "तद्ब्रह्माहमिति"—यह शब्द नहीं, बल्कि एक विस्फोट है जो हमारे सारे छोटेपन और सीमाओं को उड़ा देता है।
            जैसे ही इंसान यह मानता है कि वह ब्रह्म है, वैसे ही उसकी सारी चिंताएं और बेचैनियां धूल की तरह उड़ जाती हैं।
            शांति (Shanti) कोई ऐसी चीज़ नहीं जिसे पाना है; शांति तो हमारा असली स्वभाव है जो अज्ञान के नीचे दबा है।
            यह श्लोक आत्म-साक्षात्कार (Self-realization) की उस परम अग्नि को जाग्रत करने का अंतिम गुप्त निर्देश है।
        """.trimIndent(),
        english = """
            By fixing the eye of knowledge, one should bring forth the Supreme like fire from within the wood.
            That Supreme is partless, unmoving, and peaceful; "I am that Brahman"—thus should it be remembered.
            Just as fire is hidden inside dry wood but must be extracted by friction, the Soul manifests similarly.
            'Eye of Knowledge' (Jnana-netra) means that inner vision which ignores the outer form to see the inner essence.
            Only when we are perfectly still in Samadhi do we realize our 'Nishkala' (indivisible) and unbroken nature.
            God is not a separate person to be feared; He is our own most silent, deepest, and truest layer of existence.
            "Tad-Brahma-Aham-iti"—this is not just a sentence, but an explosion that shatters all our smallness and limits.
            The moment a person accepts he is Brahman, all his anxieties and restlessness blow away like mere dust.
            Peace (Shanti) is not something to be acquired; Peace is our original nature buried under the heap of ignorance.
            This verse is the final secret instruction to awaken that ultimate fire of direct Self-realization within.
        """.trimIndent()
    ),
    AmritabinduShloka(
        id = 22,
        sanskrit = "सर्वभूताधिवासं यद्भूतेषु च वसत्यपि । सर्वानुग्राहकत्वेन तदस्म्यहं वासुदेवः तदस्म्यहं वासुदेव इति ॥ २२ ॥",
        hindi = """
            (उपनिषद का समापन): जो परमात्मा सभी प्राणियों का परम निवास स्थान है और जो सभी प्राणियों के भीतर भी निवास करता है।
            जो अपनी अपार करुणा और कृपा (अनुग्रह) के कारण इस संपूर्ण चराचर जगत का पालन-पोषण और रक्षण करता है।
            "मैं ही वह सर्वव्यापी वासुदेव (परमात्मा) हूँ; हाँ, मैं ही वह परम सुखमय वासुदेव हूँ"—यही अंतिम सत्य है।
            (वाक्य का दोहराव इस परम ज्ञान की निश्चितता और उपनिषद की पूर्णता को हर्षपूर्वक दर्शाता है)।
            'वासुदेव' का अर्थ है वह जो हर कण में बसा हुआ है (वसु) और जो स्वयं प्रकाशमान देव (दिव्) है।
            यह श्लोक भगवान कृष्ण के वासुदेव नाम को अद्वैत चेतना (Universal Consciousness) के साथ खूबसूरती से जोड़ता है।
            ईश्वर दुनिया से दूर नहीं है; वह 'अधिवास' है यानी हम मछली की तरह ईश्वर रूपी समुद्र के भीतर ही जी रहे हैं।
            अनुग्रह (Grace) का अर्थ है कि वह हमेशा हमारी भलाई के लिए तैयार है, बस हमें अपना अहंकार छोड़ना है।
            अंत में साधक खुद को भगवान में नहीं, बल्कि भगवान को खुद में और खुद को ही भगवान के रूप में पा लेता है।
            ॐ शांतिः शांतिः शांतिः—यहाँ अमृतबिन्दु उपनिषद का परम पवित्र अमृत-ज्ञान पूर्ण रूप से संपन्न होता है।
        """.trimIndent(),
        english = """
            (Conclusion of the Upanishad): That Lord who is the abode of all beings and who also dwells within all beings.
            Who, through His universal grace and compassion (Anugraha), sustains and protects this entire universe.
            "I am that all-pervading Vasudeva (Supreme Lord); indeed, I am that blissful Vasudeva"—this is the final Truth.
            (The repetition of the final phrase joyfully indicates the certainty of this knowledge and the Upanishad's completion).
            'Vasudeva' means the one who dwells in every atom (Vasu) and is the self-luminous radiant Deity (Div).
            This verse beautifully links Lord Krishna's name, Vasudeva, with the concept of Universal Consciousness.
            God is not far from the world; He is the 'Abode', meaning we are like fish living within the ocean of God.
            'Anugraha' (Grace) implies He is always ready for our welfare; we simply need to drop our stubborn ego.
            In the end, the seeker finds not just God in himself, but discovers himself as that very Supreme God.
            OM Peace, Peace, Peace—Here the supremely sacred Nectar-knowledge of the Amritabindu Upanishad is completed.
        """.trimIndent()
    )
)