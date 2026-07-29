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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaThreeScreen() {
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
                    // Safe search logic explicitly finding the ID
                    val targetIndex = adhyayaThreeShlokas.indexOfFirst { it.id == targetId }
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
            label = { Text("Search Shloka (1-${adhyayaThreeShlokas.size})") },
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
            itemsIndexed(adhyayaThreeShlokas) { _, shloka ->
                // This automatically uses your existing SaptshatiCard from the other files!
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

// Top-Level Data List (NO companion object used here!)
val adhyayaThreeShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ऋषिरुवाच ॥ १ ॥\nनिहन्यमानं तत्सैन्यमवलोक्य महासुरः ।\nसेनानीश्चिक्षुरः कोपाद् ययौ योद्धुमम्बिकाम् ॥ २ ॥",
        hindi = """
            (चिक्षुर का क्रोध): "महर्षि मेधा ने कहा: अपनी उस विशाल सेना को इस प्रकार देवी के हाथों अत्यंत भयंकर रूप से कटते और मरते हुए देखकर।"
            "महिषासुर की सेना का मुख्य सेनापति, वह महा-राक्षस 'चिक्षुर' अत्यंत भयंकर क्रोध से पागल हो उठा।"
            "और वह तुरंत साक्षात् भगवती 'अम्बिका' (महामाया) के साथ युद्ध करने के लिए रणभूमि में आगे बढ़ गया!"
            चिक्षुर (Chikshura) का शाब्दिक अर्थ है 'चंचल' (Restless)। यह इंसान के दिमाग का वह हिस्सा है जो कभी टिक कर एक जगह नहीं बैठता।
            जब ध्यान या सच्चाई की ऊर्जा इंसान के अज्ञान (सेना) को मिटाना शुरू करती है, तो माइंड का 'ओवरथिंकिंग' एक्टिव हो जाता है।
            वह क्रोध में आकर ध्यान को तोड़ने का प्रयास करता है। चिक्षुर का युद्ध में उतरना साइकोलॉजी में 'अटेंशन डेफिसिट' का प्रतीक है।
            ईगो (Ego) को जब लगता है कि उसका बेस कमज़ोर हो रहा है, तो वह आपके विचारों को भयंकर गति से दौड़ाता है ताकि आप शांत न हो सकें।
            परंतु चिक्षुर यह नहीं जानता कि वह साक्षात् 'अम्बिका' (समस्त ब्रह्मांड की माता और परम शांति) से टकराने जा रहा है।
            अम्बिका वह परम शून्यता है जिसके सामने दुनिया की सबसे तेज़ गति वाला विचार भी जाकर नष्ट हो जाता है।
            यहाँ से अध्याय 3 के असली कॉस्मिक युद्ध की आक्रामक शुरुआत होती है।
        """.trimIndent(),
        english = """
            (The Wrath of Chikshura): "The Sage profoundly declared: Vividly witnessing that colossal demonic army being brutally slaughtered and ruthlessly decimated by the Goddess."
            "The absolute primary Commander-in-Chief of Mahishasura's forces, the terrifying mega-demon 'Chikshura', erupted into blinding apocalyptic rage."
            "And he violently aggressively charged forward into the battlefield explicitly to actively fight the Supreme Goddess 'Ambika'!"
            'Chikshura' literally translates to 'The Restless One'. This flawlessly symbolizes the exceptionally unstable, scattered, and hyperactive human mind.
            When the pure energy of Truth begins to systematically eradicate thick ignorance, the mind's toxic 'Overthinking' mechanism actively retaliates.
            It aggressively utilizes blind rage to ruthlessly shatter the human's inner peace. Chikshura's massive attack explicitly represents 'Attention Deficit'.
            When the toxic Ego realizes its foundation is collapsing, it forcefully accelerates your chaotic thoughts to maximum velocity to prevent stillness.
            However, Chikshura is completely ignorant that he is aggressively charging directly at 'Ambika' (The Universal Mother of Absolute Peace).
            Ambika undeniably represents that ultimate Supreme Void where even the absolute fastest chaotic thought instantly drops dead to mathematical zero.
            This flawlessly marks the aggressive initiation of Chapter 3's literal cosmic psychological war.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "स देवीं शरवर्षेण ववर्ष समरेऽसुरः ।\nयथा मेरुगिरेः शृङ्गं तोयवर्षेण तोयदः ॥ ३ ॥",
        hindi = """
            (चिक्षुर की तीरों की बारिश): "उस भयंकर राक्षस ने युद्ध के मैदान में माता के ऊपर अपने तीखे बाणों की अत्यंत खौफनाक बारिश कर दी।"
            "उसने इतने तीर चलाए मानो कोई विशाल बादल सुमेरु पर्वत के सर्वोच्च शिखर पर भयंकर मूसलाधार बारिश कर रहा हो!"
            यह श्लोक चंचल मन (चिक्षुर) के अटैक को बहुत ही साइंटिफिक तरीके से समझा रहा है।
            बाण (Arrows) इंसान के 'विचारों' (Thoughts) का प्रतीक हैं। जब आप शांत बैठने की कोशिश करते हैं, तो दिमाग फालतू विचारों की बारिश कर देता है।
            ताकि आपकी चेतना विचलित हो जाए। परंतु यहाँ देवी की तुलना 'सुमेरु पर्वत' (Mount Meru) से की गई है!
            सुमेरु पर्वत ब्रह्मांड का 'सेंटर' (Axis) है, जो बिल्कुल अचल और स्थिर (Unmovable) है।
            बादल कितनी भी ज़ोर से बारिश कर लें, वे पहाड़ को कभी अपनी जगह से हिला नहीं सकते; बारिश का पानी पहाड़ से टकराकर नीचे ही गिरता है।
            उसी तरह, अज्ञान के विचार (तीर) परम चेतना (देवी) को रत्ती भर भी डैमेज या डिस्टर्ब नहीं कर सकते।
            अहंकार (Ego) अपनी पूरी ताकत लगाकर थक जाएगा, पर सत्य की स्थिरता को कभी नहीं तोड़ पाएगा।
            ओवरथिंकिंग परम शांति की अचल स्थिति के आगे हमेशा हार जाती है।
        """.trimIndent(),
        english = """
            (Chikshura's Rain of Arrows): "In that terrifying battlefield, that massive demon unleashed an exceptionally horrific torrential rain of razor-sharp arrows directly upon the Goddess."
            "He violently showered weapons exactly like a colossal dark storm-cloud relentlessly executing a torrential downpour upon the peak of Mount Meru!"
            This spectacular verse flawlessly explicitly decodes the exact scientific mechanism of the restless mind's (Chikshura's) direct attack.
            Arrows perfectly symbolize 'Thoughts'. When you attempt to sit in absolute peace, your toxic brain ruthlessly rains thousands of useless chaotic thoughts.
            It desperately aims to violently distract your pure consciousness. However, the Goddess is profoundly compared to 'Mount Meru'!
            Mount Meru is undeniably the absolute central Axis of the entire cosmos, remaining entirely perfectly Unmovable and completely invincible.
            Regardless of how violently the clouds rain, they absolutely cannot possibly shake the massive mountain; the water merely crashes and falls.
            Similarly, the toxic thoughts (arrows) of thick ignorance cannot actively cause even a microscopic fraction of Damage to Supreme Consciousness.
            The toxic Ego will aggressively exhaust its entire biological energy, but it can never shatter the absolute stability of the Supreme Truth.
            Overthinking strictly eternally loses directly against the unmovable foundation of absolute pure peace.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "छित्त्वा तस्य शरान् देवी लीलयैव शरोत्करैः ।\nजघान तुरगान् बाणैर्यन्तारं चैव वाजिनम् ॥ ४ ॥",
        hindi = """
            (देवी का प्रहार): "तब परम देवी ने बिल्कुल 'खेल-खेल में' (लीलयैव) अपने अचूक तीरों के प्रहार से उस राक्षस के उन सभी तीरों को हवा में ही काट डाला!"
            "और केवल इतना ही नहीं, माता ने अपने तीरों से उस राक्षस के 'रथ के घोड़ों' और उसके 'सारथी' को भी तुरंत जान से मार दिया!"
            'लीलयैव' (खेल-खेल में) शब्द यह साबित करता है कि जो अज्ञान अपनी पूरी ताकत लगा रहा था, उसे हराना भगवान के लिए कोई काम (Task) ही नहीं है।
            राक्षस का 'रथ' उसके ईगो का स्ट्रक्चर है। 'घोड़े' उसकी इंद्रियां (Senses) हैं जो उसे युद्ध में दौड़ा रही हैं।
            और 'सारथी' उसकी 'भ्रष्ट बुद्धि' (Corrupted Intellect) है जो उस रथ को चला रही है।
            देवी ने राक्षस को मारने से पहले उसका सपोर्ट सिस्टम (Support System) काट दिया।
            जब आप बुराई को ख़त्म करना चाहते हैं, तो आपको उसके सोर्स (घोड़े और सारथी) को डिलीट करना पड़ता है।
            बिना इन्द्रियों और अशुद्ध बुद्धि के, इंसान का ईगो बिल्कुल अपाहिज (Paralyzed) हो जाता है।
            महामाया का यह 'सर्जिकल स्ट्राइक' सीधे अज्ञान की जड़ों को सुखा रहा है।
            यह ध्यान की वह अवस्था है जहाँ इंद्रियां बाहरी दुनिया की तरफ दौड़ना बंद कर देती हैं।
        """.trimIndent(),
        english = """
            (The Goddess's Counter-Strike): "Then, purely playfully and completely effortlessly, the Supreme Goddess released Her own invincible arrows, ruthlessly severing all of his weapons in mid-air!"
            "And actively advancing further, the Mother immediately slaughtered the exact horses actively pulling his massive chariot, alongside his demon charioteer!"
            The profound word 'Lilayaiva' (Playfully) undeniably proves that defeating the toxic ignorance which was utilizing its entire life force is absolutely zero Task for God.
            The demon's 'Chariot' is the exact literal physical structure of his toxic Ego. The 'Horses' strictly symbolize his biological Senses driving him into war.
            And the 'Charioteer' is undeniably his absolute 'Corrupted Intellect' actively navigating that toxic chariot.
            The Goddess flawlessly ruthlessly dismantled the demon's complete physical Support System directly prior to actively slaughtering him.
            Exactly when you desire to completely annihilate pure evil, you actively must relentlessly Delete its primary source code (the horses and charioteer).
            Completely without biological senses and toxic intellect, the human Ego successfully becomes entirely Paralyzed and completely helpless.
            Mahamaya's explicit advanced Surgical Strike is aggressively drying up the absolute deepest literal roots of thick ignorance.
            This perfectly symbolizes that supreme state of meditation where biological senses permanently cease actively running towards the external illusion.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "चिच्छेद च धनुः सद्यो ध्वजं चातिसमुच्छ्रितम् ।\nविव्याध गात्रेषु छिन्नधन्वानमाशुगैः ॥ ५ ॥",
        hindi = """
            (धनुष और ध्वजा का कटना): "उसके बाद माता ने तुरंत ही उस राक्षस के भयंकर 'धनुष' को और अत्यंत ऊँचाई पर फहरा रही उसकी 'ध्वजा' को भी काट कर ज़मीन पर गिरा दिया!"
            "धनुष कट जाने के बाद, देवी ने अपने अत्यंत तेज़ गति वाले बाणों से उस राक्षस के शरीर के 'सभी अंगों' को बुरी तरह बींध डाला!"
            'धनुष' हथियार है जिससे विचार (तीर) निकलते हैं; देवी ने उसका थॉट-प्रोसेस ही ब्लॉक कर दिया।
            'ध्वजा' (Flag) इंसान के झूठे 'सम्मान और अहंकार' (Pride) का प्रतीक है। जो ईगो बहुत ऊँचा उड़ रहा था, सत्य ने उसे एक सेकंड में ज़मीन पर पटक दिया।
            जब इंसान का घमंड टूटता है, तो उसका 'अहंकार रूपी झंडा' कट जाता है, जिससे सेना का मोरल डाउन हो जाता है।
            शरीर को बींधना—माता के तीर अब सीधे अस्तित्व पर प्रहार कर रहे हैं।
            यह कोई फिजिकल दर्द नहीं है; यह वह भयंकर 'गिल्ट' और 'रियलाइजेशन' है जो अज्ञान के टूटने पर इंसान को अंदर तक चीर देता है।
            जब आपके पास न तर्क (धनुष) बचे और न घमंड (ध्वजा), तब परम चेतना आपके ईगो को छलनी कर देती है।
            चिक्षुर अब पूरी तरह से नंगा और निहत्था हो चुका है।
            यह आध्यात्मिक अहंकार के पूर्ण विनाश की प्रक्रिया है।
        """.trimIndent(),
        english = """
            (Severing the Bow and Flag): "Immediately after, the Mother flawlessly severed and ruthlessly struck down the demon's massive Bow and his exceptionally high-flying Flag of pride!"
            "With his bow completely destroyed, the Goddess aggressively pierced the absolute entire physical body of that demon strictly utilizing Her exceptionally lightning-fast arrows!"
            The 'Bow' is the exact physical literal weapon from which thoughts are generated; the Goddess permanently Blocked his underlying Thought-process.
            The 'Flag' undeniably symbolizes the human's highly fake Status and toxic Pride. The exact ego flying exceptionally high was violently smashed straight to the dirt.
            Exactly when a human's toxic arrogance shatters, his specific 'Flag of Ego' drops, violently destroying his morale.
            'Piercing the body'—The Mother's absolute cosmic arrows are now executing direct aggressive physical strikes entirely upon his core existence.
            This is absolutely zero physical pain; this perfectly symbolizes that terrifying Guilt and brutal Realization which pierces a human exactly when ignorance shatters.
            When you actively possess zero arguments (Bow) and zero fake pride (Flag), the Supreme Consciousness ruthlessly pierces the body of your Ego.
            Chikshura has now effortlessly successfully become completely Vulnerable and entirely unarmed.
            This perfectly explicitly represents the absolute permanent destruction strictly of supreme spiritual arrogance.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "स छिन्नधन्वा विरथो हताश्वो हतसारथिः ।\nअभ्यधावत तां देवीं खड्गचर्मधरोऽसुरः ॥ ६ ॥",
        hindi = """
            (निहत्थे राक्षस का हमला): "अपना धनुष कट जाने, रथ के टूट जाने, और घोड़ों तथा सारथी के मारे जाने के बाद भी।"
            "वह भयंकर राक्षस अपने हाथ में 'तलवार' और 'ढाल' लेकर साक्षात् उस परम देवी की ओर मारने के लिए 'दौड़ पड़ा'!"
            यही अज्ञान (Ignorance) का सबसे खौफनाक और 'ब्लाइंड' रूप है! उसका पूरा सिस्टम क्रैश हो चुका है।
            फिर भी वह अपनी हार स्वीकार करने को तैयार नहीं है। अहंकार को लगता है कि अगर मेरे पास तलवार है, तो मैं भगवान को भी मार सकता हूँ।
            'तलवार और ढाल'—ये इंसान के उस 'सर्वाइवल इंस्टिंक्ट' का प्रतीक हैं जहाँ वह अपने ईगो को बचाने के लिए आक्रामक और डिफेन्सिव दोनों हो जाता है।
            वह भूल गया कि जिसके तीरों ने दूर से ही उसका रथ नष्ट कर दिया, वह पास जाने पर उसका क्या हाल करेगी!
            इंसान जब अपनी बुरी आदतों के चंगुल में फँसता है, तो लॉजिक खत्म होने के बाद वह 'गुस्से' और 'ज़िद' से सच का सामना करना चाहता है।
            महिषासुर का सेनापति अब अपनी मौत के बिल्कुल आखिरी कदम पर है।
            देवी उसे रोकने के बजाय उसकी अंधी दौड़ को देख रही हैं ताकि उसका पूरा अहंकार बाहर आ सके।
            यह ईगो का अंतिम और सबसे हताश प्रयास है।
        """.trimIndent(),
        english = """
            (The Desperate Charge of the Disarmed Demon): "Even completely after his bow was severed, his chariot shattered, and his horses alongside his charioteer were brutally slaughtered."
            "That highly toxic demon violently gripped a massive Sword and heavy Shield, and aggressively sprinted completely blindly straight towards the Supreme Goddess to attack Her!"
            This undeniably perfectly is the absolute most exceptionally Blind and horrifying exact form of thick Ignorance! His complete operating system is Crashed.
            Yet he actively completely aggressively refuses entirely to successfully seamlessly accept his absolute defeat. Ego falsely assumes it can slaughter God using a cheap sword.
            The 'Sword and Shield' seamlessly symbolize the human's toxic Survival Instinct, aggressively becoming exceptionally Offensive and Defensive exclusively to protect the fake Ego.
            He completely foolishly forgot that the exact Entity whose arrows obliterated his massive chariot from afar will flawlessly annihilate him up close!
            Exactly when a human is trapped inside toxic bad habits and logic entirely ends, he attempts to aggressively fight Truth using blind Stubbornness and raw rage.
            Mahishasura's supreme general is undeniably exactly taking his absolute literal final physical steps towards certain absolute death.
            Instead of passively stopping him, the Goddess effortlessly watches his blind sprint so his complete toxic ego fully manifests.
            This flawlessly represents the absolute final and most desperate physical attempt of the dying ego.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "सिंहमाहत्य खड्गेन तीक्ष्णधारेण मूर्धनि ।\nआजघान भुजे सव्ये देवीमप्यतिवेगवान् ॥ ७ ॥",
        hindi = """
            (देवी और सिंह पर वार): "उस अत्यंत तेज़ गति वाले राक्षस ने पास पहुँचकर अपनी 'अत्यंत तेज़ धार वाली तलवार' से।"
            "माता के 'वाहन शेर के सिर' पर बहुत ज़ोर से प्रहार किया! और उसके तुरंत बाद उसने 'देवी के बाएँ हाथ' पर भी तलवार से हमला कर दिया!"
            अहंकार (चिक्षुर) का यह सबसे 'सुसाइडल' कदम था! उसने साक्षात् 'धर्म' (शेर) और 'परम चेतना' (देवी) पर तलवार चला दी।
            शेर के सिर पर वार करना मतलब इंसान के अंदर की सच्चाई (Truth/Courage) को चोट पहुँचाने की कोशिश करना।
            'बाएँ हाथ' (Left arm) पर प्रहार—तन्त्र में बायां हिस्सा 'रिसेप्टिव' और 'करुणा' (Compassion) का प्रतीक है।
            राक्षस माता की करुणा को कमज़ोरी समझकर उस पर वार कर रहा है।
            यह हमारी रियल लाइफ में होता है; जब आप किसी के साथ अच्छा करते हैं, तो बुरा इंसान उसी अच्छाई (बाएं हाथ) पर प्रहार करता है।
            परंतु सत्य के शरीर (देवी) पर भौतिक हथियारों का कोई असर नहीं होता।
            चिक्षुर ने अपनी ताकत का सबसे भयंकर इस्तेमाल किया है, पर यह वार उसके खुद के विनाश का 'ट्रिगर' बनने वाला है।
            अज्ञान की तलवार जब सत्य के कवच से टकराती है, तो केवल तलवार ही टूटती है।
        """.trimIndent(),
        english = """
            (Striking the Lion and Goddess): "Reaching exceptionally close with massive terrifying speed, that demon violently utilized his extremely razor-sharp Sword."
            "He aggressively brutally struck a massive physical blow directly perfectly upon the exact Head of the Mother's Lion, and simultaneously violently attacked the Goddess's Left Arm!"
            This was undeniably the exact absolute most heavily Suicidal step exactly of the toxic Ego! He literally actively violently attacked absolute 'Dharma' (Lion) and 'Supreme Consciousness'.
            Striking the Lion's head explicitly mathematically equates to aggressively attempting perfectly to ruthlessly damage the absolute inner pure Truth and Courage.
            Attacking the 'Left Arm'—In advanced Tantra, the left cosmic side seamlessly symbolizes pure absolute Receptivity and supreme Divine Compassion.
            The pathetic demon ignorantly assumes the Mother's absolute compassion is a physical weakness and violently aggressively attempts to exploit it.
            This flawlessly perfectly happens in real life; exactly when you actively strictly demonstrate pure goodness, a toxic human deliberately strikes that exact goodness.
            However, cheap physical worldly weapons possess exactly zero active capability entirely to damage the indestructible body of Supreme Truth.
            Chikshura has actively aggressively utilized his absolute maximum raw force, but this explicit strike is undeniably the exact physical Trigger exclusively for his absolute annihilation.
            Exactly when the sword of ignorance crashes into the armor of Truth, exclusively the cheap sword shatters.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "तस्याः खड्गो भुजं प्राप्य पफाल नृपनन्दन ।\nततो जग्राह शूलं स कोपादरुणलोचनः ॥ ८ ॥",
        hindi = """
            (तलवार का टूटना): "हे राजा सुरथ! उस राक्षस की वह भयंकर तलवार परम देवी की भुजा से टकराते ही तुरंत 'टूटकर टुकड़े-टुकड़े' हो गई!"
            "अपनी तलवार को इस प्रकार टूटते हुए देखकर, वह राक्षस 'क्रोध के कारण अपनी आँखें बिल्कुल लाल करके' एक भयंकर 'शूल' उठा लाया!"
            यह देवी के 'अभेद्य शरीर' का सबसे बड़ा प्रमाण है!
            राक्षस ने अपनी पूरी ताकत से तलवार चलाई, पर देवी को खरोंच भी नहीं आई; उल्टे राक्षस की तलवार (उसका सबसे बड़ा लॉजिक) ही टूट कर बिखर गई।
            जब असत्य (Lie) सत्य (Truth) से सीधे टकराता है, तो सत्य को पलटवार करने की ज़रूरत नहीं होती; झूठ खुद-ब-खुद टूट जाता है।
            तलवार टूटने के बाद भी राक्षस ने हार नहीं मानी! उसने अपनी आँखें क्रोध से लाल कर लीं और एक नया हथियार उठा लिया।
            यह ईगो की वह बीमारी है जहाँ इंसान एक गलती पकड़े जाने पर उसे सुधारने के बजाय, उसे सही साबित करने के लिए दूसरा झूठ गढ़ लेता है।
            गुस्से से लाल आँखें उस 'पागलपन' का प्रतीक हैं जहाँ अज्ञान अपनी मौत को देखकर बौखला गया है।
            महिषासुर का यह सेनापति अब अपनी आखिरी और सबसे खौफनाक गलती करने जा रहा है।
            सत्य की अजेयता यहाँ पूरी तरह सिद्ध हो गई है।
        """.trimIndent(),
        english = """
            (The Shattering of the Sword): "O King Suratha! The exact split-second that terrifying massive sword aggressively violently collided exactly with the Goddess's arm, it instantly completely Shattered into pieces!"
            "Visually witnessing his ultimate weapon flawlessly destroyed, that monster, with his exact physical eyes actively burning entirely blood-red exclusively due to rage, ruthlessly gripped a massive Spear!"
            This is undeniably the absolute greatest explicit proof exactly of the Goddess's completely Indestructible cosmic physical form!
            The demon violently applied his absolute maximum raw force, yet the Goddess received zero scratches; instead, the demon's sword (his highest logic) violently shattered perfectly.
            Exactly when a massive Lie crashes directly straight into Absolute Truth, Truth requires absolutely zero need entirely to strike back; the Lie effortlessly automatically destroys itself.
            Even exactly after his sword was brutally severed, the demon absolutely did not yield! He violently turned his eyes blood-red with rage and aggressively grabbed a brand-new weapon.
            This perfectly symbolizes the toxic disease of Ego where, instead of seamlessly actively accepting a mistake, a human aggressively fabricates a completely new lie.
            The bloodshot eyes explicitly symbolize that absolute terrifying Madness where thick ignorance completely panics witnessing its literal death.
            Mahishasura's supreme general is flawlessly exactly now actively preparing to successfully successfully commit his absolute final mistake.
            The absolute invincibility strictly of pure Truth is flawlessly explicitly proven perfectly exactly right here.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "चिक्षेप च सुतप्तं तत्तेजसा भद्रकालिम् ।\nभद्रकाल्यां महाशूलं ज्वालामालमिवोत्थितम् ॥ ९ ॥",
        hindi = """
            (भाले का प्रहार): "उस राक्षस ने उस अत्यंत खौफनाक और 'आग की तरह धधकते हुए' उस महा-शूल (भाले) को।"
            "साक्षात् परम देवी 'भद्रकाली' (महामाया) के ऊपर पूरी ताकत से 'फेंक कर मारा'!"
            "वह भयंकर भाला आसमान में उड़ता हुआ ऐसा लग रहा था मानो आकाश से 'आग की भयंकर ज्वालाएं और लपटें' देवी की तरफ आ रही हों!"
            यहाँ पहली बार माता को 'भद्रकाली' कहा गया है! 'भद्र' का अर्थ है जो मंगल करती हैं, और 'काली' मतलब साक्षात् 'काल' (Death)।
            चिक्षुर ने अपनी सबसे भयंकर और धधकती हुई नेगेटिव एनर्जी को सीधे 'समय और मृत्यु' (भद्रकाली) पर फेंक दिया है!
            भाले से आग की लपटें निकलना इंसान के उस चरम 'द्वेष और घृणा' का प्रतीक है जो किसी को पूरी तरह से जला देना चाहता है।
            अज्ञान अपनी पूरी आग (Fire) लेकर आ रहा है।
            पर राक्षस यह भूल गया है कि वह जिस पर आग फेंक रहा है, वह देवी खुद पूरे ब्रह्मांड की 'परम अग्नि' की मालकिन हैं।
            यह श्लोक दिखाता है कि जब बुराई अपना सबसे घातक और आख़िरी वार करती है, तो वह कितना विनाशकारी दिखाई देता है।
            परंतु भद्रकाली के सामने यह आग महज़ एक चिंगारी है।
        """.trimIndent(),
        english = """
            (The Lethal Strike of the Spear): "That monster aggressively violently hurled exactly that exceptionally terrifying and intensely violently 'Blazing fire-like' massive Spear with absolute total brute force."
            "Directly perfectly explicitly straight upon the absolute Supreme Goddess 'Bhadrakali' Herself!"
            "That terrifying massive spear actively flying seamlessly entirely through the physical sky visually appeared identically like a colossal 'Massive apocalyptic mountain of violent blazing flames' rushing towards the Goddess!"
            Right exactly here explicitly for the absolute first time, the Mother is undeniably formally addressed strictly as 'Bhadrakali'! 'Bhadra' translates to Goodness, and 'Kali' equates to Absolute Death.
            Chikshura has violently successfully explicitly hurled his absolute most terrifying blazing negative energy directly perfectly exactly at literal 'Time and Death' (Bhadrakali) Herself!
            The blazing flames explicitly erupting directly from the spear seamlessly symbolize the human's absolute ultimate extreme 'Hatred' which violently desires to brutally burn someone to ashes.
            Thick ignorance is actively aggressively perfectly flawlessly attacking directly bringing its absolute complete total Fire.
            But the pathetic monster entirely ignorantly perfectly forgot exactly that She whom he is actively attacking is Herself the absolute Supreme Owner exactly of the entire universe's 'Supreme Fire'.
            This spectacular verse flawlessly effectively proves exactly how exceptionally horrifying Evil visually explicitly completely physically appears precisely when executing its absolute final lethal strike.
            However, directly exactly perfectly flawlessly strictly in absolute pure front of Bhadrakali, this explicit blazing fire is literally a tiny microscopic spark.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "दृष्ट्वा तदापतच्छूलं देवी शूलममुञ्चत ।\nतेन तच्छतधा शूलं स च भस्मीकृतोऽसुरः ॥ १० ॥",
        hindi = """
            (चिक्षुर का वध): "अपनी ओर आते हुए उस भयंकर आग उगलते शूल को देखकर, परम देवी ने तुरंत अपने हाथों से अपना अजेय त्रिशूल चला दिया!"
            "देवी के उस त्रिशूल ने राक्षस के उस भयंकर भाले को हवा में ही 'सौ टुकड़ों में काटकर चकनाचूर' कर दिया!"
            "और उसी त्रिशूल ने उस महान राक्षस को भी एक ही झटके में जलाकर 'पूरी तरह राख' कर दिया!"
            यह देवी का 'क्वांटम प्रहार' है! सत्य ने अज्ञान के सबसे बड़े हथियार को हवा में ही 'शतधा' (100 टुकड़ों) में तोड़ दिया।
            माता का त्रिशूल (सत्व, रज, तम का कंट्रोलर) जब वार करता है, तो वह केवल हथियार को नहीं रोकता, वह हथियार चलाने वाले को भी हमेशा के लिए डिलीट कर देता है।
            'भस्मीकृतो' (राख कर दिया)—चिक्षुर का शरीर ज़मीन पर नहीं गिरा; वह त्रिशूल की परम ऊर्जा से वहीं हवा में जलकर 'राख' हो गया!
            चंचल मन (चिक्षुर) का अंत 'शून्य' (Ashes) में होता है। जब ध्यान अपने चरम पर पहुँचता है, तो ओवरथिंकिंग पूरी तरह भस्म हो जाती है।
            महिषासुर का सबसे बड़ा सेनापति अब इतिहास बन चुका है।
            अहंकार की पहली बड़ी लेयर को देवी ने एक सेकंड में राख कर दिया है!
            यह ध्यान की वह सर्वोच्च अवस्था है जहाँ चंचलता जड़ से मिट जाती है।
        """.trimIndent(),
        english = """
            (Annihilation of Chikshura): "Visually vividly perfectly witnessing that exceptionally terrifying fire-spitting massive spear aggressively rushing straight towards Her, the Goddess instantaneously violently unleashed Her invincible Trident!"
            "The Mother's terrifying Trident ruthlessly actively brutally completely shattered and perfectly explicitly sliced the exact demon's massive spear into precisely 'One Hundred Pieces' completely seamlessly exactly in mid-air!"
            "And that exact identical absolute Trident seamlessly violently ruthlessly explicitly entirely burned that exact mega-demon completely perfectly exactly straight to absolute literal physical 'Ashes' in a single split-second!"
            This is undeniably the Goddess's absolute ultimate terrifying 'Quantum Strike'! The Supreme Truth violently shattered the absolute greatest weapon of thick Ignorance perfectly into exactly 100 microscopic pieces flawlessly.
            When the Mother's Trident (the absolute supreme controller of Sattva, Rajas, and Tamas) brutally strikes, it absolutely does not merely block the weapon; it permanently Deletes the exact literal Source entirely forever.
            'Bhasmikrito' (Reduced to Ashes)—Chikshura's physical dirt-body absolutely did not casually drop perfectly to the exact physical ground; it flawlessly violently burned exactly straight entirely to absolute pure ashes in mid-air!
            The exceptionally Restless Mind absolutely explicitly meets its ultimate brutal end perfectly in absolute Void (Ashes). When pure Meditation reaches its absolute peak, toxic Overthinking is permanently incinerated.
            Mahishasura's absolute supreme explicit general is undeniably seamlessly effectively now pure history.
            The Goddess has flawlessly aggressively burned the absolute first massive Layer exactly of the toxic Ego straight to ashes in exactly one second!
            This mathematically actively seamlessly represents that supreme pure stage exactly of explicit absolute intense meditation where restlessness dies eternally.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "महिषासुरसेनानौ निहते वीर्यशालिनि ।\nआजगाम गजारूढश्चामरस्त्रिदशार्दनः ॥ ११ ॥",
        hindi = """
            (चामर का प्रवेश): "महिषासुर की सेना के उस अत्यंत बलशाली और मुख्य सेनापति के मारे जाने पर।"
            "देवताओं को भयंकर कष्ट देने वाला वह दूसरा महा-राक्षस 'चामर' तुरंत एक 'विशालकाय हाथी पर सवार होकर' देवी से लड़ने के लिए आ पहुँचा!"
            चिक्षुर (चंचल मन) के भस्म होते ही, 'चामर' (ईगो का दूसरा रूप) तुरंत एक्टिव हो गया!
            यह दिखाता है कि एक बुराई के मरते ही, माइंड तुरंत दूसरी बुराई को सामने ले आता है ताकि आपकी चेतना (देवी) आराम न कर सके।
            चामर 'हाथी' पर बैठकर आया है। हाथी 'भारीपन' (Heaviness), 'जड़ता', और 'अहंकार की विशालता' का प्रतीक है।
            चिक्षुर रथ पर था (तेज़ गति), पर चामर हाथी पर है (धीमी लेकिन कुचलने वाली ताकत)।
            जब आपका 'ओवरथिंकिंग' खत्म होता है, तो कभी-कभी आप एक गहरे 'डिप्रेशन और आलस' (हाथी) में चले जाते हैं।
            यह चामर वही भारी अज्ञान है जो देवताओं (अच्छाई) को कुचलता है।
            परंतु वह मूर्ख नहीं जानता कि जो देवी अग्नि से भस्म कर सकती है, वह हाथी को भी तिनके की तरह उड़ा सकती है।
            अहंकार अब अपने तामसिक (Tamasic) रूप में देवी से टकराने आ रहा है।
        """.trimIndent(),
        english = """
            (Chamara Arrives): "Exactly perfectly immediately entirely upon the exceptionally horrifying absolute violent literal death of Mahishasura's exceptionally powerful absolute supreme explicit Commander-in-Chief."
            "That second terrifying mega-demon explicitly named 'Chamara', the ultimate brutal tormentor of the pure Gods, instantaneously arrived strictly riding a colossal terrifying 'Giant Elephant' to ruthlessly fight the Goddess!"
            Exactly perfectly explicitly the exact identical split-second Chikshura (Restless Mind) was violently burned to physical ashes, 'Chamara' (the second explicit toxic form of Ego) instantaneously became aggressively Active!
            This spectacularly completely proves exactly that strictly perfectly exactly immediately upon the literal death of exactly one toxic evil, the human mind flawlessly instantly ruthlessly replaces it with another.
            Chamara has aggressively perfectly arrived actively seamlessly riding a massive 'Elephant'. The literal Elephant flawlessly undeniably symbolizes absolute terrifying 'Heaviness', strict 'Stubborn inertia', and colossal toxic Ego.
            Chikshura was on a chariot (high speed), but Chamara is strictly actively riding an elephant (slow but totally crushing absolute force).
            Exactly when your toxic 'Overthinking' completely entirely cleanly explicitly dies, you frequently silently slip completely perfectly directly into a highly dense terrifying 'Depression and extreme laziness' (The Elephant).
            This specific Chamara is exactly that absolute heavy thick ignorance which actively brutally entirely completely crushes the pure goodness (Gods).
            However, the pathetic fool absolutely actively perfectly ignores exactly that the Goddess who seamlessly burned a demon to ashes can effortlessly blow away an elephant.
            Toxic ego is actively flawlessly seamlessly advancing absolutely utilizing its highly Tamasic exact literal heavy format.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 11,
        sanskrit = "सोऽपि शक्तिं मुमोचाथ देव्यास्तामम्बिका द्रुतम् ।\nहुङ्कारेणैव ताम्भस्मीकृत्य सा भूमलेऽपातयत् ॥ १२ ॥",
        hindi = """
            (हुंकार से भस्म होना): "उस चामर ने आते ही अपनी अत्यंत विनाशकारी 'शक्ति' (भाला) परम देवी के ऊपर पूरी ताकत से फेंक दी!"
            "परंतु साक्षात् उस परम 'अम्बिका' देवी ने अपने मुँह से केवल एक भयंकर 'हुं' (Humkara) का उच्चारण किया!"
            "और उस 'हुंकार' की आवाज़ मात्र से ही उस भयंकर शक्ति को हवा में ही राख करके उसे ज़मीन पर गिरा दिया!"
            यह पूरे ब्रह्मांड के विज्ञान (Science) का सबसे बड़ा चमत्कार है! देवी ने कोई हथियार नहीं चलाया, उन्होंने केवल 'हुं' की ध्वनि की!
            'हुंकार' तन्त्र में अग्नि बीज (Fire Seed Mantra) का प्रतीक है। यह वह कॉस्मिक फ्रीक्वेंसी है जो किसी भी भौतिक चीज़ को डी-मटेरियलाइज़ कर सकती है।
            चामर (Ego) ने अपना सबसे भारी फिजिकल अस्त्र चलाया, पर अम्बिका ने उसे केवल अपनी एक 'साँस की आवाज़' से भस्म कर दिया!
            यह सिद्ध करता है कि मैटर हमेशा साउंड (Consciousness) का गुलाम होता है।
            जब इंसान के अंदर बुराई बहुत भारी हो जाए, तो केवल परम चेतना का एक 'बीज मंत्र' ही उस बुराई को ज़ीरो करने के लिए काफी होता है।
            चामर का ईगो उस राख की तरह ज़मीन पर गिर पड़ा है।
            शब्द (Sound) की शक्ति यहाँ समस्त भौतिक अस्त्रों पर भारी पड़ती दिखाई गई है।
        """.trimIndent(),
        english = """
            (Burned by Humkara): "Exactly perfectly immediately entirely upon aggressively arriving, that Chamara violently ruthlessly entirely hurled his exceptionally apocalyptic 'Shakti' (Spear) completely straight upon the Supreme Goddess!"
            "However, the exact literal direct absolute Supreme 'Ambika' Goddess instantaneously flawlessly actively explicitly merely uttered a single exceptionally terrifying apocalyptic sound of 'Hum' directly from Her physical mouth!"
            "And strictly seamlessly effortlessly explicitly exclusively via the sheer absolute terrifying blinding raw power of that 'Humkara' sound alone, She aggressively successfully 'Burned that exact physical spear entirely straight to literal Ashes' in exactly mid-air!"
            This is undeniably the absolute greatest precise literal miracle perfectly exactly inside the entire Science of the physical universe! The Goddess actively flawlessly entirely fired zero physical weapons; She merely executed the 'Hum' Sound!
            'Humkara' perfectly successfully actively identically translates precisely entirely explicitly perfectly inside advanced Tantra to the absolute Fire Seed Mantra. It is the exact cosmic Frequency capable of De-materializing any object.
            Chamara (Ego) violently actively completely effectively fired his absolute heaviest physical weapon, but Ambika effortlessly successfully entirely burned it to literal ashes exclusively with the pure simple sound of a single 'Breath'!
            This explicitly mathematically completely perfectly flawlessly proves exactly that physical Matter is undeniably perpetually the absolute cheap pathetic slave entirely explicitly to pure Sound.
            When absolute evil becomes exceptionally massive, exclusively exactly one single 'Seed Mantra' (Sound) exactly of the Supreme Consciousness is effortlessly completely enough to reduce it to zero.
            Chamara's toxic ego has violently actively dropped perfectly straight exactly to the absolute literal dirt exactly like that ash.
            The sheer absolute cosmic power of Divine Sound explicitly flawlessly ruthlessly destroys all physical weapons right exactly here.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "भग्नायां शक्तौ शूलं स चिक्षेप क्रोधाकुलः ।\nतदपि सा देवी छित्त्वा बाणैरुपातयत् ॥ १३ ॥",
        hindi = """
            (शूल का कटना): "अपनी परम शक्तिशाली 'शक्ति' (भाले) को इस प्रकार भस्म होते हुए देखकर, वह राक्षस 'क्रोध से बिल्कुल पागल' (क्रोधाकुलः) हो गया!"
            "और बौखलाहट में उसने देवी के ऊपर अपना दूसरा सबसे भयंकर 'शूल' (त्रिशूल) पूरी ताकत से फेंक कर मारा।"
            "परंतु परम देवी ने अपने अत्यंत तेज़ और अचूक बाणों (तीरों) से उस शूल को भी हवा में ही 'काटकर' (छित्त्वा) ज़मीन पर गिरा दिया!"
            जब ईगो का सबसे बड़ा हथियार (शक्ति) केवल एक 'आवाज़' (हुंकार) से नष्ट हो जाता है, तो अहंकार पूरी तरह से अपमानित और बौखला जाता है।
            'क्रोधाकुलः' (क्रोध से व्याकुल)—यह साइकोलॉजी का वह फेज़ है जहाँ इंसान हार बर्दाश्त नहीं कर पाता और बिना सोचे-समझे रिएक्शन (Reaction) देने लगता है।
            उसने गुस्से में दूसरा हथियार (शूल) चलाया, पर इस बार देवी ने उसे अपने 'तीरों' से काट दिया।
            तीर (Arrows) फोकस (Focus) और क्लैरिटी (Clarity) के प्रतीक हैं। देवी का फोकस इतना अचूक है कि वह अज्ञान के हर रैंडम थॉट को हवा में ही ब्लॉक कर रही हैं।
            ईगो बार-बार कोशिश कर रहा है, और चेतना उसे बार-बार रिजेक्ट (Reject) कर रही है।
            चामर का हाथी अब पूरी तरह से सुरक्षाहीन (Defenseless) हो चुका है।
            यह दृश्य यह सिखाता है कि क्रोध में उठाया गया कोई भी कदम कभी सत्य को पार नहीं कर सकता।
        """.trimIndent(),
        english = """
            (Severing the Spear): "Visually witnessing his absolute supreme devastating 'Shakti' weapon flawlessly perfectly completely burned to pure ashes, that monster instantly went absolutely 'Visually Insane with pure blinding rage'!"
            "And aggressively actively strictly acting purely exactly out of extreme frustration, he violently ruthlessly entirely hurled his absolute second most horrifying 'Trident' directly perfectly upon the Supreme Goddess."
            "However, the absolute Supreme Goddess flawlessly utilized Her exceptionally terrifying, razor-sharp, completely invincible arrows to aggressively perfectly entirely explicitly 'Sever' that exact spear cleanly entirely directly in exact mid-air, causing it to aggressively drop to the literal dirt!"
            Exactly when the Ego's absolute supreme absolute heaviest massive physical weapon is permanently destroyed strictly perfectly by exclusively one single literal 'Sound', the toxic Ego perfectly explicitly becomes completely deeply absolutely humiliated and violently mentally frustrated.
            'Krodhakula' explicitly mathematically translates strictly flawlessly exactly to pure blinding frustration—the precise psychological phase where a toxic human absolutely cannot handle brutal defeat and strictly flawlessly executes blind aggressive reactions.
            He aggressively actively violently hurled exactly his absolute second weapon entirely in pure blind rage, but this specific time the Goddess flawlessly ruthlessly aggressively permanently severed it exclusively utilizing strictly Her pure absolute 'Arrows'.
            Arrows seamlessly perfectly flawlessly explicitly symbolize absolute pure extreme intense mental Focus and extreme Clarity. The Goddess's absolute focus is undeniably successfully perfectly flawless.
            The toxic Ego is aggressively repeatedly strictly flawlessly actively completely attempting entirely, and the Supreme pure Consciousness perfectly relentlessly ruthlessly explicitly entirely successfully Rejects it.
            Chamara's exceptionally massive literal elephant is undeniably flawlessly actively completely successfully directly right exactly now absolutely 100% physically Defenseless.
            This flawless visual explicitly perfectly undeniably seamlessly completely teaches entirely exactly that any physical step violently aggressively actively completely taken strictly completely purely in blind sheer rage can never successfully cross absolute pure Truth.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "ततः सिंहः समुत्पत्य गजकुम्भान्तरे स्थितः ।\nबाहुयुद्धेन तेनोच्चैश्चचार सुरशत्रुणा ॥ १४ ॥",
        hindi = """
            (शेर का हाथी पर कूदना): "जैसे ही चामर के अस्त्र कटकर गिरे, माता का वाहन 'सिंह' (शेर) ज़मीन से अत्यंत तेज़ी से 'उछलकर' (समुत्पत्य)!"
            "सीधे उस विशालकाय हाथी के 'मस्तक' (गजकुम्भान्तरे) के बीचों-बीच जाकर बैठ गया (स्थितः)!"
            "और उस हाथी के सिर पर बैठकर ही, उस शेर ने देवताओं के उस भयंकर शत्रु (सुरशत्रुणा / चामर) के साथ अत्यंत भयंकर 'बाहुयुद्ध' (हाथापाई / Hand-to-hand combat) शुरू कर दिया!"
            यह पूरी सप्तशती के सबसे रोमांचक और प्रतीकात्मक (Symbolic) दृश्यों में से एक है!
            'शेर' (Lion) साक्षात् 'धर्म', 'साहस' (Courage) और 'सत्य' का प्रतीक है, और 'हाथी' (Elephant) भारी 'अहंकार' और 'जड़ता' (Tamas) का।
            जब देवी (परम चेतना) ने अहंकार के सभी तर्क (अस्त्र) काट दिए, तो धर्म (शेर) ने खुद उछलकर अज्ञान के सिर (हाथी के मस्तक) पर कब्ज़ा कर लिया!
            धर्म कभी नीचे रहकर अज्ञान से नहीं लड़ता; वह सीधा अज्ञान के 'दिमाग' (मस्तक) पर बैठता है।
            शेर और चामर का 'बाहुयुद्ध' (Wrestling)—यह इंसान के अंदर की वह 'इनर फाइट' (Inner Fight) है जहाँ आपका साहस और आपका डिप्रेशन (हाथी) आपस में हाथापाई करते हैं।
            धर्म ने अब अहंकार को पूरी तरह से 'लॉक' (Lock) कर दिया है।
            यह ईगो के फिजिकल सप्रेशन (Physical suppression) की शुरुआत है।
        """.trimIndent(),
        english = """
            (The Lion Jumps on the Elephant): "The exact absolute split-second Chamara's weapons aggressively fell shattered, the Mother's absolute supreme pure divine vehicle, the 'Lion', violently 'Leaped' directly from the dirt perfectly utilizing exceptionally terrifying blinding speed!"
            "And successfully actively flawlessly entirely perfectly completely physically landed absolutely directly identically exactly perfectly strictly upon the exact absolute top literal 'Forehead' strictly of that exact colossal massive terrifying elephant!"
            "And actively aggressively strictly remaining perfectly actively seated upon that massive exact elephant's physical head, that pure divine Lion aggressively flawlessly aggressively initiated an exceptionally terrifying absolute extremely brutal 'Hand-to-Hand Combat' (Bahu-Yuddha) directly perfectly completely identically strictly against that absolute supreme massive exact brutal enemy of the Gods!"
            This is undeniably actively successfully perfectly flawlessly explicitly exactly one absolute of the absolutely most incredibly thrilling and deeply Symbolic explicit pure visual exactly perfectly inside the entire Durga Saptashati!
            The 'Lion' mathematically explicitly cleanly undeniably exactly strictly successfully explicitly translates absolutely identically perfectly exclusively exactly into absolute pure pure pure 'Dharma', extreme absolute pure 'Courage', and absolute strictly entirely 'Truth', whereas the 'Elephant' strictly seamlessly entirely completely represents heavy exact thick 'Ego' and 'Tamas'.
            Exactly when the Supreme Goddess cleanly perfectly actively entirely permanently severed absolutely all pure massive weapons exactly of the Ego, absolute Dharma (Lion) flawlessly actively violently aggressively dynamically perfectly jumped and aggressively captured the exact physical exact literal 'Brain' (Forehead) exactly of pure thick ignorance!
            Absolute Dharma absolutely strictly explicitly flawlessly entirely completely perfectly actively never fights pure heavy ignorance actively remaining completely safely identically physically entirely directly down; it jumps explicitly strictly entirely perfectly to the precise head.
            The direct brutal precise physical exact 'Wrestling' explicitly seamlessly physically actively executed strictly directly entirely actively between the Lion and Chamara is undeniably identically the precise exact human's literal pure 'Inner Fight' where courage actively precisely physically wrestles strict depression.
            Dharma has absolutely completely seamlessly perfectly perfectly strictly successfully physically entirely perfectly physically directly Locked the heavy toxic ego.
            This mathematically flawlessly accurately actively flawlessly successfully successfully formally rigorously undeniably strictly successfully specifically directly exactly explicitly perfectly strictly initiates the exact brutal direct explicit strict absolute Physical suppression of the heavy toxic Ego.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "युध्यमानौ ततस्तौ तु तस्मान्नागान्महीतलम् ।\nनिपेततुः सम्मरब्धौ प्रहारैरतिदारुणैः ॥ १५ ॥",
        hindi = """
            (ज़मीन पर गिरना): "हाथी के मस्तक पर अत्यंत भयंकर रूप से हाथापाई (युध्यमानौ) करते हुए, वे दोनों (शेर और चामर)!"
            "एक-दूसरे पर 'अत्यंत भयंकर और खौफनाक प्रहार' (प्रहारैरतिदारुणैः) करते हुए, अचानक उस विशाल हाथी के ऊपर से नीचे 'ज़मीन पर आ गिरे' (निपेततुः सम्मरब्धौ महीतलम्)!"
            यह श्लोक उस महासंग्राम की इंटेंसिटी (Intensity) को दिखा रहा है। शेर और राक्षस दोनों इतने गुस्से और जोश में गुंथे हुए हैं कि वे हाथी का संतुलन खोकर नीचे गिर पड़ते हैं।
            साइकॉलॉजी में इसे 'ग्राउंडिंग' (Grounding) कहते हैं। जब आपका 'धर्म' (शेर) आपके 'भारी ईगो' (हाथी पर बैठे चामर) से लड़ता है, तो ईगो को उसकी ऊँचाई (हाथी) से नीचे ज़मीन (Reality) पर आना ही पड़ता है।
            अहंकार हमेशा खुद को दूसरों से ऊपर (हाथी पर) समझता है।
            परंतु धर्म (शेर) उसे खींचकर 'महीतलम्' (ज़मीन/धरती) पर ला पटकता है, ताकि उसे उसकी असली औकात दिखाई जा सके।
            'अतिदारुणैः प्रहारैः' (भयंकर प्रहार)—सच्चाई और झूठ की लड़ाई कभी सॉफ्ट (Soft) नहीं होती।
            जब आप अपनी किसी पुरानी और गहरी बुरी आदत को छोड़ते हैं, तो अंदर भयंकर तोड़-फोड़ (दारुण प्रहार) मचती है।
            चामर अब अपनी 'सुपीरियरिटी' (हाथी) से नीचे गिरकर ज़मीन पर रेंगने के लिए मजबूर हो गया है।
            यह ईगो के झूठे रुतबे (Fake Status) का पतन है।
        """.trimIndent(),
        english = """
            (Falling to the Ground): "Aggressively wrestling intensely upon the elephant's head, both entities executed horrifying physical blows directly upon each other!"
            "They became so aggressively entangled that they lost the elephant's balance and violently dropped straight down to the dirt ground!"
            "This verse flawlessly demonstrates the absolute raw Intensity of that cosmic fight. The Lion and demon are completely locked in pure rage."
            "Inside advanced Psychology, this explicit physical process is named 'Grounding'."
            "When pure Dharma (Lion) fights the heavy Ego (Chamara on the elephant), the ego must drop to reality."
            "Toxic ego eternally perceives itself physically elevated above everyone else."
            "However, pure Dharma ruthlessly drags it down to the Earth to destroy its fake toxic status."
            "The fight between Truth and Lies is never soft; breaking old bad habits creates internal destruction."
            "Chamara is now forced to physically fight on the pure dirt, completely losing his height."
            "This mathematically represents the complete destruction of the ego's false superiority."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "ततस्तु वेगात् खमुत्पत्य निपत्य च मृगारिणा ।\nकरप्रहारेण शिरश्चामरस्य पृथक्कृतम् ॥ १६ ॥",
        hindi = """
            (चामर का वध): "ज़मीन पर गिरते ही, माता के उस सिंह (मृगारिणा) ने अत्यंत भयंकर 'तेज़ी से' (वेगात्) हवा में 'उछलकर' (खमुत्पत्य)!"
            "और फिर वापस अत्यंत वेग से नीचे 'गिरते हुए' (निपत्य च), अपने 'पंजों के एक ही भयंकर प्रहार से' (करप्रहारेण)।"
            "उस महा-राक्षस चामर के 'सिर को उसके धड़ से पूरी तरह अलग' (शिरश्चामरस्य पृथक्कृतम्) कर दिया!"
            यह धर्म (शेर) की परम विजय है! शेर ने देवी को कोई कष्ट दिए बिना, खुद ही अपने पंजे (करप्रहारेण) से चामर का सिर धड़ से अलग कर दिया।
            'खमुत्पत्य' (आकाश में उछलना) दिखाता है कि सत्य हमेशा ऊँचाई (Highest perspective) से वार करता है।
            शेर का पंजा (Paw) उस 'कर्म' (Action) का प्रतीक है जो बिना किसी हथियार के, केवल अपने शुद्ध पौरुष (Pure courage) से बुराई को चीर देता है।
            चामर (डिप्रेशन / भारी अहंकार) का सिर कटना मतलब 'थॉट प्रोसेस' का धड़ (शरीर) से अलग होना।
            जब तक दिमाग (सिर) शरीर (इन्द्रियों) से जुड़ा है, तब तक आलस और भारीपन बना रहता है।
            शेर ने उस कनेक्शन (Connection) को एक झटके में काट दिया।
            महिषासुर की सेना के दो सबसे बड़े और खौफनाक स्तंभ (चिक्षुर और चामर) अब हमेशा के लिए नष्ट हो चुके हैं!
        """.trimIndent(),
        english = """
            (The Slaughter of Chamara): "Upon dropping to the dirt, the Mother's Lion moved with blinding speed!"
            "It violently leaped into the sky and came crashing downward dynamically."
            "With a single, extremely terrifying strike of its powerful paw, it attacked."
            "It completely severed the mega-demon Chamara's head from his physical body!"
            "This is the absolute victory of Dharma, destroying ego without the Goddess's weapons."
            "Leaping into the sky shows that Truth always strikes from the Highest perspective."
            "The paw symbolizes pure Action that obliterates evil utilizing pure courage."
            "Severing the head of heavy depression disconnects the toxic thought process."
            "As long as the corrupted brain is attached to the body, heavy laziness remains."
            "The Lion permanently disconnected it. The two greatest pillars of Mahishasura's army are now destroyed!"
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "उग्रस्यश्च रणे देव्या शिलावृक्षादिभिर्हतः ।\nदन्तमुष्टितलैश्चैव करालश्च निपातितः ॥ १७ ॥",
        hindi = """
            (उदग्र और कराल का वध): "देवी ने युद्ध में 'उदग्र' नामक राक्षस को पत्थरों और पेड़ों से मार गिराया।"
            "तथा 'कराल' नामक भयंकर राक्षस को भी अपने प्रहारों से ज़मीन पर सुला दिया।"
            "माता ने कराल को मारने के लिए अपने दाँतों, मुक्कों और थप्पड़ों का प्रयोग किया।"
            "यह दृश्य दर्शाता है कि साक्षात् प्रकृति (देवी) को किसी विशेष अस्त्र की आवश्यकता नहीं है।"
            "वह साधारण भौतिक तत्वों से ही बड़े-बड़े अज्ञान को कुचल सकती हैं।"
            "उदग्र का अर्थ है 'अत्यंत घमंडी' और कराल का अर्थ है 'भयंकर क्रोध'।"
            "घमंड (उदग्र) को तोड़ने के लिए प्रकृति पत्थर और पेड़ (कठोर वास्तविकता) का उपयोग करती है।"
            "क्रोध (कराल) को शांत करने के लिए देवी उसे थप्पड़ और मुक्के (सीधी चोट) मारती हैं।"
            "यह ईगो के अलग-अलग रूपों का बहुत ही सिस्टमैटिक विनाश है।"
            "प्रकृति के सामने इंसान की कोई भी मानसिक बीमारी या घमंड नहीं टिक सकता।"
        """.trimIndent(),
        english = """
            (Death of Udagra and Karala): "The Goddess killed the demon 'Udagra' during the battle using heavy stones and trees."
            "She also completely crushed the terrifying demon 'Karala' straight to the ground."
            "To kill Karala, the Mother aggressively utilized Her teeth, fists, and powerful slaps."
            "This visually proves Mother Nature requires zero advanced weaponry to destroy evil."
            "She can pulverize massive ignorance using the most basic physical elements."
            "'Udagra' means extreme arrogance, and 'Karala' translates to horrific wrath."
            "To shatter arrogance, Nature uses stones and trees, representing harsh reality."
            "To silence wrath, the Goddess applies direct physical trauma through slaps and fists."
            "This is the highly systematic destruction of the ego's various specific forms."
            "No human mental disease or arrogance can survive in front of Mother Nature."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "प्रादाच्च गदापातेन चूर्णयामास चोद्धतम् ।\nबाष्कलं भिन्दिपालेन बाणैस्ताम्रान्धकावपि ॥ १८ ॥",
        hindi = """
            (उद्धत, बाष्कल, ताम्र और अन्धक का वध): "देवी ने अत्यंत क्रोध में आकर अपनी गदा का भयंकर प्रहार किया।"
            "और उस प्रहार से 'उद्धत' नामक राक्षस को पीसकर चूर्ण (राख) कर दिया।"
            "उसके बाद उन्होंने 'बाष्कल' नामक राक्षस को भिन्दिपाल (एक प्रकार का अस्त्र) से मारा।"
            "और 'ताम्र' तथा 'अन्धक' नामक राक्षसों को अपने अचूक बाणों से मौत के घाट उतार दिया।"
            "अहंकार एक रूप में नहीं आता; इसके अलग-अलग मनोवैज्ञानिक रूप होते हैं।"
            "उद्धत (उद्दंडता), बाष्कल (क्रूरता), ताम्र (लालच) और अन्धक (अंधापन/अज्ञान)।"
            "महामाया इन सभी मनोवैज्ञानिक बीमारियों को बहुत ही सटीकता से नष्ट कर रही हैं।"
            "हर विकार के लिए माता एक अलग और सटीक अस्त्र (गदा, तीर, आदि) का प्रयोग करती हैं।"
            "उद्दंडता (उद्धत) को गदा से कुचला जाता है, और लालच (ताम्र) को तीरों से भेदा जाता है।"
            "अज्ञान (अन्धक) भी चेतना के बाणों के सामने पल भर में नष्ट हो जाता है।"
        """.trimIndent(),
        english = """
            (Death of Uddhata, Bashkala, Tamra, Andhaka): "The Goddess, in supreme wrath, delivered a terrifying strike with Her heavy mace."
            "With that blow, She pulverized the demon 'Uddhata' completely into fine dust."
            "Following this, She slaughtered 'Bashkala' using a specific throwing weapon."
            "She then killed the demons 'Tamra' and 'Andhaka' using Her flawless arrows."
            "The toxic ego does not manifest in one form; it has various psychological faces."
            "Uddhata is Arrogance, Bashkala is Cruelty, Tamra is Greed, and Andhaka is Blindness."
            "Mahamaya is systematically eradicating these psychological diseases with absolute precision."
            "For every mental distortion, the Mother uses a specifically tailored cosmic weapon."
            "Arrogance is crushed by the mace, while Greed is pierced entirely by sharp arrows."
            "Blind Ignorance is also instantly destroyed when struck by the arrows of Consciousness."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "उग्रास्यमुग्रवीर्यं च तथैव च महाहनुम् ।\nत्रिनेत्रा च त्रिशूलेन जघान परमेश्वरी ॥ १९ ॥",
        hindi = """
            (त्रिशूल से वध): "तीन नेत्रों वाली परमेश्वरी ने अपने अत्यंत भयानक त्रिशूल का प्रहार किया।"
            "उन्होंने 'उग्रास्य' नामक महा-राक्षस को अपने त्रिशूल से मार डाला।"
            "तथैव उन्होंने 'उग्रवीर्य' नामक अत्यंत बलशाली राक्षस का भी संहार किया।"
            "और 'महाहनु' नामक राक्षस को भी उसी त्रिशूल से मौत के घाट उतार दिया।"
            "'त्रिनेत्रा' (तीन आँखों वाली) ज्ञान और विवेक (Clarity) की जाग्रत अवस्था का प्रतीक है।"
            "'उग्रास्य' का अर्थ है कड़वे और हिंसक वचन बोलने वाला विकार।"
            "'उग्रवीर्य' का अर्थ है गलत दिशा में बहने वाली हिंसक ऊर्जा या वासना।"
            "और 'महाहनु' (बड़ा जबड़ा) इंसान के उस बड़े घमंड का प्रतीक है जो सब कुछ निगलना चाहता है।"
            "जब विवेक (तीसरी आँख) जाग्रत होता है, तो त्रिशूल (तीनों गुणों का नियंत्रण) वार करता है।"
            "और यह अस्त्र इन सभी मानसिक विकारों का एक साथ संहार कर देता है।"
        """.trimIndent(),
        english = """
            (Death by Trident): "The three-eyed Supreme Goddess delivered a strike with Her terrifying Trident."
            "She effortlessly slaughtered the mega-demon 'Ugrasya' with this divine weapon."
            "Similarly, She annihilated the exceptionally powerful demon named 'Ugravirya'."
            "She also dispatched the demon 'Mahahanu' to death using the exact same Trident."
            "'Trinetra' (Three-eyed) symbolizes the fully activated state of absolute wisdom."
            "'Ugrasya' represents the mental distortion of speaking bitter and violent words."
            "'Ugravirya' symbolizes toxic violent energy or lust flowing in the wrong direction."
            "'Mahahanu' (Large jaw) represents the massive pride that desires to consume everything."
            "When the third eye of wisdom opens, the Trident of the three Gunas strikes."
            "This cosmic weapon simultaneously annihilates all these toxic mental distortions."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "बिडालस्यासिना कायात् पातयामास वै शिरः ।\nदुर्धरं दुर्मुखं चोभौ शरैर्निन्ये यमक्षयम् ॥ २० ॥",
        hindi = """
            (बिडाल, दुर्धर और दुर्मुख का वध): "माता ने अपनी अत्यंत तेज़ धार वाली तलवार निकाली और प्रहार किया।"
            "उन्होंने 'बिडाल' नामक राक्षस का सिर काटकर उसके शरीर से अलग कर दिया।"
            "इसके साथ ही युद्ध भूमि में दो और भयंकर राक्षस आगे आए।"
            "परंतु देवी ने 'दुर्धर' और 'दुर्मुख' दोनों को अपने बाणों से यमलोक पहुँचा दिया।"
            "ये तीनों राक्षस इंसान के चरित्र के बहुत ही गहरे और छिपे हुए दोष हैं।"
            "'बिडाल' का अर्थ है बिल्ली, जो इंसान की 'चालाकी' और 'धोखेबाज़ी' का प्रतीक है।"
            "'दुर्धर' वह विकार है जो 'बुरी आदतों' को ज़िद्दी तरीके से धारण करके रखता है।"
            "और 'दुर्मुख' वह विकार है जो हमेशा 'अपशब्द' और नकारात्मक बातें बोलता है।"
            "सत्य की तलवार और चेतना के बाण इन चालाक आदतों को छुपने नहीं देते।"
            "वे बिना किसी दया के इन मनोवैज्ञानिक बीमारियों को हमेशा के लिए समाप्त कर देते हैं।"
        """.trimIndent(),
        english = """
            (Death of Bidala, Durdhara, and Durmukha): "The Mother drew Her exceptionally razor-sharp sword and delivered a strike."
            "She completely severed the head of the demon 'Bidala' from his physical body."
            "Simultaneously, two other terrifying demons advanced in the battlefield."
            "But the Goddess dispatched both 'Durdhara' and 'Durmukha' to the realm of Death."
            "These three demons represent deeply hidden and highly toxic character flaws."
            "'Bidala' means cat, flawlessly symbolizing human cunningness and deception."
            "'Durdhara' is the toxic distortion that stubbornly holds onto extremely bad habits."
            "'Durmukha' represents the flaw of constantly speaking foul words and negativity."
            "The sword of Truth and the arrows of Consciousness do not let these habits hide."
            "They permanently and mercilessly execute these deceptive psychological patterns."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "एवंसङ्क्षीयमाणे तु स्वसैन्ये महिषासुरः ।\nमाहिषेण स्वरूपेण त्रासयामास तान् गणान् ॥ २१ ॥",
        hindi = """
            (महिषासुर का असली रूप): "अपनी विशाल सेना को इस प्रकार अत्यंत भयानक रूप से नष्ट होते देखकर।"
            "महिषासुर समझ गया कि अब उसके सभी सेनापति और रक्षक मारे जा चुके हैं।"
            "तब स्वयं महिषासुर अपने असली 'भैंसे के रूप' (माहिषेण स्वरूपेण) में प्रकट हुआ।"
            "और उसने अपने उस भयंकर रूप से देवी के गणों को डराना और मारना शुरू कर दिया!"
            "यह दुर्गा सप्तशती का सबसे बड़ा टर्निंग पॉइंट (Turning Point) है।"
            "जब अहंकार के सारे बाहरी सिपाही (तर्क, क्रोध, चालाकी, डिप्रेशन) हार जाते हैं।"
            "तो अंत में इंसान का मूल 'पशु रूप' (Animal instinct) बाहर निकल कर आता है।"
            "महिषासुर (भैंसा) वह गहरी जड़ता और अंधा हठ है जो अब तक छिपा हुआ था।"
            "अब वह बिना किसी आवरण या तर्क के, सीधे तौर पर चेतना (देवी) के सामने खड़ा हो गया है।"
            "सारे आवरणों के हटने के बाद, अब परम सत्य और परम अज्ञान का असली युद्ध शुरू होगा!"
        """.trimIndent(),
        english = """
            (Mahishasura's True Form): "Witnessing his massive army being horrifically annihilated in this complete manner."
            "Mahishasura realized that all his commanders and external defenses were slaughtered."
            "Then, Mahishasura himself finally took his true, literal 'Buffalo form'."
            "He began violently terrorizing and attacking the Goddess's divine troops!"
            "This is the absolute greatest turning point inside the entire Durga Saptashati."
            "When all external defenses of the ego (arguments, wrath, deception) are destroyed."
            "The human's core, raw, unfiltered 'Animal Instinct' ultimately steps out into the open."
            "Mahishasura (the Buffalo) represents the deep-seated, blind stubbornness hidden within."
            "Now, completely stripped of any logical cover, he stands directly before Consciousness."
            "With all masks removed, the final, ultimate battle between Truth and Ignorance begins!"
        """.trimIndent()
    ),
            SaptshatiShloka(
            id = 21,
    sanskrit = "काँश्चित्तुण्डप्रहारेण खुरविक्षेपतस्तथान् ।\nलाङ्गूलताडितांश्चान्याञ्छृङ्गाभ्यां च विदारितान् ॥ २२ ॥",
    hindi = """
            (भैंसे का आक्रमण): "महिषासुर ने अपने असली और भयंकर भैंसे के रूप में आकर देवी के गणों पर सीधा और जानलेवा हमला कर दिया।"
            "उसने कुछ योद्धाओं को अपने 'थूथन' (मुंह) की ज़ोरदार मार से ज़मीन पर गिरा कर बुरी तरह कुचल दिया।"
            "कुछ गणों को उसने अपने भारी 'खुरों' की लात मारकर रणभूमि से बहुत दूर फेंक दिया।"
            "कई योद्धाओं को उसने अपनी लंबी और लोहे जैसी 'पूंछ' के भयंकर प्रहार से लहूलुहान कर दिया।"
            "और बाकी बचे हुए योद्धाओं को उसने अपने नुकीले 'सींगों' से फाड़ कर मौत के घाट उतार दिया।"
            यहाँ महिषासुर का थूथन, खुर, पूंछ और सींग इंसान के अंध और पाश्विक (Animalistic) प्रहारों का प्रतीक हैं।
            जब इंसान का ईगो हारने लगता है, तो वह लॉजिक भूलकर गंदी भाषा (थूथन) और गलत व्यवहार (खुर) पर उतर आता है।
            वह दूसरों को अपने रुतबे की पूंछ से मारता है और अपने घमंड के सींगों से उनकी भावनाओं को फाड़ देता है।
            यह वह स्थिति है जहाँ अज्ञान पूरी तरह से बेशर्म होकर अपनी असली जंगली फितरत को बाहर निकाल देता है।
            अहंकार जब मर रहा होता है, तो वह अपने आस-पास की हर अच्छी चीज़ को नष्ट करना चाहता है।
        """.trimIndent(),
    english = """
            (The Buffalo's Attack): "Manifesting strictly in his true, terrifying buffalo form, Mahishasura initiated a lethal assault on the Goddess's divine troops."
            "He aggressively crushed several warriors to the dirt utilizing the devastating force of his heavy snout."
            "He violently kicked and forcefully launched other divine soldiers entirely out of the battlefield using his massive hooves."
            "Many warriors were brutally battered and completely bloodied precisely by the terrifying whipping strikes of his iron-like tail."
            "And the remaining troops were mercilessly ripped apart and violently slaughtered by his razor-sharp horns."
            Here, Mahishasura's snout, hooves, tail, and horns flawlessly symbolize a human's blind, raw, and toxic animalistic instincts.
            When the toxic ego begins to lose, it completely abandons logic, utilizing foul language (snout) and abusive behavior (hooves).
            It aggressively strikes innocent people with the tail of its fake status and rips their emotions apart using the horns of arrogance.
            This represents the exact psychological state where thick ignorance becomes completely shameless and exposes its true wild nature.
            When toxic arrogance is dying, it desperately attempts to violently destroy every pure, good thing around it.
        """.trimIndent()
),
SaptshatiShloka(
id = 22,
sanskrit = "वेगेन कांश्चिदपरान्नादेन भ्रमणेन च ।\nनिश्वासपवनेनान्यान् पातयामास भूतले ॥ २३ ॥",
hindi = """
            (वेग और नाद से प्रहार): "महिषासुर ने केवल अंगों से ही नहीं, बल्कि अपनी भयंकर 'रफ्तार' से भी कई योद्धाओं को रौंद डाला।"
            "उसने इतनी ज़ोर से 'गर्जना' की, कि उस खौफनाक आवाज़ से ही कई गणों के प्राण निकल गए और वे ज़मीन पर गिर पड़े।"
            "वह रणभूमि में पागलों की तरह गोल-गोल 'घूमने' लगा, जिससे पैदा हुए भंवर ने कई सैनिकों को उड़ा दिया।"
            "और जो बचे थे, उन्हें उसने अपनी 'सांसों की भयंकर आंधी' से ही धरती पर पटक दिया।"
            रफ्तार, गर्जना, घूमना, और सांसों की आंधी—ये ईगो के चार साइकोलॉजिकल हथियार हैं।
            रफ्तार का मतलब है बिना सोचे-समझे जल्दबाज़ी में गलत फैसले लेना, जो आस-पास के लोगों को रौंद देता है।
            गर्जना का अर्थ है दूसरों पर चिल्लाकर उन्हें डराना और अपनी झूठी ताकत को साबित करने की कोशिश करना।
            घूमना इंसान के उस 'कन्फ्यूजन' का प्रतीक है, जहाँ वह अपनी ही उलझनों में गोल-गोल घूमकर सबको परेशान करता है।
            और सांसों की आंधी वह नेगेटिव वाइब है जो एक घमंडी इंसान सिर्फ अपनी मौजूदगी से दूसरों पर डालता है।
            अहंकार अब अपने विनाश के बिल्कुल अंतिम चरम पर पहुँचकर अपनी पूरी ताकत का तमाशा दिखा रहा है।
        """.trimIndent(),
english = """
            (Attack by Speed and Roar): "Mahishasura did not merely attack physically; he actively crushed numerous warriors utilizing his terrifying speed."
            "He aggressively executed a deafening roar, and that exceptionally horrifying sound alone killed many troops instantly."
            "He violently began spinning rapidly like a maniac in the battlefield, creating a massive vortex that blew soldiers away."
            "And those who survived were ruthlessly slammed to the ground strictly by the apocalyptic storm of his breath."
            Speed, Roar, Spinning, and Breath flawlessly represent the four toxic psychological weapons utilized by the dying ego.
            Speed translates to making aggressive, impulsive, wrong decisions that blindly crush the people around you.
            The Roar symbolizes aggressively shouting at innocent people to terrorize them and explicitly prove a fake dominance.
            Spinning perfectly represents that human confusion where a toxic mind spirals in circles, disturbing everyone in its radius.
            And the storm of breath is undeniably that heavy toxic energy a highly arrogant human radiates purely through his presence.
            The thick ignorance has now successfully reached its absolute extreme peak, aggressively executing a desperate exhibition of power.
        """.trimIndent()
),
SaptshatiShloka(
id = 23,
sanskrit = "निपात्य प्रमथानीकमभ्यधावत सोऽसुरः ।\nसिंहं हन्तुं महादेव्याः कोपं चक्रे ततोऽम्बिका ॥ २४ ॥",
hindi = """
            (अम्बिका का क्रोध): "देवी की सेना को इस प्रकार ज़मीन पर गिराने के बाद, वह भयंकर राक्षस महिषासुर आगे बढ़ा।"
            "उसने अपना पूरा ध्यान माता के परम वाहन 'सिंह' (शेर) की ओर केंद्रित कर दिया।"
            "और वह उस दिव्य शेर को जान से मारने के इरादे से उसकी तरफ भयंकर तेज़ी से दौड़ पड़ा!"
            "अपने प्रिय वाहन और धर्म के प्रतीक शेर पर इस प्रकार महिषासुर को हमला करते हुए देखकर।"
            "साक्षात् परम जगन्माता 'अम्बिका' (महामाया) के भीतर अत्यंत भयंकर और प्रलयंकारी क्रोध उत्पन्न हो गया!"
            यह श्लोक दिखाता है कि भगवान आपके अज्ञान को तब तक सहते हैं जब तक वह आप तक सीमित रहता है।
            परंतु जब आपका भारी अहंकार सीधे 'धर्म और सच्चाई' (शेर) को नष्ट करने की कोशिश करता है।
            तब परम चेतना (अम्बिका) का 'रिएक्टिव क्रोध' (Reactive Wrath) जागृत हो जाता है।
            शेर वह साहस है जो इंसान को साधना के मार्ग पर आगे बढ़ाता है, और ईगो उस साहस को मारना चाहता है।
            माता का क्रोध कोई साधारण गुस्सा नहीं है; यह ब्रह्मांडीय संतुलन को वापस लाने वाली ऊर्जा है।
        """.trimIndent(),
english = """
            (Ambika's Wrath): "After aggressively dropping the Goddess's divine troops to the physical dirt, the massive demon advanced."
            "He violently shifted his complete absolute focus directly towards the Mother's supreme vehicle, the Lion."
            "And he sprinted with terrifying blinding speed explicitly with the pure intention to slaughter that divine Lion!"
            "Vividly witnessing Mahishasura aggressively execute a direct lethal attack upon Her beloved vehicle of Dharma."
            "An exceptionally terrifying, apocalyptic, and purely destructive wrath instantaneously manifested inside the Supreme Mother Ambika!"
            This specific verse proves that God actively tolerates your thick ignorance only until it remains limited to yourself.
            However, exactly when your heavy toxic Ego aggressively attempts to physically destroy Dharma and Truth (Lion).
            That is the exact precise moment the Reactive Wrath of the Supreme Consciousness fully and forcefully awakens.
            The Lion perfectly symbolizes that pure courage which actively drives a human on the spiritual path.
            The Mother's wrath is absolutely zero ordinary human anger; it is the pure cosmic energy restoring universal balance.
        """.trimIndent()
),
SaptshatiShloka(
id = 24,
sanskrit = "सोऽपि कोपान्महावीर्यः खुरक्षुण्णमहीतलः ।\nशृङ्गाभ्यामुच्चिचिक्षेप गिरींश्चन्नाद चोच्चकैः ॥ २५ ॥",
hindi = """
            (पहाड़ों को उछालना): "उधर माता को क्रोधित देखकर, वह महा-पराक्रमी महिषासुर भी भयंकर क्रोध से पागल हो उठा।"
            "उसने गुस्से में आकर अपने भारी खुरों से धरती पर इतनी ज़ोर से प्रहार किया कि ज़मीन कटने और फटने लगी।"
            "उसने अपनी पूरी पाश्विक ताकत का इस्तेमाल करते हुए अपनी सींगों से बड़े-बड़े पहाड़ों को उखाड़ लिया।"
            "और उन विशाल पर्वतों को हवा में बहुत ऊँचाई तक उछाल कर देवी की तरफ फेंकने लगा!"
            "पहाड़ों को उछालते हुए वह राक्षस अत्यंत खौफनाक और कान फाड़ देने वाली गर्जना कर रहा था।"
            यह ईगो का 'विनाशकारी फ्रस्ट्रेशन' (Destructive Frustration) है जब उसे लगता है कि सत्ता उसके हाथ से फिसल रही है।
            खुरों से ज़मीन फाड़ना मतलब अपनी ही 'फाउंडेशन' (Reality) को गुस्से में आकर नष्ट कर देना।
            पहाड़ों को सींगों से उछालना इंसान के उस घमंड का प्रतीक है जो बड़ी-बड़ी बातों को उछाल कर दूसरों को डराना चाहता है।
            जब अज्ञानी इंसान हारता है, तो वह अपने आस-पास के माहौल को खराब करता है और अपनी झूठी ताकत की गर्जना करता है।
            परंतु सत्य के सामने पहाड़ों को उछालने वाला यह ईगो महज़ एक तमाशा कर रहा है।
        """.trimIndent(),
english = """
            (Tossing the Mountains): "Witnessing the Mother's wrath, that exceptionally powerful demon also went completely insane with rage."
            "In sheer frustration, he aggressively stomped his heavy hooves strictly upon the earth so brutally that the ground shattered."
            "Actively utilizing his absolute maximum raw animalistic force, he violently uprooted colossal mountains with his horns."
            "And he aggressively launched those massive mountains exceptionally high into the physical sky, directly towards the Goddess!"
            "While actively tossing the mountains, that monster relentlessly executed a horrifying, ear-shattering, demonic roar."
            This perfectly symbolizes the toxic Ego's Destructive Frustration exactly when it realizes absolute power is rapidly slipping away.
            Shattering the ground with hooves explicitly translates to aggressively destroying your own foundational reality in blind anger.
            Tossing massive mountains with horns perfectly represents arrogant humans hurling massive fake claims to terrorize others.
            When a highly ignorant human loses, he aggressively pollutes his surrounding environment and roars to fake his dominance.
            However, directly in front of the Supreme Truth, this mountain-tossing toxic ego is merely executing a pathetic circus.
        """.trimIndent()
),
SaptshatiShloka(
id = 25,
sanskrit = "वेगभ्रमणविक्षुण्णा मही तस्य व्यशीर्यत ।\nलाङ्गूलेनाहतश्चाब्धिः प्लावयामास सर्वतः ॥ २६ ॥",
hindi = """
            (पृथ्वी और समुद्र का कांपना): "वह राक्षस इतनी तेज़ गति से रणभूमि में गोल-गोल घूमने लगा कि उसके वेग से धरती बुरी तरह कटकर छिन्न-भिन्न हो गई।"
            "ज़मीन के टुकड़े-टुकड़े हो गए और वह पूरी तरह से तहस-नहस हो गई।"
            "उसने अपनी भयंकर पूंछ से महासागर (समुद्र) पर इतनी ज़ोर से प्रहार किया कि पानी उफान मारने लगा।"
            "और समुद्र का पानी अपनी सीमाएं तोड़कर चारों तरफ फैलने लगा, जिससे भयंकर बाढ़ आ गई!"
            जब इंसान का घमंड (महिषासुर) आउट ऑफ कंट्रोल हो जाता है, तो वह अपनी 'मही' (ज़मीन/आधार) को ही नष्ट कर देता है।
            गोल-गोल घूमना इंसान के उस बेलगाम व्यवहार को दर्शाता है जो उसके खुद के जीवन के स्ट्रक्चर (धरती) को तोड़ देता है।
            'समुद्र' इंसान की 'भावनाओं' (Emotions) का प्रतीक है, जो आमतौर पर अपनी मर्यादा में रहता है।
            परंतु जब ईगो अपनी पूंछ (रुतबा) भावनाओं पर मारता है, तो इंसान भावनात्मक रूप से अनस्टेबल (Unstable) हो जाता है।
            समुद्र का उफान मारना यह बताता है कि अज्ञानी व्यक्ति अपने आस-पास के लोगों को भी भावनात्मक बाढ़ में डुबो देता है।
            यह अंधकार की वह चरम सीमा है जो प्रकृति के हर नियम को तोड़ना चाहती है।
        """.trimIndent(),
english = """
            (Trembling of Earth and Ocean): "That demon began spinning in the battlefield with such terrifying speed that the earth was brutally shattered."
            "The ground was literally ripped into microscopic pieces and became completely devastated by his sheer momentum."
            "He struck the cosmic ocean so violently with his massive tail that the waters began to aggressively boil and rise."
            "The ocean permanently broke its natural boundaries, overflowing in all directions and causing an apocalyptic flood!"
            When human arrogance spins completely out of control, it aggressively destroys its own foundational earth (Reality).
            Spinning in circles demonstrates the reckless behavior of a toxic mind that shatters the very structure of its own life.
            The 'Ocean' mathematically symbolizes deep human 'Emotions', which naturally peacefully remain within their strict limits.
            But when the Ego violently strikes these emotions with the tail of status, the human becomes entirely emotionally unstable.
            The overflowing ocean proves that an ignorant person drowns everyone around him in a toxic emotional flood.
            This represents the absolute extreme limit of dark ignorance attempting to break every fundamental rule of nature.
        """.trimIndent()
),
SaptshatiShloka(
id = 26,
sanskrit = "धुतशृङ्गविभिन्नाश्च खण्डं खण्डं ययुर्घनाः ।\nश्वासानिलास्ताः शतशो निपेतुर्नभसो गिरयः ॥ २७ ॥",
hindi = """
            (बादलों का फटना): "उस महिषासुर ने अपने सींगों को इतनी ज़ोर से हिलाया कि आकाश में छाए हुए काले बादल बुरी तरह फट गए।"
            "सींगों के प्रहार से वे बादल कटकर टुकड़े-टुकड़े (खण्डं खण्डं) हो गए और हवा में बिखर गए।"
            "राक्षस के नथुनों से निकलने वाली भयंकर 'सांसों की आंधी' इतनी शक्तिशाली थी कि उसका वेग आसमान तक पहुँच गया।"
            "और उस सांस की आंधी से टकराकर, सैकड़ों विशाल पर्वत आसमान से टूटकर ज़मीन पर गिरने लगे!"
            बादल (Clouds) इंसान के 'विचारों की शीतलता' और 'ज्ञान' का प्रतीक होते हैं।
            जब ईगो अपने सींग (घमंड) हिलाता है, तो वह इंसान के दिमाग की सारी शांति और समझदारी (बादलों) को फाड़ कर रख देता है।
            आसमान से पहाड़ों का गिरना—यह उस मानसिक प्रलय (Mental Chaos) का प्रतीक है जहाँ इंसान को लगता है कि आसमान टूट पड़ा है।
            अहंकार की सांस (Toxic vibes) इतनी भारी होती है कि वह बड़े-बड़े स्थापित सिद्धांतों (पर्वतों) को भी गिरा देती है।
            महिषासुर अब अपनी ताकत का ऐसा अंधा प्रदर्शन कर रहा है जिसका कोई वास्तविक उद्देश्य (Purpose) नहीं है।
            यह डिस्ट्रक्शन केवल देवी की नज़र में उसकी मौत को और जल्दी बुलाने का काम कर रहा है।
        """.trimIndent(),
english = """
            (Tearing of Clouds): "Mahishasura violently shook his razor-sharp horns with such apocalyptic force that the dark clouds in the sky ruptured."
            "Struck by his horns, those massive clouds were ruthlessly sliced into microscopic pieces and scattered across the atmosphere."
            "The terrifying storm of breath aggressively escaping his nostrils was so monumentally powerful that its velocity reached the high heavens."
            "And violently struck by that toxic breath, hundreds of colossal mountains shattered and began raining down from the sky!"
            Clouds purely symbolize the gentle coolness of thoughts and the presence of deep inner wisdom.
            When the Ego tosses its horns of arrogance, it violently rips apart all the peace and understanding within the human brain.
            Mountains falling from the sky seamlessly represent a state of complete Mental Chaos where the world seems to be collapsing.
            The breath of toxic ego is so physically heavy that it aggressively knocks down firmly established moral principles (Mountains).
            Mahishasura is actively executing a completely blind exhibition of sheer power that holds absolutely zero actual purpose.
            This mindless destruction is strictly acting exclusively as a catalyst to accelerate his inevitable death by the Goddess.
        """.trimIndent()
),
SaptshatiShloka(
id = 27,
sanskrit = "इति क्रोधसमाध्मातमापतन्तं महासुरम् ।\nदृष्ट्वा सा चण्डिका कोपं तद्वधाय तदाकरोत् ॥ २८ ॥",
hindi = """
            (चण्डिका का संकल्प): "इस प्रकार क्रोध से बुरी तरह धधकते हुए और दुनिया का विनाश करते हुए उस महा-राक्षस को अपनी ओर आते देखकर।"
            "साक्षात् परम देवी 'चण्डिका' (महामाया) ने उसके पूर्ण विनाश का संकल्प ले लिया।"
            "और उस महिषासुर का हमेशा के लिए वध करने के लिए माता ने अपने भीतर अत्यंत भयंकर क्रोध को जाग्रत कर लिया!"
            यहाँ देवी को पहली बार 'चण्डिका' (Chandika) के नाम से संबोधित किया गया है।
            'चण्ड' का अर्थ होता है अत्यंत उग्र (Fierce), जो किसी भी बुराई को बर्दाश्त नहीं करता।
            जब अज्ञान (महिषासुर) ब्रह्मांड के नियमों को तोड़ने लगता है, तो परम शांति (अम्बिका) को उग्र रूप (चण्डिका) धारण करना ही पड़ता है।
            देवी का यह क्रोध कोई नकारात्मक भावना नहीं है; यह एक 'सर्जिकल टूल' (Surgical Tool) है।
            जिस तरह कैंसर को काटने के लिए एक तेज़ ब्लेड की ज़रूरत होती है, उसी तरह ईगो को काटने के लिए दिव्य क्रोध की आवश्यकता होती है।
            माता ने अब महिषासुर को कोई मौका न देने का अंतिम फैसला कर लिया है।
            युद्ध अब अपने चरम क्लाइमेक्स (Climax) की ओर बढ़ चुका है।
        """.trimIndent(),
english = """
            (Chandika's Resolve): "Visually witnessing that massive mega-demon aggressively rushing towards Her, completely engulfed in destructive blazing rage."
            "The absolute Supreme Goddess 'Chandika' (Mahamaya) firmly established the unshakeable cosmic resolve for his total annihilation."
            "And strictly to permanently slaughter Mahishasura forever, the Mother actively manifested an exceptionally terrifying wrath within Herself!"
            Right exactly here, for the very first time, the Goddess is formally addressed as 'Chandika'.
            'Chanda' strictly translates to extremely Fierce, representing the absolute cosmic force that tolerates absolutely zero evil.
            When thick ignorance completely shatters universal laws, Supreme Peace (Ambika) unconditionally must assume a destructive format (Chandika).
            The Goddess's divine wrath is absolutely zero negative emotion; it is purely an advanced cosmic Surgical Tool.
            Just as removing cancer perfectly requires a razor-sharp blade, completely severing the toxic ego requires pure divine wrath.
            The Mother has now made the absolute ultimate decision to offer zero further chances to Mahishasura.
            The cosmic war has flawlessly accelerated straight into its most terrifying, ultimate, and final Climax.
        """.trimIndent()
),
SaptshatiShloka(
id = 28,
sanskrit = "सा क्षिप्त्वा तस्य वै पाशं तं बबन्ध महासुरम् ।\nतत्याज माहिषं रूपं सोऽपि बद्धो महामृधे ॥ २९ ॥",
hindi = """
            (पाश का प्रहार और रूप बदलना): "देवी चण्डिका ने तुरंत अपना अजेय 'पाश' (रस्सी / Noose) फेंका और उस महा-राक्षस को कसकर बांध लिया।"
            "उस महासंग्राम (महामृधे) में देवी के पाश से बुरी तरह बंध जाने के बाद, महिषासुर पूरी तरह से फँस गया।"
            "पाश से बंधते ही, उस मायावी राक्षस ने तुरंत ही अपना वह 'भैंसे का रूप' (माहिषं रूपं) छोड़ दिया!"
            'पाश' (Noose) तन्त्र में 'नियंत्रण' (Control) और 'माया के बंधन' का प्रतीक है।
            जब इंसान का घमंड (भैंसा) बहुत ज़्यादा उछलने लगता है, तो परम चेतना उस पर परिस्थितियों का 'पाश' डाल देती है।
            पाश से बंधने का मतलब है कि अब ईगो अपनी आज़ादी खो चुका है और भगवान की पकड़ में आ गया है।
            परंतु ईगो इतनी आसानी से हार नहीं मानता; वह 'शेप-शिफ्टर' (Shape-shifter) होता है।
            जैसे ही देवी ने उसके भैंसे (अंधे हठ) वाले रूप को बांधा, उसने तुरंत अपना रूप बदल लिया।
            यह मनोविज्ञान का नियम है: जब आपकी एक बुरी आदत पकड़ी जाती है, तो दिमाग तुरंत खुद को बचाने के लिए दूसरा बहाना (नया रूप) बना लेता है।
            महिषासुर अब बचने के लिए अपनी मायावी शक्तियों का अंतिम प्रयोग कर रहा है।
        """.trimIndent(),
english = """
            (The Noose and Shape-shifting): "Goddess Chandika instantaneously hurled Her invincible 'Pasha' (Noose) and tightly bound that massive mega-demon."
            "Brutally captured and entirely tied down by the divine noose in that apocalyptic cosmic war, Mahishasura was completely trapped."
            "The exact split-second he was bound, the deceptive monster instantaneously abandoned his primary 'Buffalo Form'!"
            The 'Pasha' (Noose) flawlessly translates in advanced Tantra to absolute Control and the binding power of Maya.
            When human arrogance (the Buffalo) aggressively jumps out of control, Supreme Consciousness throws the noose of strict circumstances upon it.
            Being bound by the noose proves that the Ego has completely lost its false freedom and is permanently trapped in God's grip.
            However, the toxic ego never yields easily; it is fundamentally an advanced psychological Shape-shifter.
            The exact moment the Goddess restricted his blind stubbornness, he instantly modified his visual appearance to escape.
            This is a pure rule of psychology: when one bad habit is exposed, the brain instantaneously fabricates a new excuse (new form) to survive.
            Mahishasura is now actively utilizing his absolute final deceptive illusions entirely to escape certain death.
        """.trimIndent()
),
SaptshatiShloka(
id = 29,
sanskrit = "ततः सिंहोऽभवत्सद्यो यावत्तस्याम्बिका शिरः ।\nछिनत्ति तावत्पुरुषः खड्गपाणिरदृश्यत ॥ ३० ॥",
hindi = """
            (शेर और पुरुष का रूप): "भैंसे का रूप छोड़ते ही, वह राक्षस तुरंत एक भयंकर 'शेर' (सिंहोऽभवत्सद्यो) बन गया!"
            "माता अम्बिका ने जैसे ही उस शेर का सिर काटने के लिए अपना शस्त्र उठाया।"
            "उसी क्षण (यावत्... तावत्), वह राक्षस शेर का रूप छोड़कर हाथ में 'तलवार लिए हुए एक पुरुष' (पुरुषः खड्गपाणि) बन गया!"
            यह ईगो के मल्टीपल पर्सनालिटीज़ (Multiple Personalities) का सबसे सटीक वर्णन है।
            भैंसा 'जड़ता' (Tamas) का प्रतीक था। जब देवी ने जड़ता को बांधा, तो ईगो तुरंत 'शेर' (Rajas/Aggression) बन गया।
            शेर बनकर वह दिखाना चाहता था कि मैं बहुत साहसी और सही हूँ। पर माता ने उसे भी पकड़ लिया।
            जब शेर का रूप भी कटने लगा, तो वह 'हाथ में तलवार लिए पुरुष' (Human with logic) बन गया।
            पुरुष का रूप इंसान के उस 'तर्क और चालाकी' (Intellect) का प्रतीक है जो हारने पर लॉजिक (तलवार) का सहारा लेता है।
            अहंकार अपनी जान बचाने के लिए बार-बार अपने मुखौटे (Masks) बदल रहा है।
            परंतु महामाया की नज़र से अज्ञान का कोई भी मुखौटा बच नहीं सकता।
        """.trimIndent(),
english = """
            (Form of Lion and Man): "The exact moment he abandoned the buffalo form, the monster instantaneously transformed into a terrifying 'Lion'!"
            "However, the absolute precise split-second Mother Ambika raised Her weapon strictly to sever that Lion's head."
            "He instantly abandoned the Lion form and dynamically manifested as a 'Human Man gripping a Sword'!"
            This is undeniably the absolute most precise definition of the toxic Ego's deceptive Multiple Personalities.
            The Buffalo symbolized heavy inertia (Tamas). When the Goddess bound it, the ego instantly became a 'Lion' (Rajas/Aggression).
            By becoming a lion, it falsely attempted to project courage and righteousness. But the Mother caught that too.
            When the lion form was about to be destroyed, it morphed into a 'Man with a sword' (Human logic and intellect).
            The human form perfectly symbolizes that cunning intellect which utilizes cheap logic (the sword) to aggressively defend itself.
            The dying arrogance is desperately changing its fake masks exclusively to survive the cosmic slaughter.
            However, absolutely zero deceptive masks of thick ignorance can possibly hide from Mahamaya's perfect vision.
        """.trimIndent()
),
SaptshatiShloka(
id = 30,
sanskrit = "तत एवाशु पुरुषं देवी चिच्छेद सायकैः ।\nतं खड्गचर्मणा सार्धं ततः सोऽभून्महागजः ॥ ३१ ॥",
hindi = """
            (हाथी का रूप): "उस पुरुष को देखते ही, देवी ने अत्यंत तेज़ी (आशु) से अपने अचूक बाण चलाए।"
            "और माता ने उस पुरुष के रूप को उसकी तलवार (खड्ग) और ढाल (चर्म) के साथ ही तुरंत काट डाला (चिच्छेद)!"
            "अपने पुरुष रूप को भी कटते हुए देखकर, वह राक्षस तुरंत एक 'विशालकाय हाथी' (महागजः) के रूप में बदल गया!"
            देवी ने ईगो के लॉजिक (तलवार), उसके डिफेन्स (ढाल), और उसकी चालाकी (पुरुष रूप) तीनों को एक साथ नष्ट कर दिया।
            जब इंसान के पास बचने का कोई तर्क या बहाना नहीं बचता, तो वह 'महागज' (विशाल हाथी) बन जाता है।
            हाथी यहाँ 'अत्यधिक ज़िद और भारीपन' (Colossal Stubbornness) का प्रतीक है।
            वह यह दर्शाना चाहता है कि मैं इतना बड़ा हूँ कि तुम मुझे हिला नहीं सकते।
            ईगो जब हारने लगता है, तो वह खुद को बहुत विशाल और महत्वपूर्ण (Important) दिखाने की कोशिश करता है।
            परंतु सत्य के सामने कोई भी रूप, चाहे वह कितना भी बड़ा क्यों न हो, केवल एक भ्रम (Illusion) है।
            यह महिषासुर का आखिरी से पहला रूप है।
        """.trimIndent(),
english = """
            (Form of the Elephant): "Instantly spotting that human form, the Goddess rapidly unleashed Her infallible arrows."
            "And the Mother flawlessly severed that exact human form entirely, completely destroying his sword and shield simultaneously!"
            "Visually witnessing his human disguise brutally shattered, that monster instantly transformed into a 'Colossal Elephant'!"
            The Goddess completely permanently annihilated the Ego's logic (Sword), its defense (Shield), and its cunningness (Human form).
            Exactly when a human possesses absolutely zero valid logic or excuses to escape, he transforms into a 'Maha-gaja' (Giant Elephant).
            The Elephant flawlessly symbolizes exceptional pure 'Colossal Stubbornness' and absolute heavy inertia.
            It aggressively attempts to falsely project that it is too massive and important to be moved or destroyed.
            When the toxic ego loses, it desperately attempts to project an illusion of extreme supreme self-importance.
            However, directly in front of Absolute Truth, any physical form, regardless of its size, is strictly a cheap illusion.
            This undeniably marks Mahishasura's penultimate desperate physical transformation.
        """.trimIndent()
),
SaptshatiShloka(
id = 31,
sanskrit = "करेण च महासिंहं तं चकर्ष ररास च ।\nकर्षतस्तु करं देवी खड्गेन निरकृन्तत ॥ ३२ ॥",
hindi = """
            (हाथी की सूंड का कटना): "हाथी बनते ही, उस राक्षस ने अपनी लंबी 'सूंड' (करेण) से माता के विशाल शेर (महासिंहं) को पकड़ लिया!"
            "वह शेर को अपनी ओर भयंकर रूप से खींचने (चकर्ष) लगा और ज़ोर-ज़ोर से चिंघाड़ने (ररास च) लगा।"
            "परंतु शेर को अपनी ओर खींचते हुए उस हाथी की 'सूंड' (करं) को देवी ने अपनी तलवार से एक ही झटके में 'काट कर गिरा दिया' (निरकृन्तत)!"
            हाथी की सूंड (Trunk) उस चीज़ का प्रतीक है जिससे इंसान बाहरी दुनिया को 'पकड़ता' (Attachment) है।
            अहंकार (हाथी) ने धर्म (शेर) को अपनी वासना और मोह (सूंड) से पकड़कर अपनी तरफ खींचने की कोशिश की।
            यह दिखाता है कि कैसे बुराई हमेशा अच्छाई को अपनी गंदी आदतों में खींचना चाहती है।
            परंतु परम चेतना (देवी) ने अपनी 'विवेक रूपी तलवार' से उस अटैचमेंट (सूंड) को ही जड़ से काट दिया।
            जब इंसान का मोह (Attachment) कट जाता है, तो उसका अहंकार पूरी तरह से शक्तिहीन हो जाता है।
            सूंड कटने के बाद हाथी (ईगो) दर्द से तड़प उठता है।
            यह आध्यात्मिक यात्रा का वह पड़ाव है जहाँ सांसारिक पकड़ (Grip) टूट जाती है।
        """.trimIndent(),
english = """
            (Severing the Elephant's Trunk): "Upon becoming an elephant, that monster aggressively grabbed the Mother's massive Lion directly with his long trunk!"
            "He violently began dragging the divine Lion towards himself and relentlessly executed ear-shattering, terrifying roars."
            "However, exactly while he was actively pulling the Lion, the Goddess cleanly severed his trunk completely using Her sword!"
            The Elephant's Trunk flawlessly symbolizes the exact physical psychological mechanism of 'Attachment' (Grasping the external world).
            The toxic Ego (Elephant) violently attempted to drag Dharma (Lion) into its own darkness strictly utilizing its pure attachment (Trunk).
            This proves mathematically how heavy evil perpetually attempts to drag pure goodness into its own toxic, dirty habits.
            But the Supreme Consciousness cleanly severed that exact root of Attachment explicitly using Her 'Sword of Pure Wisdom'.
            Exactly when a human's blind attachment is permanently severed, his massive ego instantaneously becomes completely powerless.
            With its trunk cleanly cut, the colossal elephant (Ego) violently writhes in absolute pure agony.
            This perfectly marks that advanced spiritual phase where the ego's physical grip on the illusion is shattered forever.
        """.trimIndent()
),
SaptshatiShloka(
id = 32,
sanskrit = "ततो महासुरो भूयो माहिषं वपुरास्थितः ।\nतथैव क्षोभयामास त्रैलोक्यं सचराचरम् ॥ ३३ ॥",
hindi = """
            (पुनः भैंसे का रूप): "सूंड कटने के बाद जब बचने का कोई रास्ता नहीं दिखा, तो वह महा-राक्षस (महासुरो) 'फिर से' (भूयो)।"
            "अपने उसी असली और पुराने 'भैंसे के रूप' (माहिषं वपुरास्थितः) में वापस आ गया!"
            "और उसने भैंसे का रूप धरते ही पहले की तरह ही संपूर्ण 'चराचर त्रिलोकी' (तीनों लोकों) को भयंकर रूप से हिलाना और डराना (क्षोभयामास) शुरू कर दिया!"
            यह ईगो (Ego) का पूरा सर्कल (Full circle) है! जब इंसान के सारे नाटक (शेर, पुरुष, हाथी) खत्म हो जाते हैं।
            तो अंत में वह वापस अपनी सबसे बेसिक और नीच फितरत (भैंसे का रूप) पर आ गिरता है।
            भैंसा इंसान की वह सबसे गहरी, जड़ और अंधकारमय प्रवृत्ति (Core Ignorance) है जिसे बदला नहीं जा सकता।
            अहंकार ने अपने सारे रूप बदल कर देख लिए, पर माता ने हर रूप को काट दिया।
            अब वह समझ गया है कि छुपने का कोई फायदा नहीं, इसलिए वह अपने असली और सबसे बदसूरत रूप में आ गया है।
            त्रिलोकी को हिलाना यह दर्शाता है कि मरता हुआ ईगो अपने आस-पास के हर इंसान की ज़िंदगी नर्क बना देता है।
            अब महामाया इस मूल अज्ञान (Root cause) को जड़ से खत्म करने वाली हैं।
        """.trimIndent(),
english = """
            (Return to the Buffalo Form): "With his trunk severed and absolutely zero escape routes remaining, that mega-demon once again."
            "Violently reverted entirely backward completely into his original, core, absolute 'Buffalo Form'!"
            "And upon assuming the buffalo form, he relentlessly began aggressively shaking and terrorizing the entire three worlds exactly like before!"
            This perfectly perfectly perfectly demonstrates the absolute exact Full Circle of the toxic human Ego! When all dramatic fake masks (Lion, Man, Elephant) fail.
            The human ultimately drops straight backward perfectly into his absolute most basic, lowest, and darkest core nature (The Buffalo).
            The Buffalo strictly symbolizes that absolute deepest, heaviest, completely unchangeable root of pure blind ignorance.
            The Ego desperately tested every single possible camouflage, but the Mother systematically ruthlessly severed every single one.
            Now, actively realizing that hiding is completely mathematically useless, it violently exposes its absolute most ugly, raw form.
            Shaking the three worlds proves that a dying, hopeless toxic ego aggressively turns the lives of everyone around it into pure hell.
            Now, Mahamaya is officially preparing to permanently annihilate this exact Root Cause of ignorance forever.
        """.trimIndent()
),
SaptshatiShloka(
id = 33,
sanskrit = "ततः क्रुद्धा जगन्माता चण्डिका पानमुत्तमम् ।\nपपौ पुनः पुनश्चैव जहासाणरुणाकुला ॥ ३४ ॥",
hindi = """
            (देवी का मदिरा पान और अट्टहास): "महिषासुर की इस ढिठाई को देखकर, पूरे ब्रह्मांड की माता (जगन्माता) चण्डिका अत्यंत क्रोधित (क्रुद्धा) हो उठीं!"
            "उन्होंने क्रोध में आकर एक उत्तम दिव्य 'पान' (मदिरा / Divine Wine) पिया।"
            "माता ने वह पान 'बार-बार' (पुनः पुनश्चैव) किया, और मदिरा के प्रभाव से उनकी आँखें बिल्कुल लाल (अरुणाकुला) हो गईं।"
            "और आँखें लाल करके देवी ने रणभूमि में अत्यंत भयंकर 'अट्टहास' (जहासा / खौफनाक हंसी) किया!"
            तन्त्र में यह 'सुरा-पान' (Drinking Wine) साधारण शराब नहीं है; यह 'ब्रह्मानंद' (Cosmic Bliss) और 'परम ऊर्जा' का प्रतीक है।
            जब चेतना (देवी) अज्ञान के अंतिम रूप को मिटाने के लिए तैयार होती है, तो वह अपनी पूरी शक्ति (मदिरा) को खुद में खींच लेती है।
            आँखें लाल होना उस प्रलयंकारी फोकस (Destructive Focus) का प्रतीक है जो अब बिना किसी रहम के वार करेगा।
            माता का 'अट्टहास' (भयंकर हंसी) अहंकार (महिषासुर) के अस्तित्व का सीधा मज़ाक उड़ाना है।
            वह हंसी यह बता रही है कि—"तेरा अंत अब तय है, और तू मेरे सामने महज़ एक धूल का कण है।"
            यह कॉस्मिक ड्रामा (Cosmic Drama) अपने सबसे तीव्र और खौफनाक मोड़ पर है।
        """.trimIndent(),
english = """
            (Drinking Divine Wine and Laughter): "Witnessing this extreme stubbornness of Mahishasura, the Mother of the Universe, Chandika, became aggressively enraged!"
            "In absolute divine wrath, She violently consumed an exceptional, supreme 'Divine Drink' (Cosmic Wine)."
            "The Mother consumed that divine wine 'Repeatedly', and under its pure cosmic influence, Her divine eyes turned completely blood-red."
            "And with Her eyes blazing red, the Goddess executed an exceptionally horrifying, earth-shattering 'Demonic Laugh' in the battlefield!"
            Inside advanced Tantra, this explicit 'Drinking of Wine' is zero ordinary alcohol; it flawlessly symbolizes pure 'Cosmic Bliss' and absolute pure raw energy.
            Exactly when Supreme Consciousness prepares to entirely eradicate the final root of ignorance, it forcefully absorbs absolute complete power (Wine) into itself.
            The blood-red eyes seamlessly symbolize that pure Apocalyptic Focus which will explicitly strike with absolutely zero mercy.
            The Mother's terrifying laughter is the direct explicit cosmic mockery of the toxic Ego's pathetic existence.
            That absolute laugh mathematically translates to: "Your death is mathematically certain, and you are literally a speck of dust before Me."
            This exact cosmic drama has flawlessly reached its absolute most intense and utterly terrifying pure climax.
        """.trimIndent()
),
SaptshatiShloka(
id = 34,
sanskrit = "ननर्द चासुरः सोऽपि बलवीर्यमदोद्धतः ।\nविषाणाभ्यां च चिक्षेप चण्डिकां प्रति भूधरान् ॥ ३५ ॥",
hindi = """
            (राक्षस का प्रहार): "उधर देवी को हंसता हुआ देखकर, वह महिषासुर भी अपने 'बल और पराक्रम के घमंड में अंधा होकर' (बलवीर्यमदोद्धतः)।"
            "अत्यंत भयंकर आवाज़ में 'गर्जना' (ननर्द) करने लगा!"
            "और उसने पागलों की तरह अपनी दोनों 'सींगों' (विषाणाभ्यां) से बड़े-बड़े पर्वतों (भूधरान्) को उखाड़ना शुरू कर दिया।"
            "तथा उन भारी पर्वतों को वह सीधे देवी चण्डिका की ओर पूरी ताकत से फेंकने लगा (चिक्षेप)!"
            यह अहंकार (Ego) की सबसे बड़ी बेवकूफी (Ignorance) है; वह भगवान की हंसी का मतलब नहीं समझ पाया।
            जब सत्य आपका मज़ाक उड़ाता है, तो ईगो उसे अपना अपमान समझता है और दोगुने जोश से अपनी मूर्खता का प्रदर्शन करता है।
            'बलवीर्यमदोद्धतः'—अपनी ही ताकत के नशे में अंधा होना। महिषासुर भूल गया है कि उसकी मौत उसके सामने खड़ी है।
            सींगों से फिर से पर्वत फेंकना यह दिखाता है कि ईगो के पास नए हथियार नहीं बचे हैं; वह अपनी पुरानी और घिसी-पिटी चालें ही दोहरा रहा है।
            अज्ञानी इंसान हमेशा अपने भारी और खोखले तर्कों (पर्वतों) को उछाल कर खुद को सही साबित करना चाहता है।
            परंतु वह नहीं जानता कि वह खुद अपनी मौत के लिए मंच (Stage) तैयार कर रहा है।
        """.trimIndent(),
english = """
            (The Demon's Strike): "On the other side, seeing the Goddess laugh, Mahishasura, completely 'Blind with the toxic intoxication of his own strength and power'."
            "Relentlessly began executing an exceptionally terrifying, ear-shattering 'Roar'!"
            "And like a complete maniac, he began violently uprooting massive, colossal mountains strictly utilizing both his horns."
            "And he aggressively forcefully hurled those unbelievably heavy mountains directly perfectly straight towards Goddess Chandika!"
            This is undeniably the absolute peak stupidity of the toxic Ego; it completely failed to understand the mathematics behind God's laughter.
            When Absolute Truth explicitly mocks you, the ego blindly perceives it as a heavy insult and aggressively doubles its display of pure stupidity.
            'Intoxicated by strength'—Being completely blind to reality. Mahishasura has perfectly forgotten that his literal death is standing right in front of him.
            Tossing mountains again perfectly proves that the ego possesses exactly zero new weapons; it is merely repeating its expired, pathetic old tricks.
            Highly ignorant humans perpetually attempt to hurl their heavy, hollow arguments (Mountains) exclusively to forcefully prove themselves right.
            However, he remains absolutely ignorant that he is explicitly actively setting the final stage exactly for his own permanent slaughter.
        """.trimIndent()
),
SaptshatiShloka(
id = 35,
sanskrit = "सा च तान् प्रहितांस्तेन चूर्णयन्ती शरोत्करैः ।\nउवाच तं मदोद्धूतमुखरागाकुलाक्षरम् ॥ ३६ ॥",
hindi = """
            (देवी के वचन): "महिषासुर द्वारा फेंके गए उन सभी विशाल पर्वतों को परम देवी ने अपने 'तीरों के समूह' (शरोत्करैः) से हवा में ही 'पीसकर चूर्ण' (चूर्णयन्ती) कर दिया!"
            "और फिर माता ने उस राक्षस से कुछ ऐसे वचन कहे (उवाच तं), जो मदिरा के प्रभाव के कारण (मदोद्धूत)।"
            "उनके 'लाल हो चुके मुख' (मुखराग) से अत्यंत 'लड़खड़ाते हुए अक्षरों' (आकुलाक्षरम् / Slurred speech) में निकल रहे थे!"
            पहाड़ों (भारी तर्कों) को तीरों (विवेक) से चूर्ण करना यह साबित करता है कि सत्य के सामने झूठ का कोई वज़न नहीं होता।
            सबसे रहस्यमयी बात यह है कि देवी के शब्द 'लड़खड़ा' (Slurred) रहे हैं!
            तन्त्र के अनुसार, यह कोई नशे का लड़खड़ाना नहीं है; यह 'समाधि' (Samadhi) की वह सर्वोच्च अवस्था है जहाँ 'भाषा और शब्द' (Language) खत्म होने लगते हैं।
            जब परम चेतना (Consciousness) अपने सबसे शुद्ध रूप में आती है, तो दुनियावी शब्द उसका भार नहीं सह पाते।
            माता का चेहरा लाल (मुखराग) है, जो उनके प्रचंड और प्रलयंकारी संकल्प को दर्शा रहा है।
            अब देवी ब्रह्मांड के उस सत्य का उच्चारण करने जा रही हैं जो महिषासुर के अंत की घोषणा करेगा।
            अहंकार अपनी मौत की डिक्री (Decree) सुनने वाला है।
        """.trimIndent(),
english = """
            (The Goddess Speaks): "The Supreme Goddess flawlessly completely 'Pulverized into fine dust' all those massive mountains hurled by Mahishasura perfectly in mid-air using Her arrows!"
            "And then, the Mother explicitly spoke specific words to that monster, which, strictly due to the heavy influence of the divine wine."
            "Erupted directly from Her extremely 'Flushed, blood-red face', emerging in highly 'Slurred, stammering syllables' (Akulaksharam)!"
            Pulverizing mountains (heavy toxic arguments) exactly with arrows (pure wisdom) mathematically proves that lies hold zero weight before Truth.
            The absolutely most profoundly mysterious aspect is that the Goddess's divine words are physically 'Slurring'!
            According to advanced Tantra, this is zero ordinary intoxication; it is the absolute peak state of 'Samadhi' where worldly Language completely collapses.
            When Supreme Consciousness manifests in its absolute purest form, cheap physical words absolutely cannot handle its raw cosmic weight.
            The Mother's face is blazing red, flawlessly reflecting Her purely destructive, apocalyptic resolve.
            Now, the Goddess is officially preparing to physically utter that absolute cosmic truth which will permanently announce Mahishasura's death.
            The toxic ego is about to forcefully strictly listen to its own final death decree.
        """.trimIndent()
),
SaptshatiShloka(
id = 36,
sanskrit = "देव्युवाच ॥ ३७ ॥\nगर्ज गर्ज क्षणं मूढ मधु यावत्पिबाम्यहम् ।\nमया त्वयि हतेऽत्रैव गर्जिष्यन्त्याशु देवताः ॥ ३८ ॥",
hindi = """
            (देवी की चेतावनी): "देवी ने लड़खड़ाती हुई वाणी में कहा: 'अरे मूर्ख (मूढ)! जब तक मैं यह मधु (मदिरा) पी रही हूँ, तब तक तू कुछ क्षण (क्षणं) के लिए और गर्जना कर ले (गर्ज गर्ज)!"
            "क्योंकि जैसे ही मेरा पान पूरा होगा, मैं यहीं इसी रणभूमि (अत्रैव) में तेरा वध कर दूँगी (मया त्वयि हते)!"
            "और तेरे मरते ही, जो देवता आज रो रहे हैं, वे सब के सब अत्यंत शीघ्र (आशु) खुशी से गर्जना (गर्जिष्यन्ति) करने लगेंगे!'"
            यह पूरी दुर्गा सप्तशती का सबसे प्रसिद्ध और शक्तिशाली श्लोक (Iconic Verse) है!
            'गर्ज गर्ज क्षणं मूढ'—भगवान अज्ञान से कहते हैं कि तू थोड़ा और चिल्ला ले, तेरा समय खत्म होने वाला है।
            ईगो (महिषासुर) सोचता है कि उसकी गर्जना (आवाज़/रुतबा) परमानेंट है, पर देवी उसे 'मूढ' (मूर्ख) कहकर उसकी औकात बता रही हैं।
            'यावत्पिबाम्यहम्' (जब तक मैं पी रही हूँ)—जब तक प्रकृति (Nature) शांत है और अपनी ऊर्जा समेट रही है, तभी तक बुराई उछल सकती है।
            बुराई की उम्र सिर्फ 'क्षणं' (एक पल) की होती है।
            और जैसे ही ईगो मरता है, इंसान के अंदर के सात्विक गुण (देवता) खुशी से झूम उठते हैं (गर्जिष्यन्त्याशु देवताः)।
            यह श्लोक सत्य का अंतिम और अमिट 'डेथ वारंट' (Death Warrant) है।
        """.trimIndent(),
english = """
            (The Goddess's Warning): "The Goddess spoke with slurred syllables: 'O absolute fool (Mudha)! Roar and shout for just a brief moment (Kshanam) while I consume this divine wine!"
            "Because exactly the split-second I finish drinking, I will physically slaughter you right here in this exact spot!"
            "And strictly upon your brutal death, the pure Gods who are currently weeping will instantaneously execute absolute roars of supreme joy!'"
            This is undeniably explicitly the absolutely most iconic, powerful, and universally recognized verse in the entire Durga Saptashati!
            'Roar for a moment, fool'—God mathematically explicitly tells thick ignorance: shout a little louder, because your timeline is permanently expiring.
            The toxic ego falsely assumes its loud roar is permanent, but the Goddess actively shatters its illusion by calling it a complete 'Fool'.
            'While I drink'—Evil can only jump and terrorize exactly as long as Mother Nature is peacefully silent, actively absorbing Her cosmic energy.
            The exact total lifespan of pure arrogance is strictly 'Kshanam' (one microscopic moment).
            And exactly when the toxic ego dies, the pure inner virtues (Gods) instantaneously roar with absolute ecstatic joy.
            This flawless verse is the Supreme Truth's absolute, permanent, and entirely inescapable Death Warrant.
        """.trimIndent()
),
SaptshatiShloka(
id = 37,
sanskrit = "ऋषिरुवाच ॥ ३९ ॥\nएवमुक्त्वा समुत्पत्य साऽऽरूढा तं महासुरम् ।\nपादेनाक्रम्य कण्ठे च शूलेनैनमताडयत् ॥ ४० ॥",
hindi = """
            (देवी का प्रहार): "महर्षि मेधा ने कहा: उस महिषासुर को ऐसा कहकर, परम देवी चण्डिका हवा में अत्यंत ऊपर उछल गईं (समुत्पत्य)!"
            "और सीधे उस महा-राक्षस (भैंसे) के ऊपर जाकर चढ़ गईं (आरूढा तं)!"
            "माता ने अपना एक पैर उस भैंसे की 'गर्दन' (कण्ठे) पर रखकर उसे ज़मीन पर बुरी तरह दबा दिया (पादेनाक्रम्य)!"
            "और फिर उसी स्थिति में उन्होंने अपना भयंकर 'शूल' (भाला) उसके शरीर में पूरी ताकत से घोंप दिया (शूलेनैनमताडयत्)!"
            यह देवी का 'फाइनल असॉल्ट' (Final Assault) है! 'समुत्पत्य' (उछलना) मतलब चेतना का सर्वोच्च स्तर पर पहुँचना।
            देवी भैंसे के ऊपर चढ़ गईं—इसका अर्थ है कि सत्य ने अब अज्ञान (Ego) को पूरी तरह से दबा (Suppress) लिया है।
            गर्दन पर पैर रखना (Foot on the neck)—गर्दन वह जगह है जहाँ से इंसान का घमंड (अकड़) सीधा खड़ा होता है।
            माता ने अपने चरण से उसकी 'अकड़' को हमेशा के लिए कुचल दिया।
            ईगो को जब तक गर्दन से न दबाया जाए, वह सिर उठाता रहता है। शूल (भाला) घोंपना 'पेनिट्रेशन ऑफ ट्रुथ' (Penetration of Truth) है।
            महिषासुर अब ज़मीन पर पूरी तरह से लॉक (Pinned down) हो चुका है; वह हिल भी नहीं सकता।
        """.trimIndent(),
english = """
            (The Goddess's Assault): "The Sage declared: Having spoken these exact words, Supreme Goddess Chandika leaped exceptionally high into the sky!"
            "And she crashed down, directly mounting and physically aggressively riding that massive mega-demon buffalo!"
            "The Mother violently placed Her divine foot directly upon the buffalo's exact 'Neck', brutally crushing him entirely to the dirt!"
            "And actively pinning him down, She ruthlessly drove Her terrifying heavy 'Spear' deep into his physical body with absolute force!"
            This is undeniably the Goddess's absolute explicit Final Assault! 'Leaping' physically translates to pure Consciousness reaching its absolute highest peak.
            The Goddess mounting the buffalo explicitly mathematically proves that Absolute Truth has now completely suppressed the thick toxic Ego.
            Placing the foot precisely on the neck—The neck is the exact biological center from where human arrogance and stiffness stand tall.
            The Mother flawlessly completely crushed his 'Stiffness' permanently perfectly utilizing the cosmic weight of Her divine foot.
            Unless toxic ego is brutally pinned by the neck, it continually raises its head. Driving the spear is the ultimate 'Penetration of Truth'.
            Mahishasura is now completely, entirely, perfectly Pinned Down strictly to the dirt; he physically cannot move a single inch.
        """.trimIndent()
),
SaptshatiShloka(
id = 38,
sanskrit = "ततः सोऽपि पदाक्रान्तस्तया निजमुखात्ततः ।\nअर्धनिष्क्रान्त एवासीद् देव्या वीर्येण संवृतः ॥ ४१ ॥",
hindi = """
            (राक्षस का आधा बाहर आना): "देवी के पैर (चरण) के भयंकर भार से बुरी तरह कुचले जाने के कारण (पदाक्रान्तस्तया)।"
            "वह राक्षस महिषासुर अपने ही भैंसे वाले 'मुख' (मुंह) से बाहर निकलने लगा (निजमुखात्ततः)!"
            "परंतु देवी के असीम प्रभाव और ताकत (वीर्येण) से पूरी तरह घिर जाने के कारण (संवृतः)।"
            "वह उस भैंसे के मुख से केवल 'आधा ही बाहर निकल पाया' (अर्धनिष्क्रान्त एवासीद्)!"
            यह मनोविज्ञान (Psychology) का एक अद्भुत रहस्य है! जब ईगो (भैंसा) पूरी तरह से कुचला जाता है, तो इंसान के अंदर की असली 'आत्मा' या 'चेतना' (जो उस अज्ञान में फंसी थी) बाहर निकलने की कोशिश करती है।
            महिषासुर भैंसे के मुंह से इंसान के रूप में बाहर आ रहा है। यह इंसान की वह छटपटाहट है जब उसकी झूठी पहचान (Identity) टूट रही होती है।
            पर वह केवल 'आधा' (Half) ही बाहर आ पाया! क्यों?
            क्योंकि ईगो इतनी गहराई तक जड़ों में बसा होता है कि वह आपको पूरी तरह से मुक्त (Free) नहीं होने देता।
            यह वह दर्दनाक अवस्था है जहाँ इंसान न तो अपना पुराना घमंड (भैंसा) जी पा रहा है, और न ही नई आज़ादी (आधा शरीर) अपना पा रहा है।
            महामाया ने उसे बीच में ही रोक कर उसकी पूर्ण विवशता (Helplessness) को उजागर कर दिया है।
        """.trimIndent(),
english = """
            (The Demon Half-Emerges): "Brutally crushed strictly under the exceptionally terrifying, infinite cosmic weight of the Goddess's foot."
            "That massive demon Mahishasura began aggressively attempting to physically emerge entirely out of his own buffalo mouth!"
            "However, completely surrounded, suppressed, and paralyzed by the Goddess's infinite absolute power."
            "He was strictly only capable of emerging exactly 'Half-way' out of that buffalo's physical mouth!"
            This is an exceptionally profound miracle of advanced Psychology! When the toxic ego (Buffalo) is brutally entirely crushed, the human's actual trapped 'Soul/Consciousness' desperately attempts to escape.
            Mahishasura is aggressively emerging as a human directly from the buffalo's mouth. This flawlessly symbolizes the extreme suffocation of a human when his fake Identity is shattering.
            But he only successfully emerged exactly 'Half-way'! Why?
            Because toxic ego is rooted so deeply inside the biological system that it explicitly physically refuses to let you become completely free.
            This is that exact agonizing phase where a human can neither live his old arrogance (Buffalo) nor successfully embrace his new freedom (Half-body).
            Mahamaya actively intentionally froze him exactly in the middle exclusively to flawlessly expose his absolute pure complete Helplessness.
        """.trimIndent()
),
SaptshatiShloka(
id = 39,
sanskrit = "अर्धनिष्क्रान्त एवासौ युध्यमानो महासुरः ।\nतया महासिना देव्या शिरश्छित्त्वा निपातितः ॥ ४२ ॥",
hindi = """
            (महिषासुर का वध): "आधा शरीर बाहर निकलने के बावजूद (अर्धनिष्क्रान्त एवासौ), वह महा-राक्षस अपनी ज़िद में अभी भी देवी से 'युद्ध कर रहा था' (युध्यमानो)!"
            "तब परम देवी ने अपनी 'विशाल और महान तलवार' (महासिना) को हवा में उठाया।"
            "और उस महिषासुर का 'सिर धड़ से पूरी तरह काटकर' (शिरश्छित्त्वा), उसे हमेशा के लिए ज़मीन पर 'गिरा दिया' (निपातितः)!"
            यही अहंकार का पूर्ण और अंतिम विनाश है! ईगो आधा बाहर आ चुका है, मर रहा है, फिर भी 'युध्यमानो' (लड़ रहा है)।
            बुराई की जड़ें इतनी गहरी होती हैं कि मौत के आखिरी सेकंड तक वह हथियार नहीं डालती।
            अंततः, माता को अपनी 'महा-असि' (Great Sword of Wisdom) का प्रयोग करना पड़ता है।
            तलवार से सिर कटना (Decapitation) मतलब ईगो के 'मैं' (I-ness) को हमेशा के लिए डिलीट कर देना।
            जैसे ही सिर कटा, महिषासुर (अज्ञान/आलस/घमंड) हमेशा के लिए ज़मीन पर गिरकर शांत हो गया।
            अध्याय 2 में जो महायुद्ध शुरू हुआ था, वह यहाँ देवी की परम विजय के साथ समाप्त होता है।
            महिषासुरमर्दिनी (Mahishasuramardini) का रूप यहीं पर अपनी पूर्णता को प्राप्त होता है।
        """.trimIndent(),
english = """
            (The Slaughter of Mahishasura): "Even while physically strictly only half-emerged from the buffalo's mouth, that mega-demon stubbornly continued 'Actively Fighting' the Goddess!"
            "Then, the Supreme Goddess raised Her exceptionally massive, divine 'Great Sword' high into the cosmic sky."
            "And She completely effortlessly, brutally 'Severed his head entirely from his body', dropping him permanently dead to the exact dirt!"
            This undeniably marks the absolute final and total permanent annihilation of the toxic Ego! The ego is dying, half-emerged, yet blindly continues fighting.
            The roots of thick evil are so exceptionally deep that it physically refuses to surrender even inside its absolute final dying second.
            Ultimately, the Mother explicitly unconditionally must utilize Her 'Great Sword of Absolute Wisdom'.
            Severing the head permanently exclusively translates mathematically to permanently Deleting the ego's false sense of 'I-ness' (Identity).
            The exact split-second the head fell, Mahishasura (Pure Ignorance/Laziness/Pride) dropped completely dead to the ground, silenced forever.
            The massive cosmic war initiated in Chapter 2 perfectly flawlessly concludes right exactly here with the Goddess's supreme victory.
            The absolute divine format of 'Mahishasuramardini' (The Slayer of Mahishasura) achieves absolute pure physical completion right here.
        """.trimIndent()
),
SaptshatiShloka(
id = 40,
sanskrit = "ततो हाहाकृतं सर्वं दैत्यसैन्यं ननाश तत् ।\nप्रहर्षं च परं जग्मुः सकला देवतागणाः ॥ ४३ ॥",
hindi = """
            (असुर सेना का नाश और देवताओं का हर्ष): "महिषासुर का सिर कटते ही, बची हुई पूरी की पूरी दैत्य सेना (राक्षस) 'हा-हाकार' (हाहाकृतं / चीखने-चिल्लाने) करने लगी!"
            "और बिना किसी लीडर के, वह पूरी सेना अपने आप ही रणभूमि छोड़कर भाग गई और 'नष्ट' (ननाश तत्) हो गई।"
            "महिषासुर के वध को देखकर, सभी देवताओं के समूह (सकला देवतागणाः) के भीतर एक 'परम हर्ष' (प्रहर्षं च परं / Supreme Joy) छा गया!"
            जब इंसान के अंदर का मुख्य अहंकार (महिषासुर) मर जाता है, तो छोटी-मोटी बुराइयां (बची हुई सेना) खुद-ब-खुद नष्ट हो जाती हैं।
            ईगो ही वह लीडर है जो सारी नेगेटिविटी (Negativity) को बांध कर रखता है। लीडर के मरते ही सब बिखर जाता है।
            'हाहाकृतं'—यह बुराई की वह हार है जहाँ उसके पास केवल रोने और भागने के अलावा कुछ नहीं बचता।
            'परम हर्ष'—जब दिमाग से अज्ञान का बोझ हटता है, तो इंसान के अंदर के अच्छे गुण (देवता) आज़ादी की सांस लेते हैं।
            यह वह 'स्पिरिचुअल रिलीफ' (Spiritual Relief) है जो एक इंसान को भारी डिप्रेशन और ओवरथिंकिंग से बाहर निकलने पर महसूस होता है।
            सत्य की जीत ने पूरे ब्रह्मांड (इंसान के शरीर और मन) में शांति स्थापित कर दी है।
        """.trimIndent(),
english = """
            (Destruction of the Army and Joy of Gods): "The exact split-second Mahishasura's head was severed, the entire remaining demonic army began screaming in absolute pure terror!"
            "And completely leaderless, that entire exact toxic army automatically fled the battlefield and completely 'Perished' into nothingness."
            "Visually witnessing Mahishasura's permanent slaughter, an absolutely pure 'Supreme Joy' completely engulfed the entire assembly of the pure Gods!"
            When the core primary Ego (Mahishasura) inside a human is permanently killed, all minor toxic bad habits (the remaining army) automatically destroy themselves.
            The Ego is the exact explicit leader binding all negativity perfectly together. Once the leader dies, everything completely shatters.
            'Screaming in terror'—This is the absolute defeat of evil where it physically possesses zero options except strictly weeping and actively fleeing.
            'Supreme Joy'—When the colossal weight of ignorance is permanently lifted from the brain, the pure inner virtues (Gods) breathe absolute freedom.
            This is that exact literal 'Spiritual Relief' a human physically experiences exactly when breaking permanently free from heavy depression and overthinking.
            The absolute victory of Supreme Truth has unconditionally actively established permanent pure peace throughout the entire cosmos (body and mind).
        """.trimIndent()
),
SaptshatiShloka(
id = 41,
sanskrit = "तुष्टुवुस्तां सुरा देवीं सह दिव्यैर्महर्षिभिः ।\nजगुर्गुन्धर्वपतयो ननृतुश्चाप्सरोगणाः ॥ ४४ ॥",
hindi = """
            (स्तुति और उत्सव): "तब सभी देवताओं (सुरा) ने मिलकर, दिव्य और महान ऋषियों (महर्षिभिः) के साथ, उस परम देवी की 'स्तुति' (तुष्टुवुस्तां / Praise) करनी शुरू कर दी!"
            "गंधर्वों (स्वर्ग के संगीतकार) के राजाओं ने अत्यंत मधुर स्वर में देवी के विजय गीत 'गाना' (जगुर्गुन्धर्वपतयो) शुरू कर दिया।"
            "और स्वर्ग की सुंदर अप्सराओं के समूहों (अप्सरोगणाः) ने खुशी से झूमते हुए 'नृत्य' (ननृतुश्च / Dance) करना शुरू कर दिया!"
            यह जीत का 'सेलिब्रेशन' (Celebration) है! जब अंदर की लड़ाई खत्म होती है, तो पूरा अस्तित्व खुशी से नाच उठता है।
            ऋषि (Wisdom) और देवता (Senses) मिलकर उस परम शक्ति (देवी) का धन्यवाद कर रहे हैं।
            गंधर्वों का गाना इंसान के अंदर उठने वाले उस 'अनाहत नाद' (Inner Music / Peace) का प्रतीक है जो समाधि में सुनाई देता है।
            अप्सराओं का नृत्य इंसान के जीवन में वापस लौट आई उस 'रचनात्मकता और खुशी' (Creativity and Joy) का प्रतीक है, जो ईगो के कारण खो गई थी।
            यहीं पर श्री मार्कण्डेय पुराण में वर्णित 'सावर्णिक मन्वन्तर' की कथा के अंतर्गत, 'महिषासुर-वध' नामक दुर्गा सप्तशती का तीसरा अध्याय पूर्ण होता है।
            सत्यमेव जयते।
        """.trimIndent(),
english = """
            (Praise and Celebration): "Then, absolutely all the pure Gods, completely alongside the divine and great Sages, actively began strictly 'Praising' the Supreme Goddess!"
            "The supreme kings of the Gandharvas (celestial musicians) instantaneously initiated singing exceptionally beautiful, melodious songs of pure victory."
            "And the massive divine bands of beautiful celestial Apsaras joyfully began executing an ecstatic, beautiful 'Dance'!"
            This flawlessly represents the ultimate cosmic Celebration! When the brutal inner war permanently ends, the entire core existence physically dances with joy.
            The Sages (Wisdom) and Gods (Senses) unite entirely strictly to express profound gratitude exclusively to the Supreme Energy (Goddess).
            The Gandharvas singing flawlessly symbolizes that exact divine 'Inner Music' (Anahata Nada) actively heard strictly inside deep, pure meditation.
            The dancing Apsaras perfectly symbolize the pure return of 'Creativity and Joy' inside human life, which was brutally suppressed by the toxic ego.
            Right exactly here successfully formally concludes the glorious Third Chapter, named 'The Slaughter of Mahishasura', inside the Durga Saptashati.
            Absolute Truth eternally reigns Supreme.
        """.trimIndent()
),
    SaptshatiShloka(
        id = 42,
        sanskrit = "अर्धनिष्क्रान्त एवासौ युध्यमानो महासुरः ।\nतया महासिना देव्या शिरश्छित्त्वा निपातितः ॥ ४२ ॥",
        hindi = """
            (महिषासुर का अंतिम वध): "आधा शरीर बाहर निकलने के बावजूद (अर्धनिष्क्रान्त एवासौ), वह महा-राक्षस महिषासुर।"
            "अपनी ज़िद और अहंकार में अंधा होकर अभी भी परम देवी से 'युद्ध कर रहा था' (युध्यमानो महासुरः)!"
            "तब भगवती महामाया ने अपनी 'विशाल और महान तलवार' (महासिना देव्या) को हवा में उठाया।"
            "और उस महिषासुर का 'सिर धड़ से पूरी तरह काटकर' (शिरश्छित्त्वा), उसे हमेशा के लिए शांत कर दिया।"
            "सिर कटते ही वह अज्ञानी दानव हमेशा के लिए ज़मीन पर 'गिर पड़ा' (निपातितः)!"
            यह दृश्य दर्शाता है कि बुराई की जड़ें इतनी गहरी होती हैं कि वह मौत के आखिरी पल तक लड़ती है।
            ईगो आधा बाहर आ चुका है, मर रहा है, फिर भी वह पूरी तरह से सरेंडर (Surrender) नहीं करना चाहता।
            अंततः, माता को अपनी 'महा-असि' (विवेक और ज्ञान की महान तलवार) का प्रयोग करना ही पड़ता है।
            तलवार से सिर कटना (Decapitation) मतलब ईगो के 'मैं' (I-ness) को जड़ से और हमेशा के लिए डिलीट कर देना।
            जैसे ही सिर कटा, इंसान के अंदर का वह भारी अज्ञान (महिषासुर) हमेशा के लिए ज़मीन पर गिरकर समाप्त हो गया।
        """.trimIndent(),
        english = """
            (The Final Annihilation of Mahishasura): "Even while physically strictly only half-emerged from the buffalo's mouth."
            "That massive mega-demon stubbornly and blindly continued 'Actively Fighting' the Supreme Goddess!"
            "Then, the Supreme Goddess Mahamaya raised Her exceptionally massive, divine 'Great Sword' high."
            "And She completely effortlessly, brutally 'Severed his head entirely from his body' with one strike."
            "The exact split-second his head was severed, he permanently dropped dead to the physical dirt!"
            This undeniably proves that the roots of thick evil refuse to surrender even inside their final dying second.
            The toxic Ego is actively dying, half-emerged, yet it aggressively blindly continues fighting the truth.
            Ultimately, the Mother explicitly unconditionally must utilize Her 'Great Sword of Absolute Wisdom'.
            Severing the head permanently exclusively translates to permanently Deleting the ego's false sense of 'I-ness'.
            Exactly when the head fell, Mahishasura (Pure Ignorance) dropped completely dead to the ground, silenced forever.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 43,
        sanskrit = "ततो हाहाकृतं सर्वं दैत्यसैन्यं ननाश तत् ।\nप्रहर्षं च परं जग्मुः सकला देवतागणाः ॥ ४३ ॥",
        hindi = """
            (असुर सेना का नाश और देवताओं का हर्ष): "महिषासुर का सिर कटते ही और उसे ज़मीन पर मृत गिरते हुए देखकर।"
            "बची हुई पूरी की पूरी दैत्य सेना (राक्षसों की भीड़) भयंकर रूप से 'हा-हाकार' (हाहाकृतं) करने लगी!"
            "और बिना किसी राजा या लीडर के, वह पूरी की पूरी सेना अपने आप ही 'नष्ट' (ननाश तत्) हो गई।"
            "अपने सबसे बड़े शत्रु महिषासुर के इस भयंकर वध को अपनी आँखों से देखकर।"
            "सभी देवताओं के समूह (सकला देवतागणाः) के भीतर एक 'परम हर्ष' (प्रहर्षं च परं) छा गया!"
            जब इंसान के अंदर का मुख्य अहंकार (महिषासुर) मर जाता है, तो छोटी-मोटी बुराइयां अपने आप खत्म हो जाती हैं।
            ईगो ही वह लीडर है जो सारी नेगेटिविटी (Negativity) और बुरी आदतों को एक साथ बांध कर रखता है।
            'हाहाकृतं'—यह बुराई की वह पूर्ण हार है जहाँ उसके पास केवल रोने और भागने के अलावा कोई विकल्प नहीं बचता।
            'परम हर्ष'—जब दिमाग से अज्ञान का भारी बोझ हटता है, तो इंसान के अंदर के अच्छे सात्विक गुण आज़ादी की सांस लेते हैं।
            यह वह 'स्पिरिचुअल रिलीफ' (Spiritual Relief) है जो गहरे डिप्रेशन और अज्ञान से बाहर निकलने पर महसूस होता है।
        """.trimIndent(),
        english = """
            (Destruction of the Army and Joy of Gods): "The exact split-second Mahishasura's head was severed and he dropped dead."
            "The entire remaining demonic army began screaming in absolute pure terror and utter cosmic despair!"
            "And completely leaderless, that entire exact toxic army automatically fled and completely 'Perished' into nothingness."
            "Visually witnessing the permanent slaughter of their absolute greatest and most terrifying enemy."
            "An absolutely pure 'Supreme Joy' completely engulfed the entire assembly of the pure divine Gods!"
            When the core primary Ego (Mahishasura) inside a human dies, all minor toxic bad habits automatically destroy themselves.
            The Ego is the exact explicit leader binding all negativity and dark psychological traits perfectly together.
            'Screaming in terror'—This is the absolute defeat of evil where it physically possesses zero options except weeping.
            'Supreme Joy'—When the colossal weight of ignorance is lifted from the brain, pure inner virtues breathe absolute freedom.
            This is that exact literal 'Spiritual Relief' a human physically experiences when breaking free from heavy toxic depression.
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 44,
        sanskrit = "तुष्टुवुस्तां सुरा देवीं सह दिव्यैर्महर्षिभिः ।\nजगुर्गुन्धर्वपतयो ननृतुश्चाप्सरोगणाः ॥ ४४ ॥\n\n(इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये महिषासुरवधो नाम तृतीयोऽध्यायः ॥ ३ ॥)",
        hindi = """
            (स्तुति और उत्सव): "इस महाविजय के बाद, सभी देवताओं (सुरा) ने मिलकर परम शांति की सांस ली।"
            "और दिव्य तथा महान ऋषियों (महर्षिभिः) के साथ मिलकर, उस परम देवी की भावपूर्ण 'स्तुति' (तुष्टुवुस्तां) करनी शुरू कर दी!"
            "गंधर्वों (स्वर्ग के दिव्य संगीतकार) के राजाओं ने अत्यंत मधुर स्वर में देवी के विजय गीत 'गाना' (जगुर्गुन्धर्वपतयो) शुरू कर दिया।"
            "और स्वर्ग की सुंदर अप्सराओं के समूहों (अप्सरोगणाः) ने खुशी से झूमते हुए 'नृत्य' (ननृतुश्च) करना शुरू कर दिया!"
            यह जीत का सबसे बड़ा 'सेलिब्रेशन' (Celebration) है! जब अंदर की लड़ाई खत्म होती है, तो पूरा अस्तित्व खुशी से नाच उठता है।
            ऋषि (Wisdom) और देवता (Senses) मिलकर उस परम शक्ति (महामाया) का हृदय से धन्यवाद कर रहे हैं।
            गंधर्वों का गाना इंसान के अंदर उठने वाले उस 'अनाहत नाद' (Inner Peace) का प्रतीक है जो समाधि में सुनाई देता है।
            अप्सराओं का नृत्य जीवन में वापस लौट आई उस रचनात्मकता (Creativity) का प्रतीक है, जो ईगो के कारण खो गई थी।
            यहीं पर श्री मार्कण्डेय पुराण में वर्णित दुर्गा सप्तशती का 'महिषासुर-वध' नामक तीसरा अध्याय पूर्ण होता है।
            सत्य की हमेशा जीत होती है (सत्यमेव जयते), और अज्ञान का अंत निश्चित है।
        """.trimIndent(),
        english = """
            (Praise and Celebration): "Following this supreme cosmic victory, absolutely all the pure Gods finally breathed in absolute peace."
            "And completely alongside the divine Sages, they actively began strictly 'Praising' the Supreme Goddess with deep devotion!"
            "The supreme kings of the Gandharvas (celestial musicians) instantaneously initiated singing exceptionally beautiful, melodious songs."
            "And the massive divine bands of beautiful celestial Apsaras joyfully began executing an ecstatic, beautiful 'Dance'!"
            This flawlessly represents the ultimate cosmic Celebration! When the brutal inner war ends, the entire core existence physically dances.
            The Sages (Wisdom) and Gods (Senses) unite entirely strictly to express profound gratitude exclusively to the Supreme Energy.
            The Gandharvas singing flawlessly symbolizes that exact divine 'Inner Music' (Anahata Nada) actively heard inside deep meditation.
            The dancing Apsaras perfectly symbolize the pure return of 'Creativity and Joy' inside human life, previously suppressed by ego.
            Right exactly here successfully formally concludes the glorious Third Chapter, named 'The Slaughter of Mahishasura'.
            Absolute Truth eternally reigns Supreme, and the ultimate destruction of thick dark ignorance is always mathematically certain.
        """.trimIndent()
    )
)