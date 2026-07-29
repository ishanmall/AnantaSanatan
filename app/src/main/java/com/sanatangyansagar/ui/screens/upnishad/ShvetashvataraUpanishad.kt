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

// 1. Data Model
data class ShvetashvataraShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShvetashvataraUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 113
                if (shlokaNumber != null && shlokaNumber in 1..113) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-113)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        // Shloka List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(shvetashvataraShlokasList) { _, shloka ->
                ShvetashvataraShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun ShvetashvataraShlokaCard(shloka: ShvetashvataraShloka) {
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

// 4. Data List (Exactly 113 Shlokas)
val shvetashvataraShlokasList: List<ShvetashvataraShloka> = listOf(
    ShvetashvataraShloka(
        id = 1,
        sanskrit = "हरिः ॐ ॥ ब्रह्मवादिनो वदन्ति । किं कारणं ब्रह्म कुतः स्म जाता जीवाम केन क्व च सम्प्रतिष्ठाः । अधिष्ठिताः केन सुखेतरेषु वर्तामहे ब्रह्मविदो व्यवस्थाम् ॥ १ ॥",
        hindi = """
            ब्रह्म को जानने की इच्छा रखने वाले विद्वान आपस में चर्चा करते हैं और यह मौलिक प्रश्न पूछते हैं।
            क्या यह संपूर्ण जगत ब्रह्म के कारण उत्पन्न हुआ है? हम सभी प्राणी कहाँ से पैदा हुए हैं?
            हम किसके सहारे जीवित हैं और प्रलय के समय अंततः हम कहाँ जाकर स्थित होते हैं?
            हे ब्रह्मवेत्ताओं! वह कौन सी शक्ति है जिसके नियंत्रण में रहकर हम सुख और दुख को भोगते हैं?
            हम किस नियम या व्यवस्था के अधीन इस जीवन के चक्र में बंधे हुए अपना समय बिता रहे हैं?
            यह श्वेताश्वतर उपनिषद का अत्यंत ही दार्शनिक और वैचारिक आरंभ है।
            मनुष्य जब तक यह नहीं पूछता कि 'मैं कौन हूँ और कहाँ से आया हूँ', तब तक वह अज्ञानी है।
            सुख और दुख जीवन के दो पहिए हैं, पर इन्हें घुमाने वाला असली ड्राइवर कौन है?
            इस एक श्लोक में संपूर्ण सृष्टि, जीवन, मृत्यु और कर्म के सबसे बड़े रहस्य छुपे हुए हैं।
            यह सामूहिक चिंतन की उस प्राचीन पद्धति को दर्शाता है जहाँ ऋषि मिलकर सत्य की खोज करते थे।
        """.trimIndent(),
        english = """
            The seekers of Brahman discuss among themselves and ask these fundamental philosophical questions.
            Is Brahman the ultimate cause of this universe? From where have all of us been born?
            By whose power do we live, and where do we ultimately rest at the time of dissolution?
            O knowers of Brahman! Under whose control do we experience our various joys and sorrows?
            Under what cosmic law or arrangement are we bound to live our lives in this world?
            This is the profoundly philosophical and contemplative beginning of the Shvetashvatara Upanishad.
            Until a person asks 'Who am I and where did I come from?', he remains in sheer ignorance.
            Joy and sorrow are the two wheels of life, but who is the actual driver turning them?
            In this single verse lie the greatest mysteries of creation, life, death, and karma.
            It beautifully illustrates the ancient tradition of collective inquiry where sages sought truth together.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 2,
        sanskrit = "कालः स्वभावो नियतिर्यदृच्छा भूतानि योनिः पुरुष इति चिन्त्या । संयोग एषां न त्वात्मभावादात्माप्यनीशः सुखदुःखहेतोः ॥ २ ॥",
        hindi = """
            क्या काल (समय), स्वभाव (प्रकृति), नियति (भाग्य), यदृच्छा (संयोग) या पंचभूत इस जगत के कारण हैं?
            क्या जीवात्मा (पुरुष) को इस संपूर्ण सृष्टि का मूल कारण माना जाना चाहिए? इस पर विचार करना चाहिए।
            परंतु इनमें से कोई भी अकेला या इनका समूह भी सृष्टि का परम कारण नहीं हो सकता है।
            क्योंकि ये सभी जड़ हैं और आत्मा के भोग के लिए बनाए गए हैं, ये स्वयं स्वतंत्र नहीं हैं।
            जीवात्मा (पुरुष) भी स्वतंत्र नहीं है, क्योंकि वह स्वयं सुख और दुख के कर्म-बंधनों में बँधा हुआ है।
            जब आत्मा खुद कर्मों के अधीन है, तो वह इस इतने विशाल ब्रह्मांड का रचयिता कैसे हो सकता है?
            समय केवल बदलता है, स्वभाव अंधा है, और संयोग का कोई निश्चित वैज्ञानिक नियम नहीं होता।
            यह श्लोक भौतिक विज्ञान और नास्तिक दर्शनों (Materialism) की सीमाओं को पूरी तरह से खारिज करता है।
            यदि दुनिया इतनी व्यवस्थित है, तो इसके पीछे कोई अत्यंत चेतन और स्वतंत्र शक्ति होनी ही चाहिए।
            इसलिए ऋषियों ने इन भौतिक कारणों को नकार कर किसी उच्च सत्य की तलाश को आगे बढ़ाया।
        """.trimIndent(),
        english = """
            Should time, inherent nature, destiny, chance, or the material elements be considered the cause?
            Or should the individual soul (Purusha) be regarded as the root cause? This must be pondered.
            But none of these alone, nor their combination, can be the ultimate cause of creation.
            Because they are inert and exist merely for the experience of the soul; they are not independent.
            Even the individual soul is not independent, as it is bound by the chains of joy and sorrow.
            When the soul itself is subject to karma, how can it be the creator of such a vast cosmos?
            Time merely changes things, nature is blind, and chance lacks any definite scientific law.
            This verse completely rejects the limitations of physical sciences and materialistic philosophies.
            If the universe is so orderly, there must be an extremely conscious and independent power behind it.
            Therefore, rejecting these material causes, the sages advanced their search for a higher Truth.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 3,
        sanskrit = "ते ध्यानयोगानुगता अपश्यन् देवात्मशक्तिं स्वगुणैर्निगूढाम् । यः कारणानि निखिलानि तानि कालान्मयुक्तान्यधितिष्ठत्येकः ॥ ३ ॥",
        hindi = """
            बाहरी कारणों को नकारने के बाद, उन ऋषियों ने ध्यान और योग के मार्ग का आश्रय लिया।
            गहरी समाधि में उन्होंने उस परमेश्वर की उस आत्म-शक्ति (देवात्मशक्ति) का साक्षात् दर्शन किया।
            वह दिव्य शक्ति जो अपने ही त्रिगुणों (सत्त्व, रज, तम) के आवरण में गहराई से छिपी हुई थी।
            वही एक अद्वितीय परमेश्वर है जो काल (समय) से लेकर जीवात्मा तक के सभी कारणों पर शासन करता है।
            ईश्वर को तर्क या बहस से नहीं जाना जा सकता; उसे जानने का एकमात्र उपाय ध्यान (Meditation) है।
            ईश्वर की शक्ति (माया/प्रकृति) उससे अलग नहीं है, जैसे अग्नि से उसकी गर्मी अलग नहीं होती।
            गुणों का आवरण ही वह पर्दा है जो हमें उस परम शक्ति को सीधे देखने से पूरी तरह रोकता है।
            तत्वों, समय और भाग्य की अपनी कोई ताकत नहीं है; वे सब उसी परमेश्वर के रिमोट कंट्रोल से चलते हैं।
            यह श्लोक वेदान्त के उस मूल सिद्धांत को बताता है कि भगवान ही सृष्टि का निमित्त और उपादान कारण है।
            ध्यान की सफलता ही वह कुंजी है जिससे सृष्टि के सभी गहरे रहस्य अपने आप खुल जाते हैं।
        """.trimIndent(),
        english = """
            Having rejected external causes, those sages resorted to the path of meditation and yoga.
            In deep Samadhi, they directly beheld the self-luminous power of the Supreme Lord (Devatma-Shakti).
            That divine power which remained deeply hidden beneath the covering of its own three Gunas (modes).
            He is that one non-dual Lord who rules over all the causes, from Time right up to the individual soul.
            God cannot be known through logic or debate; the only way to realize Him is through meditation.
            God's power (Maya/Nature) is not separate from Him, just as heat is not separate from fire.
            The covering of the Gunas is the veil that completely prevents us from seeing that Supreme Power directly.
            Elements, time, and destiny have no power of their own; they operate under His remote control.
            This verse states the core Vedantic principle that God is both the material and efficient cause of creation.
            The success of meditation is the key that spontaneously unlocks all the deep mysteries of the universe.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 4,
        sanskrit = "तमेकनेमिं त्रिवृतं षोडशान्तं शतार्धारं विंशतिप्रत्यराभिः । अष्टकैः षड्भिर्विश्वरूपैकपाशं त्रिमार्गभेदं द्विनिमित्तैकमोहम् ॥ ४ ॥",
        hindi = """
            ऋषियों ने उस ब्रह्मांड को एक विशाल चक्र (पहिये) के रूप में देखा जिसकी केवल एक नेमि (परिधि/प्रकृति) है।
            वह चक्र तीन गुणों (सत्त्व, रज, तम) से घिरा है और उसमें सोलह विकार (अंत) मौजूद हैं।
            उस चक्र में पचास अरेज (Aras/Spokes) हैं, जो बीस उप-अरों (प्रत्यर) के साथ मजबूती से जुड़े हुए हैं।
            यह चक्र छह प्रकार के अष्टकों (आठ-आठ के समूहों) से बना है और विश्वरूप रूपी एक पाश से बँधा है।
            इस चक्र में तीन अलग-अलग मार्ग (धर्म, अधर्म, ज्ञान) हैं और मोह का एक ही कारण (अज्ञान) है।
            यह अज्ञान पाप और पुण्य (द्विनिमित्त) नाम के दो फलों को उत्पन्न करके जीव को फँसाता है।
            यह श्लोक सृष्टि को एक घूमते हुए पहिये (ब्रह्मचक्र) के रूप में बहुत ही वैज्ञानिक रूपक से समझाता है।
            पहिया कभी रुकता नहीं है, यह निरंतर जन्म और मृत्यु के रूप में गोल-गोल घूमता रहता है।
            इस पहिये में फँसा हुआ व्यक्ति कभी सुखी नहीं हो सकता, क्योंकि इसका स्वभाव ही परिवर्तनशील है।
            योग का उद्देश्य इस पहिये के केंद्र (भगवान) में पहुँचना है जहाँ कोई गति या बेचैनी नहीं होती।
        """.trimIndent(),
        english = """
            The sages saw the universe as a vast wheel having only one rim (circumference/Prakriti).
            That wheel is enveloped by the three Gunas (modes) and contains sixteen modifications (ends).
            The wheel has fifty spokes, which are firmly connected by twenty counter-spokes.
            It consists of six sets of eights (Ashtakas) and is bound by a single rope of universal illusion.
            In this wheel, there are three distinct paths (virtue, vice, knowledge) and one cause of delusion (ignorance).
            This ignorance traps the soul by generating two types of fruits: merit and demerit (twin causes).
            This verse explains creation through a very scientific metaphor of a revolving wheel (Brahmachakra).
            The wheel never stops; it continuously rotates in the form of endless birth and death.
            A person trapped in this wheel can never be truly happy, as its very nature is ever-changing.
            The goal of Yoga is to reach the exact center of this wheel (God) where there is no motion or unrest.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 5,
        sanskrit = "पञ्चस्रोतोम्बुं पञ्चयोन्युग्रवक्रां पञ्चप्राणोर्मिं पञ्चबुद्ध्यादिमूलाम् । पञ्चावर्तां पञ्चदुःखौघवेगां पञ्चाशद्भेदां पञ्चपर्वामधीमः ॥ ५ ॥",
        hindi = """
            हम इस जगत को एक नदी के रूप में भी देखते हैं, जिसमें पाँच ज्ञानेंद्रियों रूपी जल की धाराएँ बह रही हैं।
            इसके पाँच उद्गम (पंचभूत) हैं, जो अत्यंत भयंकर और टेढ़े-मेढ़े हैं; पाँच प्राण ही इस नदी की लहरें हैं।
            पाँच कर्मेंद्रियां ही इसका मूल हैं, और पाँच प्रकार के विषय (शब्द, स्पर्श आदि) इसके भंवर (भंवरजाल) हैं।
            इसमें पाँच प्रकार के दुखों (गर्भ, जन्म, बुढ़ापा, बीमारी, मृत्यु) का अत्यंत तीव्र वेग बह रहा है।
            यह नदी पचास प्रकार के भेदों (मन की वृत्तियों) वाली है और इसके पाँच पर्व (अविद्या के प्रकार) हैं।
            ऋषियों ने इस श्लोक में संसार को एक खतरनाक और तेज बहने वाली नदी का सुंदर रूपक दिया है।
            जैसे नदी में गिरने वाला तिनका भंवरों में फँस जाता है, वैसे ही जीव विषयों के जाल में फँसता है।
            इंद्रियों की धाराएँ हमें लगातार बाहर की ओर बहा ले जाती हैं, जिससे हम सत्य से दूर हो जाते हैं।
            दुखों का वेग इतना तेज है कि बिना आध्यात्मिक ज्ञान रूपी नाव के इससे पार पाना असंभव है।
            इस भवसागर (नदी) को पार करने का एकमात्र उपाय अपने भीतर बैठे उस शांत किनारे (ब्रह्म) को खोजना है।
        """.trimIndent(),
        english = """
            We also perceive this universe as a river, in which the five senses of perception flow as water streams.
            Its five sources are the five elements, which are fierce and crooked; the five Pranas are its waves.
            The five organs of action are its root, and the five sense objects (sound, touch, etc.) are its whirlpools.
            Within it flows the extremely rapid current of five types of miseries (womb, birth, old age, disease, death).
            This river possesses fifty varieties (modifications of mind) and has five sections (types of ignorance).
            In this verse, the sages provide a beautiful metaphor of the world as a dangerous, fast-flowing river.
            Just as a twig falling into a river is caught in whirlpools, the soul gets trapped in the web of objects.
            The currents of the senses constantly sweep us outward, taking us farther away from the ultimate Truth.
            The current of sorrow is so rapid that crossing it is impossible without the boat of spiritual wisdom.
            The only way to cross this river of existence is to find that peaceful shore (Brahman) within oneself.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 6,
        sanskrit = "सर्वाजीवे सर्वसंस्थे बृहन्ते अस्मिन् हंसो भ्राम्यते ब्रह्मचक्रे । पृथगात्मानं प्रेरितारं च मत्वा जुष्टस्ततस्तेनामृतत्वमेति ॥ ६ ॥",
        hindi = """
            इस महान और विशाल ब्रह्मचक्र (संसार रूपी पहिये) में, जो सबका जीवनदाता और सबका आश्रय है।
            जीवात्मा रूपी 'हंस' अपने कर्मों के अनुसार बार-बार जन्म और मृत्यु के चक्र में भटकता रहता है।
            वह तब तक भटकता है जब तक वह स्वयं को और उस परमात्मा (प्रेरित करने वाले) को अलग-अलग मानता है।
            किंतु जब वह ज्ञान प्राप्त करके उस परमात्मा के साथ अपनी पूरी एकता को साक्षात् अनुभव कर लेता है।
            तब वह उस ईश्वर की कृपा (जुष्टः) को प्राप्त करके हमेशा के लिए अमृतत्व (मोक्ष) को प्राप्त हो जाता है।
            'हंस' का अर्थ है शुद्ध आत्मा; परंतु अज्ञान के कारण वह इस चक्र में एक कैदी की तरह घूम रहा है।
            द्वैत (मुझमें और भगवान में अंतर है) ही हमारे सभी भटकावों और दुखों का असली कारण है।
            एकता (मैं ही वह हूँ) का बोध होते ही यह घूमने वाला पहिया साधक के लिए तुरंत रुक जाता है।
            ईश्वर कोई तानाशाह नहीं है, वह तो कृपा का सागर है; बस हमें उसकी ओर मुड़कर देखना है।
            यह श्लोक अद्वैत दर्शन का सार है—अलगाव ही बंधन है, और एकीकरण (Oneness) ही सच्ची मुक्ति है।
        """.trimIndent(),
        english = """
            In this great and vast wheel of Brahman, which is the life-giver and the ultimate refuge of all.
            The 'Swan' in the form of the individual soul wanders endlessly in the cycle of birth and death.
            He wanders as long as he considers himself and the Supreme Lord (the impeller) as entirely separate.
            But when, through wisdom, he directly experiences his absolute unity with that Supreme Lord.
            Then, blessed by the grace (Jushtah) of God, he attains eternal Immortality (Moksha) forever.
            'Hamsa' (Swan) signifies the pure soul; but due to ignorance, it spins like a prisoner in this wheel.
            Duality (the thought that God and I are different) is the real root cause of all our wanderings and grief.
            The moment the realization of unity (I am That) dawns, this spinning wheel stops instantly for the seeker.
            God is not a dictator; He is an ocean of grace; we simply need to turn around and look at Him.
            This verse is the essence of Advaita philosophy—separation is bondage, and oneness is true liberation.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 7,
        sanskrit = "उद्गीतमेतत् परमं तु ब्रह्म तस्मिंस्त्रयं सुप्रतिष्ठाक्षरं च । अत्रान्तरं ब्रह्मविदो विदित्वा लीना ब्रह्मणि तत्परा योनिमुक्ताः ॥ ७ ॥",
        hindi = """
            उपनिषदों में इसी तत्व को 'परम ब्रह्म' के रूप में बहुत स्पष्टता से गाया (उद्गीत) और बताया गया है।
            उसी एक परब्रह्म के भीतर यह त्रयी (भोक्ता, भोग्य और प्रेरक) पूरी तरह से आश्रित और स्थित है।
            वह ब्रह्म ही इस संपूर्ण जगत का मुख्य आधार है और वह स्वयं अक्षर (कभी न नष्ट होने वाला) है।
            ब्रह्म को जानने वाले विद्वान इस शरीर के भीतर ही उस छिपे हुए परम सत्य को भलीभांति जान लेते हैं।
            सत्य को जानकर वे उसी ब्रह्म में लीन हो जाते हैं और जन्म लेने की प्रक्रिया (योनि) से मुक्त हो जाते हैं।
            यह दुनिया कोई भ्रम या शून्य नहीं है, यह तो साक्षात् उस परब्रह्म की ही एक जीवंत अभिव्यक्ति है।
            जीवात्मा (भोक्ता), दुनिया (भोग्य) और ईश्वर (प्रेरक)—ये तीनों अंततः उस एक ही सत्ता के तीन रूप हैं।
            बाहर भटकने से सत्य नहीं मिलता; उसे 'अत्रान्तरं' यानी अपने ही हृदय के भीतर खोजना पड़ता है।
            ज्ञान का फल केवल जानकारी नहीं है, बल्कि वह ब्रह्मांड की ऊर्जा के साथ पूरी तरह घुल-मिल जाना है।
            जो ब्रह्म में लीन हो गया, उसे किसी माता के गर्भ में दोबारा कभी नहीं आना पड़ता, वह मुक्त है।
        """.trimIndent(),
        english = """
            This very principle has been clearly sung and declared as the 'Supreme Brahman' in the Upanishads.
            Within that single Supreme Brahman, this triad (the experiencer, the experienced, the impeller) rests entirely.
            That Brahman alone is the ultimate foundation of this world, and He Himself is Imperishable (Akshara).
            The knowers of Brahman fully realize that hidden Supreme Truth right within this very physical body.
            Having known the Truth, they merge completely into Brahman and are freed from the cycle of birth (womb).
            This world is not an empty illusion; it is the direct and vibrant manifestation of that Supreme Brahman.
            The soul (experiencer), the world (experienced), and God (impeller)—all three are forms of that one Reality.
            Truth is not found wandering outside; it must be discovered 'Atrantaram', meaning deep within one's own heart.
            The fruit of knowledge is not mere information, but an absolute blending with the cosmic energy.
            He who has merged into Brahman never has to enter a mother's womb again; he is completely liberated.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 8,
        sanskrit = "संयुक्तमेतत् क्षरमक्षरं च व्यक्ताव्यक्तं भरते विश्वमीशः । अनीशश्चात्मा बध्यते भोक्तृभावाज्ज्ञात्वा देवं मुच्यते सर्वपापैः ॥ ८ ॥",
        hindi = """
            यह पूरा संसार दो चीजों का संगम है: क्षर (नष्ट होने वाला पदार्थ) और अक्षर (अविनाशी जीवात्मा)।
            परमेश्वर इन दोनों (व्यक्त और अव्यक्त जगत) को एक साथ धारण करता है और उनका पोषण करता है।
            परंतु जीवात्मा (अनीश/असमर्थ) अपने आप को भोक्ता मान लेने के कारण संसार के बंधनों में बँध जाता है।
            वह सोचता है कि 'मैं सुख भोग रहा हूँ' या 'मैं दुख सह रहा हूँ', और इसी भ्रम में वह कैदी बन जाता है।
            किंतु जब वह उस परम प्रकाशमय 'देव' (परमात्मा) को जान लेता है, तो वह सभी बेड़ियों से मुक्त हो जाता है।
            ईश्वर सब कुछ धारण करके भी स्वतंत्र है, क्योंकि वह उसमें आसक्त (Attached) नहीं होता है।
            जीवात्मा भी स्वरूप से ईश्वर ही है, पर आसक्ति के कारण वह अपनी शक्ति भूलकर लाचार बन गया है।
            बंधनों को तोड़ने के लिए किसी बाहरी हथियार की नहीं, बल्कि 'ज्ञात्वा' (जानने) की आवश्यकता है।
            जैसे अँधेरे में रस्सी साँप लगती है और ज्ञान होते ही भय मिटता है, वैसे ही आत्मा का अज्ञान मिटता है।
            यह श्लोक ईश्वर की महानता और जीव की लाचारी के बीच का मनोवैज्ञानिक अंतर स्पष्ट करता है।
        """.trimIndent(),
        english = """
            This entire universe is a combination of two things: the perishable (matter) and the imperishable (soul).
            The Supreme Lord simultaneously supports and nourishes both of these (the manifest and the unmanifest).
            But the individual soul (helpless) gets bound by worldly chains because it assumes the role of an enjoyer.
            It thinks 'I am experiencing joy' or 'I am suffering', and through this illusion, it becomes a prisoner.
            However, when it truly realizes that luminous 'Deva' (Supreme Lord), it is freed from all fetters.
            God supports everything yet remains completely independent because He is not attached to anything.
            The soul is inherently God too, but due to attachment, it has forgotten its power and become helpless.
            To break the chains, one doesn't need external weapons; only 'Jnatva' (the act of knowing) is required.
            Just as a rope appears as a snake in darkness and light removes the fear, so is the soul's ignorance destroyed.
            This verse clearly outlines the psychological difference between God's greatness and the soul's helplessness.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 9,
        sanskrit = "ज्ञाज्ञौ द्वावजावीशानीशावजा ह्येका भोक्तृभोग्यार्थयुक्ता । अनन्तश्चात्मा विश्वरूपो ह्यकर्ता त्रयं यदा विन्दते ब्रह्ममेतत् ॥ ९ ॥",
        hindi = """
            सृष्टि में दो अजन्मे (अनादि) तत्व हैं: एक ज्ञानी (ईश्वर) है और दूसरा अज्ञानी (जीवात्मा) है।
            एक सर्वसमर्थ (ईश) है और दूसरा असमर्थ (अनीश) है। इसके अलावा एक तीसरी अजन्मी शक्ति भी है।
            वह शक्ति 'प्रकृति' है, जो भोक्ता (जीव) और भोग्य (संसार) के बीच संबंध बनाने में लगी हुई है।
            किंतु जो परम आत्मा है, वह अनंत है, विश्वरूप है और वास्तव में किसी भी कर्म का कर्ता नहीं है।
            जब साधक इन तीनों (ईश्वर, जीव, प्रकृति) को एक ही परब्रह्म के रूप में जान लेता है, तब वह मुक्त होता है।
            उपनिषद यहाँ स्पष्ट करता है कि संसार के यह तीनों अंग किसी एक दिन पैदा नहीं हुए, ये हमेशा से हैं।
            ईश्वर जानता है कि वह सब कुछ है, जबकि जीव भूल गया है कि वह कौन है; यही दोनों में अंतर है।
            प्रकृति वह रंगमंच है जहाँ जीव अपने कर्मों का नाटक खेलता है और ईश्वर उसे चुपचाप देखता है।
            अकर्ता होने का अर्थ है कि परमात्मा किसी भी सांसारिक इच्छा से प्रेरित होकर काम नहीं करता है।
            मुक्ति का अर्थ इस त्रिकोणीय खेल को समझकर उस असीम आधार (ब्रह्म) के साथ जुड़ जाना है।
        """.trimIndent(),
        english = """
            There are two unborn (beginningless) entities in creation: the knowing (God) and the ignorant (soul).
            One is all-powerful (Isha) and the other is helpless (Anisha). Besides them, there is a third unborn power.
            That power is 'Prakriti' (Nature), engaged in creating a connection between the enjoyer and the enjoyed.
            But the Supreme Self is infinite, possesses the universal form, and is truly not the doer of any action.
            When a seeker realizes these three (God, soul, nature) as the single Supreme Brahman, he is liberated.
            The Upanishad clarifies here that these three aspects of the world weren't born one day; they are eternal.
            God knows He is everything, whereas the soul has forgotten who it is; this is the only difference.
            Nature is the stage where the soul plays the drama of its karma while God watches silently.
            Being a non-doer means the Supreme Lord does not act out of any worldly desire or motivation.
            Liberation means understanding this triangular game and uniting with that limitless foundation (Brahman).
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 10,
        sanskrit = "क्षरं प्रधानममृताक्षरं हरः क्षरात्मानौ ईशते देव एकः । तस्याभिध्यानाद्योजनात्तत्त्वभावाद् भूयश्चान्ते विश्वमायानिवृत्तिः ॥ १० ॥",
        hindi = """
            जो प्रधान (प्रकृति या पदार्थ) है, वह क्षर (नष्ट और परिवर्तित होने वाला) है।
            किंतु जो 'हर' (अज्ञान को हरने वाला शिव/परमात्मा) है, वह पूर्ण रूप से अमृत और अक्षर है।
            वह एक ही देव (परमात्मा) उस क्षर (प्रकृति) और आत्मा (जीव) दोनों पर अपना शासन करता है।
            उस परमात्मा के निरंतर ध्यान (अभिध्यान) से और उसके साथ गहरे जुड़ाव (योग/योजना) से।
            तथा उसके असली तत्त्व भाव (मैं ही वह हूँ) को जान लेने से, अंत में विश्व की सभी माया निवृत्त हो जाती है।
            प्रकृति का स्वभाव ही बदलना है, इसलिए भौतिक चीजों में स्थायी सुख ढूँढना एक बड़ी मूर्खता है।
            ईश्वर को 'हर' कहा गया है, क्योंकि वह अपनी कृपा से भक्त के सभी दुखों और अज्ञान को हर लेता है।
            ध्यान केवल आँख बंद करना नहीं है, बल्कि ईश्वर के साथ अपनी चेतना को पूरी तरह से जोड़ देना है।
            जब हम सत्य को समझ लेते हैं, तो माया (ब्रह्मांडीय भ्रम) का पर्दा हमारी आँखों से हमेशा के लिए हट जाता है।
            माया के निवृत्त होने का अर्थ है संसार का खत्म होना नहीं, बल्कि संसार के प्रति हमारे भ्रम का खत्म होना।
        """.trimIndent(),
        english = """
            That which is Pradhana (Nature or matter) is perishable and constantly changing (Kshara).
            But 'Hara' (the Supreme Lord/Shiva who destroys ignorance) is completely immortal and imperishable.
            That one single Deity (Supreme Lord) rules over both the perishable (Nature) and the soul (Jiva).
            By constant and deep meditation (Abhidhyana) upon Him, and by a deep connection (Yoga) with Him.
            And by realizing His true essence (I am That), finally, all universal illusion (Maya) completely ceases.
            The very nature of Prakriti is to change; therefore, seeking permanent joy in physical things is foolish.
            God is called 'Hara' because, out of His grace, He takes away all the sorrows and ignorance of the devotee.
            Meditation is not just closing eyes, but fully connecting one's consciousness with the Divine.
            When we understand the Truth, the veil of Maya (cosmic illusion) is lifted from our eyes forever.
            The cessation of Maya does not mean the end of the world, but the end of our delusion regarding the world.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 11,
        sanskrit = "ज्ञात्वा देवं सर्वपाशापहानिः क्षीणैः क्लेशैर्जन्ममृत्युप्रहाणिः । तस्याभिध्यानात्तृतीयं देहभेदे विश्वैश्वर्यं केवल आप्तकामः ॥ ११ ॥",
        hindi = """
            उस परम देव (ईश्वर) को यथार्थ रूप में जान लेने पर जीव के सभी पाश (बंधन) कट जाते हैं।
            अविद्या आदि सभी क्लेशों के पूरी तरह क्षीण हो जाने पर जन्म और मृत्यु का चक्र हमेशा के लिए छूट जाता है।
            उस परमात्मा के निरंतर ध्यान से, इस भौतिक शरीर के छूटने (मृत्यु) के बाद एक तीसरी अवस्था प्राप्त होती है।
            वह अवस्था 'विश्वैश्वर्य' (ईश्वरीय ऐश्वर्य) की है, जहाँ वह केवल (पूर्ण रूप से अद्वैत) हो जाता है।
            और वह आप्तकाम हो जाता है, जिसका अर्थ है कि उसकी सभी इच्छाएं हमेशा के लिए पूरी और शांत हो जाती हैं।
            बंधन लोहे की जंजीरें नहीं हैं; क्रोध, लोभ और अज्ञान ही असली बंधन हैं जो ज्ञान से कटते हैं।
            क्लेश ही हमारे बार-बार जन्म लेने का असली कारण हैं; जब वे जल जाते हैं, तो वापसी नहीं होती।
            यह श्लोक योग और वेदान्त का सर्वोच्च परिणाम है—मरने के बाद ईश्वर के पूर्ण ऐश्वर्य को पा लेना।
            केवल का अर्थ है 'कैवल्य' यानी अब वह किसी भी द्वैत या दूसरे तत्व से पूरी तरह स्वतंत्र है।
            आप्तकाम वह है जिसे अब ब्रह्मांड में कुछ भी पाना शेष नहीं रहा, क्योंकि वह स्वयं ब्रह्मांड हो गया है।
        """.trimIndent(),
        english = """
            By truly knowing that Supreme Deity, all the fetters (bonds) of the soul drop away completely.
            With the total destruction of afflictions like ignorance, the cycle of birth and death ceases forever.
            Through constant meditation on Him, after the shedding of this physical body, a third state is attained.
            That state is of 'universal lordship', where he becomes Kevala (absolutely non-dual and isolated).
            And he becomes 'Aptakama', meaning all his desires are completely fulfilled and permanently stilled.
            Bonds are not iron chains; anger, greed, and ignorance are the real bonds cut by wisdom.
            Afflictions (Kleshas) are the real reason for rebirth; when they are burnt, there is no return.
            This verse presents the highest result of Yoga and Vedanta—attaining God's full glory after death.
            'Kevala' means Kaivalya, indicating he is now completely independent of any duality or second element.
            An Aptakama is one who has nothing left to attain in the universe, for he has become the universe itself.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 12,
        sanskrit = "एतज्ज्ञेयं नित्यमेवात्मसंस्थं नातः परं वेदितव्यं हि किञ्चित् । भोक्ता भोग्यं प्रेरितारं च मत्वा सर्वं प्रोक्तं त्रिविधं ब्रह्ममेतत् ॥ १२ ॥",
        hindi = """
            यह परम सत्य (ब्रह्म) हमेशा अपनी ही आत्मा में स्थित है; इसे ही निश्चित रूप से जानना चाहिए।
            इसे जान लेने के बाद इस संसार में जानने योग्य और कुछ भी (किञ्चित्) शेष नहीं रह जाता है।
            भोक्ता (जीवात्मा), भोग्य (संसार) और इन दोनों को प्रेरित करने वाला ईश्वर (प्रेरितारं)—इन तीनों को समझो।
            जब साधक इन तीनों को एक साथ समझ लेता है, तो वह जान लेता है कि यह सब कुछ वह त्रिविध ब्रह्म ही है।
            ईश्वर को खोजने के लिए हिमालय या किसी दूर आकाश में जाने की कोई आवश्यकता नहीं है; वह भीतर ही है।
            जब हम गणित या विज्ञान पढ़ते हैं, तो हमारा ज्ञान अधूरा रहता है, पर आत्मज्ञान पूर्ण और अंतिम है।
            दुनिया की तीन सबसे बड़ी चीजें—मैं, यह दुनिया और भगवान—अलग-अलग नहीं हैं, वे एक ही हैं।
            जैसे सोने से बने हुए कंगन, अंगूठी और हार रूप में अलग हैं पर तत्व में केवल सोना ही हैं।
            उसी प्रकार यह सारी विविधता केवल एक ही ब्रह्म की सुंदर और जादुई अभिव्यक्ति (Expression) है।
            यह श्लोक वेदान्त का सार है जो साधक की दृष्टि को द्वैत से उठाकर पूर्ण अद्वैत पर टिका देता है।
        """.trimIndent(),
        english = """
            This Supreme Truth (Brahman) is eternally situated in one's own soul; this alone must be known.
            After knowing this, there remains absolutely nothing else left to be known in this world.
            Understand the enjoyer (soul), the enjoyed (world), and the Impeller (God) who directs them both.
            When the seeker understands these three together, he realizes that all this is that threefold Brahman.
            There is no need to go to the Himalayas or a distant sky to find God; He is right within.
            When we study math or science, our knowledge remains incomplete, but Self-knowledge is final.
            The three biggest things in existence—I, this world, and God—are not separate; they are one.
            Just as a bracelet, ring, and necklace are different in form but in essence are only pure gold.
            Similarly, all this diversity is merely a beautiful and magical expression of that one Brahman.
            This verse is the essence of Vedanta, lifting the seeker's vision from duality to absolute non-duality.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 13,
        sanskrit = "वह्नेर्यथा योनिगतस्य मूर्तिर्न दृश्यते नैव च लिङ्गनाशः । स भूय एवेन्धनयोनिगृह्यस्तद्वोभयं वै प्रणवेन देहे ॥ १३ ॥",
        hindi = """
            जिस प्रकार लकड़ी (योनि) के भीतर छिपी हुई आग का कोई भी रूप बाहर से दिखाई नहीं देता है।
            किंतु उस अदृश्य आग के सूक्ष्म स्वरूप (लिङ्ग) का कभी भी नाश नहीं होता, वह वहीं मौजूद रहती है।
            और जब उस लकड़ी को रगड़ा (मंथा) जाता है, तो वह आग फिर से प्रकट होकर स्पष्ट दिखाई देने लगती है।
            ठीक उसी प्रकार, वह परमात्मा इस शरीर के भीतर छिपा हुआ है, जिसे ॐ (प्रणव) के द्वारा पकड़ा जा सकता है।
            यह उपनिषद की सबसे शक्तिशाली उपमाओं में से एक है जो आत्मा की उपस्थिति को समझाती है।
            ईश्वर अदृश्य है इसका मतलब यह नहीं कि वह नहीं है; वह लकड़ी में छिपी आग की तरह शांत है।
            अगर हम लकड़ी को केवल देखते रहें, तो आग नहीं मिलेगी; हमें उसे रगड़ने का प्रयास करना होगा।
            प्रणव (ॐ) का निरंतर जाप ही वह घर्षण है जो हमारे अज्ञान की लकड़ी को जलाकर ज्ञान की आग पैदा करता है।
            शरीर एक उपकरण है और ॐ उस उपकरण को जगाने की चाबी है, जिससे आत्मा का प्रकाश फूट पड़ता है।
            यह श्लोक बताता है कि योग कोई रहस्य नहीं, बल्कि चेतना को प्रकट करने की एक प्रायोगिक (Practical) विधि है।
        """.trimIndent(),
        english = """
            Just as the form of fire hidden within its source (wood) is not visible from the outside at all.
            Yet the subtle essence (Linga) of that invisible fire is never destroyed; it remains present there.
            And when that wood is rubbed (churned), that fire manifests again and becomes clearly visible.
            In the exact same way, the Supreme Lord is hidden within this body and can be grasped through OM (Pranava).
            This is one of the most powerful metaphors in the Upanishads explaining the presence of the Soul.
            God being invisible does not mean He doesn't exist; He is calm like the latent fire in wood.
            If we merely stare at the wood, we won't get fire; we must make the active effort to rub it.
            The continuous chanting of Pranava (OM) is the friction that burns the wood of ignorance to produce the fire of wisdom.
            The body is an instrument, and OM is the key to ignite it, causing the light of the soul to burst forth.
            This verse shows that Yoga is not a mystery, but a highly practical method to manifest consciousness.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 14,
        sanskrit = "स्वदेहमरणिं कृत्वा प्रणवं चोत्तराणिम् । ध्याननिर्मथनाभ्यासाद् देवं पश्येन्निगूढवत् ॥ १४ ॥",
        hindi = """
            साधक को अपने स्वयं के शरीर को नीचे की अरणि (आग जलाने वाली लकड़ी) बनाना चाहिए।
            और ॐ (प्रणव) मंत्र को ऊपर की अरणि बनाकर इन दोनों के बीच निरंतर घर्षण करना चाहिए।
            इस प्रकार ध्यान रूपी मंथन (रगड़ने की क्रिया) के लगातार अभ्यास और प्रयास के द्वारा।
            वह साधक अपने भीतर छिपे हुए (निगूढ) उस परम देव (परमात्मा) को प्रत्यक्ष रूप से देख सकता है।
            यह श्लोक ध्यान की अत्यंत व्यावहारिक तकनीक (Technique) को स्पष्ट रूप से बताता है।
            केवल किताब पढ़ने से आग नहीं जलेगी, साधक को स्वयं बैठकर ध्यान का मंथन करना ही होगा।
            शरीर को स्थिर रखना (नीचे की लकड़ी) और मन से ॐ का जाप करना (ऊपर की लकड़ी) ही योग है।
            जब ध्यान गहरा होता है, तो चित्त की अशुद्धियां जल जाती हैं और सत्य का प्रकाश फैल जाता है।
            ईश्वर हमारे ही भीतर छिपा हुआ एक खजाना है, ध्यान उस खजाने को खोदकर बाहर निकालने की प्रक्रिया है।
            अभ्यास (Practice) के बिना यह सब असंभव है; लगातार साधना ही सफलता की एकमात्र गारंटी है।
        """.trimIndent(),
        english = """
            The seeker should make his own physical body the lower Arani (the wood block used for making fire).
            And he should make the Pranava (OM) mantra the upper Arani to create continuous friction between them.
            Through the constant and diligent practice of this churning in the form of deep meditation.
            The seeker can directly behold that Supreme Deity (Paramatman) who is deeply hidden within him.
            This verse clearly explains a highly practical and actionable technique of meditation.
            Merely reading a book will not light the fire; the seeker must sit and do the churning of meditation himself.
            Keeping the body steady (lower wood) and chanting OM with the mind (upper wood) is true Yoga.
            When meditation deepens, the impurities of the mind are burnt away and the light of truth spreads.
            God is a treasure hidden right within us; meditation is the active process of digging that treasure out.
            Without practice (Abhyasa), all this is impossible; continuous spiritual discipline is the only guarantee of success.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 15,
        sanskrit = "तिलेषु तैलं दधनीव सर्पिरापः स्रोतःस्वरणीषु चाग्निः । एवमात्माऽऽत्मनि गृह्यतेऽसौ सत्येनैनं तपसा योऽनुपश्यति ॥ १५ ॥",
        hindi = """
            जिस प्रकार तिलों के भीतर तेल छिपा होता है, और दही के भीतर घी (मक्खन) छिपा रहता है।
            जिस प्रकार भूमि के स्रोतों (नदियों) में जल छिपा है और अरणियों (लकड़ियों) में अग्नि छिपी है।
            ठीक उसी प्रकार, वह परमात्मा इस जीवात्मा (हृदय) के भीतर ही छिपा हुआ है और वहीं ग्रहण किया जाता है।
            जो व्यक्ति सत्य और तप (कठोर मानसिक अनुशासन) के द्वारा उसे खोजता है, वही उसे साक्षात् देखता है।
            इस श्लोक में दी गई चार उपमाएं (तिल, दही, नदी, लकड़ी) प्रकृति के छिपे हुए रहस्यों को दर्शाती हैं।
            तिल को पेरे बिना तेल नहीं मिलता और दही को मथे बिना घी बाहर नहीं आता है।
            इसी प्रकार, केवल सत्य बोलने और मन-इंद्रियों को अनुशासित (तप) किए बिना ईश्वर का दर्शन नहीं हो सकता।
            ईश्वर कोई बाहरी वस्तु नहीं जिसे खरीदा जा सके; वह हमारी अपनी ही चेतना का सबसे शुद्ध रूप है।
            साधना एक वैज्ञानिक प्रक्रिया है; जो भी सही विधि का प्रयोग करेगा, उसे परिणाम अवश्य मिलेगा।
            यहाँ श्वेताश्वतर उपनिषद का पहला अध्याय एक अत्यंत ही प्रेरणादायक और सशक्त नोट पर समाप्त होता है।
        """.trimIndent(),
        english = """
            Just as oil is hidden within sesame seeds, and ghee (butter) is hidden within curd.
            Just as water is hidden within underground springs, and fire is hidden within the Arani wood.
            In the exact same way, that Supreme Soul is hidden within the individual soul and is grasped right there.
            The person who searches for Him through truth and Tapas (strict mental discipline) alone truly beholds Him.
            The four metaphors (sesame, curd, springs, wood) given in this verse illustrate the hidden secrets of nature.
            Without pressing sesame, oil is not extracted, and without churning curd, butter does not come out.
            Similarly, without speaking truth and disciplining the mind and senses (Tapas), God cannot be realized.
            God is not an external commodity to be bought; He is the purest form of our own consciousness.
            Spiritual practice is a scientific process; whoever applies the right method will definitely get the result.
            Here, the first chapter of the Shvetashvatara Upanishad concludes on an extremely inspiring and powerful note.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 16,
        sanskrit = "सर्वव्यापिनमात्मानं क्षीरे सर्पिरिवार्पितम् । आत्मविद्यातपोमूलं तद्ब्रह्मोपनिषत्परम् ॥ १६ ॥",
        hindi = """
            वह परमात्मा सर्वव्यापी है, वह हर जगह और हर वस्तु में उसी प्रकार घुला-मिला है।
            जिस प्रकार दूध के कण-कण में मक्खन (घी) पूरी तरह से व्याप्त और छिपा हुआ रहता है।
            वह परम ब्रह्म केवल आत्मविद्या (स्वयं को जानने की विद्या) और तप (अनुशासन) के द्वारा ही प्राप्त होता है।
            यही वह सर्वोच्च उपनिषद (ब्रह्मविद्या) का ज्ञान है, जो मनुष्य को उसके असली स्वरूप से मिलाता है।
            दूध बाहर से सफेद पानी जैसा दिखता है, पर उसके भीतर एक अत्यंत मूल्यवान तत्व (घी) छिपा है।
            उसी तरह, यह दुनिया बाहर से केवल जड़ पदार्थ दिखती है, पर इसके कण-कण में ईश्वरीय चेतना मौजूद है।
            घी निकालने के लिए दूध को गर्म करना और मथना पड़ता है, यही आत्मविद्या और तप का अर्थ है।
            बिना तपस्या के किया गया ज्ञान का दावा केवल एक बौद्धिक अहंकार है, उसमें कोई सत्य नहीं।
            जब साधक इस तत्व को जान लेता है, तो वह हर जीव में और हर पत्थर में उसी ईश्वर का दर्शन करता है।
            यह श्लोक प्रथम अध्याय का उपसंहार है, जो वेदांत के संपूर्ण मार्ग को एक वाक्य में समेट देता है।
        """.trimIndent(),
        english = """
            That Supreme Soul is all-pervading; He is blended and mixed into everywhere and everything.
            Just as butter (ghee) is completely pervaded and hidden within every single drop of milk.
            That Supreme Brahman is attained exclusively through Self-knowledge (Atmavidya) and Tapas (discipline).
            This is the highest teaching of the Upanishads (Brahmavidya), which unites man with his true nature.
            Milk looks like white water from the outside, but a highly valuable element (ghee) is hidden within it.
            Similarly, this world looks like inert matter outwardly, but divine consciousness exists in its every atom.
            To extract ghee, milk must be heated and churned; this is exactly the meaning of Atmavidya and Tapas.
            A claim of knowledge made without austerity is merely intellectual ego; it holds no real truth.
            When a seeker realizes this principle, he sees the same God in every living being and every stone.
            This verse is the conclusion of the first chapter, summarizing the entire path of Vedanta in one sentence.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 17,
        sanskrit = "युञ्जानः प्रथमं मनस्तत्त्वाय सविता धियः । अग्नेर्ज्योतिर्निचाय्य पृथिव्या अध्याभरत् ॥ १७ ॥",
        hindi = """
            (द्वितीय अध्याय प्रारंभ): सबसे पहले, सविता देव (सूर्य/परमात्मा) ने सत्य को जानने के लिए।
            हमारे मन और हमारी बुद्धियों को ध्यान और एकाग्रता के मार्ग में पूरी तरह से लगा दिया (युक्त किया)।
            उसने अग्नि (परमात्मा के प्रकाश) की दिव्य ज्योति को देखकर उसे इस पृथ्वी (शरीर) में धारण किया।
            यह श्लोक यजुर्वेद का एक प्राचीन मंत्र है जिसे यहाँ योग की शुरुआत के लिए प्रयोग किया गया है।
            ध्यान शुरू करने से पहले हमें उस परम प्रकाशक (सविता) से प्रेरणा और आशीर्वाद मांगना चाहिए।
            जब तक परमात्मा की कृपा नहीं होती, तब तक मन कभी भी एकाग्र होकर ध्यान में नहीं लग सकता।
            अग्नि की ज्योति का अर्थ है वह आंतरिक आध्यात्मिक ऊर्जा जो हमारी अज्ञानता को जला देती है।
            शरीर (पृथ्वी) में उस ज्योति को स्थापित करने का अर्थ है कुंडलिनी या आंतरिक चेतना को जगाना।
            योग कोई शारीरिक कसरत नहीं है, यह एक अत्यंत गहरी और पवित्र आध्यात्मिक प्रक्रिया है।
            साधक यहाँ प्रार्थना कर रहा है कि उसका मन भटके नहीं, बल्कि सत्य के प्रकाश में स्थिर हो जाए।
        """.trimIndent(),
        english = """
            (Beginning of Chapter 2): First of all, Savitr (the Sun/Supreme Lord), to realize the Truth.
            Yoked (directed) our minds and our intellects entirely into the path of meditation and concentration.
            Having perceived the divine light of Fire (the Supreme's radiance), He established it in this earth (body).
            This verse is an ancient mantra from the Yajurveda used here to mark the beginning of Yoga practice.
            Before starting meditation, we must seek inspiration and blessings from that Supreme Illuminator (Savitr).
            Unless there is the grace of God, the mind can never become concentrated and engaged in meditation.
            The light of the fire signifies that internal spiritual energy which completely burns away our ignorance.
            Establishing that light in the body (earth) means awakening the Kundalini or the inner consciousness.
            Yoga is not a mere physical exercise; it is an extremely deep and highly sacred spiritual process.
            The seeker is praying here that his mind may not wander, but become steady in the light of Truth.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 18,
        sanskrit = "युक्तेन मनसा वयं देवस्य सवितुः सवे । सुवर्गेयाय शक्त्या ॥ १८ ॥",
        hindi = """
            हम एकाग्र और पूरी तरह वश में किए गए (युक्त) मन के साथ उस देव सविता की आज्ञा में स्थित हों।
            ताकि हम अपनी पूरी शक्ति और सामर्थ्य के साथ स्वर्ग (परम सुख/मोक्ष) की ओर बढ़ सकें।
            यहाँ 'स्वर्ग' का अर्थ केवल मरने के बाद मिलने वाला लोक नहीं है, बल्कि यह चेतना की उच्चतम अवस्था है।
            मन एक घोड़े की तरह है; जब तक इसे ध्यान (योग) की लगाम से जोड़ा नहीं जाता, यह हमें गिरा देता है।
            सविता (सूर्य) यहाँ उस परमात्मा का प्रतीक है जो पूरी सृष्टि को जीवन और प्रकाश देता है।
            उसकी 'आज्ञा' में रहने का अर्थ है अहंकार को छोड़कर ईश्वरीय इच्छा के प्रति पूरी तरह समर्पित हो जाना।
            ध्यान में बैठने से पहले अपनी पूरी शक्ति (शक्त्या) को एक बिंदु पर केंद्रित करना अनिवार्य है।
            यह श्लोक योग के मार्ग पर चलने के लिए साधक के दृढ़ संकल्प (Willpower) को स्पष्ट करता है।
            बिना एकाग्र मन के की गई कोई भी प्रार्थना या पूजा केवल एक कर्मकांड बनकर रह जाती है।
            सच्चा योगी वही है जो अपनी सारी ऊर्जा को सत्य की खोज के एक ही लक्ष्य में झोंक देता है।
        """.trimIndent(),
        english = """
            With a mind completely concentrated and controlled (yoked), may we abide by the command of God Savitr.
            So that with all our strength and full capacity, we may advance toward heaven (supreme bliss/Moksha).
            Here, 'Heaven' does not merely mean an afterlife realm, but indicates the highest state of consciousness.
            The mind is like a wild horse; until it is harnessed with the reins of meditation (Yoga), it throws us down.
            Savitr (Sun) here symbolizes that Supreme Lord who grants life and illumination to the entire creation.
            Abiding in His 'command' means dropping the ego and becoming totally surrendered to the Divine Will.
            Before sitting in meditation, focusing one's entire strength (Shaktya) on a single point is mandatory.
            This verse clearly expresses the strong determination (Willpower) of the seeker to walk the path of Yoga.
            Any prayer or worship done without a concentrated mind remains nothing more than an empty ritual.
            A true Yogi is one who pours all his energy into the single goal of discovering the absolute Truth.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 19,
        sanskrit = "युक्त्वाय मनसा देवान् सुवर्यतो धिया दिवम् । बृहज्ज्योतिः करिष्यतः सविता प्रसुवाति तान् ॥ १९ ॥",
        hindi = """
            सविता देव उन योगियों को सफलता का आशीर्वाद (प्रेरणा) प्रदान करते हैं।
            जो योगी अपने मन और बुद्धि के द्वारा इंद्रियों (देवों) को पूरी तरह वश में कर लेते हैं।
            और जो स्वर्ग (परम प्रकाश) की ओर जाने की तीव्र इच्छा रखकर ध्यान में बैठते हैं।
            जो उस महान ज्योति (बृहज्ज्योति/ब्रह्म) को साक्षात् प्रकट करने का दृढ़ संकल्प कर चुके हैं।
            इंद्रियों को 'देव' कहा गया है क्योंकि वे बाहरी दुनिया के प्रकाशक और खिड़कियां हैं।
            जब तक इंद्रियां बाहर भागती हैं, तब तक भीतर की महान ज्योति का दर्शन कभी नहीं हो सकता।
            सविता देव की प्रेरणा का अर्थ है कि जब हम एक कदम बढ़ाते हैं, तो ईश्वर हमारी ओर दस कदम बढ़ाता है।
            योग कोई अकेला संघर्ष नहीं है, यह तो ईश्वरीय कृपा और मानवीय प्रयास का सुंदर संगम है।
            बृहज्ज्योति वह आत्म-प्रकाश है जो करोड़ों सूर्यों से भी अधिक चमकीला और शांतिदायक है।
            यह श्लोक योगियों को उनकी कठिन साधना में ईश्वर के पूर्ण समर्थन का भरोसा दिलाता है।
        """.trimIndent(),
        english = """
            God Savitr grants the blessing (inspiration) of success to those dedicated yogis.
            Those yogis who, through their mind and intellect, completely control their senses (Devas).
            And who sit in meditation with an intense desire to journey toward heaven (supreme Light).
            Those who have made a firm resolve to directly manifest that Great Light (Brihajjyoti/Brahman).
            The senses are called 'Devas' because they are the illuminators and windows to the external world.
            As long as the senses run outward, the great internal Light can never possibly be perceived.
            The inspiration of Savitr means that when we take one step, God takes ten steps toward us.
            Yoga is not a lonely struggle; it is a beautiful confluence of divine grace and human effort.
            Brihajjyoti is that light of the Self which is brighter and more soothing than millions of suns.
            This verse assures yogis of God's complete support and backing in their arduous spiritual practice.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 20,
        sanskrit = "युञ्जते मन उत युञ्जते धियो विप्रा विप्रस्य बृहतो विपश्चितः । वि होत्रा दधे वयुनाविदेक इन्मही देवस्य सवितुः परिष्टुतिः ॥ २० ॥",
        hindi = """
            ज्ञानी और मेधावी (विप्र) पुरुष अपने मन और अपनी बुद्धियों को ध्यान में एकाग्र (युक्त) करते हैं।
            वे उस महान, सर्वज्ञ और अनंत परमात्मा (सविता) में अपनी चेतना को पूरी तरह से लगा देते हैं।
            वह परमात्मा अकेला ही सब कुछ जानने वाला (वयुनाविद्) है और वही सभी कर्मों के फल देता है।
            उस सर्वव्यापी सविता देव की यह स्तुति अत्यंत महान (मही) और कल्याणकारी है।
            जब बुद्धिमान लोग सत्य को जान लेते हैं, तो वे अपनी सारी ऊर्जा सांसारिक चीज़ों से हटा लेते हैं।
            उनका पूरा ध्यान केवल उस 'विपश्चित' (परम ज्ञानी) ईश्वर के साथ एक होने पर केंद्रित होता है।
            होत्रा दधे का अर्थ है कि वही ईश्वर हमारे सभी यज्ञों (अच्छे कर्मों) को धारण करता है।
            हम जो कुछ भी करते हैं, वह उसी की चेतना की उपस्थिति के कारण ही संभव हो पाता है।
            यह श्लोक ध्यान की गहराई को दर्शाता है जहाँ स्तुति केवल शब्द नहीं, बल्कि मौन अवस्था बन जाती है।
            परमात्मा की महानता को पहचानना और उसमें लीन हो जाना ही मानव जीवन की असली सफलता है।
        """.trimIndent(),
        english = """
            The wise and highly intelligent (Vipra) men yoke their minds and intellects completely in meditation.
            They attach their consciousness entirely to that great, omniscient, and infinite Supreme Lord (Savitr).
            That Supreme Lord alone is the knower of all things (Vayunavid) and the ordainer of all karma's fruits.
            This praise of that all-pervading God Savitr is extremely great (Mahi) and highly auspicious.
            When intelligent people realize the truth, they withdraw all their energy from worldly things.
            Their entire focus is centered solely on becoming one with that 'Vipashchit' (Supreme Knower) God.
            'Hotra dadhe' means that God Himself supports and sustains all our sacrifices (noble deeds).
            Whatever we do becomes possible only because of the presence of His absolute consciousness.
            This verse illustrates the depth of meditation where praise is not just words, but a state of silence.
            Recognizing the greatness of the Supreme and merging into Him is the true success of human life.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 21,
        sanskrit = "युजे वां ब्रह्म पूर्व्यं नमोभिर्वि श्लोक एतु पथ्येव सूरेः । शृण्वन्तु विश्वे अमृतस्य पुत्रा आ ये धामानि दिव्यानि तस्थुः ॥ २१ ॥",
        hindi = """
            (साधक कहता है): मैं नमस्कार और प्रार्थनाओं के द्वारा उस प्राचीन परब्रह्म से जुड़ने का प्रयास करता हूँ।
            मेरी यह स्तुति और कीर्ति एक ज्ञानी पुरुष (सूरि) के मार्ग की तरह सब दिशाओं में फैल जाए।
            हे विश्व के सभी लोगो! हे अमृत के पुत्रों! तुम सब मेरी इस पुकार को ध्यान से सुनो।
            वे सभी देवता भी सुनें जो उन दिव्य और उच्च लोकों (धामों) में विराजमान हैं।
            यह उपनिषदों की सबसे प्रसिद्ध और क्रांतिकारी उद्घोषणा है: 'अमृतस्य पुत्राः' (अमृत के पुत्र)।
            हम पापी या कमजोर शरीर नहीं हैं, हम उस शाश्वत और अमर परमात्मा की साक्षात् संतान हैं।
            जब एक योगी सत्य को पा लेता है, तो वह चाहता है कि यह प्रकाश पूरी दुनिया तक पहुँचे।
            यह श्लोक हमें अपनी असली पहचान (Divine identity) की याद दिलाकर हमारे भीतर सोई हुई शक्ति को जगाता है।
            हमारा जन्म मरने और रोने के लिए नहीं, बल्कि अपनी दिव्यता को पहचानने के लिए हुआ है।
            यह एक वैश्विक आमंत्रण (Global call) है जो पूरी मानवता को योग और ज्ञान के मार्ग पर बुलाता है।
        """.trimIndent(),
        english = """
            (The seeker says): I strive to unite with that ancient Supreme Brahman through salutations and prayers.
            May this praise and glory of mine spread in all directions like the path of a wise sage (Suri).
            O all people of the world! O Children of Immortality! Listen carefully to this call of mine.
            May all the deities also listen, who are seated in those divine and highly exalted realms (Dhamas).
            This is the most famous and revolutionary declaration of the Upanishads: 'Amritasya Putrah' (Children of Immortality).
            We are not sinners or weak bodies; we are the direct offspring of that eternal and immortal God.
            When a yogi realizes the truth, he desires that this light should reach the entire world.
            This verse awakens the dormant power within us by reminding us of our true, divine identity.
            We are not born to weep and die, but to recognize and experience our inherent divinity.
            This is a global invitation calling all of humanity to walk the path of Yoga and ultimate wisdom.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 22,
        sanskrit = "अग्निर्यत्राभिमथ्यते वायुर्यत्राधिरुध्यते । सोमो यत्रातिरिच्यते तत्र सञ्जायते मनः ॥ २२ ॥",
        hindi = """
            जहाँ (जिस योग के अभ्यास में) ध्यान की अग्नि को निरंतर रगड़कर (मंथन करके) प्रज्वलित किया जाता है।
            जहाँ प्राणायाम के द्वारा प्राण वायु को पूरी तरह से नियंत्रित (निरुद्ध) किया जाता है।
            और जहाँ सोम (सोम रस/आध्यात्मिक आनंद का रस) अत्यधिक मात्रा में छलकने और बहने लगता है।
            उसी अवस्था में साधक का मन पूरी तरह से शुद्ध और उस परब्रह्म में एकाग्र हो जाता है।
            यह श्लोक हठयोग और राजयोग की बहुत ही गुप्त और वैज्ञानिक प्रक्रिया का वर्णन करता है।
            अग्नि का मंथन मतलब कुंडलिनी शक्ति को मूलाधार चक्र से जाग्रत करके ऊपर की ओर उठाना।
            वायु का निरोध मतलब अपनी श्वास को शांत करना, क्योंकि श्वास रुकने पर विचार भी रुक जाते हैं।
            सोम वह अमृत है जो सहस्रार चक्र (मस्तिष्क) से टपकता है जब योगी गहरी समाधि में पहुँचता है।
            इन तीनों (अग्नि, वायु, सोम) के संतुलन से ही मन सांसारिक मोह से कटकर ब्रह्म में लीन होता है।
            योग कोई दिमागी कसरत नहीं, यह शरीर की रासायनिक और ऊर्जात्मक (Energetic) संरचना का पूर्ण बदलाव है।
        """.trimIndent(),
        english = """
            Where (in the practice of Yoga) the fire of meditation is kindled continuously through churning.
            Where the vital air (Prana) is completely controlled and restrained through Pranayama.
            And where the Soma (the nectar of spiritual bliss) overflows and begins to stream down abundantly.
            In that very state, the mind of the seeker becomes completely pure and concentrated on Brahman.
            This verse describes a highly secret and scientific process of Hatha Yoga and Raja Yoga.
            Churning the fire means awakening the Kundalini power from the Root Chakra and raising it upwards.
            Restraining the air means calming the breath, because when breath stops, thoughts also stop.
            Soma is that nectar which drips from the Crown Chakra (brain) when the yogi reaches deep Samadhi.
            Only through the balance of these three (Fire, Air, Soma) does the mind detach from the world and merge in God.
            Yoga is not a mental exercise; it is a complete transformation of the body's chemical and energetic structure.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 23,
        sanskrit = "सवित्रैवा प्रसवेन जुषेत ब्रह्म पूर्व्यम् । तत्र योनिं कृणवसे न हि ते पूर्तमक्षिपत् ॥ २३ ॥",
        hindi = """
            सविता देव (ईश्वर) की प्रेरणा और उनकी दिव्य कृपा से ही उस प्राचीन ब्रह्म का सेवन (ध्यान) करो।
            उस ब्रह्म में ही तुम अपने मन और अपनी चेतना को पूरी तरह से स्थापित (योनिं कृणवसे) करो।
            यदि तुम ऐसा करोगे, तो तुम्हारे पूर्व कर्म (पाप और पुण्य) तुम्हें कभी भी बांध या नीचे गिरा नहीं सकेंगे।
            ब्रह्म का ध्यान कोई अहंकार का विषय नहीं है; यह ईश्वर की आज्ञा और कृपा के बिना संभव नहीं है।
            जब साधक अपने मन को ब्रह्म में स्थापित कर लेता है, तो वह कर्मों के कार्य-कारण चक्र से बाहर आ जाता है।
            हमारे पिछले कर्म एक जाल की तरह हैं जो हमें बार-बार जन्म लेने के लिए मजबूर करते हैं।
            परंतु योग की अग्नि इतनी प्रचंड है कि वह संचित कर्मों के बीज को पूरी तरह से भस्म कर देती है।
            यहाँ उपनिषद स्पष्ट आश्वासन दे रहा है कि ध्यान ही वह कवच है जो कर्मों के प्रहार से बचाता है।
            साधक को चाहिए कि वह अपनी सारी ऊर्जा उस एक सुरक्षित किले (ब्रह्म) में छिपने में लगा दे।
            कर्म हमें तभी तक सताते हैं जब तक हम खुद को शरीर मानते हैं; आत्मा बनने पर कर्म समाप्त हो जाते हैं।
        """.trimIndent(),
        english = """
            With the inspiration and divine grace of God Savitr, serve and meditate upon that ancient Brahman.
            Establish your mind and your consciousness entirely and firmly in that Brahman alone (make it your source).
            If you do this, your past actions (both sins and merits) will never be able to bind you or cast you down.
            Meditating on Brahman is not a matter of ego; it is impossible without God's command and grace.
            When a seeker establishes his mind in Brahman, he steps outside the cause-and-effect cycle of karma.
            Our past actions are like a web that constantly forces us to be reborn in this world.
            But the fire of Yoga is so fierce that it completely burns the seeds of accumulated karmas to ashes.
            Here the Upanishad gives a clear assurance that meditation is the armor protecting against karma's strikes.
            The seeker should devote all his energy to hiding in that one completely safe fortress (Brahman).
            Karmas torment us only as long as we consider ourselves a body; upon becoming the Soul, karmas end.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 24,
        sanskrit = "त्रिरुन्नतं स्थाप्य समं शरीरं हृदीन्द्रियाणि मनसा सन्निवेश्य । ब्रह्मोडुपेन प्रतरेत विद्वान् स्रोतांसि सर्वाणि भयानकानि ॥ २४ ॥",
        hindi = """
            योगी को अपने शरीर के तीन अंगों (छाती, गर्दन और सिर) को सीधा, ऊँचा और एक सीध में रखना चाहिए।
            उसे अपनी सभी इंद्रियों को बाहरी विषयों से हटाकर मन के द्वारा अपने हृदय (आत्मा) में स्थिर करना चाहिए।
            इस प्रकार वह विद्वान साधक 'ब्रह्म रूपी नाव' (ॐकार) के सहारे इस संसार रूपी नदी को पार कर ले।
            यह नदी अत्यंत भयानक है, जो अनेक प्रकार के दुखों, भयों और आकर्षणों की धाराओं से भरी हुई है।
            यह श्लोक ध्यान के लिए सही शारीरिक आसन (Posture) का सबसे सटीक और प्राचीन वर्णन है।
            रीढ़ की हड्डी का सीधा होना जरूरी है ताकि सुषुम्ना नाड़ी में ऊर्जा का प्रवाह बिना रुके ऊपर जा सके।
            इंद्रियों को मन के सहारे हृदय में खींचना ही पतंजलि योग सूत्र का 'प्रत्याहार' (Withdrawal) है।
            संसार की धाराओं में इंसान आसानी से डूब सकता है; मोह और लोभ इसकी सबसे भयानक लहरें हैं।
            ब्रह्म (या ॐ का जाप) ही वह इकलौती मजबूत नाव है जो इस खतरनाक भंवर से सुरक्षित बाहर निकाल सकती है।
            शारीरिक स्थिरता और मानसिक एकाग्रता—ये दोनों ही इस भवसागर को पार करने की पतवारें हैं।
        """.trimIndent(),
        english = """
            The Yogi should hold the three upper parts of his body (chest, neck, and head) erect and in a straight line.
            He should withdraw all his senses from external objects and establish them in his heart using his mind.
            In this manner, the wise seeker should cross over the river of the world using the 'boat of Brahman' (OM).
            This river is extremely terrifying, filled with currents of various sorrows, fears, and sensual attractions.
            This verse is the most precise and ancient description of the correct physical posture for meditation.
            Keeping the spine straight is essential so that energy can flow upward through the Sushumna Nadi uninterrupted.
            Drawing the senses into the heart via the mind is exactly what Patanjali calls 'Pratyahara' (Withdrawal).
            A person can easily drown in the currents of the world; delusion and greed are its most terrifying waves.
            Brahman (or chanting OM) is the only sturdy boat that can safely carry one out of this dangerous whirlpool.
            Physical steadiness and mental concentration—these two are the oars required to cross this ocean of existence.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 25,
        sanskrit = "प्राणान् प्रपीड्येह संयुक्तचेष्टः क्षीणे प्राणे नासिकयोच्छ्वसीत । दुष्टाश्वयुक्तमिव वाहमेनं विद्वान् मनो धारयेताप्रमत्तः ॥ २५ ॥",
        hindi = """
            साधक को अपने आहार-विहार को नियंत्रित करके अपने प्राणों (श्वास) को पूरी तरह से साधना (रोकना) चाहिए।
            जब प्राण वायु बहुत धीमी और सूक्ष्म (क्षीण) हो जाए, तब उसे केवल नाक के छिद्रों से ही श्वास छोड़नी चाहिए।
            जैसे कोई चतुर सारथी दुष्ट और अनियंत्रित घोड़ों वाले रथ को बहुत सावधानी से काबू में रखता है।
            उसी प्रकार, विद्वान साधक को बिना किसी लापरवाही (अप्रमत्त) के अपने मन को मजबूती से काबू में रखना चाहिए।
            यह श्लोक योग के 'प्राणायाम' और 'मनोनिग्रह' (Mind control) के विज्ञान को बहुत स्पष्ट रूप से समझाता है।
            श्वास और मन का बहुत गहरा संबंध है; जब श्वास धीमी होती है, तो मन के विचार अपने आप शांत हो जाते हैं।
            'दुष्ट घोड़े' हमारी चंचल इंद्रियां हैं जो हमेशा सुखों की ओर भागने के लिए बेताब रहती हैं।
            रथ हमारा शरीर है और सारथी हमारी बुद्धि है; यदि सारथी सो गया, तो रथ का विनाश निश्चित है।
            अप्रमत्त होने का अर्थ है कि ध्यान में जरा सी भी नींद या आलस्य की कोई गुंजाइश नहीं होनी चाहिए।
            मन को एकाग्र रखना ही योग की सबसे बड़ी चुनौती और सबसे बड़ी जीत है।
        """.trimIndent(),
        english = """
            The seeker should control his diet and habits, thereby fully restraining and regulating his vital breaths (Pranas).
            When the breath becomes extremely slow and subtle (weak), he should breathe out only through his nostrils.
            Just as a clever charioteer very carefully restrains and controls a chariot yoked with wicked, unruly horses.
            In the exact same way, the wise seeker must firmly control his mind without any carelessness (Apramatta).
            This verse very clearly explains the science of 'Pranayama' and 'Mind control' in the system of Yoga.
            Breath and mind have a very deep connection; when breath slows down, thoughts naturally become quiet.
            The 'wicked horses' are our restless senses that are always desperate to run towards worldly pleasures.
            The chariot is our body and the charioteer is our intellect; if the charioteer falls asleep, destruction is certain.
            Being 'Apramatta' means there should be absolutely no room for sleep or laziness during meditation practice.
            Keeping the mind concentrated is the greatest challenge of Yoga and also its greatest absolute victory.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 26,
        sanskrit = "समे शुचौ शर्करावह्निवालुकाविवर्जिते शब्दजलाश्रयादिभिः । मनोनुकूले न तु चक्षुपीडने गुहानिवाताश्रयणे प्रयोजयेत् ॥ २६ ॥",
        hindi = """
            साधक को ध्यान का अभ्यास एक ऐसे स्थान पर करना चाहिए जो बिल्कुल समतल (बराबर) और शुद्ध हो।
            जहाँ कंकड़, पत्थर, बालू न हो और जहाँ आग या धूप की तेज गर्मी बिल्कुल भी न पहुँचती हो।
            जहाँ किसी भी प्रकार का शोर (शब्द) न हो, और जो जल तथा नमी के हानिकारक प्रभाव से मुक्त हो।
            वह स्थान मन के अनुकूल होना चाहिए और आँखों को पीड़ा पहुँचाने वाले दृश्यों से पूरी तरह रहित होना चाहिए।
            उसे किसी सुरक्षित गुफा या हवा के तेज झोंकों से बचे हुए (निर्वात) स्थान पर मन लगाना चाहिए।
            यह श्लोक सफल ध्यान के लिए बाहरी वातावरण (Environment) के भौतिक नियमों को स्पष्ट करता है।
            हमारा मन बाहरी दुनिया से बहुत जल्दी प्रभावित होता है; इसलिए शुरुआत में एकांत बहुत आवश्यक है।
            आँखों को पीड़ा न देने का अर्थ है कि स्थान का प्रकाश सौम्य होना चाहिए, न बहुत तेज, न बहुत अँधेरा।
            जब शरीर और इंद्रियां बाहरी झंझटों से सुरक्षित महसूस करती हैं, तभी मन भीतर की ओर आसानी से मुड़ पाता है।
            पतंजलि के 'आसन' और 'प्रत्याहार' के लिए अनुकूल वातावरण की यह एक बहुत ही प्राचीन और प्रामाणिक मार्गदर्शिका है।
        """.trimIndent(),
        english = """
            A seeker should practice meditation in a place that is perfectly level (even) and totally pure.
            Where there are no pebbles, stones, sand, and where the intense heat of fire or sun does not reach.
            Where there is absolutely no disturbing noise, and which is free from the harmful effects of water or dampness.
            That place should be pleasing to the mind and completely free from sights that cause pain to the eyes.
            He should concentrate his mind in a secure cave or a shelter protected from strong gusts of wind.
            This verse outlines the physical rules of the external environment required for successful meditation.
            Our mind is easily affected by the outside world; therefore, seclusion is highly essential in the beginning.
            Not causing pain to the eyes means the lighting should be soothing, neither too glaring nor too dark.
            Only when the body and senses feel safe from external troubles can the mind easily turn inwards.
            This is a very ancient and authentic guide to creating the right atmosphere for Patanjali's 'Asana' and 'Pratyahara'.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 27,
        sanskrit = "नीहारधूमार्कानिलानलानां खद्योतविद्युत्स्फटिकशशीनाम् । एतानि रूपाणि पुरःसराणि ब्रह्मण्यभिव्यक्तिकराणि योगे ॥ २७ ॥",
        hindi = """
            योग के अभ्यास के दौरान जब ध्यान गहरा होने लगता है, तो मन में कुछ प्रारंभिक दर्शन (चिह्न) प्रकट होते हैं।
            साधक को कोहरा, धुआं, सूर्य, तेज हवा और प्रज्वलित अग्नि जैसे सूक्ष्म रूप दिखाई देने लगते हैं।
            कभी-कभी जुगनू की चमक, चमकती हुई बिजली, स्फटिक मणि और शांत चंद्रमा जैसे दृश्य भी प्रकट होते हैं।
            ब्रह्म के साक्षात् प्रकट होने से पहले ये सभी रूप योग में प्रारंभिक अवस्था (पुरःसराणि) के रूप में दिखाई देते हैं।
            ये कोई बाहरी दृश्य नहीं हैं, बल्कि साधक की जागृत होती हुई आंतरिक चेतना और ऊर्जा के सूक्ष्म अनुभव हैं।
            जब मन बाहरी दुनिया से कटकर भीतर एकाग्र होता है, तो चक्रों और नाड़ियों की ऊर्जा प्रकाश रूप में दिखती है।
            ये चिह्न इस बात का सबूत हैं कि ध्यान सही दिशा में जा रहा है और अज्ञान का परदा धीरे-धीरे हट रहा है।
            किंतु उपनिषद यहाँ संकेत देता है कि साधक को इन चमत्कारी दृश्यों में उलझकर अपनी यात्रा रोकनी नहीं चाहिए।
            ये केवल मील के पत्थर (Milestones) हैं, अंतिम मंजिल तो वह परम ब्रह्म है जो इन सबसे परे और निराकार है।
            सच्चा योगी इन प्रकाश-बिंदुओं से गुजरता हुआ उस अखंड और असीम परम-प्रकाश (ईश्वर) की ओर बढ़ता रहता है।
        """.trimIndent(),
        english = """
            During the practice of Yoga, as meditation deepens, certain preliminary signs manifest in the mind.
            The seeker begins to see subtle forms like mist, smoke, the sun, strong wind, and blazing fire.
            Sometimes visions like the glow of fireflies, flashing lightning, crystal gems, and the calm moon also appear.
            Before the direct manifestation of Brahman, all these forms appear as preliminary stages in Yoga.
            These are not external sights, but the subtle experiences of the seeker's awakening inner consciousness and energy.
            When the mind detaches from the outside and focuses within, the energy of chakras appears as light.
            These signs are proof that meditation is progressing correctly and the veil of ignorance is gradually lifting.
            However, the Upanishad hints here that the seeker should not stop his journey by getting entangled in these visions.
            These are merely milestones; the final destination is that Supreme Brahman who is beyond all these and formless.
            A true yogi passes through these points of light and continues moving towards that unbroken, limitless Supreme Light.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 28,
        sanskrit = "पृथिव्यप्तेजोऽनिलखे समुत्थिते पञ्चात्मके योगगुणे प्रवृत्ते । न तस्य रोगो न जरा न मृत्युः प्राप्तस्य योगाग्निमयं शरीरम् ॥ २8 ॥",
        hindi = """
            जब ध्यान के प्रभाव से पृथ्वी, जल, तेज, वायु और आकाश—इन पांचों महाभूतों की सूक्ष्म शक्तियां जाग्रत हो जाती हैं।
            और जब साधक के भीतर पंचतत्वों से संबंधित योग के विशेष गुण (सिद्धियां) पूरी तरह से प्रवृत्त और प्रकट हो जाते हैं।
            तब उस योगी का भौतिक शरीर योग की अग्नि (योगाग्नि) से तपकर अत्यंत शुद्ध और दिव्य (योगाग्निमय) बन जाता है।
            ऐसे दिव्य शरीर को प्राप्त कर लेने वाले उस योगी को न कोई रोग सताता है, न बुढ़ापा आता है और न ही मृत्यु का भय रहता है।
            यह श्लोक हठयोग और कुंडलिनी योग की उस चरम अवस्था का वर्णन करता है जहाँ शरीर की रसायन (Chemistry) बदल जाती है।
            योग की अग्नि शरीर की सभी अशुद्धियों और बीमारियों के बीजों को पूरी तरह से जलाकर भस्म कर देती है।
            रोग और बुढ़ापा भौतिक शरीर के धर्म हैं; जब शरीर 'योगाग्निमय' हो जाता है, तो वह इन साधारण नियमों से मुक्त हो जाता है।
            मृत्यु न होने का अर्थ भौतिक रूप से हमेशा के लिए जिंदा रहना नहीं है, बल्कि मृत्यु के भ्रम और डर का हमेशा के लिए मिट जाना है।
            जब योगी जान लेता है कि वह शरीर नहीं बल्कि अमर आत्मा है, तो मृत्यु उसके लिए केवल पुराने कपड़े बदलने जैसी हो जाती है।
            यहाँ आकर शारीरिक और मानसिक सीमाएं टूट जाती हैं और साधक एक लौकिक मानव से अलौकिक सिद्ध बन जाता है।
        """.trimIndent(),
        english = """
            When the subtle powers of the five elements—earth, water, fire, air, and ether—are awakened through meditation.
            And when the specific yogic qualities (Siddhis) related to these five elements become fully active in the seeker.
            Then the physical body of that yogi, purified by the fire of yoga, becomes extremely divine and luminous.
            Having attained such a divine, fire-like body, that yogi is afflicted by no disease, no old age, and no fear of death.
            This verse describes the peak state of Hatha and Kundalini Yoga where the body's chemistry completely changes.
            The fire of yoga completely burns to ashes all the impurities and the very seeds of illness within the body.
            Disease and old age are properties of the physical body; a 'fire-body' becomes free from these ordinary laws.
            Not dying does not mean living physically forever, but the complete eradication of the illusion and fear of death.
            When the yogi realizes he is the immortal soul and not the body, death becomes merely like changing old clothes.
            Here, physical and mental limitations are shattered, and the seeker transforms from a mortal human into a divine sage.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 29,
        sanskrit = "लघुत्वमारोग्यमलोलुपत्वं वर्णप्रसादः स्वरसौष्ठवं च । गन्धः शुभो मूत्रपुरीषमल्पं योगप्रवृत्तिं प्रथमां वदन्ति ॥ २९ ॥",
        hindi = """
            योग के सही अभ्यास से सबसे पहले शरीर में भारीपन खत्म होता है और एक अद्भुत हल्कापन (लघुत्व) महसूस होने लगता है।
            संपूर्ण स्वास्थ्य (आरोग्य) प्राप्त होता है और विषयों के प्रति मन की लोलुपता (लालच/आसक्ति) पूरी तरह से खत्म हो जाती है।
            त्वचा के रंग में एक दिव्य कांति और उज्ज्वलता (वर्णप्रसाद) आ जाती है, और वाणी में अत्यंत मधुरता (स्वरसौष्ठव) भर जाती है।
            शरीर से एक शुभ और पवित्र सुगंध आने लगती है, तथा मल-मूत्र आदि विकारों की मात्रा शरीर में बहुत अल्प (कम) हो जाती है।
            ज्ञानी जन इन सभी शारीरिक और मानसिक लक्षणों को योग की पहली सिद्धि या योग की प्रथम अवस्था (प्रवृत्ति) कहते हैं।
            यह श्लोक योगियों के शरीर में होने वाले प्रत्यक्ष और वैज्ञानिक (Scientific) बदलावों को बहुत ही स्पष्ट रूप से बताता है।
            जब मन शांत होता है, तो उसका सीधा असर शरीर की कोशिकाओं (Cells) और ग्रंथियों (Glands) के काम करने के तरीके पर पड़ता है।
            विषयों की आसक्ति मिटने से ऊर्जा का व्यय रुक जाता है, जिससे शरीर का तेज और ओज भीतर ही संचित होने लगता है।
            मल-मूत्र का कम होना यह साबित करता है कि शरीर अब भोजन का बहुत ही गहराई और शुद्धता से पाचन कर रहा है।
            यदि ये लक्षण जीवन में न दिखें, तो इसका अर्थ है कि योग केवल कसरत बनकर रह गया है, उसमें आध्यात्मिक गहराई नहीं आई है।
        """.trimIndent(),
        english = """
            Through correct yogic practice, heaviness first disappears, and a wonderful lightness (Laghutva) is felt in the body.
            Perfect health is attained, and the mind's greed or craving for sensual objects (Alolupatvam) completely vanishes.
            A divine radiance and brightness appears in the complexion, and the voice becomes exceptionally sweet and melodious.
            A pure and auspicious fragrance begins to emanate from the body, and the quantity of excretions becomes very minimal.
            The wise declare all these physical and mental symptoms to be the first perfection or the primary stage of Yoga.
            This verse very clearly outlines the direct, observable, and scientific changes occurring in a yogi's physical body.
            When the mind is calm, it directly impacts the functioning of the body's cells and hormonal glands.
            With the cessation of sensory cravings, energy leakage stops, allowing vitality and aura to accumulate within.
            Minimal excretions prove that the body is now metabolizing food with extreme depth, purity, and efficiency.
            If these signs are absent, it means yoga has remained mere exercise and lacks true spiritual depth.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 30,
        sanskrit = "यथैव बिम्बं मृदयोपलिप्तं तेजोमयं भ्राजते तत् सुधान्तम् । तद्वाऽऽत्मतत्त्वं प्रसमीक्ष्य देही एकः कृतार्थो भवते वीतशोकः ॥ ३० ॥",
        hindi = """
            जिस प्रकार कोई दर्पण (शीशा) मिट्टी और धूल से सना हुआ हो, तो वह अपनी चमक और स्वरूप को नहीं दिखा पाता।
            किंतु जब उसे अच्छी तरह धोकर साफ (सुधान्तम्) कर दिया जाता है, तो वह अत्यंत तेजोमय होकर फिर से चमकने लगता है।
            ठीक उसी प्रकार, अज्ञान और कर्मों की धूल से ढकी हुई यह जीवात्मा अपने असली और शुद्ध स्वरूप को भूल जाती है।
            परंतु जब साधक योग और ध्यान के द्वारा अपने अंतःकरण को पूरी तरह से शुद्ध करके उस आत्मतत्त्व का साक्षात् दर्शन कर लेता है।
            तब वह शरीर धारण करने वाला जीव (देही) पूर्ण रूप से कृतार्थ (सफल) हो जाता है और हमेशा के लिए शोकरहित (दुख-मुक्त) हो जाता है।
            दर्पण की उपमा यह सिद्ध करती है कि आत्मा कभी भी अशुद्ध नहीं होती, केवल उस पर मन और इच्छाओं की धूल जम जाती है।
            हमें आत्मा को कहीं बाहर से लाना नहीं है; हमें केवल उस पर जमी हुई अज्ञानता की मिट्टी को ध्यान के पानी से धोना है।
            जैसे ही दर्पण साफ होता है, उसमें परमात्मा का असली और अखंड प्रकाश अपने आप स्पष्ट रूप से झलकता है।
            'कृतार्थ' होने का अर्थ है कि मानव जीवन का जो असली उद्देश्य था, वह अब पूरी तरह से संपन्न हो चुका है।
            शोकरहित होने का अर्थ है कि अब जन्म, मृत्यु, हानि या अपमान जैसी कोई भी सांसारिक घटना उस योगी को रुला नहीं सकती।
        """.trimIndent(),
        english = """
            Just as a mirror smeared with mud and dust is completely unable to reflect its true brilliance and nature.
            But when it is washed and cleaned thoroughly (Sudhantam), it begins to shine brightly with immense radiance again.
            In the exact same way, the individual soul covered by the dust of ignorance and karma forgets its pure, original nature.
            But when the seeker completely purifies his inner being through Yoga and directly beholds that true soul-principle.
            Then that embodied soul (Dehi) achieves the ultimate fulfillment of life and becomes free from all sorrow forever.
            The mirror metaphor proves that the soul is never truly impure; it is only covered by the dust of the mind and desires.
            We do not have to bring the soul from outside; we merely have to wash away the mud of ignorance with the water of meditation.
            The moment the mirror is cleaned, the true and unbroken light of the Supreme Lord automatically reflects in it clearly.
            Being 'Kritartha' (fulfilled) means that the true, ultimate purpose of taking a human birth has been fully accomplished.
            Being sorrow-less means that no worldly event like birth, death, loss, or insult can ever make that Yogi weep again.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 31,
        sanskrit = "यदात्मतत्त्वेन तु ब्रह्मतत्त्वं दीपोपमेनेह युक्तः प्रपश्येत् । अजं ध्रुवं सर्वतत्त्वैर्विशुद्धं ज्ञात्वा देवं मुच्यते सर्वपापैः ॥ ३१ ॥",
        hindi = """
            जब योगी अपने पूरी तरह से शुद्ध किए गए आत्मतत्त्व के द्वारा उस परम ब्रह्मतत्त्व को प्रत्यक्ष रूप से देखता है।
            दीपक के समान प्रकाशमान उस आत्म-ज्योति के सहारे वह उस परमेश्वर को अपने ही भीतर प्रकाशित और स्थित अनुभव करता है।
            वह परमात्मा जो अजन्मा (अज) है, जो हमेशा स्थिर और शाश्वत (ध्रुव) है, और जो प्रकृति के सभी तत्वों से पूरी तरह विशुद्ध (परे) है।
            उस दिव्य और परम प्रकाशमय देव को यथार्थ रूप में जान लेने पर वह मनुष्य अपने सभी प्रकार के पापों से हमेशा के लिए मुक्त हो जाता है।
            यहाँ यह रहस्य खोला गया है कि ईश्वर को देखने की आँख कोई भौतिक आँख नहीं, बल्कि हमारी अपनी शुद्ध आत्मा (दीपक) ही है।
            आत्मा और परमात्मा अलग नहीं हैं; आत्मा वह छोटा दीपक है जिसकी लौ उस अनंत परब्रह्म के महा-प्रकाश से जा मिलती है।
            अजन्मा और ध्रुव होने का अर्थ है कि ईश्वर न कभी पैदा होता है और न ही समय के साथ उसमें कोई भी बदलाव आता है।
            प्रकृति के गुण (सत्त्व, रज, तम) उसे छू भी नहीं सकते, क्योंकि वह सभी भौतिक आवरणों से अत्यंत परे और शुद्ध है।
            पापों से मुक्ति का अर्थ कोई चमत्कार नहीं, बल्कि उस अहंकार (मैं शरीर हूँ) का मिट जाना है जो सभी पापों का मूल कारण है।
            जब कर्ता (अहंकार) ही नहीं बचता, तो पाप किस पर लागू होंगे? यही योग और वेदान्त का सबसे बड़ा और अंतिम मोक्ष है।
        """.trimIndent(),
        english = """
            When the Yogi directly beholds the Supreme Brahman-principle through his own thoroughly purified soul-principle.
            Using that self-luminous soul as a shining lamp, he perceives and experiences the Supreme Lord dwelling right within him.
            That Supreme Lord who is unborn (Aja), who is eternally steady and constant (Dhruva), and completely pure of all material elements.
            By truly knowing that divine and supremely radiant Deity, that person is completely liberated from all his sins forever.
            Here the secret is revealed that the eye to see God is not a physical eye, but our own purified soul (the lamp).
            Soul and God are not separate; the soul is the small lamp whose flame merges into the massive light of that infinite Brahman.
            Being unborn and constant means God is never created, nor does He undergo any kind of change with the passage of time.
            The qualities of nature (Sattva, Rajas, Tamas) cannot even touch Him, as He is perfectly pure and beyond all physical sheaths.
            Freedom from sins is not a miracle, but the eradication of the ego (I am the body) which is the root cause of all sins.
            When the doer (ego) itself no longer exists, to whom do the sins apply? This is the greatest ultimate liberation in Yoga.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 32,
        sanskrit = "एष ह देवः प्रदिशोऽनु सर्वाः पूर्वो ह जातः स उ गर्भे अन्तः । स एव जातः स जनिष्यमाणः प्रत्यङ् जनास्तिष्ठति सर्वतोमुखः ॥ ३२ ॥",
        hindi = """
            वास्तव में वही एक परम देव (परमात्मा) सभी दिशाओं और उप-दिशाओं में पूरी तरह से व्याप्त होकर स्थित है।
            वही सबसे पहले हिरण्यगर्भ (ब्रह्मा/सृष्टि का पहला जीव) के रूप में उत्पन्न हुआ था, और वही हर माता के गर्भ के भीतर मौजूद है।
            अब तक जितने भी प्राणी पैदा हुए हैं, वे सब वही हैं; और भविष्य में जो भी पैदा होंगे, वे भी साक्षात् वही परमात्मा हैं।
            हे मनुष्यो! वह हर एक प्राणी के भीतर अंतरात्मा (प्रत्यङ्) के रूप में बैठा हुआ है और उसके मुख सभी दिशाओं में (सर्वतोमुख) हैं।
            यह श्लोक ईश्वर की सर्वव्यापकता (Omnipresence) और उसके अनंत विस्तार का सबसे शक्तिशाली वैदिक उद्घोष है।
            दिशाएं केवल एक भौतिक विचार हैं; सत्य तो यह है कि पूरब, पश्चिम, उत्तर, दक्षिण सब उसी एक चेतना से भरे हुए हैं।
            गर्भ में पल रहा एक नन्हा शिशु भी कोई साधारण जीव नहीं है, वह स्वयं उस विराट ईश्वर की ही एक नई अभिव्यक्ति है।
            संसार में कुछ भी नया पैदा नहीं होता, केवल वही एक अनंत सत्ता अपने-आप को अनगिनत नए रूपों में प्रकट करती रहती है।
            सर्वतोमुख का अर्थ है कि उसकी दृष्टि से कुछ भी छिप नहीं सकता; वह हर कण की गतिविधि को एक साथ और पूरी तरह जानता है।
            जब हम हर चेहरे में उसी एक भगवान का चेहरा (मुख) देखते हैं, तो हमारे भीतर से घृणा और द्वेष हमेशा के लिए समाप्त हो जाते हैं।
        """.trimIndent(),
        english = """
            Indeed, that one Supreme Deity completely pervades and exists in all directions and sub-directions.
            He was the first to be born as Hiranyagarbha (the cosmic creator), and He alone dwells inside every mother's womb.
            All the beings that have been born so far are Him; and all those who will be born in the future are also that very Lord.
            O men! He sits within every single being as the inner soul (Pratyang) and His faces are turned in all directions (Sarvatomukha).
            This verse is the most powerful Vedic proclamation of God's absolute omnipresence and His infinite cosmic expansion.
            Directions are merely a physical concept; the truth is that East, West, North, and South are all filled with that one Consciousness.
            Even a tiny infant growing in the womb is no ordinary creature; it is a fresh manifestation of that vast Supreme Lord Himself.
            Nothing new is ever born in the world; only that one infinite Reality keeps manifesting Itself in countless new forms.
            'Sarvatomukha' means nothing can be hidden from His vision; He knows the activity of every atom simultaneously and perfectly.
            When we begin to see the face of that same God in every human face, hatred and malice vanish from our hearts forever.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 33,
        sanskrit = "यो देवो अग्नौ योऽप्सु यो विश्वं भुवनमाविवेश । य ओषधीषु यो वनस्पतिषु तस्मै देवाय नमो नमः ॥ ३३ ॥",
        hindi = """
            (द्वितीय अध्याय का समापन): जो प्रकाशमय देव अग्नि के भीतर उसकी ताप और चमक के रूप में मौजूद है।
            जो देव जल के भीतर उसकी शीतलता और जीवनदायिनी शक्ति के रूप में बसा हुआ है।
            जिस एक परमात्मा ने इस संपूर्ण विश्व और ब्रह्मांड के कण-कण में प्रवेश किया हुआ है (आविवेश)।
            जो देव पृथ्वी की सभी छोटी औषधियों (Herbs) और विशाल वनस्पतियों (Trees) के भीतर जीवन बनकर धड़क रहा है।
            उस सर्वव्यापी, अनंत और परम कल्याणकारी देव को हमारा बार-बार नमस्कार है, बार-बार प्रणाम है।
            यह श्लोक प्रकृति की पवित्रता और उसमें छिपे हुए ईश्वरीय तत्व (Divine essence) के प्रति गहरी कृतज्ञता व्यक्त करता है।
            आग केवल एक रासायनिक प्रक्रिया (Chemical reaction) नहीं है, वह ईश्वर का ही एक साक्षात् और उग्र रूप है।
            पेड़-पौधे केवल जड़ वस्तुएं नहीं हैं, उनके भीतर भी उसी परमात्मा की चेतना का रस पूरी तरह से प्रवाहित हो रहा है।
            हिंदू दर्शन प्रकृति का शोषण नहीं करता, बल्कि वह प्रकृति के हर रूप में ईश्वर को देखकर उसकी पूजा (नमस्कार) करता है।
            यह सर्वेश्वरवाद (Pantheism) नहीं, बल्कि यह अद्वैत है—ईश्वर दुनिया में भी है और दुनिया से परे भी है।
        """.trimIndent(),
        english = """
            (Conclusion of Chapter 2): The luminous Deity who is present inside the fire as its heat and brilliance.
            The Deity who resides within the water as its coolness and life-giving sustaining power.
            That one Supreme Lord who has completely entered and permeated every single atom of this entire universe.
            The Deity who pulsates as life within all the small herbs of the earth and the giant vegetation (trees).
            To that all-pervading, infinite, and supremely auspicious Deity, we offer our salutations again and again.
            This verse expresses profound gratitude towards the sanctity of nature and the divine essence hidden within it.
            Fire is not just a chemical reaction; it is a direct and fierce manifestation of God Himself.
            Plants and trees are not merely inert objects; the sap of that very Lord's consciousness flows entirely through them.
            Hindu philosophy does not exploit nature; instead, it worships (salutes) it by seeing God in every form of nature.
            This is not mere Pantheism, but pure Advaita—God is completely in the world, yet He exists beyond the world too.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 34,
        sanskrit = "य एको जालवानीशत ईशनीभिः सर्वाँल्लोकानीशत ईशनीभिः । य एवैक उद्भवे सम्भवे च य एतद्विदुरमृतास्ते भवन्ति ॥ ३४ ॥",
        hindi = """
            (तृतीय अध्याय प्रारंभ): वह अद्वितीय परमात्मा माया रूपी जाल का स्वामी (जालवान) है।
            वह अपनी असीम और स्वतंत्र शक्तियों (ईशनीभिः) के द्वारा इस संपूर्ण जगत पर शासन करता है।
            वही एक अकेला ईश्वर अपनी उसी शक्ति से इन सभी लोकों और ब्रह्मांडों को नियंत्रित और संचालित करता है।
            इस संपूर्ण सृष्टि की उत्पत्ति (उद्भव) में और उसके पालन-पोषण (संभव) में भी केवल वही एक कारण रूप में विद्यमान है।
            जो ज्ञानी पुरुष इस परम रहस्य को भलीभांति जान लेते हैं, वे हमेशा के लिए अमर (अमृत) हो जाते हैं।
            माया ईश्वर का जाल है, जिसके माध्यम से वह इस विविधतापूर्ण और रंग-बिरंगे संसार की रचना करता है।
            ईश्वर इस जाल में नहीं फँसता, बल्कि वह इसका स्वामी है; फँसता वह जीव है जो इस जाल को ही अंतिम सत्य मान लेता है।
            संसार का कोई भी नियम या ताकत (Gravity, Time, etc.) ईश्वर की इच्छा के बिना एक इंच भी काम नहीं कर सकती।
            पैदा करने वाला, पालने वाला और अंत करने वाला कोई अलग-अलग देवता नहीं, वह एक ही परब्रह्म है।
            अमर होने का अर्थ शरीर का न मरना नहीं, बल्कि उस परम चेतना के साथ एक हो जाना है जो कभी मरती ही नहीं।
        """.trimIndent(),
        english = """
            (Beginning of Chapter 3): That non-dual Supreme Lord is the master of the net of Maya (Jalavan).
            He rules over this entire universe entirely through His boundless and independent ruling powers (Ishanibhih).
            That one solitary God controls and operates all these worlds and galaxies through that very same power.
            In the creation (origin) of this entire cosmos and in its preservation, He alone exists as the ultimate cause.
            Those wise men who thoroughly realize this supreme mystery become immortal (Amrita) forever.
            Maya is the net of God, through which He beautifully weaves this diverse and colorful universe.
            God does not get caught in this net, He is its master; the soul gets caught when it mistakes the net for the ultimate truth.
            No law or force in the universe (Gravity, Time, etc.) can function even an inch without God's will.
            The Creator, the Preserver, and the Destroyer are not different deities; they are that one Supreme Brahman.
            Being immortal does not mean the body won't die, but becoming one with that Supreme Consciousness which never dies.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 35,
        sanskrit = "एको हि रुद्रो न द्वितीयाय तस्थुर्य इमांल्लोकानीशत ईशनीभिः । प्रत्यङ् जनास्तिष्ठति सञ्चुकोचान्तकाले संसृज्य विश्वा भुवनानि गोपाः ॥ ३५ ॥",
        hindi = """
            वह रुद्र (परमात्मा) केवल एक ही है; ज्ञानी जन उसके अलावा किसी दूसरे (द्वैत) की सत्ता को बिल्कुल स्वीकार नहीं करते हैं।
            वही एक रुद्र अपनी असीम शक्तियों के द्वारा इन सभी लोकों और ब्रह्मांडों पर पूरी तरह से शासन करता है।
            वह रक्षक (गोपा) बनकर इन समस्त भुवनों (लोकों) को रचता है और हर प्राणी के भीतर (प्रत्यङ्) अंतर्यामी रूप में स्थित रहता है।
            और जब अंतकाल (प्रलय) का समय आता है, तब वह अपनी बनाई इस संपूर्ण सृष्टि को समेटकर अपने ही भीतर विलीन कर लेता है।
            उपनिषदों में 'रुद्र' शब्द का प्रयोग किसी पौराणिक देवता के लिए नहीं, बल्कि उस सर्वोच्च निर्गुण ब्रह्म के लिए हुआ है जो दुखों को नष्ट (रुत) करता है।
            यहाँ अद्वैत की स्पष्ट घोषणा है—न द्वितीयाय तस्थुः (कोई दूसरा सत्य खड़ा ही नहीं हो सकता)।
            ईश्वर केवल दुनिया को बनाकर आसमान में नहीं बैठ गया, वह 'गोपा' (रक्षक) बनकर इस दुनिया को लगातार चला रहा है।
            वह हमारे ही दिल में बैठा हुआ हमारे हर विचार और हर कर्म को बड़ी शांति से देख रहा है।
            प्रलय कोई भयानक तबाही नहीं है, यह तो ईश्वर का अपने ही बनाए हुए खेल को वापस अपने भीतर समेट लेना है।
            जैसे मकड़ी अपना जाला बनाती है और फिर उसे निगल लेती है, वैसे ही रुद्र इस सृष्टि को रचता और समेटता है।
        """.trimIndent(),
        english = """
            That Rudra (Supreme Lord) is absolutely one; the wise do not accept the existence of any second entity (duality) at all.
            That one Rudra rules completely over all these worlds and galaxies through His boundless powers.
            As the Protector (Gopa), He creates all these worlds and dwells intimately within every being as the Inner Controller.
            And when the time of the end (dissolution) arrives, He withdraws this entire creation and merges it back into Himself.
            In the Upanishads, the word 'Rudra' does not mean a mythological deity, but the supreme formless Brahman who destroys sorrows.
            Here is a clear declaration of Non-duality—Na dvitiyaya tasthuh (no second truth can even stand before Him).
            God didn't just create the world and sit in the sky; as the 'Gopa' (Protector), He is constantly running this world.
            He is seated right in our own hearts, calmly observing our every single thought and every single action.
            Dissolution is not a terrifying destruction; it is simply God folding His own created play back into Himself.
            Just as a spider spins its web and then swallows it, similarly, Rudra creates and withdraws this universe.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 36,
        sanskrit = "विश्वतश्चक्षुरुत विश्वतोमुखो विश्वतोबाहुरुत विश्वतस्पात् । सं बाहुभ्यां धमति सं पतत्रैर्द्यावाभूमी जनयन् देव एकः ॥ ३६ ॥",
        hindi = """
            उस एक परमात्मा की आँखें हर तरफ (सभी दिशाओं में) हैं; उसके मुख भी हर दिशा में मौजूद हैं।
            उसकी भुजाएं (हाथ) हर तरफ फैले हुए हैं, और उसके पैर भी इस संपूर्ण विश्व में हर जगह स्थित हैं।
            वही एक अद्वितीय देव स्वर्ग (द्यावा) और पृथ्वी (भूमी) को उत्पन्न करके इस पूरी सृष्टि का निर्माण करता है।
            और वह मनुष्यों को उनके हाथों (बाहु) से और पक्षियों को उनके पंखों (पतत्र) से जोड़कर (सृजित कर) प्रेरित करता है।
            यह श्लोक ऋग्वेद से लिया गया है जो ईश्वर के उस असीम 'विश्वरूप' (Cosmic Form) का अत्यंत भव्य वर्णन करता है।
            आँखें, मुख और हाथ यहाँ केवल भौतिक अंग नहीं हैं, बल्कि यह ईश्वर की सर्वज्ञता (Omniscience) और सर्वव्यापकता का प्रतीक है।
            दुनिया के किसी भी कोने में कुछ भी हो रहा हो, वह ईश्वर की आँखों से कभी बच नहीं सकता।
            उसके हाथ हर जगह हैं, इसका मतलब यह है कि प्रकृति का हर काम और हर हलचल उसी की ताकत से हो रही है।
            पक्षी के पंखों का फड़फड़ाना और इंसान के हाथों का चलना—दोनों के पीछे उसी एक भगवान की ऊर्जा काम कर रही है।
            ईश्वर आकाश और पृथ्वी को रचकर उन्हें अपने ही दिव्य अनुशासन और व्यवस्था (Order) में बांध कर रखता है।
        """.trimIndent(),
        english = """
            That one Supreme Lord has eyes everywhere (in all directions); His faces are also present in every direction.
            His arms (hands) extend everywhere, and His feet are fully situated everywhere in this entire universe.
            That single non-dual Deity creates this entire cosmos, giving birth to both heaven and the earth.
            And He endows men with their arms and birds with their wings, continuously inspiring and driving them.
            This verse, taken from the Rigveda, offers an exceedingly magnificent description of God's limitless 'Cosmic Form'.
            Eyes, faces, and hands here are not physical organs, but powerful symbols of God's omniscience and omnipresence.
            Whatever happens in any corner of the world can absolutely never escape the all-seeing eyes of God.
            His hands being everywhere means that every action and movement in nature occurs solely by His power.
            The fluttering of a bird's wings and the movement of a human's hands—the energy of that same God operates behind both.
            Having created heaven and earth, God binds and sustains them within His own divine discipline and cosmic order.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 37,
        sanskrit = "यो देवानां प्रभवश्चोद्भवश्च विश्वाधिपो रुद्रो महर्षिः । हिरण्यगर्भं जनयामास पूर्वं स नो बुद्ध्या शुभया संयुनक्तु ॥ ३७ ॥",
        hindi = """
            वह महान दृष्टा (महर्षि) और रुद्र जो सभी देवताओं का उद्गम (पैदा करने वाला) और उनका परम आश्रय है।
            जो इस संपूर्ण विश्व का एकमात्र अधिपति (मालिक/स्वामी) है और जो सभी शक्तियों का महान स्रोत है।
            जिसने सृष्टि के बिल्कुल आरंभ में सबसे पहले उस 'हिरण्यगर्भ' (ब्रह्मांडीय बुद्धि/ब्रह्मा) को उत्पन्न किया था।
            वह परमेश्वर हम सभी को अत्यंत शुभ, कल्याणकारी और पवित्र बुद्धि (प्रज्ञा) से संयुक्त करे।
            देवता वे हैं जो प्रकाश देते हैं (जैसे सूर्य, इंद्रियां, मन), पर उन सबको प्रकाश देने वाला वह रुद्र ही है।
            महर्षि का अर्थ है वह जो सबसे बड़ा ज्ञानी है और जो भूत, वर्तमान और भविष्य को एक साथ देखता है।
            हिरण्यगर्भ वह पहली चेतना है जिससे यह सारी भौतिक दुनिया बाद में धीरे-धीरे विस्तार पाती है।
            उपनिषद के ऋषि यहाँ भौतिक धन या लंबी उम्र नहीं मांग रहे हैं, वे केवल 'शुभ बुद्धि' की प्रार्थना कर रहे हैं।
            यदि बुद्धि शुभ (पवित्र) हो जाए, तो मनुष्य कभी बुरे कर्म नहीं करेगा और अपने-आप सत्य के मार्ग पर चल पड़ेगा।
            यह प्रार्थना स्पष्ट करती है कि सही समझ (Right understanding) ही जीवन का सबसे बड़ा और कीमती खजाना है।
        """.trimIndent(),
        english = """
            That great seer (Maharshi) and Rudra who is the origin (creator) and the supreme refuge of all the gods.
            Who is the sole overlord (master) of this entire universe and the great source of all cosmic powers.
            Who, at the very beginning of creation, first gave birth to 'Hiranyagarbha' (the cosmic intelligence/Brahma).
            May that Supreme Lord endow and unite all of us with highly auspicious, beneficial, and pure intellect.
            Gods are those who give light (like the sun, senses, mind), but Rudra is the one who gives light to all of them.
            Maharshi means the greatest knower who simultaneously sees the past, the present, and the future.
            Hiranyagarbha is that initial consciousness from which this entire physical world later expands gradually.
            The sages of the Upanishad do not ask for material wealth or long life here; they pray only for an 'auspicious intellect'.
            If the intellect becomes auspicious (pure), a person will never commit evil deeds and will naturally walk the path of Truth.
            This prayer clearly establishes that right understanding is the greatest and most precious treasure of human life.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 38,
        sanskrit = "या ते रुद्र शिवा तनूरघोराऽपापकाशिनी । तया नस्तन्वा शन्तमया गिरिशन्ताभिचाकशीहि ॥ ३८ ॥",
        hindi = """
            हे रुद्र! आपकी जो मूर्ति (तनू) अत्यंत कल्याणकारी (शिवा), सौम्य (अघोरा) और परम शांतिदायक है।
            जो मूर्ति किसी भी प्रकार के पाप या अज्ञान को प्रकट नहीं करती (अपापकाशिनी), बल्कि उन्हें पूरी तरह नष्ट कर देती है।
            हे कैलाश पर्वत पर निवास कर सुख देने वाले (गिरिशन्त)! आप अपनी उस परम सुखदायक और मंगलमयी मूर्ति से।
            हम पर हमेशा कृपा दृष्टि बनाए रखें और हमारे अंतःकरण को अपने दिव्य प्रकाश से पूरी तरह प्रकाशित करें।
            ईश्वर के दो रूप माने गए हैं—एक भयानक (घोर) जो पापियों को दंड देता है, और दूसरा सौम्य (अघोर) जो भक्तों को तारता है।
            साधक यहाँ भगवान के उस शांत और प्रेमपूर्ण स्वरूप का ध्यान कर रहा है जो अज्ञान के अंधकार को मिटाता है।
            'गिरिशन्त' का अर्थ केवल पहाड़ पर रहने वाला नहीं, बल्कि हमारी वाणी (गिरा) और हृदय के भीतर शांत रहने वाला परब्रह्म है।
            ईश्वर का स्वरूप पाप से पूरी तरह अछूता (अपाप) है; जब हम उस पर ध्यान लगाते हैं, तो हमारे भीतर के विकार भी जल जाते हैं।
            यह श्लोक भक्ति और प्रेम का एक अत्यंत सुंदर उदाहरण है, जहाँ भय की जगह केवल ईश्वरीय कृपा की याचना है।
            प्रार्थना यह है कि भगवान का वह सौम्य रूप हमारे जीवन के हर अंधेरे कोने को ज्ञान के उजाले से भर दे।
        """.trimIndent(),
        english = """
            O Rudra! That form (Tanu) of Yours which is supremely auspicious (Shiva), gentle (Aghora), and extremely pacifying.
            That form which reveals no sin or ignorance (Apapakashini), but rather completely destroys them.
            O You who dwell on the mountain granting happiness (Girishanta)! With that supremely blissful and benevolent form of Yours.
            Please look upon us always with grace and completely illuminate our inner being with Your divine light.
            God is considered to have two forms—a terrifying one (Ghora) that punishes sinners, and a gentle one (Aghora) that saves devotees.
            The seeker here is meditating on that calm and loving form of God which eradicates the darkness of ignorance.
            'Girishanta' doesn't just mean a mountain-dweller; it means the Brahman who brings peace to our speech (Gira) and heart.
            God's nature is completely untouched by sin (Apapa); when we meditate on it, our internal impurities are also burnt away.
            This verse is an extremely beautiful example of devotion and love, where instead of fear, there is only a plea for divine grace.
            The prayer is that God's gentle form may fill every dark corner of our lives with the bright light of ultimate wisdom.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 39,
        sanskrit = "यामिषुं गिरिशन्त हस्ते बिभर्ष्यस्तवे । शिवां गिरित्र तां कुरु मा हिंसीः पुरुषं जगत् ॥ ३९ ॥",
        hindi = """
            हे कैलाश पर निवास करने वाले और सुख प्रदान करने वाले प्रभु (गिरिशन्त)!
            अज्ञान और पापों का नाश करने के लिए आपने अपने हाथ में जो भयानक बाण (इषुं) धारण किया हुआ है।
            हे वाणी और पर्वतों के रक्षक (गिरित्र)! कृपया आप अपने उस बाण को अत्यंत कल्याणकारी (शिव) बना दें।
            आप हमारे शरीर (पुरुष), हमारे संसार (जगत) और हमारे प्रियजनों का विनाश (हिंसा) न करें।
            यह श्लोक ईश्वर के संहारक रूप (Destroyer aspect) के सामने एक विनम्र और भयभीत भक्त की पुकार है।
            भगवान का बाण मृत्यु, बीमारी और दुखों का प्रतीक है जो हमारे बुरे कर्मों के परिणाम के रूप में हम पर गिरता है।
            साधक प्रार्थना कर रहा है कि वह बाण हमारे भौतिक शरीर को नष्ट करने की बजाय हमारे भीतर के अहंकार और पापों को नष्ट करे।
            ईश्वर का दंड भी कल्याणकारी (शिव) हो सकता है यदि वह हमें सुधारने और ज्ञान के मार्ग पर लाने के लिए हो।
            यह जीवन और जगत अनमोल है; भक्त चाहता है कि वह जिंदा रहकर इसी शरीर में ईश्वर की महिमा का गुणगान कर सके।
            यह प्रार्थना हमें ईश्वर के न्याय के प्रति सम्मान और उसकी अपार करुणा के प्रति विश्वास सिखाती है।
        """.trimIndent(),
        english = """
            O Lord who dwells on the mountain and grants happiness (Girishanta)!
            That terrifying arrow (Ishum) which You hold in Your hand ready to shoot to destroy ignorance and sins.
            O Protector of the mountains and speech (Giritra)! Please make that arrow of Yours extremely auspicious (Shiva).
            Do not destroy (harm) our physical body (Purusha), our world (Jagat), and our beloved ones.
            This verse is the plea of a humble and fearful devotee facing the destructive aspect of the Supreme Lord.
            God's arrow symbolizes death, disease, and sorrows that fall upon us as a consequence of our bad karmas.
            The seeker prays that instead of destroying our physical bodies, the arrow should destroy our inner ego and sins.
            Even God's punishment can be auspicious (Shiva) if it is meant to correct us and bring us to the path of wisdom.
            This life and world are precious; the devotee wishes to stay alive to sing the glories of God in this very body.
            This prayer teaches us deep respect for God's justice and unwavering faith in His immense compassion.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 40,
        sanskrit = "ततः परं ब्रह्मपरं बृहन्तं यथानिकायं सर्वभूतेषु गूढम् । विश्वस्यैकं परिवेष्टितारमीशं तं ज्ञात्वाऽमृता भवन्ति ॥ ४० ॥",
        hindi = """
            इस भौतिक जगत और ब्रह्मा (हिरण्यगर्भ) से भी बहुत परे वह महान और सबसे बड़ा (बृहन्तं) परब्रह्म स्थित है।
            वह परमेश्वर प्रत्येक प्राणी के भीतर उनके शरीर के आकार (यथानिकायं) के अनुसार गहराई से छिपा हुआ (गूढ़) है।
            वह एक अद्वितीय (एकं) ईश्वर ही इस संपूर्ण विश्व को चारों ओर से घेरे हुए (परिवेष्टितारं) और व्याप्त है।
            उस सर्वव्यापी और परम शासक (ईश) को यथार्थ रूप में जान लेने पर मनुष्य हमेशा के लिए अमर (अमृत) हो जाते हैं।
            ईश्वर इतना बड़ा है कि वह पूरे ब्रह्मांड को अपने भीतर समेटे हुए है (बृहन्तं)।
            और साथ ही वह इतना सूक्ष्म है कि चींटी के भीतर चींटी के आकार का और हाथी के भीतर हाथी के आकार का होकर छिपा है।
            वह दूर सातवें आसमान पर नहीं बैठा है, बल्कि वह हमारे ही दिल की धड़कन में एक रहस्य की तरह छिपा हुआ है।
            ईश्वर ने दुनिया को ऐसे लपेटा हुआ है जैसे किसी धागे ने कपड़े को चारों तरफ से बुना हुआ हो।
            अमर होने का अर्थ शारीरिक मौत से बचना नहीं, बल्कि उस अनंत चेतना का हिस्सा बन जाना है जो कभी नहीं मरती।
            यह श्लोक ईश्वर की 'ट्रांसेंडेंस' (दुनिया से परे) और 'इमॅनेंस' (दुनिया के भीतर) दोनों को एक साथ बहुत खूबसूरती से जोड़ता है।
        """.trimIndent(),
        english = """
            Far beyond this physical world and Brahma (Hiranyagarbha) exists that great and vast (Brihantam) Supreme Brahman.
            That Supreme Lord is deeply hidden (Gudha) within every single being according to the size and shape of their bodies.
            That one non-dual (Ekam) God alone completely envelops (encompasses) and pervades this entire universe from all sides.
            By truly realizing that all-pervading and supreme Ruler (Isha), human beings become immortal (Amrita) forever.
            God is so phenomenally vast that He encompasses the entire universe within Himself (Brihantam).
            And at the same time, He is so subtle that He hides within an ant in the size of an ant, and within an elephant in the size of an elephant.
            He is not sitting in some distant seventh heaven; rather, He is hidden like a deep mystery in our very heartbeat.
            God has enveloped the world in the same way a thread is completely woven throughout a piece of cloth.
            Becoming immortal does not mean escaping physical death, but becoming a part of that infinite consciousness that never dies.
            This verse beautifully unites both the 'Transcendence' (beyond the world) and 'Immanence' (within the world) of God simultaneously.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 41,
        sanskrit = "वेदाहमेतं पुरुषं महान्तमादित्यवर्णं तमसः परस्तात् । तमेव विदित्वाति मृत्युमेति नान्यः पन्था विद्यतेऽयनाय ॥ ४१ ॥",
        hindi = """
            (ऋषि अत्यंत दृढ़ता से उद्घोष करते हैं): मैं उस महान और अनंत परम पुरुष को प्रत्यक्ष रूप से जानता हूँ।
            वह पुरुष जो सूर्य (आदित्य) के समान अत्यंत प्रकाशमान है और जो अज्ञान रूपी अंधकार से पूरी तरह परे है।
            केवल और केवल उस परब्रह्म को यथार्थ रूप में जान लेने पर ही मनुष्य मृत्यु (और मृत्यु के भय) को पार कर सकता है।
            मोक्ष प्राप्त करने और इस संसार सागर से तरने के लिए इसके अलावा अन्य कोई दूसरा मार्ग बिल्कुल भी नहीं है।
            यह यजुर्वेद और श्वेताश्वतर उपनिषद का सबसे शक्तिशाली और प्रसिद्ध मंत्र है जो गुरु के सीधे अनुभव को बताता है।
            ऋषि यहाँ 'मुझे लगता है' या 'मैंने पढ़ा है' नहीं कह रहे हैं, वे सीना ठोक कर कह रहे हैं 'वेदाहम्' (मैं जानता हूँ)।
            ईश्वर सूर्य की तरह स्वयं प्रकाशमान है; जहाँ वह है, वहाँ अज्ञान, संदेह या दुख का कोई अँधेरा टिक नहीं सकता।
            मृत्यु को पार करने का अर्थ है इस भ्रम को तोड़ देना कि 'मैं यह नश्वर शरीर हूँ'।
            ज्ञान के बिना किए गए सारे कर्म और पूजा-पाठ केवल तैयारी हैं; अंतिम आज़ादी केवल सत्य को जानने से ही मिलती है।
            यह श्लोक मानव जाति के लिए आशा की एक महान किरण है कि मृत्यु अंत नहीं है, परम प्रकाश हमारा इंतजार कर रहा है।
        """.trimIndent(),
        english = """
            (The Sage declares with absolute conviction): I directly know that great, infinite, and Supreme Person.
            That Person who is intensely radiant like the sun (Aditya) and who is completely beyond the darkness of ignorance.
            Only and exclusively by truly knowing that Supreme Brahman can a person cross over death (and the fear of death).
            There is absolutely no other path available for attaining liberation and crossing this ocean of worldly existence.
            This is the most powerful and famous mantra of the Yajurveda and Shvetashvatara Upanishad, expressing the Guru's direct experience.
            The sage is not saying 'I think' or 'I have read'; he is boldly declaring with absolute certainty 'Vedaham' (I know).
            God is self-luminous like the sun; where He is, no darkness of ignorance, doubt, or sorrow can ever survive.
            Crossing over death simply means breaking the deep illusion that 'I am this perishable physical body'.
            All rituals and worship done without wisdom are merely preparations; ultimate freedom comes solely from knowing the Truth.
            This verse is a great ray of hope for humanity, proving that death is not the end, and the Supreme Light awaits us.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 42,
        sanskrit = "यस्मात् परं नापरमस्ति किञ्चिद् यस्मान्नाणीयो न ज्यायोऽस्ति कश्चित् । वृक्ष इव स्तब्धो दिवि तिष्ठत्येकस्तेनेदं पूर्णं पुरुषेण सर्वम् ॥ ४२ ॥",
        hindi = """
            जिस परमात्मा से श्रेष्ठ या उससे परे इस पूरे ब्रह्मांड में अन्य कुछ भी (किञ्चित्) नहीं है।
            जिससे अधिक सूक्ष्म (अणीय) कुछ नहीं है, और जिससे अधिक विशाल (ज्याय) भी दूसरा कोई नहीं है।
            जो एक अद्वितीय वृक्ष के समान बिना किसी कंपन के अपने ही दिव्य प्रकाश (दिवि) में बिल्कुल स्थिर खड़ा है।
            उसी एक महान परम पुरुष (परमात्मा) के द्वारा यह संपूर्ण चराचर जगत पूरी तरह से भरा हुआ (पूर्ण) है।
            परमात्मा ही अस्तित्व की अंतिम सीमा है; उसके आगे कोई कारण या कोई शक्ति नहीं है।
            वह अणु से भी छोटा होकर परमाणु में छिपा है और आकाश से भी बड़ा होकर पूरे ब्रह्मांड को निगले हुए है।
            संसार में सब कुछ बदल रहा है, सब कुछ हिल रहा है, पर वह परमात्मा एक विशाल पेड़ की तरह अचंचल और शांत है।
            वह स्थिर होकर भी अपनी ऊर्जा से इस पूरे ब्रह्मांड के रोम-रोम को भर देता है।
            जब हम उस पूर्णता (Wholeness) को महसूस करते हैं, तो हमारे भीतर का खालीपन और अकेलापन हमेशा के लिए खत्म हो जाता है।
            यह श्लोक ईश्वर की परिपूर्णता (Perfection) और उसकी स्थिरता (Stillness) का एक अत्यंत सुंदर और काव्यात्मक वर्णन है।
        """.trimIndent(),
        english = """
            There is absolutely nothing (whatsoever) higher than or beyond that Supreme Lord in this entire universe.
            There is no one who is subtler (smaller) than Him, and there is no one who is vaster (greater) than Him.
            Who stands absolutely motionless like a unique, steady tree rooted in His own divine radiant space (heaven).
            By that one great Supreme Person alone is this entire universe of moving and unmoving things completely filled.
            The Supreme Lord is the ultimate limit of existence; there is no cause or power beyond Him at all.
            He hides in an atom being smaller than the sub-atomic, and swallows the cosmos being larger than space itself.
            Everything in the world is changing and moving, but God remains completely unmoving and calm like a massive tree.
            Despite being perfectly still, He fills every single pore of this entire universe with His boundless energy.
            When we realize and feel that Wholeness, the emptiness and loneliness within us completely disappear forever.
            This verse is an exquisitely beautiful and poetic description of God's absolute perfection and His profound stillness.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 43,
        sanskrit = "ततो यदुत्तरतरं तदरूपमनामयम् । य एतद्विदुरमृतास्ते भवन्त्यथेतरे दुःखमेवापियन्ति ॥ ४३ ॥",
        hindi = """
            इस संपूर्ण दृश्यमान भौतिक जगत से जो बहुत परे (उत्तरतर) और अत्यंत श्रेष्ठ है।
            वह परब्रह्म किसी भी भौतिक आकार (अरूप) से रहित है और सभी प्रकार के दुखों और दोषों (अनामय) से पूरी तरह मुक्त है।
            जो ज्ञानी पुरुष इस परम सत्य को जान लेते हैं, वे हमेशा के लिए अमर (जन्म-मृत्यु से मुक्त) हो जाते हैं।
            किंतु जो लोग इस सत्य को नहीं जानते, वे बेचारे दूसरे लोग (अज्ञानी) केवल दुख को ही प्राप्त करते हैं।
            हमारा संसार रूपों (Forms) का संसार है, जो भी रूप में है वह एक दिन नष्ट होगा।
            ईश्वर 'अरूप' है, इसलिए समय या मृत्यु उसका बाल भी बांका नहीं कर सकते।
            'अनामय' का अर्थ है पूर्ण रूप से स्वस्थ और पवित्र; जहाँ न शारीरिक बीमारी है न मानसिक तनाव।
            उपनिषद यहाँ बहुत स्पष्ट चेतावनी देता है: अज्ञान का अंतिम परिणाम केवल और केवल दुख है।
            दुनिया की कोई भी संपत्ति या रिश्ता हमें दुखों से नहीं बचा सकता, केवल आत्मज्ञान ही हमें बचा सकता है।
            जो उस निराकार और निर्दोष सत्य के साथ जुड़ जाता है, वह स्वयं भी उसी के समान निर्दोष और अमर हो जाता है।
        """.trimIndent(),
        english = """
            That which is far beyond (higher than) this entire visible, manifest physical universe.
            That Supreme Brahman is completely devoid of any physical form (Arupa) and is entirely free from all sorrows and defects (Anamaya).
            Those wise men who truly realize this Supreme Truth become immortal (freed from birth and death) forever.
            But those poor others (the ignorant) who do not know this Truth, attain nothing but sorrow and suffering.
            Our world is a world of forms; whatever exists in a form will undoubtedly perish one day.
            God is 'formless' (Arupa), which is exactly why time or death cannot touch even a hair of His existence.
            'Anamaya' means perfectly healthy and pure; where there is neither physical disease nor mental stress.
            The Upanishad gives a very clear warning here: the ultimate result of ignorance is only and exclusively sorrow.
            No wealth or worldly relationship can save us from misery; only Self-knowledge can truly rescue us.
            He who unites with that formless and flawless Truth becomes as flawless and immortal as the Truth itself.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 44,
        sanskrit = "सर्वाननशिरोग्रीवः सर्वभूतगुहाशयः । सर्वव्यापी स भगवांस्तस्मात् सर्वगतः शिवः ॥ ४४ ॥",
        hindi = """
            इस ब्रह्मांड में जितने भी मुख (चेहरे), सिर और गर्दनें हैं, वे सब वास्तव में उसी एक परमात्मा के ही हैं।
            वह परमेश्वर सभी छोटे-बड़े प्राणियों के हृदय रूपी गुफा (गुहाशय) में गहराई से निवास करता है।
            वह भगवान सर्वव्यापी है, अर्थात दुनिया की कोई भी जगह या कण उसकी उपस्थिति से खाली नहीं है।
            इसलिए वह अत्यंत कल्याणकारी (शिव) परमात्मा हर वस्तु और हर प्राणी के भीतर (सर्वगत) मौजूद है।
            हम जो भी चेहरा देखते हैं—चाहे वह दोस्त का हो, जानवर का हो या दुश्मन का—वह उसी भगवान का एक रूप है।
            यदि हम इस सत्य को समझ लें, तो हम किसी भी व्यक्ति का अपमान या हिंसा कैसे कर सकते हैं?
            ईश्वर केवल आसमान में नहीं बैठा है, वह हमारी और हर जीव की धड़कन (गुहा) में छिपा हुआ है।
            सर्वव्यापी होने का अर्थ है कि वह हवा की तरह सब जगह है, और शिव होने का अर्थ है कि वह हमेशा हमारा भला चाहता है।
            यह श्लोक हमें सिखाता है कि पूजा केवल मंदिरों तक सीमित नहीं है; हर प्राणी की सेवा ही भगवान की असली पूजा है।
            जब हम पूरी दुनिया को ईश्वर का ही शरीर मान लेते हैं, तो हमारा जीवन स्वतः ही एक पवित्र यज्ञ बन जाता है।
        """.trimIndent(),
        english = """
            All the faces, heads, and necks that exist in this entire universe actually belong solely to that one Supreme Lord.
            That Supreme God deeply resides within the cave of the heart (Guhashaya) of all great and small beings.
            That Lord is all-pervading, meaning no place or sub-atomic particle in the world is empty of His divine presence.
            Therefore, that supremely auspicious (Shiva) Lord is present within every object and every single creature (Sarvagata).
            Whatever face we see—whether it is of a friend, an animal, or an enemy—is simply a manifestation of that same God.
            If we truly understand this profound truth, how could we possibly insult or commit violence against anyone?
            God is not merely sitting in the sky; He is intimately hidden within our own heartbeat and that of every creature.
            Being all-pervading means He is everywhere like the air, and being Shiva means He always desires our ultimate welfare.
            This verse teaches us that worship is not limited to temples; serving every being is the real, true worship of God.
            When we consider the entire world to be the body of God, our life automatically transforms into a sacred sacrifice.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 45,
        sanskrit = "महान् प्रभुर्वै पुरुषः सत्त्वस्यैष प्रवर्तकः । सुनिर्मलामिमां प्राप्तिमीशानो ज्योतिरव्ययः ॥ ४५ ॥",
        hindi = """
            वह परम पुरुष वास्तव में एक बहुत ही महान प्रभु (सबका सर्वसमर्थ स्वामी) है।
            वही एकमात्र ईश्वर सभी प्राणियों के भीतर अंतःकरण (सत्त्व) और शुभ प्रवृत्तियों को प्रेरित करने वाला (प्रवर्तक) है।
            वह हमें उस अत्यंत निर्मल, पवित्र और शांत अवस्था (मोक्ष) की प्राप्ति की ओर ले जाता है।
            वह सबका नियंता (ईशान), प्रकाश का साक्षात् स्वरूप (ज्योति) और कभी न नष्ट होने वाला (अव्यय) है।
            ईश्वर केवल एक मूक दर्शक नहीं है; वह हमारी बुद्धि को सही दिशा में धकेलने वाला (प्रवर्तक) गाइड भी है।
            जब हमारे मन में कोई अच्छा विचार या दया की भावना आती है, तो वह उसी प्रभु की प्रेरणा होती है।
            मोक्ष (सुनिर्मल प्राप्ति) कोई भौतिक जगह नहीं है, यह मन की वह अवस्था है जहाँ कोई मैल या स्वार्थ नहीं बचता।
            'ईशान' का अर्थ है कि वह पूरी सृष्टि का अकेला राजा है, और उसकी मर्जी के बिना एक पत्ता भी नहीं हिलता।
            वह स्वयं ज्योति (ज्ञान) है, जो हमारे भीतर के अज्ञान के अंधेरे को बिना किसी प्रयास के नष्ट कर देता है।
            अव्यय होने का अर्थ है कि चाहे कितने भी ब्रह्मांड बनें और मिटें, उसकी ऊर्जा में कभी कोई कमी नहीं आती।
        """.trimIndent(),
        english = """
            That Supreme Person is indeed a phenomenally great Lord (the all-powerful Master of absolutely everything).
            He alone is the prime impeller (Pravartaka) who inspires the inner being (Sattva) and noble tendencies within all creatures.
            He is the one who leads us towards the attainment of that extremely immaculate, pure, and tranquil state of liberation (Moksha).
            He is the absolute controller of all (Ishana), the direct embodiment of Light (Jyoti), and utterly imperishable (Avyaya).
            God is not merely a silent spectator; He is also the active guide (Pravartaka) pushing our intellect in the right direction.
            Whenever a good thought or a feeling of deep compassion arises in our minds, it is an inspiration from that very Lord.
            Moksha (the immaculate attainment) is not a physical place; it is a state of mind where no impurity or selfishness remains.
            'Ishana' means He is the sole King of the cosmos, and without His will, not even a single leaf can move.
            He Himself is Light (Wisdom), which effortlessly destroys the thick darkness of ignorance within us completely.
            Being imperishable (Avyaya) means that no matter how many universes are created and destroyed, His energy never diminishes.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 46,
        sanskrit = "अङ्गुष्ठमात्रः पुरुषोऽन्तरात्मा सदा जनानां हृदये सन्निविष्टः । हृदा मन्वीशो मनसाभिक्लृप्तो य एतद्विदुरमृतास्ते भवन्ति ॥ ४६ ॥",
        hindi = """
            वह परम पुरुष (परमात्मा) अँगूठे के आकार (अंगुष्ठमात्र) का होकर अंतरात्मा के रूप में स्थित है।
            वह हमेशा (सदा) सभी मनुष्यों और प्राणियों के हृदय के भीतर गहराई से बैठा हुआ (सन्निविष्ट) है।
            हृदय (भाव) और मन (विचार) के द्वारा ही उस सर्वसमर्थ ईश्वर (मन्वीश) को पूरी तरह से जाना और अनुभव किया जा सकता है।
            जो ज्ञानी मनुष्य इस रहस्य को भलीभांति जान लेते हैं, वे हमेशा के लिए अमर हो जाते हैं।
            क्या ईश्वर सच में अँगूठे जितना छोटा है? नहीं, यह केवल ध्यान (Meditation) करने के लिए एक रूपक (Metaphor) है।
            चूंकि इंसान का हृदय मुट्ठी के आकार का होता है, इसलिए ध्यान के लिए आत्मा की ज्योति को अँगूठे के आकार का माना गया है।
            ईश्वर को खोजना बाहर की दुनिया में समय बर्बाद करना है, वह तो हमारे अपने सीने में धड़क रहा है।
            ईश्वर को केवल सूखी बुद्धि (तर्क) से नहीं पाया जा सकता; उसे जानने के लिए हृदय (प्रेम/भक्ति) और मन (एकाग्रता) दोनों चाहिए।
            जब भावना और विचार एक दिशा में केंद्रित हो जाते हैं, तब सत्य का परदा अपने आप गिर जाता है।
            यह श्लोक कठोपनिषद में भी आता है, जो योगियों के लिए आत्मा पर ध्यान लगाने की सबसे सटीक और पुरानी विधि है।
        """.trimIndent(),
        english = """
            That Supreme Person (God) dwells as the Inner Soul in the size of a thumb (Angushtamatra).
            He is always (constantly) seated deeply within the hearts of all humans and living beings.
            That all-powerful Lord (Manvisha) can be fully known and experienced only through the heart (emotion) and the mind (thought).
            Those wise people who thoroughly understand this profound mystery become completely immortal forever.
            Is God really as small as a thumb? No, this is purely a metaphor specifically used for the purpose of meditation.
            Since the human physical heart is about the size of a fist, the light of the soul is imagined as thumb-sized for concentration.
            Searching for God in the outside world is a waste of time; He is pulsating right within our own chest.
            God cannot be attained by dry intellect (logic) alone; knowing Him requires both the heart (love/devotion) and the mind (focus).
            When emotion and thought become concentrated in a single direction, the veil of truth drops automatically.
            This verse also appears in the Katha Upanishad and provides the most precise and ancient method for yogis to meditate on the Soul.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 47,
        sanskrit = "सहस्रशीर्षा पुरुषः सहस्राक्षः सहस्रपात् । स भूमिं विश्वतो वृत्वात्यतिष्ठद्दशाङ्गुलम् ॥ ४७ ॥",
        hindi = """
            उस परम पुरुष (ईश्वर) के हजारों (अनंत) सिर हैं, उसकी हजारों आँखें हैं, और उसके हजारों पैर हैं।
            उस विराट परमात्मा ने इस पूरी पृथ्वी (ब्रह्मांड) को सब तरफ से (विश्वतः) पूरी तरह घेर रखा है।
            और वह पूरे ब्रह्मांड को घेरने के बाद भी उससे दस अंगुल (दशांगुल) ऊपर और परे स्थित है।
            यह ऋग्वेद के प्रसिद्ध 'पुरुष सूक्त' का पहला मंत्र है, जो ईश्वर के विश्वरूप का वर्णन करता है।
            हजारों सिर, आँखें और पैर का मतलब है कि दुनिया में जितने भी जीव हैं, वे सब उसी ईश्वर के अंग हैं।
            हर इंसान का दिमाग उसी का है, हर आँख से वही देख रहा है, और हर पैर से वही चल रहा है।
            ईश्वर ब्रह्मांड के भीतर तो है, पर ब्रह्मांड उसकी सीमा नहीं है; वह ब्रह्मांड से भी बहुत बड़ा है।
            'दस अंगुल परे' होने का अर्थ है कि वह इस दृश्यमान भौतिक दुनिया (Matter) के पूरी तरह पार (Transcendental) है।
            हम जो कुछ भी अपनी आँखों से या दूरबीन से देख सकते हैं, ईश्वर उस सबसे कहीं अधिक विशाल है।
            यह श्लोक अद्वैत (Non-duality) का चरम है—यहाँ कुछ भी ऐसा नहीं है जो ईश्वर न हो।
        """.trimIndent(),
        english = """
            That Supreme Person (God) has thousands (infinite) of heads, thousands of eyes, and thousands of feet.
            That colossal Supreme Lord has completely enveloped this entire earth (universe) from all sides (Vishvatah).
            And even after entirely encompassing the whole universe, He stands ten fingers (Dashangulam) above and beyond it.
            This is the first mantra of the famous 'Purusha Sukta' of the Rigveda, describing God's magnificent cosmic form.
            Thousands of heads, eyes, and feet mean that all the living beings in the world are simply limbs of that same God.
            Every human's brain is His, He is seeing through every eye, and He is walking through every foot.
            God is indeed inside the universe, but the universe is not His limit; He is phenomenally vaster than the universe.
            Being 'ten fingers beyond' means that He is completely transcendental to this entire visible physical world (matter).
            Whatever we can see with our eyes or powerful telescopes, God is boundlessly more vast than all of that combined.
            This verse is the pinnacle of Non-duality (Advaita)—there is absolutely nothing here that is not God.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 48,
        sanskrit = "पुरुष एवेदं सर्वं यद् भूतं यच्च भव्यम् । उतामृतत्वस्येशानो यदन्नेनातिरोहति ॥ ४८ ॥",
        hindi = """
            यह जो कुछ भी संपूर्ण जगत दिखाई दे रहा है, वह वास्तव में वह परम पुरुष (परमात्मा) ही है।
            अतीत में जो कुछ था, और भविष्य में जो कुछ भी होने वाला है, वह सब भी वही परम पुरुष है।
            वह परमात्मा ही अमृतत्व (मोक्ष/अमरता) का एकमात्र स्वामी (ईशान) और देने वाला है।
            और वह इसलिए इस जगत का रूप धारण करता है ताकि जीव अन्न (कर्मफल) के द्वारा अपने विकास को प्राप्त कर सकें।
            समय के तीन टुकड़े (भूत, वर्तमान, भविष्य) केवल हमारे लिए हैं, ईश्वर के लिए सब कुछ एक ही 'अब' (Now) है।
            सृष्टि का कोई भी हिस्सा, चाहे वह जड़ हो या चेतन, उस पुरुष से अलग नहीं हो सकता।
            ईश्वर ही वह शक्ति है जो हमें मौत के डर से निकालकर अमरता (अमृतत्व) का अनुभव कराती है।
            उसने यह दुनिया खेल या सजा के लिए नहीं बनाई, बल्कि जीवों को उनके कर्मों के माध्यम से विकसित होने का मौका देने के लिए बनाई है।
            'अन्न' का अर्थ यहाँ भौतिक शरीर और सांसारिक अनुभव हैं, जिनके सहारे आत्मा अज्ञान से ज्ञान की ओर बढ़ती है।
            यह श्लोक बताता है कि संसार एक पाठशाला है, और ईश्वर ही वह स्कूल और उसका प्रिंसिपल दोनों है।
        """.trimIndent(),
        english = """
            All this entire universe that is visible right now is, in reality, nothing but that Supreme Person (God).
            Whatever existed in the past, and whatever will exist in the future, all of that is also that very Supreme Person.
            That Supreme Lord is the sole master (Ishana) and the bestower of Immortality (Moksha/eternal life).
            And He assumes the form of this world so that souls can achieve their evolution through food (fruits of karma).
            The three divisions of time (past, present, future) are only for us; for God, everything is one single eternal 'Now'.
            No part of creation, whether inert or conscious, can ever possibly be separate from that Supreme Person.
            God alone is that power which pulls us out of the fear of death and makes us experience true Immortality.
            He didn't create this world as a mere game or punishment, but to give souls a chance to evolve through their actions.
            'Food' here refers to the physical body and worldly experiences, relying on which the soul grows from ignorance to wisdom.
            This verse explains that the world is a school, and God is both the school itself and its ultimate Principal.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 49,
        sanskrit = "सर्वतः पाणिपादं तत् सर्वतोऽक्षिशिरोमुखम् । सर्वतः श्रुतिमल्लोके सर्वमावृत्य तिष्ठति ॥ ४९ ॥",
        hindi = """
            उस परब्रह्म के हाथ और पैर इस ब्रह्मांड में हर तरफ और सभी दिशाओं में (सर्वतः) फैले हुए हैं।
            उसकी आँखें, उसके सिर और उसके मुख हर जगह मौजूद हैं (वह सब कुछ एक साथ देख और जान रहा है)।
            इस संपूर्ण लोक (संसार) में उसके कान हर तरफ मौजूद हैं (वह हर छोटी-से-छोटी आवाज़ और प्रार्थना सुनता है)।
            वह परमेश्वर इस संपूर्ण ब्रह्मांड को चारों ओर से पूरी तरह घेरकर (आवृत्य) स्थिर रूप से मौजूद है।
            यह श्लोक भी भगवद्गीता (13.13) में आता है और ईश्वर के निर्गुण-सगुण रूप का अद्भुत वर्णन करता है।
            हम जो भी काम करते हैं, वह ईश्वर के हाथों से ही हो रहा है, क्योंकि हमारी ऊर्जा उसकी ही है।
            हम जहाँ भी जाते हैं, वह हमें देख रहा है; हम जो भी सोचते हैं, वह उसे सुन रहा है।
            इसलिए ज्ञानी पुरुष कभी एकांत में भी पाप नहीं करता, क्योंकि वह जानता है कि वह कभी अकेला नहीं है।
            ईश्वर कोई व्यक्ति नहीं है जो एक जगह बैठा हो; वह तो आकाश की तरह हर जगह व्याप्त चेतना है।
            जब साधक को इसका एहसास होता है, तो वह हर जगह, हर समय गहरी सुरक्षा और शांति महसूस करता है।
        """.trimIndent(),
        english = """
            The hands and feet of that Supreme Brahman extend everywhere and in all directions (Sarvatah) in this universe.
            His eyes, His heads, and His faces are present absolutely everywhere (He sees and knows everything simultaneously).
            His ears are present all around in this entire world (He hears every single tiny sound and unspoken prayer).
            That Supreme Lord exists steadily, having completely enveloped (covered) this entire cosmos from all sides.
            This verse also appears in the Bhagavad Gita (13.13) and provides an amazing description of God's formless-yet-formed nature.
            Whatever action we perform is actually being done by God's hands, because our very energy is His alone.
            Wherever we go, He is watching us; whatever we even think, He is clearly listening to it.
            Therefore, a wise man never commits a sin even in absolute isolation, because he knows he is never alone.
            God is not a person sitting in one specific place; He is the consciousness pervading everywhere like space itself.
            When a seeker realizes this deeply, he feels profound security and perfect peace everywhere, all the time.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 50,
        sanskrit = "सर्वेन्द्रियगुणाभासं सर्वेन्द्रियविवर्जितम् । सर्वस्य प्रभुमीशानं सर्वस्य शरणं सुहृत् ॥ ५० ॥",
        hindi = """
            वह परमात्मा सभी इंद्रियों (आँख, कान आदि) के गुणों (देखना, सुनना) को प्रकाशित करने वाला है।
            फिर भी वह स्वयं सभी प्रकार की इंद्रियों और उनके भौतिक आकारों से पूरी तरह रहित (विवर्जित) है।
            वह संपूर्ण चराचर जगत का परम प्रभु (स्वामी) और सबका नियंता (ईशान) है।
            वह सभी प्राणियों का एकमात्र सच्चा आश्रय (शरण) है और सबका बिना किसी स्वार्थ के हित चाहने वाला मित्र (सुहृत्) है।
            यह एक बहुत ही सुंदर विरोधाभास (Paradox) है—उसके पास आँखें नहीं हैं, फिर भी वह हमारी आँखों को देखने की शक्ति देता है।
            वह मन और इंद्रियों के माध्यम से दुनिया को जानता है, पर वह मन और इंद्रियों में कैद नहीं है।
            प्रभु और ईशान होने का मतलब है कि प्रकृति और समय उसके इशारों पर नाचते हैं।
            परंतु वह कोई कठोर तानाशाह नहीं है; वह तो 'सुहृत्' है, यानी एक ऐसा दोस्त जो बदले में कुछ नहीं चाहता।
            जब दुनिया में सब साथ छोड़ देते हैं, तब वही एक ईश्वर हमारा अंतिम और सबसे सुरक्षित आश्रय (Refuge) बनता है।
            यह श्लोक ज्ञान और भक्ति का एक उत्तम मिश्रण है, जहाँ ईश्वर असीम भी है और अत्यंत प्यारा भी।
        """.trimIndent(),
        english = """
            That Supreme Lord is the illuminator of the qualities (seeing, hearing) of all the senses (eyes, ears, etc.).
            Yet He Himself is completely devoid (Vivarjita) of all types of physical senses and their material forms.
            He is the Supreme Lord (Master) and the absolute controller (Ishana) of the entire moving and unmoving world.
            He is the sole true refuge (shelter) for all beings, and the selfless, well-wishing friend (Suhrid) of everyone.
            This is an exceedingly beautiful paradox—He has no physical eyes, yet He gives our eyes the very power to see.
            He knows the world through the mind and senses, but He is not imprisoned within the mind or the senses at all.
            Being the Lord and Ishana means that nature and time dance entirely according to His subtle gestures.
            But He is not a harsh dictator; He is a 'Suhrid', meaning a true friend who expects absolutely nothing in return.
            When everyone abandons us in the world, that one God becomes our ultimate and most secure refuge.
            This verse is a perfect blend of wisdom and devotion, where God is both infinitely vast and immensely lovable.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 51,
        sanskrit = "नवद्वारे पुरे देही हंसो लेलायते बहिः । वशी सर्वस्य लोकस्य स्थावरस्य चरस्य च ॥ ५१ ॥",
        hindi = """
            यह जीवात्मा नौ दरवाजों (आँख, कान, नाक, मुँह आदि) वाले इस शरीर रूपी नगर (पुर) में निवास करती है।
            यह जीव एक हंस (पक्षी) के समान है जो हमेशा अपनी चंचलता के कारण बाहर की ओर उड़ता रहता है।
            वह बाहरी विषयों और सुखों की ओर भागता है, परंतु वास्तव में वह इस पूरे ब्रह्मांड का शासक है।
            वह स्थावर (स्थिर) और जंगम (चलने वाले) संपूर्ण विश्व को अपनी सत्ता से पूरी तरह नियंत्रित करता है।
            शरीर के नौ द्वार मनुष्य को हमेशा बाहरी दुनिया से जोड़े रखते हैं, जिससे मन अशांत रहता है।
            'हंस' वह शुद्ध चेतना है जो अज्ञान के कारण खुद को इस छोटे से शरीर में कैद मान लेती है।
            शरीर एक नगर है जिसका राजा आत्मा है, पर वह अपनी शक्ति भूलकर बाहर खैरात (सुख) मांग रहा है।
            जब योगी ध्यान में इन नौ दरवाजों को बंद करता है, तब उसे अपने भीतर का वह राजा दिखाई देता है।
            आत्मा की शक्ति असीम है; जो पूरे ब्रह्मांड को चलाती है, वही हमारे शरीर को भी चला रही है।
            यह श्लोक इंद्रिय-संयम का महत्व बताता है ताकि बाहर भटकने वाली ऊर्जा भीतर की ओर लौट सके।
        """.trimIndent(),
        english = """
            The embodied soul resides in this city (body) having exactly nine gates (eyes, ears, nostrils, mouth, etc.).
            This soul is like a swan (Hamsa) that, due to its restlessness, constantly flutters and flies outward.
            It runs passionately towards external objects and pleasures, but in reality, it is the ruler of the cosmos.
            It completely controls and commands the entire universe, including both the moving and the unmoving.
            The nine gates of the body keep a person perpetually hooked to the outside world, making the mind restless.
            'Hamsa' is that pure consciousness which, out of ignorance, considers itself imprisoned in this small body.
            The body is a city whose King is the Soul, but forgetting its power, it begs for joy outside.
            When a Yogi closes these nine gates during meditation, he directly beholds that true King within.
            The power of the soul is limitless; the exact same energy that runs the cosmos runs our body.
            This verse emphasizes the importance of sense-control so that outward-flowing energy can return inward.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 52,
        sanskrit = "अपाणिपादो जवनो ग्रहीता पश्यत्यचक्षुः स शृणोत्यकर्णः । स वेत्ति वेद्यं न च तस्यास्ति वेत्ता तमाहुरग्र्यं पुरुषं महान्तम् ॥ ५२ ॥",
        hindi = """
            वह परमात्मा बिना हाथ-पैर के भी अत्यंत तेज दौड़ने वाला है और सब कुछ पकड़ने (ग्रहण करने) वाला है।
            वह बिना आँखों के भी सब कुछ स्पष्ट रूप से देखता है, और बिना कानों के भी सब कुछ सुनता है।
            इस संसार में जो कुछ भी जानने योग्य है, वह उसे जानता है, पर उसे पूरी तरह जानने वाला कोई नहीं है।
            ज्ञानी जन उस परब्रह्म को ही सबसे श्रेष्ठ (अग्र्य), सबसे प्राचीन और महान पुरुष (परमात्मा) कहते हैं।
            यह श्लोक (जो कैवल्य उपनिषद में भी आता है) ईश्वर की असीमित और भौतिक शरीर से परे क्षमता को दर्शाता है।
            ईश्वर हमारी तरह किसी उपकरण (इंद्रिय) का मोहताज नहीं है; उसकी चेतना स्वयं ही पूर्ण रूप से जाग्रत है।
            वह इतनी तेज़ गति से चलता है कि आप जहाँ भी पहुँचें, वह वहाँ पहले से ही मौजूद मिलता है।
            उसे कोई नहीं जान सकता क्योंकि हमारी बुद्धि सीमित है, और सीमित चीज असीम को नहीं नाप सकती।
            ईश्वर विषय (Object) नहीं है जिसे जाना जा सके, वह जानने वाला (Subject/Knower) स्वयं है।
            हम उस भगवान को केवल तभी जान सकते हैं जब हम स्वयं अपना अहंकार मिटाकर उसमें समा जाते हैं।
        """.trimIndent(),
        english = """
            That Supreme Lord, though without hands and feet, is extremely swift and grasps everything.
            He sees everything perfectly clearly without physical eyes, and hears everything without physical ears.
            He fully knows whatever is to be known in this world, but there is no one who can fully know Him.
            The wise call that Supreme Brahman the foremost (Agrya), the most ancient, and the Great Person.
            This verse (also found in Kaivalya Upanishad) shows God's limitless capacity beyond physical anatomy.
            God does not depend on instruments (senses) like we do; His consciousness itself is fully awake.
            He moves so swiftly that no matter where you go, you find Him already present there in advance.
            No one can completely know Him because our intellect is finite, and the finite cannot measure the infinite.
            God is not an Object to be known or studied; He is the ultimate Subject (Knower) Himself.
            We can truly know that Lord only when we dissolve our own ego and merge completely into Him.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 53,
        sanskrit = "अणोरणीयान् महतो महीयानात्मा गुहायां निहितोऽस्य जन्तोः । तमक्रतुं पश्यति वीतशोको धातुः प्रसादान्महिमानमीशम् ॥ ५३ ॥",
        hindi = """
            वह परमात्मा परमाणु (अणु) से भी अत्यंत सूक्ष्म है, और वह महान-से-महान आकाश से भी अधिक विशाल है।
            वह परम आत्मा प्रत्येक मनुष्य और जीव की हृदय रूपी गुफा में गहराई से छिपा हुआ (निहित) है।
            जो निष्काम (अक्रतु) साधक है, जिसकी कोई सांसारिक इच्छा शेष नहीं है, वह ही उसे देख पाता है।
            उस विधाता (ईश्वर) की अहैतुकी कृपा (प्रसाद) से ही मनुष्य उसकी महानता को देखकर शोकरहित हो जाता है।
            यह कठोपनिषद का भी प्रसिद्ध मंत्र है, जो बताता है कि परमात्मा एक साथ सूक्ष्मतम और विराटतम दोनों है।
            वह चींटी के हृदय में चींटी जितना और ब्रह्मांड में ब्रह्मांड जितना होकर पूर्ण रूप से समाया है।
            जब तक मन में कोई भी भौतिक इच्छा (क्रतु) बाकी है, तब तक आत्मा का दर्शन असंभव है।
            संसार की हर चीज़ पुरुषार्थ (मेहनत) से पाई जा सकती है, पर ईश्वर केवल उसकी 'कृपा' (Grace) से मिलता है।
            जब कृपा बरसती है, तो अहंकार का पर्दा टूटता है और आत्मा का प्रकाश फूट पड़ता है।
            ईश्वर की महिमा को अनुभव करने वाला योगी जीवन के सारे दुखों और डरों से हमेशा के लिए मुक्त हो जाता है।
        """.trimIndent(),
        english = """
            That Supreme Lord is subtler than the smallest atom, and vastly greater than the greatest magnitude.
            That Supreme Soul is deeply hidden (seated) within the cave of the heart of every single creature.
            The desireless seeker (Akratu), who has no worldly cravings left, alone is able to behold Him.
            By the pure grace (Prasada) of that Creator, a person sees His glory and becomes completely free from sorrow.
            This is also a famous mantra from Katha Upanishad, revealing God as simultaneously the most microscopic and cosmic.
            He fits perfectly as the size of an ant in its heart, and as the size of the cosmos in the universe.
            As long as any material desire (Kratu) remains in the mind, the vision of the Soul is utterly impossible.
            Everything in the world can be achieved through self-effort, but God is attained only through His 'Grace'.
            When grace descends, the veil of ego shatters completely, and the brilliant light of the Soul bursts forth.
            The Yogi who experiences the glory of God becomes forever liberated from all the sorrows and fears of life.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 54,
        sanskrit = "वेदाहमेतमजरं पुराणं सर्वात्मानं सर्वगतं विभुत्वात् । जन्मनिरोधं प्रवदन्ति यस्य ब्रह्मवादिनो हि प्रवदन्ति नित्यम् ॥ ५४ ॥",
        hindi = """
            (ऋषि उद्घोष करते हैं): मैं उस अजर (कभी बूढ़े न होने वाले) और सबसे प्राचीन (पुराण) परम पुरुष को जानता हूँ।
            मैं उसे सर्वव्यापकता (विभुत्व) के कारण संपूर्ण प्राणियों की अंतरात्मा और सब जगह स्थित के रूप में जानता हूँ।
            ब्रह्म को जानने वाले श्रेष्ठ ज्ञानी जन जिसके जन्म के निरोध (अर्थात उसका कभी जन्म नहीं होता) की घोषणा करते हैं।
            और ब्रह्मवेत्ता ऋषि जिसे हमेशा सनातन और नित्य (कभी न बदलने वाला) सत्य कहकर पुकारते हैं।
            यह तीसरे अध्याय का अंतिम श्लोक है, जिसमें ऋषि अपने साक्षात् आत्म-अनुभव का डंके की चोट पर वर्णन कर रहे हैं।
            अजर का अर्थ है कि समय का उस पर कोई असर नहीं होता, वह हमेशा एक समान और युवा ऊर्जा से भरा है।
            वह सर्वव्यापी है, इसलिए ब्रह्मांड का कोई भी कोना उसकी उपस्थिति से एक पल के लिए भी अछूता नहीं है।
            जिसका जन्म ही नहीं हुआ, उसकी मृत्यु कैसे हो सकती है? इसलिए वह जन्म-मरण के चक्र से पूरी तरह परे है।
            ब्रह्मवादी किसी अंधविश्वास में नहीं, बल्कि सीधे अनुभव (Direct Experience) के आधार पर यह बात कहते हैं।
            यह श्लोक साधक के भीतर यह दृढ़ विश्वास जगाता है कि वह भी ध्यान द्वारा इस परम सत्य को जान सकता है।
        """.trimIndent(),
        english = """
            (The sage declares): I truly know this undecaying (Ageless) and most ancient (Primeval) Supreme Person.
            I know Him as the soul of all and existing everywhere due to His absolute all-pervading nature (Vibhutva).
            The great knowers of Brahman boldly declare the total cessation of His birth (meaning He is never born).
            And the expounders of Brahman always proclaim Him to be the eternal and unchangeable Truth.
            This is the final verse of the third chapter, where the sage confidently describes his direct Self-experience.
            Undecaying means time has absolutely no effect on Him; He is always constant and full of youthful energy.
            He is omnipresent, meaning no corner of the universe is ever untouched by His divine presence for even a second.
            How can one who is never born possibly die? Hence, He is completely beyond the cycle of birth and death.
            The knowers of Brahman say this not out of blind faith, but based on their absolute Direct Experience.
            This verse awakens a firm belief in the seeker that he too can realize this Supreme Truth through meditation.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 55,
        sanskrit = "य एकोऽवर्णो बहुधा शक्तियोगाद् वर्णाननेकान् निहितार्थो दधाति । विचैति चान्ते विश्वमादौ स देवः स नो बुद्ध्या शुभया संयुनक्तु ॥ ५५ ॥",
        hindi = """
            (चतुर्थ अध्याय प्रारंभ): वह जो एक है और जिसका अपना कोई वर्ण (रंग/जाति/आकार) नहीं है (अवर्ण)।
            वह अपनी ही शक्तियों के योग से, किसी गूढ़ उद्देश्य (निहितार्थ) के लिए अनेक प्रकार के वर्ण (रूप) धारण करता है।
            जो परमेश्वर सृष्टि के आरंभ में इस पूरे विश्व को बनाता है और अंत में इस पूरे विश्व को अपने भीतर समेट लेता है।
            वह परम प्रकाशमय देव हम सभी को अत्यंत शुभ, कल्याणकारी और निर्मल बुद्धि से संयुक्त (प्रदान) करे।
            सृष्टि कैसे बनती है? जैसे एक रंगहीन (सफेद) प्रकाश प्रिज्म (Prism) से गुजरकर सात रंगों में बँट जाता है।
            उसी तरह वह निराकार परब्रह्म अपनी माया (शक्ति) के माध्यम से इस रंग-बिरंगी दुनिया का रूप ले लेता है।
            ईश्वर का कोई 'निहितार्थ' (Hidden purpose) है जिसे हम नहीं जानते; यह सृष्टि उसका एक रहस्यमयी खेल है।
            वह दुनिया को बनाकर छोड़ नहीं देता, बल्कि अंत में उसे वापस अपने ही भीतर समेट कर विश्राम देता है।
            उपनिषद के ऋषि यहाँ फिर से किसी भौतिक सुख की बजाय केवल 'शुभ बुद्धि' (Right Understanding) की प्रार्थना कर रहे हैं।
            क्योंकि यदि बुद्धि शुद्ध हो गई, तो वह रंग-बिरंगी दुनिया के मोह में न फँसकर उस रंगहीन सत्य को देख लेगी।
        """.trimIndent(),
        english = """
            (Beginning of Chapter 4): He who is One and who possesses no color, form, caste, or attribute of His own (Avarna).
            He, through the union of His various powers, assumes numerous forms (colors) for some hidden, profound purpose.
            That Supreme Lord who projects this entire universe in the beginning and completely withdraws it at the end.
            May that supremely radiant Deity endow and unite us all with an extremely auspicious, pure intellect.
            How is creation formed? Just as colorless (white) light passes through a prism and splits into seven colors.
            Similarly, that formless Brahman, through His Maya (power), takes the form of this incredibly colorful world.
            God has a 'hidden purpose' that we do not fully know; this creation is His deeply mystical divine play.
            He doesn't just create the world and abandon it; at the end, He withdraws it back into Himself for rest.
            The sages of the Upanishad again pray not for material joy, but exclusively for 'Right Understanding' (Shubha Buddhi).
            Because if the intellect is purified, it will not get trapped in the colorful world, but will see the colorless Truth.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 56,
        sanskrit = "तदेवाग्निस्तदादित्यस्तद्वायुस्तदु चन्द्रमाः । तदेव शुक्रं तद् ब्रह्म तदापस्तत् प्रजापतिः ॥ ५६ ॥",
        hindi = """
            वही एक परब्रह्म अग्नि (आग) है, वही आदित्य (सूर्य) है, वही वायु (हवा) है, और वही चंद्रमा है।
            वही परब्रह्म चमकते हुए तारे (शुक्र) है, वही हिरण्यगर्भ (ब्रह्मा) है, वही जल है और वही प्रजापति है।
            यह श्लोक सृष्टि की सभी प्राकृतिक शक्तियों और देवताओं को उसी एक परब्रह्म के रूप में घोषित करता है।
            आग की गर्मी उसी की है, सूर्य की चमक उसी का प्रकाश है, और चंद्रमा की शीतलता उसी का प्रेम है।
            वह केवल आसमान में नहीं बैठा है; प्रकृति का हर तत्व वास्तव में उसी का साक्षात् और जीवंत स्वरूप है।
            ब्रह्मा (रचयिता) और प्रजापति (प्रजा का पालक) भी उससे अलग नहीं हैं, बल्कि उसी की उपाधियां हैं।
            यह वेदान्त का सर्वेश्वरवाद (Panentheism) है—ईश्वर ही ब्रह्मांड है, और वह ब्रह्मांड से भी बड़ा है।
            जब साधक इस सत्य को अनुभव करता है, तो उसे प्रकृति के हर रूप में भगवान का ही दर्शन होने लगता है।
            फिर उसके लिए मंदिर की चारदीवारी जरूरी नहीं रहती; वह नदी, हवा और तारों में भी भगवान की पूजा कर लेता है।
            अद्वैत का यह चरम सिद्धांत मनुष्य को हर प्रकार के धार्मिक और वैचारिक संकुचितपन से आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            That one Supreme Brahman alone is Fire, He is the Sun (Aditya), He is the Wind (Vayu), and He is the Moon.
            That Supreme Brahman alone is the shining stars (Shukra), He is Brahma, He is the Waters, and He is Prajapati.
            This verse declares all the natural forces and deities of creation to be the forms of that one Supreme Brahman.
            The heat of the fire is His, the brilliance of the sun is His light, and the coolness of the moon is His love.
            He is not merely sitting in the sky; every element of nature is indeed His direct, living, and breathing manifestation.
            Brahma (the creator) and Prajapati (lord of creatures) are not separate from Him, but are just His functional titles.
            This is Vedantic Panentheism—God Himself is the universe, and He is also infinitely greater than the universe.
            When a seeker experiences this truth, he begins to see God in every single aspect and form of nature.
            Then the four walls of a temple are no longer necessary; he worships God in the river, the wind, and the stars.
            This peak principle of Non-duality completely frees man from all types of religious and ideological narrowness.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 57,
        sanskrit = "त्वं स्त्री त्वं पुमानसि त्वं कुमार उत वा कुमारी । त्वं जीर्णो दण्डेन वञ्चसि त्वं जातो भवसि विश्वतोमुखः ॥ ५७ ॥",
        hindi = """
            हे परमात्मा! आप ही स्त्री (औरत) हैं, आप ही पुरुष (आदमी) हैं, आप ही लड़के हैं और आप ही लड़की (कुमारी) हैं।
            आप ही वह बूढ़े इंसान हैं जो बुढ़ापे में अपनी लाठी (डंडे) के सहारे डगमगाते हुए चल रहे हैं।
            आप ही जन्म लेकर इस संसार में अलग-अलग रूपों में प्रकट हो रहे हैं, क्योंकि आपके मुख सब ओर (विश्वतोमुख) हैं।
            यह श्लोक लिंग और उम्र के सारे भेदों को मिटाकर हर इंसान में भगवान को देखने की शिक्षा देता है।
            ईश्वर न तो पुरुष है और न ही स्त्री; वह चेतना है जो इन दोनों शरीरों में एक समान धड़क रही है।
            खेलता हुआ बच्चा भी वही है और लाठी टेकता हुआ कमजोर बूढ़ा भी उसी का एक साक्षात् रूप है।
            हम इंसानों को उनके शरीर से पहचानते हैं, पर उपनिषद कहता है कि शरीरों के पीछे झांककर उस आत्मा को देखो।
            यदि हर व्यक्ति ईश्वर है, तो समाज में कोई ऊँच-नीच, कोई लड़ाई या कोई अपमान कैसे हो सकता है?
            ईश्वर ही बार-बार जन्म लेकर अपनी ही बनाई दुनिया का अनुभव अलग-अलग दृष्टिकोण (Perspectives) से ले रहा है।
            भक्ति का यह सबसे ऊंचा रूप है—चलते-फिरते हर इंसान में सीधे उस परब्रह्म का दर्शन और सत्कार करना।
        """.trimIndent(),
        english = """
            O Supreme Lord! You are the woman, You are the man, You are the young boy, and You are the young maiden.
            You are indeed that old man who is tottering and walking with the support of a wooden staff in his old age.
            It is You who take birth and manifest in all these various forms, for Your faces are turned in all directions.
            This verse completely erases all distinctions of gender and age, teaching us to see God in every human being.
            God is neither male nor female; He is the pure consciousness pulsating equally within both these bodies.
            The playing child is Him, and the weak old man leaning on a stick is also a direct manifestation of Him.
            We identify people by their bodies, but the Upanishad urges us to look behind the bodies and see the Soul.
            If every individual is God, how can there be any hierarchy, any conflict, or any insult in society?
            God Himself takes birth repeatedly to experience His own created world from countless different perspectives.
            This is the highest form of devotion—to directly behold and honor the Supreme Brahman in every walking human.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 58,
        sanskrit = "नीलः पतङ्गो हरितो लोहिताक्षस्तटिद्गर्भ ऋतवः समुद्राः । अनादिमत्त्वं विभुत्वेन वर्तसे यतो जातानि भुवनानि विश्वा ॥ ५८ ॥",
        hindi = """
            हे ईश्वर! आप ही नीले रंग के भंवरे (पतंग) हैं, आप ही लाल आँखों वाले हरे रंग के तोते (पक्षी) हैं।
            आप ही वह मेघ (बादल) हैं जिसके गर्भ में बिजली छिपी है, आप ही सभी ऋतुएं हैं और आप ही ये विशाल समुद्र हैं।
            आप अनादि (जिसकी कोई शुरुआत न हो) हैं, और आप ही सर्वव्यापकता (विभुत्व) के साथ सर्वत्र मौजूद हैं।
            आप ही वह मूल स्रोत हैं जिससे ये सभी भुवन (लोक) और संपूर्ण विश्व उत्पन्न हुए हैं।
            यह श्लोक सृष्टि की प्राकृतिक सुंदरता में ईश्वर की कारीगरी (Artistry) और उपस्थिति को दिखाता है।
            एक छोटा सा कीड़ा या एक सुंदर तोता—वे भी भगवान की ही एक सजीव और सुंदर कलाकृति हैं।
            बिजली, मौसमों का बदलना और समुद्र की लहरें—ये प्रकृति के नियम नहीं, बल्कि साक्षात् भगवान का खेल हैं।
            ईश्वर 'अनादि' है, जिसका अर्थ है कि वह बिग-बैंग (Big Bang) से भी पहले से मौजूद था और हमेशा रहेगा।
            विभु होने का अर्थ है कि वह हर कण में पूरी तरह से फिट है; वह कहीं भी कम या ज्यादा नहीं है।
            यह श्लोक हमें सिखाता है कि जो आँखें परमात्मा को देखना चाहती हैं, वे उसे एक पक्षी के पंखों में भी देख सकती हैं।
        """.trimIndent(),
        english = """
            O Lord! You are the dark blue bee (or butterfly), You are the green parrot (bird) with red eyes.
            You are the thundercloud with lightning hidden in its womb, You are all the seasons, and You are the vast oceans.
            You are entirely beginning-less (without origin), and You exist everywhere with absolute all-pervasiveness.
            You alone are the ultimate root source from which all these realms and the entire cosmos have been born.
            This verse reveals God's stunning artistry and His vibrant presence in the natural beauty of creation.
            A tiny insect or a beautiful parrot—they too are a living, breathing, and beautiful artwork of God.
            Lightning, the changing of seasons, and ocean waves—these are not mere laws of nature, but God's direct play.
            God is 'Anadi' (beginning-less), meaning He existed even before the Big Bang and will remain forever.
            Being all-pervading (Vibhu) means He fits perfectly into every atom; He is nowhere less or more.
            This verse teaches us that eyes wishing to see the Supreme can easily spot Him even in a bird's feathers.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 59,
        sanskrit = "अजामेकां लोहितशुक्लकृष्णां बह्वीः प्रजाः सृजमानां सरूपाम् । अजो ह्येको जुषमाणोऽनुशेते जहात्येनां भुक्तभोगामजोऽन्यः ॥ ५९ ॥",
        hindi = """
            एक 'अजा' (अजन्मी प्रकृति/माया) है, जो लाल (रजोगुण), सफेद (सत्त्वगुण) और काले (तमोगुण) रंग वाली है।
            यह अजा (प्रकृति) अपने ही समान त्रिगुणात्मक रूप वाली अनगिनत प्रजाओं (वस्तुओं/जीवों) की रचना करती है।
            एक अज्ञानी 'अज' (अजन्मा जीवात्मा) इस प्रकृति के आकर्षण में फँसकर इसका सेवन (उपभोग) करता है और बंध जाता है।
            किंतु एक दूसरा ज्ञानी 'अज' (मुक्त जीवात्मा) इसके सभी भोगों को जानकर इस प्रकृति (माया) को हमेशा के लिए त्याग देता है।
            यह उपनिषद का अत्यंत ही प्रसिद्ध सांख्य और वेदान्त का मिला-जुला रहस्यमयी (Mystical) श्लोक है।
            लाल रंग कर्म (रजस) का, सफेद रंग ज्ञान (सत्त्व) का, और काला रंग आलस्य (तमस) का सटीक प्रतीक है।
            दुनिया की हर चीज़ इन्हीं तीन गुणों के धागों से बुनी गई है, इसलिए हर चीज़ में ये तीनों रंग मौजूद हैं।
            अज्ञानी जीव सोचता है कि संसार के ये रंगीन सुख ही सब कुछ हैं, और वह इस जाल में फँसकर दुखी होता है।
            ज्ञानी जीव जान लेता है कि यह प्रकृति केवल एक भ्रम है, वह इसे भोगकर (अनुभव करके) इससे विरक्त हो जाता है।
            मुक्ति का अर्थ दुनिया से भागना नहीं, बल्कि इसके स्वभाव (Nature) को समझकर इससे अपनी आसक्ति हटा लेना है।
        """.trimIndent(),
        english = """
            There is one 'Aja' (unborn Nature/Prakriti) which is red (Rajas), white (Sattva), and black (Tamas) in color.
            This unborn Nature creates countless progeny (creatures and objects) that share her exact three-fold characteristics.
            One ignorant 'Aja' (unborn soul) gets mesmerized by this Nature, enjoys her offerings, and gets firmly bound.
            But another wise 'Aja' (liberated soul), having experienced her enjoyments, abandons this Nature (Maya) forever.
            This is an extremely famous mystical verse combining the deep philosophies of Samkhya and Vedanta.
            Red is the precise symbol of action (Rajas), white of wisdom (Sattva), and black of ignorance (Tamas).
            Everything in the world is woven from the threads of these three Gunas; hence, all three colors are in everything.
            The ignorant soul thinks these colorful worldly joys are everything, gets caught in the web, and suffers.
            The wise soul realizes that this Nature is just an illusion; having experienced it, he becomes totally detached.
            Liberation is not running away from the world, but understanding its true nature and withdrawing attachment from it.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 60,
        sanskrit = "द्वा सुपर्णा सयुजा सखाया समानं वृक्षं परिषस्वजाते । तयोरन्यः पिप्पलं स्वाद्वत्त्यनश्नन्नन्यो अभिचाकशीति ॥ ६० ॥",
        hindi = """
            दो सुंदर पंखों वाले पक्षी, जो हमेशा साथ रहने वाले घनिष्ठ मित्र हैं, एक ही वृक्ष को गले लगाए (बैठे) हुए हैं।
            उन दोनों पक्षियों में से एक पक्षी उस वृक्ष के स्वादिष्ट फलों को बड़े मजे से चख-चख कर खा रहा है।
            किंतु दूसरा पक्षी उन फलों को बिल्कुल नहीं खाता, वह केवल शांत भाव से सब कुछ देख (साक्षी रूप में) रहा है।
            यह मुण्डक उपनिषद (3.1.1) का वही प्रसिद्ध मंत्र है, जो यहाँ दोहराया गया है।
            वृक्ष हमारा भौतिक शरीर है, फल हमारे कर्मों के सुख-दुख हैं, और ये दोनों पक्षी हमारी चेतना के दो रूप हैं।
            खाने वाला पक्षी 'जीवात्मा' (Individual Soul) है जो संसार के भोगों और वासनाओं में पूरी तरह उलझा हुआ है।
            बिना खाने वाला पक्षी 'परमात्मा' (Supreme Soul) है जो हमारे भीतर शुद्ध दृष्टा (Witness) भाव से स्थित है।
            हम दुखी होते हैं क्योंकि हम खुद को फल खाने वाला (जीवात्मा) मान लेते हैं और कर्मों के फल में फँस जाते हैं।
            जिस दिन हम खाने वाले से हटकर देखने वाले (साक्षी) के साथ एक हो जाएंगे, उसी दिन हम पूरी तरह मुक्त हो जाएंगे।
            यह श्लोक द्वैत से अद्वैत की ओर ले जाने वाला भारतीय दर्शन का सबसे महान और सरल मनोवैज्ञानिक रूपक है।
        """.trimIndent(),
        english = """
            Two birds with beautiful plumage, who are inseparable intimate friends, sit embracing the exact same tree.
            One of those two birds is eating the tasty fruits of that tree with great relish and attachment.
            But the other bird does not eat anything at all; it merely looks on calmly as a silent Witness.
            This is the exact same famous mantra from the Mundaka Upanishad (3.1.1) repeated here for emphasis.
            The tree is our physical body, the fruits are the joys and sorrows of karma, and the birds are forms of consciousness.
            The eating bird is the 'Jivatma' (individual soul) who is completely entangled in worldly enjoyments and desires.
            The non-eating bird is the 'Paramatma' (Supreme Soul) residing within us purely in the state of an Observer.
            We suffer because we identify ourselves as the eater (individual soul) and get trapped in the fruits of actions.
            The day we shift our identity from the eater to the Witness (Observer), we will be completely liberated.
            This verse is the greatest and simplest psychological metaphor in Indian philosophy leading from duality to non-duality.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 61,
        sanskrit = "समाने वृक्षे पुरुषो निमग्नोऽनीशया शोचति मुह्यमानः । जुष्टं यदा पश्यत्यन्यमीशमस्य महिमानमिति वीतशोकः ॥ ६१ ॥",
        hindi = """
            उसी एक ही वृक्ष (शरीर) पर बैठा हुआ वह जीवात्मा मोह और अज्ञान के कारण पूरी तरह से डूबा हुआ है।
            वह अपनी लाचारी और असमर्थता (अनीशया) के कारण भ्रमित होकर बार-बार शोक और विलाप करता है।
            किंतु जब वह अपने से भिन्न उस दूसरे आराध्य 'ईश्वर' (परमात्मा) को साक्षात् देख लेता है।
            और जब वह उस ईश्वर की महान महिमा को जान लेता है, तब वह तुरंत सभी शोकों से हमेशा के लिए मुक्त हो जाता है।
            (यह भी मुण्डक का ही मंत्र है)। हमारा सारा दुख हमारी अपनी कमजोरी और लाचारी की भावना के कारण है।
            हम सोचते हैं कि हम शरीर हैं और बाहरी परिस्थितियां हमें कुचल देंगी, यही भ्रम (मोह) है।
            परंतु जैसे ही जीव अपने भीतर बैठे उस शांत 'दूसरे पक्षी' (ईश्वर) की ओर ध्यान लगाता है, चमत्कार होता है।
            वह जान लेता है कि असली शक्ति (महिमा) तो उसी ईश्वर की है, और वह ईश्वर उसी का अपना असली स्वरूप है।
            जब इंसान को अपनी असीमित ताकत का पता चलता है, तो दुनिया का कोई भी डर उसे डरा नहीं सकता।
            शोक से पार जाने का अर्थ है यह जानना कि 'मैं' नश्वर शरीर नहीं, बल्कि वह अविनाशी और सर्वसमर्थ आत्मा हूँ।
        """.trimIndent(),
        english = """
            Seated on the exact same tree (body), the individual soul is completely immersed in delusion and ignorance.
            Bewildered by his own helplessness and impotence (Anishaya), he constantly grieves and laments.
            But when he directly beholds the other adorable 'Lord' (the Supreme Soul) seated right next to him.
            And when he realizes the magnificent glory of that Lord, he instantly becomes free from all sorrow forever.
            (This is also a mantra from Mundaka). All our sorrow is strictly due to our feeling of weakness and helplessness.
            We think we are the body and external circumstances will crush us; this is the core illusion (Moha).
            But the moment the soul turns its focus to the calm 'second bird' (God) within, a miracle happens.
            He realizes that the real power (glory) belongs to God, and that God is his own true, original nature.
            When a person discovers his own limitless strength, no fear in the world can ever frighten him again.
            Crossing over sorrow means knowing that 'I' am not the mortal body, but the indestructible, all-powerful Soul.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 62,
        sanskrit = "ऋचो अक्षरे परमे व्योमन् यस्मिन्देवा अधि विश्वे निषेदुः । यस्तन्न वेद किमृचा करिष्यति य इत्तद्विदुस्त इमे समासते ॥ ६२ ॥",
        hindi = """
            ऋग्वेद के सभी मंत्र उस परम, अविनाशी और सबसे ऊँचे आकाश (परमे व्योमन्/परब्रह्म) में ही स्थित हैं।
            उसी परम अक्षर (ब्रह्म) के भीतर सारे विश्व के देवी-देवता और शक्तियां आश्रय लेकर बैठे हुए हैं।
            जो व्यक्ति उस परम ब्रह्म को नहीं जानता, वह केवल वेद के मंत्रों (ऋचाओं) को रटकर क्या करेगा?
            परंतु जो ज्ञानी उस परब्रह्म को यथार्थ रूप से जान लेते हैं, वे पूर्ण शांति और परमानंद में स्थित हो जाते हैं।
            यह श्लोक खोखले कर्मकांड और बिना समझ के किए गए किताबी अध्ययन पर एक बहुत बड़ा प्रहार है।
            वेद केवल कागज पर लिखे शब्द नहीं हैं, वे उस परब्रह्म से निकली हुई ब्रह्मांडीय ध्वनियां (Vibrations) हैं।
            यदि हम मंत्र पढ़ते हैं पर उस मंत्र के लक्ष्य (ईश्वर) को अनुभव नहीं करते, तो वह केवल समय की बर्बादी है।
            सारे देवता (इंद्र, अग्नि आदि) स्वतंत्र नहीं हैं; वे सब उसी एक अविनाशी ब्रह्म की छत के नीचे काम करते हैं।
            धर्म का उद्देश्य केवल शास्त्रों को याद करना नहीं है, बल्कि उस सत्य का साक्षात् अनुभव (Realization) करना है।
            जो उस सत्य को पा लेता है, उसे फिर कुछ और पढ़ने की आवश्यकता नहीं रहती; वह स्वयं ज्ञान का स्वरूप हो जाता है।
        """.trimIndent(),
        english = """
            All the mantras of the Rigveda rest securely in that supreme, imperishable, and highest ether (Brahman).
            Within that Supreme Imperishable, all the gods and cosmic powers of the universe sit taking refuge.
            He who does not know that Supreme Brahman, what will he possibly achieve by merely reciting Vedic mantras?
            But those wise ones who truly know that Brahman become perfectly established in absolute peace and bliss.
            This verse is a massive strike against hollow ritualism and academic study done without real understanding.
            The Vedas are not just words written on paper; they are cosmic sounds (vibrations) emerging from Brahman.
            If we recite mantras but do not experience the target of the mantra (God), it is merely a waste of time.
            All deities (Indra, Agni, etc.) are not independent; they all work under the roof of that one Imperishable Brahman.
            The goal of religion is not memorizing scriptures, but the direct, firsthand realization of the Truth.
            He who attains that Truth has no need to read anything else; he becomes the embodiment of wisdom itself.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 63,
        sanskrit = "छन्दांसि यज्ञाः क्रतवो व्रतानि भूतं भव्यं यच्च वेदा वदन्ति । अस्मान्मायी सृजते विश्वमेतत् तस्मिंश्चान्यो मायया सन्निरुद्धः ॥ ६३ ॥",
        hindi = """
            सभी वेद-मंत्र (छंद), सभी प्रकार के यज्ञ, अनुष्ठान (क्रतु), व्रत, जो अतीत में हो चुका है और जो भविष्य में होगा।
            और वह सब कुछ जिसका वर्णन वेद करते हैं, वे सभी उसी एक परब्रह्म से उत्पन्न होते हैं।
            वह माया का स्वामी (मायी) परब्रह्म अपनी असीम माया शक्ति के द्वारा इस संपूर्ण विश्व की रचना करता है।
            और उसी माया के रचे हुए इस जाल (संसार) में वह दूसरा (जीवात्मा) पूरी तरह से बँधकर कैद हो जाता है।
            माया कोई बुरी चीज़ नहीं है, यह तो ईश्वर की वह रचनात्मक शक्ति है जिससे वह ब्रह्मांड का नाटक लिखता है।
            यज्ञ, व्रत और समय के चक्र (भूत-भविष्य)—सब उसी के रचे हुए खेल के अलग-अलग नियम और दृश्य हैं।
            ईश्वर इस माया को 'कंट्रोल' करता है (वह मायी है), इसलिए वह स्वतंत्र है और इस खेल का आनंद लेता है।
            परंतु जीवात्मा माया को 'सच' मान लेती है, इसलिए वह इसमें 'कंट्रोल' हो जाती है (सन्निरुद्ध) और दुखी होती है।
            यह श्लोक माया के सिद्धांत (Theory of Maya) को बहुत ही स्पष्ट और वैज्ञानिक तरीके से समझाता है।
            मुक्ति का रास्ता माया से लड़ना नहीं, बल्कि उस 'मायी' (मालिक/ईश्वर) की शरण में जाना है।
        """.trimIndent(),
        english = """
            All Vedic meters (mantras), all sacrifices, rituals, vows, whatever happened in the past and will happen in the future.
            And absolutely everything that the Vedas declare—all of these emerge solely from that one Supreme Brahman.
            That Master of Maya (Mayin) creates this entire vast universe through His limitless power of Maya.
            And within this very net (world) created by Maya, the other one (the individual soul) gets completely bound and confined.
            Maya is not an evil thing; it is simply God's creative power with which He writes the drama of the cosmos.
            Sacrifices, vows, and the cycle of time (past-future) are all just different rules and scenes of His play.
            God 'controls' this Maya (He is the Mayin), therefore He remains independent and enjoys the play.
            But the soul mistakes Maya to be 'real', hence it gets 'controlled' (confined) by it and suffers greatly.
            This verse explains the Theory of Maya in an extremely clear and highly scientific manner.
            The path to liberation is not fighting Maya, but taking refuge in that 'Mayin' (the Master/God) Himself.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 64,
        sanskrit = "मायां तु प्रकृतिं विद्यान्मायिनं तु महेश्वरम् । तस्यावयवभूतैस्तु व्याप्तं सर्वमिदं जगत् ॥ ६४ ॥",
        hindi = """
            साधक को यह भलीभांति जान लेना चाहिए कि यह 'प्रकृति' (Nature) ही वास्तव में 'माया' है।
            और उस माया को धारण करने वाला और उसका स्वामी (मायी) वह महान परमेश्वर (महेश्वर) है।
            इस संसार में जो कुछ भी दिखाई देता है, वह सब उसी महेश्वर के अवयवों (अंगों/अंशों) से बना है।
            उसी परमेश्वर की शक्तियों और अंगों से यह संपूर्ण चराचर जगत पूरी तरह से व्याप्त (भरा हुआ) है।
            यह श्लोक वेदान्त दर्शन का सबसे महत्वपूर्ण सूत्र है जो माया और प्रकृति के बीच के भेद को खत्म करता है।
            प्रकृति (पेड़, पहाड़, ग्रह, शरीर) कोई ठोस या स्वतंत्र वस्तु नहीं है, यह सिर्फ ईश्वर का एक जादुई भ्रम (माया) है।
            जादूगर (महेश्वर) को पता होता है कि जादू (माया) असली नहीं है, पर देखने वाले (जीव) उसमें खो जाते हैं।
            दुनिया की हर चीज़—चाहे वह अच्छी हो या बुरी—उसी महेश्वर का एक छोटा सा हिस्सा (अवयव) मात्र है।
            जब हम जान लेते हैं कि पूरी दुनिया उसी एक ईश्वर का शरीर है, तो हम किसी भी चीज़ से नफरत नहीं कर सकते।
            यह ज्ञान हमें सिखाता है कि प्रकृति का सम्मान करना साक्षात् उस महेश्वर (परमेश्वर) का ही सम्मान करना है।
        """.trimIndent(),
        english = """
            The seeker should understand perfectly well that this 'Prakriti' (Nature) is in fact 'Maya' itself.
            And the wielder and absolute Master of that Maya (the Mayin) is the Great Lord (Maheshvara) Himself.
            Whatever is visible in this world is made up entirely of the limbs (parts/fragments) of that Maheshvara.
            This entire moving and unmoving universe is completely pervaded (filled) by the powers and limbs of that Lord.
            This verse is the most important formula of Vedantic philosophy, eliminating the distinction between Maya and Nature.
            Nature (trees, mountains, planets, bodies) is not a solid independent entity; it is just a magical illusion (Maya) of God.
            The Magician (Maheshvara) knows the magic (Maya) is not real, but the spectators (souls) get lost in it.
            Everything in the world—whether good or bad—is merely a tiny fragment (limb) of that great Lord.
            When we realize that the whole world is the very body of God, we cannot possibly hate anything.
            This wisdom teaches us that respecting Nature is directly respecting that Maheshvara (Supreme Lord) Himself.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 65,
        sanskrit = "यो योनिं योनिमधितिष्ठत्येको यस्मिन्निदं सञ्च वि चैति सर्वम् । तमीशानं वरदं देवमीड्यं निचाय्येमां शान्तिमत्यन्तमेति ॥ ६५ ॥",
        hindi = """
            वह जो एक अद्वितीय परमात्मा सृष्टि के प्रत्येक कारण (योनि) और प्रत्येक वस्तु का अधिष्ठाता (शासक) है।
            जिस एक ईश्वर के भीतर यह पूरा ब्रह्मांड प्रलय के समय विलीन होता है, और उसी से विस्तार (उत्पन्न) पाता है।
            उस परम शासक (ईशान), वरदान देने वाले (वरद) और स्तुति करने योग्य (ईड्य) परम देव (परमात्मा) को।
            जब साधक अपने हृदय में पूरी तरह से अनुभव (दर्शन) कर लेता है, तब वह अत्यंत और परम शांति को प्राप्त करता है।
            सृष्टि में लाखों योनियां (प्रजातियां) हैं, पर उन सबमें चेतना का स्रोत केवल वह एक ही ईश्वर है।
            ईश्वर हमारी प्रार्थनाओं को सुनने वाला (ईड्य) और हमें ज्ञान का वरदान देने वाला (वरद) कृपालु है।
            दुनिया की अशांति इसलिए है क्योंकि हम शांति को बाहरी चीज़ों (धन, रिश्ते) में ढूँढने की कोशिश करते हैं।
            असली और स्थायी शांति (अत्यन्त शान्ति) केवल उस परम कारण (ईश्वर) के साथ जुड़ने पर ही मिलती है।
            निचाय्य का अर्थ है केवल बौद्धिक रूप से जानना नहीं, बल्कि ध्यान के माध्यम से उसका सीधा दर्शन करना।
            जब जीव उस अनंत सागर में समा जाता है, तो उसके सारे डर और बेचैनियां हमेशा के लिए शांत हो जाती हैं।
        """.trimIndent(),
        english = """
            He who is the one non-dual Supreme Lord presiding over every single cause (yoni) and every object of creation.
            Within whom this entire universe dissolves at the time of destruction, and from whom it expands (is born).
            That Supreme Ruler (Ishana), the bestower of boons (Varada), and the highly adorable (Idya) Deity.
            When a seeker completely experiences (perceives) Him within his heart, he attains extreme and absolute peace.
            There are millions of species (Yonis) in creation, but the source of consciousness in all of them is that One God.
            God is compassionate; He listens to our prayers (Idya) and grants us the ultimate boon of wisdom (Varada).
            The restlessness of the world exists because we try to find peace in external things (wealth, relationships).
            Real and permanent peace (Atyanta Shanti) is found exclusively by connecting with that Supreme Cause (God).
            'Nichayya' does not mean just knowing intellectually, but having a direct vision through deep meditation.
            When the soul merges into that infinite ocean, all its fears and anxieties are silenced forever.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 66,
        sanskrit = "यो देवानां प्रभवश्चोद्भवश्च विश्वाधिपो रुद्रो महर्षिः । हिरण्यगर्भं पश्यत जायमानं स नो बुद्ध्या शुभया संयुनक्तु ॥ ६६ ॥",
        hindi = """
            वह महान दृष्टा (महर्षि) और रुद्र जो सभी देवताओं की उत्पत्ति का मूल कारण और उनका परम रक्षक है।
            जो इस संपूर्ण विश्व का एकमात्र अधिपति (मालिक) है और जिसने सृष्टि के आरंभ में सब कुछ रचा।
            जिसने सृष्टि के पहले जीव 'हिरण्यगर्भ' (ब्रह्मा) को अपने सामने उत्पन्न होते हुए साक्षात् देखा था।
            वह परमेश्वर (रुद्र) हम सभी को अत्यंत शुभ, पवित्र और कल्याणकारी बुद्धि से संयुक्त (प्रदान) करे।
            यह श्लोक लगभग 3.4 और 3.37 के समान ही है, जो उपनिषद के मूल संदेश (शुभ बुद्धि की मांग) को दोहराता है।
            हिरण्यगर्भ वह ब्रह्मांडीय बीज (Cosmic egg) है जिससे पूरा भौतिक संसार धीरे-धीरे विकसित हुआ है।
            परंतु ईश्वर उस बीज से भी पहले मौजूद था, इसलिए उसने उसे 'पैदा होते हुए देखा' (पश्यत जायमानं)।
            हमारी बुद्धि ही हमारा सबसे बड़ा हथियार और सबसे बड़ा दुश्मन है; यदि यह अशुद्ध है तो विनाश करती है।
            ऋषि यहाँ भगवान से यह वरदान मांग रहे हैं कि हमारी बुद्धि हमेशा सही (सत्य) और गलत (असत्य) को पहचान सके।
            जब बुद्धि शुभ हो जाती है, तो हमारे सभी कर्म स्वतः ही ईश्वरीय और कल्याणकारी बन जाते हैं।
        """.trimIndent(),
        english = """
            That great seer (Maharshi) and Rudra who is the root cause of the origin of all gods and their supreme protector.
            Who is the sole overlord (master) of this entire universe and who created everything at the beginning.
            Who directly witnessed the first cosmic being 'Hiranyagarbha' (Brahma) being born right before His eyes.
            May that Supreme Lord (Rudra) endow and unite all of us with a highly auspicious, pure, and beneficial intellect.
            This verse is almost identical to 3.4 and 3.37, reiterating the core message of the Upanishad (seeking pure intellect).
            Hiranyagarbha is that cosmic seed (cosmic egg) from which the entire physical world gradually evolved.
            But God existed even prior to that seed, which is why He 'witnessed it being born' (Pashyata Jayamanam).
            Our intellect is our greatest weapon and our greatest enemy; if it is impure, it causes absolute destruction.
            The sages are asking God for the boon that our intellect may always discern between right (Truth) and wrong (falsehood).
            When the intellect becomes auspicious, all our actions automatically become divine and beneficial for all.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 67,
        sanskrit = "यो देवानामधिपो यस्मिंल्लोका अधिश्रिताः । य ईशे अस्य द्विपदश्चतुष्पदः कस्मै देवाय हविषा विधेम ॥ ६७ ॥",
        hindi = """
            जो परमेश्वर सभी देवों (इंद्र, अग्नि, वरुण आदि) का भी महान अधिपति (मालिक/राजा) है।
            जिस एक के भीतर ये सभी लोक (स्वर्ग, पृथ्वी, पाताल) पूरी तरह से आश्रित और टिके हुए हैं।
            जो इस संसार के सभी दो पैरों वाले (मनुष्य/पक्षी) और चार पैरों वाले (पशु) जीवों पर शासन (ईशे) करता है।
            उस सुखस्वरूप और आनंदमय 'क' देव (परमात्मा) की ही हम हवि (भक्ति/प्रेम की आहुति) के द्वारा पूजा करें।
            वेद में 'क' शब्द का अर्थ प्रजापति या 'परम सुख' (Who) होता है, जो ईश्वर की रहस्यमयी प्रकृति को दर्शाता है।
            दुनिया के देवी-देवता स्वतंत्र शक्तियां नहीं हैं, वे सब उस एक 'अधिप' (Supreme Boss) के कर्मचारी हैं।
            गुरुत्वाकर्षण (Gravity) लोकों को नहीं थामे हुए है, यह तो ईश्वर की अदृश्य शक्ति है जिस पर ब्रह्मांड टिका है।
            वह चींटी से लेकर हाथी तक और इंसान से लेकर पक्षी तक—सभी के जीवन और कर्मों को नियंत्रित करता है।
            हमें किसी छोटी शक्ति की पूजा करने की बजाय सीधे उस सर्वोच्च आनंदमय देव की उपासना करनी चाहिए।
            भक्ति की सबसे अच्छी आहुति (हवि) कोई भौतिक वस्तु नहीं, बल्कि अपना अहंकार (Ego) ईश्वर को सौंप देना है।
        """.trimIndent(),
        english = """
            The Supreme Lord who is the great overlord (Master/King) of all the gods (Indra, Agni, Varuna, etc.).
            Within Whom all these worlds (heaven, earth, netherworlds) are completely supported and rest securely.
            Who absolutely rules (Ishe) over all the two-footed (humans/birds) and four-footed (animals) creatures of this world.
            To that blissful and joyous Deity 'Ka' (the Supreme), let us offer our worship with oblations (of love/devotion).
            In the Vedas, the word 'Ka' means Prajapati or 'Supreme Bliss' (Who), signifying the mystical nature of God.
            The deities of the world are not independent powers; they are all employees of that one 'Adhipa' (Supreme Boss).
            Gravity is not what holds the worlds; it is the invisible power of God upon which the universe truly rests.
            He controls the lives and actions of everyone—from the ant to the elephant, and from humans to birds.
            Instead of worshiping any lesser power, we should directly worship that highest blissful Supreme Deity.
            The best oblation (Havi) of devotion is not a material object, but completely surrendering one's ego to God.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 68,
        sanskrit = "सूक्ष्मातिसूक्ष्मं कलिलस्य मध्ये विश्वस्य स्रष्टारमनेकरूपम् । विश्वस्यैकं परिवेष्टितारं ज्ञात्वा शिवं शान्तिमत्यन्तमेति ॥ ६८ ॥",
        hindi = """
            जो परमात्मा सूक्ष्म से भी अत्यंत सूक्ष्म है और जो इस गहन अज्ञान (कलिल) के बीच में भी छिपा हुआ है।
            जो इस संपूर्ण विश्व का महान रचयिता है और जो अपनी माया से अनेक रूपों (अनेकरूपं) में प्रकट होता है।
            जो एक अद्वितीय ईश्वर इस पूरे ब्रह्मांड को सब ओर से घेरे हुए (परिवेष्टितारं) है।
            उस परम कल्याणकारी 'शिव' (परमात्मा) को यथार्थ रूप में जानकर मनुष्य अत्यंत और চিরस्थायी शांति प्राप्त करता है।
            ईश्वर इतना सूक्ष्म है कि दुनिया की भारी-भरकम और जटिल (कलिल) चीजों में वह दिखाई नहीं देता।
            जैसे घने जंगल (कलिल) में रास्ता खोजना मुश्किल है, वैसे ही संसार के शोर में ईश्वर को खोजना कठिन है।
            परंतु जो योगी ध्यान की गहराई में उतरता है, वह उस छिपे हुए रचयिता को अपने ही भीतर ढूँढ लेता है।
            ईश्वर अनेक रूप धारण करता है (पेड़, पशु, मनुष्य), पर वह इन सब रूपों को लपेटे हुए भी एक ही रहता है।
            शिव का अर्थ केवल एक हिंदू देवता नहीं है; शिव का अर्थ है 'कल्याण'—जो सबका हमेशा मंगल ही करता है।
            सच्ची शांति किसी स्थान (जैसे पहाड़) पर नहीं है; वह शांति उस 'शिव' तत्व को अपने भीतर 'जानने' में है।
        """.trimIndent(),
        english = """
            That Supreme Lord who is subtler than the absolute subtlest and is hidden in the midst of this dense chaos (ignorance/Kalila).
            Who is the great Creator of this entire universe and who manifests in manifold forms (Anekarupam) through His Maya.
            That one non-dual God who completely envelops and encompasses this whole universe from all sides.
            By truly knowing that supremely auspicious 'Shiva' (Supreme Lord), a person attains extreme and everlasting peace.
            God is so subtle that He remains completely invisible amidst the heavy and complex (Kalila) objects of the world.
            Just as finding a path in a dense forest (Kalila) is tough, finding God in the noise of the world is difficult.
            But the yogi who descends into the depths of meditation discovers that hidden Creator right within himself.
            God assumes many forms (trees, animals, humans), yet enveloping all these forms, He remains entirely One.
            Shiva does not merely mean a Hindu deity; Shiva means 'auspiciousness'—He who always does good for everyone.
            True peace is not found in a physical place (like mountains); it lies solely in 'knowing' that Shiva-principle within.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 69,
        sanskrit = "स एव काले भुवनस्य गोप्ता विश्वाधिपः सर्वभूतेषु गूढः । यस्मिन् युक्ता ब्रह्मर्षयो देवताश्च तमेवं ज्ञात्वा मृत्युपाशांश्छिनत्ति ॥ ६९ ॥",
        hindi = """
            वही एक परमात्मा समय-समय पर (काले) इस संसार (भुवन) की रक्षा करने वाला महान रक्षक (गोप्ता) है।
            वह संपूर्ण विश्व का एकमात्र अधिपति (मालिक) है और सभी छोटे-बड़े प्राणियों के भीतर गहराई से छिपा (गूढ़) है।
            उसी एक परब्रह्म के भीतर सभी महान ब्रह्मर्षि (ज्ञानी ऋषि) और सभी देवतागण ध्यान के द्वारा एकाकार (युक्त) हैं।
            उस परमात्मा को इस प्रकार (पूर्ण यथार्थ रूप में) जान लेने पर साधक मृत्यु के सभी पाशों (बंधनों) को काट देता है।
            संसार जब भी संकट में होता है, तब ईश्वर किसी न किसी रूप में उसकी रक्षा (गोप्ता) करने अवश्य आता है (जैसे अवतार)।
            वह बाहर से दुनिया को चलाता है और भीतर से 'आत्मा' बनकर हर जीव में शांति से छुपा हुआ (गूढ़) है।
            देवता और ऋषि भी अपनी शक्ति उसी परम स्रोत से प्राप्त करते हैं, वे उससे अलग होकर कुछ नहीं हैं।
            মৃত্যु (Death) कोई शारीरिक अंत नहीं है; बार-बार अज्ञान के कारण जन्म लेना ही असली मृत्यु है।
            ईश्वर का ज्ञान वह तेज तलवार है जो जन्म, मृत्यु, डर और कर्मों के सभी बंधनों (पाशों) को एक ही झटके में काट देती है।
            यह श्लोक ईश्वर की रक्षक प्रकृति (Preserver aspect) और मोक्ष की गारंटी को बहुत सुंदरता से बताता है।
        """.trimIndent(),
        english = """
            That one Supreme Lord is the great protector (Gopta) of this world from time to time (Kale).
            He is the sole overlord of the entire universe and is deeply hidden (Gudha) within all great and small beings.
            It is within that one Supreme Brahman that all the great Brahma-rishis (sages) and all the gods are perfectly united.
            By truly realizing that Supreme Lord in this manner, the seeker completely severs all the fetters of death.
            Whenever the world is in crisis, God inevitably comes in some form or another to protect it (like Avatars).
            He governs the world from the outside and is peacefully hidden (Gudha) as the 'Soul' inside every creature.
            The gods and sages also derive their power from that exact same supreme source; they are nothing apart from Him.
            Death is not a physical end; taking birth repeatedly due to sheer ignorance is the real death.
            The knowledge of God is that sharp sword which severs all bonds (Pashas) of birth, death, fear, and karma in one stroke.
            This verse beautifully highlights the protective nature (Preserver aspect) of God and the absolute guarantee of Moksha.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 70,
        sanskrit = "घृतात् परं मण्डमिवातिसूक्ष्मं ज्ञात्वा शिवं सर्वभूतेषु गूढम् । विश्वस्यैकं परिवेष्टितारं ज्ञात्वा देवं मुच्यते सर्वपाशैः ॥ ७० ॥",
        hindi = """
            जिस प्रकार घी (या दूध) के ऊपर एक अत्यंत सूक्ष्म मलाई (मण्ड) की परत आ जाती है, जो पूरे घी का सार है।
            उसी प्रकार, वह शिव (परमात्मा) अत्यंत सूक्ष्म है और सभी प्राणियों के भीतर गूढ़ रूप से छिपा हुआ है।
            उस एक अद्वितीय (एकं) परमेश्वर ने इस संपूर्ण विश्व को चारों ओर से पूरी तरह घेर (परिवेष्टितारं) रखा है।
            उस परम देव (प्रकाशमय ईश्वर) को यथार्थ रूप में जान लेने पर मनुष्य सभी प्रकार के पाशों (बंधनों) से मुक्त हो जाता है।
            यह उपनिषद की बहुत ही सरल और व्यावहारिक उपमा है: जैसे दूध में मलाई छिप कर रहती है और पूरे दूध को घेरे रहती है।
            वैसे ही भगवान इस पूरी दुनिया में छिपा हुआ है; दुनिया दूध है और भगवान उस दुनिया का सार (मलाई/Essence) है।
            मलाई को देखने के लिए दूध को स्थिर करना पड़ता है; उसी तरह ईश्वर को देखने के लिए मन को ध्यान में स्थिर करना पड़ता है।
            शिव का अर्थ केवल संहारक नहीं है, वह परम कल्याणकारी तत्व है जो हर जीव की भलाई चाहता है।
            दुनिया की कोई भी बेड़ी (मोह, लोभ, क्रोध) इतनी मजबूत नहीं है जो आत्मज्ञान के प्रकाश के सामने टिक सके।
            यह श्लोक अद्वैत ज्ञान की सरलता को बताता है—ईश्वर दुनिया से अलग नहीं है, वह दुनिया का सबसे सूक्ष्म रूप है।
        """.trimIndent(),
        english = """
            Just as an extremely subtle film of cream (Manda) forms on the surface of ghee (or milk), which is its very essence.
            Similarly, that Shiva (Supreme Lord) is exceedingly subtle and remains deeply hidden within all living beings.
            That one non-dual (Ekam) Supreme Lord has completely enveloped and encompassed this entire universe from all sides.
            By truly realizing that Supreme Deity (the luminous Lord), a person is completely freed from all fetters (bonds).
            This is a very simple and practical Upanishadic metaphor: just as cream hides in milk and covers the whole milk.
            In the exact same way, God is hidden in this entire world; the world is the milk, and God is its pure essence (cream).
            To see the cream, the milk must be made still; similarly, to see God, the mind must be made completely still in meditation.
            Shiva does not merely mean the destroyer; He is the supremely auspicious principle who desires the welfare of all.
            No chain of the world (delusion, greed, anger) is strong enough to survive before the brilliant light of Self-knowledge.
            This verse reveals the simplicity of non-dual wisdom—God is not separate from the world; He is its subtlest form.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 71,
        sanskrit = "एष देवो विश्वकर्मा महात्मा सदा जनानां हृदये सन्निविष्टः । हृदा मनीषा मनसाभिक्लृप्तो य एतद्विदुरमृतास्ते भवन्ति ॥ ७१ ॥",
        hindi = """
            यह परम प्रकाशमय देव (परमात्मा) ही इस संपूर्ण विश्व की रचना करने वाला असली 'विश्वकर्मा' है।
            वह महान आत्मा (महात्मा) हमेशा (सदा) सभी मनुष्यों और प्राणियों के हृदय के भीतर विराजमान है।
            उस परमेश्वर को केवल भावपूर्ण हृदय (हृदा), शुद्ध प्रज्ञा (मनीषा) और एकाग्र मन के द्वारा ही अनुभव किया जा सकता है।
            जो ज्ञानी मनुष्य इस रहस्य को भलीभांति जान लेते हैं, वे हमेशा के लिए जन्म-मरण से मुक्त (अमर) हो जाते हैं।
            'विश्वकर्मा' कोई अलग देवता नहीं है, यह ईश्वर की वह शक्ति है जिससे वह इस ब्रह्मांड का आर्किटेक्ट (Architect) बनता है।
            ईश्वर ने दुनिया बनाकर उसे अकेला नहीं छोड़ा; वह 'महात्मा' बनकर हम सबके दिल में बैठा धड़क रहा है।
            सत्य को कोरी बौद्धिक बहसों से नहीं पाया जा सकता; इसके लिए हृदय का प्रेम और बुद्धि की स्पष्टता दोनों चाहिए।
            जब हमारी भावनाएं (Heart) और हमारे विचार (Mind) एक साथ ईश्वर की ओर मुड़ते हैं, तब सत्य साक्षात् प्रकट होता है।
            अमरता का अर्थ यह जानना है कि 'मैं यह नष्ट होने वाला शरीर नहीं, बल्कि वह हमेशा रहने वाली चेतना हूँ।'
            यह श्लोक कठोपनिषद और श्वेताश्वतर (3.13) के समान ही है, जो ज्ञान और भक्ति के सुंदर समन्वय पर जोर देता है।
        """.trimIndent(),
        english = """
            This supremely luminous Deity (Supreme Lord) is the real 'Vishvakarma' (Architect) who created this entire universe.
            That Great Soul (Mahatma) is always (constantly) seated deeply within the hearts of all human beings and creatures.
            That Lord can be experienced only through a devoted heart (Hrida), pure intellect (Manisha), and a concentrated mind.
            Those wise people who thoroughly understand this profound mystery become completely immortal (free from birth and death) forever.
            'Vishvakarma' is not a separate deity; it is God's power by which He acts as the supreme Architect of this cosmos.
            God didn't create the world and leave it alone; as the 'Mahatma', He sits pulsating right inside everyone's heart.
            Truth cannot be attained by dry intellectual debates; it requires both the love of the heart and the clarity of the intellect.
            When our emotions (Heart) and our thoughts (Mind) turn towards God simultaneously, the Truth manifests directly.
            Immortality means knowing that 'I am not this perishable physical body, but that eternally existing pure consciousness.'
            This verse is identical to Katha Upanishad and Shvetashvatara (3.13), emphasizing the beautiful harmony of wisdom and devotion.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 72,
        sanskrit = "यदाऽतमस्तन्न दिवा न रात्रिर्न सन्न चासच्छिव एव केवलः । तदक्षरं तत्सवितुर्वरेण्यं प्रज्ञा च तस्मात् प्रसृता पुराणी ॥ ७२ ॥",
        hindi = """
            जब अज्ञान का अंधकार (तमस) पूरी तरह से मिट जाता है, तब वहाँ न दिन रह जाता है और न ही रात्रि होती है।
            उस अवस्था में न 'सत्' (भौतिक अस्तित्व) रहता है और न ही 'असत्' (शून्यता); वहाँ केवल एकमात्र 'शिव' ही शेष रहता है।
            वही परम तत्व अविनाशी (अक्षर) है, और वही सूर्य (सविता) के द्वारा भी पूजनीय और वरेण्य (अपनाने योग्य) है।
            उसी एक परब्रह्म से यह प्राचीन (पुराणी) और सनातन प्रज्ञा (ब्रह्मांडीय ज्ञान/बुद्धि) चारों ओर प्रवाहित (प्रसृता) हुई है।
            यह श्लोक मोक्ष (कैवल्य) की उस परम अवस्था का वर्णन करता है जो शब्दों और कल्पनाओं से बिल्कुल परे है।
            दिन और रात समय के परिचायक हैं; जब समय ही नहीं रहता, तो केवल एक शाश्वत 'अब' (Eternal Now) बचता है।
            सत् और असत् हमारी बुद्धि के पैमाने हैं; ईश्वर इन दोनों से परे केवल शुद्ध आनंद (शिव) का स्वरूप है।
            सूर्य हमें प्रकाश देता है, पर सूर्य को भी प्रकाश उस अक्षर ब्रह्म से ही मिलता है (तत् सवितुर्वरेण्यं - गायत्री मंत्र का भाव)।
            ज्ञान की शुरुआत वेदों या किताबों से नहीं हुई; असली ज्ञान उस ईश्वर की चेतना से ही ब्रह्मांड में फैला है।
            जब साधक उस 'केवल' (अकेले/Non-dual) शिव को पा लेता है, तो द्वैत के सभी भ्रम हमेशा के लिए मिट जाते हैं।
        """.trimIndent(),
        english = """
            When the darkness of ignorance (Tamas) is completely destroyed, then there remains neither day nor night.
            In that state, there is neither 'Sat' (manifest existence) nor 'Asat' (void/non-existence); there is only 'Shiva' alone.
            That Supreme Principle is Imperishable (Akshara), and He is adorable and worthy of worship even by the Sun (Savitr).
            From that single Supreme Brahman, this ancient (Purani) and eternal wisdom (cosmic intelligence) has flowed forth all around.
            This verse describes that ultimate state of Moksha (Kaivalya) which is completely beyond all words and imaginations.
            Day and night represent time; when time itself ceases to exist, only an 'Eternal Now' remains.
            Existence (Sat) and non-existence (Asat) are measures of our intellect; God is purely blissful (Shiva) beyond both.
            The sun gives us light, but the sun itself receives its light from that Imperishable Brahman (the essence of Gayatri Mantra).
            Wisdom did not originate from Vedas or books; real wisdom has spread into the cosmos from God's own consciousness.
            When a seeker attains that 'Kevala' (alone/non-dual) Shiva, all illusions of duality are wiped out forever.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 73,
        sanskrit = "नैनमूर्ध्वं न तिर्यञ्चं न मध्ये परिजग्रभत् । न तस्य प्रतिमा अस्ति यस्य नाम महद्यशः ॥ ७३ ॥",
        hindi = """
            उस परमात्मा को किसी ने भी ऊपर से, आड़े-तिरछे (बगल से) या बीच में से कभी भी पकड़ (समझ) नहीं पाया है।
            (अर्थात वह इतना असीम है कि उसे किसी भी दिशा या सीमा में पूरी तरह से नहीं बांधा जा सकता है)।
            उस महान ईश्वर की कोई भी 'प्रतिमा' (मूर्ति/समानता/उपमा) इस पूरे ब्रह्मांड में बिल्कुल भी मौजूद नहीं है।
            उसका असली नाम ही 'महद्यशः' (महान यश वाला / अनंत कीर्ति वाला) है; वह सबसे अनूठा और अद्वितीय है।
            हम भौतिक चीज़ों को ऊपर-नीचे से पकड़ कर नाप सकते हैं, पर ईश्वर कोई भौतिक वस्तु नहीं है।
            वह स्पेस (Space) और टाइम (Time) से बाहर है, इसलिए उसे मापना या पकड़ना इंसान के बस की बात नहीं है।
            'प्रतिमा' का अर्थ यहाँ केवल मूर्ति नहीं है, बल्कि इसका अर्थ है कि दुनिया में कोई भी चीज़ उसके 'जैसी' नहीं है।
            हम कह सकते हैं 'ईश्वर प्रकाश जैसा है', पर यह भी अधूरा है; ईश्वर केवल 'ईश्वर' जैसा है।
            उसका नाम 'महान यश' है क्योंकि दुनिया में जितनी भी अच्छी चीज़ें और अच्छाइयां हैं, वे सब उसी की यशोगाथा हैं।
            यह श्लोक ईश्वर की निरपेक्षता (Absoluteness) और उसकी अपार महानता (Transcendence) को स्थापित करता है।
        """.trimIndent(),
        english = """
            No one has ever been able to grasp (comprehend) Him from above, from across (the sides), or from the middle.
            (Meaning, He is so completely infinite that He can never be bound by any direction or physical limitation).
            There is absolutely no 'Pratima' (image/likeness/comparison) of that Great God existing anywhere in this cosmos.
            His very real name is 'Mahadyashah' (One of Infinite Glory / Great Fame); He is supremely unique and without a second.
            We can grasp and measure physical objects from top to bottom, but God is not a physical object at all.
            He is outside Space and Time, so measuring or catching Him is entirely beyond human capability.
            'Pratima' here doesn't just mean an idol; it means there is absolutely nothing in the world that is 'like' Him.
            We might say 'God is like light', but even that is incomplete; God is only like 'God'.
            His name is 'Great Glory' because whatever good things and virtues exist in the world are simply His praises.
            This verse establishes the absolute Transcendence and the unparalleled, incomparable greatness of the Supreme Lord.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 74,
        sanskrit = "न सन्दृशे तिष्ठति रूपमस्य न चक्षुषा पश्यति कश्चनैनम् । हृदा हृदिस्थं मनसा य एनमेवं विदुरमृतास्ते भवन्ति ॥ ७४ ॥",
        hindi = """
            उस परमात्मा का वास्तविक स्वरूप हमारी इन भौतिक आँखों की दृष्टि (सन्दृशे) के सामने कभी खड़ा नहीं होता।
            दुनिया का कोई भी मनुष्य अपनी इन चर्म-चक्षुओं (Skin eyes) से उस ईश्वर को बिल्कुल नहीं देख सकता है।
            वह तो हमेशा हमारे हृदय में स्थित (हृदिस्थं) है, और उसे केवल प्रेमपूर्ण हृदय और एकाग्र मन (मनसा) से ही जाना जा सकता है।
            जो ज्ञानी मनुष्य उस परब्रह्म को इस प्रकार (हृदय और मन से) जान लेते हैं, वे हमेशा के लिए अमर हो जाते हैं।
            ईश्वर कोई वस्तु नहीं है जो प्रकाश को रिफ्लेक्ट (Reflect) करे, इसलिए भौतिक आँखें उसे नहीं देख सकतीं।
            आँखें केवल रंगों और आकारों को देखती हैं, जबकि ईश्वर रंगहीन (अवर्ण) और आकारहीन (अरूप) है।
            उसे देखने के लिए 'अंतर्दृष्टि' (Inner Vision) चाहिए, जो केवल एक शांत और शुद्ध मन से ही प्राप्त होती है।
            हृदय भावों (Devotion) का केंद्र है और मन बुद्धि (Wisdom) का; इन दोनों के मिलन से ही परमात्मा प्रकट होता है।
            ईश्वर हमारे इतने करीब है कि वह हमारे दिल में ही धड़क रहा है, फिर भी हम उसे बाहर तलाश कर थक जाते हैं।
            अमर होने का अर्थ मौत को हराना नहीं, बल्कि उस आत्मा को पहचानना है जिसका कभी जन्म ही नहीं हुआ था।
        """.trimIndent(),
        english = """
            The true form of that Supreme Lord never stands before the vision (Sandrishe) of our physical eyes.
            No human being in the world can ever possibly see that God with these fleshy, physical eyes.
            He is always situated right within our own heart (Hridistham), and can be known only through a loving heart and a concentrated mind.
            Those wise people who truly know that Supreme Brahman in this manner (through heart and mind) become immortal forever.
            God is not a physical object that reflects light, which is exactly why physical eyes simply cannot see Him.
            Eyes only perceive colors and shapes, whereas God is completely colorless (Avarna) and formless (Arupa).
            To see Him, one needs 'Inner Vision', which is attained exclusively through a calm and perfectly pure mind.
            The heart is the center of devotion and the mind is of wisdom; God manifests only through the union of these two.
            God is so incredibly close to us that He beats within our own heart, yet we tire ourselves searching for Him outside.
            Becoming immortal does not mean defeating death, but recognizing that Soul which was never even born.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 75,
        sanskrit = "अजात इत्येवं कश्चिद्भीरुः प्रपद्यते । रुद्र यत्ते दक्षिणं मुखं तेन मां पाहि नित्यम् ॥ ७५ ॥",
        hindi = """
            हे परमात्मा! आप 'अजात' (अजन्मे) हैं, ऐसा जानकर संसार के भयों से डरा हुआ (भीरु) एक साधक।
            जन्म, मृत्यु और दुखों के डर से व्याकुल होकर पूरी तरह आपकी शरण (प्रपद्यते) में आता है।
            हे रुद्र (दुखों को नष्ट करने वाले ईश्वर)! आपका जो दक्षिण (सौम्य, दयालु और कल्याणकारी) मुख है।
            कृपया अपने उस प्रेमपूर्ण और कृपालु मुख से आप मेरी हमेशा (नित्य) रक्षा और पालन करें।
            यह श्लोक एक सच्चे साधक की उस गहरी पुकार (Prayer) को दर्शाता है जब वह संसार से थक कर भगवान की शरण लेता है।
            'अजात' का अर्थ है कि भगवान कभी जन्म और मरण के चक्र में नहीं पड़ते, इसलिए केवल वही हमें इस चक्र से बचा सकते हैं।
            जो खुद डूब रहा है, वह दूसरों को नहीं बचा सकता; ईश्वर किनारे पर खड़ा है, इसलिए केवल वही तारणहार है।
            ईश्वर के कई रूप हैं—कुछ कठोर (न्याय करने वाले) और कुछ दक्षिण (दया करने वाले)।
            भक्त यहाँ प्रार्थना कर रहा है कि हे प्रभु! मेरे पापों को देखकर कठोर मत होना, मुझ पर दया की दृष्टि ही रखना।
            शरणागति (Surrender) ही वह अंतिम मार्ग है जहाँ साधक का अहंकार शून्य हो जाता है और भगवान की कृपा शुरू होती है।
        """.trimIndent(),
        english = """
            O Supreme Lord! Knowing that You are 'Ajata' (unborn), a seeker who is deeply afraid (Bhiru) of worldly fears.
            Agitated by the terrifying fear of birth, death, and sorrows, he comes to take absolute refuge in You.
            O Rudra (the Lord who destroys all sorrows)! That 'Dakshina' (gentle, compassionate, and auspicious) face of Yours.
            Please, with that incredibly loving and merciful face, protect me and sustain me always (Nitya).
            This verse depicts the deep prayer of a sincere seeker when he gets tired of the world and seeks God's shelter.
            'Ajata' means God never falls into the cycle of birth and death, hence only He can save us from this cycle.
            One who is drowning cannot save others; God stands firmly on the shore, so He alone is the true Savior.
            God has many aspects—some are harsh (dispensing justice) and some are 'Dakshina' (showering mercy).
            The devotee prays here: O Lord! Do not be harsh seeing my sins; please look upon me only with eyes of mercy.
            Surrender (Sharanagati) is that ultimate path where the seeker's ego becomes zero and God's grace instantly begins.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 76,
        sanskrit = "मा नस्तोके तनये मा न आयौ मा नो गोषु मा नो अश्वेषु रीरिषः । वीरान्मा नो रुद्र भामितो वधीर्हविष्मन्तः सदमित् त्वा हवामहे ॥ ७६ ॥",
        hindi = """
            (चतुर्थ अध्याय का समापन): हे रुद्र (परमेश्वर)! आप क्रोधित होकर हमारे बच्चों (पुत्रों और पौत्रों) का, हमारी आयु का, हमारी गायों का और हमारे घोड़ों (संपत्ति) का विनाश न करें।
            हमारे वीर और श्रेष्ठ पुरुषों को अपने क्रोध का शिकार न बनाएं (उन्हें न मारें)।
            हम अपने हाथों में हवि (भक्ति और समर्पण की आहुति) लेकर हमेशा आपका आह्वान करते हैं और आपकी स्तुति करते हैं।
            यह श्लोक ऋग्वेद (1.114.8) का एक अत्यंत प्रसिद्ध प्रार्थना मंत्र है, जो यहाँ लिया गया है।
            जब साधक ईश्वर की अपार और भयंकर शक्ति को महसूस करता है, तो वह विनम्रता से अपने परिवार और समाज की रक्षा की भीख मांगता है।
            ईश्वर का संहारक रूप (रुद्र) अहंकारियों के लिए प्रलय है, पर जो समर्पण (हवि) के साथ झुक जाता है, उसके लिए वह रक्षक बन जाता है।
            यहाँ भौतिक संपत्ति (गायों, घोड़ों) की रक्षा का अर्थ है जीवन जीने के लिए आवश्यक साधनों की प्रार्थना करना।
            अध्यात्म का मतलब दुनिया को छोड़ना नहीं है, बल्कि ईश्वर की कृपा के साये में दुनिया का सही उपयोग करना है।
            यह श्लोक अध्याय 4 का समापन करता है, जहाँ ज्ञान की ऊंचाई के बाद एक भक्त की सीधी और सच्ची प्रार्थना झलकती है।
        """.trimIndent(),
        english = """
            (Conclusion of Chapter 4): O Rudra (Supreme Lord)! Do not, in Your anger, bring harm or destruction to our children (sons and grandsons), our lifespan, our cows, and our horses (wealth).
            Do not slay our heroic and noble men by making them victims of Your fierce wrath.
            Bearing oblations (the offering of devotion and surrender) in our hands, we constantly invoke You and sing Your praises.
            This verse is an extremely famous prayer mantra directly sourced from the Rigveda (1.114.8).
            When a seeker realizes the terrifying and infinite cosmic power of God, he humbly begs for the protection of his family and society.
            The destructive aspect of God (Rudra) is a cataclysm for the egoistic, but for the one who bows down with surrender (Havi), He becomes a flawless protector.
            Praying for the protection of material wealth (cows, horses) here simply means asking for the basic resources necessary to sustain life.
            Spirituality does not strictly mean abandoning the world, but rightly utilizing the world strictly under the protective shadow of God's grace.
            This verse concludes Chapter 4, beautifully showcasing a devotee's simple, sincere, and grounded prayer right after scaling the massive heights of cosmic wisdom.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 77,
        sanskrit = "द्वे अक्षरे ब्रह्मपरे त्वनन्ते विद्याविद्ये निहिते यत्र गूढे । क्षरं त्वविद्या ह्यमृतं तु विद्या विद्याविद्ये ईशते यस्तु सोऽन्यः ॥ ७७ ॥",
        hindi = """
            (पांचवां अध्याय प्रारंभ): उस अनंत और सबसे श्रेष्ठ परब्रह्म के भीतर दो चीजें अत्यंत गुप्त रूप से छिपी हुई हैं।
            वे दो चीजें हैं 'विद्या' (ज्ञान/चेतना) और 'अविद्या' (अज्ञान/प्रकृति); ये दोनों ही उसमें स्थित हैं।
            इनमें से जो 'अविद्या' है, वह क्षर (नष्ट होने वाली और परिवर्तनशील) है, जो जन्म-मरण का कारण है।
            परंतु जो 'विद्या' है, वह अमृत (अविनाशी) है, जो आत्मा को अमरता और मोक्ष की ओर ले जाती है।
            किंतु वह परमेश्वर इन दोनों (विद्या और अविद्या) से बिल्कुल अलग (अन्य) है, क्योंकि वह इन दोनों पर शासन करता है।
            यह श्लोक बहुत स्पष्ट करता है कि अज्ञान और ज्ञान—दोनों ही ईश्वर की बनाई हुई शक्तियां हैं।
            अविद्या हमें दुनिया में उलझाती है, जबकि विद्या हमें दुनिया से निकालकर वापस ईश्वर तक पहुँचाती है।
            पर ईश्वर न तो अविद्या है और न ही विद्या; वह इन दोनों उपकरणों (Tools) का इस्तेमाल करने वाला मास्टर है।
            साधक को अविद्या को छोड़कर विद्या को अपनाना चाहिए, और अंत में विद्या को भी छोड़कर उस ईश्वर में समा जाना चाहिए।
            जो इन दोनों के पार है, वही असली सत्य है; बाकी सब केवल उस सत्य तक पहुँचने के रास्ते हैं।
        """.trimIndent(),
        english = """
            (Beginning of Chapter 5): Within that infinite and supreme Brahman, two things are deeply hidden.
            Those two things are 'Vidya' (knowledge/consciousness) and 'Avidya' (ignorance/nature); both reside in Him.
            Of these, 'Avidya' is perishable (Kshara) and mutable, acting as the root cause of birth and death.
            But 'Vidya' is immortal (Amrita) and imperishable, leading the soul directly towards immortality and Moksha.
            However, that Supreme Lord is completely distinct (Anya) from both of these, for He rules over both of them.
            This verse clarifies profoundly that both ignorance and knowledge are powers created by God Himself.
            Avidya entangles us in the material world, while Vidya pulls us out and leads us back to the Divine.
            But God is neither Avidya nor Vidya; He is the absolute Master who wields both of these tools.
            A seeker must abandon ignorance and embrace knowledge, and ultimately transcend even knowledge to merge in God.
            He who is beyond both is the absolute Truth; everything else is merely a pathway to reach that Truth.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 78,
        sanskrit = "यो योनिं योनिमधितिष्ठत्येको विश्वानि रूपाणि योनीश्च सर्वाः । ऋषिं प्रसूतं कपिलं यस्तमग्रे ज्ञानैर्बिभर्ति जायमानं च पश्येत् ॥ ७८ ॥",
        hindi = """
            वह जो एक अद्वितीय परमात्मा है, वह सृष्टि के प्रत्येक कारण (योनि) पर अपना पूरा शासन रखता है।
            वह इस दुनिया के सभी रूपों, सभी प्रजातियों और उत्पत्ति के सभी स्थानों (योनि) का एकमात्र अधिष्ठाता है।
            जिसने सृष्टि के बिल्कुल आरंभ में 'कपिल' नामक उस महान और पवित्र ऋषि (हिरण्यगर्भ) को उत्पन्न किया।
            और जिसने उस उत्पन्न हुए ऋषि को सभी प्रकार के ज्ञान से भर दिया और उसे जन्म लेते हुए साक्षात् देखा।
            ईश्वर ही वह अकेला बीज है जिससे यह सारा ब्रह्मांड और इसके अनगिनत रूप पैदा हुए हैं।
            कपिल यहाँ सांख्य दर्शन वाले ऋषि नहीं हैं, बल्कि यह सृष्टि के पहले जीव (ब्रह्मा/हिरण्यगर्भ) का प्रतीक है।
            'कपिल' का अर्थ है सुनहरे या भूरे रंग वाला (स्वर्ण-आभा), जो ब्रह्मांडीय ज्ञान और प्रकाश का साक्षात् रूप है।
            ईश्वर ने केवल शरीर नहीं बनाए, उसने शुरुआत से ही जीव के भीतर 'ज्ञान' (चेतना) को भी भरा है।
            वह हमारे हर जन्म और हमारे हर विकास को एक दृष्टा की तरह बहुत ही प्यार से देख रहा है।
            यह श्लोक ईश्वर को सृष्टि के परम रचयिता और प्रथम गुरु के रूप में बहुत ही सुंदरता से स्थापित करता है।
        """.trimIndent(),
        english = """
            That one non-dual Supreme Lord holds absolute dominion over every single cause (Yoni) of creation.
            He is the sole presiding deity over all forms, all species, and all places of origin in this world.
            Who, at the very beginning of creation, gave birth to that great and sacred sage named 'Kapila' (Hiranyagarbha).
            And who nourished that born sage with all forms of supreme wisdom and directly witnessed him being born.
            God alone is that single seed from which this entire universe and its countless forms have sprouted.
            'Kapila' here does not mean the sage of Samkhya philosophy, but symbolizes the first cosmic being (Brahma).
            'Kapila' means golden or tawny-hued, representing the direct embodiment of cosmic wisdom and light.
            God didn't just create physical bodies; He infused 'knowledge' (consciousness) into the soul from the very beginning.
            He is watching our every birth and our continuous evolution with immense love, like an observing Witness.
            This verse beautifully establishes the Supreme Lord as the ultimate Creator and the very first Guru of creation.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 79,
        sanskrit = "एकैकं जालं बहुधा विकुर्वन्नस्मिन् क्षेत्रे संहरत्येष देवः । भूयः सृष्ट्वा यतयस्तथेशः सर्वाधिपत्यं कुरुते महात्मा ॥ ७९ ॥",
        hindi = """
            वह परमेश्वर (देव) इस संसार रूपी क्षेत्र (मैदान) में अपने माया रूपी जाल को अनेक प्रकार से फैलाता है।
            वह हर एक जीव के लिए अलग-अलग कर्मों और भोगों का जाल बुनता है, और फिर प्रलय के समय उसे समेट लेता है।
            वह महान आत्मा (महात्मा) वाला ईश्वर अपनी शक्तियों (यतयः/प्रजापतियों) को फिर से उत्पन्न करके।
            उन सबके ऊपर अपना पूर्ण आधिपत्य (Supreme Rulership) स्थापित करता है और उन पर शासन करता है।
            संसार ईश्वर द्वारा बिछाया गया एक विशाल और रहस्यमयी जाल (Net) है, जिसमें जीव अपने कर्मों से फँसता है।
            वह इस जाल को बनाने वाला अकेला जादूगर है, जो अलग-अलग जीवों के लिए अलग-अलग परिस्थितियां बनाता है।
            पर यह जाल हमेशा नहीं रहता; जब खेल खत्म होता है, तो वह इसे समेट कर वापस अपने भीतर रख लेता है।
            सृष्टि और प्रलय की यह प्रक्रिया कोई एक बार की घटना नहीं है, यह एक अनंत और लगातार चलने वाला चक्र है।
            वह देवताओं (प्रजापतियों) को बनाता है ताकि वे दुनिया चलाएं, पर अंतिम रिमोट कंट्रोल उसी के हाथ में रहता है।
            यह श्लोक ईश्वर की महानता और सृष्टि के निर्माण-विनाश की वैज्ञानिक और चक्रीय (Cyclic) प्रकृति को दर्शाता है।
        """.trimIndent(),
        english = """
            That Supreme Deity spreads His net of Maya in multiple, diverse ways in this field (the world).
            He weaves a different web of karmas and experiences for every single soul, and withdraws it at the time of dissolution.
            That Great Soul (Mahatma/Lord), having created His powers and lords of creation (Yatis/Prajapatis) all over again.
            Establishes His absolute overlordship (Supreme Rulership) over all of them and governs them perfectly.
            The world is a vast and mystical net cast by God, in which the soul gets caught through its own karmas.
            He is the lone magician weaving this net, creating perfectly tailored situations for different individual souls.
            But this net is not permanent; when the cosmic play ends, He folds it up and keeps it back within Himself.
            This process of creation and dissolution is not a one-time event; it is an infinite and continuous cycle.
            He creates the gods to run the universe, but the ultimate remote control remains strictly in His hands.
            This verse illustrates God's greatness and the highly scientific, cyclic nature of the universe's creation and destruction.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 80,
        sanskrit = "सर्वा दिश ऊर्ध्वमधश्च तिर्यक् प्रकाशयन् भ्राजते यद्वनड्वान् । एवं स देवो भगवान् वरेण्यो योनिस्वभावानधितिष्ठत्येकः ॥ ८० ॥",
        hindi = """
            जिस प्रकार अकेला सूर्य ऊपर, नीचे, तिरछे और सभी दिशाओं को पूरी तरह से प्रकाशित करता हुआ चमकता है।
            ठीक उसी प्रकार, वह परम पूजनीय, वरेण्य (अपनाने योग्य) और ऐश्वर्यशाली भगवान (परमात्मा) भी है।
            वह एक अकेला ही इस पूरी सृष्टि और सभी कारणों (योनियों) तथा उनके स्वभावों पर अपना नियंत्रण रखता है।
            सूर्य केवल भौतिक दुनिया का अंधकार मिटाता है, पर परमात्मा सूर्य का भी सूर्य है जो पूरी चेतना को प्रकाशित करता है।
            ईश्वर की शक्ति (प्रकाश) किसी एक जगह तक सीमित नहीं है, वह ब्रह्मांड के हर छोटे-बड़े कोने में मौजूद है।
            योनि-स्वभाव का अर्थ है कि अग्नि का काम जलाना है और पानी का काम शीतल करना—यह उनका स्वभाव है।
            परंतु आग जलेगी और पानी शीतल करेगा, यह नियम भी उसी एक परमात्मा द्वारा तय किया गया है और उसी के अधीन है।
            वह अकेला है, पर उसकी ऊर्जा (Light) अनंत है। दुनिया का हर जीव उसी की ऊर्जा से काम कर रहा है।
            जब हम सूर्य को देखते हैं, तो हमें उस परमेश्वर की सर्वव्यापकता और उसके प्रकाश का साक्षात् स्मरण होना चाहिए।
            यह श्लोक ईश्वर की महिमा को समझाने के लिए सूर्य की सबसे सटीक और खूबसूरत उपमा का प्रयोग करता है।
        """.trimIndent(),
        english = """
            Just as the single sun shines brilliantly, completely illuminating above, below, across, and all directions.
            In the exact same way shines that highly adorable, excellent, and supremely glorious Lord (Bhagavan).
            He alone completely controls and presides over all the causes of creation (Yonis) and their inherent natures.
            The sun only removes the darkness of the physical world, but God is the sun of the sun, illuminating all consciousness.
            God's power (Light) is not limited to one place; it is fully present in every tiny and massive corner of the cosmos.
            'Yoni-svabhava' means fire burns and water cools—this is their inherent, natural characteristic.
            But the rule that fire will burn and water will cool is also set by and strictly governed by that one Lord.
            He is One, yet His energy is infinite. Every creature in the world operates solely on His borrowed energy.
            Whenever we look at the sun, we should directly remember the omnipresence and the absolute light of that Lord.
            This verse uses the most precise and beautiful metaphor of the sun to deeply explain the magnificent glory of God.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 81,
        sanskrit = "यच्च स्वभावं पचति विश्वयोनिः पाच्यांश्च सर्वान् परिणामयेद्यः । सर्वमेतद्विश्वमधितिष्ठत्येको गुणांश्च सर्वान् विनियोजयेद्यः ॥ ८१ ॥",
        hindi = """
            वह जो इस संपूर्ण विश्व का मूल कारण (विश्वयोनि) है, वह प्रत्येक वस्तु के स्वभाव को पकाता (परिपक्व करता) है।
            और जो वस्तुएं पकने (विकसित होने) योग्य हैं, उन सभी को वह धीरे-धीरे रूपांतरित (परिणामयेत्) करता है।
            वह एक अद्वितीय परमात्मा ही इस सारे ब्रह्मांड पर पूर्ण रूप से अपना नियंत्रण और शासन (अधितिष्ठति) रखता है।
            और वही एक ईश्वर प्रकृति के सभी गुणों (सत्त्व, रज, तम) को उनके उचित कार्यों में लगाता (विनियोजयति) है।
            'पकाना' एक बहुत ही गहरा शब्द है; जैसे सूरज कच्चे फल को पकाकर मीठा करता है, वैसे ही ईश्वर जीव को पकाता है।
            कर्म, दुख और अनुभव वह आग हैं जिससे ईश्वर हमारी चेतना को पकाकर (Evolve करके) शुद्ध और परिपक्व करता है।
            संसार में जो भी बदलाव (परिणाम) आ रहे हैं—जैसे बच्चे का जवान होना—वह उसी के नियम के तहत हो रहा है।
            तीनों गुण (सत्त्व, रज, तम) स्वतंत्र नहीं हैं; ईश्वर उन्हें आदेश देता है कि कब किसे जाग्रत करना है और कब सुलाना है।
            ईश्वर सृष्टि का रचयिता भी है और इसका मुख्य संचालक (Director) भी; उसके बिना प्रकृति एक कदम भी नहीं चल सकती।
            यह श्लोक सृष्टि के विकास (Evolution) के पीछे काम कर रहे ईश्वरीय हाथ को बहुत ही स्पष्ट रूप से दिखाता है।
        """.trimIndent(),
        english = """
            He who is the root cause of this entire universe (Vishvayoni), ripens (matures) the inherent nature of everything.
            And all those things that are capable of ripening (evolving), He gradually transforms and evolves them.
            That one non-dual Supreme Lord alone completely controls, governs, and presides over this entire universe.
            And He alone is the one who distributes and assigns all the qualities (Sattva, Rajas, Tamas) to their appropriate tasks.
            'Ripening' is a profound concept; just as the sun ripens a raw fruit making it sweet, God ripens the soul.
            Karma, sorrow, and experiences are the fire through which God cooks (evolves) our consciousness, making it pure and mature.
            Whatever transformations occur in the world—like a child growing into a youth—happen strictly under His law.
            The three Gunas are not independent; God commands them on when to awaken and when to become dormant.
            God is both the creator of the cosmos and its Chief Director; without Him, Nature cannot take a single step.
            This verse very clearly reveals the divine, invisible hand actively working behind the cosmic evolution of creation.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 82,
        sanskrit = "तद्वेदगुह्योपनिषत्सु गूढं तद्ब्रह्मा वेदयते ब्रह्मयोनिम् । ये पूर्वदेवा ऋषयश्च तद्विदुस्ते तन्मया अमृता वै बभूवुः ॥ ८२ ॥",
        hindi = """
            वह परम सत्य (परमात्मा) वेदों के भी सबसे रहस्यमयी और गुप्त भाग 'उपनिषदों' में अत्यंत गहराई से छिपा हुआ है।
            ब्रह्मा जी (हिरण्यगर्भ) भी उस परब्रह्म को वेदों के परम स्रोत (ब्रह्मयोनि) के रूप में भलीभांति जानते हैं।
            प्राचीन काल के जो देवता और जो महान ऋषि उस परम सत्य को यथार्थ रूप में जान गए थे।
            वे सभी उस परमात्मा में पूरी तरह लीन (तन्मय) होकर निश्चित रूप से हमेशा के लिए अमर (अमृत) हो गए।
            ईश्वर कोई साधारण जानकारी नहीं है जिसे किसी भी किताब में आसानी से पढ़ा जा सके; वह 'गुह्य' (गुप्त) है।
            वह केवल उन्हीं को समझ में आता है जो उपनिषदों के ज्ञान का अपने हृदय में गहरा ध्यान और मंथन करते हैं।
            वेद स्वयं उस ईश्वर से निकले हैं (ब्रह्मयोनि); इसलिए वेद ईश्वर को नहीं बनाते, बल्कि ईश्वर वेदों का कारण है।
            अमर होने का अर्थ शारीरिक रूप से जिंदा रहना नहीं है, बल्कि अपनी चेतना को उस अनंत तत्व के साथ मिला देना है।
            जब साधक तन्मय (तल्लीन) हो जाता है, तो साधक और भगवान के बीच का सारा भेद पूरी तरह मिट जाता है।
            यह श्लोक उपनिषदों की महानता और आत्मज्ञान द्वारा प्राप्त होने वाली मोक्ष की स्थिति को प्रमाणित करता है।
        """.trimIndent(),
        english = """
            That Supreme Truth (God) is deeply hidden within the Upanishads, which are the most secret and mystical parts of the Vedas.
            Lord Brahma (Hiranyagarbha) also knows that Supreme Brahman perfectly well as the ultimate source of the Vedas (Brahmayoni).
            Those ancient gods and those great ancient sages who realized that Supreme Truth in its absolute reality.
            They all became completely absorbed (Tanmaya) in that Supreme Lord and undoubtedly became immortal forever.
            God is not ordinary information that can be easily read in any book; He is deeply 'Guhya' (secret/hidden).
            He is understood only by those who deeply meditate and churn the wisdom of the Upanishads within their hearts.
            The Vedas themselves emerged from God; hence Vedas don't create God, rather God is the very cause of the Vedas.
            Becoming immortal does not mean surviving physically, but merging one's consciousness completely with that infinite Principle.
            When a seeker becomes 'Tanmaya' (absorbed), all distinction between the seeker and God is completely obliterated.
            This verse certifies the supreme greatness of the Upanishads and the state of Moksha attained through Self-knowledge.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 83,
        sanskrit = "गुणान्वयो यः फलकर्मकर्ता कृतस्य तस्यैव स चोपभोक्ता । स विश्वरूपस्त्रिगुणस्त्रिवर्त्मा प्राणाधिपः सञ्चरति स्वकर्मभिः ॥ ८३ ॥",
        hindi = """
            (अब जीवात्मा का वर्णन): जो जीव सत्व, रज और तम—इन तीन गुणों से घिरा (गुणान्वय) हुआ है।
            जो फल की इच्छा से कर्मों को करता है, वही जीव अपने किए हुए उन कर्मों के फल का उपभोग (भोग) भी करता है।
            वह अनेक रूप धारण करने वाला (विश्वरूप), तीनों गुणों से युक्त और तीन मार्गों (धर्म, अधर्म, ज्ञान) पर चलने वाला है।
            वह प्राणों का स्वामी (प्राणाधिप) है, जो अपने ही किए गए कर्मों के अनुसार जन्म-मरण के चक्र में भटकता (संचरण) रहता है।
            यह श्लोक जीवात्मा (Individual Soul) के दुख और उसके बंधनों का मुख्य कारण स्पष्ट करता है।
            आत्मा शुद्ध है, पर जब वह प्रकृति के तीन गुणों (रस्सी) से जुड़ जाती है, तो वह 'जीव' बन जाती है।
            हम जो बोते हैं, वही काटते हैं; यदि हम इच्छा से कर्म करेंगे, तो हमें उसका फल भोगने के लिए दोबारा जन्म लेना होगा।
            विश्वरूप का अर्थ है कि जीव कभी इंसान, कभी जानवर और कभी देवता का रूप धारण करता रहता है।
            वह प्राणों का राजा है, यानी वह शरीर को चलाता है, पर अपने ही कर्मों का गुलाम बन गया है।
            जब तक गुणों और कर्मों का यह खेल चलता है, तब तक जीव इस ब्रह्मांड के चक्रव्यूह में बिना शांति के भटकता रहता है।
        """.trimIndent(),
        english = """
            (Description of the individual soul): The soul that is endowed and enveloped by the three Gunas (Sattva, Rajas, Tamas).
            Who performs actions with the desire for fruits, that very soul also ultimately reaps and enjoys the fruits of those actions.
            He is the assumer of manifold forms (Vishvarupa), endowed with the three Gunas, and travels on three paths (virtue, vice, wisdom).
            He is the lord of the vital breaths (Pranadhipa), who wanders endlessly in the cycle of rebirth according to his own karmas.
            This verse clearly explains the primary cause of the individual soul's (Jivatma) sorrow and its heavy bondage.
            The soul is pure, but when it associates with the three qualities of nature (ropes), it becomes the bound 'Jiva'.
            We reap exactly what we sow; if we perform actions with desire, we must take birth again to consume their fruits.
            'Vishvarupa' implies that the soul continuously takes various forms—sometimes human, sometimes animal, sometimes divine.
            He is the king of the Pranas, meaning he drives the body, yet he has become an absolute slave to his own karmas.
            As long as this play of Gunas and karmas continues, the soul wanders restlessly without peace in this cosmic labyrinth.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 84,
        sanskrit = "अंगुष्ठमात्रो रवितुल्यरूपः संकल्पाहंकारसमन्वितो यः । बुद्धेर्गुणेनात्मगुणेन चैव आराग्रमात्रोऽप्यपरोऽपि दृष्टः ॥ ८४ ॥",
        hindi = """
            वह जीवात्मा हृदय में अँगूठे के आकार (अंगुष्ठमात्र) का है और वह सूर्य के समान अत्यंत प्रकाशमान रूप वाला है।
            परंतु वह अपने संकल्पों (इच्छाओं) और अहंकार ('मैं' का भाव) के साथ पूरी तरह से जुड़ा हुआ है।
            बुद्धि के गुणों और शरीर के गुणों के साथ मिल जाने के कारण वह जीव अपने असली रूप को भूल जाता है।
            इस मिलावट के कारण वह अनंत आत्मा बैलगाड़ी के पहिए की आरा (तीलियों) की नोक (आराग्र) जितना अत्यंत सूक्ष्म (छोटा) दिखाई देता है।
            यहाँ उपनिषद जीवात्मा के असली और नकली (व्यावहारिक) स्वरूप के बीच का भेद बता रहा है।
            मूल रूप से आत्मा सूर्य की तरह विशाल और चमकीली है, पर इच्छाओं ने उसे अँगूठे जितना छोटा कर दिया है।
            जब आत्मा के साथ अहंकार (Ego) जुड़ जाता है, तो वह खुद को सीमित शरीर मानकर बहुत छोटा और कमजोर महसूस करता है।
            'आराग्रमात्र' (सुई की नोक जितना) होना आत्मा की कमजोरी नहीं, बल्कि उसके भ्रम और सूक्ष्मता का प्रतीक है।
            वह वास्तव में महान है (अपरः), पर अपनी बुद्धि के सीमित चश्मे से देखने के कारण वह खुद को तुच्छ (बिंदु मात्र) समझता है।
            मोक्ष का अर्थ इस छोटे से बिंदु को वापस उस असीम सूर्य के साथ मिला देना है जहाँ से यह आया था।
        """.trimIndent(),
        english = """
            That individual soul is the size of a thumb (Angushtamatra) in the heart and is highly luminous like the blazing sun.
            However, it is completely united and entangled with its resolves (desires) and ego (the sense of 'I').
            Due to associating with the qualities of the intellect and the body, the soul completely forgets its true nature.
            Because of this mixture, that infinite soul appears exceedingly tiny, as extremely subtle as the point of an awl (Aragra).
            Here the Upanishad is explaining the deep difference between the real and the perceived (practical) nature of the soul.
            Fundamentally, the soul is vast and bright like the sun, but desires have shrunk its perception to the size of a thumb.
            When ego attaches to the soul, it falsely identifies with the limited body and feels incredibly small and weak.
            Being 'Aragramatra' (the size of a needle's point) is not the soul's weakness, but a symbol of its deep illusion and subtlety.
            He is actually truly great (Apara), but looking through the limited lens of intellect, he considers himself insignificant (a mere dot).
            Moksha means merging this tiny dot back into that boundless, infinite sun from which it originally came.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 85,
        sanskrit = "वालाग्रशतभागस्य शतधा कल्पितस्य च । भागो जीवः स विज्ञेयः स चानन्त्याय कल्पते ॥ ८५ ॥",
        hindi = """
            यदि बाल के आगे वाले (सबसे पतले) हिस्से के एक सौ (100) टुकड़े किए जाएं।
            और फिर उस एक टुकड़े के भी दोबारा एक सौ (100) हिस्से कर दिए जाएं (यानी बाल का 10,000वां हिस्सा)।
            उस अत्यंत सूक्ष्म भाग को ही तुम 'जीवात्मा' का आकार समझो (अर्थात वह इतना सूक्ष्म है कि दिखाई नहीं देता)।
            इतना सूक्ष्म और छोटा होते हुए भी, वह जीव वास्तव में 'अनंत' (असीम परब्रह्म) होने की पूरी क्षमता (कल्पते) रखता है।
            यह श्लोक जीवात्मा की भौतिक सूक्ष्मता और उसकी आध्यात्मिक विशालता का सबसे बड़ा और प्रसिद्ध उदाहरण है।
            आत्मा को किसी माइक्रोस्कोप या साइंस के यंत्र से नहीं देखा जा सकता, क्योंकि वह पदार्थ (Matter) है ही नहीं।
            बाल का दस हजारवां हिस्सा केवल यह बताने के लिए है कि आत्मा का कोई भौतिक फैलाव (Physical dimension) नहीं है।
            परंतु इस छोटे से बिंदु के भीतर पूरे ब्रह्मांड को अपने अंदर समेट लेने की अपार ताकत और चेतना छिपी हुई है।
            जब तक जीव अज्ञान में है, वह एक छोटे से कण की तरह रोता और भटकता रहता है।
            पर जब ज्ञान का विस्फोट होता है, तो वह छोटा सा कण ब्रह्मांड के पार फैलकर 'अनंत' परमात्मा बन जाता है।
        """.trimIndent(),
        english = """
            If the very tip (the thinnest part) of a hair were divided perfectly into one hundred (100) equal parts.
            And if one of those tiny parts were further divided again into one hundred (100) parts (i.e., 1/10,000th of a hair).
            That incredibly subtle fraction should be known as the dimension of the 'Jiva' (individual soul).
            Yet, despite being so unimaginably minute and subtle, that soul holds the full potential to become 'Infinite' (the Supreme).
            This verse provides the greatest and most famous example of the soul's physical subtlety and its spiritual vastness.
            The soul cannot be seen with any microscope or scientific tool because it is absolutely not material (matter).
            The ten-thousandth part of a hair is merely to illustrate that the soul has no physical dimension or extension.
            But hidden within this tiny point is the immense power and consciousness capable of enveloping the entire universe.
            As long as the soul remains in ignorance, it weeps and wanders endlessly like a tiny, helpless particle.
            But when the explosion of wisdom occurs, that tiny particle expands beyond the cosmos and becomes the 'Infinite' God.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 86,
        sanskrit = "नैव स्त्री न पुमानेष न चैवायं नपुंसकः । यद्यच्छरीरमादत्ते तेन तेन स युज्यते ॥ ८६ ॥",
        hindi = """
            यह जीवात्मा वास्तव में न तो स्त्री (औरत) है, न ही यह पुरुष (आदमी) है।
            और न ही यह आत्मा नपुंसक (Genderless in physical sense) है; इसका अपना कोई भौतिक लिंग नहीं है।
            यह आत्मा अपने कर्मों के अनुसार जिस-जिस प्रकार का भौतिक शरीर (स्त्री, पुरुष या पशु) धारण करती है।
            वह अज्ञान के कारण स्वयं को उसी शरीर के रूप (लिंग) और गुणों के साथ जोड़कर (युज्यते) वैसा ही मान लेती है।
            यह श्लोक शरीर के लिंग-भेद (Gender) और सामाजिक पहचान के अहंकार को जड़ से उखाड़ फेंकता है।
            आत्मा केवल शुद्ध चेतना है; 'मैं आदमी हूँ' या 'मैं औरत हूँ' यह केवल शरीर का एक कपड़ा है जिसे हमने पहना है।
            जैसे पानी जिस बर्तन में जाता है उसी का आकार ले लेता है, वैसे ही आत्मा जिस शरीर में जाती है, वैसी ही लगने लगती है।
            हमारा सारा दुख इसी गलत पहचान (False identification) के कारण है कि हम खुद को एक सीमित शरीर मान बैठे हैं।
            जब कोई साधक इस सत्य को अनुभव करता है, तो उसके भीतर से सारा लैंगिक अहंकार (Gender ego) और भेदभाव मिट जाता है।
            यह उपनिषदों की वह समानता (Equality) है जो इंसानों को आत्मा के स्तर पर एक समान और पवित्र मानती है।
        """.trimIndent(),
        english = """
            This individual soul, in its true reality, is neither a woman, nor is it a man.
            Nor is this soul an androgyne (neuter); it has absolutely no physical gender or biological sex of its own.
            Whatever type of physical body (female, male, or animal) this soul assumes strictly according to its past karmas.
            Due to ignorance, it completely associates and identifies (Yujyate) itself with the gender and traits of that very body.
            This verse completely uproots the ego of bodily gender differences and transient social identities from the core.
            The soul is pure consciousness; saying 'I am a man' or 'I am a woman' is merely referring to the bodily garment we wear.
            Just as water takes the shape of the vessel it is poured into, the soul appears as the body it enters.
            All our suffering is due to this false identification, where we mistakenly believe ourselves to be a limited body.
            When a seeker directly experiences this truth, all gender ego and discrimination vanish entirely from within him.
            This is the supreme equality taught by the Upanishads, treating all humans as equal and sacred at the level of the Soul.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 87,
        sanskrit = "संकल्पनस्पर्शनदृष्टिमोहैर्ग्रासाम्बुवृष्ट्या चात्मविवृद्धिजन्म । कर्मानुगान्यनुक्रमेण देही स्थानेषु रूपाण्यभिसम्प्रपद्यते ॥ ८७ ॥",
        hindi = """
            यह जीव अपने मन के संकल्प (इच्छाओं), स्पर्श, दृष्टि और मोह (आसक्ति) के कारण ही बार-बार जन्म लेता है।
            जिस प्रकार भोजन (ग्रास) और जल (अंबु) की वृष्टि से भौतिक शरीर का विकास (वृद्धि) होता है।
            उसी प्रकार, इच्छाओं और मोह की वृष्टि से यह जीवात्मा अनेक प्रकार के शरीर धारण कर संसार में पुष्ट होती है।
            यह देहधारी जीव (देही) अपने पूर्व जन्मों के कर्मों का अनुसरण करते हुए, क्रम के अनुसार एक के बाद एक।
            विभिन्न स्थानों (योनियों/लोकों) में जाकर अलग-अलग भौतिक रूपों (शरीरों) को प्राप्त करता रहता है।
            जन्म लेने का असली कारण भगवान का आदेश नहीं, बल्कि हमारी अपनी ही अधूरी इच्छाएं (संकल्प) और मोह है।
            हम जिन चीजों को देखते हैं, छूते हैं और प्यार करते हैं, वही चीजें हमें अगले जन्म के लिए एक नया शरीर दे देती हैं।
            जैसे शरीर खाने-पीने से मोटा होता है, वैसे ही हमारा 'अहंकार' वासनाओं को भोगने से मोटा और मजबूत होता है।
            कर्म एक बीज है, और शरीर उसका फल है। जब तक बीज रहेगा, तब तक जन्म-मरण की यह खेती लगातार चलती रहेगी।
            केवल आत्मज्ञान (Self-knowledge) की अग्नि ही वह उपाय है जो इच्छाओं के इन बीजों को हमेशा के लिए जला सकती है।
        """.trimIndent(),
        english = """
            This soul takes birth repeatedly entirely due to the resolves of the mind (desires), touch, sight, and delusion (attachment).
            Just as the physical body grows and develops through the nourishment of food (morsels) and the shower of water.
            Similarly, nourished by the shower of desires and delusions, this soul grows and takes on various bodies in the world.
            This embodied soul (Dehi), strictly following the consequences of its past karmas, sequentially one after another.
            Goes to various places (different species/realms) and continuously acquires different physical forms (bodies) there.
            The real cause of rebirth is not God's command, but our very own unfulfilled desires (Sankalpa) and strong attachments.
            The things we look at, touch, and intensely crave act as magnets that forge a new body for us in the next life.
            Just as the body fattens by eating and drinking, our 'ego' fattens and strengthens by indulging in worldly lusts.
            Karma is a seed, and the body is its fruit. As long as the seed remains, this farming of birth and death will continue.
            Only the fierce fire of Self-knowledge is the ultimate solution that can permanently burn these seeds of desire.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 88,
        sanskrit = "स्थूलानि सूक्ष्माणि बहूनि चैव रूपाणि देही स्वगुणैर्वृणोति । क्रियागुणैरात्मगुणैश्च तेषां संयोगहेतुरपरोऽपि दृष्टः ॥ ८८ ॥",
        hindi = """
            यह देहधारी जीवात्मा अपने ही गुणों (सत्त्व, रज, तम) और वासनाओं के अनुसार अनेक रूप धारण करता है।
            वह अपने कर्मों के अनुसार कभी बहुत स्थूल (बड़े/भौतिक) और कभी अत्यंत सूक्ष्म (छोटे/अदृश्य) शरीर चुनता है।
            शरीर के कार्यों (क्रियागुण) और मन की इच्छाओं (आत्मगुण) के कारण ही वह बार-बार नए शरीरों से जुड़ता है।
            और इस प्रकार वह बार-बार जन्म लेकर एक के बाद एक अन्य शरीरों (अपरोऽपि) के संयोग (जुड़ाव) का कारण बनता है।
            यह श्लोक पुनर्जन्म (Reincarnation) की वैज्ञानिक प्रक्रिया को गहराई से समझाता है।
            आत्मा को कोई बाहरी अदालत सजा नहीं देती; आत्मा की अपनी इच्छाएं ही उसका अगला शरीर (सूक्ष्म या स्थूल) तय करती हैं।
            यदि जीवन भर पशुओं जैसा लालच किया है, तो प्रकृति उसी गुण के अनुसार अगला शरीर पशु का दे देती है।
            हमारे कर्म (क्रिया) और हमारे विचार (आत्मगुण) मिलकर एक ऐसा गोंद (Glue) बनाते हैं जो आत्मा को नए शरीर से चिपका देता है।
            यह चक्र तब तक नहीं टूटता जब तक कि आत्मा अपने स्वरूप को पहचान कर इन सभी भौतिक गुणों से मुक्त न हो जाए।
            सच्ची आज़ादी का मतलब अपनी इच्छाओं और कर्मों पर ऐसा नियंत्रण पाना है कि वे गोंद बनना बंद कर दें।
        """.trimIndent(),
        english = """
            This embodied soul assumes countless diverse forms strictly according to its own qualities (Sattva, Rajas, Tamas) and desires.
            Based on its karmas, it selects bodies that are sometimes very gross (large/physical) and sometimes extremely subtle (tiny/invisible).
            It is solely due to the qualities of its actions (Kriyaguna) and the desires of its mind (Atmaguna) that it attaches to new bodies.
            And thus, taking birth repeatedly, it becomes the active cause for its conjunction (union) with one new body after another (Aparo-api).
            This verse profoundly explains the exact scientific and psychological process of reincarnation.
            No external court punishes the soul; the soul's own deep-seated desires determine its next body (gross or subtle).
            If one has lived with animalistic greed, Nature automatically provides the body of an animal matching that exact quality.
            Our actions (Kriya) and our thoughts (Atmaguna) combine to create a glue that firmly sticks the soul to a new body.
            This cycle does not break until the soul recognizes its true nature and completely frees itself from all these material qualities.
            True freedom means gaining such absolute mastery over desires and actions that they completely stop acting as glue.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 89,
        sanskrit = "अनाद्यनन्तं कलिलस्य मध्ये विश्वस्य स्रष्टारमनेकरूपम् । विश्वस्यैकं परिवेष्टितारं ज्ञात्वा देवं मुच्यते सर्वपाशैः ॥ ८९ ॥",
        hindi = """
            वह परमेश्वर अनादि (जिसकी कोई शुरुआत नहीं) और अनंत (जिसका कोई अंत नहीं) है।
            वह इस गहन और उलझे हुए अज्ञान रूपी जंगल (कलिल) के बिल्कुल बीचोबीच छिपा हुआ है।
            वह इस संपूर्ण विश्व का महान रचयिता है और अनेक रूपों (अनेकरूपं) में स्वयं प्रकट हो रहा है।
            वह एक अद्वितीय परमात्मा ही इस पूरे ब्रह्मांड को सब ओर से घेरे हुए (परिवेष्टितारं) है।
            उस परम प्रकाशमय देव को यथार्थ रूप में जान लेने पर मनुष्य सभी प्रकार के पाशों (बंधनों) से मुक्त हो जाता है।
            यह श्लोक लगभग 4.14 और 4.16 की गूंज है, जो अध्याय के अंत में मुख्य संदेश को दोहराता है।
            'कलिल' (गहन अज्ञान) का अर्थ है कि दुनिया की उलझनों के बीच भगवान को देखना बहुत मुश्किल लगता है।
            परंतु वह दुनिया से बाहर नहीं है; वह इसी शोरगुल और भीड़ के बीच परम शांति के रूप में बैठा है।
            जब साधक को यह ज्ञान हो जाता है, तो उसके कर्मों, इच्छाओं और भयों की सभी जंजीरें टूट कर गिर जाती हैं।
            ईश्वर को जानना ही मोक्ष है; मोक्ष कोई मरने के बाद मिलने वाला इनाम नहीं, बल्कि जीते-जी अज्ञान का टूटना है।
        """.trimIndent(),
        english = """
            That Supreme Lord is completely without beginning (Anadi) and absolutely without end (Ananta).
            He is deeply hidden right in the very midst of this dense, chaotic, and tangled forest of ignorance (Kalila).
            He is the great Creator of this entire universe and is manifesting Himself in manifold, diverse forms (Anekarupam).
            That one non-dual Supreme God completely envelops and encompasses this whole universe from all sides.
            By truly realizing that supremely luminous Deity, a person is completely freed from all fetters and bonds (Pashas).
            This verse echoes 4.14 and 4.16, reiterating the core message at the conclusion of the chapter.
            'Kalila' (dense ignorance) implies that finding God amidst the intense complexities of the world seems extremely difficult.
            But He is not outside the world; He sits right in the middle of this noise and crowd as ultimate peace.
            When a seeker attains this wisdom, all chains of his past karmas, worldly desires, and deep fears shatter and fall away.
            Knowing God is itself Moksha; Moksha is not a post-death reward, but the shattering of ignorance while fully alive.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 90,
        sanskrit = "भावग्राह्यमनीडाख्यं भावाभावकरं शिवम् । कलासर्गकरं देवं ये विदुस्ते जहुस्तनुम् ॥ ९० ॥",
        hindi = """
            (पांचवें अध्याय का समापन): वह परमात्मा केवल शुद्ध 'भाव' (श्रद्धा/प्रेम/शुद्ध चेतना) के द्वारा ही ग्रहण (प्राप्त) किया जा सकता है।
            उसे 'अनीड' (बिना घोंसले/शरीर का) कहा जाता है, क्योंकि उसका कोई भौतिक शरीर या निश्चित स्थान नहीं है।
            वही ईश्वर सृष्टि का अस्तित्व (भाव) बनाता है और प्रलय के समय उसका विनाश (अभाव) भी करता है; वह परम शिव (कल्याणकारी) है।
            वही परम देव सोलह कलाओं (प्राण, मन, पंचभूत आदि) की रचना करने वाला (कलासर्गकर) है।
            जो ज्ञानी पुरुष उस परमात्मा को यथार्थ रूप में जान लेते हैं, वे इस भौतिक शरीर (तनु) के मोह को हमेशा के लिए त्याग देते हैं।
            ईश्वर को कोरे तर्क, बहस या विज्ञान के उपकरणों से कभी नहीं पकड़ा जा सकता; वह केवल शुद्ध हृदय (भाव) की पकड़ में आता है।
            अनीड का अर्थ है कि वह किसी एक मंदिर, मस्जिद या आकाश में कैद नहीं है; वह सर्वव्यापी है।
            सृष्टि को बनाना और मिटाना कोई क्रूरता नहीं है, यह उस 'शिव' (कल्याण करने वाले) का ब्रह्मांडीय नृत्य है।
            जब साधक सत्य को जान लेता है, तो शरीर से उसका चिपकना (Attachment) खत्म हो जाता है।
            वह जान लेता है कि शरीर केवल एक अस्थायी कपड़ा है, जबकि उसकी असली पहचान वह अमर शिव है।
        """.trimIndent(),
        english = """
            (Conclusion of Chapter 5): That Supreme Lord can be grasped (attained) only through pure 'Bhava' (faith/love/pure consciousness).
            He is called 'Anida' (without a nest/body), because He has no physical body or fixed limited dwelling place.
            That Lord alone brings about the existence (creation) and non-existence (dissolution) of the world; He is the supremely auspicious Shiva.
            That Supreme Deity is the creator of the sixteen parts (Prana, mind, elements, etc.) of cosmic manifestation.
            Those wise men who truly know that Supreme Lord in His essence completely abandon their attachment to the physical body (Tanu) forever.
            God can never be caught by dry logic, debates, or scientific instruments; He is grasped solely by a pure, devoted heart (Bhava).
            'Anida' means He is not imprisoned in any single temple, mosque, or heaven; He is completely omnipresent.
            Creating and destroying the universe is not an act of cruelty; it is the cosmic dance of that 'Shiva' (the Auspicious One).
            When a seeker realizes the absolute truth, his desperate clinging (attachment) to the physical body simply vanishes.
            He fully realizes that the body is merely a temporary garment, while his true identity is that immortal Shiva.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 91,
        sanskrit = "स्वभावमेके कवयो वदन्ति कालंतथान्ये परिमुह्यमानाः । देवस्यैष महिमा तु लोके येनेदं भ्राम्यते ब्रह्मचक्रम् ॥ ९१ ॥",
        hindi = """
            (छठा अध्याय प्रारंभ): कुछ विद्वान (कवि) अज्ञानवश कहते हैं कि यह संसार चीज़ों के अपने 'स्वभाव' (Nature) से अपने-आप चल रहा है।
            तथा कुछ अन्य लोग मोह (भ्रम) में पड़कर कहते हैं कि 'काल' (समय) ही इस सृष्टि का मुख्य कारण और रचयिता है।
            परंतु सत्य तो यह है कि इस लोक में जो कुछ भी हो रहा है, वह सब उस एक परम देव (ईश्वर) की ही महान महिमा है।
            उसी परमेश्वर की शक्ति के द्वारा यह 'ब्रह्मचक्र' (संसार रूपी विशाल पहिया) निरंतर घुमाया जा रहा है।
            अंतिम अध्याय यहाँ फिर से उसी सवाल पर आता है जो पहले श्लोक में पूछा गया था: सृष्टि का कारण क्या है?
            विज्ञान (Science) अक्सर कहता है कि दुनिया प्रकृति के नियमों (स्वभाव) और समय के संयोग से बनी है।
            पर उपनिषद कहता है कि जो खुद जड़ (Inert) है, वह इतनी व्यवस्थित दुनिया कैसे बना सकता है?
            समय और प्रकृति तो केवल साधन हैं; असली इंजन तो भगवान की महिमा है जो सब कुछ चला रही है।
            ब्रह्मचक्र का घूमना कोई एक्सीडेंट नहीं है; इसके पीछे एक सर्वोच्च चेतना (Supreme Intelligence) का हाथ है।
            जब हम इस सच को मानते हैं, तो जीवन का नजरिया बदल जाता है और हम हर घटना में ईश्वर का हाथ देखते हैं।
        """.trimIndent(),
        english = """
            (Beginning of Chapter 6): Some scholars (poets), out of ignorance, declare that this world runs automatically by its own 'Nature' (Svabhava).
            And others, being deeply deluded, claim that 'Time' (Kala) is the primary cause and creator of this universe.
            But the absolute truth is that whatever exists in this world is entirely the magnificent glory of that one Supreme God.
            It is solely by the power of that Supreme Lord that this 'Brahmachakra' (the vast cosmic wheel of the world) is continuously revolved.
            The final chapter returns here to the very same question asked in the first verse: What is the cause of creation?
            Science often asserts that the world was formed merely by the laws of nature and the combination of time.
            But the Upanishad argues: How can something completely inert (matter) create such a highly organized world?
            Time and Nature are merely instruments; the real engine is God's glory which is driving everything perfectly.
            The spinning of the Brahmachakra is no accident; there is a Supreme Intelligence actively working behind it.
            When we accept this profound truth, our perspective changes, and we see the hand of God in every single event.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 92,
        sanskrit = "येनावृतं खल्विदं विश्वमेतद् ज्ञः कालकालो गुणी सर्वविद्यः । तेनेशितं कर्म विवर्तते ह पृथिव्यप्तेजोऽनिलखानि चिन्त्यम् ॥ ९२ ॥",
        hindi = """
            जिस एक परमेश्वर के द्वारा यह संपूर्ण विश्व निश्चित रूप से सब ओर से ढका हुआ (आवृत) है।
            जो स्वयं सब कुछ जानने वाला (ज्ञः), काल का भी काल (महाकाल), सभी शुभ गुणों का सागर और सर्वविद्य (संपूर्ण ज्ञान स्वरूप) है।
            उसी परमात्मा के आदेश और नियंत्रण (ईशितं) से ही यह पूरा संसार और कर्मों का चक्र निरंतर घूम (विवर्तते) रहा है।
            उसी के आदेश से पृथ्वी, जल, अग्नि, वायु और आकाश (पंचभूत) अपना-अपना काम कर रहे हैं; इसी का चिंतन करना चाहिए।
            ईश्वर दुनिया का एक हिस्सा नहीं है; वह दुनिया को ऐसे घेरे हुए है जैसे आकाश सब चीजों को घेरे रहता है।
            वह 'काल का भी काल' है, यानी समय इंसानों को मारता है, पर ईश्वर समय को भी जन्म देता है और खत्म कर देता है।
            प्रकृति के पाँचों तत्व (पंचभूत) आजाद नहीं हैं; पानी बहता है और आग जलती है क्योंकि ईश्वर का ऐसा 'आदेश' है।
            यह श्लोक ईश्वर के पूर्ण नियंत्रण (Absolute Control) को स्थापित करता है, जिसके बिना सृष्टि में अराजकता (Chaos) फैल जाएगी।
            कर्मों का फल अपने-आप नहीं मिलता; ईश्वर ही वह न्यायाधीश है जो हमारे कर्मों का सही चक्र घुमाता है।
            साधक को हमेशा इस सत्य का मनन (चिंतन) करना चाहिए कि वह कभी भी उस सर्वज्ञ ईश्वर की नज़रों से बाहर नहीं है।
        """.trimIndent(),
        english = """
            That one Supreme Lord by whom this entire universe is undoubtedly enveloped and covered from all sides.
            Who is Himself the Knower of all (Jnah), the Time of time (Mahakala), the ocean of all virtues, and the embodiment of all wisdom.
            It is strictly under the command and control of that Lord that this entire world and the cycle of karma continuously revolves.
            By His command alone do earth, water, fire, air, and ether perform their duties; this truth must be deeply contemplated.
            God is not a part of the world; He envelops the world exactly as space encompasses all physical objects.
            He is the 'Time of time', meaning time kills humans, but God gives birth to time and ultimately destroys time itself.
            The five elements of nature are not independent; water flows and fire burns simply because of God's 'command'.
            This verse establishes God's absolute control, without which total chaos would spread throughout the cosmos.
            The fruits of karma do not manifest automatically; God is the Supreme Judge who accurately turns the wheel of our actions.
            A seeker must constantly contemplate this truth that he is never, ever outside the vision of that omniscient Lord.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 93,
        sanskrit = "तत्कर्म कृत्वा विनिवर्त्य भूयस्तत्त्वस्य तत्त्वेन समेत्य योगम् । एकेन द्वाभ्यां त्रिभिरष्टभिर्वा कालेन चैवात्मगुणैश्च सूक्ष्मैः ॥ ९३ ॥",
        hindi = """
            साधक को ईश्वर के लिए कर्म करके (तत्कर्म कृत्वा), उन कर्मों के फलों से अपने मन को पूरी तरह हटा (विनिवर्त्य) लेना चाहिए।
            फिर उसे एक (गुरु), दो (प्रेम और ज्ञान), तीन (सत्त्व, रज, तम पर विजय) या आठ (अष्टांग योग) साधनों के द्वारा।
            और समय (काल) के साथ-साथ आत्मा के सूक्ष्म गुणों (विवेक, वैराग्य आदि) के द्वारा अभ्यास करना चाहिए।
            इन सभी साधनों का उपयोग करके उसे अपनी आत्मा (तत्त्व) का उस परब्रह्म (परम तत्त्व) के साथ योग (मिलाप) कराना चाहिए।
            यह श्लोक निष्काम कर्मयोग (Desireless action) और राजयोग का एक अत्यंत सुंदर और व्यावहारिक मिश्रण है।
            कर्म करना छोड़ना नहीं है, बल्कि कर्म के फल की आसक्ति (Attachment) को छोड़ना है।
            अष्टांग योग (यम, नियम, आसन, प्राणायाम, प्रत्याहार, धारणा, ध्यान, समाधि) वह सीढ़ी है जो आत्मा तक ले जाती है।
            अध्यात्म में समय (Patience) लगता है; रातों-रात मोक्ष नहीं मिलता, इसलिए काल को भी एक साधन माना गया है।
            मन के सूक्ष्म गुणों (जैसे क्षमा, शांति) के बिना किया गया योग केवल एक शारीरिक व्यायाम है।
            योग का अंतिम लक्ष्य अपनी आत्मा की बूंद को उस परमात्मा के महासागर के साथ एक कर देना (समेत्य योगम्) है।
        """.trimIndent(),
        english = """
            A seeker should perform actions dedicated to God, and then completely withdraw (detach) his mind from their fruits.
            Then, utilizing one (Guru), two (love and wisdom), three (mastery over Gunas), or eight (Ashtanga Yoga) methods.
            Along with the passage of time (patience) and the subtle, pure qualities of the soul (discrimination, dispassion).
            Using all these means, he must bring about the perfect union (Yoga) of his own soul (Tattva) with the Supreme Truth.
            This verse is an exceptionally beautiful and practical blend of Nishkama Karma Yoga (desireless action) and Raja Yoga.
            One must not stop performing actions; one must only drop the attachment to the fruits of those actions.
            Ashtanga Yoga (the eightfold path) is the sturdy ladder that leads the seeker directly to the Soul.
            Spirituality requires time (Patience); Moksha is not achieved overnight, hence Time is also considered a vital tool.
            Yoga practiced without cultivating the subtle qualities of the mind (like forgiveness, peace) is merely a physical exercise.
            The ultimate goal of Yoga is to merge the drop of one's soul entirely into the vast ocean of the Supreme Lord.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 94,
        sanskrit = "आरभ्य कर्माणि गुणान्वितानि भावांश्च सर्वान् विनियोजयेद्यः । तेषामभावे कृतकर्मनाशः कर्मक्षये याति स तत्त्वतोऽन्यः ॥ ९४ ॥",
        hindi = """
            जो साधक सत्व आदि गुणों से युक्त होकर ईश्वर की प्रसन्नता के लिए शुभ कर्मों का आरंभ करता है।
            और फिर अपने सभी भावों, विचारों और कर्मों को पूरी तरह से उस परमेश्वर के चरणों में समर्पित (विनियोजय) कर देता है।
            ईश्वर को समर्पण करने के कारण (अभावे) उसके द्वारा किए गए कर्मों के बंधन और अहंकार का पूर्ण नाश हो जाता है।
            जब इस प्रकार उसके सभी कर्मों का क्षय (विनाश) हो जाता है, तब वह जन्म-मरण से पार हो जाता है।
            वह साधक अपनी इस भौतिक प्रकृति से बिल्कुल अलग होकर (अन्यः) उस परम तत्व (ब्रह्म) को प्राप्त कर लेता है।
            यह श्लोक भगवद्गीता के 'कर्मयोग' और 'भक्तियोग' का सबसे मूल आधार है।
            जब हम 'मैं कर रहा हूँ' सोचकर काम करते हैं, तो हम कर्म के जाल में फँस जाते हैं।
            पर जब हम अपना काम भगवान को अर्पित कर देते हैं, तो कर्म हमें बांध नहीं पाता, वह पूजा बन जाता है।
            जैसे भुने हुए बीज से पौधा नहीं उगता, वैसे ही समर्पित कर्मों से अगला जन्म नहीं होता (कर्मक्षय)।
            सच्ची आज़ादी तब मिलती है जब जीव खुद को इस शरीर और प्रकृति (Matter) से पूरी तरह अलग (अन्य) अनुभव कर लेता है।
        """.trimIndent(),
        english = """
            The seeker who, endowed with pure qualities (Sattva), begins performing noble actions solely to please God.
            And then completely dedicates and surrenders all his emotions, thoughts, and actions at the feet of that Supreme Lord.
            Due to this complete surrender, the binding nature and ego of all the actions he performs are entirely destroyed.
            When all his karmas are thus exhausted and annihilated (Karmakshaya), he crosses over birth and death.
            That seeker becomes completely distinct (Anya) from his physical nature and attains the Supreme Principle (Brahman).
            This verse forms the very foundational basis of 'Karma Yoga' and 'Bhakti Yoga' found in the Bhagavad Gita.
            When we act thinking 'I am the doer', we get tightly caught in the sticky web of karma.
            But when we offer our work to God, the karma loses its power to bind us; it transforms into pure worship.
            Just as a roasted seed cannot sprout into a plant, surrendered actions cannot cause a future rebirth.
            True freedom is achieved when the soul experiences itself as entirely separate (Anya) from the body and material nature.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 95,
        sanskrit = "आदिः स संयोगनिमित्तहेतुः परस्त्रिकालादकलोऽपि दृष्टः । तं विश्वरूपं भवभूतमीड्यं देवं स्वचित्तस्थमुपास्य पूर्वम् ॥ ९५ ॥",
        hindi = """
            वह परमात्मा ही सबका 'आदि' (शुरुआत) है, और वही जीव तथा शरीर के संयोग (मिलन) का मुख्य कारण है।
            वह तीनों कालों (भूत, वर्तमान, भविष्य) से पूरी तरह परे है, और वह कलाओं (अंशों) से रहित (अकल) अखंड स्वरूप है।
            वह परमेश्वर अनेक रूपों वाला (विश्वरूप) है, वही संसार का रचयिता (भवभूत) है और वही स्तुति करने योग्य (ईड्य) है।
            साधक को चाहिए कि वह सबसे पहले उस परम देव की अपने ही चित्त (हृदय) के भीतर एकाग्र होकर उपासना करे।
            जब तक ईश्वर की इच्छा न हो, तब तक आत्मा और शरीर का जुड़ाव (संयोग/जन्म) नहीं हो सकता।
            ईश्वर समय के फ्रेम में फिट नहीं होता, इसलिए वह कभी बूढ़ा नहीं होता; वह 'अकल' है यानी उसका कोई टुकड़ा नहीं किया जा सकता।
            उसे खोजने के लिए किसी तीर्थ में जाने से पहले उसे 'स्वचित्तस्थ' (अपने ही मन में स्थित) मानकर पूजना चाहिए।
            हमारा मन ही सबसे बड़ा मंदिर है; यदि वहाँ ईश्वर नहीं मिला, तो वह बाहर कहीं नहीं मिलेगा।
            विश्वरूप होने का अर्थ है कि बाहर की सारी दुनिया उसी की मूर्ति है, इसलिए दुनिया की सेवा भी उसकी उपासना है।
            यह श्लोक आंतरिक ध्यान और ईश्वर की समय-रहित (Timeless) प्रकृति पर गहरा जोर देता है।
        """.trimIndent(),
        english = """
            That Supreme Lord is the 'Origin' (Adi) of all, and He is the primary cause of the union between the soul and the body.
            He is completely beyond the three periods of time (past, present, future), and He is seen as partless (Akala) and unbroken.
            He is the assumer of universal forms (Vishvarupa), the creator of the world, and the only one worthy of worship (Idya).
            The seeker should first and foremost worship that Supreme Deity intently by realizing Him right within his own mind (heart).
            Without the will of God, the union (birth) of the conscious soul and the physical body can never take place.
            God does not fit into the frame of time, so He never ages; He is 'Akala', meaning He cannot be divided into parts.
            Before going to any pilgrimage to find Him, one must worship Him as 'Svachittastha' (residing in one's own mind).
            Our own mind is the greatest temple; if God is not found there, He will not be found anywhere outside.
            Being Vishvarupa means the entire outside world is His idol, hence serving the world is also His worship.
            This verse places profound emphasis on internal meditation and the absolutely timeless (eternal) nature of God.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 96,
        sanskrit = "स वृक्षकालाकृतिभिः परोऽन्यो यस्मात् प्रपञ्चः परिवर्ततेऽयम् । धर्मावहं पापनुदं भगेशं ज्ञात्वात्मस्थममृतं विश्वधाम ॥ ९६ ॥",
        hindi = """
            वह परमात्मा इस संसार रूपी वृक्ष, काल (समय) और सभी आकारों (आकृतियों) से पूरी तरह परे और भिन्न (अन्य) है।
            उसी परम शक्ति के कारण ही यह सारा संसार (प्रपंच) निरंतर घूम रहा है और परिवर्तित हो रहा है।
            वह धर्म को लाने वाला (धर्मावह) है, सभी पापों को नष्ट करने वाला (पापनुद) है, और संपूर्ण ऐश्वर्य का स्वामी (भगेश) है।
            उस अमर और संपूर्ण विश्व के आश्रय (विश्वधाम) परमात्मा को अपनी ही आत्मा में स्थित (आत्मस्थ) जानकर मनुष्य मुक्त हो जाता है।
            दुनिया एक पेड़ की तरह है जो लगातार बदल रहा है, पर भगवान उस पेड़ से अलग उसका बीज और आधार है।
            हम जो भी बदलाव (ऋतुएं, उम्र, जन्म-मृत्यु) देखते हैं, वह ईश्वर के ही महान पहिए का घूमना है।
            जब हम ईश्वर की ओर बढ़ते हैं, तो हमारे जीवन में धर्म (अच्छाई) अपने आप आ जाता है और पाप जल जाते हैं।
            'भगेश' का अर्थ है जिसके पास दुनिया का सारा ज्ञान, बल, धन और वैराग्य पूर्ण रूप से मौजूद है।
            ईश्वर पूरे ब्रह्मांड का घर (विश्वधाम) है, पर मजे की बात यह है कि वह हमारे छोटे से दिल में (आत्मस्थ) भी रहता है।
            उसको बाहर ढूँढना अज्ञान है; उसे अपने ही भीतर पहचान लेना ही मोक्ष का सीधा और सरल रास्ता है।
        """.trimIndent(),
        english = """
            That Supreme Lord is completely beyond and distinct (Anya) from this tree of the world, time, and all physical forms.
            It is solely due to His supreme power that this entire world (Prapancha) continuously revolves and undergoes transformation.
            He is the bringer of righteousness (Dharmavaha), the destroyer of all sins (Papanuda), and the Lord of all opulence (Bhagesha).
            By knowing that immortal Lord, who is the refuge of the universe, as seated within one's own soul, man becomes liberated.
            The world is like a constantly changing tree, but God is the unchangeable seed and foundation separate from that tree.
            Whatever changes we witness (seasons, aging, birth-death) are merely the spinning of God's great cosmic wheel.
            When we move towards God, Dharma (goodness) automatically enters our lives and all our sins are burnt away.
            'Bhagesha' means the one who possesses all the wisdom, strength, wealth, and dispassion of the world perfectly.
            God is the home of the entire universe (Vishvadhama), yet fascinatingly, He also dwells in our tiny heart (Atmastha).
            Searching for Him outside is sheer ignorance; recognizing Him right within oneself is the direct and simple path to Moksha.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 97,
        sanskrit = "तमीश्वराणां परमं महेश्वरं तं देवतानां परमं च दैवतम् । पतिं पतीनां परमं परस्ताद् विदाम देवं भुवनेशमीड्यम् ॥ ९७ ॥",
        hindi = """
            वह परमात्मा सभी ईश्वरों (शासकों/मालिकों) का भी सबसे बड़ा और परम 'महेश्वर' (महान ईश्वर) है।
            वह सभी देवताओं (इंद्र, ब्रह्मा आदि) का भी सबसे परम और श्रेष्ठ देवता (परमं दैवतं) है।
            वह सभी पतियों (पालकों/रक्षकों) का भी परम पति है, और वह इस दृश्यमान जगत से अत्यंत परे (परस्तात्) है।
            हम उस परम पूजनीय (ईड्य) और संपूर्ण लोकों के एकमात्र स्वामी (भुवनेश) परम देव को भलीभांति जानते (विदाम) हैं।
            दुनिया में बहुत से राजा और ताकतवर लोग हैं, पर वे सब उस 'महेश्वर' के सामने एक तिनके के समान हैं।
            हम देवी-देवताओं की पूजा करते हैं, पर उन देवताओं को भी शक्ति उसी एक परम देवता से मिलती है।
            'पति' का अर्थ रक्षक है; जब कोई हमारा रक्षक नहीं होता, तब वह परम पति ही हमारी रक्षा करता है।
            वह इस दुनिया को चलाता जरूर है, पर वह इस दुनिया की गंदगी और सीमाओं से बहुत ऊपर (परस्तात्) है।
            ऋषि यहाँ पूरे ब्रह्मांड के इकलौते और सर्वोच्च बॉस (Supreme Boss) की बहुत ही स्पष्ट घोषणा कर रहे हैं।
            ऐसे महान ईश्वर को छोड़कर किसी और से कुछ मांगना मूर्खता है; हमें उसी भुवनेश की उपासना करनी चाहिए।
        """.trimIndent(),
        english = """
            He is the supreme and greatest 'Maheshvara' (Great Lord) even among all the lords (rulers/masters) of the world.
            He is the most supreme and ultimate Deity (Paramam Daivatam) even among all the gods (Indra, Brahma, etc.).
            He is the supreme Master of all masters (protectors), and He exists infinitely beyond (Parastat) this visible universe.
            We truly know (recognize) that highly adorable (Idya) Supreme Deity who is the sole Lord of all the worlds (Bhuvanesha).
            There are many kings and powerful people in the world, but they are all like a mere blade of grass before that 'Maheshvara'.
            We worship various deities, but even those gods receive their power exclusively from that one Supreme Deity.
            'Pati' means protector; when no one else protects us, that Supreme Master alone fiercely protects us.
            He certainly runs this world, but He is situated far above (Parastat) the dirt, pain, and limitations of this world.
            The sage here makes a very clear and thunderous declaration of the single, absolute Supreme Boss of the entire cosmos.
            Asking anyone else for anything, ignoring such a great God, is foolishness; we must worship only that Bhuvanesha.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 98,
        sanskrit = "न तस्य कार्यं करणं च विद्यते न तत्समश्चाभ्यधिकश्च दृश्यते । परास्य शक्तिर्विविधैव श्रूयते स्वाभाविकी ज्ञानबलक्रिया च ॥ ९८ ॥",
        hindi = """
            उस परमात्मा का न तो कोई 'कार्य' (बनाने के लिए शरीर) है और न ही कोई 'करण' (काम करने के लिए इंद्रियां) है।
            इस पूरे ब्रह्मांड में न तो कोई उसके समान (बराबर) है, और न ही उससे अधिक (बड़ा) कोई दिखाई देता है।
            उसकी परम शक्ति (परा शक्ति) अनेक प्रकार की है, ऐसा वेदों और शास्त्रों में सुना (श्रूयते) जाता है।
            उसका ज्ञान, उसका असीम बल और उसकी क्रियाएं सब कुछ पूरी तरह से स्वाभाविक (Natural) और बिना प्रयास के होती हैं।
            ईश्वर को कोई काम करने के लिए हमारी तरह हाथ-पैर या दिमाग की जरूरत नहीं पड़ती।
            वह अपनी इच्छा मात्र से ही करोड़ों ब्रह्मांड बना सकता है और मिटा सकता है; यही उसकी 'परा शक्ति' है।
            ईश्वर की कोई बराबरी नहीं कर सकता; वह अतुलनीय है, और उससे ऊपर कुछ होने का तो सवाल ही नहीं उठता।
            'स्वाभाविकी' का अर्थ है कि भगवान को कुछ करने के लिए सोचना या मेहनत नहीं करनी पड़ती।
            जैसे आग स्वाभाविक रूप से गर्मी देती है, वैसे ही ईश्वर का ज्ञान और बल उसके स्वभाव से ही प्रकट होते रहते हैं।
            यह श्लोक ईश्वर की सर्वशक्तिमत्ता (Omnipotence) और उसकी अद्वितीयता का सबसे सुंदर और तार्किक प्रमाण है।
        """.trimIndent(),
        english = """
            That Supreme Lord has neither any 'Karya' (a physical body to be formed) nor any 'Karana' (sense organs to act).
            In this entire universe, there is no one seen who is equal to Him, nor is anyone seen who is greater than Him.
            His Supreme Power (Para Shakti) is described in the Vedas as being exceedingly diverse and manifold.
            His vast knowledge, His infinite strength, and His actions are all completely natural (Svabhaviki) and effortless.
            God does not need hands, feet, or a brain like us to perform any action or task in the universe.
            He can create and destroy millions of universes merely by His will; this is His divine 'Para Shakti'.
            No one can ever match God; He is peerless, and the question of anyone being higher than Him does not even arise.
            'Svabhaviki' means God doesn't have to struggle, think hard, or exert effort to accomplish absolutely anything.
            Just as fire naturally radiates heat, God's immense wisdom and power manifest continuously from His very nature.
            This verse is the most beautiful and logical proof of God's absolute omnipotence and His unmatched uniqueness.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 99,
        sanskrit = "न तस्य कश्चित् पतिरस्ति लोके न चेशिता नैव च तस्य लिङ्गम् । स कारणं करणाधिपाधिपो न चास्य कश्चिज्जनिता न चाधिपः ॥ ९९ ॥",
        hindi = """
            इस संपूर्ण लोक (ब्रह्मांड) में उस परमात्मा का कोई भी पति (मालिक या रक्षक) बिल्कुल नहीं है।
            उस पर शासन करने वाला (ईशिता) कोई नहीं है, और न ही उसका कोई भौतिक चिह्न या रूप (लिंग) है जिससे उसे पहचाना जा सके।
            वह स्वयं इस पूरी सृष्टि का एकमात्र 'कारण' है, और वह इंद्रियों के स्वामियों (जीवात्माओं) का भी परम अधिपति (मालिक) है।
            उस परमात्मा को पैदा करने वाला (जनिता) कोई पिता नहीं है, और न ही उसके ऊपर कोई शासक या राजा (अधिप) है।
            हम सब किसी न किसी के अधीन हैं, पर ईश्वर पूर्ण रूप से आज़ाद (स्वतंत्र) है; उसका कोई बॉस नहीं है।
            उसका कोई 'लिंग' (निशान) नहीं है, यानी हम किसी मूर्ति या आकार को देखकर यह नहीं कह सकते कि ईश्वर केवल इतना ही है।
            विज्ञान बिग-बैंग को कारण मानता है, पर उपनिषद कहता है कि ईश्वर उस बिग-बैंग का भी कारण है।
            जीवात्मा मन और इंद्रियों का मालिक है, पर ईश्वर उस जीवात्मा का भी मालिक (करणाधिपाधिप) है।
            ईश्वर अजन्मा है; यदि उसे किसी ने पैदा किया होता, तो वह ईश्वर नहीं रहता, एक आम जीव बन जाता।
            यह श्लोक ईश्वर की परम सत्ता (Ultimate Supremacy) और उसके स्वयंभू (Self-existent) होने की घोषणा करता है।
        """.trimIndent(),
        english = """
            In this entire universe, there is absolutely no master, protector, or Lord (Pati) over that Supreme God.
            There is no ruler (Ishita) who commands Him, nor does He have any physical sign or mark (Linga) to be identified by.
            He Himself is the ultimate 'Cause' of everything, and He is the supreme Lord of the lords of the senses (the individual souls).
            There is no creator or father (Janita) who gave birth to Him, nor is there any overlord (Adhipa) sitting above Him.
            We are all subordinate to someone, but God is completely and absolutely independent; He has no boss.
            He has no 'Linga' (mark), meaning we cannot look at an idol or shape and say that God is limited only to this.
            Science considers the Big Bang the cause, but the Upanishad declares that God is the cause of even the Big Bang.
            The soul is the master of the mind and senses, but God is the supreme Master of that soul itself (Karanadhipadhipa).
            God is unborn; if someone had created Him, He would no longer be God, but merely an ordinary creature.
            This verse powerfully proclaims the Ultimate Supremacy of God and His completely self-existent (Svayambhu) nature.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 100,
        sanskrit = "यस्तन्तुनाभ इव तन्तुभिः प्रधानजैः स्वभावतः । देव एकः स्वमावृणोत् स नो दधाद् ब्रह्माप्ययम् ॥ १०० ॥",
        hindi = """
            जिस प्रकार एक मकड़ी (तन्तुनाभ) पूरी तरह से स्वाभाविक रूप से अपने ही भीतर से जाले (तंतु) निकालती है।
            और फिर वह मकड़ी अपने ही बनाए हुए उस जाले से स्वयं को चारों ओर से ढँक (आवृत कर) लेती है।
            उसी प्रकार, वह अद्वितीय देव (परमात्मा) प्रकृति (प्रधान) से उत्पन्न हुए नाम और रूपों के जाले से स्वयं को ढँक लेता है।
            वह परमेश्वर हम सभी को उस परब्रह्म में पूर्ण लय (ब्रह्माप्ययम् / मोक्ष) प्रदान करे।
            मकड़ी को जाला बनाने চৈতন্য बाहर से कोई सूत या धागा नहीं लाना पड़ता; वह सामग्री उसी के भीतर है।
            ठीक वैसे ही, ईश्वर को ब्रह्मांड बनाने के लिए किसी बाहरी ईंट या पत्थर की जरूरत नहीं पड़ती, प्रकृति उसी का हिस्सा है।
            दुनिया ईश्वर का ही जाला है, और वह इस दुनिया के बीच में छिपकर बैठ गया है।
            हम उस जाले (प्रकृति) को तो देखते हैं, पर उस जाले के बीच बैठे भगवान (मकड़ी) को भूल जाते हैं।
            प्रार्थना यह है कि भगवान हमें इस माया के जाले से बाहर निकालें और हमें अपने ही भीतर (मोक्ष में) समेट लें।
            यह श्लोक सृष्टि की रचना का सबसे सरल और गहरा वैज्ञानिक उदाहरण प्रस्तुत करता है।
        """.trimIndent(),
        english = """
            Just as a spider (Tantunabha) completely naturally draws out threads (webs) from within its own body.
            And then that spider entirely covers and envelops itself with the very web it has spun.
            Similarly, that non-dual Deity covers Himself with the web of names and forms born of His own Nature (Pradhana).
            May that Supreme Lord grant us complete dissolution and merging into that Brahman (Brahmapyayam / Moksha).
            A spider does not have to bring thread from outside to build a web; the material is right inside it.
            Exactly like that, God does not need external bricks or stones to build the universe; Nature is part of Him.
            The world is simply God's web, and He has hidden Himself perfectly right in the center of this world.
            We see the web (Nature), but we completely forget the God (the spider) sitting hidden in the middle of it.
            The prayer is that God pulls us out of this web of Maya and absorbs us back into Himself (granting Moksha).
            This verse presents the simplest and most profoundly scientific example of the creation of the cosmos.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 101,
        sanskrit = "एको देवः सर्वभूतेषु गूढः सर्वव्यापी सर्वभूतान्तरात्मा । कर्माध्यक्षः सर्वभूताधिवासः साक्षी चेता केवलो निर्गुणश्च ॥ १०१ ॥",
        hindi = """
            वह एक अद्वितीय देव (परमात्मा) सभी छोटे-बड़े प्राणियों के भीतर गहराई से छिपा हुआ (गूढ़) है।
            वह सर्वव्यापी है (कण-कण में है) और वही सभी प्राणियों की परम अंतरात्मा है।
            वह सभी कर्मों का अध्यक्ष (नियंता) है, और वही सभी प्राणियों का परम निवास स्थान (आश्रय) है।
            वह सबका साक्षी (देखने वाला), विशुद्ध चेतना (चेता), बिल्कुल अकेला (केवल) और तीनों गुणों से परे (निर्गुण) है।
            यह श्लोक भारतीय दर्शन का सबसे बड़ा और सबसे अधिक उद्धृत (Quoted) मंत्र है जो ईश्वर की पूरी परिभाषा देता है।
            भगवान को खोजना है तो मंदिर से पहले अपने और दूसरों के दिल (भूत) में खोजना चाहिए, क्योंकि वह वहीं छिपा है।
            हम जो भी अच्छे या बुरे कर्म करते हैं, वह 'कर्माध्यक्ष' के रूप में उन्हें रिकॉर्ड कर रहा है; उससे कुछ नहीं छिपता।
            हम सोचते हैं कि हम घर में रहते हैं, पर सच यह है कि हम सब उसी ईश्वर के भीतर (अधिवास) रहते हैं।
            वह हमारे दुख-सुख में फँसता नहीं है; वह केवल एक 'साक्षी' की तरह कैमरे की तरह सब कुछ देख रहा है।
            निर्गुण होने का अर्थ है कि उस पर क्रोध, लोभ या पक्षपात का कोई दाग नहीं है; वह परम शुद्ध और परम अकेला है।
        """.trimIndent(),
        english = """
            That one non-dual Deity (Supreme Lord) is deeply hidden (Gudha) within all great and small beings.
            He is completely all-pervading (in every atom) and is the supreme Inner Soul of all creatures.
            He is the presiding supervisor of all actions (Karmadhyaksha) and the ultimate dwelling place of all beings.
            He is the absolute Witness (Sakshi), pure Consciousness (Cheta), entirely Alone (Kevala), and free from all qualities (Nirguna).
            This verse is the greatest and most widely quoted mantra in Indian philosophy, giving the complete definition of God.
            If you want to find God, look in your own and others' hearts before looking in a temple, for He is hidden right there.
            Whatever good or bad deeds we do, He is recording them as the 'Karmadhyaksha'; absolutely nothing hides from Him.
            We think we live in houses, but the profound truth is that we all dwell securely within that God Himself.
            He does not get entangled in our joys and sorrows; He watches everything impartially like a camera, purely as a 'Witness'.
            Being Nirguna means He is untainted by anger, greed, or favoritism; He is supremely pure and absolutely non-dual.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 102,
        sanskrit = "एको वशी निष्क्रियाणां बहूनामेकं बीजं बहुधा यः करोति । तमात्मस्थं येऽनुपश्यन्ति धीरास्तेषां सुखं शाश्वतं नेतरेषाम् ॥ १०२ ॥",
        hindi = """
            वह अकेला ही सबको अपने वश में रखने वाला (वशी) है, और जड़ (निष्क्रिय) पदार्थों को भी चेतन करने वाला है।
            वह अकेला ही उस एक मूल बीज (प्रकृति) को अनेक और विविध रूपों (बहुधा) में बदल देता है।
            उस परमात्मा को जो धीर (विवेकी) पुरुष अपनी ही आत्मा के भीतर (आत्मस्थ) साक्षात् देखते और अनुभव करते हैं।
            केवल उन्हीं ज्ञानी पुरुषों को शाश्वत (हमेशा रहने वाला) सुख प्राप्त होता है, अज्ञानियों (इतरेषाम्) को कभी नहीं।
            संसार का कण-कण ईश्वर के पूर्ण नियंत्रण (वश) में है; उसकी मर्जी के बिना हवा भी नहीं बह सकती।
            पदार्थ (Matter) खुद कुछ नहीं कर सकता; यह ईश्वर की चेतना ही है जो जड़ चीज़ों में जीवन का खेल भर देती है।
            जैसे एक छोटे से बीज से हजारों पत्ते और फल वाला पेड़ निकलता है, वैसे ही ईश्वर से यह ब्रह्मांड निकलता है।
            सच्चा सुख (Happiness) मोबाइल, पैसे या रिश्तों में नहीं है; ये सब कुछ दिन बाद खत्म हो जाएंगे।
            'शाश्वत सुख' (Eternal happiness) केवल तब मिलता है जब इंसान जान लेता है कि सुख का खजाना उसके अपने भीतर है।
            जो बाहर सुख ढूँढते हैं, वे हमेशा थकते और रोते हैं; जो भीतर ढूँढते हैं, वे परमानंद पाते हैं।
        """.trimIndent(),
        english = """
            He alone is the supreme Controller (Vashi) of all, bringing consciousness even to completely inert (inactive) matter.
            He is the one who transforms that single root seed (Nature) into manifold and incredibly diverse forms (Bahudha).
            Those wise and patient men (Dhira) who directly perceive and experience that Lord situated within their own souls (Atmastha).
            Only to those wise ones belongs eternal (everlasting) happiness, and never ever to the ignorant others (Itaresham).
            Every atom of the world is perfectly under God's control; even the wind cannot blow without His divine will.
            Matter by itself can do absolutely nothing; it is God's consciousness that infuses the play of life into inert things.
            Just as a massive tree with thousands of leaves springs from one tiny seed, this entire cosmos springs from God.
            True happiness is not found in gadgets, money, or relationships; all of these will definitely perish one day.
            'Eternal happiness' is found exclusively when a person realizes that the ultimate treasure of joy is right within him.
            Those who seek joy outside always tire and weep; those who seek it within attain supreme, unending bliss.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 103,
        sanskrit = "नित्यो नित्यानां चेतनश्चेतनानामेको बहूनां यो विदधाति कामान् । तत्कारणं सांख्ययोगाधिगम्यं ज्ञात्वा देवं मुच्यते सर्वपाशैः ॥ १०३ ॥",
        hindi = """
            वह परमात्मा सभी नित्य (शाश्वत) वस्तुओं में भी परम नित्य है, और सभी चेतन जीवों में वह परम चेतन है।
            वह एक अकेला ही अनगिनत जीवों (बहुओं) की सभी इच्छाओं (कामान्) को पूरा करता है और उनके कर्मफल देता है।
            वह संपूर्ण सृष्टि का एकमात्र कारण है, और उसे केवल ज्ञान (सांख्य) और ध्यान (योग) के द्वारा ही जाना जा सकता है।
            उस परम प्रकाशमय देव को यथार्थ रूप में जान लेने पर मनुष्य अपने सभी प्रकार के बंधनों (पाशों) से मुक्त हो जाता है।
            यह कठोपनिषद का भी एक महान मंत्र है। हमारी आत्माएं नित्य और चेतन हैं, पर भगवान उनका भी राजा है।
            हम जो कुछ भी मांगते हैं, वह हमें ईश्वर ही देता है; कोई और शक्ति हमें कुछ भी देने में समर्थ नहीं है।
            ईश्वर को जानने के दो मुख्य रास्ते हैं: सांख्य (बुद्धि/ज्ञान से सत्य को समझना) और योग (ध्यान से सत्य को अनुभव करना)।
            जब ये दोनों रास्ते मिल जाते हैं, तो साधक को ईश्वर का साक्षात् दर्शन होता है।
            अज्ञान, लालच और डर—यही वे बेड़ियां (पाश) हैं जो हमें संसार से बाँधती हैं। ज्ञान की कैंची इन्हें काट देती है।
            जो ईश्वर को जान लेता है, उसे दुनिया की कोई भी ताकत या दुख दुबारा गुलाम नहीं बना सकता।
        """.trimIndent(),
        english = """
            That Supreme Lord is the ultimate Eternal among all eternals, and the supreme Consciousness among all conscious beings.
            He, being One, completely fulfills the desires (Kaman) and dispenses the fruits of actions to countless living beings.
            He is the sole cause of the entire creation, and can be attained exclusively through wisdom (Samkhya) and meditation (Yoga).
            By truly realizing that supremely radiant Deity, a person is completely liberated from all fetters and bonds (Pashas).
            This is also a great mantra from the Katha Upanishad. Our souls are eternal and conscious, but God is their King too.
            Whatever we ask for is ultimately provided by God alone; no other power is capable of giving us absolutely anything.
            There are two main paths to know God: Samkhya (understanding Truth via intellect) and Yoga (experiencing Truth via meditation).
            When both these paths unite perfectly, the seeker attains the direct, firsthand vision of God.
            Ignorance, greed, and fear—these are the chains (Pashas) that bind us to the world. The scissors of wisdom cut them.
            He who has realized God can never be enslaved again by any power or any sorrow of this world.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 104,
        sanskrit = "न तत्र सूर्यो भाति न चन्द्रतारकं नेमा विद्युतो भान्ति कुतोऽयमग्निः । तमेव भान्तमनुभाति सर्वं तस्य भासा सर्वमिदं विभाति ॥ १०४ ॥",
        hindi = """
            वहाँ (उस परब्रह्म के प्रकाश में) न सूर्य चमक सकता है, न चंद्रमा और न ही ये तारे प्रकाश दे सकते हैं।
            वहाँ आकाश की ये तेज बिजलियां भी नहीं चमक सकतीं, तो फिर इस पृथ्वी की तुच्छ अग्नि की तो बात ही क्या?
            उसी एक परमात्मा के प्रकाशित होने पर, यह पूरा का पूरा ब्रह्मांड उसके पीछे-पीछे प्रकाशित होता है।
            केवल और केवल उसी ईश्वर की परम आभा (प्रकाश) से यह सब कुछ अपनी-अपनी क्षमता के अनुसार चमक रहा है।
            यह मंत्र मुण्डक और कठोपनिषद दोनों में आता है और यह भारतीय दर्शन का सबसे चमत्कारी श्लोक है।
            ईश्वर को देखने के लिए हमें किसी टॉर्च या सूरज की जरूरत नहीं है; वह खुद ही प्रकाश का खजाना है।
            सूरज हमें रौशनी देता है, पर सूरज को भी चमकने की ताकत उसी भगवान से मिलती है।
            बिना चेतना के सूरज केवल गैस का एक अंधा गोला है; भगवान की चेतना ही उसे रोशनी देती है।
            हमारा मन और हमारी आँखें भी तभी देख पाती हैं जब आत्मा का प्रकाश उनके भीतर से गुजरता है।
            यह श्लोक भौतिक प्रकाश और आध्यात्मिक प्रकाश (Spiritual Light) के बीच के अंतर को स्पष्ट करता है।
        """.trimIndent(),
        english = """
            There (in the presence of Brahman) the sun does not shine, nor do the moon and stars give any light.
            There these lightning flashes of the sky cannot shine, so what can be said of this tiny earthly fire?
            It is only when that Supreme Lord shines, that this entire universe shines after Him, reflecting His brilliance.
            It is solely and entirely by His supreme radiance (Light) that all this shines according to its capacity.
            This mantra appears in both Mundaka and Katha Upanishads and is the most spectacular verse in Indian philosophy.
            We do not need a torch or the sun to see God; He Himself is the ultimate reservoir of all Light.
            The sun gives us light, but the sun itself gets its absolute power to shine from that very same God.
            Without consciousness, the sun is just a blind ball of gas; God's consciousness alone grants it illumination.
            Our mind and our eyes can see only when the brilliant light of the Soul passes through them.
            This verse profoundly clarifies the vast difference between physical light and true Spiritual Light.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 105,
        sanskrit = "एको हंसो भुवनस्यास्य मध्ये स एवाग्निः सलिले सन्निविष्टः । तमेव विदित्वाति मृत्युमेति नान्यः पन्था विद्यतेऽयनाय ॥ १०५ ॥",
        hindi = """
            इस संपूर्ण विश्व (भुवन) के बिल्कुल बीच में वह एक अद्वितीय 'हंस' (विशुद्ध चेतना/परमात्मा) ही स्थित है।
            वही साक्षात् अग्नि है जो इस संसार रूपी जल (सलिल) के भीतर गहराई में निवास कर रहा है।
            केवल और केवल उस एक परब्रह्म को यथार्थ रूप में जान लेने पर ही मनुष्य मृत्यु के भय को पार कर सकता है।
            मोक्ष प्राप्त करने और इस भवसागर से तरने के लिए इसके अलावा अन्य कोई दूसरा मार्ग बिल्कुल भी नहीं है।
            'हंस' का अर्थ है वह जो नीर-क्षीर (पानी और दूध/सत्य और असत्य) को अलग कर सकता है; ईश्वर परम सत्य है।
            संसार एक समुद्र है, और ईश्वर उस समुद्र के भीतर छिपी हुई आग (बड़वानल) की तरह है जो अज्ञान को जलाती है।
            हम दुनिया में सब कुछ जान लें—साइंस, व्यापार, कला—पर भगवान को न जानें, तो मौत का डर हमें डराता रहेगा।
            मौत से बचने का मतलब शरीर को बचाना नहीं है, बल्कि अपनी उस पहचान (आत्मा) को खोजना है जो कभी मरती ही नहीं।
            उपनिषद बार-बार चेतावनी देता है कि कर्मकांड और पूजा-पाठ केवल साधन हैं, अंतिम मंजिल केवल ज्ञान (Knowing) है।
            सत्य का साक्षात् ज्ञान ही जीवन की एकमात्र सफलता है, इसके अलावा मुक्ति का कोई 'शॉर्टकट' नहीं है।
        """.trimIndent(),
        english = """
            In the exact center of this entire universe (Bhuvan), there dwells that one non-dual 'Swan' (Pure Consciousness/God).
            He Himself is the ultimate Fire that resides deeply within the water (Salila) of this worldly existence.
            Only and exclusively by truly realizing that one Supreme Brahman can a person cross over the terrifying fear of death.
            There is absolutely no other path available whatsoever for attaining liberation and crossing this ocean of existence.
            'Hamsa' (Swan) means the one who separates water from milk (falsehood from truth); God is the Ultimate Truth.
            The world is an ocean, and God is like the submarine fire hidden within it that completely burns away ignorance.
            We may know everything in the world—science, business, art—but without knowing God, the fear of death will haunt us.
            Escaping death doesn't mean saving the body, but discovering that true identity (Soul) which simply never dies.
            The Upanishad repeatedly warns that rituals and worship are mere tools; the final destination is solely Knowledge.
            The direct realization of Truth is life's only real success; there is no other 'shortcut' to liberation whatsoever.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 106,
        sanskrit = "स विश्वकृद् विश्वविदात्मयोनिर्ज्ञः कालकालो गुणी सर्वविद्यः । प्रधानक्षेत्रज्ञपतिर्गुणेशः संसारमोक्षस्थितिबन्धहेतुः ॥ १०६ ॥",
        hindi = """
            वह परमात्मा ही विश्व को बनाने वाला (विश्वकृत्), विश्व को जानने वाला (विश्वविद्) और स्वयं अपना कारण (आत्मयोनि) है।
            वह सर्वज्ञ है, समय का भी समय (कालकाल) है, शुभ गुणों का सागर है और संपूर्ण विद्याओं (ज्ञान) का स्रोत है।
            वह प्रधान (प्रकृति) और क्षेत्रज्ञ (जीवात्मा) दोनों का परम पति (मालिक) है, और वही तीनों गुणों का स्वामी (गुणेश) है।
            वही एकमात्र ईश्वर इस संसार में बंधन का, संसार में रुके रहने (स्थिति) का, और संसार से मोक्ष का कारण है।
            ईश्वर को किसी ने नहीं बनाया, वह 'आत्मयोनि' है यानी वह खुद से ही पैदा हुआ है (Self-existent)।
            हमारी बुद्धि बहुत छोटी है, पर ईश्वर 'सर्वविद्' है, यानी उसे दुनिया के हर रहस्य का पूरा ज्ञान है।
            जीव और प्रकृति दोनों उसी के कर्मचारी हैं, वह इन दोनों का बॉस (पति) है।
            हम सोचते हैं कि हम अपने कर्मों से बंधते हैं, पर उपनिषद कहता है कि बंधन और मोक्ष दोनों उसी के हाथ में हैं।
            जब हम अहंकार करते हैं, तो वह माया से हमें बांध देता है; जब हम रोकर उसे पुकारते हैं, तो वह हमें आज़ाद कर देता है।
            यह श्लोक ईश्वर की सर्वशक्तिमत्ता का सबसे बड़ा घोषणापत्र है—वही ताला है और वही उस ताले की इकलौती चाबी है।
        """.trimIndent(),
        english = """
            That Supreme Lord is the creator of the world (Vishvakrit), the knower of the world (Vishvavid), and His own cause (Atmayoni).
            He is omniscient, the Time of time (Kalakala), the ocean of auspicious qualities, and the source of all wisdom (Sarvavidya).
            He is the supreme Master (Pati) of both Pradhana (Nature) and Kshetrajna (Soul), and the Lord of the three Gunas.
            He alone is the ultimate cause of bondage in this world, of remaining in the world (maintenance), and of Moksha (liberation).
            No one created God; He is 'Atmayoni', meaning He is entirely self-born and absolutely Self-existent.
            Our intellect is very tiny, but God is 'Sarvavid', meaning He has complete knowledge of every secret in the cosmos.
            Both the soul and Nature are His employees; He is the supreme Boss (Pati) of both of them.
            We think we are bound by our karmas, but the Upanishad says that both bondage and liberation are entirely in His hands.
            When we show ego, He binds us with Maya; when we cry and surrender to Him, He instantly sets us free.
            This verse is the greatest manifesto of God's absolute omnipotence—He is the lock, and He is its only key.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 107,
        sanskrit = "स तन्मयो ह्यमृत ईशसंस्थो ज्ञः सर्वगो भुवनस्यास्य गोप्ता । य ईशे अस्य जगतो नित्यमेव नान्यो हेतुर्विद्यत ईशनाय ॥ १०७ ॥",
        hindi = """
            वह परमात्मा इस संपूर्ण विश्व के रूप में तन्मय (व्याप्त) है, वह अमर है और अपनी ही महिमा में स्थित (ईशसंस्थ) है।
            वह परम ज्ञानी है, सर्वत्र जाने वाला (सर्वग) है, और इस पूरे ब्रह्मांड की रक्षा करने वाला महान रक्षक (गोप्ता) है।
            जो हमेशा (नित्य) इस संपूर्ण जगत पर पूर्ण रूप से अपना नियंत्रण और शासन (ईशे) करता है।
            इस पूरे ब्रह्मांड पर शासन करने के लिए उसके अलावा और कोई दूसरा कारण या शक्ति (नान्यो हेतु) बिल्कुल नहीं है।
            ईश्वर दुनिया से अलग नहीं है; वह दुनिया के कण-कण में 'तन्मय' होकर बसा हुआ है।
            वह किसी स्वर्ग या सिंहासन का मोहताज नहीं है; वह खुद ही अपनी ताकत और महिमा में टिका हुआ है (ईशसंस्थ)।
            ब्रह्मांड में जो भी नियम काम कर रहे हैं (जैसे ग्रहों का घूमना), वह उसी रक्षक की व्यवस्था है।
            लोग सोचते हैं कि प्रकृति (Nature) खुद काम कर रही है, पर प्रकृति के पीछे भी उसी का आदेश है।
            इस दुनिया को चलाने के लिए भगवान को किसी मंत्री या सहायक की कोई जरूरत नहीं है; वह अकेला ही काफी है।
            यह श्लोक ईश्वर के पूर्ण राजत्व (Absolute Kingship) और उसकी दयालु रक्षक प्रकृति पर मुहर लगाता है।
        """.trimIndent(),
        english = """
            That Supreme Lord is fully absorbed (Tanmaya) as this universe; He is immortal and established in His own glory (Ishasamstha).
            He is the Supreme Knower, all-pervading (Sarvaga), and the great protector (Gopta) who guards this entire cosmos.
            He is the one who eternally (Nitya) exercises absolute control and rule (Ishe) over this entire world.
            To rule and govern this cosmos, there is absolutely no other cause or power existing other than Him.
            God is not separate from the world; He resides perfectly 'Tanmaya' (absorbed) in every single atom of the world.
            He does not depend on any heaven or throne; He rests entirely in His own absolute power and glory (Ishasamstha).
            Whatever laws are functioning in the universe (like planets revolving) are the arrangements of that Protector.
            People think Nature works on its own, but firmly behind Nature is His supreme, unbreakable command.
            To run this world, God requires absolutely no ministers or assistants; He alone is more than enough.
            This verse places a definitive seal on God's Absolute Kingship and His compassionate, protective nature.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 108,
        sanskrit = "यो ब्रह्माणं विदधाति पूर्वं यो वै वेदांश्च प्रहिणोति तस्मै । तं ह देवमात्मबुद्धिप्रकाशं मुमुक्षुर्वै शरणमहं प्रपद्ये ॥ १०८ ॥",
        hindi = """
            जिस परमात्मा ने सृष्टि के आरंभ में सबसे पहले ब्रह्मा (हिरण्यगर्भ) को उत्पन्न (विदधाति) किया था।
            और जिसने उन ब्रह्मा जी को संपूर्ण वेदों और ज्ञान का उपदेश दिया था (प्रहिणोति)।
            जो परम देव मेरी आत्मा और मेरी बुद्धि को प्रकाशित करने वाला (आत्मबुद्धिप्रकाशं) है।
            मैं, मोक्ष की गहरी इच्छा रखने वाला (मुमुक्षु), उस ईश्वर की पूर्ण रूप से शरण में जाता हूँ (प्रपद्ये)।
            यह श्लोक शरणागति (Surrender) का सबसे सुंदर और हृदयस्पर्शी मंत्र है।
            ब्रह्मा जी सृष्टि के रचयिता हैं, पर उनको भी ज्ञान (वेद) उसी एक सर्वोच्च ईश्वर से ही मिला था।
            हम अपनी बुद्धि पर बहुत घमंड करते हैं, पर वह बुद्धि तभी सोच पाती है जब ईश्वर उसे प्रकाश देता है।
            मुमुक्षु वह है जो दुनिया के सुखों से थक चुका है और जिसे अब केवल परम शांति (ईश्वर) चाहिए।
            शरण में जाने का अर्थ है अपना अहंकार छोड़ देना और भगवान से कहना कि "अब तू ही मेरा रास्ता है।"
            जब हम अपने हाथ खड़े कर देते हैं, तब भगवान अपने हाथ बढ़ाकर हमें इस भवसागर से बाहर निकाल लेते हैं।
        """.trimIndent(),
        english = """
            That Supreme Lord who at the very beginning of creation first projected (created) Lord Brahma (Hiranyagarbha).
            And who then imparted and delivered all the Vedas and cosmic wisdom entirely to that Brahma.
            That Supreme Deity who is the true illuminator of my soul and my intellect (Atmabuddhiprakasham).
            I, having a deep, burning desire for liberation (Mumukshu), take absolute and complete refuge in Him.
            This verse is the most beautiful and deeply touching mantra of Sharanagati (complete surrender).
            Lord Brahma is the creator of the world, but even he received his wisdom (Vedas) exclusively from that Supreme God.
            We take great pride in our intellect, but that intellect can think only when God grants it illumination.
            A Mumukshu is one who is tired of worldly pleasures and now desires absolutely nothing but ultimate peace (God).
            Taking refuge means completely dropping one's ego and telling God, "Now You alone are my path."
            When we throw our hands up in surrender, God reaches out His hands and pulls us out of this ocean of existence.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 109,
        sanskrit = "निष्कलं निष्क्रियं शान्तं निरवद्यं निरञ्जनम् । अमृतस्य परं सेतुं दग्धेन्धनमिवानलम् ॥ १०९ ॥",
        hindi = """
            वह परमात्मा निष्कल (बिना किसी अंग या टुकड़े के), निष्क्रिय (किसी सांसारिक कर्म में न उलझने वाला) और पूर्ण शांत है।
            वह निरवद्य (दोषों से पूरी तरह मुक्त) और निरंजन (अज्ञान के दागों से अछूता) है।
            वह उस परम अमृतत्व (मोक्ष/अमरता) तक पहुँचने का सबसे श्रेष्ठ और एकमात्र सेतु (पुल) है।
            वह उस अग्नि के समान अत्यंत प्रकाशमान है जिसका सारा ईंधन (लकड़ी) पूरी तरह से जल चुका हो (दग्धेन्धन)।
            जब लकड़ी जल रही होती है, तो उसमें धुआं और आवाज होती है; पर जब वह जल चुकी होती है, तो केवल एक शांत चमक बचती है।
            ईश्वर उसी शांत और धुआं-रहित अग्नि की तरह है—विशुद्ध, शांत और अत्यंत प्रकाशमान।
            संसार में बहुत शोर और भागदौड़ है, पर ईश्वर के पास केवल असीम शांति है।
            ईश्वर में कोई दोष (अवद्य) या कलंक (अंजन) नहीं है; वह पूर्ण रूप से पवित्र और निर्मल है।
            मृत्यु के सागर को पार करने के लिए कोई भौतिक नाव नहीं चल सकती; केवल ईश्वर ही वह पुल है जो हमें पार ले जाता है।
            यह श्लोक ध्यान के लिए ईश्वर की निराकार (Formless) और अत्यंत शांत प्रकृति का एक अद्भुत चित्र प्रस्तुत करता है।
        """.trimIndent(),
        english = """
            That Supreme Lord is partless (Nishkala), inactive (unentangled in worldly actions), and perfectly tranquil.
            He is completely flawless (Niravadya) and totally untainted by the blemishes of ignorance (Niranjana).
            He is the supreme and ultimate bridge (Setu) leading directly to absolute Immortality (Moksha).
            He is radiantly luminous like a blazing fire whose entire fuel has been completely burnt to ashes (Dagdhendhana).
            When wood is actively burning, there is smoke and crackling noise; but when fully burnt, only a calm glow remains.
            God is exactly like that calm, smokeless fire—supremely pure, profoundly peaceful, and intensely luminous.
            There is immense noise and chaos in the world, but near God, there is only boundless, absolute peace.
            God holds no defect or stain; He is flawlessly pure and immaculately clean.
            No physical boat can cross the ocean of death; God alone is the bridge that safely carries us across.
            This verse presents a stunning picture of the formless and deeply serene nature of God for the purpose of meditation.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 110,
        sanskrit = "यदा चर्मवदाकाशं वेष्टयिष्यन्ति मानवाः । तदा देवमविज्ञाय दुःखस्यान्तो भविष्यति ॥ ११० ॥",
        hindi = """
            (ऋषि एक अत्यंत कठोर सत्य कहते हैं): यदि कभी ऐसा हो जाए कि मनुष्य इस विशाल आकाश को चमड़े की तरह लपेट लें।
            (अर्थात यदि कोई मनुष्य किसी असंभव काम को भी पूरा करने में सफल हो जाए)।
            फिर भी, उस परम देव (परमात्मा) को जाने बिना उसके दुखों का अंत कभी नहीं हो सकता।
            ईश्वर को जाने बिना मोक्ष प्राप्त करना आकाश को चटाई की तरह लपेटने जितना ही घोर असंभव है।
            हम चाहे विज्ञान में कितनी भी तरक्की कर लें, चाहे हम दूसरे ग्रहों पर घर बना लें या मौत को कुछ दिन टाल दें।
            परंतु जब तक हम अपने भीतर बैठे उस परमात्मा को नहीं जानेंगे, हमारे मन की पीड़ा और खालीपन कभी खत्म नहीं होगा।
            पैसे, सुख और तकनीक (Technology) केवल बाहरी आराम दे सकते हैं, पर वे आत्मा के दुख को नहीं मिटा सकते।
            दुख का असली कारण अज्ञान है, और अज्ञान का इलाज केवल और केवल आत्मज्ञान है।
            यह श्लोक भौतिकवाद (Materialism) की सीमाओं को बहुत ही कड़े शब्दों में आईना दिखाता है।
            सच्ची शांति का कोई 'शॉर्टकट' नहीं है; परमात्मा की शरण में जाना ही एकमात्र और अंतिम उपाय है।
        """.trimIndent(),
        english = """
            (The Sage states a profound truth): If it ever happens that men are able to roll up the vast sky like a piece of leather.
            (Meaning, even if a human being successfully accomplishes the most incredibly impossible tasks).
            Even then, without truly realizing that Supreme Deity, there will never be an end to his sorrow and suffering.
            Attaining Moksha without knowing God is as utterly impossible as rolling up the sky like a mat.
            No matter how much progress we make in science, build homes on other planets, or delay death for a few days.
            Until we realize that Supreme Lord seated within us, our mental agony and emptiness will never end.
            Money, pleasures, and technology can only provide external comfort, but they cannot erase the sorrow of the soul.
            The real root cause of suffering is ignorance, and the only cure for ignorance is solely Self-knowledge.
            This verse holds up a very stern mirror to the strict limitations of materialism and worldly achievements.
            There is no 'shortcut' to true peace; taking absolute refuge in God is the one and only ultimate solution.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 111,
        sanskrit = "तपःप्रभावाद् देवप्रसादाच्च ब्रह्म ह श्वेताश्वतरोऽथ विद्वान् । अत्याश्रमिभ्यः परमं पवित्रं प्रोवाच सम्यगृषिसंघजुष्टम् ॥ १११ ॥",
        hindi = """
            अपने अत्यंत कठोर तप के प्रभाव से और उस परमेश्वर की विशेष कृपा (प्रसाद) से।
            ज्ञानी महर्षि श्वेताश्वतर ने उस परम सत्य (ब्रह्म) का साक्षात् और प्रत्यक्ष अनुभव कर लिया।
            तदुपरांत, उन्होंने इस परम पवित्र और महान ऋषियों द्वारा सेवित (अनुमोदित) ज्ञान को।
            उन संन्यासियों (अत्याश्रमी) को बहुत ही अच्छी तरह (सम्यक्) उपदेशित किया, जो इसके सच्चे अधिकारी थे।
            उपनिषदों का ज्ञान कोई बौद्धिक थ्योरी नहीं है; यह ऋषियों की अपनी व्यक्तिगत तपस्या और भगवान की कृपा का फल है।
            यहाँ ऋषि का नाम 'श्वेताश्वतर' (जिसकी इंद्रियां सफेद/शुद्ध घोड़े के समान हों) पहली बार बताया गया है।
            ज्ञान किसी को भी नहीं बाँटा जा सकता; यह केवल उन 'अत्याश्रमी' (विरक्त संन्यासियों) को दिया जाता है जिनका मन शुद्ध है।
            यदि अपात्र (अयोग्य) व्यक्ति को यह ज्ञान दिया जाए, तो वह इसका गलत मतलब निकाल कर समाज का नुकसान कर सकता है।
            यह श्लोक गुरु-शिष्य परंपरा की महत्ता को स्थापित करता है, जहाँ ज्ञान एक जीवित ज्योति की तरह आगे बढ़ता है।
            ईश्वर की कृपा के बिना न तो तपस्या सफल होती है और न ही सत्य का ज्ञान प्राप्त होता है।
        """.trimIndent(),
        english = """
            Through the immense power of his severe penance (Tapas) and by the special grace (Prasada) of the Supreme Lord.
            The wise sage Shvetashvatara attained the direct, firsthand experience and realization of that Supreme Truth (Brahman).
            Thereafter, he imparted this supremely pure wisdom, which is revered and practiced by the assembly of great sages.
            He taught it perfectly (Samyak) to the ascetics (Atyashramis) who were truly qualified and deserving to receive it.
            Upanishadic wisdom is not an intellectual theory; it is the fruit of the sage's personal austerity and God's absolute grace.
            Here the sage's name 'Shvetashvatara' (one whose senses are like pure white horses) is revealed for the first time.
            Wisdom cannot be distributed to just anyone; it is given only to the 'Atyashramis' (detached ascetics) with pure minds.
            If this high knowledge is given to an unqualified person, he might misinterpret it and cause harm to society.
            This verse establishes the immense importance of the Guru-disciple tradition, where wisdom passes like a living flame.
            Without the grace of God, neither does penance succeed nor is the ultimate knowledge of Truth ever attained.
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 112,
        sanskrit = "वेदान्ते परमं गुह्यं पुराकल्पे प्रचोदितम् । नाप्रशान्ताय दातव्यं नापुत्रायाशिष्याय वा पुनः ॥ ११२ ॥",
        hindi = """
            वेदान्त (उपनिषदों) का यह परम रहस्यमयी और गुप्त (गुह्य) ज्ञान, जो प्राचीन काल (पुराकल्प) में ऋषियों द्वारा प्रकट किया गया था।
            यह ज्ञान कभी भी किसी ऐसे व्यक्ति को नहीं देना चाहिए जिसका मन शांत (प्रशांत) न हो।
            और न ही यह ज्ञान उस व्यक्ति को देना चाहिए जो अपना पुत्र या अपना सुयोग्य शिष्य न हो।
            यह उपनिषद का सख्त नियम है जो ज्ञान की पवित्रता और सुरक्षा को सुनिश्चित करता है।
            अशांत मन वाले व्यक्ति को ज्ञान देना ऐसा है जैसे किसी गंदे बर्तन में शुद्ध दूध डालना; दूध भी खराब हो जाएगा।
            ज्ञान एक बहुत बड़ी शक्ति है; यदि यह किसी स्वार्थी या क्रोधी इंसान के हाथ लग जाए, तो वह इसका दुरुपयोग करेगा।
            पुत्र या शिष्य का अर्थ यह है कि गुरु उसी को ज्ञान देता है जिसे वह लंबे समय तक परखता है और प्यार करता है।
            प्राचीन काल में गुरु अपने शिष्यों को सालों तक केवल सेवा और अनुशासन सिखाते थे, ज्ञान बहुत बाद में देते थे।
            यह श्लोक स्पष्ट करता है कि अध्यात्म कोई बाजार में बिकने वाली चीज़ नहीं है, यह पात्रता (Qualification) की मांग करता है।
            सत्य की रक्षा करना उसे खोजने से भी ज्यादा महत्वपूर्ण है; इसलिए इसे केवल 'गुह्य' (Secret) रखा गया।
        """.trimIndent(),
        english = """
            This supremely mystical and profoundly secret (Guhya) wisdom of Vedanta, which was revealed by sages in ancient times.
            This wisdom should absolutely never be imparted to a person whose mind is not completely tranquil (Prashanta).
            Nor should this high knowledge be given to anyone who is not one's own worthy son or a tested, obedient disciple.
            This is the strict rule of the Upanishads ensuring the ultimate purity and absolute security of divine knowledge.
            Giving wisdom to a restless mind is like pouring pure milk into a dirty vessel; the milk itself will spoil completely.
            Knowledge is an immense power; if it falls into the hands of a selfish or angry person, he will certainly misuse it.
            'Son or disciple' means the Guru imparts wisdom only to someone he has observed, tested, and loved for a long time.
            In ancient times, Gurus taught their students only service and discipline for years; wisdom was given much later.
            This verse clarifies that spirituality is not a commodity sold in the market; it demands strict qualification.
            Protecting the truth is even more important than finding it; this is exactly why it was kept highly 'Guhya' (Secret).
        """.trimIndent()
    ),
    ShvetashvataraShloka(
        id = 113,
        sanskrit = "यस्य देवे परा भक्तिर्यथा देवे तथा गुरौ । तस्यैते कथिता ह्यर्थाः प्रकाशन्ते महात्मनः प्रकाशन्ते महात्मन इति ॥ ११३ ॥",
        hindi = """
            जिस साधक की उस परम देव (परमात्मा) में अत्यंत गहरी और परा (सर्वोच्च) भक्ति होती है।
            और जैसी भक्ति उसकी ईश्वर में है, वैसी ही अटूट भक्ति उसकी अपने गुरु में भी होती है।
            केवल उसी महात्मा (विशाल हृदय वाले साधक) के हृदय में उपनिषद के ये गहरे रहस्य और अर्थ स्वयं प्रकाशित होते हैं।
            हाँ, केवल उसी महात्मा के हृदय में ये सत्य साक्षात् प्रकाशित होते हैं (वाक्य का दोहराव इसकी निश्चितता बताता है)।
            यह श्वेताश्वतर उपनिषद का अंतिम और संपूर्ण वेदान्त का सबसे महत्वपूर्ण भक्ति-सूत्र है।
            ज्ञान कोई किताब पढ़कर नहीं आता; जब तक हृदय में ईश्वर और गुरु के प्रति असीम प्रेम (भक्ति) न हो, ज्ञान सूखा रहता है।
            गुरु कोई साधारण इंसान नहीं है; वह ईश्वर का ही सजीव रूप है जो हमारा मार्गदर्शन करने आया है।
            यदि हम ईश्वर की तो पूजा करें पर गुरु का अपमान करें, तो ज्ञान का दरवाजा हमेशा के लिए बंद हो जाता है।
            भक्ति वह चाबी है जो बुद्धि के ताले को खोलती है, जिसके बाद उपनिषदों के अक्षर खुद-ब-खुद अर्थ (सत्य) में बदल जाते हैं।
            'प्रकाशन्ते महात्मनः'—यह श्लोक सिद्ध करता है कि ज्ञान एक ईश्वरीय कृपा है, जो केवल पूर्ण समर्पण करने वाले पर ही बरसती है। ॐ शांति।
        """.trimIndent(),
        english = """
            The seeker who possesses extremely deep and supreme (Para) devotion for that Supreme Deity (God).
            And exactly as his devotion is towards God, he possesses the very same unbreakable devotion towards his Guru.
            Only in the pure heart of such a Mahatma (great soul) do all these deep mysteries and meanings of the Upanishad reveal themselves.
            Yes, they reveal themselves truly only to such a great soul (the repetition emphasizes absolute certainty).
            This is the final verse of the Shvetashvatara Upanishad and the most important Bhakti-sutra of all Vedanta.
            Wisdom doesn't come by merely reading books; without boundless love (devotion) for God and Guru, knowledge remains dry.
            The Guru is not an ordinary human; he is the living embodiment of God who has come specifically to guide us.
            If we worship God but disrespect the Guru, the door to true cosmic wisdom shuts tightly forever.
            Devotion is the key that unlocks the intellect, after which the words of the Upanishads automatically transform into living Truth.
            'Prakashante Mahatmanah'—this verse proves that wisdom is a divine grace that showers only on those who surrender completely. OM Peace.
        """.trimIndent()
    )
)