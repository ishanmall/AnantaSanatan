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
data class HamsaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HamsaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..21) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-21)") },
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
            itemsIndexed(hamsaShlokasList) { _, shloka ->
                HamsaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun HamsaShlokaCard(shloka: HamsaShloka) {
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

val hamsaShlokasList: List<HamsaShloka> = listOf(
    HamsaShloka(
        id = 1,
        sanskrit = "अथ हंसपरमहंसनिर्णयं व्याख्यास्यामः । गौतम उवाच - भगवन् सर्वधर्मज्ञ सर्वशास्त्रविशारद । केनोपायेन देवेश ब्रह्मविद्याऽवाप्यते ॥ १ ॥",
        hindi = """
            (हंस उपनिषद प्रारंभ): अब हम हंस और परमहंस के स्वरूप का यथार्थ निर्णय और व्याख्या करेंगे।
            महर्षि गौतम ने भगवान सनत्कुमार से अत्यंत विन्रमतापूर्वक पूछा।
            हे भगवन्! आप सभी धर्मों के ज्ञाता और सभी शास्त्रों के परम विद्वान हैं।
            कृपया मुझे बताइए कि उस परमेश्वर की ब्रह्मविद्या किस उपाय (तरीके) से प्राप्त होती है?
            यह उपनिषद इसी महान प्रश्न से शुरू होता है जो हर सच्चे साधक के मन में उठता है।
            ब्रह्मविद्या वह ज्ञान है जो हमें जन्म और मृत्यु के इस अंतहीन चक्र से हमेशा के लिए आज़ाद करता है।
            गौतम ऋषि का प्रश्न यह नहीं है कि दुनिया कैसे बनी, बल्कि यह है कि मैं मुक्त कैसे होऊँ?
            यह दर्शाता है कि आध्यात्मिक ज्ञान प्राप्त करने के लिए एक योग्य गुरु के पास जाना बहुत आवश्यक है।
            बिना प्रश्न पूछे और बिना सच्ची जिज्ञासा के कभी भी सत्य का द्वार नहीं खुलता।
            यहाँ से योग और नाद-अनुसंधान (Sound Meditation) की एक अत्यंत गहरी और रहस्यमयी यात्रा शुरू होती है।
        """.trimIndent(),
        english = """
            (Beginning of Hamsa Upanishad): Now we shall expound the true nature of Hamsa and Paramahamsa.
            Sage Gautama very humbly asked Lord Sanatkumara with great devotion.
            O Lord! You are the absolute knower of all Dharmas and a supreme expert in all scriptures.
            Please tell me, by exactly what method can the Brahma-vidya (Divine Wisdom) be successfully attained?
            This Upanishad begins with this profound question that naturally arises in every true seeker's mind.
            Brahma-vidya is that supreme knowledge which permanently frees us from the endless cycle of rebirth.
            Sage Gautama's question is not about how the world was made, but how can I ultimately be liberated?
            This brilliantly demonstrates that to gain spiritual wisdom, approaching a true Guru is absolutely essential.
            Without sincere questioning and deep, burning curiosity, the doors of Truth simply never open.
            From here begins an exceedingly profound and mystical journey of Yoga and Nada (Sound) Meditation.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 2,
        sanskrit = "सनत्कुमार उवाच - शृणु गौतम तत्त्वं यत् सर्ववेदान्तगोचरम् । योगिनां निधिरूपं च रहस्यं कथयामि ते ॥ २ ॥",
        hindi = """
            भगवान सनत्कुमार ने उत्तर दिया: हे गौतम! ध्यान से सुनो, मैं तुम्हें वह परम तत्व बताऊँगा।
            वह तत्व जो संपूर्ण वेदान्त (उपनिषदों) का अंतिम लक्ष्य है और जो महान योगियों का खजाना (निधि) है।
            मैं तुम्हें वह अत्यंत गुप्त रहस्य बता रहा हूँ जो हर किसी को आसानी से नहीं बताया जाता।
            सच्चा ज्ञान हमेशा 'रहस्य' होता है, क्योंकि अज्ञानी व्यक्ति इसे समझ नहीं सकता और इसका मजाक उड़ाता है।
            योगियों का खजाना कोई सोना या चाँदी नहीं है, बल्कि वह आंतरिक शांति और मोक्ष का ज्ञान है।
            सनत्कुमार स्पष्ट करते हैं कि यह ज्ञान केवल उसी को दिया जाता है जो इसके लिए पूरी तरह योग्य हो।
            यहाँ वेदान्त (ज्ञान) और योग (अभ्यास) का एक बहुत ही सुंदर और अद्भुत संगम होने वाला है।
            सत्य कोई किताबी जानकारी नहीं है; यह एक ऐसा खजाना है जिसे अपने ही भीतर गहराई में खोजना पड़ता है।
            गुरु की आज्ञा "शृणु" (सुनो) का अर्थ केवल कानों से सुनना नहीं, बल्कि पूरे ध्यान से इसे हृदय में उतारना है।
            यह श्लोक शिष्य के मन को पूरी तरह से एकाग्र और तैयार करने का कार्य करता है।
        """.trimIndent(),
        english = """
            Lord Sanatkumara replied: O Gautama! Listen very carefully, I shall reveal that Supreme Principle to you.
            That reality which is the ultimate goal of all Vedanta and the greatest treasure (Nidhi) of the Yogis.
            I am about to tell you that profoundly deep secret which is not easily shared with just anyone.
            True wisdom is always a 'secret' because an ignorant person simply cannot understand it and mocks it.
            The treasure of the Yogis is not gold or silver, but the supreme knowledge of inner peace and Moksha.
            Sanatkumara makes it clear that this wisdom is imparted exclusively to one who is fully qualified for it.
            A highly beautiful and remarkable confluence of Vedanta (Wisdom) and Yoga (Practice) is about to occur here.
            Truth is not textbook information; it is a hidden treasure that must be excavated deep within oneself.
            The Guru's command "Shrinu" (Listen) means not just hearing with ears, but absorbing it entirely into the heart.
            This verse perfectly serves to deeply concentrate and meticulously prepare the disciple's mind for the teaching.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 3,
        sanskrit = "सर्वभूतेषु निगूढो हंसो व्याप्य व्यवस्थितः । अग्निर्दारुषु यद्वद्वै तिलपुष्पेषु तैलवत् ॥ ३ ॥",
        hindi = """
            वह 'हंस' (आत्मा/परमात्मा) सभी प्राणियों के भीतर अत्यंत गुप्त रूप से छिपा (निगूढ़) हुआ है।
            वह हर चीज़ में पूरी तरह से व्याप्त होकर स्थित है, पर फिर भी वह साधारण आँखों से दिखाई नहीं देता।
            ठीक उसी प्रकार जैसे सूखी लकड़ी (दारु) के अंदर आग छिपी रहती है, पर बाहर से दिखती नहीं।
            या जैसे तिलों के अंदर तेल और फूलों के अंदर सुगंध छिपी होती है, वैसे ही शरीर में हंस छिपा है।
            'हंस' का अर्थ है हमारी श्वास (सांस) की ध्वनि। जब हम सांस अंदर लेते हैं तो 'हं' और बाहर छोड़ते हैं तो 'सः' की आवाज़ आती है।
            यह 'हंस' (अहं सः - मैं वह हूँ) का निरंतर अजपा जाप हमारे भीतर हर पल चल रहा है।
            ईश्वर आसमान में नहीं है; वह हमारी हर धड़कन और हर सांस में तेल और आग की तरह बसा हुआ है।
            लकड़ी से आग निकालने के लिए उसे रगड़ना पड़ता है; वैसे ही आत्मा को जानने के लिए 'ध्यान' का घर्षण चाहिए।
            हम शरीर (लकड़ी) को तो देखते हैं, पर उसके अंदर की आग (चेतना) को अज्ञान के कारण भूल जाते हैं।
            यह श्लोक ईश्वर की सर्वव्यापकता और उसकी गुप्त उपस्थिति का सबसे शानदार और वैज्ञानिक उदाहरण देता है।
        """.trimIndent(),
        english = """
            That 'Hamsa' (Soul/God) is extremely deeply hidden (Nigudha) and safely concealed within all living beings.
            He is completely all-pervading and firmly established in everything, yet remains entirely invisible to normal eyes.
            Exactly in the same way as fire remains deeply hidden inside dry wood (Daru) but isn't seen from the outside.
            Or just as oil is hidden inside sesame seeds and fragrance inside flowers, the Hamsa is hidden in the body.
            'Hamsa' refers to the sound of our breath. Inhaling produces 'Ham' and exhaling produces the sound 'Sa'.
            This continuous, silent chanting (Ajapa Japa) of 'Hamsa' (Aham Sah - I am That) happens within us every single moment.
            God is not in the sky; He resides in every heartbeat and breath precisely like fire in wood and oil in seeds.
            To extract fire from wood, friction is required; similarly, to realize the Soul, the friction of 'Meditation' is needed.
            We see the physical body (wood) but completely forget the fire (consciousness) inside due to sheer ignorance.
            This verse brilliantly provides the most scientific and magnificent example of God's omnipresence and hidden existence.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 4,
        sanskrit = "तं विदित्वा न मृत्युमेति । हंसं हृदयकमलमध्ये ध्यायेत् ॥ ४ ॥",
        hindi = """
            उस भीतर छिपे हुए 'हंस' (आत्मा) को भलीभांति जान लेने पर मनुष्य कभी मृत्यु को प्राप्त नहीं होता।
            (अर्थात वह जन्म-मरण के भयानक चक्र से हमेशा के लिए पार हो जाता है)।
            उस हंस (परमात्मा) का ध्यान साधक को अपने 'हृदय-कमल' के बिल्कुल बीचोबीच (मध्य में) करना चाहिए।
            जब हम अपनी सांसों (हंस) को एकाग्र करते हैं, तो मन अपने-आप हृदय के केंद्र में शांत हो जाता है।
            मृत्यु केवल शरीर की होती है; जो खुद को शरीर मानता है, वह मरने के डर से हमेशा कांपता रहता है।
            पर जो अपनी चेतना को उस 'हंस' के साथ जोड़ लेता है, वह जान जाता है कि वह एक अमर ऊर्जा है।
            हृदय-कमल (अनाहत चक्र) ध्यान का सबसे पवित्र और सुरक्षित स्थान माना गया है।
            यह कोई मांस का टुकड़ा नहीं है, बल्कि यह हमारे भीतर प्रेम, शांति और चेतना का वह आध्यात्मिक केंद्र है।
            ध्यान का अर्थ है—बाहर भागती हुई अपनी सारी ऊर्जा को वापस खींचकर हृदय के उस शून्य में टिका देना।
            जो इस केंद्र को पा लेता है, उसके लिए दुनिया का सबसे बड़ा डर (मौत) एक मामूली खेल बन जाता है।
        """.trimIndent(),
        english = """
            Having perfectly known and realized that hidden 'Hamsa' (Soul), a human being absolutely never meets death again.
            (Meaning, he successfully and permanently transcends the terrifying cycle of repeated births and deaths).
            The seeker must intensely meditate upon that Hamsa (Supreme Lord) exactly in the absolute center of the 'Heart-Lotus'.
            When we focus deeply on our breath (Hamsa), the mind automatically becomes perfectly still in the center of the heart.
            Death happens only to the physical body; he who identifies as the body perpetually trembles with the fear of dying.
            But he who aligns his consciousness firmly with that 'Hamsa' realizes instantly that he is an immortal energy.
            The Heart-Lotus (Anahata Chakra) is considered the most sacred, secure, and profound center for meditation.
            It is not a piece of physical flesh, but the ultimate spiritual center of love, profound peace, and pure consciousness within us.
            Meditation means withdrawing all outwardly rushing energy and flawlessly anchoring it in the void of that heart.
            For one who discovers this center, the world's greatest terrifying fear (death) becomes merely a trivial game.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 5,
        sanskrit = "अष्टदले कमले हंसो निवसति । तस्य पूर्वादिदलेषु फलानि भवन्ति ॥ ५ ॥",
        hindi = """
            वह 'हंस' (जीवात्मा) हमारे हृदय में स्थित आठ पंखुड़ियों वाले कमल (अष्टदल कमल) में निवास करता है।
            उस हृदय-कमल की पूर्व आदि अलग-अलग दिशाओं की पंखुड़ियों (दलों) पर मन के जाने से अलग-अलग फल (प्रभाव) होते हैं।
            यह श्लोक मानव मनोविज्ञान (Psychology) और सूक्ष्म शरीर विज्ञान (Chakra system) का एक बहुत गहरा नक्शा है।
            हमारा मन एक ही है, पर जब वह हृदय के अलग-अलग कोनों (पंखुड़ियों) में जाता है, तो उसकी भावनाएं बदल जाती हैं।
            जैसे टीवी पर चैनल बदलने से दृश्य बदल जाते हैं, वैसे ही मन के अलग-अलग दिशाओं में जाने से हमारे विचार बदलते हैं।
            हृदय का यह आठ पंखुड़ियों वाला कमल हमारी आठ मुख्य भावनाओं और मानसिक स्थितियों का प्रतीक है।
            ध्यान का असली विज्ञान यह जानना है कि इस समय मेरा मन किस पंखुड़ी पर बैठा है।
            यदि मन गलत पंखुड़ी पर है, तो हम दुखी और क्रोधी होंगे; यदि सही पंखुड़ी पर है, तो हम शांत होंगे।
            यह उपनिषद हमें अपने ही दिमाग और भावनाओं को कंट्रोल करने का एक अत्यंत स्पष्ट और वैज्ञानिक तरीका (Method) सिखाता है।
            अगले श्लोकों में हर एक पंखुड़ी का विस्तृत रहस्य बताया जाएगा।
        """.trimIndent(),
        english = """
            That 'Hamsa' (individual soul) strictly resides within the eight-petaled lotus (Ashtadala Kamala) located in our heart.
            When the mind moves to the different directional petals (like the East) of that heart-lotus, different fruits (effects) are produced.
            This verse provides an exceptionally profound map of human Psychology and the subtle energy system (Chakras).
            Our mind is only one, but when it travels to different corners (petals) of the heart, its emotions and moods change completely.
            Just as changing a TV channel changes the scene entirely, the mind's movement to different directions changes our thoughts.
            This highly mystical eight-petaled lotus of the heart strictly symbolizes our eight primary emotions and mental states.
            The true science of meditation is actively recognizing exactly which petal my mind is sitting on at this current moment.
            If the mind is on the wrong petal, we feel sad and angry; if on the right petal, we remain perfectly peaceful.
            This Upanishad teaches us an extremely clear and highly scientific method to control our own brain and chaotic emotions.
            In the following verses, the deep secret of every single petal will be revealed in great detail.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 6,
        sanskrit = "पूर्वदले पुण्ये मतिः । आग्नेये निद्रालस्यादयो भवन्ति ॥ ६ ॥",
        hindi = """
            जब हंस (मन/चेतना) हृदय-कमल की पूर्व दिशा वाली पंखुड़ी पर होता है, तो मनुष्य की बुद्धि पुण्य (अच्छे कर्मों) में लगती है।
            और जब वह आग्नेय (दक्षिण-पूर्व) दिशा की पंखुड़ी पर जाता है, तो मनुष्य को बहुत नींद और आलस्य (आलस) घेर लेता है।
            यह बहुत ही अद्भुत और सटीक मनोवैज्ञानिक विश्लेषण है कि हमारे विचार कैसे बदलते हैं।
            जब सुबह हम उठते हैं और मन शांत (पूर्व दिशा) होता है, तो हमें पूजा-पाठ और दूसरों की मदद करने का विचार आता है।
            परंतु जब वही मन थोड़ा खिसक कर आग्नेय दिशा में जाता है, तो शरीर भारी हो जाता है और हम काम टालने (Procrastination) लगते हैं।
            नींद और आलस्य कोई शारीरिक बीमारी नहीं हैं; ये मन के एक विशेष 'स्थान' पर पहुँचने का परिणाम हैं।
            एक योगी इस बात के प्रति हमेशा अलर्ट (जागरूक) रहता है कि उसकी चेतना किस दिशा में बह रही है।
            यदि आलस्य आ रहा है, तो योगी तुरंत अपने प्राणायाम से मन को उस आग्नेय पंखुड़ी से हटा लेता है।
            हमें अपने विचारों का गुलाम नहीं बनना है; हमें उनका राजा बनना है।
            यह श्लोक हमें अपनी भावनाओं के पीछे के 'कंट्रोल रूम' (Control room) को समझने की कुंजी देता है।
        """.trimIndent(),
        english = """
            When the Hamsa (mind/consciousness) is on the Eastern petal of the heart-lotus, a human's intellect inclines heavily toward virtue (Punya/good deeds).
            And when it moves to the South-East (Agneya) petal, the person is completely overwhelmed by deep sleep and heavy laziness (Alasya).
            This is an incredibly fascinating and highly accurate psychological analysis of exactly how our thoughts constantly shift.
            When we wake up and the mind is peaceful (East), we naturally feel inspired to pray and help others selflessly.
            But when that exact same mind slips slightly to the South-East, the body becomes heavy and we start procrastinating on tasks.
            Sleep and laziness are not merely physical illnesses; they are the direct result of the mind reaching a specific 'location'.
            A true Yogi remains perpetually alert and highly conscious of exactly which direction his vital consciousness is currently flowing.
            If laziness strikes, the Yogi instantly uses Pranayama to forcefully shift his mind away from that Agneya petal.
            We absolutely must not become pathetic slaves to our random thoughts; we must actively become their supreme King.
            This verse hands us the master key to fully understand the hidden 'Control Room' strictly operating behind our emotions.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 7,
        sanskrit = "याम्ये क्रौर्ये मतिः । नैर्ऋत्ये पापे मनीषा ॥ ७ ॥",
        hindi = """
            जब मन हृदय-कमल की दक्षिण (याम्य) दिशा वाली पंखुड़ी पर होता है, तो बुद्धि में क्रूरता (निर्दयता/क्रोध) पैदा होती है।
            और जब वह नैर्ऋत्य (दक्षिण-पश्चिम) दिशा की पंखुड़ी पर पहुँचता है, तो मनुष्य की बुद्धि पाप कर्मों की ओर झुक जाती है।
            अक्सर लोग हैरान होते हैं कि एक अच्छा इंसान अचानक इतना हिंसक और क्रूर कैसे हो गया?
            उपनिषद बताता है कि जब ऊर्जा 'दक्षिण' पंखुड़ी पर टकराती है, तो इंसान के अंदर का पशु जाग उठता है और वह गुस्सा करता है।
            नैर्ऋत्य दिशा पाप की दिशा है; यहाँ पहुँचने पर इंसान को चोरी, धोखा या गलत काम करने में कोई झिझक नहीं होती।
            यह कोई बाहरी शैतान नहीं है जो हमसे पाप करवाता है; यह हमारी अपनी ही असंयमित (Uncontrolled) ऊर्जा का खेल है।
            जब मन इन पंखुड़ियों पर हो, तो साधक को कोई भी बड़ा निर्णय (Decision) लेने से बचना चाहिए।
            उसे तुरंत ॐकार या गहरे ध्यान का अभ्यास करके अपने मन की लोकेशन (Location) को बदलना चाहिए।
            मन की इन गंदी गलियों को पहचान लेना ही इनसे बचने का सबसे पहला और पक्का तरीका है।
            योग वह विज्ञान है जो हमें इन क्रूर और पापी अवस्थाओं से निकालकर वापस पुण्य और शांति में ले आता है।
        """.trimIndent(),
        english = """
            When the mind is on the Southern (Yamya) petal of the heart-lotus, terrible cruelty, ruthlessness, and anger arise in the intellect.
            And when it reaches the South-West (Nairritya) petal, the human intellect becomes intensely inclined toward committing sinful actions.
            People are often completely shocked as to how a perfectly good human being can suddenly become so violently cruel.
            The Upanishad reveals that when energy hits the 'South' petal, the inner animal awakens, causing uncontrollable fits of extreme anger.
            The South-West is the direction of sin; upon reaching here, a person feels zero hesitation in stealing, cheating, or doing evil.
            There is no external devil forcing us to commit sins; it is merely the destructive play of our own uncontrolled internal energy.
            When the mind is stuck on these negative petals, a seeker must strictly avoid making any major life decisions whatsoever.
            He should immediately practice Omkara or deep meditation to forcefully and consciously shift his mind's active 'Location'.
            Recognizing these dark, dirty alleys of the mind is the absolute first and most foolproof way to successfully avoid them.
            Yoga is that exact science which pulls us out of these cruel, sinful states and safely brings us back to virtue and peace.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 8,
        sanskrit = "वारुणे क्रीडायां मतिः । वायव्ये गमनादौ बुद्धिः ॥ ८ ॥",
        hindi = """
            जब मन पश्चिम (वारुण) दिशा की पंखुड़ी पर होता है, तो मनुष्य की बुद्धि खेल-कूद, मनोरंजन और मौज-मस्ती (क्रीडा) में लगती है।
            और जब मन वायव्य (उत्तर-पश्चिम) दिशा की पंखुड़ी पर आता है, तो बुद्धि हमेशा चलने-फिरने (गमन) और यात्रा करने के लिए बेचैन रहती है।
            पश्चिम दिशा की पंखुड़ी पर मन को बहुत चंचलता और हल्कापन महसूस होता है, इसलिए हम पार्टी या गेम खेलना चाहते हैं।
            यह मनोरंजन बुरा नहीं है, पर यदि मन हमेशा यहीं अटका रहे, तो जीवन का गंभीर लक्ष्य (मोक्ष) पीछे छूट जाता है।
            वायव्य (हवा की दिशा) मन को हवा की तरह उड़ाती है; यहाँ मन टिकता नहीं है, बस भागना चाहता है।
            जिन लोगों को हमेशा एक जगह से दूसरी जगह घूमने की या بی‌चैनी (Restlessness) की आदत होती है, उनका मन इसी पंखुड़ी पर होता है।
            यह अवस्था ध्यान के लिए सबसे बड़ी दुश्मन है, क्योंकि ध्यान में शरीर और मन दोनों का स्थिर होना बहुत जरूरी है।
            अगर आपको बैठते ही पैर हिलाने या उठकर भागने का मन करे, तो समझ लें कि चेतना वायव्य पंखुड़ी पर है।
            योगी अपनी श्वास (प्राण) को धीमा करके इस उड़ने वाले मन को वापस केंद्र में लाकर बाँधता है।
            हमारी हर आदत का एक स्विच (Switch) हमारे ही दिल में मौजूद है।
        """.trimIndent(),
        english = """
            When the mind is on the Western (Varuna) petal, the human intellect becomes highly inclined toward sports, amusement, and playful entertainment (Krida).
            And when the mind comes to the North-West (Vayavya) petal, the intellect becomes perpetually restless, constantly desiring to walk, move, and travel (Gaman).
            On the Western petal, the mind feels extreme playfulness and lightness, which is exactly why we desire to party or play games.
            This entertainment is not inherently evil, but if the mind gets permanently stuck here, the serious goal of life (Moksha) is left behind.
            Vayavya (the direction of wind) blows the mind around like the wind; the mind simply cannot settle here, it just wants to run wildly.
            People who have a chronic habit of constantly traveling from place to place or suffer from sheer restlessness, have their mind stuck on this specific petal.
            This state is the absolute greatest enemy of deep meditation, because in meditation, both the body and the mind must remain perfectly still.
            If you feel an intense urge to shake your legs or jump up and run the moment you sit down, understand that your consciousness is on the Vayavya petal.
            A true Yogi actively slows down his breath (Prana) to reel this flying, chaotic mind back in and securely tie it to the center.
            A dedicated master switch for every single habit of ours is flawlessly located right inside our own heart.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 9,
        sanskrit = "उत्तरे रतिप्रीतिः । ईशाने द्रव्यादानम् ॥ ९ ॥",
        hindi = """
            जब मन उत्तर दिशा की पंखुड़ी पर होता है, तो मनुष्य के भीतर काम-वासना, प्रेम और रति (शारीरिक सुख) की प्रबल इच्छा जगती है।
            और जब मन ईशान (उत्तर-पूर्व) दिशा की पंखुड़ी पर होता है, तो मनुष्य की बुद्धि केवल धन-संपत्ति (द्रव्य) को इकट्ठा करने (आदान) में लग जाती है।
            उत्तर दिशा की पंखुड़ी पर मन दुनिया के सबसे बड़े आकर्षण (Sex and physical love) में फँसता है।
            यह एक बहुत शक्तिशाली ऊर्जा है, और अगर इसे सही दिशा (ऊर्ध्वरेता) न दी जाए, तो यह साधक को पूरी तरह गिरा देती है।
            ईशान कोण पर मन को पैसे की भूख (Greed) लग जाती है; वह दिन-रात केवल बैंक बैलेंस बढ़ाने के सपने देखता है।
            लालच इंसान को अंधा कर देता है और वह भूल जाता है कि मौत के समय यह सारा 'द्रव्य' यहीं मिट्टी में मिल जाएगा।
            हम सोचते हैं कि हम बाहर की दुनिया को कंट्रोल कर रहे हैं, पर असल में ये पंखुड़ियां हमें कठपुतली (Puppet) की तरह नचा रही हैं।
            काम और लोभ (Lust and Greed) जीवन की सबसे बड़ी बेड़ियां हैं जो हमें आत्मा की आज़ादी से दूर रखती हैं।
            साधक को इन दोनों पंखुड़ियों से अपनी चेतना को बहुत ही सावधानी और वैराग्य के साथ हटाना पड़ता है।
            उपनिषद हमें यह स्कैनिंग मशीन (Scanning Machine) दे रहा है जिससे हम अपने मन की बीमारी को पकड़ सकें।
        """.trimIndent(),
        english = """
            When the mind is on the Northern petal, a highly intense desire for lust, physical love, and sexual pleasure (Rati) awakens fiercely within the human.
            And when the mind is on the North-East (Ishana) petal, the human intellect becomes entirely obsessed with accumulating and hoarding vast wealth (Dravya).
            On the Northern petal, the mind gets deeply trapped in the world's most powerful, blinding attraction (Sex and physical love).
            This is an incredibly powerful energy, and if it is not sublimated and directed upwards (Urdhvareta), it completely destroys the seeker.
            On the Ishana petal, the mind develops an insatiable hunger for money (Greed); it dreams solely of increasing bank balances day and night.
            Greed totally blinds a person, making him completely forget that at the exact moment of death, all this 'wealth' will become mere dust here.
            We falsely think we are controlling the outside world, but in reality, these hidden petals are dancing us exactly like helpless puppets.
            Lust and Greed are the absolute heaviest shackles of life that keep us miles away from the ultimate freedom of the Soul.
            A sincere seeker must actively, carefully, and with profound detachment (Vairagya) withdraw his consciousness away from both these dangerous petals.
            The Upanishad provides us with this remarkable internal Scanning Machine so we can accurately diagnose and cure the severe sickness of our mind.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 10,
        sanskrit = "मध्ये वैराग्यम् । केसरे जाग्रदवस्था भवति ॥ १० ॥",
        hindi = """
            जब मन इन सभी पंखुड़ियों को छोड़कर कमल के बिल्कुल मध्य (केंद्र/कर्णिका) में आ जाता है, तब पूर्ण 'वैराग्य' (Detachment) उत्पन्न होता है।
            और जब चेतना कमल के केसर (Filaments/पंखुड़ियों के धागों) पर होती है, तो वह मनुष्य की 'जाग्रत अवस्था' (Waking state) कहलाती है।
            यह श्लोक ध्यान का सबसे बड़ा रहस्य खोलता है। शांति किसी भी दिशा (बाहरी दुनिया) में नहीं है, वह केवल 'केंद्र' (Center) में है।
            जब मन केंद्र में आता है, तो उसे न पैसे की भूख रहती है, न वासना सताती है और न ही कोई क्रोध आता है।
            वैराग्य का मतलब दुनिया से भागना नहीं है, बल्कि दुनिया की किसी भी चीज़ के प्रभाव से पूरी तरह मुक्त (Zero reaction) हो जाना है।
            जाग्रत अवस्था में हमारी चेतना कमल के केसर (बाहरी किनारों) पर फैली रहती है, इसलिए हम दुनिया को देखते और सुनते हैं।
            जैसे ही हम केसर से सिमटकर केंद्र में आते हैं, बाहरी दुनिया का स्विच ऑफ (Switch off) हो जाता है।
            यही वह अवस्था है जिसे हर योगी अपनी साधना में पाना चाहता है, जहाँ केवल पूर्ण मौन और वैराग्य हो।
            जब तक मन बाहर की पंखुड़ियों पर भटकता है, तब तक इंसान एक गुलाम है; जब वह मध्य में आता है, तो वह राजा बन जाता है।
            सारी साधना इस 'मध्य' बिंदु को ढूँढने और वहाँ टिके रहने का ही एक निरंतर अभ्यास है।
        """.trimIndent(),
        english = """
            When the mind completely leaves all these outer petals and reaches the exact absolute center (Madhya/Pericarp) of the lotus, complete 'Vairagya' (Detachment) arises.
            And when the consciousness is actively spread on the filaments (Kesara) of the lotus, that is known as the human's 'Waking State' (Jagrat).
            This verse reveals the absolute greatest secret of meditation. True peace is absolutely not in any direction (outside world); it is exclusively in the 'Center'.
            When the mind successfully arrives at the center, it is completely free from money-hunger, immune to lust, and entirely devoid of any anger.
            Vairagya absolutely does not mean running away from the world; it means becoming completely unaffected (Zero reaction) by anything in the world.
            In the waking state, our consciousness remains extended on the outer filaments, which is precisely why we see and interact with the physical world.
            The exact moment we withdraw from the filaments and contract into the center, the external world is instantly 'Switched Off' for us.
            This is exactly that supreme state every Yogi desperately strives to achieve in his practice, where there is only absolute Silence and Detachment.
            As long as the mind wanders on the outer petals, a human is a pathetic slave; the moment he reaches the center, he becomes a supreme King.
            All spiritual practice is essentially the continuous, relentless effort to find this 'Center' point and remain firmly anchored there forever.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 11,
        sanskrit = "कर्णिकायां स्वप्नावस्था । नाले सुषुप्त्यवस्था ॥ ११ ॥",
        hindi = """
            जब चेतना कमल के मध्य भाग (कर्णिका / Pericarp) में प्रवेश करती है, तो वह मनुष्य की 'स्वप्न अवस्था' (सपनों की दुनिया) होती है।
            और जब वह चेतना कमल की नाल (Stem / डंठल) में पूरी तरह उतर जाती है, तो वह गहरी नींद (सुषुप्ति अवस्था) कहलाती है।
            यहाँ चेतना के भीतर (Inward) जाने की यात्रा को बहुत ही बारीकी से समझाया गया है।
            जाग्रत में हम बाहर थे (केसर पर), जब हम थोड़ा अंदर (कर्णिका में) जाते हैं, तो बाहरी दुनिया कट जाती है और हम सपने देखते हैं।
            सपनों में मन अपनी ही स्मृतियों (Memories) की एक नई दुनिया बनाता है और उसमें रमता है।
            पर जब इंसान बहुत थक जाता है, तो चेतना और भी गहरी होकर कमल की डंठल (नाल) में छिप जाती है।
            नाल में जाने पर न शरीर का होश रहता है और न ही कोई सपना आता है; वहाँ पूर्ण अंधकार और अज्ञान वाली शांति (सुषुप्ति) होती है।
            यह एक प्राकृतिक (Natural) प्रक्रिया है जो हर इंसान के साथ रोज रात को होती है।
            परंतु अज्ञानी व्यक्ति इस प्रक्रिया में बेहोश रहता है, जबकि एक योगी इसे पूरे होश (Awareness) के साथ देखता है।
            नींद भी एक प्रकार का ध्यान ही है, बस उसमें 'ज्ञान' का प्रकाश नहीं होता।
        """.trimIndent(),
        english = """
            When the consciousness deeply enters the very middle portion (Karnika / Pericarp) of the lotus, that is the human's 'Dream State' (Svapna).
            And when that consciousness descends completely down into the very stem (Nala) of the lotus, it is perfectly known as deep, dreamless sleep (Sushupti).
            Here, the incredibly precise inward journey of human consciousness is explained with astonishing, microscopic detail.
            In the waking state we were outside (on filaments); when we go slightly inward (into the pericarp), the external world is cut off and we dream.
            In dreams, the mind creates a completely new, vivid world purely out of its own stored memories and happily revels in it.
            But when a human gets utterly exhausted, consciousness sinks even deeper and hides securely in the stem (Nala) of the lotus.
            Upon entering the stem, there is no awareness of the body, nor do any dreams appear; there is only the peace of complete darkness and ignorance (Sushupti).
            This is a flawless, natural biological and spiritual process that happens to every single human being every single night.
            However, an ignorant person remains completely unconscious during this process, whereas a master Yogi actively observes it with full, unbroken Awareness.
            Deep sleep is indeed a profound form of meditation itself, except that it completely lacks the brilliant light of true 'Wisdom'.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 12,
        sanskrit = "पद्मत्यागे तुरीयावस्था भवति । यदा हंसो नादे लीनो भवति तदा तुरीयातीतम् ॥ १२ ॥",
        hindi = """
            जब चेतना उस पूरे हृदय-कमल का भी त्याग कर देती है (पद्मत्याग), तब वह महान 'तुरीय अवस्था' (चौथी अवस्था) को प्राप्त होती है।
            और जब वह हंस (चेतना) भीतर गूँजने वाले 'नाद' (परम ध्वनि/ॐकार) में पूरी तरह लीन हो जाता है, तब वह 'तुरीयातीत' (तुरीय से भी परे) अवस्था होती है।
            सुषुप्ति (नींद) के बाद भी एक अवस्था है, जहाँ कमल (शरीर/मन का आधार) ही पूरी तरह छूट जाता है; यह आत्म-साक्षात्कार (तुरीय) है।
            तुरीय में साधक को पूर्ण होश रहता है कि "मैं शरीर और मन नहीं, केवल एक शुद्ध प्रकाश हूँ।"
            पर उपनिषद इससे भी एक कदम आगे जाता है और 'तुरीयातीत' (Beyond Turiya) की बात करता है।
            जब साधक ध्यान में गहरा उतरता है, तो उसे अपने भीतर एक दिव्य ध्वनि (नाद) सुनाई देती है।
            जब साधक का अपना 'मैं' (अहंकार) उस ध्वनि में पूरी तरह घुलकर शून्य हो जाता है, तो वह परम अवस्था है।
            वहाँ न तो ध्यान करने वाला बचता है और न ही कोई दुनिया; वहाँ केवल एक अखंड परमानंद का सागर होता है।
            यही वह सबसे आखिरी मंजिल है जहाँ पहुँचने के बाद लौटने का कोई रास्ता या कारण नहीं बचता।
            नाद (Cosmic Sound) ही वह अंतिम पुल है जो जीव को साक्षात् परब्रह्म से मिला देता है।
        """.trimIndent(),
        english = """
            When the consciousness completely abandons and transcends even that entire heart-lotus (Padmatyaga), it successfully attains the great 'Turiya State' (the Fourth State).
            And when that Hamsa (Consciousness) perfectly and entirely merges into the resonating 'Nada' (Supreme Sound/OM) within, that is the ultimate 'Turiyatita' (Beyond Turiya) state.
            There is a state strictly beyond deep sleep where the very lotus (the base of body/mind) is entirely dropped; this is direct Self-realization (Turiya).
            In Turiya, the seeker possesses absolute, crystal-clear awareness that "I am neither body nor mind, I am strictly pure, radiant Light."
            But the Upanishad goes one massive step further and profoundly speaks of 'Turiyatita' (that which is completely Beyond Turiya).
            When a seeker dives infinitely deep in meditation, he clearly hears a divine, cosmic sound (Nada) resonating right within him.
            When the seeker's own 'I' (Ego) flawlessly dissolves into that cosmic sound and becomes zero, that is the absolute Supreme State.
            There, neither a meditator survives nor any world exists; there is absolutely nothing but an unbroken, infinite ocean of Supreme Bliss.
            This is exactly that final, ultimate destination reaching which absolutely no path or reason to return ever remains.
            The Nada (Cosmic Sound) is the absolute final bridge that seamlessly unites the individual soul directly with the Supreme Brahman.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 13,
        sanskrit = "नादो दशविधो जायते । चिणीति प्रथमः । चिणिचिणीति द्वितीयः ॥ १३ ॥",
        hindi = """
            (यहाँ से नाद योग का वर्णन शुरू होता है): ध्यान की गहराई में उत्पन्न होने वाला वह 'नाद' (आंतरिक ध्वनि) दस (10) प्रकार का होता है।
            इनमें से जो सबसे पहली ध्वनि सुनाई देती है, वह 'चिणि' (चिन्-चिन् जैसी बारीक आवाज़) के समान होती है।
            और जो दूसरी ध्वनि सुनाई देती है, वह 'चिणि-चिणि' (लगातार होने वाली झंकार) के समान होती है।
            जब योगी अपनी इंद्रियों को बाहर से बंद करके अपने भीतर ध्यान लगाता है, तो उसे बाहर की नहीं बल्कि अंदर की आवाजें सुनाई देती हैं।
            यह कोई कानों की बीमारी (Tinnitus) नहीं है, बल्कि यह हमारे नर्वस सिस्टम (Nervous system) और प्राण ऊर्जा की अत्यंत सूक्ष्म ध्वनि है।
            जैसे-जैसे मन शांत होता है, हमारी सुनने की शक्ति (Hearing capacity) स्थूल (Gross) से अत्यंत सूक्ष्म (Subtle) हो जाती है।
            शुरुआत में ये ध्वनियां बहुत हल्की और झींगुर (Cricket) की आवाज़ जैसी 'चिणि' होती हैं।
            यह एक पक्का संकेत (Signal) है कि साधक का ध्यान सही दिशा में जा रहा है और उसका मन एकाग्र हो रहा है।
            साधक को इन ध्वनियों से डरना नहीं चाहिए, बल्कि अपना पूरा ध्यान इन्हीं पर केंद्रित (Focus) कर देना चाहिए।
            नाद योग दुनिया की सबसे सरल साधना है, क्योंकि मन को रोकने के लिए आवाज़ (Sound) एक बहुत ही मीठा और शक्तिशाली चुंबक (Magnet) है।
        """.trimIndent(),
        english = """
            (Here begins the description of Nada Yoga): That profound 'Nada' (internal cosmic sound) arising in the extreme depths of meditation is of exactly ten (10) distinct types.
            Out of these, the absolute first sound that is clearly heard is exactly like 'Chini' (a very sharp, subtle, tingling sound).
            And the second distinct sound that successfully manifests is exactly like 'Chini-Chini' (a continuous, unbroken chiming or ringing).
            When a Yogi firmly closes his physical senses from the outside world and meditates deeply within, he hears internal, not external, sounds.
            This is absolutely not a physical ear disease (like Tinnitus), but the exceedingly subtle sound of our own nervous system and Pranic energy.
            As the mind becomes perfectly still, our hearing capacity remarkably shifts from the gross (physical) to the extremely subtle (spiritual).
            In the very beginning, these sounds are extremely faint and sound exactly like the sharp chirping of a cricket ('Chini').
            This is a highly confirmed, positive signal that the seeker's meditation is heading precisely in the right direction and his mind is concentrating.
            A seeker must absolutely never fear these mystical sounds, but instead should actively focus his entire, undivided attention strictly upon them.
            Nada Yoga is the world's simplest spiritual practice, because to stop a restless mind, Sound acts as an incredibly sweet and powerful magnet.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 14,
        sanskrit = "घण्टानादस्तृतीयः । शङ्खनादश्चतुर्थः ॥ १४ ॥",
        hindi = """
            ध्यान के और अधिक गहरे होने पर जो तीसरी ध्वनि सुनाई देती है, वह किसी बड़ी 'घंटी' (घण्टा / Bell) के बजने जैसी गूँज होती है।
            और जो चौथी ध्वनि प्रकट होती है, वह किसी पवित्र 'शंख' (Conch) के बजने जैसी अत्यंत गंभीर और लंबी आवाज़ होती है।
            जैसे-जैसे प्राण (ऊर्जा) ऊपर के चक्रों में चढ़ता है, नाद (ध्वनि) का स्वरूप बदलता जाता है।
            घंटी की आवाज़ मन को एक झटके में शून्य कर देती है; मंदिरों में घंटी बजाने का असली विज्ञान भी यही है।
            यह बाहरी घंटी हमें हमारे भीतर बजने वाली उस असली, अनंत घंटी की याद दिलाने के लिए है।
            शंख की ध्वनि अत्यंत शक्तिशाली और शुद्ध करने वाली होती है; यह साधक के भीतर के सारे डरों और मलिनताओं (Impurities) को उड़ा देती है।
            जब शंखनाद सुनाई दे, तो समझना चाहिए कि कुण्डलिनी ऊर्जा अब जागृत होकर स्थिरता प्राप्त कर रही है।
            इस अवस्था में बाहरी दुनिया का शोर साधक को बिल्कुल भी डिस्टर्ब (Disturb) नहीं कर सकता।
            उसका मन उस शंखनाद की मधुर गूँज में पूरी तरह से सम्मोहित और कैद हो जाता है।
            ये ध्वनियां कोई भ्रम नहीं हैं, ये ब्रह्मांड (Cosmos) की वे असली फ्रीक्वेंसी (Frequencies) हैं जिनसे यह पूरी सृष्टि बनी है।
        """.trimIndent(),
        english = """
            Upon the meditation becoming even more intensely deep, the third sound heard is exactly like the loud, echoing ring of a large 'Bell' (Ghanta).
            And the fourth distinct sound that perfectly manifests is exactly like the extremely deep, long, and resonant blowing of a sacred 'Conch' (Shankha).
            As the vital breath (Prana) steadily ascends into the higher Chakras, the precise nature of the Nada (sound) continuously transforms.
            The profound sound of a bell forcefully reduces the mind to absolute zero in a single stroke; this is the real science behind ringing bells in temples.
            The external temple bell is specifically designed to remind us of that real, infinite, unbroken bell ringing constantly within us.
            The sound of the conch is exceptionally powerful and purifying; it completely blows away all internal fears and mental impurities of the seeker.
            When the Conch-sound is clearly heard, one must perfectly understand that the Kundalini energy is now fully awakened and gaining stability.
            In this highly elevated state, the chaotic noise of the external physical world simply cannot disturb the seeker at all.
            His entire mind becomes completely hypnotized, captivated, and blissfully imprisoned within the sweet, echoing resonance of that conch.
            These sounds are not hallucinations; they are the actual, literal cosmic frequencies (vibrations) out of which this entire universe is constructed.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 15,
        sanskrit = "तन्त्रीनादः पञ्चमः । तालनादः षष्ठः ॥ १५ ॥",
        hindi = """
            नाद की पांचवीं अवस्था में साधक को वीणा के तारों (तन्त्री / Lute) के झंकृत होने जैसी अत्यंत मधुर ध्वनि सुनाई देती है।
            और छठी अवस्था में जो ध्वनि प्रकट होती है, वह 'ताल' (झांझ / मंजीरा / Cymbals) के बजने जैसी लयबद्ध आवाज़ होती है।
            पाँचवीं ध्वनि (वीणा) मन को भाव-विभोर कर देती है; यह साक्षात् देवी सरस्वती का संगीत है जो हमारे ही भीतर बज रहा है।
            इस स्तर पर ध्यान एक संघर्ष (Struggle) नहीं रहता, बल्कि यह एक अत्यंत आनंददायक और रसपूर्ण अनुभव (Blissful experience) बन जाता है।
            ताल (मंजीरा) की छठी ध्वनि साधक की श्वास और हृदय की धड़कन को एक परम ब्रह्मांडीय लय (Cosmic Rhythm) में बाँध देती है।
            अब शरीर, मन और प्राण एक ही ताल पर नाचने लगते हैं; सारा बिखराव और तनाव हमेशा के लिए खत्म हो जाता है।
            योगी को इन मधुर आवाजों में इतना रस आने लगता है कि वह बाहरी संगीत या मनोरंजन को पूरी तरह भूल जाता है।
            यह संगीत (नाद) किसी बाहरी वाद्य-यंत्र (Instrument) से नहीं पैदा हो रहा, यह आत्मा की अपनी ही प्राकृतिक गूँज है।
            साधक को यहाँ भी रुकना नहीं है, क्योंकि ये ध्वनियां भी केवल माइलस्टोन (Milestones) हैं, अंतिम मंजिल नहीं।
            मन को एक आवाज़ से हटाकर अगली आवाज़ में डुबाते हुए, उसे और अधिक सूक्ष्म (Subtle) बनाते जाना ही यह महान योग है।
        """.trimIndent(),
        english = """
            In the fifth stage of Nada, the seeker clearly hears an exceedingly sweet sound exactly like the vibrating strings of a 'Lute' (Tantri / Veena).
            And the sixth sound that beautifully manifests is a perfectly rhythmic sound exactly like the striking of 'Cymbals' (Tala / Manjira).
            The fifth sound (Veena) completely overwhelms the mind with deep emotion; it is the direct music of Goddess Saraswati playing right inside us.
            At this highly advanced level, meditation is no longer a harsh struggle, but it effortlessly transforms into an extremely blissful, juicy experience.
            The sixth sound of the cymbals perfectly binds the seeker's breath and heartbeat directly into a supreme Cosmic Rhythm.
            Now the physical body, restless mind, and vital breath all begin to dance flawlessly to a single beat; all scattering and stress end forever.
            The Yogi begins to find so much immense pleasure in these sweet sounds that he completely forgets all external music or worldly entertainment.
            This divine music (Nada) is absolutely not produced by any external physical instrument; it is the natural, uncreated echo of the Soul itself.
            The seeker must absolutely not stop here either, because even these beautiful sounds are merely milestones, not the ultimate final destination.
            Continuously shifting the mind from one sound to the next deeper sound, making it infinitely subtler, is the exact process of this great Yoga.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 16,
        sanskrit = "वेणुनादः सप्तमः । मृदङ्गनादोऽष्टमः ॥ १६ ॥",
        hindi = """
            सातवें स्तर पर जो अत्यंत मनमोहक ध्वनि सुनाई देती है, वह भगवान कृष्ण की बांसुरी (वेणु / Flute) जैसी होती है।
            और आठवें स्तर पर पहुँचने पर किसी बड़े नगाड़े या पखावज (मृदङ्ग / Drum) के बजने जैसी गहरी धमक सुनाई पड़ती है।
            बांसुरी की आवाज़ इतनी मीठी होती है कि वह योगी की बची-खुची सारी वासनाओं को पिघलाकर प्रेम में बदल देती है।
            यह वह नाद है जिसने गोपियों को भी दुनिया भूलने पर मजबूर कर दिया था; यह साक्षात् परमानंद की पुकार है।
            मृदंग (ड्रम) की आठवीं ध्वनि साधक की कुण्डलिनी ऊर्जा को पूरी तरह से प्रज्वलित और शक्तिशाली बना देती है।
            इस गहरी धमक से शरीर के सारे सूक्ष्म चक्र (Chakras) पूरी तरह से खुल जाते हैं और ऊर्जा सहस्रार की ओर भागती है।
            अब साधक का 'अहंकार' पूरी तरह से टूटने की कगार पर है; यह मृदंग उस अहंकार के अंत की घोषणा (Announcement) है।
            इन ध्वनियों को सुनने के लिए कान बंद करके अपने पूरे ध्यान को आज्ञा चक्र (भ्रूमध्य) पर टिकाना पड़ता है।
            जो व्यक्ति इस नाद को सुन लेता है, उसके लिए दुनिया की बड़ी से बड़ी बातें और लालच बिल्कुल छोटे और बेकार हो जाते हैं।
            भगवान को बाहर ढूँढने वाले भटकते हैं, पर नाद योगी आँख बंद करके उसी भगवान को अपने भीतर सुन लेता है।
        """.trimIndent(),
        english = """
            At the highly elevated seventh level, the extremely enchanting sound clearly heard is exactly like Lord Krishna's divine 'Flute' (Venu).
            And upon successfully reaching the eighth level, a profound, deep thumping sound exactly like a large beating 'Drum' (Mridanga) is heard.
            The sound of the flute is so overwhelmingly sweet that it instantly melts all the Yogi's remaining lusts and transforms them into pure love.
            This is exactly that Nada which forced the Gopis to completely forget the world; it is the direct, irresistible call of Supreme Bliss.
            The eighth sound of the Mridanga (drum) completely ignites and makes the seeker's Kundalini energy exceptionally powerful and active.
            Through this deep, rhythmic thumping, all the subtle Chakras of the body open completely, and the energy rushes straight toward the Crown.
            Now the seeker's 'Ego' is absolutely on the verge of total destruction; this beating drum is the grand announcement of that ego's absolute end.
            To clearly hear these divine sounds, one must firmly close the physical ears and anchor his entire focus directly on the Ajna Chakra (between the eyebrows).
            For the person who successfully hears this Nada, the world's greatest worldly matters and extreme greeds become utterly tiny and completely useless.
            Those who search for God outside wander endlessly, but the Nada Yogi simply closes his eyes and flawlessly hears that very God right within himself.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 17,
        sanskrit = "भेरीनादो नवमः । मेघनादो दशमः ॥ १७ ॥",
        hindi = """
            नौवें स्तर की ध्वनि एक अत्यंत विशाल युद्ध के नगाड़े (भेरी / Kettle-drum) जैसी भयंकर और शक्तिशाली होती है।
            और सबसे अंतिम, दसवीं ध्वनि आकाश में गरजने वाले बादलों की गड़गड़ाहट (मेघनाद / Thunder) के समान होती है।
            भेरी की आवाज़ वह शंखनाद है जो अब जीव और माया के बीच के अंतिम महा-युद्ध (Final battle) का संकेत देती है।
            यह ध्वनि योगी के मन में बसे अंतिम 'मैं-पन' के संस्कारों को पूरी तरह से चकनाचूर कर देती है।
            दसवीं ध्वनि (मेघनाद) वह परम और असीम ध्वनि है जो पूरे ब्रह्मांड में गूँज रही है; यह साक्षात् 'ॐ' का असली विराट रूप है।
            बादलों की गड़गड़ाहट जैसी इस आवाज़ में इतनी ताकत होती है कि साधक का मन (Mind) हमेशा के लिए शून्य (Zero) हो जाता है।
            जैसे बिजली गिरने पर सब कुछ स्तब्ध (Silent) हो जाता है, वैसे ही मेघनाद के सामने सारे विचार भस्म हो जाते हैं।
            यही वह आखिरी और सर्वोच्च नाद है जिसके बाद कोई और आवाज़ नहीं बचती, बस परम सन्नाटा (मोक्ष) आ जाता है।
            यह 10 ध्वनियों की यात्रा एक वैज्ञानिक प्रक्रिया है जो साधक को स्थूल दुनिया से निकालकर सीधे निराकार ईश्वर में फेंक देती है।
            नाद योग का यह अंतिम विस्फोट (Explosion) इंसान को एक साधारण जीव से साक्षात् 'शिव' में रूपांतरित (Transform) कर देता है।
        """.trimIndent(),
        english = """
            The sound at the ninth level is as intensely fierce and tremendously powerful as a massive, echoing war 'Kettle-drum' (Bheri).
            And the absolute final, tenth sound is exactly like the earth-shattering, roaring 'Thunder' of dark clouds (Meghanada) in the sky.
            The sound of the Bheri is the battle-cry that strictly signals the ultimate, Final Battle between the individual soul and cosmic Maya.
            This intense sound completely shatters and destroys the absolute last remaining traces of 'I-ness' (Ego) deeply hidden in the Yogi's mind.
            The tenth sound (Thunder) is that supreme, boundless vibration resonating throughout the entire cosmos; it is the true, colossal form of 'OM'.
            This earth-shattering thunderous sound possesses so much sheer power that the seeker's Mind is permanently and instantly reduced to Zero.
            Just as everything becomes dead silent after a lightning strike, absolutely all thoughts are instantly burnt to ashes before this Meghanada.
            This is exactly that final, ultimate Nada after which absolutely no other sound remains; only Supreme, absolute Silence (Moksha) arrives.
            This journey of 10 sounds is a flawless scientific process that pulls a seeker from the gross world and throws him straight into the formless God.
            This final, massive explosion of Nada Yoga completely and flawlessly transforms a human from an ordinary creature directly into 'Shiva' Himself.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 18,
        sanskrit = "नवमं परित्यज्य दशममेवाभ्यसेत् । तस्मिन् लीने मनो गच्छति ॥ १८ ॥",
        hindi = """
            साधक को चाहिए कि वह शुरुआत की उन पहली नौ (9) ध्वनियों को छोड़ दे और केवल उस दसवीं (मेघनाद) ध्वनि का ही अभ्यास करे।
            जब साधक अपना पूरा ध्यान केवल उस दसवीं ध्वनि पर लगा देता है, तो उसका मन उसी महान ध्वनि में पूरी तरह लीन (विलीन) हो जाता है।
            पहली 9 ध्वनियां बहुत मीठी और आकर्षक हैं, इसलिए साधक का मन उनमें उलझ कर रुक सकता है।
            उपनिषद सख्त चेतावनी देता है कि बीच के चमत्कारों या सुखों (जैसे वीणा या बांसुरी की आवाज़) पर रुकना नहीं है।
            दसवीं ध्वनि (बादलों की गड़गड़ाहट) सबसे विशाल और असीम है; केवल वही मन को पूरी तरह से निगल सकती है।
            'मन का लीन होना' (Dissolution of mind) ही राजयोग का अंतिम और सबसे बड़ा लक्ष्य है।
            जब तक मन जिंदा है, तब तक इंसान को सुख-दुख और डर सताते रहेंगे; मन के मरते ही सब कुछ परम शांत हो जाता है।
            जैसे नमक पानी में मिलकर गायब हो जाता है, वैसे ही मन उस दसवीं ध्वनि (ॐकार) में घुलकर हमेशा के लिए शून्य हो जाता है।
            इस अवस्था में पहुँचने के बाद कोई विचार, कोई इच्छा और कोई अहंकार बाकी नहीं रहता।
            साधक को अब कुछ करना नहीं पड़ता; वह स्वयं उस नाद (ईश्वर) का ही एक हिस्सा बन जाता है।
        """.trimIndent(),
        english = """
            A sincere seeker must absolutely abandon and let go of the first nine (9) sounds and exclusively practice focusing only on the tenth (Thunder) sound.
            When the seeker anchors his complete, undivided attention solely on that tenth sound, his mind becomes completely merged and dissolved (Lina) into it.
            The first 9 sounds are incredibly sweet and highly attractive, so the seeker's mind can easily get entangled and stuck in them.
            The Upanishad gives a strict warning: absolutely do not stop at intermediate miracles or pleasures (like the beautiful sounds of the lute or flute).
            The tenth sound (roaring thunder) is the most colossal and infinite; it alone possesses the raw power to completely swallow the human mind.
            The 'Dissolution of the mind' (Mano lina) is the absolute final and greatest, supreme goal of Raja Yoga.
            As long as the mind is alive, a human will be constantly tormented by joy, sorrow, and fear; the moment the mind dies, everything becomes perfectly peaceful.
            Just as salt completely dissolves and vanishes in water, the mind melts into that tenth sound (Omkara) and becomes Zero forever.
            After successfully reaching this ultimate state, absolutely no thought, no desire, and zero ego remain existing anymore.
            The seeker no longer has to 'do' anything; he himself seamlessly becomes an inseparable part of that very Nada (Supreme Lord).
        """.trimIndent()
    ),
    HamsaShloka(
        id = 19,
        sanskrit = "मनसि सङ्कल्पविकल्पे दग्धे पुण्यपापे विलीयते । तदा सदाशिवः शक्त्यात्मा सर्वत्रावस्थितः ॥ १९ ॥",
        hindi = """
            जब उस परम नाद में मन के सभी संकल्प (इच्छाएं) और विकल्प (संदेह/विचार) पूरी तरह से जलकर भस्म (दग्ध) हो जाते हैं।
            तब उस योगी के करोड़ों जन्मों के सारे पुण्य और पाप भी हमेशा के लिए विलीन (नष्ट) हो जाते हैं।
            उस अवस्था में वह योगी स्वयं को 'सदाशिव' (परम कल्याणकारी) और 'शक्त्यात्मा' (शक्ति के मूल स्रोत) के रूप में अनुभव करता है।
            और वह जान जाता है कि वह एक छोटे से शरीर में कैद नहीं, बल्कि सर्वत्र (हर जगह) समान रूप से स्थित (अवस्थित) है।
            पुण्य और पाप केवल तब तक हैं जब तक 'मैं' (अहंकार) यह सोचता है कि "मैंने यह काम किया है।"
            जब नाद के विस्फोट से वह 'मैं' ही मर गया, तो पाप और पुण्य किस पर चिपकेंगे? वे राख हो जाते हैं।
            यही 'कर्मों का कटना' (Liberation from Karma) है, जो दुनिया के किसी भी कर्मकांड या पूजा से नहीं हो सकता।
            सदाशिव कोई व्यक्ति नहीं है, यह चेतना की वह सबसे ऊँची स्थिति (State) है जो हमेशा शुद्ध और आनंदमय है।
            साधक अब एक साधारण इंसान नहीं रहा; वह साक्षात् पूरे ब्रह्मांड की चेतना (Universal Consciousness) बन चुका है।
            उसे अपनी सर्वव्यापकता (Omnipresence) का सीधा और सच्चा अनुभव हो जाता है।
        """.trimIndent(),
        english = """
            When absolutely all resolves (desires) and doubts (thoughts) of the mind are completely burnt to ashes (Dagdha) within that Supreme Nada.
            Then all the merits (Punya) and sins (Papa) of millions of the Yogi's past lifetimes also dissolve and are destroyed forever.
            In that supreme state, the Yogi experiences himself strictly as 'Sada-Shiva' (the eternally auspicious) and 'Shaktyatma' (the core soul of all power).
            And he profoundly realizes that he is absolutely not confined in a tiny physical body, but is equally established and present everywhere (Omnipresent).
            Merits and sins exist only as long as the 'I' (Ego) falsely thinks, "I am the one who performed this specific action."
            When that very 'I' is killed completely by the explosion of Nada, onto whom will the sins and merits attach? They turn to ashes.
            This is the true 'Severing of Karma' (Liberation), which can absolutely never be achieved by any worldly ritual or external worship.
            Sada-Shiva is not a person; it is that absolute highest state of Consciousness which is eternally pure, unbroken, and blissful.
            The seeker is no longer an ordinary human being; he has literally become the Universal Consciousness of the entire cosmos.
            He gains the direct, indisputable, and true living experience of his own absolute Omnipresence (pervading everywhere).
        """.trimIndent()
    ),
    HamsaShloka(
        id = 20,
        sanskrit = "स्वयंज्योतिः शुद्धो बुद्धो नित्यो निरञ्जनः प्रशान्तः प्रकाशते ॥ २० ॥",
        hindi = """
            उस परम अवस्था (मोक्ष) में वह आत्मा अपने आप ही (स्वयंज्योतिः / बिना किसी बाहरी प्रकाश के) पूरी तरह से चमकने लगती है।
            वह आत्मा परम शुद्ध (मलिनता-रहित), बुद्ध (हमेशा ज्ञान से जाग्रत) और नित्य (हमेशा रहने वाली / अमर) है।
            वह निरंजन (जिस पर माया का कोई भी दाग या असर न हो) और प्रशान्त (अत्यंत शांत और स्थिर) होकर प्रकाशित होती है।
            यह श्लोक आत्म-साक्षात्कार (Self-realization) के बाद आत्मा की असली चमक और उसके गुणों का वर्णन करता है।
            आत्मा को रोशन करने के लिए किसी सूरज या बल्ब की जरूरत नहीं है; वह खुद ही ब्रह्मांड का सबसे बड़ा प्रकाश (स्वयंज्योति) है।
            वह हमेशा 'बुद्ध' (Awake) है, यानी वह अज्ञान की नींद में कभी नहीं सोती।
            दुनिया की हर चीज़ मिट जाती है, पर यह चेतना 'नित्य' है; यह करोड़ों साल पहले भी थी और हमेशा रहेगी।
            'प्रशान्त' का अर्थ है वह शांति जिसे दुनिया का कोई भी भयंकर तूफान या दुख कभी तोड़ नहीं सकता।
            जब योगी के मन का शोर (विचार) खत्म हो जाता है, तो केवल यही शुद्ध और शांत प्रकाश पीछे रह जाता है।
            यही हमारा असली और वास्तविक चेहरा है जिसे हमने वासनाओं और अहंकार के कीचड़ में छुपा रखा था।
        """.trimIndent(),
        english = """
            In that ultimate, supreme state (Moksha), that Soul begins to shine brilliantly entirely by Itself (Svayamjyotih / without any external light).
            That Soul is absolutely pure (devoid of any filth), Buddha (eternally awake with wisdom), and Nitya (eternal / always existing / immortal).
            It shines radiantly as Niranjana (completely untouched and unstained by Maya) and Prashanta (exceedingly tranquil, deeply peaceful, and still).
            This magnificent verse describes the true, original brilliance and exact qualities of the Soul immediately after direct Self-realization.
            The Soul absolutely does not need any sun or lightbulb to illuminate it; It is itself the greatest, supreme light of the cosmos (Self-luminous).
            It is perpetually 'Buddha' (Awake), meaning it absolutely never falls asleep in the dark, blinding slumber of ignorance.
            Everything in the world perishes, but this Consciousness is 'Nitya'; it existed millions of years ago and will flawlessly remain forever.
            'Prashanta' means that absolute, profound peace which no terrifying storm or sorrow of the world can ever possibly break.
            When the loud, chaotic noise (thoughts) of the Yogi's mind ends completely, only this pure, exceptionally peaceful light remains behind.
            This is our absolute, true, and original face which we had foolishly hidden deep in the filthy mud of lusts and ego.
        """.trimIndent()
    ),
    HamsaShloka(
        id = 21,
        sanskrit = "तदहमस्मीति वेदान्तवाक्यैर्विजानन्ति । इति हंसोपनिषत् समाप्ता ॥ २१ ॥",
        hindi = """
            महान ज्ञानी और योगी वेदान्त के महावाक्यों (जैसे 'तत्त्वमसि' - तुम वही हो) के द्वारा इस परम सत्य को प्रत्यक्ष जान लेते हैं।
            वे इस बात का साक्षात् अनुभव कर लेते हैं कि "निश्चित रूप से मैं ही वह परम ब्रह्म हूँ" (तदहमस्मि)।
            (उपसंहार): इस प्रकार यह अत्यंत पवित्र और रहस्यमयी 'हंस उपनिषद' यहाँ पूर्ण रूप से समाप्त (समाप्ता) होता है।
            वेदान्त (उपनिषदों) का अंतिम उद्देश्य हमें कोई नई चीज़ देना नहीं है, बल्कि हमें हमारी अपनी ही भूली हुई सच्चाई याद दिलाना है।
            जब तक हम खुद को शरीर मानते हैं, हम एक छोटे से पिंजरे में कैद पक्षी की तरह दुखी रहते हैं।
            पर जब 'हंस' (श्वास) के ध्यान से वह पिंजरा टूटता है, तो जीव जान जाता है कि वह खुद ही वह अनंत आकाश (ब्रह्म) है।
            "तदहमस्मि" (मैं वह हूँ) केवल बोलने का मंत्र नहीं है; यह वह महा-विस्फोट है जो इंसान के सारे डरों (विशेषकर मौत) को खत्म कर देता है।
            हंस उपनिषद ने हमें अपनी ही सांसों के द्वारा ईश्वर तक पहुँचने का सबसे सरल और सीधा रास्ता (नाद योग) सिखाया है।
            ॐ शांतिः शांतिः शांतिः—हमारे जीवन में उस परब्रह्म की असीम और अखंड शांति हमेशा के लिए स्थापित हो।
            भगवान हमारी इस आध्यात्मिक यात्रा को सफल बनाएं।
        """.trimIndent(),
        english = """
            Great realized sages and Yogis directly know and experience this Supreme Truth strictly through the Mahavakyas (Great Sayings) of Vedanta (like 'Tat Tvam Asi' - Thou art That).
            They attain the direct, living realization and absolute conviction that "I am undoubtedly that exact Supreme Brahman" (Tadaham asmi).
            (Conclusion): Thus, this exceedingly sacred, profound, and highly mystical 'Hamsa Upanishad' is completely and joyfully concluded (Samapta) here.
            The ultimate, absolute purpose of Vedanta (Upanishads) is not to give us anything new, but to simply remind us of our own forgotten Truth.
            As long as we consider ourselves the physical body, we remain deeply miserable like a pathetic bird trapped in a tiny, iron cage.
            But when that cage shatters through meditation on the 'Hamsa' (breath), the creature instantly realizes that it is the infinite sky (Brahman) itself.
            "Tadaham asmi" (I am That) is not a mere mantra to be chanted; it is the grand explosion that annihilates all human fears (especially death).
            The Hamsa Upanishad has flawlessly taught us the simplest, most direct path (Nada Yoga) to reach God using our very own breath.
            OM Peace, Peace, Peace—May the boundless, unbroken, and supreme peace of that Brahman be permanently established in our lives.
            May the Supreme Lord crown this magnificent spiritual journey of ours with absolute success.
        """.trimIndent()
    )
)