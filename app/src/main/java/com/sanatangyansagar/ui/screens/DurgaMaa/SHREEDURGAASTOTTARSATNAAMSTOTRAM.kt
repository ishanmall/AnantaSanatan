package com.sanatangyansagar.ui.screens.DurgaMaa

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// 1. Data Model
data class DurgaNameShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SHREEDURGAASTOTTARSATNAAMSTOTRAMScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 20 (standard grouping of 108 names)
                if (shlokaNumber != null && shlokaNumber in 1..20) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Verse Number (1-20)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        // Shloka List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(durga108NamesList) { _, shloka ->
                DurgaNameCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun DurgaNameCard(shloka: DurgaNameShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Verse ${shloka.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFD84315)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = shloka.sanskrit,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 22.sp)
        }
    }
}

// 4. Data List
val durga108NamesList: List<DurgaNameShloka> = listOf(
    DurgaNameShloka(
        id = 1,
        sanskrit = "ईश्वर उवाच -\nशतनाम प्रवक्ष्यामि शृणुष्व कमलानने । यस्य प्रसादमात्रेण दुर्गा प्रीता भवेत् सती ॥ १ ॥",
        hindi = """
            भगवान शिव ने माता पार्वती (कमलानने) से कहा: हे कमले! मैं तुम्हें उन सौ नामों (अष्टोत्तर शतनाम) का उपदेश देता हूँ,
            जिनके केवल पाठ मात्र से भगवती दुर्गा प्रसन्न हो जाती हैं। यह मन्त्रों का वह समूह है जो साधक के जीवन के सभी संकटों को हर लेता है।
            ये नाम केवल शब्द नहीं, बल्कि साक्षात् दिव्य शक्तियाँ हैं जो माँ की कृपा को आकर्षित करती हैं।
            साधक को इन नामों का श्रवण और पठन पूरी एकाग्रता और श्रद्धा के साथ करना चाहिए।
            माँ दुर्गा की प्रसन्नता ही इस संसार में अभय और मोक्ष प्राप्त करने का सबसे सुगम मार्ग है।
            यह श्लोक स्तोत्र की महिमा और इसकी फलश्रुति का परिचय देता है।
        """.trimIndent(),
        english = """
            Lord Shiva said: O Lotus-faced one! I shall now reveal the 108 names of Goddess Durga.
            By the mere grace of reciting these names, the Goddess becomes immensely pleased with the devotee.
            These names are not mere words but are potent vibrations that invoke divine protection.
            A seeker must listen to and chant these with absolute focus and unwavering faith.
            Gaining the Mother's favor is the simplest path to achieving fearlessness and liberation in this world.
            This introductory verse highlights the profound merit and efficacy of this sacred hymn.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 2,
        sanskrit = "सती साध्वी भवप्रीता भवानी भवमोचनी । आर्या दुर्गा जया चाद्या त्रिनेत्रा शूलधारिणी ॥ २ ॥",
        hindi = """
            माँ के ये प्रथम नाम उनकी मौलिक प्रकृतियों को दर्शाते हैं:
            सती (अग्नि में भस्म होने वाली), साध्वी (परम पवित्र), भवप्रीता (संसार द्वारा पूजित), भवानी (शिव की शक्ति) और भवमोचनी (संसार के बंधनों से मुक्त करने वाली)।
            आर्या (महान), दुर्गा (अजेय), जया (विजयी), आद्या (आदि-शक्ति), त्रिनेत्रा (तीन आँखों वाली) और शूलधारिणी (त्रिशूल धारण करने वाली)।
            भवमोचनी नाम यह आश्वासन देता है कि माँ हमें जन्म-मरण के चक्र से बाहर निकाल सकती हैं।
            त्रिनेत्रा का अर्थ है वह जो भूत, वर्तमान और भविष्य तीनों को एक साथ देखने की क्षमता रखती हैं।
            माँ का यह योद्धा स्वरूप दुष्टों का संहार और भक्तों की रक्षा करने के लिए सदैव तत्पर है।
        """.trimIndent(),
        english = """
            These initial names of the Mother reveal Her fundamental cosmic nature:
            Sati (The chaste), Sadhvi (The virtuous), Bhavaprita (Loved by the universe), Bhavani (The source of existence), and Bhavamochani (The liberator from worldly bonds).
            Arya (The noble), Durga (The invincible), Jaya (The victorious), Aadya (The primordial energy), Trinetra (Three-eyed), and Shuladharini (Wielder of the trident).
            The name 'Bhavamochani' assures that She can free us from the cycle of birth and death.
            'Trinetra' signifies Her ability to see past, present, and future simultaneously.
            This warrior aspect of the Mother is eternally ready to destroy evil and protect Her children.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 3,
        sanskrit = "पिनाकधारिणी चित्रा चण्डघण्टा महातपाः । मनो बुद्धि्राहंकारा चित्तरूपा चिता चितिः ॥ ३ ॥",
        hindi = """
            पिनाकधारिणी (शिव का धनुष धारण करने वाली), चित्रा (अद्भुत सौंदर्य वाली), चण्डघण्टा (प्रचण्ड ध्वनि वाली) और महातपाः (घोर तपस्या करने वाली)।
            माँ हमारे सूक्ष्म शरीर की चार परतों के रूप में भी स्थित हैं: मन, बुद्धि, अहंकार और चित्त।
            चिता (चेतना की अग्नि) और चितिः (शुद्ध संविद्) भी उन्हीं के स्वरूप हैं।
            यह श्लोक बताता है कि माँ केवल बाहर नहीं, बल्कि हमारे मनोवैज्ञानिक और बौद्धिक कार्यों के पीछे की असली संचालक हैं।
            जब हम माँ को बुद्धि के रूप में पूजते हैं, तो हमारे निर्णय सत्य और धर्म के करीब हो जाते हैं।
            माँ का 'चित्तरूपा' होना यह सिद्ध करता है कि हमारी हर स्मृति और विचार उन्हीं की ऊर्जा से प्रकाशित है।
        """.trimIndent(),
        english = """
            Pinakadharini (Wielder of Shiva's bow), Chitra (The picturesque/beautiful), Chandaghanta (Possessing fierce bells), and Mahatapa (One who practiced great penance).
            She resides as the four pillars of our subtle being: Manas (Mind), Buddhi (Intellect), Ahankara (Ego), and Chitta (Memory/Subconscious).
            Chita (The sacrificial fire of consciousness) and Chiti (The power of understanding) are also Her forms.
            This verse reveals that the Mother is the inner driver behind our psychological and cognitive functions.
            Worshiping Her as 'Intellect' aligns our decisions with Truth and righteousness.
            Her being 'Chittarupa' proves that every memory and thought is illuminated by Her divine energy.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 4,
        sanskrit = "सर्वमन्त्रमयी सत्ता सत्यानन्दस्वरूपिणी । अनन्ता भाविनी भाव्या भव्याभव्या सदागतिः ॥ ४ ॥",
        hindi = """
            माँ 'सर्वमन्त्रमयी' हैं, यानी संसार के सभी मन्त्रों की शक्ति उन्हीं में समाहित है।
            वे 'सत्यानन्दस्वरूपिणी' हैं—सत्य और आनंद का साक्षात् विग्रह।
            अनन्ता (असीम), भाविनी (भावनाओं में वास करने वाली), भाव्या (ध्यान करने योग्य) और भव्या (दिव्य/सुन्दर)।
            अभव्या (अगम्य/रहस्यमयी) और सदागतिः (जो हमेशा गतिमान और कल्याणकारी मार्ग पर रहती हैं)।
            सत्य और आनंद माँ के दो ऐसे गुण हैं जो साधक को संसार के दुखों से पूरी तरह ऊपर उठा देते हैं।
            जब हम मन्त्र जपते हैं, तो हम वास्तव में माँ की उस 'मन्त्रमयी' सत्ता से जुड़ने का प्रयास करते हैं।
        """.trimIndent(),
        english = """
            The Mother is 'Sarvamantramayi', meaning the power of all universal mantras resides within Her.
            She is 'Satyanandasvarupini'—the direct embodiment of Absolute Truth and Bliss.
            Ananta (The infinite), Bhavini (Resident of emotions), Bhavya (Worthy of meditation), and Bhavya (The magnificent).
            Abhavya (The mysterious/beyond reach) and Sadagati (The eternal path of liberation).
            Truth and Bliss are two attributes of the Mother that lift the seeker completely above worldly miseries.
            When we chant mantras, we are actually attempting to connect with Her 'Mantramayi' presence.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 5,
        sanskrit = "शाम्भवी देवमाता च चिन्ता रत्नप्रिया सदा । सर्वविद्या दक्षकन्या दक्षयज्ञविनाशिनी ॥ ५ ॥",
        hindi = """
            शाम्भवी (शिव की प्रिय), देवमाता (देवताओं की जननी), चिन्ता (चिंतन/चिंता को हरने वाली) और रत्नप्रिया (रत्नों से प्रेम करने वाली)।
            वे 'सर्वविद्या' हैं—अर्थात ब्रह्मांड का समस्त ज्ञान और कला उन्हीं का स्वरूप है।
            दक्षकन्या (दक्ष की पुत्री सती) और दक्षयज्ञविनाशिनी (दक्ष के अभिमानी यज्ञ का विनाश करने वाली)।
            यह श्लोक माँ के उस स्वरूप को दर्शाता है जो अहंकार और अधर्म का नाश करने के लिए अत्यंत उग्र हो सकता है।
            'सर्वविद्या' होने के कारण वे ही छात्रों और ज्ञानियों की परम आराध्य हैं।
            दक्ष के यज्ञ का विनाश यह सिखाता है कि बिना भक्ति और शिव के, कोई भी कर्म सफल नहीं हो सकता।
        """.trimIndent(),
        english = """
            Shambhavi (Beloved of Shambhu), Devamata (Mother of the gods), Chinta (Contemplation/remover of worry), and Ratnapriya (Fond of jewels).
            She is 'Sarvavidya'—the totality of all arts, sciences, and cosmic knowledge.
            Dakshakanya (The daughter of Daksha/Sati) and Dakshayajnavinashini (Destroyer of Daksha's arrogant sacrifice).
            This verse portrays the Mother's fierce aspect that can become terrifying to annihilate ego and unrighteousness.
            Being 'Sarvavidya', She is the supreme object of worship for students and seekers of wisdom.
            The destruction of Daksha's Yajna teaches that no action can succeed without devotion and the presence of Shiva.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 6,
        sanskrit = "अपर्णानेकवर्णा च पाटला पाटलावती । पट्टाम्बरपरीधाना कलमञ्जीररञ्जिनी ॥ ६ ॥",
        hindi = """
            अपर्णा (तपस्या में पत्तों का भी त्याग करने वाली), अनेकवर्णा (अनेक रूपों और रंगों वाली) और पाटला (लाल रंग वाली)।
            पाटलावती (गुलाब के फूलों से युक्त), पट्टाम्बरपरीधाना (रेशमी वस्त्र धारण करने वाली) और कलमञ्जीररञ्जिनी (मधुर पायलों की ध्वनि वाली)।
            'अपर्णा' नाम माँ की उस घोर तपस्या की याद दिलाता है जो उन्होंने भगवान शिव को पाने के लिए की थी।
            माँ का सौंदर्य कोमल भी है और उनका श्रृंगार दिव्य भी, जो भक्त के मन को शांति देता है।
            मधुर पायलों की ध्वनि का अर्थ है वह ब्रह्मांडीय नाद (Sound) जो ध्यान में योगी को सुनाई देता है।
            यह श्लोक माँ के अत्यंत सुंदर, सौम्य और तपस्वी स्वरूप का चित्रण करता है।
        """.trimIndent(),
        english = """
            Aparna (One who gave up even eating leaves during penance), Anekavarna (Possessing many colors/forms), and Patala (Red-hued).
            Patalavati (Adorned with roses), Pattambaraparidhana (Clothed in silk garments), and Kalamanjiraranjini (Delighting in the sound of sweet anklets).
            The name 'Aparna' reminds us of Her extreme austerity performed to attain Lord Shiva.
            The Mother's beauty is both gentle and divine, offering immense peace to the devotee's restless mind.
            The sound of the sweet anklets symbolizes the primordial cosmic sound (Nada) heard by yogis in deep meditation.
            This verse paints a picture of Her supremely beautiful, serene, and ascetic forms.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 7,
        sanskrit = "अमेयविक्रमा क्रूरा सुन्दरी सुरसुन्दरी । वनदुर्गा महाकाली मातङ्गी मुनिपूजिता ॥ ७ ॥",
        hindi = """
            अमेयविक्रमा (असीम पराक्रम वाली), क्रूरा (शत्रुओं के लिए कठोर), सुन्दरी (परम सुंदर) और सुरसुन्दरी (देवताओं की सुन्दरी)।
            वनदुर्गा (वनों की अधिष्ठात्री), महाकाली (काल का संहार करने वाली) और मातङ्गी (दस महाविद्याओं में से एक)।
            माँ ऋषियों और मुनियों द्वारा हमेशा पूजी जाती हैं (मुनिपूजिता), क्योंकि वे ही शांति का आधार हैं।
            माँ का पराक्रम 'अमेय' है, जिसका अर्थ है कि उसे किसी भी सांसारिक पैमाने से मापा नहीं जा सकता।
            वे जहाँ भक्तों के लिए 'सुन्दरी' हैं, वहीं धर्म के शत्रुओं के लिए 'क्रूरा' (भयानक) बन जाती हैं।
            यह श्लोक माँ की व्यापकता को प्रकृति (वन) से लेकर परम संहार (महाकाली) तक विस्तारित करता है।
        """.trimIndent(),
        english = """
            Ameyavikrama (Of boundless prowess), Krura (Fierce toward the wicked), Sundari (Exquisitely beautiful), and Surasundari (The beauty of the gods).
            Vanadurga (The Durga of the forests), Mahakali (The great destroyer of time), and Matangi (One of the ten Mahavidyas).
            She is eternally worshiped by sages and seers (Munipujita) as the foundation of inner peace.
            Her prowess is 'Ameya', meaning it cannot be measured by any worldly or physical standard.
            While She is 'Sundari' for Her devotees, She becomes 'Krura' (fierce) for the enemies of righteousness.
            This verse expands the Mother's presence from nature (Forests) to the ultimate cosmic destruction (Mahakali).
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 8,
        sanskrit = "ब्राह्मी माहेश्वरी चैन्द्री कौमारी वैष्णवी तथा । चामुण्डा चैव वाराही लक्ष्मीश्च पुरुषाकृतिः ॥ ८ ॥",
        hindi = """
            माँ 'सप्तमातृका' के रूपों में ब्रह्मांड का संचालन करती हैं: ब्राह्मी (ब्रह्मा की शक्ति), माहेश्वरी (शिव की शक्ति) और ऐन्द्री (इन्द्र की शक्ति)।
            कौमारी (कार्तिकेय की शक्ति), वैष्णवी (विष्णु की शक्ति), चामुण्डा (असुरों का वध करने वाली) और वाराही (वराह की शक्ति)।
            लक्ष्मी (समृद्धि) और पुरुषाकृतिः (विराट पुरुष के समान आकार वाली)।
            ये नाम यह सिद्ध करते हैं कि संसार की सभी दिव्य पुरुष-शक्तियों के पीछे की असली ऊर्जा माँ दुर्गा ही हैं।
            माँ का 'पुरुषाकृति' होना अद्वैत का प्रतीक है—जहाँ स्त्री और पुरुष तत्व एक ही चेतना में मिल जाते हैं।
            इन शक्तियों का ध्यान करने से साधक को हर दिशा और हर आयाम से सुरक्षा प्राप्त होती है।
        """.trimIndent(),
        english = """
            The Mother operates the cosmos as the Sapta-Matrikas: Brahmi (Power of Brahma), Maheshwari (Power of Shiva), and Aindri (Power of Indra).
            Kaumari (Power of Kartikeya), Vaishnavi (Power of Vishnu), Chamunda (Slayer of demons), and Varahi (Power of Varaha).
            Lakshmi (Prosperity) and Purushakriti (Having the form of the Primordial Man/Universe).
            These names prove that Mother Durga is the actual energy behind all divine masculine powers in the universe.
            Her being 'Purushakriti' is a symbol of non-duality—where masculine and feminine principles merge into one consciousness.
            Meditating on these powers grants the seeker total protection from every direction and dimension.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 9,
        sanskrit = "विमलोत्कर्षिणी ज्ञाना क्रिया नित्या च बुद्धिदा । बहुला बहुलप्रेमा सर्ववाहनवाहना ॥ ९ ॥",
        hindi = """
            विमलोत्कर्षिणी (पवित्रता और उन्नति देने वाली), ज्ञाना (ज्ञान स्वरूप), क्रिया (कर्म की शक्ति) और नित्या (शाश्वत)।
            बुद्धिदा (बुद्धि प्रदान करने वाली), बहुला (अनेक रूपों वाली) और बहुलप्रेमा (अगाध प्रेम करने वाली माँ)।
            वे 'सर्ववाहनवाहना' हैं—अर्थात वे सभी वाहनों (शक्तियों) पर सवारी करने में समर्थ और स्वतंत्र हैं।
            माँ न केवल ज्ञान देती हैं, बल्कि उस ज्ञान को जीवन में उतारने के लिए 'क्रिया' (एक्शन) की शक्ति भी देती हैं।
            'बहुलप्रेमा' होने के कारण वे अपने भक्तों के हजारों अपराधों को एक क्षण में माफ कर देती हैं।
            यह श्लोक माँ की दयालुता और उनके गतिशील (Dynamic) गुणों का बहुत सुंदर वर्णन करता है।
        """.trimIndent(),
        english = """
            Vimalotkarshini (Bestower of purity and elevation), Gyana (Wisdom itself), Kriya (The power of action), and Nitya (Eternal).
            Buddhida (Giver of intellect), Bahula (Many-formed), and Bahulaprema (The Mother of boundless love).
            She is 'Sarvavahanavahana'—capable and independent, riding upon all possible vehicles (cosmic forces).
            The Mother not only grants wisdom but also the power of 'Kriya' (Action) to implement that wisdom in life.
            Being 'Bahulaprema', She forgives thousands of offenses committed by Her children in a single moment.
            This verse provides a beautiful description of Her compassionate nature and Her dynamic cosmic attributes.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 10,
        sanskrit = "निशुम्भशुम्भहननी महिषासुरमर्दिनी । मधु-कैटभहन्त्री च चण्डमुण्डविनाशिनी ॥ १० ॥",
        hindi = """
            निशुम्भ और शुम्भ का वध करने वाली, महिषासुर का मर्दन करने वाली।
            मधु और कैटभ का विनाश करने वाली तथा चण्ड और मुण्ड को समाप्त करने वाली।
            ये असुर हमारे भीतर के 'मैं' (अहंकार), 'मेरा' (ममता), क्रोध और वासना के प्रतीक हैं।
            जब हम माँ का ये नाम लेते हैं, तो हमारे मन की नकारात्मक प्रवृत्तियाँ कमजोर होने लगती हैं।
            माँ का संहारक रूप वास्तव में हमारे आध्यात्मिक शत्रुओं को मिटाकर हमें शुद्ध बनाता है।
            यह श्लोक माँ को बुराई के विरुद्ध सबसे बड़ी और अजेय शक्ति के रूप में स्थापित करता है।
        """.trimIndent(),
        english = """
            The slayer of Nishumbha and Shumbha, the crusher of the demon Mahishasura.
            The annihilator of Madhu and Kaitabha, and the absolute destroyer of Chanda and Munda.
            These demons represent our inner ego (I-ness), attachment (My-ness), anger, and deep-seated lusts.
            Chanting these names weakens the negative tendencies within our own subconscious mind.
            The Mother's destructive form actually purifies us by eliminating our spiritual enemies.
            This verse establishes the Mother as the ultimate and invincible force against all forms of evil.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 11,
        sanskrit = "सर्वासुरविनाशा च सर्वदानवघातिनी । सर्वशास्त्रमयी सत्या सर्वास्त्रधारिणी तथा ॥ ११ ॥",
        hindi = """
            माँ सभी असुरों और दानवों का पूरी तरह नाश करने वाली महाशक्ति हैं।
            वे 'सर्वशास्त्रमयी' हैं—समस्त शास्त्रों का ज्ञान उन्हीं का विस्तार है।
            वे 'सत्या' (परम सत्य) हैं और 'सर्वास्त्रधारिणी' (सभी दिव्य अस्त्रों को धारण करने वाली) हैं।
            अस्त्र और शास्त्र (Power and Wisdom) का यह संतुलन माँ दुर्गा का सबसे बड़ा गुण है।
            माँ हमें केवल लड़ने की शक्ति नहीं देतीं, बल्कि उसे सही दिशा में प्रयोग करने का ज्ञान (शास्त्र) भी देती हैं।
            परम सत्य (सत्या) होने के कारण वे ही इस परिवर्तनशील संसार का इकलौता स्थिर आधार हैं।
        """.trimIndent(),
        english = """
            The Mother is the supreme force that completely wipes out all demonic and negative entities.
            She is 'Sarvashastramayi'—the entire knowledge of the scriptures is but an expansion of Her.
            She is 'Satya' (The Absolute Truth) and 'Sarvastradharini' (Wielder of all divine celestial weapons).
            This balance of Astra (Power) and Shastra (Wisdom) is the greatest attribute of Mother Durga.
            She grants not just the power to fight, but the wisdom (scriptures) to direct that power correctly.
            Being the Absolute Truth (Satya), She remains the only constant foundation in this ever-changing world.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 12,
        sanskrit = "अनेकशस्त्रहस्ता च अनेकास्त्रस्य धारिणी । कुमारी चैककन्या च कैशोरी युवती यतिः ॥ १२ ॥",
        hindi = """
            माँ के अनेक हाथों में अनेक प्रकार के दिव्य शस्त्र और अस्त्र सुशोभित हैं।
            वे कुमारी (मासूम), एककन्या (अद्वितीय कन्या), कैशोरी (किशोरी) और युवती (युवा) के रूपों में प्रकट हैं।
            वे 'यति' (तपस्वी/सन्यासिनी) भी हैं, जो संसार से विरक्त होकर अपनी आत्मा में स्थित हैं।
            ये नाम दिखाते हैं कि माँ जन्म से लेकर तपस्या तक के हर पड़ाव की अधिष्ठात्री हैं।
            'यति' होना यह संकेत देता है कि शक्ति का असली स्रोत इंद्रिय-संयम और आंतरिक तप है।
            माँ का यह रूप साधक को अपनी उम्र के हर दौर में पवित्र रहने की प्रेरणा देता है।
        """.trimIndent(),
        english = """
            Manifold weapons and celestial arms gracefully adorn the numerous hands of the Mother.
            She manifests as Kumari (Innocent child), Ekakanya (The unique maiden), Kaishori (Adolescent), and Yuvati (The youth).
            She is also 'Yati' (The ascetic/renunciant), detached from the world and steady in Her own soul.
            These names show that the Mother presides over every stage of life, from childhood to asceticism.
            Being a 'Yati' suggests that the true source of power is sense-control and internal austerity.
            This aspect of the Mother inspires the seeker to remain pure through every phase of their human existence.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 13,
        sanskrit = "अप्रौढा चैव प्रौढा च वृद्धमाता बलप्रदा । महोदरी मुक्तकेशी घोररूपा महाबला ॥ १३ ॥",
        hindi = """
            माँ अप्रौढा (बालिका), प्रौढा (परिपक्व स्त्री) और वृद्धमाता (वृद्ध माँ) के रूपों में भी जीवन का आधार हैं।
            वे 'बलप्रदा' हैं—अर्थात शारीरिक और मानसिक बल देने वाली इकलौती सत्ता।
            महोदरी (विशाल उदर वाली—जिसमें ब्रह्मांड समाया है), मुक्तकेशी (खुले बालों वाली) और घोररूपा (भयानक रूप वाली)।
            वे 'महाबला' हैं, जिनके बल के सामने संसार की कोई भी सैन्य शक्ति टिक नहीं सकती।
            'वृद्धमाता' का रूप हमें यह सिखाता है कि अनुभव और बुढ़ापे में भी वही एक शक्ति कार्य करती है।
            मुक्तकेशी रूप यह दर्शाता है कि वे सामाजिक बंधनों से मुक्त और पूर्ण रूप से स्वतंत्र हैं।
        """.trimIndent(),
        english = """
            The Mother is the basis of life as Apraudha (Girl), Praudha (Mature woman), and Vriddhamata (Elderly Mother).
            She is 'Balaprada'—the sole entity capable of bestowing physical, mental, and spiritual strength.
            Mahodari (Large-bellied—containing the universe), Muktakeshi (Loose-haired), and Ghorarupa (Of terrifying form).
            She is 'Mahabala', before whose might no military or cosmic force in the world can survive.
            The form of 'Vriddhamata' teaches us that the same divine power operates even in old age and experience.
            The 'Muktakeshi' form signifies that She is free from social shackles and is completely independent.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 14,
        sanskrit = "अग्निज्वाला रौद्रमुखी कालरात्रिस्तपस्विनी । नारायणी भद्रकाली विष्णुमाया जलोदरी ॥ १४ ॥",
        hindi = """
            अग्निज्वाला (आग की लपटों जैसी), रौद्रमुखी (भयानक मुख वाली) और कालरात्रि (समय की रात्रि)।
            तपस्विनी (तप करने वाली), नारायणी (विष्णु की शक्ति), भद्रकाली (कल्याणकारी काली) और विष्णुमाया।
            जलोदरी (जल में निवास करने वाली—या ब्रह्मांडीय गर्भ)।
            माँ 'नारायणी' के रूप में जगत का पालन करती हैं और 'विष्णुमाया' के रूप में इस संसार का भ्रम बनाए रखती हैं।
            अग्नि की ज्वाला के समान वे हमारे पापों और अशुद्धियों को जलाकर भस्म कर देती हैं।
            यह श्लोक माँ के उग्र और सुरक्षात्मक गुणों को एक साथ बहुत ही खूबसूरती से जोड़ता है।
        """.trimIndent(),
        english = """
            Agnijvala (Luminous like fire), Raudramukhi (Fierce-faced), and Kalaratri (The dark night of time).
            Tapasvini (The ascetic), Narayani (The power of Narayana), Bhadrakali (The auspicious Kali), and Vishnumaya.
            Jalodari (Abiding in the waters—the cosmic womb).
            As 'Narayani', She sustains the world, and as 'Vishnumaya', She maintains the beautiful illusion of existence.
            Like a blazing fire, She incinerates our sins and mental impurities into absolute ashes.
            This verse beautifully links Her fierce attributes with Her protective and sustaining cosmic functions.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 15,
        sanskrit = "शिवदूती कराली च अनन्ता परमेश्वरी । कात्यायनी च सावित्री प्रत्यक्षा ब्रह्मवादिनी ॥ १५ ॥",
        hindi = """
            शिवदूती (शिव को दूत बनाने वाली), कराली (भयानक) और अनन्ता (जिसका कोई अंत नहीं)।
            परमेश्वरी (सर्वोच्च ईश्वरी), कात्यायनी (महिषासुर घातिनी) और सावित्री (प्रकाश देने वाली)।
            वे 'प्रत्यक्षा' (जो साक्षात् अनुभव में आती हैं) और 'ब्रह्मवादिनी' (ब्रह्म का ज्ञान देने वाली) हैं।
            'प्रत्यक्षा' होना यह सिद्ध करता है कि माँ कोई कल्पना नहीं, बल्कि एक जीवंत और अनुभव करने योग्य सत्य हैं।
            ब्रह्मवादिनी के रूप में वे साधक को वेदों के सबसे गहरे और गुप्त रहस्यों का ज्ञान कराती हैं।
            माँ का 'शिवदूती' रूप उनकी उस शक्ति को दिखाता है जिसके आगे स्वयं महादेव भी नतमस्तक होते हैं।
        """.trimIndent(),
        english = """
            Shivaduti (Who sent Shiva as Her messenger), Karali (The terrifying), and Ananta (The endless).
            Parameshwari (The Supreme Goddess), Katyayani (The slayer of Mahishasura), and Savitri (The illuminator).
            She is 'Pratyaksha' (The perceptible/direct experience) and 'Brahmavadini' (One who speaks of/teaches the Brahman).
            Being 'Pratyaksha' proves that the Mother is not a mere imagination but a living, experienceable reality.
            As Brahmavadini, She reveals the deepest and most secret mysteries of the Vedas to the sincere seeker.
            The 'Shivaduti' form showcases Her supreme power, to which even Lord Mahadeva bows in reverence.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 16,
        sanskrit = "य इदं प्रपठेन्नित्यं दुर्गानामशताष्टकम् । नासाध्यं विद्यते किञ्चित् त्रिषु लोकेषु पार्वति ॥ १६ ॥",
        hindi = """
            (फलश्रुति): जो मनुष्य नित्य माँ दुर्गा के इन १०८ नामों का पाठ करता है,
            उसके लिए तीनों लोकों में कुछ भी 'असाध्य' (असंभव) नहीं रह जाता है।
            भगवान शिव कहते हैं कि यह पाठ करने वाला व्यक्ति हर लक्ष्य को प्राप्त करने में समर्थ हो जाता है।
            इच्छाशक्ति और आत्मविश्वास बढ़ाने के लिए यह स्तोत्र एक अचूक आध्यात्मिक औषधि है।
            जब माँ के १०८ नाम हमारे मन में गूँजते हैं, तो असफलता का हर विचार अपने आप मिट जाता है।
            यह श्लोक साधक को निरंतर पाठ करने के लिए गहरा प्रोत्साहन और भरोसा प्रदान करता है।
        """.trimIndent(),
        english = """
            (Result of Chanting): The person who daily recites these 108 names of Mother Durga,
            Finds that absolutely nothing remains 'Asadhya' (impossible) for him in all the three worlds.
            Lord Shiva declares that the practitioner of this hymn becomes capable of achieving any noble goal.
            This stotram acts as an infallible spiritual remedy for increasing willpower and self-confidence.
            When these 108 names resonate in the mind, every thought of failure is spontaneously erased.
            This verse provides deep encouragement and assurance to the seeker to continue the daily practice.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 17,
        sanskrit = "धनं धान्यं सुतं जायां हयं हस्तिनमेव च । चतुर्वर्गं तथा चान्ते लभेन्मुक्तिं च शाश्वतीम् ॥ १७ ॥",
        hindi = """
            पाठ करने वाले को धन, धान्य, सुपुत्र और उत्तम जीवनसाथी (जायां) की प्राप्ति होती है।
            उसे हाथी, घोड़े (यानी आधुनिक समय में वाहन और संपत्ति) और जीवन के चारों वर्ग (धर्म, अर्थ, काम, मोक्ष) मिलते हैं।
            और अंत में वह उस 'शाश्वत मुक्ति' (मोक्ष) को प्राप्त करता है जहाँ से फिर लौटना नहीं पड़ता।
            यह स्तोत्र साधक की भौतिक और आध्यात्मिक—दोनों प्रकार की जरूरतों को पूर्ण करता है।
            माँ केवल मोक्ष ही नहीं देतीं, वे हमारे गृहस्थ जीवन को भी सुख-समृद्धि से परिपूर्ण बना देती हैं।
            शाश्वत मुक्ति का अर्थ है अपनी आत्मा की शांति में हमेशा के लिए स्थित हो जाना।
        """.trimIndent(),
        english = """
            The reciter attains wealth, abundant food, virtuous children, and an excellent life partner.
            He receives vehicles, property, and the four goals of life: Dharma, Artha, Kama, and Moksha.
            And ultimately, he attains that 'Eternal Liberation' (Moksha) from which there is no return to suffering.
            This stotram fulfills both the material and the spiritual necessities of the dedicated practitioner.
            The Mother does not just grant liberation; She makes one's household life prosperous and joyful.
            Eternal liberation signifies being permanently established in the supreme peace of one's own soul.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 18,
        sanskrit = "कुमारीं पूजयित्वा तु ध्यात्वा देवीं सुरेश्र्वरीम् । पूजयेत् परया भक्त्या पठेन्नामशताष्टकम् ॥ १८ ॥",
        hindi = """
            साधक को चाहिए कि वह छोटी कन्याओं (कुमारी) की पूजा करे और उन में साक्षात् 'सुरेश्वरी' का ध्यान करे।
            पूरी भक्ति और श्रद्धा के साथ माँ का पूजन करने के बाद इन १०८ नामों का पाठ करना चाहिए।
            कन्या पूजन माँ दुर्गा की साक्षात् कृपा पाने का सबसे सरल और प्रभावशाली मार्ग माना गया है।
            यह हमारे मन में मासूमियत और स्त्री शक्ति के प्रति सम्मान का भाव जाग्रत करता है।
            विधिपूर्वक किया गया यह पाठ हृदय को शुद्ध कर माँ के साथ एक गहरा संबंध स्थापित करता है।
            बिना भक्ति (परया भक्त्या) के किया गया पाठ केवल शब्दों का खेल है; भाव ही असली शक्ति है।
        """.trimIndent(),
        english = """
            The seeker should worship young maidens (Kumari) and meditate upon them as the direct forms of the Goddess.
            After performing the worship with supreme devotion, one should proceed to recite these 108 names.
            Kumari-Puja is considered the simplest and most effective way to attract the Mother's immediate grace.
            It awakens a sense of innocence and deep respect for the feminine principle in the practitioner's heart.
            Reciting with the proper ritual purifies the heart and establishes a profound connection with the Mother.
            Chanting without devotion (Paraya Bhaktya) is mere lip service; pure intent is the real source of power.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 19,
        sanskrit = "तस्य सिद्धिर्भवेद् देवि सर्वैः सुरवरैरपि । राजानो दासतां यान्ति राज्यश्रियमवाप्नुयात् ॥ १९ ॥",
        hindi = """
            हे देवी! ऐसे साधक को बड़े-बड़े देवता भी अपनी सिद्धियाँ प्रदान करने के लिए विवश हो जाते हैं।
            राजा और शक्तिशाली लोग उसके अनुकूल (दासता) हो जाते हैं, और उसे अपार राज्य-लक्ष्मी प्राप्त होती है।
            इसका अर्थ है कि समाज में साधक का प्रभाव बढ़ता है और लोग उसकी सलाह का सम्मान करते हैं।
            जब ईश्वर हमारे साथ होता है, तो संसार की कोई भी ताकत हमारे मार्ग में बाधा नहीं बन सकती।
            राज्यश्री का अर्थ केवल सत्ता नहीं, बल्कि वह प्रभाव है जो समाज में सकारात्मक बदलाव ला सके।
            यह श्लोक माँ की भक्ति से मिलने वाले सामाजिक और भौतिक प्रभुत्व का वर्णन करता है।
        """.trimIndent(),
        english = """
            O Goddess! Even the great deities feel compelled to grant their perfections (Siddhis) to such a seeker.
            Kings and powerful authorities become favorable to him, and he attains immense sovereignty and wealth.
            This implies that the seeker's influence in society grows, and people respect his wisdom and counsel.
            When God is with us, no power in the world can successfully create an obstacle in our righteous path.
            'Rajyashri' means not just political power, but the influence required to bring positive changes to society.
            This verse describes the social and material dominance one achieves through absolute devotion to the Mother.
        """.trimIndent()
    ),
    DurgaNameShloka(
        id = 20,
        sanskrit = "गोरोचनालक्तककुङ्कुमेन सिन्दूरकर्पूरमधुत्रयेण । विलिख्य यन्त्रं विधिना विधिज्ञो भवेत् सदा धारयते पुरारिः ॥ २० ॥\nइति श्रीदुर्गाष्टोत्तरशतनामस्तोत्रं सम्पूर्णम् ॥",
        hindi = """
            गोरोचन, लाक्षा, कुंकुम, सिन्दूर, कपूर, घी, शर्करा और मधु—इन पवित्र द्रव्यों से भोजपत्र पर यन्त्र लिखकर।
            जो विधि का ज्ञाता मनुष्य इसे विधिपूर्वक धारण करता है, वह साक्षात् भगवान शिव (पुरारि) के समान अजेय हो जाता है।
            यह श्लोक यन्त्र विज्ञान की शक्ति और माँ की सुरक्षा के भौतिक माध्यम (Talisman) को दर्शाता है।
            यन्त्र का धारण करना माँ की शक्ति को हर पल अपने शरीर के करीब रखने का एक तरीका है।
            सच्चा 'विधिज्ञ' वह है जो नियमों के साथ-साथ हृदय के भावों को भी पवित्र रखता है।
            ॥ इस प्रकार भगवान शिव द्वारा प्रोक्त श्री दुर्गा अष्टोत्तर शतनाम स्तोत्र सम्पूर्ण हुआ ॥
        """.trimIndent(),
        english = """
            By writing the Yantra using sacred substances like Gorochan, Lac, Saffron, Vermilion, Camphor, and Honey.
            The knower of rituals who wears this Yantra as prescribed becomes invincible like Lord Shiva (Purari) Himself.
            This verse highlights the power of Yantra science and the physical medium (Talisman) of the Mother's protection.
            Wearing a Yantra is a way to keep the Mother's vibrant energy close to one's body at every moment.
            A true 'Vidhighna' is one who keeps his heart pure along with following the external rules of the ritual.
            || Thus concludes the Sri Durga Ashtottara Shatanama Stotram revealed by Lord Shiva ||
        """.trimIndent()
    )
)