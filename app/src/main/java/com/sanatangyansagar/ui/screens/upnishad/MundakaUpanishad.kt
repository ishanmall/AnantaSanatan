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

data class MundakaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MundakaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..20) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-20)") },
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
            itemsIndexed(mundakaShlokasList) { _, shloka ->
                MundakaShlokaCard(shloka)
            }
        }
    }
}

@Composable
fun MundakaShlokaCard(shloka: MundakaShloka) {
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
            Text(text = "हिन्दी अर्थ:", fontWeight = FontWeight.Bold, color = Color(0xFF1565C0))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "English Meaning:", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

val mundakaShlokasList = listOf(
    MundakaShloka(
        id = 1,
        sanskrit = "ॐ ब्रह्मा देवानां प्रथमः सम्बभूव विश्वस्य कर्ता भुवनस्य गोप्ता । स ब्रह्मविद्यां सर्वविद्याप्रतिष्ठामथर्वाय ज्येष्ठपुत्राय प्राह ॥ १ ॥",
        hindi = """
            ब्रह्मा जी देवताओं में सबसे पहले उत्पन्न हुए, जो इस ब्रह्मांड के रचयिता हैं।
            वे संपूर्ण भुवनों के रक्षक और संचालक माने जाते हैं, उनकी शक्ति असीम है।
            उन्होंने ब्रह्मविद्या का उपदेश दिया, जो समस्त विद्याओं का आधार और मूल है।
            यह सर्वोच्च ज्ञान उन्होंने अपने ज्येष्ठ पुत्र अथर्वा को सबसे पहले प्रदान किया।
            ब्रह्मविद्या ही वह प्रकाश है जिससे अज्ञान का अंधकार पूरी तरह मिट जाता है।
            सृष्टि के आरंभ में ही सत्य के ज्ञान की परंपरा इस प्रकार स्थापित हुई।
            बिना इस आधारभूत ज्ञान के अन्य सभी लौकिक विद्याएँ अधूरी और व्यर्थ हैं।
            यह श्लोक गुरु-शिष्य परंपरा के दैवीय उद्गम की ओर संकेत करता है।
            ब्रह्मा का ज्ञान ही संसार की रक्षा करने वाला असली कवच और शक्ति है।
            यहीं से मुण्डक उपनिषद की महान ज्ञान यात्रा का औपचारिक आरंभ होता है।
        """.trimIndent(),
        english = """
            Brahma was the first among the gods to manifest in this vast universe.
            He is the creator of the world and the supreme protector of existence.
            He imparted the knowledge of Brahman, the foundation of all sciences.
            This sacred wisdom was first taught to his eldest son, Atharvan.
            Brahmavidya is hailed as the cornerstone upon which all learning rests.
            The verse establishes the divine lineage of spiritual and cosmic truth.
            It emphasizes that spiritual knowledge precedes all worldly achievements.
            Brahma represents the creative intelligence that governs our reality.
            Without this foundational wisdom, the mysteries of life remain unsolved.
            This shloka highlights the importance of preserving ancient sacred traditions.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 2,
        sanskrit = "अथर्वणे यां प्रवदेत ब्रह्माथर्वा तां पुरोवाचाङ्गिरे ब्रह्मविद्याम् । स भारद्वाजाय सत्यवहाय प्राह भारद्वाजोऽङ्गिरसे परावराम् ॥ २ ॥",
        hindi = """
            अथर्वा को ब्रह्मा द्वारा प्राप्त ज्ञान उन्होंने प्राचीन काल में अंगिर को दिया।
            अंगिर ने वही ब्रह्मविद्या भारद्वाज गोत्र के सत्यवह को विस्तार से सिखाई।
            सत्यवह ने उस महान परावर विद्या को महर्षि अंगिरस को पूर्णतः प्रदान किया।
            इस प्रकार यह ज्ञान एक ऋषि से दूसरे ऋषि तक अखंड रूप से पहुँचता रहा।
            ब्रह्मविद्या को 'परावरा' कहा गया है क्योंकि यह गुरु से शिष्य तक बहती है।
            यह श्लोक बताता है कि आध्यात्मिक सत्य कभी भी अकेले नहीं खोजा जाता।
            ज्ञान की प्रमाणिकता उसके शुद्ध और प्रामाणिक संचरण (Transmission) में है।
            परंपरा ही वह माध्यम है जिससे सत्य अपनी मौलिकता और शक्ति बनाए रखता है।
            ऋषियों का यह वंश वृक्ष केवल रक्त का नहीं, बल्कि शुद्ध बोध का है।
            ज्ञान की इस श्रृंखला में हर शिष्य आगे चलकर एक समर्थ गुरु बन जाता है।
        """.trimIndent(),
        english = """
            The wisdom Brahma gave to Atharvan was later passed on to Angir.
            Angir taught this science of Brahman to Satyavaha of Bharadvaja clan.
            Satyavaha then imparted this higher knowledge to the great Sage Angiras.
            The verse traces the historical succession of the ultimate spiritual truth.
            It describes Brahmavidya as 'Paravara', passed from the high to the low.
            Spiritual insight is traditionally acquired through a recognized lineage.
            This ensures that the purity of the message remains intact over ages.
            The Guru-Shishya tradition is the lifeblood of Vedic and Yogic wisdom.
            It proves that true enlightenment is a shared heritage of humanity.
            Every link in this chain represents a master who realized the Self.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 3,
        sanskrit = "शौनको ह वै महाशालोऽङ्गिरसं विधिवदुपसन्नः पप्रच्छ । कस्मिन्नु भगवो विज्ञाते सर्वमिदं विज्ञां भवत्तीति ॥ ३ ॥",
        hindi = """
            महान गृहस्थ शौनक ने शास्त्रोक्त विधि से महर्षि अंगिरस के पास जाकर पूछा।
            उनका प्रश्न अत्यंत मौलिक था: 'हे भगवन! वह क्या है जिसे जानने पर सब ज्ञात होता है?'
            यह प्रश्न जिज्ञासा की पराकाष्ठा है जो संपूर्ण जगत के मूल को ढूँढती है।
            शौनक यह जानना चाहते थे कि क्या कोई ऐसा एक तत्व है जो सबका आधार है।
            यदि हम उस एक मूल कारण को जान लें, तो क्या कार्य (सृष्टि) स्वतः ज्ञात होगी?
            यह श्लोक उपनिषद की उस वैज्ञानिक पद्धति को दर्शाता है जो एकत्व खोजती है।
            विविधता के पीछे छिपी एकता को पहचानना ही वास्तविक और पूर्ण ज्ञान है।
            शौनक का समर्पण और उनकी विनम्रता एक आदर्श शिष्य की पहचान कराती है।
            यहाँ से वह महान उपदेश शुरू होता है जो परा और अपरा विद्या का भेद करेगा।
            यह जिज्ञासा ही मनुष्य को साधारण जीवन से उठाकर ब्रह्मत्व की ओर ले जाती है।
        """.trimIndent(),
        english = """
            Saunaka, a great householder, approached Sage Angiras with due respect.
            He asked: 'Venerable Sir, what is that, by knowing which, all is known?'
            This is the ultimate inquiry into the fundamental cause of the universe.
            The seeker looks for a singular principle that explains the entire diversity.
            By knowing the seed or the source, one understands the whole tree of life.
            It represents the Upanishadic quest for the Absolute amidst the relative.
            This question bridges the gap between material science and spirituality.
            Saunaka's approach signifies the necessity of a qualified guide for Truth.
            The Sage’s answer will define the two types of knowledge: Para and Apara.
            It suggests that true wisdom lies in finding the essence of everything.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 4,
        sanskrit = "तस्मै स होवाच । द्वे विद्ये वेदितव्ये इति ह स्म यद्ब्रह्मविदो वदन्ति परा चैवापरा च ॥ ४ ॥",
        hindi = """
            महर्षि अंगिरस ने उत्तर दिया: 'दो प्रकार की विद्याएँ जानने योग्य होती हैं।'
            ब्रह्म को जानने वाले विद्वान ऐसा कहते हैं—एक 'परा' और दूसरी 'अपरा' विद्या।
            अपरा विद्या वह है जो हमें सांसारिक वस्तुओं और धर्म-कर्म का ज्ञान देती है।
            परा विद्या वह है जिससे उस अक्षर (विनाशरहित) परमात्मा का बोध होता है।
            संसार को चलाने के लिए अपरा जरूरी है, पर स्वयं को जानने के लिए परा अनिवार्य है।
            बिना इस वर्गीकरण के साधक अक्सर कर्मकांडों के जाल में ही उलझा रहता है।
            यह श्लोक ज्ञान के क्षेत्र को दो स्पष्ट भागों में विभाजित कर स्पष्टता देता है।
            अपरा विद्या नश्वर है, जबकि परा विद्या शाश्वत और मोक्षदायिनी मानी जाती है।
            दोनों का अपना महत्व है, पर अंतिम लक्ष्य केवल परा विद्या की प्राप्ति ही है।
            यहाँ से ऋषि विस्तारपूर्वक बताते हैं कि इन दोनों विद्याओं में क्या शामिल है।
        """.trimIndent(),
        english = """
            The Sage replied: 'Two kinds of knowledge are to be acquired by man.'
            Thus say the knowers of Brahman—the Higher (Para) and the Lower (Apara).
            Apara Vidya deals with the phenomenal world, rituals, and worldly sciences.
            Para Vidya is that by which the Indestructible Reality is fully realized.
            The lower knowledge is useful for survival, the higher for liberation.
            This distinction is crucial for a seeker to avoid getting lost in rituals.
            It categorizes the entire scope of human learning into two distinct levels.
            The lower is transient and relative; the higher is eternal and absolute.
            Both have their roles, but the ultimate goal is the realization of Para.
            This sets the stage for a detailed explanation of the Vedic curriculum.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 5,
        sanskrit = "तत्रापरा ऋग्वेदो यजुर्वेदः सामवेदोऽथर्ववेदः शिक्षा कल्पो व्याकरणं निरुक्तं छन्दो ज्योतिषमिति । अथ परा यया तदक्षरमधिगम्यते ॥ ५ ॥",
        hindi = """
            ऋग्वेद, यजुर्वेद, सामवेद और अथर्ववेद—ये चारों वेद अपरा विद्या के अंग हैं।
            शिक्षा, कल्प, व्याकरण, निरुक्त, छन्द और ज्योतिष भी इसी श्रेणी में आते हैं।
            यह सारा ज्ञान शब्दों, कर्मों और सांसारिक नियमों के प्रबंधन तक ही सीमित है।
            किंतु 'परा' वह विद्या है जिससे उस अविनाशी (अक्षर) तत्व को प्राप्त किया जाए।
            वेदों का पाठ करना अपरा है, पर वेदों के सार (ब्रह्म) को अनुभव करना परा है।
            यहाँ ऋषि बताते हैं कि केवल मंत्र रटना ही पूर्णता नहीं, बोध ही पूर्णता है।
            अपरा विद्या बुद्धि को तेज करती है, पर परा विद्या आत्मा को मुक्त करती है।
            अक्षर वह है जो कभी नहीं बदलता, जो समय और स्थान के प्रभाव से परे है।
            साधक को अपरा से आगे बढ़कर परा की गहराई में उतरने का प्रयास करना चाहिए।
            यह श्लोक धार्मिक ग्रंथों और उनके वास्तविक अनुभव के बीच का अंतर बताता है।
        """.trimIndent(),
        english = """
            Apara includes the four Vedas: Rig, Yajur, Sama, and Atharva Veda.
            It also includes phonetics, ritual, grammar, etymology, metrics, and astrology.
            This encompasses all linguistic, ritualistic, and intellectual sciences.
            But 'Para' is that wisdom by which the Imperishable is reached.
            Reading the scriptures is Apara; realizing the Truth within them is Para.
            The verse warns that mere academic scholarship is not enlightenment.
            Lower knowledge polishes the mind, while higher knowledge frees the soul.
            The 'Akshara' is that which remains unchanged amidst the changing world.
            One must graduate from intellectual data to direct spiritual experience.
            This shloka defines the limitations of scripture and the vastness of Truth.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 6,
        sanskrit = "यत्तदद्रेश्यमग्राह्यमगोत्रमवर्णमचक्षुःश्रोत्रं तदपाणिपादम् । नित्यं विभुं सर्वगतं सुसूक्ष्मं तदव्ययं यद्भूतयोनिं परिपश्यन्ति धीराः ॥ ६ ॥",
        hindi = """
            वह तत्व जो आँखों से नहीं दिखता, जिसे हाथों से पकड़ा नहीं जा सकता।
            जिसका कोई गोत्र या जाति नहीं, जिसका कोई रंग या भौतिक स्वरूप नहीं है।
            जिसके न आँख-कान हैं और न ही हाथ-पैर, वह इंद्रियों के बोध से परे है।
            वह नित्य (शाश्वत), विभु (अत्यंत समर्थ) और सर्वत्र व्याप्त सूक्ष्म तत्व है।
            वह अव्यय है (जिसका कभी क्षय नहीं होता) और वही संपूर्ण प्राणियों का मूल है।
            धीर और विवेकी पुरुष ही उसे अपने हृदय के भीतर स्पष्ट रूप से देख पाते हैं।
            यह श्लोक निराकार ब्रह्म के लक्षणों का अत्यंत सूक्ष्म और गहरा वर्णन करता है।
            वह सब कुछ होकर भी किसी भी भौतिक सीमा में कभी भी नहीं बँधता है।
            सृष्टि उसी से उत्पन्न होती है और उसी में अंततः वापस विलीन हो जाती है।
            उसे जानने के लिए बाहरी दृष्टि की नहीं, बल्कि आंतरिक विवेक की आवश्यकता है।
        """.trimIndent(),
        english = """
            That which is invisible, ungraspable, without lineage or social class.
            It has no eyes, no ears, no hands, and no feet—it is beyond senses.
            It is eternal, all-pervading, omnipresent, and exceedingly subtle.
            It is the Imperishable Source of all beings that the wise behold everywhere.
            The Absolute transcends all physical attributes and biological limits.
            One cannot find It through the physical senses or the thinking mind.
            Only those with steady wisdom can perceive this underlying Reality.
            It is the womb from which the entire tapestry of existence is woven.
            This verse provides a negative description to point toward the Positive.
            To realize It, one must transcend the labels of form, color, and name.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 7,
        sanskrit = "यथोर्णनाभिः सृजते गृह्णते च यथा पृथिव्यामोषधयः सम्भवन्ति । यथा सतः पुरुषात्केशलोमानि तथाक्षरात्सम्भवतीह विश्वम् ॥ ७ ॥",
        hindi = """
            जिस प्रकार मकड़ी स्वयं अपने भीतर से जाला निकालती है और उसे समेट लेती है।
            जिस प्रकार उपजाऊ पृथ्वी से अनेक प्रकार की औषधियाँ और वनस्पतियाँ उगती हैं।
            जिस प्रकार जीवित मनुष्य के शरीर से नाखून और बाल स्वतः ही निकलते रहते हैं।
            ठीक उसी प्रकार, उस अविनाशी अक्षर ब्रह्म से यह संपूर्ण विश्व उत्पन्न होता है।
            परमात्मा को सृष्टि बनाने के लिए किसी बाहरी सामग्री की आवश्यकता नहीं होती।
            वह स्वयं ही निमित्त (कर्ता) है और स्वयं ही उपादान (सामग्री) भी है।
            यह उदाहरण बताते हैं कि सृष्टि परमात्मा का ही एक स्वाभाविक विस्तार है।
            जैसे जाला मकड़ी से अलग नहीं, वैसे ही संसार परमात्मा से भिन्न नहीं है।
            उत्पत्ति के बाद भी परमात्मा में कोई कमी नहीं आती, वह पूर्ण ही रहता है।
            यह श्लोक सृष्टि की उत्पत्ति के अत्यंत वैज्ञानिक और सरल उदाहरण प्रस्तुत करता है।
        """.trimIndent(),
        english = """
            As a spider projects and withdraws its web from within its own body.
            As various herbs and plants grow spontaneously from the fertile earth.
            As hair grows from the body of a living person without any effort.
            So does the entire universe emerge from the Imperishable Brahman.
            The Divine does not need external materials to create the cosmos.
            He is both the efficient cause and the material cause of existence.
            These metaphors illustrate that creation is a natural extension of God.
            The web is not separate from the spider; the world is not separate from Him.
            Creation does not diminish the Infinite; it remains eternally whole.
            This verse provides intuitive examples to explain the mystery of creation.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 8,
        sanskrit = "तपसा चीयते ब्रह्म ततोऽन्नमभिजायते । अन्नात्प्राणो मनः सत्यं लोकाः कर्मसु चामृतम् ॥ ८ ॥",
        hindi = """
            तप (ज्ञानमय संकल्प) के द्वारा ब्रह्म का विस्तार होता है और सृष्टि बनती है।
            उस ब्रह्म से सबसे पहले 'अन्न' (अव्याकृत प्रकृति) का प्रादुर्भाव होता है।
            अन्न से प्राण (ऊर्जा), मन, सत्य (पंचभूत) और विभिन्न लोकों की उत्पत्ति हुई।
            कर्मों के द्वारा ही सुख-दुख के फल और अमृतत्व (शाश्वत नियम) प्राप्त होते हैं।
            यहाँ 'तप' का अर्थ शारीरिक कष्ट नहीं, बल्कि सृजन का गहरा विचार है।
            सृष्टि का हर स्तर एक क्रमबद्ध विकास (Sequential Evolution) का परिणाम है।
            पदार्थ से चेतना और चेतना से कर्म तक की यात्रा यहाँ स्पष्ट की गई है।
            बिना प्राण के पदार्थ जड़ है, और बिना मन के प्राण दिशाहीन होता है।
            यह श्लोक ब्रह्मांड के सूक्ष्म अंगों के निर्माण की प्रक्रिया को समझाता है।
            परमात्मा की इच्छा शक्ति ही वह बीज है जिससे यह सारा प्रपंच फैला है।
        """.trimIndent(),
        english = """
            Brahman expands through Tapas (contemplation), and from it, food is born.
            From food (matter) comes Prana (energy), Mind, Truth, and the worlds.
            The results of actions and the laws of immortality are established thereafter.
            Tapas here refers to the focused creative thought of the Absolute.
            Creation is a systematic evolution from the subtle to the grosser forms.
            It explains the ladder of existence from pure being to physical matter.
            Without energy (Prana), matter is inert; without mind, energy is blind.
            Every layer of reality is interconnected and emerges from the same Source.
            This verse outlines the cosmic blueprint of the manifest universe.
            The divine will is the catalyst that sets the wheel of creation in motion.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 9,
        sanskrit = "यः सर्वज्ञः सर्वविद्यस्य ज्ञानमयं तपः । तस्मादेतद्ब्रह्म नाम रूपमन्नं च जायते ॥ ९ ॥",
        hindi = """
            वह परमात्मा सर्वज्ञ (सामान्य ज्ञान वाला) और सर्वविद् (विशेष ज्ञान वाला) है।
            उसका तप केवल ज्ञान स्वरूप है, जिसमें कोई प्रयास या परिश्रम नहीं है।
            उसी परम सत्ता से यह हिरण्यगर्भ ब्रह्म, नाम, रूप और अन्न उत्पन्न होते हैं।
            ईश्वर का ज्ञान ही वह शक्ति है जो शून्यता में व्यवस्था (Order) लाती है।
            वह हर जीव के भीतर की सूक्ष्म भावनाओं और बाहरी कार्यों को जानता है।
            नाम और रूप ही वे सीमाएं हैं जिनसे हम संसार की वस्तुओं को पहचानते हैं।
            सृष्टि का सारा विविधतापूर्ण खेल उसी के ज्ञान-तप की एक अभिव्यक्ति है।
            वह कर्ता होकर भी अकर्ता है क्योंकि उसका सृजन स्वाभाविक और सहज है।
            यह श्लोक ईश्वर की सर्वशक्तिमान बुद्धिमत्ता का परिचय देता है।
            बिना उसके ज्ञान के, यह ब्रह्मांड एक अव्यवस्थित ढेर के समान होता।
        """.trimIndent(),
        english = """
            He is all-knowing in general and all-perceiving in every detail.
            His Tapas consists of pure knowledge, effortless and all-encompassing.
            From Him are born the first creator, names, forms, and food (matter).
            Divine intelligence is the force that brings order into the void.
            He is aware of the subtlest intentions and the grandest cosmic events.
            Name and form are the coordinates through which we navigate reality.
            The entire diversity of life is a reflection of His cognitive heat.
            He is the creator who remains uninvolved, as His creation is natural.
            This verse introduces the omniscient character of the Supreme Being.
            Without His wisdom, the universe would be a chaotic and lifeless heap.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 10,
        sanskrit = "तदेतत्सत्यं मन्त्रेषु कर्माणि कवयो यान्यपश्यंस्तानि त्रेतायां बहुधा सन्ततानि । तान्याचरथ नियतं सत्यकामा एष वः पन्थाः सुकृतस्य लोके ॥ १० ॥",
        hindi = """
            यह सत्य है कि ऋषियों ने मंत्रों में जिन कर्मों (यज्ञों) का दर्शन किया था।
            वे त्रेता युग में (तीन वेदों के माध्यम से) बहुत विस्तार से फैलाए गए।
            हे सत्य चाहने वालों! तुम उन कर्मों का निरंतर श्रद्धा के साथ अनुष्ठान करो।
            शुभ फल प्राप्त करने के लिए यही तुम्हारा मुख्य और प्रामाणिक मार्ग है।
            यहाँ 'सत्य' का अर्थ कर्मों के निश्चित और अचूक परिणामों से है।
            यज्ञ केवल अग्नि का खेल नहीं, बल्कि ब्रह्मांडीय शक्तियों से जुड़ने का विज्ञान है।
            प्राचीन ऋषियों ने ध्यान की अवस्था में इन विधियों को साक्षात् देखा था।
            सत्यकामा वे हैं जो अपने जीवन में ईमानदारी और पवित्रता की खोज करते हैं।
            यह श्लोक अपरा विद्या यानी कर्मकांड के महत्व को पहले चरण में स्वीकारता है।
            सांसारिक सुख और स्वर्ग की प्राप्ति के लिए कर्म ही एकमात्र साधन हैं।
        """.trimIndent(),
        english = """
            This is the truth: the rituals which the sages saw in the mantras.
            They were practiced extensively during the Vedic age of three fires.
            Perform them constantly, O seekers of truth, with faith and diligence.
            This is your primary path to the worlds earned by good deeds.
            'Truth' here refers to the certainty of the results of ritual actions.
            Sacrifice is a science of connecting with universal cosmic energies.
            Ancient seers perceived these methods in their states of deep meditation.
            'Satyakama' are those who yearn for honesty and merit in their lives.
            The verse acknowledges the importance of Apara Vidya as a starting point.
            For earthly success and heavenly gains, action is the indispensable tool.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 11,
        sanskrit = "यदा लेलायते ह्यर्चिः समिद्धे हव्यवाहने । तदान्तरावाहुतीभ्यां प्रतिपादयेच्छ्रद्धयाहुतम् ॥ ११ ॥",
        hindi = """
            जब प्रज्वलित अग्नि की लपटें यज्ञ-वेदी में चारों ओर ऊँची उठने लगें।
            तब साधक को दो आहुतियों के बीच में श्रद्धापूर्वक आहुति प्रदान करनी चाहिए।
            अग्नि ही देवताओं का मुख है जो हमारी प्रार्थनाओं को उन तक पहुँचाता है।
            यज्ञ की सफलता के लिए समय, विधि और मन की एकाग्रता बहुत जरूरी है।
            श्रद्धा के बिना दी गई आहुति केवल धुएँ के समान है, उसका कोई फल नहीं।
            जब अग्नि स्थिर और प्रकाशमान हो, तभी वह मंत्रों की शक्ति ग्रहण करती है।
            यह श्लोक यज्ञ की सूक्ष्म तकनीकी प्रक्रिया और उसकी गरिमा को बताता है।
            बाहरी अग्नि हमारे भीतर की संकल्प-अग्नि का ही एक दृश्य रूप है।
            यज्ञ हमें त्याग और समर्पण का वह पाठ सिखाता है जो अहंकार को मिटाता है।
            विधिपूर्वक किया गया कर्म ही कर्ता के जीवन में अनुशासन और शांति लाता है।
        """.trimIndent(),
        english = """
            When the fire is well-kindled and the flames are moving high.
            One should offer the oblations with faith between the two portions of fire.
            Fire is the mouth of the gods through which prayers reach the subtle realms.
            Timing, method, and mental focus are essential for a successful ritual.
            An offering without faith is like mere smoke; it yields no spiritual fruit.
            Only when the flame is steady and bright does it absorb the mantra's power.
            The verse describes the technical precision required in Vedic sacrifices.
            External fire is a symbol of the internal fire of determination and will.
            Sacrifice teaches the lesson of renunciation that dissolves the ego.
            Methodical action brings discipline and harmony into the performer's life.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 12,
        sanskrit = "यस्याग्निहोत्रमदर्शमपौर्णमासमचातुर्मास्यमनाग्रयणमतिथिवर्जितं च । अहुतमवैश्वदेवमविधिना हुतमासप्तमांस्तस्य लोकान्हिनस्ति ॥ १२ ॥",
        hindi = """
            जिसका अग्निहोत्र यज्ञ अमावस्या, पूर्णिमा और चातुर्मास्य के नियमों से रहित है।
            जो अतिथियों के सत्कार से वंचित है और जिसमें सही समय पर आहुति नहीं दी गई।
            जो शास्त्र की विधि के विरुद्ध है, वह कर्ता के सातों लोकों का विनाश कर देता है।
            यज्ञ कोई खेल नहीं है, इसमें की गई लापरवाही बहुत भारी पड़ सकती है।
            शास्त्रोक्त नियमों का पालन करना गुरु के अनुशासन और सत्य के प्रति प्रेम है।
            अतिथि देवो भव—यज्ञ तभी पूर्ण है जब उसमें समाज के प्रति सेवा का भाव हो।
            यह श्लोक कर्मकांडों में होने वाली गलतियों और उनके परिणामों के प्रति सचेत करता है।
            सात लोकों का अर्थ है—तीन पीढ़ियाँ ऊपर, तीन नीचे और स्वयं का अस्तित्व।
            अविधि से किया गया कार्य लाभ की जगह हानि और मानसिक अशांति दे सकता है।
            ईश्वर भाव को देखता है, पर विधि उस भाव को सही दिशा प्रदान करती है।
        """.trimIndent(),
        english = """
            If one's fire-sacrifice lacks the rites of New Moon, Full Moon, or seasons.
            If it is devoid of hospitality to guests or offered at the wrong time.
            If performed contrary to rules, it destroys the person's seven worlds.
            Ritual is not a casual act; negligence in it leads to spiritual decay.
            Following rules signifies respect for discipline and the pursuit of truth.
            Hospitality is an integral part of sacrifice; service to others is vital.
            The verse warns against the mechanical and faulty performance of rites.
            The seven worlds represent the past, present, and future lineages of the doer.
            Action done incorrectly causes mental unrest instead of spiritual gain.
            God looks at the heart, but the method gives that heart a proper direction.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 13,
        sanskrit = "काली कराली च मनोजवा च सुलोहिता या च सुधूम्रवर्णा । स्फुलिङ्गिनी विश्वरुची च देवी लेलायमाना इति सप्त जिह्वाः ॥ १३ ॥",
        hindi = """
            काली, कराली, मनोजवा, सुलोहिता, सुधूम्रवर्णा, स्फुलिङ्गिनी और विश्वरुची।
            ये अग्नि की सात लपटें (जिह्वाएँ) हैं जो अलग-अलग शक्तियों का प्रतीक हैं।
            ये सात नाम चेतना के सात स्तरों और ऊर्जा के सात रूपों को दर्शाते हैं।
            काली का अर्थ है समय, कराली का अर्थ है भयानक शक्ति, मनोजवा यानी मन की गति।
            इन लपटों के माध्यम से ही यज्ञ की आहुति देवताओं तक पहुँचाई जाती है।
            जैसे भोजन के लिए जीभ जरूरी है, वैसे ही यज्ञ के लिए ये लपटें जरूरी हैं।
            यह श्लोक अग्नि के सूक्ष्म और व्यापक स्वरूप का सुंदर वर्णन करता है।
            साधक इन सात शक्तियों के माध्यम से अपने भीतर के विकारों को जलाता है।
            अग्नि केवल विनाश नहीं करती, वह शुद्धिकरण और प्रकाश का भी प्रतीक है।
            इन सात लपटों का दर्शन करना ही ईश्वर के सात रूपों का साक्षात् करना है।
        """.trimIndent(),
        english = """
            Kali, Karali, Manojava, Sulohita, Sudhumravarna, Sphulingini, and Vishvaruchi.
            These are the seven flickering tongues of fire representing different powers.
            They symbolize seven levels of consciousness and seven forms of energy.
            Kali represents Time; Manojava refers to the swiftness of the mind.
            Through these flames, the offerings of the sacrifice reach the deities.
            Just as the tongue is for eating, these flames are for absorbing oblations.
            The verse describes the mystical and expansive nature of the ritual fire.
            A seeker uses these seven powers to burn away his internal impurities.
            Fire is not merely destructive; it is a symbol of purification and light.
            Beholding these seven flames is to witness the seven aspects of the Divine.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 14,
        sanskrit = "एतेषु यश्चरते भ्राजमानेषु यथाकालं चाहुतयो ह्याददायन् । तं नयन्त्येताः सूर्यस्य रश्मयो यत्र देवानां पतिरेकोऽधिवासः ॥ १४ ॥",
        hindi = """
            जो व्यक्ति इन चमकती हुई सात लपटों में सही समय पर आहुति प्रदान करता है।
            वे आहुतियाँ सूर्य की किरणों का रूप लेकर उस यजमान को ऊपर की ओर ले जाती हैं।
            वे उसे उस लोक में ले जाती हैं जहाँ देवताओं का स्वामी (इंद्र) निवास करता है।
            यह कर्मकांड के सुखद और स्वर्गीय फलों का अत्यंत काव्यात्मक वर्णन है।
            यज्ञ की ऊर्जा साधक को भौतिक सीमाओं से उठाकर सूक्ष्म लोकों तक पहुँचाती है।
            सूर्य की किरणें यहाँ ज्ञान और पुण्य के मार्ग का प्रतीक मानी गई हैं।
            स्वर्ग की प्राप्ति उन लोगों के लिए है जो अभी संसार के सुखों की इच्छा रखते हैं।
            यह श्लोक बताता है कि विधिपूर्वक किया गया कार्य कभी भी निष्फल नहीं होता।
            मनुष्य जैसा बीज बोता है, वैसी ही गति उसे मृत्यु के बाद प्राप्त होती है।
            किंतु यह मार्ग अभी भी 'अपरा' है, जो पुनर्जन्म के चक्र से पूरी तरह मुक्त नहीं है।
        """.trimIndent(),
        english = """
            He who performs sacrifices when these seven flames are shining brightly.
            These offerings, as solar rays, lead the performer to the higher worlds.
            They carry him to where the lord of the gods (Indra) dwells in glory.
            This is a poetic description of the pleasant and heavenly fruits of rituals.
            Sacrificial energy lifts the seeker beyond physical limits to subtle realms.
            The rays of the sun symbolize the path of merit and celestial light.
            Attaining heaven is the goal for those still desiring worldly pleasures.
            The verse emphasizes that methodical actions always yield their results.
            As a man sows in this life, so he reaps in the journeys after death.
            However, this path is still within Apara, not yet free from rebirth.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 15,
        sanskrit = "एह्येहीति तमाहुतयः वर्चसः सूर्यस्य रश्मिभिर्यजमानं वहन्ति । प्रियां वाचमभिवदन्त्योऽर्चयन्त्य एष वः पुण्यः सुकृतो ब्रह्मलोकः ॥ १५ ॥",
        hindi = """
            'आओ, आओ'—ऐसा कहती हुई वे चमकदार आहुतियाँ यजमान का स्वागत करती हैं।
            वे सूर्य की किरणों के माध्यम से उसे सम्मानपूर्वक स्वर्ग की ओर ले जाती हैं।
            वे मधुर वाणी में उसकी प्रशंसा करती हैं और उसे उसके पुण्यों का फल दिखाती हैं।
            'यह तुम्हारा कमाया हुआ पुण्यमय ब्रह्मलोक है'—ऐसा वे बार-बार कहती हैं।
            यहाँ 'ब्रह्मलोक' का अर्थ स्वर्ग से है, जहाँ भोग और सुखों की प्रचुरता होती है।
            यह श्लोक धार्मिक कार्यों के मनोवैज्ञानिक और आध्यात्मिक उत्साह को बढ़ाता है।
            अच्छे कार्यों का फल हमेशा मीठा और सम्मानजनक होता है, यही इसका संदेश है।
            किंतु यह सुख भी अस्थायी है, क्योंकि यह कर्मों की पूंजी पर टिका हुआ है।
            उपनिषद यहाँ हमें कर्मों के आकर्षण को दिखाकर आगे के वैराग्य के लिए तैयार कर रहा है।
            जैसे ही पुण्य समाप्त होते हैं, जीव को पुनः इस मर्त्य लोक में लौटना पड़ता है।
        """.trimIndent(),
        english = """
            'Come here, come here,' say the radiant offerings as they welcome him.
            They carry the sacrificer through the sun's rays with great honor.
            They speak pleasing words of praise and show him the fruits of his merit.
            'This is the holy world of Brahma earned by your good deeds,' they say.
            Here, 'Brahmaloka' refers to the lower heaven of abundant pleasures.
            The verse boosts the psychological and spiritual morale of the ritualist.
            The fruit of noble actions is always sweet and honorable for the soul.
            However, this joy is temporary, lasting only as long as the merit lasts.
            The Upanishad depicts this attraction to prepare us for later detachment.
            Once the merit is exhausted, the soul must return to the mortal world.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 16,
        sanskrit = "प्लवा ह्येते अदृढा यज्ञरूपा अष्टादशोक्तमवरं येषु कर्म । एतच्छ्रेयो येऽभिनन्दन्ति मूढा जरामृत्युं ते पुनरेवापि यन्ति ॥ १६ ॥",
        hindi = """
            किंतु ये यज्ञ रूपी नावें अत्यंत कमजोर और अस्थिर हैं, ये पार नहीं लगा सकतीं।
            अठारह प्रकार के यज्ञों में जो कर्म बताए गए हैं, वे ज्ञान की तुलना में निम्न हैं।
            जो मूर्ख लोग इन्हीं कर्मों को ही 'परम कल्याण' मानकर इनमें ही रम जाते हैं।
            वे बार-बार बुढ़ापे और मृत्यु के चक्र में फँसते रहते हैं और कभी मुक्त नहीं होते।
            यहाँ से उपनिषद का स्वर बदलता है और वह कर्मकांड की सीमाओं को उजागर करता है।
            यज्ञ स्वर्ग तो दे सकते हैं, पर आत्मज्ञान और मोक्ष कभी भी नहीं दे सकते।
            कमजोर नाव कभी भी भवसागर के तूफानों को पार करने में सक्षम नहीं होती।
            संसार के सुख चाहे कितने भी ऊँचे हों, वे अंततः दुःख और मृत्यु में ही खत्म होते हैं।
            यह श्लोक साधक को कर्मों के अहंकार से बचकर सत्य की खोज के लिए प्रेरित करता है।
            असली 'श्रेय' (कल्याण) कर्म में नहीं, बल्कि उस अक्षर ब्रह्म के बोध में है।
        """.trimIndent(),
        english = """
            But these sacrifices are frail boats that cannot cross the ocean of life.
            The rituals performed by eighteen people are considered inferior knowledge.
            Those fools who rejoice in them as the highest good are truly deluded.
            They fall repeatedly into the trap of old age and death, never finding rest.
            The tone of the Upanishad shifts here to expose the limits of rituals.
            Rituals can grant heaven but can never provide Self-realization or Moksha.
            A frail boat is insufficient to survive the storms of the worldly ocean.
            No matter how high the worldly joy, it inevitably ends in sorrow and death.
            The verse urges the seeker to move beyond the ego of action toward Truth.
            The real 'Good' (Shreya) lies not in action, but in knowing the Imperishable.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 17,
        sanskrit = "अविद्यायामन्तरे वर्तमानाः स्वयं धीराः पण्डितंमन्यमानाः । जङ्घन्यमानाः परियन्ति मूढा अन्धेनैव नीयमाना यथाऽन्धाः ॥ १७ ॥",
        hindi = """
            अज्ञान के अंधेरे में डूबे हुए लोग स्वयं को बहुत धीर और बुद्धिमान मानते हैं।
            वे खुद को पंडित (विद्वान) समझकर अहंकार में डूबे रहते हैं और दूसरों को सिखाते हैं।
            ऐसे लोग बार-बार दुखों की मार झेलते हुए भटकते रहते हैं और कभी शांत नहीं होते।
            वे ठीक उसी तरह हैं जैसे एक अंधा आदमी दूसरे अंधे का मार्गदर्शन कर रहा हो।
            बिना आत्मज्ञान के दी गई सलाह केवल भटकाव और अंधकार को ही बढ़ाती है।
            अहंकार ही वह पर्दा है जो हमें अपनी कमियों को देखने से पूरी तरह रोकता है।
            यह श्लोक उन लोगों पर प्रहार करता है जो केवल किताबी ज्ञान को ही सत्य मान लेते हैं।
            सत्य का मार्ग विनम्रता से शुरू होता है, न कि 'मैं सब जानता हूँ' के भाव से।
            जब गुरु और शिष्य दोनों अंधे हों, तो वे कभी भी प्रकाश तक नहीं पहुँच सकते।
            यह हमें एक जाग्रत और आत्मज्ञानी गुरु को खोजने की महत्ता को गहराई से समझाता है।
        """.trimIndent(),
        english = """
            Dwelling in the darkness of ignorance, they consider themselves wise.
            Thinking they are scholars, they are puffed up with pride and teach others.
            Such fools wander about, suffering greatly and never finding true peace.
            They are like the blind being led by the blind toward a deep pit.
            Advice given without Self-knowledge only increases confusion and darkness.
            Ego is the veil that prevents one from recognizing their own limitations.
            The verse attacks those who mistake mere intellectual data for the Truth.
            The path to Truth begins with humility, not with the thought 'I know it all'.
            When both the guide and the follower are blind, they never reach the light.
            It emphasizes the absolute necessity of finding an enlightened Master.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 18,
        sanskrit = "अविद्यायां बहुधा वर्तमाना वयं कृतार्था इत्यभिमन्यन्ति बालाः । यत्कर्मिणो न प्रवेदयन्ति रागात्तेनातुराः क्षीणलोकाश्चयवन्ते ॥ १८ ॥",
        hindi = """
            अज्ञान के अनेक रूपों में उलझे हुए नासमझ लोग सोचते हैं कि 'हम कृतार्थ हो गए'।
            वे सांसारिक सफलताओं को ही जीवन का अंतिम लक्ष्य मानकर गर्व करने लगते हैं।
            क्योंकि वे केवल कर्मों में आसक्त हैं, इसलिए वे सत्य को कभी पहचान नहीं पाते।
            जैसे ही उनके पुण्यों का फल समाप्त होता है, वे दुखी होकर स्वर्ग से नीचे गिर जाते हैं।
            कर्म का नशा व्यक्ति को सत्य की आवाज़ सुनने से पूरी तरह रोक देता है।
            आसक्ति (Attachment) ही वह जंजीर है जो आत्मा को पुनर्जन्म से बाँधे रखती है।
            स्वर्ग स्थायी घर नहीं है, वह केवल एक शानदार 'किराये का कमरा' मात्र है।
            जो लोग केवल सुख चाहते हैं, वे अंततः पीड़ा और वियोग के लिए ही तैयार होते हैं।
            यह श्लोक कर्मों के प्रति अत्यधिक आसक्ति के खतरों के बारे में सचेत करता है।
            असली तृप्ति केवल ब्रह्म के अनुभव में है, किसी अस्थायी स्वर्ग के भोग में नहीं।
        """.trimIndent(),
        english = """
            Engrossed in various forms of ignorance, the immature think 'We have succeeded'.
            They take pride in worldly achievements as if they were the final goal.
            Because they are attached to action, they never perceive the deeper Truth.
            As soon as their merits are exhausted, they fall back from heaven in misery.
            The intoxication of action prevents one from hearing the voice of Truth.
            Attachment is the chain that binds the soul to the cycle of rebirth.
            Heaven is not a permanent home; it is merely a grand 'rented room'.
            Those who only seek pleasure inevitably prepare themselves for pain.
            The verse warns against the dangers of excessive attachment to rituals.
            Real fulfillment is in the experience of Brahman, not in transient joys.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 19,
        sanskrit = "इष्टापूर्तं मन्यमाना वरिष्ठं नान्यच्छ्रेयो वेदयन्ते प्रमूढाः । नाकस्य पृष्ठे ते सुकृतेऽनुभूत्वेमं लोकं हीनतरं वा विशन्ति ॥ १९ ॥",
        hindi = """
            यज्ञ और समाज सेवा (इष्टापूर्त) को ही जो मूर्ख सर्वश्रेष्ठ मान लेते हैं।
            वे इसके अलावा किसी अन्य कल्याणकारी मार्ग (आत्मज्ञान) को नहीं जानते।
            वे स्वर्ग के शिखर पर अपने पुण्यों का अनुभव करने के बाद पुनः नीचे आते हैं।
            वे इस मनुष्य लोक में या इससे भी निम्न योनियों में विवश होकर प्रवेश करते हैं।
            भलाई करना अच्छा है, पर भलाई को ही अंतिम सत्य मान लेना अज्ञानता है।
            बिना विवेक के किया गया पुण्य भी हमें संसार के चक्र से मुक्त नहीं कर सकता।
            स्वर्ग के सुख भी इंद्रियों के ही सुख हैं, जो कभी भी स्थायी नहीं हो सकते।
            यह श्लोक परोपकार और धार्मिकता के भी अहंकार के प्रति हमें सावधान करता है।
            मुक्ति का मार्ग कर्मों से नहीं, बल्कि कर्मों के कर्ता (आत्मा) को जानने से है।
            जो केवल बाहर सुधार करते हैं और भीतर नहीं झाँकते, वे भटकते ही रहते हैं।
        """.trimIndent(),
        english = """
            Thinking rituals and charity to be the highest, the deluded know no better.
            They are unaware of any other beneficial path like the path of wisdom.
            Having enjoyed the fruits of their merit on the heights of heaven, they return.
            They enter this human world or even lower births as dictated by their karma.
            Doing good is noble, but mistaking it for the absolute Truth is ignorance.
            Merit performed without discernment cannot free us from the cosmic cycle.
            Even heavenly joys are sensory and thus can never be truly eternal.
            The verse warns against the ego that often accompanies charity and piety.
            The path to freedom is not through action, but through knowing the Actor.
            Those who only fix the outside and never look within remain in bondage.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 20,
        sanskrit = "तपःश्रद्धे ये ह्युपवसन्त्यरण्ये शान्ता विद्वांसो भैक्षचर्यां चरन्तः । सूर्यद्वारेण ते विरजाः प्रयान्ति यत्रामृतः स पुरुषो ह्यव्ययात्मा ॥ २० ॥",
        hindi = """
            किंतु जो शांत और विद्वान पुरुष वन में रहकर तप और श्रद्धा का पालन करते हैं।
            जो भिक्षा मांगकर जीवन यापन करते हैं और अपनी इंद्रियों को पूरी तरह जीत चुके हैं।
            वे निर्मल होकर 'सूर्य-द्वार' से उस स्थान पर जाते हैं जहाँ वह अविनाशी पुरुष रहता है।
            यही वह मार्ग है जो कभी वापस नहीं लाता, यही वह परम शांति का स्थान है।
            सन्यास और वैराग्य ही वह नाव है जो भवसागर के उस पार सुरक्षित ले जाती है।
            यहाँ 'भिक्षा' का अर्थ है अहंकार का पूर्ण त्याग और ईश्वर पर पूर्ण निर्भरता।
            सूर्य-द्वार ज्ञान के उस मार्ग को दर्शाता है जो चेतना को उच्चतम स्तर पर ले जाता है।
            जो सांसारिक इच्छाओं से 'विरज' (रजोगुण रहित) हो गए हैं, वही वहाँ पहुँच सकते हैं।
            यह श्लोक कर्मकांड के मार्ग और ज्ञान के मार्ग के बीच का अंतिम चुनाव बताता है।
            अविनाशी पुरुष ही वह अंतिम विश्राम है जिसे पाने के बाद कुछ पाना शेष नहीं रहता।
        """.trimIndent(),
        english = """
            But those calm and wise ones who practice penance and faith in the forest.
            Living on alms and having mastered their senses, they become pure.
            They depart through the 'Gate of the Sun' to where the Immortal Person dwells.
            This is the path of no return, the abode of absolute and eternal peace.
            Renunciation and detachment are the boats that cross the worldly ocean safely.
            'Living on alms' signifies the total destruction of ego and reliance on the Divine.
            The Gate of the Sun represents the path of wisdom leading to high consciousness.
            Only those who have become 'Viraja' (free from passion) can reach there.
            The verse presents the final choice between the path of action and wisdom.
            The Imperishable Person is the final rest; attaining Him, nothing remains.
        """.trimIndent()
    ),
    // ... Continuing mundakaShlokasList from ID 21

    MundakaShloka(
        id = 21,
        sanskrit = "परीक्ष्य लोकान् कर्मचितान् ब्राह्मणो निर्वेदमायान्नास्त्यकृतः कृतेन । तद्विज्ञानार्थं स गुरुमेवाभिगच्छेत् समित्पाणिः श्रोत्रियं ब्रह्मनिष्ठम् ॥ २१ ॥",
        hindi = """
            कर्मों द्वारा प्राप्त होने वाले लोकों की परीक्षा करके साधक को वैराग्य प्राप्त करना चाहिए।
            वह समझता है कि कर्मों (कृत) से वह अविनाशी (अकृत) मोक्ष प्राप्त नहीं किया जा सकता।
            संसार के सभी सुख विनाशी हैं, जबकि आत्मा का आनंद शाश्वत और कभी न खत्म होने वाला है।
            उस परम सत्य को जानने के लिए साधक को एक योग्य गुरु की शरण में अवश्य जाना चाहिए।
            हाथों में समिधा लेकर गुरु के पास जाना विनम्रता और सेवा भाव का साक्षात् प्रतीक है।
            गुरु को 'श्रोत्रिय' (वेदों का ज्ञाता) और 'ब्रह्मनिष्ठ' (ब्रह्म में स्थित) होना अनिवार्य है।
            बिना गुरु के निर्देशन के, आध्यात्मिक मार्ग की सूक्ष्मताओं को समझना लगभग असंभव है।
            यह श्लोक कर्मकांड से ज्ञान मार्ग की ओर मुड़ने का सबसे महत्वपूर्ण मोड़ माना जाता है।
            केवल बुद्धि से नहीं, बल्कि श्रद्धा और समर्पण से ही सत्य का मार्ग प्रशस्त होता है।
            वैराग्य ही वह नींव है जिस पर ब्रह्मविद्या का भव्य महल मजबूती से खड़ा होता है।
        """.trimIndent(),
        english = """
            Having examined the worlds gained by actions, a seeker should arrive at detachment.
            He realizes that the Eternal (Uncreated) cannot be attained through transient deeds.
            All worldly rewards are finite, whereas the joy of the Self is infinite and absolute.
            To understand that Supreme Reality, one must approach a Guru with great humility.
            Carrying sacrificial fuel (Samidha) signifies a readiness to serve and to learn.
            The Guru must be 'Shrotriya' (versed in scriptures) and 'Brahmanishtha' (rooted in Brahman).
            Without a master's guidance, the subtle nuances of the spiritual path remain hidden.
            This verse marks the critical transition from ritualistic action to the path of wisdom.
            Truth is attained not just through intellect, but through faith and total surrender.
            Detachment is the foundation upon which the grand palace of Brahmavidya is built.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 22,
        sanskrit = "तस्मै स विद्वानुपसन्नाय सम्यक् प्रशान्तचित्ताय शमान्विताय । येनाक्षरं पुरुषं वेद सत्यं प्रोवाच तां तत्त्वतो ब्रह्मविद्याम् ॥ २२ ॥",
        hindi = """
            जब शांत चित्त और इंद्रियों को वश में रखने वाला शिष्य गुरु के पास पहुँचता है।
            तब वह विद्वान गुरु उसे पूर्ण सत्य और ब्रह्मविद्या का यथार्थ उपदेश प्रदान करते हैं।
            जिस विद्या के माध्यम से उस अविनाशी (अक्षर) सत्य पुरुष को पूरी तरह जाना जा सके।
            गुरु का कर्तव्य है कि वे सुपात्र शिष्य को सत्य का मार्ग बिना किसी संकोच के दिखाएं।
            शिष्य की शांति और उसका संयम ही ज्ञान ग्रहण करने की असली पात्रता मानी गई है।
            यह श्लोक प्रथम मुण्डक (अध्याय) के दूसरे खंड का अंतिम और निष्कर्ष श्लोक है।
            ब्रह्मविद्या केवल शब्दों का जाल नहीं, बल्कि सत्य का जीवंत और प्रत्यक्ष अनुभव है।
            गुरु की करुणा और शिष्य की व्याकुलता मिलकर ही आध्यात्मिक क्रांति को जन्म देती है।
            सत्य को तत्वों (सिद्धांतों) के साथ समझना ही भ्रांतियों को दूर करने का एकमात्र तरीका है।
            यहाँ से साधक की यात्रा बाहरी कर्मों से मुड़कर आंतरिक प्रकाश की ओर बढ़ जाती है।
        """.trimIndent(),
        english = """
            When a disciple with a tranquil mind and controlled senses approaches the Master.
            The enlightened Guru imparts to him the true knowledge of the Supreme Brahman.
            It is that wisdom through which the Imperishable (Akshara) Reality is realized.
            It is the sacred duty of the Master to show the path of Truth to a deserving student.
            The student's inner peace and self-discipline are the prerequisites for higher learning.
            This verse serves as the concluding statement of the second section of the first Mundaka.
            Brahmavidya is not a mere play of words but a living, direct experience of the Truth.
            The compassion of the Guru and the yearning of the seeker create a spiritual revolution.
            Understanding Truth through its core principles is the only way to dispel all illusions.
            From here, the seeker's journey shifts from external acts to internal illumination.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 23,
        sanskrit = "तदेतत्सत्यं यथा सुदीप्तात्पावकाद्विस्फुलिङ्गाः सहस्रशः प्रभवन्ते सरूपाः । तथाक्षराद्विविधाः सोम्य भावाः प्रजायन्ते तत्र चैवापि यन्ति ॥ २३ ॥",
        hindi = """
            यह परम सत्य है: जिस प्रकार प्रज्वलित अग्नि से हजारों चिंगारियाँ उत्पन्न होती हैं।
            वे सभी चिंगारियाँ स्वरूप में अपनी मूल अग्नि के समान ही देदीप्यमान होती हैं।
            हे सोम्य! उसी प्रकार उस अविनाशी अक्षर से अनेक प्रकार के भाव (जीव) उत्पन्न होते हैं।
            और अंत में वे सभी जीव वापस उसी परमात्मा में विलीन होकर एक हो जाते हैं।
            अग्नि और चिंगारी का यह उदाहरण जीव और ब्रह्म की एकता को बखूबी समझाता है।
            सृष्टि के सभी प्राणी परमात्मा का ही अंश हैं, उनका अपना कोई अलग अस्तित्व नहीं।
            जैसे चिंगारी अग्नि से अलग नहीं रह सकती, वैसे ही हम ईश्वर से अलग नहीं रह सकते।
            विविधता केवल ऊपरी है, आंतरिक रूप से हम सब उस एक ही महाप्रकाश का रूप हैं।
            यह श्लोक द्वितीय मुण्डक के प्रथम खंड का आरंभ है जो सृष्टि का रहस्य खोलता है।
            अपनी वास्तविकता को पहचानना ही संसार के सभी बंधनों से मुक्त होने की कुंजी है।
        """.trimIndent(),
        english = """
            This is the Truth: as from a blazing fire thousands of fiery sparks fly forth.
            These sparks are of the same nature and essence as the original source of fire.
            O dear one! In the same way, various beings emerge from the Imperishable Brahman.
            And ultimately, they all return and merge back into that very same Supreme Being.
            The metaphor of fire and sparks perfectly illustrates the unity of Soul and God.
            All living beings are fragments of the Divine; they have no independent existence.
            Just as a spark cannot exist without fire, we cannot exist without the Divine.
            Diversity is only superficial; internally, we are all reflections of the same Light.
            This verse begins the first section of the second Mundaka, revealing cosmic secrets.
            Recognizing one's true reality is the key to liberation from all worldly bonds.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 24,
        sanskrit = "दिव्यो ह्यमूर्तः पुरुषः सबाह्याभ्यन्तरो ह्यजः । अप्राणो ह्यमनाः शुभ्रो ह्यक्षरात्परतः परः ॥ २४ ॥",
        hindi = """
            वह दिव्य पुरुष (परमात्मा) निराकार है और वह बाहर तथा भीतर सब जगह व्याप्त है।
            वह अजन्मा (अजः) है, क्योंकि उसका न कोई आदि है और न ही कोई अंत हो सकता है।
            वह प्राणों से रहित और मन से भी परे है, क्योंकि वह स्वयं शुद्ध और प्रकाशमान है।
            वह उस अक्षर (प्रकृति) से भी श्रेष्ठ है, जो स्वयं बहुत ही सूक्ष्म और अविनाशी है।
            परमात्मा को किसी भी भौतिक अंग या मानसिक प्रक्रिया की आवश्यकता नहीं होती है।
            वह निर्विकार है, यानी उसमें कभी कोई परिवर्तन या सुधार की गुंजाइश नहीं होती।
            शुद्धता ही उसका स्वभाव है, और प्रकाश ही उसका असली और शाश्वत परिचय है।
            वह चेतना का वह उच्चतम स्तर है जहाँ पहुँचकर सभी द्वैत और भेद समाप्त हो जाते हैं।
            यह श्लोक ब्रह्म की निरपेक्ष (Absolute) और अलौकिक स्थिति का वर्णन करता है।
            उसे जानने का अर्थ है अपनी सभी मानसिक और शारीरिक सीमाओं को पूरी तरह लांघ जाना।
        """.trimIndent(),
        english = """
            That Divine Person is formless and He pervades both the outside and the inside.
            He is unborn (Ajah), for He has no beginning and can have no ultimate end.
            He is without vital breath and beyond the mind, being pure and self-luminous.
            He is superior even to the Imperishable Nature (Prakriti), which is itself subtle.
            The Supreme Reality does not require any physical organs or mental processes.
            He is immutable, meaning there is never any room for change or modification.
            Purity is His very essence, and Light is His true and eternal manifestation.
            He represents the highest level of consciousness where all dualities and splits end.
            This verse describes the absolute and transcendental state of the Brahman.
            To know Him is to completely transcend all one's mental and physical limitations.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 25,
        sanskrit = "एतस्माज्जायते प्राणो मनः सर्वेन्द्रियाणि च । खं वायुर्ज्योतिरापः पृथिवी विश्वस्य धारिणी ॥ २५ ॥",
        hindi = """
            उसी परम पुरुष से प्राण, मन और सभी ज्ञानेंद्रियों तथा कर्मेंद्रियों की उत्पत्ति होती है।
            आकाश (खं), वायु, अग्नि (ज्योति), जल और संपूर्ण विश्व को धारण करने वाली पृथ्वी।
            यह संपूर्ण भौतिक और मानसिक जगत उसी एक केंद्र से विकसित और प्रकट हुआ है।
            विज्ञान जिसे तत्व कहता है, उपनिषद उन्हें परमात्मा की अभिव्यक्ति मानता है।
            पंचभूतों का निर्माण आकस्मिक नहीं, बल्कि एक सुनियोजित और दिव्य प्रक्रिया है।
            हमारा शरीर और यह ब्रह्मांड एक ही रसायनों और ऊर्जा से मिलकर बने हुए हैं।
            प्राण वह ऊर्जा है जो जड़ पदार्थ में जीवन का संचार कर उसे सक्रिय बनाती है।
            मन वह यंत्र है जिससे हम उस परम चेतना के खेल को समझने का प्रयास करते हैं।
            यह श्लोक सृष्टि की रचना के वैज्ञानिक क्रम (Evolutionary Order) को दर्शाता है।
            परमात्मा ही वह बीज है जिससे प्रकृति का यह विशाल वृक्ष फल-फूल रहा है।
        """.trimIndent(),
        english = """
            From Him are born the vital breath, the mind, and all the organs of perception.
            From Him come space, air, fire, water, and the earth that supports the universe.
            This entire physical and mental world evolved and emerged from that one Center.
            What science calls elements, the Upanishads view as manifestations of the Divine.
            The creation of the five elements is not accidental but a planned, divine process.
            Our body and the cosmos are composed of the same chemicals and energy.
            Prana is the energy that infuses life into inert matter and makes it active.
            The mind is the instrument through which we try to understand the Divine play.
            This verse illustrates the scientific and evolutionary order of the creation.
            The Supreme Being is the seed from which this vast tree of nature flourishes.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 26,
        sanskrit = "अग्निर्मूर्धा चक्षुषी चन्द्रसूर्यौ दिशः श्रोत्रे वाग्विवृताश्च वेदाः । वायुः प्राणो हृदयं विश्वमस्य पद्भ्यां पृथिवी ह्येष सर्वभूतान्तरात्मा ॥ २६ ॥",
        hindi = """
            अग्नि (स्वर्ग) जिसका मस्तक है, चन्द्र और सूर्य जिसकी दोनों आँखें मानी गई हैं।
            दिशाएं जिसके कान हैं और चारों वेद जिसकी खुली हुई वाणी (शब्द) के समान हैं।
            वायु जिसका प्राण है और यह संपूर्ण विश्व जिसका विशाल हृदय स्थल है।
            जिसके पैरों से पृथ्वी उत्पन्न हुई है, वही समस्त प्राणियों का अंतरात्मा है।
            यह श्लोक परमात्मा के 'विश्वरूप' (Cosmic Form) का अत्यंत भव्य वर्णन करता है।
            पूरा ब्रह्मांड एक ही विशाल जीव (Cosmic Being) की तरह कार्य कर रहा है।
            प्रकृति का कोई भी हिस्सा ईश्वर से अलग नहीं है, वह सबमें पूरी तरह समाया है।
            हम जिसे निर्जीव ब्रह्मांड कहते हैं, वह वास्तव में एक चेतन शरीर के समान है।
            आंतरिक रूप से वही शक्ति हमारे भीतर भी है जो नक्षत्रों को चला रही है।
            यह दर्शन हमें प्रकृति के प्रति सम्मान और एकता का भाव रखने की शिक्षा देता है।
        """.trimIndent(),
        english = """
            Fire is His head, the sun and moon are His eyes, and the quarters are His ears.
            The revealed Vedas are His speech, the air is His breath, and the world His heart.
            The earth has originated from His feet; He is indeed the inner Self of all beings.
            This verse provides a magnificent description of the 'Vishvarupa' (Cosmic Form).
            The entire universe functions like a single, massive Cosmic Being.
            No part of nature is separate from God; He is fully permeated in everything.
            What we call the inanimate universe is actually like a conscious body.
            Internally, the same power resides within us that drives the stars and galaxies.
            This philosophy teaches us to hold respect and a sense of unity toward nature.
            Recognizing the macrocosm within the microcosm is the essence of this wisdom.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 27,
        sanskrit = "तस्मादग्निः समिधो यस्य सूर्यः सोमात्पर्जन्य ओषधयः पृथिव्याम् । पुमान्रेतः सिञ्चति योषित्यायां बह्वीः प्रजाः पुरुषात्सम्प्रसूताः ॥ २७ ॥",
        hindi = """
            उसी पुरुष से अग्नि (स्वर्ग) उत्पन्न हुई, जिसका मुख्य ईंधन स्वयं सूर्य है।
            सोम (चंद्रमा) से वर्षा (पर्जन्य) होती है और वर्षा से पृथ्वी पर औषधियाँ उगती हैं।
            पुरुष स्त्री में वीर्य का सिंचन करता है और इस प्रकार अनेक प्रजाएँ उत्पन्न होती हैं।
            यह श्लोक सृष्टि की निरंतरता और जीवन चक्र (Life Cycle) की व्याख्या करता है।
            आकाशीय पिंडों और पृथ्वी के बीच एक गहरा ऊर्जात्मक संबंध (Energy link) है।
            भोजन, वर्षा और प्रजनन—ये सब उसी एक ईश्वरीय योजना के अलग-अलग चरण हैं।
            जीवन का हर स्तर दूसरे पर आश्रित है और सबका मूल आधार वह परमात्मा ही है।
            यह दर्शाता है कि जैव-विविधता (Biodiversity) वास्तव में एक महान चेतना का ही विस्तार है।
            सृष्टि की हर हलचल उस परम पुरुष की उपस्थिति का ही एक जीवंत प्रमाण है।
            हम सब उस एक ही स्रोत से निकले हैं और उसी की ऊर्जा से पोषित हो रहे हैं।
        """.trimIndent(),
        english = """
            From Him comes the fire (heaven), whose fuel is the sun; from the moon, the rain.
            From the rain, herbs grow on earth, and the male pours seed into the female.
            Thus, many creatures are produced from the Supreme Person in an endless cycle.
            This verse explains the continuity of creation and the intricate cycle of life.
            There is a deep energetic link between celestial bodies and the planet Earth.
            Food, rain, and reproduction are various stages of a single divine plan.
            Every level of life depends on another, and the root foundation is the Divine.
            It shows that biodiversity is actually an expansion of one great consciousness.
            Every movement in the creation is a living proof of that Supreme Person's presence.
            We have all emerged from the same source and are nourished by His energy.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 28,
        sanskrit = "तस्मादृचः साम यजूंषि दीक्षा यज्ञाश्च सर्वे क्रतवो दक्षिणाश्च । संवत्सरश्च यजमानश्च लोकाः सोमो यत्र पवते यत्र सूर्यः ॥ २८ ॥",
        hindi = """
            उसी परमात्मा से ऋग्वेद, सामवेद, यजुर्वेद, दीक्षा और सभी यज्ञ उत्पन्न हुए हैं।
            सभी अनुष्ठान, दक्षिणा, संवत्सर (समय), यजमान और वे सभी लोक जहाँ जीव जाते हैं।
            वे लोक जहाँ चंद्रमा और सूर्य निरंतर अपनी किरणों से प्रकाश फैला रहे हैं।
            सांस्कृतिक और आध्यात्मिक परंपराओं का आधार भी वह ईश्वर ही माना गया है।
            यज्ञ की पवित्रता और समय की गति—सब उसी के शासन में सुचारू रूप से चलते हैं।
            ज्ञान के ग्रंथ और कर्म के विधान उसी एक चेतना से ऋषि-हृदयों में प्रकट हुए।
            यह श्लोक धर्म और विज्ञान के समन्वय को बहुत ही खूबसूरती से प्रस्तुत करता है।
            सृष्टि का कोई भी मानवीय या दैवीय कार्य ईश्वर की सत्ता के बिना संभव नहीं है।
            समय (संवत्सर) ही वह रंगमंच है जिस पर हम अपने कर्मों का खेल खेलते हैं।
            परमात्मा ही वह परम प्रकाश है जो सूर्य और चंद्रमा को भी चमक प्रदान करता है।
        """.trimIndent(),
        english = """
            From Him are born the Rik, the Saman, the Yajus, initiations, and all sacrifices.
            All rituals, gifts, the year (time), the sacrificer, and all the worlds.
            Those worlds where the moon purifies and where the sun shines perpetually.
            The Divine is considered the very basis of all cultural and spiritual traditions.
            The sanctity of sacrifice and the flow of time operate under His governance.
            Scriptures of wisdom and laws of action emerged from that one Consciousness.
            This verse beautifully presents the harmony between religion and cosmic science.
            No human or divine act in creation is possible without the existence of God.
            Time (Samvatsara) is the stage upon which we play out the drama of our karma.
            The Supreme Being is the ultimate light that grants brilliance to the sun and moon.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 29,
        sanskrit = "तस्माच्च देवा बहुधा सम्प्रसूताः साध्या मनुष्याः पशवो वयांसि । प्राणापानौ व्रीहियवौ तपश्च श्रद्धा सत्यं ब्रह्मचर्यं विधिश्च ॥ २९ ॥",
        hindi = """
            उसी से अनेक प्रकार के देवता, साध्य, मनुष्य, पशु और पक्षी उत्पन्न हुए हैं।
            प्राण और अपान, अन्न (धान और जौ), तप, श्रद्धा, सत्य, ब्रह्मचर्य और विधि।
            यह श्लोक जीवन के भौतिक, जैविक और नैतिक—तीनों पहलुओं को शामिल करता है।
            देवता सूक्ष्म शक्तियों के प्रतीक हैं, जबकि पशु-पक्षी स्थूल जगत के अंग हैं।
            नैतिक मूल्य जैसे सत्य और ब्रह्मचर्य भी परमात्मा की ही मानसिक रचना हैं।
            बिना विधि और अनुशासन के यह संसार एक पल भी टिक नहीं सकता है।
            प्राण और अपान वे दो मुख्य ऊर्जाएं हैं जो शरीर को जीवित और सक्रिय रखती हैं।
            श्रद्धा और तप ही वे साधन हैं जिनसे मनुष्य अपनी चेतना को ऊँचा उठाता है।
            सृष्टि की हर विविधता उस एक ही महान चित्रकार की अद्भुत पेंटिंग के समान है।
            यह श्लोक सिद्ध करता है कि हमारा अस्तित्व केवल हाड़-मांस नहीं, बल्कि दिव्य है।
        """.trimIndent(),
        english = """
            From Him, many gods, celestial beings, men, beasts, and birds are produced.
            From Him come Prana and Apana, grains like rice and barley, and austerity.
            Faith, truth, celibacy, and law—all have emerged from that same Source.
            This verse covers the physical, biological, and ethical aspects of life.
            Gods symbolize subtle forces, while beasts and birds represent the gross world.
            Ethical values like truth and celibacy are also mental creations of the Divine.
            Without law and discipline, this world could not sustain itself for a moment.
            Prana and Apana are the two primary energies that keep the body alive and active.
            Faith and austerity are the means by which humans elevate their consciousness.
            Every diversity in creation is like a masterpiece by the one great Painter.
            This shloka proves that our existence is not just flesh and bone, but divine.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 30,
        sanskrit = "सप्त प्राणाः प्रभवन्ति तस्मात्सप्तार्चिषः समिधः सप्त होमाः । सप्त इमे लोका येषु चरन्ति प्राणा गुहाशया निहिताः सप्त सप्त ॥ ३० ॥",
        hindi = """
            उसी से सात प्राण (इंद्रियां), सात लपटें, सात समिधा और सात होम उत्पन्न होते हैं।
            ये सात लोक जिनमें प्राण विचरण करते हैं, वे सब उसी के द्वारा स्थापित किए गए हैं।
            हृदय की गुफा में रहने वाले ये सात-सात प्राण हर जीव में पूरी तरह स्थित हैं।
            सात प्राणों का अर्थ है—दो आँखें, दो कान, दो नासिका छिद्र और एक मुख।
            इनके द्वारा हम बाहरी दुनिया के अनुभवों की आहुति अपने भीतर ग्रहण करते हैं।
            यज्ञ केवल बाहर नहीं होता, हमारे शरीर के भीतर भी निरंतर एक यज्ञ चल रहा है।
            इंद्रियां ही वे लपटें हैं जिनसे हम ज्ञान और विषयों को जलाकर अनुभव प्राप्त करते हैं।
            परमात्मा ने ही यह जटिल और सूक्ष्म प्रणाली (System) हमारे भीतर फिट की है।
            हमारा पूरा जीवन एक आध्यात्मिक अनुष्ठान है जहाँ हम हर पल कुछ सीख रहे हैं।
            यह श्लोक मानव शरीर को एक दिव्य और जीवित मंदिर के रूप में प्रस्तुत करता है।
        """.trimIndent(),
        english = """
            From Him originate the seven life-breaths (senses), the seven flames, and fuels.
            The seven oblations and the seven worlds where the breaths move are His creation.
            These seven-seven breaths, seated in the cave of the heart, are placed in all.
            The seven breaths refer to the two eyes, two ears, two nostrils, and one mouth.
            Through these, we ingest the offerings of external world experiences into us.
            Sacrifice does not only happen outside; a ritual is constantly ongoing within us.
            The senses are the flames through which we burn knowledge and objects for experience.
            The Divine alone has fitted this complex and subtle system within our being.
            Our entire life is a spiritual rite where we are learning something every moment.
            This verse presents the human body as a divine and living temple of God.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 31,
        sanskrit = "अतः समुद्रा गिरयश्च सर्वे तस्मात्स्यन्दन्ते सिन्धवः सर्वरूपाः । अतश्च सर्वा ओषधयो रसश्च येनैष भूतैस्तिष्ठते ह्यन्तरात्मा ॥ ३१ ॥",
        hindi = """
            उसी से सभी समुद्र और पर्वत उत्पन्न हुए हैं, और उसी से नदियाँ प्रवाहित होती हैं।
            सभी प्रकार की औषधियाँ और वह रस (तरल) भी उसी से है जो जीवन का आधार है।
            वही अंतरात्मा है जो पंचभूतों के साथ शरीर के भीतर पूरी तरह व्याप्त है।
            प्रकृति की विशालता—ऊँचे पहाड़ और गहरा समुद्र—ईश्वर की ही भव्यता है।
            नदियों का बहना और पौधों में रस का होना, उस अदृश्य शक्ति का ही प्रमाण है।
            परमात्मा केवल दूर आकाश में नहीं है, वह हमारे खून और प्राणों के रस में भी है।
            वह सूक्ष्म धागा है जिसने पृथ्वी के सभी तत्वों को एक साथ पिरोया हुआ है।
            बिना उस आंतरिक 'रस' के, शरीर जड़ और निर्जीव मिट्टी के समान रह जाएगा।
            यह श्लोक ईश्वर की सर्वव्यापकता (Omnipresence) को बहुत ही सरलता से समझाता है।
            हम जो कुछ भी देखते, पीते या महसूस करते हैं, वह सब उसी परम चेतना का अंश है।
        """.trimIndent(),
        english = """
            From Him come all the oceans and mountains; from Him flow the rivers of all forms.
            From Him come all the herbs and the sap (Rasah) that sustains the living body.
            He is the inner Self that dwells within, surrounded by the physical elements.
            The vastness of nature—high mountains and deep oceans—is the glory of God.
            The flowing of rivers and the presence of sap in plants prove that invisible power.
            The Divine is not just in the distant sky; He is in our blood and vital fluids.
            He is the subtle thread that has strung together all the elements of the earth.
            Without that internal 'Sap', the body would remain like inert and lifeless clay.
            This verse explains the omnipresence of God in a very simple and direct manner.
            Everything we see, drink, or feel is a fragment of that Supreme Consciousness.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 32,
        sanskrit = "पुरुष एवेदं विश्वं कर्म तपो ब्रह्म परामृतम् । एतद्यो वेद निहितं गुहायां सोऽविद्याग्रन्थिं विकिरतीह सोम्य ॥ ३२ ॥",
        hindi = """
            यह संपूर्ण विश्व, कर्म और तप वास्तव में वह परम अमृत ब्रह्म 'पुरुष' ही है।
            हे सोम्य! जो मनुष्य अपने हृदय की गुफा में छिपे इस सत्य को पूरी तरह जान लेता है।
            वह इसी जीवन में अविद्या (अज्ञान) की गाँठ को हमेशा के लिए काटकर मुक्त हो जाता है।
            अज्ञान की गाँठ ही वह भ्रम है जो हमें ईश्वर से अलग और सीमित महसूस कराती है।
            जब हम जान लेते हैं कि सब कुछ ब्रह्म है, तब डर और मोह पूरी तरह समाप्त हो जाते हैं।
            यह श्लोक द्वितीय मुण्डक के प्रथम खंड का अंतिम और अत्यंत शक्तिशाली संदेश है।
            सत्य को केवल बाहर नहीं, बल्कि अपने ही भीतर खोजना ही असली बुद्धिमानी है।
            अविद्या का नाश होना ही मोक्ष है, और यह इसी शरीर में रहते हुए संभव है।
            ब्रह्म को जानना ही स्वयं ब्रह्म हो जाना है, जहाँ कोई द्वैत शेष नहीं रहता।
            यह ज्ञान मनुष्य को उसके असली, आनंदमयी और अविनाशी स्वरूप से मिला देता है।
        """.trimIndent(),
        english = """
            The Supreme Person is indeed this entire universe, action, austerity, and nectar.
            O dear one! He who knows this Truth hidden in the cave of his own heart.
            He cuts asunder the knot of ignorance (Avidya) even while living here on earth.
            The knot of ignorance is the delusion that makes us feel separate and limited.
            When we realize that everything is Brahman, fear and attachment vanish completely.
            This verse is the final and extremely powerful message of the first section, second Mundaka.
            Seeking Truth not just outside but within oneself is the sign of true wisdom.
            The destruction of ignorance is liberation, and it is possible in this very life.
            To know Brahman is to become Brahman, where no duality remains whatsoever.
            This wisdom reunites man with his original, blissful, and indestructible nature.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 33,
        sanskrit = "आविः संनिहितं गुहाचरं नाम महत्पदमत्रैतत् समर्पितम् । एजत्प्राणन्निमिषच्च यदेतज्जानथ सदसद्वरेण्यं परं विज्ञानाद्यद्वरिष्ठं प्रजानाम् ॥ ३३ ॥",
        hindi = """
            वह प्रकाशमान, समीप स्थित और हृदय-गुफा में रहने वाला ही महान पद (लक्ष्य) है।
            जो कुछ भी हिलता है, सांस लेता है और पलकें झपकाता है, सब उसी में समर्पित है।
            उसे जानो, जो सत् (स्थूल) और असत् (सूक्ष्म) दोनों है और जो सबसे अधिक वरेण्य है।
            वह मनुष्यों के सामान्य विज्ञान (बुद्धि) से भी परे और प्रजाओं में सबसे श्रेष्ठ है।
            यह श्लोक ईश्वर की महानता और उसकी सूक्ष्मता के बीच के संतुलन को दिखाता है।
            वह हर छोटी-से-छोटी जैविक क्रिया का आधार और ब्रह्मांड का सबसे बड़ा सत्य है।
            हमारी बुद्धि उसे पकड़ने की कोशिश करती है, पर वह बुद्धि का भी प्रकाशक है।
            'सदसत्' होने का अर्थ है कि वह दिखने वाले जगत और न दिखने वाली शक्ति दोनों में है।
            उसे जानना ही जीवन की सभी खोजों का अंतिम और सर्वोच्च विश्राम बिंदु है।
            यह द्वितीय मुण्डक के दूसरे खंड का मंगलमय और गहरा आरंभिक श्लोक है।
        """.trimIndent(),
        english = """
            That which is luminous, near, and dwells in the heart-cave is the Great Goal.
            In It is centered all that moves, breathes, and blinks in this vast existence.
            Know It as both being (gross) and non-being (subtle), most adorable of all.
            It is beyond the ordinary understanding of creatures and the highest of all.
            This verse shows the balance between God's greatness and His extreme subtlety.
            He is the basis of every tiny biological act and the greatest Truth of the cosmos.
            Our intellect tries to grasp Him, but He is the one who illuminates the intellect.
            Being 'Sat and Asat' means He exists in both the visible world and invisible force.
            Knowing Him is the final and supreme resting point of all human quests.
            This is the auspicious and deep opening verse of the second section, second Mundaka.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 34,
        sanskrit = "यदर्चिमद्यदणुभ्योऽणु च यस्मिँल्लोका निहिता लोकिनश्च । तदेतदक्षरं ब्रह्म स प्राणस्तदु वाङ्मनः तदेतत्सत्यं तदमृतं तद्वेद्धव्यं सोम्य विद्धि ॥ ३४ ॥",
        hindi = """
            वह जो प्रकाशमान है, जो सूक्ष्म से भी सूक्ष्म है और जिसमें सभी लोक स्थित हैं।
            वही अविनाशी ब्रह्म है, वही प्राण है और वही वाणी तथा मन का असली आधार है।
            वही एकमात्र परम सत्य है, वही अमृत है और हे सोम्य! वही निशाना साधने योग्य है।
            साधक को अपना पूरा ध्यान उसी एक लक्ष्य की ओर एकाग्र करना चाहिए।
            परमात्मा ही वह शक्ति है जिससे हमारी इंद्रियां और मन अपना कार्य कर पाते हैं।
            वह सूक्ष्म इतना है कि दिखाई नहीं देता, पर विराट इतना कि सब उसी के भीतर है।
            'वेद्धव्यं' (निशाना साधने योग्य) शब्द साधना की तीव्रता और एकाग्रता को दर्शाता है।
            जीवन का असली उद्देश्य उस सत्य की गहराई में पूरी तरह डूब जाना ही है।
            अमृत होने का अर्थ है—वह कभी नष्ट नहीं होता, भले ही शरीर बदल जाएँ।
            यह श्लोक हमें लक्ष्य की पहचान कराकर उस पर प्रहार करने की प्रेरणा देता है।
        """.trimIndent(),
        english = """
            That which is radiant, subtler than the subtle, and in which all worlds rest.
            That is the Imperishable Brahman; It is life, speech, and the basis of the mind.
            That alone is the Truth, That is the Immortal; O dear one, It is the Target.
            A seeker must concentrate his entire attention toward that single absolute Goal.
            The Divine is the power through which our senses and mind can function at all.
            He is so subtle that He is invisible, yet so vast that everything is within Him.
            The word 'Veddhavyam' (target) signifies the intensity and focus of spiritual practice.
            The real purpose of life is to completely immerse oneself in the depth of that Truth.
            Being immortal means It never perishes, even if physical bodies continue to change.
            This verse identifies the Goal for us and inspires us to strike it with focus.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 35,
        sanskrit = "धनुर्गृहीत्वौपनिषदं महास्त्रं शरं ह्युपासानिशितं सन्धयीत । आयम्य तद्भावगतेन चेतसा लक्ष्यं तदेवाक्षरं सोम्य विद्धि ॥ ३५ ॥",
        hindi = """
            उपनिषदों के महान अस्त्र 'धनुष' को लेकर, उस पर निरंतर उपासना से पैना किया हुआ बाण रखें।
            अपने चित्त को पूरी तरह उस ब्रह्म के भाव में डुबोकर, उस धनुष की डोरी को खींचें।
            हे सोम्य! उस अविनाशी अक्षर ब्रह्म को ही अपना एकमात्र निशाना (लक्ष्य) समझें।
            यहाँ साधना की तुलना धनुर्विद्या (Archery) से की गई है, जो एकाग्रता का खेल है।
            धनुष उपनिषद का ज्ञान है, और बाण हमारी अपनी आत्मा या निरंतर उपासना है।
            उपासना से बाण को पैना करना मतलब मन की चंचलता को पूरी तरह समाप्त करना।
            डोरी को खींचना यानी अपनी पूरी संकल्प शक्ति को एक ही दिशा में लगा देना है।
            यदि निशाना सही लगा, तो साधक और ब्रह्म के बीच की दूरी सदा के लिए मिट जाएगी।
            यह श्लोक आध्यात्मिक अभ्यास (Practice) की विधि को बहुत ही रोचक ढंग से समझाता है।
            बिना एकाग्रता के, ज्ञान केवल एक बोझ है; लक्ष्य को भेदना ही असली सफलता है।
        """.trimIndent(),
        english = """
            Taking the great weapon of the Upanishads as the bow, place the arrow sharpened by devotion.
            Drawing the string with a mind fully absorbed in the thought of Brahman.
            O dear one! Know that Imperishable Reality alone to be the absolute Target.
            Here, spiritual practice is compared to archery, which is a game of total focus.
            The bow is the Upanishadic wisdom, and the arrow is our own soul or meditation.
            Sharpening the arrow with devotion means ending all restlessness of the mind.
            Drawing the string means channeling one's entire willpower in a single direction.
            If the aim is true, the distance between the seeker and the Divine vanishes forever.
            This verse explains the method of spiritual practice in a very engaging manner.
            Without concentration, knowledge is a burden; hitting the target is true success.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 36,
        sanskrit = "प्रणवो धनुः शरो ह्यात्मा ब्रह्म तलक्ष्यमुच्यते । अप्रमत्तेन वेद्धव्यं शरवत्तन्मयो भवेत् ॥ ३६ ॥",
        hindi = """
            'ॐ' (प्रणव) ही धनुष है, जीवात्मा ही बाण है और ब्रह्म ही उसका लक्ष्य कहा गया है।
            प्रमाद (लापरवाही) रहित होकर उस लक्ष्य को भेदना चाहिए, ताकि बाण लक्ष्य में समा जाए।
            जैसे बाण लक्ष्य में घुसकर एक हो जाता है, वैसे ही आत्मा को ब्रह्म में लीन होना चाहिए।
            ॐ की ध्वनि मन को एकाग्र करने और उसे उच्च स्तर पर ले जाने का सबसे बड़ा साधन है।
            'अप्रमत्तेन' का अर्थ है कि साधना में जरा भी आलस्य या भटकाव की कोई जगह नहीं है।
            एकीकरण (Oneness) ही इस महान निशानेबाजी का अंतिम और एकमात्र परिणाम है।
            साधना का अर्थ स्वयं को मिटाकर उस असीम शक्ति में पूरी तरह मिल जाना ही है।
            यह श्लोक ओंकार की उपासना और आत्म-साक्षात्कार के संबंध को स्पष्ट करता है।
            जब बाण लक्ष्य में होता है, तब वह अपनी अलग पहचान खोकर लक्ष्य का ही हिस्सा बन जाता है।
            यही वह अवस्था है जहाँ 'मैं' समाप्त होता है और केवल 'वह' (ब्रह्म) शेष रह जाता है।
        """.trimIndent(),
        english = """
            The Pranava (OM) is the bow, the soul is the arrow, and Brahman is the target.
            One should hit that target with an undistracted mind, becoming one with it like the arrow.
            As the arrow enters the target and becomes inseparable, so should the soul merge in God.
            The sound of OM is the greatest tool to focus the mind and lift it to higher states.
            'Apramattena' means there is no room for laziness or distraction in spiritual practice.
            Integration (Oneness) is the final and only result of this grand spiritual archery.
            Meditation means dissolving one's limited self into that infinite and absolute Power.
            This verse clarifies the link between Om-meditation and direct Self-realization.
            When the arrow hits the target, it loses its separate identity and becomes part of it.
            This is the state where the 'I' ends and only 'That' (Brahman) remains forever.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 37,
        sanskrit = "यस्मिन् द्यौः पृथिवी चान्तरिक्षमोतं मनः सह प्राणैश्च सर्वैः । तमेवैकं जानथ आत्मानमन्या वाचो विमुञ्चथामृतस्यैष सेतुः ॥ ३७ ॥",
        hindi = """
            जिसमें स्वर्ग, पृथ्वी और अंतरिक्ष पिरोये हुए हैं, और जिसमें मन सभी प्राणों के साथ स्थित है।
            उस एक ही 'आत्मा' को जानो और अन्य सभी व्यर्थ की बातों को पूरी तरह त्याग दो।
            यही वह सेतु (पुल) है जो तुम्हें संसार के दुखों से पार अमृतत्व की ओर ले जाता है।
            संसार की बातें हमें बिखेरती हैं, जबकि आत्मा का ज्ञान हमें स्वयं में समेटता है।
            परमात्मा ही वह धागा है जिसने पूरे ब्रह्मांड के मनकों को एक साथ पकड़ रखा है।
            अन्य चर्चाएँ केवल मन को थकाती हैं, जबकि आत्म-चिंतन उसे नई ऊर्जा प्रदान करता है।
            अमृत का सेतु होने का अर्थ है कि यह ज्ञान ही मृत्यु के पार जाने का एकमात्र रास्ता है।
            जब हम केंद्र को जान लेते हैं, तो परिधि की सारी चीजें स्वतः ही स्पष्ट हो जाती हैं।
            यह श्लोक साधक को अपनी ऊर्जा केवल एक ही दिशा—आत्मज्ञान—में लगाने की प्रेरणा देता है।
            चुप्पी और एकांत ही वह माहौल है जहाँ आत्मा की आवाज़ स्पष्ट रूप से सुनाई देती है।
        """.trimIndent(),
        english = """
            In Him are woven the heavens, the earth, and the atmosphere, along with the mind and life.
            Know Him alone as the one Self and discard all other vain and distracting talk.
            This is the bridge to Immortality that carries you across the ocean of worldly sorrow.
            Worldly talk scatters our energy, while knowledge of the Self integrates us within.
            The Divine is the thread that holds the beads of the entire universe together.
            Other discussions only tire the mind, whereas self-reflection grants it new vitality.
            Being the 'Bridge to Immortality' means this wisdom is the only way beyond death.
            When we know the Center, all things on the periphery become clear spontaneously.
            This verse inspires the seeker to channel all energy in one direction—Self-knowledge.
            Silence and solitude are the environments where the voice of the Soul is heard clearly.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 38,
        sanskrit = "अरा इव रथनाभौ संहता यत्र नाड्यः स एषोऽन्तश्चरते बहुधा जायमानः । ओमित्येवं ध्यायथ आत्मानं स्वस्ति वः पाराय तमसः परस्तात् ॥ ३८ ॥",
        hindi = """
            जिस प्रकार रथ के पहिये की नाभि में सभी अरे (तिलियाँ) आकर एक साथ मिल जाती हैं।
            उसी प्रकार हृदय में सभी नाड़ियाँ मिलती हैं, जहाँ वह आत्मा अनेक रूपों में स्थित है।
            उस आत्मा का 'ॐ' के रूप में ध्यान करो; अंधकार के पार जाने के लिए तुम्हारा कल्याण हो।
            हृदय केवल एक अंग नहीं, बल्कि चेतना का वह मिलन बिंदु है जहाँ ईश्वर का वास है।
            अनेक रूपों में प्रकट होने का अर्थ है कि वही शक्ति हमारी हर भावना और विचार में है।
            अंधकार अज्ञान का प्रतीक है, और ॐ वह मशाल है जो हमें प्रकाश की ओर ले जाती है।
            ऋषि यहाँ शिष्यों को 'स्वस्ति' (आशीर्वाद) देते हैं ताकि उनकी यात्रा सफल और मंगलमय हो।
            साधना का लक्ष्य उस पार (तपसः परस्तात्) पहुँचना है जहाँ कोई भ्रम या पीड़ा नहीं है।
            यह श्लोक हृदय की सूक्ष्म संरचना और ध्यान की प्रभावशीलता को गहराई से समझाता है।
            ॐ का जाप करना ही वह नाव है जो अज्ञान के सागर को पार करने में हमारी मदद करती है।
        """.trimIndent(),
        english = """
            Where all the nadis (channels) meet like spokes in the hub of a chariot wheel.
            There He dwells within the heart, manifesting Himself in manifold ways.
            Meditate on that Self as OM; may you safely cross to the shore beyond darkness.
            The heart is not just an organ but the junction where the Divine resides in us.
            Manifesting in manifold ways means the same power is in every emotion and thought.
            Darkness is a symbol of ignorance, and OM is the torch that leads us toward light.
            The Sage blesses the disciples here with 'Svasti' for a successful and holy journey.
            The goal of meditation is to reach the 'other shore' where no delusion or pain exists.
            This verse explains the subtle structure of the heart and the efficacy of meditation.
            Chanting OM is the boat that helps us cross the vast and turbulent ocean of ignorance.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 39,
        sanskrit = "यः सर्वज्ञः सर्वविद्यस्यैष महिमा भुवि । दिव्ये ब्रह्मपुरे ह्येष व्योम्न्यऽऽत्मा प्रतिष्ठितः ॥ ३९ ॥",
        hindi = """
            वह जो सर्वज्ञ और सर्वविद् है, जिसकी महिमा इस संपूर्ण पृथ्वी पर स्पष्ट दिखाई देती है।
            वही आत्मा इस दिव्य ब्रह्मपुर (हृदय-आकाश) के भीतर पूरी तरह प्रतिष्ठित और स्थित है।
            ईश्वर की शक्ति को हम सितारों की चमक और फूलों की खुशबू—हर जगह देख सकते हैं।
            ब्रह्मपुर हमारे शरीर का वह सूक्ष्म हिस्सा है जहाँ हम परमात्मा का साक्षात् करते हैं।
            महिमा का अर्थ है कि प्रकृति का हर नियम और सौंदर्य उसी की बुद्धिमत्ता का प्रमाण है।
            वह जो अनंत है, वह हमारे छोटे-से हृदय में भी समाया हुआ है, यही सबसे बड़ा रहस्य है।
            उसे जानने के लिए हमें बहुत दूर जाने की नहीं, बस अपने भीतर ठहरने की ज़रूरत है।
            यह श्लोक ब्रह्म की सर्वव्यापकता और उसकी आंतरिक स्थिति के बीच संबंध जोड़ता है।
            हृदय वह सिंहासन है जहाँ वह राजा की तरह बैठकर हमारे जीवन का संचालन करता है।
            उसकी महिमा को पहचानना ही कृतज्ञता और भक्ति का सबसे पहला और मुख्य चरण है।
        """.trimIndent(),
        english = """
            He who is all-knowing and all-perceiving, whose glory is manifest everywhere on earth.
            That Self is established in the divine city of Brahman—the space within the heart.
            We can see God's power in the twinkle of stars and the scent of flowers everywhere.
            Brahmapura is the subtle part of our body where we come face-to-face with the Divine.
            Glory means that every law of nature and all its beauty prove His supreme intelligence.
            That which is infinite is also contained within our tiny heart; this is the great mystery.
            To know Him, we don't need to travel far; we just need to settle down within ourselves.
            This verse links the omnipresence of Brahman with His internal presence in man.
            The heart is the throne where He sits like a King and governs the course of our lives.
            Recognizing His glory is the first and most essential step toward gratitude and devotion.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 40,
        sanskrit = "मनोमयः प्राणशरीरनेता प्रतिष्ठितोऽन्ने हृदयं सन्निधाय । तद्विज्ञानेन परिपश्यन्ति धीरा आनन्दरूपममृतं यद्विभाति ॥ ४० ॥",
        hindi = """
            वह मन के स्वरूप वाला, प्राण और शरीर का नेता है जो अन्न (शरीर) में स्थित है।
            वह हृदय के भीतर रहकर संपूर्ण जीवन की गतिविधियों का सूक्ष्मता से संचालन करता है।
            विवेकी पुरुष ज्ञान के द्वारा उसे आनंदमयी और अविनाशी रूप में चमकते हुए देखते हैं।
            परमात्मा ही वह ड्राइवर है जो हमारे प्राणों और इस शरीर रूपी वाहन को चलाता है।
            'आनन्दरूपम' होने का अर्थ है कि ईश्वर का असली स्वभाव केवल और केवल परम सुख ही है।
            जब मन शुद्ध होता है, तब वह बाहरी विषयों की जगह आंतरिक प्रकाश को देखने लगता है।
            अन्न यानी हमारा भौतिक शरीर, जिसका आधार वह आंतरिक चेतन शक्ति ही मानी गई है।
            अमृत होने का अर्थ है कि वह कभी बूढ़ा नहीं होता और कभी मरता भी नहीं है।
            यह श्लोक बताता है कि भगवान केवल एक विचार नहीं, बल्कि एक जीवंत अनुभव हैं।
            धीर पुरुष वह है जो अपनी बुद्धि का उपयोग सत्य की परतों को खोलने के लिए करता है।
        """.trimIndent(),
        english = """
            He consists of mind and is the leader of the life-breaths and the body seated in food.
            He dwells in the heart, subtly governing all the activities and functions of life.
            The wise, through knowledge, behold Him shining as blissful and immortal existence.
            The Divine is the Driver who operates our vital breaths and this vehicle of the body.
            Being 'Anandarupam' means that the true nature of God is nothing but absolute Bliss.
            When the mind is purified, it stops looking at outer objects and sees the inner light.
            'Food' refers to our physical body, whose very basis is that internal conscious Power.
            Being immortal means He never grows old and He certainly never tastes death.
            This verse explains that God is not just a concept but a vibrant, living experience.
            A 'Dhira' is one who uses his intellect specifically to peel away the layers of illusion.
        """.trimIndent()
    ),// ... Continuing mundakaShlokasList from ID 41

    MundakaShloka(
        id = 41,
        sanskrit = "भिद्यते हृदयग्रन्थिश्छिद्यन्ते सर्वसंशयाः । क्षीयन्ते चास्य कर्माणि तस्मिन् दृष्टे परावरे ॥ ४१ ॥",
        hindi = """
            जब उस परावर (कार्य और कारण रूप) परमात्मा का साक्षात् अनुभव हो जाता है।
            तब साधक के हृदय की अविद्या रूपी गाँठ हमेशा के लिए पूरी तरह टूट जाती है।
            उसके मन में उठने वाले जन्म-जन्मान्तर के सभी संशय सदा के लिए मिट जाते हैं।
            उसके संचित कर्मों का भारी बोझ पूरी तरह क्षीण और भस्म हो जाता है।
            परमात्मा को देखना कोई भौतिक क्रिया नहीं, बल्कि बोध की एक महाक्रांति है।
            हृदय की गाँठ ही वह अहंकार है जो हमें सत्य देखने से पूरी तरह रोकता है।
            संशय ही वह कुहासा है जो हमें बार-बार सही मार्ग से भटकने पर मजबूर करता है।
            इस अवस्था में पहुँचने के बाद साधक फिर कभी अज्ञान के अंधेरे में नहीं गिरता।
            यह श्लोक आत्म-साक्षात्कार के बाद मिलने वाली पूर्ण स्वतंत्रता का प्रमाण है।
            मुक्ति का अर्थ ही है—बिना किसी बोझ और बिना किसी संदेह के सत्य में जीना।
        """.trimIndent(),
        english = """
            When that Supreme Reality, which is both cause and effect, is clearly seen.
            The knots of the heart, representing ignorance, are broken asunder forever.
            All doubts that have lingered for lifetimes are resolved and disappear completely.
            All the accumulated karmas of the individual are exhausted and destroyed.
            Beholding the Divine is not a physical act but a revolution of consciousness.
            The knot of the heart is the ego that prevents us from seeing the Truth.
            Doubt is the fog that repeatedly misleads us from the correct spiritual path.
            Once this state is attained, the seeker never falls back into the dark.
            This verse is a testament to the total freedom gained after Self-realization.
            Liberation means living in the Truth, without any burden and without any doubt.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 42,
        sanskrit = "हिरण्मये परे कोशे विरजं ब्रह्म निष्कलम् । तच्छुभ्रं ज्योतिषां ज्योतिस्तद्यदात्मविदो विदुः ॥ ४२ ॥",
        hindi = """
            उस ज्योतिर्मय (हिरण्मय) परम कोश के भीतर वह निर्मल और निष्कल ब्रह्म है।
            वह अत्यंत शुभ्र (पवित्र) है और सभी ज्योतियों की भी एकमात्र परम ज्योति है।
            उसे केवल वे ही जानते हैं जो अपनी आत्मा का साक्षात् अनुभव कर चुके हैं।
            'हिरण्मय कोश' का अर्थ है बुद्धि का वह उच्चतम स्तर जहाँ केवल प्रकाश है।
            निष्कल होने का अर्थ है कि उसमें कोई टुकड़ा या कोई भी अशुद्धि नहीं है।
            जैसे सूर्य सभी दीपकों को प्रकाशित करता है, वैसे ही ब्रह्म बुद्धियों को जगाता है।
            आत्मा को जानने वाले लोग बाहरी दुनिया के नकली चमत्कारों में नहीं उलझते।
            वह ज्योति इतनी सूक्ष्म है कि उसे केवल शांत मन से ही पहचाना जा सकता है।
            यह श्लोक परमात्मा की निराकार शुद्धता और उसकी दिव्यता का गुणगान करता है।
            सत्य की खोज का अंत उस परम प्रकाश के चरणों में पहुँचकर ही संभव होता है।
        """.trimIndent(),
        english = """
            In the highest golden sheath resides the Brahman, stainless and partless.
            It is the purest of the pure and is the Light of all lights in existence.
            That is what the knowers of the Self perceive within their own being.
            The 'Golden Sheath' refers to the intellect when it is purified and radiant.
            Being 'partless' means It is indivisible and free from all modifications.
            Just as the sun lights up all lamps, Brahman empowers all consciousness.
            Those who know the Self do not get distracted by worldly illusions.
            That Light is so subtle that it can only be recognized by a tranquil mind.
            This verse glorifies the formless purity and divinity of the Supreme.
            The quest for truth ends only upon reaching that ultimate, absolute Radiance.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 43,
        sanskrit = "न तत्र सूर्यो भाति न चन्द्रतारकं नेमा विद्युतो भान्ति कुतोऽयमग्निः । तमेव भान्तमनुभाति सर्वं तस्य भासा सर्वमिदं विभाति ॥ ४३ ॥",
        hindi = """
            वहाँ न सूर्य प्रकाशित होता है, न चन्द्रमा और न ही नक्षत्रों की चमक पहुँचती है।
            वहाँ ये बिजलियाँ भी नहीं चमकतीं, फिर इस तुच्छ अग्नि की तो बात ही क्या।
            उसके प्रकाशित होने पर ही यह संपूर्ण ब्रह्मांड उसके पीछे-पीझे प्रकाशित होता है।
            उसी की परम आभा से यह सब कुछ अपनी-अपनी सामर्थ्य के अनुसार चमक रहा है।
            यह उपनिषद का सबसे शक्तिशाली और काव्यात्मक श्लोक माना जाता है।
            ईश्वर किसी बाहरी प्रकाश का मोहताज नहीं, वह स्वयं प्रकाश का भी स्रोत है।
            हम जो कुछ भी बाहर देखते हैं, वह उस एक दिव्य प्रकाश का ही फीका प्रतिबिंब है।
            बिना उसकी चेतना के, न सूर्य में ऊष्मा होती और न मन में विचार करने की शक्ति।
            यह श्लोक हमें जड़ जगत से ऊपर उठकर उस चेतन शक्ति को देखने के लिए कहता है।
            उस परम प्रकाश को जानना ही जीवन के सभी अंधेरों को सदा के लिए मिटा देना है।
        """.trimIndent(),
        english = """
            There the sun shines not, nor the moon, nor do the stars glitter there.
            Neither do these lightnings flash, so what can be said of this tiny fire?
            When He shines, everything shines after Him by reflecting His brilliance.
            By His light alone, all this manifest universe is illuminated and visible.
            This is considered one of the most powerful and poetic verses in the Vedas.
            God is not dependent on any external light; He is the source of light itself.
            Everything we perceive outside is but a faint reflection of that Divine Light.
            Without His consciousness, the sun would lack heat and the mind lack thought.
            This verse urges us to look beyond the inert world to the conscious Power.
            To know that Supreme Light is to dispel all the darkness of life forever.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 44,
        sanskrit = "ब्रह्मैवेदममृतं पुरस्ताद्ब्रह्म पश्चाद्ब्रह्म दक्षिणतश्चोत्तरेण । अधश्चोर्ध्वं च प्रसृतं ब्रह्मैवेदं विश्वमिदं वरिष्ठम् ॥ ४४ ॥",
        hindi = """
            यह अविनाशी ब्रह्म ही सामने है, वही पीछे है और वही दक्षिण तथा उत्तर में है।
            वही नीचे की ओर और वही ऊपर की ओर भी पूरी तरह से फैला हुआ (व्याप्त) है।
            यह संपूर्ण दृश्य जगत वास्तव में वह श्रेष्ठ और महान ब्रह्म ही है।
            ईश्वर से खाली कोई जगह नहीं है, वह हर दिशा और हर कण में समाया हुआ है।
            जब हमारी दृष्टि बदलती है, तब हमें संसार की जगह केवल ईश्वर ही दिखता है।
            वरिष्ठ होने का अर्थ है कि उससे महान या उससे पुराना और कोई तत्व नहीं है।
            दूरी केवल हमारे मन का भ्रम है, सत्य तो यह है कि हम ब्रह्म में ही जी रहे हैं।
            यह श्लोक अद्वैत (Non-duality) के सिद्धांत को पूरी स्पष्टता से घोषित करता है।
            सब कुछ ब्रह्ममय है—यही वह अंतिम बोध है जो साधक को पूर्ण शांति देता है।
            यहाँ द्वितीय मुण्डक का समापन होता है और अद्वैत दर्शन की स्थापना होती है।
        """.trimIndent(),
        english = """
            This immortal Brahman is in the front, It is behind, and It is in the south and north.
            It is spread below and above; Brahman alone is this entire vast universe.
            This perceived world is, in reality, nothing but that supreme, great Brahman.
            There is no space empty of God; He is permeated in every direction and atom.
            When our vision changes, we see only the Divine instead of the world.
            Being 'Varishtham' means there is no element greater or older than It.
            Distance is only an illusion of our mind; we are already living in Brahman.
            This verse declares the principle of Non-duality with absolute clarity.
            All is Brahman—this is the final realization that grants the seeker peace.
            Here the second Mundaka concludes, establishing the non-dual philosophy.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 45,
        sanskrit = "द्वा सुपर्णा सयुजा सखाया समानं वृक्षं परिषस्वजाते । तयोरन्यः पिप्पलं स्वाद्वत्त्यनश्नन्नन्यो अभिचाकशीति ॥ ४५ ॥",
        hindi = """
            दो सुंदर पंखों वाले पक्षी, जो सदा साथ रहने वाले मित्र हैं, एक ही वृक्ष पर बैठे हैं।
            उनमें से एक पक्षी उस वृक्ष के फलों को स्वाद ले-लेकर बड़े मजे से खा रहा है।
            किंतु दूसरा पक्षी बिना कुछ खाए, केवल शांत भाव से सब कुछ देख (साक्षी) रहा है।
            वृक्ष हमारा शरीर है, फल हमारे कर्मों के सुख-दुख हैं और पक्षी चेतना है।
            खाने वाला पक्षी 'जीवात्मा' है जो संसार के भोगों में पूरी तरह उलझा रहता है।
            देखने वाला पक्षी 'परमात्मा' है जो हमारे भीतर शुद्ध दृष्टा भाव से स्थित है।
            यह उपनिषदों का सबसे प्रसिद्ध उदाहरण है जो द्वैत और अद्वैत को समझाता है।
            जब तक हम 'खाने वाले' बने रहेंगे, तब तक हम कर्मों के बंधन में बंधे रहेंगे।
            जिस दिन हम 'देखने वाले' के साथ एक हो जाएंगे, उसी दिन हम मुक्त हो जाएंगे।
            यह श्लोक तृतीय मुण्डक का आरंभ है, जो जीवन के असली रहस्य को खोलता है।
        """.trimIndent(),
        english = """
            Two birds of beautiful plumage, inseparable friends, reside on the selfsame tree.
            One of them eats the fruit of the tree with relish and experiences its taste.
            The other bird, however, eats nothing and looks on merely as a silent Witness.
            The tree is the body, the fruits are the results of karma, and birds are consciousness.
            The eating bird is the 'Jiva' (individual soul) entangled in worldly enjoyments.
            The witnessing bird is the 'Atman' (Supreme Soul) residing as the pure Observer.
            This is the most famous metaphor in the Upanishads explaining the human condition.
            As long as we identify with the eater, we remain bound by our actions.
            The day we identify with the Witness, we attain freedom from all suffering.
            This verse begins the third Mundaka, revealing the core secret of existence.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 46,
        sanskrit = "समाने वृक्षे पुरुषो निमग्नोऽनीशया शोचति मुह्यमानः । जुष्टं यदा पश्यत्यन्यमीशमस्य महिमानमिति वीतशोकः ॥ ४६ ॥",
        hindi = """
            उसी एक ही वृक्ष (शरीर) पर बैठा हुआ जीवात्मा अज्ञान के कारण पूरी तरह डूबा हुआ है।
            वह अपनी असमर्थता और दुखों के कारण बार-बार शोक करता है और मोहित होता है।
            किंतु जब वह अपने से भिन्न उस महिमावान 'ईश' (परमात्मा) को साक्षात् देख लेता है।
            तब वह अपनी असलियत जानकर तुरंत सभी दुखों और शोकों से हमेशा के लिए मुक्त होता है।
            हमारा दुख केवल इसलिए है क्योंकि हमने खुद को केवल शरीर और मन मान लिया है।
            मोक्ष का अर्थ परमात्मा के पास जाना नहीं, बल्कि उसे अपने भीतर ही पहचान लेना है।
            महिमा को देखने का अर्थ है यह जानना कि हम उस अनंत ऊर्जा का ही एक हिस्सा हैं।
            जैसे ही दृष्टि बदलती है, वैसे ही संसार का सारा बोझ और तनाव गायब हो जाता है।
            यह श्लोक साधना के उस क्षण का वर्णन करता है जब अज्ञान का पर्दा गिरता है।
            शांति केवल सत्य को स्वीकार करने में है, उसे बाहर कहीं ढूँढने में बिल्कुल नहीं।
        """.trimIndent(),
        english = """
            On the same tree, the individual soul is immersed, grieving and bewildered by ego.
            He laments his helplessness and is confused by the changing nature of the world.
            But when he beholds the other, the adorable Lord, and perceives His vast glory.
            He immediately becomes free from all grief and attains eternal tranquility.
            Our suffering exists only because we identify exclusively with the body and mind.
            Liberation is not going to God, but recognizing Him right within ourselves.
            Perceiving His glory means realizing that we are a part of that infinite Energy.
            As soon as the perspective shifts, the entire burden and stress of life vanish.
            This verse describes the moment in meditation when the veil of ignorance falls.
            Peace lies only in accepting the Truth, not in searching for it elsewhere.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 47,
        sanskrit = "यदा पश्यः पश्यते रुक्मवर्णं कर्तारमीशं पुरुषं ब्रह्मयोनिम् । तदा विद्वान् पुण्यपापे विधूय निरञ्जनः परमं साम्यमुपैति ॥ ४७ ॥",
        hindi = """
            जब साधक उस सुवर्ण के समान प्रकाशमान, कर्ता और ब्रह्म के मूल पुरुष को देख लेता है।
            तब वह विद्वान पुण्य और पाप—दोनों के बंधनों को पूरी तरह झाड़कर फेंक देता है।
            वह अशुद्धि-रहित (निरंजन) होकर परमात्मा के साथ परम समानता (एकता) को प्राप्त करता है।
            पुण्य भी एक तरह की सोने की जंजीर है, जो हमें संसार से बाँधे रखती है।
            परमात्मा को 'ब्रह्मयोनि' कहा गया है क्योंकि वही संपूर्ण ज्ञान और सृष्टि का स्रोत है।
            निरंजन होने का अर्थ है कि उस पर अब कर्मों का कोई दाग या रंग नहीं चढ़ सकता।
            साम्य का अर्थ है कि अब उसके और ईश्वर के बीच कोई भी दूरी या भेद शेष नहीं है।
            यह श्लोक द्वैत से अद्वैत की ओर छलांग लगाने की उस उच्चतम अवस्था का वर्णन है।
            साधना का अंत केवल ज्ञान में नहीं, बल्कि स्वयं ब्रह्म हो जाने में ही होता है।
            पाप और पुण्य से ऊपर उठना ही वास्तविक आध्यात्मिक स्वतंत्रता और पूर्णता है।
        """.trimIndent(),
        english = """
            When the seer beholds the golden-hued Creator, the Lord, the Source of Brahma.
            Then the wise one shakes off both merit and demerit, becoming free from bonds.
            Being stainless (Niranjana), he attains the supreme equality with the Divine.
            Even merit (Punya) is a kind of golden chain that keeps us bound to the world.
            The Divine is called 'Brahmayoni' as He is the source of all wisdom and creation.
            Being Niranjana means that no stain of past actions can ever touch him again.
            Equality means there is no longer any distance or difference between him and God.
            This verse describes the highest state of leaping from duality into non-duality.
            The end of practice is not just in knowing Brahman, but in becoming Brahman.
            Rising above both sin and virtue is true spiritual independence and perfection.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 48,
        sanskrit = "प्राणो ह्येष यः सर्वभूतैर्विभाति विजानन् विद्वान् भवते नातिवादी । आत्मक्रीड आत्मरतिः क्रियावानेष ब्रह्मविदां वरिष्ठः ॥ ४८ ॥",
        hindi = """
            यह प्राण ही है जो समस्त प्राणियों के भीतर अलग-अलग रूपों में चमक रहा है।
            इस सत्य को जानने वाला विद्वान कभी भी व्यर्थ का वाक-युद्ध (बहस) नहीं करता।
            वह अपनी आत्मा में ही क्रीड़ा करने वाला, आत्मा में ही लीन और निरंतर क्रियाशील है।
            ऐसा महापुरुष ही ब्रह्मवेत्ताओं में सबसे श्रेष्ठ और महान माना जाता है।
            जो सत्य को जान लेता है, उसे दूसरों को प्रभावित करने के लिए बोलने की ज़रूरत नहीं होती।
            आत्म-क्रीड़ा का अर्थ है कि उसे सुख के लिए बाहरी मनोरंजन की कोई आवश्यकता नहीं है।
            उसकी क्रियाशीलता निस्वार्थ होती है, क्योंकि वह सबमें अपनी ही आत्मा को देखता है।
            वह शांत होकर भी बहुत सक्रिय होता है, क्योंकि उसकी ऊर्जा अब ईश्वर से आती है।
            यह श्लोक एक आत्मज्ञानी पुरुष के आचरण और उसकी आंतरिक स्थिति को बताता है।
            ब्रह्मविदों में वरिष्ठ वही है जो ज्ञान को केवल बातों में नहीं, बल्कि जीवन में जीता है।
        """.trimIndent(),
        english = """
            Life (Prana) indeed is He who shines forth through all living beings.
            Knowing this, the wise one does not become a vain talker or a debater.
            He sports in the Self, delights in the Self, and is yet full of right action.
            Such a person is the best among the knowers of the Supreme Brahman.
            He who has realized the Truth has no need for words to impress others.
            Sporting in the Self means he requires no external entertainment for happiness.
            His actions are selfless because he perceives his own Self in everyone.
            He is calm yet highly active, for his energy now flows directly from the Divine.
            This verse describes the conduct and the internal state of a realized soul.
            The best of knowers is he who lives the wisdom rather than just talking about it.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 49,
        sanskrit = "सत्येन लभ्यस्तपसा ह्येष आत्मा सम्यग्ज्ञानेन ब्रह्मचर्येण नित्यम् । अन्तःशरीरे ज्योतिर्मयो हि शुभ्रो यं पश्यन्ति यतयः क्षीणदोषाः ॥ ४९ ॥",
        hindi = """
            यह आत्मा सत्य, तप, यथार्थ ज्ञान और निरंतर ब्रह्मचर्य के द्वारा प्राप्त की जा सकती है।
            वह शरीर के भीतर ही अत्यंत ज्योतिर्मय और शुभ्र (पवित्र) रूप में स्थित है।
            जिन्होंने अपने दोषों (काम, क्रोध, लोभ) को नष्ट कर दिया है, वे यति ही उसे देख पाते हैं।
            आध्यात्मिक मार्ग पर सफलता के लिए ये चार स्तंभ—सत्य, तप, ज्ञान और संयम—अनिवार्य हैं।
            ईश्वर कहीं दूर नहीं, हमारे अपने शरीर के ही आंतरिक आकाश में प्रकाशित है।
            दोषों का क्षीण होना मन के उस दर्पण को साफ करने जैसा है जिसमें सत्य दिखता है।
            नित्यता का अर्थ है कि यह अभ्यास कभी-कभी का नहीं, बल्कि हर पल का होना चाहिए।
            ब्रह्मचर्य केवल शारीरिक नहीं, बल्कि अपनी ऊर्जा को ऊपर की ओर ले जाना है।
            यह श्लोक साधना के व्यावहारिक नियमों और आत्म-साक्षात्कार की विधि को बताता है।
            सत्य का खोजी वही है जो अपने चरित्र को पूरी तरह पवित्र और मजबूत बना लेता है।
        """.trimIndent(),
        english = """
            This Self is attainable by truth, by austerity, by right knowledge, and by celibacy.
            He is seated within the body, full of light and absolutely pure.
            Only the seekers (Yatis) who have cleansed their sins can perceive Him.
            Four pillars are essential for spiritual success: Truth, Penance, Wisdom, and Discipline.
            The Divine is not far away; He shines within the internal space of our own body.
            Exhausting one's flaws is like cleaning the mirror of the mind to see the Truth.
            Constancy implies that this practice should be a perpetual way of living.
            Celibacy is not just physical; it is the redirection of all energy toward the Divine.
            This verse outlines the practical rules and the method of direct Self-realization.
            A true seeker is one who makes his character completely pure and resilient.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 50,
        sanskrit = "सत्यमेव जयते नानृतं सत्येन पन्था विततो देवयानः । येनाक्रमन्त्यृषयो ह्याप्तकामा यत्र तत् सत्यस्य परमं निधानम् ॥ ५० ॥",
        hindi = """
            सत्य की ही जीत होती है, असत्य की नहीं; सत्य के द्वारा ही देवयान मार्ग बना है।
            उसी मार्ग से वे पूर्णकाम ऋषि गमन करते हैं, जिनकी सभी सांसारिक इच्छाएं समाप्त हो चुकी हैं।
            वे उस स्थान पर पहुँचते हैं जहाँ सत्य का वह परम भंडार (परमात्मा) स्थित है।
            यह श्लोक भारत का राष्ट्रीय आदर्श वाक्य है, जो नैतिकता की सर्वोच्चता को बताता है।
            सत्य का अर्थ केवल बोलना नहीं, बल्कि सत्य के साथ अपनी पूरी निष्ठा जोड़ना है।
            झूठ थोड़े समय के लिए जीत सकता है, पर अंततः वह विनाश की ओर ही ले जाता है।
            देवयान वह मार्ग है जो साधक को अंधकार से निकालकर दिव्य प्रकाश की ओर ले जाता है।
            आप्तकाम वे हैं जिन्होंने ईश्वर को पाकर सब कुछ पा लिया है, अब उन्हें कुछ नहीं चाहिए।
            सत्य ही वह सीढ़ी है जिससे चढ़कर मनुष्य अपने ईश्वरीय स्वरूप तक पहुँचता है।
            यह श्लोक जीवन में सच्चाई और ईमानदारी को सबसे बड़ी शक्ति के रूप में स्थापित करता है।
        """.trimIndent(),
        english = """
            Truth alone triumphs, not falsehood; by Truth is laid out the path of the gods.
            By that path, the sages whose desires are fulfilled ascend to the Supreme.
            They reach that place where the ultimate treasure of Truth (Brahman) resides.
            This verse is India's national motto, declaring the absolute supremacy of morality.
            Truth means not just speaking it, but aligning one's entire being with the Real.
            Falsehood may win temporarily, but it inevitably leads to ultimate destruction.
            Devayana is the path that carries the seeker out of darkness into divine Light.
            Aptakama are those who have found the Divine and now want nothing else from the world.
            Truth is the ladder by which man ascends to his original, divine nature.
            This verse establishes honesty and integrity as the greatest powers in existence.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 51,
        sanskrit = "बृहच्च तद्दिव्यमचिन्त्यरूपं सूक्ष्माच्च तत्सूक्ष्मतरं विभाति । दूरात्सुदूरे तदिहान्तिके च पश्यत्स्विहैव निहितं गुहायाम् ॥ ५१ ॥",
        hindi = """
            वह ब्रह्म अत्यंत महान, दिव्य और अचिन्त्य रूप वाला है, यानी वह सोच से परे है।
            वह सूक्ष्म से भी अधिक सूक्ष्म है और चारों ओर अपनी आभा से प्रकाशित हो रहा है।
            वह दूर से भी बहुत दूर है, और साथ ही वह यहीं हमारे बिल्कुल पास (समीप) भी है।
            देखने वालों के लिए वह यहीं इसी शरीर की हृदय-गुफा में पूरी तरह स्थित है।
            परमात्मा की विराटता और उसकी सूक्ष्मता—दोनों को एक साथ समझना ही योग है।
            वह दूर उनके लिए है जो बाहर खोज रहे हैं, पर पास उनके लिए है जो भीतर हैं।
            अचिन्त्य का अर्थ है कि उसे तर्क या गणित से पूरी तरह नहीं समझा जा सकता।
            वह जो अनंत आकाश को थामे है, वही हमारे छोटे-से दिल में भी धड़क रहा है।
            यह श्लोक ईश्वर की सर्वव्यापकता (Omnipresence) का बहुत सुंदर परिचय देता है।
            सत्य कहीं विदेश में नहीं, वह हमारे अपने अस्तित्व की सबसे गहरी परत में छिपा है।
        """.trimIndent(),
        english = """
            That Brahman is vast, divine, and of unthinkable form—beyond all imagination.
            It is subtler than the subtlest and shines forth with its own brilliance.
            It is farther than the farthest, yet It is right here, very near to the seeker.
            For those who see, It is perceived as dwelling right here in the cave of the heart.
            To understand both the vastness and the subtlety of God simultaneously is Yoga.
            He is distant for those looking outside, but near for those who look within.
            'Unthinkable' means It cannot be fully grasped by logic or mathematical calculations.
            The One who supports the infinite sky is also pulsating within our own small hearts.
            This verse provides a beautiful introduction to the omnipresence of the Divine.
            Truth is not in some foreign land; it is hidden in the deepest layer of our existence.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 52,
        sanskrit = "न चक्षुषा गृह्यते नापि वाचा नान्यैर्देवैस्तपसा कर्मणा वा । ज्ञानप्रसादेन विशुद्धसत्त्वस्ततस्तु तं पश्यते निष्कलं ध्यायमानः ॥ ५२ ॥",
        hindi = """
            वह न तो आँखों से पकड़ा जा सकता है और न ही वाणी से उसका वर्णन किया जा सकता है।
            वह न अन्य इंद्रियों से, न केवल तप से और न ही कर्मों से प्राप्त किया जा सकता है।
            जब ज्ञान की शुद्धि से अंतःकरण निर्मल होता है, तब ध्यानी पुरुष उस निष्कल को देखता है।
            परमात्मा कोई वस्तु नहीं जिसे हम भौतिक औजारों से पकड़ सकें या देख सकें।
            तप और कर्म केवल मन को साफ करते हैं, वे साक्षात् मोक्ष नहीं दे सकते।
            'ज्ञानप्रसाद' का अर्थ है कि जब बुद्धि पूरी तरह शांत और पारदर्शी हो जाती है।
            तभी वह परमात्मा का प्रतिबिंब अपने भीतर स्पष्ट रूप से देख पाने में सक्षम होती है।
            निष्कलं यानी वह अखंड है, उसमें कोई भेद या कोई भी हिस्सा बिल्कुल नहीं है।
            ध्यान ही वह अंतिम द्वार है जिससे हम सत्य के गर्भगृह में प्रवेश करते हैं।
            यह श्लोक साधना की सूक्ष्मता और आंतरिक शुद्धि की महत्ता पर जोर देता है।
        """.trimIndent(),
        english = """
            He is not grasped by the eye, nor by speech, nor by any other sense organ.
            Nor is He attained by mere penance or by the performance of any actions.
            When the mind is purified by the light of wisdom, then the meditator sees Him.
            The Divine is not an object that we can catch or see with physical tools.
            Penance and rituals only clean the mind; they cannot grant liberation directly.
            'Jnana-prasada' means the state when the intellect becomes totally still and transparent.
            Only then is it capable of clearly reflecting the Divine within itself.
            'Partless' (Nishkalam) means He is undivided, without any fragments or splits.
            Meditation is the final door through which we enter the sanctum of Truth.
            This verse emphasizes the subtlety of practice and the importance of inner purity.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 53,
        sanskrit = "एषोऽणुरात्मा चेतसा वेदितव्यो यस्मिन् प्राणः पञ्चधा संविवेश । प्राणैश्चित्तं सर्वमोतं प्रजानां यस्मिन् विशुद्धे विभवत्येष आत्मा ॥ ५३ ॥",
        hindi = """
            यह सूक्ष्म (अणु) आत्मा शुद्ध चित्त द्वारा जानने योग्य है, जिसमें पांच प्राण स्थित हैं।
            समस्त प्राणियों का चित्त इंद्रियों और प्राणों के साथ पूरी तरह ओत-प्रोत है।
            जब वह चित्त पूरी तरह शुद्ध हो जाता है, तब यह आत्मा स्वयं ही प्रकट हो जाती है।
            चित्त ही वह पर्दा है जिस पर संसार के चित्र चलते हैं, उसे साफ करना ही साधना है।
            पांच प्राण (प्राण, अपान, व्यान, उदान, समान) हमारे जीवन की ऊर्जा के संचारक हैं।
            आत्मा इतनी सूक्ष्म है कि वह स्थूल विचारों की भीड़ में कभी नहीं दिखाई देती।
            शुद्धि का अर्थ है—पुरानी यादों, राग और द्वेष के कचरे को मन से बाहर निकाल देना।
            जैसे बादल छंटते ही सूर्य दिखता है, वैसे ही चित्त शुद्ध होते ही आत्मा दिखती है।
            परमात्मा को कहीं से लाना नहीं है, वह तो हमेशा से यहीं मौजूद और स्थिर है।
            यह श्लोक मन की गहराइयों और आत्मज्ञान के संबंध को बहुत बारीकी से समझाता है।
        """.trimIndent(),
        english = """
            This subtle Self is to be known by the pure mind, in which the five Pranas rest.
            The mind of all beings is completely interwoven with the senses and life-breaths.
            When that mind becomes absolutely pure, the Self reveals Itself spontaneously.
            The mind is the screen on which the world-images play; cleaning it is spiritual practice.
            The five Pranas are the transmitters of energy that keep our life functions active.
            The Self is so subtle that It remains unseen amidst the crowd of gross thoughts.
            Purification means removing the debris of old memories, attachments, and aversions.
            As the sun appears when clouds disperse, the Self appears when the mind is clear.
            The Divine doesn't have to be brought from anywhere; He is already present right here.
            This verse explains the link between the depths of the mind and Self-realization.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 54,
        sanskrit = "यं यं लोकं मनसा संविभाति विशुद्धसत्त्वः कामयते यांश्च कामान् । तं तं लोकं जयते तांश्च कामांस्तस्मादात्मज्ञं ह्यर्चयेद्भूतिकामः ॥ ५४ ॥",
        hindi = """
            शुद्ध अंतःकरण वाला आत्मज्ञानी मन से जिस-जिस लोक और जिन भोगों की इच्छा करता है।
            वह उन सभी लोकों और उन सभी कामनाओं को अपनी संकल्प शक्ति से जीत लेता है।
            इसलिए जो अपना कल्याण (विभूति) चाहता है, उसे आत्मज्ञानी की सेवा और पूजा करनी चाहिए।
            आत्मज्ञानी की संकल्प शक्ति परमात्मा की शक्ति के साथ पूरी तरह एक हो जाती है।
            उसकी इच्छाएं स्वार्थ के लिए नहीं, बल्कि जगत के कल्याण के लिए ही होती हैं।
            एक मुक्त पुरुष के सान्निध्य में रहना ही सबसे बड़ी आध्यात्मिक प्रगति मानी गई है।
            यह श्लोक आत्मज्ञान की अद्भुत शक्ति और उसके प्रभाव का वर्णन करता है।
            संसार की सफलता भी आत्मज्ञानी के आशीर्वाद से सुलभ और मंगलकारी हो जाती है।
            पूजन का अर्थ है—उनके गुणों को अपने भीतर उतारना और उनका सम्मान करना।
            सत्य को जानने वाला व्यक्ति पूरे ब्रह्मांड की ऊर्जा का स्वामी बन जाता है।
        """.trimIndent(),
        english = """
            Whatever world or whatever desires a man of pure mind and Self-knowledge intends.
            He wins those worlds and those desires through the sheer power of his will.
            Therefore, let him who desires prosperity worship the one who knows the Self.
            The willpower of a realized soul becomes one with the willpower of the Divine.
            His desires are not for selfish gain but for the ultimate good of the entire world.
            Being in the presence of a liberated soul is the greatest spiritual advancement.
            This verse describes the extraordinary power and influence of Self-realization.
            Even worldly success becomes easy and auspicious with the blessing of a Master.
            Worship means imbibing their qualities within oneself and showing deep respect.
            One who knows the Truth becomes the master of the energy of the entire universe.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 55,
        sanskrit = "स वेदैतत्परमं ब्रह्म धाम यत्र विश्वं निहितं भाति शुभ्रम् । उपासते पुरुषं ये ह्यकामास्ते शुक्रमेतदतिवर्तन्ति धीराः ॥ ५५ ॥",
        hindi = """
            वह आत्मज्ञानी उस परम ब्रह्म-धाम को जानता है, जहाँ यह संपूर्ण विश्व स्थित और प्रकाशित है।
            जो निष्काम होकर ऐसे आत्मज्ञानी पुरुष की उपासना करते हैं, वे पुनर्जन्म से मुक्त होते हैं।
            वे धीर पुरुष इस मानवीय बीज (शुक्र) और संसार के बंधनों को हमेशा के लिए पार कर जाते हैं।
            ब्रह्म ही वह आधार है जिस पर संसार का पूरा नाटक टिका हुआ और चल रहा है।
            आत्मज्ञानी की सेवा करना स्वयं ईश्वर के समीप जाने का सबसे छोटा रास्ता है।
            निष्काम होने का अर्थ है कि उनकी सेवा में कोई सांसारिक स्वार्थ या लालच न होना।
            पुनर्जन्म का चक्र अज्ञान के कारण है, और ज्ञान उसे जड़ से पूरी तरह काट देता है।
            यह श्लोक गुरु की महिमा और उनके माध्यम से मिलने वाली मुक्ति को बताता है।
            जो सत्य के साथ जुड़ जाते हैं, वे समय और मृत्यु की सीमाओं से ऊपर उठ जाते हैं।
            यहाँ तीसरे मुण्डक के दूसरे खंड का आरंभ होता है जो मोक्ष के मार्ग को पुष्ट करता है।
        """.trimIndent(),
        english = """
            The realized one knows that supreme abode of Brahman, where the universe is centered.
            Those who, free from all desires, worship such a person, transcend rebirth.
            These wise ones pass beyond the human seed and the bonds of this mortal world.
            Brahman is the foundation on which the entire drama of the world is supported.
            Serving a realized soul is the shortest route to getting closer to the Divine.
            Being 'desireless' means having no selfish motive or greed while serving them.
            The cycle of rebirth is caused by ignorance, and knowledge cuts it from the root.
            This verse explains the glory of the Guru and the liberation attained through them.
            Those who align themselves with the Truth rise above the limits of time and death.
            This marks the beginning of the final section, reinforcing the path of liberation.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 56,
        sanskrit = "कामान् यः कामयते मन्यमानः स कामभिर्जायते तत्र तत्र । पर्याप्तकामस्य कृतात्मनस्तु इहैव सर्वे प्रविलीयन्ति कामाः ॥ ५६ ॥",
        hindi = """
            जो व्यक्ति विषयों का चिंतन करते हुए उनकी इच्छा करता है, वह उन्हीं कामनाओं के कारण जन्म लेता है।
            जहाँ-जहाँ उसकी आसक्ति होती है, वहीं उसे पुनः शरीर धारण करना ही पड़ता है।
            किंतु जिसकी इच्छाएं परमात्मा में तृप्त हो चुकी हैं, उसकी सभी कामनाएं यहीं विलीन हो जाती हैं।
            कामना ही वह चुंबक है जो आत्मा को बार-बार धरती की मिट्टी की ओर खींच लाती है।
            'पर्याप्तकाम' वह है जिसने सब कुछ पा लिया है और अब उसे कुछ भी अधूरा नहीं लगता।
            जब मन पूर्ण हो जाता है, तब वह बाहर भटकना छोड़कर स्वयं में ही शांत हो जाता है।
            मुक्ति कहीं बाहर नहीं, बल्कि अपनी इच्छाओं के अंत और सत्य के बोध में ही है।
            यह श्लोक पुनर्जन्म के मुख्य कारण और उससे बचने के उपाय को बहुत स्पष्ट बताता है।
            अधूरी इच्छाएं ही अगले जन्म का बीज बनती हैं, उन्हें ज्ञान से भस्म करना ही योग है।
            परमात्मा का आनंद मिलते ही संसार के सभी सुख फीके और अर्थहीन लगने लगते हैं।
        """.trimIndent(),
        english = """
            He who cherishes objects and desires them is born again because of those desires.
            Wherever his attachments lie, there he must take up a physical form once more.
            But for him whose desire is fulfilled in the Self, all desires vanish right here.
            Desire is the magnet that repeatedly pulls the soul back to the dust of the earth.
            'Paryaptakama' is one who has attained everything and feels nothing is lacking.
            When the mind is full, it stops wandering outside and settles into itself in peace.
            Liberation is not outside but in the end of desire and the realization of Truth.
            This verse clearly states the main cause of rebirth and the way to avoid it.
            Unfulfilled desires are the seeds of the next life; burning them with wisdom is Yoga.
            Once the bliss of the Divine is felt, all worldly joys seem pale and meaningless.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 57,
        sanskrit = "नायमात्मा प्रवचनेन लभ्यो न मेधया न बहुना श्रुतेन । यमेवैष वृणुते तेन लभ्यस्तस्यैष आत्मा विवृणुते तनूं स्वाम् ॥ ५७ ॥",
        hindi = """
            यह आत्मा न तो बहुत प्रवचन देने से, न बुद्धि की चतुराई से और न बहुत सुनने से मिलती है।
            यह केवल उसे ही मिलती है जिसे यह 'स्वयं' चुन लेती है, यानी जो पूरी तरह समर्पित है।
            उस अनन्य भक्त के सामने यह आत्मा अपने वास्तविक दिव्य स्वरूप को प्रकट कर देती है।
            ईश्वर को केवल पढ़कर या तर्क करके नहीं पाया जा सकता, वह अनुभव का विषय है।
            'चुनने' का अर्थ है कि साधक की तड़प इतनी गहरी हो कि वह परमात्मा के बिना न रह सके।
            अहंकार जब पूरी तरह गिर जाता है, तभी सत्य का प्रकाश भीतर प्रवेश कर पाता है।
            विवृणुते यानी परमात्मा स्वयं ही पर्दा हटाकर अपना दीदार साधक को करा देते हैं।
            यह श्लोक ज्ञान के अहंकार को तोड़कर समर्पण और प्रेम की महत्ता को स्थापित करता है।
            बुद्धि केवल द्वार तक ले जा सकती है, पर भीतर प्रवेश केवल हृदय का प्रेम ही कराता है।
            परमात्मा की कृपा ही वह अंतिम चाबी है जो मोक्ष के ताले को हमेशा के लिए खोलती है।
        """.trimIndent(),
        english = """
            This Self is not attained by much speaking, nor by intellect, nor by much hearing.
            It is gained by him alone whom It chooses; to such a one, the Self reveals Itself.
            Before that exclusive devotee, the Self unveils Its true, divine, and absolute nature.
            God cannot be found merely by reading or logic; He is a subject of direct experience.
            'Choosing' implies that the seeker's yearning is so deep that he cannot live without Him.
            Only when the ego completely collapses can the light of Truth enter within the soul.
            'Vivrunute' means the Divine Himself removes the veil and shows Himself to the seeker.
            This verse shatters the pride of knowledge and establishes the value of surrender.
            Intellect can lead you to the door, but only the love of the heart can lead you inside.
            Divine Grace is the final key that opens the lock of liberation forever and ever.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 58,
        sanskrit = "नायमात्मा बलहीनेन लभ्यो न च प्रमादात्तपसो वाप्यलिङ्गात् । एतैरुपायैर्यतते यस्तु विद्वांस्तस्यैष आत्मा विशते ब्रह्मधाम ॥ ५८ ॥",
        hindi = """
            यह आत्मा बलहीन (कमजोर इच्छाशक्ति वाले) और आलसी (प्रमादी) को कभी नहीं मिलती।
            यह बिना सही लक्ष्य (अलिङ्ग) वाले तप से भी कभी प्राप्त नहीं की जा सकती है।
            किंतु जो विद्वान इन उपायों (शक्ति, सतर्कता और सही तप) के साथ प्रयास करता है।
            उसकी आत्मा उस परम ब्रह्म-धाम में प्रवेश कर परमात्मा के साथ पूरी तरह एक हो जाती है।
            आध्यात्मिक मार्ग वीरों का मार्ग है, इसमें कायरों और आलसियों के लिए कोई जगह नहीं है।
            बल का अर्थ शारीरिक नहीं, बल्कि मानसिक मजबूती और संकल्प की अटूट दृढ़ता है।
            प्रमाद यानी असावधानी ही साधना की सबसे बड़ी दुश्मन है, हमेशा जागरूक रहना होगा।
            तप केवल दिखावे का नहीं, बल्कि स्पष्ट लक्ष्य (लिङ्ग) के साथ आत्म-शुद्धि के लिए होना चाहिए।
            यह श्लोक साधना के लिए आवश्यक साहस, अनुशासन और स्पष्टता पर बहुत जोर देता है।
            जो पूरे मन से और सही दिशा में प्रयास करता है, सफलता उसी के कदम चूमती है।
        """.trimIndent(),
        english = """
            This Self is not attained by the weak-willed, nor by the careless or the distracted.
            Nor is It gained by penance without a proper purpose or a clear spiritual goal.
            But the wise one who strives with strength, alertness, and correct discipline.
            His soul enters that supreme abode of Brahman and becomes one with the Divine.
            The spiritual path is for the brave; there is no place here for the timid or lazy.
            Strength refers not to the physical but to mental resilience and unshakable will.
            Carelessness (Pramada) is the greatest enemy of practice; one must remain alert.
            Penance should not be for show but for self-purification with a clear spiritual aim.
            This verse emphasizes the courage, discipline, and clarity required for the journey.
            Success kisses the feet of him who strives with a whole heart and in the right direction.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 59,
        sanskrit = "सम्प्राप्यैनमृषयो ज्ञानतृप्ताः कृतात्मानो वीतरागाः प्रशान्ताः । ते सर्वगं सर्वतः प्राप्य धीरा युक्तात्मानः सर्वमेवाविशन्ति ॥ ५९ ॥",
        hindi = """
            उस परमात्मा को प्राप्त करके ऋषि ज्ञान से तृप्त, शांत और राग-द्वेष से पूरी तरह मुक्त हो जाते हैं।
            वे धीर पुरुष सब जगह व्याप्त उस परमात्मा को हर जगह साक्षात् अनुभव करते हैं।
            वे परमात्मा में पूरी तरह युक्त (जुड़कर) स्वयं उस 'सब कुछ' (ब्रह्म) में प्रविष्ट हो जाते हैं।
            तृप्ति का अर्थ है कि अब उन्हें बाहर से कुछ भी पाने की कोई इच्छा शेष नहीं रह गई है।
            वीतराग होने का अर्थ है कि अब संसार की कोई भी वस्तु उन्हें आकर्षित या विचलित नहीं करती।
            सर्वत्र अनुभव करने का मतलब है कि वे अब हर कण में अपनी ही आत्मा का दर्शन करते हैं।
            मुक्ति का अर्थ है अपनी सीमाओं को तोड़कर उस अनंत विराट चेतना का हिस्सा बन जाना।
            जब हम ईश्वर में प्रविष्ट होते हैं, तब हम स्वयं ईश्वर ही हो जाते हैं, कोई भेद नहीं रहता।
            यह श्लोक मुक्त पुरुषों की परम शांति और उनकी व्यापकता का बहुत सुंदर वर्णन है।
            ज्ञान की पूर्णता ही हमें व्यक्तिगत पहचान से उठाकर वैश्विक चेतना तक पहुँचा देती है।
        """.trimIndent(),
        english = """
            Having attained Him, the sages are satisfied with wisdom, calm and free from desire.
            Those wise ones, finding the All-pervading everywhere, merge into the All.
            United with the Self, they enter into the Everything—the Absolute Brahman.
            Satisfaction means they no longer have any desire to gain anything from the outside.
            Being 'Vitaraga' means no worldly object can attract or disturb them anymore.
            Experiencing Him everywhere means they see their own Self in every single particle.
            Liberation means breaking one's limits and becoming a part of that infinite Consciousness.
            When we enter into God, we become God Himself; no distinction or split remains.
            This verse is a beautiful description of the peace and the vastness of liberated souls.
            The perfection of knowledge lifts us from individual identity to universal awareness.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 60,
        sanskrit = "वेदान्तविज्ञानसुनिश्चितार्थाः संन्यासयोगाद्यतयः शुद्धसत्त्वाः । ते ब्रह्मलोकेषु परान्तकाले परामृताः परिमुच्यन्ति सर्वे ॥ ६० ॥",
        hindi = """
            वेदान्त के विज्ञान से जिन्होंने सत्य को सुनिश्चित कर लिया है और संन्यास योग से शुद्ध हो गए हैं।
            वे यति मृत्यु के समय ब्रह्मलोक में उस परम अमृत (परमात्मा) के साथ पूरी तरह मुक्त होते हैं।
            वे हमेशा के लिए जन्म और मरण के इस दुखद चक्र से पूरी तरह बाहर निकल जाते हैं।
            'वेदान्त विज्ञान' का अर्थ है उपनिषदों के ज्ञान का तर्कसंगत और अनुभवात्मक बोध।
            संन्यास का अर्थ केवल कपड़े बदलना नहीं, बल्कि अपने अहंकार और आसक्ति का त्याग है।
            शुद्धसत्त्व वे हैं जिनका अंतःकरण पूरी तरह पारदर्शी और ईश्वरीय प्रकाश से भरा है।
            परान्तकाले का अर्थ है वह समय जब देह का अंतिम बंधन भी पूरी तरह टूट जाता है।
            मुक्ति अब उनके लिए कोई संभावना नहीं, बल्कि एक निश्चित और अटल हकीकत है।
            यह श्लोक सन्यास के मार्ग और वेदान्त के अंतिम लक्ष्य की महत्ता को बताता है।
            ब्रह्म में विलीन होना ही मानव जीवन की सबसे बड़ी और अंतिम सफलता मानी गई है।
        """.trimIndent(),
        english = """
            Those who have ascertained the Truth through Vedanta and are purified by Sannyasa.
            They, at the time of death, are liberated in the world of Brahman with the Immortal.
            They all pass beyond the cycle of birth and death and attain absolute and eternal peace.
            'Vedanta-Vijnana' refers to the logical and experiential understanding of Upanishads.
            Renunciation (Sannyasa) means the sacrifice of ego and attachment, not just clothes.
            'Shuddha-Sattva' are those whose minds are transparent and filled with Divine Light.
            'Parantakale' refers to the time when the final bond with the physical body is broken.
            Liberation is no longer a possibility for them; it is a certain and immutable reality.
            This verse explains the importance of the path of Sannyasa and the goal of Vedanta.
            Merging into Brahman is considered the greatest and final success of human life.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 61,
        sanskrit = "गताः कलाः पञ्चदश प्रतिष्ठा देवाश्च सर्वे प्रतिदेवतासु । कर्माणि विज्ञानमयश्च आत्मा परेऽव्यये सर्व एकीभवन्ति ॥ ६१ ॥",
        hindi = """
            मृत्यु के समय शरीर की पन्द्रह कलाएं अपने-अपने मूल कारणों (तत्वों) में वापस मिल जाती हैं।
            सभी इंद्रियां (देवता) अपनी-अपनी अधिष्ठात्री शक्तियों में पूरी तरह विलीन हो जाती हैं।
            व्यक्ति के कर्म और उसकी विज्ञानमयी आत्मा—सब उस अविनाशी ब्रह्म में एक हो जाते हैं।
            जैसे घड़ा फूटने पर उसके भीतर का आकाश बाहर के अनंत आकाश के साथ एक हो जाता है।
            वैसे ही मुक्त पुरुष की चेतना अपनी सभी सीमाओं को छोड़कर परमात्मा में समा जाती है।
            पन्द्रह कलाएं हमारे शरीर और जीवन की संरचना के विभिन्न अंग और ऊर्जाएं हैं।
            अब न कोई 'मैं' बचता है और न कोई 'मेरा', केवल वह एक अखंड सत्य ही शेष रहता है।
            यह श्लोक मुक्ति के समय होने वाली आंतरिक और बाहरी प्रलय (लय) को समझाता है।
            सब कुछ वहीं लौट जाता है जहाँ से वह कभी खेल खेलने के लिए बाहर निकला था।
            एकीकरण (Oneness) ही वह परम अवस्था है जिसे पाने के बाद कुछ भी अलग नहीं रहता।
        """.trimIndent(),
        english = """
            The fifteen parts of the body return to their sources, and the senses to their deities.
            Actions and the intellectual self (Vijnanamaya Atma) all become one in the Supreme.
            They merge into the Imperishable Brahman like a jar breaking and its air joining the sky.
            The consciousness of the liberated soul leaves all limits and merges into the Divine.
            The fifteen parts are the various organs and energies that constitute our physical life.
            Now no 'I' remains and no 'mine'; only that one unbroken Truth exists forever.
            This verse explains the internal and external dissolution at the time of liberation.
            Everything returns to the source from where it once emerged to play the world-game.
            Integration (Oneness) is the supreme state after attaining which nothing is separate.
            The journey of the many ends in the realization of the absolute and eternal One.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 62,
        sanskrit = "यथा नद्यः स्यन्दमानाः समुद्रेऽस्तं गच्छन्ति नामरूपे विहाय । तथा विद्वान् नामरूपाद्विमुक्तः परात्परं पुरुषमुपैति दिव्यम् ॥ ६२ ॥",
        hindi = """
            जिस प्रकार बहती हुई नदियां समुद्र में मिलकर अपने नाम और रूप को पूरी तरह त्याग देती हैं।
            वे फिर केवल 'समुद्र' ही कहलाती हैं, उनकी अपनी कोई अलग पहचान नहीं रह जाती है।
            ठीक उसी प्रकार, विद्वान पुरुष नाम और रूप के बंधनों से मुक्त होकर उस दिव्य पुरुष को प्राप्त करता है।
            नदियां अलग-अलग जगहों से आती हैं, पर समुद्र में पहुँचते ही वे सब एक हो जाती हैं।
            हमारा नाम और हमारा रूप केवल इस शरीर की सीमाएं हैं, हमारी आत्मा तो अनंत है।
            मुक्ति का अर्थ है अपनी छोटी पहचान को छोड़कर उस विराट पहचान को स्वीकार कर लेना।
            जैसे गंगा और यमुना समुद्र में मिलकर एक हैं, वैसे ही सभी मुक्त आत्माएं ब्रह्म में एक हैं।
            यह उपनिषदों की सबसे सुंदर और प्रसिद्ध उपमा है जो अद्वैत के अनुभव को बताती है।
            परमात्मा 'परात्पर' है, यानी वह सूक्ष्म से भी सूक्ष्म और श्रेष्ठ से भी श्रेष्ठतम है।
            जब हम उसमें विलीन होते हैं, तब हम स्वयं वह अमृत और अविनाशी सत्य ही हो जाते हैं।
        """.trimIndent(),
        english = """
            As flowing rivers merge into the ocean, leaving behind their separate names and forms.
            They are then called only 'Ocean', and their individual identity disappears completely.
            Similarly, the wise one, freed from name and form, attains the Supreme Divine Person.
            Rivers come from different places, but they all become one upon reaching the ocean.
            Our name and our form are merely the limits of the body; our soul is truly infinite.
            Liberation means discarding the small identity to embrace the universal identity.
            As Ganga and Yamuna are one in the sea, all liberated souls are one in Brahman.
            This is the most beautiful and famous metaphor in the Upanishads for the non-dual state.
            The Divine is 'Paratparam'—subtler than the subtle and higher than the highest.
            When we merge into Him, we become that very immortal and indestructible Truth.
        """.trimIndent()
    ),

    MundakaShloka(
        id = 63,
        sanskrit = "स यो ह वै तत्परमं ब्रह्म वेद ब्रह्मैव भवति नास्याब्रह्मवित्कुले भवति । तरति शोकं तरति पाप्मानं गुहाग्रन्थिभ्यो विमुक्तोऽमृतो भवति ॥ ६३ ॥",
        hindi = """
            जो उस परम ब्रह्म को जान लेता है, वह वास्तव में स्वयं ब्रह्म ही हो जाता है।
            उसके कुल (वंश) में कोई भी ऐसा व्यक्ति नहीं होता जो ब्रह्म को न जानता हो।
            वह शोक को पार कर जाता है, पापों से मुक्त होता है और हृदय की गाँठों से छूटकर अमृत होता है।
            यह वेदान्त का सबसे बड़ा महावाक्य है—'ब्रह्मविद् ब्रह्मैव भवति' (ब्रह्मवेत्ता ब्रह्म ही है)।
            ज्ञान केवल जानकारी नहीं, बल्कि वह पूरी तरह रूपांतरित (Transform) हो जाने की प्रक्रिया है।
            ब्रह्म को जानने वाले का सान्निध्य उसके पूरे परिवार और समाज को ज्ञान की ओर मोड़ देता है।
            शोक और पाप केवल अज्ञान के कारण हैं, ज्ञान के सूर्य के सामने वे टिक नहीं सकते।
            गुहाग्रन्थि यानी अज्ञान के वे गहरे संस्कार जो हमें जन्म-मरण के चक्र में बाँधे रखते हैं।
            अमृत होने का अर्थ है कि वह अब काल (समय) और मृत्यु के प्रभाव से पूरी तरह ऊपर है।
            यह श्लोक आत्मज्ञान के महान और क्रांतिकारी परिणामों को पूरी दुनिया के सामने रखता है।
        """.trimIndent(),
        english = """
            He who knows that Supreme Brahman truly and certainly becomes Brahman Himself.
            In his lineage, there is born no one who is not a knower of the Supreme Brahman.
            He crosses over grief, he crosses over sin, and freed from the heart's knots, he is immortal.
            This is the greatest dictum of Vedanta—'Brahmavid Brahmaiva Bhavati' (Knower is Brahman).
            Knowledge is not just information; it is a process of total and absolute transformation.
            The presence of a realized soul turns his entire family and society toward wisdom.
            Grief and sin exist only due to ignorance; they cannot stand before the sun of wisdom.
            'Knots of the heart' are the deep impressions of ignorance that bind us to rebirth.
            Being immortal means he is now completely beyond the reach of time and death.
            This verse presents the grand and revolutionary results of Self-realization to the world.
        """.trimIndent()
    ),
    MundakaShloka(
        id = 64,
        sanskrit = "तदेतदृचाभ्युक्तम् । क्रियावन्तः श्रोत्रिया ब्रह्मनिष्ठाः स्वयं जुह्वत एकर्षिं श्रद्धयन्तः । तेषामेवैतां ब्रह्मविद्यां वदेत शिरोव्रतं विधिवद्यैस्तु चीर्णम् ॥ ६४ ॥",
        hindi = """
            यह ब्रह्मविद्या केवल उन्हीं को सिखानी चाहिए जो क्रियावान, वेदों के ज्ञाता और ब्रह्मनिष्ठ हैं।
            जो स्वयं श्रद्धापूर्वक एकर्षि अग्नि में आहुति देते हैं और जिन्होंने शिरोव्रत का पालन किया है।
            पात्रता के बिना दिया गया उच्च ज्ञान व्यर्थ हो जाता है और उसका दुरुपयोग भी हो सकता है।
            शिरोव्रत का अर्थ है—कठिन तप और अपने मन को पूरी तरह अनुशासित करने का संकल्प।
            ब्रह्मनिष्ठा वह योग्यता है जिसमें साधक ने ईश्वर को ही अपना अंतिम लक्ष्य मान लिया है।
            ऋषि यहाँ ज्ञान की पवित्रता और उसकी मर्यादा बनाए रखने का निर्देश देते हैं।
            यह मुण्डक उपनिषद का अंतिम उपदेश है जो शिष्य की तैयारी (Preparation) पर जोर देता है।
            गुरु और शिष्य दोनों का पवित्र होना ही ज्ञान के फलने-फूलने के लिए अनिवार्य है।
            यहाँ यह महान उपनिषद पूर्ण होता है, जो हमें अंधकार से प्रकाश की ओर ले जाता है।
            ॐ शांतिः शांतिः शांतिः—यह शांति पाठ ही इस दिव्य ज्ञान यात्रा का मधुर विश्राम है।
        """.trimIndent(),
        english = """
            This Brahmavidya should be taught only to those who are active, learned, and devoted.
            To those who faithfully offer oblations to the fire and have performed the Shiro-vrata.
            Higher knowledge given without eligibility is wasted and can even be misused.
            'Shiro-vrata' implies a vow of intense penance and total discipline of the mind.
            'Brahmanishtha' is the qualification where the seeker has made God his only goal.
            The Sage instructs here to maintain the sanctity and the dignity of this wisdom.
            This is the final teaching of the Mundaka Upanishad, emphasizing student preparation.
            The purity of both the Guru and the disciple is essential for wisdom to flourish.
            Here this great Upanishad concludes, leading us from darkness into absolute Light.
            OM Shanti Shanti Shanti—this peace invocation is the sweet rest of this divine journey.
        """.trimIndent()
    )
)