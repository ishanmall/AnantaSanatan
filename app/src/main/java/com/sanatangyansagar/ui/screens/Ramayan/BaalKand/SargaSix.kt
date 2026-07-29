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
fun SargaSixScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaSixData
        } else {
            sargaSixData.filter {
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
                        Text("षष्ठ सर्ग - सचिव वर्णन", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFE0B2)
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

val sargaSixData = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "तस्यां पुर्यामयोध्यायां राज्ञो दशरथस्य च ।\nअष्टौ बभूवुर्धर्मात्मानः सचिवाः सुयशस्विनः ॥ १ ॥",
        hindiCommentary = """
            अयोध्या नगरी में राजा दशरथ के आठ अत्यंत धर्मात्मा और यशस्वी सचिव (मंत्री) नियुक्त थे।
            ये मंत्री केवल शासन चलाने वाले अधिकारी नहीं थे, बल्कि वे धर्म के साक्षात् विग्रह थे।
            इन आठ मंत्रियों की परिषद राजा को नीति और न्याय के मार्ग पर स्थिर रखने का कार्य करती थी।
            यशस्वी होने का अर्थ है कि उनकी कीर्ति उनके न्यायपूर्ण निर्णयों के कारण पूरे आर्यावर्त में फैली थी।
            दशरथ का राज्य इन मंत्रियों की बुद्धिमत्ता और उनकी सत्यनिष्ठा के कारण ही 'अजेय' बना हुआ था।
            वाल्मीकि जी यहाँ दशरथ की उस टीम का परिचय दे रहे हैं जो अयोध्या की असली सामरिक शक्ति थी।
            जहाँ सलाहकार शुद्ध हृदय के हों, वहाँ राजा कभी भी अपने मार्ग से विचलित नहीं होता।
            प्राचीन भारतीय राजनीति में मंत्रिपरिषद का स्थान राजा के बराबर ही महत्वपूर्ण माना जाता था।
            इन मंत्रियों का चुनाव उनकी व्यक्तिगत ईमानदारी और राष्ट्र के प्रति समर्पण के आधार पर किया गया था।
            समाज के हर वर्ग का हित इन मंत्रियों की प्राथमिकताओं में सबसे ऊपर रहता था।
        """.trimIndent(),
        englishCommentary = """
            In the city of Ayodhya, King Dasharatha had eight ministers who were righteous and illustrious.
            These ministers were not just bureaucratic officials but were the embodiments of Dharma themselves.
            This council of eight served as the moral compass, guiding the King on the path of absolute justice.
            Their fame (Yashas) was not accidental; it was the result of their consistent and transparent policies.
            Dasharatha’s reign was solidified by the intellectual vigor and the integrity of these noble counselors.
            Sage Valmiki begins here to introduce the core administrative team that formed the backbone of Ayodhya.
            When advisors are pure-hearted, the Monarch remains anchored in truth despite any external pressures.
            In ancient Indian statecraft, the Council of Ministers held a status almost parallel to the King.
            These individuals were selected based on their personal integrity and their undying national loyalty.
            The welfare of every social strata remained the topmost priority in their strategic deliberations.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 2,
        sanskrit = "धृष्टिर्जयन्तो विजयः सुराष्ट्रो राष्ट्रवर्धनः ।\nअकोपो धर्मपालश्च सुमन्त्रश्चाष्टमोऽभवत् ॥ २ ॥",
        hindiCommentary = """
            उन आठ मंत्रियों के नाम थे—धृष्टि, जयन्त, विजय, सुराष्ट्र, राष्ट्रवर्धन, अकोप, धर्मपाल और आठवें सुमन्त्र।
            इन नामों के अर्थ ही उनके महान चरित्र और उनके विशिष्ट कार्यों की ओर संकेत करते हैं।
            'धृष्टि' साहस का, 'जयन्त' और 'विजय' निरंतर सफलता और विजय के प्रतीक बनकर कार्य करते थे।
            'सुराष्ट्र' और 'राष्ट्रवर्धन' का मुख्य दायित्व देश की सीमाओं की रक्षा और उसकी समृद्धि बढ़ाना था।
            'अकोप' वे थे जिन्होंने अपने क्रोध को जीत लिया था और जो अत्यंत शांतिपूर्ण ढंग से न्याय करते थे।
            'धर्मपाल' यह सुनिश्चित करते थे कि राज्य का प्रत्येक विधान धर्म के नैतिक नियमों के अनुकूल ही हो।
            'सुमन्त्र' उन सबमें सबसे अनुभवी और राजा दशरथ के अत्यंत निकटवर्ती प्रधान सलाहकार थे।
            यह सूची सिद्ध करती है कि प्रत्येक मंत्री अपने नाम के अनुरूप गुणों को अपने आचरण में धारण किए था।
            वाल्मीकि जी ने यहाँ एक 'आदर्श कैबिनेट' का खाका दिया है जो आज के युग के लिए भी प्रेरणादायक है।
            इन मंत्रियों की आपसी एकता ही अयोध्या की सुरक्षा व्यवस्था का सबसे बड़ा और अभेद्य रहस्य था।
        """.trimIndent(),
        englishCommentary = """
            The names of the eight ministers were Dhrishti, Jayanta, Vijaya, Surashtra, Rashtravardhana, Akopa, Dharmapala, and Sumantra.
            The etymological meanings of these names directly reflect their character and administrative roles.
            'Dhrishti' signified courage, while 'Jayanta' and 'Vijaya' stood for consistent victory in state missions.
            'Surashtra' and 'Rashtravardhana' were responsible for territorial integrity and national economic growth.
            'Akopa' was the one who had conquered anger, delivering justice with a serene and unclouded mind.
            'Dharmapala' ensured that every state ordinance strictly adhered to the eternal laws of morality.
            'Sumantra' was the most eminent and the closest confidant, serving as the King's chief diplomatic advisor.
            This list proves that each minister lived up to the virtues signified by their names in their daily conduct.
            Valmiki presents a blueprint for an 'Ideal Cabinet' that remains a standard for modern governance.
            The internal unity among these ministers was the ultimate secret behind Ayodhya's impenetrable defense.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 3,
        sanskrit = "वसिष्ठो वामदेवश्च ऋत्विजौ तस्य सम्मतौ ।\nतथान्ये च बभूवुर्हि ब्राह्मणा वेदपारगाः ॥ ३ ॥",
        hindiCommentary = """
            मंत्रियों के अतिरिक्त, वसिष्ठ और वामदेव महाराज दशरथ के अत्यंत प्रिय और सम्मानित 'ऋत्विज' (पुरोहित) थे।
            इनके साथ अन्य अनेक वेद-पारंगत ब्राह्मण भी थे जो राज्य को आध्यात्मिक और धार्मिक दिशा प्रदान करते थे।
            वसिष्ठ जी रघुकुल के कुलगुरु थे, जिनकी सहमति और आशीर्वाद के बिना कोई भी शुभ कार्य नहीं होता था।
            वामदेव जी धर्म के गूढ़ रहस्यों के ज्ञाता थे, जो राजा को नीति की जटिलताओं में सही मार्ग दिखाते थे।
            'सम्मतौ' शब्द यह दर्शाता है कि राजा और इन ऋषियों के बीच पूर्ण मानसिक और वैचारिक तालमेल था।
            इन ऋत्विजों का कार्य केवल पूजा-पाठ नहीं, बल्कि राष्ट्र की नैतिक आत्मा की रक्षा करना भी था।
            वेद-पारंगत होने का अर्थ है कि उनका ज्ञान केवल शब्दों तक नहीं, बल्कि वेदों के सार में गहराई से स्थित था।
            अयोध्या की शासन व्यवस्था में 'राज-शक्ति' और 'ब्रह्म-शक्ति' का एक अद्भुत संतुलन विद्यमान था।
            राजा दशरथ ऋषियों के चरणों में बैठकर शासन की प्रेरणा लेते थे, जो उनकी महान विनम्रता को दर्शाता है।
            इन ऋषियों की दिव्य उपस्थिति ही अयोध्या को एक पवित्र और सुरक्षित नगरी के रूप में विश्व में स्थापित करती थी।
        """.trimIndent(),
        englishCommentary = """
            In addition to the ministers, Vashistha and Vamadeva were the highly honored 'Ritvijas' (priests) of the King.
            Accompanying them were many other Brahmins who were thoroughly well-versed in the depths of the Vedas.
            Sage Vashistha was the family preceptor (Kula-Guru), without whose consent no major state event occurred.
            Vamadeva was an expert in the subtle mysteries of Dharma, advising the King on complex ethical dilemmas.
            The term 'Sammatau' indicates a profound mental and ideological harmony between the King and the sages.
            The role of these priests was not limited to rituals; they were the guardians of the nation's spiritual soul.
            Being 'Veda-paraga' implies that their wisdom was at its zenith, rooted in direct realization of Truth.
            Ayodhya's governance featured a sublime balance between 'Temporal Power' and 'Spiritual Wisdom.'
            King Dasharatha sought inspiration for his rule at the feet of these seers, showcasing His immense humility.
            The divine presence of these sages established Ayodhya as a holy and invincible capital in the world.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 4,
        sanskrit = "शूराश्च कृतविद्याश्च विनीताश्च जितेन्द्रियाः ।\nश्रीमन्तश्च महात्मानः शास्त्रज्ञा दृढविक्रमाः ॥ ४ ॥",
        hindiCommentary = """
            वे सभी मंत्री शूरवीर, विद्यावान, अत्यंत विनम्र और अपनी इंद्रियों को जीतने वाले (जितेन्द्रिय) थे।
            वे शोभाशाली (श्रीमन्त), महान आत्मा वाले, समस्त शास्त्रों के ज्ञाता और दृढ़ पराक्रमी (दृढविक्रमाः) थे।
            शूरवीर होने का अर्थ है कि वे युद्ध भूमि में भी सेना का सफल नेतृत्व करने में पूरी तरह सक्षम थे।
            विद्यावान और विनीत होना यह सिद्ध करता है कि उच्च पदों पर आसीन होने के बावजूद उनमें रत्ती भर भी अहंकार नहीं था।
            इंद्रियों को जीतने से वे कभी भी काम, क्रोध या लोभ के वशीभूत होकर राज्य के विरुद्ध गलत निर्णय नहीं लेते थे।
            शास्त्रों का ज्ञान उन्हें धर्मसंकट के समय सही और न्यायपूर्ण निर्णय लेने की स्पष्ट दृष्टि प्रदान करता था।
            'दृढविक्रम' होने के कारण वे शत्रु के सामने कभी नहीं झुकते थे और राज्य की सीमाओं की रक्षा के लिए अडिग थे।
            वाल्मीकि जी ने यहाँ एक प्रशासक के लिए आवश्यक बौद्धिक और शारीरिक—दोनों योग्यताओं का वर्णन किया है।
            उनका 'महात्मा' होना इस बात का प्रमाण था कि उनका हर कार्य केवल और केवल राष्ट्र के कल्याण के लिए समर्पित था।
            ऐसे सर्वगुण संपन्न मंत्रियों के कारण ही राजा दशरथ निश्चिंत होकर पूरे आर्यावर्त पर शासन करते थे।
        """.trimIndent(),
        englishCommentary = """
            All those ministers were valiant, highly educated, deeply humble, and masters of their senses.
            They were glorious (Shrimantah), high-souled, experts in the scriptures, and possessed unwavering valor.
            Being valiant indicates that they were equally capable of leading armies successfully on the battlefield.
            Being educated yet humble proves that despite holding the highest offices, they were entirely free of ego.
            Mastering their senses ensured they never made detrimental decisions influenced by lust, anger, or greed.
            Knowledge of the Shastras provided them with crystal-clear vision to make just decisions during moral crises.
            Their 'Dridhavikrama' (firm valor) meant they never bowed to enemies and staunchly protected the borders.
            Valmiki describes both the intellectual and physical qualifications necessary for an ideal administrator here.
            Being 'Mahatmas' (great souls) proved that every action they took was solely dedicated to national welfare.
            It was due to such multifaceted and perfect ministers that King Dasharatha ruled Aryavarta with a peaceful mind.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 5,
        sanskrit = "तेषाममात्याः शुचयो ज्ञानवन्तो गुणान्विताः ।\nनाविदितं किञ्चित् स्वेषु राष्ट्रेषु किञ्चन ॥ ५ ॥",
        hindiCommentary = """
            वे सभी अमात्य (मंत्री) मन, वचन और कर्म से अत्यंत पवित्र (शुचयो), ज्ञानवान और श्रेष्ठ गुणों से युक्त थे।
            उनके अपने राष्ट्र या किसी अन्य राष्ट्र में ऐसा कुछ भी नहीं था जो उनसे अज्ञात (अविदितं) या छिपा हुआ हो।
            पवित्रता का अर्थ है कि उनमें भ्रष्टाचार या स्वार्थ का लेशमात्र भी अंश नहीं था, वे पूरी तरह पारदर्शी थे।
            उनका सूचना तंत्र (Intelligence Network) इतना मजबूत था कि राज्य के हर कोने की खबर उन तक पहुँचती थी।
            शत्रु राष्ट्रों की कूटनीतिक चालों का भी उन्हें पहले से ही भान हो जाता था, जिससे राज्य सुरक्षित रहता था।
            ज्ञान और गुणों का यह मेल उन्हें केवल राजनीतिज्ञ नहीं, बल्कि एक उच्च कोटि का राजर्षि बनाता था।
            राजा को सही समय पर सही सूचना देना ही एक मंत्री का सबसे बड़ा और महत्वपूर्ण धर्म माना गया है।
            वाल्मीकि जी यहाँ अयोध्या की 'खुफिया प्रणाली' (Espionage System) की श्रेष्ठता की ओर सीधा संकेत कर रहे हैं।
            जहाँ राज्य के मंत्रियों की दृष्टि पैनी हो, वहाँ कोई भी शत्रु या आंतरिक विद्रोही सिर नहीं उठा सकता।
            यही कारण था कि अयोध्या में कभी भी कोई अप्रत्याशित संकट या विद्रोह उत्पन्न नहीं हुआ।
        """.trimIndent(),
        englishCommentary = """
            All the ministers were exceedingly pure in thought, word, and deed, highly knowledgeable, and full of virtues.
            There was absolutely nothing occurring in their own nation or in others that remained unknown to them.
            Purity implies an absolute lack of corruption or selfish motives; their administrative lives were totally transparent.
            Their Intelligence Network was so robust that news from every corner of the state reached them instantly.
            They were pre-emptively aware of the diplomatic maneuvers of enemy states, keeping Ayodhya constantly secure.
            The combination of knowledge and virtue elevated them from mere politicians to the status of royal sages.
            Providing the King with accurate information at the right time is considered a minister’s highest duty.
            Valmiki directly points to the superiority of Ayodhya’s espionage and internal security systems here.
            When the vision of the state’s ministers is razor-sharp, no enemy or internal rebellion can ever dare to rise.
            This was the primary reason why Ayodhya never faced any unforeseen crisis or internal uprising during that era.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 6,
        sanskrit = "सुसंवृताः सुसम्पन्नाः कुशलाः सर्वकर्मसु ।\nन तेषां शल्यमस्तीह न चामित्रो न चासकृत् ॥ ६ ॥",
        hindiCommentary = """
            वे अपने रहस्यों को सुरक्षित रखने वाले (सुसंवृताः), वैभव संपन्न और राजकाज के सभी कार्यों में अत्यंत कुशल थे।
            उन मंत्रियों के मन में किसी के प्रति कोई द्वेष (शल्य) नहीं था, और न ही उनका कोई अकारण शत्रु (अमित्र) था।
            राजकीय रहस्यों को गुप्त रखना कूटनीति का सबसे बड़ा और अनिवार्य नियम है, जिसे वे भली-भांति जानते थे।
            'सुसम्पन्नाः' होने का अर्थ है कि वे स्वयं धनी थे, जिससे उन्हें रिश्वत या लोभ की कोई आवश्यकता नहीं थी।
            सभी कार्यों में कुशल होने से राज्य की आर्थिक, सामरिक और सामाजिक नीतियाँ बिना किसी बाधा के चलती थीं।
            हृदय में 'शल्य' (कांटा या द्वेष) न होने से उनका हर निर्णय निष्पक्ष और विशुद्ध न्याय पर आधारित होता था।
            वे इतने न्यायप्रिय थे कि उनका कोई भी नागरिक या बाहरी राजा अकारण ही उनका शत्रु नहीं बनता था।
            यह श्लोक एक आदर्श लोक-सेवक के लिए आवश्यक मानसिक शांति और व्यावसायिक दक्षता को दर्शाता है।
            वाल्मीकि जी यह स्पष्ट कर रहे हैं कि एक शांत मन वाला मंत्री ही राज्य में शांति स्थापित कर सकता है।
            वे अपने कर्तव्यों का निर्वाह किसी दबाव में नहीं, बल्कि अपने धर्म और राष्ट्र-प्रेम के कारण करते थे।
        """.trimIndent(),
        englishCommentary = """
            They were masters at keeping state secrets (Susamvritah), prosperous, and highly skilled in all state affairs.
            There was no malice or thorn (Shalya) in their hearts against anyone, nor did they have any unprovoked enemies.
            Safeguarding state secrets is the paramount rule of diplomacy, a discipline they practiced flawlessly.
            Being 'Susampannah' (prosperous) meant they were personally wealthy, eradicating any susceptibility to bribery or greed.
            Their versatility in all tasks ensured that economic, strategic, and social policies ran without any friction.
            Having no 'Shalya' (thorn of prejudice) in their hearts meant their decisions were strictly impartial and purely just.
            They were so exceptionally fair that no citizen or foreign king ever became their enemy without just cause.
            This verse illustrates the necessary mental tranquility and professional efficiency required of an ideal civil servant.
            Valmiki clarifies that only a minister with a peaceful mind can successfully establish and maintain peace in a nation.
            They performed their duties not under any external pressure, but driven by their adherence to Dharma and patriotism.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 7,
        sanskrit = "ते हि सर्वे विजितेन्द्रियाः महात्मानः शास्त्रज्ञाः च ।\nसत्यप्रतिज्ञाः सर्वे च वदन्ति स्म हितं च नः ॥ ७ ॥",
        hindiCommentary = """
            वे सभी मंत्री अपनी इंद्रियों को पूरी तरह वश में रखने वाले, महान आत्मा वाले और शास्त्रों के पूर्ण ज्ञाता थे।
            वे अपनी प्रतिज्ञाओं के प्रति अत्यंत सत्यनिष्ठ थे और हमेशा राजा व प्रजा का परम हित ही बोलते थे।
            इंद्रियों पर विजय होने के कारण वे कभी भी राजमद या सत्ता के अहंकार में आकर गलत मार्ग नहीं चुनते थे।
            'महात्मानः' होने का अर्थ है कि उनका दृष्टिकोण संकीर्ण नहीं था, बल्कि वे पूरे राष्ट्र को एक परिवार मानते थे।
            शास्त्रों का ज्ञान उन्हें किसी भी जटिल परिस्थिति में धर्म के अनुसार सही मार्ग ढूँढने की अमोघ शक्ति देता था।
            सत्यप्रतिज्ञा होने का अर्थ है—उनका एक-एक शब्द अटल था, जिस पर पूरी प्रजा बिना किसी संकोच के विश्वास करती थी।
            वे चाटुकारिता नहीं करते थे, बल्कि राजा दशरथ को वही परामर्श देते थे जो वास्तव में राष्ट्र के लिए कल्याणकारी हो।
            वाल्मीकि जी यहाँ मंत्रियों के उन व्यक्तिगत गुणों का वर्णन कर रहे हैं जो उन्हें साक्षात् देवतुल्य बनाते थे।
            जहाँ सलाहकार सत्यवादी और संयमी हों, वहाँ अधर्म कभी भी राजकाज में अपना सिर नहीं उठा सकता।
            यह श्लोक एक आदर्श लोक-सेवक के लिए आवश्यक गुणों का सबसे प्राचीन और श्रेष्ठ वैश्विक मानदंड है।
        """.trimIndent(),
        englishCommentary = """
            All those ministers had completely conquered their senses, were high-souled, and were scholars of the scriptures.
            They were absolutely truthful to their vows and always spoke what was supremely beneficial for the King and subjects.
            Mastery over their senses ensured that they never strayed onto the wrong path due to the intoxication of power.
            Being 'Mahatmanah' implies their vision was never narrow; they considered the entire nation as one family.
            Knowledge of scriptures granted them the unfailing power to find the righteous path in any complex situation.
            Being 'Satyapratijñah' meant their every word was absolute, earning the unhesitating trust of the entire populace.
            They did not indulge in flattery; they offered King Dasharatha only that counsel which was truly in the national interest.
            Valmiki describes the personal attributes of the ministers here that elevated them to a near-divine status.
            Where the advisors are truthful and self-restrained, unrighteousness can never interfere in state affairs.
            This verse represents the oldest and highest global standard for the essential qualities of an ideal public servant.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 8,
        sanskrit = "नासूयकाः सानुक्रोशाः क्षमावन्तः प्रियंवदाः ।\nनाधर्मं कुर्वते केचित् न चासत्यं वदन्ति च ॥ ८ ॥",
        hindiCommentary = """
            वे ईर्ष्या रहित (नासूयकाः), अत्यंत दयालु, क्षमावान और सदैव मधुर वाणी बोलने वाले (प्रियंवदाः) थे।
            उनमें से कोई भी कभी अधर्म का साथ नहीं देता था और न ही कभी कोई असत्य बात अपने मुख से निकालता था।
            ईर्ष्या का न होना यह सिद्ध करता था कि मंत्रियों के बीच कोई राजनैतिक प्रतिस्पर्धा नहीं, बल्कि पूर्ण सहयोग था।
            दयालुता उनके न्याय का आधार थी, जहाँ वे प्रजा के कष्टों को दूर करने के लिए सदैव तत्पर रहते थे।
            क्षमाशीलता यह बताती है कि वे अपराधियों को भी सुधारने का अवसर देते थे और किसी से द्वेष नहीं रखते थे।
            मधुर वाणी उनका वह गुण था जिससे वे प्रजा का दिल जीत लेते थे और समाज में शांति की स्थापना करते थे।
            अधर्म से उनकी घृणा इतनी प्रबल थी कि वे किसी भी प्रलोभन के लिए अपने सिद्धांतों से कभी समझौता नहीं करते थे।
            असत्य का त्याग करना उनके लिए केवल एक नियम नहीं, बल्कि उनकी प्रतिष्ठा और उनके जीवन का प्राण था।
            वाल्मीकि जी यहाँ एक ऐसे 'एथिकल लीडरशिप' का चित्रण कर रहे हैं जो आज के नेताओं के लिए एक महान मिसाल है।
            यह श्लोक मानवीय स्वभाव की उच्चतम शुचिता और उसकी गरिमा का एक अत्यंत प्रेरक और जीवंत वर्णन प्रस्तुत करता है।
        """.trimIndent(),
        englishCommentary = """
            They were completely free from jealousy, profoundly compassionate, forgiving, and always soft-spoken.
            None among them ever committed or supported an unrighteous act, nor did they ever utter a falsehood.
            The absence of jealousy proves that there was no toxic political rivalry among them, only absolute cooperation.
            Compassion was the bedrock of their justice, where they remained ever ready to eradicate the sufferings of the people.
            Being forgiving indicates that they provided offenders a chance to reform and harbored no petty grudges.
            Their soft speech was the quality through which they won the subjects' hearts and established societal peace.
            Their aversion to Adharma was so absolute that they never compromised their principles for any earthly temptation.
            Abstaining from falsehood was not merely a rule; it was the foundation of their honor and their very life-breath.
            Valmiki portrays a model of 'Ethical Leadership' here that serves as a magnificent benchmark for modern leaders.
            This verse provides a highly inspiring and vivid account of the peak of human purity and its associated dignity.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 9,
        sanskrit = "स्वसुखेषु निराकाङ्क्षाः परदुःखेषु दुःखिताः ।\nराजप्रणयिनः सर्वे धर्मज्ञाश्च महाबलाः ॥ ९ ॥",
        hindiCommentary = """
            वे अपने व्यक्तिगत सुखों के प्रति कोई आकांक्षा नहीं रखते थे और दूसरों के दुख देखकर स्वयं अत्यंत दुखी होते थे।
            वे सभी राजा दशरथ के प्रति अगाध प्रेम रखने वाले, धर्म के पूर्ण ज्ञाता और अत्यंत शक्तिशाली (महाबलाः) थे।
            'स्वसुखेषु निराकाङ्क्षाः' होना एक लोक-सेवक का सर्वोच्च गुण है, जहाँ वह स्वयं से ऊपर राष्ट्र के हितों को रखता है।
            दूसरों के दुख में दुखी होना उनकी महान संवेदनशीलता और उनकी निस्वार्थ सेवा-भावना का साक्षात् प्रमाण था।
            राजा के प्रति उनका प्रेम चाटुकारिता नहीं था, बल्कि एक महान और स्थिर व्यक्तित्व के प्रति उनका स्वाभाविक अनुराग था।
            धर्म का ज्ञान उन्हें विवेकपूर्ण निर्णय लेने में सक्षम बनाता था, जिससे समाज की व्यवस्था हमेशा सुचारू बनी रहती थी।
            महाबल होने का अर्थ है कि वे न केवल बौद्धिक रूप से, बल्कि युद्ध और प्रशासन में भी शारीरिक रूप से सक्षम थे।
            वाल्मीकि जी ने यहाँ एक ऐसी 'इमोशनल इंटेलिजेंस' का वर्णन किया है जो एक श्रेष्ठ प्रशासक के लिए अनिवार्य है।
            वे प्रजा के लिए केवल कड़े नियम बनाने वाले अधिकारी नहीं, बल्कि उनके दुख-सुख के सच्चे साथी और रक्षक थे।
            राजा दशरथ को ऐसे सहायकों का मिलना उनके स्वयं के पुण्यों और अयोध्या की महान नियति का ही एक परिणाम था।
        """.trimIndent(),
        englishCommentary = """
            They held no desire for their own personal comforts and were deeply pained upon seeing the sorrows of others.
            They were all deeply affectionate toward King Dasharatha, absolute experts in Dharma, and possessed great might.
            Being indifferent to personal luxury is the supreme attribute of a public servant who prioritizes national interests.
            Being pained by others' distress was direct evidence of their immense sensitivity and selfless spirit of service.
            Their love for the King was not sycophancy, but a natural devotion toward a magnificent and stable personality.
            Expertise in Dharma empowered them to make discerning decisions, keeping the societal order flawlessly smooth.
            Being 'Mahabala' implies they were capable not just intellectually, but also physically in warfare and administration.
            Valmiki describes a high level of 'Emotional Intelligence' here, which is indispensable for a superior administrator.
            They were not just strict bureaucratic rule-makers but were true companions and protectors of the people.
            Finding such assistants was a direct result of King Dasharatha’s own immense virtues and Ayodhya's great destiny.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 10,
        sanskrit = "कोशसङ्ग्रहणे युक्ता बलस्य च परिग्रहे ।\nअहितं चापि पश्यन्ति न स्वसुतेष्वपि ॥ १० ॥",
        hindiCommentary = """
            वे मंत्री राजकोष (खजाना) को न्यायपूर्ण ढंग से भरने और सेना (बल) को सुदृढ़ करने के कार्यों में निरंतर लगे रहते थे।
            वे न्याय के इतने कठोर पक्षधर थे कि यदि उनका अपना पुत्र भी अपराध करता, तो वे उसे भी दंड (अहितं) देने से नहीं चूकते थे।
            कोश-संग्रहण किसी भी राज्य की आर्थिक रीढ़ होता है, और ये मंत्री बिना प्रजा को कष्ट दिए कोष की वृद्धि करते थे।
            सेना का परिग्रह (विस्तार) यह सुनिश्चित करता था कि अयोध्या की सीमाएं किसी भी विदेशी आक्रमण से पूरी तरह सुरक्षित रहें।
            अपने ही पुत्र को दंड देने की भावना उनके 'निष्पक्ष न्याय' (Impartial Justice) का सबसे बड़ा और कठोर उदाहरण है।
            राज्य के नियमों के सामने उनके लिए कोई भी सगा या संबंधी नहीं था; सत्य ही उनका एकमात्र परिवार था।
            यह श्लोक सिद्ध करता है कि अयोध्या में 'रूल ऑफ लॉ' (कानून का शासन) पूरी कठोरता और ईमानदारी से लागू था।
            वाल्मीकि जी बताते हैं कि जब मंत्री स्वयं आदर्श स्थापित करते हैं, तो प्रजा स्वतः ही अपराधों से दूर हो जाती है।
            मोह से मुक्त होना राजनीति की सबसे बड़ी आवश्यकता है, जिसे इन आठों मंत्रियों ने अपने जीवन में चरितार्थ किया था।
            इस प्रकार का निष्कलंक प्रशासन ही राम-राज्य की भूमिका तैयार करने में सबसे बड़ा कारण सिद्ध हुआ।
        """.trimIndent(),
        englishCommentary = """
            The ministers were consistently engaged in justly enriching the royal treasury and strengthening the armed forces.
            They were such staunch advocates of justice that if their own sons committed a crime, they did not hesitate to punish them.
            Enriching the treasury is the economic spine of any state, and they achieved this without ever harassing the subjects.
            The expansion of the military (Bala) ensured that Ayodhya's borders remained completely impregnable to foreign attacks.
            The willingness to punish their own offspring stands as the greatest and strictest example of their 'Impartial Justice.'
            Before the law of the state, they recognized no relatives or favorites; Truth was their one and only family.
            This verse proves that the 'Rule of Law' was implemented with absolute rigor and unwavering honesty in Ayodhya.
            Valmiki implies that when ministers themselves set such high ideals, the populace naturally abstains from crime.
            Freedom from familial attachment is a prime necessity in politics, which these eight ministers perfectly embodied.
            Such unblemished and objective administration served as the primary foundation for the upcoming Ram-Rajya.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 11,
        sanskrit = "अक्लिष्टकारिणः सर्वे व्यवहारविदो नराः ।\nन कश्चिद् दुष्टमन्त्रोऽस्ति तेषामपि महात्मनाम् ॥ ११ ॥",
        hindiCommentary = """
            वे सभी मंत्री किसी को अकारण क्लेश या पीड़ा न पहुँचाने वाले (अक्लिष्टकारिणः) और व्यवहार (कानून/न्याय) के ज्ञाता थे।
            उन महात्माओं में से किसी का भी विचार या परामर्श (मन्त्र) कभी दुष्टतापूर्ण या स्वार्थ से भरा हुआ नहीं होता था।
            'व्यवहारविद' होने का अर्थ है कि वे राज्य के सिविल और क्रिमिनल कानूनों के बहुत ही सूक्ष्म जानकार थे।
            वे दंड देते समय भी यह ध्यान रखते थे कि अपराधी को अनावश्यक पीड़ा न हो, बल्कि केवल न्याय की स्थापना हो।
            'दुष्टमन्त्र' (बुरी सलाह) का अभाव यह सुनिश्चित करता था कि राजा दशरथ तक कोई भी गलत या भ्रामक नीति नहीं पहुँचती थी।
            मंत्रीगण हमेशा पारदर्शी और स्पष्ट नीतियाँ बनाते थे जो राज्य के हर नागरिक के लिए कल्याणकारी होती थीं।
            वाल्मीकि जी यहाँ मंत्रियों की बौद्धिक और नैतिक पवित्रता का एक बहुत ही सुंदर और प्रेरणादायक चित्र खींच रहे हैं।
            उनका हर निर्णय शास्त्रों और मानवीय संवेदनाओं की कसौटी पर परखा हुआ होता था।
            जहाँ की मंत्रिपरिषद इतनी विशुद्ध हो, वहाँ राज्य की मशीनरी कभी भी भ्रष्ट या निरंकुश नहीं हो सकती।
            ये मंत्री राजा के लिए एक ऐसे दर्पण के समान थे जो केवल सत्य और मर्यादा का ही प्रतिबिंब दिखाते थे।
        """.trimIndent(),
        englishCommentary = """
            All those ministers refrained from causing unprovoked pain (Aklishthakarinah) and were profound experts in jurisprudence.
            None of the counsel or policies (Mantra) formulated by those great souls was ever wicked or tainted by selfishness.
            Being 'Vyavaharavidah' means they were meticulous scholars of both the civil and criminal laws of the state.
            Even while delivering punishment, they ensured that the focus remained on establishing justice, not inflicting undue suffering.
            The absence of 'Dushtamantra' (malicious advice) guaranteed that no flawed or deceptive policy ever reached the King.
            The ministers always crafted transparent and lucid policies that were universally beneficial to every citizen.
            Valmiki paints a beautiful and inspiring picture of the intellectual and moral purity of the King's cabinet.
            Every decision they made was rigorously tested against the standards of the scriptures and deep human empathy.
            Where the council of ministers is so pristine, the machinery of the state can never become corrupt or autocratic.
            These ministers acted as a flawless mirror for the King, reflecting only the images of Truth and propriety.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 12,
        sanskrit = "ते हि सर्वे विजितेन्द्रियाः महात्मानः शास्त्रज्ञाः च ।\nसत्यप्रतिज्ञाः सर्वे च वदन्ति स्म हितं च नः ॥ १२ ॥",
        hindiCommentary = """
            (यह श्लोक मूल रामायण के कुछ संस्करणों में मंत्रियों की सत्यनिष्ठा को पुनः दृढ़ करने के लिए दोहराया या विस्तार दिया गया है।)
            वे सभी मंत्री इंद्रियों पर विजय प्राप्त किए हुए, महान आत्मा वाले और नीतिशास्त्र के प्रकांड विद्वान थे।
            वे अपने वचनों के पक्के थे और हमेशा राजा, राज्य और प्रजा के हित की ही बात करते थे।
            पुनरावृत्ति (Repetition) का अर्थ यहाँ वाल्मीकि द्वारा उन गुणों पर विशेष जोर देना है जो शासन का मूल हैं।
            जब तक शासक 'विजितेन्द्रिय' नहीं होता, वह राज्य के खजाने और शक्ति का दुरुपयोग करने से बच नहीं सकता।
            सत्य की प्रतिज्ञा उन्हें समाज में एक ऐसा सम्मान दिलाती थी जो किसी राजा से कम नहीं था।
            उनका 'हित' बोलना केवल मीठा बोलना नहीं था, बल्कि वह कड़वा सत्य भी था जो राज्य को संकट से बचा सके।
            यह श्लोक यह संदेश देता है कि एक सुखी राष्ट्र के निर्माण के लिए राजनेताओं का चरित्र ही सबसे महत्वपूर्ण उपकरण है।
            महान आत्मा (महात्मा) होने के कारण वे अपने पद का अहंकार नहीं पालते थे, बल्कि सेवाभाव से भरे रहते थे।
            अयोध्या का यह प्रशासन दुनिया के लिए 'सुशासन' (Good Governance) का पहला और सबसे प्रामाणिक 'मैनुअल' है।
            मुनि वाल्मीकि ने इन श्लोकों के माध्यम से राजनीति को एक 'आध्यात्मिक साधना' के रूप में प्रस्तुत किया है।
        """.trimIndent(),
        englishCommentary = """
            (In certain recensions, this verse expands upon and reiterates the ministers' integrity for profound emphasis.)
            All those ministers were conquerors of their senses, great-souled, and profound scholars of political science.
            They were staunch in their vows and consistently spoke only of the welfare of the King, the state, and the people.
            The repetition here by Valmiki serves to place special emphasis on the core virtues that sustain an empire.
            Unless a ruler is 'Vijitendriya' (sense-controlled), he cannot avoid misusing the state's wealth and military power.
            Their commitment to truth earned them a level of respect in society that was parallel to the King himself.
            Speaking of 'welfare' did not merely mean sweet talk; it included the bitter truths necessary to avert national crises.
            This verse conveys the message that the character of politicians is the most crucial tool in building a happy nation.
            Being 'Mahatmas,' they harbored no arrogance about their high offices, remaining full of the spirit of service.
            This administration of Ayodhya serves as the world's first and most authentic manual on 'Good Governance.'
            Through these verses, Sage Valmiki elevates the practice of politics to the level of a high 'Spiritual Discipline.'
        """.trimIndent()
    ),
    RamayanVerse(
        id = 13,
        sanskrit = "वीरैश्च शूरैश्च सुसम्पन्नैः सर्वकर्मसु कोविदैः ।\nनाविदितं किञ्चित् स्वेषु राष्ट्रेषु किञ्चन ॥ १३ ॥",
        hindiCommentary = """
            वे मंत्री वीर, शूर, अत्यंत कुशाग्र और राजकाज के सभी कार्यों में पूरी तरह से निपुण (कोविद) थे।
            उनका खुफिया तंत्र इतना सशक्त था कि उनके अपने राष्ट्र या पड़ोसी राज्यों में कोई भी बात उनसे छिपी नहीं रहती थी।
            'वीर' और 'शूर' विशेषण बताते हैं कि वे केवल कलम के सिपाही नहीं थे, बल्कि जरूरत पड़ने पर तलवार भी उठा सकते थे।
            सभी कार्यों में निपुणता (सर्वकर्मसु कोविद) का अर्थ है कि उन्हें अर्थशास्त्र, सैन्य विज्ञान और कूटनीति का पूरा ज्ञान था।
            राजा दशरथ के मंत्री किसी भी एक क्षेत्र तक सीमित नहीं थे, वे 'मल्टी-टास्कर' (बहुआयामी) नेतृत्वकर्ता थे।
            'नाविदितं किञ्चित्' यह सिद्ध करता है कि राज्य के भीतर कोई भी गुप्त षड्यंत्र उनके संज्ञान के बिना नहीं पनप सकता था।
            यह बुद्धिमत्ता और सजगता ही अयोध्या के अभेद्य होने का सबसे बड़ा कारण थी।
            वाल्मीकि जी यहाँ बता रहे हैं कि एक आदर्श राज्य वह है जहाँ का प्रशासन हमेशा सतर्क और सक्रिय रहता है।
            मंत्रीगण प्रजा के हर वर्ग की नब्ज पहचानते थे और उसी के अनुरूप अपनी नीतियाँ लागू करते थे।
            यह श्लोक राज्य की 'सुरक्षा और खुफिया' व्यवस्था की एक अत्यंत गौरवशाली और तकनीकी तस्वीर पेश करता है।
        """.trimIndent(),
        englishCommentary = """
            Those ministers were heroic, brave, highly astute, and perfectly adept (Kovida) in all matters of the state.
            Their intelligence network was so formidable that absolutely nothing in their own or neighboring states remained hidden from them.
            The adjectives 'Vira' and 'Shura' indicate they were not just men of the pen, but could wield the sword if necessary.
            Being adept in all tasks (Sarvakarmasu Kovida) meant they possessed total mastery over economics, military science, and diplomacy.
            King Dasharatha's ministers were not confined to a single domain; they were highly versatile, multi-dimensional leaders.
            'Naviditam kinchit' proves that no secret conspiracy could ever brew within the state without their immediate knowledge.
            This exceptional intelligence and vigilance formed the core reason behind the total invincibility of Ayodhya.
            Valmiki highlights that an ideal kingdom is one where the administration is perpetually alert and proactively engaged.
            The ministers understood the pulse of every section of society and implemented their policies accordingly.
            This verse presents an exceedingly glorious and technical picture of the state's internal security and espionage framework.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 14,
        sanskrit = "गुप्ताश्च सुविभक्ताश्च सर्वतः परिरक्षिताः ।\nन तेषां शल्यमस्तीह न चामित्रो न चासकृत् ॥ १४ ॥",
        hindiCommentary = """
            वे मंत्री राज्य के गुप्त रहस्यों के रक्षक थे, उनके कार्य सुविभक्त (बंटे हुए) थे, और वे सब ओर से सुरक्षित थे।
            उनके मन में किसी के लिए कोई कांटा (द्वेष) नहीं था और न ही उनका कोई ऐसा शत्रु था जो बार-बार उन पर प्रहार करे।
            कार्यों का 'सुविभक्त' होना एक बहुत ही उन्नत प्रशासनिक व्यवस्था (Division of Labor) को दर्शाता है।
            हर मंत्री के पास अपना एक स्पष्ट विभाग था, जिससे कार्यों में कोई टकराव या भ्रम की स्थिति उत्पन्न नहीं होती थी।
            द्वेष (शल्य) का अभाव उनके मानसिक स्वास्थ्य और उनकी आध्यात्मिक गहराई का प्रमाण है।
            जब मंत्री न्याय के पथ पर होते हैं, तो वे अकारण शत्रु पैदा नहीं करते; उनके शत्रु केवल अधर्मी ही होते हैं।
            'सर्वतः परिरक्षिताः' का अर्थ है कि वे मंत्री स्वयं भी राज्य के सुरक्षा तंत्र द्वारा भली-भांति सुरक्षित थे।
            वाल्मीकि जी ने यहाँ एक ऐसा 'सिस्टम' वर्णित किया है जो बिना किसी घर्षण (Friction) के सुचारू रूप से चलता है।
            यह श्लोक स्पष्ट करता है कि दशरथ के मंत्री दल में कोई भी आंतरिक गुटबाजी या ईर्ष्या नहीं थी।
            इस प्रकार का स्वच्छ और संगठित प्रशासन ही किसी भी देश को 'विश्वगुरु' बनाने का सामर्थ्य रखता है।
        """.trimIndent(),
        englishCommentary = """
            The ministers were guardians of state secrets, their duties were well-divided, and they were protected from all sides.
            There was no thorn of malice in their hearts, nor did they have any enemy who could repeatedly strike at them.
            The 'Suvibhakta' (well-divided) nature of their work highlights a highly advanced administrative system of Division of Labor.
            Every minister headed a clear department, ensuring that no conflict of interest or confusion ever arose in operations.
            The absence of malice (Shalya) is a profound testament to their mental health and deep spiritual grounding.
            When ministers walk the path of pure justice, they do not create unprovoked enemies; their only foes are the unrighteous.
            'Sarvatah parirakshitah' implies that the ministers themselves were well-protected by the state's comprehensive security grid.
            Valmiki describes a 'System' here that functions smoothly and efficiently without any internal friction.
            This verse makes it crystal clear that there was absolutely no internal factionalism or jealousy within Dasharatha’s cabinet.
            Such a clean, organized, and harmonious administration is what grants any nation the capability to become a world leader.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 15,
        sanskrit = "सन्धि विग्रहतत्त्वज्ञाः प्रकृत्या सम्पदान्विताः ।\nमन्त्रसंवृतयः शूराः शास्त्रेषु कृतनिश्चयाः ॥ १५ ॥",
        hindiCommentary = """
            वे मंत्री संधि (मित्रता) और विग्रह (युद्ध) के सिद्धांतों के पूर्ण ज्ञाता थे और स्वभाव से ही संपत्ति (गुणों) से युक्त थे।
            वे मंत्रणा (राज्य के रहस्यों) को गुप्त रखने में निपुण, शूरवीर और शास्त्रों के आधार पर दृढ़ निश्चय करने वाले थे।
            संधि और विग्रह कूटनीति के दो सबसे महत्वपूर्ण अंग हैं; दशरथ के मंत्री जानते थे कि कब युद्ध करना है और कब शांति।
            'प्रकृत्या सम्पदान्विताः' का अर्थ है कि उनका अच्छा स्वभाव कोई दिखावा नहीं था, बल्कि वह जन्मजात और संस्कारित था।
            मन्त्रसंवृति (Confidentiality) यह सुनिश्चित करती थी कि राज्य की योजनाएं शत्रुओं के कानों तक कभी न पहुँचें।
            शास्त्रों में कृतनिश्चय होने का अर्थ है कि उनका हर फैसला प्राचीन ऋषियों द्वारा रचित संविधान के अनुकूल होता था।
            वे अपने मनमाने ढंग से कानून नहीं थोपते थे, बल्कि नीति-शास्त्र के स्थापित नियमों का ही पालन करते थे।
            यह श्लोक मंत्रियों की 'विदेशी नीति' (Foreign Policy) और उनके 'निर्णय लेने की क्षमता' का सुंदर वर्णन है।
            शूरवीर होने के साथ-साथ शास्त्रों का ज्ञान होना उन्हें एक पूर्ण और आदर्श राजनेता (Statesman) बनाता था।
            वाल्मीकि जी ने इस श्लोक में राजनीति की कला और विज्ञान—दोनों के अद्भुत समन्वय को प्रकट किया है।
        """.trimIndent(),
        englishCommentary = """
            The ministers were complete masters of the principles of Sandhi (alliance) and Vigraha (war), and were naturally endowed with virtues.
            They were experts in keeping state counsels confidential, were heroic, and made firm decisions based on the scriptures.
            Alliance and War are the two most critical components of diplomacy; these ministers knew exactly when to seek peace and when to fight.
            'Prakritya Sampadanvitah' means their noble disposition was not a pretense, but an innate and cultured trait.
            'Mantrasamvriti' (Confidentiality) guaranteed that the strategic plans of the state never reached the ears of enemy spies.
            Making firm decisions based on Shastras meant that every verdict aligned strictly with the constitution laid down by ancient seers.
            They did not impose arbitrary laws but dutifully executed the established codes of political ethics.
            This verse provides a beautiful description of the ministers' 'Foreign Policy' and their extraordinary 'Decision-Making' skills.
            Being heroic while simultaneously possessing scriptural wisdom made them complete and ideal Statesmen.
            In this verse, Sage Valmiki reveals the marvelous synthesis of both the art and the science of politics.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 16,
        sanskrit = "क्षमावन्तो यशस्विनः धर्मज्ञाश्च महाबलाः ।\nदशरथस्य इमेऽमात्याः राज्ञो दशरथस्य च ॥ १६ ॥",
        hindiCommentary = """
            वे सभी मंत्री अत्यंत क्षमावान, यशस्वी, धर्म के मर्म को जानने वाले और शारीरिक व मानसिक रूप से महाबली थे।
            ये सभी महान अमात्य (मंत्री) राजा दशरथ के दरबार की शोभा थे और उनके शासन के मुख्य आधार थे।
            क्षमावान होना यह दर्शाता है कि वे शक्ति के नशे में चूर नहीं थे; वे निर्बलों की गलतियों को माफ करने का हृदय रखते थे।
            यशस्वी होने का अर्थ है कि उनके न्याय की गाथाएं अयोध्या के बाहर भी श्रद्धा के साथ गाई जाती थीं।
            धर्म का ज्ञान ही वह प्रकाश था जो उन्हें हर अंधकारमय परिस्थिति में सही निर्णय लेने की दिशा दिखाता था।
            महाबल होना आवश्यक था ताकि कोई भी विद्रोही या शत्रु राज्य की शांति को भंग करने का साहस न कर सके।
            वाल्मीकि जी बार-बार 'धर्मज्ञा' शब्द का प्रयोग करते हैं, जो यह सिद्ध करता है कि राम-राज्य की नींव 'धर्म' ही है।
            राजा दशरथ का प्रताप इन मंत्रियों के बिना अधूरा था, क्योंकि राजा का शरीर उसके मंत्री ही होते हैं।
            यह श्लोक दशरथ के मंत्रिमंडल के 'चरित्र और शक्ति' के उस अंतिम और पक्के निष्कर्ष को प्रस्तुत करता है।
            ऐसे महान मंत्रियों के संरक्षण में ही अयोध्या की वह पावन भूमि राम के अवतार के लिए पूरी तरह से तैयार हो रही थी।
        """.trimIndent(),
        englishCommentary = """
            All those ministers were highly forgiving, illustrious, profound knowers of Dharma, and possessed of great power.
            These great Amatyas (counselors) were the crowning glory of King Dasharatha's court and the main pillars of His rule.
            Being forgiving shows that they were not intoxicated by power; they possessed the magnanimity to pardon the weak.
            Being illustrious meant that the tales of their justice were sung with deep reverence even beyond the borders of Ayodhya.
            The knowledge of Dharma was the guiding light that helped them navigate and make righteous decisions in every dark crisis.
            Being 'Mahabala' (greatly powerful) was essential so that no rebel or enemy could ever dare to disrupt the state's peace.
            Valmiki repeatedly uses the term 'Dharmajña,' proving that 'Dharma' is the absolute foundation of the Ram-Rajya model.
            King Dasharatha’s glory would have been incomplete without them, for the ministers act as the very limbs of the monarch.
            This verse presents the final and definitive conclusion regarding the 'Character and Power' of Dasharatha's cabinet.
            Under the meticulous care of such great ministers, the holy land of Ayodhya was being prepared for Rama’s divine incarnation.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 17,
        sanskrit = "स तैर्गुणैरनुपमैः सचिवैः सुयशस्विभिः ।\nशशास पृथिवीं कृत्स्नां दशरथो महाराजः ॥ १७ ॥",
        hindiCommentary = """
            इन्हीं अनुपम गुणों वाले और अत्यंत यशस्वी सचिवों (मंत्रियों) की सहायता से महाराज दशरथ ने शासन किया।
            उन्होंने इन मंत्रियों के उचित परामर्श से पूरी पृथ्वी (कृत्स्नां पृथिवीं) पर अपना न्यायपूर्ण और धर्ममय राज्य स्थापित किया।
            'अनुपम' गुणों का अर्थ है कि दशरथ के मंत्रियों का जो स्तर था, वह संसार के इतिहास में अद्वितीय और बेजोड़ है।
            राजा दशरथ का शासन केवल एक नगर का नहीं था; वे उस युग के चक्रवर्ती सम्राट थे जिनका प्रभाव सर्वत्र था।
            मंत्रियों की यशस्विता राजा के यश में वृद्धि करती थी, क्योंकि अच्छे मंत्री राजा की ही विवेकशीलता का परिणाम होते हैं।
            यह श्लोक यह सिद्ध करता है कि एक महान साम्राज्य के निर्माण में राजा और उसके सहयोगियों का 'टीम-वर्क' सबसे महत्वपूर्ण है।
            पृथ्वी पर शासन करने का आशय बल-प्रयोग से नहीं, बल्कि धर्म और नीति के उस प्रभाव से था जिसे सब राजा मानते थे।
            वाल्मीकि जी ने यहाँ अयोध्या के 'स्वर्ण युग' का एक ऐसा खाका खींचा है जो आज भी राजशास्त्र का सर्वोच्च आदर्श है।
            इन मंत्रियों के कारण ही दशरथ को कभी भी राज्य की चिंता नहीं सताती थी और वे यज्ञ आदि में ध्यान लगा पाते थे।
            यह श्लोक राजा दशरथ के वैभवपूर्ण काल का एक बहुत ही गौरवशाली और ऐतिहासिक निष्कर्ष प्रस्तुत करता है।
        """.trimIndent(),
        englishCommentary = """
            With the assistance of these exceptionally virtuous and highly illustrious ministers, Maharaja Dasharatha governed.
            Aided by their sound counsel, He established His just and righteous rule over the entire earth (Kritsnam Prithivim).
            'Unparalleled' virtues imply that the standard maintained by Dasharatha’s cabinet remains historically unique and unmatched.
            Dasharatha’s reign was not confined to a single city; He was the universal monarch (Chakravarti) of that era.
            The fame of the ministers amplified the King’s own glory, as good advisors are the direct reflection of a King's wisdom.
            This verse proves that impeccable 'Teamwork' between the sovereign and his aides is the most vital element of a great empire.
            Ruling the earth did not imply oppressive force, but an over-arching influence of Dharma and policy respected by all kings.
            Valmiki draws the blueprint of Ayodhya’s 'Golden Age' here, which remains the supreme ideal in political science even today.
            It was due to these ministers that Dasharatha was free from administrative anxieties and could focus on grand sacrifices.
            This verse provides a glorious and historical conclusion to the magnificent era of King Dasharatha's global sovereignty.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 18,
        sanskrit = "धर्मेण राज्यं कुर्वाणो न तस्य परितप्यते ।\nहृदयं राजसिंहस्य दशरथस्य महात्मनः ॥ १८ ॥",
        hindiCommentary = """
            धर्म के अनुसार राज्य का संचालन करते हुए, उन महात्मा और राजाओं में सिंह के समान दशरथ का हृदय कभी संतप्त नहीं होता था।
            चूंकि उनका हर निर्णय सत्य और न्याय की नींव पर खड़ा होता था, इसलिए उन्हें कभी भी किसी बात का पश्चाताप (परिताप) नहीं होता था।
            एक राजा को अक्सर कठिन निर्णय लेने पड़ते हैं, पर जब आधार 'धर्म' हो, तो मन में कोई अपराध-बोध या शंका नहीं बचती।
            'राजसिंहस्य' विशेषण दशरथ के उस निर्भय और प्रतापी स्वरूप को दर्शाता है जो किसी भी अन्याय के सामने झुकता नहीं था।
            महात्मा होने के कारण उनका हृदय अपनी प्रजा के लिए करुणा से भरा था, पर न्याय करते समय वे अत्यंत दृढ़ रहते थे।
            यह श्लोक 'धार्मिक शासन' (Righteous Governance) के उस परम सुख को दिखाता है जो शासक को मानसिक शांति प्रदान करता है।
            जहाँ धर्म है, वहाँ अंतर्विरोध नहीं होता; यही कारण था कि दशरथ का हृदय हमेशा एक अगाध शांति से परिपूर्ण रहता था।
            वाल्मीकि जी स्पष्ट करते हैं कि सत्ता का सुख उसके उपभोग में नहीं, बल्कि धर्म के पालन से मिलने वाले संतोष में है।
            उनका राज्य एक ऐसा 'राम-राज्य' का पूर्व-रूप था जहाँ हर व्यक्ति सुरक्षित और राजा स्वयं तनाव-मुक्त था।
            यह श्लोक आधुनिक नेतृत्व के लिए एक संदेश है कि सत्य के मार्ग पर चलने वाला नेता ही वास्तविक शांति का अनुभव कर सकता है।
        """.trimIndent(),
        englishCommentary = """
            Administering the kingdom strictly according to Dharma, the heart of that high-souled, lion-like King Dasharatha never suffered any agony.
            Because every decision He made was anchored in Truth and Justice, He never experienced any remorse or mental torment (Paritap).
            Monarchs often face tough choices, but when the foundation is 'Dharma,' it leaves no room for guilt, doubt, or inner conflict.
            The epithet 'Rajasimhasya' (Lion among kings) reflects Dasharatha’s fearless and majestic persona that never bowed to injustice.
            Being a 'Mahatma,' His heart was full of compassion for His subjects, yet He remained absolutely firm while dispensing justice.
            This verse illustrates the supreme joy of 'Righteous Governance' that bestows absolute mental tranquility upon the ruler.
            Where Dharma prevails, internal contradictions vanish; this is why Dasharatha's heart was perpetually filled with profound peace.
            Valmiki clarifies that the true joy of power lies not in its consumption, but in the deep satisfaction derived from upholding Duty.
            His reign was a pristine prototype for 'Ram-Rajya,' where every citizen was secure and the King Himself was completely stress-free.
            This verse holds a timeless message for modern leadership: only a leader walking the path of Truth can experience genuine peace.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 19,
        sanskrit = "स तैर्गुणैः समुदितैः सचिवैः समलङ्कृतः ।\nददृशे राजशार्दूलो नक्षत्रैर्विमलो यथ ॥ १९ ॥",
        hindiCommentary = """
            उन समस्त महान गुणों से युक्त सचिवों (मंत्रियों) के बीच घिरे हुए वे राजाओं में श्रेष्ठ (राजशार्दूल) दशरथ अत्यंत सुशोभित होते थे।
            उनके दरबार का वह दृश्य ऐसा लगता था मानो निर्मल और चमकते हुए नक्षत्रों (तारों) के बीच साक्षात् चंद्रमा (या सूर्य) विराजमान हो।
            'राजशार्दूल' का अर्थ है राजाओं में बाघ के समान पराक्रमी, जो दशरथ के राजसी तेज और उनके प्रभावशाली व्यक्तित्व को दर्शाता है।
            नक्षत्रों की उपमा मंत्रियों के लिए दी गई है, जो अपने ज्ञान और कर्मों से राज्य को प्रकाश देते थे, पर उनका केंद्र राजा ही था।
            यह श्लोक उस सभा के 'एस्थेटिक' और आध्यात्मिक सौंदर्य का वर्णन करता है, जहाँ शक्ति और ज्ञान का परम सुंदर समन्वय था।
            जैसे चंद्रमा तारों के बिना सूना लगता है, वैसे ही एक महान राजा भी अपने योग्य मंत्रियों के बिना अधूरा होता है।
            वाल्मीकि जी ने यहाँ दशरथ की उस सभा को एक ब्रह्मांडीय रूप (Cosmic Form) दे दिया है, जो अत्यंत पवित्र और गरिमामयी है।
            मंत्री केवल सेवक नहीं थे, बल्कि वे राजा के उस आभामंडल का हिस्सा थे जो अयोध्या को पूरे विश्व में चमकाता था।
            यह दृश्य सिद्ध करता है कि एक श्रेष्ठ नेतृत्व वही है जो अपने आसपास के लोगों को भी चमकने और विकसित होने का अवसर दे।
            इस श्लोक के साथ वाल्मीकि जी अयोध्या के उस वैभवशाली और शांत युग का वर्णन चरम पर पहुँचा देते हैं।
        """.trimIndent(),
        englishCommentary = """
            Surrounded by those ministers endowed with all great virtues, Dasharatha, the tiger among kings, looked exceedingly magnificent.
            The scene of His royal court appeared exactly as if the pristine Moon (or Sun) was glowing brilliantly amidst a cluster of radiant stars.
            'Rajashardula' means a tiger among kings, reflecting Dasharatha’s royal majesty, fearless aura, and highly influential personality.
            The metaphor of 'stars' is used for the ministers, who illuminated the state with their wisdom, while the King remained their vital center.
            This verse beautifully describes the aesthetic and spiritual grandeur of that assembly, where power and wisdom merged seamlessly.
            Just as the moon seems lonely without the stars, a great monarch is entirely incomplete without his capable and worthy ministers.
            Valmiki elevates Dasharatha’s court to a 'Cosmic Form' here, establishing it as exceptionally sacred, harmonious, and dignified.
            The ministers were not mere servants; they were integral elements of that halo which made Ayodhya shine across the entire world.
            This scene proves that true leadership is one that provides its associates the platform and opportunity to shine and grow brightly.
            With this verse, Valmiki brings the description of Ayodhya's opulent, peaceful, and majestic era to its absolute zenith.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 20,
        sanskrit = "तस्य त्वेवं प्रभावस्य धर्मज्ञस्य महात्मनः ।\nसुतार्थं तप्यमानस्य नासीद्वंशकरः सुतः ॥ २० ॥",
        hindiCommentary = """
            इस प्रकार के अपार प्रभाव, धर्म के पूर्ण ज्ञान और महात्मा स्वरूप वाले राजा दशरथ के जीवन में केवल एक ही भारी दुख था।
            पुत्र-प्राप्ति के लिए निरंतर तप (संताप) करते रहने पर भी, उनके यहाँ अपने वंश को आगे बढ़ाने वाला कोई भी पुत्र नहीं था।
            यह श्लोक रामायण की कथा के मुख्य मोड़ (Turning Point) की ओर ले जाता है, जहाँ से राम के अवतरण की पृष्ठभूमि तैयार होती है।
            संसार के सारे सुख, ऐश्वर्य और अजेय शक्ति होने के बावजूद, दशरथ का हृदय इस एक कमी के कारण भीतर ही भीतर रोता था।
            'वंशकरः सुतः' (वंश को चलाने वाला पुत्र) न होना उस युग में एक राजा के लिए सबसे बड़ी चिंता का विषय माना जाता था।
            यह स्थिति दर्शाती है कि भौतिक समृद्धि और राजसत्ता मनुष्य को पूर्ण संतुष्टि नहीं दे सकती; जीवन में कुछ रिक्तता हमेशा रहती है।
            मुनि वाल्मीकि ने यहाँ दशरथ की उस पीड़ा को बहुत ही सूक्ष्मता से उकेरा है जो उनके राजसी मुस्कान के पीछे छिपी हुई थी।
            यही वह पीड़ा थी जिसने अंततः दशरथ को 'पुत्रेष्टि यज्ञ' करने के लिए प्रेरित किया, जिससे साक्षात् नारायण पृथ्वी पर आए।
            एक महान साम्राज्य का उत्तराधिकारी न होना केवल एक व्यक्तिगत दुख नहीं, बल्कि पूरे राष्ट्र के भविष्य पर एक प्रश्नचिह्न था।
            यह श्लोक हमें सिखाता है कि नियति बड़े लोगों को भी उनके कर्म और धैर्य की परीक्षा के लिए कुछ कमियाँ जरूर देती है।
        """.trimIndent(),
        englishCommentary = """
            Despite possessing such immense influence, complete knowledge of Dharma, and a high soul, King Dasharatha harbored a deep sorrow.
            Even though He constantly agonized and prayed for a son, He had not yet been blessed with an heir to continue His glorious lineage.
            This verse acts as the critical 'Turning Point' of the epic, setting the exact stage and background for the divine incarnation of Lord Rama.
            Despite possessing all worldly joys, unimaginable opulence, and invincible power, Dasharatha’s heart wept silently over this one void.
            The absence of a 'Vamshakara Suta' (lineage-bearing son) was considered the most profound anxiety for any monarch in that ancient era.
            This situation illustrates that material prosperity and supreme authority cannot grant absolute fulfillment; a void often remains in life.
            Sage Valmiki subtly carves out the hidden agony of Dasharatha that lay concealed behind His confident and radiant royal smile.
            It was this very pain that ultimately compelled Dasharatha to perform the 'Putreshti Yajna,' bringing the Supreme Lord Narayana to earth.
            The lack of an heir for such a great empire was not just a personal tragedy but a looming question mark over the nation's future.
            This verse teaches us that Destiny deliberately imparts certain voids even to great men to test their karma, faith, and patience.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 21,
        sanskrit = "चिन्तयानस्य तस्यैवं बुद्धिरासीन्महात्मनः ।\nसुतार्थं वाजिमेधेन किमर्थं न यजाम्यहम् ॥ २१ ॥",
        hindiCommentary = """
            इसी चिंता में निरंतर डूबे हुए उन महात्मा राजा दशरथ के मन में अचानक एक अत्यंत उत्तम विचार (बुद्धि) उत्पन्न हुआ।
            उन्होंने सोचा—"पुत्र की प्राप्ति के लिए मैं अश्वमेध यज्ञ (वाजिमेधेन) का अनुष्ठान क्यों न करूँ?"
            प्राचीन काल में अश्वमेध यज्ञ केवल साम्राज्य विस्तार के लिए नहीं, बल्कि बड़े संकल्पों की पूर्ति और पापों की शुद्धि के लिए भी किया जाता था।
            दशरथ का यह विचार कोई साधारण सोच नहीं थी, बल्कि यह देवताओं की उस योजना का हिस्सा था जो राम को पृथ्वी पर लाना चाहती थी।
            एक राजा का यह कर्तव्य है कि वह अपने राज्य को सुरक्षित हाथों में सौंपे, और दशरथ इसी धर्म-संकट का समाधान खोज रहे थे।
            यज्ञ का विचार आते ही उनके संतापित मन में आशा की एक नई किरण फूट पड़ी, जो रामायण के अगले अध्याय की भूमिका है।
            'महात्मनः' शब्द यह बताता है कि उनका यह निर्णय निजी स्वार्थ से अधिक रघुकुल की महान परंपरा को बचाने के लिए था।
            अश्वमेध यज्ञ अत्यंत कठिन और खर्चीला अनुष्ठान था, जिसे संपन्न करने का साहस केवल एक चक्रवर्ती सम्राट ही कर सकता था।
            वाल्मीकि जी यहाँ दशरथ की उस 'कर्मण्यता' को दिखाते हैं जहाँ वे दुख में डूबने के बजाय एक आध्यात्मिक समाधान की ओर बढ़े।
            यह श्लोक सिद्ध करता है कि जब मनुष्य के सारे मानवीय प्रयास विफल हो जाते हैं, तो वह अंततः ईश्वर और यज्ञ की शरण में जाता है।
        """.trimIndent(),
        englishCommentary = """
            While continuously immersed in this deep anxiety, a highly noble and brilliant thought (Buddhi) arose in the mind of the great King.
            He pondered: "Why should I not perform the grand 'Ashvamedha Yajna' (Horse Sacrifice) specifically to obtain a worthy son?"
            In ancient times, the Ashvamedha was not merely for imperial expansion but also for fulfilling major vows and attaining spiritual purification.
            Dasharatha’s thought was no ordinary idea; it was a direct manifestation of the divine plan designed to bring Lord Rama to the earth.
            It is a monarch’s supreme duty to hand over his kingdom to safe hands, and Dasharatha was seeking a solution to this moral dilemma.
            The very thought of the Yajna sparked a new ray of hope in His agonized heart, setting the definitive stage for the next epic chapter.
            The word 'Mahatmanah' indicates that His decision was driven less by personal desire and more by the need to save the Solar lineage.
            The Ashvamedha was an incredibly rigorous and expensive ritual that only a true, undisputed universal emperor could dare to execute.
            Valmiki portrays Dasharatha’s 'action-oriented' nature here, where instead of wallowing in grief, He sought a grand spiritual solution.
            This verse proves that when all human efforts and resources fail, man ultimately seeks refuge in the Divine and in sacred rituals.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 22,
        sanskrit = "निश्चित्य मनसा राज्ञा मन्त्रिभिः सह मन्त्रितम् ।\nसुमन्त्रं च ततो राजा मन्त्रयामास सत्वरम् ॥ २२ ॥",
        hindiCommentary = """
            अपने मन में यह दृढ़ निश्चय करने के पश्चात, राजा दशरथ ने इस विषय पर अपने विश्वसनीय मंत्रियों के साथ गुप्त मंत्रणा (विचार-विमर्श) की।
            इसके बाद, राजा ने तुरंत (सत्वरम्) अपने प्रधान मंत्री और सारथी 'सुमन्त्र' को बुलाया और उनसे विशेष रूप से इस यज्ञ के बारे में चर्चा की।
            यह श्लोक दशरथ की लोकतांत्रिक कार्यप्रणाली को दर्शाता है; वे कोई भी बड़ा निर्णय अकेले नहीं, बल्कि मंत्रियों की सहमति से लेते थे।
            यज्ञ का विचार यद्यपि उनका अपना था, पर उसे अमलीजामा पहनाने के लिए राज्य के प्रमुख अधिकारियों का समर्थन अनिवार्य था।
            सुमन्त्र राजा के सबसे निकट थे, और वे केवल एक मंत्री नहीं, बल्कि दशरथ के मित्र और मार्गदर्शक भी थे।
            मन्त्रणा (Counsel) करना यह सिद्ध करता है कि अश्वमेध यज्ञ कोई छोटा आयोजन नहीं था; इसके लिए पूरे राष्ट्र की मशीनरी को जुटना था।
            'सत्वरम्' (शीघ्रता से) शब्द दशरथ की उस व्याकुलता और उत्साह को प्रकट करता है जो पुत्र-प्राप्ति के विचार मात्र से उनके भीतर जाग उठा था।
            वाल्मीकि जी ने यहाँ एक उत्तम शासक के 'डिसीजन-मेकिंग प्रोसेस' (निर्णय लेने की प्रक्रिया) का बहुत ही सटीक वर्णन किया है।
            मंत्रियों ने राजा के इस विचार का सहर्ष स्वागत किया होगा, क्योंकि वे स्वयं भी राज्य के भविष्य को लेकर चिंतित थे।
            यहीं से अयोध्या में उस महान यज्ञ की तैयारियाँ शुरू होती हैं जो पृथ्वी के इतिहास को हमेशा के लिए बदलने वाला था।
        """.trimIndent(),
        englishCommentary = """
            Having firmly resolved this in His mind, the King held a highly confidential counsel (Mantritam) with His trusted ministers regarding the matter.
            Thereafter, the King promptly (Satvaram) summoned His chief minister and charioteer, 'Sumantra,' to specifically discuss the execution of this Yajna.
            This verse highlights Dasharatha’s democratic functioning; He never took monumental decisions in isolation but sought His council's consent.
            Though the idea of the sacrifice was entirely His own, executing it required the absolute backing of the state’s highest administrative officers.
            Sumantra was the closest to the King, serving not merely as an official minister but as Dasharatha’s intimate friend and philosophical guide.
            Seeking 'Mantra' (Counsel) proves that the Ashvamedha was no small feat; it demanded the mobilization of the entire national machinery.
            The word 'Satvaram' (swiftly) reveals the intense eagerness and enthusiasm that the mere thought of getting a son had sparked within Him.
            Valmiki provides a very precise and accurate description of an ideal ruler's 'Decision-Making Process' in state affairs.
            The ministers undoubtedly welcomed the King’s proposal with joy, as they themselves were deeply concerned about the empire's heirless future.
            From this point onwards, the preparations begin in Ayodhya for that colossal sacrifice destined to alter the history of the earth forever.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 23,
        sanskrit = "शीघ्रमानय मे सर्वान् गुरून् पुरोहितांस्तथा ।\nइत्युक्त्वा स सुमन्त्रं तु राजा दशरथस्तदा ॥ २३ ॥",
        hindiCommentary = """
            राजा दशरथ ने सुमन्त्र को आदेश दिया—"शीघ्र जाओ और मेरे सभी गुरुओं तथा पुरोहितों को यहाँ सम्मानपूर्वक बुलाकर लाओ।"
            सुमन्त्र को यह आज्ञा देकर दशरथ आगे की रणनीति पर विचार करने लगे, क्योंकि यज्ञ गुरुओं के मार्गदर्शन के बिना संभव नहीं था।
            'शीघ्रमानय' (जल्दी लाओ) राजा की उस तीव्र इच्छा का प्रतीक है जो अब एक पल का भी विलंब सहन नहीं करना चाहती थी।
            गुरु और पुरोहित किसी भी धार्मिक अनुष्ठान की धुरी होते हैं, विशेषकर जब अनुष्ठान 'अश्वमेध' जैसा विशाल और जटिल हो।
            यह श्लोक दशरथ की धर्मनिष्ठा को दर्शाता है—उन्होंने सत्ता का प्रयोग करके यज्ञ शुरू नहीं किया, बल्कि पहले संतों का आश्रय लिया।
            सुमन्त्र, जो राजा के मन की बात को भली-भांति समझते थे, तुरंत इस पवित्र कार्य को पूरा करने के लिए निकल पड़े।
            राजदरबार में अब राजनीतिक चर्चाओं का स्थान धार्मिक और आध्यात्मिक मंत्रणाओं ने ले लिया था।
            वाल्मीकि जी ने यहाँ स्पष्ट किया है कि भारत की सनातन परंपरा में 'गुरु' का स्थान राजा से भी उच्च माना गया है।
            राजा दशरथ का यह कदम अयोध्या के लिए एक नए और स्वर्णिम अध्याय की शुरुआत का आधिकारिक शंखनाद था।
            पुरोहितों के आने के साथ ही उस यज्ञ की रूपरेखा तय होने वाली थी जिससे भगवान राम का अवतरण होना था।
        """.trimIndent(),
        englishCommentary = """
            King Dasharatha commanded Sumantra: "Go swiftly and respectfully bring all my Gurus and Royal Priests here to the court."
            Having issued this directive to Sumantra, King Dasharatha began contemplating the subsequent steps, as no Yajna is possible without spiritual guides.
            'Shighramanaya' (bring quickly) symbolizes the King's intense and burning desire that could no longer tolerate even a moment's delay.
            Gurus and priests are the absolute axis of any religious ritual, especially one as colossal, intricate, and demanding as the 'Ashvamedha.'
            This verse illustrates Dasharatha’s deep religious integrity—He did not initiate the sacrifice using sheer royal power but first sought the refuge of saints.
            Sumantra, who perfectly understood the innermost feelings of the King, immediately set out to execute this highly sacred task.
            The royal court’s atmosphere was now shifting from standard political discourses to profound religious and spiritual deliberations.
            Valmiki clarifies here that in the eternal Indian (Sanatan) tradition, the position of the 'Guru' is revered far above that of the Monarch.
            This decisive step by King Dasharatha was the official sounding of the conch shell for a new, golden chapter in Ayodhya’s destiny.
            With the arrival of the priests, the exact blueprint of that legendary sacrifice, which would bring Lord Rama to earth, was about to be finalized.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 24,
        sanskrit = "आमन्त्र्य तान् द्विजान् सर्वान् मानयित्वा च शास्त्रतः ।\nअब्रवीद् राजशार्दूलो वाक्यं वाक्यविशारदः ॥ २४ ॥",
        hindiCommentary = """
            उन सभी श्रेष्ठ ब्राह्मणों (द्विजान्) और ऋषियों को बुलाकर, राजा ने शास्त्रोक्त विधि से उनका सत्कार और सम्मान (मानयित्वा) किया।
            तत्पश्चात, राजाओं में श्रेष्ठ (राजशार्दूल) और वाणी के मर्मज्ञ (वाक्यविशारदः) दशरथ ने उनसे अत्यंत विनम्रतापूर्वक अपने मन की बात कही।
            'शास्त्रतः मानयित्वा' का अर्थ है कि अतिथियों का सत्कार मनमाने ढंग से नहीं, बल्कि वेदों में बताए गए कड़े नियमों के अनुसार किया गया।
            दशरथ का यह आचरण सिद्ध करता है कि एक महान सम्राट होते हुए भी ऋषियों के सामने उनमें रत्ती भर भी अहंकार नहीं था।
            'वाक्यविशारदः' विशेषण यह बताता है कि दशरथ अपनी बात को अत्यंत प्रभावपूर्ण, स्पष्ट और शिष्ट भाषा में प्रस्तुत करने में निपुण थे।
            उन्होंने ऋषियों को अपने दुख (पुत्रहीनता) और अपनी योजना (अश्वमेध यज्ञ) से अवगत कराने के लिए शब्दों का बहुत सावधानी से चयन किया।
            सभा में उपस्थित सभी मुनि राजा की इस गंभीरता और उनके शास्त्र-प्रेम को देखकर अत्यंत प्रसन्न और संतुष्ट हुए।
            यह श्लोक 'धर्म-सभा' के उस पावन वातावरण का वर्णन करता है जहाँ राष्ट्र के भविष्य का निर्णय आध्यात्मिक आधार पर हो रहा था।
            राजा का 'शार्दूल' (बाघ) की तरह होना उनकी शक्ति को, और ब्राह्मणों का सम्मान करना उनकी भक्ति को एक साथ प्रस्तुत करता है।
            यहीं से उस संवाद की शुरुआत होती है जो रामायण की कथा को एक 'वैयक्तिक' पीड़ा से 'ब्रह्मांडीय' घटना में बदल देता है।
        """.trimIndent(),
        englishCommentary = """
            Summoning all those pre-eminent Brahmins (Dvijas) and sages, the King honored and worshiped them strictly according to scriptural injunctions.
            Thereafter, Dasharatha, the tiger among kings (Rajashardulo) and a master of eloquent speech (Vakyavisharadah), spoke to them with utmost humility.
            'Shastratah Manayitva' implies that the hospitality was not arbitrary but meticulously adhered to the stringent rules prescribed in the Vedas.
            Dasharatha’s conduct proves that despite being a universal emperor, He harbored absolutely zero ego when standing before realized seers.
            The epithet 'Vakyavisharadah' indicates that Dasharatha was highly skilled in presenting His thoughts in an impactful, clear, and cultured manner.
            He selected His words with extreme care to inform the sages of His deep sorrow (heirlessness) and His proposed solution (the Ashvamedha).
            All the ascetics present in the assembly were deeply pleased and satisfied witnessing the King's gravity and His profound love for the Shastras.
            This verse describes the sacred atmosphere of a 'Dharma-Sabha' where the nation's future was being decided on a purely spiritual foundation.
            The King being like a 'Shardula' (tiger) represents His power, while His honoring of the Brahmins simultaneously showcases His deep devotion.
            This marks the start of the dialogue that transforms the epic from a tale of 'personal' agony into a grand 'cosmic' phenomenon.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 25,
        sanskrit = "मम लालप्यमानस्य सुतार्थं नास्ति वै सुखम् ।\nतदर्थं हयमेधेन यक्ष्यामीति मतिर्मम ॥ २५ ॥",
        hindiCommentary = """
            राजा दशरथ ने ऋषियों से कहा—"पुत्र प्राप्ति के लिए निरंतर विलाप और तड़प (लालप्यमानस्य) सहने के कारण मेरे जीवन में कोई सुख नहीं रह गया है।"
            "इसलिए, उस उद्देश्य (पुत्र) की प्राप्ति के लिए मेरी यह निश्चित मति (विचार) है कि मैं महान 'अश्वमेध यज्ञ' (हयमेधेन) का अनुष्ठान करूँ।"
            दशरथ ने बिना किसी संकोच के अपने हृदय की सबसे गहरी और कमजोर पीड़ा को ऋषियों के सामने खोलकर रख दिया।
            संसार का सबसे शक्तिशाली राजा यहाँ एक बेबस और दुखी पिता के रूप में खड़ा था, जो यह बताता है कि प्रकृति के नियम सबके लिए समान हैं।
            'नास्ति वै सुखम्' का अर्थ है कि राजमहल का वैभव, असीमित खजाना और विशाल सेना—ये सब एक संतान के बिना उन्हें व्यर्थ और शून्य लग रहे थे।
            उन्होंने यज्ञ का प्रस्ताव एक 'आदेश' के रूप में नहीं, बल्कि एक 'विचार' (मतिर्मम) के रूप में रखा, जिस पर उन्हें ऋषियों की स्वीकृति चाहिए थी।
            अश्वमेध यज्ञ को उन्होंने एक राजनीतिक उपकरण की बजाय अपनी आध्यात्मिक और व्यक्तिगत पीड़ा की औषधि के रूप में चुना।
            वाल्मीकि जी ने इस श्लोक में मानव मन की उस पीड़ा का बहुत ही सजीव चित्रण किया है जहाँ भौतिक सफलताएं आंतरिक शांति नहीं दे पातीं।
            ऋषिगण राजा की इस स्पष्टवादिता और उनके आर्त-भाव को देखकर अत्यंत करुणा से भर उठे और उनकी सहायता करने का निश्चय किया।
            यहीं से राम के अवतरण के लिए आवश्यक वह 'महा-यज्ञ' अपनी सैद्धांतिक स्वीकृति प्राप्त करता है।
        """.trimIndent(),
        englishCommentary = """
            King Dasharatha said to the sages: "Constantly lamenting and agonizing (Lalapyamanasya) for a son, there is absolutely no happiness left in my life."
            "Therefore, to achieve that very purpose (a son), it is my firm intention (Matirmama) to perform the grand 'Ashvamedha Yajna' (Horse Sacrifice)."
            Dasharatha laid bare the deepest and most vulnerable agony of His heart before the ascetics without any trace of royal hesitation.
            The world's most powerful monarch stood here as a helpless and grieving father, proving that the laws of nature are equal for everyone.
            'Nasti Vai Sukham' implies that the palace's opulence, limitless treasury, and vast armies felt utterly worthless and empty to Him without a child.
            He presented the proposal of the sacrifice not as a royal 'command' but as a 'thought' seeking the formal spiritual sanction of the sages.
            He chose the Ashvamedha not as a tool for political expansion, but as the ultimate spiritual remedy for His intense personal suffering.
            Valmiki vividly depicts the human condition here, where immense material success entirely fails to provide genuine internal peace.
            The seers, observing the King’s profound candor and His piteous state, were filled with deep compassion and resolved to assist Him.
            From this precise moment, the 'Maha-Yajna' required for the divine descent of Lord Rama receives its formal theoretical approval.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 26,
        sanskrit = "तथैव मे भवेत् कामः सर्वथा मुनिपुङ्गवाः ।\nतथानुध्यायतन्मां वै सर्वे सम्भूय यत्नतः ॥ २६ ॥",
        hindiCommentary = """
            दशरथ ने निवेदन किया—"हे मुनिश्रेष्ठों! जिस प्रकार मेरी यह मनोकामना (कामः) पूर्ण हो सके, आप सब मिलकर वैसा ही प्रयास करें।"
            "आप सभी मुनिगण एक साथ (सम्भूय) यत्नपूर्वक मुझ पर कृपा करें और ऐसा अनुध्यान (विचार/योजना) करें जिससे यह यज्ञ सफल हो।"
            राजा ने स्पष्ट कर दिया कि धन और बल उनके पास है, पर इस यज्ञ की सफलता पूरी तरह से ब्राह्मणों के ज्ञान और उनके तप पर निर्भर है।
            'सर्वथा' का अर्थ है कि हर संभव तरीके से इस अनुष्ठान को निर्विघ्न संपन्न कराना अब इन ऋषियों का ही उत्तरदायित्व है।
            दशरथ का यह समर्पण यह सिखाता है कि जब लक्ष्य ईश्वरीय हो, तो मनुष्य को अपना अहंकार छोड़कर संतों की शरण में जाना चाहिए।
            'सम्भूय' (मिलकर) शब्द दर्शाता है कि दशरथ एक सामूहिक और संगठित आध्यात्मिक प्रयास चाहते थे, किसी एक व्यक्ति का चमत्कार नहीं।
            मुनियों के आशीर्वाद और उनके मंत्र-बल से ही अश्वमेध यज्ञ जैसा कठिन कार्य अपनी पूर्णता तक पहुँच सकता था।
            वाल्मीकि जी ने इस श्लोक में राजा की आर्त पुकार और उनके अगाध विश्वास का बहुत ही भावपूर्ण चित्रण किया है।
            ऋषियों ने राजा के इस आर्त भाव को समझा और उन्हें आश्वस्त किया कि उनका यह यज्ञ अवश्य ही सफल और फलदायी होगा।
            यह श्लोक उस सहकारिता (Cooperation) को दिखाता है जो प्राचीन भारत में राजसत्ता और धर्मसत्ता के बीच मौजूद थी।
        """.trimIndent(),
        englishCommentary = """
            Dasharatha pleaded: "O Best of Sages! Please make concerted efforts so that this deep desire (Kamah) of mine may be fulfilled in every way."
            "May all of you collectively (Sambhūya) bestow your grace upon me and carefully devise a strategy (Anudhyayatan) to ensure the success of this sacrifice."
            The King made it clear that while He possessed the wealth and power, the success of this Yajna depended entirely on the Brahmins' wisdom and penance.
            'Sarvatha' implies that ensuring the flawless and obstacle-free completion of this ritual through every possible means was now the sages' responsibility.
            Dasharatha’s total surrender teaches that when the goal is divine, a person must abandon ego and seek absolute refuge at the feet of holy men.
            The word 'Sambhūya' (together) shows that Dasharatha sought a collective and highly organized spiritual effort, not just an individual miracle.
            Only through the collective blessings and the potent mantra-power of the seers could a rigorous task like the Ashvamedha reach its absolute completion.
            Valmiki poignantly portrays the King’s desperate, piteous cry and His unfathomable faith in the spiritual community in this verse.
            The sages understood the King’s distressed state and assured Him that His monumental sacrifice would undoubtedly be successful and fruitful.
            This verse beautifully illustrates the profound cooperation that existed between temporal 'State Power' and spiritual 'Dharma Power' in ancient India.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 27,
        sanskrit = "तस्य तद्वचनं श्रुत्वा ब्राह्मणास्ते सवसिष्ठकाः ।\nसाधु साध्विति तं वाक्यं राजानमभिनन्द्य च ॥ २७ ॥",
        hindiCommentary = """
            राजा दशरथ के उन विनम्र और आर्त वचनों को सुनकर, महर्षि वसिष्ठ सहित वहाँ उपस्थित सभी ब्राह्मण अत्यंत प्रसन्न हुए।
            उन्होंने राजा के इस श्रेष्ठ विचार की भूरि-भूरि प्रशंसा की और "साधु! साधु!" (बहुत उत्तम!) कहते हुए राजा का अभिनंदन (स्वागत) किया।
            ब्राह्मणों की यह प्रसन्नता इसलिए थी क्योंकि अश्वमेध यज्ञ केवल राजा का नहीं, बल्कि संपूर्ण विश्व के कल्याण का एक महान अनुष्ठान था।
            'साधु साधु' का उच्चारण उस युग में किसी भी पवित्र और महान संकल्प को दी जाने वाली सर्वोच्च ईश्वरीय और सामाजिक स्वीकृति थी।
            वसिष्ठ जी का नेतृत्व इस बात की गारंटी था कि यह यज्ञ किसी भी शास्त्र-विरुद्ध त्रुटि का शिकार नहीं होगा।
            ऋषियों ने अनुभव किया कि दशरथ का यह संकल्प केवल एक पुत्र की कामना नहीं, बल्कि साक्षात् भगवान को धरती पर बुलाने की पुकार है।
            उन्होंने राजा को आश्वस्त किया कि उनका यह धर्ममय संकल्प अवश्य ही पूर्ण होगा और उनके घर एक तेजस्वी उत्तराधिकारी का जन्म होगा।
            वाल्मीकि जी यहाँ उस 'सकारात्मक ऊर्जा' का वर्णन कर रहे हैं जो एक शुभ विचार के प्रकट होने पर पूरी सभा में फैल गई थी।
            राजा और ऋषियों के बीच का यह संवाद यह सिद्ध करता है कि अयोध्या में 'धर्म' का शासन कितना जीवंत और पारदर्शी था।
            इस श्लोक के साथ यज्ञ की सैद्धांतिक प्रक्रिया समाप्त होती है और अब उसकी व्यावहारिक तैयारियों का समय शुरू होता है।
        """.trimIndent(),
        englishCommentary = """
            Upon hearing those humble and distressed words of King Dasharatha, all the Brahmins present, led by Sage Vashistha, were exceedingly pleased.
            They profusely praised the King's noble thought and warmly congratulated (Abhinandya) Him, loudly exclaiming "Sadhu! Sadhu!" (Excellent! Most Noble!).
            The joy of the Brahmins stemmed from the fact that the Ashvamedha Yajna was not just for the King, but a grand ritual for universal welfare.
            The exclamation 'Sadhu! Sadhu!' was the highest form of divine and social validation granted to any sacred and monumental resolve in that era.
            Sage Vashistha’s leadership served as an absolute guarantee that this sacrifice would not suffer from any scriptural or procedural errors.
            The seers intuitively felt that Dasharatha’s resolve was not merely a desire for a son, but a desperate cosmic call inviting the Supreme Lord to earth.
            They assured the King that His righteous vow would undoubtedly be fulfilled, and a highly radiant heir would surely be born in His illustrious house.
            Valmiki describes the surge of 'Positive Energy' that instantly permeated the entire assembly upon the declaration of such an auspicious thought.
            This profound dialogue between the King and the sages proves how incredibly vibrant and transparent the rule of 'Dharma' was in Ayodhya.
            With this verse, the theoretical and consultative phase of the Yajna concludes, paving the way for the commencement of its practical preparations.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 28,
        sanskrit = "ऊचुश्च परमप्रीता वसिष्ठप्रमुखा द्विजाः ।\nसम्भारान् सम्भरस्वाद्य यज्ञायाश्वं विमुञ्च च ॥ २८ ॥\nइति वाल्मीकिरामायणे बालकाण्डे षष्ठः सर्गः ॥",
        hindiCommentary = """
            वसिष्ठ आदि सभी प्रमुख ब्राह्मणों ने अत्यंत प्रसन्न (परमप्रीता) होकर राजा दशरथ से कहा—
            "हे राजन्! अब आप आज ही से यज्ञ के लिए आवश्यक सामग्रियों (सम्भारान्) को एकत्र करना शुरू करें और यज्ञ के अश्व (घोड़े) को स्वतंत्र छोड़ दें।"
            यह आदेश उस महान 'अश्वमेध यज्ञ' की औपचारिक और क्रियात्मक (Practical) शुरुआत का शंखनाद था।
            सामग्री एकत्र करने का अर्थ है—यज्ञ मंडप का निर्माण, आहुतियों का प्रबंध और अतिथियों के लिए भव्य व्यवस्था करना।
            अश्व को छोड़ना यह घोषित करता था कि राजा ने अपना संकल्प ले लिया है और अब पीछे हटने का कोई मार्ग नहीं है।
            ऋषियों की इस आज्ञा ने राजा दशरथ के मन के सारे संशयों को मिटाकर उन्हें एक नई और असीम ऊर्जा से भर दिया।
            वाल्मीकि जी ने इस श्लोक में उस ऐतिहासिक क्षण को कैद किया है जहाँ से रामायण की कथा ने अपनी असली गति पकड़ी।
            यही वह यज्ञ था जिसने आगे चलकर ऋष्यशृंग मुनि के आगमन और भगवान राम के अवतरण का मार्ग प्रशस्त किया।
            इस प्रकार, वाल्मीकि रामायण के बालकाण्ड का यह छठा सर्ग, जो अयोध्या के प्रशासन और यज्ञ के संकल्प से जुड़ा था, यहाँ पूर्ण होता है।
            यह सर्ग हमें एक आदर्श राज्य और एक राजा की ईश्वरीय योजना के प्रति समर्पण का अत्यंत सुंदर पाठ पढ़ाता है।
            ॥ छठा सर्ग सम्पूर्ण हुआ। जय श्री राम ॥
        """.trimIndent(),
        englishCommentary = """
            Being supremely pleased (Paramaprita), all the leading Brahmins, headed by Sage Vashistha, declared to King Dasharatha:
            "O King! Begin collecting all the necessary materials (Sambharan) for the sacrifice from this very day, and release the sacrificial Horse."
            This explicit command was the official sounding of the conch, marking the practical and active commencement of the grand 'Ashvamedha Yajna.'
            Collecting materials implied the massive task of constructing the sacrificial altar, arranging oblations, and organizing grand logistics for global guests.
            Releasing the horse formally proclaimed to the world that the King had taken His vow, and there was absolutely no turning back from this holy endeavor.
            This direct instruction from the sages completely eradicated all lingering doubts in Dasharatha’s mind, filling Him with a new, boundless energy.
            In this verse, Valmiki has perfectly captured the historic moment from which the core narrative of the Ramayana gains its true momentum.
            It was this very sacrifice that subsequently paved the way for the arrival of Sage Rishyashringa and the divine incarnation of Lord Rama.
            Thus, the sixth Sarga of the Baal Kand in the Valmiki Ramayana, dealing with Ayodhya's administration and the vow of sacrifice, reaches its completion here.
            This chapter teaches us a profoundly beautiful lesson about an ideal state and a Monarch's absolute surrender to the greater cosmic divine plan.
            || Thus ends the Sixth Sarga. Jai Shri Ram ||
        """.trimIndent()
    ),

)