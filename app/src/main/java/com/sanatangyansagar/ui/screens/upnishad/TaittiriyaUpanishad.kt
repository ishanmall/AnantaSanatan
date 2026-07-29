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
data class TaittiriyaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaittiriyaUpanishadScreen() {
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
                // Supports 1 to 31 Anuvakas/Shlokas
                if (shlokaNumber != null && shlokaNumber in 1..31) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-31)") },
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
            itemsIndexed(taittiriyaShlokasList) { _, shloka ->
                TaittiriyaShlokaCard(shloka)
            }
        }
    }
}

@Composable
fun TaittiriyaShlokaCard(shloka: TaittiriyaShloka) {
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

// First 10 Shlokas (Anuvakas of Shikshavalli)
val taittiriyaShlokasList = listOf(
    TaittiriyaShloka(
        id = 1,
        sanskrit = "ॐ शं नो मित्रः शं वरुणः । शं नो भवत्वर्यमा । शं न इन्द्रो बृहस्पतिः । शं नो विष्णुरुरुक्रमः । नमो ब्रह्मणे । नमस्ते वायो । त्वमेव प्रत्यक्षं ब्रह्मासि । त्वामेव प्रत्यक्षं ब्रह्म वदिष्यामि । ऋतं वदिष्यामि । सत्यं वदिष्यामि । तन्मामवतु । तद्वक्तारमवतु । अवतु माम् । अवतु वक्तारम् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥ १ ॥",
        hindi = """
            मित्र देव हमारे लिए कल्याणकारी हों और वरुण देव हमारे लिए शांतिदायक हों।
            अर्यमा देव, इंद्र और बृहस्पति हमारे लिए शुभ और मंगलकारी सिद्ध हों।
            विशाल डग भरने वाले भगवान विष्णु हमारे लिए सभी दिशाओं में कल्याणकारी हों।
            उस परब्रह्म को मेरा नमस्कार है; हे वायु देव! आपको मेरा विशेष प्रणाम है।
            हे वायु! आप ही प्रत्यक्ष ब्रह्म हैं, इसलिए मैं आपको ही प्रत्यक्ष ब्रह्म कहूँगा।
            मैं ऋत (यथार्थ मानसिक सत्य) कहूँगा और मैं सत्य (वाणी का सत्य) ही कहूँगा।
            वह परब्रह्म मेरी रक्षा करे, और वह परब्रह्म मेरे गुरु (वक्ता) की भी रक्षा करे।
            मेरी रक्षा हो, मेरे गुरु की रक्षा हो ताकि ज्ञान का प्रवाह बिना बाधा के चलता रहे।
            यह शांति पाठ विद्या ग्रहण करने से पहले शरीर, मन और प्रकृति को शांत करता है।
            आध्यात्मिक ज्ञान के लिए गुरु और शिष्य दोनों का सुरक्षित और स्वस्थ होना अनिवार्य है।
        """.trimIndent(),
        english = """
            May Mitra be propitious to us, and may Varuna be propitious to us.
            May Aryaman be propitious to us; may Indra and Brihaspati be propitious.
            May Vishnu of wide strides be highly propitious and bring us total welfare.
            Salutations to Brahman; Salutations to You, O Vayu (the cosmic life-force).
            You indeed are the visible Brahman; I shall proclaim You as the visible Brahman.
            I shall speak the right (Rit) and I shall speak the absolute truth (Satya).
            May that Supreme Brahman protect me, and may That protect my teacher.
            Protect me, protect the speaker, so that the flow of wisdom remains unbroken.
            This peace invocation calms the body, mind, and nature before receiving knowledge.
            For spiritual learning, the safety and health of both guru and disciple are essential.
        """.trimIndent()
    ),

    TaittiriyaShloka(
        id = 2,
        sanskrit = "शीक्षां व्याख्यास्यामः । वर्णः स्वरः । मात्रा बलम् । साम सन्तानः । इत्युक्तः शीक्षाध्यायः ॥ २ ॥",
        hindi = """
            अब हम 'शिक्षा' (उच्चारण विज्ञान) के महत्वपूर्ण अंगों की स्पष्ट व्याख्या करेंगे।
            इसमें सबसे पहले 'वर्ण' (अक्षर) आते हैं, जो ध्वनियों का मूल आधार माने जाते हैं।
            फिर 'स्वर' (उदात्त, अनुदात्त, स्वरित) का ज्ञान आवश्यक है, जो मंत्रों की शक्ति है।
            'मात्रा' (ह्रस्व, दीर्घ, प्लुत) अक्षरों के उच्चारण में लगने वाले समय को निर्धारित करती है।
            'बल' उच्चारण के समय प्राण और वागिंद्रिय (Speech organs) के सही उपयोग को कहते हैं।
            'साम' का अर्थ है अक्षरों को बिना किसी दोष के समान और सुरीले रूप में बोलना।
            'सन्तान' का अर्थ है शब्दों को आपस में सही तरीके से जोड़कर (संधि करके) पढ़ना।
            इस प्रकार शिक्षा-अध्याय के इन छह प्रमुख अंगों का संक्षेप में वर्णन किया गया है।
            वेदांत में प्रवेश करने से पहले भाषा की पवित्रता और शुद्धता अत्यंत अनिवार्य है।
            गलत उच्चारण से मंत्र का अर्थ और उसकी ब्रह्मांडीय ऊर्जा दोनों ही नष्ट हो जाते हैं।
        """.trimIndent(),
        english = """
            We shall now expound the science of 'Shiksha' (Phonetics and Pronunciation).
            First is 'Varna' (letters/sounds), which form the basic foundation of all speech.
            Next is 'Svara' (accents/pitch), which provides the essential power to the mantras.
            'Matra' (measure/duration) determines the exact time taken to pronounce the syllables.
            'Bala' is the correct effort and use of vocal organs required for articulation.
            'Sama' means the even, uniform, and melodious pronunciation without any defects.
            'Santana' refers to the continuous and correct conjunction (Sandhi) of letters.
            Thus, the six main components of the chapter on phonetics have been briefly declared.
            Before entering Vedanta, the purity and accuracy of language are absolutely necessary.
            Incorrect pronunciation destroys both the meaning and the cosmic energy of the mantra.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 3,
        sanskrit = "सह नौ यशः । सह नौ ब्रह्मवर्चसम् । अथातः सहिताया उपनिषदं व्याख्यास्यामः । पञ्चस्वधिकरणेषु । अधिलोकमधिज्यौतिषमधिविद्यमधिप्रजमध्यात्मम् । ता महासहिता इत्याचक्षते ॥ ३ ॥",
        hindi = """
            हम दोनों (गुरु और शिष्य) का यश इस संसार में एक साथ चारों दिशाओं में फैले।
            हम दोनों का ब्रह्मवर्चस (ज्ञान का तेज) एक साथ और समान रूप से निरंतर बढ़ता रहे।
            अब हम 'संहिता' (जोड़ने वाली शक्तियों) के रहस्यमयी ज्ञान की पूरी व्याख्या करेंगे।
            यह संहिता का रहस्य मुख्य रूप से पांच अधिकरणों (विषयों) में विभाजित किया गया है।
            ये पांच विषय हैं: अधिलोक (लोकों के विषय में), अधिज्यौतिष (प्रकाशकों के विषय में)।
            अधिविद्य (विद्या के विषय में), अधिप्रज (संतान के विषय में) और अध्यात्म (शरीर के विषय में)।
            ज्ञानी जन इन पांचों विषयों के समन्वय को 'महासंहिता' के नाम से पुकारते हैं।
            यह श्लोक गुरु और शिष्य के बीच ज्ञान के सह-अस्तित्व और प्रेम को स्थापित करता है।
            ब्रह्मांड की हर चीज़ एक-दूसरे से जुड़ी हुई है, यही उपनिषदों का प्रमुख वैज्ञानिक सत्य है।
            संहिता ध्यान (Meditation on connections) से मनुष्य का दृष्टिकोण विशाल हो जाता है।
        """.trimIndent(),
        english = """
            May the glory of both of us (teacher and student) spread together in the world.
            May the brilliance of Brahman (spiritual radiance) grow in both of us simultaneously.
            Now we shall expound the secret doctrine of 'Samhita' (the science of conjunctions).
            This profound mystery of conjunctions is divided into five main categories.
            These are: Adhiloka (concerning worlds), Adhijyautisha (concerning luminaries).
            Adhividya (concerning knowledge), Adhipraja (concerning progeny), and Adhyatma (the self).
            The wise men refer to these five integrated contemplations as the 'Maha-Samhitas'.
            This verse establishes the coexistence, love, and shared growth of the guru and disciple.
            Everything in the universe is interconnected; this is the core scientific truth of Upanishads.
            Meditating on these conjunctions broadens a person's vision to a cosmic scale.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 4,
        sanskrit = "यश्छन्दसामृषभो विश्वरूपः । छन्दोभ्योऽध्यमृतात्सम्बभूव । स मेन्द्रो मेधया स्पृणोतु । अमृतस्य देव धारणो भूयासम् । शरीरं मे विचर्षणम् । जिह्वा मे मधुमत्तमा । कर्णाभ्यां भूरि विश्रुवम् । ब्रह्मणः कोशोऽसि मेधया पिहितः । श्रुतं मे गोपाय ॥ ४ ॥",
        hindi = """
            जो ओंकार (ॐ) सभी वेदों का सार है, जो विश्वरूप है और सबमें व्यापक रूप से स्थित है।
            जो अमर वेदों के भीतर से अमृत तत्व के रूप में साक्षात् उत्पन्न और प्रकट हुआ है।
            वह ओंकार रूपी परमेश्वर मुझे श्रेष्ठ मेधा (धारण करने वाली प्रखर बुद्धि) प्रदान करे।
            हे देव! मैं उस आत्मज्ञान रूपी अमरत्व को हमेशा के लिए धारण करने वाला बन सकूँ।
            मेरा शरीर इस ज्ञान की प्राप्ति और सेवा के लिए पूरी तरह से स्वस्थ और सक्षम रहे।
            मेरी जिह्वा (वाणी) अत्यंत मधुर हो, ताकि मैं सत्य को प्रेम और मिठास के साथ कह सकूँ।
            मैं अपने कानों से बहुत सारा पवित्र और श्रेष्ठ ज्ञान निरंतर सुनता रहूँ।
            हे ओंकार! आप लौकिक बुद्धि से ढके हुए परब्रह्म के असली आवरण (कोश) हैं।
            मेरे द्वारा सुने गए और समझे गए इस पवित्र ज्ञान की आप हमेशा रक्षा करें।
            यह श्लोक एक आदर्श विद्यार्थी की प्रार्थना है, जो शारीरिक और मानसिक बल मांगता है।
        """.trimIndent(),
        english = """
            May the Omkara (OM), which is the bull (essence) of the Vedas and possesses all forms.
            Which has emerged as the immortal essence from the immortal Vedic hymns.
            May that Supreme Lord in the form of OM invigorate me with supreme intelligence.
            O Lord! May I become a worthy bearer of the immortal knowledge of the Self.
            May my physical body remain healthy, active, and fully capable for this spiritual pursuit.
            May my tongue (speech) be exceedingly sweet, so I may speak the truth with love.
            May I continuously hear abundant sacred and supreme knowledge with my ears.
            O OM! You are the sheath of Brahman, concealed by ordinary worldly intellect.
            Please protect the sacred knowledge that I have heard and learned from my teacher.
            This verse is the prayer of an ideal student seeking physical and mental vigor for learning.
        """.trimIndent()
    ),

    TaittiriyaShloka(
        id = 5,
        sanskrit = "भूर्भुवः सुवरिति वा एतास्तिस्रो व्याहृतयः । तासामु ह स्मैतां चतुर्थीम् । माहाचमस्यः प्रवेदयते । मह इति । तद्ब्रह्म । स आत्मा । अङ्गान्यन्या देवताः । भूरिति वा अयं लोकः । भुव इत्यन्तरिक्षम् । सुवरित्यसौ लोकः । मह इत्यादित्यः । आदित्येन वाव सर्वे लोका महीयन्ते ॥ ५ ॥",
        hindi = """
            'भूः', 'भुवः', और 'सुवः'—निश्चित रूप से ये तीन प्रसिद्ध और पवित्र व्याहृतियां (शब्द) हैं।
            इन तीनों के अलावा, महाचमस के पुत्र (महर्षि महाचमस्य) ने एक चौथी व्याहृति की खोज की।
            वह चौथी व्याहृति 'महः' है। वास्तव में यही 'महः' साक्षात् परब्रह्म का ही स्वरूप है।
            यही 'महः' मुख्य आत्मा है, और अन्य सभी देवता (शक्तियां) केवल इसके अंग मात्र हैं।
            'भूः' यह पृथ्वी लोक है; 'भुवः' यह बीच का अंतरिक्ष लोक है, जहाँ वायु बहती है।
            'सुवः' वह ऊपर का स्वर्ग लोक है; और 'महः' स्वयं प्रकाशमान आदित्य (सूर्य) है।
            इस सूर्य (आदित्य) के द्वारा ही ये सभी लोक महिमावान और प्रकाशित होते हैं।
            इन रहस्यमयी शब्दों का ध्यान करने से साधक की चेतना का भारी विस्तार होता है।
            यह श्लोक सृष्टि की संरचना को ध्वनियों (Vibrations) के माध्यम से समझाता है।
            ब्रह्म को केवल एक विचार नहीं, बल्कि ब्रह्मांड के केंद्र के रूप में स्थापित किया गया है।
        """.trimIndent(),
        english = """
            'Bhuh', 'Bhuvah', and 'Suvah'—these are indeed the three famous sacred utterances.
            Besides these three, the son of Mahachamas discovered a fourth mystical utterance.
            That fourth utterance is 'Mahah'. Indeed, this 'Mahah' is Brahman itself.
            This 'Mahah' is the principal Self, and all other deities are merely its limbs.
            'Bhuh' represents this terrestrial world (Earth); 'Bhuvah' is the intermediate space.
            'Suvah' represents the celestial world (Heaven); and 'Mahah' is the Sun (Aditya).
            It is entirely by the Sun that all these worlds are glorified and illuminated.
            Meditating on these mystical words causes a massive expansion of the seeker's consciousness.
            This verse explains the structure of creation through the medium of sound vibrations.
            Brahman is established not just as an idea, but as the pulsating center of the cosmos.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 6,
        sanskrit = "स य एषोऽन्तर्हृदय आकाशः । तस्मिन्नयं पुरुषो मनोमयः । अमृतो हिरण्मयः । अन्तरेण तालुके । य एष स्तन इवावलम्बते । सेन्द्रयोनिः । यत्रासौ केशान्तो विवर्तते । व्यपोह्य शीर्षकपाले । भूरित्यग्नौ प्रतितिष्ठति । भुव इति वायौ ॥ ६ ॥",
        hindi = """
            हृदय के भीतर जो यह सूक्ष्म आकाश है, उसी में यह मनोमय (मन रूपी) पुरुष स्थित है।
            वह परम पुरुष पूर्ण रूप से अमृत (मरण-रहित) और हिरण्मय (सुवर्ण के समान प्रकाशमान) है।
            तालू के बीच में जो यह मांस-पिंड (Uvula) स्तन के समान नीचे की ओर लटकता है।
            यही 'इन्द्रयोनि' (सुषुम्ना नाड़ी का मार्ग) है, जहाँ से चेतना ऊपर की ओर यात्रा करती है।
            जहाँ सिर के बाल अलग होते हैं (ब्रह्मरन्ध्र), वहां वह खोपड़ी के कपाल को भेदकर निकलता है।
            ब्रह्मरन्ध्र को भेदकर निकलने वाला योगी 'भूः' के रूप में अग्नि में प्रतिष्ठित होता है।
            और वह 'भुवः' व्याहृति के रूप में वायु देव के भीतर पूरी तरह से प्रतिष्ठित हो जाता है।
            यह श्लोक योग और कुंडलिनी जागरण की अत्यंत गुप्त और वैज्ञानिक प्रक्रिया को बताता है।
            हृदय से लेकर मस्तिष्क तक की यह यात्रा ही चेतना के विकास का असली मार्ग है।
            ध्यान के माध्यम से साधक इसी मार्ग से पंचभूतों पर अपना पूर्ण नियंत्रण प्राप्त करता है।
        """.trimIndent(),
        english = """
            In this subtle space which is within the heart, resides this Person consisting of mind.
            That Supreme Person is absolutely immortal and golden (luminous with pure light).
            Between the palates, there hangs a piece of flesh like a nipple (the uvula).
            This is the 'Indrayoni' (the path of Sushumna), where consciousness travels upward.
            Where the roots of the hair divide (Brahmarandhra), it exits by piercing the skull.
            The Yogi emerging through this Brahmarandhra is established in Fire as 'Bhuh'.
            And he becomes completely established in the Air as the mystic utterance 'Bhuvah'.
            This verse reveals the highly secret and scientific process of Yoga and Kundalini.
            This upward journey from the heart to the brain is the true path of conscious evolution.
            Through meditation on this path, the seeker gains mastery over the physical elements.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 7,
        sanskrit = "पृथिव्यन्तरिक्षं द्यौर्दिशोऽवान्तरदिशाः । अग्निर्वायुरादित्यश्चन्द्रमा नक्षत्राणि । आप ओषधयो वनस्पतय आकाश आत्मा । इत्यधिभूतम् । अथाध्यात्मम् । प्राणो व्यानोऽपान उदानः समानः । चक्षुः श्रोत्रं मनो वाक् त्वक् । चर्म मासँ स्नावास्थि मज्जा । एतदधिविधाय ऋषिरवोचत् । पाङ्क्तं वा इदँ सर्वम् । पाङ्क्तेनैव पाङ्क्तँ स्पृणोतीति ॥ ७ ॥",
        hindi = """
            पृथ्वी, अंतरिक्ष, द्युलोक (स्वर्ग), मुख्य दिशाएं और उप-दिशाएं—यह लोकों का पांचवां समूह है।
            अग्नि, वायु, सूर्य, चंद्रमा और नक्षत्र—यह देवताओं (प्रकाशकों) का पांचवां समूह है।
            जल, औषधियां, वनस्पतियां, आकाश और भौतिक शरीर (आत्मा)—यह पंचभूतों का समूह है।
            यह सब बाहरी (अधिभूत) जगत है। अब शरीर के भीतर (अध्यात्म) के समूहों को सुनो।
            प्राण, व्यान, अपान, उदान और समान—यह पांच प्रकार की आंतरिक वायु का समूह है।
            आँख, कान, मन, वाणी और त्वचा—यह ज्ञान और कर्म के साधनों का पांचवां समूह है।
            त्वचा, मांस, स्नायु, हड्डी और मज्जा—यह शरीर के निर्माणक तत्वों का पांचवां समूह है।
            इन सबको जानकर ऋषि ने कहा था: 'यह संपूर्ण जगत पांच-पांच के समूहों (पाङ्क्त) का बना है।'
            बाहरी पांच के समूहों से ही मनुष्य भीतरी पांच के समूहों को पोषण और शक्ति प्रदान करता है।
            यह श्लोक पिंड (Microcosm) और ब्रह्मांड (Macrocosm) के बीच की गहरी समरूपता दिखाता है।
        """.trimIndent(),
        english = """
            Earth, intermediate space, heaven, primary quarters, and sub-quarters—a group of five.
            Fire, air, sun, moon, and stars—this is the pentad of deities (luminaries).
            Water, herbs, trees, space, and the physical body—this is the pentad of material elements.
            This is the external (Adhibhuta) world. Now hear about the internal (Adhyatma) groups.
            Prana, Vyana, Apana, Udana, and Samana—this is the group of five internal vital breaths.
            Eye, ear, mind, speech, and touch—this is the pentad of the instruments of perception.
            Skin, flesh, muscle, bone, and marrow—this is the pentad of bodily constituents.
            Having analyzed this, the sage declared: 'This entire universe is fivefold (Pankta).'
            Through the external fivefold sets, one nourishes and sustains the internal fivefold sets.
            This verse demonstrates the profound symmetry between the microcosm and the macrocosm.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 8,
        sanskrit = "ओमिति ब्रह्म । ओमितीदँ सर्वम् । ओमित्येतदनुकृति ह स्म वा अप्योश्रावयेत्याश्रावयन्ति । ओमिति सामानि गायन्ति । ओँ शोमिति शस्त्राणि शँसन्ति । ओमित्यध्वर्युः प्रतिगरं प्रतिगृणाति । ओमिति ब्रह्मा प्रसौति । ओमित्यग्निहोत्रमनुजानाति । ओमिति ब्राह्मणः प्रवक्ष्यन्नाह ब्रह्मोपाप्नवानीति । ब्रह्मैवोपाप्नोति ॥ ८ ॥",
        hindi = """
            'ॐ' ही साक्षात् परब्रह्म है। यह जो कुछ भी दृश्य और अदृश्य है, वह सब 'ॐ' ही है।
            'ॐ' यह सहमति (स्वीकृति) का शब्द है; यज्ञ में इसी से श्रवण और आज्ञा दी जाती है।
            सामवेद के गायक 'ॐ' का उच्चारण करके ही अपने मधुर साम-गानों को आरंभ करते हैं।
            'ॐ शोम्' कहकर ही ऋग्वेद के होता (पुजारी) अपने शास्त्रों और मंत्रों का पाठ करते हैं।
            'ॐ' कहकर ही अध्वर्यु (यजुर्वेद का पुरोहित) यज्ञ के सभी कार्यों में अपनी सहमति देता है।
            'ॐ' कहकर ही मुख्य ब्रह्मा (यज्ञ का अध्यक्ष) अनुष्ठान शुरू करने की आज्ञा प्रदान करता है।
            'ॐ' कहकर ही अग्निहोत्र (हवन) करने की अंतिम अनुमति और दिशा दी जाती है।
            वेदाध्ययन शुरू करने से पहले ब्राह्मण 'ॐ' कहता है, यह सोचकर कि 'मैं ब्रह्म को प्राप्त करूँ।'
            और इस पवित्र 'ॐ' के निरंतर अभ्यास से वह निश्चय ही परब्रह्म को प्राप्त कर लेता है।
            यह श्लोक वैदिक परंपरा में ओंकार (OM) की सर्वव्यापकता और उसकी व्यावहारिक शक्ति को बताता है।
        """.trimIndent(),
        english = """
            'OM' is indeed Brahman. All this, visible and invisible, is nothing but 'OM'.
            'OM' is a word of assent and compliance; in sacrifices, commands are issued with it.
            The singers of the Samaveda begin their melodious chants by first uttering 'OM'.
            Uttering 'OM Shom', the priests of Rigveda recite their scriptures and sacred mantras.
            Saying 'OM', the Adhvaryu (priest of Yajurveda) gives his encouraging response in rituals.
            Saying 'OM', the Brahma (chief presiding priest) grants permission to start the sacrifice.
            Saying 'OM', the performer gives the final assent to begin the Agnihotra oblation.
            A Brahmin begins reciting Vedas saying 'OM', with the thought 'May I attain Brahman.'
            And through the continuous practice of this sacred 'OM', he certainly attains Brahman.
            This verse explains the omnipresence and the practical power of OM in Vedic traditions.
        """.trimIndent()
    ),

    TaittiriyaShloka(
        id = 9,
        sanskrit = "ऋतं च स्वाध्यायप्रवचने च । सत्यं च स्वाध्यायप्रवचने च । तपश्च स्वाध्यायप्रवचने च । दमश्च स्वाध्यायप्रवचने च । शमश्च स्वाध्यायप्रवचने च । अग्नयश्च स्वाध्यायप्रवचने च । अग्निहोत्रं च स्वाध्यायप्रवचने च । अतिथयश्च स्वाध्यायप्रवचने च । मानुषं च स्वाध्यायप्रवचने च । प्रजा च स्वाध्यायप्रवचने च । प्रजनश्च स्वाध्यायप्रवचने च । प्रजातिश्च स्वाध्यायप्रवचने च ॥ ९ ॥",
        hindi = """
            यथार्थ मानसिक सत्य (ऋत) का पालन करो; साथ ही वेदों का अध्ययन और प्रवचन करते रहो।
            वाणी के सत्य का पालन करो; साथ ही वेदों का अध्ययन और दूसरों को उपदेश करते रहो।
            कठोर तपस्या का आचरण करो; साथ ही अपना स्वाध्याय और प्रवचन का नियम बनाए रखो।
            इंद्रियों का दमन (नियंत्रण) करो; साथ ही शास्त्रों का अध्ययन और उनका ज्ञान बाँटते रहो।
            मन को पूरी तरह शांत (शम) रखो; साथ ही स्वाध्याय और ज्ञान-प्रसार का कार्य करते रहो।
            पवित्र अग्नियों की स्थापना करो; साथ ही वेद-मन्त्रों का निरंतर अभ्यास करते रहो।
            अग्निहोत्र (हवन) संपन्न करो; साथ ही स्वाध्याय और प्रवचन में अपना पूरा मन लगाओ।
            अतिथियों का सत्कार करो; और इसके साथ भी वेदों का अध्ययन और शिक्षण जारी रखो।
            मनुष्योचित (लौकिक) कर्तव्यों को निभाओ; साथ ही अध्ययन और प्रवचन कभी मत छोड़ो।
            संतान, प्रजन और वंश-वृद्धि के धर्म का पालन करते हुए भी स्वाध्याय और प्रवचन करते रहो।
        """.trimIndent(),
        english = """
            Practice the mental truth (Rit); along with the study and teaching of the Vedas.
            Practice the truth in speech (Satya); along with the study and teaching of the Vedas.
            Practice severe austerities (Tapas); along with your self-study and giving discourses.
            Control your external senses (Dama); along with the study and sharing of scriptures.
            Keep the mind completely tranquil (Shama); along with self-study and spreading wisdom.
            Maintain the sacred fires; along with the continuous practice of the Vedic mantras.
            Perform the Agnihotra oblations; while fully engaging in self-study and teaching.
            Serve the guests with hospitality; and alongside this, continue learning and teaching.
            Fulfill your normal human (social) duties; and never abandon study and discourses.
            Fulfill the duties of procreation and family; while consistently studying and teaching.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 10,
        sanskrit = "अहं वृक्षस्य रेरिवा । कीर्तिः पृष्ठं गिरेरिव । ऊर्ध्वपवित्रो वाजिनीव स्वमृतमस्मि । द्रविणँ सवर्चसम् । सुमेधा अमृतोक्षितः । इति त्रिशङ्कोर्वेदानुवचनम् ॥ १० ॥",
        hindi = """
            (आत्मज्ञान प्राप्ति के बाद त्रिशंकु ऋषि की गर्जना): 'मैं इस संसार रूपी वृक्ष को हिलाने वाला हूँ।'
            'मेरी कीर्ति (प्रसिद्धि) एक विशाल पर्वत के ऊँचे शिखर के समान महान और विस्तृत है।'
            'मैं ऊर्ध्वपवित्र (परमात्मा में शुद्ध) हूँ, जैसे सूर्य में पवित्र और अमृतमय तत्व निवास करता है।'
            'मैं वह अद्वितीय अमृत हूँ जो साक्षात् प्रकाशमान है और जो कभी भी नष्ट नहीं होता।'
            'मैं ही तेज से युक्त, सुवर्ण के समान चमकता हुआ परम ऐश्वर्य (आध्यात्मिक धन) हूँ।'
            'मैं सुमेधा (उत्तम बुद्धि वाला) हूँ और मैं अमरता के रस से पूरी तरह सिंचित (अमृतोक्षित) हूँ।'
            यह महान और ओजस्वी कथन महर्षि त्रिशंकु का वेदानुवचन (आत्म-साक्षात्कार का उद्घोष) है।
            जब साधक को अपनी आत्मा और ब्रह्म की एकता का बोध होता है, तो सारा भय खत्म हो जाता है।
            यह श्लोक 'मैं शरीर नहीं, मैं ही यह संपूर्ण ब्रह्मांड हूँ' इस सर्वोच्च अद्वैत भाव को दर्शाता है।
            ज्ञान की पूर्णता मनुष्य को एक ऐसी असीम शक्ति से भर देती है जो दुनिया को हिला सकती है।
        """.trimIndent(),
        english = """
            (Sage Trishanku's declaration after Self-realization): 'I am the invigorator of the tree of the world.'
            'My glory and fame are as great and exalted as the high peak of a vast mountain.'
            'I am pure at my Source, just as the immortal and pure essence dwells in the Sun.'
            'I am that unique, luminous immortal essence which never suffers destruction.'
            'I am the supreme wealth (spiritual opulence), fully endowed with shining brilliance.'
            'I am of excellent intelligence (Sumedha) and fully sprinkled with the nectar of immortality.'
            This grand and powerful declaration is the post-illumination statement of Sage Trishanku.
            When a seeker realizes the unity of his Soul and Brahman, all fear is destroyed.
            This verse reflects the highest non-dual feeling: 'I am not the body; I am the universe.'
            The perfection of knowledge fills a person with boundless power that can move the world.
        """.trimIndent()
    ),
    // ... Continuing taittiriyaShlokasList from ID 11


    TaittiriyaShloka(
        id = 11,
        sanskrit = "वेदमनूच्याचार्योऽन्तेवासिनमनुशास्ति । सत्यं वद । धर्मं चर । स्वाध्यायान्मा प्रमदः । आचार्याय प्रियं धनमाहृत्य प्रजातन्तुं मा व्यवच्छेत्सीः । सत्यान्न प्रमदितव्यम् । धर्मान्न प्रमदितव्यम् । कुशलान्न प्रमदितव्यम् । भूत्यै न प्रमदितव्यम् । स्वाध्यायप्रवचनाभ्यां न प्रमदितव्यम् ॥ देवपितृकार्याभ्यां न प्रमदितव्यम् । मातृदेवो भव । पितृदेवो भव । आचार्यदेवो भव । अतिथिदेवो भव । यान्यनवद्यानि कर्माणि । तानि सेवितव्यानि । नो इतराणि । यान्यस्माकँ सुचरितानि । तानि त्वयोपास्यानि । नो इतराणि ॥ ११ ॥",
        hindi = """
            वेदों का ज्ञान देने के बाद आचार्य अपने शिष्यों को दीक्षा (उपदेश) देते हैं।
            'सत्य बोलो, धर्म का आचरण करो और अपने स्वाध्याय में कभी आलस्य मत करो।'
            'गुरु को उनकी प्रिय दक्षिणा देकर गृहस्थ जीवन अपनाओ और वंश परंपरा को मत तोड़ो।'
            'सत्य, धर्म और अपनी कुशलता (कल्याण) के कार्यों से कभी भी विमुख मत होना।'
            'भौतिक समृद्धि (धन) और ज्ञान के प्रचार-प्रसार के कर्तव्य से भी मत चूकना।'
            'देवताओं और पितरों के प्रति अपने दायित्वों को निभाने में कभी प्रमाद मत करना।'
            'माता को देवता मानो, पिता को देवता मानो, गुरु और अतिथि को भी देवता मानो।'
            'जो कर्म निर्दोष हैं, केवल उन्हीं का आचरण करना; निंदनीय कर्मों का कभी नहीं।'
            'गुरुओं के केवल अच्छे आचरणों का ही पालन करना चाहिए, उनके दोषों का नहीं।'
            यह प्राचीन दीक्षांत समारोह का उपदेश है जो नैतिकता और जीवन मूल्यों को स्थापित करता है।
        """.trimIndent(),
        english = """
            Having taught the Vedas, the preceptor imparts this final instruction to the students.
            'Speak the truth, practice righteousness, and never neglect your self-study.'
            'Offer the desired wealth to the teacher, enter family life, and do not cut the lineage.'
            'Never deviate from the truth, from Dharma, and from activities that ensure your welfare.'
            'Do not neglect your material prosperity nor your duty to study and teach the scriptures.'
            'Never be careless in performing your sacred duties towards the gods and ancestors.'
            'Treat your mother as God, your father as God, your teacher and your guest as God.'
            'Only those actions which are flawless and blameless should be performed, none else.'
            'You must follow only the good deeds of your teachers, and never their faults.'
            This is the ancient convocation address establishing supreme ethics and life values.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 12,
        sanskrit = "शं नो मित्रः शं वरुणः । शं नो भवत्वर्यमा । शं न इन्द्रो बृहस्पतिः । शं नो विष्णुरुरुक्रमः । नमो ब्रह्मणे । नमस्ते वायो । त्वमेव प्रत्यक्षं ब्रह्मासि । त्वामेव प्रत्यक्षं ब्रह्मावादिषम् । ऋतमवादिषम् । सत्यमवादिषम् । तन्मामावीत् । तद्वक्तारमावीत् । आवीन्माम् । आवीद्वक्तारम् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥ १२ ॥",
        hindi = """
            (शिक्षावल्ली के अंत में शांति पाठ दोहराया जाता है): मित्र देव हमारे लिए शांतिदायक हों।
            वरुण, अर्यमा, इंद्र, बृहस्पति और विशाल कदम वाले भगवान विष्णु हमारे लिए कल्याणकारी हों।
            परब्रह्म को मेरा नमस्कार है; हे वायु देव! आपको मेरा विशेष प्रणाम है।
            हे वायु! आप ही प्रत्यक्ष ब्रह्म हैं, इसलिए मैंने आपको ही प्रत्यक्ष ब्रह्म कहा है।
            मैंने यथार्थ मानसिक सत्य (ऋत) कहा है और मैंने वाणी के सत्य को ही बोला है।
            उस परब्रह्म ने मेरी रक्षा की है, और उस परब्रह्म ने मेरे गुरु की भी रक्षा की है।
            मेरी रक्षा हुई है, मेरे गुरु की रक्षा हुई है, जिससे यह ज्ञान बिना बाधा के पूर्ण हुआ।
            यह श्लोक कृतज्ञता का प्रतीक है कि बिना किसी विघ्न के शिक्षा का पहला भाग संपन्न हुआ।
            अध्ययन के प्रारंभ और अंत में शांति पाठ करना वैदिक शिक्षा की महान परंपरा है।
            ॐ शांतिः शांतिः शांतिः—यह तीन बार की शांति हमारे शरीर, मन और आत्मा को स्थिर करती है।
        """.trimIndent(),
        english = """
            (The peace chant is repeated at the end of Shikshavalli): May Mitra be propitious to us.
            May Varuna, Aryaman, Indra, Brihaspati, and the wide-striding Vishnu bring us welfare.
            Salutations to Brahman; Salutations to You, O Vayu (the cosmic life-force).
            You indeed are the visible Brahman; therefore, I have proclaimed You as the visible Brahman.
            I have spoken the right (Rit) and I have spoken the absolute truth (Satya).
            That Supreme Brahman has protected me, and That has protected my teacher.
            I have been protected, my teacher has been protected, bringing this study to completion.
            This verse is a symbol of gratitude that the first part of learning finished without obstacles.
            Chanting peace prayers at the beginning and end of study is a great Vedic tradition.
            OM Shanti Shanti Shanti—this threefold peace stabilizes our body, mind, and soul.
        """.trimIndent()
    ),

    TaittiriyaShloka(
        id = 13,
        sanskrit = "ॐ ब्रह्मविदाप्नोति परम् । तदेषाऽभ्युक्ता । सत्यं ज्ञानमनन्तं ब्रह्म । यो वेद निहितं गुहायां परमे व्योमन् । सोऽश्नुते सर्वान् कामान् सह । ब्रह्मणा विपश्चितेति ॥ तस्माद्वा एतस्मादात्मन आकाशः सम्भूतः । आकाशाद्वायुः । वायोरग्निः । अग्नेरापः । अद्भ्यः पृथिवी । पृथिव्या ओषधयः । ओषधीभ्योऽन्नम् । अन्नात् पुरुषः । स वा एष पुरुषोऽन्नरसमयः ॥ १३ ॥",
        hindi = """
            'ब्रह्म को जानने वाला परब्रह्म को प्राप्त कर लेता है।' यह ब्रह्मानंदवल्ली का मूल संदेश है।
            ब्रह्म सत्य (अस्तित्व), ज्ञान (चेतना) और अनंत (सीमा रहित) है, यही उसका असली स्वरूप है।
            जो उस ब्रह्म को अपनी हृदय रूपी गुफा के परम आकाश में पूरी तरह जान लेता है।
            वह उस सर्वज्ञ ब्रह्म के साथ एक होकर अपनी सभी कामनाओं और असीम सुख को प्राप्त कर लेता है।
            उस परम आत्मा से सबसे पहले आकाश की उत्पत्ति हुई; और आकाश से वायु उत्पन्न हुई।
            वायु से अग्नि, अग्नि से जल, जल से पृथ्वी और पृथ्वी से सभी औषधियां (वनस्पतियां) उत्पन्न हुईं।
            औषधियों से अन्न उत्पन्न हुआ और उस अन्न से ही यह मनुष्य (स्थूल शरीर) उत्पन्न हुआ है।
            यह मनुष्य वास्तव में 'अन्नरसमय' है, यानी यह भोजन के रस से बना हुआ भौतिक आवरण है।
            यह श्लोक अन्नमय कोश (Physical Body) की उत्पत्ति और सृष्टि के क्रम को बताता है।
            ब्रह्मांड के सभी तत्व हमारे शरीर में मौजूद हैं, इसलिए हम ब्रह्मांड का ही एक छोटा रूप हैं।
        """.trimIndent(),
        english = """
            'The knower of Brahman attains the Supreme.' This is the core message of Brahmanandavalli.
            Brahman is Truth (Existence), Knowledge (Consciousness), and Infinite; this is Its true nature.
            He who realizes that Brahman hidden in the supreme space of the cave of his heart.
            He attains all his desires and infinite bliss in complete union with the omniscient Brahman.
            From that Supreme Self, space (Akasha) was born; and from space, air (Vayu) was born.
            From air came fire, from fire came water, from water came earth, and from earth came herbs.
            From herbs came food, and from that food, this human being (the physical body) was born.
            This human is indeed 'Annarasamaya', meaning he is a physical sheath made of the essence of food.
            This verse explains the sequence of creation and the origin of the Annamaya Kosha (Physical Body).
            All elements of the cosmos are present in our body, making us a microcosm of the universe.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 14,
        sanskrit = "अन्नाद्वै प्रजाः प्रजायन्ते । याः काश्च पृथिवीँ श्रिताः । अथो अन्नेनैव जीवन्ति । अथैनदपि यन्त्यन्ततः । अन्नँ हि भूतानां ज्येष्ठम् । तस्मात् सर्वौषधमुच्यते । सर्वं वै तेऽन्नमाप्नुवन्ति । येऽन्नं ब्रह्मोपासते । ... तस्माद्वा एतस्मादन्नरसमयात् । अन्योऽन्तर आत्मा प्राणमयः । तेनैष पूर्णः ॥ १४ ॥",
        hindi = """
            पृथ्वी पर जो भी प्रजाएं (जीव) निवास करती हैं, वे सभी निश्चित रूप से अन्न से ही उत्पन्न होती हैं।
            उत्पन्न होने के बाद वे अन्न से ही जीवित रहती हैं और अंत में मृत्यु के बाद अन्न (मिट्टी) में ही मिल जाती हैं।
            अन्न सभी भौतिक प्राणियों में सबसे ज्येष्ठ (प्रथम) है, इसलिए इसे सभी जीवों की परम औषधि कहा जाता है।
            जो लोग अन्न को ही ब्रह्म मानकर उसकी उपासना करते हैं, वे सभी प्रकार के अन्नों को प्राप्त कर लेते हैं।
            किंतु इस भौतिक 'अन्नमय कोश' के भीतर एक और सूक्ष्म आत्मा है, जिसे 'प्राणमय कोश' कहते हैं।
            यह प्राणमय कोश शरीर के भीतर व्याप्त है और इसने अन्नमय कोश को पूरी तरह से भरा हुआ है।
            यह प्राण (ऊर्जा) ही भौतिक शरीर को आकार और गति प्रदान करता है, जिससे वह जीवित दिखता है।
            साधक को शरीर (अन्न) से अपनी दृष्टि हटाकर अपने प्राणों (श्वास और ऊर्जा) की ओर ध्यान ले जाना चाहिए।
            यह श्लोक भौतिक जगत से चेतना के दूसरे स्तर (ऊर्जा) की ओर आध्यात्मिक यात्रा का वर्णन करता है।
            भोजन शरीर का ईंधन है, किंतु प्राण वह असली शक्ति है जो उस ईंधन को जलाकर जीवन चलाती है।
        """.trimIndent(),
        english = """
            All creatures that dwell on the earth are certainly born from food alone.
            After being born, they live strictly by food, and in the end, they merge back into food (earth).
            Food is the eldest (firstborn) among all physical beings; hence it is called the universal medicine.
            Those who worship food as Brahman obtain all kinds of food and material nourishment.
            But inside this physical 'Annamaya Kosha', there is another subtle self called the 'Pranamaya Kosha'.
            This sheath of vital energy pervades the inside of the physical body and completely fills it.
            It is this Prana (energy) that gives shape and mobility to the physical body, keeping it alive.
            A seeker must shift his focus from the physical body (food) to his vital forces (breath and energy).
            This verse describes the spiritual journey from the physical world to the second level of consciousness.
            Food is the fuel of the body, but Prana is the true power that burns this fuel to drive life.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 15,
        sanskrit = "प्राणं देवा अनु प्राणन्ति । मनुष्याः पशवश्च ये । प्राणो हि भूतानामायुः । तस्मात् सर्वायुषमुच्यते । ... तस्माद्वा एतस्मात् प्राणमयात् । अन्योऽन्तर आत्मा मनोमयः । तेनैष पूर्णः । स वा एष पुरुषविध एव ॥ १५ ॥",
        hindi = """
            देवता, मनुष्य और पशु—ये सभी उस प्राण (ऊर्जा) के आधार पर ही श्वास लेते और जीवित रहते हैं।
            प्राण ही समस्त प्राणियों की असली आयु (जीवनकाल) है, इसलिए इसे सबकी संपूर्ण आयु कहा जाता है।
            जो प्राण को ब्रह्म जानकर उसकी उपासना करते हैं, वे पूर्ण आयु प्राप्त करते हैं और स्वस्थ रहते हैं।
            किंतु इस 'प्राणमय कोश' के भीतर भी एक और सूक्ष्म आत्मा है, जिसे 'मनोमय कोश' कहा जाता है।
            यह मनोमय कोश प्राणमय कोश के भीतर व्याप्त है और इसने प्राणमय कोश को पूरी तरह भरा हुआ है।
            यह मन ही है जो प्राणों को निर्देशित करता है और हमारी इच्छाओं और भावनाओं का केंद्र है।
            मन का स्वरूप भी मनुष्य के आकार जैसा ही है, जो शरीर के हर हिस्से में विचार और संवेदना भेजता है।
            विचार, संकल्प और विकल्प इसी मनोमय कोश से उत्पन्न होते हैं, जो हमें बाहरी दुनिया से जोड़ते हैं।
            साधक को ऊर्जा (प्राण) से भी गहरे उतरकर अपने मन (विचारों) के स्रोत पर ध्यान केंद्रित करना चाहिए।
            यह श्लोक चेतना के तीसरे और अधिक सूक्ष्म स्तर का परिचय देता है जो हमारी मनोवैज्ञानिक दुनिया है।
        """.trimIndent(),
        english = """
            Gods, men, and animals—all breathe and remain alive entirely on the basis of Prana (energy).
            Prana is the true lifespan of all beings; hence it is called the universal and complete life.
            Those who worship Prana as Brahman attain a full lifespan and remain completely healthy.
            But inside this 'Pranamaya Kosha', there is yet another subtle self called the 'Manomaya Kosha'.
            This mental sheath pervades the inside of the vital sheath and completely fills it up.
            It is the mind that directs the vital energies and serves as the center of our desires and emotions.
            The mind also takes the shape of the human form, sending thoughts and sensations to every part.
            Thoughts, resolves, and doubts originate from this mental sheath, connecting us to the outer world.
            A seeker must dive deeper than energy (Prana) and focus on the source of his mind (thoughts).
            This verse introduces the third, much subtler level of consciousness, which is our psychological world.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 16,
        sanskrit = "यतो वाचो निवर्तन्ते । अप्राप्य मनसा सह । आनन्दं ब्रह्मणो विद्वान् । न बिभेति कदाचनेति । तस्यैष एव शारीर आत्मा । यः पूर्वस्य । तस्माद्वा एतस्मान्मनोमयात् । अन्योऽन्तर आत्मा विज्ञानमयः । तेनैष पूर्णः ॥ १६ ॥",
        hindi = """
            जहाँ से वाणी उसे प्राप्त किए बिना मन के साथ ही असमर्थ होकर वापस लौट आती है।
            उस ब्रह्म के असीम आनंद को जानने वाला विद्वान फिर कभी भी किसी भी वस्तु से भयभीत नहीं होता।
            यह मनोमय कोश वास्तव में उस प्राणमय कोश की ही आंतरिक आत्मा है।
            किंतु इस 'मनोमय कोश' के भीतर भी एक और अत्यंत सूक्ष्म आत्मा है, जिसे 'विज्ञानमय कोश' कहते हैं।
            यह विज्ञानमय कोश मन के भीतर व्याप्त है और इसने मनोमय कोश को पूरी तरह से भरा हुआ है।
            विज्ञानमय कोश हमारी बुद्धि, विवेक, निर्णय लेने की क्षमता और सत्य-असत्य को पहचानने का केंद्र है।
            मन चंचल होता है और हमेशा संदेह करता है, जबकि बुद्धि (विज्ञान) स्थिर और निश्चयात्मक होती है।
            साधक को अपने भटकते हुए मन से परे जाकर अपनी शुद्ध बुद्धि (Intellect) में स्थापित होना चाहिए।
            यह श्लोक हमारी चेतना के चौथे स्तर को खोलता है, जहाँ लौकिक ज्ञान आध्यात्मिक प्रज्ञा में बदलता है।
            जब बुद्धि शुद्ध होती है, तभी वह आत्मा के आनंद को ग्रहण करने और भय से मुक्त होने में सक्षम होती है।
        """.trimIndent(),
        english = """
            That from which speech, along with the mind, turns back completely unable to reach It.
            The wise one who knows the infinite bliss of that Brahman never fears anything at all.
            This mental sheath is actually the inner self of the preceding vital sheath (Pranamaya).
            But inside this 'Manomaya Kosha', there is another exceedingly subtle self called the 'Vijnanamaya Kosha'.
            This sheath of intellect pervades the inside of the mental sheath and completely fills it up.
            The Vijnanamaya Kosha is the center of our intellect, discernment, decision-making, and judgment.
            The mind is restless and always doubts, whereas the intellect (Vijnana) is steady and determinative.
            A seeker must transcend his wandering mind and become established in his pure intellect.
            This verse unveils the fourth level of our consciousness, where worldly knowledge turns into spiritual wisdom.
            Only when the intellect is pure is it capable of receiving the bliss of the Self and becoming fearless.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 17,
        sanskrit = "विज्ञानं यज्ञं तनुते । कर्माणि तनुतेऽपि च । विज्ञानं देवाः सर्वे । ब्रह्म ज्येष्ठमुपासते । ... तस्माद्वा एतस्माद्विज्ञानमयात् । अन्योऽन्तर आत्मानन्दमयः । तेनैष पूर्णः । स वा एष पुरुषविध एव । तस्य प्रियमेव शिरः । मोदो दक्षिणः पक्षः । प्रमोद उत्तरः पक्षः । आनन्द आत्मा । ब्रह्म पुच्छं प्रतिष्ठा ॥ १७ ॥",
        hindi = """
            विज्ञान (बुद्धि) ही सभी लौकिक और आध्यात्मिक यज्ञों का विस्तार करता है और सभी कर्मों को चलाता है।
            सभी देवता उस विज्ञान को ही सबसे श्रेष्ठ ब्रह्म मानकर उसकी निरंतर उपासना करते हैं।
            बुद्धि (विज्ञान) की शुद्धि से मनुष्य अपने पापों को पीछे छोड़कर अपने सभी मनोरथ पूर्ण कर लेता है।
            किंतु इस 'विज्ञानमय कोश' के भीतर भी एक और परम सूक्ष्म आत्मा है, जिसे 'आनंदमय कोश' कहते हैं।
            यह आनंदमय कोश बुद्धि के भीतर व्याप्त है और इसने विज्ञानमय कोश को पूरी तरह से भरा हुआ है।
            यह आनंदमय कोश भी मनुष्य के आकार का ही है; 'प्रिय' (इच्छा पूर्ति की खुशी) इसका सिर है।
            'मोद' (सुखद प्राप्ति) इसका दाहिना पंख है, और 'प्रमोद' (अत्यधिक सुख) इसका बायां पंख है।
            'आनंद' इसका मध्य भाग (आत्मा) है, और स्वयं परब्रह्म इसकी पूंछ (स्थायी और मूल आधार) है।
            आनंदमय कोश हमारी चेतना का पांचवां और सबसे गहरा स्तर है, जो गहरी नींद (सुषुप्ति) में अनुभव होता है।
            यह श्लोक भौतिक शरीर से शुरू होकर आत्मा के सबसे करीबी आवरण तक की महायात्रा को पूर्ण करता है।
        """.trimIndent(),
        english = """
            Intellect (Vijnana) directs all worldly and spiritual sacrifices and drives all human actions.
            All the gods constantly worship this Vijnana, considering it as the eldest and supreme Brahman.
            By purifying the intellect, a person leaves his sins behind and fulfills all his noble desires.
            But inside this 'Vijnanamaya Kosha', there is an ultimately subtle self called the 'Anandamaya Kosha'.
            This sheath of bliss pervades the inside of the intellectual sheath and completely fills it up.
            This Anandamaya Kosha also takes a human shape; 'Priya' (joy of seeing a desired object) is its head.
            'Moda' (joy of acquiring it) is its right wing, and 'Pramoda' (intense joy of enjoying it) is its left wing.
            'Ananda' (pure bliss) is its central trunk, and the Supreme Brahman itself is its tail (foundation).
            The Anandamaya Kosha is the fifth and deepest layer of consciousness, experienced in deep sleep.
            This verse completes the epic journey from the physical body to the closest covering of the Soul.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 18,
        sanskrit = "असन्नेव स भवति । असद्ब्रह्मेति वेद चेत् । अस्ति ब्रह्मेति चेद्वेद । सन्तमेनं ततो विदुरिति । ... सोऽकामयत । बहु स्यां प्रजायेयेति । स तपोऽतप्यत । स तपस्तप्त्वा । इदँ सर्वमसृजत । यदिदं किञ्च । तत्सृष्ट्वा । तदेवानुप्राविशत् ॥ १८ ॥",
        hindi = """
            यदि कोई यह मानता है कि 'ब्रह्म असत् (नहीं) है', तो वह स्वयं भी असत् (अस्तित्वहीन) के समान हो जाता है।
            किंतु यदि कोई यह जानता है कि 'ब्रह्म अस्ति (है)', तो ज्ञानी लोग उसे एक सत् (सच्चा) पुरुष मानते हैं।
            यही आनंदमय आत्मा विज्ञानमय आत्मा की भी आंतरिक आत्मा है। (शिष्य पूछता है: क्या अज्ञानी भी ब्रह्म को पाता है?)
            उस परमात्मा ने इच्छा (काम) की: 'मैं एक हूँ, मैं बहुत हो जाऊँ और मैं अनेक रूपों में प्रकट होऊँ।'
            इस संकल्प के साथ उसने तप (गहरा विचार) किया, और उस तप के द्वारा इस संपूर्ण जगत की रचना की।
            उसने जो कुछ भी दिखाई देता है और जो नहीं दिखाई देता, उन सभी सूक्ष्म और स्थूल तत्वों को रचा।
            इस संपूर्ण जगत को रचने के बाद, वह परमात्मा स्वयं ही अपनी उस रचना के भीतर प्रविष्ट हो गया।
            वही मूर्त्त (दिखने वाला) और अमूर्त्त (निराकार) बन गया, वही चेतन और अचेतन पदार्थों में समा गया।
            सृष्टिकर्ता और सृष्टि अलग नहीं हैं; जैसे मकड़ी जाला बनाकर उसी में रहती है, वैसे ही ब्रह्म भी है।
            यह श्लोक सृष्टि की रचना और परमात्मा की सर्वव्यापकता (Omnipresence) के रहस्य को उजागर करता है।
        """.trimIndent(),
        english = """
            If someone believes that 'Brahman does not exist (Asat)', he himself becomes as if non-existent.
            But if someone knows that 'Brahman exists', the wise consider him a true and virtuous person.
            This blissful self is the inner soul of the intellectual self. (The disciple asks: Does an ignorant man attain Brahman?)
            That Supreme Lord desired: 'I am one, let me become many, let me multiply and manifest.'
            With this resolve, He performed Tapas (deep thought), and through that Tapas, He created this universe.
            He created everything that exists—whatever is visible and invisible, subtle and gross elements.
            Having created this entire universe, that Supreme Lord Himself entered into His own creation.
            He became the defined (form) and the undefined (formless), He permeated both conscious and inert matter.
            The Creator and the creation are not separate; just as a spider lives in its web, so does Brahman.
            This verse reveals the deep secret of the creation of the universe and the omnipresence of God.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 19,
        sanskrit = "असद्वा इदमग्र आसीत् । ततो वै सदजायत । तदात्मानँ स्वयमकुरुत । तस्मात् सुकृतमुच्यत इति ॥ यद्वै तत् सुकृतम् । रसो वै सः । रसँ ह्येवायं लब्ध्वानन्दी भवति । को ह्येवान्यात् कः प्राण्यात् । यदेष आकाश आनन्दो न स्यात् । एष ह्येवानन्दयाति ॥ १९ ॥",
        hindi = """
            सृष्टि के आरंभ में यह सब असत् (अव्याकृत/अप्रकट) था; उसी अव्यक्त अवस्था से सत् (प्रकट नाम-रूप) उत्पन्न हुआ।
            उस परम सत्ता ने बिना किसी बाहरी सहायता के स्वयं ही अपने-आप को इस जगत के रूप में निर्मित किया।
            चूँकि उसने स्वयं को बहुत ही सुंदर ढंग से रचा है, इसलिए उस परब्रह्म को 'सुकृत' (Self-made) कहा जाता है।
            वह जो सुकृत है, वह वास्तव में 'रस' (आनंद का सार) है। इस रस को पाकर ही कोई भी जीव आनंदित होता है।
            यदि हृदय के आकाश में यह आनंद रूपी ब्रह्म न होता, तो भला कौन शरीर में श्वास ले सकता था?
            यह परम आनंदमय ब्रह्म ही है जो समस्त प्राणियों को उनके जीवन में सुख और आनंद प्रदान करता है।
            जब मनुष्य उस निराकार, अदृश्य और आधारहीन ब्रह्म में निर्भय होकर पूरी तरह से स्थित हो जाता है।
            तभी वह मृत्यु और संसार के सभी भयों से हमेशा के लिए मुक्त हो जाता है।
            किंतु यदि वह उस ब्रह्म में थोड़ा सा भी भेद (द्वैत) मानता है, तो उसके लिए भय उत्पन्न हो जाता है।
            यह श्लोक यह सिद्ध करता है कि ईश्वर 'रस' (Bliss) है, और जीवन की हर खुशी उसी का एक अंश है।
        """.trimIndent(),
        english = """
            In the beginning, all this was Asat (unmanifested); from that unmanifest state, Sat (the manifest world) was born.
            That Supreme Reality created Itself into this universe by Itself, without any external assistance.
            Because He created Himself so beautifully, that Supreme Brahman is called 'Sukrita' (well-made/self-made).
            That which is Sukrita is indeed 'Rasa' (the essence of bliss). Only by obtaining this Rasa does a soul feel joy.
            If this bliss-form Brahman were not in the space of the heart, who could possibly breathe or live?
            It is this supremely blissful Brahman alone that grants joy and happiness to all living beings in their lives.
            When a person becomes fearlessly and firmly established in that formless, invisible, and ungrounded Brahman.
            Only then does he become completely free from the fear of death and worldly sorrows forever.
            But if he perceives even a slight difference (duality) in that Brahman, fear is created for him.
            This verse proves that God is 'Rasa' (Bliss), and every happiness in life is merely a fragment of Him.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 20,
        sanskrit = "भीषाऽस्माद्वातः पवते । भीषोदेति सूर्यः । भीषाऽस्मादग्निश्चेन्द्रश्च । मृत्युर्धावति पञ्चम इति ॥ सैषानन्दस्य मीमाँसा भवति । युवा स्यात् साधुयुवाध्यायकः । आशिष्ठो दृढिष्ठो बलिष्ठः । तस्येयं पृथिवी सर्वा वित्तस्य पूर्णा स्यात् । स एको मानुष आनन्दः । ते ये शतं मानुषा आनन्दाः ... स एको ब्रह्मण आनन्दः ॥ २० ॥",
        hindi = """
            उस परब्रह्म के भय (अनुशासन) से ही यह वायु निरंतर बहती है; उसके भय से ही सूर्य उदय होता है।
            उसी के भय से अग्नि जलती है, इंद्र वर्षा करते हैं, और पांचवां देव मृत्यु (यमराज) भी दौड़ता रहता है।
            अब उस परब्रह्म के 'आनंद' की मीमांसा (Calculation) की जाती है। कल्पना करो एक श्रेष्ठ मनुष्य की:
            जो युवा हो, सदाचारी हो, वेदों का ज्ञाता हो, सबसे अधिक आशावान, अत्यंत दृढ़ और सबसे अधिक बलवान हो।
            और धन-धान्य से भरी यह पूरी पृथ्वी उसकी हो; उस युवक का आनंद 'एक मानुष आनंद' (Human Bliss) कहलाता है।
            ऐसे सौ मानुष आनंद मिलकर 'मनुष्य-गंधर्वों' का केवल एक आनंद बनाते हैं।
            ऐसे सौ मनुष्य-गंधर्वों के आनंद मिलकर 'देव-गंधर्वों' का एक आनंद बनाते हैं। ऐसे ही आनंद कई गुणा बढ़ता जाता है।
            पितरों, देवताओं, इंद्र, बृहस्पति और प्रजापति से होता हुआ यह आनंद 'ब्रह्मा' के आनंद तक पहुँचता है।
            किंतु जो वेदों का ज्ञाता (श्रोत्रिय) है और निष्काम है, उसे वह ब्रह्मा का आनंद यहीं इसी क्षण प्राप्त होता है।
            यह श्लोक ब्रह्मानंद की असीमता को बताता है—सांसारिक सुख उस परमानंद के सामने समुद्र की एक बूंद के समान हैं।
        """.trimIndent(),
        english = """
            Out of fear (discipline) of that Supreme Brahman, the wind blows constantly; out of His fear, the sun rises.
            Out of His fear, the fire burns, Indra sends rain, and the fifth deity, Death (Yama), runs doing his duty.
            Now, an inquiry (calculation) into the 'Bliss' of that Brahman is made. Imagine a perfect human being:
            A youth, virtuous, learned in the Vedas, supremely hopeful, exceedingly firm, and exceptionally strong.
            And let this entire earth full of wealth belong to him; the joy of that youth is called 'One Human Bliss'.
            A hundred such human blisses make just one bliss of the 'Human-Gandharvas'.
            A hundred blisses of Human-Gandharvas make one bliss of 'Celestial-Gandharvas'. The bliss multiplies similarly.
            Rising exponentially through ancestors, gods, Indra, Brihaspati, and Prajapati, it reaches the bliss of 'Brahma'.
            But a knower of the Vedas who is free from all desires experiences that infinite bliss of Brahma right here and now.
            This verse reveals the limitlessness of Brahmananda—worldly joys are but a drop in the ocean of that Supreme Bliss.
        """.trimIndent()
    ),
    // ... Continuing taittiriyaShlokasList from ID 21

    TaittiriyaShloka(
        id = 21,
        sanskrit = "यतो वाचो निवर्तन्ते । अप्राप्य मनसा सह । आनन्दं ब्रह्मणो विद्वान् । न बिभेति कुतश्चनेति । एतं ह वाव न तपति । किमहँ साधु नाकरवम् । किमहं पापमकरवमिति । स य एवं विद्वानेते आत्मानँ स्पृणुते । उभे ह्येवैष एते आत्मानँ स्पृणुते । य एवं वेद । इत्युपनिषत् ॥ २१ ॥",
        hindi = """
            जहाँ से वाणी और मन उस परब्रह्म को बिना पाए ही पूरी तरह से वापस लौट आते हैं।
            उस परब्रह्म के परम आनंद को जानने वाला ज्ञानी पुरुष कभी भी किसी से भयभीत नहीं होता।
            उसे यह चिंता या पश्चाताप कभी नहीं सताता कि 'मैंने अच्छे कर्म (पुण्य) क्यों नहीं किए?'
            'या मैंने बुरे कर्म (पाप) क्यों किए?' क्योंकि वह पाप और पुण्य दोनों के पार जा चुका है।
            जो इस रहस्य को जान लेता है, वह इन दोनों (पाप और पुण्य) को अपनी ही आत्मा मानता है।
            वह ज्ञानी पुरुष इन दोनों द्वंद्वों से अपनी आत्मा की रक्षा कर लेता है और शांत रहता है।
            उसे अब कोई भी सांसारिक नियम या कर्मफल का डर परेशान नहीं कर सकता है।
            वह पूर्ण रूप से मुक्त होकर केवल परमानंद के असीम सागर में गोते लगाता रहता है।
            यहीं पर 'ब्रह्मानंदवल्ली' का यह अत्यंत गहरा और रहस्यमयी उपदेश समाप्त होता है।
            यह उपनिषद की सर्वोच्च शिक्षा है जो मनुष्य को हर प्रकार के मानसिक बोझ से मुक्त करती है।
        """.trimIndent(),
        english = """
            That from which speech and the mind turn back, completely unable to reach It.
            The wise man who knows the supreme bliss of that Brahman never fears anything at all.
            He is never tormented by the thought or regret: 'Why did I not do good deeds?'
            'Or why did I commit sinful acts?' because he has transcended both sin and virtue.
            He who knows this secret regards both (virtue and sin) simply as his own Self.
            That wise man protects his soul from these two dualities and remains forever tranquil.
            No worldly rules or fear of karmic consequences can ever disturb him again.
            He becomes completely liberated, diving continuously into the boundless ocean of supreme bliss.
            Here ends the profound and mystical teaching of the 'Brahmanandavalli'.
            This is the ultimate teaching of the Upanishad that frees man from every mental burden.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 22,
        sanskrit = "भृगुर्वै वारुणिः । वरुणं पितरमुपससार । अधीहि भगवो ब्रह्मेति । तस्मा एतत्प्रोवाच । अन्नं प्राणं चक्षुः श्रोत्रं मनो वाचमिति । तँ होवाच । यतो वा इमानि भूतानि जायन्ते । येन जातानि जीवन्ति । यत्प्रयन्त्यभिसंविशन्ति । तद्विजिज्ञासस्व । तद् ब्रह्मेति । स तपोऽतप्यत । स तपस्तप्त्वा ॥ २२ ॥",
        hindi = """
            वरुण के पुत्र भृगु अपने पिता वरुण के पास गए और बोले: 'हे भगवन्! मुझे ब्रह्म का उपदेश दें।'
            पिता वरुण ने उनसे कहा: 'अन्न, प्राण, आँख, कान, मन और वाणी—ये ब्रह्म प्राप्ति के द्वार हैं।'
            फिर उन्होंने ब्रह्म का लक्षण बताया: 'जिससे ये सभी प्राणी निश्चित रूप से उत्पन्न होते हैं।'
            'उत्पन्न होने के बाद जिसके सहारे ये सभी जीवित रहते हैं और अपना अस्तित्व बनाए रखते हैं।'
            'और अंत में मृत्यु के बाद ये सभी प्राणी जिसमें वापस लौटकर पूरी तरह से विलीन हो जाते हैं।'
            'उसी परम तत्व को विशेष रूप से जानने की इच्छा करो; वास्तव में वही परब्रह्म है।'
            पिता का यह उपदेश सुनकर भृगु ऋषि ने सत्य को जानने के लिए घोर तप (चिंतन) किया।
            यह 'भृगुवल्ली' का आरंभ है, जो एक खोजी (शिष्य) और गुरु (पिता) का संवाद है।
            ब्रह्म की परिभाषा यहाँ अत्यंत वैज्ञानिक ढंग से दी गई है—वह जो सृष्टि का आदि, मध्य और अंत है।
            तप का अर्थ यहाँ शारीरिक कष्ट नहीं, बल्कि गहरी मानसिक एकाग्रता और खोज है।
        """.trimIndent(),
        english = """
            Bhrigu, the son of Varuna, approached his father Varuna and said: 'Venerable Sir, teach me Brahman.'
            His father told him: 'Food, vital breath, the eye, the ear, the mind, and speech are the doors to Brahman.'
            Then he defined Brahman: 'That from which all these beings are certainly born.'
            'That by which, having been born, they live and sustain their entire existence.'
            'And that into which they finally return and merge completely after their death.'
            'Seek to know that Supreme Principle specifically and deeply; for That is indeed Brahman.'
            Hearing this instruction from his father, Sage Bhrigu performed intense Tapas (contemplation) to know the truth.
            This is the beginning of 'Bhriguvalli', a dialogue between an earnest seeker (son) and guru (father).
            The definition of Brahman is given here very scientifically—He is the beginning, middle, and end of creation.
            Tapas here does not mean physical suffering, but profound mental concentration and inquiry.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 23,
        sanskrit = "अन्नं ब्रह्मेति व्यजानात् । अन्नाद्ध्येव खल्विमानि भूतानि जायन्ते । अन्नेन जातानि जीवन्ति । अन्नं प्रयन्त्यभिसंविशन्तीति । तद्विज्ञाय । पुनरेव वरुणं पितरमुपससार । अधीहि भगवो ब्रह्मेति । तँ होवाच । तपसा ब्रह्म विजिज्ञासस्व । तपो ब्रह्मेति । स तपोऽतप्यत । स तपस्तप्त्वा ॥ २३ ॥",
        hindi = """
            तप (गहन चिंतन) करने के बाद भृगु ने यह जाना कि 'अन्न' (भौतिक पदार्थ) ही ब्रह्म है।
            क्योंकि अन्न से ही यह समस्त प्राणी निश्चित रूप से जन्म लेते हैं और शरीर धारण करते हैं।
            जन्म लेने के बाद ये सभी अन्न खाकर ही जीवित रहते हैं और अपनी वृद्धि करते हैं।
            और अंत में विनाश होने पर ये अन्न (मिट्टी) में ही वापस लौटकर विलीन हो जाते हैं।
            यह जानकर कि अन्न ही ब्रह्म है, वह फिर से अपने पिता वरुण के पास गए।
            उन्होंने पुनः प्रार्थना की: 'हे भगवन्! मुझे ब्रह्म का वास्तविक उपदेश प्रदान करें।'
            पिता ने उत्तर दिया: 'तप (एकाग्र चिंतन) के द्वारा ब्रह्म को जानने का निरंतर प्रयास करो।'
            'तप ही वह वास्तविक साधन है जिससे ब्रह्म को जाना जाता है, इसलिए तप ही ब्रह्म है।'
            पिता ने सीधे उत्तर नहीं दिया, बल्कि शिष्य को स्वयं और गहराई में उतरने के लिए प्रेरित किया।
            यह अन्नमय कोश (Physical layer) की पहचान है, जो आत्मज्ञान की पहली सीढ़ी है।
        """.trimIndent(),
        english = """
            After performing Tapas (deep contemplation), Bhrigu realized that 'Food' (matter) is Brahman.
            Because it is from food that all these living beings are certainly born and take physical bodies.
            Having been born, they all remain alive and grow by consuming food.
            And finally, upon destruction, they return and merge completely back into food (earth).
            Having understood that food is Brahman, he went back to his father Varuna again.
            He prayed once more: 'Venerable Sir, please instruct me further about the true Brahman.'
            The father replied: 'Seek to know Brahman continuously through Tapas (focused contemplation).'
            'Tapas is the true means by which Brahman is known, therefore Tapas itself is Brahman.'
            The father did not give a direct answer but inspired the disciple to dive even deeper himself.
            This is the recognition of the Annamaya Kosha (physical layer), the first step to Self-knowledge.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 24,
        sanskrit = "प्राणो ब्रह्मेति व्यजानात् । प्राणाद्ध्येव खल्विमानि भूतानि जायन्ते । प्राणेन जातानि जीवन्ति । प्राणं प्रयन्त्यभिसंविशन्तीति । तद्विज्ञाय । पुनरेव वरुणं पितरमुपससार । अधीहि भगवो ब्रह्मेति । तँ होवाच । तपसा ब्रह्म विजिज्ञासस्व । तपो ब्रह्मेति । स तपोऽतप्यत । स तपस्तप्त्वा ॥ २४ ॥",
        hindi = """
            पुनः गहन चिंतन करने के बाद भृगु ने जाना कि 'प्राण' (जीवन ऊर्जा) ही साक्षात् ब्रह्म है।
            क्योंकि प्राण से ही ये सभी प्राणी जन्म लेते हैं और इसी शक्ति से वे क्रियाशील होते हैं।
            जन्म लेने के बाद वे प्राण के सहारे ही जीवित रहते हैं और श्वास लेते हैं।
            और अंत में मृत्यु के समय उनका यह प्राण ही उस महाप्राण में वापस विलीन हो जाता है।
            यह जानकर वह संतुष्ट नहीं हुए और सत्य की तलाश में फिर अपने पिता वरुण के पास पहुँचे।
            उन्होंने पुनः विनती की: 'हे भगवन्! मुझे उस परम ब्रह्म का अंतिम और सत्य उपदेश दें।'
            पिता ने फिर वही उत्तर दिया: 'तप के द्वारा ही ब्रह्म को जानने की उत्कृष्ट इच्छा करो।'
            'तप ही ब्रह्म को प्राप्त करने का एकमात्र मार्ग है।' यह सुनकर भृगु ने फिर से तप किया।
            यह खोज का दूसरा चरण है—अन्न (Matter) से प्राण (Energy) की ओर प्रस्थान।
            साधक अब स्थूल से सूक्ष्म की ओर बढ़ रहा है, और 'प्राणमय कोश' का रहस्य जान चुका है।
        """.trimIndent(),
        english = """
            After performing deep contemplation again, Bhrigu realized that 'Prana' (life energy) is Brahman.
            Because it is from Prana that all these beings are born and by this power they become active.
            Having been born, they remain alive and breathe solely relying on Prana.
            And finally, at the time of death, their individual Prana merges back into the cosmic Prana.
            Knowing this, he was not satisfied and reached out to his father Varuna again in search of truth.
            He requested once more: 'Venerable Sir, give me the final and true teaching of that Supreme Brahman.'
            The father gave the same reply: 'Desire strongly to know Brahman through Tapas alone.'
            'Tapas is the only path to attain Brahman.' Hearing this, Bhrigu performed Tapas once again.
            This is the second stage of inquiry—moving from Food (Matter) to Prana (Energy).
            The seeker is now moving from the gross to the subtle, understanding the 'Pranamaya Kosha'.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 25,
        sanskrit = "मनो ब्रह्मेति व्यजानात् । मनसो ह्येव खल्विमानि भूतानि जायन्ते । मनसा जातानि जीवन्ति । मनः प्रयन्त्यभिसंविशन्तीति । तद्विज्ञाय । पुनरेव वरुणं पितरमुपससार । अधीहि भगवो ब्रह्मेति । तँ होवाच । तपसा ब्रह्म विजिज्ञासस्व । तपो ब्रह्मेति । स तपोऽतप्यत । स तपस्तप्त्वा ॥ २५ ॥",
        hindi = """
            फिर से कठोर चिंतन करने के बाद भृगु ने यह जाना कि 'मन' (विचार और संकल्प) ही ब्रह्म है।
            क्योंकि मन के संकल्पों और इच्छाओं से ही ये सभी प्राणी जन्म लेने के लिए प्रेरित होते हैं।
            जन्म लेने के बाद वे मन के द्वारा ही सोचते हैं, इच्छाएं करते हैं और अपना जीवन बिताते हैं।
            और अंत में जब वे शरीर त्यागते हैं, तो उनकी चेतना मन के सूक्ष्म रूप में ही विलीन होती है।
            यह जानकर भी उन्हें पूर्ण संतुष्टि नहीं मिली, इसलिए वे पुनः अपने पिता वरुण के पास गए।
            उन्होंने फिर वही प्रश्न दोहराया: 'हे भगवन्! मुझे उस परब्रह्म का सच्चा उपदेश प्रदान करें।'
            पिता ने उन्हें फिर से आगे बढ़ने की प्रेरणा दी: 'तप के द्वारा ही ब्रह्म को जानने का प्रयास करो।'
            'तुम्हारा यह चिंतन (तप) ही तुम्हें अंततः सत्य तक ले जाएगा।' भृगु ने फिर से तप शुरू किया।
            अब भृगु ने ऊर्जा (प्राण) से भी सूक्ष्म तत्व 'मन' (Mind) को ब्रह्मांड का आधार माना है।
            यह 'मनोमय कोश' की पहचान है, जहाँ मनोवैज्ञानिक दुनिया को ही सब कुछ मान लिया जाता है।
        """.trimIndent(),
        english = """
            After contemplating vigorously again, Bhrigu realized that 'Mind' (thought and will) is Brahman.
            Because it is from the resolves and desires of the mind that all beings are driven to be born.
            Having been born, they think, form desires, and spend their lives directed by the mind.
            And finally, when they leave the body, their consciousness merges into the subtle form of the mind.
            Even after knowing this, he was not fully satisfied, so he went back to his father Varuna again.
            He repeated the same question: 'Venerable Sir, please grant me the true teaching of that Supreme Brahman.'
            The father inspired him to advance further again: 'Try to know Brahman through Tapas.'
            'This contemplation (Tapas) of yours will ultimately lead you to the truth.' Bhrigu started Tapas again.
            Now Bhrigu considered 'Mind', an element subtler than energy (Prana), as the foundation of the universe.
            This is the recognition of the 'Manomaya Kosha', where the psychological world is considered everything.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 26,
        sanskrit = "विज्ञानं ब्रह्मेति व्यजानात् । विज्ञानाद्ध्येव खल्विमानि भूतानि जायन्ते । विज्ञानेन जातानि जीवन्ति । विज्ञानं प्रयन्त्यभिसंविशन्तीति । तद्विज्ञाय । पुनरेव वरुणं पितरमुपससार । अधीहि भगवो ब्रह्मेति । तँ होवाच । तपसा ब्रह्म विजिज्ञासस्व । तपो ब्रह्मेति । स तपोऽतप्यत । स तपस्तप्त्वा ॥ २६ ॥",
        hindi = """
            मन से भी आगे की गहराई में चिंतन करने पर भृगु ने जाना कि 'विज्ञान' (बुद्धि/ज्ञान) ही ब्रह्म है।
            क्योंकि इस विशेष ज्ञान और विवेक के कारण ही जीवों का जन्म एक व्यवस्थित तरीके से होता है।
            जन्म लेने के बाद जीव अपनी इसी बुद्धि के सहारे निर्णय लेते हैं और जीवन को सफलतापूर्वक जीते हैं।
            और मृत्यु के बाद उनकी चेतना इसी ज्ञान (विज्ञान) के भंडार में जाकर पूरी तरह समा जाती है।
            परंतु विज्ञान को जानकर भी भृगु को वह परम शांति और पूर्णता का अनुभव नहीं हुआ जो ब्रह्म में है।
            वे फिर से अपने पिता के पास लौटकर गए और बोले: 'हे भगवन्! मुझे ब्रह्म का अंतिम रहस्य बताएँ।'
            वरुण ने कहा: 'अपनी खोज को यहाँ मत रोको, तप के माध्यम से उस ब्रह्म को और गहराई से जानो।'
            'तप ही वह ज्योति है जो हर परत को भेद सकती है।' भृगु ने फिर से एकाग्रचित्त होकर तप किया।
            मन चंचल होता है, परंतु विज्ञान (Intellect) स्थिर होता है; यह 'विज्ञानमय कोश' का ज्ञान है।
            साधक अब सत्य के बहुत करीब आ गया है, पर वह अभी भी पूर्ण आनंद से एक कदम दूर है।
        """.trimIndent(),
        english = """
            Contemplating deeper than the mind, Bhrigu realized that 'Vijnana' (intellect/wisdom) is Brahman.
            Because it is due to this specific knowledge and discernment that beings are born in an orderly way.
            Having been born, beings make decisions relying on this intellect and live their lives successfully.
            And after death, their consciousness goes and merges completely into this reservoir of knowledge (Vijnana).
            But even after knowing Vijnana, Bhrigu did not experience the ultimate peace and perfection of Brahman.
            He returned to his father again and said: 'Venerable Sir, tell me the final secret of Brahman.'
            Varuna said: 'Do not stop your search here; know that Brahman more deeply through Tapas.'
            'Tapas is the light that can pierce every layer.' Bhrigu meditated with single-minded focus again.
            The mind is restless, but Vijnana (Intellect) is steady; this is the knowledge of the 'Vijnanamaya Kosha'.
            The seeker has now come very close to the truth, but he is still one step away from absolute bliss.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 27,
        sanskrit = "आनन्दो ब्रह्मेति व्यजानात् । आनन्दाद्ध्येव खल्विमानि भूतानि जायन्ते । आनन्देन जातानि जीवन्ति । आनन्दं प्रयन्त्यभिसंविशन्तीति । सैषा भार्गवी वारुणी विद्या । परमे व्योमन् प्रतिष्ठिता । स य एवं वेद प्रतितिष्ठति । अन्नवानन्नादो भवति । महान् भवति प्रजया पशुभिर्ब्रह्मवर्चसेन । महान् कीर्त्या ॥ २७ ॥",
        hindi = """
            अपने अंतिम तप के बाद भृगु ने जान लिया कि 'आनंद' (असीम सुख/Bliss) ही वास्तव में परब्रह्म है।
            क्योंकि इस आनंद से ही ये समस्त प्राणी उत्पन्न होते हैं; आनंद ही जीवन का परम मूल कारण है।
            जन्म लेने के बाद वे सभी इस आनंद के सहारे ही जीवित रहते हैं और आनंद की ही खोज करते हैं।
            और अंत में वे इसी परमानंद के महासागर में लौटकर हमेशा के लिए पूरी तरह से विलीन हो जाते हैं।
            यही भृगु और वरुण की वह महान विद्या है, जो हृदय के परम आकाश (परमे व्योमन्) में प्रतिष्ठित है।
            जो साधक इस विद्या को इस प्रकार गहराई से जान लेता है, वह स्वयं उसी परमानंद में प्रतिष्ठित हो जाता है।
            वह प्रचुर अन्न से युक्त होता है और उस अन्न का उपभोग करने की उत्तम शक्ति (अन्नाद) भी प्राप्त करता है।
            वह श्रेष्ठ संतान, पशुधन और ब्रह्मवर्चस (आध्यात्मिक तेज) के कारण इस संसार में महान हो जाता है।
            वह अपनी निर्मल कीर्ति (यश) से महान होता है। यह आत्मज्ञान और लौकिक सफलता का अद्भुत संगम है।
            भृगु की यह यात्रा अन्नमय कोश से शुरू होकर आत्मा के असली स्वरूप 'आनंदमय कोश' पर पूरी होती है।
        """.trimIndent(),
        english = """
            After his final Tapas, Bhrigu realized that 'Ananda' (infinite Bliss) is indeed the Supreme Brahman.
            Because it is from this Bliss that all these beings are born; Bliss is the ultimate root cause of life.
            Having been born, they all live sustained by this Bliss and they constantly search for Bliss alone.
            And finally, they return and merge completely into this magnificent ocean of supreme Bliss forever.
            This is that great knowledge of Bhrigu and Varuna, which is established in the supreme space of the heart.
            The seeker who knows this wisdom deeply in this manner becomes established in that supreme Bliss himself.
            He is endowed with abundant food and also gains the excellent power (Annada) to consume and digest that food.
            He becomes great in this world by virtue of excellent progeny, cattle wealth, and spiritual radiance.
            He becomes great by his pure fame. This is a wonderful confluence of Self-realization and worldly success.
            Bhrigu's journey, which started from the physical sheath (Annamaya), completes at the soul's true nature—Bliss.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 28,
        sanskrit = "अन्नं न निन्द्यात् । तद्व्रतम् । प्राणो वा अन्नम् । शरीरमन्नादम् । प्राणे शरीरं प्रतिष्ठितम् । शरीरे प्राणः प्रतिष्ठितः । तदेतदन्नमन्ने प्रतिष्ठितम् । स य एतदन्नमन्ने प्रतिष्ठितं वेद प्रतितिष्ठति । अन्नवानन्नादो भवति । महान् भवति प्रजया पशुभिर्ब्रह्मवर्चसेन । महान् कीर्त्या ॥ २८ ॥",
        hindi = """
            उपनिषद अब एक व्रत देता है: 'अन्न (भोजन) की कभी निंदा मत करो।' यह जीवन भर का व्रत होना चाहिए।
            क्योंकि यह प्राण (श्वास और ऊर्जा) ही वास्तव में अन्न है, और यह भौतिक शरीर ही उस अन्न को खाने वाला है।
            यह शरीर पूरी तरह से प्राणों पर ही टिका हुआ है, और प्राण इस शरीर के भीतर ही आश्रय लेकर स्थित हैं।
            इसलिए यह प्राण रूपी अन्न इस शरीर रूपी अन्न में ही प्रतिष्ठित है—दोनों एक-दूसरे के पूरक और आश्रित हैं।
            जो ज्ञानी पुरुष यह जान लेता है कि अन्न ही अन्न में प्रतिष्ठित है, वह जीवन के सत्य में दृढ़ता से प्रतिष्ठित हो जाता है।
            भोजन शरीर का निर्माण करता है और प्राण उसे चलाता है, इसलिए भोजन का अपमान प्राण और ईश्वर का अपमान है।
            वह व्यक्ति भरपूर अन्न (संसाधन) वाला होता है और उस अन्न का आनंद लेने की उत्तम क्षमता भी प्राप्त करता है।
            वह अपनी योग्य संतान, उत्तम पशुधन (संपत्ति) और ब्रह्मज्ञान के तेज (ब्रह्मवर्चस) से महान बन जाता है।
            संसार में उसका यश और कीर्ति फैलती है। यह श्लोक भोजन के प्रति गहरा सम्मान और कृतज्ञता सिखाता है।
            आध्यात्मिक ऊंचाई पाने के लिए भी अपने शरीर और उसके पोषण (अन्न) का सम्मान करना अत्यंत आवश्यक है।
        """.trimIndent(),
        english = """
            The Upanishad now gives a vow: 'Never condemn or disrespect food.' This should be a lifelong vow.
            Because this Prana (breath and energy) is indeed food, and this physical body is the eater of that food.
            This body is completely supported by the Pranas, and the Pranas are established taking shelter within the body.
            Therefore, this food in the form of Prana is established in the food in the form of the body—they are interdependent.
            The wise man who knows that food is established in food becomes firmly established in the truth of life.
            Food builds the body and Prana drives it; hence insulting food is an insult to Prana and God Himself.
            That person becomes possessed of abundant food (resources) and also gains the excellent capacity to enjoy it.
            He becomes great through his worthy progeny, excellent cattle (wealth), and the radiance of spiritual wisdom.
            His fame and glory spread in the world. This verse teaches deep respect and absolute gratitude towards food.
            To attain spiritual heights, it is extremely necessary to respect one's body and its nourishment (food).
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 29,
        sanskrit = "अन्नं न परिचक्षीत । तद्व्रतम् । आपो वा अन्नम् । ज्योतिरन्नादम् । अप्सु ज्योतिः प्रतिष्ठितम् । ज्योतिष्यापः प्रतिष्ठिताः । तदेतदन्नमन्ने प्रतिष्ठितम् । स य एतदन्नमन्ने प्रतिष्ठितं वेद प्रतितिष्ठति । अन्नवानन्नादो भवति । महान् भवति प्रजया पशुभिर्ब्रह्मवर्चसेन । महान् कीर्त्या ॥ २९ ॥",
        hindi = """
            उपनिषद का दूसरा महत्वपूर्ण व्रत: 'अन्न का कभी भी परित्याग या तिरस्कार मत करो।'
            क्योंकि 'जल' ही वास्तव में अन्न का रूप है, और 'अग्नि' (ज्योति) उस जल रूपी अन्न को ग्रहण करने वाली है।
            अग्नि की ज्योति हमेशा जल के भीतर (विद्युत के रूप में) छिपी रहती है और उसमें ही प्रतिष्ठित है।
            और जल हमेशा ज्योति (अग्नि/सूर्य की किरणों) में वाष्प के रूप में प्रतिष्ठित और समाहित रहता है।
            इस प्रकार यह जल रूपी अन्न अग्नि रूपी अन्न में ही स्थित है—जल और अग्नि का यह संतुलन ही जीवन है।
            जो साधक इस गूढ़ रहस्य को समझ लेता है कि प्रकृति की सारी ऊर्जाएँ एक-दूसरे से जुड़ी हैं, वह सत्य में स्थित होता है।
            ब्रह्मांड के ये महाभूत एक-दूसरे का भक्षण करते हैं और एक-दूसरे को पोषण भी देते हैं, यही सृष्टि का चक्र है।
            वह ज्ञानी पर्याप्त अन्न और उसे पचाने वाली अग्नि (भूख/स्वास्थ्य) दोनों को अच्छी तरह प्राप्त करता है।
            वह अपनी उत्तम संतान, संपदा और ब्रह्मज्ञान के असीम तेज के कारण समाज में महानता को प्राप्त होता है।
            उसका यश चारों दिशाओं में फैल जाता है। यह श्लोक प्रकृति के जल और अग्नि तत्वों के बीच अद्भुत एकता को बताता है।
        """.trimIndent(),
        english = """
            The second important vow of the Upanishad: 'Never reject or show contempt for food.'
            Because 'Water' is indeed the form of food, and 'Fire' (light/heat) is the eater of that water-food.
            The light of the fire is always hidden within water (as electricity) and is firmly established in it.
            And water is always established and contained in the light (fire/sun rays) in the form of vapor.
            Thus this food in the form of water is established in the food in the form of fire—this balance is life.
            The seeker who understands this deep secret that all energies of nature are interconnected stands firm in truth.
            The great elements of the cosmos consume each other and nourish each other; this is the cycle of creation.
            That wise man attains both abundant food and the fire (appetite/health) required to properly digest it.
            He attains greatness in society due to his excellent progeny, wealth, and the boundless radiance of spiritual wisdom.
            His fame spreads in all directions. This verse explains the amazing unity between water and fire elements of nature.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 30,
        sanskrit = "अन्नं बहु कुर्वीत । तद्व्रतम् । पृथिवी वा अन्नम् । आकाशोऽन्नादः । पृथिव्यामाकाशः प्रतिष्ठितः । आकाशे पृथिवी प्रतिष्ठिता । तदेतदन्नमन्ने प्रतिष्ठितम् । स य एतदन्नमन्ने प्रतिष्ठितं वेद प्रतितिष्ठति । अन्नवानन्नादो भवति । महान् भवति प्रजया पशुभिर्ब्रह्मवर्चसेन । महान् कीर्त्या ॥ ३० ॥",
        hindi = """
            उपनिषद का तीसरा और महान व्रत: 'अन्न का अधिक से अधिक उत्पादन करो, उसे खूब बढ़ाओ।'
            क्योंकि यह 'पृथ्वी' ही वास्तव में अन्न है, और यह विशाल 'आकाश' ही उस पृथ्वी रूपी अन्न का उपभोक्ता (अन्नाद) है।
            यह अनंत आकाश इस पृथ्वी के कण-कण में समाया हुआ है और पृथ्वी इसी आकाश के भीतर टिकी हुई है।
            उसी प्रकार पृथ्वी भी इस आकाश के ही भीतर पूरी तरह से प्रतिष्ठित और स्थित है।
            इस प्रकार यह पृथ्वी रूपी अन्न आकाश रूपी अन्न में ही प्रतिष्ठित है—पदार्थ और शून्यता का यही गहरा संबंध है।
            जो इस रहस्य को जान लेता है कि ठोस पदार्थ (पृथ्वी) और असीम अंतरिक्ष (आकाश) एक-दूसरे के पूरक हैं, वह ज्ञान में स्थिर होता है।
            अन्न का अधिक उत्पादन करना केवल व्यक्तिगत नहीं, बल्कि एक सामाजिक और ब्रह्मांडीय धर्म माना गया है।
            वह व्यक्ति जीवन के भरपूर संसाधनों (अन्न) और उन्हें भोगने की पूर्ण क्षमता के साथ समृद्ध होता है।
            वह अपनी उत्तम प्रजा, पशुधन और ब्रह्मज्ञान के महान तेज के कारण सर्वत्र सम्मान और महानता प्राप्त करता है।
            उसकी कीर्ति अखंड हो जाती है। यह श्लोक कृषि, प्रचुरता और ब्रह्मांड की विशालता का सम्मान करना सिखाता है।
        """.trimIndent(),
        english = """
            The third and great vow of the Upanishad: 'Produce food in abundance, multiply it greatly.'
            Because this 'Earth' is indeed food, and this vast 'Space' (Akasha) is the consumer (eater) of that earth-food.
            This infinite space permeates every particle of the earth, and the earth rests securely within this space.
            Similarly, the earth is fully established and situated within the vastness of space itself.
            Thus this food in the form of earth is established in the food in the form of space—this is the deep link between matter and void.
            He who knows this secret that solid matter (Earth) and boundless void (Space) are complementary, is established in wisdom.
            Producing food in abundance is considered not just a personal but a profound social and cosmic duty.
            That person prospers with abundant resources of life (food) and the full capacity to enjoy them.
            He gains universal respect and greatness through his excellent progeny, cattle wealth, and the great radiance of spiritual wisdom.
            His glory becomes unbroken. This verse teaches us to honor agriculture, abundance, and the vastness of the cosmos.
        """.trimIndent()
    ),
    TaittiriyaShloka(
        id = 31,
        sanskrit = "न कञ्चन वसतौ प्रत्याचक्षीत । तद्व्रतम् । तस्माद्यया कया च विधया बह्वन्नं प्राप्नुयात् । अराध्यस्मा अन्नमित्याचक्षते । एतद्वै मुखतोऽन्नँ राद्धम् । मुखतोऽस्मा अन्नँ राध्यते । ... हा ३ वु हा ३ वु हा ३ वु । अहमन्नमहमन्नमहमन्नम् । अहमन्नादोऽ३हमन्नादोऽ३हमन्नादः । ... अहमेवमिदं सर्वोऽस्मीति । सुवर्णज्योतीः । य एवं वेद । इत्युपनिषत् ॥ ३१ ॥",
        hindi = """
            अंतिम व्रत: 'अपने घर (निवास) आए किसी भी अतिथि को कभी भी वापस मत लौटाओ (उसे आश्रय और भोजन दो)।'
            इसलिए मनुष्य को जिस किसी भी उचित उपाय से हो सके, प्रचुर मात्रा में अन्न का संग्रह करना चाहिए।
            जब यजमान अतिथि से आदरपूर्वक कहता है: 'आपके लिए अन्न (भोजन) तैयार है', तो यह सर्वोच्च सत्कार है।
            जो व्यक्ति अतिथि को उत्तम भाव से अन्न देता है, उसे बदले में उत्तम आयु और अन्न की प्राप्ति होती है।
            (मुक्त पुरुष का अंतिम आनंदमयी गान): 'हा वु! हा वु! हा वु! (अद्भुत आश्चर्य!) मैं ही अन्न हूँ, मैं ही अन्न हूँ, मैं ही अन्न हूँ।'
            'मैं ही अन्न को खाने वाला (अन्नाद) हूँ, मैं ही अन्नाद हूँ, मैं ही अन्नाद हूँ। मैं ही इन दोनों को जोड़ने वाला हूँ।'
            'मैं ही यह संपूर्ण ब्रह्मांड हूँ! मेरी ज्योति सुवर्ण के समान अत्यंत प्रकाशमान और शाश्वत है।'
            जो साधक इस प्रकार परब्रह्म को जान लेता है, वह इसी जीवन में उस परमानंद और एकता का साक्षात् अनुभव करता है।
            यहाँ वह द्वैत पूरी तरह से मिट जाता है; खाने वाला, खाया जाने वाला और खाने की क्रिया—तीनों एक हो जाते हैं।
            यहाँ तैत्तिरीय उपनिषद का महान और अत्यंत रहस्यमयी उपदेश पूर्ण होता है। (इति उपनिषत्)।
        """.trimIndent(),
        english = """
            The final vow: 'Never turn away anyone seeking shelter or food at your home (residence).'
            Therefore, by whatever rightful means possible, a person should acquire and store abundant food.
            When the host respectfully says to the guest: 'Food is prepared and ready for you', it is the highest hospitality.
            The person who gives food to guests with noble intentions receives excellent lifespan and food in return.
            (The final blissful song of the liberated soul): 'Ha Vu! Ha Vu! Ha Vu! (Oh wonderful!) I am food, I am food, I am food.'
            'I am the eater of food (Annada), I am the eater, I am the eater. I am the unifying force between the two.'
            'I am this entire universe! My light is supremely radiant like gold and absolutely eternal.'
            The seeker who knows the Supreme Brahman in this way directly experiences that ultimate bliss and unity in this very life.
            Here duality is completely obliterated; the eater, the eaten, and the act of eating—all three become entirely one.
            Here ends the great and highly mystical teaching of the Taittiriya Upanishad. (Iti Upanishad).
        """.trimIndent()
    )
)