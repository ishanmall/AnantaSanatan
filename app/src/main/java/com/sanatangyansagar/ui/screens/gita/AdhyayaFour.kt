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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AdhyayaFour() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaFourShlokas.indexOfFirst { it.id == shlokaNum }
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
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (e.g., 7)") },
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

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(adhyayaFourShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaFourShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            श्रीभगवानुवाच |
            इमं विवस्वते योगं प्रोक्तवानहमव्ययम् |
            विवस्वान्मनवे प्राह मनुरिक्ष्वाकवेऽब्रवीत् || १ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: मैंने इस अविनाशी (अव्ययम्) योग का उपदेश सृष्टि के आरंभ में सूर्यदेव (विवस्वान) को दिया था।
            सूर्यदेव ने यह ज्ञान अपने पुत्र, मानव जाति के पिता मनु को दिया, और मनु ने इसका उपदेश अपने पुत्र राजा इक्ष्वाकु को दिया।
            चौथे अध्याय की शुरुआत एक बहुत ही ऐतिहासिक और ब्रह्मांडीय (Cosmic) रहस्योद्घाटन से होती है। भगवान श्रीकृष्ण अर्जुन को भगवद्गीता का इतिहास (History) बता रहे हैं।
            वे स्पष्ट करते हैं कि यह ज्ञान कोई नया दर्शन (Philosophy) नहीं है जो उन्होंने युद्ध के मैदान में अचानक सोच लिया हो। यह एक 'अविनाशी योग' (Eternal Science) है, जो सृष्टि के निर्माण के समय से मौजूद है।
            सबसे पहले यह ज्ञान सूर्यदेव को दिया गया, क्योंकि सूर्य प्रकाश और ऊर्जा का स्रोत है, और एक राजा (सूर्यदेव) ही पूरे ब्रह्मांड पर शासन करता है। 
            सूर्यदेव ने यह ज्ञान पृथ्वी के शासक 'मनु' को दिया (जिनसे 'मानव' शब्द बना है), और फिर यह ज्ञान सूर्यवंश के पहले राजा इक्ष्वाकु (भगवान राम के पूर्वज) को मिला।
            भगवान यह सिद्ध कर रहे हैं कि गीता का यह ज्ञान विशेष रूप से 'राजाओं' और 'क्षत्रियों' (Executive class) के लिए है, ताकि वे स्वार्थरहित होकर समाज का सही मार्गदर्शन कर सकें।
            यह ज्ञान एक अचूक 'मैनेजमेंट मैनुअल' (Management Manual) है, जो समाज को चलाने वालों के लिए अनिवार्य है।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead said: I instructed this imperishable (Avyayam) science of yoga to the sun-god, Vivasvan, at the very beginning of creation.
            Vivasvan instructed it to Manu, the father of mankind, and Manu in turn instructed it to his son, King Ikshvaku.
            The Fourth Chapter begins with an incredibly monumental, cosmic historical revelation. Lord Sri Krishna is disclosing the absolute origin and ancient history of the Bhagavad Gita to Arjuna.
            He makes it completely clear that this knowledge is absolutely not some newly invented philosophy that He just cooked up on the battlefield. It is an 'Avyaya Yoga' (Eternal, Imperishable Science) existing since the absolute dawn of creation.
            This supreme knowledge was first delivered to the Sun-god, because the sun is the ultimate source of light and energy, and as a king, he rules the solar system.
            The Sun-god then passed this down to 'Manu', the administrative father of the earth (from whom the word 'Man' originates), who then passed it to King Ikshvaku, the founder of the earthly solar dynasty (Lord Rama's ancestor).
            The Lord is proving that this specific science of the Gita is heavily tailored for the 'Kings' and 'Kshatriyas' (The Executive/Administrative class) so they can rule society selflessly.
            This supreme knowledge is the ultimate, infallible 'Management Manual' absolutely mandatory for anyone holding a position of leadership.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            एवं परम्पराप्राप्तमिमं राजर्षयो विदुः |
            स कालेनेह महता योगो नष्टः परन्तप || २ ||
        """.trimIndent(),
        hindi = """
            हे परन्तप (शत्रुओं को तपाने वाले अर्जुन)! इस प्रकार गुरु-शिष्य परम्परा से प्राप्त इस योग को महान राजर्षियों (राजा जो भीतर से ऋषि हैं) ने जाना।
            परंतु समय के एक बहुत बड़े अंतराल (महता कालेन) के प्रभाव से वह महान योग इस पृथ्वी पर लगभग लुप्त (नष्ट) हो गया।
            भगवान श्रीकृष्ण यहाँ सनातन धर्म के सबसे महत्वपूर्ण सिद्धांत 'गुरु-शिष्य परम्परा' (Disciplic Succession) की बात कर रहे हैं।
            आध्यात्मिक ज्ञान कोई ऐसी चीज़ नहीं है जिसे इंसान केवल किताबें पढ़कर या अपनी बुद्धि से सोचकर पा ले; यह ज्ञान एक योग्य गुरु से योग्य शिष्य तक एक अटूट श्रृंखला (Chain) में बहना चाहिए।
            इसे 'राजर्षियों' ने जाना—अर्थात् वे लोग जो बाहर से एक राजा की तरह शक्तिशाली थे, लेकिन भीतर से एक ऋषि की तरह शांत और वैरागी थे (जैसे राजा जनक)।
            लेकिन श्रीकृष्ण बताते हैं कि समय के साथ, जब अयोग्य लोगों ने अपने स्वार्थ और अहंकार के लिए इस ज्ञान की गलत व्याख्या (Misinterpretation) करनी शुरू कर दी, तो यह परंपरा टूट गई।
            'योगो नष्टः' का अर्थ यह नहीं है कि ज्ञान पूरी तरह से मिट गया (ज्ञान कभी नहीं मरता), बल्कि इसका अर्थ है कि ज्ञान का 'मूल और शुद्ध रूप' (Original Essence) दुनिया से गायब हो गया।
            आज भी दुनिया में ऐसे बहुत से तथाकथित ज्ञानी हैं जो गीता का मनमाना अर्थ निकालते हैं; इसीलिए भगवान को अवतार लेकर उस परंपरा को दोबारा से रीसेट (Reset/Re-establish) करना पड़ता है।
        """.trimIndent(),
        english = """
            O subduer of enemies (Parantapa)! This supreme science was thus received through the continuous chain of disciplic succession (Parampara), and the saintly kings (Rajarshis) understood it in that way.
            But in the course of time (Mahata kalena), the succession was broken, and therefore the science as it is appears to be lost (Nashtah).
            Lord Sri Krishna is introducing the absolute, foundational principle of Sanatana Dharma here: 'Guru-Shishya Parampara' (the unbroken chain of Disciplic Succession).
            Supreme spiritual knowledge is absolutely not something a human being can invent through intellectual speculation or merely by reading books; it must flow downwards from a highly qualified Guru to a qualified disciple through an unbroken chain.
            It was understood by 'Rajarshis'—meaning phenomenal leaders who were immensely powerful kings on the outside, but completely detached, serene sages on the inside (like King Janaka).
            However, Sri Krishna explains that over a massive period of time, when unqualified, greedy people began aggressively misinterpreting this knowledge for their own selfish motives, the pure chain was shattered.
            'Yogo nashtah' absolutely does not mean the eternal knowledge died; it means the 'Original, Pure Essence' of the knowledge was obscured and lost to the world.
            Even today, millions of so-called scholars arrogantly misinterpret the Gita for their own agendas; this is exactly why the Supreme Lord must personally descend to 'Reset' and re-establish the original, pure Parampara.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            स एवायं मया तेऽद्य योगः प्रोक्तः पुरातनः |
            भक्तोऽसि मे सखा चेति रहस्यं ह्येतदुत्तमम् || ३ ||
        """.trimIndent(),
        hindi = """
            वही यह अत्यंत प्राचीन (पुरातन) योग आज मैंने तुम्हें दोबारा बताया है, क्योंकि तुम मेरे भक्त (भक्तः) और मेरे सखा (मित्र) हो।
            वास्तव में, यह ज्ञान एक बहुत ही उत्तम और परम रहस्य (रहस्यं) है।
            अर्जुन के मन में एक स्वाभाविक सवाल उठ सकता था कि "हे कृष्ण, दुनिया में इतने बड़े-बड़े विद्वान, तपस्वी और ज्ञानी बैठे हैं, फिर आपने यह महान ज्ञान दोबारा शुरू करने के लिए मुझे ही क्यों चुना?"
            श्रीकृष्ण इस श्लोक में आध्यात्मिक ज्ञान प्राप्त करने की सबसे बड़ी और एकमात्र 'योग्यता' (Qualification) बता रहे हैं।
            भगवान अर्जुन से कहते हैं कि मैंने तुम्हें इसलिए नहीं चुना क्योंकि तुम दुनिया के सबसे बड़े तीरंदाज हो, या बहुत पढ़े-लिखे हो। मैंने तुम्हें इसलिए चुना है क्योंकि तुम मेरे 'भक्त' (Devotee) और 'सखा' (Friend) हो।
            आध्यात्मिक ज्ञान (विशेषकर गीता का ज्ञान) कोई बौद्धिक पहेली (Intellectual Puzzle) नहीं है जिसे केवल होशियार दिमाग से सुलझाया जा सके। यह एक 'उत्तम रहस्य' (Supreme Secret) है।
            यह रहस्य केवल उसी के सामने खुलता है जिसके हृदय में ईश्वर के प्रति प्रेम, समर्पण और विश्वास (श्रद्धा) होता है।
            जो व्यक्ति भगवान को अपना प्रतिद्वंद्वी (Rival) या केवल एक साधारण इंसान मानता है, उसके लिए गीता के श्लोक केवल कुछ संस्कृत के शब्द ही बनकर रह जाते हैं। लेकिन एक प्रेमी भक्त के लिए यह भगवान का सीधा हृदय (Heart) है।
        """.trimIndent(),
        english = """
            That very same ancient (Puratanah) science of the relationship with the Supreme is today being spoken by Me to you because you are My devotee (Bhakta) as well as My friend (Sakha).
            Indeed, this science is the absolute supreme mystery (Rahasyam).
            A highly natural, logical question could have easily popped into Arjuna's mind: "O Krishna, there are thousands of massive scholars, ascetic monks, and great philosophers in the world. Why on earth did You choose me to restart this ancient knowledge?"
            Sri Krishna reveals the absolute ultimate, singular 'Qualification' required to actually receive and understand supreme spiritual knowledge.
            The Lord tells Arjuna: I absolutely did not choose you because you are the world's deadliest archer, nor because you are highly educated. I chose you purely because you are My 'Devotee' (Bhakta) and My dear 'Friend' (Sakha).
            Supreme spiritual knowledge (especially the Gita) is absolutely not some complex intellectual puzzle that can be cracked by a high-IQ brain. It is an 'Uttamam Rahasyam' (Supreme, deeply hidden Secret).
            This ultimate secret flawlessly reveals itself only to that specific heart which is overflowing with pure love, deep submission, and absolute faith (Shraddha) toward the Supreme Lord.
            For an arrogant academic scholar who views God as a myth or a competitor, the Gita remains nothing more than a bunch of complex Sanskrit verses. But for a loving devotee, it becomes the direct, beating heart of God.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            अर्जुन उवाच |
            अपरं भवतो जन्म परं जन्म विवस्वतः |
            कथमेतद्विजानीयां त्वमादौ प्रोक्तवानिति || ४ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने पूछा: आपका जन्म तो अभी हाल ही का (अपरं/बाद का) है, जबकि सूर्यदेव (विवस्वान) का जन्म अत्यंत प्राचीन (परं/बहुत पहले का) है।
            तो फिर मैं यह बात कैसे मान लूँ (कथं विजानीयां) कि सृष्टि के आरंभ में आपने ही उन्हें यह योग सिखाया था?
            अर्जुन यहाँ एक बहुत ही तार्किक (Logical) और 'सामान्य इंसान' वाला सवाल पूछ रहे हैं। यह सवाल हमारे मन में भी आता है।
            अर्जुन और कृष्ण दोनों एक ही काल में पैदा हुए हैं, दोनों एक साथ पले-बढ़े हैं, और दोनों आपस में चचेरे-ममेरे भाई जैसे रिश्ते में हैं। अर्जुन ने कृष्ण को हमेशा एक इंसान और अपने एक प्रिय मित्र के रूप में देखा है।
            जब कृष्ण अचानक यह दावा करते हैं कि "मैंने यह ज्ञान करोड़ों साल पहले सूर्यदेव को दिया था", तो अर्जुन का गणितीय दिमाग (Mathematical Brain) इसे प्रोसेस (Process) नहीं कर पाता।
            अर्जुन कहते हैं, "सूर्य तो करोड़ों साल से है, और आपका जन्म तो मेरे साथ कुछ दशक पहले वासुदेव-देवकी के यहाँ हुआ है। तो आप उन्हें ज्ञान कैसे दे सकते हैं?"
            अर्जुन वास्तव में यह सवाल अपने लिए नहीं, बल्कि भविष्य के उन नास्तिकों और संदेह करने वाले लोगों के लिए पूछ रहे हैं, जो कृष्ण को केवल एक साधारण ऐतिहासिक महापुरुष मानेंगे।
            इस सवाल के बहाने अर्जुन भगवान से उनके असली 'ईश्वरीय स्वरूप' (Divine Identity) और उनके 'अवतार' के विज्ञान को प्रकट करवाना चाहते हैं।
        """.trimIndent(),
        english = """
            Arjuna logically inquired: Your birth is entirely recent (Aparam), whereas the birth of the sun-god (Vivasvan) is extremely ancient (Param).
            How am I to possibly understand and believe that You instructed this supreme science to him at the very beginning of creation?
            Arjuna is asking an incredibly logical, highly rational, and completely 'normal human' question here—a question that perfectly echoes the doubts of modern man.
            Arjuna and Krishna were born in the exact same timeline, they grew up together playing, and they share a close familial relationship. Arjuna has always viewed Krishna as a highly phenomenal human being and his best friend.
            When Krishna suddenly drops the massive claim that "I gave this knowledge millions of years ago to the Sun-god," Arjuna's mathematical, chronological brain simply fails to process it.
            Arjuna essentially asks, "The Sun has existed for billions of years, whereas You took birth with me just a few decades ago in the house of Vasudeva. How could You possibly have taught him?"
            In reality, Arjuna is asking this brilliant question not for his own sake, but specifically for the future generations of atheists and skeptics who would foolishly consider Krishna to be merely an ordinary historical human figure.
            Using this brilliant question as a catalyst, Arjuna is setting the perfect stage for the Lord to officially reveal the highly classified, supreme science of His 'Divine Identity' and 'Avatarhood'.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            श्रीभगवानुवाच |
            बहूनि मे व्यतीतानि जन्मानि तव चार्जुन |
            तान्यहं वेद सर्वाणि न त्वं वेत्थ परन्तप || ५ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे अर्जुन! मेरे और तुम्हारे बहुत से जन्म पहले ही बीत चुके हैं (बहूनि व्यतीतानि)।
            मैं उन सभी जन्मों को पूरी तरह से जानता हूँ (वेद सर्वाणि), परंतु हे परन्तप! तुम उन्हें बिल्कुल नहीं जानते (न त्वं वेत्थ)।
            इस एक झटके में भगवान श्रीकृष्ण जीव (आत्मा) और ईश्वर (परमात्मा) के बीच का सबसे बड़ा और बुनियादी अंतर (Fundamental Difference) स्पष्ट कर देते हैं।
            वे कहते हैं कि अर्जुन, यह तुम्हारा या मेरा पहला जन्म नहीं है। तुम भी करोड़ों बार जन्म ले चुके हो और मैं भी अनगिनत बार इस पृथ्वी पर आ चुका हूँ।
            लेकिन अंतर क्या है? अर्जुन एक साधारण जीवात्मा हैं, जो हर बार जन्म लेने पर जब नया शरीर (Hardware) पाते हैं, तो उनका पिछला सारा मेमोरी कार्ड (Memory Card) फॉर्मेट (Format) हो जाता है। प्रकृति (माया) उन्हें सब कुछ भुला देती है।
            परंतु भगवान माया के अधीन नहीं हैं; वे 'मायापति' (माया के स्वामी) हैं। ईश्वर कभी अपनी सर्वज्ञता (Omniscience) नहीं खोता।
            भगवान कह रहे हैं कि "मुझे वह करोड़ों साल पुरानी घटना आज भी उसी तरह याद है जैसे वह कल की बात हो, क्योंकि मेरी चेतना (Consciousness) कभी नहीं मिटती।"
            यह श्लोक सिद्ध करता है कि कृष्ण कोई साधारण इंसान नहीं हैं जिन्होंने योग से शक्तियां पाई हों, बल्कि वे स्वयं अनादि और अनंत परमेश्वर हैं।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead majestically replied: Many, many births both you and I have passed.
            I can perfectly remember all of them (Tany aham veda sarvani), but you absolutely cannot remember them (Na tvam vettha), O subduer of the enemy (Parantapa)!
            In one spectacular, mind-bending stroke, Lord Sri Krishna clearly establishes the absolute, fundamental difference between the tiny individual soul (Jiva) and the Supreme Lord (Ishvara).
            He declares to Arjuna: This is absolutely not your first birth, nor is it Mine. You have taken birth millions of times, and I have also descended to this earth countless times.
            But what is the colossal difference? Arjuna is an ordinary, tiny individual soul. Every single time he gets a new physical body (Hardware), his entire past 'Memory Card' is brutally formatted and wiped clean by the laws of material nature (Maya).
            However, the Supreme Lord is absolutely never under the control of Maya; He is 'Mayapati' (The Absolute Master of Illusion). God never, ever loses His 'Omniscience'.
            The Lord is stating, "I perfectly remember that specific incident with the Sun-god from billions of years ago as clearly as if it happened yesterday, because My divine consciousness is never erased."
            This spectacular verse definitively proves that Krishna is absolutely not just some ordinary human who achieved mystical powers through meditation; He is the eternal, beginningless, and infinite Supreme Personality of Godhead Himself.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            अजोऽपि सन्नव्ययात्मा भूतानामीश्वरोऽपि सन् |
            प्रकृतिं स्वामधिष्ठाय सम्भवाम्यात्ममायया || ६ ||
        """.trimIndent(),
        hindi = """
            यद्यपि मैं अजन्मा (जिसका कभी जन्म नहीं होता) हूँ, और मेरा शरीर अविनाशी (अव्ययात्मा) है, तथा मैं सभी प्राणियों का परम ईश्वर (ईश्वरः) हूँ...
            फिर भी, मैं अपनी प्रकृति (अपनी मूल शक्ति) को अपने अधीन करके, अपनी ही योगमाया (आत्ममायया) के द्वारा इस संसार में प्रकट होता हूँ (सम्भवामि)।
            यह श्लोक भगवान के 'अवतार' (Incarnation) के रहस्य का सबसे गहरा और वैज्ञानिक स्पष्टीकरण (Explanation) है।
            साधारण इंसान कर्मों के बंधन (Karma) के कारण मजबूरी में जन्म लेता है। उसे प्रकृति तय करके देती है कि वह कुत्ता बनेगा, राजा बनेगा या भिखारी बनेगा।
            लेकिन भगवान कह रहे हैं कि मेरा कोई 'कर्म' नहीं है। मैं 'अजः' (अजन्मा) हूँ, मुझे जन्म लेने की कोई मजबूरी नहीं है। मैं ब्रह्मांड का 'ईश्वर' (मालिक) हूँ।
            तो फिर मैं धरती पर कैसे आता हूँ? "प्रकृतिं स्वामधिष्ठाय"—मैं किसी भौतिक माँ के पेट से साधारण तरीके से नहीं बनता, बल्कि मैं अपनी ही 'योगमाया' (दिव्य शक्ति) का उपयोग करके अपने 100% शुद्ध, आध्यात्मिक और अविनाशी रूप (अव्ययात्मा) में ही सीधे प्रकट (Manifest) हो जाता हूँ।
            साधारण इंसान का शरीर हड्डी और मांस का बना होता है, लेकिन भगवान का शरीर सच्चिदानंद (सत्य, ज्ञान, आनंद) का बना होता है, चाहे वह इंसान के रूप में ही क्यों न दिखे।
            भगवान जन्म नहीं लेते, वे बस 'प्रकट' (Appear) होते हैं, जैसे सूरज सुबह प्रकट होता है। सूरज का जन्म नहीं होता, वह बस हमारे सामने आ जाता है।
        """.trimIndent(),
        english = """
            Although I am completely unborn (Aja) and My transcendental body never deteriorates (Avyayatma), and although I am the Supreme Lord of all living entities (Ishvarah)...
            I still appear in every millennium in My original transcendental form, establishing Myself by My own internal divine potency (Atma-mayaya).
            This staggering verse provides the absolute deepest, most highly classified, and scientific explanation of the supreme phenomenon of 'Avatar' (Divine Incarnation).
            An ordinary, conditioned human being takes birth purely out of brutal compulsion, strictly forced by his past Karmic debts. Material nature forcibly dictates whether he will be born as a dog, a billionaire, or a beggar.
            But the Supreme Lord declares: I have absolutely zero Karmic debt. I am 'Aja' (The Unborn); there is absolutely no cosmic law that can force Me to take birth. I am the absolute 'Ishvara' (Master) of the entire universe.
            So how exactly do I come to earth? "Prakritim svam adhishthaya"—I absolutely do not take a forced material birth forced through biology. Instead, I utilize My own 'Yoga-Maya' (Supreme Internal Potency) to directly 'Manifest' (Appear) in My 100% pure, spiritual, and indestructible original form (Avyayatma).
            An ordinary human's body is manufactured from blood, bones, and dirt, but the Lord's body is composed entirely of Sacchidananda (Eternity, Knowledge, and Bliss), even if He visually appears to look like an ordinary human.
            God absolutely does not 'take birth'; He simply 'Appears', exactly like the sun appears on the horizon in the morning. The sun is not born at dawn; it merely manifests before our vision.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            यदा यदा हि धर्मस्य ग्लानिर्भवति भारत |
            अभ्युत्थानमधर्मस्य तदात्मानं सृजाम्यहम् || ७ ||
        """.trimIndent(),
        hindi = """
            हे भारत (अर्जुन)! जब-जब भी धर्म (सच्चाई और न्याय) की भारी हानि (ग्लानि) होती है...
            और अधर्म (पाप और अन्याय) की बहुत अधिक वृद्धि (अभ्युत्थानम्) होने लगती है, तब-तब मैं स्वयं को (अपने रूप को) इस संसार में प्रकट (सृजाम्यहम्) करता हूँ।
            यह पूरी भगवद्गीता का सबसे लोकप्रिय और हर बच्चे की ज़ुबान पर रहने वाला श्लोक है। यह भगवान का इंसानियत के लिए सबसे बड़ा 'प्रॉमिस' (Promise/आश्वासन) है।
            यहाँ 'धर्म' का अर्थ कोई विशेष हिंदू, मुस्लिम या ईसाई धर्म नहीं है; धर्म का अर्थ है ब्रह्मांडीय संतुलन, न्याय, करुणा और सच्चाई (Cosmic Order & Righteousness)।
            समाज में पाप हमेशा रहता है, लेकिन जब बुराई इतनी ज्यादा बढ़ जाती है ('अभ्युत्थानम्') कि अच्छे और सच्चे लोगों का जीना असंभव हो जाए, और समाज का सिस्टम पूरी तरह से क्रैश (Crash) होने की कगार पर आ जाए...
            तब भगवान अपने नियम के अनुसार इस संतुलन को ठीक करने के लिए स्वयं धरती पर आते हैं।
            "यदा यदा" का अर्थ है कि भगवान के आने का कोई एक फिक्स टाइम (Fixed Time) नहीं है कि वे केवल एक ही बार आएंगे। जब भी (Whether in Satyayuga or Kaliyuga) समाज को उनकी सबसे ज्यादा जरूरत होती है, वे अवतार लेते हैं।
            यह श्लोक इंसानों को यह भरोसा देता है कि यह ब्रह्मांड लावारिस नहीं है; जब पानी सिर के ऊपर से गुजरता है, तो इसे बनाने वाला खुद इसकी सफाई करने आता है।
        """.trimIndent(),
        english = """
            Whenever and wherever there is a catastrophic decline in religious practice and righteousness (Dharmasya glanir), O descendant of Bharata...
            and a predominant, terrifying rise of irreligion and massive injustice (Abhyutthanam adharmasya)—at that very time I descend and manifest Myself personally (Tadatmanam srijamy aham).
            This is undisputedly the most famous, most universally recognized, and legendary verse in the entire Bhagavad Gita. It is the Supreme Lord's ultimate, iron-clad 'Promise' and absolute guarantee to humanity.
            Here, 'Dharma' absolutely does not refer to any localized, man-made religion or sect; Dharma refers to the supreme Cosmic Order, absolute justice, truth, and universal compassion.
            Petty sins and crimes always exist in society, but when absolute evil and terrifying tyranny rise to such a devastating, toxic level ('Abhyutthanam') that the survival of good, innocent people becomes totally impossible, and the very fabric of society is about to violently crash...
            at that exact critical moment, the Supreme Lord personally intervenes and descends to earth to aggressively reset the balance.
            "Yada yada" emphatically means that the Lord's arrival is not limited to just one single, restricted historical event. Whenever and wherever (whether thousands of years ago or in the future) the cosmic system faces a fatal threat, He incarnates.
            This spectacular verse gives humanity the ultimate, unshakeable psychological comfort that this universe is absolutely not an abandoned orphanage; when the darkness becomes utterly unbearable, the Creator Himself steps in to brutally cleanse it.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            परित्राणाय साधूनां विनाशाय च दुष्कृताम् |
            धर्मसंस्थापनार्थाय सम्भवामि युगे युगे || ८ ||
        """.trimIndent(),
        hindi = """
            साधु पुरुषों (भक्तों और अच्छे लोगों) का उद्धार और रक्षा (परित्राणाय) करने के लिए, और पाप कर्म करने वाले दुष्टों का पूरी तरह विनाश (विनाशाय) करने के लिए...
            तथा धर्म (सच्चाई और न्याय) की भली-भांति स्थापना (संस्थापनार्थाय) करने के लिए, मैं हर युग में (युगे युगे) प्रकट होता हूँ।
            पिछले श्लोक में भगवान ने बताया था कि वे 'कब' आते हैं, इस श्लोक में वे बताते हैं कि वे 'क्यों' आते हैं (अवतार का उद्देश्य क्या है)।
            भगवान के आने के मुख्य रूप से तीन एजेंडे (Agendas) होते हैं:
            १. 'परित्राणाय साधूनां': जो लोग बहुत अच्छे हैं, निर्दोष हैं और भगवान से प्रेम करते हैं (जैसे प्रह्लाद, द्रौपदी या पांडव), जब दुनिया उन्हें बहुत सताती है, तो भगवान केवल उन्हें बचाने और अपना प्यार देने आते हैं। (यह उनका सबसे मुख्य कारण है)।
            २. 'विनाशाय च दुष्कृताम्': रावण, कंस या दुर्योधन जैसे महापापियों का विनाश करने के लिए। (हालाँकि दुष्टों को मारने का काम तो भगवान प्रकृति के किसी भूकंप या बीमारी से भी करवा सकते हैं, लेकिन वे खुद आते हैं ताकि भक्तों को उनका दर्शन मिल सके)।
            ३. 'धर्मसंस्थापनार्थाय': समाज में फिर से एक ऐसा सिस्टम (Constitution) स्थापित करना जहाँ न्याय और सत्य की जीत हो।
            "युगे युगे" का अर्थ है कि भगवान का यह रेस्क्यू ऑपरेशन (Rescue Operation) हर उस युग में होता है जब-जब दुनिया खतरे में होती है। यह श्लोक भगवान की असीम दया और उनके सख्त न्याय (Justice) का परफेक्ट बैलेंस है।
        """.trimIndent(),
        english = """
            To deliver the pious and specifically protect My pure devotees (Paritranaya sadhunam), and to completely annihilate the miscreants and tyrants (Vinashaya cha dushkritam)...
            as well as to firmly and permanently re-establish the supreme principles of religion (Dharma-samsthapanarthaya), I Myself advent and appear millennium after millennium (Yuge yuge).
            While the previous verse stated 'When' the Lord descends, this highly explosive verse details exactly 'Why' He descends (The absolute Mission Objective of an Avatar).
            The Supreme Lord descends with a highly specific, three-point cosmic agenda:
            1. 'Paritranaya sadhunam': When intensely pure, innocent, and deeply loving devotees (like Prahlada, Draupadi, or the Pandavas) are violently tortured by the world, the Lord descends purely to rescue them and give them His personal, loving association. (This is His absolute primary motive).
            2. 'Vinashaya cha dushkritam': To ruthlessly slaughter and violently annihilate massive global terrorists and tyrants like Ravana, Kamsa, or Duryodhana. (Although the Lord could easily kill them using a simple virus or an earthquake, He comes personally to grant joy to His devotees while doing the cleansing).
            3. 'Dharma-samsthapanarthaya': To aggressively reset the corrupted system and firmly re-establish a flawless, functioning societal Constitution where absolute truth and justice reign supreme.
            "Yuge yuge" guarantees that this massive Divine Rescue Operation is executed in every single age whenever the planet faces total destruction. This verse is the ultimate, flawless balance of the Lord's infinite compassion and His terrifying, uncompromising justice.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            जन्म कर्म च मे दिव्यमेवं यो वेत्ति तत्त्वतः |
            त्यक्त्वा देहं पुनर्जन्म नैति मामेति सोऽर्जुन || ९ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! मेरे जन्म और मेरे कर्म पूरी तरह से 'दिव्य' (अलौकिक और आध्यात्मिक) हैं। जो मनुष्य इस बात को तत्त्व से (गहराई से और सचमुच) जान लेता है...
            वह मनुष्य इस शरीर को त्यागने के बाद संसार में फिर से जन्म नहीं लेता (पुनर्जन्म नैति), बल्कि वह सीधा मुझे ही प्राप्त होता है (मामेति)।
            यह श्लोक मोक्ष (Liberation) प्राप्त करने का एक बहुत ही आसान और अद्भुत शॉर्टकट (Shortcut) बताता है।
            साधारण लोग सोचते हैं कि कृष्ण तो हमारी तरह ही पैदा हुए थे, उन्होंने माखन चुराया, युद्ध लड़ा, और फिर मर गए। जो लोग कृष्ण को एक साधारण ऐतिहासिक इंसान मानते हैं, वे अज्ञान में हैं।
            लेकिन भगवान कहते हैं कि मेरा जन्म और मेरे काम 'दिव्य' (Divine/Transcendental) हैं। मेरा शरीर भौतिक (Material) नहीं है, मेरी लीलाएं कोई साधारण इंसान के काम नहीं हैं; उनके पीछे ब्रह्मांड का सबसे गहरा आध्यात्मिक विज्ञान है।
            जो व्यक्ति इस 'तत्त्व' (Truth) को केवल पढ़ता नहीं, बल्कि गहराई से 'समझ' लेता है (वेत्ति तत्त्वतः), उस व्यक्ति का हृदय भगवान के प्रेम से भर जाता है।
            और जैसे ही इंसान इस सत्य को महसूस कर लेता है, उसका इस माया की दुनिया से कनेक्शन कट जाता है।
            मृत्यु के बाद उसे फिर से माँ के गर्भ में नौ महीने उल्टा लटकने का कष्ट नहीं सहना पड़ता। उसका पुनर्जन्म का चक्र हमेशा के लिए टूट जाता है और वह सीधे भगवान के परम धाम (वैकुंठ/गोलोक) में एंट्री पा लेता है।
        """.trimIndent(),
        english = """
            O Arjuna, One who perfectly knows the absolute transcendental and divine nature (Divyam) of My appearance and activities...
            does not, upon leaving this physical body, take his birth again in this miserable material world (Punarjanma naiti), but directly and eternally attains My supreme abode (Mam eti).
            This spectacular verse reveals an incredibly profound, direct, and almost magical 'Shortcut' to achieving ultimate liberation (Moksha).
            Ordinary, foolish people heavily mistakenly believe that Krishna was born exactly like us, stole butter like an ordinary child, fought political wars, and then died. Those who view Krishna merely as an ordinary historical figure are trapped in deep illusion.
            But the Supreme Lord declares that His birth and His actions are absolutely 'Divyam' (100% Divine, Spiritual, and Transcendental). His body is not made of mortal flesh, and His pastimes are not ordinary human activities; they carry the absolute deepest spiritual science of the cosmos.
            A person who doesn't merely read this, but profoundly and experientially 'understands' this absolute truth (vetti tattvatah), finds his heart instantly flooded with supreme divine love.
            And the very microsecond a human being realizes this staggering truth, his entire connection to this toxic material matrix is permanently severed.
            After physical death, he absolutely never has to suffer the horror of hanging upside down in a mother's womb for nine months ever again. His cycle of reincarnation is permanently shattered, and he gets direct, VIP entry into the Lord's eternal, supreme abode (Vaikuntha/Goloka).
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            वीतरागभयक्रोधा मन्मया मामुपाश्रिताः |
            बहवो ज्ञानतपसा पूता मद्भावमागताः || १० ||
        """.trimIndent(),
        hindi = """
            जो राग (आसक्ति), भय (डर) और क्रोध (गुस्से) से पूरी तरह मुक्त हो चुके हैं (वीतरागभयक्रोधाः), जो पूरी तरह से मुझमें ही तन्मय रहते हैं (मन्मया), और जिन्होंने केवल मेरी ही शरण ली है (मामुपाश्रिताः)...
            ऐसे बहुत से लोग ज्ञान रूपी तपस्या से पूरी तरह पवित्र (पूता) होकर, मेरे उस परम भाव (ईश्वरीय प्रेम और दिव्य अवस्था) को पहले भी प्राप्त हो चुके हैं।
            अर्जुन को लग सकता था कि "भगवान को समझना इतना आसान है क्या? क्या सच में कोई मोक्ष तक पहुँचा है?" श्रीकृष्ण इसका ऐतिहासिक प्रमाण (Historical Proof) दे रहे हैं।
            वे कहते हैं कि यह कोई नई थ्योरी नहीं है। प्राचीन काल में भी 'बहवो' (बहुत सारे) लोग इस रास्ते पर चलकर परम अवस्था (मद्भाव) को प्राप्त कर चुके हैं।
            लेकिन उन महापुरुषों ने किया क्या था? उन्होंने तीन सबसे भयंकर मानसिक बीमारियों का इलाज किया था: 'राग' (सांसारिक चीजों से चिपके रहना), 'भय' (चीजों के खोने का डर), और 'क्रोध' (इच्छा पूरी न होने पर आने वाला गुस्सा)।
            जब दिमाग से ये तीन कचरे निकल जाते हैं, तो दिमाग खाली हो जाता है। उस खाली दिमाग में उन्होंने 'मन्मया' (मुझसे भरे हुए) होकर ईश्वर का ध्यान किया।
            उन्होंने किसी और देवता या शॉर्टकट का सहारा नहीं लिया, बल्कि 100% 'मामुपाश्रिताः' (मेरी ही शरण ली)।
            यह 'ज्ञानतपसा' (ज्ञान रूपी आग की तपस्या) उनके सारे जन्मों के पापों को जलाकर उन्हें शुद्ध ('पूता') कर देती है, और अंततः वे भगवान के ही समान दिव्य आनंद को प्राप्त कर लेते हैं।
        """.trimIndent(),
        english = """
            Being completely and permanently freed from all false attachment, paralyzing fear, and violent anger (Vita-raga-bhaya-krodhah), being fully absorbed in Me (Manmaya), and taking absolute refuge only in Me (Mam upashritah)...
            many, many persons in the past became totally purified (Putah) by the blazing fire of knowledge (Jnana-tapasa)—and thus they all attained transcendental love and My exact divine nature (Mad-bhavam).
            Arjuna might have deeply doubted: "Is realizing God really this simple? Has anyone in history actually ever achieved this ultimate liberation?" Sri Krishna is providing the absolute Historical Proof here.
            He declares that this is absolutely not an untested, theoretical hypothesis. In ancient times, 'Bahavo' (millions of people) successfully walked this exact path and achieved the supreme, ultimate perfection (Mad-bhavam).
            But what exactly did those elite masters do? They violently cured themselves of the mind's three deadliest psychological diseases: 'Raga' (toxic addiction to worldly things), 'Bhaya' (the paralyzing terror of losing them), and 'Krodha' (the violent anger when frustrated).
            When these three massive mountains of garbage are cleared out, the mind becomes a pristine vacuum. Into that pure vacuum, they became 'Manmaya' (100% fully absorbed in the thought of Me).
            They did not seek pathetic shortcuts or take shelter of lesser demigods; they were 'Mam upashritah' (taking 100% absolute refuge exclusively in the Supreme Lord).
            This 'Jnana-tapasa' (the severe austerity of the blazing fire of knowledge) brutally incinerated all their sins from millions of lifetimes, making them impeccably pure ('Putah'), and ultimately, they attained the exact same divine, ecstatic nature as God Himself.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            ये यथा मां प्रपद्यन्ते तांस्तथैव भजाम्यहम् |
            मम वर्त्मानुवर्तन्ते मनुष्याः पार्थ सर्वशः || ११ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य जिस भाव से (यथा) मेरी शरण में आता है (मुझसे जुड़ता है), मैं भी उसे उसी प्रकार (तथा एव) फल देकर संतुष्ट करता हूँ (भजाम्यहम्)।
            हे पार्थ! सभी मनुष्य सब प्रकार से मेरे ही मार्ग का अनुसरण करते हैं (यानी हर कोई अंततः मुझे ही ढूँढ रहा है)।
            यह श्लोक ईश्वर के पूर्ण 'न्याय' (Absolute Justice) और उनकी असीम दया का सबसे महान और स्पष्ट नियम है।
            दुनिया अक्सर पूछती है कि अगर भगवान एक है, तो वह सबको एक जैसा फल क्यों नहीं देता? कोई बहुत खुश क्यों है और कोई दुःखी क्यों है?
            भगवान कहते हैं, "मैं एक आईने (Mirror) की तरह हूँ। तुम मेरे सामने जो भाव लेकर आओगे, मैं तुम्हें वही वापस दूँगा।"
            अगर कोई इंसान भगवान को केवल 'पैसे देने वाली मशीन' मानकर उनकी पूजा करता है, तो भगवान उसे पैसा देकर उसका हिसाब चुकता कर देते हैं (उसे अपना प्रेम नहीं देते)।
            अगर कोई कंस की तरह भगवान को अपना 'दुश्मन' मानता है, तो भगवान दुश्मन बनकर उसका वध कर देते हैं।
            लेकिन अगर कोई गोपियों या अर्जुन की तरह भगवान को अपना 'सबसे प्रिय मित्र या प्रेमी' मानकर बिना स्वार्थ के प्यार करता है, तो भगवान भी उसके दास बनकर उसे अपना 100% प्रेम दे देते हैं।
            संसार में हर इंसान जो भी कर रहा है (चाहे वह पैसे के पीछे भाग रहा हो या विज्ञान के पीछे), वह अनजाने में आनंद (यानी ईश्वर) को ही ढूँढ रहा है ('मम वर्त्मानुवर्तन्ते')। भगवान हर किसी को उसकी इच्छा और नीयत के अनुसार 100% सटीक फल देते हैं।
        """.trimIndent(),
        english = """
            As all surrender unto Me (Ye yatha mam prapadyante), I accurately reward them accordingly (Tams tathaiva bhajamy aham).
            O son of Pritha, all human beings, in all respects and in every possible way, are following My path alone (Mama vartmanuvartante).
            This specific verse is the absolute, most magnificent, and crystal-clear declaration of God's 'Absolute Justice' and infinite reciprocation.
            The ignorant world constantly questions: If God is one and equally merciful to all, why doesn't He give the exact same reward to everyone? Why is someone ecstatic while someone else is suffering?
            The Lord brilliantly replies, "I act exactly like a flawless, cosmic Mirror. Whatever specific intention and emotion you approach Me with, I will accurately reflect and reciprocate that exact same thing back to you."
            If a greedy human being approaches God treating Him merely as an 'ATM Machine', God hands him the cash and completely settles the transaction (but strictly denies him His personal love).
            If a demonic tyrant like Kamsa aggressively treats God as his 'Bitter Enemy', God reciprocates perfectly by becoming his executioner and slaughtering him.
            But if a pure soul like Arjuna or the Gopis approaches God out of absolutely selfless, unconditional love as a 'Best Friend or Lover', the Supreme Lord completely subordinates Himself and gives them 100% of His heart.
            Every single human on earth (whether chasing billions of dollars or scientific truths) is unknowingly and desperately searching for absolute bliss (which is God Himself). The Lord perfectly rewards everyone strictly according to their specific desires and pure intentions.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            काङ्क्षन्तः कर्मणां सिद्धिं यजन्त इह देवताः |
            क्षिप्रं हि मानुषे लोके सिद्धिर्भवति कर्मजा || १२ ||
        """.trimIndent(),
        hindi = """
            इस संसार में जो लोग अपने कर्मों की सिद्धि (सफलता और भौतिक फल) की बहुत अधिक इच्छा (काङ्क्षन्तः) रखते हैं, वे देवताओं की पूजा (यजन्त) करते हैं।
            क्योंकि इस मनुष्य लोक (पृथ्वी) में कर्मों से उत्पन्न होने वाली सिद्धि (सफलता) बहुत जल्दी (क्षिप्रं) मिल जाती है।
            भगवान श्रीकृष्ण यहाँ मानव मनोविज्ञान (Human Psychology) की एक बहुत बड़ी कमज़ोरी बता रहे हैं—'क्विक रिज़ल्ट्स' (Quick Results / जल्दी सफलता पाने की भूख)।
            लोग भगवान (परमेश्वर) की निष्काम भक्ति (जिसमें मोक्ष मिलता है) क्यों नहीं करते? क्योंकि मोक्ष और आत्मशुद्धि एक लंबी और कठिन प्रक्रिया है, जिसमें इंसान को अपना अहंकार छोड़ना पड़ता है।
            साधारण इंसान को मोक्ष नहीं चाहिए; उसे जल्दी से एक अच्छी नौकरी, सुंदर पत्नी, बीमारी से छुटकारा, या चुनाव में जीत चाहिए।
            इन छोटी-मोटी भौतिक इच्छाओं को जल्दी पूरा करने के लिए लोग ब्रह्मांड के विभागीय मंत्रियों (Departmental Ministers) यानी 'देवताओं' (Demigods) की पूजा करते हैं।
            देवताओं की पूजा एक व्यापार (Business Transaction) की तरह है—"मैं तुम्हें इतने नारियल चढ़ाऊंगा, तुम मेरा यह काम कर दो।"
            चूँकि इस पृथ्वी ('मानुषे लोके') पर लोगों को इंस्टेंट ग्रैटिफिकेशन (Instant Gratification) चाहिए, और देवताओं की पूजा से उन्हें भौतिक सफलता ('सिद्धि') बहुत जल्दी ('क्षिप्रं') मिल भी जाती है, इसलिए ज्यादातर लोग इसी रास्ते पर भागते हैं।
            लेकिन यह सफलता अस्थायी (Temporary) होती है और यह आत्मा को कभी परम शांति नहीं दे सकती।
        """.trimIndent(),
        english = """
            Those who strongly desire massive success and quick fruitive results from their activities in this material world continuously worship the demigods (Devatah).
            Because in this human world, the material success (Siddhi) born from such fruitive work undeniably comes very quickly (Kshipram).
            Lord Sri Krishna is surgically exposing a massive, fatal flaw in human psychology here—the desperate, pathetic hunger for 'Quick Results' (Instant Gratification).
            Why do the vast majority of people completely avoid the pure, selfless devotional service of the Supreme Lord (which grants eternal Moksha)? Because true self-realization is a profound, lifelong process that violently demands the complete slaughter of one's false ego.
            An ordinary, ignorant mortal absolutely does not want eternal liberation; he desperately wants a high-paying job, a beautiful spouse, a cure for a disease, or to win a petty election immediately.
            To rapidly fulfill these tiny, insignificant material desires, people bypass the Supreme Lord and worship the 'Demigods' (the appointed Departmental Ministers of the cosmos).
            Worshiping demigods is exactly like a cheap 'Business Transaction'—"I will offer you ten coconuts, and you must instantly clear my bank loan."
            Because humans on this planet ('Manushe loke') are intensely addicted to instant gratification, and because worshiping demigods actually does grant material success ('Siddhi') extremely fast ('Kshipram'), 99% of the population blindly rushes down this exact path.
            But this cheap success is horribly temporary and can absolutely never, ever grant the soul permanent, eternal peace.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            चातुर्वर्ण्यं मया सृष्टं गुणकर्मविभागशः |
            तस्य कर्तारमपि मां विद्ध्यकर्तारमव्ययम् || १३ ||
        """.trimIndent(),
        hindi = """
            ब्राह्मण, क्षत्रिय, वैश्य और शूद्र—इन चार वर्णों (चातुर्वर्ण्यं) की व्यवस्था मेरे ही द्वारा लोगों के गुणों (स्वभाव) और कर्मों (कार्यों) के विभाग के आधार पर रची गई है।
            इस व्यवस्था का कर्ता (बनाने वाला) होने पर भी, तुम मुझे वास्तव में अकर्ता (कुछ न करने वाला) और अव्यय (अविनाशी) ही जानो।
            यह श्लोक सनातन धर्म के सबसे विवादित (Controversial) समझे जाने वाले विषय—'वर्ण व्यवस्था' (Caste System)—का सबसे सटीक और वैज्ञानिक स्पष्टीकरण है।
            श्रीकृष्ण स्पष्ट करते हैं कि समाज को चार हिस्सों (वर्णों) में बाँटने का नियम उन्होंने ही बनाया है। लेकिन यह बँटवारा 'जन्म' (Birth) या परिवार के आधार पर नहीं है!
            भगवान बहुत स्पष्ट कहते हैं: "गुण-कर्म-विभागशः"—यह वर्गीकरण इंसान की 'मानसिक प्रकृति' (Guna / क्वालिटी) और उसके 'काम' (Karma) के आधार पर है।
            १. ब्राह्मण (Intellectuals): जिनमें सत्त्वगुण (शांति/ज्ञान) ज्यादा है और जो पढ़ाने का काम करते हैं।
            २. क्षत्रिय (Administrators): जिनमें रजोगुण (लीडरशिप/वीरता) है और जो रक्षा का काम करते हैं।
            ३. वैश्य (Merchants): जो व्यापार और कृषि करते हैं।
            ४. शूद्र (Workers): जो अपनी मेहनत से ऊपर के तीनों की सेवा (नौकरी) करते हैं।
            यह बिल्कुल एक कंपनी (Company) के ऑर्गनाइजेशन चार्ट (Organization Chart) की तरह है।
            भगवान कहते हैं कि मैंने यह परफेक्ट सिस्टम बनाया जरूर है, लेकिन मैं इससे बंधा हुआ नहीं हूँ। मैं इन सब भेदों से ऊपर (अकर्ता) हूँ, क्योंकि ईश्वर न तो ब्राह्मण है और न शूद्र, वह परम निर्लिप्त (Detached) सत्ता है।
        """.trimIndent(),
        english = """
            According to the three modes of material nature and the work associated with them (Guna-karma-vibhagashah), the four divisions of human society (Chatur-varnyam) are perfectly created by Me.
            And although I am the absolute creator (Kartaram) of this system, you should know that I am yet the non-doer (Akartaram), being completely unchangeable and imperishable (Avyayam).
            This phenomenal verse provides the absolute most accurate, scientific, and authoritative explanation of what is arguably Sanatana Dharma's most heavily misunderstood topic: The 'Varna System' (Societal Divisions).
            Sri Krishna explicitly declares that He Himself engineered the division of human society into four distinct categories. But this division is absolutely, 100% NOT based on 'Birth', genetics, or family lineage!
            The Lord makes it brutally clear: "Guna-karma-vibhagashah"—This flawless classification is based purely on a human being's psychological nature/qualities (Guna) and his actual occupational activities (Karma).
            1. Brahmanas (Intellectuals): Dominated by Sattva (purity/knowledge), executing the work of teaching and advising.
            2. Kshatriyas (Administrators/Military): Dominated by Rajas (passion/courage), executing the work of governance and protection.
            3. Vaishyas (Merchants): Executing business, agriculture, and economics.
            4. Shudras (Workers): Providing manual labor and service assistance to the other three.
            It functions exactly like a highly efficient corporate Organization Chart designed to keep society stable.
            The Lord adds that although He engineered this flawless matrix, He is completely immune and unbound by it. He is the 'Akarta' (Non-doer), because the Supreme God is neither a Brahmana nor a Shudra; He is the supreme, detached, transcendental observer.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            न मां कर्माणि लिम्पन्ति न मे कर्मफले स्पृहा |
            इति मां योऽभिजानाति कर्मभिर्न स बध्यते || १४ ||
        """.trimIndent(),
        hindi = """
            मुझे कोई भी कर्म लिप्त नहीं करते (यानी मुझे बांधते या गंदा नहीं करते), और न ही मेरी किसी भी कर्म के फलों (परिणामों) में कोई लालसा (स्पृहा) है।
            जो मनुष्य मुझे इस प्रकार (तत्व से) भली-भांति जान लेता है, वह भी कभी कर्मों के बंधनों में नहीं बंधता (कर्मभिर्न बध्यते)।
            भगवान श्रीकृष्ण यहाँ अपने परम निर्लिप्त (Absolutely Detached) स्वभाव का वर्णन कर रहे हैं, जो हर इंसान के लिए एक अल्टीमेट रोल मॉडल (Ultimate Role Model) है।
            भगवान इस दुनिया में अनंत कर्म करते हैं—वे सृष्टि बनाते हैं, दुष्टों का वध करते हैं, और संसार चलाते हैं। लेकिन इन भयंकर कर्मों का एक भी 'दाग' (Reaction / लिम्पन्ति) उन पर नहीं लगता।
            क्यों? क्योंकि भगवान को अपने काम से कोई पर्सनल स्वार्थ (Personal motive) या फल की लालसा ('कर्मफले स्पृहा') नहीं होती। वे जो कुछ भी करते हैं, 100% निस्वार्थ भाव से दुनिया के भले के लिए करते हैं।
            भगवान एक बहुत बड़ी बात कहते हैं कि जो इंसान मेरे इस 'साइक्रेट' (Secret) को समझ लेता है कि "ईश्वर काम करते हुए भी कैसे पूरी तरह अनासक्त (Detached) रहता है", वह इंसान भी ईश्वर जैसा ही हो जाता है।
            अगर कोई व्यक्ति भगवान की इस शैली (Style) की कॉपी (Copy) कर ले और अपने जीवन के सारे काम बिना किसी स्वार्थ और फल की चिंता के करे, तो वह दुनिया के सबसे भारी और मुश्किल काम करके भी कभी कर्मों के जाल (Stress/Sin) में नहीं फँसेगा।
            ज्ञान ही मुक्ति की असली चाबी है।
        """.trimIndent(),
        english = """
            There is absolutely no work that affects Me or binds Me (Na mam karmani limpanti); nor do I have the slightest aspiration or craving for the fruits of action (Na me karma-phale spriha).
            One who understands this absolute truth about Me perfectly does not also become entangled in the fruitive reactions of his own work (Karmabhir na sa badhyate).
            Lord Sri Krishna is revealing His supreme, absolutely flawless, and 100% detached psychological nature here, presenting Himself as the 'Ultimate Role Model' for all of humanity.
            The Supreme Lord executes an infinite number of unimaginably massive actions in this universe—He engineers galaxies, slaughters powerful demons, and manages cosmic affairs. Yet, absolutely not a single microscopic drop of 'stain' or karmic reaction ('Limpanti') ever touches Him.
            Why? Because the Lord possesses exactly zero personal selfish motives, and absolutely no greedy craving ('Karma-phale spriha') to enjoy the fruits of His labor. Whatever He does is 100% pure, selfless action for universal welfare.
            The Lord makes a staggering declaration: Any human being who profoundly decodes and understands this 'Master Secret' of "how God works furiously yet remains completely untouched," instantly achieves that exact same godlike status.
            If a human successfully 'copies' the Lord's working style and executes his daily duties completely stripped of selfish greed and outcome-anxiety, he can run billion-dollar empires or fight massive wars and still never, ever get entangled in the toxic spiderweb of karmic stress or sin.
            Perfect knowledge is the ultimate key to absolute liberation.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            एवं ज्ञात्वा कृतं कर्म पूर्वैरपि मुमुक्षुभिः |
            कुरु कर्मैव तस्मात्त्वं पूर्वैः पूर्वतरं कृतम् || १५ ||
        """.trimIndent(),
        hindi = """
            प्राचीन काल में (पूर्वैरपि) मोक्ष की इच्छा रखने वाले (मुमुक्षुभिः) महापुरुषों ने भी भगवान के इस रहस्य को जानकर ही इसी प्रकार अपने सारे कर्म किए थे।
            इसलिए, तुम भी उसी प्रकार कर्म (युद्ध) करो, जिस प्रकार प्राचीन काल में तुम्हारे पूर्वजों (पूर्वतरं) ने हमेशा किया था।
            अर्जुन को अब तक सारी फिलॉसफी (Philosophy) समझा दी गई है—कि भगवान कैसे काम करते हैं और निस्वार्थ कर्म से कैसे मुक्ति मिलती है।
            अब भगवान उस फिलॉसफी को अर्जुन के जीवन में लागू (Apply) करने का आदेश दे रहे हैं।
            वे कहते हैं कि अर्जुन, तुम कोई नया या अनोखा काम नहीं करने जा रहे हो। प्राचीन काल में भी इक्ष्वाकु, विवस्वान और राजा जनक जैसे मोक्ष चाहने वाले ('मुमुक्षु') महान राजा हुए हैं।
            उन्होंने मोक्ष पाने के लिए राजपाट छोड़कर जंगल का रास्ता नहीं चुना था; उन्होंने ईश्वर की इसी 'अनासक्ति' (Detachment) वाली शैली को समझा और एक राजा के रूप में अपने सारे कर्तव्य (युद्ध आदि) निभाए।
            श्रीकृष्ण अर्जुन को उनके महान पूर्वजों की याद दिलाते हैं ("पूर्वैः पूर्वतरं कृतम्")।
            वे कहते हैं कि तुम अपने उन महान और सफल पूर्वजों की परंपरा का पालन करो। उन महान पूर्वजों ने मुश्किल समय में कायरों की तरह हथियार नहीं डाले थे; उन्होंने बिना किसी स्वार्थ के धर्म के लिए लड़ाई लड़ी थी।
            इसलिए तुम भी अपने दिमाग से संन्यास का यह झूठा विचार निकालो और ठीक उसी तरह युद्ध (कर्म) करो!
        """.trimIndent(),
        english = """
            Knowing this exact truth, all the great liberated souls of ancient times (Purvaih) who strongly desired liberation (Mumukshubhih) performed their duties in this exact selfless manner.
            Therefore, you should simply perform your prescribed duty (Kuru karmaiva), exactly following in the glorious footsteps of your great predecessors in ancient times (Purvataram kritam).
            Arjuna has now been comprehensively taught the entire supreme philosophy—exactly how God Himself works, and how executing selfless action directly guarantees absolute liberation.
            Now, the Lord issues a strict, commanding order for Arjuna to actually 'Apply' this profound philosophy directly on the battlefield.
            He tells Arjuna: You are absolutely not being asked to invent a new path or do something bizarre. In ancient history, there were magnificent kings like Ikshvaku, Vivasvan, and Janaka who intensely desired supreme liberation ('Mumukshu').
            They absolutely did not run away to hide in remote jungles to attain Moksha; they perfectly understood God's style of 'Detachment' and flawlessly executed their massive, violent duties as kings and warriors.
            Sri Krishna aggressively reminds Arjuna of the unparalleled legacy of his own royal bloodline ("Purvaih purvataram kritam").
            He commands: You must strictly follow the glorious traditions of your elite, successful ancestors. Those legendary forefathers did not drop their weapons like pathetic cowards when faced with immense crisis; they fought terrifying wars for dharma without a drop of selfishness.
            Therefore, completely flush this fake idea of escapist renunciation out of your brain, and fight your war (Karma) exactly as they did!
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            किं कर्म किमकर्मेति कवयोऽप्यत्र मोहिताः |
            तत्ते कर्म प्रवक्ष्यामि यज्ज्ञात्वा मोक्ष्यसेऽशुभात् || १६ ||
        """.trimIndent(),
        hindi = """
            वास्तव में 'कर्म' (क्या करना चाहिए) क्या है और 'अकर्म' (क्या नहीं करना चाहिए) क्या है, इस विषय का निर्णय करने में बड़े-बड़े बुद्धिमान और विद्वान (कवयोऽपि) लोग भी भ्रमित (मोहिताः) हो जाते हैं।
            इसलिए, मैं तुम्हें उस कर्म के वास्तविक स्वरूप और रहस्य को भली-भांति समझाऊँगा, जिसे जानकर तुम इस संसार के सभी अशुभ (पाप और दुःख) से पूरी तरह मुक्त हो जाओगे।
            भगवान श्रीकृष्ण अब एक ऐसे विषय (Topic) की शुरुआत कर रहे हैं जो मनुष्य के जीवन का सबसे बड़ा कंफ्यूजन (Confusion) है—कि आखिर सही काम क्या है?
            हम अक्सर सोचते हैं कि हम जानते हैं कि क्या सही है और क्या गलत। लेकिन भगवान कहते हैं कि 'कर्म' (Action) और 'अकर्म' (Inaction) का विज्ञान इतना गहरा और बारीक है कि बड़े-बड़े दार्शनिक, संत और वैज्ञानिक ('कवयोऽपि') भी इसमें धोखा खा जाते हैं।
            बाहर से जो चीज़ एकदम सही और पुण्य का काम लगती है (जैसे अर्जुन का युद्ध न करना और दया दिखाना), वह वास्तव में सबसे बड़ा पाप (अधर्म) हो सकती है।
            और बाहर से जो चीज़ हिंसा और पाप लगती है (जैसे भगवान के आदेश पर अर्जुन का अपनों को मारना), वह वास्तव में सबसे बड़ा पुण्य और 'अकर्म' (जिसका कोई फल न बने) हो सकती है।
            श्रीकृष्ण अर्जुन से वादा करते हैं कि मैं तुम्हें कर्म की वह 'सीक्रेट डिकोडिंग' (Secret Decoding) सिखाऊंगा, जिसे समझने के बाद तुम जीवन में कभी गलत फैसला नहीं लोगे।
            और इस ज्ञान को पाकर तुम जीवन के सारे 'अशुभ' (पाप, टेंशन, और जन्म-मरण के चक्र) से हमेशा के लिए आज़ाद (मोक्ष्यसे) हो जाओगे।
        """.trimIndent(),
        english = """
            Even the most highly intelligent, thoughtful men and great scholars (Kavayo 'pi) are completely bewildered and illusioned (Mohitah) in determining exactly what is action (Karma) and what is inaction (Akarma).
            Therefore, I shall now explicitly explain to you the absolute truth and profound mystery of action, knowing which you shall be eternally liberated from all misfortune and inauspiciousness (Ashubhat).
            Lord Sri Krishna is now officially launching into a subject that is undeniably the absolute greatest, most paralyzing confusion in human existence—determining what exactly is the "Right thing to do."
            We ordinary mortals arrogantly assume we perfectly know right from wrong. But the Lord declares that the actual, intricate science of 'Karma' (Action) and 'Akarma' (Inaction) is so unfathomably deep and complex that even the world's greatest philosophers, elite scientists, and brilliant scholars ('Kavayo api') get totally confused and make massive blunders.
            What superficially appears on the outside to be highly pious and morally correct (like Arjuna showing mercy and refusing to fight) can actually be the most horrific, destructive sin (Adharma) from a cosmic perspective.
            And what superficially looks like brutal, horrific violence and sin on the outside (like Arjuna slaughtering his relatives on God's command) can actually be the absolute highest piety and 'Akarma' (reaction-free action).
            Sri Krishna promises Arjuna: I am going to teach you the ultimate 'Secret Decoding' of Karma. Once you master this, you will never make a wrong decision in your life again.
            And by acquiring this supreme knowledge, you will be permanently liberated (Mokshyase) from all 'Ashubha' (sins, psychological stress, and the agonizing cycle of rebirth).
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            कर्मणो ह्यपि बोद्धव्यं बोद्धव्यं च विकर्मणः |
            अकर्मणश्च बोद्धव्यं गहना कर्मणो गतिः || १७ ||
        """.trimIndent(),
        hindi = """
            क्योंकि मनुष्य को 'कर्म' (शास्त्रों द्वारा बताए गए सही काम) के असली स्वरूप को भी जानना चाहिए; 'विकर्म' (शास्त्रों द्वारा मना किए गए पाप कर्म) को भी गहराई से जानना चाहिए...
            तथा 'अकर्म' (बिना फल की इच्छा के किए गए कर्म, जो बांधते नहीं) के स्वरूप को भी समझना चाहिए; क्योंकि कर्म की गति (इसका विज्ञान) अत्यंत गहन (बहुत गहरी और रहस्यमयी) है।
            भगवान श्रीकृष्ण यहाँ 'कर्म' को तीन बिल्कुल स्पष्ट श्रेणियों (Categories) में बाँट रहे हैं, जो हर इंसान को समझना अनिवार्य है:
            १. कर्म (Righteous Action): वे काम जो शास्त्रों और हमारी ड्यूटी (Duty) के अनुसार सही हैं (जैसे सच बोलना, दान देना, अपनी नौकरी ईमानदारी से करना)।
            २. विकर्म (Forbidden Action): वे काम जो पूरी तरह से गलत और स्वार्थी हैं (जैसे चोरी, हत्या, भ्रष्टाचार)। इनका रिज़ल्ट भयंकर दुःख और नरक होता है।
            ३. अकर्म (Inaction / Reaction-free Action): यह सबसे ऊँची स्टेज है। बाहर से इंसान बहुत बड़ा काम कर रहा होता है, लेकिन उसके मन में 'मैं कर रहा हूँ' का अहंकार और फल का लालच नहीं होता। इसलिए वह काम कोई पाप या पुण्य पैदा नहीं करता; वह व्यक्ति कर्मों से पूरी तरह आज़ाद रहता है।
            श्रीकृष्ण एक बहुत बड़ी चेतावनी देते हैं: "गहना कर्मणो गतिः" (कर्म का जाल बहुत गहरा और कॉम्प्लेक्स/Complex है)।
            एक इंसान सोचता है कि वह बहुत अच्छा 'कर्म' कर रहा है (जैसे अर्जुन सोच रहा था कि युद्ध न करना पुण्य है), लेकिन वास्तव में वह एक भयंकर 'विकर्म' (पाप) कर रहा होता है।
            इसलिए केवल बाहरी एक्शन को मत देखो, उसके पीछे के मनोविज्ञान (Psychology) और आध्यात्मिक नियम को समझना बहुत जरूरी है।
        """.trimIndent(),
        english = """
            The absolute truth and true nature of prescribed action (Karma) must be completely understood; the true nature of forbidden, sinful action (Vikarma) must also be profoundly understood...
            and the exact nature of inaction or reaction-free action (Akarma) must also be flawlessly understood; because the intricacies and absolute path of action are incredibly profound, deep, and highly difficult to understand (Gahana karmano gatih).
            Lord Sri Krishna is surgically dividing all human activity into three absolute, distinct categories here, which every human being must mandatorily understand to survive:
            1. Karma (Righteous Action): Actions that perfectly align with moral duties and scriptural injunctions (e.g., speaking the truth, charity, executing your job with integrity).
            2. Vikarma (Forbidden Action): Actions that are strictly prohibited, immoral, and driven entirely by selfish greed (e.g., theft, murder, corruption). These guarantee horrific suffering and hellish reactions.
            3. Akarma (Reaction-free Action): This is the absolute highest, supreme state. Outwardly, the person is executing massively intense actions, but inwardly he has zero 'Doer' ego and zero greedy lust for the results. Therefore, his actions generate absolutely zero karmic reactions (no sin, no merit); he remains completely liberated.
            Sri Krishna issues a highly critical warning: "Gahana karmano gatih" (The intricate spiderweb and mechanics of Karma are unfathomably deep and complex).
            A foolish human often genuinely believes he is performing a highly pious 'Karma' (just as Arjuna thought abandoning the war was an act of high morality), when in reality, he is committing a catastrophic 'Vikarma' (Sin).
            Therefore, you must never judge an action merely by its external appearance; profoundly decoding the internal psychology and cosmic laws governing it is absolutely essential.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            कर्मण्यकर्म यः पश्येदकर्मणि च कर्म यः |
            स बुद्धिमान्मनुष्येषु स युक्तः कृत्स्नकर्मकृत् || १८ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य 'कर्म' में 'अकर्म' को देखता है (यानी भयंकर काम करते हुए भी जो खुद को कुछ न करने वाला महसूस करता है), और जो 'अकर्म' में 'कर्म' को देखता है (यानी बाहर से शांत बैठे रहने वाले के भीतर चल रहे तूफानी विचारों को पहचान लेता है)...
            वही मनुष्य सभी मनुष्यों में सबसे बड़ा बुद्धिमान (बुद्धिमान्) है, वही सच्चा योगी (युक्तः) है, और वही व्यक्ति सम्पूर्ण कर्मों को सही तरीके से करने वाला (कृत्स्नकर्मकृत्) है।
            यह श्लोक एक बहुत बड़ा 'ब्रेन टीज़र' (Brain Teaser) और भगवद्गीता के सबसे गहरे रहस्यमय श्लोकों में से एक है। इसे समझने के लिए बहुत शार्प इंटेलिजेंस (Sharp Intelligence) चाहिए।
            भगवान अर्जुन को देखने का एक बिल्कुल नया चश्मा (Perspective) दे रहे हैं:
            १. 'कर्म में अकर्म देखना': एक सच्चा कर्मयोगी (जैसे जनक या कृष्ण) बाहर से दिन-रात काम करता है, बड़े-बड़े युद्ध लड़ता है। लेकिन अंदर से उसका अहंकार शून्य (Zero) होता है। वह जानता है कि "प्रकृति काम कर रही है, मेरी आत्मा कुछ नहीं कर रही।" इसलिए इतने भारी काम (कर्म) के बीच भी वह पूरी शांति और 'अकर्म' (Zero reaction) में रहता है।
            २. 'अकर्म में कर्म देखना': दूसरी तरफ, एक ढोंगी संन्यासी बाहर से आँखें बंद करके शांत बैठा है (अकर्म)। लेकिन उसके दिमाग के भीतर वासना, लालच और अहंकार का भयंकर तूफान (कर्म) चल रहा है। ज्ञानी आदमी तुरंत देख लेता है कि यह चुपचाप बैठा इंसान भी मानसिक रूप से भयंकर पाप (कर्म) कर रहा है।
            जो इंसान इस बाहरी धोखे को पार करके अंदर की असलियत को देख लेता है, वही दुनिया का सबसे 'बुद्धिमान' व्यक्ति है।
            और ऐसा व्यक्ति चाहे जो भी काम करे, उसका हर काम परफेक्शन (Perfection) के साथ पूरा होता है।
        """.trimIndent(),
        english = """
            One who can clearly see 'inaction in action' (Akarma in Karma), and simultaneously see 'action in inaction' (Karma in Akarma)...
            is undeniably the most intelligent and wise person among all human beings (Buddhiman). He is situated in the supreme transcendental position (Yuktah), although he may be engaged in all sorts of massive activities (Kritsna-karma-krit).
            This verse is a spectacular philosophical 'Brain Teaser' and arguably one of the most profoundly mystical verses in the entire Bhagavad Gita. It requires razor-sharp spiritual intelligence to decode.
            The Lord is handing Arjuna an entirely new, multidimensional lens (Perspective) to view reality:
            1. 'Seeing Inaction in Action': A flawless Karma Yogi (like King Janaka or Krishna Himself) outwardly executes massive, intense actions 24/7, fighting world wars and running empires. But inwardly, his ego is absolute Zero. He perfectly knows, "Material nature is acting; my pure soul is doing absolutely nothing." Therefore, amidst a hurricane of action (Karma), he exists in absolute stillness and generates zero karmic reactions (Akarma).
            2. 'Seeing Action in Inaction': Conversely, a fake, hypocritical monk sits physically motionless with closed eyes in a forest (outward Akarma). But deep inside his brain, a terrifying, violent hurricane of lust, greed, and ego is actively raging. The wise man instantly detects that this physically inactive person is actually performing horrific mental 'Action' (Karma).
            The rare genius who can effortlessly pierce through external physical illusions and accurately perceive this internal spiritual reality is declared the absolute most 'Intelligent' (Buddhiman) person on earth.
            And because his consciousness is perfectly calibrated, absolutely every action he touches becomes a masterpiece of flawless perfection.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            यस्य सर्वे समारम्भाः कामसङ्कल्पवर्जिताः |
            ज्ञानाग्निदग्धकर्माणं तमाहुः पण्डितं बुधाः || १९ ||
        """.trimIndent(),
        hindi = """
            जिस मनुष्य के संपूर्ण कार्य (सभी प्रयास और प्रोजेक्ट्स) किसी भी प्रकार की स्वार्थी कामना (काम) और निजी संकल्प (सङ्कल्प) से पूरी तरह रहित (वर्जिताः) होते हैं...
            और जिसके सभी कर्म 'ज्ञान रूपी अग्नि' (ज्ञानाग्नि) में पूरी तरह जलकर भस्म (दग्ध) हो चुके हैं, उस महापुरुष को ज्ञानी लोग 'सच्चा पण्डित' (पण्डितं) कहते हैं।
            श्रीकृष्ण अब उस परम बुद्धिमान ('पंडित') व्यक्ति के व्यावहारिक लक्षण बता रहे हैं।
            दुनिया में 'पंडित' उसे कहा जाता है जिसने बहुत सी किताबें पढ़ी हों या जिसे बहुत सी भाषाएं आती हों। लेकिन गीता के अनुसार असली पंडित वह है जिसका 'एक्शन' (Action) शुद्ध हो चुका है।
            साधारण इंसान जब भी कोई नया काम या प्रोजेक्ट (समारम्भाः) शुरू करता है, तो उसके पीछे उसकी कोई स्वार्थी इच्छा (काम) और भविष्य की कोई प्लानिंग (संकल्प) होती है कि "मैं यह करूँगा तो मुझे यह फायदा होगा।"
            लेकिन असली ज्ञानी के काम 'काम-संकल्प-वर्जिताः' होते हैं। वह काम तो 100% परफेक्शन के साथ करता है, लेकिन उसमें उसका 'मेरा क्या फायदा' वाला स्वार्थ ज़ीरो होता है। वह जो भी करता है, केवल ईश्वर की सेवा या समाज के कल्याण के लिए करता है।
            जब इंसान के मन में यह 'ज्ञान' (कि मैं शरीर नहीं, आत्मा हूँ, और मुझे कुछ नहीं चाहिए) आ जाता है, तो यह ज्ञान एक भयंकर 'आग' (ज्ञानाग्नि) का काम करता है।
            यह ज्ञान की आग उस व्यक्ति के द्वारा किए जा रहे काम के सारे पाप, पुण्य और कर्म-बंधनों को उसी तरह जलाकर राख कर देती है जैसे आग सूखे घास को जला देती है ('दग्धकर्माणं')।
            ऐसा व्यक्ति काम करते हुए भी हमेशा 'फ्री' (Free) रहता है।
        """.trimIndent(),
        english = """
            That person whose every single endeavor and massive project is completely entirely devoid of selfish desire for sense gratification and personal calculating motives (Kama-sankalpa-varjitah)...
            and whose entire fruitive actions have been completely burnt to ashes (Dagdha-karmanam) by the blazing fire of perfect spiritual knowledge (Jnanagni), is officially declared a true, enlightened sage (Panditam) by the wise.
            Sri Krishna is now explicitly defining the practical, behavioral symptoms of that supremely intelligent person ('Pandita') mentioned in the previous verse.
            In the ignorant material world, a 'Pandita' is superficially defined as someone who has memorized libraries of books or speaks multiple languages. But according to the Gita's absolute standard, a true Pandita is someone whose 'Actions' are impeccably purified.
            Whenever an ordinary human launches a new startup, project, or endeavor (Samarambhah), it is heavily powered by a toxic, selfish desire (Kama) and a calculated, greedy future plan (Sankalpa) thinking, "If I do this, how much money/fame will I extract?"
            But the actions of an elite, enlightened master are 'Kama-sankalpa-varjitah'. He executes massive global projects with 100% flawless perfection, but his "What's in it for me?" selfishness is absolutely Zero. Whatever he does is purely an offering of service to God or for universal welfare.
            When a human firmly realizes this supreme 'Knowledge' (that I am not this mortal body, and I require nothing from this world), this realization acts exactly like an explosive, blazing 'Fire' (Jnanagni).
            This ferocious fire of knowledge instantly incinerates and burns to ashes absolutely all karmic reactions, sins, and merits attached to his work, just like a roaring fire burns dry grass to ash ('Dagdha-karmanam').
            Such a master remains eternally 'Free' and liberated, even while performing the most intense actions in the world.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            त्यक्त्वा कर्मफलासङ्गं नित्यतृप्तो निराश्रयः |
            कर्मण्यभिप्रवृत्तोऽपि नैव किञ्चित्करोति सः || २० ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति अपने कर्मों के फलों (परिणामों) की सारी आसक्ति (लगाव) को पूरी तरह त्याग कर (त्यक्त्वा), हमेशा अपने आप में परमानंद से तृप्त (संतुष्ट) रहता है, और जो संसार के किसी भी व्यक्ति या वस्तु पर आश्रित (निराश्रयः) नहीं है...
            वह महापुरुष बाहर से भयंकर कर्मों में बहुत अच्छी तरह लगा हुआ होने पर भी (कर्मण्यभिप्रवृत्तोऽपि), वास्तव में वह कुछ भी नहीं करता है (नैव किञ्चित्करोति सः)।
            यह श्लोक 'कर्मयोग' की पूर्णता (Perfection) और एक योगी की सबसे रहस्यमयी (Mystical) अवस्था का वर्णन है। यह उस 'कर्म में अकर्म' (Action without reaction) का प्रैक्टिकल उदाहरण है।
            एक सिद्ध कर्मयोगी में तीन बहुत ही खास क्वालिटीज़ (Qualities) आ जाती हैं:
            १. 'त्यक्त्वा कर्मफलासङ्गं': वह काम का रिज़ल्ट (सफलता/विफलता) ईश्वर पर छोड़ देता है। उसका सारा फोकस केवल अपना 'बेस्ट' (Best) देने पर होता है।
            २. 'नित्यतृप्तो': उसे खुशी के लिए बाहर से किसी प्रमोशन, तारीफ या पैसे की जरूरत नहीं होती। वह 24 घंटे अपने भीतर ईश्वर के परमानंद में 'रिचार्ज्ड' (Recharged) और संतुष्ट रहता है।
            ३. 'निराश्रयः': वह भावनात्मक (Emotionally) या मनोवैज्ञानिक रूप से दुनिया के किसी भी इंसान (यहाँ तक कि अपने परिवार) पर निर्भर (Dependent) नहीं होता। उसका एकमात्र सहारा ईश्वर है।
            जब ऐसा सुपर-ह्यूमन (Super-human) व्यक्ति युद्ध के मैदान में या ऑफिस में उतरता है, तो बाहर से लगता है कि वह बहुत ज्यादा 'एक्टिव' (Active) है और बहुत काम कर रहा है ('कर्मण्यभिप्रवृत्तोऽपि')।
            लेकिन क्योंकि उसके अंदर रत्ती भर भी अहंकार या स्वार्थ नहीं है, इसलिए आध्यात्मिक दृष्टि से उसका खाता बिल्कुल खाली रहता है। ब्रह्मांड के रिकॉर्ड (Record) में वह व्यक्ति "कुछ नहीं कर रहा है" ('नैव किञ्चित्करोति') माना जाता है। वह दुनिया में रहकर भी दुनिया से पूरी तरह आज़ाद (Mukta) रहता है।
        """.trimIndent(),
        english = """
            Completely totally abandoning all false attachment to the results of his activities (Tyaktva karma-phalasangam), remaining eternally fully satisfied within himself (Nitya-tripto), and being completely independent of all worldly shelters (Nirashrayah)...
            such a highly elevated person, even though engaged in all kinds of massive, intense undertakings (Karmany abhipravritto api), actually performs absolutely nothing at all (Naiva kinchit karoti sah).
            This spectacular verse describes the absolute ultimate 'Perfection' of Karma Yoga and the highly mystical, mind-bending state of a supreme Yogi. It is the practical, real-world demonstration of 'Akarma in Karma' (Action generating zero reaction).
            A perfected, master Karma Yogi develops three incredibly powerful, superhuman qualities:
            1. 'Tyaktva karma-phalasangam': He completely amputates his psychological addiction to the end result (success/failure), outsourcing it entirely to God. His 100% focus is solely on executing flawless action.
            2. 'Nitya-tripto': He absolutely does not need to beg for a job promotion, public validation, or money to feel happy. He remains 24/7 eternally 'Recharged', intoxicated, and 100% satisfied by the infinite bliss of God residing within him.
            3. 'Nirashrayah': He is utterly and completely independent. Emotionally and psychologically, he does not lean on or depend upon any human being, family member, or bank account in this world for shelter. God is his sole, exclusive refuge.
            When such an elite, superhuman entity enters a bloody battlefield or a corporate boardroom, to external eyes, he appears hyper-active, aggressively executing massive, world-changing operations ('Karmany abhipravritto api').
            But because his internal software has absolute zero ego and zero selfishness, from the supreme transcendental perspective, his karmic ledger remains perfectly blank. In the cosmic records, he is officially registered as doing "Absolutely Nothing" ('Naiva kinchit karoti'). He lives right in the center of the chaotic matrix, yet remains flawlessly, eternally liberated.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            निराशीर्यतचित्तात्मा त्यक्तसर्वपरिग्रहः |
            शारीरं केवलं कर्म कुर्वन्नाप्नोति किल्बिषम् || २१ ||
        """.trimIndent(),
        hindi = """
            जिसने अपनी सभी सांसारिक आशाओं और इच्छाओं को पूरी तरह छोड़ दिया है (निराशीः), जिसने अपने मन और बुद्धि को पूरी तरह वश में कर लिया है (यतचित्तात्मा)...
            और जिसने सभी प्रकार के परिग्रह (स्वामित्व/Ownership का दावा) को पूरी तरह त्याग दिया है; ऐसा व्यक्ति केवल शरीर को बनाए रखने के लिए (शारीरं केवलं) कर्म करते हुए भी कभी कोई पाप (किल्बिषम्) प्राप्त नहीं करता।
            भगवान श्रीकृष्ण यहाँ उस ज्ञानी कर्मयोगी के काम करने की परफेक्ट शैली (Perfect Style) का वर्णन कर रहे हैं।
            साधारण इंसान जब कोई काम करता है, तो वह बहुत सी आशाएं (Hopes) पालता है और चीजों पर अपना 'कब्जा' (Possession/परिग्रह) जमाना चाहता है। यही आसक्ति (Attachment) उसके लिए पाप और स्ट्रेस (Stress) का कारण बनती है।
            लेकिन एक सिद्ध कर्मयोगी का मन पूरी तरह उसके नियंत्रण (यतचित्तात्मा) में होता है। वह काम तो करता है, लेकिन "यह मेरा है" (Mine-ness) की बीमारी से 100% मुक्त होता है।
            यहाँ 'शारीरं केवलं कर्म' का अर्थ है कि वह मशीन की तरह केवल शारीरिक रूप से काम कर रहा है; उसका 'अहंकार' (Ego) उस काम में बिल्कुल शामिल नहीं है।
            जब काम में अहंकार और स्वार्थ का ज़हर (Poison) नहीं होता, तो वह काम पूरी तरह से पवित्र हो जाता है। ऐसा व्यक्ति युद्ध जैसे भयंकर काम करते हुए भी कर्म-बंधन (पाप) से बिल्कुल उसी तरह अछूता रहता है जैसे आग में से निकला हुआ शुद्ध सोना।
        """.trimIndent(),
        english = """
            Such a man of understanding acts entirely without any false hopes or selfish desires for the result (Nirashih), keeping his mind and intelligence perfectly controlled (Yata-chittatma)...
            and having completely completely given up all sense of proprietorship over all possessions (Tyakta-sarva-parigrahah); by performing actions merely for the bare maintenance of the body (Shariram kevalam karma), he incurs absolutely no sinful reaction (Kilbisham).
            Lord Sri Krishna is vividly describing the absolutely perfect, flawless working style of an enlightened Karma Yogi here.
            When an ordinary mortal works, he desperately harbors massive hopes for future profits and violently tries to 'Own' and hoard objects (Parigraha). This exact toxic attachment breeds massive karmic sin and psychological stress.
            But a perfected Yogi's mind and intelligence are under his absolute, titanium control (Yata-chittatma). He executes massive actions, but is 100% immune to the crippling disease of "Mine-ness".
            Here, 'Shariram kevalam karma' profoundly means that he is acting mechanically and purely on the physical platform; his 'False Ego' is completely unplugged and absent from the action.
            When any action is completely drained of the toxic venom of ego and selfishness, it instantly becomes supremely pure. Such a person, even while fighting a devastating war, remains completely untouched by karmic sin, exactly like pure gold passing through a roaring fire.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            यदृच्छालाभसन्तुष्टो द्वन्द्वातीतो विमत्सरः |
            समः सिद्धावसिद्धौ च कृत्वापि न निबध्यते || २२ ||
        """.trimIndent(),
        hindi = """
            जो बिना मांगे (अपने आप) प्राप्त हुए लाभ (यदृच्छालाभ) में ही पूरी तरह संतुष्ट (सन्तुष्टो) रहता है, जो सुख-दुःख आदि सभी द्वंद्वों से पूरी तरह पार हो चुका है (द्वन्द्वातीतो), जो ईर्ष्या (जलन) से पूरी तरह मुक्त है (विमत्सरः)...
            तथा जो कर्मों की सिद्धि (सफलता) और असिद्धि (विफलता) में हमेशा एक समान (समः) रहता है, वह महापुरुष भयंकर कर्म करके भी कभी उन कर्मों के बंधनों में नहीं बंधता (न निबध्यते)।
            यह श्लोक एक सच्चे कर्मयोगी की असीम मानसिक स्वतंत्रता (Absolute Mental Freedom) का सबसे शानदार ब्लूप्रिंट (Blueprint) है।
            दुनिया के ज़्यादातर लोग इस बात से दुःखी नहीं होते कि उनके पास क्या है; वे इस बात से दुःखी होते हैं कि "पड़ोसी के पास मुझसे ज़्यादा क्यों है?" इसे 'मत्सर' (Jealousy) कहते हैं।
            लेकिन ज्ञानी पुरुष 'विमत्सरः' (Zero Jealousy) होता है। वह अपनी मेहनत पूरी ईमानदारी से करता है, और फिर प्रकृति (या ईश्वर) उसे जो भी परिणाम देती है ('यदृच्छालाभ'), वह उसी में 100% संतुष्ट हो जाता है।
            वह सफलता (Siddhi) मिलने पर अहंकार से अंधा नहीं होता, और असफलता (Asiddhi) मिलने पर डिप्रेशन में नहीं जाता ('समः')।
            उसने अपने दिमाग को सर्दी-गर्मी, मान-अपमान जैसे द्वंद्वों (Dualities) से पूरी तरह 'हैक' (Hack) कर लिया है ('द्वन्द्वातीत')।
            जब इंसान का मन इतना अजेय और बैलेंस (Balanced) हो जाता है, तो भौतिक दुनिया की कोई भी जंजीर (कर्म-बंधन) उसे बाँध नहीं सकती।
        """.trimIndent(),
        english = """
            He who is perfectly satisfied with whatever comes automatically of its own accord (Yadriccha-labha-santushto), who has entirely surpassed the dualities of this world (Dvandvatito), who is completely completely free from envy (Vimatsarah)...
            and who remains absolutely steady and equal in both success (Siddhau) and failure (Asiddhau), such a master is absolutely never entangled (Na nibadhyate), even though performing all kinds of massive actions.
            This phenomenal verse provides the absolute greatest blueprint for the supreme Mental Freedom of a true Karma Yogi.
            The vast majority of people in this world are not depressed by what they possess; they are violently depressed thinking, "Why does my neighbor have more than me?" This is the toxic virus of 'Matsara' (Jealousy).
            But an enlightened sage is 'Vimatsarah' (containing Zero Jealousy). He executes his heavy duties with 100% integrity, and whatever exact result material nature (destiny) automatically hands him ('Yadriccha-labha'), he accepts it with absolute, 100% satisfaction.
            He does not go blindly arrogant upon achieving massive success (Siddhi), nor does he crash into dark depression upon facing devastating failure (Asiddhi).
            He has essentially 'Hacked' his brain to remain entirely unaffected by earthly dualities like heat-cold or honor-dishonor ('Dvandvatito').
            When a human mind achieves this staggering, invincible level of equilibrium, absolutely no karmic chain in the material universe can ever bind him.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            गतसङ्गस्य मुक्तस्य ज्ञानावस्थितचेतसः |
            यज्ञायाचरतः कर्म समग्रं प्रविलीयते || २३ ||
        """.trimIndent(),
        hindi = """
            जिसकी सांसारिक विषयों में कोई आसक्ति (सङ्ग) नहीं बची है (गतसङ्गस्य), जो पूरी तरह मुक्त है (मुक्तस्य), और जिसका मन (चेतना) आध्यात्मिक ज्ञान में पूरी तरह स्थित है (ज्ञानावस्थितचेतसः)...
            ऐसे केवल यज्ञ (ईश्वर की प्रसन्नता) के लिए आचरण (कर्म) करने वाले महापुरुष के संपूर्ण कर्म पूरी तरह से विलीन (नष्ट) हो जाते हैं (समग्रं प्रविलीयते)।
            भगवान श्रीकृष्ण यहाँ एक बहुत बड़ा आध्यात्मिक विज्ञान (Spiritual Science) बता रहे हैं: "कर्मों का शून्य (Zero) हो जाना।"
            साधारण इंसान जो भी काम करता है, उसका एक अकाउंट (Karmic Account) बनता है। अच्छा काम करोगे तो पुण्य मिलेगा (स्वर्ग जाना पड़ेगा), बुरा काम करोगे तो पाप मिलेगा (नरक जाना पड़ेगा)। दोनों ही हाल में जन्म लेना पड़ेगा।
            लेकिन एक 'मुक्त' योगी का अकाउंट हमेशा 'Zero' रहता है। क्यों?
            क्योंकि उसकी चेतना 'ज्ञानावस्थित' (Knowledge-based) है। वह जानता है कि यह दुनिया एक भ्रम है और केवल ईश्वर ही सत्य है।
            इसलिए वह जो भी काम करता है (चाहे वह युद्ध हो या राज्य चलाना), वह केवल 'यज्ञ' (परमात्मा की सेवा) के रूप में करता है।
            जब कोई काम 100% बिना किसी स्वार्थ और केवल भगवान के लिए किया जाता है, तो उस काम का कोई भौतिक प्रभाव (Reaction) नहीं बनता। उसका वह सारा कर्म 'समग्रं प्रविलीयते'—यानी ब्रह्मांड में पूरी तरह पिघल कर गायब हो जाता है।
        """.trimIndent(),
        english = """
            The entire work of a man who is completely unattached to the modes of material nature (Gata-sangasya), who is fully liberated (Muktasya), and whose consciousness is permanently situated in transcendental knowledge (Jnanavasthita-chetasah)...
            who performs all actions entirely as a sacrifice to the Supreme (Yajnayacharatah), merges completely into absolute transcendence and vanishes entirely (Samagram praviliyate).
            Lord Sri Krishna is revealing a staggering Spiritual Science here: "The complete Zeroing of Karma."
            Whenever an ordinary human acts, a strict Karmic Account is generated. Good deeds generate merit (forcing rebirth in heaven), and bad deeds generate sin (forcing rebirth in hell). Both identically force the soul to reincarnate.
            But the karmic ledger of a 'Liberated' Yogi consistently remains at an absolute 'Zero'. Why?
            Because his consciousness is 'Jnanavasthita' (Perfectly stabilized in ultimate truth). He profoundly knows that this material matrix is temporary and only the Supreme Lord is eternal.
            Therefore, whatever intense action he performs (whether fighting a massive war or ruling an empire), he executes it purely as a 'Yajna' (a selfless sacrifice to God).
            When an action is performed with 100% zero selfishness and entirely for the Lord, it generates absolutely zero material reactions. His entire karmic footprint 'Samagram praviliyate'—it literally melts away and completely vanishes into the cosmic transcendence.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            ब्रह्मार्पणं ब्रह्म हविर्ब्रह्माग्नौ ब्रह्मणा हुतम् |
            ब्रह्मैव तेन गन्तव्यं ब्रह्मकर्मसमाधिना || २४ ||
        """.trimIndent(),
        hindi = """
            उस महापुरुष के लिए अर्पण करने का साधन (चम्मच आदि) भी 'ब्रह्म' (परमात्मा) है; अर्पण की जाने वाली सामग्री (हवि) भी 'ब्रह्म' है; और 'ब्रह्म' रूपी कर्ता (यजमान) के द्वारा 'ब्रह्म' रूपी अग्नि में ही आहुति दी जा रही है।
            इस प्रकार सभी कर्मों में केवल 'ब्रह्म' को ही देखने वाले (ब्रह्मकर्मसमाधिना) उस योगी द्वारा जो प्राप्त किया जाने वाला लक्ष्य है, वह भी साक्षात् 'ब्रह्म' (ईश्वर) ही है।
            यह भगवद्गीता के सबसे गहरे, रहस्यमयी और सबसे ज्यादा पढ़े जाने वाले श्लोकों (भोजन से पहले अक्सर इसका उच्चारण होता है) में से एक है।
            भगवान यहाँ 'अद्वैत' (Non-duality) और 'पूर्ण ईश्वर चेतना' (Ultimate God-consciousness) का सबसे सुंदर चित्र खींच रहे हैं।
            जब एक ज्ञानी अपनी चरम अवस्था (Peak State) में पहुँचता है, तो उसकी दृष्टि (Vision) पूरी तरह बदल जाती है। उसे इस दुनिया में 'मैं' और 'तू' दिखना बंद हो जाता है; उसे हर जगह केवल 'परमात्मा' (ब्रह्म) ही दिखता है।
            जब वह यज्ञ (कोई भी कर्म) करता है, तो वह सोचता है: "यह काम करने वाला मैं नहीं, ब्रह्म है। जो सामग्री (हवि) है, वह भी ब्रह्म है। जो काम हो रहा है, वह भी ब्रह्म है। और इस काम का जो रिजल्ट आएगा, वह भी ब्रह्म ही है।"
            जब इंसान हर सेकंड, हर चीज़ में केवल भगवान को ही देखता है ('ब्रह्मकर्मसमाधि'), तो उसका पूरा जीवन ही एक 'समाधि' बन जाता है।
            ऐसे व्यक्ति के लिए यह भौतिक दुनिया (Material World) खत्म हो जाती है, और वह जीते जी ही भगवान में विलीन (Merge) हो जाता है।
        """.trimIndent(),
        english = """
            For such a fully spiritually absorbed person, the instrument of offering is entirely Brahman (Spirit/Supreme); the offering itself (Havi) is Brahman; and the offering is poured by Brahman into the blazing fire of Brahman.
            Thus, by remaining completely absorbed in this absolute trance of spiritual action (Brahma-karma-samadhina), the ultimate destination he is guaranteed to reach is certainly the Supreme Brahman alone.
            This is universally recognized as one of the most profoundly mystical, beautiful, and heavily chanted verses in the entire Bhagavad Gita (often recited as a prayer before meals).
            The Lord is painting the absolute ultimate masterpiece of 'Non-duality' and 'Total God-consciousness' here.
            When an enlightened sage reaches his absolute 'Peak State', his cosmic vision radically upgrades. He completely stops seeing the toxic illusions of 'I' and 'Mine'; he exclusively perceives only the 'Supreme Lord' (Brahman) everywhere and in everything.
            When he performs a Yajna (any worldly action), his software calculates: "The person acting is not me; it is Brahman. The material being offered is Brahman. The process of acting is Brahman. And the final destination of this action is also purely Brahman."
            When a human being perfectly visualizes only the Supreme Lord in absolutely every microsecond and every atom ('Brahma-karma-samadhi'), his entire waking life becomes one continuous, unbroken 'Trance' (Samadhi).
            For such an elite master, the material matrix completely ceases to exist, and he perfectly merges into the Supreme Godhead even while physically alive.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            दैवमेवापरे यज्ञं योगिनः पर्युपासते |
            ब्रह्माग्नावपरे यज्ञं यज्ञेनैवोपजुह्वति || २५ ||
        """.trimIndent(),
        hindi = """
            कुछ दूसरे कर्मयोगी केवल 'देवताओं' को प्रसन्न करने के लिए ही यज्ञों (पूजा-पाठ) का भली-भांति अनुष्ठान करते हैं।
            और कुछ अन्य (ज्ञान) योगी परब्रह्म (परमात्मा) रूपी अग्नि में, आत्मा (यज्ञ) को आत्मा के द्वारा ही आहुति (आहुति) दे देते हैं (अर्थात् वे आत्मा को परमात्मा में लीन कर देते हैं)।
            पिछले श्लोक में भगवान ने यज्ञ का सबसे ऊँचा स्तर (ब्रह्म-समाधि) बताया था। अब भगवान 25वें से 30वें श्लोक तक समाज में अलग-अलग लोगों द्वारा किए जाने वाले अलग-अलग प्रकार के 'यज्ञों' (Sacrifices) का वर्णन कर रहे हैं।
            समाज में हर इंसान का मानसिक और आध्यात्मिक स्तर (Frequency) अलग होता है, इसलिए सबके योग (साधना) के तरीके भी अलग होते हैं।
            १. पहले प्रकार के लोग: ये वे योगी हैं जो भौतिक दुनिया के देवताओं (जैसे इंद्र, वरुण) की पूजा करते हैं। इनका उद्देश्य देवताओं को खुश करके उनसे भौतिक सुख या शक्तियां पाना होता है। (यह शुरुआती स्तर है)।
            २. दूसरे प्रकार के लोग (परम ज्ञानी): ये वो लोग हैं जो किसी बाहरी देवता या आग की पूजा नहीं करते। वे अपनी ही आत्मा (Self) को परमात्मा (Supreme Self) रूपी आग में 'होम' (आहुति) कर देते हैं।
            इसका मतलब है कि वे अपने 'मैं' (Ego) और 'अहंकार' को पूरी तरह से जलाकर, अपनी व्यक्तिगत पहचान को ईश्वर में मिटा देते हैं (अद्वैत)।
            यह सबसे महान 'आंतरिक यज्ञ' (Internal Sacrifice) है, जहाँ आहुति अनाज की नहीं, बल्कि स्वयं के 'अहंकार' की दी जाती है।
        """.trimIndent(),
        english = """
            Some yogis flawlessly worship the demigods by offering various material sacrifices to them perfectly.
            And some others (advanced Jnana-yogis) offer the ultimate sacrifice by offering the self (the individual soul) entirely into the blazing fire of the Supreme Brahman.
            In the previous verse, the Lord described the absolute highest pinnacle of Yajna (Brahma-samadhi). Now, from verses 25 to 30, He categorizes the various different types of 'Yajnas' (Sacrifices) practiced by different levels of men in society.
            Every human operates on a completely different psychological and spiritual frequency, hence their specific methods of spiritual practice (Sadhana) vary greatly.
            1. The First Category: These are practicing yogis who rigidly worship the cosmic demigods (like Indra or Varuna) using material rituals. Their primary objective is to please these managers to extract material opulence or celestial powers. (This is the beginner level).
            2. The Second Category (Elite Sages): These ultra-advanced masters absolutely do not worship external demigods or external fires. They directly take their own 'Self' (Individual ego/soul) and forcefully offer it as a sacrifice into the blazing, infinite fire of the 'Supreme Brahman'.
            This profoundly means they violently burn their 'False Ego' and 'I-ness' to absolute ashes, completely erasing their individual material identity and perfectly merging into God.
            This is the absolute greatest 'Internal Yajna', where the offering is not cheap grain, but the ultimate sacrifice of the 'Ego' itself.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            श्रोत्रादीनीन्द्रियाण्यन्ये संयमाग्निषु जुह्वति |
            शब्दादीन्विषयानन्य इन्द्रियाग्निषु जुह्वति || २६ ||
        """.trimIndent(),
        hindi = """
            कुछ अन्य (ब्रह्मचारी) योगी अपनी श्रोत्र (कान) आदि सभी इन्द्रियों को 'संयम' (कंट्रोल) रूपी अग्नि में हवन (आहुति) कर देते हैं।
            और कुछ अन्य (गृहस्थ) योगी शब्द, रस आदि भौतिक विषयों को 'इन्द्रियों' रूपी अग्नि में आहुति दे देते हैं।
            भगवान श्रीकृष्ण यहाँ 'यज्ञ' की परिभाषा को और भी ज्यादा विशाल (Broad) कर रहे हैं। वे बता रहे हैं कि अपनी इन्द्रियों पर कंट्रोल करना भी एक बहुत बड़ा यज्ञ है।
            १. 'संयम रूपी अग्नि' (नैष्ठिक ब्रह्मचारी): कुछ ऐसे कट्टर योगी होते हैं जो अपनी इन्द्रियों (आँख, कान, जीभ) को बाहरी दुनिया के मजे लेने से पूरी तरह ब्लॉक (Block) कर देते हैं। उनका नियम इतना सख्त (Strict) होता है कि वे किसी भी भौतिक सुख को अपने पास फटकने भी नहीं देते। उनका यह कड़ा 'सेल्फ-कंट्रोल' (Self-control) ही उनका यज्ञ है।
            २. 'इन्द्रियों रूपी अग्नि' (गृहस्थ योगी): लेकिन जो लोग समाज (गृहस्थ जीवन) में रह रहे हैं, वे अपनी आँख-कान पूरी तरह बंद नहीं कर सकते। तो वे क्या करते हैं?
            वे विषयों (जैसे अच्छा खाना, संगीत, या सुंदरता) को अपनी इन्द्रियों से ग्रहण तो करते हैं, लेकिन 'आसक्ति' (Attachment) के बिना।
            वे उस खाने या संगीत को भगवान का प्रसाद समझकर इन्द्रियों रूपी आग में डालते हैं। वे इन्द्रियों का इस्तेमाल करते हैं, लेकिन इन्द्रियों के गुलाम नहीं बनते।
            भगवान स्पष्ट करते हैं कि चाहे आप जंगल में संन्यासी बनकर इन्द्रियों को रोकें, या घर में रहकर अनासक्त भाव से विषयों का भोग करें—दोनों ही अवस्थाएं परम 'यज्ञ' हैं।
        """.trimIndent(),
        english = """
            Some (the unadulterated Brahmacharis) sacrifice the hearing process and all other senses entirely into the blazing fire of strict mental restraint and control (Samyamagnishu).
            And others (the regulated householders) sacrifice the objects of the senses, such as sound, forms, and taste, directly into the fire of the senses (Indriyagnishu).
            Lord Sri Krishna is massively broadening and revolutionizing the traditional definition of 'Yajna' here. He declares that achieving absolute mastery over one's senses is in itself a spectacularly great sacrifice.
            1. 'The Fire of Restraint' (Strict Celibates): There are highly extreme yogis who completely, rigidly block their senses (eyes, ears, tongue) from accessing any external worldly pleasures. Their discipline is so titanium-strong that they absolutely refuse to let any material temptation even come near them. This brutal 'Self-Control' itself is their Yajna.
            2. 'The Fire of the Senses' (Regulated Householders): But what about those living actively in society with families? They cannot physically shut their eyes and ears permanently. What is their Yajna?
            They actively interact with sense objects (like good food, music, or beauty) using their senses, but with absolutely ZERO 'Attachment' (Asakti).
            They offer that food or experience into the 'fire of their senses' purely as sanctified mercy from God, strictly without greed. They expertly use the senses, but absolutely refuse to become slaves to them.
            The Lord beautifully clarifies that whether you strictly shut down your senses as a monk, or use them with supreme detachment as a householder—both are flawless, exalted forms of 'Yajna'.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            सर्वाणीन्द्रियकर्माणि प्राणकर्माणि चापरे |
            आत्मसंयमयोगाग्नौ जुह्वति ज्ञानदीपिते || २७ ||
        """.trimIndent(),
        hindi = """
            और कुछ अन्य ज्ञानी योगी अपनी इन्द्रियों के सभी कार्यों को, और प्राणों (सांसों/जीवन शक्ति) के सभी कार्यों को...
            ज्ञान द्वारा प्रज्वलित (जलाई गई) 'आत्मसंयम' (मन को वश में करने) रूपी योग की अग्नि में आहुति (हवन) कर देते हैं।
            यहाँ भगवान श्रीकृष्ण 'पतंजलि अष्टांग योग' (ध्यान योग) के सबसे गहरे (Advanced) स्तर का वर्णन कर रहे हैं।
            यह कोई साधारण यज्ञ नहीं है; यह एक अत्यंत कठोर और उच्च कोटि का 'आंतरिक (Internal) यज्ञ' है।
            इस स्तर का योगी अपने शरीर की सभी बाहरी इन्द्रियों (देखना, सुनना, बोलना) की गतिविधियों को पूरी तरह से बंद (Shut down) कर देता है।
            इतना ही नहीं, वह अपने शरीर के भीतर चलने वाले 'प्राणों' (Breathing and Vital life forces) के सिस्टम को भी अपने पूर्ण नियंत्रण में ले लेता है।
            वह अपनी चेतना (Consciousness) को बाहरी दुनिया से 100% कट ऑफ (Cut-off) करके, अपने मन को 'ज्ञान' (Knowledge of the Self) की प्रज्वलित आग में झोंक देता है।
            यहाँ 'आत्मसंयमयोगाग्नौ' का अर्थ है कि उसका मन (Mind) इतनी बुरी तरह से आत्मा के ध्यान में फोकस (Focused) हो चुका है कि उसके शरीर का वजूद (Physical existence) ही खत्म सा हो जाता है।
            वह अपने सारे शारीरिक और मानसिक व्यापारों की 'बलि' चढ़ाकर, केवल और केवल 'शुद्ध आत्मा' के रूप में स्थित हो जाता है। यह समाधि की सबसे अकल्पनीय और सर्वोच्च अवस्था है।
        """.trimIndent(),
        english = """
            And some others, who are exclusively interested in achieving the ultimate state of self-realization, sacrifice absolutely all the functions of all the senses, and completely suspend the functions of the life breath (Prana)...
            offering them entirely as oblations into the blazing fire of the controlled mind (Atma-samyama-yogagnau), which is brightly illuminated by pure spiritual knowledge (Jnana-dipite).
            Here, Lord Sri Krishna is vividly describing the absolute most advanced, ultra-elite level of the 'Patanjali Ashtanga Yoga' (The Yoga of Deep Meditation).
            This is absolutely no ordinary external ritual; it is a highly rigorous, exceptionally severe 'Internal Sacrifice'.
            A Yogi operating at this staggering altitude completely and aggressively shuts down 100% of all external sensory activities (seeing, hearing, speaking).
            Not only that, he masters and completely paralyzes the internal biological 'Prana' system (the subtle breathing and vital life forces moving within the physical body).
            He executes a brutal 100% cut-off of his consciousness from the external material matrix, and violently throws his entire flickering mind into the roaring, blazing fire of 'Pure Self-Knowledge'.
            Here, 'Atma-samyama-yogagnau' profoundly means his mind is so overwhelmingly and flawlessly focused strictly on the eternal soul that his physical bodily existence practically ceases to operate.
            By sacrificing absolutely all his physical and mental biological functions, he exists purely and exclusively as the 'Pure Spiritual Soul'. This is the most unimaginable, supreme altitude of Trance (Samadhi).
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            द्रव्ययज्ञास्तपोयज्ञा योगयज्ञास्तथापरे |
            स्वाध्यायज्ञानयज्ञाश्च यतयः संशितव्रताः || २८ ||
        """.trimIndent(),
        hindi = """
            कुछ दूसरे लोग अपनी संपत्ति (धन) का दान करके 'द्रव्ययज्ञ' करने वाले हैं; कुछ लोग कठिन तपस्या करके 'तपोयज्ञ' करने वाले हैं; कुछ लोग अष्टांग योग का अभ्यास करके 'योगयज्ञ' करने वाले हैं।
            और कुछ अत्यंत कठोर व्रत (नियम) पालने वाले यत्नशील पुरुष (यतयः) वेदों का अध्ययन करके 'स्वाध्याययज्ञ' और 'ज्ञानयज्ञ' करने वाले हैं।
            यज्ञों की इस शानदार लिस्ट (List) में भगवान बता रहे हैं कि ईश्वर तक पहुँचने का कोई एक फिक्स (Fixed) रास्ता नहीं है; इंसान अपनी क्षमता के अनुसार अपना 'यज्ञ' चुन सकता है।
            १. 'द्रव्ययज्ञ' (Sacrifice of Wealth): जो लोग बहुत अमीर हैं, वे अस्पताल, स्कूल या मंदिर बनाकर अपनी मेहनत की कमाई समाज के लिए त्याग देते हैं। यह उनका यज्ञ है।
            २. 'तपोयज्ञ' (Sacrifice of Austerity): जो लोग शरीर को कष्ट देकर कड़े व्रत रखते हैं (जैसे महीनों तक केवल फलाहार करना या हिमालय में सर्दी सहना), वे तपस्या का यज्ञ कर रहे हैं।
            ३. 'योगयज्ञ' (Sacrifice of Yoga): जो लोग तीर्थयात्राएं करते हैं या शरीर को शुद्ध करने के लिए प्राणायाम और योगासन करते हैं।
            ४. 'स्वाध्याय और ज्ञान यज्ञ' (Sacrifice of Knowledge): जो लोग ('संशितव्रताः' - जिनके संकल्प बहुत कठोर हैं) दिन-रात उपनिषदों और वेदों की पढ़ाई करते हैं, और उस ज्ञान को समाज में बाँटते हैं (जैसे बड़े-बड़े संत या दार्शनिक)।
            भगवान का स्पष्ट संदेश यह है कि यज्ञ का मतलब केवल 'अग्नि जलाना' नहीं है; 'त्याग' (Sacrifice) के साथ किया गया कोई भी पवित्र काम, चाहे वह पैसे का दान हो या ज्ञान का दान, ईश्वर की नजर में एक सर्वोच्च यज्ञ है।
        """.trimIndent(),
        english = """
            Some others, having accepted incredibly strict and severe vows (Samshita-vratah), perform the sacrifice of offering their material wealth in charity (Dravya-yajnah); some perform severe austerities (Tapo-yajnah); and others practice the eightfold mysticism of yoga (Yoga-yajnah).
            And there are yet other highly diligent endeavorers (Yatayah) who sacrifice their entire lives deeply studying the Vedas to advance in transcendental knowledge (Svadhyaya-jnana-yajnah).
            In this spectacular list of sacrifices, the Lord is brilliantly illustrating that there is absolutely no single, rigid, monopolized path to reach God; a human being can choose his specific 'Yajna' strictly according to his own personal capacity.
            1. 'Dravya-yajna' (Sacrifice of Wealth): Highly wealthy people who violently detach themselves from their hard-earned millions and build massive hospitals, free schools, or temples for public welfare are performing this sacrifice.
            2. 'Tapo-yajna' (Sacrifice of Austerity): People who voluntarily subject their physical bodies to extreme hardships (like fasting for months or tolerating freezing Himalayan winters) to burn their karma are performing this Yajna.
            3. 'Yoga-yajna' (Sacrifice of Yoga): Those who undertake insanely arduous pilgrimages or practice highly complex physical Yoga and breathing techniques to purify the system.
            4. 'Svadhyaya & Jnana Yajna' (Sacrifice of Knowledge): Elite scholars ('Samshita-vratah' - men of terrifyingly strict vows) who dedicate their entire lifetimes 24/7 to fiercely studying complex Upanishads and freely distributing that wisdom to society.
            The Lord's crystal-clear message is that Yajna absolutely does not just mean 'lighting a campfire'; any noble, prescribed action executed with the profound spirit of 'Sacrifice', whether donating billions or donating supreme knowledge, is a flawless Yajna in God's eyes.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            अपाने जुह्वति प्राणं प्राणेऽपानं तथापरे |
            प्राणापानगती रुद्ध्वा प्राणायामपरायणाः |
            अपरे नियताहाराः प्राणान्प्राणेषु जुह्वति || २९ ||
        """.trimIndent(),
        hindi = """
            कुछ दूसरे योगी 'अपान' वायु (नीचे जाने वाली सांस) में 'प्राण' वायु (अंदर आने वाली सांस) का हवन करते हैं, और कुछ 'प्राण' में 'अपान' का हवन करते हैं।
            कुछ योगी प्राण और अपान दोनों की ही गति (चाल) को रोककर (कुम्भक करके) पूरी तरह 'प्राणायाम' (सांसों के नियंत्रण) में लग जाते हैं।
            और कुछ अन्य योगी जो अपने आहार (भोजन) को अत्यंत सीमित (नियमित) कर लेते हैं, वे प्राणों को प्राणों में ही हवन (आहुति) करते हैं।
            यह श्लोक 'प्राणायाम' (Science of Breath Control) का अत्यंत गहरा और तकनीकी (Technical) विवरण है।
            हमारे शरीर में मुख्य रूप से दो प्रकार की वायु (हवा) चलती है: 'प्राण' (जो हम अंदर खींचते हैं) और 'अपान' (जो शरीर से बाहर निकलती है)।
            जब तक सांस ऊपर-नीचे चलती है, हमारा मन भी चंचल रहता है। हठयोगी अपनी सांसों की गति पर कंट्रोल करते हैं।
            १. 'पूरक' और 'रेचक': कुछ योगी सांस अंदर खींचकर उसे रोकते हैं (प्राण को अपान में मिलाना), और कुछ बाहर निकालकर रोकते हैं।
            २. 'कुम्भक': सबसे एडवांस योगी (प्राणायामपरायणाः) सांस को पूरी तरह जहाँ-का-तहाँ रोक (रुद्ध्वा) देते हैं। जब सांस रुक जाती है, तो मन 100% शून्य (Zero) और शांत हो जाता है, और व्यक्ति तुरंत समाधि (Trance) में चला जाता है।
            ३. 'नियताहाराः': कुछ योगी भोजन इतना कम कर देते हैं कि शरीर की मशीनरी धीमी पड़ जाती है। खाना कम होने से सांसें अपने-आप धीमी हो जाती हैं, जिससे इन्द्रियों की आग बुझ जाती है।
            भगवान बता रहे हैं कि सांसों को जीतना भी जीवन का सबसे महान 'यज्ञ' है, क्योंकि जो अपनी सांसों का मास्टर (Master) बन गया, वह अपने मन का बॉस (Boss) बन जाता है।
        """.trimIndent(),
        english = """
            Still others, deeply dedicated to the practice of controlling the breath (Pranayama-parayanah), offer the movement of the outgoing breath (Apana) directly into the incoming breath (Prana), and offer the incoming breath into the outgoing breath.
            Ultimately, they completely arrest and stop the movement of both the incoming and outgoing breaths entirely (Ruddhva), remaining in a perfect, breathless trance.
            And there are some others who strictly and severely curtail their eating process (Niyataharah), and offer the exhaled breath into itself as a sacrifice.
            This highly technical verse provides a profoundly deep, scientific breakdown of 'Pranayama' (The Ultimate Science of Breath Control).
            Inside the human biological machine, two primary vital airs constantly function: 'Prana' (the breath being inhaled) and 'Apana' (the breath being exhaled).
            As long as this physical breathing fluctuates rapidly, the human mind remains violently restless. Elite Hatha-yogis specifically target and hijack this breathing mechanism.
            1. 'Puraka & Rechaka': Some yogis aggressively inhale and lock the breath inside (merging Prana into Apana), while others exhale entirely and lock it outside.
            2. 'Kumbhaka': The most absolutely advanced masters completely paralyze and stop ('Ruddhva') the motion of breath altogether. The precise microsecond the breathing hits absolute Zero, the mind instantly collapses into perfect, deafening silence, shooting the Yogi straight into ultimate Samadhi (Trance).
            3. 'Niyataharah': Some hardcore yogis brutally restrict their food intake to a microscopic level. Starving the biological machine automatically slows down the breathing rate exponentially, violently crushing the fire of the senses.
            The Lord confirms that conquering the biological breath is an exceptionally magnificent 'Yajna', because a human who becomes the absolute Master of his lungs instantly becomes the undisputed Boss of his mind.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            सर्वेऽप्येते यज्ञविदो यज्ञक्षपितकल्मषाः |
            यज्ञशिष्टामृतभुजो यान्ति ब्रह्म सनातनम् || ३० ||
        """.trimIndent(),
        hindi = """
            यह जितने भी यज्ञ करने वाले योगी (श्लोक 25 से 29 तक बताए गए) हैं, वे सभी यज्ञ के परम रहस्य को भली-भांति जानने वाले (यज्ञविदः) हैं; और इन यज्ञों के प्रभाव से उनके सारे पाप (कल्मष) पूरी तरह नष्ट हो चुके हैं।
            वे इस यज्ञ के बाद बचे हुए अमृत (यज्ञशिष्टामृत) का भोग (अनुभव) करने वाले योगी अंततः उस सनातन (हमेशा रहने वाले) परब्रह्म परमात्मा को ही प्राप्त होते हैं।
            भगवान श्रीकृष्ण ने पिछले पांच श्लोकों में जो अलग-अलग प्रकार के यज्ञों (संपत्ति का दान, तपस्या, योग, स्वाध्याय, और प्राणायाम) की एक लंबी लिस्ट बताई थी, यह श्लोक उन सभी का फाइनल रिज़ल्ट (Final Result) है।
            भगवान कहते हैं कि इंसान चाहे इनमें से कोई भी यज्ञ (रास्ता) चुने, अगर वह इसे पूरी निष्ठा और स्वार्थ-रहित होकर करता है, तो उसका दिमाग एक डिटर्जेंट (Detergent) की तरह धुलकर पूरी तरह साफ हो जाता है ('यज्ञक्षपितकल्मषाः' - पापों का नाश)।
            जब पाप नष्ट हो जाते हैं, तो उस यज्ञ से एक बहुत ही खास चीज़ पैदा होती है—'यज्ञशिष्टामृत'।
            यह कोई पीने वाला अमृत नहीं है; यह वह दिव्य आनंद (Spiritual Ecstasy) और परम शांति है जो कोई बड़ा त्याग करने के बाद इंसान की आत्मा महसूस करती है।
            जो व्यक्ति रोज़ इस आध्यात्मिक आनंद (अमृत) को चखता है, उसका भौतिक दुनिया से मन पूरी तरह हट जाता है।
            और अंततः (मृत्यु के बाद), वह 'सनातन ब्रह्म' (उस परम और शाश्वत ईश्वर) में हमेशा के लिए विलीन (Merge) हो जाता है।
            शॉर्ट में: कोई भी सच्चा यज्ञ करो -> पाप जलेंगे -> दिव्य आनंद मिलेगा -> और अंत में साक्षात् भगवान मिलेंगे।
        """.trimIndent(),
        english = """
            All these different performers who perfectly know the deep meaning and purpose of sacrifice (Yajna-vidah) become completely cleansed of all their sinful reactions (Yajna-kshapita-kalmashah).
            And having tasted the divine nectar (Amrita) of the remnants of such massive sacrifices, they ultimately advance to the supreme eternal atmosphere and attain the eternal Supreme Brahman.
            Lord Sri Krishna provided a massively extensive list of various distinct sacrifices (donating wealth, severe austerities, Ashtanga yoga, scriptural study, and breath control) over the last five verses. This verse brilliantly summarizes the absolute 'Final Result' of all of them combined.
            The Lord guarantees that no matter which specific hardcore path (Yajna) a human chooses, if he executes it with absolute sincerity and zero selfishness, that Yajna acts like an incredibly potent, cosmic detergent, violently washing away all the accumulated toxic dirt and sins of millions of lifetimes ('Yajna-kshapita-kalmashah').
            When all sins are incinerated, a highly specific byproduct is generated from that sacrifice—'Yajna-shishtamrita'.
            This is absolutely not a physical, liquid drink; it is the blinding, intoxicating 'Spiritual Ecstasy' and absolute, profound peace that the soul directly experiences after performing a massive selfless sacrifice.
            A yogi who daily tastes this highly addictive spiritual nectar (Amrita) automatically loses his entire appetite for cheap material pleasures.
            And ultimately (after dropping the physical body), he flawlessly and permanently merges into the 'Sanatana Brahman' (The Absolute, Eternal Supreme Godhead).
            In short: Execute any genuine sacrifice -> Sins are brutally destroyed -> Divine Ecstasy is tasted -> Supreme God is permanently attained.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            नायं लोकोऽस्त्ययज्ञस्य कुतोऽन्यः कुरुसत्तम |
            एवं बहुविधा यज्ञा वितता ब्रह्मणो मुखे || ३१ || (Part 1 of combined meaning)
            कर्मजान्विद्धि तान्सर्वानैवं ज्ञात्वा विमोक्ष्यसे || ३२ || (Part 2 of combined meaning)
        """.trimIndent(),
        hindi = """
            (श्लोक 31 और 32 का संयुक्त भाव): हे कुरुश्रेष्ठ (अर्जुन)! जो मनुष्य अपने जीवन में कोई 'यज्ञ' (निस्वार्थ कर्तव्य या त्याग) नहीं करता, उसके लिए तो यह मनुष्य लोक (धरती का जीवन) भी सुखदायक नहीं है, फिर उसके लिए परलोक (स्वर्ग या अगला जन्म) कैसे सुखदायक हो सकता है?
            इस प्रकार और भी बहुत से अलग-अलग प्रकार के यज्ञ वेदों (ब्रह्मा के मुख) में विस्तार से बताए गए हैं। तुम उन सभी यज्ञों को 'कर्म' (मन, इन्द्रियों और शरीर की क्रियाओं) से ही उत्पन्न होने वाला समझो (अर्थात् बिना एक्शन के कोई यज्ञ नहीं होता)।
            इस सच्चाई को इस तरह तत्व से जानकर (कि कर्म करना अनिवार्य है), तुम कर्मों के भयानक बंधनों से हमेशा के लिए मुक्त (विमोक्ष्यसे) हो जाओगे।
            यहाँ श्रीकृष्ण स्वार्थी और कामचोर इंसानों पर एक और बड़ा मनोवैज्ञानिक वार कर रहे हैं।
            वे कहते हैं कि जो इंसान 'अयज्ञस्य' है—यानी जो समाज को कुछ वापस नहीं देता, जो केवल अपने लिए पैसे और खाना बटोरता है—ऐसे इंसान की तो यह वर्तमान जिंदगी (Physical life) भी नरक बन जाती है।
            जब आप केवल स्वार्थ के लिए जीते हैं, तो समाज आपसे नफरत करता है, आपके अपने परिवार वाले आपसे कट जाते हैं, और आपका मन 24 घंटे चिंता में जलता रहता है। जब यह लोक ही नर्क बन गया, तो परलोक (मरने के बाद) में शांति कैसे मिलेगी?
            वेदों में ऐसे सैकड़ों यज्ञ लिखे हैं, लेकिन उन सबका 'बेस' (Base/आधार) एक ही है—'कर्म'। बिना मेहनत (Action) किए न तो ज्ञान मिलता है और न ही मोक्ष।
            भगवान अर्जुन की इस गलतफहमी को फिर से तोड़ रहे हैं कि "मैं हथियार डालकर अकर्म (Inaction) में चला जाऊंगा।" भगवान कह रहे हैं कि तुम्हें शरीर, मन या बुद्धि से कर्म तो करना ही पड़ेगा, बस उसे 'यज्ञ' (भगवान को समर्पित) बना दो, तो तुम तुरंत मुक्त हो जाओगे।
        """.trimIndent(),
        english = """
            (Combined meaning of Verses 31 & 32): O best of the Kuru dynasty (Kuru-sattama)! For a human being who absolutely performs no sacrifice (Ayajnasya), he can never live happily even in this present world or in this very life; what then to speak of his next life in another world?
            All these multifarious and vast varieties of sacrifices are elaborately and explicitly described in the Vedas (extending from the mouth of Brahman).
            You should profoundly understand that absolutely all of them are born solely of action (Karmajan) performed by the body, mind, or intelligence. Knowing this ultimate truth perfectly, you shall become eternally liberated (Vimokshyase).
            Here, Sri Krishna is launching another massive psychological strike against incredibly selfish and lazy human beings.
            He declares that a person who is 'Ayajnasya'—meaning a parasite who extracts everything from society but sacrifices absolutely nothing in return, aggressively hoarding resources purely for his own bloated ego—such a person's current physical life on this very earth degrades into a suffocating hell.
            When you live strictly for your own toxic selfishness, society despises you, your own blood relatives disconnect from you, and your brain burns 24/7 in extreme paranoia. If this present life is already a nightmare, how on earth can you expect peace in the afterlife (Perlok)?
            There are hundreds of complex Yajnas prescribed in the Vedas, but their absolute, non-negotiable 'Base Foundation' is exactly one thing—'Karma' (Intense Action). Without grueling effort and action, neither knowledge nor liberation is possible.
            The Lord is violently shattering Arjuna's pathetic illusion that "I will just drop my bow and slip into peaceful inaction." The Lord commands: You are biologically forced to act with your body and mind; simply convert that exact intense action into a 'Yajna' (Offering to God), and you will be instantly and permanently liberated.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            श्रेयान्द्रव्यमयाद्यज्ञाज्ज्ञानयज्ञः परन्तप |
            सर्वं कर्माखिलं पार्थ ज्ञाने परिसमाप्यते || ३३ ||
        """.trimIndent(),
        hindi = """
            हे परन्तप (शत्रुओं को तपाने वाले अर्जुन)! भौतिक द्रव्यों (पैसे, अन्न या सामग्री) से किए जाने वाले यज्ञ की तुलना में 'ज्ञान यज्ञ' (आध्यात्मिक ज्ञान प्राप्त करने का यज्ञ) बहुत अधिक श्रेष्ठ (श्रेयान्) है।
            क्योंकि हे पार्थ! संसार के संपूर्ण कर्म (सारे अच्छे काम और यज्ञ) अंततः अपने पूर्ण रूप में 'ज्ञान' में ही जाकर समाप्त (परिसमाप्यते) हो जाते हैं।
            यह श्लोक 'ज्ञान' (Knowledge) की सर्वोच्चता की सबसे बड़ी घोषणा (Declaration) है।
            भगवान कहते हैं कि अगर कोई व्यक्ति अरबों रुपए दान कर दे, करोड़ों गरीबों को खाना खिला दे, या सोने (Gold) से बड़े-बड़े मंदिर बनवा दे ('द्रव्यमय यज्ञ')—यह बहुत अच्छा और पुण्य का काम है।
            लेकिन इससे करोड़ों गुना बड़ा और पावरफुल यज्ञ है 'ज्ञान यज्ञ' (अध्यात्म की पढ़ाई करना, ईश्वर को समझना, और सत्य का प्रचार करना)। क्यों?
            क्योंकि भौतिक दान (पैसे या खाने का दान) इंसान की केवल 'टेंपरेरी' (Temporary/अस्थायी) भूख मिटाता है। आज खाना खिलाओगे, कल वह इंसान फिर भूखा होगा।
            लेकिन 'ज्ञान' इंसान के अज्ञान (Ignorance) को हमेशा के लिए जड़ से मिटा देता है और उसे जन्म-मरण के चक्र से ही आज़ाद कर देता है।
            श्रीकृष्ण एक बहुत बड़ा सिद्धांत देते हैं: "सर्वं कर्माखिलं ज्ञाने परिसमाप्यते" (दुनिया के सारे महान कर्म अंत में ज्ञान में जाकर ही खत्म होते हैं)।
            आप चाहे जितना भी दान-पुण्य कर लें, आपका अंतिम लक्ष्य (Target) मन की शुद्धि के माध्यम से 'ज्ञान' (ईश्वर का साक्षात्कार) प्राप्त करना ही है। ज्ञान ही सभी कर्मों का 'एंड-पॉइंट' (End-point) है।
        """.trimIndent(),
        english = """
            O chastiser of the enemy (Parantapa)! The sacrifice performed in knowledge (Jnana-yajna) is vastly and infinitely superior (Shreyan) to the sacrifice composed merely of material possessions or wealth (Dravyamayad yajnat).
            After all, O son of Pritha, all sacrifices of work and every single material activity culminate and reach their absolute, ultimate perfection completely within transcendental knowledge (Jnane parisamapyate).
            This phenomenal verse is the absolute, supreme declaration of the unmatched superiority of 'Transcendental Knowledge' (Jnana) over everything else in existence.
            The Lord asserts that if a billionaire donates his entire fortune, feeds millions of starving people, or constructs massive temples out of solid gold ('Dravya-yajna')—this is undoubtedly highly pious and noble.
            But a billion times more powerful and majestic than that is the 'Jnana Yajna' (The sacrifice of intensely acquiring, mastering, and distributing absolute spiritual truth). Why?
            Because material charity (donating food or cash) merely cures a human's 'Temporary' physical hunger. Feed him today, and he will be violently hungry again tomorrow.
            But giving a human 'Transcendental Knowledge' permanently slaughters the root cause of his suffering (Ignorance) and permanently liberates him from the terrifying matrix of reincarnation.
            Sri Krishna delivers an ultimate cosmic principle: "Sarvam karmakhilam jnane parisamapyate" (Absolutely all massive, righteous actions ultimately hit their final climax and terminate strictly in Knowledge).
            No matter how many millions of pious actions you perform, your ultimate, final target is simply to purify your mind enough to attain 'Enlightenment' (Jnana). Knowledge is the absolute 'End-point' of all human action.
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            तद्विद्धि प्रणिपातेन परिप्रश्नेन सेवया |
            उपदेक्ष्यन्ति ते ज्ञानं ज्ञानिनस्तत्त्वदर्शिनः || ३४ ||
        """.trimIndent(),
        hindi = """
            तुम उस परम ज्ञान (तत्त्वज्ञान) को किसी प्रामाणिक गुरु के पास जाकर समझने का प्रयास करो (तद्विद्धि)।
            उन्हें दंडवत प्रणाम (प्रणिपातेन) करने से, उनसे उचित प्रश्न (परिप्रश्नेन) पूछने से, और उनकी निस्वार्थ सेवा (सेवया) करने से...
            वे तत्त्वदर्शी ज्ञानी महापुरुष (जिन्होंने वास्तव में सत्य को देखा है) तुम्हें उस परम ज्ञान का उपदेश देंगे (उपदेक्ष्यन्ति)।
            यह पूरी भगवद्गीता के सबसे प्रसिद्ध और महत्वपूर्ण श्लोकों में से एक है। यह 'गुरु' (Spiritual Master) के पास जाने का सही तरीका (Protocol) बताता है।
            श्रीकृष्ण ने ज्ञान की बहुत महिमा बताई, लेकिन अब अर्जुन (और हम) सोच सकते हैं कि "यह ज्ञान मिलेगा कहाँ से? क्या गूगल (Google) करने से या लाइब्रेरी में किताबें पढ़ने से ज्ञान मिल जाएगा?"
            भगवान स्पष्ट कहते हैं, "नहीं!" यह ज्ञान किसी किताब में नहीं, बल्कि एक 'तत्त्वदर्शी' (जिसने भगवान को खुद अपनी आँखों से अनुभव किया है) महापुरुष के हृदय में रहता है।
            उस गुरु से यह ज्ञान डाउनलोड (Download) करने के तीन कड़े नियम (Passwords) हैं:
            १. 'प्रणिपातेन' (झुकना/Surrender): अपना सारा ईगो (Ego) और डिग्रियां बाहर छोड़कर गुरु के सामने पूरी तरह झुक जाओ (विनम्र बनो)। एक भरा हुआ कप (अहंकार) कभी और नहीं भरा जा सकता।
            २. 'परिप्रश्नेन' (सवाल पूछना): आँख बंद करके अंधभक्त मत बनो। सत्य को जानने के लिए लॉजिकल (Logical) और गहरे सवाल पूछो (जैसे अर्जुन पूछ रहे हैं), लेकिन बहस (Argument) या गुरु को नीचा दिखाने के लिए नहीं।
            ३. 'सेवया' (सेवा): गुरु को पैसे नहीं चाहिए; वे आपकी निस्वार्थ 'सेवा' से खुश होते हैं। जब गुरु का दिल आपकी सेवा से पिघलता है, तो ज्ञान खुद-ब-खुद (Transfer) हो जाता है।
        """.trimIndent(),
        english = """
            Just try to learn and profoundly understand this absolute truth by formally approaching a bona fide spiritual master (Guru).
            Inquire from him submissively and humbly (Pariprashnena), fall down before him in full surrender (Pranipatena), and render selfless service unto him (Sevaya).
            The self-realized, enlightened souls (Tattva-darshinah) can instantly impart and initiate you into this supreme knowledge because they have actually seen the absolute truth.
            This is universally acknowledged as one of the most spectacularly famous and crucial verses in the Gita. It lays down the absolute, non-negotiable 'Protocol' for acquiring a Guru.
            Sri Krishna highly glorified knowledge, but Arjuna (and humanity) would naturally ask: "Where on earth do I download this knowledge? Can I get it by Googling or reading massive libraries of ancient books?"
            The Lord delivers a brutally clear "No!" This supreme knowledge is not locked in paper books; it is physically and spiritually alive exclusively within the heart of a 'Tattva-darshi' (a Grandmaster who has directly, experientially 'Seen' God).
            There are three extremely strict Passwords (Protocols) required to successfully download this knowledge from the Guru:
            1. 'Pranipatena' (Total Surrender): Aggressively leave your toxic ego, massive wealth, and university degrees at the door. Fall completely flat (submissive) before the master. A cup already full of arrogant ego simply cannot receive a single drop of new knowledge.
            2. 'Pariprashnena' (Intelligent Inquiry): Do not become a blind, mindless sheep. Ask intensely logical, highly profound questions (exactly like Arjuna is doing) to decode the truth, but NEVER ask questions simply to argue, challenge, or insult the master.
            3. 'Sevaya' (Selfless Service): A genuine Guru absolutely does not want your billions. He is pleased exclusively by your utterly selfless, physical, and mental 'Service'. When the Guru's heart melts seeing your pure service, the supreme knowledge is automatically and magically transferred into your heart.
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            यज्ज्ञात्वा न पुनर्मोहमेवं यास्यसि पाण्डव |
            येन भूतान्यशेषेण द्रक्ष्यस्यात्मन्यथो मयि || ३५ ||
        """.trimIndent(),
        hindi = """
            हे पाण्डव (अर्जुन)! उस तत्त्वदर्शी गुरु से उस परम ज्ञान को प्राप्त कर लेने के बाद तुम फिर कभी इस प्रकार के भयंकर मोह (अज्ञान या भ्रम) में नहीं फँसोगे।
            और उस ज्ञान के द्वारा तुम यह स्पष्ट देख लोगे कि सम्पूर्ण प्राणी (ब्रह्मांड के सभी जीव) पहले तुम्हारी ही आत्मा (आत्मनि) में हैं, और फिर वे सब मुझ परमेश्वर (मयि) में ही स्थित हैं।
            यह श्लोक उस 'सच्चे ज्ञान' (Enlightenment) का फाइनल रिज़ल्ट (Final Result) बता रहा है जो गुरु से मिलता है।
            भगवान अर्जुन को एक बहुत बड़ी गारंटी (Guarantee) दे रहे हैं: "अगर तुमने गुरु से सही ज्ञान ले लिया, तो तुम जीवन में कभी भी (न पुनर्मोहम्) दोबारा इस डिप्रेशन (Depression), डर या कंफ्यूजन का शिकार नहीं होगे।"
            अर्जुन का अभी मोह क्या है? वे सोच रहे हैं: "ये मेरे भाई हैं, ये मेरे गुरु हैं, अगर ये मर गए तो क्या होगा?"
            लेकिन जब 'ज्ञान' का चश्मा आँखों पर लगता है, तो इंसान की विज़न (Vision) 3D से बढ़कर 'गॉड-डायमेंशन' (God-Dimension) की हो जाती है।
            उसे यह ब्रह्मांड अलग-अलग टुकड़ों या जातियों में नहीं दिखता। उसे दिखता है कि चींटी से लेकर हाथी तक, और दुर्योधन से लेकर अर्जुन तक—सबके भीतर एक ही आत्मा है ('आत्मनि')।
            और फिर उसे दिखता है कि ये सभी आत्माएं अलग-अलग नहीं, बल्कि उस एक ही परमेश्वर (श्रीकृष्ण/मयि) के शरीर का हिस्सा हैं।
            जब इंसान हर किसी में भगवान को ही देखने लगता है, तो फिर वह किससे नफरत करेगा और किसके मरने पर रोएगा? यही 'अद्वैत' (Oneness) का सबसे बड़ा और अंतिम दर्शन है, जो सारे दुःखों का हमेशा के लिए अंत कर देता है।
        """.trimIndent(),
        english = """
            Having obtained this absolute, real knowledge from a self-realized soul, you will absolutely never again fall into such a terrifying illusion or bewilderment (Na punar moham), O son of Pandu.
            For by this supreme knowledge, you will flawlessly see that all living beings in existence (Bhutani asheshena) are but part of the Supreme, or, in other words, that they are situated right within Me (Mayi).
            This spectacular verse officially declares the absolute, ultimate 'Final Result' of receiving true 'Enlightenment' from a bonafide Guru.
            The Lord is giving Arjuna an iron-clad, massive Cosmic Guarantee: "Once you successfully download this pure truth from the master, you will absolutely never, ever ('Na punar moham') relapse into this pathetic state of depression, paralyzing fear, or toxic attachment again."
            What exactly is Arjuna's current crippling illusion? He is hallucinating: "These are MY brothers, these are MY beloved teachers, what will happen to MY world if they die?"
            But the exact microsecond the 'Lens of Knowledge' is installed over his eyes, his vision aggressively upgrades from 3D directly to the 'God-Dimension'.
            He completely stops seeing the universe as a fragmented, chaotic mess of different species, races, or enemies. He vividly sees that from the tiniest microscopic ant to the massive Duryodhana—every single entity shares the exact same spiritual soul ('Atmani').
            And ultimately, he sees that all these billions of souls are absolutely not separate; they are all intimately woven as tiny parts and parcels existing perfectly right inside the Supreme Lord (Sri Krishna/Mayi).
            When a human being literally sees God in every single atom and every single person, who is left to violently hate, and whose death is left to bitterly cry over? This is the ultimate, grand vision of 'Oneness' (Advaita) that permanently slaughters all sorrow forever.
        """.trimIndent()
    ),
    Shloka(
        id = 36,
        sanskrit = """
            अपि चेदसि पापेभ्यः सर्वेभ्यः पापकृत्तमः |
            सर्वं ज्ञानप्लवेनैव वृजिनं सन्तरिष्यसि || ३६ ||
        """.trimIndent(),
        hindi = """
            यदि तू संसार के सभी पापियों (पापेभ्यः सर्वेभ्यः) से भी बहुत अधिक भयंकर पाप करने वाला (पापकृत्तमः) सबसे बड़ा महापापी ही क्यों न हो...
            तो भी तू केवल इस 'ज्ञान रूपी नौका' (ज्ञानप्लवेन) में बैठकर उस संपूर्ण पाप-रूपी महासागर (वृजिनं) को बहुत ही आसानी से और भली-भांति पार कर जाएगा (सन्तरिष्यसि)।
            यह श्लोक सनातन धर्म की असीम दया, क्षमा और 'होप' (Hope / आशा) का सबसे महान प्रतीक है।
            दुनिया के कई धर्म कहते हैं कि अगर तुमने कोई बहुत बड़ा पाप (Sin) कर दिया, तो तुम हमेशा के लिए नर्क की आग में जलोगे और तुम्हें कोई नहीं बचा सकता।
            लेकिन भगवान श्रीकृष्ण यहाँ एक अत्यंत क्रांतिकारी (Revolutionary) बात कहते हैं।
            वे कहते हैं कि कल्पना करो, अगर कोई इंसान दुनिया का सबसे खूंखार हत्यारा, बलात्कारी या सबसे बड़ा आतंकवादी ('पापकृत्तमः') भी है... अगर उसके पापों का एक विशाल और गहरा समंदर बन चुका है...
            तो भी उसे निराश होने या आत्महत्या करने की कोई जरूरत नहीं है!
            जैसे ही उस इंसान के जीवन में सच्चा 'आध्यात्मिक ज्ञान' (कि मैं शरीर नहीं आत्मा हूँ और भगवान का अंश हूँ) उदय होता है, वह ज्ञान एक बहुत बड़ी और मजबूत 'नाव' (प्लव / Boat) बन जाता है।
            ज्ञान की वह नाव कितनी भी बड़ी और खतरनाक पापों की सुनामी (Tsunami) क्यों न हो, उसे बिना डूबे आराम से पार करा देती है।
            शर्त सिर्फ एक है: इंसान को अपने पाप का अहंकार छोड़कर इस 'ज्ञान की नाव' में पूरी श्रद्धा के साथ बैठना (समर्पण करना) होगा। ईश्वर के ज्ञान की ताकत इंसान के किसी भी पाप से करोड़ों गुना बड़ी है।
        """.trimIndent(),
        english = """
            Even if you are universally considered to be the most horrific and wicked of all sinners (Papa-krittamah) among all sinful men (Papebhyah sarvebhyah)...
            once you are safely situated in the impenetrable boat of transcendental knowledge (Jnana-plavena), you will effortlessly and completely cross over this entire terrifying ocean of miseries and sin (Vrijinam santarishyasi).
            This specific verse stands as the absolute greatest, most breathtaking symbol of infinite mercy, ultimate forgiveness, and staggering 'Hope' in Sanatana Dharma.
            Many global philosophies terrifyingly dictate that if you commit a massively horrific sin, you are permanently damned to burn in hellfire for all eternity with absolutely zero chance of redemption.
            But Lord Sri Krishna drops an incredibly revolutionary, paradigm-shifting bomb here.
            He declares: Imagine a human being who is officially the universe's most ruthless murderer, a savage terrorist, or the absolute worst of all cosmic sinners ('Papa-krittamah')... even if his accumulated sins have formed a bottomless, toxic, raging black ocean...
            he absolutely does not need to drown in suicidal despair!
            The exact microsecond true 'Spiritual Knowledge' (the realization that "I am a pure eternal soul, part of God") powerfully dawns upon his mind, that blazing knowledge instantly manifests as a massive, indestructible, unsinkable 'Boat' (Plava).
            No matter how violent or terrifying the massive Tsunami of his past sins is, that titanic Boat of Knowledge will effortlessly carry him safely across to the shores of liberation.
            There is only one strict condition: The sinner must completely drop his massive ego, genuinely repent, and firmly sit inside this 'Boat of Knowledge' with absolute surrender. The staggering power of God's knowledge is infinitely greater than the darkest human sin.
        """.trimIndent()
    ),
    Shloka(
        id = 37,
        sanskrit = """
            यथैधांसि समिद्धोऽग्निर्भस्मसात्कुरुतेऽर्जुन |
            ज्ञानाग्निः सर्वकर्माणि भस्मसात्कुरुते तथा || ३७ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! जिस प्रकार पूरी तरह से भड़कती हुई (प्रज्वलित) आग (समिद्धोऽग्निः) सूखी लकड़ियों (एधांसि) के बड़े से बड़े ढेर को एक पल में जलाकर पूरी तरह राख (भस्म) कर देती है...
            ठीक उसी प्रकार, 'ज्ञान रूपी अग्नि' (ज्ञानाग्निः) इंसान के सभी जन्मों के संपूर्ण कर्मों (पाप और पुण्य दोनों को) एक साथ जलाकर पूरी तरह राख (भस्मसात्) कर देती है।
            पिछले श्लोक में भगवान ने ज्ञान को 'नाव' (Boat) कहा था जो हमें बचाती है। अब इस श्लोक में भगवान ज्ञान को 'आग' (Fire) कह रहे हैं जो सब कुछ जलाकर खत्म कर देती है।
            यह श्लोक 'कर्म के सिद्धांत' (Law of Karma) को बायपास (Bypass) करने का अल्टीमेट चीट-कोड (Ultimate Cheat-code) है।
            इंसान ने अपने करोड़ों पिछले जन्मों में इतने पाप और पुण्य (Karma) किए हैं कि अगर वह एक-एक करके उनका फल (सुख-दुःख) भोगने बैठे, तो उसे करोड़ों जन्म और लेने पड़ेंगे। यह कर्मों का एक बहुत बड़ा, सूखा पहाड़ (लकड़ियों का ढेर) है।
            क्या इंसान कभी इस पहाड़ को खत्म कर पाएगा? साधारण रूप से नहीं।
            लेकिन श्रीकृष्ण कहते हैं कि जब इंसान को यह सुप्रीम रियलाइजेशन (Supreme Realization / ज्ञान) हो जाता है कि "मैं तो शरीर हूँ ही नहीं, मैं आत्मा हूँ, और मैंने कभी कोई काम किया ही नहीं, सब प्रकृति ने किया है"...
            तो यह अहसास (ज्ञान) एक भयंकर 'आग' (ज्ञानाग्नि) बन जाता है।
            जैसे 100 साल पुराना लकड़ियों का पहाड़ भी एक छोटी सी तीली (माचिस) से चंद मिनटों में राख हो जाता है, वैसे ही करोड़ों जन्मों का जमा हुआ 'कर्मों का बैंक-बैलेंस' (Karmic Bank Balance) इस आत्मज्ञान की आग में एक सेकंड में जलकर 'ज़ीरो' (Zero) हो जाता है। इंसान तुरंत मुक्त (Liberate) हो जाता है।
        """.trimIndent(),
        english = """
            As a furiously blazing and roaring fire (Samiddho agnih) turns a massive mountain of dry firewood to absolute ashes (Bhasmasat kurute), O Arjuna...
            in the exact same manner, the blinding fire of transcendental knowledge (Jnanagnih) violently burns to ashes absolutely all reactions to material activities (Sarva-karmani).
            In the previous verse, the Lord beautifully compared Knowledge to an unsinkable 'Boat' that rescues. Now, in this terrifyingly powerful verse, He compares Knowledge to an explosive, roaring 'Fire' that completely annihilates.
            This verse provides the absolute 'Ultimate Cheat-code' to completely bypass and violently hack the incredibly strict 'Law of Karma'.
            Over millions of past lifetimes, a human soul has aggressively accumulated such a colossal, Everest-sized mountain of good and bad karmic reactions (the dry firewood) that if he were to experience the results of each action one by one, he would be forced to take billions of more births.
            Can a mortal ever possibly empty this infinite mountain? Normally, absolutely not.
            But Sri Krishna declares that the exact microsecond a human achieves the Supreme Realization (Jnana) that "I am absolutely not this physical body; I am the pure eternal soul, and I have actually never performed any material action; material nature did it all"...
            this explosive realization instantly manifests as a terrifying 'Fire of Knowledge' (Jnanagni).
            Just as a massive, 100-year-old mountain of dry wood is completely reduced to microscopic ash in minutes by a single, tiny matchstick, the entire 'Karmic Bank Balance' spanning millions of lifetimes is violently incinerated to absolute 'Zero' in a single second by this fire of self-realization. The soul is instantly and permanently liberated.
        """.trimIndent()
    ),
    Shloka(
        id = 38,
        sanskrit = """
            न हि ज्ञानेन सदृशं पवित्रमिह विद्यते |
            तत्स्वयं योगसंसिद्धः कालेनात्मनि विन्दति || ३८ ||
        """.trimIndent(),
        hindi = """
            इस पूरे संसार में 'आध्यात्मिक ज्ञान' (तत्त्वज्ञान) के समान पवित्र करने वाली (शुद्ध करने वाली) दूसरी कोई भी चीज़ मौजूद (विद्यते) नहीं है।
            उस परम ज्ञान को, जो मनुष्य निष्काम कर्मयोग में पूरी तरह से सिद्ध (परफेक्ट/योगसंसिद्धः) हो चुका है, वह अपने आप ही, सही समय (काल) आने पर अपनी ही आत्मा (भीतर) में अनुभव (विन्दति) कर लेता है।
            भगवान श्रीकृष्ण यहाँ 'ज्ञान' (Knowledge) को इस ब्रह्मांड का सबसे बेहतरीन और शक्तिशाली 'डिटर्जेंट' (Detergent/Purifier) घोषित कर रहे हैं।
            लोग खुद को पवित्र करने के लिए गंगा में नहाते हैं, तीर्थयात्राओं पर जाते हैं, या कड़े उपवास रखते हैं। ये सब शरीर या मन को थोड़ी देर के लिए शुद्ध कर सकते हैं।
            लेकिन भगवान कहते हैं कि इंसान की चेतना (Consciousness) में जो करोड़ों जन्मों का मैल (पाप और अहंकार) जमा है, उसे धोने की ताकत इस दुनिया की किसी नदी या साबुन में नहीं है।
            वह मैल केवल और केवल 'आत्मज्ञान' (कि मैं ईश्वर का अंश हूँ) रूपी तेजाब से ही कट सकता है। ज्ञान से बड़ा कोई 'प्यूरिफायर' (Purifier) नहीं है।
            फिर सवाल आता है कि यह ज्ञान मिलेगा कैसे? क्या यह ज्ञान किसी दुकान पर मिलेगा?
            श्रीकृष्ण कहते हैं कि यह ज्ञान बाहर से नहीं आता। जब तुम लंबे समय तक ('कालेन') बिना किसी स्वार्थ के अपना काम (कर्मयोग) पूरी ईमानदारी से करते हो ('योगसंसिद्धः'), तो तुम्हारा मन शीशे की तरह साफ हो जाता है।
            और जब मन साफ हो जाता है, तो यह 'सुप्रीम ज्ञान' (Supreme Knowledge) किसी बाहर के स्रोत से नहीं, बल्कि तुम्हारे अपने ही 'अंदर' (आत्मनि) एक धमाके के साथ अपने आप प्रकट (विन्दति) हो जाता है।
        """.trimIndent(),
        english = """
            In this entire material world, there is absolutely nothing so sublime, purifying, and supremely pure as transcendental knowledge (Jnanena sadrisham pavitram).
            Such absolute knowledge is the mature fruit of all mysticism. And one who has achieved absolute perfection in unattached devotional yoga (Yoga-samsiddhah) enjoys this knowledge automatically within himself (Atmani vindati) in due course of time (Kalena).
            Lord Sri Krishna officially declares 'Transcendental Knowledge' (Jnana) to be the absolute greatest, most incredibly powerful 'Cosmic Detergent and Purifier' in the entire universe.
            Ignorant people desperately try to purify themselves by taking dips in freezing holy rivers, walking on brutal pilgrimages, or aggressively fasting. These rituals may temporarily scrub the physical body or superficial mind.
            But the Lord asserts that the incredibly thick, toxic grime of sins, lust, and massive ego accumulated over millions of lifetimes on the soul's consciousness cannot be washed away by any physical river or chemical soap.
            That invincible dirt can only be violently dissolved and burned away by the highly concentrated acid of 'Self-Knowledge' (realizing you are a pure spirit soul). There is simply no greater 'Purifier' in existence.
            Then the ultimate question arises: Where exactly do I purchase or find this knowledge?
            Sri Krishna profoundly answers that this supreme truth is absolutely not imported from the outside. When you continuously and flawlessly execute selfless action (Karma Yoga) over a prolonged period of time ('Kalena'), achieving absolute perfection ('Yoga-samsiddhah'), your mind becomes as impeccably clean as a polished mirror.
            And the very second the mind becomes completely pure, this staggering 'Supreme Knowledge' violently and automatically explodes directly from 'Within' your very own soul ('Atmani vindati'). True enlightenment is an internal explosion, not an external acquisition.
        """.trimIndent()
    ),
    Shloka(
        id = 39,
        sanskrit = """
            श्रद्धावाँल्लभते ज्ञानं तत्परः संयतेन्द्रियः |
            ज्ञानं लब्ध्वा परां शान्तिमचिरेणाधिगच्छति || ३९ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य अत्यंत श्रद्धावान (ईश्वर और गुरु के वचनों में पूरा विश्वास रखने वाला) है, जो इस ज्ञान को पाने के लिए पूरी तरह समर्पित (तत्परः) है, और जिसने अपनी इन्द्रियों को पूरी तरह वश में (संयतेन्द्रियः) कर लिया है...
            केवल वही व्यक्ति इस परम 'ज्ञान' को प्राप्त (लभते) करता है। और इस अलौकिक ज्ञान को प्राप्त करके वह बहुत ही जल्द (अचिरेण) परम शांति (भगवत्प्राप्ति) को प्राप्त हो जाता है।
            यह पूरी गीता का एक और बहुत बड़ा 'मास्टर-फॉर्मूला' (Master-Formula) है। यहाँ भगवान 'ज्ञान' प्राप्त करने की तीन सबसे जरूरी शर्तें (Eligibility Criteria) बता रहे हैं:
            १. 'श्रद्धावान्' (Faith): सबसे पहली और सबसे बड़ी शर्त है 'श्रद्धा'। अगर आप गूगल (Google) करते समय डाउट (Doubt) में हैं, तो आप ज्ञान नहीं पा सकते। गुरु और ईश्वर के शब्दों पर 100% अटल विश्वास होना चाहिए कि वे जो कह रहे हैं, वही सत्य है।
            २. 'तत्परः' (Dedicated/Focused): ज्ञान कोई ऐसी चीज़ नहीं जो पार्ट-टाइम (Part-time) हॉबी की तरह मिल जाए। इंसान को इस ज्ञान को पाने के लिए पागलों की तरह 100% कमिटेड (Committed) होना चाहिए।
            ३. 'संयतेन्द्रियः' (Sense-control): अगर इंसान का विश्वास पक्का है, लेकिन वह दिन भर मोबाइल देखता है, गलत खाना खाता है, या वासना में फँसा है (इन्द्रियां बेकाबू हैं), तो उसका दिमाग कभी उस ज्ञान को रोक (Retain) नहीं पाएगा। ज्ञान एक ऐसे मटके में टिकता है जिसमें इन्द्रियों रूपी कोई छेद (Hole) न हो।
            जो व्यक्ति इन तीन टेस्ट्स (Tests) को पास कर लेता है, उसे ज्ञान मिल जाता है। और ज्ञान मिलने के बाद क्या होता है?
            उसे 'परां शान्तिम्' (Supreme Peace) मिलती है—और वह भी 10 या 20 साल बाद नहीं, बल्कि 'अचिरेण' (Immediately / बहुत ही जल्द / तुरंत)! ज्ञान और परम शांति के बीच कोई टाइम-गैप (Time gap) नहीं है।
        """.trimIndent(),
        english = """
            A faithful man (Shraddhavan) who is supremely dedicated and absorbed in transcendental knowledge (Tat-parah), and who completely subdues and violently controls his physical senses (Samyatendriyah)...
            is uniquely eligible to achieve such supreme spiritual knowledge (Labhate jnanam). and having achieved it, he instantly and rapidly attains the supreme spiritual peace (Param shantim achirena).
            This is yet another universally famous, spectacular 'Master-Formula' of the entire Gita. The Lord is rigidly laying down the absolute three non-negotiable Eligibility Criteria required to download supreme enlightenment:
            1. 'Shraddhavan' (Absolute Faith): The absolute first and heaviest requirement is unflinching 'Faith'. If you approach spiritual science with a toxic, highly cynical, doubting mindset, you will achieve absolutely zero. You must possess 100% blind, titanium trust in the words of the Supreme Lord and the Guru.
            2. 'Tat-parah' (Extreme Dedication): God-realization is absolutely not a casual weekend hobby. A human being must be aggressively, intensely, and 100% ruthlessly committed and singularly focused on achieving this truth.
            3. 'Samyatendriyah' (Brutal Sense Control): Even if a person has massive faith, but he spends his entire day wildly chasing toxic internet content, junk food, and intense lust (uncontrolled senses), his brain will leak out all the knowledge instantly. Supreme knowledge can only be stored in a titanium vessel that has absolutely zero sensory leaks.
            Whoever flawlessly passes these three severe tests is instantly awarded Enlightenment. And what is the immediate result?
            He attains 'Param shantim' (The Absolute Supreme Peace)—and he absolutely does not have to wait 10 or 20 years for it; it happens 'Achirena' (Instantaneously / in a flash)! There is zero time-delay between true enlightenment and ultimate cosmic peace.
        """.trimIndent()
    ),
    Shloka(
        id = 40,
        sanskrit = """
            अज्ञश्चाश्रद्दधानश्च संशयात्मा विनश्यति |
            नायं लोकोऽस्ति न परो न सुखं संशयात्मनः || ४० ||
        """.trimIndent(),
        hindi = """
            परंतु जो मनुष्य पूरी तरह से अज्ञानी (मूर्ख/अज्ञः) है, जिसमें बिल्कुल भी श्रद्धा या विश्वास नहीं है (अश्रद्दधानः), और जिसका मन हमेशा शंका या डाउट (संशयात्मा) से भरा रहता है... ऐसे व्यक्ति का निश्चित रूप से घोर पतन (विनाश) हो जाता है।
            ऐसे हर बात पर शंका (Doubt) करने वाले संशयात्मा मनुष्य के लिए न तो यह लोक (संसार) सुखदायक है, न ही मरने के बाद परलोक (अगला जन्म) सुखदायक है, और न ही उसे कभी कोई मानसिक सुख मिल सकता है।
            अगर श्लोक 39 'सफलता' का फॉर्मूला था, तो यह श्लोक 'बर्बादी' (Ultimate Ruin) का सबसे खतरनाक ब्लूप्रिंट (Blueprint) है।
            श्रीकृष्ण एक बहुत ही भयानक बीमारी का ज़िक्र कर रहे हैं: 'संशयात्मा' (Overthinker / हमेशा डाउट करने वाला व्यक्ति)।
            भगवान कहते हैं कि अगर कोई अज्ञानी (Uneducated) है, तो उसे ज्ञान देकर सुधारा जा सकता है। अगर कोई अश्रद्धालु (Atheist) है, तो उसे चमत्कार दिखाकर विश्वास दिलाया जा सकता है।
            लेकिन जो 'संशयात्मा' है—यानी जो भगवान पर भी डाउट करता है, गुरु पर भी डाउट करता है, खुद पर भी डाउट करता है, और यहाँ तक कि अपनी पत्नी या दोस्तों पर भी हमेशा शक करता है—ऐसे इंसान का कोई इलाज नहीं है। उसका विनाश (विनश्यति) 100% तय है।
            भगवान एक बहुत ही कड़वी और प्रैक्टिकल (Practical) सच्चाई बताते हैं: जिस इंसान को किसी पर भरोसा नहीं है, उसे इस दुनिया ('अयं लोको') में भी कोई सुख नहीं मिलता (वह हमेशा शक की आग में डिप्रेशन में जलता है)।
            और चूँकि उसने कोई आध्यात्मिक काम भी नहीं किया (क्योंकि उसे भगवान पर डाउट था), इसलिए मरने के बाद उसका परलोक ('न परो') भी पूरी तरह बर्बाद हो जाता है।
            संदेह (Doubt) वह सबसे खतरनाक दीमक (Termite) है जो इंसान की दुनिया और अध्यात्म—दोनों को खोखला कर देती है।
        """.trimIndent(),
        english = """
            But those ignorant fools who possess absolutely no spiritual knowledge (Ajnah), who are entirely devoid of faith and completely faithless (Ashraddadhanah), and who are plagued by constant, toxic doubts (Samshayatma), are completely ruined and doomed to destruction (Vinashyati).
            For the perpetually doubting soul (Samshayatmanah), there is absolutely no happiness whatsoever, neither in this material world (Ayam lokah), nor in the next afterlife (Parah).
            If verse 39 was the absolute formula for 'Ultimate Success', this terrifying verse is the absolute blueprint for 'Guaranteed, Total Annihilation'.
            Sri Krishna is aggressively diagnosing the most fatal psychological cancer in human existence: 'Samshayatma' (The Chronic Overthinker / The Perpetually Doubting Mind).
            The Lord implies that if a person is simply uneducated (Ajnah), he can easily be taught. If a person is currently an atheist without faith (Ashraddadhanah), he can eventually be convinced by powerful logic or miracles.
            But the 'Samshayatma'—the intensely toxic person who aggressively doubts God, violently doubts his Guru, doubts his own abilities, and constantly suspects his own spouse and friends—is completely incurable. His absolute destruction (Vinashyati) is a 100% guarantee.
            The Lord drops a brutally harsh, immensely practical truth: A highly paranoid human who refuses to trust anyone can absolutely never find a single drop of happiness or peace in this current physical world ('Ayam Loko'), because his brain burns 24/7 in the toxic acid of suspicion and stress.
            And because his paralyzing doubts prevented him from executing any spiritual actions for God, his afterlife ('Na Paro') is also completely ruined and destined for hell.
            Doubt (Samshaya) is the absolute deadliest cosmic termite that silently, brutally hollows out and collapses both a human's material life and spiritual future.
        """.trimIndent()
    ),
    Shloka(
        id = 41,
        sanskrit = """
            योगसन्न्यस्तकर्माणं ज्ञानसञ्छिन्नसंशयम् |
            आत्मवन्तं न कर्माणि निबध्नन्ति धनञ्जय || ४१ ||
        """.trimIndent(),
        hindi = """
            हे धनञ्जय (अर्जुन)! जिसने निष्काम कर्मयोग के द्वारा अपने सारे कर्मों (और उनके फलों) को पूरी तरह से भगवान को अर्पण (संन्यास) कर दिया है...
            जिसने आत्मज्ञान (सच्चे ज्ञान) की तलवार से अपने मन के सारे संशयों (Doubts) को पूरी तरह काट डाला है (ज्ञानसञ्छिन्नसंशयम्)...
            ऐसे 'आत्मवान्' (जिसने अपनी आत्मा और मन को पूरी तरह जीत लिया है) महापुरुष को उसके द्वारा किए गए कोई भी भयंकर कर्म कभी भी बांध नहीं सकते (न निबध्नन्ति)।
            अध्याय 4 का समापन करते हुए, भगवान श्रीकृष्ण एक बार फिर से 'लिबरेटेड सुपरहीरो' (Liberated Superhero) की प्रोफाइल (Profile) का सारांश (Summary) दे रहे हैं।
            वे अर्जुन को याद दिला रहे हैं कि कर्मों के जंजाल से आज़ादी (मुक्ति) पाने के तीन सबसे पक्के स्टेप्स (Steps) क्या हैं:
            १. 'योगसन्न्यस्तकर्माणं': काम छोड़ना संन्यास नहीं है। तुम दुनिया के सबसे मुश्किल काम (जैसे युद्ध) करो, लेकिन उसके रिज़ल्ट (लाभ-हानि) का 'संन्यास' कर दो (यानी उसे ईश्वर के खाते में डाल दो)। यह पहला कवच (Armor) है।
            २. 'ज्ञानसञ्छिन्नसंशयम्': पिछले श्लोक में भगवान ने बताया था कि 'डाउट' (संशय) इंसान को मार देता है। इस डाउट को खत्म करने का एकमात्र हथियार है 'ज्ञान की तलवार' (Sword of Knowledge)। लॉजिक और गुरु के ज्ञान से अपने सारे शक काट डालो।
            ३. 'आत्मवन्तं': जो अपनी ही इन्द्रियों और मन का गुलाम है, वह कभी आज़ाद नहीं हो सकता। तुम्हें अपनी चेतना (Soul) का मास्टर बनना होगा।
            जब इंसान इन तीन हथियारों से लैस हो जाता है, तो वह युद्ध के मैदान में लाखों तीर चलाए या अरबों की कंपनी चलाए, दुनिया का कोई भी कर्म (पाप या पुण्य) उसे एक मिलीमीटर भी बांध (Bind) नहीं सकता। वह पूरी तरह बुलेटप्रूफ (Bulletproof / न निबध्नन्ति) हो जाता है।
        """.trimIndent(),
        english = """
            O Dhananjaya (Arjuna)! One who completely renounces the fruits of his actions by acting in pure devotional service (Yoga-sannyasta-karmanam)...
            and whose toxic doubts have been violently and completely slashed to pieces by transcendental knowledge (Jnana-sanchinna-samshayam)...
            such a perfectly self-realized master situated solidly in the self (Atmavantam) is absolutely never bound or entangled by any reactions of his work (Na karmani nibadhnanti).
            Rapidly concluding the majestic Fourth Chapter, Lord Sri Krishna provides the absolute, ultimate summary profile of the 'Liberated Spiritual Superhero'.
            He aggressively reminds Arjuna of the three absolute, iron-clad steps required to completely hack the matrix of Karma and achieve total immunity:
            1. 'Yoga-sannyasta-karmanam': Real Sannyasa (Renunciation) does NOT mean dropping your bow and running to a forest. It means flawlessly executing the most terrifying, heavy duties in the world (like a world war), but violently 'Renouncing' and outsourcing the result entirely to God's bank account. This is the first impenetrable Titanium Armor.
            2. 'Jnana-sanchinna-samshayam': In the previous verse, the Lord declared that toxic 'Doubt' ruins a man. The absolute only lethal weapon capable of slaughtering this demon of doubt is the blazing 'Sword of Knowledge'. You must aggressively slice all your confusions to pieces using sharp spiritual logic.
            3. 'Atmavantam': A pathetic slave to his own genitals, tongue, and mind can never be a master. You must completely conquer and lock down your internal operating system.
            When a human being is fully equipped with these three staggering weapons, he can fire millions of deadly arrows in a war or run a billion-dollar empire, and absolutely NO karmic reaction (sin or merit) can ever bind him even a millimeter. He becomes 100% Karmically Bulletproof (Na nibadhnanti).
        """.trimIndent()
    ),
    Shloka(
        id = 42,
        sanskrit = """
            तस्मादज्ञानसम्भूतं हृत्स्थं ज्ञानासिनात्मनः |
            छित्त्वैनं संशयं योगमातिष्ठोत्तिष्ठ भारत || ४२ ||
        """.trimIndent(),
        hindi = """
            इसलिए हे भारत (अर्जुन)! तुम्हारे हृदय में अज्ञान (मूर्खता) से पैदा हुए इस भयंकर संशय (Doubt/भ्रम) को...
            तुम अपने 'ज्ञान रूपी तीखी तलवार' (ज्ञानासिना) से पूरी तरह काट डालो (छित्त्वा)! और समत्व रूपी 'कर्मयोग' (निष्काम कर्म) में दृढ़ता से स्थित हो जाओ (योगमातिष्ठ), और युद्ध के लिए उठ खड़े हो (उत्तिष्ठ)!
            यह चौथे अध्याय (ज्ञान-कर्म-संन्यास योग) का अत्यंत ही शानदार, आक्रामक और रोंगटे खड़े कर देने वाला (Goosebumps) 'ग्रैंड फिनाले' (Grand Finale) श्लोक है!
            भगवान श्रीकृष्ण यहाँ किसी शांत उपदेशक की तरह नहीं, बल्कि एक सुप्रीम मिलिट्री कमांडर (Supreme Military Commander) की तरह अर्जुन को सीधा आदेश (Command) दे रहे हैं।
            वे कहते हैं कि अर्जुन, तुम्हारे अंदर जो "मैं युद्ध करूँ या न करूँ, मुझे पाप लगेगा" का कीड़ा (Doubt) रेंग रहा है, वह कोई महान दया या फिलॉसफी नहीं है। वह 'अज्ञानसम्भूतं' (विशुद्ध अज्ञान और मूर्खता से पैदा हुआ) एक भयंकर वायरस है जो तुम्हारे 'हृदय' (हृत्स्थं) में बैठ गया है।
            श्रीकृष्ण एक बहुत ही विज़ुअल (Visual) और हिंसक हथियार अर्जुन को देते हैं: 'ज्ञानासिना' (ज्ञान की तलवार)।
            "अर्जुन! रोना बंद करो! मैंने तुम्हें जो यह परम ज्ञान दिया है, इसकी धारदार तलवार उठाओ और अपने ही दिल में बैठे हुए इस 'संशय' (Doubt) रूपी राक्षस का बेरहमी से गला काट दो (छित्त्वा)!"
            और जैसे ही यह डाउट मरे, तुरंत 'योगमातिष्ठ' (अपने क्षत्रिय धर्म और कर्मयोग के अजेय कवच को पहन लो)।
            और फिर भगवान अपना अंतिम, गर्जना करता हुआ आदेश देते हैं: "उत्तिष्ठ भारत!" (हे महान भरतवंश के योद्धा! अपना गांडीव उठाओ और युद्ध के लिए खड़े हो जाओ!)।
            यहाँ यह महान अध्याय पूर्ण होता है।
        """.trimIndent(),
        english = """
            Therefore, O descendant of Bharata (Arjuna)! The toxic doubts which have arisen in your heart purely out of deep ignorance (Ajnana-sambhutam hrit-stham)...
            should be violently and completely slashed to pieces (Chittva) by the razor-sharp weapon of transcendental knowledge (Jnanashina). Arming yourself flawlessly in the discipline of yoga (Yogam atishtha), STAND UP AND FIGHT (Uttishtha)!
            This is the highly explosive, breathtaking, and absolute adrenaline-pumping 'Grand Finale' verse of the Fourth Chapter (Jnana-Karma-Sannyasa Yoga)!
            Lord Sri Krishna is absolutely no longer speaking like a soft, peaceful philosopher here; He is aggressively roaring like the Supreme, Undisputed Military Commander of the Universe, issuing an ultimate direct order.
            He brutally diagnoses Arjuna: This pathetic, crippling disease of "Should I fight or not? Will I incur sin?" crawling inside your brain is absolutely not some grand compassion or high philosophy. It is an 'Ajnana-sambhutam' (a highly toxic virus born entirely out of pure, unadulterated ignorance and stupidity) that has heavily infected your heart (Hrit-stham).
            Sri Krishna violently hands Arjuna an incredibly visual, lethal weapon: 'Jnanashina' (The blazing, razor-sharp Sword of Knowledge).
            "Arjuna! Stop your pathetic weeping instantly! Take this devastating Sword of Knowledge I have just given you, and ruthlessly, violently slash and behead (Chittva) this terrifying demon of 'Doubt' sitting right inside your own heart!"
            The exact millisecond that doubt is slaughtered, 'Yogam atishtha' (Instantly lock yourself into the impenetrable titanium armor of selfless Karma Yoga).
            And then, the Lord delivers His final, earth-shattering battle-cry command: "UTTISHTHA BHARATA!" (STAND UP, O GREAT WARRIOR, PICK UP YOUR BOW, AND FIGHT!).
            Thus spectacularly ends the Fourth Chapter of the Bhagavad Gita.
        """.trimIndent()
    )
)