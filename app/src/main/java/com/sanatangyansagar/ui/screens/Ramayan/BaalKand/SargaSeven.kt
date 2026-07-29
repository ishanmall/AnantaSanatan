package com.sanatangyansagar.ui.screens.Ramayan.BaalKand

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SargaSevenScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaSevenData
        } else {
            sargaSevenData.filter {
                it.id.toString().contains(searchQuery) ||
                        it.sanskrit.contains(searchQuery, ignoreCase = true) ||
                        it.hindiCommentary.contains(searchQuery, ignoreCase = true) ||
                        it.englishCommentary.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color.White)) {
                CenterAlignedTopAppBar(
                    title = {
                        Text("सप्तम सर्ग - अमात्य वर्णन", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFE0B2) // Sacred Saffron
                    )
                )
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("खोजें (श्लोक संख्या या शब्द)...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFF5F5F5),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFFF3E0)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(filteredVerses) { verse ->
                RamayanDetailCard(verse)
            }

            if (filteredVerses.isEmpty()) {
                item {
                    Text(
                        "कोई परिणाम नहीं मिला।",
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

val sargaSevenData = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "तस्यामात्या गुणैरासन्निक्ष्वाकोस्तु महात्मनः ।\nमन्त्रज्ञाश्चेङ्गितज्ञाश्च नित्यं प्रियहिते रताः ॥ १ ॥",
        hindiCommentary = """
            इक्ष्वाकु वंश में उत्पन्न हुए उन महात्मा राजा दशरथ के सभी अमात्य (मंत्री) अत्यंत श्रेष्ठ और दिव्य गुणों से संपन्न थे।
            वे सभी मंत्री मन्त्रणा (कूटनीति) के ज्ञाता थे, दूसरे के मन के भावों को बिना कहे ही समझ लेने वाले (इङ्गितज्ञाः) थे।
            वे सदैव राजा और अपनी प्रजा के प्रिय तथा हितकारी कार्यों में ही निरंतर लगे रहते थे।
            'इङ्गितज्ञाः' होना एक प्रशासक का सबसे बड़ा गुण है, जिससे वे संकट के उत्पन्न होने से पहले ही उसे भाँप लेते थे।
            मन्त्रज्ञा का अर्थ है कि वे राज्य के रहस्यों और नीतियों को गोपनीय रखने तथा उनका सही समय पर प्रयोग करने में निपुण थे।
            दशरथ का राज्य केवल उनके बाहुबल पर नहीं, बल्कि इन मंत्रियों की बौद्धिक संपदा पर खड़ा था।
            वाल्मीकि जी स्पष्ट करते हैं कि एक महान राजा की असली शक्ति उसकी अपनी नहीं, बल्कि उसके सलाहकारों की 'गुणवत्ता' होती है।
            'नित्यं प्रियहिते रताः' यह सिद्ध करता है कि वे चाटुकार नहीं थे; वे वही करते थे जो राज्य के लिए लाभदायक हो, चाहे वह कड़वा ही क्यों न हो।
            इन मंत्रियों का आचरण पूरी तरह से निस्वार्थ था, वे सत्ता का उपयोग व्यक्तिगत लाभ के लिए कभी नहीं करते थे।
            यह श्लोक 'सुशासन' (Good Governance) का वह मूल मंत्र है जिस पर अयोध्या का वह स्वर्णिम काल टिका हुआ था।
            राजा और मंत्रियों के बीच का यह अटूट विश्वास ही रघुकुल को पूरे विश्व में अजेय और पूजनीय बनाता था।
        """.trimIndent(),
        englishCommentary = """
            The Amatyas (ministers) of the high-souled King Dasharatha, born in the Ikshvaku dynasty, were endowed with supreme and divine virtues.
            They were profound experts in political counsel (Mantrajnah) and were incredibly adept at reading the unexpressed thoughts and intentions of others (Ingitajnah).
            They were perpetually and singularly devoted (Ratah) to executing actions that were both pleasing and beneficial to the King and his subjects.
            Being 'Ingitajnah' (readers of gestures) is the hallmark of a master administrator, allowing them to anticipate and neutralize crises before they even sprouted.
            'Mantrajnah' signifies their absolute mastery in formulating state policies and strictly safeguarding the utmost confidential secrets of the empire.
            Dasharatha’s unassailable reign stood not merely on His physical prowess, but heavily on the intellectual wealth of these councilors.
            Valmiki explicitly clarifies that the true strength of a great monarch lies fundamentally in the pristine 'quality' of his chosen advisors.
            'Nityam priyahite ratah' proves they were not sycophants; they executed what was genuinely beneficial for the nation, even if the truth was bitter.
            The conduct of these ministers was thoroughly selfless; they absolutely never exploited their immense political power for any personal gain.
            This verse introduces the core mantra of 'Good Governance' upon which the golden era of Ayodhya’s history firmly rested.
            The unbreakable mutual trust between the King and His ministers is what rendered the Solar Dynasty globally invincible and highly revered.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 2,
        sanskrit = "अष्टौ बभूवुर्वीरस्य तस्यामात्या यशस्विनः ।\nशुचयश्चानुरक्ताश्च राजकृत्येषु नित्यशः ॥ २ ॥",
        hindiCommentary = """
            उन शूरवीर और प्रतापी राजा दशरथ के दरबार में आठ अत्यंत यशस्वी और प्रसिद्ध अमात्य (मंत्री) नियुक्त थे।
            वे सभी मंत्री मन, वचन और कर्म से अत्यंत पवित्र (शुचयः) थे और राज्य के कार्यों (राजकृत्येषु) में सदा अनुरक्त (समर्पित) रहते थे।
            'अष्टौ' (आठ) की संख्या बताती है कि प्रशासनिक सुविधा के लिए राज्य के कार्यभार को आठ मुख्य विभागों में बहुत वैज्ञानिक ढंग से बांटा गया था।
            यशस्वी होने का अर्थ है कि उनके न्याय और उनकी सत्यनिष्ठा की ख्याति केवल अयोध्या में नहीं, बल्कि दूर-दूर के जनपदों में भी फैली हुई थी।
            पवित्रता (शुचयः) का गुण यह सुनिश्चित करता था कि राज्य के खजाने में कभी भ्रष्टाचार न हो और न्याय में कभी कोई पक्षपात न हो।
            'अनुरक्ताः' शब्द यह प्रमाणित करता है कि राजकाज उनके लिए केवल एक नौकरी नहीं थी, बल्कि यह उनके जीवन की एक आध्यात्मिक साधना (तपस्या) थी।
            वे राजा के आदेशों का पालन भय से नहीं, बल्कि प्रेम और गहरे राष्ट्र-धर्म के कारण करते थे।
            वाल्मीकि जी यहाँ बता रहे हैं कि एक आदर्श शासन तभी संभव है जब मंत्रियों का चरित्र स्वयं शीशे की तरह साफ और पारदर्शी हो।
            आठ मंत्रियों की यह परिषद राजा के लिए एक 'सुरक्षा कवच' के समान थी जो हर प्रकार की राजनीतिक और सामाजिक आपदा को रोक लेती थी।
            यही वह प्रशासनिक ढाँचा था जिसने आगे चलकर भगवान राम को एक सुव्यवस्थित और समृद्ध राज्य विरासत में दिया।
        """.trimIndent(),
        englishCommentary = """
            In the grand court of that heroic and majestic King Dasharatha, there were exactly eight highly illustrious and renowned ministers.
            They were exceptionally pure (Shuchayah) in mind, word, and deed, and remained perpetually dedicated (Anuraktah) to their royal and state duties.
            The specific number 'Eight' indicates a highly scientific and systematic division of administrative portfolios for the smooth functioning of the state.
            Being 'Yashasvinah' (illustrious) means the tales of their absolute justice and integrity were celebrated not just locally, but across distant lands.
            The virtue of absolute purity (Shuchayah) ensured that corruption never touched the state treasury and partiality never tainted their justice.
            The term 'Anuraktah' certifies that statecraft was not merely an official job for them; it was a deeply spiritual penance and their life's calling.
            They executed the King's commands not out of bureaucratic fear, but out of profound love and a deeply ingrained sense of national duty (Rashtra-dharma).
            Valmiki emphasizes that ideal governance is only possible when the character of the governing ministers is as clean and transparent as flawless glass.
            This council of eight served as an impenetrable 'Armor' for the King, effortlessly blocking every political, social, and economic catastrophe.
            This was the very administrative infrastructure that eventually provided Lord Rama with a perfectly organized and prosperous kingdom as His heritage.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 3,
        sanskrit = "धृष्टिर्जयन्तो विजयः सिद्धार्थो ह्यर्थसाधकः ।\nअशोको मन्त्रपालश्च सुमन्त्रश्चाष्टमोऽभवत् ॥ ३ ॥",
        hindiCommentary = """
            राजा दशरथ के उन आठ मंत्रियों के नाम थे—धृष्टि, जयन्त, विजय, सिद्धार्थ, अर्थसाधक, अशोक, मन्त्रपाल और आठवें 'सुमन्त्र'।
            इन आठों मंत्रियों के नाम अत्यंत अर्थपूर्ण हैं, जो उनके व्यक्तिगत गुणों और उनके द्वारा संभाले जाने वाले विभागों की ओर सीधा संकेत करते हैं।
            'धृष्टि' अदम्य साहस का प्रतीक थे, जबकि 'जयन्त' और 'विजय' राज्य के लिए सदा अजेय सफलता सुनिश्चित करते थे।
            'सिद्धार्थ' हर योजना को पूर्णता तक पहुँचाने वाले थे और 'अर्थसाधक' राज्य की अर्थव्यवस्था और खजाने (Treasury) के मुख्य रक्षक थे।
            'अशोक' वह मंत्री थे जो प्रजा के दुखों को दूर कर उन्हें शोक-रहित रखते थे, और 'मन्त्रपाल' राज्य के कूटनीतिक रहस्यों के परम रक्षक थे।
            इन सबमें 'सुमन्त्र' सबसे विशेष थे, जो राजा के सारथी होने के साथ-साथ उनके सबसे विश्वस्त और निकटतम निजी सलाहकार भी थे।
            वाल्मीकि जी ने इन नामों के माध्यम से यह दर्शाया है कि अयोध्या की कैबिनेट में शक्ति, अर्थव्यवस्था, कूटनीति और न्याय का एक आदर्श संतुलन था।
            यह कोई साधारण मंत्रिमंडल नहीं था, बल्कि यह उन महापुरुषों का समूह था जिन्होंने अपना पूरा जीवन इक्ष्वाकु वंश की सेवा में समर्पित कर दिया था।
            इन आठों के सहयोग और सर्वसम्मति से ही राजा दशरथ कोई भी नया नियम या सामरिक निर्णय लेते थे।
            ये नाम आज भी राजशास्त्र (Political Science) में सत्यनिष्ठा और प्रशासनिक दक्षता के अमर प्रतीक माने जाते हैं।
        """.trimIndent(),
        englishCommentary = """
            The names of those eight ministers of King Dasharatha were: Dhrishti, Jayanta, Vijaya, Siddhartha, Arthasadhaka, Ashoka, Mantrapala, and the eighth was 'Sumantra.'
            The names of these eight counselors are profoundly meaningful, directly reflecting their individual virtues and their specific administrative portfolios.
            'Dhrishti' symbolized indomitable courage, while 'Jayanta' and 'Vijaya' ensured absolute and unyielding success for the state in all its endeavors.
            'Siddhartha' was the accomplisher of all state projects, and 'Arthasadhaka' acted as the chief guardian of the state's economy and royal treasury.
            'Ashoka' was the minister responsible for eradicating the people's miseries, while 'Mantrapala' was the ultimate protector of highly classified diplomatic secrets.
            Among them, 'Sumantra' was the most exceptional, serving not only as the King’s royal charioteer but as His most trusted, intimate, and senior-most advisor.
            Through these names, Valmiki brilliantly illustrates that Ayodhya's cabinet possessed a flawless balance of power, economics, diplomacy, and pure justice.
            This was no ordinary council; it was an elite assembly of great men who had dedicated their entire existence to the selfless service of the Ikshvaku dynasty.
            It was solely with the unanimous cooperation and consent of these eight that King Dasharatha executed any new law or strategic military decision.
            Even today, these names stand eternally immortalized in ancient political science as the ultimate symbols of integrity and supreme administrative efficiency.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 4,
        sanskrit = "ऋत्विजौ द्वावभिमतौ तस्यास्तामृषिसत्तमौ ।\nवसिष्ठो वामदेवश्च मन्त्रिणश्च तथापरे ॥ ४ ॥",
        hindiCommentary = """
            इन आठ मंत्रियों के अतिरिक्त, राजा दशरथ के दरबार में दो अत्यंत मान्य और ऋषियों में श्रेष्ठ 'ऋत्विज' (राजपुरोहित) निवास करते थे।
            वे दोनों परम ज्ञानी ऋषि 'वसिष्ठ' और 'वामदेव' थे; इनके साथ-साथ धर्म और शास्त्रों के ज्ञाता कुछ अन्य मंत्री (सलाहकार) भी सभा में उपस्थित रहते थे।
            राजपुरोहित का कार्य केवल यज्ञ या पूजा-पाठ तक सीमित नहीं था; वे राज्य की सर्वोच्च 'नैतिक सत्ता' (Moral Authority) का प्रतिनिधित्व करते थे।
            महर्षि वसिष्ठ रघुकुल के कुलगुरु थे, जिनकी सहमति के बिना राजा दशरथ कोई भी बड़ा राजनैतिक या पारिवारिक निर्णय नहीं लेते थे।
            वामदेव जी न्यायशास्त्र और वेदों के प्रकांड विद्वान थे, जो राज्य की नीतियों को धर्म की कसौटी पर कसने का महत्वपूर्ण कार्य करते थे।
            'अभिमतौ' शब्द का अर्थ है कि इन दोनों ऋषियों का समाज और राजा की दृष्टि में अत्यंत उच्च और निर्विवाद सम्मान था।
            अयोध्या के इस शासन-प्रबंध में लौकिक शक्ति (राजा/मंत्री) और पारलौकिक ज्ञान (ऋषि) का एक अत्यंत सुंदर और दुर्लभ संतुलन (Balance of Power) था।
            जहाँ सत्ता को ज्ञान का अंकुश प्राप्त हो, वहाँ राजा कभी निरंकुश (Dictator) नहीं बन सकता, यही वाल्मीकि जी का मुख्य संदेश है।
            इन ऋषियों के तपोबल के कारण ही अयोध्या नगरी किसी भी प्राकृतिक या कृत्रिम आपदा से पूरी तरह सुरक्षित रहती थी।
            यह श्लोक सनातन परंपरा के उस सिद्धांत को पुष्ट करता है जहाँ 'ब्रह्म-तेज' (आध्यात्म) को 'क्षात्र-तेज' (राजसत्ता) से ऊपर रखा गया है।
        """.trimIndent(),
        englishCommentary = """
            In addition to those eight ministers, there resided two highly esteemed and supreme sages who served as the 'Ritvijas' (Royal Priests) in Dasharatha's court.
            These two immensely wise seers were 'Vashistha' and 'Vamadeva'; alongside them, several other ministers and scriptural scholars were also present.
            The role of a Royal Priest was not confined merely to rituals; they represented the highest and most absolute 'Moral Authority' of the state.
            Maharishi Vashistha was the family preceptor (Kula-Guru), without whose express consent King Dasharatha never executed any major political or familial decision.
            Vamadeva was an unparalleled scholar of jurisprudence and the Vedas, performing the critical task of testing state policies against the touchstone of Dharma.
            The word 'Abhimatau' implies that these two sages commanded supreme, unquestionable, and universally accepted respect from both the King and society.
            This governance structure in Ayodhya featured an incredibly rare and beautiful 'Balance of Power' between temporal might (King) and transcendental wisdom (Sages).
            Valmiki's core message here is that when worldly power is continuously guided and checked by spiritual wisdom, a monarch can never become an autocratic dictator.
            It was entirely due to the immense penance of these seers that the city of Ayodhya remained completely shielded from any natural or artificial calamities.
            This verse powerfully reinforces the Sanatan principle where 'Brahma-Tejas' (Spiritual Brilliance) is always placed above 'Kshatra-Tejas' (Temporal/Royal Power).
        """.trimIndent()
    ),
    RamayanVerse(
        id = 5,
        sanskrit = "विद्याविनीता ह्रीमन्तः कुशला नियतेन्द्रियाः ।\nपरस्परानुरक्ताश्च नीतिमन्तो बहुश्रुताः ॥ ५ ॥",
        hindiCommentary = """
            वे सभी मंत्री अपनी विद्या (ज्ञान) के कारण अत्यंत विनम्र (विनीता) थे, उनके भीतर लज्जा (ह्रीमन्तः) थी, और वे कार्यों में अत्यंत कुशल थे।
            उन्होंने अपनी इंद्रियों को पूरी तरह वश में (नियतेन्द्रियाः) कर लिया था, वे एक-दूसरे से प्रेम (परस्परानुरक्ताः) करते थे, नीतिवान थे और बहुश्रुत (विद्वान) थे।
            'विद्याविनीता' यह सिद्ध करता है कि उच्च शिक्षा और पद ने उन्हें अहंकारी नहीं बनाया, बल्कि वे ज्ञान के भार से फलों से लदे वृक्ष की तरह और झुक गए थे।
            'ह्रीमन्तः' (लज्जाशील) होने का अर्थ है कि वे कोई भी ऐसा अनैतिक या अनुचित कार्य करने से डरते थे जिससे राज्य या उनके चरित्र पर दाग लगे।
            इंद्रियों पर नियंत्रण (नियतेन्द्रियाः) एक प्रशासक का सबसे आवश्यक गुण है, जिससे वह कभी भ्रष्टाचार या वासना का शिकार नहीं होता।
            उन मंत्रियों में आपस में कोई ईर्ष्या या राजनीतिक गुटबाजी नहीं थी; 'परस्परानुरक्ताः' बताता है कि वे एक परिवार की तरह एकजुट होकर काम करते थे।
            'नीतिमन्तो' और 'बहुश्रुताः' का अर्थ है कि उन्होंने अनेक शास्त्रों का श्रवण किया था और वे कूटनीति के सभी रहस्यों को भली-भांति समझते थे।
            वाल्मीकि जी यहाँ बता रहे हैं कि एक आदर्श मंत्रिमंडल (Cabinet) केवल बुद्धिमानी से नहीं, बल्कि नैतिक शुद्धता और टीम-वर्क से बनता है।
            इन गुणों के कारण ही अयोध्या का प्रशासन बिना किसी विवाद या गतिरोध के सुचारू रूप से चलता रहता था।
            यह श्लोक आधुनिक काल के राजनेताओं के लिए एक सीधा और स्पष्ट 'मार्गदर्शक सिद्धांत' (Guiding Principle) प्रस्तुत करता है।
        """.trimIndent(),
        englishCommentary = """
            All those ministers were profoundly humble due to their vast education (Vidyavinita), possessed a sense of moral shame (Hrimantah), and were highly skilled.
            They had completely conquered their senses (Niyatendriyah), held deep mutual affection for one another (Parasparanuraktah), were ethical, and widely learned (Bahushrutah).
            'Vidyavinita' proves that high education and status did not make them arrogant; rather, like a tree laden with fruit, they bowed down with true humility.
            Being 'Hrimantah' (possessing moral shame) means they possessed an inherent fear of committing any unethical act that could tarnish their own or the state's pristine character.
            Control over the senses (Niyatendriyah) is the most vital trait for an administrator, ensuring they never fall prey to deep-seated corruption or blinding lust.
            There was no toxic jealousy or political factionalism among them; 'Parasparanuraktah' indicates they functioned cohesively, exactly like a tightly-knit family.
            'Nitimanto' and 'Bahushrutah' signify that they had listened to and absorbed numerous scriptures and completely understood all the complex secrets of diplomacy.
            Valmiki demonstrates here that an ideal Cabinet is forged not merely by raw intelligence, but essentially through moral purity and exceptional teamwork.
            Because of these exact virtues, Ayodhya’s entire administration operated flawlessly, devoid of any internal conflicts or bureaucratic gridlocks.
            This verse presents a very direct, clear, and timeless 'Guiding Principle' for modern-day politicians, civil servants, and state leaders.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 6,
        sanskrit = "श्रीमन्तश्च महात्मानः शास्त्रज्ञा धृढविक्रमाः ।\nकीर्तिमन्तः प्रणिहिता यथावचनकारिणः ॥ ६ ॥",
        hindiCommentary = """
            वे मंत्री अत्यंत शोभाशाली (श्रीमन्त), महान आत्मा वाले (महात्मानः), सभी शास्त्रों के ज्ञाता और युद्ध में अत्यंत दृढ़ पराक्रमी (धृढविक्रमाः) थे।
            वे अपने सुकर्मों के कारण कीर्तिमान थे, हमेशा राजकाज में सावधान (प्रणिहिता) रहते थे, और राजा की आज्ञा का अक्षरशः पालन (यथावचनकारिणः) करते थे।
            'श्रीमन्त' का अर्थ केवल धनी होना नहीं है, बल्कि उनके व्यक्तित्व में एक ऐसा तेज था जो देखने वालों को सहज ही प्रभावित कर लेता था।
            'धृढविक्रमाः' शब्द स्पष्ट करता है कि वे केवल कलम के सिपाही नहीं थे; संकट आने पर वे सेनापति बनकर युद्ध के मैदान में भी दुश्मनों के छक्के छुड़ा सकते थे।
            उनका महान आत्मा होना यह सुनिश्चित करता था कि उनके सभी निर्णय स्वार्थ से प्रेरित न होकर केवल जनकल्याण के लिए होते थे।
            'प्रणिहिता' (सावधान) का अर्थ है कि वे राज्य की सुरक्षा और गुप्तचर व्यवस्था को लेकर चौबीसों घंटे सतर्क रहते थे; आलस्य उनके जीवन में नहीं था।
            'यथावचनकारिणः' यह बताता है कि राजा दशरथ और उनके मंत्रियों के बीच पूर्ण सामंजस्य था—राजा जो नीति बनाते, मंत्री उसे तुरंत बिना किसी विलंब के लागू करते थे।
            एक अच्छे प्रशासक को बुद्धिमान होने के साथ-साथ आज्ञाकारी भी होना चाहिए, यह गुण अयोध्या के मंत्रियों में कूट-कूट कर भरा था।
            वाल्मीकि जी ने यहाँ एक सर्वांगीण (All-rounder) व्यक्तित्व का चित्र खींचा है, जो शास्त्रों में भी पारंगत है और शस्त्रों में भी।
            इसी अद्वितीय कार्यकुशलता के कारण ही इक्ष्वाकु वंश का प्रताप पूरे आर्यावर्त में एक चमकते सूर्य के समान फैला हुआ था।
        """.trimIndent(),
        englishCommentary = """
            Those ministers were extremely glorious (Shrimantah), high-souled (Mahatmanah), experts in scriptures, and possessed an unwavering, firm valor in battle (Dridhavikramah).
            They were widely renowned for their noble deeds, perpetually vigilant in state affairs (Pranihita), and executed the King's commands exactly as instructed (Yathavachanakarinah).
            'Shrimanta' does not merely mean wealthy; it implies their personalities emanated a radiant aura that naturally and effortlessly influenced all onlookers.
            The term 'Dridhavikramah' clarifies that they were not just bureaucrats of the pen; in crises, they could lead armies and completely crush enemies on the battlefield.
            Being 'Mahatmanah' ensured that their decisions were never driven by petty selfishness, but were formulated exclusively for the ultimate welfare of the public.
            'Pranihita' (vigilant) means they remained alert round-the-clock regarding state security and intelligence; lethargy and negligence had no place in their lives.
            'Yathavachanakarinah' shows the perfect synergy between King Dasharatha and His council—whatever policy the King decreed, the ministers implemented it without any delay.
            A superior administrator must be highly intelligent as well as obedient to the sovereign; this trait was ingrained deeply within Ayodhya’s ministers.
            Valmiki paints the picture of a true 'All-rounder' personality here, someone who is an absolute master of both Shastras (scriptures) and Shastras (weapons).
            It was entirely due to this unique and unmatched operational efficiency that the glory of the Ikshvaku dynasty shone across Aryavarta like a brilliant sun.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 7,
        sanskrit = "तेजः क्षमा यशः प्राप्ताः स्मितपूर्वाभिभाषिणः ।\nक्रोधात्कामार्थहेतोर्वा न ब्रूयुरनृतं वचः ॥ ७ ॥",
        hindiCommentary = """
            वे मंत्री तेज, क्षमा और यश से पूर्णतः संपन्न थे; वे किसी से भी बात करते समय पहले मुस्कुराते थे (स्मितपूर्वाभिभाषिणः) और फिर मधुरता से बोलते थे।
            वे इतने सत्यनिष्ठ थे कि चाहे कितना ही क्रोध आ जाए, या काम (इच्छा) और अर्थ (धन) का कितना ही बड़ा प्रलोभन हो, वे कभी झूठ (अनृतं) नहीं बोलते थे।
            'तेज' उन्हें अपराधियों के सामने कठोर बनाता था, परंतु 'क्षमा' का गुण उन्हें निर्बलों और भूल करने वालों के प्रति अत्यंत दयालु बनाए रखता था।
            किसी से भी बात करने से पहले 'मुस्कुराना' एक श्रेष्ठ लोक-सेवक का वह गुण है जो प्रजा के मन से भय को निकालकर उनके बीच विश्वास और अपनत्व पैदा करता है।
            सत्य पर टिके रहना सामान्य परिस्थितियों में सरल है, परंतु क्रोध, लोभ या दबाव में सत्य बोलना ही एक मनुष्य के चरित्र की असली और सबसे बड़ी परीक्षा होती है।
            वाल्मीकि जी यह स्पष्ट कर रहे हैं कि अयोध्या का प्रशासन किसी भी प्रकार की रिश्वत (अर्थ) या वासना (काम) के सामने कभी झुकता नहीं था।
            वे मंत्री अपना कार्य एक निष्काम कर्मयोगी की तरह करते थे, जहाँ सत्य ही उनका सबसे बड़ा धर्म और रक्षक था।
            जहाँ शासन-तन्त्र की वाणी में इतनी पवित्रता और पारदर्शिता हो, वहाँ समाज में किसी भी प्रकार का भ्रष्टाचार या अपराध पनप ही नहीं सकता।
            यह श्लोक दशरथ के मंत्रियों के उस 'इमोशनल और एथिकल' (Emotional and Ethical) संतुलन को अत्यंत सुंदरता से दर्शाता है।
            यही वह पवित्र आचरण था जिसने अयोध्या को पृथ्वी पर 'राम-राज्य' की स्थापना के लिए सबसे उपयुक्त और पवित्र भूमि बनाया।
        """.trimIndent(),
        englishCommentary = """
            Those ministers had fully attained brilliance, forgiveness, and fame; whenever they conversed with anyone, they always preceded their speech with a gentle smile (Smitapurvabhibhashinah).
            They were so staunchly truthful that neither out of blinding anger, nor for the sake of desire (Kama) or immense wealth (Artha), would they ever utter a single falsehood (Anritam).
            Their 'Tejas' (brilliance) made them formidable before criminals, while their 'Kshama' (forgiveness) kept them profoundly compassionate towards the weak and the repentant.
            Smiling before speaking is the hallmark of a superior public servant, as it instantly eradicates fear from the citizens' minds and fosters deep trust and affinity.
            Upholding the truth is easy in normal times, but remaining truthful under the intense pressure of anger, greed, or lust is the ultimate test of a man's character.
            Valmiki explicitly clarifies here that Ayodhya’s administration never bowed down or compromised its integrity before any form of bribery (Artha) or dark temptation (Kama).
            Those ministers executed their duties exactly like selfless Karma-Yogis, where Absolute Truth was their greatest religion and ultimate protector.
            When the speech of the governing body possesses such pristine purity and transparency, no form of systemic corruption or crime can ever breed in that society.
            This verse beautifully illustrates the highly refined 'Emotional and Ethical' balance maintained flawlessly by King Dasharatha's council of ministers.
            It was this very immaculate conduct that transformed Ayodhya into the most suitable and holiest ground for the eventual establishment of 'Ram-Rajya' on earth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 8,
        sanskrit = "तेषामविदितं किञ्चत् स्वेषु नास्ति परेषु वा ।\nक्रियमाणं कृतं वापि चारेणापि चिकीर्षितम् ॥ ८ ॥",
        hindiCommentary = """
            उन मंत्रियों के लिए अपने राष्ट्र (स्वेषु) या शत्रुओं के राष्ट्र (परेषु) में ऐसा कुछ भी नहीं था जो उनसे अज्ञात (अविदितं) या छिपा हुआ हो।
            चाहे कोई कार्य किया जा रहा हो (क्रियमाणं), किया जा चुका हो (कृतं), या भविष्य में करने की योजना (चिकीर्षितम्) हो, वे गुप्तचरों (चार) के माध्यम से सब कुछ जान लेते थे।
            यह श्लोक अयोध्या की 'खुफिया प्रणाली' (Intelligence and Espionage System) की अत्यधिक अचूक और उन्नत व्यवस्था का साक्षात् प्रमाण है।
            एक सुरक्षित राज्य के लिए केवल अपनी सीमाओं की जानकारी होना पर्याप्त नहीं है, बल्कि पड़ोसी और शत्रु राज्यों की हर हलचल पर पैनी नज़र रखना अनिवार्य है।
            वर्तमान, भूत और भविष्य की योजनाओं को गुप्तचरों द्वारा जान लेने की यह क्षमता अयोध्या को किसी भी 'सरप्राइज़ अटैक' (Surprise Attack) से सुरक्षित रखती थी।
            मंत्रीगण अपने महलों में बैठकर ही पूरे आर्यावर्त की राजनीतिक और सामाजिक गतिविधियों का सटीक विश्लेषण करने में पूरी तरह सक्षम थे।
            वाल्मीकि जी यह बता रहे हैं कि एक कुशल प्रशासक की आँखें केवल उसके चेहरे पर नहीं होतीं, बल्कि उसके गुप्तचर ही उसकी असली आँखें होते हैं।
            यह सतर्कता और सूचना का तंत्र ही वह कारण था जिससे राजा दशरथ के शासनकाल में राज्य के भीतर कभी कोई विद्रोह पनप नहीं पाया।
            यह श्लोक राजशास्त्र के उस सिद्धांत को पुष्ट करता है कि 'सूचना ही शक्ति है' (Information is Power)।
            अमात्यों का यह गुण उन्हें एक साधारण मंत्री से उठाकर एक उच्च कोटि का 'स्ट्रैटेजिस्ट' (Strategist) और कूटनीतिज्ञ बनाता था।
        """.trimIndent(),
        englishCommentary = """
            For those highly capable ministers, absolutely nothing remained unknown (Aviditam) or hidden, whether it occurred within their own nation (Sveshu) or in enemy territories (Pareshu).
            Whether an action was currently being executed (Kriyamanam), had already been completed (Kritam), or was merely being planned for the future (Chikirshitam), they knew it all through their spies (Char).
            This verse serves as direct and irrefutable evidence of the incredibly accurate, advanced, and robust 'Intelligence and Espionage System' operating in ancient Ayodhya.
            For a state to remain secure, merely knowing one's own borders is insufficient; keeping a razor-sharp eye on every single movement of neighboring and enemy states is mandatory.
            The ability to uncover present, past, and future conspiracies through spies kept Ayodhya completely immune and heavily guarded against any sort of 'Surprise Attack.'
            While seated in their royal palaces, the ministers were fully capable of accurately analyzing the complex political and social dynamics of the entire Aryavarta.
            Valmiki implies here that an efficient administrator's true eyes are not the ones on his face; rather, his vast network of embedded spies serves as his real vision.
            This hyper-vigilance and seamless information network were the exact reasons why no internal rebellion could ever breed or succeed during King Dasharatha’s reign.
            This verse powerfully reinforces the eternal political doctrine that 'Information is Power,' a concept mastered brilliantly by the Ikshvaku dynasty.
            This exceptional trait elevated the Amatyas from being ordinary administrative clerks to the highly revered status of elite 'Strategists' and master diplomats.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 9,
        sanskrit = "कुशला व्यवहारेषु सौहृदेषु परीक्षिताः ।\nप्राप्तकालं तु ते दण्डं धारयेयुः सुतेष्वपि ॥ ९ ॥",
        hindiCommentary = """
            वे मंत्री राज्य के सभी व्यवहारों (कानून, न्याय और प्रशासन) में अत्यंत कुशल थे और मित्रता (सौहृदेषु) की कसौटी पर पूरी तरह से परखे हुए (परीक्षिताः) थे।
            वे न्याय के इतने कठोर पक्षधर थे कि समय आने पर (प्राप्तकालं) यदि उनका अपना सगा पुत्र भी अपराध करे, तो वे उसे भी दंड देने से तनिक नहीं हिचकते थे।
            'व्यवहार' शब्द प्राचीन भारतीय न्याय-प्रणाली का सूचक है, जहाँ संपत्ति, अपराध और सामाजिक विवादों का निष्पक्ष रूप से निपटारा किया जाता था।
            मित्रता में परखे जाने का अर्थ है कि वे राजा दशरथ के केवल वेतनभोगी कर्मचारी नहीं थे, बल्कि सुख-दुख के सच्चे और विश्वस्त मित्र थे।
            अपने ही पुत्र को दंड देने की भावना उनके 'निष्पक्ष न्याय' (Impartial Justice) और 'कानून के शासन' (Rule of Law) का सबसे बड़ा और कठोर उदाहरण है।
            राज्य के नियमों के सामने उनके लिए कोई भी सगा, संबंधी या प्रियजन विशेष नहीं था; 'सत्य और धर्म' ही उनका एकमात्र परिवार था।
            वाल्मीकि जी ने यहाँ स्पष्ट किया है कि जब सत्ता के सर्वोच्च शिखर पर बैठे लोग भाई-भतीजावाद (Nepotism) से मुक्त होते हैं, तो प्रजा भी अपराध से दूर रहती है।
            यह श्लोक सिद्ध करता है कि अयोध्या का न्याय अँधा नहीं था, बल्कि वह बिना किसी भेदभाव के हर अपराधी पर समान रूप से प्रहार करता था।
            मंत्री का यह गुण उसे एक साधारण राजनेता से उठाकर साक्षात् 'धर्मराज' (यमराज) के समान निष्पक्ष और पूजनीय बना देता है।
            इस प्रकार का निष्कलंक और अत्यंत कठोर प्रशासनिक मॉडल ही राम-राज्य की भूमिका तैयार करने में सबसे बड़ा कारण सिद्ध हुआ।
        """.trimIndent(),
        englishCommentary = """
            Those ministers were exceptionally skilled in all state affairs and jurisprudence (Vyavahareshu), and had been thoroughly tested and proven (Parikshitah) in their steadfast friendship.
            They were such staunch advocates of absolute justice that when the time demanded (Praptakalam), they would not hesitate to inflict rightful punishment even upon their own sons.
            The term 'Vyavahara' refers to the ancient Indian judicial system, where disputes regarding property, crime, and social issues were settled with absolute impartiality.
            Being tested in friendship implies that they were not mere salaried employees of King Dasharatha; they were His truest, most loyal, and reliable companions in joy and sorrow.
            The willingness to punish their own offspring stands as the greatest, strictest, and most profound example of their 'Impartial Justice' and adherence to the 'Rule of Law.'
            Before the stringent laws of the state, they recognized no relatives, favorites, or loved ones; 'Truth and Dharma' constituted their one and only true family.
            Valmiki clarifies here that when those seated at the very pinnacle of power are completely free from Nepotism, the general populace naturally and fearfully abstains from crime.
            This verse proves that Ayodhya’s justice system was not blind; rather, it struck down every offender equally, without the slightest trace of discrimination or bias.
            This specific virtue elevates a minister from an ordinary politician to a figure as impeccably impartial and venerable as 'Dharmaraja' (the Lord of Justice) himself.
            Such an unblemished, rigorous, and highly objective administrative model served as the primary and strongest foundation for the upcoming and legendary Ram-Rajya.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 10,
        sanskrit = "कोशसङ्ग्रहणे युक्ता बलस्य च परिग्रहे ।\nअहितं वाऽपि पुरुषं न विहिंस्युरदूषकम् ॥ १० ॥",
        hindiCommentary = """
            वे मंत्री राजकोष (खजाने) को न्यायपूर्ण ढंग से भरने (सङ्ग्रहणे) और सेना (बल) का विस्तार (परिग्रहे) करने के कार्यों में निरंतर तत्पर रहते थे।
            परंतु वे इतने न्यायप्रिय थे कि यदि कोई व्यक्ति उनका शत्रु (अहितं) भी हो, लेकिन उसने कोई अपराध (अदूषकम्) न किया हो, तो वे उसे कभी हानि नहीं पहुँचाते थे।
            कोश-संग्रहण किसी भी राज्य की आर्थिक रीढ़ होता है, और ये मंत्री बिना प्रजा पर अनुचित कर (Tax) लगाए, धर्मपूर्वक खजाने की वृद्धि करते थे।
            सेना का परिग्रह यह सुनिश्चित करता था कि अयोध्या की सीमाएं किसी भी विदेशी आक्रमण से पूरी तरह सुरक्षित रहें और सैनिक हमेशा युद्ध के लिए सज्ज रहें।
            शत्रु होने पर भी निर्दोष को दंड न देना, यह उनके चरित्र की सबसे महान और दैवीय ऊँचाई को दर्शाता है।
            अक्सर सत्ता में बैठे लोग अपने पद का दुरुपयोग करके अपने व्यक्तिगत विरोधियों को कुचल देते हैं, परंतु अयोध्या के मंत्रियों में यह दुर्गुण बिल्कुल नहीं था।
            वाल्मीकि जी यहाँ बता रहे हैं कि राज्य की शक्ति का उपयोग केवल 'अपराध' को रोकने के लिए होना चाहिए, 'प्रतिशोध' के लिए नहीं।
            उनका कानून केवल साक्ष्यों और सत्य पर आधारित था, व्यक्तिगत पसंद या नापसंद पर नहीं।
            यह श्लोक 'ह्यूमन राइट्स' (Human Rights) और निष्पक्ष न्याय-प्रणाली का एक अत्यंत प्राचीन और गौरवशाली उदाहरण प्रस्तुत करता है।
            ऐसी धर्मनिष्ठ और शक्तिशाली मंत्रिपरिषद के कारण ही कोसल देश की प्रजा पूरी तरह से निर्भय और सुखी थी।
        """.trimIndent(),
        englishCommentary = """
            The ministers were continuously and diligently engaged in justly enriching the royal treasury (Koshagrahane) and actively expanding and organizing the state's armed forces (Bala).
            However, their sense of justice was so profound that even if a man was their known enemy (Ahitam), they would never harm him if he was entirely innocent of any crime (Adushakam).
            Enriching the treasury forms the economic spine of any state, and these ministers achieved this righteously without ever imposing unjust or oppressive taxes on the subjects.
            The expansion of the military ensured that Ayodhya's borders remained completely impregnable to foreign attacks and that the soldiers were always battle-ready.
            Refraining from punishing an innocent person, even if he happens to be a personal adversary, showcases the greatest, most divine, and elevated peak of their moral character.
            Often, those in power misuse their authority to ruthlessly crush their personal opponents, but this dark vice was absolutely non-existent among the noble ministers of Ayodhya.
            Valmiki is highlighting here that the immense power of the state must be utilized exclusively for preventing 'Crime,' and never ever as a tool for personal 'Revenge.'
            Their legal system was grounded purely on solid evidence and absolute Truth, rather than on personal whims, likes, or dislikes.
            This verse serves as a highly ancient, glorious, and perfect example of modern concepts like 'Human Rights' and a completely unbiased, objective judicial system.
            It was precisely because of such a righteous and powerful council of ministers that the citizens of the Kosala country lived in a state of total fearlessness and profound happiness.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 11,
        sanskrit = "वीराश्च नियतोत्साहा राजशास्त्रमनुव्रताः ।\nशुचीनां रक्षितारश्च नित्यं विषयवासिनाम् ॥ ११ ॥",
        hindiCommentary = """
            वे सभी मंत्री अत्यंत वीर थे, जिनका उत्साह कभी कम नहीं होता था (नियतोत्साहा), और वे राजनीति-शास्त्र (राजशास्त्र) के नियमों का दृढ़ता से पालन करने वाले थे।
            वे अपने राज्य (विषय) में निवास करने वाले पवित्र और शरीफ नागरिकों (शुचीनां) की हमेशा रक्षा करने के लिए तत्पर रहते थे।
            'नियतोत्साहा' का अर्थ है कि राजकाज के बोझिल और जटिल कार्यों को करते हुए भी वे कभी थकावट या निराशा का शिकार नहीं होते थे।
            राजशास्त्र (Political Science) का अनुव्रत (पालन) करने का अर्थ है कि वे अपनी मनमर्जी से नहीं, बल्कि प्राचीन ऋषियों द्वारा रचित संविधान के अनुसार ही राज्य चलाते थे।
            एक अच्छे शासक का मुख्य कर्तव्य 'सज्जनों की रक्षा' और 'दुष्टों का विनाश' होता है, जिसे ये मंत्री पूरी सत्यनिष्ठा से निभाते थे।
            'शुचीनां रक्षितारश्च' यह सिद्ध करता है कि जो नागरिक कानून का पालन करते थे, उन्हें राज्य की ओर से पूर्ण सुरक्षा और सम्मान की गारंटी (Guarantee) प्राप्त थी।
            वीरता का उपयोग उन्होंने कभी किसी को डराने के लिए नहीं किया, बल्कि वह वीरता प्रजा को एक अभेद्य सुरक्षा-कवच प्रदान करने के लिए थी।
            वाल्मीकि जी यहाँ एक ऐसे 'सक्रिय प्रशासन' (Proactive Administration) का वर्णन कर रहे हैं जो समस्या आने से पहले ही उसका समाधान खोज लेता है।
            मंत्रियों का यह असीम उत्साह ही पूरी प्रजा के भीतर ऊर्जा और राष्ट्र-प्रेम का संचार करता था।
            यह श्लोक स्पष्ट करता है कि दशरथ के राज्य में 'गुड गवर्नेंस' (Good Governance) कोई नारा नहीं, बल्कि एक जीवंत और निरंतर चलने वाली प्रक्रिया थी।
        """.trimIndent(),
        englishCommentary = """
            All those ministers were exceptionally heroic, possessed a constant and unwavering enthusiasm (Niyatotsaha), and strictly adhered to the intricate laws of political science (Rajashastra).
            They remained perpetually ready and committed to protecting the pure, honest, and law-abiding citizens (Shuchinam) residing within their kingdom (Vishaya).
            'Niyatotsaha' signifies that despite the heavy, complex, and highly demanding burdens of statecraft, they never fell prey to mental fatigue, burnout, or crippling despair.
            Following 'Rajashastra' implies that they did not govern based on arbitrary personal whims, but strictly according to the established constitution laid down by ancient, realized seers.
            The primary duty of a noble ruler is the 'protection of the righteous' and the 'destruction of the wicked,' a mandate these ministers executed with absolute, unyielding integrity.
            'Shuchinam rakshitarashcha' proves that citizens who faithfully abided by the law received an ironclad guarantee of total security, dignity, and respect from the state apparatus.
            They never utilized their heroic valor to intimidate the masses; rather, that immense power functioned as an impenetrable, protective shield for the innocent public.
            Valmiki describes a highly 'Proactive Administration' here—one that identifies, confronts, and completely resolves potential issues long before they can escalate into crises.
            This boundless and contagious enthusiasm of the ministers naturally infused the entire populace with vibrant energy and a profound sense of patriotism.
            This verse clearly establishes that in King Dasharatha’s realm, 'Good Governance' was not merely a hollow political slogan, but a living, breathing, and continuous daily reality.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 12,
        sanskrit = "ब्रह्मक्षत्रमहिंसन्तस्ते कोशं समवर्धयन् ।\nसुतीक्ष्णदण्डाः सम्प्रेक्ष्य पुरुषस्य बलाबलम् ॥ १२ ॥",
        hindiCommentary = """
            वे मंत्री ब्राह्मणों (ज्ञानियों) और क्षत्रियों (रक्षकों) को किसी भी प्रकार की पीड़ा या हानि पहुँचाए बिना (अहिंसन्तः) राज्य के खजाने को निरंतर बढ़ाते थे।
            परंतु जब दंड देने का समय आता था, तो वे अपराधी के शारीरिक और मानसिक बल-अबल (ताकत और कमजोरी) को अच्छी तरह परखकर ही अत्यंत तीक्ष्ण (कठोर) दंड देते थे।
            'ब्रह्मक्षत्रमहिंसन्तः' का अर्थ है कि वे राज्य की कर (Tax) नीति को इतना संतुलित रखते थे कि समाज के बौद्धिक और सैन्य वर्ग पर कोई अनुचित आर्थिक दबाव न पड़े।
            एक राज्य का विकास तभी संभव है जब उसके विचारक (ब्राह्मण) और योद्धा (क्षत्रिय) बिना किसी शोषण के स्वतंत्र रूप से अपना कार्य कर सकें।
            खजाना बढ़ाना आवश्यक था, पर वह प्रजा का खून चूसकर नहीं, बल्कि व्यापार और उचित नीतियों के माध्यम से बढ़ाया जाता था।
            'सुतीक्ष्णदण्डाः' यह बताता है कि वे मंत्री बाहर से जितने सौम्य थे, न्याय की कुर्सी पर बैठकर वे उतने ही कठोर और निर्मम हो जाते थे।
            दंड देते समय 'बलाबलम्' (Strength and weakness) का विचार करना प्राचीन भारतीय न्याय प्रणाली (Jurisprudence) की एक बहुत बड़ी वैज्ञानिक और मनोवैज्ञानिक विशेषता है।
            किसी कमजोर व्यक्ति को ऐसा दंड न दिया जाए जो वह सह न सके, और किसी ताकतवर को इतना हल्का दंड न मिले कि वह सुधरे ही नहीं—यह उनका सिद्धांत था।
            वाल्मीकि जी ने इस श्लोक में 'आर्थिक नीति' (Economic Policy) और 'दंड नीति' (Penal Code) का सबसे श्रेष्ठ और संतुलित रूप प्रस्तुत किया है।
            इसी न्यायपूर्ण और संवेदनशील व्यवस्था ने अयोध्या को पृथ्वी का सबसे सुखी और समृद्ध राष्ट्र बना दिया था।
        """.trimIndent(),
        englishCommentary = """
            Those ministers continuously expanded the state treasury without ever causing any harm, distress, or unjust oppression (Ahinsantah) to the Brahmins (scholars) and Kshatriyas (warriors).
            However, when it came to delivering justice, they inflicted extremely severe punishments (Sutikshnadandah) only after meticulously evaluating the specific strength and weakness (Balabalam) of the offender.
            'Brahmakshatramahinsantah' implies that they kept the taxation policies perfectly balanced, ensuring the intellectual and military classes faced no undue economic burden or exploitation.
            A state can only truly flourish when its thinkers (Brahmins) and its defenders (Kshatriyas) operate freely and efficiently without facing systemic harassment.
            Enriching the treasury was vital, but it was achieved through flourishing trade and fair policies, never by bleeding the innocent subjects dry.
            'Sutikshnadandah' reveals that while the ministers were gentle externally, they transformed into strict, ruthless, and unyielding judges when seated on the chair of justice.
            Considering the 'Balabalam' (physical/mental capacity) of a convict before sentencing is a highly scientific, psychological, and advanced feature of ancient Indian Jurisprudence.
            Their core principle was: a weak person shouldn't receive a fatal punishment they cannot endure, and a powerful man shouldn't get a light sentence that fails to reform him.
            In this verse, Valmiki presents the most superior, enlightened, and perfectly balanced fusion of 'Economic Policy' and 'Penal Code' known to mankind.
            It was precisely this sensitive yet fiercely just system that elevated Ayodhya into the happiest, most prosperous, and secure nation on the face of the earth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 13,
        sanskrit = "शुचीनामेकबुद्धीनां सर्वेषां सम्प्रजानताम् ।\nनासीत्पुरे वा राष्ट्रे वा मृषावादी नरः क्वचित् ॥ १३ ॥",
        hindiCommentary = """
            उन अत्यंत पवित्र (शुचीनां), एक समान विचारधारा वाले (एकबुद्धीनां) और सब कुछ जानने वाले (सम्प्रजानताम्) मंत्रियों के कुशल शासन में—
            अयोध्या नगर (पुरे) या संपूर्ण कोसल राष्ट्र में कहीं पर भी कोई एक भी झूठ बोलने वाला (मृषावादी) व्यक्ति मौजूद नहीं था।
            'एकबुद्धीनां' का अर्थ है कि उन आठों मंत्रियों के बीच किसी भी नीति को लेकर कोई मतभेद या वैचारिक टकराव नहीं होता था; वे सब एक दिशा में सोचते थे।
            जब नेतृत्व (Leadership) एक सुर में बात करता है, तो राज्य की प्रशासनिक मशीनरी कभी भ्रमित नहीं होती और पूरी गति से कार्य करती है।
            मंत्रियों का 'सम्प्रजानताम्' (सब कुछ जानने वाला) होना यह सिद्ध करता है कि उनका सूचना-तंत्र इतना मजबूत था कि राज्य में कुछ भी छिप नहीं सकता था।
            झूठ न बोलना (मृषावादी का अभाव) किसी भी समाज की सबसे बड़ी नैतिक उपलब्धि है, जो यह बताती है कि लोग भय या लालच से पूरी तरह मुक्त थे।
            जब समाज में न्याय सुलभ हो और शासक स्वयं सत्यवादी हों, तो प्रजा को अपने बचाव या लाभ के लिए झूठ का सहारा लेने की आवश्यकता ही नहीं पड़ती।
            वाल्मीकि जी ने यहाँ एक ऐसे 'आदर्श यूटोपियन समाज' (Ideal Utopian Society) का चित्रण किया है, जहाँ नैतिकता केवल किताबों में नहीं, बल्कि लोगों के आचरण में थी।
            यह श्लोक सिद्ध करता है कि राम के अवतार से पूर्व ही, राजा दशरथ और उनके मंत्रियों ने अयोध्या की भूमि को सत्य और धर्म के तप से पूरी तरह शुद्ध कर दिया था।
            एक ऐसा राष्ट्र जहाँ झूठ का कोई अस्तित्व न हो, वह केवल एक राजनीतिक सत्ता नहीं, बल्कि साक्षात् स्वर्ग का ही एक भौतिक रूप बन जाता है।
        """.trimIndent(),
        englishCommentary = """
            Under the highly efficient administration of those utterly pure (Shuchinam), like-minded (Ekabuddhinam), and all-knowing (Samprajanatam) ministers—
            There was absolutely not a single person anywhere, either in the capital city (Pure) or throughout the entire nation (Rashtre), who ever spoke a lie (Mrishavadi).
            'Ekabuddhinam' signifies that there was absolutely no ideological friction or political conflict among the eight ministers; they thought and acted in perfect, unified synergy.
            When the core Leadership speaks with one unified voice, the entire administrative machinery remains free from confusion and operates at its maximum potential.
            The ministers being 'Samprajanatam' (all-knowing) proves that their intelligence network was incredibly flawless, making it impossible to hide anything in the state.
            The total absence of liars (Mrishavadi) is the greatest moral triumph of any civilization, indicating that the citizens were entirely free from fear, oppression, or greed.
            When justice is easily accessible and the rulers themselves embody absolute Truth, the subjects never feel the desperate need to resort to falsehood for survival or profit.
            Valmiki depicts an 'Ideal Utopian Society' here, where high morality was not confined to philosophical texts but vibrantly lived and practiced in daily human conduct.
            This verse proves that even before Lord Rama’s divine incarnation, King Dasharatha and his council had completely purified the soil of Ayodhya through the fire of Truth and Dharma.
            A nation where falsehood holds zero existence transcends being a mere political entity; it literally transforms into the physical manifestation of heaven on earth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 14,
        sanskrit = "कश्चिन्न दुष्टस्तत्रासीत्परदाररतो नरः ।\nप्रशान्तं सर्वमेवासीद्राष्ट्रं पुरवरं च तत् ॥ १४ ॥",
        hindiCommentary = """
            उस राज्य में कोई भी व्यक्ति दुष्ट प्रकृति का नहीं था, और न ही कोई ऐसा मनुष्य था जो पराई स्त्रियों (परदार) में आसक्त या बुरी नज़र रखने वाला हो।
            वह संपूर्ण राष्ट्र (कोसल) और वह श्रेष्ठ नगरी (पुरवरं - अयोध्या) पूरी तरह से शांति, सुरक्षा और परम संतोष (प्रशान्तं) में मग्न थी।
            'दुष्ट' का न होना यह प्रमाणित करता है कि समाज में आपराधिक प्रवृत्तियाँ (Criminal Tendencies) शून्य के स्तर पर पहुँच चुकी थीं।
            'परदाररतो न' का अर्थ है कि पुरुषों का चरित्र अत्यंत उच्च और पवित्र था; वे पराई स्त्री को माता या बहन के समान ही आदर देते थे।
            किसी भी राष्ट्र का पतन तब होता है जब वहाँ स्त्रियों का सम्मान समाप्त हो जाता है; अयोध्या में नारी-सम्मान अपनी सर्वोच्च अवस्था में था।
            जब समाज के नागरिक स्वयं अपनी इंद्रियों पर नियंत्रण रखते हैं, तो राज्य में चोरी, व्यभिचार या हिंसा जैसे अपराध स्वतः ही समाप्त हो जाते हैं।
            'प्रशान्तं सर्वमेवासीत्' यह दर्शाता है कि वहां कोई राजनीतिक उथल-पुथल, दंगे, या सामाजिक तनाव नहीं था; सब कुछ एक दिव्य लय में चल रहा था।
            वाल्मीकि जी ने इस श्लोक के माध्यम से यह स्पष्ट किया है कि 'सुशासन' का अंतिम लक्ष्य महलों का निर्माण नहीं, बल्कि समाज में इस 'प्रशांति' को स्थापित करना है।
            राजा दशरथ के मंत्रियों ने अपनी नीतियों और व्यक्तिगत उदाहरणों से समाज को इतना सुसंस्कृत बना दिया था कि पुलिस या दंड की आवश्यकता ही नगण्य हो गई थी।
            यह श्लोक भारतीय संस्कृति के उस चरम चारित्रिक उत्कर्ष का वर्णन करता है जिसे 'राम-राज्य' की वास्तविक नींव माना जाता है।
        """.trimIndent(),
        englishCommentary = """
            In that kingdom, there was absolutely no individual of wicked disposition, nor was there any man who lusted after or harbored evil intentions toward another's wife (Paradararato).
            That entire nation of Kosala and that most excellent city of Ayodhya (Puravaram) existed in a state of absolute, profound, and uninterrupted peace (Prashantam).
            The absence of any 'wicked' person confirms that criminal tendencies and malicious behavior within the society had been successfully eradicated down to absolute zero.
            'Paradararato na' implies that the moral character of the men was exceptionally high and pure; they viewed and respected every other woman purely as a mother or sister.
            The downfall of any nation begins when the dignity of its women is compromised; in Ayodhya, the respect and security afforded to women were at their absolute zenith.
            When the citizens of a society exercise strict self-control over their own senses, crimes like theft, adultery, and violence automatically cease to exist.
            'Prashantam sarvamevasit' signifies that there was no political turmoil, no riots, and no social tension whatsoever; everything functioned in a perfect, divine rhythm.
            Through this verse, Valmiki clarifies that the ultimate goal of 'Good Governance' is not merely building grand palaces, but establishing this deep, pervasive 'Tranquility' in society.
            King Dasharatha’s ministers, through their flawless policies and personal examples, had cultured the society to such a degree that the need for police or punitive force became negligible.
            This verse beautifully describes the ultimate peak of moral excellence in Indian culture, which serves as the true, unshakeable foundation of the legendary 'Ram-Rajya.'
        """.trimIndent()
    ),
    RamayanVerse(
        id = 15,
        sanskrit = "सुवाससः सुवेषाश्च ते च सर्वे सुशीलिनः ।\nहितार्थं च नरेन्द्रस्य जाग्रतो नयचक्षुषा ॥ १५ ॥",
        hindiCommentary = """
            वे सभी मंत्री अत्यंत सुंदर और उत्तम वस्त्र (सुवाससः) तथा गरिमापूर्ण वेशभूषा (सुवेषाश्च) धारण करते थे, और उन सभी का स्वभाव अत्यंत उत्तम (सुशीलिनः) था।
            वे राजा दशरथ (नरेन्द्र) के कल्याण और राज्य के हित के लिए अपनी 'नीति रूपी आँखों' (नयचक्षुषा) से हमेशा जागते (सतर्क रहते) थे।
            उत्तम वस्त्र और वेशभूषा यह दर्शाती है कि मंत्रीगण अपने पद की गरिमा और राजसी शिष्टाचार (Protocol) का पूर्ण रूप से पालन करते थे; उनका बाहरी स्वरूप उनके आंतरिक तेज को झलकाता था।
            'सुशीलिनः' होना यह प्रमाणित करता है कि इतना शक्ति और ऐश्वर्य होने के बावजूद उनमें रत्ती भर भी अक्खड़पन या अहंकार नहीं था; वे सबसे अत्यंत विनम्रता से मिलते थे।
            'जाग्रतो नयचक्षुषा' रामायण का एक अत्यंत शक्तिशाली राजनीतिक सूत्र है—इसका अर्थ है कि एक राजनेता कभी सोता नहीं है, उसकी नीति और कूटनीति की आँखें चौबीसों घंटे खुली रहती हैं।
            वे केवल शारीरिक रूप से पहरा नहीं देते थे, बल्कि अपनी दूरदृष्टि और बुद्धि से राज्य पर आने वाले हर अदृश्य संकट को पहले ही देख लेते थे।
            राजा का 'हितार्थं' (कल्याण) उनके जीवन का एकमात्र लक्ष्य था; वे जानते थे कि राजा सुरक्षित रहेगा तो ही पूरी प्रजा और राष्ट्र सुरक्षित रहेंगे।
            वाल्मीकि जी यहाँ बता रहे हैं कि एक आदर्श मंत्री वह है जिसका बाहरी आचरण आकर्षक हो और जिसकी भीतरी दृष्टि बाज की तरह पैनी हो।
            यह श्लोक दशरथ के मंत्रियों की उस 'प्रोफेशनल और एथिकल' (Professional and Ethical) उत्कृष्टता का वर्णन करता है जो किसी भी राज्य के लिए रक्षा-कवच का काम करती है।
            इन्हीं जाग्रत और नीति-निपुण मंत्रियों के कारण अयोध्या की ओर आँख उठाकर देखने का साहस उस काल के किसी भी शत्रु में नहीं था।
        """.trimIndent(),
        englishCommentary = """
            All those ministers wore highly elegant, excellent garments (Suvasasah) and maintained a highly dignified, royal appearance (Suveshashcha); furthermore, they all possessed exceptionally noble character (Sushilinah).
            They remained perpetually awake and hyper-vigilant for the ultimate welfare and benefit of the King (Narendra), constantly watching over the state through the sharp 'Eye of Policy' (Nayachakshusha).
            Wearing excellent garments and maintaining decorum indicates they strictly adhered to royal protocol and the immense dignity of their high offices; their external attire perfectly mirrored their internal brilliance.
            Being 'Sushilinah' proves that despite wielding unimaginable power and wealth, they harbored absolutely no arrogance or rudeness; they interacted with everyone with supreme humility and grace.
            'Jagrato nayachakshusha' is an incredibly powerful political maxim in the Ramayana—it implies that a true statesman never truly sleeps; his eyes of diplomacy and strategic policy remain wide open 24/7.
            They did not merely stand physical guard; they utilized their profound foresight and towering intellect to detect, intercept, and neutralize any invisible threat long before it could manifest.
            The 'Hitartham' (welfare) of the King was the singular, ultimate mission of their lives; they fundamentally understood that the safety of the Monarch guaranteed the absolute security of the entire nation.
            Valmiki illustrates here that an ideal minister is one whose outward conduct is charismatic and highly refined, while his internal strategic vision remains as razor-sharp and piercing as an eagle’s.
            This verse vividly describes the sheer 'Professional and Ethical' excellence of Dasharatha's cabinet, functioning as an impenetrable, invisible armor for the entire kingdom.
            It was exclusively due to these continuously vigilant and politically astute ministers that no enemy of that era ever possessed the sheer audacity to even cast an evil eye toward Ayodhya.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 16,
        sanskrit = "गुरौ गुणगृहीताश्च प्रख्याताश्च पराक्रमे ।\nविदेशेष्वपि विख्याताः सर्वतो बुद्धिनिश्चयात् ॥ १६ ॥",
        hindiCommentary = """
            वे मंत्री अपने गुरुजनों द्वारा अपने श्रेष्ठ गुणों के कारण अत्यंत आदरणीय और स्वीकार्य (गुणगृहीताः) थे, तथा युद्ध-भूमि में अपने अदम्य पराक्रम के लिए विश्व-विख्यात थे।
            उनकी बुद्धि की कुशाग्रता और सही निर्णय लेने की क्षमता (बुद्धिनिश्चयात्) के कारण उनकी ख्याति केवल अयोध्या में ही नहीं, बल्कि विदेशी राज्यों (विदेशेष्वपि) में भी सर्वत्र फैली हुई थी।
            'गुरौ गुणगृहीताः' का अर्थ है कि उन्होंने अपनी विद्या और संस्कार अत्यंत अनुशासन में रहकर अपने गुरुओं से प्राप्त किए थे, और गुरु भी उन पर गर्व करते थे।
            पराक्रम में प्रख्यात होना यह सिद्ध करता है कि वे केवल कागजी योजनाएं बनाने वाले मंत्री नहीं थे, बल्कि आवश्यकता पड़ने पर सेना का नेतृत्व कर शत्रुओं का नाश करने में भी पूर्णतः सक्षम थे।
            विदेशों में विख्यात होना उस काल की कूटनीति (Diplomacy) की सबसे बड़ी सफलता है; विदेशी राजा उनके नाम मात्र से ही अयोध्या की शक्ति का अनुमान लगा लेते थे।
            बुद्धि का 'निश्चय' (Decisiveness) एक प्रशासक का सबसे महत्वपूर्ण गुण है; वे कभी भ्रम या दुविधा में नहीं रहते थे, बल्कि धर्म-सम्मत और त्वरित निर्णय लेते थे।
            वाल्मीकि जी ने यहाँ एक मंत्री के 'सॉफ्ट पावर' (बुद्धि और गुण) और 'हार्ड पावर' (पराक्रम) का सबसे आदर्श और दुर्लभ मिश्रण प्रस्तुत किया है।
            जब पड़ोसी राज्यों को पता होता है कि सामने वाले देश का नेतृत्व इतना बौद्धिक और शक्तिशाली है, तो युद्ध की संभावना अपने आप समाप्त हो जाती है।
            यह श्लोक दशरथ के मंत्रियों को 'अंतर्राष्ट्रीय स्तर' (International Level) के राजनेताओं के रूप में स्थापित करता है।
            उनकी यह वैश्विक छवि ही अयोध्या को उस युग के पूरे आर्यावर्त की अघोषित राजधानी (Capital) बनाए रखने का सबसे बड़ा कारण थी।
        """.trimIndent(),
        englishCommentary = """
            Those ministers were deeply respected and wholly embraced by their Gurus due to their outstanding virtues (Gunagrihitah), and were world-renowned for their indomitable valor in battle (Parakrame).
            Because of the razor-sharp brilliance of their intellect and their flawless, resolute decision-making capabilities (Buddhinishchayat), their massive fame had spread everywhere, even into foreign kingdoms (Videsheshvapi).
            'Gurau Gunagrihitah' implies that they acquired their profound wisdom and culture through strict discipline under their masters, and their Gurus themselves took immense, boundless pride in them.
            Being renowned in valor proves they were not mere paper-pushing bureaucrats; when a crisis struck, they were fully capable of leading the vanguard and obliterating enemies on the battlefield.
            Being famous in foreign lands represents the absolute pinnacle of ancient Diplomacy; rival foreign kings could accurately gauge Ayodhya’s terrifying might simply by hearing the names of these ministers.
            'Decisiveness' (Buddhinishchayat) is the most critical trait of an administrator; they never wallowed in confusion or dilemma, but always made rapid, highly accurate, and Dharma-compliant decisions.
            Valmiki presents the most ideal and exceptionally rare synthesis of a minister's 'Soft Power' (intellect and virtue) and 'Hard Power' (military valor) in this glorious verse.
            When neighboring nations are acutely aware that a state's leadership is so intellectually formidable and physically devastating, the very possibility of unprovoked war is automatically eliminated.
            This verse firmly establishes King Dasharatha’s ministers not just as local officials, but as towering, 'International Level' statesmen of the highest pedigree.
            This flawless global image and reputation were the primary reasons why Ayodhya remained the undisputed, de facto capital of the entire Aryavarta during that golden era.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 17,
        sanskrit = "सन्धिविग्रहतत्वज्ञाः प्रकृत्या सम्पदान्विताः ।\nमन्त्रसंवरणे युक्ताः श्लक्ष्णाः सूक्ष्मासु बुद्धिषु ॥ १७ ॥",
        hindiCommentary = """
            वे मंत्री 'संधि' (मित्रता) और 'विग्रह' (युद्ध) की नीतियों के वास्तविक मर्म (तत्व) को गहराई से जानने वाले थे, और वे जन्मजात स्वभाव से ही श्रेष्ठ गुणों (सम्पत्ति) से युक्त थे।
            वे राज्य के गुप्त रहस्यों (मन्त्र) को छिपाकर रखने (संवरणे) में अत्यंत निपुण थे, उनका व्यवहार बहुत ही कोमल (श्लक्ष्णाः) था, और उनकी बुद्धि अत्यंत सूक्ष्म और पैनी थी।
            संधि और विग्रह विदेशी कूटनीति (Foreign Policy) के दो सबसे प्रमुख स्तंभ हैं; उन्हें यह भली-भांति ज्ञात था कि किस राजा के साथ कब शांति वार्ता करनी है और कब उस पर प्रहार करना है।
            'प्रकृत्या सम्पदान्विताः' का अर्थ है कि उनकी नैतिकता और ईमानदारी किसी दबाव का परिणाम नहीं थी, बल्कि वह उनके खून और स्वभाव में स्वाभाविक रूप से रची-बसी थी।
            'मन्त्रसंवरणे युक्ताः' सिद्ध करता है कि अयोध्या का 'डेटा और इन्फॉर्मेशन सिक्योरिटी' (Information Security) अभेद्य था; राज्य की योजनाएं शत्रुओं को तब तक पता नहीं चलती थीं जब तक वे लागू न हो जाएं।
            वे बाहर से 'श्लक्ष्ण' (मुलायम और मधुर) थे, जिससे प्रजा और मित्र उनसे प्रेम करते थे, परंतु भीतर से उनकी बुद्धि इतनी 'सूक्ष्म' थी कि वे किसी भी षड्यंत्र को जड़ से उखाड़ सकते थे।
            वाल्मीकि जी ने इस श्लोक में राजनीति की उस कला को दर्शाया है जहाँ एक नेता को बाहर से विनम्र और भीतर से लोहे के समान कठोर व बुद्धिमान होना चाहिए।
            सूक्ष्म बुद्धि का अर्थ है कि वे किसी भी घटना के दूरगामी परिणामों (Long-term consequences) का विश्लेषण पल भर में कर लेते थे।
            यह श्लोक एक आदर्श कूटनीतिज्ञ (Diplomat) और प्रशासक के लिए आवश्यक मनोवैज्ञानिक और बौद्धिक लक्षणों का संपूर्ण पैकेज (Package) है।
            इन्हीं विशेषताओं के कारण राजा दशरथ का साम्राज्य बिना किसी बड़ी बाधा या आंतरिक संकट के लगातार प्रगति के मार्ग पर अग्रसर था।
        """.trimIndent(),
        englishCommentary = """
            Those ministers were profound knowers of the true essence (Tattva) of 'Sandhi' (peace treaties) and 'Vigraha' (war), and were naturally, inherently endowed with a wealth of superior virtues (Sampadanvitah).
            They were absolute masters at concealing and safeguarding top-secret state counsels (Mantrasamvarane), possessed a highly gentle and refined demeanor (Shlakshnah), and wielded an incredibly sharp, subtle intellect.
            Peace and War are the two most fundamental pillars of Foreign Policy; these ministers possessed flawless judgment regarding exactly when to extend a hand of friendship and when to strike an enemy down.
            'Prakritya Sampadanvitah' implies that their high morality and pristine integrity were not enforced by external pressure; these noble traits were seamlessly integrated into their very blood and natural disposition.
            'Mantrasamvarane yuktah' proves that Ayodhya’s 'Information and Data Security' was totally impenetrable; the state's strategic plans remained entirely invisible to enemies until the exact moment of execution.
            Externally, they were 'Shlakshna' (soft, polite, and gentle), earning the deep love of allies and citizens, but internally, their intellect was so 'subtle' and piercing that they could instantly dismantle any hidden conspiracy.
            Valmiki brilliantly illustrates the highest art of politics here, demonstrating that a true leader must be extremely humble and approachable on the outside, yet as hard as steel and incredibly shrewd on the inside.
            Having a subtle intellect means they possessed the extraordinary ability to instantly analyze and accurately predict the long-term consequences of any minor event or policy decision.
            This verse serves as the complete, ultimate psychological and intellectual package outlining the exact traits required to forge an ideal, world-class Diplomat and public Administrator.
            It was entirely due to these phenomenal characteristics that King Dasharatha’s vast empire continued to surge forward on the path of relentless progress without encountering any major internal crises.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 18,
        sanskrit = "नीतिशास्त्रविशेषज्ञाः सततं प्रियवादिनः ।\nईदृशैस्तैरमात्यैश्च राजा दशरथोऽनघः ॥ १८ ॥",
        hindiCommentary = """
            वे सभी मंत्री राजनीति और नीतिशास्त्र के विशिष्ट और प्रकांड ज्ञाता थे, तथा वे सदैव मीठी, संयमित और प्रिय वाणी (प्रियवादिनः) बोलने वाले थे।
            इस प्रकार के उपर्युक्त सभी महान और दुर्लभ गुणों से युक्त उन अमात्यों (मंत्रियों) के साथ मिलकर, वे पाप-रहित (अनघः) राजा दशरथ शासन करते थे।
            'नीतिशास्त्रविशेषज्ञाः' का अर्थ है कि वे राज्य संचालन के केवल सामान्य नियमों को नहीं, बल्कि चाणक्य या बृहस्पति जैसी सूक्ष्म नीतियों के विशेषज्ञ थे।
            'सततं प्रियवादिनः' यह प्रमाणित करता है कि अपार सत्ता और ज्ञान होने के बावजूद उनका अहंकार कभी उनकी जीभ पर नहीं आता था; उनकी भाषा हमेशा संस्कारी होती थी।
            मीठी वाणी एक ऐसा अस्त्र है जो बिना रक्त बहाए ही शत्रुओं के हृदय को जीत लेता है और प्रजा के मन में राजा के प्रति प्रेम बढ़ाता है।
            वाल्मीकि जी ने राजा दशरथ के लिए 'अनघः' (पापरहित) शब्द का प्रयोग किया है, जिसका अर्थ है कि उनका जीवन और शासन पूरी तरह से निष्कलंक और पारदर्शी था।
            जब राजा स्वयं निष्पाप हो और उसके मंत्री इतने अधिक योग्य और धर्मपरायण हों, तो उस राज्य को 'राम-राज्य' की पूर्वपीठिका बनने से कोई नहीं रोक सकता।
            यह श्लोक उस पूरी मंत्री-परिषद के चरित्र-चित्रण का एक सुंदर और सारगर्भित निष्कर्ष (Conclusion) प्रस्तुत करता है।
            राजा और मंत्रियों का यह पवित्र गठबंधन (Alliance) ही अयोध्या के उस स्वर्णिम युग का असली आधार था जिसका गान देवता भी करते थे।
            वाल्मीकि जी ने यह सिद्ध कर दिया है कि किसी भी राष्ट्र का गौरव उसकी भौगोलिक सीमाओं से नहीं, बल्कि उसे चलाने वाले नेताओं के चरित्र से मापा जाता है।
        """.trimIndent(),
        englishCommentary = """
            All those ministers were highly specialized, profound experts in political science and ethics (Nitishastra), and they consistently, without fail, spoke in a sweet, measured, and highly pleasing manner (Priyavadinah).
            Accompanied and supported by such Amatyas (ministers) who were fully endowed with all these magnificent and exceptionally rare virtues, the completely sinless (Anaghah) King Dasharatha governed the realm.
            'Nitishastra-visheshajnah' means they did not merely possess a superficial understanding of governance; they were elite specialists in subtle statecraft, rivaling the intellect of divine preceptors like Brihaspati.
            'Satatam Priyavadinah' proves that despite wielding unimaginable authority and vast knowledge, their egos never corrupted their tongues; their language remained perpetually cultured, polite, and refined.
            Sweet, diplomatic speech is an incredibly potent weapon that can effortlessly conquer the hearts of enemies without shedding a single drop of blood, while simultaneously multiplying the citizens' love for their King.
            Valmiki uses the powerful epithet 'Anaghah' (sinless) for King Dasharatha, signifying that His entire personal life, as well as His royal administration, was absolutely unblemished, pure, and flawlessly transparent.
            When a monarch is himself entirely free of sin, and is backed by ministers of such towering capability and righteousness, nothing in the universe can stop that kingdom from becoming the very precursor to 'Ram-Rajya.'
            This verse elegantly presents a beautiful, profound, and highly meaningful conclusion to the extensive and detailed character-sketch of Dasharatha's legendary council of ministers.
            This immaculate, sacred alliance between the sinless Monarch and His virtuous ministers formed the true, unshakeable bedrock of Ayodhya’s golden era—an era highly glorified even by the celestial gods.
            Valmiki has conclusively proven here that the true glory of a nation is never measured merely by the vastness of its geographical borders, but by the pristine character of the leaders who govern it.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 19,
        sanskrit = "उपपन्नो गुणोपेतैरन्वशासद्वसुन्धराम् ।\nअवेक्षमाणश्चारेण प्रजा धर्मेण रञ्जयन् ॥ १९ ॥",
        hindiCommentary = """
            उन समस्त महान और दिव्य गुणों से युक्त मंत्रियों के साथ मिलकर, राजा दशरथ ने इस संपूर्ण पृथ्वी (वसुन्धराम्) पर अपना कुशल शासन (अन्वशासद्) स्थापित किया।
            वे अपने गुप्तचरों (चारेण) के माध्यम से राज्य की हर छोटी-बड़ी गतिविधि की सूक्ष्म निगरानी (अवेक्षमाणः) करते थे, और पूर्ण रूप से धर्म का पालन करते हुए अपनी प्रजा को निरंतर प्रसन्न (रञ्जयन्) रखते थे।
            वाल्मीकि जी यह स्पष्ट कर रहे हैं कि एक सफल शासन केवल दरबार में बैठकर नहीं चलता; राजा को गुप्तचरों के माध्यम से 'ग्राउंड रियलिटी' (Ground Reality) से जुड़ा रहना पड़ता है।
            'चारेण अवेक्षमाणः' (गुप्तचरों से देखना) यह सिद्ध करता है कि दशरथ की शासन व्यवस्था में 'फीडबैक मैकेनिज्म' (Feedback Mechanism) अत्यंत मजबूत और पारदर्शी था।
            राजा कभी भी केवल चाटुकार मंत्रियों की बातों पर निर्भर नहीं रहता था; वह गुप्तचरों द्वारा जनता के असली सुख-दुख और समस्याओं की जानकारी स्वयं प्राप्त करता था।
            'प्रजा धर्मेण रञ्जयन्' भारतीय राजशास्त्र का सबसे बड़ा सिद्धांत है—राजा का प्राथमिक और सर्वोच्च कर्तव्य प्रजा का मनोरंजन या तुष्टिकरण नहीं, बल्कि 'धर्म' के मार्ग पर चलकर उन्हें प्रसन्न और सुरक्षित रखना है।
            रञ्जन (प्रसन्न रखना) तभी स्थायी होता है जब वह न्याय और नीति पर आधारित हो; दशरथ ने अपने न्याय से हर नागरिक का हृदय जीत लिया था।
            इन मंत्रियों का सहयोग और गुप्तचरों की आँखें—इन दोनों उपकरणों ने दशरथ को एक ऐसा चक्रवर्ती सम्राट बना दिया था जिसका कोई सानी नहीं था।
            यह श्लोक 'सुशासन' (Good Governance) और 'खुफिया तंत्र' (Intelligence Gathering) के बीच के उस अनिवार्य और वैज्ञानिक संबंध को बहुत ही सटीकता से परिभाषित करता है।
            ऐसी धर्मनिष्ठ और पारदर्शी व्यवस्था के कारण ही अयोध्या का हर नागरिक स्वयं को राजा दशरथ के परिवार का एक अभिन्न अंग मानता था।
        """.trimIndent(),
        englishCommentary = """
            Accompanied and fully supported by ministers endowed with all those magnificent and divine virtues, King Dasharatha efficiently governed and ruled over the entire earth (Vasundharam).
            He maintained an incredibly meticulous and constant surveillance (Avekshamanah) over every state activity through His vast network of spies (Charena), and kept His subjects perpetually delighted (Ranjayan) by strictly upholding Dharma.
            Valmiki explicitly clarifies here that successful governance cannot be conducted merely by sitting inside a royal court; a monarch must remain intimately connected to the 'Ground Reality' via an active intelligence network.
            'Charena Avekshamanah' (observing through spies) proves that the 'Feedback Mechanism' within Dasharatha’s administrative system was exceptionally robust, highly advanced, and entirely transparent.
            The King never relied solely on the potentially filtered reports of flattering courtiers; He independently verified the true joys, sorrows, and real problems of the public through His undercover agents.
            'Praja dharmena ranjayan' is the supreme, golden principle of Indian political science—the primary and highest duty of a King is not cheap appeasement, but keeping the public genuinely happy and secure by walking the path of 'Dharma.'
            'Ranjana' (pleasing the subjects) only becomes permanent when it is firmly rooted in absolute justice and sound policy; Dasharatha had effortlessly conquered every citizen's heart through His flawless justice.
            The brilliant cooperation of His elite ministers combined with the piercing eyes of His spy network—these two potent instruments transformed Dasharatha into an unparalleled, universal Emperor (Chakravarti).
            This verse highly accurately defines the mandatory, scientific, and deeply symbiotic relationship that must exist between transparent 'Good Governance' and active 'Intelligence Gathering' in any successful state.
            It was exclusively due to this profoundly righteous and transparent system that every single citizen of Ayodhya felt completely secure, considering themselves an integral and cherished part of King Dasharatha’s own family.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 20,
        sanskrit = "प्रजानां पालनं कुर्वन्नधर्मं परिवर्जयन् ।\nविश्रुतस्त्रिषु लोकेषु वदान्यः सत्यसङ्गरः ॥ २० ॥",
        hindiCommentary = """
            अपनी समस्त प्रजा का एक पिता के समान पूर्ण पालन-पोषण करते हुए और अपने जीवन व राज्य से हर प्रकार के अधर्म का पूरी तरह परित्याग (परिवर्जयन्) करते हुए राजा दशरथ शासन करते थे।
            वे अत्यंत दानशील (वदान्यः) थे और युद्ध तथा शांति—दोनों ही स्थितियों में अपनी प्रतिज्ञा पर अटल (सत्यसङ्गरः) रहने के कारण तीनों लोकों (स्वर्ग, पृथ्वी, पाताल) में विख्यात (विश्रुतः) थे।
            'प्रजानां पालनं' का अर्थ केवल भौतिक सुरक्षा देना नहीं था, बल्कि प्रजा की नैतिक, आर्थिक और आध्यात्मिक उन्नति सुनिश्चित करना राजा का मुख्य धर्म था।
            अधर्म का परित्याग यह सिद्ध करता है कि दशरथ के राज्य में कोई भी ऐसा कानून या नियम नहीं था जो प्रकृति या वेदों के विरुद्ध हो; उनका आचरण पूरी तरह से निष्कलंक था।
            'वदान्यः' (अत्यंत दानी) होना राजा के उस विशाल हृदय को दर्शाता है जहाँ खजाना केवल तिजोरी में बंद रखने के लिए नहीं, बल्कि यज्ञों और गरीबों के कल्याण के लिए मुक्त हस्त से खर्च किया जाता था।
            'सत्यसङ्गरः' प्राचीन क्षत्रियों का वह सर्वोच्च आभूषण है जिसका अर्थ है—चाहे प्राण चले जाएँ, पर एक बार की गई प्रतिज्ञा कभी न टूटे (रघुकुल रीति सदा चलि आई, प्राण जाई पर बचन न जाई)।
            यही वह सत्यनिष्ठा थी जिसके कारण बाद में दशरथ ने कैकेयी को दिए गए अपने वचनों को निभाने के लिए अपने प्रिय पुत्र राम को वनवास भेज दिया और स्वयं अपने प्राण त्याग दिए।
            तीनों लोकों में विख्यात होने का तात्पर्य है कि दशरथ का प्रताप केवल मनुष्यों तक सीमित नहीं था; स्वयं देवता भी असुरों से युद्ध करने के लिए उनकी सहायता मांगते थे।
            वाल्मीकि जी ने इस श्लोक में दशरथ के पूरे जीवन-दर्शन (Life Philosophy) का निचोड़ अत्यंत प्रभावपूर्ण शब्दों में प्रस्तुत कर दिया है।
            यह श्लोक एक ऐसे 'आदर्श सम्राट' का चित्र है जो शक्ति, करुणा, दान और सत्य का साक्षात् और सर्वोच्च अवतार बन चुका था।
        """.trimIndent(),
        englishCommentary = """
            King Dasharatha ruled while nurturing and protecting His subjects exactly like a loving father, completely and absolutely abandoning (Parivarjayan) every single trace of unrighteousness (Adharma) from His life and empire.
            He was extraordinarily generous and charitable (Vadanyah), and because He remained totally unwavering and true to His vows (Satyasangarah) in both war and peace, His fame resounded gloriously across all three worlds (Vishrutah).
            'Prajanam palanam' did not merely mean providing basic physical security; the King’s primary Dharma was to actively ensure the moral, economic, and high spiritual evolution of the entire populace.
            The total abandonment of Adharma proves that not a single law or decree in Dasharatha’s kingdom violated the laws of nature or the Vedas; His personal and political conduct was flawlessly unblemished.
            Being 'Vadanyah' (highly charitable) reflects the Monarch's expansive heart, where the royal treasury was not hoarded greedily, but spent with an open hand on grand sacrifices and massive public welfare.
            'Satyasangarah' is the supreme ornament of ancient Kshatriyas, meaning—even at the cost of one's own life, a vow once made must never be broken (the ultimate principle of the Solar Dynasty).
            It was this exact, unyielding commitment to Truth that later compelled Dasharatha to honor His promises to Kaikeyi, sending His most beloved son Rama into exile and ultimately sacrificing His own life in grief.
            Being famous across the three worlds implies that Dasharatha's might was not confined to mortals; even the celestial gods routinely sought His formidable military assistance to battle powerful demons.
            In this deeply moving verse, Valmiki has brilliantly distilled the entire core essence and 'Life Philosophy' of King Dasharatha using incredibly impactful and resonant words.
            This verse paints the ultimate, definitive portrait of an 'Ideal Emperor' who had become the absolute, living incarnation of sheer power, profound compassion, boundless charity, and eternal Truth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 21,
        sanskrit = "स तत्र पुरुषव्याघ्रः शशास पृथिवीमिमाम् ।\nनाध्यगच्छद्विशिष्टं वा तुल्यं वा शत्रुमात्मनः ॥ २१ ॥",
        hindiCommentary = """
            पुरुषों में बाघ के समान अदम्य पराक्रमी (पुरुषव्याघ्रः) राजा दशरथ उस अयोध्या नगरी में निवास करते हुए इस संपूर्ण पृथ्वी पर अत्यंत सफलता और नीति के साथ शासन करते थे।
            उनके पूरे शासनकाल में, उन्हें कभी भी कोई ऐसा शत्रु प्राप्त नहीं हुआ (नाध्यगच्छद्) जो बल, बुद्धि या ऐश्वर्य में उनसे श्रेष्ठ (विशिष्टं) हो, या उनके समान (तुल्यं) भी हो।
            'पुरुषव्याघ्रः' विशेषण दशरथ के उस निर्भय, तेज और आक्रामक योद्धा स्वरूप को दर्शाता है जिसके सामने खड़े होने की हिम्मत किसी भी विरोधी में नहीं थी।
            एक राजा की सबसे बड़ी उपलब्धि यह होती है कि उसके राज्य को चुनौती देने वाला कोई न बचे; दशरथ ने अपने पराक्रम से पूरे विश्व को 'शत्रु-विहीन' कर दिया था।
            कोई भी शत्रु उनसे 'विशिष्ट' (Superior) नहीं था, इसका अर्थ है कि सामरिक शक्ति और कूटनीति में अयोध्या पूरे विश्व में नंबर एक (Number One) पर थी।
            कोई शत्रु 'तुल्य' (Equal) भी नहीं था, इसका मतलब है कि उनके आस-पास प्रतिस्पर्धा (Competition) करने वाला कोई भी राजा दूर-दूर तक मौजूद नहीं था; उनका वर्चस्व पूर्णतः एकतरफा था।
            दशरथ का यह अजेय स्वरूप केवल उनकी विशाल सेना के कारण नहीं था, बल्कि यह उनके 'धर्म' और उन श्रेष्ठ मंत्रियों की नीतियों का साक्षात् परिणाम था जिनका वर्णन पूर्व के श्लोकों में किया गया है।
            वाल्मीकि जी यह स्पष्ट कर रहे हैं कि राम को जो साम्राज्य विरासत में मिला, वह कोई कमजोर या संघर्षरत राज्य नहीं था, बल्कि वह पृथ्वी का सबसे शक्तिशाली और शांत 'सुपरपावर' (Superpower) था।
            शत्रुओं का अभाव राजा को विलासी बना सकता है, परंतु दशरथ के मामले में इस शांति ने उन्हें और अधिक यज्ञ, तप और लोक-कल्याण के कार्यों की ओर प्रेरित किया।
            यह श्लोक इक्ष्वाकु वंश के उस गौरवशाली चरम (Climax) का वर्णन है जहाँ शक्ति और शांति का एक अत्यंत दुर्लभ और स्वर्णिम मिलन हो चुका था।
        """.trimIndent(),
        englishCommentary = """
            Residing in that grand city of Ayodhya, King Dasharatha, who was like a fiercely indomitable tiger among men (Purushavyaghrah), successfully and righteously governed this entire earth.
            Throughout His entire glorious reign, He never encountered (Nadhyagacchad) a single enemy who was either superior (Vishishtam) to Him, or even remotely equal (Tulyam) to Him in power, intellect, or opulence.
            The epithet 'Purushavyaghrah' brilliantly captures Dasharatha’s fearless, radiant, and highly aggressive warrior persona, before whom absolutely no opponent possessed the sheer courage to stand.
            The greatest, most historic achievement of any monarch is to render his realm completely unchallenged; Dasharatha, through His sheer valor, had successfully rendered the entire globe entirely 'enemy-free.'
            No enemy being 'Vishishtam' (superior) implies that in terms of strategic military might and sharp diplomacy, Ayodhya stood absolutely uncontested as the Number One power in the world.
            No enemy being even 'Tulyam' (equal) means there was no competing king anywhere in the vicinity; Dasharatha’s absolute supremacy and global hegemony were entirely one-sided and completely undisputed.
            This invincible, towering status of Dasharatha was not merely due to a massive army, but was the direct, tangible result of His 'Dharma' and the flawless policies of those elite ministers described in previous verses.
            Valmiki explicitly clarifies that the empire Lord Rama eventually inherited was not a weak or struggling kingdom, but the most powerful, peaceful, and utterly dominant 'Superpower' on the face of the earth.
            The complete absence of enemies can often render a king lazy or luxurious, but in Dasharatha's case, this profound peace motivated Him further toward performing grand sacrifices, severe penance, and massive public welfare.
            This verse profoundly describes the glorious Climax of the Ikshvaku dynasty, marking an exceptionally rare, golden, and historic confluence of absolute power and unbroken peace.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 22,
        sanskrit = "मित्रवान्नतसामन्तः प्रतापहतकण्टकः ।\nस शशास जगद्राजा दिवं देवपतिर्यथा ॥ २२ ॥",
        hindiCommentary = """
            राजा दशरथ के विश्व भर में अनगिनत मित्र (मित्रवान्) थे, उनके अधीन सभी सामंत (सहायक राजा) उनके चरणों में नतमस्तक (नतसामन्तः) रहते थे, और उन्होंने अपने प्रचंड प्रताप से राज्य के सभी 'कांटों' (शत्रुओं और बाधाओं) को पूरी तरह नष्ट (प्रतापहतकण्टकः) कर दिया था।
            वे महान राजा इस संपूर्ण जगत पर ठीक उसी प्रकार निर्विघ्न और ऐश्वर्यपूर्ण शासन करते थे, जिस प्रकार देवताओं के स्वामी (देवपतिः) इन्द्र स्वर्ग (दिवं) पर शासन करते हैं।
            'मित्रवान्' होना यह दर्शाता है कि दशरथ केवल डराकर राज नहीं करते थे; उनकी कूटनीति (Diplomacy) इतनी श्रेष्ठ थी कि विश्व के अधिकांश राजा स्वेच्छा से उनके सहयोगी और मित्र बन गए थे।
            'नतसामन्तः' का अर्थ है कि जो राजा उनके अधीन थे, वे कभी विद्रोह का विचार नहीं करते थे, बल्कि दशरथ के न्याय और शक्ति के प्रति पूर्ण श्रद्धा और समर्पण रखते थे।
            'प्रतापहतकण्टकः' राजनीति का एक अत्यंत महत्वपूर्ण सूत्र है; इसका अर्थ है कि राजा ने राज्य के भीतर के चोर, लुटेरे, भ्रष्ट अधिकारी और बाहरी शत्रुओं रूपी सभी 'कांटों' को अपने तेज से जलाकर भस्म कर दिया था।
            वाल्मीकि जी ने यहाँ राजा दशरथ की तुलना साक्षात् 'इन्द्र' से की है, जो प्राचीन काल में शक्ति, ऐश्वर्य और संपूर्ण नियंत्रण का सबसे बड़ा और अंतिम मानक माना जाता था।
            जिस प्रकार स्वर्ग में देवताओं को कोई पीड़ा नहीं होती और व्यवस्था ईश्वरीय होती है, वैसी ही निर्दोष और सुखद व्यवस्था अयोध्या की धरती पर स्थापित हो चुकी थी।
            एक राजा के लिए इससे बड़ी सफलता क्या हो सकती है कि उसका राज्य पृथ्वी पर होते हुए भी साक्षात् स्वर्ग का अनुभव दे।
            यह श्लोक राजा दशरथ की 'विदेशी नीति' (Foreign Policy), 'आंतरिक सुरक्षा' (Internal Security) और उनके 'सम्राट' (Emperor) स्वरूप का सबसे भव्य, पूर्ण और अंतिम निष्कर्ष प्रस्तुत करता है।
            यहीं से अयोध्या के वैभव और दशरथ के सुशासन का वह गौरवशाली अध्याय समाप्त होता है, और कथा अब उनके जीवन के उस सबसे बड़े अभाव (पुत्रहीनता) की ओर मुड़ने के लिए तैयार होती है।
        """.trimIndent(),
        englishCommentary = """
            King Dasharatha possessed countless loyal friends and allies globally (Mitravan), all His vassal kings bowed down submissively at His feet (Natasamantah), and through His blazing valor, He had completely eradicated all the 'thorns' (enemies and obstacles) from His empire (Pratapahatakantakah).
            That magnificent Monarch governed this entire world as flawlessly, seamlessly, and opulently as Indra, the Lord of the Gods (Devapatih), rules over the celestial heavens (Divam).
            Being 'Mitravan' (having many friends) illustrates that Dasharatha did not rule solely through fear; His elite Diplomacy was so superior that most global kings voluntarily and happily became His trusted allies.
            'Natasamantah' implies that the subordinate kings never even entertained a single thought of rebellion; instead, they maintained absolute reverence, loyalty, and deep surrender toward Dasharatha's justice and power.
            'Pratapahatakantakah' is a highly critical political maxim; it means the King had utilized His radiant aura to incinerate and destroy all internal 'thorns'—such as thieves, corrupt officials, and external foes.
            Valmiki directly compares King Dasharatha to 'Indra' here, which in ancient times was considered the absolute, ultimate, and highest standard for absolute power, immense opulence, and total, unshakeable control.
            Just as the deities in heaven experience absolutely no suffering and the administration is flawlessly divine, an identical, pristine, and blissful system had been firmly established on the very soil of Ayodhya.
            What greater success can a monarch possibly achieve than transforming his earthly kingdom into a realm that provides the exact, lived experience of literal heaven?
            This verse presents the most grandiose, complete, and final conclusion regarding Dasharatha’s 'Foreign Policy,' 'Internal Security,' and His towering status as a Universal Emperor.
            With this, the glorious chapter detailing Ayodhya’s opulence and Dasharatha’s perfect governance concludes, setting the stage for the narrative to turn toward the single, profound void in His life (His lack of an heir).
        """.trimIndent()
    ),
    RamayanVerse(
        id = 23,
        sanskrit = "तैर्मन्त्रिभिर्मन्त्रहिते नियुक्तै-\nर्वृतोऽनुरक्तैः कुशलैः समर्थैः ।",
        hindiCommentary = """
            (यह श्लोक एक 'त्रिष्टुभ्' छंद का पूर्वार्ध है, जो अगले श्लोक के साथ जुड़कर अर्थ पूर्ण करता है।)
            राजा दशरथ उन महान मंत्रियों से हमेशा घिरे (वृतः) रहते थे, जो राज्य के हित की गुप्त मंत्रणाओं (मन्त्रहिते) में अत्यंत निष्ठापूर्वक नियुक्त (नियुक्तैः) थे।
            वे सभी मंत्री राजा और प्रजा के प्रति पूर्ण रूप से समर्पित एवं अनुरागी (अनुरक्तैः) थे, राजकाज के सभी कार्यों में अत्यंत कुशल (कुशलैः) थे, और किसी भी संकट का सामना करने में पूरी तरह समर्थ (समर्थैः) थे।
            वाल्मीकि जी इस सर्ग का समापन करते हुए पुनः एक बार उन मंत्रियों के अभूतपूर्व योगदान को रेखांकित कर रहे हैं, क्योंकि एक सम्राट की महानता उसके सलाहकारों के बिना अधूरी होती है।
            'मन्त्रहिते नियुक्तैः' का अर्थ है कि उनका पूरा ध्यान केवल और केवल इस बात पर केंद्रित रहता था कि राज्य की नीतियों (मंत्रणा) से राष्ट्र का अधिकतम कल्याण कैसे हो।
            'अनुरक्त' होने का तात्पर्य यह है कि उनका राजा के प्रति समर्पण किसी स्वार्थ, वेतन या भय के कारण नहीं था; वह एक विशुद्ध, स्वाभाविक और आध्यात्मिक प्रेम था।
            'कुशल' और 'समर्थ' होना यह सिद्ध करता है कि वे केवल योजनाएं बनाने वाले बुद्धिजीवी नहीं थे, बल्कि उन योजनाओं को धरातल पर सफलतापूर्वक लागू करने की व्यावहारिक क्षमता (Execution capability) भी रखते थे।
            इस श्लोक का प्रवाह यह बताता है कि दशरथ का दरबार कोई साधारण राजनीतिक अखाड़ा नहीं था, बल्कि वह एक ऐसा पवित्र परिवार था जहाँ हर सदस्य एक ही लक्ष्य (राष्ट्र-निर्माण) के लिए श्वास ले रहा था।
            यह पूर्वार्ध (First half) राजा की उस 'टीम' की शक्ति को समेटता है जो अगले श्लोक में राजा के दिव्य और सूर्य के समान तेजस्वी स्वरूप को पूर्णता प्रदान करने वाली है।
        """.trimIndent(),
        englishCommentary = """
            (This verse is the first half of a 'Trishtubh' meter stanza, which combines with the next verse to complete its profound meaning.)
            King Dasharatha was constantly surrounded (Vritah) by those magnificent ministers who were dedicatedly appointed and deeply engaged in highly beneficial and secret state counsels (Mantrahite niyuktaih).
            All those ministers were profoundly devoted and deeply affectionate (Anuraktaih) toward the King and subjects, exceptionally skilled in all statecraft (Kushalaih), and fully capable (Samarthaih) of neutralizing any crisis.
            Concluding this Sarga, Valmiki once again highlights the unprecedented and monumental contribution of these ministers, reiterating that an Emperor’s greatness is entirely incomplete without his brilliant advisors.
            'Mantrahite niyuktaih' implies that their entire, unwavering focus remained exclusively on how to extract the maximum possible welfare for the nation through impeccable state policies (Mantra).
            Being 'Anurakta' (devoted) signifies that their absolute surrender to the King was not driven by selfish motives, salary, or fear; it was a pure, natural, and highly spiritual bond of love.
            Being 'Kushala' and 'Samartha' proves they were not mere ivory-tower intellectuals drawing up theoretical plans; they possessed the hardcore, practical 'Execution Capability' to implement those plans on the ground successfully.
            The rhythmic flow of this verse indicates that Dasharatha’s court was not a mundane political arena, but a sacred family where every single member breathed for one unified goal: ultimate Nation-Building.
            This first half perfectly encapsulates the sheer power of the King’s 'Team,' setting up the final imagery in the next verse that will illuminate the King’s divine, sun-like radiance to absolute perfection.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 24,
        sanskrit = "स पार्थिवो दीप्तिमवाप युक्त-\nस्तेजोमयैर्गोभिरिवोदितोऽर्कः ॥ २४ ॥\nइति वाल्मीकिरामायणे बालकाण्डे षष्ठः सर्गः ॥",
        hindiCommentary = """
            (पूर्व श्लोक से जुड़ते हुए) उन कुशल और समर्थ मंत्रियों से युक्त होकर, वे पृथ्वीपति (पार्थिवो) राजा दशरथ उस राजसभा में ऐसी अद्भुत दीप्ति और शोभा (दीप्तिमवाप) को प्राप्त होते थे—
            जैसे उदित होता हुआ सूर्य (उदितोऽर्कः) अपनी अत्यंत तेजोमयी और प्रकाशवान किरणों (तेजोमयैर्गोभिरिव) से युक्त होकर संपूर्ण आकाश को आलोकित कर देता है।
            वाल्मीकि जी ने यहाँ एक अत्यंत भव्य और ब्रह्मांडीय उपमा (Cosmic Metaphor) का प्रयोग किया है; राजा दशरथ को 'सूर्य' और उनके मंत्रियों को उस सूर्य की 'रश्मियों' (किरणों) के समान बताया गया है।
            जिस प्रकार सूर्य की किरणें सूर्य के तेज को पूरे ब्रह्मांड में फैलाकर अंधकार का नाश करती हैं, उसी प्रकार ये मंत्री दशरथ के न्याय और प्रताप को पूरे विश्व में फैलाकर अधर्म का नाश करते थे।
            सूर्य की किरणें सूर्य से अलग नहीं होतीं, वे उसी का विस्तार होती हैं; इसी प्रकार ये मंत्री भी राजा की इच्छा और उनके धर्म के ही सजीव विस्तार थे, दोनों के बीच पूर्ण अद्वैत (Oneness) था।
            'उदितोऽर्कः' (उगता हुआ सूर्य) यह संकेत देता है कि दशरथ का साम्राज्य कभी पतन की ओर नहीं जा रहा था, बल्कि वह हमेशा प्रगति, विकास और नव-निर्माण की ओर ही अग्रसर रहता था।
            इस प्रकार, वाल्मीकि रामायण के बालकाण्ड का 'सचिव वर्णन' नामक यह अत्यंत ओजस्वी और ज्ञानवर्धक 'छठा सर्ग' यहाँ अपनी पूर्णता को प्राप्त होता है।
            इस सर्ग ने विश्व के समस्त शासकों के लिए एक ऐसा शाश्वत 'सुशासन का घोषणा-पत्र' (Manifesto of Good Governance) प्रस्तुत किया है जो युगों-युगों तक प्रासंगिक रहेगा।
            दशरथ का यह धर्ममय दरबार और उनका सूर्य के समान तेज ही वह पवित्र 'आसन' था जिस पर साक्षात् परब्रह्म श्री राम का अवतरण होने वाला था।
            ॥ छठा सर्ग सम्पूर्ण हुआ। जय श्री राम ॥
        """.trimIndent(),
        englishCommentary = """
            (Continuing from the previous verse) Accompanied and perfectly united with those highly skilled and capable ministers, that Lord of the Earth (Parthivo), King Dasharatha, attained such a breathtaking and miraculous brilliance (Diptimavapa)—
            Exactly like the newly rising Sun (Udito'rkah), which, when united with its intensely radiant, luminous, and energy-filled rays (Tejomayairgobhiriva), spectacularly illuminates the entire sky and eradicates all darkness.
            Valmiki has employed an incredibly majestic and 'Cosmic Metaphor' here; King Dasharatha is equated to the 'Sun,' while His elite ministers are compared to the brilliant 'Rays' of that very sun.
            Just as the sun's rays propagate the sun's fiery brilliance across the entire universe to annihilate darkness, these ministers broadcasted Dasharatha’s absolute justice and valor across the globe to annihilate all unrighteousness.
            The rays are never separate from the sun; they are its direct extension. Similarly, these ministers were the living, breathing extensions of the King’s will and His Dharma, functioning in a state of perfect Oneness (Advaita).
            'Udito'rkah' (the rising sun) signifies that Dasharatha’s empire was never in a state of decline; it was perpetually surging upward, constantly ascending toward new horizons of progress, development, and creation.
            Thus, this highly vigorous, enlightening, and majestic 'Sixth Sarga' of the Baal Kand in the Valmiki Ramayana, titled 'Description of the Ministers,' reaches its glorious and definitive completion here.
            This chapter has laid down an eternal and universal 'Manifesto of Good Governance' for all global rulers, establishing a flawless benchmark that will remain deeply relevant for countless eons to come.
            This highly righteous royal court and Dasharatha's sun-like brilliance constituted the very sacred 'Throne' upon which the Supreme Absolute, Lord Sri Rama, was destined to make His divine descent.
            || Thus ends the Sixth Sarga. Jai Shri Ram ||
        """.trimIndent()
    )
)