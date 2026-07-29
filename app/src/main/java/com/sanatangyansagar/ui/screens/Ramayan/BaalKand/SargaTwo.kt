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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SargaTwoScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaTwoVerses
        } else {
            sargaTwoVerses.filter {
                it.id.toString().contains(searchQuery) ||
                        it.sanskrit.contains(searchQuery, ignoreCase = true) ||
                        it.hindiCommentary.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color.White)) {
                CenterAlignedTopAppBar(
                    title = {
                        Text("द्वितीय सर्ग - श्लोक उत्पत्ति", fontWeight = FontWeight.ExtraBold)
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
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

val sargaTwoVerses = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "नारदस्य तु तद्वाक्यं श्रुत्वा वाक्यविशारदः ।\nपूजयामास धर्मज्ञः सहशिष्यो महामुनिः ॥ १ ॥",
        hindiCommentary = """
            नारद जी के वचनों को सुनने के बाद वाणी के विशेषज्ञ मुनि वाल्मीकि ने उनका सत्कार किया।
            वे स्वयं धर्म के ज्ञाता थे और नारद के दिव्य उपदेशों की गहराई को समझ रहे थे।
            उन्होंने अपने शिष्यों के साथ मिलकर देवर्षि का विधि-विधान से पूजन संपन्न किया।
            यह पूजन उस महान सत्य के प्रति कृतज्ञता थी जो नारद जी ने अभी-अभी प्रकट किया था।
            वाल्मीकि जी जानते थे कि यह राम-कथा संसार के कल्याण का एकमात्र मार्ग बनने वाली है।
            नारद के वचनों ने उनके हृदय में भक्ति और ज्ञान का एक नया प्रकाश भर दिया था।
            गुरु-शिष्य परंपरा में ज्ञान देने वाले का सम्मान करना अनिवार्य और पवित्र माना गया है।
            मुनि का मन अब उस दिव्य चरित्र पर मनन करने के लिए पूरी तरह तैयार हो चुका था।
            सत्कार के दौरान वन का वातावरण अत्यंत शांत और आध्यात्मिक ऊर्जा से परिपूर्ण था।
            यह श्लोक दो महान ऋषियों के बीच के उस गरिमामयी संवाद के समापन को दर्शाता है।
            वाल्मीकि जी की विनम्रता उनके महान ऋषि होने का सबसे बड़ा और प्रत्यक्ष प्रमाण थी।
        """.trimIndent(),
        englishCommentary = """
            After listening to Narada's words, Valmiki, the master of speech, honored him properly.
            Being an expert in Dharma, he grasped the profound essence of the divine narrative.
            Alongside his disciples, the great sage performed the formal worship of the celestial seer.
            This worship was an expression of gratitude for the transcendental wisdom shared.
            Valmiki realized that this story of Rama was destined to uplift all of humanity.
            Narada's discourse had ignited a new light of devotion and wisdom within his heart.
            In the Vedic tradition, honoring the source of knowledge is a sacred and vital duty.
            The sage’s mind was now fully prepared to contemplate the divine life of Sri Rama.
            The forest atmosphere remained tranquil and charged with immense spiritual vibrations.
            This verse marks the dignified conclusion of the dialogue between the two great seers.
            Valmiki's humility stands as a primary testimony to his stature as an enlightened sage.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 2,
        sanskrit = "यथावत्पूजितस्तेन देवर्षिर्नारदस्तदा ।\nआपृष्ट्वैव जगामाथ नभसं मुनिना ततः ॥ २ ॥",
        hindiCommentary = """
            जब वाल्मीकि जी ने देवर्षि नारद का विधिवत पूजन कर लिया, तब नारद जी ने विदा ली।
            मुनि की अनुमति पाकर देवर्षि नारद क्षण भर में ही आकाश मार्ग से स्वर्ग की ओर चले गए।
            नारद जी का आकाश में विलीन होना उनकी अलौकिक शक्तियों और देवत्व का प्रतीक था।
            उनका आगमन और प्रस्थान केवल धर्म की रक्षा और ज्ञान के प्रसार के लिए ही होता है।
            वाल्मीकि जी उन्हें विस्मय और आदर के साथ तब तक देखते रहे जब तक वे ओझल नहीं हुए।
            'यथावत्' शब्द बताता है कि पूजन की हर प्रक्रिया शास्त्रों के अनुसार पूर्ण की गई थी।
            नारद के जाने के बाद वन में एक पवित्र सन्नाटा छा गया, मानो प्रकृति भी मौन हो गई हो।
            यह प्रस्थान वाल्मीकि के लिए एक बड़ी जिम्मेदारी और महान सृजन की शुरुआत का क्षण था।
            अब उनके पास केवल श्री राम का दिव्य चरित्र और नारद के दिए हुए विचार ही शेष थे।
            मुनि वाल्मीकि के जीवन का अगला अध्याय अब यहीं से आकार लेने वाला था।
            यह श्लोक भौतिक जगत और सूक्ष्म देवलोक के बीच के सहज संपर्क को उजागर करता है।
        """.trimIndent(),
        englishCommentary = """
            After being properly worshiped by Valmiki, the celestial sage Narada took his leave.
            With the permission of the sage, Narada instantly ascended into the firmament.
            His disappearance into the sky was a testament to his supernatural and divine nature.
            His arrival and departure are always motivated by the spread of wisdom and Dharma.
            Valmiki watched him with a mixture of reverence and awe until he vanished from sight.
            The term 'Yathavat' signifies that every ritual was performed according to the scriptures.
            Following his exit, a sacred silence filled the forest, as if nature itself was in meditation.
            This departure was the catalyst for Valmiki's upcoming journey of grand literary creation.
            He was now left with only the divine name of Rama and the seeds of the great epic.
            The next chapter of Valmiki’s life was destined to take shape from this very point.
            This verse illustrates the seamless connection between the mortal world and the divine realms.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 3,
        sanskrit = "स मुहूर्तं गते तस्मिन् देवलोकं मुनिस्तदा ।\nजगाम तमसातीरं जाह्नव्यास्त्वविदूरतः ॥ ३ ॥",
        hindiCommentary = """
            नारद जी के जाने के कुछ ही समय बाद मुनि वाल्मीकि तमसा नदी के तट पर गए।
            यह नदी पवित्र गंगा (जाह्नव्या) के अत्यंत निकट बहती थी और अपनी शांति के लिए प्रसिद्ध थी।
            मुनि का नदी तट पर जाना केवल स्नान के लिए नहीं, बल्कि मानसिक शांति और चिंतन के लिए था।
            नारद के वचनों ने उनके मन में जो हलचल पैदा की थी, उसे वे शांत करना चाहते थे।
            नदियाँ भारतीय संस्कृति में ज्ञान के निरंतर प्रवाह और शुद्धि का प्रतीक मानी गई हैं।
            वाल्मीकि जी के साथ उनके शिष्य भी थे जो गुरु की हर क्रिया का श्रद्धापूर्वक अवलोकन कर रहे थे।
            प्रकृति की गोद में ही अक्सर महान सत्यों का उद्घाटन होता है और यहाँ भी यही होने वाला था।
            मुहूर्त भर का समय उनके चिंतन और आने वाली महान घटना के बीच का एक छोटा अंतराल था।
            तमसा का तट वह पावन स्थान बनने वाला था जहाँ संसार के पहले काव्य का जन्म होगा।
            मुनि के कदम अनजाने में ही इतिहास रचने की दिशा में अत्यंत स्थिरता से बढ़ रहे थे।
            गंगा और तमसा का वह सान्निध्य ऋषियों के तप के लिए सबसे अनुकूल वातावरण प्रदान करता था।
        """.trimIndent(),
        englishCommentary = """
            Shortly after Narada's ascent to heaven, Valmiki headed toward the river Tamasa.
            This river flowed in close proximity to the holy Ganges and was known for its purity.
            The sage's visit to the bank was intended for both ritual bathing and deep reflection.
            He sought to process the profound intellectual and spiritual stirrings caused by Narada.
            In Vedic culture, rivers symbolize the eternal flow of wisdom and spiritual cleansing.
            Valmiki was accompanied by his disciples, who closely observed his solemn behavior.
            Great revelations often occur in the lap of nature, and this moment was no different.
            The brief interval after Narada's exit was the calm before a monumental epiphany.
            The banks of Tamasa were destined to be the birthplace of the world's first poetry.
            The sage’s footsteps were leading him toward a historic and divine literary milestone.
            The vicinity of the Ganges and Tamasa provided the ideal setting for Vedic penance.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 4,
        sanskrit = "स तु तीरं समासाद्य तमसाया मुनिस्तदा ।\nशिष्यमाह स्थितं पार्श्वे भारद्वाजमदूरतः ॥ ४ ॥",
        hindiCommentary = """
            तमसा नदी के तट पर पहुँचकर मुनि वाल्मीकि ने अपने निकट खड़े शिष्य भारद्वाज से बात की।
            भारद्वाज जी एक निष्ठावान शिष्य थे जो सदैव अपने गुरु की सेवा में तत्पर रहते थे।
            नदी की स्वच्छता और वहाँ के शांत वातावरण ने मुनि का ध्यान अपनी ओर खींच लिया था।
            गुरु और शिष्य का यह संवाद उस महान घटना की भूमिका है जो अगले ही क्षण घटने वाली थी।
            वाल्मीकि जी ने भारद्वाज को नदी के जल की निर्मलता देखने का निर्देश दिया।
            शिष्य का पास होना यह दर्शाता है कि ज्ञान का हस्तांतरण निरंतर एक पीढ़ी से दूसरी पीढ़ी को होता है।
            यहाँ 'अदूरतः' शब्द गुरु और शिष्य के बीच के उस आत्मीय और निकट संबंध को दर्शाता है।
            भारद्वाज आगे चलकर स्वयं एक महान ऋषि बने, पर यहाँ वे एक विनम्र सेवक की भूमिका में हैं।
            नदी का शांत प्रवाह मुनि के स्वयं के निर्मल और एकाग्र मन का प्रतिबिंब जान पड़ता था।
            वाल्मीकि जी का शिष्य को संबोधित करना यह बताता है कि वे प्रकृति से शिक्षा लेने के आदि थे।
            यह क्षण उस महान 'करुणा' के उदय से ठीक पहले का है जिसने रामायण को जन्म दिया।
        """.trimIndent(),
        englishCommentary = """
            Upon reaching the banks of the Tamasa, Sage Valmiki addressed his disciple Bharadwaja.
            Bharadwaja was a dedicated student who was always ready to serve his master.
            The cleanliness and the serene environment of the river captured the sage's attention.
            This interaction serves as a subtle prelude to the extraordinary event that followed.
            Valmiki instructed Bharadwaja to observe the crystalline clarity of the river water.
            The presence of the disciple signifies the continuous transmission of knowledge.
            The word 'Aduratah' highlights the intimate and soulful bond between Guru and Shishya.
            Bharadwaja later became a great seer himself, but here he fulfills the role of a servant.
            The calm flow of the river seemed to mirror the sage's own pristine and focused mind.
            Addressing the disciple shows that Valmiki was accustomed to learning from nature.
            This moment immediately preceded the dawn of 'Compassion' that birthed the Ramayana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 5,
        sanskrit = "अकर्दममिदं तीर्थं भरद्वाज निशामय ।\nरमणीयं प्रसन्नाम्बु सन्मनुष्यमनो यथा ॥ ५ ॥",
        hindiCommentary = """
            वाल्मीकि जी कहते हैं—"हे भारद्वाज! इस घाट को देखो, यह कितना निर्मल और कीचड़ रहित है।"
            इसका जल अत्यंत रमणीय और स्वच्छ है, बिल्कुल एक 'सज्जन मनुष्य के मन' की तरह।
            यह उपमा विश्व साहित्य की सबसे सुंदर और प्राचीनतम उपमाओं में से एक मानी जाती है।
            एक श्रेष्ठ मनुष्य का मन जिस प्रकार विकारों से मुक्त होता है, वैसा ही इस नदी का जल है।
            मुनि यहाँ प्रकृति के माध्यम से जीवन के सर्वोच्च नैतिक मूल्यों की व्याख्या कर रहे हैं।
            स्वच्छता केवल बाहर की नहीं, बल्कि भीतर की भी अनिवार्य है, यही उनका मुख्य संदेश है।
            नदी का शांत और पारदर्शी प्रवाह यह सिखाता है कि सत्य हमेशा गहराई में ही वास करता है।
            'प्रसन्नाम्बु' शब्द जल की उस खुशी को दर्शाता है जो अपनी मर्यादा में रहने से प्राप्त होती है।
            भारद्वाज ने अपने गुरु की इस सूक्ष्म दृष्टि को बड़े ध्यान से सुना और उस सौंदर्य को महसूस किया।
            यह श्लोक हमें प्रकृति के साथ तादात्म्य बिठाने और उसमें मानवीय गुणों को देखने की प्रेरणा देता है।
            वाल्मीकि जी का मन स्वयं उस जल की तरह प्रसन्न था, क्योंकि वे सत्य के करीब पहुँच चुके थे।
        """.trimIndent(),
        englishCommentary = """
            Valmiki says: "O Bharadwaja! Behold this bathing spot; it is so pure and devoid of mud."
            The water is delightful and limpid, just like the 'mind of a good and virtuous man.'
            This metaphor is celebrated as one of the oldest and most beautiful in global literature.
            Just as the mind of a noble person is free from impurities, so is the water of this river.
            The sage is explaining the highest ethical values of life through the medium of nature.
            External purity is significant, but internal transparency is essential—this is his message.
            The calm and transparent flow of the river teaches that Truth always resides in depth.
            The word 'Prasannambu' reflects the inherent joy that comes from remaining within bounds.
            Bharadwaja carefully noted his master's subtle vision and experienced the beauty described.
            This verse inspires us to align with nature and perceive human virtues within the wild.
            Valmiki's own mind was as clear as that water, as he was drawing closer to the ultimate Truth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 6,
        sanskrit = "न्यस्यतां कलशस्तात दीयतां वल्कलं मम ।\nइदमेवावगाहिष्ये तमसातीर्थमुत्तमम् ॥ ६ ॥",
        hindiCommentary = """
            वाल्मीकि जी ने भारद्वाज से कहा—"तात! तुम जल का कलश यहाँ रख दो और मुझे मेरा वल्कल वस्त्र दे दो।"
            वे इसी उत्तम तमसा तीर्थ के जल में गोता लगाने और स्नान करने का विचार कर रहे थे।
            'तात' कहना उनके अपने शिष्य के प्रति अगाध प्रेम और वात्सल्य को दर्शाता है।
            वल्कल वस्त्र ऋषियों की सादगी और भौतिक सुखों के त्याग का एक महान प्रतीक माना गया है।
            स्नान से पहले मुनि का यह संयम और उनकी तैयारी एक पवित्र आध्यात्मिक अनुष्ठान के समान थी।
            तमसा का जल उन्हें आमंत्रित कर रहा था, क्योंकि वह स्थान अब इतिहास रचने वाला था।
            भारद्वाज ने तुरंत आज्ञा का पालन किया, जो एक आदर्श शिष्य की तत्परता का प्रमाण है।
            स्नान केवल शरीर की शुद्धि नहीं था, बल्कि वह आने वाले महान सृजन के लिए आत्मा की तैयारी थी।
            'उत्तमम्' विशेषण यह बताता है कि उस समय तमसा का वह तट ऋषियों के लिए अत्यंत प्रिय था।
            मुनि का प्रत्येक कार्य मर्यादित और शास्त्रसम्मत विधियों के अनुरूप ही संपन्न होता था।
            इस साधारण सी तैयारी के पीछे नियति का एक बहुत बड़ा और गंभीर उद्देश्य छिपा हुआ था।
        """.trimIndent(),
        englishCommentary = """
            Valmiki said to Bharadwaja: "Dear child! Place the water-pot here and hand me my bark garment."
            He intended to immerse himself and bathe in the waters of this excellent Tamasa spot.
            Addressing the disciple as 'Tata' shows his immense paternal affection and deep love.
            The bark garment (Valkala) represents the simplicity and renunciation of material comforts.
            The sage's preparation before the bath was like a disciplined and sacred spiritual ritual.
            The waters of Tamasa seemed to invite him, for that location was about to make history.
            Bharadwaja obeyed the instruction immediately, demonstrating the promptness of a student.
            The bath was not merely for physical hygiene but a soul-cleansing before a grand creation.
            The adjective 'Uttamam' indicates that the bank of Tamasa was highly cherished by sages.
            Every action of Valmiki was conducted within the bounds of propriety and Vedic injunctions.
            Behind this seemingly ordinary preparation lay a massive and serious design of Destiny.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 7,
        sanskrit = "एवमुक्तो भरद्वाजो मुनिनाभाषितेन च ।\nप्रादाद्वल्कलं तस्मै नियतो गुरुवत्सलः ॥ ७ ॥",
        hindiCommentary = """
            गुरु वाल्मीकि के ऐसा कहने पर, गुरुभक्त भारद्वाज ने तुरंत उन्हें वल्कल वस्त्र प्रदान किया।
            भारद्वाज जी 'नियत' (संयमित) थे और उनके मन में गुरु के प्रति अगाध श्रद्धा और प्रेम था।
            'गुरुवत्सल' होना एक शिष्य का सबसे बड़ा आभूषण है, जो उसे ज्ञान पाने का अधिकारी बनाता है।
            उन्होंने बिना किसी विलंब के गुरु की इच्छा को पूरा किया, जो उनकी अटूट सेवा-भावना का प्रमाण है।
            गुरु और शिष्य के बीच यह मूक संवाद और तालमेल प्राचीन शिक्षा पद्धति की आधारशिला थी।
            वल्कल देते समय भारद्वाज के मन में गुरु के प्रति श्रद्धा का एक ज्वार उमड़ रहा था।
            वाल्मीकि जी ने उस वस्त्र को ग्रहण किया और स्नान के लिए नदी के शीतल जल की ओर बढ़े।
            यह क्षण अत्यंत शांत था, जहाँ केवल नदी की कल-कल और पक्षियों का चहकना ही गूँज रहा था।
            अनुशासन और सेवा का यह सुंदर उदाहरण पाठक को आदर्श विद्यार्थी जीवन की याद दिलाता है।
            भारद्वाज का गुरु की सेवा में लीन होना उन्हें भी उस महान फल का भागीदार बनाता है जो रामायण से मिला।
            इस प्रकार, स्नान की प्रारंभिक प्रक्रिया गुरु और शिष्य के सहयोग से पूर्णता को प्राप्त हुई।
        """.trimIndent(),
        englishCommentary = """
            Upon being told thus by Sage Valmiki, the devoted Bharadwaja immediately handed the bark.
            Bharadwaja was 'Niyatah' (disciplined), harboring immense reverence for his master.
            Being 'Guruvatsala' (loving toward the Guru) is the greatest ornament of a true disciple.
            He fulfilled the master's wish without any delay, showcasing his spirit of dedicated service.
            This silent understanding and coordination between Guru and Shishya was the foundation of learning.
            While handing over the garment, a wave of profound respect for the master surged in his heart.
            Valmiki accepted the attire and proceeded toward the cool waters of the river for his bath.
            The moment was intensely quiet, with only the gentle gurgle of the river and birdsong.
            This beautiful example of discipline and service reminds the reader of the ideal student life.
            Bharadwaja's absorption in the Guru's service made him a participant in the epic's fruits.
            Thus, the initial process of the bath was completed properly with the cooperation of both.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 8,
        sanskrit = "स शिष्यहस्तादादाय वल्कलं नियतेन्द्रियः ।\nविचचार ह पश्यंस्तं सर्वतो विपुलं वनम् ॥ ८ ॥",
        hindiCommentary = """
            जितेन्द्रिय वाल्मीकि जी ने शिष्य के हाथ से वल्कल लिया और उस विशाल वन की शोभा देखने लगे।
            वे वन के चप्पे-चप्पे को अपनी दिव्य दृष्टि से निहार रहे थे, जहाँ प्रकृति अपने पूरे यौवन पर थी।
            स्नान से पहले वन का भ्रमण करना मुनि के मन को और भी अधिक एकाग्र और प्रसन्न कर रहा था।
            'विपुलं वनम्' का अर्थ है कि वह वन अत्यंत सघन, प्राचीन और अनगिनत रहस्यों से भरा हुआ था।
            वाल्मीकि जी की दृष्टि केवल बाहरी सुंदरता पर नहीं, बल्कि भीतर छिपे ईश्वरीय संकेतों पर थी।
            एक ऋषि के लिए वन केवल पेड़ों का समूह नहीं, बल्कि साक्षात् ब्रह्म की एक सजीव पाठशाला है।
            उनका विचरण करना उनकी सहजता और शांति का परिचायक था, जो किसी भी चिंता से पूरी तरह मुक्त थे।
            वन के फूल, लताएं और वृक्ष—सभी मुनि का मौन अभिवादन कर रहे थे क्योंकि वे उनके रक्षक थे।
            इस भ्रमण के दौरान ही उनका ध्यान उन पक्षियों की ओर गया जो वहाँ स्वतंत्र विचरण कर रहे थे।
            नियतेन्द्रिय होना यह बताता है कि वन की सुंदरता उन्हें विचलित नहीं, बल्कि अंतर्मुखी बना रही थी।
            यही वह समय था जब वाल्मीकि जी उस ऐतिहासिक और कारुणिक दृश्य के अत्यंत निकट पहुँच चुके थे।
        """.trimIndent(),
        englishCommentary = """
            The master of his senses, Valmiki, took the bark and observed the vast and beautiful forest.
            He gazed at every corner of the woods with his divine vision, where nature was in full bloom.
            Walking through the forest before his bath made the sage's mind even more focused and joyful.
            'Vipulam Vanam' implies that the forest was extremely dense, ancient, and filled with mysteries.
            Valmiki's gaze was fixed not just on external beauty but on the divine signs within nature.
            For a seer, a forest is not just a collection of trees but a living classroom of the Absolute.
            His wandering was a sign of his natural ease and peace, being entirely free from any anxiety.
            The flowers, creepers, and trees of the woods seemed to offer a silent salutation to him.
            It was during this walk that his attention was drawn to the birds wandering freely nearby.
            Being 'Niyatendriya' signifies that the forest's beauty made him more introspective, not distracted.
            This was the exact time when Valmiki had reached very close to that historic and tragic scene.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 9,
        sanskrit = "तस्याभ्याशे तु मिथुनं चरन्तं चारुदर्शनम् ।\nददर्श भगवांस्तत्र क्रौञ्चयोश्चारुनिःस्वनम् ॥ ९ ॥",
        hindiCommentary = """
            वहाँ पास ही भगवान वाल्मीकि ने क्रौञ्च पक्षियों का एक अत्यंत सुंदर और प्रिय जोड़ा देखा।
            वे दोनों पक्षी मधुर स्वर में चहक रहे थे और एक-दूसरे के साथ क्रीड़ा में पूरी तरह मग्न थे।
            उनका स्वरूप अत्यंत 'चारुदर्शनम्' था, जो प्रेम और निर्दोषता की साक्षात् मूरत लग रहे थे।
            प्रकृति में प्रेम का ऐसा सहज और पवित्र प्रदर्शन देखकर मुनि का हृदय आनंद से भर गया।
            क्रौञ्च पक्षी अपनी वफादारी के लिए जाने जाते हैं, जो हमेशा अपने साथी के साथ ही रहते हैं।
            वे दोनों एक-दूसरे में इतने खोए थे कि उन्हें आने वाले किसी भी संकट का लेशमात्र भी आभास नहीं था।
            मुनि ने उन्हें बड़े प्रेम से देखा, क्योंकि वे अहिंसा और शांति के वातावरण के जीवंत प्रतीक थे।
            पक्षी का चहकना उस समय वन के सन्नाटे में एक मधुर स्वर्गीय संगीत की तरह गूँज रहा था।
            यही वह जोड़ा है जिसे आधार बनाकर भविष्य में प्रेम और विरह की महान गाथा लिखी जानी थी।
            वाल्मीकि जी उस समय केवल एक दर्शक थे, पर नियति उन्हें एक महान अनुभव की ओर ले जा रही थी।
            यह दृश्य उस चरम सुख का था जिसके ठीक बाद एक महान और असहनीय दुख प्रहार करने वाला था।
        """.trimIndent(),
        englishCommentary = """
            Nearby, Lord Valmiki beheld an extremely beautiful and lovely pair of Krauncha birds.
            Both birds were chirping in a sweet melody and were absorbed in playful love.
            Their appearance was 'Charudarshanam'—delightful to look at—representing innocent affection.
            Witnessing such a natural and pure display of love in nature filled the sage's heart with bliss.
            Krauncha birds are renowned for their loyalty, traditionally known to always remain together.
            The two were so lost in each other that they had no premonition of any impending danger.
            The sage watched them with great affection, as they were symbols of non-violence and peace.
            The birds' chirping resonated like sweet celestial music in the profound silence of the forest.
            This very pair was to become the foundation for the great saga of love and separation.
            At that moment, Valmiki was merely an observer, but destiny was leading him toward a grand experience.
            This scene represented the peak of happiness, immediately followed by an unbearable strike of grief.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 10,
        sanskrit = "तस्मात्तु मिथुनादेकं काममोहितमग्रतः ।\nजघान पापनिलयो निषादस्तस्य पश्यतः ॥ १० ॥",
        hindiCommentary = """
            उस जोड़े में से एक पक्षी, जो प्रेम में मग्न था, उसे एक निषाद (शिकारी) ने मार गिराया।
            वह निषाद 'पापनिलयो' (पाप का घर) था, जिसने मुनि के देखते-देखते यह जघन्य अपराध किया।
            निर्दोष पक्षी का वध करना एक अत्यंत नीच और क्रूर कार्य था, जिसने वन की शांति भंग कर दी।
            राम-राम का जाप करने वाले वाल्मीकि के सामने हिंसा का यह प्रदर्शन असहनीय और पीड़ादायक था।
            वह पक्षी जो अभी चहक रहा था, अब रक्त से लथपथ होकर जमीन पर छटपटाने लगा था।
            व्याध का यह कार्य उसकी अज्ञानता और क्रूर वृत्ति का परिणाम था, जिसे केवल अपना स्वार्थ दिखा।
            यहाँ 'काममोहित' शब्द यह बताता है कि पक्षी अपनी रक्षा के प्रति पूरी तरह से बेखबर था।
            मुनि की आँखों के सामने एक जीवन का अंत हो गया, जिसने उनके भीतर करुणा का ज्वार पैदा कर दिया।
            यह प्रहार केवल पक्षी पर नहीं था, बल्कि प्रेम और अहिंसा के सिद्धांतों पर एक सीधा प्रहार था।
            निषाद का आना और बाण चलाना नियति की उस योजना का हिस्सा था जो वाल्मीकि को झकझोरने के लिए थी।
            यह श्लोक रामायण के उस 'करुण रस' की पहली और सबसे मर्मस्पर्शी गूँज माना जाता है।
        """.trimIndent(),
        englishCommentary = """
            From that pair, one bird, who was absorbed in love, was struck down by a cruel hunter.
            The hunter was an 'abode of sin,' committing this heinous act right before the sage's eyes.
            Slaying an innocent bird was an extremely vile and cruel deed that shattered the forest's peace.
            For Valmiki, who was established in non-violence, this display of cruelty was utterly unbearable.
            The bird that was chirping moments ago was now covered in blood, struggling for life.
            The hunter's action was the result of his dark nature, seeing only his own selfish gain.
            The term 'Kamamohita' highlights that the bird was entirely unaware of its own safety.
            The end of a life before the sage's eyes generated a massive surge of compassion within his soul.
            This strike was not just on a bird but a direct assault on the principles of Love and Mercy.
            The arrival and the arrow of the hunter were part of Destiny's design to stir Valmiki's heart.
            This verse is the first and most poignant echo of the 'Karuna Rasa' that defines the Ramayana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 11,
        sanskrit = "तं शोणितपरीताङ्गं चेष्टमानं महीतले ।\nभार्या तु निहतं दृष्ट्वा रुराव करुणां गिरम् ॥ ११ ॥",
        hindiCommentary = """
            रक्त से लथपथ और जमीन पर तड़पते हुए अपने पति को देखकर उसकी पत्नी अत्यंत व्याकुल हो गई।
            उसने अपने मरे हुए साथी को देखा और अत्यंत करुण स्वर में विलाप करना शुरू कर दिया।
            उस पक्षी का रोना इतना मर्मस्पर्शी था कि वन की संवेदनाएँ भी जागृत हो उठीं।
            अभी कुछ देर पहले जो प्रेम का उत्सव था, वह अब अचानक मृत्यु के मातम में बदल चुका था।
            पक्षी का विलाप यह सिद्ध करता है कि शोक और वियोग की पीड़ा केवल मनुष्यों तक सीमित नहीं है।
            उसने अपने पंख फड़फड़ाए और अपने साथी को उठाने का निष्फल प्रयास किया, जो अत्यंत दुखद था।
            वाल्मीकि जी इस दृश्य को देख रहे थे और उनका हृदय उस पक्षी के दुख के साथ एकाकार हो गया था।
            'महीतले' (पृथ्वी पर) गिरना यह बताता है कि जीवन का अंत कितना आकस्मिक और कठोर होता है।
            यह रुदन उस महाकाव्य की नींव बनने वाला था जो विरह और मिलन की सबसे बड़ी गाथा है।
            प्रकृति स्वयं उस विलाप में शामिल लग रही थी, मानो सारा वन ही शोक के सागर में डूब गया हो।
            यह श्लोक पाठक के मन में उस दया को जाग्रत करता है जो वाल्मीकि के भीतर उस समय पैदा हुई थी।
        """.trimIndent(),
        englishCommentary = """
            Beholding her mate covered in blood and struggling on the ground, the female bird was distraught.
            Seeing her partner slain, she began to wail in an extremely heart-rending and piteous voice.
            The bird's cry was so moving that it awakened the latent sensitivities of the entire forest.
            The celebration of love that existed moments ago had transformed into the mourning of death.
            The wailing of the bird proves that the agony of grief is not restricted to human beings alone.
            She fluttered her wings, making futile and tragic attempts to revive her fallen companion.
            Valmiki observed this scene, and his heart became one with the immense sorrow of the bird.
            Falling on the 'Mahitale' (earth) signifies how sudden and harsh the end of a life can be.
            This lamentation was destined to become the foundation of the world's greatest story of parting.
            Nature itself seemed to join in that wailing, as if the entire woods had plunged into mourning.
            This verse awakens in the reader's mind that very mercy and compassion which was born in Valmiki.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 12,
        sanskrit = "तथाविधं द्विजं दृष्ट्वा निषादेन निपातितम् ।\nऋषेर्धर्मात्मनस्तस्य कारुण्यं समपद्यत ॥ १२ ॥",
        hindiCommentary = """
            निषाद द्वारा गिराए गए उस पक्षी की ऐसी दयनीय अवस्था देखकर धर्मात्मा ऋषि अत्यंत द्रवित हो उठे।
            वाल्मीकि जी के भीतर अगाध करुणा और दया का एक महासागर हिलोरे लेने लगा था।
            वे स्वयं को उस पक्षी के दुख से अलग नहीं कर पा रहे थे; उनका हृदय उस पीड़ा को साक्षात् महसूस कर रहा था।
            यही वह करुणा है जो किसी साधारण मनुष्य को एक महान 'ऋषि' और 'कवि' में बदल देती है।
            धर्मात्मा होने का अर्थ है—दूसरे के दुख को अपना समझना और अन्याय के प्रति संवेदनशील होना।
            मुनि का ध्यान अब स्नान से हटकर उस हिंसा के शिकार हुए पक्षी और उसके विलाप पर केंद्रित हो गया।
            यह क्षण संसार के लिए एक महान संदेश था कि हिंसा हमेशा केवल दुख और विनाश ही लेकर आती है।
            वाल्मीकि की यह करुणा ही रामायण का बीज मंत्र है, जिस पर भविष्य का पूरा ग्रंथ खड़ा है।
            उन्होंने देखा कि कैसे एक क्रूर शिकारी ने एक सुखी परिवार को पल भर में उजाड़ कर रख दिया।
            यह श्लोक ऋषि के व्यक्तित्व की कोमलता और उनकी उच्च आध्यात्मिक अवस्था का अटूट प्रमाण है।
            अब उनके मुख से जो निकलने वाला था, वह संसार का पहला और सबसे पवित्र वाणी चमत्कार था।
        """.trimIndent(),
        englishCommentary = """
            Witnessing the bird in such a miserable state, brought down by the hunter, the sage was moved.
            A vast ocean of profound compassion and mercy began to surge within Valmiki's soul.
            He could not detach himself from the bird's agony; his heart was experiencing that pain directly.
            This is the very compassion that transforms an ordinary man into a great 'Seer' and 'Poet.'
            Being 'Dharmatma' means perceiving another's sorrow as one's own and opposing injustice.
            The sage's focus shifted from his bath to the victim of violence and the resulting lament.
            This moment conveyed a grand message to the world: that violence only brings grief and ruin.
            Valmiki's compassion is the seed-mantra of the Ramayana, upon which the entire epic rests.
            He witnessed how a cruel hunter had destroyed a happy family unit in a single, heartless instant.
            This verse is a firm testimony to the softness of the sage's persona and his high spiritual state.
            What was about to flow from his lips would be the world's first and most sacred poetic miracle.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 13,
        sanskrit = "ततः करुणवेदित्वादधर्मोऽयमिति द्विजः ।\nनिशाम्य रुदतीं क्रौञ्चीमिदं वचनमब्रवीत् ॥ १३ ॥",
        hindiCommentary = """
            पक्षी के करुण विलाप को सुनकर मुनि ने महसूस किया कि यह एक बहुत बड़ा 'अधर्म' हुआ है।
            वे उस क्रौञ्ची (मादा पक्षी) को रोते हुए देखकर स्वयं को बोलने से नहीं रोक सके।
            उनकी आत्मा में अन्याय के विरुद्ध एक तीव्र विद्रोह और पीड़ा एक साथ उत्पन्न हुई थी।
            'करुणवेदित्वाद्' का अर्थ है कि वे उस करुणा को केवल देख नहीं रहे थे, बल्कि उसे जी रहे थे।
            उन्होंने शिकारी के उस कृत्य को धर्म की मर्यादाओं का पूर्ण उल्लंघन माना।
            जब समाज में मासूमों पर अत्याचार होता है, तो संतों की वाणी ही न्याय की पुकार बनती है।
            मुनि का बोलना केवल एक प्रतिक्रिया नहीं थी, बल्कि यह सत्य की एक अजेय घोषणा थी।
            उन्होंने उस पक्षी के आँसुओं में पूरी मानवता का सामूहिक दुख समाहित देखा था।
            यहाँ से वाल्मीकि के व्यक्तित्व में एक नए आयाम—एक ओजस्वी वक्ता—का उदय होता है।
            यह श्लोक उस मानसिक अवस्था को दर्शाता है जहाँ पीड़ा शब्दों का रूप लेना शुरू करती है।
            अब समय आ गया था कि शिकारी को उसके कुकर्म का बोध कराया जाए और उसे दंडित किया जाए।
        """.trimIndent(),
        englishCommentary = """
            Hearing the piteous wail, the sage realized that a great 'Adharma' (injustice) had occurred.
            Beholding the female Krauncha bird weeping, he could not restrain himself from speaking out.
            A sharp rebellion against injustice and intense pain arose simultaneously within his soul.
            'Karunaveditvat' implies that he was not just witnessing compassion but was embodying it.
            He viewed the hunter's act as a complete violation of the boundaries of moral propriety.
            When the innocent are oppressed in society, the voice of the saint becomes the cry for justice.
            The sage’s speech was not a mere reaction but a formidable declaration of absolute Truth.
            In the tears of that bird, he perceived the collective sorrow of all sentient beings.
            From here, a new dimension—an eloquent speaker—emerges within Valmiki's multifaceted persona.
            This verse illustrates the mental state where intense agony begins to crystallize into words.
            The time had come to make the hunter realize his misdeed and deliver the spiritual sentence.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 14,
        sanskrit = "स तु पश्यन्महातेजाः तं विद्धं द्विजमुत्तमम् ।\nतपोविद्धः क्रुधाविष्टः इदं वचनमब्रवीत् ॥ १४ ॥",
        hindiCommentary = """
            महातेजस्वी मुनि ने उस बाण से बिंधे हुए उत्तम पक्षी को देखा और वे क्रोध से भर गए।
            वे 'तपोविद्धः' (तपस्या के प्रभाव वाले) थे, जिनका क्रोध भी धर्म की रक्षा के लिए जागृत हुआ था।
            अन्याय को देखकर चुप रहना ऋषियों का स्वभाव नहीं है, और वाल्मीकि भी विचलित हो उठे थे।
            उनके भीतर का तेज अब एक शाप के रूप में बाहर निकलने के लिए पूरी तरह सज्ज था।
            शिकारी ने अनजाने में एक ऐसी शक्ति को ललकारा था जो पूरे ब्रह्मांड को हिला सकती थी।
            मुनि का क्रोध व्यक्तिगत स्वार्थ के लिए नहीं, बल्कि उस निरीह पक्षी के हक के लिए था।
            यहाँ 'महातेजाः' विशेषण उनकी आध्यात्मिक शक्ति की प्रचंडता को बहुत स्पष्ट रूप से दर्शाता है।
            उन्होंने देखा कि कैसे एक निर्दोष जीवन को बिना किसी कारण के क्रूरतापूर्वक समाप्त कर दिया गया।
            यह क्रोध वास्तव में करुणा का ही एक दूसरा और रौद्र रूप था, जो पाप का नाश करना चाहता था।
            यह श्लोक उस चरम बिंदु (Climax) का वर्णन है जहाँ से इतिहास की सबसे बड़ी कविता का जन्म हुआ।
            अब मुनि के मुख से वह ऐतिहासिक शब्द निकलने वाले थे जो युगों-युगों तक गूँजने वाले थे।
        """.trimIndent(),
        englishCommentary = """
            The supremely radiant sage looked at the bird pierced by the arrow and was filled with wrath.
            He was 'Tapoviddhah'—powered by penance—whose anger was awakened only for the sake of Dharma.
            It is not the nature of sages to remain silent against injustice, and Valmiki was deeply shaken.
            The brilliance within him was now fully ready to manifest as a powerful and righteous curse.
            The hunter had unknowingly challenged a power that could shake the foundations of the cosmos.
            The sage's wrath was not for any personal gain but for the rights of that helpless creature.
            The epithet 'Mahatejah' clearly illustrates the immense intensity of his spiritual potency.
            He witnessed how an innocent life was brutally ended without any provocation or reason.
            This anger was, in reality, a fierce form of compassion seeking to annihilate sin.
            This verse describes the climax from which the greatest poetry in history was born.
            The historic words that would resonate through the eons were now about to flow from his lips.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 15,
        sanskrit = "मा निषाद प्रतिष्ठां त्वमगमः शाश्वतीः समाः ।\nयत्क्रौञ्चमिथुनादेकमवधीः काममोहितम् ॥ १५ ॥",
        hindiCommentary = """
            यह संसार का पहला 'श्लोक' है, जो वाल्मीकि के हृदय की पीड़ा से अनायास ही फूट पड़ा।
            उन्होंने शिकारी को शाप दिया—"हे निषाद! तुझे युगों-युगों तक कभी भी प्रतिष्ठा प्राप्त न हो।"
            इसका कारण यह था कि उसने प्रेम में मग्न क्रौञ्च पक्षियों के जोड़े में से एक की हत्या की थी।
            यह केवल एक शाप नहीं था, बल्कि अनपेक्षित हिंसा के विरुद्ध करुणा की पहली संगठित गूँज थी।
            'काममोहितम्' शब्द यह दर्शाता है कि पक्षी निर्दोष था और अपने सुखद क्षणों में पूरी तरह लीन था।
            वाल्मीकि जी ने महसूस किया कि प्रेम के क्षण में किसी के प्राण लेना सबसे बड़ा अधर्म और क्रूरता है।
            यह छंदबद्ध वाणी अनायास ही मुनि के मुख से निकली, जो उनके आंतरिक संताप का परिणाम थी।
            इस श्लोक ने ही भविष्य में 'अनुष्टुप छंद' के रूप में समस्त संस्कृत काव्य की आधारशिला रखी।
            यहाँ करुणा (Compassion) ही काव्य की जननी बनी, जो रामायण का मुख्य और प्राण रस है।
            इस शाप में एक गहरा दर्द छिपा है जो निरीह प्राणियों की सुरक्षा की प्रबल वकालत करता है।
            इसी पल से वाल्मीकि एक ऋषि से 'आदि-कवि' (प्रथम कवि) के रूप में पूरी दुनिया में विख्यात हो गए।
        """.trimIndent(),
        englishCommentary = """
            This is the very first 'Shloka' of the world, spontaneously erupting from Valmiki's deep grief.
            He cursed the hunter: "O Nishada, may you never find stability or honor for endless years."
            The reason was the hunter's cruel act of killing one of the birds while it was lost in love.
            This was not just a curse; it was the first organized outcry of compassion against mindless violence.
            The term 'Kamamohitam' emphasizes that the bird was innocent and entirely absorbed in bliss.
            Valmiki felt that taking a life during a moment of love is the ultimate act of unrighteousness.
            This rhythmic, metered speech flowed effortlessly from his lips, born from his intense internal heat.
            This single verse laid the foundation for all Sanskrit poetry in the form of the 'Anushtup' meter.
            Here, Compassion (Karuna) became the mother of Poetry, which is the soul-sentiment of the Ramayana.
            Within this curse lies a profound pain that advocates for the protection of all helpless beings.
            From this precise moment, Valmiki transformed from a mere seer into the 'Adi-Kavi'—the First Poet.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 16,
        sanskrit = "तस्येत्थं ब्रुवतश्चिन्ता बभूव हृदि वीक्षितः ।\nशोकार्तेनास्य शकुनेः किमिदं व्याहृतं मया ॥ १६ ॥",
        hindiCommentary = """
            ऐसा बोलने के बाद मुनि के हृदय में एक गहरी चिंता और विचार उत्पन्न हुआ।
            उन्होंने मन ही मन सोचा—"पक्षी के दुख से पीड़ित होकर यह मैंने क्या कह दिया?"
            वे स्वयं चकित थे कि उनके मुख से ये लयबद्ध शब्द कैसे और क्यों निकल पड़े?
            एक ऋषि के लिए शाप देना कोई सुखद अनुभव नहीं होता, इसलिए वे अपनी वाणी पर विचार करने लगे।
            उन्होंने अनुभव किया कि वह वाणी सामान्य नहीं थी, बल्कि उसमें एक विशेष शक्ति और लय थी।
            वाल्मीकि जी अपनी उस 'भावुकता' का विश्लेषण कर रहे थे जिसने उन्हें बोलने पर विवश किया था।
            यह श्लोक एक महान सृजनकर्ता के उस आंतरिक द्वंद्व को दिखाता है जो रचना के ठीक बाद आता है।
            वे समझ नहीं पा रहे थे कि यह शब्द उनकी बुद्धि के थे या किसी दैवीय प्रेरणा के।
            'शोकार्तेन' शब्द यह बताता है कि उनकी वाणी का मूल आधार उस पक्षी का शोक ही था।
            मुनि की यह आत्म-समीक्षा उनके चरित्र की महानता और उनकी जागरूकता को सिद्ध करती है।
            अनजाने में वे एक ऐसी भाषा और छंद को जन्म दे चुके थे जो आने वाले इतिहास को बदलने वाला था।
        """.trimIndent(),
        englishCommentary = """
            After speaking thus, a deep concern and contemplation arose within the sage's heart.
            He thought to himself: "Distraught by the sorrow of the bird, what have I uttered?"
            He was surprised at how and why these rhythmic words had flowed from his mouth.
            For a seer, uttering a curse is not a pleasant experience, so he began to reflect on his speech.
            He sensed that the speech was not ordinary; it possessed a unique power and cadence.
            Valmiki was analyzing the intense 'emotionality' that had compelled him to speak out.
            This verse illustrates the internal conflict of a great creator that often follows a moment of creation.
            He couldn't fathom whether these words were of his intellect or a divine inspiration.
            The word 'Shokartena' highlights that the very foundation of his speech was the bird's grief.
            This self-reflection of the sage proves the greatness of his character and his state of awareness.
            Unknowingly, he had birthed a language and a meter that was destined to change history.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 17,
        sanskrit = "चिन्तयन् स महाप्राज्ञश्चकार मतिमुत्तमाम् ।\nशिष्यं चैवाब्रवीद्वाक्यमिदं स मुनिपुङ्गवः ॥ १७ ॥",
        hindiCommentary = """
            चिंतन करते हुए उन महाप्राज्ञ मुनि ने अपनी बुद्धि को स्थिर किया और एक उत्तम निश्चय पर पहुँचे।
            मुनियों में श्रेष्ठ वाल्मीकि ने अपने शिष्य (भारद्वाज) को संबोधित करते हुए कुछ वचन कहे।
            वे अपनी उस रहस्यमयी वाणी के रहस्य को सुलझाने की कोशिश कर रहे थे।
            उन्होंने महसूस किया कि जो कुछ भी निकला है, वह सार्थक है और उसे संजोना आवश्यक है।
            मुनि की 'मति' अब उस नवीन छंद के शास्त्रीय विश्लेषण की ओर मुड़ चुकी थी।
            वे अपने शिष्य को इस महान खोज का साक्षी बनाना चाहते थे, ताकि ज्ञान का संरक्षण हो सके।
            यह श्लोक गुरु द्वारा शिष्य को एक महान रहस्य बताने के उस पावन क्षण का चित्रण करता है।
            वाल्मीकि जी की बुद्धिमत्ता (महाप्राज्ञ) ने उस आकस्मिक घटना को एक शास्त्र में बदल दिया।
            उन्होंने समझ लिया था कि यह घटना केवल एक संयोग नहीं, बल्कि किसी बड़े उद्देश्य का संकेत है।
            उनका स्वर अब शांत और गंभीर था, जिसमें एक नई खोज का उत्साह भी छिपा हुआ था।
            शिष्य भारद्वाज भी अपने गुरु के इस परिवर्तित और तेजस्वी स्वरूप को देखकर विस्मित थे।
        """.trimIndent(),
        englishCommentary = """
            Contemplating deeply, the highly wise sage stabilized his mind and reached a noble conclusion.
            The pre-eminent among sages, Valmiki, then addressed certain words to his disciple.
            He was attempting to unravel the mystery behind his own spontaneous and cryptic speech.
            He realized that whatever had emerged was meaningful and required preservation.
            The sage's intellect was now turning toward the technical analysis of this new-found meter.
            He wished to make his disciple a witness to this discovery to ensure the continuity of wisdom.
            This verse depicts the sacred moment of a master revealing a profound secret to his student.
            Valmiki’s immense wisdom (Mahaprajña) transformed a sudden event into a structured science.
            He understood that this incident was not a mere coincidence but a sign of a larger purpose.
            His voice was now calm and grave, hiding within it the excitement of a new revelation.
            The disciple Bharadwaja was awestruck, beholding the transformed and radiant form of his Guru.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 18,
        sanskrit = "पादबद्धोऽक्षरसमस्तन्त्रीलयसमन्वितः ।\nशोकार्तस्य प्रवृत्तो मे श्लोको भवतु नान्यथा ॥ १८ ॥",
        hindiCommentary = """
            वाल्मीकि जी ने कहा—"जो मेरे शोक से उत्पन्न हुआ है, वह चार चरणों वाला (पादबद्धो) 'श्लोक' ही हो।"
            इसमें अक्षरों की संख्या समान है और यह वीणा की लय (तन्त्रीलय) पर गाने योग्य है।
            उन्होंने स्पष्ट घोषणा की कि यह वाणी 'श्लोक' के अलावा और कुछ नहीं मानी जानी चाहिए।
            मुनि ने 'शोक' और 'श्लोक' के बीच के उस अटूट संबंध को यहाँ सदा के लिए स्थापित कर दिया।
            यही वह क्षण था जब 'अनुष्टुप छंद' का नामकरण और उसका स्वरूप परिभाषित हुआ।
            तन्त्रीलय समन्वित होने का अर्थ है कि इसमें संगीत और भाव—दोनों का अद्भुत संगम है।
            वाल्मीकि जी ने स्वीकार किया कि यह रचना उनकी अपनी वेदना की कोख से जन्मी है।
            यह परिभाषा आने वाले हजारों वर्षों के लिए संस्कृत काव्य का प्रमाण (Standard) बन गई।
            उन्होंने अपनी पीड़ा को एक सकारात्मक और कलात्मक दिशा दे दी थी, जो चकित करने वाली थी।
            मुनि की यह घोषणा सिद्ध करती है कि वे केवल एक ऋषि नहीं, बल्कि एक महान छंदशास्त्री भी थे।
            अब यह स्पष्ट था कि रामायण की रचना इसी नवीन और मधुर शैली में होने वाली है।
        """.trimIndent(),
        englishCommentary = """
            Valmiki declared: "Let that which emerged from my grief be known as a 'Shloka,' bound in four feet."
            It possesses an equal number of syllables and is perfectly compatible with the rhythm of the lute.
            He firmly announced that this speech should not be considered anything other than a 'Shloka.'
            The sage established the eternal link between 'Shoka' (sorrow) and 'Shloka' (poetry) here.
            This was the precise moment when the 'Anushtup' meter was formally named and defined.
            Being 'Tantrilaya-samanvitah' implies a marvelous fusion of music and deep sentiment.
            Valmiki acknowledged that this creation was birthed from the womb of his own intense pain.
            This definition became the standard for all Sanskrit poetic compositions for millennia to come.
            He had channeled his agony into a constructive and artistic direction, which was astonishing.
            This declaration proves that he was not just a seer but a master of prosody and aesthetics.
            It was now clear that the Ramayana would be composed in this novel and melodic style.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 19,
        sanskrit = "शिष्यस्तु तस्य ब्रुवतो मुनेर्वाक्यमनुत्तमम् ।\nप्रतिजग्राह संहृष्टस्तस्य तुष्टोऽभवन्मुनिः ॥ १९ ॥",
        hindiCommentary = """
            मुनि के उन श्रेष्ठ और अद्भुत वचनों को उनके शिष्य ने अत्यंत प्रसन्नता के साथ स्वीकार किया।
            भारद्वाज जी ने गुरु की उस नई खोज को तुरंत हृदयंगम कर लिया, जिससे मुनि अत्यंत संतुष्ट हुए।
            शिष्य की इस एकाग्रता और उसकी प्रसन्नता ने वाल्मीकि के आत्मविश्वास को और अधिक बढ़ा दिया।
            एक अच्छे गुरु के लिए उसका सबसे बड़ा संतोष उसके योग्य और समर्पित शिष्य में ही छिपा होता है।
            भारद्वाज ने उस श्लोक को कंठस्थ कर लिया, जो उस समय ज्ञान के संरक्षण का एकमात्र तरीका था।
            यहाँ गुरु की प्रसन्नता (तुष्टो) यह बताती है कि यह विद्या अब सुरक्षित हाथों में पहुँच गई है।
            शिष्य का 'संहृष्ट' होना यह सिद्ध करता है कि वह वाणी सुनने में अत्यंत प्रिय और प्रभावशाली थी।
            यह दृश्य ज्ञान के प्रवाह की उस निरंतरता को दिखाता है जो प्राचीन भारत की विशेषता थी।
            गुरु और शिष्य—दोनों ही उस ऐतिहासिक पल की दिव्यता का अनुभव कर रहे थे।
            वाल्मीकि जी ने महसूस किया कि उनके दुख का फल अब एक महान विद्या के रूप में फलित हो रहा है।
            इस श्लोक के साथ ही 'श्लोक विद्या' का पहला सफल हस्तांतरण (Transfer of Knowledge) संपन्न हुआ।
        """.trimIndent(),
        englishCommentary = """
            The disciple accepted the incomparable and excellent words of the sage with great delight.
            Bharadwaja immediately absorbed his master's new discovery, leaving the sage deeply satisfied.
            The disciple's focus and his evident joy further bolstered Valmiki's own confidence.
            For a true teacher, the greatest satisfaction lies in the growth of a capable and devoted student.
            Bharadwaja memorized the verse instantly, which was the only way of preserving knowledge then.
            The Guru’s satisfaction (Tushtah) indicates that the wisdom had now reached safe and worthy hands.
            The disciple being 'Samhrishtah' proves that the speech was melodic and profoundly impactful.
            This scene illustrates the continuity of the flow of knowledge characteristic of ancient India.
            Both the master and the student were experiencing the divinity of that historic moment.
            Valmiki felt that the fruit of his sorrow was now blossoming into a grand and noble science.
            With this verse, the first successful transmission of the 'Shloka Vidya' was effectively completed.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 20,
        sanskrit = "स च तस्मिन् कृतस्नानस्तीर्थे तस्मिन् यथाविधि ।\nतमेव चिन्तयन्नर्थमुपावर्तत स मुनिः ॥ २० ॥",
        hindiCommentary = """
            तदनंतर मुनि वाल्मीकि ने उस तीर्थ (तमसा घाट) पर विधिपूर्वक अपना स्नान संपन्न किया।
            स्नान के बाद वापस लौटते समय भी मुनि के मन में निरंतर उसी 'श्लोक' के अर्थ का चिंतन चल रहा था।
            वे अपनी उस वाणी के आध्यात्मिक और साहित्यिक महत्व को गहराई से समझने की कोशिश कर रहे थे।
            यद्यपि उनका शरीर नदी से बाहर आ गया था, पर उनका मन अब भी उसी 'करुणा' के सागर में डूबा हुआ था।
            वाल्मीकि जी की एकाग्रता इतनी प्रबल थी कि उन्हें वन के अन्य दृश्यों का अब आभास भी नहीं हो रहा था।
            वे समझ गए थे कि आज की यह घटना उनके जीवन को एक नई और महान दिशा देने वाली है।
            'यथाविधि' शब्द फिर से उनकी नियमप्रियता और धार्मिक निष्ठा की ओर संकेत करता है।
            मुनि का लौटना (उपावर्तत) एक सामान्य क्रिया थी, पर उनका मन एक महाकाव्य की रचना में लीन था।
            यही वह चिंतन था जिसने आगे चलकर 24,000 श्लोकों की रामायण को एक ठोस रूप प्रदान किया।
            वे उस छंद की शक्ति को अपने भीतर महसूस कर रहे थे, जो अब उनकी स्थायी पहचान बनने वाली थी।
            यह श्लोक एक महान तपस्वी के निरंतर चलते रहने वाले उस 'अंतर्मन के मंथन' का सुंदर वर्णन है।
        """.trimIndent(),
        englishCommentary = """
            Thereafter, Sage Valmiki completed his ritual bath at that spot according to the prescribed rules.
            While returning after the bath, the sage continued to contemplate the meaning of that very 'Shloka.'
            He was trying to deeply grasp the spiritual and literary significance of his spontaneous utterance.
            Although his body had emerged from the river, his mind remained submerged in the ocean of compassion.
            Valmiki's concentration was so intense that he was no longer aware of the other forest scenes.
            He realized that today’s incident was destined to provide a new and grand direction to his life.
            The term 'Yathavidhi' again points toward his strict adherence to discipline and religious duty.
            His return (Upavartata) was a physical act, but his soul was already occupied with an epic creation.
            This very contemplation eventually gave solid form to the 24,000 verses of the Ramayana.
            He was feeling the potency of the meter within him, which was to become his permanent identity.
            This verse is a beautiful description of the continuous 'inner churning' of a great and dedicated ascetic.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 21,
        sanskrit = "अथ शिष्यो भरद्वाजः सर्वं तदवधारयत् ।\nतस्य महर्षेः शुश्रूषुः प्रीतोऽभवदतीव सः ॥ २१ ॥",
        hindiCommentary = """
            मुनि वाल्मीकि के प्रिय शिष्य भरद्वाज ने उस पूरे प्रसंग और उस नवीन श्लोक को अपने मन में पूरी तरह धारण कर लिया।
            वे अपने गुरु की सेवा (शुश्रूषुः) में सदैव तत्पर रहने वाले थे और इस नई विद्या को पाकर अत्यंत प्रसन्न (प्रीतः) हुए।
            भरद्वाज जी समझ गए थे कि उनके गुरु के मुख से निकली यह वाणी सामान्य नहीं, बल्कि ईश्वरीय प्रेरणा है।
            प्राचीन काल में ज्ञान को कंठस्थ करना ही उसे सुरक्षित रखने का एकमात्र माध्यम था, जिसे भरद्वाज ने बखूबी निभाया।
            गुरु की प्रसन्नता में ही शिष्य की प्रसन्नता छिपी होती है, और यहाँ दोनों के बीच एक अद्भुत सामंजस्य दिखाई देता है।
            शिष्य का 'अतीव' (अत्यधिक) प्रसन्न होना यह सिद्ध करता है कि वह श्लोक सुनने में बहुत ही मधुर और कर्णप्रिय था।
            भारद्वाज जी ने उस श्लोक को बार-बार दोहराया ताकि उसकी लय और अक्षरों की शुद्धता बनी रहे।
            यह श्लोक गुरु-शिष्य संबंध की उस गहराई को दर्शाता है जहाँ ज्ञान का आदान-प्रदान केवल शब्दों से नहीं, भावों से होता है।
            यहाँ मुनि की 'शुश्रूषा' का अर्थ केवल शारीरिक सेवा नहीं, बल्कि उनके ज्ञान को सहेजने की मानसिक तत्परता भी है।
            इस प्रकार, संसार का पहला श्लोक गुरु के हृदय से निकलकर शिष्य की स्मृति में सुरक्षित हो गया।
            यह क्षण भारतीय काव्य परंपरा के प्रथम 'संग्रहण' (Archiving) का ऐतिहासिक क्षण माना जा सकता है।
        """.trimIndent(),
        englishCommentary = """
            Bharadwaja, the devoted disciple, meticulously absorbed the entirety of that incident and the new verse.
            Ever desirous of serving (Shushrushuh) his great master, he felt an extraordinary sense of joy (Pritah) within.
            Bharadwaja realized that the rhythmic words flowing from his Guru were not mundane but divinely inspired.
            In ancient times, memorization was the singular vessel for preserving wisdom, a task he performed perfectly.
            A disciple’s true fulfillment lies in the master's grace, and here, a marvelous harmony existed between them.
            The disciple being 'Ativa' (exceedingly) happy proves that the verse was melodious and profoundly impactful.
            He repeated the Shloka internally several times to ensure the purity of its meter and phonetic structure.
            This verse illustrates the depth of the Guru-Shishya bond, where wisdom is transmitted through soul-resonance.
            'Shushrusha' here implies not just physical service, but the mental readiness to safeguard the Master's realizations.
            Thus, the world's first Shloka traveled from the Guru’s heart into the safe sanctuary of the disciple’s memory.
            This moment can be viewed as the historic first 'archiving' of classical Sanskrit poetic literature.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 22,
        sanskrit = "अथ स मुनिराजोऽपि कृतशौचो यथाविधि ।\nविवेश स्वाश्रमं धीमान्विचारयन्नमुं श्लोकम् ॥ २२ ॥",
        hindiCommentary = """
            तदनंतर, मुनिराज वाल्मीकि ने अपनी दैनिक शुद्धि और स्नान की क्रिया विधिपूर्वक (यथाविधि) संपन्न की।
            वे अत्यंत बुद्धिमान (धीमान्) थे और स्नान के बाद अपने आश्रम में प्रवेश करते समय भी उसी श्लोक पर विचार कर रहे थे।
            उनके मन की एकाग्रता इतनी गहरी थी कि बाहरी संसार की हलचल उन्हें स्पर्श भी नहीं कर पा रही थी।
            'विचारयन्' शब्द यह बताता है कि वे उस वाणी के व्याकरण और उसके आध्यात्मिक पक्ष का विश्लेषण कर रहे थे।
            आश्रम का शांत वातावरण उनके चिंतन को और अधिक गहराई प्रदान कर रहा था, जो एक महान सृजन की तैयारी थी।
            मुनि यह समझने का प्रयास कर रहे थे कि क्या यह छंद भविष्य में किसी बड़े ग्रंथ का आधार बन सकता है?
            नदी से आश्रम तक की उनकी वह पैदल यात्रा वास्तव में एक दार्शनिक यात्रा थी जिसने छंदशास्त्र को जन्म दिया।
            यथाविधि कार्य करना उनके 'ऋषित्व' का प्रमाण है, जहाँ वे नियमों का उल्लंघन कभी नहीं करते थे।
            उनके भीतर का 'धीमान' (बुद्धिजीवी) पक्ष उस आकस्मिक घटना को एक व्यवस्थित ज्ञान में बदलने में लगा था।
            यह श्लोक एक स्रष्टा (Creator) की उस मानसिक अवस्था को दर्शाता है जो अपनी रचना से स्वयं विस्मित है।
            आश्रम में प्रवेश करते समय उनके चेहरे पर एक दिव्य तेज और एक गंभीर रहस्य की झलक साफ देखी जा सकती थी।
        """.trimIndent(),
        englishCommentary = """
            Thereafter, the king among sages, Valmiki, completed his purificatory rites according to the rules (Yathavidhi).
            Being possessed of high intellect (Dhiman), he entered his hermitage while still contemplating that very Shloka.
            His mental concentration was so profound that the external world could not distract his inner focus.
            The word 'Vicharayan' suggests he was analyzing the grammatical structure and spiritual dimension of the verse.
            The serene atmosphere of the ashram added depth to his thoughts, paving the way for a monumental creation.
            The sage was attempting to discern if this particular meter could serve as the foundation for a larger epic.
            His walk from the river to the ashram was essentially a philosophical journey that birthed classical prosody.
            Acting 'Yathavidhi' (as per rules) is a testament to his sagehood, where discipline was never compromised.
            The 'Dhiman' aspect of his persona was busy converting a spontaneous eruption of emotion into structured science.
            This verse depicts the mental state of a creator who is himself astonished by the magnitude of his creation.
            As he entered the hermitage, a divine radiance and a sense of a profound mystery were visible on his face.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 23,
        sanskrit = "उपविष्टस्तु स मुनिः कृतसन्ध्यो यथाविधि ।\nदध्यौ स एव धैर्यात्मा श्लोकमुत्पन्नमच्युतम् ॥ २३ ॥",
        hindiCommentary = """
            आश्रम में बैठकर मुनि ने अपनी संध्या-वंदना (कृतसन्ध्यो) की क्रिया को भी विधिपूर्वक संपन्न किया।
            वह धैर्यात्मा (धैर्यवान) मुनि स्थिर होकर बैठे और फिर से उसी 'अच्युत' (अविनाशी) श्लोक का ध्यान करने लगे।
            संध्या का समय आत्म-चिंतन के लिए सर्वश्रेष्ठ माना जाता है, और वाल्मीकि जी ने इसी समय को चुना।
            'अच्युतम्' विशेषण यह संकेत देता है कि वह श्लोक अब उनके मन से कभी न मिटने वाला एक सत्य बन चुका था।
            धैर्यवान होने का अर्थ है कि वे जल्दबाजी में नहीं थे, बल्कि उस वाणी की गहराई को पूरी तरह पीना चाहते थे।
            उनका ध्यान केवल शब्दों पर नहीं, बल्कि उस 'करुणा' पर था जिसने उन शब्दों को जन्म दिया था।
            मुनि की यह स्थिरता आने वाले समय में 24,000 श्लोकों के निर्माण की एक मजबूत मानसिक आधारशिला थी।
            संध्या-वंदन के बाद का वह सन्नाटा मुनि के अंतर्मन में गूँज रहे उस श्लोक को और अधिक स्पष्ट कर रहा था।
            वे उस सत्य की खोज में थे जो केवल एक पक्षी के शोक तक सीमित न रहकर पूरी मानवता का शोक हर सके।
            यह श्लोक तपस्या और सृजन (Tapas and Creation) के बीच के उस घनिष्ठ संबंध को बहुत सुंदर ढंग से उजागर करता है।
            वाल्मीकि जी का बैठना (उपविष्टः) एक साधारण क्रिया नहीं, बल्कि एक महान महाकाव्य के समाधिस्थ होने का क्षण था।
        """.trimIndent(),
        englishCommentary = """
            Seated in his hermitage, the sage performed his evening prayers (Sandhya) according to the ancient rites.
            That patient-souled (Dhairyatma) seer then sat steadily and meditated again on that 'Acyuta' (imperishable) Shloka.
            The evening hour is considered optimal for introspection, and Valmiki utilized it for his profound reflection.
            The epithet 'Acyutam' suggests that the verse had become an indelible truth within his consciousness.
            Being 'Dhairyatma' implies he was not in a hurry, but sought to fully assimilate the depth of the utterance.
            His meditation was not merely on the phonetics but on the core 'Compassion' that had birthed the words.
            This stability was the mental cornerstone for the eventual composition of the 24,000 verses of the epic.
            The post-prayer silence amplified the resonance of the Shloka within the inner chambers of his mind.
            He was searching for a truth that transcended the bird's grief to encompass the sorrows of all humanity.
            This verse highlights the intimate connection between spiritual penance (Tapas) and literary creation.
            Valmiki's act of sitting (Upavishtah) was not casual; it was the moment of entering 'Samadhi' for an epic.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 24,
        sanskrit = "आजगाम ततो ब्रह्मा लोककर्ता स्वयं प्रभुः ।\nद्रष्टुं तं मुनिशार्दूलं वेदो लोकगुरुस्तथा ॥ २४ ॥",
        hindiCommentary = """
            उसी समय, संपूर्ण लोकों के कर्ता और वेदों के ज्ञाता स्वयं भगवान ब्रह्मा वहाँ प्रकट हुए।
            लोकगुरु और प्रभु ब्रह्मा जी मुनियों में श्रेष्ठ (मुनिशार्दूलं) वाल्मीकि के दर्शन के लिए स्वयं आए थे।
            ब्रह्मा जी का आना यह सिद्ध करता है कि वाल्मीकि की उस वाणी ने सत्यलोक तक हलचल मचा दी थी।
            यह कोई साधारण मुलाकात नहीं थी, बल्कि ब्रह्मांडीय शक्तियों का एक महान साहित्यिक मिशन के लिए मिलन था।
            ब्रह्मा जी को 'लोककर्ता' कहा गया है, जो यह जानते थे कि संसार को अब रामायण जैसे ग्रंथ की आवश्यकता है।
            वे देखना चाहते थे कि क्या वाल्मीकि उस महान उत्तरदायित्व को निभाने के लिए मानसिक रूप से तैयार हैं?
            मुनि वाल्मीकि की कुटिया अचानक ब्रह्म-तेज से प्रज्वलित हो उठी, जो एक परम मंगलकारी संकेत था।
            ईश्वर का स्वयं भक्त के पास आना यह दर्शाता है कि जब करुणा जाग्रत होती है, तो परमात्मा खिंचा चला आता है।
            नारद के पिता और सृष्टिकर्ता के रूप में ब्रह्मा जी का आगमन रामायण को सर्वोच्च प्रमाणिकता प्रदान करता है।
            यह श्लोक दिव्य और मानवीय जगत के बीच के उस अद्भुत और दुर्लभ मिलन का वर्णन करता है।
            वाल्मीकि जी के लिए यह आश्चर्य और सौभाग्य का विषय था कि स्वयं विधाता उनके सामने खड़े थे।
        """.trimIndent(),
        englishCommentary = """
            At that very moment, Lord Brahma, the self-manifested Creator of the worlds, arrived there in person.
            The Lord of the Universe and the Guru of the Vedas came to see Valmiki, the lion among sages (Munishardulam).
            Brahma's personal arrival signifies that Valmiki’s spontaneous verse had vibrated even in the highest realms.
            This was not a casual visit but a convergence of cosmic forces for a grand literary and spiritual mission.
            Brahma is called 'Lokakarta,' the one who realized that the world now required a scripture like the Ramayana.
            He wished to ascertain if Valmiki was mentally prepared to shoulder the massive responsibility of the epic.
            Valmiki’s humble hut was suddenly illuminated by the 'Brahma-Tejas' (Divine Radiance), an auspicious sign.
            God approaching the devotee proves that when true compassion awakens, Divinity is naturally drawn toward it.
            As the father of Narada and the architect of creation, Brahma's presence grants supreme authority to the epic.
            This verse depicts the rare and marvelous meeting between the transcendental and the human realms.
            For Valmiki, it was a matter of immense wonder and fortune that the Creator Himself stood before him.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 25,
        sanskrit = "तमुत्थाय स मुनिराजः सहशिष्यो विलोक्स्वम् ।\nतपोविद्धः क्रुधाविष्टः इदं वचनमब्रवीत् ॥ २५ ॥",
        hindiCommentary = """
            ब्रह्मा जी को देखते ही मुनिराज वाल्मीकि अपने शिष्यों सहित अत्यंत विस्मित होकर खड़े हो गए।
            यद्यपि वे ब्रह्मा जी के सामने थे, पर उनका मन अब भी उस शिकारी के प्रति क्रोध और दुख से भरा (क्रुधाविष्टः) था।
            उनकी आँखों के सामने अभी भी वह घायल पक्षी तड़प रहा था, जिसने उनकी तपस्या के तेज को विचलित कर दिया था।
            वाल्मीकि जी ने ब्रह्मा जी को प्रणाम तो किया, पर उनके मुख से अनायास ही फिर से वही पीड़ा व्यक्त हुई।
            यह श्लोक मनुष्य के उस 'शोक' की गहराई को दिखाता है जो ईश्वर के सामने भी शांत नहीं हो पा रहा था।
            मुनि का 'तपोविद्ध' होना यह बताता है कि उनकी तपस्या ने उन्हें अत्यंत संवेदनशील और न्यायप्रिय बना दिया था।
            वे ब्रह्मा जी से यह कहना चाहते थे कि संसार में ऐसी क्रूरता क्यों विद्यमान है?
            एक महान मुनि का क्रोध भी व्यक्तिगत नहीं, बल्कि पूरी सृष्टि की पीड़ा का प्रतिनिधित्व कर रहा था।
            ब्रह्मा जी शांत खड़े होकर वाल्मीकि के इस मानसिक उद्वेग और उनकी करुणा को देख रहे थे।
            यह संवाद की एक ऐसी शुरुआत थी जहाँ भक्त अपनी व्यथा सीधे अपने परम पिता के सामने रख रहा था।
            वाल्मीकि जी की यह स्थिति एक सच्चे कवि की स्थिति है जो दुनिया के दुख को अपना मान लेता है।
        """.trimIndent(),
        englishCommentary = """
            Beholding Brahma, the king of sages, Valmiki, rose instantly along with his disciples in utter amazement.
            Although he stood before Brahma, his mind was still occupied with wrath and sorrow (Kruddhavishtah) toward the hunter.
            The image of the struggling, wounded bird still flickered before his eyes, unsettling his ascetic peace.
            Valmiki prostrated before Brahma, yet his speech spontaneously reflected that same lingering agony again.
            This verse illustrates the depth of a human 'Grief' that remained unquenched even in the presence of God.
            The term 'Tapoviddhah' suggests that his penance had rendered him intensely sensitive and deeply committed to justice.
            He subconsciously wished to question the Creator: Why does such cruelty exist within the creation?
            The wrath of a great sage was not personal; it represented the collective suffering of the entire cosmos.
            Lord Brahma stood silently, observing Valmiki’s mental agitation and the purity of his immense compassion.
            It was the beginning of a dialogue where the seeker lays bare his distress directly before the Great Father.
            Valmiki’s state here is that of a true poet—one who adopts the world’s sorrow as his own personal pain.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 26,
        sanskrit = "तं शिष्यसहितं दृष्ट्वा मुनिराजमुपस्थितम् ।\nपूजयामास धर्मज्ञः सहशिष्यो महामुनिः ॥ २६ ॥",
        hindiCommentary = """
            जब मुनिराज वाल्मीकि ने देखा कि साक्षात् लोकपितामह ब्रह्मा उनके आश्रम में उपस्थित हैं, तो वे विस्मित रह गए।
            उन्होंने अपने शिष्यों के साथ मिलकर धर्म के ज्ञाता ब्रह्मा जी का विधि-विधान से अर्घ्य और पाद्य द्वारा पूजन किया।
            वाल्मीकि जी के हृदय में एक ओर ईश्वर के दर्शन का आनंद था, तो दूसरी ओर उस पक्षी का दुख अब भी ताजा था।
            गुरु और शिष्यों का एक साथ उठकर स्वागत करना प्राचीन भारतीय आश्रम पद्धति के शिष्टाचार को दर्शाता है।
            ब्रह्मा जी का तेज इतना प्रबल था कि आश्रम के वृक्ष और लताएं भी वंदना करती हुई प्रतीत हो रही थीं।
            पूजन की यह प्रक्रिया मुनि के अनुशासन और उनके आध्यात्मिक परिपक्वता का एक सुंदर उदाहरण है।
            भले ही मुनि का मन अशांत था, पर उन्होंने अपने अतिथ्य सत्कार के धर्म को पूरी निष्ठा से निभाया।
            शिष्य भारद्वाज भी अपने गुरु के साथ मिलकर मौन भाव से इस दिव्य उपस्थिति की सेवा में लग गए थे।
            यह श्लोक सिद्ध करता है कि एक महान मुनि के लिए कर्तव्य और मर्यादा किसी भी मानसिक उद्वेग से ऊपर होती है।
            ब्रह्मा जी ने प्रसन्नतापूर्वक उस सत्कार को स्वीकार किया, क्योंकि वे वाल्मीकि की पात्रता को जानते थे।
            इस क्षण ने कुटिया को एक साधारण स्थान से उठाकर दिव्य ज्ञान के वैश्विक केंद्र में बदल दिया था।
        """.trimIndent(),
        englishCommentary = """
            Beholding the Great Progenitor Brahma standing within his hermitage, Sage Valmiki was struck with awe.
            Along with his disciples, the knower of Dharma performed the formal worship using traditional rituals.
            In Valmiki's heart, the joy of seeing the Divine coexisted with the lingering trauma of the bird's death.
            The simultaneous rising of the master and disciples illustrates the refined etiquette of ancient ashram life.
            Brahma's aura was so potent that even the trees and creepers seemed to lean in respectful salutation.
            This act of worship is a testament to the sage’s discipline and his profound spiritual maturity.
            Even though his mind was internally turbulent, he fulfilled his duty of hospitality with absolute sincerity.
            The disciple Bharadwaja silently assisted his Guru, sensing the cosmic magnitude of the visitor.
            This verse proves that for a true sage, duty and propriety (Maryada) transcend any personal emotional state.
            Lord Brahma graciously accepted the honor, fully aware of Valmiki's worthiness and internal state.
            This moment transformed the humble hut into a global epicenter of divine knowledge and revelation.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 27,
        sanskrit = "उपविष्टे तदा तस्मिन् साक्षाल्लोकपितामहे ।\nदध्यौ स एव मुनिः श्लोकमुत्पन्नमच्युतम् ॥ २७ ॥",
        hindiCommentary = """
            जब साक्षात् लोकपितामह ब्रह्मा जी अपने आसन पर विराजमान हो गए, तब मुनि वाल्मीकि मौन हो गए।
            परंतु उनका मन अब भी उसी 'अच्युत' (अविनाशी) श्लोक का ध्यान (दध्यौ) कर रहा था जो नदी तट पर प्रकट हुआ था।
            सृष्टिकर्ता के सामने होते हुए भी मुनि की चेतना उस 'करुण रस' से मुक्त नहीं हो पा रही थी।
            यह एकाग्रता दर्शाती है कि वह वाणी उनके हृदय में कितनी गहराई तक जड़ें जमा चुकी थी।
            ब्रह्मा जी शांत भाव से मुनि के चेहरे को देख रहे थे, जहाँ भक्ति और शोक का एक अद्भुत मिश्रण था।
            मुनि का ध्यान करना केवल एक विचार नहीं था, बल्कि वह उस छंद की लय और शक्ति का अनुभव था।
            'अच्युतम्' शब्द यहाँ अत्यंत महत्वपूर्ण है, जो उस श्लोक की शाश्वतता और उसकी सत्यता को प्रकट करता है।
            वे सोच रहे थे कि क्या वह श्राप देना उनके तपस्वी जीवन के लिए उचित था या यह केवल एक आवेग था?
            आश्रम का वह वातावरण उस समय अत्यंत गंभीर था, जहाँ एक महान सत्य शब्दों में ढलने की प्रतीक्षा कर रहा था।
            वाल्मीकि जी की यह स्थिति एक शोधकर्ता की तरह थी जो अपनी ही खोज के रहस्य को सुलझाना चाहता था।
            यह श्लोक मुनि की गहरी अंतर्मुखता और उनके वैचारिक संघर्ष का एक जीवंत और मर्मस्पर्शी चित्रण है।
        """.trimIndent(),
        englishCommentary = """
            Once the Great Progenitor Brahma had seated Himself, Sage Valmiki fell into a deep, reflective silence.
            However, his mind remained obsessively focused on that 'Acyuta' (imperishable) Shloka born at the river.
            Even in the immediate presence of the Creator, the sage's consciousness could not escape the grip of compassion.
            This intense focus demonstrates how deeply those rhythmic words had rooted themselves in his soul.
            Brahma observed the sage’s face, which reflected a complex blend of supreme devotion and lingering grief.
            The sage’s meditation was not just a passing thought but a profound immersion in the power of the meter.
            The term 'Acyutam' is vital here, signifying the eternal validity and the indestructible nature of that verse.
            He wondered if uttering that curse was appropriate for his ascetic path or if it was a mere emotional surge.
            The atmosphere of the hermitage was heavy and solemn, waiting for a grand Truth to take definitive form.
            Valmiki's state resembled that of a researcher trying to decode the mystery of his own revelation.
            This verse provides a vivid and touching depiction of the sage's intense introspection and mental conflict.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 28,
        sanskrit = "किमिदं व्याहृतं पूर्वं शोकार्तेन मया प्रभो ।\nतथाविधं द्विजं दृष्ट्वा निषादेन निपातितम् ॥ २८ ॥",
        hindiCommentary = """
            वाल्मीकि जी ने अत्यंत विनम्रता के साथ ब्रह्मा जी से पूछा—"हे प्रभो! उस समय मैंने यह क्या कह दिया था?"
            "एक निषाद द्वारा उस निर्दोष पक्षी (द्विजं) को गिराए जाते देख, मैं शोक से व्याकुल (शोकार्तेन) हो उठा था।"
            मुनि अपनी उस मानसिक अवस्था का वर्णन कर रहे थे जब उनकी संवेदनाओं ने शब्दों का रूप ले लिया था।
            वे जानना चाहते थे कि क्या एक ऋषि का इतना भावुक होना और श्राप देना धर्मसंगत है?
            पक्षी का गिरना मुनि के लिए केवल एक घटना नहीं, बल्कि निर्दोष प्रेम पर क्रूरता का सीधा प्रहार था।
            'प्रभो' संबोधन ब्रह्मा जी के प्रति उनके पूर्ण समर्पण और उनके मार्गदर्शन की याचना को प्रकट करता है।
            वे स्पष्ट कर रहे थे कि उनकी वाणी क्रोध से नहीं, बल्कि उस निरीह प्राणी के दुख से उत्पन्न हुई थी।
            यह श्लोक एक महान आत्मा की ईमानदारी को दिखाता है जो ईश्वर के सामने अपने हर कृत्य की समीक्षा चाहती है।
            वाल्मीकि जी ने स्वीकार किया कि उस दृश्य ने उनके अंतर्मन को पूरी तरह से झकझोर कर रख दिया था।
            वे उस 'अज्ञात प्रेरणा' को समझने का प्रयास कर रहे थे जिसने उनके मुख से छंदबद्ध वाणी निकलवाई थी।
            यह संवाद मानवीय संवेदना और ईश्वरीय विधान के बीच के गहरे संबंध को समझने की एक महान कोशिश है।
        """.trimIndent(),
        englishCommentary = """
            With immense humility, Valmiki inquired of Brahma: "O Lord! What did I utter earlier in that state?"
            "Beholding that innocent bird (Dvija) struck down by a hunter, I was overwhelmed by grief (Shokartena)."
            The sage was describing the psychological state where his raw empathy had crystallized into words.
            He sought to know if it was righteous for an ascetic to be so emotionally moved as to utter a curse.
            For the sage, the bird's fall was not just an incident but a direct assault of cruelty upon innocent love.
            The address 'Prabho' signifies his total surrender to Brahma and a desperate plea for higher guidance.
            He clarified that his speech originated not from personal malice but from the sorrow of a helpless creature.
            This verse showcases the honesty of a great soul seeking a divine review of his own spontaneous actions.
            Valmiki admitted that the tragic scene had completely unsettled the foundations of his inner peace.
            He was attempting to comprehend the 'unknown inspiration' that forced rhythmic speech from his lips.
            This dialogue is a profound attempt to understand the link between human sensitivity and divine law.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 29,
        sanskrit = "पुनरेव हि तं श्लोकं जगौ स मुनिपुङ्गवः ।\nमा निषाद प्रतिष्ठां त्वमगमः शाश्वतीः समाः ॥ २९ ॥",
        hindiCommentary = """
            मुनियों में श्रेष्ठ वाल्मीकि ने ब्रह्मा जी के सामने फिर से उसी 'श्लोक' का सस्वर गान (जगौ) किया।
            उन्होंने वही शब्द दोहराए—"हे निषाद! तुझे युगों-युगों तक कभी भी प्रतिष्ठा प्राप्त न हो।"
            ब्रह्मा जी को वह छंद सुनाना वास्तव में उस पीड़ा को फिर से जीना और उसे ईश्वर को समर्पित करना था।
            यद्यपि मुनि शांत थे, पर उस वाणी को दोहराते समय उनके स्वर में वही पुरानी गूँज और ओज था।
            यह श्लोक का दोहराव सिद्ध करता है कि वह वाणी अब मुनि के अस्तित्व का अभिन्न हिस्सा बन चुकी थी।
            'मुनिपुङ्गवः' विशेषण यह बताता है कि वे मुनियों में श्रेष्ठ थे, फिर भी उनकी वाणी एक पीड़ित की पुकार थी।
            उन्होंने दिखाया कि कैसे वह श्राप एक विशेष लय और अक्षरों की समानता (Meter) में बंधा हुआ था।
            वह गान केवल एक शिकायत नहीं थी, बल्कि करुणा के माध्यम से अधर्म को दी गई एक चुनौती थी।
            ब्रह्मा जी बड़े ध्यान से उस लय को सुन रहे थे, जिसे उन्होंने ही मुनि के भीतर से प्रकट किया था।
            वाल्मीकि जी को आभास हो रहा था कि यह शब्द उनके अपने नहीं, बल्कि किसी उच्च सत्ता के हैं।
            यह क्षण संसार के प्रथम छंदबद्ध काव्य की आधिकारिक 'प्रस्तुति' (Presentation) का क्षण था।
        """.trimIndent(),
        englishCommentary = """
            The pre-eminent among sages, Valmiki, then recited (Jagau) that very 'Shloka' once more before Brahma.
            He repeated the fateful words: "O Nishada, may you never find stability or honor for endless years."
            Reciting that meter to Brahma was like reliving the pain and surrendering it entirely to the Divine.
            Though the sage appeared calm, his voice held the same resonant power and vigor as it did at the river.
            The repetition of the verse proves that the utterance had now become an integral part of the sage's being.
            The epithet 'Munipungavah' implies his superior status, yet his voice was that of a grieving witness.
            He demonstrated how the curse was bound in a specific rhythm and a symmetry of syllables (Meter).
            The recitation was not a mere complaint but a formidable challenge to unrighteousness through compassion.
            Lord Brahma listened intently to the rhythm, which He Himself had manifested through the sage's soul.
            Valmiki was sensing that these words were not his own but belonged to a much higher, cosmic authority.
            This moment was the formal 'presentation' of the world's first classical poetic composition to its Creator.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 30,
        sanskrit = "तपोविद्धः क्रुधाविष्टः इदं वचनमब्रवीत् ।\nअहो गीतस्य माधुर्यं श्लोकानां च विशेषतः ॥ ३० ॥",
        hindiCommentary = """
            तपस्या के प्रभाव वाले वाल्मीकि, जो अब भी उस क्रोध और दुख में स्थित थे, उन्होंने अपनी व्यथा कही।
            परंतु साथ ही, वे उस गीत के माधुर्य और उन श्लोकों की विशेष बनावट को देखकर स्वयं विस्मित (अहो) थे।
            'अहो' शब्द उनकी उस वैज्ञानिक और कलात्मक जिज्ञासा को व्यक्त करता है जो उनके दुख के साथ चल रही थी।
            वे एक कवि की तरह अपनी ही रचना की सुंदरता और उसकी 'लय' पर मुग्ध हो रहे थे।
            तपोविद्ध होने का अर्थ है कि उनकी तपस्या ने ही इस महान सत्य को वाणी देने का सामर्थ्य प्रदान किया था।
            क्रुधाविष्ट होना यह बताता है कि उनका क्रोध अभी शांत नहीं हुआ था, क्योंकि न्याय होना अभी बाकी था।
            उन्होंने अनुभव किया कि पीड़ा को जब छंद में बांधा जाता है, तो वह एक दिव्य मिठास (माधुर्य) बन जाती है।
            विशेषतः श्लोकों की रचना उनकी बुद्धि के परे एक चमत्कार की तरह मुनि को प्रतीत हो रही थी।
            यह श्लोक एक स्रष्टा की उस दोहरी मानसिक स्थिति को दिखाता है—जहाँ वह दुखी भी है और अपनी कला पर चकित भी।
            मुनि ने ब्रह्मा जी से संकेत माँगा कि इस अद्भुत वाणी का आगे क्या उपयोग होना चाहिए?
            यहीं से ब्रह्मा जी का वह महान आदेश शुरू होता है जो रामायण के लेखन का मुख्य आधार बना।
        """.trimIndent(),
        englishCommentary = """
            Valmiki, powered by penance but still occupied by that wrath and sorrow, expressed his distress.
            Yet, simultaneously, he was astonished (Aho) by the sweetness of the song and the unique structure of the verses.
            The exclamation 'Aho' reflects his scientific and artistic curiosity that ran parallel to his grief.
            Like a true poet, he was enchanted by the aesthetic beauty and the 'cadence' of his own creation.
            Being 'Tapoviddhah' suggests that his long years of austerity had granted him the potency to voice this Truth.
            Being 'Kruddhavishtah' implies that his righteous anger had not subsided, as justice was yet to be done.
            He realized that when intense pain is bound within a meter, it transforms into a divine sweetness (Madhurya).
            The specific construction of the Shlokas appeared as a miracle to the sage, beyond his own intellect.
            This verse illustrates the dual state of a creator's mind—simultaneously suffering and amazed by the craft.
            The sage sought a sign from Lord Brahma regarding the future purpose of this extraordinary speech.
            This sets the stage for Brahma’s grand command, which became the cornerstone for the writing of the Ramayana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 31,
        sanskrit = "शोकार्तेन मया शकुनेः किमिदं व्याहृतं प्रभो ।\nमा निषाद प्रतिष्ठां त्वमगमः शाश्वतीः समाः ॥ ३१ ॥",
        hindiCommentary = """
            वाल्मीकि जी ने ब्रह्मा जी से निवेदन किया—"हे प्रभु! पक्षी के शोक से दुखी होकर मैंने यह क्या कह दिया?"
            उन्होंने वही ऐतिहासिक श्लोक ब्रह्मा जी के सामने फिर से दोहराया—"मा निषाद प्रतिष्ठां..."।
            वे ईश्वर से यह स्पष्टीकरण चाहते थे कि क्या उनका यह क्रोध और शाप देना उचित था?
            मुनि को डर था कि कहीं उनकी तपस्या का तेज इस शाप के कारण क्षीण न हो गया हो।
            यह श्लोक मुनि की सत्यनिष्ठा और उनके आत्म-विश्लेषण की पराकाष्ठा को दर्शाता है।
            वे ब्रह्मा जी को वह 'छंद' सुना रहे थे जो बिना किसी प्रयास के उनके मुख से निकला था।
            'प्रभो' कहकर उन्होंने ब्रह्मा जी की सर्वज्ञता को स्वीकार किया और मार्गदर्शन की प्रार्थना की।
            यह क्षण संसार के पहले काव्य की 'ऑडिटिंग' या ईश्वरीय समीक्षा के समान था।
            वाल्मीकि जी यह जानना चाहते थे कि क्या उनकी वाणी में केवल क्रोध था या कोई गहरा सत्य भी?
            ब्रह्मा जी ने उस श्लोक को बड़े ध्यान से सुना, क्योंकि वे जानते थे कि यही वह 'बीज' है जिससे रामायण उगेगी।
            यहाँ से कथा का वह मोड़ आता है जहाँ ब्रह्मा जी मुनि की शंका को एक महान वरदान में बदल देंगे।
        """.trimIndent(),
        englishCommentary = """
            Valmiki submitted to Brahma: "O Lord! Distraught by the bird's grief, what have I uttered?"
            He then repeated that historic verse before Brahma: "Ma Nishada Pratishtham...".
            He sought clarification from the Divinity: Was his anger and the subsequent curse justified?
            The sage feared that the potency of his penance might have been diminished by uttering a curse.
            This verse demonstrates the peak of the sage’s integrity and his relentless self-analysis.
            He was reciting to Brahma the 'meter' that had effortlessly flowed from his lips during the incident.
            By addressing him as 'Prabho,' he acknowledged Brahma’s omniscience and prayed for higher guidance.
            This moment was akin to a divine review or 'auditing' of the very first classical poetic composition.
            Valmiki wished to know if his speech contained only raw wrath or if it held some profound cosmic truth.
            Lord Brahma listened to the Shloka with great focus, for He knew this was the 'Seed' of the Ramayana.
            From here begins the turn where Brahma transforms the sage’s doubt into a monumental divine blessing.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 32,
        sanskrit = "तमुवाच ततो ब्रह्मा प्रहसन्मुनिपुङ्गवम् ।\nश्लोक एवास्त्वयं बद्धो नात्र कार्या विचारणा ॥ ३२ ॥",
        hindiCommentary = """
            तब भगवान ब्रह्मा ने मुनि श्रेष्ठ वाल्मीकि से हँसते हुए (प्रहसन्) कहा—"यह वाणी 'श्लोक' ही होगी।"
            उन्होंने स्पष्ट किया कि इस छंदबद्ध रचना के विषय में अब और अधिक विचार या चिंता करने की आवश्यकता नहीं है।
            ब्रह्मा जी की वह हँसी अत्यंत सुखद थी, जिसने वाल्मीकि के मन के सारे बोझ को एक पल में उतार दिया।
            'श्लोक एवास्त्वयं'—सृष्टिकर्ता ने स्वयं उस नवीन काव्य विधा का नामकरण कर दिया और उसे मान्यता दी।
            उन्होंने सिद्ध किया कि 'शोक' जब मर्यादा में रहकर व्यक्त होता है, तो वह 'श्लोक' बन जाता है।
            ब्रह्मा जी की स्वीकृति ने वाल्मीकि की वाणी को वेदों के समान पवित्र और प्रामाणिक बना दिया था।
            यह ईश्वरीय मुस्कान वाल्मीकि के लिए सबसे बड़ा पुरस्कार और आगामी कार्य के लिए प्रेरणा थी।
            विचारणा न करने का अर्थ है कि यह रचना पूर्णतः सत्य और ईश्वरीय इच्छा के अनुकूल है।
            ब्रह्मा जी जानते थे कि यह श्लोक केवल एक शुरुआत है, जिसका विस्तार अनंत होने वाला है।
            यह श्लोक संस्कृत साहित्य के 'मैग्ना कार्टा' के समान है, जिसने काव्य को विधिवत जन्म दिया।
            अब वाल्मीकि को समझ आ गया कि उनकी पीड़ा वास्तव में एक महान दिव्य योजना का हिस्सा थी।
        """.trimIndent(),
        englishCommentary = """
            Then, Lord Brahma, smilingly (Prahasan) addressed the eminent sage Valmiki: "This shall be known as a Shloka."
            He clarified that there was no need for further deliberation or anxiety regarding this rhythmic creation.
            Brahma's smile was profoundly comforting, instantly lifting the heavy burden from Valmiki's troubled mind.
            'Shloka Evastvayam'—the Creator Himself christened and validated the new poetic genre.
            He demonstrated that when 'Grief' (Shoka) is expressed within the bounds of propriety, it transforms into 'Poetry' (Shloka).
            Brahma’s approval rendered Valmiki’s speech as sacred and authoritative as the eternal Vedas themselves.
            This divine smile served as Valmiki’s greatest reward and the ultimate inspiration for his future work.
            The command not to deliberate implies that the creation was perfectly aligned with Truth and Divine Will.
            Brahma was aware that this single verse was merely the beginning of an infinite spiritual expansion.
            This verse acts as the 'Magna Carta' of Sanskrit literature, formally inaugurating the birth of classical poetry.
            Valmiki now understood that his personal agony was a catalyst for a grand, cosmic divine design.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 33,
        sanskrit = "मच्छन्दादेव ते ब्रह्मन् प्रवृत्तेयं सरस्वती ।\nरामस्य चरितं कृत्स्नं कुरु त्वं ऋषिसत्तम ॥ ३३ ॥",
        hindiCommentary = """
            ब्रह्मा जी ने कहा—"हे ब्रह्मन्! तुम्हारी यह वाणी (सरस्वती) मेरी ही इच्छा से प्रकट हुई है।"
            "अतः हे ऋषिश्रेष्ठ! अब तुम इसी छंद में श्री राम के संपूर्ण चरित्र (कृत्स्नं) की रचना करो।"
            यह रामायण की रचना के लिए दिया गया साक्षात् ईश्वरीय आदेश (Divine Mandate) था।
            ब्रह्मा जी ने स्पष्ट किया कि वाल्मीकि केवल एक माध्यम थे, जबकि प्रेरणा स्वयं विधाता की थी।
            'सरस्वती' शब्द यहाँ वाणी की पवित्रता और उसके ज्ञानमयी स्वरूप को दर्शाता है।
            श्री राम का चरित्र लिखने का अर्थ था—संसार को धर्म का एक जीवित और साकार विग्रह प्रदान करना।
            'कृत्स्नं' शब्द यह बताता है कि उन्हें राम के जीवन के हर पहलू—गुप्त और प्रकट—का वर्णन करना है।
            वाल्मीकि जी को अब अपने जीवन का मुख्य लक्ष्य और ब्रह्मांडीय उत्तरदायित्व प्राप्त हो चुका था।
            यह श्लोक रामायण के लेखन की औपचारिक अनुमति और उसके ईश्वरीय स्रोत की पुष्टि करता है।
            ब्रह्मा जी ने वाल्मीकि को एक साधारण कवि से उठाकर 'आदि-कवि' के उच्चासन पर बैठा दिया।
            अब वाल्मीकि की लेखनी को स्वयं विधाता का बल और सरस्वती का प्रकाश प्राप्त हो गया था।
        """.trimIndent(),
        englishCommentary = """
            Brahma declared: "O Brahmana! This speech (Saraswati) of yours has emerged solely through my divine will."
            "Therefore, O best among seers! Compose the entire life-story (Kritsnam) of Sri Rama in this very meter."
            This was the direct Divine Mandate issued for the formal composition of the Ramayana.
            Brahma clarified that Valmiki was merely the instrument, while the original inspiration was the Creator's own.
            The word 'Saraswati' here signifies the absolute purity and the wisdom-filled nature of the utterance.
            Writing Rama’s story meant providing the world with a living, breathing personification of Dharma.
            The term 'Kritsnam' implies that he was to narrate every aspect of Rama's life—both the hidden and the manifest.
            Valmiki had now received the primary mission of his life and his definitive cosmic responsibility.
            This verse confirms the formal authorization for the Ramayana and establishes its divine origin.
            Brahma elevated Valmiki from a mere sage to the exalted status of the 'Adi-Kavi' (The First Poet).
            Valmiki’s pen was now empowered by the strength of the Creator and the illumination of the Goddess of Wisdom.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 34,
        sanskrit = "धर्मात्मनो भगवतो लोके रामस्य धीमतः ।\nवृत्तं कथय धीरस्य यथा ते नारदाच्छ्रुतम् ॥ ३४ ॥",
        hindiCommentary = """
            ब्रह्मा जी ने वाल्मीकि को आदेश दिया—"संसार में जो साक्षात् भगवान के अवतार हैं, उन धर्मात्मा, बुद्धिमान और धीर श्री राम की कथा कहो।"
            "जिस प्रकार तुमने देवर्षि नारद के मुख से उनके संपूर्ण वृत्तांत को सुना है, उसी के आधार पर इस महाकाव्य की रचना करो।"
            ब्रह्मा जी का यह आदेश यह सिद्ध करता है कि राम कोई साधारण मनुष्य नहीं, बल्कि स्वयं 'भगवान' और धर्म के रक्षक हैं।
            'यथा ते नारदाच्छ्रुतम्' का अर्थ है कि वाल्मीकि को कथा की मूल संरचना वही रखनी थी जो नारद जी ने उन्हें संक्षेप में बताई थी।
            सृष्टिकर्ता चाहते थे कि राम का 'धीर' (धैर्यवान) और 'धीमान' (बुद्धिमान) स्वरूप मानवता के लिए एक शाश्वत आदर्श बने।
            नारद जी ने केवल सूचना दी थी, परंतु अब ब्रह्मा जी वाल्मीकि को उस सूचना को 'काव्य' में बदलने का आधिकारिक दायित्व सौंप रहे थे।
            एक ऋषि द्वारा दूसरे ऋषि से प्राप्त ज्ञान का यह कैसा अद्भुत विस्तार है, जहाँ बीज नारद का था और वृक्ष वाल्मीकि का होने वाला था।
            यह श्लोक सिद्ध करता है कि रामायण किसी कवि की मनगढ़ंत कल्पना नहीं, बल्कि एक श्रुति-आधारित (सुना हुआ) ईश्वरीय सत्य है।
            ब्रह्मा जी के शब्द वाल्मीकि के भीतर की उस हिचकिचाहट को पूरी तरह मिटा रहे थे जो एक नए छंद को लेकर उनके मन में थी।
            अब वाल्मीकि केवल एक दृष्टा नहीं रह गए थे, बल्कि वे भगवान के चरित्र को दुनिया तक पहुँचाने वाले 'आधिकारिक दूत' बन चुके थे।
        """.trimIndent(),
        englishCommentary = """
            Lord Brahma commanded Valmiki: "Narrate the life-story of the righteous, wise, and courageous Rama, who is the Supreme Lord incarnate in this world."
            "Compose this grand epic precisely in accordance with the narrative you have heard directly from the lips of the divine Sage Narada."
            Brahma's command conclusively proves that Rama is not a mere mortal hero, but 'Bhagavan' (God) and the ultimate protector of Dharma.
            'Yatha te Naradacchrutam' implies that Valmiki was to strictly maintain the core structural integrity of the summary provided by Narada.
            The Creator intended for Rama’s 'Dhira' (patient) and 'Dhiman' (wise) character to become an eternal standard for all of humanity.
            Narada had merely planted the seed of information; Brahma was now officially authorizing Valmiki to cultivate it into a massive poetic tree.
            This is a marvelous expansion of wisdom transmitted from one seer to another, where the inspiration is divine and the execution is human.
            This verse certifies that the Ramayana is not the fabricated imagination of a poet, but a 'Shruti-based' (heard) transcendental truth.
            Brahma’s empowering words completely erased any lingering hesitation Valmiki might have harbored regarding the newly discovered meter.
            Valmiki was no longer just an observer; he had been formally elevated to the status of the 'Official Messenger' of the Lord's divine pastimes.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 35,
        sanskrit = "रहस्यं च प्रकाशं च यद्वृत्तं तस्य धीमतः ।\nरामस्य सहसौमित्रे राक्षसानां च सर्वशः ॥ ३५ ॥",
        hindiCommentary = """
            ब्रह्मा जी ने आगे कहा—"बुद्धिमान श्री राम और लक्ष्मण (सौमित्र) के साथ-साथ राक्षसों का जो भी वृत्तांत है, चाहे वह गुप्त (रहस्यं) हो या प्रकट (प्रकाशं)।"
            "वह सब कुछ तुम्हें पूर्ण रूप से ज्ञात होगा, और तुम उनके हर कर्म का बिना किसी बाधा के वर्णन कर सकोगे।"
            एक इतिहासकार केवल वही लिख सकता है जो समाज में घटित हुआ हो (प्रकाशं), पर वाल्मीकि को 'रहस्य' जानने का भी वरदान मिला।
            लक्ष्मण के निस्वार्थ त्याग और राक्षसों के उन कूटनीतिक षड्यंत्रों को भी मुनि देख सकेंगे जो बंद कमरों में रचे गए थे।
            राक्षसों की मानसिकता, उनके भय और उनके अहंकार को समझे बिना रामायण का युद्ध वर्णन अधूरा रहता।
            'सहसौमित्रे' शब्द यह बताता है कि राम का चरित्र लक्ष्मण के बिना पूर्ण नहीं हो सकता, दोनों का जीवन एक-दूसरे से गुंथा हुआ है।
            ब्रह्मा जी का यह वरदान वाल्मीकि को एक सामान्य लेखक से उठाकर एक 'त्रिकालदर्शी' (Past, Present, Future seer) बना देता है।
            मुनि अब किसी भी पात्र के मन के भीतर चल रहे विचारों और भावनाओं को भी ठीक उसी तरह पढ़ सकेंगे जैसे वे बाहर की घटनाएं देखते हैं।
            यह श्लोक रामायण की उस 'मनोवैज्ञानिक गहराई' (Psychological Depth) की नींव रखता है जो इसे विश्व साहित्य में अद्वितीय बनाती है।
            विधाता ने सुनिश्चित कर दिया कि सत्य का कोई भी अंश—चाहे वह कितना ही गहरा क्यों न छिपा हो—वाल्मीकि की दृष्टि से अछूता न रहे।
        """.trimIndent(),
        englishCommentary = """
            Brahma continued: "Whatever transpired concerning the wise Rama, Lakshmana (Saumitra), and the demons, whether in absolute secrecy (Rahasyam) or in public (Prakasham)..."
            "...all of those events and deeds shall be fully revealed to you, enabling you to chronicle them without any obstruction."
            An ordinary historian can only record what happens in the public eye (Prakasham), but Valmiki was blessed to perceive even the deepest 'secrets.'
            The sage would be able to witness Lakshmana's silent sacrifices and the dark, diplomatic conspiracies hatched by demons behind closed doors.
            The description of the epic war would remain incomplete without a thorough understanding of the demons' psychology, fear, and colossal ego.
            The term 'Saha-saumitre' indicates that Rama’s character is inseparable from Lakshmana; their lives are divinely interwoven.
            Brahma’s boon instantly elevates Valmiki from a mere scribe to an omniscient 'Trikaldarshi' (Seer of past, present, and future).
            The sage would now be able to read the internal thoughts and unspoken emotions of any character just as clearly as he observed external events.
            This verse lays the critical foundation for the profound 'Psychological Depth' that makes the Ramayana uniquely supreme in global literature.
            The Creator ensured that no fragment of Truth—no matter how deeply concealed—would ever escape the penetrating spiritual gaze of Sage Valmiki.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 36,
        sanskrit = "वैदेह्याश्चैव यद्वृत्तं प्रकाशं यदि वा रहः ।\nतच्चाप्यविदितं सर्वं विदितं ते भविष्यति ॥ ३६ ॥",
        hindiCommentary = """
            ब्रह्मा जी ने सीता जी के विषय में विशेष रूप से कहा—"विदेहराज-नंदिनी सीता (वैदेही) का जो भी वृत्तांत है, चाहे वह सबके सामने हुआ हो या एकांत (रहः) में।"
            "वह सब जो अब तक अज्ञात (अविदितं) है, वह भी तुम्हारी योग-दृष्टि से तुम्हें पूरी तरह से ज्ञात (विदितं) हो जाएगा।"
            सीता का जीवन रामायण का सबसे करुण, पवित्र और रहस्यमयी हिस्सा है, जिसे समझना किसी साधारण मनुष्य के वश की बात नहीं थी।
            अशोक वाटिका में सीता जी ने जो मानसिक यातनाएं सहीं और जिस प्रकार रावण को फटकारा, वह सब एकांत (रहः) में हुआ था।
            ब्रह्मा जी ने वाल्मीकि को वह 'दिव्य-चक्षु' (Divine Eye) प्रदान किया जिससे वे सीता के आंसुओं और उनके पतिव्रत धर्म को साक्षात् देख सकें।
            सीता के बिना राम की कथा का कोई अर्थ नहीं है; वे ही इस महाकाव्य की धुरी और इसकी असली शक्ति हैं।
            'विदितं ते भविष्यति' यह वरदान है कि वाल्मीकि की चेतना को देश और काल की कोई भी सीमा रोक नहीं पाएगी।
            वाल्मीकि जी अब माता सीता की उस परम पवित्रता को शब्दों में पिरोने में सक्षम हो गए थे जो अग्नि से भी अधिक शुद्ध थी।
            यह श्लोक नारी-सम्मान और सीता के चरित्र की गरिमा को रामायण के केंद्र में अत्यंत प्रमुखता से स्थापित करता है।
            ब्रह्मा जी का यह आशीर्वाद ही वह कारण है जिससे हम आज अशोक वाटिका के उन मार्मिक और गुप्त संवादों को पढ़ पाते हैं।
        """.trimIndent(),
        englishCommentary = """
            Brahma specifically mentioned Sita, stating: "Whatever occurred in the life of Vaidehi (Sita), whether in the open or in the deepest solitude (Rahah)..."
            "...all that is currently unknown (Aviditam) to the world shall become completely and vividly known (Viditam) to your yogic vision."
            Sita’s life is the most poignant, pure, and profound segment of the Ramayana, comprehending which is beyond ordinary human capacity.
            The mental agony she endured in the Ashoka Grove and the fiery rebukes she delivered to Ravana all took place in absolute isolation (Rahah).
            Brahma granted Valmiki the 'Divine Eye' required to personally witness Sita’s silent tears and the invincible power of her chastity.
            Without Sita, the narrative of Rama holds no meaning; she is the absolute axis and the driving spiritual force of this great epic.
            'Viditam te bhavishyati' is the boon ensuring that Valmiki’s consciousness would never be hindered by the limitations of time and space.
            Valmiki was now fully empowered to translate Mother Sita's supreme sanctity—a purity greater than fire itself—into immortal words.
            This verse places immense prominence on the dignity of women and positions Sita's impeccable character at the very heart of the Ramayana.
            Brahma’s blessing is the sole reason humanity today can read and experience those deeply moving and highly secretive dialogues of the Ashoka Grove.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 37,
        sanskrit = "श्रुतं ते यन्मया पूर्वं तदप्यत्र प्रकाशताम् ।\nअविदितं च यत्किञ्चिद् विदितं ते भविष्यति ॥ ३७ ॥",
        hindiCommentary = """
            ब्रह्मा जी ने अपने वरदान को पूर्ण करते हुए कहा—"पूर्व में देवर्षि नारद द्वारा जो भी तुमने सुना है, वह तुम्हारे इस महाकाव्य में प्रकाशित हो।"
            "और इसके अतिरिक्त जो कुछ भी अज्ञात (अविदितं) रह गया है, वह भी मेरी कृपा से तुम्हारे ज्ञान में पूरी तरह स्पष्ट (विदितं) हो जाएगा।"
            यह श्लोक ज्ञान की पूर्णता का उद्घोष है। जो बातें नारद जी ने संक्षेप में बताई थीं, वे अब वाल्मीकि की लेखनी से विस्तार पाएंगी।
            'प्रकाशताम्' का अर्थ है कि राम का चरित्र केवल वाल्मीकि के मन तक सीमित नहीं रहेगा, बल्कि वह पूरे संसार को आलोकित करेगा।
            ब्रह्मा जी ने मुनि को आश्वासन दिया कि रामायण लिखते समय उन्हें कभी भी किसी तथ्य या घटना को लेकर कोई शंका नहीं होगी।
            अदृश्य को देखने की यह शक्ति वाल्मीकि को एक साधारण कवि से विश्व का प्रथम 'आर्ष-कवि' (Seer-Poet) बना देती है।
            यह ईश्वरीय गारंटी थी कि रामायण में कोई भी प्रसंग अधूरा, भ्रामक या सत्य से परे नहीं होगा।
            मुनि का अंतर्मन अब एक ऐसे दर्पण में बदल चुका था जिसमें त्रेता युग का पूरा इतिहास प्रतिबिंबित होने वाला था।
            सृष्टिकर्ता का यह वरदान वाल्मीकि के लिए सबसे बड़ा संबल था, जिसने उनके भीतर छिपे 'शोक' को एक रचनात्मक शक्ति में बदल दिया।
            इसके ठीक बाद (श्लोक 38 में), ब्रह्मा जी उन्हें विश्वास दिलाते हैं कि उनके काव्य का कोई भी शब्द असत्य नहीं होगा।
        """.trimIndent(),
        englishCommentary = """
            Concluding His boon, Brahma said: "Whatever you have previously heard from Sage Narada, let it be brilliantly illuminated (Prakashatam) in this epic."
            "And whatever minor details have remained unknown (Aviditam) to you shall also become flawlessly clear and known (Viditam) through my grace."
            This verse is the absolute declaration of perfect knowledge. The brief summary provided by Narada would now find its grand expansion through Valmiki’s pen.
            'Prakashatam' implies that Rama’s character will not remain confined to Valmiki’s mind; it is destined to illuminate the entire world.
            Brahma assured the sage that while composing the Ramayana, he would never face any doubt or confusion regarding any fact or incident.
            The power to perceive the invisible elevates Valmiki from a conventional poet to the world's very first 'Arsha-Kavi' (Seer-Poet).
            This was a divine guarantee that no episode within the Ramayana would ever be incomplete, misleading, or divorced from absolute Truth.
            The sage's inner consciousness had now transformed into a pristine mirror, perfectly reflecting the entire history of the Treta Yuga.
            The Creator’s boon acted as the greatest support for Valmiki, converting his latent 'Grief' into an unstoppable, highly creative cosmic force.
            Immediately following this (in Shloka 38), Brahma assures him that not a single word in his epic poetry will ever be proven false.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 36,
        sanskrit = "रहस्यं च प्रकाशं च यद्वृत्तं तस्य धीमतः ।\nरामस्य सहसौमित्रे राक्षसानां च सर्वशः ॥ ३६ ॥",
        hindiCommentary = """
            ब्रह्मा जी ने वरदान दिया कि बुद्धिमान राम, लक्ष्मण (सौमित्रे) और राक्षसों का सारा रहस्य और प्रकट वृत्तांत तुम्हें ज्ञात होगा।
            चाहे वह घटना सबके सामने घटी हो या अत्यंत गुप्त (रहस्यं) स्थान पर, वह तुम्हारी दृष्टि से नहीं छिपेगी।
            यह 'दिव्य-दृष्टि' का वरदान था, जिसके बिना रामायण जैसे सूक्ष्म ग्रंथ की रचना संभव नहीं थी।
            वाल्मीकि जी को अब उन गुप्त संवादों और भावनाओं का भी ज्ञान होने वाला था जो केवल पात्रों के हृदय में थे।
            सौमित्र (लक्ष्मण) के त्याग और उनकी अटूट सेवा का हर सूक्ष्म विवरण वाल्मीकि को स्पष्ट दिखने लगा।
            राक्षसों के षडयंत्र और उनकी मानसिक स्थिति का भी पूर्ण ज्ञान उन्हें ब्रह्मा की कृपा से प्राप्त हुआ।
            'सर्वशः' शब्द बताता है कि ज्ञान में कोई भी कमी या अधूरापन नहीं रहेगा, वह पूर्ण और अखंड होगा।
            यह वरदान रामायण को केवल एक कहानी नहीं, बल्कि एक 'ऐतिहासिक सत्य' (Fact) की गरिमा प्रदान करता है।
            मुनि की आँखों के सामने अब पूरा घटनाक्रम एक चलचित्र की तरह जीवंत होने वाला था।
            ब्रह्मा जी ने सुनिश्चित किया कि वाल्मीकि का काव्य सत्य की कसौटी पर हमेशा खरा उतरे।
            इस श्लोक के साथ ही वाल्मीकि एक त्रिकालदर्शी कवि के रूप में पूरी तरह से प्रतिष्ठित हो गए।
        """.trimIndent(),
        englishCommentary = """
            Brahma bestowed the boon: "All secrets and manifest deeds of the wise Rama, Lakshmana, and the demons shall be known to you."
            "Whether an event occurred in public or in the deepest privacy (Rahasyam), it shall not be hidden from your vision."
            This was the boon of 'Divine Vision,' without which a subtle and nuanced epic like the Ramayana could not be written.
            Valmiki was now empowered to know the secret dialogues and the innermost feelings held within the characters' hearts.
            Every subtle detail of Saumitra’s (Lakshmana’s) sacrifice and his tireless service became crystal clear to Valmiki.
            The conspiracies of the demons and their complex psychological states were also revealed through Brahma’s grace.
            The word 'Sarvashah' indicates that the knowledge would be complete and seamless, without any gaps or ambiguities.
            This boon grants the Ramayana the dignity of a 'Historical Truth' rather than just a fictional narrative.
            The entire sequence of events was set to become as vivid as a motion picture before the sage's spiritual eyes.
            Brahma ensured that Valmiki’s poetry would eternally stand the test of absolute Truth.
            With this verse, Valmiki was fully established as a seer-poet with the power to witness the past, present, and future.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 38,
        sanskrit = "न ते वागनृता काव्ये काचिदत्र भविष्यति ।\nकुरु रामकथां पुण्यां श्लोकबद्धां मनोरमाम् ॥ ३८ ॥",
        hindiCommentary = """
            ब्रह्मा जी ने वाल्मीकि को एक और अत्यंत महत्वपूर्ण वरदान दिया—"इस महाकाव्य में तुम्हारी कोई भी बात (वाक्) असत्य (अनृता) नहीं होगी।"
            "अतः तुम श्री राम की इस परम पवित्र और मन को हरने वाली (मनोरमाम्) कथा को श्लोकों में आबद्ध करो।"
            एक इतिहासकार या कवि के लिए सबसे बड़ा डर यह होता है कि कहीं उसकी रचना में कोई अशुद्धि या कल्पना का मिश्रण न हो जाए।
            ब्रह्मा जी ने इस डर को हमेशा के लिए समाप्त कर दिया; उन्होंने रामायण को पूर्णतः 'सत्य' का प्रमाण-पत्र दे दिया।
            'काव्ये काचिदत्र' का अर्थ है कि इस ग्रंथ का एक-एक शब्द, एक-एक प्रसंग और एक-एक भावना पूर्ण रूप से प्रामाणिक होगी।
            वाल्मीकि जी की वाणी अब केवल एक मनुष्य की वाणी नहीं रही थी, बल्कि वह साक्षात् विधाता की मुहर से युक्त ईश्वरीय सत्य बन चुकी थी।
            'पुण्यां' विशेषण बताता है कि यह कथा केवल मनोरंजन के लिए नहीं है, बल्कि इसके पठन-पाठन से जन्म-जन्मांतर के पाप नष्ट होते हैं।
            ब्रह्मा जी का यह आदेश वाल्मीकि के लिए जीवन का सर्वोच्च उद्देश्य बन गया।
            यह श्लोक वाल्मीकि रामायण की उस निर्विवाद प्रामाणिकता को स्थापित करता है, जिसके कारण इसे हिंदू धर्म का आधार स्तंभ माना जाता है।
            मुनि अब पूरी तरह से निर्भय हो चुके थे, क्योंकि स्वयं सत्य के रचयिता ने उनकी लेखनी का मार्गदर्शन करने का वचन दे दिया था।
        """.trimIndent(),
        englishCommentary = """
            Lord Brahma bestowed another immensely crucial boon upon Valmiki: "Not a single word of yours in this epic shall ever be false."
            "Therefore, compose this supremely holy and enchanting (Manoramam) story of Rama, binding it into beautiful rhythmic verses."
            The greatest fear of any historian or poet is the unintentional inclusion of inaccuracies or purely fictional elements in their work.
            Brahma permanently eradicated this fear, granting the Ramayana the ultimate certificate of absolute and pristine 'Truth.'
            'Kavye Kachidatra' signifies that every single word, episode, and emotion captured within this scripture will be undeniably authentic.
            Valmiki’s speech was no longer merely human; it had transformed into divine truth, stamped with the Creator's own authority.
            The adjective 'Punyam' (holy) indicates that this narrative is not for mere entertainment; reading it destroys the sins of countless lifetimes.
            This direct command from Brahma became the highest and most profound purpose of Sage Valmiki's existence.
            This verse firmly establishes the unquestionable authenticity of the Valmiki Ramayana, making it a foundational pillar of Hindu Dharma.
            The sage was now completely fearless, for the very Creator of Truth had vowed to guide his poetic pen.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 39,
        sanskrit = "यावत्स्थास्यन्ति गिरयः सरितश्च महीतले ।\nतावद्रामायणकथा लोकेषु प्रचरिष्यति ॥ ३९ ॥",
        hindiCommentary = """
            ब्रह्मा जी ने वह ऐतिहासिक और शाश्वत भविष्यवाणी की—"जब तक इस पृथ्वी (महीतले) पर पर्वत और नदियाँ विद्यमान रहेंगी।"
            "तब तक रामायण की यह पावन कथा संसार के लोगों के बीच निरंतर प्रचलित और जीवित रहेगी।"
            यह श्लोक रामायण की 'अमरता' की सबसे बड़ी, सबसे प्रसिद्ध और आधिकारिक घोषणा माना जाता है।
            पर्वत और नदियाँ प्रकृति के सबसे स्थायी तत्व हैं, और रामायण को उन्हीं के समान शाश्वत और अजर-अमर बताया गया है।
            इसका सीधा अर्थ है कि समय का कोई भी प्रलय, सामाजिक परिवर्तन या सांस्कृतिक पतन इस कथा की महिमा को कभी मिटा नहीं पाएगा।
            रामायण केवल एक ग्रंथ नहीं, बल्कि एक सांस्कृतिक चेतना है जो पीढ़ी-दर-पीढ़ी एक अविरल नदी की तरह बहती रहेगी।
            'लोकेषु' शब्द यह संकेत देता है कि यह कथा केवल मनुष्यों तक सीमित नहीं रहेगी, बल्कि तीनों लोकों में देवों और गंधर्वों द्वारा भी पूजी जाएगी।
            जब तक मानवता का अस्तित्व है, राम के आदर्श उसे अंधकार में दिशा दिखाते रहेंगे और प्रेरित करते रहेंगे।
            ब्रह्मा जी ने वाल्मीकि को आश्वस्त किया कि उनका यह महान साहित्यिक श्रम कभी भी व्यर्थ नहीं जाएगा और वह पूरी तरह कालातीत होगा।
            यह भविष्यवाणी आज हजारों वर्षों बाद भी शत-प्रतिशत सच साबित हो रही है, क्योंकि रामायण की प्रासंगिकता समय के साथ और बढ़ी है।
            यह श्लोक पाठक के भीतर इस ग्रंथ के प्रति एक अगाध सम्मान और उसकी लौकिक-अलौकिक शाश्वतता का दृढ़ विश्वास जगाता है।
        """.trimIndent(),
        englishCommentary = """
            Brahma made the historic and eternal prophecy: "As long as the mountains and rivers endure upon this earth (Mahitale)..."
            "...so long shall the sacred story of the Ramayana seamlessly circulate and remain alive among the people of the world."
            This verse is universally regarded as the greatest, most famous, and authoritative declaration of the Ramayana's 'Immortality.'
            Mountains and rivers represent the most enduring elements of nature, and the epic is equated directly with their timeless longevity.
            This implies that no deluge of time, social upheaval, or cultural shift will ever be able to erase the glory of this divine narrative.
            The Ramayana is not just a book but a cosmic consciousness that will flow unceasingly like a river from generation to generation.
            The term 'Lokeshu' suggests that this story will be revered not just by humans, but across the three worlds by gods and celestials.
            As long as humanity exists, Rama's ideals will act as a lighthouse, continuing to guide and inspire the human heart through darkness.
            Brahma assured Valmiki that his monumental literary labor would never be in vain and would utterly transcend the boundaries of time.
            This prophecy remains remarkably and absolutely true today, as the relevance and reach of the Ramayana have only expanded over millennia.
            This verse instills in the reader a profound respect for the text and a firm belief in its earthly and celestial eternal nature.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 40,
        sanskrit = "यावद्रामायणकथा त्वत्कृता प्रचरिष्यति ।\nतावदूर्ध्वमधश्चैव लोकेषु निवत्स्यसि ॥ ४० ॥",
        hindiCommentary = """
            ब्रह्मा जी ने वाल्मीकि को उनका व्यक्तिगत वरदान देते हुए कहा—"जब तक तुम्हारे द्वारा रची गई (त्वत्कृता) यह रामायण कथा संसार में प्रचलित रहेगी।"
            "तब तक तुम ऊर्ध्व लोकों (स्वर्ग आदि) और अधोलोकों (पृथ्वी आदि) में स्वतंत्र रूप से निवास करोगे और अमर रहोगे।"
            यह एक स्रष्टा (Creator) के लिए सबसे बड़ा पुरस्कार है कि उसकी कृति ही उसके अस्तित्व और उसकी अमरता का शाश्वत माध्यम बन जाए।
            'ऊर्ध्वमधश्चैव' का अर्थ है कि वाल्मीकि की कीर्ति और उनकी आध्यात्मिक उपस्थिति पूरे ब्रह्मांड में किसी भी भौतिक सीमा से परे होगी।
            शरीर नश्वर है, परंतु वाल्मीकि ने रामायण के रूप में एक ऐसा 'वाङ्मय शरीर' (Body of Words) धारण कर लिया जिसका कभी अंत नहीं हो सकता।
            ब्रह्मा जी ने सुनिश्चित किया कि भगवान राम के नाम के साथ 'आदि-कवि' वाल्मीकि का नाम भी हमेशा के लिए अभिन्न रूप से जुड़ जाए।
            जब भी कोई राम-कथा पढ़ेगा, वह वाल्मीकि के प्रति अपनी कृतज्ञता अवश्य प्रकट करेगा, यही उनकी वास्तविक अमरता है।
            यह श्लोक सिद्ध करता है कि जो व्यक्ति धर्म और सत्य के लिए महान कार्य करता है, प्रकृति स्वयं उसे काल के प्रभाव से मुक्त कर देती है।
            मुनि की वह तपस्या और उनकी वह करुणा अब एक ऐसे सार्वभौमिक फल में बदल चुकी थी जिसका रसास्वादन पूरी मानवता करने वाली थी।
            ब्रह्मा जी के इन वचनों ने वाल्मीकि को एक अत्यंत दिव्य गौरव और हृदय में परम शांति प्रदान की।
        """.trimIndent(),
        englishCommentary = """
            Bestowing a personal boon, Brahma told Valmiki: "As long as this Ramayana story composed by you (Tvatkrita) circulates in the world."
            "Until then, you shall reside freely and immortally in the upper realms (Heavens) and the lower realms (Earth)."
            This is the ultimate reward for any creator—that their masterpiece becomes the eternal medium of their own existence and immortality.
            'Urdhvamadhashchaiva' implies that Valmiki’s fame and his spiritual presence will transcend all physical boundaries across the entire cosmos.
            The physical body is mortal, but Valmiki assumed a 'Vangmaya Sharira' (Body of Words) in the form of the epic, which can never perish.
            Brahma ensured that the name of the 'Adi-Kavi' (First Poet) Valmiki would be inextricably and eternally linked with the name of Lord Rama.
            Whenever anyone reads the story of Rama, they inherently express gratitude to Valmiki; this is the essence of his true immortality.
            This verse proves that nature herself liberates those who perform monumental deeds for the sake of Dharma and Truth from the effects of time.
            The sage’s penance and his profound compassion had now blossomed into a universal fruit that all of humanity was destined to taste.
            Brahma’s absolute and empowering words granted Valmiki an exceedingly divine status and a sense of profound spiritual tranquility.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 41,
        sanskrit = "इत्युक्त्वा भगवान् ब्रह्मा तत्रैवान्तरधीयत ।\nततः सशिष्यो भगवान् मुनिर्विस्मयमाययौ ॥ ४१ ॥",
        hindiCommentary = """
            मुनि वाल्मीकि को यह महान आदेश और आशीर्वाद देकर (इत्युक्त्वा), भगवान ब्रह्मा वहीं पर अचानक अंतर्ध्यान (लुप्त) हो गए।
            सृष्टिकर्ता के इस प्रकार अचानक चले जाने के बाद, भगवान मुनि वाल्मीकि और उनके सभी शिष्य अत्यंत विस्मय (आश्चर्य) से भर गए।
            ब्रह्मा जी का जाना यह संकेत था कि ईश्वरीय प्रेरणा का कार्य पूरा हो चुका है, और अब वाल्मीकि को अपने मानवीय और तपोबल से कर्म करना है।
            विधाता ने मुनि के भीतर वह असीम आत्म-विश्वास जगा दिया था जो एक 24,000 श्लोकों के महाकाव्य को रचने के लिए अनिवार्य था।
            आश्रम की कुटिया में जो दिव्य प्रकाश फैला था, वह अब वाल्मीकि के अंतर्मन और उनकी लेखनी में पूरी तरह समा चुका था।
            'विस्मयमाययौ' यह बताता है कि यह पूरी घटना—क्रौंच वध से लेकर ब्रह्मा के आगमन तक—इतनी तीव्र थी कि कोई भी साधारण मन इसे समझ नहीं सकता था।
            शिष्य भारद्वाज और अन्य लोग मौन खड़े थे; उन्होंने अनुभव किया कि उनके गुरु अब केवल एक तपस्वी नहीं, बल्कि साक्षात् सरस्वती के अवतार बन गए हैं।
            भगवान का लुप्त होना उनकी लीला का हिस्सा था, जहाँ वे भक्त को महान कर्म करने के लिए स्वतंत्र और सशक्त छोड़ देते हैं।
            वाल्मीकि जी उस शून्य को देख रहे थे जहाँ अभी साक्षात् विधाता खड़े थे, और उनका हृदय अगाध कृतज्ञता से भर उठा था।
            यह क्षण एक महान दिव्य संवाद के समापन और संसार के सबसे बड़े ग्रंथ के प्रकटीकरण का पवित्र संधि-काल था।
        """.trimIndent(),
        englishCommentary = """
            Having imparted this grand command and blessing (Ityuktva) to Sage Valmiki, Lord Brahma vanished from that very spot.
            Following the sudden departure of the Creator, the venerable Sage Valmiki and all his disciples were completely overwhelmed with wonder (Vismaya).
            Brahma’s departure signaled that the phase of divine inspiration was complete; it was now time for Valmiki to act using his own penance and skill.
            The Creator had ignited that boundless self-confidence within the sage which was absolutely indispensable for composing a 24,000-verse epic.
            The divine light that had illuminated the humble hermitage had now fully absorbed itself into Valmiki’s inner consciousness and his poetic pen.
            'Vismayamayayau' indicates that the entire sequence—from the bird's tragic death to Brahma's arrival—was so intense it bewildered the ordinary mind.
            Disciple Bharadwaja and others stood in silent awe; they realized their Guru was no longer just an ascetic, but the incarnate vessel of Goddess Saraswati.
            The Lord’s vanishing was a part of His divine play, leaving the devotee completely empowered and independent to execute the assigned monumental duty.
            Valmiki gazed at the void where the Creator had just stood, his heart overflowing with an unfathomable and deep sense of gratitude.
            This moment served as the sacred bridge between the conclusion of a cosmic dialogue and the physical manifestation of the world's greatest scripture.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 42,
        sanskrit = "तस्य शिष्यास्ततः सर्वे जगुः श्लोकमिमं पुनः ।\nमुहुर्मुहुः प्रीयमाणाः प्राहुश्च भृशविस्मिताः ॥ ४२ ॥",
        hindiCommentary = """
            ब्रह्मा जी के जाने के बाद, वाल्मीकि जी के सभी शिष्यों ने उस प्रथम 'श्लोक' (मा निषाद...) को एक साथ फिर से गाया।
            वे उस नए छंद की मधुरता से बार-बार (मुहुर्मुहुः) प्रसन्न (प्रीयमाणाः) हो रहे थे और अत्यधिक आश्चर्यचकित होकर आपस में बातें कर रहे थे।
            यह दृश्य अत्यंत मार्मिक और ऐतिहासिक है—जो पंक्तियाँ कुछ देर पहले एक गहरे 'शोक' और दुख में निकली थीं, वे अब 'आनंद' का स्रोत बन गई थीं।
            शिष्यों का उस श्लोक को गाना यह सिद्ध करता है कि विद्या का हस्तांतरण तुरंत और सफलतापूर्वक हो गया था।
            वे बार-बार उस लय को दोहरा रहे थे, मानो वे इतिहास के उस पहले संगीत का पूरी तरह से रसास्वादन करना चाहते हों।
            आश्रम का वह शोकपूर्ण सन्नाटा अब 'अनुष्टुप छंद' की सुरीली और सामूहिक ध्वनि से टूट चुका था।
            वाल्मीकि जी अपने शिष्यों को गाते हुए देखकर समझ गए कि ब्रह्मा जी का वरदान सत्य हो गया है; यह काव्य मनमोहक है।
            'भृशविस्मिताः' बताता है कि शिष्यों के लिए यह किसी जादू से कम नहीं था कि कैसे क्रोध और पीड़ा से इतनी सुंदर कविता का जन्म हो सकता है।
            यह श्लोक काव्य-कला के उस प्रभाव को दर्शाता है जो मनुष्य के दुख को कलात्मक आनंद (Aesthetic Joy) में बदल देता है।
            रामायण का गायन यहीं से, वाल्मीकि के आश्रम से ही, विधिवत रूप से आरंभ हो गया था।
        """.trimIndent(),
        englishCommentary = """
            Following Brahma’s departure, all of Valmiki's disciples collectively sang that very first 'Shloka' (Ma Nishada...) once again.
            They were repeatedly (Muhurmuhuh) delighted (Priyamanah) by the sweetness of this new meter and conversed with each other in immense astonishment.
            This scene is profoundly poignant and historic—the very lines that had erupted from deep 'Grief' moments ago had now transformed into a source of 'Joy.'
            The disciples singing the verse proves that the transmission of this newly discovered knowledge was immediate and completely successful.
            They repeated the rhythm again and again, as if wanting to fully relish and absorb the very first structured music in human history.
            The mournful silence of the hermitage was now thoroughly shattered by the melodic and collective chanting of the 'Anushtup' meter.
            Observing his disciples sing, Valmiki realized that Brahma’s boon had actualized; this poetry was indeed captivating and capable of holding minds.
            'Bhrishavismitah' highlights that to the disciples, it felt like pure magic how intense anger and trauma could birth such flawlessly beautiful poetry.
            This verse illustrates the therapeutic power of art, demonstrating how it sublimates raw human suffering into elevated aesthetic joy.
            The formal recitation and singing of the Ramayana officially commenced right here, starting from the very ashram of Sage Valmiki.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 43,
        sanskrit = "समाक्षरैश्चतुर्भिर्यः पादैर्गीतो महर्षिणा ।\nसोऽनुव्याहरणाद् भूयः शोकः श्लोकत्वमागतः ॥ ४३ ॥\nइति वाल्मीकिरामायणे बालकाण्डे द्वितीयः सर्गः ॥",
        hindiCommentary = """
            महर्षि वाल्मीकि द्वारा समान अक्षरों वाले (समाक्षरैः) जिन चार चरणों (पादों) में वह वाणी गाई गई थी।
            बार-बार दोहराए जाने (अनुव्याहरणाद्) के कारण मुनि का वह 'शोक' (दुख) स्थायी रूप से 'श्लोक' (कविता) के रूप में परिणत हो गया।
            यह श्लोक द्वितीय सर्ग का अंतिम और सबसे महत्वपूर्ण निष्कर्ष है, जो 'शोक से श्लोक' की यात्रा को तकनीकी रूप से परिभाषित करता है।
            'समाक्षरैश्चतुर्भिः पादैः' इस बात की पुष्टि करता है कि अनुष्टुप छंद में आठ-आठ अक्षरों के चार चरण होते हैं।
            यह कोई संयोग नहीं था, बल्कि पीड़ा जब एक विशिष्ट लय और अनुशासन में बंधती है, तो वह कालजयी साहित्य बन जाती है।
            इस प्रकार वाल्मीकि रामायण के बालकाण्ड का यह 'द्वितीय सर्ग' यहाँ अपने पूर्ण गौरव के साथ समाप्त होता है।
            यह सर्ग रामायण के जन्म की वह दिव्य गाथा है जिसने पूरी दुनिया को पहला कवि और पहली कविता प्रदान की।
            अब वाल्मीकि जी के पास छंद था, ब्रह्मा का वरदान था, और नारद द्वारा दी गई राम की कथा थी।
            पूरी सामग्री एकत्र हो चुकी थी, और अब उन्हें केवल अपनी समाधि में बैठकर उस महान कथा को शब्द देने थे (जो तृतीय सर्ग में होता है)।
            ॥ द्वितीय सर्ग सम्पूर्ण हुआ। जय श्री राम ॥
        """.trimIndent(),
        englishCommentary = """
            That which was sung by the great sage in four feet (Padah) containing an equal number of syllables (Samaksharaih).
            Through constant repetition (Anuvyaharanad), that intense 'Shoka' (grief) of the sage formally and permanently transformed into a 'Shloka' (poetry).
            This verse serves as the final and most crucial conclusion of the Second Sarga, technically defining the grand journey from 'Sorrow to Verse.'
            'Samaksharaishchaturbhih Padaih' officially confirms the structure of the Anushtup meter, consisting of four quarters of exactly eight syllables each.
            This was no mere coincidence; it proves that when profound pain is bound by rhythm and discipline, it evolves into timeless classical literature.
            Thus, the 'Second Sarga' of the Baal Kand in the Valmiki Ramayana reaches its glorious conclusion right here.
            This chapter is the divine saga of the epic's birth, uniquely gifting the entire world its very First Poet and its First Classical Poem.
            Valmiki now possessed the perfect meter, the infallible boon of Brahma, and the summary of Rama's life provided by Sage Narada.
            With all the elements perfectly aligned, all he had to do was enter deep meditation to give voice to that epic narrative (which occurs in Sarga 3).
            || Thus ends the Second Sarga. Jai Shri Ram ||
        """.trimIndent()
    )
)