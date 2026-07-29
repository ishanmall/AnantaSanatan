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
fun PurvarchikaAdhyayaFiveScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            purvarchikaAdhyayaFiveData
        } else {
            purvarchikaAdhyayaFiveData.filter {
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
                        Text("पंचम अध्याय - ऐन्द्र पर्व (उत्तर)", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFD1C4E9) // Soft Purple/Deep Sky tint for Indra
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
                .background(Color(0xFFF3E5F5)),
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



val purvarchikaAdhyayaFiveData = listOf(
    PurvarchikaVerse(
        id = 1,
        sanskrit = "त्वामिद्धि हवामहे सातौ वाजस्य कारवः ।\nत्वां वृत्रेषु इन्द्र सत्पतिं नरस्त्वां काष्ठास्वर्वतः ॥ १ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! हम स्तोता और यज्ञ करने वाले भक्त, संग्राम में विजय और प्रचुर ऐश्वर्य की प्राप्ति के लिए केवल आपको ही पुकारते हैं।
            आप ही वह 'सत्पति' (सज्जनों के स्वामी) हैं जो वृत्रासुर जैसे भयंकर शत्रुओं का नाश कर हमें धर्म की रक्षा का सामर्थ्य प्रदान करते हैं।
            युद्ध के मैदान में और जीवन की कठिन परीक्षाओं में, पराक्रमी वीर योद्धा केवल आपकी ही दिव्य शक्ति का आह्वान करते हैं।
            जैसे वेगवान अश्व लक्ष्य की ओर दौड़ते हैं, वैसे ही हमारे संकल्प आपकी कृपा से सफलता के सर्वोच्च शिखर की ओर अग्रसर हों।
            आप ही वह शक्ति हैं जो हमारे जीवन के अवरोधों को दूर कर ज्ञान और संपन्नता के मार्ग को प्रशस्त करने वाली हैं।
            हम श्रद्धापूर्वक आपकी शरण में आए हैं क्योंकि आपके बिना विजय और मानसिक शांति प्राप्त करना असंभव है।
            हे देवराज, आप अपनी अमोघ शक्ति के साथ हमारे हृदयों में प्रदीप्त हों और हमें समस्त संशयों से मुक्ति प्रदान करें।
            आपकी प्रसन्नता से ही सृष्टि का चक्र व्यवस्थित रहता है और हमें वर्षा, अन्न तथा उत्तम स्वास्थ्य प्राप्त होता है।
            हम अपनी पवित्र वाणी से आपकी महिमा का गान करते हैं ताकि आपके सान्निध्य में हमारा जीवन सार्थक और मंगलमय बने।
            हे अजेय इन्द्र, आप हमारे परम रक्षक बनकर हमें अंधकार से प्रकाश की ओर ले चलने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, we the chanters and devotees invoke only you for obtaining victory and abundant riches in the battle of life.
            You are the 'Satpati' (Lord of the righteous) who destroys formidable enemies like Vritra and empowers us to protect Dharma.
            In the battlefield and during the toughest trials of existence, mighty warriors seek only your divine and invincible strength.
            Just as swift horses race toward their goal, may our resolutions advance toward the pinnacle of success through your grace.
            You are the supreme power that removes all obstacles from our path and opens the gateway to wisdom and prosperity.
            We seek your refuge with deep devotion because without your aid, attaining victory and mental peace is impossible.
            O King of Gods, ignite your infallible power within our hearts and liberate us from all doubts and anxieties.
            Your satisfaction ensures the balance of the cosmic cycle, granting us rain, nourishment, and superior health.
            We sing your glories with our sacred speech so that our lives become meaningful and auspicious in your holy presence.
            O unconquerable Indra, stay as our supreme protector and lead us from the depths of darkness to the heights of light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 2,
        sanskrit = "अभित्वा शूर नोनुमो दुग्धा इव धेनवः ।\nईशानमस्य जगतः स्वर्दृशमीशानमिन्द्र तस्थुषः ॥ २ ॥",
        hindiCommentary = """
            हे वीर इन्द्रदेव! जैसे दुधारू गौएँ अपने बछड़े की ओर प्रेमपूर्वक रंभाती हुई दौड़ती हैं, वैसे ही हम आपकी निरंतर स्तुति करते हैं।
            आप इस संपूर्ण चराचर जगत के अधिपति हैं, जो जड़ और चेतन दोनों प्रकार की सत्ताओं पर न्यायपूर्वक शासन करने वाले देव हैं।
            आपकी दिव्य दृष्टि स्वर्ग लोक तक व्याप्त है, और आप ही समस्त लोकों के वास्तविक रक्षक और परम नियन्ता के रूप में प्रतिष्ठित हैं।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के गहन अंधकार को दूर कर उसे ज्ञान और सत्य के प्रकाश से भरते हैं।
            आपकी असीम कृपा से ही हमें वह आत्मिक सामर्थ्य प्राप्त होता है जिससे हम अपनी चंचल इंद्रियों और मन पर नियंत्रण पा सकें।
            जैसे गौ अपने दूध से संसार का पोषण करती है, वैसे ही आप अपनी कृपा की वर्षा से अपने भक्तों का सर्वांगीण कल्याण करते हैं।
            आपकी महिमा का गान करने से हमारे भीतर के सोए हुए साहस और वीरता का जागरण होता है, जो हमें कर्मक्षेत्र में विजयी बनाता है।
            हे देवराज, आप हमारे हृदयों में भक्ति का ऐसा अखंड दीपक जलाएं जो अज्ञान की आँधियों में भी कभी न बुझे और हमें राह दिखाए।
            हम श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमें आध्यात्मिक शांति और भौतिक संपन्नता दोनों ही प्रचुरता में प्रदान करें।
            हे अजेय वीर, आप हमारे रक्षक बनकर हमें सदैव धर्म के मार्ग पर दृढ़ रहने की दिव्य शक्ति और प्रेरणा प्रदान करने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O heroic Lord Indra, just as milch cows low affectionately toward their calves, we continuously and devotedly chant your praises.
            You are the sovereign Lord of this entire universe, governing both the moving and the non-moving entities with absolute justice.
            Your divine vision extends to the highest heavens, and you are established as the true protector and controller of all the realms.
            We worship you because you are the deity who removes the deep darkness of our lives and fills them with light and truth.
            It is only through your boundless grace that we receive the strength required to gain total mastery over our senses and mind.
            Just as a cow nourishes the world with its milk, you nourish the well-being of your devotees with the constant showers of grace.
            Singing your glories awakens the dormant courage and heroism within us, enabling us to emerge victorious in the field of action.
            O King of Gods, ignite such an eternal lamp of devotion in our hearts that it never flickers and always guides our pathway.
            We bow before your feet with profound faith so that you may grant us superior prosperity in both spiritual and material aspects.
            O invincible hero, stay as our guardian and graciously provide us with the divine strength to remain firm on the path of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 3,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ ३ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आपके समान शक्तिशाली और दयालु न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न कोई हुआ है और न कभी होगा।
            आपकी महानता अद्वितीय और अतुलनीय है, आप समस्त ब्रह्मांडीय और सांसारिक शक्तियों के सर्वोच्च स्वामी और अजेय रक्षक हैं।
            हम शक्ति, विजय और प्रचुर संसाधनों की कामना करते हुए आपको अपने इस पवित्र यज्ञ में अत्यंत आदर के साथ आमंत्रित करते हैं।
            आप ही वह एकमात्र शक्ति हैं जो हमारे जीवन में पूर्णता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम पूर्ण श्रद्धा से आपकी शरण में हैं।
            आपकी दिव्यता समस्त सीमाओं से परे है, और आप ही 'ऋत' (ब्रह्मांडीय सत्य) के मार्ग के सबसे बड़े संरक्षक और सजग प्रहरी हैं।
            जब हम आपका हृदय से आह्वान करते हैं, तो हमारे भीतर एक नई ऊर्जा का संचार होता है जो हमें समस्त विकारों पर विजय दिलाती है।
            संसार की कोई भी बाधा आपके अजेय वज्र के सामने क्षण भर भी टिक नहीं सकती, आप हमारे मार्ग के समस्त कंटकों को दूर करें।
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और अपने श्रेष्ठ लक्ष्यों को प्राप्त करें।
            आपकी कृपा दृष्टि से हमारा कल्याण और आध्यात्मिक उत्थान सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार हृदय से वंदना करते हैं।
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और अंधकार से शाश्वत दिव्य प्रकाश की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, there is none as powerful and merciful as you in the heavens, nor on earth; none has existed, nor will ever exist.
            Your greatness is unique and incomparable; you are the supreme master and invincible guardian of all cosmic and worldly powers.
            Desiring strength, victory, and abundant resources, we invite you to this sacred sacrifice with the highest degree of respect.
            You are the only power capable of bringing completeness and plenty into our lives; we seek your divine refuge with absolute faith.
            Your divinity transcends all possible boundaries, and you stand as the greatest protector and sentinel of the Cosmic Law (Rta).
            When we invoke you from our hearts, a new surge of energy flows through us, granting us victory over all our inner afflictions.
            No obstacle in this world can withstand your invincible thunderbolt; please remove all the thorns from our life's pathway forever.
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to achieve our noble and grand goals.
            Our well-being and spiritual evolution are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 4,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ४ ॥",
        hindiCommentary = """
            समस्त स्तुतियां और प्रार्थनाएं समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और संसार में प्रकाशित करती हैं।
            वे दिव्य रथियों में सर्वश्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और वंदना की जानी चाहिए।
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं।
            वे हमारे जीवन रूपी रथ के सबसे कुशल सारथी हैं, जो हमें संसार की बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं।
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम शिखर तक पहुँचाने की कृपा करें।
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव ऊँचा रख सकें।
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत होने लगते हैं।
            इन्द्रदेव की शरण में आने वाला साधक कभी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक और मित्र बन जाता है।
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और सच्ची कीर्ति का मार्ग दिखाए।
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast as the ocean.
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion.
            The expanse of Indra's presence is infinite like the sky and the sea, within which all cosmic powers are safely contained.
            He is the most skillful charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world.
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence.
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high.
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and awareness.
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend.
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and true glory.
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 5,
        sanskrit = "स नः शुभः शुभंभर इन्द्रो विश्वाभिरूतिभिः ।\nअस्मे धेहि श्रवश्च्यौतम् ॥ ५ ॥",
        hindiCommentary = """
            हे कल्याणकारी इन्द्रदेव! आप शुभ फल प्रदान करने वाले देव हैं, कृपया अपनी समस्त रक्षात्मक शक्तियों के साथ हमारे जीवन में पधारें।
            आप हमारे जीवन में वह यश और ऐश्वर्य स्थापित करें जो शत्रुओं और नकारात्मक शक्तियों के प्रभाव को जड़ से समाप्त कर देने वाला हो।
            आपकी शुभता हमारे घर और मन को पवित्र करती है, जिससे हमारे भीतर सात्विक गुणों का निरंतर और तीव्र विकास होता है।
            जब आप अपनी महान और अजेय शक्तियों के साथ हमारे सहायक बनते हैं, तो सफलता स्वतः ही हमारे प्रत्येक कार्य का अनुसरण करने लगती है।
            हे देवराज, आप हमारे अज्ञान रूपी शत्रुओं को नष्ट कर हमें वह कीर्ति प्रदान करें जो सत्य पर आधारित हो और स्थायी बनी रहे।
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य कवच बनाती हैं जिसमें कोई भी नकारात्मकता या रोग कभी प्रवेश नहीं कर सकता।
            हम अपनी प्रार्थनाओं से आपकी उस शक्ति का आह्वान करते हैं जो असंभव को भी संभव बनाने और हमें विपदाओं से उबारने का सामर्थ्य रखती है।
            आप ही वह ऊर्जा हैं जो हमारे शिथिल पड़ते संकल्पों में नवीन प्राण और उत्साह फूंकती हैं और हमें जीवन के प्रत्येक क्षेत्र में विजयी बनाती हैं।
            हे इन्द्र, आप अपनी अनंत उदारता के साथ हमारे यज्ञ को सफल बनाएं और हमें आध्यात्मिक उन्नति के मार्ग की ओर ले चलें।
            आपकी कृपा दृष्टि से हमारा भविष्य सुरक्षित और उज्ज्वल है, हम आपकी अजेय और भव्य शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O auspicious Lord Indra, you are the bringer of good fortune; please manifest in our lives with all your protective and divine powers.
            Establish within us that fame and prosperity (Shravah) which has the strength to completely shatter the influence of negative forces.
            Your auspiciousness sanctifies our homes and minds, leading to the rapid development of virtuous and celestial qualities within us.
            When you become our helper with your vast and invincible powers, success and abundance naturally begin to follow our every endeavor.
            O King of Gods, destroy the internal enemies of ignorance and grant us fame that is rooted in Truth and remains permanent.
            Your protective energies form an impenetrable shield around us, through which no form of negativity, disease, or sorrow can penetrate.
            Through our prayers, we invoke that power of yours which possesses the capability to make the impossible possible and rescue us from calamities.
            You are the energy that breathes new life and enthusiasm into our weakening resolutions and empowers us to emerge victorious in every field.
            O Indra, with your infinite generosity, make our sacrifice successful and lead us toward the path of profound spiritual evolution.
            Our future is safe and immensely bright under your merciful gaze; we repeatedly bow before your invincible and magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 6,
        sanskrit = "आ तू न इन्द्र क्षुमन्तं चित्रं ग्राभं सं गृभाय ।\nमहाहस्ती दक्षिणेन ॥ ६ ॥",
        hindiCommentary = """
            हे अत्यंत विशाल हाथों वाले इन्द्रदेव! आप अपने दाहिने हाथ से हमारे लिए अद्भुत, श्रेष्ठ और प्रचुर धन एवं ऐश्वर्य ग्रहण करें।
            आप हमें वह अन्न और समृद्धि प्रदान करें जो हमारे परिवार का पोषण करे और हमें समाज में सम्मानित और गौरवपूर्ण स्थान दिलाए।
            आपके उदार हाथ सदैव भक्तों को देने के लिए उठे रहते हैं, कृपया हमारी विनम्र प्रार्थनाओं को स्वीकार कर हमें निहाल करें।
            हमें वह 'अद्भुत पकड़' और सफलता प्रदान करें जिससे हम अपने लक्ष्यों को दृढ़तापूर्वक प्राप्त करने में पूरी तरह सफल हो सकें।
            इन्द्रदेव की कृपा से प्राप्त ऐश्वर्य न केवल सुख देता है, बल्कि वह हमें धर्म के कार्यों में दान देने और परोपकार करने के योग्य भी बनाता है।
            हे देव, आप अपनी प्रचंड शक्ति से हमारी दरिद्रता का नाश करें और हमारे जीवन में संपन्नता का सूर्य उदय करने की कृपा करें।
            जब आप अपनी महान भुजाओं से हमारी रक्षा करते हैं, तब हमें संसार की किसी भी असुर शक्ति से तनिक भी डरने की आवश्यकता नहीं।
            आप ही वह शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं।
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के प्रत्येक अभाव को पूर्णता में बदलने वाले एकमात्र देव हैं।
            हे इन्द्र, आप अपनी उदारता के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी दिव्य सुरक्षा में मंगल के साथ रखें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra with mighty hands, with your right hand, grasp and bring for us wonderful, superior, and vast wealth.
            Bestow upon us that nourishment and prosperity which sustains our family and earns us an honored and dignified place in society.
            Your generous hands are always raised to bless your devotees; please accept our humble prayers and fill our lives with abundance.
            Grant us that 'marvelous grasp' and success enabling us to firmly and completely achieve all the great goals of our lives.
            Prosperity obtained through the grace of Indra not only provides comfort but also makes us capable of performing charity and noble deeds.
            O God, with your fierce power, destroy our poverty and make the sun of prosperity rise within our daily existence.
            When you protect us with your magnificent and powerful arms, we have no reason to fear any demonic force or negative situation.
            You are the power that makes our hard work meaningful and continuously drives us forward on the path of holistic evolution.
            We worship you with deep devotion because you are the deity who transforms every scarcity of our life into absolute completeness.
            O Indra, reside in our homes and hearts with your divine generosity and keep us forever safe under your magnificent protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 7,
        sanskrit = "का त उस्तिः शविष्ठ्य का मतिः का सुवृक्तिः ।\nकदा वसूनि भरसि ॥ ७ ॥",
        hindiCommentary = """
            हे अत्यंत बलवान और तेजस्वी इन्द्रदेव! आपकी स्तुति करने का सही ढंग क्या है, और आपको प्रसन्न करने वाली बुद्धि कौन सी है?
            वह कौन सा उत्तम कर्म है जिससे आप संतुष्ट होते हैं, और आप हमें अपना अद्भुत ऐश्वर्य और दिव्य धन कब प्रदान करेंगे?
            भक्त का यह प्रश्न उसकी व्याकुलता और आपके सान्निध्य की तीव्र इच्छा को दर्शाता है, जो केवल पूर्ण समर्पण से ही शांत हो सकती है।
            हम अपनी इस अल्प बुद्धि से आपकी विराट महिमा को समझने का प्रयास कर रहे हैं, कृपया हमें सही मार्ग और प्रज्ञा प्रदान करें।
            हे देवराज, आप ही ज्ञान के अक्षय भंडार हैं, हमें वह संस्कार दें जिससे हम आपकी स्तुति करने के वास्तविक अधिकारी बन सकें।
            जब मनुष्य अपने अहंकार को त्यागकर आपकी शरण में आता है, तभी उसे आपके दिव्य ऐश्वर्य, शांति और अखंड आनंद की प्राप्ति होती है।
            आपकी कृपा का समय आपकी ही इच्छा पर निर्भर है, परंतु हमारा कर्तव्य निरंतर आपकी उपासना और धर्म का पालन करना है।
            आप ही वह शक्ति हैं जो हमारे जीवन के अंधकारमय संशयों को दूर कर हमें सत्य के साक्षात्कार की ओर सफलतापूर्वक ले जाती हैं।
            हम विनम्र भाव से आपकी प्रतीक्षा करते हैं कि आप कब हमारे जीवन को अपनी वैभवशाली ज्योति से आलोकित करेंगे।
            हे इन्द्र, आप हमारे गुरु और रक्षक बनकर हमें वह विवेक दें जिससे हम आपके रहस्यों को समझ सकें और सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O most powerful and radiant Indra, what is the proper way to praise you, and what is the intellect that truly pleases you?
            Which noble deed satisfies your divinity, and when will you bring forth your marvelous and divine treasures for us?
            This inquiry of the devotee reflects his restlessness and intense longing for your presence, stilled only by absolute surrender.
            We are attempting to comprehend your vast majesty with our limited intellect; please graciously grant us the right path and wisdom.
            O King of Gods, you are the inexhaustible storehouse of knowledge; grant us the virtues to become worthy of your divine praise.
            Only when a human renounces their ego and seeks your refuge do they attain your divine abundance, eternal peace, and bliss.
            The timing of your grace depends on your divine will, yet our duty is to remain engaged in your worship and the path of Dharma.
            You are the power that removes the dark doubts of our lives and leads us toward the realization of the ultimate Truth.
            We wait with humility for that moment when you decide to illuminate our existence with your magnificent and radiant light.
            O Indra, become our teacher and protector, granting us the discernment to understand your mysteries and succeed in life.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 8,
        sanskrit = "कुविद्ङ्ग मघवन् कस्यचिद् गिरो ज्रयो वाजस्य गन्त ।\nएवा हि ते मनो विचेतसम् ॥ ८ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आप वास्तव में उन भक्तों की वाणियों और स्तुतियों के पास पहुँचते हैं जो विजय और सिद्धि के लिए निरंतर प्रयत्नशील हैं।
            आपका मन अत्यंत विशेष ज्ञानी और चतुर है, जो यह भली-भांति जानता है कि किस साधक को कब और क्या प्रदान करना उसके लिए श्रेष्ठ है।
            आपकी बुद्धि सूक्ष्म रहस्यों को भेदने वाली है, और आप केवल सच्ची श्रद्धा और पुरुषार्थ से ही प्रसन्न होने वाले महान देव हैं।
            जब हम एकाग्र मन से आपकी महिमा गाते हैं, तो आपकी चेतना हमारे जीवन के संघर्षों में साक्षात् मार्गदर्शन करने लगती है।
            हे देव, आप हमारे संकल्पों को वह गति दें जिससे हम अपने लक्ष्यों को शीघ्रता और पूर्णता के साथ प्राप्त करने में सफल हों।
            आपकी कृपा का प्रवाह उन लोगों की ओर स्वतः ही मुड़ जाता है जो धर्म की रक्षा और समाज के उत्थान के लिए समर्पित हैं।
            हमें वह 'विचेतस' (विशेष चेतना) प्रदान करें जिससे हम सांसारिक भ्रमों से बचकर केवल शाश्वत सत्य की खोज कर सकें।
            आप ही वह शक्ति हैं जो हमारे परिश्रम को ईश्वरीय फल में और हमारी छोटी प्रार्थनाओं को दिव्य आशीषों में बदलती हैं।
            इन्द्रदेव की मित्रता हमें वह सुरक्षा प्रदान करती है जो हमें संसार के प्रलोभनों के बीच भी विचलित नहीं होने देती।
            हे इन्द्र, आप हमारे रक्षक और मार्गदर्शक बनकर हमें दिव्यता के उस शिखर पर ले चलें जहाँ केवल आनंद और शांति हो।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, you truly reach and attend to the voices and hymns of those devotees who strive for victory and success.
            Your mind is exceptionally wise and discerning, knowing exactly what to bestow upon which seeker and at what time for their best.
            Your intellect pierces through subtle mysteries, and you are a deity pleased only by sincere faith and dedicated human effort.
            When we sing your glories with a focused mind, your consciousness begins to guide us personally through all of life's struggles.
            O God, grant our resolutions that momentum through which we can achieve our goals with speed, precision, and completeness.
            The flow of your grace naturally turns toward those who are dedicated to the defense of Dharma and social upliftment.
            Grant us that 'Vichetas' (special consciousness) which enables us to avoid worldly illusions and seek only the eternal Truth.
            You are the power that transforms our hard labor into divine results and our simple prayers into magnificent celestial blessings.
            Indra's friendship provides us with a security that prevents us from wavering even amidst the strongest worldly temptations.
            O Indra, stay with us as our protector and guide, and lead us to that peak of divinity where only joy and peace reside.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 9,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ९ ॥",
        hindiCommentary = """
            हे शक्ति के पुंज इन्द्रदेव! आप हमारी स्तुतियों से प्रसन्न होकर हमारे प्रति दयालु भाव रखते हुए यहाँ कृपापूर्वक पधारें।
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ हमारे जीवन के युद्ध क्षेत्र में सहायक और रक्षक बनकर आएं।
            आपकी उपस्थिति हमारे भीतर के आत्मविश्वास को जागृत करती है और हमें बड़ी से बड़ी विपदाओं से लड़ने का साहस प्रदान करती है।
            जब आप हमारे पक्ष में खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति या शत्रु हमें पराजित करने का साहस नहीं कर सकता।
            हे देवराज, आप हमारे अज्ञान रूपी अंधकार को अपनी ज्योति से मिटाकर हमारे जीवन में ज्ञान और विवेक का प्रकाश फैलाएं।
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख और शांति का ही वास होता है।
            हम अपनी विनम्र प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी उदारता से पूर्ण कर दें।
            आप ही वह शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं।
            हे इन्द्र, आप अपनी अनंत महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी दिव्य सुरक्षा में रखें।
            आपकी कृपा दृष्टि से हमारा कल्याण सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O fountain of energy Lord Indra, being pleased by our hymns and harboring a kind intent, please come here graciously.
            Arrive in our lives as a helper and guardian along with your grand and immensely vast protective powers and divine assistances.
            Your presence awakens the self-confidence within us and grants us the courage required to battle the greatest of calamities.
            When you stand on our side, no negative force or enemy in the world can ever dare to defeat or even disturb our peace.
            O King of Gods, erase the darkness of our ignorance with your light and spread the radiance of wisdom and discernment in our lives.
            Your protective energies build such a fortress of security around us within which only happiness and tranquility reside.
            We invoke you with our humble supplications so that you may fulfill every single scarcity of our existence with your generosity.
            You are the power that makes our hard work meaningful and continuously drives us forward on the path of evolution and growth.
            O Indra, reside in our homes and hearts with your infinite glory and keep us forever safe under your divine protection.
            Our well-being is guaranteed under your merciful gaze; we repeatedly bow before your invincible and magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 10,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ १० ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो सोमरस का पान कर आनंदित होते हैं।
            वे हमें ऐश्वर्य और धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महिमा भक्तों की वाणी से निरंतर बढ़ती रहती है।
            जैसे माताएं और गौएँ अपने बछड़े की ओर प्रेमपूर्वक दौड़ती हैं, वैसे ही हमारी स्तुतियां और प्रार्थनाएं इन्द्र की ओर बढ़ती हैं।
            आपकी उपस्थिति मात्र से हमारे मन की चंचलता समाप्त होती है और हम एकाग्र होकर आपकी दिव्य सत्ता का अनुभव करते हैं।
            हे शक्तिशाली इन्द्र, आप हमारे यज्ञ के आधार हैं और हमारे जीवन को ऊर्जस्वित करने वाले परम तेजस्वी देव हैं।
            जैसे बछड़ा अपनी माँ से पोषण पाता है, वैसे ही हम आपकी कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्राप्त करते हैं।
            आपकी उदारता की कोई सीमा नहीं है; आप अपने शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके विकास के लिए आवश्यक है।
            हम अपनी मधुर और सत्य वाणी से आपको प्रसन्न करने का प्रयास करते हैं ताकि आप हमारे जीवन के समस्त दुखों का अंत कर सकें।
            इन्द्रदेव की शरण में आने वाला साधक कभी रिक्त नहीं रहता, उसे ज्ञान के प्रकाश और वैभव की प्रचुरता का वरदान मिलता है।
            हे देवराज, आप हमारे हृदयों में अनन्य भक्ति का संचार करें और हमें सदैव अपनी दिव्य छाया में सुरक्षित और सुखी रखें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, praise the wonderful Lord Indra, the subduer of enemies, who rejoices in the consumption of the Soma nectar.
            He remains ever ready to bestow abundance upon us, and his glory is continuously increased by the hymns of his followers.
            Just as mothers and cows run affectionately toward their calf, our hymns and heartfelt prayers flow toward Indra's presence.
            Your mere presence terminates the restlessness of our minds, allowing us to experience and worship your divine existence with focus.
            O Mighty Indra, you are the bedrock of our sacrifice and the supremely radiant deity who energizes our entire life.
            As a calf receives vital nourishment from its mother, we receive spiritual peace and material plenty through your divine favor.
            There is no limit to your generosity; you bestow upon your surrendered devotee everything necessary for their holistic development.
            We strive to please you with our sweet and truthful voices so that you may bring a definitive end to all the sufferings of our life.
            A seeker who takes refuge in Lord Indra never remains empty; they are blessed with the light of knowledge and vast abundance.
            O King of Gods, infuse our hearts with exclusive devotion and keep us forever protected and happy under your divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 11,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ११ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों और ऋषियों द्वारा स्तुतियों के माध्यम से संवर्धित और प्रदीप्त किए जाने वाले अत्यंत महान देव हैं।
            आप हमारे लिए शीघ्र ही वह शक्ति, अन्न और विजय लेकर आने की कृपा करें जो हमारे जीवन को उन्नत बना सके।
            आप हमारे लिए एक कल्याणकारी और अत्यंत आत्मीय मित्र बनकर हमारे जीवन की इस दुर्गम यात्रा को सुगम बनाएं।
            आपकी मित्रता संसार के सभी अस्थायी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त को नहीं त्यागते।
            हे देव, हमें वह आत्मबल और साहस प्रदान करें जिससे हम जीवन के संघर्षों में विजयी होकर गौरवपूर्ण स्थान प्राप्त कर सकें।
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव न हो।
            जब आप हमारे सखा बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक मार्ग में रुकावट नहीं बन सकती।
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम को ईश्वरीय फल और सफलता में बदलने वाले हैं।
            आपकी ऊर्जा हमारे प्राणों में उत्साह बनकर बहती है, जो हमें सदैव श्रेष्ठ और परोपकारी कर्म करने के लिए प्रेरित करती है।
            हे इन्द्र, आप हमारे रक्षक और मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the great deity who is increased and glorified through the powerful hymns of men and sages.
            Graciously bring to us very quickly that power, nourishment, and victory which will elevate our lives in every aspect.
            Become a benevolent and highly intimate friend to us, making this difficult journey of life easy and successful.
            Your friendship is superior to all temporary worldly relationships because you never abandon your devotee in times of distress.
            O God, provide us with the inner strength and courage required to emerge victorious and attain a position of honor in society.
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources or peace in our households.
            When you become our companion, no major obstacle of the world can ever block our spiritual or material progress.
            We worship you with deep devotion, for it is you who transforms our hard labor and efforts into divine and successful results.
            Your energy flows through our being as enthusiasm, perpetually inspiring us to perform noble and altruistic deeds.
            O Indra, stay with us as our protector and guide, graciously making us magnificent, successful, and renowned.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 12,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ १२ ॥",
        hindiCommentary = """
            हे वृत्रहन् इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में अपनी असीम कृपा के साथ अवश्य पधारें।
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ हमारे जीवन के प्रत्येक संघर्ष में सहायक और रक्षक बनकर आएं।
            आपकी उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता प्रदान करती है जिससे हम जीवन की किसी भी विषम परिस्थिति में नहीं डगमगाते।
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति या बाधा से तनिक भी भयभीत होने की आवश्यकता नहीं।
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का अंत कर हमारे मन में ज्ञान की पवित्र गंगा प्रवाहित करने की कृपा करें।
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा घेरा बनाती हैं जिसमें कोई भी बुराई कभी प्रवेश नहीं कर सकता।
            हम अपनी विनम्र प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से मिटा दें।
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर ले चलती हैं।
            हे इन्द्र, आप अपनी अनंत उदारता और वैभव के साथ हमारे घर और हृदय में विराजें और हमें अपने आशीषों से कृतार्थ करें।
            आपकी कृपा दृष्टि से हमारा कल्याण और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra, please do come graciously to our sacrificial ground and take our side.
            Arrive in our lives as a vigilant helper and guardian along with your grand and immensely vast protective powers.
            Your sacred presence provides our resolutions with that steel-like firmness needed to remain unshaken in any situation.
            When you are with us, there is absolutely no need for us to fear any demonic force or obstacle that the world presents.
            O King of Gods, graciously destroy the Vritra of ignorance within our hearts and let the pure river of knowledge flow within us.
            Your protective energies build such an impenetrable shield around us that no form of evil can ever find its way inside.
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your light.
            You are the supreme power that makes our hard work meaningful and carries us forward on the path of evolution.
            O Indra, reside in our homes and hearts with your infinite generosity and splendor, and bless us with your auspicious favors.
            Our complete well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 13,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ १३ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि हैं, आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी माता के रूप में प्रतिष्ठित हैं।
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और हमारा पालन कर रहे हैं।
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के संकटों से रक्षा करते हैं, वैसे ही आप हमारी सूक्ष्म देखभाल करते हैं।
            हम आपसे वह 'सुम्नम्' (परम सुख और शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे भक्तों को ही प्राप्त होता है।
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के जाल से बाहर निकालती है।
            हे देवराज, हमारे प्रति आपके वात्सल्य की कोई सीमा नहीं है, और हम एक समर्पित संतान के रूप में आपकी पावन वंदना करते हैं।
            आपकी असीम कृपा से ही हमें वह मानसिक शांति प्राप्त होती है जो संसार की किसी भी भौतिक वस्तु में अत्यंत दुर्लभ है।
            हम अपनी संपूर्ण श्रद्धा और विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में सुरक्षित रखें।
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान भी प्रदान करें।
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को जलाकर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर ले जाए।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are established as our superior intellect, our supreme Father, and our most affectionate Mother.
            You have manifested in our lives as the foundation of our entire existence and our sole well-wisher, nurturing us.
            Just as parents protect and nourish their innocent child from all kinds of dangers, you take care of our subtle and physical needs.
            We seek from you that 'Sumnam' (supreme bliss and peace) which is only granted to true devotees seeking your refuge.
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the web of ignorance.
            O King of Gods, there is no limit to your affection and love for us, and we worship you with the simple heart of a child.
            By your boundless grace alone do we find the mental tranquility that is extremely rare and unattainable in any worldly object.
            We offer our complete faith and trust at your divine feet so that you may forever keep us safe within your protective shadow.
            O Indra, bring abundance into every field of our existence and make us successful while granting us the light of Self-realization.
            May your radiant stream burn away the darkness of our ignorance and lead us to the realization of the Supreme Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 14,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ १४ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और नवीन ऊर्जा प्रदान करने वाला है।
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं।
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा करते हैं।
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं।
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव धर्म की रक्षा कर सकें।
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और कष्ट सदा के लिए दूर हो जाते हैं।
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें।
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है।
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है।
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वर के समीप रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy.
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power.
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity.
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant.
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma.
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace.
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity.
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character.
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is totally rare in fleeting worldly things.
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 15,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ १५ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में सर्वश्रेष्ठ वीर हैं।
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं।
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं।
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है।
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण स्थान प्राप्त कर सकें।
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए कल्याणकारी हो।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं।
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं।
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है।
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
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
        id = 16,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ १६ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं।
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं।
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है।
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है।
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें।
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें।
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले।
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें।
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है।
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma.
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
        id = 17,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ १७ ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं।
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
        id = 18,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ १८ ॥",
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
        id = 19,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ १९ ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं।
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
        id = 20,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ २० ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्रदेव! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और अजेय ऊर्जा प्रदान करने वाला है।
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं।
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं।
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं।
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य की रक्षा कर सकें।
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और कष्ट सदा के लिए दूर हो जाते हैं।
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें।
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है।
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है।
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वरमय रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the guide on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy.
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power.
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity.
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant.
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma.
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace.
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity.
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character.
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things.
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 21,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ २१ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं।
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं।
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं।
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है।
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज में गौरवपूर्ण स्थान प्राप्त कर सकें।
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो मानवता के लिए कल्याणकारी हो।
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं।
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं।
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है।
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O knower of divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong.
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
        id = 22,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ २२ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं।
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं।
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है।
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है।
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें।
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें।
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले।
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें।
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है।
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma.
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today.
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed.
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically.
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies.
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm.
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence.
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly.
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold.
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 23,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ २३ ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं।
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
        id = 24,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ २४ ॥",
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
        id = 25,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ २५ ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं।
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
        id = 16,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ १६ ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित (स्वराजम्) हैं, भक्त उनकी परम उपासना करते हैं। 
            वे 'होता' के पवित्र आह्वान और यज्ञीय आहुतियों के माध्यम से निरंतर प्रदीप्त और भक्तों के हृदयों में संवर्धित किए जाते हैं। 
            इन्द्र की यह 'स्वराज' अवस्था मनुष्य को आत्म-संयम, आत्म-बोध और वास्तविक आत्म-निर्भरता का महान आध्यात्मिक संदेश प्रदान करती है। 
            जब हम अपनी इंद्रियों के स्वामी स्वयं बन जाते हैं, तब हम अपने भीतर इन्द्र के उस दिव्य और तेजस्वी स्वरूप का अनुभव कर सकते हैं। 
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
        id = 17,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ १७ ॥",
        hindiCommentary = """
            हे असीम शक्ति के स्वामी इन्द्रदेव! आप हमारी प्रार्थनाओं से प्रसन्न होकर हमारे प्रति दयालु भाव रखते हुए यहाँ पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ हमारे जीवन के इस यज्ञ में सहायक और रक्षक बनकर आएं। 
            आपकी दिव्य उपस्थिति हमारे भीतर के आत्मविश्वास को जागृत करती है और हमें कठिन परिस्थितियों से लड़ने का साहस प्रदान करती है। 
            जब आप हमारे पक्ष में खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति हमें पराजित करने का साहस नहीं कर सकता। 
            हे देवराज, आप हमारे अज्ञान रूपी अंधकार को अपनी प्रखर ज्योति से मिटाकर हमारे जीवन में ज्ञान और विवेक का प्रकाश फैलाएं। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख, शांति और पवित्रता का वास होता है। 
            हम अपनी विनम्र पुकार से आपको बुलाते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी अनंत उदारता से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी दिव्य महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी अजेय सुरक्षा की छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, the master of infinite power, being pleased by our sincere prayers and harboring a kind intent, please manifest here. 
            Arrive in our lives as a helper and guardian, accompanied by your grand and immensely vast protective divine powers. 
            Your sacred presence awakens the latent self-confidence within us and grants us the courage required to battle difficult situations. 
            When you stand on our side, no negative force of the world or any mental affliction can ever dare to defeat us. 
            O King of Gods, erase the darkness of our ignorance with your intense light and spread the radiance of wisdom and discernment in our lives. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness and peace reside. 
            We invoke you with our humble cries so that you may fulfill every single scarcity of our existence with your infinite generosity. 
            You are the supreme authority that makes our hard work meaningful and continuously drives us forward on the path of growth. 
            O Indra, reside in our homes and hearts with your divine glory and keep us forever safe under the shadow of your protection. 
            Our ultimate well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 18,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ १८ ॥",
        hindiCommentary = """
            समस्त स्तुतियां और प्रार्थनाएं समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और संसार में प्रकाशित करती हैं। 
            वे दिव्य रथियों में सर्वश्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल सारथी हैं, जो हमें संसार की बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम शिखर तक पहुँचाने की कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और सच्ची कीर्ति का मार्ग दिखाए। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and true glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 19,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ १९ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता और पराक्रम के प्रेमी हैं, कृपया हमारे भीतर भी वही अटूट वीरता और साहस स्थापित करें। 
            आप अत्यंत महान और तेजस्वी हैं, हमारे जीवन के श्रेष्ठ संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रहें। 
            सच्ची वीरता वह नहीं जो केवल बाह्य युद्ध में दिखे, बल्कि वह है जो हमें अपने विकारों और शत्रुओं पर विजय पाने की शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य और न्याय का मार्ग प्रशस्त करने वाले योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के प्रत्येक सूक्ष्म डर को समाप्त कर हमें पूर्णतः निर्भीक और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति हमें अपने मार्ग से विचलित नहीं कर सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम मानवता के लिए श्रेष्ठ बनें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल मन में नवीन ऊर्जा का संचार कर हमें निरंतर कर्मयोग की ओर सफलतापूर्वक अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के वास्तविक और शाश्वत सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism and valor; please instill that same valor and unshakable courage within us. 
            You are exceedingly great and radiant; grant firmness to the noble resolutions of our lives so that we are always ready for the defense of Dharma. 
            True heroism is not just seen in physical external war, but in the power that enables us to conquer our own inner flaws and weaknesses. 
            By your grace, let us receive that vigor and luster which transform us into warriors who pave the way for Truth and Justice in society. 
            O King of Gods, graciously terminate every subtle fear within us and make us completely fearless, steady, and self-confident. 
            When you sow the seed of courage in our hearts, no adverse circumstance of the world can ever sway or disturb our peace of mind. 
            We worship you with devotion so that a fraction of your greatness reflects in our character and we become superior beings for humanity. 
            You are the power that infuses fresh energy into our lethargic minds, pushing us successfully toward the path of dedicated action. 
            O Indra, give us the spiritual capability to rise above worldly temptations and attain the true essence of the Divine and Eternal Truth. 
            May your merciful gaze always remain upon us as we lead a glorious and meaningful life successfully under your supreme divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 20,
        sanskrit = "तमिन्द्रं वाजयामसि महे वृत्राय हन्तवे ।\nस वृषा वृषभो बभूविथ ॥ २० ॥",
        hindiCommentary = """
            हम उन इन्द्रदेव को बल और सामर्थ्य प्रदान करने वाली स्तुतियां अर्पित करते हैं ताकि वे महान शत्रु वृत्रासुर का समूल वध कर सकें। 
            वे स्वयं असीम शक्ति के पुंज और श्रेष्ठ वीरों में भी सर्वश्रेष्ठ हैं, जो अधर्म का नाश करने के लिए सदैव शस्त्र धारण किए रहते हैं। 
            भक्तों की श्रद्धापूर्ण प्रार्थनाएं इन्द्र के वज्र को और अधिक प्रखर बनाती हैं, जिससे वे संसार की समस्त बाधाओं को नष्ट करने में सक्षम होते हैं। 
            वृत्र केवल एक राक्षस नहीं, बल्कि हमारे मार्ग में आने वाला वह हर सूक्ष्म अवरोध है जो हमें सत्य की प्राप्ति और आत्मोन्नति से रोकता है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारे भीतर के अज्ञान और जड़ता का अंत कर हमारे जीवन में प्रकाश का मार्ग सदा के लिए खोलें। 
            आपकी विजय ही हमारी वास्तविक विजय है, और हम आपकी निरंतर जय-जयकार करते हुए स्वयं को आपके दिव्य कार्यों के लिए समर्पित करते हैं। 
            आपकी ऊर्जा हमारे शरीर में जीवनी शक्ति बनकर और मन में दृढ़ संकल्प बनकर बहती है, जिससे हम जीवन के युद्ध में कभी हार नहीं मानते। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि आप हमारे जीवन के प्रत्येक संघर्ष में हमें सफलता की ओर ले जाने वाले महान सहायक बनें। 
            इन्द्रदेव की अजेय शक्ति हमें यह विश्वास दिलाती है कि अंततः जीत सदैव धर्म और सत्य की ही होती है, चाहे शत्रु कितना भी प्रबल क्यों न हो। 
            हे इन्द्र, आप हमारे परम रक्षक हैं, हमें अपनी दिव्य ज्वाला में तपाकर शुद्ध करें और हमें दिव्यता के सर्वोच्च शिखर पर पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            We offer hymns that bestow strength and capability to Lord Indra so that he may completely slay the great and formidable enemy, Vritra. 
            He is himself the immense mass of infinite energy and the foremost among the great heroes, always armed to destroy unrighteousness. 
            The devoted prayers of his followers sharpen Indra's thunderbolt (Vajra), enabling him to effectively annihilate all the obstacles of the world. 
            Vritra is not just a demon but every single subtle barrier in our path that prevents us from attaining Truth and Self-growth. 
            O God, with your fierce power, end the ignorance and lethargy within us and open the pathway of supreme light in our lives forever. 
            Your victory is our true victory, and as we continuously hail your name, we dedicate ourselves to your divine and benevolent purposes. 
            Your energy flows within us as the vital force and as a firm resolution in the mind, ensuring we never give up in the battle of life. 
            We worship you with devotion so that you become our constant and great helper, leading us toward success and peace in every life struggle. 
            The invincible power of Lord Indra reassures us that victory ultimately belongs to Dharma and Truth, no matter how strong the foe. 
            O Indra, you are our ultimate protector; refine us in your divine flame and lead us to the supreme and holy heights of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 21,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ २१ ॥",
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
        id = 22,
        sanskrit = "आ नो मित्रस्य वरुणस्य प्र यंसत् ।\nसोम रयिं सुवीर्यम् ॥ २२ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमें मित्र और वरुण देव के समान अत्यंत श्रेष्ठ, पवित्र और मंगलकारी धन प्रदान करने की महान कृपा करें। 
            आप हमें वह 'सुवीर्यम्' (उत्तम वीरता और आध्यात्मिक सामर्थ्य) दें जिससे हम धर्म की रक्षा और समाज का उद्धार करने में सफल हो सकें। 
            मित्र देव ब्रह्मांडीय सौहार्द के प्रतीक हैं और वरुण देव नैतिकता के रक्षक हैं, इन दोनों के महान गुण हमारे चरित्र में समाहित हों। 
            आपकी असीम कृपा से हमें वह ऐश्वर्य प्राप्त हो जो पूर्णतः सत्य और न्याय के मार्ग पर चलकर अर्जित किया गया हो और जो सुखदायी हो। 
            हे देव, हमें केवल भौतिक धन ही नहीं, बल्कि वह प्रज्ञा और चरित्र भी दें जो उस धन का लोक-कल्याण में सदुपयोग करने में सहायक हो। 
            आपकी ज्योति हमारे संकल्पों को वह दृढ़ता प्रदान करे जिससे हम वीरतापूर्वक जीवन की चुनौतियों का सामना कर सकें और कभी न डगमगाएं। 
            हम आपकी निरंतर वंदना करते हैं ताकि हमारे जीवन में अनुशासन, प्रेम और दिव्यता का एक सुंदर और सफल समन्वय सदैव बना रहे। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम और त्याग को महान सफलता और ईश्वरीय फल में परिवर्तित करने का सामर्थ्य रखती हैं। 
            हे सोम, हमें वह वैभव दें जो हमारे वंश की गरिमा को बढ़ाए और हमें वह आत्मिक शांति प्रदान करे जो संसार में अत्यंत दुर्लभ है। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हम ऐश्वर्य पाकर भी अहंकारी न हों और विनम्र बने रहकर सदैव सेवा के मार्ग पर चलें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, please bestow upon us that most excellent, sacred, and auspicious wealth, similar to the gifts of Mitra and Varuna. 
            Grant us 'Suviryam'—superior valor and spiritual capability—so that we may successfully protect Dharma and uplift our society. 
            Mitra represents cosmic harmony and Varuna represents morality; let the noble qualities of both reside within our character. 
            By your boundless grace, let us receive that abundance which is earned by following the path of truth and justice and which brings peace. 
            O God, do not give us just material wealth, but also the wisdom and character required to use that wealth for the welfare of all. 
            May your light provide our resolutions with the firmness needed to face life's challenges heroically without ever wavering. 
            We worship you continuously so that a beautiful balance of discipline, love, and divinity remains always present in our lives. 
            You are the power that possesses the capability to transform our hard labor and sacrifice into magnificent success and divine fruits. 
            O Soma, grant us the splendor that enhances our lineage's dignity and provides us with the inner peace that is rare in the world. 
            May your merciful gaze remain upon us so that even with abundance, we do not become arrogant but stay humble on the path of service.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 23,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ २३ ॥",
        hindiCommentary = """
            हे पवमान और पावक (पवित्र करने वाले) सोमदेव! आप स्वर्ग की दिव्य कांति के समान अद्भुत और विविध प्रकार के ऐश्वर्यों के स्वामी हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह पुष्टिकारक अन्न और शक्तिशाली जीवनी शक्ति लेकर आएं जो हमारे जीवन को सफल बनाए। 
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु का लेशमात्र भी अभाव न रहे और हम सदैव सुख, शांति और समृद्धि से संपन्न बने रहें। 
            हे देव, आप हमारे अंतःकरण के समस्त अंधकार और विकारों को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा के दर्शन कर सकें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन की दरिद्रता और अज्ञान को समाप्त कर हमें प्रचुरता और ज्ञान के सर्वोच्च शिखर पर पहुँचाती हैं। 
            हमें वह 'इषम्' (प्रेरणा और पोषण) प्रदान करें जो हमारे शरीर और आत्मा दोनों को पूर्णतः तृप्त कर हमें दिव्यता की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे दुखों का नाश होता है और हमें वह नवीन उत्साह प्राप्त होता है जो हमें कभी थकने नहीं देता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो समय के साथ कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और ईश्वर की ओर ले जाने वाले मार्ग का दर्शन कराए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में रखें और हमारा मंगलमय जीवन सदैव आपकी मर्यादा में सुरक्षित रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the master of magnificent and extraordinary riches that shine like celestial luster. 
            For us, your devoted chanters, bring forth that powerful nourishment and vital energy that make our lives meaningful and successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we always remain prosperous, peaceful, and abundant. 
            O God, purify our inner self of all darkness and afflictions and grant us the divine vision to perceive the Presence of the Divine. 
            You are the supreme power that terminates the poverty and ignorance of our existence and leads us to the peaks of plenty and wisdom. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our physical body and soul and leads us toward divinity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of our duty. 
            O Soma, come into our homes and hearts as the generous giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and continuously show us the pathway leading toward fame, splendor, and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever safe within your laws.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 24,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ २४ ॥",
        hindiCommentary = """
            पवित्र किया जाता हुआ यह सोम अपनी दिव्य धारा के साथ जल रूपी वस्त्रों को धारण कर (अपो वसानो) वेगपूर्वक प्रवाहित हो रहा है। 
            रत्नों और श्रेष्ठ गुणों को धारण करने वाला यह सोम 'ऋत' (ब्रह्मांडीय सत्य) के मूल स्थान (योनिं) पर जाकर विराजमान होता है। 
            सोम का जल के साथ मिलन जीवन की सृजनात्मक ऊर्जा और शांति के सुंदर समन्वय का प्रतीक है। 
            जैसे सोम ऋत के स्थान पर बैठता है, वैसे ही हमारे संकल्प भी सत्य और धर्म के आधार पर प्रतिष्ठित होने चाहिए। 
            हे देव, आप अपनी इस पावन यात्रा के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे दैवीय आभा से पूरी तरह आलोकित कर दें। 
            आपकी उपस्थिति हमारे जीवन के प्रत्येक यज्ञीय कर्म को सफल बनाती है और हमें देवताओं के आशीर्वाद का पात्र बनाती है। 
            हमें वह 'रत्न' (विवेक और प्रज्ञा) प्रदान करें जो हमारे जीवन की दिशा को अंधकार से हटाकर प्रकाश की ओर मोड़ दे। 
            जब हम आपकी शरण में होते हैं, तब ब्रह्मांड का परम सत्य हमारे हृदय में स्वतः ही प्रकाशित होने लगता है। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी कृपा की धारा हमारे परिवार और समाज में सदैव सुख और शांति लाए। 
            हे पवमान सोम, आप हमारे रक्षक और शाश्वत मार्गदर्शक बनकर हमें मोक्ष और ईश्वर के परम पद तक पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma flows with its divine stream, appearing as if clothed in waters (Apo Vasano) as it rushes forward. 
            This bestower of treasures and virtues (Ratnadha) proceeds to seat himself upon the primal source (Yonim) of cosmic Truth (Rta). 
            The merging of Soma with water symbolizes the beautiful harmony between the creative energy of life and profound peace. 
            Just as Soma sits at the source of Rta, may our resolutions also be established upon the foundations of Truth and Dharma. 
            O God, through this holy journey of yours, purify our inner self and illuminate it completely with your celestial radiance. 
            Your presence makes every sacrificial act of our lives successful and makes us worthy of the magnificent blessings of the gods. 
            Bestow upon us those 'gems' of wisdom and discernment that shift our life's direction away from darkness toward light. 
            When we are in your refuge, the ultimate Truth of the universe begins to manifest within our hearts naturally and effortlessly. 
            We worship you with devotion so that the stream of your grace always brings happiness and peace to our families and society. 
            O Pavamana Soma, stay as our protector and eternal guide, and graciously lead us to liberation and the supreme state of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 25,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ २५ ॥",
        hindiCommentary = """
            आँख और कान वाले मित्र (सखायो) भी मन की गति और दिव्य अनुभूतियों के क्षेत्र में एक समान (असमा) नहीं होते हैं। 
            कुछ साधक केवल बाहरी सतह तक ही पहुँच पाते हैं, जबकि कुछ गहरे सरोवर (ह्रदा) के समान ईश्वर के रहस्यों का दर्शन करते हैं। 
            यह मंत्र आध्यात्मिक साधना की गहराई और साधकों की विभिन्न श्रेणियों के बीच के सूक्ष्म अंतर को स्पष्ट करता है। 
            केवल शारीरिक इंद्रियों का होना पर्याप्त नहीं है; वास्तविक ज्ञान वही है जो हृदय की गहराई और मन की एकाग्रता से प्राप्त हो। 
            हे सोम, आप हमें वह अंतर्दृष्टि प्रदान करें जिससे हम बाहरी प्रपंचों से हटकर आपके वास्तविक और दिव्य स्वरूप को पहचान सकें। 
            जैसे सरोवर शांत होने पर ही अपना तल दिखाता है, वैसे ही शांत मन ही परमात्मा की छवि को ग्रहण करने में समर्थ होता है। 
            हम आपकी निरंतर उपासना करते हैं ताकि हमारे संशय दूर हों और हम ज्ञान के उस गहरे सरोवर में डुबकी लगा सकें। 
            आपकी कृपा से ही हमारे भीतर वह पात्रता विकसित होती है जिससे हम दिव्य मंत्रों और सत्यों के साक्षात् द्रष्टा बन पाते हैं। 
            इन्द्रदेव के सखा सोम, आप हमें वह मेधा और प्रज्ञा दें जो हमें संसार के शोर में भी ईश्वर की पुकार सुनने के योग्य बनाए। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन साधारण से असाधारण और दिव्य बन सके।
        """.trimIndent(),
        englishCommentary = """
            Friends (Sakhayo) who possess eyes and ears are not equal (Asama) in their mental speed and divine realizations. 
            Some seekers only reach the shallow edges, while others, like deep lakes (Hrada), perceive the profound mysteries of the Divine. 
            This mantra clarifies the depth of spiritual practice and the subtle differences between various levels of seekers and their insights. 
            Possessing physical senses is not enough; true knowledge is that which is attained through the depth of the heart and mental focus. 
            O Soma, grant us that inner vision which allows us to look beyond external illusions and recognize your true celestial nature. 
            Just as a lake shows its bottom only when still, a calm mind is the only vessel capable of reflecting the image of the Supreme. 
            We worship you continuously so that our doubts vanish and we may dive deep into that profound lake of ultimate wisdom. 
            It is through your grace that the eligibility is developed within us to become direct seers of divine mantras and eternal truths. 
            O Soma, companion of Indra, grant us that intellect and wisdom which make us capable of hearing God's call amidst the world's noise. 
            We offer our entire faith at your feet so that our lives may transform from ordinary existence into an extraordinary and divine journey.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 26,
        sanskrit = "एतमु त्यं दश यन्तो मृजन्ति सप्त धीतीभिः ।\nअभि प्रियमधारयत् ॥ २६ ॥",
        hindiCommentary = """
            हे साधकों! जो दसों दिशाओं से आने वाली और सात प्रकार की बुद्धियों (धीतीभिः) से युक्त शक्तियाँ हैं, वे इस सोम को पवित्र करती हैं। 
            यह मंत्र हमारी इंद्रियों और प्राणों के शुद्धिकरण की उस सूक्ष्म प्रक्रिया को दर्शाता है जो हमें ईश्वर के सान्निध्य के योग्य बनाती है। 
            जब हम अपनी दसों इंद्रियों को वश में करते हैं और सात चेतना स्तरों पर कार्य करते हैं, तब दिव्य आनंद हमारे हृदय में स्थित होता है। 
            पवित्रता ही वह कुंजी है जो हमारे भीतर छिपी हुई दैवीय ऊर्जा को जाग्रत करती है और हमें एक नई दृष्टि प्रदान करती है। 
            हे सोम, आप हमारी बुद्धि को वह निर्मलता दें जिससे हम संसार के प्रपंचों से मुक्त होकर सत्य का साक्षात् कर सकें। 
            आपकी उपस्थिति हमारे यज्ञ को वह तेज प्रदान करती है जिससे हमारे संकल्प सीधे स्वर्ग के लोकों तक पहुँचते हैं। 
            हमें वह आंतरिक बल प्रदान करें जिससे हम प्रतिकूल परिस्थितियों में भी विचलित न हों और सदैव आपकी शरण में रहें। 
            आप ही वह शक्ति हैं जो हमारे परिश्रम को ईश्वरीय फल में बदलने और हमारे जीवन को धन्य करने का सामर्थ्य रखती हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपका यह दिव्य रस हमारे प्राणों में नव-जीवन और उत्साह का संचार करे। 
            हे पवमान सोम, आप हमारे रक्षक और मार्गदर्शक बनकर हमें दिव्यता के सर्वोच्च शिखर पर ले जाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O seekers, the powers coming from the ten directions and endowed with the seven types of intellect (Dhitibhih) purify this Soma. 
            This mantra depicts the subtle process of purifying our senses and vital breaths, making us worthy of the Divine presence. 
            When we master our ten senses and operate on seven levels of consciousness, divine bliss becomes established in our hearts. 
            Purity is the key that awakens the hidden celestial energy within us and provides us with a completely new spiritual vision. 
            O Soma, grant our intellect that clarity through which we can liberate ourselves from worldly illusions and realize Truth. 
            Your presence provides our sacrifice with such brilliance that our resolutions reach directly into the celestial realms. 
            Bestow upon us that inner strength so that we do not waver even in adverse situations and always stay in your refuge. 
            You are the power that possesses the capability to transform our hard labor into divine fruits and bless our entire existence. 
            We worship you with devotion so that this divine nectar of yours infuses new life and enthusiasm into our vital breaths. 
            O Pavamana Soma, stay as our protector and guide, and lead us graciously toward the absolute peak of supreme divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 27,
        sanskrit = "त्वं ह्यग्ने अग्निना विप्रो विप्रेण सन्नसि ।\nसखा सख्या समिध्यसे ॥ २७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप अग्नि के द्वारा ही प्रदीप्त होते हैं, आप विद्वान (विप्र) के द्वारा विद्वान की तरह पूजे और बढ़ाए जाते हैं। 
            आप एक मित्र के द्वारा मित्र की तरह समिध (प्रज्वलित) किए जाते हैं, जो आपके और भक्त के बीच के प्रगाढ़ संबंध को दर्शाता है। 
            यह श्लोक ईश्वर और भक्त के बीच की उस मधुर आत्मीयता का प्रतीक है जहाँ दोनों एक-दूसरे की महिमा को बढ़ाते हैं। 
            अग्नि केवल एक तत्व नहीं, बल्कि वह चेतना है जो हमारे भीतर के दिव्य गुणों को जागृत करने की सामर्थ्य रखती है। 
            हे देव, आप हमारे श्रेष्ठ मित्र बनकर हमें वह संबल दें जिससे हम जीवन के किसी भी कठिन मोड़ पर कभी अकेला महसूस न करें। 
            जब हम आपकी स्तुति करते हैं, तो हम स्वयं भी आपकी आभा से दीप्तिमान हो उठते हैं और हमारे संशय दूर हो जाते हैं। 
            आपकी मित्रता हमें वह अभय प्रदान करती है जो हमें धर्म के मार्ग पर दृढ़तापूर्वक खड़े रहने के लिए प्रेरित करती है। 
            हम श्रद्धापूर्वक आपकी सेवा में तत्पर रहते हैं ताकि हमारे जीवन में ज्ञान और प्रेम का प्रकाश सदैव बना रहे। 
            जैसे एक मित्र दूसरे मित्र के दोषों को दूर करता है, वैसे ही आप हमारे अंतःकरण के समस्त विकारों को शांत कर दें। 
            हे अग्नि, आप हमारे सखा बनकर हमें अपनी दिव्य ऊर्जा से अनुगृहीत करें और हमें सफलता के उच्चतम शिखर पर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, you are kindled by fire; as a wise one (Vipra), you are worshipped and increased by the wise seekers. 
            You are ignited by a friend like a friend, symbolizing the deep, intimate, and reciprocal bond between you and the devotee. 
            This verse represents the sweet intimacy between the Divine and the seeker, where both mutually enhance each other's glory. 
            Agni is not merely a physical element but a consciousness that possesses the capacity to awaken the divine qualities within us. 
            O God, become our best friend and provide us with that support so that we never feel alone at any difficult turn of life. 
            When we sing your praises, we too become radiant with your aura, and all our lingering doubts are instantly removed. 
            Your friendship provides us with the fearlessness that inspires us to stand firm on the righteous path of Dharma. 
            We remain dedicated to your service with devotion so that the light of knowledge and love forever remains in our lives. 
            Just as a friend corrects another friend's flaws, please calm and remove all the afflictions and impurities of our inner self. 
            O Agni, as our companion, favor us with your divine energy and lead us graciously to the highest peaks of success.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 28,
        sanskrit = "यं ते स्तोमं चर्कृम वत्सो न विप्र इन्द्रयन् ।\nस नः पवस्व रयिमूर्मिणा सुतः ॥ २८ ॥",
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
            O Soma, just as a calf longs for its mother, we devotees chant your praises while yearning for the presence of Indra. 
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
        id = 29,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ २९ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम शक्ति, श्रेष्ठ ऐश्वर्य और असीम सुख प्रदान करने के लिए पवित्र होकर प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता और सामर्थ्य लाने वाली है, हम आपकी कृपा की याचना करते हैं। 
            शक्ति केवल शारीरिक नहीं, बल्कि मानसिक और आत्मिक भी होनी चाहिए, जो हमें धर्म के मार्ग पर अडिग रहने के लिए बल दे। 
            हमें वह धन प्रदान करें जो न्यायपूर्ण रीति से प्राप्त किया गया हो और जिसका उपयोग हम लोक-कल्याण के लिए कर सकें। 
            आपकी कृपा से प्राप्त होने वाला सुख वह आंतरिक शांति है जो संसार के किसी भी अभाव या दुख से कभी भी विचलित नहीं होती। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दृष्टि दें जिससे हम ईश्वर की महिमा को चराचर जगत में देख सकें। 
            आप ही वह शक्ति हैं जो हमारे जीवन की जड़ता को समाप्त कर हमें प्रचुरता और सक्रियता के सर्वोच्च शिखर पर पहुँचाती हैं। 
            आपकी महिमा का गान करने से हमारे कष्टों का निवारण होता है और हमें नवीन उत्साह और अटूट जीवनी शक्ति की प्राप्ति होती है। 
            हे सोम, आप हमारे स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की महान कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state to bestow upon us superior strength, excellent abundance, and infinite happiness. 
            Your holy stream brings prosperity and capability into every field of our existence; we humbly seek your divine grace. 
            Strength should not be merely physical but also mental and spiritual, granting us the power to stay firm on the path of Dharma. 
            Provide us with that wealth which is obtained through righteous means and which we can use for the welfare of the public. 
            The happiness obtained by your grace is that inner peace which is never disturbed by any worldly scarcity or suffering. 
            O God, purify our inner self and grant us the vision to perceive the glory of God in the entire moving and non-moving world. 
            You are the power that terminates the lethargy of our life and leads us to the supreme peaks of plenty and activity. 
            Singing your glories removes our afflictions and grants us a renewed sense of enthusiasm and unbreakable vital force. 
            O Soma, stay with us forever as our protector and Lord, graciously making our lives magnificent, successful, and renowned. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, and completely God-conscious.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 30,
        sanskrit = "एते असृग्रमिन्दवस्तिरः पवित्रमाशवः ।\nविश्वान्यभि सौभगा ॥ ३० ॥",
        hindiCommentary = """
            ये अत्यंत वेगवान और पवित्र सोमरस के कण (इन्दवः) छननी के माध्यम से निरंतर प्रवाहित होकर हमारे जीवन में सौभाग्य लेकर आ रहे हैं। 
            इनका यह तीव्र प्रवाह हमारे अंतःकरण की समस्त जड़ता और अशुद्धियों को नष्ट कर उसमें दिव्य गति और ऊर्जा का संचार करता है। 
            जैसे सोम की धाराएं पात्र में गिरकर उसे पूर्णता प्रदान करती हैं, वैसे ही आपकी कृपा हमारे जीवन के रिक्त पात्रों को आनंद से भर दे। 
            पवित्रता ही वह दिव्य माध्यम है जिससे ईश्वरीय शक्तियाँ हमारे निकट आती हैं और हमारे संकल्पों को ईश्वरीय संकल्पों से जोड़ती हैं। 
            हे देव, आप हमारे चंचल मन को अपनी पावन धारा से शुद्ध कर उसे एकाग्र, स्थिर और केवल श्रेष्ठ लक्ष्यों के प्रति समर्पित बना दें। 
            आपका यह निरंतर प्रवाह अज्ञान के काले आवरणों को हटाकर हमें सत्य के साक्षात् दर्शन कराने और ईश्वर के समीप ले जाने में सहायक है। 
            हम आपकी वंदना करते हैं क्योंकि आप ही आनंद के परम स्रोत हैं और अपने भक्तों के त्रिविध तापों को क्षण भर में हरने वाले देव हैं। 
            यज्ञ की इस पवित्र अग्नि में आपकी आहुति समस्त देवताओं को पुष्ट करती है और संपूर्ण ब्रह्मांड को नवीन जीवनी शक्ति प्रदान करती है। 
            हमें वह आध्यात्मिक सामर्थ्य और असीम धैर्य प्रदान करें जिससे हम संसार के द्वंद्वों से ऊपर उठकर सदैव शांत और सुखी रह सकें। 
            हे सोम, आपकी यह तेजस्वी धारा हमारे घरों को सुख, अखंड शांति और दिव्य समृद्धि से भर देने वाली एक मंगलकारी शक्ति के रूप में प्रकट हो।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, these swift and holy drops are flowing through the sacred filter, bringing forth immense good fortune and auspiciousness. 
            Their rapid flow is essential for destroying the lethargy and impurities of our inner self, infusing it with divine dynamism and energy. 
            Just as the streams of Soma fall into the ritual vessel to bring it to fullness, may your grace fill the empty vessels of our lives with bliss. 
            Purity is the divine medium through which celestial forces approach us and align our individual intentions with the Supreme Will. 
            O God, purify our restless minds with your holy stream and make them focused, steady, and entirely dedicated to the highest goals. 
            Your continuous flow acts as a catalyst in removing the dark veils of ignorance, helping us perceive Truth and drawing us closer to God. 
            We worship you as the ultimate source of ecstasy, the one who removes the three-fold sufferings of your devotees in an instant. 
            Your oblation in this sacred fire nourishes all the deities and provides fresh vitalizing energy to the entire moving and non-moving cosmos. 
            Grant us the spiritual capability and immense patience to rise above the dualities of the world and remain internally peaceful and happy. 
            O Soma, let this radiant stream of yours manifest as the generous and benevolent power that fills our homes with peace and prosperity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 31,
        sanskrit = "अभि प्र मन्दिनं गिरः सोमं पवस्व धारया ।\nइन्द्राय पातवे सुतम् ॥ ३१ ॥",
        hindiCommentary = """
            हे दिव्य सोमदेव! आप हमारी श्रद्धापूर्ण स्तुतियों के साथ अत्यंत आनंददायक और हर्षित होकर अपनी पावन धारा के साथ यहाँ निरंतर प्रवाहित हों। 
            आप विशेष रूप से देवराज इन्द्र के पान करने के लिए तैयार किए गए हैं, कृपया उन्हें तृप्त करने और अजेय बल प्रदान करने के लिए आगे बढ़ें। 
            इन्द्र और सोम का यह मिलन ब्रह्मांडीय शक्ति और आध्यात्मिक आनंद के उस महान संगम का प्रतीक है जो धर्म की रक्षा के लिए अनिवार्य है। 
            जब आप इन्द्र के अस्तित्व में प्रवाहित होते हैं, तो वे अजेय बन जाते हैं और हमारे जीवन के आंतरिक एवं बाह्य शत्रुओं का सफलतापूर्वक दमन करते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण को पूर्णतः शुद्ध कर हमें उच्चतर दिव्य अनुभूतियों और परमात्मा के साक्षात् के योग्य बनाने में सक्षम है। 
            हे देव, आप हमारे इस यज्ञ को सिद्ध करें और हमारे श्रेष्ठ संकल्पों को देवताओं के महान आशीर्वादों के साथ सफलतापूर्वक जोड़ देने की कृपा करें। 
            हमारी वाणी में वह सत्य, ओज और तेज भर दें कि हमारी भक्तिपूर्ण पुकार सीधे आपके और देवराज इन्द्र के हृदय के गहन स्तरों तक पहुँच सके। 
            आप ही वह दिव्य अमृत हैं जो मृत्यु के भय और सांसारिक मोह को समाप्त कर मनुष्य को अमरता और मोक्ष के परम पथ पर अग्रसर करता है। 
            हम अत्यंत श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन और परिवार में सदैव निरंतर और शाश्वत बना रहे। 
            हे पवमान सोम, आप हमारे परम रक्षक और मार्गदर्शक बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च और पवित्रतम शिखर पर पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Soma, flow here in your sacred stream, being most exhilarating and joyful, accompanied by our profound and devoted hymns. 
            You have been specifically extracted for the consumption of Lord Indra; please proceed toward the divine vessels to satisfy and strengthen him. 
            This union of Indra and Soma symbolizes the confluence of cosmic power and spiritual bliss, which is essential for the defense of Dharma. 
            When you flow through Indra's existence, he becomes invincible and subdues all the internal and external enemies of our lives successfully. 
            This holy stream of yours possesses the power to completely purify our inner self and make us worthy of higher divine realizations. 
            O God, make our sacrifice successful and meaningful, and successfully connect our noble resolutions with the great blessings of the gods. 
            Fill our voices with such truth, vigor, and brilliance that our devoted calls reach the deepest levels of your heart and Indra's heart. 
            You are the divine nectar that terminates the fear of death and worldly attachments, driving humans toward the path of immortality. 
            We worship you with profound devotion so that the nectar-like flow of your immense generosity remains forever constant in our lives. 
            O Pavamana Soma, stay as our supreme protector and guide, leading us graciously to the highest and holiest peaks of success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 32,
        sanskrit = "तं वो मदाय घृष्वये सोमं विश्वाभिरूतिभिः ।\nइन्द्राय गायत सुतम् ॥ ३२ ॥",
        hindiCommentary = """
            हे दिव्य स्तोताओं! आप इन्द्र के उस 'घृष्वये' (शत्रुओं का दमन करने वाले) मद और आनंद के लिए सोमरस का अत्यंत भक्तिपूर्वक गान करें। 
            आप अपनी समस्त रक्षात्मक और मंगलकारी शक्तियों के साथ इस पवित्र और मधुर रस को इन्द्रदेव के पान के लिए सादर समर्पित करने की कृपा करें। 
            इन्द्र की प्रसन्नता ही इस संपूर्ण जगत की व्यवस्था और संतुलन का मुख्य आधार है, और सोम ही उनकी उस प्रसन्नता और शक्ति का आदि स्रोत है। 
            जब हम मिल-जुलकर सामूहिक रूप से आपकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य सुरक्षा चक्र का निर्माण होता है। 
            हे देव, आप अपनी प्रचंड और अजेय शक्ति से हमारे जीवन के समस्त अमंगल, दरिद्रता और मानसिक व्याधियों को भस्म करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे पवित्र संकल्पों को वह फौलादी दृढ़ता प्रदान करती हैं जिससे हम धर्म और सत्य के मार्ग पर कभी विचलित नहीं होते। 
            हम अपनी विनम्र और आर्त प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक सूक्ष्म अभाव को अपनी अनंत उदारता से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे प्रत्येक परिश्रम और त्याग को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे सोम, आप अपनी अनंत महिमा और ऐश्वर्य के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी अजेय और दिव्य सुरक्षा के घेरे में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण और आध्यात्मिक उत्थान सुनिश्चित है, हम आपकी इस भव्य और आनंदमयी शक्ति की श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O divine singers of hymns, chant most devotedly for that exhilarating joy of Indra which subdues and terminates all opposing forces. 
            Dedicate this sacred and sweet nectar for the consumption of Lord Indra along with all your protective and auspicious divine powers. 
            Indra's satisfaction is the main foundation of the order and balance of the entire universe, and Soma is the original source of his might. 
            When we collectively sing your glories in a group, an extremely positive, energetic, and divine cycle of protection is built around us. 
            O God, with your fierce and invincible power, please graciously burn away all the inauspiciousness, poverty, and mental ailments of our lives. 
            Your protective energies provide our holy resolutions with that steel-like firmness through which we never waver from the path of Truth. 
            We invoke you with our humble and sincere prayers so that you may fulfill every subtle scarcity of our existence with your infinite generosity. 
            You are the supreme authority that makes our every effort and sacrifice meaningful and continuously drives us forward on the path of growth. 
            O Soma, reside in our homes and hearts with your infinite glory and splendor, and keep us forever safe under your divine and invincible protection. 
            Our ultimate well-being and spiritual elevation are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 33,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ ३३ ॥",
        hindiCommentary = """
            हे पवमान कवि (क्रांतदर्शी) सोम! आपकी अत्यंत शक्तिशाली और पवित्र लहरें रत्नों और दिव्य गुणों की कामना करती हुई तीव्र गति से प्रवाहित हो रही हैं। 
            आप स्वयं शाश्वत ज्ञान के पुंज हैं और जब आप अपनी दिव्य तरंगों के साथ बहते हैं, तो आप अपने उपासकों के लिए सौभाग्य और शांति का संदेश लाते हैं। 
            जैसे समुद्र की लहरें तट पर बहुमूल्य और दुर्लभ वस्तुएं लेकर आती हैं, वैसे ही आपकी धारा हमारे जीवन में आध्यात्मिक रत्न और सद्गुणों का संचार करती है। 
            हे देव, आपकी ये पावन लहरें हमारे मन के समस्त संताप, अज्ञान और नकारात्मक विचारों को बहा ले जाएं और हमें शांति के सागर में पूरी तरह सराबोर कर दें। 
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करती है जिससे हम संसार के भ्रामक मायाजाल को भेदकर ईश्वर के वास्तविक और दिव्य स्वरूप का दर्शन करने में सफल होते हैं। 
            हमें वह 'रत्न' (विवेक और वैराग्य) प्रदान करने की कृपा करें जो हमारे चरित्र को बलवान और उज्ज्वल बनाएं ताकि हम समाज के लिए एक महान आदर्श बनें। 
            आप ही वह आदि शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों में बदलने का अद्भुत और अमोघ सामर्थ्य रखती हैं, हम आपकी शरण में हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का निरंतर गान करते हैं ताकि आपकी कृपा की वर्षा हमारे जीवन और परिवार में सदैव निरंतर, सुखद और अखंड बनी रहे। 
            जैसे तरंगें निरंतरता का प्रतीक हैं, वैसे ही हमारी अटूट भक्ति भी आपके प्रति निरंतर और निष्काम बनी रहे, यही हमारी आपसे करबद्ध प्रार्थना है। 
            हे दिव्य सोम, आप अपनी इन पावन और तेजस्वी लहरों के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे परमात्मा के शाश्वत सान्निध्य के योग्य बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Kavi (wise seer) Soma, your extremely powerful and holy waves flow with speed, seeking gems and divine qualities for our lives. 
            You are the mass of eternal knowledge, and as you flow with your divine ripples, you bring messages of good fortune and peace to your followers. 
            Just as ocean waves bring precious and rare objects to the shore, your sacred current infuses spiritual gems and virtues into our daily existence. 
            O God, let these holy waves wash away all the heat of our sorrows, ignorance, and negative thoughts, immersing us in the ocean of peace. 
            Your energy provides us with the capability to pierce through the deceptive illusions of the world and perceive the actual nature of God. 
            Graciously bestow upon us those 'gems' (discernment and detachment) that make our character strong and bright, so we become an ideal for society. 
            You are the primordial power that possesses the strength to transform our subtle intentions into cosmic achievements; we seek your refuge. 
            We worship you with devotion so that the rain of your grace remains continuous, pleasant, and unbroken within our lives and our families. 
            Just as waves represent continuity, may our unshakable devotion toward you remain constant and selfless; this is our humble and heartfelt prayer. 
            O Divine Soma, through these holy and radiant waves of yours, purify our inner self and make it worthy of the eternal proximity of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 34,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ ३४ ॥",
        hindiCommentary = """
            हे सोमदेव! आप वाणी के अधिपति और ज्ञान के अथाह समुद्र होकर अपनी दिव्य चेतना (चित्तिभिः) के साथ अत्यंत पवित्र होकर यहाँ प्रवाहित हों। 
            आप दिव्य गर्जना करते हुए अपने शाश्वत स्थान पर विराजमान हों, जो आपकी अजेय शक्ति, दिव्यता और सर्वोच्चता का साक्षात् और अडिग प्रतीक है। 
            आप ही वह सर्वोच्च ऊर्जा हैं जो ऋषियों के पवित्र कंठ में वेदमंत्रों का संचार करती हैं और उन्हें जगत के परम कल्याण के लिए सदैव प्रेरित करती हैं। 
            जैसे समुद्र अथाह और अनंत रहस्यों से भरा होता है, वैसे ही आपका स्वरूप भी अनंत है, जो हमें शाश्वत आध्यात्मिक शांति और आनंद प्रदान करने वाला है। 
            हे देव, आप हमारे विचारों और वचनों में सत्य की वाणी बनकर विराजें ताकि हम सदैव मंगलकारी, मीठे और कल्याणकारी मार्ग पर ही अग्रसर रहें। 
            आपकी गर्जना हमारे भीतर के अज्ञान, आलस्य और तामसी प्रवृत्तियों को जगाकर हमें आत्मज्ञान और ईश्वर की साधना के मार्ग पर सक्रिय कर देने वाली है। 
            हमें वह मेधा शक्ति और प्रज्ञा प्रदान करें जिससे हम वेदों के गूढ़ अर्थों को आत्मसात कर सकें और अपने जीवन को उनके श्रेष्ठ सिद्धांतों के अनुरूप ढाल सकें। 
            आपकी कृपा से हमारा मन एक शांत, शीतल और गहरे सरोवर की तरह बन जाए जिसमें आपकी भक्ति का प्रकाश सदैव सूर्य के समान जगमगाता रहे। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को पूर्णतः शुद्ध कर उसे दिव्यता के निवास योग्य एक पवित्र स्थान बनाते हैं। 
            हे पवमान सोम, आप अपनी अनंत महिमा के साथ हमारे इस यज्ञ में प्रतिष्ठित हों और हमें परम ज्ञान और ईश्वर की प्राप्ति का आशीर्वाद प्रदान करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow here in your most purified state with divine consciousness, being the leader of speech and the fathomless ocean of wisdom. 
            Seat yourself upon your eternal source with a celestial roar, symbolizing your invincible power, divinity, and ultimate supreme authority. 
            You are the supreme energy that infuses Vedic mantras into the holy throats of the seers and perpetually inspires them for the world's welfare. 
            Just as the ocean is fathomless and filled with infinite mysteries, your nature is infinite and capable of granting us eternal spiritual peace. 
            O God, reside in our thoughts and words as the voice of Truth so that we may always walk on the path of auspiciousness and benevolence. 
            Your roar awakens us from internal ignorance, lethargy, and dark tendencies, activating us on the path of Self-realization and discipline. 
            Bestow upon us that intellectual capability and wisdom through which we can assimilate the meanings of the Vedas and shape our lives by them. 
            By your grace, may our minds become like a calm, cool, and deep lake in which the light of your devotion shines as brilliantly as the Sun. 
            We worship you with devotion because you are the one who completely purifies our inner self and makes it a holy fit dwelling for divinity. 
            O Pavamana Soma, reside in our sacrifice with your infinite glory and grant us the blessings of supreme knowledge and the attainment of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 35,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ३५ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम शक्ति, श्रेष्ठतम ऐश्वर्य और अखंड दिव्य सुख प्रदान करने के लिए पूर्णतः पवित्र होकर यहाँ प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, आरोग्यता और सामर्थ्य लाने वाली है, हम आपकी असीम और दयालु कृपा की याचना करते हैं। 
            शक्ति केवल बाह्य नहीं, बल्कि आंतरिक और आत्मिक भी होनी चाहिए, जो हमें धर्म के मार्ग पर अडिग रहने और सत्य का पक्ष लेने के लिए बल प्रदान करे। 
            हमें वह धन और संसाधन प्रदान करें जो न्यायपूर्ण रीति से प्राप्त किए गए हों और जिनका उपयोग हम मानवता की सेवा के लिए अत्यंत गौरव के साथ कर सकें। 
            आपकी कृपा से प्राप्त होने वाला सुख वह आत्मिक शांति है जो सांसारिक उथल-पुथल या दुखों से कभी भी विचलित नहीं होती और जो सदैव आनंदित रखती है। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम ईश्वर की महिमा और उपस्थिति को इस चराचर जगत के कण-कण में देख सकें। 
            आप ही वह पराशक्ति हैं जो हमारे जीवन की जड़ता और आलस्य को समाप्त कर हमें प्रचुरता, ज्ञान और सक्रियता के सर्वोच्च शिखर पर पहुँचाने में समर्थ हैं। 
            आपकी महिमा का निरंतर गान करने से हमारे समस्त कष्टों का निवारण होता है और हमें नवीन उत्साह, आशा और अटूट जीवनी शक्ति की प्राप्ति होती रहती है। 
            हे सोम, आप हमारे परम स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी, परोपकारी और महान बनाने की असीम कृपा करने का कष्ट करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट, पवित्र और पूर्णतः ईश्वरमय बना रहे, यही प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state to bestow upon us superior strength, excellent abundance, and unbroken divine happiness. 
            Your holy stream brings prosperity, health, and capability into every single area of our existence; we humbly seek your boundless mercy. 
            Strength should not be merely physical but also internal and spiritual, granting us the power to stay firm on the path of Dharma and Truth. 
            Provide us with that wealth and those resources which are obtained through righteous means and which we can use for the service of humanity. 
            The happiness obtained by your grace is that inner peace which is never disturbed by worldly turmoil or sorrows and keeps us forever joyful. 
            O God, purify our inner self and grant us the divine vision to perceive the glory and presence of God in every particle of the entire world. 
            You are the supreme power that terminates the lethargy and laziness of our life and leads us to the absolute peaks of plenty and wisdom. 
            Singing your glories continuously removes all our afflictions and grants us a renewed sense of enthusiasm, hope, and vitalizing energy. 
            O Soma, always stay with us as our protector and Lord, graciously making our lives magnificent, successful, altruistic, and noble. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, holy, and completely God-conscious in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 36,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ३६ ॥",
        hindiCommentary = """
            हे पवमान और पावक सोमदेव! आप स्वर्ग की दिव्य कांति और प्रकाश के समान अद्भुत ऐश्वर्यों और आध्यात्मिक निधियों के परम अधिपति और स्वामी हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली प्रेरणा, सात्विक अन्न और जीवनी ऊर्जा लेकर आएं जो हमारे जीवन को सफल और दिव्य बनाए। 
            आपकी असीम कृपा से हमारे जीवन में किसी भी वस्तु का लेशमात्र भी अभाव न रहे और हम सदैव सुख, शांति, संतोष और समृद्धि से परिपूर्ण बने रहें। 
            हे देव, आप हमारे अंतःकरण को पूर्णतः शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा की सर्वव्यापकता और उनके प्रेम का अनुभव कर सकें। 
            आप ही वह महाशक्ति हैं जो हमारे जीवन की दरिद्रता, अज्ञान और भय को समाप्त कर हमें प्रचुरता और निर्भयता के सर्वोच्च शिखर पर पहुँचाने में समर्थ हैं। 
            हमें वह 'इषम्' प्रदान करें जो हमारे शरीर और आत्मा दोनों को पूर्णतः तृप्त कर हमें दिव्यता और मोक्ष के परम मार्ग की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे समस्त दुखों का नाश होता है और हमें वह नवीन उत्साह मिलता है जो हमें जीवन के कार्यों में कभी थकने नहीं देता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार और कृपालु दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो समय के साथ कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश, कीर्ति और ईश्वर की ओर ले जाने वाला सही मार्ग निरंतर दिखाती रहे। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में सुरक्षित रखें और हमारा मंगलमय जीवन सदैव आपकी मर्यादाओं में सुखी रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the supreme master of marvelous riches and spiritual treasures that shine like celestial light. 
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous nourishment, and energy that make our lives successful and divine. 
            By your grace, let there be no scarcity of any kind in our lives, and may we remain forever full of peace, contentment, and prosperity. 
            O God, purify our inner self completely and grant us the divine vision to experience the omnipresence of God and His infinite love for us. 
            You are the supreme power that possesses the strength to terminate the poverty, ignorance, and fear of our life and lead us to plenty. 
            Provide us with 'Isham'—divine inspiration—that satisfies both our body and soul and leads us toward the path of divinity and liberation. 
            Singing your glories destroys all our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of our daily tasks. 
            O Soma, come into our homes and hearts as the generous and merciful giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and continuously show us the pathway leading toward fame, splendor, and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever safe and happy within your laws.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 37,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ३७ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और अडिग साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
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
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 38,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ३८ ॥",
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
        id = 39,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ३९ ॥",
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
        id = 40,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ४० ॥",
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
        id = 41,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ४१ ॥",
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
        id = 42,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ४२ ॥",
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
        id = 43,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ४३ ॥",
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
        id = 44,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ४४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त, पवित्र और प्रखर ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म संपन्न करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च दिव्य प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या नकारात्मक विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
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
        id = 45,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ४५ ॥",
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
        id = 46,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ४६ ॥",
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
        id = 47,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ४७ ॥",
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
        id = 48,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ४८ ॥",
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
        id = 49,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ४९ ॥",
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
        id = 50,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ५० ॥",
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
            id = 51,
            sanskrit = "अभि प्र वः सुरधसं इन्द्रं अर्चत गायत ।\nसखायः सप्रथस्तमम् ॥ ५१ ॥",
            hindiCommentary = """
            हे मित्रों! आप उन इन्द्रदेव की अर्चना और महिमा का गान करें जो अत्यंत उदार, ऐश्वर्यशाली और व्यापक (सप्रथस्तमम्) हैं। 
            वे भक्तों के प्रति अत्यंत दयालु हैं और उनके सान्निध्य में ही वास्तविक सुख और समृद्धि की प्राप्ति संभव है। 
            इन्द्र की व्यापकता का अर्थ है कि उनकी चेतना ब्रह्मांड के प्रत्येक तत्व में रची-बसी है और वे सबको नियंत्रित करते हैं। 
            जब हम मिलकर उनका गान करते हैं, तो हमारे भीतर के नकारात्मक विचार धीरे-धीरे शांत होने लगते हैं और प्रकाश का उदय होता है। 
            यह मंत्र हमें सामूहिक भक्ति और एकता का संदेश देता है, जहाँ साझा प्रार्थना से दैवीय शक्तियों का आह्वान किया जाता है। 
            आपकी यह उदारता हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता और अखंड सौभाग्य प्रदान करने वाली है। 
            जैसे सूर्य की किरणें अंधकार को चीरकर प्रकाश फैलाती हैं, वैसे ही इन्द्र की स्तुति हमारे अज्ञान के परदों को हटा देती है। 
            हमें वह आध्यात्मिक सामर्थ्य दें कि हम संसार के द्वंद्वों से ऊपर उठकर सदैव आपके दिव्य सत्य में प्रतिष्ठित रहें। 
            आप ही वह ऊर्जा हैं जो हमारे शिथिल मन को जाग्रत करती हैं और हमें कर्तव्य-पथ पर निरंतर गतिशील बनाए रखती हैं। 
            हे देवराज, आप हमारे घर और हृदय में विराजें और अपनी असीम कृपा से हमारे जीवन को मंगलमय और सार्थक बनाएं।
        """.trimIndent(),
            englishCommentary = """
            O friends, offer your worship and sing the profound glories of Lord Indra, who is most generous, wealthy, and vastly pervasive. 
            He is exceedingly compassionate toward his devotees, and it is only in his proximity that true happiness and prosperity are possible. 
            Indra's pervasiveness implies that his consciousness is woven into every element of the cosmos, governing and sustaining all. 
            When we collectively sing his praises, our internal negative thoughts gradually subside, making way for the rise of inner light. 
            This mantra conveys a message of collective devotion and unity, where shared prayer invokes the highest celestial powers. 
            Your generosity possesses the strength to remove every scarcity in our lives, granting us completeness and unbroken fortune. 
            Just as the rays of the sun pierce through darkness to spread light, the praise of Indra removes the veils of our ignorance. 
            Grant us the spiritual capability to rise above worldly dualities and remain forever established in your divine Truth. 
            You are the energy that awakens our lethargic minds and keeps us constantly dynamic on the path of our higher duties. 
            O King of Gods, reside in our homes and hearts, and with your infinite grace, make our lives auspicious and meaningful.
        """.trimIndent()
        ),
PurvarchikaVerse(
id = 52,
sanskrit = "तमु वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ५२ ॥",
hindiCommentary = """
            आप उन अद्भुत और कष्टों को हरने वाले इन्द्र की स्तुति करें जो सोमरस के आनंद में मग्न होकर भक्तों का कल्याण करते हैं। 
            जैसे माताएं और गौएँ अपने बछड़े (वत्सम्) की ओर अत्यंत प्रेम और व्याकुलता से दौड़ती हैं, वैसे ही स्तुतियां इन्द्र की ओर बढ़ती हैं। 
            इन्द्र को 'वृषभ' (शक्तिशाली बैल) कहा गया है, जो सामर्थ्य, प्रजनन क्षमता और ब्रह्मांडीय ऊर्जा के पुंज का प्रतीक है। 
            भक्त की वाणी जब हृदय की गहराई से निकलती है, तो वह साक्षात् देवत्व को आकर्षित करने और उसे जाग्रत करने में समर्थ होती है। 
            आपकी उपस्थिति मात्र से हमारे मन की चंचलता समाप्त होती है और हम एकाग्र होकर आत्म-साक्षात्कार की ओर बढ़ते हैं। 
            जैसे बछड़ा माँ से पोषण पाता है, वैसे ही हम आपकी कृपा से आध्यात्मिक ज्ञान और भौतिक समृद्धि का पोषण प्राप्त करते हैं। 
            आपकी असीम शक्ति हमें वह सुरक्षा प्रदान करती है जिससे हम संसार के किसी भी भय से मुक्त होकर निर्भीक जीवन जीते हैं। 
            हम अपनी मधुर वाणी से आपको प्रसन्न करने का प्रयास करते हैं ताकि आप हमारे दुखों का अंत कर हमें आनंदित कर सकें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी रिक्त नहीं रहता, उसे विवेक और ऐश्वर्य की प्रचुरता स्वतः ही प्राप्त हो जाती है। 
            हे देवराज, आप हमारे हृदयों में भक्ति का अखंड संचार करें और हमें सदैव अपनी दिव्य और शीतल छाया में सुरक्षित रखें।
        """.trimIndent(),
englishCommentary = """
            Praise that wonderful Indra, the subduer of afflictions, who rejoices in the Soma nectar to bless his devoted followers. 
            Just as mothers and cows run with intense love and longing toward their calf (Vatsam), so do our hymns flow toward Indra. 
            Indra is called 'Vrishabha' (the mighty bull), symbolizing power, fertility, and the immense mass of cosmic energy. 
            When a devotee's voice arises from the depths of the heart, it possesses the capability to attract and awaken divinity itself. 
            Your mere presence terminates the restlessness of our minds, allowing us to move toward self-realization with focus. 
            As a calf receives vital nourishment from its mother, we receive the sustenance of spiritual wisdom and material plenty through you. 
            Your infinite power provides us with a security that allows us to lead a fearless life, free from all worldly terrors. 
            We strive to please you with our sweet voices so that you may terminate our sufferings and fill us with profound joy. 
            A seeker who takes refuge in Lord Indra never remains empty; they are naturally gifted with an abundance of discernment and riches. 
            O King of Gods, infuse our hearts with an unbroken stream of devotion and keep us forever safe under your divine and cool shadow.
        """.trimIndent()
),
PurvarchikaVerse(
id = 53,
sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ५३ ॥",
hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों (नृभिः) द्वारा अपनी पवित्र स्तुतियों के माध्यम से निरंतर प्रदीप्त और तेजस्वी बनाए जाते हैं। 
            आप हमारे लिए शीघ्र ही (मक्षूणी) वह अन्न, शक्ति और विजय लेकर आने की कृपा करें जो हमारे जीवन को उन्नत बना सके। 
            आप हमारे लिए एक कल्याणकारी (शिवः) मित्र (सखा) बनकर हमारे जीवन की इस दुर्गम यात्रा को सुगम और सफल बनाएं। 
            इन्द्र की मित्रता का अर्थ है कि स्वयं ब्रह्मांड की सर्वोच्च शक्ति हमारे पक्ष में खड़ी है और हमारा मार्गदर्शन कर रही है। 
            सच्चा मित्र वही है जो संकट के समय साथ न छोड़े, और आपसे श्रेष्ठ मित्र इस संपूर्ण चराचर जगत में अन्य कोई नहीं है। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम सांसारिक प्रलोभनों और बाधाओं को सफलतापूर्वक पार करने में सक्षम हों। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव न हो। 
            जब आप हमारे सखा बनते हैं, तब बड़ी से बड़ी आपदा भी हमारे मार्ग में रुकावट नहीं बन सकती और हम विजयी होते हैं। 
            आपकी ऊर्जा हमारे प्राणों में नवीन उत्साह बनकर बहती है और हमें सदैव श्रेष्ठ और परोपकारी कर्म करने के लिए प्रेरित करती है। 
            हे इन्द्र, आप हमारे रक्षक और मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की महान कृपा करें।
        """.trimIndent(),
englishCommentary = """
            O Lord Indra, you are continuously kindled and made radiant through the sacred hymns chanted by noble men (Nribhih). 
            Graciously bring to us very quickly (Makshuni) that nourishment, power, and victory which will elevate our daily existence. 
            Become an auspicious (Shivah) friend (Sakha) to us, making this difficult journey of life smooth, easy, and successful. 
            The friendship of Indra means that the supreme power of the cosmos stands by our side, guiding our every single step. 
            A true friend is one who never deserts in times of crisis, and there is no friend superior to you in this entire universe. 
            Provide us with the inner strength and courage required to successfully transcend worldly temptations and daunting obstacles. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources or peace in our homes. 
            When you become our companion, even the greatest calamity cannot block our path, and we emerge victorious in our endeavors. 
            Your energy flows through our being as a new wave of enthusiasm, perpetually inspiring us to perform noble and altruistic deeds. 
            O Indra, stay with us as our protector and guide, and graciously make our lives magnificent, successful, and highly renowned.
        """.trimIndent()
),
PurvarchikaVerse(
id = 54,
sanskrit = "य इन्द्र सोमपातमो मदस्तं प्रत्नथा सहः ।\nअषाळ्हं सहमानं पृतन्यन्तं सं यन्मध्वो अदुद्रवत् ॥ ५४ ॥",
hindiCommentary = """
            हे इन्द्रदेव! जो सोमरस (सोमपातमो) अत्यंत आनंददायक है, उसे आप अपनी प्राचीन रीति (प्रत्नथा) के अनुसार हर्षपूर्वक ग्रहण करें। 
            वह सोम आपको वह अजेय बल प्रदान करे जो किसी भी शत्रु द्वारा पराजित न होने वाला (अषाळ्हं) और सबको वश में करने वाला हो। 
            जब मधुर सोमरस आपकी दिव्य चेतना में प्रवाहित होता है, तो आप शत्रुओं की विशाल सेनाओं को कुचलने की शक्ति प्राप्त करते हैं। 
            सोम का पान केवल एक अनुष्ठान नहीं, बल्कि यह आपकी असीम ऊर्जा को जाग्रत करने और जगत की रक्षा का एक पवित्र माध्यम है। 
            आप ही हमारी विजय के आधार हैं और युद्ध में शत्रुओं का दमन करने वाले उस अजेय वीर के रूप में प्रतिष्ठित हैं जिसकी कोई सीमा नहीं। 
            आपकी वीरता समस्त लोकों में विख्यात है, और आप ही ऋत (सत्य) के मार्ग के सबसे बड़े रक्षक और सजग प्रहरी के रूप में जाने जाते हैं। 
            इस मधुर रस के प्रभाव से आप अत्यंत प्रसन्न होकर हमारे इस यज्ञ को सिद्ध करते हैं और हमें अभीष्ट फल की प्राप्ति कराते हैं। 
            हम श्रद्धापूर्वक आपको यह सोमरस अर्पित करते हैं ताकि आप हमारे भीतर भी साहस और दृढ़ संकल्प का दिव्य बीज बो सकें। 
            आपके सान्निध्य में हमारा मन समस्त भयों से मुक्त होता है और हम श्रेष्ठ एवं कल्याणकारी लक्ष्यों की ओर निरंतर आगे बढ़ते हैं। 
            हे इन्द्र, आप अपनी अनंत ऊर्जा से हमारे जीवन के अंधकारमय विरोधियों का समूल नाश कर हमें प्रकाश और सत्य की ओर ले चलें।
        """.trimIndent(),
englishCommentary = """
            O Lord Indra, please accept the Soma juice (Somapatamo) which is most exhilarating, following the ancient traditions (Pratnatha). 
            May this Soma grant you that invincible strength which cannot be conquered (Asalham) and which subdues all opposing entities. 
            When the sweet Soma juice flows into your divine consciousness, you gain the power to crush the vast and threatening armies of enemies. 
            Consuming Soma is not just a ritual; it is a sacred medium to awaken your infinite energy for the absolute protection of the world. 
            You are the foundation of our victories and are established as the unconquerable hero who subdues all forces of unrighteousness. 
            Your heroism is renowned across all realms, and you are known as the greatest protector and sentinel of the Eternal Truth (Rta). 
            Under the influence of this sweet nectar, you rejoice and ensure the ultimate success and fulfillment of our sacrificial ritual. 
            We offer this Soma with deep devotion so that you may sow the divine seeds of courage and firm resolve within our own hearts. 
            In your divine presence, our minds become free from all fears, and we advance steadily toward noble and beneficial goals. 
            O Indra, with your infinite energy, completely destroy the dark adversaries of our life and lead us toward light and Truth.
        """.trimIndent()
),
PurvarchikaVerse(
id = 55,
sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ५५ ॥",
hindiCommentary = """
            हे वृत्रहन् (अज्ञान के नाशक) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष (अर्धम्) में अपनी असीम कृपा के साथ अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल (महाँ महीभिः) रक्षात्मक शक्तियों (ऊतिभिः) के साथ हमारे सहायक और रक्षक बनकर यहाँ आएं। 
            आपकी उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता प्रदान करती है जिससे हम जीवन की किसी भी विषम परिस्थिति में डगमगाते नहीं हैं। 
            जब आप हमारे पक्ष में खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति या बाधा हमें अपने मार्ग से विचलित नहीं कर सकती। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का अंत कर हमारे जीवन में ज्ञान की अविरल और पवित्र गंगा प्रवाहित करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा घेरा बनाती हैं जिसमें कोई भी बुराई या पाप कभी प्रवेश नहीं कर सकता। 
            हम अपनी विनम्र और हृदयस्पर्शी प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से मिटा दें। 
            आप ही वह शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता के साथ हमारे घर और हृदय में विराजें और हमें अपने मंगलकारी और दिव्य आशीषों से कृतार्थ करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
englishCommentary = """
            O Indra, the slayer of Vritra (Vritrahan), please do come graciously to our sacrificial ground and take our side (Ardham). 
            Come as our helper and guardian along with your grand and immensely vast (Maham Mahibhih) protective powers and assistances (Utibhih). 
            Your presence provides our resolutions with that steel-like firmness needed to remain unshaken in any adverse life situation. 
            When you stand on our side, no negative force or obstacle in the world can ever sway or distract us from our righteous path. 
            O King of Gods, graciously destroy the Vritra of ignorance within us and let the continuous river of knowledge flow in our lives. 
            Your protective energies build such a shield of security around us that no form of evil or sin can ever find its way inside. 
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your light. 
            You are the supreme power that makes our hard work meaningful and carries us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your infinite generosity and bless us with your most auspicious and divine favors. 
            Our complete well-being is guaranteed under your merciful gaze; we repeatedly bow before your magnificent and invincible power.
        """.trimIndent()
),
PurvarchikaVerse(
id = 56,
sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ५६ ॥",
hindiCommentary = """
            हे शतक्रतो (सैकड़ों यज्ञों के स्वामी) इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि, आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी माता हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र सच्चे हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा पालन कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के ज्ञात और अज्ञात संकटों से रक्षा करते हैं, वैसे ही आप हमारी सूक्ष्म देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और प्रेम की कोई सीमा नहीं है, और हम एक समर्पित संतान के रूप में आपकी पावन वंदना करते हैं। 
            आपकी असीम कृपा से ही हमें वह मानसिक शांति प्राप्त होती है जो संसार की किसी भी नश्वर और भौतिक वस्तु में अत्यंत दुर्लभ और अप्राप्य है। 
            हम अपनी संपूर्ण श्रद्धा और अटूट विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान के प्रकाश से भी आलोकित करें। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को जलाकर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाने की कृपा करे।
        """.trimIndent(),
englishCommentary = """
            O Shatakratu (Lord of a hundred sacrifices) Indra, you are our superior intellect, our supreme Father, and our most affectionate Mother. 
            You have manifested in our lives as the foundation of our entire existence and our sole well-wisher, continuously nurturing us. 
            Just as parents protect and nourish their innocent child from all kinds of known and unknown dangers, you take care of our subtle needs. 
            We seek from you that 'Sumnam' (supreme bliss and peace) which is only granted to true and sincere devotees seeking your refuge. 
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the web of ignorance. 
            O King of Gods, there is no limit to your maternal affection and love for us, and we worship you with the simple heart of a dedicated child. 
            By your boundless grace alone do we find the mental tranquility that is extremely rare and unattainable in any perishable worldly object. 
            We offer our complete faith and unwavering trust at your divine feet so that you may forever keep us fully safe within your shadow. 
            O Indra, bring abundance into every field of our existence and make us successful while illuminating us with the light of Self-realization. 
            May your radiant stream burn away the darkness of our ignorance and successfully lead us to the realization of the Supreme Truth.
        """.trimIndent()
),
PurvarchikaVerse(
id = 57,
sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ५७ ॥",
hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज (वृषा) के रूप में इस संपूर्ण ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान (सवन) में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत संचालित होता है, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य और धर्म की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और दुख सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति और साहस प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर और नश्वर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वर के समीप रहें।
        """.trimIndent(),
englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session (Savana), we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe is governed; by consuming Soma, you become more radiant and luminous. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities and afflictions of our lives vanish forever by your gracious favor. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is totally rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
),
PurvarchikaVerse(
id = 58,
sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ५८ ॥",
hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों (पुरूणाम्) के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सोए हुए साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और अखंड आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल नहीं रहता, उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का दुर्लभ वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
englishCommentary = """
            O devotees who know the divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns (Purunam), and no being can ever surpass the limit of his might. 
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
id = 59,
sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ५९ ॥",
hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों और साधकों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
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
id = 60,
sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ६० ॥",
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
id = 61,
sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ६१ ॥",
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
id = 62,
sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ६२ ॥",
hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं। 
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
id = 63,
sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ६३ ॥",
hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्रदेव! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और अजेय ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वरमय रहें।
        """.trimIndent(),
englishCommentary = """
            O Indra, the guide on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
),
PurvarchikaVerse(
id = 64,
sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ६४ ॥",
hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
englishCommentary = """
            O knower of divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
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
id = 65,
sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ६५ ॥",
hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
englishCommentary = """
            O my dear friends, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
),
PurvarchikaVerse(
id = 66,
sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ६६ ॥",
hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
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
id = 67,
sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ६७ ॥",
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
id = 68,
sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ६८ ॥",
hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं। 
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
id = 69,
sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ६९ ॥",
hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्रदेव! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और अजेय ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वरमय रहें।
        """.trimIndent(),
englishCommentary = """
            O Indra, the guide on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
),
PurvarchikaVerse(
id = 70,
sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ७० ॥",
hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
englishCommentary = """
            O knower of divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
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
id = 71,
sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ७१ ॥",
hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
englishCommentary = """
            O my dear friends, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
),
PurvarchikaVerse(
id = 72,
sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ७२ ॥",
hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में अत्यंत गौरव के साथ प्रकाशित करती हैं। 
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
id = 73,
sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ७३ ॥",
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
id = 74,
sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ७४ ॥",
hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं। 
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
id = 75,
sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ७५ ॥",
hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्रदेव! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और अजेय ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और दुख सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वरमय रहें।
        """.trimIndent(),
englishCommentary = """
            O Indra, the guide on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
),
    PurvarchikaVerse(
        id = 76,
        sanskrit = "त्वं न इन्द्र ऋतयुरपां नेतः परिष्कृतः ।\nमहाँ महीभिः ऊतिभिः ॥ ७६ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप सत्य के प्रेमी (ऋतयुः) और समस्त जलों एवं प्राण-शक्तियों के नियामक (नेतः) के रूप में प्रतिष्ठित हैं। 
            आप पवित्रता से परिष्कृत होकर हमारे यज्ञ में अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ पधारने की कृपा करें। 
            सत्य का मार्ग ही जीवन का वास्तविक आधार है, और आप उस मार्ग के रक्षक बनकर हमें सदैव धर्म में प्रतिष्ठित रखते हैं। 
            आपकी उपस्थिति हमारे भीतर की प्राण ऊर्जा को शुद्ध करती है और हमें दिव्य चेतना के साथ एकरूप होने का सामर्थ्य देती है। 
            जब आप अपनी अजेय शक्तियों के साथ हमारे सहायक बनते हैं, तो संसार की कोई भी प्रतिकूल शक्ति हमें भयभीत नहीं कर सकती। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख, शांति और पवित्रता का वास होता है। 
            हम अपनी विनम्र और आर्त पुकार से आपको निरंतर पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी उदारता से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक उन्नति के पथ पर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी दिव्य महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी अजेय सुरक्षा की शीतल छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण और सौभाग्य सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are established as the lover of Truth (Rtayuh) and the leader and regulator of all waters and vital forces. 
            Being refined by purity, please manifest in our sacrifice along with your grand and immensely vast protective divine powers. 
            The path of Truth is the actual foundation of life, and as its protector, you always keep us established in Dharma. 
            Your sacred presence purifies the vital energy within us and grants us the capability to unify with the divine consciousness. 
            When you become our helper with your invincible powers, no adverse force in the world can ever intimidate or disturb us. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness and peace reside. 
            We invoke you with our humble and sincere cries so that you may fulfill every scarcity of our existence with your infinite generosity. 
            You are the supreme authority that makes our hard work meaningful and continuously drives us forward on the path of evolution. 
            O Indra, reside in our homes and hearts with your divine glory and keep us forever safe under the cool shadow of your protection. 
            Our ultimate well-being and good fortune are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 77,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ७७ ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो पवित्र सोमरस का पान कर आनंदित होते हैं। 
            वे हमें ऐश्वर्य और दिव्य धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महिमा भक्तों की श्रद्धापूर्ण वाणी से निरंतर बढ़ती रहती है। 
            जैसे माताएं और गौएँ अपने प्रिय बछड़े की ओर वात्सल्य भाव से दौड़ती हैं, वैसे ही हमारी स्तुतियां और हृदय की पुकार इन्द्र की ओर प्रवाहित होती हैं। 
            आपकी दिव्य उपस्थिति मात्र से हमारे मन की चंचलता और अशांति समाप्त होती है और हम एकाग्र होकर आपकी असीम सत्ता का अनुभव करते हैं। 
            हे शक्तिशाली इन्द्र, आप हमारे जीवन रूपी यज्ञ के मुख्य आधार हैं और हमारे अस्तित्व को ऊर्जस्वित करने वाले परम तेजस्वी देव हैं। 
            जैसे बछड़ा अपनी माँ से पोषण और जीवन प्राप्त करता है, वैसे ही हम आपकी कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्राप्त करते हैं। 
            आपकी उदारता की कोई सीमा नहीं है; आप अपने शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके सर्वांगीण और श्रेष्ठ विकास के लिए आवश्यक है। 
            हम अपनी मधुर और सत्यनिष्ठ वाणी से आपको प्रसन्न करने का निरंतर प्रयास करते हैं ताकि आप हमारे जीवन के समस्त क्लेशों का अंत कर सकें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी रिक्त या असहाय नहीं रहता, उसे ज्ञान के प्रकाश और अनंत वैभव का दुर्लभ वरदान प्राप्त होता है। 
            हे देवराज, आप हमारे हृदयों में अनन्य भक्ति और निष्कामता का संचार करें और हमें सदैव अपनी दिव्य छाया में सुरक्षित और सुखी रखें।
        """.trimIndent(),
        englishCommentary = """
            O seekers, praise the wonderful Lord Indra, the subduer of all foes, who rejoices deeply in the consumption of the sacred Soma nectar. 
            He remains ever ready to bestow abundance and divine prosperity upon us, and his glory is continuously enhanced by the devoted hymns of his followers. 
            Just as mothers and cows run with maternal affection toward their beloved calf, our hymns and heartfelt cries flow toward Indra's presence. 
            Your divine presence alone terminates the restlessness and turmoil of our minds, allowing us to experience your infinite existence with focus. 
            O Mighty Indra, you are the primary foundation of the sacrifice of our lives and the supremely radiant deity who energizes our entire being. 
            As a calf receives vital nourishment and life from its mother, we receive spiritual peace and material plenty through your divine favor and grace. 
            There is no limit to your generosity; you bestow upon your surrendered devotee everything necessary for their holistic and superior development. 
            We strive to please you with our sweet and truthful voices so that you may bring a definitive end to all the afflictions and sufferings of our life. 
            A seeker who takes refuge in Lord Indra never remains empty or helpless; they are blessed with the light of knowledge and the gift of infinite splendor. 
            O King of Gods, infuse our hearts with exclusive devotion and selflessness, and keep us forever protected and happy under your divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 78,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ७८ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों और विद्वानों द्वारा अपनी पवित्र स्तुतियों के माध्यम से संवर्धित और प्रदीप्त किए जाने वाले अत्यंत महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह आंतरिक शक्ति, प्रचुर अन्न और विजय लेकर आने की कृपा करें जो हमारे जीवन को हर दृष्टि से उन्नत बना सके। 
            आप हमारे लिए एक कल्याणकारी और अत्यंत आत्मीय मित्र बनकर हमारे जीवन की इस दुर्गम और चुनौतीपूर्ण यात्रा को सुगम और सफल बनाएं। 
            आपकी यह दिव्य मित्रता संसार के सभी अस्थायी और स्वार्थी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त का साथ नहीं छोड़ते। 
            हे देव, हमें वह आत्मबल और साहस प्रदान करें जिससे हम जीवन के कठिन संघर्षों में विजयी होकर समाज में एक गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों और परिवारों में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव न होने पाए। 
            जब आप हमारे सखा और मार्गदर्शक बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक या भौतिक मार्ग में रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम और पुरुषार्थ को ईश्वरीय फल और महान सफलता में बदलने वाले देव हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह, आशा और चेतना बनकर बहती है, जो हमें सदैव श्रेष्ठ, पवित्र और परोपकारी कर्म करने के लिए निरंतर प्रेरित करती है। 
            हे इन्द्र, आप हमारे परम रक्षक और गुरु के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, ज्ञानी, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the magnificent deity who is increased and glorified through the powerful sacred hymns chanted by men and learned scholars. 
            Graciously bring to us very quickly that inner power, abundant nourishment, and the spoils of victory which will elevate our lives in every aspect. 
            Become a benevolent and highly intimate friend to us, making this difficult and challenging journey of life smooth, easy, and successful. 
            Your divine friendship is superior to all temporary and selfish worldly relationships because you never abandon your devotee in times of distress. 
            O God, provide us with the inner strength and courage required to emerge victorious in life's struggles and attain a dignified position in society. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources or peace within our homes and families. 
            When you become our companion and guide, no major obstacle of the world can ever block our spiritual or material progress and evolution. 
            We worship you with deep devotion, for it is you who transforms our hard labor and efforts into divine results and magnificent successes. 
            Your energy flows through our being as enthusiasm, hope, and consciousness, perpetually inspiring us to perform noble, holy, and altruistic deeds. 
            O Indra, stay with us as our supreme protector and teacher, graciously making us magnificent, knowledgeable, successful, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 79,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ७९ ॥",
        hindiCommentary = """
            हे वृत्रहन् (अज्ञान और बुराई का नाश करने वाले) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में अपनी असीम कृपा के साथ अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ हमारे जीवन के प्रत्येक संघर्ष में एक सजग सहायक और रक्षक बनकर आएं। 
            आपकी उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता और शक्ति प्रदान करती है जिससे हम जीवन की किसी भी विषम परिस्थिति में कभी नहीं डगमगाते। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति, नकारात्मकता या बाधा से तनिक भी भयभीत होने की कोई आवश्यकता नहीं है। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का अंत कर हमारे मन में ज्ञान की निर्मल और पवित्र गंगा प्रवाहित करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा घेरा बनाती हैं जिसमें कोई भी बुराई, पाप या मानसिक विकार कभी प्रवेश नहीं कर सकता। 
            हम अपनी विनम्र और हृदयस्पर्शी प्रार्थनाओं से आपको निरंतर पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से सदा के लिए मिटा दें। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे प्रत्येक परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता और वैभव के साथ हमारे घर और हृदय में विराजें और हमें अपने मंगलकारी और दिव्य आशीषों से कृतार्थ करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण, सुख और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra (the forces of ignorance and evil), please do come graciously to our sacrificial ground and take our side. 
            Arrive in our lives as a vigilant helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your sacred presence provides our resolutions with that steel-like firmness and strength needed to remain unshaken in any adverse life situation. 
            When you are with us, there is absolutely no need for us to fear any demonic force, negativity, or obstacle that the material world presents. 
            O King of Gods, graciously destroy the Vritra of ignorance within our hearts and let the pure and holy river of knowledge flow within our minds. 
            Your protective energies build such an impenetrable shield around us that no form of evil, sin, or mental affliction can ever find its way inside. 
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your divine light forever. 
            You are the supreme power that makes our every effort meaningful and carries us forward on the path of spiritual and material evolution. 
            O Indra, reside in our homes and hearts with your infinite generosity and splendor, and bless us with your most auspicious and divine favors. 
            Our complete well-being, happiness, and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 80,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ८० ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि और विवेक हैं, आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र सच्चे हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के ज्ञात और अज्ञात संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन और जटिल निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से सफलतापूर्वक बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और प्रेम की कोई सीमा नहीं है, और हम एक समर्पित संतान के रूप में आपकी पावन वंदना निरंतर करते हैं। 
            आपकी असीम कृपा से ही हमें वह मानसिक शांति और स्थिरता प्राप्त होती है जो संसार की किसी भी नश्वर और भौतिक वस्तु में अत्यंत दुर्लभ और अप्राप्य है। 
            हम अपनी संपूर्ण श्रद्धा, प्रेम और अडिग विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित और सुखी रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान के अखंड प्रकाश से भी आलोकित करें। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को समूल नष्ट कर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाने की महान कृपा करे।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are established as our superior intellect and discernment, our supreme Father, and our most affectionate Mother. 
            You have manifested in our lives as the foundation of our entire existence and our only true well-wisher, continuously nurturing us. 
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
        id = 81,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ८१ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज (वृषा) के रूप में इस संपूर्ण ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान (सवन) में आपको प्रसन्न करने के लिए अपनी स्तुतियों और अपार श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण चराचर जगत और इसकी समस्त सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक प्रदीप्त हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य और धर्म की रक्षा कर सकें। 
            जैसे वर्षा की शीतल बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव, दुख और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक एवं आध्यात्मिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति और साहस प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर और नश्वर वस्तुओं में सर्वथा दुर्लभ और कठिन है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव ईश्वर के समीप रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
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
        id = 82,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ८२ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी भी प्राणी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सोए हुए साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और अखंड आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
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
        id = 83,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ८३ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों और साधकों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और ईश्वर के शाश्वत सत्य की ओर ले चलें।
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
        id = 84,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ८४ ॥",
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
        id = 85,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ८५ ॥",
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
        id = 86,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ८६ ॥",
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
        id = 87,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ८७ ॥",
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
        id = 88,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ८८ ॥",
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
        id = 89,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ८९ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों, ऋषियों और विद्वानों द्वारा अपनी पवित्र और ओजस्वी स्तुतियों के माध्यम से निरंतर संवर्धित और प्रदीप्त किए जाने वाले महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह अजेय शक्ति, प्रचुर अन्न, स्वास्थ्य और विजय लेकर आने की कृपा करें जो हमारे जीवन को प्रत्येक दृष्टि से पूर्णतः उन्नत बना सके। 
            आप हमारे लिए एक परम कल्याणकारी और अत्यंत आत्मीय मित्र (सखा) बनकर हमारे जीवन की इस दुर्गम और चुनौतीपूर्ण यात्रा को अत्यंत सुगम और सफल बनाएं। 
            आपकी यह दिव्य मित्रता संसार के सभी अस्थायी, क्षणभंगुर और स्वार्थी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त का साथ नहीं छोड़ते। 
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
        id = 90,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ९० ॥",
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
        id = 91,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ९१ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि और विवेक हैं, आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी और करुणामयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र सच्चे हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन और पोषण कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के ज्ञात और अज्ञात संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म और स्थूल देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और अखंड आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन और जटिल निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से सफलतापूर्वक बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और प्रेम की कोई सीमा नहीं है, और हम एक समर्पित और श्रद्धालु संतान के रूप में आपकी पावन वंदना निरंतर करते हैं। 
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
        id = 92,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ९२ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद, तृप्ति और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस संपूर्ण ब्रह्मांड के कण-कण में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और अपार श्रद्धा के साथ आपकी अनन्य सेवा, भक्ति और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण चराचर जगत और इसकी समस्त सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य, न्याय और धर्म की रक्षा कर सकें। 
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
        id = 93,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ९३ ॥",
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
        id = 94,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ९४ ॥",
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
        id = 95,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ९५ ॥",
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
        id = 96,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ९६ ॥",
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
        id = 97,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ ९७ ॥",
        hindiCommentary = """
            हे भक्तों! जो इन्द्रदेव स्वयं प्रकाशित और अपने ही साम्राज्य में पूर्णतः प्रतिष्ठित हैं, भक्त उनकी परम उपासना और नमस्कार करते हैं। 
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
        id = 98,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ९८ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्रदेव! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और अजेय ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी सूक्ष्म गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और दुख सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वरमय रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the guide on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session, we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 99,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ९९ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O knower of divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
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
        id = 100,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ १०० ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 101,
        sanskrit = "वयं घ त्वा सुतावन्त आपो न वृक्तबर्हिषः ।\nहविष्मन्तो हवामहे ॥ १०१ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! हम यजमान, जिन्होंने सोमरस तैयार किया है और यज्ञवेदी पर कुश (बर्हिषः) बिछाया है, आपको अत्यंत श्रद्धापूर्वक बुलाते हैं। 
            जैसे प्यासा जीव जल की ओर दौड़ता है, वैसे ही हमारी प्रार्थनाएं आपकी ओर वेगपूर्वक बढ़ रही हैं ताकि आप हमारा कल्याण करें। 
            हम केवल बाहरी हवि ही अर्पित नहीं कर रहे, बल्कि अपने अहंकार और विकारों की आहुति भी आपके चरणों में समर्पित करते हैं। 
            आपकी प्रसन्नता से ही हमारे जीवन में सत्य का उदय होता है और हमें वह सामर्थ्य प्राप्त होता है जिससे हम जीवन के संघर्षों में विजयी हो सकें। 
            यह मंत्र भक्त और भगवान के बीच के उस अटूट संबंध को दर्शाता है जहाँ भक्त की पुकार साक्षात् देवत्व को पृथ्वी पर आमंत्रित करती है। 
            हमें वह प्रज्ञा प्रदान करें जिससे हम सदैव धर्म के मार्ग पर अडिग रहें और कभी भी अधर्म की छाया में न जाएं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह बनकर प्रवाहित होती है, जो हमें निरंतर श्रेष्ठ और परोपकारी कर्म करने के लिए प्रेरित करती है। 
            हे देवराज, आप अपनी अमोघ शक्ति के साथ हमारे यज्ञ में पधारें और हमें अभय प्रदान कर हमारे जीवन को कृतार्थ करें। 
            आपके सान्निध्य में हमारा मन निर्भय होता है और हम संसार के मायाजाल को भेदकर ईश्वर के वास्तविक स्वरूप को देख पाते हैं। 
            हम बार-बार आपकी वंदना करते हैं क्योंकि आप ही इस संपूर्ण चराचर जगत के एकमात्र रक्षक और शाश्वत पालनहार हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, we the devotees who have extracted the Soma and prepared the sacrificial grass (Barhish), invoke you with profound faith. 
            Just as a thirsty being rushes toward water, our prayers flow toward you with speed, seeking your divine grace and ultimate well-being. 
            We do not merely offer external oblations; we surrender our ego and mental afflictions at your holy feet as our true sacrifice. 
            Only through your satisfaction does Truth dawn in our lives, granting us the capability to emerge victorious in the battles of existence. 
            This mantra illustrates the inseparable bond between the devotee and the Divine, where a sincere call invites divinity to manifest on earth. 
            Grant us that wisdom through which we can remain steadfast on the path of Dharma and never succumb to the shadows of unrighteousness. 
            Your energy flows within our vital breaths as enthusiasm, perpetually inspiring us to perform noble and altruistic deeds for humanity. 
            O King of Gods, arrive at our sacrifice with your infallible power, grant us fearlessness, and make our existence truly meaningful. 
            In your presence, our minds become bold, enabling us to pierce through the world's illusions and perceive the actual nature of God. 
            We repeatedly bow before you because you are the sole protector and eternal nourisher of this entire moving and non-moving universe.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 102,
        sanskrit = "यत् इन्द्र यावयसि वृत्रं अवधीः ।\nमहश्चित् त्वा तविषी अवीवृधत् ॥ १०२ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! जब आपने अज्ञान और जड़ता के प्रतीक वृत्रासुर का संहार किया, तब आपकी उस महान शक्ति (तविषी) ने आपको और अधिक प्रदीप्त किया। 
            वृत्र का वध वास्तव में उस अवरोध को हटाना है जो हमारे जीवन में सुख और ज्ञान की धाराओं को बहने से रोकता है। 
            जब हम अपने भीतर के तमस और प्रमाद का नाश करते हैं, तभी आपकी दिव्य शक्ति हमारे हृदय में पूर्णतः जाग्रत और विस्तारित होती है। 
            आपकी वीरता केवल एक पौराणिक कथा नहीं है, बल्कि यह हर क्षण हमारे भीतर होने वाले धर्म और अधर्म के युद्ध की वास्तविकता है। 
            हे देव, आप हमारे संकल्पों को वह दृढ़ता दें जिससे हम अपने भीतर छिपे हुए अज्ञान रूपी शत्रुओं को जड़ से समाप्त कर सकें। 
            आपकी विजय ही हमारी मुक्ति है, क्योंकि जब अज्ञान हटता है, तभी आत्मा परमात्मा के आनंदमय स्वरूप का अनुभव कर पाती है। 
            हमें वह ओज और तेज प्रदान करें जिससे हम संसार की प्रतिकूलताओं का सामना अत्यंत धैर्य और अटूट साहस के साथ कर सकें। 
            इन्द्रदेव की अजेय शक्ति हमें यह विश्वास दिलाती है कि अंततः जीत सदैव सत्य की ही होती है, चाहे अंधकार कितना भी प्रबल क्यों न हो। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम श्रेष्ठ मनुष्य बन सकें। 
            हे अजेय वीर, आप हमारे रक्षक बनकर हमें अंधकार से प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य सुख की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, when you slew the demon Vritra—the symbol of ignorance and stagnation—your immense power (Tavishi) glorified you further. 
            The destruction of Vritra is essentially the removal of those blockades that prevent the streams of joy and knowledge from flowing in our lives. 
            Only when we destroy the darkness and lethargy within ourselves does your divine power fully awaken and expand in our consciousness. 
            Your heroism is not just an ancient legend; it is the reality of the constant war between Dharma and unrighteousness occurring within us. 
            O God, grant our resolutions that firmness through which we can completely uproot the enemies of ignorance hidden in our hearts. 
            Your victory is our liberation, for only when ignorance is removed can the soul experience the blissful nature of the Supreme Being. 
            Endow us with that vigor and luster through which we can face life's adversities with extreme patience and unbreakable courage. 
            The invincible power of Lord Indra reassures us that Truth ultimately triumphs, no matter how formidable the forces of darkness may seem. 
            We worship you with devotion so that a fraction of your greatness reflects in our character, enabling us to become superior human beings. 
            O unconquerable hero, stay as our guardian and lead us from darkness to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 103,
        sanskrit = "इममिन्द्र सुतं पिब ज्येष्ठममर्त्यं मदम् ।\nशुक्रस्य त्वाभ्यक्षरन् धारा ऋतस्य सादने ॥ १०३ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप इस निष्कासित सोमरस का पान करें, जो श्रेष्ठ (ज्येष्ठम्), अमरत्व देने वाला (अमर्त्यम्) और अत्यंत आनंददायक है। 
            सत्य के अधिष्ठान (ऋतस्य सादने) में इस शुद्ध सोम की धाराएं आपकी तृप्ति के लिए निरंतर और पवित्र होकर प्रवाहित हो रही हैं। 
            सोम का पान कर आप उस अजेय सामर्थ्य को प्राप्त करते हैं जिससे ब्रह्मांड की व्यवस्था और अनुशासन सुरक्षित बना रहता है। 
            यह मंत्र हमें यह सिखाता है कि जब हम अपने कर्मों को 'ऋत' (सत्य के कानून) के अनुरूप ढालते हैं, तभी हमें दिव्य आनंद की प्राप्ति होती है। 
            आपकी प्रसन्नता हमारे जीवन के प्रत्येक अभाव को दूर कर उसे पूर्णता, शांति और अखंड ऐश्वर्य से भर देने वाली एकमात्र शक्ति है। 
            जैसे सोम अग्नि में अर्पित होकर देवलोक तक पहुँचता है, वैसे ही हमारे संकल्प भी आपकी शक्ति से परम पद को प्राप्त करने में समर्थ हों। 
            हमें वह आध्यात्मिक स्पष्टता दें कि हम संसार के क्षणभंगुर आकर्षणों में न फंसकर केवल शाश्वत सत्य की खोज में निरंतर लगे रहें। 
            आप ही वह ऊर्जा हैं जो हमारे शिथिल पड़ते मन को जाग्रत करती हैं और हमें कर्मयोग की दिशा में दृढ़तापूर्वक अग्रसर करती हैं। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि आपका सान्निध्य हमारे अंतःकरण को शुद्ध कर उसे परमात्मा के निवास योग्य पवित्र स्थान बना दे। 
            हे देवराज, आप इस मधुर रस को ग्रहण कर प्रसन्न हों और हमारे घरों को सुख, आरोग्य और दिव्य संपन्नता से भर देने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, please drink this extracted Soma juice, which is foremost (Jyeshtham), immortal (Amartyam), and most exhilarating. 
            In the abode of Truth (Rtasya sadane), the streams of this pure Soma flow continuously and sacredly for your gratification. 
            By consuming Soma, you attain that invincible capability through which the order and discipline of the universe remain secured. 
            This mantra teaches us that when we align our actions with 'Rta' (the cosmic law of Truth), only then do we attain divine bliss. 
            Your satisfaction is the singular power that can remove every scarcity of our life and fill it with completeness and eternal prosperity. 
            Just as Soma offered in fire reaches the celestial realms, may our resolutions also reach the supreme state through your divine power. 
            Grant us that spiritual clarity so that we do not get trapped in fleeting attractions but stay engaged in the search for eternal Truth. 
            You are the energy that awakens our lethargic minds and pushes us firmly toward the path of dedicated and selfless action (Karma Yoga). 
            We worship you with devotion so that your presence purifies our inner self and transforms it into a holy dwelling for the Divine. 
            O King of Gods, be pleased by accepting this sweet nectar and graciously fill our homes with happiness, health, and divine plenty.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 104,
        sanskrit = "इन्द्राय गायत सुतं सोमो यः पावकः ।\nतस्य सख्ये शिवो भव ॥ १०४ ॥",
        hindiCommentary = """
            हे भक्तों! आप इन्द्रदेव के लिए उस निष्कासित सोमरस का गान करें जो अत्यंत पवित्र करने वाला (पावकः) और आनंद का अक्षय स्रोत है। 
            आप इन्द्र की उस दिव्य मित्रता (सख्ये) में स्थित होकर मंगलकारी और कल्याणकारी (शिवः) जीवन व्यतीत करने का संकल्प लें। 
            इन्द्र की मित्रता संसार के सभी अस्थायी संबंधों से श्रेष्ठ है, क्योंकि वे संकट के समय अपने भक्त का हाथ कभी भी नहीं छोड़ते। 
            जब हम अपनी वाणी को उनकी महिमा में लगाते हैं, तो हमारा अंतःकरण स्वतः ही शुद्ध होने लगता है और हमारे संशय दूर हो जाते हैं। 
            हे देव, आप हमारे श्रेष्ठ मित्र बनकर हमें वह संबल दें जिससे हम जीवन की किसी भी कठिन परीक्षा में कभी भी अकेला महसूस न करें। 
            आपकी कृपा से ही हमें वह आत्मबल प्राप्त होता है जिससे हम अपनी इंद्रियों पर नियंत्रण पाकर आत्म-साक्षात्कार की ओर बढ़ पाते हैं। 
            पवित्र सोम का गान हमारे चारों ओर एक ऐसा सकारात्मक वातावरण निर्मित करता है जहाँ केवल सुख, शांति और दिव्यता का ही वास होता है। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपका मार्गदर्शन हमें अज्ञान के अंधकार से निकालकर परम सत्य के प्रकाश की ओर ले जाए। 
            इन्द्रदेव की शरण में आने वाला साधक कभी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक और रक्षक बन जाता है। 
            हे इन्द्र, आप हमारे सखा बनकर हमें अपनी दिव्य ऊर्जा से अनुगृहीत करें और हमें सफलता के उच्चतम और श्रेष्ठ शिखर पर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, sing for Lord Indra of the extracted Soma juice, which is a great purifier (Pavakah) and an eternal source of joy. 
            Abiding in the divine friendship (Sakhye) of Indra, resolve to lead a life that is truly auspicious and benevolent (Shivah). 
            Indra's friendship is superior to all temporary worldly bonds, for he never abandons his devotee during times of extreme crisis. 
            When we engage our voice in his glory, our inner self begins to purify automatically, and all our lingering doubts are removed. 
            O God, become our best friend and provide us with that support so that we never feel alone during any difficult trial of life. 
            It is through your grace that we receive the inner strength to master our senses and advance toward profound self-realization. 
            Singing the holy Soma creates a positive atmosphere all around us, where only happiness, peace, and divinity can reside. 
            We worship you with devotion so that your guidance leads us out of the darkness of ignorance toward the radiant light of Truth. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their helper and protector. 
            O Indra, as our companion, favor us with your divine energy and lead us graciously to the highest and noblest peaks of success.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 105,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ १०५ ॥",
        hindiCommentary = """
            हे शक्ति के पुंज (वृषन्) इन्द्र! आप हमारी स्तुतियों से प्रसन्न होकर (घृवाणो) हमारे प्रति दयालु भाव रखते हुए यहाँ कृपापूर्वक पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के संघर्षों में सहायक और रक्षक बनकर आएं। 
            आपकी उपस्थिति हमारे सुप्त आत्मविश्वास को जागृत करती है और हमें बड़ी से बड़ी विपदाओं से सफलतापूर्वक लड़ने का साहस प्रदान करती है। 
            जब आप हमारे पक्ष में खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति या शत्रु हमें पराजित करने का साहस तनिक भी नहीं कर सकता। 
            हे देवराज, आप हमारे अज्ञान रूपी अंधकार को अपनी प्रखर ज्योति से मिटाकर हमारे जीवन में ज्ञान, विवेक और आत्मिक प्रकाश फैलाएं। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख, शांति और पवित्रता का ही निरंतर वास होता है। 
            हम अपनी विनम्र और आर्त पुकार से आपको पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी अनंत उदारता से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी दिव्य महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी अजेय सुरक्षा की शीतल छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण और मंगल सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O fountain of energy Lord Indra, being pleased by our hymns (Ghrivano) and harboring a kind intent, please come here graciously. 
            Arrive in our lives as a helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your presence awakens the dormant self-confidence within us and grants us the courage required to successfully battle life's calamities. 
            When you stand on our side, no negative force or enemy in the world can ever dare to defeat or even disturb our inner peace. 
            O King of Gods, erase the darkness of our ignorance with your intense light and spread the radiance of wisdom and discernment in our lives. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness, peace, and purity reside. 
            We invoke you with our humble and desperate cries so that you may fulfill every single scarcity of our existence with your infinite generosity. 
            You are the supreme authority that makes our hard work meaningful and continuously drives us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your divine glory and keep us forever safe under the cool shadow of your invincible protection. 
            Our ultimate well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 106,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ १०६ ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो पवित्र सोमरस (अन्धसः) का पान कर आनंदित होते हैं। 
            वे हमें ऐश्वर्य (वसोः) और दिव्य धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महिमा भक्तों की वाणी से निरंतर बढ़ती रहती है। 
            जैसे माताएं और गौएँ अपने बछड़े की ओर वात्सल्य भाव से दौड़ती हैं, वैसे ही हमारी स्तुतियां और हृदय की पुकार इन्द्र की ओर प्रवाहित होती हैं। 
            आपकी दिव्य उपस्थिति मात्र से हमारे मन की चंचलता और अशांति समाप्त होती है और हम एकाग्र होकर आपकी असीम सत्ता का अनुभव करते हैं। 
            हे शक्तिशाली इन्द्र (वृषभम्), आप हमारे यज्ञ के आधार हैं और हमारे जीवन को ऊर्जस्वित करने वाले परम तेजस्वी और अजेय देव हैं। 
            जैसे बछड़ा अपनी माँ से पोषण और जीवन प्राप्त करता है, वैसे ही हम आपकी कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्राप्त करते हैं। 
            आपकी उदारता की कोई सीमा नहीं है; आप अपने शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके सर्वांगीण और श्रेष्ठ विकास के लिए आवश्यक है। 
            हम अपनी मधुर वाणी से आपको प्रसन्न करने का निरंतर प्रयास करते हैं ताकि आप हमारे जीवन के समस्त क्लेशों और दुखों का अंत कर सकें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी रिक्त नहीं रहता, उसे ज्ञान के प्रकाश और अनंत वैभव का दुर्लभ वरदान प्राप्त होता है। 
            हे देवराज, आप हमारे हृदयों में अनन्य भक्ति का संचार करें और हमें सदैव अपनी दिव्य छाया में सुरक्षित और सुखी रखने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, praise the wonderful Lord Indra, the subduer of enemies, who rejoices in the consumption of the sacred Soma nectar (Andhasah). 
            He remains ever ready to bestow abundance (Vasoh) and divine prosperity upon us, and his glory is continuously enhanced by our hymns. 
            Just as mothers and cows run with maternal affection toward their calf, our hymns and heartfelt cries flow toward Indra's presence. 
            Your divine presence alone terminates the restlessness and turmoil of our minds, allowing us to experience your infinite existence with focus. 
            O Mighty Indra (Vrishabham), you are the bedrock of our sacrifice and the supremely radiant and invincible deity who energizes us. 
            As a calf receives vital nourishment and life from its mother, we receive spiritual peace and material plenty through your divine favor. 
            There is no limit to your generosity; you bestow upon every surrendered devotee everything necessary for their holistic and superior development. 
            We strive to please you with our sweet and truthful voices so that you may bring a definitive end to all the afflictions and sorrows of our life. 
            A seeker who takes refuge in Lord Indra never remains empty; they are blessed with the light of knowledge and the gift of infinite splendor. 
            O King of Gods, infuse our hearts with exclusive devotion and keep us forever protected and happy under your supreme divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 107,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ १०७ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों (नृभिः) द्वारा अपनी पवित्र और ओजस्वी स्तुतियों के माध्यम से निरंतर संवर्धित और प्रदीप्त किए जाने वाले महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह अजेय शक्ति, अन्न और विजय (वाजां) लेकर आने की कृपा करें जो हमारे जीवन को प्रत्येक दृष्टि से उन्नत बना सके। 
            आप हमारे लिए एक परम कल्याणकारी (शिवः) मित्र (सखा) बनकर हमारे जीवन की इस दुर्गम और चुनौतीपूर्ण यात्रा को सुगम और सफल बनाएं। 
            आपकी यह दिव्य मित्रता संसार के सभी अस्थायी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त का साथ नहीं छोड़ते। 
            हे देव, हमें वह आत्मबल और साहस प्रदान करें जिससे हम जीवन के संघर्षों में विजयी होकर समाज और राष्ट्र में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों और परिवारों में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव न हो। 
            जब आप हमारे सखा और मार्गदर्शक बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक या भौतिक मार्ग में रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम और पुरुषार्थ को ईश्वरीय फल और महान सफलता में बदलने वाले देव हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह बनकर बहती है, जो हमें सदैव श्रेष्ठ, पवित्र और परोपकारी कर्म करने के लिए निरंतर प्रेरित करती है। 
            हे इन्द्र, आप हमारे परम रक्षक और गुरु के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, ज्ञानी और यशस्वी बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the magnificent deity who is increased and glorified through the powerful hymns chanted by noble men (Nribhih). 
            Graciously bring to us very quickly that invincible power, nourishment, and the spoils of victory (Vajan) which will elevate our lives. 
            Become a supremely benevolent (Shivah) and highly intimate friend (Sakha) to us, making this difficult journey of life easy and successful. 
            Your divine friendship is superior to all temporary worldly relationships because you never abandon your devotee in times of great distress. 
            O God, provide us with the inner strength and courage required to emerge victorious in life's struggles and attain a dignified position in society. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources or peace within our homes and families. 
            When you become our companion and guide, no major obstacle of the world can ever block our spiritual or material progress and evolution. 
            We worship you with deep devotion, for it is you who transforms our hard labor and efforts into divine results and magnificent successes. 
            Your energy flows through our being as enthusiasm, perpetually inspiring us to perform noble, holy, and altruistic deeds for the world. 
            O Indra, stay with us as our supreme protector and guide, graciously making us magnificent, knowledgeable, successful, and renowned.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 108,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ १०८ ॥",
        hindiCommentary = """
            हे वृत्रहन् (अज्ञान के नाश करने वाले) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में अपनी असीम दया और कृपा के साथ अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के प्रत्येक संघर्ष में सहायक और रक्षक बनकर आएं। 
            आपकी दिव्य उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता प्रदान करती है जिससे हम जीवन की किसी भी विषम परिस्थिति में कभी नहीं डगमगाते। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति, नकारात्मक ऊर्जा या बाधा से तनिक भी भयभीत होने की आवश्यकता नहीं। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का अंत कर हमारे मन में ज्ञान और विवेक की निर्मल गंगा प्रवाहित करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा घेरा बनाती हैं जिसमें कोई भी बुराई, पाप या विकार कभी प्रवेश नहीं कर सकता। 
            हम अपनी विनम्र और हृदयस्पर्शी प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से सदा के लिए मिटा दें। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता और वैभव के साथ हमारे घर और हृदय में विराजें और हमें अपने मंगलकारी और दिव्य आशीषों से कृतार्थ करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण, सुख और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra, please do come graciously to our sacrificial ground and take our side with your boundless mercy. 
            Arrive in our lives as a vigilant helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your sacred presence provides our resolutions with that steel-like firmness needed to remain unshaken in any difficult life situation. 
            When you are with us, there is absolutely no need for us to fear any demonic force, negativity, or obstacle that the world presents. 
            O King of Gods, graciously destroy the Vritra of ignorance within our hearts and let the pure river of knowledge flow within our minds. 
            Your protective energies build such an impenetrable shield around us that no form of evil, sin, or impurity can ever find its way inside. 
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your divine light forever. 
            You are the supreme power that makes our hard work meaningful and carries us forward on the path of spiritual and material evolution. 
            O Indra, reside in our homes and hearts with your infinite generosity and splendor, and bless us with your most auspicious and divine favors. 
            Our complete well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 109,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ १०९ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि और विवेक हैं, आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र सच्चे हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म और स्थूल देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन और जटिल निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और प्रेम की कोई सीमा नहीं है, और हम एक समर्पित संतान के रूप में आपकी पावन वंदना निरंतर करते हैं। 
            आपकी असीम कृपा से ही हमें वह मानसिक शांति प्राप्त होती है जो संसार की किसी भी नश्वर और भौतिक वस्तु में अत्यंत दुर्लभ और अप्राप्य है। 
            हम अपनी संपूर्ण श्रद्धा, प्रेम और विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित और सुखी रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान के प्रकाश से भी आलोकित करें। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को समूल नष्ट कर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाए।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are established as our superior intellect, our supreme Father, and our most affectionate and loving Mother. 
            You have manifested in our lives as the foundation of our entire existence and our sole well-wisher, continuously nurturing and raising us. 
            Just as parents protect and nourish their innocent child from all kinds of dangers, you take care of our subtle and physical needs. 
            We seek from you that 'Sumnam' (supreme bliss and spiritual peace) which is only granted to true and sincere devotees seeking your refuge. 
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the illusory web of ignorance. 
            O King of Gods, there is no limit to your maternal affection and love for us, and we worship you with the simple heart of a dedicated child. 
            By your boundless grace alone do we find the mental tranquility that is extremely rare and unattainable in any perishable worldly object. 
            We offer our complete faith, love, and trust at your divine feet so that you may forever keep us fully safe within your protective shadow. 
            O Indra, bring abundance into every field of our existence and make us successful while illuminating us with the light of Self-realization. 
            May your radiant stream completely destroy the root of our ignorance and successfully lead us to the realization of the Supreme Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 110,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ११० ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज (वृषा) के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान (सवन) में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण चराचर जगत संचालित होता है, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव सत्य और धर्म की रक्षा कर सकें। 
            जैसे वर्षा की शीतल बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और दुख सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति और साहस प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर और नश्वर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव ईश्वर के समीप रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power (Vrisha). 
            In this special sacrificial session (Savana), we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire moving universe is governed; by consuming Soma, you become more radiant and luminous. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by cool raindrops, all the scarcities and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is totally rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 111,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ १११ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं (चर्षणीनां) के परम स्वामी और बलवानों में सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों (पुरूणाम्) के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सुप्त साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और अखंड आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को महान दिव्य आशीर्वादों में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का दुर्लभ वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O devotees who know the divine powers, I praise Lord Indra, the supreme master of all subjects and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns (Purunam), and no being can ever surpass the limit of his might. 
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
        id = 112,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ११२ ॥",
        hindiCommentary = """
            हे मेरे श्रेष्ठ मित्रों और साधकों! आप उन इन्द्रदेव के लिए अत्यंत आनंददायक और भक्तिपूर्ण गीतों का गान करें जो अश्वों के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में साक्षात् पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें संपूर्ण ब्रह्मांड में अजेय बना देता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक, ऊर्जावान और दिव्य वातावरण का निर्माण स्वतः ही होने लगता है। 
            हे देव, आप अपने तेजस्वी और वायु के समान तीव्र घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट और सर्वव्यापी सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की दिव्य शक्ति और प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे और हम निरंतर आत्मोन्नति करें। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों, भयों और दुखों को जड़ से समाप्त कर हमें निर्भय बना देती है। 
            हे इन्द्र, आप हमारे परम स्वामी, रक्षक और गुरु हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश और परमात्मा के शाश्वत सत्य की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O my dear friends and fellow seekers, sing exhilarated and highly devoted songs for Lord Indra, the master of horses and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 113,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ११३ ॥",
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
        id = 114,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ११४ ॥",
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
    )
)