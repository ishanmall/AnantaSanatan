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
fun AdhyayaEleven() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaElevenShlokas.indexOfFirst { it.id == shlokaNum }
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
            label = { Text("Search Shloka Number (1 - 30)") },
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
            itemsIndexed(adhyayaElevenShlokas) { _, shloka ->
                // Using the ShlokaCard defined in AdhyayaOne.kt to avoid duplicate errors
                ShlokaCard(shloka)
            }
        }
    }
}

// Shlokas 1 to 30 for Chapter 11
val adhyayaElevenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            अर्जुन उवाच |
            मदनुग्रहाय परमं गुह्यमध्यात्मसञ्ज्ञितम् |
            यत्त्वयोक्तं वचस्तेन मोहोऽयं विगतो मम || १ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने कहा: हे कृष्ण! केवल मुझ पर विशेष कृपा (अनुग्रह) करने के लिए आपने मुझे जो 'अध्यात्म' नाम का परम गोपनीय रहस्य (परमं गुह्यम्) बताया है...
            आपके उन वचनों (ज्ञान) को सुनकर, अब मेरा यह सारा 'मोह' (अज्ञान और भ्रम) पूरी तरह से नष्ट (विगतो) हो गया है।
            ग्यारहवें अध्याय (विश्वरूप दर्शन योग) की शुरुआत में अर्जुन भगवान को अपना 'फीडबैक' (Feedback) दे रहे हैं।
            पहले अध्याय में अर्जुन रो रहे थे कि "मैं युद्ध नहीं करूँगा, ये मेरे अपने हैं।" वह उनका 'मोह' (Illusion) था। 
            दसवें अध्याय तक श्रीकृष्ण ने उन्हें आत्मा, परमात्मा और ब्रह्मांड का पूरा 'मास्टर-कोड' (Master-code) समझा दिया। अर्जुन अब समझ चुके हैं कि यह शरीर तो केवल एक 'मशीन' है और असली कंट्रोलर (Controller) केवल ईश्वर हैं।
            अर्जुन बहुत ही विनम्रता से भगवान का धन्यवाद करते हुए कहते हैं: "हे प्रभु! आपने जो ये टॉप-सीक्रेट (Top-Secret / गुह्यम्) बातें मुझे बताई हैं, उससे मेरे दिमाग का सारा जाला (Confusion) साफ हो गया है।"
            "मेरा मोह (Attachment) कि 'मैं मारने वाला हूँ और ये मरने वाले हैं', अब 100% डिलीट (Delete) हो चुका है।" यह एक परफेक्ट शिष्य की निशानी है जो गुरु के ज्ञान को पूरी तरह स्वीकार कर लेता है।
        """.trimIndent(),
        english = """
            Arjuna gratefully said: O Krishna! Purely out of Your causeless mercy upon me (Mad-anugrahaya), You have revealed the absolute most confidential, supreme spiritual subjects (Paramam guhyam adhyatma-sanjnitam).
            By simply hearing these profound words from You, my entire illusion and toxic bewilderment has now been completely destroyed and dispelled (Moho 'yam vigato mama).
            At the spectacular dawn of the Eleventh Chapter (Vishwaroopa Darshana Yoga), Arjuna delivers his ultimate 'Feedback' and status report to the Supreme Lord.
            In Chapter 1, Arjuna was violently weeping, paralyzed by the toxic illusion (Moha) of "I am the doer, these are my relatives, I cannot kill them." 
            By the end of Chapter 10, Sri Krishna has flawlessly downloaded the absolute 'Master-Code' of quantum spirituality, cosmic creation, and God's absolute supremacy directly into Arjuna's brain.
            Arjuna humbly and profoundly thanks the Lord: "O Supreme Master! By decoding these 'Top-Secret' (Paramam Guhyam) cosmic truths explicitly for my benefit, You have aggressively wiped my mental hard drive clean."
            "The pathetic illusion ('Moha') that I am the supreme controller of my destiny or the destroyer of these armies has been 100% permanently deleted." This is the hallmark of a flawless disciple perfectly absorbing the Guru's transcendental data.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            भवाप्ययौ हि भूतानां श्रुतौ विस्तरशो मया |
            त्वत्तः कमलपत्राक्ष माहात्म्यमपि चाव्ययम् || २ ||
        """.trimIndent(),
        hindi = """
            हे कमल के पत्तों जैसी सुंदर आँखों वाले (कमलपत्राक्ष / श्रीकृष्ण)! मैंने आपसे सभी प्राणियों की उत्पत्ति (पैदा होना / भव) और प्रलय (नष्ट होना / अप्ययौ) के बारे में बहुत विस्तार (विस्तरशः) से सुना है।
            तथा मैंने आपकी उस अविनाशी (अव्ययम्) और असीम महानता (माहात्म्यम्) को भी भली-भांति सुन लिया है।
            अर्जुन यहाँ श्रीकृष्ण को 'कमलपत्राक्ष' (Lotus-eyed) कहकर बड़े प्यार से संबोधित कर रहे हैं। यह शब्द अर्जुन के भगवान के प्रति असीम प्रेम और कृतज्ञता (Gratitude) को दर्शाता है।
            अर्जुन पिछले अध्यायों की एक छोटी सी समरी (Summary) दे रहे हैं: "हे कृष्ण! आपने मुझे बता दिया कि यह ब्रह्मांड कैसे बनता है और कैसे ब्लैक-होल (प्रलय) में जाकर खत्म हो जाता है।"
            "मुझे यह भी समझ आ गया है कि आपकी 'महानता' (Mahatmya) इतनी बड़ी है कि पूरी दुनिया आपके केवल एक छोटे से अंश (Fraction) पर टिकी हुई है।"
            अर्जुन यह सब इसलिए बोल रहे हैं ताकि भगवान को यह विश्वास हो जाए कि अर्जुन ने उनकी पूरी 'थ्योरी' (Theory / फिलॉसफी) को 100% सही तरीके से समझ लिया है।
            लेकिन केवल 'सुनने' से बात नहीं बनती! अर्जुन का दिमाग अब उस 'थ्योरी' का लाइव प्रैक्टिकल डेमो (Live Practical Demo) देखना चाहता है, जिसकी डिमांड (Demand) वे अगले श्लोकों में करेंगे।
        """.trimIndent(),
        english = """
            O lotus-eyed one (Kamala-patraksha)! I have now heard directly from You in great detail (Vistarasho maya) an exhaustive account of the appearance (Bhavah) and the complete disappearance (Apyayau) of all living entities.
            And I have also realized Your inexhaustible, eternal, and supreme glories (Mahatmyam api chavyayam).
            Arjuna affectionately addresses Sri Krishna as 'Kamala-patraksha' (Lotus-eyed) here, perfectly demonstrating his overwhelming love and supreme gratitude toward the Lord.
            Arjuna provides a quick, executive 'Summary' of the previous chapters: "O Krishna! You have flawlessly explained the exact quantum mechanics behind how this multiverse is violently engineered (Big Bang) and how it is ultimately annihilated (Big Crunch)."
            "I have also successfully processed the terrifying magnitude of Your 'Mahatmya' (Supreme Glories)—realizing that billions of galaxies rest effortlessly upon a mere, microscopic fraction of Your cosmic energy."
            Arjuna explicitly states this to assure the Supreme Lord that his biological brain has successfully, 100% successfully downloaded and processed all the heavy 'Theoretical Data' and philosophy.
            But mere 'Theory' is absolutely never enough for an elite warrior! Arjuna's upgraded consciousness is now aggressively demanding to witness the ultimate 'Live Practical Demonstration' of this staggering cosmic power, setting the stage for the next breathtaking verses.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            एवमेतद्यथात्थ त्वमात्मानं परमेश्वर |
            द्रष्टुमिच्छामि ते रूपमैश्वरं पुरुषोत्तम || ३ ||
        """.trimIndent(),
        hindi = """
            हे परमेश्वर! आपने अपने स्वरूप के बारे में जो कुछ भी बताया है, वह बिल्कुल वैसा ही है (एवमेतद्यथात्थ), इसमें कोई शक नहीं है।
            परंतु हे पुरुषोत्तम! अब मैं आपके उस परम 'ईश्वरीय रूप' (विश्वरूप / ऐश्वरं रूपम्) को अपनी आँखों से साक्षात् देखने की इच्छा (द्रष्टुमिच्छामि) रखता हूँ।
            यहाँ अर्जुन ने भगवद्गीता की सबसे भयंकर और सबसे बड़ी 'डिमांड' (Demand / मांग) रख दी है!
            अर्जुन कहते हैं: "हे कृष्ण! मैं 100% मानता हूँ कि आप ब्रह्मांड के सुप्रीम बॉस (परमेश्वर) हैं। मैं आपकी किसी भी बात पर डाउट (Doubt) नहीं कर रहा हूँ।"
            "लेकिन आपने पिछले अध्याय में कहा था कि 'यह पूरा ब्रह्मांड मेरे एक छोटे से अंश में मौजूद है'। हे पुरुषोत्तम! मैं अब आपके उस 'विश्वरूप' (Universal Form / ऐश्वरं रूपम्) को लाइव (Live) देखना चाहता हूँ!"
            अर्जुन यहाँ अपने लिए नहीं, बल्कि दुनिया के आने वाले अज्ञानी लोगों के लिए यह मांग कर रहे हैं। 
            वे जानते थे कि भविष्य (कलयुग) में कई पाखंडी लोग उठेंगे जो कहेंगे "मैं भगवान हूँ।" अर्जुन एक 'बेंचमार्क' (Benchmark / पैमाना) सेट करना चाहते हैं कि जो कोई भी खुद को भगवान कहे, पहले उसे यह 'विश्वरूप' (जिसमें पूरा ब्रह्मांड दिखाई दे) दिखाना पड़ेगा!
            यह एक शिष्य की भगवान से उनके 'विराट और डरावने' रूप को देखने की अत्यंत साहसी प्रार्थना है।
        """.trimIndent(),
        english = """
            O greatest of all personalities, O Supreme Lord (Parameshvara)! Though I completely see You here before me in Your actual position exactly as You have described Yourself (Evam etad yathattha tvam)...
            I now intensely desire to directly, physically see how You have actually entered into this cosmic manifestation. I want to see Your majestic, infinite Universal Form (Drashtum icchami te rupam aishvaram), O best of personalities (Purushottama)!
            Arjuna has just officially dropped the absolute biggest, most terrifying, and staggering 'Demand' in the entire Bhagavad Gita!
            He respectfully declares: "O Krishna! I absolutely believe with 100% titanium certainty that You are the Supreme Boss of the multiverse (Parameshvara). I am absolutely not doubting a single word You have spoken."
            "But in the previous chapter, You made the mind-bending claim: 'This entire cosmos rests on a microscopic fragment of My energy.' O Purushottama! I now aggressively desire to witness a 'Live, 3D, Physical Demonstration' of that exact 'Universal Form' (Aishvaram Rupam)!"
            Arjuna is brilliantly executing this demand not merely for his own entertainment, but strictly to set an impenetrable 'Cosmic Benchmark' for future generations.
            He knew that in the degraded future (Kali-yuga), thousands of cheap, pathetic frauds would arrogantly declare, "I am God." Arjuna is officially establishing the ultimate Acid-Test: If anyone claims to be God, demand that they display this terrifying, multiverse-spanning 'Vishwaroopa' first!
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            मन्यसे यदि तच्छक्यं मया द्रष्टुमिति प्रभो |
            योगेश्वर ततो मे त्वं दर्शयात्मानमव्ययम् || ४ ||
        """.trimIndent(),
        hindi = """
            हे प्रभो! यदि आप ऐसा मानते हैं (मन्यसे यदि) कि मेरे द्वारा आपके उस विश्वरूप को देखा जाना संभव (शक्यं) है...
            तो हे सभी योगों के स्वामी (योगेश्वर)! कृपया आप मुझे अपने उस कभी न मिटने वाले (अविनाशी / अव्ययम्) विराट स्वरूप के दर्शन कराइए (दर्शय)।
            अर्जुन का यह श्लोक एक सच्चे शिष्य की चरम 'विनम्रता' (Humility) को दर्शाता है।
            अर्जुन ने पिछले श्लोक में भगवान का विश्वरूप देखने की बहुत बड़ी डिमांड कर तो दी थी, लेकिन उन्हें तुरंत एहसास हुआ कि "क्या मेरी इन छोटी सी इंसानी आँखों की कोई औकात (Capacity) है कि वे उस अनंत ईश्वर को देख सकें?"
            इसलिए वे तुरंत सरेंडर (Surrender) करते हैं और कहते हैं: "हे योगेश्वर! मैंने मांग तो ली, लेकिन अगर आपको लगता है कि मेरा यह छोटा सा दिमाग और आँखें आपके उस भयंकर रूप का 'वोल्टेज' (Voltage) सहन कर पाएंगी (तच्छक्यं मया द्रष्टुम्)... केवल तभी मुझे वह रूप दिखाइएगा।"
            भगवान की शक्ति असीमित है, और इंसान का हार्डवेयर (Hardware / आँखें) बहुत ही लिमिटेड (Limited) है।
            अर्जुन भगवान को 'योगेश्वर' (Master of all Mysticism) कह रहे हैं, जिसका अर्थ है कि "यह काम किसी साइंस (Science) से नहीं होगा, यह केवल आपके ईश्वरीय 'जादू' (Mystic power) से ही संभव हो सकता है।" 
            भगवान के सामने कभी भी ज़िद (Arrogance) नहीं करनी चाहिए; हमेशा उनकी इच्छा और कृपा (Mercy) पर निर्भर रहना चाहिए।
        """.trimIndent(),
        english = """
            O Lord (Prabho)! If You think that I am sufficiently able to actually behold Your cosmic form (Manyase yadi tach chakyam maya drashtum iti)...
            then, O Master of all mystic power (Yogeshvara), please be merciful and kindly show me that infinite, imperishable universal Self (Darshayatmanam avyayam).
            This spectacular verse brilliantly showcases the absolute, ultimate 'Humility' and profound self-awareness of an elite, perfect disciple.
            Arjuna boldly demanded to witness the terrifying Universal Form in the previous verse, but he instantaneously experiences a massive reality-check: "Wait, does my fragile, biological human hardware (my physical eyes and brain) actually possess the processing capacity to view the infinite, blazing Godhead without violently melting?"
            Therefore, he immediately softens his demand into a perfectly submissive request: "O Yogeshvara! I have asked, but if You scientifically audit my capacity and conclude that I can actually survive the terrifying 'Voltage' of Your cosmic form without crashing (Tach chakyam maya)... only then, please reveal it."
            God's power is infinitely limitless, while human biological hardware is pathetically restricted.
            Arjuna deliberately addresses Krishna as 'Yogeshvara' (The Supreme Hacker/Master of all Mysticism), implicitly acknowledging, "My physical eyes absolutely cannot see this; this staggering event can only occur if You execute a supreme, magical override on my physical system."
            One must absolutely never approach the Supreme Lord with arrogant demands; one must always humbly rely entirely on His ultimate mercy and clearance.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            श्रीभगवानुवाच |
            पश्य मे पार्थ रूपाणि शतशोऽथ सहस्रशः |
            नानाविधानि दिव्यानि नानावर्णाकृतीनि च || ५ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे पार्थ (अर्जुन)! अब तुम मेरे सैकड़ों और हज़ारों प्रकार के (शतशोऽथ सहस्रशः) ईश्वरीय रूपों (रूपाणि) को देखो (पश्य)।
            मेरे ये रूप अनेक प्रकार के (नानाविधानि) हैं, पूरी तरह से अलौकिक (दिव्यानि / Divine) हैं, और तरह-तरह के रंगों और आकृतियों (नानावर्णाकृतीनि) वाले हैं।
            अर्जुन की प्रार्थना सुनकर, भगवान श्रीकृष्ण बिल्कुल भी देर नहीं करते। वे ब्रह्मांड का सबसे बड़ा '3D कॉस्मिक शो' (3D Cosmic Show) तुरंत चालू कर देते हैं!
            भगवान कहते हैं, "पश्य मे पार्थ" (हे अर्जुन! अपनी आँखें खोलो और देखो!)।
            अर्जुन केवल एक भगवान (कृष्ण) को देख रहे थे, लेकिन भगवान उन्हें कोई एक रूप नहीं दिखा रहे हैं। वे कह रहे हैं: "मेरे अंदर 10, 20 या 100 नहीं, बल्कि 'सैकड़ों और हज़ारों' (Unlimited) रूप एक साथ देखो।"
            ये रूप कोई इंसान या जानवर के नहीं हैं; ये 'दिव्यानि' (Transcendental / इस दुनिया से बाहर की चीज़) हैं।
            उन रूपों के रंग (Colors) और आकार (Shapes) इतने अलग और अकल्पनीय (Unimaginable) हैं कि इंसान का दिमाग उनकी कल्पना भी नहीं कर सकता। 
            भगवान श्रीकृष्ण यहाँ मानो एक ही स्क्रीन (Screen) पर पूरे ब्रह्मांड (Past, Present, Future, देवता, राक्षस, ग्रह) को एक साथ 'प्ले' (Play) कर रहे हैं। यह एक 'सुपर-कम्प्यूटर' (Super-computer) के क्रैश होने जैसा नज़ारा है!
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead aggressively commanded: O son of Pritha (Partha)! Behold now My magnificent opulences and hundreds of thousands of varied divine forms (Pashya me rupani shatasho 'tha sahasrashah).
            Behold them, for they are entirely transcendental and divine (Divyani), appearing in infinitely diverse forms, shapes, and a multitude of mesmerizing, brilliant colors (Nana-varnakritini cha).
            Hearing Arjuna's incredibly humble plea, Lord Sri Krishna wastes absolutely zero seconds. He instantly flips the switch and triggers the absolute greatest, most terrifying '3D Cosmic Simulation' in the history of the multiverse!
            The Lord aggressively commands: "Pashya me Partha" (Open your eyes, Arjuna, and BEHOLD!).
            Arjuna was previously looking at a single, two-armed human form (Krishna). But the Lord is absolutely not going to show him just one more avatar. He commands: "Witness not 10, not 100, but 'Hundreds of Thousands' (Unlimited, infinite) staggering forms manifesting simultaneously right inside Me!"
            These forms are absolutely not cheap biological entities; they are strictly 'Divyani' (100% Transcendental, Anti-material, and belonging to a higher, terrifying dimension).
            Their blazing 'Colors' (Varna) and geometry/shapes (Akritini) are so wildly incomprehensible and completely alien that a mortal human brain would instantly crash trying to render them.
            Lord Sri Krishna is essentially playing the entire infinite Multiverse (Past, Present, Future, all demigods, all planets) simultaneously on a single, infinite HD Screen. It is a visual explosion that transcends all known laws of physics!
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            पश्यादित्यान्वसून्रुद्रानश्विनौ मरुतस्तथा |
            बहून्यदृष्टपूर्वाणि पश्याश्चर्याणि भारत || ६ ||
        """.trimIndent(),
        hindi = """
            हे भारत (अर्जुन)! तुम मुझमें 12 आदित्यों, 8 वसुओं, 11 रुद्रों, दोनों अश्विनी कुमारों, और 49 मरुद्गणों (हवा के देवताओं) को एक साथ देखो (पश्य)।
            और हे अर्जुन! तुमने जो पहले कभी नहीं देखे हैं (अदृष्टपूर्वाणि), ऐसे बहुत सारे अद्भुत और आश्चर्यजनक रूपों को भी तुम मेरे भीतर देखो (पश्याश्चर्याणि)।
            भगवान श्रीकृष्ण अपने 'विश्वरूप' (Universal Form) के अंदर अर्जुन को पूरे ब्रह्मांड का 'टूर' (Tour) करा रहे हैं।
            जिन 'देवताओं' (Demigods) की पूजा करने के लिए लोग दिन-रात यज्ञ करते हैं और जिन्हें देखने के लिए तरसते हैं...
            भगवान अर्जुन से कहते हैं कि "तुम्हें स्वर्ग जाने की कोई जरूरत नहीं है! तुम उन सारे बड़े-बड़े देवताओं (आदित्य, रुद्र, वसु) को एक साथ मेरी इस बॉडी (Body) के अंदर लाइव (Live) खड़े हुए देखो।"
            इतना ही नहीं! भगवान एक बहुत बड़ा सस्पेंस (Suspense) खोलते हैं: "बहून्यदृष्टपूर्वाणि" (जो तुमने या किसी भी इंसान ने पहले कभी नहीं देखा)।
            ब्रह्मांड में ऐसे लाखों-करोड़ों रहस्य, 'एलियंस' (Aliens/Other species), और गैलेक्सीज़ (Galaxies) हैं जो इंसानी ज्ञान और वेदों से भी बाहर हैं।
            भगवान अर्जुन को वह सब कुछ एक 'मल्टीवर्सल ज़ूम' (Multiversal Zoom) में दिखा रहे हैं। अर्जुन को अब समझ में आ रहा है कि कृष्ण का शरीर कोई आम इंसान का शरीर नहीं, बल्कि पूरे ब्रह्मांड का 'डेटा-सेंटर' (Data-center) है!
        """.trimIndent(),
        english = """
            O best of the Bharatas (Bharata)! See here within Me the twelve Adityas, the eight Vasus, the eleven Rudras, the two Ashvini-kumaras, and the forty-nine Maruts (demigods of the wind).
            Behold here many, many astonishing, terrifying, and wonderful things which absolutely no one has ever seen or even imagined before (Bahuny adrishta-purvani pashyashcharyani).
            Lord Sri Krishna is giving Arjuna the ultimate, VIP, unrestricted 'Cosmic Tour' directly inside His own Universal Form.
            Ignorant humans brutally torture themselves executing massive sacrifices just to catch a tiny, fleeting glimpse of highly powerful celestial demigods.
            The Lord nonchalantly commands Arjuna: "You absolutely do not need a ticket to Heaven! Just look closely at My body; you will instantly see every single one of those elite celestial managers (the Adityas, the terrifying Rudras, the Vasus) standing completely subservient, 'Live', right inside Me."
            And then, the Lord drops a massive, mind-bending suspense: "Bahuny adrishta-purvani" (Behold infinite cosmic anomalies that neither you nor any human in history has EVER witnessed before).
            The multiverse contains trillions of classified secrets, unidentified cosmic entities (Aliens/higher-dimensional beings), and bizarre galaxies that completely defy human science and even Vedic descriptions.
            The Lord is aggressively displaying absolutely all of them in a spectacular, simultaneous 'Multiversal Zoom'. Arjuna is violently realizing that Krishna's body is absolutely not biological flesh; it is the ultimate, infinite 'Data-Center' hosting the entire cosmic simulation!
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            इहैकस्थं जगत्कृत्स्नं पश्याद्य सचराचरम् |
            मम देहे गुडाकेश यच्चान्यद्द्रष्टुमिच्छसि || ७ ||
        """.trimIndent(),
        hindi = """
            हे गुडाकेश (अर्जुन)! तुम आज (अद्य) मेरे इस एक ही शरीर (मम देहे) के एक ही भाग (जगह) में स्थित (इहैकस्थं)...
            इस पूरे के पूरे चराचर (चलने वाले और स्थिर) ब्रह्मांड (जगत्कृत्स्नं) को एक साथ देखो (पश्य)। और इसके अलावा भी तुम जो कुछ भी देखना चाहते हो (यच्चान्यद्द्रष्टुमिच्छसि), वह सब कुछ तुम इसी शरीर में देख लो।
            यह श्लोक 'स्पेस और टाइम' (Space and Time / देश और काल) के नियमों को पूरी तरह से हैक (Hack) कर देता है!
            भगवान श्रीकृष्ण कह रहे हैं कि "तुम्हें ब्रह्मांड देखने के लिए किसी स्पेस-शिप (Space-ship) में बैठने की जरूरत नहीं है।" 
            'इहैकस्थं': मेरे शरीर के केवल एक छोटे से हिस्से (One single spot) में पूरा का पूरा ब्रह्मांड (अरबों तारे, ब्लैक-होल्स, और गैलेक्सीज़) एक साथ चल रहा है।
            और सबसे बड़ी बात: "यच्चान्यद्द्रष्टुमिच्छसि" (तुम्हारी जो भी मर्जी हो, वो देख लो)। 
            भगवान अर्जुन को 'सर्च-इंजन' (Search-engine) का पूरा एक्सेस (Access) दे देते हैं। अर्जुन युद्ध का 'फ्यूचर' (Future / कि कौन मरेगा और कौन जीतेगा) देखना चाहते थे। भगवान कहते हैं कि पास्ट, प्रेजेंट और फ्यूचर (Past, Present, Future) सब कुछ इस 'विश्वरूप' के अंदर लाइव टेलीकास्ट (Live telecast) हो रहा है।
            भगवान की यह छाती एक ऐसी स्क्रीन (Screen) बन गई है जिस पर पूरा ब्रह्मांड, समय और स्पेस एक साथ प्ले (Play) हो रहे हैं।
        """.trimIndent(),
        english = """
            O Arjuna, conqueror of sleep (Gudakesha)! Behold now (Adya) the entire, infinite cosmic manifestation, including all moving and non-moving entities (Sacharacharam jagat kritsnam), flawlessly situated completely in one single place directly within My body (Ihaika-stham mama dehe).
            And whatever else you may possibly desire to see (Yach chanyad drashtum icchasi)—behold it absolutely all, right here!
            This spectacular verse completely, violently 'Hacks' and breaks every single known law of 'Space and Time' (Quantum Physics)!
            Lord Sri Krishna is declaring: "You absolutely do not need to board a light-speed spaceship to explore the vast multiverse."
            'Ihaika-stham': Inside just one microscopic, localized spot upon My divine body, the entire, unimaginably massive cosmos (billions of galaxies, supermassive black holes, and trillions of species) is simultaneously, physically functioning in real-time.
            And the absolute ultimate mic-drop: "Yach chanyad drashtum icchasi" (Whatever else your brain wishes to Google, just look!).
            The Lord grants Arjuna unrestricted, 'Admin-Level Access' to the cosmic Search Engine. Arjuna was heavily anxious to know the 'Future' (who will survive this bloody war). The Lord declares that the Past, Present, and the absolute Future are all simultaneously 'Live-Streaming' directly on the screen of His Universal Form.
            The Supreme Lord's chest has literally transformed into a terrifying, multidimensional HD Monitor displaying the entirety of Space, Time, and Destiny simultaneously!
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            न तु मां शक्यसे द्रष्टुमनेनैव स्वचक्षुषा |
            दिव्यं ददामि ते चक्षुः पश्य मे योगमैश्वरम् || ८ ||
        """.trimIndent(),
        hindi = """
            परंतु तुम अपनी इन साधारण (भौतिक) आँखों से (अनेनैव स्वचक्षुषा) मेरे इस असीम विश्वरूप को देखने में बिल्कुल भी समर्थ नहीं हो (न तु मां शक्यसे द्रष्टुम्)।
            इसलिए, मैं तुम्हें वह 'दिव्य दृष्टि' (अलौकिक आँखें / दिव्यं चक्षुः) प्रदान करता हूँ (ददामि)। अब तुम मेरी उस अकल्पनीय ईश्वरीय योग-शक्ति (योगमैश्वरम्) को देखो!
            भगवान ने अर्जुन को ब्रह्मांड देखने को तो कह दिया, लेकिन अर्जुन की आँखों के सामने तो अभी भी एक साधारण दो-हाथों वाला इंसान (कृष्ण) ही खड़ा है!
            भगवान एक बहुत बड़ा वैज्ञानिक (Scientific) तथ्य बताते हैं। हमारी जो बायोलॉजिकल (Biological) आँखें हैं, वे केवल 3D दुनिया (रंग और रौशनी का एक छोटा सा स्पेक्ट्रम / Spectrum) देख सकती हैं। 
            जब भगवान का विश्वरूप प्रकट होगा, तो उसमें करोड़ों सूर्यों की चमक (Blinding radiation) और फोर्थ डायमेंशन (Fourth dimension / Time) भी होगा। अगर अर्जुन अपनी इन 'मांस की आँखों' (स्वचक्षुषा) से उसे देखने की कोशिश करते, तो उनकी आँखें तुरंत जलकर भस्म हो जातीं और उनका दिमाग फट जाता!
            इसलिए, भगवान अपने भक्त पर सबसे बड़ी कृपा करते हैं: "दिव्यं ददामि ते चक्षुः" (मैं तुम्हारे हार्डवेयर/Hardware को अपग्रेड/Upgrade कर रहा हूँ!)
            भगवान अर्जुन को 'दिव्य दृष्टि' (Spiritual X-Ray Vision) देते हैं, जिससे अर्जुन अब स्पेस और टाइम (Space & Time) के पार देख सकते हैं। 
            यह श्लोक साबित करता है कि इंसान अपनी मेहनत या साइंस से भगवान को कभी 'डिस्कवर' (Discover) नहीं कर सकता; जब तक भगवान खुद अपनी कृपा से आपको 'दृष्टि' न दें, आप उन्हें नहीं देख सकते।
        """.trimIndent(),
        english = """
            But you simply cannot possibly possess the capacity to see Me with your present, ordinary biological eyes (Na tu mam shakyase drashtum anenaiva sva-chakshusha).
            Therefore, I now officially grant you divine, transcendental vision (Divyam dadami te chakshuh). Behold My staggering, inconceivable mystic opulence and supreme cosmic majesty (Pashya me yogam aishvaram)!
            The Lord aggressively commanded Arjuna to behold the multiverse, but Arjuna was still merely staring at a normal, two-armed human (Krishna) standing on a chariot!
            The Lord drops a massively profound 'Scientific Truth' here. Our pathetic, fragile biological eyes operate strictly on a heavily restricted 3D visual spectrum. They can only process tiny amounts of physical light.
            The impending manifestation of the Universal Form involves blinding, radioactive effulgence equal to billions of supernovas, projecting directly across the 'Fourth Dimension' (Time). If Arjuna attempted to view this horrific cosmic explosion using his weak 'Eyes of flesh' (Sva-chakshusha), his retinas would instantly melt, and his biological brain would violently short-circuit and explode!
            Therefore, the Lord executes the ultimate cosmic upgrade: "Divyam dadami te chakshuh" (I am officially aggressively 'Upgrading your Biological Hardware'!).
            The Lord surgically implants 'Divya Drishti' (Divine Spiritual X-Ray Vision) into Arjuna's consciousness, allowing his brain to process Infinite Space and Time simultaneously without crashing.
            This spectacular verse mathematically proves that an ignorant human can absolutely NEVER 'Discover' God using cheap earthly telescopes or arrogant science; you remain 100% blind until God personally downloads His 'Divine Software' into your soul.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            सञ्जय उवाच |
            एवमुक्त्वा ततो राजन्महायोगेश्वरो हरिः |
            दर्शयामास पार्थाय परमं रूपमैश्वरम् || ९ ||
        """.trimIndent(),
        hindi = """
            संजय ने धृतराष्ट्र से कहा: हे राजन्! इस प्रकार (दिव्य दृष्टि देने की बात) कहकर, उसके तुरंत बाद (ततः)...
            सभी योगों और शक्तियों के परम स्वामी (महायोगेश्वरो), साक्षात् भगवान हरि (श्रीकृष्ण) ने पृथा-पुत्र अर्जुन (पार्थाय) को अपना वह अत्यंत भयंकर और परम ईश्वरीय 'विश्वरूप' (परमं रूपमैश्वरम्) दिखा दिया (दर्शयामास)।
            यहाँ भगवद्गीता का 'सीन' (Scene) एक बार फिर बदलता है। अर्जुन को अब दिव्य दृष्टि मिल चुकी है, और जो नज़ारा अर्जुन देख रहे हैं, उसे 'संजय' (जिनके पास पहले से दिव्य दृष्टि थी) अंधे राजा धृतराष्ट्र को 'लाइव कमेंट्री' (Live Commentary) के रूप में बता रहे हैं।
            संजय यहाँ भगवान के लिए एक बहुत ही भारी और भव्य शब्द का इस्तेमाल करते हैं: 'महायोगेश्वरो हरिः' (The Ultimate Master of all Magic and Mysticism)। 
            भगवान कोई साधारण जादू (Magic) नहीं कर रहे थे। उन्होंने एक ही सेकंड में अपने उस 2-हाथ वाले 'मानवीय रूप' को एक्सपैंड (Expand) करके पूरे ब्रह्मांड में फैला दिया! 
            "परमं रूपमैश्वरम्"—वह रूप इतना बड़ा, इतना अकल्पनीय और इतना डरावना था कि वह पूरे 'स्पेस' (Space) को फाड़ता हुआ अर्जुन के सामने खड़ा हो गया।
            संजय अब अगले श्लोकों में उस भयानक और शानदार विश्वरूप का वह 'विज़ुअल' (Visual) वर्णन करेंगे, जिसे पढ़कर ही किसी भी इंसान के रोंगटे (Goosebumps) खड़े हो जाएं!
        """.trimIndent(),
        english = """
            Sanjaya spoke to King Dhritarashtra: O King! Having spoken exactly thus, the Supreme, Ultimate Lord of all mystic power (Maha-yogeshvaro harih)...
            instantaneously revealed and manifested to Arjuna (Parthaya) His supreme, majestic, and terrifyingly infinite Universal Form (Darshayam asa paramam rupam aishvaram).
            Here, the camera angle of the Bhagavad Gita radically shifts! Arjuna has officially received the 'Divine Software Upgrade', and the blinding, apocalyptic spectacle exploding before Arjuna's eyes is now being aggressively 'Live-Streamed' by Sanjaya (who already possessed divine vision) directly to the blind King Dhritarashtra.
            Sanjaya deploys an incredibly heavy, majestic, and terrifying title for the Lord here: 'Maha-Yogeshvaro Harih' (The Absolute Ultimate Grandmaster of all Cosmic Magic and Mysticism).
            The Lord was not performing some cheap earthly illusion. In a single microsecond, He violently 'Expanded' His localized, 2-armed human form until it shattered the atmosphere and aggressively engulfed the entire infinite multiverse!
            "Paramam Rupam Aishvaram"—That Universal Form was so unfathomably gigantic, so mind-bendingly incomprehensible, and so terrifyingly majestic that it literally ripped through the fabric of 'Space and Time' right in front of Arjuna's chariot.
            In the upcoming highly explosive verses, Sanjaya will provide the raw, hyper-visual 'Live Commentary' of this terrifying Universal Form—a description so intensely graphic it guarantees massive Goosebumps!
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            अनेकवक्त्रनयनमनेकाद्भुतदर्शनम् |
            अनेकदिव्याभरणं दिव्यानेकोद्यतायुधम् || १० ||
        """.trimIndent(),
        hindi = """
            (श्लोक 10 और 11 एक साथ जुड़े हुए हैं)
            उस परम विश्वरूप में अर्जुन ने अनगिनत मुँह (अनेक-वक्त्र) और अनगिनत आँखें (नयनम्) देखीं। उसमें बहुत सारे अत्यंत अद्भुत और डरावने दृश्य (दर्शनम्) दिखाई दे रहे थे।
            उस रूप ने अनगिनत प्रकार के दिव्य (अलौकिक) आभूषण (गहने / दिव्याभरणं) पहने हुए थे, और उसने प्रहार करने के लिए ऊपर उठाए हुए (उद्यत) अनेक प्रकार के भयंकर और दिव्य हथियार (आयुधम्) हाथ में पकड़े हुए थे।
            संजय अब 'विश्वरूप' की भयंकर 3D डिटेल्स (3D Details) दे रहे हैं। अर्जुन का दिमाग यह देखकर सुन्न (Blank) हो गया है!
            १. 'अनेकवक्त्रनयनम्': अर्जुन जब भी जहाँ भी नज़र घुमाते, उन्हें भगवान के करोड़ों बड़े-बड़े मुँह और अरबों भयंकर आँखें घूरती हुई दिखाई देती हैं। इसका कोई ओर-छोर नहीं है।
            २. 'अनेकाद्भुतदर्शनम्': उस रूप के अंदर करोड़ों गैलेक्सीज़, पाताल लोक, नर्क की आग और स्वर्ग के नज़ारे एक साथ लाइव (Live) चल रहे हैं।
            ३. 'अनेकोद्यतायुधम्': भगवान के करोड़ों हाथ हैं, और हर हाथ में ब्रह्मांड को नष्ट करने वाले भयंकर 'दिव्य हथियार' (जैसे सुदर्शन चक्र, त्रिशूल, वज्र) मारने के लिए ऊपर उठे हुए हैं ('उद्यत')। यह रूप बहुत ही 'वायलेंट' (Violent / डरावना) और आक्रामक (Aggressive) है! 
            भगवान यह दिखाना चाहते हैं कि मैं केवल शांति का प्रतीक नहीं हूँ; जब मैं विनाश करने पर आता हूँ, तो ब्रह्मांड में मुझसे बड़ा 'हथियारबंद योद्धा' (Armed Warrior) कोई नहीं है।
        """.trimIndent(),
        english = """
            (Verses 10 and 11 form a continuous visual description)
            In that terrifying Universal Form, Arjuna saw an absolutely unlimited number of mouths (Aneka-vaktra) and unlimited eyes (Nayanam). It was a fully wondrous, mind-bending vision containing countless astonishing sights (Anekadbhuta-darshanam).
            The Form was majestically decorated with countless celestial, divine ornaments (Aneka-divyabharanam), and it was violently brandishing and raising upwards tens of thousands of terrifying, divine glowing weapons (Divyanekodyatayudham).
            Sanjaya is now rapidly streaming the horrific, ultra-HD '3D Details' of the Vishwaroopa. Arjuna's brain is completely paralyzed and blanking out from the staggering sensory overload!
            1. 'Aneka-vaktra-nayanam': Wherever Arjuna frantically darts his eyes, he is violently confronted by billions of massive, roaring mouths and trillions of terrifying, unblinking cosmic eyes staring directly into his soul. It has absolutely zero boundaries.
            2. 'Anekadbhuta-darshanam': Displayed directly inside that transparent, glowing torso are billions of galaxies, hellish dimensions, and celestial paradises operating simultaneously in a live cosmic simulation.
            3. 'Aneko-dyatayudham': The Supreme Lord possesses billions of massive arms, and every single hand is aggressively 'Raised' ('Udyata' - locked and loaded to strike), brandishing terrifying, cosmic 'Weapons of Mass Destruction' (like the Sudarshana Chakra, tridents, and thunderbolts). This Form is unimaginably 'Violent' and horrifyingly aggressive!
            The Lord is aggressively proving: "I am absolutely NOT just a cute, peaceful symbol of love; when it is time for cosmic annihilation, there is no 'Armed Warrior' more lethal, armed, and terrifying than ME."
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            दिव्यमाल्याम्बरधरं दिव्यगन्धानुलेपनम् |
            सर्वाश्चर्यमयं देवमनन्तं विश्वतोमुखम् || ११ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 10 का शेष)... उस रूप ने अत्यंत दिव्य (अलौकिक) मालाएं (फूलों के हार) और दिव्य वस्त्र (कपड़े / अम्बर) धारण किए हुए थे; और उस रूप के पूरे शरीर पर अत्यंत सुगंधित दिव्य चंदन (परफ्यूम / दिव्यगन्धानुलेपनम्) का लेप लगा हुआ था।
            वह परम देव (ईश्वर का रूप) सभी प्रकार के आश्चर्यों से पूरी तरह भरा हुआ (सर्वाश्चर्यमयम्), असीम (जिसका कोई अंत न हो / अनन्तं), और सब दिशाओं में मुँह वाला (विश्वतोमुखम्) था।
            संजय विश्वरूप की भव्यता (Majesty) का वर्णन जारी रखते हैं। 
            वह रूप केवल डरावना (हथियारों वाला) ही नहीं था; वह ब्रह्मांड का सबसे सुंदर और 'रॉयल' (Royal) रूप भी था। 
            १. 'दिव्यमाल्याम्बरधरं': भगवान के उन करोड़ों शरीरों पर ऐसे दिव्य फूल और चमकते हुए कपड़े (जैसे ऊर्जा से बने हों) थे, जो पृथ्वी पर कभी नहीं देखे गए।
            २. 'दिव्यगन्धानुलेपनम्': उनके शरीर से एक ऐसी 'ब्रह्मांडीय सुगंध' (Cosmic fragrance) आ रही थी जो पूरे स्पेस (Space) को महका रही थी।
            ३. 'अनन्तं विश्वतोमुखम्': यह सबसे हैरान करने वाली बात है। आप जब किसी इंसान को देखते हैं, तो उसका एक चेहरा सामने होता है और पीछे पीठ होती है। लेकिन भगवान का यह रूप 'अनंत' (Infinite) था। अर्जुन उनके पीछे, ऊपर या नीचे जहाँ भी देखते, उन्हें भगवान का एक नया चमकता हुआ 'चेहरा' (विश्वतोमुखम् - 360 Degree Faces) ही दिखाई देता।
            यह कोई 3D रूप नहीं था, यह एक ऐसा 'सर्वाश्चर्यमयम्' (Total Wonder) रूप था जो स्पेस के हर डायरेक्शन (Direction) को खा चुका था!
        """.trimIndent(),
        english = """
            (Continuing from Verse 10)... That supreme form was gloriously draped in magnificent, celestial garlands (Divya-malya) and glowing divine garments (Ambara-dharam), and its entire vast body was heavily anointed with incredibly fragrant, heavenly perfumes and pastes (Divya-gandhanulepanam).
            That Supreme Deity was an absolute ocean of terrifying wonders (Sarvashcharya-mayam), completely infinite and boundless (Anantam), with faces pointing simultaneously in absolutely every single direction of the cosmos (Vishvato-mukham).
            Sanjaya continues downloading the breathtaking, majestic royal graphics of the Universal Form.
            This manifestation was absolutely not just a terrifying, weapon-wielding war-machine; it was simultaneously the absolute most staggeringly beautiful and 'Royal' entity in existence.
            1. 'Divya-malyambara-dharam': Across those billions of cosmic bodies hung glowing, anti-material flower garlands and highly radiant, energy-woven garments completely unseen on any earthly planet.
            2. 'Divya-gandhanulepanam': A blindingly intoxicating 'Cosmic Fragrance' (divine perfume) radiated violently from His pores, perfuming the vacuum of space itself.
            3. 'Anantam Vishvato-mukham': This is the absolute ultimate mind-bender! When you look at a human, there is a face in the front and a blind back behind. But this God-Form was 'Ananta' (Mathematically Infinite). Wherever Arjuna desperately darted his eyes—behind, above, below, sideways—he violently collided with a brand new, roaring 'Face' (Vishvato-mukham - 360-Degree Omnidirectional Faces).
            This was absolutely NOT a localized 3D structure; it was a 'Sarvashcharya-mayam' (Absolute Matrix of Wonder) that had literally devoured and hijacked every single geographical direction in space!
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            दिवि सूर्यसहस्रस्य भवेद्युगपदुत्थिता |
            यदि भाः सदृशी सा स्याद्भासस्तस्य महात्मनः || १२ ||
        """.trimIndent(),
        hindi = """
            यदि आकाश (दिवि) में एक साथ 'एक हज़ार सूर्य' (सूर्यसहस्रस्य) एक ही समय पर (युगपद्) उदय हो जाएँ (निकल आएं / उत्थिता)...
            तो उन एक हज़ार सूर्यों की जो भयंकर रोशनी (भाः) होगी, वह रोशनी भी शायद उस महान परमात्मा (महात्मनः) के विश्वरूप की असीम चमक (भासः) की तुलना (सदृशी) कर सके!
            संजय के पास भगवान की उस चमक को बताने के लिए दुनिया की कोई 'यूनिट' (Unit) या शब्द (Words) नहीं बचे हैं! 
            जब अर्जुन ने भगवान का वह रूप देखा, तो उसकी रोशनी कितनी तेज़ थी? 
            संजय एक 'न्यूक्लियर एक्सप्लोज़न' (Nuclear Explosion) से भी करोड़ों गुना बड़ा उदाहरण देते हैं। वे कहते हैं, कल्पना करो कि हमारे सिर के ऊपर आसमान में एक सूरज नहीं, बल्कि 'एक हज़ार सूरज' (A thousand Suns) एक ही सेकंड ('युगपद्') में फट पड़ें और चमकने लगें! 
            क्या कोई इंसान हज़ार सूर्यों की गर्मी और रोशनी को बर्दाश्त कर सकता है? आँखें तुरंत पिघल जाएंगी!
            संजय कहते हैं कि "शायद" वह हज़ार सूर्यों की भयंकर रोशनी उस विश्वरूप की 'चमक' (Aura) के बराबर हो सके! 
            यह श्लोक 'परमेश्वर' (Supreme Lord) की उस असीम और डरावनी रेडिएशन (Radiation / ऊर्जा) का साक्षात् प्रमाण है, जिसे देखने के लिए अर्जुन को 'दिव्य दृष्टि' (Anti-material eyes) दी गई थी।
        """.trimIndent(),
        english = """
            If hundreds of thousands of suns (Surya-sahasrasya) were to violently explode and rise simultaneously in the sky all at once (Yugapad utthita divi)...
            their combined, blinding effulgence might possibly somehow resemble the staggering, roaring radiance (Bhasah) of that Supreme Person in that universal form (Tasya mahatmanah).
            Sanjaya's biological brain has completely run out of earthly vocabulary or scientific 'Metrics' to accurately quantify the blinding radiation of the Lord's form!
            Exactly how blinding was the light when Arjuna opened his divine eyes?
            Sanjaya deploys an analogy billions of times more explosive than a thermonuclear detonation. He commands: Imagine if not just one, but 'A Thousand Super-Suns' (Surya-sahasrasya) violently exploded and ignited simultaneously ('Yugapad') in the sky right above your head!
            Could any biological lifeform physically survive the melting heat and blinding radiation of a thousand suns? Human retinas would vaporize instantly!
            Sanjaya stammers that "Perhaps, maybe" that apocalyptic, blinding light of a thousand suns could slightly match the roaring 'Aura' (Bhasa) of that Supreme Universal Form!
            This spectacular verse is the absolute, terrifying proof of the infinite, highly radioactive 'Cosmic Energy' radiating from the Supreme Lord—explaining exactly why Arjuna desperately required 'Titanium Divine Eyes' just to survive the viewing.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            तत्रैकस्थं जगत्कृत्स्नं प्रविभक्तमनेकधा |
            अपश्यद्देवदेवस्य शरीरे पाण्डवस्तदा || १३ ||
        """.trimIndent(),
        hindi = """
            उस समय (तदा) अर्जुन (पाण्डवः) ने देवताओं के भी परम देव (देवदेवस्य) भगवान श्रीकृष्ण के उस विश्वरूप वाले शरीर (शरीरे) में...
            हज़ारों-लाखों अलग-अलग हिस्सों में बंटे हुए (अनेकधा प्रविभक्तम्) इस संपूर्ण ब्रह्मांड (जगत्कृत्स्नं) को एक ही जगह पर स्थित (एकस्थं) देखा (अपश्यत्)।
            यह श्लोक एक 'कॉस्मिक ज़ूम-आउट' (Cosmic Zoom-out) की तरह है। 
            कल्पना कीजिए कि अर्जुन रथ पर खड़े हैं, और उनके सामने एक विशाल शरीर (विश्वरूप) खड़ा है। जब अर्जुन उस शरीर के अंदर देखते हैं, तो उनकी आँखें फटी की फटी रह जाती हैं।
            उन्हें 'देवदेवस्य' (ईश्वर) के सीने या पेट के अंदर पूरी की पूरी गैलेक्सीज़ (Galaxies), स्वर्ग, नर्क, पृथ्वी, और ब्रह्मांड के सारे अलग-अलग 'डायमेंशन्स' (Dimensions / प्रविभक्तम् अनेकधा) बिल्कुल स्पष्ट दिखाई दे रहे हैं!
            यह ऐसा था जैसे किसी ने पूरे अनंत ब्रह्मांड को एक छोटे से बॉक्स (शरीर) के अंदर 'कंप्रेस' (Compress) करके अर्जुन के सामने रख दिया हो ('एकस्थं' - in one single place)।
            अर्जुन को अब यकीन हो गया कि सातवें और दसवें अध्याय में कृष्ण ने जो भी कहा था कि "सब कुछ मेरे अंदर है," वह कोई फिलॉसफी (Philosophy) नहीं थी, वह 'भौतिक सच्चाई' (Physical Reality) थी, जो अब अर्जुन की आँखों के सामने लाइव (Live) चल रही थी।
        """.trimIndent(),
        english = """
            At that exact moment (Tada), Arjuna (Pandavah) could flawlessly and clearly see in the universal form of the Lord of all demigods (Deva-devasya sharire)...
            the entire, limitless universe (Jagat kritsnam), although divided into many thousands of infinitely diverse planetary systems and dimensions (Pravibhaktam anekadha), situated completely and entirely in one single place (Tatraika-stham apashyat).
            This spectacular verse acts exactly like a staggering 'Cosmic Zoom-Out' camera shot!
            Imagine Arjuna standing paralyzed on his pathetic wooden chariot, staring up into the colossal, glowing torso of the Universal Form. When Arjuna actively focuses his divine X-Ray vision deep inside that Body, his brain absolutely short-circuits.
            Right inside the chest and abdomen of 'Deva-devasya' (The Supreme God of Gods), Arjuna is visually perceiving thousands of swirling galaxies, hellish dimensions, heavenly planetary systems, and parallel universes ('Pravibhaktam anekadha' - infinitely divided compartments) all operating simultaneously in real-time!
            It was exactly as if the Supreme Lord had taken the entire infinite, boundless multiverse, aggressively 'Compressed' it into an ultra-dense simulation, and placed it flawlessly in 'One Single Spot' (Eka-stham) right in front of Arjuna.
            Arjuna is now violently hit with the realization that all of Krishna's heavy philosophical claims in Chapters 7 and 10 ("Everything rests in Me") were absolutely NOT just poetic philosophy; they were brutal, terrifying 'Physical Reality' playing 'Live' right in front of his retinas.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            ततः स विस्मयाविष्टो हृष्टरोमा धनञ्जयः |
            प्रणम्य शिरसा देवं कृताञ्जलिरभाषत || १४ ||
        """.trimIndent(),
        hindi = """
            तब (उस भयानक विश्वरूप को देखने के बाद) अत्यधिक आश्चर्य और घबराहट से भर कर (विस्मयाविष्टो), और जिसके शरीर के सारे रोंगटे खड़े हो गए थे (हृष्टरोमा)...
            ऐसे अर्जुन (धनञ्जयः) ने परमेश्वर को अपने सिर से प्रणाम करके (प्रणम्य शिरसा देवं) और अपने दोनों हाथ जोड़कर (कृताञ्जलिः) प्रार्थना करना शुरू किया (अभाषत)।
            यह अर्जुन के 'रिएक्शन' (Reaction / प्रतिक्रिया) का श्लोक है!
            जब एक इंसान इतने करीब से अरबों गैलेक्सीज़, करोड़ों मुँह, और हज़ारों सूर्यों की चमक को एक साथ देखेगा, तो उसका क्या हाल होगा?
            अर्जुन जो दुनिया का सबसे निडर योद्धा था, वह इस 'कॉस्मिक शॉक' (Cosmic Shock) को देखकर पूरी तरह सुन्न हो गया ('विस्मयाविष्टो')। उसके शरीर का हर एक रोंगटा (Hair) बिजली के करंट की तरह खड़ा हो गया ('हृष्टरोमा' - Goosebumps)।
            उसे समझ आ गया कि उसके सामने जो सत्ता खड़ी है, उसके सामने उसका गांडीव धनुष या उसकी वीरता एक धूल के कण से भी छोटी है।
            उसका सारा अहंकार तुरंत चकनाचूर हो गया। अर्जुन ने बिना सोचे तुरंत अपना सिर भगवान के चरणों में झुका दिया ('प्रणम्य शिरसा') और हाथ जोड़ लिए ('कृताञ्जलिः')। 
            यहाँ से अर्जुन की वह भयंकर और खौफ से भरी हुई 'स्तुति' (प्रार्थना) शुरू होती है, जहाँ वह भगवान से इस रूप को शांत करने की भीख मांगेगा।
        """.trimIndent(),
        english = """
            Then (Tatah), utterly bewildered, totally overwhelmed with intense astonishment (Vismayavishto), and with his bodily hairs standing violently on end due to sheer awe (Hrishta-roma), Arjuna (Dhananjayah)...
            bowed his head deeply in utter submission before the Supreme Lord (Pranamya shirasa devam) and with folded hands in intense reverence (Kritanjalir), he began to speak and pray (Abhashata).
            This is the ultimate, dramatic 'Reaction Shot' of Arjuna!
            When a tiny biological mortal physically witnesses billions of swirling galaxies, millions of roaring mouths, and the blinding radiation of a thousand suns simultaneously at point-blank range, what is his exact physiological response?
            Arjuna, the absolute most fearless, cold-blooded sniper on the planet, was completely paralyzed and thrown into massive 'Cosmic Shock' ('Vismayavishto'). Every single hair follicle on his body violently stood on end, electrified like high-voltage wires ('Hrishta-roma' - Ultimate Goosebumps).
            He instantaneously realized that standing before this terrifyingly infinite, cosmic entity, his legendary Gandiva bow and his military arrogance were far less significant than a microscopic speck of dust.
            His massive warrior ego was instantly, brutally shattered into ash. Without a microsecond's hesitation, Arjuna physically crashed down, aggressively bowing his head in total submission ('Pranamya shirasa') and tightly folded his hands in sheer terror and awe ('Kritanjalir').
            From this exact moment begins Arjuna's terrifying, awe-struck, and desperately panicked 'Prayer', where he will eventually beg the Lord to shut down this horrific manifestation.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            अर्जुन उवाच |
            पश्यामि देवांस्तव देव देहे सर्वांस्तथा भूतविशेषसङ्घान् |
            ब्रह्माणमीशं कमलासनस्थमृषींश्च सर्वानुरगांश्च दिव्यान् || १५ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने (काँपते हुए) कहा: हे देव (भगवान)! मैं आपके इस विशाल शरीर में (तव देहे) सभी देवताओं को (देवान्), और सभी प्रकार के प्राणियों के विशेष समूहों को (सर्वांस्तथा भूतविशेषसङ्घान्) एक साथ देख रहा हूँ (पश्यामि)।
            मैं कमल के आसन पर बैठे हुए ब्रह्मा जी को (ब्रह्माणं कमलासनस्थम्), महादेव शिव जी (ईशं) को, सभी महान ऋषियों को (ऋषींश्च सर्वान्) और सभी दिव्य (विशाल) सर्पों (जैसे वासुकि / उरगांश्च दिव्यान्) को भी आपके ही अंदर देख रहा हूँ!
            अर्जुन अब अपनी 'दिव्य आँखों' का लाइव टेलीकास्ट (Live Telecast) बोलकर बता रहे हैं!
            अर्जुन ने देखा कि जिन देवताओं (ब्रह्मा, शिव) के लिए लोग दुनिया में अलग-अलग मंदिर बनाते हैं, वे सारे के सारे सबसे बड़े और पावरफुल देवता हाथ जोड़े हुए श्रीकृष्ण के पेट (विश्वरूप) के एक छोटे से हिस्से में बैठे हुए हैं!
            ब्रह्मा जी (Creator) अपने कमल के फूल पर बैठे हुए साक्षात नज़र आ रहे हैं। 'उरगान्'—यानी ब्रह्मांड के वे विशालकाय और खतरनाक दिव्य नाग (जैसे शेषनाग) जो पाताल को थामे हुए हैं, वे भी भगवान के शरीर का ही एक छोटा सा हिस्सा हैं।
            अर्जुन को अब कोई डाउट (Doubt) नहीं रहा कि कृष्ण ही 'सुप्रीम बॉस' (The Ultimate Boss) हैं, जिनके अंदर ये सारे बड़े-बड़े देवता केवल एक कर्मचारी (Employees) की तरह काम कर रहे हैं।
        """.trimIndent(),
        english = """
            Arjuna fearfully prayed: O Lord God (Deva)! I am physically seeing assembled entirely within Your massive body (Tava dehe) all the celestial demigods (Devan), and all the countless varieties of living entities (Sarvans tatha bhuta-vishesha-sanghan).
            I clearly see Lord Brahma seated majestically on his lotus flower (Brahmanam kamalasanastham), Lord Shiva (Isham), all the highly elevated great sages (Rishimsh cha sarvan), and all the terrifyingly massive, divine serpents (Uragamsh cha divyan)!
            Arjuna is now officially broadcasting a frantic, terrified 'Live Telecast' of exactly what his new Divine Eyes are rendering!
            Arjuna shockingly witnesses that the absolute highest, most powerful demigods (like Brahma and Shiva)—for whom ignorant humans build separate, massive temples across the earth—are all literally sitting with folded hands, compacted right inside a tiny fraction of Sri Krishna's glowing torso!
            Lord Brahma (The Chief Cosmic Engineer) is physically visible sitting submissively on his giant lotus. 'Uragan'—The unimaginably colossal, terrifying, planet-holding divine serpents (like Sheshanaga) residing in the darkest netherworlds are also just microscopic components churning inside the Lord's body.
            Arjuna's brain officially registers that there is absolutely zero doubt remaining: Krishna is the undisputed, terrifying 'Ultimate Boss', and all these towering celestial demigods are merely tiny, subordinate 'Employees' operating safely inside His gigantic matrix-body.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            अनेकबाहूदरवक्त्रनेत्रं पश्यामि त्वां सर्वतोऽनन्तरूपम् |
            नान्तं न मध्यं न पुनस्तवादिं पश्यामि विश्वेश्वर विश्वरूप || १६ ||
        """.trimIndent(),
        hindi = """
            मैं आपके शरीर में अनेकों (करोड़ों) भुजाएं (हाथ / बाहू), पेट (उदर), मुँह (वक्त्र) और आँखें (नेत्रं) देख रहा हूँ; आप मुझे हर तरफ (सर्वतः) केवल 'अनंत रूप' (इनफिनिट / अनन्तरूपम्) वाले ही दिखाई दे रहे हैं।
            हे संपूर्ण ब्रह्मांड के परम स्वामी (विश्वेश्वर)! हे विश्वरूप! मैं आपके इस विशाल रूप का न तो कोई 'अंत' (End) देख पा रहा हूँ, न कोई 'मध्य' (बीच का हिस्सा / Middle) देख पा रहा हूँ, और न ही आपकी कोई 'शुरुआत' (आदि / Beginning) ही मुझे कहीं दिखाई दे रही है!
            अर्जुन का दिमाग अब पूरी तरह 'ओवरलोड' (Overload) हो चुका है!
            वे जहाँ भी देखते हैं (ऊपर, नीचे, दाएँ, बाएँ), उन्हें केवल भगवान के करोड़ों हाथ, करोड़ों पेट (जो पूरी दुनिया को निगल सकते हैं), और करोड़ों डरावनी आँखें घूरती हुई दिखाई देती हैं।
            यह कोई ऐसा रूप नहीं है जिसे इंसान अपनी नज़र से नाप सके। अर्जुन बहुत कोशिश कर रहे हैं यह देखने की कि "भगवान का यह रूप शुरू कहाँ से होता है और खत्म कहाँ होता है?"
            लेकिन वे घबराकर कहते हैं: "न अंतं, न मध्यं, न आदिम्"—यह रूप तो 'इनफिनिट' (Infinite) है! इसका न कोई 'टॉप' (Top) है, न कोई 'बॉटम' (Bottom)। 
            वे डरते हुए भगवान को 'विश्वेश्वर' (ब्रह्मांड के बॉस) कहकर पुकारते हैं, क्योंकि अब उनके सामने वो प्यार करने वाले 'कृष्ण' नहीं, बल्कि स्पेस और टाइम (Space and Time) को फाड़ कर खड़ा हुआ एक असीम 'राक्षसी और ईश्वरीय' (Monstrous & Divine) रूप है जिसे समझना इंसान के बस के बाहर है।
        """.trimIndent(),
        english = """
            I physically behold You manifesting with tens of millions of arms (Bahu), bellies (Udara), mouths (Vaktra), and eyes (Netram), expanded endlessly and infinitely in absolutely all directions (Sarvato 'nanta-rupam).
            O Supreme Lord of the entire universe (Vishveshvara)! O Universal Form (Vishva-rupa)! I can absolutely see no end (Na antam), no middle (Na madhyam), and absolutely no beginning to Your terrifyingly massive form (Na punas tavadim)!
            Arjuna's spiritual CPU has officially hit 'Maximum Overload' and is violently crashing!
            Wherever his terrified eyes desperately dart (up, down, sideways), he is violently confronted by billions of massive flailing arms, trillions of gigantically expanding bellies (capable of swallowing galaxies), and billions of horrific, unblinking eyes staring right back into his soul.
            This is absolutely NOT a localized 3D structure that a human can measure. Arjuna desperately squints, trying to calculate the geographical geometry of the form: "Where exactly does this gigantic monster-God start, and where does He finish?"
            But he panics, screaming: "Na antam, na madhyam, na adim"—This entity is mathematically 'Infinite'! It possesses absolutely zero top, zero bottom, and zero center!
            He fearfully addresses the Lord as 'Vishveshvara' (The terrifying Boss of the cosmos), because standing before him is no longer his sweet, smiling best friend 'Krishna'; it is a staggeringly infinite, monstrously divine geometric horror tearing through the fabric of Space and Time, completely impossible for a mortal to comprehend.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            किरीटिनं गदिनं चक्रिणं च तेजोराशिं सर्वतो दीप्तिमन्तम् |
            पश्यामि त्वां दुर्निरीक्ष्यं समन्ताद् दीप्तानलार्कद्युतिमप्रमेयम् || १७ ||
        """.trimIndent(),
        hindi = """
            मैं आपको मुकुट पहने हुए (किरीटिनं), गदा धारण किए हुए (गदिनं), और चक्र लिए हुए (चक्रिणं च) देख रहा हूँ। आपका यह रूप 'तेज का एक भयंकर पहाड़' (तेजोराशिं) है जो सब ओर से प्रकाशमान (दीप्तिमन्तम्) हो रहा है।
            आपके इस रूप को देखना अत्यंत ही कठिन (दुर्निरीक्ष्यं / आँखों को अंधा कर देने वाला) है, क्योंकि यह चारों ओर से भड़कती हुई आग (अनल) और प्रलय के सूर्य (अर्क) के समान चमक रहा है; और यह रूप 'अप्रमेय' (जिसे नापा न जा सके / Immeasurable) है।
            अर्जुन अब उस विश्वरूप की 'रेडिएशन' (Radiation/चमक) का वर्णन कर रहे हैं।
            भगवान ने अपने सिरों पर करोड़ों 'मुकुट' और हाथों में भयंकर 'गदा' और 'चक्र' (हथियार) धारण किए हुए हैं, जो यह बता रहे हैं कि वे ब्रह्मांड के अकेले 'राजा और डिस्ट्रॉयर' (Destroyer) हैं।
            लेकिन सबसे बड़ी समस्या है उस रूप की 'चमक' (Brightness)। अर्जुन के पास दिव्य आँखें हैं, फिर भी अर्जुन कहते हैं: "दुर्निरीक्ष्यं" (मेरी आँखें चुंधिया रही हैं, मैं आपको ठीक से देख भी नहीं पा रहा हूँ!)।
            यह चमक कोई ट्यूबलाइट की नहीं है; यह 'दीप्तानलार्क' है—यानी जैसे लाखों सूरज एक साथ फट गए हों और भयंकर आग लग गई हो! उस भयंकर रेडिएशन (तेजोराशिं) के कारण वह रूप आँखों को अंधा कर रहा है।
            यह 'अप्रमेय' है, अर्थात् दुनिया का कोई भी थर्मामीटर (Thermometer) इस गर्मी और प्रकाश को नाप नहीं सकता। भगवान का यह रूप 'भयानक सुंदरता' (Terrifying Beauty) का अल्टीमेट उदाहरण है।
        """.trimIndent(),
        english = """
            Your form is immensely adorned with various brilliant crowns (Kiritinam), massive clubs (Gadinam), and deadly discs (Chakrinam). You are a blinding, concentrated mountain of glaring effulgence (Tejo-rashim), shining brilliantly in every single direction (Sarvato diptimantam).
            It is intensely painful and fiercely difficult to even look upon You (Pashyami tvam durnirikshyam), for Your terrifyingly blazing radiance is exactly like the violent, roaring fire and the immeasurable glare of the apocalyptic sun (Diptanalarqa-dyutim aprameyam).
            Arjuna is now desperately trying to describe the fatal, apocalyptic 'Radiation' and blinding glare emitting from the Vishwaroopa.
            The Lord is heavily armed and decorated with billions of towering royal 'Crowns' and holding terrifying, planet-crushing 'Maces' and 'Discs' (weapons), officially signifying that He is the sole, undisputed 'Emperor and Destroyer' of the cosmos.
            But the absolute biggest threat is the sheer, lethal 'Brightness'. Even though Arjuna was explicitly granted titanium 'Divine Eyes', he frantically screams: "Durnirikshyam" (I am physically struggling to even look at You; my divine retinas are burning and going blind!).
            This is absolutely no ordinary LED light; it is 'Diptanalarqa'—meaning it physically resembles the simultaneous detonation of a million thermonuclear supernovas resulting in a roaring, universe-consuming fire! That blinding, apocalyptic radiation (Tejo-rashim) makes the form agonizingly difficult to stare at.
            It is 'Aprameyam' (Unmeasurable); absolutely no high-tech cosmic thermometer or Geiger counter could ever mathematically calculate this insane heat and luminosity. This form is the absolute ultimate peak of 'Terrifying Beauty'.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            त्वमक्षरं परमं वेदितव्यं त्वमस्य विश्वस्य परं निधानम् |
            त्वमव्ययः शाश्वतधर्मगोप्ता सनातनस्त्वं पुरुषो मतो मे || १८ ||
        """.trimIndent(),
        hindi = """
            आप ही एकमात्र 'अक्षर' (कभी नष्ट न होने वाले) और जानने योग्य 'परम सत्य' (परमं वेदितव्यं) हैं। आप ही इस पूरे ब्रह्मांड के परम 'निधान' (Ultimate Resting Place / अंतिम खजाना) हैं।
            आप ही कभी न बदलने वाले (अव्ययः) और सनातन धर्म (शाश्वत-धर्म) के रक्षक (गोप्ता) हैं। और आप ही सबसे प्राचीन और हमेशा रहने वाले 'सनातन परम पुरुष' (सनातनः पुरुषः) हैं, ऐसा मेरा पक्का मत (विश्वास) है।
            भगवान का इतना डरावना और विशाल रूप देखकर अर्जुन का सारा ज्ञान 'प्रैक्टिकली' (Practically) पक्का हो गया है। अर्जुन अब भगवान की एक बहुत ही भारी और फिलॉसॉफिकल (Philosophical) स्तुति कर रहे हैं।
            १. 'परमं वेदितव्यं': अर्जुन कहते हैं, "अब मुझे समझ आ गया कि दुनिया में अगर कुछ जानने लायक है, तो वो कोई साइंस नहीं, केवल 'आप' हैं।"
            २. 'परं निधानम्': जब प्रलय (Destruction) आएगा, तो यह पूरी गैलेक्सी और ब्रह्मांड कहाँ जाकर छुपेंगे? अर्जुन देख रहे हैं कि यह पूरा ब्रह्मांड भगवान के ही पेट (निधान/Treasure-house) में जाकर सुरक्षित हो जाता है।
            ३. 'शाश्वतधर्मगोप्ता': जब-जब धरती पर अत्याचार बढ़ता है, तो धर्म (Righteousness) की रक्षा करने वाला सुप्रीम प्रोटेक्टर (Supreme Protector / गोप्ता) कोई और नहीं, साक्षात् आप ही हैं।
            ४. 'सनातनः पुरुषः': आप कोई आम इंसान नहीं, आप ही वो 'ओरिजिनल मैन' (Original Person) हैं जो समय की शुरुआत से पहले भी थे और हमेशा रहेंगे। अर्जुन अब 100% कन्फर्म (Confirm) कर चुके हैं कि कृष्ण ही परम पिता हैं।
        """.trimIndent(),
        english = """
            You are the absolute, infallible supreme objective, the ultimate truth to be understood (Tvam aksharam paramam veditavyam). You are the supreme, infinite resting place and ultimate treasure-house of all this universe (Tvam asya vishvasya param nidhanam).
            You are completely inexhaustible and imperishable (Tvam avyayah), You are the fierce, ultimate maintainer and protector of the eternal religion (Shashvata-dharma-gopta), and You are the eternal, original Supreme Personality of Godhead (Sanatanas tvam purusho). This is my absolute, unshakeable opinion (Mato me).
            Upon physically witnessing this terrifying, colossal form, absolutely all of Arjuna's theoretical knowledge has been violently 'Practically' verified and cemented. Arjuna now aggressively glorifies the Lord using extremely heavy, absolute philosophical facts.
            1. 'Paramam veditavyam': Arjuna essentially declares, "I now realize with absolute certainty that if there is one singular thing in this entire multiverse worth 'Knowing' or researching, it is absolutely NOT material science; it is ONLY YOU."
            2. 'Param nidhanam': When the terrifying, apocalyptic Doomsday (Pralaya) strikes, where exactly does this massive galaxy hide for safety? Arjuna visually witnesses that the entire multiverse physically collapses and safely stores itself directly inside God's infinite belly (The Ultimate Treasure-house / Nidhanam).
            3. 'Shashvata-dharma-gopta': Whenever horrific tyranny and demonic terror hijack the earth, the ultimate, heavily-armed 'Supreme Protector' (Gopta) who violently descends to save 'Dharma' is none other than You.
            4. 'Sanatanas Purushah': You are absolutely no ordinary prince; You are the 'Original, Primeval Man' who existed in the dark void long before the invention of Time itself. Arjuna has now 100% officially confirmed Krishna as the Supreme Creator.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            अनादिमध्यान्तमनन्तवीर्यमनन्तबाहुं शशिसूर्यनेत्रम् |
            पश्यामि त्वां दीप्तहुताशवक्त्रं स्वतेजसा विश्वमिदं तपन्तम् || १९ ||
        """.trimIndent(),
        hindi = """
            मैं आपको बिना किसी आदि (शुरुआत), मध्य (बीच), या अंत वाले (अनादिमध्यान्तम्) के रूप में देख रहा हूँ! आपकी शक्ति (वीर्य) असीमित और अनंत (अनन्तवीर्यम्) है, और आपकी भुजाएं (हाथ) भी अनगिनत (अनन्तबाहुं) हैं।
            आपके नेत्र (आँखें) सूर्य और चंद्रमा के समान हैं (शशिसूर्यनेत्रम्)। मैं आपके मुखों (मुँह) से प्रज्वलित (भड़कती हुई) आग (दीप्तहुताशवक्त्रं) निकलती हुई देख रहा हूँ, और आप अपने उस भयंकर तेज़ (रेडिएशन) से इस पूरे ब्रह्मांड को जला रहे हैं (स्वतेजसा विश्वमिदं तपन्तम्)।
            यह श्लोक 'कॉस्मिक गॉडज़िला' (Cosmic Godzilla / अत्यंत प्रलयंकारी रूप) का एक भयानक दृश्य है!
            अर्जुन की घबराहट अब 'आतंक' (Terror) में बदल रही है। अर्जुन कहते हैं कि आपके इस रूप का कोई भी कोना (आदि, मध्य, अंत) नहीं है। 
            भगवान के करोड़ों हाथ (अनन्तबाहुं) हर तरफ घूम रहे हैं, जो उनकी 'इनफिनिट पावर' (Infinite Power / अनन्तवीर्यम्) को दिखाते हैं। 
            भगवान की दो विशालकाय आँखें हैं—एक सूरज की तरह आग उगल रही है (जो क्रोध और सज़ा का प्रतीक है), और दूसरी चाँद की तरह ठंडी है (जो भक्तों के लिए दया का प्रतीक है)।
            लेकिन सबसे डरावना हिस्सा उनका 'मुँह' है! भगवान के करोड़ों मुँह खुले हुए हैं, और उन मुँहों के अंदर से भयंकर आग की लपटें ('दीप्तहुताश') निकल रही हैं, बिल्कुल एक ड्रैगन (Dragon) या ज्वालामुखी की तरह!
            उस आग की भयंकर गर्मी ('तपन्तम्') इतनी ज्यादा है कि ऐसा लग रहा है जैसे पूरा ब्रह्मांड जलकर भस्म हो जाएगा। भगवान का यह रूप 'डिस्ट्रॉयर ऑफ द वर्ल्ड' (Destroyer of the World) का साक्षात् प्रमाण है।
        """.trimIndent(),
        english = """
            I physically behold You without any beginning, middle, or end (Anadi-madhyantam). You possess entirely limitless, unfathomable raw power and infinite strength (Ananta-viryam), and You have countless, infinite arms (Ananta-bahum).
            The blinding sun and the soothing moon are Your very eyes (Shashi-surya-netram). I see blazing, roaring fire forcefully shooting out from Your terrifying mouths (Dipta-hutasha-vaktram), and Your violently intense radiation and glaring effulgence are aggressively scorching and burning this entire universe (Sva-tejasa vishvam idam tapantam).
            This specific verse paints a horrifying, apocalyptic picture of the Lord acting exactly like a terrifying 'Cosmic Godzilla' (The Ultimate Destroyer)!
            Arjuna's initial awe is rapidly violently mutating into absolute 'Terror'. Arjuna screams that this monstrous geometric entity possesses absolutely zero start, zero center, and zero end.
            Billions of massive, flailing arms (Ananta-bahum) are violently whipping in all directions, representing His staggering 'Infinite Raw Power' (Ananta-viryam).
            The Lord possesses two titanic, cosmic eyes—one acts exactly like a blazing, radioactive Sun (representing His brutal, unyielding wrath and punishment), and the other acts like a cooling Moon (representing His soothing mercy for pure devotees).
            But the absolute most horrifying feature is His 'Mouth'! Billions of His massive jaws are unhinged wide open, aggressively vomiting and blasting roaring flames ('Dipta-hutasha') exactly like cosmic, galaxy-consuming Dragons!
            The sheer, brutal thermonuclear heat ('Tapantam') radiating from His blazing mouths is so catastrophically intense that it literally feels like the entire physical multiverse is being violently scorched and burnt to ashes. This form is the absolute, irrefutable proof of God as the 'Destroyer of Worlds'.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            द्यावापृथिव्योरिदमन्तरं हि व्याप्तं त्वयैकेन दिशश्च सर्वाः |
            दृष्ट्वाद्भुतं रूपमुग्रं तवेदं लोकत्रयं प्रव्यथितं महात्मन् || २० ||
        """.trimIndent(),
        hindi = """
            हे महात्मन्! स्वर्ग (द्यावा) और पृथ्वी (पृथिव्योः) के बीच का यह जितना भी 'स्पेस' (अंतरिक्ष / अन्तरं) है, और जितनी भी दिशाएं (दिशश्च सर्वाः) हैं, वे सब केवल 'आप अकेले' (त्वयैकेन) के ही द्वारा पूरी तरह से ढकी हुई (व्याप्तं) हैं!
            आपके इस अत्यंत अद्भुत (Awesome) और अत्यंत भयंकर (उग्रं / Terrifying) रूप को देखकर, ये तीनों लोक (स्वर्ग, पृथ्वी, और पाताल) बहुत ही बुरी तरह से डरे हुए और काँप रहे हैं (प्रव्यथितं लोकत्रयम्)।
            यह श्लोक 'विश्वरूप' के भयंकर 'साइज और इम्पैक्ट' (Size and Impact / आकार और प्रभाव) का वर्णन है।
            अर्जुन का दम घुट रहा है! वे देखते हैं कि आसमान (स्वर्ग) और धरती के बीच का जितना भी खाली 'स्पेस' (Space) है (जहाँ हम हवा और चाँद-तारे देखते हैं), वह स्पेस अब खाली नहीं रहा!
            भगवान का वह विशालकाय रूप इतना फैल चुका है कि उसने पृथ्वी, आसमान और सारी दिशाओं (North, South, East, West) को 'पैक' (Pack / व्याप्त) कर दिया है। अर्जुन को कृष्ण के शरीर के अलावा कुछ भी दिखाई नहीं दे रहा है!
            भगवान का यह रूप 'अद्भुत' (Beautiful/Magical) तो है, लेकिन साथ ही यह 'उग्रं' (अत्यंत डरावना / Fierce) भी है।
            अर्जुन कहते हैं कि, "हे प्रभु! सिर्फ मैं ही नहीं डर रहा हूँ; यह जो आपके अंदर तीनों लोकों (तीनों दुनियाओं) के लोग बैठे हैं, वे भी आपके इस खूंखार रूप को देखकर आतंकित (Terrorized) हो गए हैं और बुरी तरह 'काँप' (प्रव्यथितं) रहे हैं!"
            ईश्वर का गुस्सा और उसकी विशालता जब सामने आती है, तो पूरे ब्रह्मांड की हालत खराब हो जाती है।
        """.trimIndent(),
        english = """
            O great one (Mahatman)! The entire vast, empty space existing between the earth and the heavens (Dyava-prithivyor idam antaram hi), as well as absolutely all the directions in the universe (Dishash cha sarvah), are completely, densely filled and suffocated by You alone (Vyaptam tvayaikena).
            Seeing this incredibly wondrous (Adbhutam) and violently terrifying, fierce form (Ugram rupam) of Yours, all the planetary systems in all the three worlds are completely trembling in absolute panic and terror (Loka-trayam pravyathitam).
            This spectacular verse vividly describes the horrifying, claustrophobic 'Size and Psychological Impact' of the Vishwaroopa.
            Arjuna is literally suffocating from the staggering scale of the vision! He violently realizes that the entire vast, empty cosmic 'Vacuum' (Space) existing between the earthly planet and the celestial heavens (where we normally see empty sky and stars) is absolutely NO longer empty!
            That titanic, monstrous form has violently expanded and completely 'Packed' (Vyaptam), hijacked, and choked up the entire sky and every single geographical direction (North, South, East, West). Arjuna's eyes cannot find a single millimeter of space that is not covered by Krishna's blazing flesh!
            This form is undeniably 'Adbhutam' (Mesmerizingly magical and beautiful), but simultaneously, it is brutally 'Ugram' (Horrifyingly fierce, violent, and terrifying).
            Arjuna screams, "O Lord! I am absolutely not the only one paralyzed with fear; all the billions of entities residing inside Your three planetary systems (Heaven, Earth, Hell) are aggressively watching this horrific manifestation, and they are all violently 'Trembling' in absolute, apocalyptic terror (Pravyathitam)!"
            When the raw, unrestrained wrath and infinite magnitude of the Creator are unleashed, the entire multiverse goes into a complete panic attack.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            अमी हि त्वां सुरसङ्घा विशन्ति केचिद्भीताः प्राञ्जलयो गृणन्ति |
            स्वस्तीत्युक्त्वा महर्षिसिद्धसङ्घाः स्तुवन्ति त्वां स्तुतिभिः पुष्कलाभिः || २१ ||
        """.trimIndent(),
        hindi = """
            देखिए! ये सभी देवताओं के समूह (सुरसङ्घाः) आप ही के भीतर प्रवेश कर रहे हैं (विशन्ति), और कुछ देवता तो अत्यंत डरे हुए (भीताः) हाथ जोड़कर (प्राञ्जलयो) आपके नाम और गुणों का उच्चारण कर रहे हैं (गृणन्ति)।
            तथा महर्षियों और सिद्ध पुरुषों के समूह (महर्षिसिद्धसङ्घाः) "संसार का कल्याण हो (स्वस्ति)" ऐसा कहकर, अत्यंत सुंदर और उत्तम स्तोत्रों (पुष्कलाभिः स्तुतिभिः) के द्वारा आपकी स्तुति (प्रार्थना / स्तुवन्ति) कर रहे हैं।
            यह श्लोक दिखाता है कि जब 'सुप्रीम बॉस' (Supreme Boss / परमेश्वर) अपने प्रलयंकारी रूप में आते हैं, तो ब्रह्मांड के बड़े-बड़े 'मंत्रियों' (देवताओं) की क्या हालत होती है!
            अर्जुन देख रहे हैं कि जो देवता (इंद्र, अग्नि आदि) अपनी शक्ति पर घमंड करते हैं, वे सब इस विशाल 'ब्लैक-होल' (Black-hole) रूपी विश्वरूप के मुँह के अंदर 'खिंचे' चले जा रहे हैं ('विशन्ति')। 
            कई देवता तो मौत के डर से बुरी तरह काँप ('भीताः') रहे हैं और हाथ जोड़कर भगवान से अपनी जान की भीख मांग रहे हैं।
            दूसरी तरफ, जो ब्रह्मांड के बहुत बड़े ज्ञानी ऋषि और सिद्ध पुरुष हैं, वे डर नहीं रहे हैं, लेकिन वे समझ गए हैं कि यह 'प्रलय' का समय है और दुनिया का विनाश होने वाला है।
            इसलिए वे ऋषि-मुनि संसार के बचाव के लिए "स्वस्ति" (Peace / शांति हो, दुनिया बच जाए) चिल्लाते हुए, भगवान को शांत करने के लिए बहुत ही सुंदर वैदिक मंत्रों (स्तुतियों) का ज़ोर-ज़ोर से पाठ कर रहे हैं।
            यह दृश्य बिल्कुल वैसा है जैसे जब कोई बहुत बड़ा तूफान आता है, तो लोग हाथ जोड़कर भगवान से रक्षा की प्रार्थना करने लगते हैं।
        """.trimIndent(),
        english = """
            Look! All the vast multitudes of celestial demigods (Sura-sanghah) are helplessly surrendering and entering directly into You (Tvām vishanti). Out of sheer terror, some of them are standing with folded hands (Kechid bhitah pranjalayo), desperately chanting Your holy names and offering prayers (Grinanti).
            Simultaneously, the massive groups of great sages and perfected beings (Maharshi-siddha-sanghah), loudly crying "All peace and auspiciousness to the world!" (Svasty ity uktva), are frantically singing the Vedic hymns and praying to You with exquisite, elaborate prayers (Stuvanti tvaam stutibhih pushkalabhih).
            This spectacular verse explicitly showcases exactly what happens to the arrogant, high-ranking 'Ministers' (Demigods) of the universe when the 'Supreme Boss' (God) manifests in His terrifying, apocalyptic form!
            Arjuna vividly watches as the massively powerful celestial demigods (like Indra and Agni), who normally arrogantly flaunt their cosmic powers, are helplessly being sucked like dust into the roaring, massive 'Black-Hole' mouths of the Vishwaroopa ('Vishanti').
            Several demigods are violently trembling in absolute, paralyzing fear of death ('Bhitah'), desperately folding their hands and pathetically begging the Lord for their survival.
            On the other hand, the highly elite, advanced cosmic sages and perfected beings (Rishis) are not panicking blindly, but they acutely realize that an apocalyptic 'Doomsday' event has been triggered and the universe is facing annihilation.
            Therefore, in a desperate attempt to save the cosmos, these sages scream "Svasti" (May there be Peace/Survival for the world!), frantically and loudly chanting the absolute most powerful, beautiful, and elaborate Vedic mantras ('Pushkalabhih Stutibhih') to successfully pacify the raging, terrifying Lord.
            This terrifying scene perfectly mirrors humans desperately folding their hands and frantically praying for survival when a massive Category 5 hurricane violently strikes.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            रुद्रादित्या वसवो ये च साध्या विश्वेऽश्विनौ मरुतश्चोष्मपाश्च |
            गन्धर्वयक्षासुरसिद्धसङ्घा वीक्षन्ते त्वां विस्मिताश्चैव सर्वे || २२ ||
        """.trimIndent(),
        hindi = """
            ग्यारह रुद्र, बारह आदित्य, आठ वसु, साध्यगण, विश्वेदेव, दोनों अश्विनीकुमार, मरुद्गण और उष्मपा (पितरों का एक समूह)...
            तथा गन्धर्वों, यक्षों, असुरों और सिद्धों के जितने भी समूह (सङ्घाः) हैं, वे सब के सब अत्यंत विस्मित (आश्चर्यचकित / हक्के-बक्के होकर) आपको ही देख रहे हैं (वीक्षन्ते त्वां विस्मिताश्चैव सर्वे)।
            यह श्लोक 'यूनिवर्सल ऑडियंस' (Universal Audience / ब्रह्मांड के सभी दर्शकों) की लिस्ट है जो इस खौफनाक 'कॉस्मिक शो' (Cosmic Show) को देख रहे हैं।
            केवल अर्जुन ही नहीं, बल्कि ब्रह्मांड के दूसरे डायमेंशन्स (Dimensions / लोकों) में रहने वाली जितनी भी 'एलियन' (Alien/दिव्य) प्रजातियां हैं, वे सब भी भगवान के इस भयंकर रूप को देखकर सन्न (Paralyzed) रह गई हैं!
            अर्जुन ब्रह्मांड के सबसे वीआईपी (VIP) देवताओं (रुद्र, सूर्य, वसु) से लेकर, मेडिकल एक्सपर्ट्स (अश्विनीकुमार), परछाइयों की तरह रहने वाले पितरों (उष्मपा), स्वर्ग के सिंगर्स (गन्धर्व), खजाने के रक्षक (यक्ष), और यहाँ तक कि खूंखार 'असुरों' (Demons) की भी भीड़ को देख रहे हैं।
            ये सब के सब (चाहे अच्छे हों या बुरे), भगवान के इस विशालकाय और डरावने रूप को देखकर 'विस्मिताः' (Completely Shocked / आँखें फाड़कर) खड़े हैं। 
            किसी के मुँह से आवाज़ नहीं निकल रही है। कोई भी देवता या असुर इस रूप के सामने अपनी ताकत दिखाने की हिम्मत नहीं कर पा रहा है। सब बस एक मूर्ति की तरह चुपचाप ईश्वर के इस खौफनाक रूप को घूर रहे हैं।
        """.trimIndent(),
        english = """
            The various manifestations of Lord Shiva (Rudras), the Adityas, the Vasus, the Sadhyas, the Vishvedevas, the two Ashvins, the Maruts, and the forefathers (Ushmapas)...
            as well as the massive hosts of Gandharvas (celestial singers), Yakshas, Asuras (demons), and the perfected demigods (Siddhas)—all of them are continuously gazing at You in absolute, paralyzed wonder and utter astonishment (Vikshante tvam vismitash chaiva sarve).
            This spectacular verse provides the exhaustive guest list of the 'Universal Audience' currently witnessing this horrifying, apocalyptic 'Cosmic Show' in real-time.
            It is absolutely not just Arjuna on earth! Every single highly advanced, 'Alien' (Celestial) species residing in completely different, higher dimensions of the multiverse is equally paralyzed and stunned by this monstrous manifestation!
            Arjuna officially lists the VIP heavyweights of the cosmos: from the highest destructive deities (Rudras) and solar gods (Adityas), to celestial doctors (Ashvins), shadow-like ancestors (Ushmapas), heavenly rockstars (Gandharvas), billionaire treasure guards (Yakshas), and even the terrifying, blood-thirsty 'Demons' (Asuras).
            Every single one of them (whether purely holy or violently evil) is standing completely frozen, 'Vismitah' (Minds blown, jaws dropped, eyes wide open in absolute, staggering shock), rigidly staring at the Lord's terrifying form.
            Absolutely no one dares to utter a single sound. Not a single arrogant demigod or massive demon dares to flex his petty muscles before this infinite horror. They are all reduced to pathetic, silent statues, violently mesmerized and terrified by the Supreme Godhead.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            रूपं महत्ते बहुवक्त्रनेत्रं महाबाहो बहुबाहूरुपादम् |
            बहूदरं बहुदंष्ट्राकरालं दृष्ट्वा लोकाः प्रव्यथितास्तथाहम् || २३ ||
        """.trimIndent(),
        hindi = """
            हे महाबाहु (विशाल भुजाओं वाले कृष्ण)! आपके इस अत्यंत विशाल रूप (रूपं महत्) को, जिसमें करोड़ों मुँह (बहु-वक्त्र) और आँखें (नेत्रं) हैं, करोड़ों हाथ (बहु-बाहू), जांघें (ऊरु) और पैर (पादम्) हैं...
            जिसमें करोड़ों विशाल पेट (बहु-उदरं) हैं, और जो भयंकर दाँतों के कारण अत्यंत डरावना (बहु-दंष्ट्रा-करालं) लग रहा है, उस रूप को देखकर सभी लोक (दुनिया के सभी लोग) अत्यंत भयभीत होकर काँप रहे हैं (प्रव्यथिताः), और बिल्कुल वैसी ही हालत मेरी भी हो रही है (तथाहम्)!
            यह श्लोक एक 'हॉरर फिल्म' (Horror Movie) के सबसे खौफनाक सीन की तरह है! 
            अब तक अर्जुन भगवान के रूप को केवल 'अद्भुत' मान रहे थे, लेकिन अब अर्जुन की नज़र भगवान के मुँह के 'दाँतों' पर पड़ती है।
            अर्जुन देखते हैं कि भगवान के उन करोड़ों चेहरों में 'बहु-दंष्ट्रा-करालं'—यानी बहुत सारे बड़े-बड़े, नुकीले और खौफनाक (कराल) दाँत निकले हुए हैं, जो किसी भी चीज़ को चबाने के लिए तैयार हैं!
            करोड़ों हाथ और पैर ब्रह्मांड में हर तरफ ऐसे हिल रहे हैं जैसे सब कुछ कुचल देंगे। करोड़ों बड़े-बड़े पेट (उदर) सामने फैले हैं जो पूरी दुनिया को एक ही बार में हज़म करने के लिए भूखे हैं।
            इस 'राक्षसी' (Monstrous) और भयंकर (Terrifying) रूप को देखकर दुनिया के बाकी लोग तो डर से काँप ही रहे हैं, अर्जुन (जो दुनिया का सबसे निडर योद्धा है) वह भी खुलेआम अपनी 'हवा टाइट' (Extreme Fear) होने की बात मान लेता है: "तथाहम्" (हे कृष्ण! मेरी भी हालत खराब हो गई है, मैं भी बहुत बुरी तरह डर गया हूँ!)।
        """.trimIndent(),
        english = """
            O mighty-armed one (Maha-baho)! Seeing Your terrifyingly immense, colossal form (Rupam mahat), with its countless billions of faces (Bahu-vaktra) and eyes (Netram), its countless arms (Bahu-bahu), thighs (Uru), and legs (Padam)...
            and its countless massive bellies (Bahudaram), and seeing Your horrifying, gnashing, and terrible teeth (Bahu-damshtra-karalam), all the planetary systems are violently shaking in absolute terror (Drishtva lokah pravyathitas), and I too am completely terrified and shaking (Tathaham)!
            This spectacular verse reads exactly like the absolute most horrifying, apocalyptic climax scene of a Cosmic 'Horror Movie'!
            Up until now, Arjuna considered the form somewhat 'Wondrous'. But now, Arjuna's terrified eyes zoom in and focus directly on the horrific 'Teeth' of the Lord's millions of mouths.
            Arjuna is brutally confronted by 'Bahu-damshtra-karalam'—billions of massive, razor-sharp, gnashing, and violently terrifying fangs protruding from those mouths, dripping and locked-and-loaded to aggressively chew up the entire universe!
            Billions of massive arms and legs are violently thrashing across space, threatening to crush galaxies. Billions of gargantuan, bottomless bellies (Udara) are bulging out, violently hungry and ready to swallow and digest the entire multiverse in a single gulp.
            Seeing this monstrous, apocalyptic, and deeply horrific (Terrifying) manifestation, the entire population of the multiverse is violently trembling in panic. And Arjuna (officially the most fearless, cold-blooded sniper on planet Earth) openly admits his absolute 'Paralyzing Terror': "Tathaham" (O Krishna! I am totally losing my mind; I am violently terrified and physically shaking to my core!).
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            नभःस्पृशं दीप्तमनेकवर्णं व्यात्ताननं दीप्तविशालनेत्रम् |
            दृष्ट्वा हि त्वां प्रव्यथितान्तरात्मा धृतिं न विन्दामि शमं च विष्णो || २४ ||
        """.trimIndent(),
        hindi = """
            हे विष्णु! आकाश को छूने वाले (नभःस्पृशं), आग की तरह चमकते हुए (दीप्तम्), अनेक डरावने रंगों वाले (अनेकवर्णं), खुले हुए भयंकर मुँह वाले (व्यात्ताननं), और चमकती हुई विशाल आँखों वाले (दीप्त-विशाल-नेत्रम्) आपके इस रूप को देखकर...
            मेरा अंतःकरण (मेरा हृदय / अंतरात्मा) डर के मारे बहुत बुरी तरह से काँप रहा है (प्रव्यथितान्तरात्मा)! और मैं अपना सारा धैर्य (हिम्मत / धृतिं) और मन की शांति (शमं) पूरी तरह से खो चुका हूँ (न विन्दामि)।
            अर्जुन का 'पैनिक अटैक' (Panic Attack) अब अपने बिल्कुल चरम (Peak) पर पहुँच चुका है!
            अर्जुन एक 'योद्धा' (Warrior) हैं, उन्होंने बड़े-बड़े युद्ध देखे हैं, लेकिन भगवान का यह रूप उनकी बर्दाश्त (Tolerance) से बाहर हो गया है।
            अर्जुन उस रूप का वर्णन करते हैं: "नभःस्पृशं" (वह रूप इतना विशाल है कि उसने पूरे आसमान को फाड़ दिया है)।
            "अनेकवर्णं": उसमें से ऐसे-ऐसे डरावने और तेज़ रंग निकल रहे हैं जो आँखों को अंधा कर रहे हैं।
            "व्यात्ताननं": करोड़ों मुँह 'पूरे खुले हुए' (Wide open) हैं, जैसे किसी को निगलने के लिए झपटने वाले हों!
            "दीप्त-विशाल-नेत्रम्": भगवान की आँखें बहुत बड़ी-बड़ी हैं और उनमें से लेज़र (Laser) की तरह आग की किरणें निकल रही हैं।
            यह खौफनाक नज़ारा देखकर दुनिया का सबसे बहादुर इंसान (अर्जुन) भगवान विष्णु के सामने सरेंडर (Surrender) कर देता है और रोते हुए कहता है: "हे प्रभु! मेरी रूह (आत्मा) डर से काँप रही है! मेरी सारी हिम्मत ('धृति') टूट चुकी है, और मेरे दिमाग की सारी शांति ('शम') उड़ गई है! मैं यह और नहीं देख सकता!"
        """.trimIndent(),
        english = """
            O all-pervading Lord Vishnu! Seeing You touching the very sky and piercing the heavens (Nabhah-sprisham), glaring brightly with many terrifying, blinding colors (Diptam aneka-varnam), with Your billions of mouths wide open (Vyattananam) and Your massive, glowing eyes staring like fire (Dipta-vishala-netram)...
            my very soul and inmost heart are violently trembling in absolute terror (Drishtva hi tvam pravyathitantaratma)! I can no longer maintain my courage or steadiness (Dhritim na vindami), nor can I find any mental peace (Shamam cha).
            Arjuna's massive, biological 'Panic Attack' has now officially hit its absolute extreme, catastrophic 'Peak'!
            Arjuna is a cold-blooded 'Warrior' who has witnessed horrific massacres and fought legendary monsters. But the terrifying, apocalyptic magnitude of God's form has completely shattered his biological tolerance threshold.
            Arjuna describes the horror: "Nabhah-sprisham" (The monstrous form is so unfathomably colossal that it has literally ripped open the sky and swallowed the atmosphere).
            "Aneka-varnam": It is violently blasting out terrifying, highly radioactive, blinding colors that are physically burning Arjuna's divine retinas.
            "Vyattananam": Billions of massive jaws are 'Stretched Wide Open' (like a snake unhinging its jaw), looking exactly like they are about to lunge and aggressively swallow Arjuna alive!
            "Dipta-vishala-netram": God's eyes are gigantically massive, violently glowing, and shooting out blinding laser-beams of pure fire.
            Witnessing this absolute cosmic nightmare, the bravest man on earth completely breaks down and violently surrenders to Lord Vishnu, crying: "O Lord! My very eternal soul is shaking in absolute terror! My titanium courage ('Dhriti') is completely shattered into dust, and my brain has lost every single drop of sanity and peace ('Shama')! I absolutely cannot handle this anymore!"
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            दंष्ट्राकरालानि च ते मुखानि दृष्ट्वैव कालानलसन्निभानि |
            दिशो न जाने न लभे च शर्म प्रसीद देवेश जगन्निवास || २५ ||
        """.trimIndent(),
        hindi = """
            हे देवेश (देवताओं के भगवान)! हे जगन्निवास (पूरे ब्रह्मांड को अपने भीतर रखने वाले)! प्रलय-काल की भयंकर आग के समान (कालानलसन्निभानि) धधकते हुए, और भयानक दाँतों वाले (दंष्ट्राकरालानि) आपके इन डरावने मुखों (मुँहों) को देखकर...
            मैं सारी दिशाओं को भूल गया हूँ (मेरा दिमाग काम नहीं कर रहा है / दिशो न जाने), और मुझे बिल्कुल भी शांति या सुख नहीं मिल रहा है (न लभे च शर्म)। इसलिए हे प्रभु! आप मुझ पर प्रसन्न होइए (मुझ पर रहम खाइए / प्रसीद)।
            यह अर्जुन का भगवान से 'रहम' (Mercy) मांगने का श्लोक है।
            अर्जुन का ध्यान बार-बार भगवान के उन 'डरावने मुँहों' पर जा रहा है। वे मुँह कैसे हैं? "कालानलसन्निभानि"—जैसे 'प्रलय की आग' (Doomsday Fire) होती है जो पूरी दुनिया को जलाकर राख कर देती है, बिल्कुल वैसी ही आग उन करोड़ों मुँहों के अंदर से भभक रही है! और उनके दाँत किसी खूंखार राक्षस की तरह 'दंष्ट्राकरालानि' (भयंकर और नुकीले) हैं।
            यह देखकर अर्जुन को भयंकर 'वर्टिगो' (Vertigo / चक्कर) आ गया है! वे कहते हैं: "दिशो न जाने" (मुझे यह भी याद नहीं आ रहा है कि पूरब कहाँ है और पश्चिम कहाँ है! मेरा जीपीएस (GPS) और दिमाग पूरी तरह से सुन्न हो गया है)।
            अर्जुन, जो गीता सुनने से पहले कहते थे "मैं युद्ध नहीं करूँगा," अब वे बच्चों की तरह गिड़गिड़ा रहे हैं: "प्रसीद देवेश" (हे भगवान! प्लीज शांत हो जाइए, अपना यह खौफनाक रूप बंद कीजिए, मुझ पर थोड़ी दया कीजिए!)।
            इंसान का अहंकार ईश्वर के 'रौद्र रूप' (Wrathful Form) के आगे एक सेकंड भी नहीं टिक सकता।
        """.trimIndent(),
        english = """
            O Lord of all lords (Devesha)! O refuge of the universe (Jagan-nivasa)! Seeing Your blazing, death-like faces (Mukani) adorned with completely terrifying, gnashing teeth (Damshtra-karalani), glowing exactly like the horrific, universe-destroying fire at the end of time (Kalanala-sannibhani)...
            I have completely lost my sense of direction (Disho na jane), and my mind finds absolutely no peace or comfort anywhere (Na labhe cha sharma). Therefore, O Lord, please be merciful and gracious to me (Prasida)!
            This is Arjuna desperately, pathetically begging for 'Mercy' from the Supreme Lord.
            Arjuna's terrified gaze is magnetically, fatally drawn back to the Lord's horrific, roaring 'Mouths'. What exactly do they look like? "Kalanala-sannibhani"—They physically resemble the absolute, apocalyptic 'Doomsday Fire' (Kalanala) that violently incinerates the entire multiverse to ash at the end of time. That exact horrific fire is roaring directly out of God's throats! And their teeth are 'Damshtra-karalani' (monstrous, razor-sharp fangs like a cosmic predator).
            Witnessing this, Arjuna is hit with a massive, paralyzing psychological 'Vertigo'! He frantically screams: "Disho na jane" (My brain is entirely short-circuiting! I have completely forgotten which way is North or South! My internal GPS is destroyed).
            The arrogant Arjuna, who an hour ago confidently argued, "I will not fight," is now pathetically begging like a terrified child: "Prasida Devesha" (O Supreme Lord! PLEASE, I beg You, calm down! Shut down this terrifying nightmare manifestation and have some mercy on my soul!).
            The massive human ego absolutely cannot survive even one microsecond when confronted by the unrestrained 'Wrathful Form' (Raudra Rupa) of the Supreme Creator.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            अमी च त्वां धृतराष्ट्रस्य पुत्राः सर्वे सहैवावनिपालसङ्घैः |
            भीष्मो द्रोणः सूतपुत्रस्तथासौ सहास्मदीयैरपि योधमुख्यैः || २६ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 26 और 27 एक ही दृश्य का हिस्सा हैं)
            और देखिए! ये धृतराष्ट्र के सभी सौ पुत्र (दुर्योधन आदि), धरती के इन सभी राजाओं के समूहों (अवनिपालसङ्घैः) के साथ...
            तथा भीष्म पितामह, गुरु द्रोणाचार्य, और वह सूतपुत्र (कर्ण) भी, हमारे पक्ष के (पांडवों की सेना के) सभी प्रमुख योद्धाओं (योधमुख्यैः) के साथ मिलकर...
            (सीधे आपके मुँह में जा रहे हैं - अगले श्लोक में पूरा होगा)।
            भगवान ने अर्जुन को 7वें श्लोक में एक ऑफर (Offer) दिया था: "जो भी तुम 'भविष्य' (Future) के बारे में देखना चाहते हो, वो मेरे इस शरीर में देख लो!"
            अर्जुन का सबसे बड़ा सवाल था: "इस युद्ध में कौन मरेगा और कौन बचेगा?"
            अब अर्जुन अपनी आँखों से उस युद्ध का 'लाइव फ्यूचर टेलीकास्ट' (Live Future Telecast) देख रहे हैं! अर्जुन क्या देखते हैं?
            कौरव सेना के सारे घमंडी राजा (दुर्योधन, दुशासन), जो खुद को अजेय मानते थे। सबसे बड़े महारथी भीष्म और द्रोण (जिनके मरने का अर्जुन को सबसे ज्यादा डर था)। और अर्जुन का सबसे बड़ा दुश्मन 'कर्ण' (सूतपुत्र)।
            यहाँ तक कि खुद अर्जुन की अपनी सेना (पांडवों की साइड) के भी बड़े-बड़े शूरवीर!
            अर्जुन देख रहे हैं कि ये सारे के सारे महान लोग, जिन्हें अपने हथियारों पर बहुत घमंड है, वे सब एक साथ खिंचे चले जा रहे हैं। कहाँ जा रहे हैं? इसका भयंकर और खूनी नज़ारा (Bloody Scene) अगले श्लोक में है!
        """.trimIndent(),
        english = """
            (Verses 26 and 27 form a continuous, horrific vision)
            And behold! All the hundred sons of Dhritarashtra (Duryodhana and others), along with all their massive, allied hosts of earthly kings (Avani-pala-sanghaih)...
            as well as Grandsire Bhishma, Guru Drona, and that son of a charioteer (Suta-putras - Karna), along with all the absolute greatest, chief warriors and generals from our own Pandava army as well (Sahas madiyair api yodha-mukhyaih)...
            (are rushing blindly into Your mouths - completed in the next verse).
            In Verse 7, the Lord had issued a massive open invitation: "Whatever you wish to see regarding the 'Future', simply look inside My body!"
            Arjuna's absolute biggest, most desperate question was: "Who exactly is going to die, and who will survive this horrific World War?"
            Now, Arjuna's retinas are projecting the absolute 'Live Future Telecast' of the war's ultimate conclusion! What exactly does he see?
            He sees all the toxically arrogant Kings of the Kaurava army (Duryodhana, Dushasana) who falsely believed they were invincible. He sees the absolute greatest, unbeatable Grandmasters Bhishma and Drona (whose deaths terrified Arjuna the most). And he sees his ultimate, bitter arch-rival 'Karna' (the Suta-putra).
            Shockingly, he also vividly sees the absolute greatest, elite generals and heroes from his OWN allied Pandava army!
            Arjuna watches as absolutely all these legendary demigods of war, who aggressively flaunted their massive egos and advanced weapons, are being magnetically, helplessly sucked forward in one massive cluster. Where exactly are they going? The brutally gory, blood-soaked 'Climax' explodes in the very next verse!
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            वक्त्राणि ते त्वरमाणा विशन्ति दंष्ट्राकरालानि भयानकानि |
            केचिद्विलग्ना दशनान्तरेषु सन्दृश्यन्ते चूर्णितैरुत्तमाङ्गैः || २७ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 26 के बाद)... वे सभी (कौरव, भीष्म, कर्ण और अन्य योद्धा) बहुत ही तेज़ी से दौड़ते हुए (त्वरमाणाः), आपके उन भयंकर (भयानकानि) और नुकीले-खौफनाक दाँतों वाले (दंष्ट्राकरालानि) मुँहों के अंदर घुसते (गिरते) जा रहे हैं (विशन्ति)!
            उनमें से कुछ लोग तो आपके दोनों दाँतों के बीच में बुरी तरह फँसे हुए (दशनान्तरेषु विलग्नाः) दिखाई दे रहे हैं (सन्दृश्यन्ते), जिनके सिर (उत्तमाङ्गैः) आपके दाँतों से कुचले जाकर बिल्कुल 'चूर-चूर' (चूर्णितैः) हो गए हैं!
            यह भगवद्गीता का सबसे 'गौरी और खूनी' (Gory and Bloody) दृश्य है! 
            अर्जुन का यह 'फ्यूचर-विज़न' (Future-vision) इंसान के इस भ्रम को चकनाचूर कर देता है कि "हम मौत को हरा सकते हैं।" 
            जिन भीष्म, द्रोण और कर्ण को अर्जुन 'अजेय' (Invincible) मानकर डर रहे थे, अर्जुन देखते हैं कि वे सब अपनी मर्जी से नहीं, बल्कि एक 'मैग्नेट' (Magnet) की तरह बड़ी तेज़ी ('त्वरमाणाः') से भगवान के उस भयानक आग उगलते मुँह की तरफ खिंचे चले जा रहे हैं।
            और मुँह के अंदर क्या हो रहा है? भगवान के दाँत एक भयंकर 'क्रशर मशीन' (Crusher Machine) की तरह काम कर रहे हैं।
            बड़े-बड़े राजाओं के सिर ('उत्तमाङ्गैः' / जिन पर सोने के मुकुट सजे थे) भगवान के नुकीले दाँतों के बीच ('दशनान्तरेषु') फँस गए हैं, और दाँतों के दबाव से उनके सिरों की हड्डियां टमाटर की तरह 'चूर-चूर' (चूर्णितैः / Crushed to dust) हो रही हैं! 
            यह रूप देखकर अर्जुन को यह पक्का विश्वास हो गया कि "ये सारे लोग भविष्य में मर चुके हैं! मुझे इन्हें मारने का शोक नहीं करना चाहिए, क्योंकि भगवान ने (काल रूप में) इन्हें पहले ही अपने दाँतों के बीच कुचल कर चबा लिया है!"
        """.trimIndent(),
        english = """
            (Continuing from Verse 26)... All of them are rushing blindly with tremendous, unstoppable speed (Tvaramanah) straight into Your terrifying (Bhayanakani), horrific mouths equipped with massive, fearful teeth (Damshtra-karalani vaktrami te vishanti)!
            I see some of them violently trapped and crushed between Your massive teeth (Kechid vilagna dashanantareshu sandrishyante), with their heads completely smashed and ground into a bloody powder (Churnitair uttamangaih)!
            This is undeniably the absolute most violently 'Gory, Graphic, and Bloody' cinematic scene in the entire Bhagavad Gita!
            Arjuna's horrific 'Future-Vision' violently slaughters the pathetic human delusion that "We can successfully defeat Death using advanced weapons."
            Those exact legendary Titans—Bhishma, Drona, and Karna—whom Arjuna terrifyingly considered 'Invincible', are seen absolutely stripped of their power. They are not walking voluntarily; they are being magnetically, violently sucked forward at hyper-speed ('Tvaramanah') directly into the roaring, fire-breathing, apocalyptic mouths of God.
            And what horrific execution is occurring inside those mouths? The Lord's teeth are operating exactly like a brutal, industrial, cosmic 'Meat-Crusher Machine'.
            The majestic, arrogant heads of the greatest emperors ('Uttamangaih' / heads previously adorned with solid gold crowns) are violently snagged and jammed right between the Lord's razor-sharp fangs ('Dashanantareshu'). Under the sheer, crushing hydraulic pressure of God's jaws, their skulls are literally popping like tomatoes, ground into a bloody, microscopic powder ('Churnitaih' / Crushed to dust)!
            Witnessing this brutal massacre, Arjuna receives the absolute, titanium verification: "All these warriors are ALREADY officially dead in the future! I absolutely must not grieve over killing them, because the Supreme Lord (as Time/Death) has already chewed and pulverized their skulls into dust between His teeth!"
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            यथा नदीनां बहवोऽम्बुवेगाः समुद्रमेवाभिमुखा द्रवन्ति |
            तथा तवामी नरलोकवीरा विशन्ति वक्त्राण्यभिविज्वलन्ति || २८ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार नदियों के पानी की बहुत सी तेज़ धाराएं (बहवोऽम्बुवेगाः) स्वाभाविक रूप से केवल समुद्र की ओर ही (समुद्रमेवाभिमुखा) दौड़ती हैं (द्रवन्ति)...
            बिल्कुल उसी प्रकार, मनुष्य लोक के ये सभी महान शूरवीर योद्धा (नरलोकवीरा) भी (अपने विनाश के लिए) आपके उन चारों ओर से भयंकर आग उगलते हुए (अभिविज्वलन्ति) मुँहों के अंदर घुसते (विशन्ति) चले जा रहे हैं।
            अर्जुन उस खौफनाक दृश्य को समझाने के लिए एक बहुत ही शानदार उदाहरण (Analogy) दे रहे हैं: 'नदियों का समुद्र में मिलना'।
            जब नदियों में बाढ़ आती है, तो पानी का बहाव ('अम्बुवेगाः') इतना भयंकर और तेज़ होता है कि उसे दुनिया का कोई भी बांध (Dam) रोक नहीं सकता। वह पानी हर हाल में दौड़कर अपनी मंज़िल—'विशाल समुद्र'—में जाकर ही गिरता है और खत्म हो जाता है।
            अर्जुन कहते हैं कि बिल्कुल उसी तरह, ये जो कौरव और पांडव सेना के बड़े-बड़े 'हीरो' (वीरा) हैं—जो आज अपनी जवानी और ताकत के नशे में उछल रहे हैं—ये सब उन उफनती हुई नदियों की तरह हैं।
            और आपका यह भड़कती हुई आग ('अभिविज्वलन्ति') वाला डरावना मुँह वह 'समुद्र' है!
            यह नियति (Destiny / मौत) का एक ऐसा 'इनएविटेबल अट्रैक्शन' (Inevitable Attraction / अटल खिंचाव) है जिसे कोई भी योद्धा अपनी ताकत या हथियारों से नहीं रोक सकता। उनकी मौत तय है, और वे खुद दौड़कर अपनी मौत (आपके मुँह) की तरफ जा रहे हैं।
        """.trimIndent(),
        english = """
            Just as the many massive, roaring waves and swift currents of the rivers (Nadinam bahavo 'mbu-vegah) flow inevitably and violently down directly into the ocean (Samudram evabhimukha dravanti)...
            in the exact same manner, all these great, arrogant heroes and warriors of this mortal world (Tava ami nara-loka-vira) are blazing forward and rushing blindly into Your fiercely flaming, apocalyptic mouths (Vishanti vaktrany abhivijvalanti).
            Arjuna is deploying a spectacular, highly visual analogy to vividly describe this horrific massacre: 'The Rushing Rivers merging into the Ocean'.
            During a massive monsoon flood, the roaring, violent current of river waters ('Ambu-vegah') is so terrifyingly fast and unstoppable that absolutely no man-made concrete dam can hold it back. That water rushes unstoppably and violently crashes into its ultimate, final destination—the 'Gigantic Ocean'—where it completely loses its identity and is destroyed.
            Arjuna states that in the exact same manner, all these so-called invincible, elite 'Superheroes' (Vira) of the Kaurava and Pandava armies—who are currently arrogantly flexing their muscles and heavy weapons—are exactly like those violently rushing, doomed rivers.
            And Your terrifying, roaring, violently flaming ('Abhivijvalanti') mouth is the ultimate 'Ocean of Death'!
            This is the absolute, inescapable 'Inevitable Magnetic Attraction' of cosmic Destiny (Death) that absolutely no warrior can ever block with his pathetic earthly weapons. Their brutal expiration date is fully guaranteed, and they are literally aggressively sprinting directly into their own annihilation (Your blazing mouths).
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            यथा प्रदीप्तं ज्वलनं पतङ्गा विशन्ति नाशाय समृद्धवेगाः |
            तथैव नाशाय विशन्ति लोकास्तवापि वक्त्राणि समृद्धवेगाः || २९ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार पतंगे (Moths/कीड़े) अपने विनाश (नाशाय) के लिए बहुत ही तेज़ गति (समृद्धवेगाः) से उड़ते हुए, जलती हुई भयंकर आग (प्रदीप्तं ज्वलनं) में जान-बूझकर घुस जाते हैं (विशन्ति)...
            बिल्कुल उसी प्रकार, ये सभी लोग (लोकाः) भी अपने ही विनाश (नाशाय) के लिए, अत्यंत तेज़ गति से (समृद्धवेगाः) आपके ही भयंकर मुँहों में घुसते (विशन्ति) चले जा रहे हैं।
            यह मौत और अज्ञानता का एक और बहुत ही अचूक (Spot-on) उदाहरण है: 'आग और पतंगे'।
            बरसात के मौसम में जब कोई दीया या आग जलती है, तो छोटे-छोटे कीड़े (पतंगे) उस रोशनी (आग) को देखकर इतने 'आकर्षित' (Attracted/Hypnotized) हो जाते हैं कि वे भूल जाते हैं कि यह आग उन्हें जला देगी। वे खुद अपनी पूरी स्पीड ('समृद्धवेगाः') से उड़कर उस आग में कूद पड़ते हैं और भस्म हो जाते हैं।
            अर्जुन कह रहे हैं कि दुर्योधन और उसके साथी राजा बिल्कुल उन्हीं 'बेवकूफ पतंगों' की तरह हैं!
            उन्हें सत्ता, पैसे और ज़मीन (राज्य) का 'लालच' इतना सुंदर और आकर्षक (रोशनी की तरह) लग रहा है कि वे अपनी मौत को भूल चुके हैं। वे खुद अपनी ही स्पीड से दौड़कर (युद्ध करने आकर) भगवान के इस 'काल-रूपी' (Time/Death) मुँह में कूद रहे हैं।
            ईश्वर (या मौत) उन्हें मार नहीं रहा है; वे अपने खुद के अहंकार और वासना के कारण 'सुसाइड' (Suicide/आत्मनाश) कर रहे हैं! यह श्लोक इंसान की उस बेवकूफी को दिखाता है जहाँ वह खुद अपने विनाश की ओर दौड़ता है।
        """.trimIndent(),
        english = """
            Just as the swarms of moths (Patanga), completely hypnotized, rush with extreme, accelerated speed (Samriddha-vegah) directly into a blazing, roaring fire (Pradiptam jvalanam) simply to be violently destroyed (Nashaya vishanti)...
            in the exact same horrific way, all these people and kings (Lokah) are rushing blindly with tremendous, unstoppable speed (Samriddha-vegah) into Your terrifying mouths, solely for their own absolute destruction (Tavapi vaktrani nashaya vishanti).
            This is yet another brilliantly flawless, highly accurate analogy illustrating the lethal combination of human ignorance and imminent Death: 'The Blazing Fire and the Moths'.
            In the dark night, when a blazing lamp or fire is lit, swarms of tiny insects (Moths) become so violently 'Hypnotized' and fatally attracted to the glowing light that they completely forget their basic biological survival instincts. They willfully sprint at maximum velocity ('Samriddha-vegah') directly into the flames and are instantly incinerated to ash.
            Arjuna is explicitly declaring that the arrogant Duryodhana and his massive army of elite kings are exactly like those 'Idiotic, suicidal Moths'!
            The toxic greed for immense political power, billions of dollars, and the royal throne appears so incredibly beautiful and seductive (like the glowing fire) to them that they have completely forgotten their own impending death. They are literally running at top speed, willfully throwing themselves onto the battlefield, directly into the absolute, apocalyptic 'Mouth of Time/Death' (God).
            God (Death) is absolutely not hunting them down; they are actively committing mass 'Cosmic Suicide' driven entirely by their own blinding arrogance and lust! This verse perfectly captures the pathetic human stupidity of sprinting enthusiastically towards one's own violent annihilation.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            लेलिह्यसे ग्रसमानः समन्ताल्लोकान्समग्रान्वदनैर्ज्वलद्भिः |
            तेजोभिरापूर्य जगत्समग्रं भासस्तवोग्राः प्रतपन्ति विष्णो || ३० ||
        """.trimIndent(),
        hindi = """
            हे विष्णु! आप अपने आग उगलते हुए भयंकर मुँहों (वदनैर्ज्वलद्भिः) से सभी दिशाओं के (समन्तात्) संपूर्ण लोकों (लोगों) को एक साथ निगलते हुए (ग्रसमानः), अपने होठों को बार-बार चाट रहे हैं (लेलिह्यसे)!
            आपका वह अत्यंत उग्र और खौफनाक प्रकाश (भासस्तवोग्राः) अपने भयंकर तेज़ (रेडिएशन / तेजोभिः) से इस पूरे के पूरे ब्रह्मांड (जगत्समग्रं) को पूरी तरह भरकर (आपूर्य), उसे भयंकर रूप से जला रहा है (प्रतपन्ति)।
            यह विश्वरूप दर्शन का सबसे 'टेरीफाइंग और एपोकैलिप्टिक' (Terrifying and Apocalyptic / प्रलयंकारी) चरम बिंदु (Peak) है!
            अर्जुन भगवान के मुँह के अंदर का सबसे खौफनाक 'एक्शन' (Action) देख रहे हैं। 
            भगवान केवल लोगों को चबा नहीं रहे हैं; जैसे किसी भूखे शेर को बहुत स्वादिष्ट शिकार मिल गया हो, वैसे ही काल (Death) रूपी भगवान इन घमंडी राजाओं को निगलने (ग्रसमानः) के बाद मज़े से अपने होठों को अपनी जीभ से 'चाट' रहे हैं (लेलिह्यसे - Licking the lips)! यह मौत का सबसे खूंखार रूप है, जो हर किसी को खा जाने के लिए बेताब है।
            और भगवान के शरीर से जो रोशनी निकल रही है, वह कोई नॉर्मल (Normal) रोशनी नहीं है। 
            वह एक 'उग्र भासः' (Violent, Aggressive Radiation) है! वह रेडिएशन पूरे ब्रह्मांड (समग्र जगत्) में गैस-चैम्बर (Gas-chamber) की तरह भर गई है और पूरे ब्रह्मांड को माइक्रोवेव (Microwave) की तरह बुरी तरह भून और जला ('प्रतपन्ति') रही है।
            अर्जुन का यह खौफनाक नज़ारा देखकर दम घुट रहा है। वे भगवान विष्णु से यह जानना चाहते हैं कि आखिर आप इस रूप में दुनिया को जला क्यों रहे हैं!
        """.trimIndent(),
        english = """
            O Lord Vishnu! I see You devouring and swallowing up (Grasamanah) all people from all directions (Lokaan samantan) with Your blazing, flaming mouths (Vadanair jvaladbhih), and You are fiercely licking Your lips in satisfaction (Lelihyase)!
            Covering the entire universe with Your immeasurable, blinding rays (Tejobhir apurya jagat samagram), Your fierce, terrifying, and aggressive radiation is violently scorching and burning the entire cosmos (Bhasas tavograh pratapanti Vishno).
            This is the absolute, terrifying, 'Apocalyptic Peak' and absolute climax of the Vishwaroopa revelation!
            Arjuna is visually processing the absolute most horrific, cold-blooded 'Action' occurring directly inside God's raging mouths.
            The Lord (manifested as Universal Time/Death) is not merely mechanically chewing up these arrogant humans. Exactly like a starving, bloodthirsty apex lion enthusiastically devouring its favorite prey, the Lord is violently swallowing (Grasamanah) these kings and aggressively 'Licking His lips' (Lelihyase) with a terrifying, horrific satisfaction! This is the absolute most terrifying, predatory manifestation of Death, desperately eager to consume absolutely everything.
            And the blinding light radiating from the Lord's colossal body is absolutely NOT normal, peaceful illumination.
            It is an 'Ugrah Bhasah' (a violently aggressive, highly lethal, and toxic Radiation)! That apocalyptic radiation has entirely flooded the entire multiverse (Samagram Jagat) exactly like a lethal cosmic gas chamber, and it is aggressively scorching, melting, and literally 'Microwaving' ('Pratapanti') the entire cosmos to ash.
            Arjuna is literally suffocating and having a massive mental breakdown witnessing this cosmic horror. He desperately screams out to Lord Vishnu, terrified and begging to know why God is violently incinerating the entire universe in this terrifying form!
        """.trimIndent()
    ),

    Shloka(
        id = 31,
        sanskrit = """
            आख्याहि मे को भवानुग्ररूपो नमोऽस्तु ते देववर प्रसीद |
            विज्ञातुमिच्छामि भवन्तमाद्यं न हि प्रजानामि तव प्रवृत्तिम् || ३१ ||
        """.trimIndent(),
        hindi = """
            हे अत्यंत उग्र (डरावने) रूप वाले! कृपा करके मुझे बताइए (आख्याहि मे) कि आप वास्तव में कौन हैं (को भवान्)? हे देवों में श्रेष्ठ! आपको मेरा नमस्कार है (नमोऽस्तु ते), आप मुझ पर प्रसन्न हों (प्रसीद)।
            मैं आप 'आदि-पुरुष' (सबसे प्राचीन / Original) को विशेष रूप से (विज्ञातुम्) जानना चाहता हूँ, क्योंकि मैं आपकी इस भयंकर प्रवृत्ति (कदम या एक्शन / Action) को बिल्कुल भी समझ नहीं पा रहा हूँ (न हि प्रजानामि)।
            अर्जुन का दिमाग अब 100% शॉर्ट-सर्किट (Short-circuit) हो चुका है। वे काँप रहे हैं।
            अर्जुन के सामने जो सत्ता खड़ी है, वह आग उगल रही है और ग्रहों को चबा रही है। अर्जुन भूल जाते हैं कि यह कृष्ण हैं! अर्जुन पूछते हैं: "को भवान्?" (हु आर यू? / Who are you?)
            अर्जुन कह रहे हैं: "हे उग्र रूप वाले (Terrifying Entity)! मैं मानता हूँ कि आप भगवान हैं, लेकिन भगवान तो दयालु होते हैं! आपका यह रूप इतना हिंसक (Violent) क्यों है? आप इन सबको क्यों खा रहे हैं?"
            "आप जो यह 'प्रवृत्ति' (Apocalyptic Action / प्रलय का काम) कर रहे हैं, इसका 'पर्पस' (Purpose/उद्देश्य) क्या है? मैं जानना चाहता हूँ कि आप इस रूप में यहाँ क्या करने आए हैं?"
            यह इंसान का वह सवाल है जब वह प्रकृति के भयंकर रूप (जैसे सुनामी या भूकंप) को देखकर पूछता है कि "ईश्वर इतना क्रूर क्यों हो सकता है?" इसका जवाब भगवान अगले ही श्लोक में देते हैं!
        """.trimIndent(),
        english = """
            O Lord of terrifying and fierce form (Ugra-rupo), please tell me exactly who You are (Akhyahi me ko bhavan). I offer my humble obeisances unto You (Namo 'stu te); please be gracious to me (Prasida).
            I desperately wish to know You, the absolute original Personality (Bhavantam adyam), for I completely fail to understand what Your exact mission and purpose is here (Na hi prajanami tava pravrittim).
            Arjuna's biological brain has completely crashed, and his psychological software is officially short-circuiting in absolute terror.
            The monstrous, galactic entity standing before him is vomiting roaring fire and aggressively chewing up planets. Arjuna completely forgets he is talking to his sweet friend Krishna and screams: "Ko bhavan?" (WHO ARE YOU?).
            Arjuna is desperately pleading: "O Ugra-rupa (Terrifying Entity)! I know You are God, but God is supposed to be peaceful! Why is Your current manifestation so unimaginably 'Violent' and apocalyptic? Why are You slaughtering everyone?"
            "I completely fail to comprehend Your 'Pravrittim' (Your current aggressive Action/Mission). What exactly is the ultimate 'Purpose' behind this horrific cosmic destruction You are executing right now?"
            This mirrors the exact terrifying question a human asks when witnessing a catastrophic earthquake or tsunami: "How can God be so brutal?" The Supreme Lord delivers the legendary, earth-shattering answer in the very next verse!
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            श्रीभगवानुवाच |
            कालोऽस्मि लोकक्षयकृत्प्रवृद्धो लोकान्समाहर्तुमिह प्रवृत्तः |
            ऋतेऽपि त्वां न भविष्यन्ति सर्वे येऽवस्थिताः प्रत्यनीकेषु योधाः || ३२ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: मैं सभी लोकों (दुनिया) का विनाश करने वाला अत्यंत बढ़ा हुआ (प्रवृद्धो) 'महाकाल' (मृत्यु / Time) हूँ! और इस समय मैं इन सभी लोगों का नाश (समाहर्तुम्) करने के लिए यहाँ प्रवृत्त (लगा हुआ) हूँ।
            तुम्हारे युद्ध न करने पर भी (ऋतेऽपि त्वां), दुश्मन की सेनाओं (प्रत्यनीकेषु) में जो भी शूरवीर योद्धा (योधाः) खड़े हैं, वे सब के सब जीवित नहीं बचेंगे (न भविष्यन्ति सर्वे)।
            यह पूरी दुनिया के इतिहास का सबसे भयंकर, खौफनाक और प्रसिद्ध श्लोक है! (यही वह श्लोक है जिसे परमाणु बम बनाने वाले वैज्ञानिक रॉबर्ट ओपेनहाइमर ने अपनी आँखों से बम फटते हुए देखकर बोला था: "Now I am become Death, the destroyer of worlds.")
            अर्जुन ने पूछा था: "तुम कौन हो?" 
            भगवान दहाड़ते हुए जवाब देते हैं: "कालोऽस्मि!" (मैं 'वक्त' हूँ! मैं 'महाकाल' हूँ! मैं साक्षात् 'मौत' हूँ!)। 
            भगवान कहते हैं, "मैं यहाँ क्यों आया हूँ? मैं यहाँ इन पापी राजाओं का 'विनाश' करने आया हूँ। मेरा काम शुरू हो चुका है।"
            और फिर भगवान अर्जुन का सबसे बड़ा ईगो (Ego) तोड़ देते हैं। अर्जुन सोच रहे थे कि "अगर मैं नहीं लड़ूंगा, तो ये लोग बच जाएंगे।"
            महाकाल कहते हैं: "हे अर्जुन! तुम्हारी कोई औकात नहीं है! अगर तुम हथियार डालकर घर चले भी गए (ऋतेऽपि त्वां), तो भी सामने खड़े इन भीष्म, द्रोण और दुर्योधन में से एक भी इंसान ज़िंदा नहीं बचेगा! मैंने (समय ने) इन्हें पहले ही मार दिया है!"
            यह श्लोक इंसान को बताता है कि 'समय' (Time) सबसे बड़ा हत्यारा है, जिसे कोई नहीं रोक सकता।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead aggressively declared: I am Time (Kalo 'smi), the great, terrifying destroyer of the worlds (Loka-kshaya-krit pravriddho), and I have come here to aggressively engage in destroying all people (Lokan samahartum iha pravrittah).
            With the sole exception of you (the Pandavas), absolutely none of all the soldiers situated here on both sides will survive (Rite 'pi tvam na bhavishyanti sarve); even without your participation, they are already dead.
            This is universally recognized as the absolute most terrifying, apocalyptic, and legendary verse in global history! (This is the exact verse Julius Robert Oppenheimer, the father of the atomic bomb, chillingly quoted upon witnessing the first nuclear detonation: "Now I am become Death, the destroyer of worlds.")
            Arjuna asked: "Who are You?"
            The Lord roars with cosmic authority: "KALO 'SMI!" (I AM TIME! I am the absolute, unbeatable, all-devouring 'DEATH'!).
            "Why am I here? I have manifested right here, right now, specifically to ruthlessly 'Annihilate' these toxic kings. My execution sequence has already begun."
            Then, the Lord violently crushes Arjuna's biggest false ego. Arjuna arrogantly hallucinated: "If I choose to act merciful and refuse to fight, I will save their lives."
            Maha-kala (Death) ruthlessly corrects him: "O Arjuna! You are biologically irrelevant! Even if you drop your weapons and cowardly run home today, absolutely NOT A SINGLE ONE of these elite warriors (Bhishma, Drona, Duryodhana) standing before you will survive! I (Time) have already slaughtered them!"
            This verse proves that 'Time' is the ultimate, invincible assassin that no human choice can ever escape.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            तस्मात्त्वमुत्तिष्ठ यशो लभस्व जित्वा शत्रून् भुङ्क्ष्व राज्यं समृद्धम् |
            मयैवैते निहताः पूर्वमेव निमित्तमात्रं भव सव्यसाचिन् || ३३ ||
        """.trimIndent(),
        hindi = """
            इसलिए हे अर्जुन! तुम युद्ध के लिए उठ खड़े हो (तस्मात्त्वमुत्तिष्ठ), यश (महान नाम) प्राप्त करो (यशो लभस्व), और अपने शत्रुओं को जीतकर (जित्वा शत्रून्) धन-धान्य से भरे हुए राज्य का सुख भोगो (भुङ्क्ष्व राज्यं समृद्धम्)।
            मेरे द्वारा ये सभी योद्धा पहले ही मारे जा चुके हैं (मयैवैते निहताः पूर्वमेव); हे सव्यसाचिन् (दोनों हाथों से तीर चलाने वाले अर्जुन)! तुम तो केवल 'निमित्त मात्र' (एक साधन / Instrument) बन जाओ!
            यह श्लोक 'सक्सेस और मैनेजमेंट' (Success & Karma Yoga) का सबसे बड़ा मास्टरस्ट्रोक (Masterstroke) है! 
            भगवान अर्जुन से कहते हैं, "जब मैंने इन सबको पहले ही मार दिया है, तो तुम क्यों फालतू में हत्या का गिल्ट (Guilt) पाल रहे हो?"
            भगवान अर्जुन को एक बहुत ही शानदार डील (Deal) ऑफर करते हैं: "काम मैंने कर दिया है, लेकिन तुम अपना गांडीव उठाओ, तीर चलाओ और दुनिया की नज़रों में 'क्रेडिट' (Credit/यश) तुम ले लो! दुनिया कहेगी कि महान अर्जुन ने सबको हरा दिया, और तुम इस धरती का राज भोगो।"
            यहाँ सबसे ताकतवर शब्द है: "निमित्त-मात्रं" (Be merely an Instrument)। 
            इंसान दुःखी क्यों होता है? क्योंकि वह सोचता है "मैं कर रहा हूँ।" भगवान कहते हैं कि तुम कुछ नहीं कर रहे। तुम केवल मेरे हाथ में एक 'कठपुतली' (Tool/Instrument) हो। एक पेन (Pen) अपने आप नहीं लिखता, राइटर (Writer) उससे लिखवाता है।
            तुम अपना अहंकार छोड़ो, अपने आप को ईश्वर के हाथों में सौंप दो (निमित्त बन जाओ), और फिर देखो कि ईश्वर तुम्हारे हाथों से कैसे असंभव काम करवा देते हैं, जिसका सारा 'यश' (Fame) भी तुम्हें ही मिलेगा!
        """.trimIndent(),
        english = """
            Therefore, get up and stand firmly (Tasmat tvam uttishtha). Prepare to fight and win unparalleled glory (Yasho labhasva). Conquer your enemies and seamlessly enjoy a flourishing, immensely wealthy kingdom (Bhunkshva rajyam samriddham).
            They are all completely, already put to death by My arrangement long before (Mayaivaite nihatah purvam eva), and you, O Savyasachin (Arjuna, who can shoot arrows expertly with both hands), can be but an instrument in the fight (Nimitta-matram bhava).
            This verse delivers the absolute ultimate 'Masterstroke' of Karma Yoga, Success, and Destiny!
            The Lord essentially tells Arjuna, "Since I have already officially terminated their lifespans, why on earth are you carrying this toxic, fake guilt of becoming a 'Murderer'?"
            The Lord offers Arjuna the absolute greatest, most highly lucrative 'Cosmic Deal' in history: "I have already done the heavy lifting and executed them in the higher dimension. All you have to do is physically pick up your bow, shoot the arrows, and take 100% of the 'Credit' (Yasho/Fame)! The blind world will worship you as the ultimate victor, and you will enjoy a massive empire."
            The absolute most staggeringly powerful phrase here is: "Nimitta-matram" (Become merely an Instrument/Tool).
            Why do humans suffer intense anxiety? Because their toxic ego screams, "I am doing this!" The Lord reveals: You are absolutely doing nothing. You are merely a 'Tool' in My hands. A pen cannot write a masterpiece alone; the Writer uses the pen.
            Delete your false ego, completely surrender yourself as an empty 'Instrument' in God's hands, and watch how the Supreme Lord effortlessly executes impossible, world-changing miracles through your physical body, giving YOU the entire glory!
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            द्रोणं च भीष्मं च जयद्रथं च कर्णं तथान्यानपि योधवीरान् |
            मया हतांस्त्वं जहि मा व्यथिष्ठा युध्यस्व जेतासि रणे सपत्नान् || ३४ ||
        """.trimIndent(),
        hindi = """
            द्रोणाचार्य, भीष्म पितामह, जयद्रथ और कर्ण तथा अन्य बहुत से महान और शूरवीर योद्धाओं को (तथान्यानपि योधवीरान्)...
            मेरे द्वारा पहले ही मारा जा चुका है (मया हतान्)! इसलिए तुम केवल उन्हें (बाहरी तौर पर) मारो (त्वं जहि), बिल्कुल भी घबराओ या डरो मत (मा व्यथिष्ठाः)। तुम युद्ध करो (युध्यस्व), तुम युद्ध में अपने दुश्मनों को निश्चित रूप से जीतोगे (जेतासि रणे सपत्नान्)।
            अर्जुन के दिमाग में जिन 4 लोगों का सबसे बड़ा खौफ (Phobia/Fear) बैठा हुआ था, भगवान कृष्ण उनका सीधा 'नाम' लेकर अर्जुन का डर खत्म कर रहे हैं।
            १. 'द्रोण': जिनके पास ब्रह्मांड के सारे दिव्य अस्त्र थे (गुरु)।
            २. 'भीष्म': जिन्हें अपनी मर्जी से मरने (इच्छा मृत्यु) का वरदान था, उन्हें कोई नहीं मार सकता था।
            ३. 'जयद्रथ': जिसके पिता का वरदान था कि जो जयद्रथ का सिर ज़मीन पर गिराएगा, उसका खुद का सिर 100 टुकड़ों में फट जाएगा।
            ४. 'कर्ण': जो अर्जुन के बराबर का ही तीरंदाज़ था।
            अर्जुन का सोचना लॉजिकल (Logical) था कि "इन 4 अजेय लोगों को मैं कैसे मार सकता हूँ?"
            भगवान डंके की चोट पर कहते हैं: "मया हतान्" (इनके सारे वरदान, सारी ताकत और सारी उम्र मैंने पहले ही 'कैंसिल' / Cancel कर दी है! ये अब केवल अंदर से मरी हुई लाशें हैं जो बाहर से खड़ी हैं)।
            "मा व्यथिष्ठाः" (पैनिक मत करो / Do not panic!)। तुम बस तीर छोड़ो, तुम्हारी जीत 100% फिक्स (Fix) है। यह श्लोक ईश्वर पर पूर्ण विश्वास (Faith) का प्रतीक है।
        """.trimIndent(),
        english = """
            Drona, Bhishma, Jayadratha, Karna, and many other great, supposedly invincible elite warriors (Yodha-viran)...
            have already been utterly destroyed and killed by Me (Maya hatan). Therefore, simply strike them down and kill them (Tvam jahi). Do not be disturbed or terrified at all (Ma vyathishthah). Simply fight (Yudhyasva), and you will undoubtedly completely vanquish your enemies in battle (Jetasi rane sapatnan).
            Lord Krishna surgically directly calls out the exact 'Names' of the 4 absolute greatest nightmares causing massive psychological Phobia in Arjuna's brain.
            1. 'Drona': The supreme Guru who possessed the access codes to all cosmic nuclear weapons.
            2. 'Bhishma': The Grandmaster who possessed a terrifying boon that he could only die when he personally chose to (Invincible).
            3. 'Jayadratha': Who held a lethal curse that whoever caused his head to fall to the ground would instantly have his own head violently explode into 100 pieces.
            4. 'Karna': The absolute apex rival whose archery flawlessly matched Arjuna's.
            Arjuna's logic was totally justified: "How can I biologically or magically possibly kill these 4 unbeatable titans?"
            The Lord aggressively declares: "Maya hatan" (I have already officially 'Canceled' their boons, revoked their powers, and deleted their lifespans! They are literally just dead corpses currently standing on biological autopilot).
            "Ma vyathishthah" (Stop panicking immediately!). Just shoot your arrows; your ultimate victory is mathematically 100% Fixed and Guaranteed by ME. This verse demands absolute, blind trust in God's master plan.
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            सञ्जय उवाच |
            एतच्छ्रुत्वा वचनं केशवस्य कृताञ्जलिर्वेपमानः किरीटी |
            नमस्कृत्वा भूय एवाह कृष्णं सगद्गदं भीतभीतः प्रणम्य || ३५ ||
        """.trimIndent(),
        hindi = """
            संजय ने धृतराष्ट्र से कहा: भगवान केशव (श्रीकृष्ण) के इन खौफनाक और स्पष्ट वचनों को सुनकर (एतच्छ्रुत्वा वचनं), मुकुट धारण किए हुए अर्जुन (किरीटी) डर के मारे बहुत बुरी तरह काँपने लगे (वेपमानः)।
            उन्होंने अपने दोनों हाथ जोड़कर (कृताञ्जलिः) भगवान को नमस्कार किया, और अत्यंत डरे हुए (भीतभीतः) और काँपती हुई रुंधी आवाज़ (गले में अटकती आवाज़ / सगद्गदं) में भगवान कृष्ण के सामने झुककर (प्रणम्य) फिर से (भूय एव) यह कहा।
            यहाँ 'कैमरा' (Camera) वापस संजय पर आता है, जो धृतराष्ट्र को लाइव (Live) कमेंट्री सुना रहे हैं।
            संजय अर्जुन की 'फिजिकल और साइकोलॉजिकल' (Physical & Psychological) हालत का बहुत ही सजीव (Vivid) वर्णन कर रहे हैं।
            अर्जुन ('किरीटी' - जिसे इंद्र से शानदार मुकुट मिला था, जो सबसे बड़ा हीरो था) आज पूरी तरह से टूट गया है।
            जब उसने देखा कि कृष्ण कोई दोस्त नहीं, बल्कि 'मौत' (काल) हैं जो सबको चबा रहे हैं, तो अर्जुन की हालत खराब हो गई। अर्जुन एक आम डरे हुए इंसान की तरह 'वेपमानः' (बुरी तरह काँप रहा है)। 
            वह हाथ जोड़े हुए है ('कृताञ्जलिः')। उसकी आवाज़ गले में फँस रही है और वह हकला रहा है ('सगद्गदं')। वह इतना डर गया है ('भीतभीतः' - Terrified) कि वह बार-बार भगवान के आगे ज़मीन पर झुक रहा है।
            यह दृश्य यह साबित करता है कि जब इंसान के सामने ईश्वरीय शक्ति अपनी असली 100% औकात (Magnitude) में आती है, तो इंसान का सारा घमंड और ताकत पल भर में मिट्टी बन जाता है।
        """.trimIndent(),
        english = """
            Sanjaya officially reported to King Dhritarashtra: Having heard these terrifyingly absolute words from Lord Keshava (Krishna), the crowned Arjuna (Kiriti) violently trembled in sheer panic (Vepamanah).
            With his hands tightly folded in absolute submission (Kritanjalir), he repeatedly offered his obeisances (Namaskritva). Being completely overwhelmed and severely terrified (Bhita-bhitah), he bowed down before Lord Krishna and began to speak with a highly faltering, choked, and trembling voice (Sa-gadgadam).
            Here, the cosmic 'Camera' cuts back to Sanjaya, who is aggressively live-streaming this apocalyptic event to the blind King Dhritarashtra.
            Sanjaya paints an incredibly vivid, raw picture of Arjuna's completely shattered 'Physical and Psychological' state.
            Arjuna ('Kiriti' - the absolute alpha-hero who proudly wore the crown gifted by Indra) is now completely broken and reduced to absolute zero.
            Upon violently realizing that his sweet friend Krishna is actually the apocalyptic 'Time/Death' currently chewing up the entire universe, Arjuna's biological system fails. He is 'Vepamanah' (violently shivering and shaking like a leaf).
            His hands are tightly glued together in pure submission ('Kritanjalir'). His vocal cords are paralyzed, causing him to stutter and choke on his own words ('Sa-gadgadam'). He is so paralyzingly terrified ('Bhita-bhitah') that he keeps aggressively bowing his head down into the dirt before the Lord.
            This brutal scene absolutely proves that when a human being is confronted by the raw, 100% unfiltered, terrifying Magnitude of God, the greatest human ego and military power instantly evaporates into worthless dust.
        """.trimIndent()
    ),
    Shloka(
        id = 36,
        sanskrit = """
            अर्जुन उवाच |
            स्थाने हृषीकेश तव प्रकीर्त्या जगत्प्रहृष्यत्यनुरज्यते च |
            रक्षांसि भीतानि दिशो द्रवन्ति सर्वे नमस्यन्ति च सिद्धसङ्घाः || ३६ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने (काँपते हुए) कहा: हे हृषीकेश (इन्द्रियों के स्वामी कृष्ण)! यह बिल्कुल उचित ही (स्थाने) है कि आपके नाम, गुणों और प्रभाव के कीर्तन (प्रकीर्त्या / महिमा गान) से यह पूरा ब्रह्मांड अत्यंत हर्षित (खुश) होता है और आपसे असीम प्रेम (अनुरज्यते) करता है।
            और यह भी बिल्कुल सही है कि आपसे डरे हुए (भीतानि) राक्षस (रक्षांसि) जान बचाकर दसों दिशाओं में भाग रहे हैं (दिशो द्रवन्ति), और सभी सिद्ध पुरुषों के समूह (सिद्धसङ्घाः) आपको सिर झुकाकर प्रणाम (नमस्यन्ति) कर रहे हैं।
            अब अर्जुन का 'रीबूट' (Reboot) हो रहा है। अर्जुन को समझ आ गया है कि यह जो खौफनाक नज़ारा (विश्वरूप) है, यह दुनिया के लिए 'बुरा' नहीं, बल्कि 'परफेक्ट' (Perfect) है!
            अर्जुन कहते हैं: "स्थाने" (Everything is exactly as it should be / सब कुछ बिल्कुल सही हो रहा है!)
            अर्जुन भगवान से कहते हैं कि "आपकी इस भयंकर ताकत को देखकर मुझे समझ आ गया कि अच्छे लोग (संत/भक्त) आपसे प्यार क्यों करते हैं, क्योंकि आप उन्हें खुशी (प्रहृष्यति) देते हैं।"
            "और यह जो सारे खूंखार राक्षस (Terrorists / रक्षांसि) हैं, जो खुद को बहुत तीसमारखां समझते थे, वे आपकी इस काल-अग्नि को देखकर कुत्तों की तरह डर कर ब्रह्मांड के हर कोने में छुपने के लिए भाग रहे हैं ('दिशो द्रवन्ति')।"
            "और जो बड़े-बड़े सिद्ध पुरुष हैं, वे इस सत्य को जानकर आपके सामने घुटने टेक रहे हैं।" 
            अर्जुन भगवान के उस 'जस्टिस सिस्टम' (Cosmic Justice System) को देखकर सेटिस्फाइड (Satisfied) हो गए हैं, जहाँ दुष्टों का विनाश और अच्छों की रक्षा हो रही है।
        """.trimIndent(),
        english = """
            Arjuna, his voice trembling, said: O Hrishikesha, Master of the senses! It is absolutely rightful and perfect (Sthane) that the entire universe deeply rejoices and becomes intensely attached to You upon hearing Your glories and chanting Your name (Tava prakirtya jagat prahrishyaty anurajyate cha).
            And it is equally perfect that the terrifying demons are completely panic-stricken and are fleeing blindly in all directions out of sheer terror (Rakshamsi bhitani disho dravanti), while the massive hosts of perfected, self-realized saints are bowing down respectfully before You (Sarve namasyanti cha siddha-sanghah).
            Arjuna's shattered consciousness is officially executing a massive 'Reboot'. He suddenly realizes that this apocalyptic, horrifying spectacle (Vishwaroopa) is absolutely NOT 'evil'; it is the most 'Flawlessly Perfect' system of justice!
            Arjuna proudly declares: "Sthane" (Everything is operating exactly flawlessly as it is supposed to!)
            Arjuna tells the Lord: "Witnessing this staggering power, I now perfectly understand why the innocent and pious heavily rejoice ('Prahrishyati') and love You—because You are their ultimate protector."
            "And these toxic, arrogant, bloodthirsty Demons ('Rakshamsi'), who terrorized the earth thinking they were untouchable, are now violently panicking, fleeing like terrified rats in all directions just to escape Your apocalyptic wrath ('Disho dravanti')."
            "Meanwhile, the elite, perfected sages, fully comprehending this ultimate truth, are completely bowing down to Your absolute authority."
            Arjuna is incredibly satisfied witnessing the Lord's flawless 'Cosmic Justice System' in action, where evil is brutally annihilated and the innocent are perfectly protected.
        """.trimIndent()
    ),
    Shloka(
        id = 37,
        sanskrit = """
            कस्माच्च ते न नमेरन्महात्मन् गरीयसे ब्रह्मणोऽप्यादिकर्त्रे |
            अनन्त देवेश जगन्निवास त्वमक्षरं सदसत्तत्परं यत् || ३७ ||
        """.trimIndent(),
        hindi = """
            हे महात्मन्! वे सभी (सिद्ध पुरुष आदि) आपको प्रणाम क्यों न करें (कस्माच्च ते न नमेरन्)? क्योंकि आप तो ब्रह्मा जी (ब्रह्मणः) से भी बड़े (गरीयसे) और उनके भी मूल रचयिता (आदिकर्त्रे) हैं!
            हे अनंत! हे देवेश! हे जगन्निवास! आप ही 'सत्' (कभी न मिटने वाली आत्मा) हैं, आप ही 'असत्' (मिटने वाली प्रकृति) हैं, और जो इन दोनों से भी परे परम तत्व 'अक्षर' (परब्रह्म) है... वह सब कुछ केवल आप ही (त्वम्) हैं!
            अर्जुन अब भगवान श्रीकृष्ण की एक अत्यंत ही 'लॉजिकल और सुप्रीम' (Logical & Supreme) स्तुति कर रहे हैं।
            अर्जुन खुद से ही सवाल पूछते हैं: "दुनिया के सारे महान लोग और देवता आपको प्रणाम क्यों न करें?" और फिर वो खुद ही इसका सबसे बड़ा कारण बताते हैं।
            दुनिया मानती है कि 'ब्रह्मा जी' (Brahma) ने इस दुनिया को बनाया है (वे क्रिएटर / Creator हैं)। लेकिन अर्जुन कहते हैं, "हे कृष्ण! आप तो उन ब्रह्मा जी के भी 'आदिकर्त्रे' (Original Creator / पिता) हैं! जब आप ब्रह्मा के भी बॉस हैं, तो पूरी दुनिया आपके सामने क्यों नहीं झुकेगी?"
            अर्जुन भगवान को तीन शानदार टाइटल (Titles) देते हैं:
            १. 'अनन्त' (Infinite): जिसका कोई बॉर्डर (Border/अंत) नहीं है।
            २. 'देवेश' (God of Gods): जो सारे देवताओं का भी देवता है।
            ३. 'जगन्निवास' (Home of the Universe): जिसके अंदर यह पूरा ब्रह्मांड एक घर की तरह टिका है।
            "सदसत्तत्परं": यह दुनिया में जो कुछ भी अच्छा है (सत्), जो कुछ भी बुरा या मिटने वाला है (असत्), और जो इन सबसे बाहर (अक्षर / Beyond) है—वो सब कुछ मिलाकर 'केवल आप' (त्वम्) ही हैं!
        """.trimIndent(),
        english = """
            O Great One (Mahatman)! Why should they absolutely not bow down to offer their total homage unto You (Kasmach cha te na nameran)? For You are vastly superior and infinitely greater even than Lord Brahma (Gariyase brahmano), being the absolute original creator of him (Adi-kartre)!
            O Infinite One (Ananta)! O God of the demigods (Devesha)! O Refuge of the entire universe (Jagan-nivasa)! You are the invincible, imperishable source (Aksharam), the ultimate cause of all causes, transcendental to both this material manifestation (Asat) and the unmanifested spirit (Sat), and You are the Supreme Truth that lies infinitely beyond them both (Tat param yat).
            Arjuna is now violently pouring out the absolute most 'Logical and Supreme' glorification of Lord Sri Krishna.
            Arjuna asks a rhetorical question: "Why on earth would the greatest entities in the multiverse NOT bow down in total submission to You?" He instantly drops the staggering answer.
            The ignorant world officially considers 'Lord Brahma' to be the absolute Creator of the universe. But Arjuna declares, "O Krishna! You are the 'Adi-kartre' (The Original Creator / The Father) of even Lord Brahma! If You are the Boss of the Creator himself, why wouldn't the entire cosmos fall to its knees before You?"
            Arjuna assigns three breathtaking, massive Titles to the Lord:
            1. 'Ananta' (The Infinite): The entity possessing absolute zero borders or limits.
            2. 'Devesha' (The God of Gods): The Supreme Commander ruling all celestial managers.
            3. 'Jagan-nivasa' (The Universal Refuge): The literal 'House' harboring the entire multiverse.
            "Sad-asat-tat-param": Whatever exists as eternal spirit (Sat), whatever decays as temporary matter (Asat), and the absolute, indescribable transcendental reality that exists entirely 'Beyond' both (Akshara)—You, and ONLY YOU (Tvam), are the absolute total sum of it all!
        """.trimIndent()
    ),
    Shloka(
        id = 38,
        sanskrit = """
            त्वमादिदेवः पुरुषः पुराणस्त्वमस्य विश्वस्य परं निधानम् |
            वेत्तासि वेद्यं च परं च धाम त्वया ततं विश्वमनन्तरूप || ३८ ||
        """.trimIndent(),
        hindi = """
            आप ही सबसे पहले देव (आदिदेवः) और सबसे प्राचीन (सनातन) परम पुरुष (पुरुषः पुराणः) हैं। आप ही इस संपूर्ण ब्रह्मांड के परम 'निधान' (सबसे बड़े खजाने या आश्रय / परं निधानम्) हैं।
            आप ही सब कुछ जानने वाले (वेत्तासि) हैं, आप ही एकमात्र 'जानने योग्य' (वेद्यं) हैं, और आप ही सबसे परम 'धाम' (Ultimate Abode) हैं। हे अनंत रूप वाले (अनन्तरूप)! आपके ही द्वारा यह संपूर्ण ब्रह्मांड पूरी तरह से 'व्याप्त' (भरा हुआ / ततं) है!
            अर्जुन का यह स्तोत्र (Prayer) एक शिष्य के हृदय की गहराई से निकला हुआ 'परम ज्ञान' है।
            अर्जुन कह रहे हैं कि इस दुनिया में भगवान से पुराना कोई नहीं है ('पुरुषः पुराणः')। जब समय और स्पेस (Time & Space) नहीं थे, तब भी केवल कृष्ण ही मौजूद थे।
            जब दुनिया में प्रलय आता है और सब कुछ मिट जाता है, तो वह सारा का सारा मैटर (Matter) और आत्माएं कहाँ जाती हैं? वे सब भगवान के ही अंदर एक 'खजाने' (Vault / निधानम्) की तरह सुरक्षित हो जाती हैं।
            "वेत्तासि वेद्यं च": भगवान ही इस दुनिया के सबसे बड़े 'ज्ञाता' (Knower / जिन्हें सब कुछ पता है) हैं, और अगर इंसान को कुछ 'जानना' चाहिए (वेद्यं / Knowledge worth knowing), तो वह भी केवल भगवान ही हैं।
            "त्वया ततं विश्वम्": जैसे एक धागा पूरे कपड़े में बुना होता है, वैसे ही यह पूरा ब्रह्मांड भगवान की ही शक्ति से 'बुना हुआ' (ततं) है। भगवान से बाहर इस दुनिया का कोई वजूद ही नहीं है।
        """.trimIndent(),
        english = """
            You are the absolute original, primeval God (Tvam adi-devah), the oldest, highly ancient Supreme Personality (Purushah puranah). You are the ultimate, supreme sanctuary and absolute resting place of this entire manifested cosmic universe (Tvam asya vishvasya param nidhanam).
            You are the ultimate knower of everything (Vettasi), You are the absolute only truth that is worth knowing (Vedyam), and You are the supreme, ultimate transcendental refuge and abode (Param cha dhama). O limitless form (Ananta-rupa)! This entire infinite cosmic manifestation is completely, thoroughly pervaded by You alone (Tvaya tatam vishvam)!
            This spectacular prayer by Arjuna is the absolute, concentrated explosion of 'Supreme Knowledge' erupting from the depths of a perfect disciple's heart.
            Arjuna declares that absolutely nothing in existence is older than God ('Purushah puranah'). Long before the biological invention of Time and Space, Krishna alone existed in the void.
            When the terrifying cosmic Doomsday (Pralaya) strikes and the entire physical multiverse collapses, where exactly does all that matter and trillions of souls go? They are all safely deposited and securely locked directly inside God's body, which acts as the ultimate 'Cosmic Vault' (Nidhanam).
            "Vettasi vedyam cha": God is the absolute supreme 'Knower' (possessing 100% of all quantum data), and if there is absolutely one single subject in the universe that a human MUST research and 'Know' (Vedyam), it is God Himself.
            "Tvaya tatam vishvam": Just as a single continuous thread perfectly weaves an entire massive piece of cloth, this entire infinite multiverse is flawlessly 'Woven and Pervaded' (Tatam) entirely by God's energy. Absolutely zero existence is possible outside of God.
        """.trimIndent()
    ),
    Shloka(
        id = 39,
        sanskrit = """
            वायुर्यमोऽग्निर्वरुणः शशाङ्कः प्रजापतिस्त्वं प्रपितामहश्च |
            नमो नमस्तेऽस्तु सहस्रकृत्वः पुनश्च भूयोऽपि नमो नमस्ते || ३९ ||
        """.trimIndent(),
        hindi = """
            आप ही वायु (हवा के देवता) हैं, यमराज (मौत के देवता) हैं, अग्नि हैं, वरुण (जल के देवता) हैं, शशाङ्क (चंद्रमा) हैं, आप ही प्रजापति (ब्रह्मा जी) हैं, और आप ब्रह्मा जी के भी पिता (प्रपितामहः / परदादा) हैं!
            इसलिए हे भगवान! आपको मेरे हज़ारों-हज़ार बार नमस्कार हो (नमो नमस्तेऽस्तु सहस्रकृत्वः)! और फिर से, बार-बार आपको मेरा नमस्कार हो (पुनश्च भूयोऽपि नमो नमस्ते)!
            अर्जुन का यह श्लोक असीम 'भक्ति और पागलपन' (Overwhelming Ecstasy & Devotion) का प्रतीक है।
            अर्जुन को अब समझ आ गया है कि प्रकृति के जितने भी बड़े-बड़े देवता हैं जो हवा, आग, पानी और यहाँ तक कि मौत (यमराज) को भी कंट्रोल करते हैं... वे सब असल में भगवान की ही अलग-अलग 'ड्रेसेस' (Dresses/रूप) हैं।
            वे कहते हैं कि "आप प्रजापति (ब्रह्मा) भी हैं, और चूँकि आपने ब्रह्मा को पैदा किया है, इसलिए आप हम सबके 'प्रपितामह' (Great-Grandfather / परदादा) हैं!"
            अर्जुन की भावनाएं अब पूरी तरह से बेकाबू हो गई हैं। वे समझ नहीं पा रहे हैं कि वे भगवान की स्तुति कैसे करें। 
            इसलिए वे पागलों की तरह बस ज़मीन पर सिर पटक-पटक कर भगवान को प्रणाम करने लगते हैं। "आपको मेरा एक बार नहीं, हज़ार बार ('सहस्रकृत्वः') नमस्कार हो! और इतना ही नहीं, हज़ार बार के बाद 'फिर से' (पुनश्च) और 'बार-बार' (भूयोऽपि) मैं आपको प्रणाम करता हूँ!" 
            यह एक इंसान के दिल से निकला हुआ वो शुद्ध प्यार है, जहाँ शब्द खत्म हो जाते हैं और केवल 'समर्पण' (Surrender) बाकी रह जाता है।
        """.trimIndent(),
        english = """
            You are the air (Vayuh), You are the supreme controller of death (Yamo), You are the fire (Agnir), You are the lord of the waters (Varunah), and You are the moon (Shashankah)! You are the first living creature, Lord Brahma (Prajapatis), and You are the great-grandfather of all existence (Prapitamahash cha).
            Therefore, I offer my humble, prostrated obeisances unto You a thousand times (Namo namas te 'stu sahasra-kritvah)! And again, and yet again, I repeatedly bow down to offer my absolute obeisances unto You (Punash cha bhuyo 'pi namo namas te)!
            This incredible verse represents the absolute peak of 'Overwhelming Ecstasy and Paralyzing Devotion' inside Arjuna's shattered consciousness.
            Arjuna has completely realized that absolutely all the terrifyingly powerful cosmic Demigods who command the Wind, Fire, Water, and even Death itself (Yamaraja)... are literally just the Supreme Lord operating in different 'Cosmic Costumes' (Forms).
            He declares, "You are Lord Brahma (the creator of humans), and because You directly birthed Brahma, You are officially the absolute 'Prapitamaha' (The Great-Grandfather) of all existence!"
            Arjuna's biological emotions completely overflow and crash. He literally runs out of human vocabulary to glorify God.
            So, in absolute, ecstatic madness, he throws himself onto the dirt and frantically begins bowing down over and over again. "I offer my head to You not once, but a THOUSAND TIMES ('Sahasra-kritvah')! And after those thousand times, I bow 'Again' (Punash cha) and 'Repeatedly' (Bhuyo 'pi) forever!"
            This is the ultimate, raw manifestation of pure, unadulterated Love—when human words permanently expire, and absolutely nothing remains but 100% violent, physical 'Surrender'.
        """.trimIndent()
    ),
    Shloka(
        id = 40,
        sanskrit = """
            नमः पुरस्तादथ पृष्ठतस्ते नमोऽस्तु ते सर्वत एव सर्व |
            अनन्तवीर्यामितविक्रमस्त्वं सर्वं समाप्नोषि ततोऽसि सर्वः || ४० ||
        """.trimIndent(),
        hindi = """
            हे सर्वरूप (सब कुछ आप ही हैं / सर्व)! आपको आगे (सामने) से नमस्कार है (नमः पुरस्तात्), आपको पीछे से भी नमस्कार है (अथ पृष्ठतस्ते), और हे प्रभु, आपको चारों तरफ से (सब ओर से / सर्वत एव) मेरा नमस्कार है!
            हे असीम शक्ति वाले (अनन्तवीर्य)! हे असीम पराक्रम वाले (अमितविक्रम)! आप अपने भीतर इस पूरे ब्रह्मांड को समाए हुए हैं (सर्वं समाप्नोषि), इसलिए वास्तव में आप ही 'सब कुछ' (ततोऽसि सर्वः) हैं!
            अर्जुन का पागलपन (प्रेम में) इस श्लोक में भी जारी है!
            जब इंसान किसी को प्रणाम करता है, तो वह सामने (Front) से करता है। लेकिन अर्जुन जब विश्वरूप को देखते हैं, तो उन्हें समझ नहीं आता कि भगवान का 'सामने का हिस्सा' (Front) कौन सा है और 'पीठ' (Back) कौन सी है, क्योंकि भगवान के मुँह हर दिशा (360 Degree) में हैं!
            इसलिए अर्जुन पागलों की तरह हर दिशा में घूम-घूम कर ज़मीन पर सिर रगड़ते हैं: "हे प्रभु! आपको आगे से प्रणाम, आपको पीछे से प्रणाम, आपको दाएँ-बाएँ ऊपर-नीचे हर तरफ से मेरा दंडवत प्रणाम है!"
            अर्जुन भगवान को दो बहुत बड़े टाइटल देते हैं: 'अनन्तवीर्य' (Infinite Power) और 'अमितविक्रम' (Infinite Bravery)।
            और फिर अर्जुन गीता का सबसे बड़ा 'अद्वैत' (Non-duality) का सिद्धांत बोलते हैं: "सर्वं समाप्नोषि ततोऽसि सर्वः" (चूँकि यह पूरी दुनिया आपके ही अंदर समाई हुई है, इसलिए इस दुनिया में आपके अलावा और कुछ है ही नहीं... आप ही सब कुछ हैं!)
            ईश्वर और ब्रह्मांड अलग-अलग नहीं हैं, ईश्वर ही ब्रह्मांड हैं।
        """.trimIndent(),
        english = """
            O You who are absolutely everything (Sarva)! I offer my humble obeisances unto You from the front (Namah purastad), and I offer them unto You from behind (Atha prishthatas te). O Lord, I offer my obeisances unto You from all sides and every single direction (Namo 'stu te sarvata eva)!
            O You of infinite, limitless power (Ananta-virya), and of boundless, immeasurable force and prowess (Amita-vikramas tvam)! You completely and totally pervade and encompass this entire universe (Sarvam samapnoshi), and therefore You are absolutely EVERYTHING (Tato 'si sarvah)!
            Arjuna's ecstatic, loving madness continues beautifully in this verse!
            Normally, when a human bows down to someone, they face their 'Front'. But when Arjuna stares at the infinite Vishwaroopa, his brain cannot mathematically compute which side is the 'Front' and which is the 'Back', because God's terrifying faces are literally staring at him from every 360-degree angle!
            Therefore, in pure frantic devotion, Arjuna spins around, aggressively slamming his head into the dirt in all directions: "O Lord! I bow to Your front, I bow to Your back, I bow to You from absolutely EVERY SINGLE DIRECTION in the cosmos!"
            Arjuna bestows two staggering titles upon the Lord: 'Ananta-virya' (Infinite Raw Power) and 'Amita-vikrama' (Boundless, Unstoppable Bravery).
            And then, Arjuna delivers the absolute ultimate philosophy of 'Non-Duality' (Advaita): "Sarvam samapnoshi tato 'si sarvah" (Because You completely swallow, pervade, and hold this entire multiverse inside Your body, absolutely nothing exists outside of You... YOU ARE LITERALLY EVERYTHING!)
            God and the universe are absolutely not separate; God IS the universe.
        """.trimIndent()
    ),
    Shloka(
        id = 41,
        sanskrit = """
            सखेति मत्वा प्रसभं यदुक्तं हे कृष्ण हे यादव हे सखेति |
            अजानता महिमानं तवेदं मया प्रमादात्प्रणयेन वापि || ४१ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 41 और 42 एक ही माफीनामा/Apology हैं)
            हे प्रभु! आपके इस असीम प्रभाव और महिमा (महिमानं तवेदं) को बिल्कुल न जानते हुए (अजानता), केवल एक साधारण 'मित्र' (दोस्त / सखा) मानकर (सखेति मत्वा), मैंने पागलपन (प्रमादात्) या अत्यधिक प्यार (प्रणयेन) के कारण...
            आपको हठपूर्वक (बिना रिस्पेक्ट के / प्रसभं) "हे कृष्ण!", "हे यादव!", "हे सखा!"—ऐसा कहकर जो कुछ भी पुकारा है... (माफी अगले श्लोक में)।
            यह भगवद्गीता का सबसे 'इमोशनल' (Emotional) और रुला देने वाला श्लोक है!
            अर्जुन को अब अचानक एक भयंकर 'गिल्ट ट्रिप' (Guilt Trip / पछतावा) हो रहा है। अर्जुन को याद आ रहा है कि पिछले 40 सालों से वे कृष्ण के साथ कैसा बर्ताव करते आए हैं।
            अर्जुन सोच रहे हैं: "हे भगवान! मैंने क्या कर दिया! जो सुप्रीम गॉड (Supreme God) करोड़ों गैलेक्सीज़ को अपने दाँतों के बीच चबा रहा है, उसे मैं पूरी ज़िंदगी एक आम इंसान और अपना 'लंगोटिया यार' समझता रहा!"
            अर्जुन को याद आता है कि उन्होंने प्यार ('प्रणयेन') या कभी-कभी नशे/मस्ती ('प्रमादात्') में आकर भगवान को उनके निकनेम (Nickname) से बुलाया: "अबे ओ कृष्ण!", "अरे ओ यादव!", "सुन मेरे दोस्त!" (हे कृष्ण हे यादव हे सखेति)।
            अर्जुन को अब भयंकर डर और शर्मिंदगी (Embarrassment) महसूस हो रही है कि उन्होंने इस ब्रह्मांड के 'अल्टीमेट बॉस' (Ultimate Boss) की कितनी भारी बेइज़्जती (Disrespect) की है, बिना यह जाने कि वे कौन हैं!
        """.trimIndent(),
        english = """
            (Verses 41 and 42 form a single continuous Apology)
            O Lord! Completely ignorant of Your unimaginable, infinite majesty and cosmic glories (Ajanata mahimanam tavedam), and foolishly thinking of You merely as my ordinary, casual friend (Sakheti matva)...
            I have rashly, presumptuously, and disrespectfully addressed You (Prasabham yad uktam) as "O Krishna," "O Yadava," "O my dear friend" (He Krishna, He Yadava, He Sakheti)—doing so purely out of careless madness (Pramadat) or out of intense, casual love (Pranayena vapi)... (apology continues in the next verse).
            This is undeniably the absolute most 'Emotional', heartbreaking, and deeply relatable human verse in the entire Bhagavad Gita!
            Arjuna is suddenly hit by a massive, paralyzing 'Guilt Trip' (PTSD). His brain violently flashes back to exactly how casually and disrespectfully he has treated Krishna over the last 40 years.
            Arjuna is internally panicking: "Oh my God! What have I done! The Absolute Supreme Creator who is currently chewing up billions of galaxies between His fangs... I treated Him exactly like my ordinary, biological college buddy for my entire life!"
            Arjuna painfully remembers how, driven by toxic casualness ('Pramadat' - madness/carelessness) or overly intimate love ('Pranayena'), he aggressively called the Supreme Lord by cheap, casual nicknames: "Hey Krishna!", "Yo Yadava!", "Listen here, friend!" (He Krishna, He Yadava, He Sakheti).
            Arjuna is utterly suffocating in horrific fear and extreme 'Embarrassment', realizing he has been completely disrespecting the terrifying 'Ultimate Boss' of the multiverse on a daily basis, simply because he was completely ignorant of His true identity!
        """.trimIndent()
    ),
    Shloka(
        id = 42,
        sanskrit = """
            यच्चावहासार्थमसत्कृतोऽसि विहारशय्यासनभोजनेषु |
            एकोऽथवाप्यच्युत तत्समक्षं तत्क्षामये त्वामहमप्रमेयम् || ४२ ||
        """.trimIndent(),
        hindi = """
            और हे अच्युत (श्रीकृष्ण)! हँसी-मज़ाक (मस्ती / अवहासार्थम्) के लिए, खेलते समय (विहार), सोते समय (शय्या), बैठते समय (आसन) या एक साथ खाना खाते समय (भोजनेषु)...
            चाहे अकेले में (एकः), या फिर दूसरे लोगों (दोस्तों) के सामने (तत्समक्षं), मैंने आपका जो भी अपमान (बेइज़्जती / असत्कृतोऽसि) किया है...
            हे अप्रमेय (असीम शक्ति वाले प्रभु)! मैं अपनी उन सारी गलतियों के लिए आपसे हाथ जोड़कर 'क्षमा' (माफी) मांगता हूँ (तत्क्षामये त्वामहमप्रमेयम्)।
            यह अर्जुन का 100% 'अनकंडीशनल अपोलॉजी' (Unconditional Apology / बिना शर्त माफीनामा) है।
            अर्जुन को अपने बचपन और जवानी के सारे 'मस्ती-मज़ाक' याद आ रहे हैं। 
            जब अर्जुन और कृष्ण एक साथ खेलते थे (विहार), एक ही बिस्तर पर सोते थे (शय्या), एक ही सोफे पर बैठते थे (आसन), और एक ही थाली में खाना खाते थे (भोजनेषु), तो अर्जुन ने भगवान को कई बार मज़ाक में गालियां दी होंगी, उन्हें धक्का दिया होगा, या दोस्तों के सामने ('तत्समक्षं') उनका मज़ाक उड़ाया होगा।
            अब जब अर्जुन को कृष्ण की असली 'औकात' (असीम शक्ति / अप्रमेय) का पता चला है, तो अर्जुन की रूह काँप रही है कि "मैंने ब्रह्मांड के मालिक को धक्का दिया था!"
            वे गिड़गिड़ा कर भगवान से कहते हैं: "हे अच्युत! प्लीज़ मेरी उन सारी बेवकूफियों को भूल जाइए। मैंने जो भी आपका अपमान किया है, उसके लिए मैं आपसे दिल से माफी मांगता हूँ। मुझे सज़ा मत दीजिएगा!"
            यह श्लोक दिखाता है कि जब इंसान का अहंकार टूटता है, तो वह कितना विनम्र (Humble) हो जाता है।
        """.trimIndent(),
        english = """
            And O infallible Lord (Achyuta)! For whatever times I have completely disrespected or dishonored You merely for the sake of a joke or cheap humor (Yach chavahasartham asat-krito 'si)...
            while relaxing, playing, resting on the same bed, sitting together, or while eating meals from the same plate (Vihara-shayyasana-bhojaneshu)...
            whether we were entirely alone (Ekah) or in front of other friends and companions (Tat-samaksham)—O immeasurable, limitless Lord (Aprameyam), I violently beg for Your absolute forgiveness for all those offenses (Tat kshamaye tvam aham)!
            This is Arjuna's 100% 'Unconditional, Tearful Apology' to the Supreme Lord.
            Arjuna's brain is flashing back to every single childhood memory and casual hangout. 
            When Arjuna and Krishna hung out and played sports (Vihara), crashed on the exact same bed (Shayya), chilled on the same sofa (Asana), and casually shared food from the exact same plate (Bhojaneshu), Arjuna undoubtedly shoved God, mocked God, and hurled friendly insults at Him for cheap laughs ('Avahasartham'), both privately and aggressively in front of their other friends ('Tat-samaksham').
            Now that Arjuna has visually witnessed Krishna's true, terrifying 'Magnitude' (Aprameyam - The Immeasurable), his soul is violently shaking with the realization: "I literally shoved and mocked the Creator of the Multiverse!"
            He drops to his knees, frantically pleading: "O Achyuta! PLEASE completely forget all my toxic, idiotic behavior. I beg You from the bottom of my soul to forgive every single insult I ever directed at You. Please do not annihilate me!"
            This verse spectacularly demonstrates exactly how incredibly humble a human being becomes when his false ego is entirely shattered by the Truth.
        """.trimIndent()
    ),
    Shloka(
        id = 43,
        sanskrit = """
            पितासि लोकस्य चराचरस्य त्वमस्य पूज्यश्च गुरुर्गरीयान् |
            न त्वत्समोऽस्त्यभ्यधिकः कुतोऽन्यो लोकत्रयेऽप्यप्रतिमप्रभाव || ४३ ||
        """.trimIndent(),
        hindi = """
            हे अप्रतिम प्रभाव वाले (अतुलनीय शक्ति वाले प्रभु)! आप ही इस संपूर्ण चर (चलने वाले) और अचर (न चलने वाले) जगत (ब्रह्मांड) के परम 'पिता' (Father / पितासि) हैं।
            आप ही सबसे बड़े पूजनीय (पूज्यश्च) हैं, और आप ही सबसे महान गुरु (गुरुर्गरीयान्) हैं।
            इन तीनों लोकों (स्वर्ग, पृथ्वी, पाताल) में आपके 'समान' (बराबरी का / त्वत्समो) भी कोई दूसरा नहीं है, तो फिर आपसे 'अधिक' (बड़ा / अभ्यधिकः) तो कोई हो ही कैसे सकता है (कुतोऽन्यो)?
            माफी मांगने के बाद, अर्जुन अब भगवान की उस परम सत्ता (Ultimate Supremacy) को एक 'लॉजिकल डिक्लेरेशन' (Logical Declaration) के रूप में स्वीकार कर रहे हैं।
            अर्जुन कहते हैं कि इस ब्रह्मांड में जो कुछ भी जिंदा या मुर्दा (चर-अचर) है, उसे पैदा करने वाले साक्षात् 'परमपिता' केवल आप ही हैं।
            दुनिया में बहुत से गुरु और पूजनीय लोग (जैसे द्रोणाचार्य या भीष्म) हैं, लेकिन अर्जुन कहते हैं कि "आप गुरुओं के भी गुरु हैं ('गुरुर्गरीयान्'), यानी इस दुनिया का सारा ज्ञान केवल आपसे ही निकला है।"
            अर्जुन का लॉजिक (Logic) बहुत शानदार है: "हे प्रभु! जब पूरे ब्रह्मांड में आपकी 'टक्कर' (बराबरी / Equal) का ही कोई इंसान या देवता मौजूद नहीं है, तो फिर आपसे 'बड़ा' या 'पावरफुल' (Greater/अभ्यधिकः) तो कोई सपने में भी नहीं हो सकता!"
            अर्जुन ने अब 100% मान लिया है कि श्रीकृष्ण ही 'द अल्टीमेट सुप्रीम बीइंग' (The Ultimate Supreme Being) हैं, जिनके ऊपर कोई सत्ता है ही नहीं।
        """.trimIndent(),
        english = """
            O Lord of completely immeasurable, unparalleled, and incomprehensible power (Apratima-prabhava)! You are the absolute original Father of this entire complete cosmic manifestation, including all moving and non-moving beings (Pitasi lokasya characharasya).
            You are its absolute supreme object of worship (Pujyash cha), and You are the most highly glorious, supreme spiritual master (Gurur gariyan).
            No one in all the three planetary systems is even microscopically equal to You (Na tvat-samo 'sti). How then could absolutely anyone possibly be greater than You (Abhyadhikah kuto 'nyo loka-traye 'pi)?
            Having intensely begged for forgiveness, Arjuna now officially stamps a 'Logical Declaration' establishing God's Ultimate Supremacy.
            Arjuna declares that whatever is biologically alive (moving) or completely dead matter (non-moving) in this matrix, You are the literal, original 'Supreme Father' who engineered and birthed it all.
            There are many highly respected earthly Gurus (like Drona) and worshipable elders, but Arjuna violently overrides them all: "You are the Guru of all Gurus ('Gurur gariyan'). Absolutely 100% of all universal knowledge leaked strictly from Your brain alone."
            Arjuna drops flawlessly sharp logic: "O Lord! When there is absolutely no entity, demigod, or force in the entire multiverse that is even mathematically 'Equal' (Samo) to You, how on earth could anyone even hallucinate about being 'Greater' (Abhyadhikah) or more powerful than You?"
            Arjuna has now officially, 100% permanently verified that Sri Krishna is 'The Ultimate Supreme Being'; there is absolutely no authority existing above Him.
        """.trimIndent()
    ),
    Shloka(
        id = 44,
        sanskrit = """
            तस्मात्प्रणम्य प्रणिधाय कायं प्रसादये त्वामहमीशमीड्यम् |
            पितेव पुत्रस्य सखेव सख्युः प्रियः प्रियायार्हसि देव सोढुम् || ४४ ||
        """.trimIndent(),
        hindi = """
            इसलिए हे प्रभु! मैं अपने इस शरीर को आपके सामने पूरी तरह झुकाकर (प्रणिधाय कायं) और आपको दंडवत प्रणाम करके (प्रणम्य), आप परम पूजनीय (ईड्यम्) और परमेश्वर (ईशम्) को प्रसन्न (प्रसादये) कर रहा हूँ (आपसे दया की भीख मांग रहा हूँ)।
            हे देव! जिस प्रकार एक पिता अपने पुत्र के (अपराधों को), एक मित्र अपने मित्र के (मज़ाक को), और एक प्रेमी अपनी प्रेमिका के (अपराधों को) सह लेता है (माफ़ कर देता है)...
            उसी प्रकार आप भी कृपा करके मेरे सभी अपराधों को सहने (क्षमा करने / सोढुम्) की कृपा करें!
            यह एक भक्त की तरफ से 'अल्टीमेट सरेंडर' (Ultimate Surrender) का सबसे खूबसूरत श्लोक है।
            अर्जुन का अहंकार अब धूल में मिल चुका है। वे केवल हाथ नहीं जोड़ते; वे अपना पूरा शरीर (कायं) भगवान के चरणों में ज़मीन पर गिरा देते हैं (साष्टांग दंडवत प्रणाम करते हैं)। 
            अर्जुन भगवान से 3 बहुत ही इमोशनल (Emotional) उदाहरण देकर माफी मांगते हैं:
            १. "जैसे एक पिता अपने छोटे बच्चे की बदतमीज़ी को माफ़ कर देता है, वैसे ही आप मेरे पिता हैं, मुझे बच्चा समझ कर माफ़ कर दीजिए।"
            २. "जैसे एक पक्का दोस्त अपने दोस्त के भद्दे मज़ाक और गालियों का बुरा नहीं मानता, वैसे ही आप मेरे दोस्त हैं, मेरी बातों को माफ़ कर दीजिए।"
            ३. "जैसे एक पति अपनी पत्नी की हर गलती को प्यार से इग्नोर (Ignore) कर देता है, वैसे ही आप मुझे प्यार से माफ़ कर दीजिए।"
            अर्जुन कह रहे हैं कि "भले ही आप ब्रह्मांड के सबसे डरावने परमेश्वर हैं, लेकिन मेरा आपके साथ जो पर्सनल (Personal) रिश्ता है, उस रिश्ते की खातिर मुझे माफ़ कर दीजिए।" यह भक्ति की सबसे गहरी स्टेज (Stage) है।
        """.trimIndent(),
        english = """
            Therefore, O Supreme Lord, bowing down and completely falling flat to violently prostrate my entire physical body before You (Ttasmat pranamya pranidhaya kayam), I desperately beg Your supreme mercy and seek to please You (Prasadaye tvam aham), the most worshipable Supreme Lord (Isham idyam).
            O Lord God (Deva)! Just as a loving father tolerates the impudence of his son (Piteva putrasya), just as a best friend tolerates the casual insults of a friend (Sakheva sakhyuh)...
            and just as a deeply loving husband completely forgives the offenses of his beloved wife (Priyah priyayah), please, I beg You, gracefully tolerate and entirely forgive all my massive wrongs and offenses (Arhasi devha sodhum)!
            This is the absolute most breathtakingly beautiful verse of 'Ultimate Physical and Emotional Surrender' from a devotee.
            Arjuna's toxic warrior ego has been ground into microscopic dust. He doesn't just politely fold his hands; he violently throws his entire physical biological body ('Kayam') flat onto the dirt, executing a full 'Sashtanga Dandavat' (Prostration) directly at God's lotus feet.
            Arjuna desperately begs for forgiveness using 3 highly emotional, tear-jerking, human analogies:
            1. "Just as a powerful father completely ignores and forgives the arrogant tantrums of his tiny toddler, You are my Supreme Father; please forgive my childish stupidity."
            2. "Just as an absolute best friend never takes the vulgar jokes or casual insults of his buddy seriously, You are my eternal friend; please forgive my casualness."
            3. "Just as a profoundly loving husband unconditionally forgives every single mistake of his beloved wife, please lovingly forgive my massive offenses."
            Arjuna is pleading: "Even though You are the terrifying, apocalyptic Creator of the cosmos, please look at the intensely 'Personal' relationship we share, and out of that pure love, spare me!" This is the deepest, rawest altitude of Bhakti.
        """.trimIndent()
    ),
    Shloka(
        id = 45,
        sanskrit = """
            अदृष्टपूर्वं हृषितोऽस्मि दृष्ट्वा भयेन च प्रव्यथितं मनो मे |
            तदेव मे दर्शय देव रूपं प्रसीद देवेश जगन्निवास || ४५ ||
        """.trimIndent(),
        hindi = """
            हे प्रभु! जो रूप पहले कभी किसी ने नहीं देखा था (अदृष्टपूर्वम्), आपके उस अद्भुत विश्वरूप को देखकर मैं बहुत ज्यादा खुश और रोमांचित (हृषितोऽस्मि) हूँ...
            परंतु साथ ही, अत्यधिक डर (भयेन) के कारण मेरा मन बहुत बुरी तरह से काँप रहा है और व्यथित (घबराया हुआ / प्रव्यथितं) है!
            इसलिए हे देव! हे देवेश! हे जगन्निवास! आप मुझ पर प्रसन्न हों (प्रसीद), और कृपा करके मुझे अपना वही पुराना (सौम्य / 4-भुजाओं वाला विष्णु) रूप ही दिखाइए (तदेव मे दर्शय देव रूपं)।
            अर्जुन की हालत एक छोटे बच्चे की तरह हो गई है जिसे बहुत ज़बरदस्त 'रोलर-कोस्टर' (Roller-coaster) पर बिठा दिया गया हो!
            अर्जुन बहुत ईमानदारी (Honesty) से भगवान को अपनी दोनों (Mixed) फीलिंग्स (Feelings) बता रहे हैं।
            एक तरफ अर्जुन बहुत ज्यादा एक्साइटेड (Excited) और खुश (हृषित) हैं, क्योंकि उन्हें ब्रह्मांड का वह वीआईपी 'विश्वरूप' देखने को मिला जो आज तक दुनिया में किसी को नहीं दिखा था। यह उनके लिए सबसे बड़ा 'अचीवमेंट' (Achievement) है।
            लेकिन दूसरी तरफ, अर्जुन का इंसानी दिमाग उस रूप की 'टेरर' (Terror/खौफ) को बर्दाश्त नहीं कर पा रहा है। उनका मन डर के मारे बुरी तरह 'शॉर्ट-सर्किट' (Short-circuit / प्रव्यथितं) हो चुका है।
            इसलिए अर्जुन हाथ जोड़कर रिक्वेस्ट (Request) करते हैं: "हे प्रभु! मैंने आपकी ताकत देख ली! मेरा शक दूर हो गया! अब प्लीज़ (Please) इस डरावने 'हॉरर-शो' (Horror-show) को बंद कीजिए! मुझे आपका यह उग्र रूप नहीं देखना, मुझे वही आपका पुराना, शांत, और प्यार करने वाला रूप देखना है।" 
            भगवान का उग्र रूप इंसान के लिए बहुत डरावना होता है, इसलिए भक्त हमेशा भगवान के 'शांत' (सुंदर) रूप की ही पूजा करना चाहते हैं।
        """.trimIndent(),
        english = """
            O Lord! After seeing this terrifying, magnificent universal form which I have absolutely never seen before (Adrishta-purvam), I am overwhelmingly gladdened and thrilled with ecstasy (Hrishito 'smi drishtva)...
            but at the exact same time, my fragile mind is completely violently disturbed, panicking, and trembling with sheer, absolute terror (Bhayena cha pravyathitam mano me)!
            Therefore, O Supreme God (Deva)! O Lord of lords (Devesha)! O Refuge of the universe (Jagan-nivasa)! Please be merciful to me (Prasida) and gracefully reveal to me once again Your original, soothing, and beautiful form (Tad eva me darshaya deva rupam)!
            Arjuna's psychological state is exactly like a tiny child who just survived the most terrifying, fastest 'Roller-Coaster' in the world!
            Arjuna is acting brutally honest, exposing his heavily 'Mixed Emotions' to the Lord.
            On one side, Arjuna is explosively thrilled, honored, and ecstatic ('Hrishito') because he was officially granted the ultimate VIP cosmic clearance to witness a terrifying manifestation that absolutely no human in history has ever seen. It is his ultimate achievement.
            But on the flip side, Arjuna's limited biological brain is violently melting under the sheer 'Terror' (Bhaya) of this apocalyptic form. His mind is severely short-circuiting and suffering massive panic attacks ('Pravyathitam').
            Therefore, Arjuna desperately begs: "O Supreme Lord! Point taken! I have witnessed Your infinite power! My doubts are 100% annihilated! Now PLEASE, I beg You, instantly shut down this terrifying cosmic 'Horror-Show'! I cannot handle this! Please morph back into Your beautiful, calming, original form."
            The apocalyptic, wrathful form of God is unendurable for a mortal; therefore, pure devotees eternally prefer to worship and interact exclusively with the Lord's sweet, beautiful, and loving personal form.
        """.trimIndent()
    ),
    Shloka(
        id = 46,
        sanskrit = """
            किरीटिनं गदिनं चक्रहस्तमिच्छामि त्वां द्रष्टुमहं तथैव |
            तेनैव रूपेण चतुर्भुजेन सहस्रबाहो भव विश्वमूर्ते || ४६ ||
        """.trimIndent(),
        hindi = """
            हे सहस्रबाहु (हज़ारों भुजाओं वाले)! हे विश्वमूर्ते (पूरे ब्रह्मांड का रूप धारण करने वाले)! मैं आपको उसी प्रकार मुकुट पहने हुए (किरीटिनं), गदा धारण किए हुए (गदिनं), और हाथ में चक्र लिए हुए (चक्रहस्तम्) देखना चाहता हूँ (इच्छामि)।
            इसलिए, कृपा करके आप अपने उसी 'चार भुजाओं वाले' (चतुर्भुजेन) रूप (विष्णु रूप) में दोबारा प्रकट हो जाइए (तेनैव रूपेण भव)।
            अर्जुन अब भगवान को 'एग्ज़ैक्ट इंस्ट्रक्शन्स' (Exact Instructions / स्पष्ट निर्देश) दे रहे हैं कि उन्हें भगवान का कौन सा रूप देखना है!
            अभी भगवान के करोड़ों हाथ और करोड़ों डरावने मुँह हैं (सहस्रबाहो विश्वमूर्ते)। अर्जुन इस 'मल्टी-डायमेंशनल' (Multi-dimensional) रूप से इतना डर गए हैं कि वे भगवान से इसे तुरंत 'डाउनग्रेड' (Downgrade) करने की प्रार्थना करते हैं।
            अर्जुन कहते हैं, "मुझे यह हज़ारों हाथों वाला खौफनाक रूप नहीं देखना! मुझे आपका वह सुंदर और शांत 'विष्णु' रूप देखना है।"
            कैसा रूप? जिसके सिर पर एक सुंदर 'मुकुट' हो, जिसके चार हाथ हों ('चतुर्भुजेन'), और जिसने अपने हाथों में शंख, 'गदा', और 'चक्र' पकड़ा हो।
            यह श्लोक साबित करता है कि अर्जुन को पता था कि कृष्ण कोई साधारण इंसान नहीं हैं। कृष्ण के अंदर ही 'विष्णु' का 4-हाथों वाला रूप भी है, और कृष्ण के अंदर ही यह 'विश्वरूप' भी है। 
            अर्जुन 'ईश्वर के ऐश्वर्य' (विश्वरूप) से घबराकर 'ईश्वर के शांत स्वरूप' (विष्णु/कृष्ण) की शरण में वापस जाना चाहते हैं।
        """.trimIndent(),
        english = """
            O Lord of a thousand terrifying arms (Sahasra-baho)! O Universal Form (Vishva-murte)! I eagerly wish to see You exactly as before (Icchami tvam drashtum aham tathaiva), crowned perfectly (Kiritinam), and holding Your massive mace (Gadinam) and glowing disc in Your hands (Chakra-hastam).
            Therefore, I beg You, please gracefully morph back and manifest Yourself once again in that exact same beautiful, calming, four-armed form (Tenaiva rupena chatur-bhujena bhava)!
            Arjuna is now issuing highly specific, 'Exact Instructions' to the Supreme Lord regarding exactly which visual form his human brain desperately wants to see!
            Currently, the Lord is manifesting with billions of terrifying, flailing arms and roaring mouths (Sahasra-baho). Arjuna is so violently traumatized by this 'Multi-Dimensional' horror that he desperately begs the Lord to instantly 'Downgrade' the manifestation.
            Arjuna pleads: "I absolutely do not want to see this apocalyptic, thousand-armed monster! I desperately want to see Your beautifully majestic, calming, and serene 'Vishnu' form."
            What exact form? The one flawlessly adorned with a beautiful royal 'Crown', possessing exactly 'Four Arms' (Chatur-bhujena), gracefully holding the glowing conch, 'Mace', and the spinning 'Disc' (Chakra).
            This spectacular verse officially proves that Arjuna perfectly knew Krishna was absolutely not an ordinary biological human. Krishna is the original source from whom both the 4-armed 'Vishnu' form and this infinite 'Universal Form' manifest.
            Terrified by the crushing 'Opulence and Wrath' of God, the pure devotee always desperately runs back to take shelter in the 'Sweet, Beautiful, and Loving' original form of God.
        """.trimIndent()
    ),
    Shloka(
        id = 47,
        sanskrit = """
            श्रीभगवानुवाच |
            मया प्रसन्नेन तवार्जुनेदं रूपं परं दर्शितमात्मयोगात् |
            तेजोमयं विश्वमनन्तमाद्यं यन्मे त्वदन्येन न दृष्टपूर्वम् || ४७ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे अर्जुन! मैंने तुम्हारे ऊपर अत्यंत प्रसन्न होकर (मया प्रसन्नेन), अपनी 'आत्मयोग' (योगमाया / अचिंत्य शक्ति) के प्रभाव से यह अपना 'परम रूप' (Supreme Form / रूपं परं) तुम्हें दिखाया है (दर्शितम्)।
            मेरा यह विश्वरूप अत्यंत तेजोमय (करोड़ों सूर्यों की चमक वाला / तेजोमयं), संपूर्ण विश्व को समाए हुए (विश्वम्), अनंत (जिसका कोई अंत नहीं / अनन्तम्), और सबसे आदि (सबसे पुराना / आद्यम्) है। 
            मेरे इस भयंकर रूप को तुम्हारे सिवा पहले कभी किसी और इंसान ने नहीं देखा है (यन्मे त्वदन्येन न दृष्टपूर्वम्)।
            भगवान श्रीकृष्ण यहाँ अर्जुन के डर को कम करते हुए उन्हें 'कम्फर्ट' (Comfort) दे रहे हैं और बता रहे हैं कि अर्जुन ने जो देखा है, वह कितनी बड़ी 'एक्सक्लूसिव' (Exclusive / VIP) चीज़ थी!
            भगवान कहते हैं, "अर्जुन, तुम डर क्यों रहे हो? मैंने यह रूप तुम्हें डराने के लिए नहीं, बल्कि तुम्हारे प्यार से खुश होकर (प्रसन्नेन) एक 'स्पेशल गिफ्ट' (Special Gift) के तौर पर दिखाया है!"
            यह रूप भगवान ने किसी मैजिक-ट्रिक (Magic-trick) से नहीं, बल्कि अपनी सुप्रीम पावर 'आत्मयोगात्' (Personal Mystic Power) से प्रकट किया था।
            इस रूप की 4 सबसे भयंकर क्वालिटीज़ (Qualities) हैं: 1. तेजोमय (Blinding radiation), 2. विश्वम् (Containing the multiverse), 3. अनन्तम् (Infinite), 4. आद्यम् (Existing before time).
            और सबसे बड़ा 'प्रिविलेज' (Privilege) क्या है? भगवान कहते हैं, "पूरी मानव जाति के इतिहास में, तुम्हारे अलावा (त्वदन्येन) यह सुप्रीम 3D शो आज तक किसी ने भी लाइव (Live) नहीं देखा है!" यह अर्जुन के लिए भगवान का सबसे बड़ा आशीर्वाद और सम्मान था।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead gently said: My dear Arjuna, being exceptionally pleased with you (Maya prasannena), by My own internal mystic power (Atma-yogat), I have happily shown you this absolute, supreme universal form (Rupam param darshitam).
            This specific form is blindingly brilliant and full of glowing effulgence (Tejomayam), it is the entire limitless universe (Vishvam), it is mathematically infinite (Anantam), and it is the primeval, original form (Adyam).
            Understand clearly that absolutely no human being before you has ever seen this staggering form (Yan me tvad-anyena na drishta-purvam).
            Lord Sri Krishna is actively calming Arjuna's violent panic attack here, deeply comforting him while simultaneously explaining the unimaginably 'Exclusive VIP' nature of the cosmic show he just survived!
            The Lord reassures him: "Arjuna, why are you screaming in terror? I absolutely did not manifest this form to torture or terrify you. I revealed it purely because I am exceptionally 'Pleased' (Prasannena) with your pure love, presenting it as a highly classified 'Special Gift'!"
            The Lord did not use cheap earthly magic; He deployed His absolute, supreme internal software ('Atma-yogat' / Personal Mystic Power) to execute this projection.
            This form has 4 terrifyingly majestic qualities: 1. Tejomayam (Blindingly radioactive), 2. Vishvam (Encompassing the entire multiverse), 3. Anantam (Geometrically infinite), 4. Adyam (Existing before the Big Bang).
            And what is the absolute highest 'Privilege'? The Lord declares: "In the entire recorded history of the human race, absolutely NO ONE other than you ('Tvad-anyena') has ever been granted the security clearance to watch this Supreme 3D Show Live!" This was God's ultimate badge of honor for Arjuna.
        """.trimIndent()
    ),
    Shloka(
        id = 48,
        sanskrit = """
            न वेदयज्ञाध्ययनैर्न दानैर्न च क्रियाभिर्न तपोभिरुग्रैः |
            एवंरूपः शक्य अहं नृलोके द्रष्टुं त्वदन्येन कुरुप्रवीर || ४८ ||
        """.trimIndent(),
        hindi = """
            हे कुरुवीरों में श्रेष्ठ (कुरुप्रवीर)! इस मनुष्य लोक (पृथ्वी) में, तुम्हारे अलावा (त्वदन्येन) किसी और के द्वारा मुझे इस 'विश्वरूप' (एवंरूपः) में देखा जाना बिल्कुल भी संभव (शक्य) नहीं है।
            न तो वेदों के बहुत अधिक अध्ययन (पढ़ने) से, न बड़े-बड़े यज्ञों से, न करोड़ों के दान से, न किसी भी प्रकार के भारी कर्मकांडों (क्रियाओं) से, और न ही भयंकर और उग्र तपस्याओं (तपोभिरुग्रैः) से ही मेरा यह रूप देखा जा सकता है!
            भगवान श्रीकृष्ण यहाँ दुनिया के सारे घमंडी पंडितों, दानवीरों और तपस्वियों का 'ईगो' (Ego) हमेशा के लिए ज़ीरो (Zero) कर रहे हैं!
            इंसान सोचता है कि "मैं 20 साल तक हिमालय में नंगे पैर बर्फ पर तपस्या (उग्र तप) करूँगा, तो भगवान मुझे दर्शन दे देंगे।" या "मैं करोड़ों रुपए दान करूँगा, तो भगवान मुझे मिल जाएंगे।"
            श्रीकृष्ण इस 'बिज़नेस-मॉडल' (Business Model) को 100% रिजेक्ट (Reject) कर देते हैं!
            भगवान एक बहुत ही कड़ा 'रूल' (Rule) बताते हैं: इस भौतिक दुनिया (नृलोके) में, तुम चाहे कितनी भी मोटी किताबें (वेद) पढ़ लो, कितना भी भारी 'यज्ञ' कर लो, या अपने शरीर को आग में तपा लो... इस 'मैकेनिकल मेहनत' (Mechanical efforts) के दम पर तुम मेरे इस 'परम विश्वरूप' को 1% भी नहीं देख सकते! 
            भगवान की यह 3D कॉस्मिक मूवी (Cosmic Movie) किसी भी 'टिकट' (पैसे या पुण्य) से नहीं खरीदी जा सकती।
            यह रूप केवल 'अर्जुन' (तुम्हारे अलावा कोई नहीं) देख पाया, क्योंकि अर्जुन के पास दुनिया की सबसे बड़ी और इकलौती क्वालिफिकेशन (Qualification) थी: 'भगवान से अनकंडीशनल प्यार (भक्ति)'। ईश्वर केवल प्रेम से बिकते हैं, तपस्या या दान से नहीं।
        """.trimIndent(),
        english = """
            O absolute best of the Kuru warriors (Kuru-pravira)! In this entire material human world (Nri-loke), absolutely no one other than you (Tvad-anyena) can possibly see Me in this terrifying universal form (Evam-rupah shakya aham drashtum).
            This form cannot be seen by aggressively studying the massive Vedas, nor by executing huge sacrifices (Na veda-yajnadhayanair), nor by immense charity (Na danair), nor by complex pious activities (Na cha kriyabhir), nor by undergoing the most severe, brutal austerities (Na tapobhir ugraih).
            Lord Sri Krishna is violently crashing the massive, bloated 'Egos' of all the world's greatest scholars, billionaires, and hardcore ascetics to absolute Zero here!
            Ignorant mortals arrogantly strategize: "I will brutally torture my body standing barefoot in freezing Himalayan snow for 20 years (Ugra-tapasya), and God will be forced to show Himself to me." Or "I will donate billions to charity, and I will buy a vision of God."
            Sri Krishna 100% ruthlessly rejects this pathetic 'Business Model' of spirituality!
            The Lord establishes an impenetrable cosmic 'Rule': In this biological matrix (Nri-loke), no matter how many massive libraries of Vedic textbooks you memorize, no matter how many explosive fire-sacrifices you fund, or how violently you torture your physical body... all these 'Mechanical Efforts' will absolutely NEVER hack the system to grant you a vision of My 'Supreme Universal Form'!
            God's ultimate 3D Cosmic Movie absolutely cannot be purchased with the 'Tickets' of money, PhDs, or pious karma.
            This horrific form was revealed exclusively to 'Arjuna' (no one else) simply because Arjuna possessed the absolute only valid Cosmic Qualification: '100% Unconditional Love and Pure Devotion (Bhakti)'. God is sold exclusively to Love, never to mechanical rituals or charity.
        """.trimIndent()
    ),
    Shloka(
        id = 49,
        sanskrit = """
            मा ते व्यथा मा च विमूढभावो दृष्ट्वा रूपं घोरमीदृङ्ममेदम् |
            व्यपेतभीः प्रीतमनाः पुनस्त्वं तदेव मे रूपमिदं प्रपश्य || ४९ ||
        """.trimIndent(),
        hindi = """
            मेरे इस प्रकार के अत्यंत भयंकर और डरावने (घोरम्) रूप को देखकर, तुम्हें न तो कोई घबराहट या डर (व्यथा) होना चाहिए, और न ही तुम्हारी बुद्धि भ्रमित (विमूढभावो / Confuse) होनी चाहिए।
            अब तुम अपने सारे डरों से पूरी तरह मुक्त होकर (व्यपेतभीः) और अत्यंत प्रसन्न और शांत मन से (प्रीतमनाः), दोबारा (पुनः) मेरे उसी पुराने (शंख-चक्र वाले 4-हाथों के विष्णु) रूप को अच्छी तरह से देखो (तदेव मे रूपमिदं प्रपश्य)।
            यहाँ भगवान श्रीकृष्ण एक अत्यंत ही दयालु पिता या 'बेस्ट फ्रेंड' (Best Friend) की तरह व्यवहार कर रहे हैं जो अपने डरे हुए दोस्त को शांत कर रहा है।
            भगवान अर्जुन की 'हार्ट-बीट' (Heartbeat) को नॉर्मल (Normal) कर रहे हैं। वे कहते हैं: "अर्जुन! मुझे पता है कि मेरा यह उग्र रूप बहुत 'घोर' (Horrifying/भयंकर) है, लेकिन तुम्हें इससे डरने ('व्यथा') या कंफ्यूज़ ('विमूढ') होने की कोई ज़रूरत नहीं है। क्योंकि यह भयंकर रूप तुम्हारे दुश्मनों (कौरवों) को खाने के लिए है, तुम्हें डराने के लिए नहीं!"
            भगवान अर्जुन को 'रिलैक्स' (Relax) होने का सीधा ऑर्डर (Order) देते हैं: "व्यपेतभीः" (अपना सारा डर अपने दिमाग से निकाल फेंको!) और "प्रीतमनाः" (अपने दिल को खुश और शांत कर लो)।
            और जैसे ही अर्जुन अपनी आँखें बंद करके दोबारा खोलते हैं, वह भयंकर करोड़ों मुँह वाला 'हॉरर-शो' (Horror-show) गायब हो चुका है। उसकी जगह भगवान अपने 'ओरिजिनल' (Original), अत्यंत सुंदर और शांत 'चतुर्भुज' (Four-armed Vishnu) रूप में अर्जुन के सामने खड़े हैं। भगवान ने अपने भक्त की खुशी के लिए अपना अलार्म (Alarm) बंद कर दिया!
        """.trimIndent(),
        english = """
            You should absolutely not be terrified or excessively disturbed (Ma te vyatha), nor should your mind be bewildered and hallucinating (Ma cha vimudha-bhavo), upon seeing this horribly terrifying, apocalyptic form of Mine (Drishtva rupam ghoram idrin mamedam).
            Now, completely freeing yourself from all traces of panic and fear (Vyapeta-bhih), and with a profoundly cheerful, happy, and peaceful mind (Prita-manah), behold once again (Punah) this original, beautiful form of Mine exactly as you desire (Tad eva me rupam idam prapashya).
            Here, Lord Sri Krishna operates exactly like an unimaginably compassionate Father or an absolute 'Best Friend', desperately trying to calm down his violently traumatized buddy.
            The Lord is actively normalizing Arjuna's skyrocketing, panicked 'Heartbeat'. He gently consoles: "Arjuna! I perfectly know this cosmic form is incredibly 'Ghoram' (Horrifyingly graphic and terrifying), but you absolutely do not need to suffer from PTSD ('Vyatha') or massive mental confusion ('Vimudha'). This monstrous form is explicitly engineered to chew up your toxic enemies (the Kauravas), not to harm you!"
            The Lord issues a direct psychological command to 'Relax': "Vyapeta-bhih" (Violently eject all residual panic and terror out of your brain!) and "Prita-manah" (Force your heart to become instantly cheerful and profoundly peaceful).
            And the exact microsecond Arjuna blinks and re-opens his eyes, the apocalyptic, billion-mouthed 'Horror-Show' is completely uninstalled and deleted. In its place stands the Supreme Lord in His 'Original', mesmerizingly beautiful, and deeply calming 'Four-Armed Vishnu' form. The Lord completely shut down His apocalyptic alarm system purely for His devotee's comfort!
        """.trimIndent()
    ),
    Shloka(
        id = 50,
        sanskrit = """
            सञ्जय उवाच |
            इत्यर्जुनं वासुदेवस्तथोक्त्वा स्वकं रूपं दर्शयामास भूयः |
            आश्वासयामास च भीतमेनं भूत्वा पुनः सौम्यवपुर्महात्मा || ५० ||
        """.trimIndent(),
        hindi = """
            संजय ने धृतराष्ट्र से कहा: भगवान वासुदेव (श्रीकृष्ण) ने अर्जुन से इस प्रकार कहकर (तथोक्त्वा), फिर से (भूयः) अपना वही पुराना (चार भुजाओं वाला) रूप दिखाया (स्वकं रूपं दर्शयामास)।
            और फिर उन महान आत्मा (महात्मा / श्रीकृष्ण) ने दोबारा (पुनः) अपने अत्यंत सुंदर, शांत और मनमोहक मानवीय (दो-भुजाओं वाले) रूप (सौम्यवपुः) को धारण करके, उस बुरी तरह डरे हुए (भीतम्) अर्जुन को पूरी तरह से सांत्वना दी (दिलासा दिया / आश्वासयामास)।
            यहाँ 'कैमरा' (Camera) फिर से संजय पर आता है, जो इस पूरे कॉस्मिक ट्रांज़िशन (Cosmic Transition / रूप बदलने की प्रक्रिया) का 'लाइव' (Live) वर्णन कर रहे हैं।
            यह श्लोक दिखाता है कि भगवान कृष्ण अपने भक्त से कितना प्यार करते हैं। उन्होंने अर्जुन को शांत करने के लिए 'दो बार' (Two times) अपना रूप बदला (Downgrade किया)!
            १. सबसे पहले भगवान ने अपना भयंकर करोड़ों मुँह वाला 'विश्वरूप' समेटा और अपना बहुत ही राजसी (Majestic) 'चतुर्भुज विष्णु रूप' (चार हाथों वाला रूप) दिखाया।
            २. लेकिन अर्जुन तो कृष्ण को अपने 'दोस्त' के रूप में देखना चाहते थे। इसलिए भगवान (महात्मा) ने वह 4-हाथों वाला भगवान का रूप भी हटा दिया, और "भूत्वा पुनः सौम्यवपुः"—यानी वे वापस अपने उसी अत्यंत 'सौम्य' (Beautiful, soft, human-like), दो हाथों वाले प्यारे 'कृष्ण' के रूप में आ गए, जो अर्जुन के साथ रथ चला रहे थे!
            जब अर्जुन ने अपने उसी प्यारे, मुस्कुराते हुए दोस्त (कृष्ण) को वापस देखा, तो उनका सारा 'टेरर' (Terror / भीतम्) खत्म हो गया, और भगवान ने उन्हें गले लगाकर पूरी तरह 'रिलैक्स' (आश्वासयामास) कर दिया।
        """.trimIndent(),
        english = """
            Sanjaya officially reported to Dhritarashtra: The Supreme Lord, Vasudeva, having thus spoken to Arjuna (Ity arjunam vasudevas tathoktva), flawlessly displayed His real, four-armed form once again (Svakam rupam darshayam asa bhuyah).
            And finally, the Great Lord (Mahatma) assumed His exceptionally beautiful, gentle, and highly pacifying two-armed human-like form (Bhutva punah saumya-vapur), completely comforting and reassuring the violently terrified Arjuna (Ashvasayam asa cha bhitam enam).
            Here, the cosmic 'Camera' cuts back to Sanjaya, who is enthusiastically 'Live-Streaming' this staggering, multi-stage 'Cosmic Transition' (Downgrade of Forms) to the blind king.
            This spectacular verse absolutely proves the unfathomable, infinite Love the Supreme Lord holds for His pure devotee. To completely cure Arjuna's panic attack, the Lord executed a massive 'System Downgrade' not once, but 'Twice'!
            1. First, the Lord violently compressed and deleted His apocalyptic, billion-mouthed 'Vishwaroopa', morphing down into His highly majestic, royal, 'Four-Armed Vishnu' form (to show His divine opulence).
            2. But Arjuna desperately missed his sweet, casual 'Best Friend'. Therefore, the Supreme Lord (Mahatma) deactivated even that majestic 4-armed God-form, and "Bhutva punah saumya-vapur"—He morphed back into His exceptionally 'Saumya' (Staggeringly beautiful, soft, approachable, two-armed human-like) original 'Krishna' form, exactly as He was driving the chariot!
            The exact microsecond Arjuna visually locked onto his beloved, smiling best friend (Krishna) again, his absolute 'Terror' (Bhitam) was instantly vaporized. The Lord embraced him, completely 'Reassuring and Comforting' (Ashvasayam asa) His shattered devotee back to 100% sanity.
        """.trimIndent()
    ),
    Shloka(
        id = 51,
        sanskrit = """
            अर्जुन उवाच |
            दृष्ट्वेदं मानुषं रूपं तव सौम्यं जनार्दन |
            इदानीमस्मि संवृत्तः सचेताः प्रकृतिं गतः || ५१ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने (राहत की साँस लेते हुए) कहा: हे जनार्दन (श्रीकृष्ण)! आपके इस अत्यंत ही शांत, कोमल और सुंदर (सौम्यं) मनुष्य रूप (मानुषं रूपं) को देखकर...
            अब (इदानीम्) मैं बिल्कुल शांत हो गया हूँ, मेरे मन का सारा संतुलन वापस आ गया है (संवृत्तः सचेताः), और मैं पूरी तरह से अपनी पुरानी और नॉर्मल अवस्था (प्रकृतिं गतः) में लौट आया हूँ!
            यह श्लोक अर्जुन की 'नॉर्मलसी' (Normalcy / रिकवरी) का ऐलान है।
            कल्पना कीजिए कि कोई इंसान एक भयंकर और खौफनाक रोलर-कोस्टर (Roller-coaster) से उतरा हो; उसकी हालत कैसी होगी? अर्जुन की हालत बिल्कुल वैसी ही थी।
            लेकिन जैसे ही उन्होंने वापस अपने प्यारे 2-हाथों वाले भगवान कृष्ण को देखा (जिन्हें वे अपना भाई और सखा मानते थे), उनकी जान में जान आ गई।
            अर्जुन भगवान को 'जनार्दन' (भक्तों को शांति देने वाले) कहकर पुकारते हैं। वे कहते हैं: "दृष्ट्वेदं मानुषं रूपं तव सौम्यं" (आपके इस 'मानव रूप' की कोमलता और सुंदरता ने मेरे दिमाग का सारा डर धो दिया है)।
            "सचेताः प्रकृतिं गतः": यानी मेरा जो दिमाग अभी कुछ सेकंड पहले 'क्रैश' (Crash / शॉर्ट-सर्किट) हो गया था, वह अब 100% 'रिबूट' (Reboot) हो गया है। मेरा नर्वस सिस्टम (Nervous System) शांत हो गया है, और मैं वापस अपनी 'नॉर्मल' (Natural) दिमागी हालत में आ गया हूँ।
            इससे यह भी साबित होता है कि भगवान का 'दो-हाथों वाला कृष्ण रूप' उनके उस भयंकर 'विश्वरूप' से कहीं ज़्यादा प्यारा, महान और भक्तों को सुख देने वाला (Ultimate Form) है।
        """.trimIndent(),
        english = """
            Arjuna, breathing a massive sigh of relief, said: O Janardana (Krishna)! Seeing this exceptionally beautiful, incredibly gentle, and highly pacifying human-like form of Yours (Drishtvedam manusham rupam tava saumyam)...
            my mind is now completely pacified and my sanity is fully restored (Idanim asmi samvrittah sa-chetah), and I am restored to my absolute normal, original nature (Prakritim gatah).
            This specific verse is Arjuna's official declaration of achieving 100% 'Biological Normalcy and Psychological Recovery'.
            Imagine a human stepping off the most terrifying, death-defying, multi-dimensional 'Roller-Coaster' in the universe; what would his biological state be? Arjuna was exactly in that shattered condition.
            But the exact microsecond his retinas locked back onto the sweet, beautiful, 2-armed form of Lord Krishna (whom he deeply loved as his cousin and best friend), his biological system instantly stabilized.
            Arjuna addresses the Lord as 'Janardana' (the pacifier of devotees). He passionately declares: "Drishtvedam manusham rupam tava saumyam" (The sheer gentle, magnetic beauty of this specific 'Human-like Form' has violently flushed every microscopic drop of terror out of my brain).
            "Sa-chetah prakritim gatah": Meaning, my psychological software, which had completely crashed and 'Short-Circuited' just a few seconds ago, has now flawlessly 'Rebooted' to 100%. My biological nervous system is entirely pacified, and I have officially returned to my 'Normal', original baseline state of mind.
            This spectacularly proves a massive cosmic truth: The Lord's 'Two-armed Krishna form' is infinitely sweeter, more intimate, and ultimately vastly superior to His terrifying, mechanical 'Universal Form' when it comes to experiencing pure devotion.
        """.trimIndent()
    ),
    Shloka(
        id = 52,
        sanskrit = """
            श्रीभगवानुवाच |
            सुदुर्दर्शमिदं रूपं दृष्टवानसि यन्मम |
            देवा अप्यस्य रूपस्य नित्यं दर्शनकाङ्क्षिणः || ५२ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: तुमने मेरा यह जो रूप (विश्वरूप / 4-भुजाओं वाला रूप) अभी-अभी देखा है (दृष्टवानसि यन्मम), इस रूप का दर्शन कर पाना अत्यंत ही दुर्लभ और लगभग असंभव (सुदुर्दर्शम्) है!
            यहाँ तक कि स्वर्ग के बड़े-बड़े देवता (देवा अपि) भी हमेशा (नित्यं) मेरे इस रूप को देखने के लिए तरसते रहते हैं (दर्शनकाङ्क्षिणः / लालायित रहते हैं)।
            अब भगवान अर्जुन को यह समझा रहे हैं कि अर्जुन ने जो अभी 'शो' (Show) देखा है, वह कितनी बड़ी 'वीआईपी चीज़' (VIP Thing) थी!
            भगवान कहते हैं, "अर्जुन, तुमने जो रूप देखा है, वह 'सुदुर्दर्शम्' है।" 'सुदुर्दर्श' का मतलब है जो करोड़ों जन्मों की तपस्या के बाद भी दिखाई न दे।
            हम इंसान सोचते हैं कि अगर हम मरकर 'स्वर्ग' चले गए, तो वहाँ देवता हमें भगवान से मिलवा देंगे। 
            भगवान इस 'मिथ' (Myth) को तोड़ देते हैं! वे कहते हैं कि तुम इंसानों की तो छोड़ो, जो स्वर्ग के 'सुप्रीम मंत्री' (देवता / Brahma, Indra आदि) हैं... वे भी रोज़ ('नित्यं') मेरे इस रूप की एक झलक देखने के लिए पागलों की तरह तरसते ('दर्शनकाङ्क्षिणः') रहते हैं, लेकिन उन्हें भी मैं यह रूप नहीं दिखाता!
            देवता भगवान की शक्ति का इस्तेमाल तो करते हैं, लेकिन वे भगवान के इस साक्षात् रूप को नहीं देख पाते। 
            और वो 'टॉप-सीक्रेट' (Top-Secret) रूप मैंने तुम्हें इतनी आसानी से दिखा दिया! अर्जुन को यह एहसास दिलाया जा रहा है कि उनकी 'भक्ति' (प्यार) ने देवताओं की 'पोजीशन' (Position) को भी हरा दिया है।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead declared: My dear Arjuna, this exact specific form of Mine which you have just now seen (Drishtavan asi yan mama) is exceptionally, staggeringly difficult to behold, and practically impossible to see (Su-durdarsham idam rupam).
            Even the most highly elevated celestial demigods (Deva api) are eternally, constantly yearning, thirsting, and desperately longing just to catch a tiny glimpse of this exact form (Asya rupasya nityam darshana-kankshinah).
            Now, the Lord is heavily emphasizing to Arjuna exactly how unbelievably 'VIP, Classified, and Rare' the cosmic projection he just witnessed actually was!
            The Lord emphatically declares, "Arjuna, the specific form you just laid your eyes upon is 'Su-durdarsham'." This term translates to: absolutely mathematically impossible to see, even after millions of lifetimes of severe austerities.
            Ignorant humans heavily hallucinate that if they simply earn enough karma to immigrate to 'Heaven', the demigods will casually introduce them to God.
            The Lord violently shatters this 'Myth'! He reveals that forget puny humans, even the absolute 'Supreme Ministers' of the multiverse (The Demigods / Devah like Brahma and Indra)... literally spend their entire eternal existence ('Nityam') desperately 'Thirsting, panting, and frantically begging' ('Darshana-kankshinah') just to catch one microscopic, fractional glimpse of this form, yet I strictly deny them!
            The demigods operate God's administrative powers, but they are absolutely blind to His intimate, personal form.
            And yet, I casually unlocked this 'Top-Secret' manifestation for you effortlessly! Arjuna is being made to profoundly realize that his pure 'Bhakti' (Love) has brutally outperformed and defeated the staggering 'Positions' of the highest demigods.
        """.trimIndent()
    ),
    Shloka(
        id = 53,
        sanskrit = """
            नाहं वेदैर्न तपसा न दानेन न चेज्यया |
            शक्य एवंविधो द्रष्टुं दृष्टवानसि मां यथा || ५३ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार (जिस रूप में / यथा) तुमने मुझे अभी साक्षात् देखा है (दृष्टवानसि मां), मुझे इस रूप में (एवंविधो) किसी भी तरीके से देखा जाना संभव (शक्य) नहीं है...
            न तो वेदों के बहुत अध्ययन (पढ़ने) से (नाहं वेदैः), न अत्यंत कठोर तपस्या से (न तपसा), न करोड़ों के भारी दान से (न दानेन), और न ही बड़े-बड़े यज्ञों (कर्मकांडों) के द्वारा ही (न चेज्यया) मैं इस प्रकार देखा जा सकता हूँ!
            यह श्लोक 'आध्यात्मिक अहंकार' (Spiritual Ego) पर सबसे बड़ा हथौड़ा (Hammer) है!
            दुनिया में लोग सोचते हैं कि वे अपने पैसे, अपनी बुद्धि या अपनी शारीरिक ताकत (तपस्या) से भगवान को 'खरीद' लेंगे या मजबूर कर देंगे।
            श्रीकृष्ण एक-एक करके दुनिया के सबसे 'महान और पवित्र' माने जाने वाले 4 रास्तों को 100% रिजेक्ट (Reject / खारिज) कर देते हैं:
            १. 'वेद' (Academic Knowledge): आप पूरी ज़िंदगी संस्कृत की किताबें और वेद रट लें, आप बहुत बड़े स्कॉलर (Scholar) बन जाएंगे, लेकिन आप मुझे नहीं देख सकते।
            २. 'तपस्या' (Physical Torture): आप हिमालय की बर्फ में एक पैर पर 100 साल खड़े रहें, मुझे नहीं देख सकते।
            ३. 'दान' (Wealth/Charity): आप दुनिया के सबसे बड़े अरबपति हों और अपनी सारी संपत्ति गरीबों या मंदिरों में दान कर दें, तो भी आप मेरा दर्शन नहीं खरीद सकते।
            ४. 'इज्यया' (Massive Rituals): आप हजारों पंडितों को बुलाकर करोड़ों रुपयों का 'यज्ञ' करा लें, तो भी मुझे मजबूर नहीं कर सकते।
            भगवान स्पष्ट करते हैं कि ईश्वर कोई 'मशीन' या 'बिज़नेस' (Business) नहीं है जिसमें तुम इन 4 सिक्कों (सिक्कों) को डालोगे और तुम्हें भगवान का दर्शन मिल जाएगा। इन सारे 'मैकेनिकल' (Mechanical) तरीकों से मुझे (मेरे असली रूप को) देखना बिल्कुल 'असंभव' (नाहं शक्य) है!
        """.trimIndent(),
        english = """
            This exact, intimate form of Mine which you have just visually witnessed with your own eyes (Drishtavan asi mam yatha) can absolutely NEVER be seen or achieved in this way (Shakya evam-vidho drashtum)...
            neither by extensively studying the massive Vedas (Naham vedaih), nor by undergoing severe, brutal penances (Na tapasa), nor by executing massive, billion-dollar charity (Na danena), nor by performing highly complex, expensive sacrifices and rituals (Na chejyaya).
            This phenomenal verse acts as the absolute heaviest, most destructive titanium 'Hammer' smashing the toxic 'Spiritual Ego' of materialistic humanity!
            Arrogant mortals constantly hallucinate that they can somehow 'Purchase', blackmail, or mechanically force God to appear before them using their massive wealth, high IQ, or brutal physical endurance (austerities).
            Sri Krishna systematically, one by one, 100% ruthlessly 'Rejects and Disqualifies' the 4 most universally glorified paths of achieving greatness:
            1. 'Vedah' (Academic Knowledge): You can aggressively memorize entire libraries of Sanskrit Vedas and become the world's most elite PhD scholar, but you will absolutely never see Me.
            2. 'Tapasya' (Physical Torture): You can stand barefoot on a freezing Himalayan glacier for 100 years, severely torturing your biology, but you will never see Me.
            3. 'Dana' (Wealth/Charity): You can be a multi-billionaire philanthropist and casually donate your entire fortune to build temples, but you absolutely cannot 'Buy' My vision.
            4. 'Ijyaya' (Massive Rituals): You can hire thousands of priests to execute hundred-million-dollar fire sacrifices, yet you cannot force Me to appear.
            The Lord makes it crystal clear: God is absolutely NOT a vending machine or a cheap 'Business' where you insert these 4 coins (knowledge, austerity, charity, rituals) and instantly extract a vision of Him. Through these purely 'Mechanical' transactions, seeing My true form is biologically and spiritually 'Impossible' (Naham Shakya)!
        """.trimIndent()
    ),
    Shloka(
        id = 54,
        sanskrit = """
            भक्त्या त्वनन्यया शक्य अहमेवंविधोऽर्जुन |
            ज्ञातुं द्रष्टुं च तत्त्वेन प्रवेष्टुं च परन्तप || ५४ ||
        """.trimIndent(),
        hindi = """
            परंतु हे परन्तप अर्जुन! केवल और केवल 'अनन्य भक्ति' (100% शुद्ध और एकनिष्ठ प्रेम) के द्वारा ही (भक्त्या त्वनन्यया)...
            मैं इस प्रकार के (अपने असली साक्षात्) रूप में (अहमेवंविधो), वास्तव में (तत्त्व से) 'जाना' जा सकता हूँ (ज्ञातुं), अपनी आँखों से प्रत्यक्ष 'देखा' जा सकता हूँ (द्रष्टुं च), और मेरे भीतर (मेरे परम धाम में) 'प्रवेश' (Entry) भी किया जा सकता है (प्रवेष्टुं च)!
            पिछले श्लोक में भगवान ने 4 रास्तों (वेद, तप, दान, यज्ञ) को रिजेक्ट कर दिया था, जिससे इंसान पूरी तरह निराश हो सकता है। 
            अब इस श्लोक में भगवान ब्रह्मांड का 'एकमात्र मास्टर-पासवर्ड' (The Only Master-Password) दे रहे हैं जो ईश्वर के सिस्टम को हैक (Hack) कर सकता है!
            वह पासवर्ड है: "अनन्य भक्ति" (Ananya Bhakti / 100% Unconditional, Single-minded Love)।
            'अनन्य' का मतलब है कि आपके दिल में भगवान के सिवा कोई दूसरा (अन्य) नहीं होना चाहिए। आपको भगवान से मोक्ष, पैसा या स्वर्ग कुछ नहीं चाहिए; आपको सिर्फ 'भगवान' चाहिए।
            जब इंसान इस लेवल (Level) का शुद्ध 'प्यार' (भक्ति) करता है, तो उसे तीन सुपर-पावर (Super-powers) एक साथ मिल जाती हैं:
            १. 'ज्ञातुं' (To Know): वह भगवान के सारे रहस्यों को बिना किताबें पढ़े 100% समझ जाता है।
            २. 'द्रष्टुं' (To See): उसे ध्यान में या साक्षात् भगवान का ओरिजिनल (Original) रूप आँखों से 'दिखाई' दे जाता है (जैसे अर्जुन को दिखा)।
            ३. 'प्रवेष्टुं' (To Enter): और मरने के बाद वह सीधा भगवान के 'हृदय' (परम धाम / वैकुंठ) में वीआईपी 'एंट्री' (VIP Entry) मार लेता है।
            ईश्वर को केवल एक ही करेंसी (Currency) से खरीदा जा सकता है, और वह है 'निस्वार्थ प्रेम' (Pure Love)।
        """.trimIndent(),
        english = """
            But my dear Arjuna, O conqueror of enemies (Parantapa)! It is strictly and exclusively by undivided, 100% pure, unalloyed devotional service and love alone (Bhaktya tv ananyaya) that I can be approached in this way (Shakya aham evam-vidho)...
            Only by this pure love can I be genuinely, fundamentally 'Understood' in truth (Jnatum), practically 'Seen' face-to-face (Drashtum cha tattvena), and ultimately 'Entered into' (Praveshtum cha)!
            In the previous verse, the Lord ruthlessly rejected the 4 massive pillars of human effort (Vedas, Austerity, Charity, Rituals), which could easily plunge an ignorant human into absolute despair.
            Now, in this spectacularly explosive verse, the Lord officially reveals the universe's 'Single, Absolute Master-Password' that can flawlessly hack God's system!
            That ultimate password is: "Ananya Bhakti" (100% Unconditional, Undivided, Laser-focused Pure Love).
            'Ananya' strictly means that your heart harbors absolutely ZERO 'Other' (Anya) toxic agendas. You are not treating God like a vending machine demanding money, a healthy body, or even liberation; you fiercely want ONLY God for God's sake.
            When a human biological machine successfully generates this staggering level of pure 'Love' (Bhakti), he instantaneously unlocks three ultimate Cosmic Superpowers simultaneously:
            1. 'Jnatum' (To Know): He perfectly and flawlessly decodes all of God's classified cosmic secrets without needing to read a single academic book.
            2. 'Drashtum' (To See): He gets absolute VIP clearance to practically, visually 'SEE' God's true, original form face-to-face (exactly as Arjuna just did).
            3. 'Praveshtum' (To Enter): And upon physical death, his soul executes a direct, non-stop VIP 'Entry' straight into the very heart and eternal kingdom of God (Vaikuntha).
            The Supreme Creator can be legally purchased using exactly ONE cosmic currency: 'Pure, Selfless Love' (Bhakti).
        """.trimIndent()
    ),
    Shloka(
        id = 55,
        sanskrit = """
            मत्कर्मकृन्मत्परमो मद्भक्तः सङ्गवर्जितः |
            निर्वैरः सर्वभूतेषु यः स मामेति पाण्डव || ५५ ||
        """.trimIndent(),
        hindi = """
            हे पाण्डव (अर्जुन)! जो मनुष्य केवल मेरे लिए ही सारे कर्म (ड्यूटी) करता है (मत्कर्मकृत्), जो केवल मुझे ही अपना परम लक्ष्य (सुप्रीम बॉस) मानता है (मत्परमो), जो मेरा सच्चा 'भक्त' है (मद्भक्तः)...
            जो सांसारिक चीजों और फलों से पूरी तरह अनासक्त (अटैचमेंट-फ्री / सङ्गवर्जितः) है, और जिसका इस दुनिया के किसी भी प्राणी से कोई 'वैर' (दुश्मनी / निर्वैरः) नहीं है...
            ऐसा वह शुद्ध इंसान निश्चित रूप से सीधे 'मुझे ही' प्राप्त करता है (यः स मामेति)!
            यह ग्यारहवें अध्याय का 'ग्रैंड फिनाले' (Grand Finale) श्लोक है, और आदि शंकराचार्य जी के अनुसार यह 'पूरी भगवद्गीता का सबसे महान और सम्पूर्ण श्लोक' (The Essence of Gita) है।
            अगर किसी के पास पूरी गीता पढ़ने का समय नहीं है, तो भगवान ने मोक्ष पाने का '5-स्टेप फॉर्मूला' (5-Step Formula) इस एक श्लोक में पैक (Pack) कर दिया है:
            १. 'मत्कर्मकृत्' (My Work): तुम जो भी काम (जॉब/बिज़नेस) करो, उसे 'मेरा काम' समझकर पूरी ईमानदारी से करो।
            २. 'मत्परमो' (My Goal): पैसे या फेम (Fame) को अपना लक्ष्य मत बनाओ, केवल 'ईश्वर' को अपना आखिरी लक्ष्य मानकर जियो।
            ३. 'मद्भक्तः' (My Devotee): दिल में मेरे लिए बहुत प्यार रखो (भक्ति)।
            ४. 'सङ्गवर्जितः' (Zero Attachment): काम करो, लेकिन काम के रिज़ल्ट (सक्सेस/फेलियर) या पैसे से फेविकोल की तरह चिपक मत जाना।
            ५. 'निर्वैरः' (Zero Enmity): यह सबसे ज़रूरी है! तुम भगवान से तो प्यार करो, लेकिन इंसान से नफरत करो, यह नहीं चलेगा। तुम्हारे दिल में दुनिया के किसी भी इंसान, जानवर या कीड़े के लिए 0% दुश्मनी (निर्वैर) होनी चाहिए।
            जो इंसान अपनी ज़िंदगी इस '5-स्टेप' के हिसाब से जीता है, भगवान स्टैम्प (Stamp) लगा देते हैं कि वह मरने के बाद "मामेति" (सीधा मेरे घर, मेरी गोद में ही आएगा)! 
            यहाँ विश्वरूप दर्शन योग नामक 11वां अध्याय अत्यंत ही भव्यता के साथ पूर्ण होता है।
        """.trimIndent(),
        english = """
            O son of Pandu (Arjuna)! He who actively engages in executing all his activities entirely for Me (Mat-karma-krit), who considers Me as the absolute supreme goal of his life (Mat-paramo), who is My pure devoted servant (Mad-bhaktah)...
            who is entirely free from the toxic contamination of material attachments and fruitive results (Sanga-varjitah), and who holds absolutely zero enmity, hatred, or malice towards any living entity in the universe (Nirvairah sarva-bhuteshu)...
            that flawless person undoubtedly and directly comes to Me (Yah sa mam eti)!
            This is the spectacular, explosive 'Grand Finale' verse of the Eleventh Chapter. According to elite ancient commentators like Adi Shankaracharya, this single verse contains the absolute 'Complete Essence and Summary of the entire Bhagavad Gita'!
            If a human being completely lacks the time to read the entire Gita, the Supreme Lord has flawlessly compressed the ultimate '5-Step Master-Formula' for achieving eternal Moksha into this single, mind-blowing verse:
            1. 'Mat-karma-krit' (My Work): Whatever intense corporate job or worldly duty you execute, do it with 100% titanium integrity, treating it exclusively as 'My' personal work.
            2. 'Mat-paramo' (My Goal): Absolutely do not make cheap paper money or toxic social clout your ultimate life goal. Make 'God' your absolute, singular target.
            3. 'Mad-bhaktah' (My Devotee): Saturate your heart with explosive, unadulterated pure Love (Bhakti) for Me.
            4. 'Sanga-varjitah' (Zero Attachment): Execute intense actions, but never, ever violently glue your psychology to the material results (success, failure, or profits). Remain 100% unattached.
            5. 'Nirvairah' (Zero Enmity): This is the absolute ultimate filter! You cannot claim to love God while simultaneously harboring toxic hatred for His creations. Your heart must contain mathematically 0% enmity, jealousy, or malice towards absolutely any human, animal, or insect in the multiverse.
            The Lord officially signs an iron-clad Cosmic Guarantee: Any human who flawlessly operates his biological life strictly executing these '5 Steps', upon death, instantly shatters the matrix and "Mam eti" (Comes straight on a direct flight into My eternal embrace)!
            Here flawlessly and majestically concludes the phenomenal Eleventh Chapter, The Vision of the Universal Form.
        """.trimIndent()
    )
)