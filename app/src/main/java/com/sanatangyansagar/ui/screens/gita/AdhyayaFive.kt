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
fun AdhyayaFive() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaFiveShlokas.indexOfFirst { it.id == shlokaNum }
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
            label = { Text("Search Shloka Number (1 - 29)") },
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
            itemsIndexed(adhyayaFiveShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaFiveShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            अर्जुन उवाच |
            संन्यासं कर्मणां कृष्ण पुनर्योगं च शंससि |
            यच्छ्रेय एतयोरेकं तन्मे ब्रूहि सुनिश्चितम् || १ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने कहा: हे कृष्ण! आप पहले कर्मों के संन्यास (छोड़ देने) की प्रशंसा करते हैं, और फिर निष्काम कर्मयोग (कर्म करने) की भी तारीफ करते हैं।
            इन दोनों रास्तों में से जो एक मेरे लिए निश्चित रूप से सबसे अधिक कल्याणकारी (श्रेय) हो, कृपया मुझे वही एक रास्ता स्पष्ट रूप से बताइए।
            पाँचवें अध्याय की शुरुआत में अर्जुन फिर से एक गहरे कंफ्यूजन (Confusion) में हैं। अर्जुन का दिमाग एक 'बाइनरी' (Binary) तरीके से सोचता है: या तो मुझे काम छोड़ना है (संन्यास), या मुझे काम करना है (कर्मयोग)।
            तीसरे और चौथे अध्याय में श्रीकृष्ण ने कभी कहा "सारे कर्मों का संन्यास कर दो" और कभी कहा "उठो और युद्ध करो"। अर्जुन इन दोनों बातों को आपस में विरोधी (Contradictory) मान रहे हैं।
            वे भगवान से एक सीधा और पक्का फैसला मांग रहे हैं कि "मुझे दो नावों में मत बिठाइए; मुझे कोई एक ऐसा रास्ता बता दीजिए जो मेरे मोक्ष के लिए 100% पक्का (सुनिश्चितम्) और सर्वश्रेष्ठ हो।"
            यह प्रश्न इंसान के जीवन का सबसे बड़ा द्वंद्व है कि हम अपनी नौकरी/परिवार छोड़कर जंगल चले जाएं, या समाज में रहकर ही अध्यात्म का पालन करें?
        """.trimIndent(),
        english = """
            Arjuna anxiously inquired: O Krishna! First of all, You highly praise renunciation of actions (Sannyasa), and then You again recommend the path of selfless work (Karma-yoga).
            Therefore, please tell me definitively and with absolute certainty which of these two paths is the most beneficial (Shreya) for me.
            At the dawn of the Fifth Chapter, Arjuna is once again trapped in a massive logical paradox. His brain operates in a strict 'Binary' mode: either I abandon all work (monkhood), or I engage in intense action (Karma Yoga).
            In chapters 3 and 4, Sri Krishna simultaneously praised "renouncing all actions" and commanded "stand up and fight." Arjuna perceives these two instructions as entirely mutually exclusive and highly contradictory.
            He pleads with the Lord for an absolute, black-and-white verdict: "Please stop placing my feet in two different boats; tell me precisely that 'One' singular path which guarantees 100% certain and supreme liberation for me."
            This profound question represents humanity's greatest existential dilemma: Should we physically abandon our careers and families to seek God in a forest, or should we practice spirituality while actively living in society?
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            श्रीभगवानुवाच |
            संन्यासः कर्मयोगश्च निःश्रेयसकरावुभौ |
            तयोस्तु कर्मसंन्यासात्कर्मयोगो विशिष्यते || २ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: कर्मों का संन्यास (त्याग) और निष्काम कर्मयोग—ये दोनों ही मार्ग परम कल्याण (मोक्ष) देने वाले हैं।
            परंतु उन दोनों में भी, कर्मों के संन्यास की तुलना में निष्काम 'कर्मयोग' बहुत अधिक श्रेष्ठ (विशिष्यते) है।
            भगवान श्रीकृष्ण यहाँ अर्जुन के कंफ्यूजन को हमेशा के लिए खत्म कर रहे हैं। वे एक बहुत ही स्पष्ट और ऐतिहासिक (Historic) फैसला (Verdict) सुनाते हैं।
            वे मानते हैं कि दोनों रास्ते सही हैं और दोनों से ही भगवान मिल जाते हैं। लेकिन जब तुलना (Comparison) की बात आती है, तो 'कर्मयोग' (समाज में रहकर निस्वार्थ काम करना) 'कर्मसंन्यास' (जंगल में जाकर काम छोड़ देने) से कहीं ज्यादा बेहतर और सुरक्षित (Safe) है।
            ऐसा क्यों? क्योंकि संन्यास लेना बहुत खतरनाक और मुश्किल है। यदि कोई इंसान जंगल चला जाए लेकिन उसका मन वासनाओं में फँसा रहे, तो वह पाखंडी बन जाएगा।
            लेकिन कर्मयोग में इंसान काम करता रहता है, इसलिए उसका दिमाग खाली नहीं होता। वह धीरे-धीरे अपनी ड्यूटी करते हुए शुद्ध हो जाता है।
            इसलिए भगवान अर्जुन के लिए कर्मयोग को ही सबसे 'सुपीरियर' (Superior) रास्ता घोषित करते हैं।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead conclusively replied: The renunciation of work (Sannyasa) and work in devotion (Karma-yoga) are both undeniably good for ultimate liberation.
            But of the two, the path of selfless work in devotion (Karma-yoga) is definitively superior (Vishishyate) to the absolute renunciation of work.
            Lord Sri Krishna puts a permanent end to Arjuna's deep confusion here by delivering a highly explicit, historic, and ultimate 'Verdict'.
            He perfectly acknowledges that both paths are genuine and both successfully lead to the Supreme. But when a direct head-to-head comparison is drawn, 'Karma Yoga' (executing selfless action while living in society) is infinitely superior and far safer than 'Karma Sannyasa' (physically abandoning work for a forest).
            Why? Because premature physical renunciation is incredibly dangerous. If a human isolates himself in a cave but his mind still burns with toxic lust, he instantly becomes a degraded hypocrite.
            But in Karma Yoga, the person is intensely occupied executing his prescribed duties, preventing his mind from becoming an idle devil's workshop. Through selfless action, he gradually and safely purifies his consciousness.
            Therefore, the Lord officially declares Karma Yoga as the absolute 'Superior' path for Arjuna.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            ज्ञेयः स नित्यसंन्यासी यो न द्वेष्टि न काङ्क्षति |
            निर्द्वन्द्वो हि महाबाहो सुखं बन्धात्प्रमुच्यते || ३ ||
        """.trimIndent(),
        hindi = """
            हे महाबाहु (अर्जुन)! जो मनुष्य न तो किसी से द्वेष (घृणा) करता है और न ही किसी चीज़ की आकांक्षा (लालसा) करता है, उसे 'नित्य संन्यासी' (सच्चा और हमेशा संन्यासी रहने वाला) ही जानना चाहिए।
            क्योंकि सुख-दुःख आदि द्वंद्वों (Dualities) से पूरी तरह मुक्त हुआ ऐसा व्यक्ति बहुत ही आसानी से (सुखं) सांसारिक बंधनों से पूरी तरह मुक्त (प्रमुच्यते) हो जाता है।
            श्रीकृष्ण यहाँ 'संन्यासी' की सबसे सटीक और साइकोलॉजिकल (Psychological) परिभाषा (Definition) दे रहे हैं।
            दुनिया मानती है कि संन्यासी वह है जिसने भगवा कपड़े पहन लिए हों और अपना घर-बार छोड़ दिया हो। लेकिन गीता का विज्ञान कहता है कि संन्यास कपड़ों या जगह का नाम नहीं है; यह एक 'माइंडसेट' (Mindset) है।
            सच्चा संन्यासी वह है जिसके दिमाग में दो वायरस (Viruses) नहीं हैं: 'न काङ्क्षति' (मुझे यह चाहिए की भूख) और 'न द्वेष्टि' (मुझे इससे नफरत है)।
            जिस इंसान ने अपनी चाहत और नफरत दोनों को मार दिया है, वह चाहे महलों में रहे या युद्ध लड़े, वह अंदर से 24 घंटे एक 'नित्य संन्यासी' ही है।
            ऐसा व्यक्ति बिना किसी टेंशन के अपने परिवार और जॉब के बीच रहकर भी कर्म के जाल से बहुत 'सुखपूर्वक' (Effortlessly) आज़ाद हो जाता है।
        """.trimIndent(),
        english = """
            O mighty-armed Arjuna! One who neither intensely hates (Na dveshti) nor passionately desires (Na kankshati) the fruits of his activities is strictly known to be always a true renunciate (Nitya-sannyasi).
            Such a person, completely free from all material dualities (Nirdvandvo), effortlessly and easily (Sukham) completely liberates himself from material bondage.
            Sri Krishna is delivering the absolute most precise, ultimate psychological definition of a true 'Sannyasi' (Renunciate) here.
            The ignorant world foolishly defines a Sannyasi entirely by his external saffron robes, bald head, and the physical abandonment of his home. But the profound science of the Gita declares that renunciation is absolutely not a dress code; it is a pristine 'State of Mind'.
            A genuine Sannyasi is exclusively that person whose brain is completely immune to two lethal viruses: 'Na Kankshati' (toxic craving/lust) and 'Na Dveshti' (toxic hatred/aversion).
            A human being who has successfully slaughtered both his desperate desires and bitter hatreds is permanently considered a 'Nitya Sannyasi' 24/7, even if he lives in a massive luxury palace or fights a terrifying world war.
            Such an elite master, completely detached from the bipolar dualities of this matrix, 'Effortlessly' and joyfully breaks the unbreakable titanium chains of karmic bondage.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            साङ्ख्ययोगौ पृथग्बालाः प्रवदन्ति न पण्डिताः |
            एकमप्यास्थितः सम्यगुभयोर्विन्दते फलम् || ४ ||
        """.trimIndent(),
        hindi = """
            अज्ञानी (मूर्ख या बच्चे) लोग ही 'सांख्य' (ज्ञान/संन्यास के मार्ग) और 'योग' (निष्काम कर्म के मार्ग) को एक-दूसरे से अलग (पृथक्) बताते हैं, ज्ञानी पण्डित ऐसा नहीं कहते।
            क्योंकि जो मनुष्य इन दोनों में से किसी भी एक मार्ग पर भली-भांति (सम्यक्) और पूरी निष्ठा से स्थित हो जाता है, वह दोनों ही मार्गों के अंतिम फल (मोक्ष) को प्राप्त कर लेता है।
            यह श्लोक धर्म के नाम पर समाज में फैले हुए एक बहुत बड़े झगड़े को शांत करता है। कुछ लोग कहते हैं कि "केवल ज्ञान (ध्यान) से ही मुक्ति मिलेगी", और दूसरे कहते हैं "नहीं, केवल समाज सेवा (कर्म) से ही भगवान मिलेंगे।"
            भगवान इन बहस करने वालों को 'बालाः' (Immature children / मूर्ख बच्चे) कहते हैं। 
            एक सच्चा 'पंडित' (ज्ञानी) जानता है कि ये दोनों रास्ते एक ही मंज़िल पर पहुँचते हैं। ज्ञान का अंतिम उद्देश्य (Goal) क्या है? अहंकार को मारना और ईश्वर से जुड़ना। और कर्मयोग का अंतिम उद्देश्य क्या है? स्वार्थ को मारना और ईश्वर की सेवा करना।
            चाहे आप ज्ञान के रास्ते से पहाड़ पर चढ़ें या कर्म के रास्ते से, अगर आप 100% ईमानदारी ('सम्यक्') से उस पर चलेंगे, तो आप उसी एक 'मोक्ष' (अंतिम फल) तक पहुँचेंगे।
        """.trimIndent(),
        english = """
            Only the ignorant, immature children (Balah) speak of analytical study (Sankhya) and devotional action (Yoga) as being completely different and separate, not the truly learned and wise (Panditah).
            One who firmly, genuinely, and flawlessly establishes himself in either one of these paths effortlessly achieves the ultimate result of both (Moksha).
            This phenomenal verse permanently silences one of the greatest, most toxic sectarian debates prevalent in the spiritual community. Some aggressively claim that "Only renunciation and knowledge lead to liberation," while others fiercely argue that "Only active social duty and action lead to God."
            The Lord bluntly insults these fighting dogmatists, calling them 'Balah' (foolish, immature, quarreling children).
            A true 'Pandita' (Enlightened master) perfectly knows that both these seemingly opposing paths flawlessly converge at the exact same ultimate destination. What is the ultimate goal of Knowledge? To slaughter the false ego and merge with God. What is the goal of Karma Yoga? To slay toxic selfishness and serve God.
            Whether you aggressively climb the mountain via the steep, quiet path of knowledge or the active, bustling path of selfless action, if you execute your chosen path with 100% flawless integrity ('Samyak'), you are guaranteed to seize the exact same supreme prize of eternal liberation.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            यत्साङ्ख्यैः प्राप्यते स्थानं तद्योगैरपि गम्यते |
            एकं साङ्ख्यं च योगं च यः पश्यति स पश्यति || ५ ||
        """.trimIndent(),
        hindi = """
            ज्ञानियों (संन्यासियों) द्वारा जो परम स्थान (मोक्ष) प्राप्त किया जाता है, निष्काम कर्मयोगियों द्वारा भी उसी परम स्थान तक पहुँचा जाता है।
            इसलिए, जो मनुष्य ज्ञानमार्ग (सांख्य) और कर्ममार्ग (योग) को फलरूप में एक ही देखता है, वास्तव में वही सही देखता है (स पश्यति)।
            भगवान पिछले श्लोक की बात को और पक्का (Confirm) कर रहे हैं। वे दोनों रास्तों की तुलना एक ही मंज़िल की ओर जाने वाले दो अलग-अलग दरवाज़ों से कर रहे हैं।
            सांख्य योगी (ज्ञानी) दुनिया को 'माया' (Illusion) मानकर छोड़ देता है और ध्यान लगाकर भगवान में लीन हो जाता है। कर्मयोगी दुनिया को भगवान की 'सेवा' का स्थान मानकर काम करता है और वह भी अंततः भगवान में ही लीन होता है।
            दोनों का 'स्थानं' (Destination / मोक्ष) बिल्कुल एक (Same) है। 
            भगवान कहते हैं: "यः पश्यति स पश्यति"—अर्थात् जिसकी नज़रों में ये दोनों रास्ते एक हो गए हैं, केवल उसी इंसान की आँखें खुली हैं (वही असलियत देख रहा है)। 
            जो लोग धर्म के नाम पर पंथ या रास्ते को लेकर लड़ते हैं, वे वास्तव में अंधे हैं।
        """.trimIndent(),
        english = """
            That supreme destination (Sthanam) which is achieved by means of analytical study (Sankhya/Renunciation) is also perfectly attained by working in devotional service (Yoga).
            Therefore, one who can clearly see that the path of analytical study and the path of unattached action are ultimately one and the same, truly sees things as they are (Sa pashyati).
            The Lord is strongly confirming and permanently validating the profound principle laid out in the previous verse. He compares both paths to two different doors entering the exact same magnificent room.
            The Sankhya Yogi (Renunciate) totally rejects the world as toxic 'Maya' (Illusion) and achieves God through deep meditation. The Karma Yogi actively embraces the world purely as an arena for God's 'Service' and also merges into the exact same God.
            Their absolute, final 'Sthanam' (Destination / Liberation) is 100% identical.
            The Lord drops an incredibly powerful statement: "Yah pashyati sa pashyati"—Meaning, the rare genius who perceives these two superficially different systems as fundamentally one and the same is the absolute ONLY person whose eyes are truly open to reality.
            Those who dogmatically fight over religious sects and external pathways are tragically blind to the ultimate truth.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            संन्यासस्तु महाबाहो दुःखमाप्तुमयोगतः |
            योगयुक्तो मुनिर्ब्रह्म नचिरेणाधिगच्छति || ६ ||
        """.trimIndent(),
        hindi = """
            परंतु हे महाबाहु (अर्जुन)! निष्काम कर्मयोग (योग) का आचरण किए बिना केवल संन्यास (कर्मों का त्याग) प्राप्त करना अत्यंत दुःखदायक (दुःखमाप्तुम्) है।
            लेकिन कर्मयोग (योगयुक्तो) में पूरी तरह लगा हुआ मननशील मुनि (ज्ञानी पुरुष) बहुत ही शीघ्र (नचिरेण) परब्रह्म परमात्मा को प्राप्त कर लेता है।
            यहाँ भगवान एक बहुत बड़ा 'वार्निंग साइन' (Warning Sign) दे रहे हैं। संन्यास लेना सुनने में बहुत अच्छा लगता है, लेकिन बिना मन की सफाई किए संन्यास लेना बहुत खतरनाक है।
            'अयोगतः' का मतलब है अगर इंसान का मन 'कर्मयोग' की भट्टी में पककर शुद्ध नहीं हुआ है, और वह सीधे जंगल में जाकर बैठ जाए, तो उसका संन्यास उसे केवल और केवल 'दुःख' देगा। उसका मन बार-बार शहर के सुखों की ओर भागेगा और वह फ्रस्ट्रेशन (Frustration) में पागल हो जाएगा।
            इसलिए भगवान कहते हैं कि पहले 'योगयुक्तो' बनो—यानी दुनिया में रहकर निष्काम भाव से काम करो, इससे तुम्हारा मन पूरी तरह शुद्ध हो जाएगा।
            और जो शुद्ध मन से कर्मयोग करता है, उसे भगवान को पाने में सालो-साल नहीं लगते, वह 'नचिरेण' (बहुत ही जल्दी / Without delay) भगवान तक पहुँच जाता है।
            कर्मयोग वास्तव में संन्यास के लिए इंसान को 'क्वालिफाई' (Qualify) करता है।
        """.trimIndent(),
        english = """
            But merely renouncing all activities (Sannyasa) without engaging in the devotional service of the Lord (Ayogatah) is highly distressing and brings only sheer misery (Duhkham aptum), O mighty-armed Arjuna.
            However, a thoughtful sage fully engaged in devotional, selfless service (Yoga-yukto) achieves the Supreme Brahman without the slightest delay (Nachirena).
            Here, the Lord erects a massive, glaring red 'Warning Sign' for spiritual seekers. Artificially renouncing the world sounds extremely romantic, but leaping into it without prior mental purification is a highly destructive psychological hazard.
            'Ayogatah' means that if a human being's mind has not been completely scrubbed and purified in the intense furnace of 'Karma Yoga', and he prematurely runs to a forest cave, his so-called renunciation will bring him absolutely nothing but agonizing 'Misery' (Duhkham). His toxic mind will violently drag him back to city pleasures, completely driving him insane with frustration.
            Therefore, the Lord prescribes the perfect sequential method: First, become 'Yoga-yukto'—meaning furiously execute selfless action within society to ruthlessly burn away your ego and desires.
            And for that contemplative sage who purifies himself through flawless Karma Yoga, achieving the Supreme Godhead does not take decades of frustrating meditation; he attains God 'Nachirena' (Instantly / With zero delay).
            True Karma Yoga is the absolute mandatory prerequisite qualification for true Sannyasa.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            योगयुक्तो विशुद्धात्मा विजितात्मा जितेन्द्रियः |
            सर्वभूतात्मभूतात्मा कुर्वन्नपि न लिप्यते || ७ ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति निष्काम कर्मयोग में स्थित है (योगयुक्तो), जिसका अंतःकरण (मन) पूरी तरह शुद्ध है (विशुद्धात्मा), जिसने अपनी आत्मा (मन और शरीर) को जीत लिया है (विजितात्मा), और जिसने अपनी इन्द्रियों पर पूरा काबू पा लिया है (जितेन्द्रियः)...
            तथा जो सम्पूर्ण प्राणियों की आत्मा को अपनी ही आत्मा मानता है (सर्वभूतात्मभूतात्मा), ऐसा महापुरुष संसार के सारे कर्म करते हुए भी कभी (पाप में) लिप्त नहीं होता (न लिप्यते)।
            इस श्लोक में भगवान एक 'परफेक्ट कर्मयोगी' (Perfect Karma Yogi) के शानदार और ईश्वरीय लक्षण बता रहे हैं।
            उस योगी की चार बहुत बड़ी उपलब्धियां (Achievements) होती हैं: वह काम को निष्काम भाव से करता है, उसका मन एकदम पवित्र (विशुद्ध) हो चुका है, उसका अपने शरीर और मन पर 100% कंट्रोल (विजितात्मा) है, और उसकी पाँचों इन्द्रियां उसकी गुलाम (जितेन्द्रिय) हैं।
            लेकिन उसकी सबसे बड़ी और महान खूबी (Superpower) है—"सर्वभूतात्मभूतात्मा"।
            इसका मतलब है कि उसे चींटी में, कुत्ते में, इंसान में और दुश्मन में भी वही एक आत्मा (भगवान) दिखाई देती है जो उसके खुद के अंदर है। वह सब जीवों से अपने जैसा ही प्यार करता है।
            जब इंसान इस लेवल (Level) की पवित्रता और समझ पर पहुँच जाता है, तो वह युद्ध में तीर चलाए या राजनीति करे—उसका कोई भी काम उसे पाप या पुण्य की जंजीरों में 'लिप्त' (Bind) नहीं कर सकता।
            वह इंसान एक चलता-फिरता भगवान बन जाता है।
        """.trimIndent(),
        english = """
            One who firmly works in devotion (Yoga-yukto), who is a pure soul (Vishuddhatma), and who completely controls his mind (Vijitatma) and effectively subdues his senses (Jitendriyah)...
            and whose very soul becomes intimately one with the soul of every living entity (Sarva-bhutatma-bhutatma)—such an exalted master, although always fully engaged in all kinds of massive actions, is never, ever entangled (Na lipyate).
            In this spectacular verse, the Lord enumerates the divine, flawless credentials and ultimate symptoms of a 'Perfected Karma Yogi'.
            This elite master has unlocked four monumental achievements: He operates flawlessly with zero selfishness, his internal software is impeccably purified (Vishuddhatma), he has successfully hacked and overridden his erratic mind (Vijitatma), and he holds absolute, titanium mastery over his senses (Jitendriyah).
            But his absolute greatest, most godlike Superpower is: "Sarva-bhutatma-bhutatma".
            This profoundly means his cosmic vision has expanded so immensely that he sees the exact same eternal soul (God) residing within an ant, a stray dog, a human, and even his most bitter enemy, exactly as it resides within himself. He loves the entire cosmos as his own self.
            When a human achieves this staggering altitude of extreme purity and universal oneness, whether he launches deadly arrows in a world war or manages complex global politics—absolutely no action can ever 'Bind' or entangle (Lipyate) him in karmic chains.
            He practically elevates into a walking, breathing manifestation of God on earth.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            नैव किञ्चित्करोमीति युक्तो मन्येत तत्त्ववित् |
            पश्यञ्शृण्वन्स्पृशञ्जिघ्रन्नश्नन्गच्छन्स्वपन्श्वसन् || ८ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 8 और 9 एक ही विचार हैं)
            परम सत्य को जानने वाला (तत्त्ववित्) और योग में स्थित (युक्तः) महापुरुष देखते हुए (पश्यन्), सुनते हुए (शृण्वन्), छूते हुए (स्पृशन्), सूंघते हुए (जिघ्रन्), खाते हुए (अश्नन्), चलते हुए (गच्छन्), सोते हुए (स्वपन्), और सांस लेते हुए (श्वसन्)...
            (हमेशा यही मानता है कि "मैं वास्तव में कुछ भी नहीं कर रहा हूँ" - नैव किञ्चित्करोमीति)।
            भगवान यहाँ एक आत्मज्ञानी (Enlightened person) का 'आंतरिक मनोविज्ञान' (Internal Psychology) बता रहे हैं।
            जब हम साधारण लोग कुछ देखते या खाते हैं, तो हमारा ईगो (Ego) कहता है, "मैं देख रहा हूँ, मैं खा रहा हूँ।"
            लेकिन जो व्यक्ति 'तत्त्ववित्' (Truth-realized) है, उसका ईगो (मैं-पन) पूरी तरह मर चुका होता है।
            वह अपनी आँखों से दुनिया को देखता है, कानों से सुनता है, यहाँ तक कि गहरी नींद में सोता भी है और सांस भी लेता है। बाहर से वह हमारे जैसा ही एक नॉर्मल (Normal) इंसान लगता है।
            लेकिन उसके दिमाग के अंदर एक बहुत गहरा सॉफ्टवेयर (Software) चल रहा होता है: "मैं (आत्मा) कुछ नहीं कर रहा।"
            वह जानता है कि शरीर की ये इन्द्रियां और मशीनरी अपना मेकेनिकल काम (Mechanical work) कर रही हैं, और मैं (आत्मा) केवल एक साइलेंट ऑब्जर्वर (Silent Observer / दृष्टा) हूँ।
            यही वजह है कि वह कुछ भी करते हुए कभी कर्मों के जाल में नहीं फँसता।
        """.trimIndent(),
        english = """
            (Verses 8 and 9 are a continuous thought)
            A person in divine consciousness, knowing the Absolute Truth (Tattva-vit), while actively seeing (Pashyan), hearing (Shrinvan), touching (Sprishan), smelling (Jighran), eating (Ashnan), moving about (Gacchan), sleeping (Svapan), and breathing (Shvasan)...
            (always firmly thinks within himself: "I am absolutely doing nothing at all" - Naiva kinchit karomi iti).
            The Lord is brilliantly exposing the highly classified 'Internal Psychology' and background operating system of a fully Enlightened Master.
            When we ordinary mortals look at a screen or chew food, our toxic false ego aggressively claims, "I am seeing this, I am eating this."
            But a master who is completely 'Tattva-vit' (One who has successfully decoded the Absolute Truth) has brutally assassinated this false 'I-ness'.
            He uses his physical eyes to see the world, his ears to hear, he physically walks, sleeps deeply, and his lungs actively breathe. From the outside, he looks exactly like a perfectly normal human being.
            But deep inside his consciousness, a flawless software algorithm is permanently running: "I (the pure spirit soul) am doing absolutely nothing."
            He perfectly realizes that his physical senses and biological machinery are simply executing their automated, mechanical functions, while 'He' (the soul) remains an utterly detached, Silent Observer.
            This exact profound separation of identity is precisely why he executes massive actions but never gets caught in the karmic spiderweb.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            प्रलपन्विसृजन्गृह्णन्नुन्मिषन्निमिषन्नपि |
            इन्द्रियाणीन्द्रियार्थेषु वर्तन्त इति धारयन् || ९ ||
        """.trimIndent(),
        hindi = """
            बोलते हुए (प्रलपन्), मल त्यागते हुए (विसृजन्), किसी चीज़ को पकड़ते हुए (गृह्णन्), और अपनी आँखें खोलते तथा बंद करते हुए भी (उन्मिषन्निमिषन्नपि)...
            वह ज्ञानी पुरुष हमेशा यही दृढ़ धारणा (निश्चय) रखता है कि "ये सभी इन्द्रियां केवल अपने-अपने इन्द्रिय-विषयों में बरत रही हैं (अपना काम कर रही हैं), मेरा इनसे कोई लेना-देना नहीं है।"
            यह 8वें श्लोक का ही सीधा विस्तार (Continuation) है।
            भगवान इंसान के उन सबसे छोटे और ऑटोमैटिक (Automatic) कामों की लिस्ट दे रहे हैं जिन पर हमारा ध्यान भी नहीं जाता, जैसे पलकें झपकाना (Blinking) या मल त्यागना (Excreting)।
            एक अज्ञानी व्यक्ति अपनी हर छोटी-बड़ी हरकत के साथ अपना ईगो (Ego) जोड़ लेता है।
            लेकिन ज्ञानी महापुरुष पलक झपकाने से लेकर युद्ध के मैदान में भाषण देने (प्रलपन्) तक, हर काम में पूरी तरह से डिटैच्ड (Detached) रहता है।
            वह मन ही मन इस वैज्ञानिक सत्य को होल्ड (Hold / धारयन्) करके रखता है कि "ये इन्द्रियां (हार्डवेयर) बाहरी दुनिया के ऑब्जेक्ट्स (Objects) के साथ इंटरेक्ट (Interact) कर रही हैं। यह सिर्फ नेचर (Nature) का एक मेकेनिकल (Mechanical) प्रोसेस है।"
            इस प्रकार, वह अपनी आत्मा (Consciousness) को इस फिजिकल मैट्रिक्स (Physical Matrix) से पूरी तरह अलग (Unplug) कर लेता है, और इसी कारण वह हमेशा परम शांति में रहता है।
        """.trimIndent(),
        english = """
            While speaking (Pralapan), evacuating (Visrijan), grasping objects (Grihnan), or even simply opening and closing his eyes (Unmishan nimishann api)...
            he always firmly maintains the strict conviction (Dharayan) that "it is merely the material senses expertly interacting with their corresponding sense objects; I am completely apart from them."
            This is the direct, seamless continuation of the profound philosophy established in Verse 8.
            The Lord is listing the absolute most microscopic, highly automated, and mundane biological functions of the human body that we don't even consciously notice, like blinking the eyelids or evacuating waste.
            An ignorant, heavily conditioned soul violently attaches his false ego to every single tiny bodily movement.
            But the enlightened grandmaster remains 100% ruthlessly 'Detached' in everything he does—from the simple act of blinking an eye to delivering a roaring speech on a bloody battlefield (Pralapan).
            He permanently runs the unshakeable scientific conviction (Dharayan) in the background of his mind: "These physical senses (the biological hardware) are merely interacting with the external objects of the material matrix. It is a completely automated, mechanical process of nature."
            By sustaining this exact thought, he flawlessly and permanently 'Unplugs' his true consciousness from the terrifying physical Matrix, which allows him to eternally reside in absolute, unbreakable peace.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            ब्रह्मण्याधाय कर्माणि सङ्गं त्यक्त्वा करोति यः |
            लिप्यते न स पापेन पद्मपत्रमिवाम्भसा || १० ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य अपने सभी कर्मों को 'ब्रह्म' (परमात्मा) में अर्पण करके (आधाय), और सारी आसक्ति (लगाव/स्वार्थ) को पूरी तरह त्याग कर (त्यक्त्वा) कर्म करता है...
            वह मनुष्य पाप से बिल्कुल उसी प्रकार अछूता (न लिप्यते) रहता है, जिस प्रकार कमल का पत्ता (पद्मपत्रम्) जल (पानी) में रहते हुए भी जल से कभी गीला नहीं होता।
            यह पूरी भगवद्गीता के सबसे शानदार, खूबसूरत और दुनिया भर में सबसे ज्यादा दिए जाने वाले उदाहरणों (Analogies) में से एक है।
            श्रीकृष्ण एक बहुत बड़ी समस्या का समाधान कर रहे हैं। हम सोचते हैं कि अगर हम इस गंदी और भ्रष्ट दुनिया (पाप के कीचड़) में रहेंगे, तो हम भी गंदे (पापी) हो जाएंगे।
            लेकिन भगवान 'कमल के पत्ते' (Lotus Leaf) का अमेजिंग (Amazing) उदाहरण देते हैं। कमल का पत्ता हमेशा तालाब के कीचड़ और पानी में रहता है, 24 घंटे पानी से घिरा रहता है, लेकिन अगर आप उसे पानी से बाहर निकालें, तो वह बिल्कुल सूखा (Dry) होता है। पानी की एक बूंद भी उस पर नहीं चिपकती।
            उसी प्रकार, जो इंसान अपना सारा काम 'ईश्वर को अर्पित' कर देता है और 'स्वार्थ' (Attachment) की चिपचिपाहट को अपने मन से धो देता है...
            वह इस दुनिया के सबसे गंदे राजनीति, व्यापार या युद्ध के कीचड़ में 24 घंटे रहते हुए भी पाप से 100% अछूता (Untouched) रहता है। दुनिया उसे गंदा नहीं कर सकती।
            हमें दुनिया (पानी) छोड़कर भागने की जरूरत नहीं है, हमें बस अपने मन को 'कमल का पत्ता' (Waterproof) बनाना है!
        """.trimIndent(),
        english = """
            One who performs his duty entirely without any attachment (Sangam tyaktva), completely dedicating and surrendering the results unto the Supreme Lord (Brahmany adhaya karmani)...
            is absolutely never affected or stained by sinful action (Lipyate na sa papena), exactly as a lotus leaf (Padma-patram) remains completely untouched by the water (Ambhasa) it floats on.
            This is universally celebrated as one of the most spectacular, breathtakingly beautiful, and frequently cited analogies in the entire Bhagavad Gita.
            Sri Krishna is solving a massive existential problem here. Ignorant humans fiercely believe that if they actively live and operate within this corrupt, highly toxic, and sinful material world, they will inevitably become infected and corrupted by it.
            But the Lord provides the phenomenal, ultimate counter-example of the 'Lotus Leaf'. The lotus leaf physically exists 24/7 directly inside the murky, muddy water of a pond, surrounded by it constantly; yet, if you pull it out, it is flawlessly, 100% bone-dry. Not a single microscopic drop of dirty water ever sticks to it.
            In the exact same magnificent way, a human being who officially 'Transfers' all his actions to God's account and completely scrubs off the toxic glue of 'Selfish Attachment' from his mind...
            can operate 24/7 right in the deepest, filthiest mud of corporate politics, cut-throat business, or a brutal world war, yet remain absolutely 100% uninfected and untouched by sin. The toxic matrix cannot contaminate him.
            We absolutely do not need to cowardly run away from the world (the water); we simply need to upgrade our mind's software to become entirely 'Waterproof' like the Lotus Leaf!
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            कायेन मनसा बुद्ध्या केवलैरिन्द्रियैरपि |
            योगिनः कर्म कुर्वन्ति सङ्गं त्यक्त्वात्मशुद्धये || ११ ||
        """.trimIndent(),
        hindi = """
            सच्चे योगी लोग आसक्ति (स्वार्थ और अहंकार) को पूरी तरह से त्याग कर (सङ्गं त्यक्त्वा), केवल अपने अंतःकरण (मन) की शुद्धि के लिए (आत्मशुद्धये)...
            केवल शरीर से (कायेन), मन से (मनसा), बुद्धि से (बुद्ध्या), और केवल इन्द्रियों के द्वारा ही कर्म करते हैं (उनमें 'मैं' का भाव नहीं होता)।
            भगवान श्रीकृष्ण यहाँ योगियों के काम करने का एकमात्र 'उद्देश्य' (Purpose) बता रहे हैं।
            साधारण लोग शरीर, मन और बुद्धि का इस्तेमाल क्यों करते हैं? पैसा कमाने के लिए, ऐशो-आराम के लिए या दूसरों को हराने के लिए।
            लेकिन जो 'योगी' है (यानी जो इंसान भगवान से जुड़ना चाहता है), वह अपने शरीर, मन और बुद्धि को एक 'क्लीनिंग टूल' (Cleaning Tool / झाड़ू) की तरह इस्तेमाल करता है।
            वह जो भी कर्म (ड्यूटी) करता है, उसका अल्टीमेट टारगेट (Ultimate Target) केवल एक ही होता है: 'आत्म-शुद्धि' (Self-purification)।
            वह जानता है कि जब तक उसके अंदर ईर्ष्या, लालच और घमंड का कचरा है, तब तक उसे भगवान नहीं मिलेंगे। इसलिए वह निष्काम भाव से काम करके अपने अंदर के उस कचरे को साफ करता है।
            श्लोक में 'केवलैः' (केवल) शब्द बहुत गहरा है। इसका मतलब है कि योगी जब काम करता है, तो काम तो होता है, लेकिन उसमें 'अहंकार' (Ego) शामिल नहीं होता। वे केवल मशीन की तरह काम करते हैं।
            आपके ऑफिस का काम या आपका पारिवारिक कर्तव्य ही आपकी सबसे बड़ी 'आध्यात्मिक थेरेपी' (Spiritual Therapy) बन सकता है, अगर आप उसे बिना स्वार्थ के करें।
        """.trimIndent(),
        english = """
            The yogis, totally abandoning all false attachment (Sangam tyaktva), act purely with their physical body (Kayena), their mind (Manasa), their intelligence (Buddhya), and even with their purified senses (Kevalair indriyair api)...
            exclusively for the sole and supreme purpose of purifying their own consciousness and soul (Atma-shuddhaye).
            Lord Sri Krishna is brilliantly decoding the absolute, singular, and exclusive 'Ultimate Purpose' behind why advanced Yogis perform any action in this world.
            Why do ordinary, ignorant mortals fiercely utilize their bodies, minds, and intelligence? Strictly to ruthlessly hoard money, extract cheap sensory pleasure, or crush their competitors.
            But an elite 'Yogi' (one who desperately seeks union with the Supreme Lord) utilizes his physical body, sharp mind, and genius intelligence purely as a highly efficient 'Scrubbing Brush' (Cleaning Tool).
            Whatever intense duty he performs in the world, his absolute, singular ultimate target is always exactly one thing: 'Atma-shuddhi' (Absolute Self-Purification).
            He profoundly knows that as long as the toxic garbage of envy, lust, and blinding arrogance pollutes his heart, he can never perceive God. Therefore, he uses selfless action as a high-pressure hose to blast away all internal dirt.
            The word 'Kevalaih' (only/purely) used in this verse is highly significant. It proves that when the Yogi works, the biological machine operates flawlessly, but his toxic 'Ego' is 100% completely unplugged from the action.
            Your stressful corporate job or heavy family duties can instantly transform into the absolute greatest 'Spiritual Therapy' to purify your soul, provided you execute them without a single drop of selfishness.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            युक्तः कर्मफलं त्यक्त्वा शान्तिमाप्नोति नैष्ठिकीम् |
            अयुक्तः कामकारेण फले सक्तो निबध्यते || १२ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य 'युक्त' है (यानी निष्काम कर्मयोगी है), वह अपने कर्मों के फलों (रिज़ल्ट) को त्याग कर परम 'शांति' (नैष्ठिकीं शान्तिम्) को प्राप्त कर लेता है।
            परंतु जो मनुष्य 'अयुक्त' है (यानी सकाम कर्मी / स्वार्थी है), वह अपनी कामना (लालच) के कारण कर्म के फलों में बुरी तरह आसक्त (चिपका हुआ) रहता है, और इसी कारण वह जन्म-मरण के बंधनों में बुरी तरह बँध जाता है (निबध्यते)।
            यह श्लोक दुनिया के दो सबसे अलग-अलग तरह के लोगों का बिल्कुल साफ 'तुलनात्मक चित्र' (Comparative Picture) पेश करता है: 'मुक्त इंसान' और 'गुलाम इंसान'।
            १. 'युक्त इंसान' (The Free Man): यह वह इंसान है जो अपना काम 100% फोकस (Focus) से करता है, लेकिन काम पूरा होते ही वह उसके रिज़ल्ट (पैसे, तारीफ या सक्सेस) को भगवान के चरणों में फेंक देता है (त्याग देता है)। ऐसा करने से उसे तुरंत एक ऐसी 'नैष्ठिकी शांति' (Unshakeable Peace) मिलती है जिसे दुनिया का कोई दुख तोड़ नहीं सकता।
            २. 'अयुक्त इंसान' (The Slave): यह वह साधारण इंसान है जो काम शुरू करने से पहले ही रिज़ल्ट (प्रॉफिट/Profit) का सपना देखने लगता है। उसकी पूरी ड्राइविंग फोर्स (Driving Force) 'कामकारेण' (इच्छा या लालच) होती है।
            चूँकि वह उस फल (Result) से फेविकोल (Fevicol) की तरह चिपक ('सक्तः') जाता है, इसलिए वह हमेशा स्ट्रेस, एंग्ज़ायटी (Anxiety) और डिप्रेशन का शिकार रहता है। और यही आसक्ति उसे अगले जन्म में फिर से दुनिया में घसीट लाती है ('निबध्यते')।
            शांति 'काम' छोड़ने से नहीं मिलती, शांति 'काम के रिज़ल्ट' की टेंशन छोड़ने से मिलती है।
        """.trimIndent(),
        english = """
            The steadily devoted soul (Yuktah) attains unadulterated, supreme, and everlasting peace (Shantim naishthikim) simply because he completely offers the results of all his activities to Me (Karma-phalam tyaktva).
            Whereas a person who is entirely disconnected from the Divine (Ayuktah), being aggressively driven by his own lust and greed (Kama-karena), becomes intensely attached to the fruits of his labor (Phale sakto) and thus becomes heavily entangled and bound (Nibadhyate).
            This spectacular verse paints an absolutely crystal-clear, striking 'Comparative Picture' between the two distinctly opposite categories of humans on earth: 'The Totally Free Man' vs. 'The Pathetic Slave'.
            1. 'The Yukta Human' (The Free Man): This is the elite master who executes his duties with 100% razor-sharp focus, but the very microsecond the work is done, he violently tosses the result (money, praise, success) entirely at the feet of God (Renounces it). By doing this, he instantly unlocks 'Naishthiki Shanti' (an Unshakeable, Titanium-grade Peace) that absolutely no earthly tragedy can ever shatter.
            2. 'The Ayukta Human' (The Slave): This is the ignorant mortal who starts obsessively daydreaming about the end-result (Profit/Fame) even before starting the actual work. His entire psychological driving force is 'Kama-karena' (Toxic lust and blinding greed).
            Because he glues himself to that future result ('Saktah') like superglue, he permanently burns in the hellfire of chronic stress, severe anxiety, and dark depression. And this exact toxic attachment forcefully drags him back into the matrix of rebirth ('Nibadhyate').
            Supreme peace is absolutely never achieved by abandoning your work; true peace is achieved exclusively by abandoning the toxic, paralyzing anxiety over the results of your work.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            सर्वकर्माणि मनसा संन्यस्यास्ते सुखं वशी |
            नवद्वारे पुरे देही नैव कुर्वन्न कारयन् || १३ ||
        """.trimIndent(),
        hindi = """
            जिसने अपने मन और इन्द्रियों को पूरी तरह वश में कर लिया है (वशी), वह देहधारी आत्मा (देही) अपने मन के द्वारा सभी कर्मों का संन्यास करके (त्याग करके)...
            इस 'नौ दरवाजों वाले नगर' (नवद्वारे पुरे) रूपी शरीर में, वास्तव में न तो कुछ करता हुआ और न ही कुछ करवाता हुआ, अत्यंत सुख और आनंदपूर्वक (सुखं) निवास करता है।
            भगवान श्रीकृष्ण यहाँ मानव शरीर को एक बहुत ही शानदार रूपक (Metaphor) 'नौ दरवाजों वाले शहर' (City of Nine Gates) के रूप में प्रस्तुत कर रहे हैं।
            हमारे शरीर में बाहरी दुनिया से जुड़ने के नौ (9) छेद (दरवाजे) हैं: दो आँखें, दो कान, दो नथुने (नाक), एक मुँह, एक गुदा (मलद्वार) और एक जननेन्द्रिय।
            साधारण इंसान इन 9 दरवाजों को खुला छोड़ देता है, जिससे दुनिया का सारा कचरा (वासनाएं और टेंशन) उसके शहर (शरीर) में घुस आता है और राजा (आत्मा) को परेशान कर देता है।
            लेकिन जो 'वशी' (Self-controlled Master) है, उसने मन की शक्ति से इन सभी दरवाजों पर कड़ा पहरा लगा दिया है। वह बाहर के कचरे को अंदर नहीं आने देता।
            उसने मन से मान लिया है कि "मैं यह शरीर (शहर) नहीं हूँ, मैं तो इसमें रहने वाला एक राजा (आत्मा) हूँ।"
            जब वह यह महसूस कर लेता है कि शरीर के सारे काम प्रकृति कर रही है (न मैं कर रहा हूँ, न करवा रहा हूँ), तो वह इस शरीर के अंदर एक वीआईपी (VIP) अतिथि की तरह बिल्कुल 'सुखपूर्वक' (Blissfully) रहता है। उसे शरीर की बीमारियों या उम्र का कोई दुख नहीं सताता।
        """.trimIndent(),
        english = """
            When the embodied living being (Dehi) completely controls his nature and mentally renounces absolutely all actions (Sarva-karmani manasa sannyasya)...
            he safely and blissfully resides in supreme happiness (Sukham) within the 'City of Nine Gates' (Nava-dvare pure) [the material body], absolutely neither working nor causing any work to be done.
            Lord Sri Krishna brilliantly introduces one of the most phenomenal and fascinating metaphors in spiritual philosophy here, describing the human biological body as the 'City of Nine Gates'.
            The human biological machine possesses exactly nine physical openings (gates) connecting it to the external matrix: two eyes, two ears, two nostrils, one mouth, one anus, and one genital.
            An ignorant, uncontrolled mortal leaves all these 9 massive gates wide open, allowing the highly toxic garbage of the material world (lust, anxiety, and stress) to violently flood into his city and torture the resident King (the Soul).
            But the 'Vashi' (The Supreme Self-controlled Master) places heavily armed, titanium guards at all these gates using the sheer power of his purified mind. He absolutely blocks all toxic external input from entering.
            He has firmly realized through deep meditation, "I am absolutely not this biological city (body); I am merely the eternal royal King (soul) temporarily residing inside it."
            When he perfectly realizes that material nature is mechanically performing all bodily actions (he is neither doing them nor causing them), he reclines inside this physical body exactly like an untouched, highly pampered VIP guest, residing in absolute 'Bliss' (Sukham), totally immune to the body's aging or diseases.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            न कर्तृत्वं न कर्माणि लोकस्य सृजति प्रभुः |
            न कर्मफलसंयोगं स्वभावस्तु प्रवर्तते || १४ ||
        """.trimIndent(),
        hindi = """
            परमेश्वर (भगवान) इस संसार के लोगों के लिए न तो 'कर्तापन' (किसी काम को करने का अहंकार) पैदा करता है, न ही उनके 'कर्म' (कार्यों) को बनाता है...
            और न ही भगवान लोगों को उनके 'कर्मों के फलों' (सुख-दुःख) से जोड़ता है। यह सब तो केवल प्रकृति का अपना 'स्वभाव' (माया या प्राकृतिक नियम) ही है जो इन सबको ऑटोमैटिक तरीके से चला रहा है।
            यह श्लोक उन लोगों के लिए सबसे बड़ा और करारा जवाब है जो अपनी हर नाकामी या बुरे काम के लिए भगवान को दोष देते हैं (कि "भगवान ने मेरे साथ ऐसा क्यों किया!" या "भगवान की मर्जी के बिना पत्ता भी नहीं हिलता")।
            श्रीकृष्ण पूरी तरह से स्पष्ट करते हैं कि भगवान इंसान के रोजमर्रा के कामों में कोई दखलंदाजी (Interference) नहीं करते!
            १. 'न कर्तृत्वं': भगवान किसी के अंदर यह अहंकार नहीं डालते कि "मैं चोरी करूँ या मैं महान काम करूँ।" यह इंसान का अपना अहंकार है।
            २. 'न कर्माणि': भगवान किसी से कोई पाप या पुण्य का काम जबरदस्ती नहीं करवाते। इंसान अपनी 'फ्री-विल' (Free Will / आज़ादी) का खुद इस्तेमाल करता है।
            ३. 'न कर्मफलसंयोगं': और न ही भगवान बैठकर किसी को दुःख या सुख का रिज़ल्ट बांटते हैं।
            तो फिर यह सब कौन चला रहा है? "स्वभावस्तु प्रवर्तते" (यह सब प्रकृति यानी Material Nature का एक ऑटोमैटिक सॉफ्टवेयर/Software है)।
            भगवान ने दुनिया बनाकर एक 'सिस्टम' (Law of Karma) सेट कर दिया है। अगर तुम आग में हाथ डालोगे (कर्म), तो हाथ जलेगा (फल)। इसमें भगवान तुम्हें जलाने नहीं आए, यह प्रकृति का नियम है जो काम कर रहा है।
        """.trimIndent(),
        english = """
            The Supreme Lord (Prabhuh) absolutely does not create any false sense of proprietorship or doership (Kartritvam) for the living entities, nor does He forcefully dictate or create their specific material activities (Karmani)...
            nor does He directly orchestrate the exact connection between their actions and the resulting fruits (Karma-phala-samyogam). All this is executed entirely flawlessly by the automated laws of material nature (Svabhavas tu pravartate).
            This spectacular verse delivers the absolute ultimate, crushing response to billions of ignorant humans who constantly blame God for their own pathetic failures or horrific crimes (crying, "Why did God do this to me!" or "Nothing moves without God's explicit will!").
            Sri Krishna makes it brutally, 100% crystal clear that the Supreme Lord absolutely does not micromanage or interfere with the daily mundane choices of the tiny living entities!
            1. 'Na Kartritvam': God absolutely does not inject the toxic ego into a human's brain making him think, "I should rob a bank" or "I am a billionaire." That false ego is completely self-generated.
            2. 'Na Karmani': God absolutely never forcefully programs or manipulates a human like a robot to commit a sin or a pious act. The human soul completely exercises its own independent 'Free Will'.
            3. 'Na Karma-phala-samyogam': Nor does God manually sit down and distribute specific doses of happiness or depression to people.
            So, who exactly is running this massive show? "Svabhavas tu pravartate" (It is the highly advanced, automated software of Material Nature / Maya).
            God engineered the universe, installed the absolute, unbreakable 'Law of Karma', and stepped back. If you foolishly thrust your hand into a roaring fire (Action), it will burn horribly (Reaction). God did not personally burn your hand; the automated laws of nature simply flawlessly executed the reaction.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            नादत्ते कस्यचित्पापं न चैव सुकृतं विभुः |
            अज्ञानेनावृतं ज्ञानं तेन मुह्यन्ति जन्तवः || १५ ||
        """.trimIndent(),
        hindi = """
            वह सर्वव्यापी परमेश्वर (विभुः) न तो किसी के पाप (बुरे कर्मों) को ग्रहण करता है (लेता है), और न ही किसी के पुण्यों (अच्छे कर्मों) को लेता है।
            वास्तव में, अज्ञान (Ignorance/अंधेरे) के द्वारा जीवों का असली ज्ञान पूरी तरह से ढका (आवृत) हुआ है, और इसी कारण सभी जीव (जन्तवः) भयंकर मोह और भ्रम (मुह्यन्ति) में पड़े हुए हैं।
            यह पिछले श्लोक का ही सीधा विस्तार है और अज्ञानता पर एक और कड़ा प्रहार है।
            कई लोग सोचते हैं कि "मैं बहुत पाप करूँगा, और फिर गंगा नहाकर या मंदिर में कुछ पैसे दान करके अपने पाप भगवान को दे दूँगा (भगवान मेरे पाप ले लेंगे)।"
            श्रीकृष्ण इस बेवकूफी को खारिज करते हैं: "नादत्ते कस्यचित्पापम्" (मैं किसी का कोई पाप अपने ऊपर नहीं लेता)। तुम्हारा पाप तुम्हारा ही है, और उसका रिज़ल्ट (नरक या दुःख) तुम्हें ही भुगतना पड़ेगा।
            और न ही भगवान को तुम्हारे 'पुण्य' की कोई भूख है। वे 'विभु' (सब कुछ से पूर्ण) हैं, उन्हें तुम्हारी किसी चीज़ की कोई जरूरत नहीं है।
            तो फिर इंसान यह सब बेवकूफी क्यों सोचता है? 
            "अज्ञानेनावृतं ज्ञानं"—क्योंकि इंसान की असली बुद्धि (कि वह आत्मा है और भगवान का नियम कठोर है) को अज्ञान (Illusion) की एक बहुत मोटी और काली चादर ने पूरी तरह ढक दिया है।
            इसी घोर अज्ञान के नशे में ('तेन मुह्यन्ति') इंसान खुद को शरीर मान बैठता है, पाप करता है, और सोचता है कि वह भगवान को رشवत (Bribe) देकर बच जाएगा। अज्ञान ही दुनिया की सारी समस्याओं की इकलौती जड़ है।
        """.trimIndent(),
        english = """
            The all-pervading Supreme Lord (Vibhuh) absolutely does not accept or assume anyone's sinful activities (Papam), nor does He require or accept anyone's pious deeds (Sukritam).
            In absolute reality, the pure spiritual knowledge of the living entities is completely and densely covered by profound ignorance (Ajnanenavritam jnanam), and it is solely because of this that all living beings are entirely bewildered and hallucinating (Tena muhyanti jantavah).
            This verse is the direct, heavy continuation of the previous truth and serves as another devastating strike against human stupidity and religious hypocrisy.
            Many ignorant mortals foolishly plot, "I will commit horrific sins all week, and on Sunday, I will donate a few dollars to the temple or take a bath in a holy river, and God will magically absorb all my sins."
            Sri Krishna violently rejects this pathetic illusion: "Namatte kasyachit papam" (I absolutely never take or assume anyone's sins upon Myself). Your toxic sins belong 100% exclusively to you, and you alone will suffer the horrific, hellish consequences.
            Nor is the Lord desperately hungry for your petty 'Pious deeds' (Sukritam). He is 'Vibhu' (Infinite and Complete); He requires absolutely nothing from a tiny mortal.
            So why do humans harbor such absurd, idiotic thoughts?
            "Ajnane-navritam jnanam"—Because the original, brilliant spiritual intelligence of the human being (that he is an eternal soul governed by strict karmic laws) has been completely smothered and covered by an extremely thick, black blanket of pure 'Ignorance' (Illusion).
            Heavily intoxicated by this terrifying darkness ('Tena muhyanti'), the living entity foolishly hallucinates that he is the physical body, brazenly commits sins, and arrogantly thinks he can simply 'Bribe' God to escape justice. Ignorance is the sole, absolute root cause of all cosmic suffering.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            ज्ञानेन तु तदज्ञानं येषां नाशितमात्मनः |
            तेषामादित्यवज्ज्ञानं प्रकाशयति तत्परम् || १६ ||
        """.trimIndent(),
        hindi = """
            परंतु जिन मनुष्यों का वह घोर अज्ञान, आत्मा के 'सच्चे ज्ञान' (ज्ञानेन) के द्वारा पूरी तरह से नष्ट कर दिया गया है (नाशितम्)...
            उनका वह शुद्ध ज्ञान, ठीक चमकते हुए सूर्य (आदित्यवत्) के समान, उस परम सत्य (परमात्मा/तत्परम्) को पूरी तरह से प्रकाशित कर देता है (यानी साक्षात् दिखा देता है)।
            अज्ञान के अंधेरे की बात करने के बाद, भगवान अब 'ज्ञान के सूर्योदय' (Sunrise of Knowledge) का अत्यंत ही खूबसूरत और विज़ुअल (Visual) वर्णन कर रहे हैं।
            जब इंसान रात के घने अंधेरे में होता है, तो उसे रस्सी भी सांप नज़र आती है, और वह डर के मारे काँपता रहता है (यही हमारी स्थिति है जहाँ हम दुनिया के दुःखों से डर रहे हैं)।
            अंधेरे (अज्ञान) को आप लाठी मारकर या रोकर नहीं भगा सकते। अंधेरे को भगाने का पूरी दुनिया में सिर्फ एक ही तरीका है—'रोशनी' (Light/ज्ञान)।
            जब एक योग्य गुरु के मार्गदर्शन और निष्काम कर्मयोग से इंसान के भीतर 'आत्मज्ञान' (कि मैं शरीर नहीं, आत्मा हूँ) की चिंगारी जलती है, तो वह अज्ञान हमेशा के लिए नष्ट ('नाशितम्') हो जाता है।
            श्रीकृष्ण उस ज्ञान की तुलना किसी छोटे दीये से नहीं, बल्कि 'आदित्यवत्' (दोपहर के चमकते हुए सूरज) से करते हैं। 
            जैसे ही सूरज निकलता है, सारी दुनिया की असली तस्वीर साफ हो जाती है; उसी तरह जैसे ही आत्मज्ञान का सूरज दिमाग में उगता है, इंसान को ब्रह्मांड का सबसे बड़ा रहस्य—साक्षात् परमेश्वर ('तत्परम्')—बिल्कुल साफ-साफ दिखाई देने लगता है। सारा डर हमेशा के लिए खत्म हो जाता है।
        """.trimIndent(),
        english = """
            But for those exalted individuals whose dense ignorance is utterly completely destroyed (Nashitam) by the blazing acquisition of pure spiritual knowledge (Jnanena)...
            that absolute knowledge illuminates everything entirely and flawlessly reveals the Supreme Absolute Truth (Tat param), exactly as the blazing sun (Aditya-vat) lights up the entire world in the daytime.
            Having just described the terrifying, pitch-black darkness of ignorance, the Lord now paints an incredibly stunning, highly visual, and majestic picture of the 'Sunrise of Absolute Knowledge'.
            When a human being is trapped in pitch-black darkness, he hallucinates a harmless rope to be a venomous snake and violently trembles in sheer terror (this is exactly our current pathetic state, terrified of temporary worldly miseries).
            You can absolutely never drive away darkness (ignorance) by beating it with a stick or crying profusely. There is exactly one singular weapon in the entire universe that destroys darkness—'Light' (Jnana/Knowledge).
            When the spark of true 'Self-Realization' (that I am not this decaying body, but an immortal soul) is finally ignited within a human through a bonafide Guru and selfless action, that horrific ignorance is permanently annihilated ('Nashitam').
            Sri Krishna deliberately does not compare this knowledge to a flickering candle; He compares it to 'Aditya-vat' (the blinding, roaring, midday Sun).
            The exact microsecond the sun rises, the true reality of the entire world is instantly and flawlessly exposed; similarly, the moment the Sun of Spiritual Knowledge explodes inside the brain, the human flawlessly and directly perceives the universe's ultimate, supreme secret—The Supreme Godhead ('Tat Param'). All fear evaporates eternally.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            तद्बुद्धयस्तदात्मानस्तन्निष्ठास्तत्परायणाः |
            गच्छन्त्यपुनरावृत्तिं ज्ञाननिर्धूतकल्मषाः || १७ ||
        """.trimIndent(),
        hindi = """
            जिनकी बुद्धि पूरी तरह से केवल उस परमात्मा में ही स्थित है (तद्बुद्धयः), जिनका मन (आत्मा) केवल उसी परमात्मा में तल्लीन है (तदात्मानः), जिनकी पूरी निष्ठा (श्रद्धा) केवल उसी परम सत्य में है (तन्निष्ठाः), और जिन्होंने केवल उसी परमेश्वर को अपना एकमात्र अंतिम आश्रय मान लिया है (तत्परायणाः)...
            ऐसे महापुरुष, जिनका सारा पाप (कल्मष) ज्ञान के द्वारा पूरी तरह धुल (निर्धूत) चुका है, वे उस परम अवस्था (मोक्ष) को प्राप्त करते हैं जहाँ से फिर कभी संसार में लौटना नहीं पड़ता (अपुनरावृत्तिं)।
            यह श्लोक एक इंसान को 'सुपर-एनलाइटेन्ड' (Super-Enlightened) बनाने का एक 'फोर-व्हील ड्राइव' (Four-wheel drive) फॉर्मूला है। भगवान बता रहे हैं कि मोक्ष पाने के लिए आपको अपना पूरा सिस्टम (System) भगवान पर लॉक (Lock) करना होगा:
            १. 'तद्बुद्धयः' (Intelligence): आपकी सोचने-समझने की शक्ति 100% भगवान के विज्ञान पर फोकस होनी चाहिए (कोई दुनियावी कचरा नहीं)।
            २. 'तदात्मानः' (Mind/Heart): आपका मन और भावनाएं केवल भगवान के प्रेम में डूबी होनी चाहिए।
            ३. 'तन्निष्ठाः' (Faith): आपका विश्वास (श्रद्धा) एक चट्टान की तरह केवल ईश्वर पर टिका होना चाहिए।
            ४. 'तत्परायणाः' (Ultimate Goal): आपका जीवन का एकमात्र और आखिरी लक्ष्य (Refuge) सिर्फ भगवान को पाना होना चाहिए, न कि जन्नत (स्वर्ग) या पैसा।
            जब इंसान का पूरा दिमाग, दिल और आत्मा इस तरह से भगवान पर पूरी तरह 'लॉक' (Lock) हो जाता है, तो ज्ञान की यह भयंकर शक्ति उसके सारे जन्मों के पापों (कल्मष) को ऐसे 'धो' (निर्धूत) देती है जैसे वाशिंग मशीन दाग निकाल देती है।
            और इसका सबसे बड़ा इनाम क्या है? 'अपुनरावृत्तिं' (No Return Ticket)। वे उस वैकुंठ (मोक्ष) में चले जाते हैं जहाँ से उन्हें दोबारा कभी इस दुःख भरी दुनिया में रोने के लिए जन्म नहीं लेना पड़ता।
        """.trimIndent(),
        english = """
            When one's intelligence is completely, 100% locked on the Supreme (Tad-buddhayah), when one's mind and soul are entirely absorbed in Him (Tad-atmanah), when one's faith is utterly fixed purely on Him (Tan-nishthah), and when one takes ultimate, absolute refuge exclusively in Him (Tat-parayanah)...
            then such fully enlightened souls, having all their misgivings and toxic sins completely washed away by absolute knowledge (Jnana-nirdhuta-kalmashah), proceed straight to that supreme path of liberation from which there is absolutely no return (Apunar-avrittim).
            This spectacular verse provides the ultimate, foolproof 'Four-Wheel Drive' master-formula for achieving 'Super-Enlightenment'. The Lord declares that to seize absolute Moksha, you must aggressively 'Lock' your entire operating system onto God:
            1. 'Tad-buddhayah' (Intelligence): Your highly rational intelligence and logic must be 100% laser-focused exclusively on the science of the Supreme (zero worldly garbage).
            2. 'Tad-atmanah' (Mind/Heart): Your emotional mind and inner self must be violently submerged and intoxicated purely in the love of God.
            3. 'Tan-nishthah' (Faith): Your absolute trust and faith must be anchored onto God like an impenetrable, immovable titanium rock.
            4. 'Tat-parayanah' (Ultimate Goal): The absolute, final, and only refuge and goal of your entire existence must be attaining the Lord, completely rejecting cheap goals like heaven or billions.
            When a human's entire brain, heart, and soul are flawlessly 'Locked' onto the Supreme in this 4-dimensional manner, the blinding power of this knowledge ruthlessly and violently 'Washes away' (Nirdhuta) all the toxic sins (Kalmasha) of millions of lifetimes exactly like a cosmic washing machine.
            And what is the supreme, ultimate grand prize? 'Apunar-avrittim' (Absolutely No Return Ticket). They transcend directly to the eternal Vaikuntha (Spiritual Sky), completely guaranteeing they will never, ever be forced to take birth and suffer in this miserable material matrix again.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            विद्याविनयसम्पन्ने ब्राह्मणे गवि हस्तिनि |
            शुनि चैव श्वपाके च पण्डिताः समदर्शिनः || १८ ||
        """.trimIndent(),
        hindi = """
            जो सच्चे ज्ञानी महापुरुष (पण्डिताः) होते हैं, वे विद्या (ज्ञान) और विनय (विनम्रता) से युक्त एक अत्यंत श्रेष्ठ 'ब्राह्मण' को, एक 'गाय' को, एक 'हाथी' को...
            तथा एक 'कुत्ते' (शुनि) को और कुत्ते का मांस खाने वाले 'चांडाल' (श्वपाके) को भी, बिल्कुल एक समान दृष्टि (समदर्शिनः) से ही देखते हैं।
            यह पूरी भगवद्गीता का सबसे महान और 'समानता' (Equality / Universal Brotherhood) का सबसे बड़ा संदेश देने वाला श्लोक है।
            एक साधारण और अज्ञानी इंसान दुनिया को हमेशा 'बाहरी शरीर' (Hardware) के आधार पर जज (Judge) करता है—यह बड़ा आदमी है, यह नीची जाति का है, यह जानवर है।
            लेकिन एक 'पंडित' (Realized Master) के पास ज्ञान का एक 'एक्स-रे विज़न' (X-Ray Vision) आ जाता है। वह बाहरी चमड़ी या शरीर को नहीं देखता, वह सीधे उसके भीतर बैठी हुई 'आत्मा' (Soul) को देखता है।
            समाज की नजर में एक विद्वान और संस्कारी ब्राह्मण (सबसे ऊँचा स्तर) और एक अछूत या चांडाल (सबसे नीचा स्तर) में बहुत बड़ा फर्क है। जानवरों में गाय (पवित्र) और कुत्ते (अपवित्र) में बहुत फर्क है।
            लेकिन ज्ञानी पुरुष की नजर में ये सब केवल अलग-अलग प्रकार के 'कपड़े' (Bodies) हैं जो आत्मा ने पहने हुए हैं। वह जानता है कि ब्राह्मण के अंदर और कुत्ते के अंदर बिल्कुल एक ही (Same) ईश्वर का अंश मौजूद है।
            'समदर्शिनः' का मतलब यह नहीं है कि वह कुत्ते को अपने साथ मेज पर बैठाकर खाना खिलाएगा (शारीरिक व्यवहार तो शरीर के अनुसार ही होगा); इसका मतलब है कि उसके मन में सबके लिए 'सम्मान' और 'आध्यात्मिक प्रेम' बिल्कुल बराबर (100% Equal) होता है, किसी के लिए नफरत नहीं होती।
        """.trimIndent(),
        english = """
            The humble sages, by virtue of their true, transcendental knowledge (Panditah), see with perfect, absolute equal vision (Sama-darshinah) a highly learned and gentle Brahmana (Vidya-vinaya-sampanne), a cow (Gavi), an elephant (Hastini)...
            a dog (Shuni), and even an absolute outcaste or dog-eater (Shvapake).
            This is undeniably the absolute greatest, most magnificent, and legendary verse in the entire Bhagavad Gita propagating the supreme doctrine of 'Universal Equality and Brotherhood'.
            An ordinary, deeply ignorant mortal constantly and pathetically judges the entire world strictly based on the superficial 'External Body' (The biological Hardware)—thinking, "He is a billionaire, he is a low-caste, this is just an animal."
            But a true 'Pandita' (A fully self-realized Master) has successfully developed a staggering spiritual 'X-Ray Vision'. He completely bypasses the external flesh and bone and looks directly, piercingly at the eternal 'Soul' residing within.
            From a strict societal viewpoint, there is a colossal, infinite gap between an elite, highly educated, and gentle Brahmana (the highest standard) and a filthy outcaste or dog-eater (the lowest standard). Among animals, the cow is highly sacred, and the dog is considered impure.
            But through the flawless eyes of the Master, these are merely different biological 'Costumes' or 'Vehicles' the souls are temporarily driving. He perfectly realizes that the exact same, pure spiritual spark of God resides identically inside the elite Brahmana and the stray dog.
            'Sama-darshinah' (Equal Vision) absolutely does not mean he foolishly invites a tiger to dine at his table (practical bodily interactions remain appropriate to the body type); it profoundly means his internal, spiritual 'Respect' and 'Divine Love' for every single entity is 100% equally distributed, completely devoid of any toxic hatred or prejudice.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            इहैव तैर्जितः सर्गो येषां साम्ये स्थितं मनः |
            निर्दोषं हि समं ब्रह्म तस्माद् ब्रह्मणि ते स्थिताः || १९ ||
        """.trimIndent(),
        hindi = """
            जिन महापुरुषों का मन इस 'समभाव' (सबमें एक ही ईश्वर को देखने की समानता) में पूरी तरह स्थित (स्थितं) हो गया है, उन्होंने जीते जी इसी संसार में (इहैव) संपूर्ण सृष्टि (जन्म-मृत्यु के चक्र) को जीत लिया है (जितः सर्गः)।
            क्योंकि परब्रह्म (परमात्मा) पूरी तरह से निर्दोष (पाप-रहित) और बिल्कुल सम (समान/भेदभाव रहित) है, इसलिए वे (समदर्शी लोग) साक्षात् परब्रह्म (ईश्वर) में ही स्थित हैं।
            यह श्लोक समभाव (Equality/Balance) की अकल्पनीय और डरावनी ताकत (Power) का सबूत है।
            साधारण लोग सोचते हैं कि मोक्ष (Liberation) मरने के बाद स्वर्ग जाकर मिलेगा।
            लेकिन भगवान एक बहुत बड़ा रहस्य (Secret) खोल रहे हैं: "इहैव तैर्जितः सर्गः"—जिस इंसान ने अपने दिमाग को हर हाल में और हर जीव के प्रति 'समान' (Balanced/Equal) कर लिया है, उसने मरने का इंतज़ार नहीं किया; उसने 'इसी जिंदगी में' और 'इसी धरती पर' पूरे ब्रह्मांड (Matrix) को हरा दिया है! वह जीते जी मुक्त (Jivan-mukta) हो गया है।
            भगवान इसका बहुत ही तार्किक (Logical) कारण भी बताते हैं।
            भगवान (ब्रह्म) का नेचर (Nature) कैसा है? वह 'निर्दोष' (100% Pure/Flawless) है और 'सम' (वह चींटी और हाथी दोनों से बराबर प्यार करता है, उसमें कोई भेदभाव नहीं है)।
            तो जब किसी इंसान का मन भी दुनिया की सारी नफरत (दोष) छोड़कर पूरी तरह 'समान' (सम) हो जाता है, तो उस इंसान का मन बिल्कुल 'भगवान के माइंड' (Mind of God) की तरह हो जाता है।
            और जब इंसान का दिमाग भगवान जैसा हो गया, तो इसका सीधा मतलब है कि वह इंसान अब भौतिक दुनिया में नहीं, बल्कि साक्षात् 'ब्रह्म में स्थित' (Living in God) है। वह चलता-फिरता भगवान बन चुका है।
        """.trimIndent(),
        english = """
            Those whose minds are perfectly and permanently established in absolute sameness and equanimity (Samye sthitam manah) have already completely conquered the entire cycle of birth and death (Jitah sargah) right here in this very life (Ihaiva).
            Because the Supreme Brahman is completely flawless, totally without sin (Nirdosham), and absolutely equal to all (Samam), therefore, such persons of equal vision are already perfectly situated in the Supreme Brahman (Brahmani te sthitah).
            This verse is the absolute, staggering proof of the unimaginable, terrifying power of 'Equanimity' (Mental Balance and Equal Vision).
            Ordinary, ignorant people foolishly hallucinate that ultimate Moksha (Liberation) is a magical destination they will only reach after their physical death.
            But the Lord shatters this myth and drops a massive secret: "Ihaiva tair jitah sargah"—The elite master who has successfully programmed his brain to remain completely 'Balanced and Equal' towards all situations and all living beings has absolutely not waited for death; he has violently 'Conquered the entire Cosmic Matrix' (conquered birth and death) right here on this earth, while still biologically alive! He is a 'Jivan-mukta' (Liberated while living).
            The Lord provides highly flawless, razor-sharp logic for this.
            What is the exact psychological nature of God (Brahman)? He is 'Nirdosham' (100% impeccably pure/flawless) and 'Samam' (He loves the microscopic ant and the massive elephant equally; He has zero bias or prejudice).
            Therefore, when a human forcefully upgrades his own mind, violently deleting all toxic hatred (faults) and achieving that exact 100% 'Equal Vision', his mind becomes a perfect, identical replica of the 'Mind of God'.
            And when a human's consciousness flawlessly matches God's consciousness, it literally proves that he no longer exists in the material matrix; he is directly "Living inside Brahman" (Situated in God). He has elevated into a walking, breathing manifestation of the Divine.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            न प्रहृष्येत्प्रियं प्राप्य नोद्विजेत्प्राप्य चाप्रियम् |
            स्थिरबुद्धिरसम्मूढो ब्रह्मविद् ब्रह्मणि स्थितः || २० ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति किसी बहुत प्यारी (प्रिय) चीज़ को पाकर खुशी से पागल (अहंकारी) नहीं होता (न प्रहृष्येत्), और किसी अत्यंत बुरी (अप्रिय) घटना के होने पर डिप्रेशन में जाकर घबराता नहीं है (न उद्विजेत्)...
            जिसकी बुद्धि पूरी तरह स्थिर (स्थिरबुद्धिः) है, जो हर प्रकार के मोह (अज्ञान) से पूरी तरह मुक्त (असम्मूढः) है, ऐसा ब्रह्म को जानने वाला ज्ञानी (ब्रह्मवित्) साक्षात् परब्रह्म में ही स्थित (ब्रह्मणि स्थितः) रहता है।
            यह श्लोक 'परफेक्ट इमोशनल स्टेबिलिटी' (Perfect Emotional Stability / Emotional Intelligence) का सबसे बड़ा 'गोल्ड स्टैंडर्ड' (Gold Standard) है।
            भगवान बता रहे हैं कि जो इंसान सच में 'ईश्वर' को जान गया है, उसका 'रिएक्शन' (Reaction) दुनिया की घटनाओं पर कैसा होता है।
            साधारण इंसान की भावनाएं 'रोलर कोस्टर' (Roller Coaster) की तरह होती हैं। अगर उसे कोई लॉटरी लग जाए या फेवरेट (Favorite) चीज़ मिल जाए (प्रियं प्राप्य), तो वह 'प्रहृष्येत्' (खुशी से पागल होकर अपना आपा खो बैठता है और अहंकारी हो जाता है)।
            और अगर उसकी नौकरी चली जाए या कोई नुकसान हो जाए (अप्रियं प्राप्य), तो वह 'उद्विजेत्' (भयंकर घबराहट, स्ट्रेस और डिप्रेशन में डूबकर रोने लगता है)।
            लेकिन 'ब्रह्मवित्' (ईश्वर को जानने वाला) महापुरुष जानता है कि यह दुनिया एक फिल्म (Movie) की तरह है जहाँ कुछ भी परमानेंट (Permanent) नहीं है। इसलिए जब उसे कोई बहुत बड़ी सफलता मिलती है, तो वह मुस्कुरा कर शांत रहता है। और जब कोई बहुत बड़ा नुकसान होता है, तब भी वह चट्टान की तरह स्थिर ('स्थिरबुद्धिः') रहता है।
            उसे कोई भी चीज़ भ्रमित (सम्मूढ) नहीं कर सकती। क्योंकि वह दुनिया में नहीं, बल्कि 'ब्रह्म' (परमात्मा की असीम शांति) में रह रहा होता है।
        """.trimIndent(),
        english = """
            A person who absolutely does not rejoice, gloat, or become arrogantly overjoyed upon achieving something highly pleasant (Na prahrishyet priyam prapya), nor does he become agitated, terrified, or depressed upon obtaining something highly unpleasant (Nodvijet prapya chapriyam)...
            who is possessed of an unshakeably self-intelligent, perfectly steady mind (Sthira-buddhir), who is completely unbewildered and free from all illusions (Asammudho), and who perfectly knows the Supreme Science of God (Brahma-vit), is undoubtedly already situated in transcendence (Brahmani sthitah).
            This spectacular verse establishes the absolute, ultimate 'Gold Standard' for 'Perfect Emotional Stability' (Supreme Emotional Intelligence) in the universe.
            The Lord is vividly detailing exactly how a genuine, God-realized master 'Reacts' to the extreme, violent fluctuations of material existence.
            An ordinary, ignorant mortal's emotional state is exactly like a chaotic 'Roller Coaster'. If he wins a massive lottery or secures a highly coveted prize (Priyam prapya), he violently 'Prahrishyet' (goes absolutely crazy with arrogant euphoria, completely losing his mind and humility).
            Conversely, if he gets brutally fired from his job or suffers a devastating financial crash (Apriyam prapya), he instantly 'Udvijet' (violently crashes into crippling anxiety, panic attacks, and dark depression, weeping bitterly).
            But the elite 'Brahma-vit' (The Knower of the Supreme) profoundly realizes that this entire material matrix is merely a temporary, flickering movie where absolutely nothing is permanent. Therefore, when a massive, glorious success hits him, he simply smiles and remains serenely calm. And when a catastrophic tragedy strikes, he remains unshakable and unmoved like a massive granite mountain ('Sthira-buddhir').
            Absolutely no illusion in the universe can bewilder or hijack him (Asammudhah). Because psychologically, he is no longer living in this toxic material world; he is permanently residing ('Brahmani sthitah') in the infinite, indestructible peace of God.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            बाह्यस्पर्शेष्वसक्तात्मा विन्दत्यात्मनि यत्सुखम् |
            स ब्रह्मयोगयुक्तात्मा सुखमक्षयमश्नुते || २१ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य बाहरी भौतिक इन्द्रिय-सुखों (बाह्यस्पर्शेषु) में बिल्कुल भी आसक्त (Attached) नहीं है, वह अपनी ही आत्मा (भीतर) में उस असीम दिव्य सुख (यत्सुखम्) का अनुभव (विन्दति) करता है।
            ऐसा महापुरुष, जिसका मन परब्रह्म (परमात्मा) के ध्यान रूपी योग में पूरी तरह जुड़ा (युक्त) हुआ है, वह 'अक्षय' (कभी न खत्म होने वाले / Infinite) परम आनंद को प्राप्त करता है (अश्नुते)।
            इस श्लोक में भगवान श्रीकृष्ण दुनिया के सबसे बड़े रहस्य—'सच्ची खुशी (Happiness) का स्रोत (Source) क्या है?'—का खुलासा कर रहे हैं।
            आम इंसान सोचता है कि खुशी 'बाहर' (Outside) है। वह सोचता है कि जब मेरी त्वचा (Skin) किसी मुलायम चीज़ को छुएगी, या जीभ पिज़्ज़ा खाएगी, या आँखें कोई सुंदर चीज़ देखेंगी ('बाह्यस्पर्श' - External contacts), तब मुझे खुशी मिलेगी। वह खुशी के लिए बाहरी दुनिया का भिखारी (Beggar) बन जाता है।
            लेकिन ज्ञानी पुरुष ('असक्तात्मा') जानता है कि बाहर से मिलने वाली हर खुशी एक 'धोखा' है, जो कुछ सेकंड में खत्म हो जाती है और बाद में दुःख देती है।
            इसलिए वह अपना फोकस (Focus) 180 डिग्री घुमाकर 'अंदर' (Within) की तरफ ले जाता है। जब वह बाहर की वासनाओं को काट देता है, तो उसे अपनी 'आत्मा' (Self) के भीतर ही एक ऐसा जादुई और भयंकर सुख (सुखम्) मिलता है, जिसके सामने दुनिया के सारे सुख कचरे जैसे लगते हैं।
            और जब वह अपनी आत्मा के जरिए 'ब्रह्म' (परमात्मा) से जुड़ जाता है (ब्रह्मयोगयुक्तात्मा), तो उसे जो आनंद मिलता है वह 'अक्षय' (Akshaya) होता है—यानी वह आनंद कभी कम नहीं होता, कभी एक्सपायर (Expire) नहीं होता, और हमेशा के लिए (Forever) बना रहता है।
        """.trimIndent(),
        english = """
            Such a highly liberated person is absolutely not attracted to or attached to any external, material sense pleasures (Bahya-sparsheshv asaktatma), but instead flawlessly discovers the supreme transcendental happiness situated deep within his own self (Vindaty atmani yat sukham).
            And because his purified soul is perfectly and permanently united with the Supreme Brahman in deep yogic trance (Sa brahma-yoga-yuktatma), he constantly enjoys an infinite, eternal, and inexhaustible bliss (Sukham akshayam ashnute).
            In this breathtaking verse, Lord Sri Krishna brutally exposes the absolute greatest secret in the universe—'What is the true, exact Source of Happiness?'
            The pathetic, ignorant mortal deeply hallucinates that happiness exists purely 'Outside'. He firmly believes that only when his physical skin rubs against something soft, or his tongue tastes junk food, or his eyes see a seductive form ('Bahya-sparsha' - external sensory contacts), will he extract joy. He reduces himself to a pathetic, desperate 'Beggar' begging the external material world for drops of pleasure.
            But the elite, self-realized sage ('Asaktatma') possesses the piercing intelligence to know that every single drop of external pleasure is a massive 'Scam'; it lasts for mere seconds and inevitably guarantees future suffering.
            Therefore, he violently rotates his focus 180 degrees 'Inward'. By aggressively cutting off all external toxic cravings, he taps directly into his own eternal 'Soul' (Atmani) and unearths an unimaginably magical, explosive, and infinite reservoir of pure ecstasy (Sukham) that makes all worldly billionaires look like paupers.
            And when his soul successfully plugs directly into the 'Supreme Brahman' (God) through deep meditation (Brahma-yoga-yuktatma), the bliss he downloads is entirely 'Akshaya'—meaning it is 100% Inexhaustible; it never degrades, it never reaches an expiration date, and it roars infinitely forever.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            ये हि संस्पर्शजा भोगा दुःखयोनय एव ते |
            आद्यन्तवन्तः कौन्तेय न तेषु रमते बुधः || २२ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! इन्द्रियों और उनके भौतिक विषयों (चीजों) के स्पर्श (संपर्क) से पैदा होने वाले जितने भी भोग (सुख) हैं, वे वास्तव में केवल दुःखों को जन्म देने वाले (दुःखयोनयः) ही हैं।
            क्योंकि इन सभी सुखों की एक शुरुआत (आदि) होती है और एक अंत (अंत) होता है (यानी ये अस्थायी हैं)। इसलिए, कोई भी बुद्धिमान (बुधः) और विवेकशील पुरुष कभी भी इन झूठे सुखों में रमण (आनंद) नहीं करता।
            यह भगवद्गीता के सबसे 'प्रैक्टिकल और आई-ओपनिंग' (Practical and Eye-opening) श्लोकों में से एक है। यह भौतिक सुखों (Material Pleasures) का सबसे शानदार पोस्टमार्टम (Post-mortem) है।
            श्रीकृष्ण एक बहुत ही कड़वा सच बता रहे हैं: जिस चीज़ को हम 'सुख' या 'मज़ा' (Enjoyment) कहते हैं (जैसे स्वादिष्ट खाना, शराब, या कामवासना), वह वास्तव में 'दुःख की माँ' (दुःखयोनि - Womb of Misery) है।
            क्यों? इसके दो वैज्ञानिक कारण हैं:
            १. आदत (Addiction) और डर: जब आप किसी बाहरी सुख को भोगते हैं, तो आपको उसकी आदत पड़ जाती है। जब वह नहीं मिलता, तो आप तड़पते हैं (फ्रस्ट्रेशन)। और जब वह मिलता है, तो आपको उसे खोने का डर लगा रहता है। दोनों ही स्थितियों में यह आपको स्ट्रेस (Stress) ही देता है।
            २. 'आद्यन्तवन्तः' (Beginning and End): दुनिया का कोई भी भौतिक सुख हमेशा नहीं रहता। फिल्म 3 घंटे में खत्म हो जाती है, स्वादिष्ट खाना कुछ मिनटों में पच जाता है, और जवानी कुछ सालों में बुढ़ापे में बदल जाती है। जो चीज़ 'शुरू' हुई है, उसका 'खत्म' होना तय है, और जब सुख खत्म होता है, तो वह पीछे भयंकर दुःख छोड़ जाता है।
            इसलिए जो इंसान सच में 'बुधः' (Highly Intelligent) है, वह इन दो-कौड़ी के टेंपररी (Temporary) सुखों में अपना कीमती समय और अपनी आत्मा को बर्बाद नहीं करता। वह केवल परमानेंट (Permanent) सुख (ईश्वर) की तलाश करता है।
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya)! An intelligent person knows perfectly well that all material pleasures and enjoyments born of the contact between the physical senses and their objects (Samsparsha-ja bhoga) are undeniably the true sources and wombs of all misery (Duhkha-yonayah eva te).
            Because all such material pleasures possess a definite beginning and an inevitable end (Ady-antavantah), a truly wise and highly intelligent man (Budhah) never takes delight or rejoices in them.
            This is universally hailed as one of the most incredibly 'Practical, brutal, and Eye-opening' verses in the entire Gita. It acts as the ultimate, flawless clinical 'Post-mortem' of all Material Pleasures.
            Lord Sri Krishna drops a highly bitter, yet absolute truth: Every single thing that ignorant mortals aggressively chase and label as 'Happiness' or 'Fun' (such as delicious gourmet food, toxic intoxication, or sexual lust) is, in absolute reality, the literal 'Mother and Womb of all Misery' (Duhkha-yoni).
            Why? He gives two iron-clad scientific reasons:
            1. Toxic Addiction & Fear: The exact moment you taste an external material pleasure, you instantly develop a crippling psychological addiction to it. When you can't get it, you violently burn in frustrated agony. When you do have it, you constantly suffer from the terrifying paranoia of losing it. In both scenarios, it purely generates heavy toxic stress.
            2. 'Ady-antavantah' (Beginning and End): Absolutely zero physical pleasure in this material matrix is permanent. A blockbuster movie ends in 3 hours, a luxurious meal is swallowed and gone in minutes, and youthful beauty violently degrades into wrinkled old age. Whatever has a 'Start' is 100% guaranteed to have an 'End', and the exact moment that temporary pleasure abruptly dies, it leaves behind a massive, agonizing void of sorrow.
            Therefore, a human being who is genuinely 'Budhah' (An Elite, Highly Intelligent Master) absolutely refuses to pathetically waste his priceless life and pure soul rolling around in these cheap, two-cent, temporary thrills. He relentlessly hunts solely for the Infinite, Permanent Joy (God).
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            शक्नोतीहैव यः सोढुं प्राक्शरीरविमोक्षणात् |
            कामक्रोधोद्भवं वेगं स युक्तः स सुखी नरः || २३ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य अपने इस वर्तमान शरीर को त्यागने (मरने) से पहले ही (प्राक् शरीरविमोक्षणात्), इसी जन्म में और इसी दुनिया में (इहैव)...
            अपने मन में उठने वाले 'काम' (भयंकर वासना/इच्छा) और 'क्रोध' (भयंकर गुस्से) के अत्यंत तीव्र वेग (तूफान/Force) को सहने (और रोकने) में पूरी तरह सफल (सक्षम) हो जाता है...
            वही मनुष्य सच्चा योगी (युक्तः) है, और वास्तव में केवल वही मनुष्य इस संसार में सच्चा सुखी (सुखी नरः) है।
            श्रीकृष्ण यहाँ इंसान का सबसे बड़ा 'लाइफ-टेस्ट' (Life Test / चुनौती) बता रहे हैं।
            मनुष्य के शरीर में दो सबसे भयंकर और विस्फोटक (Explosive) तूफान आते हैं: 'काम का वेग' (Lust—सेक्स या पैसे की अचानक और अंधी चाहत) और 'क्रोध का वेग' (Anger—अचानक आने वाला भयंकर और विनाशकारी गुस्सा)।
            इनका 'वेग' (Velocity/Force) इतना तेज़ होता है कि यह इंसान के दिमाग की सारी सर्किट (Circuit) जला देता है और उसे अंधा कर देता है, जिससे इंसान मर्डर या रेप जैसे बड़े पाप कर बैठता है।
            भगवान एक बहुत सख्त डेडलाइन (Deadline) देते हैं: "प्राक् शरीरविमोक्षणात्" (मरने से पहले!)।
            अगर इंसान ने मरने से पहले इन दो तूफानों (काम और क्रोध) के झटकों को सहना और उन्हें कंट्रोल करना (सोढुं) नहीं सीखा, तो उसका पूरा जीवन फेल (Fail) है और वह अगले जन्म में फिर नर्क में जाएगा।
            लेकिन जो वीर योद्धा जब गुस्सा या वासना का तूफान आए, तो उस समय धैर्य से काम ले और उस आंधी को अपने ऊपर से बिना कोई पाप किए गुजर जाने दे...
            वही इस दुनिया का असली 'हीरो' और 'सच्चा सुखी' इंसान है। क्योंकि जिसने अपने मन के राक्षसों को हरा दिया, उसे दुनिया की कोई ताकत दुःखी नहीं कर सकती।
        """.trimIndent(),
        english = """
            Before definitively giving up this present physical body (Prak sharira-vimokshanat), if a human being is successfully able to tolerate and perfectly withstand right here in this very life (Ihaiva)...
            the violent, hurricane-like urges and fierce forces generated by intense material lust and blinding anger (Kama-krodhodbhavam vegam)...
            then he is undoubtedly a perfectly situated Yogi (Yuktah), and he alone is truly a happy man in this world (Sukhi narah).
            Sri Krishna is explicitly declaring the absolute greatest, ultimate 'Life Test' and supreme challenge for any human being on earth here.
            Inside the human biological machine, two absolutely terrifying, highly explosive hurricanes constantly erupt: 'The Velocity of Kama' (Lust—the sudden, blinding, maddening physical craving for sex or extreme wealth) and 'The Velocity of Krodha' (Anger—the sudden, violent, destructive volcanic eruption of rage).
            The 'Vega' (Velocity/Force) of these urges is so staggeringly high that it instantly violently overloads and short-circuits the brain's rational logic, completely blinding the human, forcing him to commit horrific, life-destroying crimes like murder or assault.
            The Lord issues a terrifying, strict, non-negotiable Deadline: "Prak sharira-vimokshanat" (You must absolutely conquer this BEFORE physical death!).
            If a human helplessly fails to learn how to expertly tolerate, absorb, and neutralize (Sodhum) the brutal shockwaves of these two hurricanes before he dies, his entire human existence is a colossal failure, and he guarantees himself a horrific hellish rebirth.
            But the elite warrior who, when the violent tsunami of lust or anger strikes, remains as cold and immovable as titanium, allowing the toxic storm to pass over him without committing a single sinful reaction...
            He is officially the universe's ultimate 'Hero' and the absolute ONLY 'Truly Happy' man on earth. Because he who violently slaughters the demons inside his own head can absolutely never be made miserable by any external force in the matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            योऽन्तःसुखोऽन्तरारामस्तथान्तर्ज्योतिरेव यः |
            स योगी ब्रह्मनिर्वाणं ब्रह्मभूतोऽधिगच्छति || २४ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य अपनी ही आत्मा के भीतर (अंदर) परम सुख का अनुभव करता है (अन्तःसुखः), जो केवल अपनी ही आत्मा के भीतर रमण करता है (अन्तरारामः), और जो केवल अपनी ही आत्मा के भीतर ज्ञान के प्रकाश (ज्योति) को देखता है (अन्तर्ज्योतिः)...
            ऐसा वह महापुरुष, जो पूरी तरह से ब्रह्मरूप (भगवान के समान शुद्ध) हो चुका है (ब्रह्मभूतः), वह जीते जी और मरने के बाद भी परम 'ब्रह्म-निर्वाण' (ईश्वर में पूर्ण मुक्ति और शांति) को ही प्राप्त करता है।
            पिछले श्लोक में भगवान ने बताया था कि वासना (काम-क्रोध) को कैसे रोकना है। अब भगवान बता रहे हैं कि वासना रोकने के बाद जो खाली जगह बचेगी, उसे किस चीज़ से भरना है!
            भगवान उस 'सुपर-योगी' (Super-yogi) की तीन सबसे बड़ी खूबियां (Qualities) बता रहे हैं। उसका सब कुछ 'अंदर' (Internal) है, बाहर (External) कुछ नहीं है:
            १. 'अन्तःसुखः': उसे खुश होने के लिए बाहर की कोई कॉमेडी फिल्म, पार्टी या पैसा नहीं चाहिए। उसका सारा 'सुख' उसके अपने 'अंदर' भगवान के ध्यान से आता है।
            २. 'अन्तरारामः': वह बाहर लोगों की भीड़ में या क्लबों में 'मज़ा' (आराम) नहीं ढूँढता। जब वह आँखें बंद करके अपने अंदर बैठता है, तो वह अपनी ही चेतना में सबसे ज्यादा रिलैक्स (Relaxed) और 'मजे' में होता है।
            ३. 'अन्तर्ज्योतिः': उसे किसी बाहरी डिग्री, टीवी या लोगों की सलाह से 'ज्ञान' (Light/Direction) नहीं चाहिए। उसके 'अंदर' आत्मा का जो प्रकाश है, वही उसे जीवन का सही रास्ता दिखाता है।
            जो व्यक्ति पूरी तरह से 'सेल्फ-सफिशिएंट' (Self-sufficient / आत्मनिर्भर) हो चुका है, वह अब इंसान नहीं रहा, वह 'ब्रह्मभूतः' (भगवान का साक्षात् रूप) बन चुका है।
            ऐसा व्यक्ति इसी धरती पर रहते हुए ही 'ब्रह्म-निर्वाण' (Ultimate Liberation / सर्वोच्च आज़ादी) का मज़ा ले रहा होता है।
        """.trimIndent(),
        english = """
            One whose happiness is entirely within himself (Antah-sukhah), who is highly active and perfectly rejoices solely within himself (Antar-aramah), and whose aim and supreme illumination (light) is purely internal (Antar-jyotih)...
            such an incredibly exalted mystic is perfectly liberated in the Supreme, having already attained the exact qualitative nature of the Supreme (Brahma-bhutah), and he ultimately completely attains the Supreme Brahman (Brahma-nirvanam).
            In the previous verse, the Lord commanded the violent restriction of toxic lust and anger. Now, He brilliantly explains exactly what supreme, divine substance must fiercely fill the vacuum left behind by those annihilated desires!
            The Lord is defining the three absolute greatest, staggering qualities of a 'Super-Yogi'. His entire existence is 100% 'Internal'; he relies on absolutely zero 'External' input:
            1. 'Antah-sukhah' (Internal Happiness): He absolutely does not need to beg for a comedy movie, a loud party, or a billion dollars to feel happy. His entire reservoir of explosive 'Ecstasy' is generated purely from deep 'Within' through meditation on God.
            2. 'Antar-aramah' (Internal Rejoicing): He never desperately searches for 'Fun' or relaxation in chaotic crowds or toxic clubs. When he simply closes his eyes and dives deep inside his own soul, he experiences the most profound, intense, and highest 'Rejoicing' possible in the universe.
            3. 'Antar-jyotih' (Internal Illumination): He absolutely does not require cheap external degrees, media propaganda, or ignorant human advice for 'Knowledge' (Light/Direction). The blinding, blazing light of his own purified 'Internal' soul flawlessly guides his every step in life.
            A human being who has become this staggeringly 100% 'Self-Sufficient' is practically no longer a mortal man; he has been upgraded to 'Brahma-bhutah' (a walking, qualitative replica of God Himself).
            Such an elite master is actively enjoying 'Brahma-nirvanam' (Absolute, Ultimate Cosmic Liberation and Freedom) while still physically walking on this earth.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            लभन्ते ब्रह्मनिर्वाणमृषयः क्षीणकल्मषाः |
            छिन्नद्वैधा यतात्मानः सर्वभूतहिते रताः || २५ ||
        """.trimIndent(),
        hindi = """
            जिनके सभी पाप पूरी तरह से नष्ट हो चुके हैं (क्षीणकल्मषाः), जिनके मन के सारे संशय और भ्रम (द्वंद्व) ज्ञान की तलवार से कट चुके हैं (छिन्नद्वैधाः)...
            जिन्होंने अपने मन और इन्द्रियों को पूरी तरह अपने वश में कर लिया है (यतात्मानः), और जो हमेशा सभी प्राणियों (जीवों) के परम कल्याण (भलाई) में लगे रहते हैं (सर्वभूतहिते रताः)...
            ऐसे पूर्ण रूप से पवित्र और दयालु ऋषि (ज्ञानी महापुरुष) ही उस परम 'ब्रह्म-निर्वाण' (भगवान के धाम और परम शांति) को प्राप्त करते हैं (लभन्ते)।
            यहाँ भगवान श्रीकृष्ण 'लिबरेशन' (Liberation/मोक्ष) प्राप्त करने वाले एक सिद्ध ऋषि की सबसे सुंदर और संपूर्ण प्रोफाइल (Profile) बता रहे हैं।
            मोक्ष पाने के लिए केवल जंगल में आँख बंद करके बैठना ही काफी नहीं है, उसके लिए चार बहुत बड़े चेकबॉक्स (Checkboxes) टिक (Tick) करने होते हैं:
            १. 'क्षीणकल्मषाः': निष्काम कर्म करके पिछले जन्मों का सारा कचरा (पाप) डिलीट (Delete) करना होगा।
            २. 'छिन्नद्वैधाः': ज्ञान के द्वारा मन के सारे डाउट्स (Doubts / संशय) को खत्म करना होगा कि भगवान हैं या नहीं, मैं क्या हूँ।
            ३. 'यतात्मानः': अपने मन और शरीर पर एक कठोर मिलिट्री कमांडर (Military Commander) की तरह 100% कंट्रोल रखना होगा।
            ४. 'सर्वभूतहिते रताः': यह सबसे महत्वपूर्ण है! ज्ञानी इंसान स्वार्थी नहीं होता कि "मुझे मोक्ष मिल गया, अब दुनिया भाड़ में जाए।" वह 24 घंटे बिना किसी स्वार्थ के दुनिया के सारे जीवों (इंसान, जानवर, पेड़-पौधे) की भलाई (Social Welfare / Compassion) में पागलों की तरह लगा रहता है।
            जो व्यक्ति खुद को इतना शुद्ध कर लेता है और दुनिया की निस्वार्थ सेवा करता है, वैकुंठ (ब्रह्म-निर्वाण) के दरवाजे उसके लिए हमेशा के लिए खुल जाते हैं।
        """.trimIndent(),
        english = """
            Those exalted, holy sages (Rishayah) whose all sins and material impurities have been completely wiped out and exhausted (Kshina-kalmashah), whose all toxic doubts and dualities have been violently slashed to pieces by knowledge (Chinna-dvaidhah)...
            whose minds and senses are fiercely and perfectly disciplined and controlled (Yatatmanah), and who are constantly, intensely engaged in working for the ultimate welfare of all living entities (Sarva-bhuta-hite ratah)...
            they and they alone successfully attain the supreme spiritual liberation in the Absolute (Labhante brahma-nirvanam).
            Here, Lord Sri Krishna is flawlessly outlining the absolute most beautiful, comprehensive, and ultimate 'Profile' of a perfected, liberated Sage (Rishi) who successfully achieves Moksha.
            Attaining ultimate cosmic liberation absolutely does not mean just selfishly hiding in a dark forest with closed eyes; it requires forcefully ticking four massive, highly difficult Checkboxes:
            1. 'Kshina-kalmashah': You must completely delete and incinerate the colossal mountain of toxic garbage (Sins) accumulated from millions of past lives by executing fierce selfless action.
            2. 'Chinna-dvaidhah': You must use the blazing sword of absolute knowledge to violently slash and destroy every single microscopic Doubt (Illusion/Duality) regarding God, the soul, and reality.
            3. 'Yatatmanah': You must impose a titanium, draconian, Military-grade lockdown and 100% absolute control over your wildly flickering mind and rebellious physical senses.
            4. 'Sarva-bhuta-hite ratah': This is the absolute most critical crown jewel! A truly enlightened master is never a selfish parasite who thinks, "I got my enlightenment, now let the rest of the world burn." He actively, aggressively, and madly dedicates his entire existence 24/7 to the absolute 'Supreme Welfare' and upliftment of ALL living entities (humans, animals, and nature) with zero personal motive.
            The eternal, majestic gates of Vaikuntha (Brahma-nirvanam) swing wide open permanently for that phenomenal superhero who purifies himself to this staggering altitude and serves the universe with such blinding compassion.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            कामक्रोधवियुक्तानां यतीनां यतचेतसाम् |
            अभितो ब्रह्मनिर्वाणं वर्तते विदितात्मनाम् || २६ ||
        """.trimIndent(),
        hindi = """
            जो लोग 'काम' (सांसारिक वासनाओं) और 'क्रोध' (गुस्से) से पूरी तरह मुक्त हो चुके हैं (कामक्रोधवियुक्तानां), जिन्होंने अपने मन को बहुत अच्छी तरह से अपने पूर्ण नियंत्रण में कर लिया है (यतचेतसाम्)...
            और जिन्होंने अपनी आत्मा (स्वयं के सच्चे ईश्वरीय स्वरूप) का साक्षात् अनुभव कर लिया है (विदितात्मनाम्), ऐसे निरंतर प्रयत्नशील संन्यासियों (यतीनां) के लिए...
            परम 'ब्रह्म-निर्वाण' (ईश्वर की पूर्ण शांति और मोक्ष) हर ओर से (अभितः), अर्थात् जीते जी और मरने के बाद, हमेशा ही प्राप्त रहता है (वर्तते)।
            भगवान यहाँ एक बार फिर से 'काम' और 'क्रोध' को इंसान का सबसे बड़ा दुश्मन घोषित कर रहे हैं और बता रहे हैं कि मोक्ष (Liberation) कोई ऐसी जगह नहीं है जहाँ मरने के बाद फ्लाइट (Flight) से जाना पड़ता है।
            श्रीकृष्ण कहते हैं कि जो इंसान अपने भीतर के इन दो खूंखार राक्षसों (वासना और गुस्से) का गला काट देता है ('वियुक्तानां'), और अपने भटकते हुए दिमाग पर एक मजबूत लगाम कस लेता है ('यतचेतसाम्')...
            और सबसे बड़ी बात, जिसे यह पक्का अहसास ('विदितात्मनाम्') हो जाता है कि "मैं हड्डी-मांस का पुतला नहीं, बल्कि एक अजर-अमर आत्मा हूँ"...
            उस इंसान के लिए मोक्ष ('ब्रह्म-निर्वाण') कहीं दूर भविष्य में नहीं है! 
            'अभितो वर्तते' का अर्थ है कि मोक्ष उसके 'आगे-पीछे, सब तरफ' इसी पल मौजूद है। वह जीते जी ही भगवान की गोद (शांति) में बैठा हुआ है।
            मोक्ष कोई 'डेस्टिनेशन' (Destination) नहीं है; मोक्ष एक 'स्टेट ऑफ माइंड' (State of Mind) है, जो मन के पूरी तरह शुद्ध होते ही 'अभी और यहीं' (Here and Now) प्रकट हो जाता है।
        """.trimIndent(),
        english = """
            For those highly elevated, constantly striving renunciates (Yatinam) who are entirely and permanently freed from all blinding lust and violent anger (Kama-krodha-viyuktanam), and who have successfully established absolute, iron-clad control over their minds (Yata-chetasam)...
            and who have profoundly, directly, and experientially realized their true spiritual self (Viditatmanam)...
            the supreme, absolute liberation in the Supreme (Brahma-nirvanam) is already flawlessly and permanently existing all around them, at every single moment, in all directions (Abhito vartate).
            The Lord is once again officially declaring 'Lust' and 'Anger' to be the absolute deadliest cosmic enemies of mankind, while simultaneously revealing a mind-bending truth: Moksha (Liberation) is absolutely NOT a geographical location you catch a flight to after physical death.
            Sri Krishna declares that the exact microsecond a human being successfully beheads and completely annihilates the two terrifying internal demons of Lust and Anger ('Viyuktanam'), and clamps a brutal, titanium leash on his wildly flickering brain ('Yata-chetasam')...
            and most importantly, when he achieves the staggering experiential realization ('Viditatmanam') that "I am absolutely not this pathetic bag of blood and bones; I am an indestructible, eternal spiritual entity"...
            for such an elite master, Moksha ('Brahma-nirvanam') is absolutely not waiting for him in some distant future!
            'Abhito vartate' profoundly means that supreme liberation is existing 'Everywhere, all around him, on all sides' at this very exact microsecond. He is already sitting securely in the lap of God's infinite peace while biologically alive.
            Moksha is absolutely not a physical 'Destination'; Moksha is a supreme 'State of Consciousness' that instantly manifests 'Here and Now' the very second the mind becomes 100% pure.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            स्पर्शान्कृत्वा बहिर्बाह्यांश्चक्षुश्चैवान्तरे भ्रुवोः |
            प्राणापानौ समौ कृत्वा नासाभ्यन्तरचारिणौ || २७ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 27 और 28 एक ही विचार हैं)
            बाहर के इन्द्रिय विषयों (जैसे रूप, रस, गंध आदि) का चिंतन मन से पूरी तरह बाहर निकालकर (स्पर्शान्कृत्वा बहिर्बाह्यान्), अपनी आँखों की दृष्टि (नजर) को दोनों भौंहों (Eyebrows) के बिल्कुल बीच में स्थिर (फोकस) करके (चक्षुश्चैवान्तरे भ्रुवोः)...
            तथा नाक के अंदर (नासाभ्यन्तर) चलने वाली 'प्राण' (अंदर जाने वाली) और 'अपान' (बाहर आने वाली) वायु (सांसों) की गति को बिल्कुल एक समान (बराबर और शांत) करके...
            पाँचवें अध्याय के अंत में भगवान श्रीकृष्ण एक बहुत ही बड़ा सरप्राइज़ (Surprise) देते हैं। अभी तक वे 'कर्मयोग' की बात कर रहे थे, लेकिन अचानक वे 'अष्टांग ध्यान योग' (Mystic Meditation) की अत्यंत ही एडवांस (Advanced) और सीक्रेट (Secret) टेक्निक (Technique) का एक टीज़र (Teaser) दे रहे हैं (जिसे वे छठे अध्याय में विस्तार से बताएंगे)।
            ध्यान लगाने का यह 'प्रैक्टिकल फॉर्मूला' (Practical Formula) है:
            १. 'स्पर्शान् बहिर्बाह्यान्': सबसे पहले, बाहरी दुनिया (मोबाइल, रिश्तेदार, पैसे) के सारे विचारों को दिमाग से धक्के मारकर बाहर निकाल दो। माइंड को पूरी तरह 'ब्लैंक' (Blank) कर दो।
            २. 'चक्षुश्चैवान्तरे भ्रुवोः': अपनी दोनों आँखों को आधा खुला (Half-closed) रखो और अपना पूरा फोकस अपनी दोनों भौंहों के बीच (थर्ड आई / Third Eye) पर लॉक (Lock) कर दो। अगर आँखें पूरी बंद कीं, तो नींद आ जाएगी; पूरी खोलीं, तो दुनिया दिखेगी।
            ३. 'प्राणापानौ समौ कृत्वा': अपनी सांसों पर ध्यान लगाओ। अंदर जाने वाली सांस और बाहर आने वाली सांस की गति को इतना 'बैलेंस' (Balance) और 'शांत' कर दो कि तुम्हें पता ही न चले कि तुम सांस ले भी रहे हो या नहीं।
            जब कोई इंसान अपने शरीर और मन को इस अकल्पनीय स्तर (Level) पर फ्रीज़ (Freeze) कर देता है, तब क्या होता है? इसका उत्तर अगले श्लोक में है।
        """.trimIndent(),
        english = """
            (Verses 27 and 28 are a continuous thought)
            Completely shutting out and forcefully expelling all external sense objects and material thoughts from the mind (Sparshan kritva bahir bahyan), keeping the eyes and vision steadily locked exactly between the two eyebrows (Chakshush chaivantare bhruvoh)...
            and completely suspending and perfectly balancing the inward-moving breath (Prana) and the outward-moving breath (Apana) exactly within the nostrils (Pranapanau samau kritva)...
            At the very tail-end of the Fifth Chapter, Lord Sri Krishna drops a massive, unexpected Surprise. Up until now, He had been extensively glorifying 'Karma Yoga', but suddenly, He drops a highly advanced, ultra-secret 'Teaser' trailer of 'Ashtanga Dhyana Yoga' (The Mystic Science of Deep Meditation) [which He will fully decode in Chapter 6].
            This is the absolute, hardcore 'Practical Master-Formula' for achieving hyper-trance (Meditation):
            1. 'Sparshan bahir bahyan': First, violently kick out and completely expel every single thought of the external matrix (smartphones, family drama, financial stress) from your brain. Turn your mental screen absolutely 100% 'Blank'.
            2. 'Chakshush chaivantare bhruvoh': Keep your two physical eyes perfectly half-closed, and aggressively 'Lock' your entire visual focus exactly at the spot between your two eyebrows (The Third Eye / Ajna Chakra). If you close them fully, you will foolishly fall asleep; if you open them fully, you will be distracted by the matrix.
            3. 'Pranapanau samau kritva': Shift your entire consciousness to your breathing. Forcefully 'Balance', equalize, and slow down your inhaling and exhaling breath to such an extreme, microscopic level of stillness that you barely even register that you are physically breathing.
            When a human being successfully 'Freezes' his biological machine and chaotic mind at this unimaginable, staggering altitude, what exactly happens next? The ultimate answer is in the very next verse.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            यतेन्द्रियमनोबुद्धिर्मुनिर्मोक्षपरायणः |
            विगतेच्छाभयक्रोधो यः सदा मुक्त एव सः || २८ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 27 के बाद)... इस प्रकार जिस मननशील मुनि (योगी) ने अपनी इन्द्रियों, मन और बुद्धि को पूरी तरह से जीत लिया है (वश में कर लिया है - यतेन्द्रियमनोबुद्धिः), जिसका एकमात्र लक्ष्य केवल 'मोक्ष' (ईश्वर की प्राप्ति) ही है (मोक्षपरायणः)...
            और जो इच्छा (लालसा), भय (डर) और क्रोध (गुस्से) से पूरी तरह और हमेशा के लिए मुक्त हो चुका है (विगतेच्छाभयक्रोधो), ऐसा योगी हमेशा (सदा) ही निश्चित रूप से 'मुक्त' (ईश्वर में विलीन) है।
            श्लोक 27 में बताई गई ध्यान की टेक्निक (Technique) का यह फाइनल रिज़ल्ट (Final Result) है।
            जब योगी अपनी सांसों को रोक लेता है और ध्यान को भौंहों के बीच फोकस (Focus) कर लेता है, तो उसकी पूरी 'मशीनरी'—उसकी इन्द्रियां, उसका पागल मन, और उसकी तर्क करने वाली बुद्धि—पूरी तरह से हैक (Hack) हो जाती है और उसके 100% कंट्रोल (यतेन्द्रियमनोबुद्धिः) में आ जाती है।
            उसका अब दुनिया में कोई दूसरा 'प्लान' (Plan B) नहीं होता; उसका केवल एक ही लेज़र-शार्प (Laser-sharp) टारगेट होता है: 'मोक्षपरायणः' (मुझे सिर्फ और सिर्फ भगवान चाहिए)।
            चूँकि उसने दुनिया की कोई चीज़ चाही ही नहीं, इसलिए उसके भीतर 'इच्छा' नहीं होती। जब इच्छा नहीं होती, तो उसे किसी चीज़ के छिनने का 'डर' (भय) नहीं होता। और जब डर नहीं होता, तो उसे किसी पर 'गुस्सा' (क्रोध) नहीं आता।
            ये तीन सबसे बड़े राक्षस (इच्छा, डर, गुस्सा) जब मर जाते हैं, तो वह इंसान एक साधारण इंसान नहीं रहता।
            श्रीकृष्ण गारंटी देते हैं: "यः सदा मुक्त एव सः"—वह इंसान भविष्य में मुक्त नहीं होगा; वह इसी सेकंड, इसी पल, हमेशा के लिए 100% 'मुक्त' (Liberated / आजाद) हो चुका है। उसका और ईश्वर का फासला हमेशा के लिए खत्म हो चुका है।
        """.trimIndent(),
        english = """
            (Continuing from Verse 27)... The thoughtful sage (Muni) who has thus completely conquered and perfectly controlled his physical senses, mind, and intelligence (Yatendriya-mano-buddhir), whose absolute, singular ultimate aim is strictly liberation (Moksha-parayanah)...
            and who has permanently cast away and become utterly free from all material desire, paralyzing fear, and violent anger (Vigateccha-bhaya-krodho), is undeniably and certainly always eternally liberated (Sada mukta eva sah).
            This verse delivers the absolute, staggering 'Final Result' of the hardcore meditation technique prescribed in Verse 27.
            When the Yogi successfully paralyzes his breathing and locks his extreme focus between his eyebrows, his entire biological and psychological 'Machinery'—his wild senses, his chaotic mind, and his calculating intelligence—is completely 'Hacked' and brought under his 100% absolute, titanium control (Yatendriya-mano-buddhir).
            He has absolutely zero 'Plan B' for material enjoyment; he has only one single, terrifyingly laser-sharp Target: 'Moksha-parayanah' (I want absolutely nothing but the Supreme Lord and ultimate liberation).
            Because he literally desires absolutely nothing from the material matrix, he possesses zero 'Desire' (Iccha). Because he desires nothing, he has absolutely zero 'Fear' (Bhaya) of losing anything. And because he has no fear or frustrated desires, he generates absolutely zero violent 'Anger' (Krodha).
            When these three absolute greatest internal demons (Desire, Fear, Anger) are ruthlessly slaughtered, that human is no longer an ordinary mortal.
            Sri Krishna delivers an iron-clad Cosmic Guarantee: "Yah sada mukta eva sah"—That person will absolutely not become liberated in some distant future; he is officially, permanently, and 100% 'Liberated' (Free) at this very exact microsecond. The illusionary gap between him and God is permanently annihilated.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            भोक्तारं यज्ञतपसां सर्वलोकमहेश्वरम् |
            सुहृदं सर्वभूतानां ज्ञात्वा मां शान्तिमृच्छति || २९ ||
        """.trimIndent(),
        hindi = """
            मुझे (श्रीकृष्ण को) दुनिया के सभी यज्ञों और तपस्याओं का परम 'भोक्ता' (अंतिम आनंद लेने वाला / Beneficiary) मानकर, मुझे सम्पूर्ण लोकों और ब्रह्मांडों का परम 'ईश्वर' (मालिक / Supreme Lord) जानकर...
            तथा मुझे इस ब्रह्मांड के सभी प्राणियों का सबसे बड़ा 'सुहृद' (बिना किसी स्वार्थ के भलाई करने वाला सबसे सच्चा और परम मित्र) जानकर...
            जो मनुष्य मुझे इस प्रकार तत्त्व से जान लेता है (ज्ञात्वा मां), वह जीवन की सर्वोच्च और परम 'शांति' (शान्तिम्) को प्राप्त कर लेता है (ऋच्छति)।
            यह भगवद्गीता के पाँचवें अध्याय का 'ग्रैंड फिनाले' (Grand Finale) श्लोक है, और इसे पूरी दुनिया में 'शांति का अचूक फॉर्मूला' (The Ultimate Peace Formula) कहा जाता है।
            दुनिया का हर इंसान स्ट्रेस (Stress) में है और केवल 'शांति' (Peace) ढूँढ रहा है। भगवान श्रीकृष्ण इस एक श्लोक में दुनिया के सारे स्ट्रेस को खत्म करने के तीन सबसे बड़े 'सुप्रीम सीक्रेट्स' (Supreme Secrets) बताते हैं:
            १. 'भोक्तारं यज्ञतपसां': हम दुःखी क्यों हैं? क्योंकि हम सोचते हैं, "मैंने मेहनत की है, तो इस काम का 'रिज़ल्ट' (क्रेडिट/पैसा) मुझे ही मिलना चाहिए।" भगवान कहते हैं, "नहीं! दुनिया के हर काम, मेहनत और यज्ञ का असली और अंतिम भोक्ता (मालिक) केवल मैं हूँ।" जब हम यह मान लेते हैं कि सब कुछ ईश्वर का है, तो हमारा सारा अहंकार और टेंशन खत्म हो जाता है।
            २. 'सर्वलोकमहेश्वरम्': हम डरते क्यों हैं? क्योंकि हमें लगता है कि हमारे बॉस (Boss) या दुश्मन हमें बर्बाद कर देंगे। भगवान कहते हैं, "डरो मत! इन सारे लोकों (ग्रहों), ब्रह्मांडों और तुम्हारे बॉस का भी 'परम बॉस' (Supreme Owner) केवल मैं हूँ।" जब ईश्वर आपका बॉस है, तो डर कैसा?
            ३. 'सुहृदं सर्वभूतानां': हम अकेलेपन से दुःखी क्यों हैं? भगवान कहते हैं, "तुम अकेले नहीं हो! मैं दुनिया के हर जीव का 'सुहृद' हूँ।" ('सुहृद' वह दोस्त होता है जो बिना किसी मतलब या स्वार्थ के आपसे प्यार करता है और आपकी मदद करता है)। भगवान आपके सबसे अच्छे और सबसे शक्तिशाली 'बेस्ट फ्रेंड' (Best Friend) हैं।
            जब इंसान इन तीन बातों को गहराई से समझ लेता है—कि भगवान ही मालिक हैं, भगवान ही सुप्रीम बॉस हैं, और भगवान ही मेरे सबसे अच्छे दोस्त हैं—तो उसके दिमाग की सारी चिंताएं हमेशा के लिए मर जाती हैं, और वह एक ऐसी अकल्पनीय 'परम शांति' (शान्तिम्) को प्राप्त कर लेता है, जिसे कोई छीन नहीं सकता।
            यहाँ 'कर्म संन्यास योग' नामक पाँचवाँ अध्याय अत्यंत ही शांतिपूर्ण और दिव्य तरीके से समाप्त होता है।
        """.trimIndent(),
        english = """
            A person in full consciousness of Me, profoundly knowing Me to be the ultimate beneficiary and supreme enjoyer of all sacrifices and austerities (Bhoktaram yajna-tapasam), knowing Me to be the Supreme Lord and absolute proprietor of all planets and demigods (Sarva-loka-maheshvaram)...
            and knowing Me to be the absolute, most intimate, selfless well-wishing friend of all living entities (Suhridam sarva-bhutanam)...
            by truly understanding Me in this exact way (Jnatva mam), that person flawlessly attains the absolute, highest relief from all material pangs and achieves supreme, eternal 'Peace' (Shantim ricchati).
            This is the spectacular, breathtaking 'Grand Finale' verse of the Fifth Chapter, and it is universally celebrated across the globe as 'The Ultimate Peace Formula'.
            Every single human being on this planet is burning in severe stress and desperately hunting for 'Peace'. In this single, explosive verse, Lord Sri Krishna delivers the three absolute 'Supreme Secrets' to permanently annihilate all human anxiety:
            1. 'Bhoktaram yajna-tapasam': Why are we so miserable? Because our massive ego arrogantly thinks, "I did the hard work, so I must enjoy the ultimate credit, profit, and result." The Lord declares, "No! I am the absolute, final Proprietor and Supreme Enjoyer of every single action, sacrifice, and business in this universe." When you officially transfer the ownership of your results to God, your massive burden of stress instantly vanishes.
            2. 'Sarva-loka-maheshvaram': Why are we constantly terrified? Because we fear our human bosses, enemies, or the economy will destroy us. The Lord declares, "Do not fear! I am the absolute, Ultimate 'Supreme Boss' and CEO of all universes, planets, and even your earthly bosses." When the Supreme Creator is in control, what is there to fear?
            3. 'Suhridam sarva-bhutanam': Why do we suffer from crippling loneliness? The Lord declares, "You are absolutely never alone! I am the 'Suhridam' of every living entity." (A 'Suhrid' is a highly specific type of friend who loves you and helps you entirely unconditionally, without expecting a single thing in return). God is your absolute most powerful, most intimate 'Best Friend'.
            The exact microsecond a human deeply internalizes these three staggering truths—that God is the ultimate Enjoyer, the Supreme Controller, and my absolute Best Friend—every single microscopic drop of anxiety in his brain dies forever. He is instantly flooded with an unimaginable, indestructible 'Supreme Peace' (Shantim) that the material world can never, ever touch.
            Here, the deeply profound Fifth Chapter, 'Karma Sannyasa Yoga', comes to an incredibly serene, divine, and majestic conclusion.
        """.trimIndent()
    )
)