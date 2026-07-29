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
fun AdhyayaThirteen() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaThirteenShlokas.indexOfFirst { it.id == shlokaNum }
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
            label = { Text("Search Shloka Number (1 - 35)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { performSearch() }),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            itemsIndexed(adhyayaThirteenShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaThirteenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            अर्जुन उवाच |
            प्रकृतिं पुरुषं चैव क्षेत्रं क्षेत्रज्ञमेव च |
            एतद्वेदितुमिच्छामि ज्ञानं ज्ञेयं च केशव || १ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने प्रकृति और पुरुष के बारे में केशव से पूछा।
            उन्होंने क्षेत्र और क्षेत्रज्ञ का अर्थ भी जानना चाहा।
            ज्ञान और ज्ञेय के बीच का अंतर अर्जुन का मुख्य प्रश्न था।
            यह अध्याय ज्ञान-योग का गहरा और तकनीकी हिस्सा है।
            अर्जुन ब्रह्मांड के भौतिक और आध्यात्मिक पक्ष समझना चाहते हैं।
            क्षेत्र हमारा यह भौतिक जैविक शरीर है जो हम देखते हैं।
            क्षेत्रज्ञ इसके भीतर बैठी चेतन आत्मा है जो सब जानती है।
            सच्ची शिक्षा क्या है, अर्जुन यह प्रश्न भी स्पष्ट करते हैं।
            जीवन का अंतिम लक्ष्य क्या होना चाहिए, यह उनकी जिज्ञासा है।
            केशव से इन सभी छह स्तंभों की विस्तृत व्याख्या का अनुरोध किया।
        """.trimIndent(),
        english = """
            Arjuna inquires about the nature of Prakriti and Purusha.
            He seeks the precise definition of the Field and its Knower.
            He asks for the distinction between Knowledge and its Object.
            This starts the highly technical Jnana-Yoga section of Gita.
            Arjuna wants to decode the universe's hardware and software.
            Kshetra represents our physical biological body in reality.
            Kshetrajna is the conscious soul operating from within.
            He questions what constitutes an absolute true education.
            He wonders about the ultimate target of human life.
            He requests Keshava to explain these six core pillars clearly.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            श्रीभगवानुवाच |
            इदं शरीरं कौन्तेय क्षेत्रमित्यभिधीयते |
            एतद्यो वेत्ति तं प्राहुः क्षेत्रज्ञ इति तद्विदः || २ ||
        """.trimIndent(),
        hindi = """
            भगवान ने कहा कि यह शरीर ही वास्तव में क्षेत्र है।
            जो इस शरीर को गहराई से जानता है, वह क्षेत्रज्ञ है।
            शरीर एक कर्म करने की उपजाऊ भूमि की तरह कार्य करता है।
            इसमें बोए गए बीज ही हमें सुख-दुःख की फसल देते हैं।
            आत्मा शरीर के भीतर रहकर इसे केवल ऑब्जर्व करती है।
            विद्वान लोग इस ज्ञाता को ही क्षेत्रज्ञ कहकर पुकारते हैं।
            आप स्वयं यह शरीर नहीं हैं, बल्कि इसके मालिक हैं।
            जैसे किसान खेत से अलग है, वैसे ही आत्मा शरीर से अलग है।
            यह जैविक मशीन केवल आत्मा के उपयोग के लिए बनी है।
            कौन्तेय को शरीर और आत्मा का मूल अंतर यहाँ समझाया गया।
        """.trimIndent(),
        english = """
            The Lord explains that the physical body is the Field.
            One who consciously observes this body is the Knower.
            The body is a fertile ground for performing life's actions.
            Seeds sown here produce the inevitable harvest of joy or pain.
            The soul resides within, acting strictly as a silent observer.
            Sages officially identify this knower as the Kshetrajna.
            You are not the biological body, but its true and eternal owner.
            A farmer is distinct from his land; so is the soul from flesh.
            This biological machine exists solely for the soul's usage.
            Krishna reveals the fundamental gap between matter and spirit.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            क्षेत्रज्ञं चापि मां विद्धि सर्वक्षेत्रेषु भारत |
            क्षेत्रक्षेत्रज्ञयोर्ज्ञानं यत्तज्ज्ञानं मतं मे || ३ ||
        """.trimIndent(),
        hindi = """
            भगवान ने कहा कि मैं भी हर शरीर में क्षेत्रज्ञ के रूप में हूँ।
            हर शरीर में दो जानने वाले आत्मा और परमात्मा मौजूद होते हैं।
            आत्मा केवल अपने शरीर के सुख-दुःख को ही जान पाती है।
            परमात्मा ब्रह्मांड के हर जीव का अनुभव एक साथ जानते हैं।
            शरीर और आत्मा के अंतर को समझना ही सबसे असली ज्ञान है।
            भगवान इस संपूर्ण सृष्टि के कॉमन थ्रेड या मूल सूत्र हैं।
            किताबी जानकारी नहीं, बल्कि यह परम सत्य ही सच्ची शिक्षा है।
            हार्डवेयर और सॉफ्टवेयर का यह विश्लेषण ही सच्ची बुद्धिमानी है।
            ईश्वर हर कोशिका में एक परम साक्षी बनकर बैठे हुए हैं।
            भारत को सच्चे ज्ञान की सर्वोच्च और सटीक परिभाषा दी गई।
        """.trimIndent(),
        english = """
            The Lord reveals He is also the Knower in all bodies.
            Two knowers exist within: the individual Soul and the Supersoul.
            The soul only experiences its specific body's limited pain.
            The Supersoul knows every entity's thoughts simultaneously.
            Distinguishing body from spirit is the only true knowledge.
            God is the underlying common thread of all cosmic existence.
            This realization is infinitely superior to any academic information.
            Wisdom lies in analyzing the biological hardware-software divide.
            God sits in every single cell as the eternal, silent witness.
            Arjuna receives the ultimate definition of true enlightenment.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            तत्क्षेत्रं यच्च यादृक्च यद्विकारि यतश्च यत् |
            स च यो यत्प्रभावश्च तत्समासेन मे शृणु || ४ ||
        """.trimIndent(),
        hindi = """
            भगवान अब शरीर की बनावट और उसके बदलावों को समझाएंगे।
            यह शरीर किससे बना है और इसमें विकार क्यों उत्पन्न होते हैं।
            आत्मा वास्तव में कौन है और उसकी असली शक्तियाँ क्या हैं।
            इन सब का एक अत्यंत संक्षिप्त और सटीक विवरण दिया जाएगा।
            यह मानव अस्तित्व और जीवन का एक तकनीकी मैनुअल है।
            शरीर के केमिकल और इमोशनल बदलावों का स्रोत बताया जाएगा।
            आत्मा के अदृश्य और शक्तिशाली प्रभाव की व्याख्या शुरू होगी।
            अर्जुन को पूरे ध्यान से इन बातों को सुनने का आदेश दिया गया।
            भौतिक और आध्यात्मिक डेटा का मिलन बिंदु यहीं से शुरू होता है।
            भगवान संक्षेप में इस महान सत्य को प्रकट करने का वादा करते हैं।
        """.trimIndent(),
        english = """
            The Lord will now explain the body's structure and changes.
            He details its core elements and the reasons for its mutation.
            He describes the soul's true identity and its vast powers.
            A precise and brief summary will now be provided to Arjuna.
            This acts exactly as the technical manual of human existence.
            He identifies the exact source of chemical and emotional shifts.
            The explanation of the soul's invisible influence now begins.
            Arjuna is firmly commanded to listen with absolute focus.
            This is the critical junction of material and spiritual data.
            Krishna promises to reveal the ultimate truth in concise form.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            ऋषिभिर्बहुधा गीतं छन्दोभिर्विविधैः पृथक् |
            ब्रह्मसूत्रपदैश्चैव हेतुमद्भिर्विनिश्चितैः || ५ ||
        """.trimIndent(),
        hindi = """
            यह ज्ञान महान ऋषियों द्वारा वेदों में विस्तार से गाया गया है।
            इसे ब्रह्मसूत्र के तार्किक और अकाट्य वचनों में भी बताया गया है।
            यह केवल कोई राय नहीं है, बल्कि वैज्ञानिक रूप से सिद्ध तथ्य है।
            हर आध्यात्मिक दावे के पीछे एक ठोस कारण या हेतु दिया गया है।
            सनातन अध्यात्म कोई अंधविश्वास नहीं, बल्कि सुपर-लॉजिक है।
            प्राचीन महान वैज्ञानिकों ने अपने शोध से इसे प्रमाणित किया है।
            वेदों के विभिन्न सुंदर छंदों में यह ज्ञान सुरक्षित रखा गया है।
            कार्य और कारण के संबंध की निश्चित व्याख्या यहाँ उपलब्ध है।
            भगवान ने अपने इस ज्ञान का आधिकारिक आधार स्पष्ट किया है।
            तर्कों के माध्यम से इस परम सत्य को मजबूती से स्थापित किया गया है।
        """.trimIndent(),
        english = """
            This knowledge is highly glorified by sages in the Vedas.
            It is precisely detailed in the logical words of the Vedanta-sutra.
            It is not just a casual opinion, but a scientifically proven truth.
            Every spiritual claim is supported by a solid rational cause.
            True spirituality is absolutely not blind faith; it is Super-Logic.
            Elite spiritual scientists have thoroughly verified these facts.
            This profound wisdom is safely preserved across diverse Vedic hymns.
            Definitive explanations of cause and effect are officially given.
            The Lord perfectly clarifies the authoritative basis of His words.
            The ultimate truth is established through rigorous logical reasoning.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            महाभूतान्यहङ्कारो बुद्धिरव्यक्तमेव च |
            इन्द्रियाणि दशकैकं च पञ्च चेन्द्रियगोचराः || ६ ||
        """.trimIndent(),
        hindi = """
            यह शरीर चौबीस तत्वों से बना एक अत्यंत कॉम्प्लेक्स रोबोट है।
            इसमें पाँच महाभूत हैं: पृथ्वी, जल, अग्नि, वायु और आकाश।
            तीन भीतरी तत्व इसे चलाते हैं: अहंकार, बुद्धि और मूल प्रकृति।
            दस इन्द्रियां हैं जिनमें पाँच ज्ञानेंद्रियां और पाँच कर्मेंद्रियां हैं।
            ग्यारहवाँ तत्व हमारा मन है जो इन सबका केंद्र और नियंत्रक है।
            पाँच इन्द्रिय विषय भी हैं: रूप, रस, गंध, शब्द और स्पर्श।
            यह हमारे भौतिक जगत का पूर्ण हार्डवेयर कॉन्फ़िगरेशन कहलाता है।
            इन चौबीस तत्वों के बाहर इस दुनिया में कुछ भी भौतिक मौजूद नहीं है।
            हमारे शरीर का निर्माण इन्ही बुनियादी ईंटों से मिलकर हुआ है।
            मनुष्य की इस जैविक मशीनरी का यह सबसे वैज्ञानिक वर्गीकरण है।
        """.trimIndent(),
        english = """
            The body is a Complex Robot manufactured from exactly 24 elements.
            The five gross elements are Earth, Water, Fire, Air, and Ether.
            Three subtle drivers operate it: Ego, Intelligence, and Nature.
            There are ten senses: five for knowledge and five for working.
            The Mind acts as the eleventh element and the central hub.
            The five sense objects are Sound, Touch, Form, Taste, and Smell.
            This represents the complete hardware configuration of all matter.
            Absolutely nothing physical exists outside this specific matrix.
            The human body is strictly constructed from these foundational bricks.
            A flawless scientific classification of human machinery is revealed.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            इच्छा द्वेषः सुखं दुःखं सङ्घातश्चेतना धृतिः |
            एतत्क्षेत्रं समासेन सविकारमुदाहृतम् || ७ ||
        """.trimIndent(),
        hindi = """
            इच्छा, नफरत, सुख और दुःख भी इसी भौतिक शरीर का ही हिस्सा हैं।
            शरीर का आकार, जैविक शक्ति और धैर्य भी भौतिक प्रकृति ही हैं।
            ये सब आत्मा के नहीं, बल्कि क्षेत्र के विकार या बदलाव होते हैं।
            आत्मा इन रासायनिक और विद्युत बदलावों से पूरी तरह अलग है।
            जिसे हम महसूस करते हैं, वह केवल शरीर का एक सॉफ्टवेयर है।
            मन की ये हलचलें केवल शरीर की जैविक मशीनरी का हिस्सा हैं।
            संक्षेप में इस क्षेत्र और इसके विकारों का पूरा विवरण दिया गया है।
            आत्मा केवल एक शांत और अछूता दृष्टा बनकर सब कुछ देखती है।
            हम अज्ञानतावश अपनी भावनाओं को ही अपनी आत्मा मान बैठते हैं।
            शरीर के मानसिक और शारीरिक कार्यों का यह स्पष्टीकरण बहुत जरूरी है।
        """.trimIndent(),
        english = """
            Desire, hatred, joy, and pain are fundamentally part of the Field.
            Physical form, life-force, and conviction are entirely material.
            These are simply mutations of matter, not attributes of the soul.
            The soul is distinctly separate from these chemical interactions.
            What we intensely feel is merely the body's subtle software.
            Mental fluctuations belong strictly to the biological machinery.
            A concise and precise description of the Field is now finalized.
            The soul remains a perfectly calm and untouched observer inside.
            We mistakenly identify our fleeting emotions as our true self.
            This clarification of the body's mental and physical functions is vital.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            अमानित्वमदम्भित्वमहिंसा क्षान्तिरार्जवम् |
            आचार्योपासनं शौचं स्थैर्यमात्मविनिग्रहः || ८ ||
        """.trimIndent(),
        hindi = """
            असली ज्ञान का अर्थ केवल सूचना नहीं बल्कि उत्तम चरित्र है।
            अमानित्व का अर्थ है घमंड का न होना और पूरी विनम्रता रखना।
            अदम्भित्व हमें किसी भी प्रकार के दिखावे या पाखंड से दूर रखता है।
            अहिंसा और क्षमा भाव को अपनाना एक ज्ञानी के सबसे बड़े गुण हैं।
            आर्जवम् का मतलब है अपने विचार और व्यवहार में सरलता रखना।
            आचार्योपासनम् यानी अपने गुरु की निष्काम सेवा और सम्मान करना।
            शौचम् का अर्थ है शरीर के बाहर और मन के भीतर की पूर्ण शुद्धि।
            स्थैर्यम् इंसान को अपने मार्ग पर अडिग और हमेशा स्थिर रखता है।
            आत्मविनिग्रहः के द्वारा मन और इन्द्रियों पर कड़ा नियंत्रण होता है।
            ये सभी गुण ज्ञान के उन बीस महान लक्षणों की महत्वपूर्ण शुरुआत हैं।
        """.trimIndent(),
        english = """
            True knowledge is officially defined by Character, not just data.
            Amanitvam means practicing absolute humility and lacking pride.
            Adambhitvam requires the total avoidance of any false or fake show.
            Embracing pure nonviolence and a tolerant heart are mandatory.
            Arjavam focuses on maintaining simplicity in both thought and deed.
            It involves sincere service and absolute respect to the Spiritual Master.
            Shaucham means achieving both internal and external cleanliness.
            Sthairyam keeps the seeker remaining steadfast on the chosen path.
            Atma-vinigraha demands maintaining strict, military-grade self-control.
            This beautifully initiates the majestic list of twenty symptoms of wisdom.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            इन्द्रियार्थेषु वैराग्यमनहङ्कार एव च |
            जन्ममृत्युजराव्याधिदुःखदोषानुदर्शनम् || ९ ||
        """.trimIndent(),
        hindi = """
            ज्ञानी वह है जिसमें इन्द्रियों के भोगों के प्रति विरक्ति का भाव हो।
            उसके भीतर अहंकार का पूर्ण अभाव या जीरो ईगो की स्थिति होती है।
            वह जीवन की चार कड़वी सच्चाइयों को हर समय याद रखता है।
            जन्म, मृत्यु, बुढ़ापा और बीमारी का वह हमेशा गहरा चिंतन करता है।
            ज्ञानी इंसान दुनिया की इस अस्थायी हकीकत से भली-भांति अवगत रहता है।
            इन भयंकर दुखों को देखने से ही मन में सच्चा वैराग्य पैदा होता है।
            इसके बाद वह भौतिक आकर्षणों के पीछे फालतू भागना बंद कर देता है।
            शरीर की इस नश्वरता को स्वीकार करना ही दुनिया की सबसे बड़ी बुद्धिमानी है।
            यह विशिष्ट गुण इंसान के झूठे घमंड को हमेशा के लिए जड़ से मिटा देता है।
            यह हमारे अस्तित्व की वास्तविक समस्याओं का अत्यंत वैज्ञानिक विश्लेषण है।
        """.trimIndent(),
        english = """
            Developing intense detachment from objects of sense pleasure is key.
            It requires the absolute absence of pride or a Zero Ego status.
            A wise man constantly remembers the four brutal truths of life.
            He maintains a deep perception of birth, death, old age, and disease.
            He is highly aware of the strictly temporary nature of reality.
            Perceiving these inevitable miseries creates a healthy detachment.
            It causes the immediate cessation of chasing worthless material distractions.
            Accepting bodily mortality is recognized as the height of wisdom.
            This specific quality completely uproots toxic arrogance from the mind.
            It provides a flawless scientific analysis of the actual problems of existence.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            असक्तिरनभिष्वङ्गः पुत्रदारगृहादिषु |
            नित्यं च समचित्तत्वमिष्टानिष्टोपपत्तिषु || १० ||
        """.trimIndent(),
        hindi = """
            ज्ञानी को परिवार और घर में अत्यधिक मोह या आसक्ति नहीं होती।
            वह पुत्र और पत्नी के प्रति अपनी इमोशनल डिपेंडेंसी को पूरी तरह त्याग देता है।
            इसका मतलब प्रेम का त्याग नहीं, बल्कि केवल आसक्ति का त्याग है।
            वह अपनी खुशी के लिए कभी दूसरों पर बोझ बनकर नहीं जीता।
            अच्छी या बुरी घटना होने पर उसका मन हमेशा एक समान रहता है।
            वह बिज़नेस के भारी लाभ और नुकसान में भी मानसिक संतुलन बनाए रखता है।
            वह भयंकर दुःख में टूटता नहीं और सुख मिलने पर पागलों की तरह उछलता नहीं।
            वह अपने चित्त को हर परिस्थिति में हमेशा शांत और बैलेंस रखता है।
            ज्ञानी व्यक्ति गहराई से जानता है कि इस दुनिया में सब कुछ अस्थायी है।
            यह रिश्तों और संपत्ति के प्रति एक बहुत ही स्वस्थ मनोवैज्ञानिक दृष्टिकोण है।
        """.trimIndent(),
        english = """
            A wise man lacks possessive attachment to his family and home.
            He achieves freedom from emotional dependency on his spouse or children.
            This is absolutely not the end of love, but the end of toxic clinginess.
            He avoids burdening others for his own psychological validation.
            He maintains perfect mental equilibrium amid all pleasant and unpleasant events.
            He keeps absolute balance of mind during both massive gain and crushing loss.
            He does not break down in sorrow or become wildly arrogant in joy.
            He keeps his consciousness perpetually calm and fundamentally steady.
            The wise scientifically know that all earthly bonds are strictly temporary.
            This forms a profoundly healthy psychological approach to relationships.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            मयि चानन्ययोगेन भक्तिरव्यभिचारिणी |
            विविक्तदेशसेवित्वमरतिर्जनसंसदि || ११ ||
        """.trimIndent(),
        hindi = """
            भगवान में अटूट और बिल्कुल शुद्ध भक्ति का होना सबसे बड़ा ज्ञान है।
            बिना किसी स्वार्थ के केवल ईश्वर से अनन्य प्रेम करना ही भक्ति है।
            भक्ति के बिना दुनिया का सारा ज्ञान पूरी तरह अधूरा और सूखा है।
            ज्ञानी को एकांत और शांत स्थानों में रहने की बहुत गहरी रुचि होती है।
            वह भीड़-भाड़ और दुनिया के शोर-शराबे से हमेशा खुद को दूर रखता है।
            वह फालतू की सोशल गपशप और पार्टियों में अपना समय नष्ट नहीं करता।
            आत्म-चिंतन के लिए वह एकांत यानी सोलीट्यूड को खुशी से अपनाता है।
            ईश्वर से जुड़ने के लिए बाहरी शोर को बंद करना बहुत आवश्यक होता है।
            आम संसारी और लालची लोगों की संगति में उसे बिल्कुल अरुचि होती है।
            यह एक उच्च स्तरीय और श्रेष्ठ आध्यात्मिक जीवन का सबसे स्पष्ट लक्षण है।
        """.trimIndent(),
        english = """
            Having unswerving and completely pure devotion to God is essential.
            Loving the Divine entirely without any selfish motives is true Bhakti.
            Without pure devotion, all academic knowledge is dry and incomplete.
            A wise man develops a strong preference for solitary, quiet places.
            He intentionally stays away from chaotic crowds and worldly noise.
            He absolutely does not waste time in mindless social chatter or parties.
            He gladly embraces Solitude for deep and uninterrupted self-reflection.
            Silencing external noise is necessary to effectively connect with the Lord.
            He feels a natural detachment from the general mass of materialistic people.
            This is a clear, undeniable symptom of an elevated spiritual life.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            अध्यात्मज्ञाननित्यत्वं तत्त्वज्ञानार्थदर्शनम् |
            एतज्ज्ञानमिति प्रोक्तमज्ञानं यदतोऽन्यथा || १२ ||
        """.trimIndent(),
        hindi = """
            आध्यात्मिक ज्ञान में हमेशा टिके रहना ही सबसे बड़ी बुद्धिमानी है।
            परम सत्य के दर्शन को ही अपने जीवन का अंतिम लक्ष्य मानना चाहिए।
            अपनी आत्मा को जानना ही दुनिया की सारी शिक्षा का असली निचोड़ है।
            इसके अलावा संसार में जो कुछ भी है, वह सब अज्ञान की श्रेणी में आता है।
            भगवान ने यहाँ ज्ञान और अज्ञान के बीच एक अत्यंत सख्त रेखा खींच दी है।
            केवल सूचनाओं का ढेर इकट्ठा करना कभी सच्ची बुद्धिमानी नहीं हो सकती।
            वह ज्ञान पूरी तरह व्यर्थ है जो इंसान को जन्म-मरण से मुक्त न कर सके।
            आत्म-साक्षात्कार ही मनुष्य की सर्वोच्च और पहली प्राथमिकता होनी चाहिए।
            ज्ञान के बीस लक्षणों की यह महान और पवित्र सूची यहीं पर समाप्त होती है।
            असली अज्ञानता वह है जो हमारी अमर आत्मा को पूरी तरह अनदेखा कर देती है।
        """.trimIndent(),
        english = """
            Remaining constantly situated in spiritual knowledge is true intelligence.
            Viewing self-realization as the ultimate life goal is absolutely mandatory.
            Knowing the eternal soul is the core essence of all valid education.
            Everything outside this pursuit is officially classified as Ignorance.
            The Lord draws a strict, uncompromising line defining true wisdom.
            Merely collecting material data is absolutely not true intelligence.
            Knowledge that fails to liberate the soul is ultimately useless.
            Self-realization must always be the absolute highest human priority.
            This concludes the majestic and powerful list of twenty symptoms.
            Ignorance is officially defined as completely ignoring the eternal soul.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            ज्ञेयं यत्तत्प्रवक्ष्यामि यज्ज्ञात्वामृतमश्नुते |
            अनादिमत्परं ब्रह्म न सत्तन्नासदुच्यते || १३ ||
        """.trimIndent(),
        hindi = """
            अब भगवान उस ईश्वर का वर्णन करेंगे जिसे वास्तव में जानना चाहिए।
            उस परम सत्य को जानकर मनुष्य अमरता यानी अमृत को प्राप्त हो जाता है।
            वह अनादि परब्रह्म है जिसकी न कोई शुरुआत है और न ही कोई अंत है।
            उसे सत् या असत् जैसे सीमित सांसारिक शब्दों में नहीं बाँधा जा सकता।
            वह भौतिक तर्क, विज्ञान और इंसानी भाषा से पूरी तरह परे स्थित है।
            मृत्यु का भयंकर भय इस ज्ञान को पाते ही हमेशा के लिए मिट जाता है।
            ईश्वर ही हमारे ज्ञान और बुद्धिमानी का सबसे अंतिम और सच्चा विषय है।
            यह ज्ञान हमारी आत्मा को एक शाश्वत और न टूटने वाली शांति प्रदान करता है।
            परमेश्वर का स्वरूप अत्यंत रहस्यमयी और दुनिया की सोच से बहुत महान है।
            जानने योग्य परम सत्य की आधिकारिक और स्पष्ट व्याख्या यहाँ से शुरू होती है।
        """.trimIndent(),
        english = """
            Now the Lord describes God, the ultimate Object of Knowledge.
            Knowing Him flawlessly allows one to taste the elixir of immortality.
            He is the Beginningless Brahman, existing eternally without start or end.
            He cannot be limited by binary terms like existence or non-existence.
            He completely transcends all material logic and human vocabulary.
            The paralyzing fear of death is permanently deleted by this truth.
            God is the final, absolute subject of all investigative intelligence.
            This specific knowledge provides unshakeable, eternal peace to the soul.
            The nature of the Supreme is mystically vast and immensely great.
            The official explanation of the ultimate Knowable entity begins here.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            सर्वतः पाणिपादं तत्सर्वतोऽक्षिशिरोमुखम् |
            सर्वतः श्रुतिमल्लोके सर्वमावृत्य तिष्ठति || १४ ||
        """.trimIndent(),
        hindi = """
            उस परमात्मा के हाथ और पैर ब्रह्मांड में हर जगह फैले हुए हैं।
            उनकी आँखें, सिर और मुँह चारों दिशाओं में एक साथ मौजूद हैं।
            वे ब्रह्मांड की हर एक छोटी-बड़ी आवाज़ को बहुत स्पष्ट सुनते हैं।
            वे इस पूरी सृष्टि को हर ओर से घेर कर और व्याप्त होकर बैठे हैं।
            यह ईश्वर की सर्वव्यापकता का एक अत्यंत साक्षात् और भव्य वर्णन है।
            भगवान कोई सीमित या किसी एक जगह रहने वाले साधारण व्यक्ति नहीं हैं।
            वे पूरे ब्रह्मांड को चलाने वाली यूनिवर्सल कॉन्शियसनेस या परम चेतना हैं।
            आप कभी भी अकेले नहीं हैं, वे हर पल आपको देख और सुन रहे हैं।
            ब्रह्मांड के एक-एक कण में उनकी शक्तिशाली उपस्थिति हमेशा मौजूद है।
            वे सब कुछ जानते हैं और हर जगह बिना किसी रुकावट के स्थित हैं।
        """.trimIndent(),
        english = """
            The Supersoul's hands and feet are physically and spiritually everywhere.
            His eyes, heads, and faces point simultaneously in all directions.
            He clearly hears every microscopic vibration and sound in the universe.
            He exists by thoroughly pervading and encompassing everything.
            This describes the absolute and terrifying Omnipresence of God.
            The Lord is absolutely not a restricted or localized physical entity.
            He is the Universal Consciousness actively operating the entire matrix.
            You are never alone; He is witnessing every second of your existence.
            His presence is densely saturated in every single atom of the cosmos.
            He flawlessly knows everything and is permanently situated everywhere.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            सर्वेन्द्रियगुणाभासं सर्वेन्द्रियविवर्जितम् |
            असक्तं सर्वभृच्चैव निर्गुणं गुणभोक्तृ च || १५ ||
        """.trimIndent(),
        hindi = """
            भगवान इन्द्रियों के बिना भी दुनिया का सब कुछ स्पष्ट रूप से जानते हैं।
            उनके पास हमारे जैसे हाड़-मांस के भौतिक अंग बिल्कुल नहीं होते हैं।
            वे पूरी तरह अनासक्त होकर बिना किसी स्वार्थ के दुनिया को पालते हैं।
            वे प्रकृति के तीनों गुणों यानी सत्त्व, रज और तम से पूरी तरह परे हैं।
            फिर भी वे ही इन सभी गुणों का वास्तविक आनंद लेने वाले परम स्वामी हैं।
            यह ईश्वर के अस्तित्व का एक अद्भुत और मैजिकल पैराडॉक्स कहलाता है।
            वे किसी चीज़ से चिपकते नहीं हैं, फिर भी वे सबका मजबूत आधार हैं।
            इस पूरी सृष्टि का खर्चा और मेंटेनेंस वही अपनी इच्छा से उठा रहे हैं।
            वे इन्द्रियों के स्रोत जरूर हैं, पर वे इन्द्रियों के गुलाम बिल्कुल नहीं हैं।
            उनकी शक्ति और उनका स्वरूप अत्यंत दिव्य, पवित्र और अलौकिक है।
        """.trimIndent(),
        english = """
            God knows everything flawlessly even without having physical senses.
            He does not possess biological organs or flesh like mortal beings.
            He sustains the entire world while remaining one hundred percent detached.
            He is Nirguna, completely transcending all three material modes.
            Yet simultaneously, He is the ultimate master and enjoyer of all qualities.
            This is the mind-bending Magical Paradox of the Divine nature.
            He doesn't cling to anything, yet He perfectly supports everything.
            He provides all the daily maintenance for every creature in existence.
            He is the source of all senses but is absolutely never their slave.
            His power and form are entirely transcendental and supremely divine.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            बहिरन्तश्च भूतानामचरं चरमेव च |
            सूक्ष्मत्वात्तदविज्ञेयं दूरस्थं चान्तिके च तत् || १६ ||
        """.trimIndent(),
        hindi = """
            परमात्मा हर एक प्राणी के बाहर भी हैं और उनके हृदय के अंदर भी हैं।
            वे स्थिर पहाड़ों में भी हैं और चलने वाले जीवों में भी समान रूप से हैं।
            वे इतने सूक्ष्म हैं कि उन्हें तर्क या विज्ञान से कभी नहीं पकड़ा जा सकता।
            अज्ञानी मनुष्यों के लिए वे हमेशा करोड़ों मील दूर महसूस होते हैं।
            लेकिन एक सच्चे भक्त के लिए वे उसके दिल के सबसे नज़दीक बैठे हैं।
            भगवान की यह दूरी पूरी तरह से हमारी अपनी चेतना पर निर्भर करती है।
            वे भौतिक इन्द्रियों और मशीनों की पहुँच से पूरी तरह बाहर स्थित हैं।
            उन्हें केवल शुद्ध प्रेम और निर्मल मन के द्वारा ही महसूस किया जा सकता है।
            वे सर्वव्यापी होकर भी दुनिया के लिए अत्यंत रहस्यमयी बने रहते हैं।
            सत्य हर जगह मौजूद है पर बिना दिव्य दृष्टि के वह दिखाई नहीं देता।
        """.trimIndent(),
        english = """
            The Supersoul is simultaneously both inside and outside all beings.
            He exists equally in the moving creatures and the non-moving structures.
            He is so incredibly subtle that He is beyond logical or scientific capture.
            To the ignorant and cynical, He appears to be light-years away.
            To the pure devotee, He is the closest, most intimate heart-resident.
            God's perceived distance depends strictly on our own consciousness.
            He is completely beyond the processing reach of material senses.
            He can only be genuinely experienced through love and internal purity.
            He is omnipresent yet remains deeply mysterious to the ordinary mind.
            Truth is present everywhere but remains completely invisible to many.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            अविभक्तं च भूतेषु विभक्तमिव च स्थितम् |
            भूतभर्तृ च तज्ज्ञेयं ग्रसिष्णु प्रभविष्णु च || १७ ||
        """.trimIndent(),
        hindi = """
            परमात्मा एक है, पर वह सभी जीवों में अलग-अलग बँटा हुआ सा दिखता है।
            जैसे एक ही आकाश अलग-अलग कमरों की खिड़कियों से अलग-अलग दिखता है।
            वही एक ईश्वर हर एक जीव का पालन-पोषण करने वाला सच्चा रक्षक है।
            मृत्यु के समय वही भयंकर रूप लेकर सब कुछ अपने भीतर निगल लेता है।
            और सृष्टि के समय वही दोबारा सबको नए सिरे से पैदा भी करता है।
            वे अविभाजित होकर भी इस मैट्रिक्स में खंडित और बँटे हुए से प्रतीत होते हैं।
            ईश्वर ही इस ब्रह्मांड का एकमात्र सस्टेनर और अंतिम विनाशक भी है।
            हमें इस बाहरी विविधता के पीछे छिपी हुई उस शाश्वत एकता को पहचानना होगा।
            आपकी हर एक साँस और धड़कन उन्हीं के कठोर नियंत्रण में चल रही है।
            यहाँ भगवान के पालन, सृजन और संहार करने वाले तीनों रूपों का वर्णन है।
        """.trimIndent(),
        english = """
            The Supersoul is one, but appears divided among all living entities.
            It is like one continuous sky viewed through thousands of windows.
            The exact same God is the absolute sustainer of every single life.
            At the time of death, He violently devours everything in existence.
            At the time of creation, He actively develops and manifests all forms.
            He is undivided yet mysteriously appears fragmented in the matrix.
            God is the absolute sole sustainer and the ultimate destroyer.
            One must train their vision to perceive the unity behind the diversity.
            Every single breath and heartbeat operates strictly under His sanction.
            This describes God's complete monopoly over creation and annihilation.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            ज्योतिषामपि तज्ज्योतिस्तमसः परमुच्यते |
            ज्ञानं ज्ञेयं ज्ञानगम्यं हृदि सर्वस्य विष्ठितम् || १८ ||
        """.trimIndent(),
        hindi = """
            वे सूरज और चाँद जैसे सभी महान प्रकाशों के भी परम प्रकाश माने गए हैं।
            वे अज्ञान के घने अंधेरे यानी तमस से पूरी तरह परे और बहुत ऊपर हैं।
            वे साक्षात् ज्ञान का स्वरूप हैं और ज्ञान का सबसे अंतिम लक्ष्य भी वही हैं।
            वे कहीं आसमान में नहीं, बल्कि सबके दिल में अभी इसी वक्त बैठे हुए हैं।
            वे कोई दूर की काल्पनिक कथा नहीं, बल्कि एक ठोस और जीवंत हकीकत हैं।
            शुद्ध बुद्धि और निर्मल प्रेम के द्वारा ही उन्हें आसानी से पाया जा सकता है।
            वे प्रकाश के मूल स्रोत हैं पर स्वयं कभी भौतिक ताप से नहीं जलते हैं।
            माया का घना अंधकार उनके इस दिव्य तेज को कभी छू भी नहीं सकता है।
            आपके भीतर बैठी यह महान शक्ति ही वह असली और सनातन ईश्वर है।
            परमात्मा की स्थिति और उनकी अपार महिमा का यह सबसे अंतिम सत्य है।
        """.trimIndent(),
        english = """
            He is the Light of all Lights, shining infinitely brighter than the sun.
            He is situated far beyond the toxic darkness of material ignorance.
            He is knowledge itself, its ultimate object, and its absolute final goal.
            He is physically and spiritually seated right inside everyone's heart.
            He is not a distant myth, but a breathing, operational physical reality.
            He can be reached exclusively through purified intelligence and love.
            He is the source of light but remains completely unaffected by heat.
            The darkness of Maya can absolutely never touch His blinding brilliance.
            The immense power seated within you is the literal, Supreme Godhead.
            This provides the final truth regarding the location and glory of God.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            इति क्षेत्रं तथा ज्ञानं ज्ञेयं चोक्तं समासतः |
            मद्भक्त एतद्विज्ञाय मद्भावायोपपद्यते || १९ ||
        """.trimIndent(),
        hindi = """
            इस प्रकार शरीर, ज्ञान और ईश्वर का वर्णन भगवान ने संक्षेप में पूरा कर दिया।
            भगवान ने बहुत ही कम शब्दों में पूरी आध्यात्मिक साइंस को समझा दिया है।
            परंतु केवल मेरा शुद्ध भक्त ही इस गहरे रहस्य को पूरी तरह समझ सकता है।
            इस ज्ञान को जानकर भक्त मेरे ही दिव्य ईश्वरीय स्वभाव को प्राप्त होता है।
            सच्ची भक्ति के बिना यह सारा ज्ञान केवल एक रूखी और बेजान थ्योरी है।
            जो इस सत्य को जान लेता है, उसका यह मनुष्य जन्म हमेशा के लिए सफल है।
            वह इस दुनिया के दुखों और जन्म-मरण के चक्र से हमेशा के लिए ऊपर उठता है।
            उसे भगवान के समान ही शाश्वत आनंद और शांति पाने की योग्यता मिल जाती है।
            यह मोक्ष की ओर ले जाने वाला एक अत्यंत स्पष्ट और सीधा रोडमैप है।
            ज्ञान और भक्ति के इस अद्भुत मिलन का निष्कर्ष यहाँ स्पष्ट रूप से दिया गया है।
        """.trimIndent(),
        english = """
            The description of the Field, Knowledge, and God is now complete.
            The Lord has concisely explained the entire spiritual science in summary.
            Only My pure devotees possess the capacity to understand this thoroughly.
            This exact wisdom allows the devotee to attain My transcendental nature.
            Without devotion, this profound knowledge remains a mere academic theory.
            One who successfully decodes this makes his human birth an absolute success.
            He eternally transcends the brutal miseries and cycles of the material world.
            He becomes officially eligible to taste divine, infinite godly bliss.
            This verse provides a crystal-clear, verified roadmap directly to liberation.
            It forms the ultimate conclusion of the union between knowledge and devotion.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            प्रकृतिं पुरुषं चैव विद्ध्यनादी उभावपि |
            विकारांश्च गुणांश्चैव विद्धि प्रकृतिसम्भवान् || २० ||
        """.trimIndent(),
        hindi = """
            भौतिक प्रकृति और जीवात्मा दोनों ही अनादि हैं और इनका कोई जन्म नहीं हुआ।
            ये दोनों ही भगवान की शक्तियां हैं जो हमेशा से अस्तित्व में रही हैं।
            शरीर में होने वाले सभी बदलाव और विकार केवल प्रकृति के कारण होते हैं।
            गुस्सा, लालच और तीनों गुण पूरी तरह से प्रकृति से ही पैदा होते हैं।
            हमारी आत्मा का इन विकारों से कोई लेना-देना या सीधा संबंध नहीं है।
            आत्मा हमेशा शुद्ध, पवित्र और अपरिवर्तनीय अवस्था में बनी रहती है।
            यह भौतिक पदार्थ और आध्यात्मिक ऊर्जा का एक बहुत वैज्ञानिक विश्लेषण है।
            हम अज्ञानतावश शरीर में होने वाली हलचल को अपनी आत्मा मान लेते हैं।
            प्रकृति अपना काम अपने बनाए हुए कड़े नियमों और सॉफ्टवेयर से करती है।
            आत्मा और प्रकृति के इन शाश्वत संबंधों का यह सबसे बड़ा रहस्य है।
        """.trimIndent(),
        english = """
            Both Material Nature and the living spirit are to be understood as beginningless.
            They were never biologically created; they have existed eternally.
            All physical transformations are caused entirely by Material Nature.
            Anger, greed, and the three modes are exclusively products of Nature.
            The soul has absolutely nothing to do with these emotional or physical shifts.
            The soul remains eternally pure, static, and completely transcendental.
            This represents a profound scientific analysis of matter versus spirit.
            We mistakenly identify with the body's fluctuations and biological pains.
            Nature executes its massive work according to its pre-installed software.
            This reveals the secret of the eternal bond between the soul and matter.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            कार्यकरणकर्तृत्वे हेतुः प्रकृतिरुच्यते |
            पुरुषः सुखदुःखानां भोक्तृत्वे हेतुरुच्यते || २१ ||
        """.trimIndent(),
        hindi = """
            शरीर के सभी भौतिक कार्यों का मुख्य कारण केवल भौतिक प्रकृति ही है।
            लेकिन आत्मा केवल उन कार्यों के सुख-दुःख को महसूस करने वाली सत्ता है।
            यह शरीर रूपी मशीन हमेशा प्रकृति के कड़े नियमों के अनुसार ही चलती है।
            आत्मा खुद को अज्ञानवश मशीन का मालिक मानकर बहुत बुरी तरह फँस जाती है।
            इस सुख-दुःख को महसूस करना ही हमारे सभी कर्मों और बंधनों की असली जड़ है।
            मैं यह काम कर रहा हूँ—यह अहंकार प्रकृति का दिया हुआ एक बड़ा भ्रम है।
            आत्मा वास्तव में कोई भी भौतिक या सांसारिक कार्य अपने हाथों से नहीं करती।
            हम शरीर के अनुभवों से अपनी पहचान जोड़कर खुद को बहुत दुखी कर लेते हैं।
            सुख-दुःख का अनुभव आत्मा की अज्ञानता और शरीर से जुड़ाव का परिणाम है।
            यहाँ कर्ता और भोक्ता के बीच का यह अत्यंत सूक्ष्म और जरूरी अंतर बताया गया है।
        """.trimIndent(),
        english = """
            Nature is officially the primary cause of all physical activities and effects.
            The soul is merely the cause of experiencing the resulting joy and pain.
            The biological machine operates autonomously according to physical laws.
            The soul gets heavily trapped by falsely identifying with the machine.
            Experiencing these outcomes is the fundamental root of our cosmic bondage.
            The idea that 'I am the doer' is a highly toxic delusion of material nature.
            The soul actually performs absolutely zero material labor in reality.
            We erroneously link our eternal identity to the body's temporary sensations.
            Joy and distress result purely from the soul's ignorance and attachment.
            This clearly defines the distinction between the Doer and the Experiencer.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            पुरुषः प्रकृतिस्थो हि भुङ्क्ते प्रकृतिजान्गुणान् |
            कारणं गुणसङ्गोऽस्य सदसद्योनिजन्मसु || २२ ||
        """.trimIndent(),
        hindi = """
            आत्मा प्रकृति में रहकर प्रकृति के गुणों का आनंद लेने की कोशिश करती है।
            इन सांसारिक गुणों से चिपकना ही हमारे बार-बार पुनर्जन्म का मुख्य कारण है।
            हमारा वर्तमान लगाव ही यह तय करता है कि हमें अगला शरीर कैसा मिलेगा।
            यही अच्छी या बुरी योनियों में जन्म लेने का सबसे बड़ा रहस्य और गणित है।
            आसक्ति हमें इस दुनिया के चक्कर में एक अदृश्य धागे से बाँधे रखती है।
            गुणों का यह भोग ही स्वतंत्र आत्मा को शरीर के पिंजरे में कैद कर देता है।
            आप जिससे सबसे अधिक प्रेम करेंगे, मृत्यु के बाद आप सीधा वहीं जाएंगे।
            यह कर्म और वासना का एक अत्यंत सटीक और कभी न टूटने वाला नियम है।
            जन्म का कारण भगवान नहीं, बल्कि हमारी अपनी पसंद और वासनाएं होती हैं।
            पुनर्जन्म की प्रक्रिया को समझने का यह सबसे आसान और सटीक सूत्र है।
        """.trimIndent(),
        english = """
            The soul attempts to heavily enjoy the three modes of material nature.
            Attachment to these modes causes the terrifying cycle of repeated rebirth.
            Our current psychological association strictly determines our next vessel.
            This is the secret behind taking birth in either elite or degraded species.
            Toxic clinginess keeps us perpetually trapped in the worldly cycle.
            Enjoying these material modes imprisons the free soul in biological flesh.
            You will go exactly to what you obsessively love after your physical death.
            This forms the mathematically precise law of karma and human desire.
            God is not the cause of our birth; our own misguided choices are.
            This represents the most accurate formula for the reincarnation process.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            उपद्रष्टाऽनुमन्ता च भर्ता भोक्ता महेश्वरः |
            परमात्मेति चाप्युक्तो देहेऽस्मिन्पुरुषः परः || २३ ||
        """.trimIndent(),
        hindi = """
            इस शरीर के अंदर एक दूसरा परम पुरुष भी है जिसे हम परमात्मा कहते हैं।
            वे हमारे भीतर केवल एक मूक उपद्रष्टा यानी साक्षी के रूप में बैठे हुए हैं।
            वे हमारे कर्मों को करने की अनुमति देने वाले और हमारे सबसे बड़े रक्षक हैं।
            वे शरीर में रहकर भी भौतिक गंदगी से पूरी तरह अछूते और पवित्र रहते हैं।
            परमात्मा हमारे हर गुप्त विचार और इरादे को बहुत स्पष्ट रूप से देख रहे हैं।
            जब हम कुछ करना चाहते हैं, तो वे कर्मों के अनुसार हमें मंजूरी दे देते हैं।
            वे हमारे सबसे अच्छे मित्र के रूप में हमारे हृदय के केंद्र में हमेशा स्थित हैं।
            आत्मा और परमात्मा एक ही शरीर रूपी पेड़ पर बैठे हुए दो अलग पक्षी हैं।
            वे हमारे कर्मों के भोक्ता और अंतिम न्यायाधीश के रूप में भी कार्य करते हैं।
            हृदय में ईश्वर की इस भव्य उपस्थिति का यह एक बहुत ही सुंदर वर्णन है।
        """.trimIndent(),
        english = """
            Another Supreme Person known as the Supersoul lives deep within the body.
            He acts primarily as the silent Overseer and the ultimate Permitter.
            He is the absolute sustainer, maintainer, and the supreme Master.
            He resides in the body but remains eternally untouched by its dirt.
            The Supersoul witnesses every single hidden thought and micro-event.
            When we desperately desire to act, He merely grants the cosmic Sanction.
            He sits permanently in the heart as our absolute best, well-wishing friend.
            The soul and Supersoul are exactly like two birds resting in one tree.
            He is the ultimate transcendental enjoyer and the supreme cosmic Judge.
            This provides a magnificent description of God's physical presence within.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            य एवं वेत्ति पुरुषं प्रकृतिं च गुणैः सह |
            सर्वथा वर्तमानोऽपि न भूयः सोऽभिजायते || २४ ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति आत्मा, प्रकृति और गुणों के इस सत्य को पूरी तरह जान लेता है।
            वह वर्तमान में चाहे किसी भी हाल में या किसी भी प्रोफेशन में क्यों न हो।
            उसका इस दुनिया में दोबारा कभी जन्म नहीं होता, वह मुक्त हो जाता है।
            यह अज्ञान की जंजीरों को हमेशा के लिए तोड़ने का एक गारंटी कार्ड है।
            सही ज्ञान इंसान को कर्मों के खतरनाक जाल से पूरी तरह आज़ाद करता है।
            वह जीते-जी भी अपने मन से पूरी तरह स्वतंत्र और शांतिपूर्ण महसूस करता है।
            मौत अब उसके लिए कोई डरावना अंत नहीं, बल्कि भगवान तक जाने का द्वार है।
            उसे फिर कभी किसी माँ के गर्भ में उल्टा लटकने के लिए नहीं आना पड़ेगा।
            संसार की इस मैट्रिक्स से बाहर निकलने का यह सबसे अंतिम और पक्का सूत्र है।
            मोक्ष और ईश्वर प्राप्ति का यह भगवान की तरफ से दिया गया पक्का आश्वासन है।
        """.trimIndent(),
        english = """
            One who thoroughly knows the truth of the soul, nature, and the modes.
            Regardless of his present material circumstances or social status.
            He will absolutely never be forced to take birth in this world again.
            This acts as the ultimate Guarantee Card for breaking human ignorance.
            True knowledge effortlessly liberates one from the sticky web of karma.
            He feels 100% Free and detached even while physically alive in the body.
            Death becomes merely a formal gateway to eternity for him, not an end.
            He will never have to painfully enter a biological womb ever again.
            This is the ultimate, precise code required to successfully exit the Matrix.
            It is a definitive, signed assurance of attaining Moksha and the Godhead.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            ध्यानेनात्मनि पश्यन्ति केचिदात्मानमात्मना |
            अन्ये साङ्ख्येन योगेन कर्मयोगेन चापरे || २५ ||
        """.trimIndent(),
        hindi = """
            कुछ लोग ध्यान योग के द्वारा ईश्वर को अपने हृदय के भीतर ही देखते हैं।
            कुछ लोग ज्ञान योग के द्वारा चिंतन करके उस परम सत्य तक पहुँच जाते हैं।
            और कुछ अन्य लोग निष्काम कर्मयोग से समाज की सेवा करके ईश्वर को पाते हैं।
            ईश्वर तक जाने के ये तीन मुख्य सुपर-हाइवे भगवान ने यहाँ स्पष्ट किए हैं।
            हर इंसान की मानसिक बनावट और उसकी रुचि एक दूसरे से बहुत अलग होती है।
            ध्यान योग मन की एक्सट्रीम एकाग्रता का एक बहुत कठिन लेकिन सच्चा रास्ता है।
            ज्ञान योग अपनी बुद्धि और तर्क के द्वारा सृष्टि का विश्लेषण करने का मार्ग है।
            कर्मयोग समाज में रहकर बिना स्वार्थ के अपनी ड्यूटी करने का आसान रास्ता है।
            इन तीनों रास्तों की आखिरी मंजिल केवल एक ही है, और वह है परमेश्वर।
            आध्यात्मिक विकास के इन विभिन्न विकल्पों का यह बहुत ही सुंदर वर्णन है।
        """.trimIndent(),
        english = """
            Some perceive God within themselves through the intensity of deep meditation.
            Some reach the absolute truth through analytical knowledge and deep study.
            Others attain the Supreme by executing work without fruitive desires.
            The three primary Super-Highways leading to God are clearly identified here.
            Every human possesses a completely different mental makeup and taste.
            Dhyana-yoga is the severe and rigorous path of intense inward concentration.
            Jnana-yoga is the highly intellectual path of analytical logic and philosophy.
            Karma-yoga is the practical path of selfless social duty and pure service.
            All three legitimate roads ultimately lead to the exact same Supreme Destination.
            This provides a beautiful description of various options for spiritual evolution.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            अन्ये त्वेवमजानन्तः श्रुत्वान्येभ्य उपासते |
            तेऽपि चातितरन्त्येव मृत्युं श्रुतिपरायणाः || २६ ||
        """.trimIndent(),
        hindi = """
            जो लोग खुद ज्ञानी नहीं हैं, उनके लिए भी मोक्ष का दरवाज़ा हमेशा खुला है।
            वे केवल महापुरुषों से सुनकर और उन पर विश्वास करके ही भक्ति करते हैं।
            केवल सुनने में सच्ची निष्ठा रखने वाले भी मृत्यु के सागर को पार कर जाते हैं।
            यह उन साधारण लोगों के लिए बहुत बड़ी आशा है जो ज्यादा बुद्धिमान नहीं हैं।
            सुनने की यह शक्ति ही इंसान को मौत के खौफनाक समंदर से पार करा देती है।
            सच्चे गुरु के वचनों में आपकी अटूट श्रद्धा और पूरा विश्वास होना चाहिए।
            सुनने मात्र से ही हृदय पूरी तरह शुद्ध होता है और सारा अज्ञान मिट जाता है।
            भक्ति का यह सबसे सरल, सुलभ और अत्यंत प्रभावशाली तरीका माना गया है।
            श्रुति यानी सुनना ही आध्यात्मिक ज्ञान और मोक्ष का पहला प्रवेश द्वार है।
            मोक्ष पाने के लिए भारी डिग्रियां या पांडित्य का होना बिल्कुल अनिवार्य नहीं है।
        """.trimIndent(),
        english = """
            The path is wide open even for those who are not elite scholars or yogis.
            They worship God simply by Hearing about Him from trusted authorities.
            Those faithful to hearing alone also flawlessly transcend birth and death.
            This serves as a spectacular message of hope for the less intellectually inclined.
            The immense power of listening safely carries one across the ocean of death.
            One must possess absolute, titanium faith in the words of a genuine Master.
            Hearing actively purifies the heart and permanently kills all ignorance.
            This is officially recognized as the simplest and most potent method of Bhakti.
            Shruti or Hearing acts as the primary entrance gate to transcendental wisdom.
            Intellectual brilliance or massive degrees are absolutely not mandatory for Moksha.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            यावत्सञ्जायते किञ्चित्सत्त्वं स्थावरजङ्गमम् |
            क्षेत्रक्षेत्रज्ञसंयोगात्तद्विद्धि भरतर्षभ || २७ ||
        """.trimIndent(),
        hindi = """
            इस भौतिक दुनिया में जो कुछ भी पैदा होता है वह केवल एक मिश्रण होता है।
            जड़ शरीर और चेतन आत्मा के मिलन से ही यह जीवन और अस्तित्व बनता है।
            बिना आत्मा के यह पूरा ब्रह्मांड केवल एक मृत और ठंडी मशीन के समान है।
            और बिना शरीर के आत्मा इस भौतिक दुनिया में कोई भी काम नहीं कर सकती।
            हर एक प्राणी वास्तव में एक इलेक्ट्रो-मैकेनिकल हाइब्रिड सत्ता का ही रूप है।
            पेड़, इंसान, जानवर—ये सब क्षेत्र और क्षेत्रज्ञ के जुड़ने का ही सीधा परिणाम हैं।
            हे अर्जुन! जीवन की इस बुनियादी और सबसे अहम सच्चाई को तुम जान लो।
            जीवन वास्तव में आत्मा और पदार्थ का एक बहुत ही अस्थायी और छोटा विवाह है।
            सृष्टि का हर एक कण इसी संयोग के द्वारा काम कर रहा है और संचालित है।
            जैविक जीवन के निर्माण का यह सबसे सटीक और वैज्ञानिक आधार बताया गया है।
        """.trimIndent(),
        english = """
            Everything that is born in this world is strictly a hybrid combination.
            Life is the explicit union of dead Matter and highly conscious Spirit.
            Without the soul, the universe is just a cold, dark, and dead machine.
            Without the body, the soul absolutely cannot act within this dimension.
            Every creature is effectively an Electro-Mechanical hybrid biological entity.
            Trees, humans, and animals are all sums of the Field and its Knower.
            Chief of Bharatas! Know this foundational and absolute cosmic reality.
            Life is officially defined as a temporary marriage of spirit and matter.
            Every single atom in creation operates efficiently via this combination.
            This reveals the flawless scientific basis of how biological life is constructed.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            समं सर्वेषु भूतेषु तिष्ठन्तं परमेश्वरम् |
            विनश्यत्सु अविनश्यन्तं यः पश्यति स पश्यति || २८ ||
        """.trimIndent(),
        hindi = """
            असली विज़न वह है जो सबमें एक समान रूप से बैठे ईश्वर को साक्षात् देखे।
            शरीर रोज़ मरता है और सड़ता है पर उसके अंदर का परमात्मा कभी नहीं मरता।
            जो इंसान नाशवान शरीर में भी अमर तत्व को देख ले, वही सच्चा ज्ञानी है।
            बाहरी भेदभाव को मिटाकर केवल आत्मा की रोशनी को देखना ही परम सत्य है।
            हर शरीर के भीतर भगवान एक खामोश साक्षी और मित्र बनकर हमेशा बैठे हैं।
            मौत केवल भौतिक हार्डवेयर का अंत है, यह सॉफ्टवेयर का अंत बिल्कुल नहीं है।
            ज्ञानी को मरते हुए इंसान में भी वह अविनाशी तत्व बिल्कुल साफ दिखाई देता है।
            यह समभाव ही आध्यात्मिक उन्नति और मोक्ष की पहली और सबसे बड़ी सीढ़ी है।
            दुनिया को चमड़ी से नहीं, बल्कि आत्मा की नज़रों से देखना शुरू करना चाहिए।
            यह ईश्वर की अविनाशी और सर्वव्यापी उपस्थिति का सबसे साक्षात् प्रमाण है।
        """.trimIndent(),
        english = """
            Real Vision is officially defined as seeing the same God equally in everyone.
            The body perishes, but the Supersoul residing within absolutely never dies.
            One who clearly sees the Immortal within the Mortal is genuinely wise.
            Deleting superficial bias to see the underlying soul is the Ultimate Truth.
            God sits as the eternal, non-flickering witness inside every physical form.
            Death is strictly the end of the hardware, never the transcendental software.
            A sage perceives the Indestructible spirit even within a dying biological body.
            This equanimity is the essential first step toward total spiritual growth.
            Start viewing the world through the lens of the soul, not the biological skin.
            This provides direct proof of the imperishable, eternal presence of God.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            समं पश्यन्हि सर्वत्र समवस्थितमीश्वरम् |
            न हिनस्त्यात्मनात्मानं ततो याति परां गतिम् || २९ ||
        """.trimIndent(),
        hindi = """
            जो इंसान सब जगह एक समान रूप से स्थित ईश्वर को अपनी आँखों से देखता है।
            वह कभी भी किसी दूसरे प्राणी को अपनी बातों या कामों से दुःख नहीं पहुँचाता।
            दूसरों को बुरा कहना या मारना अपने ही अंदर के ईश्वर का सीधा अपमान है।
            वह अपनी आत्मा का पतन या नुकसान कभी भी किसी भी हालत में नहीं होने देता।
            ऐसी सोच रखने वाला व्यक्ति सीधा मोक्ष और परम शांति को प्राप्त होता है।
            सार्वभौमिक सम्मान और प्यार ही परम गति तक जाने का इकलौता रास्ता है।
            घृणा और नफरत हमारी अज्ञानता और मानसिक अंधेरे का सबसे बड़ा सबूत हैं।
            परमेश्वर को हर चेहरे में देखना ही इस दुनिया की सबसे बड़ी और असली पूजा है।
            मन की सच्ची शांति इसी समानता और प्रेम के भाव से इंसान के भीतर आती है।
            यह अहिंसा और करुणा का सबसे बड़ा और सर्वोच्च आध्यात्मिक आधार माना गया है।
        """.trimIndent(),
        english = """
            One who actively sees God equally present in every single physical location.
            He absolutely never brings distress, pain, or harm to any living entity.
            To abuse others is to directly insult the Supreme God residing within oneself.
            He resolutely does not allow his own soul to degrade or violently fall.
            Such a highly elevated human directly attains the supreme cosmic destination.
            Universal respect is the absolute only road to achieving absolute freedom.
            Hatred and malice are the greatest proofs of ignorance and internal blindness.
            Seeing the Lord in every single biological face is the highest form of worship.
            Unshakeable peace of mind naturally results from this sense of equality.
            This forms the ultimate spiritual foundation of nonviolence and compassion.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            प्रकृत्यैव च कर्माणि क्रियमाणानी सर्वशः |
            यः पश्यति तथात्मानमकर्तारं स पश्यति || ३० ||
        """.trimIndent(),
        hindi = """
            संसार के सभी काम पूरी तरह से प्रकृति की शक्तियों द्वारा ही किए जाते हैं।
            आत्मा वास्तव में अकर्ता है, वह भौतिक रूप से कोई भी काम नहीं करती है।
            यह अहंकार और कर्तापन के भाव को जड़ से मिटाने का सबसे बड़ा सूत्र है।
            हाथ, पैर और इन्द्रियां शरीर के जैविक नियमों के अनुसार ही चलती हैं।
            आत्मा केवल शांत होकर इस पूरे जीवन के ड्रामे को एक दर्शक की तरह देख रही है।
            जब आप यह कर्तापन छोड़ते हैं, तो आपके कर्म के सारे बंधन अपने-आप टूटते हैं।
            हम व्यर्थ ही अपनी मेहनत और सफलता का झूठा घमंड अपने मन में पाल लेते हैं।
            प्रकृति एक मशीन है और आत्मा केवल उसकी शांत और अछूती ड्राइवर है।
            जो इस रहस्य को समझ गया, उसे किसी भी कर्म का पाप कभी नहीं लगता।
            असली एक्शन का यह वैज्ञानिक और आध्यात्मिक सच इंसान को आज़ाद करता है।
        """.trimIndent(),
        english = """
            All universal activities are executed strictly by the forces of Nature.
            The soul is actually a Non-doer and performs absolutely zero material labor.
            This is the master formula to permanently dissolve the toxic, inflated ego.
            Hands, feet, and senses move strictly via biological laws and chemical codes.
            The soul is merely watching this 3D drama in absolute, undisturbed silence.
            Dropping the toxic Doership permanently shatters the chains of heavy karma.
            We pointlessly nourish arrogance over our physical labor and achievements.
            Nature is the complex machine; the soul is merely the conscious driver.
            One who flawlessly decodes this secret incurs zero sinful or pious reactions.
            This reveals the ultimate scientific and spiritual truth behind all Action.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            यदा भूतपृथग्भावमेकस्थमनुपश्यति |
            तत एव च विस्तारं ब्रह्म सम्पद्यते तदा || ३१ ||
        """.trimIndent(),
        hindi = """
            सब प्राणी अलग-अलग दिखते हैं पर वे वास्तव में एक ही स्रोत से निकले हैं।
            जब यह विविधता के पीछे की एकता इंसान को दिख जाए, तो उसकी सिद्धि पूरी है।
            जैसे हज़ारों लहरें अलग-अलग दिखती हैं पर वे सब एक ही समंदर का हिस्सा हैं।
            सारा ब्रह्मांड श्रीकृष्ण के ही असीम संकल्प का एक विशाल विस्तार मात्र है।
            जब इंसान इस एकता को देख लेता है, तो वह सीधा ब्रह्म के स्तर पर पहुँच जाता है।
            भेदभाव करना ही असली अज्ञान है, और एकता देखना ही परम ज्ञान की चोटी है।
            सभी जीव एक ही ईश्वरीय चेतना के अलग-अलग रूप और जैविक कंटेनर हैं।
            यह महसूस करना ही भक्ति की पूर्णता है और यही मोक्ष का असली अर्थ है।
            दृश्य जगत की अनेकता के पीछे छिपी हुई यह शाश्वत अखंडता सबसे बड़ी सच्चाई है।
            पूर्ण ईश्वर-साक्षात्कार का यह एक बहुत ही गहरा और मनोवैज्ञानिक वर्णन है।
        """.trimIndent(),
        english = """
            Entities look distinct but share a singular, absolute divine source.
            Perceiving unity behind material diversity is the definition of perfection.
            Like thousands of waves that look different but belong to the one ocean.
            The entire cosmos is a magnificent expansion of Krishna's supreme will.
            When one successfully sees this Oneness, he attains the Brahman conception.
            Discrimination is ignorance; recognizing unity is supreme cosmic wisdom.
            All beings are just different forms of the exact same divine light.
            Realizing this profoundly is the absolute culmination of Bhakti and Moksha.
            The eternal integrity hidden behind the manifold world is the ultimate target.
            This provides a staggering psychological description of full God-realization.
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            अनादित्वान्निर्गुणत्वात्परमात्मायमव्ययः |
            शरीरस्थोऽपि कौन्तेय न करोति न लिप्यते || ३२ ||
        """.trimIndent(),
        hindi = """
            आत्मा अनादि है और प्रकृति के तीनों गुणों से पूरी तरह परे स्थित है।
            यह अविनाशी परमात्मा शरीर में रहकर भी वास्तव में कुछ भी नहीं करता।
            आत्मा कभी भी कर्मों के फल से लिप्त या गंदी नहीं होती, वह हमेशा शुद्ध है।
            यह शरीर रूपी पिंजरे में एक पूरी तरह अछूता और स्वतंत्र कैदी है।
            शरीर चाहे पाप करे या पुण्य, उसके अंदर की आत्मा हमेशा पवित्र ही रहती है।
            आत्मा का मूल स्वभाव सच्चिदानंद है, जो समय के साथ कभी नहीं बदलता है।
            हम आत्मा को शरीर की क्रियाओं से जोड़कर बहुत बड़ी बेवकूफी करते हैं।
            यह हमारी शाश्वत शुद्धता का सबसे बड़ा और सबसे पक्का आध्यात्मिक प्रमाण है।
            हे कौन्तेय! आत्मा हमेशा इस संसार के कीचड़ में रहकर भी निर्लिप्त रहती है।
            शरीर और आत्मा की अलग-अलग प्रकृति का यह रहस्य ही मोक्ष का मुख्य द्वार है।
        """.trimIndent(),
        english = """
            The soul is beginningless and exists far beyond all material modes.
            This imperishable spirit neither acts nor is entangled by the physical body.
            The soul never gets stained or polluted by karmic fruits or actions.
            It is an Untouchable and free resident confined within the biological cage.
            Whether the body sins or prays, the soul remains eternally pure and pristine.
            The fundamental nature of the soul is eternal bliss and is unchanging.
            We err significantly by linking the soul to physical activities and decay.
            This is the ultimate proof of eternal spiritual purity and cosmic dignity.
            Arjuna! The soul remains perpetually aloof and free despite the matrix.
            Decoding the secret of the distinct natures of body and spirit is essential.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            यथा सर्वगतं सौक्ष्म्यादाकाशं नोपलिप्यते |
            सर्वत्रावस्थितो देहे तथात्मा नोपलिप्यते || ३३ ||
        """.trimIndent(),
        hindi = """
            आकाश या स्पेस हर जगह है पर वह किसी भी चीज़ से गंदा नहीं होता है।
            वैसे ही आत्मा पूरे शरीर में है पर वह शरीर के किसी भी गुण से अछूती है।
            जो चीज़ जितनी सूक्ष्म और बारीक होती है, वह उतनी ही सुरक्षित रहती है।
            कीचड़ आकाश को गंदा नहीं कर सकता, वैसे ही शरीर आत्मा को गंदा नहीं कर सकता।
            आत्मा इस ब्रह्मांड की सबसे बारीक और अनटचेबल चीज़ मानी गई है।
            यह पिछले श्लोक का सबसे शानदार और समझने में आसान वैज्ञानिक उदाहरण है।
            आकाश में धुआँ हो या बहुत अच्छी खुशबू, आकाश हमेशा शुद्ध ही रहता है।
            वैसे ही आत्मा भयंकर पापों के बीच रहकर भी हमेशा पवित्र और साफ रहती है।
            अपनी सूक्ष्मता के कारण आत्मा भौतिकता के सभी नियमों से पूरी तरह परे है।
            आत्मा की इस अखंड पवित्रता का यह एक बहुत ही सुंदर ब्रह्मांडीय रूपक है।
        """.trimIndent(),
        english = """
            Space is absolutely everywhere but never gets dirty or mixed with matter.
            Similarly, the soul is in the body but remains completely untouched by it.
            The more Subtle an entity is, the more naturally immune it becomes.
            Mud cannot stain the sky; similarly, the body cannot stain the eternal soul.
            The soul is the absolute most subtle entity in the entire cosmos.
            This is a magnificent, highly visual scientific analogy for the spirit.
            Whether there is toxic smoke or sweet perfume, space remains perfectly pure.
            Similarly, the soul stays impeccably pure even amidst massive earthly sins.
            Due to its extreme subtlety, the soul transcends all laws of materiality.
            This serves as a beautiful cosmic metaphor for the soul's unbreakable purity.
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            यथा प्रकाशयत्येकः कृत्स्नं लोकमिमं रविः |
            क्षेत्रं क्षेत्री तथा कृत्स्नं प्रकाशयति भारत || ३४ ||
        """.trimIndent(),
        hindi = """
            जैसे एक अकेला सूर्य पूरे संसार और सोलर सिस्टम को रोशनी देता है।
            वैसे ही एक छोटी सी आत्मा पूरे शरीर में जीवन और चेतना फैलाती है।
            चेतना या महसूस करना ही आत्मा की मौजूदगी का सबसे साक्षात् प्रमाण है।
            एक बल्ब की तरह आत्मा आपके सिर के बालों से लेकर पैर के नाखूनों तक चमकती है।
            जहाँ दर्द या कोई भी अहसास है, समझो वहाँ आत्मा की रोशनी पहुँच रही है।
            बिना आत्मा के यह शरीर एक अंधेरे, ठंडे और मृत कमरे के समान हो जाता है।
            हे भारत! इस कॉस्मिक लाइट के अद्भुत रहस्य को गहराई से समझो।
            आत्मा शरीर का इंजन है और उसे चलाने वाला एकमात्र ऊर्जा स्रोत है।
            एक ही सूर्य करोड़ों आँखों को रोशनी देता है, वैसे ही आत्मा सेल्स को चलाती है।
            जैविक चेतना और आत्मा के इस संबंध का यह बहुत ही वैज्ञानिक चित्रण है।
        """.trimIndent(),
        english = """
            As a single sun successfully illuminates the entire solar system.
            So does a tiny soul actively spread consciousness across the entire body.
            Consciousness and feeling are the direct, irrefutable proof of the soul.
            Like a bright bulb, the soul shines its energy from your head to your toes.
            Wherever there is physical sensation, the soul's radiant light is present.
            Without the soul, the body is just a dark, dead, and decaying biological room.
            Arjuna! Deeply understand the profound mystery of this Cosmic Light.
            The soul is the primary engine and sole energy source of the physical body.
            One sun lights up millions of eyes; so does the spirit animate the cells.
            This is a flawless scientific depiction of the bond between soul and life.
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            क्षेत्रक्षेत्रज्ञयोरेवमन्तरं ज्ञानचक्षुषा |
            भूतप्रकृतिमोक्षं च ये विदुर्यान्ति ते परम् || ३५ ||
        """.trimIndent(),
        hindi = """
            यह तेरहवें अध्याय का बहुत ही शानदार और भव्य ग्रैंड फिनाले श्लोक है।
            भगवान कहते हैं कि अब अपनी ज्ञान रूपी आँखें पूरी तरह से खोल लो।
            शरीर और आत्मा के इस गहरे अंतर को वैज्ञानिक तरीके से जान लो।
            प्रकृति के बंधन से छूटने का उपाय समझना ही मनुष्य की असली सफलता है।
            जो इसे जान गया, वह सीधा परमात्मा के सर्वोच्च धाम को प्राप्त होता है।
            मैं यह नश्वर गाड़ी या शरीर नहीं हूँ, बल्कि मैं इसका अविनाशी ड्राइवर हूँ।
            इस सत्य को जानना ही इस संसार की भयंकर जेल से हमेशा के लिए आज़ादी है।
            ज्ञान की आँखें ही माया के उस घने परदे को हमेशा के लिए फाड़ सकती हैं।
            यहाँ क्षेत्र और क्षेत्रज्ञ का यह दिव्य विज्ञान पूरी तरह से संपन्न होता है।
            सर्वोच्च पद और मोक्ष प्राप्ति का यह भगवान की ओर से अंतिम आश्वासन है।
        """.trimIndent(),
        english = """
            This represents the magnificent Grand Finale of the thirteenth chapter.
            The Lord commands you to officially open your absolute Eyes of Knowledge.
            Profoundly and scientifically know the difference between body and spirit.
            Mastering the exact process of liberation is the definition of true success.
            One who actively decodes this successfully attains the Supreme Godhead.
            I am absolutely not the perishable vehicle, but the indestructible driver.
            Knowing this specific truth is the only true exit from the world's jail.
            Only the eyes of wisdom can violently tear the blinding veil of Maya.
            This perfectly completes the divine science of the Field and the Knower.
            This is the final, iron-clad assurance of achieving the supreme destination.
        """.trimIndent()
    )
)