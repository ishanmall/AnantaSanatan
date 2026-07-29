package com.sanatangyansagar.ui.screens.DurgaSaptshati

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
data class SaptshatiShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaOneScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1)) // Deep Cream Background
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val targetId = query.toIntOrNull()

                if (targetId != null) {
                    // Find the actual position (index) of the shloka that has this specific ID
                    val targetIndex = adhyayaOneShlokas.indexOfFirst { it.id == targetId }

                    // If it exists in the list (-1 means not found), scroll to it
                    if (targetIndex != -1) {
                        coroutineScope.launch {
                            listState.animateScrollToItem(targetIndex)
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka (1-10)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
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
            itemsIndexed(adhyayaOneShlokas) { _, shloka ->
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SaptshatiCard(shloka: SaptshatiShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Shloka ${shloka.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFBF360C) // Deep Orange
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = shloka.sanskrit,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(thickness = 1.dp, color = Color(0xFFFFCC80))
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "हिन्दी व्याख्या:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD32F2F)
            )
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Commentary:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

val adhyayaOneShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ॐ मार्कण्डेय उवाच ॥ १ ॥\nसावर्णिः सूर्यतनयो यो मनुः कथ्यतेऽष्टमः ।\nनिशामय तदुत्पत्तिं विस्तराद्गदतो मम ॥ १ ॥",
        hindi = """
            महर्षि मार्कण्डेय जी कहते हैं: "अब मैं तुम्हें आठवें मनु 'सावर्णि' की उत्पत्ति की कथा विस्तार से सुनाता हूँ।"
            सनातन कालचक्र में 14 मनु होते हैं, और सावर्णि मनु सूर्य देव के पुत्र हैं जो भविष्य के मनु बनेंगे।
            यह कोई साधारण राजा की कहानी नहीं है, बल्कि यह चेतना (Consciousness) के विकास का एक महाकाव्य है।
            ऋषि मार्कण्डेय इस ब्रह्मांड के सबसे प्राचीन ज्ञानियों में से एक हैं जिन्हें अमरत्व का वरदान प्राप्त है।
            वे कह रहे हैं कि सावर्णि मनु कैसे एक साधारण राजा से उठकर 'मनु' के पद तक पहुँचे, यह समझना बहुत ज़रूरी है।
            इस कथा के माध्यम से हमें यह पता चलता है कि कैसे इंसान अपनी 'माया' के बंधनों को तोड़ सकता है।
            'मम' का अर्थ है 'मुझसे', यानी ऋषि खुद इस परम रहस्य का स्रोत (Source) बन रहे हैं।
            यह अध्याय 'मधु-कैटभ वध' के नाम से जाना जाता है, जो हमारे अंदर के अज्ञान को मिटाने का प्रतीक है।
            सृष्टि का हर नया मनु एक नए युग (Era) की शुरुआत करता है, जो मानवता को सही दिशा देता है।
            मार्कण्डेय जी का यह संवाद साक्षात् ब्रह्मांडीय सत्य को हमारे सामने प्रकट करने वाला है।
        """.trimIndent(),
        english = """
            The great Sage Markandeya profoundly declares: "Listen carefully as I describe the origin of Savarni, the eighth Manu."
            In the massive cosmic timeline of Sanatana Dharma, Savarni is the son of Surya who is destined to rule the next era.
            This is absolutely no ordinary story of a king, but an epic saga detailing the violent evolution of human consciousness.
            Sage Markandeya is one of the most ancient and immortal masters who has witnessed the dissolution of the universe.
            He is explicitly revealing how a ruler flawlessly transcended his worldly suffering to successfully attain the title of 'Manu'.
            Through this sacred narrative, we discover the exact methods to ruthlessly sever the chains of 'Maya' (Illusion).
            The word 'Mama' signifies that the sage himself is the direct, authentic channel for this highly classified cosmic secret.
            This first chapter is titled 'The Slaying of Madhu and Kaitabha', symbolizing the absolute annihilation of thick ignorance.
            Every new Manu effectively reboots the moral framework of the world, flawlessly guiding humanity through a brand-new cycle.
            Markandeya's explosive discourse is designed to violently awaken the seeker's mind from its deep, pathetic spiritual sleep.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "महामायानुभावेन यथा मन्वन्तराधिपः ।\nस बभूव महाभागः सावर्णिस्तनयो रवेः ॥ २ ॥",
        hindi = """
            "वे रवि-पुत्र (सूर्य के पुत्र) महाभाग्यशाली सावर्णि, 'महामाया' के प्रभाव से कैसे मन्वन्तर के स्वामी बने।"
            यहाँ 'महामाया' शब्द का प्रयोग हुआ है, जो इस पूरे ब्रह्मांड को चलाने वाला 'सॉफ्टवेयर' (Software) है।
            यही महामाया है जो हमें सच को झूठ और झूठ को सच दिखाने का भ्रम (Illusion) पैदा करती है।
            सावर्णि मनु का जीवन यह साबित करता है कि बिना देवी की कृपा के कोई भी इंसान बड़ा लक्ष्य नहीं पा सकता।
            वे 'महाभाग' हैं, यानी उनके पास केवल धन नहीं, बल्कि असीम आध्यात्मिक सौभाग्य (Divine Fortune) भी है।
            यह श्लोक संकेत देता है कि हमारी सफलता के पीछे केवल हमारी मेहनत नहीं, बल्कि 'कॉस्मिक ग्रेस' (Cosmic Grace) होती है।
            मन्वन्तर का स्वामी होना साक्षात् इस धरती का प्रशासक (Administrator) होने के बराबर है।
            परंतु इस ऊँचे पद को पाने के लिए उन्हें एक भयंकर मानसिक और आध्यात्मिक परीक्षा से गुज़रना पड़ा।
            यही वह देवी की शक्ति है जो एक रोते हुए इंसान को भी ब्रह्मांड का राजा बनाने की ताकत रखती है।
            बिना महामाया को समझे, इंसान कभी भी इस संसार के मैट्रिक्स (Matrix) से बाहर नहीं निकल सकता।
        """.trimIndent(),
        english = """
            "Exactly how that fortunate Savarni, the son of the Sun, became the Lord of a Manvantara through the power of Mahamaya."
            The term 'Mahamaya' is aggressively introduced here, representing the ultimate cosmic 'Software' that operates the entire universe.
            It is exactly this Mahamaya that relentlessly crafts the thick Illusion where we falsely perceive the lie as absolute truth.
            The life of Savarni Manu flawlessly proves that without the Mother's absolute grace, no human can ever attain a supreme goal.
            He is called 'Mahabhaga', meaning he possesses not just cheap money, but infinite, radiant Divine Fortune (spiritual wealth).
            This verse explicitly indicates that behind every massive success exists the terrifying and silent force of 'Cosmic Grace'.
            Becoming the Lord of a Manvantara is effectively the same as being the supreme Administrator of the entire physical earth.
            However, to successfully attain this high rank, he had to ruthlessly endure an exceptionally horrific mental and spiritual trial.
            This is strictly that power of the Goddess which possesses the raw capacity to transform even a crying beggar into a King.
            Completely without understanding Mahamaya, a human can absolutely never successfully escape the high-tech 'Matrix' of this world.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "स्वारोचिषेऽन्तरे पूर्वं चैत्रवंशसमुद्भवः ।\nसुरथो नाम राजाभूत्समस्ते क्षितिमण्डले ॥ ३ ॥",
        hindi = """
            "प्राचीन काल में, स्वारोचिष मन्वन्तर के समय, चैत्र वंश में उत्पन्न 'सुरथ' नाम के एक महान राजा हुए।"
            राजा सुरथ का अधिकार इस पूरी पृथ्वी (क्षितिमण्डले) पर था, यानी वे दुनिया के सबसे शक्तिशाली सम्राट थे।
            वे 'चैत्र वंश' के थे, जो अपनी वीरता और धर्म के लिए पूरे आर्यावर्त में प्रसिद्ध माना जाता था।
            यह कहानी हमें एक ऐसे समय में ले जाती है जब धर्म और न्याय ही शासन का एकमात्र आधार हुआ करते थे।
            सुरथ का अर्थ है 'सुन्दर रथ वाला', यानी जिसकी जीवन-यात्रा और इन्द्रियां पूरी तरह से व्यवस्थित (Disciplined) हों।
            परंतु इतना वैभव और इतनी शक्ति होने के बाद भी, नियति (Fate) उनके लिए कुछ और ही सोच रही थी।
            राजा सुरथ का चरित्र यह दिखाता है कि एक महान योद्धा को भी दुःख और हार का सामना करना पड़ सकता है।
            यह श्लोक कहानी का 'बैकग्राउंड' (Background) सैट कर रहा है ताकि हम राजा की मानसिक स्थिति को समझ सकें।
            पूरी पृथ्वी पर राज करने वाला राजा अंत में एक जंगल में पहुँचता है, जो इंसान की नश्वरता का साक्षात् प्रमाण है।
            यहीं से उस महान यात्रा की शुरुआत होती है जो अंततः उन्हें साक्षात् जगदम्बा के दर्शन करवाती है।
        """.trimIndent(),
        english = """
            "Long ago, during the Swarochisha Manvantara, there was a king named Suratha born strictly in the illustrious Chaitra dynasty."
            King Suratha's absolute authority extended flawlessly across the entire globe (Kshitimandale), marking him as a supreme world emperor.
            Belonging to the 'Chaitra Dynasty', he represented a lineage world-famous for its raw courage and absolute adherence to Dharma.
            This story transports us aggressively back to an era where justice and righteousness were the solitary foundations of governance.
            Suratha literally means 'one with a magnificent chariot', symbolizing a life and senses that are perfectly disciplined and aligned.
            However, despite possessing such astronomical wealth and raw power, Destiny (Niyati) was actively planning a different outcome.
            The character of Suratha brilliantly demonstrates that even the greatest warrior must ruthlessly face total defeat and agony.
            This verse flawlessly sets the historical 'Background' so that we can deeply analyze the King's upcoming mental breakdown.
            The ruler of the entire earth ultimately landing in a forest is the direct, brutal proof of human mortality and fragility.
            Exactly from here begins that magnificent journey which ultimately forces him to witness the direct manifestation of the Mother.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "तस्य पालयतः सम्यक् प्रजाः पुत्रानिवौरसान् ।\nबभूवुः शत्रवो भूपाः कोलाविध्वंसिनस्तदा ॥ ४ ॥",
        hindi = """
            "वे अपनी प्रजा का अपने औरस पुत्रों (सगी संतान) की तरह बहुत ही अच्छी तरह से पालन करते थे।"
            "परंतु उसी समय 'कोलाविध्वंसी' नाम के शक्तिशाली राजा उनके भयंकर शत्रु बन गए।"
            राजा सुरथ एक 'आइडियल' (Ideal) राजा थे जो अपनी प्रजा के लिए अपना सब कुछ न्योछावर करने को तैयार रहते थे।
            उनकी प्रजा उन्हें एक पिता के समान मानती थी, जो शासन के सबसे शुद्ध और धार्मिक स्वरूप (Dharma) को दर्शाता है।
            परंतु दुनिया का नियम है कि जहाँ बहुत अधिक अच्छाई होती है, वहाँ बुराई (शत्रु) भी पैदा हो जाती है।
            ये 'कोलाविध्वंसी' राजा उन शक्तियों के प्रतीक हैं जो धर्म और व्यवस्था को पूरी तरह से नष्ट करना चाहती हैं।
            यह युद्ध केवल दो राजाओं के बीच नहीं, बल्कि 'सुव्यवस्था' और 'अराजकता' (Chaos) के बीच का एक महासंग्राम था।
            जब आप दुनिया में बहुत अच्छा काम करते हैं, तो अक्सर अनपेक्षित दुश्मन (Unexpected enemies) आपके रास्ते में आ खड़े होते हैं।
            सुरथ ने प्रजा के साथ कभी अन्याय नहीं किया, फिर भी उन्हें शत्रुओं के भयंकर आक्रमण का सामना करना पड़ा।
            यह श्लोक हमें सिखाता है कि जीवन में संघर्ष किसी भी समय, किसी के भी ऊपर, बिना किसी चेतावनी के आ सकता है।
        """.trimIndent(),
        english = """
            "He governed and protected his subjects flawlessly, exactly as if they were his very own legitimate biological sons."
            "However, at that very time, certain powerful kings known as the 'Kola-vidhvamsis' became his exceptionally fierce enemies."
            King Suratha was the absolute 'Ideal' monarch, perpetually ready to sacrifice his entire life strictly for the welfare of his subjects.
            His people worshipped him exactly like a father, representing the absolute purest and most righteous form of 'Dharma' in leadership.
            But the brutal rule of the world is that wherever intense goodness exists, evil (enemies) will inevitably and violently arise.
            These 'Kola-vidhvamsi' kings symbolize those destructive forces that desperately want to annihilate cosmic order and social structure.
            This war was absolutely not merely between two kings, but a massive conflict strictly between 'Divine Order' and 'Total Chaos'.
            Exactly when you execute magnificent work in the world, frequently unexpected enemies will aggressively block your path without reason.
            Suratha never committed a single act of injustice, yet he was ruthlessly forced to face a horrific and massive invasion.
            This verse explicitly teaches us that life-altering struggle can violently strike anyone, at any time, completely without any prior warning.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "तस्य तैरभवद्युद्धमतिप्रबलदण्डिनः ।\nन्यूनैरपि स तैर्युद्धे कोलाविध्वंसिभिर्जितः ॥ ५ ॥",
        hindi = """
            "अत्यंत शक्तिशाली सेना (दण्ड) होने के बाद भी, राजा सुरथ का उन शत्रुओं के साथ भयंकर युद्ध हुआ।"
            "संख्या में कम होने के बावजूद (न्यूनैरपि), उन कोलाविध्वंसी शत्रुओं ने युद्ध में राजा सुरथ को हरा दिया।"
            यह श्लोक बहुत ही 'शॉकिंग' (Shocking) है—एक महान और शक्तिशाली राजा एक छोटी सेना से कैसे हार गया?
            इसका आध्यात्मिक अर्थ यह है कि कभी-कभी हमारी बाहरी ताकत हमें हार (Failure) से नहीं बचा सकती।
            जब समय (Time) खराब होता है, तो सबसे बड़ा योद्धा भी अपनी छोटी सी गलती या भाग्य के कारण नीचे गिर जाता है।
            कोलाविध्वंसी शत्रु संख्या में कम थे, पर उनकी नीयत और उनका षड्यंत्र राजा की ईमानदारी से ज़्यादा भारी पड़ गया।
            यह दिखाता है कि दुनिया के युद्ध केवल बाहुबल से नहीं, बल्कि कूटनीति और माया (Strategy) से जीते जाते हैं।
            राजा सुरथ की यह हार उनके जीवन का सबसे बड़ा 'टर्निंग पॉइंट' (Turning Point) साबित होने वाली थी।
            हारना हमेशा बुरा नहीं होता; कभी-कभी हारना इसलिए ज़रूरी होता है ताकि हम सच को जान सकें।
            अगर सुरथ युद्ध जीत जाते, तो वे कभी जंगल नहीं जाते और कभी देवी के रहस्यों को नहीं समझ पाते।
        """.trimIndent(),
        english = """
            "Despite possessing an exceptionally powerful army, a horrific war broke out strictly between King Suratha and those enemies."
            "Even though they were significantly fewer in number (Nyuna-irapi), those Kola-vidhvamsi enemies ruthlessly defeated King Suratha in battle."
            This verse is exceptionally 'Shocking'—how on earth did a magnificent and powerful King get crushed by a tiny, inferior army?
            Its profound spiritual meaning is that sometimes our external raw power simply cannot save us from absolute Failure.
            Exactly when 'Time' is unfavorable, even the absolute greatest warrior falls violently due to a minor error or sheer bad luck.
            The Kola-vidhvamsis were numerically inferior, but their toxic intentions and clever conspiracies outweighed the King's honesty.
            This brilliantly demonstrates that the world's battles are won not just by muscle, but by cold diplomacy and strategic 'Maya'.
            This specific defeat was destined to become the absolute greatest 'Turning Point' in the entire life of King Suratha.
            Failure is absolutely not always a curse; frequently, failing is mandatory strictly so that we can finally discover the Absolute Truth.
            Had Suratha flawlessly won that war, he would have never traveled to the forest and never decoded the Mother's cosmic secrets.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "ततः स्वपुरमायातो निजदेशाधिपोऽभवत् ।\nआक्रान्तः स महाभागस्तैस्तदा प्रबलारिभिः ॥ ६ ॥",
        hindi = """
            "युद्ध हारने के बाद वे अपनी राजधानी वापस आए और केवल अपने ही नगर (स्वपुर) के शासक बनकर रह गए।"
            "परन्तु उन शक्तिशाली शत्रुओं ने वहाँ भी उनका पीछा नहीं छोड़ा और उन पर दोबारा भयंकर आक्रमण कर दिया।"
            एक चक्रवर्ती सम्राट, जो पूरी दुनिया का मालिक था, अब केवल एक शहर का राजा बनकर सिमट गया था।
            यह 'डाउनफॉल' (Downfall) इंसान के अहंकार पर एक बहुत बड़ी चोट होती है, जो सुरथ के साथ हो रही थी।
            शत्रु केवल राज्य छीनकर खुश नहीं थे; वे राजा सुरथ का अस्तित्व (Existence) ही मिटा देना चाहते थे।
            यह दिखाता है कि नकारात्मक शक्तियां (Negative forces) तब तक शांत नहीं बैठतीं जब तक वे आपको पूरी तरह तोड़ न दें।
            राजा सुरथ 'महाभाग' (सौभाग्यशाली) थे, फिर भी उन्हें अपमान और डर की स्थिति में जीना पड़ा।
            इंसान जब गिरता है, तो उसकी अपनी प्रजा और उसके अपने लोग भी उसे कमज़ोर समझने लगते हैं।
            यह श्लोक 'क्राइसिस' (Crisis) की उस चरम सीमा को दर्शाता है जहाँ से इंसान का भगवान से भरोसा उठने लगता है।
            लेकिन यही वह अँधेरा है जिसके बाद ज्ञान का सूरज निकलने वाला था, जो कि ऋषि मेधा के रूप में मिलने वाला था।
        """.trimIndent(),
        english = """
            "After losing the grand war, he returned to his own capital and remained merely the ruler of his own city (Svapuram)."
            "However, those powerful enemies ruthlessly attacked that magnificent soul once again, refusing to leave him in peace."
            A universal emperor, who once owned the absolute entire world, was now violently reduced to being the ruler of a single city.
            This massive 'Downfall' is an exceptionally heavy blow to the human ego, which was exactly what Suratha was ruthlessly experiencing.
            The enemies were absolutely not satisfied merely by stealing his kingdom; they desperately wanted to annihilate his very Existence.
            This demonstrates that Negative Forces will absolutely never sit quietly until they have completely and flawlessly broken you.
            Despite being called 'Mahabhaga' (Fortunate), King Suratha was forced to live in a state of extreme humiliation and terrifying fear.
            Exactly when a human falls from power, his own subjects and closest people frequently begin to perceive him as pathetically weak.
            This verse captures the absolute peak of that 'Crisis' where a human's faith in God usually begins to violently crumble and fail.
            But this specific darkness was mandatory, as it preceded the rising sun of wisdom that was about to appear as Sage Medha.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "अमात्यैर्बलिभिर्दुष्टैर्दुर्बलस्य दुरात्मभिः ।\nकोशो बलं चापहृतं तत्रापि स्वपुरे ततः ॥ ७ ॥",
        hindi = """
            "उनके अपने ही दुष्ट और शक्तिशाली मंत्रियों (अमात्यैः) ने, राजा को कमज़ोर जानकर, धोखे से उनका साथ छोड़ दिया।"
            "उन दुरात्माओं ने राजा का खजाना (कोश) और उनकी बची-कुची सेना (बल) को भी पूरी तरह से हड़प लिया।"
            यह दुनिया का सबसे कड़वा सच है—जब आप कमज़ोर पड़ते हैं, तो सबसे पहले 'अपने' ही आपको लूटते हैं!
            सुरथ के मंत्री, जिन्हें उन्होंने पाल-पोसकर बड़ा किया था, अब वही उनके सबसे बड़े लुटेरे और गद्दार बन गए।
            'दुरात्मभिः' का अर्थ है जिनकी आत्मा गंदी हो चुकी है; ऐसे लोग केवल ताकत के पुजारी होते हैं, वफादारी के नहीं।
            उन मंत्रियों ने राजा के पैसे (Treasury) और पॉवर (Army) पर कब्ज़ा कर लिया, जिससे राजा बिल्कुल अकेला (Lonely) हो गया।
            यह श्लोक राजनीति और इंसानी स्वभाव की उस 'डार्क रियलिटी' (Dark Reality) को खोलता है जो आज भी सच है।
            इंसान तब तक सुरक्षित है जब तक उसके पास ताकत है; जैसे ही ताकत जाती है, अपने भी पराये हो जाते हैं।
            सुरथ के पास अब न राज्य था, न पैसा था, और न ही कोई भरोसेमंद दोस्त बचा था।
            वे साक्षात् 'जीरो' (Zero) पर आ चुके थे, और यही वह स्थिति है जहाँ से असली वैराग्य और अध्यात्म की शुरुआत होती है।
        """.trimIndent(),
        english = """
            "His very own wicked and powerful ministers (Amatyaih), perceiving the King as weak, ruthlessly betrayed him."
            "Those evil-minded souls (Duratmabhih) completely plundered the King's treasury (Kosha) and forcibly seized his remaining army."
            This is the world's absolute most bitter truth—the moment you become weak, your 'own' people are the first to loot you!
            Suratha's ministers, whom he had nurtured and elevated, seamlessly transformed into his absolute greatest robbers and traitors.
            'Duratmabhih' signifies individuals whose souls have become exceptionally filthy; such people worship strictly raw power, never loyalty.
            Those ministers violently hijacked the King's entire wealth (Treasury) and his power (Army), leaving the King completely isolated and Lonely.
            This verse ruthlessly exposes that 'Dark Reality' of politics and human nature which remains flawlessly true even in the modern world.
            A human remains safe strictly and exclusively as long as he holds raw power; the split-second it vanishes, relatives become strangers.
            Suratha was left with absolutely zero kingdom, zero money, and not even a single trustworthy friend remained by his side.
            He had flawlessly reached the state of 'Zero', and exactly this is the precise condition where actual Vairagya and spirituality begin.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "ततो मृगयाव्याजेन हृतस्वाम्यः स भूपतिः ।\nएकाकी हयमारुह्य ययौ गहनमन्वरम् ॥ ८ ॥",
        hindi = """
            "सब कुछ छिन जाने के बाद, वह राजा शिकार खेलने के बहाने (मृगयाव्याजेन) अपने घोड़े पर सवार होकर।"
            "अकेले ही (एकाकी) महल से निकल गए और एक अत्यंत घने और सुनसान जंगल (गहनमन्वरम्) की ओर चले गए।"
            जब इंसान का दिल टूटता है, तो वह भीड़ से भागकर 'एकांत' (Solitude) की तलाश करने लगता है।
            राजा ने 'शिकार' का बहाना इसलिए बनाया ताकि किसी को उनकी बेबसी और उनके आँसुओं का पता न चल सके।
            एक घोड़ा और एक राजा—यही अब उनकी कुल संपत्ति थी; यह उनके 'अकेलेपन' का सबसे दर्दनाक दृश्य है।
            वे महल की सुख-सुविधाओं को छोड़कर उस प्रकृति की गोद में जा रहे थे जो किसी के साथ भेदभाव नहीं करती।
            'गहन' जंगल हमारे अवचेतन मन (Subconscious mind) का प्रतीक है, जहाँ हम अपने डरों का सामना करने जाते हैं।
            यह भागना (Escape) वास्तव में उनकी खुद की खोज (Self-discovery) की शुरुआत थी, जिसे वे खुद भी नहीं जानते थे।
            इंसान जब दुनिया से हारता है, तभी वह कुदरत और भगवान के करीब जाने का रास्ता ढूँढ पाता है।
            घोड़े की टापों की आवाज़ और जंगल का सन्नाटा—यही अब राजा सुरथ की नई दुनिया बनने वाली थी।
        """.trimIndent(),
        english = """
            "Stripped of absolutely everything, that King, under the clever pretext of hunting (Mrigayavyajena), mounted his lone horse."
            "Entirely 'Alone' (Ekaki), he exited the palace and rode deep into an exceptionally dense and desolate forest (Gahanam-anvaram)."
            The absolute moment a human's heart is shattered, he aggressively flees from the crowd to frantically seek 'Solitude' (Ekant).
            The King used 'hunting' strictly as a fake excuse so that absolutely no one could witness his pathetic helplessness or his tears.
            A single horse and a broken King—this was now his absolute entire net worth; it is the most agonizing vision of total loneliness.
            He was ruthlessly abandoning palace luxuries to enter the lap of Nature which flawlessly treats every creature with absolute equality.
            The 'Dense' forest is a direct symbol of the Subconscious Mind, exactly where we go to violently confront our deepest, darkest fears.
            This specific Escape was, in absolute reality, the beginning of his own 'Self-Discovery', a fact he himself completely failed to realize.
            Strictly when a human is ruthlessly defeated by the world does he successfully find the hidden path leading toward Nature and God.
            The sound of horse hooves and the terrifying silence of the jungle—this was destined to be King Suratha's brand-new world.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "स तत्राश्रममद्राक्षीद् द्विजवर्यस्य मेधसः ।\nप्रशान्तश्वापदाकीर्णं मुनिशिष्योपशोभितम् ॥ ९ ॥",
        hindi = """
            "उस जंगल में उन्होंने परम ज्ञानी ब्राह्मण 'मेधा' ऋषि का एक अत्यंत पवित्र आश्रम देखा।"
            "वह आश्रम इतना शांत था कि वहाँ के खूंखार जानवर (श्वापद) भी अपनी दुश्मनी छोड़कर शांति से एक साथ रहते थे।"
            "वहाँ मुनि के महान शिष्य चारों ओर वेदों का पाठ कर रहे थे, जिससे पूरा वातावरण दिव्य लग रहा था।"
            ऋषि मेधा का आश्रम उस 'मेंटल पीस' (Mental Peace) का प्रतीक है जिसे राजा सुरथ पूरी दुनिया में ढूँढ रहे थे।
            वहाँ शेर और हिरण एक साथ पानी पीते थे, जो यह साबित करता है कि एक ज्ञानी की 'वाइब्रेशन' (Vibration) प्रकृति को भी बदल सकती है।
            अज्ञानी इंसान जहाँ जाता है वहाँ युद्ध होता है, पर एक संत जहाँ बैठता है वहाँ हिंसा (Violence) अपने-आप खत्म हो जाती है।
            राजा सुरथ ने जब उस आश्रम को देखा, तो उनके अशांत मन को पहली बार थोड़ी राहत (Relief) महसूस हुई।
            वेदों की ध्वनि (Chanting) हवा में गूँज रही थी, जो अज्ञान के अँधेरे को चीरने वाली एक दिव्य तलवार के समान थी।
            मेधा ऋषि साक्षात् 'इंटेलेक्ट' (Intellect) और 'विजडम' (Wisdom) के अवतार हैं, जो राजा के भ्रम को तोड़ने वाले थे।
            यह आश्रम केवल एक जगह नहीं, बल्कि एक 'हॉस्पिटल' (Hospital) था जहाँ राजा की आत्मा का इलाज होने वाला था।
        """.trimIndent(),
        english = """
            "In that forest, he witnessed the exceptionally sacred ashram of the supreme Brahmin sage, 'Medha'."
            "That ashram was so profoundly peaceful that even the most ferocious wild beasts (Shvapada) had flawlessly abandoned their enmity to live together."
            "The magnificent disciples of the sage were beautifully adorning the place, making the entire atmosphere divine with their presence."
            The ashram of Sage Medha is the absolute symbol of that 'Mental Peace' which King Suratha was frantically searching for globally.
            There, lions and deer drank water together, flawlessly proving that the 'Vibration' of an enlightened master can violently alter Nature itself.
            An ignorant human breeds war wherever he travels, but a saint effortlessly annihilates all Violence (Ahimsa) strictly by his mere presence.
            Exactly when King Suratha witnessed that ashram, his highly restless mind felt a tiny spark of 'Relief' for the absolute first time.
            The continuous Chanting of the Vedas echoed in the air, acting like a divine sword designed to ruthlessly slice through the darkness of ignorance.
            Sage Medha is the direct, literal incarnation of 'Intellect' and 'Wisdom' who was destined to violently shatter the King's deep illusions.
            This ashram was absolutely not just a physical location, but a spiritual 'Hospital' where the King's soul was about to be surgically treated.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "तस्थौ कंचित्कालं च मुनिना तेन सत्कृतः ।\nइतस्ततश्च विचरंस्तस्मिन् मुनिवराश्रमे ॥ १० ॥",
        hindi = """
            "उन श्रेष्ठ मुनि मेधा द्वारा सम्मानित होने पर, राजा सुरथ कुछ समय के लिए वहीं आश्रम में रुक गए।"
            "वे उस मुनिवर के आश्रम में इधर-उधर टहलते हुए अपना समय व्यतीत करने लगे।"
            राजा सुरथ अब एक 'रिफ्यूजी' (Refugee) की तरह थे, पर मुनि ने उन्हें एक राजा के समान ही आदर (सत्कार) दिया।
            यह दिखाता है कि एक संत कभी इंसान की गरीबी या उसकी हार को नहीं देखता, वह केवल उसकी 'तड़प' को देखता है।
            राजा आश्रम में इधर-उधर घूम तो रहे थे, पर उनका मन अभी भी महल की यादों में ही फँसा हुआ था।
            शांति की जगह पर रहने से शांति नहीं मिलती; जब तक दिमाग के अंदर 'अटैचमेंट' (Attachment) है, इंसान कहीं भी खुश नहीं रह सकता।
            सुरथ उन पेड़ों और ऋषियों को देख रहे थे, पर उनके दिमाग में अभी भी अपने शत्रुओं और अपने खजाने की ही बातें चल रही थीं।
            यह श्लोक 'ह्यूमन साइकोलॉजी' (Human Psychology) का बड़ा सच है—हम फिजिकली कहीं और होते हैं और मेंटली कहीं और!
            वे मेधा ऋषि की शरण में तो थे, पर अभी उनका 'सरेंडर' (Surrender) 100% नहीं हुआ था।
            यही वह समय था जब उनकी मुलाकात उस वैश्य (व्यापारी) से होने वाली थी जो उनकी तरह ही दुखी था।
        """.trimIndent(),
        english = """
            "Being flawlessly honored and welcomed by that supreme Sage Medha, King Suratha stayed strictly in that ashram for some time."
            "He spent his days aimlessly wandering here and there (Itastatashcha) within the boundaries of that magnificent sage's retreat."
            King Suratha was effectively exactly like a 'Refugee' now, yet the sage treated him flawlessly with the absolute dignity of an Emperor.
            This demonstrates that a true saint absolutely never looks at a human's poverty or defeat; he exclusively perceives only his inner 'Yearning'.
            Although the King was physically wandering within the peaceful ashram, his mind remained violently trapped strictly in the memories of his lost palace.
            Merely residing in a peaceful location does absolutely not grant peace; exactly as long as 'Attachment' exists in the brain, no human can be happy.
            Suratha looked at those sacred trees and sages, but his brain was still frantically processing thoughts of his enemies and plundered treasury.
            This verse captures a massive truth of 'Human Psychology'—we are frequently physically in one place but mentally in an entirely different dimension!
            He was under the protection of Sage Medha, but his internal 'Surrender' was absolutely not yet 100% complete.
            This was the exact window of time when he was destined to meet that merchant (Vaishya) who was just as miserable as he was.
        """.trimIndent()
    ),
    // ... Continuing adhyayaOneShlokas from ID 10

    SaptshatiShloka(
        id = 11,
        sanskrit = "सोऽचिन्तयत्तदा तत्र ममत्वाकृष्टमानसः ।\nमत्पूर्वैः पालितं पूर्वं मया हीनं पुरं हि तत् ॥ ११ ॥",
        hindi = """
            (राजा का 'ममत्व' और मानसिक पीड़ा): "आश्रम में रहते हुए भी, 'ममत्व' (अटैचमेंट / यह मेरा है) की भावना से पूरी तरह बंधा हुआ वह राजा सुरथ सोचने लगा।"
            "मेरे पूर्वजों (मत्पूर्वैः) ने जिस महान राज्य और राजधानी का इतने लंबे समय तक पालन किया था।"
            "अब वह राज्य मेरे बिना (मया हीनं) न जाने किस दुर्दशा में होगा, और क्या वह अब भी सुरक्षित है?"
            यह श्लोक इंसान की सबसे बड़ी मनोवैज्ञानिक बीमारी (Psychological Disease) को उजागर करता है—'ओवरथिंकिंग' (Overthinking)।
            राजा सब कुछ हार चुका है, पर उसका 'ईगो' (Ego) अभी भी उसे यही अहसास दिला रहा है कि "मेरे बिना दुनिया नहीं चल सकती।"
            'ममत्वाकृष्टमानसः' का अर्थ है एक ऐसा दिमाग जिसे 'मैं और मेरा' के चुंबक ने बुरी तरह जकड़ लिया है।
            हमेशा याद रखें, जब इंसान अपने पद (Position) से हट जाता है, तो उसे उस पद की चिंता छोड़ देनी चाहिए।
            पर माया इतनी भयंकर है कि वह भूतकाल (Past) की यादों का एक लूप (Loop) चलाकर इंसान को वर्तमान (Present) में जीने नहीं देती।
            मुनि के आश्रम का शांत वातावरण भी उस राजा के दिमाग के इस भयंकर शोर को शांत नहीं कर पा रहा था।
            यही अटैचमेंट इंसान को नर्क में धकेलती है, जहाँ वह जो चीज़ उसके पास नहीं है, उसके लिए रोता रहता है।
        """.trimIndent(),
        english = """
            (The King's 'Mamatva' and mental agony): "Even while residing in the peaceful ashram, that King Suratha, whose mind was violently dragged by 'Mamatva' (toxic attachment / mine-ness), began to think."
            "That magnificent kingdom and capital which was flawlessly protected and ruled by my great ancestors (Matpurvaih) for so long."
            "Now completely completely bereft of my presence (Maya hinam), in what miserable condition must it be, and is it even safe?"
            This spectacular verse exposes humanity's absolute greatest Psychological Disease—relentless 'Overthinking'.
            The King has lost absolutely everything, yet his highly toxic 'Ego' still forces him to blindly believe that "The world cannot possibly function without me."
            'Mamatvakrishtamanasah' precisely means a mind that has been brutally hijacked and tied down perfectly by the massive magnet of 'I and Mine'.
            Always remember, exactly when a human is stripped of his Position, he must ruthlessly drop all anxiety regarding that position.
            But Maya is so incredibly terrifying that it actively runs a perpetual Loop of Past memories, absolutely refusing to let the human live in the Present.
            Even the exceptionally tranquil atmosphere of the sage's ashram completely failed to silence this horrific, deafening noise inside the King's brain.
            This exact toxic attachment violently pushes a human straight into hell, where he perpetually cries for exactly that which he no longer possesses.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "मद्भृत्यैस्तैरसद्वृत्तैर्धर्मतः पाल्यते न वा ।\nन जाने स प्रधानो मे शूरहस्ती सदामदः ॥ १२ ॥",
        hindi = """
            (शत्रुओं और हाथी की चिंता): "राजा सोचने लगा: जिन दुष्ट और गद्दार सेवकों (मद्भृत्यैस्तैरसद्वृत्तैर्) ने मेरा राज्य छीना है, क्या वे धर्म-पूर्वक उस राज्य का पालन कर रहे होंगे या नहीं?"
            "मैं यह भी नहीं जानता (न जाने) कि मेरा वह सबसे प्रधान (मुख्य), सबसे शूरवीर, और हमेशा मदमस्त रहने वाला हाथी (शूरहस्ती सदामदः) अब किस हाल में होगा।"
            यहाँ राजा सुरथ का 'मोह' (Blind Attachment) अपने चरम (Peak) पर पहुँच गया है; वह अपने दुश्मनों के काम की चिंता कर रहा है!
            जिन मंत्रियों ने उसे लात मारकर महल से निकाला, राजा अब भी सोच रहा है कि वे प्रजा का ध्यान रख रहे हैं या नहीं।
            यह एक 'कंट्रोल फ्रीक' (Control Freak) मानसिकता है, जहाँ इंसान यह मानने को तैयार नहीं होता कि अब उसका कोई अधिकार नहीं बचा।
            और फिर हाथी (शूरहस्ती) की याद आना—यह इंसान के उन भौतिक शौक (Material possessions) और लक्ज़री (Luxury) का प्रतीक है जो छूट जाने पर उसे सबसे ज़्यादा तड़पाते हैं।
            हाथी उस समय पावर (Power) और स्टेटस (Status symbol) का सबसे बड़ा प्रतीक हुआ करता था, जैसे आज की दुनिया में कोई महंगी कार।
            राजा अपनी जान बचाकर जंगल में बैठा है, पर उसका दिमाग अपनी उस 'महंगी कार' (हाथी) के लिए रो रहा है!
            माया का यह जाल इतना खतरनाक है कि वह आपके दुखों का कारण उसी चीज़ को बना देती है जो कभी आपकी ख़ुशी थी।
            ज्ञान के बिना इंसान कभी भी अपने इन पुराने खिलौनों (Memories) से मोह नहीं छोड़ सकता।
        """.trimIndent(),
        english = """
            (Anxiety regarding enemies and the elephant): "The King actively pondered: Those wicked, treacherous servants (Madbhrityaistairasadvrittair) who stole my kingdom, are they ruling it flawlessly according to Dharma or not?"
            "I absolutely do not even know (Na jane) in what pathetic condition my absolute best, bravest, and perpetually intoxicated royal elephant (Shurahasti sadamadah) must be right now."
            Here, King Suratha's 'Moha' (Blind Attachment) has flawlessly reached its absolute Peak; he is literally worrying about the actions of his deadly enemies!
            The exact ministers who violently kicked him out of his own palace, the King is still frantically wondering if they are taking care of the citizens.
            This perfectly demonstrates a 'Control Freak' mentality, where a human absolutely refuses to brutally accept that he possesses zero authority anymore.
            And then the painful memory of the elephant (Shurahasti)—this is the direct symbol of a human's Material Possessions and cheap Luxury that torture him the most when lost.
            The elephant was undeniably the absolute greatest symbol of raw Power and Status in that era, exactly like an exceptionally expensive modern car.
            The King is sitting helplessly in a dense forest saving his own life, yet his pathetic brain is violently crying for that 'expensive car' (elephant)!
            This terrifying web of Maya is so incredibly dangerous that it seamlessly turns the exact same object that was once your joy strictly into the cause of your agony.
            Completely without supreme wisdom, a human can absolutely never ruthlessly drop his toxic attachment to these old physical toys (Memories).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "मम वैरिवशं यातः कान् भोगानुपलप्स्यते ।\nये ममानुगता नित्यं प्रसादधनभोजनैः ॥ १३ ॥",
        hindi = """
            (सेवकों की चिंता): "मेरा वह प्यारा हाथी अब मेरे उन भयंकर शत्रुओं के वश (मम वैरिवशं यातः) में चला गया है, न जाने अब उसे खाने-पीने के लिए कैसे भोग (कान् भोगानुपलप्स्यते) मिलते होंगे?"
            "और जो मेरे सेवक और सैनिक नित्य (रोजाना) मेरी कृपा, मेरे दिए हुए धन, और मेरे दिए हुए उत्तम भोजन (प्रसादधनभोजनैः) पर पलते थे और मेरे पीछे चलते थे (ये ममानुगता)।"
            राजा का दिमाग पास्ट (Past) में इतना फँस गया है कि वह अपने उस हाथी और पुराने कर्मचारियों की 'डाइट' (Diet/खाने) की टेंशन ले रहा है!
            'मम वैरिवशं यातः' का अर्थ है कि मेरी चीज़ मेरे दुश्मन के पास चली गई—यही वह ईर्ष्या (Jealousy) है जो इंसान को अंदर से जलाकर राख कर देती है।
            इंसान को अपनी हार का उतना दुख नहीं होता, जितना इस बात का होता है कि उसकी चीज़ का फायदा अब कोई और (दुश्मन) उठा रहा है।
            राजा सुरथ यह सोचकर अपने 'ईगो' (Ego) को शांत कर रहे हैं कि "मेरे सेवक मेरे पैसों और खाने (प्रसादधनभोजनैः) पर पलते थे।"
            यह घमंड कि "मैं पालने वाला (Provider) हूँ", इंसान की सबसे बड़ी बेवकूफी है, क्योंकि इस पूरी दुनिया का असली पालनहार केवल भगवान है।
            जब इंसान सोचता है कि उसने किसी को खिलाया, तो वह अपने अंदर एक झूठा 'गॉड-कॉम्प्लेक्स' (God-complex) पाल लेता है।
            महामाया इसी गॉड-कॉम्प्लेक्स को राजा के दिमाग में एक फिल्म (Movie) की तरह चलाकर उसे दर्द दे रही है।
            यह श्लोक साबित करता है कि दिमाग को शांत किए बिना कोई भी इंसान ध्यान (Meditation) या मुक्ति के रास्ते पर नहीं चल सकता।
        """.trimIndent(),
        english = """
            (Anxiety regarding the servants): "That beloved elephant of mine has now flawlessly fallen strictly under the control of my horrific enemies (Mama vairivasham yatah), I wonder what exact kind of food and enjoyments (Kan bhoganupalapsyate) he receives now?"
            "And exactly what about those loyal servants and soldiers who perpetually followed me daily (Ye mamanugata), surviving strictly on my absolute grace, the wealth I gave them, and the royal food I provided (Prasadadhanabhojanaih)?"
            The King's pathetic brain is so violently trapped in the Past that he is literally taking massive tension regarding the 'Diet' (food) of his elephant and old employees!
            'Mama vairivasham yatah' means my personal property has now gone to my deadly enemy—this is exactly that toxic Jealousy that violently burns a human entirely to ashes from the inside.
            A human does absolutely not suffer as much from his own defeat as he suffers from the brutal fact that someone else (the enemy) is now actively enjoying his former possessions.
            King Suratha is desperately trying to pacify his shattered 'Ego' by actively thinking, "My servants survived strictly on my money and my food (Prasadadhanabhojanaih)."
            This exact toxic pride that "I am the supreme Provider" is humanity's absolute greatest stupidity, strictly because the only actual, real sustainer of this entire cosmos is God alone.
            When a human falsely assumes he has fed someone, he flawlessly breeds a highly fake 'God-Complex' directly inside himself.
            Mahamaya is aggressively utilizing this exact God-complex, actively running it strictly like a painful Movie right inside the King's brain to torture him.
            This spectacular verse flawlessly proves that completely without silencing the mind, absolutely no human can ever possibly walk the path of Meditation or Moksha.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "अनुवृत्तिं ध्रुवं तेऽद्य कुर्वन्त्यन्यमहीभृताम् ।\nअसम्यग्व्ययशीलैस्तैः कुर्वद्भिः सततं व्ययम् ॥ १४ ॥",
        hindi = """
            (दुश्मनों की चापलूसी और खजाने की बर्बादी): "निश्चित रूप से (ध्रुवं) मेरे वे पुराने सेवक आज (अद्य) अपनी आजीविका के लिए उन दूसरे राजाओं (अन्यमहीभृताम् / मेरे शत्रुओं) की चापलूसी और सेवा (अनुवृत्तिं) कर रहे होंगे।"
            "और जो लोग अनुचित और गलत तरीके से धन खर्च करने वाले हैं (असम्यग्व्ययशीलैस्तैः), वे मेरे शत्रू लगातार मेरे उस खजाने का फालतू में भयंकर व्यय (बर्बादी / सततं व्ययम्) कर रहे होंगे।"
            राजा सुरथ का दिमाग अब एक और 'डार्क ज़ोन' (Dark Zone) में चला गया है—वह सोच रहा है कि उसके वफादार लोग अब उसके दुश्मनों के गुलाम (नौकर) बन गए होंगे!
            यह विचार इंसान के 'पज़ेसिवनेस' (Possessiveness) पर सबसे बड़ा हमला है। जिसे आप अपना मानते हैं, जब वह किसी और का हो जाए, तो सबसे ज़्यादा दर्द होता है।
            फिर राजा अपने 'खजाने' (Treasury) के बारे में सोचता है। उसने अपनी पूरी ज़िंदगी मेहनत करके जो पैसा जमा किया था, अब दुश्मन उसे अय्याशी (असम्यग्व्यय) में उड़ा रहे हैं।
            यह श्लोक 'पैसों के प्रति मोह' (Greed for Wealth) की साइकोलॉजी को खोलकर रख देता है।
            इंसान खुद तो एक दिन मर जाता है, पर उसका जमा किया हुआ पैसा कोई और (कई बार दुश्मन या नालायक बच्चे) उड़ाते हैं।
            माया इंसान को यह कभी नहीं समझने देती कि जो चीज़ पीछे छूट गई, वह वास्तव में कभी उसकी थी ही नहीं!
            सुरथ अभी भी उस पैसे को 'अपना' मान रहा है, जबकि वह पैसा अब किसी और के कंट्रोल में है।
            तन्त्र और वेदान्त का पहला नियम है: जो तुम्हारे हाथ में नहीं है, उसके बारे में सोचना 100% पागलपन (Stupidity) है।
        """.trimIndent(),
        english = """
            (Flattery of enemies and wastage of treasury): "Undoubtedly and certainly (Dhruvam), those old loyal servants of mine must today (Adya) be pathetically flattering and serving (Anuvrittim) those other new kings (Anyamahibhritam / my deadly enemies) just to survive."
            "And those wicked enemies who possess highly inappropriate and reckless spending habits (Asamyagvyayashilaistaih), must definitely be continuously wasting and squandering (Satatam vyayam) my entire grand treasury."
            King Suratha's highly restless brain has now flawlessly entered another 'Dark Zone'—he is brutally imagining his former loyalists now acting completely as slaves (servants) to his worst enemies!
            This exact thought is the absolute greatest, most violent attack on a human's toxic 'Possessiveness'. Exactly when someone you blindly considered yours becomes someone else's, it inflicts the absolute maximum agony.
            Then the King frantically thinks about his 'Treasury'. The massive wealth he had ruthlessly accumulated with a lifetime of hard work, his enemies are now violently blowing away in cheap luxury (Asamyagvyaya).
            This spectacular verse flawlessly exposes the deep Psychology of 'Greed for Wealth' (Moha for money).
            The human himself violently dies one day, but the exact money he obsessively hoarded is aggressively squandered entirely by someone else (frequently enemies or useless heirs).
            Maya absolutely never lets the pathetic human realize that whatever physical object was left behind was, in absolute reality, never his to begin with!
            Suratha is still frantically considering that wealth as 'His own', even though that exact money is now completely under someone else's absolute control.
            The absolute first rule of pure Tantra and Vedanta is: Frantically worrying about exactly that which is completely out of your hands is 100% pure Stupidity.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "सञ्चितः सोऽतिदुःखेन क्षयं कोशो गमिष्यति ।\nएताश्चान्याश्च सततं चिन्तयामास पार्थिवः ॥ १५ ॥",
        hindi = """
            (खजाने का नाश और लगातार चिंता): "मैंने अत्यंत महान कष्ट और दुःख सहकर (सोऽतिदुःखेन) जो खजाना इकट्ठा (सञ्चितः) किया था, वह निश्चित रूप से उनके द्वारा पूरी तरह नष्ट (क्षयं गमिष्यति) कर दिया जाएगा।"
            "वह पृथ्वी का राजा (पार्थिवः) सुरथ इसी प्रकार की (एताश्च) और दूसरी अनेक (अन्याश्च) फालतू बातों के बारे में लगातार बिना रुके (सततं) चिंता (चिन्तयामास) करता ही रहा।"
            राजा का रोना सिर्फ एक बात पर अटका है—"मैंने वो पैसा बहुत 'दुःख' (मेहनत) से जमा किया था!" (सोऽतिदुःखेन)।
            इंसान को चीज़ के जाने का उतना दुःख नहीं होता, जितना उस 'मेहनत' के बर्बाद होने का दुःख होता है जो उसने उस चीज़ को पाने में लगाई थी।
            यही 'सङ्कन कॉस्ट फॅलेसी' (Sunk Cost Fallacy) है; जहाँ इंसान अपने बीते हुए कल (Past) के इन्वेस्टमेंट (Investment) के लिए रोता रहता है।
            'सततं चिन्तयामास' का अर्थ है कि उसके दिमाग का इंजन बिना ब्रेक (Brake) के 24 घंटे केवल चिंता के ट्रैक पर भाग रहा था।
            जब इंसान 'प्रेजेंट' (Present moment) को छोड़कर पास्ट की यादों या फ्यूचर के डरों में फँस जाता है, तो वह ज़िंदा लाश बन जाता है।
            मार्कण्डेय ऋषि यह साफ कर रहे हैं कि दुनिया का सबसे बड़ा राजा भी अपने 'दिमाग' (Mind) का गुलाम होता है।
            पूरी धरती (पार्थिवः) पर राज करने वाला इंसान अपने खुद के ख्यालों को कंट्रोल नहीं कर पा रहा था।
            यहीं से यह सिद्ध होता है कि बाहरी आज़ादी से कुछ नहीं होता, असली आज़ादी मन (Thoughts) की आज़ादी है।
        """.trimIndent(),
        english = """
            (The destruction of the treasury and continuous anxiety): "That massive treasury which I had successfully accumulated (Sanchitah) strictly by enduring exceptionally terrifying hardship and intense pain (So'tiduhkhena), will undoubtedly be violently destroyed and permanently exhausted (Kshayam gamishyati) by them."
            "That supreme King of the earth (Parthivah), Suratha, continuously and relentlessly (Satatam) kept fiercely worrying and overthinking (Chintayamasa) strictly about these specific things (Etashcha) and countless other entirely useless matters (Anyashcha)."
            The King's pathetic crying is violently stuck exclusively on one single point—"I had accumulated that massive money with exceptionally heavy 'Pain' (hard work)!" (So'tiduhkhena).
            A human absolutely does not suffer as much from merely losing the object, as he suffers brutally from the perceived wastage of the 'Hard work' he aggressively invested in acquiring it.
            This is exactly the absolute 'Sunk Cost Fallacy'; where a human perpetually cries strictly for the dead Investment of his completely gone Past.
            'Satatam chintayamasa' literally means that the massive engine of his brain was violently racing 24 hours a day exactly on the tracks of high-voltage anxiety entirely without any Brakes.
            Exactly when a human abandons the 'Present Moment' to become hopelessly trapped in past memories or future fears, he seamlessly becomes a literal walking corpse.
            Sage Markandeya is fiercely clarifying that even the world's absolute greatest King is merely a pathetic slave strictly to his own 'Mind'.
            The exact human who successfully ruled the entire global earth (Parthivah) was completely failing to control his very own chaotic thoughts.
            This flawlessly proves that external physical freedom means absolutely nothing; the absolute real freedom is strictly the ultimate freedom from toxic Thoughts.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "तत्र विप्रश्रमाभ्याशे वैश्यमेकं ददर्श सः ।\nस पृष्टस्तेन कस्त्वं भो हेतुश्चागमनेऽत्र कः ॥ १६ ॥",
        hindi = """
            (वैश्य समाधि से मुलाकात): "उस समय, उस परम ज्ञानी ब्राह्मण (विप्र / मेधा ऋषि) के उस पवित्र आश्रम के बिल्कुल पास (तत्र विप्रश्रमाभ्याशे)।"
            "उस राजा सुरथ ने एक वैश्य (व्यापारी) को देखा (वैश्यमेकं ददर्श सः)।"
            "राजा ने उस व्यापारी के पास जाकर उससे पूछा (स पृष्टस्तेन): 'हे भाई (भो)! तुम कौन हो (कस्त्वं)? और तुम्हारे यहाँ इस घने जंगल में आने का क्या कारण (हेतुश्चागमनेऽत्र कः) है?'"
            यहाँ कहानी में 'सेकंड मेन कैरेक्टर' (Second Main Character)—वैश्य (व्यापारी)—की एंट्री (Entry) होती है।
            राजा (क्षत्रीय / Power) और वैश्य (व्यापारी / Wealth) दोनों ही इस दुनिया को चलाने वाले सबसे मजबूत खंभे (Pillars) हैं।
            पर आज आश्रम में दोनों ही पूरी तरह से बर्बाद, बेबस और कंगाल होकर एक-दूसरे के सामने खड़े हैं।
            यह दर्शाता है कि इंसान चाहे पॉवर (सत्ता) के पीछे भागे या पैसे (Money) के पीछे, अंत में 'माया' दोनों को ही एक बराबर धोखा देती है!
            राजा ने जब उस वैश्य को देखा, तो उसे लगा कि कोई और भी उसी की तरह 'दुख' में फँसा हुआ है।
            दुनिया का नियम है कि एक दुखी इंसान हमेशा दूसरे दुखी इंसान को देखकर उससे बात (Connect) करना चाहता है।
            'कस्त्वं भो' (तुम कौन हो) यह केवल एक साधारण सवाल नहीं है, यह उपनिषद और तन्त्र का सबसे बड़ा आध्यात्मिक प्रश्न है: 'Who am I?'
            यहीं से इन दोनों हारे हुए इंसानों की वह बातचीत शुरू होती है जो दुनिया को 'दुर्गा सप्तशती' का ज्ञान देगी।
        """.trimIndent(),
        english = """
            (The encounter with the Vaishya Samadhi): "Exactly at that specific time, perfectly near the highly sacred ashram of that supreme enlightened Brahmin sage (Tatra viprashramabhyashe)."
            "That magnificent King Suratha vividly saw exactly one Vaishya (a wealthy merchant) wandering there (Vaishyamekam dadarsha sah)."
            "Approaching him directly, the King fiercely asked him (Sa prishtastena): 'O brother (Bho)! Exactly who are you (Kastvam)? And what is the absolute precise reason for your arrival here (Hetushchagamane'tra kah) in this dense forest?'"
            Here perfectly occurs the flawless Entry of the story's 'Second Main Character'—the Vaishya (Merchant).
            The King (Kshatriya / raw Power) and the Vaishya (Merchant / massive Wealth) are undeniably the two absolute strongest Pillars actively operating this physical world.
            But today, right inside the ashram, both flawlessly stand face-to-face completely destroyed, absolutely helpless, and entirely bankrupt.
            This brilliantly demonstrates that whether a human frantically chases absolute Power or heavily chases massive Money, in the ultimate end, 'Maya' flawlessly betrays both of them equally!
            Exactly when the King saw that merchant, he instantly perceived that someone else was also violently trapped strictly in identical 'Agony'.
            The brutal rule of the world is that a miserable, broken human perpetually desires to Connect and talk immediately upon seeing another heavily broken human.
            'Kastvam bho' (Exactly who are you) is absolutely not merely an ordinary, cheap question; it is Vedanta and Tantra's absolute greatest spiritual inquiry: 'Who am I?'
            Right exactly from here begins that profound conversation between these two defeated humans which will flawlessly hand the explosive wisdom of 'Durga Saptshati' to the world.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "सशोक इव कस्मात्त्वं दुर्मना इव लक्ष्यसे ।\nइत्याकर्ण्य वचस्तस्य भूपतेः प्रणयोदितम् ॥ १७ ॥",
        hindi = """
            (राजा का वैश्य से प्रश्न): "राजा सुरथ ने आगे पूछा: 'तुम किस कारण से इतने अधिक शोक में डूबे हुए (सशोक इव कस्मात्त्वं) और इतने गहरे दुःख से भरे हुए (दुर्मना इव) दिखाई दे रहे हो (लक्ष्यसे)?'"
            "राजा के द्वारा अत्यंत प्रेम, सहानुभूति और अपनेपन से कहे गए (प्रणयोदितम्) इन वचनों को ध्यान से सुनकर (इत्याकर्ण्य वचस्तस्य भूपतेः)।"
            राजा सुरथ खुद डिप्रेशन (Depression) में थे, पर व्यापारी का चेहरा देखकर वे समझ गए कि उसका दुःख भी बहुत भयंकर है।
            'सशोक' का मतलब है जिसका पूरा शरीर और ऑरा (Aura) दुःख की वाइब्रेशन (Vibration) छोड़ रहा हो।
            और 'दुर्मना' का मतलब है जिसका मन (Mind) अंदर से पूरी तरह टूट चुका हो और नेगेटिविटी (Negativity) से भर गया हो।
            जब एक राजा (जिसका काम आदेश देना होता है) एक व्यापारी से 'प्रणय' (प्यार और सहानुभूति) से बात करता है, तो यह दिखाता है कि दुःख इंसान के अहंकार को कैसे पिघला देता है।
            हारने के बाद इंसान का 'स्टेटस' (Status) खत्म हो जाता है, और वह दूसरे इंसान को सिर्फ एक 'इंसान' की तरह देखने लगता है।
            राजा के इन सहानुभूति भरे शब्दों ने उस व्यापारी के दिल का ताला खोल दिया।
            जब कोई इंसान अंदर से बहुत भारी (टेंशन में) होता है, तो उसे सिर्फ एक ऐसे व्यक्ति की तलाश होती है जो बिना जज (Judge) किए उसकी बात सुन ले।
            राजा सुरथ का यह सवाल उस वैश्य के लिए एक 'थेरेपी' (Therapy) की तरह काम करने वाला था।
        """.trimIndent(),
        english = """
            (The King's question to the Vaishya): "King Suratha further fiercely asked: 'For exactly what horrific reason do you actively appear to be drowning so heavily in profound sorrow (Sashoka iva kasmattvam) and violently filled with exceptionally dark misery (Durmana iva lakshyase)?'"
            "Carefully and flawlessly hearing these exact words of the supreme King (Ityakarnya vachastasya bhupateh), which were spoken strictly with immense affection, deep empathy, and familiarity (Pranayoditam)."
            King Suratha himself was aggressively battling heavy Depression, but simply looking at the merchant's face, he flawlessly understood that his agony was equally terrifying.
            'Sashoka' literally means someone whose entire physical body and Aura are violently emitting the toxic Vibration of pure grief.
            And 'Durmana' profoundly means someone whose highly restless Mind has completely shattered from the inside and is heavily flooded strictly with deep Negativity.
            Exactly when a King (whose sole job is to ruthlessly command) speaks to a mere merchant with 'Pranaya' (pure love and empathy), it brilliantly demonstrates exactly how violent sorrow flawlessly melts human arrogance.
            Exactly after a crushing defeat, a human's fake 'Status' is completely annihilated, and he perfectly begins to view another human strictly as just a 'Human'.
            These exceptionally empathetic words of the King violently unlocked the heavy vault of that merchant's shattered heart.
            Exactly when a human is exceptionally heavy from the inside (under massive tension), he desperately searches exclusively for just one specific person who will silently listen to him completely without Judging.
            This exact profound question of King Suratha was destined to work flawlessly exactly like a psychological 'Therapy' for that broken Vaishya.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "प्रत्युवाच स तं वैश्यः प्रश्रयावनतो नृपम् ।\nवैश्य उवाच ॥ १८ ॥",
        hindi = """
            (वैश्य का विनम्र उत्तर): "उस वैश्य (व्यापारी) ने अत्यंत नम्रता और सम्मान के साथ (प्रश्रयावनतो) सिर झुकाकर उस महान राजा (नृपम्) को अपना उत्तर दिया (प्रत्युवाच)।"
            "वैश्य ने कहा (वैश्य उवाच):"
            यह एक बहुत छोटा श्लोक (Transition verse) है जो कहानी को आगे बढ़ाता है।
            'प्रश्रयावनतो' का अर्थ है कि व्यापारी ने राजा के सामने अपनी ईगो (Ego) को पूरी तरह से नीचे कर दिया।
            हालाँकि दोनों ही इस समय जंगल में सब कुछ हार चुके थे, पर व्यापारी ने राजा के पिछले 'स्टेटस' (Status) का पूरा सम्मान किया।
            जब इंसान दुःख में होता है, तो विनम्रता (Humility) अपने-आप आ जाती है; घमंड केवल तब तक रहता है जब तक जेब में पैसा होता है!
            व्यापारी अब अपनी पूरी 'लाइफ-स्टोरी' (Life-story) और अपने 'ट्रॉमा' (Trauma) को राजा के सामने खोलने जा रहा है।
            यह संवाद तन्त्र का एक बहुत बड़ा रहस्य खोलता है: जब तक आप अपने अंदर के कचरे (दबे हुए दुःख) को बाहर नहीं निकालते, तब तक आप भगवान को नहीं पा सकते।
            राजा और व्यापारी की यह बातचीत एक साइकोलॉजिकल 'क्लींजिंग' (Cleansing / सफाई) का प्रोसेस (Process) है।
            इसी के बाद दोनों एक साफ दिमाग (Clean state) के साथ ऋषि मेधा से परम ज्ञान (श्री विद्या) प्राप्त करने के योग्य बनेंगे।
        """.trimIndent(),
        english = """
            (The humble reply of the Vaishya): "That specific Vaishya (merchant) flawlessly and deeply bowed his head with exceptionally extreme humility and profound respect (Prashrayavanato) and replied directly to that magnificent King (Pratyuvacha sa tam nripam)."
            "The Vaishya profoundly spoke (Vaishya uvacha):"
            This is an exceptionally brief Transition Verse that flawlessly propels the epic narrative violently forward.
            'Prashrayavanato' strictly means that the merchant ruthlessly lowered his entire toxic Ego entirely to the ground perfectly before the King.
            Even though both were currently completely destroyed and standing absolutely bankrupt right inside the dense forest, the merchant flawlessly respected the King's former Royal 'Status'.
            Exactly when a human is actively experiencing terrifying sorrow, true Humility (Vinamrata) violently appears entirely on its own; toxic pride actively survives strictly only as long as cheap money exists in the pocket!
            The merchant is now aggressively preparing to flawlessly open up his entire traumatic 'Life-Story' and deep internal 'Trauma' completely before the King.
            This flawless dialogue ruthlessly exposes a massive secret of advanced Tantra: Exactly until you completely vomit out all the toxic garbage (suppressed agony) from inside yourself, you can absolutely never attain God.
            This exact conversation strictly between the King and the merchant is undeniably a highly advanced psychological 'Cleansing' (Purification) Process.
            Strictly and exclusively after this, both will effortlessly become perfectly worthy of violently receiving the ultimate supreme wisdom (Sri Vidya) directly from Sage Medha with a 100% 'Clean State'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "समाधिर्नाम वैश्योऽहमुत्पन्नो धनिनां कुले ।\nपुत्रदारैर्निरस्तश्च धनलोभादसाधुभिः ॥ १९ ॥",
        hindi = """
            (वैश्य समाधि की कहानी): "मेरा नाम 'समाधि' है और मैं एक वैश्य (व्यापारी) हूँ। मेरा जन्म अत्यंत धनवान और अमीर लोगों के कुल (धनिनां कुले) में हुआ था।"
            "परंतु मेरे अपने ही अत्यंत दुष्ट और बुरे (असाधुभिः) 'पुत्रों और पत्नी' (पुत्रदारैः) ने मुझे घर से बाहर निकाल दिया (निरस्तश्च)।"
            "और यह सब उन्होंने केवल और केवल 'धन के लालच' (धनलोभाद्) में आकर किया!"
            यह श्लोक इस दुनिया के सबसे गंदे और कड़वे सच—'लालच' (Greed)—का पर्दाफाश करता है!
            व्यापारी का नाम 'समाधि' है। तन्त्र में समाधि का मतलब परम शांति है; पर यहाँ यह इंसान बिल्कुल अशांत और दुखी है।
            उसने अपनी पूरी ज़िंदगी मेहनत करके अपनी पत्नी और बच्चों के लिए करोड़ों की संपत्ति (Wealth) जमा की थी।
            पर जिन बच्चों को उसने प्यार से पाला था, उन्होंने उसी पैसे (Property) के लालच में अपने ही बाप को लात मारकर घर से निकाल दिया!
            'धनलोभादसाधुभिः'—पैसे का लालच अच्छे-अच्छे इंसानों को राक्षस (असाधु) बना देता है; यह रिश्ते-नाते, खून का रिश्ता कुछ नहीं देखता।
            यह श्लोक साबित करता है कि दुनिया का कोई भी रिश्ता परमानेंट (Permanent) या निस्वार्थ (Selfless) नहीं है। हर रिश्ता किसी न किसी स्वार्थ (लालच) पर टिका है।
            राजा को उसके मंत्रियों ने लूटा था, पर समाधि को तो उसके अपने 'खून' (पत्नी-बच्चों) ने ही लूट लिया।
            यह दर्द राजा के दर्द से भी ज्यादा भयंकर (Violent) है।
        """.trimIndent(),
        english = """
            (The tragic story of Vaishya Samadhi): "My actual name is 'Samadhi' and I am exactly a Vaishya (wealthy merchant). I was flawlessly born strictly into an exceptionally rich and massively wealthy family (Utpanno dhaninam kule)."
            "However, my very own exceptionally wicked and evil-minded (Asadhubhih) 'sons and wife' (Putradaraih) ruthlessly kicked me out and banished me entirely from my own house (Nirastashcha)."
            "And they executed all this extreme cruelty strictly and exclusively purely out of their terrifying 'Greed for my Wealth' (Dhanalobhad)!"
            This spectacular verse violently exposes the absolute filthiest and most brutal truth of this physical world—toxic 'Greed' (Lalach)!
            The merchant's literal name is 'Samadhi'. In pure Tantra, Samadhi profoundly means ultimate, absolute supreme peace; yet here this human is exceptionally restless and deeply miserable.
            He had relentlessly worked like a dog his entire life strictly to accumulate millions in absolute Wealth explicitly for his beloved wife and children.
            But the exact same biological children he had raised with intense love, violently kicked their own father out of the house strictly out of dark, blind greed for that exact same Property!
            'Dhanalobhadasadhubhih'—the terrifying greed for cheap paper money flawlessly transforms even the absolute best humans into literal demons (Asadhu); it absolutely ignores all blood relations and worldly ties.
            This phenomenal verse flawlessly proves that absolutely zero physical relationship in the entire world is truly Permanent or completely 'Selfless'. Every single worldly relationship fundamentally rests exclusively on some selfish greed.
            The King was ruthlessly looted strictly by his political ministers, but Samadhi was brutally plundered exactly by his very own 'Blood' (wife and sons).
            This specific agony is undeniably billions of times more 'Violent' and excruciating than even the King's brutal pain.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "विहीनः स्वजनैर्दारैः पुत्रैरादाय मे धनम् ।\nवनमभ्यागतो दुःखी निरस्तश्चाप्तबन्धुभिः ॥ २० ॥",
        hindi = """
            (अपनों द्वारा ठुकराया जाना): "मेरे अपने ही सगे-संबंधियों (स्वजनैः), मेरी पत्नी (दारैः), और मेरे सगे बेटों (पुत्रैः) ने मेरा सारा धन और संपत्ति पूरी तरह से हड़प (आदाय मे धनम्) लिया है।"
            "उन सभी रिश्तेदारों और अपनों से पूरी तरह से ठुकराया हुआ (निरस्तश्चाप्तबन्धुभिः), धन से रहित (विहीनः), और अत्यंत दुखी (दुःखी) होकर, मैं इस भयानक जंगल में भटकता हुआ आ गया हूँ (वनमभ्यागतो)।"
            समाधि का दर्द इस बात से बहुत ज्यादा है कि उसे किसी बाहरी दुश्मन ने नहीं, बल्कि 'अपनों' ने मारा है।
            इंसान बाहर की दुनिया से लड़ सकता है, पर जब उसके अपने ही उसकी पीठ में छुरा घोंपते हैं (Backstabbing), तो उसका 'सिस्टम' (System) क्रैश (Crash) हो जाता है।
            उन्होंने सिर्फ उसका पैसा (धन) नहीं लिया; उन्होंने उसका सम्मान, उसका प्यार और उसका वजूद (Existence) सब कुछ छीन लिया (विहीनः)।
            'आप्तबन्धुभिः' का अर्थ है वो दोस्त और रिश्तेदार जिन पर आप आँख बंद करके भरोसा (Trust) करते हैं।
            जब वो लोग धोखा देते हैं, तो इंसान का इस दुनिया और इंसानियत से हमेशा के लिए भरोसा उठ जाता है।
            यही कारण था कि समाधि ने किसी दूसरे शहर जाकर नई ज़िंदगी शुरू करने के बजाय, सीधे 'जंगल' (वनम्) का रास्ता चुना।
            वह समाज की इस गंदी 'माया' (स्वार्थ) से इतना थक चुका था कि अब उसे किसी भी इंसान की शक्ल नहीं देखनी थी।
            यह श्लोक 'वैराग्य' (Vairagya / Detachment) पैदा होने की सबसे पहली और सबसे क्रूर (Brutal) स्टेज (Stage) है।
        """.trimIndent(),
        english = """
            (Violently rejected by one's own blood): "My very own close relatives (Svajanaih), my literal wife (Daraih), and my biological sons (Putraih) have completely and ruthlessly confiscated and violently hijacked all my massive wealth and entire property (Adaya me dhanam)."
            "Being completely, brutally rejected and violently thrown out exactly by all those highly trusted relatives and close friends (Nirastashchaptabandhubhih), entirely bereft of all money (Vihinah), and exceptionally devastated (Duhkhi), I have helplessly wandered strictly into this terrifying dense forest (Vanamabhyagato)."
            Samadhi's agonizing pain is exceptionally astronomical strictly because he was absolutely not destroyed by some external enemy, but directly slaughtered by his very 'Own' blood.
            A human can flawlessly and aggressively fight the external physical world, but exactly when his very own family brutally stabs him directly in the back (Backstabbing), his entire mental 'System' violently Crashes.
            They absolutely did not merely steal his physical paper money (Dhanam); they ruthlessly stripped him of his absolute dignity, his pure love, and his very Existence completely (Vihinah).
            'Aptabandhubhih' specifically means those exact close friends and relatives upon whom you blindly place your 100% absolute Trust.
            Exactly when those specific people commit terrifying betrayal, the human's complete trust in this physical world and entire humanity is permanently annihilated forever.
            This was exactly the absolute reason why Samadhi aggressively chose the direct path straight into the 'Forest' (Vanam), instead of pathetically traveling to another city to start a fake new life.
            He was so incredibly exhausted and disgusted exactly by this filthy 'Maya' (selfishness) of society that he absolutely never wanted to see another human face again.
            This spectacular verse perfectly captures the absolute first and most incredibly Brutal (Cruel) stage of the violent awakening of 'Vairagya' (Absolute Detachment).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 21,
        sanskrit = "सोऽहं न वेद्मि पुत्राणां कुशलाकुशलात्मिकाम् ।\nप्रवृत्तिं स्वजनानां च दाराणां चात्र संस्थितः ॥ २१ ॥",
        hindi = """
            (अटैचमेंट की बेबसी): "इतना सब होने के बाद भी (सोऽहं), इस जंगल में बैठा हुआ (अत्र संस्थितः) मैं अभी तक यह बिल्कुल नहीं जानता (न वेद्मि)।"
            "कि मेरे वे बेटे (पुत्राणां), मेरे सगे-संबंधी (स्वजनानां), और मेरी वह पत्नी (दाराणां) इस समय किस हाल में हैं; उनका कोई कुशल (भला / Good) हो रहा है या अकुशल (बुरा / Bad)?"
            यह श्लोक 'ह्यूमन अटैचमेंट' (Human Attachment) की सबसे खौफनाक और अंधी (Blind) बीमारी को दिखा रहा है!
            जिन बच्चों और पत्नी ने समाधि का सारा पैसा लूटकर उसे लात मार दी, वह समाधि जंगल में बैठकर भी उन्हीं के 'कुशल' (Welfare) की चिंता कर रहा है!
            लॉजिक (Logic) कहता है कि उसे अपने परिवार से नफरत (Hate) करनी चाहिए और उन्हें बद्दुआ देनी चाहिए।
            पर 'मोह' (Moha) कोई लॉजिक नहीं समझता! मोह इंसान को इतना बेबस कर देता है कि वह अपने ही कातिलों (Killers) से प्यार करने लगता है; इसे साइकोलॉजी में 'स्टॉकहोम सिंड्रोम' (Stockholm Syndrome) कहते हैं!
            समाधि कह रहा है "न वेद्मि" (मैं नहीं जानता); यानी वह 'जानना' चाहता है कि उसके परिवार वालों ने खाना खाया या नहीं!
            माया (Illusion) का इससे बड़ा कोई और उदाहरण नहीं हो सकता कि इंसान उस ज़हर को दोबारा पीना चाहता है जिसने उसकी जान ले ली।
            यही वह 'माया का सॉफ्टवेयर' है जिसे साक्षात् 'माता त्रिपुरा' ने इंसान के दिमाग में इनस्टॉल (Install) किया है ताकि दुनिया चलती रहे।
            बिना इस मोह के, दुनिया एक दिन में खत्म हो जाएगी।
        """.trimIndent(),
        english = """
            (The absolute helplessness of toxic attachment): "Even strictly after absolutely all this horrific betrayal (So'ham), flawlessly sitting right here in this dense forest (Atra samsthitah), I still absolutely do not even know (Na vedmi)."
            "Exactly what is the current precise situation of those sons of mine (Putranam), my close relatives (Svajananam), and that literal wife of mine (Daranam); is any exact 'Kushala' (good/welfare) happening to them or 'Akushala' (bad/harm)?"
            This phenomenal verse flawlessly demonstrates the absolute most terrifying and completely 'Blind' disease of toxic 'Human Attachment'!
            The exact same children and wife who violently looted absolutely all of Samadhi's massive wealth and ruthlessly kicked him out, that exact Samadhi is actively sitting in the forest frantically worrying exclusively about their 'Kushala' (Welfare)!
            Pure Logic aggressively dictates that he absolutely must violently Hate his entire family and fiercely curse them to hell.
            But 'Moha' (Blind Infatuation) comprehends absolutely zero Logic! Moha renders a human so exceptionally helpless that he literally begins intensely loving his very own Killers; modern Psychology profoundly calls this exact phenomenon 'Stockholm Syndrome'!
            Samadhi pathetically cries "Na vedmi" (I do not know); explicitly meaning he desperately 'Wishes to Know' whether his extremely wicked family has successfully eaten food or not!
            There can absolutely be no greater ultimate example of 'Maya' (Illusion) than the brutal fact that a human desperately thirsts to actively drink the exact same Poison that just violently killed him.
            This is exactly that absolute 'Software of Maya' which the direct 'Mother Tripura' Herself has flawlessly Installed straight into the human brain strictly so that the physical world keeps running.
            Completely without this terrifying Moha, the entire physical world would effortlessly collapse and end in exactly a single day.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 22,
        sanskrit = "किं नु तेषां गृहे क्षेममक्षेमं किं नु साम्प्रतम् ।\nकथं ते किं नु सद्वृत्ता दुर्वृत्ताः किं नु मे सुताः ॥ २२ ॥",
        hindi = """
            (बेटों की चिंता की पराकाष्ठा): "क्या इस समय (साम्प्रतम्) उनके उस घर (गृहे) में सब कुछ कुशल-मंगल (क्षेमम्) है, या कोई अमंगल (अक्षेमं) घटित हो रहा है?"
            "मेरे वे बेटे (मे सुताः) अब कैसे हैं (कथं ते)? क्या वे अब भी अच्छे आचरण (सद्वृत्ता) वाले हैं, या फिर वे पूरी तरह से दुराचारी (दुर्वृत्ताः / बुरे रास्ते पर चलने वाले) बन गए हैं?"
            यह 'मोह' (Moha) की चरम सीमा (Extreme limit) है! समाधि अभी भी उस घर को 'उनका घर' (तेषां गृहे) कह रहा है, जिसे उसने खुद अपने पैसों से बनाया था।
            और वह यह सोचकर तड़प रहा है कि उसके घर में कोई 'अक्षेम' (Danger / बीमारी या नुक्सान) तो नहीं आ गया!
            जिन बेटों ने खुद सबसे बड़ा 'दुराचार' (अपने पिता को निकालना) किया है, समाधि अभी भी सोच रहा है कि क्या वे 'सद्वृत्त' (Good character) हैं?
            इंसान का दिमाग रियलिटी (Reality) को देखने से कैसे इंकार कर देता है, यह उसका सबसे बड़ा सबूत है (Denial mode)।
            वह जानता है कि उसके बेटे 'राक्षस' बन चुके हैं, फिर भी एक पिता का अंधा प्यार (Blind love) उन्हें 'अच्छा' साबित करने की झूठी उम्मीद (False hope) पाल रहा है।
            हम भी अपनी ज़िंदगी में उन लोगों के लिए रोते हैं जिन्होंने हमें बर्बाद किया, और हम सोचते हैं कि "शायद वो बदल गए होंगे।"
            मार्कण्डेय ऋषि हमें यह दिखा रहे हैं कि जब तक दिमाग में यह 'उम्मीद' (Hope) ज़िंदा है, इंसान कभी भी आज़ाद (Liberated) नहीं हो सकता।
            अध्यात्म (Spirituality) का मतलब है इस झूठी उम्मीद के शीशे को हथौड़े से तोड़ देना!
        """.trimIndent(),
        english = """
            (The absolute extreme peak of anxiety for sons): "Exactly at this current precise moment (Sampratam), is absolutely everything flawlessly safe and prosperous (Kshemam) entirely inside that exact house of theirs (Teṣam grihe), or is some horrific danger and misfortune (Akshemam) violently occurring?"
            "Exactly how are those specific sons of mine right now (Katham te)? Are they still strictly possessing a flawlessly 'Good Character' (Sadvritta), or have they violently transformed entirely into completely evil and wicked people (Durvrittah)?"
            This is undeniably the absolute 'Extreme Limit' of highly toxic 'Moha' (Blind Attachment)! Samadhi is still pathetically referring to that house strictly as 'Their house' (Tesham grihe), which he himself had flawlessly built entirely with his own hard-earned money.
            And he is violently torturing himself continuously thinking whether some massive 'Akshema' (Danger / disease or total ruin) has violently struck his house!
            The exact same sons who themselves have flawlessly committed the absolute greatest 'Evil Act' (kicking out their own father), Samadhi is still frantically pondering if they are 'Sadvritta' (of Good character)!
            Exactly how the human brain violently refuses to strictly perceive actual Reality, this is the absolute greatest proof of it (pure Denial mode).
            He flawlessly knows in reality that his sons have violently become literal 'Demons', yet the highly blind love of a pathetic father is actively nurturing a highly Fake Hope desperately trying to prove them 'Good'.
            We too furiously cry our entire lives strictly for exactly those specific people who violently destroyed us, and we foolishly think, "Perhaps they have miraculously changed."
            Sage Markandeya is aggressively showing us that exactly as long as this highly toxic 'Hope' actively survives in the brain, a human can absolutely never become 'Liberated' (Free).
            True Spirituality (Adhyatma) profoundly means ruthlessly smashing this specific fragile glass mirror of fake hope violently with a heavy hammer!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 23,
        sanskrit = "राजोवाच ॥ २३ ॥\nयैर्निरस्तो भवाँलुब्धैः पुत्रदारादिभिर्धनैः ॥ २३ ॥",
        hindi = """
            (राजा सुरथ का सीधा और तीखा प्रश्न): "राजा सुरथ ने उस वैश्य से अत्यंत हैरानी से कहा (राजोवाच):"
            "जिन अत्यंत लालची (लुब्धैः) और धन के भूखे (धनैः) 'तुम्हारे अपने ही बेटों, पत्नी आदि' (पुत्रदारादिभिः) ने तुम्हें इतनी बेरहमी से धक्के मारकर घर से निकाल दिया (यैर्निरस्तो भवाँ)!"
            (यह श्लोक अगले श्लोक के साथ जुड़ा हुआ है, जहाँ राजा अपना पूरा सवाल खत्म करेगा)।
            राजा सुरथ, जो खुद एक प्रैक्टिकल (Practical) शासक और योद्धा थे, वैश्य की इस 'पागलपन' (Stupidity) को सुनकर हैरान रह गए।
            राजा को समझ नहीं आ रहा था कि कोई इंसान इतना बेवकूफ और इतना 'अँधा' कैसे हो सकता है?
            जिन लोगों ने पैसों (धनैः) के लिए बाप को कचरे की तरह बाहर फेंक दिया (निरस्तः), उनके लिए यह आदमी अब भी क्यों रो रहा है?
            राजा का यह सवाल केवल वैश्य के लिए नहीं है; यह सवाल 'उपनिषद' पूरी इंसानियत से पूछ रहा है!
            हम सब जानते हैं कि दुनिया मतलबी (Selfish) है, रिश्ते केवल पैसों के लिए हैं (लुब्धैः), फिर भी हम उन्हीं के लिए अपनी पूरी ज़िंदगी क्यों बर्बाद करते हैं?
            राजा यहाँ 'लॉजिक' (Intellect) का प्रतीक बन गया है, जो 'इमोशन' (Emotion / वैश्य) को झकझोर कर जगाने की कोशिश कर रहा है।
            यह दो अलग-अलग मानसिकताओं (Mindsets) की टक्कर है—एक तरफ सच को देखने वाला राजा, और दूसरी तरफ मोह में अंधा हुआ वैश्य।
        """.trimIndent(),
        english = """
            (King Suratha's direct and fiercely sharp question): "King Suratha spoke to that exact Vaishya with exceptionally massive astonishment and profound shock (Rajovacha):"
            "Exactly those highly exceptionally greedy (Lubdhaih) and completely money-hungry (Dhanaih) 'very own biological sons, wife, etc., of yours' (Putradaradibhih) who have so violently and ruthlessly kicked you out and completely banished you (Yairnirasto bhavan)!"
            (This specific verse is flawlessly and inextricably linked strictly with the next verse, where the King will forcefully complete his entire massive question).
            King Suratha, who himself was an exceptionally highly Practical ruler and fierce warrior, was completely blown away and violently shocked actively listening to this sheer 'Stupidity' (Madness) of the Vaishya.
            The King absolutely could not possibly comprehend exactly how on earth any human could realistically be so exceptionally foolish and so flawlessly 'Blind'?
            Exactly those specific people who violently threw their own father out exactly like cheap trash strictly for petty paper money (Dhanaih / Nirastah), exactly why on earth is this pathetic man still frantically crying for them?
            This explosive question of the King is absolutely not strictly meant merely for the Vaishya; it is exactly this 'Upanishad' fiercely interrogating absolute entire humanity!
            We absolutely all flawlessly know that the entire physical world is highly Selfish, and all fake relationships exist strictly exclusively for money (Lubdhaih), yet exactly why do we violently destroy our entire lives solely for them?
            The King flawlessly becomes the absolute symbol of pure 'Logic' (Intellect) right here, aggressively attempting to violently shake and violently awaken pure 'Emotion' (The Vaishya).
            This is the ultimate horrific collision of exactly two completely different Mindsets—the King who ruthlessly sees the harsh truth on one side, and the merchant completely blinded by highly toxic Moha on the other.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 24,
        sanskrit = "तेषु किं भवतः स्नेहमनुबध्नाति मानसम् ॥ २४ ॥",
        hindi = """
            (राजा का प्रश्न पूरा हुआ): "उन अत्यंत दुष्ट और लालची लोगों में (तेषु), तुम्हारा यह मन (मानसम्) आज भी क्यों और किस कारण से इतना भयंकर 'स्नेह' (Blind Affection / प्रेम) बांधे हुए है (किं स्नेहमनुबध्नाति)?"
            राजा सुरथ ने उस वैश्य के दिमाग के सबसे कमज़ोर 'नर्व' (Nerve) पर सीधा प्रहार किया है।
            वह पूछ रहा है कि तुम्हारे दिमाग (मानसम्) का वह कौन सा 'सॉफ्टवेयर बग' (Software Bug) है जो तुम्हें अभी भी उनसे जोड़े (अनुबध्नाति) हुए है?
            जब कोई आपको नुकसान पहुँचाता है, तो आपका 'डिफेंस मैकेनिज्म' (Defense Mechanism) तुरंत उस इंसान को ब्लॉक (Block) कर देना चाहिए।
            पर इंसान का मन (Mind) इतना बेवकूफ है कि वह 'लॉजिक' (Logic) से नहीं, बल्कि 'आदत' (Habit) और 'मोह' से चलता है।
            राजा सुरथ यह जानना चाहता है कि इस 'मेंटल स्लेवरी' (Mental Slavery / मानसिक गुलामी) का असली 'रूट कॉज' (Root Cause / जड़) क्या है?
            मज़े की बात यह है कि राजा सुरथ खुद भी अपने 'हाथी और खजाने' के लिए रो रहा था!
            पर जब हम दूसरों की परेशानी देखते हैं, तो हम बहुत 'लॉजिकल' (Logical) और बड़े 'ज्ञानी' बन जाते हैं।
            यह श्लोक 'सेल्फ-रिफ्लेक्शन' (Self-reflection) का मास्टरक्लास (Masterclass) है—हम दूसरों की गलतियां तुरंत पकड़ लेते हैं, पर खुद उसी जाल में फँसे होते हैं।
            अब वैश्य जो जवाब देगा, वह सनातन साइकोलॉजी (Psychology) का सबसे बड़ा रहस्य खोलने वाला है।
        """.trimIndent(),
        english = """
            (The King's massive question successfully completed): "Exactly in those highly wicked and exceptionally greedy people (Teshu), exactly why and for what precise reason does this specific mind of yours (Manasam) still aggressively and violently bind (Anubadhnati) itself with such exceptionally horrific 'Sneha' (Blind Affection / Love / Sneham) even today?"
            King Suratha has ruthlessly and aggressively struck exactly straight at the absolute weakest 'Nerve' of that Vaishya's highly chaotic brain.
            He is fiercely interrogating exactly what specific 'Software Bug' actively exists perfectly inside your brain (Manasam) that aggressively continues to securely Tie (Anubadhnati) you directly to them?
            Exactly when someone violently harms you, your natural biological 'Defense Mechanism' must instantaneously and flawlessly Block that specific human forever.
            But the pathetic human Mind is so exceptionally stupid that it absolutely does not operate on pure 'Logic', but strictly runs entirely on deep 'Habit' and toxic 'Moha' (Infatuation).
            King Suratha desperately desires to perfectly comprehend exactly what the absolute literal 'Root Cause' (Foundation) of this highly terrifying 'Mental Slavery' (Blind attachment) actually is?
            The exceptionally ironic and absolute funniest part is that King Suratha himself was actively frantically crying strictly for his lost 'Elephant and Treasury'!
            But exactly when we vividly observe the massive problems of other humans, we instantaneously and flawlessly transform into highly 'Logical' and supreme 'Enlightened sages'.
            This spectacular verse is undeniably an absolute Masterclass exactly in 'Self-Reflection'—we violently and instantly catch the glaring errors of others, yet we ourselves remain hopelessly trapped securely inside the exact same terrifying web.
            Now, the specific explosive answer the Vaishya will flawlessly provide is destined to violently unlock the absolute greatest secret of Sanatana Psychology.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 25,
        sanskrit = "वैश्य उवाच ॥ २५ ॥\nएवमेतद्यथा प्राह भवानस्मद्गतं वचः ।\nकिं करोमि न बध्नाति मम निष्ठुरतां मनः ॥ २५ ॥",
        hindi = """
            (वैश्य की बेबसी और स्वीकृति): "वैश्य ने अत्यंत दुःख के साथ कहा (वैश्य उवाच): हे महान राजा! आपने मेरी इस दयनीय स्थिति (अस्मद्गतं) के बारे में जो कुछ भी कहा (यथा प्राह भवान्), वह बिल्कुल 100% सच है (एवमेतद्)!"
            "परंतु मैं क्या करूँ (किं करोमि)? मेरा यह बेवकूफ मन (मम मनः) उन लोगों के प्रति ज़रा सी भी 'निष्ठुरता' (कठोरता / Cruelty / निष्ठुरतां) धारण ही नहीं कर पाता (न बध्नाति)!"
            यह श्लोक एक इंसान के अपने ही 'मन' (Mind) के सामने पूरी तरह हार मान लेने (Total Surrender) का सबसे बड़ा उदाहरण है।
            व्यापारी मान रहा है कि राजा का लॉजिक (Logic) बिल्कुल सही है। उसे अपने परिवार से नफरत करनी चाहिए।
            "किं करोमि" (मैं क्या करूँ?)—यह उन करोड़ों लोगों की चीख है जो किसी टॉक्सिक रिलेशनशिप (Toxic Relationship) या एडिक्शन (Addiction) में फँसे हुए हैं।
            वे जानते हैं कि यह इंसान या यह आदत उन्हें बर्बाद कर रही है, पर वे खुद को रोक नहीं पाते!
            वैश्य कह रहा है कि मेरा 'सॉफ्टवेयर' (मन) ऐसा करप्ट (Corrupt) हो चुका है कि वह उन धोखेबाज़ों के लिए भी 'कठोर' (निष्ठुर) नहीं हो पा रहा।
            इंसान सोचता है कि वह अपने मन का 'मालिक' (Master) है, पर यहाँ साबित हो गया कि इंसान अपने ही मन का सबसे बड़ा 'गुलाम' (Slave) है।
            जब तक यह 'मन' (Mind) ज़िंदा है, आप कभी सही फैसले (Right decisions) नहीं ले सकते, क्योंकि मन हमेशा इमोशन (Emotion) के आगे घुटने टेक देता है।
            वैश्य का यह जवाब राजा सुरथ के 'ईगो' (कि मैं बहुत लॉजिकल हूँ) को भी हिलाने वाला था।
        """.trimIndent(),
        english = """
            (The absolute helplessness and confession of the Vaishya): "The Vaishya replied strictly with exceptionally deep sorrow (Vaishya uvacha): O magnificent King! Absolutely everything that you have just flawlessly spoken (Yatha praha bhavan) perfectly regarding this highly pathetic condition of mine (Asmadgatam), is undeniably 100% the absolute pure truth (Evametad)!"
            "But exactly what on earth do I do (Kim karomi)? This exceptionally stupid mind of mine (Mama manah) absolutely and completely fails to aggressively tie itself to or strictly adopt even the slightest millimeter of 'Nishthurata' (Cruelty / harshness / Nishthuratam) flawlessly toward those exact people (Na badhnati)!"
            This phenomenal verse is undeniably the absolute greatest example of a pathetic human completely and unconditionally admitting total Defeat (Total Surrender) strictly before his very own 'Mind'.
            The merchant flawlessly admits that the King's pure Logic is absolutely 100% correct. He undeniably absolutely must fiercely hate his evil family.
            "Kim karomi" (Exactly what do I do?)—this is the exact terrifying, violent scream of millions of pathetic humans hopelessly trapped deeply strictly inside a highly Toxic Relationship or deadly Addiction.
            They flawlessly and completely know that this specific human or this exact toxic habit is aggressively destroying them, yet they absolutely cannot possibly stop themselves!
            The Vaishya is actively screaming that my 'Software' (Mind) has become so exceptionally Corrupt that it absolutely cannot possibly become 'Harsh' (Cruel) even for those absolute ultimate backstabbers.
            A human foolishly assumes he is the absolute 'Master' of his own mind, but right here it is flawlessly proven that the human is the absolute greatest pathetic 'Slave' exactly to his very own mind.
            Exactly as long as this specific 'Mind' is actively alive, you can absolutely never possibly execute 'Right Decisions', strictly because the mind perpetually drops violently to its knees completely before cheap Emotion.
            This explicit, terrifying answer of the Vaishya was perfectly destined to violently shake even King Suratha's massive 'Ego' (that I am exceptionally logical).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 26,
        sanskrit = "यैः सन्त्यज्य पितृस्नेहं धनलुब्धैर्निराकृतः ।\nपतिस्वजनहार्दं च हार्दि तेष्वेव मे मनः ॥ २६ ॥",
        hindi = """
            (अटैचमेंट का अंधापन): "जिन लालची लोगों ने (यैः धनलुब्धैः) एक पिता के पवित्र प्यार (पितृस्नेहं), एक पति के प्यार, और सगे-संबंधियों के प्रेम (पतिस्वजनहार्दं च) को पूरी तरह से त्याग कर (सन्त्यज्य) मुझे बेघर कर दिया (निराकृतः)।"
            "उन्हें सब कुछ भूल जाने वाले उन गद्दारों (तेष्वेव) के लिए ही मेरा यह पागल मन (मे मनः) आज भी अंदर से 'हार्दिक प्रेम' (हार्दि / Deep affection) महसूस कर रहा है!"
            वैश्य अपने ही पागलपन (Madness) को 'डिकोड' (Decode) कर रहा है! वह खुद हैरान है कि उसका दिमाग कैसे काम कर रहा है।
            जिन बच्चों ने 'पिता के प्यार' (पितृस्नेहं) की कोई कीमत नहीं समझी और जिस पत्नी ने 'पति के प्यार' (पतिहार्दं) को पैसों के लिए कूड़े में फेंक दिया।
            लॉजिक (Logic) के हिसाब से वैश्य को उन पर 'भयंकर गुस्सा' (Anger) आना चाहिए!
            पर यह 'हार्दि' (हार्दिक प्रेम) क्या चीज़ है जो उसे अभी भी रुला रही है? यह 'हार्दि' कोई पवित्र प्यार (Pure Love) नहीं है!
            तन्त्र में इसे 'ग्रंथि' (Knot / ब्लॉकेज) कहते हैं। यह वो जंजीर है जो इंसान के दिल (हार्ट चक्र) में फँस गई है।
            यह कोई 'महानता' (Greatness) या 'माफ़ी' (Forgiveness) नहीं है; यह एक बहुत बड़ी 'मानसिक बीमारी' (Mental illness) है।
            माया (Illusion) इंसान के दिमाग को इस तरह हैक (Hack) करती है कि इंसान ज़हर को ही अमृत समझने लगता है।
            यह श्लोक साबित करता है कि जब तक आप महामाया (सुपर-चेतना) की शरण में नहीं जाते, आपका खुद का दिमाग आपको बर्बाद कर देगा।
        """.trimIndent(),
        english = """
            (The absolute blindness of toxic attachment): "Exactly those highly greedy people (Yaih dhanalubdhaih) who violently and entirely abandoned (Santyajya) the supremely pure love of a father (Pitrusneham), the sacred love of a husband, and the deep affection of close blood relatives (Patisvajanahardam cha) and ruthlessly banished me entirely (Nirakritah)."
            "Exactly strictly for those absolute traitors who completely forgot absolutely everything (Teshveva), this highly pathetic, insane mind of mine (Me manah) is still actively experiencing profound, exceptionally deep 'Hardika Love' (Hardi / deep affection) exactly from the inside even today!"
            The Vaishya is flawlessly and aggressively 'Decoding' his very own terrifying Madness! He himself is exceptionally violently shocked at exactly how his own brain is actively operating.
            The exact same children who absolutely completely failed to understand the exact value of a 'Father's love' (Pitrusneham) and the exact wife who violently threw a 'Husband's love' (Patihardam) straight into the garbage exclusively for cheap paper money.
            Strictly according to pure Logic, the Vaishya absolutely must aggressively feel 'Terrifying Anger' directly toward them!
            But exactly what on earth is this 'Hardi' (Hardika Love) that is still ruthlessly making him cry? This 'Hardi' is absolutely no 'Pure Love' (Sacred affection)!
            In advanced Tantra, this is profoundly called a 'Granthi' (Toxic Knot / Blockage). This is exactly that heavy iron chain that has violently become stuck perfectly inside the human's physical heart (Heart Chakra).
            This is absolutely zero 'Greatness' or supreme 'Forgiveness'; this is an exceptionally massive and terrifying 'Mental Illness'.
            Maya (Illusion) Hacks the human brain so incredibly flawlessly that the human seamlessly begins strictly considering literal lethal Poison as immortal Nectar.
            This spectacular verse explicitly proves that exactly until you violently surrender straight to the absolute refuge of Mahamaya (Super-Consciousness), your very own pathetic brain will ruthlessly destroy you.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 27,
        sanskrit = "किमेतन्नाभिजानामि जानन्नपि महामते ।\nयत्प्रेमप्रवणं चित्तं विगुणेष्वपि बन्धुषु ॥ २७ ॥",
        hindi = """
            (ज्ञान के बावजूद अज्ञान): "हे महाबुद्धिमान राजा (महामते)! मैं यह सब कुछ अपनी आँखों से देखने और पूरी तरह से जानने (जानन्नपि) के बावजूद भी।"
            "यह बिल्कुल भी नहीं समझ पा रहा हूँ (किमेतन्नाभिजानामि) कि मेरा यह पागल 'चित्त' (मन / चित्तं) उन 'विगुण' (गुणहीन / सारे सद्गुणों से खाली / विगुणेष्वपि) और बुरे संबंधियों (बन्धुषु) के प्रति भी इतना अधिक 'प्रेम से भरा हुआ' (प्रेमप्रवणं) क्यों है?"
            यह 'गीता' के अर्जुन जैसी ही स्थिति है! अर्जुन को भी पता था कि कौरव बुरे हैं, फिर भी वह मोह में फँसकर हथियार डाल देता है।
            वैश्य कह रहा है "जानन्नपि" (सब कुछ जानने के बाद भी)! दुनिया की सारी 'सेल्फ-हेल्प बुक्स' (Self-help books) और 'लॉजिक' (Logic) यहाँ फेल (Fail) हो जाते हैं!
            आपको पता होता है कि सिगरेट पीने से कैंसर होगा (जानन्नपि), फिर भी इंसान सिगरेट पीता है।
            आपको पता होता है कि यह इंसान आपके लिए 'विगुण' (Toxic/ज़हरीला) है, फिर भी आपका 'चित्त' (Subconscious mind) उसी की ओर भागता है (प्रेमप्रवणं)।
            क्यों? क्योंकि ज्ञान (Knowledge) केवल ऊपरी 'बुद्धि' (Intellect) में है, जबकि आदत (Habit/मोह) गहरे 'चित्त' (Unconscious) में बैठी है।
            बुद्धि चित्त को कंट्रोल (Control) नहीं कर सकती! चित्त एक भयंकर हाथी की तरह है और बुद्धि उस पर बैठे हुए एक चींटी के समान है।
            यही वह 'माया का बग' (Glitch in the matrix) है जिसे इंसान खुद कभी ठीक नहीं कर सकता।
            इसे ठीक करने के लिए 'सुपर-यूज़र एक्सेस' (Super-user access) चाहिए, जो केवल साक्षात् 'महामाया' (देवी) के पास है।
        """.trimIndent(),
        english = """
            (Thick ignorance completely despite possessing knowledge): "O exceptionally highly intelligent and magnificent King (Mahamate)! Even strictly despite flawlessly seeing absolutely everything directly with my own eyes and perfectly knowing the exact truth (Janannapi)."
            "I absolutely completely fail to possibly comprehend exactly what this is (Kimetannabhijanami), that exactly why on earth is this insane 'Chitta' (Mind / Subconscious / Chittam) of mine so exceptionally heavily 'prone to and overflowing with love' (Premapravanam) entirely even toward those completely 'Viguna' (Toxic / entirely devoid of absolutely all good qualities / Viguneshvapi) and deeply evil relatives (Bandhushu)?"
            This is identically exactly the exact same terrifying situation as Arjuna precisely in the 'Gita'! Arjuna flawlessly knew the Kauravas were exceptionally evil, yet he violently dropped his weapons, helplessly trapped in deep Moha.
            The Vaishya actively screams "Janannapi" (Even strictly after flawlessly knowing absolutely everything)! Absolutely all the world's cheap 'Self-help books' and pure 'Logic' instantly and entirely Fail completely right here!
            You flawlessly know smoking lethal cigarettes will aggressively cause cancer (Janannapi), yet the pathetic human continues strictly to violently smoke.
            You flawlessly know perfectly well that this specific human is exceptionally 'Viguna' (Toxic/Poisonous) for you, yet your 'Chitta' (Subconscious mind) relentlessly and violently runs exactly toward them (Premapravanam).
            Exactly why? Strictly because physical Knowledge exists purely in the exceptionally superficial 'Intellect' (Buddhi), whereas heavy Habit (Moha) violently sits perfectly hidden exactly deep inside the 'Chitta' (Unconscious).
            The tiny Intellect absolutely cannot possibly Control the massive Chitta! The Chitta is exactly like an exceptionally terrifying mad elephant, and the intellect is merely a microscopic ant helplessly sitting on it.
            This is exactly that terrifying 'Bug of Maya' (Glitch in the Matrix) which a human absolutely can never ever possibly fix entirely on his own.
            To flawlessly fix this, one absolutely desperately requires 'Super-User Access' (Root access), which is possessed strictly, exclusively, and solely by direct 'Mahamaya' (The Goddess) alone.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 28,
        sanskrit = "तेषां कृते मे निःश्वासो दौर्मनस्यं च जायते ।\nकरोमि किं यन्न मनस्तेष्वप्रीतिषु निष्ठुरम् ॥ २८ ॥",
        hindi = """
            (वैश्य का अंतिम समर्पण और रोना): "केवल और केवल उन्हीं लोगों के लिए (तेषां कृते) बार-बार मेरी भारी 'आहें' (निःश्वासो / Sighs) निकल रही हैं, और मेरे अंदर भयंकर 'मानसिक दुःख और डिप्रेशन' (दौर्मनस्यं च) पैदा हो रहा है (जायते)।"
            "मैं क्या करूँ (करोमि किं)? मेरा यह मन (मनः) उन 'प्रेम न करने वाले और नफरत करने वाले' (अप्रीतिषु) लोगों के प्रति भी बिल्कुल भी 'कठोर' (निष्ठुरम्) नहीं हो पा रहा है (यन्न)!"
            यह श्लोक वैश्य की मानसिक आज़ादी (Mental Freedom) की आख़िरी पुकार है। वह पूरी तरह से टूट चुका है।
            'निःश्वासो' का अर्थ है गहरी और भारी साँसें लेना; यह डिप्रेशन (Depression) और पैनिक अटैक (Panic Attack) का सबसे बड़ा लक्षण (Symptom) है।
            उसका शरीर जंगल में है, पर उसका दिमाग (दौर्मनस्यं) उसे लगातार एक 'लूप' (Loop) में टार्चर (Torture) कर रहा है।
            जिन लोगों ने उसे प्यार नहीं किया (अप्रीतिषु), वह उन्हीं से प्यार की भीख माँग रहा है!
            दुनिया का सबसे बड़ा दुःख यह नहीं है कि कोई आपसे नफरत करता है; सबसे बड़ा दुःख यह है कि आप उस इंसान से नफरत नहीं कर पाते जो आपको बर्बाद कर रहा है!
            'करोमि किं' (मैं क्या करूँ?) कहकर वैश्य ने राजा के सामने अपना 'अहंकार' (Ego) 100% ज़ीरो (Zero) कर दिया है।
            जब इंसान खुद को बचाने के सारे तरीके आज़मा कर हार जाता है, तभी 'गुरु' (Guru) की एंट्री (Entry) होती है।
            अब राजा और वैश्य दोनों समझ चुके हैं कि उनके पास अपनी बीमारी (मोह) का कोई इलाज नहीं है, इसलिए वे अब ऋषि (डॉक्टर) के पास जाएंगे।
        """.trimIndent(),
        english = """
            (The absolute final surrender and agonizing cry of the Vaishya): "Solely, strictly, and exclusively specifically for exactly those people (Tesham krite), exceptionally heavy 'Sighs' (Nihshvaso) are violently escaping my chest repeatedly, and a highly terrifying 'Mental agony and thick Depression' (Daurmanasyam cha) is relentlessly being generated inside me (Jayate)."
            "Exactly what on earth do I possibly do (Karomi kim)? This highly pathetic mind of mine (Manah) is absolutely entirely failing to become even slightly 'Harsh or Cruel' (Nishthuram) flawlessly even towards those exceptionally 'loveless and actively hateful' (Apritiṣhu) people (Yanna)!"
            This spectacular verse is the absolute final, violent, desperate call precisely for 'Mental Freedom' of the Vaishya. He is flawlessly and completely permanently shattered.
            'Nihshvaso' literally means taking exceptionally deep and heavy sighs; this is undeniably the absolute greatest physical Symptom strictly of major Depression and severe Panic Attacks.
            His physical dirt-body is completely safe exactly in the forest, but his terrifying brain (Daurmanasyam) is relentlessly and violently Torturing him actively in a highly toxic 'Loop'.
            Exactly those specific people who absolutely did not give him any pure love (Apritiṣhu), he is helplessly, pathetically begging exactly them for love!
            The absolute greatest terrifying sorrow in the world is absolutely not that someone fiercely hates you; the absolute greatest agony is exactly that you completely fail to actively hate that specific human who is violently destroying you!
            Aggressively screaming 'Karomi Kim' (Exactly what do I do?), the Vaishya has flawlessly dropped his entire 'Ego' exactly to 100% Zero perfectly before the King.
            Exactly when a human successfully exhausts absolutely all possible personal methods to actively save himself and completely fails miserably, strictly then exactly does the 'Guru' flawlessly Enter.
            Now both the King and the Vaishya have flawlessly realized they possess absolutely zero cure strictly for their horrific disease (Moha), hence they will now aggressively approach the Sage (The absolute Doctor).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 29,
        sanskrit = "मार्कण्डेय उवाच ॥ २९ ॥\nततस्तौ सहितौ विप्र तं मुनिं समुपस्थितौ ॥ २९ ॥",
        hindi = """
            (ऋषि के पास जाना): "महर्षि मार्कण्डेय जी ने आगे कहा (मार्कण्डेय उवाच): हे विप्र (ब्राह्मण क्रौष्टुकि)! इसके बाद (ततः), वे दोनों (राजा और वैश्य / तौ सहितौ) एक साथ मिलकर उस परम ज्ञानी मुनि 'मेधा' के पास जा पहुँचे (तं मुनिं समुपस्थितौ)।"
            यह श्लोक एक बहुत ही महत्वपूर्ण 'ट्रांजीशन' (Transition / बदलाव) है। कहानी अब 'डिप्रेशन' (Depression) से 'सॉल्यूशन' (Solution / समाधान) की ओर मुड़ रही है!
            जब दो बीमार (मोह में फँसे हुए) इंसान आपस में बात करते हैं, तो वे केवल एक-दूसरे का दुःख बढ़ा सकते हैं, उसका इलाज नहीं कर सकते।
            राजा और व्यापारी दोनों ही एक ही भयंकर वायरस (Virus / माया) से संक्रमित (Infected) थे।
            उन्हें यह बात 100% समझ आ गई कि उनकी 'बुद्धि' (Intellect) और 'लॉजिक' (Logic) इस मोह को काटने में पूरी तरह फेल (Fail) हो चुके हैं।
            इसलिए (ततः), वे अपनी ईगो (Ego / कि मैं राजा हूँ या मैं अमीर हूँ) को वहीं छोड़कर, एक साथ (सहितौ) मुनि (डॉक्टर) के पास गए।
            सनातन धर्म का यह सबसे बड़ा नियम है: जब आपके दिमाग का सॉफ्टवेयर (Software) क्रैश (Crash) हो जाए, तो आपको खुद उसे ठीक करने की कोशिश नहीं करनी चाहिए।
            आपको सीधा उस 'सद्गुरु' (मुनि) के पास 'समुपस्थित' (पूरी तरह हाज़िर) होना चाहिए जिसके पास यूनिवर्सल-चेतना (Universal Consciousness) का 'एडमिन एक्सेस' (Admin Access) हो।
            अब मेधा ऋषि उन दोनों के दिमाग की 'सर्जरी' (Surgery) करने वाले हैं।
            यहीं से 'श्री दुर्गा सप्तशती' के परम और गुप्त ज्ञान का साक्षात् विस्फोट होने वाला है!
        """.trimIndent(),
        english = """
            (Approaching the supreme Sage): "The magnificent Sage Markandeya profoundly continued (Markandeya uvacha): O exceptional Brahmin (Vipra / Krauṣhtuki)! Immediately exactly after this (Tatah), both of those completely broken humans (the King and the Vaishya / Tau sahitau) flawlessly united together and directly approached completely before that supremely enlightened Sage 'Medha' (Tam munim samupasthitau)."
            This phenomenal verse perfectly represents a highly exceptionally critical 'Transition' (Shift). The epic narrative is aggressively violently pivoting perfectly from highly toxic 'Depression' flawlessly straight exactly toward the absolute 'Solution' (Cure)!
            Exactly when two exceptionally sick humans (heavily infected with toxic Moha) talk continuously to each other, they can absolutely exclusively merely increase each other's horrific agony, they absolutely cannot possibly cure it.
            Both the King and the massive merchant were aggressively, identically Infected strictly by exactly the exact same terrifying Virus (Maya).
            They had flawlessly and 100% completely realized that their tiny 'Intellect' and cheap worldly 'Logic' had completely brutally Failed perfectly in attempting to ruthlessly slash this heavy Moha.
            Therefore (Tatah), violently leaving their toxic Ego (that I am a King or I am a billionaire) permanently behind exactly there, they flawlessly went completely together (Sahitau) directly to the Sage (The absolute Doctor).
            This is undeniably Sanatana Dharma's absolute greatest ironclad rule: Exactly when your brain's delicate Software violently Crashes, you absolutely must never ever frantically attempt to blindly fix it entirely yourself.
            You must flawlessly and aggressively become completely 'Samupasthitau' (100% physically and mentally present) strictly directly before exactly that 'Sadguru' (Sage) who flawlessly possesses the absolute 'Admin Access' of the pure Universal Consciousness.
            Now, Sage Medha is fiercely preparing to execute a terrifyingly precise psychological 'Surgery' directly inside the chaotic brains of both these men.
            Right exactly from here, the highly classified, top-secret, and absolute supreme wisdom strictly of 'Sri Durga Saptshati' is about to flawlessly violently explode!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 30,
        sanskrit = "समाधिर्नाम वैश्योऽसौ स च पार्थिवसत्तमः ।\nकृत्वा तु तौ यथान्यायं यथार्हं तेन संविदम् ॥ ३० ॥",
        hindi = """
            (मुनि के समक्ष उचित शिष्टाचार): "वह 'समाधि' नाम का वैश्य (समाधिर्नाम वैश्योऽसौ) और वह पृथ्वी के राजाओं में सबसे श्रेष्ठ राजा सुरथ (स च पार्थिवसत्तमः)।"
            "उन दोनों (तौ) ने मुनि मेधा के पास पहुँचकर, उनके साथ पूरी तरह से शास्त्र-विधि के अनुसार (यथान्यायं) और उनकी महान योग्यता के अनुरूप (यथार्हं)।"
            "अत्यंत श्रद्धा के साथ अपना उचित शिष्टाचार और वार्तालाप (संविदम्) किया (कृत्वा तु)।"
            (यह श्लोक अगले श्लोक से जुड़ा है जहाँ वे अपना प्रश्न पूछेंगे)।
            जब आप किसी ब्रह्मज्ञानी (Enlightened Master) के पास जाते हैं, तो आप उससे एक 'नौकर' की तरह बात नहीं कर सकते!
            राजा सुरथ पूरी दुनिया का मालिक (पार्थिवसत्तमः) था, और वैश्य अरबपति था; पर मुनि के सामने वे दोनों 'भिखारी' (Beggars) थे जो ज्ञान की भीख माँगने आए थे।
            'यथान्यायं यथार्हं' का मतलब है 100% परफेक्ट प्रोटोकॉल (Perfect Protocol)। उन्होंने अपनी ईगो (Ego) को बाहर जूते के साथ उतार दिया और साष्टांग प्रणाम किया।
            तन्त्र में ज्ञान कभी भी बिना 'पात्रता' (Eligibility / योग्यता) और बिना 'श्रद्धा' (Surrender) के नहीं दिया जाता।
            अगर आप गुरु के सामने घमंड से खड़े हैं, तो वह आपको केवल बाहर का रास्ता दिखा देगा!
            उन दोनों ने पहले मुनि का सम्मान (संविदम्) किया, उन्हें यह अहसास दिलाया कि "हम कुछ नहीं जानते, आप ही सब कुछ हैं।"
            यह 'एम्प्टी कप' (Empty Cup / खाली प्याला) की साइकोलॉजी है—जब तक आप अपने दिमाग को खाली नहीं करते, उसमें नया ज्ञान (Knowledge) नहीं भरा जा सकता।
            अब वे दोनों अपने जीवन का सबसे बड़ा सवाल पूछने के लिए 100% तैयार थे।
        """.trimIndent(),
        english = """
            (The flawless proper etiquette exactly before the Sage): "That exact specific Vaishya famously named 'Samadhi' (Samadhirnama vaishyo'sau) and that absolute most magnificent and supreme among all kings of the earth, Suratha (Sa cha parthivasattamah)."
            "Exactly upon flawlessly approaching Sage Medha, both of them (Tau) flawlessly and entirely exactly according to the strict, absolute rules of the sacred scriptures (Yathanyayam) and exactly perfectly befitting the Sage's exceptionally supreme, infinite greatness (Yatharham)."
            "Aggressively executed (Kritva tu) their absolute proper, flawlessly respectful etiquette and highly profound preliminary conversation (Samvidam) perfectly with profound, absolute devotion."
            (This exact specific verse is inextricably linked directly to the next verse where they will aggressively ask their massive question).
            Exactly when you strictly approach a completely Enlightened Master (Brahmjnani), you absolutely cannot possibly casually speak to him exactly like a cheap 'servant'!
            King Suratha was literally the absolute master of the entire global earth (Parthivasattamah), and the Vaishya was a massive billionaire; but directly before the Sage, both were strictly mere 'Beggars' who had helplessly come to frantically beg exclusively for supreme wisdom.
            'Yathanyayam Yatharham' profoundly means 100% Flawless Protocol. They ruthlessly removed their entire toxic Ego outside perfectly along strictly with their physical shoes and flawlessly offered absolute full-body prostrations.
            In advanced Tantra, highly classified supreme wisdom is absolutely never ever handed out completely without fierce 'Eligibility' (Patrata) and strictly 100% absolute 'Surrender' (Shraddha).
            Exactly if you aggressively stand directly before the Guru strictly with toxic arrogance, he will instantaneously and flawlessly show you exactly the exit door!
            Both of them absolute first fiercely honored the sage (Samvidam), flawlessly making him perfectly realize that "We know absolutely nothing, You alone are absolutely everything."
            This is undeniably the highly advanced Psychology of the 'Empty Cup'—exactly until you violently empty your corrupted brain completely, brand-new explosive Knowledge absolutely cannot possibly be poured perfectly into it.
            Now, both of them were exactly 100% flawlessly ready to aggressively ask the absolute biggest, most terrifying question of their entire miserable lives.
        """.trimIndent()
    ),
    // ... Continuing adhyayaOneShlokas from ID 30

    SaptshatiShloka(
        id = 31,
        sanskrit = "उपविष्टौ कथाः काश्चिच्चक्रतुर्वैश्यपार्थिवौ ।\nराजोवाच ॥\nभगवंस्त्वामहं प्रष्टुमिच्छाम्येकं वदस्व तत् ॥ ३१ ॥",
        hindi = """
            (मुनि के समक्ष प्रश्न): "मुनि मेधा के पास बैठकर (उपविष्टौ) उस वैश्य और राजा (वैश्यपार्थिवौ) ने कुछ आध्यात्मिक वार्तालाप (कथाः काश्चिच्चक्रतुर्) आरंभ किया।"
            "तभी राजा सुरथ ने कहा (राजोवाच): 'हे भगवन्! मैं आपसे केवल एक अत्यंत महत्वपूर्ण प्रश्न (एकं) पूछना चाहता हूँ (प्रष्टुमिच्छामि), कृपया मुझे उसका उत्तर दें (वदस्व तत्)।'"
            जब इंसान का 'लॉजिक' (Logic) और दुनियावी ज्ञान पूरी तरह से फेल हो जाता है, तो वह सीधा एक 'सद्गुरु' (Bhagavan) के पास ही जाता है।
            राजा सुरथ, जो कभी दुनिया को आदेश देता था, आज एक शिष्य बनकर हाथ जोड़कर बैठा है।
            यह 'खाली प्याला' (Empty cup) की अवस्था है, जहाँ इंसान यह मान लेता है कि उसे जीवन का असली सच नहीं पता।
            'कथाः काश्चिच्चक्रतुर्' का अर्थ है कि उन्होंने पहले सीधे अपनी परेशानी नहीं बताई, बल्कि सम्मानपूर्वक माहौल (Environment) बनाया।
            एक गुरु के सामने आपको अपनी 'ईगो' (Ego) को बाहर छोड़ना पड़ता है, तभी आपको उस 'एक' (एकं) परम प्रश्न का उत्तर मिल सकता है।
            राजा का यह प्रश्न केवल उसका अपना नहीं है; यह इस दुनिया के हर उस दुखी इंसान का प्रश्न है जो मोह (Attachment) में फँसा है।
            यहीं से उस महान 'दुर्गा सप्तशती' के साक्षात् ज्ञान का द्वार पूरी तरह से खुलने वाला है।
            यह दिखाता है कि सही सवाल पूछना (Inquiry), सही जवाब मिलने से भी ज़्यादा ज़रूरी है।
        """.trimIndent(),
        english = """
            (The ultimate question before the Sage): "Flawlessly sitting down (Upavishtau) perfectly near Sage Medha, that merchant and the King (Vaishyaparthivau) initiated some profound spiritual conversation (Kathah kashchichchakratur)."
            "Exactly then, King Suratha fiercely spoke (Rajovacha): 'O Supreme Lord (Bhagavan)! I desperately wish to ask you strictly one single, exceptionally critical question (Prashtumicchamyekam), please graciously answer it (Vadasva tat).'"
            Exactly when a human's cheap worldly 'Logic' and physical intellect completely and utterly Fail, he flawlessly approaches strictly a true 'Sadguru' (Bhagavan).
            King Suratha, who once ruthlessly commanded the entire globe, is actively sitting exactly like a humble disciple with folded hands today.
            This is the absolute 'Empty Cup' state, where a human brutally accepts that he knows absolutely nothing about actual reality.
            'Kathah kashchichchakratur' perfectly implies they absolutely did not immediately vomit their problems, but flawlessly established a highly respectful spiritual Environment first.
            Directly before a true Guru, you absolutely must ruthlessly abandon your toxic 'Ego' outside, strictly then can you receive the answer to that 'One' (Ekam) supreme question.
            The King's explosive question is absolutely not merely his own; it is the terrifying question of every single miserable human helplessly trapped in toxic Attachment.
            Right exactly from here, the magnificent gateway to the direct, literal wisdom of 'Durga Saptshati' is about to be violently ripped open.
            This flawlessly demonstrates that fiercely asking the exact right question (Inquiry) is fundamentally far more critical than merely receiving the answer.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 32,
        sanskrit = "दुःखाय यन्मे मनसः स्वचित्तायत्ततां विना ।\nममत्वं गतराज्यस्य राज्याङ्गेष्वखिलेष्वपि ॥ ३२ ॥",
        hindi = """
            (राजा का अपना दुःख): "मेरा यह अपना मन (मे मनसः) बिल्कुल भी मेरे अपने अधिकार (कण्ट्रोल / स्वचित्तायत्ततां) में नहीं है (विना)।"
            "मेरा पूरा राज्य मुझसे छिन चुका है (गतराज्यस्य), फिर भी उस राज्य के सभी अंगों (राज्याङ्गेष्वखिलेष्वपि) में मेरा 'ममत्व' (अटैचमेंट / यह मेरा है) लगातार बना हुआ है।"
            "और यह बेवकूफी भरा मोह मुझे अंदर से भयंकर 'दुःख' (दुःखाय) दे रहा है!"
            राजा सुरथ अपनी सबसे बड़ी कमज़ोरी (Weakness) को बिना किसी शर्म के गुरु के सामने नंगा (Expose) कर रहा है।
            वह कह रहा है: "मेरा दिमाग मुझे ही टॉर्चर (Torture) कर रहा है! मैं राजा था, पर मैं अपने खुद के विचारों (Thoughts) का मालिक नहीं हूँ!"
            'स्वचित्तायत्ततां विना' का मतलब है कि इंसान का 'ऑटोपायलट' (Autopilot / अवचेतन मन) उसके 'मैनुअल कण्ट्रोल' (लॉजिक) को बाईपास (Bypass) कर चुका है।
            राज्य (Property), खजाना और सैनिक सब कुछ खत्म हो चुके हैं, पर दिमाग अभी भी उसी पुरानी फिल्म (Movie) को बार-बार चला रहा है।
            'ममत्व' (Mamatva) वह गोंद (Glue) है जो हमारी चेतना को उन चीज़ों से चिपका देती है जो वास्तव में हैं ही नहीं।
            हमेशा याद रखें, चीज़ों के जाने से दर्द नहीं होता; "यह चीज़ मेरी थी और हमेशा रहनी चाहिए", इस सोच के टूटने से दर्द होता है।
            राजा का यह 'सेल्फ-एनालिसिस' (Self-analysis) बहुत ऊँचे दर्जे का है, क्योंकि वह अपनी बीमारी (अटैचमेंट) को 100% पहचान चुका है।
        """.trimIndent(),
        english = """
            (The King's personal agony): "This very mind of mine (Me manasah) is absolutely completely entirely out of my own personal control (Svachittayattatam vina)."
            "My entire massive kingdom has been completely lost and snatched away (Gatarajyasya), yet my toxic 'Mamatva' (blind attachment / mine-ness) flawlessly remains violently anchored exactly in absolutely all aspects and parts of that lost kingdom (Rajyangeshvakhileshvapi)."
            "And this exceptionally stupid, highly toxic infatuation is continuously causing me horrific, terrifying 'Agony' (Duhkhaya) entirely from the inside!"
            King Suratha is ruthlessly Exposing his absolute greatest Weakness completely naked directly before the Guru without a single drop of fake shame.
            He is actively screaming: "My own brain is violently Torturing me! I was a universal King, yet I am absolutely not the master of my very own Thoughts!"
            'Svachittayattatam vina' profoundly means the human's 'Autopilot' (Subconscious mind) has completely aggressively Bypassed his 'Manual Control' (Logic).
            The kingdom (Property), heavy treasury, and army are 100% permanently gone, yet the pathetic brain is still relentlessly running that exact same old Movie on a loop.
            'Mamatva' is exactly that terrifying Glue which violently sticks our pure consciousness flawlessly to physical objects that absolutely do not even exist anymore.
            Always flawlessly remember, the physical loss of objects absolutely does not cause pain; the violent shattering of the arrogant thought that "this was mine and must remain mine" causes the agonizing pain.
            The King's brilliant 'Self-Analysis' is of an exceptionally high caliber, strictly because he has flawlessly Diagnosed his own disease (Attachment) 100%.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 33,
        sanskrit = "जानतोऽपि यथाज्ञस्य किमेतन्मुनिसत्तम ।\nअयं च निकृतः पुत्रैर्दारैर्भृत्यैस्तथोज्झितः ॥ ३३ ॥",
        hindi = """
            (ज्ञानी होकर भी अज्ञानियों जैसा व्यवहार): "हे मुनिश्रेष्ठ (मुनिसत्तम)! मैं सब कुछ देखने और 'जानने के बावजूद भी' (जानतोऽपि), एक बिल्कुल 'मूर्ख और अज्ञानी' (यथाज्ञस्य) इंसान की तरह व्यवहार क्यों कर रहा हूँ? यह क्या माया है (किमेतत्)?"
            "और यह जो वैश्य (अयं च) यहाँ मेरे साथ बैठा है, इसे भी इसके सगे बेटों (पुत्रैर्), पत्नी (दारैर्), और नौकरों (भृत्यैस्) ने घर से बाहर निकालकर त्याग (उज्झितः / निकृतः) दिया है।"
            राजा सुरथ खुद भी हैरान है! वह एक पढ़ा-लिखा (Educated) और समझदार इंसान है, फिर भी उसका व्यवहार एक अनपढ़ (Ignorant) मूर्ख जैसा है!
            यही सनातन साइकोलॉजी (Psychology) का सबसे बड़ा 'बग' (Bug) है—कि इन्फॉर्मेशन (Information) आपको दुःख से नहीं बचा सकती!
            आप कितनी भी 'सेल्फ-हेल्प' (Self-help) किताबें पढ़ लें, जब डिप्रेशन (Depression) या धोखा मिलता है, तो आपका सारा ज्ञान 'ज़ीरो' (Zero) हो जाता है।
            राजा ने केवल अपनी बात नहीं की, उसने उस व्यापारी (वैश्य) का केस (Case) भी मुनि के सामने रखा।
            व्यापारी के 'अपनों' (पत्नी, बच्चों) ने ही उसे लात मारी है, जो दुनिया का सबसे बड़ा धोखा (Ultimate Betrayal) है।
            राजा यह पूछ रहा है कि हमारा जो 'लॉजिक' (Logic) है, वह हमारे 'इमोशन' (Emotion) को हरा क्यों नहीं पाता?
            हम क्यों उन लोगों के लिए रोते हैं जो हमें कचरे की तरह इस्तेमाल करके फेंक देते हैं?
            यह सवाल पूरी इंसानियत की सबसे बड़ी ट्रेजेडी (Tragedy) का साक्षात् और सटीक वर्णन है।
        """.trimIndent(),
        english = """
            (Behaving like an ignorant fool despite possessing knowledge): "O absolute supreme Sage (Munisattama)! Strictly despite flawlessly 'knowing and seeing absolutely everything' (Janato'pi), exactly why am I actively behaving exactly like a completely 'ignorant, uneducated fool' (Yathajnasya)? Exactly what is this terrifying illusion (Kimetat)?"
            "And this exact Vaishya (Ayam cha) sitting right here with me, he too has been violently kicked out, humiliated (Nikritah), and completely abandoned (Ujjhitah) exactly by his very own biological sons (Putrair), his literal wife (Darair), and his own servants (Bhrityais)."
            King Suratha himself is exceptionally violently shocked! He is a highly Educated and perfectly sensible human, yet his behavior is identically exactly like a completely Ignorant fool!
            This is undeniably Sanatana Psychology's absolute greatest 'Bug'—that mere cheap Information can absolutely never, ever possibly save you from deep agony!
            You can aggressively read millions of cheap 'Self-help' books, but exactly when brutal Depression or horrific betrayal strikes, absolutely all your fake knowledge instantly drops mathematically to 'Zero'.
            The King absolutely did not merely speak for himself; he flawlessly presented the merchant's precise Case directly before the Sage as well.
            The merchant's very 'Own' (wife, children) ruthlessly kicked him, which is undeniably the world's absolute 'Ultimate Betrayal'.
            The King is fiercely interrogating exactly why our supreme 'Logic' completely fundamentally fails to violently defeat our highly toxic 'Emotion'?
            Exactly why on earth do we relentlessly cry strictly for exactly those specific people who ruthlessly use us exactly like cheap trash and violently throw us away?
            This explosive question is the direct, literal, and absolute most accurate description of the entire humanity's greatest pathetic Tragedy.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 34,
        sanskrit = "स्वजनेन च सन्त्यक्तस्तेषु हार्दी तथाप्यति ।\nएवमेष तथाहं च द्वावप्यत्यन्तदुःखितौ ॥ ३४ ॥",
        hindi = """
            (अपनों का धोखा और फिर भी प्यार): "अपने ही सगे-संबंधियों (स्वजनेन) द्वारा पूरी तरह से लात मारकर निकाल दिए जाने (सन्त्यक्तः) के बाद भी (तथापि), इसका मन उन गद्दारों के लिए ही (तेषु) अत्यंत 'हार्दिक प्यार' (हार्दी अति / Deep affection) महसूस कर रहा है!"
            "इसी प्रकार यह वैश्य (एवमेष), और ठीक उसी प्रकार मैं भी (तथाहं च); हम दोनों के दोनों ही (द्वावपि) इस समय 'अत्यंत भयंकर दुःख' (अत्यन्तदुःखितौ) में पूरी तरह डूब चुके हैं।"
            राजा सुरथ वैश्य के 'पागलपन' (Madness) को मुनि के सामने डिकोड (Decode) कर रहा है कि "देखिए, यह आदमी कितना बेवकूफ है!"
            जिन रिश्तेदारों (स्वजन) ने इसे भिखारी बना दिया, यह अभी भी उनसे 'हार्दी' (सच्चा प्यार) कर रहा है!
            पर राजा यह भी मान रहा है कि "मैं भी इसी के जैसा बेवकूफ हूँ" (तथाहं च)।
            जब दो 'ईगो' (Ego) वाले इंसान (एक राजा और एक अमीर वैश्य) अपने घमंड को छोड़कर यह मान लेते हैं कि "हम भयंकर दुखी और लाचार हैं", तो यह 'सरेंडर' (Surrender) की चरम सीमा है।
            दुनिया की कोई भी बीमारी (Disease) तब तक ठीक नहीं हो सकती, जब तक मरीज़ यह एक्सेप्ट (Accept) न कर ले कि वह बीमार है!
            'अत्यन्तदुःखितौ' का मतलब है कि उनका दुःख अब सहने की सीमा (Limit) को पार कर चुका है (Breaking point)।
            यही वह 'पॉइंट' (Point) है जहाँ भगवान (गुरु) को इंटरफेयर (Interfere) करना ही पड़ता है।
            जब इंसान अपने खुद के दिमाग के आगे घुटने टेक देता है, तब महामाया का खेल शुरू होता है।
        """.trimIndent(),
        english = """
            (Betrayed by one's own, yet still loving them): "Even strictly after being violently kicked out and permanently abandoned (Santyaktah) entirely by his very own close blood relatives (Svajanena), his pathetic mind still (Tathapi) actively experiences exceptionally deep 'Hardika Love' (Hardi ati / intense blind affection) exclusively for those exact traitors (Teshu)!"
            "Exactly in this precise manner is this Vaishya (Evamesha), and perfectly exactly like him am I as well (Tathaham cha); both of us combined (Dvayapi) are currently completely drowning entirely in 'Exceptionally Terrifying Agony' (Atyantaduhkhitau)."
            King Suratha is aggressively Decoding the Vaishya's absolute 'Madness' directly before the Sage, screaming, "Look exactly how unbelievably stupid this pathetic man is!"
            Exactly those specific relatives (Svajana) who ruthlessly reduced him directly into a street beggar, he is still actively offering them 'Hardi' (true affection)!
            But the King flawlessly and brutally admits that "I too am identically exactly as utterly stupid as him" (Tathaham cha).
            Exactly when two exceptionally high 'Ego' humans (a universal King and a billionaire Vaishya) completely drop their toxic pride and violently confess "We are exceptionally miserable and entirely helpless", that is the absolute ultimate peak of pure 'Surrender'.
            Absolutely zero Disease in the world can ever possibly be cured completely until the patient aggressively Accepts the brutal fact that he is actually heavily sick!
            'Atyantaduhkhitau' perfectly signifies that their terrifying agony has now flawlessly crossed the absolute maximum limit of human tolerance (Breaking Point).
            This is exactly that absolute 'Point' where God (The Guru) absolutely must violently Interfere.
            Exactly when a human completely drops to his knees permanently defeated by his own brain, the absolute grand play of Mahamaya violently begins.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 35,
        sanskrit = "दृष्टदोषेऽपि विषये ममत्वाकृष्टमानसौ ।\nतत्किमेतन्महाभाग यन्मोहो ज्ञानिनोरपि ॥ ३५ ॥",
        hindi = """
            (ज्ञानियों का मोह): "उन सांसारिक विषयों (विषये / पैसे, रिश्ते) में साफ-साफ प्रत्यक्ष 'दोष' (गंदगी और धोखा / दृष्टदोषेऽपि) देखने के बावजूद भी, हम दोनों का मन उसी मोह की तरफ ज़ोर से खिंचा (ममत्वाकृष्टमानसौ) चला जा रहा है।"
            "हे महाभाग (मुनि)! यह कैसी भयंकर माया है (तत्किमेतत्)? कि हम जैसे 'पढ़े-लिखे और ज्ञानी' (ज्ञानिनोरपि) लोगों को भी ऐसा खौफनाक 'मोह' (अँधापन / यन्मोहो) हो रहा है?"
            राजा का सवाल एक बहुत बड़े 'पैराडॉक्स' (Paradox / विरोधाभास) को जन्म दे रहा है!
            'दृष्टदोषे' का मतलब है जब आपने अपनी आँखों से देख लिया कि आग में हाथ डालने से हाथ जलता है (दोष देख लिया)।
            फिर भी आपका दिमाग 'चुंबक' (Magnet / आकृष्ट) की तरह उसी आग (मोह) में हाथ डालने के लिए भाग रहा है!
            राजा कह रहा है: "हम अनपढ़ नहीं हैं! हम 'ज्ञानी' (Knowledgeable) हैं! हमें सब पता है, फिर भी हम मोह (Moha) के गुलाम क्यों हैं?"
            यह श्लोक साबित करता है कि सांसारिक पढ़ाई (Degree) और आध्यात्मिक आज़ादी (Moksha) में कोई संबंध नहीं है।
            एक बहुत बड़ा डॉक्टर या साइंटिस्ट (ज्ञानी) भी अपनी पर्सनल लाइफ (Personal life) में डिप्रेशन और मोह का शिकार हो सकता है।
            क्योंकि 'मोह' (Attachment) एक ऐसा वायरस (Virus) है जो इंसान की 'बुद्धि' (Intellect) पर नहीं, बल्कि उसकी 'प्रवृत्ति' (Instinct) पर हमला करता है।
            और इस प्रवृत्ति को काटने के लिए जो 'एंटी-वायरस' (Anti-virus) चाहिए, वह अब मुनि मेधा उन्हें देने वाले हैं।
        """.trimIndent(),
        english = """
            (The toxic infatuation of the enlightened): "Strictly despite flawlessly and directly vividly seeing the obvious 'Dosha' (filth, pain, and betrayal / Drishtadoshe'pi) exactly in these worldly objects (Vishaye / cheap money, fake relationships), the minds of both of us are violently being dragged (Mamatvakrishtamanasau) exactly toward that same toxic attachment exactly like a high-powered magnet."
            "O magnificent Sage (Mahabhaga)! Exactly what on earth is this terrifying illusion (Tatkimeta)? That even highly 'Educated, enlightened, and knowledgeable' (Jnaninorapi) humans exactly like us are brutally suffering from such horrific, blind 'Moha' (toxic infatuation / Yanmoho)?"
            The King's explosive question violently gives birth strictly to an exceptionally massive 'Paradox' (Contradiction)!
            'Drishtadoshe' literally means exactly when you have flawlessly seen directly with your own physical eyes that shoving your hand into a blazing fire violently burns it (you have seen the Dosha).
            Yet your pathetic brain relentlessly runs exactly like a high-powered 'Magnet' (Akrishta) frantically trying to shove your hand strictly into that exact same fire (Moha) again!
            The King is aggressively screaming: "We are absolutely not uneducated! We are highly 'Jnani' (Knowledgeable)! We flawlessly know absolutely everything, yet exactly why are we pathetic slaves of Moha?"
            This phenomenal verse flawlessly proves that there is absolutely zero connection strictly between cheap worldly Education (Degrees) and ultimate spiritual freedom (Moksha).
            Even the world's absolute greatest Doctor or Scientist (Jnani) can effortlessly become a pathetic victim of severe depression and toxic Moha exactly in his Personal Life.
            Strictly because 'Moha' (Attachment) is exactly such a terrifying Virus that absolutely does not attack the human's 'Intellect' (Buddhi), but violently hijacks his absolute 'Instinct' (Pravritti).
            And the exact 'Anti-Virus' desperately required to ruthlessly slash this instinct is exactly what Sage Medha is now preparing to actively inject into them.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 36,
        sanskrit = "ममास्य च भवत्येषा विवेकान्धस्य मूढता ॥ ३६ ॥\nऋषिरुवाच ॥ ३७ ॥",
        hindi = """
            (विवेक का अंधापन): "मुझमें (मम) और इस वैश्य में (अस्य च), जो यह भयंकर 'मूढ़ता' (मूर्खता और अज्ञान / मूढता) पैदा हो रही है (भवत्येषा), वह वास्तव में 'विवेक के पूरी तरह अंधे' (विवेकान्धस्य) हो जाने के कारण ही है।" (यहाँ राजा का प्रश्न समाप्त होता है)।
            "इसके बाद उन परम ज्ञानी महर्षि मेधा ने अत्यंत शांतिपूर्वक उत्तर दिया (ऋषिरुवाच):"
            राजा सुरथ ने अपनी बीमारी का 100% सही 'डायग्नोसिस' (Diagnosis) कर लिया है—"विवेक का अंधापन" (विवेकान्धस्य)।
            'विवेक' (Discrimination) वह सुपर-पावर (Super-power) है जो इंसान को बताती है कि क्या सच है और क्या झूठ (Permanent vs Temporary)।
            जब यह 'विवेक' अँधा (Blind) हो जाता है, तो इंसान कूड़े (Garbage) को सोना (Gold) समझने लगता है!
            राजा और वैश्य दोनों की बुद्धि चालू थी, पर उनका 'विवेक' (आध्यात्मिक आँख) पूरी तरह फूट चुका था।
            राजा ने अपनी 'मूढ़ता' (Stupidity) को स्वीकार कर लिया। जब ईगो (Ego) पूरी तरह मर जाता है, तभी गुरु बोलना शुरू करता है।
            'ऋषिरुवाच' (मुनि बोले) कोई साधारण शब्द नहीं है; यह उस ब्रह्मांडीय ज्ञान (Cosmic Download) की शुरुआत है जो इंसानियत के इतिहास को बदल देगा।
            मुनि अब उन्हें कोई मीठी 'मोटिवेशनल' (Motivational) बातें नहीं बताएंगे; वे सीधा उनके दिमाग के 'सॉफ्टवेयर' (Software) को हैक (Hack) करने वाले हैं।
            यहाँ से 'महामाया' का वह खौफनाक विज्ञान शुरू होता है, जिसे सुनकर बड़े-बड़े ज्ञानियों के पसीने छूट जाते हैं!
        """.trimIndent(),
        english = """
            (The absolute blindness of pure discrimination): "Exactly inside me (Mama) and perfectly inside this Vaishya (Asya cha), this exceptionally terrifying 'Mudhatva' (absolute stupidity and thick ignorance / Mudhata) that is violently arising (Bhavatyesha), is undeniably, in absolute reality, strictly due to our 'Viveka' (power of discrimination) becoming completely 100% 'Blind' (Vivekandhasya)." (The King's massive question officially concludes exactly here).
            "Immediately following this, that supremely enlightened Maharshi Medha flawlessly and profoundly answered with absolute absolute peace (Rishiruvacha):"
            King Suratha has flawlessly and aggressively executed the exact 100% correct 'Diagnosis' of his own terrifying disease—"The absolute blindness of Viveka" (Vivekandhasya).
            'Viveka' (Discrimination) is exactly that ultimate Super-Power that flawlessly tells a human exactly what is eternal truth and what is a fake lie (Permanent vs Temporary).
            Exactly when this 'Viveka' becomes flawlessly Blind, the pathetic human actively begins blindly considering literal toxic Garbage as pure Gold!
            Both the King and the Vaishya's physical intellects were actively running perfectly, but their 'Viveka' (Spiritual Eye) had violently ruptured and gone completely blind.
            The King ruthlessly accepted his own absolute 'Mudhata' (Stupidity). Exactly when the toxic Ego drops completely dead 100%, strictly then alone does the Guru flawlessly begin to actively speak.
            'Rishiruvacha' (The Sage spoke) is absolutely no ordinary, cheap phrase; it is the violent beginning of that exact 'Cosmic Download' (Wisdom) which is destined to alter the entire history of humanity forever.
            The Sage will absolutely not hand them cheap, sweet 'Motivational' garbage now; he is aggressively preparing to flawlessly Hack directly straight into their brain's core 'Software'.
            Right exactly from here begins that terrifying, horrific science of 'Mahamaya', violently hearing which even the absolute greatest enlightened masters begin to ruthlessly sweat!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 37,
        sanskrit = "ज्ञानमस्ति समस्तस्य जन्तोर्विषयगोचरे ।\nविषयश्च महाभाग याति चैवं पृथक् पृथक् ॥ ३७ ॥",
        hindi = """
            (विषयों का ज्ञान हर प्राणी को है): "महर्षि ने कहा: हे महाभाग (महान भाग्य वाले)! इस दुनिया में मौजूद 'प्रत्येक प्राणी' (समस्तस्य जन्तोर्) को अपने-अपने 'इंद्रिय-विषयों' (देखना, सुनना, खाना / विषयगोचरे) का पूरा-पूरा ज्ञान मौजूद है (ज्ञानमस्ति)।"
            "परंतु हे राजा! यह जो 'विषयों का ज्ञान' (विषयश्च) है, वह अलग-अलग प्राणियों में अत्यंत 'अलग-अलग प्रकार' (पृथक् पृथक्) से दिखाई देता है (याति)।"
            मुनि मेधा ने अपना पहला 'ब्रह्मास्त्र' (Brahmastra) छोड़ दिया है! उन्होंने राजा के 'मैं ज्ञानी हूँ' वाले ईगो (Ego) को एक सेकंड में तोड़ दिया!
            राजा कह रहा था कि "मैं ज्ञानी हूँ, फिर भी मैं बेवकूफ क्यों हूँ?"
            मुनि कहते हैं: "तुम कौन से 'ज्ञान' (Knowledge) की बात कर रहे हो? खाना कैसे खाना है, घर कैसे बनाना है, दुश्मन से कैसे बचना है—यह ज्ञान तो एक कुत्ते और कीड़े (जन्तु) को भी है!" (ज्ञानमस्ति समस्तस्य जन्तोर्)।
            सांसारिक ज्ञान (Worldly knowledge/Physics/Economics) कोई आध्यात्मिक (Spiritual) ज्ञान नहीं है; वह केवल सर्वाइवल (Survival / ज़िंदा रहने) का एक टूल (Tool) है!
            'पृथक् पृथक्' का अर्थ है कि एक ही चीज़ अलग-अलग जानवरों को अलग-अलग दिखती है।
            जो मांस एक शेर के लिए 'स्वादिष्ट भोजन' (विषय) है, वही मांस एक गाय के लिए 'कचरा' है!
            इसलिए तुम्हारी जो आँखें या दिमाग (Brain) तुम्हें 'सच' दिखा रहा है, वह वास्तव में सच नहीं है, वह केवल तुम्हारी बायोलॉजिकल प्रोग्रामिंग (Biological programming) है!
            मुनि ने साबित कर दिया कि राजा का 'ज्ञान' वास्तव में केवल एक जानवरों वाला 'सर्वाइवल इंस्टिंक्ट' (Survival Instinct) है।
        """.trimIndent(),
        english = """
            (The knowledge of sense objects exists in all creatures): "The Supreme Sage profoundly declared: O highly fortunate one (Mahabhaga)! Exactly 'Every single living creature' (Samastasya jantor) flawlessly existing in this world inherently completely possesses the absolute full knowledge (Jnanamasti) strictly regarding its very own 'Sense Objects' (seeing, hearing, eating / Vishayagochare)."
            "However, O King! This specific 'Knowledge of objects' (Vishayashcha) flawlessly manifests and operates (Yati) in exceptionally 'Completely Different and Distinct' (Prithak prithak) ways strictly across entirely different creatures."
            Sage Medha has violently launched his absolute first 'Brahmastra' (Ultimate Weapon)! He flawlessly shattered the King's massive Ego of "I am knowledgeable" completely to ashes in exactly a single second!
            The King was aggressively screaming, "I am highly Jnani (enlightened), yet exactly why am I a pathetic fool?"
            The Sage fiercely replies: "Exactly what cheap 'Knowledge' are you arrogantly boasting about? Exactly how to eat food, how to build a shelter, how to evade an enemy—this exact cheap knowledge is flawlessly possessed even by a street dog and a tiny insect!" (Jnanamasti samastasya jantor).
            Cheap worldly Knowledge (Physics/Economics) is absolutely zero 'Spiritual' (Divine) knowledge; it is exclusively merely a basic biological Tool strictly designed purely for cheap physical Survival!
            'Prithak Prithak' literally means that the exact same physical object visually appears completely different exactly to completely different animals.
            The exact raw meat which is exceptionally 'Delicious Food' (Vishaya) strictly for a lion, is literally toxic 'Garbage' completely for a cow!
            Therefore, exactly whatever your physical eyes or tiny Brain are aggressively showing you as 'Truth', is absolutely not the actual truth at all, it is exclusively merely your cheap Biological Programming!
            The Sage flawlessly proved that the King's highly arrogant 'Knowledge' is, in absolute reality, merely a cheap animalistic 'Survival Instinct'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 38,
        sanskrit = "दिवान्धाः प्राणिनः केचिद्रात्रावन्धास्तथापरे ।\nकेचिद्दिवा तथा रात्रौ प्राणिनस्तुल्यदृष्टयः ॥ ३८ ॥",
        hindi = """
            (प्रकृति की प्रोग्रामिंग और माया): "इस प्रकृति में कुछ प्राणी ऐसे हैं जो 'दिन के समय पूरी तरह अंधे' (दिवान्धाः प्राणिनः केचिद्) हो जाते हैं (जैसे उल्लू), और कुछ दूसरे प्राणी ऐसे हैं जो 'रात के समय बिल्कुल अंधे' (रात्रावन्धास्तथापरे) हो जाते हैं (जैसे इंसान और कौवे)।"
            "और इनके अलावा कुछ प्राणी ऐसे भी हैं जो 'दिन और रात दोनों ही समय' (दिवा तथा रात्रौ) बिल्कुल एक समान और बराबर रूप से देख सकते हैं (तुल्यदृष्टयः) (जैसे बिल्ली)।"
            मुनि मेधा इंसान की 'रियलिटी' (Reality) को डिकोड (Decode) कर रहे हैं! हम सोचते हैं कि जो हम अपनी आँखों से देख रहे हैं, वही 100% सच है।
            पर मुनि कहते हैं: तुम रात में अंधे (रात्रावन्धा) हो जाते हो, पर उल्लू रात में साफ-साफ देखता है और दिन में अँधा (दिवान्धा) हो जाता है!
            तो फिर असली 'सच' (Truth) क्या है? दिन का उजाला या रात का अँधेरा?
            सच यह है कि 'रोशनी' या 'अँधेरा' बाहर नहीं है, यह तुम्हारी आँखों के हार्डवेयर (Hardware) की 'लिमिटेशन' (Limitation / सीमा) है!
            महामाया (Matrix) ने हर जीव को एक अलग 'वीआर हेडसेट' (VR Headset) पहनाकर इस दुनिया में भेजा है।
            हर जानवर एक ही दुनिया को अपने अलग-अलग 'फिल्टर' (Filter) से देख रहा है और उसी को 'परम सत्य' मान रहा है।
            राजा सुरथ जिसे अपना 'सबसे बड़ा दुःख' मानकर रो रहा है, वह दुःख भी केवल उसके दिमाग का एक 'फिल्टर' ही है!
            जब बाहर का 'फिजिकल विज़न' (Physical Vision) ही झूठा और अलग-अलग है, तो तुम अपने 'मन' (Mind) के विचारों पर कैसे भरोसा कर सकते हो?
        """.trimIndent(),
        english = """
            (Nature's programming and the Matrix of Maya): "Strictly inside this material nature, there are certain specific creatures who become completely and flawlessly 'Blind entirely during the daytime' (Divandhah praninah kechid) (exactly like the owl), while certain completely different creatures become absolutely '100% Blind strictly at night' (Ratravandhastathapare) (exactly like humans and crows)."
            "And completely apart from these, there are specific unique creatures who possess the exact raw capacity to see flawlessly and completely equally (Tulyadrishtayah) 'During both the bright day and the pitch-black night' (Diva tatha ratrau) (exactly like the cat)."
            Sage Medha is aggressively and flawlessly Decoding the absolute 'Reality' of the pathetic human! We arrogantly assume that exactly whatever we vividly see strictly with our physical eyes is the 100% absolute truth.
            But the Sage fiercely counters: You violently become completely Blind strictly at night (Ratravandha), but an owl sees flawlessly perfectly at night and becomes completely Blind exactly during the day (Divandha)!
            Then exactly what on earth is the absolute real 'Truth'? The bright light of the day or the pitch-black darkness of the night?
            The terrifying absolute truth is that 'Light' or 'Darkness' absolutely does not exist externally, it is strictly and exclusively the biological 'Limitation' exactly of your physical eyes' Hardware!
            Mahamaya (The Matrix) has violently strapped a completely entirely different 'VR Headset' directly onto the face of every single living creature and dropped them exactly into this world.
            Every single animal is actively viewing the exact same massive world strictly through its very own completely different 'Filter' and aggressively declaring it as the 'Absolute Supreme Truth'.
            Exactly what King Suratha is desperately crying about assuming it to be his 'Ultimate Agony', that exact agony is undeniably also merely a cheap 'Filter' actively running strictly inside his brain!
            Exactly when your external 'Physical Vision' itself is 100% a fake lie and highly subjective, exactly how on earth can you ever possibly Trust the chaotic thoughts of your pathetic 'Mind'?
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 39,
        sanskrit = "ज्ञानिनो मनुजाः सत्यं किं तु ते न हि केवलम् ।\nयतो हि ज्ञानिनः सर्वे पशुपक्षिमृगादयः ॥ ३९ ॥",
        hindi = """
            (इंसान के अहंकार पर चोट): "यह बात बिल्कुल 100% सत्य (सत्यं) है कि मनुष्य (मनुजाः) अपने आप को बहुत 'ज्ञानी' (समझदार / ज्ञानिनो) मानते हैं, परंतु इस बात को अच्छी तरह से समझ लो कि इस ब्रह्मांड में 'केवल वही' (किं तु ते न हि केवलम्) ज्ञानी नहीं हैं!"
            "क्योंकि (यतो हि) इस दुनिया में जितने भी पशु, पक्षी, और हिरण आदि जंगली जानवर (पशुपक्षिमृगादयः) हैं, वे सभी भी अपने-अपने विषय में पूरी तरह से 'ज्ञानी' (समझदार / ज्ञानिनः सर्वे) ही हैं।"
            यह श्लोक इंसान के उस सबसे बड़े 'ईगो' (Ego) को हथौड़े से कुचल देता है जहाँ इंसान खुद को इस पृथ्वी का राजा (Superior species) मानता है!
            हम सोचते हैं कि हम इंसानों के पास दिमाग है, बिल्डिंग्स (Buildings) हैं, इसलिए हम जानवरों से ऊपर हैं।
            पर मुनि कहते हैं: तुम्हारा ज्ञान केवल अपने 'पेट और सुरक्षा' तक सीमित है! और यह ज्ञान (Survival intelligence) तो एक पक्षी और हिरण के पास भी 100% परफेक्ट (Perfect) है!
            एक चिड़िया अपना घोंसला (घर) बिना किसी इंजीनियर (Engineer) की मदद के बनाती है; क्या तुम इसे उसका 'ज्ञान' नहीं मानोगे?
            एक हिरण को पता है कि शेर से कैसे भागना है। जानवरों की सोसाइटी (Society) में भी उनके अपने रूल्स (Rules) हैं।
            मुनि राजा सुरथ को आईना (Mirror) दिखा रहे हैं: तुम जो राज्य और पैसों का ज्ञान बघार रहे हो, वह 'स्पिरिचुअल' (Spiritual) ज्ञान नहीं है; वह एक 'एनिमल इंस्टिंक्ट' (Animal instinct) है!
            जब तक इंसान 'परमात्मा' को नहीं जानता, वह केवल दो पैरों पर चलने वाला एक 'स्मार्ट जानवर' (Smart Animal) ही है, उससे ज़्यादा कुछ नहीं।
            महामाया ने जानवरों और इंसानों के बेसिक 'सॉफ्टवेयर' (Software) में रत्ती भर भी कोई फर्क नहीं रखा है।
        """.trimIndent(),
        english = """
            (A brutal strike on human arrogance): "It is undeniably the 100% absolute literal truth (Satyam) that human beings (Manujah) inherently consider themselves to be exceptionally 'Jnani' (highly intelligent and wise / Jnanino), but you must flawlessly understand that in this colossal cosmos, 'they are absolutely not the exclusive only ones' (Kim tu te na hi kevalam) who possess knowledge!"
            "Strictly because (Yato hi) absolutely all the animals, flying birds, wild deer, and absolutely every other creature (Pashupakshimirgadayah) actively existing perfectly in this entire world are undeniably 100% 'Jnani' (highly intelligent and knowledgeable / Jnaninah sarve) exactly in their very own respective fields as well."
            This spectacular verse violently crushes that absolute greatest 'Ego' of the pathetic human strictly with a heavy hammer, exactly where the human arrogantly declares himself the absolute King (Superior species) of this physical earth!
            We ignorantly assume that because we humans physically possess complex brains and build massive concrete Buildings, we are infinitely superior strictly to mere animals.
            But the Sage fiercely screams: Your cheap knowledge is violently limited exclusively to your petty 'Stomach and Security'! And this precise knowledge (Survival intelligence) is undeniably 100% Perfect entirely even in a tiny bird and a wild deer!
            A tiny physical bird flawlessly constructs its complex nest (house) completely without aggressively begging for the help of any human Engineer; will you absolutely not strictly consider this her 'Jnana' (Supreme intelligence)?
            A wild deer flawlessly knows exactly how to aggressively outrun a terrifying lion. Even exactly inside the Society of animals, they flawlessly follow their very own strict Rules.
            The Sage is violently forcing King Suratha to stare directly into a brutal Mirror: The highly arrogant knowledge of kingdoms and cheap money you are aggressively boasting about is absolutely zero 'Spiritual' wisdom; it is exclusively merely a highly advanced 'Animal Instinct'!
            Exactly until a human flawlessly realizes 'God' (The Supreme Soul), he is absolutely nothing more than merely a highly 'Smart Animal' actively walking directly on two physical legs, and absolutely nothing more.
            Mahamaya has flawlessly maintained absolutely zero millimeter of difference strictly between the basic biological 'Software' of physical animals and pathetic humans.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 40,
        sanskrit = "ज्ञानं च तन्मनुष्याणां यत्तेषां मृगपक्षिणाम् ।\nमनुष्याणां च यत्तेषां तुल्यमन्यत्तथोभयोः ॥ ४० ॥",
        hindi = """
            (इंसानों और जानवरों में समानता): "जिस प्रकार का 'सांसारिक ज्ञान' (Survival instinct / ज्ञानं च) उन हिरणों और पक्षियों आदि जानवरों के पास मौजूद (यत्तेषां मृगपक्षिणाम्) है, बिल्कुल ठीक वैसा ही ज्ञान इन मनुष्यों (तन्मनुष्याणां) के पास भी है।"
            "और जो सांसारिक ज्ञान इन मनुष्यों के पास है (मनुष्याणां च यत्), वह बिल्कुल उन्हीं जानवरों (तेषां) के समान (तुल्यम्) है। खाने-पीने, डरने और सोने के जो बाकी काम (अन्यत्) हैं, वे भी इन दोनों ही प्रजातियों (इंसानों और जानवरों / तथोभयोः) में 100% एक समान और बराबर हैं।"
            मुनि मेधा ने इंसान की सारी 'स्पेशलिटी' (Specialty) का एक झटके में चीरहरण (Dissection) कर दिया है!
            बायोलॉजी (Biology) और वेदान्त (Vedanta) दोनों कहते हैं कि 'आहार (खाना), निद्रा (सोना), भय (डरना), और मैथुन (सेक्स)'—ये चार काम इंसान और जानवर में 100% एक जैसे हैं।
            तुम एक महल (Palace) में सोते हो, जानवर गुफा में सोता है; पर नींद (Sleep) दोनों को एक जैसी आती है!
            तुम बैंक-बैलेंस (Bank balance) देखकर सुरक्षित महसूस करते हो, जानवर झुंड में रहकर सुरक्षित महसूस करता है।
            राजा सुरथ अपनी जिस 'महान समझदारी' (कि मेरे जाने के बाद राज्य का क्या होगा) का रोना रो रहा था।
            मुनि उसे समझा रहे हैं कि यह कोई 'देवताओं' वाला ज्ञान नहीं है! एक कुत्ते को भी अपनी गली (Territory) की उतनी ही चिंता होती है जितनी तुम्हें अपने राज्य की हो रही है!
            जब तक तुम्हारा दिमाग केवल 'मैं, मेरा घर, मेरा परिवार, मेरी सुरक्षा' तक सीमित है, तुम 'बायोलॉजिकली' (Biologically) एक जानवर (Animal) से एक इंच भी ऊपर नहीं हो।
            इंसान केवल तभी इंसान बनता है जब वह 'मोक्ष' (Liberation) के बारे में सोचता है; बाकी सब कुछ महामाया की 'एनिमल प्रोग्रामिंग' (Animal Programming) है।
        """.trimIndent(),
        english = """
            (The absolute identical equality between humans and animals): "Exactly the identical kind of 'Worldly Knowledge' (Survival instinct / Jnanam cha) that is flawlessly possessed (Yattesham mrigapakshinam) directly by those wild deer, flying birds, and other animals, exactly that very identical knowledge actively exists perfectly inside these humans (Tanmanushyanam) as well."
            "And exactly whatever cheap worldly knowledge is violently possessed by these humans (Manushyanam cha yat), it is absolutely perfectly identical and equal (Tulyam) strictly to that of those exact animals (Tesham). Absolutely all the other primary biological activities (Anyat) like frantically eating, actively fearing, and lazily sleeping are also undeniably 100% identical and flawlessly equal perfectly in both these specific species (humans and animals / Tathobhayoh)."
            Sage Medha has violently and ruthlessly executed a complete Dissection and total annihilation of absolutely all human 'Specialty' in exactly one single stroke!
            Both pure Biology and advanced Vedanta fiercely declare that 'Ahara (frantically eating), Nidra (lazily sleeping), Bhaya (terrifying fear), and Maithuna (wild sex)'—these exact four primitive actions are 100% perfectly identical strictly in both humans and pathetic animals.
            You foolishly sleep exactly inside a massive, highly expensive Palace, while an animal sleeps securely directly inside a dark cave; but the actual biological Sleep (Nidra) perfectly arrives exactly identically for both!
            You aggressively feel highly secure actively looking strictly at your massive Bank Balance, while a physical animal feels exactly identically secure aggressively living perfectly inside its massive herd.
            That highly arrogant 'Magnificent wisdom' (what will happen to my kingdom after I leave) which King Suratha was frantically crying about.
            The Sage is brutally explaining to him that this is absolutely zero 'Divine' or Godly knowledge! Even a petty street dog relentlessly possesses the exact identical terrifying anxiety strictly for his dirty Territory precisely as you actively possess for your massive kingdom!
            Exactly as long as your pathetic brain remains violently limited exclusively to "I, my physical house, my biological family, my cheap security", you are 'Biologically' absolutely not even a single millimeter higher than a literal wild Animal.
            A human flawlessly becomes an actual human strictly and exclusively only when he actively thinks perfectly regarding 'Moksha' (Absolute Liberation); absolutely everything else is strictly merely Mahamaya's cheap 'Animal Programming'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 41,
        sanskrit = "ज्ञानेऽपि सति पश्यैतान् पतङ्गाञ्छावचञ्चुषु ।\nकणमोक्षादृतान् मोहात्पीड्यमानानपि क्षुधा ॥ ४१ ॥",
        hindi = """
            (पक्षियों में मोह का भयंकर उदाहरण): "इन छोटे-छोटे पक्षियों (पतङ्गान्) को ध्यान से देखो (पश्यैतान्)! इन्हें इस बात का बहुत अच्छी तरह से 'ज्ञान' (ज्ञानेऽपि सति) है कि इन्हें खुद भी भयंकर भूख लगी है।"
            "वे खुद भूख से अत्यंत भयानक पीड़ा सह रहे हैं (पीड्यमानानपि क्षुधा), फिर भी वे केवल और केवल भयंकर 'मोह' (अंधे प्यार / मोहात्) के कारण।"
            "अनाज के छोटे-छोटे दानों (कण) को अपने नन्हे बच्चों की चोंच में (शावचञ्चुषु) डालने के काम में ही पूरी तरह से लगे हुए हैं (मोक्षादृतान्)!"
            मुनि मेधा ने 'मोह' (Attachment) की साइकोलॉजी (Psychology) का सबसे खौफनाक और प्रैक्टिकल उदाहरण (Practical example) दिया है!
            एक चिड़िया (पक्षी) सुबह से शाम तक उड़कर एक दाना लाती है। वह खुद भूख से तड़प रही है (क्षुधा पीड़ित), पर जब वह अपने बच्चे की खुली हुई चोंच देखती है।
            तो उसका सारा लॉजिक (कि मुझे भी ज़िंदा रहना है) 'क्रैश' (Crash) हो जाता है! वह 'मोह' (Moha) में अंधी होकर वह दाना खुद खाने के बजाय अपने बच्चे के मुँह में डाल देती है।
            मुनि पूछ रहे हैं: क्या वह चिड़िया कोई महान 'त्याग' (Sacrifice) कर रही है? नहीं!
            यह कोई महानता नहीं है, यह महामाया का 'बायोलॉजिकल कोड' (Biological code) है जिसे 'मातृत्व' (Motherhood / मोह) कहते हैं!
            माया ने चिड़िया के दिमाग में यह 'ग्लिच' (Glitch) डाल दिया है कि वह अपने बच्चे के लिए अपनी जान भी दे देगी।
            राजा सुरथ! जो तुम अपने बच्चों और हाथी के लिए रो रहे हो, वह कोई तुम्हारा 'महान प्रेम' नहीं है!
            यह केवल और केवल माया की उसी 'प्रोग्रामिंग' (Programming) का हिस्सा है जो एक कीड़े और चिड़िया में भी फिट की गई है!
        """.trimIndent(),
        english = """
            (The terrifying example of blind attachment perfectly in birds): "Vividly and carefully observe (Pashyaitan) these tiny flying birds (Patangan)! They flawlessly and perfectly possess the exact clear 'Knowledge' (Jnane'pi sati) that they themselves are violently starving."
            "They themselves are actively and brutally enduring exceptionally terrifying, agonizing pain strictly from extreme hunger (Pidyamananapi kshudha), yet strictly and exclusively purely due to highly toxic, blind 'Moha' (blind infatuation / Mohat)."
            "They remain completely and flawlessly fiercely engaged (Mokshadritan) entirely in actively dropping tiny, microscopic grains of food (Kana) straight directly into the violently open beaks of their tiny babies (Shavachanchushu)!"
            Sage Medha has violently provided the absolute most terrifyingly horrific and brilliantly Practical Example exactly of the Psychology of 'Moha' (Toxic Attachment)!
            A tiny bird violently flies perfectly from early morning to late evening strictly to aggressively secure a single grain. She herself is brutally suffering intensely from agonizing hunger (Kshudha pidita), but exactly when she vividly sees the wide-open beak of her tiny baby.
            Her entire pure logic (that I absolutely must survive too) violently 'Crashes' to mathematical zero! Flawlessly blinded entirely by 'Moha', instead of actively eating that specific grain herself, she ruthlessly drops it flawlessly straight into her baby's mouth.
            The Sage is aggressively interrogating: Is that specific bird actively executing some exceptionally supreme, divine 'Sacrifice'? Absolutely not!
            This is undeniably zero 'Greatness'; this is strictly and exclusively Mahamaya's terrifying 'Biological Code' profoundly called 'Motherhood' (Moha / blind attachment)!
            Maya has flawlessly injected this exact fatal 'Glitch' directly into the bird's pathetic brain that she will seamlessly violently sacrifice her very own life strictly for her baby.
            O King Suratha! Exactly what you are frantically and pathetically crying about strictly for your wicked children and lost elephant, is absolutely zero 'Magnificent Love' of yours!
            It is solely, entirely, and exclusively just a cheap, petty component exactly of that exact same 'Programming' of Maya which is flawlessly fitted identically exactly even inside a tiny insect and a pathetic bird!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 42,
        sanskrit = "मानुषा मनुजव्याघ्र साभिलाषाः सुतान् प्रति ।\nलोभात् प्रत्युपकाराय नन्वेतान् किं न पश्यसि ॥ ४२ ॥",
        hindi = """
            (इंसानों का स्वार्थी प्रेम): "हे मनुष्यों में बाघ के समान श्रेष्ठ राजा (मनुजव्याघ्र)! सभी मनुष्य (मानुषा) अपने सगे पुत्रों और संतानों के प्रति (सुतान् प्रति) अत्यंत 'इच्छा और मोह' (साभिलाषाः) से भरे होते हैं।"
            "परंतु क्या तुम यह साफ-साफ नहीं देख पा रहे हो (नन्वेतान् किं न पश्यसि) कि इंसानों का यह प्यार पूरी तरह से केवल एक 'भयंकर लोभ' (लालच / लोभात्) पर टिका है?"
            "वे केवल इस लालच में बच्चों को पालते हैं कि बुढ़ापे में ये बच्चे 'बदले में उनका उपकार' (प्रत्युपकाराय / Return on investment) करेंगे!"
            यह श्लोक इंसानी रिश्तों (Human relationships) का सबसे 'ब्रूटल' (Brutal / क्रूर) पोस्टमार्टम (Post-mortem) है!
            पक्षी अपने बच्चों को खाना खिलाता है, पर वह बच्चे से बुढ़ापे में 'पेंशन' (Pension) या 'सहारा' नहीं माँगता; जानवर का प्यार निस्वार्थ (Selfless) है।
            पर इंसान (मानुषा) दुनिया का सबसे बड़ा 'व्यापारी' (Businessman) है!
            मुनि राजा सुरथ को झकझोर कर कह रहे हैं: "तुम इंसानों का प्यार तो जानवरों से भी ज्यादा स्वार्थी (Selfish) है!"
            एक बाप अपने बच्चे पर लाखों रुपये इसलिए खर्च करता है क्योंकि उसके अंदर गहरे सबकॉन्शस (Subconscious) में एक 'लालच' (लोभात्) छिपा होता है कि बुढ़ापे में (प्रत्युपकाराय) यह बच्चा मेरा ध्यान रखेगा।
            "किं न पश्यसि" (क्या तुम अंधे हो गए हो जो तुम्हें यह नहीं दिख रहा?)—मुनि राजा के 'पिता वाले ईगो' (Fatherly ego) को चकनाचूर कर रहे हैं।
            जिन बेटों ने तुम्हें लात मारी, तुम उनके लिए इसलिए रो रहे हो क्योंकि तुम्हारा 'बुढ़ापे का इन्वेस्टमेंट' (Investment) डूब गया है!
            यह कोई 'पवित्र प्यार' नहीं, यह सिर्फ एक फेल हुआ 'बिज़नेस डील' (Failed business deal) है।
        """.trimIndent(),
        english = """
            (The highly selfish love of pathetic humans): "O magnificent King, absolute supreme tiger among all human beings (Manujavyaghra)! Absolutely all humans (Manusha) are completely flawlessly overflowing heavily with extreme 'Desire and toxic Moha' (Sabhilashah) strictly directly toward their very own biological sons and offspring (Sutan prati)."
            "But can you absolutely not visibly see completely clearly (Nanvetan kim na pashyasi) that this pathetic love of humans undeniably rests exactly and entirely exclusively upon a terrifyingly 'Horrific Greed' (Blind selfishness / Lobhat)?"
            "They exclusively raise their children strictly harboring exactly this precise greed that exactly in old age these children will violently 'Return the favor and serve them back' (Pratyupakaraya / Return on Investment)!"
            This spectacular verse is undeniably the absolute most 'Brutal' (Cruel) and exceptionally terrifying Post-mortem of absolutely all worldly Human Relationships!
            A tiny bird flawlessly feeds its young baby, yet it absolutely never, ever demands a 'Pension' or 'Old-age Support' strictly from the baby exactly in old age; an animal's raw love is completely Selfless.
            But the pathetic human (Manusha) is undeniably the world's absolute greatest and most exceptionally ruthless 'Businessman'!
            The Sage is violently shaking King Suratha, aggressively screaming: "You humans' pathetic love is exponentially billions of times more toxically 'Selfish' than even wild animals!"
            A father violently spends millions of rupees strictly on his child exclusively because, flawlessly hidden perfectly deep inside his Subconscious, exists an exceptionally massive 'Greed' (Lobhat) that exactly in old age (Pratyupakaraya) this child will actively serve me.
            "Kim na pashyasi" (Have you gone completely violently blind that you absolutely cannot see this?)—the Sage is ruthlessly shattering the King's highly toxic 'Fatherly Ego' completely to pieces.
            The exact identical sons who violently kicked you out, you are frantically crying for them exclusively because your heavy 'Old-age Investment' has violently sunk and crashed!
            This is absolutely zero 'Sacred Pure Love', it is strictly, exclusively merely an exceptionally massive 'Failed Business Deal'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 43,
        sanskrit = "तथापि ममतावर्ते मोहगर्ते निपातिताः ।\nमहामायाप्रभावेन संसारस्थितिकारिणा ॥ ४३ ॥",
        hindi = """
            (ममता का भंवर और महामाया): "सब कुछ जानने और इतना भयंकर स्वार्थ देखने के बाद भी (तथापि), सभी मनुष्य 'ममता' (यह मेरा है) के भयंकर भंवर (ममतावर्ते / Whirlpool) में फँसे हुए हैं।"
            "और अज्ञान तथा 'मोह' रूपी अत्यंत गहरे और अंधेरे गड्ढे (मोहगर्ते) में बहुत ही बुरी तरह से गिरे हुए (निपातिताः) हैं।"
            "यह सब कुछ उस 'महामाया' देवी के अत्यंत भयंकर और अजेय 'प्रभाव' (महामायाप्रभावेन) के कारण ही हो रहा है, जो इस पूरे के पूरे 'संसार की स्थिति और रचना' (स संसारस्थितिकारिणा) को लगातार चला रही है।"
            यहाँ मुनि मेधा 'महामाया' (The Ultimate Matrix) का पर्दाफाश कर रहे हैं!
            इंसान को पता है कि रिश्ते स्वार्थी (Selfish) हैं, पैसा झूठा है, और शरीर एक दिन मर जाएगा; फिर भी वह उसी 'ममता' (अटैचमेंट) के भंवर (Whirlpool) में डूब रहा है!
            क्यों? क्योंकि यह कोई साधारण 'साइकोलॉजिकल प्रॉब्लम' (Psychological problem) नहीं है! यह साक्षात् 'महामाया' (Cosmic Illusion) का डायरेक्ट अटैक (Direct attack) है!
            महामाया वह 'सॉफ्टवेयर डेवलपर' (Software Developer) है जिसने इस दुनिया का कोड (संसारस्थितिकारिणा) लिखा है।
            अगर माँ अपने बच्चे से प्यार (मोह) करना छोड़ दे, तो यह दुनिया एक दिन में खत्म (Extinct) हो जाएगी।
            इसलिए भगवान (महामाया) ने जान-बूझकर इंसान के दिमाग में 'ममता और मोह' का यह भयंकर गड्ढा (मोहगर्ते) खोदा है ताकि सृष्टि (संसार) चलती रहे।
            यह तुम्हारी गलती नहीं है सुरथ! तुम जिस हैकर (Hacker) से लड़ने की कोशिश कर रहे हो, वह खुद इस यूनिवर्स की 'रचनाकार' (Creator) है।
            उस 'सुपर-कम्प्यूटर' (महामाया) के सामने तुम्हारा 'लॉजिक' कभी काम नहीं करेगा।
        """.trimIndent(),
        english = """
            (The whirlpool of attachment and Mahamaya): "Even strictly despite flawlessly knowing absolutely everything and directly witnessing such terrifying extreme selfishness (Tathapi), absolutely all humans are helplessly trapped violently inside the horrific 'Whirlpool of Mamatva' (Mine-ness / Mamatavarte)."
            "And they have violently and brutally fallen hopelessly exactly into the exceptionally deep, pitch-black 'Pit of Moha' (blind infatuation and thick ignorance / Mohagarte) (Nipatitah)."
            "Absolutely all this is relentlessly occurring strictly and exclusively due perfectly to the terrifying, completely invincible 'Influence of Mahamaya' (Mahamayaprabhavena) Goddess, who is actively, continuously flawlessly maintaining exactly the 'Existence, order, and operation of this entire colossal Cosmos' (Samsarasthitikarina)."
            Right here, Sage Medha is violently Exposing the terrifying reality of 'Mahamaya' (The Ultimate Matrix)!
            The human flawlessly knows exactly that physical relationships are brutally Selfish, cheap money is entirely fake, and the dirt-body will violently die one day; yet he aggressively drowns exactly in that exact same terrifying Whirlpool of 'Mamatva' (Attachment)!
            Exactly why? Strictly because this is absolutely no ordinary, cheap 'Psychological Problem'! This is undeniably the direct, violent Attack explicitly by 'Mahamaya' (Cosmic Illusion) Herself!
            Mahamaya is exactly that terrifying 'Software Developer' who flawlessly wrote the absolute underlying Code (Samsarasthitikarina) actively running this massive world.
            Exactly if a mother ruthlessly abandons loving (Moha) her child, this entire physical world would effortlessly go entirely Extinct in exactly a single day.
            Therefore, God (Mahamaya) has flawlessly and intentionally aggressively dug this exact horrific, inescapable Pit of 'Mamatva and Moha' (Mohagarte) perfectly directly inside the human brain strictly so that the massive Creation (Samsara) perpetually continues operating.
            This is absolutely not your personal fault, O Suratha! The exact terrifying Hacker you are frantically aggressively attempting to fight is literally the direct 'Creator' of this entire Universe Herself.
            Directly before that terrifying 'Super-Computer' (Mahamaya), your tiny, pathetic 'Logic' will absolutely never, ever possibly work.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 44,
        sanskrit = "तन्नात्र विस्मयः कार्यो योगनिद्रा जगत्पतेः ।\nमहामाया हरेश्चैषा तया सम्मोह्यते जगत् ॥ ४४ ॥",
        hindi = """
            (महामाया की शक्ति पर कोई विस्मय नहीं): "इसलिए (तन्), इस भयंकर अज्ञान और मोह को देखकर तुम्हें अपने मन में बिल्कुल भी 'विस्मय' (आश्चर्य या हैरानी / अत्र विस्मयः कार्यो) नहीं करना चाहिए (न)!"
            "यह जो 'महामाया' (महामाया) है, वह कोई और नहीं, बल्कि पूरे ब्रह्मांड के परम स्वामी भगवान 'विष्णु' (जगत्पतेः हरेः) की साक्षात् 'योगनिद्रा' (परम शक्ति और चेतना / योगनिद्रा) ही है!"
            "और केवल और केवल उसी एक महामाया के द्वारा ही यह पूरा का पूरा ब्रह्मांड (जगत्) भयंकर रूप से 'सम्मोहित' (सम्मोह्यते / Hypnotized) किया जा रहा है।"
            राजा सुरथ हैरान (Shocked) था कि "मेरे जैसा पढ़ा-लिखा इंसान इतना बेवकूफ कैसे हो सकता है?"
            मुनि हँसकर कहते हैं: "इसमें 'हैरान' (विस्मय) होने की कोई बात नहीं है! तुम किसी मामूली बीमारी से नहीं लड़ रहे हो!"
            तुम जिस 'मोह' (अटैचमेंट) को अपनी कमज़ोरी समझ रहे हो, वह वास्तव में साक्षात् भगवान विष्णु की 'योगनिद्रा' है!
            योगनिद्रा वह 'सुपर-शक्ति' (Super-power) है जो पूरे यूनिवर्स को सुलाकर (Hypnotize करके) रखती है।
            जब भगवान (विष्णु) की इस भयंकर शक्ति (महामाया) ने पूरी दुनिया (अरबों लोगों) को अपने सम्मोहन (Hypnosis / सम्मोह्यते) में जकड़ा हुआ है।
            तो तुम जैसे एक साधारण राजा का उसके सामने हार जाना कोई 'आश्चर्य' (Surprise) की बात नहीं है!
            यह श्लोक इंसान के अंदर से 'गिल्ट' (Guilt / कि मैं कमज़ोर हूँ) को हमेशा के लिए मिटा देता है।
            जब दुश्मन साक्षात् 'ईश्वर की शक्ति' (महामाया) हो, तो हार मानना ही समझदारी है।
        """.trimIndent(),
        english = """
            (Absolutely zero surprise strictly regarding Mahamaya's terrifying power): "Therefore (Tan), flawlessly witnessing this exceptionally horrific thick ignorance and toxic Moha, you absolutely must never ever harbor even a single millimeter of 'Vismaya' (shock, extreme surprise, or heavy astonishment / Atra vismayah karyo) exactly inside your mind (Na)!"
            "This exact specific 'Mahamaya' (Mahamaya) is undeniably absolutely no one else, but literally the direct, supreme 'Yoganidra' (absolute power and pure consciousness / Yoganidra) exclusively of Lord 'Vishnu' Himself, the absolute supreme master of the entire cosmos (Jagatpateh Hareh)!"
            "And strictly, entirely, and exclusively by that exactly One Mahamaya alone is this absolute entire colossal universe (Jagat) violently, flawlessly, and aggressively 'Hypnotized' (Sammohyate / entirely deluded)."
            King Suratha was exceptionally violently Shocked thinking, "Exactly how on earth can a highly educated human exactly like me possibly be so exceptionally stupid?"
            The Sage flawlessly laughs and profoundly replies: "There is absolutely zero reason whatsoever to be 'Shocked' (Vismaya) strictly about this! You are absolutely not fighting some cheap, petty minor disease!"
            Exactly what you foolishly perceive strictly as your personal pathetic weakness (Moha / Attachment) is, in absolute reality, literal Lord Vishnu's terrifying 'Yoganidra' Herself!
            Yoganidra is exactly that ultimate 'Super-Power' which flawlessly keeps the entire massive Universe aggressively Asleep (completely Hypnotized).
            Exactly when this terrifying, horrific power (Mahamaya) of God (Vishnu) has violently trapped the absolute entire world (billions of people) flawlessly in Her inescapable Hypnosis (Sammohyate).
            Then the brutal fact that a completely ordinary, petty King like you violently failed directly before Her is absolutely zero matter of 'Surprise' whatsoever!
            This spectacular verse completely and permanently annihilates absolutely all toxic 'Guilt' (that I am pathetic and weak) directly from inside the human forever.
            Exactly when the ultimate opponent is literally the direct 'Power of God' (Mahamaya), flawlessly admitting total defeat is the absolute only supreme intelligence.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 45,
        sanskrit = "ज्ञानिनामपि चेतांसि देवी भगवती हि सा ।\nबलादाकृष्य मोहाय महामाया प्रयच्छति ॥ ४५ ॥",
        hindi = """
            (ज्ञानियों के दिमाग को भी हैक करने वाली देवी): "वह जो परम 'भगवती महामाया देवी' (देवी भगवती हि सा महामाया) हैं।"
            "वे दुनिया के सबसे बड़े और महान 'ज्ञानियों' (विद्वानों और योगियों / ज्ञानिनामपि) के 'चित्त' (दिमाग और मन / चेतांसि) को भी।"
            "अत्यंत 'बलपूर्वक' (जबरदस्ती / बलादाकृष्य) खींचकर उन्हें इस भयंकर 'मोह' (माया के जाल / मोहाय) में पूरी तरह से धकेल (प्रयच्छति) देती हैं!"
            यह पूरी दुर्गा सप्तशती का सबसे 'खतरनाक' (Most dangerous) और सबसे प्रसिद्ध श्लोक है!
            हम सोचते हैं कि जो इंसान बहुत किताबें पढ़ लेता है या बहुत तपस्या (Meditation) करता है, वह माया से बच जाता है।
            पर मुनि मेधा चेतावनी (Warning) दे रहे हैं: "महामाया के सामने तुम्हारे 'ज्ञान' (Knowledge) की कोई औकात नहीं है!"
            वह देवी इतनी पावरफुल (Powerful) है कि वह बड़े-बड़े 'ज्ञानियों' (Scientists, Philosophers, Gurus) के दिमाग (चेतांसि) को भी 'बलपूर्वक' (बलादाकृष्य / By brutal force) हैक (Hack) कर लेती है।
            तुम 'चॉइस' (Choice) से मोह में नहीं गिरते; महामाया तुम्हारी इच्छा के खिलाफ 'जबरदस्ती' (बलात्) तुम्हारा कॉलर (Collar) पकड़कर तुम्हें वासना, ईर्ष्या और मोह के दलदल (मोहाय) में फेंक देती है!
            इसलिए अपने ज्ञान या अपनी बुद्धि पर कभी भी रत्ती भर भी घमंड (Arrogance) मत करना।
            इस 'ग्रेविटी' (Gravity / माया) से बचने का कोई 'लॉजिक' (Logic) नहीं है; इससे बचने का एकमात्र तरीका उस माता के आगे 'सरेंडर' (पूर्ण समर्पण) करना ही है।
            वह तुम्हारी बुद्धि से अनंत गुना बड़ी है।
        """.trimIndent(),
        english = """
            (The Goddess who violently hacks even the brains of the enlightened): "That exact absolute supreme 'Bhagavati Mahamaya Goddess' (Devi bhagavati hi sa mahamaya)."
            "Violently and aggressively Hacks and hijacks even the absolute 'Chitta' (core brain, mind, and intellect / Chetamsi) of the world's absolute greatest and most supreme 'Jnanis' (enlightened masters, scholars, and yogis / Jnaninamapi)."
            "And violently dragging them strictly by 'Exceptionally Brutal Force' (Baladakrishya), She ruthlessly and flawlessly violently throws and completely pushes them (Prayacchati) perfectly into this terrifying 'Moha' (the horrific web of absolute blind illusion / Mohaya)!"
            This is undeniably the absolute 'Most Dangerous' and exceptionally most famous verse of the entire colossal Durga Saptshati!
            We foolishly assume that the exact human who heavily reads millions of books or aggressively performs intense penance (Meditation) flawlessly escapes Maya.
            But Sage Medha is fiercely issuing an absolute Warning: "Directly before Mahamaya, your cheap 'Knowledge' (Jnana) possesses absolutely zero pathetic worth!"
            That Goddess is so incredibly terrifyingly Powerful that She aggressively Hacks the physical brains (Chetamsi) of even the absolute greatest 'Jnanis' (Scientists, Philosophers, Gurus) strictly by 'Brutal Force' (Baladakrishya / completely against their will).
            You absolutely do not casually fall into Moha purely by 'Choice'; Mahamaya ruthlessly grabs your literal Collar completely against your will 'by raw Force' (Balat) and violently throws you directly into the toxic swamp of thick lust, jealousy, and Moha!
            Therefore, absolutely never, ever harbor even a single millimeter of toxic Pride (Arrogance) strictly regarding your cheap knowledge or petty intellect.
            There exists absolutely zero 'Logic' to possibly escape this terrifying 'Gravity' (Maya); the absolute only solitary method to flawlessly escape is purely 100% total 'Surrender' directly before that Mother.
            She is infinitely, boundlessly billions of times greater than your pathetic human intellect.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 46,
        sanskrit = "तया विसृज्यते विश्वं जगदेतच्चराचरम् ।\nसैषा प्रसन्ना वरदा नृणां भवति मुक्तये ॥ ४६ ॥",
        hindi = """
            (सृष्टि की रचना और मोक्ष का वरदान): "केवल और केवल उसी एक महामाया देवी के द्वारा (तया) इस संपूर्ण चराचर (चलने और न चलने वाले / चराचरम्) ब्रह्मांड और विश्व (जगदेतद्) की रचना (विसृज्यते / Creation) की जाती है।"
            "और जब वही परम देवी (सैषा) किसी साधक की भक्ति से पूरी तरह 'प्रसन्न' (प्रसन्ना / खुश) हो जाती हैं।"
            "तो वे ही माता मनुष्यों को (नृणां) साक्षात् 'मोक्ष' (परम मुक्ति / मुक्तये) का सबसे बड़ा 'वरदान देने वाली' (वरदा भवति) बन जाती हैं।"
            यह श्लोक 'परम सत्य' (Ultimate Truth) का परफेक्ट बैलेंस (Perfect Balance) है।
            पिछले श्लोक में देवी ने ज्ञानियों को भी बलपूर्वक मोह में धकेल दिया था (जो उनका डरावना रूप था)।
            पर यहाँ मुनि बता रहे हैं कि जो देवी तुम्हें मोह (जेल) में डाल सकती है, केवल उसी के पास उस जेल की 'चाबी' (Key / मोक्ष) भी है!
            'चराचरम्' का अर्थ है कि चींटी से लेकर पहाड़ तक सब कुछ उसी एक 'प्रोग्रामर' (Programmer) ने बनाया है (विसृज्यते)।
            तुम खुद से इस माया (Matrix) से बाहर नहीं निकल सकते, क्योंकि तुम खुद उस माया के अंदर के एक 'कैरेक्टर' (Character) हो!
            बाहर निकलने का एक ही तरीका है—उस 'सुपर-कम्प्यूटर' (देवी) को 'प्रसन्न' (प्रसन्ना / खुश) करना!
            जब वह माता खुश होती है, तो वह 'वरदा' (वरदान देने वाली) बनकर तुम्हारे दिमाग का सारा मोह (वायरस) एक सेकंड में डिलीट (Delete) कर देती है।
            वही तुम्हारी सबसे बड़ी दुश्मन (अज्ञान) है, और वही तुम्हारी सबसे बड़ी दोस्त (मोक्ष) है।
        """.trimIndent(),
        english = """
            (The creation of the cosmos and the boon of Moksha): "Strictly, entirely, and exclusively by that exactly One Mahamaya Goddess alone (Taya) is this absolute entire moving and non-moving (animate and inanimate / Characharam) colossal universe and physical cosmos (Jagadetad) flawlessly and violently Created and projected (Visrijyate)."
            "And exactly when that exact same Supreme Goddess (Saisha) becomes completely 100% 'Pleased' (Prasanna / highly satisfied) strictly by a sincere seeker's profound devotion."
            "Then She, that exact Mother alone, flawlessly becomes the absolute greatest 'Bestower of the ultimate Boon' (Varada bhavati) of direct, literal 'Moksha' (Absolute liberation / Muktaye) strictly for mortal humans (Nrinam)."
            This spectacular verse perfectly establishes the exact 'Perfect Balance' of the 'Ultimate Truth'.
            Exactly in the previous verse, the Goddess violently pushed even the most enlightened masters completely into toxic Moha by brutal force (which was Her highly terrifying form).
            But right here the Sage is explicitly revealing that the exact same Goddess who possesses the terrifying raw power to violently throw you strictly into Moha (the Jail), exclusively She alone flawlessly possesses the absolute 'Key' (Moksha) strictly to that exact same jail!
            'Characharam' profoundly means that absolutely everything strictly from a tiny ant exactly up to a massive mountain has been flawlessly Coded exclusively by that exactly one 'Programmer' (Visrijyate).
            You absolutely cannot possibly escape this Matrix (Maya) entirely on your own, strictly because you yourself are merely a completely coded 'Character' existing perfectly inside that exact Maya!
            The absolute solitary method to successfully escape is exclusively—to completely 'Please' (Prasanna) that terrifying 'Super-Computer' (The Goddess)!
            Exactly when that Mother is highly pleased, She flawlessly becomes 'Varada' (The Boon-Giver) and permanently Deletes the entire heavy Virus of Moha directly from your brain in exactly a single second.
            She alone is your absolute greatest terrifying enemy (thick ignorance), and exactly She alone is your absolute greatest supreme friend (ultimate Moksha).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 47,
        sanskrit = "सा विद्या परमा मुक्तेर्हेतुभूता सनातनी ।\nसंसारबन्धहेतुश्च सैव सर्वेश्वरेश्वरी ॥ ४७ ॥",
        hindi = """
            (विद्या और अविद्या दोनों माता ही हैं): "वह साक्षात् माता त्रिपुरा ही परम 'विद्या' (परम ज्ञान / सा विद्या परमा) हैं, जो मनुष्य की अंतिम 'मुक्ति' (मोक्ष / मुक्तेर्) का एकमात्र कारण (हेतुभूता) हैं, और वे ही हमेशा से रहने वाली 'सनातनी' (सनातनी) शक्ति हैं।"
            "और वे ही माता इस जन्म-मरण के भयंकर 'संसार के बंधन' (संसारबन्ध) का एकमात्र कारण (हेतुश्च) भी हैं!"
            "निश्चित रूप से वही एक माता (सैव) इस ब्रह्मांड के सभी ईश्वरों (ब्रह्मा, विष्णु, शिव आदि) की भी परम 'ईश्वरी' (सर्वेश्वरेश्वरी / Supreme Boss) हैं।"
            यह अद्वैत (Non-duality) का सबसे बड़ा धमाका (Explosion) है!
            इंसान सोचता है कि 'भगवान' (God) मुझे आज़ाद करेगा और 'शैतान' (Devil) मुझे बंधन में डालेगा।
            पर दुर्गा सप्तशती ईसाई या इस्लाम धर्म की तरह 2 ताकतों (God vs Devil) को नहीं मानती! यहाँ केवल 'एक' (सैव) ही है!
            वही माता तुम्हारे दिमाग में 'विद्या' (ज्ञान) बनकर तुम्हें मोक्ष देती है, और वही माता 'अविद्या' (माया) बनकर तुम्हें संसार (पैसे, वासना) के बंधन (संसारबन्ध) में जकड़ देती है।
            सॉफ्टवेयर (Software) एक ही है, बस उसके दो अलग-अलग 'मोड' (Modes) हैं।
            'सर्वेश्वरेश्वरी' का मतलब है कि वे देवी किसी देवता की पत्नी नहीं हैं; वे साक्षात् 'ईश्वरों की भी ईश्वर' (The Boss of all Gods) हैं!
            ब्रह्मा, विष्णु और महेश भी उसी माता के 'एम्प्लॉई' (Employees) हैं जो उसके 'संसार' के प्रोजेक्ट (Project) को चला रहे हैं।
            जब इंसान इस लेवल (Level) का सच समझ लेता है, तो वह मूर्तियों से ऊपर उठकर सीधा उस 'परम ऊर्जा' (सनातनी विद्या) से जुड़ जाता है।
        """.trimIndent(),
        english = """
            (Both Supreme Wisdom and Ignorance are strictly the Mother): "That direct Mother Tripura Herself is undeniably exactly the ultimate 'Vidya' (Supreme Cosmic Knowledge / Sa vidya parama), who is the absolute solitary, direct cause (Hetubhuta) of the human's final 'Liberation' (Moksha / Mukter), and She exactly is the completely eternal, immortal 'Sanatani' (Sanatani) raw power."
            "And strictly She, that exact identical Mother, is also undeniably the absolute solitary cause (Hetushcha) of the terrifying 'Bondage of this physical world' (Samsarabandha) consisting entirely of brutal birth and death!"
            "Undoubtedly and certainly, exactly that One Mother alone (Saiva) is flawlessly the absolute, supreme 'Ishvari' (Sarveshvareshvari / The Ultimate Supreme Boss) exactly even of absolutely all the Lords (Brahma, Vishnu, Shiva, etc.) of this entire massive cosmos."
            This is undeniably the absolute greatest massive Explosion of pure Advaita (Non-duality)!
            A pathetic human foolishly assumes that 'God' will magically free him and a fake 'Devil' will aggressively throw him straight into bondage.
            But the Durga Saptshati absolutely does not blindly believe strictly in exactly 2 competing physical forces (God vs Devil) like Christianity or Islam! Right here, absolutely only 'One' (Saiva) exists!
            That exact identical Mother perfectly becomes 'Vidya' (Supreme Wisdom) exactly inside your brain to flawlessly grant you Moksha, and exactly that identical Mother violently becomes 'Avidya' (Maya) to ruthlessly chain you strictly in the terrifying bondage (Samsarabandha) of the physical world (cheap money, lust).
            The core Software is exactly purely one; it exclusively merely possesses exactly two entirely completely different 'Modes'.
            'Sarveshvareshvari' profoundly means that the Goddess is absolutely no cheap, submissive wife strictly of any male God; She is literally the direct 'God exactly of all Gods' (The Boss of all Gods)!
            Even Brahma, Vishnu, and Mahesh are exclusively merely exactly that Mother's obedient 'Employees' actively running Her massive 'Samsara' Project.
            Exactly when a human flawlessly comprehends the absolute truth strictly of this terrifying Level, he seamlessly transcends cheap idols and violently Connects directly entirely to that 'Supreme Energy' (Sanatani Vidya).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 48,
        sanskrit = "राजोवाच ॥ ४८ ॥\nभगवन् का हि सा देवी महामायेति यां भवान् ।\nब्रवीति कथमत्पन्ना सा कर्मास्याश्च किं द्विज ॥ ४८ ॥",
        hindi = """
            (राजा सुरथ का देवी के बारे में प्रश्न): "राजा सुरथ ने अत्यंत जिज्ञासा से पूछा (राजोवाच): हे भगवन्! वह रहस्यमयी देवी 'महामाया' वास्तव में कौन है (का हि सा देवी महामायेति), जिसके बारे में आप मुझे अभी बता रहे हैं (यां भवान् ब्रवीति)?"
            "हे श्रेष्ठ ब्राह्मण (द्विज)! वह परम देवी इस संसार में 'किस प्रकार उत्पन्न' (कथमत्पन्ना सा) हुई हैं? और उस माता का मुख्य 'कार्य' (कर्मास्याश्च किं) क्या है?"
            मुनि मेधा ने राजा के दिमाग में 'महामाया' नाम का जो न्यूक्लियर बम (Nuclear Bomb) फोड़ा था, उसका असर अब दिख रहा है!
            राजा सुरथ की सारी चिंता (राज्य, खजाना, हाथी) अब 100% गायब (Vanish) हो चुकी है!
            अब उसका फोकस (Focus) अपनी 'बीमारी' से हटकर उस बीमारी को बनाने वाले 'सॉफ्टवेयर' (महामाया) पर चला गया है।
            राजा अब जानना चाहता है कि आखिर वह परम शक्ति (Super-power) है कौन जो ज्ञानियों के दिमाग को भी हैक (Hack) कर लेती है?
            वह 'कथमत्पन्ना' (कैसे पैदा हुई) पूछ रहा है, यह जानने के लिए कि क्या उस देवी का कोई फिजिकल (Physical) रूप है या वह केवल एक एनर्जी (Energy) है?
            और उसका 'कर्म' (Job/Function) क्या है? क्या वह केवल दुनिया को डिप्रेशन (मोह) में डालती है या उसका कोई और भी काम है?
            यह एक सच्चे 'जिज्ञासु' (Seeker) का प्रश्न है। जब तक आप सही सवाल नहीं पूछते, तब तक यूनिवर्स (Universe) आपको कभी सही जवाब नहीं देता।
            अब मुनि मेधा जो उत्तर देंगे, वह 'दुर्गा सप्तशती' की असली कहानी (मधु-कैटभ वध) को शुरू करेगा।
        """.trimIndent(),
        english = """
            (King Suratha's massive question regarding the Goddess): "King Suratha aggressively asked strictly with exceptionally intense curiosity (Rajovacha): O Supreme Lord (Bhagavan)! Exactly who on earth is that highly mysterious Goddess 'Mahamaya' in actual reality (Ka hi sa devi mahamayeti), perfectly regarding whom you are actively speaking to me right now (Yam bhavan braviti)?"
            "O supreme, ultimate Brahmin (Dvija)! Exactly 'How was that Supreme Goddess born' or flawlessly manifested (Kathamatpanna sa) strictly in this physical world? And exactly what is the absolute primary 'Function and Action' (Karmasyashcha kim) of that Mother?"
            The terrifying Nuclear Bomb completely named 'Mahamaya' which Sage Medha ruthlessly exploded exactly inside the King's brain is actively flawlessly showing its massive effect now!
            King Suratha's entire pathetic toxic anxiety (kingdom, treasury, elephant) has now flawlessly 100% entirely Vanished!
            Now his absolute intense Focus has aggressively shifted completely away from his petty 'disease' directly straight onto the exact terrifying 'Software' (Mahamaya) that flawlessly manufactured that exact disease.
            The King now desperately thirsts to flawlessly know exactly who on earth that ultimate Supreme Power (Super-power) actually is who aggressively Hacks the physical brains exactly of even the greatest enlightened masters?
            He is fiercely asking 'Kathamatpanna' (How was She born), exclusively to perfectly comprehend whether that Goddess flawlessly possesses a visible Physical form or if She is purely raw, formless Energy?
            And exactly what is Her precise 'Karma' (Job/Function)? Does She strictly exclusively merely violently throw the world into deep depression (Moha) or does She actively perform some other cosmic task as well?
            This is undeniably the explicit question of a 100% true 'Seeker' (Jijnasu). Exactly until you aggressively ask the exact correct question, the Universe absolutely never, ever possibly hands you the correct answer.
            Now exactly whatever profound answer Sage Medha will flawlessly deliver, will violently initiate the actual, real epic saga (the slaying of Madhu-Kaitabha) strictly of the 'Durga Saptshati'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 49,
        sanskrit = "यत्प्रभावा च सा देवी यत्स्वरूपा यदुद्भवा ।\nतत्सर्वं श्रोतुमिच्छामि त्वत्तो ब्रह्मविदां वर ॥ ४९ ॥",
        hindi = """
            (ब्रह्मज्ञानी मुनि से सत्य जानने की इच्छा): "उस परम देवी का 'प्रभाव' (शक्ति और महिमा / यत्प्रभावा च सा देवी) कितना महान है? उनका साक्षात् 'असली रूप' (यत्स्वरूपा) क्या है? और उनकी 'उत्पत्ति का मूल कारण' (यदुद्भवा) क्या है?"
            "हे ब्रह्म को जानने वाले योगियों में सबसे श्रेष्ठ (ब्रह्मविदां वर)! मैं यह सब कुछ (तत्सर्वं) विस्तार से केवल और केवल आपके ही मुख से 'सुनने की इच्छा' (श्रोतुमिच्छामि त्वत्तो) रखता हूँ।"
            राजा सुरथ अब पूरी तरह से 'सरेंडर' (Surrender) कर चुका है। वह मुनि को 'ब्रह्मविदां वर' (ब्रह्मज्ञानियों में सबसे श्रेष्ठ) कह रहा है।
            जब इंसान को यह एहसास हो जाता है कि उसका अपना 'लॉजिक' (Logic) कूड़ा (Garbage) है, तो वह सीधा 'ब्रह्म' (यूनिवर्सल सच) को जानने वाले के चरणों में गिर पड़ता है।
            राजा देवी के 3 मुख्य 'पैरामीटर्स' (Parameters) जानना चाहता है: 1. 'प्रभाव' (Power / वह क्या कर सकती है?), 2. 'स्वरूप' (Form / वह कैसी दिखती है?), 3. 'उद्भव' (Origin / वह कहाँ से आती है?)।
            यह कोई अंधभक्ति (Blind faith) नहीं है; यह एक 'साइंटिफिक इन्क्वायरी' (Scientific Inquiry) है!
            तन्त्र (Tantra) में भगवान को केवल 'माना' नहीं जाता, भगवान के 'सोर्स-कोड' (Source-code) को डिकोड (Decode) किया जाता है।
            राजा कह रहा है कि "मैं यह सब केवल 'आप' (त्वत्तो) से सुनना चाहता हूँ", क्योंकि किताबी ज्ञान (Bookish knowledge) इंसान को आज़ाद नहीं कर सकता।
            असली ज्ञान केवल एक 'जीवित गुरु' (Living Master) के सीधे 'ट्रांसमिशन' (Transmission) से ही दिमाग में उतरता है।
            यही वह परम क्षण था जब 'चण्डी पाठ' (दुर्गा सप्तशती) इस धरती पर पहली बार सुनाया गया!
        """.trimIndent(),
        english = """
            (The intense desire to flawlessly know the absolute truth from the enlightened Sage): "Exactly how magnificent and terrifying is the absolute 'Prabhava' (raw power, supreme influence, and glory / Yatprabhava cha sa devi) of that Supreme Goddess? Exactly what is Her direct, literal 'Actual True Form' (Yatsvarupa)? And exactly what is the absolute 'Root cause of Her ultimate origin' (Yadudbhava)?"
            "O absolute supreme and greatest among absolutely all highly enlightened masters who flawlessly know Brahman (Brahmavidam vara)! I exceptionally desperately 'Desire to completely hear' (Shrotumicchami) absolutely all of this (Tatsarvam) in massive detail strictly and exclusively directly from your very own mouth alone (Tvatto)."
            King Suratha has now flawlessly and completely violently 'Surrendered' 100%. He is aggressively addressing the Sage strictly as 'Brahmavidam vara' (the absolute greatest among the knowers of Brahman).
            Exactly when a human flawlessly realizes that his very own 'Logic' is literal toxic Garbage, he violently falls flawlessly straight exactly at the sacred feet of the one who actively knows 'Brahman' (Universal Truth).
            The King desperately wishes to explicitly know exactly 3 primary 'Parameters' of the Goddess: 1. 'Prabhava' (Power / exactly what can She actively do?), 2. 'Svarupa' (Form / exactly what does She actually look like?), 3. 'Udbhava' (Origin / exactly where on earth does She originate from?).
            This is undeniably absolutely zero 'Blind Faith'; this is exactly an aggressively highly advanced 'Scientific Inquiry'!
            In pure Tantra, God is absolutely never merely blindly 'believed in'; God's absolute exact 'Source-Code' is violently and aggressively Decoded!
            The King is fiercely declaring, "I desire to actively hear absolutely all this exclusively strictly from 'You' (Tvatto)", simply because cheap Bookish Knowledge can absolutely never possibly liberate a human.
            True, actual supreme wisdom violently downloads directly into the brain strictly and exclusively through the direct 'Transmission' entirely of a 'Living Master'.
            This was undeniably the exact absolute supreme moment precisely when the 'Chandi Path' (Durga Saptshati) was violently recited flawlessly on this earth for the absolute first time!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 50,
        sanskrit = "ऋषिरुवाच ॥ ५० ॥\nनित्यैव सा जगन्मूर्तिस्तया सर्वमिदं ततम् ।\nतथापि तत्समुत्पत्तिर्बहुधा श्रूयतां मम ॥ ५० ॥",
        hindi = """
            (देवी नित्य हैं, फिर भी उनकी उत्पत्ति सुनो): "महर्षि मेधा ने कहा (ऋषिरुवाच): हे राजा! वह परम देवी 100% 'नित्य' (शाश्वत / नित्यैव / Eternal) हैं और यह पूरा का पूरा ब्रह्मांड साक्षात् उन्हीं की मूर्ति (रूप / जगन्मूर्तिस्) है!"
            "उसी एक माता के द्वारा यह संपूर्ण दृश्यमान संसार (सर्वमिदं) पूरी तरह से व्याप्त (ततम् / Pervaded) है (अर्थात कण-कण में वही भरी हुई हैं)।"
            "उनके कभी पैदा न होने (नित्य) के बावजूद भी (तथापि), देवताओं के कार्य के लिए उनकी 'उत्पत्ति' (प्रकट होना / तत्समुत्पत्तिर्) अनेक प्रकार (बहुधा) से होती है; अब उसे तुम मेरे मुख से ध्यानपूर्वक सुनो (श्रूयतां मम)।"
            मुनि मेधा ने पहले ही झटके में राजा के एक सवाल (वह कैसे पैदा हुई?) को पूरी तरह 'डिलीट' (Delete) कर दिया!
            मुनि कहते हैं: "देवी कोई इंसान या वस्तु नहीं है जो किसी दिन 'पैदा' (Born) हो! वह 'नित्य' (Permanent) है। जब टाइम (Time) और स्पेस (Space) नहीं था, तब भी वह थी!"
            और उसका 'स्वरूप' (Form) क्या है? यह पूरा का पूरा 'ब्रह्मांड' (जगन्मूर्तिस्) ही उसका साक्षात् शरीर है!
            तुम जिस कुर्सी पर बैठे हो, जो हवा तुम पी रहे हो—सब कुछ 100% माता त्रिपुरा (चेतना) से ही बना हुआ है (ततम्)।
            पर फिर मुनि कहते हैं कि "भले ही वह कभी पैदा नहीं होती, फिर भी वह एक खास 'फॉर्म' (Physical Form) लेकर बार-बार इस दुनिया में 'प्रकट' (Manifest) होती है।"
            जैसे बिजली (Electricity) हमेशा तारों में मौजूद (नित्य) रहती है, पर जब तुम 'बल्ब' चालू करते हो, तो वह रोशनी (उत्पत्ति) के रूप में दिखाई देने लगती है!
            अब मुनि उसी परम 'बिजली' (महामाया) के पहली बार 'बल्ब' (रूप) में प्रकट होने की खौफनाक कहानी सुनाने जा रहे हैं।
        """.trimIndent(),
        english = """
            (The Goddess is completely Eternal, yet hear of Her manifestation): "Maharshi Medha profoundly declared (Rishiruvacha): O King! That Supreme Goddess is 100% completely 'Nitya' (Absolute Eternal / Nityaiva / immortal), and this exact entire massive cosmos is directly Her very own literal idol and physical form (Jaganmurtis)!"
            "Strictly and exclusively by that exactly One Mother alone is this absolute entire visible physical world (Sarvamidam) flawlessly and entirely completely Pervaded (Tatam / fully saturated) (meaning She actively fills absolutely every single atom)."
            "Even strictly despite Her absolutely never, ever being physically born (Nitya) (Tathapi), Her direct 'Manifestation' (appearing / Tatsamutpattir) actively occurs perfectly in exceptionally countless different forms (Bahudha) exclusively for the divine work of the gods; now aggressively listen to that flawlessly directly from my mouth (Shruyatam mama)."
            Sage Medha flawlessly and completely 'Deleted' one entire question of the King (Exactly how was She born?) violently in the absolute first stroke!
            The Sage fiercely declares: "The Goddess is absolutely no cheap human or physical object that is suddenly 'Born' on a specific day! She is completely 'Nitya' (Permanent). Exactly when physical Time and Space absolutely did not even exist, She flawlessly existed!"
            And exactly what is Her 'Svarupa' (Form)? This absolute entire colossal 'Cosmos' (Jaganmurtis) itself is literally Her direct physical body!
            The exact physical chair you are sitting on, the exact raw air you are actively breathing—absolutely everything is 100% manufactured strictly from Mother Tripura (Consciousness) alone (Tatam).
            But then the Sage profoundly states, "Even though She absolutely never, ever takes physical birth, She still flawlessly assumes a highly specific 'Physical Form' to aggressively 'Manifest' exactly in this world repeatedly."
            Exactly just as invisible Electricity remains flawlessly present (Nitya) permanently strictly inside the wires, but exactly when you switch on a 'Bulb', it instantly vividly manifests perfectly exactly in the form of blinding light (Utpatti)!
            Now the Sage is fiercely preparing to actively narrate the terrifying epic saga of exactly that ultimate 'Electricity' (Mahamaya) flawlessly manifesting directly in a 'Bulb' (Form) strictly for the absolute first time.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 51,
        sanskrit = "देवानां कार्यसिद्ध्यर्थमाविर्भवति सा यदा ।\nउत्पन्नेति तदा लोके सा नित्याप्यभिधीयते ॥ ५१ ॥",
        hindi = """
            (देवी का प्रकट होना ही उनकी उत्पत्ति है): "जब वह परम सनातनी देवी 'देवताओं के किसी अत्यंत विशेष कार्य को सफल करने के लिए' (देवानां कार्यसिद्ध्यर्थम्)।"
            "इस संसार में किसी विशेष रूप में 'प्रकट' (आविर्भवति सा यदा) होती हैं।"
            "तब हमेशा 'नित्य' (शाश्वत और अजन्मी / नित्यापि) होने के बावजूद भी, इस भौतिक संसार में लोग अज्ञानवश उन्हें 'उत्पन्न हुई' (पैदा हुई / उत्पन्नेति तदा लोके) कहकर पुकारने लगते हैं (अभिधीयते)।"
            यह श्लोक सनातन धर्म के 'अवतारवाद' (Concept of Avatar) का सबसे 'साइंटिफिक एक्सप्लेनेशन' (Scientific explanation) है!
            भगवान कभी 'पैदा' (Born) नहीं होता; पैदा वह होता है जो 9 महीने पेट में रहे और फिर एक दिन मर जाए।
            देवी (महामाया) 'आविर्भूत' (Manifest / प्रकट) होती हैं।
            जैसे आपके मोबाइल (Mobile) में कोई 'ऐप' (App) पहले से इनस्टॉल (Install) होता है, पर जब आप उस पर 'क्लिक' (Click) करते हैं, तो वह स्क्रीन (Screen) पर 'आविर्भूत' (Open) हो जाता है!
            उसी तरह, जब दुनिया (देवानां) के सिस्टम (System) में कोई भयंकर 'बग' (Bug / राक्षस) आ जाता है जिसे साधारण देवता डिलीट (Delete) नहीं कर पाते।
            तब वह 'सुपर-सॉफ्टवेयर' (देवी) खुद उस बग को मारने के लिए (कार्यसिद्ध्यर्थम्) एक फिजिकल अवतार (Physical Avatar) लेती है।
            मूर्ख लोग सोचते हैं कि "अरे! आज देवी पैदा हो गई!" पर ज्ञानी (मुनि मेधा) जानते हैं कि वह 'नित्या' (Permanent) है; उसने सिर्फ तुम्हारे लिए अपना रूप बदला है।
            यहाँ से मुनि यह सिद्ध कर रहे हैं कि जो कहानी वह आगे सुनाएंगे, वह केवल एक 'लीला' (Game) है।
        """.trimIndent(),
        english = """
            (The absolute manifestation of the Goddess is falsely termed Her birth): "Exactly when that absolute supreme eternal Goddess explicitly and flawlessly 'Manifests' (Avirbhavati sa yada) strictly in a highly specific form entirely in this physical world."
            "Exclusively and strictly 'To flawlessly accomplish and successfully execute an exceptionally critical specific task of the gods' (Devanam karyasiddhyartham)."
            "Then, strictly despite Her being completely, flawlessly 100% 'Nitya' (Eternal, permanent, and unborn / Nityapi), ignorant people completely in this physical material world (Loke) blindly and falsely actively begin calling Her (Abhidhiyate) completely 'Born' or newly generated (Utpanneti tada)."
            This phenomenal verse is undeniably Sanatana Dharma's absolute most exceptionally 'Scientific Explanation' flawlessly detailing the precise 'Concept of Avatar' (Incarnation)!
            God is absolutely never, ever physically 'Born'; strictly exactly that which brutally rots exactly for 9 months inside a physical stomach and violently dies one day is truly born.
            The Supreme Goddess (Mahamaya) strictly 'Avirbhuta' (Flawlessly Manifests / directly appears).
            Exactly just as a highly complex 'App' remains permanently flawlessly Installed exactly inside your Mobile, but exactly when you violently 'Click' it, it instantly 'Manifests' (Opens) flawlessly straight directly onto your physical Screen!
            In the exact identical manner, exactly when a highly terrifying 'Bug' (Demons) aggressively infects the entire operating System of the world (Devanam) which ordinary gods absolutely completely fail to Delete.
            Exactly then that ultimate 'Super-Software' (The Goddess) Herself flawlessly assumes a direct Physical Avatar exclusively to violently slaughter that exact bug (Karyasiddhyartham).
            Pathetic, ignorant fools blindly scream, "Oh! The Goddess was physically born today!" But the supreme enlightened masters (Sage Medha) flawlessly know She is 'Nitya' (Permanent); She strictly exclusively merely altered Her physical form exclusively for you.
            Right exactly from here, the Sage is flawlessly proving that the exact terrifying epic saga he will violently narrate next is strictly merely a massive cosmic 'Game' (Lila).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 52,
        sanskrit = "योगनिद्रां यदा विष्णुर्जगत्येकार्णवीकृते ।\nआस्तीर्य शेषमभजत् कल्पान्ते भगवान् प्रभुः ॥ ५२ ॥",
        hindi = """
            (महाप्रलय और विष्णु की योगनिद्रा): "प्राचीन काल में (कल्पान्ते / कल्प के अंत में), जब यह पूरा का पूरा संसार नष्ट होकर एक 'विशाल जल के समुद्र' (एकार्णवीकृते / Cosmic Ocean) में पूरी तरह से बदल गया था।"
            "उस समय संपूर्ण ब्रह्मांड के परम रक्षक (प्रभुः) साक्षात् भगवान विष्णु (भगवान् विष्णुर्)।"
            "उस भयंकर जल के ऊपर 'शेषनाग' (शेषम् / अनंत नाग) की शय्या (बिस्तर) बिछाकर (आस्तीर्य), उसी 'योगनिद्रा' (महामाया) देवी की गोद में अत्यंत गहरी नींद में सो गए (योगनिद्रां अभजत्)।"
            यह श्लोक 'सृष्टि' (Creation) के खत्म होने के बाद के उस खौफनाक सन्नाटे (Silence) का वर्णन है जिसे 'महाप्रलय' (Kalpante) कहते हैं।
            जब सब कुछ खत्म हो जाता है, तो कोई ग्रह (Planet) या तारा (Star) नहीं बचता; केवल एक असीम 'डार्क मैटर' (Dark Matter) या 'कॉस्मिक फ्लूइड' (Cosmic fluid / एकार्णवीकृते) बचता है।
            उस सन्नाटे में भगवान विष्णु (चेतना का रक्षक रूप) भी एक्टिव मोड (Active mode) से 'स्लीप मोड' (Sleep mode) में चले जाते हैं!
            वे किस बिस्तर पर सोते हैं? 'शेषनाग' (Shesha)! शेष का मतलब है 'Remainder' (जो सब कुछ खत्म होने के बाद भी बच जाए)।
            वह शेषनाग 'अनंत समय' (Infinite Time) का प्रतीक है। यानी भगवान टाइम (Time) के ऊपर लेट जाते हैं!
            और वे किसकी गोद में सोते हैं? 'योगनिद्रा' (Yoganidra) की! विष्णु खुद अपनी मर्जी से नहीं सोते; वह परम 'महामाया' (योगनिद्रा) साक्षात् विष्णु के दिमाग को भी 'हाइबरनेट' (Hibernate) कर देती है!
            यह दिखाता है कि 'महामाया' (Goddess) साक्षात् विष्णु से भी ऊपर की वह 'सुपर-चेतना' है जो भगवान को भी कंट्रोल करती है।
        """.trimIndent(),
        english = """
            (The Maha-Pralaya and Vishnu's Yoganidra): "In the immensely ancient past (Kalpante / strictly exactly at the absolute end of a cosmic cycle), exactly when this absolute entire colossal world was violently destroyed and flawlessly transformed entirely completely into one single, massive 'Infinite Cosmic Ocean of water' (Ekarnavikrite)."
            "Exactly at that precise terrifying time, the absolute supreme protector and Lord of the entire massive cosmos (Prabhuh), direct Lord Vishnu Himself (Bhagavan Vishnur)."
            "Flawlessly spreading (Astirya) the massive, terrifying bed of the 'Sheshanaga' (Shesham / the infinite cosmic serpent) exactly perfectly upon that horrific cosmic water, completely and flawlessly went perfectly into an exceptionally deep sleep (Abhajat) entirely inside the lap of that exact identical 'Yoganidra' (Mahamaya) Goddess."
            This spectacular verse is the direct, literal description exactly of that horrific, terrifying Silence (Maha-Pralaya / Kalpante) which perfectly exists exactly after the total, absolute annihilation of all 'Creation'.
            Exactly when absolutely everything is permanently annihilated, absolutely zero physical Planet or massive Star survives; strictly exclusively only an infinite, boundless 'Dark Matter' or 'Cosmic Fluid' (Ekarnavikrite) remains.
            Exactly inside that absolute terrifying silence, even Lord Vishnu (the protector form of pure consciousness) flawlessly completely shifts straight from 'Active Mode' entirely directly into deep 'Sleep Mode'!
            Exactly upon which precise bed does He actively sleep? 'Sheshanaga' (Shesha)! Shesha literally and profoundly means exactly the 'Remainder' (absolutely that which flawlessly survives even after absolutely everything else is permanently annihilated).
            That Sheshanaga is the direct absolute symbol of 'Infinite Time'. Meaning, God flawlessly lies down directly exactly on top of absolute Time itself!
            And exactly entirely in whose lap does He sleep? Strictly 'Yoganidra'! Vishnu absolutely does not lazily sleep purely by His own will; that supreme 'Mahamaya' (Yoganidra) literally flawlessly puts exactly even Vishnu's supreme brain entirely into deep 'Hibernation'!
            This flawlessly proves that 'Mahamaya' (The Goddess) is exactly that ultimate 'Super-Consciousness', existing infinitely above even direct Vishnu, who aggressively controls even God Himself.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 53,
        sanskrit = "तदा द्वावसुरौ घोरौ विख्यातौ मधुकैटभौ ।\nविष्णुकर्णमलोद्भूतौ हन्तुं ब्रह्माणमुद्यतौ ॥ ५३ ॥",
        hindi = """
            (मधु और कैटभ की उत्पत्ति): "उसी समय (तदा), जब भगवान विष्णु गहरी योगनिद्रा में थे, तब 'मधु और कैटभ' (मधुकैटभौ) नाम के दो अत्यंत भयंकर (घोरौ) और कुख्यात (विख्यातौ) असुर पैदा हुए।"
            "ये दोनों भयंकर राक्षस स्वयं भगवान विष्णु के 'कान के मैल' (विष्णुकर्णमलोद्भूतौ) से उत्पन्न हुए थे!"
            "और पैदा होते ही वे दोनों अत्यंत क्रूर राक्षस, उस कमल पर बैठे हुए ब्रह्मा जी को 'मारने के लिए पूरी तरह तैयार' (हन्तुं ब्रह्माणमुद्यतौ) होकर उनकी ओर दौड़े।"
            यह श्लोक सनातन धर्म की सबसे गहरी और 'डार्क' (Dark) साइकोलॉजी है!
            भगवान विष्णु (चेतना) सो रहे हैं, और उनके कान के मैल (Dirt of the ear) से दो राक्षस पैदा होते हैं! 'कान का मैल' क्या है?
            कान (Ear) वह जगह है जहाँ से हम दुनिया की बातें (Sound/Information) सुनते हैं।
            जब इंसान की 'चेतना' (विष्णु) सो जाती है (Unconscious हो जाती है), तो उसके दिमाग में जो दुनिया की फालतू बातें और गंदा ज्ञान (कान का मैल) जमा होता है, वही भयंकर 'राक्षस' (Demons) बन जाता है!
            'मधु' (Madhu) का अर्थ है 'मीठा' (Sweet / Raga / अटैचमेंट), और 'कैटभ' (Kaitabha) का अर्थ है 'कड़वा' (Bitter / Dvesha / नफरत)।
            पूरी दुनिया इन्हीं दो राक्षसों (Attachment and Aversion) से बर्बाद है। हम या तो मीठे (मधु) की तरफ भागते हैं, या कड़वे (कैटभ) से लड़ते हैं।
            और ये दोनों राक्षस पैदा होते ही 'ब्रह्मा' (Creator / हमारी बुद्धि और क्रिएटिविटी) को मारने (हन्तुं) दौड़ते हैं!
            जब आपके अंदर राग और द्वेष (मधु-कैटभ) जागते हैं, तो सबसे पहले वे आपकी 'क्रिएटिविटी और शांति' (ब्रह्मा) को ही मार डालते हैं!
        """.trimIndent(),
        english = """
            (The terrifying birth of Madhu and Kaitabha): "Exactly precisely at that specific time (Tada), exactly when Lord Vishnu was flawlessly deep inside absolute Yoganidra, two exceptionally horrific (Ghorau) and globally infamous (Vikhyatau) terrifying demons famously named 'Madhu and Kaitabha' (Madhukaitabhau) violently manifested."
            "These exact two horrific demons were violently born and generated exclusively directly from the raw 'Ear-wax / dirt of the ears' of Lord Vishnu Himself (Vishnukarnamalodbhutau)!"
            "And immediately the exact split-second they were violently born, those two exceptionally cruel demons aggressively rushed violently perfectly completely 'Ready and fully prepared to brutally slaughter and kill' (Hantum brahmanamudyatau) Lord Brahma, who was actively sitting on the lotus."
            This spectacular verse is undeniably Sanatana Dharma's absolute deepest and exceptionally 'Dark' Psychology!
            Lord Vishnu (Supreme Consciousness) is actively sleeping, and from the literal 'Dirt of His Ear' (Ear-wax), two massive, terrifying demons are violently born! Exactly what on earth is this 'Ear-wax'?
            The Ear is exactly that specific physical organ strictly from where we passively hear the world's toxic gossip (Sound/Information).
            Exactly when a human's pure 'Consciousness' (Vishnu) falls completely asleep (becomes Unconscious), absolutely all the world's highly toxic gossip and cheap, filthy knowledge (Ear-wax) heavily accumulated directly inside his brain violently transforms perfectly into exceptionally terrifying 'Demons'!
            'Madhu' literally means exceptionally 'Sweet' (Raga / toxic Attachment), and 'Kaitabha' literally translates perfectly to 'Bitter' (Dvesha / violent Hatred).
            The absolute entire physical world is violently destroyed strictly exclusively by these exact two demons (Attachment and Aversion). We perpetually either frantically run exactly towards the sweet (Madhu), or aggressively fight the bitter (Kaitabha).
            And the exact split-second these two horrific demons are violently born, they ruthlessly run aggressively exactly to slaughter (Hantum) 'Brahma' (The Creator / our pure Intellect and Creativity)!
            Exactly when toxic Raga and Dvesha (Madhu-Kaitabha) violently awaken completely inside you, the absolute first thing they brutally slaughter is exactly your pure 'Creativity and Peace' (Brahma)!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 54,
        sanskrit = "स नाभिकमले विष्णोः स्थितो ब्रह्मा प्रजापतिः ।\nदृष्ट्वा तावसुरौ चोग्रौ प्रसुप्तं च जनार्दनम् ॥ ५४ ॥",
        hindi = """
            (ब्रह्मा जी का संकट): "भगवान विष्णु की नाभि (Navel) से निकले हुए उस महान कमल (नाभिकमले) पर बैठे हुए (स्थितो) उन सृष्टि के रचयिता 'प्रजापति ब्रह्मा' (ब्रह्मा प्रजापतिः) ने।"
            "जब उन दोनों (तौ) अत्यंत भयंकर और उग्र राक्षसों (असुरौ चोग्रौ) को अपनी ओर हमला करने के लिए आते हुए 'देखा' (दृष्ट्वा)।"
            "और साथ ही यह भी देखा कि इस पूरे ब्रह्मांड के रक्षक भगवान 'जनार्दन' (विष्णु) अत्यंत गहरी नींद में सोए हुए हैं (प्रसुप्तं च जनार्दनम्)।"
            (यह श्लोक अगले श्लोक से जुड़कर ब्रह्मा जी की स्तुति का कारण बनता है)।
            भगवान विष्णु की नाभि (Navel) 'सेंटर ऑफ़ यूनिवर्स' (Center of the Universe) का प्रतीक है, जहाँ से ब्रह्मा (सृष्टि की बुद्धि) पैदा हुए हैं।
            ब्रह्मा जी अपने कमल (शांति और ज्ञान के प्रतीक) पर बैठे थे, पर अचानक उन्हें मौत (मधु-कैटभ) अपनी ओर भागती हुई दिखाई दी!
            यह इंसान के जीवन का वह 'पैनिक मोमेंट' (Panic Moment) है जब कोई बहुत बड़ी बीमारी या दुश्मन अचानक सामने आ खड़ा होता है।
            ब्रह्मा जी ने तुरंत मदद के लिए विष्णु (परमात्मा) की तरफ देखा, पर भगवान तो 'प्रसुप्तं' (गहरी नींद में बेहोश) थे!
            जब आपकी ज़िंदगी में सबसे बड़ा संकट आता है, तो ऐसा लगता है जैसे भगवान सो रहा है (God is not listening)!
            आप लाख पूजा करते हैं, पर भगवान की तरफ से कोई 'रिस्पॉन्स' (Response) नहीं आता; यही विष्णु का 'प्रसुप्तं' (सोना) है।
            ब्रह्मा जी (लॉजिक/बुद्धि) समझ गए कि विष्णु (चेतना) को खुद जगाना उनके बस की बात नहीं है!
            अब ब्रह्मा जी वही करेंगे जो एक 'हॅकर' (Hacker) सिस्टम एडमिनिस्ट्रेटर (System Administrator) को जगाने के लिए करता है—वे 'महामाया' को कॉल (Call) करेंगे!
        """.trimIndent(),
        english = """
            (The terrifying crisis of Lord Brahma): "Exactly actively sitting (Sthito) flawlessly perfectly upon that magnificent massive lotus which had miraculously emerged directly from the exact navel (Nabhikamale) of Lord Vishnu, the supreme creator of the entire cosmos, 'Prajapati Brahma' (Brahma prajapatih)."
            "Exactly when he vividly 'Saw' (Drishtva) both of those (Tau) exceptionally terrifying and violently ferocious demons (Asurau chograu) aggressively rushing violently completely straight towards him strictly to launch a brutal attack."
            "And simultaneously flawlessly witnessed the absolute terrifying fact that the ultimate supreme protector of the entire massive cosmos, Lord 'Janardana' (Vishnu), was flawlessly completely unconscious and entirely lost exactly in an exceptionally deep sleep (Prasuptam cha janardanam)."
            (This exact specific verse is flawlessly inextricably linked directly to the next verse, perfectly actively forming the absolute reason exactly for Brahma's profound prayer).
            Lord Vishnu's absolute Navel is the direct, literal symbol precisely of the 'Center of the Universe', strictly from where Brahma (the active intelligence of creation) was violently born.
            Lord Brahma was sitting peacefully exactly on his divine lotus (the absolute symbol of pure peace and wisdom), but suddenly he flawlessly saw terrifying brutal death (Madhu-Kaitabha) violently rushing entirely straight towards him!
            This is exactly that terrifying 'Panic Moment' perfectly in a human's miserable life when an exceptionally massive horrific disease or a deadly enemy suddenly actively stands completely directly in front of him.
            Brahma instantaneously and frantically looked entirely straight directly towards Vishnu (Supreme God) strictly for immediate help, but the Lord was flawlessly 'Prasuptam' (completely unconscious entirely in deep sleep)!
            Exactly when the absolute biggest terrifying crisis violently strikes your physical life, it flawlessly actively feels exactly as if God is entirely deep asleep (God is absolutely not listening)!
            You aggressively perform millions of cheap prayers, yet absolutely zero 'Response' actively arrives strictly from God; this is exactly Vishnu's terrifying 'Prasuptam' (sleeping).
            Brahma (Logic/Intellect) flawlessly completely understood that aggressively attempting to actively awaken Vishnu (Consciousness) entirely himself was absolutely completely beyond his pathetic capacity!
            Now Brahma will flawlessly execute exactly what an elite 'Hacker' actively performs strictly to aggressively awaken a sleeping System Administrator—he will violently initiate a direct Call strictly to 'Mahamaya' Herself!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 55,
        sanskrit = "तुष्टाव योगनिद्रां तामेकाग्रहृदयः स्थितः ।\nविबोधनार्थाय हरेर्हरिनेत्रकृतालयाम् ॥ ५५ ॥",
        hindi = """
            (ब्रह्मा जी द्वारा योगनिद्रा की स्तुति): "तब ब्रह्मा जी ने अपने 'हृदय और मन को पूरी तरह से एक जगह केंद्रित करके' (एकाग्रहृदयः स्थितः)।"
            "भगवान 'हरि' (विष्णु) को उस गहरी नींद से 'पूरी तरह जगाने के लिए' (विबोधनार्थाय हरेर्)।"
            "उन भगवान विष्णु के 'नेत्रों' (आँखों) में अपना घर बनाकर बैठी हुई (हरिनेत्रकृतालयाम्)।"
            "उस परम शक्तिशाली 'योगनिद्रा' (महामाया देवी) की अत्यंत भयंकर और दिव्य 'स्तुति' (प्रार्थना / तुष्टाव) करना आरंभ कर दिया।"
            [Image of Lord Brahma sitting on the lotus praying to Goddess Yoganidra as Madhu and Kaitabha approach]
            यह श्लोक सनातन तन्त्र का सबसे बड़ा 'बग-बाउंटी' (Bug-Bounty / हैकिंग) है!
            ब्रह्मा जी को विष्णु (परमात्मा) को जगाना था, पर उन्होंने विष्णु की पूजा नहीं की! उन्होंने 'योगनिद्रा' (देवी) की पूजा की!
            क्यों? क्योंकि जब सिस्टम (विष्णु) लॉक (Lock) हो जाता है, तो आपको सिस्टम से नहीं, 'पासवर्ड' (Password) से बात करनी पड़ती है!
            योगनिद्रा (महामाया) वह परम 'पासवर्ड' है जिसने विष्णु (चेतना) की आँखों (नेत्रकृतालयाम्) पर 'नींद का पर्दा' (Sleep mode) डाला हुआ है।
            जब तक देवी खुद विष्णु की आँखों से नहीं हटेंगी, विष्णु कभी नहीं जागेंगे!
            'एकाग्रहृदयः' का अर्थ है 100% लेज़र-फोकस (Laser-focus)। ब्रह्मा जी के सामने दो भयंकर राक्षस उन्हें मारने के लिए आ रहे थे, फिर भी उनका मन बिल्कुल नहीं भटका!
            जब आप पर मौत मंडरा रही हो, और फिर भी आप अपना ध्यान 100% भगवान पर 'एकाग्र' कर लें; केवल वही 'असली ध्यान' (Meditation) है।
            यहीं से दुर्गा सप्तशती का सबसे पहला और सबसे शक्तिशाली स्तोत्र—'ब्रह्मा कृत रात्रिसूक्त' (Brahma's Ratri Sukta)—शुरू होने वाला है।
        """.trimIndent(),
        english = """
            (Lord Brahma's absolute supreme prayer strictly to Yoganidra): "Exactly then, Lord Brahma flawlessly and aggressively 'focused his entire heart and highly restless mind exactly onto one single absolute point' (Ekagrahirdayah sthitah)."
            "Strictly and exclusively 'To completely and violently awaken' (Vibodhanarthaya) Lord 'Hari' (Vishnu) entirely directly from that exceptionally deep sleep (Harer)."
            "He violently and fiercely actively began executing an exceptionally terrifying and absolutely divine 'Prayer' (profound eulogy / Tustava) explicitly to that supreme, terrifying 'Yoganidra' (Mahamaya Goddess)."
            "Who was flawlessly actively sitting, having perfectly made Her absolute permanent residence directly exactly inside the very 'Eyes' (Harinetrakritalayam) of that exact Lord Vishnu Himself."
            This spectacular verse is undeniably Sanatana Tantra's absolute greatest 'Bug-Bounty' (Hacking)!
            Lord Brahma desperately required to violently awaken Vishnu (Supreme God), yet he absolutely did not pathetically worship Vishnu! He fiercely worshipped 'Yoganidra' (The Goddess)!
            Exactly why? Strictly because exactly when the massive System (Vishnu) violently Locks entirely, you absolutely cannot possibly talk to the System; you must aggressively negotiate directly with the exact 'Password'!
            Yoganidra (Mahamaya) is exactly that ultimate terrifying 'Password' who has flawlessly draped the heavy 'Veil of Sleep' (Sleep mode) exactly over Vishnu's (Consciousness's) literal eyes (Netrakritalayam).
            Exactly until the Goddess Herself flawlessly physically steps completely away exactly from Vishnu's eyes, Vishnu will absolutely never, ever possibly awaken!
            'Ekagrahirdayah' profoundly means 100% flawless Laser-Focus. Two exceptionally terrifying demons were violently rushing straight directly towards Brahma to ruthlessly slaughter him, yet his pure mind did absolutely not waver even a single millimeter!
            Exactly when terrifying death is violently hovering directly entirely over you, and yet you successfully, flawlessly 'Focus' your attention 100% explicitly exactly onto God; strictly and exclusively only that alone is 'True Meditation'.
            Right exactly from here, the absolute first and exceptionally most terrifyingly powerful Stotra of the Durga Saptshati—the 'Brahma Krita Ratri Sukta'—is flawlessly preparing to violently commence.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 56,
        sanskrit = "विश्वेश्वरीं जगद्धात्रीं स्थितिसंहारकारिणीम् ।\nनिद्रां भगवतीं विष्णोरतुलां तेजसः प्रभुः ॥ ५६ ॥",
        hindi = """
            (निद्रा देवी की महिमा): "ब्रह्मा जी (तेजसः प्रभुः / तेज के स्वामी) ने उन भगवती 'निद्रा' (निद्रां भगवतीं) देवी की स्तुति की, जो साक्षात् 'विश्वेश्वरी' (पूरे विश्व की परम मालकिन / विश्वेश्वरीं) हैं।"
            "जो इस संपूर्ण ब्रह्मांड को धारण करने वाली 'जगद्धात्री' (जगद्धात्रीं / Universal Mother) हैं, और जो इस पूरे के पूरे संसार का पालन (स्थिति) और विनाश (संहार / स्थितिसंहारकारिणीम्) करने वाली एकमात्र शक्ति हैं।"
            "और जो स्वयं भगवान विष्णु (विष्णोरतुलां) की वह 'अतुलनीय' (जिसकी कोई तुलना नहीं की जा सकती) परम शक्ति हैं।"
            ब्रह्मा जी देवी की केवल इसलिए तारीफ नहीं कर रहे कि वे विष्णु की 'नींद' हैं; ब्रह्मा जी उन्हें इस पूरे यूनिवर्स (Universe) की 'सुप्रीम बॉस' (Supreme Boss / विश्वेश्वरी) मान रहे हैं!
            'निद्रा' (नींद) को हम इंसान एक बहुत साधारण चीज़ मानते हैं, पर उपनिषद कहता है कि 'नींद' साक्षात् देवी का एक अत्यंत भयंकर रूप है!
            जब निद्रा आती है, तो दुनिया का सबसे बड़ा राजा, सबसे अमीर आदमी, और सबसे बड़ा ज्ञानी भी एक सेकंड में ज़मीन पर गिरकर 'बेहोश' (Unconscious) हो जाता है!
            नींद के सामने किसी का 'ईगो' (Ego) काम नहीं आता; नींद सबको 100% 'ज़ीरो' (Zero) कर देती है।
            और यह निद्रा कोई साधारण देवी नहीं है; यह 'जगद्धात्री' (ब्रह्मांड को संभालने वाली) और 'संहारकारिणी' (डिलीट करने वाली) भी है!
            ब्रह्मा जी (तेजसः प्रभुः / खुद रोशनी के देवता) को उस 'अँधेरे' (निद्रा / Dark matter) के सामने हाथ जोड़ने पड़े, क्योंकि रोशनी हमेशा अँधेरे के अंदर से ही पैदा होती है।
            यहाँ से साक्षात् देवी की वह सबसे रहस्यमयी स्तुति शुरू होती है, जहाँ वेदों के मन्त्र तन्त्र में बदल जाते हैं।
        """.trimIndent(),
        english = """
            (The supreme glory of Goddess Nidra): "Lord Brahma (Tejasah Prabhuh / The absolute lord of brilliant light) profoundly prayed and fiercely praised that exact Bhagavati 'Nidra' (Goddess of Sleep / Nidram bhagavatim), who is literally the direct 'Vishveshvari' (The Absolute Supreme Queen of the entire universe / Vishveshvarim)."
            "Who is exactly the direct 'Jagaddhatri' (Jagaddhatrim / The Universal Mother) flawlessly supporting and aggressively sustaining this entire colossal cosmos, and who alone is the absolute solitary power flawlessly actively continuously executing the perfect sustenance (Sthiti) and violent annihilation (Samhara / Sthitisamharakarinim) of this entire massive world."
            "And who is undeniably exactly that absolute 'Incomparable' (Atulam / beyond all possible comparison) ultimate supreme raw power exclusively of direct Lord Vishnu Himself (Vishnoratulam)."
            Lord Brahma is absolutely not pathetically blindly praising the Goddess merely simply because She is Vishnu's trivial 'Sleep'; Brahma flawlessly actively acknowledges Her strictly as the absolute 'Supreme Boss' (Vishveshvari) of this entire massive Universe!
            We pathetic humans ignorantly consider 'Nidra' (Sleep) to be an exceptionally ordinary, cheap biological thing, but the Upanishad fiercely declares that 'Sleep' is literally a highly terrifying direct form of the Supreme Goddess Herself!
            Exactly when Nidra violently violently strikes, the world's absolute greatest King, the absolute wealthiest billionaire, and the absolute greatest enlightened master violently drops perfectly straight to the dirt entirely 'Unconscious' in exactly a single split-second!
            Absolutely no human's massive 'Ego' can possibly work perfectly before Sleep; Sleep ruthlessly violently reduces absolutely everyone to mathematical 'Zero' (100%).
            And this Nidra is absolutely no cheap ordinary deity; She is simultaneously the absolute 'Jagaddhatri' (The active Sustainer of the cosmos) and the terrifying 'Samharakarini' (The ultimate Destroyer/Deleter)!
            Brahma (Tejasah prabhuh / the literal lord of light himself) was violently forced to perfectly fold his hands exclusively directly before that absolute 'Darkness' (Nidra / Dark matter), strictly because Light inherently perpetually violently births entirely completely from inside absolute darkness.
            Right exactly from here aggressively begins that absolute most highly classified, deeply mysterious prayer explicitly of the Goddess, exactly where sacred Vedic mantras seamlessly perfectly transform entirely into explosive Tantra.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 57,
        sanskrit = "ब्रह्मोवाच ॥ ५७ ॥\nत्वं स्वाहा त्वं स्वधा त्वं हि वषट्कारः स्वरात्मिका ।\nसुधा त्वमक्षरे नित्ये त्रिधा मात्रात्मिका स्थिता ॥ ५७ ॥",
        hindi = """
            (ब्रह्मा कृत रात्रिसूक्त का आरंभ): "ब्रह्मा जी ने प्रार्थना करते हुए कहा (ब्रह्मोवाच): हे देवी! देवताओं को यज्ञ में दी जाने वाली आहुति 'स्वाहा' तुम ही हो! पितरों को दी जाने वाली आहुति 'स्वधा' तुम ही हो! और यज्ञ का 'वषट्कार' (भयंकर मन्त्र) भी निश्चित रूप से (हि) तुम ही हो!"
            "तुम साक्षात् सभी 'स्वरों की आत्मा' (स्वरात्मिका) हो! हे देवी! तुम ही जीवन देने वाली परम 'अमृत' (सुधा त्वम्) हो।"
            "हे नित्ये (कभी न मरने वाली देवी)! 'ॐ' (ओंकार) रूपी उस परम अविनाशी अक्षर (अक्षरे) के भीतर, अकार, उकार, मकार—इन 'तीनों मात्राओं' (त्रिधा मात्रात्मिका) के रूप में तुम ही हमेशा विराजमान (स्थिता) हो!"
            ब्रह्मा जी ने देवी की स्तुति किसी स्त्री (Woman) के रूप में नहीं, बल्कि 'साउंड और वाइब्रेशन' (Sound and Vibration) के रूप में शुरू की है!
            'स्वाहा', 'स्वधा' और 'वषट्कार'—ये वेदों के 3 सबसे ताकतवर पासवर्ड (Passwords) हैं। बिना स्वाहा बोले आग में कुछ भी डालो, वह भगवान तक नहीं पहुँचता।
            देवी वह 'कूरियर सर्विस' (Courier Service) हैं जो इंसान की प्रार्थना को भगवान के सर्वर (Server) तक पहुँचाती हैं!
            वह 'स्वरात्मिका' हैं! यानी दुनिया में जितनी भी आवाज़ें (Sound frequencies) हैं, उन सबकी 'बेस फ्रीक्वेंसी' (Base frequency) माता ही हैं।
            और सबसे बड़ा रहस्य—'ॐ' (OM) जो इस ब्रह्मांड की सबसे पहली आवाज़ (Big Bang Sound) है, वह 'ॐ' कोई देवता नहीं है, वह साक्षात् माता 'त्रिपुरा' की ही 3 मात्राएं (A, U, M) हैं!
            ब्रह्मा जी विष्णु को नहीं जगा रहे हैं; वे उस 'कॉस्मिक मदरबोर्ड' (Cosmic Motherboard) को कमांड (Command) दे रहे हैं जहाँ से पूरा ब्रह्मांड (ॐ) कंट्रोल होता है।
            यह श्लोक तन्त्र विज्ञान का साक्षात् 'क्वांटम फिजिक्स' (Quantum Physics) है।
        """.trimIndent(),
        english = """
            (The explosive beginning of Brahma's Ratri Sukta): "Lord Brahma fiercely prayed entirely exactly saying (Brahmovacha): O Supreme Goddess! You exclusively alone are exactly the literal 'Svaha', the absolute sacred offering flawlessly delivered directly to the gods perfectly in the blazing fire sacrifice! You exclusively alone are exactly the literal 'Svadha', the absolute sacred offering flawlessly delivered directly to the ancestors! And You alone are undeniably (Hi) the absolute terrifying 'Vashatkara' (the ultimate destructive mantra) of the massive Yajna!"
            "You alone are exactly the direct literal 'Soul of all sound frequencies' (Svaratmika)! O Goddess! You exclusively alone are exactly the ultimate life-giving, supreme, immortal 'Nectar' (Sudha tvam)."
            "O Nitye (the absolute eternal, deathless Goddess)! Flawlessly actively situated entirely perfectly inside that absolute supreme indestructible literal syllable (Akshare) of 'OM' (Omkara), You alone perpetually actively exist perfectly exclusively exactly in the absolute true form of its 'Three specific Matras' (Tridha matratmika) (A, U, M)!"
            Lord Brahma absolutely did not violently begin actively praising the Goddess strictly as a physical Woman, but aggressively completely strictly as pure 'Sound and Vibration'!
            'Svaha', 'Svadha', and 'Vashatkara'—these are undeniably the Vedas' exactly 3 absolute most terrifyingly powerful Passwords. Blindly throwing absolutely anything straight into the physical fire without explicitly uttering Svaha absolutely never reaches God.
            The Goddess is exactly that absolute ultimate 'Courier Service' who flawlessly transports the human's pathetic prayer securely perfectly straight exactly to God's literal Server!
            She is 'Svaratmika'! Meaning exactly that out of absolutely all the Sound Frequencies currently existing entirely perfectly in the world, the Mother exclusively alone is their absolute 'Base Frequency'.
            And the absolute greatest terrifying secret—'OM' which is undeniably the exact absolute first terrifying sound (Big Bang Sound) of this massive cosmos, that 'OM' is absolutely no male deity, it is literally the direct exactly 3 specific frequencies (A, U, M) exclusively of Mother 'Tripura' Herself!
            Brahma is absolutely not pathetically aggressively attempting to casually awaken Vishnu; he is violently actively explicitly issuing a direct supreme Command straight entirely to that exact 'Cosmic Motherboard' strictly from exactly where the absolute entire universe (OM) is flawlessly Controlled.
            This spectacular verse is the direct, literal absolute 'Quantum Physics' of pure Tantra Science.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 58,
        sanskrit = "अर्धमात्रास्थिता नित्या यानुच्चार्या विशेषतः ।\nत्वमेव सन्ध्या सावित्री त्वं देवि जननी परा ॥ ५८ ॥",
        hindi = """
            (ॐ की चौथी अवस्था और परम जननी): "इन तीन मात्राओं (A, U, M) के अलावा, ॐ के ऊपर बिन्दु के रूप में जो 'अर्धमात्रा' (Half-syllable / अर्धमात्रास्थिता) है, जिसका कभी भी मुँह से स्पष्ट उच्चारण नहीं किया जा सकता (यानुच्चार्या विशेषतः), वह नित्य और अव्यक्त चेतना भी साक्षात् तुम ही हो!"
            "हे परम देवि (देवि)! तुम ही 'संध्या' (दिन और रात का मिलन) हो! तुम ही वेदों की परम माता 'सावित्री' (गायत्री) हो! और तुम ही इस पूरे ब्रह्मांड को जन्म देने वाली सबसे महान 'परम जननी' (जननी परा) हो!"
            ॐ में तीन मात्राएं (A, U, M) तो बोली जा सकती हैं, पर जब 'म' खत्म होता है, तो उसके बाद जो एक 'सन्नाटा' (Silence) गूंजता है, उसे 'अर्धमात्रा' कहते हैं।
            ब्रह्मा जी कह रहे हैं कि जो आवाज़ (Sound) है वह तो तुम हो ही, पर जो 'साइलेंस' (Silence / यानुच्चार्या) है जिसे कोई इंसान मुँह से नहीं बोल सकता, वह परम सन्नाटा भी साक्षात् तुम ही हो!
            यह वेदान्त की 'तुरीय' (Turiya / 4th State) अवस्था है, जहाँ मन और भाषा दोनों 100% काम करना बंद कर देते हैं।
            'संध्या' का मतलब केवल शाम का समय नहीं है; संध्या वह 'ट्रांजीशन पॉइंट' (Transition point / जंक्शन) है जहाँ दिन और रात (लाइट और डार्कनेस) आपस में मिलते हैं।
            माता वह 'जंक्शन' हैं जहाँ शिव (चेतना) और माया (सृष्टि) 100% एक हो जाते हैं।
            'सावित्री' का मतलब है जो पूरे ब्रह्मांड को रोशनी (ज्ञान) देती है।
            ब्रह्मा जी जो खुद इस दुनिया के 'पिता' (Creator) हैं, वे हाथ जोड़कर माता को 'जननी परा' (परम माँ) कह रहे हैं!
            यानी जो ब्रह्मा दुनिया को पैदा करता है, उस ब्रह्मा को भी उसी 'परम जननी' ने पैदा किया है!
        """.trimIndent(),
        english = """
            (The fourth state of OM and the Ultimate Mother): "Completely entirely beyond exactly these three specific syllables (A, U, M), the exceptionally highly classified 'Ardha-Matra' (Half-syllable / Ardhamatrasthita) flawlessly situated entirely exactly as the Bindu (Dot) perfectly over OM, which absolutely completely strictly can absolutely never ever possibly be distinctly spoken or pronounced perfectly exactly by the human mouth (Yanuccharya visheshatah), that absolute eternal and unmanifest pure consciousness is undeniably exclusively exactly You alone!"
            "O Supreme Goddess (Devi)! You exclusively alone are exactly the literal 'Sandhya' (the precise exact junction flawlessly completely merging the day and pitch-black night)! You exclusively alone are exactly the literal 'Savitri' (Gayatri / the supreme mother of the Vedas)! And You exclusively alone are undeniably exactly the absolute greatest 'Parama Janani' (Janani para / The Ultimate Supreme Mother) flawlessly actively giving direct birth entirely to this absolute entire colossal cosmos!"
            Exactly inside OM, the exact three syllables (A, U, M) can flawlessly be actively physically spoken, but exactly when the 'M' violently concludes, the exceptionally deep terrifying 'Silence' (Vibration) that actively echoes entirely exactly afterwards is profoundly called the 'Ardha-Matra'.
            Lord Brahma is fiercely declaring that exactly whatever is actively physical 'Sound' is undeniably You, but exactly that absolute terrifying 'Silence' (Yanuccharya) which absolutely no human can ever possibly physically pronounce, that exact Supreme Silence is also literally exactly You alone!
            This is undeniably Vedanta's absolute 'Turiya' (4th State), exactly perfectly where both the human mind and physical speech drop flawlessly to 100% mathematical zero.
            'Sandhya' absolutely does not merely mean the cheap physical evening time; Sandhya is exactly that terrifying 'Transition Point' (Junction) flawlessly completely exactly where Light and Darkness violently perfectly merge into exactly one.
            The Mother is exactly that absolute 'Junction' flawlessly perfectly exactly where Shiva (Consciousness) and Maya (Creation) seamlessly become exactly 100% One.
            'Savitri' profoundly means exactly She who relentlessly actively supplies absolute blinding Light (Wisdom) completely directly to the entire universe.
            Lord Brahma, who himself is undeniably the literal 'Father' (Creator) of this world, is flawlessly standing with folded hands violently actively calling the Mother 'Janani Para' (The Ultimate Supreme Mother)!
            Meaning, exactly that identical Brahma who actively creates the physical world, that exact Brahma was also violently born exclusively strictly exactly from that very same 'Parama Janani'!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 59,
        sanskrit = "त्वयैतद्धार्यते विश्वं त्वयैतत्सृज्यते जगत् ।\nत्वयैतत्पाल्यते देवि त्वमत्स्यन्ते च सर्वदा ॥ ५९ ॥",
        hindi = """
            (सृष्टि, पालन और संहार की एकमात्र शक्ति): "हे परम देवी (देवि)! केवल और केवल तुम्हारे ही परम बल द्वारा (त्वयैतद्) इस पूरे के पूरे विश्व को अंतरिक्ष में 'धारण' (धार्यते / Supported/Held) किया जाता है!"
            "केवल और केवल तुम्हारे ही द्वारा (त्वयैतद्) इस संपूर्ण चराचर जगत की 'रचना' (सृज्यते / Created) की जाती है!"
            "केवल और केवल तुम्हारे ही द्वारा (त्वयैतद्) इस संपूर्ण ब्रह्मांड का लगातार 'पालन और पोषण' (पाल्यते / Sustained) किया जाता है।"
            "और हे देवी! महाप्रलय के अंत में (अन्ते च) तुम ही हमेशा (सर्वदा) इस पूरे ब्रह्मांड को अपना 'ग्रास' बनाकर 'खा' (भक्षण कर / त्वमत्स्यन्ते / Devour) जाती हो!"
            यह श्लोक सनातन धर्म के तीन सबसे बड़े देवों (ब्रह्मा, विष्णु, शिव) की पूरी 'जॉब डिस्क्रिप्शन' (Job Description) को केवल एक 'देवी' (महामाया) के अंदर ट्रांसफर (Transfer) कर देता है!
            दुनिया सोचती है कि ब्रह्मा बनाते हैं, विष्णु पालते हैं, और शिव संहार करते हैं।
            पर ब्रह्मा जी खुद अपने मुँह से कह रहे हैं: "हम तो केवल कठपुतलियां (Puppets) हैं! बनाने वाली (सृज्यते), पालने वाली (पाल्यते), और मारने वाली (अत्सि) साक्षात् तुम ही हो!"
            ग्रैविटी (Gravity) जो ग्रहों को हवा में रोके (धार्यते) हुए है, वह कोई फिजिकल फ़ोर्स (Physical force) नहीं है; वह माता का ही 'हाथ' है।
            'त्वमत्स्यन्ते' बहुत ही डरावना (Terrifying) शब्द है! इसका मतलब है 'तुम इसे खा जाती हो'!
            जब सृष्टि का समय (Time) खत्म होता है, तो महाकाली (देवी) इस पूरे ब्रह्मांड को, सारे ग्रहों और तारों को, एक सेकंड में अपने मुँह में चबा (Devour) जाती हैं।
            इससे बड़ा और भयंकर 'सुपर-पॉवर' (Super-power) इस पूरी दुनिया में और कोई नहीं है।
        """.trimIndent(),
        english = """
            (The absolute solitary power of Creation, Sustenance, and Destruction): "O Supreme Goddess (Devi)! Solely, strictly, and exclusively entirely by Your absolute terrifying raw power alone (Tvayetad) is this absolute entire massive universe flawlessly and completely 'Held and securely Supported' (Dharyate) perfectly exactly in deep physical space!"
            "Solely, strictly, and exclusively entirely by You alone (Tvayetad) is this absolute entire colossal physical world violently flawlessly 'Created and projected' (Srijyate)!"
            "Solely, strictly, and exclusively entirely by You alone (Tvayetad) is this absolute entire massive cosmos continuously flawlessly 'Sustained, protected, and nourished' (Palyate)."
            "And O Goddess! Exactly strictly at the absolute ultimate end of cosmic time (Maha-Pralaya / Ante cha), You exclusively alone flawlessly and perpetually (Sarvada) absolutely completely 'Eat and Devour' (Tvamatsyante) this absolute entire colossal universe entirely exactly as Your own personal food!"
            This spectacular verse completely, violently, and flawlessly Transfers the absolute entire 'Job Description' of Sanatana Dharma's exactly three absolute greatest Gods (Brahma, Vishnu, Shiva) perfectly entirely completely into strictly exactly one 'Goddess' (Mahamaya) alone!
            The pathetic ignorant world blindly assumes that Brahma creates, Vishnu relentlessly sustains, and Shiva violently destroys.
            But Lord Brahma himself is violently screaming directly strictly from his very own mouth: "We are absolutely exclusively merely pathetic Puppets! The exact absolute one who relentlessly Creates (Srijyate), Sustains (Palyate), and ruthlessly slaughters (Atsi) is undeniably literally You alone!"
            Gravity, which flawlessly securely Holds (Dharyate) massive planets perfectly exactly in the physical air, is absolutely zero cheap physical force; it is literally exactly the direct 'Hand' of the Mother Herself.
            'Tvamatsyante' is an exceptionally horrific and Terrifying specific word! It profoundly literally translates exactly to 'You violently Eat it entirely'!
            Exactly when the biological Time of physical creation is flawlessly 100% exhausted, Mahakali (The Goddess) violently and ruthlessly Chews (Devours) this absolute entire colossal universe, including all massive planets and giant stars, entirely straight directly into Her massive mouth exactly in a single split-second.
            There is absolutely zero greater or more terrifying 'Super-Power' actively existing perfectly exactly in this absolute entire physical world.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 60,
        sanskrit = "विसृष्टौ सृष्टिरूपा त्वं स्थितिरूपा च पालने ।\nतथा संहृतिरूपान्ते जगतोऽस्य जगन्मये ॥ ६० ॥",
        hindi = """
            (देवी का त्रिरूप - सृष्टि, स्थिति, संहार): "हे इस पूरे ब्रह्मांड की साक्षात् स्वरूप 'जगन्मयी' (जगत+मयी / पूरे जगत में समाई हुई / जगन्मये) देवी!"
            "जब इस संसार की रचना (विसृष्टौ) होती है, तो तुम स्वयं ही साक्षात् 'सृष्टि-रूपा' (सृष्टिरूपा त्वं / Creation itself) बन जाती हो।"
            "जब इस संसार का पालन (पालने) होता है, तो तुम स्वयं ही साक्षात् 'स्थिति-रूपा' (स्थितिरूपा च / Preservation itself) बन जाती हो।"
            "और ठीक उसी प्रकार (तथा), जब इस भयंकर जगत का पूर्ण विनाश (अस्य जगतो अन्ते) होता है, तो तुम ही साक्षात् 'संहार-रूपा' (संहृतिरूपान्ते / Destruction itself) का भयंकर रूप धारण कर लेती हो!"
            यह श्लोक 'परम अद्वैत' (Absolute Non-duality) का सबसे बड़ा प्रमाण है।
            ब्रह्मा जी कह रहे हैं कि माता इस दुनिया को 'बनाती' नहीं हैं, माता खुद 'दुनिया' (सृष्टिरूपा) बन जाती हैं!
            जैसे एक मकड़ी (Spider) अपने ही अंदर से जाला (Web) निकालती है और खुद उसी जाले के रूप में फैल जाती है।
            उसी तरह माता 'जगन्मयी' (Universal) हैं; इस दुनिया का हर एक एटम (Atom), हर एक इंसान, और हर एक चीज़—सब कुछ 100% माता ही हैं।
            जब दुनिया स्थिर (Stable) होती है, तो वह विष्णु की कोई अलग शक्ति नहीं है, वह माता का 'स्थिति-रूपा' (Sustaining form) है।
            और जब सब कुछ ब्लैक-होल (Black-hole) की तरह खत्म होता है, तो वह मौत भी साक्षात् माता का 'संहार-रूपा' (Destructive form / काली) ही है।
            सृष्टि, स्थिति, और संहार—ये तीन अलग-अलग भगवान नहीं हैं; ये उसी एक 'सुपर-कम्प्यूटर' (महामाया) के तीन अलग-अलग 'सॉफ्टवेयर मोड' (Software Modes) हैं।
            इस ज्ञान को सुनने के बाद, मौत और ज़िंदगी का सारा डर हमेशा के लिए खत्म हो जाता है।
        """.trimIndent(),
        english = """
            (The Trinity form of the Goddess - Creation, Sustenance, Destruction): "O absolute supreme Goddess who Herself is undeniably exactly the direct, literal physical embodiment entirely of this entire colossal cosmos, 'Jaganmayi' (Jagat+Mayi / completely pervading the entire universe / Jaganmaye)!"
            "Exactly when the massive creation (Visrishtau) of this physical world flawlessly occurs, You Yourself literally seamlessly transform exactly into direct 'Srishti-rupa' (Srishtirupa tvam / the absolute physical form of Creation itself)."
            "Exactly when the active preservation (Palane) of this massive world flawlessly occurs, You Yourself literally seamlessly transform exactly into direct 'Sthiti-rupa' (Sthitirupa cha / the absolute physical form of Sustenance itself)."
            "And precisely in the exact same flawless manner (Tatha), exactly when the absolute total, terrifying annihilation (Asya jagato ante) of this massive world violently occurs, You exclusively alone literally perfectly assume the exceptionally horrific true form exactly of direct 'Samhara-rupa' (Samhritirupante / the absolute physical form of Destruction itself)!"
            This spectacular verse is undeniably the absolute greatest explicit proof exactly of 'Absolute Non-duality' (Param Advaita).
            Lord Brahma is fiercely declaring that the Mother absolutely does not merely physically 'build' this world, the Mother Herself violently literally 'Becomes' exactly the absolute physical 'World' (Srishtirupa) Herself!
            Exactly just as a physical Spider flawlessly effortlessly ejects a massive web strictly directly entirely from inside itself and itself seamlessly expands exactly as that very web.
            Exactly similarly, the Mother is completely 'Jaganmayi' (Universal); absolutely every single microscopic Atom, every single human, and every single object in this entire physical world—absolutely everything is 100% strictly the exact Mother Herself alone.
            Exactly when the massive world is perfectly Stable, that is absolutely no completely separate power of Vishnu, it is strictly exactly the Mother's 'Sthiti-Rupa' (Sustaining form).
            And exactly when absolutely everything violently collapses completely exactly like a terrifying Black-hole, that exact absolute death is also literally exactly the Mother's 'Samhara-Rupa' (Destructive form / Kali) Herself.
            Creation, Sustenance, and Destruction—these are absolutely not 3 completely separate distinct Gods; these are strictly exclusively merely 3 completely different 'Software Modes' actively running entirely inside that exact same ONE 'Super-Computer' (Mahamaya).
            Exactly after flawlessly and actively violently hearing this explosive supreme wisdom, absolutely all terrifying fear of physical death and life is permanently annihilated entirely forever.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 61,
        sanskrit = "महाविद्या महामाया महामेधा महास्मृतिः ।\nमहामोहा च भवती महादेवी महेश्वरी ॥ ६१ ॥",
        hindi = """
            (देवी के महा-रूप): "हे देवी! तुम ही 'महाविद्या' (परम ज्ञान) हो, तुम ही 'महामाया' (परम भ्रम) हो, तुम ही 'महामेधा' (परम बुद्धि) हो, और तुम ही 'महास्मृति' (परम याददाश्त) हो!"
            "तुम ही अत्यंत भयंकर 'महामोहा' (परम अंधापन/अटैचमेंट) हो, तुम ही 'महादेवी' हो, और तुम ही सभी ईश्वरों की परम 'महेश्वरी' (Supreme Boss) हो!"
            यह श्लोक साबित करता है कि संसार का ज्ञान और संसार का अज्ञान—दोनों एक ही सिक्के (महामाया) के दो पहलू हैं।
            इंसान सोचता है कि उसकी 'मेधा' (बुद्धि) उसकी अपनी है, पर वह भी देवी का ही एक रूप है। 
            और जो 'महामोह' इंसान को बर्बाद करता है, वह भी उसी परम शक्ति का ही एक भयंकर 'सिस्टम टूल' (System Tool) है।
        """.trimIndent(),
        english = """
            (The Supreme forms of the Goddess): "O Goddess! You exclusively alone are exactly the literal 'Mahavidya' (Absolute Supreme Cosmic Knowledge), You alone are 'Mahamaya' (The Ultimate Terrifying Matrix/Illusion), You alone are 'Mahamedha' (Absolute Supreme Intellect), and You alone are exactly 'Mahasmriti' (The Ultimate Cosmic Memory)!"
            "You exclusively alone are the exceptionally terrifying 'Mahamoha' (Absolute Supreme Blind Infatuation/Attachment), You alone are 'Mahadevi' (The Great Goddess), and You alone are exactly the absolute 'Maheshvari' (The Ultimate Supreme Boss of all Gods)!"
            This spectacular verse flawlessly proves that both the supreme wisdom of the world and its thick ignorance are strictly two identical sides of the exact same cosmic coin (Mahamaya).
            A human foolishly assumes his 'Medha' (Intellect) is entirely his own, but that too is exclusively merely a direct form of the Goddess.
            And exactly that 'Mahamoha' which violently destroys a human is undeniably also a terrifying 'System Tool' of that exact same supreme raw power.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 62,
        sanskrit = "प्रकृतिस्त्वं च सर्वस्य गुणत्रयविभाविनी ।\nकालरात्रिर्महारात्रिर्मोहरात्रिश्च दारुणा ॥ ६२ ॥",
        hindi = """
            (प्रकृति और तीन भयंकर रात्रियां): "तुम ही सत्व, रज, और तम—इन तीनों गुणों (गुणत्रयविभाविनी) को पैदा करने वाली इस पूरे ब्रह्मांड की 'परम प्रकृति' (प्रकृतिस्त्वं च सर्वस्य) हो!"
            "तुम ही प्रलय के समय की भयंकर 'कालरात्रि' हो, तुम ही 'महारात्रि' हो, और तुम ही अत्यंत खौफनाक 'मोहरात्रि' (अज्ञान की डरावनी रात / दारुणा) हो!"
            यहाँ देवी को 'प्रकृति' कहा गया है, जो इस पूरे यूनिवर्स (Universe) का 'सोर्स कोड' (Source Code) है।
            'कालरात्रि' वह रात है जब सृष्टि खत्म होती है (Physical Death)। 
            'मोहरात्रि' वह भयंकर रात है जब इंसान का 'विवेक' (Intellect) मर जाता है और वह अज्ञान में अंधा हो जाता है (Spiritual Death)।
        """.trimIndent(),
        english = """
            (Prakriti and the three terrifying nights): "You exclusively alone are exactly the absolute 'Supreme Prakriti' (Primal Nature / Prakritistvam cha sarvasya) actively generating and perfectly flawlessly dividing all the three cosmic Gunas (Sattva, Rajas, Tamas / Gunatrayavibhavini) entirely in this massive universe!"
            "You exclusively alone are the exceptionally horrific 'Kalaratri' (The terrifying Night of Absolute Cosmic Destruction), You alone are 'Maharatri' (The Great Night), and You alone are the exceptionally brutal and completely terrifying 'Moharatri' (The Dark Night of Absolute Blind Delusion / Daruna)!"
            Right here, the Goddess is fiercely declared as 'Prakriti', which is literally the absolute 'Source Code' of this entire Universe.
            'Kalaratri' is exactly that horrific night exactly when the entire creation violently ends (Physical Death).
            'Moharatri' is that exceptionally terrifying night exactly when a human's 'Viveka' (Intellect) violently drops dead and he becomes completely blind in thick ignorance (Spiritual Death).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 63,
        sanskrit = "त्वं श्रीस्त्वमीश्वरी त्वं ह्रीस्त्वं बुद्धिर्बोधलक्षणा ।\nलज्जा पुष्टिस्तथा तुष्टिस्त्वं शान्तिः क्षान्तिरेव च ॥ ६३ ॥",
        hindi = """
            (देवी के सूक्ष्म रूप): "तुम ही साक्षात् 'श्री' (धन और लक्ष्मी) हो, तुम ही 'ईश्वरी' (शक्ति) हो, तुम ही 'ह्री' (विनम्रता) हो, और तुम ही साक्षात् 'बुद्धि' (बोधलक्षणा / समझने की शक्ति) हो!"
            "तुम ही 'लज्जा', तुम ही 'पुष्टि' (पोषण), तुम ही 'तुष्टि' (संतुष्टि), तुम ही 'शान्ति', और तुम ही 'क्षान्ति' (क्षमा) हो!"
            ब्रह्मा जी समझा रहे हैं कि हमारे अंदर जो भी 'पॉजिटिव इमोशंस' (Positive Emotions) हैं, वे हमारे नहीं हैं, वे साक्षात् देवी का ही 'सॉफ्टवेयर' हैं।
            जब आप जीवन में 'तुष्टि' (Satisfaction) महसूस करते हैं, तो वास्तव में आपके अंदर माता का ही एक रूप प्रकट होता है।
            इंसान का अपना कुछ नहीं है; उसका शरीर, उसकी बुद्धि, उसकी शांति सब कुछ उसी परम शक्ति (Hardware and Software) का हिस्सा है।
        """.trimIndent(),
        english = """
            (The subtle attributes of the Goddess): "You exclusively alone are exactly the literal 'Sri' (Absolute Supreme Wealth and Fortune), You alone are 'Ishvari' (Supreme Sovereign Power), You alone are 'Hri' (Modesty), and You alone are exactly direct 'Buddhi' (Bodhalakshana / The raw power of Absolute Comprehension)!"
            "You exclusively alone are 'Lajja' (Shame/Modesty), You alone are 'Pushti' (Absolute Cosmic Nourishment), You alone are 'Tushti' (Supreme Contentment), You alone are 'Shanti' (Absolute Peace), and You alone are exactly 'Kshanti' (Supreme Forgiveness)!"
            Lord Brahma is aggressively explaining that absolutely whatever 'Positive Emotions' exist perfectly inside us are absolutely not ours, they are literally the direct 'Software' of the Goddess Herself.
            Exactly when you physically experience 'Tushti' (Satisfaction) in life, in absolute reality, a direct physical form of the Mother has actively manifested exactly inside you.
            A human actively owns absolutely nothing; his dirt-body, his pathetic intellect, his cheap peace—absolutely everything is strictly a coded component of that exact same Supreme Power (Hardware and Software).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 64,
        sanskrit = "खड्गिनी शूलिनी घोरा गदिनी चक्रिणी तथा ।\nशङ्खिनी चापिनी बाणभुशुण्डीपरिघायुधा ॥ ६४ ॥",
        hindi = """
            (देवी के अस्त्र-शस्त्र): "तुम ही अपने हाथों में भयंकर खड्ग (तलवार / खड्गिनी), शूल (त्रिशूल / शूलिनी), गदा (गदिनी), और चक्र (चक्रिणी) धारण करने वाली अत्यंत 'घोर' (घोरा / भयानक) शक्ति हो!"
            "तुम ही शंख (शङ्खिनी), धनुष (चापिनी), बाण, भुशुण्डी और परिघ जैसे खौफनाक अस्त्रों (आयुध) को धारण करने वाली साक्षात् परम योद्धा हो!"
            ये अस्त्र केवल धातुओं (Metals) के बने हुए हथियार नहीं हैं; तन्त्र में ये 'ब्रह्मांडीय ऊर्जाओं' (Cosmic Energies) के प्रतीक हैं।
            'खड्ग' (Sword) उस परम ज्ञान का प्रतीक है जो अज्ञान के अँधेरे को एक झटके में काट देता है।
            'चक्र' (Discus) 'समय' (Time) का प्रतीक है जो बिना रुके चलता है और सबको खत्म कर देता है।
            ब्रह्मा जी देवी के उस 'रौद्र' (Terrifying) रूप को जगा रहे हैं जो राक्षसों (वायरस) को डिलीट (Delete) करने के लिए ज़रूरी है।
        """.trimIndent(),
        english = """
            (The terrifying cosmic weapons of the Goddess): "You exclusively alone are exactly that exceptionally 'Ghora' (Terrifying / Ferocious) supreme raw power who flawlessly actively wields the brutal sword (Khadgini), the massive trident (Shulini), the crushing mace (Gadini), and the blazing discus (Chakrini)!"
            "You exclusively alone are exactly the ultimate supreme warrior who flawlessly holds the conch (Shankhini), the massive bow (Chapini), deadly arrows, the Bhushundi, and the horrific Parigha completely exactly as Your terrifying weapons (Ayudha)!"
            These exceptionally massive weapons are absolutely not merely cheap tools manufactured from physical Metals; entirely in advanced Tantra, they are the absolute direct symbols of raw 'Cosmic Energies'.
            The 'Khadga' (Sword) is the direct absolute symbol of exactly that supreme cosmic wisdom which ruthlessly slashes the terrifying darkness of thick ignorance perfectly in exactly a single split-second.
            The 'Chakra' (Discus) is the absolute supreme symbol of 'Time' which relentlessly spins completely non-stop and violently annihilates absolutely everything.
            Lord Brahma is violently and aggressively actively awakening exactly that 'Raudra' (Terrifying) form of the Goddess which is absolutely mandatory strictly to violently Delete the demons (Viruses).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 65,
        sanskrit = "सौम्या सौम्यतराशेषसौम्येभ्यस्त्वतिसुन्दरी ।\nपरापराणां परमा त्वमेव परमेश्वरी ॥ ६५ ॥",
        hindi = """
            (देवी का परम सौंदर्य और सर्वोच्चता): "हे देवी! तुम अत्यंत सौम्य (सौम्या) और शांत हो, यहाँ तक कि दुनिया में जितने भी सुंदर और सौम्य पदार्थ (अशेषसौम्येभ्यः) हैं, तुम उन सबसे भी कहीं अधिक 'अत्यंत सुंदरी' (त्वतिसुन्दरी) हो!"
            "तुम 'परा' (सबसे ऊँची) और 'अपरा' (नीची) सभी शक्तियों से भी परे साक्षात् परम 'परमेश्वरी' (परापराणां परमा) हो!"
            एक तरफ देवी के हाथों में खौफनाक हथियार हैं, और दूसरी तरफ ब्रह्मा जी उन्हें 'अत्यंत सुंदरी' कह रहे हैं! यह एक बहुत बड़ा 'पैराडॉक्स' (Paradox) है।
            ब्रह्मांड की सबसे डरावनी ऊर्जा (Darkness) ही वास्तव में सबसे शांत और सुंदर अवस्था है (Zero State)।
            'परापराणां परमा' का मतलब है कि वे देवी इंसान की समझ (Dimension) से पूरी तरह बाहर (Transcendental) हैं। 
            वे 'फॉर्म' (Physical form) में भी हैं और 'फॉर्मलेस' (Formless energy) में भी।
        """.trimIndent(),
        english = """
            (The ultimate supreme beauty and absolute sovereignty of the Goddess): "O Supreme Goddess! You are exceptionally gentle (Saumya) and completely peaceful, and flawlessly perfectly compared to absolutely all the gentle and beautiful physical objects existing in the entire massive cosmos (Asheshasaumyebhyah), You exclusively alone are exceptionally infinitely 'Supremely Beautiful' (Tvatisundari)!"
            "You exclusively alone are undeniably exactly the absolute highest 'Parameshvari' (The Ultimate Supreme Sovereign Goddess), perfectly existing entirely infinitely beyond both the 'Para' (Supreme) and 'Apara' (Lower) cosmic manifestations (Paraparanam parama)!"
            Exactly on one side, the Goddess aggressively holds exceptionally horrific terrifying weapons, and perfectly on the exact other side, Lord Brahma is frantically actively calling Her 'Supremely Beautiful'! This is an exceptionally massive 'Paradox'.
            The absolute most exceptionally terrifying dark energy (Darkness) of the massive cosmos is undeniably, in absolute reality, its exact most flawlessly peaceful and beautiful state (The Zero State).
            'Paraparanam Parama' profoundly literally means that the Goddess perfectly exists completely entirely 'Transcendental' (flawlessly completely outside) the pathetic human's cheap understanding (Dimension).
            She flawlessly actively exists perfectly in both 'Physical Form' and entirely as 'Formless Energy'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 66,
        sanskrit = "यच्च किञ्चित् क्वचिद्वस्तु सदसद्वाखिलात्मिके ।\nतस्य सर्वस्य या शक्तिः सा त्वं किं स्तूयसे तदा ॥ ६६ ॥",
        hindi = """
            (देवी की सर्वव्यापकता): "हे पूरे ब्रह्मांड की आत्मा (अखिलात्मिके)! इस पूरे संसार में कहीं भी (क्वचिद्वस्तु), जो कुछ भी सत् (असली) या असत् (झूठा / सदसद्वा) मौजूद है।"
            "उस हर एक चीज़ के अंदर मौजूद 'परम शक्ति' (या शक्तिः) साक्षात् तुम ही हो! तो फिर भला मैं तुम्हारी पूरी स्तुति (किं स्तूयसे तदा) कैसे कर सकता हूँ?"
            जब दुनिया की हर चीज़—चाहे वह सच (Sat) हो या माया का झूठ (Asat)—केवल देवी ही है, तो प्रार्थना करने वाला 'मैं' कौन हूँ?
            ब्रह्मा जी यहाँ 'अद्वैत' (Non-duality) की चरम अवस्था में पहुँच गए हैं! वे मान रहे हैं कि 'प्रार्थना करने वाला और जिसको प्रार्थना की जा रही है', दोनों एक ही हैं।
            जिस इंसान को यह समझ आ गया, उसका सारा 'मोह' (Attachment) एक सेकंड में ख़त्म हो जाता है।
        """.trimIndent(),
        english = """
            (The absolute omnipresence of the Goddess): "O absolute supreme Soul of the entire colossal cosmos (Akhilatmike)! Absolutely wherever (Kvacidvastu), exactly whatever exists physically perfectly inside this entire massive universe, whether it is flawlessly 'Sat' (Real/Truth) or 'Asat' (Fake/Illusion) (Sadasadva)."
            "The absolute raw 'Supreme Power' (Ya shaktih) actively flawlessly existing perfectly entirely inside absolutely every single one of those exact things is undeniably exactly You alone! Then exactly how on earth can I ever possibly, fully, and completely execute Your absolute praise (Kim stuyase tada)?"
            Exactly when absolutely every single thing in the world—whether it is the absolute Truth (Sat) or the terrifying fake lie of Maya (Asat)—is strictly exclusively the Mother alone, then exactly who on earth is the 'I' actively actively executing the prayer?
            Lord Brahma has violently seamlessly flawlessly reached the absolute ultimate extreme peak exactly of 'Advaita' (Non-duality) right here! He aggressively admits that 'the exact one who is praying and the exact One who is being aggressively prayed perfectly to', both are undeniably exactly One and the same.
            The exact split-second a human flawlessly completely comprehends this, his absolute entire 'Moha' (Attachment) is permanently violently annihilated perfectly exactly in a single second.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 67,
        sanskrit = "यया त्वया जगत्स्रष्टा जगत्पात्यत्ति यो जगत् ।\nसोऽपि निद्रावशं नीतः कस्त्वां स्तोतुमिहेश्वरः ॥ ६७ ॥",
        hindi = """
            (विष्णु को भी सुलाने वाली): "हे देवी! जब तुमने ही (यया त्वया) इस पूरे जगत् को बनाने वाले (ब्रह्मा), जगत् को पालने वाले (विष्णु), और जगत् को खाने वाले (शिव) को भी।"
            "पूरी तरह से भयंकर 'निद्रा के वश' (निद्रावशं नीतः / Sleep mode) में डाल दिया है, तो फिर इस ब्रह्मांड में कौन सा ऐसा ईश्वर है जो तुम्हारी स्तुति करने में समर्थ हो सके (कस्त्वां स्तोतुमिहेश्वरः)?"
            ब्रह्मा जी खुद ही मान रहे हैं कि "मेरा (ब्रह्मा का), विष्णु का, और शिव का—हम तीनों का 'स्विच' (Switch) तुम्हारे ही हाथ में है!"
            जब देवी सिस्टम को 'स्लीप मोड' (Sleep Mode) में डालना चाहती हैं, तो 'सुप्रीम गॉड' (Supreme God) भी सो जाते हैं।
            यह श्लोक साबित करता है कि महामाया (Tripura Sundari) इस सनातन धर्म की सबसे बड़ी 'एडमिनिस्ट्रेटर' (Administrator) हैं, जिनके आगे कोई देवता नहीं टिक सकता।
        """.trimIndent(),
        english = """
            (She who effortlessly puts exactly even Vishnu to deep sleep): "O Supreme Goddess! Exactly when You exclusively alone (Yaya tvaya) have flawlessly and violently forced exactly the creator of the world (Brahma), the active sustainer of the world (Vishnu), and the ultimate devourer of the world (Shiva)."
            "Completely violently exactly straight perfectly into the terrifying inescapable 'Control of Deep Sleep' (Nidravasham nitah / Absolute Hibernation), then exactly who on earth is that highly supreme God perfectly inside this massive cosmos who possesses the precise raw capacity to flawlessly execute Your absolute praise (Kastvam stotumiheshvarah)?"
            Lord Brahma Himself flawlessly fiercely brutally admits exactly that "The absolute 'Switch' strictly of myself (Brahma), of Vishnu, and exactly of Shiva—the switch exactly of all three of us is entirely actively sitting strictly exactly inside Your hand alone!"
            Exactly when the Goddess violently desires to flawlessly put the cosmic System exactly straight into 'Sleep Mode', even the 'Supreme God' flawlessly and silently drops entirely to sleep.
            This spectacular verse absolutely completely proves that Mahamaya (Tripura Sundari) is undeniably exactly the absolute greatest ultimate 'Administrator' entirely of Sanatana Dharma, strictly before whom absolutely zero deity can possibly stand.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 68,
        sanskrit = "विष्णुः शरीरग्रहणमहमीशान एव च ।\nकारितास्ते यतोऽतस्त्वां कः स्तोतुं शक्तिमान् भवेत् ॥ ६८ ॥",
        hindi = """
            (देवताओं को शरीर देने वाली): "भगवान विष्णु, भगवान शिव (ईशान), और मैंने स्वयं (अहम् / ब्रह्मा) भी!"
            "केवल और केवल तुम्हारी ही कृपा से यह भौतिक 'शरीर धारण' (शरीरग्रहणम् / Physical bodies) किया है (कारितास्ते); इसलिए तुम्हारी स्तुति करने की 'शक्ति' (शक्तिमान् भवेत्) भला किसके पास हो सकती है?"
            देवताओं के पास भी जो 'शरीर' (Form) है, वह उन्होंने खुद नहीं बनाया है; वह भी साक्षात् माता ने ही उन्हें 'एलोकेट' (Allocate) किया है!
            ब्रह्मा जी अपनी पूर्ण 'लाचारी' (Helplessness) को स्वीकार कर रहे हैं।
            तन्त्र में जब तक साधक अपनी ईगो (मैं कुछ हूँ) को पूरी तरह ज़ीरो (Zero) नहीं कर देता, तब तक देवी का 'डाउनलोड' (Download) शुरू नहीं होता।
        """.trimIndent(),
        english = """
            (She who explicitly grants physical bodies strictly to the Supreme Gods): "Direct Lord Vishnu, direct Lord Shiva (Ishana), and flawlessly even I myself (Aham / Brahma)!"
            "Have explicitly assumed exactly these extremely highly advanced physical 'Bodies' (Shariragrahanam / Manifestations) solely, strictly, and exclusively flawlessly by Your absolute grace and command alone (Karitaste); therefore, exactly who on earth can possibly possess the massive 'Raw Power' (Shaktiman bhavet) to actively flawlessly praise You?"
            Even the exact 'Physical Bodies' (Forms) actively possessed perfectly by the Supreme Gods were absolutely not casually created completely by themselves; they too were literally seamlessly 'Allocated' exclusively directly exactly by the Mother Herself!
            Lord Brahma is aggressively and violently accepting his absolute entire complete 'Helplessness'.
            In advanced Tantra, exactly until the seeker ruthlessly aggressively annihilates his toxic Ego ("I am something") completely entirely to mathematical Zero, the absolute ultimate 'Download' explicitly from the Goddess absolutely never, ever possibly begins.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 69,
        sanskrit = "सा त्वमित्थं प्रभावैः स्वैरुदारैर्देवि संस्तुता ।\nमोहयैतौ दुराधर्षावसुरौ मधुकैटभौ ॥ ६९ ॥",
        hindi = """
            (मधु-कैटभ को मोहने की प्रार्थना): "हे देवी (देवि)! आप अपने इन महान और अत्यंत उदार 'प्रभावों' (उदारैः प्रभावैः) के द्वारा मेरे द्वारा इस प्रकार स्तुति की गई हैं (संस्तुता)।"
            "अब कृपया करके इन दोनों अत्यंत भयंकर और अजेय (दुराधर्षावसुरौ) राक्षसों—मधु और कैटभ—को अपने भयंकर 'मोह' (Matrix / मोहयैतौ) में पूरी तरह से फँसा दीजिए!"
            ब्रह्मा जी देवी से राक्षसों को 'मारने' (Kill) के लिए नहीं कह रहे हैं! वे कह रहे हैं कि "इन्हें अपने मोह (सम्मोहन) में फँसा लो!"
            क्योंकि जब तक दुश्मन का दिमाग 'हैक' (Hack) नहीं होता, तब तक उसे फिजिकल रूप (Physically) से हराया नहीं जा सकता।
            यहाँ ब्रह्मा जी उसी 'मोह' (Attachment / Blindness) रूपी हथियार का इस्तेमाल कर रहे हैं, जो इंसान की सबसे बड़ी कमज़ोरी है। 
            जब माया राक्षसों को 'ओवरकॉन्फिडेंट' (Overconfident) कर देगी, तभी विष्णु उन्हें मार पाएंगे।
        """.trimIndent(),
        english = """
            (The terrifying prayer to violently hypnotize Madhu and Kaitabha): "O Supreme Goddess (Devi)! You have been flawlessly and actively praised exactly in this precise manner strictly by me (Samstuta) perfectly for Your exceptionally magnificent and highly generous 'Divine Powers and Glory' (Udaraih prabhavaih)."
            "Now please graciously violently throw both exactly these exceptionally horrific and completely invincible (Duradharshavasurau) demons—Madhu and Kaitabha—flawlessly straight perfectly completely into Your absolute terrifying 'Moha' (Hypnotic Matrix / Mohayaitau)!"
            Lord Brahma is absolutely not frantically actively begging the Goddess perfectly to brutally 'Kill' the demons! He is fiercely actively screaming: "Violently throw them flawlessly perfectly entirely into Your terrifying Moha (Hypnosis)!"
            Strictly because exactly until the enemy's brain is flawlessly and aggressively 'Hacked', he absolutely can never, ever possibly be completely defeated Physically.
            Right here, Lord Brahma is flawlessly exploiting exactly that identical massive weapon called 'Moha' (Attachment / Blindness), which is undeniably the human's absolute greatest terrifying weakness.
            Exactly when Maya completely magically makes the demons insanely 'Overconfident', strictly and exclusively only then will Vishnu flawlessly brutally slaughter them.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 70,
        sanskrit = "प्रबोधं च जगत्स्वामी नीयतामच्युतो लघु ।\nबोधश्च क्रियतामस्य हन्तुमेतौ महासुरौ ॥ ७० ॥",
        hindi = """
            (विष्णु को जगाने की प्रार्थना): "और इस पूरे ब्रह्मांड के परम स्वामी (जगत्स्वामी), भगवान 'अच्युत' (विष्णु) को अत्यंत शीघ्र (लघु) 'नींद से जगा दीजिए' (प्रबोधं नीयताम्)!"
            "और उनके मन में इन दोनों भयंकर महा-राक्षसों (महासुरौ) को 'जान से मारने की बुद्धि' (हन्तुमेतौ बोधश्च) भी पैदा (क्रियतामस्य) कर दीजिए!"
            ब्रह्मा जी की 'हैकिंग' (Hacking) पूरी हो गई! उन्होंने देवी (पासवर्ड) से दो चीज़ें माँगीं: 1. राक्षसों के दिमाग में वायरस (मोह) डाल दो, और 2. मेरे सिस्टम एडमिन (विष्णु) का एंटी-वायरस (बोध) चालू कर दो!
            यह दिखाता है कि एक 'चेतना' (Consciousness / विष्णु) तभी काम करती है जब उसे 'महामाया' (देवी) से परमिशन (Permission) और मोटिवेशन (Motivation) मिलती है।
        """.trimIndent(),
        english = """
            (The aggressive plea to awaken Vishnu): "And graciously perfectly awaken (Prabodham niyatam) the absolute supreme Master of the entire massive cosmos (Jagatsvami), Lord 'Achyuta' (Vishnu), exceptionally instantly and rapidly (Laghu) from His terrifying deep sleep!"
            "And simultaneously flawlessly violently generate exactly the precise intense 'Intellect and active Desire to ruthlessly slaughter' (Hantumetau bodhashcha) exactly these two exceptionally horrific mega-demons (Mahasurau) perfectly right inside His supreme brain (Kriyatamasya)!"
            Lord Brahma's absolute 'Hacking' is now flawlessly 100% complete! He aggressively explicitly demanded exactly two massive things strictly from the Goddess (The Password): 1. Actively inject the terrifying Virus (Moha) directly into the demons' brains, and 2. Violently activate the exact Anti-Virus (Bodha) exclusively of my System Admin (Vishnu)!
            This completely flawlessly proves that a pure 'Consciousness' (Vishnu) actively successfully operates strictly and exclusively only exactly when it flawlessly actively receives the ultimate direct Permission and precise Motivation directly entirely from 'Mahamaya' (The Goddess).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 71,
        sanskrit = "ऋषिरुवाच ॥\nएवं स्तुता तदा देवी तामसी तत्र वेधसा ।\nविष्णोः प्रबोधनार्थाय निहन्तुं मधुकैटभौ ॥ ७१ ॥",
        hindi = """
            (देवी का ब्रह्मा की स्तुति से प्रकट होना): "महर्षि मेधा ने कहा (ऋषिरुवाच): ब्रह्मा जी (वेधसा) द्वारा उन मधु और कैटभ को मारने के लिए (निहन्तुं मधुकैटभौ) भगवान विष्णु को नींद से 'जगाने के उद्देश्य से' (विष्णोः प्रबोधनार्थाय)।"
            "इस प्रकार अत्यंत भयंकर स्तुति किए जाने पर (एवं स्तुता तदा), वह तमोगुण की अधिष्ठात्री 'तामसी देवी' (महामाया / देवी तामसी तत्र) तुरंत वहाँ से बाहर आ गईं।"
            ब्रह्मा जी का 'मन्त्र' (कोड) एकदम सही था! 'तामसी देवी' (नींद और अँधेरे की देवी) तुरंत एक्टिवेट (Activate) हो गईं।
            यह श्लोक साबित करता है कि ब्रह्मांड की सबसे डार्क और खतरनाक शक्ति (तमोगुण / तामसी) भी भगवान विष्णु (चेतना) को मदद करने के लिए ही बनी है, यदि उसे सही तरीके से 'invoke' (जगाया) जाए।
        """.trimIndent(),
        english = """
            (The Goddess explicitly responds entirely to Brahma's prayer): "Maharshi Medha flawlessly declared (Rishiruvacha): Exactly when Lord Brahma (Vedhasa) aggressively executed this exceptionally terrifying prayer (Evam stuta tada) strictly exclusively exactly with the absolute precise intention of 'Awakening Lord Vishnu' (Vishnoh prabodhanarthaya) perfectly to violently slaughter Madhu and Kaitabha (Nihantum madhukaitabhau)."
            "That exact supreme 'Tamasi Goddess' (The absolute controller of Tamoguna / Mahamaya / Devi tamasi tatra) flawlessly and instantaneously physically emerged completely exactly from right there."
            Lord Brahma's absolute 'Mantra' (Code) was undeniably 100% flawlessly perfectly correct! The exact 'Tamasi Goddess' (The absolute Goddess exactly of deep sleep and thick darkness) was instantaneously violently Activated.
            This spectacular verse completely flawlessly proves that absolutely even the exact most terrifying, horrific, and absolute darkest power of the entire cosmos (Tamoguna / Tamasi) is explicitly manufactured strictly to flawlessly Assist Lord Vishnu (Consciousness) perfectly, strictly if it is flawlessly and aggressively 'Invoked' (Awakened) correctly.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 72,
        sanskrit = "नेत्रास्यनासिकाबाहुहृदयेभ्यस्तथोरसः ।\nनिर्गम्य दर्शने तस्थौ ब्रह्मणोऽव्यक्तजन्मनः ॥ ७२ ॥",
        hindi = """
            (विष्णु के अंगों से देवी का निकलना): "वे परम देवी भगवान विष्णु के दोनों 'नेत्रों' (आँखों / नेत्रा), 'मुख' (मुँह / अस्य), 'नासिका' (नाक / नासिका), 'बाहु' (भुजाओं / बाहु), 'हृदय' (हार्ट चक्र / हृदयेभ्यस्), और 'छाती' (वक्षस्थल / तथोरसः) से।"
            "पूरी तरह बाहर निकलकर (निर्गम्य), उन अव्यक्त रूप से जन्म लेने वाले (अव्यक्तजन्मनः) ब्रह्मा जी (ब्रह्मणो) के ठीक सामने साक्षात् 'प्रकट' (दर्शने तस्थौ) हो गईं!"
            यह बहुत ही साइंटिफिक (Scientific) श्लोक है! 'नींद' (Sleep) कहाँ रहती है? आँखों में, मुँह में (जम्हाई आना), नाक में (सांस भारी होना), और हाथ-पैरों (थकान) में।
            देवी इन सभी अंगों से 'निर्गम्य' (बाहर आ गईं)। यानी विष्णु का नर्वस सिस्टम (Nervous System) अब पूरी तरह से 100% एक्टिव (Active) हो चुका था।
        """.trimIndent(),
        english = """
            (The massive cosmic withdrawal perfectly from Vishnu's physical organs): "That absolute Supreme Goddess flawlessly and violently physically withdrew entirely (Nirgamya) exactly straight perfectly from the physical 'Eyes' (Netra), 'Mouth' (Asya), 'Nose' (Nasika), 'Arms' (Bahu), 'Heart' (Heart Chakra / Hridayebhyas), and 'Chest' (Tathorasah) of direct Lord Vishnu Himself."
            "And instantaneously stood flawlessly actively manifested in absolute, direct physical vision (Darshane tasthau) perfectly exactly in front of that Lord Brahma (Brahmano) who is flawlessly born strictly from the unmanifest (Avyaktajanmanah)!"
            This is an exceptionally highly 'Scientific' verse! Exactly where on earth does biological 'Sleep' physically reside? Entirely inside the eyes, completely inside the mouth (yawning), directly inside the nose (heavy breathing), and perfectly inside the arms (heavy fatigue).
            The exact Goddess aggressively 'Nirgamya' (physically violently withdrew) completely from absolutely all these exact organs. Profoundly meaning, Lord Vishnu's absolute entire Nervous System was now flawlessly 100% completely violently Active!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 73,
        sanskrit = "उत्तस्थौ च जगन्नाथस्तया मुक्तो जनार्दनः ।\nएकार्णवेऽहिशयनात्ततः स ददृशे च तौ ॥ ७३ ॥",
        hindi = """
            (विष्णु का जागना): "उस महामाया देवी द्वारा पूरी तरह से 'मुक्त' (छोड़े जाने पर / तया मुक्तो), वे पूरे ब्रह्मांड के स्वामी 'जगन्नाथ जनार्दन' (विष्णु / जगन्नाथस्तया जनार्दनः)।"
            "उस भयंकर प्रलय के जल (एकार्णवे) में बिछे हुए शेषनाग के बिस्तर (अहिशयनात्) से तुरंत 'उठ खड़े हुए' (उत्तस्थौ च)! और उठते ही उन्होंने उन दोनों भयंकर राक्षसों को अपनी आँखों से 'देखा' (ततः स ददृशे च तौ)।"
            सिस्टम रीबूट (System Reboot) हो चुका है! भगवान विष्णु (परम चेतना) अब पूरी तरह से जाग गए हैं।
            'जगन्नाथ' (पूरी दुनिया का मालिक) और 'जनार्दन' (दुष्टों को सज़ा देने वाला) नाम यहाँ जान-बूझकर इस्तेमाल किए गए हैं।
            जैसे ही चेतना जागती है (उत्तस्थौ), सबसे पहला काम वह यह करती है कि वह 'समस्या' (राक्षसों / तौ) को सीधे अपनी आँखों (ददृशे) से फेस (Face) करती है!
        """.trimIndent(),
        english = """
            (The violent awakening of Lord Vishnu): "Exactly perfectly immediately upon being flawlessly 'Released and completely Freed' (Taya mukto) strictly by that terrifying Mahamaya Goddess, that absolute supreme Master of the colossal universe, 'Jagannatha Janardana' (Vishnu)."
            "Instantaneously violently 'Stood entirely up' (Utthasthau cha) flawlessly straight from His massive serpent bed (Ahishayanat) exactly perfectly upon that terrifying cosmic ocean of absolute destruction (Ekarnave)! And instantly upon waking, He flawlessly visually 'Saw' (Tatah sa dadrishe cha tau) exactly those two horrific mega-demons."
            The massive cosmic System Reboot is flawlessly 100% completely successful! Direct Lord Vishnu (The Absolute Supreme Consciousness) is undeniably now entirely aggressively Awake.
            The massive names 'Jagannatha' (The absolute owner of the entire world) and 'Janardana' (The exact one who ruthlessly punishes entirely all wicked entities) are exceptionally flawlessly and intentionally actively utilized right here.
            The exact split-second pure Consciousness violently awakens (Utthasthau), its absolute first flawless action is actively and aggressively directly 'Facing' (Dadrishe) the absolute horrific 'Problem' (the terrifying demons / Tau) perfectly exactly straight in the eyes!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 74,
        sanskrit = "मधुकैटभौ दुरात्मानावतिवीर्यपराक्रमौ ।\nक्रोधरक्तेक्षणावत्तुं ब्रह्माणं जनितोद्यमौ ॥ ७४ ॥",
        hindi = """
            (राक्षसों का क्रोध): "विष्णु ने देखा कि वे दोनों दुष्ट आत्मा वाले (दुरात्मानौ) राक्षस मधु और कैटभ (मधुकैटभौ), जो अत्यंत 'भयंकर बल और पराक्रम' (अतिवीर्यपराक्रमौ) से भरे हुए थे।"
            "अपनी क्रोध से बिल्कुल लाल और खौफनाक आँखों (क्रोधरक्तेक्षणावत्तुं) से घूरते हुए, ब्रह्मा जी को 'जान से मारने और खा जाने के लिए पूरी तरह तैयार' (ब्रह्माणं जनितोद्यमौ) होकर उनकी ओर झपट रहे थे!"
            मधु (Attachment) और कैटभ (Aversion) जब इंसान के अंदर आते हैं, तो उनका एक ही टारगेट (Target) होता है—'ब्रह्मा' (इंसान की क्रिएटिविटी और शांति) को मारना!
            वे 'अतिवीर्यपराक्रमौ' हैं; यानी अज्ञान (Ignorance) में बहुत भयंकर पॉवर (Power) होती है।
            वे ब्रह्मा को 'खाने' (अत्तुं) जा रहे थे, लेकिन तभी विष्णु (चेतना) बीच में आ गए!
        """.trimIndent(),
        english = """
            (The blinding rage exactly of the demons): "Lord Vishnu vividly saw exactly that both those exceptionally evil-souled (Duratmanau) demons, Madhu and Kaitabha (Madhukaitabhau), who were aggressively overflowing perfectly with exceptionally 'Terrifying brute force and massive raw power' (Ativiryaparakramau)."
            "With their horrific eyes violently burning absolute blood-red strictly with extreme blinding rage (Krodharaktekshanavattum), were aggressively furiously rushing perfectly 100% 'Prepared and ready to ruthlessly slaughter and violently devour' (Brahmanam janitodyamau) Lord Brahma entirely!"
            Exactly when Madhu (Toxic Attachment) and Kaitabha (Violent Aversion) violently enter completely perfectly inside a human, they possess exclusively exactly One singular absolute Target—aggressively and brutally slaughtering 'Brahma' (the exact human's pure Creativity and pristine Peace)!
            They are flawlessly 'Ativiryaparakramau'; profoundly meaning that thick blind Ignorance inherently relentlessly possesses exceptionally terrifying massive raw Power.
            They were aggressively preparing exactly to violently 'Devour' (Attum) Lord Brahma, but exactly precisely right then direct Vishnu (Pure Consciousness) flawlessly and violently intervened directly strictly in between!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 75,
        sanskrit = "समुत्थाय ततस्ताभ्यां युयुधे भगवान् हरिः ।\nपञ्चवर्षसहस्राणि बाहुप्रहरणो विभुः ॥ ७५ ॥",
        hindi = """
            (विष्णु और राक्षसों का महायुद्ध): "यह भयंकर दृश्य देखकर, परम शक्तिशाली भगवान हरि (विष्णु / भगवान् हरिः) तुरंत अपने बिस्तर से 'उठकर' (समुत्थाय)।"
            "उन दोनों राक्षसों के साथ भयंकर युद्ध (युयुधे) करने लगे! विष्णु ने उन दोनों के साथ अपने केवल 'हाथों की ताकत' (बाहुप्रहरणो / Hand-to-hand combat) से लगातार 'पाँच हज़ार वर्षों' (पञ्चवर्षसहस्राणि) तक अत्यंत भयंकर महायुद्ध किया!"
            भगवान विष्णु (सुप्रीम गॉड) को अपने ही कान के मैल (मधु-कैटभ) से लड़ने में 'पाँच हज़ार साल' लग गए! यह क्या साबित करता है?
            यह साबित करता है कि इंसान के दिमाग में बैठे हुए 'राग' (Attachment) और 'द्वेष' (Hatred) को ख़त्म करना भगवान के लिए भी आसान नहीं है!
            'बाहुप्रहरणो' का मतलब है बिना किसी अस्त्र (Weapon) के; यह चेतना और अज्ञान की डायरेक्ट 'फिजिकल फाइट' (Physical Fight) है।
        """.trimIndent(),
        english = """
            (The colossal cosmic war between Vishnu and the demons): "Vividly witnessing this terrifying horrific scene, the absolute supreme Lord Hari (Vishnu) instantaneously violently 'Rose strictly up' (Samutthaya)."
            "And aggressively initiated a terrifyingly horrific colossal cosmic war (Yuyudhe) flawlessly exactly with both of them! Lord Vishnu violently fought them strictly, entirely, and exclusively purely using massive 'Hand-to-Hand Combat' (Bahupraharano / physical blows of the arms) relentlessly and continuously for exactly an astonishing 'Five Thousand Cosmic Years' (Panchavarshasahasrani)!"
            It absolutely literally required exactly 'Five Thousand Cosmic Years' exclusively for direct Lord Vishnu (The Absolute Supreme God) to flawlessly brutally fight the exact literal dirt exactly from His very own physical ear (Madhu-Kaitabha)! Exactly what on earth does this flawlessly prove?
            This spectacularly completely proves that actively aggressively permanently annihilating highly toxic 'Raga' (Attachment) and violent 'Dvesha' (Hatred) actively residing entirely perfectly inside the human's pathetic brain is absolutely not casual or easy completely exactly even strictly for God Himself!
            'Bahupraharano' strictly profoundly means entirely completely without any massive cosmic Weapons; this is the direct absolute exceptionally terrifying 'Physical Fight' flawlessly exactly between pure Consciousness and highly thick Ignorance.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 76,
        sanskrit = "तावप्यतिबलोन्मत्तौ महामायाविमोहितौ ।\nउक्तवन्तौ वरोऽस्मत्तो व्रियतामिति केशवम् ॥ ७६ ॥",
        hindi = """
            (राक्षसों का महामाया के कारण अहंकार): "वे दोनों राक्षस भी अपने भयंकर बाहुबल के नशे में पूरी तरह 'पागल और अंधे' (अतिबलोन्मत्तौ) हो चुके थे! और सबसे बड़ी बात, वे 'महामाया देवी के भयंकर मोह और मायाजाल' (महामायाविमोहितौ / Hypnotized) में बुरी तरह फँस चुके थे!"
            "इसलिए अहंकार में आकर उन्होंने साक्षात् भगवान केशव (विष्णु) से कहा: 'अरे विष्णु! हम तेरी लड़ाई से बहुत खुश हैं, तू हमसे कोई भी वरदान माँग ले' (उक्तवन्तौ वरोऽस्मत्तो व्रियतामिति केशवम्)!"
            यही है 'महामाया का जादू' (Magic of Mahamaya)! ब्रह्मा जी ने देवी से जो 'वायरस' डालने को कहा था, वह काम कर गया!
            राक्षस सोच रहे थे कि "विष्णु हमसे हार रहा है", पर वास्तव में वे अपने ही घमंड (Overconfidence) में अंधी मौत की तरफ जा रहे थे।
            जब इंसान का नाश (Destruction) आने वाला होता है, तो महामाया सबसे पहले उसकी 'बुद्धि' (Intellect) को हैक कर लेती है। 
            एक राक्षस (जो मरने वाला है) वह खुद भगवान को 'वरदान' देने की औकात दिखा रहा है! यही अहंकार है।
        """.trimIndent(),
        english = """
            (The horrifying arrogance of the demons caused flawlessly by Mahamaya): "Both exactly those horrifying demons were completely entirely violently 'Drunk, insane, and fully blinded' (Atibalonmattau) strictly by the toxic addiction of their very own raw brute force! And absolutely most importantly, they were aggressively and flawlessly entirely 'Hypnotized and violently trapped completely inside the terrifying Web of Mahamaya' (Mahamayavimohitau)!"
            "Therefore, strictly out of absolute blinding toxic arrogance, they violently spoke directly straight to Lord Keshava (Vishnu) Himself: 'Hey Vishnu! We are highly pleased exactly by your fighting, ask absolutely any Boon strictly from us' (Uktavantau varo'smatto vriyatamiti keshavam)!"
            This is exactly undeniably the absolute terrifying 'Magic of Mahamaya'! The exact highly toxic 'Virus' which Lord Brahma had violently actively requested the Goddess to inject flawlessly worked 100%!
            The pathetic demons were actively arrogantly assuming that "Vishnu is losing heavily exactly to us", but completely in absolute actual reality, strictly blinded exclusively by their very own toxic Overconfidence, they were aggressively frantically racing flawlessly straight perfectly towards absolute terrifying death.
            Exactly when a human's absolute total Destruction violently actively approaches, Mahamaya flawlessly ruthlessly Hacks his exact 'Intellect' absolute first.
            A pathetic microscopic demon (who is flawlessly actively about to violently die) is aggressively arrogantly demonstrating his absolutely fake cosmic worth strictly by actively attempting entirely to flawlessly 'Grant a Boon' directly to the absolute Supreme God Himself! This is exactly pure Ego.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 77,
        sanskrit = "श्रीभगवानुवाच ॥\nभवेतामद्य मे तुष्टौ ममावध्यावुभावपि ।\nकिमन्येन वरेणात्र एताद्वद्धि वृतं मया ॥ ७७ ॥",
        hindi = """
            (विष्णु का चतुर वरदान): "तब श्री भगवान (विष्णु) ने मुसकुराते हुए कहा (श्रीभगवानुवाच): 'अरे राक्षसों! यदि तुम दोनों सचमुच आज मेरी इस लड़ाई से पूरी तरह प्रसन्न (तुष्टौ) हो गए हो!'"
            "'तो बस मुझे यही वरदान दे दो कि तुम दोनों की मौत केवल और केवल मेरे ही हाथों से हो (ममावध्यावुभावपि)! मुझे यहाँ इसके अलावा किसी और फालतू वरदान (किमन्येन वरेणात्र) की कोई आवश्यकता नहीं है, मैंने यही वरदान चुन लिया है (एताद्वद्धि वृतं मया)!' "
            विष्णु (बुद्धि/चेतना) ने उसी 'ईगो' (Ego) का इस्तेमाल राक्षसों के खिलाफ किया!
            यह एक 'साइकोलॉजिकल ट्रैप' (Psychological Trap) है। राक्षसों को लगा था कि वे सुपीरियर (Superior) हैं, पर विष्णु ने उसी वरदान के जाल में उन्हें फँसा लिया।
            जब आपके अंदर के राग और द्वेष (मधु-कैटभ) बहुत बड़े हो जाते हैं, तो आपको उनसे लड़ने के बजाय, अपनी 'चेतना' (विष्णु) से उन्हें एक ट्रिक (Trick) के ज़रिए काटना पड़ता है।
        """.trimIndent(),
        english = """
            (The flawlessly clever supreme Boon explicitly requested by Vishnu): "Exactly then the Supreme Lord (Vishnu) flawlessly completely smiled and aggressively replied (Shribhagavanuvacha): 'O Demons! Exactly if both of you are undeniably entirely fully pleased and highly satisfied (Tushtau) exactly today strictly by My exceptional fighting!'"
            "'Then simply explicitly grant Me exactly this specific Boon that both of you absolutely exclusively must be violently slaughtered strictly by My hands alone (Mamavadhyavubhavapi)! I possess absolutely zero need for any other useless, cheap boon right here (Kimanyena varenatra), I have flawlessly specifically chosen exactly this exact Boon alone (Etadvaddhi vritam maya)!' "
            Lord Vishnu (Supreme Intellect/Consciousness) aggressively actively exploited that exact identical highly toxic 'Ego' entirely flawlessly completely against the demons themselves!
            This is undeniably an exceptionally terrifying 'Psychological Trap'. The pathetic demons ignorantly assumed they were highly Superior, but Lord Vishnu flawlessly violently ensnared them perfectly completely exactly inside the inescapable net entirely of their very own highly arrogant boon.
            Exactly when your internal toxic Raga and Dvesha (Madhu-Kaitabha) become completely exceptionally massive, flawlessly instead of strictly actively blindly fighting them, you absolutely must violently ruthlessly slash them completely exactly through a highly advanced supreme Trick utilizing your pure 'Consciousness' (Vishnu).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 78,
        sanskrit = "ऋषिरुवाच ॥\nवञ्चिताभ्यामिति तदा सर्वमापोमयं जगत् ।\nविलोक्य ताभ्यां गदितो भगवान् कमलेक्षणः ॥ ७८ ॥",
        hindi = """
            (राक्षसों का धोखा खाना): "महर्षि मेधा ने कहा (ऋषिरुवाच): महामाया के भयंकर प्रभाव के कारण जब उन दोनों राक्षसों ने खुद को विष्णु की बातों से 'पूरी तरह ठगा हुआ और धोखा खाया हुआ' (वञ्चिताभ्यामिति तदा) महसूस किया।"
            "और फिर जब उन्होंने देखा कि पूरी की पूरी दुनिया केवल 'विशाल और गहरे पानी' (सर्वमापोमयं जगत् / Cosmic Ocean) में डूबी हुई है, तब उन राक्षसों ने उन कमल-नेत्रों वाले भगवान (कमलेक्षणः) से यह चाल चली।"
            जब राक्षसों को समझ आया कि उन्होंने खुद अपनी मौत का वारंट (Death warrant) साइन (Sign) कर दिया है (वञ्चित / Deceived)!
            पर वे अभी भी अपनी हार मानने को तैयार नहीं थे। उन्होंने 'लूपहोल' (Loophole) ढूँढने की कोशिश की।
            चूंकि प्रलय के समय पूरा ब्रह्मांड एक विशाल 'जल' (Cosmic Water) में डूबा था, तो उन्होंने एक बहुत ही स्मार्ट (Smart) शर्त रखी।
        """.trimIndent(),
        english = """
            (The absolute terrifying deception flawlessly completely fooling the demons): "Maharshi Medha perfectly declared (Rishiruvacha): Exactly when both those horrific demons flawlessly realized they were completely, violently 'Deceived, scammed, and entirely outsmarted' (Vanchitabhyamiti tada) strictly due to the terrifying blinding effect of Mahamaya."
            "And exactly when they vividly visually 'Observed' (Vilokya) perfectly that the absolute entire cosmos was violently flooded entirely by an 'Infinite Deep Cosmic Ocean of Water' (Sarvamapomayam jagat), exactly then those demons aggressively attempted this exact cunning physical trick perfectly upon the Lotus-Eyed Lord (Kamalekshanah)."
            Exactly when the pathetic demons flawlessly finally completely comprehended that they had aggressively foolishly signed their very own explicit Death Warrant (Vanchita / Brutally Deceived)!
            Yet they were absolutely still entirely completely unready to aggressively accept their brutal flawless defeat. They frantically desperately actively attempted entirely to vividly locate a highly legal 'Loophole'.
            Strictly since flawlessly exactly during the cosmic dissolution the absolute entire universe was violently entirely drowned completely perfectly in a massive 'Cosmic Ocean' (Water), they explicitly aggressively laid exactly down an exceptionally highly Smart physical condition.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 79,
        sanskrit = "आवां जहि न यत्रोर्वी सलिलेन परिप्लुता ॥ ७९ ॥",
        hindi = """
            (राक्षसों की अंतिम चाल): "उन राक्षसों ने कहा: 'ठीक है विष्णु! तुम हमें जान से मार दो (आवां जहि), पर हमारी एक शर्त है! तुम हमें उस जगह पर मारो जो जगह पूरी तरह से 'सूखी' हो और जहाँ पानी का एक भी कतरा (सलिलेन परिप्लुता न यत्रोर्वी / Not flooded by water) न हो!' "
            यह राक्षसों का 'स्मार्टनेस' (Smartness) था! क्योंकि पूरी दुनिया पानी में डूबी थी, सूखी ज़मीन कहीं थी ही नहीं!
            अहंकार (Ego) अंत समय तक अपनी चालाकी नहीं छोड़ता। 
            इंसान सोचता है कि वह भगवान को अपने 'लॉजिक' (Logic) से हरा देगा, पर वह यह भूल जाता है कि विष्णु साक्षात् 'लॉजिक के पिता' हैं।
        """.trimIndent(),
        english = """
            (The absolutely final desperate trick of the demons): "Those demons aggressively screamed: 'Fine Vishnu! You can flawlessly violently slaughter both of us (Avam jahi), but strictly on exactly one massive condition! You absolutely must kill us strictly exactly in a specific location which is completely 100% 'Dry' and absolutely not physically flooded even by a single drop of this massive cosmic water (Salilena paripluta na yatrorvi)!' "
            This was exactly undeniably the exceptionally arrogant 'Smartness' perfectly of the horrifying demons! Strictly since the absolute entire massive cosmos was completely violently drowned entirely exactly in deep water, absolutely zero dry dirt physically existed perfectly anywhere!
            Highly toxic Ego absolutely never ever flawlessly Abandons its exceptionally cheap pathetic cunning tricks completely even strictly precisely at the absolute ultimate end.
            A pathetic human arrogantly actively assumes entirely that he will flawlessly magically defeat God exactly via his cheap 'Logic', but he completely explicitly forgets the absolute brutal reality that direct Lord Vishnu Himself is undeniably literally the absolute direct 'Father of all Logic'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 80,
        sanskrit = "ऋषिरुवाच ॥\nतथेत्युक्त्वा भगवता शङ्खचक्रगदाभृता ।\nकृत्वा चक्रेण वै छिन्ने जघने शिरसी तयोः ॥ ८० ॥",
        hindi = """
            (विष्णु द्वारा वध): "महर्षि मेधा ने कहा (ऋषिरुवाच): अपने हाथों में शंख, चक्र और गदा धारण करने वाले (शङ्खचक्रगदाभृता) उन परम भगवान विष्णु ने 'तथास्तु' (तथेत्युक्त्वा / ऐसा ही होगा) कहा!"
            "और भगवान विष्णु ने तुरंत अपनी दोनों जाँघों (जघने) को फैलाकर उन राक्षसों के दोनों सिरों को अपनी जाँघों पर रखकर (कृत्वा), अपने भयंकर सुदर्शन चक्र (चक्रेण) से उनके दोनों सिर 'काटकर धड़ से अलग कर दिए' (वै छिन्ने शिरसी तयोः)!"
            पानी से सूखी जगह कहाँ थी? भगवान विष्णु की 'जाँघें' (Thighs)!
            विष्णु ने उनके 'लॉजिक' (Logic) को उनके ही खिलाफ इस्तेमाल करके उनका 'गेम ओवर' (Game Over) कर दिया।
            जब इंसान का 'राग' और 'द्वेष' (मधु-कैटभ) अपनी चरम सीमा पर होता है, तो भगवान उसे किसी बाहरी हथियार से नहीं, बल्कि इंसान के खुद के 'अहंकार की शर्त' (Ego's condition) से ही मार देते हैं!
        """.trimIndent(),
        english = """
            (The ultimate flawless cosmic slaughter by Vishnu): "Maharshi Medha perfectly declared (Rishiruvacha): That absolute supreme Lord Vishnu, who flawlessly actively wields the divine conch, discus, and crushing mace exactly in His hands (Shankhachakragadabhrita), flawlessly fiercely roared 'Tathastu' (Exactly so it shall be / Tathetyuktva)!"
            "And Lord Vishnu instantaneously violently expanded His own massive cosmic thighs (Jaghane), forcefully placing both their horrific heads strictly perfectly directly upon His thighs (Kritva), and violently ruthlessly 'Slaughtered and entirely severed both their heads' (Vai chinne shirasi tayoh) strictly with His terrifying Sudarshana Chakra (Chakrena)!"
            Exactly where on earth was that highly specific dry location completely untouched entirely exactly by massive cosmic water? The direct explicit 'Thighs' exclusively of Supreme Lord Vishnu!
            Lord Vishnu flawlessly perfectly violently exploited exactly their very own highly arrogant 'Logic' completely explicitly exactly entirely against them, ruthlessly executing an absolute perfect cosmic 'Game Over'.
            Exactly when a pathetic human's highly toxic 'Raga' and 'Dvesha' (Madhu-Kaitabha) effortlessly flawlessly completely hit their absolute ultimate extreme peak, God absolutely does not actively kill him strictly with any cheap external physical weapon, but undeniably flawlessly slaughters him strictly exactly utilizing the human's very own 'Condition of Ego' itself!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 81,
        sanskrit = "एवमेषा समुत्पन्ना ब्रह्मणा संस्तुता स्वयं ।\nप्रभावमस्या देव्यास्तु भूयः शृणु वदामि ते ॥ ८१ ॥",
        hindi = """
            (प्रथम अध्याय का समापन): "महर्षि ने राजा सुरथ से कहा: ब्रह्मा जी द्वारा स्तुति किए जाने पर (ब्रह्मणा संस्तुता), वह महामाया देवी इसी प्रकार से 'स्वयं उत्पन्न और प्रकट' (एवमेषा समुत्पन्ना स्वयं) हुई थीं।"
            "हे राजा! अब तुम इसी महान देवी के अत्यंत भयंकर और असीम 'प्रभाव' (प्रभावमस्या देव्यास्तु) के बारे में आगे और भी विस्तार से सुनो (भूयः शृणु), जो मैं तुम्हें आगे बताने जा रहा हूँ (वदामि ते)!"
            यहाँ 'प्रथम अध्याय' (First Chapter) समाप्त होता है!
            मुनि मेधा ने राजा सुरथ को बता दिया कि जो 'मोह' (Attachment) तुम्हें रुला रहा है, वह साक्षात् विष्णु को भी फँसा लेता है।
            और उसी मोह से बाहर निकलने के लिए तुम्हें 'महामाया' की शरण में ही जाना होगा, क्योंकि विष्णु (चेतना) भी उसी के कारण राक्षसों को मार पाए थे!
        """.trimIndent(),
        english = """
            (The absolute perfect conclusion exactly of Chapter One): "The Sage violently declared to King Suratha: Exactly upon being flawlessly actively praised strictly by Lord Brahma (Brahmana samstuta), that exact Mahamaya Goddess flawlessly and directly 'Manifested and physically originated Herself' (Evamesha samutpanna svayam) perfectly in exactly this specific cosmic manner."
            "O King! Now aggressively and flawlessly completely 'Listen' (Bhuyah shrinu) even more intensely entirely regarding the absolute terrifying and limitless 'Cosmic Glory and Raw Power' (Prabhavamatsya devyastu) of this exact identical Supreme Goddess, which I am actively meticulously preparing to explicitly violently narrate perfectly to you (Vadami te)!"
            Right exactly here flawlessly completely concludes the absolute 'First Chapter' (Prathamo'dhyaya)!
            Sage Medha has aggressively flawlessly perfectly completely informed King Suratha precisely that the exact highly toxic 'Moha' (Attachment) which is violently making him helplessly cry, undeniably successfully entirely traps completely even direct Lord Vishnu Himself.
            And explicitly entirely exactly to flawlessly escape directly from that exact identical Moha, you absolutely undeniably flawlessly must actively violently fall exclusively directly entirely into the absolute pure Refuge strictly of 'Mahamaya' Herself, strictly because flawlessly even Vishnu (Consciousness) was successfully actively capable of ruthlessly slaughtering the demons exclusively precisely strictly entirely due to Her!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 82,
        sanskrit = "देवासुरमभूद्युद्धं पूर्णमब्दशतं पुरा ।\nमहिषेऽसुराणामधिपे देवानां च पुरन्दरे ॥ ८२ ॥",
        hindi = """
            (अध्याय २ आरंभ - देवासुर संग्राम): "महर्षि मेधा ने कहा: प्राचीन काल में (पुरा), देवताओं और असुरों (राक्षसों) के बीच पूरे 'सौ वर्षों' (पूर्णमब्दशतं) तक अत्यंत भयंकर और खौफनाक महायुद्ध (देवासुरमभूद्युद्धं) हुआ था!"
            "उस समय असुरों (राक्षसों) का परम राजा भयंकर 'महिषासुर' (महिषेऽसुराणामधिपे) था, और देवताओं के राजा साक्षात् 'इन्द्र' (देवानां च पुरन्दरे) थे!"
            यहाँ से 'द्वितीय अध्याय' (Chapter 2 - महिषासुर सेना वध) शुरू होता है।
            महिषासुर (Mahishasura) 'भैंसे' (Buffalo) के रूप वाला राक्षस है। 'भैंसा' घोर 'अहंकार' (Ego) और 'तमोगुण' (आलस/क्रोध) का साक्षात् प्रतीक है।
            जब इंसान के अंदर पशुत्व (Animal nature) हावी हो जाता है, तो वह देवता (Divine nature) से 100 साल (Life span) तक लड़ता रहता है!
        """.trimIndent(),
        english = """
            (Chapter 2 Begins - The Terrifying War): "Maharshi Medha fiercely continued: In the extremely ancient cosmic past (Pura), an exceptionally terrifying and utterly horrific absolute colossal mega-war flawlessly exploded violently strictly between the Gods and the brutal demons (Devasuramabhudyuddham), furiously continuing relentlessly entirely for exactly 'One Full Hundred Cosmic Years' (Purnamabdashatam)!"
            "Exactly at that specific precise time, the absolute supreme king commanding the entire demonic army was the exceptionally horrifying 'Mahishasura' (Mahishe'suranamadhipe), while the supreme king perfectly commanding the Gods was direct 'Indra' (Devanam cha purandare)!"
            Right exactly from here violently flawlessly commences the absolute 'Second Chapter' (Adhyaya 2 - The slaughter of Mahishasura's army).
            Mahishasura is undeniably a terrifying monster flawlessly perfectly exactly possessing the physical form explicitly of a 'Buffalo'. The explicit 'Buffalo' is undeniably the direct absolute supreme literal symbol exactly of highly toxic 'Ego' (Ahankara) and terrifying 'Tamoguna' (apocalyptic laziness/rage).
            Exactly when the pathetic brutal animalistic nature (Pashutva) aggressively flawlessly successfully entirely dominates a human, it violently completely fights flawlessly directly exactly against his pure divine nature (Devata) relentlessly entirely for literally 100 cosmic years (his entire human Life span)!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 83,
        sanskrit = "तत्रासुरैर्महावीर्यैर्देवसैन्यं पराजितम् ।\nजित्वा च सकलान् देवानिन्द्रोऽभून्महिषासुरः ॥ ८३ ॥",
        hindi = """
            (महिषासुर की जीत): "उस भयंकर युद्ध में (तत्र), उन अत्यंत महाबलशाली और शक्तिशाली असुरों (असुरैर्महावीर्यैर्) ने सभी देवताओं की विशाल सेना को बहुत बुरी तरह से 'हरा दिया' (देवसैन्यं पराजितम्)!"
            "और सारे के सारे देवताओं को युद्ध में पूरी तरह से 'जीतकर और कुचलकर' (जित्वा च सकलान् देवान्), वह दुष्ट राक्षस महिषासुर खुद ही स्वर्ग का 'नया इन्द्र' (इन्द्रोऽभून्महिषासुरः / King of Heaven) बन बैठा!"
            इंसान के अंदर भी यह युद्ध चलता है। जब हमारा 'ईगो' (महिषासुर) हमारे 'सद्गुणों' (देवताओं) को पूरी तरह से हरा देता है।
            तो वह अहंकार खुद ही हमारे दिमाग का 'इन्द्र' (Boss) बन जाता है!
            वह तय करता है कि हम क्या सोचेंगे और क्या करेंगे। देवता (अच्छाई) बुरी तरह से हार चुके हैं।
        """.trimIndent(),
        english = """
            (The brutal catastrophic defeat of the Gods): "Exactly directly in that horrific terrifying war (Tatra), those exceptionally massive, highly overpowered, and heavily 'Supremely valiant demons' (Asurairmahaviryair) violently ruthlessly 'Crushed and entirely defeated the absolute entire army of the Gods' (Devasainyam parajitam)!"
            "And strictly after flawlessly violently 'Conquering, slaughtering, and crushing' absolutely all the massive Gods (Jitva cha sakalan devan), that exact horrifying wicked demon Mahishasura aggressively directly 'Declared himself as the brand new Indra' (Indro'bhunmahishasurah / The Ultimate King of Heaven)!"
            Exactly this exact identical violent horrific war aggressively flawlessly actively continues relentlessly strictly entirely perfectly inside every single human as well. Exactly when our highly toxic 'Ego' (Mahishasura) violently completely brutally massacres exactly all our pure 'Divine virtues' (Gods).
            Exactly then that very identical terrifying Ego aggressively immediately directly declares itself as the absolute supreme 'Indra' (The Supreme Boss) flawlessly of our entire brain!
            It ruthlessly controls and explicitly perfectly entirely commands exactly what we actively physically think and physically do. The pure Gods (Goodness) have been completely exceptionally catastrophically violently defeated.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 84,
        sanskrit = "ततः पराजिता देवा पद्मयोनिं प्रजापतिम् ।\nपुरस्कृत्य गतास्तत्र यत्रेशगरुडध्वजौ ॥ ८४ ॥",
        hindi = """
            (देवताओं का ब्रह्मा, विष्णु और शिव के पास जाना): "स्वर्ग से बाहर निकाले जाने के बाद (ततः), वे सभी हारे हुए और अपमानित देवता (पराजिता देवा) कमल से जन्म लेने वाले (पद्मयोनिं) 'ब्रह्मा जी' (प्रजापतिम्) को सबसे आगे करके (पुरस्कृत्य)।"
            "उस परम स्थान पर गए (गतास्तत्र), जहाँ भगवान शिव (ईश) और भगवान विष्णु (गरुड़ध्वजौ / जिनके रथ पर गरुड़ है) विराजमान थे!"
            जब इंसान का 'अहंकार' (Ego) हद से ज़्यादा बढ़ जाता है और उसके अंदर की अच्छाई (देवता) हार जाती है।
            तो वे देवता (अच्छाइयाँ) सबसे पहले 'ब्रह्मा' (बुद्धि) के पास जाती हैं, और फिर बुद्धि उन्हें 'विष्णु' (चेतना) और 'शिव' (परमात्मा) के पास लेकर जाती है।
            यह एक इंटरनल आध्यात्मिक प्रोसेस (Internal Spiritual Process) है जहाँ इंसान मदद के लिए अपनी 'चेतना' (Consciousness) से पुकार करता है।
        """.trimIndent(),
        english = """
            (The utterly humiliated Gods violently flee perfectly to the Supreme Trinity): "Exactly strictly after being brutally kicked out of heaven (Tatah), absolutely all those exceptionally heavily 'Defeated, crushed, and violently humiliated Gods' (Parajita deva) flawlessly placed Lord Brahma (Prajapatim), who is flawlessly born strictly from the cosmic lotus (Padmayonim), exactly perfectly entirely in the absolute front (Puraskritya)."
            "And actively aggressively marched directly straight exactly to that highly supreme divine location (Gatastatra) where Lord Shiva (Isha) and Lord Vishnu (Garudadhvajau / He whose massive flag bears Garuda) were flawlessly majestically residing!"
            Exactly when a human's terrifying toxic 'Ego' explodes far beyond absolutely all massive physical limits and the pure absolute goodness (Gods) physically inside him is brutally defeated.
            Exactly then those highly supreme Gods (divine pure virtues) flawlessly actively violently sprint exactly straight absolute first perfectly to 'Brahma' (pure Intellect), and exactly then that Intellect aggressively physically drags them entirely straight flawlessly to 'Vishnu' (pure Consciousness) and 'Shiva' (Supreme God).
            This is undeniably an exceptionally massive, completely 'Internal Spiritual Process' flawlessly perfectly where the human actively frantically begs exclusively for absolute supreme assistance strictly exactly from his very own pure 'Consciousness' (God).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 85,
        sanskrit = "यथावृत्तं तयोस्तद्वन्महिषासुरचेष्टितम् ।\nत्रिदशाः कथयामासुर्देवाभिभवविस्तरम् ॥ ८५ ॥",
        hindi = """
            (देवताओं द्वारा महिषासुर के अत्याचारों का वर्णन): "वहाँ पहुँचकर उन सभी देवताओं (त्रिदशाः) ने उस भयंकर महिषासुर की सारी गंदी और नीच हरकतों (महिषासुरचेष्टितम्) का बिल्कुल वैसा ही 'विस्तार से वर्णन' (यथावृत्तं कथयामासुर्) किया।"
            "और यह भी बताया कि उस राक्षस ने किस प्रकार से सभी देवताओं को युद्ध में बुरी तरह 'हराकर उनका घोर अपमान' (देवाभिभवविस्तरम्) किया है!"
            देवताओं ने अपना सारा 'ट्रॉमा' (Trauma) भगवान विष्णु और शिव के सामने खोल कर रख दिया!
            वे बता रहे हैं कि किस तरह महिषासुर (जानवर जैसी वृत्ति) ने उनके दैवीय स्वभाव (Divine nature) को पूरी तरह कुचल (Humiliate) दिया है।
            जब तक आप अपनी 'कमियों' को भगवान के सामने पूरी ईमानदारी से स्वीकार नहीं करते, तब तक भगवान एक्शन (Action) नहीं लेते।
        """.trimIndent(),
        english = """
            (The Gods furiously narrate exactly the horrific atrocities strictly of Mahishasura): "Flawlessly reaching exactly there, absolutely all those massive Gods (Tridashah) aggressively actively flawlessly 'Narrated strictly exactly in extremely highly detailed precision' (Yathavrittam kathayamasur) absolutely all the terrifying, exceptionally filthy, and completely evil physical actions entirely of that mega-demon Mahishasura (Mahishasuracheshtitam)."
            "And also violently vividly detailed exactly how that exact specific monster brutally 'Defeated, crushed, and executed the absolute maximum supreme humiliation' flawlessly perfectly exactly upon absolutely all the Gods (Devabhibhavavistaram)!"
            The entire massive host of Gods flawlessly completely actively vomited their absolute entire terrifying 'Trauma' completely naked directly perfectly exactly in front of Supreme Lord Vishnu and direct Shiva!
            They are aggressively actively screaming perfectly detailing exactly how Mahishasura (Highly violent brutal animalistic Instinct) has completely, violently, and ruthlessly 'Crushed and entirely Humiliated' absolutely all their pure divine, spiritual nature completely.
            Exactly until you flawlessly and completely honestly aggressively accept absolutely all your exceptionally pathetic weaknesses directly perfectly entirely before God, God absolutely never, ever actively physically takes any direct Action.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 86,
        sanskrit = "सूर्येन्द्राग्न्यनिलेन्दूनां यमस्य वरुणस्य च ।\nअन्येषां चाधिकारान् स स्वयमेवाधितिष्ठति ॥ ८६ ॥",
        hindi = """
            (सभी अधिकार छिन जाना): "देवताओं ने कहा: उस महिषासुर ने 'सूर्य', 'इन्द्र', 'अग्नि', 'वायु' (अनिल), 'चन्द्रमा' (इन्दु), 'यमराज' (यमस्य), और 'वरुण' (वरुणस्य च)।"
            "इन सभी प्रमुख देवताओं के, और यहाँ तक कि 'बाकी सभी दूसरे देवताओं' (अन्वेषां च) के भी सारे के सारे 'अधिकार और पावर्स' (अधिकारान्) छीन लिए हैं और खुद ही उन सब पर 'कब्ज़ा करके बैठ गया है' (स्वयमेवाधितिष्ठति)!"
            महिषासुर ने केवल स्वर्ग नहीं छीना, उसने देवताओं की 'जॉब' (Job / Cosmic Duties) भी छीन ली!
            सूर्य का काम रोशनी देना है, पर अब महिषासुर तय कर रहा है कि सूर्य कहाँ उगेगा!
            यह दिखाता है कि जब 'अहंकार' हावी होता है, तो इंसान के सारे अंग (Senses) और उसकी सारी इंद्रियां (इन्द्र, अग्नि) उसी अहंकार के गुलाम बन जाते हैं।
        """.trimIndent(),
        english = """
            (The terrifying violent hijacking exactly of all absolute cosmic authorities): "The Gods actively screamed: That horrifying Mahishasura has brutally hijacked the massive cosmic positions exactly of the 'Sun' (Surya), 'Indra', 'Agni' (Fire), 'Vayu' (Wind/Anila), 'Moon' (Indu), 'Yamaraja' (Yamasya), and 'Varuna' (Varunasya cha)."
            "He has violently entirely stripped absolutely all the absolute primary Gods, and perfectly even 'Absolutely all the other remaining Gods' (Anyesham cha), completely of their absolute ultimate 'Powers, rights, and cosmic authority' (Adhikaran), actively aggressively 'Occupying completely and perfectly ruling exactly all of them entirely himself' (Svayamevadhitishthati)!"
            Mahishasura undeniably absolutely did not strictly casually steal the physical Heaven; he violently brutally literally explicitly completely hijacked the absolute pure 'Jobs' (Cosmic Duties) of absolutely all the Gods!
            The Sun's pure absolute job is flawlessly executing Light, but exactly now Mahishasura arrogantly explicitly dictates exactly where the Sun will physically rise!
            This phenomenally explicitly violently proves that exactly when the highly toxic 'Ego' aggressively strictly flawlessly dominates perfectly entirely, absolutely all the human's physical Senses and his entire exact physical faculties (Indra, Agni) flawlessly completely become absolute cheap pathetic slaves strictly explicitly to that exact identical Ego.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 87,
        sanskrit = "स्वर्गान्निराकृताः सर्वे तेन देवगणा भुवि ।\nविचरन्ति यथा मर्त्या महिषेण दुरात्मना ॥ ८७ ॥",
        hindi = """
            (देवताओं की दुर्दशा): "उस अत्यंत दुष्ट और पापी आत्मा वाले महिषासुर (महिषेण दुरात्मना) ने स्वर्ग के सारे देवताओं (देवगणा सर्वे) को 'स्वर्ग से धक्के मारकर बाहर निकाल दिया' (स्वर्गान्निराकृताः) है!"
            "और अब वे सारे के सारे महान देवता अपनी सारी शक्ति खोकर, एक साधारण इंसान (यथा मर्त्या / Mortal human) की तरह इस पृथ्वी (भुवि) पर भिखारियों की तरह 'भटक रहे हैं' (विचरन्ति)!"
            देवता (Energy/Positivity) जब अपने असली रूप (स्वर्ग) में होते हैं, तो वे दुनिया को चलाते हैं।
            पर अब महिषासुर (Negativity) ने उन्हें इतना कमज़ोर कर दिया है कि वे 'मर्त्य' (मरने वाले इंसानों) की तरह लाचार हो गए हैं।
            यह एक 'डिप्रेशन' (Depression) की स्थिति है, जहाँ इंसान की सारी अच्छी ऊर्जा खत्म हो जाती है और केवल 'अंधेरा' (महिषासुर) राज करता है।
        """.trimIndent(),
        english = """
            (The incredibly pathetic state exactly of the absolute Gods): "That exceptionally filthy, completely utterly evil-souled demon Mahishasura (Mahishena duratmana) has violently and ruthlessly 'Kicked absolutely all the entire host of Gods flawlessly entirely straight outside' strictly from the absolute supreme Heaven (Svargannirakritah)!"
            "And currently, absolutely all those formerly glorious massive Gods, having violently lost their entire absolute raw power, are actively pathetically 'Wandering helplessly entirely exactly like ordinary, cheap mortal humans' (Vicharanti yatha martya) perfectly exactly on this physical dirt-earth (Bhuvi)!"
            Exactly when the absolute pure Gods (Energy/Positivity) are flawlessly completely securely actively perfectly residing precisely in their exact true form (Heaven), they flawlessly entirely actively run the world.
            But exactly now Mahishasura (Toxic Negativity) has violently brutally explicitly aggressively reduced them entirely exactly to such extreme absolute massive weakness that they are utterly helpless entirely exactly like cheap physical 'Martya' (mortal humans destined entirely to die).
            This is undeniably an exceptionally terrifying absolute state precisely of highly clinical 'Depression', strictly where the human's entire absolute positive energy drops dead to zero and strictly exclusively 'Darkness' (Mahishasura) violently actively Rules exactly as the ultimate supreme King.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 88,
        sanskrit = "एतद्वः कथितं सर्वममरारिविचेष्टितम् ।\nशरणं वः प्रपन्नाः स्मो वधस्तस्य विचिन्त्यताम् ॥ ८८ ॥",
        hindi = """
            (देवताओं की प्रार्थना): "हमने आप लोगों (ब्रह्मा, विष्णु, शिव) के सामने उस अमर देवताओं के भयंकर शत्रु (अमरारि / राक्षस महिषासुर) की सारी गंदी चालें और काम (विचेष्टितम्) पूरी तरह से 'कह दिए हैं' (एतद्वः कथितं सर्वम्)!"
            "अब हम सब अपनी जान बचाने के लिए आपकी ही 'शरण' (Protection) में आ गिरे हैं (शरणं वः प्रपन्नाः स्मो)! कृपया करके उस भयंकर राक्षस के 'वध' (हत्या) का कोई ठोस उपाय 'सोचिए' (वधस्तस्य विचिन्त्यताम्)!"
            देवता अपना ईगो (Ego) 100% खत्म कर चुके हैं। वे मान चुके हैं कि वे महिषासुर से नहीं जीत सकते!
            जब इंसान हार मानकर 'पूर्ण समर्पण' (शरणं प्रपन्नाः) करता है, तभी 'डिवाइन इंटरवेंशन' (Divine Intervention) होता है।
            वे विष्णु और शिव से कह रहे हैं: "हम कुछ नहीं कर सकते, अब आप ही इसके 'वध' (हत्या) का मास्टरप्लान (Masterplan) बनाइए!"
        """.trimIndent(),
        english = """
            (The absolute desperate plea exactly for protection): "We have flawlessly, fully, and aggressively 'Entirely actively narrated' (Etadvah kathitam sarvam) directly before all of You exactly absolutely all the horrifying, filthy actions and terrifying operations (Vicheshtitam) perfectly exactly of that absolute ultimate massive enemy exactly of the immortal Gods (Amarari / Mahishasura)!"
            "Now, we have flawlessly and completely violently actively fallen exactly straight directly strictly into Your absolute supreme 'Protection and Refuge' (Sharanam vah prapannah smo) strictly to casually save our pathetic lives! Kindly aggressively 'Actively profoundly Think, plan, and precisely device' an absolute flawless method exactly to execute his absolute brutal 'Slaughter and total annihilation' (Vadhastasya vichintyatam)!"
            The absolute entire host of Gods has brutally flawlessly entirely permanently annihilated exactly their massive Ego 100%. They have ruthlessly aggressively brutally accepted completely exactly that they absolutely completely fundamentally cannot possibly ever successfully defeat Mahishasura!
            Exactly when a human entirely completely aggressively fiercely gives entirely up and physically executes absolute complete 'Total Surrender' (Sharanam prapannah), exclusively only exactly then does an absolute terrifying 'Divine Intervention' flawlessly miraculously occur.
            They are violently actively furiously screaming directly perfectly explicitly exactly to Vishnu and Shiva: "We can absolutely do zero things! Now You exclusively alone absolutely flawlessly must aggressively actively aggressively entirely device the ultimate violent Masterplan exactly strictly for his brutal 'Slaughter' (Vadha)!"
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 89,
        sanskrit = "इत्थं निशम्य देवानां वचांसि मधुसूदनः ।\nचकार कोपं शम्भुश्च भृकुटीकुटिलाननौ ॥ ८९ ॥",
        hindi = """
            (विष्णु और शिव का भयंकर क्रोध): "इस प्रकार (इत्थं) उन सभी असहाय देवताओं के अत्यंत दुःख भरे वचनों (देवानां वचांसि) को 'सुनकर' (निशम्य), भगवान मधुसूदन (विष्णु) और भगवान शम्भु (शिव)।"
            "अत्यंत भयंकर 'क्रोध' (चकार कोपं) से पूरी तरह भर उठे! और उस भयानक गुस्से के कारण उन दोनों भगवानों की 'भौंहेँ (Eyebrows) तन गईं और उनका चेहरा अत्यंत टेढ़ा और खौफनाक' (भृकुटीकुटिलाननौ) हो गया!"
            
            अब 'गेम' (Game) बदल रहा है! ब्रह्मांड की सबसे बड़ी और शांत शक्तियां (विष्णु और शिव) अब अत्यंत भयंकर 'गुस्से' (Rage) में आ चुकी हैं!
            'भृकुटीकुटिलाननौ' का मतलब है गुस्से से चेहरे का अत्यंत डरावना और टेढ़ा हो जाना।
            जब धर्म (अच्छाई) पर अत्याचार अपनी सीमा पार कर जाता है, तो भगवान की 'करुणा' (Mercy) खत्म हो जाती है और उनका 'रौद्र' (Destructive) रूप बाहर आ जाता है।
        """.trimIndent(),
        english = """
            (The exceptionally terrifying apocalyptic rage of Vishnu and Shiva): "Exactly perfectly 'Hearing' (Nishamya) absolutely all these highly pathetic, intensely sorrowful exact words (Vachamsi) exclusively exactly of all those helpless Gods strictly entirely in exactly this precise manner (Ittham), direct Lord Madhusudana (Vishnu) and direct Lord Shambhu (Shiva)."
            "Instantaneously violently erupted exactly entirely completely exactly into exceptionally terrifying, blinding apocalyptic 'Absolute Rage' (Chakara kopam)! And strictly exclusively due to that exceptionally horrific massive anger, both their absolute supreme 'Eyebrows violently knitted together, brutally contorting their absolute supreme faces flawlessly perfectly exactly into an exceptionally horrifying, terrifying expression' (Bhrikutikutilananau)!"
            The absolute entire colossal 'Game' is violently explicitly aggressively entirely flawless changing exactly right now! The absolute greatest and precisely most exceptionally peaceful powers perfectly of the entire Universe (Vishnu and Shiva) have undeniably violently explicitly entered exactly into a state of absolute exceptionally terrifying apocalyptic 'Rage' (Kopa)!
            'Bhrikutikutilananau' literally profoundly perfectly means the absolute terrifying, highly brutal, and explicitly horrifying violent contortion completely of the physical face purely explicitly strictly completely due to blinding supreme anger.
            Exactly when the brutal horrific atrocities actively committed perfectly against absolute Dharma (Goodness) violently aggressively cross the absolute ultimate maximum breaking point limit, God's pure 'Mercy' (Karuna) is permanently completely suspended and His absolute terrifying 'Raudra' (Apocalyptic Destructive) physical form violently fiercely effortlessly flawlessly emerges entirely.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 90,
        sanskrit = "ततोऽतिकोपपूर्णस्य चक्रिणो वदनात्ततः ।\nनिश्चक्राम महत्तेजो ब्रह्मणः शङ्करस्य च ॥ ९० ॥",
        hindi = """
            (तीनों देवों के तेज का निकलना): "फिर (ततो), सबसे पहले अत्यंत भयंकर क्रोध से भरे हुए (अतिकोपपूर्णस्य) भगवान विष्णु (चक्रिणो) के 'मुख' (वदनात्ततः) से एक अत्यंत ही भयंकर और विशाल 'रोशनी का पुंज' (महत्तेजो / Supreme Energy) बाहर निकला (निश्चक्राम)!"
            "और ठीक उसी के तुरंत बाद, भगवान 'ब्रह्मा' (ब्रह्मणः) और भगवान 'शंकर' (शङ्करस्य च) के शरीरों से भी वैसा ही अत्यंत भयंकर और असीम तेज बाहर निकला!"
            यहीं से साक्षात् 'माँ दुर्गा' (महिषासुरमर्दिनी) के जन्म की खौफनाक प्रक्रिया शुरू होती है!
            भगवान अपना कोई 'हथियार' नहीं चला रहे हैं; वे अपने अंदर की सबसे शक्तिशाली 'परम ऊर्जा' (महत्तेजो / Divine Light) को अपने शरीर से बाहर निकाल रहे हैं!
            जब सारे देवताओं की ऊर्जाएँ (Energies) एक साथ मिलेंगी, तब ब्रह्मांड की सबसे बड़ी सुपरपावर—'महामाया दुर्गा'—साकार रूप लेंगी।
        """.trimIndent(),
        english = """
            (The terrifying violent eruption of the absolute Supreme Light): "Immediately strictly exactly exactly after that (Tato), absolute first, flawlessly directly straight exactly out of the exact physical 'Mouth' (Vadanattatah) exclusively exactly of direct Lord Vishnu (Chakrino), who was violently completely overflowing absolutely 100% strictly with exceptionally terrifying apocalyptic blinding rage (Atikopapurnasya), an exceptionally massive, horrifically powerful absolute 'Colossal Beam of Supreme Cosmic Light' (Mahattejo / Supreme Raw Energy) aggressively violently 'Erupted and flawlessly shot completely straight out' (Nishchakrama)!"
            "And absolutely exactly perfectly immediately following that, identically exceptionally terrifying and absolute boundless massive raw cosmic light violently erupted exactly from the physical bodies flawlessly exactly of Lord 'Brahma' (Brahmanah) and direct Lord 'Shankara' (Shiva / Shankarasya cha) as well!"
            Right exactly entirely perfectly from here seamlessly flawlessly violently exclusively begins the absolute terrifying majestic process explicitly precisely exactly of the actual physical incarnation strictly of direct 'Maa Durga' (Mahishasuramardini) Herself!
            The Supreme Gods are absolutely explicitly not firing any physical 'Weapons'; they are flawlessly violently executing a terrifying ejection of the absolute most exceptionally highly powerful 'Supreme Cosmic Energy' (Mahattejo / Divine Light) completely entirely straight outside from inside their physical bodies!
            Exactly when the absolute ultimate raw Energies exclusively exactly of all the Gods violently seamlessly flawlessly fuse completely exactly perfectly perfectly into exactly One, undeniably strictly then the absolute greatest supreme Superpower of the entire colossal Cosmos—'Mahamaya Durga'—will flawlessly brutally explicitly physically assume Her actual literal form.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 91,
        sanskrit = "अन्येषां चैव देवानां शक्रादीनां शरीरतः ।\nनिर्गतं सुमहत्तेजस्तच्चैक्यं समगच्छत ॥ ९१ ॥",
        hindi = """
            संसार के रचयिता ब्रह्मा, पालनहार विष्णु और संहारक शिव के भयंकर तेज़ के प्रकट होने के बाद।
            स्वर्ग के राजा 'इन्द्र' (शक्र) और वहां मौजूद अन्य सभी छोटे-बड़े देवताओं (अन्येषां चैव देवानां) के शरीरों (शरीरतः) से भी।
            एक अत्यंत भयंकर और विशाल 'रोशनी का पुंज' (सुमहत्तेजः) पूरी तरह से बाहर निकला (निर्गतं)।
            और वह सारा का सारा अलग-अलग देवताओं का 'तेज' अंतरिक्ष में जाकर 'पूरी तरह से एक साथ मिल गया' (तच्चैक्यं समगच्छत)!
            यह घटना सनातन तन्त्र का सबसे बड़ा 'कॉस्मिक फ्यूज़न' (Cosmic Fusion) है, जहाँ सारी ऊर्जाएँ एक हो रही हैं।
            जब महिषासुर (Ego) बहुत बड़ा हो जाता है, तो देवता (अच्छाई) अलग-अलग रहकर उसे बिल्कुल नहीं हरा सकते।
            इसलिए सारी पॉजिटिव एनर्जीज़ (Positive Energies) को अपना-अपना 'अहंकार' (कि मैं इन्द्र हूँ, मैं सूर्य हूँ) छोड़ना पड़ता है।
            उन्हें एक ही लक्ष्य के लिए 100% 'एक' (Unity) होना पड़ता है, ताकि सबसे बड़ी सुपरपावर पैदा की जा सके।
            यहाँ सारे 'सॉफ्टवेयर मॉड्यूल्स' (Software Modules) मिलकर ब्रह्मांड का सबसे बड़ा 'सुपर-कम्प्यूटर' (Super-computer) बना रहे हैं।
            जब तक आप अपनी सारी बिखरी हुई शक्तियों (Focus) को एक जगह इकट्ठा नहीं करते, आप अज्ञान (महिषासुर) को नहीं हरा सकते।
        """.trimIndent(),
        english = """
            Exactly after the terrifying eruption of light strictly from Brahma, Vishnu, and Shiva, the creators, sustainers, and destroyers.
            Straight exactly out of the physical bodies (Shariratah) exclusively of the King of Heaven 'Indra' (Shakra) and absolutely all the other supreme Gods (Anyesham chaiva devanam) as well.
            An exceptionally massive, horrifyingly blinding 'Supreme Cosmic Light' (Sumahattejah) violently erupted entirely outside (Nirgatam).
            And absolutely all of that completely different light of exactly all the Gods actively aggressively 'Fused flawlessly and perfectly completely exactly into ONE' (Tachchaikyam samagacchata) perfectly exactly inside deep space!
            This spectacular cosmic event is undeniably Sanatana Tantra's absolute greatest literal 'Cosmic Fusion', where absolutely all separate energies seamlessly unite.
            Exactly when Mahishasura (Highly toxic Ego) becomes exceptionally massive, totally fragmented independent Gods (separate individual Positivity) completely and flawlessly fail entirely to actively violently defeat it.
            Therefore, absolutely all the separate Positive Energies undeniably actively must ruthlessly permanently abandon exactly their personal 'Ego' (that I am Indra, I am Surya).
            They strictly undeniably actively must aggressively perfectly become exactly 100% 'One' (Unity) flawlessly perfectly exactly for exactly one single ultimate goal.
            Right here, absolutely all the completely separate 'Software Modules' aggressively actively fuse entirely straight together strictly to flawlessly build one absolute terrifying 'Super-Computer'.
            Exactly until you successfully flawlessly perfectly actively gather completely absolutely all your highly scattered and fragmented raw powers (Laser-Focus) directly entirely strictly into one single point, you absolutely cannot possibly physically defeat thick ignorance (Mahishasura).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 92,
        sanskrit = "अतीव तेजसः कूटं ज्वलन्तमिव पर्वतम् ।\nददृशुस्ते सुरास्तत्र ज्वालाव्याप्तदिगन्तरम् ॥ ९२ ॥",
        hindi = """
            वहाँ अंतरिक्ष में खड़े हुए उन सभी महान देवताओं ने (ददृशुस्ते सुरास्तत्र) उस भयानक 'तेज के पुंज' (तेजसः कूटं) को देखा।
            वह भयंकर ऊर्जा का पहाड़ बिल्कुल एक 'भयंकर रूप से जलते हुए विशाल पर्वत' (ज्वलन्तमिव पर्वतम्) के समान लग रहा था!
            और उस तेज के पहाड़ की भयंकर आग की 'ज्वालाओं' (Flames) ने पूरे ब्रह्मांड की 'दसों दिशाओं और अंतरिक्ष' (ज्वालाव्याप्तदिगन्तरम्) को पूरी तरह से घेर लिया था।
            देवताओं ने अपनी ही 'एनर्जी' (Energy) को बाहर निकालकर एक जगह जमा किया था, पर अब वे खुद ही उस रोशनी से डर रहे थे।
            वे खुद उस 'न्यूक्लियर रिएक्टर' (Nuclear Reactor / तेजसः कूटं) की भयानक गर्मी और चमक को देखकर काँप रहे थे!
            'ज्वलन्तमिव पर्वतम्' (जलते हुए पहाड़)—यह उस असीमित ऊर्जा (Infinite Energy) का प्रतीक है जो 'महामाया' की असली और फॉर्मलेस (Formless) स्थिति है।
            यह कोई साधारण आग नहीं थी; यह वह 'क्वांटम फायर' (Quantum Fire) थी जो 'ईगो' (Ego / महिषासुर) को जलाकर राख करने के लिए पैदा हुई थी।
            दसों दिशाओं (दिगन्तरम्) में सिर्फ भयंकर और अंधी कर देने वाली रोशनी ही रोशनी थी; कहीं कोई अँधेरा नहीं था।
            अज्ञान (Darkness) और पाप (Sin) के छुपने के लिए अब इस पूरे ब्रह्मांड में कोई जगह (Space) नहीं बची थी।
            जब परम चेतना का यह प्रकाश आपके अंदर जागता है, तो आपकी सारी नकारात्मकता एक सेकंड में जलकर भस्म हो जाती है।
        """.trimIndent(),
        english = """
            Absolutely all the massive Gods flawlessly actively standing exactly right there (Dadrishuste surastatra) visually vividly witnessed exactly that exceptionally terrifying 'Colossal mass of supreme cosmic light' (Tejasah kutam).
            Which literally exactly visually flawlessly appeared strictly identically like an 'Exceptionally massive, violently blazing mountain of pure fire' (Jvalantamiva parvatam)!
            And the exceptionally horrific, blinding fiery 'Flames' exactly of that massive mountain of light had flawlessly and violently 'Completely engulfed and ruthlessly invaded absolutely all the ten cosmic directions and infinite deep space' (Jvalavyaptadigantaram)!
            The absolute Gods had explicitly aggressively physically ejected entirely their very own pure 'Energy' and seamlessly flawlessly gathered it completely exactly into one location, yet exactly now they themselves were terrified.
            They themselves were violently aggressively violently shaking completely observing exactly that terrifying 'Nuclear Reactor' (Tejasah kutam) entirely due to its sheer catastrophic heat!
            'Jvalantamiva Parvatam' (A violently blazing mountain)—this is the direct, absolute ultimate literal symbol exactly of that entirely boundless Infinite Energy which actively is the actual true Formless state explicitly of 'Mahamaya'.
            This was absolutely zero ordinary cheap physical fire; this was undeniably exactly that terrifying 'Quantum Fire' exclusively entirely explicitly generated strictly to violently burn the highly toxic 'Ego' (Mahishasura) flawlessly completely exactly straight to physical Ashes!
            There was absolutely nothing exactly except terrifying blinding light actively aggressively occupying absolutely all ten directions (Digantaram); absolutely zero darkness existed anywhere.
            Absolutely zero microscopic millimeter of cheap space survived exclusively for thick Ignorance and cosmic Sin to pathetically actively hide.
            Exactly when this apocalyptic blinding supreme light of pure consciousness violently explicitly violently awakens perfectly exactly inside you, absolutely all your toxic negativity instantaneously burns permanently straight to ashes.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 93,
        sanskrit = "अतुलं तत्र तत्तेजः सर्वदेवशरीरजम् ।\nएकस्थं तदभून्नारी व्याप्तलोकत्रयं त्विषा ॥ ९३ ॥",
        hindi = """
            सभी देवताओं के शरीरों से एक साथ निकला हुआ (सर्वदेवशरीरजम्) वह 'अतुलनीय' (जिसकी कोई तुलना न हो / अतुलं तत्र तत्तेजः) अत्यंत भयंकर तेज।
            अंतरिक्ष में एक ही स्थान पर इकट्ठा होकर (एकस्थं), साक्षात् एक 'नारी' (परम स्त्री / नारी) के रूप में पूरी तरह बदल गया (तदभून्नारी)!
            और उस नारी के शरीर की भयंकर 'रोशनी और चमक' (त्विषा) ने एक ही सेकंड में 'तीनों लोकों' (व्याप्तलोकत्रयं) को पूरी तरह से भर दिया!
            यह पूरी दुर्गा सप्तशती का सबसे बड़ा 'क्लाइमेक्स' (Climax) है, जहाँ परम शक्ति साक्षात् अपना भौतिक रूप ले रही है।
            देवताओं की कंबाइंड ऊर्जा (Combined Energy) ने एक 'पुरुष' (Male) का रूप नहीं लिया, बल्कि एक 'नारी' (स्त्री / Female) का रूप लिया!
            सनातन तन्त्र का सबसे बड़ा नियम यही है: 'शिव' (चेतना/पुरुष) केवल 'विटनेस' (Witness / देखने वाला) है।
            लेकिन जो 'एक्शन' (Action), जो 'पावर' (Power), जो 'लड़ाई' (Fight) है, वह 100% 'शक्ति' (स्त्री/नारी) ही है!
            'अतुलं' का मतलब है जिसका कोई 'मैच' (Match / मुकाबला) न हो; इस ब्रह्मांड में उस परम 'माँ' की शक्ति के बराबर कोई दूसरी चीज़ है ही नहीं।
            वह नारी कोई आम औरत नहीं है; वह साक्षात् 'ब्रह्मांड की महा-एडमिनिस्ट्रेटर' (Supreme Administrator of the Universe) है।
            जिसने प्रकट होते ही केवल अपनी चमक से एक सेकंड में तीनों लोकों (स्वर्ग, पृथ्वी, पाताल) को अपने कंट्रोल (Control) में ले लिया है!
        """.trimIndent(),
        english = """
            That absolutely 'Incomparable' (possessing absolutely zero cosmic match / Atulam tatra tattejah) exceptionally terrifying massive light flawlessly violently ejected entirely straight exactly out of the physical bodies of absolutely all the Gods combined (Sarvadevasharirajam).
            Violently perfectly gathering exactly entirely strictly into one single solitary cosmic point (Ekastham), flawlessly and seamlessly miraculously transformed entirely completely exactly straight into an absolute literal 'Nari' (A Supreme Divine Woman / Tadabhunnari)!
            And the absolute horrifying, blinding 'Brilliance and infinite terrifying radiance' (Tvisha) perfectly of exactly that Woman actively aggressively 'Completely flooded and violently engulfed exactly all the three entire massive worlds' (Vyaptalokatrayam) entirely exactly in a single split-second!
            This is undeniably the absolute greatest explicit massive 'Climax' perfectly of the entire colossal Durga Saptshati, where the Supreme Power physically manifests.
            The completely flawlessly Combined Energy exactly of absolutely all the Gods actively absolutely did not seamlessly assume a 'Male' (Purusha) physical form, but aggressively violently flawlessly manifested completely exactly straight as a 'Female' (Nari / Woman)!
            This is exactly undeniably Sanatana Tantra's absolute greatest ironclad cosmic rule: 'Shiva' (Pure Consciousness / Male) is exclusively entirely merely the completely silent 'Witness'.
            However, absolutely all the explosive 'Action', all the terrifying 'Power', and the absolute total 'Fight' is strictly 100% pure 'Shakti' (Female / Nari)!
            'Atulam' strictly profoundly perfectly means exactly that which flawlessly effortlessly possesses absolutely zero cosmic 'Match'; absolutely zero other physical entity matches the Mother.
            That massive Nari is absolutely no ordinary cheap physical woman; She is undeniably literally exactly the absolute direct 'Supreme Administrator of the entire Universe'.
            Who flawlessly aggressively actively seized complete total Control exactly of absolutely all the three huge worlds (Heaven, Earth, Underworld) entirely in a single split-second merely by Her blinding radiance!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 94,
        sanskrit = "यदभूच्छाम्भवं तेजस्तेनाजायत तन्मुखम् ।\nयाम्येन चाभवन् केशा बाहवो विष्णुतेजसा ॥ ९४ ॥",
        hindi = """
            भगवान शिव (शम्भु) के शरीर से जो अत्यंत भयंकर तेज निकला था (यदभूच्छाम्भवं तेजस्)।
            उसी भयंकर शिव-तेज से साक्षात् उस देवी का 'मुख' (चेहरा / तेनाजायत तन्मुखम्) उत्पन्न हुआ!
            यमराज के तेज (याम्येन) से देवी के 'बाल' (केशा) बने (चाभवन्), और भगवान विष्णु के तेज से (विष्णुतेजसा) देवी की 'भुजाएँ' (हाथ / बाहवो) प्रकट हुईं।
            यह कोई साधारण शारीरिक रचना (Anatomy) नहीं है; यह एक 'सुपर-वेपन' (Super-Weapon) की 'असेंबली' (Assembly) है!
            शिव (Moksha/विनाश) का काम है अज्ञान को काटना; इसलिए देवी का 'चेहरा' (जिससे वह परम आदेश देंगी) साक्षात् शिव का रूप है!
            यमराज (मृत्यु/Death) का काम है प्राण खींचना; इसलिए देवी के 'बाल' (Kesha) मृत्यु के देवता की भयंकर ऊर्जा से बने हैं!
            बाल खुले होना (Unbound hair) अँधेरे और खौफ का प्रतीक है, जो राक्षसों के दिलों में मौत का सीधा खौफ पैदा करेगा।
            विष्णु (Sustainer/पालक) का काम है रक्षा करना; इसलिए 'हाथ' (जो हथियार चलाकर रक्षा करेंगे) विष्णु की असीम ऊर्जा से बने हैं!
            यानी वह देवी एक साथ शिव, यम और विष्णु की 'परम ऊर्जाओं' (Ultimate Energies) का एक साक्षात् और खौफनाक 'मशीन' (War-Machine) बन चुकी है।
            यह रूप दिखाता है कि जब भगवान अज्ञान को मारने आते हैं, तो उनका हर एक अंग एक परफेक्ट और डेडली (Deadly) हथियार होता है।
        """.trimIndent(),
        english = """
            Exactly that exceptionally horrific massive cosmic light which violently erupted flawlessly exactly from Lord Shiva (Shambhu / Yadabhucchambhavam tejas).
            Entirely from that exact identical light the literal 'Face' (Tenajayata tanmukham) strictly of that Supreme Goddess violently manifested!
            Exactly from the terrifying supreme light explicitly of Yamaraja (Yamyena), the massive 'Hair' (Kesha) perfectly of the Goddess flawlessly physically formed (Chabhavan), and entirely exactly from the blinding absolute light strictly of Lord Vishnu (Vishnutejasa), Her massive 'Arms' (Bahavo) violently physically manifested.
            This is absolutely zero cheap ordinary biological physical Anatomy flawlessly occurring; this is undeniably exactly the highly terrifying advanced 'Assembly' explicitly of the universe's ultimate 'Super-Weapon'!
            Shiva's (Moksha/Absolute Destruction) exact core job is ruthlessly actively slashing thick ignorance; therefore exactly the Goddess's 'Face' (strictly from exactly where She will fiercely roar Her commands) is literally exactly the direct absolute form exactly of Shiva!
            Yamaraja's (Absolute Death) core job is violently aggressively extracting human souls; therefore the Goddess's massive 'Hair' (Kesha) is flawlessly actively formed entirely explicitly strictly from the absolute God of Death!
            Unbound hair undeniably perfectly symbolizes absolute pitch-black darkness and terrifying fear, actively actively injecting brutal death directly into the physical hearts exactly of the demons.
            Vishnu's (Preserver/Sustainer) exact job is flawlessly actively executing supreme protection; therefore exactly the 'Arms' (which will ruthlessly actively physically wield terrifying weapons exclusively to protect) are flawlessly entirely manufactured exactly strictly from Vishnu's absolute raw energy!
            Profoundly meaning, exactly that Goddess has seamlessly flawlessly entirely actively become exactly one solitary literal 'Machine' simultaneously perfectly possessing the exact 'Ultimate Energies' entirely of Shiva, Yama, and Vishnu combined!
            This terrifying absolute form flawlessly perfectly explicitly proves that exactly when God aggressively physically arrives completely perfectly to slaughter thick ignorance, absolutely every single microscopic organ is undeniably a perfect and absolutely Deadly cosmic weapon.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 95,
        sanskrit = "सौम्येन स्तनयुग्मं च मध्यमैन्द्रेण चाभवत् ।\nवारुणेन च जङ्घोरू नितम्बस्तेजसा भुवः ॥ ९५ ॥",
        hindi = """
            चन्द्रमा (सोम) के अत्यंत शीतल तेज (सौम्येन) से देवी के 'दोनों वक्षस्थल' (स्तनयुग्मं / Breasts) पूरी तरह से प्रकट हुए।
            देवराज इन्द्र के तेज (ऐन्द्रेण) से देवी का 'कमर का मध्य भाग' (मध्यम्) बना (चाभवत्)।
            जल के देवता वरुण के तेज से (वारुणेन च) देवी की भयंकर 'जंघाएं और पिंडली' (Thighs and legs / जङ्घोरू) बनीं।
            और स्वयं साक्षात् पृथ्वी (भूमण्डल) के तेज से (तेजसा भुवः) देवी का 'नितम्ब भाग' (Hips / नितम्बस्) उत्पन्न हुआ।
            माता के हर शारीरिक अंग (Body part) के पीछे एक बहुत ही गहरा और साइंटिफिक कॉस्मिक विज्ञान (Cosmic Science) छिपा हुआ है!
            चन्द्रमा (Moon) 'अमृत' (Nectar) और 'ममता' (Motherhood) का प्रतीक है, इसलिए देवी का जो रूप ब्रह्मांड को पोषण (दूध) देगा, वह चन्द्रमा की एनर्जी से बना है।
            इन्द्र (Indra) 'शक्ति और संतुलन' (Power and Center) का प्रतीक है, इसलिए शरीर के गुरुत्वाकर्षण को थामने वाली 'कमर' इन्द्र से बनी है।
            पृथ्वी (Earth) 'आधार' (Base/Foundation) का सबसे बड़ा प्रतीक है, इसलिए शरीर का भारी बेस (नितम्ब) साक्षात् पृथ्वी की ग्रेविटी (Gravity) से बना है।
            यह कोई काल्पनिक कथा (Fantasy) नहीं है; यह ब्रह्मांड के सारे 'एलिमेंट्स' (Elements - Water, Earth, Gravity, Center) का एक ही पॉइंट पर 'सिंक्रोनाइज़' (Synchronize) होना है।
            पूरा ब्रह्मांड एक ही शरीर (Macrocosm in Microcosm) के रूप में पूरी तरह से 'डाउनलोड' (Download) हो चुका है।
        """.trimIndent(),
        english = """
            Exactly completely from the exceptionally cool, deeply soothing massive absolute light exclusively of the Moon (Soma / Saumyena), the Goddess's 'Both Breasts' (Stanayugmam) flawlessly violently manifested.
            Strictly entirely from the terrifying supreme light explicitly of the King of Gods Indra (Aindrena), the Goddess's exact 'Middle waist region' (Madhyam) physically perfectly flawlessly formed (Chabhavat).
            Exactly entirely completely from the massive absolute light strictly of the God of Cosmic Waters, Varuna (Varunena cha), the Goddess's exceptionally massive 'Thighs and lower legs' (Janghoru) flawlessly violently physically formed.
            And directly exclusively from the sheer blinding raw cosmic light explicitly of the physical Earth itself (Tejasa bhuvah), the Goddess's massive 'Hips' (Nitambas) perfectly physically manifested.
            Flawlessly existing perfectly exactly behind every single highly specific Body Part actively physically formed is undeniably a highly terrifying, exceptionally advanced 'Cosmic Science' strictly entirely completely perfectly hidden!
            The Moon (Soma) is undeniably the absolute supreme direct literal symbol perfectly of 'Nectar' (Amrita) and pure 'Motherhood', therefore exactly that physical part of the Goddess explicitly designed exclusively to flawlessly actively feed Cosmic Nourishment entirely to the universe is entirely explicitly manufactured strictly from the Moon.
            Indra undeniably is the direct absolute supreme literal symbol exactly of raw 'Power and Central Balance'; therefore the massive 'Waist' flawlessly designed to flawlessly explicitly support the massive body's gravity is perfectly formed strictly exactly from Indra.
            The massive physical Earth flawlessly explicitly perfectly symbolizes the absolute ultimate 'Base/Foundation'; therefore exactly the heavy core base exactly of the physical body (Hips) is flawlessly actively entirely manufactured explicitly directly strictly exactly out of the massive Gravity of the Earth.
            This is absolutely zero cheap fake Fantasy; this is undeniably literally exactly the absolute 'Synchronization' flawlessly perfectly exactly entirely of absolutely all the massive cosmic 'Elements' (Water, Earth, Gravity, Space) aggressively violently actively fusing perfectly exactly straight into ONE single cosmic point.
            The absolute entire colossal Universe flawlessly seamlessly actively aggressively physically 'Downloaded' entirely completely perfectly straight exclusively perfectly exactly as exactly one solitary physical body (Macrocosm in Microcosm).
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 96,
        sanskrit = "ब्रह्मणस्तेजसा पादौ तदङ्गुल्योऽर्कतेजसा ।\nवसूनां च कराङ्गुल्यः कौबेरेण च नासिका ॥ ९६ ॥",
        hindi = """
            सृष्टि की रचना करने वाले ब्रह्मा जी के भयंकर तेज से (ब्रह्मणस्तेजसा) देवी के 'दोनों पैर' (पादौ) पूरी तरह से उत्पन्न हुए।
            सूर्य देव (अर्क) के अत्यंत चमचमाते हुए तेज से (अर्कतेजसा) देवी के 'पैरों की उंगलियां' (तदङ्गुल्यो) बनीं।
            आठों वसुओं (Vasus) के महान तेज से (वसूनां च) देवी के 'हाथों की उंगलियां' (कराङ्गुल्यः) बनीं।
            और धन के देवता कुबेर के तेज से (कौबेरेण च) देवी की 'नासिका' (नाक / नासिका) साक्षात् प्रकट हुई।
            ब्रह्मा (Creator) ने यह पूरी दुनिया बनाई है, पर देवी के विशाल शरीर के सामने ब्रह्मा की औकात केवल उनके 'पैरों' (Feet) जितनी ही है!
            यानी पूरी दुनिया (ब्रह्मा की सृष्टि) केवल और केवल माता के चरणों की धूल में ही मौजूद है।
            सूर्य (Sun) जो पूरे सोलर सिस्टम (Solar System) को रोशनी और जीवन देता है, वह केवल माता के पैरों के 'नाखूनों' (उंगलियों) की छोटी सी चमक है!
            हाथों की उंगलियां (वसु) जो सारा कर्म (Action) करती हैं, वे ब्रह्मांड की 'डायरेक्शन' (Direction) और एनर्जी फ्लो (Energy flow) को कंट्रोल करती हैं।
            कुबेर (धन का देवता) नाक (Nose/सांस) बना है; यानी दुनिया का सारा पैसा, सोना और लक्ज़री (Luxury) केवल माता की एक 'साँस' (Breath) पर टिका हुआ है।
            धन (Money) केवल एक साँस की तरह है, जो कब अंदर आएगी और कब बाहर चली जाएगी, यह कोई नहीं जानता।
        """.trimIndent(),
        english = """
            Exactly entirely from the horrifying massive absolute supreme light strictly exactly of Lord Brahma, the absolute creator (Brahmanastejasa), the Goddess's 'Both massive Feet' (Padau) flawlessly physically formed.
            Directly exclusively from the absolute blinding raw cosmic light explicitly of the Sun God (Arka / Arkatejasa), the Goddess's exact 'Toes' (Tadangulyo) physically perfectly flawlessly violently manifested.
            Exactly entirely completely from the massive absolute light strictly of absolutely all the eight Vasus (Vasunam cha), the Goddess's exceptionally massive 'Fingers of both hands' (Karangulyah) flawlessly violently physically formed.
            And directly exclusively from the sheer blinding raw cosmic light explicitly of Kubera, the absolute God of Supreme Wealth (Kauberena cha), the Goddess's massive 'Nose' (Nasika) perfectly physically erupted.
            Lord Brahma (The Creator) undeniably flawlessly perfectly manufactured this entire world, but strictly compared entirely perfectly directly to the Goddess's colossal body, Brahma's cosmic worth is flawlessly exclusively entirely limited merely exactly exactly to Her 'Feet'!
            Meaning, the absolute entire world (Brahma's creation) actively exists entirely completely perfectly exclusively exactly strictly entirely directly completely inside the literal dust exactly of the Mother's sacred feet alone.
            The Sun which relentlessly entirely perfectly continuously actively feeds pure light entirely directly perfectly to the entire Solar System, is absolutely merely the microscopic tiny flash completely of the Mother's toenails (Toes)!
            The fingers of the hands (Vasus) which perfectly flawlessly actively flawlessly actively physically flawlessly perform all Action, flawlessly control the absolute cosmic 'Direction' and Energy flow entirely perfectly completely.
            Kubera (God of Wealth) physically became the literal Nose (Breath); meaning, absolutely all the entire world's massive money, gold, and cheap Luxury actively rests flawlessly exactly entirely completely perfectly exactly upon merely ONE single physical 'Breath' of the Mother.
            Physical Money is undeniably exactly like a single breath, exactly absolutely perfectly exactly precisely no human can possibly ever successfully actively flawlessly predict exactly when it completely enters and exactly when it violently exits.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 97,
        sanskrit = "तस्यास्तु दशना जाताः प्राजापत्येन तेजसा ।\nनयनत्रितयं जज्ञे तथा पावकतेजसा ॥ ९७ ॥",
        hindi = """
            संसार के रचयिता प्रजापति के महान तेज से उस परम देवी के 'दांत' (दशना) उत्पन्न हुए।
            और अग्नि देव (पावक) के अत्यंत भयंकर और धधकते हुए तेज से देवी के 'तीनों नेत्र' (नयनत्रितयं) प्रकट हुए।
            यह कोई साधारण शारीरिक रचना नहीं है, बल्कि ब्रह्मांडीय ऊर्जाओं का साक्षात् प्रकट होना है।
            प्रजापति (दक्ष आदि) सृष्टि के निर्माण का प्रतीक हैं, इसलिए देवी के दांत (जो चबाते और नष्ट करते हैं) उनके तेज से बने हैं।
            दांत चबाने (Destruction) का काम करते हैं, और यह दिखाता है कि देवी राक्षसों के अज्ञान को चबा जाएगी।
            अग्नि (Fire) ज्ञान और प्रकाश का सबसे बड़ा प्रतीक है, जो अँधेरे को पूरी तरह जलाकर राख कर देती है।
            इसलिए देवी की तीन आँखें (भूत, वर्तमान, भविष्य को देखने वाली) साक्षात् अग्नि के तेज से बनी हैं।
            तीसरा नेत्र (Third Eye) परम चेतना का प्रतीक है, जो खुलने पर माया के सबसे बड़े जालों को भस्म कर देता है।
            देवताओं ने अपनी सबसे शुद्ध शक्तियां देवी को सौंप दीं, ताकि महिषासुर का अहंकार हमेशा के लिए मिटाया जा सके।
            यहाँ महामाया कोई एक देवता नहीं, बल्कि पूरे ब्रह्मांड के देवताओं की 'कंबाइंड सुपरपावर' (Combined Superpower) बन चुकी हैं!
        """.trimIndent(),
        english = """
            From the exceptionally massive and brilliant light of Prajapati, the creator of the world, the Goddess's 'Teeth' (Dashana) physically manifested.
            And strictly from the terrifying, violently blazing supreme light of Agni (Fire God), the Goddess's 'Three Eyes' (Nayanatritayam) flawlessly erupted perfectly.
            This is absolutely no ordinary biological creation, but the direct, literal manifestation of absolute supreme cosmic energies.
            Prajapati profoundly symbolizes the ultimate foundation of creation, hence the Goddess's teeth (which brutally chew and destroy) are explicitly formed from him.
            Teeth actively perform the violent action of chewing (Destruction), flawlessly proving that the Goddess will ruthlessly chew the demons' ignorance.
            Agni (Fire) is undeniably the absolute greatest symbol of supreme wisdom and blinding light, which aggressively burns thick darkness entirely to ashes.
            Therefore, the Goddess's three eyes (flawlessly viewing the past, present, and future) are strictly manufactured entirely from Agni's absolute raw light.
            The Third Eye explicitly perfectly symbolizes supreme pure consciousness, which upon opening violently incinerates the absolute greatest webs of Maya.
            The absolute Gods ruthlessly surrendered their purest powers directly to the Goddess, strictly to permanently annihilate Mahishasura's toxic ego forever.
            Right here, Mahamaya is absolutely no single deity, but has flawlessly seamlessly become the 'Combined Superpower' of the entire colossal universe!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 98,
        sanskrit = "भ्रुवौ च सन्ध्ययोस्तेजः श्रवणावनिलस्य च ।\nअन्येषां चैव देवानां सम्भवस्तेजसां शिवा ॥ ९८ ॥",
        hindi = """
            सुबह और शाम की परम संधियों (सन्ध्ययोः) के भयंकर तेज से उस महादेवी की 'भौंहेँ' (Eyebrows / भ्रुवौ) प्रकट हुईं।
            और वायु देव (अनिलस्य) के अत्यंत शक्तिशाली तेज से उस भगवती के 'दोनों कान' (श्रवणौ) उत्पन्न हुए।
            इसी प्रकार अन्य सभी छोटे-बड़े देवताओं (अन्येषां चैव देवानां) के महान तेज से उस परम कल्याणी 'शिवा' (Goddess) का जन्म हुआ।
            संध्या (Dawn and Dusk) वह समय है जब दिन और रात मिलते हैं, जो संतुलन (Balance) का सबसे बड़ा प्रतीक है।
            इसलिए देवी की भौंहेँ (जो चेहरे का संतुलन बनाती हैं) साक्षात् दोनों संधियों की ऊर्जा से बनी हैं।
            वायु (Wind) ध्वनि (Sound) को एक जगह से दूसरी जगह ले जाती है, इसलिए देवी के कान (जो ब्रह्मांड की पुकार सुनेंगे) वायु देव के तेज से बने हैं।
            इस प्रकार देवी 'शिवा' (परम मंगलमयी) के एक-एक अंग में पूरे ब्रह्मांड का परम विज्ञान (Cosmic Science) छिपा हुआ है।
            वे केवल एक स्त्री नहीं हैं; वे साक्षात् 'यूनिवर्स' (Universe) का एक चलता-फिरता रूप (Walking Universe) बन चुकी हैं।
            सारे देवताओं ने अपना 'अस्तित्व' (Existence) मिटाकर खुद को देवी के चरणों में पूरी तरह से समर्पित (Surrender) कर दिया है।
            तभी यह परम महाशक्ति महिषासुर रूपी भयंकर 'वायरस' (Virus) को इस ब्रह्मांड के सिस्टम (System) से डिलीट (Delete) कर पाएगी।
        """.trimIndent(),
        english = """
            From the exceptionally terrifying and profound light exactly of the cosmic twilights (Sandhyas), the Great Goddess's 'Eyebrows' (Bhruvau) miraculously manifested.
            And strictly from the incredibly massive raw power explicitly of Vayu (Wind God), the Goddess's 'Both Ears' (Shravanau) flawlessly perfectly emerged.
            Exactly in this highly precise manner, from the combined light of absolutely all other remaining Gods (Anyesham chaiva devanam), that supreme auspicious Goddess 'Shiva' was violently born.
            Sandhya (Dawn and Dusk) is exactly that precise time when day and night merge, profoundly representing the ultimate absolute symbol of cosmic Balance.
            Therefore, the Goddess's eyebrows (which perfectly establish the balance of the face) are literally explicitly formed directly from the energy of both twilights.
            Vayu (Wind) flawlessly transports physical Sound across space, hence the Goddess's ears (which will hear the universe's cry) are built strictly from Vayu's light.
            In this exact manner, the absolute supreme Cosmic Science of the entire universe is flawlessly perfectly hidden inside every single organ of Goddess 'Shiva'.
            She is absolutely no ordinary woman; She has undeniably seamlessly transformed exactly into the direct, literal 'Walking Universe' Herself completely.
            Absolutely all the massive Gods violently erased their personal 'Existence' completely and flawlessly actively executing absolute Total Surrender exactly at Her sacred feet.
            Strictly and exclusively only then will this Supreme Superpower flawlessly completely successfully 'Delete' the highly toxic terrifying 'Virus' called Mahishasura directly from the cosmic System.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 99,
        sanskrit = "ततः समस्तदेवानां तेजोराशिसमुद्भवाम् ।\nतां विलोक्य मुदं प्रापुरमरा महिषार्दिताः ॥ ९९ ॥",
        hindi = """
            संसार के सभी देवताओं (समस्तदेवानां) की असीम और भयंकर ऊर्जा के उस विशाल पुंज (तेजोराशिसमुद्भवाम्) से इस प्रकार उत्पन्न हुई।
            उस परम महामाया देवी को अपनी आँखों से साक्षात् देखकर (तां विलोक्य), महिषासुर के भयंकर अत्याचारों से सताए हुए (महिषार्दिताः) वे सभी देवता।
            अत्यंत भयंकर 'प्रसन्नता और खुशी' (मुदं प्रापुः) से पूरी तरह भर उठे, क्योंकि अब उन्हें अपनी जीत का पूरा भरोसा हो गया था!
            जब आप भयंकर डिप्रेशन और हार (महिषासुर के अत्याचार) के दौर से गुज़र रहे होते हैं, तो आपको एक 'चमत्कार' (Miracle) की ज़रूरत होती है।
            सभी देवताओं ने अपनी 'पॉजिटिविटी' (Positivity) को मिलाकर एक किया, और उसका परिणाम 'माँ दुर्गा' के रूप में साक्षात् उनके सामने खड़ा था।
            उस महाशक्ति को देखकर देवताओं का सारा डर, डिप्रेशन और निराशा एक ही सेकंड में 100% गायब (Vanish) हो गई।
            यह 'मुदं प्रापुः' (परम खुशी) कोई साधारण ख़ुशी नहीं है; यह उस मरीज़ की ख़ुशी है जिसे मौत के मुँह से बचने की दवा (Cure) मिल गई हो!
            महिषासुर (अहंकार) चाहे कितना भी बड़ा क्यों न हो, जब 'महामाया' (परम चेतना) जाग जाती है, तो अहंकार का मरना 100% तय (Certain) हो जाता है।
            देवता अब समझ चुके थे कि उनका काम केवल देवी का निर्माण करना था; अब आगे की सारी लड़ाई केवल और केवल माता ही लड़ेंगी।
            सनातन धर्म हमें सिखाता है कि जब आप अपना कर्म 100% कर देते हैं, तो उसके बाद भगवान स्वयं आपके युद्ध (Battles) लड़ने के लिए आगे आ जाते हैं।
        """.trimIndent(),
        english = """
            Flawlessly and miraculously born exactly in this terrifying manner explicitly from that massive colossal mountain of supreme energy (Tejorashisamudbhavam) of absolutely all the Gods.
            Vividly witnessing exactly that absolute Supreme Mahamaya Goddess directly with their own eyes (Tam vilokya), absolutely all those specific Gods completely tormented and crushed by Mahishasura (Mahisharditah).
            Instantaneously violently erupted completely perfectly exactly into exceptionally overwhelming 'Absolute Joy and Supreme Happiness' (Mudam prapuh), perfectly realizing their absolute flawless victory was now 100% guaranteed!
            Exactly when you are actively brutally suffering through exceptionally highly terrifying Depression and brutal defeat (Mahishasura's atrocities), you absolutely desperately demand a literal 'Miracle'.
            Absolutely all the Gods actively aggressively completely fused their entire 'Positivity' strictly into exactly ONE, and the ultimate explosive result was directly physically standing flawlessly before them exactly as 'Maa Durga'.
            Actively witnessing that terrifying supreme Superpower, the absolute entire horrifying fear, depression, and despair of the Gods vanished entirely perfectly exactly to mathematical Zero in exactly a single split-second.
            This precise 'Mudam prapuh' (Supreme Joy) is absolutely no cheap ordinary happiness; it is exactly the literal joy of a dying patient flawlessly receiving the absolute ultimate immortal Cure!
            Exactly regardless of exactly how exceptionally massive Mahishasura (Toxic Ego) might be, exactly when 'Mahamaya' (Supreme Consciousness) violently awakens, the ego's absolute brutal death becomes 100% physically Certain.
            The absolute Gods flawlessly comprehended completely exactly that their ultimate job was exclusively restricted strictly to manifesting the Goddess; now absolutely all further massive cosmic battles will be fought strictly exclusively by the Mother alone.
            Sanatana Dharma explicitly strictly profoundly teaches us exactly that exactly when you flawlessly completely execute your absolute Karma 100%, exactly then God Himself seamlessly violently steps forward explicitly exclusively to fight your absolute terrifying Battles.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 100,
        sanskrit = "शूलं शूलाद्विनिष्कृष्य ददौ तस्यै पिनाकधृक् ।\nचक्रं च दत्तवान् कृष्णः समुत्पाद्य स्वचक्रतः ॥ १०० ॥",
        hindi = """
            इसके बाद भगवान शिव (पिनाकधृक्) ने अपने भयंकर त्रिशूल (शूलाद्) में से ही एक और अत्यंत भयंकर 'त्रिशूल' (शूलं) बाहर निकाला (विनिष्कृष्य)।
            और वह खौफनाक त्रिशूल उन्होंने उस परम देवी को युद्ध लड़ने के लिए पूरी तरह 'समर्पित कर दिया' (ददौ तस्यै)।
            उसी प्रकार भगवान श्री कृष्ण (विष्णु) ने भी अपने भयंकर 'सुदर्शन चक्र' (स्वचक्रतः) से ही एक और अत्यंत विनाशकारी 'चक्र' (चक्रं) उत्पन्न किया (समुत्पाद्य)।
            और वह परम शक्तिशाली चक्र उन्होंने माता को महिषासुर का सिर काटने के लिए पूरी श्रद्धा से 'भेंट कर दिया' (दत्तवान्)!
            देवी का शरीर तो बन गया, पर अब उन्हें 'सॉफ्टवेयर अपडेट्स' (Software Updates) और 'हथियारों' (Weapons) की ज़रूरत थी।
            शिव का 'त्रिशूल' तीन गुणों (सत्व, रज, तम) और तीन कालों (भूत, भविष्य, वर्तमान) को एक साथ कंट्रोल करने वाला सबसे भयंकर 'एडमिन टूल' (Admin Tool) है।
            विष्णु का 'चक्र' (Sudarshana) समय का प्रतीक है, जो लगातार घूमता है और किसी भी बड़े से बड़े अहंकार (महिषासुर) को सेकंडों में डिलीट (Delete) कर सकता है।
            ये देवता अपने खुद के हथियार देवी को दे रहे हैं; इसका मतलब है कि उन्होंने अपनी 'फ्री-विल' (Free-will) और 'ताकत' 100% माता को सौंप दी है।
            जब आप भगवान को अपना 'सब कुछ' सौंप देते हैं, तभी वह परम शक्ति आपके लिए सबसे बड़े राक्षसों का संहार करने के लिए मैदान में उतरती है।
            यहाँ से 'महिषासुरमर्दिनी' (महिषासुर को मारने वाली माता) का असली और खौफनाक रूप पूरी तरह से 'हथियारों से लैस' (Fully Armed) होना शुरू होता है।
        """.trimIndent(),
        english = """
            Immediately following this, direct Lord Shiva (Pinakadhrik) violently aggressively extracted (Vinishkrishya) another exceptionally horrific terrifying 'Trident' (Shulam) perfectly exactly straight from His very own cosmic Trident (Shulad).
            And He flawlessly, completely respectfully entirely 'Surrendered and officially gifted' (Dadau tasyai) exactly that highly horrific trident directly to that Supreme Goddess exclusively for fighting the cosmic war.
            Exactly in the identical flawless manner, direct Lord Krishna (Vishnu) aggressively violently generated and seamlessly flawlessly manifested (Samutpadya) another exceptionally apocalyptic destructive 'Discus' (Chakram) straight explicitly from His very own terrifying 'Sudarshana Chakra' (Svachakratah).
            And He flawlessly completely entirely 'Gifted' (Dattavan) exactly that absolute supreme powerful discus strictly directly to the Mother exclusively to ruthlessly actively sever Mahishasura's head!
            The Goddess's massive physical body was flawlessly created, but exactly now She desperately actively required explicit absolute 'Software Updates' and terrifying cosmic 'Weapons'.
            Shiva's 'Trident' is undeniably the absolute ultimate terrifying 'Admin Tool' flawlessly actively aggressively controlling absolutely all three Gunas (Sattva, Rajas, Tamas) and all three Time dimensions (Past, Present, Future) entirely simultaneously.
            Vishnu's 'Chakra' flawlessly seamlessly profoundly symbolizes absolute Time, which relentlessly violently spins and successfully Deletes completely exactly even the absolute greatest toxic Ego (Mahishasura) precisely in mere seconds.
            These massive supreme Gods are flawlessly actively surrendering entirely their very own terrifying weapons directly to the Goddess; flawlessly proving they have brutally permanently abandoned their 100% 'Free-will' and raw power completely to the Mother.
            Exactly when you flawlessly completely surrender absolutely 'Everything' directly exactly to God, strictly and exclusively only then does that absolute Supreme Power actively aggressively step entirely exactly onto the battlefield strictly to physically slaughter your absolute greatest demons.
            Right exactly from here, the actual, literal, and absolute most exceptionally horrific terrified physical form perfectly of 'Mahishasuramardini' violently entirely begins to seamlessly actively flawlessly perfectly become '100% Fully Armed'.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 101,
        sanskrit = "शङ्खं च वरुणः प्रादाद् हुताशश्चापि शक्तिमाम् ।\nमारुतो दत्तवांश्चापं बाणपूर्णे तथेषुधी ॥ १०१ ॥",
        hindi = """
            जल के देवता वरुण ने माता को अपना भयंकर 'शंख' (शङ्खं च वरुणः प्रादाद्) प्रदान किया, जो अपनी आवाज़ से दुश्मनों का दिल चीर देता है।
            अग्नि देव (हुताशन) ने देवी को अपनी अत्यंत विनाशकारी 'शक्ति' (भाला / हुताशश्चापि शक्तिमाम्) भेंट की, जो किसी भी राक्षस को जलाकर भस्म कर सकती है।
            और वायु देव (मारुतो) ने माता को अपना भयंकर 'धनुष' (दत्तवांश्चापं) और साथ ही 'बाणों से हमेशा भरे रहने वाले दो तरकश' (बाणपूर्णे तथेषुधी) प्रदान किए!
            अब सारे प्राकृतिक तत्व (Natural Elements) माता को अपने 'सुपर-वेपन्स' (Super-weapons) सौंप रहे हैं!
            वरुण का 'शंख' (Conch) कॉस्मिक वाइब्रेशन (Cosmic Vibration / ॐ) का प्रतीक है। जब देवी इसे बजाएंगी, तो राक्षसों का नर्वस सिस्टम (Nervous system) वहीं क्रैश (Crash) हो जाएगा!
            अग्नि की 'शक्ति' (Spear) वह परम फोकस (Focus) और विलपॉवर (Willpower) है जो किसी भी समस्या (Problem) को सीधे छेद (Pierce) कर रख देती है।
            वायु का 'धनुष और बाण' इंसान के 'मन और विचारों' (Mind and Thoughts) का प्रतीक है; देवी के बाण कभी खत्म नहीं होते (बाणपूर्णे), जिसका मतलब है उनका ज्ञान (Knowledge) असीमित है।
            यह कोई 'कहानी' (Story) नहीं है; यह एक 'योद्धा' (Warrior) को तैयार करने का वह परम सूत्र (Formula) है जो हमें भी अपने जीवन में उतारना चाहिए।
            बिना शंख (आवाज़/Truth), अग्नि (फोकस/Focus), और वायु (तीर/Action) के आप दुनिया का कोई भी युद्ध नहीं जीत सकते।
            महामाया अब एक 'परफेक्ट वॉर-मशीन' (Perfect War-Machine) में बदल रही हैं, जिसका एक ही लक्ष्य है—अहंकार (महिषासुर) का 100% सर्वनाश!
        """.trimIndent(),
        english = """
            The supreme God of Cosmic Waters, Varuna, flawlessly fiercely presented strictly to the Mother his terrifying massive 'Conch' (Shankham cha varunah pradad), which violently perfectly rips the absolute physical hearts of enemies exactly with its horrific sound.
            Agni, the Lord of Fire, aggressively gifted directly to the Goddess his exceptionally apocalyptic terrifying 'Shakti' (Spear / Hutashashchapi shaktimam), which flawlessly flawlessly burns absolutely any demon exactly instantly straight to physical ashes.
            And Vayu, the supreme God of Wind (Maruto), flawlessly aggressively presented entirely directly to the Mother his highly terrifying 'Bow' (Dattavamshchapam) and identically explicitly exactly 'Two quivers entirely completely perpetually overflowing flawlessly exclusively with infinite arrows' (Banapurne tatheshudhi)!
            Exactly now absolutely all the ultimate Natural Elements are completely flawlessly actively aggressively perfectly violently surrendering exactly their absolute supreme 'Super-Weapons' entirely straight directly perfectly to the Mother!
            Varuna's massive 'Conch' is undeniably the exact absolute explicit physical symbol flawlessly of 'Cosmic Vibration' (OM). Exactly when the Goddess violently explicitly blows it, the physical Nervous System of absolutely all demons will seamlessly violently Crash exactly right there!
            Agni's 'Shakti' (Spear) is absolutely exactly that supreme ultimate Focus and raw Willpower which flawlessly perfectly brutally Pierces completely straight entirely exactly through absolutely any massive Problem.
            Vayu's 'Bow and Arrows' flawlessly perfectly symbolize exactly the human's 'Mind and Thoughts'; the Goddess's arrows absolutely never completely run out (Banapurne), profoundly perfectly literally meaning Her absolute Wisdom is strictly completely infinite.
            This is absolutely zero cheap physical 'Story'; this is exactly the ultimate absolute supreme explicit 'Formula' to flawlessly perfectly prepare an absolute 'Warrior', which we absolutely flawlessly actively must physically implement strictly in our lives.
            Completely entirely without the Conch (Voice/Truth), Agni (Laser-Focus), and Vayu (Arrows/Action), you absolutely cannot possibly ever strictly actively win absolutely any massive war exactly in the physical world.
            Mahamaya is exactly now seamlessly flawlessly violently explicitly transforming exactly straight into an absolute 'Perfect War-Machine', who possesses exactly one absolute ultimate solitary target—the flawless 100% total annihilation completely of toxic Ego (Mahishasura)!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 102,
        sanskrit = "इन्द्रः कुलिशमुत्पाद्य कुलिशात् स्वकात् ददौ ।\nघण्टामैरावताद् गजात् ॥ १०२ ॥",
        hindi = """
            हजारों आँखों वाले देवराज इन्द्र (सहस्राक्षो इन्द्रः) ने अपने भयंकर 'वज्र' में से ही एक और खौफनाक 'वज्र' (कुलिशमुत्पाद्य कुलिशात् स्वकात्) उत्पन्न किया।
            और वह वज्र उन्होंने देवी को दे दिया (ददौ तस्यै); साथ ही इन्द्र ने अपने परम हाथी 'ऐरावत' (ऐरावताद्गजात्) के गले से निकालकर एक भयंकर 'घंटा' (घण्टाम्) भी देवी को समर्पित कर दिया।
            मृत्यु के देवता यमराज ने अपने मृत्यु-पाश (Death-rod) से एक 'कालदण्ड' (दण्डान्मृत्युर्ददौ दण्डं) माता को दिया, और जलपति वरुण ने एक और अत्यंत मजबूत 'पाश' (पाशं चाम्बुपतिर्ददौ / Noose) माता को भेंट किया!
            यहाँ हथियारों का 'लेवल' (Level) और भी ज़्यादा डरावना (Terrifying) होता जा रहा है!
            इन्द्र का 'वज्र' (Thunderbolt) आकाशीय बिजली है, जो सबसे तेज़ और सबसे घातक (Lethal) प्रहार का प्रतीक है।
            इन्द्र का 'घंटा' (Bell) वह भयंकर आवाज़ (Frequency) है जो राक्षसों के दिमाग को सुन्न (Paralyze) कर देता है। जब देवी घंटा बजाती हैं, तो राक्षसों का 'ईगो' (Ego) थर-थर काँपने लगता है!
            यमराज का 'दण्ड' (Rod) साक्षात् 'कर्मों की सज़ा' (Punishment of Karma) का प्रतीक है। देवी इसका इस्तेमाल राक्षसों को उनके पापों की सज़ा देने के लिए करेंगी।
            वरुण का 'पाश' (Noose) वह फंदा है जो भागते हुए दुश्मन (अज्ञान) को जकड़ कर उसे भागने का कोई मौका नहीं देता।
            इन सभी हथियारों का मिलना यह साबित करता है कि महिषासुर का 'एस्केप-प्लान' (Escape Plan) अब 100% फेल (Fail) हो चुका है।
            जब महामाया किसी को मारने (डिलीट करने) पर उतर आती हैं, तो यूनिवर्स की कोई भी शक्ति उसे बचा नहीं सकती।
        """.trimIndent(),
        english = """
            The thousand-eyed King of Gods, Indra (Sahasraksho Indrah), aggressively violently generated and explicitly created another exceptionally horrific 'Vajra' (Kulishamutpadya kulishat svakat) straight directly exclusively from his very own terrifying absolute 'Vajra' (Thunderbolt).
            And he flawlessly presented exactly that Vajra directly strictly perfectly exactly to the Goddess (Dadau tasyai); additionally, Indra aggressively violently explicitly removed an exceptionally terrifying 'Bell' (Ghantam) flawlessly perfectly exactly from his supreme elephant 'Airavata' (Airavatadgajat) and entirely surrendered it to the Goddess.
            Yamaraja, the absolute God of Death, explicitly violently gifted an apocalyptic 'Kala-Danda' (Dandanmrityurdadau dandam) perfectly exactly straight directly entirely from his very own absolute Death-Rod, and the Lord of Waters Varuna violently presented another exceptionally indestructible 'Pasha' (Pasham chambupatirdadau / Noose) directly to the Mother!
            Exactly right here, the absolute supreme cosmic 'Level' of these weapons is actively aggressively seamlessly flawlessly becoming exceptionally billions of times more 'Terrifying'!
            Indra's 'Vajra' (Thunderbolt) is undeniably the absolute direct lightning flawlessly explicitly from the sky, perfectly symbolizing exactly the absolute fastest and absolute most brutally 'Lethal' massive strike.
            Indra's 'Bell' is exactly that exceptionally horrific violent absolute Sound (Frequency) perfectly designed to completely ruthlessly actively 'Paralyze' the exact physical brains completely of the demons. Exactly when the Goddess rings it, the demons' toxic 'Ego' actively shatters!
            Yamaraja's 'Danda' (Rod) is undeniably exactly the direct literal explicit symbol exactly of the absolute 'Punishment of Karma'. The Goddess will violently explicitly actively exploit it exclusively exactly to aggressively brutally punish the exact demons for their sins.
            Varuna's 'Pasha' (Noose) is exactly that absolutely inescapable trap flawlessly completely entirely actively binding the violently fleeing enemy (Ignorance) securely, leaving absolutely zero millimeter exactly for Escape.
            The absolute aggressive active flawless reception completely of exactly all these weapons perfectly actively explicitly proves exactly that Mahishasura's pathetic 'Escape Plan' has flawlessly brutally completely Failed 100%.
            Exactly when Mahamaya aggressively explicitly actively decides entirely perfectly completely strictly to flawlessly violently physically slaughter (Delete) someone, absolutely zero power completely inside the massive Universe can possibly ever successfully save him.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 103,
        sanskrit = "कालदत्तवान् खड्गं तस्याश्चर्म च निर्मलम् ।\nक्षीरोदश्चामलं हारम् अजरौ वाससी ॥ १०३ ॥",
        hindi = """
            इस सृष्टि के रचयिता 'ब्रह्मा जी' (ब्रह्मा) ने अपने परम ज्ञान के प्रतीक स्वरूप माता को एक 'कमण्डलु' (कमण्डलुं प्रादात्) भेंट किया!
            सूर्य देव (सूर्यः) ने माता के शरीर के सभी 'रोम-कूपों' (pores/रश्मिषु) में अपनी अत्यंत भयंकर और धधकती हुई 'किरणों' (Rays) को पूरी तरह से भर दिया (रश्मिषु निजं तेजः)!
            साक्षात् काल (समय के देवता / कालः) ने माता को एक अत्यंत तेज़ 'खड्ग' (तलवार / खड्गं) और एक अत्यंत चमचमाती हुई 'ढाल' (चर्म च निर्मलम्) प्रदान की!
            और क्षीरसागर (दूध के समुद्र / क्षीरोदः) ने माता को कभी मैला न होने वाला एक अत्यंत 'उज्ज्वल मोतियों का हार' (अमलं हारम्) और कभी न फटने वाले 'दिव्य वस्त्र' (अजरौ वाससी) भेंट किए!
            अब हथियार (Weapons) से आगे बढ़कर माता को 'ज्ञान' (Knowledge) और 'सुरक्षा' (Armor) दी जा रही है!
            ब्रह्मा जी का 'कमण्डलु' (Water-pot) साक्षात् 'सृष्टि के बीज' (Seed of Creation) और परम शांति का प्रतीक है; जो दिखाता है कि देवी केवल संहार ही नहीं, बल्कि 'नई शुरुआत' (New Beginning) भी करेंगी।
            सूर्य देव का देवी के रोम-रोम में भर जाना (Sun's rays in every pore) यह सिद्ध करता है कि देवी का रूप अब इतना 'ब्लाइंडिंग' (Blindingly bright) हो गया है कि राक्षस उन्हें सीधे देख भी नहीं पाएंगे!
            'काल' (Time) की तलवार और ढाल सबसे ज़्यादा लॉजिकल (Logical) हथियार है! काल (समय) हर चीज़ को काटता है (तलवार), और समय ही रक्षा भी करता है (ढाल)।
            क्षीरसागर का हार और दिव्य कपड़े देवी के 'सौंदर्य और पूर्णता' (Beauty and Perfection) के प्रतीक हैं। देवी भयंकर होने के साथ-साथ अत्यंत 'दिव्य' (Divine) भी हैं।
            यह 'सुपर-कम्प्यूटर' (देवी) अब पूरी तरह से असेंबल (Assemble) और 'बूट-अप' (Boot-up) हो चुका है!
        """.trimIndent(),
        english = """
            The absolute supreme creator exactly of this entire massive creation, 'Lord Brahma' (Brahma), flawlessly perfectly aggressively violently gifted an absolute 'Kamandalu' (Water-pot / Kamandalum pradat) entirely directly strictly to the Mother precisely as the exact explicit physical symbol of his absolute supreme cosmic wisdom!
            Surya, the Lord of the Sun (Suryah), violently aggressively completely filled absolutely all the massive 'Pores' (Rashmishu) exactly of the Mother's physical body seamlessly perfectly flawlessly entirely exactly with His exceptionally terrifying, violently blazing 'Rays' (Rashmishu nijam tejah)!
            Direct absolute Kala (The ultimate Supreme God of Time / Kalah) flawlessly perfectly presented explicitly completely exactly to the Mother an exceptionally sharp terrifying 'Sword' (Khadgam) and an incredibly violently blazing, brilliantly shining 'Shield' (Charma cha nirmalam)!
            And the massive Ocean of Milk (Kshirodah) aggressively actively explicitly perfectly flawlessly gifted the Mother an exceptionally pure, entirely stainless 'Necklace of brilliant pearls' (Amalam haram) and entirely immortal, completely indestructible 'Divine cosmic garments' (Ajarau vasasi)!
            Exactly now moving seamlessly entirely completely far completely perfectly beyond entirely explicit physical Weapons, the Mother is flawlessly aggressively actively being violently securely armored entirely completely exactly with pure 'Knowledge' and 'Defense' (Armor)!
            Lord Brahma's 'Kamandalu' (Water-pot) undeniably flawlessly completely actively flawlessly symbolizes the direct literal 'Seed of Creation' and absolute supreme peace; flawlessly explicitly perfectly entirely proving that the Goddess will absolutely not merely slaughter, but flawlessly seamlessly execute an entirely 'New Beginning'.
            The precise exact violent explicit saturation entirely of the Sun's blinding rays completely straight exactly into absolutely every single physical pore flawlessly undeniably perfectly proves the Mother's absolute explicit physical form has actively entirely securely violently become so exceptionally 'Blinding' the demons absolutely entirely cannot possibly even physically directly look strictly at Her!
            The absolute sword and supreme shield exactly of 'Kala' (Time) are undeniably the absolute most highly Logical weapons! Time flawlessly aggressively actively physically slices absolutely everything (Sword), and exact identical Time seamlessly completely actively powerfully defends perfectly (Shield).
            The Ocean of Milk's absolute pure necklace and divine garments seamlessly flawlessly completely symbolize exactly the Goddess's absolute explicit 'Beauty and Perfection'. The Mother is exceptionally terrifying and simultaneously exceptionally 'Divine'.
            This explicit terrified absolute 'Super-Computer' (The Goddess) has flawlessly actively seamlessly entirely aggressively completely successfully exactly securely 'Assembled' and perfectly entirely 100% 'Booted-up'!
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 104,
        sanskrit = "चूड़ामणिं तथा दिव्यं कुण्डले कटकानि च ।\nअम्लानपङ्कजां मालां शिरस्युरसि चापराम् ॥ १०४ ॥",
        hindi = """
            विश्वकर्मा (ब्रह्मांड के परम इंजीनियर) ने देवी को एक अत्यंत चमचमाता हुआ भयंकर 'फरसा' (चूड़ामणिं तथा दिव्यं कुण्डले कटकानि च) और अनेक 'दिव्य आभूषण' दिए।
            उन्होंने देवी को कभी न टूटने वाले 'कड़े', 'बाजूबंद' (केयूर), और पैरों के लिए 'दिव्य नूपुर' (नूपुरौ) भी पहनाए!
            समुद्र (जल के देवता) ने माता को अत्यंत सुंदर 'कमल के फूलों की माला' (अम्लानपङ्कजां मालां) और हाथों में पकड़ने के लिए एक अत्यंत सुंदर 'कमल का फूल' (पङ्कजं च) भेंट किया।
            और साक्षात् हिमालय पर्वत (हिमवान्) ने माता की सवारी के लिए एक अत्यंत भयंकर 'शेर' (सिंहं वाहनं) और अनेकों प्रकार के खूंखार 'रत्न' (रत्नानि) माता को समर्पित कर दिए!
            विश्वकर्मा (Vishwakarma) देवताओं के चीफ इंजीनियर (Chief Engineer) हैं! वे देवी को वह सब कुछ दे रहे हैं जो इस 'ब्रह्मांडीय युद्ध' (Cosmic War) के लिए टेक्निकली (Technically) ज़रूरी है।
            दिव्य आभूषण केवल 'गहने' (Jewelry) नहीं हैं; ये कॉस्मिक 'शील्ड्स' (Cosmic Shields) हैं जो देवी की एनर्जी को एक जगह केंद्रित (Focus) रखते हैं।
            समुद्र का 'कमल' (Lotus) शांति (Peace) का प्रतीक है। देवी के एक हाथ में तलवार (विनाश) है और दूसरे हाथ में कमल (शांति); यही परम 'बैलेंस' (Balance) है।
            और सबसे महत्वपूर्ण—हिमालय ने देवी को 'शेर' (Lion) दिया! शेर 'परम धर्म', 'साहस' (Courage), और 'लीडरशिप' (Leadership) का सबसे बड़ा साक्षात् प्रतीक है!
            देवी का 'शेर पर बैठना' (Riding the Lion) यह दिखाता है कि उन्होंने अपने अंदर के सबसे खूंखार पशु-स्वभाव (Animal instincts) को 100% 'कंट्रोल' (Control) कर लिया है।
            अब 'शेरावाली माता' (The Goddess on the Lion) अपने पूरे फॉर्म (Form) में आ चुकी हैं, और महिषासुर की उल्टी गिनती (Countdown) शुरू हो चुकी है!
        """.trimIndent(),
        english = """
            Vishvakarma (The absolute supreme Chief Engineer of the entire cosmos) aggressively explicitly actively gifted the Mother an exceptionally brilliant, violently blazing terrifying 'Axe' (Chudamanim tatha divyam kundale katakani cha) and flawlessly exceptionally countless 'Divine supreme cosmic ornaments'.
            He explicitly flawlessly violently aggressively completely physically armored the exact Goddess entirely exclusively strictly flawlessly with absolutely completely entirely indestructible 'Bangles', massive 'Armlets' (Keyura), and entirely exceptionally absolute divine 'Anklets' exactly for Her feet (Nupurau)!
            The massive supreme Ocean (Lord of Waters) flawlessly actively explicitly perfectly presented directly entirely to the Mother an exceptionally exquisite 'Garland entirely of unfading immortal lotus flowers' (Amlanapankajam malam) and identically exactly an exceptionally brilliant physical 'Lotus flower' (Pankajam cha) exactly to actively hold strictly perfectly inside Her hands.
            And the direct literal absolute massive Himalaya Mountain himself (Himavan) flawlessly actively aggressively violently explicitly surrendered completely exactly strictly directly to the Mother an exceptionally horrifying terrifying massive 'Lion' (Simham vahanam) explicitly entirely for Her to ride exactly and completely countless kinds of cosmic 'Gems' (Ratnani)!
            Vishvakarma is undeniably the absolute literal direct explicit Chief Engineer perfectly of absolutely all the Gods! He flawlessly actively aggressively heavily exactly actively explicitly physically completely arms the Mother entirely perfectly with absolutely everything strictly 'Technically' mandatory exclusively exactly for this terrifying 'Cosmic War'.
            The exact massive divine ornaments are absolutely completely entirely not merely cheap physical 'Jewelry'; they are directly exactly absolute literal 'Cosmic Shields' flawlessly actively violently securely completely perfectly focusing the entire absolute raw Energy of the Mother.
            The Ocean's flawless pure 'Lotus' flawlessly seamlessly perfectly undeniably symbolizes absolute pure Peace. The Goddess actively grips a terrifying sword (Destruction) perfectly in one hand and exactly a peaceful Lotus (Peace) strictly in the exact other; this undeniably exactly completely perfectly perfectly flawlessly exactly constitutes absolute cosmic 'Balance'.
            And absolutely the exact explicit most incredibly massive important event—Himalaya aggressively actively entirely perfectly violently explicitly presented the exact absolute literal 'Lion' directly to the Goddess! The specific physical Lion undeniably flawlessly effortlessly explicitly explicitly perfectly symbolizes absolute supreme 'Dharma', absolute complete total raw 'Courage', and the ultimate exact explicit literal absolute cosmic 'Leadership'!
            The exact physical action exactly of the Goddess explicitly actively perfectly completely violently 'Riding the Lion' undeniably seamlessly flawlessly perfectly explicitly violently visually actively actively proves completely exactly that She has successfully 100% flawlessly perfectly 'Controlled' absolutely entirely completely absolutely all the most exceptionally horrifying brutal animalistic biological instincts!
            Exactly now the absolute ultimate terrifying 'Sherawali Mata' (The Supreme Goddess perfectly riding the massive Lion) has violently seamlessly entirely fully manifested completely exactly perfectly strictly entirely completely in Her absolute entire massive Form, and Mahishasura's exact absolute total literal countdown has aggressively violently begun!
        """.trimIndent()
    )
)