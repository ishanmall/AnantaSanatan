package com.sanatangyansagar.ui.screens.veda.samveda.PurvarchikaSamVeda

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
fun PurvarchikaAdhyayaFourScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            purvarchikaAdhyayaFourData
        } else {
            purvarchikaAdhyayaFourData.filter {
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
                        Text("चतुर्थ अध्याय - आरण्यक पर्व", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFC8E6C9) // Forest Green tint for Aranyaka Parva
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
                .background(Color(0xFFF1F8E9)),
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



val purvarchikaAdhyayaFourData = listOf(
    PurvarchikaVerse(
        id = 1,
        sanskrit = "एन्द्र सानसिं रयिं सजित्वानं सदासहम् ।\nवर्षिष्ठमूतये भर ॥ १ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप हमारे कल्याण और रक्षा (ऊतये) के लिए वह ऐश्वर्य और धन (रयिं) लेकर आएं जो अजेय और सदा विजयी हो। 
            आप वह वैभव प्रदान करें जो शत्रुओं के प्रभाव को कुचलने वाला (सदासहम्) और निरंतर उन्नति देने वाला (वर्षिष्ठमम्) हो। 
            यह मंत्र इन्द्र की उस शक्ति का आह्वान करता है जो न केवल भौतिक समृद्धि देती है, बल्कि आंतरिक शत्रुओं पर भी विजय दिलाती है। 
            इन्द्र का आशीर्वाद हमें वह सामर्थ्य प्रदान करता है जिससे हम अपने धर्म के मार्ग पर दृढ़तापूर्वक अडिग रह सकें। 
            सच्चा धन वही है जो हमें समाज में गौरव दिलाए और हमारी आध्यात्मिक यात्रा में सहायक सिद्ध हो सके। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा कवच बनाती हैं जिसे कोई भी नकारात्मक शक्ति भेद नहीं सकती। 
            हम आपकी वंदना करते हैं ताकि हमारे जीवन में साहस और संपन्नता का एक नया सवेरा उदय हो और अज्ञान का नाश हो। 
            हे देवराज, आप अपनी असीम उदारता के साथ हमारे घर और हृदय में विराजें और हमें अखंड शांति का दान दें। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह बनकर प्रवाहित होती है, जिससे हम कठिन से कठिन कार्य सफलतापूर्वक पूर्ण करते हैं। 
            इस संपूर्ण ब्रह्मांड में आपकी ही अजेय सत्ता व्याप्त है, हम आपकी शरण में आकर स्वयं को सुरक्षित और धन्य मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, for our protection and ultimate well-being (Utaye), bring forth that wealth and prosperity (Rayim) which is ever-victorious. 
            Bestow upon us that abundance which subdues all opposing forces (Sadasaham) and is most excellent and vast (Varshishtham). 
            This mantra invokes Indra's power which provides not just material riches but also the strength to conquer internal psychological enemies. 
            Indra's blessing grants us the capability to remain steadfast and unwavering on the righteous path of our designated Dharma. 
            True wealth is that which earns us respect in society and simultaneously acts as a support in our profound spiritual journey. 
            Your protective energies build such a divine shield around us that no negative or demonic force can ever pierce through it. 
            We worship you so that a new dawn of courage and plenty may arise in our lives, terminating the darkness of ignorance forever. 
            O King of Gods, reside in our homes and hearts with your infinite generosity and grant us the boon of eternal and deep peace. 
            Your energy flows through our vital breaths as enthusiasm, enabling us to complete the most daunting tasks with total success. 
            In this entire universe, only your invincible authority prevails; by seeking your refuge, we consider ourselves safe and blessed.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 2,
        sanskrit = "पुनाति ते परिस्रुतं सोमं सूर्यस्य दुहिता ।\nवारेण शश्वता तना ॥ २ ॥",
        hindiCommentary = """
            सूर्य की पुत्री (श्रद्धा) आपके प्रवाहित होते हुए (परिस्रुतं) सोमरस को निरंतर और शाश्वत रूप से पवित्र और दिव्य बनाती है। 
            यह मंत्र श्रद्धा और सोम के गहन संबंध को दर्शाता है, जहाँ श्रद्धा के बिना किसी भी दिव्य तत्व का पूर्ण लाभ प्राप्त करना असंभव है। 
            जैसे सूर्य का प्रकाश अंधकार को नष्ट करता है, वैसे ही सोम और श्रद्धा का मिलन हमारे अंतःकरण के समस्त अज्ञान को भस्म कर देता है। 
            आपकी यह पवित्रता हमें वह ऊँचाई प्रदान करती है जहाँ हम सांसारिक दुखों से ऊपर उठकर शाश्वत परमानंद का अनुभव करने लगते हैं। 
            हे सोम, आप श्रद्धा रूपी छननी से छनकर हमारे हृदय के पात्र में प्रवेश करें और हमारे संपूर्ण व्यक्तित्व को दैवीय आभा से भर दें। 
            आपकी कृपा से हमारे विचार इतने शुद्ध हों कि वे देवताओं के सान्निध्य के योग्य बन सकें और हमें उच्चतर लोकों की ओर ले जाएं। 
            हम श्रद्धापूर्वक आपकी सेवा में तत्पर रहते हैं ताकि हमारे जीवन में ज्ञान, कर्म और भक्ति का सुंदर और सफल समन्वय बना रहे। 
            जैसे सोम ऋषियों को मंत्रों का दर्शन कराता है, वैसे ही आप हमें सत्य का दर्शन कराएं और हमारे मार्ग के समस्त संशयों को दूर करें। 
            आपकी यह ऊर्जा हमारे प्राणों में चेतना बनकर बहती है, जो हमें सदैव धर्म के मार्ग पर दृढ़तापूर्वक चलने की प्रेरणा और शक्ति देती है। 
            हे दिव्य सोम, आप सूर्य की पुत्री के माध्यम से पवित्र होकर हमारे जीवन में मंगलकारी सुख और अखंड सौभाग्य का संचार करने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The daughter of the Sun (Faith/Shraddha) purifies your flowing (Parisrutam) Soma juice continuously and eternally with her divine power. 
            This mantra illustrates the profound connection between Faith and Soma, where it is impossible to gain the full benefit of divinity without devotion. 
            Just as the light of the Sun destroys darkness, the union of Soma and Faith consumes all the ignorance hidden within our inner self. 
            Your holiness grants us that elevation where we rise above worldly sufferings and begin to experience eternal and supreme bliss. 
            O Soma, passing through the filter of Faith, enter the vessel of our hearts and fill our entire personality with a celestial and radiant aura. 
            By your grace, let our thoughts become so pure that they are worthy of the company of gods and lead us toward the higher celestial realms. 
            We remain dedicated to your service with devotion so that a beautiful harmony of knowledge, action, and devotion stays in our lives. 
            Just as Soma enables seers to perceive sacred mantras, enable us to perceive the Truth and remove all doubts from our life's path. 
            Your energy flows through our being as consciousness, perpetually inspiring and empowering us to walk firmly on the path of Dharma. 
            O Divine Soma, being purified through the daughter of the Sun, graciously infuse our lives with auspicious happiness and unbroken good fortune.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 3,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ३ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम वीरता (सुवीर्यं), श्रेष्ठ धन (रयिम्) और असीम सुख (मयः) प्रदान करने के लिए पवित्र होकर प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता और सामर्थ्य लाने वाली है, हम आपकी असीम कृपा की याचना करते हैं। 
            वीरता केवल युद्ध में नहीं, बल्कि जीवन की प्रतिकूलताओं में धर्म पर अडिग रहने के लिए भी आवश्यक है, कृपया हमें वह बल प्रदान करें। 
            हमें वह धन दें जो न्यायपूर्ण रीति से प्राप्त किया गया हो और जिसका उपयोग हम समाज के दीन-दुखियों की सेवा में अत्यंत गौरव के साथ कर सकें। 
            आपकी कृपा से प्राप्त होने वाला 'मयः' (सुख) वह शांति है जो बाहरी परिस्थितियों पर निर्भर नहीं करती, बल्कि हृदय के भीतर से आती है। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दृष्टि दें जिससे हम आपके दिव्य ऐश्वर्य को चराचर जगत के कण-कण में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे जीवन की दरिद्रता और जड़ता को समाप्त कर हमें प्रचुरता और सक्रियता के शिखर पर पहुँचाती हैं। 
            आपकी महिमा का गान करने से हमारे दुखों का नाश होता है और हमें नवीन उत्साह और जीवनी शक्ति की निरंतर प्राप्ति होती रहती है। 
            हे सोम, आप हमारे स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की महान कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और पूर्णतः ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state to bestow upon us superior valor (Suviryam), excellent wealth (Rayim), and infinite bliss (Mayah). 
            Your holy stream brings prosperity and capability into every single area of our lives; we humbly seek your boundless grace and favor. 
            Valor is required not only in war but also to stay firm on the path of Dharma amidst life's adversities; please grant us that strength. 
            Provide us with that wealth which is obtained through righteous means and which we can use for the service of the needy with pride. 
            The 'Mayah' (happiness) obtained by your grace is that inner peace which does not depend on external situations but arises from within. 
            O God, purify our inner self and grant us the vision to perceive your divine splendor in every particle of the moving and non-moving world. 
            You are the power that terminates the poverty and lethargy of our existence and leads us to the peaks of abundance and activity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm and vital force for our spiritual journey. 
            O Soma, always stay with us as our protector and Lord, graciously making our lives magnificent, successful, and truly renowned. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, and completely God-conscious in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 4,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को बुलाने वाले दिव्य और पवित्र माध्यम हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा और आधार हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र और कल्याणकारी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख और धर्मनिष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और मानवता के मार्ग पर चलने की प्रेरणा देती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव कर सकें। 
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 5,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ५ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव सुखी रहें। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान बनाएं। 
            जब हमारा मन आपकी भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the destructive fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 6,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त और अज्ञान के संकटों से सदैव सुरक्षित रखने की अपनी महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें बचाएं। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त ज्वालाओं से हमारे भीतर के समस्त दोषों और विकारों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा और पवित्रता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म करती है। 
            हम आपकी शरण में आकर सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक और न्याय के प्रहरी हैं। 
            हमें वह आत्मबल प्रदान करें जिससे हम कभी भी अधर्म के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति कभी भेद न सके। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस और मानसिक शांति प्रदान करने वाला होता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु से अमरत्व की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible pit of sins and the calamities arising from ignorance. 
            Those negative forces that wish us harm, please foil all their conspiracies with your supreme intelligence and save us. 
            O Ageless and Radiant Deity, consume all our internal flaws and mental afflictions from the root with your most intense flames. 
            Your fire does not just destroy; it provides life with a new direction and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for security, for you are the guardian of all worlds and the sentinel of cosmic justice. 
            Grant us the inner strength to never walk the path of unrighteousness and to always obey your divine and holy commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force of the world can ever pierce. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true warriors of the Truth. 
            The experience of your protective power in every struggle of life gives us unbreakable courage and deep mental peace. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from mortality to immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 7,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ७ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे द्वेष रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर विजयी हों। 
            हमें वह आंतरिक शुद्धता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक अंश प्रदान करें। 
            यज्ञ में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो कल्याणकारी हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे चारों ओर रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भयों, संशयों और दुखों को जड़ से समाप्त कर देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा उठें। 
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक सार्थक जीवन जिएं।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor malice toward us. 
            May your divine energy provide us with that capability to face all of life's challenges and hurdles with absolute fearlessness. 
            Grant us that internal purity which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible power is the foundation of our existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of beneficial goals. 
            Create a continuous circle of your sacred light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward success. 
            Your friendship is that divine security for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to service and devotion, helping us to rise spiritually higher. 
            O Agni, give us the luster to keep ourselves established in Dharma and to lead a meaningful life while serving humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 8,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ८ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी और जीवनदायी ऐश्वर्य हमारे घर और हृदय में लेकर आने की कृपा करें। 
            आप हमें वह जीवनी शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म और ज्ञान की सेवा कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और ऊर्जावान बना देने की कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन की कमी न रहे और हम सदैव दूसरों की सहायता करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा और विवेक भी देते हैं जो हमें मोक्ष और सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम आपकी शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत घोल दें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और महान बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes and hearts a splendor and prosperity as brilliant and life-giving as the Sun. 
            Provide us with the vital energy that allows us to stay healthy and active for a long life to perform noble deeds and serve Dharma. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us joy that is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with energy. 
            By your grace, let there be no lack of resources in our lives, ensuring we are always capable of serving and assisting others. 
            You do not just provide external wealth; you also grant that wisdom and discernment which lead us toward liberation and Truth. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your care. 
            O God, eliminate the dark shadows of our sorrows and infuse our lives with the nectar of divine joy and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and renowned.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 9,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ९ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी शक्ति से निरंतर पोषण देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार और श्रेष्ठ दिशा की ओर बढ़ते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण करने में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता और आत्म-संतोष लाने वाली है, हम आपकी इस शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत और अमोघ सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 10,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ १० ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that makes our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior human virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our journey toward the world beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 11,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ११ ॥",
        hindiCommentary = """
            हे असीम शक्ति के पुंज इन्द्रदेव! आप हमारी श्रद्धापूर्ण स्तुतियों से प्रसन्न होकर हमारे प्रति अत्यंत दयालु और अनुग्रहपूर्ण भाव रखते हुए यहाँ पधारें। 
            आप अपनी महान और अत्यंत विस्तार वाली रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के इस यज्ञ में सहायक और रक्षक बनकर साक्षात् आएं। 
            आपकी पावन उपस्थिति हमारे भीतर के सुप्त आत्मविश्वास को जागृत करती है और हमें जीवन की बड़ी से बड़ी विपदाओं से सफलतापूर्वक लड़ने का साहस प्रदान करती है। 
            जब आप हमारे पक्ष में और हमारे साथ खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति, शत्रु या बाधा हमें पराजित करने का साहस तनिक भी नहीं कर सकती। 
            हे देवराज, आप हमारे अज्ञान रूपी घोर अंधकार को अपनी दिव्य ज्योति से मिटाकर हमारे जीवन में वास्तविक ज्ञान, विवेक और आत्मिक प्रकाश फैलाने की कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा दुर्ग का निर्माण करती हैं जिसमें केवल सुख, अखंड शांति और पवित्रता का ही निरंतर वास होता है। 
            हम अपनी विनम्र, निष्कपट और आर्त पुकार से आपको निरंतर पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी अनंत उदारता और वैभव से पूर्ण कर दें। 
            आप ही वह सर्वोच्च और आदि शक्ति हैं जो हमारे प्रत्येक परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी अनंत महिमा और ऐश्वर्य के साथ हमारे घर और हृदय के सिंहासन पर विराजें और हमें सदैव अपनी दिव्य सुरक्षा की शीतल छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण, मंगल और सौभाग्य सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धा और प्रेम से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the fountain of infinite energy, being pleased by our devoted hymns and harboring a kind and graceful intent toward us, please come here. 
            Arrive in our lives as a helper and guardian along with your grand and immensely vast protective powers and divine assistances (Mahibhih Utibhih). 
            Your holy presence awakens the dormant self-confidence within us and grants us the courage required to successfully battle the greatest life calamities. 
            When you stand on our side and with us, no negative force, enemy, or obstacle in the world can ever dare to defeat or even disturb our inner peace. 
            O King of Gods, erase the deep darkness of our ignorance with your divine light and spread the radiance of true knowledge and wisdom in our lives. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness, peace, and purity reside continuously. 
            We invoke you with our humble, sincere, and desperate cries so that you may fulfill every single scarcity of our existence with your infinite generosity. 
            You are the supreme and primordial power that makes our every effort meaningful and carries us forward on the path of evolution and growth. 
            O Indra, reside on the throne of our homes and hearts with your infinite glory and splendor, and keep us forever safe under your divine protection. 
            Our ultimate well-being, auspiciousness, and good fortune are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 12,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ १२ ॥",
        hindiCommentary = """
            हे श्रेष्ठ भक्तों! आप उन अद्भुत, तेजस्वी और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो पवित्र सोमरस का पान कर अत्यंत आनंदित और प्रमुदित होते हैं। 
            वे हमें ऐश्वर्य, सुख और दिव्य धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महान महिमा भक्तों की श्रद्धापूर्ण वाणी से निरंतर विकसित और विस्तारित होती है। 
            जैसे गौएँ और माताएं अपने प्रिय बछड़े की ओर अगाध प्रेम और वात्सल्य भाव से दौड़ती हैं, वैसे ही हमारी स्तुतियां और हृदय की पुकार इन्द्र की ओर प्रवाहित होती हैं। 
            आपकी दिव्य उपस्थिति मात्र से हमारे मन की समस्त चंचलता, अशांति और संशय समाप्त होते हैं और हम एकाग्र होकर आपकी असीम सत्ता का साक्षात् अनुभव करते हैं। 
            हे शक्तिशाली इन्द्र, आप हमारे जीवन रूपी यज्ञ के अविचल आधार हैं और हमारे संपूर्ण अस्तित्व को ऊर्जस्वित करने वाले परम तेजस्वी और अजेय देव हैं। 
            जैसे बछड़ा अपनी माता से पोषण, सुरक्षा और जीवन प्राप्त करता है, वैसे ही हम आपकी असीम कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्रचुर मात्रा में प्राप्त करते हैं। 
            आपकी उदारता की कोई सीमा नहीं है; आप अपने प्रत्येक शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके सर्वांगीण, श्रेष्ठ और दिव्य विकास के लिए अनिवार्य है। 
            हम अपनी मधुर, सत्यनिष्ठ और भक्तिपूर्ण वाणी से आपको प्रसन्न करने का निरंतर प्रयास करते हैं ताकि आप हमारे जीवन के समस्त क्लेशों और दुखों का अंत कर सकें। 
            इन्द्रदेव की पावन शरण में आने वाला साधक कभी रिक्त, निर्बल या असहाय नहीं रहता, उसे ज्ञान के अखंड प्रकाश और अनंत वैभव का दुर्लभ वरदान प्राप्त होता है। 
            हे देवराज, आप हमारे हृदयों में अनन्य भक्ति, प्रेम और निष्कामता का संचार करें और हमें सदैव अपनी दिव्य सुरक्षा की छाया में सुरक्षित, सुखी और संतुष्ट रखें।
        """.trimIndent(),
        englishCommentary = """
            O excellent devotees, praise the wonderful, radiant Lord Indra, the subduer of all foes, who rejoices in the consumption of the sacred Soma nectar. 
            He remains ever ready to bestow abundance, joy, and divine prosperity upon us, and his great glory is continuously expanded by our devoted hymns. 
            Just as cows and mothers run with profound love and maternal affection toward their beloved calf, our hymns and heartfelt cries flow toward Indra. 
            Your divine presence alone terminates all the restlessness, turmoil, and doubts of our minds, allowing us to experience your infinite existence with focus. 
            O Mighty Indra, you are the immovable foundation of the sacrifice of our lives and the supremely radiant and invincible deity who energizes our being. 
            As a calf receives vital nourishment, protection, and life from its mother, we receive spiritual peace and material plenty through your divine grace. 
            There is no limit to your generosity; you bestow upon every surrendered devotee everything that is mandatory for their holistic and divine development. 
            We strive to please you with our sweet, truthful, and devoted voices so that you may bring a definitive end to all the afflictions and sorrows of our life. 
            A seeker who takes refuge in Lord Indra never remains empty, weak, or helpless; they are blessed with the light of knowledge and infinite splendor. 
            O King of Gods, infuse our hearts with exclusive devotion, love, and selflessness, and keep us forever protected and happy under your divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 13,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ १३ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों, ऋषियों और विद्वानों द्वारा अपनी पवित्र और ओजस्वी स्तुतियों के माध्यम से निरंतर संवर्धित और प्रदीप्त किए जाने वाले महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह अजेय शक्ति, प्रचुर अन्न, स्वास्थ्य और विजय लेकर आने की कृपा करें जो हमारे जीवन को प्रत्येक दृष्टि से पूर्णतः उन्नत बना सके। 
            आप हमारे लिए एक परम कल्याणकारी और अत्यंत आत्मीय मित्र (सखा) बनकर हमारे जीवन की इस दुर्गम और चुनौतीपूर्ण यात्रा को अत्यंत सुगम और सफल बनाएं। 
            आपकी यह दिव्य मित्रता संसार के सभी अस्थायी, क्षणभंगुर और स्वार्थी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त को नहीं त्यागते। 
            हे देव, हमें वह अटूट आत्मबल और साहस प्रदान करें जिससे हम जीवन के भीषण संघर्षों में विजयी होकर समाज और राष्ट्र में एक गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों, परिवारों और समाज में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव होने की स्थिति न आए। 
            जब आप हमारे सखा और मार्गदर्शक बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक, मानसिक या भौतिक मार्ग में कभी भी रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम, त्याग और पुरुषार्थ को ईश्वरीय फल और महान दिव्य सफलता में बदलने वाले देव हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह, अटूट आशा और उच्च चेतना बनकर बहती है, जो हमें सदैव श्रेष्ठ, पवित्र और परोपकारी कर्म करने के लिए निरंतर प्रेरित करती है। 
            हे इन्द्र, आप हमारे परम रक्षक और गुरु के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, ज्ञानी, यशस्वी, धर्मनिष्ठ और परोपकारी बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the magnificent deity who is continuously increased and glorified through the powerful hymns of men, sages, and scholars. 
            Graciously bring to us very quickly that invincible power, abundant nourishment, health, and victory which will elevate our lives in every aspect. 
            Become a supremely benevolent and highly intimate friend to us, making this difficult and challenging journey of life smooth, easy, and successful. 
            Your divine friendship is superior to all temporary, fleeting, and selfish worldly relationships because you never abandon your devotee in distress. 
            O God, provide us with the unshakable inner strength and courage required to emerge victorious in life's fierce struggles and attain a dignified position. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources, joy, or peace within our homes and society. 
            When you become our companion and guide, no major obstacle of the world can ever block our spiritual, mental, or material progress and evolution. 
            We worship you with deep devotion, for it is you who transforms our hard labor, sacrifice, and efforts into divine results and magnificent successes. 
            Your energy flows through our being as enthusiasm, hope, and higher consciousness, perpetually inspiring us to perform noble and altruistic deeds. 
            O Indra, stay with us as our supreme protector and teacher, graciously making us magnificent, knowledgeable, successful, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 14,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ १४ ॥",
        hindiCommentary = """
            हे वृत्रहन् (अज्ञान और समस्त बुराइयों का नाश करने वाले) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में अपनी असीम दया और कृपा के साथ अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के प्रत्येक संघर्ष में एक सजग सहायक और रक्षक बनकर आएं। 
            आपकी दिव्य उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता और ईश्वरीय शक्ति प्रदान करती है जिससे हम जीवन की किसी भी कठिन परिस्थिति में कभी नहीं डगमगाते। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति, नकारात्मक ऊर्जा या बाधा से तनिक भी भयभीत होने की तनिक भी आवश्यकता नहीं है। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का समूल नाश कर हमारे मन में ज्ञान और विवेक की निर्मल और पवित्र गंगा प्रवाहित करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा दुर्ग बनाती हैं जिसमें कोई भी बुराई, पाप, रोग या मानसिक विकार कभी भी प्रवेश नहीं कर सकता। 
            हम अपनी विनम्र और हृदयस्पर्शी प्रार्थनाओं से आपको निरंतर पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से सदा के लिए मिटा सकें। 
            आप ही वह सर्वोच्च और आदि शक्ति हैं जो हमारे प्रत्येक परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता और वैभव के साथ हमारे घर और हृदय में विराजें और हमें अपने मंगलकारी और दिव्य आशीषों से निरंतर कृतार्थ करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण, सुख और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार अत्यंत श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra (the forces of ignorance and evil), please do come graciously to our sacrificial ground and take our side. 
            Arrive in our lives as a vigilant helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your sacred presence provides our resolutions with that steel-like firmness and divine strength needed to remain unshaken in any situation. 
            When you are with us, there is absolutely no need for us to fear any demonic force, negative energy, or obstacle that the material world presents. 
            O King of Gods, graciously destroy the Vritra of ignorance within our hearts and let the pure and holy river of knowledge flow within our minds. 
            Your protective energies build such an impenetrable shield around us that no form of evil, sin, disease, or mental affliction can ever enter. 
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your divine light forever. 
            You are the supreme and primordial power that makes our every effort meaningful and carries us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your infinite generosity and splendor, and bless us with your most auspicious and divine favors. 
            Our complete well-being, happiness, and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 15,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ १५ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि और विवेक हैं, आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी और करुणामयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र सच्चे हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन और पोषण कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के ज्ञात और अज्ञात संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म और स्थूल देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और अखंड आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन और जटिल निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से सफलतापूर्वक बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और स्नेह की कोई सीमा नहीं है, और हम एक समर्पित और श्रद्धालु संतान के रूप में आपकी पावन वंदना निरंतर करते हैं। 
            आपकी असीम कृपा से ही हमें वह मानसिक शांति और स्थिरता प्राप्त होती है जो संसार की किसी भी नश्वर और भौतिक वस्तु में अत्यंत दुर्लभ और अप्राप्य है। 
            हम अपनी संपूर्ण श्रद्धा, प्रेम और अडिग विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित रखें और सुखी रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान के अखंड प्रकाश से भी आलोकित करने की कृपा करें। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को समूल नष्ट कर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाने की महान कृपा करे।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are established as our superior intellect and discernment, our supreme Father, and our most affectionate and merciful Mother. 
            You have manifested in our lives as the foundation of our entire existence and our only true well-wisher, continuously nurturing and nourishing us. 
            Just as parents protect and nourish their innocent child from all kinds of known and unknown dangers, you take care of our subtle and physical needs. 
            We seek from you that 'Sumnam' (supreme bliss and spiritual peace) which is only granted to true and sincere devotees seeking your holy refuge. 
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the illusory web of ignorance. 
            O King of Gods, there is no limit to your maternal affection and love for us, and we worship you with the simple heart of a dedicated child. 
            By your boundless grace alone do we find the mental tranquility and stability that is extremely rare and unattainable in any perishable worldly object. 
            We offer our complete faith, love, and unwavering trust at your divine feet so that you may forever keep us fully safe and happy within your shadow. 
            O Indra, bring abundance into every field of our existence and make us successful while illuminating us with the light of Self-realization. 
            May your radiant stream completely destroy the root of our ignorance and successfully lead us to the realization of the Supreme Truth and God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 16,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ १६ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद, तृप्ति और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस संपूर्ण ब्रह्मांड के कण-कण में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और अपार श्रद्धा के साथ आपकी अनन्य सेवा, भक्ति और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण चराचर जगत और इसकी समस्त सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य, न्याय और धर्म की रक्षा सकें। 
            जैसे वर्षा की शीतल बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव, दुख और कष्ट सदा के लिए जड़ से दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक एवं आध्यात्मिक समृद्धि से सदा के लिए परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति और अटूट साहस प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर और नश्वर वस्तुओं में सर्वथा दुर्लभ और कठिन है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव परमात्मा के समीप रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, satisfaction, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial ritual, we offer our exclusive service with hymns and deep faith to please and glorify your supreme divinity. 
            It is through your divine energy that this entire moving and non-moving universe is governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Truth and Dharma. 
            Just as the thirsty earth is satisfied by cool raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and holistic prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is totally rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 17,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ १७ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर के रूप में प्रतिष्ठित हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन एवं शक्तिशाली स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का निरंतर प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और दिव्य ओज का जागरण होता है, जिससे वह जीवन के प्रत्येक क्षेत्र में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण और सम्मानित स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए परम कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और अखंड आत्मिक शांति का दिव्य अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को महान दिव्य आशीर्वादों में बदलने का सामर्थ्य रखती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का दुर्लभ वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी, सुखी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O devotees who know the divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns, and no being can ever surpass the limit of his might. 
            Indra is the supreme authority who utilizes his fierce and invincible power to maintain the justice, discipline, and balance of the universe. 
            Singing his glories with devotion awakens the dormant courage, heroism, and vigor within a person, enabling them to emerge victorious in life. 
            O God, remove every dark aspect of our existence and bestow upon us that brilliance which allows us to attain a place of honor in society. 
            By your grace, let us receive that wealth which is earned strictly by following the path of Truth and which is beneficial for all of humanity. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God and spiritual peace. 
            You are the supreme power that transforms our hard labor into divine results and our desperate prayers into magnificent celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless; they are blessed with the sharpness of self-knowledge and abundance. 
            O Indra, stay with us as our protector and eternal guide, and graciously make us great, successful, renowned, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 18,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ १८ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों और साधकों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के परम पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए सादर आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय और अजर बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त आंतरिक शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें पूर्णतः निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends and fellow seekers, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our internal enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 19,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ १९ ॥",
        hindiCommentary = """
            समस्त स्तुतियां और प्रार्थनाएं समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अथाह है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और दिव्य सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की महान कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव इस जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत, सचेत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक, रक्षक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग दिखाए, यही हमारी विनम्र प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मिक रूप से सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and unfathomable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and divine charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 20,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ २० ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता, पराक्रम और आत्मबल के प्रेमी हैं, कृपया हमारे भीतर भी वही वीरता और अडिग साहस स्थापित करें। 
            आप अत्यंत महान और तेजस्वी हैं, हमारे जीवन के श्रेष्ठ संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें। 
            सच्ची वीरता वह नहीं जो केवल बाह्य युद्ध में दिखे, बल्कि वह है जो हमें अपने भीतर के विकारों और शत्रुओं पर विजय पाने की अद्भुत शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य और न्याय का मार्ग प्रशस्त करने वाले निस्वार्थ योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के प्रत्येक सूक्ष्म डर को समाप्त कर हमें पूर्णतः निर्भीक, शांत और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का दिव्य बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति या अभाव हमें कभी विचलित नहीं कर सकता। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम मानवता के लिए श्रेष्ठ बन सकें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल और थके हुए मन में नवीन ऊर्जा का संचार कर हमें निरंतर कर्मयोग की ओर सफलतापूर्वक अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के वास्तविक और शाश्वत सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक गौरवशाली और सार्थक जीवन व्यतीत करने में सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism, valor, and inner strength; please instill that same valor and unshakable courage within us. 
            You are exceedingly great and radiant; grant firmness to the noble resolutions of our lives so that we are always ready for the defense of Dharma. 
            True heroism is not just seen in physical external war, but in the power that enables us to conquer our own inner flaws and hidden enemies. 
            By your grace, let us receive that vigor and luster which transform us into selfless warriors who pave the way for Truth and Justice in society. 
            O King of Gods, graciously terminate every subtle fear within us and make us completely fearless, calm, and self-confident. 
            When you sow the divine seed of courage in our hearts, no adverse circumstance or scarcity of the world can ever sway or disturb us. 
            We worship you with devotion so that a fraction of your greatness reflects in our character and we become superior beings for humanity. 
            You are the power that infuses fresh energy into our lethargic and tired minds, pushing us successfully toward the path of Karma Yoga. 
            O Indra, give us the spiritual capability to rise above worldly temptations and attain the true essence of the Divine and Eternal Truth. 
            May your merciful gaze always remain upon us as we lead a glorious and meaningful life successfully under your supreme divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 21,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ २१ ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित (स्वराजम्) हैं, भक्त उनकी परम उपासना करते हैं। 
            वे 'होता' के पवित्र आह्वान और यज्ञीय आहुतियों के माध्यम से निरंतर प्रदीप्त और भक्तों के हृदयों में संवर्धित किए जाते हैं। 
            इन्द्र की यह 'स्वराज' अवस्था मनुष्य को आत्म-संयम, आत्म-बोध और वास्तविक आत्म-निर्भरता का महान आध्यात्मिक संदेश प्रदान करती है। 
            जब हम अपनी दसों इंद्रियों के स्वामी स्वयं बन जाते हैं, तब हम अपने भीतर इन्द्र के उस दिव्य और तेजस्वी स्वरूप का अनुभव कर सकते हैं। 
            यज्ञ की पवित्र अग्नि में दी गई प्रत्येक आहुति इन्द्र के बल को बढ़ाती है, जो अंततः ब्रह्मांडीय संतुलन के रूप में हमारे ही कल्याण के लिए आती है। 
            हे देव, आप अपनी असीम महिमा के साथ हमारे जीवन के प्रत्येक कठिन कार्य में सहायक बनकर हमें पूर्ण सफलता की ओर ले जाएं। 
            आपकी निरंतर उपासना से हमारे मन के समस्त संशय दूर होते हैं और हमें वह दिव्य स्पष्टता प्राप्त होती है जिससे हम सत्य को जान सकें। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आपकी न्यायपूर्ण और दयालु दृष्टि हमें सदैव उन्नति के मार्ग पर अग्रसर रखे। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों और भौतिक प्रचुरता में बदलने का सामर्थ्य रखती हैं। 
            हे इन्द्र, आप हमारे रक्षक और स्वामी बनकर हमें अज्ञान के अंधकार से निकालकर दिव्यता के सर्वोच्च प्रकाश की ओर सफलतापूर्वक ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, those who are filled with deep reverence sit before Lord Indra, who is self-radiant and established in his own sovereignty. 
            He is continuously increased and glorified through the sacred calls of the priests and the sincere sacrificial offerings of the followers. 
            This state of 'Svaraj' or self-sovereignty by Indra provides a great spiritual message of self-control and self-reliance to all of humanity. 
            When we become the true masters of our own senses, we can experience that divine and radiant aspect of Indra within our consciousness. 
            Every oblation offered in the sacrificial fire increases Indra's strength, which ultimately returns to us as cosmic balance and welfare. 
            O God, with your infinite majesty, become our helper in every daunting task of our life and lead us toward magnificent success. 
            Worshipping you consistently removes the doubts of our minds and grants us the divine clarity required to perceive the Eternal Truth. 
            We bow before you with devotion so that your just and merciful gaze continuously steers us toward the path of progress and evolution. 
            You are the ultimate power that possesses the capability to transform our subtle intentions into cosmic achievements and material plenty. 
            O Indra, stay with us as our protector and Lord; pull us out of the darkness of ignorance toward the highest light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 22,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ २२ ॥",
        hindiCommentary = """
            हे शक्ति के अक्षय पुंज इन्द्रदेव! आप हमारी श्रद्धापूर्ण स्तुतियों से प्रसन्न होकर हमारे प्रति अत्यंत दयालु और अनुग्रहपूर्ण भाव रखते हुए यहाँ पधारें। 
            आप अपनी महान और अत्यंत विस्तार वाली रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के इस यज्ञ में सहायक और रक्षक बनकर साक्षात् आएं। 
            आपकी पावन उपस्थिति हमारे भीतर के सुप्त आत्मविश्वास को जागृत करती है और हमें जीवन की बड़ी से बड़ी विपदाओं से सफलतापूर्वक लड़ने का साहस प्रदान करती है। 
            जब आप हमारे पक्ष में और हमारे साथ खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति, शत्रु या बाधा हमें पराजित करने का साहस तनिक भी नहीं कर सकती। 
            हे देवराज, आप हमारे अज्ञान रूपी घोर अंधकार को अपनी दिव्य ज्योति से मिटाकर हमारे जीवन में वास्तविक ज्ञान, विवेक और आत्मिक प्रकाश फैलाने की कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा दुर्ग का निर्माण करती हैं जिसमें केवल सुख, अखंड शांति और पवित्रता का ही निरंतर वास होता है। 
            हम अपनी विनम्र, निष्कपट और आर्त पुकार से आपको निरंतर पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी अनंत उदारता और वैभव से पूर्ण कर दें। 
            आप ही वह सर्वोच्च और आदि शक्ति हैं जो हमारे प्रत्येक परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी अनंत महिमा और ऐश्वर्य के साथ हमारे घर और हृदय के सिंहासन पर विराजें और हमें सदैव अपनी दिव्य सुरक्षा की शीतल छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण, मंगल और सौभाग्य सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धा और प्रेम से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the fountain of infinite energy, being pleased by our devoted hymns and harboring a kind and graceful intent toward us, please come here. 
            Arrive in our lives as a helper and guardian along with your grand and immensely vast protective powers and divine assistances (Mahibhih Utibhih). 
            Your holy presence awakens the dormant self-confidence within us and grants us the courage required to successfully battle the greatest life calamities. 
            When you stand on our side and with us, no negative force, enemy, or obstacle in the world can ever dare to defeat or even disturb our inner peace. 
            O King of Gods, erase the deep darkness of our ignorance with your divine light and spread the radiance of true knowledge and wisdom in our lives. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness, peace, and purity reside continuously. 
            We invoke you with our humble, sincere, and desperate cries so that you may fulfill every single scarcity of our existence with your infinite generosity. 
            You are the supreme and primordial power that makes our every effort meaningful and carries us forward on the path of evolution and growth. 
            O Indra, reside on the throne of our homes and hearts with your infinite glory and splendor, and keep us forever safe under your divine protection. 
            Our ultimate well-being, auspiciousness, and good fortune are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 23,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ २३ ॥",
        hindiCommentary = """
            हे श्रेष्ठ भक्तों! आप उन अद्भुत, तेजस्वी और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो पवित्र सोमरस का पान कर अत्यंत आनंदित और प्रमुदित होते हैं। 
            वे हमें ऐश्वर्य, सुख और दिव्य धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महान महिमा भक्तों की श्रद्धापूर्ण वाणी से निरंतर विकसित और विस्तारित होती है। 
            जैसे गौएँ और माताएं अपने प्रिय बछड़े की ओर अगाध प्रेम और वात्सल्य भाव से दौड़ती हैं, वैसे ही हमारी स्तुतियां और हृदय की पुकार इन्द्र की ओर प्रवाहित होती हैं। 
            आपकी दिव्य उपस्थिति मात्र से हमारे मन की समस्त चंचलता, अशांति और संशय समाप्त होते हैं और हम एकाग्र होकर आपकी असीम सत्ता का साक्षात् अनुभव करते हैं। 
            हे शक्तिशाली इन्द्र, आप हमारे जीवन रूपी यज्ञ के अविचल आधार हैं और हमारे संपूर्ण अस्तित्व को ऊर्जस्वित करने वाले परम तेजस्वी और अजेय देव हैं। 
            जैसे बछड़ा अपनी माता से पोषण, सुरक्षा और जीवन प्राप्त करता है, वैसे ही हम आपकी असीम कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्रचुर मात्रा में प्राप्त करते हैं। 
            आपकी उदारता की कोई सीमा नहीं है; आप अपने प्रत्येक शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके सर्वांगीण, श्रेष्ठ और दिव्य विकास के लिए अनिवार्य है। 
            हम अपनी मधुर, सत्यनिष्ठ और भक्तिपूर्ण वाणी से आपको प्रसन्न करने का निरंतर प्रयास करते हैं ताकि आप हमारे जीवन के समस्त क्लेशों और दुखों का अंत कर सकें। 
            इन्द्रदेव की पावन शरण में आने वाला साधक कभी रिक्त, निर्बल या असहाय नहीं रहता, उसे ज्ञान के अखंड प्रकाश और अनंत वैभव का दुर्लभ वरदान प्राप्त होता है। 
            हे देवराज, आप हमारे हृदयों में अनन्य भक्ति, प्रेम और निष्कामता का संचार करें और हमें सदैव अपनी दिव्य सुरक्षा की छाया में सुरक्षित, सुखी और संतुष्ट रखें।
        """.trimIndent(),
        englishCommentary = """
            O excellent devotees, praise the wonderful, radiant Lord Indra, the subduer of all foes, who rejoices in the consumption of the sacred Soma nectar. 
            He remains ever ready to bestow abundance, joy, and divine prosperity upon us, and his great glory is continuously expanded by our devoted hymns. 
            Just as cows and mothers run with profound love and maternal affection toward their beloved calf, our hymns and heartfelt cries flow toward Indra. 
            Your divine presence alone terminates all the restlessness, turmoil, and doubts of our minds, allowing us to experience your infinite existence with focus. 
            O Mighty Indra, you are the immovable foundation of the sacrifice of our lives and the supremely radiant and invincible deity who energizes our being. 
            As a calf receives vital nourishment, protection, and life from its mother, we receive spiritual peace and material plenty through your divine grace. 
            There is no limit to your generosity; you bestow upon every surrendered devotee everything that is mandatory for their holistic and divine development. 
            We strive to please you with our sweet, truthful, and devoted voices so that you may bring a definitive end to all the afflictions and sorrows of our life. 
            A seeker who takes refuge in Lord Indra never remains empty, weak, or helpless; they are blessed with the light of knowledge and infinite splendor. 
            O King of Gods, infuse our hearts with exclusive devotion, love, and selflessness, and keep us forever protected and happy under your divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 24,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ २४ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों, ऋषियों और विद्वानों द्वारा अपनी पवित्र और ओजस्वी स्तुतियों के माध्यम से निरंतर संवर्धित और प्रदीप्त किए जाने वाले महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह अजेय शक्ति, प्रचुर अन्न, स्वास्थ्य और विजय लेकर आने की कृपा करें जो हमारे जीवन को प्रत्येक दृष्टि से पूर्णतः उन्नत बना सके। 
            आप हमारे लिए एक परम कल्याणकारी और अत्यंत आत्मीय मित्र (सखा) बनकर हमारे जीवन की इस दुर्गम और चुनौतीपूर्ण यात्रा को अत्यंत सुगम और सफल बनाएं। 
            आपकी यह दिव्य मित्रता संसार के सभी अस्थायी, क्षणभंगुर और स्वार्थी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त को नहीं त्यागते। 
            हे देव, हमें वह अटूट आत्मबल और साहस प्रदान करें जिससे हम जीवन के भीषण संघर्षों में विजयी होकर समाज और राष्ट्र में एक गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों, परिवारों और समाज में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव होने की स्थिति न आए। 
            जब आप हमारे सखा और मार्गदर्शक बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक, मानसिक या भौतिक मार्ग में कभी भी रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम, त्याग और पुरुषार्थ को ईश्वरीय फल और महान दिव्य सफलता में बदलने वाले देव हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह, अटूट आशा और उच्च चेतना बनकर बहती है, जो हमें सदैव श्रेष्ठ, पवित्र और परोपकारी कर्म करने के लिए निरंतर प्रेरित करती है। 
            हे इन्द्र, आप हमारे परम रक्षक और गुरु के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, ज्ञानी, यशस्वी, धर्मनिष्ठ और परोपकारी बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the magnificent deity who is continuously increased and glorified through the powerful hymns of men, sages, and scholars. 
            Graciously bring to us very quickly that invincible power, abundant nourishment, health, and victory which will elevate our lives in every aspect. 
            Become a supremely benevolent and highly intimate friend to us, making this difficult and challenging journey of life smooth, easy, and successful. 
            Your divine friendship is superior to all temporary, fleeting, and selfish worldly relationships because you never abandon your devotee in distress. 
            O God, provide us with the unshakable inner strength and courage required to emerge victorious in life's fierce struggles and attain a dignified position. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources, joy, or peace within our homes and society. 
            When you become our companion and guide, no major obstacle of the world can ever block our spiritual, mental, or material progress and evolution. 
            We worship you with deep devotion, for it is you who transforms our hard labor, sacrifice, and efforts into divine results and magnificent successes. 
            Your energy flows through our being as enthusiasm, hope, and higher consciousness, perpetually inspiring us to perform noble and altruistic deeds. 
            O Indra, stay with us as our protector and teacher, graciously making us magnificent, knowledgeable, successful, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 25,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ २५ ॥",
        hindiCommentary = """
            हे वृत्रहन् (अज्ञान और समस्त बुराइयों का नाश करने वाले) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में अपनी असीम दया और कृपा के साथ अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के प्रत्येक संघर्ष में एक सजग सहायक और रक्षक बनकर आएं। 
            आपकी दिव्य उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता और ईश्वरीय शक्ति प्रदान करती है जिससे हम जीवन की किसी भी कठिन परिस्थिति में कभी नहीं डगमगाते। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति, नकारात्मक ऊर्जा या बाधा से तनिक भी भयभीत होने की तनिक भी आवश्यकता नहीं है। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का समूल नाश कर हमारे मन में ज्ञान और विवेक की निर्मल और पवित्र गंगा प्रवाहित करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा दुर्ग बनाती हैं जिसमें कोई भी बुराई, पाप, रोग या मानसिक विकार कभी भी प्रवेश नहीं कर सकता। 
            हम अपनी विनम्र और हृदयस्पर्शी प्रार्थनाओं से आपको निरंतर पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से सदा के लिए मिटा सकें। 
            आप ही वह सर्वोच्च और आदि शक्ति हैं जो हमारे प्रत्येक परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता और वैभव के साथ हमारे घर और हृदय में विराजें और हमें अपने मंगलकारी और दिव्य आशीषों से निरंतर कृतार्थ करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण, सुख और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार अत्यंत श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra (the forces of ignorance and evil), please do come graciously to our sacrificial ground and take our side. 
            Arrive in our lives as a vigilant helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your sacred presence provides our resolutions with that steel-like firmness and divine strength needed to remain unshaken in any situation. 
            When you are with us, there is absolutely no need for us to fear any demonic force, negative energy, or obstacle that the material world presents. 
            O King of Gods, graciously destroy the Vritra of ignorance within our hearts and let the pure and holy river of knowledge flow within our minds. 
            Your protective energies build such an impenetrable shield around us that no form of evil, sin, disease, or mental affliction can ever enter. 
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your divine light forever. 
            You are the supreme and primordial power that makes our every effort meaningful and carries us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your infinite generosity and splendor, and bless us with your most auspicious and divine favors. 
            Our complete well-being, happiness, and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 26,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ २६ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि और विवेक हैं, आप ही हमारे परम पिता और आप ही हमारी करुणामयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र सच्चे हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन और पोषण कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के ज्ञात और अज्ञात संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म और स्थूल देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन और जटिल निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से सफलतापूर्वक बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और प्रेम की कोई सीमा नहीं है, और हम एक समर्पित संतान के रूप में आपकी पावन वंदना निरंतर करते हैं। 
            आपकी असीम कृपा से ही हमें वह मानसिक शांति और स्थिरता प्राप्त होती है जो संसार की किसी भी नश्वर और भौतिक वस्तु में अत्यंत दुर्लभ और अप्राप्य है। 
            हम अपनी संपूर्ण श्रद्धा, प्रेम और अडिग विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित और सुखी रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान के अखंड प्रकाश से भी आलोकित करने की कृपा करें। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को समूल नष्ट कर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाने की महान कृपा करे।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are established as our superior intellect and discernment, our supreme Father, and our most affectionate and merciful Mother. 
            You have manifested in our lives as the foundation of our entire existence and our only true well-wisher, continuously nurturing and nourishing us. 
            Just as parents protect and nourish their innocent child from all kinds of known and unknown dangers, you take care of our subtle and physical needs. 
            We seek from you that 'Sumnam' (supreme bliss and spiritual peace) which is only granted to true and sincere devotees seeking your holy refuge. 
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the illusory web of ignorance. 
            O King of Gods, there is no limit to your maternal affection and love for us, and we worship you with the simple heart of a dedicated child. 
            By your boundless grace alone do we find the mental tranquility and stability that is extremely rare and unattainable in any perishable worldly object. 
            We offer our complete faith, love, and unwavering trust at your divine feet so that you may forever keep us fully safe and happy within your shadow. 
            O Indra, bring abundance into every field of our existence and make us successful while illuminating us with the light of Self-realization. 
            May your radiant stream completely destroy the root of our ignorance and successfully lead us to the realization of the Supreme Truth and God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 27,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ २७ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद, तृप्ति और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस संपूर्ण ब्रह्मांड के कण-कण में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और अपार श्रद्धा के साथ आपकी अनन्य सेवा, भक्ति और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण चराचर जगत और इसकी समस्त सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य, न्याय और धर्म की रक्षा कर सकें। 
            जैसे वर्षा की शीतल बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव, दुख और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक एवं आध्यात्मिक समृद्धि से सदा के लिए परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति और अटूट साहस प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ और कठिन है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव परमात्मा के समीप रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, satisfaction, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial ritual, we offer our exclusive service with hymns and deep faith to please and glorify your supreme divinity. 
            It is through your divine energy that this entire moving and non-moving universe is governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Truth and Dharma. 
            Just as the thirsty earth is satisfied by cool raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and holistic prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is totally rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 28,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ २८ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर के रूप में प्रतिष्ठित हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन एवं शक्तिशाली स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का निरंतर प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और दिव्य ओज का जागरण होता है, जिससे वह जीवन के प्रत्येक क्षेत्र में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण और सम्मानित स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए परम कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और अखंड आत्मिक शांति का दिव्य अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को महान दिव्य आशीर्वादों में बदलने का सामर्थ्य रखती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का दुर्लभ वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी, सुखी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O devotees who know the divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns, and no being can ever surpass the limit of his might. 
            Indra is the supreme authority who utilizes his fierce and invincible power to maintain the justice, discipline, and balance of the universe. 
            Singing his glories with devotion awakens the dormant courage, heroism, and vigor within a person, enabling them to emerge victorious in life. 
            O God, remove every dark aspect of our existence and bestow upon us that brilliance which allows us to attain a place of honor in society. 
            By your grace, let us receive that wealth which is earned strictly by following the path of Truth and which is beneficial for all of humanity. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God and spiritual peace. 
            You are the supreme power that transforms our hard labor into divine results and our desperate prayers into magnificent celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless; they are blessed with the sharpness of self-knowledge and abundance. 
            O Indra, stay with us as our protector and eternal guide, and graciously make us great, successful, renowned, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 29,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ २९ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों और साधकों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के परम पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए सादर आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय और अजर बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त आंतरिक शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें पूर्णतः निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends and fellow seekers, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our internal enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 30,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ३० ॥",
        hindiCommentary = """
            समस्त स्तुतियां और प्रार्थनाएं समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अथाह है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और दिव्य सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की महान कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव इस जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत, सचेत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक, रक्षक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग दिखाए, यही हमारी विनम्र प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मिक रूप से सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and unfathomable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and divine charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 31,
        sanskrit = "मक्षू देववतो रथः शूरो वाजेषु सासहिः ।\nइन्द्रस्य सख्ये शिवो भव ॥ ३१ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! जिस भक्त का रथ आपकी कृपा और देवताओं के आशीर्वाद (देववतः) से चलता है, वह युद्धों में शीघ्र विजयी और शूरवीर होता है। 
            आप हमारे लिए एक कल्याणकारी मित्र (शिवः सखा) बनकर हमारे जीवन के संघर्षों में हमारी सहायता करें और हमें शक्ति प्रदान करें। 
            यह मंत्र जीवन की चुनौतियों के प्रति एक सक्रिय और वीर दृष्टिकोण रखने की प्रेरणा देता है, जहाँ ईश्वर का सान्निध्य ही वास्तविक विजय है। 
            जब हम आपकी शरण में होते हैं, तो हमारा जीवन रूपी रथ कभी भी मार्ग से नहीं भटकता और हम सफलता के शिखर पर पहुँचते हैं। 
            आपकी मित्रता संसार के सभी अस्थायी संबंधों से कहीं अधिक मूल्यवान है, क्योंकि आप हमें कभी भी अकेला नहीं छोड़ते। 
            हे देवराज, आप हमारे भीतर वह अदम्य साहस भर दें जिससे हम अधर्म और अन्याय के विरुद्ध डटकर खड़े होने में सक्षम हो सकें। 
            आपकी कृपा दृष्टि से हमारे जीवन के प्रत्येक कार्य में शुभता का संचार हो और हम समाज के लिए एक आदर्श बनें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपका मार्गदर्शन हमें अंधकार से प्रकाश की ओर सफलतापूर्वक ले जा सके। 
            इन्द्रदेव की अजेय शक्ति हमें यह विश्वास दिलाती है कि अंततः धर्म की ही विजय होती है, चाहे परिस्थितियाँ कितनी भी कठिन क्यों न हों। 
            हे इन्द्र, आप हमारे परम रक्षक हैं, हमें अपनी दिव्य ज्वाला में तपाकर शुद्ध करें और हमें दिव्यता के पवित्र शिखर पर पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, the chariot of that devotee who is blessed by the gods (Devavatah) becomes swift and heroic in battles. 
            Become an auspicious and benevolent friend (Shivah Sakha) to us, assisting us in our life's struggles and granting us immense power. 
            This mantra inspires an active and heroic perspective toward life's challenges, emphasizing that divine company is the true victory. 
            When we take refuge in you, the chariot of our life never deviates from the righteous path and we reach the pinnacle of success. 
            Your friendship is far more valuable than any temporary worldly relationship, for you never leave your devotee alone or helpless. 
            O King of Gods, fill us with that indomitable courage which enables us to stand firmly against unrighteousness and injustice. 
            By your grace, let auspiciousness permeate every single act of our lives, allowing us to become ideal models for society. 
            We worship you with devotion so that your guidance leads us successfully from the depths of darkness to the heights of light. 
            The invincible power of Indra reassures us that Dharma ultimately triumphs, regardless of how daunting the circumstances may seem. 
            O Indra, you are our supreme protector; refine us in your divine flame and lead us to the holy and magnificent heights of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 32,
        sanskrit = "त्वं वलस्य गोमतोऽपावरद्रिवो बिलम् ।\nत्वां देवा अबिभ्युषस्तुज्यमानास आविशुः ॥ ३२ ॥",
        hindiCommentary = """
            हे वज्रधारी (अद्रिवो) इन्द्र! आपने गौओं को छिपाने वाले वल नामक असुर की गुफा (बिलम्) के द्वार को अपनी प्रचंड शक्ति से खोल दिया। 
            भयभीत और दुखी होकर जब अन्य देवताओं ने आपकी शरण ली, तब आपने उन्हें अभय प्रदान किया और उन्हें असुरों के प्रभाव से मुक्त किया। 
            यह मंत्र अज्ञान के आवरण को भेदने और ज्ञान की किरणों (गौओं) को मुक्त करने की उस आध्यात्मिक प्रक्रिया का सुंदर चित्रण है। 
            वल असुर हमारे भीतर की उस जड़ता और संकीर्णता का प्रतीक है जो हमारे वास्तविक आनंद और ज्ञान को रोककर रखती है। 
            हे देव, आप अपने ज्ञान रूपी वज्र से हमारे भीतर के अंधकार को नष्ट कर हमें सत्य के वास्तविक दर्शन कराने की कृपा करें। 
            जब आप हमारे रक्षक बनते हैं, तो संसार की कोई भी नकारात्मक शक्ति हमें भयभीत नहीं कर सकती और हम निर्भीक हो जाते हैं। 
            आपकी विजय ही हमारी विजय है, और हम आपकी जय-जयकार करते हुए स्वयं को आपके दिव्य और कल्याणकारी कार्यों के लिए समर्पित करते हैं। 
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और समाज में नैतिकता ला सकें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की श्रद्धा से वंदना करते हैं। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के शाश्वत और दिव्य प्रकाश की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O wielder of the thunderbolt (Adrivo) Indra, you shattered the cave (Bilam) of the demon Vala, who had hidden the cows of light. 
            When the fearful and suffering gods sought your shelter, you granted them fearlessness and liberated them from demonic influence. 
            This mantra is a beautiful depiction of the spiritual process of piercing through the veil of ignorance to release the rays of wisdom. 
            The demon Vala represents the lethargy and narrowness within us that blocks our true joy and prevents us from attaining knowledge. 
            O God, with the thunderbolt of your wisdom, destroy our internal darkness and graciously allow us to perceive the actual Truth. 
            When you become our guardian, no negative force in the world can intimidate us, and we become truly courageous and bold. 
            Your victory is our victory, and as we hail your name, we dedicate ourselves to your divine and benevolent purposes. 
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to establish morality in society. 
            Our complete well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power. 
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Supreme Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 33,
        sanskrit = "यं ते स्तोमं चर्कृम वत्सो न विप्र इन्द्रयन् ।\nस नः पवस्व रयिमूर्मिणा सुतः ॥ ३३ ॥",
        hindiCommentary = """
            हे सोम! जैसे वत्स (बछड़ा) अपनी माता की इच्छा करता है, वैसे ही हम भक्त इन्द्र की कामना करते हुए आपकी दिव्य स्तुति करते हैं। 
            आप हमारे लिए पवित्र होकर अपनी शक्तिशाली लहरों (ऊर्मिणा) के साथ वह ऐश्वर्य (रयिम्) लेकर आएं जो हमारे जीवन को सार्थक बना सके। 
            यह मंत्र भक्त की ईश्वर के प्रति उस अनन्य पुकार को दर्शाता है जहाँ वह संसार की वस्तुओं के बजाय केवल सत्य को पाना चाहता है। 
            आपकी यह पावन धारा हमारे अंतःकरण के समस्त मलों को धोकर हमें दिव्यता, अखंड शांति और ईश्वर के सान्निध्य का अनुभव कराए। 
            जैसे सोम छननी से छनकर शुद्ध होता है, वैसे ही हमारे संकल्प भी आपकी शक्ति से परिष्कृत होकर शुभ फल प्रदान करने वाले बनें। 
            हे देव, आप हमारे यज्ञ को सफल बनाएं और हमारे श्रेष्ठ विचारों को देवताओं के महान आशीर्वादों के साथ सफलतापूर्वक जोड़ दें। 
            हमारी वाणी में वह ओज और तेज भर दें कि हमारी भक्तिपूर्ण पुकार सीधे आपके और इन्द्र के हृदय के गहन स्तरों तक पहुँच सके। 
            आप ही वह अमृत हैं जो मृत्यु के भय को समाप्त कर मनुष्य को अमरता और मोक्ष के परम पथ पर निरंतर अग्रसर करता है। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन और परिवार में सदैव निरंतर बना रहे। 
            हे पवमान सोम, आप हमारे रक्षक और मार्गदर्शक बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च शिखर पर पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, just as a calf (Vatsa) longs for its mother, we devotees chant your praises while yearning for the presence of Indra. 
            Flow in your purified state and bring to us, with your powerful waves (Urmina), that prosperity (Rayim) which makes life meaningful. 
            This mantra reflects the exclusive call of a devotee toward God, where they seek Truth rather than worldly and perishable objects. 
            May your holy stream wash away all the stains of our inner self, filling us with divinity, peace, and the presence of God. 
            Just as Soma is refined through the filter, may our resolutions also be refined by your power to yield auspicious results. 
            O God, make our sacrifice successful and connect our noble thoughts with the magnificent blessings of the celestial gods. 
            Fill our voices with such vigor and brilliance that our devoted calls reach the deepest levels of your heart and Indra's heart. 
            You are the divine nectar that terminates the fear of death and worldly sorrows, driving humans forward toward immortality. 
            We worship you with devotion so that the nectar-like flow of your immense generosity remains forever constant in our lives. 
            O Pavamana Soma, stay as our supreme protector and guide, leading us graciously to the highest peaks of success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 34,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ३४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों और अनुष्ठानों के मुख्य पुरोहित और देवताओं को बुलाने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और हितैषी हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव बचाकर रखें। 
            आपकी हितकारी दृष्टि हमें पतन के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध और कल्याणकारी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख और धर्मनिष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और मानवता के मार्ग पर चलने की प्रेरणा देती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव कर सकें। 
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 35,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ३५ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव सुखी रहें। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान बनाएं। 
            जब हमारा मन आपकी भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the destructive fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 36,
        sanskrit = "यज्ञैः संमिश्रः स नो अग्निः सख्ये शिवो भव ।\nपवमानो नः पावकः ॥ ३६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप यज्ञों में देवताओं के साथ पूर्णतः सम्मिश्रित होकर हमें अपनी पवित्र और अचल मित्रता (सख्ये) प्रदान करने की कृपा करें। 
            आप हमारे लिए एक परम कल्याणकारी (शिवः) मित्र बनकर हमारे जीवन के प्रत्येक संघर्ष और कठिन परिस्थिति में हमारा सहयोग करें। 
            आपकी पावनता और निर्मलता हमारे अंतःकरण को निरंतर शुद्ध करती रहे और हमें बुराइयों के प्रभाव से सदैव बचाकर रखे। 
            मित्रता वही श्रेष्ठ है जो हमें आध्यात्मिक उन्नति की ओर ले जाए, और आपकी मित्रता हमें साक्षात् ईश्वर की चेतना से जोड़ती है। 
            हे देव, आप हमारे जीवन के प्रत्येक अनुष्ठान को सफल बनाने के लिए सदा हमारे सहायक, रक्षक और दिव्य सारथी बनकर रहें। 
            आपकी हितकारी दृष्टि हमें संशयों के गहन अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा और धर्म की शक्ति प्रदान करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आपकी मित्रता हमारे जीवन के समस्त दुखों, पापों और क्लेशों को नष्ट कर दे। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवार और समाज में वास्तविक शांति, प्रेम और दिव्यता का आधार निर्मित करते हैं। 
            आपकी ऊर्जा हमारे प्राणों में चेतना बनकर प्रवाहित होती है और हमें सदैव धर्म के मार्ग पर दृढ़तापूर्वक चलने के लिए प्रेरित करती है। 
            हे अग्नि, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की नश्वर वस्तुओं में सर्वथा दुर्लभ है।
        """.trimIndent(),
        englishCommentary = """
            O Agni, being completely united with the gods in the sacrifice, please graciously grant us your sacred and unwavering friendship (Sakhye). 
            Become a supremely benevolent (Shivah) friend to us and support us through every struggle and difficult situation of our lives. 
            May your holiness and purity continuously refine our inner self and keep us safely protected from the influence of evil and vice. 
            The best friendship is one that leads toward spiritual evolution, and your friendship connects us directly with divine consciousness. 
            O God, always remain our helper, protector, and divine charioteer to ensure that every noble undertaking of our life is successful. 
            Your benevolent gaze pulls us out of the dense darkness of doubt and grants us the power of integrity and the strength of Dharma. 
            Just as fire burns away impurities, may your friendship destroy all the sorrows, afflictions, and past sins from our existence. 
            We worship you because you are the one who builds the foundation of true peace, love, and divinity within our family and society. 
            Your energy flows through our lives as consciousness, inspiring us to always walk firmly on the righteous path of the Eternal Law. 
            O Agni, become our closest and most intimate relative and grant us that divine bliss which is rare in the perishable things of the world.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 37,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ३७ ॥",
        hindiCommentary = """
            हे पवमान और पावक सोमदेव! आप स्वर्ग की दिव्य कांति के समान अद्भुत और विविध प्रकार के ऐश्वर्यों और आध्यात्मिक निधियों के स्वामी हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली अन्न और जीवनी ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन में किसी भी वस्तु का लेशमात्र भी अभाव न रहे और हम सदैव सुख, शांति और समृद्धि से संपन्न बने रहें। 
            हे देव, आप हमारे अंतःकरण के समस्त अंधकार और विकारों को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा के साक्षात् दर्शन कर सकें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन की दरिद्रता और अज्ञान को समाप्त कर हमें प्रचुरता और ज्ञान के सर्वोच्च शिखर पर पहुँचाती हैं। 
            हमें वह 'इषम्' (प्रेरणा और पोषण) प्रदान करें जो हमारे शरीर और आत्मा दोनों को पूर्णतः तृप्त कर हमें दिव्यता की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे समस्त दुखों का नाश होता है और हमें वह नवीन उत्साह मिलता है जो हमें कभी थकने नहीं देता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार और कृपालु दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और ईश्वर की ओर ले जाने वाला सही मार्ग दिखाए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में रखें और हमारा मंगलमय जीवन सदैव आपकी मर्यादा में सुरक्षित रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the master of magnificent and extraordinary riches that shine like celestial luster. 
            For us, your devoted chanters, bring forth that powerful nourishment and vital energy that make our lives meaningful and successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we always remain prosperous, peaceful, and abundant. 
            O God, purify our inner self of all darkness and afflictions and grant us the divine vision to perceive the Presence of the Divine. 
            You are the supreme power that possesses the strength to terminate the poverty and ignorance of our life and lead us to plenty. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our physical body and soul and leads us toward divinity. 
            Singing your glories destroys all our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of our duty. 
            O Soma, come into our homes and hearts as the generous and merciful giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and continuously show us the pathway leading toward fame, splendor, and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever safe within your holy laws.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 38,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ३८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें बचाएं। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त और पवित्र ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक और ब्रह्मांडीय न्याय के सर्वोच्च प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या विचार कभी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति और निरंतर प्रेरणा प्रदान करने वाला होता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible pit of sins and the calamities arising from ignorance and darkness. 
            Those negative forces that wish us harm, please foil all their conspiracies with your supreme intelligence and grant us absolute security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction and absolute purity, leading toward a new spiritual birth for us. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the sentinel of cosmic justice and order. 
            Grant us the inner strength and courage to never walk the path of unrighteousness and to always obey your divine and holy commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and test of life gives us unbreakable courage and deep mental peace and calm. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 39,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ३९ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न हो। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम कल्याण के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा उठें। 
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success. 
            Your friendship is that divine security for us which uproots all the fears, doubts, and sorrows of our wandering mind forever and always. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually higher. 
            O Agni, give us the luster to keep ourselves established in Dharma and to lead a glorious and meaningful life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 40,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ४० ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करें। 
            आप हमें वह जीवनी शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के पुनीत कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता करने के लिए पूर्णतः समर्थ और दयालु बने रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी देते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम आपकी शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदा शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आध्यात्मिक रूप से पूर्ण बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve Dharma. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your guidance. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete and whole.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 41,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ४१ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 42,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ४२ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 43,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ४३ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 44,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ४४ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 45,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ४५ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 46,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ४६ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 47,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ४७ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 48,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ४८ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 49,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ४९ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 50,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ५० ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 51,
        sanskrit = "एतमु त्यं दश यन्तो मृजन्ति सप्त धीतीभिः ।\nअभि प्रियमधारयत् ॥ ५१ ॥",
        hindiCommentary = """
            हे साधकों! जो दस दिशाओं में व्याप्त होने वाली और सात प्रकार की बुद्धियों (सप्त धीतीभिः) से युक्त शक्तियाँ हैं, वे इस सोम को पवित्र करती हैं। 
            यह मंत्र हमारी इंद्रियों और प्राणों के शुद्धिकरण की उस सूक्ष्म प्रक्रिया को दर्शाता है जो हमें ईश्वर के प्रिय और सान्निध्य के योग्य बनाती है। 
            दसों दिशाओं का अर्थ है कि हमारा समस्त बाह्य व्यवहार शुद्ध हो, और सात बुद्धियाँ हमारे आंतरिक चेतना के सात स्तरों का प्रतीक हैं। 
            जब हमारी सोच और दृष्टि पवित्र होती है, तब सोम रूपी आनंद हमारे हृदय के पात्र में स्वतः ही धारण (अधारयत्) हो जाता है। 
            हे सोम, आप अपनी इस पावन धारा से हमारे मन के समस्त विकारों को धोकर हमें दिव्य प्रेम और शांति का अनुभव कराएं। 
            आपकी उपस्थिति हमारे जीवन के प्रत्येक यज्ञ को सफल बनाती है और हमें देवताओं के आशीर्वाद का वास्तविक अधिकारी बनाती है। 
            हमें वह आंतरिक सामर्थ्य प्रदान करें जिससे हम संसार के शोर के बीच भी अपनी आत्मा की पुकार सुन सकें और शांत रहें। 
            आप ही वह शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों में बदलने का अद्भुत और अमोघ सामर्थ्य रखती हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का प्रवाह हमारे जीवन और परिवार में सदैव निरंतर बना रहे। 
            हे पवमान सोम, आप हमारे रक्षक और मार्गदर्शक बनकर हमें सत्य के साक्षात्कार और मोक्ष के परम पद तक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O seekers, the powers pervading the ten directions and endowed with the seven types of intellect (Sapta Dhitibhih) purify this Soma. 
            This mantra depicts the subtle process of purifying our senses and vital breaths, making us worthy of the Divine's love and proximity. 
            The ten directions imply that our entire external conduct should be pure, while the seven intellects symbolize the seven levels of consciousness. 
            When our thought and vision are sanctified, the Soma-like bliss is naturally held (Adharayat) within the vessel of our heart. 
            O Soma, with your holy stream, wash away all the afflictions of our mind and allow us to experience divine love and peace. 
            Your presence makes every sacrifice in our life successful and makes us truly deserving of the magnificent blessings of the gods. 
            Grant us that internal strength through which we can hear the call of our soul even amidst the world's noise and remain calm. 
            You are the power that possesses the capability to transform our subtle intentions into cosmic achievements and realizations. 
            We worship you with devotion so that the flow of your immense generosity remains forever constant and unbroken in our lives. 
            O Pavamana Soma, stay as our protector and guide, leading us toward the realization of Truth and the supreme state of liberation.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 52,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ ५२ ॥",
        hindiCommentary = """
            पवित्र किया जाता हुआ यह सोम अपनी दिव्य धारा के साथ जल रूपी वस्त्रों को धारण कर (अपो वसानो) अत्यंत वेगपूर्वक प्रवाहित हो रहा है। 
            रत्नों और श्रेष्ठ आध्यात्मिक गुणों को धारण करने वाला यह सोम 'ऋत' (ब्रह्मांडीय सत्य) के मूल स्थान पर जाकर अत्यंत गौरव से विराजमान होता है। 
            सोम का जल के साथ मिलन जीवन की सृजनात्मक ऊर्जा और परम शांति के सुंदर एवं सफल समन्वय का साक्षात् प्रतीक है। 
            जैसे सोम ऋत के स्थान पर बैठता है, वैसे ही हमारे प्रत्येक संकल्प भी सत्य, धर्म और न्याय के आधार पर प्रतिष्ठित होने चाहिए। 
            हे देव, आप अपनी इस पावन यात्रा के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे दैवीय आभा से पूरी तरह आलोकित कर दें। 
            आपकी दिव्य उपस्थिति हमारे जीवन के प्रत्येक यज्ञीय कर्म को सफल बनाती है और हमें देवताओं के आशीर्वाद का पात्र बनाती है। 
            हमें वह 'रत्न' (विवेक और प्रज्ञा) प्रदान करें जो हमारे जीवन की दिशा को अंधकार से हटाकर दिव्य प्रकाश की ओर मोड़ दे। 
            जब हम आपकी शरण में होते हैं, तब ब्रह्मांड का परम सत्य हमारे हृदय में स्वतः ही प्रकाशित होने लगता है और हम शांत हो जाते हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा की धारा हमारे परिवार और समाज में सदैव अखंड सुख और शांति लाए। 
            हे पवमान सोम, आप हमारे रक्षक और शाश्वत मार्गदर्शक बनकर हमें मोक्ष और ईश्वर के परम सान्निध्य तक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma flows with its divine stream, appearing as if clothed in the waters (Apo Vasano) as it rushes forward with speed. 
            This bestower of treasures and virtues (Ratnadha) proceeds to seat himself upon the primal source of the cosmic Truth (Rta). 
            The merging of Soma with water symbolizes the beautiful harmony between the creative energy of life and profound spiritual peace. 
            Just as Soma sits at the source of Rta, may our every resolution also be established upon the firm foundations of Truth and Dharma. 
            O God, through this holy journey of yours, purify our inner self and illuminate it completely with your celestial and radiant aura. 
            Your divine presence makes every sacrificial act of our lives successful and makes us worthy of the magnificent blessings of the gods. 
            Bestow upon us those 'gems' of wisdom and discernment that shift our life's direction away from darkness toward divine light. 
            When we are in your refuge, the ultimate Truth of the universe begins to manifest within our hearts naturally and effortlessly. 
            We worship you with devotion so that the stream of your grace always brings happiness and peace to our families and society. 
            O Pavamana Soma, stay as our protector and eternal guide, and graciously lead us toward liberation and the supreme proximity of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 53,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ ५३ ॥",
        hindiCommentary = """
            आँख और कान वाले मित्र भी मन की गति और दिव्य अनुभूतियों के क्षेत्र में एक समान (असमा) नहीं होते हैं, यही प्रकृति का नियम है। 
            कुछ साधक केवल बाहरी सतह तक ही पहुँच पाते हैं, जबकि कुछ गहरे सरोवर के समान ईश्वर के रहस्यों का साक्षात् दर्शन करते हैं। 
            यह मंत्र आध्यात्मिक साधना की गहराई और साधकों की विभिन्न श्रेणियों के बीच के सूक्ष्म और महत्वपूर्ण अंतर को स्पष्ट करता है। 
            केवल शारीरिक इंद्रियों का होना पर्याप्त नहीं है; वास्तविक ज्ञान वही है जो हृदय की गहराई और मन की पूर्ण एकाग्रता से प्राप्त हो। 
            हे सोम, आप हमें वह अंतर्दृष्टि प्रदान करें जिससे हम बाहरी प्रपंचों से हटकर आपके वास्तविक और दिव्य स्वरूप को पहचान सकें। 
            जैसे सरोवर शांत होने पर ही अपना तल दिखाता है, वैसे ही शांत मन ही परमात्मा की छवि को ग्रहण करने में पूर्णतः समर्थ होता है। 
            हम आपकी निरंतर उपासना करते हैं ताकि हमारे संशय दूर हों और हम ज्ञान के उस गहरे सरोवर में डुबकी लगाकर पवित्र हो सकें। 
            आपकी कृपा से ही हमारे भीतर वह पात्रता विकसित होती है जिससे हम दिव्य मंत्रों और सत्यों के साक्षात् द्रष्टा बन पाते हैं। 
            हे आनंद के देवता सोम, आप हमें वह मेधा और प्रज्ञा दें जो हमें संसार के शोर में भी ईश्वर की पुकार सुनने के योग्य बनाए। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन साधारण से असाधारण और पूर्णतः दिव्य बन सके।
        """.trimIndent(),
        englishCommentary = """
            Even friends who possess physical eyes and ears are not equal (Asama) in the realms of mental speed and divine realizations. 
            Some seekers only reach the shallow edges of awareness, while others, like deep lakes, perceive the profound mysteries of the Divine. 
            This mantra clarifies the depth of spiritual practice and the subtle differences between various levels of seekers and their insights. 
            Possessing physical senses is not enough; true knowledge is that which is attained through the depth of the heart and mental focus. 
            O Soma, grant us that inner vision which allows us to look beyond external illusions and recognize your true celestial nature. 
            Just as a lake shows its bottom only when still, a calm mind is the only vessel capable of reflecting the image of the Supreme Being. 
            We worship you continuously so that our doubts vanish and we may dive deep into that profound lake of ultimate wisdom. 
            It is through your grace that the eligibility is developed within us to become direct seers of divine mantras and eternal truths. 
            O Soma, the deity of bliss, grant us that intellect and wisdom which make us capable of hearing God's call amidst the world's noise. 
            We offer our entire faith at your divine feet so that our lives may transform from ordinary existence into an extraordinary journey.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 54,
        sanskrit = "यस्य ते द्युमतो मदा अच्छा विचेतसा ।\nसोम अर्षसि धारया ॥ ५४ ॥",
        hindiCommentary = """
            हे सोम! आपकी वह आनंददायक और मदहोश कर देने वाली धारा, जो विशेष ज्ञान (विचेतसा) से युक्त है, हमारे कल्याण के लिए प्रवाहित हो। 
            आप स्वयं प्रकाशमान हैं, और आपकी धारा हमारे जीवन के अंधकारमय मार्गों को अपनी दिव्य ज्योति से सदा के लिए आलोकित कर देने वाली है। 
            सोम का मद कोई सांसारिक नशा नहीं, बल्कि वह आध्यात्मिक आह्लाद है जो आत्मा को परमात्मा के साथ एकरूप और शांत कर देता है। 
            आपकी यह चेतना हमें वह शक्ति प्रदान करती है जिससे हम जीवन की जटिलताओं को समझकर सत्य का मार्ग चुनने में समर्थ होते हैं। 
            हे देव, आप हमारे यज्ञ में अपनी मधुर धारा के साथ पधारें और हमारे संकल्पों को दिव्यता की मिठास से पूरी तरह भर देने की कृपा करें। 
            जब आपकी कृपा का प्रवाह हमारे जीवन में आता है, तो समस्त दुःख और दरिद्रता कपूर की तरह उड़कर सदा के लिए समाप्त हो जाते हैं। 
            हमें वह 'विचेतस' (विशेष बोध) प्रदान करें जिससे हम संसार के क्षणभंगुर आकर्षणों के प्रति अनासक्त होकर आपके प्रति समर्पित रहें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल मन को ऊर्जावान बनाती हैं और हमें निरंतर प्रगति के पथ पर गतिशील रखती हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी उदारता का प्रवाह हमारे घर और हृदय में सदैव निरंतर बना रहे। 
            हे दिव्य सोम, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, may your exhilarating and intoxicating stream, combined with special wisdom (Vichetasa), flow for our welfare and peace. 
            You are self-radiant, and your current is destined to illuminate the dark pathways of our existence with its eternal light. 
            The exhilaration of Soma is not a worldly intoxication but that spiritual bliss which unifies the individual soul with the Divine. 
            This consciousness of yours provides us with the power to understand life's complexities and choose the path of Truth successfully. 
            O God, manifest within our sacrifice with your sweet stream and fill our resolutions with the sweetness of divine grace and love. 
            When the flow of your grace enters our life, all sufferings and poverty evaporate and terminate forever like camphor in a flame. 
            Grant us that 'Vichetas' (special awareness) through which we remain detached from fleeting attractions and dedicated strictly to you. 
            You are the power that energizes our lethargic minds and keeps us constantly dynamic on the pathway of continuous progress. 
            We worship you with devotion so that the flow of your immense generosity remains forever present within our homes and hearts. 
            O Divine Soma, stay with us as our protector and nourisher, and graciously make our lives magnificent, successful, and full.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 55,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ५५ ॥",
        hindiCommentary = """
            हे पवमान और पावक सोमदेव! आप स्वर्ग की दिव्य कांति के समान अद्भुत ऐश्वर्यों और आध्यात्मिक निधियों के परम अधिपति हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली अन्न और जीवनी ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन में किसी भी वस्तु का लेशमात्र भी अभाव न रहे और हम सदैव सुख, शांति और समृद्धि से संपन्न बने रहें। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा की सर्वव्यापकता का साक्षात् अनुभव कर सकें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन की दरिद्रता और अज्ञान को समाप्त कर हमें प्रचुरता और ज्ञान के सर्वोच्च शिखर पर पहुँचाती हैं। 
            हमें वह 'इषम्' (प्रेरणा और पोषण) प्रदान करें जो हमारे शरीर और आत्मा दोनों को पूर्णतः तृप्त कर हमें दिव्यता की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे दुखों का नाश होता है और हमें वह नवीन उत्साह मिलता है जो कभी कम नहीं होता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो समय के साथ कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव और ईश्वर की ओर ले जाने वाला मार्ग निरंतर दिखाए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में रखें और हमारा मंगलमय जीवन सदैव सुरक्षित और सुखी रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the supreme master of marvelous riches that shine like celestial luster. 
            For us, your devoted chanters, bring forth that powerful nourishment and vital energy that make our lives meaningful and successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we remain forever full of peace and prosperity. 
            O God, purify our inner self and grant us the divine vision to experience the omnipresence of the Supreme Being within ourselves. 
            You are the power that possesses the strength to terminate the poverty and ignorance of our life and lead us to plenty. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our body and soul and leads us toward divinity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of duty. 
            O Soma, come into our homes and hearts as the generous giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and show us the pathway leading toward splendor and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever protected and happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 56,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ५६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त और अज्ञान के संकटों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें बचाएं। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त ज्वालाओं से हमारे भीतर के समस्त दोषों और विकारों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा और पवित्रता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म करती है। 
            हम आपकी शरण में आकर सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक और ब्रह्मांडीय न्याय के प्रहरी हैं। 
            हमें वह आत्मबल प्रदान करें जिससे हम कभी भी अधर्म के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति कभी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस और मानसिक शांति प्रदान करने वाला होता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु से अमरत्व की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always from the terrible pit of sins and the calamities arising from ignorance and darkness. 
            Those negative forces that wish us harm, please foil all their conspiracies with your supreme intelligence and save our existence. 
            O Ageless and Radiant Deity, consume all our internal flaws and mental afflictions from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction and absolute purity, leading toward a new spiritual birth. 
            We seek your refuge and pray for security, for you are the guardian of all worlds and the sentinel of cosmic justice and order. 
            Grant us the inner strength to never walk the path of unrighteousness and to always obey your divine and holy commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle of life gives us unbreakable courage and deep mental peace and calm. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from mortality to immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 57,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ५७ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो कल्याणकारी हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा उठें। 
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन जिएं।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible power is the foundation of our existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of beneficial and holy goals. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward success. 
            Your friendship is that divine security for us which uproots all the fears, doubts, and sorrows of our wandering mind forever and always. 
            We pray to you with devotion so that our life remains dedicated to service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster to keep ourselves established in Dharma and to lead a glorious and meaningful life while serving humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 58,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ५८ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी और जीवनदायी ऐश्वर्य हमारे घर और हृदय में लेकर आने की महान कृपा करें। 
            आप हमें वह जीवनी शक्ति प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म और मानवता के पुनीत कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी देते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदा शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आध्यात्मिक रूप से पूर्ण बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve Dharma. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your guidance. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete and whole.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 59,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ५९ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 60,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ६० ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 61,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ६१ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 62,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ६२ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 63,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ६३ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 64,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ६४ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 65,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ६५ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 66,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ६६ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 67,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ६७ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 68,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ६८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 69,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ६९ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 70,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ७० ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 71,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ७१ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 72,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ७२ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 73,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ७३ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 74,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ७४ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 75,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ७५ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 76,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ७६ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 77,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ७७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 78,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ७८ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 79,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ७९ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 80,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ८० ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 81,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ८१ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 82,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ८२ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 83,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ८३ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 84,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ८४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 85,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ८५ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 86,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ८६ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 87,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ८७ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteousness in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 88,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ८८ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 89,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ८९ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 90,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ९० ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 91,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ९१ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 92,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ९२ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 93,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ९३ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 94,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ९४ ॥",
        hindiCommentary = """
            हे युवा और ऊर्जावान अग्निदेव! आप समस्त प्रकार की समृद्धियों और पुष्टियों के मूल आधार हैं, आप ही उन्हें अपनी दिव्य शक्ति से निरंतर पोषण और बल देते हैं। 
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ने लगते हैं। 
            आपकी असीम कृपा से हमारी मेधा शक्ति और प्रज्ञा प्रखर होती है और हम श्रेष्ठ कार्यों में अपनी बुद्धि का प्रयोग कर लोक-कल्याण के पुनीत कार्यों में सफल होते हैं। 
            हे यविष्ठ्य, आपकी ऊर्जा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, पूर्णता, आरोग्यता और आत्म-संतोष लाने वाली है, हम आपकी इस विराट शक्ति को नमन करते हैं। 
            आपकी उपासना करने से हमारे सभी नेक संकल्प सिद्ध होते हैं और हमें सर्वांगीण विकास प्राप्त होता है, यही आपकी दिव्यता की वास्तविक और महान महिमा है। 
            जैसे अग्नि समिधा पाकर और अधिक प्रदीप्त और तेजस्वी होती है, वैसे ही हमारी आत्मा आपकी प्रेरणा और सान्निध्य से और अधिक बलवान, पवित्र और ओजस्वी होती है। 
            आप हमें वह मानसिक विशालता और उदारता प्रदान करें जिससे हम संकुचित स्वार्थों से ऊपर उठकर संपूर्ण विश्व के मंगल और कल्याण के बारे में सदैव सोच सकें। 
            हमारी चेतना को उस उच्च स्तर तक उठाएं जहाँ हम ईश्वर की सर्वव्यापकता का अनुभव कर सकें और प्रत्येक जीव में आपकी ही छवि के साक्षात् दर्शन कर सकें। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और ईमानदारी को ईश्वरीय आशीर्वाद में परिवर्तित करने का अद्भुत, अमोघ और तात्कालिक सामर्थ्य रखती हैं। 
            हे अग्नि, हम आपकी बार-बार वंदना करते हैं ताकि हमारा जीवन हर दृष्टि से पुष्ट, समृद्ध, सार्थक, यशस्वी और पूर्णतः धर्ममय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Energetic Agni, you are the foundational source of all forms of prosperity and nourishment; you sustain them with your infinite power. 
            As we repeatedly sing your praises and worship you, our intellect and thoughts become vast like the sky, noble, and oriented toward excellence. 
            By your boundless grace, our mental power and wisdom become sharp, enabling us to use our intellect for noble deeds and global welfare. 
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and spiritual being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true and magnificent divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity we meet. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 95,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ९५ ॥",
        hindiCommentary = """
            हे पावक अग्निदेव! आप दिव्य लोकों के स्वामी और समस्त चराचर जगत के ऐश्वर्यों के परम नियंत्रक, अधिपति और अत्यंत उदार प्रदाता के रूप में प्रतिष्ठित हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न, स्वास्थ्य और ऊर्जा लेकर आएं जो हमारे जीवन को सफल और ऊर्ध्वगामी बनाए। 
            आपकी असीम कृपा से हमारे जीवन की दरिद्रता और अभावों का नाश हो और हम केवल भौतिक धन ही नहीं, बल्कि श्रेष्ठ मानवीय और दैवीय गुणों के भी धनी बनें। 
            हे देव, आप हमारे अज्ञान को अपनी प्रखर ज्योति से जलाकर हमें वह सत्य मार्ग दिखाएं जहाँ केवल अखंड शांति, निस्वार्थ प्रेम और दिव्य आनंद का वास हो। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे तुच्छ और छोटे कर्मों को ईश्वरीय फल तक पहुँचाती हैं और हमारे इस मानवीय जीवन को कृतार्थ और सार्थक करती हैं। 
            हमें वह 'इषम्' (शक्तिशाली प्रेरणा) प्रदान करें जिससे हमारे शरीर में नवीन उत्साह और मन में सदैव पवित्र और ऊँचे विचारों का अखंड प्रवाह बना रहे। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और ईश्वर के सान्निध्य के समीप होने लगते हैं। 
            हे अग्नि, आप हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, आरोग्यता और अखंड सौभाग्य प्रदान करने की महान कृपा करने का कष्ट करें। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और आत्मज्ञान का सही मार्ग निरंतर और सफलतापूर्वक दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें वह स्थायी संपत्ति दें जो हमारे इस लोक के साथ-साथ परलोक के मार्ग में भी परम सहायक और सुखद सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            O Purifying Agni, you are the Lord of celestial realms and the supreme controller, master, and generous provider of all worldly riches and wealth. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and ascending. 
            By your boundless grace, let our poverty and scarcities be destroyed, making us wealthy not just with money but with superior divine virtues. 
            O God, burn away our ignorance with your intense light and show us the path of truth where only unbroken peace, love, and joy reside. 
            You are the supreme power that carries our humble and small deeds to divine results and makes our human existence truly blessed and fulfilled. 
            Provide us with 'Isham'—powerful inspiration—so that fresh enthusiasm remains in our bodies and noble thoughts flow in our minds. 
            Singing your glories purifies our inner self and initiates our constant spiritual awakening and proximity to the realization of the Divine. 
            O Agni, remove every lack from our lives and graciously grant us completeness, health, and unbroken auspiciousness for our families and homes. 
            Let your radiance illuminate every dark corner of our existence and continuously show us the pathway to fame, splendor, and Self-knowledge. 
            We pray with devotion that you grant us that permanent wealth which assists us both in this world and in our spiritual journey beyond.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 96,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ९६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों, संकल्पों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा अटूट संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी रक्षक देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा, आधार और केंद्र हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखने की कृपा करें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और अखंड शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र, कल्याणकारी और फलदायी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और सर्वोच्च रक्षक देव के रूप में प्रतिष्ठित हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और निस्वार्थ मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में पूरी तरह सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीर्वादों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में तन्मयता से लगे रहें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are the chief priest (Hotar) of all human rituals and the divine and holy messenger who invokes the celestial gods to the sacrifice. 
            While residing among us mortals, you connect us with the gods of heaven; you are indeed our most sincere and supreme well-wishing deity. 
            Without your sacred presence, no sacrifice, resolution, or auspicious deed of ours can ever be completed, for you are its very soul and base. 
            O God, develop divine and virtuous tendencies within us and always keep us safely protected from the influence of evil and demonic ways. 
            Your benevolent gaze steers us away from the path of downfall and ignorance, leading us successfully toward progress, joy, and peace. 
            Just as fire consumes and destroys all impurities, please make all our physical and mental actions pure, holy, and beneficial for the world. 
            We worship you because you are the main pillar and protector of unity, love, happiness, and religious devotion within our families and homes. 
            Your divine energy flows through our lives as consciousness, perpetually inspiring us to walk the path of Truth, Justice, and Humanity. 
            O Agni, become our supreme teacher and guide, showing us that Truth where we can successfully experience the omnipresence of the Divine. 
            By your grace, let our lives be filled with divine blessings and let us stay engaged in the holy acts of selfless service and protection of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 97,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ९७ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की महान कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव एक सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना और विचलित करना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करने का कष्ट करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित बनाए रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी मानसिक शांति से विचलित नहीं कर सकती। 
            आप ही वह शक्ति हैं जो हमारे भीतर के अंधकार को नष्ट कर हमें आत्मज्ञान और ईश्वर के समीप ले जाने वाले वास्तविक मार्ग का साक्षात् दर्शन कराती हैं। 
            हमें वह साहस और अभय प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रहें और निर्भीक होकर एक आदर्श और गौरवशाली मानवीय जीवन व्यतीत करें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम सदैव सात्विक बने रहें और ईश्वर के अनंत आनंद और परम शांति का निरंतर अपने हृदय में अनुभव करते रहें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Agni, please calm all the malice, anger, restlessness, and doubts of our mind, making it extremely pure, holy, and serene. 
            Graciously grant us that firm, unshakable, and steady faith which allows us to trust in the just laws of the Divine and lead a happy life. 
            Protect us from all negative forces and thoughts that place hurdles in our path and attempt to sway us from the path of Dharma. 
            It is only by your grace that a human heart fills with selfless love and compassion for all living beings; grant us such a vast heart. 
            O God, faith is the divine key that reveals the mysteries of the Divine; please keep the flame of this faith always alive and unbroken within us. 
            Instead of burning in the fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 98,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ९८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति, धैर्य और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces or enemies that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, fresh energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 99,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ९९ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम और श्रद्धापूर्ण आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर सदैव विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या कोई भी बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की महान कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम मंगल के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर बनाए रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता, सुख और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा और श्रेष्ठ उठें। 
            हे अग्नि, हमें वह तेज और ओज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness and victory. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our entire existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success and light. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually and morally higher. 
            O Agni, give us the luster and vigor to keep ourselves established in Dharma and to lead a glorious life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 100,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ १०० ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करने का कष्ट करें। 
            आप हमें वह जीवनी शक्ति, ऊर्जा और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म, ज्ञान और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें अखंड आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की असीम कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन, सुख-सुविधा या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी प्रदान करते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी दिव्य शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहने की कृपा करें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदैव आंतरिक रूप से शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, धर्मनिष्ठ और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun itself. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve knowledge. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others in need. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward Truth and liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your divine care. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    )
)