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
fun AdhyayaEighteen() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaEighteenShlokas.indexOfFirst { it.id == shlokaNum }
            if (targetIndex != -1) {
                coroutineScope.launch {
                    listState.animateScrollToItem(targetIndex)
                }
                keyboardController?.hide()
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (1 - 25)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { performSearch() }),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump to Shloka")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            itemsIndexed(adhyayaEighteenShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaEighteenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            अर्जुन उवाच |
            संन्यासस्य महाबाहो तत्त्वमिच्छामि वेदितुम् |
            त्यागस्य च हृषीकेश पृथक्केशिनिषूदन || १ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने भगवान श्रीकृष्ण से संन्यास और त्याग के वास्तविक और गहरे अर्थ को अलग-अलग समझने की तीव्र इच्छा प्रकट की।
            उन्होंने महाबाहु और केशी दैत्य को मारने वाले शक्तिशाली नामों से भगवान को संबोधित करते हुए अपने मन के इस सबसे बड़े संशय को सामने रखा।
            अर्जुन यह जानना चाहते हैं कि क्या सभी कर्मों को छोड़ देना संन्यास है या केवल कर्मों के फल को छोड़ना सच्चा त्याग माना जाता है।
            यह अठारहवां अध्याय पूरी भगवद्गीता का सबसे लंबा और सबसे महत्वपूर्ण निष्कर्ष है जहाँ पिछले सभी सत्रह अध्यायों का भव्य निचोड़ दिया जाएगा।
            यह महान अध्याय इंसान के मन में उठने वाले सांसारिक भ्रम और कर्म के प्रति उसकी जिम्मेदारी को हमेशा के लिए पूरी तरह से स्पष्ट कर देता है।
            अर्जुन का यह प्रश्न हर उस साधक का प्रश्न है जो अध्यात्म की राह पर चलते हुए अपनी सामाजिक और पारिवारिक जिम्मेदारियों के बीच बुरी तरह फँस जाता है।
            वह समझ नहीं पाता कि ईश्वर को पाने के लिए उसे अपना घर छोड़कर जंगल जाना चाहिए या समाज में रहकर ही अपना कर्म और कर्तव्य निभाना चाहिए।
            भगवान से सीधा और अत्यंत सटीक मार्गदर्शन माँगकर अर्जुन मानव जाति के लिए मोक्ष और मुक्ति का सबसे प्रामाणिक और वैज्ञानिक रास्ता तैयार करवा रहे हैं।
            इस अंतिम संवाद में अर्जुन की स्थिति एक पूरी तरह से समर्पित और जिज्ञासु शिष्य की है जो अपने गुरु से ब्रह्मांड का सबसे बड़ा रहस्य सुनना चाहता है।
            कृष्ण अब इस महाज्ञान के अंतिम चरण में संन्यास और त्याग के उस गहरे मनोवैज्ञानिक अंतर को पूरी तरह डिकोड करेंगे जो आत्मा को आज़ाद करता है।
        """.trimIndent(),
        english = """
            Arjuna intensely inquired from Lord Sri Krishna desiring to completely understand the profound authentic reality and strict distinction between renunciation (Sannyasa) and detachment (Tyaga).
            He addressed the Supreme Lord with powerful titles like Mighty-armed and Slayer of the Keshi demon respectfully placing his ultimate final cosmic doubt before Him.
            Arjuna urgently wants to mathematically decode whether true spiritual perfection demands abandoning all physical activities entirely or merely relinquishing the psychological attachment to their results.
            This spectacular eighteenth chapter serves as the absolute longest and most critical grand conclusion of the entire Bhagavad Gita summarizing all previous philosophical data.
            This majestic chapter permanently and violently eradicates the dense psychological illusion plaguing humanity perfectly clarifying a mortal's absolute mandatory duty within the material matrix.
            Arjuna's profound question mirrors the exact paralyzing dilemma of every elite seeker who feels hopelessly trapped between advancing spiritually and executing his heavy social responsibilities.
            Mankind constantly suffers extreme confusion over whether attaining Godhead strictly requires escaping into a remote jungle or courageously executing corporate and family duties from within society.
            By demanding absolute crystal-clear guidance directly from the Supreme Creator Arjuna is aggressively paving the most authentic scientific and foolproof highway to eternal liberation for humanity.
            In this ultimate final dialogue Arjuna perfectly embodies the flawlessly surrendered disciple aggressively absorbing the multiverse's greatest highly classified secrets from his omniscient Master.
            Lord Krishna will now flawlessly decode the extremely subtle psychological architecture of renunciation delivering the absolute final hack required to permanently liberate the human soul.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            श्रीभगवानुवाच |
            काम्यानां कर्मणां न्यासं संन्यासं कवयो विदुः |
            सर्वकर्मफलत्यागं प्राहुस्त्यागं विचक्षणाः || २ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने उत्तर देते हुए कहा कि जो कर्म भौतिक इच्छाओं और वासनाओं से प्रेरित होकर किए जाते हैं उनका पूरी तरह त्याग कर देना ही विद्वान लोग संन्यास कहते हैं।
            और जो इंसान अपने सभी प्रकार के सांसारिक और धार्मिक कर्मों के मिलने वाले फलों (रिज़ल्ट्स) का मोह पूरी तरह छोड़ देता है उसे महान ज्ञानी लोग सच्चा त्याग कहते हैं।
            भगवान यहाँ बहुत ही स्पष्ट रूप से एक भ्रम को तोड़ रहे हैं कि संन्यास का मतलब कपड़े बदलकर पहाड़ पर बैठना और काम बंद कर देना बिल्कुल नहीं है।
            सच्चा संन्यास यह है कि आप उन कामों को अपनी ज़िंदगी से पूरी तरह डिलीट कर दें जिनका मकसद केवल अपनी लालची और स्वार्थी इच्छाओं को पूरा करना है।
            और सच्चा त्याग यह है कि आप समाज के लिए और भगवान के लिए खूब मेहनत से काम करें लेकिन उस काम से मिलने वाले अवार्ड या पैसे से बिल्कुल भी न चिपकें।
            एक संन्यासी केवल गलत और स्वार्थी कामों को रोकता है जबकि एक त्यागी व्यक्ति अच्छे कामों को भी बिना किसी अहंकार और लालच के 100% डिटैचमेंट के साथ करता है।
            भगवान इंसान के उस आलसी दिमाग को चेतावनी दे रहे हैं जो काम से बचने के लिए अध्यात्म और संन्यास का झूठा बहाना बनाता है।
            कर्मों से भागना आज़ादी नहीं है बल्कि कर्म करते हुए भी उसके फलों की चिंता से खुद को पूरी तरह आज़ाद कर लेना ही सबसे बड़ी मानसिक आज़ादी है।
            यही वह मनोवैज्ञानिक हैक है जो इंसान को इस 3D मैट्रिक्स में रहते हुए भी कर्मों के भयंकर कर्म-बंधन और पापों से पूरी तरह सुरक्षित रखता है।
            यह श्लोक 'एक्शन विदाउट एक्सपेक्टेशन' (Action without expectation) की उस अजेय फिलॉसफी को स्थापित करता है जो योग का सबसे पहला और आखिरी नियम है।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead answered declaring that the complete abandonment of activities driven entirely by material desire is officially what great learned men call the renounced order of life (Sannyasa).
            And the elite brilliantly wise sages officially define true detachment (Tyaga) as the absolute relentless surrender of the material results and fruits of all physical and religious activities.
            The Lord is violently shattering the toxic global illusion that true renunciation means cowardly abandoning your daily responsibilities changing your clothes and hiding lazily on a mountain.
            Authentic Sannyasa mathematically demands that you permanently and ruthlessly delete absolutely all activities from your timeline whose sole objective is satisfying your greedy selfish biological lust.
            And genuine Tyaga requires you to execute your social and cosmic duties with brutal high-speed intensity while operating with 100% absolute psychological detachment from the resulting profits or applause.
            A Sannyasi successfully terminates all toxic selfish actions while a Tyagi successfully performs incredibly noble actions without a microscopic drop of arrogance or expectation.
            The Lord is aggressively issuing a strict warning to the pathetic lazy human brain that constantly attempts to use fake spirituality as a cheap excuse to escape hard work.
            Running away from biological action is absolutely not freedom; operating flawlessly within the chaotic matrix while remaining totally immune to anxiety over the results is absolute supreme freedom.
            This specific psychological hack provides an impenetrable titanium shield permanently protecting the human from accumulating heavy karmic debt and severe sin while living in this 3D dimension.
            This spectacular verse firmly establishes the invincible supreme philosophy of 'Action without Expectation' which remains the absolute first and final law of cosmic yoga.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            त्याज्यं दोषवदित्येके कर्म प्राहुर्मनीषिणः |
            यज्ञदानतपःकर्म न त्याज्यमिति चापरे || ३ ||
        """.trimIndent(),
        hindi = """
            कुछ महान विद्वान और दार्शनिक ऐसा मानते हैं कि दुनिया का हर प्रकार का कर्म दोषों से भरा होता है इसलिए सभी कर्मों को पूरी तरह से छोड़ देना चाहिए।
            परंतु कुछ अन्य ज्ञानी महापुरुषों का यह बहुत ही दृढ़ मत है कि यज्ञ दान और तपस्या रूपी अत्यंत पवित्र कर्मों का कभी भी किसी भी हालत में त्याग नहीं करना चाहिए।
            भगवान यहाँ प्राचीन समय के अलग-अलग दार्शनिक विचारों (Philosophies) की उस बड़ी बहस (Debate) को अर्जुन के सामने बहुत ही निष्पक्ष रूप से रख रहे हैं।
            सांख्य योग को मानने वाले कुछ लोग सोचते हैं कि क्योंकि हर काम में जाने-अनजाने कोई न कोई हिंसा या पाप शामिल होता है इसलिए बिल्कुल शांत होकर बैठ जाना ही सबसे अच्छा है।
            उनके अनुसार आग जलाने में भी कीड़े मरते हैं और खेती करने में भी जीव मरते हैं इसलिए कर्म ही इंसान के सारे दुखों और जन्म-मरण की असली वजह है।
            लेकिन कर्म योग को मानने वाले और वेदों के दूसरे विद्वान इस बात का भयंकर विरोध करते हैं और कहते हैं कि ऐसा करना इंसान की आत्मा को आलसी और मूर्ख बना देगा।
            वे कहते हैं कि चाहे कितनी भी परेशानी हो इंसान को समाज की भलाई के लिए दान ईश्वर की पूजा के लिए यज्ञ और खुद को सुधारने के लिए तपस्या कभी नहीं छोड़नी चाहिए।
            ये दोनों ही विचार अपने-अपने लॉजिक (Logic) से बहुत सही लगते हैं जिससे एक आम इंसान और अर्जुन जैसे योद्धा का दिमाग पूरी तरह से कंफ्यूज (Confuse) हो सकता है।
            यह श्लोक अर्जुन के मन में उठने वाले उस मानसिक तूफ़ान को शांत करने से पहले एक बहुत बड़ा दार्शनिक ग्राउंड (Ground) तैयार कर रहा है जहाँ भगवान अपना असली फैसला सुनाएंगे।
            ईश्वर अब अगले श्लोक में एक सुप्रीम जज (Supreme Judge) की तरह इस बहस को हमेशा के लिए खत्म करते हुए अपना अंतिम और अचूक ब्रह्मांडीय फैसला पूरी दुनिया को देंगे।
        """.trimIndent(),
        english = """
            Certain highly elevated scholars and philosophers aggressively declare that absolutely all kinds of fruitive activities are inherently faulty and toxic and therefore must be completely given up.
            Yet other incredibly wise authorities maintain a titanium conviction asserting that the supremely purifying acts of sacrifice charity and penance must absolutely never be abandoned under any circumstances.
            The Lord is objectively presenting the massive ancient philosophical debate existing between different schools of elite cosmic thought directly to Arjuna's highly analytical brain.
            Certain extreme philosophers argue that because absolutely every physical action mathematically involves some microscopic level of unavoidable violence or sin total cessation of activity is the only pure path.
            According to their logic even lighting a fire kills microbes and farming slaughters insects proving that action itself is the fundamental toxic root of all karmic bondage and rebirth.
            However opposing Vedic authorities violently reject this paralyzing theory arguing that completely stopping all action will tragically mutate a human into a pathetic lazy and degraded entity.
            They fiercely advocate that despite any inherent flaws a human must relentlessly execute massive charity for society sacrifices for the Supreme and brutal austerities for self-purification.
            Both massive philosophical models present incredibly convincing highly rational logic which easily successfully paralyzes the mind of a common mortal or an elite warrior like Arjuna.
            This spectacular verse establishes the absolute foundational ground for this massive psychological conflict heavily preparing the stage before the Supreme Lord delivers His own undisputed verdict.
            Operating exactly like the Ultimate Cosmic Judge the Supreme Creator will instantly resolve this fierce global debate in the upcoming verse by officially broadcasting His absolute final decree.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            निश्चयं शृणु मे तत्र त्यागे भरतसत्तम |
            त्यागो हि पुरुषव्याघ्र त्रिविधः सम्प्रकीर्तितः || ४ ||
        """.trimIndent(),
        hindi = """
            हे भरतवंशियों में श्रेष्ठ अर्जुन! अब तुम इस महान त्याग के विषय में मेरे सबसे पक्के और अंतिम निर्णय (निश्चय) को पूरे ध्यान और एकाग्रता के साथ सुनो।
            हे पुरुषव्याघ्र (पुरुषों में बाघ के समान)! इस शास्त्रों और वेदों के विज्ञान में त्याग को मुख्य रूप से तीन प्रकार का ही बताया और घोषित किया गया है।
            भगवान श्रीकृष्ण यहाँ सभी दार्शनिक बहसों और उलझनों को एक ही झटके में पूरी तरह से समाप्त करने के लिए अपनी 'सुप्रीम अथॉरिटी' (Supreme Authority) का इस्तेमाल करते हैं।
            जब दुनिया के बड़े-बड़े ज्ञानी और शास्त्र किसी बात पर एक राय नहीं बना पाते तो साक्षात् परमेश्वर का फैसला ही इंसान के लिए सबसे बड़ा और अंतिम कानून (Law) बन जाता है।
            भगवान कहते हैं कि मैं तुम्हें कोई भ्रमित करने वाली फिलॉसफी नहीं दूँगा बल्कि मैं तुम्हें 'द आर्ट ऑफ गिविंग अप' (The Art of Giving Up) का एकदम सटीक विज्ञान समझाऊँगा।
            दुनिया में त्याग कोई एक जैसा या सिंगल मॉडल (Single Model) नहीं है बल्कि इंसान की नीयत और उसके मनोवैज्ञानिक स्तर के आधार पर यह तीन प्रकार (सत्त्व, रजस, तमस) का होता है।
            जिस तरह खाना और श्रद्धा तीन प्रकार के होते हैं उसी तरह इंसान के किसी चीज़ को छोड़ने की वजह और उसका तरीका भी उसके अंदर के गुणों पर निर्भर करता है।
            भगवान अर्जुन को 'पुरुषव्याघ्र' कहकर बुलाते हैं जिसका मतलब है कि सत्य को समझने और उसे अपनाने के लिए इंसान के अंदर एक बाघ (Tiger) जैसी भयंकर मानसिक ताकत और हिम्मत होनी चाहिए।
            यह श्लोक अर्जुन के दिमाग को एक बहुत ही हाई-लेवल डेटा (High-level data) डाउनलोड करने के लिए पूरी तरह से अलर्ट और तैयार करने का काम कर रहा है।
            यहाँ से भगवान अपने उस ऐतिहासिक फैसले की घोषणा शुरू करते हैं जो इंसान को सही कर्म करने और गलत आदतों को छोड़ने का सबसे परफेक्ट और साइंटिफिक तरीका सिखाता है।
        """.trimIndent(),
        english = """
            O absolute best of the Bharatas Arjuna! Now please listen with complete unshakeable focus to My final absolute mathematical judgment regarding the profound matter of renunciation.
            O tiger among men! The highly classified authorized Vedic science officially declares and definitively categorizes the act of renunciation strictly into three highly distinct types.
            Lord Sri Krishna utilizes His absolute undisputed 'Supreme Authority' here to violently execute and permanently terminate all confusing philosophical debates and intellectual chaos in one single stroke.
            When the multiverse's greatest elite scholars and philosophers tragically fail to reach a unanimous consensus the direct decree of the Supreme Creator becomes the absolute ultimate cosmic Law.
            The Lord assures Arjuna that He will absolutely not deliver vague useless philosophy but will instead download the precise flawless scientific architecture detailing 'The Art of Giving Up'.
            Cosmic renunciation is absolutely not a generic single template; it dynamically mathematically splits into three exact categories (Sattva Rajas Tamas) strictly based on human psychology and intention.
            Just as human food and faith strictly operate in three modes the precise methodology and hidden agenda behind a human renouncing an object heavily depend entirely on his internal biological software.
            The Lord aggressively addresses Arjuna as a 'Tiger among men' emphasizing that digesting and executing this brutal ultimate truth requires the terrifying mental horsepower and sheer bravery of an apex predator.
            This spectacular verse effectively serves as a massive psychological alarm forcefully preparing Arjuna's cognitive bandwidth to receive an immensely high-level heavily classified data download.
            From this exact microsecond the Supreme Lord initiates His historic absolute verdict actively teaching humanity the flawless scientific mechanism to execute duties while successfully hacking material attachment.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            यज्ञदानतपःकर्म न त्याज्यं कार्यमेव तत् |
            यज्ञो दानं तपश्चैव पावनानि मनीषिणाम् || ५ ||
        """.trimIndent(),
        hindi = """
            यज्ञ, दान और तपस्या रूपी इन अत्यंत पवित्र कर्मों का मनुष्य को अपने जीवन में कभी भी और किसी भी हालत में त्याग या परित्याग बिल्कुल नहीं करना चाहिए।
            बल्कि ये सभी कर्म तो इंसान का परम कर्तव्य हैं और इन्हें हर स्थिति में पूरे अनुशासन और श्रद्धा के साथ निरंतर किया ही जाना चाहिए।
            क्योंकि यज्ञ करना, दान देना और कठोर तपस्या करना ये तीनों ही काम बड़े-बड़े ज्ञानियों और महात्माओं के मन और आत्मा को भी पूरी तरह शुद्ध और पवित्र कर देते हैं।
            यह श्लोक भगवान श्रीकृष्ण का वह अंतिम और सबसे बड़ा फैसला है जो कर्म छोड़ने की बात करने वाले सभी फर्जी दार्शनिकों के अहंकार को जड़ से मिटा देता है।
            भगवान एक बहुत ही कड़ा नियम (Strict Law) बनाते हैं कि दुनिया के किसी भी इंसान को समाज और ईश्वर के प्रति अपनी ड्यूटी से भागने की कोई आज़ादी नहीं है।
            यज्ञ का मतलब केवल आग में आहुति देना नहीं है बल्कि इसका मतलब है कोई भी ऐसा बड़ा काम करना जो अपने स्वार्थ से ऊपर उठकर पूरी दुनिया की भलाई के लिए हो।
            दान इंसान के अहंकार और पैसों की लालच को मारता है और तपस्या इंसान के शरीर और दिमाग के कचरे को जलाकर उसे एक डायमंड (Diamond) की तरह चमका देती है।
            भगवान कहते हैं कि ये तीन काम कोई साधारण काम नहीं हैं बल्कि ये इंसान के भीतर जमे हुए जन्मों-जन्मों के पापों को धोने वाले सबसे बड़े और शक्तिशाली आध्यात्मिक 'डिटर्जेंट' (Detergent) हैं।
            जब बड़े-बड़े मुनि और योगी भी अपनी चेतना को अपडेट (Upgrade) करने के लिए इन कामों को नहीं छोड़ते तो एक साधारण इंसान को इन्हें छोड़ने का कोई हक नहीं है।
            इसलिए सन्यास का मतलब अच्छे कामों से संन्यास लेना बिल्कुल नहीं है बल्कि अच्छे कामों को और भी ज्यादा ताकत और बिना किसी फल की इच्छा के साथ लगातार करते रहना है।
        """.trimIndent(),
        english = """
            The supremely purifying acts of sacrifice massive charity and rigorous penance must absolutely never be abandoned or given up by any human under any cosmic circumstances.
            Rather these heavily authorized sacred activities are the fundamental absolute duties of human existence and they simply must be relentlessly executed with supreme discipline.
            Because performing sacrifices distributing selfless charity and undergoing brutal austerities aggressively and flawlessly purify even the most elite highly elevated great souls and sages.
            This spectacular verse represents Lord Krishna's absolute supreme final verdict completely incinerating the toxic arrogant arguments of fake philosophers who cowardice advocate abandoning all physical action.
            The Supreme Creator establishes an uncompromising titanium Law dictating that absolutely no entity in the matrix possesses the cosmic clearance to lazily escape their mandated duties toward society and God.
            Sacrifice absolutely does not merely mean tossing butter into a fire; it signifies executing massively powerful unselfish endeavors explicitly engineered to elevate and protect the entire global ecosystem.
            Charity violently assassinates a human's toxic financial greed while severe physical austerity brutally incinerates the biological garbage residing in the brain polishing the soul into a flawless diamond.
            The Lord explicitly declares that these three specific actions are absolutely not ordinary chores; they are the multiverse's most terrifyingly powerful spiritual 'Detergents' clinically engineered to wash away lifetimes of accumulated sin.
            If the absolute greatest enlightened sages mathematically require the continuous execution of these activities to upgrade their own consciousness an ordinary mortal possesses absolutely zero right to lazily abandon them.
            Therefore authentic renunciation absolutely never means cowardly abandoning noble work; it mandates aggressively executing these supreme duties with explosive intensity completely devoid of any cheap expectation for rewards.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            एतान्यपि तु कर्माणि सङ्गं त्यक्त्वा फलानि च |
            कर्तव्यानीति मे पार्थ निश्चितं मतमुत्तमम् || ६ ||
        """.trimIndent(),
        hindi = """
            परंतु हे पार्थ! इन यज्ञ, दान और तपस्या जैसे अत्यंत श्रेष्ठ और पवित्र कर्मों को भी पूरी तरह से आसक्ति (अटैचमेंट) और इनके फलों की लालसा को त्याग कर ही करना चाहिए।
            यानी इंसान को यह कभी नहीं सोचना चाहिए कि इन अच्छे कामों को करने के बदले उसे दुनिया में कोई महान पद मिलेगा या वह स्वर्ग का अधिकारी बन जाएगा।
            यह बिना किसी लालच के कर्म करने का सिद्धांत ही वास्तव में मेरा सबसे पक्का, अंतिम और सर्वश्रेष्ठ (उत्तम) मत या फैसला है।
            भगवान यहाँ एक बहुत ही बारीक लेकिन सबसे महत्वपूर्ण 'चेतावनी' (Disclaimer) दे रहे हैं जिसे मिस करने पर अच्छे से अच्छा काम भी पाप बन सकता है।
            लोग सोचते हैं कि अगर हम दान दे रहे हैं या गरीबों की मदद कर रहे हैं तो हम दुनिया के सबसे अच्छे इंसान हैं और भगवान को हमें इनाम देना ही पड़ेगा।
            लेकिन भगवान कहते हैं कि अगर तुमने दान देने के बाद अंदर ही अंदर उस दान के बदले कोई 'फेवर' (Favor) या तारीफ की उम्मीद रख ली, तो तुम्हारा वह दान पूरी तरह से ज़ीरो (Zero) हो गया!
            तुम्हारे किसी भी काम में 'सङ्गं' (अटैचमेंट) नहीं होना चाहिए; तुम्हें यह काम केवल इसलिए करना है क्योंकि यह तुम्हारा एक इंसान के रूप में 'कर्तव्य' (Duty) है, कोई बिज़नेस नहीं है।
            जब इंसान अपने सारे महान कर्मों के फल को भगवान के चरणों में बिना किसी शर्त के रख देता है, तभी वह कर्म उसे मोक्ष की सबसे ऊँची मंज़िल तक ले जाता है।
            भगवान का यह 'निश्चितं मतमुत्तमम्' (The Ultimate and Best Conclusion) इंसान के अहंकार को कुचलने का सबसे बड़ा और सबसे पावरफुल मनोवैज्ञानिक हथियार है।
            यही वह असली और सात्त्विक संन्यास है जहाँ इंसान दुनिया के बीच रहकर और सारे काम करते हुए भी मन से पूरी तरह आज़ाद और डिटैच (Detached) रहता है।
        """.trimIndent(),
        english = """
            But O son of Pritha even these highly elevated and supremely purifying activities must be executed entirely without any toxic material attachment or any pathetic craving for their fruitive results.
            A human must absolutely never aggressively hallucinate that executing these noble deeds will automatically entitle him to massive worldly prestige or guarantee him a permanent VIP ticket to heaven.
            This strict doctrine of executing flawless duty utterly devoid of any selfish expectation is officially and definitively My absolute final unshakeable and supreme ultimate judgment.
            The Lord is dropping an incredibly subtle yet mathematically critical cosmic 'Disclaimer' here warning that missing this exact psychological nuance instantly mutates even the most glorious action into toxic karma.
            Ignorant mortals arrogantly assume that distributing massive charity or feeding the starving automatically transforms them into supreme saviors legally forcing God to instantly reward them with massive wealth.
            But the Supreme Creator violently shatters this illusion stating that if you secretly harbor even a microscopic expectation for a return 'Favor' or public applause your entire massive charity mathematically equals absolute Zero!
            There must be absolutely zero 'Sangam' (Toxic Attachment) contaminating your actions; you must execute this greatness strictly because it is your mandatory biological and spiritual duty not a cheap commercial transaction.
            Only when a human effortlessly and unconditionally drops the entire massive result of his glorious actions directly at the lotus feet of the Lord does that specific karma securely launch him toward eternal Moksha.
            This absolute "Nishchitam matam uttamam" (The Flawless Ultimate Conclusion) functions as the universe's most terrifyingly powerful psychological weapon explicitly engineered to completely assassinate the bloated human false ego.
            This represents the absolute peak of authentic Sattvic renunciation where a master operates flawlessly deep within the chaotic matrix aggressively executing his duties while remaining mentally 100% immune and completely detached.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            नियतस्य तु संन्यासः कर्मणो नोपपद्यते |
            मोहात्तस्य परित्यागस्तामसः परिकीर्तितः || ७ ||
        """.trimIndent(),
        hindi = """
            मनुष्य को अपने नियत कर्मों का यानी शास्त्रों द्वारा सौंपे गए ज़रूरी और अनिवार्य कर्तव्यों का कभी भी किसी भी हालत में त्याग नहीं करना चाहिए।
            जो व्यक्ति अज्ञानता और मोह (भ्रम) के कारण अपने उन ज़रूरी और पवित्र कर्तव्यों को करने से पूरी तरह मुँह मोड़ लेता है और उन्हें छोड़ देता है।
            उसके इस प्रकार के झूठे और बेवकूफी भरे त्याग को ही शास्त्रों में पूरी तरह से 'तामसिक त्याग' (अंधकार और मूर्खता का त्याग) कहकर घोषित किया गया है।
            भगवान यहाँ उन ढोंगियों और आलसी लोगों की पूरी तरह से क्लास (Class) ले रहे हैं जो मेहनत से बचने के लिए 'संन्यास' का नाम इस्तेमाल करते हैं।
            दुनिया में ऐसे बहुत से लोग हैं जो अपनी पारिवारिक ज़िम्मेदारियों से, अपने बच्चों से और अपने काम से भागकर खुद को एक बहुत बड़ा साधु मान लेते हैं।
            लेकिन भगवान कहते हैं कि तुम भगवान का नाम लेकर अपने उन कर्मों को नहीं छोड़ सकते जो ब्रह्मांड के सिस्टम ने तुम्हें 'नियत' (Assign) किए हैं।
            अगर कोई सैनिक युद्ध के मैदान से या कोई पिता अपने परिवार से अज्ञानता (मोह) के कारण भागता है, तो वह कोई महान त्यागी नहीं बल्कि एक बहुत बड़ा भगोड़ा और मूर्ख है।
            ऐसा तामसिक त्याग इंसान को कभी भी भगवान तक नहीं ले जाता बल्कि यह उसे बहुत बड़े पाप और पतन की तरफ सीधे नीचे धकेल देता है।
            ईश्वर यह साफ कर रहे हैं कि अपने 'ड्यूटी' (Duty) को मारना कभी भी अध्यात्म नहीं हो सकता; अध्यात्म तो उस ड्यूटी को और भी ज्यादा परफेक्शन (Perfection) से करने का नाम है।
            जो व्यक्ति इस प्रकार का तामसिक सन्यास लेता है उसका जीवन पूरी तरह से एक कचरा बन जाता है क्योंकि वह न तो दुनिया का रहता है और न ही भगवान का।
        """.trimIndent(),
        english = """
            Prescribed duties and explicitly mandatory responsibilities assigned strictly by the authorized cosmic scriptures must absolutely never under any circumstances be abandoned or renounced.
            If a highly deluded human being cowardly runs away and completely gives up his mandatory prescribed duties entirely out of deep ignorance and blinding psychological illusion.
            Such a pathetic cowardly and totally fake renunciation is officially mathematically classified and universally condemned by sages as renunciation strictly in the darkest mode of ignorance (Tamasic Tyaga).
            The Lord is violently exposing and aggressively dismantling the pathetic excuses of hypocrites and lazy cowards who shamelessly hijack the sacred title of 'Sannyasa' merely to escape executing hard physical labor.
            There are millions of toxic entities globally who ruthlessly abandon their innocent starving children their families and their corporate duties arrogantly hallucinating that they have instantly transformed into elite holy saints.
            But the Supreme Boss explicitly decrees that you absolutely cannot illegally invoke God's name to justify cowardly abandoning the exact specific duties that the universal operating system has officially 'Assigned' to your biological profile.
            If an armed soldier deserts the battlefield or a father abandons his family entirely out of toxic delusion (Moha) he is absolutely not an elite renouncer; he is officially a pathetic degraded fugitive and a complete fool.
            This highly toxic Tamasic renunciation absolutely never elevates the human consciousness toward the Divine; it operates exactly like an anchor violently dragging the soul down into the deepest abyss of cosmic sin and degradation.
            The Supreme Creator mathematically clarifies that brutally assassinating your own assigned 'Duty' can absolutely never be labeled as authentic spirituality; genuine spirituality is executing that exact duty with 100% flawless titanium perfection.
            A human executing this pathetic Tamasic Sannyasa completely trashes his own existence mutating into a useless cosmic biological anomaly rejected entirely by both the material society and the spiritual kingdom.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            दुःखमित्येव यत्कर्म कायक्लेशभयात्त्यजेत् |
            स कृत्वा राजसं त्यागं नैव त्यागफलं लभेत् || ८ ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति केवल इस सोच और डर के कारण अपने ज़रूरी काम को छोड़ देता है कि वह काम बहुत दुःख देने वाला है और उसे करने में बहुत मेहनत लगेगी।
            या जो इंसान शारीरिक कष्ट (कायक्लेश) और परेशानी के भयंकर डर से अपने कर्तव्यों से भाग जाता है और अपनी ज़िम्मेदारी पूरी नहीं करता।
            इस प्रकार का स्वार्थी और डरपोक त्याग 'राजसिक त्याग' कहलाता है और ऐसा इंसान कभी भी सच्चे त्याग के महान फल या मोक्ष को बिल्कुल प्राप्त नहीं कर पाता।
            यह श्लोक उन लोगों की 'साइकोलॉजी' (Psychology) का सटीक एक्स-रे करता है जो हमेशा अपने 'कम्फर्ट ज़ोन' (Comfort Zone) में रहना पसंद करते हैं और मुश्किलों से भागते हैं।
            बहुत से लोग कोई बड़ा गोल (Goal) या मुश्किल काम इसलिए शुरू ही नहीं करते क्योंकि उन्हें लगता है कि उसमें बहुत पसीना बहेगा, नींद खराब होगी और बॉडी को बहुत स्ट्रेस (Stress) मिलेगा।
            वे खुद को यह झूठी तसल्ली देते हैं कि "मैंने उस चीज़ का त्याग कर दिया है क्योंकि मुझे वो सब मोह-माया नहीं चाहिए," लेकिन असल में वे सिर्फ उस काम की मेहनत से डरे हुए होते हैं।
            भगवान कहते हैं कि यह कोई संन्यास नहीं है, यह केवल तुम्हारी शारीरिक कमज़ोरी और तुम्हारे आलसी दिमाग का एक बहुत बड़ा धोखा (Fraud) है!
            राजसिक त्याग करने वाला इंसान कभी भी अपने डर पर जीत हासिल नहीं कर पाता और उसका दिमाग हमेशा एक कमज़ोर लूज़र (Loser) की तरह ही काम करता है।
            ऐसे इंसान को कभी भी आत्म-शांति या वो असली 'त्याग का फल' (The true fruit of renunciation) नसीब नहीं होता जो एक योद्धा या सच्चे योगी को मिलता है।
            सच्चा त्याग वो है जहाँ आप दर्द और पसीने को सहकर काम करते हैं, लेकिन उस काम के रिज़ल्ट का लालच नहीं करते; डर कर भागना त्याग नहीं, भगोड़ापन है।
        """.trimIndent(),
        english = """
            Anyone who cowardly abandons his prescribed biological and cosmic duties solely because he perceives them to be overwhelmingly troublesome and causing massive distress.
            Or the human who pathetically runs away from executing his mandatory responsibilities strictly out of a terrifying paralyzing fear of inflicting physical pain discomfort and heavy exhaustion upon his own biological body (Kaya-klesha).
            Such a highly selfish fear-driven surrender is officially designated as renunciation strictly in the mode of passion (Rajasic Tyaga) and this weak entity mathematically absolutely never obtains the supreme elevated result of true renunciation.
            This spectacular verse executes a flawless psychological X-Ray deeply exposing the pathetic mindset of modern humans who are hopelessly addicted to their soft 'Comfort Zones' and who violently flee from any form of grueling adversity.
            Millions of mortals deliberately avoid aggressively pursuing massive life goals or brutal spiritual disciplines simply because they are terrified of sweating blood enduring sleep deprivation and subjecting their biological machine to intense stress.
            They pathetically attempt to mentally gaslight themselves into believing "I have spiritually renounced that massive objective because I am above such material illusions" when in brutal reality they are merely terrified cowards running from hard work.
            The Supreme Lord declares that this is absolutely not elite Sannyasa; it is literally nothing but a massive toxic psychological 'Fraud' manufactured entirely by your physical weakness and highly corrupted lazy brain!
            A human executing this pathetic Rajasic renunciation mathematically never conquers his own internal biological fears and his mental software permanently downgrades to operate exactly like a terrified chronic 'Loser'.
            Such a coward is eternally denied the privilege of tasting absolute inner peace or accessing the 'True Fruit of Renunciation' which is exclusively reserved for the titanium-minded warriors and elite cosmic yogis.
            Authentic renunciation demands aggressively executing the brutal task enduring the blood and sweat while mathematically detaching from the final payout; fleeing in terror from physical pain is absolutely not detachment it is sheer cowardice.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            कार्यमित्येव यत्कर्म नियतं क्रियतेऽर्जुन |
            सङ्गं त्यक्त्वा फलं चैव स त्यागः सात्त्विको मतः || ९ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! जो इंसान केवल इस अटल और शुद्ध विचार के साथ अपना काम करता है कि "यह काम करना मेरा परम कर्तव्य (कार्यम्) है और मुझे इसे हर हाल में करना ही चाहिए।"
            और वह अपने उस ज़रूरी और नियत कर्म को करते समय उस काम की आसक्ति (Attachment) और भविष्य में मिलने वाले उसके फल (Result) को पूरी तरह से त्याग देता है।
            उसी महान और बिना किसी स्वार्थ के किए गए कर्म के परित्याग को ही शास्त्रों में सबसे श्रेष्ठ और 'सात्त्विक त्याग' (Sattvic Tyaga) माना गया है।
            भगवान श्रीकृष्ण यहाँ असली और सबसे ऊँचे दर्जे के 'संन्यास' (Renunciation) का दुनिया का सबसे परफेक्ट और अचूक फॉर्मूला (Formula) बता रहे हैं।
            सात्त्विक इंसान की सोच (Mindset) एकदम शीशे की तरह साफ होती है; वह समाज, परिवार या ईश्वर के लिए खूब मेहनत से काम करता है लेकिन उस काम से चिपकता नहीं है।
            वह कभी यह नहीं सोचता कि "अगर मैंने यह काम किया तो मुझे प्रमोशन मिलेगी, पैसा मिलेगा या स्वर्ग मिलेगा"; वह बस अपना 100% देता है क्योंकि वह उसकी ड्यूटी है।
            यह कोई आसान काम नहीं है; इंसान का दिमाग हमेशा किसी न किसी स्वार्थ या लालच के बिना काम करने को तैयार ही नहीं होता।
            लेकिन जब कोई इंसान अपने ही दिमाग को इस लेवल (Level) तक हैक (Hack) कर लेता है कि वो बिना किसी उम्मीद के मशीन की तरह परफेक्ट काम करने लगे, तो वह एक असली 'सुपरहीरो' बन जाता है।
            यह 'कर्म-योग' की बिल्कुल चरम सीमा (Peak) है जहाँ इंसान इस दुनिया के कीचड़ में रहते हुए भी एक कमल के फूल की तरह 100% अछूता और पवित्र रहता है।
            यही वो एकमात्र और सबसे साइंटिफिक त्याग है जो इंसान के सारे पापों को धोकर उसे सीधे भगवान के परम धाम की ओर ले जाने की पक्की गारंटी देता है।
        """.trimIndent(),
        english = """
            O Arjuna! When a human actively performs his prescribed mandatory duty solely operating on the absolute titanium conviction that "This must be done strictly because it is my fundamental duty" (Karyam ity eva).
            And while flawlessly executing that rigorous assigned work he successfully violently and completely relinquishes all toxic psychological attachment (Sangam) and absolutely every pathetic craving for the final fruitive result (Phalam).
            This specific incredibly pure highly unmotivated and fiercely disciplined execution of duty is officially and universally categorized by elite authorities as renunciation in the absolute mode of goodness (Sattvic Tyaga).
            Lord Sri Krishna is downloading the multiverse's absolute most flawless mathematically perfect and foolproof formula for achieving the highest echelon of authentic 'Renunciation' directly into human consciousness.
            The internal psychological software of a Sattvic human is as crystal-clear as a flawless mirror; he aggressively works extremely hard for his family society and God but completely refuses to let the matrix attach to his soul.
            His brain mathematically never calculates "If I sweat blood executing this massive project I will legally extract a heavy promotion billions in cash or a VIP ticket to heaven"; he simply delivers 100% sheer perfection purely because it is his cosmic duty.
            This is absolutely not a cheap biological feat; the default human brain is fundamentally wired to stubbornly refuse any severe physical labor unless secretly fueled by some toxic selfish greed or expectation.
            But the exact microsecond a mortal successfully hacks his own primitive biology upgrading his consciousness to operate like a flawless unexpecting machine delivering perfection he legally mutates into a literal cosmic 'Superhero'.
            This represents the absolute zenith and terrifying 'Peak' of Karma-Yoga where a human functions deep within the filthy toxic mud of the material matrix yet remains 100% untouched pristine and pure exactly like a lotus flower.
            This is the absolute only scientific form of renunciation that provides a titanium iron-clad cosmic guarantee of incinerating all karmic sins and launching the soul directly toward the Supreme Godhead's eternal dimension.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            न द्वेष्ट्यकुशलं कर्म कुशले नानुषज्जते |
            त्यागी सत्त्वसमाविष्टो मेधावी छिन्नसंशयः || १० ||
        """.trimIndent(),
        hindi = """
            जो महान और सच्चा त्यागी व्यक्ति पूरी तरह से सत्त्व गुण में स्थित हो चुका है, जिसकी बुद्धि अत्यंत मेधावी (तीक्ष्ण और कुशाग्र) है और जिसके मन के सारे संशय और शक पूरी तरह से कट चुके हैं (छिन्नसंशयः)।
            वह इंसान किसी भी ऐसे काम से कभी भी नफरत या द्वेष नहीं करता जो कष्ट देने वाला या अशुभ (अकुशल) लगता हो।
            और वह इंसान किसी भी ऐसे काम में बहुत ज़्यादा आसक्त (लिप्त) भी नहीं होता जो बहुत ही सुख देने वाला, आसान और शुभ (कुशल) लगता हो।
            यह श्लोक एक ऐसे 'एलीट साधक' (Elite Seeker) की साइकोलॉजी (Psychology) का एक्स-रे है जिसने अपने दिमाग के सिस्टम को पूरी तरह से हैक (Hack) कर लिया है।
            साधारण इंसान हमेशा उन कामों से भागता है जिनमें मेहनत लगती है या जो बोरिंग (Boring) होते हैं, और वह केवल उन्हीं कामों से चिपकता है जो उसे मज़ा और पैसा देते हैं।
            लेकिन एक सात्त्विक इंसान का दिमाग एक 'मशीन' की तरह बिल्कुल न्यूट्रल (Neutral) और फोकस (Focus) हो जाता है; उसके लिए कोई भी काम 'अच्छा' या 'बुरा' नहीं होता।
            अगर उसे समाज की भलाई के लिए टॉयलेट (Toilet) भी साफ करना पड़े (अकुशल कर्म), तो वह उसे बिना किसी नफरत या घिन के पूरी ईमानदारी से करता है।
            और अगर उसे किसी देश का राजा भी बना दिया जाए (कुशल कर्म), तो वह उस पावर (Power) के नशे में अंधा नहीं होता और न ही उस कुर्सी से चिपकता है।
            उसका हर 'संशय' (Doubt) पूरी तरह खत्म हो चुका होता है क्योंकि उसे यह 100% पक्का पता होता है कि असली शांति केवल कर्म करने में है, कर्म के रिज़ल्ट में नहीं।
            यही वह 'समभाव' (Equanimity) है जो इंसान को दुनिया के हर सुख और दुख से पूरी तरह इम्यून (Immune) बनाकर एक साक्षात योगी बना देता है।
        """.trimIndent(),
        english = """
            The authentic and highly elevated renouncer who is flawlessly situated purely in the mode of goodness whose supreme intelligence is razor-sharp (Medhavi) and whose every single microscopic psychological doubt has been violently completely shattered (Chinna-samshayah).
            Such an elite human absolutely never mathematically hates or despises executing any prescribed work even if it appears to be highly troublesome heavily distressing or fundamentally inauspicious (Akushalam).
            And simultaneously he absolutely never becomes toxically attached to or blindly entangled in any work that appears to be extremely comfortable highly profitable and beautifully auspicious (Kushale).
            This spectacular verse provides a flawless high-definition X-Ray of the psychological architecture of an 'Elite Seeker' who has successfully and completely hacked his own biological operating system.
            An ordinary ignorant mortal constantly behaves like a pathetic coward violently fleeing from any grueling boring or physically exhausting labor while desperately super-gluing himself exclusively to tasks that instantly inject cheap dopamine and quick cash.
            But the upgraded brain of a Sattvic human operates exactly like a cold perfectly neutral titanium machine; his highly advanced software absolutely refuses to categorize cosmic duties into subjective biological folders of 'Good' or 'Bad'.
            If the supreme universal system mandates that he must scrub filthy toilets to execute genuine social welfare (Inauspicious work) he performs it with 100% flawless integrity completely devoid of any microscopic hate or disgust.
            And if the cosmic matrix suddenly elevates him to the ultimate throne as the supreme king of the planet (Auspicious work) he absolutely refuses to become intoxicated by that massive power or toxically super-glue himself to that throne.
            Every single paralyzing 'Doubt' inside his skull has been permanently deleted because he possesses the 100% titanium conviction that authentic peace is extracted solely from flawless execution of duty not from hoarding the final physical payout.
            This terrifying level of absolute 'Equanimity' mathematically immunizes the human brain against every single euphoric high and crushing depression in the multiverse upgrading him into a literal walking immortal Yogi.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            न हि देहभृता शक्यं त्यक्तुं कर्माण्यशेषतः |
            यस्तु कर्मफलत्यागी स त्यागीत्यभिधीयते || ११ ||
        """.trimIndent(),
        hindi = """
            किसी भी शरीर-धारी (देहभृता) यानी भौतिक शरीर धारण करने वाले जीव के लिए यह बिल्कुल भी संभव (शक्यं) नहीं है कि वह अपने जीवन के सभी कर्मों का पूरी तरह से (अशेषतः) त्याग कर दे।
            परंतु जो महान व्यक्ति अपने द्वारा किए जाने वाले सभी कर्मों के फलों (Results/Profits) का पूरी तरह से त्याग कर देता है, वास्तव में केवल उसी व्यक्ति को ही 'सच्चा त्यागी' कहा जाता है (स त्यागीत्यभिधीयते)।
            भगवान श्रीकृष्ण यहाँ इंसानी शरीर के सबसे बड़े 'बायोलॉजिकल फैक्ट' (Biological Fact) और विज्ञान को बहुत ही कड़े शब्दों में दुनिया के सामने रख रहे हैं।
            कुछ मूर्ख लोग सोचते हैं कि अगर वे जंगल में जाकर आँखें बंद करके बैठ जाएं, तो उन्होंने सारे कर्मों को छोड़ दिया है और वे बहुत बड़े संन्यासी बन गए हैं।
            भगवान इस बात को सिरे से खारिज करते हैं! जब तक इंसान के पास यह 'हाड़-मांस की मशीन' (शरीर) है, तब तक साँस लेना, पलक झपकाना, खाना और शरीर की सफाई करना भी एक 'कर्म' ही है।
            इसलिए 100% कर्मों को छोड़ देना वैज्ञानिक और बायोलॉजिकल (Biological) रूप से पूरी तरह नामुमकिन है; ऐसा सोचना भी केवल एक भयंकर भ्रम है।
            तो फिर असली आज़ादी या संन्यास क्या है? भगवान अल्टीमेट फॉर्मूला (Ultimate Formula) देते हैं: "कर्मों को मत छोड़ो, बल्कि उन कर्मों से मिलने वाले 'अवार्ड' (Award) और 'पैसे' (Fruit) के लालच को छोड़ दो।"
            आप दिन-रात ऑफिस में काम करो या देश की रक्षा करो, लेकिन यह मत सोचो कि "मुझे इसके बदले क्या मिलेगा?" बस अपनी ड्यूटी समझकर 100% परफेक्शन (Perfection) के साथ काम करो।
            जिस इंसान ने अपने दिमाग के इस 'लालच वाले सॉफ्टवेयर' (Greed Software) को डिलीट कर दिया, भगवान उसी को ऑफिशियली दुनिया का सबसे बड़ा 'त्यागी' घोषित करते हैं।
            यह श्लोक 'प्रैक्टिकल स्पिरिचुअलिटी' (Practical Spirituality) का सबसे बड़ा मास्टरस्ट्रोक है जो इंसान को बिना जंगल जाए दुनिया में रहकर ही मोक्ष दिला सकता है।
        """.trimIndent(),
        english = """
            It is mathematically and biologically absolutely impossible for any embodied living entity possessing a physical biological vessel (Deha-bhrita) to completely and entirely give up executing all activities without exception (Asheshatah).
            But that highly elite individual who successfully violently and completely relinquishes all toxic psychological attachment to the fruits and results of his actions is the only one who is officially universally declared to be a true renouncer (Tyagi).
            Lord Sri Krishna is dropping the absolute ultimate unshakeable 'Biological Fact' and hardcore cosmic science directly onto the entire human race in extremely brutal uncompromising terms.
            Ignorant foolish mortals constantly hallucinate that if they simply run away into a dark remote jungle and sit perfectly still with closed eyes they have successfully abandoned all physical karma mutating into supreme enlightened saints.
            The Supreme Creator violently rejects this pathetic illusion! As long as a human soul operates inside this 'Flesh-and-Bone Machine' (the body) basic involuntary actions like breathing blinking digesting food and executing biological maintenance mathematically count as 'Karma'.
            Therefore completely hitting zero on the physical action meter is scientifically and biologically 100% impossible; even arrogantly hallucinating such a possibility is a symptom of severe toxic delusion.
            So what exactly is the authorized cosmic definition of ultimate freedom? The Lord provides the ultimate master formula: "Absolutely do not abandon your daily duties; instead violently amputate the toxic psychological greed demanding the final 'Award' and 'Cash' (Fruit)."
            You must aggressively hustle 24/7 in your corporate office or fiercely defend your nation on the battlefield but you must absolutely destroy the internal voice screaming "What is my personal payout?"; simply execute 100% flawless perfection purely as your assigned duty.
            The exact microsecond a human successfully uninstalls and permanently deletes this 'Toxic Greed Software' from his brain the Supreme Godhead officially and legally stamps him as the absolute greatest 'Renouncer' (Tyagi) in the multiverse.
            This spectacular verse functions as the ultimate masterstroke of 'Practical Spirituality' proving mathematically that a human can achieve eternal Moksha without ever retreating to a jungle simply by reprogramming his intentions while dominating the matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            अनिष्टमिष्टं मिश्रं च त्रिविधं कर्मणः फलम् |
            भवत्यत्यागिनां प्रेत्य न तु संन्यासिनां क्वचित् || १२ ||
        """.trimIndent(),
        hindi = """
            जो लोग कर्मों के फलों का त्याग नहीं करते (अत्यागिनां), उन्हें मृत्यु के बाद (प्रेत्य) उनके किए गए कर्मों के मुख्य रूप से तीन प्रकार के फल भोगने ही पड़ते हैं: अनिष्ट (बुरा), इष्ट (अच्छा) और मिश्र (मिला-जुला)।
            परंतु जो लोग सच्चे संन्यासी हैं और जिन्होंने अपने सभी कर्मों के फलों का पूरी तरह से त्याग कर दिया है, उन्हें मृत्यु के बाद किसी भी प्रकार के कर्म का कोई भी फल कभी भी (न क्वचित्) नहीं भुगतना पड़ता।
            भगवान यहाँ ब्रह्मांड के 'लॉ ऑफ कर्मा' (Law of Karma) का पूरा का पूरा 'बैलेंस-शीट' (Balance-sheet) और उसका अल्टीमेट रिज़ल्ट खोलकर रख रहे हैं।
            जो आम इंसान (अत्यागी) लालच, घमंड या डर से काम करता है, उसका कर्मा-अकाउंट (Karma-account) कभी खाली नहीं होता। मरने के बाद उसे अपने बुरे कामों के लिए नर्क (अनिष्ट), अच्छे कामों के लिए स्वर्ग (इष्ट) और साधारण कामों के लिए वापस धरती (मिश्र) पर आना ही पड़ता है।
            यह इंसान जन्म-मरण के इस भयानक और कभी न रुकने वाले चक्रव्यूह में एक मशीन की तरह बुरी तरह फँसा रहता है और बार-बार अलग-अलग योनियों में धक्के खाता है।
            लेकिन जो एक सच्चा योगी या संन्यासी है, वह 'हैक' (Hack) जान चुका है! वह जीवन भर काम तो बहुत ज़बरदस्त करता है, लेकिन उसके फलों (Award/Punishment) को वो अपने नाम पर रजिस्टर (Register) ही नहीं होने देता।
            वह अपने सारे कामों को "जीरो-एक्सपेक्टेशन" (Zero-expectation) के साथ भगवान के सर्वर में अपलोड (Upload) कर देता है, जिससे उसका अपना कर्मा-अकाउंट हमेशा 'ज़ीरो' (Zero) रहता है।
            और जब मौत आती है, तो ब्रह्मांड के सिस्टम के पास उस सन्यासी को देने के लिए न तो कोई सज़ा होती है और न ही कोई इनाम, क्योंकि उसका सारा हिसाब-किताब पहले ही खत्म हो चुका होता है।
            नतीजा यह होता है कि वह हमेशा के लिए इस 3D मैट्रिक्स से आज़ाद हो जाता है (मोक्ष पा लेता है) और उसे दोबारा किसी भी प्रकार का शरीर धारण नहीं करना पड़ता।
            यह श्लोक साबित करता है कि कर्मों के फल का त्याग करना केवल एक अच्छी आदत नहीं है, बल्कि यह इंसान की आत्मा को हमेशा के लिए आज़ाद करने का एकमात्र 'मास्टर-पासवर्ड' (Master-password) है।
        """.trimIndent(),
        english = """
            For those ignorant individuals who absolutely refuse to renounce the fruits of their actions (Atyaginam) there are mathematically exactly three types of cosmic results awaiting them after biological death (Pretya): undesirable (bad) desirable (good) and mixed.
            But for those elite authentic renouncers (Sannyasis) who have aggressively and permanently relinquished all attachment to fruitive results there are absolutely zero karmic reactions to suffer or enjoy at any point in the future (Na kvachit).
            The Supreme Lord is explicitly declassifying the ultimate universal 'Balance-Sheet' and explicitly revealing exactly how the strict 'Law of Karma' operates the cosmic accounting system.
            An ordinary mortal (Atyagi) who executes actions heavily fueled by toxic greed massive ego or paralyzing fear mathematically guarantees his personal 'Karma-Account' is never empty; upon death he is forcefully routed to Hell for sins (Anishta) Heaven for piety (Ishta) and Earth for mixed deeds (Mishram).
            This pathetic human remains hopelessly and violently trapped within the terrifying inescapable loop of continuous reincarnation blindly bouncing around exactly like a mechanical pinball across millions of different biological species.
            But the authentic elite Yogi or Sannyasi has successfully downloaded the ultimate cosmic 'Hack'! He executes staggering world-changing labor throughout his entire lifespan but mathematically refuses to legally register the final fruits (Awards or Punishments) under his own name.
            He flawlessly uploads 100% of his actions directly into God's absolute server operating with "Zero-Expectation" ensuring his own personal karmic bank balance remains permanently and cleanly at 'Zero'.
            And when the exact microsecond of terminal biological death arrives the universal operating system possesses absolutely no pending punishment to inflict and no cheap reward to grant because his entire cosmic ledger has been permanently zeroed out.
            The magnificent result is that he successfully totally bypasses the 3D material matrix achieving eternal Moksha and is mathematically guaranteed never to be forced into a biological cage ever again.
            This spectacular verse violently proves that renouncing the fruits of your labor is absolutely not merely a cute moral habit; it is the multiverse's only valid authorized 'Master-Password' designed to permanently liberate the human soul.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            पञ्चैतानि महाबाहो कारणानि निबोध मे |
            साङ्ख्ये कृतान्ते प्रोक्तानि सिद्धये सर्वकर्मणाम् || १३ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 13 से 15 तक हर कर्म को पूरा करने वाले 5 कारणों का वर्णन है)
            हे महाबाहु अर्जुन! इस दुनिया के किसी भी कर्म (काम) को सफलतापूर्वक पूरा करने (सिद्धि) के लिए वेदों और वेदांत (सांख्य) में मुख्य रूप से पाँच कारण (फैक्टर्स / Factors) बताए गए हैं।
            अब तुम इन पाँचों कारणों को बहुत ही ध्यान से मुझसे भली-भांति जान लो और समझ लो, क्योंकि इनके बिना दुनिया का कोई भी काम पूरा नहीं हो सकता (निबोध मे)।
            भगवान श्रीकृष्ण अब अर्जुन को 'साइंस ऑफ एक्शन' (Science of Action / कर्म का विज्ञान) की एक बिल्कुल नई और सबसे गहरी मास्टरक्लास (Masterclass) देने जा रहे हैं।
            जब इंसान कोई काम करता है और वह काम बहुत सफल हो जाता है, तो इंसान का अहंकार (Ego) तुरंत उछलकर कहता है, "यह काम मैंने किया है, मैं सबसे महान हूँ!"
            इंसान की यह अंधी सोच उसे घमंडी बना देती है क्योंकि उसे लगता है कि वह अकेला ही किसी भी काम का 100% 'कंट्रोलर' (Controller) और कारण है।
            भगवान इस भयंकर भ्रम को एक झटके में तोड़ने के लिए ब्रह्मांड का वो 'सीक्रेट फॉर्मूला' (Secret Formula) बता रहे हैं जो साबित करेगा कि इंसान अकेला कुछ भी नहीं कर सकता।
            वेद और सांख्य फिलॉसफी (Philosophy) यह साफ बताती है कि किसी भी छोटे से छोटे काम (जैसे एक गिलास पानी उठाना) से लेकर बड़े से बड़े काम (जैसे कोई युद्ध जीतना) के पीछे केवल एक नहीं बल्कि 5 अलग-अलग ताकतें (Factors) एक साथ मिलकर काम करती हैं।
            अगर इन 5 ताकतों में से कोई एक भी फैक्टर अपना काम करना बंद कर दे, तो इंसान का वह काम तुरंत फेल (Fail) हो जाएगा और वह कुछ नहीं कर पाएगा।
            भगवान अर्जुन को इन 5 ताकतों को समझने का आदेश दे रहे हैं ताकि अर्जुन का यह भ्रम टूट जाए कि "मैं युद्ध कर रहा हूँ या मैं लोगों को मार रहा हूँ।"
            अगले श्लोक में भगवान एक साइंटिस्ट (Scientist) की तरह उन 5 ताकतों का नाम और उनका काम दुनिया के सामने रखेंगे।
        """.trimIndent(),
        english = """
            (Verses 13 through 15 scientifically decode the exact 5 absolute factors required to execute any physical action)
            O mighty-armed Arjuna! According to the supreme conclusions of the highly advanced Vedanta philosophy (Sankhya) there are mathematically exactly five primary causes (Factors) required for the successful accomplishment of absolutely all physical action.
            Now please listen with absolute titanium focus and completely learn these exact five absolute factors directly from Me because without their combined alignment no task can ever be successfully executed (Nibodha me).
            Lord Sri Krishna is aggressively launching Arjuna into a completely new unprecedented and staggeringly deep masterclass explicitly decoding the absolute 'Science of Action' and human productivity.
            When an ignorant mortal executes a massive project and achieves staggering global success his toxic false ego instantaneously violently erupts screaming "I alone have achieved this greatness; I am the absolute ultimate genius!"
            This blinding arrogant assumption heavily pollutes the human consciousness because he pathetically hallucinates that he is the 100% exclusive 'Controller' and absolute sole architect behind his earthly victories.
            The Supreme Lord is violently destroying this terrifying illusion in a single stroke by officially declassifying the universe's 'Secret Formula' which mathematically proves that an isolated human is absolutely incapable of executing anything.
            The authorized Vedic scriptures and elite Sankhya philosophy flawlessly confirm that from the most microscopic action (like lifting a glass of water) to a massive cosmic event (like winning a global war) exactly 5 distinct powerful forces must operate simultaneously in absolute unison.
            If even one single microscopic variable out of these 5 precise factors randomly malfunctions or ceases to cooperate the human's entire grand endeavor will instantly and catastrophically fail rendering him completely powerless.
            The Lord commands Arjuna to thoroughly internalize the mechanics of these 5 distinct forces explicitly to violently assassinate Arjuna's toxic illusion that "I am the one fighting this war and I am the one killing these soldiers."
            In the exact next verse the Supreme Creator operating exactly like an elite quantum scientist will officially broadcast the names and precise functions of these 5 cosmic factors to the entire multiverse.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            अधिष्ठानं तथा कर्ता करणं च पृथग्विधम् |
            विविधाश्च पृथक्चेष्टा दैवं चैवात्र पञ्चमम् || १४ ||
        """.trimIndent(),
        hindi = """
            किसी भी कर्म को पूरा करने के लिए ये पाँच कारण होते हैं: पहला है 'अधिष्ठान' (यह भौतिक शरीर / The Body), दूसरा है 'कर्ता' (अहंकार से भरा हुआ जीव / The Doer)।
            तीसरा कारण है 'करण' (विभिन्न प्रकार की इन्द्रियां / The Senses), चौथा है 'विविध चेष्टाएं' (इंसान द्वारा की जाने वाली अलग-अलग प्रकार की मेहनत और प्रयास / The Endeavors)।
            और इन सबमें जो सबसे मुख्य और पाँचवाँ कारण है, वह है 'दैव' (परमात्मा या ईश्वर की कृपा / The Supersoul)।
            भगवान यहाँ उस 'कर्म की फैक्ट्री' (Action Factory) के पाँचों पुर्जों (Parts) को एक-एक करके दुनिया के सामने रख रहे हैं जिससे हर काम होता है।
            सबसे पहले आपको एक 'शरीर' (अधिष्ठान) चाहिए, जो उस काम को करने का एक प्लेटफ़ॉर्म (Platform) या मशीन है (बिना शरीर के आप कुछ नहीं कर सकते)।
            दूसरा है 'कर्ता' यानी वह आत्मा जो अहंकार में आकर सोचती है कि "मैं यह काम करूँगा।" (अगर अंदर ड्राइवर ही नहीं है, तो गाड़ी कैसे चलेगी?)।
            तीसरा है 'इन्द्रियां' (आँख, कान, हाथ, पैर), जो वे 'टूल्स' (Tools) या औज़ार हैं जिनकी मदद से शरीर बाहर की दुनिया में काम करता है।
            चौथा है 'चेष्टा', यानी वह 'मेहनत' और एनर्जी (Energy) जो इंसान का शरीर और उसकी इन्द्रियां उस काम को पूरा करने के लिए लगाती हैं।
            लेकिन भगवान कहते हैं कि अगर तुम्हारे पास ये चारों चीज़ें (परफेक्ट शरीर, घमंड, बेहतरीन औज़ार और बहुत सारी मेहनत) मौजूद भी हों, तो भी काम पूरा नहीं होगा!
            जब तक कि पाँचवाँ और सबसे बड़ा बॉस—'दैव' (ईश्वर की परमिशन और ब्रह्मांड का साथ)—उस काम में अपनी मोहर (Stamp) नहीं लगाता, तब तक कोई भी सफलता इंसान को नहीं मिल सकती।
        """.trimIndent(),
        english = """
            The exact five components required to execute any action are: First the 'Adhishthanam' (the biological physical body or place of action); second the 'Karta' (the individual soul identifying with the false ego as the doer).
            The third factor is the 'Karanam' (the various distinct senses and internal organs); the fourth is the 'Vividhash cha prithak cheshta' (the multiple different kinds of massive biological endeavors and physical efforts exerted).
            And the absolute ultimate fifth and most critical factor powering all of this is the 'Daivam' (the Supreme Supersoul or divine cosmic sanction).
            The Supreme Lord is meticulously unpacking the exact five mechanical and spiritual 'Parts' constructing the universal 'Action Factory' responsible for generating every single physical event.
            First and foremost you mathematically require a 'Body' (Adhishthanam) acting strictly as the biological platform or the physical machine (without this 3D avatar executing any earthly task is impossible).
            Second is the 'Doer' (Karta) representing the conscious eternal soul hopelessly infected with false ego arrogantly deciding "I will execute this task" (without the internal driver the biological vehicle remains totally paralyzed).
            Third are the 'Senses' (eyes ears hands) acting as the highly specialized external biological 'Tools' through which the human machine violently interacts with and manipulates the external material matrix.
            Fourth encompasses the 'Endeavors' indicating the massive raw physical energy brutal sweat and relentless biological hustle the human actively burns attempting to force the task to completion.
            But the Lord drops a massive truth bomb: Even if you possess a flawless Olympic body staggering arrogance premium biological tools and burn 100% of your energy your task will still mathematically fail!
            Absolutely no human success can ever materialize until the ultimate fifth and absolute Supreme Boss—the 'Daivam' (The Supersoul granting explicit cosmic permission)—officially stamps His divine approval upon your pathetic endeavor.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            शरीरवाङ्मनोभिर्यत्कर्म प्रारभते नरः |
            न्याय्यं वा विपरीतं वा पञ्चैते तस्य हेतवः || १५ ||
        """.trimIndent(),
        hindi = """
            मनुष्य अपने शरीर (Physical Body), अपनी वाणी (शब्द/Speech), अथवा अपने मन (विचार/Mind) के द्वारा जो भी कोई नया कर्म (काम) शुरू करता है।
            चाहे वह काम न्याय के अनुसार बिल्कुल सही और धर्म के रास्ते पर (न्याय्यं) हो, या फिर वह काम पूरी तरह से गलत, अधर्म और विपरीत (विपरीतं) हो।
            उस हर एक छोटे-बड़े, अच्छे या बुरे काम को पूरी तरह से अंजाम देने के पीछे हमेशा ये पाँच ही कारण (हेतु/Factors) मुख्य रूप से ज़िम्मेदार होते हैं।
            भगवान यहाँ एक बहुत बड़ा 'यूनिवर्सल लॉ' (Universal Law / ब्रह्मांडीय नियम) सेट कर रहे हैं कि इंसान का कोई भी एक्शन (Action) इस 5-फैक्टर (5-factor) सिस्टम से बाहर नहीं जा सकता।
            इंसान दुनिया में तीन ही तरीकों से काम कर सकता है: या तो वह अपने हाथ-पैर (शरीर) से कुछ करेगा, या अपनी जीभ (वाणी) से कुछ बोलेगा, या फिर अकेले में बैठकर अपने दिमाग (मन) में कुछ सोचेगा।
            भगवान कहते हैं कि चाहे तुम मंदिर में बैठकर पूजा (सही काम) कर रहे हो, या किसी का कत्ल (गलत काम) करने की प्लानिंग (Planning) कर रहे हो।
            तुम्हारे उस अच्छे या बुरे हर काम के पीछे केवल तुम्हारी मर्ज़ी नहीं चल रही है, बल्कि वह काम तभी पूरा हो रहा है जब वे 5 कारण (शरीर, कर्ता, इन्द्रियां, मेहनत और दैव) एक साथ मिल रहे हैं।
            यह जानकर कई लोग सोच सकते हैं कि "अगर गलत काम में भी भगवान (दैव) का ही हाथ है, तो इंसान को पाप क्यों लगता है?"
            इसका सीधा सा जवाब है: इंसान अपने अहंकार (कर्ता) और मन से उस गलत काम की 'इच्छा' और 'मेहनत' करता है, और ब्रह्मांड (दैव) केवल एक न्यूट्रल (Neutral) सिस्टम की तरह उस इच्छा को पूरा करने की परमिशन (Permission) दे देता है।
            इसलिए इंसान अपने किए हुए कर्म के पाप या पुण्य से कभी नहीं बच सकता, लेकिन उसे यह घमंड भी नहीं करना चाहिए कि वह अपनी मर्ज़ी से बिना ईश्वर की मशीनरी के कुछ भी कर सकता है।
        """.trimIndent(),
        english = """
            Absolutely whatever physical action a human being aggressively initiates or performs whether through his biological body (Sharira) his vocal cords and speech (Vang) or his internal psychological mind (Manobhir).
            And regardless of whether that specific action is strictly lawful perfectly righteous and authorized (Nyayyam) or entirely horribly wrong highly destructive and strictly prohibited (Viparitam).
            Behind every single microscopic or massive good or evil action executed in this matrix these exact five specific factors are mathematically always the sole responsible root causes (Hetavah).
            The Supreme Lord is officially establishing an absolute iron-clad 'Universal Law' explicitly dictating that absolutely zero human actions can ever possibly bypass or exist outside this flawless 5-factor systemic equation.
            A human entity can only physically interact with the multiverse through exactly three authorized vectors: executing labor with his biological limbs (Body) vibrating sound through his tongue (Speech) or calculating thoughts in his brain (Mind).
            The Lord emphatically declares that whether you are piously executing severe charity in a sacred temple (Righteous action) or secretly aggressively plotting a horrific bloody assassination (Evil action).
            That specific virtuous or toxic endeavor is absolutely not powered entirely by your independent free will; it mathematically only reaches completion because those 5 exact factors (Body Doer Senses Hustle and Supersoul) align synchronously.
            Hearing this highly classified data a confused mortal might arrogantly argue: "If the Supreme Supersoul (Daivam) is physically involved in executing a horrific murder why is the human punished for the sin?"
            The absolute scientific answer is: The human's toxic false ego (The Doer) actively desires and physically sweats (The Endeavor) to execute the evil and the Supersoul merely acts as a perfectly neutral operating system mathematically granting the biological permission required to fulfill that toxic desire.
            Therefore a human absolutely can never escape the brutal karmic consequences of his own toxic choices but he must simultaneously permanently delete the arrogant hallucination that he can execute anything entirely independent of God's universal machinery.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            तत्रैवं सति कर्तारमात्मानं केवलं तु यः |
            पश्यत्यकृतबुद्धित्वान्न स पश्यति दुर्मतिः || १६ ||
        """.trimIndent(),
        hindi = """
            इस प्रकार इन पाँचों कारणों (फैक्टर्स) के मौजूद होने पर भी, जो इंसान अपनी अशुद्ध और मूर्ख बुद्धि (अकृतबुद्धित्वात्) के कारण केवल अपनी 'आत्मा' या खुद (Ego) को ही हर काम का इकलौता करने वाला (कर्ता) मानता है।
            वास्तव में वह भयंकर रूप से अज्ञानी और मूर्ख इंसान (दुर्मतिः) दुनिया की असली सच्चाई को बिल्कुल भी नहीं देख पा रहा है (न स पश्यति)।
            भगवान यहाँ इंसान के 'मैं कर रहा हूँ' (I am the doer) वाले भयंकर अहंकार और उसकी दिमागी अंधेपन पर एक बहुत करारा और जोरदार प्रहार (Attack) कर रहे हैं।
            भगवान समझा चुके हैं कि तुम्हारे सफल होने के पीछे 5 अलग-अलग ताकतें काम कर रही हैं, जिनमें तुम्हारा शरीर, इन्द्रियां, मेहनत और सबसे बड़ा खुद भगवान (दैव) शामिल हैं।
            लेकिन जब कोई इंसान बहुत बड़ी कंपनी (Company) खड़ी कर लेता है या कोई बड़ी जंग जीत लेता है, तो उसका गंदा और अशुद्ध दिमाग (अकृतबुद्धित्वात्) बाकी चारों ताकतों को पूरी तरह भूल जाता है।
            वह न्यूज़ चैनल्स पर जाकर सीना तानकर कहता है कि "यह सब केवल मेरी अकल और मेरी ही मेहनत का नतीजा है, मैंने अकेले ही यह सब किया है (केवलं तु यः)।"
            भगवान ऐसे घमंडी इंसान को बहुत ही कड़े शब्दों में 'दुर्मतिः' (एक सड़े हुए दिमाग वाला बेवकूफ) कहकर बुलाते हैं, क्योंकि उसका विज़न (Vision) 100% करप्ट (Corrupt) हो चुका है।
            ऐसा इंसान यह भूल जाता है कि जिस दिमाग पर वह घमंड कर रहा है, अगर भगवान (दैव) उसके दिमाग की एक नस भी बंद कर दें, तो वह एक सेकंड में ज़मीन पर गिर जाएगा।
            जो इंसान अपनी सफलता में ईश्वर के हाथ और प्रकृति की मशीनरी को नहीं देख पाता, वह दुनिया का सबसे बड़ा अंधा इंसान है, चाहे उसकी आँखें कितनी भी बड़ी क्यों न हों।
            सच्चा ज्ञान और सही दृष्टि वही है जो अपनी जीत का क्रेडिट (Credit) खुद लेने के बजाय उसे शांति से भगवान के चरणों में समर्पित कर दे।
        """.trimIndent(),
        english = """
            Therefore this being the absolute scientific reality any human who foolishly considers his own pure soul or his toxic false ego as the absolute exclusive and sole executor of activities (Kartaram atmanam kevalam tu yah).
            Strictly due to his heavily corrupted unpurified and pathetic intelligence (Akrita-buddhitvat) that highly degraded foolish entity (Durmatih) is mathematically totally blind and absolutely does not perceive the truth (Na sa pashyati).
            The Supreme Lord is launching a violently aggressive and brutal psychological attack directly targeting humanity's most toxic terrifying hallucination: the bloated arrogant obsession of "I am the supreme doer."
            The Lord has already flawlessly established that any successful human endeavor is heavily powered by 5 distinct cosmic forces heavily including the biological body the senses the physical sweat and the ultimate Supreme Boss (Daivam).
            But when a highly ignorant mortal successfully builds a billion-dollar corporate empire or violently conquers a global war his deeply polluted and unrefined biological brain (Akrita-buddhi) instantaneously violently forgets the other 4 massive cosmic contributors.
            He arrogantly marches onto global television screens aggressively pounding his chest and screaming "This entire staggering success is exclusively the 100% direct result of my own solitary supreme genius! I alone did this (Kevalam)!"
            The Supreme Creator brutally labels such a toxically arrogant mortal exactly as 'Durmatih' (a pathetic brainless fool with a severely rotting intellect) because his cosmic vision has been 100% hacked and corrupted by sheer illusion.
            This pathetic human completely forgets that if the Supreme Supersoul (Daivam) simply decides to mechanically pinch one microscopic nerve inside his arrogant brain his entire biological machine will violently crash to the floor in a microsecond.
            A mortal who becomes so intoxicated by his own temporary earthly victories that he becomes biologically incapable of perceiving God's massive invisible hand operating behind the scenes is officially the multiverse's most blind entity.
            Authentic transcendental knowledge and flawless 20/20 cosmic vision dictate that a human must aggressively refuse to hoard the toxic credit for his victories choosing instead to gracefully and quietly submit 100% of the glory directly at the lotus feet of the Supreme.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            यस्य नाहङ्कृतो भावो बुद्धिर्यस्य न लिप्यते |
            हत्वापि स इमाँल्लोकान्न हन्ति न निबध्यते || १७ ||
        """.trimIndent(),
        hindi = """
            जिस इंसान के मन में "मैं यह काम कर रहा हूँ" ऐसा झूठा अहंकार (अहङ्कृतो भावो) बिल्कुल भी नहीं होता, और जिसकी बुद्धि किसी भी काम के फलों में नहीं फँसती (न लिप्यते)।
            ऐसा ज्ञानी व्यक्ति अगर इस पूरी दुनिया (इन सभी लोगों) को मार भी डाले (हत्वापि), तो भी वह वास्तव में किसी को नहीं मारता (न हन्ति) और न ही उसे कभी हत्या का कोई पाप या कर्म-बंधन लगता है (न निबध्यते)।
            यह भगवद्गीता के सबसे भयंकर, सबसे गहरे और 'माइंड-ब्लोइंग' (Mind-blowing) श्लोकों में से एक है जो आम इंसान की समझ के बिल्कुल बाहर है!
            भगवान यहाँ अर्जुन को यह समझा रहे हैं कि पाप या पुण्य तुम्हारे हाथों के एक्शन (Action) से नहीं बनता, बल्कि वह तुम्हारे दिमाग की नीयत (Intention) और ईगो (Ego) से बनता है।
            अगर कोई इंसान नफरत, लालच या अपने स्वार्थ के लिए किसी को एक थप्पड़ भी मारता है, तो उसका ईगो उसे उस भयंकर पाप के जाल में हमेशा के लिए फँसा देता है।
            लेकिन एक सच्चा योगी, एक सैनिक या एक जज (Judge), जिसका दिमाग 100% जीरो-ईगो (Zero-Ego) पर सेट है, और जो यह जानता है कि "मैं नहीं, बल्कि प्रकृति के 5 कारण काम कर रहे हैं"...
            अगर वह अपने कर्तव्य (Duty) और धर्म की रक्षा के लिए युद्ध के मैदान में लाखों दुश्मनों की गर्दन भी काट दे, तो भी भगवान के लेजर (Ledger/अकाउंट) में उसका पाप 'जीरो' (Zero) होता है!
            क्योंकि उस वक्त वह अपने किसी लालच के लिए नहीं लड़ रहा है; वह एक 'सर्जिकल टूल' (Surgical Tool) की तरह भगवान के हाथों की तलवार बन चुका होता है।
            जिस इंसान का 'मैं' (I) मर चुका है, वह जो भी करता है, वह काम उसका नहीं बल्कि सीधा ब्रह्मांड (Universe) का काम बन जाता है।
            अर्जुन को यही 'लाइसेंस' (License) दिया जा रहा है कि अगर तुम अपने अहंकार को मारकर युद्ध करोगे, तो तुम किसी को भी मारने के पाप में कभी नहीं फँसोगे।
        """.trimIndent(),
        english = """
            One who is entirely and flawlessly free from the toxic blinding illusion of the false ego (Yasya nahankrito bhavo) and whose supreme intelligence absolutely never becomes entangled in the results of action (Buddhir yasya na lipyate).
            Even if that elite enlightened master physically annihilates and kills every single living entity in this entire world (Hatvapi sa imal lokan) he actually kills absolutely no one (Na hanti) nor is he ever mathematically bound by the karmic reaction of murder (Na nibadhyate).
            This is unequivocally one of the absolute most terrifying profoundly deep and staggeringly 'Mind-Blowing' verses in the entire Bhagavad Gita existing completely infinitely beyond the pathetic grasp of ordinary human logic!
            The Supreme Lord is explicitly decoding the ultimate quantum mechanics of karma to Arjuna proving that cosmic sin or piety is absolutely NOT generated by the mere mechanical movement of physical hands; it is mathematically engineered strictly by the core 'Intention' and toxic 'Ego' burning inside the brain.
            If an ignorant mortal executes even a microscopic slap against another human strictly fueled by toxic hatred biological lust or selfish greed his bloated ego instantly permanently legally binds his soul into a horrifying web of massive karmic debt.
            But consider an elite authentic Yogi a fearless soldier or a supreme judge whose psychological software is flawlessly locked onto absolute 'Zero-Ego' and who scientifically perceives that "I am not the doer; only the 5 cosmic factors are executing this."
            If that specific master operating strictly to furiously defend eternal Dharma and execute his cosmic duty violently slaughters millions of aggressive enemies on a bloody battlefield his official karmic balance sheet in God's eternal server registers absolutely 'Zero' sin!
            This is mathematically possible because at that exact microsecond he is absolutely not fighting to satisfy any cheap personal greed; his biological vessel has effectively mutated into a flawless 'Surgical Tool' acting entirely as a razor-sharp sword wielded directly by God's own hands.
            When a human successfully violently assassinates his own 'I' (False Ego) whatever physical actions his biological machine executes are no longer classified as his own; they are legally stamped as the direct unstoppable actions of the Universe itself.
            Arjuna is being officially handed the ultimate cosmic 'License to kill': If you violently crush your own arrogance and fight strictly as My instrument you will mathematically never be trapped or bound by the horrifying karmic sin of mass slaughter.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            ज्ञानं ज्ञेयं परिज्ञाता त्रिविधा कर्मचोदना |
            करणं कर्म कर्तेति त्रिविधः कर्मसङ्ग्रहः || १८ ||
        """.trimIndent(),
        hindi = """
            ज्ञान (Knowledge), ज्ञेय (जानने योग्य वस्तु / Object of knowledge), और परिज्ञाता (जानने वाला / The Knower)—ये तीनों मिलकर किसी भी कर्म को शुरू करने की प्रेरणा (Motivation / कर्मचोदना) देते हैं।
            और करण (इन्द्रियां / Senses), कर्म (किया जाने वाला काम / The Work), तथा कर्ता (काम को करने वाला / The Doer)—ये तीनों मिलकर उस पूरे कर्म का एक सेट (कर्मसंग्रह) बनाते हैं जिससे काम पूरा होता है।
            भगवान यहाँ दुनिया के किसी भी काम (Action) के पीछे की 'साइकल' (Cycle) और 'साइकोलॉजी' (Psychology) को एक बहुत ही शानदार वैज्ञानिक फॉर्मूले (Formula) की तरह समझा रहे हैं।
            दुनिया में कोई भी इंसान बिना वजह अचानक से कोई काम शुरू नहीं कर देता; हर काम को शुरू करने से पहले उसके दिमाग में एक 'आइडिया' या 'प्रेरणा' (Motivation) आनी ज़रूरी होती है।
            यह प्रेरणा 3 चीज़ों से आती है: सबसे पहले इंसान को किसी चीज़ का 'ज्ञान' होता है, फिर वह उस 'ज्ञेय' (जैसे एक नई कार) को देखता है, और फिर वह 'ज्ञाता' (इंसान खुद) उसे पाने की इच्छा करता है।
            जब यह प्रेरणा दिमाग में बहुत ज्यादा पक्की हो जाती है, तब इंसान उस काम को फिजिकली (Physically) अंजाम देने के लिए ज़मीन पर उतरता है।
            उस काम को फिजिकली पूरा करने के लिए भी 3 चीज़ों का एक 'सेट' काम करता है: पहले उसके 'करण' (उसके हाथ, पैर और औज़ार) हरकत में आते हैं।
            फिर वह 'कर्ता' (काम करने वाला इंसान) उन औज़ारों का इस्तेमाल करके अपनी मेहनत से उस 'कर्म' (टास्क / Task) को सफलतापूर्वक अंजाम तक पहुँचाता है।
            भगवान अर्जुन को यह डीप-साइंस (Deep-science) इसलिए बता रहे हैं ताकि वह समझ सके कि युद्ध करने का विचार कैसे शुरू होता है और युद्ध कैसे लड़ा जाता है।
            यह श्लोक साबित करता है कि कर्म केवल हाथ-पैर हिलाना नहीं है, बल्कि वह एक बहुत लंबा मानसिक और शारीरिक प्रोसेस (Process) है जो हमारी चेतना से शुरू होकर हमारे शरीर पर खत्म होता है।
        """.trimIndent(),
        english = """
            Knowledge (Jnanam) the specific object of knowledge (Jneyam) and the conscious knower (Parijnata)—these three exact components completely combine to construct the absolute psychological motivation and driving impetus for all action (Karma-chodana).
            And the physical senses acting as tools (Karanam) the actual execution of the work itself (Karma) and the conscious doer (Karta)—these three physical components combine to form the total fundamental basis and complete execution of all action (Karma-sangrahah).
            The Supreme Lord is flawlessly declassifying the absolute ultimate psychological 'Cycle' and structural 'Science' engineering absolutely every single physical action in the multiverse presenting it precisely like a high-level mathematical quantum formula.
            Absolutely no sane human entity in the matrix ever randomly or suddenly initiates a massive physical endeavor completely without a reason; every single action mandatorily requires a highly potent internal 'Idea' or biological 'Motivation' to spark the ignition.
            This primary motivation is mathematically engineered by 3 factors: First the human acquires specific 'Knowledge'; then he visually perceives a highly attractive 'Object' (like a luxury hypercar); and finally the conscious 'Knower' (the human himself) psychologically burns with the toxic desire to physically possess it.
            The exact microsecond this intense psychological motivation becomes undeniably rigid and overwhelmingly powerful inside his brain the human violently launches into physical reality to aggressively execute and complete the endeavor.
            To successfully physically finalize that massive task a secondary physical 'Set' consisting of exactly 3 components violently kicks into gear: First his 'Senses' (his physical hands legs and external mechanical tools) are forcefully activated.
            Then the 'Doer' (the ambitious human operating the biological machine) aggressively utilizes those specific tools to fiercely execute the 'Work' (the targeted task) until it reaches absolute flawless completion.
            The Lord is explicitly downloading this 'Deep-Science' directly into Arjuna's brain so he can clinically dissect and fundamentally comprehend exactly how the initial thought of waging war is birthed and how the brutal physical battle is ultimately fought.
            This phenomenal verse mathematically proves that 'Action' is absolutely not merely the cheap random flailing of biological limbs; it is a profoundly massive incredibly complex psycho-physical process that violently originates deep within pure consciousness and terminates forcefully on the physical plane.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            ज्ञानं कर्म च कर्ता च त्रिधैव गुणभेदतः |
            प्रोच्यते गुणसङ्ख्याने यथावच्छृणु तान्यपि || १९ ||
        """.trimIndent(),
        hindi = """
            प्रकृति के तीनों गुणों (सत्त्व, रजस और तमस) के भारी अंतर के कारण ज्ञान (Knowledge), कर्म (Action), और कर्ता (The Doer)—इन तीनों के भी मुख्य रूप से तीन-तीन प्रकार ही बताए गए हैं।
            सांख्य शास्त्र (वेदांत के विज्ञान) में इन गुणों की बहुत ही गहरी और सटीक गणना (Analysis) की गई है, अब तुम मुझसे उन तीनों के अलग-अलग प्रकारों को बिल्कुल उसी तरह (यथावत्) ध्यानपूर्वक सुनो।
            भगवान श्रीकृष्ण अब अपने इस मनोवैज्ञानिक विश्लेषण (Psychological Analysis) को सबसे गहरे और एडवांस्ड लेवल (Advanced level) पर लेकर जा रहे हैं।
            वे अर्जुन को समझाते हैं कि इस दुनिया में हर इंसान का 'ज्ञान' एक जैसा नहीं होता; एक आतंकवादी का ज्ञान और एक संत का ज्ञान बिल्कुल अलग लेवल का होता है।
            उसी तरह, एक डॉक्टर का ऑपरेशन (कर्म) और एक हत्यारे का चाकू मारना (कर्म) बाहर से एक जैसा लग सकता है, लेकिन उनके पीछे के गुण और नीयत ज़मीन-आसमान का फर्क रखते हैं।
            और जो 'कर्ता' (काम करने वाला इंसान) है, वह भी कोई एक फिक्स (Fixed) रोबोट नहीं है; उसका बर्ताव भी सत्त्व, रजस या तमस के हिसाब से पूरी तरह बदल जाता है।
            दुनिया की हर चीज़ इन तीन गुणों की फैक्ट्री (Factory) में प्रोसेस (Process) होकर ही बाहर आती है, इसलिए किसी भी इंसान को जज (Judge) करने से पहले उसके गुणों को देखना बहुत ज़रूरी है।
            भगवान कहते हैं कि सांख्य योग (The Philosophy of analytical study) ने इस सब्जेक्ट (Subject) पर बहुत ही तगड़ी और साइंटिफिक रिसर्च (Scientific Research) की है।
            अब मैं तुम्हें बिना किसी मिलावट के वह असली और टॉप-सीक्रेट (Top-secret) डेटाबेस खोलकर बताऊँगा जिससे तुम इंसान के दिमाग को एक खुली किताब की तरह पढ़ सकोगे।
            यह श्लोक आगे आने वाले 6 श्लोकों का एक बहुत ही ज़बरदस्त ट्रेलर (Trailer) है जहाँ इंसान की पूरी पर्सनालिटी (Personality) का कच्चा-चिट्ठा दुनिया के सामने खुलेगा।
        """.trimIndent(),
        english = """
            Strictly according to the absolute massive differences found strictly within the three modes of material nature (Sattva Rajas Tamas) knowledge (Jnanam) action (Karma) and the doer (Karta) are exclusively and mathematically categorized into exactly three distinct types.
            In the highly elite and flawless analytical science of Sankhya philosophy these specific modes have been ruthlessly and accurately computed and defined; now please listen with titanium focus as I aggressively describe all of them to you exactly as they truly are (Yathavat).
            Lord Sri Krishna is now violently accelerating His spectacular psychological analysis actively elevating it to the absolute most profound and highly advanced quantum level of understanding.
            He scientifically explains to Arjuna that in this massive chaotic matrix absolutely no two humans possess identical 'Knowledge'; the dark twisted logic of a cosmic terrorist operates on a fundamentally radically different frequency than the blinding pure wisdom of an enlightened saint.
            Similarly the physical action of an elite surgeon executing a life-saving operation (Karma) and the brutal stabbing executed by a bloodthirsty assassin (Karma) might externally visually appear identical but their internal underlying modes and core intentions are separated by infinite cosmic light-years.
            And the 'Doer' (the ambitious human executing the work) is absolutely not a generic rigidly fixed biological robot; his daily behavioral output violently mutates and heavily fluctuates strictly depending on whether he is hijacked by goodness passion or ignorance.
            Absolutely everything in the entire multiverse is relentlessly processed directly through the massive cosmic factory of these three modes; therefore before you arrogantly judge any entity you must strictly audit his underlying operating algorithm.
            The Lord officially declares that the elite Sankhya Yoga (the absolute supreme philosophy of analytical study) has already executed highly rigorous flawless scientific research heavily decoding this exact complex subject matter.
            Now I shall aggressively and flawlessly unlock and download that unadulterated highly classified top-secret universal database directly into your brain enabling you to effortlessly read any human mind exactly like an open book.
            This spectacular verse effectively functions as an incredibly explosive blockbuster 'Trailer' heavily setting the stage for the upcoming 6 verses where the absolute complete psychological blueprint of human personality will be brutally exposed to the world.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            सर्वभूतेषु येनैकं भावमव्ययमीक्षते |
            अविभक्तं विभक्तेषु तज्ज्ञानं विद्धि सात्त्विकम् || २० ||
        """.trimIndent(),
        hindi = """
            (श्लोक 20 से 22 तक ज्ञान के तीन प्रकार बताए गए हैं)
            जिस 'ज्ञान' के द्वारा इंसान इस दुनिया के सभी अलग-अलग दिखने वाले जीवों (विभक्तेषु) के भीतर उस एक ही अविनाशी और न बंटे हुए (अविभक्तं) आध्यात्मिक तत्त्व (परमात्मा/आत्मा) को देखता है।
            तुम यह पक्का समझ लो कि केवल उसी अखंड और परम पवित्र दृष्टि को ही वास्तव में 'सात्त्विक ज्ञान' (Sattvic Knowledge) कहा जाता है।
            यह श्लोक 'द अल्टीमेट सुप्रीम विज़न' (The Ultimate Supreme Vision) की सबसे परफेक्ट और सबसे शक्तिशाली डेफिनेशन (Definition) दुनिया को देता है।
            हम अपनी इन साधारण आँखों से दुनिया को देखते हैं, तो हमें कोई काला, कोई गोरा, कोई अमीर, कोई गरीब, कोई जानवर और कोई इंसान दिखाई देता है (विभक्तं / Divided)।
            लेकिन जब किसी इंसान के भीतर 'सात्त्विक ज्ञान' का सॉफ्टवेयर पूरी तरह से इंस्टॉल (Install) हो जाता है, तो उसकी आँखों में एक 'डिवाइन एक्स-रे' (Divine X-Ray) फिट हो जाता है।
            उसे फिर यह बाहरी 'चमड़ी' या 'जाति-पाति' का भेदभाव बिल्कुल दिखाई नहीं देता; उसे एक कुत्ते में, एक भिखारी में और एक राजा में भी वो 'एक ही' (एकं) भगवान की शक्ति साफ चमकती हुई दिखाई देती है।
            उसे यह 100% पक्का पता चल जाता है कि ये सारे अलग-अलग शरीर केवल बाहर के प्लास्टिक कवर (Plastic Cover) हैं, लेकिन सबके अंदर की जो बैटरी (Battery / आत्मा) है, वो बिल्कुल एक जैसी और 'अव्यय' (Unbreakable) है।
            यह ज्ञान इंसान के अंदर से नफरत, ईर्ष्या और लड़ाई-झगड़े के सारे वायरसों को एक सेकंड में डिलीट कर देता है और उसे सबसे प्यार करना सिखा देता है।
            जिस इंसान के पास यह 'विजन ऑफ यूनिटी' (Vision of Unity / एकता का ज्ञान) है, केवल वही इस दुनिया में असली ज्ञानी और सबसे बड़ा साइंटिस्ट (Scientist) है।
            बाकी सारी डिग्रियां और किताबी पढ़ाई इसके सामने बिल्कुल जीरो और कचरा हैं, क्योंकि वो इंसान को बांटना सिखाती हैं, जबकि सात्त्विक ज्ञान सबको जोड़ता है।
        """.trimIndent(),
        english = """
            (Verses 20 through 22 meticulously categorize the three absolute specific modes of Knowledge)
            That supreme specific 'Knowledge' by which one flawlessly and clearly perceives one single undivided imperishable and indestructible spiritual nature (Avyayam) existing equally within all massive and countless divided living entities (Vibhakteshu).
            You must definitively internally understand and mathematically conclude that this absolute unbroken and supremely pure cosmic vision is officially exclusively designated as knowledge strictly in the mode of goodness (Sattvic Jnanam).
            This phenomenal verse delivers the absolute most perfect terrifyingly powerful and flawless definition of 'The Ultimate Supreme Cosmic Vision' to the entire human race.
            When ignorant mortals casually scan the matrix utilizing their fragile biological retinas they pathetically only perceive massive superficial divisions—someone is black another white one is a billionaire another a starving beggar an animal or an elite human (Vibhaktam / Divided).
            But the exact microsecond the elite high-frequency software of 'Sattvic Knowledge' is flawlessly installed and fully booted up inside a human's brain a literal 'Divine Spiritual X-Ray' is permanently violently integrated into his optical nerves.
            He becomes biologically and mathematically blind to all pathetic superficial discrimination based on external biological skin or toxic caste systems; he explicitly and blazingly perceives the exact 'Same' (Ekam) identical divine energy of God shining vibrantly inside a stray dog a crippled beggar and an elite king.
            He possesses the titanium 100% absolute scientific conviction that all these billions of drastically different physical bodies are literally nothing but cheap external biological plastic covers while the internal eternal battery (the Soul) powering all of them is flawlessly identical and 'Avyaya' (Unbreakable).
            This staggering supreme knowledge instantaneously brutally deletes every single toxic virus of hatred violent jealousy and petty racial conflict from his psychological hard drive effortlessly teaching his heart to unconditionally love all existence.
            Any human who has successfully downloaded this 'Vision of Absolute Unity' is mathematically the absolute only genuine intellectual and the greatest elite cosmic scientist alive in this entire matrix.
            Every other massive university PhD or elite academic degree is officially rendered absolutely zero and pathetic garbage compared to this because worldly data aggressively teaches humanity to bitterly divide itself whereas Sattvic Knowledge violently unifies the entire multiverse into one single heartbeat.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            पृथक्त्वेन तु यज्ज्ञानं नानाभावान्पृथग्विधान् |
            वेत्ति सर्वेषु भूतेषु तज्ज्ञानं विद्धि राजसम् || २१ ||
        """.trimIndent(),
        hindi = """
            परंतु जिस ज्ञान के कारण इंसान इस दुनिया के सभी अलग-अलग प्राणियों (सर्वेषु भूतेषु) में केवल भिन्न-भिन्न प्रकार के (नानाभावान्) जीवों को ही अलग-अलग (पृथक्त्वेन) रूप से देखता है।
            यानी जो ज्ञान इंसान को हर शरीर के भीतर एक अलग और कटी हुई आत्मा या सत्ता (Entity) ही दिखाता है, तुम उस भेद-भाव से भरे हुए ज्ञान को 'राजसिक ज्ञान' समझो।
            यह श्लोक आज की दुनिया के 99% लोगों की 'नॉर्मल साइकोलॉजी' (Normal Psychology) और उनके घमंडी ज्ञान का बिल्कुल नंगा और सटीक एक्स-रे है।
            राजसिक इंसान का दिमाग 'एकता' (Unity) को प्रोसेस (Process) ही नहीं कर सकता; उसका दिमाग हमेशा चीज़ों को 'टुकड़ों' (Pieces) में बाँट कर देखने के लिए प्रोग्राम्ड (Programmed) होता है।
            वह जब किसी इंसान को देखता है, तो उसकी नज़र सीधी उसके कपड़ों, उसकी बैंक-बैलेंस, उसकी जाति या उसके देश पर जाती है।
            वह सोचता है कि "मैं एक सुपीरियर (Superior) इंसान हूँ, वो आदमी मेरा दुश्मन है, और यह जानवर तो केवल मेरे खाने या इस्तेमाल के लिए ही पैदा हुआ है।"
            उसे यह बिल्कुल भी दिखाई नहीं देता कि इन सब अलग-अलग शरीरों के पीछे एक ही ईश्वर की शक्ति काम कर रही है; उसके लिए हर शरीर एक अलग और आज़ाद मशीन है।
            यह राजसिक ज्ञान इंसान के अंदर 'सुपीरियरिटी कॉम्प्लेक्स' (Superiority Complex) और ईर्ष्या का भयंकर ज़हर भर देता है जिससे दुनिया में सारे युद्ध और झगड़े पैदा होते हैं।
            आजकल की जितनी भी भारी-भरकम पॉलिटिकल (Political) और सामाजिक डिग्रियां हैं, वे ज़्यादातर इसी राजसिक ज्ञान को बढ़ावा देती हैं क्योंकि वे हमें केवल 'फर्क' (Differences) देखना सिखाती हैं।
            भगवान अर्जुन को वार्निंग (Warning) दे रहे हैं कि यह ज्ञान इंसान को शांति नहीं देता, बल्कि उसे हमेशा स्ट्रेस और दूसरों से आगे निकलने की अंधी दौड़ में फँसाए रखता है।
        """.trimIndent(),
        english = """
            But that specific heavily flawed knowledge by which a human exclusively and obsessively perceives nothing but entirely different countless types of distinct living entities (Nana-bhavan) existing separately across all biological bodies (Sarveshu bhuteshu).
            Meaning the toxic knowledge that forcefully programs a human to hallucinate that inside every single physical body resides a completely isolated disconnected and entirely independent entity; you must definitively mathematically understand this divisive discriminatory worldview as knowledge strictly in the mode of passion (Rajasic Jnanam).
            This spectacular verse executes a brutally naked highly precise and clinical X-Ray perfectly diagnosing the absolute 'Normal Psychology' and toxic arrogant worldview currently infecting 99% of the modern global population.
            The overheated brain of a passionate Rajasic human is biologically and mathematically incapable of processing the elite concept of cosmic 'Unity'; his pathetic corrupted software is permanently hardwired strictly to aggressively slice reality into fractured broken 'Pieces'.
            When he visually scans another human entity his highly degraded optical nerves instantly brutally lock onto the person's expensive luxury clothes his offshore bank-balance his toxic social caste or his specific national flag.
            His bloated false ego arrogantly calculates "I am a vastly superior elite entity that specific man is my mortal enemy and this pathetic animal was biologically engineered explicitly solely for my personal consumption and brutal exploitation."
            He is completely and horrifyingly blind to the absolute cosmic truth that the exact same singular supreme divine energy is flawlessly orchestrating all these drastically different biological vehicles; to his corrupted mind every body is a wildly disconnected isolated machine.
            This lethal Rajasic knowledge aggressively injects the terrifying venom of a massive 'Superiority Complex' and violent jealousy directly into a human's veins which acts as the absolute root cause generating every single catastrophic war and petty global conflict on earth.
            The vast majority of modern massively expensive political and elite social academic degrees heavily promote and heavily fund this exact toxic Rajasic knowledge because they systematically aggressively train humanity to exclusively obsess over superficial 'Differences' rather than spiritual core unity.
            The Supreme Lord is issuing Arjuna a massive titanium warning klaxon loudly declaring that this specific passionate knowledge absolutely mathematically never yields any genuine peace; it merely relentlessly traps the mortal inside a highly stressful blind rat race desperately fighting to crush everyone else.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            यत्तु कृत्स्नवदेकस्मिन्कार्ये सक्तमहैतुकम् |
            अतत्त्वार्थवदल्पं च तत्तामसमुदाहृतम् || २२ ||
        """.trimIndent(),
        hindi = """
            और जो ज्ञान इंसान को बिना किसी लॉजिक या तर्क (अहैतुकम्) के किसी एक ही तुच्छ काम या शरीर में पागलों की तरह ऐसे फँसा देता है (सक्तम्) मानो वही सब कुछ (कृत्स्नवत्) हो।
            जो ज्ञान सच्चाई और परम तत्त्व के अर्थ से पूरी तरह खाली होता है (अतत्त्वार्थवत्) और जो बहुत ही छोटी, संकीर्ण और नीच सोच वाला (अल्पं) होता है, उस घोर अंधेरे ज्ञान को 'तामसिक ज्ञान' कहा गया है।
            यह श्लोक दुनिया की सबसे खतरनाक 'अंधभक्ति', कट्टरवाद (Fanaticism) और घोर अज्ञानता का सबसे बड़ा साइंटिफिक और मनोवैज्ञानिक पर्दाफाश है।
            तामसिक इंसान का दिमाग एक बहुत ही छोटे से अंधेरे कुएं की तरह होता है; वह दुनिया के विशाल सच को देखने और समझने की क्षमता ही खो चुका होता है।
            वह किसी एक पत्थर की मूर्ति, किसी एक पाखंडी बाबा, या अपने ही भौतिक शरीर को भगवान मानकर उसी से पागलों की तरह चिपक जाता है और सोचता है कि बस यही पूरी दुनिया है।
            उसके पास अपने इस 'अंधे विश्वास' को सही साबित करने के लिए कोई भी लॉजिक, साइंस या शास्त्रों का प्रमाण नहीं होता (अहैतुकम्), वह बस ज़िद पर अड़ा रहता है।
            वह इंसान इतना 'अल्प' (Narrow-minded) हो जाता है कि अगर कोई उसे सच्चाई बताने की कोशिश करे, तो वह उस पर हमला कर देता है क्योंकि उसका दिमाग कुछ नया प्रोसेस ही नहीं कर सकता।
            ऐसे लोग दुनिया की उन गंदी और खौफनाक मान्यताओं के शिकार हो जाते हैं जो इंसानों की बलि देने या जानवरों को बेरहमी से मारने को ही अपना सबसे बड़ा धर्म मान बैठते हैं।
            इस ज्ञान में न तो कोई 'सच्चाई' (तत्त्वार्थ) है और न ही कोई आध्यात्मिक रोशनी; यह इंसान को जानवर से भी नीचे गिरा कर एक मूर्ख ज़ोंबी (Zombie) बना देता है।
            भगवान श्रीकृष्ण ऐसे ज्ञान को पूरी तरह से 'कचरा' (Garbage) और इंसान की सबसे बड़ी बर्बादी का सर्टिफिकेट (Certificate) घोषित करते हैं।
        """.trimIndent(),
        english = """
            And that highly degraded blind knowledge which irrationally and insanely attaches a human strictly to one single trivial kind of work or temporary biological body as if it were the absolute entirety of existence (Kritsna-vat saktam).
            Which operates completely devoid of absolutely any rational logic scientific reasoning or scriptural cause (Ahaitukam) entirely empty of any genuine perception of the absolute truth (Atattvartha-vat) and which is pathetically microscopic narrow and extremely meager (Alpam); that terrifying darkness is officially universally declared to be knowledge in the mode of ignorance (Tamasic).
            This phenomenal verse executes the absolute greatest most violent scientific and psychological expose completely ripping the mask off the world's most terrifyingly dangerous 'Blind Faith' extreme fanaticism and toxic hardcore ignorance.
            The heavily corrupted biological brain of a Tamasic human operates exactly like a microscopic suffocating pitch-black well; his psychological hardware has permanently lost the fundamental cosmic capacity to perceive process or comprehend the vast staggering reality of the multiverse.
            He toxically aggressively super-glues his entire pathetic existence to one random block of stone a highly corrupt hypocritical cult leader or merely his own rotting biological physical body arrogantly hallucinating and obsessing that this tiny fragment is the absolute totality of the cosmos.
            He possesses mathematically absolute zero rational logic elite science or authentic scriptural evidence (Ahaitukam) to defend or justify his blinding toxic belief system; he survives entirely on sheer violent animalistic stubbornness.
            This human becomes so horrifically 'Alpam' (Dangerously Narrow-Minded and microscopic in thought) that if an enlightened master attempts to mercifully download the cosmic truth into his brain he violently attacks the master because his crashed software simply cannot process any new advanced data.
            Such heavily degraded entities instantly become the prime pathetic victims of the world's most filthy horrific and dark cult ideologies violently hallucinating that executing human sacrifices or brutally slaughtering innocent animals is the absolute highest pinnacle of their fake religion.
            Inside this toxic garbage there exists mathematically zero 'Truth' (Tattvartha) and absolutely zero microscopic traces of transcendental spiritual illumination; it merely violently downgrades the human far below the level of a primitive predator mutating him into a brainless biological Zombie.
            Lord Sri Krishna aggressively completely officially condemns this specific fake knowledge as absolute toxic 'Garbage' legally certifying it as the absolute primary weapon guaranteed to execute the total catastrophic destruction of the human soul.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            नियतं सङ्गरहितमरागद्वेषतः कृतम् |
            अफलप्रेप्सुना कर्म यत्तत्सात्त्विकमुच्यते || २३ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 23 से 25 तक कर्म के तीन प्रकार बताए गए हैं)
            जो कर्म शास्त्रों द्वारा नियत (ज़रूरी / Duty) किया गया हो, जिसे पूरी तरह से आसक्ति और अहंकार से मुक्त होकर (सङ्गरहितम्) किया जाता है।
            और जो कर्म किसी भी प्रकार के राग (प्यार/अटैचमेंट) या द्वेष (नफरत/गुस्से) से पूरी तरह आज़ाद रहकर बिल्कुल शांत मन से किया गया हो।
            तथा जिसे करने वाले इंसान के मन में उस काम के भविष्य के फलों (अवार्ड/पैसे) को पाने की ज़रा सी भी लालसा या इच्छा न हो (अफलप्रेप्सुना)।
            उस प्रकार के 100% शुद्ध और परफेक्शन (Perfection) के साथ किए गए ड्यूटी को ही वास्तव में 'सात्त्विक कर्म' कहा जाता है।
            भगवान यहाँ इंसान के काम करने के तरीके (Work Ethic) का वो 'गोल्ड स्टैंडर्ड' (Gold Standard) दे रहे हैं जिसे हासिल करना एक योगी का सबसे बड़ा सपना होता है।
            सात्त्विक काम का मतलब यह नहीं है कि आप दिन भर बैठकर केवल माला जप रहे हैं; अगर आप एक डॉक्टर हैं और पूरी ईमानदारी से मरीज़ की जान बचा रहे हैं, तो वो भी सात्त्विक कर्म है।
            लेकिन शर्त यह है कि वो काम 'ड्यूटी' (नियत) होना चाहिए, उसे करते हुए आपके अंदर यह घमंड नहीं आना चाहिए कि "मैं बहुत महान हूँ।"
            जब आप काम कर रहे हों, तो आपका दिमाग एक रोबोट की तरह 100% न्यूट्रल (Neutral) होना चाहिए; न तो काम से बहुत ज़्यादा प्यार (राग) हो और न ही उस काम से चिढ़ (द्वेष) हो।
            और सबसे बड़ी बात, आपका सारा फोकस (Focus) केवल उस काम को 'परफेक्ट' (Perfect) बनाने पर होना चाहिए, न कि महीने के अंत में मिलने वाले 'बोनस' या 'तारीफ' पर।
            जिस इंसान ने अपने ऑफिस या युद्ध के मैदान में काम करने का यह 'सात्त्विक हैक' (Sattvic Hack) सीख लिया, वह दुनिया के किसी भी स्ट्रेस (Stress) या डिप्रेशन का शिकार कभी नहीं हो सकता।
        """.trimIndent(),
        english = """
            (Verses 23 through 25 scientifically classify the three absolute specific modes of physical Action)
            That exact specific action which is strictly regulated and officially prescribed as a mandatory duty by the scriptures (Niyatam) and which is executed completely entirely devoid of any toxic psychological attachment or false ego (Sanga-rahitam).
            And which is flawlessly performed maintaining absolute titanium neutrality remaining 100% free from any binding love or blinding passionate attachment (Raga) as well as any explosive hatred or violent aversion (Dveshatah).
            Furthermore the action must be fiercely executed by an elite human whose brain harbors absolutely zero microscopic craving or toxic greedy expectation for the future fruitive results or material payouts (Aphala-prepsuna).
            That specific 100% unadulterated flawlessly executed massive physical duty is officially and universally categorized by elite sages as action in the absolute mode of goodness (Sattvic Karma).
            The Supreme Lord is officially downloading the absolute ultimate 'Gold Standard' of human 'Work Ethic' and cosmic productivity which remains the highest desperate dream for any elite Yogi to flawlessly master.
            Sattvic action absolutely does not imply that you lazily sit in a dark cave silently chanting on beads all day; if you are an elite battlefield surgeon relentlessly saving dying lives with 100% pure integrity that brutal hustle is officially Sattvic karma.
            However the absolute titanium condition is that the action must be your authorized 'Duty' (Niyatam) and while sweating blood executing it your brain must absolutely never become infected with the arrogant toxic virus screaming "I am the supreme savior here."
            While your biological machine operates at maximum capacity your internal psychological software must remain perfectly neutral exactly like a high-tech AI robot; exhibiting zero passionate infatuation (Raga) and absolutely zero resentful disgust (Dvesha) toward the grueling task.
            And most critically 100% of your laser-focused massive bandwidth must be dedicated exclusively toward executing the task with absolute flawless 'Perfection' violently deleting any pathetic craving for the end-of-month financial 'Bonus' or cheap global applause.
            Any human who successfully installs and runs this ultimate 'Sattvic Hack' while aggressively dominating his corporate office or a bloody battlefield mathematically guarantees he will absolutely never ever become a pathetic victim of toxic stress anxiety or clinical depression.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            यत्तु कामेप्सुना कर्म साहङ्कारेण वा पुनः |
            क्रियते बहुलायासं तद्राजसमुदाहृतम् || २४ ||
        """.trimIndent(),
        hindi = """
            परंतु जो कर्म अपनी भयंकर और कभी न खत्म होने वाली भौतिक इच्छाओं और वासनाओं (कामेप्सुना) को पूरा करने की नीयत से बहुत ही लालच के साथ किया जाता है।
            या फिर जो काम अपने झूठे घमंड और बहुत बड़े अहंकार (साहङ्कारेण) को दुनिया के सामने दिखाने और साबित करने के लिए किया जाता है।
            और जिस काम को पूरा करने में इंसान को बहुत ही ज़्यादा शारीरिक और मानसिक ज़ोर, भयंकर थकावट और भारी मेहनत (बहुलायासं) करनी पड़ती है।
            तुम यह पक्का जान लो कि इस प्रकार के स्वार्थी, घमंडी और स्ट्रेस से भरे हुए कर्म को ही शास्त्रों में 'राजसिक कर्म' (Rajasic Karma) कहा गया है।
            यह श्लोक आज के 'हसल कल्चर' (Hustle Culture) और कॉर्पोरेट दुनिया के उस कड़वे सच का सबसे परफेक्ट एक्स-रे है जहाँ इंसान मशीन बन चुका है।
            राजसिक इंसान कोई भी काम इसलिए नहीं करता कि वह उसकी ड्यूटी है या उससे समाज का भला होगा; वह 24 घंटे केवल अपना बैंक बैलेंस और अपनी पावर बढ़ाने के लिए खून-पसीना एक करता है।
            उसके हर एक्शन के पीछे उसका वो सड़ा हुआ ईगो (Ego) बोल रहा होता है कि "मैं इस दुनिया का सबसे बड़ा बॉस हूँ और मैं सबको अपनी औकात दिखा दूंगा।"
            इस गंदे अहंकार और पैसे की भूख के कारण वह इंसान जो भी काम शुरू करता है, वह काम उसके लिए 'बहुलायासं' यानी एक बहुत बड़ा सिरदर्द और भयंकर बोझ बन जाता है।
            वह अपनी नींद, अपनी शांति और अपनी हेल्थ को पूरी तरह बर्बाद करके पागलों की तरह उस काम को खींचता है, लेकिन उसे अंदर से कभी भी रत्ती भर सुकून नहीं मिलता।
            भगवान कहते हैं कि जिस काम में इतना ज़्यादा टॉक्सिक स्ट्रेस (Toxic Stress) और अहंकार भरा हो, वह काम इंसान को सफलता की बजाय केवल हार्ट-अटैक (Heart Attack) और डिप्रेशन ही दे सकता है।
        """.trimIndent(),
        english = """
            But that specific aggressive action which is heavily heavily fueled and initiated purely out of an insatiable toxic craving to desperately gratify intense materialistic lusts and endless bodily desires (Kamepsuna).
            Or that massive endeavor which is violently orchestrated strictly by a human heavily intoxicated with a bloated massive false ego (Sahankarena) purely to desperately showcase and forcefully prove his fake supremacy to the world.
            And the execution of which mathematically demands an absolutely agonizing amount of severe physical strain terrifying mental stress brutal exhaustion and immense bone-crushing labor (Bahulayasam).
            You must definitively clinically understand and absolutely conclude that this highly toxic selfish and violently stressful type of physical activity is officially designated as action in the mode of passion (Rajasic Karma).
            This spectacular verse acts as the absolute most flawless high-definition X-Ray brutally exposing the toxic reality of modern 'Hustle Culture' and the cutthroat corporate matrix where humans have successfully mutated into pathetic biological machines.
            A passionate Rajasic human absolutely never executes a massive project because it is his noble duty or because it elevates global society; he ruthlessly sweats blood 24/7 strictly and exclusively to exponentially multiply his offshore bank accounts and aggressive political power.
            Operating relentlessly behind every single micro-action he executes is his rotting toxic Ego violently screaming "I am the absolute supreme boss of this entire planet and I will ruthlessly crush everyone to force them to acknowledge my elite status."
            Strictly due to this filthy horrific arrogance and unquenchable thirst for cheap paper money absolutely every single project he initiates instantly mutates into 'Bahulayasam'—a massive terrifying migraine and an agonizing biological burden crushing his soul.
            He brutally and willingly sacrifices his deep sleep his mental peace and his entire biological health wildly dragging that toxic project to completion like a maniac yet mathematically he absolutely never experiences even a microsecond of genuine internal peace.
            The Supreme Lord explicitly decrees that any massive endeavor heavily polluted with such extreme densities of toxic stress and blinding arrogance is mathematically guaranteed to generate absolutely nothing but severe heart attacks and clinical depression instead of any true success.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            अनुबन्धं क्षयं हिंसामनपेक्ष्य च पौरुषम् |
            मोहादारभ्यते कर्म यत्तत्तामसमुच्यते || २५ ||
        """.trimIndent(),
        hindi = """
            जो कर्म भविष्य में होने वाले उसके भयंकर परिणामों और बंधनों (अनुबन्धं) के बारे में बिल्कुल भी सोचे-समझे बिना एक अंधेपन के साथ शुरू किया जाता है।
            जिस काम को करने से अपना या दूसरों का बहुत भारी नुकसान (क्षय) होता है और जिसमें बहुत बड़े स्तर की शारीरिक या मानसिक हिंसा (Violence) शामिल होती है।
            और जो काम इंसान अपनी खुद की औकात और अपनी शारीरिक/मानसिक क्षमता (पौरुषम्) को बिल्कुल भी चेक (Check) किए बिना शुरू कर देता है।
            केवल और केवल अपने घोर अज्ञान, भ्रम और पागलपन (मोहात्) के नशे में आकर शुरू किए गए उस खौफनाक काम को ही 'तामसिक कर्म' (Tamasic Karma) कहा जाता है।
            भगवान यहाँ दुनिया के सबसे घटिया, विनाशकारी और बेवकूफी भरे कामों का पूरा का पूरा साइंटिफिक और मनोवैज्ञानिक ब्लूप्रिंट (Blueprint) दुनिया के सामने रख रहे हैं।
            तामसिक इंसान का दिमाग इतना करप्ट (Corrupt) और अंधा हो चुका होता है कि वह कोई भी काम शुरू करने से पहले एक सेकंड के लिए भी यह नहीं सोचता कि "इसका फाइनल रिज़ल्ट क्या होगा?"
            वह नशे में, गुस्से में या अपनी झूठी ज़िद में आकर ऐसे प्रोजेक्ट्स या लड़ाइयां शुरू कर देता है जिससे उसका अपना बैंक-बैलेंस, उसकी हेल्थ और दूसरों की ज़िंदगी पूरी तरह तबाह (क्षय) हो जाती है।
            उसके काम में किसी न किसी जीव को भयंकर दर्द (हिंसा) जरूर पहुँचता है, चाहे वह जानवरों को काटना हो या इंसानों को धोखा देना हो।
            सबसे बड़ी मूर्खता यह है कि वह अपनी हैसियत (पौरुष) से बहुत बड़े पंगे ले लेता है—जैसे जेब में 100 रुपये न हों और वह करोड़ों का कर्ज़ा लेकर जुआ खेल दे।
            भगवान श्रीकृष्ण ऐसे मूर्खतापूर्ण और विनाशकारी कर्मों को इंसान की 'सुसाइडल टेंडेंसी' (Suicidal Tendency) मानते हैं जो सीधा उसे और समाज को नर्क के सबसे गहरे और गंदे गड्ढे में धकेल देती है।
        """.trimIndent(),
        english = """
            That specific horrific action which is blindly and aggressively initiated without maintaining even a microscopic trace of rational consideration regarding its terrifying future karmic consequences and inevitable massive bondage (Anubandham).
            An endeavor which mathematically guarantees the infliction of catastrophic loss total biological ruin and severe destruction of wealth (Kshayam) and which inherently involves executing extreme physical or psychological violence upon others (Himsam).
            And a massive task which a highly deluded human recklessly launches entirely without logically calculating or auditing his own actual physical capabilities or financial limitations (Anapekshya paurusham).
            That terrifying highly destructive and apocalyptic action forcefully launched strictly under the heavy intoxication of sheer absolute madness deep delusion and blinding ignorance (Mohat) is officially unequivocally declared as action in the darkest mode of ignorance (Tamasic).
            The Supreme Lord is explicitly declassifying and presenting the absolute complete scientific and psychological blueprint heavily exposing the world's most degraded catastrophically destructive and monumentally idiotic physical endeavors.
            The biological brain of a Tamasic human is so severely corrupted hacked and blinded that before aggressively launching a massive project he absolutely fails to pause for even one microsecond to logically calculate "What will be the final terrifying cosmic reaction of this endeavor?"
            Heavily intoxicated by toxic substances explosive rage or his own fake stubbornness he blindly initiates apocalyptic wars or toxic projects that mathematically guarantee the absolute total annihilation (Kshayam) of his own health wealth and the precious lives of innocent others.
            His toxic work mandatorily guarantees inflicting horrific agonizing pain and brutal 'Violence' upon some living entity whether it involves ruthlessly slaughtering animals for cheap tongue stimulation or violently scamming innocent humans.
            His absolute greatest peak of blinding stupidity is aggressively picking massive fights far beyond his actual capacity (Paurusham)—exactly like a pathetic mortal possessing zero cash arrogantly borrowing millions from the mafia purely to gamble it away in a casino.
            Lord Sri Krishna mathematically categorizes such wildly idiotic and fiercely destructive actions exactly as lethal 'Suicidal Tendencies' biologically programmed to violently shove the arrogant fool and his surrounding society directly into the absolute deepest most putrid abyss of hell.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            मुक्तसङ्गोऽनहंवादी धृत्युत्साहसमन्वितः |
            सिद्ध्यसिद्ध्योर्निर्विकारः कर्ता सात्त्विक उच्यते || २६ ||
        """.trimIndent(),
        hindi = """
            जो कर्ता कर्मों की आसक्ति से पूरी तरह मुक्त है और जिसके भीतर झूठे अहंकार का बिल्कुल भी कोई नामोनिशान नहीं है।
            जो इंसान अपना काम करते समय अत्यंत धैर्य और एक कभी न टूटने वाले भयंकर उत्साह से हमेशा पूरी तरह भरा रहता है।
            और जो काम के पूरी तरह सफल होने या उसके बुरी तरह से फेल हो जाने पर भी बिल्कुल एक समान और शांत रहता है।
            उस प्रकार के अत्यंत श्रेष्ठ और अजेय मानसिकता वाले काम करने वाले इंसान को ही शास्त्रों में 'सात्त्विक कर्ता' कहा गया है।
            भगवान यहाँ एक परफेक्ट वर्कर या एक सच्चे कर्मयोगी का दुनिया का सबसे बेहतरीन और साइंटिफिक ब्लूप्रिंट दे रहे हैं।
            सात्त्विक इंसान जब कोई बड़ा प्रोजेक्ट शुरू करता है तो वह हारने के डर से नहीं कांपता और न ही जीतने की खुशी में पागल होता है।
            उसका पूरा फोकस केवल अपने काम के परफेक्शन पर होता है और वह उस काम में अपनी पूरी जान और अपनी सौ प्रतिशत एनर्जी डाल देता है।
            वह कभी यह ढिंढोरा नहीं पीटता कि यह सब मैंने किया है क्योंकि उसका ईगो पूरी तरह से खत्म होकर ईश्वर को समर्पित हो चुका होता है।
            चाहे दुनिया उसे गालियां दे या उसकी तारीफ करे वह एक साइलेंट मशीन की तरह अपने कर्तव्य के रास्ते पर बिना रुके चलता रहता है।
            यही वो सबसे शक्तिशाली और अल्टीमेट माइंडसेट है जो इंसान को दुनिया में कभी भी हारने या मानसिक रूप से टूटने नहीं देता।
        """.trimIndent(),
        english = """
            The elite worker who is completely unconditionally liberated from all toxic material attachments and entirely devoid of any false ego.
            Who executes his daily prescribed duties heavily armed with titanium determination and an explosive unbreakable enthusiastic energy.
            And who remains flawlessly neutral emotionally unshakeable and totally balanced in both massive success and catastrophic failure.
            Such a highly advanced invincible and fiercely disciplined worker is officially universally categorized as a doer in the mode of goodness.
            The Supreme Lord is officially releasing the absolute ultimate psychological blueprint of the perfect flawless worker and genuine Karma Yogi.
            When a Sattvic human initiates a massive project he absolutely does not tremble with a paralyzing fear of failure nor does he become wildly intoxicated by success.
            His entire vast cognitive bandwidth is heavily locked strictly onto executing the task with absolute mathematical perfection pouring his vital energy into it.
            He absolutely never arrogantly broadcasts to the world screaming that he is the supreme genius because his toxic false ego has been permanently assassinated.
            Whether society ruthlessly hurls brutal insults or blindly showers him with massive applause he functions exactly like a silent unstoppable titanium machine.
            This is the absolute most scientific and ultimate mindset mathematically guaranteed to permanently immunize a human against burnout and defeat in the corporate matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            रागी कर्मफलप्रेप्सुर्लुब्धो हिंसात्मकोऽशुचिः |
            हर्षशोकान्वितः कर्ता राजसः परिकीर्तितः || २७ ||
        """.trimIndent(),
        hindi = """
            जो कर्ता कर्मों में बहुत अधिक फँसा हुआ है और जो अपने हर कर्म के बदले बहुत बड़े फल या मुनाफे की इच्छा मन में रखता है।
            जो इंसान स्वभाव से बहुत लालची और कंजूस है तथा दूसरों को नुकसान पहुँचाने या हिंसा करने से बिल्कुल भी नहीं कतराता है।
            जो अंदर और बाहर से पूरी तरह अपवित्र है तथा जो काम के सफल होने पर बहुत खुश और फेल होने पर भयंकर दुखी होता है।
            इस प्रकार के अत्यधिक स्वार्थी और स्ट्रेस से भरे हुए इंसान को ही वेदों और शास्त्रों में 'राजसिक कर्ता' कहकर पुकारा गया है।
            यह श्लोक आज के भौतिकवादी और अत्यधिक लालची समाज का एक बहुत ही परफेक्ट सटीक और कड़वा मनोवैज्ञानिक आईना है।
            राजसिक इंसान ऑफिस या बिज़नेस में काम तो बहुत करता है लेकिन उसका दिमाग चौबीस घंटे केवल पैसे और अपनी तरक्की पर अटका रहता है।
            वह अपने फायदे के लिए किसी को भी धोखा देने या कुचलने के लिए हमेशा तैयार रहता है क्योंकि उसके लिए सफलता ही सबसे बड़ा भगवान है।
            वह अंदर से बहुत डरा हुआ होता है इसलिए जब उसे ज़रा सा भी नुकसान होता है तो वह तुरंत डिप्रेशन में चला जाता है और रोने लगता है।
            उसके जीवन में कोई भी सच्ची मानसिक शांति नहीं होती क्योंकि उसका पूरा कैरेक्टर केवल पैसे की भूख और अहंकार से ही ऑपरेट होता है।
            भगवान ऐसे वर्कर को बहुत ही निचले स्तर का मानते हैं क्योंकि वह खुद को और दुनिया के बाकी इंसानों को केवल एक मशीन समझता है।
        """.trimIndent(),
        english = """
            The worker who is violently attached to his work and constantly desperately hungers to aggressively hoard the fruitive results of his labor.
            Who is extremely greedy highly stingy and absolutely does not hesitate to inflict brutal violence or harm upon others to succeed.
            Who remains highly impure internally and externally and who violently fluctuates between euphoric joy in success and suicidal grief in failure.
            This highly toxic violently stressed and profoundly selfish entity is officially universally categorized as a doer in the mode of passion.
            This phenomenal verse acts as a flawless brutal and totally naked mirror reflecting the highly corrupted reality of modern cutthroat corporate society.
            A passionate human vigorously hustles relentlessly in his business but his overheated brain remains hopelessly chained exclusively to expanding his offshore bank accounts.
            He eagerly betrays crushes and ruthlessly exploits his own colleagues because his corrupted software dictates that acquiring cheap earthly power justifies absolutely any sin.
            He operates entirely out of paralyzing internal fear so when his fragile empire inevitably crashes he instantly plunges into a horrific abyss of dark depression.
            His biological timeline contains mathematically zero true peace because his entire psychological operating system is entirely hijacked by relentless greed and blinding arrogance.
            The Supreme Lord categorizes such a worker as a highly degraded entity because he toxically perceives himself and humanity purely as disposable commercial assets.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            अयुक्तः प्राकृतः स्तब्धः शठो नैष्कृतिकोऽलसः |
            विषादी दीर्घसूत्री च कर्ता तामस उच्यते || २८ ||
        """.trimIndent(),
        hindi = """
            जो कर्ता किसी भी शास्त्र या अनुशासन के नियमों को बिल्कुल नहीं मानता और जो स्वभाव से अत्यंत क्रूर तथा घमंडी और जिद्दी होता है।
            जो इंसान हमेशा दूसरों को धोखा देने में लगा रहता है जो दूसरों का सरेआम अपमान करने में माहिर है और जो बहुत ही ज्यादा आलसी है।
            जो व्यक्ति हमेशा बिना किसी वजह के उदास और दुखी रहता है और जिस काम को आज करना चाहिए उसे महीनों तक टालने की भयंकर बीमारी से पीड़ित है।
            उस अत्यंत अज्ञानी खतरनाक और मूर्ख इंसान को ही वास्तव में दुनिया का सबसे नीच यानी 'तामसिक कर्ता' के रूप में परिभाषित किया गया है।
            यह श्लोक उस इंसान का साइकोलॉजिकल एक्स-रे है जिसका पूरा सिस्टम तमोगुण के वायरस से पूरी तरह हैक और करप्ट हो चुका है।
            ऐसा इंसान अपनी ज़िंदगी में कुछ भी अचीव नहीं करना चाहता और वह हमेशा अपनी नाकामियों का सारा इल्जाम दुनिया और भगवान पर डालता है।
            उसका दिमाग इतना सड़ा हुआ होता है कि वह दूसरों को बर्बाद देखकर खुश होता है और खुद कोई मेहनत करने से हमेशा जी चुराता है।
            प्रोक्रैस्टिनेशन यानी काम को टालना उसकी सबसे बड़ी पहचान है वह एक छोटे से काम को पूरा करने में भी अपनी पूरी ज़िंदगी लगा देता है।
            उसके अंदर कोई भी ईश्वरीय प्रेरणा या उम्मीद नहीं होती और वह एक ज़िंदा लाश की तरह अपनी पूरी ज़िंदगी बिना किसी लक्ष्य के बर्बाद कर देता है।
            भगवान अर्जुन को बहुत ही कड़े शब्दों में सावधान कर रहे हैं कि ऐसे इंसान से हमेशा दूर रहना चाहिए क्योंकि वह खुद भी डूबता है और सबको डुबा देता है।
        """.trimIndent(),
        english = """
            The worker who aggressively defies all scriptural injunctions operating completely without discipline and who is violently stubborn and deeply malicious.
            Who is a chronic toxic deceiver highly expert at brutally insulting others and heavily infected with paralyzing chronic biological laziness.
            Who remains perpetually morose violently depressed and suffers from the severe lethal disease of indefinitely procrastinating urgent mandatory tasks.
            That incredibly ignorant highly degraded and foolish mortal is officially clinically defined as a doer strictly in the darkest mode of ignorance.
            This spectacular verse provides a flawless psychological X-Ray of a human entity whose entire operating system has been catastrophically hijacked by the Tamasic virus.
            Such a pathetic individual possesses absolutely zero drive to achieve any greatness perpetually hurling toxic blame at society and God for his own miserable failures.
            His corrupted brain is so fundamentally rotting that he extracts sick joy from witnessing others suffer while violently refusing to sweat or work hard himself.
            Severe toxic procrastination is his absolute defining physical symptom he stretches a simple one-hour biological task into agonizing months of useless pathetic delay.
            He operates completely devoid of any cosmic inspiration or internal hope effectively existing as a breathing corpse violently wasting his precious human timeline.
            The Supreme Lord aggressively warns Arjuna to permanently quarantine himself from such toxic entities because their heavy negative gravity drags everyone down into their abyss.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            बुद्धेर्भेदं धृतेश्चैव गुणतस्त्रिविधं शृणु |
            प्रोच्यमानमशेषेण पृथक्त्वेन धनञ्जय || २९ ||
        """.trimIndent(),
        hindi = """
            हे धनंजय अर्जुन! अब तुम भौतिक प्रकृति के इन तीनों गुणों के आधार पर इंसान की 'बुद्धि' और उसकी 'धृति' यानी धैर्य या संकल्प शक्ति के भेदों को सुनो।
            मैं तुम्हें बुद्धि और संकल्प के इन तीन अलग-अलग प्रकारों को पूरी तरह से विस्तारपूर्वक और अत्यंत गहराई के साथ अलग-अलग करके समझाऊँगा।
            भगवान श्रीकृष्ण यहाँ से इंसानी मनोविज्ञान और उसकी थिंकिंग प्रोसेस यानी सोचने के तरीके का सबसे बड़ा और सबसे गहरा चैप्टर शुरू कर रहे हैं।
            इंसान की 'बुद्धि' वह सॉफ्टवेयर है जो यह तय करती है कि क्या सही है और क्या गलत है और यही बुद्धि इंसान के हर फैसले को पूरी तरह कंट्रोल करती है।
            और 'धृति' वह विल-पावर या इंजन है जो इंसान को तब तक हार नहीं मानने देता जब तक कि वह अपने गोल या लक्ष्य को पूरी तरह हासिल नहीं कर लेता।
            लेकिन हर इंसान की बुद्धि और विल-पावर एक जैसी बिल्कुल नहीं होती है बल्कि वह उसके अंदर मौजूद सत्त्व रजस या तमस गुणों पर निर्भर करती है।
            किसी की बुद्धि उसे भगवान की तरफ ले जाती है तो किसी की बुद्धि उसे क्राइम और करप्शन के गंदे अंधेरे में पूरी तरह धकेल देती है।
            यह जानना बहुत ज़रूरी है कि हमारे अंदर का जो सॉफ्टवेयर इस वक्त काम कर रहा है वह असली है या वह माया के वायरसों से पूरी तरह हैक हो चुका है।
            भगवान एक मास्टर प्रोग्रामर की तरह अर्जुन को वह कोड बता रहे हैं जिससे वह अपनी और दूसरों की बुद्धि का असली लेवल तुरंत नाप सकेगा।
            अगले कुछ श्लोकों में बुद्धि और संकल्प शक्ति का यह ब्रह्मांडीय विश्लेषण इंसान के सारे मनोवैज्ञानिक भ्रमों को हमेशा के लिए तोड़ देगा।
        """.trimIndent(),
        english = """
            O winner of wealth Arjuna! Now please listen closely as I explicitly detail the three absolute specific divisions of human intellect and determination according to the material modes.
            I shall aggressively and flawlessly declare these distinct biological categories to you fully explicitly and in exhaustive mathematical detail completely distinguishing each type.
            Lord Sri Krishna is officially launching the absolute deepest and most profoundly advanced chapter regarding human psychology and cognitive processing algorithms right here.
            The human 'Intellect' is the absolute master software actively calculating what is morally correct and definitively controlling every single biological decision the entity executes.
            And 'Determination' is the raw explosive engine of willpower that ruthlessly prevents a human from surrendering until his massive cosmic objectives are completely achieved.
            However the intellect and willpower of every mortal are absolutely not identical; they heavily mutate and strictly depend upon whether goodness passion or ignorance infects his brain.
            One human's highly tuned intellect seamlessly elevates him toward Godhead while another's corrupted software violently drags him down into the filthy gutters of crime and corruption.
            It is mathematically critical to urgently audit whether our current psychological operating system is authentic or if it has been catastrophically hacked by the toxic viruses of Maya.
            Operating exactly like a Supreme Master Programmer the Lord is downloading the ultimate diagnostic code into Arjuna allowing him to instantly measure the true frequency of any intellect.
            In the upcoming spectacular verses this cosmic analysis of intelligence and willpower will violently shatter absolutely every psychological illusion currently paralyzing the human race.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            प्रवृत्तिं च निवृत्तिं च कार्याकार्ये भयाभये |
            बन्धं मोक्षं च या वेत्ति बुद्धिः सा पार्थ सात्त्विकी || ३० ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जो बुद्धि यह बिल्कुल स्पष्ट रूप से जानती है कि किस रास्ते पर चलना चाहिए और किस रास्ते से हमेशा के लिए पूरी तरह हट जाना चाहिए।
            जो यह जानती है कि क्या करना मेरा परम कर्तव्य है और क्या करना मेरे लिए पाप है तथा किस चीज़ से डरना चाहिए और किससे बिल्कुल नहीं डरना चाहिए।
            और जो बुद्धि इंसान के कर्म-बंधन के असली कारण को और उससे मिलने वाले परमानेंट मोक्ष को बिल्कुल सटीक रूप से समझती है वही वास्तव में 'सात्त्विकी बुद्धि' है।
            यह श्लोक दुनिया की सबसे हाई-लेवल और सबसे एलीट बुद्धिमानी का एक परफेक्ट और साइंटिफिक डेफिनेशन है जो इंसान को असली आज़ादी दिलाता है।
            सात्त्विक बुद्धि एक ऐसे लेज़र-शार्प जीपीएस की तरह काम करती है जो इंसान को इस भूलभुलैया जैसी दुनिया में कभी भी भटकने या कंफ्यूज नहीं होने देती।
            साधारण लोग हमेशा इसी टेंशन में रहते हैं कि मैं यह काम करूँ या ना करूँ लेकिन सात्त्विक बुद्धि वाले इंसान का डिसीजन-मेकिंग 100% क्लियर और परफेक्ट होता है।
            उसे यह पता होता है कि मुझे केवल भगवान से और पाप करने से डरना चाहिए बाकी दुनिया की किसी भी झूठी ताकत या मौत से मुझे बिल्कुल नहीं डरना है।
            वह भली-भांति जानता है कि कौन सी लालच वाली आदतें उसे इस मैट्रिक्स में बाँध देंगी और कौन से निस्वार्थ कर्म उसे मोक्ष की तरफ लेकर जाएंगे।
            यह बुद्धि कोई स्कूल या कॉलेज की डिग्री से नहीं आती बल्कि यह इंसान के मन की पवित्रता और उसके ईश्वरीय ज्ञान के कारण उसके अंदर अपने आप पैदा होती है।
            भगवान कहते हैं कि जिस इंसान ने अपने दिमाग को इस सात्त्विक लेवल तक अपग्रेड कर लिया है उसे दुनिया की कोई भी ताकत कभी भी बेवकूफ नहीं बना सकती।
        """.trimIndent(),
        english = """
            O son of Pritha! That absolute supreme intellect which flawlessly knows exactly what action ought to be done and what must be violently avoided entirely.
            Which mathematically calculates what is a mandatory duty and what is a cosmic sin and explicitly identifies what is truly to be feared and what is not to be feared.
            And which scientifically understands the precise mechanics of material bondage and the exact process of eternal liberation; that supreme intellect is officially in the mode of goodness.
            This spectacular verse delivers the absolute perfect scientific definition of the world's most high-level and elite cosmic intelligence that grants a human total ultimate freedom.
            The Sattvic intellect operates exactly like a laser-sharp quantum GPS mathematically guaranteeing that the human absolutely never gets lost or confused inside this highly deceptive material labyrinth.
            Ordinary ignorant mortals perpetually suffer from paralyzing biological anxiety regarding their life choices but the decision-making algorithm of a Sattvic brain is 100% crystal-clear and flawless.
            He possesses the titanium conviction that he must only fear committing horrific sins and displeasing God while remaining completely immune and fearless against earthly powers or biological death.
            He scientifically perceives exactly which toxic habits act as heavy chains binding him to the matrix and exactly which selfless actions serve as the ultimate exit codes for Moksha.
            This supreme intelligence absolutely cannot be purchased through expensive university degrees; it spontaneously boots up strictly as a direct result of internal purity and divine connection.
            The Lord aggressively guarantees that any human who successfully upgrades his psychological software to this elite Sattvic frequency can absolutely never be scammed or defeated by the universe.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            यया धर्ममधर्मं च कार्यं चाकार्यमेव च |
            अयथावत्प्रजानाति बुद्धिः सा पार्थ राजसी || ३१ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जिस बुद्धि के द्वारा मनुष्य धर्म और अधर्म के बीच के फर्क को तथा अपने सही और गलत कर्तव्यों को कभी भी ठीक से और स्पष्ट रूप से नहीं समझ पाता है।
            जिस बुद्धि में हमेशा एक भयंकर कंफ्यूजन बना रहता है और जो सत्य को वैसा नहीं देख पाती जैसा वह वास्तव में है, उस बिगड़ी हुई बुद्धि को 'राजसी बुद्धि' कहते हैं।
            यह श्लोक आज के मॉडर्न और भौतिकवादी समाज की उस सबसे बड़ी मानसिक बीमारी का एक्स-रे है जहाँ इंसान हर चीज़ को अपने फायदे के चश्मे से ही देखता है।
            राजसिक बुद्धि वाला इंसान बहुत ज़्यादा ओवरथिंकिंग करता है लेकिन जब उसे कोई सही डिसीजन लेना होता है तो उसका दिमाग पूरी तरह से जाम और कंफ्यूज हो जाता है।
            उसके लिए धर्म का मतलब वह है जिससे उसका बैंक बैलेंस और उसकी पावर बढ़े और अधर्म वह है जिससे उसे कोई भी छोटा सा पर्सनल नुकसान होता हो।
            उसे अपनी लालच और वासनाओं के कारण सच्चाई कभी साफ दिखाई नहीं देती और वह अपने हर गलत काम को सही साबित करने के लिए झूठे तर्क और बहाने बनाता है।
            यह बुद्धि एक ऐसे गंदे और धुंधले शीशे की तरह है जिसमें इंसान को अपना असली चेहरा और दुनिया की असलियत कभी भी दिखाई नहीं दे सकती।
            वह हमेशा डाउट और शक में जीता है कि मैं जो कर रहा हूँ वह सही है या नहीं और इसी स्ट्रेस के कारण वह कभी भी शांति की नींद नहीं सो पाता।
            भगवान अर्जुन को समझा रहे हैं कि बिना ईश्वरीय ज्ञान के इंसान का दिमाग हमेशा इसी राजसिक कंफ्यूजन में फँसकर अपनी पूरी ज़िंदगी को नर्क बना लेता है।
            इसलिए इंसान को अपनी इस करप्ट बुद्धि पर अंधा भरोसा करने के बजाय शास्त्रों और भगवान के वचनों को अपना अल्टीमेट गाइड और जीपीएस बनाना चाहिए।
        """.trimIndent(),
        english = """
            O son of Pritha! That heavily corrupted intellect which absolutely cannot properly or accurately distinguish between authentic cosmic religion and terrifying irreligion.
            And which is perpetually confused regarding what action should be aggressively executed and what should be avoided failing to see reality as it is; that intellect is officially in the mode of passion.
            This spectacular verse executes a flawless psychological X-Ray of the modern materialistic society's greatest mental disease where humans view everything strictly through the dirty lens of personal profit.
            A human equipped with a passionate Rajasic intellect violently overthinks 24/7 yet whenever he faces a critical moral decision his biological software completely jams and catastrophically crashes into deep confusion.
            To his highly corrupted mind authentic 'Dharma' simply means whatever artificially inflates his offshore bank accounts and 'Adharma' is anything that causes a microscopic drop in his personal corporate power.
            Blinded entirely by his toxic biological lust he is mathematically incapable of perceiving transparent truth continuously manufacturing pathetic fake excuses and toxic logic to aggressively justify his horrific sins.
            This degraded intellect operates exactly like a filthy highly shattered mirror absolutely preventing the mortal from ever perceiving his true spiritual reflection or the stark reality of the cosmos.
            He lives his entire biological timeline suffocating in deep toxic doubts desperately wondering if his actions are valid and this massive chronic stress permanently denies him a single night of true peace.
            The Lord explicitly warns Arjuna that without the absolute download of divine knowledge a human's unguided brain will perpetually remain hopelessly trapped in this passionate hellish confusion.
            Therefore a mortal must urgently stop blindly trusting his own highly corrupted biological brain and immediately adopt the authorized Vedic scriptures as his ultimate flawless cosmic GPS.
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            अधर्मं धर्ममिति या मन्यते तमसावृता |
            सर्वार्थान्विपरीतांश्च बुद्धिः सा पार्थ तामसी || ३२ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जो बुद्धि घोर अज्ञान और भयंकर अंधकार से पूरी तरह ढकी हुई है और जो जानबूझकर अधर्म को ही असली धर्म मानकर पूरी दुनिया में उसका प्रचार करती है।
            और जो बुद्धि जीवन के हर एक सिद्धांत हर बात और हर अर्थ को हमेशा बिल्कुल उल्टा और नेगेटिव ही समझती है उस सबसे घटिया बुद्धि को 'तामसी बुद्धि' कहा गया है।
            यह श्लोक दुनिया के सबसे खतरनाक अपराधियों आतंकवादियों और मानसिक रूप से बीमार लोगों की साइकोलॉजी का बिल्कुल सटीक और डरावना एक्स-रे है।
            तामसिक बुद्धि एक ऐसा वायरस है जो इंसान के दिमाग को 100% करप्ट कर देता है; इसके बाद इंसान को दिन हमेशा रात और ज़हर हमेशा अमृत ही दिखाई देता है।
            ऐसे लोग सोचते हैं कि निर्दोष लोगों को मारना जानवरों को काटना और दुनिया में तबाही मचाना ही उनका सबसे बड़ा धर्म और भगवान का काम है।
            वे सच्चाई को बिल्कुल उल्टे तरीके से प्रोसेस करते हैं; अगर आप उन्हें कोई अच्छी बात समझाएंगे तो वे उसे अपने ऊपर एक हमला मानकर आपको ही मारने दौड़ेंगे।
            उनका दिमाग एक 'ब्लैक होल' की तरह बन जाता है जहाँ ज्ञान की कोई भी रोशनी प्रवेश नहीं कर सकती और वे अपने ही घमंड में अपनी बर्बादी का जश्न मनाते हैं।
            दुनिया की जितनी भी गंदी और खौफनाक विचारधाराएं (Ideologies) हैं वे सब इसी तामसिक बुद्धि की ही देन हैं जो पूरे मानव समाज के लिए एक भयंकर कैंसर हैं।
            भगवान कहते हैं कि यह बुद्धि इंसान का सबसे बड़ा और सबसे खामोश दुश्मन है जो उसे इंसान के दर्जे से गिराकर एक खूंखार और अंधा राक्षस बना देती है।
            जो व्यक्ति इस प्रकार की उल्टी और अंधी सोच का शिकार हो जाता है उसका ब्रह्मांड में पतन निश्चित है और उसे भगवान की दया भी कभी प्राप्त नहीं होती।
        """.trimIndent(),
        english = """
            O son of Pritha! That terrifying intellect which is completely violently enveloped in the dense blinding darkness of ignorance and insanely hallucinates that catastrophic irreligion is actually pure religion.
            And which mathematically calculates and processes absolutely every single cosmic fact doctrine and meaning in the exact opposite wrong and highly negative direction; that intellect is strictly in the mode of ignorance.
            This phenomenal verse acts as the absolute most precise and terrifying psychological X-Ray diagnosing the exact corrupted software driving the world's most dangerous criminals and bloodthirsty cosmic terrorists.
            The Tamasic intellect is a highly lethal radioactive virus that 100% corrupts the human brain completely forcing the mortal to biologically perceive bright daylight as pitch-black night and lethal poison as divine nectar.
            These toxic entities aggressively hallucinate that ruthlessly slaughtering innocent humans violently torturing animals and generating apocalyptic global chaos is their supreme religious duty and divine mission.
            Their cognitive software processes objective truth in absolute reverse; if an enlightened master attempts to mercifully hand them pure wisdom they perceive it as a lethal threat and violently attack him in response.
            Their brain legally mutates into a terrifying psychological 'Black Hole' where absolutely zero rays of logical light can penetrate and they arrogantly celebrate their own catastrophic destruction as a massive victory.
            Every single horrific toxic and bloodcurdling ideology currently polluting this planet is the direct biological byproduct of this Tamasic intellect functioning exactly like a malignant terminal cancer upon human society.
            The Supreme Lord warns that this degraded intellect is humanity's absolute greatest silent assassin violently downgrading a human from a civilized entity into a blind bloodthirsty demonic apex predator.
            Any mortal who tragically succumbs to this reverse engineered highly toxic mindset mathematically guarantees his own absolute catastrophic cosmic downfall permanently disqualifying himself from God's mercy.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            धृत्या यया धारयते मनःप्राणेन्द्रियक्रियाः |
            योगेनाव्यभिचारिण्या धृतिः सा पार्थ सात्त्विकी || ३३ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जिस अटूट और कभी न टूटने वाली 'धृति' (धैर्य या विल-पावर) के द्वारा मनुष्य अपने मन, अपने प्राण और अपनी सभी इन्द्रियों की हरकतों को पूरी तरह से कंट्रोल करता है।
            और वह यह काम केवल योग और ध्यान की उस परम शक्ति के द्वारा करता है जो कभी भी अपने रास्ते से नहीं भटकती (अव्यभिचारिण्या), वही वास्तव में 'सात्त्विकी धृति' है।
            भगवान यहाँ एक महान योगी और सच्चे सुपरहीरो की उस 'टाइटेनियम विल-पावर' (Titanium Will-power) का सबसे बड़ा सीक्रेट और विज्ञान खोल कर रख रहे हैं।
            इंसान का मन और उसकी इन्द्रियां एक जंगली और पागल घोड़े की तरह होती हैं जो इंसान को हमेशा लालच और वासना की गंदी खाइयों की तरफ खींच कर ले जाती हैं।
            लेकिन सात्त्विक विल-पावर वाला इंसान एक ऐसा कमांडो होता है जो अपनी इन सभी बेकाबू शक्तियों को एक ही झटके में पकड़ कर अपने 100% कंट्रोल में ले लेता है।
            उसकी यह शक्ति दुनिया की किसी मोटिवेशनल वीडियो से नहीं आती, बल्कि यह भगवान के ध्यान (योग) से जुड़ने के कारण सीधे ब्रह्मांड के सुप्रीम सर्वर से डाउनलोड होती है।
            उसका संकल्प इतना भयंकर और पक्का होता है कि चाहे दुनिया की सबसे बड़ी लालच या मौत का डर उसके सामने आ जाए, वह अपने सत्य के रास्ते से एक इंच भी नहीं हिलता।
            यह कोई साधारण जिद्द नहीं है; यह वह ईश्वरीय ताक़त है जो इंसान को उसकी शारीरिक सीमाओं (Biological limits) से बहुत ऊपर उठाकर उसे भगवान के लेवल तक ले जाती है।
            जिस इंसान के पास यह सात्त्विकी धृति होती है, वह दुनिया के हर तूफान और स्ट्रेस के बीच एक विशाल पहाड़ की तरह पूरी तरह शांत और अजेय बना रहता है।
            यह श्लोक साबित करता है कि असली 'ताकत' दूसरों को हराने में नहीं है, बल्कि अपने ही दिमाग और अपनी वासनाओं को कुचल कर उन्हें अपना गुलाम बना लेने में है।
        """.trimIndent(),
        english = """
            O son of Pritha! That unshakeable unbreakable and absolute titanium determination (Dhriti) by which a human flawlessly and strictly controls the erratic activities of the mind the life airs and the biological senses.
            And he aggressively executes this absolute control purely through the terrifying power of yoga and meditation which absolutely never deviates from its divine target; that supreme willpower is officially in the mode of goodness.
            The Lord is aggressively declassifying the absolute ultimate science and heavily guarded secret behind the 'Titanium Willpower' possessed strictly by elite cosmic yogis and genuine spiritual superheroes.
            A human's biological mind and highly volatile senses operate exactly like a pack of rabid wild horses relentlessly violently dragging the consciousness toward the filthy toxic gutters of animalistic lust and cheap greed.
            But the elite human armed with Sattvic willpower acts exactly like an elite military commando violently grabbing the reins of these wild biological forces and forcing them into 100% absolute submission.
            His terrifying mental strength absolutely does not originate from cheap earthly motivation; it is mathematically downloaded directly from the Supreme Server of the universe via intense unyielding divine connection (Yoga).
            His cosmic resolve is so profoundly indestructible that even if the absolute greatest material temptation or the paralyzing terror of death confronts him he absolutely refuses to flinch even a single millimeter from the truth.
            This is absolutely not mere human stubbornness; it is a hyper-advanced divine cosmic energy that forcefully elevates a mortal infinitely beyond his pathetic biological limits directly toward the frequency of Godhead.
            Any human who successfully installs this Sattvic Dhriti permanently transforms into a massive invincible mountain remaining completely calm and entirely untouched amidst the multiverse's most catastrophic hurricanes and toxic stress.
            This spectacular verse mathematically proves that authentic 'Power' is absolutely not about brutally crushing other humans; it is exclusively about violently conquering your own rogue brain and forcing it to become your obedient slave.
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            यया तु धर्मकामार्थान्धृत्या धारयतेऽर्जुन |
            प्रसङ्गेन फलाकाङ्क्षी धृतिः सा पार्थ राजसी || ३४ ||
        """.trimIndent(),
        hindi = """
            परंतु हे अर्जुन! जिस 'धृति' या संकल्प शक्ति के द्वारा मनुष्य केवल धर्म, अर्थ (पैसा) और काम (वासनाओं) को ही अपने जीवन का सबसे बड़ा लक्ष्य मानकर कसकर पकड़े रहता है।
            और जो इंसान इन कामों को करते समय हमेशा बहुत ही गहरी आसक्ति (अटैचमेंट) और भविष्य में मिलने वाले बड़े फलों या मुनाफे की भयंकर लालसा (फलाकाङ्क्षी) से भरा रहता है।
            तुम यह पक्का समझ लो कि उस प्रकार के अत्यधिक स्वार्थी, लालची और दुनिया से चिपके हुए संकल्प और दृढ़ता को ही 'राजसी धृति' (Rajasic Resolve) कहा जाता है।
            यह श्लोक आज के 'हसल कल्चर' (Hustle culture) और उस वर्कहोलिक (Workaholic) इंसान का सबसे सटीक एक्स-रे है जो 24 घंटे केवल पैसे और पावर के लिए पागलों की तरह भागता है।
            राजसिक इंसान की विल-पावर भी बहुत स्ट्रॉन्ग (Strong) होती है; वह दिन-रात बिना सोए मेहनत कर सकता है, लेकिन उसका इंजन केवल 'लालच' के फ्यूल (Fuel) से चलता है।
            वह धर्म के काम (पूजा-पाठ) भी इसलिए करता है ताकि उसे भगवान से कुछ बहुत बड़ा फायदा मिल सके, और वह पैसा इसलिए कमाता है ताकि वह अपनी गंदी वासनाओं को पूरा कर सके।
            उसका हर कदम एक बिज़नेस-डील (Business deal) होता है, और अगर किसी काम में उसे अपना फायदा (फल) नहीं दिखता, तो वह उस काम को तुरंत लात मार देता है।
            वह अपनी इस स्वार्थी जिद्द को 'मेहनत' का नाम देता है, लेकिन असल में वह केवल अपनी उन इच्छाओं का गुलाम होता है जिनका पेट कभी नहीं भरता।
            भगवान कहते हैं कि यह संकल्प शक्ति इंसान को कभी शांति नहीं दे सकती क्योंकि जब उसका कोई स्वार्थ पूरा नहीं होता तो वह भयंकर डिप्रेशन और गुस्से में टूट जाता है।
            यह राजसी धृति इंसान को एक मशीन बना देती है जो दुनिया के मैट्रिक्स में गोल-गोल घूमती रहती है और अंत में बिना किसी असली खुशी के राख हो जाती है।
        """.trimIndent(),
        english = """
            But O Arjuna! That specific determination by which a heavily attached human aggressively holds fast strictly to the pursuit of religious rituals economic development (wealth) and sensory gratification (lust).
            And who executes these massive physical endeavors perpetually heavily intoxicated by extreme toxic attachment and a violently burning greedy desire to hoard the future fruitive results and maximum corporate profit (Phalakankshi).
            You must definitively clinically conclude that this highly selfish greed-driven and heavily worldly type of unyielding resolve is officially universally categorized as determination in the mode of passion (Rajasic Dhriti).
            This spectacular verse functions as the absolute flawless X-Ray brutally exposing modern 'Hustle Culture' and the manic workaholic entity who sprints like a lunatic 24/7 exclusively to hoard cheap paper money and toxic power.
            A Rajasic human possesses staggeringly strong willpower; he can violently hustle day and night absolutely without sleep but his biological engine runs exclusively on the highly toxic flammable fuel of pure 'Greed'.
            He aggressively performs religious rituals (Dharma) strictly to legally extract massive cosmic favors from God and he brutally hoards billions in cash (Artha) solely to forcefully gratify his filthy insatiable lusts (Kama).
            Absolutely every single physical action he executes is a calculated corporate 'Business Deal' and if a specific project mathematically promises zero personal profit he instantly and ruthlessly kicks it straight into the garbage.
            He arrogantly brands his toxic selfish stubbornness as 'Elite Hard Work' but in brutal cosmic reality he is merely a pathetic helpless slave chained entirely to biological desires that can mathematically never be satisfied.
            The Lord issues a titanium warning that this specific type of passionate willpower can absolutely never grant a human true peace because the microsecond his greedy expectations are crushed he violently shatters into explosive depression.
            This Rajasic determination forcefully mutates a human into a pathetic biological machine spinning mindlessly in the matrix's hamster wheel ultimately turning to ash without ever tasting a single drop of authentic cosmic happiness.
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            यया स्वप्नं भयं शोकं विषादं मदमेव च |
            न विमुञ्चति दुर्मेधा धृतिः सा पार्थ तामसी || ३५ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जिस अंधी और ज़िद्दी धृति (संकल्प) के कारण एक अत्यंत मूर्ख और अज्ञानी इंसान (दुर्मेधा) अपनी अत्यधिक नींद (स्वप्नं), अपने अंदर के भयंकर डर और अपने बेकार के शोक को कभी नहीं छोड़ता है।
            और जो इंसान अपने डिप्रेशन (विषादं) तथा अपने झूठे और घिनौने अहंकार (मदम्) को एक बीमारी की तरह पकड़ कर बैठ जाता है और उनसे बाहर आने की कोई कोशिश नहीं करता।
            तुम यह पक्का जान लो कि उस इंसान की इस प्रकार की नेगेटिव, अंधी और पूरी तरह से सड़ी हुई जिद्द को ही शास्त्रों में 'तामसी धृति' (Tamasic Resolve) कहा गया है।
            भगवान यहाँ इंसान के उस 'टॉक्सिक और नेगेटिव माइंडसेट' (Toxic and Negative Mindset) का बहुत ही कड़वा सच बता रहे हैं जहाँ इंसान खुद अपनी ही बर्बादी का जश्न मनाता है।
            तामसिक इंसान इतना बड़ा मूर्ख (दुर्मेधा) होता है कि वह अपने आलस्य और अपनी बुरी आदतों को ही अपना सबसे प्यारा दोस्त मानकर उनसे शादी कर लेता है।
            वह 24 घंटे केवल सोने में, पागलों की तरह सपने देखने में और बिना किसी बात के डरने या रोने में अपनी पूरी कीमती ज़िंदगी को नाले में बहा देता है।
            जब कोई समझदार इंसान उसे इस डिप्रेशन और अज्ञानता से बाहर निकालने की कोशिश करता है, तो वह अपने अहंकार (मद) के कारण उस इंसान पर ही हमला कर देता है।
            वह अपने दुखों और अपनी नाकामियों को 'ग्लैमराइज़' (Glamorize) करता है और अपनी इस बेवकूफी भरी जिद्द को अपनी ताकत समझने की भयंकर भूल करता है।
            यह कोई विल-पावर नहीं है; यह एक मानसिक कैंसर (Mental Cancer) है जो इंसान के सोचने-समझने की पूरी मशीनरी को अंदर से सड़ा कर उसे एक ज़िंदा लाश बना देता है।
            ईश्वर ऐसे लोगों को सीधा चेतावनी देते हैं कि जो खुद अपने अंधेरे से बाहर नहीं आना चाहता, उसे दुनिया की कोई भी ताकत और खुद भगवान भी कभी नहीं बचा सकते।
        """.trimIndent(),
        english = """
            O son of Pritha! That blinding idiotic and highly toxic determination by which a heavily degraded unintelligent fool (Durmedha) absolutely violently refuses to give up excessive sleep (Svapnam) his paralyzing fear and his pathetic grief.
            And the human who aggressively hugs his own chronic depression (Vishadam) and his sickeningly bloated false arrogance (Madam) exactly like a terminal disease actively refusing to make even a microscopic attempt to escape them.
            You must definitively scientifically conclude that this entirely negative blind and completely rotting psychological stubbornness is officially legally categorized by scriptures as determination in the darkest mode of ignorance (Tamasic Dhriti).
            The Lord is brutally exposing the absolute bitter reality of a human's 'Toxic and Negative Mindset' where the pathetic entity aggressively hallucinates and literally celebrates his own catastrophic biological and spiritual destruction.
            A Tamasic human is such a monumentally colossal fool (Durmedha) that he aggressively accepts his toxic laziness and lethal habits as his absolute best friends literally marrying them and refusing a divorce.
            He flushes his entire precious cosmic timeline straight down the filthy gutter exclusively wasting 24 hours a day engaged in heavy excessive sleep having psychotic hallucinations and crying pathetically over baseless paranoid fears.
            When an elite wise sage mercifully attempts to forcefully drag him out of this toxic swamp of depression and ignorance his bloated demonic arrogance (Mada) violently triggers causing him to aggressively attack his own savior.
            He pathetically attempts to 'Glamorize' his own horrific failures and chronic misery committing the ultimate catastrophic blunder of violently mistaking his idiotic biological stubbornness for actual elite mental toughness.
            This is absolutely not willpower; it is a highly lethal psychological 'Mental Cancer' that aggressively rots the entire cognitive machinery from the inside out mutating the human into a pathetic breathing biological corpse.
            The Supreme Creator drops a terrifying absolute decree: If a human aggressively refuses to climb out of his own toxic darkness absolutely no force in the multiverse and not even God Himself will ever save him.
        """.trimIndent()
    ),
    Shloka(
        id = 36,
        sanskrit = """
            सुखं त्विदानीं त्रिविधं शृणु मे भरतर्षभ |
            अभ्यासाद्रमते यत्र दुःखान्तं च निगच्छति || ३६ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 36 और 37 एक ही सात्त्विक सुख का वर्णन करते हैं)
            हे भरतवंशियों में श्रेष्ठ अर्जुन! अब तुम मुझसे उस 'सुख' (Happiness / आनंद) के भी तीन अलग-अलग प्रकारों के बारे में बहुत ही ध्यानपूर्वक सुनो जिसकी तलाश हर इंसान कर रहा है।
            जिस सुख में मनुष्य लंबे समय तक लगातार योग और ध्यान का अभ्यास (Practice) करने के बाद ही पूरी तरह से रम जाता है (यानी उसमें गहरा आनंद महसूस करने लगता है)।
            और जिस सच्चे और शुद्ध सुख को एक बार प्राप्त कर लेने के बाद इंसान के जीवन के सभी भयंकर दुखों और चिंताओं का हमेशा के लिए अंत (दुःखान्तं) हो जाता है।
            भगवान श्रीकृष्ण अब इंसान की जिंदगी के सबसे बड़े और अल्टीमेट लक्ष्य यानी 'हैप्पीनेस' (Happiness) का सबसे बड़ा और सबसे साइंटिफिक सीक्रेट दुनिया को बताने जा रहे हैं।
            दुनिया का हर इंसान, चाहे वह कोई संत हो या कोई चोर, 24 घंटे केवल एक ही चीज़ की तलाश में पागलों की तरह भाग रहा है, और वह चीज़ है 'सुख' या 'आनंद'।
            लेकिन इंसान की सबसे बड़ी प्रॉब्लम यह है कि उसे यह पता ही नहीं है कि असली सुख क्या होता है और वह नकली सुखों के पीछे भागकर अपनी पूरी ज़िंदगी बर्बाद कर लेता है।
            भगवान कहते हैं कि जिस तरह खाना, काम और बुद्धि तीन प्रकार के होते हैं, बिल्कुल उसी तरह तुम्हारा यह 'सुख' भी सत्त्व, रजस और तमस के हिसाब से तीन अलग-अलग कैटेगरी (Category) में बँटा हुआ है।
            असली और परमानेंट (Permanent) सुख कभी भी फ्री (Free) में या रातों-रात नहीं मिलता; उसे पाने के लिए इंसान को अपने मन पर कंट्रोल करने का बहुत लंबा और कड़ा अभ्यास (अभ्यास) करना पड़ता है।
            यह श्लोक उस महान 'सात्त्विक सुख' का एक बहुत ही शानदार इंट्रोडक्शन (Introduction) है जो इंसान के दिमाग से डिप्रेशन और स्ट्रेस के हर एक वायरस को हमेशा के लिए डिलीट कर देता है।
            अगले श्लोक में भगवान एक डॉक्टर की तरह यह बताएँगे कि यह असली सुख शुरुआत में कैसा लगता है और अंत में इसका रिज़ल्ट क्या होता है।
        """.trimIndent(),
        english = """
            (Verses 36 and 37 seamlessly describe the continuous concept of Sattvic Happiness)
            O best of the Bharatas Arjuna! Now please listen with absolute razor-sharp focus as I explicitly declare the three distinct scientific categories of 'Happiness' (Sukham) that absolutely every mortal is desperately hunting for.
            That specific happiness in which the human consciousness completely rejoices and permanently immerses itself strictly only after executing highly rigorous long-term practice (Abhyasa) of strict yoga and deep meditation.
            And by successfully achieving this absolute pure and authentic happiness the human flawlessly reaches the ultimate dead-end of all terrifying biological miseries and psychological distress (Duhkhantam).
            Lord Sri Krishna is now aggressively declassifying the absolute greatest and most highly scientific cosmic secret regarding humanity's ultimate singular objective: the pursuit of pure 'Happiness'.
            Absolutely every single biological entity on earth from an elite enlightened saint to a highly toxic criminal is frantically sprinting 24/7 like a maniac hunting exclusively for one specific target: 'Joy' or 'Bliss'.
            But humanity's absolute most catastrophic glitch is that their corrupted software has completely forgotten the true definition of happiness forcing them to violently waste their entire lifespans chasing fake highly toxic pleasures.
            The Lord mathematically clarifies that just as biological food physical action and human intellect are strictly divided into three modes 'Happiness' is also explicitly segregated into goodness passion and ignorance.
            Authentic permanent and absolute happiness is absolutely never distributed for free nor is it achieved overnight; it demands a brutally long unyielding 'Practice' (Abhyasa) of aggressively hacking and dominating your own mind.
            This spectacular verse serves as the ultimate highly anticipated 'Introduction' to that elite 'Sattvic Happiness' which mathematically guarantees the permanent deletion of every single virus of depression and stress from the brain.
            In the exact next verse the Supreme Creator operating as the ultimate cosmic physician will explicitly diagnose exactly how this true happiness feels at the beginning and what its ultimate explosive result is at the end.
        """.trimIndent()
    ),
    Shloka(
        id = 37,
        sanskrit = """
            यत्तदग्रे विषमिव परिणामेऽमृतोपमम् |
            तत्सुखं सात्त्विकं प्रोक्तमात्मबुद्धिप्रसादजम् || ३७ ||
        """.trimIndent(),
        hindi = """
            जो सुख शुरुआत में (यानी जब उसे पाने के लिए मेहनत की जाती है) तो इंसान को बिल्कुल किसी भयंकर और कड़वे 'ज़हर' (विषमिव) के समान बहुत ही कष्टदायक लगता है।
            परंतु उसका अंतिम परिणाम (Final Result) इतना शानदार होता है कि वह साक्षात् परम 'अमृत' (अमृतोपमम्) के समान इंसान को हमेशा के लिए अमर और आनंद से भर देता है।
            और जो सुख इंसान की अपनी ही आत्मा और शुद्ध बुद्धि के निर्मल होने (प्रसादजम्) से अपने आप अंदर से पैदा होता है, उस महान सुख को ही 'सात्त्विक सुख' कहा गया है।
            यह श्लोक 'द साइकोलॉजी ऑफ हार्ड-वर्क' (The Psychology of Hard-work) और 'डिलेड ग्रैटिफिकेशन' (Delayed Gratification) का दुनिया का सबसे परफेक्ट और अल्टीमेट सूत्र है!
            भगवान कहते हैं कि दुनिया की कोई भी असली और परमानेंट चीज़ कभी भी शुरुआत में मीठी या मज़ेदार नहीं लगती; उसे पाने के लिए पसीना बहाना पड़ता है और दर्द सहना पड़ता है।
            चाहे वह सुबह 4 बजे उठकर जिम (Gym) जाना हो, पढ़ाई करना हो या ध्यान (Meditation) लगाना हो—शुरुआत में शरीर और मन को यह सब एक टॉर्चर या 'ज़हर' की तरह लगता है।
            लेकिन जो इंसान इस शुरुआती ज़हर को पी जाता है और हार नहीं मानता, उसे अंत में एक ऐसी बेहतरीन हेल्थ, ज्ञान और शांति मिलती है जो किसी 'अमृत' से कम नहीं होती।
            और सबसे बड़ी बात, यह सात्त्विक सुख दुनिया की किसी महंगी कार या पैसे से नहीं आता; यह सुख आपके अपने ही दिमाग के 100% साफ और शांत हो जाने से आपके अंदर से फूट पड़ता है।
            यह एक ऐसा 'सेल्फ-जनरेटिंग पावर-हाउस' (Self-generating power-house) है जिसे बाहरी दुनिया की कोई भी टेंशन या गरीबी कभी भी छीन या बंद नहीं कर सकती।
            भगवान की यह गारंटी है कि जो इंसान इस सात्त्विक सुख के फॉर्मूले को अपनी ज़िंदगी में अप्लाई (Apply) कर लेता है, वह इस दुनिया का सबसे अजेय और सुखी इंसान बन जाता है।
        """.trimIndent(),
        english = """
            That specific happiness which at the absolute very beginning (during the initial brutal phase of hard work) feels incredibly agonizing and fiercely painful exactly like consuming highly toxic lethal 'Poison' (Visham iva).
            But whose absolute ultimate final consequence (Pariname) is so unimaginably spectacular that it perfectly acts exactly like the supreme nectar of immortality (Amritopamam) permanently filling the soul with indestructible bliss.
            And which is organically flawlessly generated entirely from the pure crystal-clear serenity of one's own awakened soul and highly purified intellect (Atma-buddhi-prasadajam); that elite happiness is officially called Sattvic.
            This spectacular verse is the multiverse's absolute most perfect and ultimate scientific formula completely decoding 'The Psychology of Hard-Work' and the highly advanced concept of 'Delayed Gratification'!
            The Lord explicitly decrees that absolutely no genuine permanent cosmic asset ever tastes sweet or highly enjoyable at the beginning; extracting it mathematically demands sweating blood enduring brutal pain and violent discipline.
            Whether it involves violently waking up at 4 AM to crush a brutal gym workout studying complex quantum physics or forcing the brain into deep meditation—initially the biological machine registers this as agonizing 'Poison' and pure torture.
            But the elite titanium-minded human who courageously swallows this initial poison absolutely refusing to surrender ultimately unlocks a staggering level of health elite wisdom and peace that operates exactly like divine 'Nectar'.
            And the absolute greatest twist: this Sattvic happiness is mathematically impossible to purchase using millions of dollars or luxury hypercars; it violently explodes spontaneously from within the human exclusively when his brain achieves 100% flawless clarity.
            It functions exactly like a permanent unhackable 'Self-Generating Power-House' embedded deep inside the consciousness which absolutely no external corporate bankruptcy or worldly tragedy can ever possibly shut down or confiscate.
            The Supreme Creator mathematically guarantees that any human who aggressively successfully applies this Sattvic formula to his daily timeline instantly permanently mutates into the absolute most invincible and ecstatic entity in existence.
        """.trimIndent()
    ),
    Shloka(
        id = 38,
        sanskrit = """
            विषयेन्द्रियसंयोगाद्यत्तदग्रेऽमृतोपमम् |
            परिणामे विषमिव तत्सुखं राजसं स्मृतम् || ३८ ||
        """.trimIndent(),
        hindi = """
            जो सुख इन्द्रियों (आँख, कान, जीभ आदि) और उनके बाहरी विषयों (पैसे, वासना, नशा आदि) के आपस में टकराने (संयोग) से पैदा होता है।
            जो सुख शुरुआत में (यानी जब उसे भोगा जाता है) तो इंसान को बिल्कुल किसी मीठे और शानदार 'अमृत' (अमृतोपमम्) की तरह बहुत ही ज़्यादा मज़ा और आनंद देने वाला लगता है।
            परंतु अंत में जब उसका फाइनल रिज़ल्ट (परिणामे) सामने आता है, तो वह सुख एक भयंकर और जानलेवा 'ज़हर' (विषमिव) की तरह इंसान को पूरी तरह से बर्बाद कर देता है; उसे ही 'राजस सुख' कहा जाता है।
            यह श्लोक आज के 'इन्स्टंट ग्रैटिफिकेशन' (Instant Gratification) और डोपामाइन (Dopamine) के नशे में डूबे हुए मॉडर्न समाज का सबसे भयंकर और कड़वा एक्स-रे है!
            भगवान अर्जुन को समझा रहे हैं कि जो चीज़ तुम्हें शुरुआत में बहुत ज़्यादा मीठी, आसान और मज़ेदार लगे, समझ लो कि वह 100% एक बहुत बड़ा 'जाल' (Trap) है।
            चाहे वह जंक-फूड खाना हो, शराब पीना हो, ड्रग्स लेना हो, या कोई गलत काम करके रातों-रात बहुत सारा पैसा कमाना हो—यह सब करते वक्त इंसान को 'अमृत' जैसा झूठा मज़ा आता है।
            लेकिन जब इन चीज़ों का असली बिल (Bill) कटता है, तो इंसान का लिवर खराब हो जाता है, वह जेल चला जाता है, या उसका पूरा परिवार और मानसिक शांति हमेशा के लिए तबाह हो जाती है।
            राजसिक सुख एक ऐसे क्रेडिट कार्ड (Credit Card) की तरह है जिसमें आप आज तो खूब ऐश करते हैं, लेकिन कल वह आपके जीवन का सारा सुकून भारी ब्याज (Interest) के साथ वसूल कर लेता है।
            यह सुख बाहर से आता है, इसलिए यह पूरी तरह से 'डिपेंडेंट' (Dependent) और गुलाम बनाने वाला है; जैसे ही वो बाहरी चीज़ छिनती है, इंसान भयंकर डिप्रेशन का शिकार हो जाता है।
            ईश्वर यह साफ वॉर्निंग (Warning) दे रहे हैं कि इस शुरुआती 'अमृत' के धोखे में कभी मत फँसना, क्योंकि इसके अंदर जो 'ज़हर' छिपा है, वह तुम्हारी आत्मा तक को सड़ा कर रख देगा।
        """.trimIndent(),
        english = """
            That specific cheap happiness which is generated strictly from the aggressive physical contact and biological friction between the material senses and their external toxic objects (Vishayendriya-samyogad).
            Which at the absolute very beginning (during the exact microsecond of biological consumption) falsely tastes incredibly sweet and highly euphoric exactly mimicking the divine nectar of immortality (Amritopamam).
            But at the absolute final consequence (Pariname) it mathematically violently mutates into a highly lethal terrifying biological and psychological 'Poison' (Visham iva) completely destroying the human; that is officially declared as passionate (Rajasic) happiness.
            This spectacular verse executes the absolute most terrifying brutal and naked X-Ray of modern society which is hopelessly hopelessly addicted to cheap 'Instant Gratification' and toxic Dopamine loops!
            The Supreme Lord is explicitly warning Arjuna with a titanium decree: If any action or consumable feels incredibly sweet effortless and euphoric right from the first microsecond you must mathematically conclude it is a 100% lethal 'Trap'.
            Whether it involves violently gorging on toxic junk food aggressively injecting illegal narcotics or executing massive corporate fraud to hoard instant billions—during the exact moment of execution the human hallucinates a fake 'Nectar-like' high.
            But when the universe mathematically demands the final invoice (Bill) the human's biological liver violently fails he is thrown into a terrifying maximum-security prison and his entire mental peace is permanently annihilated into ash.
            Rajasic happiness operates identically to a highly predatory toxic 'Credit Card'; you arrogantly violently party and consume today but tomorrow the cosmic matrix aggressively repossesses your entire life's peace with catastrophic interest rates.
            Because this cheap joy originates entirely from external material objects it renders the human a pathetic heavily dependent biological slave; the microsecond that external object is confiscated the human violently crashes into suicidal depression.
            God issues a massive unyielding warning: Absolutely never fall for the pathetic illusion of this initial fake 'Nectar' because the highly lethal 'Poison' secretly encoded inside it will mathematically rot your eternal soul to the core.
        """.trimIndent()
    ),
    Shloka(
        id = 39,
        sanskrit = """
            यदग्रे चानुबन्धे च सुखं मोहनमात्मनः |
            निद्रालस्यप्रमादोत्थं तत्तामसमुदाहृतम् || ३९ ||
        """.trimIndent(),
        hindi = """
            जो सुख शुरुआत में भी (अग्रे) और अंत में भी (अनुबन्धे) मनुष्य की आत्मा को केवल भयंकर मोह, भ्रम और घोर अज्ञान के अंधेरे में ही पूरी तरह से डुबो कर रखता है (मोहनमात्मनः)।
            और जो सुख केवल बहुत ज़्यादा नींद (निद्रा), भयंकर सुस्ती (आलस्य), और पागलपन या नशे (प्रमाद) से ही पैदा होता है, उस सबसे घटिया और खतरनाक सुख को 'तामसिक सुख' कहा गया है।
            यह श्लोक 'द अल्टीमेट डिस्ट्रक्शन' (The Ultimate Destruction) और इंसान की सबसे गिरी हुई साइकोलॉजी (Psychology) का बिल्कुल सीधा और बिना किसी फिल्टर का एक्स-रे है।
            भगवान कहते हैं कि सात्त्विक सुख अंत में फायदा देता है, राजसिक सुख शुरू में मज़ा देता है, लेकिन यह जो 'तामसिक सुख' है, यह तो शुरू से लेकर अंत तक 100% एक भयंकर और प्योर 'ज़हर' (Poison) ही है!
            दुनिया में कुछ लोग ऐसे होते हैं जिन्हें केवल दिन-रात पड़े रहने में, 15-15 घंटे सोने में, और ड्रग्स या शराब के नशे में खुद को पूरी तरह बर्बाद कर लेने में ही अपना सबसे बड़ा 'सुख' मिलता है।
            उन्हें इस बात से कोई फर्क नहीं पड़ता कि उनका भविष्य तबाह हो रहा है या उनकी फैमिली रो रही है; उनका दिमाग एक ऐसे डार्क 'ब्लैक-होल' (Black-hole) में फँस चुका है जहाँ कोई रोशनी नहीं जा सकती।
            इस सुख में इंसान का 'सॉफ्टवेयर' (Software) इतना करप्ट हो जाता है कि वह अपनी बर्बादी को ही अपना अचीवमेंट (Achievement) मानने लगता है और उसे किसी बात का कोई होश नहीं रहता।
            यह इंसान को इंसान के दर्जे से गिराकर एक ऐसा ज़ोंबी (Zombie) बना देता है जिसका न तो इस दुनिया में कोई काम है और न ही भगवान की दुनिया में उसके लिए कोई जगह है।
            नींद और आलस शरीर के लिए रेस्ट (Rest) हो सकते हैं, लेकिन जब कोई इंसान इन्हें ही अपना लाइफ-गोल (Life-goal) बना लेता है, तो वह जीते-जी एक लाश बन जाता है।
            ईश्वर की यह सबसे बड़ी वार्निंग है कि इस तामसिक 'झूठे सुख' की बीमारी से इंसान को अपनी पूरी ताक़त लगाकर तुरंत भागना चाहिए, वरना यह उसकी आत्मा तक को हमेशा के लिए मार देता है।
        """.trimIndent(),
        english = """
            That specific highly degraded happiness which remains utterly blinding and entirely illusory to the eternal soul right from the absolute very beginning to its catastrophic final end (Mohanam atmanah).
            And which is exclusively biologically and psychologically generated entirely from excessive deep sleep (Nidra) extreme chronic laziness (Alasya) and toxic madness or heavy intoxication (Pramada); that is officially declared to be happiness in the darkest mode of ignorance (Tamasic).
            This spectacular verse executes an absolutely flawless unfiltered and brutally raw X-Ray diagnosing 'The Ultimate Destruction' and the absolute lowest most degraded psychological state mathematically possible for a human entity.
            The Lord explicitly calculates: Sattvic joy yields supreme benefit at the end Rajasic joy provides a fake thrill at the start but this terrifying 'Tamasic Joy' is mathematically 100% unadulterated lethal 'Poison' from the very first microsecond to the bitter end!
            There is a highly toxic demographic of mortals who extract their absolute supreme 'Joy' exclusively from rotting in bed sleeping 15 hours a day and violently destroying their biological machines through hardcore illegal narcotics and heavy alcohol.
            Their deadened hearts register absolutely zero empathy regarding their completely annihilated future or their violently weeping families; their crashed brains are hopelessly trapped inside a dark terrifying psychological 'Black-Hole' where zero light can enter.
            Inside this toxic illusion the human's biological software becomes so catastrophically corrupted that he aggressively hallucinates his own apocalyptic ruin as a massive grand achievement remaining entirely unconscious of reality.
            This highly lethal frequency violently downgrades the entity from an advanced civilized human into a pathetic brainless biological 'Zombie' possessing absolutely zero utility in the material matrix and zero access to the spiritual sky.
            While basic sleep serves as mandatory biological maintenance when a human arrogantly elevates chronic laziness into his primary life-goal he instantly officially mutates into a breathing walking corpse.
            The Supreme Creator drops His absolute most massive warning klaxon: A human must violently forcefully and aggressively sprint away from this Tamasic 'Fake Joy' because it is a terminal virus engineered to permanently assassinate the eternal soul itself.
        """.trimIndent()
    ),
    Shloka(
        id = 40,
        sanskrit = """
            न तदस्ति पृथिव्यां वा दिवि देवेषु वा पुनः |
            सत्त्वं प्रकृतिजैर्मुक्तं यदेभिः स्यात्त्रिभिर्गुणैः || ४० ||
        """.trimIndent(),
        hindi = """
            इस पूरी पृथ्वी पर मनुष्यों के बीच या स्वर्ग (दिवि) में रहने वाले महान देवताओं के बीच भी, और यहाँ तक कि पूरे ब्रह्मांड में कहीं पर भी कोई ऐसा प्राणी या वस्तु (सत्त्वं) मौजूद ही नहीं है।
            जो भौतिक प्रकृति से पैदा हुए इन तीनों अत्यंत शक्तिशाली गुणों (सत्त्व, रजस, तमस) के भयंकर प्रभाव से पूरी तरह से मुक्त या आज़ाद (मुक्तं) हो।
            यह श्लोक पूरे भगवद्गीता के विज्ञान का एक बहुत ही शानदार और 'माइंड-ब्लोइंग' (Mind-blowing) निष्कर्ष (Conclusion) है जो पूरे यूनिवर्स (Universe) के सिस्टम को डिकोड (Decode) कर देता है!
            भगवान श्रीकृष्ण एक बहुत बड़ा और अचूक साइंटिफिक स्टेटमेंट (Scientific Statement) दे रहे हैं: "इस 3D मैट्रिक्स (Matrix) के अंदर जो कुछ भी है, वह 100% इन 3 गुणों के सॉफ्टवेयर से ही हैक और कंट्रोल किया गया है।"
            हम इंसान सोचते हैं कि अगर हम मरकर किसी तरह स्वर्ग पहुँच जाएं, तो वहाँ के देवता पूरी तरह से आज़ाद और भगवान के समान होंगे।
            लेकिन भगवान इस भयंकर भ्रम को एक ही झटके में तोड़ देते हैं! वे कहते हैं कि स्वर्ग का राजा 'इन्द्र' हो या कोई बहुत बड़ा देवता, वे सब भी इन तीनों गुणों के ही हाई-लेवल (High-level) गुलाम हैं।
            ब्रह्मांड का हर इंसान, हर जानवर, हर एलियन (Alien) और यहाँ तक कि हर एक निर्जीव पत्थर भी इन तीन गुणों (Software) की प्रोग्रामिंग (Programming) से बाहर नहीं जा सकता।
            जैसे किसी कंप्यूटर गेम (Computer Game) का कोई भी कैरेक्टर (Character) उस गेम के कोड (Code) से बाहर नहीं जा सकता, वैसे ही इस भौतिक दुनिया का कोई जीव इस 'प्रकृति' की मशीनरी से नहीं बच सकता।
            इन तीन गुणों की गुलामी से बाहर निकलने और असली 100% आज़ादी (मोक्ष) पाने का पूरे ब्रह्मांड में केवल एक ही इकलौता तरीका है।
            और वह तरीका है इस पूरी भौतिक मशीनरी के 'सुप्रीम क्रिएटर' (Supreme Creator) यानी साक्षात् भगवान श्रीकृष्ण की पूर्ण शरण में चले जाना जो इन गुणों से बहुत ऊपर (Transcendental) हैं।
        """.trimIndent(),
        english = """
            There is absolutely no living entity or physical object existing anywhere on this entire earthly planet nor even among the highly elevated elite demigods residing in the celestial higher planetary systems (Divi).
            Nor is there mathematically any being anywhere in the entire expanse of the physical multiverse who is completely flawlessly freed and liberated from the terrifying influence of these three modes born of material nature.
            This spectacular verse delivers an incredibly profound 'Mind-Blowing' and absolute ultimate scientific conclusion that perfectly decodes the complete architecture of the entire universal operating system!
            Lord Sri Krishna is dropping a massive unshakeable scientific statement: "Absolutely 100% of everything existing inside this physical 3D Matrix is aggressively hacked heavily programmed and strictly controlled by the software of these 3 modes."
            Ignorant mortals constantly hallucinate that if they can successfully upgrade their karma and immigrate to the heavenly planets they will become totally free and equal to God exactly like the elite demigods.
            But the Supreme Creator violently shatters this pathetic illusion in a single stroke! He officially decrees that whether it is King Indra or the most massive celestial deity they are all merely high-level heavily programmed biological slaves to these modes.
            Every single human every apex predator every undiscovered alien entity and even every microscopic dead rock is mathematically incapable of escaping the strict algorithmic programming enforced by these three modes.
            Just as absolutely zero AI characters inside a hyper-advanced computer game can ever bypass the foundational source code of that game no biological entity can bypass the brutal machinery of material nature.
            There exists mathematically exactly one absolute solitary exit strategy in the entire multiverse to successfully shatter the slavery of these three modes and achieve 100% authentic eternal freedom (Moksha).
            And that singular elite method is aggressively and unconditionally surrendering directly to the 'Supreme Creator' Lord Sri Krishna Himself who operates eternally situated infinitely far beyond the jurisdiction of these material algorithms.
        """.trimIndent()
    ),
    Shloka(
        id = 41,
        sanskrit = """
            ब्राह्मणक्षत्रियविशां शूद्राणां च परन्तप |
            कर्माणि प्रविभक्तानि स्वभावप्रभवैर्गुणैः || ४१ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 41 से 44 तक वर्ण व्यवस्था का वैज्ञानिक आधार बताया गया है)
            हे परन्तप अर्जुन! ब्राह्मणों, क्षत्रियों, वैश्यों और शूद्रों के जो भी काम (कर्माणि) और ड्यूटीज़ (Duties) इस समाज में अलग-अलग बाँटे गए हैं (प्रविभक्तानि)।
            वे सभी काम उनके जन्म या जाति के आधार पर नहीं, बल्कि उनके अपने स्वयं के भीतरी स्वभाव और प्रकृति से पैदा हुए 'गुणों' (सत्त्व, रजस, तमस) के आधार पर ही बहुत ही साइंटिफिक तरीके से बाँटे गए हैं (स्वभावप्रभवैर्गुणैः)।
            यह श्लोक सनातन धर्म के 'वर्ण-व्यवस्था' (Caste System) पर फैले हुए दुनिया के सबसे बड़े झूठ और कंफ्यूजन को हमेशा के लिए एक ही झटके में पूरी तरह से खत्म कर देता है!
            समाज के कुछ स्वार्थी लोगों ने यह गलत नियम बना दिया कि "ब्राह्मण का बेटा हमेशा ब्राह्मण होगा और शूद्र का बेटा हमेशा शूद्र होगा," चाहे उसके अंदर कोई क्वालिटी (Quality) हो या न हो।
            लेकिन भगवान श्रीकृष्ण यहाँ डंके की चोट पर ऐलान करते हैं कि ब्रह्मांड का सिस्टम (System) किसी के 'डीएनए' (DNA) या 'सरनेम' (Surname) से उसकी जाति तय नहीं करता है!
            भगवान कहते हैं कि मैंने समाज को चलाने के लिए इंसानों को उनके अंदर के 'सॉफ्टवेयर' (गुणों) के हिसाब से 4 अलग-अलग प्रोफेशन (Professions) में डिवाइड (Divide) किया है, ताकि दुनिया का सिस्टम परफेक्ट चले।
            जिस इंसान के दिमाग का सॉफ्टवेयर 'सत्त्व गुण' (ज्ञान और शांति) का है, वह ऑटोमैटिक रूप से एक 'ब्राह्मण' (टीचर/गाइड) है, चाहे वह किसी भी घर में पैदा हुआ हो।
            जिसका सॉफ्टवेयर 'रजोगुण' (एग्रेसन और लीडरशिप) का है, वह 'क्षत्रिय' (सैनिक/रक्षक) है; जो बिज़नेस माइंडेड है, वह 'वैश्य' है; और जो केवल फिजिकल मेहनत (लेबर) कर सकता है, वह 'शूद्र' है।
            यह कोई ऊंच-नीच या भेदभाव नहीं है, बल्कि यह एक बहुत ही हाई-लेवल का 'एचआर मैनेजमेंट' (HR Management) है, जहाँ सही टैलेंट (Talent) वाले इंसान को सही जॉब (Job) दी जा रही है।
            भगवान की यह व्यवस्था इंसान के कैरेक्टर (Character) और उसकी मेंटल कैपेसिटी (Mental Capacity) पर आधारित है, न कि उसकी जन्मपत्री (Birth Certificate) पर।
        """.trimIndent(),
        english = """
            (Verses 41 through 44 scientifically decode the absolute authentic foundation of the Varna system)
            O chastiser of the enemies Arjuna! The various specific activities prescribed duties and professional responsibilities of the Brahmanas the Kshatriyas the Vaishyas and the Shudras are clearly divided (Pravibhaktani).
            These specific duties are absolutely NOT mathematically divided based on cheap biological birth or social caste but are strictly and flawlessly assigned according to the inherent material modes (Sattva, Rajas, Tamas) born of their own internal psychological nature (Svabhava-prabhavair gunaih).
            This spectacular verse violently annihilates and permanently deletes the absolute biggest global lie and toxic confusion historically surrounding the eternal Sanatana Dharma's 'Varna System' (System of Social Orders) in one single explosive stroke!
            Corrupt and highly selfish mortals artificially manufactured the toxic false rule demanding that "A priest's son is legally always a priest and a laborer's son is forever a laborer" regardless of their actual psychological zero-quality.
            But Lord Sri Krishna drops an absolute titanium decree here publicly broadcasting that the universal operating system mathematically NEVER defines a human's cosmic status based on his biological 'DNA' or his cheap earthly 'Surname'!
            The Lord explicitly declares that He specifically engineered society into 4 distinct macro-'Professions' dividing humans strictly based on their internal psychological 'Software' (Modes) to ensure the global matrix functions with absolute 100% mechanical perfection.
            Any human whose brain heavily operates on the 'Sattvic Software' (profound wisdom and peace) is automatically instantly biologically classified as a 'Brahmana' (Elite Teacher/Guide) regardless of which hospital or family he was born into.
            A human aggressively fueled by 'Rajas' (Leadership and combat) is a 'Kshatriya' (Protector); the one hardwired for corporate calculation is a 'Vaishya' (Businessman); and the one whose software only supports raw physical labor is a 'Shudra' (Worker).
            This is absolutely not a toxic system of pathetic discrimination or racial superiority; it is the multiverse's absolute most advanced 'Elite HR Management System' flawlessly assigning the perfect human talent to the exact correct cosmic job.
            God's infallible system is constructed entirely upon a human's unadulterated internal 'Character' and verified 'Mental Capacity' completely ignoring the pathetic irrelevance of a biological 'Birth Certificate'.
        """.trimIndent()
    ),
    Shloka(
        id = 42,
        sanskrit = """
            शमो दमस्तपः शौचं क्षान्तिरार्जवमेव च |
            ज्ञानं विज्ञानमास्तिक्यं ब्रह्मकर्म स्वभावजम् || ४२ ||
        """.trimIndent(),
        hindi = """
            मन को पूरी तरह शांत और कंट्रोल में रखना (शमः), अपनी सभी इन्द्रियों को अनुशासन में रखना (दमः), शारीरिक और मानसिक तपस्या करना (तपः), तथा भीतर और बाहर से अत्यंत पवित्र रहना (शौचं)।
            दूसरों की गलतियों को माफ करने की शक्ति (क्षान्तिः), स्वभाव में बिल्कुल सीधापन और सरलता (आर्जवम्), वेदों का सैद्धांतिक ज्ञान (ज्ञानं), उस ज्ञान का प्रैक्टिकल अनुभव (विज्ञानं), और ईश्वर पर 100% अटल विश्वास (आस्तिक्यं)।
            ये सभी नौ अत्यंत उच्च और दिव्य गुण एक सच्चे 'ब्राह्मण' के स्वाभाविक कर्म हैं जो उसकी अपनी प्रकृति (स्वभाव) से ही उसके अंदर पैदा होते हैं (ब्रह्मकर्म स्वभावजम्)।
            भगवान यहाँ एक असली 'ब्राह्मण' (Brahmana / इंटेलेक्चुअल और स्पिरिचुअल गाइड) की सबसे परफेक्ट और 100% साइंटिफिक 'जॉब डिस्क्रिप्शन' (Job Description) दुनिया को दे रहे हैं।
            ब्राह्मण वह नहीं है जो केवल संस्कृत के मंत्र रट लेता है या गले में एक धागा (जनेऊ) पहन लेता है; ब्राह्मण वह एलीट (Elite) इंसान है जिसका अपने दिमाग (शम) और शरीर (दम) पर एक कमांडो (Commando) जैसा कंट्रोल होता है।
            उसका कैरेक्टर एक डायमंड (Diamond) की तरह साफ होता है, वह किसी से नफरत नहीं करता (क्षान्ति), और उसके अंदर कोई भी घमंड या पॉलिटिक्स (Politics) नहीं होती (आर्जव)।
            सबसे बड़ी बात, उसके पास केवल किताबों का सूखा 'ज्ञान' (Theory) नहीं होता; उसने उस ज्ञान को अपनी ज़िंदगी में अप्लाई (Apply) करके उसका 'विज्ञान' (Practical Experience) भी हासिल किया होता है।
            और उसका 'आस्तिक्य' यानी भगवान पर विश्वास इतना भयंकर और टाइटेनियम (Titanium) की तरह मजबूत होता है कि दुनिया की कोई भी साइंस या ताकत उसे डरा नहीं सकती।
            जिस इंसान के अंदर ये 9 सुपर-क्वालिटीज़ (Super-qualities) नेचुरली (Naturally) पाई जाती हैं, ब्रह्मांड का सिस्टम केवल उसी को 'ब्राह्मण' मानता है, बाकी सब केवल दिखावे के नाम हैं।
            यह श्लोक साबित करता है कि समाज का लीडर (Leader) बनने के लिए इंसान के पास पैसे नहीं, बल्कि ऐसा बेदाग और पावरफुल कैरेक्टर (Character) होना चाहिए।
        """.trimIndent(),
        english = """
            Maintaining absolute profound peacefulness and flawless control of the mind (Shamah) executing rigorous military-grade discipline over the biological senses (Damah) undergoing severe austerity (Tapah) and maintaining immaculate internal and external purity (Shaucham).
            Possessing the terrifying power of ultimate tolerance and forgiveness (Kshantih) maintaining absolute straightforwardness and unadulterated simplicity (Arjavam) acquiring profound theoretical knowledge (Jnanam) executing its practical realization (Vijnanam) and holding 100% titanium faith in the Supreme (Astikyam).
            These nine extraordinarily elite highly elevated and divine qualities constitute the natural inherent work and biological psychology of a true authentic Brahmana born strictly of his own internal nature (Brahma-karma svabhava-jam).
            The Lord is officially downloading the absolute most perfect flawless and 100% scientific 'Job Description' of a genuine 'Brahmana' (An Elite Intellectual and Spiritual Cosmic Guide) to the entire world.
            A true Brahmana is absolutely not a pathetic fraud who merely memorizes a few Sanskrit hymns or wears a cheap thread; he is a terrifyingly elite entity who exercises commando-level domination over his brain (Shama) and biology (Dama).
            His internal character shines flawlessly like a polished diamond he harbors mathematically zero hatred effortlessly forgiving his enemies (Kshanti) and operates entirely without any toxic political agendas or fake diplomacy (Arjava).
            Most critically he does not merely possess dry useless academic 'Theory' (Jnanam); he has violently applied that quantum data into real-life practice successfully unlocking the absolute 'Practical Experience' (Vijnanam).
            And his 'Astikya' (Absolute conviction in God) is forged from such indestructible cosmic titanium that absolutely no modern science atheistic logic or physical threat can ever shake his beliefs.
            Any human entity whose biological software naturally runs these 9 specific 'Super-Qualities' is the absolute ONLY one legally recognized by the universal operating system as a 'Brahmana'; all others claiming the title are merely theatrical frauds.
            This spectacular verse proves mathematically that to successfully lead and guide global society a human requires absolutely zero bank balance but mandatorily needs this spotless intensely powerful and flawless psychological character.
        """.trimIndent()
    ),
    Shloka(
        id = 43,
        sanskrit = """
            शौर्यं तेजो धृतिर्दाक्ष्यं युद्धे चाप्यपलायनम् |
            दानमीश्वरभावश्च क्षात्रं कर्म स्वभावजम् || ४३ ||
        """.trimIndent(),
        hindi = """
            अत्यंत भयंकर शूरवीरता और निडरता (शौर्यं), एक बहुत ही तेज़ और प्रभावशाली व्यक्तित्व (तेजः), कभी न टूटने वाला धैर्य (धृतिः), हर काम को करने में गज़ब की चतुराई और कुशलता (दाक्ष्यं)।
            युद्ध के मैदान से कभी भी पीठ दिखाकर न भागने की कसम (युद्धे चाप्यपलायनम्), बिना किसी स्वार्थ के खूब दान देने की उदारता (दानम्), और समाज पर शासन करने या लीडरशिप करने की स्वाभाविक क्षमता (ईश्वरभावश्च)।
            ये सभी सात महान और अजेय गुण एक असली 'क्षत्रिय' (Kshatriya / रक्षक या योद्धा) के स्वाभाविक कर्म और लक्षण हैं जो उसकी प्रकृति से ही उसके अंदर मौजूद होते हैं।
            भगवान यहाँ एक असली 'सुपर-सोल्जर' (Super-soldier) और एक परफेक्ट लीडर (Perfect Leader) की सबसे खतरनाक और पावरफुल प्रोफाइल (Profile) दुनिया के सामने रख रहे हैं।
            क्षत्रिय वह नहीं है जिसके हाथ में बंदूक है; क्षत्रिय वह है जिसके अंदर 'शौर्य' (Courage) का ऐसा भयंकर आग जल रहा है कि वह मौत को सामने देखकर भी बिल्कुल नहीं घबराता।
            उसके चेहरे पर एक ऐसा 'तेज' (Aura) होता है जिसे देखकर ही दुश्मन की आधी ताकत खत्म हो जाती है, और उसका 'धैर्य' (धृति) इतना बड़ा होता है कि वह किसी भी मुश्किल में पैनिक (Panic) नहीं करता।
            वह केवल ताकतवर नहीं होता, बल्कि वह 'दाक्ष्यं' (Expert) होता है; वह हर सिचुएशन को बहुत ही चालाकी और स्मार्टनेस (Smartness) के साथ हैंडल (Handle) करना जानता है।
            "युद्धे चाप्यपलायनम्"—यह एक क्षत्रिय का सबसे बड़ा धर्म है! चाहे दुश्मन करोड़ों हों या उसकी अपनी जान जा रही हो, उसके डिक्शनरी (Dictionary) में 'भागना' (Retreat) शब्द होता ही नहीं है।
            और वह केवल लड़ना नहीं जानता; वह गरीबों को 'दान' देने वाला सबसे बड़ा दिल वाला इंसान होता है और उसके अंदर समाज को कंट्रोल करने का एक नेचुरल 'बॉस-माइंडसेट' (ईश्वरभाव) होता है।
            ये 7 क्वालिटीज़ (Qualities) जिस इंसान के ब्लड (Blood) और डीएनए (DNA) में नेचुरली (Naturally) बहती हैं, भगवान के सिस्टम में वही इंसान असली क्षत्रिय और दुनिया का रक्षक कहलाने का हकदार है।
        """.trimIndent(),
        english = """
            Absolute terrifying heroism and fearless courage (Shauryam) a blinding and highly influential majestic aura (Tejah) unbreakable titanium determination (Dhritih) and extraordinary brilliant resourcefulness and expertise in all actions (Dakshyam).
            The absolute unyielding vow to absolutely never mathematically retreat or flee cowardly from any bloody battlefield (Yuddhe chapy apalayanam) possessing a massive heart for supreme generosity (Danam) and the natural biological capacity for supreme leadership and governance (Ishvara-bhavash cha).
            These seven specific magnificent and invincible qualities constitute the natural inherent work and biological psychology of a true authentic Kshatriya (Warrior/Protector) born strictly of his own internal nature.
            The Supreme Lord is officially aggressively uploading the absolute most terrifyingly powerful and flawless psychological profile of an elite 'Super-Soldier' and ultimate global Leader for the entire multiverse to witness.
            A Kshatriya is absolutely not a pathetic thug merely holding a weapon; he is an elite entity whose internal engine burns with such a horrific fire of 'Courage' (Shaurya) that he stares directly into the eyes of death without a microsecond of panic.
            His physical presence radiates such a blinding 'Tejas' (Aura) that it mathematically instantly vaporizes half the psychological strength of his enemies and his titanium 'Patience' (Dhriti) ensures he absolutely never panics in catastrophic disasters.
            He is not merely a machine of brute force; he is incredibly 'Dakshya' (Expert) possessing the razor-sharp tactical brilliance to flawlessly and smoothly navigate the most dangerously complex cosmic situations.
            "Yuddhe chapy apalayanam"—This is the absolute supreme unyielding law of a warrior! Even if faced with a billion heavily armed enemies or guaranteed biological death the word 'Retreat' has been permanently violently deleted from his psychological dictionary.
            And he is absolutely not just a killing machine; he possesses an unimaginably massive heart effortlessly executing supreme 'Charity' and biologically naturally operates on an elite 'Boss-Mindset' (Ishvara-bhava) explicitly engineered to govern global society.
            Any human whose blood and biological DNA naturally furiously pumps with these 7 exact 'Super-Qualities' is the absolute ONLY entity legally authorized by God's universal system to be officially titled a true Kshatriya and global protector.
        """.trimIndent()
    ),
    Shloka(
        id = 44,
        sanskrit = """
            कृषिगौरक्ष्यवाणिज्यं वैश्यकर्म स्वभावजम् |
            परिचर्यात्मकं कर्म शूद्रस्यापि स्वभावजम् || ४४ ||
        """.trimIndent(),
        hindi = """
            खेती करना (कृषि), गायों और जानवरों की बहुत अच्छी तरह से रक्षा और पालन करना (गौरक्ष्य), तथा व्यापार या बिज़नेस करना (वाणिज्यं)—ये तीनों काम एक 'वैश्य' के स्वाभाविक कर्म हैं जो उसकी प्रकृति (स्वभाव) से पैदा होते हैं।
            और दूसरों की सेवा करना (परिचर्यात्मकं) तथा शारीरिक मेहनत (लेबर) वाले सभी काम करना एक 'शूद्र' का स्वाभाविक और जन्मजात कर्म माना गया है।
            भगवान यहाँ समाज के उस 'इकोनॉमिक' (Economic) और 'सपोर्ट' (Support) सिस्टम को डिकोड कर रहे हैं जिसके बिना कोई भी देश या दुनिया एक दिन भी ज़िंदा नहीं रह सकती।
            वैश्य वह इंसान है जिसका माइंडसेट (Mindset) पूरी तरह से 'प्रोडक्शन' (Production) और 'वेल्थ-क्रिएशन' (Wealth-creation) के लिए डिज़ाइन किया गया है; वह समाज की अर्थव्यवस्था (Economy) का इंजन है।
            उसका काम केवल ऑफिस में बैठकर मुनाफा कमाना नहीं है; भगवान ने उसे 'कृषि' (अन्न उगाना) और 'गौरक्ष्य' (जानवरों को बचाना) की भी सबसे बड़ी ज़िम्मेदारी दी है ताकि समाज को शुद्ध खाना मिल सके।
            आज के ज़माने में जो लोग खेती और व्यापार को ईमानदारी से करते हुए समाज की भलाई करते हैं, वे साक्षात वैश्य धर्म का पालन कर रहे हैं।
            और 'शूद्र' वह इंसान है जिसके दिमाग में बहुत ज़्यादा ज्ञान (ब्राह्मण), लीडरशिप (क्षत्रिय) या बिज़नेस (वैश्य) के हाई-लेवल के कैलकुलेशन्स (Calculations) नहीं होते।
            उसका सॉफ्टवेयर केवल 'हार्ड-वर्क' (Hard-work / शारीरिक मेहनत) और 'सर्विस' (Service / सेवा) के लिए बना है; वह समाज का वो सबसे मजबूत पिलर (Pillar) है जिसके बिना बाकी तीनों वर्ण पूरी तरह फेल हो जाएंगे।
            भगवान की नज़र में न तो ब्राह्मण बड़ा है और न ही शूद्र छोटा है; ये चारों वर्ण एक ही शरीर के सिर, हाथ, पेट और पैरों की तरह हैं जो एक साथ मिलकर काम करते हैं।
            जिसका जो स्वभाव और टैलेंट (Talent) है, अगर वह बिना किसी शर्म या घमंड के वही काम ईमानदारी से करे, तो समाज बिल्कुल परफेक्ट (Perfect) और शांतिपूर्ण तरीके से चलता है।
        """.trimIndent(),
        english = """
            Aggressively engaging in agriculture and farming (Krishi) executing the absolute flawless protection and maintenance of cows (Gau-rakshya) and systematically conducting trade and corporate commerce (Vanijyam)—these three constitute the natural inherent work of a Vaishya.
            And executing tasks fundamentally consisting of dedicated physical service and intensive manual labor assisting others (Paricharyatmakam) is officially mathematically categorized as the natural inherent biological work of a Shudra.
            The Supreme Lord is completely decoding the absolute massive 'Economic' and foundational 'Support' architecture of the matrix without which absolutely no global civilization could mathematically survive for even 24 hours.
            A Vaishya is a highly specialized entity whose psychological software is explicitly and aggressively engineered strictly for massive 'Production' and global 'Wealth-Creation'; he physically operates as the titanium engine of the planet's economy.
            His cosmic duty absolutely does not end at merely hoarding corporate profits; God has officially assigned him the massive life-saving responsibility of 'Krishi' (generating global food) and 'Gau-rakshya' (protecting biological assets) to ensure society receives pure nourishment.
            In the modern matrix any elite entrepreneur who executes flawless honest business while aggressively feeding and sustaining the global population is operating perfectly within the authorized Vaishya Dharma.
            And a 'Shudra' is a specific human entity whose biological brain is absolutely not hardwired for the complex high-level quantum calculations required for advanced wisdom (Brahmana) brutal leadership (Kshatriya) or massive corporate trade (Vaishya).
            His psychological operating system is exclusively optimally designed strictly for relentless 'Hard-Work' and dedicated 'Service'; he is literally the absolute most indestructible titanium pillar of society without which the other three classes would catastrophically instantly collapse.
            In the absolute flawless vision of the Supreme Creator a Brahmana is absolutely not biologically superior and a Shudra is absolutely not inferior; these four classes operate exactly like the head arms stomach and legs of one singular massive cosmic body functioning in perfect unison.
            If every human strictly and aggressively executes his own biologically natural talent with 100% pure integrity completely devoid of toxic shame or bloated arrogance the global matrix functions with absolute mathematical perfection and unbroken peace.
        """.trimIndent()
    ),
    Shloka(
        id = 45,
        sanskrit = """
            स्वे स्वे कर्मण्यभिरतः संसिद्धिं लभते नरः |
            स्वकर्मनिरतः सिद्धिं यथा विन्दति तच्छृणु || ४५ ||
        """.trimIndent(),
        hindi = """
            मनुष्य अपने-अपने स्वाभाविक और जन्मजात कर्मों (ड्यूटीज़) में पूरी निष्ठा और ईमानदारी से लगा रहकर ही परम सिद्धि या परफेक्शन (संसिद्धिं) को प्राप्त कर सकता है।
            हे अर्जुन! अब तुम मुझसे यह बहुत ध्यान से सुनो कि इंसान अपने ही साधारण कर्मों को करते हुए किस प्रकार भगवान और मोक्ष को पा सकता है (यथा विन्दति तच्छृणु)।
            यह श्लोक उन लोगों की गलतफहमी को हमेशा के लिए मिटा देता है जो सोचते हैं कि भगवान केवल मंदिर में बैठकर पूजा करने से या जंगल जाने से ही मिलते हैं।
            भगवान बहुत स्पष्ट रूप से कहते हैं कि तुम्हारी जो भी नौकरी या काम है (चाहे तुम एक सैनिक हो, बिज़नेसमैन हो या सफाई-कर्मचारी), वही तुम्हारी सबसे बड़ी पूजा और ईश्वर तक पहुँचने का इकलौता रास्ता है।
            अगर एक सफाई कर्मचारी अपना काम 100% ईमानदारी से करता है, तो उसकी वह सफाई किसी भी पाखंडी ब्राह्मण की झूठी पूजा से करोड़ों गुना ज्यादा पवित्र है।
            ब्रह्मांड का सिस्टम यह बिल्कुल नहीं देखता कि आप क्या काम कर रहे हैं, बल्कि वह यह 'ऑडिट' (Audit) करता है कि आप उस काम को किस नीयत और कितने फोकस (Focus) से कर रहे हैं।
            अपनी खुद की ड्यूटी को पूरी परफेक्शन के साथ करना ही सबसे बड़ा 'योग' है और यही इंसान को 'स्पिरिचुअल इवोल्यूशन' (Spiritual Evolution) के टॉप लेवल तक बहुत तेज़ी से ले जाता है।
            इंसान को कभी भी अपने काम को छोटा या नीचा नहीं समझना चाहिए क्योंकि हर काम इस पूरे 'कॉस्मिक मशीनरी' (Cosmic Machinery) का एक बहुत ही महत्वपूर्ण और ज़रूरी हिस्सा है।
            जो इंसान अपनी ड्यूटी को साक्षात् भगवान का आदेश मानकर बिना किसी घमंड के पूरा करता है, उसे जीवन में कभी भी कोई पाप या कर्म-बंधन छू भी नहीं सकता।
            यही कर्म-योग का सबसे अल्टीमेट और पावरफुल सीक्रेट है जो इंसान को दुनिया के बीच रहकर भी पूरी तरह से एक सन्यासी और सिद्ध योगी बना देता है; अब भगवान आगे इसी का तरीका बताएंगे।
        """.trimIndent(),
        english = """
            By deeply and flawlessly engaging strictly in his own specific natural work and innate duty a human being can mathematically achieve ultimate absolute perfection (Samsiddhim).
            O Arjuna! Now please listen with absolute titanium focus as I officially explicitly explain exactly how a human flawlessly attains the Supreme Lord simply by executing his ordinary daily prescribed job (Yatha vindati tach chhrinu).
            This spectacular verse permanently and violently incinerates the toxic global hallucination that God can only be accessed by abandoning society and sitting idly in a temple or escaping to a remote Himalayan cave.
            The Supreme Creator explicitly decrees that whatever specific biological job or corporate duty you naturally possess (whether a soldier an entrepreneur or a street sweeper) that exact labor is your absolute highest worship and direct highway to God.
            If a street sweeper aggressively executes his cleaning with 100% flawless integrity that specific physical labor is mathematically millions of times more sacred and pure than the hollow hypocritical rituals of an arrogant priest.
            The universal operating system absolutely does not audit or care about the external category of your job title; it rigorously and clinically audits the internal purity intention and laser-focus with which you execute that specific task.
            Executing your assigned biological duty with absolute flawless perfection is the ultimate highest form of yoga instantly catapulting your soul to the supreme peak of spiritual evolution.
            A human must absolutely never degrade or toxically underestimate his own prescribed labor because absolutely every single job is a highly critical mandatory functioning gear within the massive infinite cosmic machinery.
            The elite human who aggressively treats his daily mundane duty as a direct sacred command from the Supreme Godhead entirely devoid of toxic ego remains mathematically 100% immune to all karmic entanglement and sin.
            This is the absolute ultimate and terrifyingly powerful secret of Karma-Yoga empowering a mortal to live deep inside the chaotic matrix while functioning flawlessly as a perfectly liberated elite Yogi; the Lord will now reveal exactly how to execute this.
        """.trimIndent()
    ),
    Shloka(
        id = 46,
        sanskrit = """
            यतः प्रवृत्तिर्भूतानां येन सर्वमिदं ततम् |
            स्वकर्मणा तमभ्यर्च्य सिद्धिं विन्दति मानवः || ४६ ||
        """.trimIndent(),
        hindi = """
            जिस परमेश्वर से इस ब्रह्मांड के सभी प्राणियों की उत्पत्ति हुई है (यतः प्रवृत्तिर्भूतानां) और जिस ईश्वर से यह पूरा का पूरा ब्रह्मांड सब तरफ से व्याप्त (पूरी तरह से भरा हुआ) है (येन सर्वमिदं ततम्)।
            मनुष्य केवल अपने स्वाभाविक कर्मों (ड्यूटी) को 100% ईमानदारी से पूरा करके उसी रूप में उस परमेश्वर की पूजा (तमभ्यर्च्य) करता है और अंततः परम सिद्धि (मोक्ष) को प्राप्त कर लेता है।
            यह श्लोक 'कर्म ही पूजा है' (Work is Worship) के दुनिया के सबसे फेमस और पावरफुल सिद्धांत का असली और 100% साइंटिफिक आधार (Scientific Foundation) है!
            भगवान कहते हैं कि तुम्हें मुझे ढूँढने के लिए किसी विशेष दिशा या आसमान में देखने की कोई ज़रूरत नहीं है, क्योंकि यह पूरी दुनिया और तुम्हारे आस-पास का हर इंसान मेरी ही एनर्जी (Energy) से भरा हुआ है।
            ईश्वर इस मैट्रिक्स के हर एक कण में 'कोडिंग' (Coding) की तरह व्याप्त है; इसलिए जब तुम समाज के लिए अपना काम पूरी मेहनत से करते हो, तो तुम इनडायरेक्टली (Indirectly) मेरी ही सेवा कर रहे हो।
            एक डॉक्टर जब किसी की जान बचाता है या एक सैनिक जब देश की रक्षा करता है, तो वह अपना काम नहीं कर रहा होता; वह अपने काम रूपी 'फूल' से साक्षात उस 'सुप्रीम क्रिएटर' की पूजा कर रहा होता है।
            तुम्हारी ड्यूटी ही तुम्हारा 'मंत्र' है और तुम्हारा पसीना ही तुम्हारा 'हवन' है; अगर तुमने अपने काम में कोई चोरी या बेईमानी नहीं की, तो भगवान तुम्हारे उस काम को सीधे अपनी आरती मान लेते हैं।
            यह माइंडसेट (Mindset) इंसान की पूरी ज़िंदगी को एक बहुत बड़े 'स्पिरिचुअल इवेंट' (Spiritual Event) में बदल देता है जहाँ ऑफिस की डेस्क (Desk) ही भगवान का मंदिर बन जाती है।
            जिस दिन इंसान को यह भयंकर और गहरा सच समझ आ जाता है कि "मेरा हर एक्शन भगवान कैमरे से देख रहे हैं," उस दिन से वह कोई भी काम गलत या आधा-अधूरा नहीं कर सकता।
            इसी परफेक्ट कर्म-पूजा से इंसान का दिमाग इतना शुद्ध हो जाता है कि वह सीधा उस 'परम सिद्धि' को हैक कर लेता है जिसके लिए बड़े-बड़े योगी जंगलों में भटकते रहते हैं।
        """.trimIndent(),
        english = """
            By explicitly worshiping the Supreme Lord—who is the absolute original source of all living entities (Yatah pravrittir bhutanam) and by whom this entire massive cosmic universe is completely pervaded (Yena sarvam idam tatam)—a human being mathematically attains supreme ultimate perfection simply by flawlessly executing his own prescribed duties (Sva-karmana tam abhyarchya).
            This spectacular verse establishes the absolute authentic 100% scientific foundational root for the world's most famous and terrifyingly powerful doctrine: "Work is strictly Worship"!
            The Lord explicitly declares that you absolutely do not need to desperately search the sky or look in specific directions to find Me because this entire 3D matrix and every human around you is heavily saturated exclusively with My divine energy.
            God exists perfectly encoded within every single microscopic atom of this simulation exactly like the foundational source code; therefore when you fiercely execute your duties for society you are mathematically indirectly serving and worshipping ME.
            When an elite surgeon saves a dying life or a fearless soldier defends his borders he is absolutely not merely doing a mundane job; he is actively utilizing his flawless physical labor as a 'Sacred Flower' to execute direct high-level worship of the Supreme Creator.
            Your daily assigned duty is your ultimate 'Mantra' and your brutally exhausting physical sweat is your sacred 'Sacrifice'; if you execute your work with absolutely zero theft or corruption God instantly registers that labor as His supreme personal worship.
            This elite psychological mindset successfully violently upgrades a human's entire biological timeline into one massive continuous 'Spiritual Event' where his boring corporate desk literally transforms into the supreme sacred altar of God.
            The exact microsecond a mortal deeply internalizes the terrifying truth that "God is actively auditing every single physical action I execute via cosmic cameras," it becomes mathematically impossible for him to perform any flawed or evil work.
            Through this flawless execution of Karma-Puja (Work as Worship) the human's biological brain becomes so unimaginably purified that he successfully hacks the 'Supreme Perfection' that elite yogis wander the jungles for decades trying to find.
        """.trimIndent()
    ),
    Shloka(
        id = 47,
        sanskrit = """
            श्रेयान्स्वधर्मो विगुणः परधर्मात्स्वनुष्ठितात् |
            स्वभावनियतं कर्म कुर्वन्नाप्नोति किल्बिषम् || ४७ ||
        """.trimIndent(),
        hindi = """
            अपने खुद के स्वाभाविक धर्म (स्वधर्म) का पालन करना चाहे वह कितना भी दोषपूर्ण या कमियों से भरा हुआ (विगुणः) क्यों न लगे, दूसरों के धर्म (परधर्म) की बहुत अच्छी तरह से नकल करने से करोड़ों गुना ज्यादा श्रेष्ठ (श्रेयान्) है।
            क्योंकि जो मनुष्य अपने ही स्वभाव और प्रकृति के अनुसार तय किए गए कर्मों (स्वभावनियतं कर्म) को पूरी ईमानदारी से करता है, उसे कभी भी कोई पाप (किल्बिषम्) नहीं लगता।
            यह श्लोक भगवद्गीता के तीसरे अध्याय में भी आया था और यहाँ अठारहवें अध्याय में भगवान इसे अपने सबसे बड़े नियम (Master Rule) के रूप में दोबारा कन्फर्म (Confirm) कर रहे हैं!
            इंसान की सबसे बड़ी मानसिक बीमारी यह है कि वह हमेशा दूसरों की ज़िंदगी और दूसरों के प्रोफेशन को देखकर जलता है और उनकी नकल (Copy) करना चाहता है।
            एक योद्धा (क्षत्रिय) सोचता है कि "मैं भी किसी ब्राह्मण की तरह जंगल में जाकर शांति से बैठ जाऊं," क्योंकि उसे अपना युद्ध का काम खून-खराबे वाला (विगुण) लगता है (यही अर्जुन की प्रॉब्लम थी)।
            लेकिन भगवान एक बहुत ज़ोरदार थप्पड़ मारते हुए कहते हैं कि "अगर एक शेर घास खाने की कोशिश करेगा, तो वह अपनी प्रकृति के खिलाफ जाएगा और भूखा मर जाएगा; शेर का धर्म शिकार करना ही है।"
            भगवान कहते हैं कि अगर तुम अपनी 'ओरिजिनल प्रोग्रामिंग' (Original Programming / स्वभाव) के हिसाब से काम कर रहे हो, तो चाहे उस काम में थोड़ी बहुत हिंसा या गलती भी हो, तुम्हें ब्रह्मांड के कोर्ट में कोई पाप नहीं लगेगा।
            लेकिन अगर तुम किसी दूसरे की जिंदगी चुराकर एक फेक (Fake) और बनावटी जीवन जीने की कोशिश करोगे, तो तुम खुद को और समाज दोनों को बर्बाद कर दोगे।
            इसलिए कभी भी दूसरों को देखकर अपना 'कैरियर' (Career) या अपनी 'ड्यूटी' मत बदलो; तुम्हारे अंदर जो टैलेंट (Talent) नैचुरली (Naturally) भगवान ने डाला है, उसी को अपना हथियार बनाओ।
            अपनी ऑथेंटिक (Authentic) और असली ज़िंदगी जीना ही दुनिया का सबसे बड़ा परफेक्शन है, और यही वो अल्टीमेट राज़ है जो इंसान को पापों से बचाकर 100% फ्री (Free) कर देता है।
        """.trimIndent(),
        english = """
            It is mathematically far better and infinitely more superior (Shreyan) to execute one's own natural prescribed duty (Sva-dharmah) even if it is heavily flawed and completely imperfect (Vigunah) than to flawlessly and perfectly execute another's duty (Para-dharmat).
            Because when a human being aggressively and honestly performs the specific biological duties strictly dictated by his own inherent psychological nature (Svabhava-niyatam karma) he mathematically never incurs any cosmic sin or toxic karmic reaction (Na apnoti kilbisham).
            This spectacular verse appeared previously in the Third Chapter and here in the ultimate Eighteenth Chapter the Supreme Lord aggressively re-confirms it as His absolute unshakeable 'Master Rule' of the universe!
            Humanity's absolute greatest and most toxic psychological disease is permanently obsessing over other people's lives generating violent jealousy and pathetically attempting to 'Copy' someone else's biological profession.
            An elite warrior (Kshatriya) foolishly hallucinates "I should cowardly retreat to a peaceful jungle exactly like a Brahmana" simply because his mandated duty of war appears horribly bloody and 'Faulty' (Vigunah)—this was precisely Arjuna's catastrophic glitch.
            But the Supreme Lord delivers a brutal psychological slap stating: "If an apex predator like a lion artificially attempts to graze on grass it violently violates its own cosmic programming and starves to death; the lion's absolute Dharma is to hunt."
            The Lord decrees that if you are flawlessly executing actions perfectly aligned with your 'Original Biological Programming' (Svabhava) even if that specific task inherently involves microscopic violence or apparent flaws the cosmic court officially mathematically charges you with ZERO sin.
            But if you arrogantly attempt to pirate someone else's timeline violently forcing yourself to live a completely 'Fake' and artificial existence you will mathematically guarantee the catastrophic destruction of both your own soul and global society.
            Therefore absolutely never drastically change your career path or dump your assigned 'Duty' merely by blindly copying a successful neighbor; aggressively weaponize the exact unique biological talent God organically installed into your DNA.
            Living a 100% brutally authentic original existence is the absolute highest form of cosmic perfection and this is the ultimate heavily guarded secret that flawlessly immunizes a human against all sin granting him absolute eternal freedom.
        """.trimIndent()
    ),
    Shloka(
        id = 48,
        sanskrit = """
            सहजं कर्म कौन्तेय सदोषमपि न त्यजेत् |
            सर्वारम्भा हि दोषेण धूमेनाग्निरिवावृताः || ४८ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र अर्जुन! अपने स्वाभाविक और जन्मजात कर्म (सहजं कर्म) को कभी भी नहीं छोड़ना चाहिए, भले ही उस काम में कोई बहुत बड़ा दोष (सदोषमपि) या कमी ही क्यों न दिखाई दे।
            क्योंकि इस दुनिया के जितने भी कर्म और प्रोजेक्ट्स (सर्वारम्भा) हैं, वे सभी किसी न किसी दोष या बुराई से उसी तरह पूरी तरह से घिरे हुए (आवृताः) हैं, जैसे कोई आग हमेशा धुएं से घिरी होती है (धूमेनाग्निरिवावृताः)।
            भगवान यहाँ इंसान के 'परफेक्शनिज़्म' (Perfectionism / सब कुछ 100% परफेक्ट चाहने की बीमारी) के भ्रम को एक बहुत ही शानदार और साइंटिफिक उदाहरण देकर पूरी तरह से तोड़ रहे हैं।
            अर्जुन सोच रहा था कि युद्ध करने में बहुत लोगों का खून बहेगा और यह काम बहुत 'दोषपूर्ण' (Faulty) है, इसलिए मुझे इसे छोड़कर सन्यास ले लेना चाहिए।
            लेकिन भगवान उसे एक तमाचा मारते हुए याद दिलाते हैं कि "अरे मूर्ख! इस 3D मैट्रिक्स में ऐसा कोई भी काम बना ही नहीं है जो 100% प्योर (Pure) हो और जिसमें कोई साइड-इफेक्ट (Side-effect) न हो।"
            जैसे बिना धुएं के कभी आग नहीं जल सकती, वैसे ही बिना किसी छोटी-मोटी हिंसा या दोष के कोई भी काम (यहाँ तक कि साँस लेना भी) पूरा नहीं हो सकता!
            अगर तुम खेती करोगे तो कीड़े मरेंगे, अगर तुम चलेंगे तो पैरों के नीचे चींटियां मरेंगी; तो क्या तुम इस 'धुएं' (दोष) के डर से 'आग' (कर्म) को जलाना ही बंद कर दोगे?
            भगवान का सीधा और कड़क आदेश है कि इस दुनिया में परफेक्शन (Perfection) ढूँढना बंद करो; अपनी ड्यूटी के साथ जो भी 'धुआं' (कष्ट/दोष) आ रहा है, उसे एक सिपाही की तरह बर्दाश्त करो।
            तुम्हारी ड्यूटी (सहज कर्म) तुम्हारा सबसे बड़ा हथियार है; उसे डर के मारे फेंकने वाला इंसान कभी भी इस दुनिया के मैट्रिक्स को हैक (Hack) नहीं कर सकता।
            काम की कमियों को इग्नोर (Ignore) करके पूरे फोकस के साथ अपना बेस्ट (Best) देना ही सबसे बड़ा योग है, और यही बात एक इंसान को लूज़र (Loser) से एक विनर (Winner) बनाती है।
        """.trimIndent(),
        english = """
            O son of Kunti Arjuna! Every endeavor must be executed; one must absolutely never mathematically abandon his natural innate and biologically prescribed duty (Sahajam karma) even if that specific work appears to be heavily covered with massive faults and flaws (Sadosham api).
            Because absolutely every single endeavor project and physical action executed in this universe (Sarvarambha) is fundamentally inescapably covered by some microscopic fault or cosmic defect exactly in the same way that a blazing fire is always naturally enveloped by heavy smoke (Dhumena agnir ivavritah).
            The Supreme Lord is violently destroying the toxic human hallucination of 'Perfectionism' (the psychological disease demanding 100% flawless conditions) by deploying an absolutely spectacular and flawless scientific analogy.
            Arjuna was catastrophically hallucinating that executing the war would mathematically generate massive bloodshed and therefore this specific duty was horribly 'Faulty' (Vigunah) prompting him to cowardly desire an escape into monkhood.
            But the Lord delivers a brutal psychological slap reminding him: "You fool! There is mathematically absolutely zero physical action engineered within this 3D matrix that is 100% pure and completely devoid of negative biological side-effects."
            Just as it is scientifically impossible to ignite a massive blazing fire without simultaneously generating thick choking smoke it is absolutely impossible to execute any physical action (even breathing) without causing some microscopic violence or fault!
            If you farm the land you brutally slaughter millions of insects; if you simply walk you crush ants beneath your boots; so will you pathetically refuse to ignite the 'Fire' (Duty) purely out of a paralyzing terror of the 'Smoke' (Faults)?
            The Lord issues a titanium unyielding command: Stop desperately hunting for absolute sterile perfection inside a chaotic material matrix; exactly like an elite soldier aggressively endure whatever 'Smoke' (collateral damage/flaws) naturally accompanies your assigned duty.
            Your prescribed innate duty (Sahaja Karma) is your absolute greatest weapon; a pathetic coward who throws it away out of fear can mathematically never successfully hack or escape this universal matrix.
            Aggressively ignoring the minor flaws and unleashing your absolute 100% titanium focus to execute your best possible performance is the ultimate form of yoga and this mindset permanently separates an elite 'Winner' from a pathetic 'Loser'.
        """.trimIndent()
    ),
    Shloka(
        id = 49,
        sanskrit = """
            असक्तबुद्धिः सर्वत्र जितात्मा विगतस्पृहः |
            नैष्कर्म्यसिद्धिं परमां संन्यासेनाधिगच्छति || ४९ ||
        """.trimIndent(),
        hindi = """
            जिस मनुष्य की बुद्धि हर जगह और हर वस्तु से पूरी तरह अनासक्त (डिटैच / असक्तबुद्धिः) हो चुकी है, जिसने अपने मन और अहंकार पर पूरी तरह से जीत हासिल कर ली है (जितात्मा)।
            और जिसके अंदर की सभी भौतिक वासनाएं और इच्छाएं जड़ से पूरी तरह खत्म हो चुकी हैं (विगतस्पृहः), वह व्यक्ति इस सच्चे संन्यास (त्याग) के द्वारा एक बहुत बड़ी 'नैष्कर्म्यसिद्धि' (कर्म-बंधन से पूर्ण मुक्ति) को प्राप्त कर लेता है।
            भगवान श्रीकृष्ण यहाँ इस अठारहवें अध्याय के उस 'अल्टीमेट रिजल्ट' (Ultimate Result) और सबसे बड़ी 'हैक' (Hack) को बता रहे हैं जो इंसान को इस 3D मैट्रिक्स से हमेशा के लिए बाहर निकाल सकता है!
            जब इंसान अपनी बुद्धि को दुनिया के हर लालच (पैसे, पावर, रिश्ते) से 100% 'अनप्लग' (Unplug) कर लेता है (असक्तबुद्धि), तो वह दुनिया में रहते हुए भी दुनिया का नहीं रहता।
            'जितात्मा' का मतलब है कि उसने अपने सबसे बड़े और सबसे खतरनाक दुश्मन—अपने खुद के दिमाग—को हरा दिया है और अब उसका दिमाग उसका गुलाम बन चुका है।
            'विगतस्पृहः' का मतलब है कि उसके अंदर की वो भूख मर चुकी है जो कहती थी कि "मुझे और चाहिए, और चाहिए!" अब वह इंसान पूरी तरह से शांत और संतुष्ट हो चुका है।
            जब ये तीनों सुपर-क्वालिटीज़ (Super-qualities) एक इंसान के अंदर आ जाती हैं, तो उसे एक ऐसा जादुई 'सुपरपावर' (Superpower) मिल जाता है जिसे शास्त्रों में 'नैष्कर्म्यसिद्धि' कहा गया है।
            इसका मतलब है कि वह इंसान दिन भर काम करेगा, लेकिन ब्रह्मांड के 'कर्मा-अकाउंट' (Karma-account) में उसका एक भी कर्म रजिस्टर (Register) नहीं होगा; उसका कर्मा 100% ज़ीरो (Zero) हो जाएगा!
            यही वह असली और 'सुप्रीम संन्यास' (Supreme Sannyasa) है जहाँ इंसान को कपड़े बदलने या घर छोड़ने की कोई ज़रूरत नहीं पड़ती, बल्कि वह अपने दिमाग का सॉफ्टवेयर बदल लेता है।
            और जैसे ही कर्मा ज़ीरो होता है, जन्म-मरण का सर्वर (Server) उसे हमेशा के लिए 'लॉग आउट' (Log out) कर देता है और वह इंसान साक्षात ईश्वर की आज़ादी को पा लेता है।
        """.trimIndent(),
        english = """
            That elite human whose supreme intellect is 100% completely unattached to absolutely everything in the material world (Asakta-buddhih sarvatra) and who has ruthlessly and flawlessly conquered his own mind and false ego (Jitatma).
            And who is completely totally entirely free from all toxic biological cravings and material desires (Vigata-sprihah); by strictly executing this authentic renunciation he mathematically effortlessly attains the absolute supreme perfection of freedom from all karmic reactions (Naishkarmya-siddhim).
            Lord Sri Krishna is officially unveiling the absolute 'Ultimate Result' and the multiverse's greatest psychological 'Hack' that mathematically guarantees a human's permanent extraction from this chaotic 3D matrix!
            When an elite seeker successfully 100% 'Unplugs' his intellectual software from absolutely all toxic worldly temptations (cash power relationships) he exists physically within the matrix but is psychologically completely invincible.
            'Jitatma' explicitly signifies that he has aggressively and violently defeated his absolute most dangerous lethal enemy—his own rogue biological brain—and has successfully reprogrammed it to function strictly as his obedient slave.
            'Vigata-sprihah' mathematically confirms that the toxic parasitic hunger constantly screaming "I want more I need more!" has been permanently assassinated leaving the human in a state of absolute titanium peace and 100% satisfaction.
            When these three exact 'Super-Qualities' are flawlessly booted up inside a human he instantaneously unlocks a magical cosmic 'Superpower' technically officially categorized in the scriptures as 'Naishkarmya-siddhi'.
            This explicitly means the human can vigorously execute massive global labor 24/7 yet the universal 'Karma-Account' server mathematically fails to register even a single microscopic reaction; his karmic footprint becomes absolutely absolute Zero!
            This is the authentic absolute 'Supreme Sannyasa' where a human mathematically does not need to pathetically change his clothes or run to a jungle; he simply brutally uninstalls his corrupted psychological software and upgrades his intentions.
            And the exact microsecond his karmic debt hits absolute zero the reincarnation server permanently 'Logs Him Out' granting the human the exact same absolute eternal infinite freedom enjoyed by the Supreme Creator Himself.
        """.trimIndent()
    ),
    Shloka(
        id = 50,
        sanskrit = """
            सिद्धिं प्राप्तो यथा ब्रह्म तथाप्नोति निबोध मे |
            समासेनैव कौन्तेय निष्ठा ज्ञानस्य या परा || ५० ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र अर्जुन! इस प्रकार नैष्कर्म्यसिद्धि (कर्मों से मुक्ति की अवस्था) को प्राप्त कर लेने के बाद, वह मनुष्य जिस प्रकार से साक्षात् 'ब्रह्म' (परम सत्य या परमात्मा) को प्राप्त करता है।
            जो कि ज्ञान की सबसे अंतिम, सर्वोच्च और सबसे महान पराकाष्ठा (निष्ठा ज्ञानस्य या परा) है, उस पूरी की पूरी प्रक्रिया को अब तुम मुझसे बहुत ही संक्षेप (Summary) में अच्छी तरह से समझ लो (निबोध मे)।
            भगवान श्रीकृष्ण अब इस पूरे भगवद्गीता के महाज्ञान का सबसे आखिरी और सबसे बड़ा 'फाइनल कंक्लूजन' (Final Conclusion) शुरू करने जा रहे हैं!
            पिछले श्लोक में भगवान ने बता दिया था कि इंसान अपने कर्मों को 'जीरो' (Zero) कैसे कर सकता है और 'सिद्धि' (परफेक्शन) कैसे पा सकता है।
            लेकिन कर्मों से आज़ाद होना केवल आधी जीत है; जब तक आत्मा उस सुप्रीम पावर यानी 'ब्रह्म' (भगवान) से पूरी तरह कनेक्ट (Connect) नहीं हो जाती, तब तक यात्रा अधूरी है।
            इसलिए भगवान कहते हैं कि "अब मैं तुम्हें वो 'पासवर्ड' (Password) दूँगा जिससे तुम्हारी यह आज़ाद आत्मा सीधे भगवान के वीआईपी सर्वर (VIP Server) में एंट्री (Entry) करेगी!"
            यह कोई साधारण ज्ञान नहीं है, यह "निष्ठा ज्ञानस्य या परा" है—यानी दुनिया की सारी साइंस, फिलॉसफी और वेदों के ज्ञान की बिल्कुल टॉप-मोस्ट पीक (Top-most Peak / अंतिम सीमा)।
            इसके आगे जानने के लिए पूरे ब्रह्मांड में कुछ भी नहीं बचता, यह मानव चेतना (Human Consciousness) का सबसे आखिरी और सबसे बड़ा इवोल्यूशन (Evolution) है।
            भगवान कहते हैं कि मैं तुम्हें बड़े-बड़े श्लोकों में नहीं फँसाऊँगा, बल्कि बहुत ही 'शॉर्ट और क्रिस्प' (समासेन / Summary) तरीके से यह पूरा सीक्रेट (Secret) तुम्हें डाउनलोड करके दूँगा।
            अर्जुन का दिमाग अब उस 'अल्टीमेट ट्रुथ' (Ultimate Truth) को रिसीव (Receive) करने के लिए 100% तैयार किया जा रहा है जो एक इंसान को साक्षात भगवान के लेवल पर ले जाकर हमेशा के लिए अमर बना देता है।
        """.trimIndent(),
        english = """
            O son of Kunti Arjuna! After successfully achieving this supreme perfection of freedom from all karmic reactions please learn and perfectly understand from Me exactly how that elite human subsequently flawlessly attains to the Supreme Brahman.
            Which is officially universally recognized as the absolute highest supreme and ultimate constitutional stage of perfect transcendental knowledge (Nishtha jnanasya ya para); please hear this entire massive process from Me in a highly concise summary (Samasenaiva).
            Lord Sri Krishna is now officially launching the absolute final greatest and most terrifyingly powerful 'Final Conclusion' bridging the entire colossal cosmic wisdom of the Bhagavad Gita!
            In the previous spectacular verse the Lord flawlessly decoded exactly how a human can mathematically reduce his karmic debt to 'Zero' successfully unlocking the state of absolute perfection (Siddhi).
            However merely escaping the matrix and achieving karmic freedom is only half the cosmic victory; until the liberated soul establishes a permanent high-speed fiber-optic connection directly with the 'Brahman' (The Supreme Godhead) the journey remains incomplete.
            Therefore the Lord aggressively declares: "Now I shall download the absolute ultimate 'Master Password' into your brain explicitly detailing exactly how your newly liberated soul executes a flawless VIP entry directly into God's eternal servers!"
            This is absolutely not cheap basic philosophy; this is "Nishtha jnanasya ya para"—the absolute highest top-most razor-sharp peak of all global science complex philosophy and Vedic knowledge existing in the multiverse.
            Beyond this specific point there is mathematically absolutely nothing left to learn or discover in creation; it represents the absolute final ultimate evolution of human biological and spiritual consciousness.
            The Lord promises that He will absolutely not entangle Arjuna in confusing endless theories but will instead deliver this massive highly classified 'Top-Secret' data exactly in a brilliantly 'Short and Crisp' (Samasena / Summary) format.
            Arjuna's cognitive bandwidth is being meticulously and aggressively prepared right now to receive the 'Ultimate Truth' that legally upgrades a mortal human to the exact frequency of the Supreme Creator permanently granting him absolute immortality.
        """.trimIndent()
    ),
    Shloka(
        id = 51,
        sanskrit = """
            बुद्ध्या विशुद्धया युक्तो धृत्यात्मानं नियम्य च |
            शब्दादीन्विषयांस्त्यक्त्वा रागद्वेषौ व्युदस्य च || ५१ ||
            विविक्तसेवी लघ्वाशी यतवाक्कायमानसः |
            ध्यानयोगपरो नित्यं वैराग्यं समुपाश्रितः || ५२ ||
            अहङ्कारं बलं दर्पं कामं क्रोधं परिग्रहम् |
            विमुच्य निर्ममः शान्तो ब्रह्मभूयाय कल्पते || ५३ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य पूरी तरह से शुद्ध की गई बुद्धि से युक्त होता है और एक अटूट संकल्प के द्वारा अपने मन और इन्द्रियों को बहुत ही कठोरता से नियंत्रण में रखता है।
            जो इंसान शब्द आदि सभी इन्द्रिय विषयों को त्याग देता है और अपने भीतर से राग (लगाव) तथा द्वेष (नफरत) को जड़ से उखाड़ कर पूरी तरह फेंक देता है।
            जो एकांत और पवित्र स्थानों पर रहता है, बहुत कम और शुद्ध भोजन करता है, और अपने शरीर, मन तथा वाणी पर एक कमांडो की तरह पूरी तरह से काबू पा लेता है।
            जो हमेशा ध्यान और योग में लीन रहता है और जिसने अपने मन में पूरी तरह से वैराग्य (अनासक्ति) का विकास कर लिया है वह परम सत्य के बहुत करीब आ जाता है।
            जो व्यक्ति अपने झूठे अहंकार, शारीरिक बल, घमंड, वासना, क्रोध और चीज़ों को इकट्ठा करने की लालच से पूरी तरह आज़ाद हो चुका है और शांत है।
            वही निर्मम (जिसमें 'मेरा' का कोई भाव नहीं है) और शांत मनुष्य वास्तव में साक्षात् 'ब्रह्म' (ईश्वर के परम स्वरूप) को प्राप्त करने के योग्य हो जाता है।
            भगवान यहाँ उस सुप्रीम अवस्था की एक बहुत ही सख्त 'चेकलिस्ट' दे रहे हैं जो किसी भी इंसान को भौतिक दुनिया के इस 3D मैट्रिक्स से हमेशा के लिए बाहर निकाल सकती है।
            यह कोई साधारण ध्यान नहीं है; यह अपने ही दिमाग की पूरी हार्ड-ड्राइव को फॉर्मेट करके उसमें ईश्वरीय शांति का नया सॉफ्टवेयर इंस्टॉल करने का साइंटिफिक तरीका है।
            अहंकार और लालच वो भयंकर वायरस हैं जो आत्मा को शरीर की जेल में कैद रखते हैं, और वैराग्य ही वह एंटी-वायरस है जो इन जंजीरों को हमेशा के लिए तोड़ देता है।
            जब इंसान इस लेवल की भयंकर शुद्धि और शांति को हासिल कर लेता है, तो ब्रह्मांड का सिस्टम उसे एक साधारण इंसान से हटाकर साक्षात ईश्वर के समान अमर घोषित कर देता है।
        """.trimIndent(),
        english = """
            That elite human who is fully equipped with an immaculately purified intellect and who strictly controls his mind and senses with titanium determination.
            Who violently abandons all sensory objects such as sound and touch and who completely uproots and throws away all toxic attachment and blinding hatred.
            Who deliberately resides in solitary sacred places eats extremely light and pure food and executes commando-level control over his body mind and vocal cords.
            Who remains perpetually immersed in deep trance and yoga and who has successfully downloaded the absolute software of uncompromising detachment into his brain.
            The individual who is entirely freed from false ego brutal physical arrogance blinding pride insatiable lust explosive anger and the pathetic greed to hoard material things.
            That exact peaceful and profoundly unselfish mortal is officially mathematically qualified to flawlessly attain the absolute supreme spiritual level of Brahman.
            The Lord is explicitly delivering the ultimate highly severe cosmic 'Checklist' explicitly engineered to permanently extract a human from the terrifying 3D material matrix.
            This is absolutely not generic meditation; it is the hardcore scientific methodology to completely reformat your psychological hard drive and install the elite software of divine peace.
            Toxic ego and greed are the highly radioactive viruses keeping the soul imprisoned and absolute detachment is the ultimate anti-virus that shatters these biological chains forever.
            When a human achieves this terrifying altitude of absolute purity and silence the universal operating system legally upgrades him from a pathetic mortal into an immortal divine entity.
        """.trimIndent()
    ),
    Shloka(
        id = 54,
        sanskrit = """
            ब्रह्मभूतः प्रसन्नात्मा न शोचति न काङ्क्षति |
            समः सर्वेषु भूतेषु मद्भक्तिं लभते पराम् || ५४ ||
            भक्त्या मामभिजानाति यावान्यश्चास्मि तत्त्वतः |
            ततो मां तत्त्वतो ज्ञात्वा विशते तदनन्तरम् || ५५ ||
        """.trimIndent(),
        hindi = """
            उस असीम और परम ब्रह्म की अवस्था को प्राप्त कर लेने के बाद वह योगी पूरी तरह से प्रसन्न और शांत आत्मा वाला हो जाता है और कभी किसी चीज़ का शोक नहीं करता।
            उसे भौतिक दुनिया की किसी भी वस्तु को पाने की कोई लालच या इच्छा नहीं रहती और वह ब्रह्मांड के सभी जीवों को बिल्कुल एक समान दृष्टि से देखता है।
            इस प्रकार की परम शांत और समभाव वाली अवस्था में पहुँचने के बाद ही वह मनुष्य मेरी (परमेश्वर की) सबसे शुद्ध और सर्वोच्च 'परा भक्ति' को प्राप्त करता है।
            और केवल उस अनन्य और शुद्ध भक्ति के द्वारा ही वह यह ठीक-ठीक जान पाता है कि मेरी असली महिमा क्या है और मैं वास्तव में तत्त्व से कौन हूँ।
            मेरे इस परम सत्य और मेरे असली ईश्वरीय स्वरूप को 100% जान लेने के बाद वह सीधा मेरे उस असीम आध्यात्मिक धाम में हमेशा के लिए प्रवेश कर जाता है।
            यहाँ भगवान श्रीकृष्ण इस दुनिया के सभी दार्शनिकों का सबसे बड़ा भ्रम तोड़ते हैं जो सोचते हैं कि केवल 'ब्रह्म' (शून्य या शांति) में मिल जाना ही सबसे आखिरी मंज़िल है।
            भगवान साफ कहते हैं कि शांति या मोक्ष तो केवल एक 'शुरुआत' है; जब तुम्हारी आत्मा पूरी तरह साफ हो जाती है, तब तुम्हारी असली 'भक्ति' की यात्रा शुरू होती है।
            ईश्वर को किसी भी लेबोरेटरी के साइंस या दिमाग की कैलकुलेशन से कभी हैक नहीं किया जा सकता; परमेश्वर को डिकोड करने का एकमात्र पासवर्ड सिर्फ और सिर्फ 'शुद्ध प्रेम' है।
            जब इंसान के दिल में यह प्रेम पैदा होता है, तब उसे ब्रह्मांड के सबसे गहरे रहस्य अपने आप समझ आने लगते हैं और ईश्वर उसके सामने अपना असली रूप खोल देते हैं।
            यही वह अल्टीमेट वीआईपी एक्सेस है जहाँ आत्मा भौतिक शरीर को छोड़कर सीधा भगवान के हृदय में हमेशा के लिए अपना परमानेंट घर बना लेती है।
        """.trimIndent(),
        english = """
            Upon flawlessly attaining that infinite supreme state of Brahman the yogi becomes a completely joyful soul who absolutely never laments and never mathematically craves anything.
            He possesses absolutely zero toxic lust to acquire any material object in the matrix and he looks upon every single living entity with a perfectly equal and balanced cosmic vision.
            It is strictly only after successfully reaching this profoundly peaceful and equalized state that the human officially attains pure unadulterated supreme devotion (Para Bhakti) unto Me.
            And it is exclusively through that absolute pure devotion alone that he can scientifically and fundamentally understand exactly how incredibly glorious I am and who I truly am in reality.
            After comprehensively and perfectly decoding My absolute transcendental nature he legally executes a direct non-stop flight straight into My eternal spiritual kingdom forever.
            Lord Sri Krishna violently shatters the massive illusion infecting elite philosophers who falsely hallucinate that merging into a peaceful impersonal void is the absolute final cosmic destination.
            The Supreme Creator explicitly clarifies that achieving liberation or mental peace is merely the 'Starting Line'; authentic pure devotion only officially begins after the psychological hard drive is 100% wiped clean.
            God can absolutely never be scientifically hacked by crude biological intelligence or cheap academic calculations; the absolute solitary password required to decode the Supreme is 'Pure Explosive Love'.
            When this unadulterated love successfully activates inside the heart the universe's most heavily guarded secrets automatically unlock and the Lord personally reveals His original stunning form.
            This represents the ultimate VIP cosmic access where the tiny soul permanently abandons its biological plastic cover and establishes its eternal residence directly inside the heart of God.
        """.trimIndent()
    ),
    Shloka(
        id = 56,
        sanskrit = """
            सर्वकर्माण्यपि सदा कुर्वाणो मद्व्यपाश्रयः |
            मत्प्रसादादवाप्नोति शाश्वतं पदमव्ययम् || ५६ ||
            चेतसा सर्वकर्माणि मयि संन्यस्य मत्परः |
            बुद्धियोगमुपाश्रित्य मच्चित्तः सततं भव || ५७ ||
            मच्चित्तः सर्वदुर्गाणि मत्प्रसादात्तरिष्यसि |
            अथ चेत्त्वमहङ्कारान्न श्रोष्यसि विनङ्क्ष्यसि || ५८ ||
        """.trimIndent(),
        hindi = """
            जो मेरा शुद्ध भक्त हर समय मेरे ही आश्रय में रहता है, वह दुनिया के सभी प्रकार के सांसारिक और भारी कर्मों को करते हुए भी मेरी विशेष कृपा से उस शाश्वत और अविनाशी परम पद को प्राप्त कर लेता है।
            इसलिए हे अर्जुन! तुम अपने मन और चेतना के द्वारा अपने सभी कर्मों को मुझमें ही समर्पित कर दो और मुझे ही अपना परम लक्ष्य मानकर निष्काम कर्मयोग का पूरी तरह से आश्रय लो।
            अपनी बुद्धि को 100% मेरी तरफ लगाकर तुम हमेशा केवल मेरे ही चिंतन में डूबे रहो और अपनी पूरी साइकोलॉजी को मेरे कंट्रोल में दे दो।
            अगर तुम अपना पूरा मन मुझमें लगा दोगे, तो मेरी कृपा से तुम इस जीवन की सभी भयंकर से भयंकर मुश्किलों और बाधाओं को बहुत ही आसानी से पार कर जाओगे।
            परंतु यदि तुम अपने झूठे अहंकार और घमंड में आकर मेरी इन परम सत्य बातों को नहीं सुनोगे और अपनी मर्जी चलाओगे, तो तुम्हारा पूरी तरह से विनाश हो जाएगा।
            भगवान यहाँ एक बहुत बड़ा 'प्रोटेक्शन प्लान' (Protection Plan) दे रहे हैं कि अगर तुम अपनी ज़िंदगी की स्टीयरिंग (Steering) मेरे हाथों में सौंप दोगे, तो मैं तुम्हें हर एक्सीडेंट से बचा लूँगा।
            तुम्हें काम करना नहीं छोड़ना है; तुम दिन-रात ऑफिस में, समाज में या युद्ध के मैदान में लड़ो, लेकिन तुम्हारे दिमाग का 'बैकग्राउंड ऐप' (Background App) हमेशा ईश्वर से कनेक्टेड होना चाहिए।
            जब इंसान का ईगो (Ego) यह कहता है कि "मैं खुद अपनी प्रॉब्लम सॉल्व कर लूँगा," तो वह ब्रह्मांड की अनंत शक्ति से कटकर पूरी तरह अकेला और कमज़ोर हो जाता है।
            भगवान की कृपा (Grace) वह जादुई चाबी है जो इंसान के रास्ते में आने वाले बड़े से बड़े डिप्रेशन, गरीबी और मौत जैसे पहाड़ों को एक सेकंड में धूल बना देती है।
            लेकिन जो मूर्ख इंसान अहंकार में ईश्वर की आवाज़ को इग्नोर (Ignore) करता है, प्रकृति का कठोर सिस्टम उसे बिना किसी दया के कुचल कर हमेशा के लिए नष्ट कर देता है।
        """.trimIndent(),
        english = """
            My pure devotee who operates strictly under My absolute supreme protection flawlessly attains the eternal imperishable absolute destination purely by My causeless mercy despite actively engaging in all kinds of massive worldly activities.
            Therefore O Arjuna you must consciously and completely surrender absolutely all your physical actions directly unto Me viewing Me as your ultimate supreme target and taking complete shelter of selfless Karma Yoga.
            By aggressively locking your titanium intellect entirely upon Me you must ensure your psychological software remains perpetually submerged strictly in absolute consciousness of Me.
            If you successfully lock your entire mind onto Me you will effortlessly and mathematically bypass every single terrifying catastrophic obstacle in this matrix strictly by My divine grace.
            But if you arrogantly succumb to your toxic false ego and violently refuse to hear My absolute cosmic instructions you will mathematically guarantee your own catastrophic and absolute destruction.
            The Supreme Lord is officially offering humanity the ultimate cosmic 'Protection Plan' declaring that if you explicitly hand over the steering wheel of your existence to Him He will flawlessly shield you from every universal collision.
            You are absolutely not required to abandon physical labor; you must aggressively hustle 24/7 on the bloody battlefield or in society but your brain's 'Background App' must remain permanently high-speed connected to God.
            The exact microsecond a mortal's toxic ego arrogantly screams "I will independently solve my own massive problems" he instantly violently unplugs himself from the universe's infinite power source becoming pathetically weak and alone.
            The Lord's divine Grace is the absolute magical master-key that effortlessly vaporizes massive terrifying mountains of clinical depression extreme poverty and biological death into microscopic dust in one second.
            But the arrogant fool who stubbornly ignores the explicit voice of the Supreme Creator is mathematically processed by nature's brutal unforgiving operating system and ruthlessly crushed into eternal oblivion.
        """.trimIndent()
    ),
    Shloka(
        id = 59,
        sanskrit = """
            यदहङ्कारमाश्रित्य न योत्स्य इति मन्यसे |
            मिथ्यैष व्यवसायस्ते प्रकृतिस्त्वां नियोक्ष्यति || ५९ ||
            स्वभावजेन कौन्तेय निबद्धः स्वेन कर्मणा |
            कर्तुं नेच्छसि यन्मोहात्करिष्यस्यवशोऽपि तत् || ६० ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! यदि तुम अपने झूठे अहंकार और घमंड का सहारा लेकर अपने मन में यह सोचते हो कि "मैं यह युद्ध बिल्कुल नहीं करूँगा", तो तुम्हारा यह फैसला पूरी तरह से झूठा और बेकार है।
            क्योंकि तुम्हारी अपनी क्षत्रिय प्रकृति (तुम्हारा अंदरूनी स्वभाव और डीएनए) तुम्हें जबरदस्ती इस युद्ध में धकेल ही देगी और तुमसे यह काम करवा ही लेगी।
            हे कुन्तीपुत्र! जिस काम को तुम अभी अपने मोह, अज्ञानता और डर के कारण बिल्कुल भी नहीं करना चाहते हो, उसे तुम बाद में पूरी तरह से लाचार और विवश होकर करोगे ही।
            क्योंकि तुम अपने ही पिछले जन्मों के कर्मों और अपने वर्तमान जन्मजात क्षत्रिय स्वभाव (नेचर) से बहुत ही मजबूत जंजीरों में बंधे हुए हो।
            भगवान यहाँ इंसान की तथाकथित 'फ्री-विल' (Free-will / स्वतंत्र इच्छा) का बहुत ही कड़वा और साइंटिफिक पर्दाफाश कर रहे हैं!
            अर्जुन को लग रहा था कि वह युद्ध न करने का फैसला लेकर बहुत महान बन रहा है, लेकिन भगवान कहते हैं कि तुम्हारा यह फैसला तुम्हारी आत्मा का नहीं, बल्कि तुम्हारे 'ईगो' का है।
            इंसान का शरीर और उसका दिमाग एक प्रोग्राम्ड मशीन (Programmed Machine) है; अगर एक शेर यह सोचे कि वह घास खाएगा, तो भूख लगने पर उसकी प्रकृति उसे जबरदस्ती शिकार करने पर मजबूर कर ही देगी।
            उसी तरह, अर्जुन के अंदर एक योद्धा का उग्र खून और सॉफ्टवेयर है; जब दुश्मन उसके सामने उसके परिवार पर हमला करेंगे, तो उसका स्वभाव उसे चुप नहीं बैठने देगा और वह हथियार उठा ही लेगा।
            हम अक्सर अपने घमंड में सोचते हैं कि हम परिस्थितियों को कंट्रोल कर रहे हैं, लेकिन असल में ब्रह्मांड का सिस्टम (प्रकृति) हमें कठपुतली की तरह नचा रहा होता है।
            इसलिए भगवान समझा रहे हैं कि बेवकूफों की तरह प्रकृति से लड़ने के बजाय, खुशी-खुशी भगवान के आदेश को मानकर अपनी ड्यूटी करना ही सबसे बड़ी और असली आज़ादी है।
        """.trimIndent(),
        english = """
            O Arjuna! If you arrogantly take heavy shelter of your toxic false ego and foolishly calculate in your brain that "I absolutely shall not fight this war," your pathetic resolution is completely fake and mathematically useless.
            Because your own inherent biological and psychological Kshatriya nature (your internal warrior DNA) will violently hijack your system and ruthlessly force you to engage in this exact combat.
            O son of Kunti! That specific terrifying action which you are currently desperately refusing to execute purely out of blinding delusion and deep biological fear you will inevitably be forcefully compelled to perform completely against your conscious will.
            Because you are inextricably and hopelessly chained by the massive titanium bonds of your own accumulated past karma and your naturally inherited psychological operating system.
            The Supreme Lord is brutally ripping the mask off the pathetic human hallucination of absolute 'Free-Will' dropping an incredibly bitter and highly scientific cosmic truth bomb!
            Arjuna arrogantly hallucinated that by refusing to fight he was executing a highly elite moral choice but God instantly exposes that this decision was generated entirely by a temporary toxic glitch in his 'Ego'.
            The human biological machine is a rigorously pre-programmed entity; if an apex predator like a lion idiodically decides to graze on grass his internal biological hunger will eventually aggressively force him to brutally hunt and kill.
            Similarly Arjuna is fundamentally hardwired with the explosive aggressive software of an elite warrior; the microsecond the enemy launches a lethal attack on his family his unalterable nature will violently bypass his logic and force him to draw blood.
            Arrogant mortals constantly hallucinate they are the supreme masters controlling their environment when in mathematical reality the universe's operating system (Prakriti) is flawlessly manipulating them like cheap biological puppets.
            Therefore the Lord explicitly instructs that instead of acting like a stubborn fool desperately fighting against inescapable cosmic programming the only true ultimate freedom is happily willingly surrendering to God's divine commands.
        """.trimIndent()
    ),
    Shloka(
        id = 61,
        sanskrit = """
            ईश्वरः सर्वभूतानां हृद्देशेऽर्जुन तिष्ठति |
            भ्रामयन्सर्वभूतानि यन्त्रारूढानि मायया || ६१ ||
            तमेव शरणं गच्छ सर्वभावेन भारत |
            तत्प्रसादात्परां शान्तिं स्थानं प्राप्स्यसि शाश्वतम् || ६२ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! परमेश्वर इस ब्रह्मांड के सभी जीवों के हृदय (दिल) के ठीक केंद्र में विराजमान हैं और वहीं से वे इस पूरी सृष्टि का संचालन कर रहे हैं।
            वे साक्षात् ईश्वर अपनी असीम माया शक्ति के द्वारा भौतिक शरीर रूपी मशीन (यंत्र) पर बैठे हुए इन सभी जीवों को उनके कर्मों के अनुसार गोल-गोल घुमा रहे हैं।
            इसलिए हे भारत! तुम अपने सभी झूठे घमंडों को छोड़कर अपने पूरे भाव और 100% समर्पण के साथ केवल उसी परमेश्वर की ही शरण में चले जाओ।
            उसी परमात्मा की विशेष कृपा से तुम इस जीवन में उस परम और असीम शांति को प्राप्त करोगे और अंत में उस शाश्वत तथा कभी न मिटने वाले ईश्वरीय धाम को पा लोगे।
            यह श्लोक 'द मैट्रिक्स' (The Matrix) के सबसे बड़े कंट्रोलर (Controller) का सबसे सटीक और डरावना विज़ुअल (Visual) दुनिया के सामने रखता है!
            भगवान स्पष्ट करते हैं कि इंसान का शरीर हाड़-मांस का पुतला नहीं, बल्कि एक 'यंत्र' (एक हाई-टेक बायोलॉजिकल मशीन) है जिस पर आत्मा सवारी कर रही है।
            और उस मशीन का जो मेन 'सर्वर रूम' (Server Room) है, वह इंसान का अपना हृदय है जहाँ साक्षात ईश्वर एक 'सुप्रीम ऑपरेटर' (Supreme Operator) की तरह बैठे हैं।
            जैसे मेले में बच्चे लकड़ी के घोड़ों पर बैठते हैं और एक आदमी उस मशीन को गोल-गोल घुमाता है, वैसे ही ईश्वर जीवों को उनके कर्मों के हिसाब से संसार में घुमा रहे हैं।
            जब इंसान को यह गहरा विज्ञान समझ आ जाता है कि उसके हाथ में कुछ भी नहीं है, तो उसका सारा ईगो (Ego) और स्ट्रेस एक ही पल में ज़ीरो हो जाता है।
            और वह एक रोते हुए बच्चे की तरह अपने उस परम पिता (ईश्वर) के गले लग जाता है; यही वह 'टोटल सरेंडर' (Total Surrender) है जो इंसान को हमेशा के लिए आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            O Arjuna! The Supreme Lord is physically and spiritually situated directly in the absolute core of the hearts of all living entities actively orchestrating the entire multiverse from within.
            Through His terrifyingly powerful and infinite material energy (Maya) He is meticulously directing the wanderings of all living entities who are merely seated on biological machines (Yantras) made of material energy.
            Therefore O son of Bharata! You must instantly and aggressively surrender exclusively unto Him with your entire being your complete emotions and 100% absolute devotion.
            Strictly by His supreme causeless mercy you will flawlessly attain infinite unshakeable transcendental peace in this life and ultimately secure your permanent residence in the supreme eternal abode.
            This spectacular verse delivers the absolute most precise and terrifyingly awe-inspiring visual describing exactly how the 'Supreme Controller' operates the vast universal Matrix!
            The Lord explicitly clarifies that the human body is absolutely not just flesh and bone; it is officially a 'Yantra' (a hyper-advanced biological machine) upon which the tiny soul is merely riding as a clueless passenger.
            And the absolute central 'Server Room' heavily controlling that biological machine is located deep inside the human heart where God Himself sits operating exactly like the Ultimate Cosmic Administrator.
            Just as children ride wooden horses on a massive mechanical carousel completely controlled by a hidden operator the Supreme Lord mathematically rotates all souls throughout the cosmos strictly according to their karmic data.
            When a human deeply scientifically comprehends that his own toxic ego controls absolutely nothing his massive biological stress and arrogance are instantaneously violently reduced to absolute zero.
            He then aggressively drops his fake independence and unconditionally surrenders exactly like a helpless child running to its father; this is the ultimate 'Total Surrender' that permanently hacks the matrix and liberates the soul.
        """.trimIndent()
    ),
    Shloka(
        id = 63,
        sanskrit = """
            इति ते ज्ञानमाख्यातं गुह्याद्गुह्यतरं मया |
            विमृश्यैतदशेषेण यथेच्छसि तथा कुरु || ६३ ||
            सर्वगुह्यतमं भूयः शृणु मे परमं वचः |
            इष्टोऽसि मे दृढमिति ततो वक्ष्यामि ते हितम् || ६४ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! इस प्रकार मैंने तुम्हें यह अत्यंत गुप्त से भी गुप्त (गुह्याद्गुह्यतरं) और सबसे रहस्यमयी आध्यात्मिक ज्ञान पूरी तरह से समझा दिया है।
            अब तुम मेरे द्वारा बताए गए इस पूरे ज्ञान और विज्ञान पर बहुत ही गहराई से विचार करो (विमृश्यैतदशेषेण), और फिर जैसी तुम्हारी इच्छा हो, तुम बिल्कुल वैसा ही करो (यथेच्छसि तथा कुरु)।
            लेकिन फिर भी, तुम सभी रहस्यों में सबसे बड़े और परम गोपनीय रहस्य (सर्वगुह्यतमं) को एक बार फिर से सुनो जो मेरा सबसे अंतिम और सबसे बड़ा आदेश है।
            चूँकि तुम मेरे बहुत ही प्यारे और सबसे घनिष्ठ मित्र हो (इष्टोऽसि मे दृढमिति), इसीलिए केवल तुम्हारे सबसे बड़े फायदे (हितम्) के लिए मैं तुम्हें यह परम सत्य बता रहा हूँ।
            भगवान श्रीकृष्ण यहाँ इस पूरी भगवद्गीता के सबसे 'माइंड-ब्लोइंग' (Mind-blowing) मनोवैज्ञानिक खेल और आज़ादी (Free-will) का सबसे बड़ा सबूत दे रहे हैं!
            ईश्वर ब्रह्मांड का सबसे बड़ा बॉस होने के बावजूद अर्जुन पर अपनी बात नहीं थोपते; वे कहते हैं: "मैंने तुम्हें सारा डेटा दे दिया है, अब तुम खुद सोचो और जो तुम्हें ठीक लगे, वही फैसला लो।"
            सच्चा प्यार और सच्चा भगवान इंसान को गुलाम नहीं बनाता, बल्कि उसे ज्ञान देकर उसकी बुद्धि को आज़ाद कर देता है ताकि इंसान अपनी मर्ज़ी से सही रास्ता चुन सके।
            लेकिन क्योंकि अर्जुन उनका बेस्ट-फ्रेंड (Best-friend) है, इसलिए भगवान का दिल नहीं मानता और वे कहते हैं कि "रुको! मैं तुम्हें एक लास्ट 'मास्टर-पासवर्ड' (Master-password) और देना चाहता हूँ।"
            यह 'सर्वगुह्यतमं' वो टॉप-सीक्रेट (Top-secret) है जो दुनिया की किसी भी किताब या साइंस में नहीं मिलेगा, यह केवल भगवान के दिल से सीधे उनके सबसे प्यारे भक्त के दिल में ट्रांसफर (Transfer) होता है।
            अगले श्लोकों में वह अल्टीमेट राज़ खुलेगा जो पूरी भगवद्गीता का निचोड़ है और जो इंसान को एक सेकंड में सारे पापों से मुक्त कर सकता है।
        """.trimIndent(),
        english = """
            O Arjuna! In this meticulous manner I have completely explicitly and flawlessly explained to you the absolute most confidential knowledge which is infinitely more secret than all other secrets (Guhyad guhyataram).
            Now you must aggressively and deeply utilize your supreme intellect to deliberate on this massive data download completely (Vimrishyaitad asheshena) and then you are totally free to act exactly as you wish (Yathecchasi tatha kuru).
            However because I love you deeply please listen once again to My absolute supreme instruction which is the most highly classified and fiercely guarded top-secret knowledge in the entire multiverse (Sarva-guhyatamam).
            Strictly because you are My absolute most dearly beloved and intimate best friend (Ishto 'si me dridham iti) I am officially revealing this ultimate supreme truth explicitly and exclusively for your highest ultimate benefit (Hitam).
            Lord Sri Krishna is executing the absolute most 'Mind-Blowing' psychological maneuver here officially delivering the multiverse's absolute greatest unshakeable proof of authentic human 'Free-Will'!
            Despite being the terrifyingly powerful Supreme Boss of all creation God absolutely refuses to behave like a cosmic dictator; He states: "I have fully downloaded the data; now you logically calculate and execute whatever decision you prefer."
            Authentic divine love and the true Supreme Creator absolutely never mutate humans into pathetic mindless slaves; He arms them with blazing knowledge and respects their autonomy allowing them to voluntarily choose the light.
            But simply because Arjuna is His absolute ultimate best friend the Lord's infinite compassion overflows and He aggressively interrupts saying "Wait! I must urgently hand you one absolute final 'Master-Password' before we close."
            This 'Sarva-guhyatamam' is the universe's most highly classified titanium Top-Secret which mathematically cannot be found in any modern physics textbook; it is a direct peer-to-peer data transfer strictly from God's heart to His devotee's soul.
            In the upcoming final verses the absolute ultimate secret condensing the entire 700 verses of the Bhagavad Gita will be explosively revealed possessing the raw power to incinerate all human sin in a single microsecond.
        """.trimIndent()
    ),
    Shloka(
        id = 65,
        sanskrit = """
            मन्मना भव मद्भक्तो मद्याजी मां नमस्कुरु |
            मामेवैष्यसि सत्यं ते प्रतिजाने प्रियोऽसि मे || ६५ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! तुम हमेशा और लगातार केवल मेरे ही बारे में सोचो (मन्मना भव), मेरे ही परम और शुद्ध भक्त बन जाओ (मद्भक्तो), केवल मेरी ही पूजा करो (मद्याजी) और केवल मुझे ही अपना सिर झुकाकर प्रणाम करो (मां नमस्कुरु)।
            अगर तुम ऐसा करोगे तो तुम निश्चित रूप से और बिना किसी शक के सीधे मुझे ही प्राप्त करोगे (मामेवैष्यसि), यह मैं तुमसे बिल्कुल सत्य कह रहा हूँ।
            और मैं तुम्हें यह पक्का प्रॉमिस (Promise) या वचन देता हूँ (सत्यं ते प्रतिजाने) क्योंकि तुम मुझे बहुत ही ज़्यादा प्यारे हो (प्रियोऽसि मे)।
            यह पूरी भगवद्गीता का सबसे प्यारा, सबसे पावरफुल और सबसे डायरेक्ट 'रोमांटिक और स्पिरिचुअल' (Romantic and Spiritual) श्लोक है जो सीधे भगवान के दिल से निकला है!
            भगवान यहाँ कोई भारी-भरकम योग या कठिन तपस्या नहीं माँग रहे हैं; वे सिर्फ इंसान का 'ध्यान' (Attention) और उसका प्यार (Love) माँग रहे हैं।
            वे कहते हैं कि तुम्हारा दिमाग 24 घंटे जिन फालतू चीज़ों (पैसा, टेंशन, रिश्ते) के बारे में सोचता रहता है, उस सारे फोकस (Focus) को वहां से हटाकर केवल मुझ पर (सुप्रीम पावर पर) लॉक (Lock) कर दो।
            जब तुम ऑफिस में काम करो या घर पर रहो, तुम्हारा हर एक्शन (Action) और हर सोच मेरे लिए एक पूजा बन जानी चाहिए; यही असली भक्ति है।
            और जब भगवान खुद अपने होंठों से गारंटी (Guarantee) दे रहे हैं कि "सत्यं ते प्रतिजाने" (मैं तुमसे सच प्रॉमिस करता हूँ), तो ब्रह्मांड की कोई भी ताकत इस प्रॉमिस को तोड़ नहीं सकती।
            यह कोई साधारण बात नहीं है; जब यूनिवर्स का क्रिएटर (Creator) खुद किसी इंसान को अपना 'प्रिय' (Favorite) बोल दे, तो उस इंसान का सारा डर और टेंशन वहीं खत्म हो जाता है।
            यह श्लोक साबित करता है कि ईश्वर कोई डरावना जज (Judge) नहीं है, बल्कि वह एक ऐसा परम मित्र है जो बस हमारे प्यार और हमारे दिल का इंतज़ार कर रहा है।
        """.trimIndent(),
        english = """
            O Arjuna! You must violently forcefully and continuously lock your entire mind strictly onto constantly thinking of Me (Man-mana bhava) become My pure unconditional devotee (Mad-bhakto) worship exclusively Me (Mad-yaji) and offer your absolute homage solely unto Me (Mam namaskuru).
            If you flawlessly execute this simple protocol you will mathematically securely and absolutely inevitably come directly to Me without any doubt (Mam evaishyasi); this is the absolute truth.
            And I am officially giving you My absolute titanium unbreakable promise and personal cosmic guarantee regarding this (Satyam te pratijane) simply because you are exceptionally and profoundly dear to Me (Priyo 'si me).
            This is unequivocally the absolute sweetest most terrifyingly powerful and most direct 'Romantic and Spiritual' verse in the entire Bhagavad Gita exploding straight out of the Supreme Creator's heart!
            The Lord is absolutely not demanding brutally exhausting physical yoga or horrific bone-crushing austerities; He is exclusively demanding the human's complete psychological 'Attention' and pure explosive 'Love'.
            He aggressively commands: The massive cognitive bandwidth you waste 24/7 constantly overthinking about cheap paper money toxic relationships and earthly stress must be violently unplugged and permanently locked securely onto ME.
            Whether you are aggressively hustling in a corporate boardroom or relaxing at home absolutely every single physical action and micro-thought must be executed strictly as a sacred worship of Me; this is true elite devotion.
            And when the Supreme Boss of the multiverse personally utters the words "Satyam te pratijane" (I legally and truthfully promise you) absolutely zero forces black holes or cosmic laws can ever mathematically break that titanium guarantee.
            This is absolutely not a generic statement; when the Master Architect of reality officially brands a tiny mortal as His 'Priyah' (Favorite Beloved) every single microscopic drop of biological fear and stress instantly evaporates from that human's soul.
            This spectacular verse mathematically proves that God is absolutely not a terrifying vindictive cosmic Judge but rather the ultimate supreme best friend who is patiently hungrily waiting strictly for our pure unadulterated love.
        """.trimIndent()
    ),
    Shloka(
        id = 66,
        sanskrit = """
            सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज |
            अहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि मा शुचः || ६६ ||
        """.trimIndent(),
        hindi = """
            अपने सभी प्रकार के तथाकथित सांसारिक और धार्मिक धर्मों (कर्तव्यों/नियमों) का पूरी तरह से परित्याग कर दो (सर्वधर्मान्परित्यज्य) और केवल एक मेरी (परमेश्वर की) ही पूर्ण शरण में आ जाओ (मामेकं शरणं व्रज)।
            मैं खुद अपने हाथों से तुम्हें तुम्हारे जन्मों-जन्मों के सभी भयंकर पापों और कर्म-बंधनों से हमेशा के लिए पूरी तरह मुक्त कर दूँगा (अहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि)।
            इसलिए तुम अपने मन में अब ज़रा सा भी डर, चिंता या शोक बिल्कुल मत करो (मा शुचः)!
            यह भगवद्गीता का 'द अल्टीमेट मास्टर-स्ट्रोक' (The Ultimate Master-stroke) और सबसे महान श्लोक है जिस पर पूरी सनातन फिलॉसफी (Philosophy) आकर टिक जाती है!
            भगवान इंसान के दिमाग में बैठे हुए सारे 'रिलिजियस कन्फ्यूजन' (Religious Confusion) को एक ही हथौड़े से तोड़ देते हैं: "यह पूजा करूँ, वो व्रत रखूँ, समाज क्या कहेगा?"—भगवान कहते हैं कि इन सब फालतू बातों को कूड़े में डाल दो!
            तुम्हें ब्रह्मांड के लाखों नियमों और छोटी-मोटी ड्यूटीज़ (Duties) के बोझ तले दबने की कोई ज़रूरत नहीं है; तुम बस अपना हाथ मेरे हाथ में दे दो (शरणं व्रज)।
            जैसे एक छोटा बच्चा जब अपने पिता की गोद में आ जाता है तो उसे दुनिया के किसी कानून या खतरे की चिंता नहीं होती, वैसे ही 100% सरेंडर (Surrender) ही इंसान का आखिरी और सबसे बड़ा धर्म है।
            इंसान डरता है कि "मैंने इतने पाप किए हैं, मेरा क्या होगा?" भगवान एक सुप्रीम बॉस (Supreme Boss) की तरह गारंटी देते हैं: "तुम्हारे सारे पापों का बिल मैं खुद फाड़ दूँगा, तुम बस रिलैक्स (Relax) करो!"
            "मा शुचः" (डरो मत)—यह शब्द ब्रह्मांड की सबसे बड़ी साइकोलॉजिकल (Psychological) दवा है जो इंसान के अंदर के सारे डिप्रेशन, एंग्ज़ायटी और खौफ को एक सेकंड में भस्म कर देती है।
            यही वह आखिरी और सबसे बड़ा पासवर्ड (Password) है जो इंसान की आत्मा को 3D मैट्रिक्स से निकालकर सीधा भगवान के वीआईपी ज़ोन (VIP Zone) में हमेशा के लिए अमर कर देता है।
        """.trimIndent(),
        english = """
            You must violently and absolutely permanently abandon all varieties of so-called earthly religions external religious duties and complex societal protocols (Sarva-dharman parityajya) and aggressively surrender exclusively and unconditionally unto Me alone (Mam ekam sharanam vraja).
            I personally promise to flawlessly mathematically and eternally deliver and liberate you from all the horrific catastrophic cosmic reactions of your countless lifetimes of sinful deeds (Aham tvam sarva-papebhyo mokshayishyami).
            Therefore you must absolutely not fear you must not panic and you must absolutely never lament or grieve over anything ever again (Ma shuchah)!
            This is unequivocally 'The Ultimate Master-Stroke' and the absolute greatest crowning jewel verse of the entire Bhagavad Gita upon which the entire colossal architecture of Sanatana philosophy permanently rests!
            The Supreme Lord violently smashes the exhausting 'Religious Confusion' plaguing the human brain with one titanium hammer: "Should I execute this specific ritual? What will society say?"—The Lord aggressively commands you to throw all that pathetic garbage into the cosmic trash!
            You absolutely do not need to suffer being crushed under the suffocating weight of millions of complex Vedic regulations and petty societal duties; you simply must blindly and fearlessly place your hand directly into MINE (Sharanam vraja).
            Just as a helpless infant jumping into its all-powerful father's arms instantly becomes 100% immune to all global threats executing absolute 100% total 'Surrender' is the ultimate supreme and final religion of the human soul.
            Mortals are perpetually paralyzed by the terror: "I have accumulated millions of horrific sins; how will I survive?" The Supreme Boss violently overrides the system guaranteeing: "I will personally tear up your entire massive karmic bill of sins; you just relax!"
            "Ma shuchah" (Do not fear)—These two explosive words act as the multiverse's absolute greatest psychological medicine instantaneously incinerating every microscopic drop of clinical depression anxiety and existential terror inside a human.
            This is the absolute final unbreakable master-password that seamlessly extracts the eternal soul out of the terrifying 3D biological matrix and uploads it directly into God's eternal VIP dimension forever.
        """.trimIndent()
    ),
    Shloka(
        id = 67,
        sanskrit = """
            इदं ते नातपस्काय नाभक्ताय कदाचन |
            न चाशुश्रूषवे वाच्यं न च मां योऽभ्यसूयति || ६७ ||
            य इमं परमं गुह्यं मद्भक्तेष्वभिधास्यति |
            भक्तिं मयि परां कृत्वा मामेवैष्यत्यसंशयः || ६८ ||
            न च तस्मान्मनुष्येषु कश्चिन्मे प्रियकृत्तमः |
            भविता न च मे तस्मादन्यः प्रियतरो भुवि || ६९ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! गीता का यह अत्यंत पवित्र और टॉप-सीक्रेट (Top-secret) ज्ञान कभी भी उस इंसान को नहीं बताना चाहिए जो तपस्या (अनुशासन) नहीं करता, जो मेरा भक्त नहीं है, जो इस ज्ञान को सुनने की इच्छा नहीं रखता, और जो मुझसे भयंकर नफरत या ईर्ष्या करता है।
            परंतु जो मेरा सच्चा भक्त इस परम गोपनीय और सबसे महान रहस्य (भगवद्गीता) को मेरे दूसरे भक्तों के बीच प्यार से बाँटेगा और इसका प्रचार करेगा।
            वह इंसान मुझ पर अपनी सबसे ऊँची और शुद्ध भक्ति (परां भक्ति) को साबित करेगा, और इसमें कोई शक नहीं है (असंशयः) कि मृत्यु के बाद वह सीधा मेरे ही पास वैकुंठ में वापस आएगा।
            इस पूरी दुनिया (पृथ्वी) में उस ज्ञान बाँटने वाले इंसान से बढ़कर मेरा कोई और प्रिय काम करने वाला (प्रियकृत्तमः) न तो आज कोई मौजूद है, और न ही भविष्य में कोई दूसरा इंसान मुझे उससे ज़्यादा प्यारा कभी होगा!
            भगवान श्रीकृष्ण यहाँ अपना सबसे बड़ा 'कॉर्पोरेट सीक्रेट' (Corporate Secret) और अपना सबसे प्यारा काम दुनिया के सामने रख रहे हैं।
            गीता का ज्ञान कोई सस्ती चीज़ नहीं है जिसे घमंडी और नफरत करने वाले मूर्खों के सामने फेंक दिया जाए; यह ज्ञान एक डायमंड (Diamond) है जो केवल उन्हीं को मिलना चाहिए जिनके दिल में इसके लिए रिस्पेक्ट (Respect) है।
            लेकिन जो इंसान इस डायमंड (गीता के ज्ञान) को अपनी जेब में रखने के बजाय दुनिया के भटके हुए और दुखी लोगों (भक्तों) के बीच जाकर उन्हें फ्री (Free) में बांटता है, वह भगवान का सबसे बड़ा 'ब्रांड एम्बेसडर' (Brand Ambassador) बन जाता है।
            ईश्वर खुद कहते हैं कि मुझे उस इंसान से ज्यादा प्यारा पूरी पृथ्वी पर कोई नहीं लगता जो मेरी इस गीता की किताब और मेरे मैसेज (Message) को दूसरों तक पहुँचाने के लिए मेहनत करता है।
            यह श्लोक 'स्पिरिचुअल डिस्ट्रीब्यूशन' (Spiritual Distribution) का सबसे बड़ा रिवॉर्ड (Reward) फिक्स कर देता है: जो भगवान के ज्ञान का प्रचार करेगा, भगवान उसे 100% मोक्ष की वीआईपी टिकट पहले ही दे देंगे।
            अगर आप भगवान के सबसे 'फेवरेट' (Favorite) इंसान बनना चाहते हैं, तो आपको गीता के इस अमृत को सिर्फ खुद नहीं पीना है, बल्कि पूरी दुनिया को पिलाना है।
        """.trimIndent(),
        english = """
            O Arjuna! This highly classified and supremely sacred knowledge of the Gita must absolutely never mathematically be shared with anyone who lacks severe discipline (Austerity) who is not My devotee who arrogantly refuses to listen or who violently hates and envies Me.
            However any true devotee of Mine who actively and aggressively broadcasts shares and explains this supreme absolute top-secret knowledge exclusively among My other devotees.
            That magnificent human executes the absolute highest form of pure unadulterated transcendental devotion (Para Bhakti) unto Me and there is absolutely zero microscopic doubt (Asamshayah) that he will fly directly back to My eternal kingdom.
            In this entire earthly dimension there is mathematically absolutely no human being currently existing who executes more pleasing and dearly beloved service to Me than him nor will there ever be anyone in the entire future who is more profoundly dear to Me than he is!
            Lord Sri Krishna is explicitly declassifying His absolute ultimate 'Corporate Secret' and revealing exactly what specific action makes Him overwhelmingly ecstatic.
            The staggering cosmic wisdom of the Gita is absolutely not cheap garbage to be carelessly tossed before arrogant toxic fools and violent atheists; it is an elite diamond that must strictly be handed only to those possessing genuine respect.
            But the elite human who violently refuses to selfishly hoard this diamond instead aggressively functioning as God's ultimate 'Brand Ambassador' by distributing this liberating data to deeply suffering and confused souls is infinitely rewarded.
            The Supreme Creator personally publicly declares that absolutely no entity on this entire planet is more fiercely loved by Him than the warrior who aggressively sweats to broadcast and preach the message of the Bhagavad Gita.
            This spectacular verse locks in the absolute ultimate cosmic 'Reward' for massive 'Spiritual Distribution': Anyone who aggressively preaches God's knowledge is instantly mathematically guaranteed an advance VIP ticket to eternal Moksha.
            If you desperately desire to become the Supreme Lord's absolute number one 'Favorite' human you must not selfishly consume this nectar alone; you must actively and aggressively distribute it to the entire bleeding matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 70,
        sanskrit = """
            अध्येष्यते च य इमं धर्म्यं संवादमावयोः |
            ज्ञानयज्ञेन तेनाहमिष्टः स्यामिति मे मतिः || ७० ||
            श्रद्धावाननसूयश्च शृणुयादपि यो नरः |
            सोऽपि मुक्तः शुभाँल्लोकान्प्राप्नुयात्पुण्यकर्मणाम् || ७१ ||
        """.trimIndent(),
        hindi = """
            जो कोई भी मनुष्य हम दोनों (कृष्ण और अर्जुन) के बीच हुए इस अत्यंत पवित्र और धर्म से भरे हुए संवाद (भगवद्गीता) का बहुत ही गहराई से अध्ययन (पढ़ाई/Study) करेगा।
            मैं यह पक्का मानता हूँ कि उस इंसान ने अपनी बुद्धि (ज्ञान) का उपयोग करके 'ज्ञान-यज्ञ' के द्वारा साक्षात् मेरी ही बहुत बड़ी पूजा (इष्टः) की है, यह मेरा पक्का निर्णय (मतिः) है।
            और जो मनुष्य केवल बहुत ही पक्की श्रद्धा (Faith) के साथ और बिना किसी के प्रति ईर्ष्या या नफरत (अनसूयश्च) रखे, इस गीता के ज्ञान को केवल अपने कानों से सुनेगा (शृणुयादपि) भी।
            वह इंसान भी अपने सारे पापों से पूरी तरह मुक्त (आज़ाद) होकर उन अत्यंत शुभ और श्रेष्ठ लोकों (स्वर्ग आदि) को प्राप्त करेगा जहाँ बहुत बड़े-बड़े पुण्य करने वाले महान लोग जाते हैं।
            भगवान यहाँ भगवद्गीता की 'पावर' (Power) का सबसे बड़ा और चौंकाने वाला सीक्रेट बता रहे हैं जो दुनिया की किसी और किताब में नहीं है!
            भगवान कहते हैं कि गीता पढ़ना कोई साधारण 'रीडिंग' (Reading) नहीं है; जब तुम अपने दिमाग का इस्तेमाल करके इस फिलॉसफी को समझते हो, तो तुम वास्तव में 'ज्ञान-यज्ञ' (Sacrifice of Knowledge) कर रहे हो।
            तुम्हें भगवान को खुश करने के लिए करोड़ों का दान या हिमालय पर जाने की ज़रूरत नहीं है; अपने कमरे में बैठकर पूरी एकाग्रता के साथ गीता को समझना ही भगवान की सबसे बड़ी 'आरती' और पूजा है!
            और इससे भी बड़ा चमत्कार यह है कि अगर कोई इंसान अनपढ़ है या गीता पढ़ नहीं सकता, लेकिन वह केवल साफ दिल और बिना किसी ईगो (Ego) के इसे 'सुन' भी लेता है, तो भी उसका बेड़ा पार हो जाता है।
            केवल गीता के वाइब्रेशन (Vibrations) और शब्दों को अपने कानों में जाने देने मात्र से इंसान का 'कर्मा-अकाउंट' (Karma-account) धुल जाता है और उसे बहुत बड़े पुण्यों का फ्री (Free) क्रेडिट मिल जाता है।
            यह श्लोक साबित करता है कि भगवद्गीता कोई नॉर्मल किताब नहीं है, बल्कि यह एक 'डिवाइन सॉफ्टवेयर' (Divine Software) है जिसे पढ़ने या सुनने मात्र से इंसान के दिमाग का पूरा सिस्टम अपग्रेड (Upgrade) हो जाता है।
        """.trimIndent(),
        english = """
            Absolutely any human being who aggressively and meticulously studies (Adhyeshyate) this highly sacred and supremely religious cosmic dialogue taking place between the two of us (Krishna and Arjuna).
            I mathematically and officially declare that by utilizing his intellect to absorb this data he has actively worshipped Me strictly through the execution of the 'Sacrifice of Knowledge' (Jnana-yajnena); this is My absolute supreme opinion (Matih).
            And furthermore even a human who simply listens (Shrinuyad api) to this absolute truth with a completely pure titanium faith entirely devoid of any toxic envy cynicism or malice (Anasuyash cha).
            Even that person merely by listening becomes instantaneously completely liberated from the heavy reactions of all his sins and flawless attains the highly auspicious elite planetary systems reserved strictly for those who perform massive pious deeds.
            The Supreme Lord is explicitly declassifying the absolute most staggering and mind-blowing 'Power' secretly encoded strictly within the Bhagavad Gita which absolutely no other book in the multiverse possesses!
            The Lord aggressively decrees that deeply reading the Gita is absolutely not a mundane academic 'Reading' exercise; the exact microsecond your brain processes this elite philosophy you are biologically and spiritually executing a massive 'Jnana-Yajna' (Sacrifice of Knowledge).
            You absolutely do not need to burn billions of dollars or freeze in the Himalayas to please God; simply sitting silently in your room and focusing 100% of your cognitive bandwidth on understanding the Gita is legally registered as the absolute highest worship of the Supreme!
            And the absolute greatest cosmic miracle is this: If an illiterate mortal cannot read but simply allows these highly radioactive acoustic vibrations to enter his ears with a completely pure unarrogant heart his entire existence is saved.
            Merely allowing the supreme sonic frequencies of the Gita to physically vibrate your eardrums violently scrubs your entire personal 'Karma-Account' perfectly clean granting you massive free VIP access to elite celestial dimensions.
            This spectacular verse proves mathematically that the Bhagavad Gita is absolutely not normal literature; it is a hyper-advanced 'Divine Software' that violently and permanently upgrades the human biological and spiritual operating system upon mere contact.
        """.trimIndent()
    ),
    Shloka(
        id = 72,
        sanskrit = """
            कच्चिदेतच्छ्रुतं पार्थ त्वयैकाग्रेण चेतसा |
            कच्चिदज्ञानसम्मोहः प्रनष्टस्ते धनञ्जय || ७२ ||
            अर्जुन उवाच |
            नष्टो मोहः स्मृतिर्लब्धा त्वत्प्रसादान्मयाच्युत |
            स्थितोऽस्मि गतसन्देहः करिष्ये वचनं तव || ७३ ||
        """.trimIndent(),
        hindi = """
            भगवान श्रीकृष्ण ने पूछा: हे पार्थ! क्या तुमने मेरे द्वारा बताए गए इस अत्यंत गहरे ज्ञान को पूरे 100% एकाग्र मन (One-pointed focus) और पूरे ध्यान से सुना है?
            हे धनंजय! क्या तुम्हारा वह पुराना अज्ञान और वह भयंकर मोह (Ignorance and Illusion) अब पूरी तरह से नष्ट और खत्म (प्रनष्टस्ते) हो गया है जिसके कारण तुम युद्ध करने से मना कर रहे थे?
            अर्जुन ने पूरी ऊर्जा के साथ उत्तर दिया: हे अच्युत (कभी न गिरने वाले भगवान)! आपकी इस असीम कृपा (त्वत्प्रसादान्) से मेरा वह सारा मोह और भ्रम अब पूरी तरह से राख और नष्ट (नष्टो मोहः) हो चुका है!
            मैंने अपनी उस असली 'स्मृति' (Memory/Spiritual Identity) को वापस पा लिया है जिसे मैं भूल गया था; अब मेरे दिमाग का हर एक संशय और डाउट पूरी तरह कट चुका है (गतसन्देहः)।
            अब मैं बिल्कुल एक मजबूत चट्टान की तरह अपने कर्तव्य पर स्थिर हूँ (स्थितोऽस्मि) और अब आप मुझे जो भी आदेश देंगे, मैं बिना किसी हिचकिचाहट के बिल्कुल वैसा ही करूँगा (करिष्ये वचनं तव)।
            यह पूरी भगवद्गीता के संवाद का 'क्लाइमेक्स' (Climax) है जहाँ एक गुरु अपने शिष्य का 'फाइनल टेस्ट' (Final Test) ले रहा है और शिष्य उसमें 100% पास हो जाता है!
            भगवान एक बहुत ही केयरिंग टीचर (Caring Teacher) की तरह पूछते हैं कि "क्या तुम्हारे दिमाग के सारे वायरस डिलीट (Delete) हो गए हैं या अभी भी कोई डाउट (Doubt) बाकी है?"
            अर्जुन का जवाब एक डरे हुए इंसान का जवाब नहीं है; यह उस 'सुपर-वॉरियर' (Super-warrior) का रोर (Roar/दहाड़) है जिसका 'माइंड-सॉफ्टवेयर' (Mind-software) भगवान ने खुद अपने हाथों से अपग्रेड कर दिया है।
            अर्जुन कहता है कि "मेरा सारा डिप्रेशन और डर खत्म हो गया है; मुझे याद आ गया है कि मैं कोई साधारण शरीर नहीं, बल्कि एक आत्मा हूँ जिसका एकमात्र काम आपकी मर्ज़ी को पूरा करना है।"
            "करिष्ये वचनं तव" (मैं वही करूँगा जो आप कहेंगे)—यह इंसान की सबसे बड़ी और आखिरी आज़ादी का डिक्लेरेशन (Declaration) है, जहाँ वह अपना ईगो (Ego) छोड़कर यूनिवर्स की सुप्रीम फोर्स के साथ पूरी तरह अलाइन (Align) हो जाता है।
        """.trimIndent(),
        english = """
            Lord Sri Krishna intensely inquired: O son of Pritha! Have you actually heard and absorbed this profoundly deep knowledge with absolute 100% single-pointed laser focus and undivided attention?
            O winner of wealth Arjuna! Has your previous blinding ignorance and that terrifying dense illusion (Ajnana-sammohah) which paralyzed you from fighting now been completely shattered and permanently destroyed?
            Arjuna roared back with explosive revitalized energy: O infallible Lord (Achyuta)! By Your absolute supreme causeless mercy my catastrophic illusion has been completely incinerated and totally destroyed (Nashto mohah)!
            I have fully successfully regained my original flawless biological and spiritual memory (Smritir labdha); absolutely every single microscopic paralyzing doubt has been violently deleted from my cognitive software (Gata-sandehah).
            I am now perfectly situated and anchored exactly like an invincible titanium mountain (Sthito 'smi) and I am fully prepared to aggressively and flawlessly execute absolutely whatever command You issue without hesitation (Karishye vachanam tava).
            This is the absolute staggering 'Climax' of the entire Bhagavad Gita dialogue where the Supreme Master formally executes the 'Final Diagnostic Test' on His disciple and the disciple scores a flawless 100%!
            The Lord operating exactly like a profoundly caring elite instructor explicitly demands to verify: "Has your psychological hard drive been completely purged of all toxic viruses or does some microscopic doubt still linger?"
            Arjuna's explosive response is absolutely not the whimpering of a terrified mortal; it is the terrifying aggressive roar of a cosmic 'Super-Warrior' whose mental software has just been personally upgraded by God Himself.
            Arjuna emphatically declares: "My clinical depression and biological fear have been permanently assassinated; I vividly remember that I am not this pathetic physical flesh but an eternal soul engineered strictly to execute Your divine will."
            "Karishye vachanam tava" (I shall mathematically execute Your exact command)—This is the absolute ultimate declaration of human freedom where a mortal violently deletes his false ego and perfectly aligns his entire existence with the Supreme Force of the multiverse.
        """.trimIndent()
    ),
    Shloka(
        id = 74,
        sanskrit = """
            सञ्जय उवाच |
            इत्यहं वासुदेवस्य पार्थस्य च महात्मनः |
            संवादमिममश्रौषमद्भुतं रोमहर्षणम् || ७४ ||
            व्यासप्रसादाच्छ्रुतवानेतद्गुह्यमहं परम् |
            योगं योगेश्वरात्कृष्णात्साक्षात्कथयतः स्वयम् || ७५ ||
            राजन्संस्मृत्य संस्मृत्य संवादमिममद्भुतम् |
            केशवार्जुनयोः पुण्यं हृष्यामि च मुहुर्मुहुः || ७६ ||
            तच्च संस्मृत्य संस्मृत्य रूपमत्यद्भुतं हरेः |
            विस्मयो मे महान् राजन्हृष्यामि च पुनः पुनः || ७७ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 74 से 77 तक संजय का अद्भुत और रोमांचक अनुभव है)
            संजय ने राजा धृतराष्ट्र से कहा: इस प्रकार मैंने साक्षात् भगवान वासुदेव (कृष्ण) और उस महान आत्मा वाले पार्थ (अर्जुन) के बीच हुए इस अत्यंत अद्भुत और रोंगटे खड़े कर देने वाले (रोमहर्षणम्) महान संवाद को अपने कानों से सुना है!
            महर्षि वेदव्यास जी की विशेष कृपा (प्रसादात्) और उनकी दी हुई दिव्य दृष्टि से ही मैं इस परम गोपनीय और सबसे बड़े 'टॉप-सीक्रेट' (Top-secret) योग को सीधे योगेश्वर भगवान श्रीकृष्ण के अपने मुख से बोलते हुए (साक्षात्) सुन पाया हूँ।
            हे राजन्! भगवान केशव (कृष्ण) और अर्जुन के बीच हुए इस अत्यंत पवित्र, चमत्कारी और हैरान कर देने वाले संवाद को मैं जब भी बार-बार याद करता हूँ (संस्मृत्य संस्मृत्य), तो मेरा रोम-रोम हर बार खुशी से कांप उठता है और मैं परमानंद से भर जाता हूँ!
            और हे राजन्! भगवान श्रीहरि (कृष्ण) के उस अत्यंत भयानक, असीम और अद्भुत 'विश्वरूप' (Cosmic Form) को भी बार-बार याद करके मेरे दिमाग में एक भयंकर आश्चर्य पैदा होता है और मैं बार-बार खुशी से पागल हो रहा हूँ।
            यहाँ कुरुक्षेत्र के मैदान में चल रही इस लाइव ब्रॉडकास्टिंग (Live Broadcasting) का कैमरा वापस संजय के ऊपर आता है जो हस्तिनापुर के महल में अंधकार में बैठे राजा धृतराष्ट्र को यह सब बता रहा है।
            संजय की हालत एक ऐसे इंसान जैसी हो गई है जिसे ब्रह्मांड का सबसे बड़ा खजाना और सबसे हाई-लेवल का 4D विज़ुअल एक्सपीरियंस (Visual Experience) मिल गया है, और वह खुशी के मारे रो रहा है।
            वह अपने गुरु वेदव्यास जी को धन्यवाद देता है जिन्होंने उसे वह 'वीआईपी दिव्य दृष्टि' (VIP Divine Vision) दी जिससे वह साक्षात भगवान की आवाज़ को हैक (Hack) करके सुन पाया।
            संजय धृतराष्ट्र को यह भी जताना चाहता है कि "तुम अंधे हो क्योंकि तुम केवल अपने बेटे (दुर्योधन) की जीत देखना चाहते हो, लेकिन मैं भगवान का यह सत्य देखकर खुशी से पागल हो रहा हूँ!"
            जब गीता का ज्ञान किसी इंसान के दिमाग में गहराई तक उतर जाता है, तो उसका रिएक्शन भी संजय की तरह ही होता है—वह डिप्रेशन से निकलकर एक 'परमानेंट एक्सटेसी' (Permanent Ecstasy / परमानंद) के लूप में फँस जाता है।
            संजय का यह रोंगटे खड़े कर देने वाला अनुभव (रोमहर्षणम्) यह साबित करता है कि भगवद्गीता केवल एक किताब नहीं है, बल्कि यह एक ज़िंदा और करंट मारने वाली ईश्वरीय ऊर्जा (Energy) है।
        """.trimIndent(),
        english = """
            (Verses 74 through 77 describe the staggering ecstatic and mind-blowing experience of Sanjaya)
            Sanjaya intensely exclaimed to King Dhritarashtra: Thus I have successfully and flawlessly heard this absolute wonderful and deeply astonishing cosmic conversation between Lord Vasudeva (Krishna) and the great soul Partha (Arjuna) which is literally making every single hair on my biological body stand on end (Roma-harshanam)!
            Strictly by the absolute causeless mercy and the special VIP divine vision granted to me by Vyasadeva I have flawlessly heard this supreme most highly classified top-secret (Guhyam) yoga directly from the absolute master of all mysticism Krishna speaking it personally (Sakshat) from His own lips.
            O King! As I continuously recursively recall and playback (Samsmritya samsmritya) this incredibly astonishing breathtaking and supremely holy cosmic dialogue between Keshava and Arjuna my entire biological and spiritual system violently thrills and rejoices at every single microsecond!
            And O King! When I repeatedly recall and mentally visualize that utterly staggering terrifyingly infinite and absolutely wonderful Cosmic Form (Vishvarupa) of Lord Hari I am brutally struck with massive explosive wonder and my heart violently bursts with unending ecstatic joy again and again.
            The perspective of this massive universal 'Live Broadcasting' suddenly aggressively shifts back from the Kurukshetra battlefield directly to Sanjaya who is transmitting this data to the blind arrogant King Dhritarashtra sitting in the dark palace.
            Sanjaya's psychological state is exactly like a mortal who has just been aggressively injected with the universe's most explosive 4D visual experience and the ultimate cosmic treasure literally crying uncontrollably out of sheer ecstatic bliss.
            He expresses massive violent gratitude to his guru Vyasadeva whose specific 'VIP Divine Vision' allowed Sanjaya to successfully intercept and hack into the direct acoustic frequencies vibrating from the Supreme Creator's own vocal cords.
            Sanjaya is aggressively passively warning Dhritarashtra: "You are biologically and spiritually completely blind heavily obsessing over your toxic son's pathetic victory but my brain is literally exploding with the infinite ecstasy of witnessing God's absolute truth!"
            When the staggering radioactive wisdom of the Gita successfully penetrates deep into a human's psychological hard drive the exact biological reaction is identical to Sanjaya's: the entity permanently escapes depression and enters a highly addictive loop of 'Permanent Ecstasy'.
            Sanjaya's hair-raising thrill (Roma-harshanam) mathematically proves that the Bhagavad Gita is absolutely not a dead academic textbook; it is a highly reactive living breathing high-voltage divine cosmic energy that violently electrocutes the soul with bliss.
        """.trimIndent()
    ),
    Shloka(
        id = 78,
        sanskrit = """
            यत्र योगेश्वरः कृष्णो यत्र पार्थो धनुर्धरः |
            तत्र श्रीर्विजयो भूतिर्ध्रुवा नीतिर्मतिर्मम || ७८ ||
        """.trimIndent(),
        hindi = """
            जहाँ योग के परम ईश्वर और सभी शक्तियों के मालिक साक्षात् भगवान श्रीकृष्ण स्वयं उपस्थित हैं, और जहाँ अपना गांडीव धनुष धारण किए हुए परम वीर अर्जुन खड़े हैं।
            वहाँ उस पक्ष में निश्चित रूप से अपार ऐश्वर्य (श्री), कभी न हारने वाली पक्की विजय, असीम अलौकिक शक्तियां (भूति) और अटल न्याय (नीति) हमेशा मौजूद रहती है, यह मेरा (संजय का) सबसे पक्का और अंतिम मत है।
            यह भगवद्गीता का सबसे अंतिम, सबसे महान और पूरी दुनिया के इतिहास का सबसे शानदार 'माइक-ड्रॉप' (Mic-drop) श्लोक है जिसे संजय ने अंधे राजा धृतराष्ट्र को सुनाया है!
            इस एक ही श्लोक में ब्रह्मांड की पूरी फिलॉसफी, कर्म योग और भक्ति का अल्टीमेट निष्कर्ष और पक्की गारंटी पूरी तरह से सील (Seal) कर दी गई है।
            संजय अंधे और घमंडी राजा धृतराष्ट्र का सारा घमंड यह कहकर एक झटके में चकनाचूर कर देते हैं कि "तुम्हारी विशाल 11 अक्षौहिणी सेना और तुम्हारे पैसों की ताकत किसी काम की नहीं है, तुम्हारी हार पक्की है!"
            जीत कभी भी बड़ी बंदूकों, पैसों या चालाकी से नहीं मिलती; असली और परमानेंट जीत केवल वहीं होती है जहाँ इंसान की मेहनत (अर्जुन) और ईश्वर का दिमाग (कृष्ण) का परफेक्ट कॉम्बिनेशन (Combination) होता है।
            जब इंसान अपना 100% एक्शन (धनुष उठाना) करता है और अपनी बुद्धि की स्टीयरिंग 100% ईश्वर (योगेश्वर) के हाथों में सौंप देता है, तो दुनिया की कोई भी ताकत उसे हरा ही नहीं सकती।
            यह श्लोक दुनिया के हर इंसान को एक बिल्कुल सीधा और अचूक फॉर्मूला देता है: "अपनी ज़िंदगी के रथ पर भगवान को बैठाओ और अपनी ड्यूटी का धनुष खुद उठाओ।"
            जहाँ भगवान का सुप्रीम ज्ञान और इंसान का भयंकर पसीना (मेहनत) एक साथ मिल जाते हैं, वहाँ सफलता, शांति और महा-ऐश्वर्य का आना एक अटल ब्रह्मांडीय नियम (Cosmic Law) बन जाता है।
            यहीं पर कुरुक्षेत्र के खूनी मैदान में दिया गया यह अनंत, अमर और दिव्य ईश्वरीय महाज्ञान अपनी पूर्णता को प्राप्त करता है और इंसान की आत्मा को हमेशा के लिए आज़ाद कर देता है! ओम् तत् सत्!
        """.trimIndent(),
        english = """
            Wherever there is Lord Krishna the absolute Supreme Master of all mystic yoga and infinite power and wherever there is the supreme archer Arjuna holding his mighty weapon.
            There will mathematically and undoubtedly always be infinite opulence (Shri) absolute unshakeable victory extraordinary cosmic power (Bhuti) and flawless morality (Niti); this is my absolute supreme and final opinion.
            This is unequivocally the absolute final most magnificent and historically spectacular 'Mic-Drop' verse of the entire Bhagavad Gita officially delivered like a cosmic thunderbolt by Sanjaya to the blind arrogant King Dhritarashtra!
            Within this single explosive stanza the absolute ultimate cosmic conclusion of all global philosophy Karma Yoga and pure devotion is permanently and legally sealed for all eternity.
            Sanjaya violently and ruthlessly shatters the massive toxic arrogance of the blind king explicitly declaring: "Your massive million-man military forces and billions in corporate wealth are mathematically completely useless; your catastrophic defeat is absolute!"
            Absolute permanent victory is absolutely never engineered by hoarding massive nuclear weapons cheap cash or toxic political cunning; true invincible victory exists exclusively where the human's brutal hustle and the Divine's flawless intellect perfectly unite.
            When a human aggressively executes his 100% maximum physical action (holding the bow) and completely surrenders the steering wheel of his brain entirely to God (Yogeshvara) he instantly legally mutates into a literal invincible superhero.
            This spectacular verse provides the ultimate universal foolproof formula for all humanity: Install the Supreme Creator as the absolute driver of your biological chariot and aggressively lift the heavy bow of your daily mandatory duty.
            Wherever God's supreme transcendental wisdom flawlessly merges with a human's brutal physical sweat and unyielding labor catastrophic success immense wealth and unshakeable peace become an inescapable mathematical cosmic law.
            Here on the bloody chaotic battlefield of Kurukshetra this infinite divine universal masterclass flawlessly achieves its absolute supreme perfection permanently shattering the matrix and eternally liberating the human consciousness! Om Tat Sat!
        """.trimIndent()
    )
)