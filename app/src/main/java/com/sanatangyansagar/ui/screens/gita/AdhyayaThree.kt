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
fun AdhyayaThree() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaThreeShlokas.indexOfFirst { it.id == shlokaNum }
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
            label = { Text("Search Shloka Number (e.g., 5)") },
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
            itemsIndexed(adhyayaThreeShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaThreeShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            अर्जुन उवाच |
            ज्यायसी चेत्कर्मणस्ते मता बुद्धिर्जनार्दन |
            तत्किं कर्मणि घोरे मां नियोजयसि केशव || १ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने कहा: हे जनार्दन! हे केशव! यदि आप सकाम कर्मों (अहंकारयुक्त कार्यों) की अपेक्षा ज्ञान (बुद्धि) को अधिक श्रेष्ठ मानते हैं...
            तो फिर आप मुझे इस घोर और भयंकर कर्म (युद्ध) में क्यों लगा रहे हैं?
            दूसरे अध्याय के अंत में श्रीकृष्ण ने अर्जुन को 'बुद्धियोग' (ज्ञान और समभाव) की सर्वोच्च महिमा बताई थी और स्थितप्रज्ञ योगी के लक्षण समझाए थे।
            अर्जुन की समझ यहाँ एक बहुत बड़ी चूक कर रही है। वे सोच रहे हैं कि यदि ज्ञान और ध्यान इतना ही महान है, तो फिर बाहर से कोई भी 'कर्म' करने की क्या आवश्यकता है?
            अर्जुन के मन में यह भ्रांति पैदा हो गई है कि 'बुद्धि' (ज्ञान) और 'कर्म' (एक्शन) दोनों एक-दूसरे के दुश्मन हैं।
            वे भगवान से एक सीधा और बहुत ही तार्किक सवाल पूछ रहे हैं: "जब आप खुद कह रहे हैं कि ज्ञान श्रेष्ठ है, तो मुझे चुपचाप जंगल में बैठकर ध्यान करने को क्यों नहीं कहते?"
            "आप मुझे अपने ही सगे-संबंधियों का खून बहाने जैसे इस भयंकर और घोर कर्म (युद्ध) में क्यों धकेल रहे हैं?"
            यह अर्जुन का कोई बहाना नहीं है, बल्कि एक ईमानदार शिष्य की उलझन है जो थ्योरी (Theory) और प्रैक्टिकल (Practical) के बीच का तालमेल नहीं समझ पा रहा है।
            अर्जुन चाहते हैं कि धर्म का मार्ग पूरी तरह से स्पष्ट हो, उसमें कोई विरोधाभास (Contradiction) न हो।
            यहीं से श्रीमद्भगवद्गीता के तीसरे अध्याय 'कर्मयोग' की अत्यंत शानदार शुरुआत होती है।
        """.trimIndent(),
        english = """
            Arjuna inquired: O Janardana! O Keshava! If You consider intelligence (transcendental knowledge) to be vastly superior to fruitive action...
            then why do You urge me to engage in this ghastly and terrifying action of warfare?
            At the grand conclusion of the Second Chapter, Sri Krishna highly glorified the absolute supremacy of 'Buddhi Yoga' (knowledge and equanimity) and the peaceful state of a sage.
            Arjuna's intelligence is making a massive, very common miscalculation here. He concludes that if spiritual knowledge and meditation are indeed so supreme, then why perform any external 'Action' at all?
            A profound misconception has taken root in Arjuna's mind that 'Knowledge' (Buddhi) and 'Action' (Karma) are mutually exclusive enemies.
            He asks the Lord a highly direct and completely logical question: "If You Yourself are saying that knowledge is better, why not just tell me to sit quietly in a forest and meditate?"
            "Why are You aggressively pushing me into this horrific, ghastly action of slaughtering my own beloved relatives in a bloody war?"
            This is absolutely not a cowardly excuse, but the genuine confusion of an honest student who cannot reconcile high spiritual theory with brutal worldly practicality.
            Arjuna desperately wants the path of dharma to be crystal clear, without any perceived philosophical contradictions.
            Exactly from this brilliant inquiry begins the magnificent Third Chapter of the Gita, the Yoga of Action (Karma Yoga).
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            व्यामिश्रेणेव वाक्येन बुद्धिं मोहयसीव मे |
            तदेकं वद निश्चित्य येन श्रेयोऽहमाप्नुयाम् || २ ||
        """.trimIndent(),
        hindi = """
            आपके इन मिले-जुले (व्यामिश्र) और अनेकार्थक वचनों से मेरी बुद्धि मानो और भी अधिक मोहित (भ्रमित) हो रही है।
            इसलिए, आप कृपा करके निश्चयपूर्वक कोई एक ही बात बताइए, जिससे मैं अपना परम कल्याण (श्रेय) प्राप्त कर सकूँ।
            अर्जुन यहाँ अपने गुरु श्रीकृष्ण के प्रति अपनी पूरी कुंठा (Frustration) और असमंजस को अत्यंत खुले शब्दों में व्यक्त कर रहे हैं।
            वे कहते हैं कि कभी आप युद्ध करने (कर्म) को कहते हैं, और कभी आप इन्द्रियों को समेट कर ध्यान (ज्ञान) में बैठने को कहते हैं।
            इन दोनों अलग-अलग दिशाओं वाली बातों ने मेरी बुद्धि का पूरी तरह से दही बना दिया है (बुद्धिं मोहयसीव)।
            एक शिष्य हमेशा अपने गुरु से एक स्पष्ट, सीधा और ब्लैक-एंड-व्हाइट (Black-and-white) निर्देश चाहता है।
            अर्जुन कह रहे हैं कि मेरे पास इतना समय या मानसिक क्षमता नहीं है कि मैं इस गहरे दर्शन की पहेलियां सुलझाऊं।
            इसलिए, आप मुझे कोई 'एक' (एकम्) सुनिश्चित रास्ता बता दीजिए—या तो मैं संन्यास लेकर जंगल चला जाऊं, या मैं हथियार उठाकर युद्ध करूँ।
            अर्जुन का यह प्रश्न हर उस इंसान का प्रश्न है जो अध्यात्म और अपनी नौकरी/परिवार के बीच फँसकर कंफ्यूज रहता है कि असली धर्म क्या है।
            भगवान आगे चलकर इस बात को स्पष्ट करेंगे कि ज्ञान और कर्म अलग-अलग नहीं हैं, बल्कि कर्म को ज्ञान के साथ करना ही 'कर्मयोग' है।
        """.trimIndent(),
        english = """
            My intelligence is completely bewildered by Your seemingly equivocal and highly ambiguous instructions (Vyamishrena vakyena).
            Therefore, please decisively tell me exactly one specific path by which I may attain the ultimate, supreme benefit (Shreya).
            Arjuna is expressing his extreme intellectual frustration and profound confusion towards his Guru, Sri Krishna, in very open and blunt terms here.
            He complains that at one moment You command me to aggressively fight (Action), and the next moment You glorify withdrawing the senses and sitting in meditation (Knowledge).
            Hearing these seemingly contradictory instructions pulling in opposite directions has completely short-circuited my brain ('buddhim mohayasiva').
            A sincere disciple always desperately craves a clear, direct, and absolute black-and-white command from their master.
            Arjuna is essentially pleading: I do not have the mental bandwidth right now to solve complex philosophical riddles on a battlefield.
            Therefore, please firmly dictate just 'One' (Ekam) single, definitive path—either I take renunciation and go to the forest, or I pick up my bow and slaughter them.
            Arjuna's burning question represents every modern human who feels deeply torn and confused between pursuing spiritual peace and handling their chaotic worldly career/family.
            The Lord will soon spectacularly clarify that Knowledge and Action are not enemies; performing action powered by spiritual knowledge is the true essence of 'Karma Yoga'.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            श्रीभगवानुवाच |
            लोकेऽस्मिन्द्विविधा निष्ठा पुरा प्रोक्ता मयानघ |
            ज्ञानयोगेन साङ्ख्यानां कर्मयोगेन योगिनाम् || ३ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे निष्पाप (अनघ) अर्जुन! इस संसार में आत्म-साक्षात्कार (मोक्ष) की दो प्रकार की निष्ठा (मार्ग) मेरे द्वारा प्राचीन काल में बताई गई है।
            ज्ञानियों (सांख्यवादियों) के लिए 'ज्ञानयोग' का मार्ग है, और कर्मयोगियों के लिए 'कर्मयोग' का मार्ग है।
            भगवान श्रीकृष्ण यहाँ अर्जुन की दुविधा को हमेशा के लिए सुलझा रहे हैं। वे अर्जुन को 'अनघ' (पाप रहित) कहते हैं, क्योंकि अर्जुन का प्रश्न अज्ञान से नहीं, बल्कि सच्ची जिज्ञासा से पैदा हुआ है।
            श्रीकृष्ण बताते हैं कि मनुष्य की प्रकृति अलग-अलग होती है। कुछ लोग स्वभाव से ही दार्शनिक और चिंतक (Thinkers) होते हैं; उनके लिए 'सांख्य योग' (ज्ञान का मार्ग) है, जहाँ वे दुनिया से कटकर आत्मा का ध्यान करते हैं।
            दूसरी ओर, कुछ लोग स्वभाव से ही अत्यंत सक्रिय और ऊर्जावान (Action-oriented) होते हैं; उनके लिए 'कर्मयोग' का मार्ग है, जहाँ वे दुनिया के बीच रहकर निष्काम भाव से अपने कर्तव्य निभाते हैं।
            महत्वपूर्ण बात यह है कि भगवान यह स्पष्ट कर रहे हैं कि ये दोनों ही रास्ते (निष्ठा) ईश्वर तक ही पहुँचते हैं; इनमें से कोई भी दूसरे से छोटा या बड़ा नहीं है।
            अंतर केवल इंसान के मानसिक स्वभाव (Psychological makeup) का है।
            चूँकि अर्जुन एक क्षत्रिय हैं, जिनके खून में कर्म और युद्ध करना लिखा है, उनके लिए ज्ञानयोग की गुफा में बैठना पूरी तरह से अप्राकृतिक (Unnatural) होगा।
            इसलिए भगवान अर्जुन के लिए 'कर्मयोग' को ही सबसे श्रेष्ठ और उनके स्वभाव के अनुकूल मार्ग बताते हैं।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead elegantly replied: O sinless one (Anagha)! I have already explained in ancient times that there are two primary paths of faith for self-realization in this world.
            The path of analytical knowledge (Jnana-yoga) is for the philosophical thinkers (Sankhyas), and the path of unattached action (Karma-yoga) is for the active workers (Yogis).
            Lord Sri Krishna is permanently resolving Arjuna's massive dilemma right here. He addresses Arjuna as 'Anagha' (completely sinless), because Arjuna's question stems from pure spiritual curiosity, not malicious ego.
            Sri Krishna explains that human psychological nature fundamentally varies. Some individuals are naturally deeply introspective, philosophical thinkers; for them, 'Sankhya Yoga' (the path of knowledge and renunciation) is designed.
            On the other hand, many people are naturally highly dynamic, energetic, and action-oriented; for them, the path of 'Karma Yoga' is prescribed, where they perform massive worldly duties without selfish attachment.
            The absolute, crucial point the Lord makes is that both these distinct paths (Nishtha) ultimately lead to the exact same destination (God); neither is intrinsically superior or inferior to the other.
            The only difference lies perfectly in the specific psychological and physical makeup of the practitioner.
            Since Arjuna is a fierce Kshatriya warrior with explosive action woven directly into his DNA, forcing himself to sit silently in a cave (Jnana-yoga) would be completely artificial and unnatural.
            Therefore, the Lord strongly implies that 'Karma Yoga' is the absolute best, most natural, and highly tailored path for Arjuna's specific nature.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            न कर्मणामनारम्भान्नैष्कर्म्यं पुरुषोऽश्नुते |
            न च संन्यसनादेव सिद्धिं समधिगच्छति || ४ ||
        """.trimIndent(),
        hindi = """
            मनुष्य केवल कर्मों को शुरू न करने (यानी काम से भागने) से 'नैष्कर्म्य' (कर्म-बंधन से मुक्ति) को प्राप्त नहीं कर सकता।
            और केवल कर्मों का बाहरी तौर पर संन्यास (त्याग) कर देने मात्र से ही वह परम सिद्धि (मोक्ष) को भी प्राप्त नहीं कर लेता।
            अर्जुन का यह सोचना था कि यदि मैं युद्ध (कर्म) करूँगा ही नहीं, तो मुझे पाप भी नहीं लगेगा और मैं मुक्त हो जाऊंगा। भगवान इस गलतफहमी को बहुत सख्ती से तोड़ रहे हैं।
            'नैष्कर्म्य' वह सर्वोच्च आध्यात्मिक अवस्था है जहाँ इंसान काम तो करता है, लेकिन उसका कोई भी पाप या पुण्य नहीं बनता (Freedom from reaction)।
            भगवान कहते हैं कि तुम काम से भागकर (काम न करके) इस अवस्था को कभी नहीं पा सकते। काम से भागना कोई आध्यात्मिकता नहीं, बल्कि शुद्ध आलस्य (Laziness) है।
            इसी तरह, अगर तुम केवल भगवा कपड़े पहन लो और दिखावे के लिए जंगल में चले जाओ ('संन्यसनादेव'), तो तुम्हें मोक्ष ('सिद्धि') नहीं मिल जाएगा।
            सच्चा संन्यास कपड़ों या कर्मों को छोड़ने में नहीं, बल्कि कर्म के पीछे छिपी हुई स्वार्थ और लालच की 'भावना' को छोड़ने में है।
            जब तक मन अशुद्ध है, तब तक जंगल में बैठकर भी इंसान केवल दुनिया और पाप के ही विचार करेगा।
            इसलिए, अर्जुन को भगोड़ा बनने के बजाय, युद्धभूमि में खड़ा होकर ही अपने भीतर के विकारों को जीतना होगा।
        """.trimIndent(),
        english = """
            A man can absolutely never achieve freedom from the reactions of his activities (Naishkarmyam) merely by abstaining from beginning his work.
            Nor can he ever attain supreme perfection (Siddhi/Liberation) simply by superficially renouncing the world and adopting the external order of Sannyasa.
            Arjuna harbored a deeply flawed logic: "If I simply refuse to execute this war (action), I won't incur any sin, and I will be instantly liberated." The Lord brutally crushes this misconception.
            'Naishkarmya' is the supreme transcendental state where a human performs massive actions, yet generates absolutely zero karmic reactions (neither sin nor merit).
            The Lord declares that you can never, ever achieve this exalted state simply by running away from work. Fleeing from responsibility is not high spirituality; it is pure, toxic laziness.
            Similarly, simply changing your clothes to saffron robes and retreating to a forest just for show ('sannyasanad eva') will absolutely never grant you supreme perfection ('Siddhi').
            True renunciation does not lie in physically abandoning your duty or your family; it lies entirely in violently ripping out the 'selfish intent' and 'greed' hidden behind the action.
            As long as the mind is impure, even while sitting in a remote cave, a person will endlessly meditate on worldly pleasures and sins.
            Therefore, instead of becoming a cowardly escapist, Arjuna must stand firmly on the bloody battlefield and conquer his internal demons through duty.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            न हि कश्चित्क्षणमपि जातु तिष्ठत्यकर्मकृत् |
            कार्यते ह्यवशः कर्म सर्वः प्रकृतिजैर्गुणैः || ५ ||
        """.trimIndent(),
        hindi = """
            क्योंकि कोई भी मनुष्य किसी भी काल में, एक क्षण (पल) के लिए भी बिना कर्म किए (खाली) नहीं रह सकता।
            वास्तव में, सभी प्राणी प्रकृति से उत्पन्न हुए तीनों गुणों (सत्त्व, रज, तम) के द्वारा पूरी तरह विवश (अवश) होकर कर्म करने के लिए मजबूर हैं।
            यह श्लोक ब्रह्मांड का एक अत्यंत कठोर और वैज्ञानिक सत्य (Scientific Truth) है। भगवान अर्जुन के "मैं काम नहीं करूँगा" वाले अहंकार को चकनाचूर कर रहे हैं।
            भगवान कहते हैं कि 'कुछ न करना' इंसान के लिए भौतिक रूप से असंभव है। अगर तुम चुपचाप लेट भी जाओ, तो भी तुम्हारी सांस चल रही है, दिल धड़क रहा है, और दिमाग सोच रहा है—यह सब भी 'कर्म' ही है।
            मनुष्य कोई स्वतंत्र ईश्वर नहीं है; वह प्रकृति (Material Nature) के तीन गुणों (सत्त्व, रज, तम) के अधीन एक कठपुतली (Puppet) के समान है।
            तुम्हारे भीतर मौजूद ये गुण तुम्हें हर सेकंड कुछ न कुछ करने के लिए विवश ('अवश') करेंगे। यदि तुम युद्ध का मैदान छोड़ भी दोगे, तो तुम्हारा रजोगुण तुम्हें जंगल में जाकर शिकार करने या कुछ और करने पर मजबूर कर देगा।
            जब तुम एक सेकंड के लिए भी कर्म से बच ही नहीं सकते, तो फिर अपने धर्म (Duty) से भागने का यह झूठा नाटक क्यों?
            समझदारी इसमें नहीं है कि हम काम से भागें, बल्कि असली समझदारी इसमें है कि हम इस बात को पहचानें कि हमें कौन सा काम (धर्म) करना चाहिए और उसे बिना किसी स्वार्थ के कैसे करना चाहिए।
        """.trimIndent(),
        english = """
            Because absolutely no human being can ever remain completely inactive (without performing any action) even for a single moment.
            Indeed, every single living entity is helplessly forced to act (Avashah) strictly according to the qualities he has acquired from the modes of material nature (Gunas).
            This verse reveals an extremely harsh, inescapable, and absolute scientific truth of the universe. The Lord is totally shattering Arjuna's arrogant statement: "I will not work."
            The Lord explicitly states that 'doing absolutely nothing' is physically and biologically impossible for a living entity. Even if you lie down perfectly still, your lungs are breathing, your heart is pumping blood, and your brain is actively thinking—all of these are highly active 'Karmas' (Actions).
            A human is not an independent God; he is essentially a helpless puppet completely bound under the control of Material Nature's three modes (Sattva, Rajas, Tamas).
            These inherent qualities sitting in your DNA will ruthlessly force ('Avashah') you to act every single second. Even if you run away from this war, your aggressive warrior nature (Rajas) will force you to hunt animals or fight someone else in the forest.
            When it is a biological and spiritual impossibility to escape action for even a microsecond, then what is the point of this fake, cowardly drama of abandoning your duty?
            True wisdom does not lie in attempting the impossible task of fleeing from action; true genius lies in identifying your righteous duty and executing it with absolute selflessness.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            कर्मेन्द्रियाणि संयम्य य आस्ते मनसा स्मरन् |
            इन्द्रियार्थान्विमूढात्मा मिथ्याचारः स उच्यते || ६ ||
        """.trimIndent(),
        hindi = """
            जो मूढ़ बुद्धि (अज्ञानी) मनुष्य अपनी कर्मेन्द्रियों (हाथ, पैर, वाणी आदि) को ऊपर से तो हठपूर्वक रोककर बैठ जाता है...
            परंतु अपने मन के भीतर ही भीतर लगातार इन्द्रियों के विषयों (भोगों) का ही चिंतन (स्मरण) करता रहता है, उस इंसान को 'पाखंडी' (मिथ्याचारी) कहा जाता है।
            श्रीकृष्ण यहाँ समाज में फैले हुए झूठे संन्यासियों और पाखंडियों (Hypocrites) का सबसे भयंकर पर्दाफाश (Expose) कर रहे हैं।
            अर्जुन का भी प्लान कुछ ऐसा ही था—कि वे अपने हाथ से गांडीव (कर्मेन्द्रिय) तो छोड़ देंगे और जंगल चले जाएंगे, लेकिन उनका मन हमेशा राजमहल, भाइयों और कौरवों के प्रति घृणा के बारे में ही सोचता रहेगा।
            भगवान कहते हैं कि अगर तुम बाहर से अपनी आँखें और हाथ-पैर बांध कर बैठ जाओ, लेकिन तुम्हारा दिमाग 24 घंटे पैसे, कामवासना या प्रतिशोध के ख्यालों में जलता रहे, तो तुम कोई योगी नहीं हो।
            तुम एक 'विमूढात्मा' (महामूर्ख) और 'मिथ्याचारी' (ढोंगी/Fraud) हो। ऐसा इंसान न केवल दुनिया को धोखा देता है, बल्कि वह खुद को भी धोखा दे रहा होता है।
            बाहरी कर्मों को रोक देना बहुत आसान है, लेकिन असली युद्ध इंसान के मन के भीतर होता है।
            जब तक मन शुद्ध नहीं होता, तब तक बाहर से संन्यासी के कपड़े पहन लेना इंसान को आध्यात्मिक रूप से और भी ज्यादा नीचे (नरक में) गिरा देता है।
            गीता हमेशा 'आंतरिक शुद्धि' (Internal purity) पर जोर देती है, बाहरी दिखावे पर नहीं।
        """.trimIndent(),
        english = """
            That foolish and deeply ignorant person (Vimudhatma) who forcefully restrains his working senses (hands, legs, voice) outwardly...
            but whose mind continues to intensely dwell upon and meditate on sense objects (Indriyarthan) internally, is certainly a complete hypocrite and a pretender (Mithyacharah).
            Lord Sri Krishna is delivering a devastating and brutal expose of the fake renunciates and spiritual frauds (Hypocrites) prevalent in society.
            Arjuna's current plan was dangerously close to this—he planned to physically drop his bow (restraining the working sense) and run to the forest, but his mind would undoubtedly continue burning with thoughts of the royal palace, his brothers, and his hatred for the Kauravas.
            The Lord aggressively warns that if you physically tie up your hands and close your eyes, but your brain is secretly meditating 24/7 on intense lust, money, or revenge, you are absolutely not a Yogi.
            You are a 'Vimudhatma' (a colossal fool) and a 'Mithyachara' (a complete fraud). Such a toxic hypocrite not only successfully cheats the innocent world, but he tragically cheats his own soul.
            Mechanically stopping external physical actions is incredibly easy, but the actual, terrifying war is fought strictly inside the mind.
            Until the mind is thoroughly purified, wearing the external robes of a saint simply drags a person even deeper into a horrific spiritual hell.
            The Gita places absolute, non-negotiable emphasis on 'Internal Purity' over superficial external showmanship.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            यस्त्विन्द्रियाणि मनसा नियम्यारभतेऽर्जुन |
            कर्मेन्द्रियैः कर्मयोगमसक्तः स विशिष्यते || ७ ||
        """.trimIndent(),
        hindi = """
            परंतु हे अर्जुन! जो सच्चा और निष्कपट मनुष्य अपने मन के द्वारा अपनी इन्द्रियों को पूरी तरह वश में करके (नियमित करके)...
            बिना किसी आसक्ति (स्वार्थ) के अपनी कर्मेन्द्रियों के द्वारा 'कर्मयोग' (कर्तव्य का पालन) का आचरण करना आरंभ करता है, वही मनुष्य सबसे श्रेष्ठ (विशिष्यते) है।
            पिछले श्लोक के पाखंडी (Hypocrite) की तुलना में, भगवान यहाँ एक सच्चे और श्रेष्ठ कर्मयोगी (True Hero) का वर्णन कर रहे हैं।
            यह सच्चा कर्मयोगी दुनिया छोड़कर गुफा में नहीं भागता। वह इसी समाज में रहता है, अपने परिवार को पालता है, ऑफिस जाता है या (अर्जुन की तरह) भयंकर युद्ध लड़ता है।
            वह अपनी कर्मेन्द्रियों (हाथ, पैर) को पूरी तरह से सक्रिय (Active) रखता है। लेकिन उसका रहस्य (Secret) उसके मन में छिपा है।
            उसने अपने 'मन' के द्वारा अपनी ज्ञानेंद्रियों (आकर्षणों) पर एक लोहे का ताला लगा रखा है। वह कर्म करता है, लेकिन उसके फलों में 'असक्तः' (अनासक्त / Detached) रहता है।
            जब वह इंसान समाज के बीच रहकर बिना किसी स्वार्थ, अहंकार या लालच के अपनी ड्यूटी 100% ईमानदारी से निभाता है, तो भगवान कहते हैं कि "स विशिष्यते" (वह उन दिखावटी संन्यासियों से करोड़ों गुना अधिक महान है)।
            भगवान अर्जुन को एक भगोड़ा संन्यासी नहीं, बल्कि एक अजेय और अनासक्त योद्धा (कर्मयोगी) बनाना चाहते हैं, जो दुनिया में रहते हुए भी दुनिया की गंदगी से कमल की तरह अछूता रहे।
        """.trimIndent(),
        english = """
            On the other hand, O Arjuna, if a sincere person flawlessly controls his senses by his purified mind (Manasa niyamya)...
            and actively begins to engage his working organs in the path of selfless action (Karma-yoga) completely without any attachment (Asaktah), he is by far the most superior (Vishishyate).
            In stark, beautiful contrast to the disgusting hypocrite in the previous verse, the Lord here perfectly describes the characteristics of a genuine, elite Karma Yogi (A True Hero).
            This authentic Karma Yogi absolutely does not run away to hide in a remote mountain cave. He lives right in the chaotic center of society, raises his family, runs businesses, or (like Arjuna) fights terrifying world wars.
            He keeps his working senses (hands, legs) hyper-active and intensely engaged in the world. But his ultimate superpower (Secret) lies hidden in his mind.
            Using his highly trained 'Mind', he has placed a titanium lock on his sensory attractions. He executes massive actions, but remains entirely 'Asaktah' (100% detached) from the selfish fruits of those actions.
            When a human being lives right amidst the materialistic society and executes his prescribed duty with 100% integrity, absolutely zero selfishness, and zero ego, the Lord declares "Sa vishishyate" (He is infinitely superior to those fake, show-bottle renunciates).
            The Lord does not want to turn Arjuna into a cowardly, escapist monk; He wants to forge him into an invincible, detached warrior (Karma Yogi) who remains as flawlessly pure as a lotus leaf even while floating in muddy water.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            नियतं कुरु कर्म त्वं कर्म ज्यायो ह्यकर्मणः |
            शरीरयात्रापि च ते न प्रसिद्धयेदकर्मणः || ८ ||
        """.trimIndent(),
        hindi = """
            इसलिए हे अर्जुन! तुम अपने लिए शास्त्रों द्वारा निर्धारित किए गए (नियतं) कर्म (कर्तव्य) को करो; क्योंकि बिल्कुल कर्म न करने (अकर्म) की अपेक्षा कर्म करना हमेशा बहुत श्रेष्ठ (ज्यायः) है।
            और कर्म न करने से (यानी आलसी होकर बैठ जाने से) तो तुम्हारे इस शरीर का निर्वाह (शरीरयात्रा) भी कभी सिद्ध नहीं हो पाएगा।
            श्रीकृष्ण अब अर्जुन के मन से 'कुछ न करने' (Inaction) का भूत पूरी तरह उतार रहे हैं।
            वे एक बहुत ही स्पष्ट और प्रैक्टिकल (Practical) आज्ञा देते हैं: "नियतं कुरु कर्म" (अपने ड्यूटी को निभाओ)। अर्जुन का नियत कर्म एक क्षत्रिय के रूप में समाज की रक्षा करना है।
            भगवान तर्क देते हैं कि 'अकर्म' (कुछ न करना / आलस्य) से 'कर्म' (एक्शन) हमेशा एक लाख गुना बेहतर होता है। खाली दिमाग शैतान का घर होता है, जो इंसान को पतन की ओर ले जाता है।
            फिर भगवान एक ऐसा तर्क देते हैं जिसे कोई इंसान झुटला नहीं सकता। वे कहते हैं कि तुम संन्यास लेने की बात कर रहे हो, लेकिन संन्यास लेकर भी तुम्हें जिंदा रहने के लिए खाना तो खाना ही पड़ेगा।
            भोजन जुटाने के लिए भी तुम्हें भिक्षा मांगने का 'कर्म' तो करना ही पड़ेगा। जब शरीर को चलाने (शरीरयात्रा) के लिए भी बिना कर्म के गुजारा नहीं है, तो फिर अपने सबसे महान कर्तव्य (युद्ध) से भागने का नाटक क्यों?
            भगवान स्पष्ट कर रहे हैं कि कर्म से भागना प्रकृति के नियम के खिलाफ है; इसलिए जो काम तुम्हारे हिस्से में आया है, उसे बिना शिकायत किए पूरी ईमानदारी से पूरा करो।
        """.trimIndent(),
        english = """
            Therefore, O Arjuna, perform your prescribed and bounden duty (Niyatam karma), for executing action is invariably far superior and better (Jyayo) than not working at all (Akarmanah).
            Moreover, without performing work, one cannot even successfully maintain one's own physical body (Sharira-yatra).
            Sri Krishna is now violently exorcising the ghost of 'Inaction' (Doing nothing) completely out of Arjuna's confused mind.
            He issues a remarkably clear, direct, and highly practical command: "Niyatam kuru karma" (Execute your prescribed duty without fail). Arjuna's unchangeable prescribed duty as a Kshatriya is to ruthlessly protect society from tyrants.
            The Lord logically argues that 'Karma' (Action) is always a million times superior to 'Akarma' (Inaction / pure laziness). An idle, inactive mind is the ultimate devil's workshop that drags a human into dark degradation.
            Then the Lord delivers a highly practical, earthly argument that absolutely no human can refute. He says: You are talking about taking renunciation, but even as a monk, you will still have to eat food just to stay alive.
            And simply to gather that basic food, you will be forced to perform the 'action' of begging. When even maintaining the basic biological functions of this physical body (Sharira-yatra) is completely impossible without action, then why this theatrical drama of running away from your supreme duty?
            The Lord is making it crystal clear that escaping from action is a total violation of the laws of nature; therefore, you must forcefully embrace whatever righteous duty has fallen upon your shoulders and execute it flawlessly.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            यज्ञार्थात्कर्मणोऽन्यत्र लोकोऽयं कर्मबन्धनः |
            तदर्थं कर्म कौन्तेय मुक्तसङ्गः समाचर || ९ ||
        """.trimIndent(),
        hindi = """
            श्री विष्णु (यज्ञ) के लिए किए गए कर्मों के अलावा, इस भौतिक संसार में जो भी कर्म किया जाता है, वह इस मनुष्य को जन्म-मृत्यु के बंधन (कर्मबन्धनः) में बुरी तरह बाँधने वाला होता है।
            इसलिए हे कुन्तीपुत्र (कौन्तेय)! तुम पूरी तरह से आसक्ति-रहित (मुक्तसङ्गः) होकर, केवल उन श्री भगवान (यज्ञ) की प्रसन्नता के लिए ही अपने सभी कर्तव्यों का आचरण (समाचर) करो।
            अब अर्जुन के मन में यह सवाल आ सकता है कि "अगर मैं लगातार कर्म करूँगा, तो मैं कर्म के फल (पाप/पुण्य) में बंध नहीं जाऊंगा?"
            भगवान इसका एक बहुत ही शक्तिशाली और अचूक (Bulletproof) समाधान देते हैं: 'यज्ञार्थात् कर्म' (ईश्वर के लिए किया गया कर्म)।
            'यज्ञ' का अर्थ केवल आग में आहुति देना नहीं है; यहाँ यज्ञ का अर्थ स्वयं परमेश्वर (विष्णु) हैं।
            भगवान कहते हैं कि यदि तुम कोई भी काम अपनी स्वार्थ-सिद्धि, लालच, या अहंकार को खुश करने के लिए करोगे, तो वह काम एक लोहे की जंजीर बनकर तुम्हें इस संसार में हमेशा के लिए बाँध देगा ('कर्मबन्धनः')।
            लेकिन यदि तुम अपने कर्तव्य (जैसे युद्ध लड़ना, व्यापार करना, या पढ़ाई करना) को भगवान की सेवा समझकर, बिना किसी पर्सनल एजेंडे (Personal Agenda / मुक्तसङ्गः) के करोगे, तो वह कर्म दिव्य हो जाएगा।
            ईश्वर के लिए किया गया कोई भी काम कभी इंसान को नहीं बाँधता, बल्कि वह उसे सारे पिछले बंधनों से आज़ाद (मुक्त) कर देता है।
            यही कर्मयोग का सबसे बड़ा रहस्य है: काम सारे करो, लेकिन अपने लिए नहीं, बल्कि ईश्वर को अर्पण करने के लिए करो।
        """.trimIndent(),
        english = """
            Any work performed as a direct sacrifice for Lord Vishnu (Yajna) has to be performed; otherwise, any other work causes severe bondage (Karma-bandhanah) in this material world.
            Therefore, O son of Kunti (Kaunteya), strictly perform your prescribed duties entirely for His supreme satisfaction, completely freeing yourself from all selfish attachment (Mukta-sangah); in that way, you will always remain free from bondage.
            A very natural question could arise in Arjuna's mind now: "If I continuously perform massive actions like a brutal war, won't I inevitably get tangled up in the karmic reactions (sin) of those actions?"
            The Lord delivers a highly powerful, absolutely bulletproof solution here: 'Yajnarthat karma' (Action executed solely as a sacrifice for God).
            'Yajna' absolutely does not just mean throwing grains into a fire ritual; here, Yajna specifically refers to the Supreme Lord (Vishnu) Himself.
            The Lord issues a terrifying warning: If you perform any action solely to satisfy your own personal greed, bloated ego, or selfish motives, that action will instantly forge a heavy iron chain that will permanently bind you to the horrific cycle of rebirth ('Karma-bandhanah').
            But, if you flawlessly execute your exact same prescribed duty (whether it is fighting a war, doing a job, or studying) purely as a loving service to the Supreme Lord, with zero personal agenda ('Mukta-sangah'), that ordinary action becomes highly transcendental.
            Any work executed purely for the pleasure of God never, ever binds the soul; rather, it burns down all previous karmic chains and liberates the soul.
            This is the ultimate, master secret of Karma Yoga: Perform absolutely every action with immense intensity, but not for your own selfish enjoyment; do it strictly as an offering to God.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            सहयज्ञाः प्रजाः सृष्ट्वा पुरोवाच प्रजापतिः |
            अनेन प्रसविष्यध्वमेष वोऽस्त्विष्टकामधुक् || १० ||
        """.trimIndent(),
        hindi = """
            सृष्टि के बिल्कुल आरंभ (शुरुआत) काल में, प्रजापति (ब्रह्मा जी/परमेश्वर) ने यज्ञ (बलिदान/कर्तव्य) के सहित सभी प्रजाओं (मनुष्यों) की रचना की...
            और उनसे यह कहा: "तुम सभी इस यज्ञ (निस्वार्थ कर्तव्य) के द्वारा ही वृद्धि को प्राप्त हो (फलो-फूलो); और यह यज्ञ ही तुम लोगों की सभी ऐच्छिक कामनाओं (इच्छाओं) को पूर्ण करने वाला (इष्टकामधुक्) हो।"
            श्रीकृष्ण अब 'यज्ञ' (Sacrifice/Duty) के सिद्धांत को ब्रह्मांड की रचना (Creation of the Universe) के साथ जोड़कर समझा रहे हैं।
            वे कहते हैं कि जब भगवान ने इस दुनिया और इंसानों को बनाया, तो उन्होंने इंसानों को अकेला नहीं छोड़ा; उन्होंने इंसानों के साथ 'यज्ञ' (Duty/Sacrifice) का एक इनबिल्ट सिस्टम (Inbuilt System) भी बनाया।
            यहाँ 'यज्ञ' का मतलब केवल आग जलाना नहीं है; इसका असली मतलब है 'परस्पर सहयोग' (Mutual Cooperation) और 'निस्वार्थ भाव से अपना कर्तव्य निभाना'।
            भगवान ने दुनिया को एक इकोसिस्टम (Ecosystem) की तरह बनाया है जहाँ हर जीव दूसरे पर निर्भर है। पेड़ हमें ऑक्सीजन देते हैं (यह उनका यज्ञ है), नदियां हमें पानी देती हैं।
            भगवान ने इंसानों से कहा कि अगर तुम स्वार्थी होकर केवल अपना पेट भरोगे, तो तुम नष्ट हो जाओगे। लेकिन अगर तुम 'यज्ञ' की भावना से (दूसरों की भलाई और ईश्वर की प्रसन्नता के लिए) अपना काम करोगे...
            तो यह निस्वार्थ कर्म (यज्ञ) कामधेनु गाय ('इष्टकामधुक्') की तरह बन जाएगा, जो तुम्हारी भौतिक और आध्यात्मिक दोनों जरूरतों को पूरा करेगा।
            समृद्धि (Prosperity) हमेशा त्याग और ईमानदारी से काम करने वाले समाज में ही आती है।
        """.trimIndent(),
        english = """
            In the very beginning of creation (Pura), the Lord of all creatures (Prajapati) created generations of men and demigods along with the principle of sacrifice (Saha-yajnah)...
            and blessed them by saying: "Be thou increasingly prosperous and happy by performing this Yajna (Sacrifice); because its correct performance will act as a wish-fulfilling cow (Ishta-kama-dhuk), bestowing upon you everything desirable for living happily and achieving liberation."
            Sri Krishna is now brilliantly connecting the profound principle of 'Yajna' (Sacrifice/Duty) directly to the very dawn of cosmic creation itself.
            He explains that when the Supreme Lord engineered this world and human beings, He absolutely did not leave humanity stranded and alone; He simultaneously created a flawless, inbuilt Universal Operating System called 'Yajna'.
            Here, 'Yajna' fundamentally does not just mean lighting a ritualistic fire; its true, deep essence means 'Mutual Cooperation' and 'Performing one's prescribed duties with utter selflessness'.
            The Lord masterfully designed the entire universe as an interdependent Ecosystem. Trees sacrifice themselves to give us oxygen (that is their Yajna), and rivers flow to give us water.
            The Lord instructed humanity: If you act like a selfish parasite and only hoard resources for yourself, you will be destroyed. But if you execute your duties in the pure spirit of 'Yajna' (for the welfare of others and the pleasure of God)...
            then this selfless action (Yajna) will magically transform into a mythical wish-fulfilling cow ('Ishta-kama-dhuk'), flawlessly providing you with all material opulence and ultimate spiritual liberation.
            True, lasting prosperity (Prosperity) is only achieved in a society that operates on the divine principles of mutual sacrifice and dedicated duty.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            देवान्भावयतानेन ते देवा भावयन्तु वः |
            परस्परं भावयन्तः श्रेयः परमवाप्स्यथ || ११ ||
        """.trimIndent(),
        hindi = """
            तुम लोग इस यज्ञ (अपने निर्धारित कर्तव्यों और आहुतियों) के द्वारा देवताओं को प्रसन्न (उन्नत) करो, और वे देवता वर्षा आदि देकर तुम लोगों को प्रसन्न (समृद्ध) करें।
            इस प्रकार बिना किसी स्वार्थ के एक-दूसरे को प्रसन्न (सहयोग) करते हुए, तुम सब निश्चित रूप से परम कल्याण (परम श्रेय) को प्राप्त हो जाओगे।
            यहाँ भगवान श्रीकृष्ण उस 'ब्रह्मांडीय इकोसिस्टम' (Cosmic Ecosystem) का सबसे सुंदर और वैज्ञानिक वर्णन कर रहे हैं जो दुनिया को चलाता है।
            देवता कोई काल्पनिक चरित्र नहीं हैं; वे ब्रह्मांड के विभिन्न विभागों (Departments) के प्रबंधक (Managers) हैं, जैसे सूर्य (रोशनी), वरुण (जल), और वायु।
            यह पूरी प्रकृति एक कॉर्पोरेट सिस्टम (Corporate System) की तरह है। भगवान कहते हैं कि मनुष्य और प्रकृति (देवताओं) के बीच एक कॉन्ट्रैक्ट (Contract) है।
            मनुष्य को चाहिए कि वह प्रकृति का दोहन (Exploit) न करे, बल्कि यज्ञों (प्रकृति का सम्मान और भगवान की पूजा) के माध्यम से देवताओं को शक्ति और सम्मान दे।
            जब मनुष्य अपना काम ईमानदारी से करता है और प्रकृति का सम्मान करता है, तो देवता (प्रकृति) खुश होकर उसे समय पर बारिश, अच्छी फसल और जीवन जीने के सभी साधन देते हैं।
            यह 'गिव एंड टेक' (Give and Take) का नियम है। यदि इंसान केवल प्रकृति से छीनता रहेगा और वापस कुछ नहीं देगा, तो सिस्टम क्रैश (Crash) हो जाएगा (जैसे ग्लोबल वार्मिंग)।
            'परस्परं भावयन्तः'—केवल जब मनुष्य और प्रकृति एक दूसरे का सहयोग और सम्मान करते हैं, तभी दुनिया में शांति, समृद्धि और अंतिम आध्यात्मिक कल्याण (श्रेय) आ सकता है।
        """.trimIndent(),
        english = """
            By your performance of these prescribed sacrifices (Yajna), you shall please and nourish the demigods, and in turn, those demigods will please and prosper you.
            Thus, by mutually nourishing and cooperating with one another without selfishness, you will absolutely attain the supreme benediction and ultimate prosperity for all (Param Shreyah).
            Here, Lord Sri Krishna is providing the most beautiful, highly scientific description of the 'Cosmic Ecosystem' that flawlessly runs the entire universe.
            Demigods (Devas) are not mythical, imaginary characters; they are highly powerful, authorized cosmic managers appointed by God to supply essential necessities like sunlight (Surya), water (Varuna), and air (Vayu).
            This entire material nature functions exactly like a massive, highly organized Corporate System. The Lord establishes that there is a strict, sacred contract between humanity and material nature (the demigods).
            Humans are strictly commanded not to brutally exploit or rape nature, but to nourish and honor the cosmic managers through 'Yajnas' (respecting nature, performing duties, and worshiping God).
            When humanity honestly performs its duties and shows gratitude, the pleased demigods (Nature) automatically provide timely rains, abundant crops, and all the essential resources required for a happy life.
            This is the ultimate, unbreakable law of 'Give and Take'. If humans act like greedy viruses, only extracting from nature and giving absolutely nothing back, the entire cosmic system will crash (e.g., Global Warming/Climate Change).
            'Parasparam bhavayantah'—Only when humanity and nature engage in a symbiotic relationship of mutual cooperation and deep respect, can true global peace, massive prosperity, and ultimate spiritual liberation (Shreya) be achieved.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            इष्टान्भोगान्हि वो देवा दास्यन्ते यज्ञभाविताः |
            तैर्दत्तानप्रदायैभ्यो यो भुङ्क्ते स्तेन एव सः || १२ ||
        """.trimIndent(),
        hindi = """
            यज्ञ के द्वारा अत्यंत प्रसन्न (संतुष्ट) हुए देवता तुम लोगों को बिना मांगे ही तुम्हारी इच्छित जीवन की सभी आवश्यक वस्तुएं (भोग) निश्चित रूप से प्रदान करेंगे।
            परंतु उन देवताओं (या प्रकृति/ईश्वर) के द्वारा दिए गए इन उपहारों (अन्न, जल, वायु) को बिना उन्हें अर्पण किए (बिना धन्यवाद दिए) जो व्यक्ति खुद ही अकेले भोगता है, वह निश्चित रूप से एक 'चोर' (स्तेन) ही है।
            भगवान श्रीकृष्ण यहाँ कृतज्ञता (Gratitude) का सबसे बड़ा पाठ पढ़ा रहे हैं और मनुष्य के स्वार्थ पर भयंकर चोट कर रहे हैं।
            वे कहते हैं कि इंसान का अहंकार इतना बड़ा है कि वह सोचता है, "मैंने पैसे से खाना खरीदा है, यह मेरा है।"
            लेकिन सच्चाई यह है कि इंसान फैक्ट्री में सूरज की रोशनी, बारिश का पानी, या मिट्टी की उर्वरता (Fertility) नहीं बना सकता। यह सब प्रकृति (देवताओं) का दिया हुआ एक मुफ़्त उपहार (Gift) है।
            भगवान कहते हैं कि प्रकृति तुम्हें सब कुछ दे रही है, लेकिन तुम्हारी भी एक नैतिक जिम्मेदारी (Moral Responsibility) है।
            तुम्हें खाने या भोगने से पहले उस ईश्वर और प्रकृति के प्रति आभार (यज्ञ के रूप में) प्रकट करना चाहिए कि "हे प्रभु, यह आपका दिया हुआ है, पहले आप इसे ग्रहण करें।"
            जो इंसान इतना एहसान फरामोश और स्वार्थी है कि वह प्रकृति से सब कुछ मुफ़्त में ले लेता है और बदले में ईश्वर को धन्यवाद (यज्ञ) तक नहीं देता...
            भगवान उसे कोई आम पापी नहीं, बल्कि सीधे-सीधे एक 'चोर' (Thief / स्तेन) घोषित करते हैं। एक चोर को ब्रह्मांड के कानून (Karma) के अनुसार कड़ी सजा मिलनी तय है।
        """.trimIndent(),
        english = """
            The demigods, being immensely satisfied by the performance of your sacrifices (Yajna), will undoubtedly supply all the desired necessities of life (Bhoga) to you.
            But he who selfishly enjoys these gifts directly given by the demigods without offering them back to them in return (in gratitude), is most certainly a confirmed thief (Stena).
            Lord Sri Krishna is teaching the absolute greatest lesson on 'Gratitude' here, while simultaneously delivering a massive, crushing blow to human selfishness and arrogance.
            He highlights that human ego is so absurdly bloated that a man foolishly thinks, "I bought this food with my hard-earned money, therefore it belongs solely to me."
            But the brutal reality is that no human being can ever manufacture sunlight, monsoon rains, or the fertile soil of the earth in a laboratory factory. All these are massive, free cosmic gifts provided exclusively by Nature (the demigods).
            The Lord dictates that while Nature is generously supplying everything you need to survive, you carry a massive, un-ignorable moral responsibility.
            Before you aggressively consume or enjoy anything, you must display basic gratitude (in the form of Yajna) to God and Nature, acknowledging, "O Lord, this is all given by You; please accept this offering first."
            A human being who is so incredibly ungrateful, parasitic, and selfish that he extracts everything for free from the cosmic system and refuses to offer even a basic 'Thank You' (Yajna) back to God...
            The Supreme Lord bluntly declares him not just an ordinary sinner, but explicitly a cosmic 'Thief' (Stena). And according to the absolute laws of Karma, a cosmic thief is guaranteed to face severe universal punishment.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            यज्ञशिष्टाशिनः सन्तो मुच्यन्ते सर्वकिल्बिषैः |
            भुञ्जते ते त्वघं पापा ये पचन्त्यात्मकारणात् || १३ ||
        """.trimIndent(),
        hindi = """
            जो भगवान के भक्त (सज्जन पुरुष) यज्ञ (ईश्वर को अर्पण) करने के बाद बचे हुए अन्न (प्रसाद) को खाते हैं, वे जीवन के सभी पापों से पूरी तरह मुक्त हो जाते हैं।
            परंतु जो महापापी लोग केवल अपने ही शरीर के पोषण (स्वाद और स्वार्थ) के लिए अन्न पकाते हैं, वे तो वास्तव में केवल पाप (अघं) को ही खाते हैं।
            यह श्लोक भारतीय संस्कृति के सबसे पवित्र नियम 'प्रसाद' (Prasadam) का वैज्ञानिक और आध्यात्मिक आधार (Base) है।
            हम जो भी भोजन खाते हैं (चाहे वह शाकाहारी ही क्यों न हो), उसे उगाने, काटने और पकाने में जाने-अनजाने में हजारों सूक्ष्म जीवों (कीड़ों-मकोड़ों, बैक्टीरिया) की हत्या होती है।
            इसलिए भोजन के साथ अदृश्य रूप से हत्या का 'पाप' जुड़ा होता है।
            लेकिन जब एक भक्त उस भोजन को पहले प्रेम और कृतज्ञता के साथ भगवान (यज्ञ) को अर्पण कर देता है, तो भगवान उस भोजन को स्वीकार करके उसके सारे पापों को नष्ट कर देते हैं, और वह भोजन दिव्य 'प्रसाद' बन जाता है।
            प्रसाद खाने वाला व्यक्ति कर्म के चक्र (Karmic reactions) से पूरी तरह बच जाता है।
            इसके विपरीत, जो व्यक्ति इतना स्वार्थी है कि वह सोचता है "यह मेरा खाना है, मैं केवल अपनी जीभ के स्वाद के लिए पकाऊँगा", वह इंसान भोजन नहीं खा रहा है।
            भगवान अत्यंत कठोर शब्दों में कहते हैं कि वह इंसान वास्तव में प्लेट में रखकर अपना 'पाप' (Sin / अघं) खा रहा है, जो आगे चलकर उसके जीवन में बीमारी और दुःख का कारण बनेगा।
        """.trimIndent(),
        english = """
            The devotees of the Lord are completely released from all kinds of sins (Sarva-kilbishaih) because they eat food which is offered first for sacrifice (Yajna-shishta).
            Others, however, who selfishly prepare food purely for their own personal sense enjoyment, verily eat only sin (Agham).
            This profoundly powerful verse establishes the absolute scientific and spiritual foundation of Indian culture's most sacred law: 'Prasadam' (Sanctified Food).
            Every single morsel of food we eat (even the strictest vegetarian diet) involves the unavoidable, accidental killing of millions of microscopic living entities, insects, and plants during its growing, harvesting, and cooking processes.
            Therefore, a heavy, invisible karmic debt of 'Sin' is inevitably attached to all unoffered food.
            However, when a sincere devotee first offers that freshly cooked food to the Supreme Lord (Yajna) with deep love and gratitude, the Lord accepts the devotion, completely incinerates all associated sins, and transforms the food into transcendental 'Prasadam'.
            A person who eats this divine Prasadam remains 100% immune to the terrifying karmic reactions of material existence.
            In strict contrast, a person who is so violently selfish that he thinks, "This is my food, I am cooking it exclusively for the pleasure of my own tongue," is not actually eating nutritious food.
            The Lord uses extremely harsh vocabulary to declare that such an arrogant person is literally eating a plate full of concentrated 'Sin' (Agham), which will inevitably manifest as terrible diseases, suffering, and hellish karmic reactions in his future.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            अन्नाद्भवन्ति भूतानि पर्जन्यादन्नसम्भवः |
            यज्ञाद्भवति पर्जन्यो यज्ञः कर्मसमुद्भवः || १४ ||
        """.trimIndent(),
        hindi = """
            सभी प्राणी (जीव-जंतु) अन्न (भोजन) से ही उत्पन्न होते हैं और जीवित रहते हैं; अन्न की उत्पत्ति भारी वर्षा (पर्जन्य) से होती है;
            वर्षा की उत्पत्ति यज्ञ (पुण्य कर्मों) से होती है; और यज्ञ की उत्पत्ति निर्धारित कर्मों (ड्यूटी) के करने से होती है।
            भगवान श्रीकृष्ण यहाँ पूरी सृष्टि की कार्यप्रणाली (Cycle of Creation and Sustenance) को एक शानदार वैज्ञानिक 'चेन रिएक्शन' (Chain Reaction) के माध्यम से समझा रहे हैं।
            यह एक इकोलॉजिकल (Ecological) और स्पिरिचुअल (Spiritual) साइकिल है:
            १. इंसान और जानवर जिंदा रहने के लिए पूरी तरह से 'अन्न' (फसलों/भोजन) पर निर्भर हैं।
            २. लेकिन अन्न फैक्ट्रियों में नहीं बनता, वह खेतों में 'वर्षा' (Rain) से पैदा होता है।
            ३. वर्षा कोई मौसम विभाग (Weather department) नहीं करा सकता; जब समाज में लोग 'यज्ञ' (पवित्रता, दान, परोपकार और ईश्वर का स्मरण) करते हैं, तो प्रकृति (देवता) प्रसन्न होकर समय पर बारिश देती है।
            ४. और यज्ञ तभी संभव है जब मनुष्य अपना 'कर्म' (निर्धारित ड्यूटी) पूरी ईमानदारी और मेहनत से करे।
            अर्थात्, अगर मनुष्य अपना काम (कर्म) छोड़ देगा, तो यज्ञ नहीं होगा। यज्ञ नहीं होगा, तो बारिश नहीं होगी। बारिश नहीं होगी, तो अन्न पैदा नहीं होगा। और अन्न नहीं होगा, तो पूरी मानव जाति भूखी मर जाएगी।
            अर्जुन को यह समझाया जा रहा है कि तुम्हारा युद्ध न करना केवल तुम्हारी व्यक्तिगत कायरता नहीं है; यह इस पूरे ब्रह्मांडीय चक्र (Cosmic Cycle) को तोड़ने का एक भयंकर अपराध है।
        """.trimIndent(),
        english = """
            All living bodies completely subsist and are sustained on food grains (Anna), which are directly produced from timely rains (Parjanya).
            Rains are produced by the performance of prescribed sacrifices (Yajna), and Yajna is born of the execution of prescribed duties (Karma).
            Lord Sri Krishna is brilliantly explaining the absolute operational mechanics of the entire universe (Cycle of Creation and Sustenance) through an extraordinarily flawless scientific 'Chain Reaction' here.
            He presents a profound Ecological and Spiritual Cycle that sustains life:
            1. All humans and animals are 100% helplessly dependent on 'Anna' (Food grains/Crops) to survive and grow.
            2. But food cannot be manufactured in a chemical laboratory; it is produced exclusively from the earth through timely 'Rains' (Parjanya).
            3. Rains are absolutely not controlled by human weather departments; when a society actively performs 'Yajna' (acts of purity, charity, selfless service, and worship of God), the cosmic managers (Demigods/Nature) are deeply satisfied and release abundant rains.
            4. And Yajna is only possible when human beings execute their prescribed 'Karma' (Duties) with extreme honesty, sacrifice, and hard work.
            Meaning, if a human abandons his duty (Karma), Yajna stops. If Yajna stops, rains fail (drought). If rains fail, food vanishes. And if food vanishes, the entire human race will face mass extinction through starvation.
            Arjuna is being severely warned that his cowardly desire to abandon the war is not just a personal choice; it is a horrific cosmic crime that violently disrupts the entire universal cycle of sustenance.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            कर्म ब्रह्मोद्भवं विद्धि ब्रह्माक्षरसमुद्भवम् |
            तस्मात्सर्वगतं ब्रह्म नित्यं यज्ञे प्रतिष्ठितम् || १५ ||
        """.trimIndent(),
        hindi = """
            तुम यह जान लो कि सभी कर्तव्य-कर्मों की उत्पत्ति 'ब्रह्म' (वेदों) से हुई है, और वेदों की उत्पत्ति सीधे उस 'अक्षर' (अविनाशी परमात्मा) से हुई है।
            इसलिए, वह सर्वव्यापी (सब जगह मौजूद) परम ब्रह्म (परमात्मा) हमेशा 'यज्ञ' (निस्वार्थ कर्मों) में ही प्रतिष्ठित (विद्यमान) रहता है।
            पिछले श्लोक के साइकिल को भगवान यहाँ उसके अंतिम स्रोत (Ultimate Source) तक ले जा रहे हैं।
            मनुष्य को कैसे पता चलेगा कि उसे कौन सा 'कर्म' (ड्यूटी) करना है? भगवान बताते हैं कि यह जानकारी 'ब्रह्म' अर्थात् 'वेदों' (धर्मग्रंथों) में दी गई है; वेदों में समाज को चलाने के सारे नियम (Constitution) लिखे हैं।
            और ये वेद किसी साधारण इंसान ने नहीं लिखे हैं; ये सीधे 'अक्षर' (उस परमेश्वर, जिसके शब्दों का कभी क्षय नहीं होता) की श्वास (सांस) से प्रकट हुए हैं।
            चूँकि कर्म का नियम सीधे ईश्वर से आया है, इसलिए यह एक अटल सत्य है कि जो व्यक्ति निस्वार्थ भाव से अपना कर्तव्य (यज्ञ) करता है, वह सीधे ईश्वर से जुड़ जाता है।
            "सर्वगतं ब्रह्म नित्यं यज्ञे प्रतिष्ठितम्"—भगवान कहीं आसमान में छुपकर नहीं बैठे हैं; भगवान तुम्हारे द्वारा किए जा रहे उस 'निस्वार्थ काम' और 'त्याग' के भीतर हमेशा साक्षात् मौजूद रहते हैं।
            जब तुम धर्म की रक्षा के लिए युद्ध करते हो (यज्ञ), तो भगवान उसी युद्धभूमि में तुम्हारे कर्म के भीतर प्रकट हो जाते हैं। अर्जुन को यह समझना होगा कि उनका युद्ध करना ही सबसे बड़ी ईश्वर-पूजा है।
        """.trimIndent(),
        english = """
            You should clearly know that all regulated activities (Karma) are prescribed in the Vedas (Brahma), and the Vedas are directly manifested from the imperishable Supreme Personality of Godhead (Akshara).
            Consequently, the all-pervading Supreme Transcendence (Brahman) is eternally situated in acts of sacrifice (Yajna).
            The Lord is expanding the universal cycle from the previous verse, perfectly tracing it back to its absolute Ultimate Source.
            How does a human being know exactly what specific 'Karma' (Duty) he is supposed to perform? The Lord explains that this crucial manual is written in 'Brahma' (the Holy Vedas); the Vedas are the supreme Constitution containing all laws for running a perfect society.
            And these pristine Vedas were absolutely not authored by any flawed, ordinary mortal; they directly manifested from the very breath of the 'Akshara' (The Supreme, Imperishable Lord Himself).
            Since the laws of Karma originate directly from the Supreme Lord, it is an unshakable truth that a person who performs his duty selflessly (Yajna) plugs directly into the power of God.
            "Sarva-gatam brahma nityam yajne pratishthitam"—The Supreme Lord is not hiding far away behind the clouds; the Lord is eternally, physically present right inside the very heart of 'Selfless Action' and 'Sacrifice'.
            When you fight a terrifying war strictly to protect dharma (which is a Yajna), God instantly manifests right there within your action on the battlefield. Arjuna must realize that fighting this righteous war is his absolute highest form of worshiping God.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            एवं प्रवर्तितं चक्रं नानुवर्तयतीह यः |
            अघायुरिन्द्रियारामो मोघं पार्थ स जीवति || १६ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जो मनुष्य इस जीवन में (दुनिया में) ईश्वर द्वारा इस प्रकार चलाए गए सृष्टि-चक्र (कर्म और यज्ञ के नियम) के अनुसार नहीं चलता...
            वह पापायु (पाप का जीवन जीने वाला) और इन्द्रियों के भोगों में ही रमण करने वाला (इन्द्रियारामो) अज्ञानी मनुष्य इस दुनिया में पूरी तरह व्यर्थ (बेकार) ही जीता है।
            भगवान श्रीकृष्ण यहाँ उन लोगों पर सबसे कड़ी फटकार (Harsh Condemnation) लगा रहे हैं जो अपने कर्तव्यों से भागते हैं।
            उन्होंने 14वें और 15वें श्लोक में जो एक शानदार इकोलॉजिकल और आध्यात्मिक 'चक्र' (Cycle) बताया था (कर्म -> यज्ञ -> वर्षा -> अन्न -> जीवन), वह भगवान द्वारा स्थापित एक सिस्टम (System) है।
            जो व्यक्ति सोचता है, "मैं कोई काम नहीं करूँगा, मैं समाज को कुछ नहीं दूँगा, बस आराम से बैठकर मुफ्त की रोटियां खाऊंगा और मज़े लूँगा", वह इस ब्रह्मांडीय चक्र का एक वायरस (Virus) या परजीवी (Parasite) है।
            भगवान ऐसे स्वार्थी इंसान को 'अघायुः' (जिसका पूरा जीवन ही एक पाप है) कहते हैं। क्योंकि वह दूसरों की मेहनत से जी रहा है, लेकिन खुद कुछ योगदान (Contribute) नहीं कर रहा।
            वह केवल 'इन्द्रियारामः' (अपनी इन्द्रियों को सुख देने में ही पागल) है।
            श्रीकृष्ण का अंतिम फैसला (Verdict) बहुत डरावना है: "मोघं पार्थ स जीवति"—ऐसे स्वार्थी और कामचोर इंसान का इस धरती पर पैदा होना और जीना 100% व्यर्थ, अर्थहीन और एक बोझ है।
            अर्जुन का युद्ध से भागने का विचार उन्हें इसी पापी और व्यर्थ जीवन की श्रेणी में खड़ा कर देगा, जो कि भगवान कभी नहीं चाहते।
        """.trimIndent(),
        english = """
            O Partha! My dear Arjuna, one who absolutely does not follow in human life the cosmic cycle of sacrifice (Chakram) thus established by the Lord...
            such a person, whose life is completely full of sin (Aghayur) and who lives only for the satisfaction of his senses (Indriyaramo), lives his life entirely in vain (Mogham).
            Lord Sri Krishna is delivering His absolute harshest condemnation and supreme judgment here upon those people who cowardly run away from their prescribed duties.
            In verses 14 and 15, He established a flawless ecological and spiritual 'Cycle' (Action -> Sacrifice -> Rain -> Food -> Life), which is the absolute Universal System designed by God.
            A human being who arrogantly thinks, "I will not do any hard work, I will contribute nothing to society, I will just sit lazily, eat free food, and enjoy life," acts exactly like a toxic Virus or a Parasite in this cosmic cycle.
            The Lord brands such a highly selfish person as 'Aghayuh' (one whose very lifespan is a continuous sin). Because he is shamelessly surviving on the hard labor of others, nature, and God, without contributing a single drop back.
            He is merely 'Indriyaramo' (madly obsessed only with gratifying his own physical senses like an animal).
            Sri Krishna's final, terrifying verdict is: "Mogham Partha sa jivati"—the birth and existence of such a selfish, lazy freeloader on this earth is 100% useless, meaningless, and a massive burden on the planet.
            Arjuna's weak desire to flee the war would instantly dump him into this exact category of a sinful, worthless life, which the Lord absolutely cannot allow.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            यस्त्वात्मरतिरेव स्यादात्मतृप्तश्च मानवः |
            आत्मन्येव च सन्तुष्टस्तस्य कार्यं न विद्यते || १७ ||
        """.trimIndent(),
        hindi = """
            परंतु जो मनुष्य केवल अपनी आत्मा में ही प्रेम करने वाला (आत्मरतिः) है, अपनी आत्मा में ही पूरी तरह तृप्त (आनंदित) है...
            और जो केवल अपनी आत्मा में ही पूरी तरह संतुष्ट (सन्तुष्टः) रहता है, उस महापुरुष के लिए संसार में कोई भी 'कर्तव्य' (करने योग्य कार्य) बाकी नहीं रहता।
            पिछले श्लोक में भगवान ने कामचोरों को डांटा था, लेकिन इस श्लोक में वे उस एकमात्र व्यक्ति का वर्णन कर रहे हैं जिसे दुनिया में काम करने की कोई मजबूरी (Compulsion) नहीं है।
            यह कोई साधारण इंसान नहीं है; यह वह सर्वोच्च 'आत्मज्ञानी' (Self-realized soul) है जो 'आत्मरतिः' हो चुका है।
            साधारण इंसान टीवी, पैसा, या परिवार में 'रति' (Enjoyment) ढूँढता है; और जब भूख लगती है तो खाने से 'तृप्त' (Satisfied) होता है।
            लेकिन ज्ञानी महापुरुष की सारी खुशी, सारा मज़ा, और सारी संतुष्टि केवल और केवल अपने भीतर बैठे भगवान (आत्मा) से ही पूरी हो जाती है।
            उसे अपनी खुशी या शांति के लिए बाहर की दुनिया से रत्ती भर भी कुछ नहीं चाहिए होता।
            चूँकि उसे दुनिया से कुछ पाना ही नहीं है, इसलिए दुनिया में उसके लिए कोई 'ड्यूटी' (कार्यं) या मजबूरी भी नहीं बचती। वह वेदों के सारे नियमों और सामाजिक बंधनों से पूरी तरह आज़ाद (Liberated) हो चुका है।
            लेकिन भगवान अर्जुन को यह भी याद दिला रहे हैं कि अर्जुन अभी उस सर्वोच्च स्थिति में नहीं पहुंचे हैं; अर्जुन का मन अभी भी परिवार और शोक में फँसा है, इसलिए उनके लिए कर्म करना अनिवार्य है।
        """.trimIndent(),
        english = """
            But for that highly elevated person who takes sheer pleasure entirely in the self (Atma-ratih), whose human life is one of self-realization, and who is fully satisfied only in the self (Atma-triptas)...
            who is fully satiated purely within his own soul (Santushtah)—for him, there is absolutely no prescribed duty (Karyam na vidyate) left to fulfill.
            In the previous verse, the Lord aggressively blasted lazy escapists, but in this specific verse, He defines the absolute only category of human being who has zero compulsion to perform worldly duties.
            This is no ordinary mortal; this is the ultimate, supreme 'Self-realized master' who has achieved 'Atma-ratih'.
            An ignorant, ordinary man desperately searches for 'Rati' (pleasure/entertainment) in TV, money, or family; and seeks 'Tripti' (satisfaction) by stuffing his belly with food.
            But the enlightened grandmaster derives absolutely all his ecstatic joy, thrill, and 100% supreme satisfaction entirely from the Supreme Soul (God) residing within his own heart.
            He does not need to beg for even a microscopic drop of happiness or peace from the external material world.
            Because he literally requires absolutely nothing from the world, there remains zero 'Duty' (Karyam) or compulsion for him to act in the world. He is completely, permanently liberated from all Vedic rules and social obligations.
            However, the Lord is subtly reminding Arjuna: You have absolutely not reached this exalted state yet; your mind is still violently trapped in grief and family attachment, hence performing your duty (war) is strictly mandatory for you.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            नैव तस्य कृतेनार्थो नाकृतेनेह कश्चन |
            न चास्य सर्वभूतेषु कश्चिदर्थव्यपाश्रयः || १८ ||
        """.trimIndent(),
        hindi = """
            उस आत्मज्ञानी महापुरुष का इस संसार में कोई काम करने (कृतेन) से कोई स्वार्थ या प्रयोजन (अर्थ) सिद्ध नहीं होता, और न ही कोई काम न करने (अकृतेन) से उसका कोई नुकसान होता है।
            और संपूर्ण प्राणियों में (ब्रह्मा से लेकर चींटी तक) किसी भी प्राणी के साथ उसका कोई भी स्वार्थ का संबंध (अर्थव्यपाश्रयः) नहीं रहता।
            यह श्लोक आत्मज्ञानी (Enlightened person) की असीम स्वतंत्रता (Absolute Freedom) को दर्शाता है।
            हम साधारण लोग दुनिया में कोई भी काम क्यों करते हैं? या तो कुछ पाने के लिए (जैसे नौकरी करते हैं ताकि पैसा मिले), या कुछ खोने के डर से (जैसे टैक्स भरते हैं ताकि जेल न जाना पड़े)।
            यानी हम हर काम एक 'स्वार्थ' या 'मजबूरी' के तहत करते हैं।
            लेकिन जो व्यक्ति ईश्वर को पा चुका है, उसका कोई पर्सनल एजेंडा (Personal Agenda) नहीं बचता। अगर वह कोई महान काम करता है, तो उसे उससे कोई मेडल (Medal) या पुण्य नहीं चाहिए।
            और अगर वह शांति से हिमालय में बैठ जाए (कुछ न करे), तो उसे पाप लगने या समाज से बेइज्जत होने का कोई डर नहीं होता। वह पाप और पुण्य के गणित से पूरी तरह बाहर हो चुका है।
            सबसे बड़ी बात, उसे इस ब्रह्मांड के किसी भी इंसान, देवता, या प्रधानमंत्री से कोई काम नहीं निकलवाना होता। उसका 'स्वार्थ' शून्य (Zero) हो चुका है।
            यह स्थिति तब आती है जब इंसान खुद को शरीर मानना पूरी तरह छोड़ देता है।
        """.trimIndent(),
        english = """
            A completely self-realized man has absolutely no purpose to fulfill in the discharge of his prescribed duties (Kritena), nor has he any reason or fear not to perform such work (Akritena).
            Nor does he have the slightest need to depend on any other living being in the entire universe (from Brahma down to an ant) for any personal motive whatsoever (Artha-vyapashrayah).
            This phenomenal verse showcases the infinite, staggering 'Absolute Freedom' of a perfectly self-realized, enlightened master.
            Why do we ordinary mortals perform any action in this world? Either to gain something (like doing a job to acquire a heavy paycheck), or out of the terror of losing something (like paying taxes to avoid rotting in jail).
            Meaning, every single action we perform is driven by a 'selfish motive' or intense 'compulsion'.
            But a person who has attained God-realization has absolutely zero personal agenda left. If he executes a massive, world-changing task, he wants absolutely zero medals, fame, or pious merit from it.
            And if he simply retreats to the Himalayas and sits silently (does nothing), he has zero fear of incurring sin or facing social backlash. He has completely exited the pathetic mathematics of sin and merit.
            Most importantly, he does not need to extract a single favor from any human, politician, or celestial demigod in the entire cosmos. His 'selfishness' has hit absolute Zero.
            This godlike state is only achieved when a human being completely and permanently stops identifying himself with the temporary physical body.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            तस्मादसक्तः सततं कार्यं कर्म समाचर |
            असक्तो ह्याचरन्कर्म परमाप्नोति पूरुषः || १९ ||
        """.trimIndent(),
        hindi = """
            इसलिए, तुम हमेशा (सततम्) फल की आसक्ति से पूरी तरह मुक्त होकर (असक्तः) अपना जो भी करने योग्य कर्तव्य-कर्म (कार्यं कर्म) है, उसे भली-भांति (समाचर) करते रहो।
            क्योंकि जो मनुष्य बिना किसी आसक्ति (स्वार्थ) के निरंतर कर्म करता है, वह निश्चित रूप से परमेश्वर (परम्) को प्राप्त कर लेता है।
            पिछले दो श्लोकों में आत्मज्ञानी की स्थिति बताने के बाद, भगवान अब एक झटके में वापस अर्जुन पर आते हैं और उन्हें 'एक्शन' (Action) का सीधा आदेश देते हैं।
            श्रीकृष्ण का संदेश बिल्कुल साफ है: "हे अर्जुन! तुम अभी उस आत्मज्ञानी की स्थिति में नहीं हो जहाँ तुम्हें कुछ न करना पड़े। तुम्हारा मन अभी अशुद्ध है।"
            मन को शुद्ध करने की मशीन का नाम ही 'कर्मयोग' है।
            भगवान अर्जुन को आज्ञा देते हैं कि तुम अपने क्षत्रिय धर्म (युद्ध) को पूरी ईमानदारी से ('समाचर') करो, लेकिन उसमें अपनी जीत, हार, या राज्य की आसक्ति (Attachment / असक्तः) मत रखो।
            दुनिया को लगता है कि भगवान को पाने के लिए काम छोड़कर हिमालय जाना पड़ता है। लेकिन कृष्ण यहाँ दुनिया का सबसे बड़ा रहस्य खोलते हैं:
            तुम इसी दुनिया में रहो, अपने ऑफिस जाओ, अपने परिवार की रक्षा करो और युद्ध लड़ो—बस उस काम को अपने स्वार्थ के लिए नहीं, बल्कि 'ईश्वर की सेवा' समझकर करो।
            यही 'असक्त कर्म' (Detached Action) तुम्हें सबसे तेज गति (Expressway) से परमेश्वर (परम्) तक पहुँचा देगा।
        """.trimIndent(),
        english = """
            Therefore, without being attached to the fruits of activities (Asaktah), you should continuously and constantly (Satatam) perform your prescribed duty as a matter of obligation (Karyam karma samachara).
            For by executing work entirely without any selfish attachment, a human being undoubtedly attains the Supreme Personality of Godhead (Param).
            After describing the exalted state of a liberated sage in the previous two verses, the Lord swiftly snaps back to Arjuna and issues a direct, commanding order for 'Action'.
            Sri Krishna's message is brutally clear: "O Arjuna! You are absolutely not at that exalted level of self-realization where you can abandon your duties. Your mind is still highly impure and attached."
            The ultimate washing machine designed specifically to purify a contaminated mind is called 'Karma Yoga'.
            The Lord commands Arjuna to fight this brutal war (his prescribed duty) with extreme intensity and flawlessness ('Samachara'), but totally strip it of any toxic attachment ('Asaktah') to victory, defeat, or the royal throne.
            The ignorant world assumes that to attain God, one must abandon all work and escape to the freezing Himalayas. But Krishna drops the universe's biggest secret here:
            Stay right here in the material world, go to your corporate office, fiercely protect your family, and fight massive wars—simply do not do it for your own bloated ego, do it purely as a 'Service to God'.
            This exact 'Detached Action' (Asakta Karma) acts as a high-speed spiritual expressway that will flawlessly and undoubtedly transport a human being directly to the Supreme Lord (Param).
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            कर्मणैव हि संसिद्धिमास्थिता जनकादयः |
            लोकसङ्ग्रहमेवापि सम्पश्यन्कर्तुमर्हसि || २० ||
        """.trimIndent(),
        hindi = """
            प्राचीन काल में राजा जनक और उनके जैसे अन्य अनेक ज्ञानी महापुरुषों ने केवल 'कर्म' (निष्काम कर्म) के द्वारा ही परम सिद्धि (मोक्ष) को प्राप्त किया था।
            इसलिए, (यदि तुम्हें अपने लिए कुछ नहीं भी चाहिए, तो भी) समाज को सही दिशा दिखाने (लोकसंग्रह) के उद्देश्य को देखते हुए ही तुम्हारा कर्म (युद्ध) करना उचित है।
            जब हम कोई बहुत बड़ा सिद्धांत (Theory) सुनते हैं, तो मन में सवाल आता है, "क्या किसी ने सच में ऐसा किया है? क्या इसका कोई असली उदाहरण है?"
            अर्जुन के मन में भी यही संशय हो सकता था कि क्या सच में दुनिया के बीच रहकर, राज-काज संभालते हुए मोक्ष मिल सकता है?
            भगवान तुरंत भारत के इतिहास का सबसे महान उदाहरण देते हैं: 'राजा जनक' (माता सीता के पिता)।
            राजा जनक एक बहुत बड़े साम्राज्य को चलाते थे, महल में रहते थे, और राजनीति करते थे, फिर भी वे 'विदेह' (शरीर के मोह से पूरी तरह मुक्त) कहलाते थे। उन्होंने हिमालय जाकर नहीं, बल्कि राज्य चलाते हुए ही 'परम सिद्धि' (Enlightenment) प्राप्त की थी।
            फिर भगवान एक बहुत बड़ा 'लीडरशिप लेसन' (Leadership Lesson) देते हैं: 'लोकसंग्रह' (समाज का कल्याण और मार्गदर्शन)।
            श्रीकृष्ण अर्जुन से कहते हैं कि तुम समाज के हीरो (Hero) और आइडल (Idol) हो। अगर तुम (ज्ञानी होकर भी) काम से भाग जाओगे, तो आम जनता भी तुम्हें देखकर अपना कर्तव्य छोड़ देगी और पूरा समाज नष्ट हो जाएगा।
            इसलिए, अगर तुम्हें अपने लिए राज्य नहीं भी चाहिए, तो भी समाज के सामने एक अच्छा उदाहरण (Role Model) सेट करने के लिए तुम्हें अपना काम (युद्ध) 100% करना ही होगा।
        """.trimIndent(),
        english = """
            Kings such as the great Janaka and others attained supreme perfection and ultimate liberation (Samsiddhim) solely by the flawless performance of prescribed duties (Karmanaiva).
            Therefore, even if you desire absolutely nothing for yourself, just for the sake of educating and setting a noble example for the people in general (Loka-sangraham), you must perform your work.
            Whenever we hear a massive, revolutionary philosophical theory, the human mind naturally asks, "Has anyone actually ever done this? Is there a real-world case study?"
            Arjuna might have harbored the exact same paralyzing doubt: Is it actually, practically possible to achieve ultimate liberation while running a chaotic, political kingdom?
            The Lord instantly provides the absolute greatest historical case study of India: 'King Janaka' (the father of Mother Sita).
            King Janaka actively ruled a massive, wealthy empire, lived in an opulent palace, and executed heavy political affairs, yet he was universally famous as 'Videha' (completely completely detached from the physical body). He attained 'Supreme Perfection' (Enlightenment) not by hiding in a cave, but by ruling his kingdom selflessly.
            Then, the Lord delivers an incredibly profound 'Leadership Lesson': 'Loka-sangraham' (Welfare and Guidance of society).
            Sri Krishna tells Arjuna: You are a massive Hero and a mega-Idol for the entire society. If you violently drop your weapons and run away from duty, the ordinary, ignorant masses will blindly copy your cowardice, and the entire social fabric will collapse into chaos.
            Therefore, even if you are entirely detached and want absolutely zero kingdoms for yourself, simply to set a powerful, righteous example (Role Model) for humanity, you are strictly obligated to execute your duty (fight the war) flawlessly.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            यद्यदाचरति श्रेष्ठस्तत्तदेवेतरो जनः |
            स यत्प्रमाणं कुरुते लोकस्तदनुवर्तते || २१ ||
        """.trimIndent(),
        hindi = """
            श्रेष्ठ (महान और सम्मानित) पुरुष जो-जो आचरण (काम) करता है, सामान्य लोग भी बिल्कुल वैसा ही आचरण करने लगते हैं।
            वह श्रेष्ठ पुरुष जो कुछ भी प्रमाण (Standard/Example) तय कर देता है, पूरी दुनिया उसी का अनुसरण (Follow) करने लगती है।
            यह श्लोक 'लीडरशिप' (Leadership) और सामाजिक जिम्मेदारी का दुनिया का सबसे महान और सर्वकालिक (Timeless) सिद्धांत है।
            भगवान श्रीकृष्ण अर्जुन को समझा रहे हैं कि तुम कोई साधारण सैनिक नहीं हो; तुम इस युग के सबसे बड़े 'यूथ आइकन' (Youth Icon) और श्रेष्ठ क्षत्रिय हो।
            समाज कभी भी शास्त्रों को पढ़कर नहीं सीखता; समाज हमेशा अपने 'हीरोज़' (Heroes) और नेताओं को देखकर सीखता है।
            यदि तुम (एक श्रेष्ठ पुरुष होकर) युद्धभूमि में कायरों की तरह अपने हथियार डाल दोगे और कर्तव्य से भागोगे, तो कल को आम आदमी भी हर छोटी-बड़ी मुश्किल में अपने कर्तव्य से भागने लगेगा।
            लोग कहेंगे, "जब महान अर्जुन ने ही युद्ध नहीं किया, तो हम अपना संघर्ष क्यों करें?"
            इसलिए, एक श्रेष्ठ व्यक्ति का जीवन उसका अपना व्यक्तिगत (Private) जीवन नहीं रह जाता; उसके हर छोटे-बड़े कदम का सीधा असर लाखों लोगों की मानसिकता पर पड़ता है।
            तुम्हें केवल अपने लिए नहीं, बल्कि आने वाली पीढ़ियों के लिए एक 'प्रमाण' (Perfect Standard) सेट करने के लिए यह धर्म-युद्ध लड़ना ही होगा।
        """.trimIndent(),
        english = """
            Whatever action a great, highly respected man performs, common men blindly follow in his exact footsteps.
            And whatever supreme standards or examples he sets by his exemplary acts, all the entire world relentlessly pursues.
            This verse is universally regarded as the absolute greatest, timeless master-principle of 'Leadership' and heavy social responsibility in human history.
            Lord Sri Krishna is profoundly reminding Arjuna: You are not some ordinary foot soldier; you are the absolute greatest 'Youth Icon', the ultimate Hero, and the supreme Kshatriya of this era.
            The massive, ignorant society absolutely never learns by intellectually reading complex scriptures; the masses learn purely by blindly imitating the actions of their 'Heroes' and leaders.
            If you (being the ultimate role model) drop your weapons like a pathetic coward and run away from your duty, tomorrow the common man will also start abandoning his duties at the slightest hint of hardship.
            The masses will foolishly justify their laziness by saying, "When the great, invincible Arjuna himself ran away, why should we fight our struggles?"
            Therefore, the life of a great leader is absolutely never his own 'Private' property anymore; every single step he takes creates a massive ripple effect on the psychology of millions.
            You must fight this righteous war not for your own selfish gains, but strictly to establish a flawless 'Pramana' (Gold Standard) of absolute duty for all future generations to follow.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            न मे पार्थास्ति कर्तव्यं त्रिषु लोकेषु किञ्चन |
            नानवाप्तमवाप्तव्यं वर्त एव च कर्मणि || २२ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! इन तीनों लोकों (स्वर्ग, पृथ्वी, और पाताल) में मेरे लिए कोई भी कर्तव्य (करने योग्य काम) शेष नहीं है।
            और न ही कोई ऐसी वस्तु है जो मुझे प्राप्त न हो और जिसे मुझे प्राप्त करना हो; फिर भी, मैं लगातार कर्मों (कार्यों) में ही लगा रहता हूँ।
            अर्जुन को 'लीडरशिप' का महत्व समझाने के लिए, भगवान श्रीकृष्ण अब ब्रह्मांड का सबसे बड़ा उदाहरण दे रहे हैं—स्वयं अपना!
            वे कहते हैं कि मैं इस पूरे ब्रह्मांड का परमेश्वर (Supreme Boss) हूँ। इस दुनिया में ऐसा कोई भी नियम या बॉस नहीं है जो मुझे काम करने का 'ऑर्डर' (Order) दे सके।
            इंसान काम क्यों करता है? कुछ पाने के लिए! लेकिन श्रीकृष्ण कहते हैं कि ऐसी कोई दौलत, शक्ति या सुख नहीं है जो मेरे पास न हो ('नानवाप्तमवाप्तव्यं')।
            मुझे इस दुनिया से 0% फायदा चाहिए। मेरी कोई मजबूरी नहीं है। फिर भी, मैं दिन-रात सृष्टि को चलाने का, अवतार लेने का, और (यहाँ तक कि अर्जुन के रथ का सारथी बनने का) कर्म लगातार कर रहा हूँ।
            जब साक्षात् ईश्वर, जिन्हें कुछ नहीं चाहिए, वे भी 24 घंटे कर्मों में लगे रहते हैं, तो फिर अर्जुन जैसे साधारण इंसान को कर्म छोड़ने (संन्यास लेने) का क्या अधिकार है?
            यह श्लोक 'परफेक्ट निस्वार्थ कर्म' (Perfect Selfless Action) का सबसे महान उदाहरण प्रस्तुत करता है।
        """.trimIndent(),
        english = """
            O son of Pritha (Arjuna), there is absolutely no prescribed duty for Me to perform within all the three planetary systems (heaven, earth, and the lower worlds).
            Nor is there anything whatsoever lacking in Me, nor is there anything for Me to obtain; and yet, I am continuously and intensely engaged in performing prescribed duties (Karma).
            To flawlessly illustrate the massive importance of 'Leadership', Lord Sri Krishna now presents the absolute greatest case study in the entire universe—Himself!
            He declares that He is the Supreme Personality of Godhead, the absolute 'Ultimate Boss' of existence. There is absolutely no higher law, scripture, or authority that can 'Order' Him to work.
            Why does a human being work? Simply to acquire something he lacks! But Sri Krishna asserts that there is zero wealth, absolute zero power, and zero happiness that He does not already possess ('nanavaptam avaptavyam').
            He requires exactly 0% benefit from this material world. He has zero compulsions. Yet, He works tirelessly 24/7 maintaining the cosmos, descending as avatars, and (currently) performing the menial physical labor of driving Arjuna's chariot.
            When the Supreme Creator Himself, who requires absolutely nothing, constantly engages in intense, heavy action, what possible right does a tiny mortal like Arjuna have to abandon his duties and claim fake renunciation?
            This spectacular verse stands as the ultimate, crowning example of 'Perfect Selfless Action' (Nishkama Karma) in the cosmos.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            यदि ह्यहं न वर्तेयं जातु कर्मण्यतन्द्रितः |
            मम वर्त्मानुवर्तन्ते मनुष्याः पार्थ सर्वशः || २३ ||
        """.trimIndent(),
        hindi = """
            क्योंकि हे पार्थ! यदि मैं कभी भी सावधान (अतन्द्रितः) होकर लगातार कर्मों में न लगूँ (यानी काम करना छोड़ दूँ)...
            तो यह बहुत बड़ा अनर्थ हो जाएगा, क्योंकि सभी मनुष्य सब प्रकार से केवल मेरे ही मार्ग का अनुसरण (नकल) करते हैं।
            श्रीकृष्ण बता रहे हैं कि यदि वे काम करना बंद कर दें तो समाज पर इसका क्या भयंकर मनोवैज्ञानिक (Psychological) असर पड़ेगा।
            भगवान इस दुनिया के सबसे बड़े 'रोल मॉडल' (Role Model) हैं। अगर वे अवतार लेकर केवल आराम करें या अपने कर्तव्यों से भागें, तो दुनिया के सारे लोग कहेंगे कि "जब भगवान ही कुछ नहीं करते, तो हमें मेहनत करने की क्या जरूरत है?"
            पूरी मानव जाति आलस्य, प्रमाद और अकर्मण्यता (Inaction) के भयंकर गड्ढे में गिर जाएगी।
            लोग कामचोरी को ही 'धर्म' मान लेंगे और पूरे समाज का ढांचा (System) कुछ ही दिनों में क्रैश (Crash) हो जाएगा।
            'अतन्द्रितः' का अर्थ है बिना किसी आलस्य या थकान के पूरी तरह अलर्ट (Alert) होकर काम करना। भगवान बिना थके सृष्टि को चलाते हैं।
            यह श्लोक इस बात का प्रमाण है कि जो इंसान समाज में जितनी ऊँची पोस्ट (Post) पर होता है, उसे उतनी ही ज्यादा सावधानी और मेहनत से काम करना पड़ता है, क्योंकि लाखों आँखें उसे देखकर सीख रही होती हैं।
        """.trimIndent(),
        english = """
            For if I ever failed to engage Myself continuously in the careful and vigilant execution of prescribed duties (Atandritah)...
            O Partha, certainly all men would immediately and blindly follow My path of inaction in every single respect.
            Sri Krishna is explicitly explaining the catastrophic, terrifying psychological impact it would have on human society if He ever decided to stop performing His actions.
            The Supreme Lord is undeniably the absolute biggest 'Role Model' in existence. If He descends as an Avatar and simply relaxes, sleeps, or abandons His cosmic duties, the entire world will instantly adopt that toxic mindset.
            They will lazily argue, "When God Himself does absolutely no hard work, why should we exhaust ourselves performing difficult duties?"
            The entire human race would rapidly violently collapse into a massive, dark pit of total laziness, lethargy, and extreme 'Inaction' (Akarma).
            People would start worshipping 'laziness' as the highest 'dharma', and the entire socio-economic and moral framework of human civilization would crash in days.
            'Atandritah' means working with supreme, hyper-alert vigilance without a microscopic drop of laziness. The Lord maintains the universe tirelessly.
            This verse proves the ultimate rule: The higher a human being climbs on the ladder of social leadership, the more violently hard and flawlessly he must work, because millions of ignorant eyes are actively copying his every move.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            उत्सीदेयुरिमे लोका न कुर्यां कर्म चेदहम् |
            सङ्करस्य च कर्ता स्यामुपहन्यामिमाः प्रजाः || २४ ||
        """.trimIndent(),
        hindi = """
            यदि मैं कर्म न करूँ, तो ये सभी लोक (संसार) पूरी तरह से भ्रष्ट होकर नष्ट हो जाएंगे (उत्सीदेयुः)।
            और तब मैं अवांछित संतानों (वर्णसंकर) को पैदा करने का कारण बनूँगा, और इस प्रकार मैं ही इस संपूर्ण प्रजा (मानव जाति) को नष्ट करने वाला (उपहन्याम्) कहलाऊँगा।
            यहाँ श्रीकृष्ण काम न करने (आलस्य) के उस अंतिम और सबसे भयानक परिणाम (Extreme Consequence) को बता रहे हैं, जो सीधे समाज के पतन की ओर ले जाता है।
            वे कहते हैं कि अगर मैं कर्म न करूँ, तो समाज में नियम, अनुशासन और धर्म (Order and Law) पूरी तरह खत्म हो जाएंगे।
            अनुशासन के बिना, समाज में 'वर्णसंकर' पैदा होंगे। 'वर्णसंकर' का मतलब केवल जाति-पांति का मिश्रण नहीं है; इसका मतलब है ऐसे बच्चे और ऐसी पीढ़ियां पैदा होना जिनमें कोई संस्कार, कोई नैतिकता (Morals) और कोई दिशा (Direction) न हो।
            जब समाज में ऐसी दिशाहीन और अनुशासनहीन भीड़ (Mob) बढ़ जाती है, तो वह पूरे समाज (प्रजा) को अंदर से खाकर नष्ट कर देती है।
            श्रीकृष्ण कहते हैं कि यदि समाज का यह पतन हुआ, तो उसका 'कर्ता' (जिम्मेदार/दोषी) मैं ही कहलाऊँगा, क्योंकि मैंने लीडर होकर सही उदाहरण सेट नहीं किया।
            अर्जुन पहले अध्याय (श्लोक 1.41) में कह रहे थे कि "युद्ध करने से वर्णसंकर पैदा होंगे।" भगवान यहाँ उसका बिल्कुल उल्टा और सत्य जवाब दे रहे हैं: "युद्ध न करने (कर्तव्य से भागने) से वर्णसंकर पैदा होंगे और समाज नष्ट होगा।"
        """.trimIndent(),
        english = """
            If I did not faithfully perform My prescribed duties, all these worlds would be utterly put to ruin and destroyed (Utsideyuh).
            I would then become the direct creator of unwanted, uncultured population (Varna-sankara), and I would thereby be responsible for the total destruction of the peace of all living beings (Upahanyam).
            Here, Sri Krishna vividly reveals the absolute final, most terrifying and catastrophic 'Extreme Consequence' of inaction (laziness), which directly triggers the collapse of human civilization.
            He declares that if He stops working, all rules, sacred disciplines, and supreme laws of order (Dharma) in society will entirely evaporate into thin air.
            Without strict discipline and powerful role models, society breeds 'Varna-sankara'. 'Varna-sankara' absolutely does not just mean mixed marriages; it deeply refers to producing entire generations of chaotic, unwanted offspring possessing zero moral compass, zero ethics, and zero cultural values.
            When such an explosive, directionless, and highly toxic mob multiplies, it brutally eats society from the inside out, causing absolute destruction.
            Sri Krishna states that if such a catastrophic social collapse occurs, He Himself would be held 100% guilty and responsible ('Karta') as the primary creator of that chaos, simply because He failed to set the right example as a leader.
            In Chapter 1 (Verse 1.41), Arjuna foolishly argued: "Fighting this war will create Varna-sankara." The Lord drops the ultimate, brutally true counter-argument here: "No, running away from your duty (inaction) is exactly what will create Varna-sankara and annihilate society."
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            सक्ताः कर्मण्यविद्वांसो यथा कुर्वन्ति भारत |
            कुर्याद्विद्वांस्तथासक्तश्चिकीर्षुर्लोकसङ्ग्रहम् || २५ ||
        """.trimIndent(),
        hindi = """
            हे भरतवंशी अर्जुन! जिस प्रकार अज्ञानी (अविद्वांसो) लोग अपने कर्म के फलों में अत्यंत आसक्त (सक्ताः / लालची) होकर पूरी मेहनत से काम करते हैं...
            ठीक उसी प्रकार, ज्ञानी (विद्वान) महापुरुष को भी बिना किसी आसक्ति (असक्तः) के, केवल संसार के कल्याण और मार्गदर्शन (लोकसंग्रहम्) की इच्छा से पूरी मेहनत के साथ काम करना चाहिए।
            यह श्लोक 'ज्ञानी' (Enlightened) और 'अज्ञानी' (Ignorant) इंसान के काम करने के तरीके का सबसे बेहतरीन तुलनात्मक (Comparative) विश्लेषण है।
            बाहर से देखने पर एक अज्ञानी (स्वार्थी) इंसान और एक ज्ञानी (कर्मयोगी) इंसान के काम में कोई अंतर नहीं दिखता; दोनों दिन-रात पागलों की तरह मेहनत करते हैं।
            लेकिन उनके 'उद्देश्य' (Intentions) में ज़मीन-आसमान का फर्क होता है।
            एक साधारण आदमी (अविद्वान) इसलिए खून-पसीना एक करता है क्योंकि वह पैसे, प्रमोशन, या शोहरत का भूखा (सक्तः) होता है।
            इसके बिल्कुल विपरीत, एक 'विद्वान' योगी भी उतनी ही (या उससे भी ज्यादा) मेहनत से काम करता है, लेकिन उसे अपने लिए एक रुपया या एक नाम नहीं चाहिए होता ('असक्तः')।
            वह इतनी मेहनत केवल 'लोकसंग्रह' (Loka-sangraha) के लिए करता है—यानी समाज को सही रास्ता दिखाने, गरीबों का पेट भरने, और धर्म की स्थापना करने के लिए।
            भगवान अर्जुन से कह रहे हैं कि तुम्हें युद्ध लड़ना है, और उसी एनर्जी (Energy) के साथ लड़ना है जैसे दुर्योधन लड़ रहा है। बस दुर्योधन राज्य के लालच में लड़ रहा है, और तुम्हें समाज के कल्याण के लिए अनासक्त होकर लड़ना है।
        """.trimIndent(),
        english = """
            O descendant of Bharata! As the ignorant (Avidvamso) perform their duties with extreme, blind attachment to the material results (Saktah)...
            in the exact same manner, the learned and wise (Vidvan) may also act with the exact same intensity, but entirely without attachment (Asaktah), for the sole purpose of leading people on the right path (Loka-sangraham).
            This specific verse provides the absolute greatest, most brilliant comparative psychological analysis between an 'Ignorant materialist' and an 'Enlightened Karma Yogi'.
            From an external, superficial viewpoint, there is absolutely zero difference between how a greedy man works and how a self-realized sage works; both of them hustle and grind day and night with explosive energy.
            But the massive, infinite difference lies entirely in their hidden 'Intentions' (Motives).
            An ordinary, ignorant man intensely sweats blood solely because he is desperately hungry and violently attached ('Saktah') to acquiring money, promotions, or social clout.
            In strict, beautiful contrast, a truly 'Vidvan' (Enlightened master) works with the exact same (or even greater) ferocious intensity, but he desires absolutely zero money, fame, or reward for his own ego ('Asaktah').
            He burns his energy entirely for 'Loka-sangraha'—meaning purely for the ultimate welfare of the world, to feed the starving, establish justice, and set a flawless example for humanity to follow.
            The Lord is commanding Arjuna: You must fight this war with the exact same ferocious, blood-boiling intensity as Duryodhana. The only difference is, Duryodhana fights out of toxic greed, while you must fight out of supreme, detached compassion for world welfare.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            न बुद्धिभेदं जनयेदज्ञानां कर्मसङ्गिनाम् |
            जोषयेत्सर्वकर्माणि विद्वान्युक्तः समाचरन् || २६ ||
        """.trimIndent(),
        hindi = """
            ज्ञानी महापुरुष को चाहिए कि वह सकाम कर्मों (फल की इच्छा वाले कर्मों) में फँसे हुए अज्ञानी लोगों की बुद्धि में कोई भ्रम (बुद्धिभेद) पैदा न करे।
            बल्कि वह स्वयं योग (परमात्मा) में स्थित होकर भली-भांति सारे कर्मों को करे, और उन अज्ञानियों से भी खुशी-खुशी सारे कर्म करवाए (जोषयेत्)।
            यह श्लोक आध्यात्मिक मनोविज्ञान (Spiritual Psychology) और समाजशास्त्र का एक बहुत बड़ा नियम (Rule) बताता है।
            अक्सर जब किसी व्यक्ति को थोड़ा सा आध्यात्मिक ज्ञान मिल जाता है, तो वह आम संसारी लोगों के पास जाकर उनके कामों की बुराई करने लगता है।
            वह कहता है, "तुम पैसे के पीछे क्यों भाग रहे हो? यह सब मोह-माया है, नौकरी छोड़ो और भगवान का भजन करो।"
            श्रीकृष्ण इस हरकत को 'बुद्धिभेद' (दिमाग में कंफ्यूजन पैदा करना) कहते हैं, और ऐसा करने से सख्त मना करते हैं।
            भगवान कहते हैं कि जो आम आदमी अभी कर्मों के फलों (पैसे, परिवार) में फँसा है, उसका आध्यात्मिक स्तर (Level) अभी बहुत नीचे है। अगर तुम उसे अचानक सब कुछ छोड़ने को कहोगे, तो वह न तो संन्यासी बन पाएगा और न ही अपना काम ठीक से कर पाएगा; वह पूरी तरह बर्बाद हो जाएगा।
            इसलिए एक सच्चे ज्ञानी (विद्वान) की जिम्मेदारी यह है कि वह आम लोगों का काम छुड़वाने के बजाय, खुद उनके सामने बहुत ही शानदार तरीके से अपना काम (निष्काम भाव से) करके दिखाए।
            जब लोग ज्ञानी को इतने अच्छे तरीके से और बिना किसी टेंशन के काम करते देखेंगे, तो वे खुद-ब-खुद (बिना काम छोड़े) कर्मयोग सीख जाएंगे।
        """.trimIndent(),
        english = """
            Let not the wise man disrupt the minds or create devastating confusion (Buddhi-bhedam) in the intelligence of the ignorant who are heavily attached to fruitive actions (Karma-sanginam).
            Instead, by performing his own duties beautifully in a state of deep yogic devotion, the enlightened man should encourage them to engage in all sorts of activities joyfully (Joshayet).
            This verse lays down an absolutely monumental, golden rule of 'Spiritual Psychology' and elite social engineering.
            Very often, when a novice receives a tiny drop of spiritual enlightenment, he immediately runs to ordinary, hard-working materialists and aggressively criticizes their lifestyle.
            He arrogantly preaches, "Why are you endlessly chasing money? This entire world is a fake illusion (Maya); quit your corporate job immediately and chant God's name!"
            Sri Krishna explicitly labels this highly toxic behavior as 'Buddhi-bheda' (violently disrupting and confusing someone's mind) and strictly forbids it.
            The Lord explains that an ordinary man heavily addicted to the fruits of his labor (money, family) is currently operating at a very primitive spiritual frequency. If you forcefully rip him away from his attachments, he will neither become a true monk nor remain a good worker; he will simply crash into absolute ruin.
            Therefore, the supreme responsibility of a true 'Vidvan' (Enlightened master) is absolutely not to force people to abandon their jobs. Instead, he must flawlessly perform his own massive duties right in front of them with supreme, unshakeable detachment.
            When the ignorant masses witness a master executing highly complex work with absolutely zero stress and pure joy, they will automatically be inspired to upgrade their own consciousness without ever abandoning their duties.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            प्रकृतेः क्रियमाणानि गुणैः कर्माणि सर्वशः |
            अहङ्कारविमूढात्मा कर्ताहमिति मन्यते || २७ ||
        """.trimIndent(),
        hindi = """
            वास्तव में संसार के संपूर्ण कर्म (सभी कार्य) प्रकृति के तीनों गुणों (सत्त्व, रज, तम) के द्वारा ही किए जाते हैं।
            परंतु झूठे अहंकार (Ego) से जिसका मन पूरी तरह से मूर्ख (विमूढात्मा) बन चुका है, ऐसा अज्ञानी मनुष्य यह मान बैठता है कि "मैं कर्ता हूँ" (यानी यह काम 'मैंने' किया है)।
            यह पूरी भगवद्गीता के सबसे 'आई-ओपनिंग' (Eye-opening) और इंसान के झूठे ईगो (Ego) को चकनाचूर कर देने वाले श्लोकों में से एक है।
            हम दिन भर जो भी काम करते हैं (सांस लेना, खाना पचाना, सोचना, लड़ना), वह वास्तव में हम नहीं कर रहे हैं; वह सब हमारी भौतिक 'प्रकृति' (Material Nature) के सॉफ्टवेयर (Software) द्वारा ऑटोमैटिकली (Automatically) हो रहा है।
            प्रकृति के तीन गुण (सत्त्व, रज, तम) ही शरीर और इन्द्रियों को चला रहे हैं। आत्मा (जो हम वास्तव में हैं) तो केवल एक शांत दर्शक (Observer) है।
            लेकिन 'अहंकारविमूढात्मा' (अहंकार के नशे में अंधा इंसान) सोचता है: "मैंने यह करोड़ों की कंपनी खड़ी की", "मैंने यह युद्ध जीता", "मैंने इतने लोगों को मारा।"
            यह बिल्कुल वैसा ही है जैसे ट्रेन में बैठा हुआ कोई मुसाफिर यह सोचे कि ट्रेन को वह अपने पैरों की ताकत से धकेल कर ले जा रहा है!
            अर्जुन का यह सोचना कि "मैं भीष्म को मारूँगा" इसी भयंकर 'अहंकार' का नतीजा है। भगवान बता रहे हैं कि मारने वाली प्रकृति है, मरने वाले शरीर भी प्रकृति के हैं; तुम (आत्मा) बीच में नाहक ही कर्तापन (Doership) का घमंड और अपराधबोध पाल रहे हो।
        """.trimIndent(),
        english = """
            All types of activities and actions are universally carried out entirely by the three modes of material nature (Prakriti).
            But the deeply ignorant living entity, completely bewildered and blinded by false ego (Ahankara-vimudhatma), foolishly thinks to himself, "I am the sole doer" (Karta aham iti manyate).
            This is undeniably one of the most incredibly 'Eye-opening', ego-shattering, and scientifically profound verses in the entire Bhagavad Gita.
            Every single micro-action we perform all day long (breathing, digesting food, thinking, fighting a war) is absolutely not executed by our true selves; it is being executed automatically by the highly complex software of 'Prakriti' (Material Nature).
            The three highly potent modes of nature (Sattva, Rajas, Tamas) are the actual mechanical engines driving the physical body and senses. The eternal soul (who we actually are) is merely a silent, motionless 'Observer'.
            But the 'Ahankara-vimudhatma' (a human being violently intoxicated and completely blinded by false ego) arrogantly proclaims: "I built this billion-dollar empire", "I won this massive war", "I killed these men."
            This is exactly as pathetically hilarious as a passenger sitting comfortably inside a high-speed bullet train hallucinating that he is physically pushing the train forward with his own two legs!
            Arjuna's paralyzing thought that "I will kill Bhishma" is the direct, toxic byproduct of this exact 'False Ego'. The Lord is revealing that material nature does the killing, and material nature dies; you (the eternal soul) are unnecessarily carrying the heavy, fake luggage of 'Doership' and 'Guilt'.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            तत्त्ववित्तु महाबाहो गुणकर्मविभागयोः |
            गुणा गुणेषु वर्तन्त इति मत्वा न सज्जते || २८ ||
        """.trimIndent(),
        hindi = """
            परंतु हे महाबाहु! गुण-विभाग और कर्म-विभाग के परम रहस्य को जानने वाला (तत्त्ववित्) ज्ञानी महापुरुष...
            यह भली-भांति समझता है कि "ये प्रकृति के गुण ही (इन्द्रियों के रूप में) अपने-अपने गुणों (विषयों) में बरत रहे हैं" (अर्थात् इन्द्रियां अपना काम कर रही हैं), ऐसा मानकर वह कभी उन कर्मों में आसक्त नहीं होता (न सज्जते)।
            पिछले श्लोक में अज्ञानी का अहंकार बताने के बाद, भगवान अब 'तत्त्ववित्' (Truth-realized Master) का मनोविज्ञान (Psychology) बता रहे हैं।
            ज्ञानी व्यक्ति को यह परम विज्ञान पता होता है कि शरीर और आत्मा दो बिल्कुल अलग-अलग चीजें (विभाग) हैं।
            जब ज्ञानी व्यक्ति कुछ खाता है, देखता है, या यहाँ तक कि युद्ध में किसी पर प्रहार करता है, तो वह जानता है कि "यह मेरी आँखें रूप को देख रही हैं, और मेरे हाथ हथियार चला रहे हैं।"
            "आँखें और हाथ प्रकृति (गुण) के बने हैं, और हथियार भी प्रकृति (गुण) का ही हिस्सा है। यह सिर्फ 'गुणों का गुणों के साथ' (Software interacting with Software) का एक मैकेनिकल खेल चल रहा है।"
            चूँकि ज्ञानी खुद को आत्मा (चेतना) मानता है, इसलिए वह शरीर द्वारा किए जा रहे किसी भी काम से खुद को नहीं जोड़ता ('न सज्जते')।
            वह कर्मों के बीच रहकर भी उनसे अछूता रहता है, ठीक वैसे ही जैसे कमल का पत्ता पानी में रहकर भी कभी गीला नहीं होता।
            यही वह ज्ञान है जो अर्जुन को हत्यारा बनने के झूठे डर (Guilt) से हमेशा के लिए मुक्त कर सकता है।
        """.trimIndent(),
        english = """
            But one who possesses the absolute, true knowledge of the Absolute Truth (Tattva-vit), O mighty-armed one, clearly distinguishes between the soul and the complete network of material action and reaction.
            He perfectly understands that it is merely "the senses (modes) interacting with their respective sense objects (modes)" (Guna guneshu vartanta), and therefore, he never ever becomes attached to them (Na sajjate).
            After brilliantly exposing the inflated ego of the ignorant in the previous verse, the Lord now dissects the ultimate, flawless psychology of the 'Tattva-vit' (The Truth-Realized Master).
            The enlightened sage possesses the absolute, supreme scientific knowledge that the eternal soul and the mechanical material body belong to two entirely completely different dimensions (Vibhaga).
            When a self-realized master eats, sees, or even fiercely strikes an enemy in war, his internal consciousness perfectly realizes: "My physical eyes are seeing forms, and my physical hands are swinging the sword."
            "My eyes and hands are manufactured purely from material nature (Gunas), and the enemy's body is also manufactured from material nature. This entire war is merely a mechanical interaction of 'Gunas with Gunas' (Material Software interacting with Material Hardware)."
            Because the master identifies entirely as the pure, untouched spiritual soul (Consciousness), he absolutely refuses to attach his identity ('Na sajjate') to any physical action executed by the machine of his body.
            He remains absolutely perfectly dry and untouched amidst the heaviest storms of karma, exactly like a pristine lotus leaf floating in muddy water.
            This is the exact, surgical knowledge required to permanently cure Arjuna of his fake, paralyzing guilt of becoming a 'murderer'.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            प्रकृतेर्गुणसम्मूढाः सज्जन्ते गुणकर्मसु |
            तानकृत्स्नविदो मन्दान्कृत्स्नविन्न विचालयेत् || २९ ||
        """.trimIndent(),
        hindi = """
            प्रकृति के गुणों से पूरी तरह सम्मोहित (अंधे) हुए अज्ञानी मनुष्य प्रकृति के गुणों और कर्मों (संसार के भोगों) में बहुत गहरी आसक्ति कर लेते हैं (सज्जन्ते)।
            उन पूर्ण ज्ञान को न जानने वाले (अकृत्स्नविदो) मंदबुद्धि (मन्दान्) लोगों को, पूर्ण ज्ञान को जानने वाला ज्ञानी महापुरुष (कृत्स्नविन्) विचलित न करे (यानी उनके काम न छुड़वाए)।
            यह श्लोक 26वें श्लोक के सिद्धांत को ही और गहराई से समझा रहा है। भगवान यहाँ समाज के 99% लोगों की मानसिक स्थिति का वर्णन करते हैं।
            दुनिया के ज़्यादातर लोग 'गुणसम्मूढाः' (प्रकृति की माया द्वारा हिप्नोटाइज/Hypnotized) हैं। उन्हें पक्का विश्वास है कि शरीर ही सब कुछ है, और पैसा, परिवार, व स्टेटस (Status) ही जीवन की असली सफलता है।
            इन अज्ञानी लोगों को भगवान अत्यंत स्पष्ट शब्दों में 'मन्दान्' (मंदबुद्धि / Slow-witted) और 'अकृत्स्नविदः' (आधा-अधूरा ज्ञान रखने वाले) कहते हैं।
            लेकिन भगवान ज्ञानी महापुरुष को एक बहुत सख्त निर्देश (Strict Warning) देते हैं: "तुम इन मूर्खों को जाकर यह मत कहना कि तुम्हारा ऑफिस, तुम्हारा पैसा, सब बेकार है, इसे छोड़ दो।"
            अगर एक ज्ञानी उनके सांसारिक कर्मों को अचानक छुड़वा देगा ('विचालयेत्'), तो वे लोग डिप्रेशन में चले जाएंगे। क्योंकि उनका दिमाग अभी भगवान (निराकार या आत्मज्ञान) को समझने के लायक (Matured) नहीं हुआ है।
            इसलिए एक लीडर (जैसे अर्जुन) को चाहिए कि वह उन मंदबुद्धि लोगों को डिस्टर्ब किए बिना, खुद एक कर्मयोगी बनकर उनके सामने एक ऐसा महान उदाहरण पेश करे कि वे लोग काम करते-करते ही धीरे-धीरे शुद्ध हो जाएं।
        """.trimIndent(),
        english = """
            Those who are completely bewildered and hypnotized by the modes of material nature become heavily attached (Sajjante) to material activities and the fruits of those modes.
            But the man of complete, perfect knowledge (Kritsna-vit) should absolutely not unsettle or agitate the minds of those slow-witted (Mandan) fools who possess only a poor, incomplete fund of knowledge (Akritsna-vidah).
            This verse profoundly expands and deepens the exact social-engineering principle introduced earlier in verse 26. The Lord is diagnosing the exact psychological state of 99% of the world's population.
            The vast majority of humanity is 'Guna-sammudhah' (completely and totally hypnotized by the illusion of material nature). They firmly, blindly believe that the physical body is the ultimate truth, and acquiring money, family, and high social status is the only metric of success.
            The Supreme Lord uses highly blunt, unsparing vocabulary to describe them, calling them 'Mandan' (slow-witted/foolish) and 'Akritsna-vidah' (those possessing severely fragmented, incomplete knowledge).
            However, the Lord issues a highly strict, non-negotiable warning to the enlightened master: "You must absolutely never aggressively preach to these attached fools to violently abandon their corporate jobs, their wealth, or their families."
            If a master prematurely forces them to drop their worldly attachments ('Vichalayet'), their fragile minds will crash into severe depression. Because their spiritual hard-drive is completely incapable of processing the highly advanced data of 'Soul' or 'God-realization' yet.
            Therefore, a true leader (like Arjuna) must absolutely never disturb their primitive ecosystem; instead, he must act as a flawless Karma Yogi, setting such a magnificent, practical example that the masses gradually purify themselves while executing their daily work.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            मयि सर्वाणि कर्माणि संन्यस्याध्यात्मचेतसा |
            निराशीर्निर्ममो भूत्वा युध्यस्व विगतज्वरः || ३० ||
        """.trimIndent(),
        hindi = """
            इसलिए हे अर्जुन! तुम अपने सभी कर्मों (ड्यूटी) को मुझ अंतर्यामी परमात्मा में अर्पण करके (संन्यस्य), और अपनी चेतना को पूरी तरह से मुझमें (अध्यात्मचेतसा) लगाकर...
            तथा किसी भी प्रकार की आशा (निराशीः), ममता (निर्ममो) और मानसिक संताप (विगतज्वरः) से पूरी तरह मुक्त होकर युद्ध करो।
            यह श्लोक 'कर्मयोग' की सबसे परफेक्ट और सबसे शक्तिशाली प्रैक्टिकल टेक्निक (Practical Technique) है। यह अर्जुन के लिए भगवान का 'फाइनल कमांड' (Final Command) है।
            श्रीकृष्ण एक बहुत ही स्पष्ट '4-स्टेप फॉर्मूला' (4-Step Formula) देते हैं:
            १. 'अध्यात्मचेतसा': सबसे पहले अपना माइंडसेट (Mindset) बदलो। शरीर के लेवल पर सोचना बंद करो और आध्यात्मिक चेतना (God-consciousness) में आओ।
            २. 'मयि सर्वाणि कर्माणि संन्यस्य': अपने सारे कर्मों का 'संन्यास' कर दो। लेकिन जंगल जाकर नहीं; बल्कि जो भी काम करो (जैसे युद्ध), उसे एक 'चेक' (Cheque) की तरह सीधे मेरे (ईश्वर के) अकाउंट में ट्रांसफर (Submit) कर दो।
            ३. 'निराशीर्निर्ममो': फल की 'आशा' (जीत मिलेगी या नहीं) छोड़ दो, और 'ममता' (यह मेरा भाई है, यह मेरा गुरु है) की बीमारी को जड़ से उखाड़ फेंको।
            ४. 'विगतज्वरः': यह सबसे महत्वपूर्ण है। 'ज्वर' का अर्थ है बुखार या मेंटल टेंशन (Mental Tension)। भगवान कहते हैं कि दिल में कोई गिल्ट, स्ट्रेस या डिप्रेशन का बुखार मत रखो। पूरी तरह से रिलैक्स (Relaxed) होकर और 100% निडर होकर...
            "युध्यस्व" (युद्ध करो)! यह एक डरे हुए इंसान को ब्रह्मांड के सबसे खतरनाक 'योद्धा' (Terminator) में बदलने का अचूक आध्यात्मिक मंत्र है।
        """.trimIndent(),
        english = """
            Therefore, O Arjuna, completely surrendering absolutely all your works unto Me (Sannyasya), with your mind and consciousness entirely fixed on Me (Adhyatma-chetasa)...
            and becoming completely free from all desires for profit (Nirashih), free from all claims of proprietorship (Nirmamo), and completely cured of all mental fever and lethargy (Vigata-jvarah)—FIGHT (Yudhyasva)!
            This spectacular verse is the absolute, most perfect, and highly concentrated 'Practical Master-Technique' of Karma Yoga in the entire Gita. It is the Lord's ultimate, unyielding 'Final Command' to Arjuna.
            Sri Krishna delivers a brutally clear, explosive '4-Step Master Formula':
            1. 'Adhyatma-chetasa': First, violently upgrade your core operating mindset. Stop thinking like a petty mortal body and elevate your brain directly into pure God-consciousness.
            2. 'Mayi sarvani karmani sannyasya': Perform 'Sannyasa' (renunciation) of all your actions. But absolutely do not run to a forest; instead, execute your intense work (war) and instantly endorse and transfer the entire karmic 'Cheque' directly into My (God's) personal account.
            3. 'Nirashir nirmamo': Ruthlessly slaughter all 'Hopes' for future profit (victory/defeat), and completely annihilate the toxic disease of 'Mine-ness' (my beloved brother, my dear teacher).
            4. 'Vigata-jvarah': This is critical. 'Jvara' means a burning fever or crippling mental anxiety. The Lord commands: Cure yourself instantly of this pathetic fever of guilt, stress, and depression. Become 100% cool, relaxed, and terrifyingly fearless...
            "Yudhyasva" (FIGHT)! This is the absolute ultimate, infallible spiritual mantra designed to instantly transform a weeping, terrified human into the universe's most unstoppable, lethal 'Warrior'.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            ये मे मतमिदं नित्यमनुतिष्ठन्ति मानवाः |
            श्रद्धावन्तोऽनसूयन्तो मुच्यन्ते तेऽपि कर्मभिः || ३१ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य हमेशा (नित्यम्) पूर्ण श्रद्धा (विश्वास) के साथ और बिना किसी ईर्ष्या या दोष-दृष्टि के (अनसूयन्तः)...
            मेरे इस परम मत (सिद्धांत/आदेश) का पूरी तरह से पालन (अनुतिष्ठन्ति) करते हैं, वे भी कर्मों के सारे भयंकर बंधनों से हमेशा के लिए मुक्त हो जाते हैं।
            भगवान श्रीकृष्ण ने पिछले श्लोक में जो 'कर्मयोग' का अजेय फॉर्मूला दिया था, अब वे उस फॉर्मूले का पेटेंट (Patent) और उसकी गारंटी (Guarantee) दे रहे हैं।
            वे स्पष्ट करते हैं कि यह जो ज्ञान मैंने तुम्हें दिया है (कि स्वार्थ छोड़कर ईश्वर के लिए काम करो), यह कोई मेरा व्यक्तिगत ओपिनियन (Opinion) नहीं है, बल्कि यह ब्रह्मांड का परम 'मत' (Ultimate Law) है।
            इस नियम को लागू करने के लिए भगवान दो सबसे बड़ी शर्तें (Conditions) रखते हैं:
            १. 'श्रद्धावन्तः' (अटूट विश्वास): अगर कोई इंसान शक (Doubt) के साथ इसे करेगा, तो यह काम नहीं करेगा। आपको ईश्वर के शब्दों पर 100% भरोसा होना चाहिए।
            २. 'अनसूयन्तः' (ईर्ष्या/दोष न निकालना): कई लोग भगवान के आदेशों में भी गलतियां निकालते हैं कि "भगवान ने ऐसा क्यों कहा, यह तो गलत है।" जो व्यक्ति भगवान के प्रति अपने मन में घमंड या जलन नहीं रखता...
            ऐसा साधारण से साधारण इंसान ('तेऽपि') भी अगर इस नियम को जीवन में उतार ले, तो वह बड़े-बड़े पापों और कर्मों के अंतहीन चक्र (Matrix) से हमेशा के लिए आज़ाद (मुच्यन्ते) हो जाता है।
            यह श्लोक साबित करता है कि मुक्ति के लिए संस्कृत का भारी विद्वान होना जरूरी नहीं, केवल भगवान पर सच्चा भरोसा और निस्वार्थ कर्म ही काफी है।
        """.trimIndent(),
        english = """
            Those human beings who execute their duties exactly according to My supreme injunctions and consistently follow this teaching (Matam) of Mine...
            with absolute, unflinching faith (Shraddhavanto) and completely without any envy (Anasuyanto), they become eternally liberated from the terrifying bondage of all fruitive actions.
            Lord Sri Krishna, having just delivered the invincible master-formula of 'Karma Yoga' in the previous verse, is now officially stamping His divine 'Patent' and issuing a universal, iron-clad 'Guarantee' for it.
            He explicitly clarifies that this supreme knowledge (to abandon selfishness and work solely for God) is absolutely not some casual, personal opinion; it is the absolute, unchangeable 'Ultimate Law' (Matam) of the cosmos.
            To successfully execute this law, the Lord lays down two highly strict, non-negotiable conditions:
            1. 'Shraddhavanto' (Unflinching Faith): If a human tries to apply this formula while secretly harboring toxic doubts, it will fail miserably. You must possess 100% blind, absolute trust in the Lord's words.
            2. 'Anasuyanto' (Zero Envy/Fault-finding): Many arrogant intellectuals constantly try to find logical flaws in God's commands, thinking they are smarter than the Creator. One must completely purge this demonic envy from the mind.
            Even the most ordinary, uneducated human being ('te api') who strictly follows this law with a pure heart is instantly and permanently liberated (Muchyante) from the horrific, endless matrix of karmic reactions.
            This phenomenal verse proves that eternal liberation does not require one to be a massive Sanskrit scholar; absolute faith in God and selfless action are the only mandatory requirements.
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            ये त्वेतदभ्यसूयन्तो नानुतिष्ठन्ति मे मतम् |
            सर्वज्ञानविमूढांस्तान्विद्धि नष्टानचेतसः || ३२ ||
        """.trimIndent(),
        hindi = """
            परंतु जो मूर्ख लोग मेरे प्रति ईर्ष्या (जलन) रखते हुए दोष निकालते हैं (अभ्यसूयन्तः), और मेरे इस परम सिद्धांत (मत) का पालन नहीं करते...
            उन मूर्खों को तुम सब प्रकार के ज्ञानों में पूरी तरह से अंधा (विमूढ), विवेकहीन (अचेतसः), और निश्चित रूप से नष्ट हुआ (बर्बाद) ही जानो।
            जहाँ 31वें श्लोक में भगवान ने बात मानने वालों को 'मुक्ति' की गारंटी दी थी, वहीं इस श्लोक में वे बात न मानने वालों के 'विनाश' की गारंटी दे रहे हैं।
            यह गीता का एक अत्यंत ही कठोर (Strict) और चेतावनी भरा श्लोक है।
            कुछ लोग अपने बौद्धिक अहंकार (Intellectual Arrogance) में आकर कहते हैं, "कृष्ण कौन होते हैं हमें आदेश देने वाले? हम अपने मन की करेंगे, हम किसी ईश्वर के नियम को नहीं मानते।"
            भगवान ऐसे लोगों को 'अभ्यसूयन्तः' (मुझसे ईर्ष्या करने वाले) कहते हैं। वे लोग भगवान की सत्ता (Authority) को चुनौती देते हैं।
            श्रीकृष्ण का ऐसे लोगों पर फैसला बहुत ही स्पष्ट और भयंकर है। वे कहते हैं कि चाहे ऐसे लोगों के पास दुनिया की कितनी भी बड़ी डिग्रियां (Degrees) या विज्ञान का ज्ञान क्यों न हो...
            आध्यात्मिक दृष्टि से वे 'सर्वज्ञानविमूढान्' (Complete Fools / महामूर्ख) हैं। उनके पास कोई चेतना या कॉमन सेंस (अचेतसः) नहीं है।
            और ऐसे स्वार्थी, कामचोर और अहंकारी लोगों का इस प्रकृति के द्वारा 'नष्टान' (Annihilation / पूर्ण विनाश) होना 100% तय है।
            अर्जुन के लिए यह एक खुली चेतावनी थी कि ईश्वर के आदेश ('युद्ध करो') को न मानना उनके स्वयं के पतन का सीधा रास्ता होगा।
        """.trimIndent(),
        english = """
            But those out of sheer envy and demonic pride (Abhyasuyanto) constantly disregard and completely refuse to follow these supreme teachings of Mine...
            you should know such absolute fools to be completely blind and bereft of all true knowledge (Sarva-jnana-vimudhan), utterly devoid of basic spiritual sense (Achetasah), and definitively ruined and doomed to destruction (Nashtan).
            Whereas in verse 31 the Lord guaranteed ultimate 'Liberation' for those who obey Him, in this highly intense verse, He issues an absolute, terrifying guarantee of 'Total Annihilation' for those who defy Him.
            This is one of the most brutally strict, uncompromising, and chilling warning verses in the entire Bhagavad Gita.
            Many people, bloated with toxic 'Intellectual Arrogance', stubbornly declare, "Who is Krishna to order us around? We will do whatever our mind dictates; we absolutely reject God's universal laws."
            The Lord accurately labels such demonic mentalities as 'Abhyasuyantah' (those who are deeply envious of My supreme authority). They foolishly attempt to challenge the CEO of the Universe.
            Sri Krishna's ultimate verdict upon such rebels is devastatingly clear. He declares that no matter how many prestigious PhDs or advanced scientific degrees such people hold...
            from the absolute spiritual perspective, they are 'Sarva-jnana-vimudhan' (Colossal, completely blind Fools). They possess zero true consciousness or basic spiritual common sense (Achetasah).
            And the ultimate destiny for such selfish, arrogant, and disobedient souls is 'Nashtan' (Absolute Ruin and horrific destruction) by the crushing laws of material nature.
            This served as a glaring, open warning to Arjuna that defying the Supreme Lord's direct command ('To Fight') would be a highly efficient, one-way ticket to his own absolute destruction.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            सदृशं चेष्टते स्वस्याः प्रकृतेर्ज्ञानवानपि |
            प्रकृतिं यान्ति भूतानि निग्रहः किं करिष्यति || ३३ ||
        """.trimIndent(),
        hindi = """
            सभी प्राणी अपनी-अपनी जन्मजात प्रकृति (स्वभाव) के अनुसार ही काम करते हैं, यहाँ तक कि एक बहुत बड़ा ज्ञानी (ज्ञानवान) पुरुष भी अपनी प्रकृति के अनुसार ही व्यवहार (चेष्टा) करता है।
            जब सभी प्राणी अपनी-अपनी प्राकृतिक प्रवृत्तियों (प्रकृति) के ही अधीन हैं, तो फिर इसमें किसी का हठ या बाहरी दबाव (निग्रह) क्या कर लेगा?
            यह श्लोक मनोविज्ञान (Psychology) और जेनेटिक्स (Genetics/Nature) का सबसे बड़ा मास्टरपीस है।
            अर्जुन का प्लान था कि वे अपने क्षत्रिय स्वभाव को जबरदस्ती दबाकर (निग्रह करके) एक ब्राह्मण संन्यासी की तरह जंगल में जाकर बैठेंगे।
            भगवान श्रीकृष्ण इस 'जबरदस्ती' (Repression) को पूरी तरह से वैज्ञानिक रूप से गलत साबित कर रहे हैं।
            वे कहते हैं कि हर इंसान जन्म से ही एक खास 'प्रकृति' (Nature/DNA) लेकर पैदा होता है—कोई शांत (ब्राह्मण) होता है, कोई आक्रामक (क्षत्रिय) होता है।
            यह 'इनबिल्ट सॉफ्टवेयर' (Inbuilt Software) इतना शक्तिशाली है कि बड़े-बड़े ज्ञानी लोग भी इसके खिलाफ नहीं जा सकते।
            अगर एक जन्मजात क्षत्रिय (अर्जुन) हठ करके जंगल में चला भी जाए, तो कुछ ही दिनों में उसका क्षत्रिय खून उबलने लगेगा और वह वहाँ भी किसी बात पर लड़ना शुरू कर देगा।
            "निग्रहः किं करिष्यति"—किसी भी प्राकृतिक वृत्ति (Natural Instinct) को बाहर से बलपूर्वक दबाने से वह मरती नहीं है, बल्कि वह अंदर ही अंदर एक टाइम-बम (Time-bomb) की तरह खतरनाक हो जाती है।
            इसलिए, अपनी 'प्रकृति' से भागने के बजाय, उसी प्रकृति का उपयोग ईश्वर की सेवा (स्वधर्म) में करना ही सबसे श्रेष्ठ मार्ग है।
        """.trimIndent(),
        english = """
            Even a man of absolute highest knowledge (Jnanavan api) acts strictly according to his own inherent nature, for everyone is forced to act in accordance with the modes he has acquired (Prakriti).
            Since all living beings must inevitably follow their inherent tendencies, what can artificial repression or forceful suppression (Nigrahah) possibly accomplish?
            This stunning verse is the absolute ultimate masterpiece of deep psychological profiling and genetic hardwiring (Nature vs. Nurture) in the Gita.
            Arjuna's massively flawed plan was to forcefully suppress and suffocate ('Nigraha') his aggressive Kshatriya instincts and artificially pretend to be a peaceful, meditating Brahmana monk in the forest.
            Lord Sri Krishna completely shatters this dangerous concept of 'Artificial Repression' as utterly unscientific and disastrous.
            He explicitly states that every single human being is born with a highly specific, deeply coded 'Prakriti' (Inbuilt DNA/Psychological Nature)—some are naturally serene (Brahmanas), while others are highly explosive and combative (Kshatriyas).
            This specific 'Inbuilt Software' is so terrifyingly powerful that even the greatest, most advanced enlightened masters simply cannot act against their basic physical nature.
            If a born, elite warrior like Arjuna forcefully isolates himself in a forest, within days his boiling Kshatriya blood will compel him to violently hunt animals or start a fight over a petty issue even there.
            "Nigrahah kim karishyati"—Violently suppressing a natural instinct absolutely never kills it; it merely turns the repressed emotion into a highly volatile, ticking psychological Time-bomb that will eventually explode destructively.
            Therefore, instead of cowardly running away from your 'Nature', channeling that exact same nature directly into the selfless service of God (Sva-dharma) is the absolute highest path of perfection.
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            इन्द्रियस्येन्द्रियस्यार्थे रागद्वेषौ व्यवस्थितौ |
            तयोर्न वशमागच्छेत्तौ ह्यस्य परिपन्थिनौ || ३४ ||
        """.trimIndent(),
        hindi = """
            प्रत्येक इन्द्रिय के उसके अपने-अपने विषयों (सुख देने वाली चीजों) में 'राग' (गहरा आकर्षण) और 'द्वेष' (घृणा) पहले से ही छिपे हुए बैठे (व्यवस्थित) हैं।
            मनुष्य को चाहिए कि वह कभी भी इन दोनों (राग और द्वेष) के वश (गुलाम) में न आए, क्योंकि ये दोनों ही इस मनुष्य के आध्यात्मिक मार्ग के बहुत बड़े डाकू या शत्रु (परिपन्थिनौ) हैं।
            पिछले श्लोक में यह सुनकर कि "इंसान अपनी प्रकृति के अधीन है, निग्रह (दबाना) क्या करेगा", अर्जुन को लग सकता था कि "फिर तो मुझे अपनी इच्छाओं (वासनाओं) के सामने हार मान लेनी चाहिए, क्योंकि वह भी मेरी प्रकृति है!"
            श्रीकृष्ण तुरंत इस बहुत बड़े कंफ्यूजन को दूर करते हैं। वे समझाते हैं कि 'प्रकृति' (तुम्हारा क्षत्रिय होना) और 'वासना' (राग-द्वेष) में बहुत बड़ा अंतर है।
            तुम्हारी आँख को सुंदर रूप पसंद है (राग) और बदसूरत रूप से नफरत है (द्वेष)। तुम्हारी जीभ को मीठा पसंद है (राग) और कड़वा नापसंद है (द्वेष)। यह एक मैकेनिकल (Mechanical) प्रोसेस है जो हर इन्द्री में 'बाय-डिफ़ॉल्ट' (By-default) सेट है।
            लेकिन भगवान एक बहुत बड़ी चेतावनी (Warning) देते हैं: "तयोर्न वशमागच्छेत्"—भले ही ये आकर्षण स्वाभाविक हैं, लेकिन तुम (आत्मा/बुद्धि) कभी इनके 'गुलाम' मत बनो।
            अगर तुम्हें मीठा पसंद है, तो खाओ, लेकिन अगर मीठा न मिलने पर तुम चोरी करने लगो या डिप्रेशन में चले जाओ, तो तुम उस 'राग' के गुलाम बन गए।
            ये 'राग और द्वेष' हाइवे (Highway) पर घात लगाए बैठे उन भयंकर डाकुओं ('परिपन्थिनौ') की तरह हैं, जो इंसान के सारे ज्ञान और शांति को लूटकर उसे बर्बाद कर देते हैं।
            इन्हें बलपूर्वक मत दबाओ, लेकिन इनके रिमोट कंट्रोल (Remote Control) को अपने हाथ से मत जाने दो।
        """.trimIndent(),
        english = """
            There are deep-rooted principles of intense attachment (Raga) and absolute aversion (Dvesha) situated flawlessly within the interactions of every single sense and its corresponding sense object.
            A human being must absolutely never allow himself to come under the control or fall under the sway of these two; for they are undoubtedly his greatest stumbling blocks and deadly enemies (Paripanthinau) on the path of self-realization.
            Hearing in the previous verse that "A man is helpless before his nature, what can repression do?", Arjuna might have foolishly concluded, "Well then, I should just completely surrender to my toxic lust and anger, since that is also my nature!"
            Sri Krishna instantly and brilliantly neutralizes this massive misconception. He clearly differentiates between one's working 'Nature' (being a warrior) and toxic 'Conditioning' (Attachment/Aversion).
            Your physical eyes naturally love beautiful forms (Raga) and hate ugly ones (Dvesha). Your tongue naturally craves sweet sugar (Raga) and rejects bitter medicine (Dvesha). This is a purely mechanical, 'by-default' algorithm hardcoded into every single sense organ.
            But the Lord issues an ultimate, red-alert warning: "Tayor na vasham agacchet"—Even though these magnetic attractions are highly natural, you (the intelligence/soul) must absolutely NEVER become their 'Slave'.
            It is fine to enjoy a sweet taste, but if you brutally rob someone or spiral into severe depression because you didn't get that sweet, you have become a pathetic slave to 'Raga'.
            This 'Raga' (Craving) and 'Dvesha' (Hatred) are exactly like heavily armed, ruthless highway robbers ('Paripanthinau') waiting in ambush to violently hijack your entire spiritual wealth, peace, and sanity.
            Do not artificially repress the senses, but absolutely never hand over the 'Remote Control' of your life to these twin demons.
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            श्रेयान्स्वधर्मो विगुणः परधर्मात्स्वनुष्ठितात् |
            स्वधर्मे निधनं श्रेयः परधर्मो भयावहः || ३५ ||
        """.trimIndent(),
        hindi = """
            अच्छी तरह (परफेक्शन से) किए गए दूसरे के धर्म (कर्तव्य) की तुलना में, गुणों से रहित (या अधूरा) अपना धर्म (स्वधर्म) ही बहुत अधिक श्रेष्ठ (कल्याणकारी) है।
            अपने स्वधर्म का पालन करते हुए यदि मृत्यु (निधन) भी हो जाए, तो वह भी परम कल्याणकारी (श्रेय) है; परंतु दूसरे का धर्म (परधर्म) अपनाने पर वह अत्यंत भयंकर और भय देने वाला (भयावह) होता है।
            यह भगवद्गीता का सबसे क्रांतिकारी (Revolutionary) और बार-बार कोट (Quote) किया जाने वाला श्लोक है, जो करियर (Career) और जीवन के उद्देश्य (Purpose) को परिभाषित करता है।
            अर्जुन का 'स्वधर्म' (अपना मूल कर्तव्य) एक क्षत्रिय के रूप में युद्ध लड़ना है। लेकिन वे इसे छोड़कर एक ब्राह्मण का 'परधर्म' (संन्यास लेकर जंगल में जाना) अपनाना चाहते थे।
            अर्जुन को लग रहा था कि खून-खराबा करने (युद्ध) से तो अच्छा है कि मैं शांति से जंगल में बैठूं; वह काम ज्यादा 'परफेक्ट' (Perfect) और पवित्र लग रहा था।
            लेकिन भगवान श्रीकृष्ण इस विचार को जड़ से काट देते हैं। वे कहते हैं कि "किसी दूसरे व्यक्ति का सूट (Suit) भले ही कितना भी सुंदर क्यों न हो, वह तुम्हें कभी फिट नहीं आएगा।"
            तुम्हारा अपना क्षत्रिय धर्म भले ही देखने में कितना भी बुरा, दोषपूर्ण (विगुण) या हिंसक क्यों न लगे, तुम्हारे लिए वही सबसे बेस्ट (Best) है।
            अगर एक सैनिक युद्ध में लड़ते-लड़ते मर भी जाए ('निधनं श्रेयः'), तो वह उसके लिए सबसे बड़ा गौरव और स्वर्ग का रास्ता है।
            लेकिन अगर वह सैनिक डरकर संन्यासी बन जाए (परधर्म), तो उसका वह जीवन एक भयंकर नर्क ('भयावह') बन जाएगा, क्योंकि उसकी आत्मा कभी शांत नहीं रहेगी और समाज उसे भगोड़ा कहेगा।
            खुद की ओरिजिनलिटी (Originality) में मर जाना, किसी दूसरे की कार्बन कॉपी (Carbon copy) बनकर जीने से करोड़ गुना बेहतर है।
        """.trimIndent(),
        english = """
            It is infinitely far better and more auspicious (Shreyan) to execute one's own prescribed duties (Sva-dharma), even though executed faultily or imperfectly (Vigunah), than to perform another's duties perfectly.
            Complete destruction or even death (Nidhanam) in the course of performing one's own duty is supremely beneficial (Shreyah); whereas engaging in another's path and duties (Para-dharmah) is highly dangerous and fraught with terrifying fear (Bhayavahah).
            This is undeniably one of the most highly revolutionary, most frequently quoted, and ultimate paradigm-shifting verses in the entire Bhagavad Gita, perfectly defining human purpose and career.
            Arjuna's absolute 'Sva-dharma' (inherent duty/nature) is to fight fiercely as a Kshatriya warrior. But he desperately wanted to abandon it and artificially adopt the 'Para-dharma' (another's duty) of a peaceful Brahmana monk retreating to a forest.
            Arjuna falsely hypothesized that peacefully meditating in a forest (which looked flawless and holy) was vastly superior to engaging in a brutal, blood-soaked war (which looked highly faulty and sinful).
            But Lord Sri Krishna violently destroys this misconception from its very root. He essentially declares: "No matter how exquisitely beautiful someone else's tailored suit looks, if you wear it, you will look like an absolute clown."
            Your own prescribed Kshatriya duty, no matter how physically gruesome, seemingly flawed, or violent it appears (Vigunah), is the absolute best and most perfect path specifically designed for your soul.
            If a warrior is brutally slaughtered on the battlefield while executing his duty ('Nidhanam shreyah'), it is his ultimate, supreme glory and a direct, VIP ticket to heaven.
            But if that exact same warrior cowardly adopts the robes of a monk (Para-dharma), his entire life will instantly mutate into a horrific, suffocating hell ('Bhayavahah'), because his inner nature will rebel, and society will spit on him as a deserter.
            It is a billion times more glorious to die magnificently as an original version of yourself than to live a cowardly life as a pathetic, fake carbon copy of someone else.
        """.trimIndent()
    ),
    Shloka(
        id = 36,
        sanskrit = """
            अर्जुन उवाच |
            अथ केन प्रयुक्तोऽयं पापं चरति पूरुषः |
            अनिच्छन्नपि वार्ष्णेय बलादिव नियोजितः || ३६ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने पूछा: हे वार्ष्णेय (वृष्णिवंशी श्रीकृष्ण)! तो फिर यह मनुष्य न चाहते हुए भी (अनिच्छन् अपि)...
            मानो किसी के द्वारा बलपूर्वक (बलात् इव) धकेल कर लगाया हुआ सा, आखिर किसके द्वारा प्रेरित (मजबूर) होकर पाप-कर्मों को करता है?
            यह मानव इतिहास का सबसे गहरा और हर इंसान की जिंदगी से जुड़ा हुआ सबसे बड़ा सवाल है।
            अर्जुन भगवान के सारे सिद्धांत समझ चुके हैं। वे समझ गए हैं कि पाप क्या है और पुण्य क्या है। लेकिन उनके मन में एक बहुत बड़ा प्रैक्टिकल (Practical) सवाल उठ रहा है।
            दुनिया का कोई भी इंसान (चाहे वह चोर हो, शराबी हो, या क्रोधी हो) सुबह उठकर यह नहीं सोचता कि "आज मैं अपनी जिंदगी बर्बाद करूँगा या पाप करूँगा।" हर इंसान अंदर से अच्छा ही बनना चाहता है।
            फिर ऐसा कौन सा 'अदृश्य शैतान' (Invisible Demon) है, जो इंसान की इच्छा न होने पर भी ('अनिच्छन् अपि') उसकी बुद्धि को पूरी तरह हाईजैक (Hijack) कर लेता है?
            ऐसा लगता है जैसे कोई बाहरी ताकत ('बलात् इव' - बलपूर्वक) इंसान की गर्दन पकड़कर उसे नशे, भ्रष्टाचार, वासना या जुर्म की दलदल में धकेल देती है, और इंसान हार जाता है।
            अर्जुन भगवान से उस 'मास्टरमाइंड' (Mastermind) अपराधी का नाम और पता पूछ रहे हैं जो पूरी मानव जाति को पाप के गड्ढे में धकेल रहा है।
            अर्जुन जानना चाहते हैं कि हमारी आज़ादी (Free will) को छीनने वाला यह सबसे बड़ा दुश्मन आखिर है कौन?
        """.trimIndent(),
        english = """
            Arjuna urgently inquired: O descendant of Vrishni (Krishna)! By what specific force is a man so violently impelled and compelled to commit sinful acts...
            even completely against his own will (Anicchan api), as if forcefully engaged and dragged by some overwhelming, invisible power (Balad iva)?
            This is undeniably the single most profound, incredibly relatable, and universally terrifying question in all of human history.
            Arjuna has perfectly understood all the theoretical principles the Lord has taught so far. He clearly knows the difference between right and wrong. But a massively practical, burning question arises in his mind.
            Absolutely no human being in the world (whether a drug addict, a thief, or an abuser) wakes up in the morning and genuinely thinks, "Today, I want to completely ruin my life and commit horrible sins." Deep down, every soul wants to be good.
            So, who exactly is this 'Invisible Demon' that violently hijacks a human being's intelligence, completely bypassing his conscious desire to be good ('Anicchan api')?
            It literally feels exactly as if some massive, overwhelming external dark force ('Balad iva' - by brutal physical force) grabs a man by his neck and ruthlessly throws him into the toxic quicksand of addiction, lust, corruption, or violent crime, completely overpowering his free will.
            Arjuna is directly asking the Supreme Lord for the exact name, identity, and location of this ultimate 'Mastermind' criminal who is continuously forcing the entire human race into the horrific abyss of sin.
            Arjuna desperately demands to know: Who is this absolute Greatest Enemy of humanity that constantly robs us of our free will?
        """.trimIndent()
    ),
    Shloka(
        id = 37,
        sanskrit = """
            श्रीभगवानुवाच |
            काम एष क्रोध एष रजोगुणसमुद्भवः |
            महाशनो महापाप्मा विद्ध्येनमिह वैरिणम् || ३७ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: यह केवल 'काम' (इच्छा या वासना) ही है, जो आगे चलकर 'क्रोध' (गुस्से) का रूप ले लेता है; और यह रजोगुण (पैशन) से पैदा होता है।
            यह काम कभी न पेट भरने वाला (महाशनः) और सबसे बड़ा पापी (महापाप्मा) है। इस संसार में तुम इसी को अपना सबसे बड़ा और सबसे भयंकर दुश्मन (वैरी) जानो।
            भगवान श्रीकृष्ण अर्जुन के उस 'अदृश्य शैतान' वाले सवाल का सीधा और सबसे बड़ा खुलासा (Biggest Reveal) कर रहे हैं।
            वे कहते हैं कि वह दुश्मन कहीं बाहर बादलों में या पाताल में नहीं बैठा है; वह तुम्हारे अपने ही दिमाग के भीतर 'काम' (Lust / असीमित भौतिक इच्छाएं) के रूप में बैठा है!
            'काम' का मतलब केवल सेक्सुअल (Sexual) वासना नहीं है; 'काम' का अर्थ है किसी भी चीज़ (पैसा, पावर, इज्जत, या वस्तु) को पाने की अंधी और कभी न खत्म होने वाली भूख।
            जब यह 'काम' (इच्छा) पूरी नहीं होती, तो यही काम तुरंत अपना रूप बदलकर एक भयंकर 'क्रोध' (Anger) बन जाता है।
            श्रीकृष्ण इस दुश्मन को 'महाशनः' (Maha-ashanah) कहते हैं, जिसका अर्थ है 'बहुत बड़ा पेटू' (All-devouring)। तुम इस वासना को जितना ज्यादा भोग दोगे, यह उतनी ही ज्यादा भूखी होगी; यह आग की तरह है जिसमें घी डालने से आग कभी बुझती नहीं, बल्कि और भड़कती है।
            यह 'महापाप्मा' है; दुनिया के सारे मर्डर, बलात्कार, और घोटाले इसी एक 'काम' की वजह से होते हैं।
            भगवान अर्जुन को एक स्पष्ट टारगेट (Target) दे रहे हैं: "हे अर्जुन! असली दुश्मन दुर्योधन नहीं है; तुम्हारा असली और सबसे खतरनाक दुश्मन तुम्हारे भीतर बैठा यह 'काम' है। इसे ही अपना नंबर 1 वैरी मानो!"
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead definitively declared: It is pure 'Lust' (Kama) alone, which later transforms into blinding 'Anger' (Krodha), and it is born entirely of the mode of passion (Rajo-guna).
            This lust is an all-devouring, never-satisfied glutton (Maha-ashanah) and is the absolute greatest, most horrific sinful entity (Maha-papma). Know this lust to be your absolute ultimate, greatest enemy (Vairinam) in this world.
            Lord Sri Krishna is dropping the absolute 'Biggest Reveal' and direct answer to Arjuna's desperate question regarding the identity of the 'Invisible Demon'.
            He shockingly declares that this ultimate enemy is absolutely not hiding in the clouds or in the dark underworld; it is sitting directly inside your own brain in the lethal form of 'Kama' (Lust / Boundless Material Desire)!
            'Kama' absolutely does not strictly mean just sexual lust; 'Kama' profoundly refers to the blind, toxic, and never-ending cancerous hunger to violently acquire anything (money, political power, fame, or physical objects).
            When this intense 'Kama' (desire) is inevitably frustrated or blocked, it instantly mutates its shape into violent, blinding 'Krodha' (Anger).
            Sri Krishna accurately brands this terrifying enemy as 'Maha-ashanah' (The Ultimate, All-devouring Glutton). The more you try to satisfy this lust by feeding it material pleasures, the hungrier and more violent it gets; it is exactly like trying to extinguish a roaring fire by pouring highly flammable gasoline on it—it only explodes further.
            It is 'Maha-papma' (The Supreme Sinner); 100% of all murders, brutal rapes, massive financial frauds, and world wars on this planet are directly caused purely by this one single entity: 'Kama'.
            The Lord is giving Arjuna an absolute, crystal-clear Target: "O Arjuna! Duryodhana is merely a symptom; your actual, most terrifying, and deadliest enemy is this 'Kama' sitting inside you. Declare it as your Public Enemy No. 1!"
        """.trimIndent()
    ),
    Shloka(
        id = 38,
        sanskrit = """
            धूमेनाव्रियते वह्निर्यथादर्शो मलेन च |
            यथोल्बेनावृतो गर्भस्तथा तेनेदमावृतम् || ३८ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार आग (वह्नि) धुएं से ढकी रहती है; जिस प्रकार शीशा (दर्पण) धूल और मैल से ढका रहता है...
            और जिस प्रकार माता के गर्भ में बच्चा जेर (उल्ब/womb) से ढका रहता है; ठीक उसी प्रकार, इस 'काम' (वासना) के द्वारा इंसान का शुद्ध 'ज्ञान' पूरी तरह ढका हुआ (आवृतम्) है।
            श्रीकृष्ण यह समझा रहे हैं कि इस 'काम' (वासना) ने इंसान के साथ आखिर किया क्या है? इसने हमारे असली और शुद्ध ज्ञान (कि हम अमर आत्मा हैं) को पूरी तरह से 'ढक' (Cover) दिया है।
            इस 'कवरिंग' (Covering) की गंभीरता को समझाने के लिए भगवान तीन बहुत ही शानदार और वैज्ञानिक उदाहरण देते हैं:
            १. 'आग और धुआं' (Fire and Smoke): जब आग में धुआं होता है, तो आग की गर्मी और रोशनी थोड़ी छुप जाती है, लेकिन हवा के एक झोंके से धुआं हट भी सकता है। यह उस इंसान की स्थिति है जिसमें 'काम' थोड़ा कम है; उसे ज्ञान जल्दी मिल सकता है।
            २. 'शीशा और मैल' (Mirror and Dust): अगर शीशे पर बहुत मोटी धूल जमी हो, तो वह हवा से साफ नहीं होती, उसे कपड़े से घिस-घिस कर साफ करना पड़ता है। यह उन लोगों की स्थिति है जिनका मन वासनाओं से बहुत गंदा हो चुका है, उन्हें ज्ञान पाने के लिए कड़ी मेहनत (ध्यान/योग) करनी पड़ेगी।
            ३. 'गर्भ और जेर' (Embryo and Womb): माँ के पेट में बच्चा एक मोटी थैली (Womb) में पूरी तरह कैद होता है; वह न हिल सकता है, न बाहर देख सकता है। यह उन लोगों (जैसे जानवरों या अत्यंत लालची इंसानों) की स्थिति है जिनकी चेतना 'काम' में इतनी बुरी तरह फँस चुकी है कि उनके लिए ज्ञान का एक प्रतिशत प्रकाश भी देखना लगभग असंभव है।
            इन तीन उदाहरणों से भगवान बता रहे हैं कि कामवासना ने हर इंसान की बुद्धि को उसकी डिग्री (Degree) के हिसाब से अंधा कर रखा है।
        """.trimIndent(),
        english = """
            Just as a burning fire is heavily covered by thick smoke, just as a clean mirror is completely obscured by thick dust...
            and just as a developing embryo is entirely enclosed within the darkness of the womb, in the exact same manner, the pure knowledge of the living entity is completely covered (Avritam) by different degrees of this Lust (Kama).
            Sri Krishna is profoundly explaining exactly what this terrifying enemy called 'Kama' (Lust) has practically done to human beings. It has violently and completely 'Covered' (Hijacked) our original, pure spiritual knowledge (the fact that we are eternal souls).
            To brilliantly illustrate the varying severity and density of this 'Covering', the Lord provides three incredibly spectacular, scientific analogies:
            1. 'Fire and Smoke' (Dhumena-avriyate): When fire is covered by smoke, its heat and light are partially hidden, but a strong gust of wind can easily blow the smoke away. This represents a human whose lust is relatively mild; a little spiritual guidance can quickly awaken his pure knowledge.
            2. 'Mirror and Dust' (Adarsho-malena): If a mirror is heavily coated with years of thick, sticky dirt, a mere breeze won't clean it; you must forcefully and rigorously scrub it with a cloth. This represents those whose minds are deeply contaminated by intense material desires; they require rigorous, hardcore effort (severe Yoga/Meditation) to clean their consciousness.
            3. 'Embryo and Womb' (Garbho-ulbena): A developing baby is completely and helplessly imprisoned in the pitch-dark amniotic sac inside the womb; it cannot move freely or see even a microscopic ray of light. This represents the horrific condition of entirely degraded entities (like animals or fiercely greedy humans) whose consciousness is so violently suffocated by 'Kama' that grasping even 1% of spiritual truth is almost practically impossible for them.
            Through these three flawless analogies, the Lord establishes that Lust has completely blinded every single human's intelligence according to varying degrees of severity.
        """.trimIndent()
    ),
    Shloka(
        id = 39,
        sanskrit = """
            आवृतं ज्ञानमेतेन ज्ञानिनो नित्यवैरिणा |
            कामरूपेण कौन्तेय दुष्पूरेणानलेन च || ३९ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! इस 'काम' (वासना) रूपी उस भयंकर आग (अनल) के द्वारा मनुष्य का शुद्ध ज्ञान पूरी तरह से ढका (आवृतं) हुआ है।
            यह वासना कभी न बुझने वाली और कभी न पूरी होने वाली (दुष्पूरेण) है, और यही 'काम' ज्ञानियों (बुद्धिमान लोगों) का सबसे बड़ा नित्य वैरी (हमेशा रहने वाला शत्रु) है।
            भगवान श्रीकृष्ण इस दुश्मन ('काम') की प्रोफाइल (Criminal Profile) को और भी ज्यादा खौफनाक तरीके से अर्जुन के सामने रख रहे हैं।
            वे इस वासना को 'दुष्पूरेण अनलेन' कहते हैं। 'अनल' का अर्थ है आग, और 'दुष्पूरेण' का अर्थ है जिसे कभी भरा (संतुष्ट) न जा सके।
            यह दुनिया का सबसे बड़ा भ्रम है कि "मैं बस एक बार यह मर्सिडीज गाड़ी खरीद लूँ, या बस यह एक करोड़ रुपए कमा लूँ, तो मेरी इच्छा पूरी हो जाएगी और मैं शांत हो जाऊंगा।"
            भगवान कहते हैं कि यह नामुमकिन है! वासना बिल्कुल आग की तरह है; तुम आग में जितनी सूखी लकड़ियां (भौतिक सुख) डालोगे, वह आग बुझेगी नहीं, बल्कि और भयंकर रूप से भड़केगी और अगली बार और ज़्यादा की डिमांड (Demand) करेगी।
            यह 'ज्ञानिनो नित्यवैरिणा' (ज्ञानियों का नित्य शत्रु) है। अज्ञानी लोग तो इस वासना को अपना 'दोस्त' समझते हैं (उन्हें लगता है कि इच्छाएं ही उन्हें खुशियां देंगी), इसलिए वे इसके खिलाफ लड़ते ही नहीं।
            लेकिन केवल एक ज्ञानी (सच्चा साधक) ही जानता है कि यह वासना एक भयंकर 'कैंसर' (Cancer) है जो उसकी आत्मा की शांति को खा रहा है। इसलिए एक ज्ञानी व्यक्ति इस 'काम' के साथ आजीवन (नित्य) युद्ध करता रहता है।
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya)! The pure, absolute consciousness and knowledge of a living entity is completely covered (Avritam) by this eternal enemy (Nitya-vairina) in the form of Lust (Kama-rupena).
            This lust is exactly like a terrifying, unquenchable fire which can never, ever be fully satisfied (Dushpurena analena).
            Lord Sri Krishna is painting an even more terrifying and brutal 'Criminal Profile' of this ultimate enemy ('Kama') right before Arjuna's eyes.
            He accurately brands this intense lust as 'Dushpurena Analena'. 'Anala' means a blazing fire, and 'Dushpurena' means absolutely insatiable (that which can never, ever be filled or satisfied).
            This is the absolute greatest, most pathetic illusion of the human race: "If I just buy this one luxury Mercedes, or if I just earn this one million dollars, my desire will finally be completely satisfied, and I will be at peace."
            The Lord declares this is a biological and spiritual impossibility! Lust behaves exactly like a roaring forest fire; the more dry wood (material pleasures) you blindly throw into it, it absolutely does not extinguish; it explodes more violently and aggressively demands a hundred times more the very next second.
            It is termed 'Jnanino Nitya-vairina' (The eternal, constant enemy of the wise). Foolish, ignorant people tragically mistake this lust as their 'Best Friend' (hallucinating that fulfilling desires brings happiness), so they never even try to fight it.
            But only an elite, highly enlightened sage (Jnani) realizes that this lust is a terrifying, malignant 'Cancer' violently eating away his spiritual peace. Therefore, a true sage engages in a brutal, lifelong (Nitya) daily war against this horrific enemy called 'Kama'.
        """.trimIndent()
    ),
    Shloka(
        id = 40,
        sanskrit = """
            इन्द्रियाणि मनो बुद्धिरस्याधिष्ठानमुच्यते |
            एतैर्विमोहयत्येष ज्ञानमावृत्य देहिनम् || ४० ||
        """.trimIndent(),
        hindi = """
            इन्द्रियां, मन और बुद्धि—ये तीनों ही इस 'काम' (वासना रूपी शत्रु) के रहने के स्थान (अधिष्ठान या Headquarter) कहे जाते हैं।
            यह काम इन्हीं इन्द्रियों, मन और बुद्धि के माध्यम (सहारे) से मनुष्य के शुद्ध ज्ञान को पूरी तरह ढककर जीवात्मा (देहिनम्) को बुरी तरह से मोह (भ्रम) में डाल देता है।
            युद्ध के नियमों के अनुसार, किसी भी दुश्मन को हराने के लिए सबसे पहले उसके 'ठिकानों' (Hideouts) का पता लगाना ज़रूरी होता है।
            अर्जुन के लिए भगवान श्रीकृष्ण एक शानदार कमांडर (Commander) की तरह कामवासना के तीन सबसे बड़े 'मिलिट्री बेस' (Military Bases) का खुलासा कर रहे हैं।
            १. इन्द्रियां (Senses): यह दुश्मन की पहली चौकी (Frontline) है। वासना सबसे पहले आँख (सुंदर रूप देखकर), कान या जीभ के रास्ते से शरीर में एंट्री (Enter) करती है।
            २. मन (Mind): अगर इन्द्रियों से वासना अंदर आ गई, तो वह 'मन' रूपी हेडक्वार्टर (Headquarter) में जाती है। मन उस देखी हुई चीज़ के बारे में दिन-रात ख्याली पुलाव (Daydreaming) पकाना शुरू कर देता है और उसमें भयंकर 'अटैचमेंट' (Attachment) पैदा कर देता है।
            ३. बुद्धि (Intelligence): यह सबसे खतरनाक स्टेज (Stage) है। जब वासना बुद्धि (जो सही-गलत का फैसला करती है) पर भी कब्ज़ा कर लेती है, तो बुद्धि भी करप्ट (Corrupt) हो जाती है। फिर बुद्धि उसी पाप (चोरी या धोखाधड़ी) को सही साबित करने के लिए झूठे लॉजिक (Logic) और तर्क बनाने लगती है।
            जब ये तीनों ठिकाने 'काम' के कब्जे में चले जाते हैं, तो वह इंसान के आत्मा के असली ज्ञान को पूरी तरह हैक (Hijack) कर लेता है, और इंसान पागलों की तरह पाप के दलदल में डूब जाता है।
        """.trimIndent(),
        english = """
            The physical senses (Indriyani), the mind (Manah), and the intelligence (Buddhi) are officially declared to be the strategic sitting places and ultimate strongholds (Adhishthanam) of this enemy called lust.
            Through these exact three agencies, this terrifying lust entirely covers the real knowledge of the embodied living entity (Dehinam) and completely bewilders him into dense illusion (Vimohayati).
            According to the absolute laws of warfare, before you can violently destroy a lethal enemy, you must first accurately pinpoint his exact hidden strongholds ('Hideouts/Bases').
            Acting as the supreme, flawless Military Commander for Arjuna, Lord Sri Krishna brutally exposes the three massive 'Military Bases' where this terrorist called Lust hides and operates from:
            1. The Senses (Indriyas): This is the frontline border post of the enemy. Lust initially infiltrates the human fortress purely through the physical eyes (seeing a seductive form), ears, or tongue.
            2. The Mind (Manas): Once lust breaches the senses, it marches directly into the main control room called the 'Mind'. The mind instantly begins aggressive daydreaming, repeatedly fantasizing about that object, and generates a massive, toxic psychological 'Attachment' to it.
            3. The Intelligence (Buddhi): This is the absolute final and most catastrophic stage. When lust successfully captures the intelligence (the CEO that decides right from wrong), the intelligence becomes 100% corrupted. The corrupted intelligence then starts aggressively manufacturing fake, sophisticated logic to legally and morally justify committing horrific sins (like fraud or adultery).
            When all three of these vital strongholds are successfully hijacked by 'Kama', it completely paralyzes the original, pure spiritual knowledge of the soul, throwing the human being into a terrifying, hopeless abyss of madness and illusion.
        """.trimIndent()
    ),
    Shloka(
        id = 41,
        sanskrit = """
            तस्मात्त्वमिन्द्रियाण्यादौ नियम्य भरतर्षभ |
            पाप्मानं प्रजहि ह्येनं ज्ञानविज्ञाननाशनम् || ४१ ||
        """.trimIndent(),
        hindi = """
            इसलिए हे भरतवंशियों में श्रेष्ठ (भरतर्षभ)! तुम सबसे पहले (आदौ) अपनी इन्द्रियों को ही पूरी तरह से अपने वश में (नियम्य) करो।
            और ज्ञान (आध्यात्मिक समझ) तथा विज्ञान (परमात्मा के साक्षात् अनुभव) का पूरी तरह नाश करने वाले इस महान पापी (पाप्मानं) 'काम' (वासना) को बलपूर्वक मार डालो (प्रजहि)।
            दुश्मन के ठिकानों का पता लगने के बाद, अब भगवान श्रीकृष्ण अर्जुन को 'हमला' (Attack) करने का सीधा और स्पष्ट 'एक्शन प्लान' (Action Plan) दे रहे हैं।
            भगवान कहते हैं कि चूँकि इस दुश्मन ('काम') की एंट्री (Entry) सबसे पहले 'इन्द्रियों' के गेट (Gate) से होती है, इसलिए सबसे पहले (आदौ) उसी गेट को मजबूती से बंद (नियम्य) करो!
            अगर आँखें कोई गंदी चीज़ देखें ही नहीं, अगर कान कोई भड़काऊ बात सुनें ही नहीं, तो मन और बुद्धि तक वह ज़हर पहुँचेगा ही नहीं। इन्द्रियों का नियंत्रण ही सबसे पहली और सबसे बड़ी ढाल (Shield) है।
            श्रीकृष्ण इस 'काम' को बहुत भयानक टाइटल (Title) देते हैं: 'ज्ञान-विज्ञान-नाशनम्'।
            'ज्ञान' का मतलब है किताबी पढ़ाई (Scriptural knowledge) और 'विज्ञान' का मतलब है भगवान का प्रैक्टिकल अनुभव (Realized wisdom)।
            यह कामवासना एक ऐसा भयंकर एसिड (Acid) है जो इंसान की जिंदगी भर की पढ़ी हुई गीता, वेदों के ज्ञान और उसकी सारी तपस्याओं को एक सेकंड में जलाकर राख कर देता है। बड़े-बड़े ऋषि-मुनि इस वासना के कारण अपने पथ से गिर गए।
            इसलिए भगवान का स्पष्ट ऑर्डर (Order) है: "प्रजहि" (इस दुश्मन को बेरहमी से मौत के घाट उतार दो)। इस वासना के साथ कोई समझौता (Compromise) या दोस्ती नहीं हो सकती; इसे मारना ही पड़ेगा!
        """.trimIndent(),
        english = """
            Therefore, O absolute best of the Bharatas (Bharatarshabha)! In the very beginning (Adau), you must aggressively curb and completely master your physical senses (Niyamya).
            And by doing so, ruthlessly slay (Prajahi) this terrifying, great symbol of sin (Papmanam), which is the absolute destroyer of all pure knowledge (Jnana) and self-realization (Vijnana).
            Now that the exact geographical hideouts of the enemy have been flawlessly identified, Lord Sri Krishna is giving Arjuna a direct, highly aggressive, and extremely tactical 'Action Plan' for the counter-attack.
            The Lord commands that since the very first breach of this terrorist ('Kama') occurs strictly through the entry-gates of the 'Senses', your absolute first priority ('Adau') must be to violently lock down and barricade those gates (Niyamya)!
            If the eyes absolutely refuse to look at degrading objects, and the ears refuse to listen to toxic gossip, that deadly poison can never possibly reach the deeper headquarters of the mind and intelligence. Masterful sense control is the absolute first and most impenetrable shield.
            Sri Krishna bestows a highly terrifying title upon this lust: 'Jnana-Vijnana-Nashanam'.
            'Jnana' refers to deep theoretical knowledge of the scriptures, and 'Vijnana' signifies the ultimate, practical, realized experiential wisdom of God.
            This explosive lust is such a horrific, highly concentrated acid that it can instantly burn to ashes a man's entire lifetime of Vedic study, severe austerities, and massive spiritual wisdom in a single microsecond. History is littered with legendary sages who crashed from the sky simply because of a moment's lust.
            Therefore, the Lord's absolute, uncompromising military order is: "Prajahi" (Show no mercy; violently slay and slaughter this enemy). There can be absolutely zero compromise or peaceful treaty with this lust; it must be annihilated!
        """.trimIndent()
    ),
    Shloka(
        id = 42,
        sanskrit = """
            इन्द्रियाणि पराण्याहुरिन्द्रियेभ्यः परं मनः |
            मनसस्तु परा बुद्धिर्यो बुद्धेः परतस्तु सः || ४२ ||
        """.trimIndent(),
        hindi = """
            ज्ञानी लोग कहते हैं कि इस जड़ और स्थूल शरीर से 'इन्द्रियां' (Senses) बहुत श्रेष्ठ और शक्तिशाली (परा) हैं; इन इन्द्रियों से भी अत्यंत श्रेष्ठ और शक्तिशाली 'मन' (Mind) है।
            मन से भी बहुत अधिक श्रेष्ठ और ताकतवर 'बुद्धि' (Intelligence) है; और जो इस बुद्धि से भी अत्यंत श्रेष्ठ (परतः) और सबसे ऊपर है, वह 'सः' (वह अमर आत्मा) है।
            दुश्मन ('काम') को मारने का आदेश देने के बाद, भगवान अब अर्जुन को उस 'हथियार' (Weapon) और इंसान के आंतरिक सिस्टम (Internal Hierarchy) का ज्ञान दे रहे हैं, जिससे यह लड़ाई जीती जाएगी।
            यह श्लोक भारतीय मनोविज्ञान (Vedic Psychology) और शरीर विज्ञान का सबसे शानदार और 'मास्टर-स्ट्रक्चर' (Master-Structure) है। भगवान बता रहे हैं कि शरीर में कौन किसका बॉस (Boss) है:
            १. सबसे नीचे यह 'स्थूल शरीर' (Physical Body) है (जो मिट्टी का बना है)।
            २. शरीर का बॉस 'इन्द्रियां' (आँख, कान) हैं। क्योंकि शरीर अंधा है, इन्द्रियां ही उसे चलाती हैं।
            ३. इन्द्रियों का भी बॉस 'मन' (Mind) है। अगर आप खुली आँखों से टीवी देख रहे हैं, लेकिन मन कहीं और है, तो आपको टीवी पर कुछ दिखाई नहीं देगा। मन इन्द्रियों से बहुत ज्यादा पॉवरफुल (Powerful) है।
            ४. मन हमेशा चंचल होता है, लेकिन मन का बॉस 'बुद्धि' (Intelligence/विवेक) है। जब मन कहता है "मुझे यह ज़हर पीना है", तो बुद्धि डंडा मार कर कहती है "नहीं, यह हानिकारक है।" बुद्धि मन का ड्राइवर (Driver) है।
            ५. और सबसे बड़ा सुप्रीम बॉस (Supreme Boss), जो बुद्धि से भी करोड़ों गुना ऊपर ('परतस्तु सः') है—वह है हमारी अमर 'आत्मा' (Soul)!
            भगवान समझा रहे हैं कि जब वासना हमला करे, तो घबराना मत! तुम कोई कमज़ोर शरीर नहीं हो; तुम वह परम शक्तिशाली आत्मा हो जो इस पूरे सिस्टम का असली 'मालिक' (Master) है। आत्मा की शक्ति के सामने यह वासना कुछ भी नहीं है।
        """.trimIndent(),
        english = """
            The working senses are strictly considered to be superior to dull, dead matter; mind is considerably higher and more powerful than the senses.
            Intelligence is significantly higher and much more potent than the mind; and that which is absolutely supreme and infinitely higher than the intelligence is 'He' (Sah - the Eternal Soul).
            Having issued the strict military order to annihilate the enemy ('Kama'), the Lord now reveals the ultimate 'Super-Weapon' and the flawless 'Internal Hierarchy' (Chain of Command) of the human system required to win this brutal war.
            This spectacular verse lays out the absolute 'Master-Structure' of Vedic Psychology, clearly identifying who is the exact 'Boss' inside the human framework:
            1. At the absolute bottom is dull, dead 'Matter' (the gross physical body).
            2. Superior to the body are the active 'Senses' (eyes, ears, etc.), because they actively dictate the body's actions.
            3. The boss of the senses is the 'Mind' (Manas). You can stare at a screen with wide-open eyes, but if your mind is heavily distracted elsewhere, you will see absolutely nothing. The mind is infinitely more potent than the physical senses.
            4. The mind is highly emotional and incredibly fickle, but the supreme boss of the mind is the 'Intelligence' (Buddhi/Rational Conscience). When the reckless mind screams, "I want to consume this poison!", the strict intelligence slams the brakes and says, "No, this will kill us." Intelligence is the driver.
            5. And the absolute, Ultimate Supreme Boss, residing infinitely higher ('Paratas tu sah') than even the brilliant intelligence—is 'He' (The immortal, invincible Soul)!
            The Lord is brilliantly empowering Arjuna: When the tsunami of lust violently attacks, do not panic! You are absolutely not this fragile, pathetic physical body; you are the supremely powerful, indestructible Soul, the ultimate 'Master' of this entire machine. Before the blinding power of the soul, this pathetic lust is absolutely nothing.
        """.trimIndent()
    ),
    Shloka(
        id = 43,
        sanskrit = """
            एवं बुद्धेः परं बुद्ध्वा संस्तभ्यात्मानमात्मना |
            जहि शत्रुं महाबाहो कामरूपं दुरासदम् || ४३ ||
        """.trimIndent(),
        hindi = """
            इस प्रकार हे महाबाहु (अर्जुन)! स्वयं को बुद्धि से भी अत्यंत परे (सर्वोच्च और परम शक्तिशाली आत्मा) जानकर, और अपनी शुद्ध बुद्धि के द्वारा अपने चंचल मन को पूरी तरह स्थिर (संस्तभ्य) करके...
            तुम इस 'काम' (वासना) रूपी, और जिसे जीतना अत्यंत कठिन है (दुरासदम्), ऐसे इस भयंकर शत्रु को हमेशा के लिए मार डालो (जहि)।
            यह भगवद्गीता के तीसरे अध्याय का शानदार और युद्धनाद (Battle-cry) से भरा हुआ अंतिम (Grand Finale) श्लोक है!
            भगवान श्रीकृष्ण यहाँ इस पूरी आध्यात्मिक लड़ाई का 'फाइनल ब्लूप्रिंट' (Final Blueprint) दे रहे हैं।
            वे कहते हैं कि जीत का पहला कदम है 'आत्मज्ञान' (Self-Realization)। तुम्हें यह बात गहराई से महसूस (बुद्ध्वा) करनी होगी कि तुम मन या बुद्धि नहीं हो, तुम 'बुद्धेः परं' (उन सबसे ऊपर वाली अजेय आत्मा) हो।
            जब तुम्हें अपनी इस असली और अनंत शक्ति का अहसास हो जाएगा, तब उस शुद्ध, आध्यात्मिक 'बुद्धि' के द्वारा अपने ही भड़कते हुए 'मन' (आत्मा का निचला हिस्सा) पर एक जोरदार लगाम (संस्तभ्य) लगाओ।
            श्रीकृष्ण वासना को 'दुरासदम्' कहते हैं—अर्थात् इसे जीतना या इसके पास जाना बहुत ही ज्यादा मुश्किल और खतरनाक है। यह कोई आम दुश्मन नहीं है।
            लेकिन वे अर्जुन को 'महाबाहो' (महान भुजाओं वाले योद्धा) कहकर ललकारते हैं! "तुमने दुनिया के बड़े-बड़े अजेय राक्षसों को हराया है, अब अपनी उस परम आध्यात्मिक शक्ति का इस्तेमाल करके अपने भीतर छिपे इस 'काम' रूपी राक्षस का हमेशा के लिए गला काट दो (जहि)!"
            इस प्रकार, भगवान ने अर्जुन के पहले श्लोक के प्रश्न ("मुझे इस घोर कर्म में क्यों धकेल रहे हो?") का उत्तर दिया—कि बाहर का युद्ध तो एक ड्यूटी है, लेकिन असली 'घोर युद्ध' तो तुम्हें अपने अंदर की वासनाओं के खिलाफ लड़ना है।
            यहाँ 'कर्मयोग' नामक तीसरा अध्याय पूर्ण होता है।
        """.trimIndent(),
        english = """
            Thus, O mighty-armed Arjuna (Maha-baho)! Having profoundly realized oneself to be purely transcendental and infinitely superior to material senses, mind, and intelligence...
            you must steadily and completely conquer your lower, flickering mind by deliberate spiritual intelligence (Sansthabhya), and thereby ruthlessly crush and slay (Jahi) this incredibly formidable and terrifying enemy known as lust (Kama-rupam durasadam).
            This is the highly explosive, spectacular, and adrenaline-pumping 'Grand Finale' battle-cry verse of the Third Chapter of the Bhagavad Gita!
            Lord Sri Krishna is handing over the absolute 'Final Tactical Blueprint' for winning the ultimate spiritual World War.
            He declares that the absolute first step to victory is 'Self-Realization'. You must profoundly process and internalize ('Buddhva') the fact that you are absolutely not the pathetic mind or the intelligence; you are 'Buddheh param' (the invincible, supreme eternal Soul residing far above them).
            Once you tap into that infinite, staggering reservoir of pure spiritual power, use your now-purified, razor-sharp spiritual 'Intelligence' to forcefully put an iron-clad lockdown ('Sansthabhya') on your wildly flickering 'Mind'.
            Sri Krishna accurately warns that this lust is 'Durasadam'—meaning it is horrifyingly formidable, incredibly difficult to conquer, and highly dangerous to even approach. It is absolutely no ordinary opponent.
            But He aggressively challenges Arjuna by calling him 'Maha-baho' (The Warrior with Invincible Arms)! "You have brutally slaughtered the world's most terrifying, unbeatable demons; now, ignite that supreme spiritual firepower and permanently, ruthlessly behead ('Jahi') this ultimate internal demon called Lust!"
            Thus, the Lord flawlessly answers Arjuna's very first protesting question ("Why are you pushing me into this ghastly war?"). The Lord proves that fighting the external war is merely a social duty, but the actual, most brutal 'World War' you must fight is against the toxic lust sitting inside your own brain.
            Here perfectly concludes the majestic Third Chapter, the Yoga of Action (Karma Yoga).
        """.trimIndent()
    )
)