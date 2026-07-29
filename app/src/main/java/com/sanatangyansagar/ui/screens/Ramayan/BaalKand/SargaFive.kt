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
fun SargaFive() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaFiveData
        } else {
            sargaFiveData.filter {
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
                        Text("पंचम सर्ग - अयोध्या वैभव", fontWeight = FontWeight.ExtraBold)
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

val sargaFiveData = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "कोसलो नाम मुदितः स्फीतो जनपदो महान् ।\nनिविष्टः सरयूतीरे प्रभूतधनधान्यवान् ॥ १ ॥",
        hindiCommentary = """
            सरयू नदी के पवित्र तट पर 'कोसल' नाम का एक अत्यंत विशाल और महान जनपद स्थित था।
            यह देश 'मुदित' अर्थात सदैव प्रसन्न रहने वाले लोगों से भरा हुआ और 'स्फीतो' यानी अत्यंत समृद्ध था।
            कोसल की भूमि में धन-धान्य की कोई कमी नहीं थी, जिससे वहाँ की प्रजा पूर्णतः संतुष्ट थी।
            यह जनपद प्राकृतिक सुंदरता और आध्यात्मिक शांति का एक अद्भुत संगम माना जाता था।
            नदी के किनारे स्थित होने के कारण यहाँ की जलवायु स्वास्थ्यप्रद और भूमि अत्यंत उपजाऊ थी।
            मुनि वाल्मीकि यहाँ उस स्वर्णिम काल का वर्णन कर रहे हैं जब राष्ट्र की उन्नति अपने चरम पर थी।
            प्रभूत धन-धान्य का होना इस बात का प्रमाण है कि वहाँ का शासन आर्थिक रूप से अत्यंत सुदृढ़ था।
            कोसल देश की सीमाएँ और उसका वैभव उस समय के पूरे आर्यावर्त में विख्यात और सम्मानित था।
            यहाँ के निवासी धर्मनिष्ठ थे और उनके जीवन में संतोष का भाव ही उनकी मुख्य पूंजी थी।
            नारद जी के संक्षेप वर्णन के बाद, अब वाल्मीकि जी विस्तार से उस स्थान का वर्णन कर रहे हैं।
            यह श्लोक राम-कथा के भौगोलिक और सामाजिक परिदृश्य की पहली ठोस आधारशिला रखता है।
        """.trimIndent(),
        englishCommentary = """
            On the banks of the sacred Sarayu river, there existed a vast and magnificent country named Kosala.
            This province was 'Muditah' (ever-joyful) and 'Sphitah' (prosperous), flourishing in every aspect.
            It was abundantly endowed with wealth and food grains (Prabhuta-dhana-dhanyavan), ensuring no lack.
            The location by the river Sarayu provided both strategic defensive depth and agricultural fertility.
            Kosala was a land where material abundance met spiritual tranquility in perfect harmony.
            Sage Valmiki describes a Golden Age where the subjects were physically healthy and mentally at peace.
            The immense wealth of the land indicates a robust economic system and a benevolent governance.
            The fame of Kosala's prosperity resonated throughout the ancient world as a standard of excellence.
            The inhabitants were anchored in Dharma, making the nation ethically strong as well as wealthy.
            Following the summary by Narada, Valmiki now builds the physical world of the narrative.
            This verse serves as the geographical foundation for the epic, introducing the cradle of Rama's birth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 2,
        sanskrit = "अयोध्या नाम नगरी तत्रासील्लोकविश्रुता ।\nमनुना मानवेन्द्रेण या पुरी निर्मिता स्वयम् ॥ २ ॥",
        hindiCommentary = """
            कोसल देश के भीतर 'अयोध्या' नाम की एक नगरी थी, जो समस्त लोकों में अपनी कीर्ति के लिए प्रसिद्ध थी।
            इस दिव्य नगरी का निर्माण स्वयं मानवों के प्रथम राजा और विधाता के पुत्र 'मनु' ने किया था।
            'अयोध्या' का अर्थ है—वह स्थान जिसे युद्ध द्वारा कभी जीता न जा सके, जो इसकी अभेद्यता को दर्शाता है।
            राजा मनु द्वारा निर्मित होने के कारण इस नगरी का नियोजन अत्यंत वैज्ञानिक और आध्यात्मिक था।
            यह नगरी रघुकुल की राजधानी बनी और आने वाले हजारों वर्षों तक धर्म का केंद्र रही।
            लोकविश्रुता शब्द यह बताता है कि इसका यश केवल पृथ्वी पर ही नहीं, बल्कि देवलोक तक फैला था।
            अयोध्या केवल पत्थरों का शहर नहीं था, बल्कि वह मानवीय सभ्यता के सर्वोच्च आदर्शों का प्रतीक था।
            मनु ने इसे एक ऐसी संरचना दी थी जहाँ प्रकृति और वास्तुकला एक-दूसरे के पूरक के रूप में दिखते थे।
            यहाँ की गलियों और महलों में एक ऐसी पवित्रता व्याप्त थी जो साक्षात् वैकुण्ठ की याद दिलाती थी।
            यह नगरी आने वाले समय में मर्यादा पुरुषोत्तम भगवान राम की लीलाओं का मुख्य रंगमंच बनने वाली थी।
            वाल्मीकि जी ने इस नगरी के ऐतिहासिक और दैवीय उद्गम का यहाँ बहुत स्पष्ट रूप से उल्लेख किया है।
        """.trimIndent(),
        englishCommentary = """
            Within Kosala, there was a world-renowned city famously known by the name 'Ayodhya.'
            This divine city was personally designed and founded by Manu, the foremost king of mankind.
            The name 'Ayodhya' translates to 'Unconquerable,' signifying its absolute defensive integrity.
            Being constructed by Manu, the city's planning was both scientifically advanced and spiritually resonant.
            It served as the capital for the Solar Dynasty, remaining the epicenter of Dharma for ages.
            The epithet 'Lokavishruta' implies that its fame transcended the earth and reached the celestial planes.
            Ayodhya was not merely a collection of structures but a living embodiment of civilized ideals.
            Manu crafted it as a space where nature and architecture existed in a state of perfect synergy.
            The purity lingering in its streets and palaces was reminiscent of the supreme abode of Vishnu.
            This city was destined to be the grand theater for the transcendental pastimes of Lord Rama.
            Valmiki emphasizes the city's primordial and divine origin to establish its unmatched sanctity.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 3,
        sanskrit = "आयता दश च द्वे च योजनानि महापुरी ।\nश्रीमती त्रीणि विस्तीर्णा सुविभक्तमहापथा ॥ ३ ॥",
        hindiCommentary = """
            यह महान नगरी लम्बाई में बारह योजन (लगभग 96 मील) तक फैली हुई थी और इसकी भव्यता अद्भुत थी।
            चौड़ाई में यह तीन योजन (लगभग 24 मील) थी और इसके राजमार्ग अत्यंत सुव्यवस्थित और विशाल थे।
            'सुविभक्तमहापथा' का अर्थ है कि नगर का नियोजन इतना सटीक था कि मार्ग एक-दूसरे को तार्किक रूप से काटते थे।
            नगर का विस्तार इसकी जनसंख्या और इसके गौरवशाली स्थान को देखते हुए अत्यंत प्रभावशाली था।
            'श्रीमती' विशेषण अयोध्या के उस राजसी ऐश्वर्य को दर्शाता है जो आँखों को चकाचौंध कर देने वाला था।
            विशाल राजमार्गों का होना प्राचीन काल की उन्नत शहरी इंजीनियरिंग और यातायात प्रबंधन का प्रमाण है।
            नगर की लम्बाई और चौड़ाई का यह अनुपात उसे एक भव्य आयताकार स्वरूप प्रदान करता था।
            ये मार्ग केवल चलने के लिए नहीं थे, बल्कि वे नगर की आर्थिक और सामरिक शक्ति के संचार का माध्यम थे।
            वाल्मीकि जी ने यहाँ नगर के भौतिक आयामों का सूक्ष्म वर्णन कर इसकी विशालता को प्रमाणित किया है।
            इतनी बड़ी नगरी का एक-एक कोना साफ-सुथरा और कलात्मक सौंदर्य से पूरी तरह परिपूर्ण था।
            अयोध्या की यह संरचना आज के आधुनिक स्मार्ट शहरों के लिए भी एक प्रेरणादायक उदाहरण हो सकती है।
        """.trimIndent(),
        englishCommentary = """
            This great city spanned a length of twelve yojanas (approx. 96 miles) and was magnificent in appearance.
            It possessed a breadth of three yojanas (approx. 24 miles) and featured perfectly organized highways.
            'Suvibhaktamahapatha' indicates that the city planning was precise, with well-demarcated major roads.
            The vast scale of the city reflected the grandeur of the empire and the high density of its noble citizens.
            The attribute 'Shrimati' portrays the royal opulence and breathtaking aesthetic beauty of Ayodhya.
            The existence of such wide highways proves the advanced urban engineering and traffic sense of that era.
            The ratio of its length to width provided the city with a majestic and stable rectangular architectural form.
            These roads were the lifelines of commerce and the conduits for the empire’s formidable military power.
            Valmiki provides specific measurements to emphasize that Ayodhya was a true metropolis of the ancient world.
            Despite its massive size, every corner of the city was pristine and filled with artistic splendor.
            Ayodhya’s layout stands as an ancient precursor to modern concepts of well-planned urban environments.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 4,
        sanskrit = "राजमार्गेण महता सुविभक्तेन शोभिता ।\nमुक्तपुष्पविकीर्णेन जलसेकेन नित्यशः ॥ ४ ॥",
        hindiCommentary = """
            वह नगरी एक बहुत ही विशाल और सुव्यवस्थित मुख्य राजमार्ग से सुशोभित थी जो नगर के मध्य से गुजरता था।
            उस मार्ग पर प्रतिदिन ताजे और सुगंधित फूल बिखेरे जाते थे और नियमित रूप से जल का छिड़काव होता था।
            जलसेक का उद्देश्य धूल को शांत करना और वातावरण में एक विशेष शीतलता और ताजगी बनाए रखना था।
            फूलों का बिखरा होना यह दर्शाता है कि अयोध्या के निवासियों के लिए सुंदरता और पवित्रता जीवन का अभिन्न अंग थी।
            राजमार्ग की चौड़ाई ऐसी थी कि वहाँ कई रथ और हाथी एक साथ बिना किसी बाधा के आ-जा सकते थे।
            नियमित सफाई और रखरखाव यह सिद्ध करता है कि नगर प्रशासन अत्यंत सक्रिय और प्रजा-प्रेमी था।
            राहगीरों को मार्ग में चलते हुए किसी सुगंधित उपवन में टहलने जैसा सुखद और दिव्य अनुभव प्राप्त होता था।
            यह मार्ग केवल ईंटों से नहीं बना था, बल्कि यह अयोध्या के अनुशासन और उसके वैभव का साक्षात् प्रतीक था।
            वाल्मीकि जी ने यहाँ नगर की स्वच्छता और उसकी सौंदर्य-चेतना का बहुत ही सूक्ष्म वर्णन किया है।
            ऐसी सुव्यवस्थित गलियाँ ही एक सभ्य और अत्यंत समृद्ध राष्ट्र की सबसे बड़ी पहचान मानी जाती हैं।
            अयोध्या की चमक इन मार्गों के माध्यम से ही उसके महलों और मंदिरों के गौरव को और बढ़ाती थी।
        """.trimIndent(),
        englishCommentary = """
            The city was adorned with a grand and well-partitioned central highway that ran through its heart.
            Fresh flowers were scattered across this path daily, and it was regularly sprinkled with cooling water.
            The practice of 'Jalaseka' (sprinkling water) was intended to settle dust and maintain ambient freshness.
            The scattering of blossoms highlights that for Ayodhya's people, aesthetics were inseparable from daily life.
            The width of the highway allowed multiple chariots and elephants to pass simultaneously without congestion.
            Constant maintenance and upkeep proved that the municipal administration was efficient and citizen-focused.
            Walking on these roads felt like traversing a perpetually blooming and fragrant celestial garden.
            This road was not just a passage; it was a symbol of Ayodhya's discipline and monumental prosperity.
            Valmiki captures the high standards of hygiene and the refined aesthetic sensibility of the capital.
            Such well-organized streets are the hallmark of a civilized nation at the peak of its material growth.
            The brilliance of Ayodhya radiated through these very paths, leading to its majestic temples and palaces.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 5,
        sanskrit = "तां तु राजा दशरथो महाराष्ट्रविवर्धनः ।\nअतिष्ठत पुरीं राजा महेन्द्र इव शशासि ॥ ५ ॥",
        hindiCommentary = """
            अपने महान राष्ट्र की उन्नति करने वाले राजा दशरथ ने उस दिव्य नगरी में अपना स्थायी निवास बनाया।
            वे उस पूरी नगरी और राष्ट्र का शासन ठीक उसी प्रकार करते थे जैसे देवराज इन्द्र स्वर्ग का शासन करते हैं।
            'महाराष्ट्रविवर्धनः' शब्द दशरथ की उस क्षमता को दर्शाता है जिसने कोसल को एक महाशक्ति बना दिया था।
            दशरथ का शासन न्याय, शक्ति और प्रजा के प्रति अगाध करुणा के सिद्धांतों पर पूरी तरह आधारित था।
            अयोध्या की सुरक्षा और उसका ऐश्वर्य राजा के तेजस्वी व्यक्तित्व का ही एक बाहरी विस्तार मात्र था।
            जैसे इन्द्र देवताओं की रक्षा करते हैं, वैसे ही दशरथ अपनी प्रजा के लिए एक अभेद्य सुरक्षा कवच थे।
            उनके दरबार में धर्म और नीति की निरंतर चर्चाएँ होती थीं, जिससे पूरे राष्ट्र का चारित्रिक उत्थान होता था।
            वे केवल एक प्रशासक नहीं थे, बल्कि प्रजा के लिए पिता समान संरक्षक और आध्यात्मिक मार्गदर्शक भी थे।
            दशरथ के प्रताप से शत्रु राजा उनसे युद्ध करने का विचार भी मन में लाने से हमेशा घबराते थे।
            वाल्मीकि जी ने उनकी तुलना 'महेन्द्र' से की है, जो उनकी अजेय शक्ति और उनके राजसी वैभव का सूचक है।
            अयोध्या की गलियों में राजा के प्रति प्रेम और सम्मान की लहरें निरंतर हिलोरे लेती रहती थीं।
        """.trimIndent(),
        englishCommentary = """
            King Dasharatha, who continuously enhanced the prosperity of his great nation, resided in that divine city.
            He governed the entire city and the kingdom just as Indra, the king of gods, rules over the heavens.
            The term 'Maharashtravivardhanah' highlights his role in expanding the glory and influence of Kosala.
            Dasharatha’s reign was anchored in absolute justice, military might, and paternal compassion for his people.
            The security and opulence of Ayodhya were but a macrocosm of the King’s own radiant and stable character.
            Just as Indra protects the pantheon of gods, Dasharatha acted as an impenetrable shield for his subjects.
            His court was a center for moral and political discourse, fostering the ethical growth of the entire realm.
            He was not merely a ruler but a father-like guardian and a spiritual beacon for his beloved citizens.
            Due to Dasharatha’s immense aura, rival kings trembled at the mere thought of confronting him in battle.
            Valmiki compares him to 'Mahendra,' signifying his invincible strength and his unparalleled royal majesty.
            The streets of Ayodhya resonated with the deep-seated love and reverence the people held for their King.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 6,
        sanskrit = "कपाटतोरणवतीं सुविभक्तान्तरापणाम् ।\nसर्वयन्त्रायुधवतीं उपेतां सर्वशिल्पिभिः ॥ ६ ॥",
        hindiCommentary = """
            वह नगरी विशाल फाटकों (कपाट) और सुंदर वंदनवारों (तोरण) से युक्त थी और वहाँ के बाजार अत्यंत व्यवस्थित थे।
            अयोध्या में हर प्रकार के रक्षात्मक यंत्र, अस्त्र-शस्त्र और विश्व के श्रेष्ठ शिल्पी (कलाकार) निवास करते थे।
            'सुविभक्तान्तरापणाम्' का अर्थ है कि व्यापारिक क्षेत्रों का विभाजन बहुत ही तार्किक और व्यवस्थित ढंग से किया गया था।
            नगर की सुरक्षा के लिए दरवाजों पर भारी कपाट लगाए गए थे जो किसी भी शत्रु के लिए अभेद्य थे।
            तोरणों की सजावट यह बताती है कि नगर में हर दिन उत्सव जैसा माहौल रहता था और लोग कलाप्रेमी थे।
            सर्वयन्त्रायुधवती शब्द यह सिद्ध करता है कि अयोध्या सामरिक दृष्टि से अत्यंत आधुनिक और शक्तिशाली नगरी थी।
            वहाँ रहने वाले शिल्पी (Architects/Artists) पत्थर, लकड़ी और धातुओं पर अद्भुत नक्काशी करने में निपुण थे।
            हर बाजार में वस्तुओं की प्रचुरता थी और व्यापारियों के लिए सभी आवश्यक सुविधाएँ उपलब्ध थीं।
            नगरी का यह वर्णन उसकी आत्मनिर्भरता और उसकी सर्वांगीण प्रगति को बहुत ही प्रभावशाली ढंग से दर्शाता है।
            वाल्मीकि जी ने यहाँ अयोध्या के 'इंफ्रास्ट्रक्चर' और उसकी सुरक्षा व्यवस्था का बहुत तकनीकी वर्णन किया है।
            यह नगरी न केवल सुंदर थी, बल्कि वह विज्ञान और कला के अद्भुत समन्वय का एक सजीव उदाहरण थी।
        """.trimIndent(),
        englishCommentary = """
            The city featured massive gates (Kapata), beautiful arches (Torana), and logically organized marketplaces.
            It was equipped with diverse mechanical instruments, weaponry, and was populated by the world's best artisans.
            'Suvibhaktantarapanam' implies that the commercial zones were meticulously planned for ease of trade.
            The heavy doors on the fortifications ensured that the city remained invincible to any external aggression.
            The presence of decorative arches suggests a culture that celebrated beauty and maintained a festive spirit.
            The mention of 'Sarvayantrayudhavatim' proves that Ayodhya was a militarily advanced and formidable capital.
            Artisans and architects (Shilpis) skilled in stone, wood, and metal crafts resided there in great numbers.
            Marketplaces were brimming with goods, reflecting a thriving economy and a satisfied merchant class.
            This description highlights the city's self-reliance and its comprehensive progress in all spheres of life.
            Valmiki provides a technical account of Ayodhya’s infrastructure and its sophisticated defense mechanisms.
            The city was not just aesthetically pleasing but was a living marvel of the union of science and art.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 7,
        sanskrit = "सूतमागधसंबाधां श्रीमतीमतुलप्रभाम् ।\nउच्चाट्टालध्वजवतीं शतघ्नीशतसंकुलाम् ॥ ७ ॥",
        hindiCommentary = """
            वह नगरी सूतों (वंश-गायकों) और मागधों (स्तुति-पाठकों) से भरी हुई थी और उसकी शोभा अतुलनीय (अतुलप्रभाम्) थी।
            वहाँ ऊँचे-ऊँचे अट्टालिकाएं (महल) थे जिन पर रंग-बिरंगी ध्वजाएँ फहरा रही थीं और सैकड़ों शतघ्नियां तैनात थीं।
            शतघ्नियां उस समय के वे भारी अस्त्र थे जो एक साथ सैकड़ों शत्रुओं का विनाश करने में सक्षम माने जाते थे।
            'सूतमागध' की उपस्थिति यह दर्शाती है कि अयोध्या में इतिहास और संस्कृति का बहुत सम्मान किया जाता था।
            अतुलप्रभा का अर्थ है—ऐसी चमक जिसकी तुलना संसार की किसी भी दूसरी वस्तु या नगरी से नहीं की जा सकती।
            ऊँची अट्टालिकाओं पर फहराते ध्वज राष्ट्र के गौरव और उसकी संप्रभुता का प्रतीक बनकर आकाश से बातें करते थे।
            नगर की सुरक्षा व्यवस्था इतनी कड़ी थी कि वहाँ परिंदा भी बिना अनुमति के पर नहीं मार सकता था।
            महलों की ऊँचाई यह संकेत देती थी कि अयोध्या के निवासी आर्थिक और आध्यात्मिक दोनों रूपों में ऊँचे थे।
            वाल्मीकि जी ने यहाँ नगर की भव्यता और उसकी सैन्य शक्ति के बीच के संतुलन को बहुत बखूबी दिखाया है।
            ध्वजाओं का फहराना यह भी बताता है कि अयोध्या का यश पूरे ब्रह्मांड में अपनी विजय का उद्घोष कर रहा था।
            यह श्लोक अयोध्या के उस 'रॉयल' और 'वारियर' स्वरूप का एक बहुत ही ओजपूर्ण चित्रण प्रस्तुत करता है।
        """.trimIndent(),
        englishCommentary = """
            The city was bustling with bards (Sutas) and panegyrists (Magadhas), possessing an incomparable radiance.
            It featured high-rise palaces adorned with fluttering flags and was guarded by hundreds of 'Shataghnis.'
            Shataghnis were heavy defensive weapons believed to be capable of slaying hundreds of foes simultaneously.
            The presence of Sutas and Magadhas indicates a culture that held history and oral traditions in high esteem.
            'Atulaprabham' signifies a brilliance so unique that it could not be compared to any other city on earth.
            The flags atop the tall mansions symbolized the pride and sovereign authority of the nation.
            The security grid of the city was so dense that it rendered the capital virtually impenetrable to enemies.
            The height of the buildings was a metaphor for the elevated status—both material and spiritual—of its citizens.
            Valmiki expertly balances the description of the city's aesthetic beauty with its formidable military might.
            The waving flags announced to the world that Ayodhya’s glory was unassailable and eternally victorious.
            This verse provides a powerful depiction of the 'Royal' and 'Warrior' character of the capital city.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 8,
        sanskrit = "वधूमद्भीश्च गणिका संघैश्चैव समाकुलाम् ।\nसर्वलक्षणसम्पन्नां अमरावतीमिव स्थिताम् ॥ ८ ॥",
        hindiCommentary = """
            वह नगरी कुलवधुओं और श्रेष्ठ कलाओं में निपुण गणिकाओं (नर्तकियों) के समूहों से पूरी तरह परिपूर्ण थी।
            अयोध्या समस्त शुभ लक्षणों से संपन्न थी और वह पृथ्वी पर साक्षात् देवराज इन्द्र की 'अमरावती' के समान थी।
            'वधूमद्भीश्च' शब्द समाज की पारिवारिक मर्यादा और स्त्रियों के सम्मानजनक स्थान की ओर संकेत करता है।
            गणिकाओं की उपस्थिति यह सिद्ध करती है कि अयोध्या में संगीत, नृत्य और ललित कलाओं को राजकीय संरक्षण प्राप्त था।
            नगर के सभी लक्षण शास्त्रसम्मत थे, जिससे वहाँ निरंतर सुख, शांति और समृद्धि का वास बना रहता था।
            अमरावती से तुलना यह बताती है कि अयोध्या के सुख और वैभव की कोई मानवीय सीमा नहीं थी।
            समाज में कला और नैतिकता का ऐसा अद्भुत संतुलन था कि कोई भी एक-दूसरे की मर्यादा का उल्लंघन नहीं करता था।
            स्त्रियाँ सुरक्षित थीं और वे नगर की शोभा को अपने शील और सौंदर्य से और अधिक बढ़ाती थीं।
            वाल्मीकि जी ने यहाँ अयोध्या के 'सामाजिक ताने-बाने' और उसकी विलासिता व पवित्रता के मेल को दिखाया है।
            पूरी नगरी में फूलों की सुगंध और संगीत की ध्वनि गूँजती रहती थी, जो दिव्य लोक का अनुभव कराती थी।
            यह श्लोक अयोध्या को पृथ्वी का स्वर्ग और मानवीय सभ्यता का सर्वोच्च शिखर घोषित करता है।
        """.trimIndent(),
        englishCommentary = """
            The city was populated by virtuous daughters-in-law and groups of accomplished dancers and artists.
            Endowed with all auspicious characteristics, it stood on earth like Indra’s celestial city, 'Amaravati.'
            The mention of 'Vadhumadbhih' signifies the high status of women and the sanctity of family units in society.
            The presence of artists (Ganikas) proves that music, dance, and fine arts received immense royal patronage.
            Every characteristic of the city aligned with scriptural ideals, ensuring eternal peace and prosperity.
            The comparison to Amaravati suggests that the joy and opulence of Ayodhya knew no earthly bounds.
            There was such an extraordinary balance between art and morality that social boundaries were never breached.
            Women felt secure, enhancing the city's prestige through their modesty and refined aesthetic grace.
            Valmiki illustrates the 'Social Fabric' of Ayodhya, blending material luxury with spiritual sanctity.
            The city unceasingly resonated with the fragrance of blossoms and the melodies of refined music.
            This verse declares Ayodhya as the heaven on earth and the zenith of human civilizational achievement.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 9,
        sanskrit = "विचित्रवैमानिकवतीं वैदेहीमिव भाविनीम् ।\nदिव्याम्बरधराभिश्च नारीभिः समुपेताम् ॥ ९ ॥",
        hindiCommentary = """
            नगरी में अनेक प्रकार के विचित्र और सुंदर भवन (विमान) थे और वह सीता (वैदेही) के समान ही तेजस्वी थी।
            वहाँ की स्त्रियाँ दिव्य वस्त्र (दिव्याम्बर) धारण करती थीं और उनकी आभा नगर की शोभा में चार चाँद लगाती थी।
            'विचित्रवैमानिक' शब्द महलों की उस वास्तुकला को दर्शाता है जो आकाश को छूने वाली और मनमोहक थी।
            यहाँ नगर की तुलना सीता जी से करना यह संकेत देता है कि अयोध्या साक्षात् शक्ति और पवित्रता का रूप थी।
            स्त्रियों का दिव्य वस्त्र पहनना वहाँ की आर्थिक संपन्नता और उच्च जीवन शैली का सीधा प्रमाण है।
            अयोध्या का हर घर किसी छोटे मंदिर या महल के समान सुंदर और सात्विक ऊर्जा से ओत-प्रोत था।
            लोगों के पहनावे में शुचिता और सौंदर्य का संगम था, जो उनके आंतरिक संस्कारों को भी प्रकट करता था।
            वाल्मीकि जी ने देखा कि नगर की नारियाँ शिक्षित, संस्कारी और आध्यात्मिक रूप से जाग्रत थीं।
            नगर की आभा केवल पत्थरों से नहीं, बल्कि वहाँ रहने वाले दिव्य चरित्र वाले मनुष्यों से बनी थी।
            यह श्लोक अयोध्या के 'एस्थेटिक' (सौंदर्यशास्त्रीय) पक्ष और नारी-गौरव का अत्यंत महिमामयी गान करता है।
            पूरा वातावरण रेशम और स्वर्ण के वस्त्रों की चमक से हमेशा देदीप्यमान और मांगलिक बना रहता था।
        """.trimIndent(),
        englishCommentary = """
            The city possessed diverse and marvelous mansions (Vimanas) and was as radiant as the glorious Sita.
            It was populated by women wearing divine garments, whose presence enhanced the capital’s splendor.
            'Vichitravaimanika' refers to the architectural brilliance of palaces that seemed to touch the very heavens.
            Comparing the city to Sita (Vaidehi) suggests that Ayodhya was the personification of power and purity.
            Women donning divine attire is direct evidence of the immense economic prosperity and high lifestyle standards.
            Every home in Ayodhya appeared like a small shrine or a mini-palace, filled with positive spiritual energy.
            The clothing of the citizens reflected a union of cleanliness and beauty, mirroring their internal character.
            Valmiki notes that the women of the city were educated, cultured, and spiritually awakened individuals.
            The city's radiance was derived not just from its stones but from the divine character of its inhabitants.
            This verse glorifies the 'Aesthetic' dimension of Ayodhya and the high dignity accorded to its women.
            The entire atmosphere remained perpetually luminous and auspicious due to the glitter of silk and gold.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 10,
        sanskrit = "हस्त्यश्वरथसंबाधां गजवाजिसमैः स्थिताम् ।\nसमस्तराजराजन्यैः सान्द्राम् आकुलितां सदा ॥ १० ॥",
        hindiCommentary = """
            वह नगरी हाथियों, घोड़ों और रथों से हमेशा भरी रहती थी और वहाँ श्रेष्ठ पशुओं की कोई कमी नहीं थी।
            विश्व के अनेक राजा और उनके राजकुमार निरंतर अयोध्या में आकर निवास करते थे, जिससे वहाँ सदैव चहल-पहल रहती थी।
            'हस्त्यश्वरथ' की प्रचुरता यह दर्शाती है कि अयोध्या सामरिक और व्यापारिक दृष्टि से कितनी सशक्त थी।
            गज (हाथी) और वाजि (घोड़े) उस समय की सबसे बड़ी संपत्ति और शक्ति के प्रतीक माने जाते थे।
            दूसरे राजाओं का वहाँ होना यह सिद्ध करता है कि अयोध्या पूरे विश्व का राजनीतिक और कूटनीतिक केंद्र थी।
            सान्द्राम् शब्द का अर्थ है कि नगर में जनसंख्या का घनत्व अधिक था, फिर भी वहाँ व्यवस्था और शांति थी।
            राम-राज्य की यह विशेषता थी कि वहाँ वैभव होने के बावजूद कभी भी अनुशासनहीनता या अफरा-तफरी नहीं हुई।
            राजकुमारों का अयोध्या आना वहाँ की शिक्षा और संस्कृति से प्रभावित होने की उनकी इच्छा को दर्शाता था।
            पशुओं की देखभाल के लिए भी नगर में विशेष स्थान और व्यवस्थाएं थीं, जो मुनि ने अपनी दृष्टि से देखीं।
            यह श्लोक अयोध्या के 'कॉस्मोपॉलिटन' (वैश्विक) स्वरूप और उसकी सैन्य संपन्नता का वर्णन करता है।
            नगर की सड़कों पर हाथियों की चिंघाड़ और रथों की गूँज एक अजेय राष्ट्र के आत्मविश्वास का परिचय देती थी।
        """.trimIndent(),
        englishCommentary = """
            The city was bustling with elephants, horses, and chariots, and was well-stocked with superior livestock.
            Numerous kings and princes from across the world resided there, keeping the city perpetually vibrant.
            The abundance of 'Hastyashvaratha' (elephants, horses, chariots) signifies Ayodhya's immense strategic power.
            Elephants and horses were the prime indicators of wealth and military strength in the ancient Vedic era.
            The presence of foreign royalty proves that Ayodhya was the global epicenter of politics and diplomacy.
            The term 'Sandram' implies a high density of noble population, yet maintained with perfect social order.
            A hallmark of Rama’s reign was that immense opulence never led to indiscipline or chaotic unrest.
            Princes flocked to Ayodhya to be influenced by its superior education, culture, and ethical standards.
            There were specialized zones and infrastructures for the care of livestock, as seen by the sage’s vision.
            This verse describes the 'Cosmopolitan' nature of Ayodhya and its unparalleled military readiness.
            The trumpeting of elephants and the rumble of chariots on the streets signaled the confidence of an invincible nation.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 11,
        sanskrit = "नानादेशनिवासैश्च वणिग्भिरुपशोभिताम् ।\nप्रासादै रत्नविकृतैः पर्वतैरिव शोभिताम् ॥ ११ ॥",
        hindiCommentary = """
            वह नगरी अनेक देशों से आए हुए व्यापारियों (वणिग्भिः) के निवास के कारण अत्यंत सुशोभित हो रही थी।
            रत्नों से जड़े हुए विशाल और भव्य महल (प्रासाद) ऐसे लगते थे मानो वे ऊँचे पर्वत हों।
            'नानादेशनिवासैश्च' यह प्रमाणित करता है कि अयोध्या का व्यापार वैश्विक स्तर का था और विदेशी व्यापारी यहाँ सुरक्षित महसूस करते थे।
            व्यापारियों का आना किसी भी राज्य की मजबूत अर्थव्यवस्था और उदार नीतियों का सीधा परिणाम होता है।
            रत्नों से सजे हुए महल (रत्नविकृतैः) केवल ईंट-पत्थर के ढांचे नहीं थे, बल्कि वे कोसल देश के अतुलनीय ऐश्वर्य के साक्षात् प्रमाण थे।
            इन महलों की ऊँचाई और भव्यता को देखकर ऐसा प्रतीत होता था कि जैसे नगर के भीतर ही सोने और हीरों के पर्वत खड़े हों।
            वाल्मीकि जी ने यहाँ 'ग्लोबलाइजेशन' (वैश्वीकरण) और मुक्त व्यापार (Free Trade) का एक प्राचीन चित्र प्रस्तुत किया है।
            व्यापारी केवल धन नहीं लाते थे, बल्कि वे विभिन्न संस्कृतियों और कलाओं का आदान-प्रदान भी करते थे।
            राजा दशरथ के शासन में कर (Tax) प्रणाली इतनी न्यायपूर्ण थी कि व्यापारी स्वेच्छा से यहाँ आकर बसना चाहते थे।
            यह श्लोक अयोध्या को केवल एक धार्मिक नगरी नहीं, बल्कि एक उन्नत 'कमर्शियल हब' (Commercial Hub) के रूप में भी स्थापित करता है।
            रत्नों की चमक और विदेशी मुसाफिरों की चहल-पहल अयोध्या के रास्तों को हर दिन एक उत्सव जैसा बना देती थी।
        """.trimIndent(),
        englishCommentary = """
            The city was beautifully adorned by the presence of merchants (Vanigbhih) arriving from various diverse countries.
            The grand palaces (Prasadah), intricately studded with precious gems, looked as magnificent as towering mountains.
            'Nanadeshanivasaishcha' confirms that Ayodhya engaged in global trade, and foreign merchants felt completely secure there.
            The influx of merchants is a direct reflection of a robust economy, liberal policies, and a fair taxation system.
            The gem-studded mansions (Ratnavikritaih) were not mere structures; they were the physical evidence of Kosala’s unmatched opulence.
            The sheer height and grandeur of these palaces created the illusion that mountains of gold and diamonds stood within the city.
            Valmiki presents a very ancient, yet sophisticated picture of 'Globalization' and free trade in this verse.
            Merchants did not just bring wealth; they facilitated a vibrant exchange of diverse cultures, arts, and ideas.
            Under Dasharatha’s reign, the administration was so just that global traders voluntarily desired to settle in Ayodhya.
            This verse establishes Ayodhya not merely as a religious capital, but as a highly advanced 'Commercial Hub.'
            The glitter of jewels and the lively bustle of foreign travelers made the streets of Ayodhya feel like a perpetual festival.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 12,
        sanskrit = "कूटागारैश्च सम्पूर्णाम् इन्द्रस्येवामरावतीम् ।\nचित्रामष्टापदाकारां वराभरणसञ्चयाम् ॥ १२ ॥",
        hindiCommentary = """
            वह नगरी सुंदर शिखरों वाले घरों (कूटागारैः) से पूरी तरह भरी हुई थी और इन्द्र की 'अमरावती' के समान प्रतीत होती थी।
            नगर का विन्यास (Design) चौपड़ (अष्टापद) के खेल की तरह अत्यंत तार्किक, चित्र-विचित्र और श्रेष्ठ आभूषणों से भरा हुआ था।
            'कूटागार' उन विशिष्ट भवनों को कहते हैं जिनकी छतें कलात्मक शिखरों और गुंबदों से सुसज्जित होती हैं।
            इन्द्र की अमरावती से तुलना यह दर्शाती है कि अयोध्या का भौतिक और आध्यात्मिक वैभव स्वर्ग से किसी भी रूप में कम नहीं था।
            'अष्टापदाकारां' का अर्थ है कि अयोध्या की सड़कें ग्रिड (Grid) प्रणाली पर आधारित थीं, जो एक-दूसरे को समकोण पर काटती थीं।
            यह प्राचीन 'टाउन प्लानिंग' (Town Planning) का एक उत्कृष्ट उदाहरण है, जहाँ कोई भी मार्ग टेढ़ा-मेढ़ा या भ्रमित करने वाला नहीं था।
            'वराभरणसञ्चयाम्' बताता है कि नगर में उत्तम रत्नों और आभूषणों के विशाल भंडार थे, और लोग उन्हें धारण भी करते थे।
            वाल्मीकि जी ने यहाँ अयोध्या के 'एरियल व्यू' (Aerial View) का वर्णन किया है, जो ऊपर से एक सुंदर बिसात जैसा दिखता था।
            नगर का हर कोना इतना सुव्यवस्थित था कि नागरिक बिना किसी कठिनाई के एक स्थान से दूसरे स्थान जा सकते थे।
            यह श्लोक वास्तुकला (Architecture) और ज्यामिति (Geometry) के उस उन्नत ज्ञान को प्रमाणित करता है जो उस काल में मौजूद था।
            अयोध्या केवल एक शहर नहीं, बल्कि एक बहुत बड़ी और जीवंत कला-कृति (Art Piece) थी।
        """.trimIndent(),
        englishCommentary = """
            The city was filled with beautiful peak-roofed houses (Kutagaraih) and resembled Indra’s celestial city, 'Amaravati.'
            The city’s layout was wonderfully designed like a chessboard (Ashtapadakaram) and was a repository of excellent ornaments.
            'Kutagara' refers to specialized buildings whose roofs are decorated with highly artistic pinnacles and domes.
            The comparison to Indra’s Amaravati implies that the material and spiritual grandeur of Ayodhya was in no way inferior to heaven.
            'Ashtapadakaram' signifies that Ayodhya’s streets were based on a strict Grid system, intersecting perfectly at right angles.
            This serves as an outstanding example of ancient 'Town Planning,' where no road was crooked, chaotic, or confusing.
            'Varabharanasanchayam' indicates that the city held vast reserves of excellent gems, which the citizens proudly wore.
            Valmiki describes an 'Aerial View' of Ayodhya here, observing that from above, it looked like a beautifully arranged game board.
            Every sector was so meticulously organized that citizens could navigate the metropolis without the slightest difficulty.
            This verse validates the advanced knowledge of Architecture and Geometry that existed during that glorious ancient period.
            Ayodhya was not merely a city, but a massive, living, and breathing masterpiece of urban art.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 13,
        sanskrit = "गृहैर्गाढैरविरालाईः सुसमीकृतभूतलैः ।\nक्षीरोदकसमां चैव शालिप्रस्थैश्च सञ्चिताम् ॥ १३ ॥",
        hindiCommentary = """
            अयोध्या के घर अत्यंत सुदृढ़ (गाढैः) और एक-दूसरे के पास-पास (अविरालाईः) बने थे, और वहाँ की भूमि पूरी तरह समतल (सुसमीकृत) थी।
            उस नगरी का जल क्षीर-सागर के समान शुद्ध और मीठा था और वहाँ धान के ढेरों (शालिप्रस्थ) का विशाल संग्रह था।
            घरों का सघन होना यह बताता है कि नगर की जनसंख्या अधिक थी, परंतु समतल भूमि के कारण जल-जमाव या गंदगी की कोई समस्या नहीं थी।
            'सुसमीकृतभूतलैः' (समतल भूमि) का अर्थ है कि सड़कों और रास्तों का निर्माण बहुत ही वैज्ञानिक तरीके से किया गया था।
            कोसल देश में खाद्य सुरक्षा के लिए अन्न (शालिप्रस्थ) का इतना बड़ा संचय था कि अकाल का कोई भय नहीं रहता था।
            जल की तुलना क्षीर-सागर से करना यह सिद्ध करता है कि वहाँ का पर्यावरण पूरी तरह से प्रदूषण-मुक्त और स्वास्थ्यवर्धक था।
            वाल्मीकि जी ने यहाँ नगर के 'इंजीनियरिंग' और 'इको-सिस्टम' (Ecosystem) का बहुत ही व्यावहारिक वर्णन किया है।
            मजबूत घर और स्वच्छ पानी किसी भी उन्नत सभ्यता के प्राथमिक लक्षण होते हैं, जो अयोध्या में बहुतायत में थे।
            कृषि और नागरिक व्यवस्था का यह तालमेल राजा दशरथ की दूरदर्शी प्रशासनिक नीतियों का ही परिणाम था।
            यह श्लोक अयोध्या को एक ऐसे 'स्मार्ट सिटी' के रूप में पेश करता है जहाँ आधारभूत संरचनाएं अपने सर्वोत्तम रूप में थीं।
            लोग केवल महलों में नहीं रहते थे, बल्कि वे प्रकृति के उपहारों के बीच एक अत्यंत सुरक्षित जीवन जीते थे।
        """.trimIndent(),
        englishCommentary = """
            The houses in Ayodhya were robustly built (Gadhaih) and closely spaced (Aviralaih), with perfectly leveled ground (Susamikritabhutalaih).
            The city's water was as pure as the Milky Ocean, and it was stocked with massive heaps of fine rice (Shaliprastha).
            The dense arrangement of houses indicates a high population, yet the leveled ground ensured there was no waterlogging or sanitation issue.
            'Susamikritabhutalaih' (leveled ground) means that the construction of roads and pathways was executed highly scientifically.
            The immense accumulation of grain guarantees that Kosala possessed absolute food security, eliminating any fear of famine.
            Comparing the water to the 'Kshira-Sagara' proves that the environment was completely pollution-free and health-promoting.
            Valmiki provides a very practical description of the city's 'Engineering' and its perfectly balanced 'Ecosystem' here.
            Sturdy housing and pristine water are the primary hallmarks of an advanced civilization, both abundant in Ayodhya.
            This harmony between agriculture and civic infrastructure was the direct result of King Dasharatha's visionary policies.
            This verse presents Ayodhya as an ancient 'Smart City' where all fundamental infrastructure was in its most optimal state.
            Citizens did not just reside in stone structures; they lived a highly secure life amidst the bountiful gifts of nature.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 14,
        sanskrit = "दुन्दुभीभिर्मृदङ्गैश्च वीणाभिः पणवैस्तथा ।\nनादितां भृशमत्यर्थं पृथिव्यां तामनुत्तमाम् ॥ १४ ॥",
        hindiCommentary = """
            वह नगरी दुन्दुभी, मृदङ्ग, वीणा और पणव जैसे वाद्य यंत्रों की मधुर ध्वनियों से निरंतर और अत्यधिक गूँजती रहती थी।
            इस कारण से पृथ्वी पर उस नगरी के समान श्रेष्ठ (अनुत्तमाम्) और कोई दूसरी जगह नहीं थी, जहाँ कला का इतना सम्मान था।
            'नादितां' शब्द यह बताता है कि अयोध्या में केवल सन्नाटा नहीं था, बल्कि वहाँ जीवन का एक अत्यंत पवित्र और संगीतमय उल्लास था।
            संगीत का यह वातावरण वहाँ के लोगों की प्रसन्नता, उनकी शांति और कलात्मक अभिरुचि का जीता-जागता प्रमाण था।
            दुन्दुभी और मृदङ्ग वीर रस और राजकीय उत्सवों के प्रतीक थे, जबकि वीणा की ध्वनि शांति, विद्या और अध्यात्म का संचार करती थी।
            वाल्मीकि जी ने देखा कि नगर का हर कोना किसी न किसी शास्त्रीय राग या लोक धुन से पवित्र बना रहता था।
            यह 'अनुत्तमा' नगरी थी, जिसका अर्थ है कि साहित्य और संगीत के क्षेत्र में इसकी तुलना किसी भी अन्य वैश्विक नगर से असंभव थी।
            राजकीय आयोजनों से लेकर सामान्य जनजीवन तक, संगीत हर व्यक्ति के हृदय को आपस में जोड़ने का एक शक्तिशाली माध्यम था।
            नगरी की सड़कों पर चलने वाले राहगीर भी इन ध्वनियों को सुनकर अपने श्रम की थकान को पूरी तरह भूल जाते थे।
            यह श्लोक अयोध्या की 'सांस्कृतिक संपन्नता' (Cultural Opulence) और उसके उच्च स्तरीय आध्यात्मिक उल्लास को प्रकट करता है।
            संगीत यहाँ केवल मनोरंजन नहीं था, बल्कि वह ईश्वरीय आराधना और सामाजिक समरसता का एक पवित्र यंत्र बन चुका था।
        """.trimIndent(),
        englishCommentary = """
            The city perpetually and intensely resonated with the melodic sounds of drums (Dundubhi), lutes (Veena), and celestial tabors (Panava).
            Because of this, there was absolutely no other city on this earth as excellent (Anuttamam) as Ayodhya, where art was so highly revered.
            The word 'Naditam' suggests that the city was not filled with dead silence, but vibrated with a holy, musical joy of life.
            This musical atmosphere served as living proof of the inhabitants' true happiness, their profound peace, and refined artistic tastes.
            Drums symbolized heroism and grand royal festivities, while the Veena propagated peace, knowledge, and deep spirituality.
            Valmiki noted that every corner of the capital was purified and gladdened by some form of classical raga or folk melody.
            It was an 'Anuttama' city, meaning its stature in the realms of literature and music was unrivaled by any other global metropolis.
            From royal ceremonies to daily chores, music acted as a powerful medium to seamlessly unite the hearts of all citizens.
            Even weary travelers walking on the highways forgot their fatigue upon hearing these soothing and divine celestial acoustics.
            This verse reveals the 'Cultural Opulence' of Ayodhya and its incredibly high standard of collective spiritual joy.
            Music was not mere entertainment here; it had evolved into a sacred tool for divine worship and complete social integration.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 15,
        sanskrit = "विमानमिव सिद्धानां तपसाधिगतं दिवि ।\nसुनिवेशितवेश्मान्तां नरोत्तमसमावृताम् ॥ १५ ॥",
        hindiCommentary = """
            यह नगरी स्वर्ग (दिवि) में सिद्ध पुरुषों द्वारा अपनी तपस्या (तपसा) से प्राप्त किए गए किसी दिव्य विमान के समान सुशोभित थी।
            इसमें अत्यंत सुंदर और सुव्यवस्थित घर (सुनिवेशितवेश्मान्तां) बने हुए थे और यह श्रेष्ठ मनुष्यों (नरोत्तम) से भरी हुई थी।
            वाल्मीकि जी ने अयोध्या की तुलना 'सिद्धों के विमान' से की है, जिसका अर्थ है कि यह नगरी केवल ईंट-पत्थर से नहीं, पुण्यों से बनी थी।
            जैसे तपस्या के बल पर प्राप्त स्वर्ग का सुख कभी क्षीण नहीं होता, वैसे ही अयोध्या का ऐश्वर्य भी स्थायी और दोषरहित था।
            'सुनिवेशित' का अर्थ है कि हर घर का वास्तु (Vastu) और उसकी दिशा इतनी सटीक थी कि सूर्य का प्रकाश और हवा हर घर में पहुँचती थी।
            'नरोत्तम' विशेषण यह सिद्ध करता है कि यहाँ रहने वाले लोग साधारण मनुष्य नहीं थे, बल्कि वे गुणों और आचरण में श्रेष्ठ थे।
            नगर की सुंदरता तभी सार्थक होती है जब उसमें निवास करने वाले लोगों का चरित्र भी उतना ही सुंदर और पवित्र हो।
            यहाँ भौतिक संपन्नता (महलों) और आध्यात्मिक संपन्नता (तपस्या) का एक अत्यंत दुर्लभ और सुंदर समन्वय दिखाया गया है।
            अयोध्या के निवासी अपने कर्मों से सिद्ध बन चुके थे, और उनकी नगरी साक्षात् स्वर्ग का पृथ्वी पर उतरा हुआ रूप थी।
            यह श्लोक अयोध्या को केवल एक राजधानी नहीं, बल्कि एक 'तपोभूमि' (Land of Penance) के रूप में भी महिमामंडित करता है।
            इस नगरी का एक-एक कोना धर्म और पुरुषार्थ की गवाही देता हुआ प्रतीत होता था।
        """.trimIndent(),
        englishCommentary = """
            This city was as radiant as a divine flying chariot (Vimana) attained in heaven (Divi) by perfected beings (Siddhas) through their severe penance.
            It featured perfectly arranged and beautifully designed houses, and was fully populated by the most excellent of human beings (Narottama).
            Valmiki compares Ayodhya to the 'Vimana of Siddhas,' meaning the city was constructed not just of stones, but built upon accumulated virtues.
            Just as the celestial joys earned through penance never fade, the opulence of Ayodhya was similarly permanent and entirely flawless.
            'Suniveshita' implies that the Vastu (architecture) of every house was so precise that natural light and air reached every corner.
            The epithet 'Narottama' proves that the residents were not ordinary humans; they were exceptional in their virtues and daily conduct.
            The beauty of a city is truly meaningful only when the character of its inhabitants is equally beautiful, pure, and noble.
            A highly rare and beautiful synthesis of material prosperity (palaces) and spiritual richness (penance) is showcased here.
            The citizens of Ayodhya had become perfected beings through their deeds, making their city a literal heaven descended upon the earth.
            This verse glorifies Ayodhya not merely as a political capital, but as a 'Tapobhumi' (Land of Penance) and high spiritual energy.
            Every single corner of this magnificent city seemed to bear witness to the power of Dharma and righteous human endeavor.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 16,
        sanskrit = "ये च बाणैर्न विध्यन्ति विविक्तमपराधिनम् ।\nसशब्दवेधं लक्ष्यघ्नाः शूरैस्तैराभिपूरिताम् ॥ १६ ॥",
        hindiCommentary = """
            अयोध्या ऐसे शूरवीर योद्धाओं से भरी हुई थी जो अकेले, असहाय या भागते हुए (विविक्तम्) अपराधी पर कभी बाण नहीं चलाते थे।
            वे योद्धा 'शब्दभेदी' विद्या में निपुण थे, जो केवल आवाज सुनकर ही अपने अदृश्य लक्ष्य को बींधने (लक्ष्यघ्नाः) की अद्भुत क्षमता रखते थे।
            यह श्लोक अयोध्या की सैन्य शक्ति के उस 'नैतिक संहिता' (Code of Ethics) को दर्शाता है जो युद्ध में भी मानवीय संवेदनाओं का पालन करती थी।
            निहत्थे या शरण में आए शत्रु पर प्रहार न करना रघुकुल के वीरों का सबसे बड़ा धर्म और उनके अदम्य साहस का प्रतीक था।
            'शब्दभेदी' बाण चलाने की कला उस समय की सबसे उन्नत और कठिन सैन्य तकनीक (Sniper Technology) मानी जाती थी।
            राजा दशरथ स्वयं इस विद्या के सबसे बड़े ज्ञाता थे (जिसका प्रमाण श्रवण कुमार के प्रसंग में मिलता है), और उनकी सेना भी इसी में पारंगत थी।
            ऐसे वीरों (शूरैः) से भरी होने के कारण कोई भी विदेशी शक्ति अयोध्या की ओर आँख उठाकर देखने का दुस्साहस नहीं कर सकती थी।
            वाल्मीकि जी यह स्पष्ट कर रहे हैं कि अयोध्या की शक्ति अंधाधुंध हिंसा पर नहीं, बल्कि संयम, कौशल और न्याय पर टिकी थी।
            ये योद्धा युद्धभूमि में सिंह के समान भयंकर थे, परंतु धर्म की मर्यादा के भीतर रहकर ही अपने बाणों का संधान करते थे।
            यह श्लोक 'मर्यादा' के उस दर्शन को प्रस्तुत करता है जो आगे चलकर श्री राम के चरित्र का मुख्य आधार बनने वाला था।
            अयोध्या केवल धन से नहीं, बल्कि ऐसे चरित्रवान और तकनीकी रूप से सक्षम रक्षकों के कारण 'अजेय' थी।
        """.trimIndent(),
        englishCommentary = """
            Ayodhya was filled with heroic warriors who would never shoot their arrows at a lonely, helpless, or fleeing (Viviktam) offender.
            These warriors were masters of 'Shabdabhedi' archery, possessing the miraculous ability to strike invisible targets merely by hearing their sound.
            This verse highlights the 'Code of Ethics' of Ayodhya’s military, which strictly adhered to human empathy even in the heat of battle.
            Not striking an unarmed or surrendered enemy was the paramount Dharma of the Solar warriors and the ultimate symbol of their courage.
            The art of shooting 'Shabdabhedi' (sound-piercing) arrows was considered the most advanced and difficult military technology (Sniper skill) of that era.
            King Dasharatha himself was a master of this science, and his entire army was rigorously trained and proficient in this elite warfare.
            Being populated by such exceptionally skilled heroes (Shuraih), no foreign power ever dared to cast an evil eye toward Ayodhya.
            Valmiki clarifies that Ayodhya’s might did not rely on blind, mindless violence, but on extreme restraint, tactical skill, and justice.
            These warriors were as fierce as lions on the battlefield, yet they only discharged their weapons strictly within the boundaries of Dharma.
            This verse introduces the philosophy of 'Maryada' (propriety) that would later become the central defining pillar of Lord Rama's character.
            Ayodhya was truly 'unconquerable' not because of its wealth, but due to these morally upright and technologically supreme defenders.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 17,
        sanskrit = "नानास्त्रशस्त्रकुशलैर्महारथशतावृतैः ।\nअनागतानुगैश्चैव सर्वैः समभिरक्षिताम् ॥ १७ ॥",
        hindiCommentary = """
            वह नगरी अनेक प्रकार के अस्त्रों और शस्त्रों के संचालन में पूर्णतः कुशल सैकड़ों 'महारथियों' (महारथशतावृतैः) द्वारा सुरक्षित थी।
            ये महारथी योद्धा किसी भी आने वाले (अनागत) संकट को पहले से ही भाँप लेने और उसका पीछा कर (अनुगैश्च) उसे नष्ट करने में सक्षम थे।
            'अस्त्र' वे हथियार हैं जो मंत्रों द्वारा फेंके जाते हैं, और 'शस्त्र' वे हैं जो हाथ में पकड़कर चलाए जाते हैं; अयोध्या की सेना दोनों में पारंगत थी।
            'महारथी' उस योद्धा को कहा जाता है जो अकेला ही दस हजार सामान्य सैनिकों के साथ युद्ध करने का सामर्थ्य रखता हो।
            सैकड़ों ऐसे महारथियों की उपस्थिति अयोध्या को एक ऐसा अभेद्य किला बनाती थी जिसे भेदना देवताओं के लिए भी असंभव था।
            'अनागतानुगैः' यह सिद्ध करता है कि अयोध्या का 'प्रिवेंटिव डिफेंस सिस्टम' (Preventive Defense System) अत्यंत सक्रिय था।
            वे शत्रु के आक्रमण की प्रतीक्षा नहीं करते थे, बल्कि गुप्तचरों से सूचना मिलते ही खतरे को उसकी जड़ में ही मिटा देते थे।
            वाल्मीकि जी यहाँ बता रहे हैं कि शांति तभी स्थायी हो सकती है जब राष्ट्र के पास युद्ध की सर्वोच्च तैयारी और अचूक क्षमता हो।
            इन योद्धाओं का मुख्य कार्य विस्तारवाद नहीं, बल्कि केवल अपनी प्रजा और धर्म की पूर्ण रक्षा (समभिरक्षिताम्) करना था।
            यह श्लोक अयोध्या के उस 'मिलिट्री इन्फ्रास्ट्रक्चर' (Military Infrastructure) को दर्शाता है जो किसी भी आधुनिक राष्ट्र के लिए ईर्ष्या का विषय हो।
            ऐसी अभेद्य सुरक्षा के बीच ही अयोध्या की प्रजा निश्चिंत होकर कला, साहित्य और अध्यात्म का विकास कर पा रही थी।
        """.trimIndent(),
        englishCommentary = """
            The city was protected by hundreds of 'Maharathas' (great chariot-warriors) who were absolute experts in wielding various Astras (missiles) and Shastras (hand-weapons).
            These warriors were capable of anticipating unforeseen (Anagata) threats and hunting them down (Anugaih) to neutralize them completely.
            'Astras' are weapons propelled by mantras, while 'Shastras' are hand-held weapons; Ayodhya's military was supremely proficient in both.
            A 'Maharatha' is a specialized warrior officially ranked as being capable of fighting ten thousand ordinary soldiers single-handedly.
            The presence of hundreds of such elite fighters made Ayodhya an impenetrable fortress, unassailable even for the celestial gods.
            'Anagatanugaih' proves that Ayodhya possessed a highly active and incredibly advanced 'Preventive Defense System.'
            They did not passively wait for an enemy attack; acting on intelligence, they annihilated the threat at its very roots pre-emptively.
            Valmiki emphasizes here that lasting peace can only be maintained when a nation possesses the highest readiness and lethal capacity for war.
            The primary duty of these warriors was not ruthless expansionism, but the absolute and total protection (Samabhirakshitam) of their subjects and Dharma.
            This verse illustrates Ayodhya’s 'Military Infrastructure,' which would be a matter of sheer envy for any modern sovereign nation.
            It was solely due to this impregnable security grid that the citizens could peacefully focus on developing art, literature, and high spirituality.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 18,
        sanskrit = "व्याघ्रमूकरसिंहानां नादं श्रुत्वा वनेचराः ।\nये न घ्नन्ति मृगान् जघ्नुर्बाणैस्तैराभिपूरिताम् ॥ १८ ॥",
        hindiCommentary = """
            अयोध्या ऐसे महावीरों से भरी हुई थी जो वन में विचरण करते समय बाघ, सुअर और सिंहों की भयानक दहाड़ सुनकर भी कभी भयभीत नहीं होते थे।
            वे वीर शिकार करते समय कभी भी নিরীह और कमजोर मृगों (हिरणों) को नहीं मारते थे, बल्कि अपने तीखे बाणों से केवल हिंसक पशुओं का ही वध करते थे।
            यह श्लोक उन योद्धाओं के 'शौर्य' (Bravery) और उनकी 'संवेदनशीलता' (Sensitivity) के बीच के उस महान संतुलन को उजागर करता है।
            शेर और बाघ की दहाड़ सुनकर सामान्य मनुष्य कांप जाता है, पर ये योद्धा बिना डरे उनके नाद की दिशा में बढ़कर उनका सामना करते थे।
            कमजोर हिरणों को जीवनदान देना यह सिद्ध करता है कि उनकी वीरता शक्ति के प्रदर्शन के लिए नहीं, बल्कि दुर्बलों की रक्षा के लिए थी।
            प्राचीन काल में शिकार (मृगया) को राजाओं और क्षत्रियों के लिए युद्ध के अभ्यास (Target Practice) के रूप में देखा जाता था।
            परंतु अयोध्या के वीरों ने इस अभ्यास में भी धर्म का पालन किया और प्रकृति के संतुलन (Ecological Balance) को कभी बिगड़ने नहीं दिया।
            वाल्मीकि जी यह स्पष्ट कर रहे हैं कि जिसके पास शक्ति हो, उसे उस शक्ति का उपयोग हमेशा विवेक और करुणा के साथ करना चाहिए।
            ऐसे ही वीर योद्धाओं से अयोध्या पूरी तरह भरी हुई (आभिपूरिताम्) थी, जो उसे संसार की सबसे न्यायप्रिय नगरी बनाते थे।
            यह मर्यादा ही वह संस्कार था जो आगे चलकर श्री राम के भीतर पूर्णता को प्राप्त हुआ और विश्व का मार्गदर्शन किया।
            निरीह की रक्षा और हिंसक का नाश—यही रघुकुल का सबसे बड़ा और शाश्वत सिद्धांत था।
        """.trimIndent(),
        englishCommentary = """
            Ayodhya was filled with great heroes who, while roaming the forests, never panicked upon hearing the terrifying roars of tigers, boars, and lions.
            During hunting, these warriors never killed innocent and weak deer (Mrigan); instead, they used their sharp arrows to slay only the ferocious, predatory beasts.
            This verse highlights the magnificent balance between the 'Bravery' (Shaurya) and the deep 'Sensitivity' of the Ayodhya military.
            The roar of a lion makes an ordinary man tremble, but these warriors fearlessly advanced toward the sound to confront the beast head-on.
            Sparing the weak deer proves that their valor was not for a vain display of power, but was dedicated exclusively to protecting the defenseless.
            In ancient times, hunting (Mrigaya) was viewed by kings and Kshatriyas as an essential exercise for target practice and reflex building.
            However, the warriors of Ayodhya adhered strictly to Dharma even during these drills, ensuring they never disrupted the ecological balance.
            Valmiki makes it clear that those who possess immense power must always wield it with extreme discretion and profound compassion.
            Ayodhya was completely saturated (Abhipuritam) with such noble warriors, making it the most justice-loving city in the entire world.
            This very code of propriety (Maryada) was the cultural seed that would later achieve absolute perfection within Lord Rama to guide humanity.
            Protecting the innocent and destroying the violent—this remained the greatest and most eternal doctrine of the Solar Dynasty.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 19,
        sanskrit = "तामग्निहोत्रैः सङ्कीर्णाम् ऋषिभिश्च निवालिताम् ।\nसर्वलक्षणसम्पन्नां अमरावतीमिव स्थिताम् ॥ १९ ॥",
        hindiCommentary = """
            वह अयोध्या नगरी निरंतर प्रज्वलित रहने वाले अग्निहोत्र यज्ञों से भरी (सङ्कीर्णाम्) हुई थी और महान ऋषियों द्वारा सुरक्षित व निवासित थी।
            नगर के सभी लक्षण पूर्ण रूप से शास्त्रसम्मत थे, और वह नगरी पृथ्वी पर साक्षात् देवराज इन्द्र की स्वर्गपुरी 'अमरावती' के समान स्थित थी।
            (यह श्लोक रामायण के कुछ संस्करणों में नगर के आध्यात्मिक वैभव और उसकी दिव्यता को पुनः दृढ़ करने के लिए प्रयुक्त हुआ है।)
            अग्निहोत्र का धुआं नगर के वातावरण को भौतिक और आध्यात्मिक—दोनों रूपों में अत्यंत शुद्ध और सकारात्मक ऊर्जा से भर देता था।
            ऋषियों का 'निवालित' (निवासित) होना यह सुनिश्चित करता था कि राजा और प्रजा दोनों का नैतिक पतन कभी भी न हो।
            महान ऋषि हमेशा उसी स्थान पर निवास करते हैं जहाँ सत्य, अहिंसा और धर्म का पूरी तरह से आदर किया जाता हो।
            'सर्वलक्षणसम्पन्नां' का अर्थ है कि वास्तुशास्त्र, अर्थशास्त्र और धर्मशास्त्र के सभी उत्तम गुण इस नगरी में साक्षात् विद्यमान थे।
            अमरावती से तुलना यह सिद्ध करती है कि अयोध्या के निवासियों को इस पृथ्वी पर रहते हुए भी स्वर्ग के समान ही सुख और शांति प्राप्त थी।
            वाल्मीकि जी ने इस श्लोक में यह संदेश दिया है कि किसी भी राष्ट्र की असली उन्नति केवल महलों से नहीं, बल्कि यज्ञ और तपस्या से होती है।
            अयोध्या की वह भूमि अब पूरी तरह से भगवान के अवतरण का स्वागत करने के लिए एक पावन वेदी (Altar) के रूप में तैयार हो चुकी थी।
        """.trimIndent(),
        englishCommentary = """
            That city of Ayodhya was densely filled (Sankirnam) with perpetually burning Agnihotra sacrifices and was inhabited and guarded by great sages.
            Endowed completely with all auspicious characteristics, the city stood upon the earth exactly like Indra’s celestial capital, 'Amaravati.'
            (This verse appears in certain recensions to powerfully reiterate and reinforce the spiritual grandeur and the undeniable divinity of the city.)
            The sacred smoke from the Agnihotra purified the city's atmosphere both physically and spiritually, infusing it with massive positive energy.
            The residence of the Rishis ensured that neither the Monarch nor his subjects would ever suffer a moral or ethical downfall.
            Great seers only choose to reside in locations where Truth, non-violence, and Dharma are given the highest and absolute respect.
            'Sarvalakshanasampannam' implies that all the supreme qualities prescribed by ancient architecture, economics, and ethics were present here.
            The comparison to Amaravati proves that the citizens of Ayodhya experienced the exact joy and peace of heaven while living on earth.
            Valmiki conveys the message here that a nation's true progress is not measured by its palaces alone, but by its sacrifices and spiritual penance.
            The very soil of Ayodhya had now been fully prepared and purified, turning into a holy altar ready to welcome the descent of the Supreme Lord.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 20,
        sanskrit = "तस्यां पुर्यां द्विजश्रेष्ठा वृत्तशीलगुणान्विताः ।\nनानाशास्त्रेषु कुशलाः सत्यवन्तो महाबलाः ॥ २० ॥",
        hindiCommentary = """
            उस पावन नगरी अयोध्या में निवास करने वाले ब्राह्मण (द्विजश्रेष्ठा) उत्तम आचरण, शील (चरित्र) और महान सद्गुणों से पूरी तरह युक्त थे।
            वे अनेक प्रकार के शास्त्रों और विद्याओं में अत्यंत कुशल थे, हमेशा सत्य बोलने वाले थे और अपनी तपस्या के कारण महाबली थे।
            समाज में ब्राह्मणों का मुख्य कार्य ज्ञान का प्रसार और नैतिक दिशा-निर्देश देना होता है, जिसे वे पूरी निष्ठा से निभा रहे थे।
            'वृत्तशीलगुणान्विताः' यह सिद्ध करता है कि उनका ज्ञान केवल पोथियों तक सीमित नहीं था, बल्कि वह उनके आचरण में साक्षात् झलकता था।
            शास्त्रों में कुशलता उन्हें धर्म के जटिल प्रश्नों को सुलझाने और राजा को सही परामर्श देने की अद्भुत क्षमता प्रदान करती थी।
            सत्यवक्ता होना उनके जीवन का सबसे बड़ा व्रत था; वे किसी भी भय या लालच में आकर कभी भी असत्य का सहारा नहीं लेते थे।
            ब्राह्मणों को 'महाबल' कहा गया है, जिसका अर्थ शारीरिक बल नहीं, बल्कि उनके मंत्रों, श्राप और आशीर्वाद की उस प्रचंड आध्यात्मिक शक्ति से है।
            वाल्मीकि जी ने यहाँ स्पष्ट किया है कि जब समाज का 'बौद्धिक वर्ग' (Intellectual Class) इतना शुद्ध और शक्तिशाली हो, तो राष्ट्र का पतन असंभव है।
            ये द्विजश्रेष्ठ ही वे स्तंभ थे जिन्होंने अयोध्या की वैचारिक और आध्यात्मिक नींव को हजारों वर्षों तक अडिग और सुरक्षित रखा।
            इन ब्राह्मणों की उपस्थिती के कारण ही अयोध्या की पूरी प्रजा भी स्वभाव से ही संस्कारी और धर्मपरायण बन गई थी।
        """.trimIndent(),
        englishCommentary = """
            The pre-eminent Brahmins (Dvijashreshtha) residing in that holy city of Ayodhya were fully endowed with noble conduct, pure character, and great virtues.
            They were profoundly skilled in various scriptures and sciences, were unwavering speakers of Truth, and possessed immense power through their penance.
            In society, the primary duty of Brahmins is to disseminate wisdom and provide moral direction, a duty they executed with absolute sincerity.
            'Vrittashilagunanvitah' proves that their knowledge was not confined to dusty manuscripts; it was vibrantly reflected in their daily conduct.
            Their mastery over the Shastras granted them the extraordinary ability to resolve complex moral dilemmas and provide accurate counsel to the King.
            Being 'Satyavantah' (truthful) was their greatest vow; they never resorted to falsehood under the influence of any fear or worldly temptation.
            The Brahmins are termed 'Mahabala' (highly powerful), which refers not to physical brawn, but to the tremendous spiritual potency of their mantras and blessings.
            Valmiki clarifies here that when the 'Intellectual Class' of a society is so pristine and spiritually powerful, the nation's downfall becomes impossible.
            These excellent Brahmins were the very pillars that kept the ideological and spiritual foundations of Ayodhya unshakable and secure for millennia.
            It was entirely due to the presence and influence of these Brahmins that the entire populace of Ayodhya naturally became cultured and righteous.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 21,
        sanskrit = "क्षमावन्तो यशस्विनो दानशीला महर्षयः ।\nन चाप्यविद्वान् कश्चित्स्यात् न चादाक्षिण्यवान् नरः ॥ २१ ॥",
        hindiCommentary = """
            अयोध्या के वे महर्षि और श्रेष्ठ नागरिक अत्यंत क्षमावान, यशस्वी और स्वभाव से ही दान देने वाले (दानशीला) थे।
            उस नगरी में न तो कोई भी मनुष्य अज्ञानी (अविद्वान्) था, और न ही कोई ऐसा व्यक्ति था जो दूसरों के प्रति उदार या दयालु (अदाक्षिण्यवान्) न हो।
            क्षमाशीलता यह बताती है कि वे लोग क्रोध और प्रतिशोध जैसी नकारात्मक भावनाओं से पूरी तरह मुक्त और शांत थे।
            यशस्वी होने का अर्थ है कि उनके पुण्यों और ज्ञान की चर्चा अयोध्या की सीमाओं को पार कर अन्य देशों में भी आदर के साथ होती थी।
            दानशीलता का गुण यह सिद्ध करता है कि धन का संचय केवल व्यक्तिगत सुख के लिए नहीं, बल्कि समाज के कल्याण के लिए किया जाता था।
            'अविद्वान्' (मूर्ख) का न होना इस बात का अकाट्य प्रमाण है कि राज्य की शिक्षा व्यवस्था अत्यंत सुदृढ़ थी और हर नागरिक तक उसकी पहुँच थी।
            'अदाक्षिण्यवान्' (कंजूस या कठोर) का अभाव यह दर्शाता है कि लोग एक-दूसरे की पीड़ा को समझते थे और हर संभव सहायता के लिए तत्पर रहते थे।
            वाल्मीकि जी ने यहाँ एक ऐसे 'यूटोपियन' (Utopian) समाज का सजीव चित्रण किया है जहाँ हर मनुष्य अपने आप में पूर्ण और श्रेष्ठ है।
            जब समाज का हर व्यक्ति विद्वान और उदार हो जाए, तो वहाँ किसी भी प्रकार के पुलिस या कठोर कानूनों की आवश्यकता ही समाप्त हो जाती है।
            यह श्लोक राम-राज्य की उस मनोवैज्ञानिक और सामाजिक आधारशिला का वर्णन है जिसे राजा दशरथ ने अपने सुशासन से तैयार किया था।
        """.trimIndent(),
        englishCommentary = """
            The Maharishis and elite citizens of Ayodhya were extremely forgiving, illustrious, and naturally inclined toward charity (Danashila).
            In that city, there was not a single person who was unlearned (Avidvan), nor was there any man who lacked generosity or kindness (Adakshinyavan).
            Being forgiving indicates that the populace was completely free from negative emotions like blinding anger and the desire for petty revenge.
            Being illustrious meant that the tales of their virtues and wisdom crossed the borders of Ayodhya and were discussed with reverence globally.
            The trait of charity proves that the accumulation of wealth was not for selfish hoarding, but was utilized actively for the welfare of the broader society.
            The absence of 'Avidvan' (uneducated fools) is irrefutable evidence that the state's education system was highly robust and accessible to every citizen.
            The lack of 'Adakshinyavan' (miserly or harsh people) shows that the citizens deeply understood each other's pain and were always ready to assist.
            Valmiki paints a vivid picture of a truly 'Utopian' society here, where every human being is complete, self-actualized, and inherently noble.
            When every individual in a society becomes wise and generous, the need for heavy policing or draconian laws automatically ceases to exist.
            This verse describes the exact psychological and social bedrock of Ram-Rajya that King Dasharatha had meticulously cultivated through his governance.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 22,
        sanskrit = "नानाशीलाश्च वणिजो नराः स्वकर्मनिष्ठाश्च ।\nसन्तुष्टाः स्वधनैः सर्वे नासत्यं किञ्चिदूचिरे ॥ २२ ॥",
        hindiCommentary = """
            वहाँ विभिन्न अच्छे स्वभाव (नानाशीलाश्च) वाले व्यापारी निवास करते थे, और सभी मनुष्य अपने-अपने कर्मों (कत्र्तव्यों) में पूरी निष्ठा के साथ लगे रहते थे।
            सभी नागरिक अपने स्वयं के न्यायोचित धन से पूर्णतः संतुष्ट थे, और उनमें से कोई भी कभी भी रत्ती भर झूठ (नासत्यं) नहीं बोलता था।
            व्यापारियों का 'नानाशील' होना यह बताता है कि वे व्यापार में कपट या धोखाधड़ी नहीं करते थे, बल्कि अत्यंत ईमानदार और शिष्ट थे।
            'स्वकर्मनिष्ठा' का अर्थ है कि समाज का हर वर्ग—ब्राह्मण, क्षत्रिय, वैश्य और शूद्र—अपने निर्धारित कर्तव्यों का पूरी ईमानदारी से पालन करता था।
            यह स्वकर्म-निष्ठा ही अयोध्या की आर्थिक और सामाजिक स्थिरता का सबसे बड़ा कारण थी, जहाँ कोई भी दूसरे के कार्य में हस्तक्षेप नहीं करता था।
            'सन्तुष्टाः स्वधनैः' (अपने धन से संतुष्ट) होना एक बहुत बड़ा आध्यात्मिक गुण है जो समाज को चोरी, ईर्ष्या और भ्रष्टाचार से पूरी तरह बचाता है।
            जब लोग अपने पुरुषार्थ से कमाए धन पर संतोष करते हैं, तो राज्य में अपराध दर अपने आप शून्य (Zero) हो जाती है।
            झूठ का पूर्णतः अभाव (नासत्यं) यह सिद्ध करता है कि व्यापार से लेकर व्यक्तिगत संबंधों तक, हर जगह केवल पारदर्शिता और सत्य का ही बोलबाला था।
            वाल्मीकि जी ने यहाँ यह स्पष्ट किया है कि एक महान राष्ट्र का निर्माण धन से नहीं, बल्कि नागरिकों के 'चरित्र' और उनके 'संतोष' से होता है।
            अयोध्या के इस समाज में अर्थ (Wealth) और धर्म (Ethics) एक-दूसरे के विरोधी नहीं, बल्कि पूरक बनकर साथ-साथ चल रहे थे।
        """.trimIndent(),
        englishCommentary = """
            Merchants possessing diverse noble characters resided there, and all the people were absolutely dedicated (Nishtha) to their respective duties (Svakarma).
            Every citizen was completely satisfied with their own righteously earned wealth, and none among them ever uttered the slightest falsehood (Nasatyam).
            The merchants being 'Nanashila' indicates that they never engaged in deceit or fraud in commerce; they were impeccably honest and well-mannered.
            'Svakarmanishtha' means that every section of society—Brahmins, Kshatriyas, Vaishyas, and Shudras—performed their prescribed duties with utmost sincerity.
            This dedication to one's own duty was the prime reason behind Ayodhya's socio-economic stability, where no one interfered in another's domain.
            Being 'Santushtah svadhanaih' (satisfied with one's own wealth) is a massive spiritual virtue that totally immunizes a society against theft, envy, and corruption.
            When people are content with the wealth earned through their own honest labor, the crime rate of the state automatically drops to absolute zero.
            The total absence of lies (Nasatyam) proves that from corporate trade to intimate personal relationships, transparency and Truth reigned supreme everywhere.
            Valmiki clarifies here that a truly great nation is built not upon hoarded wealth, but upon the solid 'Character' and internal 'Contentment' of its citizens.
            In this society of Ayodhya, Artha (Wealth) and Dharma (Ethics) were not in conflict; they walked hand-in-hand as perfect, complementary partners.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 23,
        sanskrit = "दीनारान् बहुसाहस्रान् न कश्चिद् दरिद्रो वा ।\nअनादृतो वा कृपणो नासीत् तस्यां पुरोत्तमे ॥ २३ ॥",
        hindiCommentary = """
            उस श्रेष्ठ नगरी (पुरोत्तमे) अयोध्या में कोई भी व्यक्ति ऐसा नहीं था जिसके पास हजारों स्वर्ण मुद्राएं (दीनारान्) न हों, और वहाँ कोई भी दरिद्र (गरीब) नहीं था।
            वहाँ न तो कोई ऐसा व्यक्ति था जिसका समाज में अनादर होता हो, और न ही कोई ऐसा कृपण (कंजूस) था जो धन होते हुए भी खर्च न करे।
            हजारों मुद्राओं का होना यह सिद्ध करता है कि दशरथ के राज्य में धन का वितरण अत्यंत समान और न्यायपूर्ण था; हर व्यक्ति आर्थिक रूप से संपन्न था।
            'दरिद्र' का न होना किसी भी शासन व्यवस्था की सबसे बड़ी और ऐतिहासिक उपलब्धि मानी जाती है, जिसे अयोध्या ने पूर्णतः प्राप्त कर लिया था।
            'अनादृत' (अपमानित) का अभाव यह बताता है कि समाज में हर व्यक्ति—चाहे वह किसी भी वर्ण या कार्य से जुड़ा हो—सम्मान और गरिमा के साथ जीता था।
            कृपणता (कंजूसी) का न होना यह दर्शाता है कि लोग धन के लोभी नहीं थे; वे दान, यज्ञ और परोपकार के कार्यों में मुक्त हस्त से धन खर्च करते थे।
            वाल्मीकि जी ने यहाँ आर्थिक समृद्धि (Prosperity) और सामाजिक समानता (Social Equality) का एक अत्यंत सटीक और आदर्श चित्र प्रस्तुत किया है।
            जब धन का प्रवाह समाज में निरंतर बना रहता है (कंजूसी के अभाव के कारण), तो अर्थव्यवस्था कभी मंदी का शिकार नहीं होती।
            यह श्लोक 'वेल्फेयर स्टेट' (Welfare State) की उस प्राचीन अवधारणा को दिखाता है जहाँ राज्य का अंतिम व्यक्ति भी सम्राट के समान ही सुखी था।
            इन पंक्तियों को पढ़कर पाठक के मन में अयोध्या के उस स्वर्ण युग के प्रति एक अगाध श्रद्धा और आश्चर्य का भाव स्वतः ही उत्पन्न हो जाता है।
        """.trimIndent(),
        englishCommentary = """
            In that most excellent of cities (Purottame), there was absolutely no one who did not possess thousands of gold coins (Dinaras), and no one was poor (Daridra).
            There was neither anyone who was disrespected (Anadrita) in society, nor was there any miser (Kripana) who hoarded wealth without spending it righteously.
            Possessing thousands of coins proves that wealth distribution in Dasharatha’s kingdom was highly equitable and just; every individual was economically affluent.
            The eradication of 'Daridra' (poverty) is considered the greatest historic achievement of any governance system, a feat Ayodhya had fully accomplished.
            The absence of the 'Anadrita' (disrespected) indicates that every person—regardless of their class or occupation—lived with absolute dignity and honor.
            The lack of misers shows that people were not greedy slaves to money; they spent generously on charity, sacrifices, and acts of social welfare.
            Valmiki presents an incredibly precise and ideal picture of both supreme Economic Prosperity and absolute Social Equality in this verse.
            When wealth flows continuously through a society (due to the absence of miserliness), the economy never falls prey to stagnation or recession.
            This verse illustrates the ancient concept of a 'Welfare State,' where even the last man in the social order was as happy as the Emperor himself.
            Reading these lines naturally evokes a profound sense of reverence and utter amazement in the reader's mind regarding Ayodhya’s golden age.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 24,
        sanskrit = "सर्वे नराश्च नार्यश्च धर्मशीलाः सुसंयताः ।\nमुदिताः शीलवृत्ताभ्यां महर्षय इवामलाः ॥ २४ ॥",
        hindiCommentary = """
            अयोध्या के सभी नर और नारियाँ स्वभाव से ही धार्मिक (धर्मशीलाः) और अपनी इंद्रियों व आचरण पर पूर्ण नियंत्रण (सुसंयताः) रखने वाले थे।
            वे सभी अपने श्रेष्ठ शील (स्वभाव) और उत्तम आचरण (वृत्त) के कारण सदैव प्रसन्न (मुदिताः) रहते थे और महर्षियों के समान निर्मल (अमलाः) थे।
            'सुसंयताः' का अर्थ है कि नगरवासी भौतिक सुखों की प्रचुरता के बावजूद कभी भी वासना या विलासिता में अंधे नहीं होते थे।
            स्त्रियों और पुरुषों—दोनों का समान रूप से धर्मशील होना यह सिद्ध करता है कि समाज में आध्यात्मिक शिक्षा का स्तर अत्यंत व्यापक और भेदभाव-रहित था।
            प्रसन्नता (मुदिताः) बाहरी कारणों से नहीं, बल्कि उनके भीतरी 'शील' और 'सदाचार' से उत्पन्न होती थी, जो कभी नष्ट नहीं होती।
            वाल्मीकि जी ने साधारण नागरिकों की तुलना 'महर्षियों' से की है, जिसका तात्पर्य है कि उनका चरित्र तपस्वियों जितना ही उज्ज्वल और पाप-रहित था।
            'अमलाः' (मल रहित) विशेषण यह बताता है कि उनके मनों में काम, क्रोध, लोभ या ईर्ष्या का कोई भी दाग नहीं बचा था।
            जब प्रजा का चरित्र इतना ऊँचा हो जाए, तो राजा को शासन करने के लिए बल-प्रयोग या कठोर दंडनीति की कोई आवश्यकता ही नहीं रह जाती।
            यह श्लोक एक आदर्श नागरिक (Ideal Citizen) की रूपरेखा प्रस्तुत करता है जो किसी भी महान और स्थिर राष्ट्र की असली नींव होता है।
            अयोध्या का यह समाज वास्तव में एक 'राम-राज्य' के लिए पूरी तरह से परिपक्व हो चुका था।
        """.trimIndent(),
        englishCommentary = """
            All the men and women of Ayodhya were inherently righteous by nature (Dharmashilah) and exercised absolute self-control over their senses (Susamyatah).
            They remained perpetually joyful (Muditah) due to their excellent disposition (Shila) and noble conduct (Vritta), and were as pure (Amalah) as great sages.
            'Susamyatah' means that despite the sheer abundance of material luxuries, the citizens never blinded themselves with lust or unbridled hedonism.
            Both men and women being equally righteous proves that spiritual and moral education in society was universally widespread and totally non-discriminatory.
            Their happiness (Muditah) did not stem from external stimuli, but originated directly from their inner 'Shila' and morality, making it indestructible.
            Valmiki compares ordinary citizens to 'Maharishis,' signifying that their daily character was as brilliantly radiant and sinless as that of severe ascetics.
            The adjective 'Amalah' (without blemish) indicates that their minds were completely cleansed of the dark stains of lust, anger, greed, and deep envy.
            When the character of the populace reaches such an elevated zenith, the King finds absolutely no need to use force or draconian penal policies to govern.
            This verse outlines the exact profile of an 'Ideal Citizen,' who inherently forms the true and unshakable foundation of any great and stable nation.
            The society of Ayodhya had indeed become fully mature and perfectly primed for the imminent establishment of the legendary Ram-Rajya.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 25,
        sanskrit = "नाकुण्डली नामुकुटी नास्रग्वी नाल्पभोगवान् ।\nनामृष्टो नानुल्लिप्ताङ्गो नासुगन्धश्च किञ्चन ॥ २५ ॥",
        hindiCommentary = """
            उस नगरी में ऐसा कोई व्यक्ति नहीं था जो कुंडल न पहनता हो, मुकुट न लगाता हो, या जिसके गले में फूलों की सुंदर माला (स्रग्वी) न हो।
            वहाँ कोई भी ऐसा नागरिक नहीं था जो अल्प-भोगी (कम सुख-सुविधाओं वाला) हो, जो स्नान न करता हो (नामृष्टो), या जिसके अंगों पर सुगंधित लेप न लगा हो।
            यह श्लोक अयोध्या के निवासियों की 'लाइफस्टाइल' (Lifestyle) और उनके अत्यंत उच्च 'जीवन स्तर' (Standard of Living) का बहुत ही सजीव चित्रण करता है।
            कुंडल और मुकुट पहनना यह सिद्ध करता है कि अयोध्या का हर साधारण नागरिक भी किसी राजा या सामंत के समान राजसी वेशभूषा धारण करता था।
            अल्पभोगवान न होने का अर्थ है कि हर व्यक्ति के पास अपनी इच्छा और आवश्यकता से कहीं अधिक साधन और सुख-सुविधाएं मौजूद थीं।
            नियमित स्नान और अंगों पर चंदन आदि का लेप (अनुल्लिप्ताङ्गो) उनके उच्च स्तर के स्वास्थ्य, स्वच्छता और 'पर्सनल हाइजीन' (Personal Hygiene) को दर्शाता है।
            फूलों की माला और सुगंध का प्रयोग यह बताता है कि वे लोग सौंदर्य-प्रेमी थे और प्रकृति के साथ उनका बहुत ही मधुर और कलात्मक संबंध था।
            वाल्मीकि जी यहाँ स्पष्ट कर रहे हैं कि धर्म का पालन करने का अर्थ दरिद्रता में जीना नहीं है; धर्म और ऐश्वर्य साथ-साथ चल सकते हैं।
            यह भौतिक समृद्धि उनके पतन का कारण नहीं बनी, बल्कि यह उनके पुण्य कर्मों का ही एक सहज और स्वाभाविक फल था।
            अयोध्या की सड़कों पर चलते हुए हर व्यक्ति से एक दिव्य सुगंध और एक राजसी तेज की किरणें निरंतर प्रस्फुटित होती रहती थीं।
        """.trimIndent(),
        englishCommentary = """
            In that city, there was absolutely no one without earrings (Kundali), without a coronet (Mukuti), or without wearing a beautiful garland of flowers (Sragvi).
            There was no citizen who enjoyed meager comforts (Alpabhogavan), who was unbathed (Namrishto), or whose body was not anointed with fragrant pastes.
            This verse paints a highly vivid picture of the opulent 'Lifestyle' and the extraordinarily high 'Standard of Living' enjoyed by the residents of Ayodhya.
            Wearing earrings and coronets proves that even the most ordinary citizen of Ayodhya dressed in a regal attire comparable to that of minor kings or lords.
            Not being 'Alpabhogavan' (having meager enjoyments) means that every individual possessed resources and luxuries far exceeding their basic desires and needs.
            Regular bathing and anointing the body with sandalwood paste reflect their extremely high standards of health, absolute cleanliness, and 'Personal Hygiene.'
            The use of floral garlands and natural perfumes indicates that they were profound lovers of aesthetics and maintained a deeply artistic relationship with nature.
            Valmiki clarifies here that practicing Dharma does not equate to living in miserable poverty; pristine ethics and immense material opulence can coexist perfectly.
            This massive physical prosperity did not become the cause of their moral downfall; rather, it was the natural and effortless fruit of their righteous karma.
            Walking down the streets of Ayodhya, one would sense a continuous emanation of divine fragrance and a majestic, royal radiance from every passing individual.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 26,
        sanskrit = "नानाभरणशोभाढ्या नानामाल्यविभूषिताः ।\nसुगन्धिनो रसवन्तो नरा नार्यश्च सर्वशः ॥ २६ ॥",
        hindiCommentary = """
            वहाँ के सभी नर और नारी अनेक प्रकार के स्वर्ण और रत्नों के आभूषणों (नानाभरण) से अत्यंत शोभायमान रहते थे।
            वे सभी विविध प्रकार की ताजी और रंग-बिरंगी पुष्प मालाओं से सुसज्जित (विभूषिताः) रहते थे और उत्तम सुगन्धियों का उपयोग करते थे।
            वे रसिक (रसवन्तो) थे, अर्थात वे साहित्य, संगीत, कला और जीवन के सभी सात्विक सुखों का भरपूर आनंद लेना भली-भांति जानते थे।
            आभूषणों की यह प्रचुरता फिर से कोसल देश की उस अथाह आर्थिक संपन्नता को प्रमाणित करती है जिसका उल्लेख पूर्व के श्लोकों में किया गया है।
            स्त्रियों के साथ-साथ पुरुषों का भी आभूषण और मालाएं धारण करना उस युग की परिष्कृत 'फैशन' (Fashion) और शृंगार-चेतना को दर्शाता है।
            सुगंधियों (इत्र, चंदन आदि) का प्रयोग यह सुनिश्चित करता था कि पूरे नगर का वातावरण सदैव तरोताजा, पवित्र और मनमोहक बना रहे।
            'रसवन्तो' शब्द यह स्पष्ट करता है कि वे लोग केवल शुष्क तपस्वी नहीं थे; वे जीवन के रस को धर्म की मर्यादा में रहकर पूरी तरह पीते थे।
            वाल्मीकि जी ने यहाँ एक ऐसा समाज गढ़ा है जो भौतिक रूप से पूर्णतः संतुष्ट है और जिसका मन कला और सौंदर्य के प्रति अत्यंत संवेदनशील है।
            यह श्लोक यह संदेश देता है कि जब मन में पाप नहीं होता, तो मनुष्य बाह्य रूप से भी अत्यंत सुंदर और आकर्षक लगने लगता है।
            पूरी अयोध्या नगरी एक ऐसे शाश्वत उत्सव (Festival) की तरह प्रतीत होती थी जहाँ शोक, उदासी या मलिनता का कोई स्थान ही नहीं था।
        """.trimIndent(),
        englishCommentary = """
            All the men and women there were magnificently adorned with various types of gold and gem-studded ornaments (Nanabharana).
            They were decorated (Vibhushitah) with diverse, fresh, and colorful floral garlands, and they profusely used excellent natural fragrances.
            They were 'Rasavanto' (appreciators of taste/aesthetics), meaning they thoroughly knew how to enjoy literature, music, art, and all pure joys of life.
            This immense abundance of jewelry once again strongly authenticates the unfathomable economic prosperity of Kosala mentioned in earlier verses.
            Both men and women equally donning ornaments and garlands reflects the highly refined 'Fashion' sense and aesthetic consciousness of that ancient era.
            The use of fragrances (like perfumes and sandalwood) ensured that the atmosphere of the entire city remained perpetually fresh, sacred, and enchanting.
            The word 'Rasavanto' clarifies that these people were not dry, joyless ascetics; they drank the nectar of life fully while strictly staying within Dharma's limits.
            Valmiki has crafted a society here that is completely satiated materially, and whose collective mind is incredibly sensitive to high art and pristine beauty.
            This verse conveys the deep message that when the mind is entirely free from sin, a human being naturally begins to appear externally beautiful and magnetic.
            The entire city of Ayodhya seemed to exist in a state of eternal festival, where sorrow, gloom, or any form of impurity found absolutely no place to dwell.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 27,
        sanskrit = "नाशुचिर्मलिनो वापि नास्नातो न रजस्वलः ।\nकश्चिदासीत् तदा पुर्यामयोध्यायां नरोत्तम ॥ २७ ॥",
        hindiCommentary = """
            हे नरोत्तम (श्रोता)! उस समय उस महान अयोध्या नगरी में ऐसा कोई भी व्यक्ति नहीं था जो अपवित्र (अशुचि) या मलिन (मैले कपड़े वाला) हो।
            वहाँ कोई भी ऐसा नहीं था जो बिना स्नान किए (नास्नातो) रहता हो या जिसके शरीर पर धूल-मिट्टी (रजस्वलः) लगी हुई हो।
            यह श्लोक अयोध्यावासियों की व्यक्तिगत स्वच्छता (Hygiene) और उनके कड़े दैनिक अनुशासन (Daily Routine) का अत्यंत स्पष्ट प्रमाण है।
            प्राचीन भारतीय संस्कृति में स्नान और शारीरिक शुद्धि को धर्म का पहला और सबसे अनिवार्य अंग माना गया है, जिसका वे पूर्णतः पालन करते थे।
            मलिन वस्त्र न पहनना यह दर्शाता है कि उनके पास वस्त्रों की कोई कमी नहीं थी और वे स्वयं को साफ-सुथरा रखने के प्रति अत्यंत जागरूक थे।
            शरीर पर धूल न होने (अरजस्वल) का एक अर्थ यह भी है कि नगर की सड़कों पर धूल नहीं उड़ती थी, क्योंकि मार्गों पर नियमित जल का छिड़काव होता था।
            वाल्मीकि जी यह बताना चाहते हैं कि जो समाज बाहर से इतना शुद्ध और निर्मल है, उसका आंतरिक मन (आत्मा) भी उतना ही पवित्र होगा।
            बीमारियां अक्सर गंदगी से जन्म लेती हैं; इस स्तर की स्वच्छता ही वह कारण थी जिससे अयोध्या के लोग रोगमुक्त और दीर्घायु (Long-living) होते थे।
            यह श्लोक शारीरिक पवित्रता और मानसिक सात्विकता के बीच के उस गहरे और वैज्ञानिक संबंध को बहुत ही सटीकता से स्थापित करता है।
            अयोध्या केवल धन से नहीं, बल्कि अपनी इसी बेदाग स्वच्छता और चमक के कारण पूरी पृथ्वी पर स्वर्ग के समान चमक रही थी।
        """.trimIndent(),
        englishCommentary = """
            O Best of Men (Listener)! At that time, in that grand city of Ayodhya, there was absolutely no one who was impure (Ashuchi) or wore dirty clothes (Malina).
            There was no one who remained unbathed (Nasnato) or whose body was covered in dust and grime (Rajasvalah).
            This verse acts as explicit and clear evidence of the exceptional personal hygiene and the strict daily routine maintained by the citizens of Ayodhya.
            In ancient Indian culture, bathing and physical purification are considered the first and most mandatory steps of Dharma, which they followed flawlessly.
            Not wearing soiled clothes demonstrates that they faced absolutely no shortage of garments and were highly conscious of maintaining a pristine appearance.
            Having no dust on their bodies (Arajasvala) also points to the fact that the city roads were dust-free, owing to the regular sprinkling of water on the streets.
            Valmiki wishes to convey that a society which is so meticulously pure and clean on the outside will naturally possess an equally pure and radiant inner soul.
            Diseases often breed in filth; this supreme level of sanitation was the exact reason why the people of Ayodhya remained entirely disease-free and long-living.
            This verse scientifically and accurately establishes the deep, intrinsic connection between rigorous physical cleanliness and elevated mental purity (Sattvikata).
            Ayodhya shone like a literal heaven on earth not just because of its hoarded wealth, but because of this very spotless, immaculate cleanliness and radiance.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 28,
        sanskrit = "नानादेशनिवासीभिर्ब्राह्मणैश्चोपशोभिताम् ।\nवेदाध्ययनसम्पन्नैर्गुणवद्भिर्विपश्चिद्भिः ॥ २८ ॥\nइति वाल्मीकिरामायणे बालकाण्डे पञ्चमः सर्गः ॥",
        hindiCommentary = """
            वह दिव्य नगरी अनेक भिन्न-भिन्न देशों से आकर निवास करने वाले महान और तपस्वी ब्राह्मणों (ब्राह्मणैश्च) से अत्यंत सुशोभित (उपशोभिताम्) थी।
            ये सभी ब्राह्मण वेदों के गहन अध्ययन (वेदाध्ययन) में पूर्णतः संपन्न, उत्तम गुणों से युक्त (गुणवद्भिः) और अत्यंत कुशाग्र विद्वान (विपश्चिद्भिः) थे।
            'नानादेशनिवासीभिः' यह सिद्ध करता है कि अयोध्या केवल एक राजनीतिक राजधानी नहीं थी, बल्कि पूरे विश्व के लिए ज्ञान और शोध (Research) का सबसे बड़ा केंद्र थी।
            देश-विदेश के विद्वान ब्राह्मण अपने ज्ञान को और अधिक परिष्कृत करने तथा राजा दशरथ का आश्रय पाने के लिए यहाँ आकर स्थायी रूप से बस जाते थे।
            वेदों का अध्ययन करने वाले इन ब्राह्मणों की मंत्र-ध्वनियों से अयोध्या का आकाश चौबीसों घंटे गुंजायमान और पवित्र बना रहता था।
            'विपश्चित्' होने का अर्थ है कि वे केवल रटने वाले पंडित नहीं थे, बल्कि वेदों के अर्थ को समझकर समाज को सही दिशा दिखाने वाले दूरदर्शी दार्शनिक थे।
            विद्वानों का यह विशाल जमावड़ा अयोध्या के बौद्धिक और आध्यात्मिक वैभव को उस काल के सर्वोच्च और अजेय शिखर पर ले जाकर स्थापित कर देता है।
            इस प्रकार, वाल्मीकि रामायण के बालकाण्ड का 'अयोध्यापुरी वर्णन' नामक यह अत्यंत गरिमामयी 'पाँचवाँ सर्ग' यहाँ पूर्णता को प्राप्त होता है।
            यह सर्ग हमें सिखाता है कि एक आदर्श राष्ट्र वह है जहाँ धन, बल, कला, स्वच्छता और वेदों का ज्ञान एक साथ पूर्ण सामंजस्य में फलते-फूलते हैं।
            इसी पावन, समृद्ध और विद्वानों से भरी भूमि को ही भगवान श्री राम ने अपने पवित्र अवतार के लिए सबसे उपयुक्त स्थान के रूप में चुना।
            ॥ पंचम सर्ग सम्पूर्ण हुआ। जय श्री राम ॥
        """.trimIndent(),
        englishCommentary = """
            That divine city was magnificently adorned (Upashobhitam) by the presence of great, ascetic Brahmins who had come to reside there from various different countries.
            All these Brahmins were fully accomplished in the deep study of the Vedas, were endowed with stellar virtues (Gunavadbhih), and were razor-sharp scholars (Vipashcidbhih).
            'Nanadeshanivasibhih' proves that Ayodhya was not merely a political capital, but functioned as the world's largest global epicenter for knowledge and spiritual research.
            Learned Brahmins from distant lands permanently migrated here to further refine their profound wisdom and to seek the highly respectful patronage of King Dasharatha.
            The skies of Ayodhya remained perpetually resonant and sanctified round the clock by the powerful, melodic chanting of mantras by these elite Vedic scholars.
            Being 'Vipashcit' implies they were not just rote-learners, but visionary philosophers who deeply understood the essence of the Vedas and provided true direction to society.
            This massive congregation of global intellectuals elevates the intellectual and spiritual majesty of Ayodhya to the absolute, unconquerable zenith of that ancient era.
            Thus, the highly dignified 'Fifth Sarga' of the Baal Kand in the Valmiki Ramayana, titled 'The Description of Ayodhya City,' reaches its glorious completion here.
            This chapter teaches us that an ideal nation is one where wealth, military might, art, supreme hygiene, and Vedic wisdom flourish together in perfect, flawless harmony.
            It was precisely this sacred, overwhelmingly prosperous, and scholar-filled land that Lord Sri Rama chose as the most fitting and perfect stage for His divine incarnation.
            || Thus ends the Fifth Sarga. Jai Shri Ram ||
        """.trimIndent()
    )
)