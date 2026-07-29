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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SargaEight() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaEightData
        } else {
            sargaEightData.filter {
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
                        Text("अष्टम सर्ग - सुमन्त्र की मंत्रणा", fontWeight = FontWeight.ExtraBold)
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
                    placeholder = { Text("श्लोक संख्या या शब्द खोजें...") },
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

val sargaEightData = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "सुमन्त्रस्तु वचः श्रुत्वा राज्ञो दशरथस्य तत् ।\nउवाच रहसि राजानं सान्त्वयन्निदमब्रवीत् ॥ १ ॥",
        hindiCommentary = """
            राजा दशरथ के उन शोकाकुल और दृढ़ वचनों (अश्वमेध यज्ञ करने के संकल्प) को सुनकर, अमात्य सुमन्त्र ने राजा से एकांत (रहसि) में भेंट की।
            उन्होंने राजा को सांत्वना (सान्त्वयन्) देते हुए और उनके दुख को दूर करने के उद्देश्य से यह अत्यंत रहस्यमयी और महत्वपूर्ण बात कही।
            सुमन्त्र केवल एक सारथी नहीं थे, बल्कि वे दशरथ के सबसे विश्वस्त मित्र और प्राचीन इतिहास व भविष्यवाणियों के बहुत बड़े ज्ञाता थे।
            'रहसि' (एकांत में) बात करना यह दर्शाता है कि सुमन्त्र जो बताने जा रहे थे, वह कोई सामान्य सूचना नहीं, बल्कि राज्य का एक अत्यंत गुप्त और ईश्वरीय रहस्य था।
            राजा दशरथ पुत्रहीनता के कारण गहरे संताप में थे; एक अच्छे मंत्री का कार्य केवल आज्ञा का पालन करना नहीं, बल्कि राजा के मानसिक संताप को हरना भी होता है।
            सुमन्त्र ने राजा को यह अनुभव कराया कि उनका यह दुख व्यर्थ नहीं है, बल्कि यह एक बहुत बड़ी ब्रह्मांडीय योजना (Cosmic Plan) का हिस्सा है।
            वाल्मीकि जी ने इस श्लोक में सुमन्त्र के उस मंत्री-धर्म को उजागर किया है जहाँ वे राजा को एक सही दिशा और उम्मीद की किरण (Ray of hope) दिखा रहे हैं।
            यह संवाद रामायण के उस मोड़ का प्रतीक है जहाँ मानवीय प्रयास (यज्ञ का संकल्प) ईश्वरीय नियति (भविष्यवाणी) के साथ जुड़ने वाला था।
            मंत्रियों की सभा में जो बात नहीं कही जा सकती थी, उसे सुमन्त्र ने राजा के परम हितैषी के रूप में अकेले में कहना उचित समझा।
            यहाँ से 'ऋष्यशृंग मुनि' के उस पावन आख्यान की भूमिका बनती है जो भगवान राम के अवतरण का सबसे प्रमुख माध्यम बनेंगे।
        """.trimIndent(),
        englishCommentary = """
            Having heard those grief-stricken yet resolute words of King Dasharatha regarding the Ashvamedha Yajna, Minister Sumantra met the King in absolute privacy (Rahasi).
            Consoling the King (Santvayan) and aiming to completely eradicate His deep sorrow, Sumantra spoke these highly profound and secretive words.
            Sumantra was not merely a royal charioteer; he was Dasharatha’s most trusted confidant and a grand scholar of ancient history and divine prophecies.
            Speaking in 'Rahasi' (solitude) indicates that the information Sumantra was about to divulge was not ordinary news, but a highly classified, divine state secret.
            King Dasharatha was engulfed in severe agony due to his heirlessness; a true minister's duty is not just to obey commands, but to heal the Monarch's mental torment.
            Sumantra made the King realize that His profound suffering was not meaningless, but an integral part of a massive, pre-ordained Cosmic Plan.
            Valmiki highlights Sumantra’s exceptional ministerial ethics in this verse, showing him actively providing the King with correct direction and a brilliant ray of hope.
            This intimate dialogue marks the crucial juncture in the Ramayana where human effort (the vow of sacrifice) is about to intertwine seamlessly with divine destiny (prophecy).
            What could not be openly discussed in the general assembly of ministers, Sumantra deemed appropriate to share in private as the King's ultimate well-wisher.
            From this precise moment begins the foundational narrative of 'Sage Rishyashringa,' who would serve as the primary catalyst for the divine descent of Lord Rama.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 2,
        sanskrit = "ऋत्विग्भिरुपदिष्टोऽयं यः पूर्वं श्रूयते मया ।\nसनत्कुमारो भगवान् पूर्वं कथितवान् कथाम् ॥ २ ॥",
        hindiCommentary = """
            सुमन्त्र ने कहा—"हे राजन्! ऋत्विजों (पुरोहितों) ने आपको जो अश्वमेध यज्ञ का उपदेश दिया है, उसके संदर्भ में मैंने पूर्व काल में एक अत्यंत गूढ़ बात सुनी है।"
            "प्राचीन काल में, साक्षात् भगवान सनत्कुमार (ब्रह्मा के मानस पुत्र) ने ऋषियों की एक सभा में इस विषय पर एक अत्यंत रहस्यमयी कथा (भविष्यवाणी) कही थी।"
            सुमन्त्र अपनी बात का आधार किसी सामान्य अफवाह को नहीं, बल्कि साक्षात् 'सनत्कुमार' जैसे सिद्ध और त्रिकालदर्शी ऋषि की वाणी को बना रहे थे।
            सनत्कुमार वे हैं जो सदैव बाल-रूप में रहते हैं और जिनकी दृष्टि भूत, वर्तमान और भविष्य तीनों कालों को एक समान स्पष्टता से देखती है।
            यह श्लोक प्रमाणित करता है कि राम का जन्म कोई अचानक हुई घटना नहीं थी; इसकी पटकथा (Script) देवताओं द्वारा युगों पहले ही लिखी जा चुकी थी।
            सुमन्त्र का यह कहना कि 'मैंने यह सुना है' (श्रूयते मया), यह बताता है कि अयोध्या के दरबार में प्राचीन ऋषियों के ज्ञान को सुरक्षित रखने की एक समृद्ध 'श्रुति-परंपरा' थी।
            दशरथ का यज्ञ का विचार और सनत्कुमार की भविष्यवाणी का आपस में मिलना यह सिद्ध करता है कि ईश्वर जब कार्य करना चाहता है, तो सारी परिस्थितियां स्वतः अनुकूल हो जाती हैं।
            वाल्मीकि जी इस श्लोक के माध्यम से रामायण की कथा को एक 'लौकिक इतिहास' से उठाकर 'अलौकिक लीला' के स्तर पर स्थापित कर देते हैं।
            राजा दशरथ के मन में यह सुनकर एक अपार जिज्ञासा और शांति उत्पन्न हुई कि स्वयं भगवान सनत्कुमार ने उनके भविष्य के बारे में कुछ कहा है।
            यह एक मंत्री की वह बुद्धिमत्ता है जो राजा को केवल सलाह नहीं देता, बल्कि उस सलाह को प्राचीन सत्य के साथ जोड़कर राजा का विश्वास पक्का करता है।
        """.trimIndent(),
        englishCommentary = """
            Sumantra said: "O King! In the context of the Ashvamedha Yajna advised to you by the royal priests, I have previously heard a deeply profound truth."
            "In ancient times, the divine Lord Sanatkumara (the mind-born son of Brahma) himself narrated a highly secretive and prophetic story regarding this very matter."
            Sumantra bases his counsel not on mere rumors, but on the infallible words of 'Sanatkumara,' a perfected sage possessing absolute clairvoyant vision (Trikaldarshi).
            Sanatkumara is the eternal youth whose piercing spiritual vision perceives the past, present, and future with identical, flawless clarity.
            This verse proves that Rama's birth was not an accidental occurrence; its grand script had been written by the celestial gods eons in advance.
            Sumantra stating 'I have heard this' (Shruyate maya) demonstrates that the court of Ayodhya maintained a rich 'Shruti-tradition' of actively preserving ancient spiritual wisdom.
            The perfect convergence of Dasharatha’s sudden resolve for the sacrifice and Sanatkumara’s ancient prophecy proves that when the Divine wills it, all circumstances automatically align.
            Through this verse, Valmiki elevates the narrative of the Ramayana from a mere 'worldly history' to the majestic level of a 'Transcendental Divine Play' (Alaukik Leela).
            Hearing that Lord Sanatkumara himself had prophesied about His future, a wave of immense curiosity and profound peace washed over King Dasharatha's heart.
            This showcases the true brilliance of a minister—he does not just offer raw advice, but anchors that advice in ancient truth, thereby completely solidifying the King's faith.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 3,
        sanskrit = "सन्तानार्थं त्वया राजन् भविष्यति सुधार्मिकः ।\nकाश्यपस्य तु पुत्रोऽस्ति विभाण्डक इति श्रुतः ॥ ३ ॥",
        hindiCommentary = """
            सुमन्त्र ने सनत्कुमार की भविष्यवाणी सुनाते हुए कहा—"हे राजन्! भगवान सनत्कुमार ने कहा था कि आपके घर संतान-प्राप्ति के लिए एक अत्यंत धर्मात्मा मुनि कारण बनेंगे।"
            "वे मुनि महर्षि कश्यप के वंशज होंगे, जिनका नाम 'विभाण्डक' है, और वे अपनी महान तपस्या के लिए तीनों लोकों में विख्यात (श्रुतः) होंगे।"
            यह श्लोक उस मुख्य पात्र (ऋष्यशृंग) की वंशावली का परिचय देता है जो दशरथ के जीवन के सबसे बड़े अंधकार (पुत्रहीनता) को दूर करने वाला था।
            विभाण्डक ऋषि महर्षि कश्यप के गोत्र के थे, जो प्रजापतियों में गिने जाते हैं; अतः उनका वंश अत्यंत पवित्र और तपोनिष्ठ था।
            'सुधार्मिकः' का अर्थ है कि वह मुनि केवल कर्मकांडी नहीं होंगे, बल्कि साक्षात् धर्म के स्वरूप होंगे, जिनके स्पर्श मात्र से यज्ञ सफल हो जाएगा।
            सुमन्त्र राजा को यह समझा रहे थे कि पुत्रेष्टि यज्ञ कोई साधारण पुरोहित नहीं कर सकता; इसके लिए एक विशेष रूप से पवित्र और निष्पाप आत्मा की आवश्यकता है।
            यह भविष्यवाणी सिद्ध करती है कि देवताओं ने दशरथ की सहायता के लिए बहुत पहले से ही एक मुनि की तपस्या को तैयार कर रखा था।
            वाल्मीकि जी यहाँ बता रहे हैं कि संसार की हर महान घटना के पीछे तपस्वियों का अदृश्य योगदान होता है, जो मौन रहकर विश्व का कल्याण करते हैं।
            दशरथ के लिए यह जानकारी एक संजीवनी के समान थी, क्योंकि अब उन्हें अपनी समस्या का एक सुनिश्चित और ईश्वरीय समाधान मिल गया था।
            विभाण्डक ऋषि का नाम सुनकर ही राजा के मन में उस महान तपोबल के प्रति गहरी श्रद्धा उत्पन्न हो गई।
        """.trimIndent(),
        englishCommentary = """
            Narrating Sanatkumara’s prophecy, Sumantra said: "O King! Lord Sanatkumara foretold that a supremely righteous sage would become the direct cause for you to obtain progeny."
            "That sage will be the descendant of Maharishi Kashyapa, renowned across the three worlds by the name 'Vibhandaka' for his severe penance."
            This verse introduces the pristine lineage of the core character (Rishyashringa) who was destined to eradicate the greatest darkness (heirlessness) of Dasharatha’s life.
            Sage Vibhandaka belonged to the Gotra of Kashyapa, a Prajapati; thus, his bloodline was exceptionally holy, pure, and deeply rooted in severe asceticism.
            'Sudharmikah' implies that the sage would not merely be a ritualistic priest, but the living embodiment of Dharma, whose mere touch would guarantee the Yajna's success.
            Sumantra was subtly explaining to the King that an ordinary priest could not perform the Putreshti Yajna; it mandated a specifically sinless, perfectly pure soul.
            This prophecy proves that the celestial gods had meticulously prepared a sage's penance ages in advance exclusively to aid King Dasharatha in his time of need.
            Valmiki highlights here that behind every monumental event in the world lies the invisible contribution of severe ascetics, who silently orchestrate global welfare.
            For Dasharatha, this information acted as the ultimate life-saving nectar (Sanjeevani), as He finally saw a definite, divinely orchestrated solution to His deepest misery.
            Merely hearing the venerable name of Sage Vibhandaka instantly evoked a profound sense of reverence in the King's heart toward that immense power of penance.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 4,
        sanskrit = "ऋष्यशृङ्ग इति ख्यातस्तस्य पुत्रो भविष्यति ।\nस वने नित्यसंवृद्धो मुनिर्वनेचरः सदा ॥ ४ ॥",
        hindiCommentary = """
            सुमन्त्र ने आगे कहा—"उन महर्षि विभाण्डक के एक पुत्र उत्पन्न होंगे, जो संसार में 'ऋष्यशृंग' के नाम से विख्यात होंगे।"
            "वे ऋष्यशृंग जन्म से ही सदा वन में निवास करने वाले (वनेचरः) होंगे, और उनका संपूर्ण पालन-पोषण तथा विकास (नित्यसंवृद्धो) केवल वन में ही होगा।"
            'ऋष्यशृंग' का शाब्दिक अर्थ है—जिनके सिर पर मृग (हिरण) के समान सींग हो; यह उनके अद्भुत जन्म और उनकी शारीरिक विशिष्टता को दर्शाता है।
            वन में ही संवृद्ध होने का तात्पर्य यह है कि उन्होंने जन्म से लेकर युवावस्था तक कभी किसी नगर, स्त्री या सांसारिक मायाजाल को देखा ही नहीं होगा।
            वे पूरी तरह से प्रकृति की गोद में, केवल अपने पिता के सान्निध्य में रहकर पले-बढ़े होंगे, जिससे उनका मन एक नवजात शिशु के समान बिल्कुल निष्पाप होगा।
            वाल्मीकि जी यहाँ ऋष्यशृंग की उस 'पूर्ण पवित्रता' (Absolute Purity) का वर्णन कर रहे हैं जो दशरथ के यज्ञ के लिए सबसे अनिवार्य शर्त थी।
            जिस व्यक्ति ने कभी संसार के विषय-भोगों को देखा ही न हो, उसके भीतर काम, क्रोध या लोभ का कोई बीज ही नहीं पनप सकता।
            ऐसे विशुद्ध ब्रह्मचारी के हाथों से दी गई आहुति को देवता सीधे स्वीकार करते हैं, और यही ऋष्यशृंग की सबसे बड़ी और अद्वितीय शक्ति थी।
            दशरथ ध्यानपूर्वक सुन रहे थे कि कैसे नियति ने उनके पुत्रों के जन्म के लिए एक ऐसे तपस्वी को तैयार किया है जो दुनिया की नजरों से पूरी तरह दूर है।
            यह श्लोक भौतिकता से दूर, विशुद्ध प्राकृतिक और आध्यात्मिक जीवन के महत्व को अत्यंत सुंदरता से स्थापित करता है।
        """.trimIndent(),
        englishCommentary = """
            Sumantra continued: "That great Maharishi Vibhandaka will have a son, who will become famously known throughout the world as 'Rishyashringa.'"
            "Rishyashringa will be a perpetual forest-dweller (Vanecharah), and his entire upbringing and evolution (Nityasamvriddho) will occur exclusively within the deep, isolated forests."
            The name 'Rishyashringa' literally translates to 'one who possesses the horn of a deer on his head,' signifying his miraculous birth and unique physical characteristic.
            Growing up entirely in the forest implies that from birth to youth, he would never have seen a city, a woman, or the deceptive illusions of the materialistic world.
            Reared entirely in the lap of untouched nature and solely in the company of his ascetic father, his mind would remain as absolutely sinless and pure as a newborn child's.
            Valmiki is describing the 'Absolute Purity' of Rishyashringa here, which was the most mandatory and non-negotiable prerequisite for the success of Dasharatha's sacrifice.
            A person who has never even witnessed worldly sensual pleasures cannot possibly harbor the seeds of lust, anger, or greed within his consciousness.
            Oblations offered by the hands of such an unblemished, perfect Brahmachari are instantly accepted by the Gods; this was Rishyashringa's greatest and most unique spiritual power.
            Dasharatha listened intently, amazed at how destiny had meticulously nurtured a secluded ascetic, far from the eyes of the world, specifically to facilitate the birth of His sons.
            This verse beautifully establishes the supreme spiritual value of an absolutely natural, ascetic life, completely untouched and uncorrupted by materialistic society.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 5,
        sanskrit = "नान्यां जानाति विप्रेन्द्रो नित्यं पित्रनुवर्तनात् ।\nतस्यैवं वर्तमानस्य कालः कश्चिद् गमिष्यति ॥ ५ ॥",
        hindiCommentary = """
            सुमन्त्र ने बताया—"वे ब्राह्मणों में श्रेष्ठ (विप्रेन्द्रो) ऋष्यशृंग अपने पिता महर्षि विभाण्डक का इतना कठोरता से अनुसरण (पित्रनुवर्तनात्) करेंगे कि वे संसार में किसी अन्य वस्तु या व्यक्ति को जानेंगे ही नहीं।"
            "इस प्रकार निरंतर अपने पिता की सेवा और घोर तपस्या में जीवन व्यतीत करते हुए (वर्तमानस्य) उनका बहुत सारा समय (कालः) बीत जाएगा।"
            'पित्रनुवर्तनात्' का अर्थ है कि उनके लिए उनके पिता ही उनकी पूरी दुनिया, उनके गुरु और उनके ईश्वर होंगे; उनके मन में कोई दूसरी जिज्ञासा ही नहीं होगी।
            वे इतने निष्पाप होंगे कि उन्हें स्त्री और पुरुष का भेद तक ज्ञात नहीं होगा; उनकी चेतना पूरी तरह से ब्रह्म में लीन होगी।
            'विप्रेन्द्रो' विशेषण यह सिद्ध करता है कि वे केवल एक अज्ञानी वनवासी नहीं थे, बल्कि वेदों के सर्वोच्च ज्ञाता और ब्राह्मणों में सबसे श्रेष्ठ थे।
            वाल्मीकि जी यहाँ 'ब्रह्मचर्य' (Brahmacharya) की उस चरम अवस्था का वर्णन कर रहे हैं जहाँ मन में संकल्प-विकल्प उठना ही बंद हो जाते हैं।
            यह श्लोक ऋष्यशृंग के उस मानसिक एकांत (Mental Isolation) को दर्शाता है जिसने उनके भीतर असीम आध्यात्मिक ऊर्जा (Spiritual Energy) का संचय कर दिया था।
            जब कोई मनुष्य बाहरी दुनिया से पूरी तरह कटकर केवल सत्य पर ध्यान केंद्रित करता है, तो प्रकृति स्वयं उसकी आज्ञा मानने लगती है।
            राजा दशरथ को यह अहसास हो रहा था कि ऐसे सिद्ध संत को अयोध्या लाना कोई आसान कार्य नहीं होगा, क्योंकि वे मोह-माया से पूरी तरह परे हैं।
            समय का इस प्रकार बीत जाना (कालः कश्चिद् गमिष्यति) यह बताता है कि उनकी तपस्या लंबी और अत्यंत सघन थी, जिसने उन्हें यज्ञ का अधिकारी बनाया।
        """.trimIndent(),
        englishCommentary = """
            Sumantra explained: "That foremost among Brahmins (Viprendro), Rishyashringa, will follow his father so strictly (Pitranuvartanat) that he will know absolutely nothing and no one else in the world."
            "Existing in this exact manner (Vartamanasya)—constantly serving his father and immersed in severe penance—a significant amount of time (Kalah) will pass."
            'Pitranuvartanat' implies that his father would constitute his entire universe, his Guru, and his God; he would harbor absolutely no curiosity about the outside world.
            He would be so immensely sinless and innocent that he wouldn't even know the biological difference between a man and a woman; his consciousness would be entirely absorbed in the Supreme Brahman.
            The epithet 'Viprendro' proves that he was not merely an ignorant forest-dweller, but the supreme knower of the Vedas and the most elevated among all Brahmins.
            Valmiki describes the absolute zenith of 'Brahmacharya' (celibacy/purity) here, a state where the mind completely ceases to generate worldly desires or dualistic thoughts.
            This verse illustrates the extreme 'Mental Isolation' of Rishyashringa, which had allowed him to accumulate an unfathomable, infinite reservoir of Spiritual Energy.
            When a human being completely disconnects from the external world and focuses solely on the Absolute Truth, nature herself begins to obey his commands.
            King Dasharatha was slowly realizing that bringing such a perfected, detached saint to the bustling city of Ayodhya would be no easy feat, as he was totally beyond worldly illusions.
            The passing of time in this manner indicates that his penance was incredibly long and intensely dense, rendering him the sole, ultimate authority capable of performing the royal sacrifice.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 6,
        sanskrit = "अग्निहोत्रं च शुश्रूषां पितुश्चैव महात्मनः ।\nएतस्मिन्नेव काले तु रोमपादः प्रतापवान् ॥ ६ ॥",
        hindiCommentary = """
            "वे युवा ऋष्यशृंग केवल दो ही कार्य करेंगे—निरंतर 'अग्निहोत्र' (यज्ञ) करना और अपने महात्मा पिता की दिन-रात सेवा (शुश्रूषां) करना।"
            "ठीक उसी कालखंड में (एतस्मिन्नेव काले तु), अंग देश में 'रोमपाद' नाम के एक अत्यंत प्रतापी और शक्तिशाली राजा शासन कर रहे होंगे।"
            यह श्लोक कथा में एक नए और अत्यंत महत्वपूर्ण पात्र 'राजा रोमपाद' (जो दशरथ के मित्र थे) का प्रवेश कराता है।
            ऋष्यशृंग का जीवन अग्निहोत्र और पिता की सेवा तक सीमित था; ये दोनों कार्य भारतीय संस्कृति में सर्वोच्च धर्म माने गए हैं।
            अग्निहोत्र से पर्यावरण और आत्मा की शुद्धि होती है, और माता-पिता की सेवा से साक्षात् ईश्वर प्रसन्न होते हैं; ऋष्यशृंग इन दोनों में पूर्ण थे।
            'रोमपादः प्रतापवान्' कहकर वाल्मीकि जी यह संकेत दे रहे हैं कि अंग देश का राजा भी बहुत शक्तिशाली था, परंतु प्रकृति के प्रकोप के आगे राजा का प्रताप भी काम नहीं आता।
            कथा का यह मोड़ (Turning Point) दो बिल्कुल विपरीत दुनियाओं को जोड़ता है—एक ओर शांत, निष्काम तपोवन और दूसरी ओर एक प्रतापी राजा का संकटग्रस्त राज्य।
            सुमन्त्र राजा दशरथ को बता रहे थे कि ऋष्यशृंग का अयोध्या से जुड़ना सीधा नहीं होगा, बल्कि इसके पीछे रोमपाद के राज्य की एक बड़ी घटना निमित्त बनेगी।
            भगवान की योजना कितनी अद्भुत होती है कि एक राज्य का संकट (अंग देश का सूखा) दूसरे राज्य के कल्याण (राम का जन्म) का मार्ग प्रशस्त करता है।
            यहाँ से कथा उस भयंकर अकाल की ओर बढ़ती है जिसने रोमपाद को महर्षि ऋष्यशृंग की शरण में जाने के लिए विवश कर दिया।
        """.trimIndent(),
        englishCommentary = """
            "The youthful Rishyashringa will perform only two constant duties: tending to the perpetual 'Agnihotra' (fire-sacrifice) and offering tireless service (Shushrusham) to his high-souled father."
            "During that exact same period of time (Etasminneva kale tu), a highly valorous and powerful king named 'Romapada' will be ruling over the Kingdom of Anga."
            This verse formally introduces a new and highly crucial character into the narrative—'King Romapada' (who was a close friend of King Dasharatha).
            Rishyashringa’s entire life was confined to the Agnihotra and serving his father; these two specific actions are considered the absolute highest Dharma in ancient Indian culture.
            The Agnihotra purifies both the environment and the soul, while serving one's parents pleases the Supreme Lord directly; Rishyashringa was utterly perfect in both.
            By describing Romapada as 'Pratapavan' (powerful), Valmiki indicates that while the King of Anga was mighty, even royal valor is utterly useless against the wrath of nature.
            This narrative 'Turning Point' bridges two diametrically opposite worlds: the profoundly quiet, desireless ascetic forest, and the crisis-stricken kingdom of a powerful monarch.
            Sumantra was explaining to Dasharatha that Rishyashringa’s connection to Ayodhya would not be direct, but would be facilitated through a major crisis in Romapada's kingdom.
            It showcases the absolute marvel of the Divine Plan, where a severe crisis in one nation (the drought in Anga) perfectly paves the way for the ultimate salvation of another (the birth of Rama).
            From here, the story seamlessly transitions toward the horrific famine that ultimately compelled King Romapada to desperately seek the refuge of Sage Rishyashringa.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 7,
        sanskrit = "अङ्गेषु प्रथितो राजा भविष्यति सुधार्मिकः ।\nतस्यापचाराद् घोरा वै अनावृष्टिर्भविष्यति ॥ ७ ॥",
        hindiCommentary = """
            सुमन्त्र ने सनत्कुमार की भविष्यवाणी को आगे बढ़ाते हुए कहा—"अंग देश में वह अत्यंत धार्मिक राजा (रोमपाद) विख्यात होगा।"
            "परंतु, उस राजा से अनजाने में कोई ऐसा बड़ा अपराध या नीति-विरुद्ध कार्य (अपचाराद्) हो जाएगा, जिसके कारण उसके पूरे राज्य में एक भयंकर और घोर अकाल (अनावृष्टि) पड़ जाएगा।"
            यह श्लोक 'कर्म और फल' (Karma and Destiny) के उस कठोर सिद्धांत को दर्शाता है कि यदि राजा से धर्म में तनिक भी चूक हो जाए, तो उसका दंड पूरी प्रजा को प्रकृति के प्रकोप के रूप में भुगतना पड़ता है।
            'सुधार्मिकः' होने के बावजूद अपराध हो जाना यह बताता है कि सत्ता के मद में या अज्ञानतावश बड़े-बड़े ज्ञानियों से भी भारी भूलें हो सकती हैं।
            प्राचीन भारत में यह अटूट मान्यता थी कि राज्य में वर्षा का न होना (अनावृष्टि) सीधे तौर पर शासक के नैतिक और आध्यात्मिक पतन का परिणाम होता है।
            प्रकृति केवल मौसमी चक्र से नहीं चलती; वह राजा के 'धर्म' और प्रजा के 'सदाचार' से सीधे जुड़ी होती है (Ecological balance linked to Morality).
            अंग देश में पड़ा यह घोर अकाल कोई सामान्य प्राकृतिक आपदा नहीं था, बल्कि वह राजा रोमपाद को उनकी गलती का अहसास कराने के लिए ईश्वरीय दंड था।
            वाल्मीकि जी यहाँ शासकों को एक कड़ी चेतावनी दे रहे हैं कि उनका व्यक्तिगत आचरण पूरे राष्ट्र के भाग्य को निर्धारित करता है।
            यही वह भयानक अकाल था जिसने एक शक्तिशाली राजा को अपना अहंकार त्यागकर ऋषियों के चरणों में गिरने पर विवश कर दिया।
            सुमन्त्र दशरथ को बता रहे थे कि कैसे एक संकट ने ऋष्यशृंग के उस तपोवन से बाहर आने की भूमिका (Platform) तैयार की।
        """.trimIndent(),
        englishCommentary = """
            Continuing Sanatkumara’s prophecy, Sumantra said: "That highly righteous King (Romapada) will be deeply renowned throughout the Kingdom of Anga."
            "However, due to some unintended but grave transgression or violation of Dharma (Apacharad) committed by him, a horrific and severe drought (Anavrishti) will strike his entire kingdom."
            This verse profoundly illustrates the strict law of 'Karma and Destiny'—if a monarch commits even a slight lapse in Dharma, the entire populace suffers the punishment in the form of nature's wrath.
            Committing a transgression despite being 'Sudharmikah' (highly righteous) proves that under the intoxication of power or sheer ignorance, even the wisest rulers can make catastrophic errors.
            In ancient India, there was an unbreakable belief that a lack of rainfall (Anavrishti) in a state was the direct, tangible result of the ruler's moral, ethical, and spiritual decline.
            Nature does not operate merely on meteorological cycles; it is deeply and intrinsically linked to the 'Dharma' of the King and the morality of the citizens (Ecology linked to Morality).
            This severe drought in Anga was no ordinary natural disaster; it was a specific divine punishment designed to make King Romapada acutely aware of his grave transgression.
            Valmiki issues a stern warning to all rulers here, emphasizing that their personal, moral conduct directly dictates the fate and survival of their entire nation.
            It was this very terrifying famine that ultimately forced a highly powerful king to completely abandon his royal ego and collapse helplessly at the feet of the sages.
            Sumantra was explaining to Dasharatha how this specific crisis set the perfect platform, compelling Sage Rishyashringa to finally step out of his isolated ascetic forest.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 8,
        sanskrit = "अनावृष्ट्यां तु वृत्तायां राजा दुःखसमन्वितः ।\nब्राह्मणान् श्रुतवृद्धांश्च समानीय प्रवक्ष्यति ॥ ८ ॥",
        hindiCommentary = """
            "जब उस राज्य में भयंकर अनावृष्टि (सूखा) पड़ जाएगी और त्राहि-त्राहि मच जाएगी, तब वह राजा रोमपाद अत्यंत दुख और शोक से घिर जाएगा।"
            "अपने राज्य को नष्ट होते देख, वह राजा ज्ञान और आयु में अत्यंत वृद्ध (श्रुतवृद्धान्) ब्राह्मणों और मुनियों को एकत्रित (समानीय) करके उनसे इसका उपाय पूछेगा।"
            यह श्लोक एक आदर्श शासक के 'क्राइसिस मैनेजमेंट' (Crisis Management) को दर्शाता है; जब लौकिक उपाय विफल हो जाते हैं, तो राजा अपनी प्रजा को बचाने के लिए आध्यात्मिक ज्ञानियों की शरण लेता है।
            राजा का 'दुःखसमन्वितः' होना यह बताता है कि रोमपाद कोई क्रूर शासक नहीं थे; वे प्रजा के दुख को अपना व्यक्तिगत दुख मानते थे और उनके प्राण बचाने के लिए तड़प रहे थे।
            'श्रुतवृद्ध' वे ब्राह्मण होते हैं जो केवल उम्र में बड़े नहीं होते, बल्कि जिन्होंने वेदों (श्रुति) का अगाध अध्ययन किया है और जिन्हें प्रकृति के रहस्यों का पूर्ण ज्ञान होता है।
            राजा ने अपने मंत्रियों या सेनापतियों को नहीं बुलाया, क्योंकि वे जानते थे कि यह संकट सैन्य नहीं, बल्कि नैतिक और दैवीय है।
            वाल्मीकि जी यहाँ यह स्थापित कर रहे हैं कि विज्ञान और सत्ता की अपनी सीमाएं होती हैं; जब प्रकृति रूठती है, तो केवल 'तपस्या और धर्म' ही उसका शमन कर सकते हैं।
            ब्राह्मणों की सभा बुलाना राजा के अहंकार के पूर्ण समर्पण का प्रतीक था, जहाँ वे अपनी गलती स्वीकार कर प्रायश्चित का मार्ग खोज रहे थे।
            यही वह ऐतिहासिक सभा थी जहाँ से ऋष्यशृंग को वन से बाहर लाने की वह अत्यंत जटिल योजना (Masterplan) तैयार की गई थी।
            सुमन्त्र दशरथ को यह समझा रहे थे कि महान कार्य हमेशा महान विद्वानों की सलाह से ही सिद्ध होते हैं।
        """.trimIndent(),
        englishCommentary = """
            "When that horrifying drought (Anavrishti) devastates the land and widespread agony ensues, King Romapada will be completely overwhelmed by immense grief and sorrow (Duhkhasamanvitah)."
            "Witnessing his kingdom perishing, the King will convene an assembly (Samaniya) of Brahmins who are highly advanced in age and supreme in Vedic wisdom (Shrutavriddhan), and will desperately ask them for a solution."
            This verse illustrates an ideal ruler's 'Crisis Management'; when all secular, worldly efforts fail completely, the monarch seeks the ultimate refuge of spiritual seers to save his dying subjects.
            The King being 'Duhkhasamanvitah' (filled with grief) proves that Romapada was not a cruel despot; he internalized the suffering of his subjects as his own personal agony and yearned to save them.
            'Shrutavriddha' refers to Brahmins who are not merely old in age, but who have exhaustively studied the Vedas (Shruti) and possess an absolute understanding of the deepest secrets of nature.
            The King did not summon his military generals or politicians, for he deeply understood that this crisis was not military or economic, but fundamentally moral and divine in nature.
            Valmiki establishes here that human science and royal authority have strict limits; when nature unleashes its wrath, only 'Penance and Dharma' possess the power to pacify it.
            Convening the assembly of Brahmins was the ultimate symbol of the King's total surrender of ego, where he was ready to accept his fault and desperately seek the path of atonement.
            This was the historic assembly where the highly complex, psychological 'Masterplan' to bring Sage Rishyashringa out of the isolated forest was officially formulated.
            Sumantra was subtly conveying to Dasharatha that monumental, impossible tasks are only successfully accomplished through the profound counsel of great, realized scholars.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 9,
        sanskrit = "भवन्तः श्रुतधर्माणो लोकचारित्रवेदिनः ।\nसमादिशन्तु नियमं प्रायश्चित्तं यथा भवेत् ॥ ९ ॥",
        hindiCommentary = """
            "राजा रोमपाद उन विद्वान ब्राह्मणों से कहेंगे—'हे श्रेष्ठ मुनियों! आप सभी श्रुतियों (वेदों) और धर्म के पूर्ण ज्ञाता हैं, तथा लोक-व्यवहार और संसार के चरित्र (लोकचारित्रवेदिनः) को भली-भांति समझते हैं।'"
            "'अतः आप लोग मुझे कोई ऐसा नियम या अनुष्ठान (समादिशन्तु) बताएं, जिससे मेरे द्वारा हुए उस अनजाने अपराध का प्रायश्चित (Atonement) हो सके और राज्य में वर्षा हो।'"
            राजा का यह निवेदन उनके भीतर के सच्चे पश्चाताप को दर्शाता है; वे अपनी प्रजा को बचाने के लिए कोई भी कठिन से कठिन नियम या व्रत करने को तैयार थे।
            'लोकचारित्रवेदिनः' का अर्थ है कि वे ब्राह्मण केवल पुस्तकीय ज्ञान नहीं रखते थे, बल्कि वे समाज के मनोविज्ञान (Psychology) और प्रकृति के नियमों के भी विशेषज्ञ थे।
            प्रायश्चित्त की अवधारणा (Concept of Atonement) सनातन धर्म का एक बहुत बड़ा आधार है; यह सिखाता है कि मनुष्य गलतियां कर सकता है, पर सच्चे मन से किए गए तप द्वारा उन गलतियों को सुधारा भी जा सकता है।
            राजा ने अपना दोष दूसरों पर नहीं थोपा, बल्कि एक सच्चे नेता की तरह संकट की पूरी जिम्मेदारी अपने कंधों पर ले ली।
            वाल्मीकि जी यहाँ यह संदेश दे रहे हैं कि समस्या का समाधान तब तक नहीं मिल सकता जब तक मनुष्य अहंकार छोड़कर अपनी भूल को स्वीकार न करे।
            ब्राह्मणों से 'नियम' माँगना यह सिद्ध करता है कि वे मनमानी नहीं करना चाहते थे, बल्कि शास्त्रोक्त विधि से ही प्रकृति को प्रसन्न करना चाहते थे।
            यह श्लोक एक शासक की उस 'जवाबदेही' (Accountability) को स्थापित करता है जो आज के आधुनिक लोकतंत्रों के लिए भी एक बड़ा आदर्श है।
            इसी प्रश्न के उत्तर में ब्राह्मणों ने राजा को वह दुर्लभ उपाय बताया जो रामायण की कथा को आगे ले जाता है।
        """.trimIndent(),
        englishCommentary = """
            "King Romapada will plead to those learned Brahmins: 'O excellent Seers! You are the absolute knowers of the Vedas and Dharma, and completely understand the behavior of the world and human nature (Lokacharitravedinah).'"
            "'Therefore, please explicitly command (Samadishantu) me to observe a specific vow or ritual so that an adequate atonement (Prayashchitta) can be made for my unknown transgression, and rain may return to the state.'"
            The King’s earnest plea reflects his genuine, deeply-felt repentance; he was prepared to undertake the most excruciating vows or disciplines just to save his dying subjects.
            'Lokacharitravedinah' implies that those Brahmins did not merely possess dry, bookish knowledge; they were elite experts in mass psychology, human behavior, and the profound laws of nature.
            The 'Concept of Atonement' (Prayashchitta) is a massive pillar of Sanatan Dharma; it teaches that while humans are prone to errors, genuine repentance through severe penance can entirely rectify those mistakes.
            The King did not shift the blame onto others; like a true, responsible leader, he absorbed the entire burden of the national crisis squarely upon his own shoulders.
            Valmiki conveys a powerful message here: a solution to a crisis can never be discovered until a person completely sheds his ego and honestly accepts his own faults.
            Asking the Brahmins for a 'Niyama' (rule/vow) proves that he did not want to act arbitrarily; he desired to pacify nature strictly through authentic, scripturally-sanctioned methods.
            This verse brilliantly establishes a ruler's absolute 'Accountability,' serving as a towering, timeless ideal even for modern democratic leaders across the globe.
            It is precisely in response to this desperate question that the Brahmins revealed the highly rare, complex solution that forcefully drives the epic's narrative forward.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 10,
        sanskrit = "इत्युक्तास्ते ततो राज्ञा सर्वे ब्राह्मणसत्तमाः ।\nवक्ष्यन्ति तेमहीपालं ब्राह्मणा वेदपारगाः ॥ १० ॥",
        hindiCommentary = """
            सुमन्त्र ने कहा—"राजा रोमपाद द्वारा इस प्रकार आर्त भाव से प्रार्थना किए जाने (इत्युक्तास्ते) के पश्चात, वे सभी श्रेष्ठ ब्राह्मण और वेद-पारंगत मुनि आपस में विचार-विमर्श करेंगे।"
            "गहन चिंतन के बाद, वे वेदों के ज्ञाता ब्राह्मण उस पृथ्वीपति (महीपालं) राजा रोमपाद से इस भयंकर अकाल को दूर करने का अंतिम और अचूक उपाय कहेंगे (वक्ष्यन्ति)।"
            यह श्लोक राजा के प्रश्न और ब्राह्मणों के समाधान के बीच का वह 'तार्किक सेतु' (Logical Bridge) है जहाँ समस्या का वैज्ञानिक और आध्यात्मिक विश्लेषण किया जा रहा है।
            'ब्राह्मणसत्तमाः' और 'वेदपारगाः' शब्दों का प्रयोग यह आश्वस्त करने के लिए किया गया है कि जो उपाय बताया जाने वाला है, वह शत-प्रतिशत प्रामाणिक और वेदों की शक्ति से युक्त है।
            ऋषिगण तुरंत उत्तर नहीं देते; वे समस्या की जड़ तक जाते हैं और एक ऐसी योजना बनाते हैं जो केवल वर्षा ही न कराए, बल्कि राज्य का स्थायी कल्याण भी करे।
            राजा को 'महीपाल' (पृथ्वी का रक्षक) कहा गया है, जिसका अर्थ है कि पृथ्वी की रक्षा के लिए अब उसे एक बहुत बड़ा कूटनीतिक और मनोवैज्ञानिक दांव (Psychological move) खेलना होगा।
            वाल्मीकि जी यहाँ बता रहे हैं कि प्राचीन काल में राज्य की 'क्राइसिस कमेटी' (Crisis Committee) किस प्रकार गंभीरता से कार्य करती थी।
            उपाय सामान्य नहीं था; इसके लिए एक ऐसे व्यक्ति (ऋष्यशृंग) को लाना था जिसने कभी संसार देखा ही न हो, जो अपने आप में एक असंभव सा कार्य प्रतीत होता था।
            यह श्लोक श्रोता (दशरथ) के मन में भारी उत्कंठा (Curiosity) पैदा करता है कि आखिर वह उपाय क्या था जिसने प्रकृति के कठोर दंड को भी पलट दिया।
            यहीं से उस 'मास्टरप्लान' (Masterplan) का खुलासा होता है जो ऋष्यशृंग के विशुद्ध ब्रह्मचर्य को अयोध्या की नियति के साथ जोड़ देगा।
        """.trimIndent(),
        englishCommentary = """
            Sumantra narrated: "After being addressed and desperately pleaded with by King Romapada in this manner (Ityuktaste), all those most excellent, Veda-mastering Brahmins will deeply deliberate among themselves."
            "Following profound contemplation, those seers, who have crossed the vast ocean of the Vedas, will instruct (Vakshyanti) that Protector of the Earth (Mahipalam) on the ultimate, foolproof solution to eradicate the horrific famine."
            This verse acts as the 'Logical Bridge' between the King’s desperate inquiry and the Brahmins' solution, showing that the crisis was being analyzed both scientifically and spiritually.
            The terms 'Brahmanasattamah' and 'Vedaparagah' are used specifically to guarantee that the impending solution is one hundred percent authentic, thoroughly tested, and powered by the eternal Vedas.
            The seers do not provide a hasty, reflexive answer; they penetrate to the very root of the problem, devising a master plan that will not only bring rain but ensure the permanent welfare of the state.
            Addressing the King as 'Mahipala' (Protector of the Earth) signifies that to genuinely protect his land, he must now execute an incredibly massive, unprecedented diplomatic and psychological maneuver.
            Valmiki illustrates here exactly how the elite 'Crisis Committee' of an ancient kingdom functioned with extreme gravity, precision, and profound intellectual depth.
            The solution was far from ordinary; it required extracting a sage (Rishyashringa) who had never even seen the outside world—a task that appeared virtually impossible on the surface.
            This verse generates intense, burning curiosity in the mind of the listener (Dasharatha) to finally uncover the exact miraculous remedy that successfully overturned nature’s harshest punishment.
            From this point, the extraordinary 'Masterplan' is unveiled, a plan that will inextricably link the absolute, pristine celibacy of Sage Rishyashringa with the ultimate destiny of Ayodhya.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 11,
        sanskrit = "विभाण्डकसुतं राजन् सर्वोपायैरिहानय ।\nआनाय्य तु मुनिश्रेष्ठं ऋष्यशृङ्गं सुसत्कृतम् ॥ ११ ॥",
        hindiCommentary = """
            "वे ब्राह्मण राजा रोमपाद से कहेंगे—'हे राजन्! आप सभी संभव उपायों (सर्वोपायैः) का प्रयोग करके महर्षि विभाण्डक के पुत्र (ऋष्यशृंग) को यहाँ अंग देश में लेकर आइए।'"
            "'उन मुनिश्रेष्ठ ऋष्यशृंग को यहाँ अत्यंत आदर और सत्कार (सुसत्कृतम्) के साथ बुलाने पर ही इस राज्य का संकट दूर हो सकेगा।'"
            यह उस पूरी समस्या का एकमात्र और अचूक समाधान था—एक अत्यंत पवित्र, निष्पाप और तपोनिष्ठ आत्मा का उस कलुषित भूमि पर चरण रखना।
            'सर्वोपायैः' (सभी उपायों से) का अर्थ है कि उन्हें लाना आसान नहीं होगा; इसके लिए बल का नहीं, बल्कि कूटनीति, युक्ति और विशेष कौशल का प्रयोग करना पड़ेगा।
            विभाण्डक मुनि अत्यंत क्रोधी और शक्तिशाली थे; उनके पुत्र को उनसे दूर ले जाना साक्षात् मृत्यु को आमंत्रण देने के समान था, इसलिए ब्राह्मणों ने अत्यंत सावधानी बरतने को कहा।
            ऋष्यशृंग का ब्रह्मचर्य इतना प्रचंड था कि उनके राज्य में प्रवेश करते ही उनकी सकारात्मक ऊर्जा (Positive Energy) से अकाल का नकारात्मक प्रभाव तुरंत नष्ट हो जाता।
            वाल्मीकि जी यहाँ यह वैज्ञानिक और आध्यात्मिक तथ्य बता रहे हैं कि एक सिद्ध योगी के शरीर से निकलने वाली तरंगें (Aura) पूरे वातावरण और प्रकृति के चक्र को संतुलित कर सकती हैं।
            'सुसत्कृतम्' (सत्कार के साथ) यह चेतावनी थी कि मुनि को किसी भी प्रकार का कष्ट या अपमान नहीं होना चाहिए, अन्यथा राज्य पर एक और भारी श्राप गिर सकता था।
            यह श्लोक सिद्ध करता है कि समाज में जब नैतिक पतन के कारण आपदाएं आती हैं, तो केवल अत्यधिक शुद्ध चरित्र वाले संत ही उसका निवारण कर सकते हैं।
            इसी निर्देश के बाद राजा रोमपाद ने उस जटिल और ऐतिहासिक 'रेस्क्यू मिशन' (Rescue Mission) की योजना बनाई।
        """.trimIndent(),
        englishCommentary = """
            "The Brahmins will instruct King Romapada: 'O King! Employing absolutely all possible means and strategies (Sarvopayaih), you must bring the son of Sage Vibhandaka (Rishyashringa) here to the Kingdom of Anga.'"
            "'Only by successfully bringing that foremost of sages, Rishyashringa, here with the utmost respect and highest royal honors (Susatkritam), will this catastrophic crisis be resolved.'"
            This was the singular, infallible remedy for the entire catastrophe—the physical presence and holy footsteps of an absolutely pure, sinless, and highly ascetic soul upon that tainted, drought-stricken land.
            'Sarvopayaih' (by all means) implies that extracting him would be incredibly difficult; it required not brute military force, but elite diplomacy, subtle psychological tactics, and exceptional skill.
            Sage Vibhandaka was known to be exceedingly wrathful and immensely powerful; taking his son away was akin to inviting certain death, hence the Brahmins advised extreme caution.
            Rishyashringa’s celibacy (Brahmacharya) was so fiercely potent that the moment he entered the kingdom, his massive 'Positive Energy' would instantly obliterate the negative, karmic effects of the famine.
            Valmiki highlights a profound scientific and spiritual truth here: the powerful vibrations (Aura) radiating from a perfected Yogi possess the capacity to completely rebalance the atmosphere and the cycles of nature.
            'Susatkritam' (with high honors) served as a dire warning that the sage must not suffer the slightest discomfort or insult, lest the kingdom be struck by another catastrophic, irreversible curse.
            This verse proves that when disasters strike a society due to deep moral degradation, only saints of the most immaculate, uncompromising character possess the power to reverse the damage.
            It was directly following this specific, critical instruction that King Romapada formulated the highly complex and historic 'Rescue Mission.'
        """.trimIndent()
    ),
    RamayanVerse(
        id = 12,
        sanskrit = "विभाण्डकसुतं राजन् ब्राह्मणं वेदपारगम् ।\nप्रयच्छ कन्यां शान्तां वै विधिना सुसमाहितः ॥ १२ ॥",
        hindiCommentary = """
            "ब्राह्मण राजा को आगे का उपाय बताते हुए कहेंगे—'हे राजन्! जब वे वेदों में पारंगत, मुनि विभाण्डक के पुत्र यहाँ आ जाएँ, तब आप अत्यंत एकाग्र और सावधान (सुसमाहितः) होकर अपनी पुत्री उन्हें सौंप दें।'"
            "'आप अपनी परम रूपवती और गुणवान कन्या 'शान्ता' का विवाह उन मुनिश्रेष्ठ के साथ शास्त्रोक्त विधि (विधिना) से संपन्न करा दें।'"
            यह श्लोक इस पूरी कूटनीतिक योजना का अंतिम और सबसे महत्वपूर्ण चरण (Masterstroke) था; केवल मुनि को लाना ही पर्याप्त नहीं था, बल्कि उन्हें राज्य से स्थायी रूप से जोड़ना अनिवार्य था।
            अपनी पुत्री 'शान्ता' का विवाह एक वनवासी तपस्वी से कर देना राजा के लिए एक बहुत बड़ा त्याग था, जो उन्होंने अपनी प्रजा की रक्षा के लिए स्वेच्छा से किया।
            'वेदपारगम्' विशेषण यह बताता है कि ऋष्यशृंग कोई सामान्य वनवासी नहीं थे, बल्कि वेदों के साक्षात् स्वरूप थे, अतः वे राजा की पुत्री के लिए सर्वथा योग्य वर थे।
            'सुसमाहितः' का अर्थ है कि यह विवाह किसी छल-कपट से नहीं, बल्कि पूर्ण पवित्रता, धार्मिक विधि-विधान और अत्यंत सावधानी के साथ संपन्न होना चाहिए ताकि महर्षि विभाण्डक को क्रोध न आए।
            विवाह के माध्यम से एक वैरागी को गृहस्थ आश्रम में प्रवेश कराना प्रकृति के सृजन चक्र (Cycle of Creation) को फिर से शुरू करने का एक बहुत बड़ा प्रतीकात्मक (Symbolic) और आध्यात्मिक कार्य था।
            वाल्मीकि जी यहाँ यह स्पष्ट कर रहे हैं कि 'शान्ता' (शांति) का मिलन जब 'ऋष्यशृंग' (तपस्या) से होता है, तो समाज में अकाल मिटता है और समृद्धि की वर्षा होती है।
            यह विवाह केवल दो व्यक्तियों का नहीं, बल्कि 'राजसत्ता' और 'धर्मसत्ता' का एक परम कल्याणकारी गठबंधन था।
            दशरथ के लिए यह जानकारी इसलिए महत्वपूर्ण थी क्योंकि शान्ता वास्तव में दशरथ की ही पुत्री थीं, जिन्हें उन्होंने अपने मित्र रोमपाद को गोद दे दिया था।
        """.trimIndent(),
        englishCommentary = """
            "The Brahmins will further advise the King: 'O King! Once the son of Vibhandaka, who has fully mastered the Vedas, arrives here, you must remain highly focused and profoundly attentive (Susamahitah).'"
            "'You must formally bestow your immensely beautiful and virtuous daughter 'Shanta' to that excellent sage, solemnizing the marriage strictly according to scriptural rites (Vidhina).'"
            This verse reveals the final, ultimate phase and the absolute 'Masterstroke' of this strategic plan; merely bringing the sage was insufficient; securely anchoring him permanently to the kingdom was mandatory.
            Giving his royal daughter 'Shanta' in marriage to a forest-dwelling ascetic was a colossal, unimaginable personal sacrifice for the King, one he willingly made solely for the survival of his subjects.
            The epithet 'Vedaparagam' clarifies that Rishyashringa was no ordinary tribal forester; he was the living embodiment of the Vedas, making him an exceptionally worthy and flawless groom for a princess.
            'Susamahitah' dictates that this marriage must not involve any deceit or trickery; it must be executed with absolute purity, total religious adherence, and extreme caution to avoid incurring Sage Vibhandaka's wrath.
            Transitioning a pure ascetic into the Grihastha (householder) stage through marriage was a highly symbolic and profoundly spiritual act designed to jumpstart the stalled 'Cycle of Creation' (rainfall and fertility) in nature.
            Valmiki subtly implies here that when 'Shanta' (Peace) is united with 'Rishyashringa' (Severe Penance), all societal famines are eradicated, and an eternal shower of massive prosperity ensues.
            This marriage was not merely a union of two individuals, but a supremely beneficial, strategic alliance between 'State Power' and 'Divine Spiritual Authority.'
            This information was incredibly crucial for King Dasharatha, as Princess Shanta was actually Dasharatha’s own biological daughter, whom He had previously given in adoption to his dear friend, King Romapada.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 13,
        sanskrit = "तेषां तद्वचनं श्रुत्वा राजा चिन्तामुपागमत् ।\nकथं स आन्तव्यो वै मुनिपुत्रो मयेति च ॥ १३ ॥",
        hindiCommentary = """
            सुमन्त्र ने कथा जारी रखते हुए कहा—"उन विद्वान ब्राह्मणों के इन वचनों को सुनकर राजा रोमपाद अत्यंत गहरी चिंता (चिन्तामुपागमत्) में डूब गए।"
            "वे सोचने लगे कि 'आखिर मैं उस अत्यंत निष्पाप, दुनिया से विरक्त और वन में रहने वाले मुनि-पुत्र को यहाँ अंग देश में कैसे ला सकूँगा (कथं स आन्तव्यो)?'"
            ब्राह्मणों ने उपाय तो बता दिया था, परंतु उस उपाय को लागू करना (Execution) पहाड़ तोड़ने से भी अधिक कठिन कार्य था।
            राजा की चिंता का मुख्य कारण महर्षि विभाण्डक का प्रचंड क्रोध था; यदि उन्हें पता चलता कि उनके मासूम पुत्र को कोई ले गया है, तो वे अपने श्राप से पूरे अंग देश को क्षण भर में भस्म कर सकते थे।
            साथ ही, ऋष्यशृंग को भौतिक वस्तुओं का कोई आकर्षण नहीं था, इसलिए उन्हें धन, संपत्ति या राजसी वैभव का लालच देकर नहीं लाया जा सकता था।
            'कथं' (कैसे) शब्द राजा के उस प्रशासनिक धर्मसंकट (Administrative Dilemma) को दर्शाता है जहाँ लक्ष्य स्पष्ट है, पर मार्ग पूरी तरह से अदृश्य और अत्यंत जोखिम भरा है।
            वाल्मीकि जी यहाँ स्पष्ट कर रहे हैं कि एक राजा का जीवन कभी भी चुनौतियों से मुक्त नहीं होता; एक समस्या के हल में ही दूसरी बड़ी समस्या छिपी होती है।
            राजा को अब बाहुबल नहीं, बल्कि अत्यंत सूक्ष्म कूटनीति और 'मनोविज्ञान' (Psychology) का सहारा लेना था।
            यह श्लोक श्रोता के मन में कहानी के प्रति रोमांच (Suspense) पैदा करता है कि आखिर रोमपाद ने इस असंभव कार्य को संभव कैसे बनाया।
            दशरथ भी इस कथा को अत्यंत ध्यानमग्न होकर सुन रहे थे, क्योंकि वे जानते थे कि इसी मुनि के हाथों उनके भविष्य की चाबी सुरक्षित है।
        """.trimIndent(),
        englishCommentary = """
            Sumantra continued the narrative: "Upon thoroughly hearing these explicit instructions from the learned Brahmins, King Romapada sank into an extremely deep state of anxiety and profound worry (Chintamupagamat)."
            "He began to desperately ponder, 'How on earth can I possibly manage to bring (Katham sa antavyo) that utterly sinless, worldly-detached son of the sage out of the deep forest and into my kingdom?'"
            The Brahmins had certainly diagnosed the problem and provided the ultimate solution, but practically executing that solution was a task infinitely more difficult than shattering a mountain.
            The primary source of the King's sheer terror was the devastating wrath of Maharishi Vibhandaka; if he discovered his innocent son was abducted, his fiery curse could incinerate the entire Anga kingdom in a fraction of a second.
            Furthermore, Rishyashringa possessed absolutely zero attraction to material objects, meaning he could never be lured or bribed using vast wealth, gold, or the superficial temptations of royal opulence.
            The word 'Katham' (How) perfectly captures the King's intense 'Administrative Dilemma,' where the ultimate goal is crystal clear, but the path to achieve it is completely invisible, uncharted, and incredibly highly perilous.
            Valmiki highlights here that a monarch's life is never free from severe challenges; the very solution to one massive crisis often conceals an even more dangerous problem within it.
            The King realized that brute military force was useless here; he had to rely entirely on razor-sharp, subtle diplomacy and extremely advanced human 'Psychology.'
            This verse brilliantly builds immense 'Suspense' and thrill in the listener's mind regarding exactly how King Romapada managed to turn this absolute impossibility into a reality.
            Dasharatha listened with rapt, undivided attention, fully aware that the ultimate key to His own future lineage lay safely secured in the hands of this very sage.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 14,
        sanskrit = "ततो मन्त्रिभिरिष्टैश्च निश्चित्य स नराधिपः ।\nवारमुख्यास्ततो राजा प्रेषयामास सत्वरम् ॥ १४ ॥",
        hindiCommentary = """
            "तत्पश्चात, उस राजा (नराधिपः) रोमपाद ने अपने सबसे योग्य और प्रिय मंत्रियों (मन्त्रिभिरिष्टैश्च) के साथ मिलकर इस विषय पर अत्यंत गुप्त और गहन विचार-विमर्श किया।"
            "एक ठोस योजना निश्चित (निश्चित्य) करने के बाद, राजा ने तुरंत (सत्वरम्) अपने राज्य की सबसे चतुर और रूपवती वेश्याओं (वारमुख्याः) को उस वन की ओर भेज दिया।"
            यह श्लोक उस कुशाग्र 'मनोवैज्ञानिक योजना' (Psychological Masterplan) का खुलासा करता है जिसे मंत्रियों ने मुनि को लाने के लिए बनाया था।
            चूंकि ऋष्यशृंग ने जीवन में कभी किसी स्त्री को नहीं देखा था, इसलिए मंत्रियों ने यह युक्ति निकाली कि यदि स्त्रियां मुनि के वेश में वन में जाएं, तो वह भोला तपस्वी उन्हें देखकर आकर्षित हो जाएगा।
            'वारमुख्याः' (प्रमुख गणिकाएं) केवल सुंदर नहीं थीं, बल्कि वे कला, संगीत और मानव मनोविज्ञान (Human Psychology) को समझने में अत्यंत निपुण (Trained professionals) थीं।
            राजा का 'सत्वरम्' (शीघ्रता से) उन्हें भेजना यह बताता है कि राज्य में अकाल के कारण स्थिति इतनी भयानक थी कि योजना को लागू करने में एक क्षण का भी विलंब नहीं किया जा सकता था।
            वाल्मीकि जी ने यहाँ राजनीति के उस यथार्थवादी (Realistic) रूप को दिखाया है जहाँ राष्ट्र के व्यापक हित और प्रजा के प्राण बचाने के लिए 'साम, दाम, दंड, भेद' में से किसी भी नीति का प्रयोग जायज माना जाता था।
            यह कोई साधारण कामुक कृत्य नहीं था, बल्कि एक अकाल-ग्रस्त राज्य को बचाने के लिए किया गया एक अत्यंत सुनियोजित 'स्टेट ऑपरेशन' (State Operation) था।
            मंत्रियों के साथ विचार करना यह सिद्ध करता है कि रोमपाद अकेले कोई जोखिम नहीं लेना चाहते थे; यह एक बहुत बड़ा 'कैलकुलेटेड रिस्क' (Calculated Risk) था।
            इन वारमुख्याओं के कंधों पर अब पूरे अंग देश का भविष्य और रोमपाद के प्राणों की रक्षा का भार टिका हुआ था।
        """.trimIndent(),
        englishCommentary = """
            "Thereafter, that ruler of men (Naradhipah), King Romapada, engaged in highly secretive, intensive deliberations and strategizing with his most trusted and capable ministers (Mantribhirishtashcha)."
            "Having firmly finalized (Nishchitya) an ingenious plan, the King immediately and swiftly (Satvaram) dispatched the most exceptionally clever, beautiful, and elite courtesans (Varamukhyah) of his state into that deep forest."
            This verse unveils the razor-sharp 'Psychological Masterplan' meticulously crafted by the King's cabinet to successfully extract the secluded sage from the forest.
            Since Rishyashringa had absolutely never seen a woman in his entire life, the ministers logically deduced that if women approached him disguised as hermits, the innocent, naive ascetic would naturally be intrigued and captivated.
            The 'Varamukhyah' (elite courtesans) were not merely beautiful; they were highly 'Trained Professionals,' absolute masters of fine arts, enchanting music, and the subtle nuances of Human Psychology.
            The King dispatching them 'Satvaram' (with extreme urgency) emphasizes that the famine had caused such horrific devastation that the execution of this covert operation could not be delayed by even a single fraction of a second.
            Valmiki portrays the highly 'Realistic' nature of ancient statecraft here, where employing any strategy—including seduction or illusion—was considered completely justified if it guaranteed the broader national welfare and saved the lives of millions.
            This was by no means a base, sensual endeavor; it was a highly classified, meticulously orchestrated 'State Operation' sanctioned at the highest levels to rescue a dying civilization.
            Consulting the ministers proves that Romapada did not act impulsively; sending the courtesans to a highly dangerous ascetic’s domain was a massive, carefully weighed 'Calculated Risk.'
            The entire future of the Anga kingdom and the very survival of King Romapada now rested heavily upon the delicate, capable shoulders of these elite women.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 15,
        sanskrit = "ता गत्वा तद्वनं सर्वं महर्षेराश्रमं प्रति ।\nददृशुस्तं मुनिसुतं तदा तं वै तपस्विनम् ॥ १५ ॥",
        hindiCommentary = """
            "राजा की आज्ञा पाकर वे सभी चतुर गणिकाएं (वारमुख्याः) उस घने वन में गईं और महर्षि विभाण्डक के आश्रम के आस-पास (आश्रमं प्रति) अत्यंत सावधानी से अपना डेरा डाल लिया।"
            "वहाँ छिपकर प्रतीक्षा करते हुए, उन्होंने एक दिन अवसर पाकर उस परम तपस्वी (तपस्विनम्) और अत्यंत तेजवान मुनि-पुत्र (ऋष्यशृंग) को साक्षात् देखा (ददृशुः)।"
            यह श्लोक उस अत्यंत संवेदनशील और जोखिम भरे 'ऑपरेशन' के पहले सफल चरण का वर्णन करता है—लक्ष्य (Target) को सही सलामत ढूँढ निकालना।
            महर्षि विभाण्डक का आश्रम कोई साधारण स्थान नहीं था; वह उनके प्रचंड तपोबल से रक्षित था, इसलिए वेश्याओं को अत्यंत सतर्कता और भय के साथ वहाँ जाना पड़ा।
            उन्हें यह विशेष ध्यान रखना था कि महर्षि विभाण्डक आश्रम में न हों, क्योंकि यदि वे उन्हें देख लेते, तो उन सभी को तुरंत भस्म कर देते।
            'मुनिसुतं तपस्विनम्' यह दर्शाता है कि ऋष्यशृंग का रूप अत्यंत अलौकिक और दिव्य था; उनके चेहरे पर कठोर तपस्या का वह तेज था जिसे देखकर वे सांसारिक स्त्रियां भी एक पल के लिए विस्मित रह गई होंगी।
            गणिकाओं ने अपने रूप और कला का प्रदर्शन तुरंत शुरू नहीं किया; पहले उन्होंने मुनि के व्यवहार, उनकी दिनचर्या और उनके अकेलेपन का बारीकी से अध्ययन (Reconnaissance) किया।
            वाल्मीकि जी यहाँ कथा में एक अत्यंत गहरा मनोवैज्ञानिक तनाव (Psychological Suspense) उत्पन्न कर रहे हैं—एक ओर नितांत अज्ञानता और भोलापन है, और दूसरी ओर सांसारिक माया और छल।
            इन दोनों बिल्कुल विपरीत शक्तियों (प्रकृति और कृत्रिमता) का यह आमना-सामना रामायण के सबसे रोचक और प्रतीकात्मक (Symbolic) प्रसंगों में से एक है।
            मुनि-पुत्र को देखने के बाद, अब उन स्त्रियों को अपने उस मोहिनी-जाल को बिछाना था जिसके लिए वे अयोध्या से इतनी दूर वन में आई थीं।
        """.trimIndent(),
        englishCommentary = """
            "Upon receiving the King's strict command, all those clever courtesans ventured deep into that dense forest and very cautiously set up their covert camp near the hermitage (Ashramam Prati) of Maharishi Vibhandaka."
            "While hiding and waiting patiently for the perfect opportunity, one day they finally spotted and directly laid their eyes upon (Dadrishuh) that supremely ascetic (Tapasvinam) and radiantly brilliant son of the sage (Rishyashringa)."
            This verse meticulously describes the successful completion of the first, highly sensitive phase of this covert operation: successfully locating and identifying the 'Target' without raising any alarms.
            Maharishi Vibhandaka’s hermitage was no ordinary location; it was fiercely protected by the terrifying aura of his penance, forcing the courtesans to navigate the area with extreme, hyper-vigilant caution and deep-seated fear.
            They had to remain absolutely certain that the elder sage, Vibhandaka, was absent from the ashram; had he spotted them trespassing, his blazing wrath would have incinerated them into ashes instantly.
            'Munisutam Tapasvinam' indicates that Rishyashringa’s physical appearance was extraordinarily ethereal and divine; the blazing spiritual aura on his face must have momentarily left even those worldly, sophisticated women utterly spellbound.
            The courtesans did not impulsively begin their seductive act; first, they conducted a thorough 'Reconnaissance,' closely studying the young sage's daily routine, innocent behavior, and periods of absolute solitude.
            Valmiki masterfully builds profound 'Psychological Suspense' here—a tense confrontation between absolute, unblemished innocence on one side, and highly calculated worldly illusion and seduction on the other.
            This imminent collision between two diametrically opposite forces (pristine Nature vs. sophisticated Artifice) stands as one of the most uniquely fascinating and highly symbolic episodes in the entire Ramayana.
            Having finally acquired a visual confirmation of the sage's son, the women were now fully prepared to weave the enchanting web of illusion for which they had traveled so far from civilization.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 16,
        sanskrit = "उपायैर्विद्यमानैश्च तं मुनिं तापसात्मकम् ।\nलोभयामासुरबला रूपयौवनशालिनी ॥ १६ ॥",
        hindiCommentary = """
            "तत्पश्चात, रूप और यौवन से पूर्णतः संपन्न उन अत्यंत चतुर स्त्रियों (अबला) ने अपने पास उपलब्ध सभी मोहक उपायों और कलाओं (उपायैर्विद्यमानैश्च) का प्रयोग करना आरंभ कर दिया।"
            "उन्होंने उस परम तपस्वी स्वभाव वाले (तापसात्मकम्) अत्यंत भोले मुनि को अपने आकर्षण और हाव-भाव से लुभाना (लोभयामासुर) शुरू कर दिया।"
            यहाँ 'अबला' शब्द का प्रयोग एक व्यंग्य (Irony) के रूप में हुआ है; जो स्त्रियां एक महातपस्वी के मन को विचलित करने का सामर्थ्य रखती थीं, वे वास्तव में अबला (कमजोर) नहीं, बल्कि माया का अत्यंत शक्तिशाली अस्त्र थीं।
            उन्होंने मुनियों जैसा ही वेश धारण किया, ताकि ऋष्यशृंग को यह न लगे कि वे कोई बाहरी या विचित्र प्राणी हैं, बल्कि उन्हें लगे कि वे उन्हीं के समान कोई सुंदर 'वनवासी' हैं।
            स्त्रियों ने अत्यंत मधुर स्वर में गीत गाए, वाद्य यंत्र बजाए, और अपने सुंदर हाव-भावों से उस निर्जन वन के कठोर वातावरण को एक मादक (Sensual) और जादुई दुनिया में बदल दिया।
            'तापसात्मकम्' मुनि ने जीवन में कभी किसी स्त्री को नहीं देखा था; उनके लिए ये स्त्रियां अत्यंत अद्भुत, कोमल और रहस्यमयी 'तपस्वी' थीं, जिनके सान्निध्य में उन्हें एक अज्ञात और नया आनंद मिलने लगा।
            वाल्मीकि जी यहाँ मानव मन की उस सहज कमजोरी (Vulnerability) को दर्शा रहे हैं जहाँ ज्ञान और अनुभव के अभाव में इंद्रियां बहुत जल्दी भ्रमित (Manipulated) हो जाती हैं।
            यह कोई साधारण प्रलोभन नहीं था, बल्कि यह राज्य के हित में किया गया एक 'इकोलॉजिकल और साइकोलॉजिकल हैक' (Ecological & Psychological Hack) था।
            मुनि का उनके मोहपाश में बंधना यह सिद्ध करता है कि कामदेव (Desire) की शक्ति के आगे संसार की बड़ी से बड़ी तपस्या भी, यदि वह दुनियावी अनुभव से परे हो, तो एक बार डगमगा सकती है।
            इसी लुभावने खेल ने मुनि को अपनी उस तपोभूमि से मानसिक रूप से काट दिया, जिससे उनका अयोध्या और अंग देश की ओर जाने का मार्ग प्रशस्त हुआ।
        """.trimIndent(),
        englishCommentary = """
            "Thereafter, those highly clever women (Abala), fully endowed with enchanting beauty and blossoming youth, actively began to employ all the seductive strategies and arts available to them (Upayairvidyamanaishcha)."
            "Through their irresistible charm and calculated gestures, they began to successfully entice and allure (Lobhayamasur) that incredibly naive sage, whose entire soul was deeply anchored purely in asceticism (Tapasatmakam)."
            The use of the word 'Abala' (weak women) here is highly ironic; women possessing the terrifying psychological capability to completely shatter the focus of a grand ascetic were not weak, but functioned as the most devastatingly powerful weapons of worldly illusion (Maya).
            They deliberately dressed themselves as fellow hermits so that Rishyashringa would not perceive them as alien or threatening entities, but mistakenly identify them as unusually beautiful, soft-spoken 'forest-dwellers' just like himself.
            The courtesans sang in incredibly melodious, honeyed voices, played sweet instruments, and utilized their graceful, calculated movements to instantly transform that harsh, isolated forest into an intoxicatingly sensual and magical paradise.
            The 'Tapasatmakam' sage had absolutely never laid eyes upon a woman before; to his pure, uncorrupted mind, they were simply marvelous, uniquely gentle, and mysterious 'ascetics' whose very presence provided him with an unprecedented, unknown joy.
            Valmiki profoundly illustrates the inherent vulnerability of the human mind here—demonstrating how, in the complete absence of worldly experience and practical exposure, the senses can be extremely easily manipulated and bewildered.
            This was no ordinary act of base seduction; it was a highly sophisticated, state-sponsored 'Ecological and Psychological Hack' meticulously executed for the supreme welfare of a dying nation.
            The sage falling into their enchanting trap conclusively proves that the overwhelming power of Kama (Desire) can momentarily destabilize even the most severe penance if it completely lacks practical, worldly grounding.
            This very game of irresistible illusion successfully severed the sage's absolute psychological attachment to his hermitage, perfectly paving the royal highway for his momentous journey to Anga and, ultimately, to Ayodhya.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 17,
        sanskrit = "स ताभिः प्रमदाभिस्तु नीतो वेश्याभिराश्रमम् ।\nरोमपादस्य नगरं अङ्गानामधिपस्य च ॥ १७ ॥",
        hindiCommentary = """
            सुमन्त्र ने कहा—"मुनि के पूरी तरह आकर्षित हो जाने के बाद, वे चतुर और रूपवती वेश्याएं (वेश्याभिः/प्रमदाभिः) अपनी योजना में पूरी तरह सफल हो गईं।"
            "वे उन मुनि-पुत्र ऋष्यशृंग को उनके पिता के आश्रम (आश्रमम्) से अत्यंत चालाकी से निकालकर, अंग देश के अधिपति (राजा) रोमपाद के उस अकाल-ग्रस्त नगर (नगरं) में ले आईं (नीतो)।"
            यह श्लोक उस अत्यंत जोखिम भरे ऑपरेशन की 'सफलता' (Success) का सीधा उद्घोष करता है; स्त्रियां बिना किसी बल-प्रयोग के, केवल अपने आकर्षण के बल पर उस महान तपस्वी को वन से बाहर ले आईं।
            'नीतो' (लाए गए) का अर्थ है कि ऋष्यशृंग स्वयं अपनी इच्छा से उनके पीछे-पीछे आ गए थे; उन्हें इस बात का तनिक भी आभास नहीं था कि उन्हें उनके वास्तविक घर से कितनी दूर ले जाया जा रहा है।
            यह एक प्रकार का मनोवैज्ञानिक अपहरण (Psychological Abduction) था, जहाँ बंदी को अपनी बेड़ियों से ही प्रेम हो गया था।
            गणिकाओं ने महर्षि विभाण्डक की अनुपस्थिति का पूरा लाभ उठाया और मुनि को इस तरह मोहित किया कि वे अपने पिता के प्रति अपने कर्तव्य को भी कुछ समय के लिए भूल गए।
            जैसे ही उस परम निष्पाप, सिद्ध और पूर्ण ब्रह्मचारी ऋष्यशृंग ने अंग देश की भूमि पर अपने पवित्र चरण रखे, उस भूमि का सारा पाप और अकाल का प्रभाव तत्काल नष्ट होने लगा।
            वाल्मीकि जी यहाँ प्रकृति के उस नियम को स्थापित कर रहे हैं कि जहाँ घोर भौतिकता और संकट हो, वहाँ विशुद्ध अध्यात्म का प्रवेश ही एकमात्र अचूक उपाय होता है।
            वेश्याओं (वेश्याभिः) का यह कृत्य समाज की दृष्टि में भले ही निम्न माना जाए, परंतु उन्होंने अपने इस कर्म से एक पूरे राष्ट्र को मृत्यु के मुख से बाहर निकाल लिया था, जो उनके महान राष्ट्र-धर्म को प्रमाणित करता है।
            राजा रोमपाद का मास्टरप्लान सफल हो चुका था, और अब उन्हें प्रकृति से अपना मनचाहा फल प्राप्त होने वाला था।
        """.trimIndent(),
        englishCommentary = """
            Sumantra narrated: "Once the sage was completely and irrevocably captivated, those exceptionally clever and beautiful courtesans (Veshyabhih/Pramadabhih) achieved absolute success in their high-stakes mission."
            "Employing masterful psychological manipulation, they successfully led (Nito) that innocent sage away from his father's hermitage (Ashramam), successfully bringing him into the drought-stricken city (Nagaram) of Romapada, the Lord of the Angas."
            This verse proclaims the ultimate 'Success' of that incredibly risky, covert operation; the women managed to extract the great ascetic from the deep forest relying purely on magnetic attraction, without employing a single drop of physical force.
            'Nito' (was led/brought) signifies that Rishyashringa willingly and eagerly followed them; his innocent mind possessed absolutely no comprehension of how incredibly far he was being drawn away from his only known sanctuary.
            It was a flawless execution of 'Psychological Abduction,' a scenario where the captive had innocently and deeply fallen in love with his very captors and their enchanting illusions.
            The courtesans brilliantly capitalized on the temporary absence of the terrifying Maharishi Vibhandaka, entrancing the young sage so profoundly that he temporarily became completely oblivious to his supreme duty toward his father.
            The exact moment that supremely sinless, perfected, and absolute Brahmachari (celibate) placed his holy footsteps upon the soil of Anga, the accumulated sins and the devastating effects of the famine began to instantly vaporize.
            Valmiki establishes a profound law of nature here: whenever a society is crippled by intense materialism and severe crisis, the forceful introduction of pure, unadulterated spirituality is the only guaranteed remedy.
            Although the actions of these courtesans (Veshyabhih) might be conventionally viewed as lowly, through this highly strategic act of seduction, they had literally rescued an entire nation from the jaws of mass starvation, fulfilling their highest national duty.
            King Romapada’s audacious masterplan was now a resounding success, and he was on the absolute brink of receiving his desperately desired boon from a pacified nature.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 18,
        sanskrit = "तस्मिन् प्रविष्टे मुनिपुङ्गवे तु \nववर्ष देवः प्रमुमोद चोर्वी ।\nस तस्मै कन्यां प्रददौ च शान्तां \nततो नृपो रोमपादः प्रहृष्टः ॥ १८ ॥",
        hindiCommentary = """
            "उन मुनियों में श्रेष्ठ (मुनिपुङ्गवे) ऋष्यशृंग के उस राज्य में प्रवेश (प्रविष्टे) करते ही, साक्षात् देवराज इन्द्र ने वहाँ मूसलाधार वर्षा (ववर्ष देवः) कर दी, और वह पूरी सूखी हुई पृथ्वी (उर्वी) अत्यंत आनंदित (प्रमुमोद) हो उठी।"
            "इस अद्भुत चमत्कार को देखकर राजा रोमपाद अत्यंत हर्षित (प्रहृष्टः) हुए, और उन्होंने तुरंत अपनी परम रूपवती और गुणवान कन्या 'शान्ता' का विवाह उन मुनिराज के साथ संपन्न कर दिया (प्रददौ च शान्तां)।"
            यह श्लोक इस पूरी कथा का 'क्लाइमेक्स' (Climax) है; एक निष्पाप तपस्वी के चरणों का स्पर्श होते ही प्रकृति का सारा रूखापन और क्रोध क्षण भर में शांत हो गया।
            इन्द्र (देवः) का तुरंत वर्षा करना यह सिद्ध करता है कि देवता केवल सच्चे तप और निर्मल चरित्र के आगे ही झुकते हैं, किसी राजा के अहंकार या सैन्य बल के आगे नहीं।
            धरती का आनंदित होना (प्रमुमोद चोर्वी) केवल एक मौसमी घटना नहीं थी; यह उस पूरी प्रजा के प्राणों के वापस लौट आने का एक बहुत ही सजीव और भावपूर्ण चित्रण है जो भूख और प्यास से तड़प रही थी।
            राजा रोमपाद ने ब्राह्मणों के निर्देशानुसार बिना किसी विलंब के मुनि के प्रति अपनी कृतज्ञता प्रकट की और अपनी सबसे मूल्यवान निधि (पुत्री शान्ता) उन्हें सौंप दी।
            विवाह के द्वारा राजा ने ऋष्यशृंग को अपने राज्य का स्थायी हिस्सा (दामाद) बना लिया, ताकि भविष्य में कभी भी राज्य पर ऐसा अकाल न पड़े और महर्षि विभाण्डक के क्रोध से भी बचा जा सके।
            वाल्मीकि जी ने यहाँ यह अत्यंत गूढ़ सिद्धांत स्थापित किया है कि जब 'तप' (ऋष्यशृंग) का सम्मान 'राजसत्ता' (रोमपाद) द्वारा किया जाता है, तो वहाँ 'शांति' (शान्ता) और समृद्धि (वर्षा) का वास स्थायी हो जाता है।
            दशरथ के लिए यह सबसे बड़ी सूचना थी कि जिस मुनि ने अपनी तपस्या से रूठी हुई प्रकृति को झुका दिया, वह मुनि उनके लिए पुत्र-प्राप्ति का यज्ञ भी अवश्य सफल करा सकता है।
            इस घटना ने ऋष्यशृंग को पूरे आर्यावर्त में एक सिद्ध और 'चमत्कारी संत' के रूप में स्थापित कर दिया था।
        """.trimIndent(),
        englishCommentary = """
            "The very moment that foremost among sages (Munipungave), Rishyashringa, entered (Pravishte) the kingdom, Lord Indra himself unleashed torrential rains (Vavarsha devah), and the completely parched earth (Urvi) instantly rejoiced (Pramumoda) with boundless delight."
            "Witnessing this absolute miracle, King Romapada became overwhelmingly ecstatic (Prahrishtah), and without any delay, he formally bestowed his beautiful and highly virtuous daughter 'Shanta' in marriage to that great sage (Pradadau cha Shantam)."
            This verse is the absolute, highly anticipated 'Climax' of the narrative; the mere physical touch of the holy footsteps of a sinless ascetic instantly pacified the severe, long-standing wrath of nature.
            Lord Indra (Devah) showering rain immediately proves an eternal cosmic law: celestial gods only bow and yield to genuine, unadulterated penance and flawless character, never to the hollow ego or military might of a worldly king.
            The earth rejoicing (Pramumoda chorvi) was not just a seasonal change; it is a profoundly vivid, emotional metaphor representing the return of life, hope, and salvation to millions of subjects who had been brutally dying of starvation and thirst.
            Strictly following the Brahmins' prior instructions, King Romapada expressed his ultimate gratitude to the sage by offering him his most precious treasure—his own daughter, Shanta.
            Through this marriage, the King securely and permanently anchored Rishyashringa to his kingdom as his son-in-law, guaranteeing eternal protection against future famines and simultaneously providing an ironclad diplomatic shield against the terrifying wrath of Maharishi Vibhandaka.
            Valmiki establishes a very deep, mystical philosophy here: when severe 'Asceticism' (Rishyashringa) is granted the highest honor by 'State Power' (Romapada), absolute 'Peace' (Shanta) and massive prosperity (Rain) permanently reside in that land.
            For King Dasharatha, this was the ultimate revelation—a sage whose sheer spiritual gravity could force furious nature to submit could undoubtedly ensure the flawless success of His own desired ritual for obtaining a son.
            This phenomenal, drought-breaking event instantly elevated and cemented Sage Rishyashringa's reputation across the entire Aryavarta as a supremely perfected, 'Miracle-working Saint.'
        """.trimIndent()
    ),
    RamayanVerse(
        id = 19,
        sanskrit = "स तत्रैव वसन् विप्रो जामाता तस्य भूपतेः ।\nसनत्कुमारो भगवान् पूर्वं कथितवान् कथाम् ॥ १९ ॥",
        hindiCommentary = """
            सुमन्त्र ने कहा—"अपनी पुत्री शान्ता का विवाह करने के पश्चात, वे विप्र (ब्राह्मण ऋष्यशृंग) उस भूपति (राजा रोमपाद) के दामाद (जामाता) बनकर अंग देश में ही स्थायी रूप से सुखपूर्वक निवास (वसन्) करने लगे।"
            "हे राजन्! साक्षात् भगवान सनत्कुमार ने ऋषियों की सभा में बहुत समय पूर्व (पूर्वं) ही इस पूरी कथा और घटनाक्रम की एकदम सटीक भविष्यवाणी (कथितवान् कथाम्) कर दी थी।"
            यह श्लोक ऋष्यशृंग के जीवन के उस 'स्थायित्व' (Settlement) को दर्शाता है जहाँ एक घोर वनवासी तपस्वी अब एक राजसी परिवार का अभिन्न और सम्मानित अंग बन चुका था।
            राजा रोमपाद की कूटनीति पूरी तरह से सफल रही; उन्होंने केवल अपने राज्य का अकाल ही नहीं मिटाया, बल्कि एक ऐसे सिद्ध महापुरुष को हमेशा के लिए अपने पास रोक लिया।
            दामाद (जामाता) बन जाने के कारण, अब महर्षि विभाण्डक भी राजा रोमपाद को श्राप नहीं दे सकते थे, क्योंकि वे अब उनके समधी बन चुके थे; यह एक अत्यंत उच्च कोटि की 'सोशल इंजीनियरिंग' (Social Engineering) थी।
            सुमन्त्र बार-बार 'सनत्कुमार' का उल्लेख इसलिए कर रहे हैं ताकि दशरथ को यह विश्वास हो जाए कि यह सब कुछ एक ईश्वरीय योजना (Divine Masterplan) के तहत हो रहा है।
            जो कुछ भी अंग देश में घटा—अकाल पड़ना, वेश्याओं का जाना, मुनि का आना और विवाह होना—वह सब उस 'स्क्रिप्ट' (Script) का हिस्सा था जो बहुत पहले लिखी जा चुकी थी।
            यह श्लोक 'नियतिवाद' (Determinism) की उस अवधारणा को अत्यंत मजबूती से पुष्ट करता है जहाँ मनुष्य सोचता है कि वह योजना बना रहा है, जबकि वह केवल ईश्वर द्वारा रचित नाटक का एक पात्र मात्र होता है।
            दशरथ के लिए यह संदेश बहुत स्पष्ट था—रोमपाद का कार्य पूर्ण हो चुका है, और अब उस ईश्वरीय भविष्यवाणी का अगला हिस्सा (दशरथ को पुत्र प्राप्ति) घटित होने वाला है।
            सुमन्त्र ने राजा को मानसिक रूप से पूरी तरह तैयार कर लिया था कि अब आगे का कदम क्या होना चाहिए।
        """.trimIndent(),
        englishCommentary = """
            Sumantra said: "Having married Princess Shanta, that great Brahmin (Vipra) became the highly honored son-in-law (Jamata) of that King (Bhupateh) and began to reside (Vasan) permanently and blissfully right there in the Kingdom of Anga."
            "O King! The divine Lord Sanatkumara had flawlessly and accurately prophesied this entire sequence of events and this exact story (Kathitavan katham) a very long time ago (Purvam) in the assembly of sages."
            This verse illustrates the complete 'Settlement' and transformation in Rishyashringa’s life, where a severe, isolated forest ascetic had now become an integral, deeply revered member of a prominent royal family.
            King Romapada’s masterful diplomacy had achieved total success; he had not only eradicated the horrific famine from his land but had permanently secured the presence of a perfected, miracle-working saint.
            By establishing him as his son-in-law (Jamata), Romapada brilliantly neutralized the threat of Maharishi Vibhandaka’s fiery curse, as the angry sage could no longer destroy the kingdom of his own extended family—a supreme example of ancient 'Social Engineering.'
            Sumantra repeatedly invokes the name of 'Sanatkumara' specifically to instill absolute, unshakeable faith in Dasharatha that all these bizarre events were unfolding strictly according to a predetermined 'Divine Masterplan.'
            Everything that transpired in Anga—the devastating drought, the dispatch of the courtesans, the sage's arrival, and the royal marriage—was simply the flawless execution of a cosmic 'Script' written eons ago.
            This verse powerfully reinforces the philosophical concept of 'Determinism'; human beings operate under the illusion that they are independently strategizing, while they are merely actors playing their designated roles in a grand drama authored by the Divine.
            For King Dasharatha, the implicit message was crystal clear: Romapada’s chapter of the prophecy had concluded perfectly, and the very next phase of that divine prediction (Dasharatha obtaining an heir) was now primed to unfold.
            Through this gripping narrative, Sumantra had thoroughly and masterfully prepared the King's psychology for the monumental action He needed to take next.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 20,
        sanskrit = "तस्यां तु वृत्तं राजर्षे शृणु सत्यं ब्रवीमि ते ।\nआनाययस्व तं विप्रं ऋष्यशृङ्गं सुसत्कृतम् ॥ २० ॥",
        hindiCommentary = """
            सुमन्त्र ने अत्यंत उत्साह के साथ कहा—"हे राजर्षे! भगवान सनत्कुमार ने उस भविष्यवाणी की सभा (तस्यां) में आपके विषय में जो सत्य वृत्तांत (वृत्तं) कहा था, अब आप उसे ध्यानपूर्वक सुनिए (शृणु), मैं आपसे वही सत्य कह रहा हूँ (सत्यं ब्रवीमि ते)।"
            "उन्होंने कहा था कि राजा दशरथ को संतान प्राप्ति के लिए उस महान विप्र (ब्राह्मण ऋष्यशृंग) को अत्यंत सम्मान और सत्कार के साथ (सुसत्कृतम्) अपने राज्य अयोध्या में बुलवाना चाहिए (आनाययस्व)।"
            यह श्लोक दशरथ के जीवन के सबसे बड़े रहस्य और उनके भाग्य (Destiny) का साक्षात् उद्घाटन (Revelation) है; सुमन्त्र अब भूमिका बाँधने के बाद सीधे मुख्य मुद्दे (Core Issue) पर आ गए थे।
            दशरथ को 'राजर्षे' (राजा + ऋषि) कहना यह प्रमाणित करता है कि दशरथ स्वयं एक बहुत बड़े तपस्वी और ज्ञानी थे, जो इस ईश्वरीय संकेत को समझने में पूरी तरह सक्षम थे।
            'सत्यं ब्रवीमि ते' (मैं सत्य कह रहा हूँ) यह बताता है कि सुमन्त्र राजा को झूठी सांत्वना या कोई कूटनीतिक चाल नहीं बता रहे थे, बल्कि वे सीधे ब्रह्मांड के उस सत्य को प्रेषित कर रहे थे जो देवताओं द्वारा निर्धारित था।
            सनत्कुमार की भविष्यवाणी के अनुसार, दशरथ को अश्वमेध और पुत्रेष्टि यज्ञ के लिए किसी अन्य पुरोहित की नहीं, बल्कि साक्षात् उस निष्पाप ऋष्यशृंग की ही आवश्यकता थी, जिनकी आहुति से ही देवता प्रत्यक्ष फल देने वाले थे।
            'सुसत्कृतम्' (अत्यंत आदर के साथ) यह एक कड़ी चेतावनी थी कि ऋष्यशृंग अब रोमपाद के दामाद हैं और एक सिद्ध संत हैं, अतः उन्हें किसी आज्ञा या बल से नहीं, बल्कि पूर्ण भक्ति और विनम्रता से ही अयोध्या लाया जा सकता है।
            वाल्मीकि जी यहाँ बता रहे हैं कि ईश्वर जब कुछ देना चाहता है, तो वह उसका साधन भी पहले से ही निर्मित कर देता है; दशरथ का संकल्प और ऋष्यशृंग की उपस्थिति—दोनों एक ही समय पर पूर्णता को प्राप्त हो रहे थे।
            सुमन्त्र ने राजा को एक स्पष्ट और 'एक्शनेबल प्लान' (Actionable Plan) दे दिया था; अब राजा को केवल अपने मित्र रोमपाद के पास जाकर उनसे अपने दामाद को माँगना था।
            यह श्लोक रामायण की कथा को सीधा उस महा-यज्ञ की ओर धकेल देता है जहाँ से राम, लक्ष्मण, भरत और शत्रुघ्न का भौतिक संसार में प्राकट्य होने वाला था।
        """.trimIndent(),
        englishCommentary = """
            With immense enthusiasm, Sumantra declared: "O Rajarshi (Royal Sage)! Now listen (Shrinu) attentively to the absolute true sequence of events (Vrittam) concerning you, exactly as Lord Sanatkumara had revealed it in that divine assembly; I speak nothing but the ultimate Truth to you (Satyam bravimi te)."
            "The prophecy clearly stated that in order to obtain an heir, King Dasharatha must respectfully invite and bring (Anayayasva) that great Brahmin, Sage Rishyashringa, to His kingdom of Ayodhya with the utmost supreme honors (Susatkritam)."
            This verse acts as the monumental 'Revelation' of the greatest secret and the ultimate Destiny of King Dasharatha’s life; having meticulously set the stage, Sumantra now struck directly at the very 'Core Issue.'
            Addressing Dasharatha as 'Rajarshi' (a blend of King and Sage) proves that Dasharatha Himself was a profoundly ascetic and wise soul, entirely capable of grasping the magnitude of this cosmic divine signal.
            'Satyam bravimi te' (I speak the Truth to you) confirms that Sumantra was not offering cheap, false consolation or a hollow political strategy; he was acting as a direct conduit for the absolute Truth predetermined by the celestial gods.
            According to Sanatkumara’s infallible prophecy, Dasharatha did not need any ordinary priest for the Ashvamedha and Putreshti Yajna; He required the physical presence of the sinless Rishyashringa, whose oblations alone could compel the gods to manifest and grant the boon.
            'Susatkritam' (with the highest respect) served as a strict warning: Rishyashringa was now the honored son-in-law of King Romapada and a perfected saint; he could not be summoned by royal decree or force, but could only be invited through absolute devotion and profound humility.
            Valmiki demonstrates here that when the Divine intends to bestow a grand blessing, He meticulously prepares the specific instrument for it well in advance; Dasharatha’s vow and Rishyashringa’s availability were perfectly synchronizing at this exact, destined moment.
            Sumantra had successfully provided the King with a highly clear, 'Actionable Plan'; all the Monarch had to do now was to approach His dear friend Romapada and humbly request the services of his son-in-law.
            This single verse forcefully propels the narrative of the Ramayana directly toward that colossal 'Maha-Yajna' from which Rama, Lakshmana, Bharata, and Shatrughna would eventually manifest into the physical world.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 21,
        sanskrit = "एवमिक्ष्वाकुनाथस्य तस्य राज्ञो महात्मनः ।\nपुत्राः प्रादुर्भविष्यन्ति चत्वारोऽमितविक्रमाः ॥ २१ ॥",
        hindiCommentary = """
            सुमन्त्र ने सनत्कुमार की भविष्यवाणी का सबसे सुखद अंश सुनाते हुए कहा—"इस प्रकार (ऋष्यशृंग के द्वारा यज्ञ संपन्न होने पर), इक्ष्वाकु वंश के नाथ, उन महात्मा राजा दशरथ के यहाँ—"
            "असीमित और अकल्पनीय पराक्रम वाले (अमितविक्रमाः) 'चार' अत्यंत तेजस्वी पुत्र (पुत्राः) एक साथ प्रकट (प्रादुर्भविष्यन्ति) होंगे।"
            यह श्लोक राजा दशरथ के वर्षों के संताप, पीड़ा और आंसुओं का अंतिम और सबसे मधुर परिणाम है; एक ऐसा 'डिवाइन प्रॉमिस' (Divine Promise) जो स्वयं ब्रह्मा के पुत्र ने दिया था।
            'चत्वारो' (चार) शब्द यह सुनिश्चित करता है कि दशरथ का वंश केवल एक पुत्र से नहीं, बल्कि चार महान स्तंभों (राम, लक्ष्मण, भरत, शत्रुघ्न) से सुरक्षित और समृद्ध होने वाला है।
            'प्रादुर्भविष्यन्ति' (प्रकट होंगे) शब्द का प्रयोग वाल्मीकि जी ने बहुत सोच-समझकर किया है; वे यह नहीं कह रहे कि पुत्र 'पैदा' होंगे, बल्कि कह रहे हैं कि वे 'प्रकट' (Manifest) होंगे, क्योंकि भगवान जन्म नहीं लेते, वे अवतरित होते हैं।
            'अमितविक्रमाः' विशेषण यह भविष्यवाणी करता है कि इन चारों पुत्रों का बाहुबल साधारण मनुष्यों जैसा नहीं होगा; वे अपने पराक्रम से पूरी पृथ्वी को राक्षसों (विशेषकर रावण) के आतंक से पूरी तरह मुक्त कर देंगे।
            इक्ष्वाकु वंश, जो दशरथ के बाद समाप्त होता हुआ प्रतीत हो रहा था, अब इन चार पुत्रों के कारण संसार के इतिहास में सबसे महान और अजर-अमर वंश बनने वाला था।
            सुमन्त्र के मुख से ये शब्द सुनते ही दशरथ का हृदय एक ऐसी असीम शांति और परमानंद से भर गया होगा जिसकी उन्होंने जीवन में कभी कल्पना भी नहीं की थी।
            यह श्लोक रामायण के उस मूल 'उद्देश्य' (Objective) की आधिकारिक घोषणा है जिसके लिए यह पूरा महाकाव्य रचा गया है—सत्य और धर्म की स्थापना के लिए परमात्मा का चार रूपों में पृथ्वी पर आना।
            सुमन्त्र की यह बात कोई साधारण कूटनीति नहीं थी, बल्कि यह दशरथ के लिए साक्षात् मोक्ष का द्वार खोलने वाला एक ईश्वरीय संदेश था।
        """.trimIndent(),
        englishCommentary = """
            Narrating the most incredibly joyous segment of Sanatkumara’s prophecy, Sumantra said: "In this exact manner (upon the successful completion of the sacrifice by Rishyashringa), to that high-souled King Dasharatha, the supreme Lord of the Ikshvaku dynasty—"
            "Four (Chatvaro) intensely radiant sons (Putrah), possessing absolutely limitless and unimaginable valor (Amitavikramah), shall simultaneously manifest (Pradurbhavishyanti)."
            This verse acts as the ultimate, sweetest, and most highly anticipated reward for King Dasharatha’s decades of deep agony, tears, and suffering; it was an ironclad 'Divine Promise' delivered by the very son of Lord Brahma.
            The specific word 'Chatvaro' (Four) guarantees that Dasharatha’s glorious lineage would not merely survive through a single heir, but would be infinitely secured and enriched by four monumental pillars (Rama, Lakshmana, Bharata, and Shatrughna).
            Valmiki has utilized the term 'Pradurbhavishyanti' (shall manifest) with extreme, deliberate precision; he does not state that the sons will be 'born' like ordinary mortals, but rather that they will 'manifest,' signifying a direct, transcendental divine incarnation.
            The powerful epithet 'Amitavikramah' accurately prophesies that the physical and spiritual might of these four sons will transcend all ordinary human limits; their sheer valor will completely liberate the entire earth from the terrifying tyranny of demons (specifically Ravana).
            The Ikshvaku lineage, which had appeared to be on the tragic brink of extinction after Dasharatha, was now destined to become the absolute greatest, most immortal dynasty in the history of the entire world.
            Upon hearing these ambrosial words directly from Sumantra's lips, Dasharatha’s heart must have instantly overflowed with a profound, boundless peace and an ultimate ecstasy that He had never even dared to imagine.
            This verse serves as the formal, official declaration of the core 'Objective' of the Ramayana—the direct descent of the Supreme Absolute into the physical realm in four distinct forms to eternally establish Truth and Dharma.
            Sumantra’s revelation was far beyond ordinary state diplomacy; it was a pure, unadulterated divine message that literally opened the gates of ultimate salvation and profound joy for King Dasharatha.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 22,
        sanskrit = "एतत् सर्वं यथातथ्यं सनत्कुमारोऽभाषत ।\nतस्मात् त्वं याहि तं विप्रं ऋष्यशृङ्गं सुसत्कृतम् ॥ २२ ॥",
        hindiCommentary = """
            सुमन्त्र ने अपनी बात का समापन करते हुए कहा—"हे राजन्! साक्षात् भगवान सनत्कुमार ने ऋषियों की उस महान सभा में यह सब कुछ बिल्कुल 'यथातथ्य' (जैसा का तैसा, पूर्ण सत्य) कहा था।"
            "इसलिए (तस्मात्), अब आप बिना कोई विलंब किए स्वयं अंग देश जाइए (त्वं याहि) और उन परम तपस्वी ब्राह्मण ऋष्यशृंग को पूर्ण आदर और सत्कार (सुसत्कृतम्) के साथ यहाँ अयोध्या ले आइए।"
            'यथातथ्यं' शब्द इस बात की 'गारंटी' (Guarantee) देता है कि सुमन्त्र ने भविष्यवाणी में अपनी ओर से एक भी शब्द नहीं जोड़ा है; जो देवताओं ने तय किया है, वही उन्होंने दशरथ के सामने प्रस्तुत किया है।
            'त्वं याहि' (आप स्वयं जाइए) यह एक बहुत बड़ा कूटनीतिक और पारम्पारिक सुझाव है; सुमन्त्र जानते थे कि यदि राजा स्वयं जाएँगे, तो उनके मित्र रोमपाद उन्हें कभी मना नहीं कर पाएंगे।
            एक महान संत और दामाद को किसी दूत के माध्यम से बुलवाना उनका अपमान होता, इसलिए सुमन्त्र ने राजा को स्वयं जाने का यह अत्यंत उचित और विनम्र परामर्श दिया।
            सुमन्त्र की यह सलाह सिद्ध करती है कि वे केवल एक आज्ञाकारी सेवक नहीं थे, बल्कि एक ऐसे 'मार्गदर्शक' (Guide) थे जो राजा को सही समय पर सही निर्णय लेने के लिए प्रेरित कर सकते थे।
            दशरथ, जो कुछ समय पहले तक निराशा के गहरे सागर में डूबे थे, अब सुमन्त्र के इन तार्किक और ईश्वरीय वचनों से पूरी तरह आश्वस्त और ऊर्जावान हो चुके थे।
            वाल्मीकि जी ने इस श्लोक में यह स्पष्ट किया है कि एक श्रेष्ठ मंत्री वह है जो समस्या बताने के साथ-साथ उसका एक अचूक और व्यावहारिक 'एक्शन प्लान' (Action Plan) भी राजा के सामने रखे।
            यह श्लोक रामायण की कहानी को एक नए भौगोलिक (Geographical) और भावनात्मक मोड़ की ओर ले जाता है, जहाँ अयोध्या का राजा अंग देश की ओर प्रस्थान करने वाला है।
            यहीं से उस महान 'पुत्रेष्टि यज्ञ' की व्यावहारिक नींव (Practical Foundation) पूरी तरह से मजबूत और तय हो जाती है।
        """.trimIndent(),
        englishCommentary = """
            Concluding his profound revelation, Sumantra said: "O King! The divine Lord Sanatkumara had articulated all of this exactly and precisely as the absolute, unaltered Truth (Yathatathyam) in that grand assembly of seers."
            "Therefore (Tasmat), you must personally go (Tvam yahi) to the Kingdom of Anga without any delay, and bring that highly ascetic Brahmin, Sage Rishyashringa, back here to Ayodhya with the most supreme honors and utmost respect (Susatkritam)."
            The term 'Yathatathyam' acts as an ironclad 'Guarantee' that Sumantra had not embellished or added a single word of his own to the prophecy; he had presented exactly what the celestial gods had predetermined and ordained.
            'Tvam yahi' (You must personally go) is an incredibly sharp and traditional diplomatic suggestion; Sumantra was acutely aware that if King Dasharatha went in person, His dear friend Romapada would find it absolutely impossible to decline His request.
            Summoning a highly perfected saint and an honored royal son-in-law via a mere messenger would be a grave insult; hence, Sumantra provided the most appropriate, humble, and perfectly decorous advice for the Monarch to travel Himself.
            Sumantra’s counsel definitively proves that he was not merely an obedient, passive servant, but an elite 'Guide' fully capable of inspiring the King to execute the perfectly correct decision at the exact right moment.
            Dasharatha, who had been drowning in the deepest, darkest ocean of despair just moments ago, was now thoroughly convinced, completely reassured, and massively energized by Sumantra's deeply logical and divine words.
            Valmiki establishes a crucial leadership principle here: a superior minister is one who not only successfully identifies a massive problem but simultaneously provides the King with an infallible, highly practical 'Action Plan.'
            This verse dynamically propels the Ramayana narrative toward a fresh geographical and emotional turning point, setting the stage for the King of Ayodhya to commence His momentous journey toward the Kingdom of Anga.
            It is exactly from this pivotal point that the 'Practical Foundation' for the grand, world-altering 'Putreshti Yajna' is firmly, solidly, and irrevocably cemented.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 23,
        sanskrit = "तच्छ्रुत्वा मन्त्रिणो वाक्यं राजा दशरथस्तदा ।\nहर्षेण महताविष्टः सुमन्त्रमिदमब्रवीत् ॥ २३ ॥\nइति वाल्मीकिरामायणे बालकाण्डे अष्टमः सर्गः ॥",
        hindiCommentary = """
            अपने अत्यंत विश्वस्त मंत्री सुमन्त्र के उन ईश्वरीय और आशा से भरे वचनों (वाक्यं) को सुनकर, राजा दशरथ उस समय (तदा) एक असीम और महान हर्ष (हर्षेण महता) से पूरी तरह भर गए (आविष्टः)।
            उस अकल्पनीय आनंद की अवस्था में, राजा दशरथ ने अपने उस परम हितैषी मंत्री सुमन्त्र से अत्यंत प्रेमपूर्वक यह (आगे का) वचन कहा (इदमब्रवीत्)।
            यह श्लोक अष्टम सर्ग का 'अंतिम श्लोक' है, जो दशरथ के वर्षों पुराने संताप के पूरी तरह से नष्ट होने और एक नए, स्वर्णिम अध्याय के शुरू होने की सुखद घोषणा करता है।
            'हर्षेण महताविष्टः' यह दर्शाता है कि यह कोई सामान्य खुशी नहीं थी; यह वह 'परमानंद' (Supreme Joy) था जो एक निराश पिता को यह जानकर मिलता है कि उसे एक नहीं, बल्कि चार अजेय पुत्र प्राप्त होने वाले हैं।
            सुमन्त्र की वह 'रहस्यमयी मंत्रणा' शत-प्रतिशत सफल रही; उन्होंने राजा को न केवल सांत्वना दी, बल्कि उन्हें कर्म के मार्ग पर पूरी ऊर्जा के साथ खड़ा कर दिया।
            दशरथ का सुमन्त्र से आगे बात करना यह सिद्ध करता है कि वे अब इस 'मिशन' (Mission) को तुरंत धरातल पर उतारने के लिए अत्यंत व्याकुल थे, और वे जानना चाहते थे कि अंग देश जाने की विस्तृत रूपरेखा क्या होगी (जिसका वर्णन अगले सर्ग में है)।
            इस प्रकार, वाल्मीकि रामायण के बालकाण्ड का यह 'अष्टम सर्ग', जो सुमन्त्र की मंत्रणा और सनत्कुमार की उस महान भविष्यवाणी से जुड़ा था, यहाँ अपने पूर्ण गौरव के साथ समाप्त होता है।
            यह सर्ग हमें यह गूढ़ शिक्षा देता है कि जब मनुष्य अपने सबसे गहरे अंधकार में होता है, तब ईश्वर किसी न किसी (जैसे सुमन्त्र) को आशा की किरण देकर अवश्य भेजता है।
            अब अयोध्या के उस शांत और भव्य राजमहल में अश्वमेध यज्ञ और ऋष्यशृंग को लाने की उन विशाल तैयारियों का शंखनाद हो चुका था जो त्रेता युग का इतिहास रचने वाली थीं।
            ॥ अष्टम सर्ग सम्पूर्ण हुआ। जय श्री राम ॥
        """.trimIndent(),
        englishCommentary = """
            Having thoroughly heard those deeply divine and incredibly hope-filled words (Vakyam) from his highly trusted minister, King Dasharatha was instantly and completely overwhelmed (Avishtah) by a profound, massive, and boundless joy (Harshena mahata).
            Firmly established in that state of unimaginable, soaring ecstasy, King Dasharatha very affectionately spoke the following words (Idamabravit) to his ultimate well-wisher, Minister Sumantra.
            This verse serves as the 'Final Shloka' of the Eighth Sarga, acting as the incredibly joyous, triumphant declaration that Dasharatha’s decades-long agony had been utterly annihilated, initiating a brand new, golden chapter.
            'Harshena mahatavishtah' clearly indicates that this was no ordinary happiness; it was the 'Supreme Joy' experienced by an utterly hopeless father upon discovering that he is destined to obtain not just one, but four invincible heirs.
            Sumantra’s highly 'Classified Counsel' was one hundred percent successful; he had not only provided profound solace to the King but had completely revitalized Him, setting Him squarely upon the path of intense, massive action.
            Dasharatha speaking further to Sumantra proves that He was now incredibly eager and restless to execute this grand 'Mission' on the ground immediately, seeking the detailed blueprint for the journey to Anga (which unfolds in the next Sarga).
            Thus, the 'Eighth Sarga' of the Baal Kand in the Valmiki Ramayana, intricately dealing with Sumantra’s secretive counsel and the monumental prophecy of Lord Sanatkumara, reaches its glorious completion here.
            This chapter imparts the profound spiritual lesson that exactly when a human being is drowning in the absolute deepest darkness of despair, the Divine invariably sends someone (like Sumantra) bearing a blazing ray of hope and salvation.
            The conch shell had now been officially blown within that serene and magnificent palace of Ayodhya, signaling the start of the colossal preparations for the Ashvamedha and the bringing of Sage Rishyashringa—events destined to author the history of the Treta Yuga.
            || Thus ends the Eighth Sarga. Jai Shri Ram ||
        """.trimIndent()
    )
)