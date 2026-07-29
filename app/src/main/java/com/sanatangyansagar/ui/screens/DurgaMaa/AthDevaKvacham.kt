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
data class KavachamShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AthDevaKvachamScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..56) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-56)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
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
            itemsIndexed(devaKavachamList) { _, shloka ->
                KavachamShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun KavachamShlokaCard(shloka: KavachamShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Shloka ${shloka.id}",
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

val devaKavachamList: List<KavachamShloka> = listOf(
    KavachamShloka(
        id = 1,
        sanskrit = "मार्कण्डेय उवाच ।\nयद्गुह्यं परमं लोके सर्वरक्षाकरं नृणाम् । यन्न कस्यचिदाख्यातं तन्मे ब्रूहि पितामह ॥ १ ॥",
        hindi = """
            मार्कण्डेय जी ने पूछा: हे पितामह! इस संसार में जो अत्यंत गोपनीय है,
            तथा मनुष्यों की सब प्रकार से रक्षा करने वाला है, उसे मुझे बताइये।
            यह ऐसा सत्य है जो अब तक आपने किसी को नहीं बताया।
            यह सुरक्षा कवच भय को मिटाने और विजय दिलाने वाला है।
            हे ब्रह्मा जी! कृपा कर मुझे वह दिव्य कवच सुनाइये।
        """.trimIndent(),
        english = """
            Sage Markandeya asked Lord Brahma about the most secret protection.
            He seeks the knowledge that shields humans from all possible dangers.
            This wisdom is described as being unparalleled and hidden from many.
            The prayer is to reveal the divine armor that secures the soul and body.
            It serves as the foundation for the entire Devi Saptashati path.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 2,
        sanskrit = "ब्रह्मोवाच ।\nअस्ति गुह्यतमं विप्र सर्वभूतपकारकम । देव्यास्तु कवचं पुण्यं तच्छृणुष्व महामुने ॥ २ ॥",
        hindi = """
            ब्रह्मा जी ने उत्तर दिया: हे विप्र! देवी का यह कवच अत्यंत गोपनीय है।
            यह सभी प्राणियों का भला करने वाला और महान पुण्य देने वाला है।
            यह कवच जादुई शक्ति के समान साधक के चारों ओर सुरक्षा घेरा बनाता है।
            इसे सुनने मात्र से ही हृदय में साहस और शांति का संचार होता है।
            सावधान होकर इस पवित्र कवच का श्रवण करो।
        """.trimIndent(),
        english = """
            Lord Brahma confirms the existence of this most profound secret.
            He describes the Devi Kavacham as beneficial for all living entities.
            It is a source of great spiritual merit and physical safety.
            The armor acts as a mystical shield against negative energies.
            Brahma invites the sage to listen with absolute focus and devotion.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 3,
        sanskrit = "प्रथमं शैलपुत्री च द्वितीयं ब्रह्मचारिणी । तृतीयं चन्द्रघण्टेति कूष्माण्डेति चतुर्थकम् ॥ ३ ॥",
        hindi = """
            पहली देवी 'शैलपुत्री' हैं, जो स्थिरता और अडिग संकल्प का प्रतीक हैं।
            दूसरी देवी 'ब्रह्मचारिणी' हैं, जो तपस्या और पवित्रता की शक्ति दिखाती हैं।
            तीसरी देवी 'चन्द्रघण्टा' हैं, जो अपने घण्टे की ध्वनि से शांति लाती हैं।
            चौथी देवी 'कूष्माण्डा' हैं, जिनकी मुस्कान से यह ब्रह्मांड उत्पन्न हुआ।
            ये नाम साधक की आध्यात्मिक यात्रा के शुरुआती चरणों को दर्शाते हैं।
        """.trimIndent(),
        english = """
            The first form is Shailaputri, representing stability and resolve.
            The second is Brahmacharini, the embodiment of penance and purity.
            The third is Chandraghanta, who removes all fears with a bell's ring.
            The fourth is Kushmanda, the creative energy of the entire cosmos.
            These names represent the initial stages of a seeker's spiritual growth.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 4,
        sanskrit = "पञ्चमं स्कन्दमातेति षष्ठं कात्यायनीति च । सप्तमं कालरात्रीति महागौरीति चाष्टमम् ॥ ४ ॥",
        hindi = """
            पाँचवीं देवी 'स्कन्दमाता' हैं, जो वात्सल्य और ममता की साक्षात् मूर्ति हैं।
            छठी देवी 'कात्यायनी' हैं, जो बुराई का संहार करने वाली योद्धा हैं।
            सातवीं देवी 'कालरात्रि' हैं, जो काल का भी अंत कर मोक्ष प्रदान करती हैं।
            आठवीं देवी 'महागौरी' हैं, जो शांति, करुणा और सुंदरता का आधार हैं।
            ये रूप माँ दुर्गा की ममता और संहारक शक्ति के अद्भुत संतुलन को बताते हैं।
        """.trimIndent(),
        english = """
            The fifth form is Skandamata, the motherly ocean of pure love.
            The sixth is Katyayani, the fierce warrior born to destroy demons.
            The seventh is Kalaratri, the terrifying night that ends all cycles.
            The eighth is Mahagauri, representing absolute serenity and grace.
            These forms show the balance between compassion and protective power.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 5,
        sanskrit = "नवमं सिद्धिदात्री च नवदुर्गाः प्रकीर्तिताः । उक्तान्येतानि नामानि ब्रह्मणैव महात्मना ॥ ५ ॥",
        hindi = """
            नौवीं देवी 'सिद्धिदात्री' हैं, जो समस्त सिद्धियाँ और पूर्णता देने वाली हैं।
            ये 'नवदुर्गा' के नौ नाम साक्षात् महात्मा ब्रह्मा जी द्वारा कहे गए हैं।
            इन नामों का स्मरण मात्र ही मनुष्य के जीवन से दरिद्रता दूर कर देता है।
            यह श्लोक नवदुर्गा की महिमा को वेदों की पवित्र वाणी से प्रमाणित करता है।
            सिद्धिदात्री की कृपा से ही साधक को आध्यात्मिक सफलता प्राप्त होती है।
        """.trimIndent(),
        english = """
            The ninth form is Siddhidatri, the bestower of all perfections.
            These nine names of Durga are declared by Lord Brahma himself.
            Remembering these forms removes misfortune from a person's life.
            This verse authenticates the Navadurga through sacred Vedic words.
            Siddhidatri's grace is the final step toward complete liberation.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 6,
        sanskrit = "अग्निना दह्यमानस्तु शत्रुमध्ये गतो रणे । विषमे दुर्गमे चैव भयार्ताः शरणं गताः ॥ ६ ॥",
        hindi = """
            जो मनुष्य अग्नि की लपटों से घिरा हो या युद्ध में शत्रुओं के बीच फँसा हो,
            या जो किसी अत्यंत कठिन और दुर्गम स्थान पर संकटों से घिरा हुआ हो,
            यदि वह डर से व्याकुल होकर माँ भगवती की शरण में आ जाता है,
            तो माँ उसे हर विपत्ति से एक रक्षक की तरह बाहर निकाल लेती हैं।
            यह माँ की असीम करुणा और उनकी रक्षक शक्ति का बहुत बड़ा भरोसा है।
        """.trimIndent(),
        english = """
            One who is surrounded by fire or trapped amidst enemies in war,
            Or someone lost in a dangerous and inaccessible mountain path,
            If they seek refuge in the Goddess with an anxious and fearful heart,
            She rescues them from every calamity like a supreme guardian.
            This verse offers a profound assurance of Her protective mercy.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 7,
        sanskrit = "न तेषां जायते किंचिदशुभं रणसंकटे । नापदं तस्य पश्यामि शोकदुःखभयं न हि ॥ ७ ॥",
        hindi = """
            माँ की शरण में जाने वालों का युद्ध के भीषण संकट में भी कुछ अशुभ नहीं होता।
            उनके जीवन में मैं कोई भी ऐसी आपदा नहीं देखता जो उन्हें नष्ट कर सके।
            शोक, दुःख और भय—ये तीनों उनके पास आने से भी डरने लगते हैं।
            यह श्लोक साधक को पूर्ण सुरक्षा और मानसिक निर्भयता का वरदान देता है।
            ब्रह्मा जी यहाँ माँ की भक्ति की अजेयता को स्पष्ट रूप से स्थापित करते हैं।
        """.trimIndent(),
        english = """
            Those protected by Her face no inauspiciousness even in war.
            No calamity has the power to destroy a devotee of the Mother.
            Sorrow, pain, and fear dare not approach those under Her wing.
            This verse grants a boon of total safety and mental fearlessness.
            Brahma establishes the invincibility of those who dwell in Her grace.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 8,
        sanskrit = "यैस्तु भक्त्या स्मृता नित्यं तेषां वृद्धिः प्रजायते । ये त्वां स्मरन्ति देवेशि रक्षसि तान्न संशयः ॥ ८ ॥",
        hindi = """
            जो भक्त प्रेमपूर्वक नित्य माँ का स्मरण करते हैं, उनकी निरंतर उन्नति होती है।
            हे देवेशि! जो आपका ध्यान करते हैं, आप स्वयं उनकी रक्षा का भार उठाती हैं।
            इसमें किसी भी प्रकार का कोई संशय या संदेह करने की आवश्यकता नहीं है।
            माँ का स्मरण ही जीवन की सबसे बड़ी पूंजी और सुरक्षा कवच बन जाता है।
            यह श्लोक श्रद्धा और माँ की गारंटीड सुरक्षा के बीच के संबंध को बताता है।
        """.trimIndent(),
        english = """
            Those who remember the Mother daily with devotion achieve prosperity.
            O Goddess of Gods! You personally take charge of protecting them.
            There is absolutely no doubt or uncertainty regarding this truth.
            The remembrance of the Mother becomes life's greatest asset and shield.
            This verse links deep faith with Her guaranteed divine protection.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 9,
        sanskrit = "प्रेतसंस्था तु चामुण्डा वाराही महिषासना । ऐन्द्री गजसमारूढा वैष्णवी गरुडासना ॥ ९ ॥",
        hindi = """
            चामुण्डा देवी प्रेत पर विराजमान हैं, जो अज्ञान के विनाश का प्रतीक है।
            वाराही देवी भैंसे पर सवार हैं, जो मानसिक जड़ता को कुचलने वाली हैं।
            ऐन्द्री देवी ऐरावत हाथी पर आरूढ़ हैं, जो ऐश्वर्य और राजसी सत्ता देती हैं।
            वैष्णवी देवी गरुड़ पर स्थित हैं, जो गति और आध्यात्मिक ऊँचाई प्रदान करती हैं।
            ये वाहन देवियों की विशिष्ट शक्तियों और उनके कार्यक्षेत्र को दर्शाते हैं।
        """.trimIndent(),
        english = """
            Chamunda sits on a corpse, symbolizing the destruction of ignorance.
            Varahi is mounted on a buffalo, crushing mental lethargy and dullness.
            Aindri rides the elephant, granting prosperity and sovereign power.
            Vaishnavi sits on Garuda, providing speed and spiritual ascension.
            These vehicles represent the specific powers and domains of the forms.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 10,
        sanskrit = "माहेश्वरी वृषारूढा कौमारी शिखिवाहना । लक्ष्मीः पद्मासना देवी पद्महस्ता हरिप्रिया ॥ १० ॥",
        hindi = """
            माहेश्वरी देवी नंदी बैल पर सवार हैं, जो धर्म और न्याय का प्रतीक है।
            कौमारी देवी मोर पर विराजमान हैं, जो सुंदरता और संयम का संकेत है।
            लक्ष्मी देवी कमल के आसन पर बैठकर हाथ में कमल लिए ऐश्वर्य बरसाती हैं।
            वे भगवान विष्णु की प्रिय हैं और जीवन में सुख-समृद्धि का आधार हैं।
            यह श्लोक जीवन के धर्म, अनुशासन और वैभव के संतुलित रूपों का वर्णन है।
        """.trimIndent(),
        english = """
            Maheshwari rides the bull, the symbol of righteousness and justice.
            Kaumari is mounted on a peacock, signifying beauty and restraint.
            Lakshmi sits on a lotus, showering prosperity and abundance.
            As the beloved of Vishnu, She is the foundation of all happiness.
            This verse describes the balance of duty, discipline, and wealth.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 11,
        sanskrit = "श्वेतरूपधरा देवी ईश्वरी वृषवाहना । ब्राह्मी हंससमारूढा सर्वाभरणभूषिता ॥ ११ ॥",
        hindi = """
            ईश्वरी देवी बैल पर सवार होकर श्वेत (सफेद) रूप में शांति का संदेश देती हैं।
            ब्राह्मी देवी हंस पर आरूढ़ हैं, जो विवेक और ज्ञान का परम प्रतीक है।
            वे सभी प्रकार के दिव्य आभूषणों से सुशोभित और प्रकाशित हो रही हैं।
            सफेद रंग पवित्रता का है, जो मन के विकारों को दूर कर शुद्धता लाता है।
            यह रूप साधक की बुद्धि को निर्मल और सत्य की ओर मोड़ने वाला है।
        """.trimIndent(),
        english = """
            Ishwari, in white form on a bull, broadcasts the message of peace.
            Brahmi is mounted on a swan, the ultimate symbol of wisdom.
            She is adorned with divine ornaments, radiating spiritual brilliance.
            The white color represents purity that cleanses mental impurities.
            This form guides the seeker's intellect toward absolute Truth.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 12,
        sanskrit = "इत्येता मातरः सर्वाः सर्वयोगसमन्विताः । नानाभरणशोभाढ्या नानारत्नप्रशोभिताः ॥ १२ ॥",
        hindi = """
            ये सभी माताएँ सभी प्रकार की योग-शक्तियों और सिद्धियों से संपन्न हैं।
            वे अनेक प्रकार के दिव्य आभूषणों और रत्नों से जगमगा रही हैं।
            उनकी शोभा निराली है और वे ब्रह्मांड की रक्षक शक्तियों का समूह हैं।
            ये माताएँ साधक को योग के मार्ग पर चलने की शक्ति प्रदान करती हैं।
            इनका ध्यान करने से शरीर और मन दोनों में दिव्य रत्नों सा तेज आता है।
        """.trimIndent(),
        english = """
            All these Mothers are endowed with every yogic power and siddhi.
            They are resplendent with various divine ornaments and jewels.
            Their beauty is unique, representing the collective guardians of the cosmos.
            These Mothers grant the seeker the power to walk the path of Yoga.
            Meditating on them brings a jewel-like brilliance to body and mind.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 13,
        sanskrit = "दृश्यन्ते रथमारूढा देव्यः क्रोधसमाकुलाः । शङ्खं चक्रं गदां शक्तिं हलं च मुसलायुधम् ॥ १३ ॥",
        hindi = """
            ये सभी देवियाँ रथों पर आरूढ़ होकर क्रोधपूर्ण मुद्रा में दिखाई दे रही हैं।
            वे असुरों के संहार के लिए शंख, चक्र, गदा और शक्ति जैसे अस्त्र लिए हुए हैं।
            हल और मूसल जैसे हथियार भी उनके हाथों में युद्ध के लिए तैयार हैं।
            माँ का यह क्रोध केवल बुराई को जड़ से मिटाने के लिए जाग्रत हुआ है।
            यह श्लोक माँ के योद्धा स्वरूप और उनकी अजेय तैयारी का वर्णन करता है।
        """.trimIndent(),
        english = """
            These Goddesses are seen mounted on chariots in a wrathful mood.
            They hold the conch, discus, mace, and shakti-spear for war.
            Weapons like the plow and pestle are also ready in their hands.
            This divine anger is awakened solely to uproot evil from existence.
            This verse depicts the warrior aspect and Her invincible preparation.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 14,
        sanskrit = "खेटकं तोमरं चैव परशुं पाशमेव च । कुन्तायुधं त्रिशूलं च शार्ङ्गमायुधमुत्तमम् ॥ १४ ॥",
        hindi = """
            माँ के हाथों में ढाल, तोमर, फरसा और पाश जैसे अनेक शस्त्र सुशोभित हैं।
            भाला, त्रिशूल और भगवान विष्णु का श्रेष्ठ 'शार्ङ्ग' धनुष भी वे धारण किए हैं।
            ये शस्त्र ब्रह्मांड के हर नकारात्मक तत्व को नष्ट करने की क्षमता रखते हैं।
            त्रिशूल तीनों गुणों और तीनों दुखों को समाप्त करने का साक्षात् प्रतीक है।
            इन हथियारों का दर्शन ही भक्त के भीतर साहस और वीरता का संचार करता है।
        """.trimIndent(),
        english = """
            The Mother's hands are adorned with shields, axes, and nooses.
            She wields spears, tridents, and the supreme 'Sharnga' bow of Vishnu.
            These weapons possess the capacity to destroy every negative element.
            The trident symbolizes the end of the three Gunas and three miseries.
            Beholding these weapons instills courage and valor in the devotee.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 15,
        sanskrit = "दैत्यानां देहनाशाय भक्तानामभयाय च । धारयन्त्यायुधानीत्थं देवानां च हिताय वै ॥ १५ ॥",
        hindi = """
            माँ इन शस्त्रों को केवल दैत्यों और असुरों के विनाश के लिए धारण करती हैं।
            इनका मुख्य उद्देश्य भक्तों को पूरी तरह से निर्भय और सुरक्षित करना है।
            ये शस्त्र देवताओं के हित और ब्रह्मांड के संतुलन के लिए चलाए जाते हैं।
            माँ की हिंसा भी करुणा से भरी है क्योंकि वह सत्य की स्थापना के लिए है।
            यह श्लोक माँ के अस्त्रों के पीछे छिपे वास्तविक और पवित्र लक्ष्य को बताता है।
        """.trimIndent(),
        english = """
            The Mother wields these weapons strictly for the destruction of demons.
            Their primary goal is to make devotees completely fearless and safe.
            These arms are exercised for the welfare of gods and cosmic balance.
            Even Her violence is compassionate as it is meant to establish Truth.
            This verse reveals the authentic and sacred motive behind Her weaponry.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 16,
        sanskrit = "नमस्तेऽस्तु महारौद्रे महाघोरपराक्रमे । महाबले महोत्साहे महाभयविनाशिनि ॥ १६ ॥",
        hindi = """
            हे महान उग्र रूप वाली और महाघोर पराक्रम दिखाने वाली देवी, आपको नमस्कार है।
            हे असीम बल वाली, महान उत्साह वाली और बड़े-बड़े भयों का नाश करने वाली!
            आपकी गर्जना मात्र से ही अधर्म कांपने लगता है और भक्त का हृदय शांत होता है।
            आप वह ज्वाला हैं जो अज्ञान और पापों के जंगल को जलाकर राख कर देती हैं।
            यह श्लोक माँ के 'रौद्र' स्वरूप की वंदना कर भयमुक्ति का मार्ग खोलता है।
        """.trimIndent(),
        english = """
            Salutations to You of terrible form and immense, horrific valor.
            O Goddess of great strength, great enthusiasm, and destroyer of fears!
            Your mere roar makes unrighteousness tremble and calms the devotee.
            You are the flame that incinerates the forest of ignorance and sins.
            This verse praises Her 'Raudra' form to pave the way for fearlessness.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 17,
        sanskrit = "त्राहि मां देवि दुष्प्रेक्ष्ये शत्रूणां भयवर्धिनि । प्राच्यां रक्षतु मामैन्द्री आग्नेय्यामग्निदेवता ॥ १७ ॥",
        hindi = """
            हे जिसे देखना भी कठिन हो और जो शत्रुओं का भय बढ़ाने वाली हैं! मेरी रक्षा करें।
            पूर्व दिशा में 'ऐन्द्री' देवी अपनी असीम शक्ति के साथ मेरी रक्षा करें।
            अग्नि कोण (दक्षिण-पूर्व) में 'अग्निदेवता' की शक्ति मेरा सुरक्षा कवच बने।
            यहाँ से शरीर और दिशाओं की 'डिजिटल मैपिंग' या सुरक्षा घेरा शुरू होता है।
            माँ हर कोने से आने वाले संकट को रोकने के लिए अलग-अलग रूपों में खड़ी हैं।
        """.trimIndent(),
        english = """
            O Goddess, difficult to behold and the increaser of terror in enemies!
            May Aindri protect me in the East with Her limitless cosmic power.
            In the Southeast (Agni-corner), may the power of Agnidevata shield me.
            This begins the 'spiritual mapping' and shielding of the physical form.
            The Mother stands in various forms to block calamities from every corner.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 18,
        sanskrit = "दक्षिणेऽवतु वाराही नैर्ऋत्यां खड्गधारिणी । प्रतीच्यां वारुणी रक्षेद् वायव्यां मृगवाहिनी ॥ १८ ॥",
        hindi = """
            दक्षिण दिशा में 'वाराही' देवी अपनी उग्र शक्ति के साथ मेरा बचाव करें।
            नैर्ऋत्य कोण (दक्षिण-पश्चिम) में 'खड्गधारिणी' देवी अपनी तलवार से रक्षा करें।
            पश्चिम दिशा में 'वारुणी' और उत्तर-पश्चिम में 'मृगवाहिनी' मेरा रक्षण करें।
            ये दिशाएं हमारे जीवन के अलग-अलग पहलुओं और आने वाली बाधाओं की प्रतीक हैं।
            माँ का यह घेरा इतना अभेद्य है कि कोई भी नकारात्मकता इसे पार नहीं कर सकती।
        """.trimIndent(),
        english = """
            May Varahi protect me in the South with Her fierce, protective energy.
            In the Southwest, may Khadgadharini guard me with Her divine sword.
            May Varuni in the West and Mrigavahini in the Northwest protect me.
            These directions represent various aspects of life and potential hurdles.
            The Mother's circle is so impenetrable that no negativity can breach it.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 19,
        sanskrit = "उदीच्यां पातु कौमारी ऐशान्यां शूलधारिणी । ऊर्ध्वं ब्रह्माणी मे रक्षेद् अधस्ताद् वैष्णवी तथा ॥ १९ ॥",
        hindi = """
            उत्तर दिशा में 'कौमारी' और उत्तर-पूर्व में 'शूलधारिणी' मेरी रक्षा करें।
            ऊपर की ओर से 'ब्रह्माणी' और नीचे की ओर से 'वैष्णवी' मेरा सुरक्षा घेरा बनें।
            इस प्रकार साधक आकाश से लेकर पाताल तक माँ की शक्ति से घिर जाता है।
            यह सुरक्षा केवल 2D नहीं, बल्कि 3D है, जो हर आयाम में भक्त को सुरक्षित रखती है।
            ब्रह्माणी और वैष्णवी का साथ होना ज्ञान और पालन की शक्तियों का संगम है।
        """.trimIndent(),
        english = """
            May Kaumari protect the North and Shuladharini the Northeast.
            May Brahmani protect from above and Vaishnavi shield from below.
            In this way, the seeker is surrounded by Mother's power in all dimensions.
            This protection is 3D, securing the devotee across every possible axis.
            The presence of Brahmani and Vaishnavi unites wisdom and preservation.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 20,
        sanskrit = "एवं दश दिशो रक्षेच्चामुण्डा शववाहना । जया मे चाग्रतः पातु विजया पातु पृष्ठतः ॥ २० ॥",
        hindi = """
            इस प्रकार दसों दिशाओं में शव पर आरूढ़ 'चामुण्डा' देवी मेरी रक्षक बनी रहें।
            'जया' देवी आगे से और 'विजया' देवी पीछे से मेरा सुरक्षा घेरा मजबूत करें।
            चामुण्डा का शव पर होना मृत्यु और अहंकार को अपने नियंत्रण में रखने का संकेत है।
            आगे और पीछे से रक्षा का अर्थ है कि अतीत और भविष्य दोनों ही माँ के अधीन हैं।
            यह श्लोक साधक को पूर्ण निर्भयता और हर कदम पर माँ का साथ होने का बोध कराता है।
        """.trimIndent(),
        english = """
            May Chamunda, mounted on a corpse, protect me in all ten directions.
            May Jaya protect me from the front and Vijaya guard my back.
            Chamunda on a corpse signifies absolute control over death and ego.
            Protection from front and back means past and future are under Her care.
            This verse gives the seeker total fearlessness and a sense of Her presence.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 21,
        sanskrit = "अजिता वामपार्श्वे तु दक्षिणे चापराजिता । शिखामुद्योतिनी रक्षेद् उमा मूर्ध्नि व्यवस्थिता ॥ २१ ॥",
        hindi = """
            बाईं ओर से 'अजिता' और दाईं ओर से 'अपराजिता' देवी मेरी रक्षा करें।
            'उद्योतिनी' देवी मेरी शिखा (चोटी) की और 'उमा' देवी मेरे मस्तक की रक्षा करें।
            अजिता और अपराजिता वे शक्तियाँ हैं जिन्हें दुनिया में कोई कभी जीत नहीं सकता।
            शिखा और मस्तक की रक्षा का अर्थ है हमारे विचारों और संकल्पों की शुद्धता।
            माँ का यह आशीर्वाद साधक के व्यक्तित्व को एक अजेय किले में बदल देता है।
        """.trimIndent(),
        english = """
            May Ajita protect my left side and Aparajita guard my right.
            May Udyotini protect my top-knot and Uma be established on my head.
            Ajita and Aparajita are the powers that can never be defeated by anyone.
            Protecting the head and top-knot ensures the purity of thoughts and will.
            This blessing transforms the devotee's persona into an unconquerable fort.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 22,
        sanskrit = "मालाधारी ललाटे च भ्रुवौ रक्षेद् यशस्विनी । त्रिनेत्रा च भ्रुवोर्मध्ये यमघण्टा च नासिके ॥ २२ ॥",
        hindi = """
            माथे की 'मालाधारी' और भौहों की 'यशस्विनी' देवी रक्षा का भार उठाएं।
            भौहों के मध्य (तीसरी आँख) की 'त्रिनेत्रा' और नाक की 'यमघण्टा' रक्षा करें।
            तीसरी आँख का स्थान दिव्य दृष्टि और विवेक का मुख्य केंद्र माना गया है।
            नाक की रक्षा का अर्थ है हमारी श्वास और जीवन-ऊर्जा का सुरक्षित होना।
            माँ हमारे चेहरे के हर सूक्ष्म केंद्र को अपनी दिव्य ऊर्जा से सुरक्षित रखती हैं।
        """.trimIndent(),
        english = """
            May Maladhari protect the forehead and Yashaswini the eyebrows.
            May Trinetra guard the third eye and Yamaghanta protect the nose.
            The third eye is the center of divine vision and supreme discrimination.
            Protecting the nose signifies the safety of our breath and life-force.
            The Mother secures every subtle center of the face with Her divine energy.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 23,
        sanskrit = "शङ्खिनी चक्षुषोर्मध्ये श्रोत्रयोर्द्वारवासिनी । कपोलौ कालिका रक्षेत्कर्णमूले तु शाङ्करी ॥ २३ ॥",
        hindi = """
            आँखों के मध्य 'शङ्खिनी' और कानों के छिद्रों की 'द्वारवासिनी' देवी रक्षा करें।
            गालों की 'कालिका' और कानों के मूल (जड़) की 'शाङ्करी' देवी रक्षा करें।
            आँख और कान हमारे बाहरी दुनिया से जुड़ने के सबसे बड़े और मुख्य द्वार हैं।
            यदि ये द्वार माँ की रक्षा में हैं, तो कोई भी बुरा विचार हमें छू नहीं सकता।
            यह श्लोक हमारी इंद्रियों को नकारात्मकता से बचाने का एक आध्यात्मिक फिल्टर है।
        """.trimIndent(),
        english = """
            May Shankhini protect the eyes and Dwaravasini guard the ear canals.
            May Kalika protect the cheeks and Shankari the root of the ears.
            Eyes and ears are the primary gates through which we connect to the world.
            If these gates are under Her watch, no evil thought or sound can taint us.
            This verse acts as a spiritual filter, safeguarding our senses from negativity.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 24,
        sanskrit = "नासिकायां सुगन्धा च उत्तरोष्ठे च चर्चिका । अधरे चामृतकला जिह्वायां च सरस्वती ॥ २४ ॥",
        hindi = """
            नाक के भीतर 'सुगन्धा' और ऊपर के होंठ की 'चर्चिका' देवी रक्षा करें।
            नीचे के होंठ की 'अमृतकला' और जीभ की साक्षात् 'सरस्वती' देवी रक्षा करें।
            जीभ की रक्षा का अर्थ है कि हमारे शब्द हमेशा मधुर, सत्य और पवित्र बने रहें।
            सरस्वती का वास होने से साधक की वाणी में ईश्वरीय शक्ति और तेज आता है।
            माँ हमारे बोलने और सूंघने की शक्ति को दिव्य और दोषमुक्त कर देती हैं।
        """.trimIndent(),
        english = """
            May Sugandha protect the nostrils and Charchika the upper lip.
            May Amritakala protect the lower lip and Saraswati guard the tongue.
            Protecting the tongue ensures that our words remain sweet, true, and holy.
            With Saraswati's presence, the seeker's speech gains divine power and fire.
            The Mother purifies our powers of speech and scent, making them flawless.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 25,
        sanskrit = "दन्तान् रक्षतु कौमारी कण्ठदेशे तु चण्डिका । घण्टिकां चित्रघण्टा च महामाया च तालुके ॥ २५ ॥",
        hindi = """
            दांतों की 'कौमारी', कण्ठ की 'चण्डिका' और गले की घंटी की 'चित्रघण्टा' रक्षा करें।
            तालु (मुँह के ऊपरी भाग) की रक्षा स्वयं 'महामाया' देवी के हाथों में हो।
            कण्ठ और तालु वह स्थान हैं जहाँ से मंत्रों की ध्वनि और शक्ति उत्पन्न होती है।
            चण्डिका और महामाया का यहाँ होना साधक की वाणी को अस्त्र में बदल देता है।
            माँ हमारे शरीर के इस हिस्से को अपनी माया और शक्ति से अभेद्य बना देती हैं।
        """.trimIndent(),
        english = """
            May Kaumari protect the teeth, Chandika the throat, and Chitraghanta the uvula.
            May Mahamaya Herself be the guardian of the palate (mouth's roof).
            The throat and palate are the origins of a mantra's sound and power.
            The presence of Chandika and Mahamaya turns the seeker's voice into a weapon.
            The Mother makes this part of the body invincible through Her Maya and Shakti.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 26,
        sanskrit = "कामाक्षी चिबुकं रक्षेद् वाचं मे सर्वमङ्गला । ग्रीवायां भद्रकाली च पृष्ठवंशे धनुर्धरी ॥ २६ ॥",
        hindi = """
            चिबुक (ठुड्डी) की रक्षा कामाक्षी और वाणी की रक्षा सर्वमङ्गला देवी करें।
            गर्दन के भाग में भद्रकाली और रीढ़ की हड्डी की रक्षा धनुर्धरी करें।
            यह श्लोक शरीर के स्तंभ यानी रीढ़ की सुरक्षा पर जोर देता है।
            वाणी का मंगलमय होना ही साधक की सबसे बड़ी सफलता मानी जाती है।
            माँ हमारे शरीर के ढाँचे को अपनी शक्ति से मजबूती प्रदान करती हैं।
        """.trimIndent(),
        english = """
            May Kamakshi protect the chin and Sarvamangala guard my speech.
            May Bhadrakali protect the neck and Dhanurdhari the spinal cord.
            This verse emphasizes the safety of the spine, the body's main pillar.
            Auspicious speech is considered the greatest success for a seeker.
            The Mother provides structural strength to the body with Her power.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 27,
        sanskrit = "नीलग्रीवा बहिःकण्ठे नलिकां नलकूबरी । स्कन्धयोः खड्गिनी रक्षेद् बाहू मे वज्रधारिणी ॥ २७ ॥",
        hindi = """
            कण्ठ के बाहरी भाग की नीलग्रीवा और कण्ठ की नली की नलकूबरी रक्षा करें।
            कंधों की रक्षा खड्गिनी और भुजाओं की रक्षा वज्रधारिणी देवी करें।
            कंधे और भुजाएं मनुष्य के पुरुषार्थ और कर्म करने की शक्ति का केंद्र हैं।
            वज्रधारिणी का भुजाओं में होना अजेय शक्ति और साहस का संचार करता है।
            माँ हमारे कर्म करने के अंगों को वज्र के समान कठोर और सुरक्षित बनाती हैं।
        """.trimIndent(),
        english = """
            May Nilagriva protect the outer throat and Nalakuvari the windpipe.
            May Khadgini guard the shoulders and Vajradharini protect my arms.
            Shoulders and arms are centers of human effort and the power to act.
            Vajradharini's presence in the arms instills invincible power and courage.
            The Mother makes our active limbs as hard as a diamond and fully secure.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 28,
        sanskrit = "हस्तयोर्दण्डिनी रक्षेद् अम्बिका चाङ्गुलीषु च । नखाञ्छूलेश्वरी रक्षेत् कुक्षौ रक्षेन्नरेश्वरी ॥ २८ ॥",
        hindi = """
            हाथों की दण्डिनी, उंगलियों की अम्बिका और नाखूनों की शूलेख्वरी रक्षा करें।
            पेट के आंतरिक अंगों (कुक्षि) की रक्षा माँ नरेश्वरी के हाथों में हो।
            हाथों के द्वारा ही हम संसार के समस्त व्यवहार और दान-पुण्य करते हैं।
            नाखूनों की रक्षा सूक्ष्म प्रहारों से बचाव का आध्यात्मिक संकेत है।
            माँ हमारे हाथों की कुशलता और आंतरिक अंगों की शुद्धि बनाए रखती हैं।
        """.trimIndent(),
        english = """
            May Dandini protect the hands, Ambika the fingers, and Shuleshwari the nails.
            May Nareshwari be the guardian of the internal abdominal region.
            Through our hands, we conduct all worldly affairs and acts of charity.
            Protecting the nails is a spiritual sign of guarding against subtle attacks.
            The Mother maintains the skill of our hands and the purity of internal organs.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 29,
        sanskrit = "स्तनौ रक्षेन्महादेवी मनः शोकविनाशिनी । हृदये ललिता देवी उदरे शूलधारिणी ॥ २९ ॥",
        hindi = """
            स्तनों की महादेवी और मन की रक्षा शोकविनाशिनी देवी करें।
            हृदय में ललिता देवी और उदर (पेट) में शूलधारिणी देवी वास करें।
            मन का शोक से मुक्त होना ही वास्तविक मानसिक स्वास्थ्य और शांति है।
            ललिता देवी हृदय की कोमलता और प्रेम को सुरक्षित रखती हैं।
            माँ हमारे भावनात्मक और पाचन तंत्र दोनों को संतुलित बनाए रखती हैं।
        """.trimIndent(),
        english = """
            May Mahadevi protect the breasts and Shokavinashini guard the mind.
            May Lalita Devi reside in the heart and Shuladharini in the abdomen.
            Freedom of the mind from grief is true mental health and peace.
            Goddess Lalita protects the tenderness and love within the heart.
            The Mother keeps both our emotional and digestive systems in balance.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 30,
        sanskrit = "नाभौ च कामिनी रक्षेद् गुह्यं गुह्येश्वरी तथा । पूतना कामिका मेढ्रं गुदे महिषवाहिनी ॥ ३० ॥",
        hindi = """
            नाभि की कामिनी और गुह्य अंगों की रक्षा गुह्येश्वरी देवी करें।
            कामिका और पूतना जननेन्द्रिय की तथा गुदा की महिषवाहिनी रक्षा करें।
            नाभि शरीर का ऊर्जा केंद्र है, जहाँ से प्राणों का संचार होता है।
            गुह्य अंगों की रक्षा विकारों और गुप्त रोगों से बचाव का प्रतीक है।
            माँ हमारे प्रजनन और विसर्जन तंत्र को रोगों से मुक्त रखती हैं।
        """.trimIndent(),
        english = """
            May Kamini protect the navel and Guhyeshwari the private parts.
            May Putana and Kamika guard the reproductive organ and Mahishavahini the anus.
            The navel is the body's energy center from where life force circulates.
            Guarding private parts symbolizes protection from impurities and hidden diseases.
            The Mother keeps our reproductive and excretory systems free from ailments.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 31,
        sanskrit = "कट्यां भगवती रक्षेज्जानुनी विन्ध्यवासिनी । जङ्घे महाबला रक्षेत्सर्वकामप्रदायिनी ॥ ३१ ॥",
        hindi = """
            कमर की रक्षा भगवती और घुटनों की रक्षा विन्ध्यवासिनी देवी करें।
            पिंडलियों की रक्षा महाबला देवी करें जो सभी कामनाओं को पूर्ण करती हैं।
            कमर और घुटने हमारे चलने-फिरने और शारीरिक गति के आधार हैं।
            विन्ध्यवासिनी की कृपा से पैरों में शक्ति और स्थिरता बनी रहती है।
            माँ हमारे आधार को मजबूत करती हैं ताकि हम जीवन पथ पर अडिग चल सकें।
        """.trimIndent(),
        english = """
            May Bhagavati protect the waist and Vindhyavasini the knees.
            May Mahabala, the fulfiller of all desires, protect the shanks.
            The waist and knees are the foundation of our mobility and movement.
            By the grace of Vindhyavasini, strength and stability remain in the legs.
            The Mother strengthens our base so we can walk steadily on life's path.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 32,
        sanskrit = "गुल्फयोर्नारसिंही च पादपृष्ठे तु तैजसी । पादाङ्गुलीषु श्रीरक्षेत्तलाधस्तलवासिनी ॥ ३२ ॥",
        hindi = """
            टखनों की नारसिंही और पैरों के ऊपरी भाग की तैजसी देवी रक्षा करें।
            उंगलियों की श्री और तलवों की रक्षा तलवासिनी देवी के जिम्मे हो।
            पैर हमें धरती से जोड़ते हैं, इनकी रक्षा हमें 'ग्राउंडेड' रखती है।
            श्री देवी का उंगलियों में होना हमारे हर कदम को शुभ और सफल बनाता है।
            माँ हमारे पैरों के कण-कण को अपनी दिव्य ऊर्जा से सुरक्षित रखती हैं।
        """.trimIndent(),
        english = """
            May Narasimhi protect the ankles and Taijasi the top of the feet.
            May Shri guard the toes and Talavasini protect the soles.
            Feet connect us to the earth; their protection keeps us grounded.
            Goddess Shri in the toes makes every step we take auspicious and successful.
            The Mother secures every part of our feet with Her divine energy.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 33,
        sanskrit = "नखान् दंष्ट्राकराली च केशांश्चैवोर्ध्वकेशिनी । रोमकूपेषु कौबेरी त्वचं वागीश्वरी तथा ॥ ३३ ॥",
        hindi = """
            नाखूनों की दंष्ट्राकराली और बालों की रक्षा ऊर्ध्वकेशिनी देवी करें।
            रोमछिद्रों की कौबेरी और त्वचा की रक्षा वागीश्वरी देवी करें।
            त्वचा शरीर का सबसे बड़ा रक्षा कवच है, इसकी सुरक्षा अत्यंत महत्वपूर्ण है।
            बालों और नाखूनों की रक्षा हमारे सूक्ष्म सौंदर्य और ऊर्जा की रक्षा है।
            माँ हमारे बाहरी आवरण को अभेद्य और तेजस्वी बनाए रखती हैं।
        """.trimIndent(),
        english = """
            May Damshtrakarali protect the nails and Urdhvakeshini the hair.
            May Kauberi guard the pores and Vagishwari protect the skin.
            The skin is the body's largest shield; its safety is vital.
            Protecting hair and nails safeguards our subtle beauty and energy.
            The Mother keeps our external covering impenetrable and radiant.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 34,
        sanskrit = "रक्तमज्जावसामंसाून्यस्थिमेदांसि पार्वती । अन्त्राणि कालरात्रिः पित्तं च मुकुटेश्वरी ॥ ३४ ॥",
        hindi = """
            रक्त, मज्जा, मांस, हड्डी और मेद की रक्षा माता पार्वती करें।
            आँतों की कालरात्रि और पित्त की रक्षा मुकुटेश्वरी देवी करें।
            यहाँ शरीर के आंतरिक द्रव्यों और धातुओं की सुरक्षा की प्रार्थना है।
            पार्वती जी का यहाँ होना शरीर के भीतर संतुलन और स्वास्थ्य का प्रतीक है।
            माँ हमारे शरीर के रसायनों और धातुओं को रोगों से बचाकर रखती हैं।
        """.trimIndent(),
        english = """
            May Parvati protect the blood, marrow, flesh, bone, and fat.
            May Kalaratri guard the intestines and Mukuteshwari the bile.
            This is a prayer for the safety of internal fluids and tissues.
            Parvati's presence signifies balance and health within the body.
            The Mother guards our bodily chemicals and tissues against diseases.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 35,
        sanskrit = "पद्मावती पद्मकोशे कफे चूडामणिस्तथा । ज्वालामुखी नखज्वालामभेद्या सर्वसन्धिषु ॥ ३५ ॥",
        hindi = """
            हृदय-कमल में पद्मावती, कफ में चूडामणि और नाखूनों में ज्वालामुखी वास करें।
            शरीर के सभी जोड़ों (Sands) की रक्षा अभेद्या देवी करें।
            जोड़ों का सुरक्षित होना बुढ़ापे और शारीरिक जकड़न से मुक्ति दिलाता है।
            ज्वालामुखी का नाखूनों में होना तेज और ऊर्जा के प्रवाह को दर्शाता है।
            माँ हमारे शरीर की लचीलापन और आंतरिक ऊर्जा केंद्रों को सुरक्षित रखती हैं।
        """.trimIndent(),
        english = """
            May Padmavati dwell in the heart, Chudamani in phlegm, and Jvalamukhi in nails.
            May Abhedya protect all the joints of the physical body.
            Securing the joints grants freedom from aging and physical stiffness.
            Jvalamukhi in the nails represents the flow of brilliance and energy.
            The Mother safeguards our flexibility and internal energy hubs.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 36,
        sanskrit = "शुक्रं ब्रह्माणि मे रक्षेच्छायां छत्रेश्वरी तथा । अहंकारं मनो बुद्धिं रक्षेन्मे धर्मधारिणी ॥ ३६ ॥",
        hindi = """
            शुक्र (वीर्य) की ब्रह्माणी, छाया की छत्रेश्वरी और अहंकार-मन-बुद्धि की धर्मधारिणी रक्षा करें।
            छाया की रक्षा का अर्थ है हमारे प्रभाव और आभा मंडल (Aura) की सुरक्षा।
            अहंकार और बुद्धि का सुरक्षित होना हमें गलत निर्णयों से बचाता है।
            धर्मधारिणी का अर्थ है वह शक्ति जो हमारे चरित्र और नैतिकता को थामे रखे।
            माँ हमारे सूक्ष्म शरीर और मानसिक शक्तियों को दिशा और सुरक्षा देती हैं।
        """.trimIndent(),
        english = """
            May Brahmani protect the reproductive fluid and Chatreshwari the shadow.
            May Dharmadharini guard my ego, mind, and intellect.
            Protecting the shadow implies the safety of our influence and Aura.
            Securing ego and intellect prevents us from making wrong decisions.
            Dharmadharini signifies the power that sustains our character and ethics.
            The Mother gives direction and safety to our subtle body and mental powers.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 37,
        sanskrit = "प्राणापानौ तथा व्यानमुदानं च समानकम् । वज्रहस्ता च मे रक्षेत्प्राणं कल्याणशोभना ॥ ३७ ॥",
        hindi = """
            पांचों प्राणों (प्राण, अपान, व्यान, उदान, समान) की रक्षा वज्रहस्ता करें।
            मुख्य प्राण वायु की रक्षा कल्याणशोभना देवी के हाथों में हो।
            प्राण ही जीवन का आधार है; इनके असंतुलित होने से रोग उत्पन्न होते हैं।
            वज्रहस्ता का अर्थ है वह शक्ति जो प्राणों को वज्र जैसा अडिग बना दे।
            माँ हमारी श्वास और जीवन-शक्ति को ब्रह्मांडीय ऊर्जा से जोड़े रखती हैं।
        """.trimIndent(),
        english = """
            May Vajrahasta protect the five vital airs (Prana, Apana, etc.).
            May Kalyanashobhana protect the primary life force (mukhya prana).
            Prana is the basis of life; its imbalance leads to various diseases.
            Vajrahasta means the power that makes life-force as steady as a diamond.
            The Mother keeps our breath and vitality connected to cosmic energy.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 38,
        sanskrit = "रसे रूपे च गन्धे च शब्दे स्पर्शे च योगिनी । सत्त्वं रजस्तमश्चैव रक्षेन्नारायणी सदा ॥ ३८ ॥",
        hindi = """
            स्वाद, रूप, गंध, शब्द और स्पर्श की रक्षा योगिनी देवी करें।
            सत्त्व, रज और तम—तीनों गुणों की रक्षा हमेशा नारायणी देवी करें।
            पाँचों इंद्रियों का सुरक्षित होना हमें बाहरी मोह-माया से बचाता है।
            गुणों की रक्षा का अर्थ है कि हम तमस और रजस के विकारों में न डूबें।
            माँ हमारी चेतना को पवित्र रखकर उसे सात्विक मार्ग पर स्थिर करती हैं।
        """.trimIndent(),
        english = """
            May Yogini protect the senses of taste, sight, smell, sound, and touch.
            May Narayani always protect the three Gunas (Sattva, Rajas, Tamas).
            Securing the five senses shields us from external worldly delusions.
            Protecting the Gunas ensures we don't sink into the flaws of lethargy or passion.
            The Mother keeps our consciousness holy and steady on the path of truth.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 39,
        sanskrit = "आयू रक्षतु वाराही धर्मं रक्षतु वैष्णवी । यशः कीर्तिं च लक्ष्मीं च धनं विद्यां च चक्रिणी ॥ ३९ ॥",
        hindi = """
            आयु की रक्षा वाराही, धर्म की वैष्णवी और यश-कीर्ति-लक्ष्मी की चक्रिणी रक्षा करें।
            धन और विद्या की रक्षा भी चक्रिणी देवी के सुदर्शन चक्र के घेरे में हो।
            जीवन में केवल लंबी उम्र नहीं, बल्कि यश और विद्या का होना भी जरूरी है।
            वाराही देवी अकाल मृत्यु और दुर्घटनाओं से हमारा बचाव करती हैं।
            माँ हमारे सामाजिक सम्मान और बौद्धिक संपदा की पूर्ण रक्षक हैं।
        """.trimIndent(),
        english = """
            May Varahi protect my lifespan and Vaishnavi guard my Dharma.
            May Chakrini protect my success, fame, wealth, and knowledge.
            In life, not just longevity, but fame and wisdom are also essential.
            Goddess Varahi saves us from untimely death and sudden accidents.
            The Mother is the total guardian of our social respect and intellectual assets.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 40,
        sanskrit = "गोत्रमिन्द्राणि मे रक्षेत्पशून्मे रक्ष चण्डिके । पुत्रान् रक्षेन्महालक्ष्मीर्भार्यां रक्षतु भैरवी ॥ ४० ॥",
        hindi = """
            कुल (गोत्र) की इन्द्राणी, पशुओं की चण्डिका और पुत्रों की महालक्ष्मी रक्षा करें।
            पत्नी (या पति) की रक्षा भैरवी देवी अपनी उग्र शक्ति से करें।
            यह श्लोक पूरे परिवार और वंश की सुरक्षा का दिव्य संकल्प है।
            कुल की रक्षा का अर्थ है हमारे पूर्वजों के संस्कारों का सुरक्षित रहना।
            माँ हमारे परिवार के हर सदस्य को अपनी करुणा की छाया में रखती हैं।
        """.trimIndent(),
        english = """
            May Indrani protect the lineage and Chandika guard the livestock.
            May Mahalakshmi protect the children and Bhairavi the spouse.
            This verse is a divine resolve for the safety of the entire family and clan.
            Protecting the lineage means safeguarding the values of our ancestors.
            The Mother keeps every family member under the shadow of Her compassion.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 41,
        sanskrit = "पन्थानं सुपथा रक्षेन्मार्गं क्षेमकरी तथा । राजद्वारे महालक्ष्मीर्विजया सर्वतः स्थिता ॥ ४१ ॥",
        hindi = """
            रास्ते की रक्षा सुपथा, कठिन मार्ग की क्षेमकरी और राजदरबार में महालक्ष्मी रक्षा करें।
            विजया देवी हर जगह स्थित होकर मुझे सर्वत्र विजय प्रदान करें।
            यात्रा के दौरान आने वाली बाधाओं को दूर करना ही सुपथा देवी का कार्य है।
            राजद्वारे का अर्थ है कानून, कचहरी और सरकारी कार्यों में मिलने वाली सफलता।
            माँ हमारे जीवन की हर छोटी-बड़ी यात्रा को सुरक्षित और सफल बनाती हैं।
        """.trimIndent(),
        english = """
            May Supatha protect the path and Kshemakari the difficult roads.
            May Mahalakshmi protect at the King's door and Vijaya guard everywhere.
            Goddess Supatha's role is to remove obstacles encountered during travel.
            'At the King's door' refers to success in legal and governmental matters.
            The Mother makes every journey of our life, big or small, safe and successful.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 42,
        sanskrit = "रक्षाहीनं तु यत्स्थानं वर्जितं कवचेन तु । तत्सर्वं रक्ष मे देवि जयन्ती पापनाशिनी ॥ ४२ ॥",
        hindi = """
            शरीर का जो भी स्थान इस कवच में नहीं बताया गया और जो रक्षा से रहित है,
            हे पापों का नाश करने वाली जयन्ती देवी! उन सभी अंगों की आप रक्षा करें।
            यह माँ की पूर्णता पर विश्वास है कि कुछ छूट भी गया हो तो वे उसे संभाल लेंगी।
            जयन्ती देवी की विजय शक्ति साधक के रोम-रोम में समा जाती है।
            माँ का सुरक्षा कवच अब शरीर के हर ज्ञात और अज्ञात भाग पर सक्रिय है।
        """.trimIndent(),
        english = """
            Any part of my body not specifically mentioned in this armor and left unprotected,
            O Goddess Jayanti, destroyer of sins! Please protect all those parts.
            This reflects total faith that She will handle whatever might have been missed.
            Goddess Jayanti's power of victory permeates every single pore of the seeker.
            The Mother's shield is now active on every known and unknown part of the body.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 43,
        sanskrit = "पदमेकं न गच्छेत्तु यदीच्छेच्छुभमात्मनः । कवचेनावृतो नित्यं यत्र यत्रैव गच्छति ॥ ४३ ॥",
        hindi = """
            यदि मनुष्य अपना कल्याण चाहता है, तो उसे कवच के बिना एक कदम भी नहीं चलना चाहिए।
            जो इस कवच से ढका हुआ है, वह जहाँ-जहाँ भी संसार में जाता है,
            वहाँ उसे माँ की अदृश्य शक्ति का घेरा अपने चारों ओर महसूस होता है।
            यह नियम साधक को हर पल सचेत और माँ की शक्ति से जुड़ा रहने की सलाह देता है।
            कवच केवल शब्द नहीं, बल्कि माँ के प्रति अटूट विश्वास की एक जैकेट है।
        """.trimIndent(),
        english = """
            If one desires absolute welfare, one should not take even a single step without this armor.
            One who is constantly covered by this Kavacham, wherever they go in the world,
            Feels the invisible circle of the Mother's power surrounding them at all times.
            This rule advises the seeker to stay alert and connected to Her power every moment.
            The armor is not just words, but a jacket made of unbreakable faith in the Mother.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 44,
        sanskrit = "तत्र तत्रार्थलाभश्च विजयः सार्वकालिकः । यं यं चिन्तयते कामं तं तं प्राप्नोति निश्चितम् ॥ ४४ ॥",
        hindi = """
            उसे हर स्थान पर धन का लाभ और हर समय (सार्वकालिक) विजय प्राप्त होती है।
            वह जिस-जिस भी कामना का चिंतन करता है, उसे वह निश्चित रूप से प्राप्त कर लेता है।
            कवच साधक के भीतर ऐसी एकाग्रता लाता है कि उसकी इच्छाएं संकल्प बन जाती हैं।
            विजय का अर्थ केवल युद्ध नहीं, बल्कि जीवन की हर चुनौती को जीतना है।
            माँ की कृपा से साधक का हर सही मनोरथ बिना किसी बाधा के पूर्ण होता है।
        """.trimIndent(),
        english = """
            In every place, he attains wealth and enjoys eternal, all-time victory.
            Whatever desire he contemplates or visualizes, he definitely achieves it.
            The armor brings such focus to the seeker that their wishes become firm resolves.
            Victory does not just mean war, but winning over every challenge in life.
            By Her grace, every righteous desire of the seeker is fulfilled without obstacles.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 45,
        sanskrit = "परमैश्वर्यमतुलं प्राप्स्यते भूतले पुमान् । निर्भयो जायते मर्त्यः सङ्ग्रामेष्वपराजितः ॥ ४५ ॥",
        hindi = """
            वह मनुष्य इस पृथ्वी पर अतुलनीय और परम ऐश्वर्य (Prosperity) प्राप्त करता है।
            वह मृत्यु लोक का जीव होकर भी पूरी तरह निर्भय और युद्धों में अपराजित रहता है।
            अतुलनीय ऐश्वर्य का अर्थ है वह सुख जो बाहरी दुनिया के सामानों से नहीं मिलता।
            निर्भयता आत्मा का वह गुण है जो माँ की शरण में जाने पर स्वतः ही आ जाता है।
            माँ अपने भक्त को इस नश्वर संसार में भी एक राजा के समान गरिमा प्रदान करती हैं।
        """.trimIndent(),
        english = """
            That person attains incomparable and supreme prosperity on this earth.
            Though a mortal being, he becomes completely fearless and remains undefeated in battles.
            Incomparable prosperity refers to joy that is not derived from material possessions.
            Fearlessness is a quality of the soul that comes naturally upon seeking Her refuge.
            The Mother grants Her devotee the dignity of a king even in this transient world.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 46,
        sanskrit = "त्रैलोक्ये तु भवेत्पूज्यः कवचेनावृतः पुमान् । इदं तु देव्याः कवचं देवानामपि दुर्लभम् ॥ ४६ ॥",
        hindi = """
            इस कवच से सुरक्षित मनुष्य तीनों लोकों में सम्मान और पूज्यता प्राप्त करता है।
            देवी का यह पवित्र कवच साक्षात् देवताओं के लिए भी प्राप्त करना अत्यंत कठिन है।
            जब हम माँ की शक्ति को ओढ़ लेते हैं, तो ब्रह्मांड की हर शक्ति हमारा सम्मान करती है।
            दुर्लभ होने का अर्थ है कि यह ज्ञान केवल माँ की विशेष कृपा से ही प्राप्त होता है।
            माँ का कवच साधक को साधारण मनुष्य से ऊँचा उठाकर दिव्य श्रेणी में ले आता है।
        """.trimIndent(),
        english = """
            Protected by this armor, a person becomes worthy of worship in all three worlds.
            This sacred Kavacham of the Goddess is extremely rare even for the gods to attain.
            When we clothe ourselves in Her power, every force in the universe respects us.
            Being 'rare' means this wisdom is received only through Her special divine grace.
            The Mother's shield elevates the seeker from an ordinary human to a divine level.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 47,
        sanskrit = "यः पठेत्प्रयतो नित्यं त्रिसन्ध्यं श्रद्धयान्वितः । दैवी कला भवेत्तस्य त्रैलोक्येष्वपराजितः ॥ ४७ ॥",
        hindi = """
            जो व्यक्ति तीनों समय (सुबह, दोपहर, शाम) श्रद्धा के साथ इसका नित्य पाठ करता है,
            उसके भीतर देवी की दिव्य कलाएँ और शक्तियाँ जाग्रत होने लगती हैं।
            वह तीनों लोकों में अजेय हो जाता है और कोई उसे परास्त नहीं कर सकता।
            त्रिसन्ध्य पाठ करने से शरीर और मन का रिदम (Rhythm) ब्रह्मांड से जुड़ जाता है।
            माँ का निरंतर ध्यान साधक को साक्षात् शक्ति का स्वरूप बना देता है।
        """.trimIndent(),
        english = """
            He who recites this daily at the three twilights with absolute faith,
            Begins to awaken divine arts and cosmic powers right within himself.
            He becomes invincible in all three worlds; no one has the power to defeat him.
            Reciting at the three twilights aligns the body and mind's rhythm with the universe.
            Constant meditation on the Mother transforms the seeker into an embodiment of Shakti.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 48,
        sanskrit = "जीवेद्वर्षशतं साग्रमपमृत्युविवर्जितः । नश्यन्ति व्याधयः सर्वे लूताविस्फोटकादयः ॥ ४८ ॥",
        hindi = """
            वह सौ वर्षों से अधिक की पूर्ण आयु जीता है और अकाल मृत्यु का भय मिट जाता है।
            चेचक, चर्म रोग और सभी प्रकार की भयानक बीमारियाँ पाठ करने से नष्ट हो जाती हैं।
            पूर्ण आयु का अर्थ है एक ऐसा जीवन जो स्वस्थ और उद्देश्यपूर्ण (Purposeful) हो।
            माँ का कवच शरीर की रोग प्रतिरोधक क्षमता (Immunity) को आध्यात्मिक रूप से बढ़ाता है।
            माँ की कृपा से साधक का शरीर निरोगी और लंबी उम्र पाने वाला बनता है।
        """.trimIndent(),
        english = """
            He lives a full life of over a hundred years, and the fear of untimely death vanishes.
            Diseases like pox, skin ailments, and all horrific illnesses are destroyed by this recitation.
            A 'full life' means a lifespan that is both healthy and purposeful.
            The Mother's armor spiritually boosts the body's immunity and resilience.
            By Her grace, the seeker's body becomes disease-free and attains a long life.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 49,
        sanskrit = "स्थावरं जङ्गमं चैव कृत्रिमं चैव यद्विषम् । अभिचाराणि सर्वाणि मन्त्रयन्त्राणि भूतल ॥ ४९ ॥",
        hindi = """
            सांप-बिच्छू का जहर, कृत्रिम जहर और धरती पर मौजूद सभी प्रकार के जहरीले पदार्थ,
            साथ ही मारण-मोहन जैसे तांत्रिक प्रयोग, यंत्र और तंत्र के प्रहार निष्फल हो जाते हैं।
            विष का अर्थ केवल शारीरिक जहर नहीं, बल्कि नकारात्मक वातावरण का असर भी है।
            माँ का कवच एक ऐसी जादुई दीवार है जिसे कोई भी काला जादू पार नहीं कर सकता।
            माँ अपने भक्त के चारों ओर एक सुरक्षात्मक 'वाइब्रेशन' का घेरा बना देती हैं।
        """.trimIndent(),
        english = """
            Poisons from snakes or scorpions, artificial poisons, and all toxic substances on earth,
            As well as harmful spells, tantric attacks, and negative yantras, are rendered useless.
            'Poison' refers not just to physical toxins, but also to the impact of a negative environment.
            The Mother's shield is a mystical wall that no black magic can ever penetrate.
            The Mother creates a protective vibrational sphere all around Her devotee.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 50,
        sanskrit = "भूचराः खेचराश्चैव जलजाश्चोपदेशिकाः । सहजा कुलजा माला डाकिनी शाकिनी तथा ॥ ५० ॥",
        hindi = """
            जमीन पर चलने वाले, आकाश में उड़ने वाले और जल में रहने वाले अदृश्य जीव,
            साथ ही डाकिनी, शाकिनी और कुल के दोषों से उत्पन्न बुरी शक्तियां...
            ये सभी माँ के नाम के तेज के सामने एक पल भी टिक नहीं पाते हैं।
            यह श्लोक उन सूक्ष्म नकारात्मक शक्तियों की बात करता है जो हमें दिखाई नहीं देतीं।
            माँ का प्रकाश इन सभी अंधेरी ताकतों को साधक के जीवन से बाहर खदेड़ देता है।
        """.trimIndent(),
        english = """
            Entities of the earth, the sky, and the water, whether visible or invisible,
            Including Dakinis, Shakinis, and malevolent forces born of lineage defects...
            None of these can stand even for a moment against the brilliance of Her name.
            This verse addresses subtle negative entities that are invisible to the naked eye.
            The Mother's light chases all such dark forces completely out of the seeker's life.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 51,
        sanskrit = "अन्तरिक्षचरा घोरा डाकिन्यश्च महाबलाः । ग्रहभूतपिशाचाश्च यक्षगन्धर्वराक्षसाः ॥ ५१ ॥",
        hindi = """
            अन्तरिक्ष में घूमने वाली भयानक डाकिनियां, भूत, पिशाच, यक्ष, गन्धर्व और राक्षस,
            साथ ही ग्रहों के अशुभ प्रभाव और अन्य सभी तामसिक शक्तियाँ...
            माँ की आज्ञा से ये सभी शक्तियाँ साधक के लिए मित्र या सहायक बन जाती हैं।
            ब्रह्मांड की कोई भी उग्र शक्ति कवच धारण करने वाले को नुकसान नहीं पहुँचा सकती।
            माँ का कवच हमें ग्रहों के बुरे प्रभाव (Bad Planetary alignment) से भी बचाता है।
        """.trimIndent(),
        english = """
            Ferocious Dakinis wandering in space, ghosts, goblins, Yakshas, Gandharvas, and demons,
            As well as the inauspicious effects of planets and all other dark energies...
            By Her command, all these forces become friendly or helpful to the devotee.
            No fierce power in the cosmos can harm one who wears Her spiritual armor.
            The Mother's shield also protects us from negative planetary alignments and influences.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 52,
        sanskrit = "ब्रह्मराक्षसवेतालाः कूष्माण्डा भैरवादयः । नश्यन्ति दर्शनात्तस्य कवचे हृदि संस्थिते ॥ ५२ ॥",
        hindi = """
            ब्रह्मराक्षस, वेताल, कूष्माण्ड और भैरव जैसी प्रचंड शक्तियाँ उस मनुष्य को देखते ही भाग जाती हैं,
            जिसके हृदय में माँ का यह दिव्य कवच पूरी तरह से स्थित और जाग्रत है।
            हृदय में स्थित होने का अर्थ है माँ के प्रति पूर्ण समर्पण और अटूट भक्ति।
            साधक का व्यक्तित्व इतना तेजस्वी हो जाता है कि नकारात्मकता उसे छूने का साहस नहीं करती।
            माँ की शक्ति भक्त की आँखों और चेहरे से साक्षात् झलकने लगती है।
        """.trimIndent(),
        english = """
            Brahmarakshasas, Vetals, Kushmandas, and Bhairavas flee at the mere sight of that man,
            In whose heart this divine armor of the Mother is fully established and awakened.
            'Established in the heart' means total surrender and unbreakable devotion to Her.
            The seeker's persona becomes so radiant that negativity lacks the courage to touch them.
            The Mother's power manifests directly through the eyes and face of the devotee.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 53,
        sanskrit = "मानोन्नतिर्भवेद्राज्ञस्तेजोवृद्धिकरं परम् । यशसा वर्धते सोऽपि कीर्तिमण्डितभूतलः ॥ ५३ ॥",
        hindi = """
            समाज और सत्ता (राजा) में उसका मान-सम्मान बढ़ता है और उसके तेज में भारी वृद्धि होती है।
            वह यश और कीर्ति से संपन्न होकर इस पूरी पृथ्वी को अपनी महानता से सुशोभित करता है।
            आत्मज्ञान के साथ-साथ सांसारिक गौरव मिलना माँ की विशेष कृपा का फल है।
            तेज की वृद्धि का अर्थ है एक ऐसा आकर्षण जो लोगों को सही मार्ग की ओर प्रेरित करे।
            माँ अपने भक्त को न केवल आंतरिक शांति, बल्कि बाहरी सफलता और सम्मान भी देती हैं।
        """.trimIndent(),
        english = """
            His honor increases in society and before authorities, and his radiance grows immensely.
            Filled with fame and glory, he adorns the entire earth with his greatness.
            Attaining worldly honor alongside self-knowledge is the fruit of Her special grace.
            'Growth in radiance' refers to a magnetism that inspires others toward the right path.
            The Mother grants Her devotee not just inner peace, but also outer success and respect.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 54,
        sanskrit = "जपेत्सप्तशतीं चण्डीं कृत्वा तु कवचं पुरा । यावद्भूमण्डलं धत्ते सशैलवनकाननम् ॥ ५४ ॥",
        hindi = """
            साधक को पहले कवच का पाठ करना चाहिए और उसके बाद ही दुर्गा सप्तशती का पाठ आरंभ करना चाहिए।
            जब तक यह पृथ्वी, इसके पहाड़ और वन (जंगल) मौजूद हैं,
            तब तक उस साधक की वंश-परंपरा और उसकी कीर्ति इस दुनिया में कायम रहती है।
            कवच पाठ को सप्तशती का 'प्रीमियम' या 'प्रोटेक्शन गियर' माना गया है।
            माँ का आशीर्वाद केवल व्यक्ति तक नहीं, बल्कि उसके आने वाले वंशों तक भी पहुँचता है।
            यह श्लोक साधना के सही क्रम और उसके दूरगामी शुभ परिणामों को बताता है।
        """.trimIndent(),
        english = """
            One should first recite the armor (Kavacham) and only then commence the Durga Saptashati.
            As long as this earth, its mountains, and forests continue to exist,
            The lineage and the fame of that seeker will endure in this world.
            Reciting the Kavacham is considered the 'essential gear' or prerequisite for the Saptashati.
            The Mother's blessing reaches not just the individual, but also their future generations.
            This verse outlines the correct sequence of practice and its long-lasting auspicious results.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 55,
        sanskrit = "तावत्तिष्ठति मेदिन्यां सन्ततिः पुत्रपौत्रिकी । देहान्ते परमं स्थानं यत्सुरैरपि दुर्लभम् ॥ ५५ ॥",
        hindi = """
            उसकी पुत्र-पौत्रों वाली संतान परंपरा इस धरती पर लंबे समय तक टिकी रहती है।
            और अंत में देह त्यागने के बाद वह उस परम स्थान (मोक्ष/धाम) को प्राप्त करता है,
            जो बड़े-बड़े देवताओं के लिए भी अत्यंत दुर्लभ और कठिन माना गया है।
            यहाँ माँ भौतिक वंश और आध्यात्मिक मोक्ष—दोनों का वरदान एक साथ दे रही हैं।
            माँ की भक्ति का अंतिम लक्ष्य वह 'परम स्थान' है जहाँ पहुँचने के बाद कोई दुख नहीं बचता।
            यह साधना मनुष्य को मृत्यु के भय से निकालकर शाश्वत अमृतत्व की ओर ले जाती है।
        """.trimIndent(),
        english = """
            His lineage, through sons and grandsons, endures for a long time upon this earth.
            And ultimately, after leaving the body, he attains that supreme abode (Moksha),
            Which is considered extremely rare and difficult to achieve even for the great gods.
            Here, the Mother grants the boon of both worldly lineage and spiritual liberation.
            The final goal of Her devotion is that 'Supreme Abode' where no sorrow remains.
            This practice leads a person out of the fear of death toward eternal immortality.
        """.trimIndent()
    ),
    KavachamShloka(
        id = 56,
        sanskrit = "प्राप्नोति पुरुषो नित्यं महामायाप्रसादतः । लभते परमं रूपं शिवेन सह मोदते ॥ ५६ ॥\nइति देव्याः कवचं सम्पूर्णम् ॥",
        hindi = """
            वह मनुष्य महामाया की कृपा से नित्य सुख प्राप्त करता है और परम रूप (शिवत्व) को पा लेता है।
            वह अंततः भगवान शिव के साथ परमानंद में विलीन होकर हमेशा के लिए आनंदित रहता है।
            माँ का कवच हमें साक्षात् 'शिव' (कल्याणकारी सत्य) से मिलाने की शक्ति रखता है।
            यहाँ 'देवी कवच' पूर्ण होता है; यह पाठ जीवन को मंगलमयी और अजेय बनाने वाला है।
            माँ भगवती की कृपा हम सब पर सदैव एक कवच बनकर बनी रहे। ॐ शांति।
        """.trimIndent(),
        english = """
            Through the grace of Mahamaya, that person attains eternal bliss and the supreme form.
            He ultimately merges in supreme ecstasy with Lord Shiva and remains joyful forever.
            The Mother's armor has the power to unite us directly with 'Shiva' (the Auspicious Truth).
            Here, the Devi Kavacham reaches its absolute completion; this is a path to an invincible life.
            May the grace of Mother Bhagavati always remain with us as an eternal shield. Om Peace.
        """.trimIndent()
    )
)