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
fun AdhyayaTenScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val targetId = query.toIntOrNull()
                if (targetId != null) {
                    val targetIndex = adhyayaTenShlokas.indexOfFirst { it.id == targetId }
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
            label = { Text("Search Shloka (1-32)") },
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
            itemsIndexed(adhyayaTenShlokas) { _, shloka ->
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

val adhyayaTenShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ऋषिरुवाच ॥ १ ॥\nनिशुम्भं निहतं दृष्ट्वा भ्रातरं प्राणसम्मितम् ।\nहन्यमानं बलं चैव शुम्भः क्रुद्धोऽब्रवीद्वचः ॥ २ ॥",
        hindi = """
            (शुम्भ का विलाप और क्रोध): "महर्षि मेधा ने कहा: अपने प्राणों के समान प्यारे भाई निशुम्भ को मरा हुआ देखकर।"
            "और अपनी विशाल असुर सेना को इस प्रकार नष्ट होते देख, राजा शुम्भ क्रोध से पागल हो उठा।"
            "निशुम्भ 'ममता' (मेरा-पन) का प्रतीक था, जिसके बिना अहंकार अब बिल्कुल अकेला पड़ गया था।"
            "जब इंसान की पकड़ अपनी प्रिय चीज़ों (Attachments) से छूटती है, तो उसे भयंकर मानसिक पीड़ा होती है।"
            "शुम्भ का यह क्रोध वास्तव में उसकी गहरी असुरक्षा और हताशा का एक हिंसक प्रकटीकरण है।"
            "वह अब तक सेनापतियों और भाई के भरोसे लड़ रहा था, पर अब उसकी अंतिम ढाल टूट चुकी थी।"
            "अहंकार अपनी हार को स्वीकार करने के बजाय अब सीधे 'परम सत्य' को ललकारने लगा है।"
            "यह स्थिति उस 'टॉक्सिक रेजिस्टेंस' को दिखाती है जो अंत समय तक खुद को सही मानती है।"
            "भाई का मरना अहंकार के लिए उसकी अपनी आधी शक्ति के खो जाने जैसा अनुभव था।"
            "यहीं से शुम्भ के अहंकार का वह अंतिम और निर्णायक युद्ध शुरू होता है जो उसे मिटा देगा।"
        """.trimIndent(),
        english = """
            (Shumbha's Lament and Wrath): "The Sage said: Visually witnessing his brother Nishumbha, who was dear as life, slaughtered."
            "And seeing his colossal demonic army being systematically annihilated, Shumbha erupted in apocalyptic rage."
            "Nishumbha symbolized 'Attachment'; without him, the Core Ego now stood entirely isolated and exposed."
            "When a human's grip on their cherished possessions is forcefully severed, it triggers extreme psychological pain."
            "Shumbha's rage is actually a violent manifestation of his deep-seated insecurity and total desperation."
            "He had been fighting through proxies until now, but his absolute final protective shield had shattered."
            "Instead of acknowledging defeat, Arrogance initiates a direct challenge against the absolute Supreme Truth."
            "This reflects that 'Toxic Resistance' which continues to validate its own errors until the very end."
            "The death of his brother felt like the loss of half of his own vital cosmic existence."
            "This initiates the final, decisive war of Shumbha's ego that will lead to his total dissolution."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "गर्वितोऽसि न मैवं त्वं देवि ब्रूहि ममाग्रतः ।\nत्रैलोक्ये कः पुमानन्यः शुम्भनिशुम्भयोः पुरः ॥ ३ ॥",
        hindi = """
            (शुम्भ का अहंकार): "शुम्भ ने चिल्लाकर कहा: 'हे देवी! तुम बहुत घमंडी हो गई हो, मेरे सामने ऐसी बातें मत करो'।"
            "'इन तीनों लोकों में मेरे और निशुम्भ के सामने टिकने की हिम्मत और किस पुरुष में है?'"
            "अहंकार की सबसे बड़ी बीमारी यह है कि वह 'आत्म-विश्वास' को 'घमंड' समझ बैठता है।"
            "शुम्भ को लग रहा है कि देवी केवल अपनी शक्तियों के कारण घमंडी (गर्वितो) व्यवहार कर रही हैं।"
            "वह अभी भी 'पुरुष' और 'स्त्री' के शारीरिक भेद में फँसा है, वह 'चेतना' को नहीं देख पा रहा।"
            "अज्ञानी मन हमेशा अपनी पिछली जीतों को याद करके खुद को सबसे श्रेष्ठ (Unmatched) मानता है।"
            "शुम्भ का यह सवाल उसकी उस संकुचित बुद्धि को दिखाता है जो खुद से बड़ा किसी को नहीं मानती।"
            "वह देवी को चुप कराने की कोशिश कर रहा है, जैसे कोई तानाशाह सच्चाई को दबाना चाहता है।"
            "जब अज्ञान अपनी 'लिमिट' क्रॉस करता है, तो वह भगवान को भी नीचा दिखाने की कोशिश करता है।"
            "यह श्लोक ईगो के उस 'ग्रैंडियोस भ्रम' (Grandiose Delusion) का चरम स्तर प्रदर्शित करता है।"
        """.trimIndent(),
        english = """
            (Shumbha's Arrogance): "Shumbha shouted: 'O Goddess! You have become too proud; do zero to speak thus before me'."
            "'Who else exists in these three worlds as a man capable of standing before Shumbha and Nishumbha?'"
            "The primary disease of Arrogance is that it perpetually mistakes 'Self-confidence' for 'Toxic Pride'."
            "Shumbha falsely believes that the Goddess is merely behaving arrogantly due to Her temporary victories."
            "He remains trapped in the physical distinction of 'Gender', failing to perceive the underlying Infinite Consciousness."
            "The ignorant mind uses its historical successes to validate its claim of being mathematically Unmatched."
            "This inquiry reveals Shumbha's narrow intellect that refuses to acknowledge any power superior to itself."
            "He attempts to silence the Goddess, identically to how a dictator desperately seeks to suppress the Truth."
            "When ignorance exceeds its limits, it even attempts to belittle and humiliate the Supreme Divine."
            "This verse demonstrates the absolute peak of the Ego's pathological and 'Grandiose Delusion' of power."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "बलमवलम्ब्य बाहूनां गर्जसि त्वमतिदुर्लभे ।\nअन्यासां बलमाश्रित्य युध्यसे यातिमानिनी ॥ ४ ॥",
        hindi = """
            (उधार की शक्ति का आरोप): "शुम्भ ने ताना मारा: 'हे अतिमानिनी! तू अपनी भुजाओं के बल पर व्यर्थ ही गरज रही है'।"
            "'तू तो दूसरों की शक्तियों (मातृकाओं) का सहारा लेकर युद्ध कर रही है और खुद पर गर्व कर रही है'।"
            "अहंकार को लगता है कि देवी 'अकेली' कुछ नहीं हैं, वे मातृकाओं के भरोसे बहादुर बन रही हैं।"
            "यह इंसान के उस भ्रम का प्रतीक है जहाँ वह 'एकत्व' (Oneness) को नहीं समझ पाता और भेद देखता है।"
            "शुम्भ को लग रहा है कि मातृकाएं देवी से अलग हैं, जैसे कि वे कोई 'भाड़े के सैनिक' (Mercenaries) हों।"
            "अज्ञानी व्यक्ति हमेशा सफलता का श्रेय किसी बाहरी चीज़ को देकर सत्य को कमज़ोर साबित करना चाहता है।"
            "वह देवी को 'अतिमानिनी' (अत्यधिक घमंडी) कहकर उनके चरित्र पर मानसिक हमला कर रहा है।"
            "अहंकार जब खुद हारने लगता है, तो वह सामने वाले की मेहनत को 'उधार की सफलता' बताने लगता है।"
            "शुम्भ की यह सोच उसकी बुद्धि के पूरी तरह से 'भ्रष्ट' और 'विभाजित' होने का सबसे बड़ा प्रमाण है।"
            "वह नहीं जानता कि वे सभी मातृकाएं वास्तव में उसी एक महामाया का ही अलग-अलग विस्तार हैं।"
        """.trimIndent(),
        english = """
            (Accusation of Borrowed Strength): "Shumbha taunted: 'O Proud One! You are roaring pointlessly based on the strength of Your arms'."
            "'You are fighting by relying on the power of others (Matrikas), yet You take pride in Yourself'."
            "Arrogance deludes itself into thinking the Goddess is 'Alone' and powerless without Her divine mothers."
            "This symbolizes the human inability to comprehend 'Universal Oneness', perceiving only separation and duality."
            "Shumbha assumes the Matrikas are distinct from the Goddess, as if they were merely borrowed Mercenaries."
            "The ignorant mind always tries to weaken Truth by attributing its success to some external variable."
            "By calling Her 'Atimanini', he executes a psychological assault to discredit Her supreme divine character."
            "When the Ego begins to fail, it attempts to label the opponent's achievement as 'Borrowed Success'."
            "Shumbha's logic proves that his intellect is entirely 'Corrupted' and perceives the universe in fragmented pieces."
            "He ignores the reality that those Matrikas are mathematically merely extensions of the singular Mahamaya."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "देव्युवाच ॥ ५ ॥\nएकैवाहं जगत्यत्र द्वितीया का ममापरा ।\nपश्यैता दुष्ट मय्येव विशन्त्यो मद्विभूतयः ॥ ६ ॥",
        hindi = """
            (अद्वैत की घोषणा): "देवी ने सिंह-नाद करते हुए कहा: 'अरे दुष्ट! इस पूरे संसार में केवल 'मैं अकेली' ही हूँ'।"
            "'मेरे सिवा यहाँ दूसरी और कौन हो सकती है? जो कुछ भी है, वह सब मेरा ही स्वरूप है'।"
            "'देख! ये सारी मातृकाएं (शक्तियां) अब मुझमें ही वापस समा रही हैं, क्योंकि ये मेरी ही विभूतियाँ हैं'।"
            "यह पूरी दुर्गा सप्तशती का सबसे 'महान और दार्शनिक' (Philosophical) श्लोक माना जाता है।"
            "देवी यहाँ 'अद्वैत' (Non-duality) का परिचय दे रही हैं—कि ब्रह्मांड में केवल 'एक' ही सत्ता है।"
            "शुम्भ जिसे 'दूसरों की शक्ति' कह रहा था, देवी ने सिद्ध किया कि वे सब उनके अपने ही 'एक्सप्रेशंस' हैं।"
            "दुष्ट (Wicked) संबोधन यह बताता है कि भेद देखना और 'मैं-तू' करना ही सबसे बड़ी बुराई है।"
            "विशन्त्यो (प्रवेश करना)—सारी शक्तियां देवी के शरीर में वापस समा गईं, जो पूर्णता का प्रतीक है।"
            "जब इंसान यह जान लेता है कि 'सब कुछ ईश्वर ही है', तो उसका सारा डर और अहंकार मिट जाता है।"
            "यह घोषणा शुम्भ के उस 'द्वैत' (Duality) के भ्रम को जड़ से उखाड़ फेंकने के लिए काफी थी।"
        """.trimIndent(),
        english = """
            (Declaration of Non-Duality): "The Goddess roared: 'O Wicked One! I alone exist in this entire complete universe'."
            "'Who else besides Me could possibly exist here? Everything that is, is strictly My own form'."
            "'Look! All these Shaktis (Matrikas) are now entering back into Me, for they are My own manifestations'."
            "This is considered the absolute most 'Profound and Philosophical' verse in the entire Durga Saptashati."
            "The Goddess is introducing the concept of 'Advaita'—that there is mathematically only 'One' absolute Reality."
            "What Shumbha labeled as 'Borrowed Power' was proven to be Her own divine and diverse Expressions."
            "Addressing him as 'Wicked' implies that perceiving separation and duality is the root cause of all evil."
            "The merging of Shaktis back into Her body symbolizes the return of all energy to its singular Source."
            "When a human realizes that 'All is God', their personal fear and arrogance are instantaneously annihilated."
            "This declaration was sufficient to uproot the foundation of Shumbha's illusion of Duality and separation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "ततः समस्तास्ता देव्यो ब्रह्माणीप्रमुखा लयम् ।\nतस्या देव्यास्तनौ जग्मुरेकासीत्तदाम्बिका ॥ ७ ॥",
        hindi = """
            (शक्तियों का विलीनीकरण): "तब ब्रह्माणी आदि सभी मातृकाएं देवी चण्डिका के शरीर में पूरी तरह विलीन (लयम्) हो गईं।"
            "उस रणभूमि में अब केवल 'अम्बिका' ही अकेली (एका) युद्ध करने के लिए शेष रह गईं।"
            "लयम् (Dissolution) का अर्थ है कि सारी लहरें वापस अपने समुद्र (देवी) में समा चुकी हैं।"
            "यह दृश्य बताता है कि सत्य अंततः 'अकेला' (Singular) है, उसे किसी बाहरी बैसाखी की ज़रूरत नहीं।"
            "ब्रह्माणी, माहेश्वरी, कौमारी—ये सब चेतना के अलग-अलग 'मोड्स' (Modes) थे जो अब शांत हो गए।"
            "जब युद्ध अपने अंतिम स्तर पर पहुँचता है, तो सारी सहायक शक्तियां केंद्र (Center) में सिमट जाती हैं।"
            "अब शुम्भ के पास कोई बहाना नहीं बचा था कि देवी 'दूसरों के सहारे' लड़ रही हैं।"
            "अम्बिका का 'अकेला' होना उनकी पूर्णता और असीमित आत्मविश्वास का सबसे बड़ा प्रमाण है।"
            "यह मन की वह अवस्था है जहाँ सारे विचार शांत होकर केवल 'शुद्ध जागरूकता' (Pure Awareness) बचती है।"
            "अज्ञान को अब साक्षात् 'एकमेवाद्वितीयं' (केवल एक) ब्रह्म की शक्ति का सामना करना था।"
        """.trimIndent(),
        english = """
            (The Churning of Energies): "Then all the Matrikas, led by Brahmani, achieved absolute dissolution (Layam) within Chandika's body."
            "On that cosmic battlefield, only Mother 'Ambika' remained singularly (Eka) to continue the combat."
            "The term 'Layam' implies that all individual waves have successfully merged back into their absolute Ocean."
            "This visual proves that Truth is fundamentally 'Singular' and requires zero external crutches to exist."
            "Brahmani, Maheshwari, and others were different 'Functional Modes' of Consciousness that now became still."
            "When the struggle reaches the absolute final level, all auxiliary energies consolidate into the singular Center."
            "Shumbha was now left with zero excuses to claim that the Goddess fought utilizing 'Borrowed Strengths'."
            "Ambika standing 'Alone' is the ultimate evidence of Her absolute completeness and infinite self-reliance."
            "This represents the state of mind where all thoughts subside, leaving strictly only 'Pure Awareness' behind."
            "Ignorance was now officially destined to face the raw power of the 'One and Only' Supreme Consciousness."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "देव्युवाच ॥ ८ ॥\nविभूत्यैतदिहानेकं मयैवात्मरूपं दर्शितम् ।\nतत्संहृतं मयैकैवाहं तस्मिन् रणे स्थिता ॥ ९ ॥",
        hindi = """
            (देवी का स्पष्टीकरण): "देवी ने कहा: 'अपनी विभूतियों के द्वारा मैंने यहाँ अपने ही 'अनेक' स्वरूप दिखाए थे'।"
            "'अब मैंने उन सबको अपने भीतर समेट (संहृतं) लिया है और अब मैं 'अकेली' ही इस युद्ध में खड़ी हूँ'।"
            "देवी शुम्भ को समझा रही हैं कि 'अनेकता' केवल एक 'भ्रम' (Display) था, वास्तविकता केवल 'एक' है।"
            "यह इंसान को सिखाता है कि जीवन के अलग-अलग रोल (Role) केवल चेतना के 'विस्तार' मात्र हैं।"
            "जैसे एक ही सूर्य हज़ारों घड़ों के पानी में अलग-अलग दिखता है, वैसे ही देवी मातृकाओं में दिख रही थीं।"
            "'संहृतं' (वापस लेना) यह दर्शाता है कि ईश्वर जब चाहे अपनी शक्तियों को प्रकट कर सकता है और छिपा सकता है।"
            "रणे स्थिता (युद्ध में स्थित)—देवी युद्ध से भागी नहीं, बल्कि और भी ज़्यादा 'कम्पोज्ड' और 'फोकस्ड' हो गईं।"
            "अकेले लड़ना यह सिद्ध करता है कि सत्य का एक कण ही पूरे अज्ञान के साम्राज्य पर भारी है।"
            "अहंकार को अब यह समझ आ जाना चाहिए था कि वह किसी 'आर्मी' से नहीं, बल्कि 'यूनिवर्स' से लड़ रहा है।"
            "परंतु अज्ञान का परदा इतना मोटा था कि शुम्भ अभी भी अपनी जीत का सपना देख रहा था।"
        """.trimIndent(),
        english = """
            (The Goddess's Clarification): "The Goddess stated: 'Through My divine glories, I displayed 'Multiple' formats of My own Self here'."
            "'Now I have withdrawn (Samhritam) all of them, and I stand singularly 'Alone' within this battlefield'."
            "The Mother is explaining to Shumbha that 'Multiplicity' was merely a display; Reality is strictly 'One'."
            "This teaches that the diverse roles we play in life are mathematically merely extensions of one Consciousness."
            "Identically as one Sun appears different in thousands of water pots, the Goddess appeared diverse in the Matrikas."
            "The act of 'Samhritam' proves that the Divine holds the power to manifest or withdraw energy at Her absolute Will."
            "The phrase 'Rane Sthita' implies She did zero to retreat; She became even more composed and focused."
            "Fighting alone proves that a single particle of Truth outweighs the entire combined empire of ignorance."
            "Arrogance should have realized by now that it was fighting zero 'Army', but the absolute 'Universe' itself."
            "However, the veil of ignorance was so exceptionally thick that Shumbha continued to dream of victory."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "ऋषिरुवाच ॥ १० ॥\nततः प्रववृते युद्धं देव्याः शुम्भस्य चोभयोः ।\nपश्यतां सर्वदेवानामसुराणां च दारुणम् ॥ ११ ॥",
        hindi = """
            (अंतिम द्वंद्व का प्रारंभ): "ऋषि मेधा ने कहा: इसके बाद देवी और शुम्भ—दोनों के बीच अत्यंत भयंकर (दारुणम्) युद्ध शुरू हुआ।"
            "सभी देवता और असुर अपनी जगह खड़े होकर उस खौफनाक मुकाबले को अपलक देख रहे थे।"
            "यह 'एक-से-एक' (One-on-One) की लड़ाई इंसान के 'अहंकार' और उसकी 'आत्मा' के बीच का अंतिम संघर्ष है।"
            "दारुणम् (Severe/Terrifying) शब्द यह बताता है कि यह कोई साधारण लड़ाई नहीं, बल्कि अस्तित्व का युद्ध था।"
            "देवताओं का देखना 'साक्षी भाव' (Witnessing) का प्रतीक है—जब अच्छाई चुप होकर सत्य की ताकत देखती है।"
            "असुरों का देखना उनके 'डर' का प्रतीक है, क्योंकि उनका आखिरी सहारा (शुम्भ) अब खतरे में था।"
            "जब अहंकार अपनी आखिरी लड़ाई लड़ता है, तो वह बहुत ज़्यादा 'डिस्ट्रक्टिव' और हिंसक हो जाता है।"
            "रणभूमि अब एक ऐसे स्टेज में बदल चुकी थी जहाँ केवल दो ही सबसे बड़ी शक्तियां शेष थीं।"
            "पूरे ब्रह्मांड की सांसे रुकी हुई थीं क्योंकि इस युद्ध का परिणाम सृष्टि का भविष्य तय करने वाला था।"
            "अब अस्त्रों की गूंज और चेतना का तेज़ एक साथ टकराने वाले थे।"
        """.trimIndent(),
        english = """
            (Initiation of the Final Duel): "The Sage Medha said: Subsequently, an exceptionally severe (Darunam) war initiated between the Goddess and Shumbha."
            "All the Gods and the remaining demons stood paralyzed, visually witnessing that terrifying cosmic confrontation."
            "This 'One-on-One' combat represents the absolute final struggle between a human's 'Ego' and their 'Soul'."
            "The word 'Darunam' implies that this was zero ordinary fight, but a fundamental war of core existence."
            "The Gods witnessing it symbolizes the 'Witness Consciousness'—where goodness silently observes the power of Truth."
            "The demons watching symbolizes their mounting 'Terror', as their absolute final refuge was now at risk."
            "When Arrogance fights its final battle, it becomes exponentially more 'Destructive' and violent."
            "The battlefield had successfully transformed into a stage where only the two greatest cosmic forces remained."
            "The entire universe held its breath as the outcome of this war was destined to define the future of creation."
            "Now the clash of physical weapons and the radiance of pure consciousness were about to collide."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "शरवर्षैः शितैः शस्त्रैस्तथास्त्रैश्चैव दारुणैः ।\nतयोर्ययुद्धमभूद्भूयः सर्वलोकभयङ्करम् ॥ १२ ॥",
        hindi = """
            (अस्त्र-शस्त्रों का महायुद्ध): "उनके बीच तीखे बाणों (शरवर्षैः) और भयंकर अस्त्र-शस्त्रों से एक बार फिर भीषण युद्ध हुआ।"
            "वह युद्ध इतना डरावना था कि उससे 'संपूर्ण लोकों' (सर्वलोकभयङ्करम्) में भय व्याप्त हो गया।"
            "अहंकार जब मर रहा होता है, तो वह अपने आसपास के पूरे 'वातावरण' (Environment) को अशांत कर देता है।"
            "तीखे बाण इंसान के उन 'चुभते हुए तर्कों' का प्रतीक हैं जो वह अपनी हार को टालने के लिए फेंकता है।"
            "सर्वलोकभयङ्करम् (सबको डराने वाला)—यह युद्ध केवल बाहर नहीं, बल्कि इंसान के 'मन की गहराई' में चल रहा था।"
            "देवी के अस्त्र 'परम संतुलन' और 'न्याय' के प्रतीक हैं जो हर हमले को शांत कर रहे थे।"
            "जब सत्य और असत्य का टकराव होता है, तो पूरा 'सिस्टम' (ब्रह्मांड) हिल जाता है।"
            "यह वह स्थिति है जब इंसान अपनी पुरानी आदतों और नई समझ के बीच बुरी तरह पिसता है।"
            "शुम्भ अपनी पूरी पाश्विक ताकत लगा रहा था, और देवी अपनी दिव्य शांति के साथ वार कर रही थीं।"
            "अस्त्रों की चमक और उनकी ध्वनि से आकाश और धरती के बीच का स्पेस कांप रहा था।"
        """.trimIndent(),
        english = """
            (The Apocalyptic Weaponry): "A fierce battle broke out once again between them utilizing sharp arrows and terrifying cosmic missiles."
            "The conflict was so horrifying that it instilled 'Terror across all worlds' (Sarva-loka-bhayankaram)."
            "Exactly when Arrogance is dying, it disturbs and agitates the entire surrounding 'Environment'."
            "Sharp arrows symbolize those 'Piercing Logics' a human hurls desperately to delay their inevitable defeat."
            "Terrifying all worlds—this war was occurring zero merely externally, but in the deepest layers of the human mind."
            "The Goddess's weapons represent 'Supreme Balance' and 'Justice', systematically pacifying every demonic assault."
            "The collision between Truth and Falsehood is of such magnitude that the entire cosmic 'System' vibrates with it."
            "This represents the state where a human is caught between ancient toxic habits and newly awakened wisdom."
            "Shumbha was utilizing his total animalistic force, while the Goddess struck back with Her divine tranquility."
            "The radiance and sound of the weapons caused the space between heaven and earth to tremble violently."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "दिव्यान्यस्त्राणि शतशो मुमोच च चण्डिका ।\nतद्वतेन निहतं च शुम्भोऽपि समरे नृप ॥ १३ ॥",
        hindi = """
            (दिव्य अस्त्रों का प्रयोग): "माता चण्डिका ने युद्ध में हज़ारों की संख्या में 'दिव्य अस्त्र' (दिव्यान्यस्त्राणि) चलाए।"
            "शुम्भ ने भी बड़ी बहादुरी दिखाते हुए उन अस्त्रों का मुकाबला किया और उन्हें रोकने की कोशिश की।"
            "दिव्य अस्त्र इंसान के उन 'पवित्र विचारों' और 'उच्च संकल्पों' का प्रतीक हैं जो अज्ञान को काटते हैं।"
            "सत्य हमेशा 'ज्ञान की रोशनी' (Astra) का उपयोग करता है, जबकि अज्ञान केवल 'बल' (Brute Force) का।"
            "शुम्भ का डटे रहना (Sticking to battle) अहंकार की उस 'ज़िद्द' को दिखाता है जो आसानी से नहीं टूटती।"
            "जब हम अपनी किसी गहरी गलती को सुधारने की कोशिश करते हैं, तो हमारा ईगो हज़ारों दलीलें (Counter-strikes) देता है।"
            "देवी के अस्त्र अज्ञान के उन हर एक 'झूठ' को चुन-चुनकर खत्म कर रहे थे।"
            "रणभूमि अब रोशनी के गोलों से भर गई थी, जो यह बता रही थी कि अंधकार का समय अब समाप्त है।"
            "शुम्भ को लग रहा था कि वह बच सकता है, पर वह सत्य की 'अनंत सप्लाई' (Infinite Supply) को नहीं जानता था।"
            "युद्ध का यह स्तर अब भौतिकता से निकलकर 'ऊर्जा' (Energy) के स्तर पर पहुँच चुका था।"
        """.trimIndent(),
        english = """
            (Employment of Divine Missiles): "Mother Chandika released hundreds of 'Divine Weapons' (Divya-astras) throughout the combat."
            "Shumbha also displayed great resilience, attempting to counter and block those celestial strikes."
            "Divine weapons symbolize those 'Sacred Thoughts' and 'Higher Resolves' that effectively slice through ignorance."
            "Truth perpetually utilizes the 'Light of Knowledge', whereas ignorance relies strictly on 'Brute Force'."
            "Shumbha's resilience demonstrates the absolute 'Stubbornness' of the Ego that refuses to shatter easily."
            "When we attempt to rectify a deep-seated mistake, our internal Ego provides thousands of deceptive counter-arguments."
            "The Goddess's missiles were systematically identifying and eliminating every single 'Lie' of the demonic mind."
            "The battlefield was now filled with orbs of light, signaling that the era of darkness was officially expiring."
            "Shumbha deluded himself into thinking survival was possible, ignoring the 'Infinite Supply' of the Truth."
            "The war had now successfully transitioned from the physical dimension to the dimension of 'Pure Energy'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "तानि चास्त्रविशेषाणि मुमुचे यानि चण्डिका ।\nजघान तानि शुम्भोऽपि तदस्त्रैः प्रतिघातनैः ॥ १४ ॥",
        hindi = """
            (शुम्भ का कड़ा मुकाबला): "चण्डिका ने जिन-जिन विशेष अस्त्रों का प्रयोग किया, शुम्भ ने उन सबको अपने 'प्रतिघाती अस्त्रों' से काट दिया।"
            "वह राक्षस अपनी पूरी ट्रेनिंग और ताक़त लगाकर देवी के हर वार का जवाब दे रहा था।"
            "यह दिखाता है कि 'मूल अहंकार' (Core Ego) के पास हर अच्छी बात के लिए एक 'बुरी दलील' तैयार होती है।"
            "शुम्भ (अहंकार) इतना 'चतुर' है कि वह सत्य के अस्त्रों की भी नकल (Copy) करने की कोशिश करता है।"
            "जब आप कोई अच्छी किताब पढ़ते हैं या अच्छी बात सुनते हैं, तो आपका ईगो तुरंत एक 'बट' (But) खड़ा कर देता है।"
            "वह 'बट' ही शुम्भ का प्रतिघाती अस्त्र (Counter-weapon) है जो आपको बदलने नहीं देता।"
            "युद्ध की यह बराबरी यह दर्शाती है कि अज्ञान को मिटाना दुनिया का सबसे 'टाइम-कन्ज़्यूमिंग' (Time-consuming) काम है।"
            "देवी शुम्भ को उसकी पूरी ताक़त दिखाने का मौका दे रही हैं, ताकि उसका कोई भी भ्रम बाकी न रहे।"
            "अहंकार को अपनी 'बौद्धिक चतुराई' पर बहुत घमंड था, जो इस मुकाबले में साफ दिख रहा था।"
            "परंतु वह नहीं जानता था कि सत्य के पास ऐसे अस्त्र भी हैं जिनका कोई 'प्रतिघात' (Counter) नहीं होता।"
        """.trimIndent(),
        english = """
            (Shumbha's Intense Resistance): "Whatever specialized weapons Chandika released, Shumbha neutralized all of them utilizing his own 'Counter-weapons'."
            "The demon was utilizing his entire training and strength to respond to every single blow from the Goddess."
            "This proves that the 'Core Ego' perpetually possesses a 'Toxic Argument' ready for every righteous truth."
            "Shumbha (Arrogance) is so 'Cunning' that he even attempts to copy and neutralize the weapons of Truth."
            "When You absorb wisdom or hear something pure, Your Ego instantaneously generates a 'But' or an excuse."
            "That 'But' is Shumbha's counter-weapon (Pratighata-astra) that prevents Your personal evolution."
            "This equality in battle demonstrates that erasing ignorance is the most 'Time-consuming' task in the cosmos."
            "The Mother is granting Shumbha the chance to display his full strength so that zero doubt remains of his eventual failure."
            "The Ego took immense pride in its 'Intellectual Cunningness', which was evident throughout this fierce duel."
            "However, he was unaware that Absolute Truth possesses weapons for which zero 'Counter-measures' mathematically exist."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 11,
        sanskrit = "मुमोच स च यानि चण्डिका तानि सापि च ।\nचिच्छेद लीलयैवोक्ता हुङ्कारोच्चारणादिभिः ॥ १५ ॥",
        hindi = """
            (हुंकार से अस्त्रों का नाश): "शुम्भ ने जो भी अस्त्र देवी पर फेंके, माता चण्डिका ने उन्हें केवल एक 'हुंकार' (Humkara) से नष्ट कर दिया।"
            "उन्होंने बिल्कुल 'खेल-खेल में' (लीलया) उसके हज़ारों सालों के युद्ध कौशल को बेकार बना दिया।"
            "यह श्लोक 'विजडम' (Wisdom) और 'एफर्टलेसनेस' (Effortlessness) का सबसे बड़ा प्रमाण है।"
            "शुम्भ पसीना बहाकर अस्त्र चला रहा था, और देवी केवल एक 'साउंड' (Sound) से उन्हें मिट्टी कर रही थीं।"
            "'हुंकार' वह ध्वनि है जो हमारे 'आज्ञा चक्र' से निकलती है और हर मानसिक भ्रम को एक पल में भस्म कर देती है।"
            "जब इंसान अपने 'केंद्र' (Center) में स्थित होता है, तो वह बड़ी से बड़ी समस्या को 'लीला' (Play) की तरह सुलझा लेता है।"
            "देवी की यह हंसी और हुंकार शुम्भ के आत्मविश्वास की जड़ों को अंदर से खोखला कर रही थी।"
            "यह दिखाता है कि 'चेतना' (Consciousness) के सामने 'मैटर' (Matter) हमेशा कमज़ोर और नश्वर होता है।"
            "शुम्भ अब समझ रहा था कि वह एक ऐसी दीवार से टकरा गया है जिसे कोई अस्त्र नहीं भेद सकता।"
            "युद्ध का पलड़ा अब पूरी तरह से 'सत्य' की ओर झुक चुका था।"
        """.trimIndent(),
        english = """
            (Neutralizing Missiles with Sound): "Whatever missiles Shumbha hurled at the Goddess, Mother Chandika destroyed them utilizing a mere 'Humkara' (Roar)."
            "She rendered his thousands of years of combat training entirely useless strictly 'Playfully' (Lilaya)."
            "This verse serves as the absolute greatest evidence of 'Wisdom' combined with 'Divine Effortlessness'."
            "Shumbha was exhausting himself to fire weapons, while the Goddess turned them to dust utilizing a single 'Sound'."
            "The 'Humkara' is the vibration originating from the 'Ajna Chakra' that incinerates every mental delusion instantly."
            "When a human is rooted in their absolute 'Center', they resolve the most colossal problems identically to a 'Game' (Leela)."
            "The Goddess's roar and playful attitude were hollowout the very foundations of Shumbha's self-confidence."
            "This proves that 'Matter' is perpetually weak and mortal when confronted by 'Infinite Consciousness'."
            "Shumbha was beginning to realize he had collided with a cosmic wall that zero weapon could ever pierce."
            "The scales of the war had now successfully and entirely tipped in favor of the absolute 'Truth'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "ततः शरशतैर्देवीमाच्छादयत सोऽसुरः ।\nसापि तत्कुपिता देवी धनुश्चिच्छेद सायकैः ॥ १६ ॥",
        hindi = """
            (धनुष का कटना): "तब उस असुर ने हज़ारों बाणों (शरशतैर्) से देवी को पूरी तरह से 'ढकने' (आच्छादयत) की कोशिश की।"
            "इससे क्रोधित होकर देवी ने अपने अचूक बाणों से शुम्भ के उस 'धनुष' को ही बीच से काट दिया!"
            "अहंकार हमेशा सत्य की 'दृष्टि' को ढकना चाहता है ताकि वह अपनी बुराइयों को छुपा सके।"
            "हज़ारों बाण वे 'झूठे बहाने' हैं जो इंसान अपनी गलतियों को जस्टिफाई (Justify) करने के लिए देता है।"
            "धनुष (Bow) इंसान के 'प्लानिंग' और 'लॉजिक' का प्रतीक है—देवी ने उसके सोचने का जरिया ही खत्म कर दिया।"
            "जब आपकी 'बुद्धि का आधार' (धनुष) ही टूट जाता है, तो आपके सारे विचार (बाण) बेकार हो जाते हैं।"
            "शुम्भ अब निहत्था होने की कगार पर था, पर उसकी 'ज़िद' अभी भी मरी नहीं थी।"
            "देवी का 'कुपित' (Enraged) होना यह बताता है कि अब वे अज्ञान के खेल को और लंबा नहीं खींचना चाहतीं।"
            "सत्य जब प्रहार करता है, तो वह सीधे समस्या की 'जड़' (धनुष) पर वार करता है।"
            "रणभूमि में अब शुम्भ के टूटे हुए धनुष के टुकड़े बिखर चुके थे।"
        """.trimIndent(),
        english = """
            (Severing the Bow): "Then that demon attempted to completely 'Cover' (Achhadayata) the Goddess with hundreds of arrows."
            "Enraged by this, the Goddess utilized Her infallible missiles to sever Shumbha's 'Bow' right from the center!"
            "Arrogance perpetually seeks to 'Hide' the vision of Truth so it can continue its toxic existence unnoticed."
            "Hundreds of arrows represent those 'False Excuses' a human provides to justify their persistent mistakes."
            "The Bow symbolizes human 'Planning' and 'Logic'—the Goddess destroyed his medium of strategic thinking."
            "When the 'Foundation of Intellect' (The Bow) shatters, all subsequent thoughts (Arrows) become mathematically useless."
            "Shumbha was now on the verge of being disarmed, yet his 'Stubbornness' refused to perish."
            "The Goddess becoming 'Enraged' indicates that She was no longer willing to tolerate the games of ignorance."
            "Exactly when Truth strikes, it targets the absolute 'Root' (The Source) of the psychological problem."
            "The fragments of Shumbha's broken bow were now scattered across the dirt of the cosmic battlefield."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "छिन्ने धनुषि दैत्येन्द्रस्तथा शक्तिमथाददे ।\nचिच्छेद देवी चक्रेण तामप्यस्य करे स्थिताम् ॥ १७ ॥",
        hindi = """
            (शक्ति का नाश): "धनुष कट जाने पर दैत्यराज शुम्भ ने एक भयंकर 'शक्ति' (भाला) अपने हाथ में उठाई।"
            "परंतु वह अस्त्र उसके हाथ (करे) में ही था, तभी देवी ने अपने 'चक्र' से उसे भी काटकर गिरा दिया!"
            "यह अज्ञान की 'छटपटाहट' है—एक हथियार टूटता है, तो वह तुरंत दूसरा उठा लेता है।"
            "शक्ति (Spear) इंसान के उस 'वन-पॉइंटेड' एग्रेसिव स्वभाव का प्रतीक है जो बदला लेना चाहता है।"
            "देवी का 'चक्र' समय (Time) का प्रतीक है जो यह बताता है कि बुराई का हर कदम पहले से ही तय है।"
            "हाथ में रहते हुए ही अस्त्र का कटना यह सिद्ध करता है कि सत्य की गति 'विचार' से भी तेज़ है।"
            "इंसान अपनी बुराई को लागू (Execute) करने का सोच भी नहीं पाता, और देवी उसे पहले ही काट देती हैं।"
            "शुम्भ अब बहुत ज़्यादा 'फ्रस्ट्रेटेड' (Frustrated) महसूस करने लगा था क्योंकि उसकी कोई भी चाल काम नहीं आ रही थी।"
            "यह श्लोक सिखाता है कि बिना 'विवेक' के उठाया गया हर कदम केवल नुकसान ही पहुँचाता है।"
            "अहंकार की हर कोशिश अब रेत की दीवार की तरह ढह रही थी।"
        """.trimIndent(),
        english = """
            (Destruction of the Spear): "With his bow severed, the Demon King Shumbha seized a terrifying 'Shakti' (Spear) in his hand."
            "While the weapon was still in his 'Grip' (Kare), the Goddess severed it utilizing Her rapidly spinning 'Chakra'!"
            "This illustrates the 'Frantic Struggle' of ignorance—when one tool fails, it immediately grabs another."
            "The Spear symbolizes that 'One-pointed' aggressive nature of a human seeking violent revenge."
            "The Goddess's 'Chakra' represents Time, proving that every move of evil is already mathematically destined to fail."
            "Severing the weapon while still in the hand proves that the velocity of Truth is faster than the speed of 'Thought'."
            "A human cannot even initiate the execution of a toxic plan before the Divine Power neutralizes it."
            "Shumbha was now experiencing 'Extreme Frustration' as none of his tactical maneuvers were yielding results."
            "This verse teaches that every action executed without 'Wisdom' results strictly in total failure and loss."
            "Every attempt by Arrogance was now collapsing identically to a wall constructed of dry sand."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "ततः खड्गमुपादाय शतचन्द्रं च भानुमान् ।\nअभ्यधावत तां देवीं दैत्यानामधिपेश्वरः ॥ १८ ॥",
        hindi = """
            (तलवार और ढाल के साथ हमला): "इसके बाद शुम्भ ने एक अत्यंत तेज़ 'तलवार' और 'सौ चंद्रमाओं वाली ढाल' (शतचन्द्रं) उठाई।"
            "वह दैत्यों का स्वामी सूर्य के समान चमकते हुए क्रोध के साथ देवी को मारने के लिए उनकी ओर दौड़ा।"
            "शतचन्द्र ढाल (Shield with 100 moons) अहंकार के उस 'मल्टीपल डिफेंस' (Multiple Defense) का प्रतीक है।"
            "इंसान अपने ईगो को बचाने के लिए हज़ारों 'सुरक्षा कवच' और बहाने बनाकर रखता है।"
            "तलवार उसकी 'काटने वाली जुबान' और 'हिंसक इरादों' का प्रतीक है जो अब बेकाबू हो चुके थे।"
            "भानुमान् (सूर्य जैसा चमकना)—यह उसके 'राजसी घमंड' को दिखाता है जो अब अपनी आखिरी चमक दिखा रहा था।"
            "अहंकार जब निहत्था (धनुष-विहीन) होता है, तो वह 'ब्लंट' और 'फिजिकल' होकर हमला करता है।"
            "वह देवी की ओर 'अभ्यधावत' (दौड़ा)—मतलब वह अब अपनी मौत से सीधे टकराने के लिए तैयार था।"
            "यह दृश्य अहंकार की उस 'वीरता' को दिखाता है जो वास्तव में केवल एक 'सुसाइडल' पागलपन है।"
            "सत्य की तलवार अब अज्ञान की इस ढाल के परखच्चे उड़ाने के लिए तैयार थी।"
        """.trimIndent(),
        english = """
            (Attack with Sword and Shield): "Subsequently, Shumbha seized a razor-sharp 'Sword' and a 'Shield adorned with a hundred moons'."
            "The lord of demons, radiating like a dark sun, aggressively charged toward the Goddess to slaughter Her."
            "The 'Hundred Moon Shield' symbolizes the Ego's 'Multiple Defense Mechanisms' and psychological armors."
            "A human constructs thousands of excuses and protective layers strictly to safeguard his fragile Ego."
            "The Sword represents his 'Cutting Speech' and 'Violent Intentions' that had now become uncontrollable."
            "The term 'Bhanuman' (Radiant) illustrates his 'Royal Pride' displaying its absolute final flicker of light."
            "When Arrogance is stripped of its strategic tools, it resorts to 'Blunt' and direct physical aggression."
            "He 'Charged' toward the Goddess—meaning he was now ready to collide directly with his own absolute end."
            "This scene illustrates the 'Valor' of the Ego, which is mathematically nothing but suicidal insanity."
            "The sword of Absolute Truth was now perfectly prepared to shatter this shield of ignorance into pieces."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "तस्यापतत एवाशु खड्गं चिच्छेद चण्डिका ।\nधनुर्मुक्तैः शितैर्बाणैश्चर्म चार्ककरामलम् ॥ १९ ॥",
        hindi = """
            (तलवार और ढाल का कटना): "शुम्भ को अपनी ओर आते देख चण्डिका ने अपने धनुष से अत्यंत तीखे बाण छोड़े।"
            "उन बाणों ने शुम्भ की उस 'तलवार' और 'सूर्य के समान चमकती ढाल' के टुकड़े-टुकड़े कर दिए!"
            "अर्ककरामलम् (सूर्य की किरणों जैसी ढाल)—अहंकार को अपनी सुरक्षा पर बहुत नाज़ था, पर वह महज़ एक भ्रम था।"
            "देवी के 'बाण' (फोकस) ने अज्ञान के बचाव (Defense) और आक्रमण (Attack) दोनों को एक साथ खत्म कर दिया।"
            "जब सत्य का प्रहार होता है, तो इंसान के पास खुद को सही साबित करने के लिए कोई 'ढाल' नहीं बचती।"
            "शुम्भ अब रणभूमि में पूरी तरह से 'एक्सपोज़' (Exposed) और असुरक्षित हो चुका था।"
            "यह श्लोक बताता है कि 'अवेयरनेस' की एक किरण ही हज़ारों झूठ के कवचों को भेदने के लिए काफी है।"
            "अहंकार की 'चमक' (ढाल) अब धूल में मिल चुकी थी और उसकी 'काटने की शक्ति' (तलवार) टूट चुकी थी।"
            "शुम्भ की हताशा अब उसके चेहरे पर साफ दिखाई देने लगी थी, पर उसकी 'अकड़' अभी भी बाकी थी।"
            "मौत अब उसके बिल्कुल करीब खड़ी थी और वह उसे अपनी आँखों से देख पा रहा था।"
        """.trimIndent(),
        english = """
            (Severing the Sword and Shield): "As Shumbha approached, Chandika released exceptionally sharp arrows from Her divine bow."
            "Those arrows instantaneously shattered Shumbha's 'Sword' and his 'Radiant sun-like shield' into pieces!"
            "The sun-like shield symbolizes that arrogance takes extreme pride in its defenses, which are merely illusions."
            "The Goddess's 'Arrows' (Focus) simultaneously terminated both the Ego's Attack and its Defense Mechanism."
            "Exactly when Truth strikes, a human is left with zero 'Shields' to justify their toxic behavior."
            "Shumbha was now entirely 'Exposed' and psychologically vulnerable in the middle of the battlefield."
            "This verse teaches that a single ray of 'Awareness' is sufficient to pierce thousands of armors of lies."
            "The Ego's 'Radiance' (The Shield) was now dust, and its 'Cutting Power' (The Sword) was permanently broken."
            "Shumbha's desperation was now visible on his face, yet his internal 'Stiffness' remained intact."
            "Death was now standing perfectly in front of him, and he could perceive it with his own physical eyes."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "हताश्वः स तदा दैत्यश्छिन्नधन्वा विसारथिः ।\nजग्राह मुद्गरं घोरं अम्बिकानिधनोद्यतः ॥ २० ॥",
        hindi = """
            (मुद्गर के साथ अंतिम प्रयास): "घोड़ों के मरने, धनुष के कटने और सारथी के न रहने पर वह दैत्य पूरी तरह अकेला हो गया।"
            "फिर भी माता अम्बिका को मारने की ज़िद में उसने एक भयंकर 'मुद्गर' (भारी डंडा) उठा लिया।"
            "यह 'अंतिम चरण' की लड़ाई है—जब सारे सोफिस्टिकेटेड (Sophisticated) हथियार फेल हो जाते हैं।"
            "मुद्गर (Heavy Club) इंसान के उस 'अनपॉलिश' (Unpolished) और जंगली गुस्से का प्रतीक है।"
            "जब अहंकार के पास कोई लॉजिक (धनुष) या बचाव (ढाल) नहीं बचता, तो वह 'पागलपन' पर उतर आता है।"
            "शुम्भ अब अपनी पूरी 'असुरी शक्ति' को उस एक मुद्गर में झोंककर देवी की ओर झपटा।"
            "अम्बिकानिधनोद्यतः (अम्बिका को मारने के लिए उद्यत)—यह उसके 'कर्ता-भाव' का आखिरी विस्फोट था।"
            "वह यह नहीं समझ पाया कि जो शून्यता (देवी) अस्त्रों को निगल सकती है, उसके लिए यह लकड़ी का डंडा क्या है।"
            "यह दृश्य ईगो के उस 'डेस्परेट सर्वाइवल' (Desperate Survival) को दिखाता है जो मुमकिन नहीं था।"
            "अज्ञान अब अपनी पूरी ताकत से मौत की ओर आखिरी छलांग लगा रहा था।"
        """.trimIndent(),
        english = """
            (Final Attempt with the Club): "With his horses slaughtered, bow severed, and driver gone, the demon became entirely alone."
            "Yet, in his stubbornness to kill Ambika, he seized an exceptionally terrifying and heavy 'Club' (Mudgara)."
            "This is the battle of the 'Final Stage'—when all sophisticated and strategic weapons have failed miserably."
            "The Club symbolizes the 'Unpolished' and wild animalistic rage that takes over the human mind."
            "When Arrogance loses its logic (The Bow) and defense (The Shield), it resorts to absolute 'Insanity'."
            "Shumbha poured his absolute remaining 'Demonic Power' into that singular club and lunged at the Goddess."
            "The phrase 'Ambika-nidhanodyatah' proves it was the final explosion of his toxic 'Sense of Doership'."
            "He failed to comprehend that for the Void (Goddess) which devours missiles, this club is mathematically zero."
            "This visual illustrates the Ego's 'Desperate Survival' attempt, which was fundamentally impossible."
            "Ignorance was now taking its final leap toward death with all the brute force it could consolidate."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "मुद्गरं प्रहितं तस्य चिच्छेद निशितैः शरैः ।\nचण्डिका तं च मुष्टिना ताडयामास हृदयोरसि ॥ १७ ॥",
        hindi = """
            (मुद्गर का नाश और प्रहार): "माता चण्डिका ने शुम्भ द्वारा फेंके गए उस भयंकर मुद्गर को अपने तीखे बाणों से बीच से काट दिया।"
            "उसके बाद देवी ने आगे बढ़कर उस दैत्यराज की छाती (हृदयोरसि) पर अपने 'मुक्के' (मुष्टिना) से ज़ोरदार प्रहार किया।"
            "यह दृश्य बताता है कि अज्ञान का 'स्थूल' (Gross) अस्त्र केवल सत्य की एक 'सूक्ष्म' किरण (बाण) से ही कट जाता है।"
            "छाती पर मुक्का मारना अहंकार के 'अभिमान के केंद्र' (Center of Pride) पर सीधा प्रहार करने का प्रतीक है।"
            "जब सारे तर्क और विचार खत्म हो जाते हैं, तो युद्ध 'हृदय' (Core) के स्तर पर आ जाता है।"
            "देवी ने उसे यह अहसास दिलाया कि उसकी सारी आसुरी शक्ति उनके एक हाथ के प्रहार के सामने कुछ भी नहीं है।"
            "हृदय पर चोट लगना अहंकार की 'जीवन-शक्ति' को हिला देने के समान है।"
            "अहंकारी व्यक्ति अक्सर अपने 'दिल' की बात नहीं सुनता, इसलिए देवी उसे वहीं चोट पहुँचाती हैं।"
            "शुम्भ इस प्रहार से पूरी तरह विचलित हो गया, पर उसकी हार अभी पूरी नहीं हुई थी।"
            "सत्य अब अज्ञान को उसके सबसे सुरक्षित स्थान से बाहर खींच रहा था।"
        """.trimIndent(),
        english = """
            (Destruction of the Club): "Mother Chandika shattered the terrifying club hurled by Shumbha utilizing Her razor-sharp arrows."
            "Subsequently, the Goddess advanced and delivered a devastating blow with Her 'Fist' (Mushtina) directly upon the demon's chest."
            "This scene proves that the 'Gross' weapons of ignorance are easily severed by a 'Subtle' ray of Truth (the arrow)."
            "Striking the chest symbolizes a direct assault on the Ego's absolute 'Center of Pride' and identity."
            "When all logic and thoughts are exhausted, the cosmic war descends to the level of the 'Heart' (The Core)."
            "The Goddess made him realize that his entire demonic strength was mathematically zero against the impact of Her hand."
            "A blow to the heart is equivalent to violently shaking the very 'Life-force' of the internal Arrogance."
            "An arrogant person perpetually ignores the voice of their 'Heart', so the Mother strikes exactly there to awaken it."
            "Shumbha was deeply destabilized by this blow, yet his absolute collapse was not yet mathematically complete."
            "Absolute Truth was now forcefully dragging ignorance out from its absolute final psychological refuge."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "मुष्टिप्रहाराभिहतो निपात धरणीतले ।\nस तु भूयः समुत्पत्य गत्वा चोर्ध्वं महासुरः ॥ १८ ॥",
        hindi = """
            (ज़मीन पर गिरना और पुनः उठना): "देवी के मुक्के के प्रहार से वह महा-असुर तड़प कर 'धरती' (धरणीतले) पर गिर पड़ा।"
            "परंतु वह एक बार फिर से (भूयः) बड़ी तेज़ी के साथ उठा और उड़कर 'आकाश' (ऊर्ध्वं) की ओर चला गया।"
            "धरती पर गिरना अहंकार के 'पतन' (Fall) का प्रतीक है—जब उसे उसकी असलियत दिखाई देती है।"
            "परंतु अहंकार बहुत ज़िद्दी होता है; वह गिरने के बाद भी हार नहीं मानता और 'ऊपर' भागने की कोशिश करता है।"
            "आकाश की ओर जाना अज्ञान का वह 'काल्पनिक संसार' है जहाँ वह खुद को सुरक्षित महसूस करना चाहता है।"
            "जब इंसान की हकीकत (Earth) कड़वी होती है, तो उसका मन 'भ्रम' और 'अहंकार' की ऊँचाइयों में छुपना चाहता है।"
            "शुम्भ को लगा कि वह आकाश में जाकर देवी की पहुँच से दूर हो जाएगा, जो उसकी सबसे बड़ी भूल थी।"
            "अज्ञान का यह 'उछाल' (Jump) वास्तव में उसकी मौत से पहले की आखिरी छटपटाहट थी।"
            "यह दृश्य दिखाता है कि बुरी आदतें एक बार में नहीं मरतीं, वे बार-बार 'बाउंस-बैक' (Bounce back) करती हैं।"
            "अब युद्ध का मैदान ज़मीन से उठकर 'अनंत स्पेस' (Infinite Space) में पहुँच चुका था।"
        """.trimIndent(),
        english = """
            (The Fall and Re-ascension): "Shattered by the strike of the Goddess's fist, that mega-demon dropped dead-like onto the 'Earth' (Dharanitale)."
            "However, he instantaneously rose again (Bhuyah) with great velocity and ascended high into the 'Sky' (Urdhvam)."
            "Falling to the earth symbolizes the Ego's absolute 'Fall'—the moment it is confronted with its own mortality."
            "Yet, Arrogance is exceptionally stubborn; even after a total collapse, it refuses to surrender and tries to flee 'Upward'."
            "Ascending into the sky represents the Ego's 'Imaginary World' where it desperately seeks psychological refuge."
            "When a human's reality (Earth) becomes bitter, their mind attempts to hide in the heights of 'Illusion' and pride."
            "Shumbha deluded himself into thinking that the sky offered safety from the Goddess, which was a fatal blunder."
            "This 'Jump' of ignorance was actually its absolute final struggle before the inevitable cosmic termination."
            "This scene demonstrates that toxic habits do zero to die in one strike; they consistently attempt to 'Bounce Back'."
            "The cosmic battlefield had now successfully shifted from the ground into the dimension of 'Infinite Space'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "उत्पत्य च तदा देवी गत्वा चोर्ध्वं नभस्तलम् ।\nतत्राकाशे निरालम्बे युद्धं तदभवत्तयोः ॥ १९ ॥",
        hindi = """
            (आकाश में युद्ध): "तब माता चण्डिका ने भी छलांग लगाई और उस असुर के पीछे 'आकाश' (नभस्तलम्) में पहुँच गईं।"
            "वहाँ उस 'निराधार' (निरालम्बे) आकाश में, देवी और शुम्भ के बीच अत्यंत भयंकर युद्ध हुआ।"
            "निरालम्बे (बिना किसी सहारे के)—यह मन की उस 'शून्यता' (Pure Void) का प्रतीक है जहाँ कोई विचार नहीं होता।"
            "जब अहंकार अपनी काल्पनिक ऊँचाइयों पर जाता है, तो चेतना (देवी) वहाँ भी उसका पीछा करती है।"
            "सत्य से भागने के लिए ब्रह्मांड में कोई भी जगह 'सुरक्षित' (Safe) नहीं है।"
            "आकाश का युद्ध यह दर्शाता है कि यह लड़ाई अब 'सूक्ष्म' (Subtle) ऊर्जा के स्तर पर पहुँच चुकी है।"
            "अहंकार को लगा था कि वह हवा में अजेय है, पर वह भूल गया कि आकाश भी देवी का ही स्वरूप है।"
            "बिना किसी आधार (निराधार) के लड़ना यह सिद्ध करता है कि सत्य को किसी 'सपोर्ट' की ज़रूरत नहीं होती।"
            "यह दृश्य इंसान के मन की उन 'ऊँची उड़ानों' को दिखाता है जिन्हें चेतना अंततः शांत कर देती है।"
            "पूरा ब्रह्मांड इस अद्भुत और निराले युद्ध को देखकर चकित और स्तब्ध था।"
        """.trimIndent(),
        english = """
            (War in the Infinite Sky): "Then Mother Chandika also leaped and pursued that demon high into the absolute 'Sky' (Nabhastalam)."
            "In that 'Supportless' (Niralambe) space, an exceptionally terrifying duel occurred between the Goddess and Shumbha."
            "'Niralambe' (Without support) perfectly symbolizes that 'Pure Void' of the mind where zero thoughts can survive."
            "When Arrogance flees to its imaginary mental heights, Consciousness (Goddess) follows it even there to terminate it."
            "Mathematically zero places exist in the entire cosmos that are 'Safe' for someone attempting to escape the Truth."
            "The war in the sky proves that the struggle has now successfully transitioned to the level of 'Subtle' energy."
            "The Ego believed it was invincible in the air, forgetting that Space itself is a manifestation of the Divine Mother."
            "Fighting without any foundation (Supportless) proves that Absolute Truth requires zero external validation or support."
            "This visual illustrates the 'High Flights' of the human mind which are eventually silenced by pure Awareness."
            "The entire universe was stunned and paralyzed, visually witnessing this unique and supportless cosmic confrontation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "ततः खमध्यमभवद्युद्धं तदतिदारुणम् ।\nयथा तच्छुम्भनिशुम्भयोः पुरासीत् खमध्यमे ॥ २० ॥",
        hindi = """
            (दारुण युद्ध): "तब आकाश के मध्य (खमध्यम) में वह अत्यंत भयंकर और दारुण युद्ध हुआ।"
            "यह वैसा ही युद्ध था जैसा प्राचीन काल में शुम्भ और निशुम्भ के बीच (या देवताओं से) हुआ था।"
            "दारुणम् (Severe)—यह शब्द बताता है कि अहंकार के साथ अंतिम समझौता नामुमकिन होता है।"
            "आकाश का मध्य भाग इंसान के 'चित्त' (Subconscious) की गहराइयों का प्रतीक है।"
            "अहंकार अपनी पुरानी यादों और जीतों (पुरा) के दम पर सत्य को दबाने की आखिरी कोशिश कर रहा था।"
            "यह युद्ध इतना तीव्र था कि इसने ब्रह्मांड के 'टाइम-स्पेस' (Time-space) को भी हिला दिया था।"
            "जब एक इंसान अपनी 'आइडेंटिटी' (Identity) के लिए लड़ता है, तो वह सबसे ज़्यादा उग्र होता है।"
            "देवी ने शुम्भ को उसके ही 'एलिमेंट' (आकाश) में घेर लिया था ताकि वह कहीं और न भाग सके।"
            "सत्य की शक्ति अब अज्ञान के हर परमाणु को विखंडित (Disintegrate) करने के लिए तैयार थी।"
            "यह युद्ध अज्ञान के साम्राज्य के पतन का आखिरी और सबसे महान चैप्टर बन चुका था।"
        """.trimIndent(),
        english = """
            (The Severe Confrontation): "Then, in the absolute center of the sky (Khamadhyama), an exceptionally severe and terrifying war occurred."
            "This battle was identical in magnitude to the ancient wars executed by Shumbha and Nishumbha in the past."
            "The term 'Darunam' (Severe) proves that a peaceful compromise with the Core Ego is mathematically impossible."
            "The center of the sky symbolizes the absolute depths of the human 'Subconscious' (Chitta)."
            "Arrogance was utilizing its ancient memories and past victories (Pura) to desperately suppress the absolute Truth."
            "This war was so intense that it shook the absolute fabric of 'Time-Space' across the entire manifested universe."
            "When a human fights strictly for their 'Identity', they become their absolute most violent and aggressive self."
            "The Goddess trapped Shumbha within his own 'Element' (Space) so he possessed zero further escape routes."
            "The power of Truth was now officially prepared to Disintegrate every atom of demonic ignorance."
            "This specific conflict had become the final and absolute greatest chapter of the fall of the demonic empire."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 21,
        sanskrit = "ततस्तु सा निजग्राह शुम्भं गत्वा नभस्तले ।\nभ्रामयित्वा च चिक्षेप तदा तं चण्डिका भुवि ॥ २१ ॥",
        hindi = """
            (शुम्भ को पटकना): "तब माता चण्डिका ने आकाश के मध्य उस शुम्भ को ज़ोर से पकड़ (निजग्राह) लिया।"
            "उन्होंने उसे हवा में ही बड़ी तेज़ी से 'गोल-गोल घुमाया' (भ्रामयित्वा) और पूरी ताक़त से 'धरती' (भुवि) पर फेंक दिया।"
            "घुमाना (Spinning) अहंकार के उस 'मानसिक भ्रम' को पूरी तरह नष्ट करने का प्रतीक है।"
            "जब आप किसी चीज़ को बहुत तेज़ घुमाते हैं, तो उसका 'सेंटर' (Center) खत्म हो जाता है; यही ईगो के साथ हुआ।"
            "आकाश से धरती पर फेंकना यह बताता है कि अहंकार चाहे जितना भी ऊपर उड़ ले, अंततः उसे हकीकत (Reality) में गिरना ही पड़ता है।"
            "चण्डिका ने उसे उसकी 'जड़ों' से काटकर वापस उस मिट्टी में मिला दिया जहाँ से वह पैदा हुआ था।"
            "यह 'डाउन-टू-अर्थ' (Down-to-earth) होने की सबसे दर्दनाक और अंतिम प्रक्रिया थी।"
            "अहंकार का वह 'राजसी नशा' अब हवा में ही गायब हो चुका था और वह केवल एक 'पिण्ड' बनकर नीचे गिर रहा था।"
            "सत्य की यह शक्ति अज्ञान को उसके 'अस्तित्व' के भ्रम से बाहर निकालने वाली थी।"
            "अब शुम्भ के पास उठने की कोई ताकत नहीं बची थी, केवल उसकी अंतिम सांस बाकी थी।"
        """.trimIndent(),
        english = """
            (Slamming Shumbha Down): "Then Mother Chandika firmly seized (Nijagraha) Shumbha within the absolute high sky."
            "She violently 'Spun him rapidly' (Bhramayitva) in the air and slammed him with total force onto the 'Earth' (Bhuvi)."
            "Spinning him symbolizes the total destruction of the Ego's absolute 'Mental Delusion' and orientation."
            "When You spin an object with apocalyptic speed, its 'Center' is destroyed; this is exactly what happened to the Ego."
            "Throwing him from sky to earth proves that regardless of how high Arrogance flies, it must eventually crash into Reality."
            "Chandika severed him from his deluded heights and returned him to the dirt from which he originated."
            "This was the absolute most painful and final stage of the 'Grounding' process of the human psyche."
            "The 'Royal Intoxication' of Arrogance had vanished in mid-air, leaving him as a mere falling mass of matter."
            "The power of Truth was now effectively pulling ignorance out of its absolute 'Illusion of Existence'."
            "Shumbha now possessed mathematically zero strength to rise; strictly only his final breath remained."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 22,
        sanskrit = "स पपात महीं प्राप्य तदा तं च निपातितम् ।\nअभ्यधावत दुष्टात्मा शुम्भो हन्तुं मुष्टिमुद्यतः ॥ २२ ॥",
        hindi = """
            (अंतिम छटपटाहट): "धरती पर गिरते ही वह दुष्ट आत्मा शुम्भ फिर से उठा और देवी को मारने के लिए अपना 'मुक्का' (मुष्टिम्) तानकर दौड़ा।"
            "यह अज्ञान की उस 'ज़िद' (Stubbornness) का चरम है जो मरने से ठीक पहले भी अपना 'अहंकार' नहीं छोड़ती।"
            "अहंकारी व्यक्ति अपनी पूरी बर्बादी के बाद भी 'सरेंडर' (Surrender) करने के बजाय 'हमला' करना चुनता है।"
            "मुक्का (Fist) तानना यह दिखाता है कि अब उसके पास कोई अस्त्र नहीं बचा, केवल उसकी 'हताशा' (Despair) बची है।"
            "सत्य के सामने मुक्का उठाना ऐसा ही है जैसे आग को हाथ से बुझाने की कोशिश करना।"
            "शुम्भ अपनी 'पाश्विक वृत्ति' (Animalistic Nature) के सबसे निचले स्तर पर पहुँच चुका था।"
            "वह 'दुष्टात्मा' (Evil Soul) बन चुका था क्योंकि उसने अपनी चेतना को पूरी तरह नेगेटिविटी को सौंप दिया था।"
            "देवी ने उसे एक मौका दिया था (गिरने के बाद), पर उसने उसे अपनी 'मौत' के रूप में इस्तेमाल किया।"
            "यह श्लोक सिखाता है कि कुछ बुराइयां कभी नहीं सुधरतीं, उन्हें केवल 'मिटाया' ही जा सकता है।"
            "अब चण्डिका अपनी उस तलवार (ज्ञान) को बाहर निकालने वाली थीं जो अंतिम फैसला करेगी।"
        """.trimIndent(),
        english = """
            (The Final Struggle): "Upon hitting the earth, that wicked-souled Shumbha rose again and rushed to kill the Goddess with his 'Fist' (Mushtim) raised."
            "This is the peak of that 'Stubbornness' of ignorance which refuses to relinquish its Ego even a second before death."
            "An arrogant person, even after total ruin, chooses to 'Attack' rather than execute an unconditional 'Surrender'."
            "Raising a Fist proves that he possessed zero remaining weapons; only his absolute 'Desperation' remained."
            "Raising a fist against Absolute Truth is mathematically identical to attempting to extinguish a fire utilizing bare hands."
            "Shumbha had now reached the absolute lowest level of his unrefined 'Animalistic Nature'."
            "He was addressed as 'Dushtatma' (Evil Soul) because he had entirely surrendered his consciousness to negativity."
            "The Goddess granted him one final moment (after the fall), but he utilized it to accelerate his own 'Death'."
            "This verse teaches that some vices mathematically never improve; they can strictly only be permanently 'Erased'."
            "Now Chandika was preparing to unsheathe that Sword of Wisdom which would deliver the absolute final verdict."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 23,
        sanskrit = "तमापतन्तं संप्रेक्ष्य देवी शूलेन वक्षसि ।\nविभेदयन्तं सा तदा पातयामास भूतले ॥ २३ ॥",
        hindi = """
            (त्रिशूल से वध): "अपनी ओर आते हुए उस असुर को देखकर, देवी ने अपने भयंकर 'शूल' (त्रिशूल) से उसकी छाती को चीर दिया।"
            "देवी के उस त्रिशूल के प्रहार से वह दैत्यराज शुम्भ उसी क्षण निर्जीव होकर धरती (भूतले) पर गिर पड़ा।"
            "छाती (Chest/Vakshasi) का फटना मतलब अहंकार के 'मैं-पन' के केंद्र का पूरी तरह से नष्ट हो जाना।"
            "त्रिशूल अज्ञान को 'तीन स्तरों' (भौतिक, मानसिक, आध्यात्मिक) पर एक साथ खत्म करने का प्रतीक है।"
            "जब सत्य का शूल हृदय को भेदता है, तो वह केवल शरीर को नहीं, बल्कि उस 'झूठी धारणा' को मारता है।"
            "शुम्भ का पतन 'अहंकार के साम्राज्य' के आधिकारिक अंत की घोषणा थी।"
            "भूतले (ज़मीन पर) गिरना यह सिद्ध करता है कि अंततः हर बुराई को धूल में ही मिलना है।"
            "यह वध कोई क्रूरता नहीं, बल्कि ब्रह्मांडीय न्याय (Cosmic Justice) की सबसे बड़ी आवश्यकता थी।"
            "जैसे ही शुम्भ गिरा, पूरे ब्रह्मांड में एक ऐसी शांति छा गई जो हज़ारों सालों से गायब थी।"
            "अब अज्ञान का वह काला अध्याय हमेशा के लिए बंद हो चुका था।"
        """.trimIndent(),
        english = """
            (Slaughter by the Trident): "Visually witnessing the demon approaching, the Goddess pierced his chest utilizing Her terrifying 'Trident'."
            "By the impact of that divine strike, Shumbha instantaneously dropped lifeless to the absolute ground (Bhutale)."
            "Ripping the chest symbolizes the total and permanent destruction of the Ego's central hub of 'I-ness'."
            "The Trident symbolizes the simultaneous termination of ignorance across 'Three Levels' (Physical, Mental, Spiritual)."
            "When the spear of Truth pierces the heart, it slaughters zero mere body, but the 'False Identity' itself."
            "Shumbha's collapse was the formal cosmic announcement of the total end of the 'Empire of Arrogance'."
            "Falling to the ground proves that ultimately every form of evil is mathematically destined to return to the dust."
            "This slaughter was zero cruelty; it was the absolute greatest necessity of 'Cosmic Justice' and order."
            "The exact split-second Shumbha fell, a peace enveloped the entire universe that had been missing for millennia."
            "The dark chapter of deep-seated ignorance was now officially and permanently closed forever."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 24,
        sanskrit = "स गतासुः पपातोर्व्यां त्रैलोक्यं सकलं ततः ।\nसपर्वतवनाधारं सप्रहर्षमभूत्तदा ॥ २४ ॥",
        hindi = """
            (जगत् की मुक्ति): "शुम्भ के प्राण निकलते ही वह धरती पर गिर पड़ा, और उसी क्षण समस्त 'त्रैलोक्य' (तीनों लोक) प्रसन्न हो उठे।"
            "पर्वतों, जंगलों और आधारों सहित यह पूरी पृथ्वी और ब्रह्मांड अत्यंत 'हर्ष' (सप्रहर्षम्) से भर गया।"
            "अहंकार का मरना केवल एक व्यक्ति की मौत नहीं है, बल्कि पूरे 'वातावरण' (Environment) की मुक्ति है।"
            "जब हमारे अंदर का 'मैं' मरता है, तो हमें पूरी दुनिया सुंदर और आनंदमयी लगने लगती है।"
            "सपर्वतवनाधारं (पहाड़ों और वनों सहित)—यह दर्शाता है कि अज्ञान का प्रभाव 'जड़' प्रकृति पर भी पड़ता था।"
            "अब नदियां फिर से शांत थीं, हवाएं शुद्ध थीं और पहाड़ों में एक दिव्य शांति लौट आई थी।"
            "हर्ष (Joy) उस 'नेचुरल स्टेट' (Natural State) का नाम है जो अहंकार के हटने के बाद अपने आप प्रकट होती है।"
            "सत्य की जीत ने ब्रह्मांड के उस 'इम्बैलेंस' (Imbalance) को ठीक कर दिया था जिसने सबको दुखी किया था।"
            "यह श्लोक 'कॉस्मिक हीलिंग' (Cosmic Healing) का सबसे सुंदर और सजीव चित्रण है।"
            "पूरी सृष्टि अब उस परम माता के चरणों में नतमस्तक होकर अपनी आज़ादी का जश्न मना रही थी।"
        """.trimIndent(),
        english = """
            (Liberation of the Universe): "As Shumbha's life-force exited, he fell to the earth, and instantaneously the 'Three Worlds' erupted in joy."
            "The entire earth including the mountains, forests, and foundations became filled with supreme 'Ecstasy' (Sapraharsham)."
            "The death of Arrogance is zero mere personal event; it represents the absolute liberation of the entire 'Environment'."
            "Exactly when our internal 'I' dies, the entire world mathematically transforms into a beautiful and blissful experience."
            "Including mountains and forests—this proves that the toxic influence of ignorance even affected inanimate 'Nature'."
            "Now the rivers were peaceful again, the winds were pure, and a divine silence returned to the mountains."
            "Ecstasy (Harsha) is the name of that 'Natural State' which manifests independently once the Ego is removed."
            "The victory of Truth corrected that cosmic 'Imbalance' which had previously tormented every living creature."
            "This verse serves as the most beautiful and vivid illustration of absolute 'Cosmic Healing' and restoration."
            "The entire creation was now celebrating its freedom while bowing at the absolute feet of the Supreme Mother."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 25,
        sanskrit = "ततः प्रसन्नमभवन्नभः शाम्यन्त्युपद्रवाः ।\nशान्तवह्निस्तथाकाशं प्रसन्नमभवन्नभः ॥ २५ ॥",
        hindi = """
            (प्राकृतिक शांति): "इसके बाद आकाश पूरी तरह 'प्रसन्न' (साफ़) हो गया और सारे 'उपद्रव' (बलाएं) हमेशा के लिए शांत हो गए।"
            "असुरों की वह विनाशकारी आग (वह्नि) बुझ गई और हवाएं अत्यंत सुखद और शीतल होकर बहने लगीं।"
            "आकाश का साफ़ होना इंसान के 'माइंड-स्पेस' (Mind Space) के क्लियर होने का प्रतीक है।"
            "जब अहंकार (धुआं) मिट जाता है, तो चेतना का नीला आकाश अपने आप चमकने लगता है।"
            "शाम्यन्त्युपद्रवाः (सारे दंगे शांत हो गए)—मन के अंदर जो चिंताओं का शोर था, वह अब पूरी तरह खत्म हो चुका था।"
            "अग्नि का शांत होना 'वासनाओं' और 'क्रोध' की आग के बुझ जाने का संकेत है।"
            "ब्रह्मांड अब वापस अपनी 'ऑरिजनल रिदम' (Original Rhythm) में लौट आया था।"
            "यह वह 'इटरनल पीस' (Eternal Peace) है जिसकी तलाश में हर योगी और साधक रहता है।"
            "जब आप सत्य को जान लेते हैं, तो बाहरी दुनिया के उपद्रव आपको परेशान करना बंद कर देते हैं।"
            "प्रकृति अब देवी की इस महाविजय पर अपनी 'प्रसन्नता' और आभार व्यक्त कर रही थी।"
        """.trimIndent(),
        english = """
            (Return of Natural Harmony): "Subsequently, the sky became perfectly 'Radiant' (Clear), and all 'Disturbances' (Upadravas) were pacified forever."
            "The destructive fires of the demons were extinguished, and the winds initiated blowing in a pleasant and cooling manner."
            "The clearing of the sky symbolizes the absolute 'Clarity' achieved within the human 'Mind-Space'."
            "Exactly when the smoke of Arrogance vanishes, the blue sky of Consciousness initiates shining independently."
            "Pacification of disturbances implies that the internal noise of worries and anxieties had completely perished."
            "The settling of fire indicates the absolute cooling of 'Lust' and 'Wrath' within the psychological system."
            "The universe had successfully returned strictly to its absolute 'Original Rhythm' and cosmic harmony."
            "This is that 'Eternal Peace' which every yogi and seeker desperately hunts throughout their existence."
            "When You successfully realize Truth, the disturbances of the external world permanently cease to affect You."
            "Nature was now expressing its absolute 'Satisfaction' and gratitude for this supreme victory of the Goddess."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 26,
        sanskrit = "नद्यो यथावद्वहन्त्यः प्रसरन्त्यो दिशस्त्विषा ।\nगावो हृष्टमानवाः समभवन् तदा ॥ २६ ॥",
        hindi = """
            (खुशहाली की वापसी): "नदियां अब अपने सही मार्ग (यथावत्) पर बहने लगीं और दसों दिशाएं प्रकाश से जगमगा उठीं।"
            "सभी मनुष्य और गौएं (प्राणी) अत्यंत 'हर्षित' और आनंदित मन वाले हो गए।"
            "नदियों का मार्ग पर बहना जीवन के 'नेचुरल फ्लो' (Natural Flow) के वापस आने का प्रतीक है।"
            "जब अहंकार हटता है, तो इंसान की रचनात्मकता और ऊर्जा सही दिशा में बहना शुरू कर देती है।"
            "दिशस्त्विषा (दिशाओं की चमक)—अंधकार अब कहीं नहीं था, केवल ज्ञान का प्रकाश हर कोने में था।"
            "गौएं (Cows) हमारी 'पवित्र इंद्रियों' का प्रतीक हैं जो अब शांत और तृप्त (Satisfied) हो चुकी थीं।"
            "मनुष्यों का खुश होना यह बताता है कि समाज में धर्म और न्याय की स्थापना हो चुकी थी।"
            "यह दृश्य 'सतयुग' (Golden Age) की वापसी जैसा अनुभव करा रहा था जहाँ कोई भय नहीं था।"
            "जब हम अपनी बुराई पर विजय पाते हैं, तो हमारे आसपास के लोग और प्रकृति—सब आनंदित होते हैं।"
            "सत्य की शक्ति ने जीवन के हर पहलू को फिर से 'जीवंत' (Alive) और सुंदर बना दिया था।"
        """.trimIndent(),
        english = """
            (Restoration of Prosperity): "Rivers initiated flowing strictly along their 'Natural Paths' (Yathavat), and all directions glowed with pure light."
            "Absolutely all humans and animals (Cows) became exceptionally 'Joyful' and possessed blissful minds."
            "The rivers returning to their path symbolizes the restoration of the 'Natural Flow' of human existence."
            "Exactly when Arrogance is removed, human creativity and energy initiate flowing in the absolute righteous direction."
            "Radiance in all directions implies that darkness was permanently deleted, replaced by the light of Wisdom."
            "Cows symbolize our 'Purified Senses' which were now perfectly calm, stable, and satisfied."
            "The joy of humans proves that Dharma and Justice were successfully re-established within society."
            "This scene evokes the experience of a 'Golden Age' (Satya Yuga) where zero fear or anxiety existed."
            "When we conquer our internal evil, the people around us and Mother Nature simultaneously share that ecstasy."
            "The power of Truth had rendered every microscopic aspect of life 'Vibrant' and beautiful once again."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 27,
        sanskrit = "जगौ मुदा गन्धर्वगणो ननृतुश्चाप्सरो गणाः ।\nवाद्यानि तत्र नेदुश्च शुभाः सन्तु सुरास्तदा ॥ २७ ॥",
        hindi = """
            (स्वर्गीय उत्सव): "गंधर्वों के समूह खुशी (मुदा) से गाने लगे और स्वर्ग की अप्सराएं मगन होकर नाचने लगीं।"
            "आकाश में दिव्य वाद्ययंत्र (Musicals) बजने लगे और सभी देवता पूरी तरह मंगलमय और शुभ हो गए।"
            "गाना और नाचना इंसान की 'सुप्त शक्तियों' (Latent Powers) के दोबारा जागने और उत्सव मनाने का प्रतीक है।"
            "जब मन से शुम्भ (अहंकार) निकल जाता है, तो अंदर का संगीत (Anahata Nada) अपने आप सुनाई देने लगता है।"
            "वाद्ययंत्रों की ध्वनि ब्रह्मांडीय लय (Cosmic Harmony) के वापस पटरी पर आने का संकेत है।"
            "देवता (सद्गुण) अब फिर से अपने यज्ञों का भाग लेने और ब्रह्मांड का संचालन करने के योग्य हो गए थे।"
            "यह जीत केवल देवी की नहीं थी, यह हर उस जीव की थी जो 'सत्य' के लिए तड़प रहा था।"
            "उत्सव (Celebration) यह बताता है कि आध्यात्मिकता कोई उदास सफर नहीं, बल्कि परम आनंद का मार्ग है।"
            "रणभूमि अब एक 'दिव्य रंगमंच' में बदल चुकी थी जहाँ केवल विजय के गीत गूंज रहे थे।"
            "यह दृश्य अज्ञान के अंत और 'ज्ञान के युग' के प्रारंभ की मुहर था।"
        """.trimIndent(),
        english = """
            (Celestial Celebration): "The bands of Gandharvas initiated singing with Joy (Muda), and the celestial Apsaras began their ecstatic dance."
            "Divine musical instruments resonated throughout the sky, and all the Gods became auspicious and holy once again."
            "Singing and dancing symbolize the re-awakening and celebration of a human's 'Latent Divine Powers'."
            "Exactly when Shumbha (Arrogance) exits the mind, the internal music (Anahata Nada) becomes independently audible."
            "The resonance of musical instruments signals that the 'Cosmic Harmony' has successfully returned to its tracks."
            "The Gods (Virtues) were now again eligible to receive their sacrificial portions and govern the universe."
            "This victory belonged zero to the Goddess alone; it belonged to every creature that yearned for absolute 'Truth'."
            "Celebration proves that Spirituality is mathematically zero depressed journey, but a path of absolute Bliss."
            "The battlefield had transformed into a 'Divine Stage' where exclusively the songs of victory resonated."
            "This specific visual served as the official seal for the end of ignorance and the birth of the 'Age of Wisdom'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 28,
        sanskrit = "जगुर्गन्धर्वपतयो ननृतुश्चाप्सरोगणाः ।\nववुर्वाताः शुभास्तत्र शान्ता अभवन् पावकाः ॥ २८ ॥",
        hindi = """
            (शांत वातावरण): "गंधर्वों के राजाओं ने गीत गाए और अप्सराओं के समूहों ने नृत्य किया, जिससे पूरा माहौल दिव्य हो गया।"
            "हवाएं अत्यंत शुभ और सुखद होकर बहने लगीं, और अग्नियां (पावकाः) अब शांत और पवित्र हो गईं।"
            "शांत अग्नि (Peaceful Fire) क्रोध के शांत होने और 'तपस्या' की अग्नि के जागने का प्रतीक है।"
            "जब अहंकार की आग बुझती है, तभी 'शांति' की शीतल हवा का अनुभव किया जा सकता है।"
            "प्रकृति का हर कण अब देवी की इस महाविजय का गवाह बन रहा था और अपना सम्मान अर्पित कर रहा था।"
            "यह श्लोक 'परम विश्राम' (Absolute Rest) की स्थिति को दर्शाता है जो युद्ध के अंत में मिलता है।"
            "जब आप अपने विकारों को मार देते हैं, तो आपका पूरा 'ओरा' (Aura) शुभ और प्रभावशाली हो जाता है।"
            "हवाओं का शुभ होना यह बताता है कि अब कोई 'नेगेटिव वाइब्रेशन' ब्रह्मांड में शेष नहीं बची थी।"
            "यह दृश्य शांति और शक्ति के उस 'परफेक्ट बैलेंस' का चित्रण है जिसे देवी ने स्थापित किया था।"
            "सृष्टि अब अपने नए और शुद्ध स्वरूप में सांस ले रही थी, जो अज्ञान के बोझ से मुक्त थी।"
        """.trimIndent(),
        english = """
            (The Peaceful Environment): "The kings of Gandharvas sang and the Apsaras danced, rendering the entire environment divine."
            "Auspicious and pleasant winds initiated flowing, and the cosmic fires (Pavakah) became peaceful and holy."
            "Peaceful Fire symbolizes the absolute cooling of wrath and the awakening of the fire of 'Auspicity'."
            "Strictly when the fire of Arrogance is extinguished, can the cooling breeze of 'Peace' be successfully experienced."
            "Every particle of Nature was now witnessing the Goddess's supreme victory and offering its cosmic respect."
            "This verse illustrates that state of 'Absolute Rest' achieved specifically at the conclusion of a psychological war."
            "Exactly when You slaughter Your mental distortions, Your entire 'Aura' becomes auspicious and influential."
            "The auspiciousness of the winds proves that mathematically zero 'Negative Vibrations' remained in the cosmos."
            "This visual depicts the 'Perfect Balance' between Peace and Power established by the Divine Mother."
            "Creation was now breathing in its brand-new and pure format, entirely liberated from the burden of ignorance."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 29,
        sanskrit = "ततो देवगणाः सर्वे हते शुम्भे महासुरे ।\nनिशुम्भे च महावीर्ये हर्षनिर्भयचेतसः ॥ २९ ॥",
        hindi = """
            (निर्भयता का वरदान): "महा-असुर शुम्भ और महा-पराक्रमी निशुम्भ के मारे जाने पर, सभी देवताओं का मन 'हर्ष' और 'निर्भयता' (निर्भयचेतसः) से भर गया।"
            "अब उनके मन में किसी भी प्रकार का कोई डर (Fear) या चिंता शेष नहीं रही थी।"
            "निर्भयता (Fearlessness) आध्यात्मिक यात्रा की सबसे बड़ी उपलब्धि मानी जाती है।"
            "जब अहंकार (I) और ममता (Mine) मर जाते हैं, तो डर अपने आप गायब हो जाता है, क्योंकि खोने के लिए कुछ नहीं बचता।"
            "देवता अब अपने 'असली स्वरूप' में आ चुके थे, जहाँ वे ब्रह्मांड का कल्याण बिना किसी दबाव के कर सकते थे।"
            "शुम्भ-निशुम्भ का अंत वास्तव में इंसान के 'साइकोलॉजिकल डार्कनेस' (Psychological Darkness) का अंत है।"
            "जब आप निर्भय होते हैं, तभी आप 'ईश्वर' के सबसे करीब होते हैं और असली शांति का अनुभव करते हैं।"
            "यह श्लोक अज्ञान के ऊपर ज्ञान की उस 'अंतिम मुहर' (Final Seal) की तरह है जो आज़ादी की घोषणा करती है।"
            "रणभूमि अब एक ऐसे तीर्थ में बदल चुकी थी जहाँ केवल कृतज्ञता (Gratitude) और भक्ति की लहरें थीं।"
            "देवताओं का यह 'निर्भय मन' अब देवी की उस 'महा-स्तुति' के लिए तैयार था जो अगले अध्याय में आएगी।"
        """.trimIndent(),
        english = """
            (The Gift of Fearlessness): "Upon the death of Shumbha and Nishumbha, the minds of all the Gods became filled with 'Ecstasy' and 'Fearlessness' (Nirbhaya-chetasah)."
            "Mathematically zero traces of fear or anxiety remained within their psychological system."
            "Fearlessness is considered the absolute greatest achievement of any spiritual or internal journey."
            "When Arrogance (I) and Attachment (Mine) are annihilated, Fear independently vanishes as zero remains to be lost."
            "The Gods had returned to their 'Authentic Nature', where they could govern the universe without external pressure."
            "The end of Shumbha and Nishumbha is actually the termination of the human 'Psychological Darkness'."
            "Strictly when You are Fearless, You are closest to the Divine and experience absolute profound peace."
            "This verse acts as the 'Final Seal' of Wisdom over ignorance, officially declaring absolute cosmic freedom."
            "The battlefield had transformed into a pilgrimage site, overflowing with waves of Gratitude and devotion."
            "This 'Fearless Mind' of the Gods was now prepared for that 'Great Praise' which arrives in the subsequent chapter."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 30,
        sanskrit = "इत्याज्ञाप्यासुरपतिः शुम्भो भैरवशासनः ।\nनिर्गत्य स महासैन्यैर्बहुभिर्वृतः ॥ ३० ॥",
        hindi = """
            (असुरों का पतन): "असुरों का वह राजा शुम्भ, जो कभी 'भैरव' (भयानक) शासन करता था, अब अपनी पूरी सेना के साथ धूल में मिल चुका था।"
            "उसकी वह लाखों की सेना, जिस पर उसे बहुत घमंड था, अब केवल एक 'इतिहास' बनकर रह गई थी।"
            "यह श्लोक 'शक्ति के दुरुपयोग' (Abuse of Power) के परिणाम को बहुत ही संक्षेप और गहराई से समझाता है।"
            "अहंकार जब गिरता है, तो वह अपने साथ अपने पूरे 'सिस्टम' (System) को भी ले डूबता है।"
            "शुम्भ की सेना उसकी 'दबी हुई वासनाओं' का प्रतीक थी, जो अब पूरी तरह से 'क्लीन' हो चुकी थीं।"
            "जब चेतना (देवी) जागती है, तो अज्ञान के हज़ारों सैनिक एक पल में गायब हो जाते हैं।"
            "यह अंत यह सिखाता है कि बिना 'चरित्र' के केवल ताकत इंसान को विनाश की ओर ही ले जाती है।"
            "सत्य की एक 'हुंकार' ने शुम्भ के उस विशाल साम्राज्य को हमेशा के लिए मिट्टी में मिला दिया।"
            "रणभूमि अब पूरी तरह शांत थी, जो अज्ञान के पूर्ण विसर्जन (Dissolution) का प्रतीक था।"
            "अब केवल सत्य का प्रकाश और देवी की असीमित करुणा ही शेष बची थी।"
        """.trimIndent(),
        english = """
            (The Downfall of Demons): "The King of Demons, Shumbha, who once maintained a 'Bhairava' (Terrifying) reign, was now reduced to dust with his army."
            "His army of millions, which served as the source of his extreme pride, was now merely a part of history."
            "This verse profoundly explains the mathematical result of the 'Abuse of Power' and cosmic arrogance."
            "Exactly when Arrogance collapses, it drags its entire supporting 'System' down into the abyss with it."
            "Shumbha's army symbolized his 'Suppressed Cravings', which were now successfully and entirely 'Cleansed'."
            "The moment Consciousness (Goddess) awakens, thousands of soldiers of ignorance vanish in a single microsecond."
            "This end teaches that raw power without 'Character' mathematically drives a human toward absolute self-destruction."
            "A single 'Humkara' of Truth reduced Shumbha's colossal empire into common dirt for all eternity."
            "The battlefield was now perfectly silent, symbolizing the total Dissolution of ignorance into the Void."
            "Strictly only the light of Truth and the Goddess's infinite compassion remained as the absolute reality."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 31,
        sanskrit = "पुनश्चाप्युवाच सा देवी निशुम्भं निहतं रणे ।\nशुम्भं चातिबलं दृष्ट्वा कोपेन व्याकुलाक्षरम् ॥ ३१ ॥",
        hindi = """
            (देवी का अंतिम वचन): "रणभूमि में निशुम्भ को मरा हुआ और शुम्भ को क्रोध से व्याकुल (व्याकुलाक्षरम्) देखकर देवी ने फिर से कहा।"
            "देवी की वाणी में अब साक्षात् 'ब्रह्मांडीय सत्य' (Cosmic Truth) की वह गूंज थी जो अंतिम फैसला सुनाती है।"
            "व्याकुलाक्षरम् (लड़खड़ाते शब्द)—अहंकार जब पूरी तरह हार जाता है, तो उसकी आवाज़ भी उसका साथ छोड़ देती है।"
            "शुम्भ अब केवल चिल्ला रहा था, पर उसके पास कोई 'पावर' या 'लॉजिक' नहीं बचा था।"
            "देवी ने उसे दिखाया कि उसकी सारी 'अतिबल' (Extreme Power) सत्य के सामने कितनी खोखली थी।"
            "यह वह अंतिम संवाद है जहाँ 'अहंकार' को उसकी नश्वरता (Mortality) का आईना दिखाया जा रहा है।"
            "जब इंसान अपने पतन के करीब होता है, तो उसे अपनी सारी सफलताएं महज़ एक 'बोझ' लगने लगती हैं।"
            "देवी का स्वर अब भी शांत और अजेय था, जो उनकी 'सुप्रीम अथॉरिटी' का प्रमाण है।"
            "अब वे उस 'महा-वध' की ओर बढ़ रही थीं जो ब्रह्मांड के सारे दुखों का अंत करने वाला था।"
            "यह श्लोक अज्ञान के ऊपर 'चेतना की पूर्ण विजय' का सबसे बड़ा और अंतिम दस्तावेज़ है।"
        """.trimIndent(),
        english = """
            (The Goddess's Final Words): "Witnessing Nishumbha slaughtered and Shumbha trembling with incoherent rage (Vyakulaksharam), the Goddess spoke again."
            "Her voice now contained the absolute resonance of 'Cosmic Truth' delivering the absolute final verdict of the universe."
            "'Vyakulaksharam' (Stammering/Disturbed words) proves that when Arrogance is defeated, even its voice fails to support it."
            "Shumbha was merely shouting now, possessing mathematically zero 'Power' or 'Logic' to sustain his claims."
            "The Goddess demonstrated exactly how hollow his perceived 'Extreme Power' was in the presence of the Absolute."
            "This is the absolute final dialogue where 'Arrogance' is shown the mirror of its own pathetic Mortality."
            "Exactly when a human is close to their fall, all their past successes appear merely as an exhausting 'Burden'."
            "The Goddess's tone remained calm and invincible, serving as the absolute evidence of Her 'Supreme Authority'."
            "She was now moving toward that 'Great Slaughter' which would terminate absolutely all cosmic suffering."
            "This verse serves as the absolute greatest and final document of the 'Total Victory of Consciousness' over ignorance."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 32,
        sanskrit = "रक्षणाय च लोकानां देवानामुपकारिणी ।\nतच्छृणुष्व मयाऽऽख्यातं यथावत्कथयामि ते ॥ ३२ ॥\n\n(इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये शुम्भनिशुम्भप्रमथनं नाम दशमोऽध्यायः ॥ १० ॥)",
        hindi = """
            (अध्याय का समापन): "लोकों की रक्षा करने वाली और देवताओं का उपकार करने वाली देवी के इस चरित्र को मैंने तुम्हें विस्तार से सुनाया।"
            "यहीं पर श्री मार्कण्डेय पुराण में वर्णित 'शुम्भ-निशुम्भ वध' नामक दुर्गा सप्तशती का दसवां अध्याय पूर्ण होता है।"
            "यह अध्याय 'अहंकार के पूर्ण विसर्जन' (Dissolution of Ego) का सबसे बड़ा प्रमाण है।"
            "इंसान के अंदर का 'मैं' (शुम्भ) और 'मेरा' (निशुम्भ) जब पूरी तरह मिट जाते हैं, तभी 'परम सुख' मिलता है।"
            "यथावत् कथयामि (जैसा है वैसा ही)—ऋषि मेधा ने इस सत्य को राजा सुरथ के हृदय में स्थापित कर दिया है।"
            "अब राजा सुरथ (भटका हुआ मन) यह समझ चुका है कि उसकी असली ताकत 'देवी' (आत्मा) की शरण में ही है।"
            "यह समापन हमें यह संदेश देता है कि बुराई चाहे कितनी भी बड़ी क्यों न हो, सत्य के एक प्रहार से वह राख हो जाती है।"
            "अब ब्रह्मांड पूरी तरह से 'पवित्र' (Purified) हो चुका था और अगली बड़ी स्तुति के लिए तैयार था।"
            "साधक अब इस दसवें अध्याय के बाद 'आत्मज्ञान' के उस स्तर पर पहुँच चुका है जहाँ कोई भ्रम बाकी नहीं रहता।"
            "सत्यमेव जयते—सत्य की हमेशा जीत होती है और अज्ञान का अंत हमेशा निश्चित होता है।"
        """.trimIndent(),
        english = """
            (Conclusion of the Chapter): "I have narrated to You this history of the Goddess who protects the worlds and executes favors for the Gods."
            "Right exactly here successfully concludes the Tenth Chapter of the text, named 'The Slaughter of Shumbha and Nishumbha'."
            "This chapter acts as the absolute evidence of the 'Total Dissolution of the Ego' (Arrogance)."
            "Exactly when the human concepts of 'I' (Shumbha) and 'Mine' (Nishumbha) are erased, absolute 'Supreme Bliss' is achieved."
            "'Narrated Exactly'—Sage Medha has successfully implanted this Truth directly into the heart of King Suratha."
            "King Suratha (The Wandering Mind) now understands that his true strength resides strictly in surrendering to the 'Goddess' (Soul)."
            "This conclusion delivers the message that regardless of the scale of evil, a single blow of Truth reduces it to ashes."
            "The universe was now completely 'Purified' and prepared for the absolute greatest praise in the subsequent chapters."
            "Following this Tenth Chapter, the practitioner has reached that level of 'Self-Realization' where zero delusion remains."
            "Truth eternally reigns supreme, and the termination of deep-seated ignorance is mathematically perpetually certain."
        """.trimIndent()
    )
)