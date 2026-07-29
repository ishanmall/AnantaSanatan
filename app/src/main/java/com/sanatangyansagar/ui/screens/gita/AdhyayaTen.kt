package com.sanatangyansagar.ui.screens.gita

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AdhyayaTen() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaTenShlokas.indexOfFirst { it.id == shlokaNum }
            if (targetIndex != -1) {
                coroutineScope.launch {
                    listState.animateScrollToItem(targetIndex)
                }
                keyboardController?.hide()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // The fully functional Search Bar!
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (1 - 20)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { performSearch() }
            ),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump to Shloka")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // The Scrollable List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(adhyayaTenShlokas) { _, shloka ->
                // Using the ShlokaCard defined in AdhyayaOne.kt to avoid duplicate errors
                ShlokaCard(shloka)
            }
        }
    }
}

// Shlokas 1 to 20 for Chapter 10
val adhyayaTenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            श्रीभगवानुवाच |
            भूय एव महाबाहो शृणु मे परमं वचः |
            यत्तेऽहं प्रीयमाणाय वक्ष्यामि हितकाम्यया || १ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे महाबाहु (अर्जुन)! तुम फिर से मेरे परम रहस्यमयी और प्रभावकारी वचनों को सुनो (शृणु मे परमं वचः)।
            चूँकि तुम मेरे अत्यंत प्रिय मित्र हो (प्रीयमाणाय), इसलिए मैं केवल तुम्हारे परम कल्याण की इच्छा से (हितकाम्यया) यह महान ज्ञान तुम्हें बताऊँगा।
            दसवें अध्याय (विभूति योग) की शुरुआत में भगवान श्रीकृष्ण खुद अपनी मर्जी से अर्जुन को और अधिक ज्ञान देने के लिए आगे आते हैं। अर्जुन ने यहाँ कोई सवाल नहीं पूछा है!
            जब कोई गुरु या भगवान देखता है कि उसका शिष्य उसके ज्ञान को बहुत प्यार और श्रद्धा से पी रहा है (सुन रहा है), तो भगवान का हृदय और भी ज्यादा पिघल जाता है।
            श्रीकृष्ण कहते हैं, "हे अर्जुन! तुम मेरे बहुत 'प्रीयमाणाय' (अत्यंत प्यारे) हो। इसलिए मैं तुम्हें वो परम रहस्य (Supreme Secret) बताने जा रहा हूँ जो दुनिया में किसी को नहीं पता।"
            ईश्वर अपने रहस्य केवल उन लोगों के सामने खोलता है जो बिना किसी ईर्ष्या या शक के, केवल शुद्ध प्रेम के साथ उनकी बातों को सुनते हैं। इस अध्याय में भगवान अपनी असीमित शक्तियों (विभूतियों) का भव्य प्रदर्शन करने वाले हैं, ताकि अर्जुन की भक्ति और भी ज्यादा पक्की (Rock-solid) हो जाए।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead elegantly said: Listen again (Bhuya eva), O mighty-armed Arjuna (Maha-baho)! Hear My supreme and most confidential words (Paramam vachah).
            Because you are My highly beloved and dear friend (Priyamānāya), I shall speak these words to you strictly for your ultimate benefit and supreme welfare (Hita-kamyaya).
            At the majestic dawn of the Tenth Chapter (Vibhuti Yoga), Lord Sri Krishna voluntarily steps forward to deliver an even greater upload of cosmic knowledge, completely unprompted! Arjuna did not even ask a question here.
            When a true Master or the Supreme Lord observes that a disciple is intensely, lovingly absorbing His teachings without an ounce of cynical doubt, the Lord's heart overwhelmingly melts.
            Sri Krishna declares, "O Arjuna! Because you are exquisitely dear to Me ('Priyamānāya'), I am voluntarily going to decode My most classified, ultimate secrets (Paramam vachah) strictly for your supreme benefit."
            God actively reveals His deepest, most terrifyingly beautiful secrets exclusively to those who listen with pure, unadulterated love. In this spectacular chapter, the Lord is about to unveil His infinite, cosmic opulences (Vibhutis) to permanently lock Arjuna's devotion into an unbreakable, titanium state.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            न मे विदुः सुरगणाः प्रभवं न महर्षयः |
            अहमादिर्हि देवानां महर्षीणां च सर्वशः || २ ||
        """.trimIndent(),
        hindi = """
            न तो देवताओं के समूह (सुरगणाः) मेरी उत्पत्ति (प्रभवं / जन्म या शुरुआत) को जानते हैं, और न ही महान ऋषि-मुनि (महर्षयः) मेरे मूल रहस्य को जानते हैं।
            क्योंकि मैं ही सभी दृष्टिकोणों से (सर्वशः) इन सभी देवताओं और महान ऋषियों का 'आदि' (Origin / सबसे पहला कारण) हूँ।
            यह श्लोक इंसानों और देवताओं के सबसे बड़े 'बौद्धिक अहंकार' (Intellectual Ego) को पूरी तरह से चकनाचूर कर देता है।
            इंसान सोचता है कि वह अपने विज्ञान (Science) और माइक्रोस्कोप (Microscope) से भगवान को डिकोड (Decode) कर लेगा। बड़े-बड़े देवता (जैसे ब्रह्मा, इंद्र) और महान तपस्वी ऋषि भी सोचते हैं कि वे अपने तप से ईश्वर की 'शुरुआत' का पता लगा लेंगे।
            श्रीकृष्ण एक बहुत बड़ा तार्किक (Logical) बयान देते हैं: "कोई भी देवता या ऋषि मेरी शुरुआत (Origin) को कभी जान ही नहीं सकता!" क्यों?
            क्योंकि, "अहमादिर्हि देवानां"—मैं उन सभी देवताओं और ऋषियों का 'पिता' हूँ! मैं उनके पैदा होने से भी करोड़ों साल पहले से मौजूद हूँ।
            क्या कोई बेटा अपने पिता के जन्म का साक्षात् गवाह (Witness) बन सकता है? बिल्कुल नहीं। जो चीज़ (देवता/ऋषि) मेरे बाद पैदा हुई है, वह अपनी छोटी सी बुद्धि से मेरे (परमेश्वर) अनंत और अनादि रूप को कैसे नाप सकती है? ईश्वर की कोई 'शुरुआत' नहीं होती; वे ही सब चीज़ों का 'स्टार्टिंग पॉइंट' (Starting Point) हैं।
        """.trimIndent(),
        english = """
            Neither the massive multitudes of celestial demigods (Sura-ganah) nor the great, highly elevated sages (Maharshayah) know My origin or opulences (Prabhavam).
            For, in every single respect (Sarvashah), I am the absolute original source and the primeval beginning (Adir) of all the demigods and great sages.
            This phenomenal verse violently shatters the massive 'Intellectual Ego' of the entire universe, from ordinary humans to elite celestial beings.
            Arrogant mortals constantly hallucinate that they can somehow 'Decode' or figure out the origin of God using their primitive scientific telescopes. Even the highly powerful cosmic managers (demigods like Brahma and Indra) and elite meditating sages attempt to trace God's beginning.
            Sri Krishna drops an irrefutable, impenetrable logical nuke: "Absolutely no demigod or sage can ever possibly know My origin!" Why?
            Because, "Aham adir hi devanam"—I am the absolute 'Original Father' of all these gods and sages! I existed infinitely long before they were even manifested into existence.
            Can a newborn child physically witness or fully comprehend the birth of his own father? Absolutely not. How can entities that were created directly 'From' Me possibly possess the bandwidth to measure My infinite, beginningless magnitude? God has no 'Origin'; He IS the Origin.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            यो मामजमनादिं च वेत्ति लोकमहेश्वरम् |
            असम्मूढः स मर्त्येषु सर्वपापैः प्रमुच्यते || ३ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य मुझे 'अजन्मा' (जिसका कभी जन्म नहीं होता / अजम्), 'अनादि' (जिसकी कोई शुरुआत नहीं है / अनादिं), और सभी लोकों (ब्रह्मांडों) का 'महान ईश्वर' (लोकमहेश्वरम्) तत्त्व से जान लेता है...
            मनुष्यों में वह व्यक्ति पूरी तरह से मोह-रहित (असम्मूढः / बिना किसी अज्ञान के) हो जाता है, और वह अपने सभी प्रकार के पापों से हमेशा के लिए मुक्त (सर्वपापैः प्रमुच्यते) हो जाता है।
            श्रीकृष्ण यहाँ ईश्वर के 'असली स्वरूप' को जानने का भयंकर और जादुई रिज़ल्ट (Magical Result) बता रहे हैं।
            साधारण इंसान कृष्ण को केवल एक राजा या एक महान इंसान मानता है (जिसका जन्म मथुरा में हुआ था)। यह सबसे बड़ा अज्ञान है।
            जो व्यक्ति (ज्ञानी) यह गहराई से समझ लेता है कि "कृष्ण पैदा नहीं हुए थे, वे 'अजम्' (Unborn) हैं; उनकी कोई शुरुआत नहीं है, वे 'अनादि' हैं; और वे केवल पृथ्वी के नहीं, बल्कि करोड़ों गैलेक्सीज़ (Galaxies) के सुप्रीम बॉस ('लोकमहेश्वर') हैं"...
            जैसे ही इंसान का दिमाग इस विराट सत्य को 100% 'वेत्ति' (Realize / अनुभव) कर लेता है, वह तुरंत 'असम्मूढः' (Illusion-free) हो जाता है। उसका दिमाग माया के मैट्रिक्स से आज़ाद हो जाता है।
            और इसका सबसे बड़ा इनाम क्या है? "सर्वपापैः प्रमुच्यते" (उसके करोड़ों जन्मों के सारे भयंकर पाप एक सेकंड में जलकर राख हो जाते हैं)। सही ज्ञान ही सबसे बड़ा पाप-नाशक (Sin-destroyer) है।
        """.trimIndent(),
        english = """
            He who perfectly knows Me as the unborn (Ajam), as the absolute beginningless (Anadim), and as the Supreme Lord of all planetary systems and universes (Loka-maheshvaram)...
            he alone, undeluded and free from all illusions among mortals (Asammudhah sa martyeshu), becomes completely completely liberated from all possible sins (Sarva-papaih pramuchyate).
            Sri Krishna is unleashing the staggering, magical results of flawlessly decoding the 'True Cosmic Identity' of God here.
            Ordinary, ignorant mortals pathetically reduce Krishna to a mere historical human king or a powerful biological entity who was 'born' in Mathura. This is the ultimate illusion.
            The elite sage who profoundly and experientially realizes: "Krishna is absolutely NOT biologically born, He is 'Ajam' (Unborn); He has absolutely no starting point, He is 'Anadim' (Beginningless); and He is not just a local king, but the terrifying Supreme CEO of trillions of galaxies ('Loka-maheshvaram')"...
            The exact microsecond a human brain successfully installs and runs this supreme truth ('Vetti'), he instantly becomes 'Asammudhah' (100% Un-deluded and Un-hacked). His consciousness breaks out of the Matrix.
            And what is the ultimate Grand Prize? "Sarva-papaih pramuchyate" (Every single microscopic trace of toxic sin accumulated over millions of lifetimes is violently incinerated to ash in a single flash). True, absolute knowledge is the universe's ultimate Sin-Destroyer.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            बुद्धिर्ज्ञानमसंमोहः क्षमा सत्यं दमः शमः |
            सुखं दुःखं भवोऽभावो भयं चाभयमेव च || ४ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 4 और 5 एक ही विचार हैं)
            बुद्धि (Intelligence), ज्ञान (सच्चा ज्ञान), असंमोह (भ्रम का न होना / Clarity), क्षमा (Forgiveness), सत्य (Truthfulness), दम (इन्द्रियों को रोकना), शम (मन को शांत रखना)...
            सुख (Happiness), दुःख (Misery), भव (जन्म/उत्पत्ति), अभाव (मृत्यु/विनाश), भय (डर), और अभय (निडरता)...
            यहाँ से भगवान इंसान के 'मनोविज्ञान' (Psychology) और ब्रह्मांड की सभी फीलिंग्स (Emotions) का 'सोर्स कोड' (Source Code) बता रहे हैं।
            हम सोचते हैं कि हमारे अंदर जो बुद्धि है, या जो हमें दुःख या डर लगता है, वह हमारा अपना क्रिएट (Create) किया हुआ है।
            लेकिन भगवान 20 प्रकार के अलग-अलग इमोशंस (Emotions) और मानवीय गुणों (Qualities) की एक बहुत बड़ी लिस्ट दे रहे हैं।
            चाहे वह बहुत पॉजिटिव (Positive) गुण हों—जैसे 'बुद्धि', 'क्षमा', 'मन की शांति (शम)' और 'निडरता (अभय)'।
            या फिर वह बहुत नेगेटिव (Negative) और डरावने अनुभव हों—जैसे 'दुःख', 'डर (भय)', और 'मृत्यु (अभाव)'।
            यह सब कुछ ब्रह्मांड का एक बहुत ही जटिल सॉफ्टवेयर (Software) है। इंसान का दिमाग तो केवल एक स्क्रीन (Screen) है जिस पर ये सारे इमोशंस (Emotions) प्ले (Play) होते हैं। 
            इन सब गुणों का असली क्रिएटर (Creator) कौन है? इसका धमाका भगवान अगले श्लोक में करते हैं।
        """.trimIndent(),
        english = """
            (Verses 4 and 5 represent a continuous thought)
            Intelligence (Buddhir), pure knowledge (Jnanam), freedom from absolute doubt and delusion (Asammohah), forgiveness (Kshama), truthfulness (Satyam), rigid control of the physical senses (Damah), profound control of the mind (Shamah)...
            Happiness (Sukham) and distress (Duhkham), birth (Bhavah), death (Abhavah), paralyzing fear (Bhayam), and absolute fearlessness (Abhayam eva cha)...
            From here, the Lord begins to flawlessly decode the absolute 'Source Code' of human Psychology and all universal emotions.
            We ignorant mortals arrogantly assume that our high intelligence, or our feelings of deep misery and fear, are entirely self-generated by our biological brains.
            But the Lord lays out an incredibly vast, comprehensive list of 20 distinct, highly complex psychological emotions and human qualities.
            Whether they are phenomenally Positive qualities—like razor-sharp 'Intelligence', 'Forgiveness', 'Mental Silence (Shama)', and 'Fearlessness (Abhaya)'.
            Or whether they are terrifying, Negative experiences—like agonizing 'Distress (Duhkham)', crippling 'Fear (Bhayam)', and violent 'Death (Abhavah)'.
            All of these are merely complex, pre-written software algorithms operating within the universal matrix. The human brain is merely a monitor screen where these emotions are 'Played'.
            So who exactly is the Ultimate Master-Programmer of all these psychological states? The Lord drops the bombshell in the very next verse.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            अहिंसा समता तुष्टिस्तपो दानं यशोऽयशः |
            भवन्ति भावा भूतानां मत्त एव पृथग्विधाः || ५ ||
        """.trimIndent(),
        hindi = """
            अहिंसा (किसी को कष्ट न देना), समता (सुख-दुःख में एक समान रहना), तुष्टि (संतुष्टि), तप (कष्ट सहकर नियम पालना), दान (Charity), यश (शोहरत/Fame), और अपयश (बदनामी/Infamy)...
            प्राणियों के ये सभी अलग-अलग प्रकार के (पृथग्विधाः) भाव (गुण और अवस्थाएं) केवल और केवल 'मुझसे ही' (मत्त एव) उत्पन्न होते हैं (भवन्ति)।
            भगवान श्रीकृष्ण यहाँ सभी साइकोलॉजिकल और इमोशनल (Psychological and Emotional) अवस्थाओं का अंतिम 'पेटेंट' (Patent) अपने नाम कर रहे हैं।
            अहिंसा, संतुष्टि, और तपस्या जैसे महान गुण, और दुनिया में मिलने वाला यश (Fame) या बदनामी (Cancel-culture)—ये सब कुछ एक ही 'सिंगल सोर्स' (Singular Source) से आते हैं: श्रीकृष्ण!
            "मत्त एव" (मुझसे ही पैदा होते हैं)—इसका अर्थ है कि भगवान ब्रह्मांड के 'सुप्रीम प्रोग्रामर' (Supreme Programmer) हैं। 
            जब कोई इंसान अच्छा काम करता है, तो भगवान उसके अंदर मौजूद 'सत्त्व गुण' को एक्टिवेट (Activate) करके उसे 'शांति और बुद्धि' (तुष्टि और समता) का सॉफ्टवेयर दे देते हैं।
            जब कोई इंसान बुरा काम करता है, तो भगवान प्रकृति के नियम (लॉ ऑफ़ कर्मा) के ज़रिए उसे 'डर' (भय) और 'अपयश' (Infamy) दे देते हैं।
            यह समझना बहुत ज़रूरी है कि भगवान किसी के साथ भेदभाव नहीं करते; वे इंसान के कर्मों के हिसाब से अपने ही खजाने से ये सारे 'भाव' (Emotions) उसे अलॉट (Allocate) करते हैं। तुम्हारे हर एक आंसू और हर एक मुस्कान का 'स्विच' (Switch) ईश्वर के ही हाथ में है।
        """.trimIndent(),
        english = """
            Nonviolence (Ahimsa), equanimity (Samata), absolute satisfaction (Tushtih), strict penance (Tapo), charity (Danam), immense fame (Yasho), and terrible infamy (Ayashah)...
            all these various, diverse, and distinct qualities and states of being (Prithag-vidhah bhavah) among living entities are created entirely and exclusively by Me alone (Matta eva bhavanti).
            Lord Sri Krishna officially claims the absolute 'Cosmic Patent' for all psychological and emotional algorithms existing in the multiverse here.
            Magnificent traits like nonviolence, perfect satisfaction, and severe austerity, as well as the external metrics of explosive global Fame (Yasho) or brutal social cancellation and Infamy (Ayashah)—all of them radiate from exactly ONE 'Singular Source': Sri Krishna!
            "Matta eva" (Emanating strictly from Me)—This profoundly means the Lord is the 'Supreme Programmer' of the cosmic simulation.
            When a human executes righteous duties, the Lord triggers his 'Sattva Guna' (Mode of Goodness) and instantly downloads the software of 'Peace and Intelligence' (Tushti and Samata) into his brain.
            When a human executes toxic sins, the Lord uses the strict Law of Karma to instantly inject 'Fear' (Bhayam) and 'Infamy' into his life.
            It is crucial to understand that God absolutely does not arbitrarily play favorites; He strictly 'Allocates' these pre-programmed 'Emotions' (Bhavas) from His infinite inventory based purely on a human's individual karmic choices. The master switch for every single tear you cry and every smile you exhibit is held exclusively by the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            महर्षयः सप्त पूर्वे चत्वारो मनवस्तथा |
            मद्भावा मानसा जाता येषां लोक इमाः प्रजाः || ६ ||
        """.trimIndent(),
        hindi = """
            प्राचीन काल के सात महान ऋषि (सप्त महर्षयः), उनसे भी पूर्व के चार (सनकादि ऋषि), और (चौदह) मनु...
            ये सभी मेरे ही संकल्प (मद्भावा) से मेरे मन से उत्पन्न (मानसा जाता) हुए हैं। और इस संसार (लोक) की ये सभी प्रजाएं (मनुष्य और जीव) उन्हीं (ऋषियों और मनुओं) की ही संतानें हैं (येषाम् इमाः प्रजाः)।
            यह श्लोक पूरी मानव जाति का 'जेनेटिक ट्री' (Genetic Family Tree / वंशावली) बता रहा है कि हम सब पैदा कहाँ से हुए हैं!
            आधुनिक विज्ञान कहता है कि इंसान बंदरों से इवॉल्व (Evolve) हुआ है। लेकिन भगवद्गीता ब्रह्मांडीय इतिहास (Cosmic History) बताती है।
            श्रीकृष्ण बताते हैं कि जब ब्रह्मांड बना, तो उन्होंने अपने 'मन' (मानसा जाता - Mind-born) से सबसे पहले 4 कुमारों (सनक, सनन्दन, सनातन, सनत्कुमार) को पैदा किया। फिर 7 महान ऋषियों (सप्तर्षि—जैसे वशिष्ठ, विश्वामित्र) को और फिर ब्रह्मांड के एडमिनिस्ट्रेटर्स (Administrators / मनुओं) को पैदा किया।
            ये सभी महान विभूतियां भगवान के 'मन' की उपज हैं (इनका कोई बायोलॉजिकल पिता नहीं है)। 
            और आज इस धरती पर जितनी भी प्रजाएं (अरबों इंसान, देवता, दानव) दिखाई दे रही हैं, वे सब के सब 'इन्हीं' ऋषियों और मनुओं की संताने हैं (इसीलिए इंसान को 'मनुष्य/मानव' कहा जाता है, क्योंकि वह मनु की संतान है)।
            निष्कर्ष यह है कि चूँकि हमारे पूर्वज सीधे भगवान के 'मन' से पैदा हुए थे, इसलिए हम सब अंततः उसी एक 'परमपिता' (ईश्वर) के ही वंशज हैं। पूरा ब्रह्मांड एक ही परिवार है।
        """.trimIndent(),
        english = """
            The seven great ancient sages (Maharshayah sapta purve), and before them the four other great sages (Chatvaro), and the Manus (the progenitors of mankind)...
            are all born directly from My supreme mind and are completely endowed with My power (Mad-bhava manasa jata). And absolutely all the living beings populating the various planets in this world are born from them and descend from them (Yesham loka imah prajah).
            This spectacularly profound verse accurately maps out the absolute, official 'Genetic Family Tree' (Cosmic Genealogy) of the entire human race!
            Modern secular science aggressively claims humans evolved randomly from monkeys. But the Bhagavad Gita explicitly decodes the true 'Cosmic History'.
            Sri Krishna reveals that at the absolute dawn of universal creation, He directly engineered and manifested from His own 'Mind' (Manasa jata - Mind-born) the first 4 Kumaras. Following them, He manifested the 7 Great Sages (Saptarshis, like Vashistha and Vishvamitra), and then the supreme administrators of human population (the Manus).
            These highly elite cosmic entities are the direct intellectual progeny of the Supreme Lord's mind (they had absolutely zero biological parents).
            And every single one of the billions of humans, demigods, and species currently populating this earthly matrix ('Imah prajah') are the direct genetic descendants of those exact same Sages and Manus (which is precisely why a human is officially called 'Manushya' in Sanskrit, meaning the descendant of 'Manu').
            The ultimate, staggering conclusion: Since our original forefathers were born directly from the Mind of God, absolutely all of us are ultimately the direct descendants of the One Supreme Father (God). The entire multiverse is literally one single family.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            एतां विभूतिं योगं च मम यो वेत्ति तत्त्वतः |
            सोऽविकम्पेन योगेन युज्यते नात्र संशयः || ७ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य मेरी इस असीम 'विभूति' (ऐश्वर्य/महानता) को और मेरी 'योग-शक्ति' (सृष्टि रचने की जादुई ताकत) को तत्त्व से (गहराई से और यथार्थ रूप में) जान लेता है (वेत्ति तत्त्वतः)...
            वह मनुष्य 'अविकम्प' (न हिलने वाले / Unshakeable) भक्तियोग के द्वारा मुझसे हमेशा के लिए जुड़ जाता है (युज्यते)। इसमें रत्ती भर भी कोई संदेह (संशय) नहीं है।
            श्रीकृष्ण यहाँ अपनी महानता (विभूति) को सुनने और समझने का 'सुपर-रिज़ल्ट' (Super-result) बता रहे हैं।
            जब इंसान को पता चलता है कि "अरे! यह पूरी दुनिया, सारे ग्रह, और इंसान भगवान के केवल एक इशारे और संकल्प से चल रहे हैं," तो उसका क्या रिएक्शन (Reaction) होना चाहिए?
            जब कोई इंसान इस 'विभूति' (Cosmic Magnitude) को केवल ऊपर-ऊपर से नहीं, बल्कि 'तत्त्वतः' (हकीकत में, गहराई से) रियलाइज़ (Realize) कर लेता है, तो उसका झूठा अहंकार तुरंत चकनाचूर हो जाता है।
            उसे समझ आ जाता है कि "मैं तो ब्रह्मांड में एक धूल के कण के बराबर भी नहीं हूँ, और भगवान सब कुछ हैं!"
            इस एहसास के बाद, उस इंसान की भक्ति कोई दिखावे वाली या कमजोर भक्ति नहीं रहती। उसकी भक्ति 'अविकम्पेन योगेन' (Unshakeable Yoga) बन जाती है—यानी एक ऐसी भक्ति जिसे दुनिया का कोई भी दुःख, कोई भी लालच या कोई भी नास्तिक इंसान हिला नहीं सकता।
            वह भगवान के चरणों में पूरी तरह से 100% लॉक (Lock) हो जाता है। और भगवान कहते हैं कि इस बात में "नात्र संशयः" (कोई डाउट नहीं है!)।
        """.trimIndent(),
        english = """
            One who genuinely, flawlessly understands this staggering cosmic opulence and majesty (Vibhutim) and mystic power of Mine in absolute truth (Mama yo vetti tattvatah)...
            becomes firmly permanently engaged in unalloyed, unshakeable devotional service (So 'vikampena yogena yujyate). Of this, there is absolutely no doubt whatsoever (Natra samshayah).
            Sri Krishna is explicitly declaring the absolute 'Super-Result' of hearing and internalizing the staggering magnitude of God's opulence.
            When a human being genuinely realizes, "Wow! This entire infinite multiverse, billions of galaxies, and the human race are operating flawlessly merely on a single thought from God," what should his psychological reaction be?
            When a mortal successfully processes and realizes this 'Vibhuti' (Cosmic Magnitude) not just superficially, but 'Tattvatah' (in raw, absolute reality), his toxic, pathetic false ego is instantly and violently shattered.
            He profoundly realizes, "I am not even a microscopic speck of dust in this cosmic matrix, and the Supreme Lord is absolutely Everything!"
            Following this explosive realization, his devotion to God ceases to be cheap, fragile, or conditional. His devotion instantly upgrades to 'Avikampena Yogena' (Unshakeable, Titanium-grade Yoga)—meaning a state of pure devotion that absolutely no worldly tragedy, no billionaire's bribe, and no toxic atheist can ever shake or derail.
            He becomes 100% permanently 'Locked' at the lotus feet of the Supreme Lord. And the Lord aggressively stamps this guarantee: "Natra samshayah" (Of this, there is zero doubt!).
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            अहं सर्वस्य प्रभवो मत्तः सर्वं प्रवर्तते |
            इति मत्वा भजन्ते मां बुधा भावसमन्विताः || ८ ||
        """.trimIndent(),
        hindi = """
            (यहाँ से 'चतुःश्लोकी गीता' / 4 Seed Verses of Gita शुरू होती है)
            मैं (श्रीकृष्ण) ही इस संपूर्ण भौतिक और आध्यात्मिक जगत की उत्पत्ति का मूल कारण (प्रभवः / Source) हूँ, और मुझसे ही यह सब कुछ संचालित हो रहा है (मत्तः सर्वं प्रवर्तते)।
            इस परम सत्य को भली-भांति मानकर (इति मत्वा), जो बुद्धिमान मनुष्य (बुधाः) हैं, वे अत्यंत प्रेम और भाव से युक्त होकर (भावसमन्विताः) निरंतर मेरी ही भक्ति और पूजा (भजन्ते मां) करते हैं।
            यह श्लोक 'चतुःश्लोकी गीता' (श्लोक 8 से 11) का पहला श्लोक है। इन 4 श्लोकों में पूरी भगवद्गीता का निचोड़ (Summary) और सबसे बड़ा रहस्य (The Ultimate Secret) छिपा है।
            श्रीकृष्ण एक बहुत ही बोल्ड और 'सुप्रीम डिक्लेरेशन' (Supreme Declaration) करते हैं: "अहं सर्वस्य प्रभवः" (मैं ही सब चीज़ों का 'सोर्स कोड' / Source Code हूँ)। ब्रह्मा, विष्णु, शिव, सारे इंसान, और सारे ब्रह्मांड 'मुझसे ही' पैदा हुए हैं और मेरी ही शक्ति से चल ('प्रवर्तते') रहे हैं।
            जब एक अत्यंत बुद्धिमान व्यक्ति ('बुधाः') इस अल्टीमेट फैक्ट (Ultimate Fact) को 100% समझ लेता है, तो वह अपना समय इधर-उधर के देवताओं या दुनियावी लोगों को खुश करने में बर्बाद नहीं करता।
            वह सीधे उस 'परम पिता' (परमेश्वर) की शरण में चला जाता है। और वह भगवान की पूजा किसी डर या लालच से नहीं करता; वह "भावसमन्विताः" (Extremely Emotional / गहरे प्रेम और भाव से भरकर) रोते हुए भगवान की भक्ति (भजन्ते) करता है।
            ज्ञान जब अपनी चरम सीमा (Peak) पर पहुँचता है, तो वह 'प्रेम' (Bhakti) में बदल जाता है!
        """.trimIndent(),
        english = """
            (Here begins the 'Chatur-Shloki Gita' - The 4 Essential Seed Verses summarizing the entire Gita)
            I am the absolute original source and root cause of all spiritual and material worlds (Aham sarvasya prabhavo). Everything universally emanates and perfectly operates exclusively from Me (Mattah sarvam pravartate).
            The highly intelligent and wise (Budhah) who perfectly know and realize this absolute truth (Iti matva) engage themselves in My pure devotional service and worship Me with their hearts utterly flooded with supreme emotion and love (Bhava-samanvitah).
            This verse initiates the legendary 'Chatur-Shloki Gita' (Verses 8 to 11). These 4 spectacular verses contain the absolute concentrated essence and the 'Ultimate Master-Secret' of the entire Bhagavad Gita.
            Lord Sri Krishna drops the most brutally bold, 'Supreme Cosmic Declaration': "Aham sarvasya prabhavah" (I am the absolute, undisputed 'Source Code' of everything). Lord Brahma, Lord Shiva, all humanity, and all multiverses are generated strictly 'From Me' and are operating ('Pravartate') solely on My power.
            When an exceptionally elite, genius intelligence ('Budhah') successfully processes and 100% understands this 'Ultimate Fact', he absolutely stops wasting his precious timeline begging cheap demigods or flattering toxic politicians.
            He directly, aggressively bypasses the entire matrix and surrenders purely to the 'Supreme Father' (Godhead). And he does not worship God out of pathetic fear of hell or cheap greed for wealth; he worships "Bhava-samanvitah" (Utterly overwhelmed with explosive, ecstatic 'Love and Emotion' for the Lord).
            When supreme knowledge reaches its absolute pinnacle, it flawlessly mutates into pure 'Love' (Bhakti)!
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            मच्चित्ता मद्गतप्राणा बोधयन्तः परस्परम् |
            कथयन्तश्च मां नित्यं तुष्यन्ति च रमन्ति च || ९ ||
        """.trimIndent(),
        hindi = """
            मेरे वे शुद्ध भक्त, जिनका चित्त (मन) पूरी तरह से मुझमें लगा हुआ है (मच्चित्ता), और जिन्होंने अपने प्राण (जीवन) पूरी तरह मुझे ही सौंप दिए हैं (मद्गतप्राणाः)...
            वे हमेशा आपस में मेरे ही बारे में चर्चा करते हुए (बोधयन्तः परस्परम्), और मेरी ही लीलाओं (कथाओं) को एक-दूसरे को सुनाते हुए (कथयन्तश्च मां नित्यं)...
            अत्यंत परम संतोष (तुष्यन्ति) और असीम दिव्य आनंद (रमण / रमन्ति) को प्राप्त करते हैं।
            यह 'चतुःश्लोकी गीता' का दूसरा श्लोक है, जो भगवान के 'पक्के प्रेमियों' (Pure Devotees) के मनोविज्ञान (Psychology) और लाइफस्टाइल (Lifestyle) का वर्णन करता है।
            भगवान को जानने के बाद भक्त क्या करते हैं?
            १. 'मच्चित्ता मद्गतप्राणाः': उनका पूरा दिमाग (Mind) 24 घंटे केवल कृष्ण के विचारों से हैक (Hack) हो चुका होता है। उनकी साँसें (प्राण) केवल भगवान के लिए ही चलती हैं; ईश्वर के बिना उनका जीवन शून्य है।
            २. 'बोधयन्तः परस्परम्': जब दो ऐसे प्रेमी भक्त आपस में मिलते हैं, तो वे शेयर बाज़ार (Stock Market), पॉलिटिक्स (Politics) या गॉसिप (Gossip) की बातें नहीं करते। वे केवल भगवान की लीलाओं और उनके महान गुणों पर एक-दूसरे के साथ चर्चा (Discussion) करते हैं।
            ३. 'तुष्यन्ति च रमन्ति च': दुनिया के लोग क्लब (Club) में शराब पीकर या पार्टी करके 'मज़ा' ढूँढते हैं। लेकिन ये भक्त भगवान की कथाएँ सुनकर ही इतने ज्यादा 'संतुष्ट' (Satisfied / तुष्यन्ति) हो जाते हैं कि वे उसी में असीम 'आनंद और नशा' (रमन्ति / Reveling in ecstasy) महसूस करते हैं। यह 'भक्ति का नशा' दुनिया के किसी भी नशे से करोड़ों गुना ज्यादा तेज़ होता है!
        """.trimIndent(),
        english = """
            The thoughts of My pure devotees dwell entirely and exclusively in Me (Mac-chitta), their very lives and vital life-airs are fully surrendered and dedicated to My service (Mad-gata-pranah)...
            and they derive intense, supreme satisfaction and unending bliss (Tushyanti cha ramanti cha) solely from always continuously discussing My glories among themselves (Bodhayantah parasparam) and constantly conversing about Me (Kathayantash cha mam nityam).
            This is the second verse of the 'Chatur-Shloki Gita', which spectacularly describes the exact 'Psychology and Daily Lifestyle' of God's absolute 'Pure Lovers' (Devotees).
            After realizing the Supreme Lord, what exactly do these elite devotees do?
            1. 'Mac-chitta Mad-gata-pranah': Their entire brain bandwidth is 100% successfully 'Hacked' and monopolized by the continuous thought of Krishna 24/7. Their very vital breathing (Prana) operates purely for the Lord's service; without God, their existence is absolute zero.
            2. 'Bodhayantah parasparam': When two such elite, ecstatic devotees physically meet, they absolutely do not waste their precious breath discussing the toxic Stock Market, corrupt politics, or cheap celebrity gossip. They intensely 'Discuss' and aggressively enlighten each other purely on the staggering pastimes and glories of the Lord.
            3. 'Tushyanti cha ramanti cha': Ignorant mortals desperately hunt for 'Fun' by heavily drinking toxic alcohol in loud nightclubs. But these pure devotees become so mind-blowingly 'Satisfied' (Tushyanti) merely by hearing God's pastimes that they experience a blinding, infinite 'Ecstasy and Intoxication' (Ramanti / Reveling). This 'Spiritual High' of pure devotion is billions of times more potent than any material drug!
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            तेषां सततयुक्तानां भजतां प्रीतिपूर्वकम् |
            ददामि बुद्धियोगं तं येन मामुपयान्ति ते || १० ||
        """.trimIndent(),
        hindi = """
            इस प्रकार जो भक्त निरंतर (सतत) मुझमें जुड़े हुए हैं (युक्तानां) और जो अत्यंत प्रेमपूर्वक (प्रीतिपूर्वकम्) हमेशा मेरी ही भक्ति (भजन) करते रहते हैं...
            उन भक्तों को मैं स्वयं (अपनी तरफ से) वह परम 'बुद्धियोग' (दिव्य ज्ञान / Divine Intelligence) प्रदान करता हूँ (ददामि), जिसके द्वारा वे निश्चित रूप से मुझ तक पहुँच जाते हैं (मामुपयान्ति ते)।
            यह 'चतुःश्लोकी गीता' का तीसरा और सबसे ज़्यादा 'कृपा' (Mercy) से भरा हुआ श्लोक है।
            भगवान श्रीकृष्ण यहाँ यह बता रहे हैं कि जो इंसान अपनी तरफ से भगवान को अपना 100% प्यार देता है, भगवान उसे बदले में क्या गिफ्ट (Gift) देते हैं।
            एक भक्त बहुत पढ़ा-लिखा विद्वान नहीं होता, वह बस प्यार करना जानता है। लेकिन मोक्ष पाने के लिए 'ज्ञान' (Intelligence/बुद्धि) की ज़रूरत होती है। तो वह ज्ञान भक्त के पास कहाँ से आएगा?
            भगवान कहते हैं: "चिंता मत करो! जो 24 घंटे केवल मुझसे प्रेम (प्रीतिपूर्वकम्) करता है, उसे बाहर जाकर किताबें पढ़ने की ज़रूरत नहीं है।"
            "ददामि बुद्धियोगं तं"—मैं खुद, उसके हृदय में बैठकर, उसे वह 'सुप्रीम बुद्धियोग' (Ultimate Cosmic Intelligence) दान (Gift) में दे देता हूँ!
            जब भगवान खुद किसी इंसान को सही फैसले लेने की 'बुद्धि' देते हैं, तो वह इंसान जीवन में कभी गलत रास्ते पर नहीं जा सकता। वह उस ईश्वरीय 'जीपीएस' (Divine GPS) के सहारे बड़ी ही आसानी से सारे मायाजाल को पार करके सीधे 'भगवान के पास' (मामुपयान्ति) पहुँच जाता है।
            भक्ति में 'ज्ञान' अपने-आप बाय-प्रोडक्ट (By-product) के रूप में मुफ़्त मिलता है!
        """.trimIndent(),
        english = """
            To those who are constantly devoted to serving Me with steadfast love (Tesham satata-yuktanam bhajatam), and who worship Me with absolute, pure affection (Priti-purvakam)...
            I Myself personally give the supreme understanding and divine intelligence (Dadami buddhi-yogam tam) by which they can flawlessly and inevitably come to Me (Yena mam upayanti te).
            This is the third verse of the 'Chatur-Shloki Gita', and it overflows with the most staggering, unimaginable 'Divine Mercy' (Kripa) of the Supreme Lord.
            Lord Sri Krishna is explicitly revealing exactly what massive, cosmic 'Return Gift' He personally bestows upon a human who offers Him 100% pure, unconditional love.
            A pure devotee might be completely uneducated; he only knows how to fiercely love God. But attaining ultimate Moksha technically requires razor-sharp 'Knowledge and Intelligence' (Buddhi). So where does the uneducated devotee acquire this knowledge?
            The Lord assures: "Do not panic! He who loves Me 24/7 with pure, blinding affection ('Priti-purvakam') absolutely does not need to waste decades reading massive philosophical libraries."
            "Dadami buddhi-yogam tam"—I, sitting right inside his heart as the Supersoul, personally download and 'Gift' him the absolute 'Supreme Cosmic Intelligence' (Buddhi-yoga)!
            When the Supreme Creator Himself installs the ultimate decision-making 'Intelligence' into a human brain, that human can absolutely never take a wrong step. Guided perfectly by this infallible 'Divine GPS', he effortlessly hacks through the entire material matrix and navigates directly straight to 'ME' (Mam upayanti).
            In the path of pure devotion, 'Supreme Knowledge' is automatically given away completely free as a By-product of Love!
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            तेषामेवानुकम्पार्थमहमज्ञानजं तमः |
            नाशयाम्यात्मभावस्थो ज्ञानदीपेन भास्वता || ११ ||
        """.trimIndent(),
        hindi = """
            उन (शुद्ध प्रेम करने वाले भक्तों) पर विशेष कृपा (अनुग्रह / अनुकम्पार्थम्) करने के लिए ही, मैं उनके हृदय (अंतःकरण / आत्मभाव) में स्वयं स्थित (स्थिर) होकर...
            उनके भीतर बैठे हुए अज्ञान रूपी घोर 'अंधकार' (अज्ञानजं तमः) को, परम 'ज्ञान रूपी अत्यंत चमकदार दीपक' (ज्ञानदीपेन भास्वता) के द्वारा पूरी तरह से नष्ट (नाशयामि) कर देता हूँ।
            यह 'चतुःश्लोकी गीता' का चौथा और अंतिम श्लोक है। यह भगवान के 'वीआईपी ट्रीटमेंट' (VIP Treatment) का सबसे खूबसूरत प्रमाण है!
            भक्त ने 100% प्यार दिया (श्लोक 9), भगवान ने उसे बदले में 100% 'बुद्धि' दे दी (श्लोक 10)। लेकिन अगर फिर भी भक्त के दिल में करोड़ों जन्मों के कुछ 'पाप या अज्ञान का अंधेरा' (तमस) बचा रह जाए, तो क्या होगा?
            क्या भक्त को वह अंधेरा खुद साफ करना पड़ेगा?
            भगवान कहते हैं, "बिल्कुल नहीं! मेरे भक्तों को मेहनत करने की कोई ज़रूरत नहीं है।"
            "तेषामेवानुकम्पार्थम्"—केवल और केवल उन पर 'स्पेशल दया' (Special Compassion) दिखाने के लिए, मैं (परमेश्वर) खुद उनके दिल ('आत्मभावस्थो') में प्रवेश करता हूँ।
            और जैसे एक अंधेरे कमरे में सूरज के जैसी तेज़ रोशनी वाला दीपक (ज्ञानदीपेन भास्वता) जला दिया जाए, तो अंधेरा एक सेकंड में भाग जाता है; ठीक वैसे ही, मैं खुद अपने हाथों से उनके दिल के सारे 'अज्ञान और मोह के अंधेरे' को जलाकर राख (नाशयामि) कर देता हूँ।
            ज्ञानयोग में इंसान को अपना अंधेरा खुद मिटाना पड़ता है, लेकिन भक्तियोग में भगवान खुद आकर झाड़ू लगाते हैं और भक्त का हृदय साफ करते हैं!
        """.trimIndent(),
        english = """
            To display absolute, special mercy and supreme compassion specifically upon them (Tesham evanukampartham), I, dwelling perpetually within their very hearts (Aham atma-bhava-stho)...
            personally completely destroy and violently annihilate the pitch-dark ignorance born of material illusion (Ajnana-jam tamah) with the blinding, brilliantly shining lamp of absolute knowledge (Jnana-dipena bhasvata).
            This is the fourth and magnificent final verse of the 'Chatur-Shloki Gita'. It serves as the absolute, most breathtaking proof of the 'VIP Cosmic Treatment' the Lord gives His devotees!
            The devotee offered 100% pure love (Verse 9), and the Lord reciprocated by gifting 100% 'Supreme Intelligence' (Verse 10). But what if, despite this, there still lingers some deep, toxic 'Darkness of Ignorance and Sin' (Tamas) accumulated from millions of past lifetimes inside the devotee's heart?
            Does the devotee have to painstakingly scrub that darkness out himself using severe austerities?
            The Lord aggressively declares, "Absolutely Not! My pure lovers do not need to struggle."
            "Tesham evanukampartham"—Purely and exclusively to display 'Special, Unimaginable Compassion' upon them, I (the Supreme Godhead) personally step down and permanently station Myself right inside the core of their hearts ('Atma-bhava-stho').
            And just as lighting a blindingly brilliant, million-watt lamp (Jnana-dipena bhasvata) inside a pitch-black cave instantly slaughters the darkness in a microsecond; exactly like that, I personally, with My own hands, violently burn and annihilate ('Nashayami') every single microscopic trace of 'Ignorance and Illusion' from their hearts.
            In Jnana Yoga, the human must brutally scrub his own heart clean; but in Bhakti Yoga, the Supreme Lord Himself descends to sweep and flawlessly clean the devotee's heart!
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            अर्जुन उवाच |
            परं ब्रह्म परं धाम पवित्रं परमं भवान् |
            पुरुषं शाश्वतं दिव्यमादिदेवमजं विभुम् || १२ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 12 और 13 एक ही वाक्य हैं)
            अर्जुन ने अत्यंत श्रद्धापूर्वक कहा: हे कृष्ण! आप ही परम ब्रह्म (Param Brahman), परम धाम (The Supreme Abode), और परम पवित्र (The Supreme Purifier) हैं!
            आप ही शाश्वत (हमेशा रहने वाले), दिव्य (Transcendental), आदिदेव (सभी देवताओं के मूल कारण), अजन्मा (Unborn), और विभु (सर्वव्यापी / All-pervading) परम 'पुरुष' (Supreme Person) हैं!
            चतुःश्लोकी गीता (श्रीकृष्ण की महानता) सुनने के बाद अर्जुन के दिमाग का सारा 'कंफ्यूजन' (Confusion/भ्रम) पूरी तरह से उड़ चुका है!
            अर्जुन का यह श्लोक एक शिष्य का सबसे परफेक्ट और अल्टीमेट 'सरेंडर' (Ultimate Surrender / पूर्ण आत्मसमर्पण) है।
            अर्जुन समझ गए हैं कि उनके सामने रथ पर बैठा हुआ जो व्यक्ति है, वह उनका केवल कोई चचेरा भाई या साधारण सारथी नहीं है।
            अर्जुन 9 बहुत ही भयंकर और सुप्रीम (Supreme) 'टाइटल' (Titles) का उपयोग करके श्रीकृष्ण की स्तुति कर रहे हैं: परम ब्रह्म (Ultimate Truth), परम धाम (Ultimate Destination), पवित्रं परमं (Ultimate Purifier), शाश्वत (Eternal), दिव्य (Divine), आदिदेव (First God), अजम (Unborn), विभु (Omnipresent), और पुरुष (Supreme Personality)।
            अर्जुन का यह डिक्लेरेशन (Declaration) उन सभी लोगों (Atheists/Impersonalists) के मुँह पर एक तमाचा है जो कहते हैं कि "कृष्ण केवल एक महान इंसान थे।"
            अर्जुन डंके की चोट पर यह साबित कर रहे हैं कि "हे कृष्ण! आप ही वो साक्षात् भगवान हैं जिसे सारे वेद और ऋषि खोज रहे हैं!"
        """.trimIndent(),
        english = """
            (Verses 12 and 13 form a continuous statement)
            Arjuna, completely overwhelmed with devotion, declared: You are the Supreme Brahman (Param Brahma), the absolute ultimate supreme abode and rest (Param Dhama), and the supremely pure, absolute purifier (Pavitram paramam bhavan)!
            You are the eternal, transcendental, original Supreme Person (Purusham shashvatam divyam), the primeval Lord of all demigods (Adi-devam), the completely unborn (Ajam), and the greatest, all-pervading Supreme Lord (Vibhum)!
            After aggressively absorbing the highly explosive 'Chatur-Shloki Gita' (the 4 seed verses of Krishna's cosmic supremacy), every single microscopic trace of 'Confusion' in Arjuna's brain has been violently blown away!
            This spectacular verse acts as the absolute, flawless, and 'Ultimate Surrender' (Total realization) of a perfect disciple.
            Arjuna profoundly realizes that the entity casually sitting on the chariot right in front of him is absolutely NOT merely his biological cousin or an ordinary chariot driver.
            Arjuna worships Sri Krishna by fiercely stacking 9 of the most terrifying, Supreme Cosmic 'Titles' ever spoken: Param Brahma (The Ultimate Truth), Param Dhama (The Supreme Destination), Pavitram Paramam (The Ultimate Purifier), Shashvatam (Eternal), Divyam (Transcendental/Divine), Adi-devam (The Original God of all Gods), Ajam (The Unborn), Vibhum (The Omnipresent), and Purusham (The Supreme Personality).
            This monumental Declaration by Arjuna serves as a brutal slap in the face to all atheists and arrogant impersonalists who foolishly claim, "Krishna was just a highly evolved historical human."
            Arjuna boldly and officially stamps the absolute truth: "O Krishna! You are the exact, literal, Supreme Personality of Godhead whom all the Vedas and elite sages are desperately hunting for!"
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            आहुस्त्वामृषयः सर्वे देवर्षिर्नारदस्तथा |
            असितो देवलो व्यासः स्वयं चैव ब्रवीषि मे || १३ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 12 के बाद)... सभी महान ऋषि-मुनि, देवर्षि नारद, असित, देवल और महान महर्षि व्यास भी आपको इसी प्रकार (परमेश्वर) ही बताते (आहुः) हैं; और अब आप स्वयं भी मुझे (यही सत्य) बता रहे हैं!
            अर्जुन यहाँ अपने उस 'रियलाइजेशन' (Realization) को प्रमाणित (Verify / Validate) कर रहे हैं, जो उन्होंने पिछले श्लोक में भगवान को दिया था।
            जब हम कोई बहुत बड़ा दावा (Claim) करते हैं कि "कृष्ण ही सुप्रीम भगवान हैं," तो लोग सबूत (Proof) मांगते हैं।
            अर्जुन यहाँ कोई मनगढ़ंत बात या अंधभक्ति नहीं दिखा रहे हैं; वे उस समय के ब्रह्मांड के सबसे महान और चोटी के 'वैज्ञानिकों और ज्ञानियों' (Supreme Authorities) का हवाला दे रहे हैं!
            अर्जुन कहते हैं: "हे कृष्ण! मैं अकेला यह नहीं कह रहा कि आप भगवान हैं। देवर्षि नारद (जो ब्रह्मांड में घूमते हैं), असित, देवल और वेदों को लिखने वाले स्वयं 'महर्षि वेदव्यास' भी अपने शास्त्रों में बिल्कुल यही बात लिखते हैं कि आप ही 'परम ब्रह्म' हैं!"
            "और अब मेरी आँखों के सामने, आप खुद (स्वयं चैव) भी मुझे वही सच्चाई बता रहे हैं।"
            यह श्लोक 'परम्परा' (Parampara / Authentic lineage) के महत्व को बताता है। एक सच्चे साधक का ज्ञान तब 100% पक्का हो जाता है जब उसका 'खुद का अनुभव', 'शास्त्रों की बातें' और 'गुरु/ईश्वर के वचन'—ये तीनों बातें बिल्कुल एक ही लाइन में मैच (Match) कर जाती हैं।
        """.trimIndent(),
        english = """
            (Continuing from Verse 12)... Absolutely all the great, legendary sages such as the celestial sage Narada (Devarshir Naradas tatha), Asita, Devala, and the great Vyasa confirm this absolute truth about You (Ahus tvam rishayah sarve); and now You Yourself are personally declaring it to me (Svayam chaiva bravishi me)!
            Arjuna is aggressively 'Verifying and Validating' his monumental realization from the previous verse using the highest cosmic authorities here.
            When a human makes a staggeringly massive claim like "Krishna is the Supreme Godhead," ignorant society immediately demands hard 'Proof'.
            Arjuna is absolutely not displaying blind, emotional fanaticism here; he is officially citing the absolute greatest, most elite, 'Top-Tier Spiritual Scientists and Authorities' of the universe!
            Arjuna essentially declares: "O Krishna! It is not just me making this massive claim. The celestial space-traveling sage Narada, Asita, Devala, and the very author of the Vedas himself, 'Maharshi Vyasa', have all officially codified in their scriptures that You are the absolute 'Param Brahman'!"
            "And now, right in front of my very eyes, You Yourself (Svayam chaiva) are personally confirming this exact same absolute truth to me."
            This verse perfectly establishes the massive importance of 'Parampara' (Authentic Lineage). A true seeker's knowledge becomes 100% titanium-solid only when his 'Personal Realization', the 'Vedic Scriptures', and the 'Direct Words of God/Guru' all perfectly align and match simultaneously.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            सर्वमेतदृतं मन्ये यन्मां वदसि केशव |
            न हि ते भगवन्व्यक्तिं विदुर्देवा न दानवाः || १४ ||
        """.trimIndent(),
        hindi = """
            हे केशव (कृष्ण)! जो कुछ भी आपने मुझसे कहा है, मैं उस सब को बिल्कुल 100% सत्य (ऋतम्) मानता हूँ (सर्वमेतदृतं मन्ये)।
            हे भगवन्! आपके इस वास्तविक स्वरूप (व्यक्तिम् / Personality) को न तो देवता (सकारात्मक शक्तियां) पूरी तरह समझ पाते हैं (न विदुर्देवा), और न ही दानव (नकारात्मक शक्तियां) ही जान पाते हैं।
            यह श्लोक एक आदर्श शिष्य (Ideal Disciple) की सबसे बड़ी क्वालिटी (Quality) को दिखाता है: 'पूर्ण और अटूट विश्वास' (Absolute Unshakable Faith)।
            अर्जुन कहते हैं, "सर्वमेतदृतं मन्ये" (आपने मुझे जो भी अकल्पनीय बातें बताई हैं, चाहे वे मेरे दिमाग में आएं या न आएं, मैं उन्हें 100% परम सत्य मानता हूँ)। अर्जुन के मन में रत्ती भर भी कोई डाउट (Doubt/शंका) नहीं बचा है।
            और फिर अर्जुन एक बहुत बड़ी बात कहते हैं कि भगवान को 'समझना' (Comprehend करना) कितना मुश्किल है।
            हम इंसान अपने छोटे से दिमाग से भगवान को डिकोड (Decode) करने की कोशिश करते हैं। अर्जुन कहते हैं कि इंसान तो छोड़ो, जो ब्रह्मांड को चलाने वाले महान 'देवता' हैं, और जो भयंकर शक्तिशाली 'दानव' हैं—वे भी अपने दिमाग का पूरा ज़ोर लगाकर भगवान की पर्सनैलिटी (Personality / व्यक्तिम्) को 1% भी नहीं समझ सकते!
            ईश्वर का स्वरूप इतना अनंत (Infinite) और रहस्यमयी है कि भौतिक बुद्धि (Material Intelligence) वहां जाते ही क्रैश (Crash) हो जाती है। ईश्वर को 'तर्क' (Logic) से नहीं, बल्कि केवल 'विश्वास और प्रेम' से ही जाना जा सकता है।
        """.trimIndent(),
        english = """
            O Keshava (Krishna)! I totally and completely accept as absolute, infallible truth (Ritam manye) absolutely everything which You have told me (Sarvam etad yan mam vadasi).
            O my Supreme Lord (Bhagavan)! Neither the highly elevated celestial demigods (Devah) nor the powerful demons (Danavah) can ever truly comprehend or perfectly know Your true, infinite personality and manifestations (Na hi te vyaktim vidur).
            This spectacular verse brilliantly showcases the absolute greatest Quality of an 'Ideal Disciple': 'Absolute, Unshakeable, Titanium Faith'.
            Arjuna officially declares, "Sarvam etad ritam manye" (Whatever unimaginable, mind-bending cosmic truths You have spoken to me, whether my tiny human brain fully comprehends the physics of it or not, I accept it 100% as the absolute, infallible Truth). Arjuna has completely deleted every single microscopic 'Doubt' from his brain.
            Then Arjuna makes a profoundly humbling statement about exactly how impossible it is to 'Comprehend' God's infinite magnitude.
            We ignorant mortals aggressively try to 'Decode' God using our pathetic, three-pound biological brains. Arjuna declares that forget puny humans, even the massively powerful cosmic managers (The Demigods) and the terrifyingly intelligent 'Demons' (Danavah)—even if they deploy 100% of their colossal intellects, they completely fail to understand even 1% of the Lord's infinite 'Personality' (Vyaktim)!
            God's absolute nature is so staggeringly infinite and mysterious that material intelligence instantly crashes and short-circuits upon approaching it. The Supreme Lord can absolutely NEVER be decoded by 'Logic'; He can only be known purely through 'Unconditional Faith and Love'.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            स्वयमेवात्मनात्मानं वेत्थ त्वं पुरुषोत्तम |
            भूतभावन भूतेश देवदेव जगत्पते || १५ ||
        """.trimIndent(),
        hindi = """
            हे सभी प्राणियों को उत्पन्न करने वाले (भूतभावन)! हे सभी प्राणियों के परम स्वामी (भूतेश)! हे सभी देवताओं के भी परम देव (देवदेव)! हे संपूर्ण ब्रह्मांड के मालिक (जगत्पते)!
            हे पुरुषोत्तम (ईश्वर)! केवल आप ही अपनी स्वयं की शक्ति (आत्मा) के द्वारा अपने आपको (अपने असली स्वरूप को) पूरी तरह से जानते हैं (स्वयमेवात्मनात्मानं वेत्थ)।
            पिछले श्लोक में अर्जुन ने कहा था कि "देवता और दानव भी आपको नहीं जानते।" तो फिर एक लॉजिकल (Logical) सवाल उठता है: "अगर देवता भी नहीं जानते, तो फिर भगवान को पूरी तरह से कौन जानता है?"
            अर्जुन इस श्लोक में उसका बहुत ही सुंदर और स्पष्ट जवाब देते हैं: "केवल भगवान ही भगवान को जान सकते हैं!"
            जैसे समंदर की गहराई और विशालता को एक छोटी सी चम्मच नहीं नाप सकती, समंदर को केवल समंदर ही जान सकता है। उसी तरह, भगवान की जो शक्ति और महानता (अनंत) है, उसे डिकोड (Decode) करने की क्षमता केवल खुद भगवान (स्वयमेव) के पास ही है।
            अर्जुन यहाँ भगवान श्रीकृष्ण को खुश करने और उनकी महानता को स्वीकार करने के लिए 5 सबसे भारी और 'ब्रह्मांडीय उपाधियाँ' (Cosmic Titles) एक साथ इस्तेमाल कर रहे हैं:
            १. 'भूतभावन' (सबको पैदा करने वाले), २. 'भूतेश' (सबको कंट्रोल करने वाले बॉस), ३. 'देवदेव' (ब्रह्मा-इंद्र आदि देवताओं के भी भगवान), ४. 'जगत्पते' (इस पूरे ब्रह्मांड के मालिक), और ५. 'पुरुषोत्तम' (सबसे सुप्रीम परसन / Supreme Person)।
            यह एक भक्त की तरफ से ईश्वर के प्रति 100% समर्पण और उनकी महानता का अद्भुत गान है।
        """.trimIndent(),
        english = """
            O Supreme Creator and Father of all living entities (Bhuta-bhavana)! O Supreme Lord of all beings (Bhutesha)! O God of all gods (Deva-deva)! O Supreme Master and Lord of the entire universe (Jagat-pate)!
            O Greatest of all persons (Purushottama)! Indeed, You alone perfectly and completely know Yourself entirely by Your own internal, inconceivable potencies (Svayam evatmanatmanam vettha tvam).
            In the previous verse, Arjuna declared that "Even the demigods and demons cannot possibly know You." This sparks a highly logical follow-up question: "If even the most elite demigods fail, then who exactly in the universe actually knows God entirely?"
            Arjuna delivers an incredibly beautiful, flawless, and poetic answer here: "ONLY God possesses the capacity to fully know God!"
            Just as a pathetic, tiny plastic spoon absolutely cannot measure the staggering depth and infinite volume of the Pacific Ocean, only the Ocean can truly know itself. Similarly, the infinite, incomprehensible magnitude of God's power can only be processed and 'Decoded' exclusively by God Himself (Svayam eva).
            Arjuna passionately fires off 5 of the absolute heaviest, most majestic 'Cosmic Titles' consecutively to fiercely glorify Lord Sri Krishna and acknowledge His undisputed supremacy:
            1. 'Bhuta-bhavana' (The Original Creator of all), 2. 'Bhutesha' (The Supreme Boss controlling all), 3. 'Deva-deva' (The God standing above all demigods like Brahma and Indra), 4. 'Jagat-pate' (The Absolute Owner of the Multiverse), and 5. 'Purushottama' (The Ultimate Supreme Person).
            This is the ultimate, ecstatic song of 100% total surrender and blinding glorification from a pure devotee to the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            वक्तुमर्हस्यशेषेण दिव्या ह्यात्मविभूतयः |
            याभिर्विभूतिभिर्लोकानिमांस्त्वं व्याप्य तिष्ठसि || १६ ||
        """.trimIndent(),
        hindi = """
            हे प्रभु! इसलिए कृपा करके आप अपनी उन सभी 'दिव्य विभूतियों' (अलौकिक शक्तियों और ऐश्वर्यों) का मेरे लिए पूरी तरह (अशेषेण / बिना कुछ छोड़े) विस्तार से वर्णन करें (वक्तुमर्हसि)...
            जिन विभूतियों (शक्तियों) के द्वारा आप इन सभी लोकों (संपूर्ण ब्रह्मांडों) में पूरी तरह से व्याप्त होकर (भरकर) स्थित हैं (व्याप्य तिष्ठसि)।
            अर्जुन का ज्ञान और विश्वास अब पूरी तरह से पक्का हो चुका है कि कृष्ण ही भगवान हैं। अब अर्जुन के मन में एक 'परम भक्त' वाली भारी जिज्ञासा (Curiosity) पैदा हो रही है।
            अर्जुन कहते हैं, "हे कृष्ण! मैं जान गया हूँ कि आप ही सब कुछ हैं। लेकिन यह दुनिया तो बहुत बड़ी है। आप इस दुनिया के कण-कण में, नदियों में, पहाड़ों में, और जानवरों में अपनी 'विभूतियों' (Superpowers / Opulences / ऐश्वर्य) के द्वारा कैसे फैले हुए हैं (व्याप्य तिष्ठसि)?"
            अर्जुन की डिमांड (Demand) बहुत बड़ी है: "वक्तुमर्हस्यशेषेण"—यानी मुझे थोड़ा बहुत नहीं, मुझे 'अशेषेण' (बिना कुछ छुपाए / 100% डिटेल में) अपनी सारी शक्तियों के बारे में बताइए!
            अर्जुन यह सब किसी 'मैजिक-शो' (Magic Show) की तरह मजे के लिए नहीं पूछ रहे हैं; वे इसलिए पूछ रहे हैं ताकि जब वे इस दुनिया में किसी भी महान, सुंदर या ताकतवर चीज़ को देखें, तो उन्हें उसमें केवल और केवल 'कृष्ण' की ही याद आए, न कि उस चीज़ का मोह हो।
            यहीं से भगवान के 'विभूति' (Cosmic Opulence) बताने के अध्याय का मुख्य हिस्सा (Main body) शुरू होता है।
        """.trimIndent(),
        english = """
            Therefore, O Lord, please gracefully describe and tell me completely, in absolute detail, without leaving anything out (Vaktum arhasy asheshena), of Your divine opulences and staggering majestic powers (Divya hy atma-vibhutayah)...
            by which specific opulences and powers (Yabhir vibhutibhir) You pervade, control, and remain permanently situated within all these immense planetary systems and universes (Lokan imans tvam vyapya tishthasi).
            Arjuna's foundational knowledge and titanium faith that Krishna is the Supreme Godhead are now 100% flawlessly cemented. Now, a massive, explosive 'Curiosity' unique to a pure devotee violently awakens within Arjuna's mind.
            Arjuna essentially pleads, "O Krishna! I have accepted that You are absolutely Everything. But this material matrix is gigantically vast. Exactly how do You deploy Your 'Vibhutis' (Cosmic Superpowers / Divine Opulences) to thoroughly 'Pervade' and actively control every single atom, river, mountain, and living entity (Vyapya tishthasi)?"
            Arjuna's demand is incredibly massive: "Vaktum arhasy asheshena"—Meaning, do not give me a short summary; I want You to reveal Your powers in 100% absolute, exhaustive 'Detail', holding nothing back!
            Arjuna is absolutely not asking for a cheap 'Magic Show' just to be entertained. He is demanding this profound knowledge so that whenever he witnesses anything staggeringly beautiful, massively powerful, or majestic in this matrix, he will instantly remember ONLY 'Krishna', rather than falling into toxic material attachment for that object.
            This exact question officially triggers the core 'Main Body' of the Lord's breathtaking revelation of His 'Vibhuti' (Cosmic Opulences).
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            कथं विद्यामयं योगिंस्त्वां सदा परिचिन्तयन् |
            केषु केषु च भावेषु चिन्त्योऽसि भगवन्मया || १७ ||
        """.trimIndent(),
        hindi = """
            हे महायोगिन् (योगिन्)! मैं हमेशा (सदा) आपका ही चिंतन (ध्यान / परिचिन्तयन्) करता हुआ, आपको किस प्रकार जान सकूँ (कथं विद्यामहं)?
            और हे भगवन्! मुझे इस भौतिक संसार की किन-किन विशेष चीज़ों या भावों में (केषु केषु च भावेषु) आपका ही चिंतन (ध्यान / चिन्त्योऽसि मया) करना चाहिए?
            यह अर्जुन का भगवान से पूछा गया एक अत्यंत ही 'प्रैक्टिकल सवाल' (Practical Question) है।
            अर्जुन कहते हैं, "हे कृष्ण! जब मैं आँखें बंद करके 'ॐ' का ध्यान करता हूँ, तब तो मैं आप पर फोकस कर लेता हूँ। लेकिन जब मैं आँखें खोलकर इस दुनिया (युद्ध, समाज) में काम करता हूँ, तब मेरा ध्यान भटक जाता है।"
            "मैं चाहता हूँ कि मैं 24 घंटे (सदा) केवल आपको ही याद करूँ। तो कृपया मुझे एक 'चीट-कोड' (Cheat-code) दीजिए! जब मैं इस दुनिया की अलग-अलग चीज़ों (पेड़, नदी, इंसान) को देखूँ, तो मैं उनमें आपको कैसे पहचानूँ? मैं किन-किन खास चीज़ों ('केषु केषु भावेषु') में आपको देखूँ ताकि मेरा मन दुनिया की सुंदरता में फँसने के बजाय सीधे आप पर ही लॉक (Lock) हो जाए?"
            यह सवाल हमारे लिए भी बहुत ज़रूरी है। हम सब दुनिया में काम करते हैं और दुनिया की सुंदर चीज़ों (जैसे किसी सुंदर व्यक्ति या बहुत सारा पैसा) को देखकर मोहित हो जाते हैं। अर्जुन वह तरीका पूछ रहे हैं जिससे हम उस 'सुंदरता' को देखकर भगवान की याद करें, न कि उस चीज़ के गुलाम बनें।
        """.trimIndent(),
        english = """
            O Supreme Mystic (Yogin)! How shall I constantly think of You, and how shall I flawlessly know and understand You while continuously meditating upon You (Katham vidyam aham yagims tvam sada parichintayan)?
            And in what various specific forms, objects, and aspects of this material world (Keshu keshu cha bhaveshu) are You to be meditated upon and remembered by me, O Supreme Lord (Chintyo 'si bhagavan maya)?
            This is an incredibly 'Highly Practical' and universally essential question posed by Arjuna to the Supreme Lord.
            Arjuna is essentially stating: "O Krishna! When I close my eyes in a quiet room and chant 'OM', I can successfully focus on You. But the exact microsecond I open my eyes and step into the chaotic, highly attractive matrix of this material world (war, society), my focus is instantly violently shattered and hijacked."
            "I desperately want to run Your remembrance continuously 24/7 (Sada) in my background consciousness. So please, give me the ultimate 'Cheat-Code'! When I look at various earthly objects (rivers, mountains, humans), exactly how do I spot You hiding inside them? In which specific, magnificent things ('Keshu keshu bhaveshu') should I perceive You, so that instead of becoming toxically addicted to their material beauty, my brain instantly 'Locks' onto YOU?"
            This question is massively critical for modern humans. We constantly work in the matrix and become violently hypnotized by external beauty (like an attractive person, or a billion-dollar mansion). Arjuna is demanding the specific psychological hack to ensure that witnessing 'Beauty' triggers an instant remembrance of God, preventing us from becoming pathetic slaves to the material object.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            विस्तरेणात्मनो योगं विभूतिं च जनार्दन |
            भूयः कथय तृप्तिर्हि शृण्वतो नास्ति मेऽमृतम् || १८ ||
        """.trimIndent(),
        hindi = """
            हे जनार्दन (श्रीकृष्ण)! आप अपनी 'योग-शक्ति' (सृष्टि को रचने और कंट्रोल करने की ताकत) और अपनी 'विभूतियों' (ऐश्वर्यों / महानताओं) को मुझे एक बार फिर से (भूयः) बहुत विस्तार से (विस्तरेण / Detail में) कहिए (कथय)।
            क्योंकि आपके इन 'अमृत' (अमृत के समान मीठे और जीवन देने वाले) वचनों को सुनते हुए (शृण्वतः) मुझे बिल्कुल भी तृप्ति (शांति या पेट भरना / Satisfaction) नहीं हो रही है (यानी मेरा मन और ज्यादा सुनने के लिए तरस रहा है)।
            जब एक भक्त को भगवान के ज्ञान का असली 'रस' (Taste/आनंद) मिल जाता है, तो उसकी क्या हालत होती है, यह श्लोक उसका सबसे बड़ा सुबूत है!
            भगवान ने सातवें और नौवें अध्याय में अपनी शक्तियों के बारे में थोड़ा सा (Trailer) बताया था। लेकिन अर्जुन को उस ज्ञान में इतना अकल्पनीय 'मज़ा' (Ecstasy) आ रहा है कि वे भगवान को रुकने ही नहीं देना चाहते!
            अर्जुन कहते हैं, "हे कृष्ण! आप जो ये ब्रह्मांड के सीक्रेट्स (Secrets) बता रहे हैं, ये मेरे लिए 'अमृत' (Nectar) की तरह हैं। जैसे इंसान को अगर अमृत मिल जाए तो उसका पेट कभी नहीं भरता, वैसे ही आपके इस ज्ञान को सुनकर मेरा दिल और दिमाग कभी 'संतुष्ट' (तृप्त) नहीं हो रहा है; मेरी भूख और बढ़ती जा रही है!"
            "इसलिए आप शॉर्टकट (Shortcut) में मत बताइए, मुझे पूरी तरह 'विस्तार से' (विस्तरेण / In heavy detail) अपनी शक्तियों के बारे में बताइए।"
            यह श्लोक दिखाता है कि आध्यात्मिक ज्ञान (Spiritual Knowledge) कोई बोरिंग (Boring) लेक्चर (Lecture) नहीं है; अगर इसे सही गुरु से सुना जाए, तो यह दुनिया के किसी भी वेब-सीरीज़ (Web-series) या फिल्म से करोड़ों गुना ज्यादा थ्रिलिंग (Thrilling) और आनंददायक होता है!
        """.trimIndent(),
        english = """
            O Janardana (Krishna)! Please explicitly describe again in complete, exhaustive detail (Vistarenatmano yogam) Your immense mystic power and Your majestic cosmic opulences (Vibhutim cha).
            Please speak again and again (Bhuyah kathaya), for I am absolutely never satiated or fully satisfied (Triptir hi nasti me) by constantly hearing Your nectar-like words (Shrinvato... amritam).
            This spectacular verse acts as the absolute greatest, ultimate proof of exactly what happens when a pure devotee tastes the blinding, addictive 'Rasa' (Ecstasy/Taste) of absolute spiritual knowledge!
            The Lord had briefly provided a small 'Teaser Trailer' of His staggering cosmic powers in Chapters 7 and 9. But Arjuna is currently experiencing such an unimaginable, explosive 'High' (Ecstasy) absorbing this data that he aggressively refuses to let the Lord stop speaking!
            Arjuna passionately declares: "O Krishna! These classified cosmic secrets You are downloading into my brain taste exactly like absolute 'Amritam' (The Elixir of Immortality). Just as a man drinking literal nectar can never be satiated, my heart and brain absolutely refuse to be 'Satisfied' (Tripti); my hunger for Your knowledge is multiplying exponentially!"
            "Therefore, absolutely do not give me a brief summary or shortcut; I demand that You explain Your staggering cosmic opulences entirely 'Vistarena' (In heavy, exhaustive, 100% comprehensive Detail)."
            This phenomenal verse proves that true 'Spiritual Knowledge' is absolutely NOT some dry, boring, dusty lecture; if received from the ultimate Master, it is a billion times more intensely thrilling, addictive, and mind-blowing than the greatest blockbuster movie or web-series in existence!
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            श्रीभगवानुवाच |
            हन्त ते कथयिष्यामि दिव्या ह्यात्मविभूतयः |
            प्राधान्यतः कुरुश्रेष्ठ नास्त्यन्तो विस्तरस्य मे || १९ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने (मुस्कुराते हुए) कहा: हाँ, ठीक है (हन्त)! हे कुरुश्रेष्ठ (अर्जुन)! अब मैं तुम्हें अपनी जो 'दिव्य विभूतियां' (ईश्वरीय शक्तियां और महानताएं) हैं, उनमें से केवल जो सबसे 'प्रमुख' (Main / प्राधान्यतः) विभूतियां हैं, वही बताऊँगा (कथयिष्यामि)।
            क्योंकि मेरी इन विभूतियों (शक्तियों और विस्तार) का वास्तव में कोई 'अंत' (End / लिमिट) है ही नहीं (नास्त्यन्तो विस्तरस्य मे)।
            अर्जुन ने भगवान से ज़िद की थी कि "मुझे अपनी सारी शक्तियों के बारे में 100% विस्तार से (Detail में) बताइए।"
            भगवान श्रीकृष्ण अर्जुन की इस भोली सी डिमांड (Demand) पर मुस्कुरा देते हैं। वे कहते हैं, "हन्त!" (ठीक है, मैं बताऊँगा)। 
            लेकिन फिर भगवान एक बहुत बड़ा 'रियालिटी चेक' (Reality Check) देते हैं। वे कहते हैं कि अर्जुन, तुम्हारा दिमाग एक छोटे से कप (Cup) की तरह है और मेरी शक्तियां एक अनंत समंदर (Infinite Ocean) की तरह हैं।
            "नास्त्यन्तो विस्तरस्य मे"—इस पूरे ब्रह्मांड में जितने भी तारे हैं, जितने भी परमाणु (Atoms) हैं, उन सबसे कहीं ज्यादा मेरी शक्तियां और रूप हैं। अगर मैं 24 घंटे लगातार करोड़ों सालों तक भी तुम्हें अपनी 'डिटेल्स' (Details) बताता रहूँ, तो भी मेरी लिस्ट (List) कभी 'खत्म' (अंत) नहीं होगी!
            इसलिए, मैं तुम्हें अपनी 'सारी' विभूतियां नहीं बता सकता। मैं तुम्हें केवल 'प्राधान्यतः' (Top Highlights / केवल मुख्य-मुख्य चीजें) बताऊँगा। जो चीज़ें दुनिया में सबसे ज्यादा शानदार, शक्तिशाली और सुंदर हैं, मैं केवल उनके उदाहरण दूँगा ताकि तुम समझ सको कि यह सब मेरी ही चमक है।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead warmly replied: Yes, very well (Hanta)! O best of the Kurus (Kuru-shreshtha), I shall now gladly describe and officially reveal to you My divine, splendorous manifestations and opulences (Divya hy atma-vibhutayah).
            But I shall mention only the most prominent and principal ones (Pradhanyatah), because My infinite opulence and massive cosmic manifestations are absolutely limitless and have zero end (Nasty anto vistarasya me).
            Arjuna fiercely demanded in the previous verse, "Tell me absolutely everything about Your powers in 100% exhaustive, limitless detail!"
            Lord Sri Krishna gently smiles at Arjuna's highly innocent, albeit biologically impossible, demand. He replies, "Hanta!" (Yes, very well, I shall tell you).
            But then, the Lord drops a massive, staggering 'Reality Check'. He essentially says: Arjuna, your human biological brain is the size of a tiny teacup, whereas My cosmic powers are literally an infinite, boundless Ocean.
            "Nasty anto vistarasya me"—There are more infinite manifestations, avatars, and powers radiating from Me than there are microscopic atoms or blazing stars in this entire multiverse. Even if I continuously spoke to you 24/7 for billions of years, My list of opulences would absolutely NEVER hit an 'End' (Anta)!
            Therefore, it is mathematically impossible for Me to tell you 'Everything'. I will only download the 'Pradhanyatah' (The Absolute Top Highlights / The Major Prominent manifestations) into your brain. I will point out only the absolute most spectacular, terrifyingly powerful, and staggeringly beautiful entities in the matrix, just so you realize that their blinding brilliance is merely a microscopic spark of MY own energy.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            अहमात्मा गुडाकेश सर्वभूताशयस्थितः |
            अहमादिश्च मध्यं च भूतानामन्त एव च || २० ||
        """.trimIndent(),
        hindi = """
            हे गुडाकेश (नींद और अज्ञान को जीतने वाले अर्जुन)! मैं ही सभी प्राणियों (जीवों) के हृदय (आशय) में स्थित सबकी 'आत्मा' (परमात्मा / Supersoul) हूँ।
            तथा मैं ही सभी प्राणियों का 'आदि' (शुरुआत/जन्म), मैं ही 'मध्य' (बीच का समय/पालन), और मैं ही 'अंत' (मृत्यु/विनाश) भी हूँ।
            विभूतियों (Opulences) की लिस्ट शुरू करने से पहले, भगवान श्रीकृष्ण अपनी सबसे बड़ी, सबसे पहली और सबसे सुप्रीम 'विभूति' (Supreme Opulence) बता रहे हैं!
            इंसान सोचता है कि भगवान किसी सातवें आसमान पर बैठे हैं। लेकिन श्रीकृष्ण कहते हैं कि मेरी सबसे बड़ी शक्ति यह है कि "अहमात्मा सर्वभूताशयस्थितः"—मैं एक चींटी से लेकर ब्रह्मा तक, दुनिया के हर एक जीव के 'दिल' (हृदय) के बिल्कुल सेंटर (Center) में 'आत्मा/परमात्मा' के रूप में बैठा हुआ हूँ! तुम्हारी धड़कन मैं ही चला रहा हूँ।
            दूसरी लाइन में भगवान कहते हैं कि यह जो 3D दुनिया का टाइमलाइन (Timeline / Past, Present, Future) है, यह सब मैं ही हूँ।
            १. 'आदि' (Origin): जब जीव पैदा होता है, तो उसका वह क्रिएशन (Creation) मैं ही हूँ।
            २. 'मध्य' (Middle): जब वह जीव अपनी पूरी जिंदगी जीता है और सांस लेता है, तो उसे होल्ड (Hold / Sustain) करने वाली ताकत (Maintenance) मैं ही हूँ।
            ३. 'अंत' (End): और जब उस जीव का शरीर मरता है (Death), तो वह विनाश करने वाली शक्ति (Destruction) भी मैं ही हूँ।
            यानी क्रिएटर (Creator), ऑपरेटर (Operator), और डिस्ट्रॉयर (Destroyer)—तीनों रोल (Role) साक्षात् मैं ही प्ले (Play) कर रहा हूँ। मेरे अलावा इस ब्रह्मांड में दूसरा कुछ 'है' ही नहीं। यह श्लोक 'परम ईश्वर' (Absolute God) की सबसे सटीक और परफेक्ट परिभाषा (Perfect Definition) है।
        """.trimIndent(),
        english = """
            O Arjuna, conqueror of sleep and ignorance (Gudakesha)! I am the Supersoul (Aham atma), perfectly seated directly within the hearts of all living entities (Sarva-bhutashaya-sthitah).
            I am the absolute beginning or origin (Adish cha), I am the middle or the maintainer (Madhyam cha), and I am the ultimate end or the destroyer of all living beings (Bhutanam anta eva cha).
            Before violently unleashing His staggering list of cosmic opulences (Vibhutis), Lord Sri Krishna officially declares His absolute First, Greatest, and 'Supreme Opulence' right here!
            Ignorant humans foolishly hallucinate that God is a bearded old man permanently hiding behind clouds in the seventh heaven. But Sri Krishna drops the ultimate truth: "Aham atma sarva-bhutashaya-sthitah"—I am permanently, intimately, and physically seated right inside the exact 'Core of the Heart' of every single living entity, from the microscopic ant to the massive Lord Brahma, functioning as the 'Paramatma' (Supersoul)! I am the literal engine pumping your heartbeat.
            In the second line, the Lord claims absolute monopoly over the entire 3D Timeline (Past, Present, and Future) of the matrix.
            1. 'Adi' (Origin): The exact microsecond a biological entity is conceived and born (Creation), that starting point is ME.
            2. 'Madhya' (Middle): During the entity's entire lifespan while it breathes, the invisible force actively holding and sustaining it (Maintenance) is ME.
            3. 'Anta' (End): And when the biological clock hits zero and the body is violently destroyed (Death), that annihilating force is also ME.
            Meaning: The Creator, the Operator, and the Destroyer—ALL THREE roles are exclusively, flawlessly played by ME alone. Outside of Me, absolutely nothing 'Exists' in this multiverse. This verse provides the absolute most precise, clinical, and 'Perfect Definition' of the Ultimate Supreme God.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            आदित्यानामहं विष्णुर्ज्योतिषां रविरंशुमान् |
            मरीचिर्मरुतामस्मि नक्षत्राणामहं शशी || २१ ||
        """.trimIndent(),
        hindi = """
            (यहाँ से भगवान अपनी प्रमुख विभूतियों की सूची दे रहे हैं)
            बारह आदित्यों में मैं 'विष्णु' (वामन अवतार) हूँ; प्रकाश देने वालों (ज्योति) में मैं किरणों वाला 'सूर्य' हूँ;
            मरुद्गणों (हवा के देवताओं) में मैं 'मरीचि' हूँ; और समस्त नक्षत्रों (तारों) में मैं 'चंद्रमा' (शशी) हूँ।
            भगवान श्रीकृष्ण यहाँ ब्रह्मांड के सबसे महान और शक्तिशाली तत्वों (Elements) की बात कर रहे हैं। वे बता रहे हैं कि किसी भी कैटेगरी (Category) में जो सबसे 'सुप्रीम' (Supreme) या 'बेस्ट' (Best) चीज़ है, वह साक्षात् मेरी ही शक्ति का प्रदर्शन है।
            आसमान में सबसे ज्यादा चमकने वाला 'सूर्य' कोई साधारण आग का गोला नहीं है; वह सूरज के रूप में भगवान की ही रोशनी (तेज) है जो पूरी दुनिया को जीवन दे रही है।
            रात के समय जब करोड़ों तारे अपनी हल्की रोशनी देते हैं, तो उन सबमें जो सबसे बड़ा, सबसे सुंदर और सबको शीतलता (Coolness) देने वाला 'चाँद' है, वह भगवान की ही 'विभूति' है।
            भगवान अर्जुन को एक नई दृष्टि (Vision) दे रहे हैं: "जब भी तुम आसमान में सूरज या चाँद को देखो, तो उन्हें केवल एक खगोलीय पिंड (Celestial body) मत मानना; मेरी उस अनंत शक्ति को महसूस करना जो उन ग्रहों के रूप में चमक रही है।"
        """.trimIndent(),
        english = """
            (From here, the Lord begins listing His prominent cosmic opulences)
            Of the twelve Adityas I am Vishnu; of all the luminaries and radiating lights, I am the radiant sun (Ravir amshuman);
            Of the Maruts (the demigods of the wind) I am Marichi; and among the stars and constellations of the night sky, I am the moon (Shashi).
            Lord Sri Krishna is officially hijacking the absolute most majestic and powerful elements of the cosmos here to demonstrate His omnipotence. He declares that in any given category of existence, the absolute 'Supreme' or 'Best' entity is a direct physical manifestation of His own energy.
            The blindingly brilliant 'Sun' dominating the daytime sky is absolutely not a random ball of burning hydrogen gas; it is the direct, physical manifestation of God's illuminating energy (Tejas) giving life to the entire solar system.
            At night, amidst billions of tiny flickering stars, the incredibly massive, beautiful, and soothing 'Moon' that dominates the darkness is a direct 'Vibhuti' (Opulence) of the Lord.
            The Lord is permanently upgrading Arjuna's vision: "Whenever you look up and witness the breathtaking majesty of the Sun or the Moon, do not merely perceive them as dead celestial rocks; actively recognize them as My staggering cosmic power shining right into your eyes."
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            वेदानां सामवेदोऽस्मि देवानामस्मि वासवः |
            इन्द्रियाणां मनश्चास्मि भूतानामस्मि चेतना || २२ ||
        """.trimIndent(),
        hindi = """
            चारों वेदों में मैं 'सामवेद' हूँ; सभी देवताओं में मैं उनका राजा 'इंद्र' (वासव) हूँ;
            शरीर की सभी इन्द्रियों में मैं 'मन' हूँ; और सभी जीवित प्राणियों में मैं उनकी 'चेतना' (Consciousness / Life-force) हूँ।
            यह श्लोक विज्ञान (Science) और अध्यात्म (Spirituality) का एक अत्यंत ही गहरा मिश्रण है। 
            भगवान बताते हैं कि वेदों में 'सामवेद' सबसे मीठा और संगीतमय (Musical) है, इसलिए वह भगवान का स्वरूप है। स्वर्ग को चलाने वाले करोड़ों देवताओं का सुप्रीम बॉस 'इंद्र' भगवान की ही शक्ति से राज करता है।
            लेकिन सबसे बड़ा रहस्य शरीर के अंदर है! हमारी 5 ज्ञानेंद्रियों (आँख, कान आदि) का बॉस कौन है? 'मन' (Mind)। अगर मन न हो, तो आँखें होते हुए भी इंसान कुछ नहीं देख सकता। भगवान कहते हैं कि तुम्हारे शरीर को चलाने वाला यह पावरफुल 'मन' मेरी ही शक्ति है।
            और सबसे बड़ी बात: "भूतानामस्मि चेतना"—यह मिट्टी और पानी का बना हुआ शरीर जिंदा कैसे है? इसके अंदर जो 'चेतना' (Consciousness / Awareness) है, जिसकी वजह से तुम दर्द, खुशी और जीवन को महसूस करते हो, वह 'चेतना' साक्षात् कृष्ण ही हैं।
            जिस दिन वह 'चेतना' (ईश्वर) इस शरीर से बाहर निकल जाती है, यह शरीर तुरंत एक सड़ती हुई लाश बन जाता है।
        """.trimIndent(),
        english = """
            Of all the Vedas I am the Sama Veda; of all the celestial demigods I am Indra, the king of heaven (Vasavah);
            Of all the physical senses I am the mind (Manas); and in all living entities I am the supreme living force, the consciousness (Chetana).
            This spectacular verse operates as a staggering fusion of cosmic administration, biology, and ultimate quantum spirituality.
            The Lord states that among the sacred Vedas, the 'Sama Veda' is the most intensely musical and beautifully harmonic, hence it represents Him. Among the millions of celestial managers, the ultimate CEO 'Indra' rules entirely by borrowing God's power.
            But the absolute greatest revelation lies within the biological body! Who is the ultimate master of your 5 physical senses (eyes, ears, etc.)? The 'Mind'. Without the mind paying attention, open eyes are totally blind. The Lord declares that this staggeringly powerful 'Mind' is His direct representation.
            And the ultimate mic-drop: "Bhutanam asmi chetana"—How exactly is a dead biological machine made of carbon and water currently 'Alive'? The exact 'Consciousness' (Awareness) that allows you to experience pain, joy, and existence is literally the direct presence of Krishna.
            The exact microsecond that 'Consciousness' (God's spark) evacuates the biological machine, the body instantly crashes and rots as dead meat.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            रुद्राणां शङ्करश्चास्मि वित्तेशो यक्षरक्षसाम् |
            वसूनां पावकश्चास्मि मेरुः शिखरिणामहम् || २३ ||
        """.trimIndent(),
        hindi = """
            ग्यारह रुद्रों में मैं 'शंकर' (भगवान शिव) हूँ; यक्षों और राक्षसों में मैं धन का स्वामी 'कुबेर' (वित्तेश) हूँ;
            आठ वसुओं में मैं 'अग्नि' (पावक) हूँ; और ऊँचे शिखर वाले सभी पर्वतों में मैं 'मेरु पर्वत' हूँ।
            भगवान श्रीकृष्ण यहाँ ब्रह्मांड के सबसे शक्तिशाली और विनाशकारी देवताओं (Deities) की बात कर रहे हैं।
            १. 'रुद्राणां शङ्करः': रुद्र वे देवता हैं जो प्रलय (Destruction) के समय हाहाकार मचाते हैं। उन ग्यारह रुद्रों में जो सबसे श्रेष्ठ, कल्याणकारी और महान हैं—साक्षात् 'भगवान शिव' (शंकर)—वे मेरी ही परम विभूति हैं। (यहाँ कृष्ण और शिव की एकता और समानता भी सिद्ध होती है)।
            २. 'वित्तेशो': यक्षों और राक्षसों का राजा 'कुबेर' है, जिसके पास ब्रह्मांड का सारा खजाना और सोना मौजूद है। वह असीम धन और खजाना भी ईश्वर की ही शक्ति है।
            ३. 'पावकः': जो अग्नि (Fire) दुनिया को भस्म कर सकती है, वह भी ईश्वर है।
            ४. 'मेरु पर्वत': हिंदू ब्रह्मांड विज्ञान (Cosmology) के अनुसार मेरु पर्वत पूरे ब्रह्मांड का 'केंद्र' (Center / Axis) है, जो पूरी तरह सोने और रत्नों का बना है।
            भगवान कह रहे हैं कि दुनिया में जहाँ भी तुम्हें एक्सट्रीम पावर (Extreme Power), अनलिमिटेड पैसा (Unlimited Wealth) या असीम विशालता (Massive Size) दिखे, तो समझ लेना कि वह साक्षात् मेरी ही उपस्थिति है।
        """.trimIndent(),
        english = """
            Of all the eleven Rudras I am Lord Shiva (Shankara); of the Yakshas and Rakshasas I am the Lord of wealth, Kubera (Vittesho);
            Of the eight Vasus I am fire (Pavakah); and of all the massive, towering mountains I am Mount Meru.
            Lord Sri Krishna is explicitly highlighting the absolute most overwhelmingly powerful, terrifying, and majestic entities operating within the cosmic matrix.
            1. 'Rudranam Shankarah': The Rudras are the terrifying celestial deities strictly responsible for cosmic destruction and doomsday. Among them, the absolute greatest, most auspicious, and supreme is 'Lord Shiva' (Shankara)—who is officially declared as a direct, non-different manifestation (Vibhuti) of Krishna Himself. (This flawlessly proves the ultimate oneness of God).
            2. 'Vittesho': The king of the Yakshas is 'Kubera', the celestial treasurer who literally hoards and guards the entire physical wealth, gold, and crypto of the universe. That staggering, infinite wealth is God's energy.
            3. 'Pavakah': The blazing 'Fire' that can incinerate entire forests and cities is a spark of His power.
            4. 'Mount Meru': According to Vedic astrophysics, Mount Meru is the absolute geographical, colossal 'Center/Axis' of the universe, manufactured entirely from solid gold and jewels.
            The Lord is programming Arjuna's brain: Wherever you witness 'Extreme Destructive Power', 'Infinite Trillions in Wealth', or 'Unfathomable Massive Size', know with absolute certainty that it is simply My presence operating right in front of you.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            पुरोधसां च मुख्यं मां विद्धि पार्थ बृहस्पतिम् |
            सेनानीनामहं स्कन्दः सरसामस्मि सागरः || २४ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! सभी पुरोहितों (पुजारियों / गुरुओं) में तुम मुझे सबसे मुख्य पुरोहित 'बृहस्पति' (देवताओं के गुरु) जानो।
            सभी सेनापतियों (Generals) में मैं 'स्कंद' (कार्तिकेय / शिव-पार्वती के पुत्र) हूँ; और पानी के सभी जलाशयों में मैं 'समुद्र' (सागर) हूँ।
            श्रीकृष्ण समाज और प्रकृति के 'लीडर्स' (Leaders / नेतृत्व करने वालों) की बात कर रहे हैं।
            १. 'बृहस्पति': ब्रह्मांड में ज्ञान (Knowledge) और धर्म (Religion) का सबसे बड़ा पद देवताओं के गुरु बृहस्पति के पास है। दुनिया की सारी बुद्धि और सारी कूटनीति (Strategy) उन्हीं से निकलती है। भगवान कहते हैं, वह 'सुप्रीम ज्ञान' (Supreme Intellect) मैं ही हूँ।
            २. 'स्कन्द': जब देवताओं और असुरों के बीच 'स्टार वार्स' (Star Wars / ब्रह्मांडीय युद्ध) होता है, तो देवताओं की सेना का मुख्य 'सुप्रीम कमांडर' (Supreme Commander) कार्तिकेय (स्कंद) होते हैं। जो अजेय युद्ध-कौशल (Invincible military strategy) है, वह साक्षात् मेरी विभूति है।
            ३. 'सागरः': दुनिया में बहुत सी नदियां और झीलें हैं, लेकिन उन सबमें सबसे विशाल, गहरा और डरावना 'समंदर' (Ocean) है। समुद्र की कोई लिमिट (Limit) नहीं है, वह अपने भीतर अनगिनत रहस्य छुपाए हुए है।
            भगवान की यह सारी लिस्ट (List) एक ही बात साबित कर रही है कि इंसान को कभी अपने ज्ञान, अपनी ताकत या अपनी गहराई पर घमंड नहीं करना चाहिए, क्योंकि उनका 'मैक्सिमम लेवल' (Maximum Level) पहले से ही ईश्वर की प्रॉपर्टी (Property) है।
        """.trimIndent(),
        english = """
            O son of Pritha, of all priests and spiritual guides, know Me to be the absolute chief, Brihaspati (the spiritual master of the demigods).
            Of all generals and supreme military commanders, I am Skanda (Kartikeya, the son of Shiva); and of all massive bodies of water, I am the vast ocean (Sagaram).
            Sri Krishna is actively spotlighting the absolute 'Supreme Leaders' and the highest hierarchical authorities in both celestial society and physical nature.
            1. 'Brihaspati': In the entire multiverse, the highest, most prestigious portfolio of 'Knowledge, Religion, and Intelligence' belongs to Brihaspati (the Guru of the Demigods). All cosmic diplomacy and pure intellectual genius radiate from him. The Lord declares: That 'Supreme Intellect' is ME.
            2. 'Skanda': When massive, apocalyptic 'Star Wars' break out between the celestial gods and the demonic forces, the undisputed 'Supreme Military Commander' leading the gods is Skanda (Kartikeya). That absolute, flawless, invincible military strategy and combat prowess is My direct opulence.
            3. 'Sagaram': There are millions of rivers and lakes, but the absolute most terrifyingly gigantic, bottomless, and unfathomably mysterious body of water is the 'Ocean'. Its limits are practically unmeasurable.
            This staggering inventory compiled by the Lord repeatedly hammers home one massive psychological point: A mortal human must absolutely NEVER harbor toxic arrogance over his petty intellect, his tiny military power, or his depth of knowledge, because the absolute 'Maximum Limit' of those traits is already the exclusive, copyrighted property of God.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            महर्षीणां भृगुरहं गिरामस्म्येकमक्षरम् |
            यज्ञानां जपयज्ञोऽस्मि स्थावराणां हिमालयः || २५ ||
        """.trimIndent(),
        hindi = """
            महान ऋषियों में मैं महर्षि 'भृगु' हूँ; शब्दों (वाणियों) में मैं केवल एक अक्षर वाला परम मंत्र 'ॐ' (एकम् अक्षरम्) हूँ।
            सभी प्रकार के यज्ञों में मैं 'जप-यज्ञ' (भगवान के नाम का शांति से जप करना) हूँ; और स्थिर (न हिलने वाली) चीज़ों में मैं 'हिमालय' पर्वत हूँ।
            भगवान श्रीकृष्ण यहाँ 'अध्यात्म' (Spirituality) के सबसे बड़े और सबसे आसान हथियारों का खुलासा कर रहे हैं।
            महर्षि भृगु ब्रह्मांड के सबसे शक्तिशाली और तपस्वी ऋषि माने जाते हैं (जिन्होंने विष्णु भगवान की छाती पर लात मारने की हिम्मत की थी, फिर भी भगवान ने उन्हें सम्मान दिया)।
            शब्दों में सबसे पावरफुल (Powerful) क्या है? कोई लंबी-चौड़ी कविता नहीं, बल्कि केवल एक अक्षर 'ॐ' (OM)। यह पूरे ब्रह्मांड का 'सीड-साउंड' (Seed-sound / मूल ध्वनि) है।
            सबसे बड़ा धमाका भगवान 'यज्ञ' के बारे में करते हैं। लोग लाखों रुपए खर्च करके आग जलाकर यज्ञ करते हैं। लेकिन भगवान कहते हैं कि सबसे बड़ा यज्ञ 'जप-यज्ञ' (Chanting the Holy Name) है! 
            'जप' में किसी पैसे की जरूरत नहीं, किसी पंडित की जरूरत नहीं, और इसमें कोई हिंसा (जानवरों की बलि) नहीं होती। यह सबसे साइलेंट (Silent), सबसे पावरफुल और सबसे प्योर (Pure) यज्ञ है।
            और जो चीज़ें कभी अपनी जगह से नहीं हिलतीं (स्थावर), उनमें 'हिमालय' मैं हूँ। हिमालय न केवल अपनी विशालता के लिए, बल्कि अपनी 'अडिग शांति' (Unshakeable Peace) और पवित्रता के लिए ईश्वर का ही भौतिक रूप है।
        """.trimIndent(),
        english = """
            Of the great sages I am Bhrigu; of all vibrations and spoken words I am the transcendental syllable OM (Ekam aksharam).
            Of all sacrifices I am the chanting of the holy names (Japa-yajnah), and of all immovable, firmly established things I am the Himalayan mountains.
            Lord Sri Krishna is unlocking the absolute greatest, most highly efficient, and easily accessible 'Spiritual Super-Weapons' in this universe.
            Maharishi Bhrigu is officially recognized as the most terrifyingly powerful and ascetic sage in the cosmos (who once famously dared to kick Lord Vishnu on the chest to test Him, yet the Lord respectfully accepted it).
            What is the absolute most powerful word in existence? It is absolutely not a complex, 1000-page poem; it is the singular, supreme seed-syllable 'OM'. It is the literal sonic vibration of the entire universe.
            But the Lord drops the absolute biggest bombshell regarding 'Yajnas' (Sacrifices). Ignorant humans burn millions of dollars organizing highly complex, massive fire-rituals. But the Supreme Lord declares the absolute greatest sacrifice is 'Japa-yajna' (the silent, meditative chanting of God's holy names)!
            'Japa' requires exactly zero money, zero external priests, and involves absolutely zero violence. It is the most silent, most universally accessible, and infinitely most powerful spiritual transaction.
            And among entities that absolutely never move (Sthavara), the Lord is the 'Himalayas'. The Himalayas represent not just terrifying physical magnitude, but the absolute, 'Unshakeable Peace' and supreme purity of God physically manifesting on earth.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            अश्वत्थः सर्ववृक्षाणां देवर्षीणां च नारदः |
            गन्धर्वाणां चित्ररथः सिद्धानां कपिलो मुनिः || २६ ||
        """.trimIndent(),
        hindi = """
            मैं सभी पेड़ों (वृक्षों) में 'पीपल' का पेड़ (अश्वत्थः) हूँ; देवर्षियों (देवताओं के ऋषियों) में मैं 'नारद' मुनि हूँ;
            गन्धर्वों (स्वर्ग के गायकों) में मैं 'चित्ररथ' हूँ; और जन्म से ही सिद्ध (परफेक्ट) महापुरुषों में मैं 'कपिल मुनि' हूँ।
            यह श्लोक सृष्टि की दिव्यता (Divinity) को अलग-अलग प्रजातियों में दिखा रहा है।
            १. 'अश्वत्थः' (पीपल का पेड़): पीपल का पेड़ भारतीय संस्कृति में सबसे पवित्र माना जाता है। विज्ञान के अनुसार भी यह उन गिने-चुने पेड़ों में से है जो दिन-रात (24 घंटे) ऑक्सीजन (Oxygen) देता है। इसकी जड़ें बहुत गहरी होती हैं और उम्र हज़ारों साल होती है। यह प्रकृति में भगवान की 24/7 सेवा (ऑक्सीजन देना) का प्रतीक है।
            २. 'नारद': नारद जी वो 'यूनिवर्सल रिपोर्टर और गाइड' (Universal Guide) हैं जो देवताओं, राक्षसों और इंसानों—सबके पास जाकर उन्हें भगवान की भक्ति का सही रास्ता दिखाते हैं। उनका काम ही 24 घंटे नारायण-नारायण जपना है।
            ३. 'चित्ररथ': स्वर्ग के गंधर्व (Gandharvas) दुनिया के सबसे महान संगीतकार (Musicians) और गायक हैं, और उनमें जो सबसे बेस्ट (Best) सिंगर है 'चित्ररथ', उसकी आवाज़ का जादू साक्षात् कृष्ण हैं।
            ४. 'कपिल मुनि': कपिल मुनि 'सांख्य दर्शन' (Analytical Philosophy) के रचयिता हैं और उन्हें जन्म से ही (Without any practice) ब्रह्मांड का सारा ज्ञान प्राप्त था।
            ईश्वर हर उस जगह मौजूद है जहाँ 'परफेक्शन' (Perfection / पूर्णता) अपने टॉप लेवल पर होती है।
        """.trimIndent(),
        english = """
            Of all trees I am the sacred banyan tree (Ashvatthah), and of all the celestial sages among the demigods I am Narada.
            Of the celestial singers and musicians (Gandharvas) I am Chitraratha, and among perfected, self-realized beings (Siddhas) I am the great sage Kapila Muni.
            This spectacular verse flawlessly highlights the exact peak of 'Divinity and Perfection' operating across completely different cosmic species and professions.
            1. 'Ashvatthah' (The Pipal / Banyan Tree): The Ashvattha is universally worshipped as the most highly sacred tree in Vedic culture. Scientifically, it is one of the extremely rare species that photosynthesizes and actively pumps life-saving 'Oxygen' into the atmosphere 24/7. With roots plunging unfathomably deep and a lifespan of thousands of years, it is the absolute biological symbol of God's eternal, life-sustaining mercy.
            2. 'Narada': Narada Muni is the ultimate, universally respected 'Cosmic Guide' and space-traveler who actively infiltrates the camps of demigods, humans, and even terrifying demons, exclusively to aggressively preach the pure devotion of God. He is the ultimate spiritual ambassador.
            3. 'Chitraratha': The Gandharvas are the absolute most elite, mesmerizing, and staggeringly talented celestial musicians in the universe. Among them, the absolute greatest superstar singer is 'Chitraratha'; the sheer hypnotic magic of his voice is the direct presence of Krishna.
            4. 'Kapila Muni': Lord Kapila is the original author of the highly advanced 'Sankhya Philosophy' (Analytical study of the soul). He was a 'Siddha' (Perfected being) right from his mother's womb, possessing 100% downloaded cosmic data with zero external practice.
            God undeniably exists physically and spiritually wherever 'Absolute Perfection' reaches its ultimate zenith.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            उच्चैःश्रवसमश्वानां विद्धि माममृतोद्भवम् |
            ऐरावतं गजेन्द्राणां नराणां च नराधिपम् || २७ ||
        """.trimIndent(),
        hindi = """
            घोड़ों में तुम मुझे अमृत के साथ (समुद्र-मंथन से) उत्पन्न होने वाला 'उच्चैःश्रवा' नामक घोड़ा जानो;
            महान हाथियों (गजेन्द्रों) में मैं 'ऐरावत' (इंद्र का सफेद हाथी) हूँ; और मनुष्यों में मैं राजा (नराधिपम् / सम्राट) हूँ।
            भगवान श्रीकृष्ण यहाँ राजसी शक्तियों (Royal Opulences) और 'लॉ ऑफ एडमिनिस्ट्रेशन' (Law of Administration) की बात कर रहे हैं।
            देवताओं और असुरों ने जब अमृत के लिए समुद्र मंथन (Samudra Manthan / Churning of the Ocean) किया था, तो उसमें से दुनिया की सबसे 'प्रीमियम' (Premium) चीज़ें निकली थीं।
            १. 'उच्चैःश्रवा': यह कोई आम घोड़ा नहीं है; यह समुद्र मंथन से निकला हुआ सफेद रंग का, उड़ने वाला और ब्रह्मांड का सबसे तेज़ और ताकतवर घोड़ा है (जो इंद्र के पास है)। 
            २. 'ऐरावत': यह भी समुद्र मंथन से निकला था। यह सफेद रंग का सबसे विशालकाय और अजेय हाथी है।
            यानी जानवरों में जो सबसे सुप्रीम (Supreme) और 'अनबीटेबल' (Unbeatable) प्रजाति है, वह भगवान की ही झलक है।
            ३. 'नराधिपम्' (राजा): भगवान कहते हैं कि इंसानों के समाज में जो एक 'सच्चा और न्यायप्रिय राजा' (सम्राट) होता है, वह भगवान का ही प्रतिनिधि (Representative) होता है।
            समाज को चलाने के लिए लीडरशिप (Leadership), न्याय (Justice) और अनुशासन (Discipline) की ज़रूरत होती है। एक राजा के अंदर लाखों लोगों को एक साथ कंट्रोल करने की जो पावर (Power/Aura) होती है, वह पावर कोई आम इंसान की नहीं हो सकती; वह सीधे भगवान की दी हुई 'एडमिनिस्ट्रेटिव पावर' (Administrative Power) है।
        """.trimIndent(),
        english = """
            Of all horses, you should know Me to be Uchchaihshrava, who was produced simultaneously with the nectar of immortality during the churning of the ocean (Amritodbhavam).
            Of all lordly elephants I am Airavata, and among all human beings, I am the supreme monarch and king (Naradhipam).
            Lord Sri Krishna is exclusively highlighting the absolute zenith of 'Royal Cosmic Opulences' and the supreme 'Laws of Administration' here.
            During the legendary cosmic event of the 'Samudra Manthan' (The violent churning of the milky ocean by demigods and demons for the nectar of immortality), the absolute most 'Premium', ultra-rare, and majestic cosmic entities were physically extracted.
            1. 'Uchchaihshrava': This is absolutely no ordinary earthly biological horse. It is a terrifyingly fast, pure white, flying celestial stallion generated directly from the cosmic ocean (currently owned by Indra). It is the absolute Bugatti of the universe.
            2. 'Airavata': Also extracted from the ocean, this is an unimaginably colossal, invincible, pure white celestial elephant that serves as the ultimate tank of the heavens.
            Meaning: The absolute most 'Unbeatable', supreme apex entities in the animal kingdom are direct, physical flashes of God's majestic power.
            3. 'Naradhipam' (The King): The Lord officially declares that in human society, a 'Righteous, Just, and Supreme Emperor' is the literal administrative representative of God on earth.
            To maintain sanity in a chaotic society, staggering 'Leadership', brutal 'Justice', and iron-clad 'Discipline' are strictly required. The hypnotic, commanding Aura and supreme political power a King wields to effortlessly control millions of humans is absolutely not a normal biological trait; it is a highly concentrated 'Administrative Superpower' officially downloaded directly from God.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            आयुधानामहं वज्रं धेनूनामस्मि कामधुक् |
            प्रजनश्चास्मि कन्दर्पः सर्पाणामस्मि वासुकिः || २८ ||
        """.trimIndent(),
        hindi = """
            सभी हथियारों (आयुधों) में मैं 'वज्र' (इंद्र का अस्त्र) हूँ; गायों में मैं 'कामधेनु' (सब इच्छाएं पूरी करने वाली गाय) हूँ;
            संतान पैदा करने के कारणों में मैं 'कामदेव' (कन्दर्पः / प्रेम का देवता) हूँ; और सभी विषैले साँपों में मैं 'वासुकि' (नागों का राजा) हूँ।
            १. 'वज्र': दधीचि ऋषि की हड्डियों से बना 'वज्र' ब्रह्मांड का सबसे खतरनाक और न टूटने वाला हथियार (Ultimate Weapon) है। भगवान कहते हैं कि वह अजेय शक्ति मैं हूँ।
            २. 'कामधुक्' (कामधेनु): स्वर्ग की वह जादुई गाय जो इंसान की 'हर इच्छा' (चाहे वह कोई भी खाना या खजाना हो) पल भर में पूरी कर देती है। दुनिया का सबसे बड़ा प्रोवाइडर (Provider) ईश्वर ही है।
            ३. 'कन्दर्पः' (कामदेव): यह बहुत ही बोल्ड (Bold) और गहरा रहस्य है। सेक्स (Sex/कामवासना) को लोग गंदा मानते हैं, लेकिन भगवान कहते हैं कि वह 'यौन-आकर्षण' (Sexual Attraction) जो केवल एक नई और अच्छी संतान (Procreation) को जन्म देने के उद्देश्य से होता है, वह आकर्षण कोई पाप नहीं, बल्कि साक्षात् 'कृष्ण' हैं। क्योंकि उसी के कारण दुनिया आगे बढ़ रही है।
            ४. 'वासुकि': साँपों (जिनमें एक ही सिर होता है और भयंकर ज़हर होता है) का सबसे बड़ा राजा 'वासुकि' है (जिसका इस्तेमाल समुद्र मंथन में रस्सी के रूप में किया गया था और जो शिवजी के गले में रहता है)। प्रकृति की सबसे खतरनाक और ज़हरीली (Toxic/Deadly) शक्ति भी भगवान के ही कंट्रोल में है।
        """.trimIndent(),
        english = """
            Of all destructive weapons I am the thunderbolt (Vajram); among cows I am the celestial, wish-fulfilling cow Surabhi (Kamadhuk).
            Of all causes for procreation I am Kandarpa, the god of love (Cupid); and of all single-headed venomous serpents I am Vasuki.
            1. 'Vajram' (The Thunderbolt): Manufactured entirely from the ultra-purified, indestructible bones of the great Sage Dadhichi, the 'Vajra' is the absolute most terrifying, lethal, and 'Ultimate Weapon of Mass Destruction' in the cosmic arsenal. The Lord declares, "I am that invincible, destructive power."
            2. 'Kamadhuk' (Surabhi): The magical, highly highly celestial cow of the upper planets that instantaneously manifests and provides absolutely 'Anything' (unlimited food, wealth, resources) its owner desires. The Supreme Lord is the ultimate, infinite 'Provider' of the multiverse.
            3. 'Kandarpah' (Cupid): This is a remarkably bold, shockingly profound revelation. Ignorant society blindly labels 'Sex' as a dirty, filthy sin. But the Lord officially declares that the intense 'Sexual Attraction' executed strictly for the noble, sacred purpose of procreating and raising righteous children is absolutely NOT a sin; it is literally the physical manifestation of 'Krishna'. Because that exact powerful drive flawlessly sustains the human race.
            4. 'Vasuki': Among all venomous, single-headed serpents, the absolute supreme king is 'Vasuki' (the gargantuan snake used as the churning rope during the Samudra Manthan, who fiercely rests around Lord Shiva's neck). This proves that even the absolute most terrifying, highly toxic, and lethal forces of nature are strictly manufactured and completely controlled by God.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            अनन्तश्चास्मि नागानां वरुणो यादसामहम् |
            पितॄणामर्यमा चास्मि यमः संयमतामहम् || २९ ||
        """.trimIndent(),
        hindi = """
            अनेक फनों (सिरों) वाले नागों में मैं 'अनंतनाग' (शेषनाग) हूँ; जल में रहने वाले जीवों और जल-देवताओं में मैं 'वरुण' (जल का देवता) हूँ;
            सभी पितरों (पूर्वजों) में मैं 'अर्यमा' (पितरों का राजा) हूँ; और नियमन (कंट्रोल/सज़ा) करने वालों में मैं साक्षात् 'यमराज' (मौत का देवता) हूँ।
            १. 'अनन्त' (शेषनाग): पिछले श्लोक में साधारण साँपों की बात थी, यहाँ 'नागों' (जिनके कई सिर होते हैं) की बात है। 'अनंत' (जिसका कोई अंत नहीं) वह विशाल नाग है जिस पर भगवान विष्णु आराम करते हैं और जिसने अपने फन पर पूरे ब्रह्मांड (Gravity) को उठाया हुआ है।
            २. 'वरुण': समुद्र और पानी के अंदर जो विशालकाय जीव (Whales, Monsters) और एक पूरी की पूरी दुनिया है, उस दुनिया का सुप्रीम कमांडर (Supreme Commander) 'वरुण' देव है।
            ३. 'अर्यमा': जब इंसान मरता है, तो पितृलोक में उसके पूर्वजों (Ancestors) का जो सबसे बड़ा और श्रेष्ठ नेता (Head) है, वह अर्यमा है।
            ४. 'यमः संयमतामहम्': यह सबसे डरावनी और पावरफुल (Powerful) लाइन है! इस दुनिया में लोग पुलिस या कानून से बच सकते हैं, लेकिन ब्रह्मांड का सबसे बड़ा पुलिस-चीफ (Chief of Justice & Punishment) 'यमराज' है।
            यमराज की अदालत में कोई रिश्वत (Bribe) नहीं चलती। यमराज वह 'सिस्टम' (System) है जो हर पापी को बिना किसी दया के उसके कर्मों का सही फल देता है। भगवान कहते हैं कि वह 'कठोर न्याय' (Absolute Justice) और मौत (Death) भी साक्षात् मैं ही हूँ!
        """.trimIndent(),
        english = """
            Of the many-hooded Nagas (serpents) I am Ananta; of the aquatic deities and all entities that live in the water I am the demigod Varuna.
            Of all departed ancestors I am Aryama; and among all dispensers of law, justice, and punishment, I am Yama, the lord of death.
            1. 'Ananta' (Shesha-naga): The previous verse classified single-headed snakes, but here the Lord specifies 'Nagas' (colossal, multi-hooded divine serpents). 'Ananta' (The Endless One) is the unimaginably gigantic, infinite cosmic serpent who serves as the eternal resting bed for Lord Vishnu and effortlessly balances the gravitational weight of all the universes upon his massive hoods.
            2. 'Varuna': The dark, terrifying, and unfathomably deep oceans contain a completely alien, massive world of monstrous aquatic creatures and forces. The absolute 'Supreme Commander' and CEO regulating that entire liquid dimension is the demigod 'Varuna'.
            3. 'Aryama': When a human dies, in the incredibly complex administrative dimension of 'Pitri-loka' (the planet of ancestors), the absolute supreme head, chief administrator, and highest recognized ancestor is Aryama.
            4. 'Yamah samyamatam aham': This is the absolute most terrifying and overwhelmingly powerful line! In the earthly matrix, highly corrupt humans can easily bribe human judges and escape the pathetic human police force. But the absolute 'Supreme Chief of Police and Ultimate Judge' of the entire cosmos is 'Yamaraja' (The Lord of Death).
            In Yamaraja's supreme court, absolutely zero bribes, tears, or fake excuses are accepted. Yamaraja is the cold, calculated 'System' that flawlessly dispenses brutal, unyielding cosmic justice and punishment. The Supreme Lord chillingly declares: "That terrifying, absolute, unapologetic 'Justice and Death' is literally ME!"
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            प्रह्लादश्चास्मि दैत्यानां कालः कलयतामहम् |
            मृगाणां च मृगेन्द्रोऽहं वैनतेयश्च पक्षिणाम् || ३० ||
        """.trimIndent(),
        hindi = """
            दैत्यों (राक्षसों) में मैं 'प्रह्लाद' हूँ; गणना (गिनती/Control) करने वालों में मैं साक्षात् 'काल' (समय / Time) हूँ;
            जंगली पशुओं (जानवरों) में मैं उनका राजा 'सिंह' (शेर/मृगेन्द्र) हूँ; और पक्षियों में मैं 'गरुड़' (वैनतेय) हूँ।
            १. 'प्रह्लाद': यह बहुत ही दिलचस्प बात है। हिरण्यकशिपु जैसे भयंकर राक्षसों के वंश (दैत्यों) में पैदा होने के बावजूद, प्रह्लाद भगवान के सबसे महान भक्त थे। भगवान यह साबित कर रहे हैं कि 'जन्म या जाति' (Caste) से कोई फर्क नहीं पड़ता। कीचड़ (राक्षस कुल) में भी कमल (भक्त) खिल सकता है, और वह कमल साक्षात् भगवान का ही रूप है।
            २. 'कालः कलयताम्': इस ब्रह्मांड में सबसे शक्तिशाली 'कंट्रोलर' (Controller) कौन है? 'समय' (Time)। 
            समय किसी के लिए नहीं रुकता। समय सबसे सुंदर चेहरे को बुढ़ापे में बदल देता है, समय बड़े-बड़े महलों को खंडहर बना देता है, और समय दुनिया के सबसे ताकतवर राजा को भी मिट्टी में मिला देता है। उस अजेय और खौफनाक 'समय' (Time) का नाम ही कृष्ण है।
            ३. 'मृगेन्द्र': जानवरों के जंगल में शेर (Lion) राजा होता है। शेर कोई वोटिंग (Voting) से राजा नहीं बनता, वह अपनी निडरता (Fearlessness), शक्ति और 'रॉयल ऑरा' (Royal Aura) के कारण राजा होता है। वह ऑरा (Aura) ईश्वर का है।
            ४. 'वैनतेय' (गरुड़): पक्षियों में सबसे विशाल, सबसे तेज़ और भगवान विष्णु का अपना प्राइवेट जेट (Private Jet / वाहन) 'गरुड़' है, जो नागों (ज़हर) का सबसे बड़ा दुश्मन है। वह गरुड़ भी ईश्वर की ही शक्ति है।
        """.trimIndent(),
        english = """
            Among the Daityas (demons) I am the great, devoted Prahlada; among all subduers and things that measure, I am Time (Kalah).
            Among all the beasts of the jungle I am the lion (Mrigendrah), and among all the birds I am Garuda (Vainateyah).
            1. 'Prahlada': This is an incredibly fascinating and paradigm-breaking inclusion. Despite being biologically born directly into the absolute most toxic, horrific, and demonic bloodline of the universe (the Daityas, led by the terrorist Hiranyakashipu), Prahlada emerged as the absolute greatest, purest devotee of God. The Lord officially proves that biological 'Birth or Caste' is mathematically irrelevant. A flawless, divine lotus (devotee) can bloom right in the middle of a toxic swamp (demon family), and that lotus is the direct manifestation of God.
            2. 'Kalah kalayatam': Who is the absolute most terrifying, undisputed, invincible 'Controller and Destroyer' in the entire multiverse? 'TIME' (Kala).
            Time stops for absolutely no billionaire. Time brutally degrades the most flawless physical beauty into wrinkled rot; Time violently crushes billion-dollar empires into forgotten dust; and Time slaughters the most powerful emperors, returning them to dirt. That cold, calculated, invincible, and terrifying force called 'Time' is literally Krishna.
            3. 'Mrigendra' (The Lion): In the brutal, chaotic jungle, the Lion is the undisputed King. A lion does not become king through democratic voting; he dominates purely through his staggering 'Fearlessness', raw brute strength, and intimidating 'Royal Aura'. That majestic Aura is God's energy.
            4. 'Vainateya' (Garuda): Among all winged creatures, the absolute most massive, hyper-fast, apex predator is 'Garuda'—who acts as Lord Vishnu's personal, celestial 'Private Jet' (Carrier) and is the ultimate, terrifying nightmare for all venomous snakes. That staggering power is also a spark of the Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            पवनः पवतामस्मि रामः शस्त्रभृतामहम् |
            झषाणां मकरश्चास्मि स्रोतसामस्मि जाह्नवी || ३१ ||
        """.trimIndent(),
        hindi = """
            पवित्र करने वालों (या तेज़ गति से चलने वालों) में मैं 'पवन' (वायु/हवा) हूँ; शस्त्र (हथियार) धारण करने वाले सभी योद्धाओं में मैं साक्षात् 'परशुराम' (या मर्यादा पुरुषोत्तम राम) हूँ;
            मछलियों (जल-जीवों) में मैं 'मकर' (मगरमच्छ / Shark) हूँ; और सभी नदियों में मैं 'गंगा' (जाह्नवी) हूँ।
            १. 'पवन': हवा (Wind) दुनिया की सबसे बड़ी 'क्लीनर' (Cleaner) और 'स्पीड' (Speed) है। एक तूफान शहर के सारे प्रदूषण (Pollution) को मिनटों में साफ कर देता है और यह इतनी तेज़ है कि कोई इसे पकड़ नहीं सकता। यह अदृश्य शक्ति ईश्वर है।
            २. 'रामः': भगवान यहाँ कहते हैं कि जितने भी लोग दुनिया में हथियार उठाते हैं, उनमें सबसे महान, सबसे अचूक और सबसे धर्मपरायण योद्धा 'राम' हैं। (राम का हर तीर लक्ष्य को भेदकर ही वापस आता है)। अजेय युद्ध-कौशल कृष्ण ही हैं।
            ३. 'मकर': पानी के अंदर लाखों प्रजातियां हैं, लेकिन उन सबमें सबसे खूंखार, विशाल और 'एपेक्स प्रिडेटर' (Apex Predator / जिसके ऊपर कोई शिकारी नहीं) मगरमच्छ या शार्क (मकर) है। पानी के अंदर उसका जो खौफ (Terror) है, वह ईश्वरीय शक्ति है।
            ४. 'जाह्नवी' (गंगा): दुनिया में अमेज़न (Amazon) जैसी बहुत सी बड़ी नदियां हैं। लेकिन 'गंगा' कोई आम नदी (H2O) नहीं है। यह स्वर्ग से उतरी हुई वह 'लिक्विड स्पिरिचुअलिटी' (Liquid Spirituality) है, जिसकी एक बूंद इंसान के करोड़ों जन्मों के पापों को धो डालती है। नदियों में जो सबसे पवित्र और मोक्ष देने वाली है, वह साक्षात् ईश्वर है।
        """.trimIndent(),
        english = """
            Of all the purifiers and swift-moving forces I am the wind (Pavanah); of all the wielders of weapons I am Rama.
            Of all the fishes and aquatic predators I am the shark/crocodile (Makara), and of all the flowing rivers I am the sacred Ganges (Jahnavi).
            1. 'Pavanah': The invisible Wind is the absolute greatest 'Cosmic Cleaner' and possesses the highest raw 'Speed' in nature. A violent hurricane effortlessly sweeps away millions of tons of toxic urban pollution in mere minutes, and it is so incredibly fast and elusive that absolutely no human can physically catch it. That invisible, purifying, kinetic power is God.
            2. 'Ramah': The Lord officially declares that among every single warrior, sniper, or soldier who has ever wielded a weapon in the history of the multiverse, the absolute greatest, most flawlessly accurate, and supremely righteous warrior is 'Lord Rama'. (Rama's arrows are strictly guided by absolute Dharma and absolutely never miss their target). That invincible, lethal martial prowess is Krishna.
            3. 'Makara': Beneath the terrifying, pitch-black surface of the oceans, there are millions of species. But the absolute 'Apex Predator'—the most massive, ruthless, cold-blooded killing machine that sits completely unchallenged at the very top of the food chain—is the Makara (the Great Shark/Crocodile). That paralyzing underwater terror and raw power is God's spark.
            4. 'Jahnavi' (The Ganges): The earth contains massively long, physical rivers like the Amazon or the Nile. But the 'Ganga' is absolutely NOT ordinary biological H2O. It is literal 'Liquid Spirituality' that descended directly from the heavens. A single microscopic drop of the Ganges possesses the staggering cosmic power to violently incinerate millions of lifetimes of horrific sins. The absolute purest, liberating entity among waters is God Himself.
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            सर्गाणामादिरन्तश्च मध्यं चैवाहमर्जुन |
            अध्यात्मविद्या विद्यानां वादः प्रवदतामहम् || ३२ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! इस पूरी सृष्टि (ब्रह्मांड की सभी रचनाओं / सर्गाणां) का आदि (शुरुआत/Creation), अंत (विनाश/Destruction), और मध्य (पालन/Maintenance) भी मैं ही हूँ।
            दुनिया की सभी विद्याओं (Sciences) में मैं 'अध्यात्म-विद्या' (आत्मा का विज्ञान / Spiritual Science) हूँ; और विवाद (Debate) करने वालों में मैं 'वाद' (सत्य का निर्णय करने वाला 'निष्कर्ष' / Logical conclusion) हूँ।
            १. सृष्टि का आदि, मध्य, अंत: भगवान 20वें श्लोक में यह बात जीवों (Living entities) के लिए कह चुके हैं। यहाँ वे 'सर्गाणां' (पूरी भौतिक दुनिया, ग्रहों, और मटेरियल क्रिएशन / Material Creation) के लिए कह रहे हैं। इस पूरे यूनिवर्स का बिग-बैंग (आदि), इसकी ग्रेविटी (मध्य), और इसका ब्लैक-होल (अंत) साक्षात् कृष्ण ही हैं।
            २. 'अध्यात्म-विद्या': दुनिया में बहुत सी 'विद्याएं' (Sciences) हैं—इंजीनियरिंग, मेडिकल, कंप्यूटर साइंस। ये सब शरीर और पैसे के लिए हैं। लेकिन भगवान कहते हैं कि इन सब साइंसेज़ (Sciences) का 'बॉस' (Boss) 'अध्यात्म-विद्या' है! क्योंकि यह इकलौती विद्या है जो यह बताती है कि "मैं कौन हूँ और मुझे हमेशा के लिए आज़ादी (मोक्ष) कैसे मिलेगी।"
            ३. 'वाद': जब दो बहुत होशियार लोग बहस (Debate) करते हैं, तो उसमें तीन चीजें होती हैं: 'जल्प' (केवल दूसरे को हराने के लिए बोलना), 'वितंडा' (बिना लॉजिक के बस अपनी जिद पर अड़े रहना), और 'वाद'। 
            'वाद' का मतलब है वह शानदार और 100% लॉजिकल 'चर्चा' जिसका इकलौता मकसद 'सच्चाई' (Truth) को खोजना है। जो ज्ञान 'सत्य' (Siddhanta) पर जाकर खत्म होता है, वह 'वाद' साक्षात् ईश्वर है।
        """.trimIndent(),
        english = """
            Of all material creations, I am the absolute beginning (Adir), the ultimate end (Antash cha), and the middle or maintainer (Madhyam chaiva), O Arjuna.
            Of all the various sciences and education, I am the spiritual science of the self (Adhyatma-vidya), and among logicians and debaters, I am the conclusive, ultimate truth (Vadah pravadatam aham).
            1. Beginning, Middle, and End of Creations: The Lord previously stated this in Verse 20 regarding 'Living Entities' (souls). Here, He is explicitly applying it to 'Sarganam' (The entire colossal Material Creation, physical planets, and universes). The explosive Big Bang (Creation), the gravitational suspension (Maintenance), and the terrifying Black Hole (Destruction) of this entire multiverse are literally Krishna Himself.
            2. 'Adhyatma-Vidya': The modern world is obsessed with thousands of elite 'Sciences'—Aeronautical Engineering, Quantum Mechanics, Neurosurgery. But these are merely petty instructions on how to maintain a dying biological body and hoard dead paper money. The Lord declares that the absolute 'Supreme Boss' of all academic knowledge is 'Adhyatma-Vidya' (The Science of the Eternal Soul)! Because it is the absolute ONLY science that permanently cures the disease of death and grants eternal Moksha.
            3. 'Vadah': When highly arrogant intellectuals engage in aggressive Debates, they typically employ: 'Jalpa' (speaking purely to brutally defeat and humiliate the opponent) or 'Vitanda' (illogically and stubbornly defending a fake point just to be annoying).
            But 'Vada' is the incredibly pure, highly logical, and deeply respectful 'Philosophical Discourse' where the absolute ONLY motive is to collaboratively discover the 'Supreme Truth' (Siddhanta). That flawlessly logical, ultimate Truth is God Himself.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            अक्षराणामकारोऽस्मि द्वन्द्वः सामासिकस्य च |
            अहमेवाक्षयः कालो धाताहं विश्वतोमुखः || ३३ ||
        """.trimIndent(),
        hindi = """
            सभी अक्षरों (Letters/Alphabets) में मैं 'अ' कार (A) हूँ; और समासों (Compound words) में मैं 'द्वंद्व समास' हूँ।
            मैं ही कभी नष्ट न होने वाला (अक्षयः) 'महाकाल' (Endless Time) हूँ; और मैं ही चारों ओर मुख वाला (विश्वतोमुखः / अर्थात् ब्रह्मा या सब कुछ देखने वाला) 'विधाता' (Sustainer/Creator) हूँ।
            १. 'अकारोऽस्मि': दुनिया की किसी भी भाषा (संस्कृत, हिंदी, अंग्रेजी) को बोलने के लिए गले से जो सबसे पहली और बेसिक (Basic) आवाज़ निकलती है, वह 'अ' (A) है। 'अ' के बिना आप कुछ बोल ही नहीं सकते (यह हर व्यंजन में छुपा होता है, जैसे क्+अ=क)। सारी भाषाओं का जो 'स्टार्टिंग पॉइंट' (Base) है, वह ईश्वर है।
            २. 'द्वंद्व समास': व्याकरण (Grammar) में जब दो शब्दों को जोड़ा जाता है (समास), तो उनमें अक्सर एक शब्द छोटा और एक बड़ा हो जाता है। लेकिन 'द्वंद्व समास' (जैसे माता-पिता, दिन-रात) में दोनों शब्द 100% 'बराबर' (Equal) होते हैं। यह 'बराबरी' (Equality) और 'संतुलन' (Balance) भगवान का रूप है।
            ३. 'अक्षयः कालः': दुनिया की हर चीज़ खत्म हो जाती है, लेकिन 'समय' (Time) कभी खत्म नहीं होता। समय ही इस ब्रह्मांड का सबसे बड़ा 'साइलेंट किलर' (Silent Killer) और शासक है। वह 'महाकाल' जो बड़े-बड़े ग्रहों को धूल बना देता है, वह कृष्ण ही हैं।
            ४. 'धाताहं विश्वतोमुखः': भगवान की आँखें और मुँह हर दिशा (360 degrees) में हैं। आप ब्रह्मांड के किसी भी कोने में छुपकर कोई पाप या पुण्य करें, उनकी 'सीसीटीवी' (CCTV/विश्वतोमुख) नज़रों से आप बच नहीं सकते। वे ही सब कुछ देख रहे हैं और सबको पाल रहे हैं।
        """.trimIndent(),
        english = """
            Of all letters in the alphabet I am the primary letter 'A' (Akaro 'smi), and among all compound words I am the dual compound (Dvandvah).
            I am also the inexhaustible, endless, and eternal Time (Akshayah kalo), and of all the creators and maintainers I am Brahma, whose multiple faces look in all directions (Dhataham vishvato-mukhah).
            1. 'Akaro 'smi': In absolutely any linguistic system in the world, the very first, most fundamental, and primitive sonic vibration generated from the human throat is 'A' (Ah). It is biologically and linguistically impossible to speak or formulate consonants without the underlying, invisible presence of 'A'. The absolute 'Starting Point' and base code of all universal communication is God.
            2. 'Dvandvah' (The Dual Compound): In complex Sanskrit grammar, when words are fused together (Samasa), usually one word dominates while the other becomes subordinate. But in the 'Dvandva' compound (e.g., Rama-Krishna, Day-Night), both words retain 100% absolute 'Equality' and identical weight. This flawless, perfect 'Equilibrium and Balance' is the exact representation of God.
            3. 'Akshayah kalah': Absolutely every single physical entity, star, and galaxy in this matrix has an expiration date. But 'TIME' (Kala) is utterly indestructible, inexhaustible, and eternal. Time is the universe's ultimate, unkillable 'Silent Assassin' that brutally grinds empires into dust. That terrifying, endless 'Maha-kala' is Krishna.
            4. 'Dhataham vishvato-mukhah': The Supreme Lord possesses infinite eyes and faces pointing simultaneously in absolutely every 360-degree direction (Vishvato-mukhah). Even if you hide in the deepest, pitch-black bunker in the galaxy to commit a secret sin, you cannot escape His absolute, flawless 'Cosmic CCTV' surveillance. He sees everything and effortlessly sustains everything.
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            मृत्युः सर्वहरश्चाहमुद्भवश्च भविष्यताम् |
            कीर्तिः श्रीर्वाक्च नारीणां स्मृतिर्मेधा धृतिः क्षमा || ३४ ||
        """.trimIndent(),
        hindi = """
            मैं ही सबका 'सर्वनाश' करने वाली (सब कुछ हर लेने वाली / सर्वहरः) 'मृत्यु' (Death) हूँ; और भविष्य में उत्पन्न होने वाले (पैदा होने वाले / भविष्यताम्) सभी प्राणियों का 'उद्भव' (Origin / जन्म) भी मैं ही हूँ।
            स्त्रियों में मैं कीर्ति (Fame), श्री (Fortune/सौंदर्य), वाक् (Fine Speech / मधुर वाणी), स्मृति (Memory), मेधा (Intelligence / बुद्धि), धृति (Steadfastness / धैर्य), और क्षमा (Forgiveness)—ये सात शक्तियां (गुण) हूँ।
            १. 'मृत्युः सर्वहरः': इंसान अपनी पूरी जिंदगी में अरबों रुपए, बहुत बड़ा नाम और ज़मीन इकट्ठा करता है। लेकिन जब 'मौत' आती है, तो वह उसका 100% बैंक बैलेंस, उसका घर, उसके कपड़े और यहाँ तक कि उसका शरीर भी 'छीन' (हर) लेती है। मौत ब्रह्मांड का सबसे बड़ा 'रीपो-मैन' (Repo-man / छीनने वाला) है। वह भयंकर 'मृत्यु' साक्षात् भगवान हैं।
            २. 'उद्भवश्च भविष्यताम्': अगर मौत सब कुछ खत्म कर देती है, तो दुनिया चलती कैसे है? भगवान कहते हैं कि मौत के तुरंत बाद जो नया 'जन्म' (Creation / उद्भव) होता है, जहाँ से नया फ्यूचर (Future) शुरू होता है, वह 'नई शुरुआत' भी मैं ही हूँ। (यानी भगवान ही डिलीट (Delete) करते हैं और भगवान ही रिस्टार्ट (Restart) करते हैं)।
            ३. 'नारीणां' (स्त्रियों के सात गुण): हिंदू शास्त्रों के अनुसार, ये 7 चीजें अत्यंत ही पवित्र, कोमल और शक्तिशाली 'स्त्रियां' (Goddesses / फेमिनिन एनर्जी) मानी गई हैं।
            जिस इंसान के पास अच्छी 'इज़्ज़त' (कीर्ति) हो, असीम 'धन/सुंदरता' (श्री) हो, जो बहुत मीठा और सच 'बोलता' हो (वाक्), जिसकी 'याददाश्त' (स्मृति) तेज़ हो, जिसका दिमाग बहुत 'शार्प' (मेधा) हो, जो मुसीबत में 'धैर्य' (धृति) रखे, और जो दूसरों की गलती पर 'माफ़' (क्षमा) कर दे... समझ लो कि उस इंसान पर साक्षात् भगवान की ही विशेष कृपा (विभूति) है!
        """.trimIndent(),
        english = """
            I am all-devouring, absolute Death (Mrityuh sarva-harash), and I am the ultimate generating principle and origin of all things yet to be (Udbhavash cha bhavishyatam).
            Among women (or feminine qualities), I am fame (Kirti), fortune and beauty (Shri), fine and perfect speech (Vak), memory (Smriti), high intelligence (Medha), steadfastness/patience (Dhriti), and absolute forgiveness (Kshama).
            1. 'Mrityuh sarva-harash': A highly ignorant mortal spends 80 years ruthlessly hustling, hoarding billions of dollars, purchasing mega-mansions, and building a massive ego. But when the Grim Reaper ('Death') abruptly kicks the door down, it brutally and violently 'Confiscates' (Sarva-harash) 100% of his bank balance, his luxury cars, his family, and even his biological skin. Death is the multiverse's absolute ultimate, undefeated 'Repo-Man'. That terrifying, all-devouring Death is literally God.
            2. 'Udbhavash cha bhavishyatam': If Death aggressively deletes everything, how does the universe continue? The Lord declares that the exact microsecond after death, the explosive 'New Birth' (Udbhava) that generates the entire 'Future' timeline of a new life is also ME. (Meaning: God is the one who presses 'Delete', and God is the one who presses 'Restart').
            3. 'Narinam' (The Seven Feminine Opulences): According to profound Vedic ontology, these 7 phenomenally powerful, subtle cosmic energies are personified as 'Goddesses' (Feminine potencies).
            If a human being possesses untarnished 'Fame' (Kirti), massive 'Wealth/Beauty' (Shri), highly eloquent and persuasive 'Speech' (Vak), photographic 'Memory' (Smriti), razor-sharp 'Intelligence' (Medha), unshakeable 'Patience' (Dhriti) during massive crises, and the divine capacity to 'Forgive' (Kshama) his bitterest enemies... realize immediately that this human is physically carrying the direct, highly concentrated 'Superpowers' (Vibhutis) of the Supreme Lord!
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            बृहत्साम तथा साम्नां गायत्री छन्दसामहम् |
            मासानां मार्गशीर्षोऽहमृतूनां कुसुमाकरः || ३५ ||
        """.trimIndent(),
        hindi = """
            गाए जाने वाले सभी (सामवेद के) मंत्रों में मैं 'बृहत्साम' (भगवान इंद्र की स्तुति का एक विशेष और अत्यंत मधुर गीत) हूँ; और सभी वेदों के छन्दों (Metres / कविताओं के नियमों) में मैं 'गायत्री' छन्द हूँ।
            सभी महीनों (Months) में मैं 'मार्गशीर्ष' (नवंबर-दिसंबर / अगहन का महीना) हूँ; और सभी ऋतुओं (Seasons) में मैं फूलों से लदी हुई 'वसंत ऋतु' (कुसुमाकरः) हूँ।
            १. 'बृहत्साम': सामवेद में बहुत सारे गाने और मंत्र हैं, लेकिन उनमें सबसे ऊँचा, सबसे जटिल (Complex) और सबसे सुंदर 'बृहत्साम' है (जिसे आधी रात को गाया जाता है)। वह मधुर संगीत भगवान की आवाज़ है।
            २. 'गायत्री': संस्कृत के श्लोकों को लिखने के कई तरीके (छन्द) होते हैं। उनमें 'गायत्री' छन्द (जिसमें 24 अक्षर होते हैं) सबसे ज्यादा पवित्र, पावरफुल (Powerful) और आध्यात्मिक है (इसी से 'गायत्री मंत्र' बना है जो आत्मा को शुद्ध करता है)।
            ३. 'मार्गशीर्ष': प्राचीन भारत में नया साल 'मार्गशीर्ष' (नवंबर-दिसंबर) से शुरू होता था। यह वह समय है जब किसानों की फसल (Crop) पूरी तरह पक कर कटने के लिए तैयार हो जाती है। यह 'समृद्धि' (Prosperity) और अनाज के घर आने का सबसे खुशी वाला महीना है, इसलिए यह भगवान का रूप है।
            ४. 'कुसुमाकरः' (वसंत ऋतु / Spring Season): वसंत ऋतु को 'ऋतुओं का राजा' कहा जाता है। इसमें न बहुत ज्यादा गर्मी होती है (ताकि इंसान जले नहीं) और न बहुत ज्यादा सर्दी (ताकि इंसान जमे नहीं)। यह एकदम 'बैलेंस्ड' (Balanced) मौसम होता है जिसमें प्रकृति अपने सबसे सुंदर रूप (नए पत्ते और फूल) में होती है। जो चीज़ प्रकृति में सबसे ज्यादा 'बैलेंस्ड और खूबसूरत' है, वह साक्षात् ईश्वर है।
        """.trimIndent(),
        english = """
            Of the hymns in the Sama Veda I am the highly exquisite Brihat-sama; and of all the poetry and mantras constructed in regulated meters, I am the Gayatri mantra (Gayatri chandasam aham).
            Of all the months of the year I am Margashirsha (November-December); and of all the seasons I am the flower-bearing spring (Rituunam kusumakarah).
            1. 'Brihat-sama': The Sama Veda contains thousands of highly complex, melodious cosmic hymns. But the absolute zenith, the most incredibly intricate, beautiful, and spiritually intoxicating musical arrangement among them is the 'Brihat-sama' (traditionally sung at midnight to praise the divine). That ultimate celestial melody is the voice of God.
            2. 'Gayatri': Vedic mantras are strictly engineered using highly mathematical, rhythmic structures known as 'Chhandas' (Meters). The absolute most powerful, sacred, and spiritually explosive meter is the 'Gayatri' (containing exactly 24 syllables, heavily utilized to construct the legendary, soul-purifying Gayatri Mantra).
            3. 'Margashirsha' (Nov-Dec): In highly ancient agrarian India, the New Year officially commenced in Margashirsha. This is the absolute peak, joyous month when massive agricultural harvests fully mature and crops are brought home. It is the ultimate month of 'Massive Prosperity', abundant food, and celebration, representing the Lord's generous providence.
            4. 'Kusumakarah' (The Spring Season): Spring is universally crowned as the undisputed 'King of all Seasons'. It brutally eradicates the agonizing, freezing torture of Winter, yet completely avoids the scorching, suffocating hellfire of Summer. It is the absolute 'Perfect, Flawless Balance', exploding with breathtaking biological beauty, fresh leaves, and blooming flowers. Whatever is absolutely 'Perfectly Balanced and Beautiful' in nature is a direct physical manifestation of God.
        """.trimIndent()
    ),
    Shloka(
        id = 36,
        sanskrit = """
            द्यूतं छलयतामस्मि तेजस्तेजस्विनामहम् |
            जयोऽस्मि व्यवसायोऽस्मि सत्त्वं सत्त्ववतामहम् || ३६ ||
        """.trimIndent(),
        hindi = """
            मैं सभी छल-कपट (धोखा देने वाली) करने वाली चीज़ों में 'द्यूत' (जुआ / Gambling) हूँ; और सभी तेजस्वी (शानदार) पुरुषों का 'तेज' (चमक / Splendor) मैं हूँ।
            मैं ही जीतने वालों की 'विजय' (Victory) हूँ; मैं ही मेहनत करने वालों का 'व्यवसाय' (दृढ़ निश्चय / Adventure) हूँ; और मैं ही सभी सात्त्विक (सच्चे और अच्छे) पुरुषों का 'सत्त्व' (सच्चाई / Goodness) हूँ।
            यह भगवद्गीता के सबसे 'कंट्रोवर्शियल' (Controversial) और 'माइंड-ब्लोइंग' (Mind-blowing) श्लोकों में से एक है!
            भगवान कहते हैं: "द्यूतं छलयतामस्मि" (दुनिया में जितना भी 'धोखा' है, उसमें सबसे बड़ा धोखा 'जुआ' है, और वह 'जुआ' मैं हूँ!)।
            क्या भगवान जुआरी (Gambler) या धोखेबाज़ हैं? बिल्कुल नहीं!
            भगवान यह बता रहे हैं कि दुनिया की 'बुरी से बुरी' और 'खतरनाक से खतरनाक' चीज़ भी भगवान की ही एनर्जी (Energy) है। जुए (Gambling) में एक ऐसा भयंकर जादू (धोखा) होता है जो राजा युधिष्ठिर जैसे धर्मराज और बड़े-बड़े अरबपतियों का दिमाग हैक (Hack) करके उन्हें सड़क पर ला देता है। इंसान को बर्बाद करने की वह जो अजेय (Unbeatable) 'छल शक्ति' (Power of Illusion) है, वह वास्तव में भगवान की ही 'माया' है।
            २. 'जयोऽस्मि': जब कोई इंसान बहुत मेहनत करके कोई बड़ा 'मैच' (Match) या 'युद्ध' जीतता है, तो वह घमंड करता है कि "मैंने जीता!" भगवान कहते हैं, तुम्हारी वह 'जीत' (Victory) मेरा ही रूप है।
            ३. 'व्यवसायो': किसी इंसान के अंदर जो रात-दिन एक करके रिस्क (Risk/Adventure) लेने और मेहनत करने की 'ज़िद' (Determination) होती है, वह ज़िद भी भगवान ही हैं।
            ४. 'सत्त्वं': और जो इंसान बहुत शरीफ (Honest) और सच्चा होता है, उसकी वह 'सच्चाई' भी भगवान की ही देन है। (भगवान ही सब कुछ हैं, अच्छा भी और बुरा भी)।
        """.trimIndent(),
        english = """
            I am also the gambling of all cheats (Dyutam chalayatam asmi), and I am the blinding splendor of the splendid (Tejas tejasvinam aham).
            I am ultimate victory (Jayo 'smi), I am adventure and resolute determination (Vyavasayo 'smi), and I am the pure strength and absolute goodness of the strong and good (Sattvam sattvavatam aham).
            This is undisputedly one of the most 'Highly Controversial', shocking, and absolute 'Mind-blowing' verses in the entire Bhagavad Gita!
            The Lord drops a terrifying bombshell: "Dyutam chalayatam asmi" (Of all the deceitful, toxic frauds and scams in the universe, the absolute most devastating 'Cheat' is Gambling, and I AM THAT GAMBLING!).
            Wait, is the Supreme Godhead a toxic casino gambler or a fraudster? Absolutely Not!
            The Lord is ruthlessly establishing that even the absolute 'Most Dangerous, Darkest, and Most Toxic' forces in the matrix operate strictly using His borrowed cosmic energy. 'Gambling' possesses such a terrifying, hypnotic, and unbeatable 'Power of Illusion' (Deceit) that it effortlessly hacks the brains of highly righteous emperors (like Yudhishthira) and modern billionaires, violently stripping them naked on the streets. That invincible, terrifying, life-destroying 'Illusionary Power' is literally the manifestation of God's 'Maya'.
            2. 'Jayo 'smi' (I am Victory): When an arrogant athlete or general grinds and wins a massive world championship, his toxic ego screams, "I won this!" The Lord brutally corrects him: The very abstract concept and euphoric reality of 'Victory' is literally ME.
            3. 'Vyavasayo': The absolute titanium, unyielding 'Determination' and adrenaline-fueled courage that drives an entrepreneur or a soldier to take massive, life-threatening 'Risks' (Adventure) is a spark of God.
            4. 'Sattvam': And the flawless, uncorrupted 'Honesty and Purity' (Goodness) existing within a highly righteous saint is simply God operating through him. (God is literally everything—the terrifyingly dangerous and the impeccably pure).
        """.trimIndent()
    ),
    Shloka(
        id = 37,
        sanskrit = """
            वृष्णीनां वासुदेवोऽस्मि पाण्डवानां धनञ्जयः |
            मुनीनामप्यहं व्यासः कवीनामुशना कविः || ३७ ||
        """.trimIndent(),
        hindi = """
            वृष्णि वंश (यादवों) में मैं 'वासुदेव' (स्वयं श्रीकृष्ण) हूँ; पाण्डवों (पाण्डु के पुत्रों) में मैं 'धनंजय' (अर्जुन) हूँ;
            सभी मुनियों (विचारकों/शास्त्रकारों) में मैं महर्षि 'वेदव्यास' हूँ; और महान कवियों (दार्शनिकों) में मैं 'शुक्राचार्य' (उशना कवि) हूँ।
            इस श्लोक में भगवान अपने समय के 'टॉप सेलिब्रिटीज़' (Top Celebrities / महान हस्तियों) को अपनी ही शक्ति (विभूति) बता रहे हैं।
            १. 'वृष्णीनां वासुदेवोऽस्मि': भगवान कहते हैं कि यदुवंश में जो 'कृष्ण' (वासुदेव) पैदा हुए हैं (यानी मैं खुद), वह कोई साधारण इंसान नहीं, बल्कि परब्रह्म का साक्षात् अवतार (Supreme manifestation) है।
            २. 'पाण्डवानां धनञ्जयः': यह सुनकर अर्जुन के रोंगटे खड़े हो गए होंगे! अर्जुन सोच रहे थे कि "मैं भगवान का भक्त हूँ।" लेकिन भगवान कहते हैं, "पांडवों में जो सबसे श्रेष्ठ, अजेय और महान योद्धा 'अर्जुन' (धनंजय) है, वह वास्तव में 'मेरी ही शक्ति' का रूप (विभूति) है!" 
            (यानी हे अर्जुन, तुम्हारे अंदर जो इतनी ताकत है, वह तुम्हारी नहीं, मेरी ही दी हुई है)।
            ३. 'मुनीनामप्यहं व्यासः': दुनिया के सबसे बड़े राइटर (Writer) और थिंकर (Thinker) जिन्होंने महाभारत और चारों वेद लिखे (महर्षि वेदव्यास), उनका वह 'सुप्रीम ज्ञान' (Supreme knowledge) साक्षात् ईश्वर की ही शक्ति है।
            ४. 'कवीनामुशना': 'कवि' का मतलब सिर्फ कविता लिखने वाला नहीं, बल्कि वह दूरदर्शी (Visionary) जो बहुत आगे की सोच सकता हो। राक्षसों के गुरु 'शुक्राचार्य' (उशना) ब्रह्मांड के सबसे महान कूटनीतिज्ञ (Diplomat) और बुद्धिमान व्यक्ति माने जाते थे। उनकी वह अद्भुत और जादुई 'बुद्धि' भी साक्षात् ईश्वर का ही रूप है।
        """.trimIndent(),
        english = """
            Of the descendants of Vrishni I am Vasudeva (Krishna Himself); and of the Pandavas I am Arjuna (Dhananjaya).
            Of all the great, contemplative sages I am Vyasa, and among all great thinkers and visionary poets I am Ushana (Shukracharya).
            In this spectacular verse, the Lord officially claims the absolute 'Top Celebrities', ultimate heroes, and elite geniuses of that specific cosmic timeline as the direct manifestations (Vibhutis) of His own power.
            1. 'Vrishninam Vasudevo 'smi': The Lord officially verifies His own Avatar. He declares that the specific entity named 'Krishna' (Vasudeva) born into the Yadu dynasty is absolutely not an ordinary biological prince, but the direct, 100% concentrated, Supreme Manifestation of the Godhead.
            2. 'Pandavanam Dhananjayah': This specific line must have sent violent, electric shockwaves down Arjuna's spine! Arjuna humbly considered himself merely a tiny servant of God. But the Lord drops a massive bomb: "Among the five Pandavas, the absolute greatest, undefeated, apex warrior 'Arjuna' (Dhananjaya) is literally a direct physical manifestation of MY own combat power!"
            (Meaning: O Arjuna, that terrifying, world-conquering archery skill you possess is absolutely not your own ego's achievement; it is literally My software running inside you).
            3. 'Muninam apy aham Vyasah': The absolute greatest 'Writer and Thinker' in universal history, Maharishi Vyasa (who compiled the massive Vedas and the Mahabharata), possesses a 'Supreme Intellect' that is exactly God Himself operating through him.
            4. 'Kavinam Ushana': A 'Kavi' here is not a cheap rhyme-writer; it means a terrifyingly intelligent, futuristic 'Visionary'. Shukracharya (Ushana), the guru of the demons, was universally recognized as the absolute greatest, most cunning diplomat and geopolitical mastermind in the cosmos. That highly dangerous, magical 'Intellect' is a direct spark of God.
        """.trimIndent()
    ),
    Shloka(
        id = 38,
        sanskrit = """
            दण्डो दमयतामस्मि नीतिरस्मि जिगीषताम् |
            मौनं चैवास्मि गुह्यानां ज्ञानं ज्ञानवतामहम् || ३८ ||
        """.trimIndent(),
        hindi = """
            मैं दमन करने वालों (सज़ा देने वालों / Rulers) का 'दण्ड' (सज़ा देने की ताकत / Rod of chastisement) हूँ; और विजय चाहने वालों (जीतने की इच्छा रखने वालों) की मैं 'नीति' (सही रणनीति / Morality/Statecraft) हूँ।
            मैं सभी गुप्त (रहस्यमयी / Secrets) चीज़ों को छुपाने वाला 'मौन' (चुप्पी / Silence) हूँ; और मैं ही सभी ज्ञानी पुरुषों का 'ज्ञान' (Wisdom) हूँ।
            १. 'दण्ड': पुलिस, सेना या जज (Judge) जब किसी अपराधी को कंट्रोल (Control) करते हैं, तो उनके पास जो 'पावर' (Power / दण्ड) होती है, वह पावर कोई साधारण चीज़ नहीं है। समाज में लॉ एंड ऑर्डर (Law and order) बनाए रखने के लिए अपराधियों को दी जाने वाली सज़ा (दण्ड) साक्षात् ईश्वर का ही रूप है।
            २. 'नीति' (Strategy / Morality): अगर आप दुनिया में जीत (Victory) हासिल करना चाहते हैं, तो केवल ताकत से काम नहीं चलता। आपको 'नीति' (सही चाल, डिप्लोमेसी और नैतिकता) चाहिए। वह जीतने वाली अचूक 'नीति' (Master-plan) भगवान ही हैं।
            ३. 'मौन' (Silence): यह बहुत ही गहरी बात है। दुनिया का सबसे बड़ा 'रहस्य' (Secret) क्या है? और रहस्य को छुपाने का सबसे पावरफुल (Powerful) तरीका क्या है? "चुप रहना" (मौन)। 'मौन' के अंदर इतनी असीम ताकत (Energy) होती है कि वह इंसान को अंदर से बहुत रहस्यमयी और शक्तिशाली बना देता है। वह 'चुप्पी' (Silence) भगवान की ही शक्ति है।
            ४. 'ज्ञान': और जिन लोगों के पास दुनिया या अध्यात्म का कोई भी सच्चा 'ज्ञान' (Wisdom) है, वह ज्ञान इंसान का अपना नहीं, बल्कि साक्षात् भगवान का ही प्रकाश है।
        """.trimIndent(),
        english = """
            Among all means of suppressing lawlessness and dispensing punishment, I am the rod of chastisement (Dandah); and among those who seek ultimate victory, I am morality and statecraft (Nitir).
            Of all heavily guarded secrets I am absolute silence (Maunam), and I am the pure wisdom and knowledge of the wise (Jnanam jnanavatam aham).
            1. 'Dandah' (The Rod of Punishment): When the Supreme Court, military generals, or heavily armed police forces aggressively suppress highly dangerous criminals to maintain societal sanity, the terrifying, raw, authoritative 'Power of Punishment' (Danda) they wield is not ordinary. The brutal, necessary force of 'Law and Order' is a direct, physical manifestation of God.
            2. 'Nitir' (Statecraft / Strategy): If a leader or general desperately seeks to completely conquer and achieve 'Victory', raw, mindless brute strength is mathematically guaranteed to fail. He requires 'Niti' (Flawless, elite Diplomacy, Strategy, and Righteous Morality). That absolute, unbeatable 'Master-Plan' is God Himself.
            3. 'Maunam' (Absolute Silence): This is an incredibly profound, chillingly psychological revelation. What is the absolute greatest 'Secret' in the universe? And what is the most terrifyingly powerful, unhackable vault to store a secret? "Absolute Silence" (Mauna). 'Silence' generates such a staggering, highly intimidating psychological 'Aura' around a human being that it makes him utterly unpredictable and deeply mystical. That deafening, terrifying 'Silence' is a direct cosmic power of God.
            4. 'Jnanam': And for any elite scholars or sages who possess genuine, absolute 'Wisdom' regarding the cosmos, that knowledge is absolutely not their own biological brain's property; it is the blazing, radiant light of God temporarily shining through them.
        """.trimIndent()
    ),
    Shloka(
        id = 39,
        sanskrit = """
            यच्चापि सर्वभूतानां बीजं तदहमर्जुन |
            न तदस्ति विना यत्स्यान्मया भूतं चराचरम् || ३९ ||
        """.trimIndent(),
        hindi = """
            और हे अर्जुन! इस ब्रह्मांड के संपूर्ण प्राणियों (सर्वभूतानां) का जो 'मूल कारण' या 'बीज' (Seed / Origin) है, वह बीज भी केवल 'मैं' ही हूँ।
            इस पूरी सृष्टि में ऐसा कोई भी चर (चलने वाला / Moving) या अचर (न चलने वाला / Non-moving) प्राणी या वस्तु नहीं है, जो 'मेरे बिना' (विना मया) अस्तित्व (Exist) में रह सके।
            यह श्लोक भगवान की 'विभूतियों' (Opulences) की लिस्ट का 'मास्टर-कन्क्लूज़न' (Master-Conclusion / अंतिम सार) है।
            भगवान श्रीकृष्ण ने पिछले 20 श्लोकों में दुनिया की हर बड़ी चीज़ (सूरज, हिमालय, शेर, सागर, गरुड़) का नाम लेकर कहा कि "इनका बेस्ट (Best) वर्ज़न (Version) मैं हूँ।" 
            लेकिन अर्जुन (या हम) सोच सकते हैं कि "जिन चीजों का नाम लिस्ट में नहीं आया (जैसे कुर्सी, टेबल, या कोई छोटा कीड़ा), क्या वो भगवान नहीं हैं?"
            भगवान इस श्लोक में वह सारी 'लिमिट' (Limit) तोड़ देते हैं!
            वे कहते हैं कि लिस्ट तो मैं सिर्फ तुम्हें समझाने के लिए दे रहा था। असली सच्चाई तो यह है कि "यच्चापि सर्वभूतानां बीजं"—इस दुनिया की 'हर एक चीज़' का (चाहे वह अच्छी हो या बुरी, बड़ी हो या छोटी) जो 'मूल बीज' (Starting Material) है, वह साक्षात् मैं ही हूँ।
            "न तदस्ति विना यत्स्यान्मया"—इस ब्रह्मांड में ऐसी कोई चीज़ 'एग्ज़िस्ट' (Exist) ही नहीं करती जिसमें मैं न हूँ। अगर किसी चीज़ में से 'कृष्ण' (परमेश्वर की शक्ति) को माइनस (-) कर दिया जाए, तो वह चीज़ तुरंत गायब (Zero/Nothing) हो जाएगी।
            अर्थात्, इस दुनिया में 'कृष्ण के अलावा' और कुछ है ही नहीं! (Everything is God).
        """.trimIndent(),
        english = """
            Furthermore, O Arjuna, I am the absolute original generating seed of all existences and living entities (Sarva-bhutanam bijam tad aham).
            There is absolutely no being—whether moving (Charam) or non-moving (Acharam)—that can possibly exist or survive even for a microsecond without Me (Na tad asti vina yat syan maya).
            This spectacular verse drops the absolute, ultimate 'Master-Conclusion' to the massive, mind-bending list of God's 'Vibhutis' (Cosmic Opulences).
            Over the last 20 verses, Lord Sri Krishna meticulously name-dropped the absolute most massive, elite entities in the universe (the Sun, the Himalayas, the Lion, the Ocean, the Shark) and declared, "The 'Best' version of all these categories is ME."
            But a highly logical human might foolishly wonder: "What about the millions of boring, tiny things that didn't make the VIP List (like a plastic chair, a dust particle, or a microscopic germ)? Are they NOT God?"
            The Lord violently smashes all physical boundaries and 'Limits' in this specific verse!
            He clarifies: The VIP list was merely a tiny trailer customized specifically for your human comprehension. The brutal, absolute reality is: "Yac chapi sarva-bhutanam bijam"—I am the absolute original 'Seed Material' (Base Quantum Particle) of 'EVERY SINGLE THING' in existence (whether magnificent or disgusting, colossal or microscopic).
            "Na tad asti vina yat syan maya"—Absolutely NOTHING in this entire multiverse can even 'Exist' without Me. If you mathematically minus (-) 'Krishna' (God's energy) from any object, that object instantly violently collapses into absolute 'Zero' (Non-existence).
            Meaning: There is literally NOTHING in this universe EXCEPT Krishna! (Everything IS God).
        """.trimIndent()
    ),
    Shloka(
        id = 40,
        sanskrit = """
            नान्तोऽस्ति मम दिव्यानां विभूतीनां परन्तप |
            एष तूद्देशतः प्रोक्तो विभूतेर्विस्तरो मया || ४० ||
        """.trimIndent(),
        hindi = """
            हे परन्तप (शत्रुओं को तपाने वाले अर्जुन)! मेरी इन 'दिव्य विभूतियों' (अलौकिक शक्तियों और ऐश्वर्यों) का कोई भी 'अंत' (End / लिमिट) नहीं है (नान्तोऽस्ति)।
            मैंने अपनी इन अनंत विभूतियों का यह जो विस्तार (Details) तुम्हारे सामने कहा है, वह तो केवल एक छोटा सा 'संकेत' (उद्देशतः / Brief example / Trailer) मात्र ही है!
            भगवान श्रीकृष्ण यहाँ अर्जुन को (और मानव जाति को) एक बहुत ही भारी 'रियालिटी चेक' (Reality Check) दे रहे हैं।
            अर्जुन ने 16वें श्लोक में भगवान से डिमांड (Demand) की थी कि "मुझे अपनी सारी शक्तियों के बारे में 'विस्तार' (Detail में) बताइए।" भगवान ने 20 श्लोकों तक लगातार अपनी सबसे महान शक्तियों की लिस्ट भी गिनाई।
            लेकिन अब भगवान मुस्कुराते हुए कहते हैं: "अर्जुन, तुम सोच रहे होगे कि मेरी लिस्ट खत्म हो गई? लेकिन मेरी शक्तियों का कोई 'अंत' (नान्तोऽस्ति) है ही नहीं!"
            भगवान इंसान के छोटे से दिमाग (Brain) की लिमिट (Limit) बताते हैं। अगर भगवान 24 घंटे, करोड़ों साल तक भी अपनी महानता गिनाते रहें, तो भी वे खत्म नहीं होंगी।
            "एष तूद्देशतः प्रोक्तो"—मैंने तो बस तुम्हें एक छोटा सा 'ट्रेलर' (Trailer) या 'इशारा' (Hint) दिया है, ताकि तुम्हें समझ आ जाए कि जब दुनिया की सबसे सुंदर और ताकतवर चीज़ें केवल मेरा एक अंश हैं, तो मैं (सुप्रीम गॉड) खुद कितना महान हूँगा!
            ईश्वर की शक्तियों को कोई इंसान कभी पूरी तरह से नहीं जान सकता, उसके आगे केवल 'सरेंडर' (Surrender / घुटने टेकना) ही किया जा सकता है।
        """.trimIndent(),
        english = """
            O mighty conqueror of enemies (Parantapa)! There is absolutely no end and no limit to My divine manifestations and cosmic opulences (Nanto 'sti mama divyanam vibhutinam).
            What I have explicitly spoken to you here is merely a tiny, microscopic indication or a brief hint (Esha tūddheshatah prokto) of My infinite, boundless opulences.
            Lord Sri Krishna is dropping a staggeringly heavy 'Reality Check' right onto Arjuna's (and humanity's) fragile, biological brain here.
            In Verse 16, Arjuna aggressively demanded, "Please tell me absolutely EVERYTHING about Your cosmic superpowers in 100% exhaustive detail!" And the Lord generously delivered a massive, 20-verse list of the most terrifyingly powerful entities in the matrix.
            But now, the Lord gently smiles and brutally crashes Arjuna's illusion: "Arjuna, do you foolishly think My list is finally over? My cosmic opulences literally have ZERO 'End' (Nanto 'sti)!"
            The Lord accurately highlights the pathetic bandwidth limitations of the human brain. Even if the Supreme Creator continuously lectured 24/7 for a billion years detailing His powers, He would still not cover even 1% of His infinite inventory.
            "Esha tūddheshatah prokto"—What I just delivered to you was absolutely nothing but a pathetic, microscopic 'Teaser Trailer' (a mere Hint). I only highlighted these few things so your tiny brain could comprehend: If the absolute most majestic, terrifyingly beautiful, and massive objects in the universe are merely a tiny spark of My energy, imagine how staggeringly infinite 'I' (The Supreme Godhead) must actually be!
            A mortal human can never, ever mathematically fully 'Know' God's powers; he can only drop to his knees and 'Surrender' to them.
        """.trimIndent()
    ),
    Shloka(
        id = 41,
        sanskrit = """
            यद्यद्विभूतिमत्सत्त्वं श्रीमदूर्जितमेव वा |
            तत्तदेवावगच्छ त्वं मम तेजोंऽशसम्भवम् || ४१ ||
        """.trimIndent(),
        hindi = """
            इस संसार में जो-जो भी वस्तु या प्राणी अत्यंत ऐश्वर्यवान (विभूतिमत् / महान और शक्तिशाली), कान्तियुक्त (श्रीमद् / अत्यंत सुंदर और ऐश्वर्यशाली), और प्रभावशील (ऊर्जितम् / अत्यंत ताकतवर) है...
            तुम उस-उस हर एक श्रेष्ठ वस्तु को, मेरे ही 'तेज' (शक्ति) के एक बहुत ही छोटे से अंश (एक छोटी सी चिंगारी / अंशसम्भवम्) से ही पैदा हुआ (बना हुआ) समझो (अवगच्छ)।
            यह पूरी भगवद्गीता के सबसे शानदार, 'आई-ओपनिंग' (Eye-opening) और 'रूल-मेकिंग' (Rule-making) श्लोकों में से एक है!
            भगवान श्रीकृष्ण यहाँ दुनिया की हर 'खूबसूरत और पावरफुल' चीज़ को जज (Judge) करने का एक 'यूनिवर्सल फॉर्मूला' (Universal Formula) दे रहे हैं।
            हम इंसान किसी बहुत सुंदर बॉलीवुड एक्टर (Actor), किसी अरबपति बिज़नेसमैन (Billionaire), किसी बहुत शानदार स्पोर्ट्सकार (Sports car), या किसी बहुत विशाल पहाड़ को देखकर 'पागल' (Hypnotize) हो जाते हैं। हम उस चीज़ या उस इंसान की पूजा (Worship/Fan) करने लगते हैं।
            भगवान हमारे उस 'अज्ञान' (Illusion) को एक झापड़ मार कर तोड़ते हैं!
            वे कहते हैं: "हे अर्जुन! तुम्हें दुनिया में जहाँ कहीं भी कोई ऐसी चीज़ दिखे जो बहुत 'पॉपुलर' (विभूतिमत्), बहुत 'सुंदर और अमीर' (श्रीमद्), या बहुत 'पावरफुल' (ऊर्जितम्) हो...
            तो उस इंसान या उस चीज़ की तारीफ मत करना! यह 100% पक्का समझ लेना कि उस चीज़ के अंदर जो भी 'ग्लैमर या अट्रैक्शन' (Glamour/Attraction) है, वह मेरा ही (ईश्वर का) एक बहुत छोटा सा 'स्पार्क' (Spark / चिंगारी) है!"
            अगर केवल एक 'चिंगारी' (Spark) इंसान को इतना पागल कर सकती है, तो ज़रा सोचो कि वह असली 'आग' (परमेश्वर कृष्ण) कितनी ज़्यादा सुंदर और पावरफुल होगी! इसलिए इंसान को उस चिंगारी के पीछे भागने के बजाय सीधे उस 'आग' (ईश्वर) से प्यार करना चाहिए।
        """.trimIndent(),
        english = """
            Know definitively that absolutely all beautiful, glorious, and mighty creations (Yad yad vibhutimat sattvam shrimad urjitam eva va)...
            spring entirely and strictly from but a single, microscopic spark of My blinding splendor (Tat tad evavagaccha tvam mama tejo-'msha-sambhavam).
            This is undeniably one of the absolute most spectacularly 'Eye-Opening', paradigm-shifting, and ultimate 'Rule-Making' verses in the entire Bhagavad Gita!
            Lord Sri Krishna is downloading the ultimate 'Universal Formula' for how a human being should perfectly judge and interact with every single 'Beautiful and Powerful' object in the matrix.
            Ignorant mortals are instantly violently 'Hypnotized' whenever they see an incredibly stunning Hollywood celebrity, an arrogant multi-billionaire, a sleek 300-mph hypercar, or a massive, breathtaking mountain. We instantly become pathetic 'Fans' and blindly worship that physical object or person.
            The Lord violently slaps away this pathetic 'Illusion' (Maya)!
            He declares: "O Arjuna! Whenever and wherever in this universe you spot any entity that is intensely 'Famous and Glorious' (Vibhutimat), staggeringly 'Beautiful, Wealthy, and Luxurious' (Shrimad), or aggressively 'Powerful and Unstoppable' (Urjitam)...
            absolutely DO NOT foolishly worship or praise that biological human or dead object! You must 100% definitively understand (Avagaccha) that the blinding 'Glamour, Talent, and Magnetic Attraction' radiating from that object is merely a microscopic, tiny 'SPARK' (Tejo-'msha) borrowed directly from MY infinite energy!"
            If a mere, microscopic tiny 'Spark' of God's energy is enough to violently hypnotize and drive the entire human race crazy, just imagine how unfathomably, terrifyingly beautiful and powerful the actual 'Roaring Fire' (The Supreme Lord Krishna Himself) must be! Therefore, a highly intelligent human stops chasing cheap, temporary 'Sparks' and directly falls in love with the ultimate 'Fire' (God).
        """.trimIndent()
    ),
    Shloka(
        id = 42,
        sanskrit = """
            अथवा बहुनैतेन किं ज्ञातेन तवार्जुन |
            विष्टभ्याहमिदं कृत्स्नमेकांशेन स्थितो जगत् || ४२ ||
        """.trimIndent(),
        hindi = """
            अथवा (लेकिन), हे अर्जुन! इन बहुत सी अलग-अलग बातों (विभूतियों की लंबी लिस्ट) को विस्तार से जानने की तुम्हें क्या आवश्यकता है? (बहुनैतेन किं ज्ञातेन)।
            (तुम केवल इतना समझ लो कि) मैं इस पूरे के पूरे ब्रह्मांड (कृत्स्नम् इदं जगत्) को केवल अपने एक छोटे से अंश (Fraction / एकांशेन) के द्वारा धारण करके (विष्टभ्य) स्थित हूँ!
            यह दसवें अध्याय (विभूति योग) का अत्यंत ही राजसी, आक्रामक और 'माइक्र-ड्रॉप' (Mic-drop / Grand Finale) श्लोक है!
            भगवान श्रीकृष्ण 20 श्लोकों तक लगातार अपनी महानता (मैं सूर्य हूँ, मैं हिमालय हूँ) गिना रहे थे। लेकिन अचानक, वे रुक जाते हैं और अर्जुन की तरफ देखकर मुस्कुराते हुए इस पूरी बातचीत (List) को एक झटके में ख़ारिज (Dismiss) कर देते हैं!
            भगवान कहते हैं: "हे अर्जुन! छोड़ो ये सब! तुम ये एक-एक करके मेरी शक्तियों की लिस्ट जानकर क्या करोगे? इससे क्या फायदा?"
            फिर भगवान एक ऐसा 'यूनिवर्सल सच' (Universal Truth) बोलते हैं जो इंसान के दिमाग की नसें फाड़ देता है:
            "तुम बस इतना जान लो कि यह जो पूरी की पूरी गैलेक्सी (Galaxy), करोड़ों तारे, ब्रह्मांड और तुम हो (कृत्स्नम् जगत्)... यह पूरा का पूरा ब्रह्मांड मेरी कुल ताकत का सिर्फ 'एक छोटा सा अंश' (एकांशेन / A tiny fraction) है! मैंने अपने एक पैर के अंगूठे (या एक सिंगल स्पार्क) से इस पूरे ब्रह्मांड को हवा में टिका रखा है (विष्टभ्य)!"
            अगर यह पूरा ब्रह्मांड भगवान की शक्ति का सिर्फ 1% (एक अंश) है, तो भगवान का बाकी 99% (आध्यात्मिक दुनिया / वैकुंठ) कितना विशाल और डरावना होगा? 
            यह श्लोक साबित करता है कि ईश्वर 'अनंत' (Infinite) है और यह भौतिक ब्रह्मांड उस अनंत के सामने एक धूल के कण से भी छोटा है। 
            यहाँ यह महान और ईश्वरीय अध्याय पूर्ण होता है।
        """.trimIndent(),
        english = """
            But what absolutely is the need for you to know all this detailed, extensive, and massive knowledge, O Arjuna (Athava bahunaitena kim jnatena tavarjuna)?
            (Simply understand this one absolute truth:) With merely a single, microscopic fragment of Myself (Ekamshena), I entirely pervade, support, and sustain this entire colossal universe (Vishtabhyaham idam kritsnam sthito jagat)!
            This is the absolute most majestic, aggressively awe-inspiring, and staggering 'MIC-DROP' (Grand Finale) verse of the Tenth Chapter (Vibhuti Yoga)!
            For 20 consecutive verses, Lord Sri Krishna painstakingly listed His staggeringly massive cosmic opulences (I am the Sun, I am the Himalayas, I am Time). But suddenly, He stops, looks at Arjuna, and with a cosmic smile, brutally dismisses the entire exhaustive List in one stroke!
            The Lord essentially says: "O Arjuna! Forget all this! Why are you pathetically bothering your tiny human brain trying to calculate and memorize this endless, detailed inventory of My powers? What is the point?"
            Then, the Supreme Lord detonates an absolute 'Universal Truth' so unfathomably massive it completely short-circuits human comprehension:
            "Just permanently burn this one absolute fact into your brain: This entire infinite, colossal multiverse (Kritsnam Jagat)—with its billions of galaxies, black holes, and trillions of living entities—is completely sustained, held up, and powered purely by just ONE TINY, MICROSCOPIC FRACTION (Ekamshena) of My total energy!"
            If this entire terrifying, mind-bending material universe represents merely 1% (a single fraction) of God's total power, can the human brain even begin to hallucinate how staggeringly massive and terrifyingly beautiful the remaining 99% of God's spiritual energy (Vaikuntha) must be?
            This legendary verse proves that God is truly 'Infinite', and this entire physical universe is less than a speck of dust floating in front of His absolute majesty.
            Here flawlessly concludes the Tenth Chapter, The Opulence of the Absolute.
        """.trimIndent()
    )
)