package com.sanatangyansagar.ui.screens.veda.YajurVeda.ShuklaYajurveda

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
fun ShuklaYajurvedaAdhyayaFourScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            shuklaYajurAdhyayaFourData
        } else {
            shuklaYajurAdhyayaFourData.filter {
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
                        Text("चतुर्थ अध्याय - सोमयाग (दीक्षा)", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFCC80) // Saffron/Orange tint for Yajurveda
                    )
                )
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("खोजें (मंत्र संख्या या शब्द)...") },
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
                .background(Color(0xFFFFF8E1)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(filteredVerses) { verse ->
                VedaDetailCard(verse)
            }

            if (filteredVerses.isEmpty()) {
                item {
                    Text(
                        "कोई मंत्र नहीं मिला।",
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

val shuklaYajurAdhyayaFourData = listOf(
    ShuklaYajurVerse(
        id = 1,
        sanskrit = "आकूत्यै प्रयुजेऽग्नये स्वाहा मेधायै मनसेऽग्नये स्वाहा दीक्षायै तपसेऽग्नये स्वाहा सरस्वत्यै पूष्णेऽग्नये स्वाहा ॥ १ ॥",
        hindiCommentary = """
            (सोमयाग की दीक्षा का आरंभ) उत्तम संकल्प (आकूति) और श्रेष्ठ कार्यों में प्रवृत्त (प्रयुज) होने के लिए अग्निदेव को यह आहुति (स्वाहा) समर्पित है।
            महान बुद्धि (मेधा) और निर्मल मन की प्राप्ति के लिए अग्निदेव को स्वाहा; कठोर दीक्षा और तपोबल की वृद्धि के लिए अग्निदेव को स्वाहा।
            ज्ञान की देवी सरस्वती और पोषण के देव पूषा से युक्त अग्निदेव की पूर्ण प्रसन्नता के लिए यह पवित्र आहुति समर्पित है।
            चतुर्थ अध्याय से महायज्ञ (सोमयाग) का आरंभ होता है; और किसी भी महान कार्य की शुरुआत उत्तम संकल्प (आकूति) के बिना संभव नहीं है।
            केवल इच्छा होना पर्याप्त नहीं है, उस इच्छा को कार्यरूप (प्रयुज) में बदलने के लिए असीम ऊर्जा (अग्नि) और कुशाग्र बुद्धि (मेधा) की आवश्यकता होती है।
            'दीक्षा' का अर्थ है अपने मन और इंद्रियों को एक विशेष अनुशासन और तप में बांध लेना, ताकि हम अपने सांसारिक मोह से मुक्त हो सकें।
            हे परमात्मा! हमारे मन में उठने वाला हर संकल्प सत्य और धर्म से प्रेरित हो, और हमारे हर कर्म में आपकी पवित्र अग्नि का तेज झलके।
            हमें वह मेधा शक्ति दें जिससे हम सत्य और असत्य का भेद कर सकें, और ऐसा तप दें जो हमारे अहंकार को पूरी तरह से जलाकर भस्म कर दे।
            ज्ञान (सरस्वती) और पोषण (पूषा) जब एक साथ मिलते हैं, तभी मनुष्य का सर्वांगीण विकास होता है और वह समाज के लिए उपयोगी बनता है।
            हमारा यह संपूर्ण जीवन ही एक पावन दीक्षा बन जाए, जहाँ हम अपनी हर श्वास को विश्व-कल्याण और आपके निस्वार्थ प्रेम में अर्पित कर दें।
        """.trimIndent(),
        englishCommentary = """
            (Beginning of Soma Yaga Initiation) For noble resolve (Akuti) and engagement in excellent deeds (Prayuj), this oblation (Svaha) is dedicated to Lord Agni.
            For the attainment of great intellect (Medha) and a pure mind, Svaha to Agni; for strict initiation (Diksha) and increase of ascetic power (Tapas), Svaha to Agni.
            For the absolute pleasure of Agni united with Saraswati (Goddess of Knowledge) and Pushan (God of Nourishment), this holy oblation is dedicated.
            From the fourth chapter, the grand sacrifice (Soma Yaga) begins; and the start of any great work is impossible without an excellent resolve (Akuti).
            Mere desire is not enough; to translate that desire into action (Prayuj), boundless energy (Agni) and sharp intellect (Medha) are required.
            'Diksha' means binding one's mind and senses in a specific discipline and penance, so that we can become free from worldly attachments.
            O Supreme Lord! May every resolve arising in our mind be inspired by truth and Dharma, and may the brilliance of Your holy fire reflect in every action.
            Grant us that intellectual power to distinguish between truth and untruth, and such penance that completely burns our ego to ashes.
            Only when knowledge (Saraswati) and nourishment (Pushan) unite together does a person's all-round development occur, making them useful to society.
            May this entire life of ours become a holy initiation, where we offer our every breath to global welfare and Your selfless, divine love.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 2,
        sanskrit = "विश्वो देवस्य नेतुर्मर्तो वुरीत सख्यम् ।\nविश्वो राय इषुध्यति द्युम्नं वृणीत पुष्यसे स्वाहा ॥ २ ॥",
        hindiCommentary = """
            विश्व का प्रत्येक मरणशील मनुष्य (मर्त्य) उस महान पथप्रदर्शक (नेता) परमेश्वर की मित्रता (सख्यम्) की ही कामना और वरण करता है।
            संसार का हर प्राणी उस परम ऐश्वर्य (धन/रयि) की इच्छा रखता है, इसलिए वह अपने पूर्ण पोषण (पुष्यसे) के लिए ईश्वरीय तेज (द्युम्न) को ही चुनता है, स्वाहा।
            यह ऋग्वेद और यजुर्वेद का अत्यंत प्रसिद्ध मंत्र है, जो मनुष्य के जीवन की सबसे मूलभूत और अंतिम खोज को स्पष्ट करता है।
            हम जीवन भर लोगों से मित्रता करते हैं, परंतु सच्चा और स्थायी 'सखा' केवल वही सर्वव्यापी ईश्वर है जो कभी हमारा साथ नहीं छोड़ता।
            ईश्वर 'नेता' (लीडर/मार्गदर्शक) है; जब हम अपने जीवन की बागडोर उसके हाथों में सौंप देते हैं, तो हम कभी भी गलत मार्ग पर नहीं भटकते।
            'द्युम्न' का अर्थ है वह आत्मिक और सात्विक तेज जो किसी भौतिक धन (रयि) से कहीं अधिक मूल्यवान और शाश्वत होता है।
            हे प्रभु! हमें यह विवेक दें कि हम नश्वर मनुष्यों और भौतिक वस्तुओं से मित्रता करने के बजाय सीधे आपसे ही अपना नाता जोड़ें।
            जो व्यक्ति ईश्वरीय प्रकाश (द्युम्न) का वरण करता है, उसका आध्यात्मिक और मानसिक पोषण (पुष्टि) स्वतः ही होने लगता है।
            हम संसार में रहते हुए भी संसार के दास न बनें; हमारी हर इच्छा और हर कर्म आपके चरणों में एक 'स्वाहा' (पवित्र आहुति) के रूप में समर्पित हो।
            आपके सान्निध्य मात्र से ही मनुष्य मृत्यु के भय से मुक्त हो जाता है और उस अनंत आनंद का भागीदार बनता है जो कभी समाप्त नहीं होता।
        """.trimIndent(),
        englishCommentary = """
            Every mortal human (Martya) of the world desires and chooses only the friendship (Sakhyam) of that great guiding Supreme Lord (Neta).
            Every creature in the world desires that supreme wealth (Rayi), therefore, for one's complete nourishment (Pushyase), one chooses only the divine brilliance (Dyumna), Svaha.
            This is an extremely famous mantra of Rigveda and Yajurveda, which clarifies the most fundamental and ultimate quest of human life.
            We make friends with people all our lives, but the only true and permanent 'Sakha' (friend) is that omnipresent God who never leaves our side.
            God is the 'Neta' (Leader/Guide); when we hand over the reins of our life into His hands, we never wander onto the wrong path.
            'Dyumna' means that spiritual and virtuous brilliance which is far more valuable and eternal than any material wealth (Rayi) of the world.
            O Lord! Give us the wisdom that instead of making friends with perishable humans and objects, we establish our relationship directly with You.
            A person who chooses the divine light (Dyumna), their spiritual and mental nourishment (Pushti) automatically begins to happen.
            Living in the world, let us not become slaves to the world; let our every desire and action be dedicated as a 'Svaha' (holy oblation) at Your feet.
            Merely by Your proximity, a human becomes free from the fear of death and becomes a partaker of that infinite bliss which absolutely never ends.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 3,
        sanskrit = "आपो देवीर्बृहतीर्विश्वशम्भुवो द्यावापृथिवी उरोऽन्तरिक्षम् ।\nबृहस्पतये हविषा विधेम स्वाहा ॥ ३ ॥",
        hindiCommentary = """
            हे महान (बृहतीः) और संपूर्ण विश्व का कल्याण करने वाली (विश्वशम्भुवः) दिव्य जल की धाराओ! हे आकाश (द्यु) और पृथ्वी! हे अत्यंत विशाल अंतरिक्ष!
            हम ज्ञान और वाक् के अधिपति देव 'बृहस्पति' के लिए अत्यंत श्रद्धापूर्वक इस हविष्य (अन्न) की आहुति (स्वाहा) प्रदान करते हैं।
            यज्ञ में दीक्षा का यह चरण ब्रह्मांड की सभी महान शक्तियों (जल, पृथ्वी, आकाश और अंतरिक्ष) को एक साथ नमन और स्मरण करने का है।
            जल 'विश्वशम्भु' है, क्योंकि जल के बिना संसार में न तो जीवन उत्पन्न हो सकता है और न ही कोई भी प्राणी सुख-शांति से रह सकता है।
            आकाश और पृथ्वी हमारे माता-पिता के समान हैं, जो हमें आश्रय देते हैं; और विशाल अंतरिक्ष हमारे विचारों की उन्मुक्त उड़ान का प्रतीक है।
            बृहस्पति देव बुद्धि, ज्ञान और मंत्र-शक्ति के स्वामी हैं; बिना उत्तम बुद्धि के किया गया कोई भी कर्म या यज्ञ कभी भी सफल नहीं होता।
            हे परमात्मा! हमारे भीतर जल जैसी शीतलता, पृथ्वी जैसी सहनशीलता और अंतरिक्ष जैसी असीम विशालता तथा उदारता का पूर्ण संचार करें।
            हम जो भी ज्ञान (बृहस्पति) प्राप्त करें, उसका उपयोग समाज में शांति (शम्भु) स्थापित करने के लिए करें, न कि अहंकार जताने के लिए।
            हमारी यह आहुति प्रकृति के प्रति हमारी कृतज्ञता का प्रतीक है; हम प्रकृति से जो कुछ भी लेते हैं, उसे पवित्र कर ईश्वर को वापस लौटाते हैं।
            हमारा मन इतना निर्मल और व्यापक हो जाए कि हम संपूर्ण सृष्टि को केवल उसी एक ईश्वरीय चेतना का अखंड विस्तार मानकर सबसे प्रेम करें।
        """.trimIndent(),
        englishCommentary = """
            O great (Brihatih) and universe-benefiting (Vishvashambhuvah) streams of divine water! O Heaven (Dyu) and Earth! O extremely vast Mid-Space!
            We offer this oblation (Svaha) of sacrificial food with utmost devotion to 'Brihaspati', the Lord of wisdom and sacred speech.
            This phase of initiation in the sacrifice is to simultaneously bow to and remember all the great forces of the universe (Water, Earth, Sky, Space).
            Water is 'Vishvashambhu' because, without water, neither can life originate in the world nor can any creature live in peace and happiness.
            Heaven and Earth are like our parents who give us refuge; and the vast space is the symbol of the completely free flight of our thoughts.
            Lord Brihaspati is the master of intellect, knowledge, and mantra-power; any action or sacrifice done without excellent wisdom is never successful.
            O Supreme Lord! Infuse completely within us the coolness of water, the tolerance of earth, and the boundless vastness and generosity of space.
            Whatever knowledge (Brihaspati) we acquire, let us use it to establish peace (Shambhu) in society, and never to show off our ego.
            This oblation of ours is a symbol of our deep gratitude towards nature; whatever we take from nature, we purify and return it to God.
            May our mind become so pure and broad that we consider the entire creation as the unbroken extension of that one divine consciousness and love all.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 4,
        sanskrit = "त्वमग्ने व्रतपा असि देव आ मर्त्येष्वा ।\nत्वं यज्ञेष्वीड्यः ॥ ४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप मरणशील मनुष्यों (मर्त्येषु) के बीच निवास करने वाले साक्षात् देव हैं और आप ही हमारे व्रतों (सच्चे संकल्पों) के परम रक्षक (व्रतपा) हैं।
            आप ही हमारे सभी श्रेष्ठ कर्मों और महायज्ञों में अत्यंत स्तुति करने योग्य (ईड्यः) और पूजनीय परमेश्वर हैं।
            दीक्षा लेते समय साधक यह उद्घोष करता है कि उसका संकल्प (व्रत) अब साधारण नहीं रहा, बल्कि स्वयं अग्निदेव (ईश्वर) उसके रक्षक बन गए हैं।
            'मर्त्येषु देवः' का अर्थ है कि ईश्वर स्वर्ग में दूर नहीं बैठा है, वह हमारे भीतर, हमारे घर में और हमारी सांसों में साक्षात् उपस्थित है।
            व्रत का अर्थ केवल उपवास नहीं, बल्कि सत्य बोलने, धर्म पर चलने और निस्वार्थ कर्म करने की वह अटल प्रतिज्ञा है जिसे हम जीवन भर निभाते हैं।
            हे प्रभु! जब भी मेरा मन सांसारिक प्रलोभनों से भटके और मेरा व्रत टूटने लगे, तो आप अपनी प्रखर ज्योति से मुझे सही मार्ग पर वापस ले आएं।
            हम अज्ञानी मनुष्य कई बार अपने संकल्पों से गिर जाते हैं; परंतु आपकी कृपा ही वह शक्ति है जो हमें बार-बार उठाकर खड़ा कर देती है।
            'ईड्यः' (स्तुति के योग्य) केवल वही है जो सत्य है; अतः हम संसार के झूठे अभिमानियों की नहीं, बल्कि केवल आपकी ही शरण और वंदना ग्रहण करें।
            हमारा पूरा जीवन एक ऐसा श्रेष्ठ यज्ञ बन जाए जिसकी हर आहुति में आपके प्रति अटूट प्रेम और मानव मात्र के कल्याण की भावना समाहित हो।
            जैसे अग्नि सदा ऊपर की ओर ही उठती है, वैसे ही हमारे संकल्प और हमारा चरित्र भी हमेशा ऊर्ध्वगामी (उच्च) हों, कभी भी पतन की ओर न जाएं।
        """.trimIndent(),
        englishCommentary = """
            O Agni! You are the direct God residing among mortal humans (Martyeshu), and You alone are the supreme protector of our vows (Vratapa).
            You alone are the most praiseworthy (Idyah) and worshipful Supreme Lord in all our noble deeds and grand sacrifices.
            While taking initiation, the seeker declares that his resolve (vow) is no longer ordinary, but Lord Agni (God) Himself has become its protector.
            'God among mortals' means that God is not sitting far away in heaven; He is directly present within us, in our homes, and in our breaths.
            A vow does not just mean fasting, but that unbreakable pledge to speak the truth, walk on Dharma, and do selfless deeds lifelong.
            O Lord! Whenever my mind wanders due to worldly temptations and my vow begins to break, bring me back to the right path with Your fierce light.
            We ignorant humans often fall from our resolutions; but Your grace is the only power that lifts us up and makes us stand again and again.
            'Idyah' (worthy of praise) is only that which is Truth; hence, let us not take refuge in false, arrogant people of the world, but solely worship You.
            May our entire life become such an excellent sacrifice where every oblation contains unbroken love for You and the feeling of welfare for all humanity.
            Just as fire always rises upwards, may our resolutions and character also always be upward-moving (elevated), and never fall towards degradation.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 5,
        sanskrit = "दैवी धियं मनामहे सुमृडीकामभिष्टये ।\nवर्चोधां यज्ञवाहसं सुतीर्था नो असद्वशे ॥ ५ ॥",
        hindiCommentary = """
            हम उस ईश्वरीय और दिव्य (दैवी) बुद्धि (धियम्) का ध्यान और मनन करते हैं, जो अत्यंत सुखदायिनी (सुमृडीका) और हमारे अभीष्ट की सिद्धि करने वाली है।
            वह दिव्य बुद्धि जो तेज (वर्चस्व) को धारण करने वाली है और हमारे जीवन रूपी यज्ञ को पूर्णता तक ले जाने वाली (यज्ञवाहसम्) है।
            वह उत्तम तीर्थ (सुतीर्था/पवित्र मार्ग) के समान हमारे मन को हमारे वश (नियंत्रण) में रखने वाली सिद्ध हो।
            गायत्री मंत्र की ही भांति, यह मंत्र भी ईश्वर से भौतिक धन नहीं, बल्कि 'दिव्य बुद्धि' (धियम्) की सबसे श्रेष्ठ और महत्वपूर्ण याचना करता है।
            जब बुद्धि ईश्वरीय प्रकाश से जुड़ती है, तो वह 'सुमृडीका' (शांति देने वाली) बन जाती है; अन्यथा अशुद्ध बुद्धि केवल चिंता और विनाश ही लाती है।
            सुतीर्थ का अर्थ है वह पवित्र घाट या रास्ता जो हमें संसार सागर के पार ले जाए; सुबुद्धि ही जीवन का सबसे बड़ा और सच्चा तीर्थ है।
            हे परमात्मा! हमारे मन को इतना नियंत्रित (वश में) कर दें कि वह इन्द्रियों का दास न बने, बल्कि इन्द्रियां हमारे ज्ञान और विवेक के अधीन रहें।
            हमारी बुद्धि में ऐसा ओज (वर्चस्व) हो कि हमारे विचार समाज के अंधकार को दूर कर सकें और हम हर कार्य को एक पावन यज्ञ के भाव से पूरा करें।
            हम जो भी सोचें, जो भी निर्णय लें, वह ईश्वरीय प्रेरणा से युक्त हो ताकि हमारे जीवन का कोई भी कदम कभी भी धर्म के मार्ग से न भटके।
            यह प्रार्थना हमें बताती है कि सच्ची सफलता और शांति केवल उसी को मिलती है जिसका मन उसके वश में हो और जिसकी बुद्धि ईश्वर में एकाग्र हो।
        """.trimIndent(),
        englishCommentary = """
            We meditate upon and ponder that divine (Daivi) intellect (Dhiyam), which is highly comforting (Sumridika) and fulfills all our desired goals.
            That divine intellect which holds brilliance (Varchas) and perfectly carries our life's sacrifice to absolute completion (Yajnavahasam).
            Like an excellent holy crossing (Sutirtha/sacred path), may it prove successful in keeping our mind completely under our control (Vasha).
            Just like the Gayatri Mantra, this mantra too does not ask God for material wealth, but makes the highest and most important plea for 'divine intellect'.
            When the intellect connects with divine light, it becomes 'Sumridika' (peace-giving); otherwise, an impure intellect brings only worry and destruction.
            Sutirtha means that holy ghat or path that takes us across the ocean of the world; good wisdom is indeed the greatest and truest pilgrimage of life.
            O Supreme Lord! Control our mind so much that it does not become a slave to the senses, but rather the senses remain strictly under our wisdom and discernment.
            Let there be such brilliance in our intellect that our thoughts eradicate society's darkness, and we complete every task with the feeling of a holy sacrifice.
            Whatever we think, whatever decisions we take, let them be endowed with divine inspiration so no step of our life ever wanders from the path of Dharma.
            This prayer tells us that true success and peace are attained only by the one whose mind is under their control and whose intellect is focused on God.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 6,
        sanskrit = "ये देवासो दिव्येकादश स्थ पृथिव्यामध्येकादश स्थ ।\nअप्सुक्षितो महिनैकादश स्थ ते देवासो यज्ञमिमं जुषध्वम् ॥ ६ ॥",
        hindiCommentary = """
            (तृतीय अध्याय के इस मंत्र की पुनः आवृत्ति) हे देवगण! जो ग्यारह देवता द्युलोक (स्वर्ग) में स्थित हैं, और जो ग्यारह देवता इस पृथ्वीलोक पर विराजमान हैं।
            और जो ग्यारह देवता अपनी महिमा के साथ जलों (अंतरिक्ष) में निवास करते हैं; वे सभी तैंतीस (33) देवता हमारे इस पवित्र यज्ञ को सहर्ष स्वीकार करें।
            दीक्षा के इस अत्यंत महत्वपूर्ण चरण में 33 कोटि (प्रकार) के देवताओं का पुनः आह्वान किया जाता है, ताकि साधक को ब्रह्मांडीय शक्तियों का पूर्ण समर्थन मिले।
            स्वर्ग, पृथ्वी और अंतरिक्ष—ये तीनों लोक प्रकृति के संतुलन के मूल आधार हैं; जब ये तीनों शुद्ध और अनुकूल होते हैं, तभी मानव जीवन सुखमय होता है।
            वैदिक धर्म में देवता कोई बाहरी व्यक्ति नहीं, बल्कि प्रकृति (जल, वायु, अग्नि, सूर्य) की वे ही प्रत्यक्ष शक्तियां हैं जो हमें जीवन देती हैं।
            हे परमेश्वर! आपकी ये सभी दिव्य शक्तियां हमारे जीवन के हर मोड़ पर हमारी रक्षा करें और हमें धर्म के मार्ग पर चलने की शक्ति प्रदान करें।
            हम प्रकृति के इन सभी तत्वों का गहराई से सम्मान करें; पृथ्वी को गंदा न करें, जल को प्रदूषित न करें और आकाश (पर्यावरण) को शुद्ध रखें।
            जब हम प्रकृति का सम्मान करते हैं, तो 33 कोटि देवता स्वतः ही हमारे कर्मों से प्रसन्न (जुषध्वम्) हो जाते हैं और हम पर अपनी कृपा बरसाते हैं।
            हमारा यह अनुष्ठान केवल हमारे व्यक्तिगत स्वार्थ के लिए न हो, बल्कि संपूर्ण सृष्टि के कल्याण और इस धरती पर शांति स्थापना के लिए हो।
            यह मंत्र हमें 'वसुधैव कुटुम्बकम्' के साथ-साथ ब्रह्मांडीय एकता का भी अत्यंत सुंदर पाठ पढ़ाता है, जहाँ सब कुछ एक ही परम सत्ता से जुड़ा है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of the mantra from Chapter 3) O Gods! The eleven deities situated in heaven (Dyuloka), and the eleven deities residing on this earth.
            And the eleven deities who dwell in the waters (mid-space) with their glory; may all those thirty-three (33) gods joyfully accept this holy sacrifice of ours.
            In this extremely important phase of initiation, the 33 Koti (types) of deities are invoked again so the seeker gets the full support of cosmic forces.
            Heaven, Earth, and Space—these three worlds are the basic foundation of nature's balance; only when these are pure and favorable is human life happy.
            In Vedic Dharma, gods are not external persons, but the direct forces of nature (water, wind, fire, sun) that give us life and sustain us.
            O Supreme Lord! May all these divine forces of Yours protect us at every turn of our lives and grant us the strength to walk strictly on the path of Dharma.
            Let us deeply respect all these elements of nature; let us not dirty the earth, pollute the water, and keep the sky (environment) perfectly pure.
            When we respect nature, the 33 types of gods automatically become pleased (Jushadhvam) with our actions and shower their profound grace upon us.
            May this ritual of ours not be just for our personal selfishness, but for the absolute welfare of the entire creation and the establishment of peace on earth.
            This mantra beautifully teaches us cosmic unity along with 'Vasudhaiva Kutumbakam', where absolutely everything is connected to that one Supreme Reality.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 7,
        sanskrit = "उपयामगृहीतोऽसि सोमाय त्वा जुष्टं गृह्णामि ।\nएष ते योनिः सोमाय त्वा ॥ ७ ॥",
        hindiCommentary = """
            (सोम रस ग्रहण का मंत्र) हे सोम! तुम यज्ञपात्र (उपयाम) के द्वारा अत्यंत सावधानी और पवित्रता से ग्रहण किए गए हो; मैं तुम्हें सोमदेव की प्रसन्नता के लिए धारण करता हूँ।
            हे पावन रस! यह स्थान (यज्ञवेदी या पात्र) तुम्हारा ही अपना वास्तविक उत्पत्ति और निवास स्थान (योनि) है; मैं तुम्हें सोम के ही निमित्त स्थापित करता हूँ।
            चतुर्थ अध्याय का यह भाग सोमयाग के मुख्य तत्व 'सोम रस' से संबंधित है; सोम केवल एक वनस्पति नहीं, बल्कि परमानंद और आध्यात्मिक उल्लास का प्रतीक है।
            'उपयाम' (पात्र) वास्तव में हमारा अपना अंतःकरण है; जब हमारा मन शुद्ध होता है, तभी वह ईश्वरीय आनंद (सोम) को ग्रहण करने योग्य बनता है।
            सोम शांति, शीतलता और मन की असीम तृप्ति का देवता है; इस रस को धारण करने का अर्थ है अपने जीवन को शांति और भक्ति से पूरी तरह भर लेना।
            हे प्रभु! मेरे हृदय रूपी पात्र को इतना निर्मल बना दें कि उसमें संसार का कोई भी विष (क्रोध/लोभ) न रहे, बल्कि केवल आपके प्रेम का अमृत (सोम) छलके।
            जब हम ईश्वर के लिए कुछ ग्रहण करते हैं (सोमाय त्वा), तो हमारे कर्मों का सारा स्वार्थ और अहंकार उसी क्षण समाप्त हो जाता है।
            योनि (निवास स्थान) का ज्ञान होना यह दर्शाता है कि आत्मा का असली घर यह भौतिक संसार नहीं, बल्कि वह परम शांत ईश्वरीय चेतना ही है।
            हम जो भी सात्विक अन्न या रस ग्रहण करें, वह हमारे शरीर को निरोग और हमारी आत्मा को ईश्वर के प्रति पूर्णतः समर्पित कर दे।
            हमारा जीवन इस सोम रस की तरह अत्यंत मधुर, आनंददायी और दूसरों के मानसिक संताप को हरने वाला एक शीतल वरदान बन जाए।
        """.trimIndent(),
        englishCommentary = """
            (Mantra for accepting Soma juice) O Soma! You are accepted with extreme care and purity by the sacrificial vessel (Upayama); I hold you for the pleasure of Lord Soma.
            O holy essence! This place (altar or vessel) is your own true place of origin and residence (Yoni); I establish you strictly for the sake of Soma.
            This part of the fourth chapter relates to the main element of Soma Yaga, the 'Soma juice'; Soma is not just a plant, but a symbol of supreme bliss and spiritual joy.
            'Upayama' (vessel) is actually our own inner conscience; only when our mind is pure does it become capable of receiving the divine bliss (Soma).
            Soma is the god of peace, coolness, and boundless mental fulfillment; holding this essence means filling one's life completely with peace and devotion.
            O Lord! Make the vessel of my heart so pure that no worldly poison (anger/greed) remains in it, but only the nectar (Soma) of Your love overflows.
            When we accept something for the sake of God (Somaya tva), all the selfishness and deep ego of our actions end at that very moment.
            Knowing the Yoni (residence) shows that the soul's real home is not this material world, but solely that supremely peaceful divine consciousness.
            Whatever pure (Sattvic) food or essence we consume, may it make our body completely disease-free and our soul fully dedicated to God.
            May our life become extremely sweet, blissful, and a cooling boon that removes the mental agony of others, just exactly like this Soma juice.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 8,
        sanskrit = "उपयामगृहीतोऽसि सवित्रे त्वा जुष्टं गृह्णामि ।\nएष ते योनिः सवित्रे त्वा ॥ ८ ॥",
        hindiCommentary = """
            हे रस! तुम यज्ञपात्र (उपयाम) के द्वारा अत्यंत विधिपूर्वक ग्रहण किए गए हो; मैं तुम्हें 'सविता देव' (सूर्य/प्रेरणा के देवता) की पूर्ण प्रसन्नता के लिए धारण करता हूँ।
            यह पावन पात्र तुम्हारा ही अपना निवास स्थान (योनि) है; मैं तुम्हें संसार के प्रेरक सविता देव के परम निमित्त ही यहाँ स्थापित करता हूँ।
            सोमयाग में विभिन्न देवताओं के लिए रस (आहुति) अलग-अलग रखा जाता है; यहाँ सविता देव का आह्वान हमारे जीवन में श्रेष्ठ प्रेरणा जगाने के लिए है।
            सविता देव सृष्टि के रचयिता और हमारे कर्मों के मुख्य प्रेरक हैं (जैसे गायत्री मंत्र में सवितुर्वरेण्यं); उनके बिना कोई भी विचार या कार्य संभव नहीं।
            जब हम अपनी ऊर्जा (रस) को सविता देव के निमित्त कर देते हैं, तो हमारे भीतर का आलस्य पूरी तरह नष्ट हो जाता है और हम अत्यंत कर्मठ बन जाते हैं।
            हे परमात्मा! हमारे मन रूपी पात्र में ऐसा ज्ञान का रस भर दें जो हमें सदैव सन्मार्ग की ओर ही प्रेरित करे और हमें अज्ञान के अंधकार से दूर रखे।
            हम जो कुछ भी जीवन में प्राप्त करें, उसे अपनी निजी जागीर न मानकर ईश्वर का पवित्र प्रसाद ही मानें और उसे समाज के मंगल के लिए बांट दें।
            सविता का प्रकाश भेदभाव नहीं करता; वह सबको समान रूप से जीवन देता है; हमारा व्यवहार भी सभी प्राणियों के प्रति ऐसा ही समतापूर्ण और प्रेममयी होना चाहिए।
            हमारा यह आध्यात्मिक अनुष्ठान हमारी चेतना को इतना जाग्रत कर दे कि हम अपने भीतर बैठे उस दिव्य सूर्य की रश्मियों को प्रत्यक्ष अनुभव कर सकें।
            हमारा हर दिन सविता देव की पावन प्रेरणा से शुरू हो और हमारा हर कर्म धर्म, सत्य और मानवता के महान आदर्शों की रक्षा करने वाला बने।
        """.trimIndent(),
        englishCommentary = """
            O Essence! You are systematically accepted by the sacrificial vessel (Upayama); I hold you for the absolute pleasure of 'Savitar' (Sun/God of inspiration).
            This holy vessel is your very own residence (Yoni); I establish you here solely for the sake of Savitar, the supreme inspirer of the world.
            In Soma Yaga, the essence (oblation) is kept separately for different gods; here the invocation of Savitar is to awaken excellent inspiration in our lives.
            Savitar is the creator of the universe and the main inspirer of our actions (like 'Saviturvarenyam' in Gayatri); no thought or deed is possible without Him.
            When we dedicate our energy (essence) to God Savitar, the laziness within us is completely destroyed and we become extremely hardworking and active.
            O Supreme Lord! Fill the vessel of our mind with such essence of knowledge that it always inspires us towards the right path and keeps us far from darkness.
            Whatever we attain in life, let us not consider it our personal property, but treat it as God's holy grace and distribute it for society's welfare.
            Savitar's light does not discriminate; it gives life equally to all; our behavior towards all living beings should also be equally equitable and loving.
            May this spiritual ritual of ours awaken our consciousness so much that we can directly experience the bright rays of that divine sun sitting right within us.
            May our every day begin with the holy inspiration of Savitar, and may every action of ours protect the great ideals of Dharma, truth, and humanity.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 9,
        sanskrit = "उपयामगृहीतोऽसि वायवे त्वा जुष्टं गृह्णामि ।\nएष ते योनिर्व्वायवे त्वा ॥ ९ ॥",
        hindiCommentary = """
            हे पावन रस! तुम इस यज्ञपात्र के द्वारा अत्यंत आदरपूर्वक ग्रहण किए गए हो; मैं तुम्हें 'वायु देव' (प्राणशक्ति और गति के देवता) की प्रसन्नता के लिए धारण करता हूँ।
            यह यज्ञपात्र तुम्हारा ही वास्तविक निवास स्थान है; मैं तुम्हें सर्वत्र विचरण करने वाले और जीवन देने वाले वायु देव के निमित्त स्थापित करता हूँ।
            वायु देव हमारी श्वास (प्राण) और संसार की गति (Movement) के साक्षात् प्रतीक हैं; बिना वायु के न तो हमारा शरीर जीवित रह सकता है, न ही यज्ञ की अग्नि जल सकती है।
            सोम रस को वायु के लिए अर्पित करने का आध्यात्मिक अर्थ है—अपनी प्राणशक्ति को ईश्वरीय कार्यों और योग-साधना में पूरी तरह से एकाग्र कर देना।
            जैसे वायु हर जगह बिना किसी रुकावट के बहती है और सबको जीवन देती है, वैसे ही हमारे प्रेम और करुणा का प्रवाह भी बिना किसी स्वार्थ के सब तक पहुँचना चाहिए।
            हे प्रभु! हमारे फेफड़ों में बहने वाली प्राणवायु को इतना शुद्ध और शक्तिशाली बना दें कि हम एक लंबा, निरोगी और अत्यंत ऊर्जावान जीवन जी सकें।
            हम अपने मन की चंचलता (जो वायु के समान उड़ता है) को इसी पात्र (एकाग्रता) में रोककर उसे केवल आपके ध्यान और चिंतन में ही स्थिर कर दें।
            वायु अशुद्धियों को उड़ा ले जाती है; उसी प्रकार आपका ईश्वरीय ज्ञान हमारे अंतःकरण के सभी कुविचारों और संशयों को उड़ाकर हमें पूर्णतः निर्मल कर दे।
            हम जो भी कार्य करें, उसमें वायु के समान एक अद्भुत गति, उत्साह और कभी न थकने वाला असीम पुरुषार्थ हो।
            हमारा जीवन केवल एक स्थान पर ठहरा हुआ तालाब न बने, बल्कि वायु की तरह स्वतंत्र होकर संसार में ज्ञान और शांति की शीतल लहरें निरंतर फैलाता रहे।
        """.trimIndent(),
        englishCommentary = """
            O holy Essence! You are accepted with utmost respect by this vessel; I hold you for the pleasure of 'Vayu' (God of vital force and motion).
            This sacrificial vessel is your very own real residence; I establish you strictly for the sake of the all-wandering, life-giving Wind God.
            Vayu is the direct symbol of our breath (Prana) and the world's motion; without wind, neither can our body survive nor can the sacrificial fire burn.
            Offering Soma juice to Vayu has a deep spiritual meaning—concentrating one's vital energy completely in divine works and Yoga practice.
            Just as the wind flows everywhere without any hurdle and gives life to all, the flow of our love and compassion should reach everyone without selfishness.
            O Lord! Make the vital breath flowing in our lungs so pure and powerful that we can live a long, disease-free, and extremely energetic life.
            Let us capture the restlessness of our mind (which flies like the wind) in this vessel (concentration) and stabilize it solely in Your deep meditation.
            Wind blows away impurities; similarly, may Your divine knowledge blow away all the evil thoughts and doubts of our conscience, making us completely pure.
            Whatever work we do, let it possess an amazing speed, profound enthusiasm, and a never-tiring boundless effort, just like the wind.
            Let our life not become a stagnant pond stuck in one place, but becoming free like the wind, let it continuously spread cool waves of knowledge and peace in the world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 10,
        sanskrit = "उपयामगृहीतोऽसीन्द्राय त्वा जुष्टं गृह्णामि ।\nएष ते योनिरिन्द्राय त्वा ॥ १० ॥",
        hindiCommentary = """
            हे रस! तुम यज्ञपात्र (उपयाम) के द्वारा अत्यंत पवित्रता के साथ ग्रहण किए गए हो; मैं तुम्हें देवराज 'इंद्र' (शक्ति और ऐश्वर्य के देवता) की प्रसन्नता के लिए धारण करता हूँ।
            यह यज्ञपात्र तुम्हारा ही अपना स्थान (योनि) है; मैं तुम्हें संसार के रक्षक और शक्तिशाली इंद्र के परम निमित्त ही यहाँ पूर्णतः स्थापित करता हूँ।
            इंद्र केवल देवराज नहीं हैं, वे हमारी 'इंद्रियों' (Senses) के स्वामी और हमारे भीतर की उस अदम्य शक्ति (Willpower) के प्रतीक हैं जो बुराइयों (वृत्रासुर) का नाश करती है।
            सोम का रस इंद्र का सबसे प्रिय भोजन माना गया है; इसका अर्थ है कि जब हमारी शक्ति (इंद्र) को भक्ति और शांति (सोम) का रस मिलता है, तो वह अजेय हो जाती है।
            शक्ति के बिना शांति कांतिहीन है, और शांति के बिना शक्ति विनाशकारी है; इंद्र और सोम का यह मिलन जीवन में शक्ति और विवेक के अद्भुत संतुलन का प्रतीक है।
            हे परमात्मा! हमारी सभी इंद्रियों पर हमारा पूर्ण नियंत्रण हो और हम अपनी शक्ति का उपयोग कभी भी अहंकार या किसी निर्बल के शोषण के लिए न करें।
            हमारे भीतर इतनी मानसिक और आत्मिक ऊर्जा भर दें कि हम जीवन की बड़ी से बड़ी बाधाओं और सांसारिक दुखों को अत्यंत सरलता से पार कर सकें।
            हम जो भी ऐश्वर्य (इंद्र-पद) प्राप्त करें, वह आपके ही आशीर्वाद का परिणाम हो और हम उसे धर्म की रक्षा और समाज के उत्थान में ही खुशी-खुशी लगाएं।
            हमारा अंतःकरण ऐसा पवित्र पात्र बन जाए जिसमें ईश्वरीय शक्ति स्वयं आकर निवास करे और हमारे सभी भयों को हमेशा के लिए समाप्त कर दे।
            हमारा संकल्प इंद्र के वज्र के समान कठोर हो, ताकि हम सत्य और न्याय के मार्ग पर बिना डरे एक सच्चे और महान योद्धा की तरह डटे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Essence! You are accepted with utmost purity by the vessel (Upayama); I hold you for the absolute pleasure of 'Indra' (God of power and wealth).
            This sacrificial vessel is your very own place (Yoni); I establish you here completely and solely for the sake of the powerful world-protector, Indra.
            Indra is not just the king of gods, he is the master of our 'senses' and the symbol of that indomitable power (willpower) within us that destroys evils (Vritra).
            Soma juice is considered Indra's most favorite food; this means when our power (Indra) gets the essence of devotion and peace (Soma), it becomes invincible.
            Peace without power is lackluster, and power without peace is destructive; this union of Indra and Soma is the symbol of an amazing balance of power and wisdom.
            O Supreme Lord! May we have absolute control over all our senses, and may we never use our power for ego or the exploitation of any weak person.
            Fill us with so much mental and spiritual energy that we can cross the biggest obstacles and worldly sorrows of life with extreme ease.
            Whatever prosperity (Indra-status) we attain, let it be the result of Your blessing, and let us happily use it solely for protecting Dharma and uplifting society.
            May our inner conscience become such a pure vessel where divine power itself comes to reside and ends all our deep fears permanently and forever.
            May our resolve be as hard as Indra's thunderbolt (Vajra), so that we stand firm on the path of truth and justice without any fear, like a true and great warrior.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 11,
        sanskrit = "देव श्रुतौ देवेष्वाघोषतं प्राची प्रेतमध्वरं कल्पयन्ती ।\nऊर्ध्वं यज्ञं नयतं मा जिह्वरतं स्वं गोष्ठमा सदत वीरवन्ती ॥ ११ ॥",
        hindiCommentary = """
            हे देवों के कानों तक संदेश पहुँचाने वाली शक्तियों! तुम देवलोक में हमारे इस यज्ञ की महान घोषणा (आघोष) करो।
            हे हमारी संकल्प-शक्तियों! तुम पूर्व दिशा (प्रकाश और ज्ञान की ओर) गमन करो और इस हिंसारहित यज्ञ (अध्वर) को पूरी तरह सफल बनाओ।
            तुम हमारे इस यज्ञ को निरंतर ऊर्ध्व (ऊपर/स्वर्ग की ओर) ले जाओ और मार्ग में कहीं भी कुटिलता या भटकाव (मा जिह्वरतम्) न लाओ।
            तुम वीरों (उत्तम संतानों/शक्तियों) से युक्त होकर अपने वास्तविक निवास स्थान (स्वं गोष्ठम्) में भली-भांति विराजमान हो जाओ।
            यह मंत्र स्पष्ट करता है कि हमारी प्रार्थनाएं केवल तभी देवों तक पहुँचती हैं जब वे पवित्र और ज्ञान (पूर्व दिशा) की ओर प्रेरित हों।
            'ऊर्ध्वं यज्ञं नयतं' का अर्थ है कि हमारा हर कर्म हमें आध्यात्मिक रूप से ऊपर उठाए; हमारा जीवन कभी भी पतन (नीचे) की ओर न जाए।
            ईश्वर से प्रार्थना है कि वे हमारे जीवन में 'कुटिलता' न आने दें, क्योंकि कुटिल मन से किया गया बड़े से बड़ा यज्ञ भी फलदायी नहीं होता।
            'स्वं गोष्ठ' का अर्थ है अपनी आत्मा का मूल घर; हमारा मन संसार में भटकने के बाद अंततः उसी परम शांति (ईश्वर) में टिक जाना चाहिए।
            हम जो भी कर्म करें, वह वीर भाव (साहस और आत्मविश्वास) से भरा हो, ताकि समाज में धर्म की स्थापना हो सके।
            यह मंत्र मनुष्य को निरंतर प्रगति, सीधा आचरण और ईश्वरीय शक्तियों के प्रति पूर्ण समर्पण का महान उपदेश देता है।
        """.trimIndent(),
        englishCommentary = """
            O powers that carry messages to the ears of the gods! Loudly proclaim (Aghosha) this great sacrifice of ours in the divine realms.
            O our resolving powers! Move towards the east (towards light and knowledge) and make this non-violent sacrifice (Adhvara) completely successful.
            Continuously lead this sacrifice of ours upwards (Urdhvam/towards heaven) and do not bring any crookedness or wandering (Ma Jihvaratam) on the path.
            Endowed with brave ones (excellent progeny/powers), be perfectly seated in your own true dwelling place (Svam Goshtham).
            This mantra clarifies that our prayers reach the gods only when they are pure and inspired towards knowledge (the east).
            'Urdhvam yajnam nayatam' means that every action of ours should elevate us spiritually; our life must never fall downwards.
            A prayer is made to God not to let 'crookedness' enter our lives, because even the greatest sacrifice done with a crooked mind bears no fruit.
            'Svam Goshta' means the original home of one's soul; after wandering in the world, our mind must ultimately rest in that supreme peace (God).
            Whatever action we perform, let it be filled with a heroic spirit (courage and self-confidence) so that Dharma can be established in society.
            This mantra gives a great teaching of continuous progress, straightforward conduct, and complete surrender to divine forces.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 12,
        sanskrit = "अभि त्यं देवं सवितारमोण्योः कविक्रतुम् ।\nअर्चामि सत्यसवं रत्नधामभि प्रियं मतिम् ॥ १२ ॥",
        hindiCommentary = """
            मैं उन महान सविता देव (सृष्टिकर्ता और प्रकाश के देव) की चारों ओर से (अभि) अत्यंत श्रद्धापूर्वक स्तुति (अर्चामि) करता हूँ।
            वे सविता देव जो स्वर्ग और पृथ्वी (ओण्योः) दोनों के रक्षक हैं, जो अत्यंत क्रान्तदर्शी (कविक्रतु - भविष्य को जानने वाले) हैं।
            जिनकी प्रेरणा और शक्ति सर्वथा सत्य (सत्यसवम्) है, जो सभी प्रकार के रत्नों (ज्ञान और धन) को धारण करने और देने वाले (रत्नधाम्) हैं।
            और जो अपनी श्रेष्ठ बुद्धि (मतिम्) के कारण सभी प्राणियों को अत्यंत प्रिय (प्रियम्) हैं; मैं उन परमेश्वर का ध्यान करता हूँ।
            दीक्षा के बाद सविता देव की यह स्तुति साधक के भीतर एक दिव्य तेज उत्पन्न करती है; 'कविक्रतु' का अर्थ है जो बिना देखे ही सब जानता है।
            ईश्वर की प्रेरणा 'सत्यसव' है; जब हम ईश्वर से प्रेरित होकर कोई काम करते हैं, तो वह कार्य कभी झूठा या विनाशकारी नहीं हो सकता।
            'रत्न' का अर्थ यहाँ केवल भौतिक आभूषण नहीं है, बल्कि सद्गुण, शील, शांति और ज्ञान रूपी वे सच्चे रत्न हैं जो जीवन को सजाते हैं।
            हे प्रभु! आप हमारे जीवन के दोनों लोकों (भौतिक और आध्यात्मिक) की रक्षा करें और हमारे हृदय में अपने सत्य का प्रकाश भर दें।
            जैसे सूर्य के उदय होने पर संसार के सभी प्राणी प्रसन्न (प्रिय) होते हैं, वैसे ही आपकी कृपा हमारे जीवन को असीम आनंद से भर दे।
            हम अपना सारा अज्ञान त्याग कर केवल आपकी 'मति' (सद्बुद्धि) के अनुसार चलें, ताकि हम भी समाज के लिए एक रत्न (मार्गदर्शक) बन सकें।
        """.trimIndent(),
        englishCommentary = """
            I intensely and reverently praise (Archami) that great God Savitar (Creator and Lord of light) from all sides (Abhi).
            That Savitar who is the protector of both heaven and earth (Onyoh), and who is far-seeing (Kavikratu - knower of the future).
            Whose inspiration and power is absolutely true (Satyasavam), and who is the holder and bestower of all kinds of gems (Ratnadham - wealth and knowledge).
            And who is extremely dear (Priyam) to all beings due to His excellent wisdom (Matim); I meditate upon that Supreme Lord.
            After initiation, this praise of Savitar generates a divine brilliance within the seeker; 'Kavikratu' means one who knows everything without even looking.
            God's inspiration is 'Satyasava'; when we perform an action inspired by God, that action can never be false or destructive.
            'Ratna' (gem) here does not just mean physical jewelry, but those true gems of virtue, modesty, peace, and knowledge that adorn life.
            O Lord! Protect both realms (material and spiritual) of our lives and fill our hearts completely with the light of Your truth.
            Just as all beings in the world become joyful (dear) when the sun rises, may Your grace fill our lives with boundless joy.
            Let us abandon all our ignorance and walk solely according to Your 'Mati' (good wisdom), so that we too can become a gem (guide) for society.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 13,
        sanskrit = "देवश्रुतो देवेष्वाघोषत ।\nप्राची प्रेतमध्वरं कल्पयन्ती ऊर्ध्वं यज्ञं नयतं मा जिह्वरतम् ॥ १३ ॥",
        hindiCommentary = """
            (यज्ञ के निर्बाध पूर्ण होने की प्रार्थना) हे देवों के कानों तक हमारी प्रार्थनाओं को पहुँचाने वाली पावन शक्तियों (देवश्रुतः)!
            तुम देवताओं के मध्य हमारे इस महान अनुष्ठान की घोषणा करो, ताकि वे हमारी हवि ग्रहण करने के लिए यहाँ पधारें।
            तुम पूर्व दिशा (सूर्य के उदय होने की दिशा/ज्ञान की दिशा) की ओर आगे बढ़ो और इस यज्ञ (अध्वर) को पूरी तरह से सिद्ध करो।
            हमारे इस यज्ञ (शुभ कर्म) को तुम निरंतर ऊपर की ओर (ईश्वर की ओर) ले जाओ और इसे मार्ग में कभी भी कुटिल मत होने दो (मा जिह्वरतम्)।
            बार-बार 'ऊर्ध्वं नयतम्' (ऊपर ले जाओ) का उद्घोष मनुष्य को यह सिखाता है कि जीवन का लक्ष्य केवल खाना-पीना नहीं, बल्कि आत्मिक उन्नति है।
            'पूर्व दिशा' ज्ञान और नवजागरण का प्रतीक है; हमारा हर कदम अज्ञान (पश्चिम/अंधकार) से ज्ञान (पूर्व/प्रकाश) की ओर ही उठना चाहिए।
            कुटिलता (जिह्वरतम्) का निषेध सबसे आवश्यक है, क्योंकि यदि मन में कपट हो तो लाखों मंत्र भी ईश्वर को प्रसन्न नहीं कर सकते।
            हे परमात्मा! हमारे मन को इतना सरल और पारदर्शी बना दें कि हमारी हर प्रार्थना सीधे आपके हृदय तक बिना किसी अवरोध के पहुँच जाए।
            हम जो भी कर्म करें, वह इतना पवित्र हो कि देवता स्वयं आकर उस कर्म को सफल बनाएं और हमारे जीवन को आशीर्वाद से भर दें।
            यज्ञ की सफलता इसी में है कि वह मनुष्य को उसकी निम्न प्रवृत्तियों से उठाकर ब्रह्मांडीय चेतना के उच्च शिखर तक पहुँचा दे।
        """.trimIndent(),
        englishCommentary = """
            (Prayer for the uninterrupted completion of the sacrifice) O holy powers that carry our prayers to the ears of the gods (Devashrutah)!
            Proclaim this great ritual of ours among the gods, so that they may arrive here to accept our oblations.
            Move forward towards the east (the direction of sunrise / direction of knowledge) and completely perfect this sacrifice (Adhvara).
            Continuously lead this sacrifice (auspicious action) of ours upwards (towards God) and never let it become crooked on the path (Ma Jihvaratam).
            The repeated declaration of 'Urdhvam Nayatam' (lead upwards) teaches humans that life's goal is not just eating and drinking, but spiritual elevation.
            The 'East direction' is the symbol of knowledge and awakening; our every step must rise from ignorance (west/darkness) towards knowledge (east/light).
            The prohibition of crookedness (Jihvaratam) is most essential, because if there is deceit in the mind, even millions of mantras cannot please God.
            O Supreme Lord! Make our mind so simple and transparent that every prayer of ours reaches directly to Your heart without any hindrance.
            Whatever action we perform, let it be so pure that the gods themselves come and make it successful, filling our lives with blessings.
            The success of a sacrifice lies entirely in elevating a human from their lower tendencies and taking them to the high peak of cosmic consciousness.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 14,
        sanskrit = "स्वं गोष्ठमा सदत वीरवन्ती ।\nअदित्यास्त्वोपस्थे सादयामि ॥ १४ ॥",
        hindiCommentary = """
            (सोम रस/वनस्पति की वेदी पर स्थापना) हे यज्ञ की पावन शक्तियों! तुम उत्तम वीरों (सत्कर्मों और ऊर्जा) से युक्त होकर...
            अपने स्वयं के वास्तविक निवास स्थान (स्वं गोष्ठम्) में भली-भांति विराजमान हो जाओ।
            हे सोम (परमानंद के प्रतीक)! मैं तुम्हें माता अदिति (अखंड पृथ्वी और ईश्वरीय सत्ता) की परम पवित्र और वात्सल्यमयी गोद में स्थापित करता हूँ।
            सोम का 'अदिति की गोद' में आना इस बात का प्रतीक है कि संसार का सारा आनंद और ऊर्जा अंततः उसी एक अखंड परमात्मा (अदिति) से ही उत्पन्न होती है।
            जब तक मनुष्य का मन 'अदिति' (विशालता) की शरण में नहीं जाता, तब तक वह जीवन के 'सोम' (सच्चे सुख) का अनुभव नहीं कर सकता।
            वीरवन्ती का अर्थ है शूरवीरता; सत्य के मार्ग पर चलने के लिए शरीर और मन दोनों का वीर (मजबूत) होना अत्यंत आवश्यक है।
            हे प्रभु! जिस प्रकार एक बालक अपनी माता की गोद में पूर्णतः सुरक्षित और शांत रहता है, वैसे ही हमारी आत्मा आपकी शरण में परम शांति पाए।
            हम अपने अहंकार और कुविचारों को त्याग कर अपने मन रूपी गोष्ठ (घर) को इतना पवित्र बनाएं कि ईश्वर स्वयं उसमें निवास करे।
            हम जो भी ग्रहण करें, वह अदिति के प्रसाद के रूप में हो; इससे हमारे भीतर की सारी खंडित भावनाएं (भेदभाव) समाप्त हो जाएंगी।
            यह मंत्र हमें प्रकृति के प्रति गहरा सम्मान और ईश्वरीय सत्ता के प्रति असीम समर्पण की भावना से पूरी तरह भर देता है।
        """.trimIndent(),
        englishCommentary = """
            (Establishing Soma on the altar) O holy powers of the sacrifice! Endowed with excellent heroes (noble deeds and energy)...
            Be perfectly seated in your very own real dwelling place (Svam Goshtham).
            O Soma (symbol of supreme bliss)! I establish you into the supremely holy and affectionate lap of Mother Aditi (unbroken Earth and Divine Reality).
            Soma coming into 'Aditi's lap' symbolizes that all the joy and energy of the world ultimately originates solely from that one unbroken Supreme Lord (Aditi).
            Until a human's mind takes refuge in 'Aditi' (vastness), they simply cannot experience the 'Soma' (true happiness) of life.
            Viravanti means heroism; to walk on the path of truth, it is absolutely essential for both the body and mind to be heroic (strong).
            O Lord! Just as a child remains completely safe and peaceful in its mother's lap, may our soul find supreme peace in Your refuge.
            Abandoning our ego and evil thoughts, let us make the dwelling (Goshtha) of our mind so pure that God Himself resides in it.
            Whatever we consume, let it be as Aditi's grace; this will completely end all fragmented feelings (discrimination) within us.
            This mantra fills us completely with a deep respect for nature and a feeling of boundless surrender towards the divine reality.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 15,
        sanskrit = "विश्वो देवस्य नेतुर्मर्तो वुरीत सख्यम् ।\nविश्वो राय इषुध्यति द्युम्नं वृणीत पुष्यसे स्वाहा ॥ १५ ॥",
        hindiCommentary = """
            (दृढ़ता हेतु पुनरावृत्ति) विश्व का प्रत्येक मरणशील मनुष्य (मर्त्य) उस महान पथप्रदर्शक (नेता) परमेश्वर की मित्रता (सख्यम्) की ही कामना करता है।
            संसार का हर प्राणी उस परम ऐश्वर्य (धन) की इच्छा रखता है, इसलिए वह अपने पूर्ण पोषण के लिए ईश्वरीय तेज (द्युम्न) को ही चुनता है, स्वाहा।
            यह मंत्र इस बात पर बल देता है कि मनुष्य चाहे कितने भी सांसारिक मित्र बना ले, पर अंत समय में केवल ईश्वर ही उसका सच्चा सखा होता है।
            सख्यम् (मित्रता) का भाव यह है कि ईश्वर हमारा स्वामी या शासक ही नहीं, बल्कि हमारा सबसे अंतरंग मित्र है जिससे हम कुछ भी साझा कर सकते हैं।
            धन (रयि) की इच्छा बुरी नहीं है, परंतु वह धन यदि ईश्वरीय प्रकाश (द्युम्न) से युक्त न हो, तो वह मनुष्य को अंधा और अहंकारी बना देता है।
            हे परमात्मा! हमें ऐसा विवेक दें कि हम संसार के झूठे प्रलोभनों को छोड़कर केवल आपकी सच्ची मित्रता का ही वरण (चुनाव) करें।
            हम जो भी कर्म रूपी आहुति (स्वाहा) दें, वह हमारे अहंकार को जलाकर हमारी आत्मा को उसी दिव्य तेज (द्युम्न) से पुष्ट करे।
            जब ईश्वर हमारा मार्गदर्शक (नेता) बन जाता है, तो जीवन की कोई भी विपत्ति हमें हमारे लक्ष्य (मोक्ष) से भटका नहीं सकती।
            ईश्वर का सान्निध्य ही मनुष्य का सच्चा पोषण है; इसके बिना संसार के सारे सुख भी आत्मा की भूख को कभी शांत नहीं कर सकते।
            हमारा जीवन इस परम मित्र के साथ एक ऐसी सुंदर यात्रा बन जाए, जहाँ मृत्यु का भय समाप्त हो और केवल अमरत्व का आनंद शेष रहे।
        """.trimIndent(),
        englishCommentary = """
            (Repetition for firmness) Every mortal human (Martya) of the world desires and chooses only the friendship (Sakhyam) of that great guiding Supreme Lord (Neta).
            Every creature in the world desires that supreme wealth, therefore, for one's complete nourishment, one chooses only the divine brilliance (Dyumna), Svaha.
            This mantra emphasizes that no matter how many worldly friends a human makes, in the end, only God is their true friend.
            The feeling of Sakhyam (friendship) is that God is not just our master or ruler, but our most intimate friend with whom we can share anything.
            The desire for wealth (Rayi) is not bad, but if that wealth is not accompanied by divine light (Dyumna), it makes a human blind and arrogant.
            O Supreme Lord! Give us such discernment that abandoning the false temptations of the world, we choose only Your true friendship.
            Whatever oblation of action (Svaha) we offer, may it burn our ego and nourish our soul with that exact same divine brilliance (Dyumna).
            When God becomes our guide (Neta), no calamity in life can ever distract us from our ultimate goal (liberation).
            God's proximity is a human's true nourishment; without it, even all worldly joys can never satisfy the hunger of the soul.
            May our life become such a beautiful journey with this Supreme Friend, where the fear of death ends and only the joy of immortality remains.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 16,
        sanskrit = "त्वमग्ने व्रतपा असि देव आ मर्त्येष्वा ।\nत्वं यज्ञेष्वीड्यः ॥ १६ ॥",
        hindiCommentary = """
            (दीक्षा की पूर्णता का मंत्र) हे अग्निदेव! आप मरणशील मनुष्यों (मर्त्येषु) के बीच निवास करने वाले साक्षात् देव हैं; आप ही हमारे व्रतों (संकल्पों) के परम रक्षक (व्रतपा) हैं।
            आप ही हमारे सभी श्रेष्ठ कर्मों और महायज्ञों में अत्यंत स्तुति करने योग्य (ईड्यः) और पूजनीय परमेश्वर हैं।
            दीक्षा के समय इस मंत्र को दोहराने का अर्थ है कि साधक अब अपने संकल्प को पूरी तरह ईश्वर के अधीन कर रहा है; अब ईश्वर ही उसकी रक्षा करेंगे।
            मनुष्य का स्वभाव अस्थिर है, वह संकल्प लेता है और तोड़ देता है; परंतु जब अग्नि (ईश्वर) 'व्रतपा' बन जाते हैं, तो संकल्प अटल हो जाता है।
            मर्त्य (मरणशील) के बीच देव (अमर) का निवास यह दर्शाता है कि हमारे इस नश्वर शरीर के भीतर एक अमर और ईश्वरीय आत्मा विराजमान है।
            हे प्रभु! हमारे व्रतों की रक्षा करें; हम सत्य, अहिंसा और ब्रह्मचर्य के जिस मार्ग पर चले हैं, उससे हमें कभी भी गिरने न दें।
            संसार में प्रशंसा के योग्य (ईड्य) केवल वही है जो सत्य है; हम झूठे मनुष्यों की चापलूसी छोड़कर केवल आपकी ही वंदना करें।
            हमारा यह यज्ञ केवल दिखावा न हो, बल्कि वह हमारे अंतःकरण को इतना तपा दे कि हमारे सारे पाप जलकर भस्म हो जाएं।
            जब ईश्वर स्वयं हमारे संकल्पों का रक्षक बन जाता है, तो संसार की कोई भी आसुरी शक्ति हमारे धर्म को भ्रष्ट नहीं कर सकती।
            हम पूर्णतः निर्भय होकर अपना जीवन जिएं, क्योंकि हमारी रक्षा वह कर रहा है जो सारे ब्रह्मांड का पालनहार और परम सत्य है।
        """.trimIndent(),
        englishCommentary = """
            (Mantra of initiation's completion) O Agni! You are the direct God residing among mortal humans (Martyeshu); You alone are the supreme protector of our vows (Vratapa).
            You alone are the most praiseworthy (Idyah) and worshipful Supreme Lord in all our noble deeds and grand sacrifices.
            Repeating this mantra during initiation means the seeker is now completely surrendering his resolve to God; now God alone will protect it.
            Human nature is unstable; one takes resolutions and breaks them; but when Agni (God) becomes 'Vratapa', the resolve becomes completely unshakable.
            The residence of God (immortal) among mortals shows that an immortal and divine soul resides right within this perishable body of ours.
            O Lord! Protect our vows; the path of truth, non-violence, and celibacy that we have walked upon, never ever let us fall from it.
            In the world, only that which is Truth is worthy of praise (Idya); abandoning the flattery of false humans, let us solely worship You.
            Let this sacrifice of ours not be a mere show, but let it heat our conscience so much that all our sins are completely burnt to ashes.
            When God Himself becomes the protector of our resolutions, no demonic force in the world can ever corrupt our Dharma.
            Let us live our lives completely fearless, because we are being protected by the One who is the nourisher of the whole universe and the Ultimate Truth.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 17,
        sanskrit = "अदित्यास्त्वोपस्थे सादयामि ।\nअग्ने हव्यं रक्षस्व ॥ १७ ॥",
        hindiCommentary = """
            हे सोम (या हवि)! मैं तुम्हें माता अदिति (अखंड पृथ्वी/प्रकृति की परम शक्ति) की अत्यंत पावन और वात्सल्यमयी गोद (उपस्थ) में स्थापित करता हूँ।
            हे अग्निदेव! आप हमारी इस अर्पित की गई हवि (हव्यम्) की सब प्रकार से रक्षा (रक्षस्व) करें।
            सोम (आध्यात्मिक आनंद) को अदिति (अखंडता) की गोद में रखने का अर्थ है कि सच्चा सुख तभी मिलता है जब हम स्वयं को सृष्टि के साथ एक (अखंड) मान लेते हैं।
            अग्नि से रक्षा की प्रार्थना इसलिए की गई है ताकि हमारे द्वारा किए गए शुभ कर्मों पर अज्ञान, आलस्य या अहंकार रूपी राक्षसों का साया न पड़े।
            हम जो भी कर्म ईश्वर को अर्पित करते हैं, वह तभी फलीभूत होता है जब वह अत्यंत सुरक्षित और पवित्र भावनाओं से भरा हो।
            हे परमात्मा! हमारे मन की वेदी पर स्थापित इस सत्य के व्रत की आप स्वयं रक्षा करें ताकि कोई भी सांसारिक प्रलोभन इसे नष्ट न कर सके।
            माता अदिति हमारी रक्षा ठीक उसी प्रकार करें जैसे एक माँ अपने नवजात शिशु को अपनी छाती से लगाकर सभी खतरों से बचाती है।
            हम प्रकृति के प्रति सदैव कृतज्ञ रहें, क्योंकि हमारा शरीर और हमारे सभी साधन उसी परम माता के अंश से ही उत्पन्न हुए हैं।
            यज्ञ का यह पवित्र क्षण हमें यह अनुभव कराए कि हम इस ब्रह्मांड में अकेले नहीं हैं, बल्कि ईश्वरीय शक्तियां हमारे चारों ओर हमारी रक्षा कर रही हैं।
            हमारा पूरा जीवन आपके चरणों में एक सुरक्षित आहुति बन जाए, जिसका फल पूरे संसार में प्रेम और शांति के रूप में निरंतर फैलता रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma (or oblation)! I establish you into the supremely holy and affectionate lap (Upastha) of Mother Aditi (the absolute power of unbroken Earth/Nature).
            O Agni! Please completely protect (Rakshasva) this oblation (Havyam) offered by us from all sides.
            Placing Soma (spiritual bliss) in the lap of Aditi (boundlessness) means true happiness is found only when we consider ourselves one (unbroken) with creation.
            The prayer for protection to Agni is made so that the shadows of demons in the form of ignorance, laziness, or ego do not fall on our noble deeds.
            Whatever action we offer to God is fruitful only when it is completely secure and filled with extremely pure emotions.
            O Supreme Lord! Please personally protect this vow of truth established on the altar of our mind so that no worldly temptation can ever destroy it.
            May Mother Aditi protect us exactly like a mother protects her newborn child from all dangers by holding it to her chest.
            Let us always remain grateful to Nature, because our body and all our resources are born solely from the parts of that Supreme Mother.
            May this holy moment of the sacrifice make us realize that we are not alone in this universe, but divine forces are protecting us all around.
            May our entire life become a secure oblation at Your feet, the fruit of which continuously spreads as pure love and peace throughout the world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 18,
        sanskrit = "देवस्य त्वा सवितुः प्रसवेऽश्विनोर्बाहुभ्यां पूष्णो हस्ताभ्याम् ।\nआददे नार्यसि ॥ १८ ॥",
        hindiCommentary = """
            (यज्ञ के उपकरण ग्रहण का मंत्र) सृष्टिकर्ता सविता देव (सूर्य) की पावन प्रेरणा से, अश्विनीकुमारों की बलशाली भुजाओं से और पूषा देव के हाथों से...
            मैं तुम्हें (यज्ञ की अरणि या साधन को) ग्रहण करता हूँ (आददे); तुम 'नारी' (अग्नि को उत्पन्न करने वाली मातृ-शक्ति) हो।
            यज्ञ में अग्नि उत्पन्न करने वाली अरणि (लकड़ी) को यहाँ 'नारी' (स्त्री/माता) कहकर संबोधित किया गया है; क्योंकि उसी के गर्भ (घर्षण) से अग्निदेव का जन्म होता है।
            यह मंत्र वैदिक संस्कृति में 'मातृ-शक्ति' के महान सम्मान को दर्शाता है; स्त्री ही वह शक्ति है जो परिवार और समाज में प्रकाश (अग्नि) को जन्म देती है।
            कोई भी कर्म करते समय साधक अपने भीतर देवताओं की शक्ति (सविता की प्रेरणा, अश्विनी का बल, पूषा का पोषण) का अनुभव करता है, जिससे अहंकार नष्ट होता है।
            हे प्रभु! हमें यह विवेक दें कि हम संसार के सभी साधनों और शक्तियों का उपयोग केवल आपकी प्रेरणा से और धर्म के महान कार्यों के लिए ही करें।
            नारी शक्ति का सम्मान ही किसी भी राष्ट्र की उन्नति का आधार है; जहाँ नारी का आदर होता है, वहीं ईश्वरीय प्रकाश (अग्नि) का वास होता है।
            हम जो भी साधन ग्रहण करें, वह हमारे जीवन में एक नई ऊर्जा और आध्यात्मिक जाग्रति को जन्म देने वाला बने।
            हमारा यह कर्म ईश्वरीय हाथों द्वारा संचालित हो, जिससे हमारे प्रत्येक कार्य में परोपकार, पूर्णता और सफलता का ही दर्शन हो।
            यह मंत्र हमें निमित्त मात्र बनकर ईश्वर की इस विराट रचना में एक सेवक की तरह अपना योगदान देने की अत्यंत सुंदर शिक्षा देता है।
        """.trimIndent(),
        englishCommentary = """
            (Mantra for taking sacrificial tools) Impelled by the holy inspiration of Creator Savitar (Sun), with the strong arms of the Ashvins, and the hands of Pushan...
            I accept (Aadade) you (the Arani wood or implement of sacrifice); you are 'Nari' (the maternal power that gives birth to Agni).
            The Arani (wood) that generates fire in the sacrifice is addressed here as 'Nari' (Woman/Mother); because from its womb (friction) Lord Agni is born.
            This mantra reflects the great respect for 'Maternal Power' in Vedic culture; a woman is the power that gives birth to light (Agni) in family and society.
            While performing any action, the seeker feels the power of the gods (Savitar's inspiration, Ashvins' strength, Pushan's nourishment) within, which destroys ego.
            O Lord! Give us the wisdom to use all the tools and powers of the world solely by Your inspiration and strictly for the great works of Dharma.
            Respecting women's power is the foundation of any nation's progress; where women are honored, there resides the divine light (Agni).
            Whatever tool we accept, may it give birth to a completely new energy and profound spiritual awakening in our lives.
            May this action of ours be guided by divine hands, so that benevolence, absolute perfection, and success are seen in every single task of ours.
            This mantra gives us the extremely beautiful teaching to become mere instruments and contribute like a humble servant in this vast creation of God.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 19,
        sanskrit = "अग्नेर्जनित्रमसि वृषणौ स्थ ऊर्वशीवामसि आयुरसि ।\nपुरूरवामसि गायत्रेण त्वा छन्दसा मन्थामि ॥ १९ ॥",
        hindiCommentary = """
            (अरणि मंथन - अग्नि प्रज्वलित करने का मंत्र) हे नीचे की अरणि! तू अग्नि की माता (जनित्रम्/उत्पत्ति स्थान) है; हे दोनों अरणियों! तुम अग्नि की वर्षा (वृषणौ) करने वाली हो।
            तू उर्वशी (नीचे की अरणि/अप्सरा) के समान है, और तू आयु (घर्षण का मध्य भाग) है।
            तू पुरूरवा (ऊपर की अरणि/राजा) के समान है; मैं तुझे अत्यंत पवित्र 'गायत्री छंद' के द्वारा मथता (घर्षण करता) हूँ।
            यह मंत्र यज्ञ में अग्नि उत्पन्न करने की अत्यंत वैज्ञानिक और काव्यात्मक (Poetic) प्रक्रिया का वर्णन करता है, जहाँ घर्षण को पुरूरवा और उर्वशी के मिलन का रूपक दिया गया है।
            उर्वशी (प्रकृति/मातृ शक्ति) और पुरूरवा (पुरुष/चेतना) के मंथन से ही अग्नि (ज्ञान और ऊर्जा) का जन्म होता है; यह सृष्टि के निर्माण का मूल रहस्य है।
            गायत्री छंद के द्वारा मथने का अर्थ है कि अग्नि केवल भौतिक लकड़ी के घर्षण से नहीं, बल्कि मंत्रों की पवित्र ध्वनि और ध्यान की एकाग्रता से जाग्रत होती है।
            हे परमात्मा! मेरे भीतर भी ध्यान की अरणियों का ऐसा ही मंथन हो कि मेरे अंतःकरण में ज्ञान की वह परम अग्नि प्रज्वलित हो जाए जो सारे अज्ञान को जला दे।
            हम अपने मन और प्राण का मंथन (योग साधना) करें, ताकि हम अपने ही भीतर छिपे हुए उस परमानंद (ईश्वर) के साक्षात् दर्शन कर सकें।
            जैसे कठिन घर्षण से ही अग्नि प्रकट होती है, वैसे ही जीवन में कठोर तपस्या और संघर्ष से ही सफलता और चारित्रिक महानता प्राप्त होती है।
            हमारा जीवन इस पावन अग्नि के समान अत्यंत तेजस्वी बने और हमारे सत्कर्मों का प्रकाश पूरे समाज के अंधकार को हमेशा के लिए दूर कर दे।
        """.trimIndent(),
        englishCommentary = """
            (Arani Manthan - Mantra for kindling fire) O lower Arani! You are the mother (Janitram/origin) of Agni; O both Aranis! You are the showerers (Vrishanau) of Agni.
            You are like Urvashi (the lower wood/nymph), and you are Ayu (the middle part of friction).
            You are like Pururavas (the upper wood/king); I churn (rub) you strictly using the highly sacred 'Gayatri meter'.
            This mantra describes the highly scientific and poetic process of generating fire in a sacrifice, where friction is metaphorically the union of Pururavas and Urvashi.
            Only through the churning of Urvashi (Nature/Maternal power) and Pururavas (Purusha/Consciousness) is Agni (knowledge and energy) born; this is the core secret of creation.
            Churning through the Gayatri meter means fire is awakened not just by physical friction of wood, but by the holy sound of mantras and deep concentration.
            O Supreme Lord! May there be such a churning of meditation's Aranis within me too that the supreme fire of knowledge is kindled in my conscience, burning all ignorance.
            Let us churn our mind and vital breath (Yoga practice), so that we can directly see that supreme bliss (God) completely hidden within our own selves.
            Just as fire manifests only through hard friction, similarly, success and greatness of character are attained in life only through hard penance and struggle.
            May our life become extremely brilliant like this holy fire, and may the light of our noble deeds remove the deep darkness of the entire society forever.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 20,
        sanskrit = "त्रैष्टुभेन त्वा छन्दसा मन्थामि ।\nजागतेन त्वा छन्दसा मन्थामि ॥ २० ॥",
        hindiCommentary = """
            (अरणि मंथन की निरंतरता) मैं तुझे महान 'त्रिष्टुप' छंद (तेज और बल के प्रतीक) के द्वारा निरंतर मथता (घर्षण करता) हूँ।
            मैं तुझे पावन 'जगती' छंद (विस्तार और गति के प्रतीक) के द्वारा भली-भांति मथता हूँ, ताकि अग्नि शीघ्र प्रज्वलित हो।
            अग्नि को प्रकट करने के लिए गायत्री (मंत्र 19), त्रिष्टुप और जगती—इन तीन प्रमुख वैदिक छंदों का प्रयोग किया जाता है; ये तीनों ब्रह्मांड की तीन महान लय (Rhythms) हैं।
            त्रिष्टुप छंद में शक्ति (इंद्र) का वास है, और जगती में सभी देवों (विश्वेदेव) का; यह दर्शाता है कि ईश्वर की प्राप्ति के लिए हमें अपनी सभी शक्तियों और लय को एकाग्र करना होता है।
            मंथन (घर्षण) एक सतत प्रक्रिया है; यदि हम बीच में रुक जाएं, तो अग्नि प्रकट नहीं होती। इसी प्रकार आध्यात्मिक साधना में निरंतरता परम आवश्यक है।
            हे प्रभु! मेरी साधना में ऐसा अखंड अनुशासन हो कि मेरा ध्यान कभी भंग न हो और मैं अंततः उस परम ज्ञान रूपी अग्नि को अपने भीतर अनुभव कर सकूं।
            हम जीवन की कठिनाइयों (घर्षण) से घबराएं नहीं, क्योंकि यही संघर्ष हमारे भीतर सोई हुई अनंत ऊर्जा और क्षमताओं को जाग्रत करता है।
            हमारा हर श्वास और हर विचार वेदों के इन पवित्र छंदों की लय में बंध जाए, ताकि हमारा जीवन एक अत्यंत संगीतमय और शांतिपूर्ण यज्ञ बन सके।
            जिस प्रकार इन छंदों से अग्नि बाहर आती है, उसी प्रकार हमारे श्रेष्ठ कर्मों से इस समाज में न्याय, प्रेम और सत्य का प्रकाश बाहर आए।
            यह वैदिक प्रक्रिया हमें सिखाती है कि पूर्ण सफलता के लिए बल (त्रिष्टुप), गति (जगती) और पवित्रता (गायत्री) तीनों का अद्भुत संगम होना अत्यंत आवश्यक है।
        """.trimIndent(),
        englishCommentary = """
            (Continuation of Arani Manthan) I continuously churn (rub) you using the great 'Trishtubh' meter (symbol of brilliance and strength).
            I thoroughly churn you using the holy 'Jagati' meter (symbol of expansion and motion), so that the fire kindles swiftly.
            To manifest Agni, the three major Vedic meters—Gayatri (Mantra 19), Trishtubh, and Jagati—are used; these three are the three great rhythms of the universe.
            Power (Indra) resides in the Trishtubh meter, and all gods (Vishvedevas) in Jagati; this shows that to attain God, we must concentrate all our powers and rhythms.
            Churning (friction) is a continuous process; if we stop in between, the fire does not manifest. Similarly, continuity is absolutely essential in spiritual practice.
            O Lord! May there be such unbroken discipline in my spiritual practice that my focus never breaks, and I ultimately experience that supreme fire of knowledge within.
            Let us not be afraid of life's difficulties (friction), because this very struggle awakens the infinite energy and capabilities deeply sleeping within us.
            May our every breath and thought be bound in the rhythm of these holy Vedic meters, so our life becomes an extremely musical and peaceful sacrifice.
            Just as fire comes out through these meters, similarly, may the light of justice, pure love, and truth come out in this society through our excellent deeds.
            This Vedic process teaches us that for absolute success, an amazing confluence of strength (Trishtubh), motion (Jagati), and purity (Gayatri) is highly essential.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 21,
        sanskrit = "भवतं नः समनसौ सचेतसावरेपसौ ।\nमा यज्ञँ हिंसिष्टं मा यज्ञपतिं जातवेदसौ शिवौ भवतमद्य नः ॥ २१ ॥",
        hindiCommentary = """
            हे उत्पन्न हुई दोनों अग्नियों (गार्हपत्य और आहवनीय)! तुम दोनों हमारे लिए समान मन वाली (समनसौ) और एक समान चेतना वाली (सचेतसौ) होकर अनुकूल हो जाओ।
            तुम दोनों पूर्णतः पाप और दोषरहित (अरेपसौ) होओ; तुम हमारे इस महान यज्ञ को और इस यज्ञ के स्वामी (यजमान) को कोई भी हानि न पहुँचाओ (मा हिंसिष्टम्)।
            हे सब कुछ जानने वाले (जातवेदसौ) अग्निदेवों! आज तुम दोनों हमारे लिए अत्यंत कल्याणकारी और मंगलमय (शिवौ) सिद्ध होओ।
            यज्ञ में दो अग्नियां होती हैं—एक जो घर की वेदी पर है और दूसरी जो आहुति के लिए है; उन दोनों का सामंजस्य यज्ञ की सफलता के लिए अनिवार्य है।
            'समनसौ सचेतसौ' का अर्थ है मन और चेतना का पूर्ण मिलन; जब हमारे भीतर के विचार और बाहरी कर्म एक समान हो जाते हैं, तभी हम निष्पाप (अरेपसौ) कहलाते हैं।
            अग्नि विनाशकारी भी हो सकती है; इसलिए उससे प्रार्थना की जाती है कि वह अपना संहारक रूप त्याग कर केवल 'शिव' (कल्याणकारी) रूप ही धारण करे।
            हे परमात्मा! हमारे घर-परिवार के सभी सदस्यों के बीच ऐसा ही 'समनसौ' (एकता और प्रेम) स्थापित करें, ताकि कोई भी कलह हमारे जीवन को नष्ट न कर सके।
            हम जो भी शुभ कार्य (यज्ञ) करें, उसमें हमें कोई शारीरिक या मानसिक कष्ट न हो, बल्कि वह हमारे लिए केवल सुख और आध्यात्मिक उन्नति का ही कारण बने।
            हम अज्ञान रूपी हिंसा का पूर्णतः त्याग कर दें; हमारा हर कर्म समाज के लिए मंगलकारी और ईश्वर को अत्यंत प्रिय हो।
            ईश्वर 'जातवेदा' है, वह हमारे हृदयों के गुप्त भावों को जानता है; अतः हम छल-कपट छोड़कर पूरी शुद्धता के साथ इस शिव (कल्याण) स्वरूप को धारण करें।
        """.trimIndent(),
        englishCommentary = """
            O both newly born Agnis (Garhapatya and Ahavaniya)! May both of you become of one mind (Samanasau) and of one equal consciousness (Sachetasau) and be favorable to us.
            May both of you be completely free from sin and flaws (Arepasau); do not cause any harm (Ma Hinsishtam) to this great sacrifice of ours or to its master.
            O omniscient (Jatavedasau) Agnis! Today, may both of you prove to be extremely benevolent and highly auspicious (Shivau) for all of us.
            There are two fires in the sacrifice—one on the home altar and the other for oblation; their absolute harmony is compulsory for the sacrifice's success.
            'Samanasau Sachetasau' means the complete union of mind and consciousness; only when our inner thoughts and outer actions become identical are we called sinless.
            Fire can also be destructive; hence it is prayed to abandon its destructive form and assume only the 'Shiva' (benevolent) form.
            O Supreme Lord! Establish such 'Samanasau' (unity and pure love) among all members of our family, so that no discord can ever destroy our lives.
            Whatever auspicious work (sacrifice) we do, may we not face any physical or mental pain in it; rather, let it be the sole cause of our joy and spiritual elevation.
            Let us completely abandon the violence of ignorance; may every action of ours be auspicious for society and extremely dear to God.
            God is 'Jatavedas', He knows the secret feelings of our hearts; hence, leaving deceit, let us embrace this Shiva (benevolent) form with absolute purity.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 22,
        sanskrit = "अग्नावग्निश्चरति प्रविष्ट ऋषीणां पुत्रो अभिशस्तिपावा ।\nस नः स्योनः सुहवा भवाग्ने मा देवानां युयोम भागधेयम् ॥ २२ ॥",
        hindiCommentary = """
            (आहवनीय अग्नि में गार्हपत्य का प्रवेश) वह महान अग्नि जो ऋषियों का पुत्र (ऋषियों द्वारा मथकर उत्पन्न) है और जो अभिशापों से हमारी रक्षा करने वाला (अभिशस्तिपावा) है...
            वह पवित्र अग्नि अब दूसरी अग्नि (यज्ञवेदी की अग्नि) में प्रविष्ट होकर निरंतर विचरण कर रहा है।
            हे अग्निदेव! आप हमारे लिए अत्यंत सुखदायक (स्योनः) और सरलता से बुलाए जाने योग्य (सुहवा) बनें।
            हम देवताओं के उस पावन भाग (हवि/आहुति) को कभी भी उनसे अलग (युयोम) न करें; हम सदैव उन्हें उनका अंश अर्पित करते रहें।
            एक अग्नि का दूसरी अग्नि में प्रवेश यह दर्शाता है कि ईश्वरीय ज्योति एक है; चाहे उसे कितने भी दीपकों में बांटा जाए, उसका मूल स्वरूप कभी नहीं बदलता।
            अग्नि को 'ऋषियों का पुत्र' कहा गया है, क्योंकि ज्ञान रूपी अग्नि तपस्वियों के कठोर चिंतन और मन्त्रबल से ही संसार में प्रकट होती है।
            'अभिशस्तिपावा' का अर्थ है बुराइयों और पापों से बचाने वाला; ईश्वर का सान्निध्य ही वह कवच है जो हमें संसार के सभी श्रापों और दोषों से बचाता है।
            हे प्रभु! हम जीवन भर इतने कृतज्ञ रहें कि हम जो कुछ भी कमाएं, उसमें से देवताओं (प्रकृति और समाज) का भाग निकालना कभी न भूलें (परोपकार करें)।
            जब हम दूसरों का भाग नहीं मारते और धर्मपूर्वक अपना जीवन जीते हैं, तो ईश्वर हमारे लिए अत्यंत सुखदायक (स्योन) मित्र बन जाता है।
            यह यज्ञ हमारी उस आंतरिक एकता का प्रतीक बन जाए जहाँ हमारी आत्मा परमात्मा की उस अनंत अग्नि में प्रविष्ट होकर सदा के लिए अद्वैत हो जाए।
        """.trimIndent(),
        englishCommentary = """
            (Entry of Garhapatya into Ahavaniya fire) That great Agni who is the son of the sages (created by their churning) and who is our protector from curses (Abhishastipava)...
            That holy Agni, having entered into the other Agni (the altar's fire), is now continuously wandering and blazing within it.
            O Agni! Become extremely joy-giving (Syonah) to us and easily invocable (Suhava) by our prayers.
            May we never ever separate (Yuyoma) that holy portion (oblation) of the gods from them; may we always keep offering them their rightful share.
            One fire entering another shows that the divine light is one; no matter how many lamps it is divided into, its original nature never changes at all.
            Agni is called the 'son of sages' because the fire of knowledge manifests in the world solely through the rigorous contemplation and mantra-power of ascetics.
            'Abhishastipava' means the savior from evils and sins; God's proximity is the only shield that protects us from all curses and flaws of the world.
            O Lord! Let us remain so grateful all our lives that whatever we earn, we never forget to set aside the share of the gods (nature and society) from it (do charity).
            When we do not steal others' shares and live our lives righteously, God becomes an extremely joy-giving (Syona) friend for us.
            May this sacrifice become the symbol of that internal unity where our soul, entering the infinite fire of the Supreme Soul, becomes non-dual forever.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 23,
        sanskrit = "अग्ने त्वं नो अन्तम उत त्राता शिवो भवा वरूथ्यः ।\nवसुरग्निर्वासुश्रवा अच्छा नक्षि द्युमत्तमं रयिं दाः ॥ २३ ॥",
        hindiCommentary = """
            (इस अत्यंत पावन मंत्र की वेदी पर पुनः आवृत्ति) हे अग्निदेव! आप हमारे सबसे निकटतम (अन्तम) मित्र बनें; आप ही हमारे परम रक्षक (त्राता) और कल्याणकारी (शिव) हों।
            आप हमारे लिए अत्यंत श्रेष्ठ आश्रयदाता (वरूथ्य) बनें; हे वसु (सबको बसाने वाले) और महान यश वाले (वासुश्रवा) देव! 
            आप हमारी ओर आएं और हमें वह धन (रयि) प्रदान करें जो सबसे अधिक प्रकाशमान (द्युमत्तम) और श्रेष्ठ हो।
            यज्ञ के इस चरण में ईश्वर को अपना सबसे 'निकटतम' (अन्तम) मानना यह सिद्ध करता है कि ईश्वर और भक्त के बीच कोई भी दूरी या पर्दा नहीं है।
            संसार के लोग स्वार्थ के लिए रक्षा करते हैं, परंतु ईश्वर रूपी 'त्राता' बिना किसी स्वार्थ के अपने भक्तों को जीवन के हर संकट से बचाता है।
            'द्युमत्तम रयि' का वास्तविक अर्थ है वह अमर ज्ञान और आत्म-संतोष जो संसार की किसी भी तिजोरी में नहीं रखा जा सकता; यही सबसे बड़ा धन है।
            हे परमात्मा! हमारे मन के सारे भयों को दूर कर हमें अपनी वह मजबूत ढाल (वरूथ्य) प्रदान करें जिससे कोई भी बुराई हमें छू न सके।
            हम आपको बाहरी संसार में नहीं, बल्कि अपने ही अंतःकरण में खोजें, क्योंकि आप हमारे सबसे सच्चे, आत्मीय और स्थायी मित्र हैं।
            वासुश्रवा कहकर हम यह प्रार्थना करते हैं कि आपके सान्निध्य से हमारे जीवन में भी सत्य, धर्म और यश की निरंतर और अखंड वृद्धि हो।
            यह मंत्र हमें संसार के नश्वर और झूठे आश्रयों को छोड़कर केवल उस एक शाश्वत ईश्वरीय आश्रय को अपनाने की महान प्रेरणा देता है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of this highly holy mantra on the altar) O Agni! Become our closest (Antama) friend; may You alone be our supreme protector (Trata) and purely benevolent (Shiva).
            May You become the most excellent provider of refuge (Varuthya) for us; O Vasu (dweller of all) and God of great glory (Vasushrava)!
            Please come towards us and grant us that wealth (Rayi) which is the most luminous (Dyumattama), excellent, and supreme.
            Considering God as one's 'closest' (Antama) at this stage of the sacrifice proves that there is absolutely no distance or veil between God and the devotee.
            People of the world protect for selfish reasons, but the 'Trata' in the form of God protects His devotees from every life crisis without any selfishness.
            The real meaning of 'Dyumattama Rayi' is that immortal knowledge and self-satisfaction which cannot be kept in any worldly safe; this is the greatest wealth.
            O Supreme Lord! Remove all fears of our minds and grant us Your strong shield (Varuthya) so that no evil can ever even touch us.
            Let us not search for You in the external world, but right within our own conscience, because You are our truest, most intimate, and permanent friend.
            By saying Vasushrava, we pray that through Your proximity, truth, Dharma, and glory continuously and unbrokenly increase in our lives too.
            This mantra gives us the great inspiration to abandon the perishable and false refuges of the world and adopt solely that one eternal divine refuge.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 24,
        sanskrit = "तं त्वा शोचिष्ठ दीदिवः सुम्नाय नूनमीमहे सखिभ्यः ।\nस नो बोधि श्रुधी हवमुरुष्या णो अघायतः समस्मात् ॥ २४ ॥",
        hindiCommentary = """
            (रक्षामंत्र की पुनरावृत्ति) हे अत्यंत प्रकाशमान (शोचिष्ठ) और सर्वत्र दीप्तिमान (दीदिवः) अग्निदेव! हम अपने और अपने मित्रों के सुख (सुम्नाय) के लिए आपकी स्तुति करते हैं।
            हम अभी (नूनम्) आपकी याचना करते हैं; हे देव! आप हमारे अंतःकरण में भली-भांति जाग्रत (बोधि) हों और हमारी इस पुकार (हवम्) को ध्यान से सुनें।
            और आप हमें उन सभी पापों, बुराइयों और पापियों (अघायतः) से पूरी तरह से बचाएं (उरुष्य) जो हमारा अहित करना चाहते हैं।
            ईश्वर से 'जाग्रत' (बोधि) होने का आग्रह वास्तव में हमारी अपनी आत्मा को उस ईश्वरीय प्रकाश के प्रति पूरी तरह सचेत करने की तीव्र पुकार है।
            अघायतः का अर्थ है पाप और नकारात्मकता; जब तक ईश्वर हमारी रक्षा नहीं करता, हम संसार की वासनाओं और आंतरिक बुराइयों से नहीं बच सकते।
            हे प्रभु! हमारी पुकार आपके कानों तक पहुँचे और आपका तेज हमारे जीवन के हर अंधकार को जलाकर हमें परम शांति और अभय प्रदान करे।
            हम जो भी सुख प्राप्त करें, उसे अपने मित्रों और परिजनों के साथ निस्वार्थ भाव से बांटें, क्योंकि स्वार्थ में लिप्त होकर पाया गया सुख वास्तव में दुख ही है।
            ईश्वर की स्तुति से हमारा मन इतना मजबूत हो जाए कि हम किसी भी अघ (पाप) के सम्मुख कभी घुटने न टेकें और हमेशा धर्म के मार्ग पर डटे रहें।
            आपकी ज्योति हमारे चारों ओर एक ऐसा सुरक्षा चक्र बना दे जिसमें प्रवेश करके हर शत्रु मित्र बन जाए और हर दुख सुख में परिवर्तित हो जाए।
            बार-बार इन रक्षा मंत्रों का उच्चारण साधक के भीतर एक अजेय आत्मविश्वास पैदा करता है कि ब्रह्मांड की सबसे बड़ी शक्ति उसके साथ है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of protection mantra) O supremely luminous (Shochishtha) and universally radiant (Didivah) Agni! We praise You for the happiness of ourselves and our friends.
            We implore You right now (Nunam); O God! Please fully awaken (Bodhi) in our inner conscience and listen attentively to this call (Havam) of ours.
            And please protect (Urushya) us completely from all those sins, evils, and sinners (Aghayatah) who wish to cause us absolute harm.
            Urging God to 'awaken' (Bodhi) is actually an intense call to make our own soul completely conscious and sensitive towards that divine light.
            Aghayatah means sin and negativity; unless God protects us, we simply cannot escape the lusts and internal deep evils of the material world.
            O Lord! May our call reach Your ears, and may Your brilliance burn away every darkness of our lives, granting us supreme peace and fearlessness.
            Whatever happiness we attain, let us share it with our friends and family selflessly, because happiness attained while engrossed in selfishness is actually sorrow.
            May our mind become so strong through God's praise that we never kneel before any Agha (sin) and always stand firm on the path of Dharma.
            May Your light create such a protective circle around us that upon entering it, every enemy becomes a friend and every sorrow turns into joy.
            Repeated chanting of these protection mantras creates an invincible self-confidence within the seeker that the universe's greatest power is with them.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 25,
        sanskrit = "अय नोऽग्निर्वरिवस्कृणोत्वयं मृधः पुर एतु प्रभिन्दन् ।\nअयं वाजाञ्जयतु वाजसातावयं शत्रूञ्जयतु जर्हृषाणः ॥ २५ ॥",
        hindiCommentary = """
            यह प्रज्वलित अग्निदेव हमारे लिए अत्यंत श्रेष्ठ धन, स्थान और ऐश्वर्य (वरिवः) उत्पन्न करें (कृणोतु); और यह हमारे सभी विघ्नों (मृधः) को नष्ट करते हुए...
            हमारे आगे-आगे (पुरः) चलकर हमारा निरंतर मार्गदर्शन करें; यह अग्नि युद्ध (वाजसातौ) में हमारे लिए महान बल और अन्नों (वाजान्) को जीते।
            और यह अग्निदेव अत्यंत प्रसन्न (जर्हृषाणः) होकर हमारे सभी आंतरिक और बाहरी शत्रुओं (शत्रून्) पर हमें पूर्ण विजय दिलाएं।
            इस मंत्र में अग्नि से 'आगे चलने' (पुर एतु) की प्रार्थना की गई है, जिसका अर्थ है कि ईश्वरीय ज्ञान ही जीवन में हमारा प्रथम मार्गदर्शक होना चाहिए।
            जब ईश्वर हमारा नेतृत्व करता है, तो जीवन की सभी बाधाएं (मृधः) स्वतः ही टूटकर बिखर जाती हैं और हम सफलता के शिखर पर पहुँचते हैं।
            'वाज' का अर्थ अन्न और शक्ति दोनों है; धर्म के मार्ग पर चलने के लिए शरीर में अन्न की पुष्टि और आत्मा में आत्मबल दोनों का होना अनिवार्य है।
            हे परमात्मा! हमारे जीवन में ऐसा धन (वरिवः) लाएं जो पवित्र हो और जिसका उपयोग हम समाज के उत्थान के लिए कर सकें।
            हम जीवन के हर संघर्ष में विजय प्राप्त करें, लेकिन वह विजय क्रोध से नहीं, बल्कि सत्य और आपकी अत्यंत प्रसन्नता (जर्हृषाणः) से प्राप्त की गई हो।
            शत्रु केवल बाहर नहीं होते; हमारे भीतर छिपे काम, लोभ और अहंकार सबसे बड़े शत्रु हैं; हे अग्निदेव! आप इन शत्रुओं को जलाकर हमें मुक्त कर दें।
            हम पूर्णतः निर्भय होकर इस संसार में कर्म करें, क्योंकि जब प्रकाश (अग्नि) हमारे आगे है, तो अज्ञान का अंधकार हमें कभी नहीं रोक सकता।
        """.trimIndent(),
        englishCommentary = """
            May this kindled Lord Agni generate (Krinotu) the most excellent wealth, space, and prosperity (Varivah) for us; and destroying all our obstacles (Mridhah)...
            May He continuously guide us by walking right ahead (Purah) of us; may this Agni win great strength and food (Vajan) for us in the battle of life (Vajasatau).
            And becoming highly pleased and joyful (Jarhrishanah), may this Lord Agni grant us absolute victory over all our internal and external enemies (Shatrun).
            In this mantra, Agni is prayed to 'walk ahead' (Pura Etu), which means that divine knowledge must be our very first guide in life.
            When God leads us, all the obstacles (Mridhah) of life automatically break and scatter, and we reach the ultimate peak of true success.
            'Vaja' means both food and power; to walk on the path of Dharma, the nourishment of food in the body and soul-strength in the spirit are both compulsory.
            O Supreme Lord! Bring such wealth (Varivah) into our lives that is completely holy and which we can use for the upliftment of society.
            May we achieve victory in every struggle of life, but let that victory be achieved not through anger, but through truth and Your extreme joy (Jarhrishanah).
            Enemies are not just outside; lust, greed, and ego hidden within us are the biggest enemies; O Agni! Burn these enemies and set us totally free.
            Let us act in this world completely fearlessly, because when the light (Agni) is ahead of us, the darkness of ignorance can never ever stop us.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 26,
        sanskrit = "रूपेण वो रूपमभ्यागां तुथो वो विश्ववेदा विभजतु ।\nऋतस्य पथा प्रेत चन्द्रदक्षिणा विस्वः पश्य व्यन्तरिक्षम् ॥ २६ ॥",
        hindiCommentary = """
            (सोम क्रय/गौओं का मंत्र) हे गौओं! मैं अपने रूप (स्वभाव) के साथ तुम्हारे रूप के सम्मुख आया हूँ; सर्वज्ञ (विश्ववेदा) 'तुथ' देव तुम्हारा भली-भांति विभाजन करें।
            तुम सब ऋत (सत्य और धर्म) के सीधे मार्ग (पथा) पर निरंतर आगे बढ़ो (प्रेत); तुम सुवर्ण (चन्द्र) रूपी दक्षिणा देने वाली हो।
            हे यजमान! तुम स्वर्ग (स्वः) को स्पष्ट रूप से देखो और इस विस्तृत अंतरिक्ष (व्यन्तरिक्षम्) का भी अवलोकन करो।
            सोम-क्रय (सोम वनस्पति को खरीदना) यज्ञ का मुख्य भाग है, जहाँ मूल्य के रूप में गौओं (गायों) का उपयोग किया जाता है; गौएं सात्विक धन का प्रतीक हैं।
            'रूपेण रूपम्' का अर्थ है कि यजमान गौओं के साथ तादात्म्य स्थापित करता है—अर्थात् मेरा हृदय भी गौओं के समान ही अत्यंत सरल और परोपकारी हो।
            'ऋतस्य पथा' (सत्य का मार्ग) मनुष्य जीवन का सबसे बड़ा आदर्श है; हमारी संपत्ति और हमारा हर कदम केवल सत्य के मार्ग पर ही आगे बढ़ना चाहिए।
            हे प्रभु! हमारी बुद्धि को सर्वज्ञ देव (तुथ) की तरह बना दें ताकि हम संसार की वस्तुओं का सही उपयोग (विभाजन) समाज की भलाई के लिए कर सकें।
            गौएं केवल पशु नहीं हैं, वे 'चन्द्रदक्षिणा' (स्वर्ण के समान मूल्यवान) हैं, क्योंकि वे दूध और घी देकर संपूर्ण मानवता का पालन-पोषण करती हैं।
            स्वर्ग और अंतरिक्ष को देखने का आदेश यह याद दिलाता है कि हमारा दृष्टिकोण संकीर्ण (धरती तक सीमित) न रहे, बल्कि हमारे विचार आकाश जैसे विशाल हों।
            हम जो भी कर्म करें, वह प्रकृति के नियमों (ऋत) के विरुद्ध न हो, ताकि हम अंततः उस परम सत्य (ईश्वर) के साक्षात् दर्शन कर सकें।
        """.trimIndent(),
        englishCommentary = """
            (Mantra for Soma purchase/Cows) O Cows! I have approached your form with my own form (nature); may the omniscient (Vishvaveda) God 'Tutha' distribute you properly.
            May all of you continuously move forward (Preta) on the straight path (Patha) of Rta (Truth and Dharma); you are the bestowers of gold-like (Chandra) fees.
            O Sacrificer! Clearly look upon heaven (Svah) and also observe this vast, expansive space (Vyantariksham).
            Soma-Kraya (purchasing the Soma plant) is a main part of the sacrifice, where cows are used as the price; cows are the symbol of pure, virtuous wealth.
            'Rupena Rupam' means the sacrificer establishes identification with the cows—meaning my heart should also be extremely simple and benevolent like the cows.
            'Rtasya Patha' (the path of Truth) is the greatest ideal of human life; our property and our every step must advance solely on the path of absolute truth.
            O Lord! Make our intellect like the omniscient God (Tutha) so we can correctly utilize (distribute) worldly objects for the ultimate good of society.
            Cows are not just animals, they are 'Chandradakshina' (valuable like gold), because by giving milk and ghee they nourish entire humanity.
            The command to look at heaven and space reminds us that our perspective should not remain narrow (limited to earth), but our thoughts must be vast like the sky.
            Whatever deed we perform, let it not be against the laws of nature (Rta), so that we can ultimately have the direct vision of that Supreme Truth (God).
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 27,
        sanskrit = "यत्स्वस्व सूर्यमपश्यत्तद्गौर्भूत्वा प्रति त्वाऽदितिर्वेत्तु ।\nमित्रस्त्वा पथिभिर्नयत्वनागसः ॥ २७ ॥",
        hindiCommentary = """
            हे सोम! जिस समय तुमने अपने प्रकाश से साक्षात् सूर्यदेव के दर्शन किए, उस समय तुम 'गौ' (ज्ञान की रश्मि/किरण) का रूप धारण कर चुके थे।
            माता अदिति (अखंड सत्ता) तुम्हें अत्यंत प्रेम और वात्सल्य के साथ स्वीकार करें (प्रति वेत्तु)।
            मित्र देव (सूर्य/सबके स्नेही) तुम्हें निष्पाप (अनागसः) और पवित्र मार्गों (पथिभिः) से आगे की ओर ले जाएं।
            सोम का सूर्य को देखना यह दर्शाता है कि सांसारिक आनंद (सोम) जब ईश्वरीय प्रकाश (सूर्य) से जुड़ता है, तभी वह सच्चा और स्थायी आनंद बनता है।
            'गौ' शब्द वेदों में किरणों और ज्ञान का प्रतीक है; ईश्वर से जुड़कर मनुष्य की चेतना भी ज्ञान की किरण बनकर चारों ओर प्रकाश फैलाती है।
            माता अदिति द्वारा स्वीकार किए जाने का अर्थ है कि हमारा कोई भी कर्म प्रकृति के अखंड नियमों को तोड़ने वाला न हो, बल्कि वह पूर्णतः प्राकृतिक हो।
            हे परमात्मा! हमारे जीवन के प्रत्येक कदम को मित्र देव (स्नेह और समता के देव) का मार्गदर्शन मिले, ताकि हम कभी भी कुमार्ग पर न भटकें।
            हम 'अनागसः' (निष्पाप) बनें; क्योंकि जब तक हमारे हृदय में पाप या स्वार्थ है, तब तक हम ईश्वर (अदिति) की शरण में नहीं जा सकते।
            हमारे जीवन का रथ सत्य के उन पवित्र मार्गों (पथिभिः) पर चले जहाँ किसी भी प्राणी के लिए कोई दुख या घृणा शेष न रहे।
            यह मंत्र हमें सिखाता है कि आत्मज्ञान (सूर्य दर्शन) और निष्पाप आचरण ही मनुष्य को ईश्वर के सबसे करीब ले जाने वाले असली मार्ग हैं।
        """.trimIndent(),
        englishCommentary = """
            O Soma! When you directly saw the Sun God with your own light, at that time you had assumed the form of a 'Gau' (ray of knowledge).
            May Mother Aditi (the Boundless Reality) accept you (Prati Vettu) with immense love and deep affection.
            May God Mitra (Sun/friend of all) lead you forward through sinless (Anagasah) and completely holy paths (Pathibhih).
            Soma seeing the Sun shows that when worldly joy (Soma) connects with divine light (Sun), only then does it become true and permanent bliss.
            The word 'Gau' in the Vedas is the symbol of rays and knowledge; by connecting with God, a human's consciousness also becomes a ray of knowledge spreading light everywhere.
            Being accepted by Mother Aditi means that none of our actions should break the unbroken laws of nature, but rather be completely natural.
            O Supreme Lord! May every step of our lives receive the guidance of God Mitra (God of affection and equality), so we never wander on the wrong path.
            Let us become 'Anagasah' (sinless); because as long as there is sin or selfishness in our hearts, we cannot go into the refuge of God (Aditi).
            May the chariot of our life run on those holy paths (Pathibhih) of truth where no sorrow or hatred remains for any living being whatsoever.
            This mantra teaches us that self-realization (seeing the Sun) and sinless conduct are the real paths that take a human closest to God.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 28,
        sanskrit = "मित्रावरुणौ त्वा पुरस्तात् पातामनागसः ।\nतयोस्त्वा धर्म्मणा सादयामि ॥ २८ ॥",
        hindiCommentary = """
            हे सोम (हवि)! मित्र और वरुण (दिन और रात / प्रेम और न्याय के देव) पूर्व दिशा (आगे) से तुम निष्पाप (अनागसः) की भली-भांति रक्षा करें।
            मैं तुम्हें उन दोनों महान देवताओं (मित्र और वरुण) के सनातन धर्म (नियमों) के अनुसार अत्यंत श्रद्धापूर्वक यहाँ स्थापित (सादयामि) करता हूँ।
            मित्र देव (सूर्य) प्रेम और दिन का प्रतीक हैं, जबकि वरुण देव (जल/रात्री) ब्रह्मांडीय न्याय और अनुशासन के साक्षात् अधिपति हैं।
            इन दोनों का एक साथ आह्वान यह दर्शाता है कि हमारे जीवन में प्रेम और अनुशासन (न्याय) दोनों का ही पूर्ण और सुंदर संतुलन होना चाहिए।
            निष्पाप (अनागस) होने पर ही देवता रक्षा करते हैं; यदि हमारे कर्मों में पाप है, तो वरुण देव का पाश (दंड) हमें अवश्य बांध लेगा।
            पूर्व दिशा से रक्षा का अर्थ है कि हमारे भविष्य (आगे के जीवन) में कोई भी अज्ञान या अंधकार प्रवेश न कर सके; हम हमेशा प्रकाश की ओर बढ़ें।
            हे प्रभु! हमें ऐसी सुबुद्धि दें कि हम मित्र (सबका भला चाहने वाले) बनें और वरुण की तरह अपने कर्तव्यों के प्रति अत्यंत कठोर और न्यायप्रिय रहें।
            हम जो भी अनुष्ठान या कार्य करें, वह किसी व्यक्ति के मनमाने नियमों से नहीं, बल्कि ईश्वरीय धर्म (धर्म्मणा) के अटल सिद्धांतों पर आधारित हो।
            ईश्वर के नियमों (ऋत) पर चलने वाला व्यक्ति कभी भी भयभीत नहीं होता, क्योंकि संपूर्ण ब्रह्मांड की शक्तियां स्वतः उसकी रक्षक बन जाती हैं।
            हमारा हृदय ऐसा निर्मल हो जाए कि धर्म स्वयं हमारे अंतःकरण में स्थापित होकर हमारे हर कर्म को सत्य और परोपकार की दिशा में ही प्रेरित करे।
        """.trimIndent(),
        englishCommentary = """
            O Soma (oblation)! May Mitra and Varuna (Gods of day and night / love and justice) thoroughly protect you, the sinless one (Anagasah), from the east (the front).
            I establish (Sadayami) you here with utmost devotion according to the eternal Dharma (laws) of those two great gods (Mitra and Varuna).
            God Mitra (Sun) is the symbol of love and day, while God Varuna (Water/Night) is the direct sovereign of cosmic justice and strict discipline.
            Invoking both of them together shows that there must be a complete and beautiful balance of both love and discipline (justice) in our lives.
            The gods protect only when one is sinless (Anagasa); if there is sin in our actions, the noose (punishment) of Varuna will surely bind us.
            Protection from the east means no ignorance or darkness can enter our future (the life ahead); we must always advance strictly towards the light.
            O Lord! Give us such wisdom that we become Mitra (wishing well for all) and remain extremely strict and just towards our duties like Varuna.
            Whatever ritual or work we do, let it not be based on arbitrary human rules, but on the unwavering principles of divine Dharma (Dharmmana).
            A person walking on God's laws (Rta) is never afraid, because the forces of the entire universe automatically become their invincible protectors.
            May our heart become so pure that Dharma itself is established in our conscience, inspiring our every action solely in the direction of truth and benevolence.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 29,
        sanskrit = "त्वं सोम क्रतुभिः सुक्रतुर्भूस्त्वं दक्षैः सुदक्षो वनेष्वृषिशूरो नित्यमाहवोऽसि ।\nत्वं वृषा वृषत्वेभिर्महित्वा द्युम्नेभिर्द्युम्न्यसि ॥ २९ ॥",
        hindiCommentary = """
            हे सोम (परमात्मा के आनंद-स्वरूप)! आप अपने महान कर्मों (क्रतुभिः) के कारण अत्यंत श्रेष्ठ कर्म करने वाले (सुक्रतुः) सिद्ध हुए हैं।
            आप अपनी अद्भुत कुशलताओं (दक्षैः) के कारण परम चतुर (सुदक्षः) हैं; आप वनों (संसार) में ऋषियों के समान ज्ञानी और शूरवीरों के समान अत्यंत बलशाली हैं।
            आप सदा (नित्यम्) बुलाए जाने योग्य (आहवः) हैं; हे कामनाओं की वर्षा करने वाले (वृषा)! आप अपनी महानता से सभी कामनाओं को पूर्ण करने वाले हैं।
            आप अपनी अनंत दीप्तियों (द्युम्नेभिः) और तेजस्विता के कारण परम प्रकाशमान (द्युम्नी) हैं।
            यह मंत्र ईश्वर (सोम) की बहुमुखी और सर्वगुणसंपन्न महिमा का अत्यंत सुंदर गान है; ईश्वर ही कर्म, कौशल, ज्ञान और शक्ति का एकमात्र स्रोत है।
            'सुक्रतु' और 'सुदक्ष' होना यह सिखाता है कि साधक को भी ईश्वर के समान अपने कर्मों में श्रेष्ठता और अपनी कला में पूर्ण निपुणता लानी चाहिए।
            ईश्वर 'ऋषिशूर' है—अर्थात् वह ऋषियों की तरह अत्यंत शांत (ज्ञानी) भी है और योद्धाओं की तरह बुराइयों का नाश करने में अत्यंत शूरवीर भी है।
            हे प्रभु! आप हमारे भीतर भी ज्ञान और साहस का ऐसा ही अद्भुत संतुलन स्थापित करें, ताकि हम धर्म के मार्ग पर कभी कमजोर न पड़ें।
            आप हमारी सच्ची पुकार (आहव) को सुनकर हमारे जीवन में ज्ञान और शांति की निरंतर वर्षा (वृषा) करें, जिससे हमारे मन की तपिश शांत हो।
            हम आपके उस परम तेज (द्युम्न) को अपने हृदय में धारण करें, ताकि अज्ञान का अंधकार नष्ट हो और हमारा जीवन एक जाग्रत महायज्ञ बन जाए।
        """.trimIndent(),
        englishCommentary = """
            O Soma (blissful form of God)! Due to Your great actions (Kratubhih), You have proven to be the performer of the most excellent deeds (Sukratuh).
            Due to Your amazing skills (Dakshaih), You are supremely deft (Sudakshah); in the forests (world), You are wise like the sages and highly mighty like the brave warriors.
            You are always (Nityam) worthy of being invoked (Ahavah); O showerer of desires (Vrisha)! By Your greatness, You fulfill all desires perfectly.
            Due to Your infinite brilliance (Dyumnebhih) and radiance, You are supremely luminous (Dyumni).
            This mantra is an extremely beautiful song of God's (Soma's) multifaceted and all-virtuous glory; God alone is the sole source of action, skill, knowledge, and power.
            Being 'Sukratu' and 'Sudaksha' teaches that the seeker too must bring excellence in their actions and absolute mastery in their art, exactly like God.
            God is 'Rishishura'—meaning He is extremely peaceful (wise) like the sages and also extremely brave like warriors in destroying all deep evils.
            O Lord! Establish such an amazing balance of knowledge and courage within us too, so that we never become weak on the path of Dharma.
            Hearing our true call (Ahava), may You continuously shower (Vrisha) knowledge and peace into our lives, calming the intense heat of our minds.
            Let us hold that supreme brilliance (Dyumna) of Yours in our hearts, so that the darkness of ignorance is destroyed and our life becomes an awakened grand sacrifice.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 30,
        sanskrit = "शुक्रस्ते ग्रहः ।\nशुक्रं त्वा शुक्रेण क्रीणामि चन्द्रं चन्द्रेणामृतममृतेन ॥ ३० ॥",
        hindiCommentary = """
            (सोम-क्रय का विशिष्ट मंत्र) हे सोम! तुम्हारा यह पात्र (ग्रह) अत्यंत शुद्ध और प्रकाशमान (शुक्र) है।
            हे विशुद्ध (शुक्र) सोम! मैं तुम्हें शुद्ध (शुक्र) सुवर्ण (स्वर्ण मुद्रा) के द्वारा पूरी श्रद्धा से खरीदता (क्रीणामि) हूँ।
            मैं तुम आह्लाददायक (चन्द्र/चंद्रमा के समान शीतल) सोम को स्वर्ण (चन्द्र) के बदले में लेता हूँ; मैं तुम अमृत (मोक्षदायी) को अमृत (अविनाशी स्वर्ण) के बदले में ग्रहण करता हूँ।
            सोम-क्रय यज्ञ का एक महत्वपूर्ण कर्मकांड है, जहाँ सोम वनस्पति को स्वर्ण देकर खरीदा जाता है; इसका गहरा आध्यात्मिक अर्थ 'समानता का नियम' है।
            'शुक्र' का अर्थ है पूर्णतः पवित्र; ईश्वर या सत्य को केवल पवित्रता (शुद्ध भाव) देकर ही प्राप्त किया जा सकता है, अशुद्ध साधनों से नहीं।
            जब हम ईश्वर (अमृत) को पाना चाहते हैं, तो हमें भी अपने भीतर का अमृत (निस्वार्थ प्रेम और पूर्ण समर्पण) ही मूल्य के रूप में चुकाना पड़ता है।
            सोम 'चन्द्र' (शीतल) है; जब यह जीवन में आता है, तो मन के सारे तनाव और क्रोध शांत हो जाते हैं और असीम आह्लाद (परमानंद) छा जाता है।
            हे परमात्मा! हमारे पास जो भी श्रेष्ठ गुण (स्वर्ण/शुक्र) हैं, हम उन्हें आपके चरणों में अर्पित करते हैं; बदले में आप हमें अपना शाश्वत सान्निध्य (अमृत) दें।
            संसार की झूठी वस्तुओं (कपट) से सच्ची शांति नहीं खरीदी जा सकती; सत्य के बदले ही सत्य मिलता है (शुक्रं त्वा शुक्रेण)।
            हमारा यह लेन-देन (कर्मयोग) ऐसा पवित्र हो कि हमारा पूरा जीवन भौतिकता से उठकर उस परम अमृत (मोक्ष) में पूरी तरह से विलीन हो जाए।
        """.trimIndent(),
        englishCommentary = """
            (Specific mantra for Soma-purchase) O Soma! This vessel (Graha) of yours is extremely pure and luminous (Shukra).
            O supremely pure (Shukra) Soma! I buy (Krinami) you with pure (Shukra) gold (golden coin) with absolute devotion.
            I accept you, the delight-giving (Chandra/cool like the moon) Soma in exchange for gold (Chandra); I accept you, the nectar (Amrita/liberating), in exchange for nectar (imperishable gold).
            Soma-Kraya is an important ritual of the sacrifice where the Soma plant is bought with gold; its deep spiritual meaning is the 'law of equivalence'.
            'Shukra' means completely holy; God or truth can only be attained by giving purity (pure feelings) in return, never ever by impure means.
            When we want to attain God (Amrita), we too have to pay the nectar within us (selfless love and complete surrender) as the ultimate price.
            Soma is 'Chandra' (cool); when it enters life, all tensions and anger of the mind calm down and boundless delight (supreme bliss) prevails.
            O Supreme Lord! Whatever excellent virtues (Gold/Shukra) we have, we offer them at Your feet; in return, please grant us Your eternal proximity (Amrita).
            True peace cannot be bought with the false objects (deceit) of the world; truth is attained only in exchange for absolute truth (Shukram tva shukrena).
            May this transaction (Karma Yoga) of ours be so pure that our entire life rises from materialism and merges completely into that supreme nectar (liberation).
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 31,
        sanskrit = "सग्मे ते गोरस्मे ते चन्द्राणि ।\nतपसस्तनूरसि प्रजापतेर्वर्णः परमेण पशुना क्रीयसे सहस्रपोषं पुषेयम् ॥ ३१ ॥",
        hindiCommentary = """
            (सोम-विक्रेता से संवाद) हे विक्रेता! तुम्हारी यह गौ (जिसे तुमने मूल्य में लिया है) तुम्हारे लिए अत्यंत सुखकारी (सग्मे) हो; और हमारे लिए ये सुवर्ण (चन्द्राणि) कल्याणकारी हों।
            हे सोम! तू महान तप की साक्षात् मूर्ति (तनू) है; तू स्वयं प्रजापति (ईश्वर) का अत्यंत श्रेष्ठ रूप (वर्ण) है।
            तू इस परम श्रेष्ठ पशु (गौ) के द्वारा खरीदा जा रहा है; तेरी कृपा से मैं सहस्रों (हजारों) प्रकार के पोषण (धन, धान्य और ज्ञान) को निरंतर प्राप्त करूँ (पुषेयम्)।
            यज्ञ में वस्तुओं का आदान-प्रदान भी अत्यंत पवित्र भाव से होता है; इसमें दोनों पक्षों (लेने वाले और देने वाले) के कल्याण की कामना की जाती है।
            सोम को 'तपसस्तनू' (तप का शरीर) कहा गया है; क्योंकि आध्यात्मिक आनंद (सोम) बिना कठोर तपस्या और आत्म-अनुशासन के कभी प्राप्त नहीं हो सकता।
            यह परम सुख किसी बाजार में नहीं बिकता, इसे पाने के लिए अपनी सबसे प्रिय वस्तु (गौ/इंद्रियों) का पूर्णतः बलिदान (समर्पण) करना पड़ता है।
            हे प्रभु! हमारा तप इतना दृढ़ हो कि हम आपके उस 'प्रजापति वर्ण' (ईश्वरीय रूप) के साक्षात् दर्शन अपने ही हृदय में कर सकें।
            हम जो भी व्यवहार समाज में करें, वह शोषण पर आधारित न हो, बल्कि वह दोनों पक्षों के लिए 'सग्मे' (सुख और शांति देने वाला) सिद्ध हो।
            हजारों प्रकार का पोषण (सहस्रपोषम्) केवल भौतिक धन नहीं है, बल्कि वह शारीरिक आरोग्य, मानसिक शांति और आत्मिक तृप्ति है जो कभी कम नहीं होती।
            हमारा जीवन इस यज्ञ के माध्यम से इतना समृद्ध हो जाए कि हम केवल अपने लिए नहीं, बल्कि संपूर्ण विश्व के मंगल के लिए कार्य कर सकें।
        """.trimIndent(),
        englishCommentary = """
            (Dialogue with Soma-seller) O Seller! May this cow of yours (taken as price) be extremely joy-giving (Sagme) to you; and may these golden coins (Chandrani) be benevolent to us.
            O Soma! You are the direct embodiment (Tanu) of great penance; you are the highly excellent form (Varna) of Prajapati (God) Himself.
            You are being purchased by this supremely excellent animal (cow); by your grace, may I continuously attain (Pusheyam) thousands of nourishments (wealth, food, and knowledge).
            In a sacrifice, the exchange of items also happens with extremely holy feelings; it wishes for the absolute welfare of both parties (giver and receiver).
            Soma is called 'Tapasastanu' (body of penance); because spiritual bliss (Soma) can never be attained without strict penance and deep self-discipline.
            This supreme joy is not sold in any market; to attain it, one has to completely sacrifice (surrender) their most beloved object (Cow/senses).
            O Lord! May our penance be so firm that we can have the direct vision of that 'Prajapati Varna' (divine form) of Yours right within our own hearts.
            Whatever dealings we do in society, let them not be based on exploitation, but prove to be 'Sagme' (giving joy and peace) for absolutely both parties.
            Thousands of nourishments (Sahasraposham) is not just material wealth, but that physical health, mental peace, and spiritual fulfillment which never diminishes.
            May our life become so prosperous through this sacrifice that we can work not just for ourselves, but for the ultimate welfare of the entire world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 32,
        sanskrit = "मित्रो न एहि सुमित्रधः ।\nइन्द्रस्योरुमा विश दक्षिणमुशन्नुशन्तम् ॥ ३२ ॥",
        hindiCommentary = """
            हे सोम! तुम हम सभी के प्रति उत्तम मित्रता को धारण करने वाले (सुमित्रधः) सच्चे मित्र बनकर हमारे पास आओ (एहि)।
            तुम अत्यंत प्रसन्न और चाहने वाले (उशन्) होकर, देवराज इंद्र (यजमान या साधक की आत्मशक्ति) की दाहिनी जांघ (दक्षिण ऊरु) पर भली-भांति विराजमान हो जाओ।
            इस मंत्र में ईश्वर (सोम) को एक 'मित्र' के रूप में पुकारा गया है; जब ईश्वर मित्र बन जाता है, तो जीवन में कभी कोई भय या निराशा नहीं रहती।
            'सुमित्रधः' का अर्थ है वह जो कभी धोखा नहीं देता और हमेशा अपने मित्र का परम कल्याण ही चाहता है।
            इंद्र की दाहिनी जांघ पर बैठने का प्रतीकात्मक अर्थ यह है कि आध्यात्मिक आनंद (सोम) को हम अपनी सबसे मजबूत और सक्रिय शक्ति (दाहिनी ओर) के साथ धारण करें।
            ईश्वर हमारी ओर तभी 'उशन्' (प्रसन्नतापूर्वक) आता है जब हम भी उसे 'उशन्तम्' (तीव्र इच्छा और प्रेम से) पुकारते हैं; यह प्रेम का दोतरफा मार्ग है।
            हे परमात्मा! हमारे जीवन में एक ऐसे सुमित्र बनकर प्रवेश करें जो हमारे सारे अज्ञान और दुखों को अपने स्नेह से हमेशा के लिए मिटा दे।
            हम अपनी सभी इंद्रियों (इंद्र) और शक्तियों को आपके बैठने का पवित्र आसन बना दें, जहाँ कोई भी मलिन विचार कभी प्रवेश न कर सके।
            जब ईश्वरीय आनंद हमारे जीवन का आधार बन जाता है, तो हमारा हर कर्म स्वतः ही अत्यंत श्रेष्ठ और धर्मनिष्ठ हो जाता है।
            हम पूर्णतः निर्भय होकर संसार में विचरण करें, क्योंकि जब सर्वशक्तिमान ईश्वर हमारा मित्र है, तो संसार की कोई भी बाधा हमें परास्त नहीं कर सकती।
        """.trimIndent(),
        englishCommentary = """
            O Soma! Come to us (Ehi) becoming a true friend who holds excellent friendship (Sumitradhah) towards all of us.
            Being highly pleased and desirous (Ushan), be perfectly seated upon the right thigh (Dakshina Uru) of Lord Indra (the sacrificer's or seeker's soul-power).
            In this mantra, God (Soma) is called upon as a 'Friend'; when God becomes a friend, there is never any fear or despair left in life.
            'Sumitradhah' means the one who never betrays and always desires only the ultimate welfare of his friend.
            Sitting on Indra's right thigh symbolically means that we should hold spiritual bliss (Soma) with our strongest and most active power (the right side).
            God comes towards us 'Ushan' (joyfully) only when we too call Him 'Ushantam' (with intense desire and pure love); this is a two-way street of love.
            O Supreme Lord! Enter our lives becoming such a wonderful friend who erases all our ignorance and sorrows forever with His deep affection.
            Let us make all our senses (Indra) and powers the holy seat for Your seating, where no impure thought can ever enter at all.
            When divine bliss becomes the foundation of our lives, every single action of ours automatically becomes extremely excellent and righteous.
            Let us wander in the world completely fearlessly, because when the Almighty God is our friend, no obstacle of the world can ever defeat us.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 33,
        sanskrit = "स्वान भ्राजाङ्घारे बम्भारे हस्त सुहस्त कृशानो ।\nएते वः सोमक्रयणास्तान् रक्षध्वं मा वो दभन् ॥ ३३ ॥",
        hindiCommentary = """
            हे स्वान, हे भ्राज, हे अंघारे, हे बम्भारे, हे हस्त, हे सुहस्त, हे कृशानो! (ये सोम की रक्षा करने वाले सात देव-गन्धर्वों के नाम हैं)।
            ये सुवर्ण, वस्त्र, गौ आदि पदार्थ तुम सबके लिए 'सोम-क्रयण' (सोम के बदले में दी जाने वाली वस्तुएं/मूल्य) हैं; तुम इन्हें स्वीकार करो।
            तुम सब इस पवित्र सोम की भली-भांति रक्षा करो (रक्षध्वम्); ध्यान रहे कि कोई भी राक्षस या पापी तुम्हें कभी भी धोखा न दे सके (मा वो दभन्)।
            सोम (ईश्वरीय ज्ञान/परमानंद) की रक्षा के लिए इन सात रक्षक शक्तियों (गन्धर्वों) का आह्वान किया गया है; ज्ञान की रक्षा करना अत्यंत कठिन और महत्वपूर्ण है।
            ये सात गन्धर्व वास्तव में हमारी अपनी सात चेतनाएं या इंद्रियां हैं, जिन्हें सतर्क रहना चाहिए ताकि हमारा आध्यात्मिक ज्ञान कभी नष्ट न हो।
            धोखा देने वाले (दभन्) राक्षस हमारे भीतर के काम, क्रोध, मद और लोभ हैं, जो अवसर मिलते ही हमारी सारी तपस्या और शांति को चुरा लेते हैं।
            हे प्रभु! हमारी इंद्रियों को (स्वान, भ्राज आदि के समान) इतना सजग और जाग्रत बना दें कि वे हमारे भीतर के ईश्वरीय आनंद (सोम) की निरंतर रक्षा करें।
            हम जो भी मूल्य (तप, त्याग, सेवा) चुकाकर इस ज्ञान को प्राप्त करें, उसे कभी भी किसी मूर्खता या सांसारिक लालच के कारण खोने न दें।
            ज्ञान प्राप्त करना सरल हो सकता है, परंतु उसे जीवन भर सुरक्षित रखना और आचरण में उतारना (रक्षध्वम्) ही सबसे बड़ी और सच्ची साधना है।
            हमारा अंतःकरण ऐसा अभेद्य दुर्ग बन जाए जहाँ हमारा यह ईश्वरीय प्रेम (सोम) पूर्णतः सुरक्षित रहे और हमें हमेशा परमानंद प्रदान करे।
        """.trimIndent(),
        englishCommentary = """
            O Svana, O Bhraja, O Anghare, O Bambhare, O Hasta, O Suhasta, O Krishano! (These are the names of the seven divine Gandharvas who protect Soma).
            These gold, clothes, cows, etc., are the 'Soma-Krayana' (objects/price given in exchange for Soma) for all of you; accept them.
            All of you thoroughly protect (Rakshadhvam) this holy Soma; beware that no demon or sinner can ever deceive you (Ma vo dabhan).
            To protect Soma (divine knowledge/supreme bliss), these seven protective forces (Gandharvas) are invoked; protecting knowledge is extremely difficult and important.
            These seven Gandharvas are actually our own seven consciousnesses or senses, which must remain alert so our spiritual knowledge is never destroyed.
            The deceiving (Dabhan) demons are the lust, anger, arrogance, and greed within us, which steal all our penance and peace the moment they get a chance.
            O Lord! Make our senses so alert and awakened (like Svana, Bhraja, etc.) that they continuously protect the divine bliss (Soma) residing within us.
            Whatever price (penance, sacrifice, service) we pay to attain this knowledge, let us never lose it due to any foolishness or worldly greed.
            Attaining knowledge might be easy, but keeping it safe lifelong and manifesting it in conduct (Rakshadhvam) is the biggest and truest spiritual practice.
            May our inner conscience become such an impenetrable fortress where this divine love (Soma) of ours remains completely secure and always grants us supreme bliss.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 34,
        sanskrit = "परि माग्ने दुश्चरिताद् बाधस्वा मा सुचरिते भज ।\nउदायुषा स्वायुषोदोषधीनां रसेन ।\nउत्पर्जन्यस्य शुष्मेणोदस्थामामृताँ२ अनु ॥ ३४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप मुझे सभी प्रकार के दुश्चरित्रों (बुरे आचरण और पापों) से दूर हटाकर मेरी रक्षा करें; और मुझे सदा उत्तम चरित्र (सुचरिते) में स्थापित करें।
            मैं श्रेष्ठ और दीर्घ आयु (आयुषा) के साथ, अपने जीवन की पूर्णता (स्वायुषा) के साथ, और औषधियों के उत्तम रस (आरोग्य) के साथ निरंतर ऊपर की ओर उठूँ (उद्)।
            मैं मेघों (पर्जन्य) के महान बल (शुष्मेण) के साथ ऊपर उठूँ; और मैं उन अमर देवताओं (अमृतान्) का अनुसरण करते हुए आत्मिक उन्नति के सर्वोच्च शिखर पर स्थित होऊं (उदस्थाम्)।
            यह यजुर्वेद का एक अत्यंत ही प्रेरक और जीवन-निर्माणकारी (Character-building) मंत्र है; इसमें मनुष्य की सर्वांगीण उन्नति (शारीरिक और चारित्रिक) की प्रार्थना है।
            सबसे पहली प्रार्थना 'दुश्चरित्र से बचने' की है, क्योंकि चरित्रहीन व्यक्ति को यदि आरोग्य या धन मिल भी जाए, तो वह उसका केवल दुरुपयोग ही करता है।
            सुचरित्र ही जीवन का असली 'अमृत' है; जो व्यक्ति सत्य और धर्म के मार्ग पर चलता है, वह इसी जीवन में देवत्व को प्राप्त कर लेता है।
            हे परमात्मा! मेरे भीतर ऐसी प्राणशक्ति (मेघों का बल) भर दें कि मैं अपने जीवन की किसी भी बाधा से कभी निराश न होऊं और हमेशा अजेय रहूँ।
            हम औषधियों (प्रकृति) के रस से शारीरिक रूप से निरोग रहें और उत्तम विचारों से मानसिक रूप से अत्यंत पुष्ट और शांत रहें।
            'ऊपर उठना' (उत्) जीवन का मूल मंत्र है; हमारा हर दिन बीते हुए कल से अधिक पवित्र, अधिक ज्ञानी और अधिक परोपकारी होना चाहिए।
            हम नश्वर संसार के पीछे न भागें, बल्कि उन अमर देवताओं (सत्यनिष्ठों) के पदचिह्नों पर चलें जिन्होंने अपना जीवन मानवता के कल्याण के लिए होम कर दिया।
        """.trimIndent(),
        englishCommentary = """
            O Agni! Push me far away from all forms of bad character (evil conduct and sins) and protect me; and establish me always in excellent character (Sucharite).
            May I rise continuously upwards (Ud) with an excellent and long life (Ayusha), with the absolute fullness of my life (Svayusha), and with the best essence (health) of herbs.
            May I rise up with the great power (Shushmena) of the rain-clouds (Parjanya); and following those immortal gods (Amritan), may I be established at the highest peak of spiritual elevation (Udastham).
            This is a highly inspiring and character-building mantra of the Yajurveda; it is a prayer for a human's all-round elevation (physical and character).
            The very first prayer is 'to escape bad character', because even if a characterless person gets health or wealth, they only absolutely misuse it.
            Good character is the real 'Amrita' (nectar) of life; a person who walks on the path of truth and Dharma attains divinity right in this life itself.
            O Supreme Lord! Fill me with such vital force (power of clouds) that I never despair from any obstacle in life and remain always invincible.
            Let us remain physically disease-free by the essence of herbs (Nature) and remain mentally extremely nourished and peaceful through excellent thoughts.
            'Rising upwards' (Ut) is the core mantra of life; our every day must be purer, wiser, and more benevolent than the yesterday that passed.
            Let us not run after the perishable world, but walk in the exact footsteps of those immortal gods (truth-seekers) who sacrificed their lives for humanity's welfare.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 35,
        sanskrit = "प्र पन्थामगन्महि स्वस्तिगामनेहसम् ।\nयेन विश्वाः परि द्विषो वृणक्ति विन्दते वसु ॥ ३५ ॥",
        hindiCommentary = """
            (प्रयाण/यात्रा का मंत्र) हमने उस परम कल्याणकारी (स्वस्तिगाम्) और सभी पापों से पूर्णतः रहित (अनेहसम्) सन्मार्ग (पन्थाम्) को भली-भांति प्राप्त कर लिया है (अगन्महि)।
            यह वह श्रेष्ठ मार्ग है जिसके द्वारा मनुष्य अपने चारों ओर के सभी शत्रुओं और द्वेषों (द्विषः) का पूर्णतः नाश कर देता है (वृणक्ति)।
            और इसी सत्य के मार्ग पर चलते हुए वह मनुष्य परम ऐश्वर्य और सच्चे धन (वसु) को निश्चित रूप से प्राप्त कर लेता है (विन्दते)।
            यह मंत्र जीवन की उस अवस्था का वर्णन करता है जब साधक को अंततः सत्य, धर्म और ईश्वरीय ज्ञान का सही रास्ता मिल जाता है।
            'स्वस्तिगाम' का अर्थ है वह मार्ग जो हमें सर्वांगीण सुख और परम शांति की ओर ले जाता है; इस मार्ग पर चलने से कभी कोई अमंगल नहीं होता।
            'अनेहसम्' अर्थात् निष्पाप; सत्य का मार्ग वही है जहाँ छल, कपट और स्वार्थ की कोई भी गुंजाइश नहीं होती।
            हे प्रभु! जब हमने आपका यह पावन मार्ग पकड़ लिया है, तो हमें इतनी शक्ति दें कि संसार का कोई भी लोभ हमें इस मार्ग से कभी डिगा न सके।
            सच्चा 'वसु' (धन) आत्मज्ञान है; जो इसे पा लेता है, उसके मन से सारी ईर्ष्या और शत्रुता (द्विषः) स्वतः ही समाप्त हो जाती है।
            हम जीवन की इस यात्रा में कभी अकेले नहीं हैं; जब हम सन्मार्ग पर होते हैं, तो ईश्वरीय शक्तियां हमेशा हमारे आगे-आगे चलकर हमारे विघ्नों को हरती हैं।
            हमारा यह जीवन-पथ इतना प्रशस्त और उज्ज्वल हो कि अन्य भटके हुए लोग भी इस प्रकाश को देखकर शांति और मुक्ति के इस गंतव्य तक पहुँच सकें।
        """.trimIndent(),
        englishCommentary = """
            (Mantra for journey/progress) We have successfully attained (Aganmahi) that supremely benevolent (Svastigam) and completely sinless (Anehasam) right path (Pantham).
            This is that excellent path by which a human completely destroys (Vrinakti) all enemies and malice (Dvishah) surrounding them.
            And strictly walking on this path of truth, that human definitely attains (Vindate) supreme prosperity and true wealth (Vasu).
            This mantra describes that state of life when the seeker finally finds the correct path of truth, Dharma, and divine profound knowledge.
            'Svastigama' means the path that leads us to all-around happiness and supreme peace; walking on this path never brings any inauspiciousness.
            'Anehasam' means sinless; the path of truth is exactly where there is absolutely no room for deceit, fraud, and selfishness.
            O Lord! Now that we have caught this holy path of Yours, give us so much strength that no worldly greed can ever sway us from this route.
            True 'Vasu' (wealth) is self-knowledge; one who attains it, all jealousy and enmity (Dvishah) automatically end from their mind.
            We are never alone in this journey of life; when we are on the right path, divine forces always walk ahead of us and remove our obstacles.
            May this life-path of ours be so wide and bright that other wandering people too, seeing this light, can reach this destination of peace and liberation.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 36,
        sanskrit = "अदित्यास्त्वोपस्थे सादयामि ।\nअग्ने हव्यं रक्षस्व ॥ ३६ ॥",
        hindiCommentary = """
            (मंत्र 17 की पुनरावृत्ति) हे सोम (या हवि)! मैं तुम्हें माता अदिति (अखंड पृथ्वी/प्रकृति की परम शक्ति) की अत्यंत पावन और वात्सल्यमयी गोद (उपस्थ) में स्थापित करता हूँ।
            हे अग्निदेव! आप हमारी इस अर्पित की गई हवि (हव्यम्) की सब प्रकार से रक्षा (रक्षस्व) करें।
            यज्ञ के इस चरण में जब सोम को पुनः स्थापित किया जाता है, तो इस मंत्र को दोहराकर प्रकृति और ईश्वर के प्रति अटूट समर्पण व्यक्त किया जाता है।
            अदिति की गोद का अर्थ है 'पूर्ण सुरक्षा'; जब हम अपने कर्मों को ईश्वर की अखंड व्यवस्था को सौंप देते हैं, तो हम सभी चिंताओं से मुक्त हो जाते हैं।
            हमारा कर्म (हवि) पवित्र होना चाहिए, परंतु उसकी रक्षा के लिए ईश्वरीय प्रकाश (अग्नि) का आशीर्वाद परम आवश्यक है।
            हे परमात्मा! हमारे मन की वेदी पर स्थापित हमारे शुभ संकल्पों की आप स्वयं रक्षा करें ताकि कोई भी सांसारिक कुविचार इन्हें दूषित न कर सके।
            जैसे माता अपने शिशु को हर संकट से बचाती है, वैसे ही यह अखंड प्रकृति हमारे प्राणों और हमारे धर्म की सदैव रक्षा करे।
            हम यह सत्य जान लें कि हमारा स्वतंत्र कोई अस्तित्व नहीं है; हम उसी एक विराट 'अदिति' के छोटे-छोटे अंश हैं जो उसी में पल रहे हैं।
            यह प्रार्थना हमारे भीतर के अहंकार को मिटाकर हमें अत्यंत विनम्र बनाती है और हमें संपूर्ण सृष्टि के साथ प्रेमपूर्वक जुड़ने की प्रेरणा देती है।
            हमारा यह कर्मयोग पूर्णतः निष्काम हो और ईश्वर के श्रीचरणों में एक ऐसी सुरक्षित आहुति बने जो विश्व का निरंतर कल्याण करे।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of Mantra 17) O Soma (or oblation)! I establish you into the supremely holy and affectionate lap (Upastha) of Mother Aditi (the absolute power of unbroken Earth/Nature).
            O Agni! Please completely protect (Rakshasva) this oblation (Havyam) offered by us from all sides.
            At this stage of the sacrifice when Soma is re-established, repeating this mantra expresses an unbreakable surrender towards Nature and God.
            Aditi's lap means 'complete security'; when we hand over our actions to the unbroken order of God, we become free from all worries.
            Our action (oblation) must be pure, but the blessing of divine light (Agni) is absolutely essential for its protection.
            O Supreme Lord! Please personally protect our auspicious resolutions established on the altar of our mind so that no worldly evil thought can pollute them.
            Just as a mother saves her infant from every crisis, may this unbroken nature always protect our vital breaths and our Dharma.
            Let us know this truth that we have no independent existence; we are small parts of that one vast 'Aditi', being nourished exactly within Her.
            This prayer erases the ego within us, makes us extremely humble, and inspires us to connect lovingly with the entire creation.
            May this Karma Yoga of ours be completely selfless and become such a secure oblation at God's holy feet that it continuously benefits the world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 37,
        sanskrit = "नमः मित्रस्य वरुणस्य चक्षसे महो देवाय तदृतँ सपर्यत ।\nदूरंदृशे देवजाताय केतवे दिवस्पुत्राय सूर्याय शंसत ॥ ३७ ॥\n(नोट: यह चतुर्थ अध्याय का अन्तिम मन्त्र है।)",
        hindiCommentary = """
            (सूर्य देव की महान स्तुति) जो मित्र और वरुण (दिन और रात/संपूर्ण जगत) के साक्षात् नेत्र (चक्षसे) हैं, उन महान देव (सूर्य) को मेरा अत्यंत आदरपूर्वक नमन (नमः) है।
            आप सभी उस महान ऋत (ब्रह्मांडीय सत्य और नियम) की भली-भांति पूजा और उपासना (सपर्यत) करें।
            जो अत्यंत दूर तक सब कुछ देखने वाले (दूरंदृशे) हैं, जो देवों से प्रकट हुए (देवजाताय) हैं और जो सारे विश्व को जगाने वाले (केतवे) हैं...
            द्युलोक (आकाश) के उस महान पुत्र (दिवस्पुत्राय) साक्षात् भगवान सूर्य की तुम सब मिलकर अत्यंत श्रेष्ठ स्तुति (शंसत) करो।
            चतुर्थ अध्याय का यह अंतिम मंत्र सूर्य देव (प्रकाश और आत्मज्ञान) की स्तुति के साथ इस यज्ञीय चरण का अत्यंत ओजस्वी समापन करता है।
            सूर्य को मित्र और वरुण का नेत्र कहा गया है, क्योंकि ईश्वरीय प्रकाश ही वह एकमात्र सत्य है जो संसार की हर वस्तु और हमारे हर कर्म को देख रहा है।
            'दूरंदृशे' का अर्थ है जिसकी दृष्टि से कुछ भी नहीं छिपता; ईश्वर सर्वद्रष्टा है, अतः हमें कभी भी एकांत में भी कोई पाप नहीं करना चाहिए।
            हे प्रभु! जिस प्रकार सूर्य अपने प्रकाश से संपूर्ण जगत के अंधकार को नष्ट कर देता है, वैसे ही आप हमारे मन के हर संशय और अज्ञान को सदा के लिए मिटा दें।
            सूर्य 'केतु' (जाग्रत करने वाला) है; आपका यह ईश्वरीय ज्ञान हमारी सोई हुई आत्मा को जगाकर उसे धर्म और परोपकार के मार्ग पर दौड़ा दे।
            हम उस परम ज्योति को नमन करते हुए इस अध्याय को पूर्ण करते हैं, और यह संकल्प लेते हैं कि हमारा जीवन भी सूर्य के समान अत्यंत तेजस्वी, निष्पक्ष और विश्व-कल्याणकारी बनेगा। ॐ शान्तिः।
        """.trimIndent(),
        englishCommentary = """
            (Great praise of the Sun God) My utmost respectful bow (Namah) is to that Great God (Sun), who is the direct eye (Chakshase) of Mitra and Varuna (Day and Night/the whole world).
            May all of you thoroughly worship and serve (Saparyata) that great Rta (cosmic truth and eternal law).
            To Him who sees everything from extremely far away (Durandrishe), who is born from the gods (Devajataya), and who is the awakener of the whole world (Ketave)...
            To that great son of heaven (Divasputraya), the direct Lord Surya, all of you together offer the most excellent praise (Shansata).
            This final mantra of the fourth chapter makes a highly energetic conclusion to this sacrificial phase with the praise of the Sun God (light and self-knowledge).
            The Sun is called the eye of Mitra and Varuna because divine light is the only truth that is watching every object of the world and every action of ours.
            'Durandrishe' means from whose vision nothing hides; God is all-seeing, therefore we must never commit any sin even in complete solitude.
            O Lord! Just as the Sun destroys the darkness of the entire world with His light, similarly, erase every doubt and ignorance of our mind forever.
            The Sun is 'Ketu' (the awakener); may this divine knowledge of Yours wake up our sleeping soul and make it run fast on the path of Dharma and benevolence.
            Bowing to that Supreme Light we complete this chapter, and take a resolve that our life too will become extremely brilliant, impartial, and globally beneficial like the Sun. Om Shanti.
        """.trimIndent()
    )
)