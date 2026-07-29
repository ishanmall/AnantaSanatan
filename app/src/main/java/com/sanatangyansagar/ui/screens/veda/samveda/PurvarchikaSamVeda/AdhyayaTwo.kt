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
fun PurvarchikaAdhyayaTwoScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            purvarchikaAdhyayaTwoData
        } else {
            purvarchikaAdhyayaTwoData.filter {
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
                        Text("द्वितीय अध्याय - ऐन्द्र पर्व", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFBBDEFB) // Light Blue tint for Indra (Sky/Lightning)
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
                .background(Color(0xFFE3F2FD)),
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

// Reusing the VedaDetailCard and PurvarchikaVerse data class from your Adhyaya 1 architecture

val purvarchikaAdhyayaTwoData = listOf(
    PurvarchikaVerse(
        id = 1,
        sanskrit = "य इन्द्र सोमपातमो मदस्तं प्रत्नथा सहः ।\nअषाळ्हं सहमानं पृतन्यन्तं सं यन्मध्वो अदुद्रवत् ॥ १ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! जो सोम का रस (सोमपातमो) अत्यंत आनंददायक और मदहोश कर देने वाला है, उसे प्राचीन रीति (प्रत्नथा) के अनुसार ग्रहण करें। 
            वह सोम आपको वह बल और पराक्रम प्रदान करे जो किसी से पराजित न होने वाला (अषाळ्हं) हो। 
            जब यह मधुर सोमरस आपकी नसों में प्रवाहित होता है, तो आप शत्रुओं की विशाल सेनाओं को कुचलने की शक्ति प्राप्त करते हैं। 
            हे देवराज, आप ही हमारी विजय के आधार हैं और युद्ध में शत्रुओं का दमन करने वाले अजेय वीर हैं। 
            सोम का पान कर आप अपने भक्त की पुकार सुनते हैं और उसे अभय प्रदान करते हैं। 
            आपकी वीरता समस्त लोकों में विख्यात है, और आप ही ऋत (सत्य) के मार्ग के रक्षक हैं। 
            इस मधुर रस के प्रभाव से आप अत्यंत प्रसन्न होकर हमारे यज्ञ को सफल बनाते हैं। 
            हम श्रद्धापूर्वक आपको यह सोमरस अर्पित करते हैं ताकि आप हमें बल और साहस प्रदान करें। 
            आपके सानिध्य में हमारा मन निर्भय होता है और हम श्रेष्ठ लक्ष्यों की ओर बढ़ते हैं। 
            हे इन्द्र, आप अपनी अनंत ऊर्जा से हमारे जीवन के अंधकारमय विरोधियों का समूल नाश करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, please accept the Soma juice (Somapatamo) which is most exhilarating and delightful, following the ancient traditions (Pratnatha). 
            May this Soma grant you that invincible strength and valor which cannot be conquered (Asalham) by any foe. 
            As the sweet Soma juice flows into your being, you gain the power to crush the vast armies of our enemies. 
            O King of Gods, you are the foundation of our victories and the unconquerable hero who subdues all opposing forces. 
            Having consumed the Soma, you listen to the cries of your devotees and bestow upon them the gift of fearlessness. 
            Your heroism is renowned across all realms, and you stand as the guardian of the eternal cosmic law (Rta). 
            Under the influence of this nectar, you rejoice and ensure the ultimate success of our sacrificial ritual. 
            We offer this Soma with deep devotion, seeking the strength and courage that only you can provide. 
            In your divine presence, our minds become bold, and we advance steadily toward noble and grand goals. 
            O Indra, with your infinite energy, completely destroy the dark adversaries that hinder our spiritual and material progress.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 2,
        sanskrit = "स ईं पाही य ऋजीषी तरुत्रो यः शविष्ठो वृत्रहा यो मतीनाम् ।\nयो गोत्राणां सहसा पास्त्यः ॥ २ ॥",
        hindiCommentary = """
            हे इन्द्र! आप ही वह 'ऋजीषी' (यज्ञ के अंत में बचा रस पीने वाले) हैं, जो बाधाओं को पार करने वाले (तरुत्रो) और अत्यंत शक्तिशाली हैं। 
            आप ही वह महान 'वृत्रहा' हैं, जिन्होंने वृत्रासुर का संहार कर जल के स्रोतों को मुक्त किया और जगत को जीवन दिया। 
            आप हमारी बुद्धियों (मतीनाम्) के प्रेरक हैं और बादलों (गोत्राणां) को भेदकर वर्षा करने वाले बलवान देव हैं। 
            आप ही वह शक्ति हैं जो हमारे घरों (पास्त्यः) की रक्षा करती है और हमें सुरक्षा का अनुभव कराती है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारे मार्ग के समस्त अवरोधों को नष्ट करने की कृपा करें। 
            आपकी कृपा से ही हमारे विचार शुद्ध होते हैं और हम सत्य की खोज में सफल होते हैं। 
            इन्द्रदेव की महिमा असीम है; वे ही प्रकृति की शक्तियों को नियंत्रित कर संसार में संतुलन बनाए रखते हैं। 
            हम आपको नमन करते हैं क्योंकि आप अज्ञान रूपी वृत्रासुर का नाश कर ज्ञान का प्रकाश फैलाते हैं। 
            हमारी प्रार्थनाओं को स्वीकार कर आप हमें वह सामर्थ्य दें कि हम भी बुराई के विरुद्ध दृढ़ रहें। 
            हे शविष्ठ (अत्यंत बलवान), आप हमारे प्राणों में चेतना बनकर प्रवाहित हों और हमें दिव्यता की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, you are the 'Rijishi' (the consumer of the essence), the one who crosses over all obstacles (Tarutrah) and is most powerful. 
            You are the great 'Vritraha', the slayer of the demon Vritra, who released the blocked waters and gave life to the world. 
            You are the ultimate inspirer of our thoughts (Matinam) and the mighty one who pierces the clouds (Gotranam) to bring rain. 
            You are the power that protects our dwellings (Pastyah) and makes us feel secure within our social and spiritual structures. 
            O God, please use your fierce power to destroy every single blockade that stands in the path of our evolution. 
            It is through your grace that our thoughts are purified, allowing us to succeed in our search for the Ultimate Truth. 
            The glory of Indra is limitless; he is the one who controls the forces of nature to maintain cosmic balance. 
            We bow to you because you destroy the Vritra of ignorance within us and spread the light of divine knowledge. 
            Accept our prayers and grant us the capability to remain steadfast against all forms of evil and unrighteousness. 
            O Most Powerful One (Shavistha), flow through our vital breaths as consciousness and lead us toward the heights of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 3,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ३ ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत (दस्मम्) और शत्रुओं का दमन करने वाले (ऋतीषहं) इन्द्रदेव की स्तुति करें। 
            वे सोमरस (अन्धसः) का पान कर आनंदित होते हैं और हमें ऐश्वर्य (वसोः) प्रदान करने के लिए सदैव तत्पर रहते हैं। 
            जैसे माताएं और गौएँ अपने बछड़े (वत्सम्) की ओर प्रेमपूर्वक दौड़ती हैं, वैसे ही स्तुतियां इन्द्र की ओर बढ़ती हैं। 
            आपकी महिमा भक्तों की वाणी से निरंतर बढ़ती है, और आप उन पर अपनी कृपा की वर्षा करते हैं। 
            हे वृषभ (शक्तिशाली इन्द्र), आप हमारे यज्ञ के आधार हैं और हमारे जीवन को ऊर्जस्वित करने वाले देव हैं। 
            जैसे बछड़ा अपनी माँ से पोषण पाता है, वैसे ही हम आपकी कृपा से आध्यात्मिक और भौतिक पोषण प्राप्त करते हैं। 
            आपकी उपस्थिति मात्र से हमारे मन की चंचलता समाप्त होती है और हम एकाग्र होकर आपकी उपासना करते हैं। 
            हम अपनी मधुर वाणी से आपको प्रसन्न करने का प्रयास करते हैं ताकि आप हमारे दुखों का अंत कर सकें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी रिक्त नहीं रहता, उसे ज्ञान और वैभव की प्रचुरता प्राप्त होती है। 
            हे देवराज, आप हमारे हृदयों में भक्ति का संचार करें और हमें सदैव अपनी दिव्य छाया में सुरक्षित रखें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, praise the wonderful (Dasmam) Lord Indra, who is the subduer of all enemies and afflictions (Rtishaham). 
            He rejoices in the drinking of the Soma juice (Andhasah) and remains ever ready to bestow abundance (Vasoh) upon us. 
            Just as mothers and cows run affectionately toward their calf (Vatsam), our hymns of praise flow toward Indra. 
            Your glory is continuously increased by the voices of your followers, and in return, you shower your grace upon them. 
            O Mighty One (Vrishabha), you are the bedrock of our sacrifice and the deity who energizes our entire existence. 
            As a calf receives nourishment from its mother, we receive spiritual and material sustenance through your divine favor. 
            Your mere presence terminates the restlessness of our minds, allowing us to worship you with focused concentration. 
            We strive to please you with our sweet and devoted speech so that you may bring an end to all our worldly sufferings. 
            A seeker who takes refuge in Lord Indra never remains empty; they are granted an abundance of wisdom and splendor. 
            O King of Gods, infuse our hearts with devotion and keep us forever protected under your supreme divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 4,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ४ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों (नृभिः) द्वारा स्तुतियों के माध्यम से संवर्धित और प्रदीप्त किए जाने वाले महान देव हैं। 
            आप हमारे लिए शीघ्र ही (मक्षूणी) अन्न, शक्ति और विजय (वाजां) लेकर आने की कृपा करें। 
            आप हमारे लिए एक कल्याणकारी (शिवः) मित्र (सखा) बनकर हमारे जीवन की यात्रा को सुगम और सफल बनाएं। 
            आपकी मित्रता संसार के सभी संबंधों से श्रेष्ठ है क्योंकि आप संकट के समय कभी भी साथ नहीं छोड़ते। 
            हे देव, हमें वह आत्मबल प्रदान करें जिससे हम सांसारिक संघर्षों में विजयी होकर गौरव प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर बनी रहे ताकि हमारे घरों में अन्न और शांति का कभी भी अभाव न हो। 
            जब आप हमारे सखा बनते हैं, तब बड़ी से बड़ी बाधा भी हमारे मार्ग में रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे परिश्रम को ईश्वरीय फल में बदलने वाले हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह बनकर बहती है और हमें सदैव श्रेष्ठ कर्म करने के लिए प्रेरित करती है। 
            हे इन्द्र, आप हमारे रक्षक और मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the great deity who is increased and glorified through the hymns chanted by men (Nribhih). 
            Graciously bring to us very quickly (Makshuni) nourishment, power, and the spoils of victory (Vajan). 
            Become a benevolent (Shivah) friend (Sakha) to us and make our life's journey easy, smooth, and successful. 
            Your friendship is superior to all worldly relationships because you never abandon your devotee in times of crisis. 
            O God, provide us with the inner strength required to emerge victorious and dignified in our worldly struggles. 
            May your merciful gaze remain upon us so that there is never a shortage of food or peace in our households. 
            When you become our companion, even the greatest of obstacles cannot hinder our path toward progress. 
            We worship you with deep devotion, for it is you who transforms our hard labor into divine and fruitful results. 
            Your energy flows through our being as enthusiasm, perpetually inspiring us to perform noble and righteous deeds. 
            O Indra, stay with us forever as our protector and guide, graciously making our lives magnificent and successful.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 5,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ५ ॥",
        hindiCommentary = """
            हे वृत्रहन् (वृत्रासुर के संहारक) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष (अर्धम्) में अवश्य पधारें। 
            आप अपनी महान और विशाल (महाँ महीभिः) रक्षात्मक शक्तियों (ऊतिभिः) के साथ हमारे सहायक बनकर आएं। 
            आपकी उपस्थिति हमारे संकल्पों को वह दृढ़ता प्रदान करती है जिससे हम किसी भी परिस्थिति में डगमगाते नहीं हैं। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति या बाधा से भयभीत होने की आवश्यकता नहीं होती। 
            हे देवराज, आप हमारे अज्ञान रूपी वृत्र का नाश कर हमारे जीवन में ज्ञान की गंगा प्रवाहित करने की कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा घेरा बनाती हैं जिसमें कोई बुराई प्रवेश नहीं कर सकती। 
            हम अपनी विनम्र प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी ज्योति से मिटा दें। 
            आप ही वह शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता के साथ हमारे घर और हृदय में विराजें और हमें मंगलकारी आशीष प्रदान करें। 
            आपकी कृपा दृष्टि से हमारा कल्याण सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra (Vritrahan), please do come to our sacrificial ground and take our side (Ardham). 
            Come as our helper with your grand and vast (Maham Mahibhih) protective powers and divine assistances (Utibhih). 
            Your presence provides our resolutions with the firmness needed to remain unshaken in any life circumstance. 
            When you are with us, we have no reason to fear any demonic force or obstacle that the material world presents. 
            O King of Gods, graciously destroy the Vritra of ignorance within us and let the river of knowledge flow in our lives. 
            Your protective energies create a shield around us through which no form of evil or negativity can ever penetrate. 
            We invoke you with our humble supplications so that you may erase the darkness of our existence with your light. 
            You are the power that makes our hard work meaningful and carries us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your infinite generosity and bestow upon us your auspicious blessings. 
            Our well-being is guaranteed under your merciful gaze; we repeatedly bow before your magnificent and invincible power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 6,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ६ ॥",
        hindiCommentary = """
            हे शतक्रतो (सैकड़ों यज्ञ करने वाले) इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि (प्रमतिः), आप ही हमारे पिता और आप ही हमारी माता हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और परम हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और हमारा पालन कर रहे हैं। 
            जैसे माता-पिता अपने बालक की हर प्रकार से रक्षा और पोषण करते हैं, वैसे ही आप हमारी देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (सुख और शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे भक्तों को ही प्राप्त होता है। 
            आपकी बुद्धिमत्ता हमें जीवन के कठिन निर्णयों में सही दिशा दिखाती है और हमें भ्रम के जाल से बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके स्नेह की कोई सीमा नहीं है, और हम आपकी संतान के रूप में आपकी वंदना करते हैं। 
            आपकी कृपा से ही हमें वह मानसिक शांति प्राप्त होती है जो संसार की किसी भी भौतिक वस्तु में दुर्लभ और अप्राप्य है। 
            हम अपनी श्रद्धा और प्रेम आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में सुरक्षित रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ ज्ञानवान भी बनाएं। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को जलाकर हमें परम सत्य और ईश्वर के साक्षात्कार की ओर ले जाए।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu (Lord of a hundred sacrifices) Indra, you are our superior intellect (Pramatih), our Father, and our Mother. 
            You have manifested in our lives as the foundation of our entire existence and our ultimate well-wisher and nurturer. 
            Just as parents protect and nourish their child in every possible way, you take care of us with divine attention. 
            We seek from you that 'Sumnam' (happiness and peace) which is only experienced by true seekers who find refuge in you. 
            Your supreme intelligence shows us the right direction during tough decisions and pulls us out of the web of confusion. 
            O King of Gods, there is no limit to your affection for us, and we worship you with the simple heart of your children. 
            By your grace alone do we find the mental tranquility that is extremely rare and unattainable in worldly objects. 
            We offer our faith and love at your feet so that you may forever keep us safe within your divine and protective shadow. 
            O Indra, bring abundance into every field of our existence and make us not just successful but also wise and enlightened. 
            May your radiant stream burn away the darkness of our ignorance and lead us to the realization of the Supreme Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 7,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ७ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले (सुप्रणीते) इन्द्र! आप इस सोमरस का पान करें जो आपको अत्यंत आनंद और मद प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला (चर्षणिप्रा) है और आप स्वयं शक्ति के पुंज (वृषा) हैं। 
            हम इस 'सवन' (यज्ञीय अनुष्ठान) में आपको प्रसन्न करने के लिए अपनी स्तुतियों के साथ आपकी विशेष सेवा करते हैं। 
            आपकी ऊर्जा से ही यह संपूर्ण जगत संचालित होता है, और सोम का पान कर आप और अधिक तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे यज्ञ को अपनी उपस्थिति से पवित्र करें और हमें वह बल दें कि हम धर्म की रक्षा कर सकें। 
            जैसे वर्षा से धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव और कष्ट दूर हो जाते हैं। 
            हम श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, शांति और समृद्धि से भर दें। 
            आपकी यह दिव्य शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा की शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की नश्वर वस्तुओं में दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the one who leads us on the best path (Supranite), please drink this Soma which grants you immense joy and vigor. 
            Your exhilaration is the one that satisfies all living beings (Charshanipra), and you are the powerful bull (Vrisha) of energy. 
            In this 'Savana' (sacrificial session), we offer our special service along with hymns to delight and glorify your divinity. 
            It is through your energy that this entire universe is governed, and by drinking Soma, you become even more radiant. 
            O King of Gods, sanctify our sacrifice with your presence and grant us the strength required to protect the Dharma. 
            Just as the earth is satisfied by rain, all the scarcities and afflictions of our lives vanish by your gracious favor. 
            We bow before your feet with deep devotion so that you may fill our lives with happiness, peace, and material prosperity. 
            Your divine power pulls us out of the darkness of doubt and grants us the strength of integrity and unshakable truth. 
            O Indra, become our nearest relative and bestow upon us that divine bliss which is rare in the perishable things of the world. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and wisdom.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 8,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ८ ॥",
        hindiCommentary = """
            हे भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं (चर्षणीनां) के स्वामी और बलवानों में भी सर्वश्रेष्ठ (वृषभः) हैं। 
            वे अनेक यज्ञों और स्तुतियों (पुरूणाम्) के अधिकारी हैं, और उनकी शक्ति का पार पाना किसी भी प्राणी के लिए संभव नहीं है। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो संसार के न्याय और अनुशासन को बनाए रखने के लिए अपनी प्रचंड शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का गान करने से मनुष्य के भीतर के सोए हुए साहस और वीरता का जागरण होता है, जिससे वह विजयी बनता है। 
            हे देव, आप हमारे जीवन के अंधकार को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज में गौरव प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य प्राप्त हो जो सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के सान्निध्य का अनुभव कराते हैं। 
            आप ही वह शक्ति हैं जो हमारे परिश्रम को ईश्वरीय फल में और हमारी प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल नहीं रहता, उसे आत्मज्ञान और भौतिक संपन्नता दोनों प्राप्त होते हैं। 
            हे अग्नि के सखा इन्द्र, आप हमारे रक्षक और मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, I praise Lord Indra, who is the sovereign master of all subjects (Charshani) and the foremost among the strong (Vrishabha). 
            He is the rightful recipient of many sacrifices and numerous hymns (Purunam), and no being can ever surpass his might. 
            Indra is the supreme authority who utilizes his fierce power to maintain the justice and discipline of the entire universe. 
            Singing his glories awakens the dormant courage and heroism within a person, enabling them to emerge victorious in life. 
            O God, remove the darkness of our existence and bestow upon us that brilliance which allows us to attain honor in society. 
            By your grace, let us receive that wealth which is earned by following the path of Truth and which is beneficial for all. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God. 
            You are the power that transforms our hard labor into divine results and our humble prayers into celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak; they attain both self-knowledge and material abundance. 
            O Indra, the companion of Agni, stay with us as our protector and guide, graciously making us great and noble.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 9,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ९ ॥",
        hindiCommentary = """
            हे मित्रों (सखायः)! आप उन इन्द्रदेव के लिए आनंददायक (मादनं) गीतों का गान करें जो हरे घोड़ों वाले (हर्यश्वाय) और सोम पीने वाले (सोमपाव्ने) हैं। 
            आपकी मधुर वाणी से निकले हुए भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे यज्ञ में पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की शक्ति का रहस्य सोम के पान और भक्तों की सच्ची पुकार में छिपा है, जो उन्हें अजेय बना देता है। 
            जब हम मिल-जुलकर उनकी महिमा गाते हैं, तो हमारे चारों ओर एक सकारात्मक और दिव्य वातावरण का निर्माण होता है। 
            हे देव, आप अपने तेजस्वी घोड़ों पर सवार होकर हमारे जीवन के युद्ध क्षेत्र में आएं और हमारे शत्रुओं का संहार करें। 
            हमें वह भक्ति और एकाग्रता प्रदान करें जिससे हम आपकी विराट सत्ता का अनुभव अपने भीतर कर सकें और शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता और अखंड सौभाग्य प्राप्त करने की शक्ति मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोकोपकार और सत्य की सेवा में लगा रहे और हम उन्नत हों। 
            इन्द्रदेव की मित्रता हमारे लिए वह सुरक्षा कवच है जो हमारे समस्त संशयों और भयों को जड़ से समाप्त कर देती है। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और अंधकार से परम प्रकाश की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O friends (Sakhayah), sing exhilarating (Madanam) songs for Lord Indra, who possesses bay horses (Haryashva) and drinks Soma (Somapavne). 
            The bhajans arising from your sweet voices delight Indra and invite him to manifest within our sacred sacrificial ritual. 
            The secret of Indra's might lies in the consumption of Soma and the sincere calls of his devotees, making him invincible. 
            When we collectively sing his glories, a positive and divine atmosphere is created all around us, purifying the space. 
            O God, riding upon your radiant horses, come into the battlefield of our lives and destroy our internal and external enemies. 
            Grant us that devotion and focus which enables us to experience your vast existence within ourselves and remain peaceful. 
            By your grace, grant us the power to remove every lack in our lives and attain completeness and unbroken good fortune. 
            We worship you with devotion so that our life remains dedicated to public welfare and the service of Truth, helping us grow. 
            The friendship of Lord Indra is that protective shield for us which completely uproots all our doubts and deep-seated fears. 
            O Indra, you are our Lord and Protector; lead us from ignorance to knowledge and from darkness to the Supreme Light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 10,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ १० ॥",
        hindiCommentary = """
            समस्त स्तुतियां (गिरः) समुद्र के समान विशाल और सर्वव्यापक इन्द्रदेव की महिमा को निरंतर बढ़ाती और प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ (रथीतं) और विजयों (वाजानां) के अधिपति हैं, जिनकी बार-बार प्रशंसा (चर्कृत्यम्) की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ समाहित और सुरक्षित हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल सारथी हैं, जो हमें संसार की बाधाओं के बीच से कुशलतापूर्वक निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और बुद्धिमत्ता से हमारे प्रयासों को सफलता के उच्चतम शिखर तक पहुँचाने की कृपा करें। 
            हमें वह 'वाज' (शक्ति और अन्न) प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से जागृत होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक बन जाता है। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और सच्ची कीर्ति का मार्ग दिखाए। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns (Girah) continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among charioteers (Rathitam) and the Lord of victories (Vajanam), worthy of being praised again and again. 
            The expanse of Indra's presence is infinite like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful charioteer of our life's vessel, guiding us expertly through the turbulent obstacles of the world. 
            O God, with your fierce power and profound wisdom, graciously lead our humble efforts to the absolute peak of success. 
            Bestow upon us 'Vaja' (power and nourishment) so that we can assist the weak and keep the flag of righteousness flying high. 
            The continuous singing of your glories purifies our inner self and initiates our deep spiritual awakening and growth. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper. 
            Let your radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and true glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and renowned.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 11,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ११ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता और शक्ति के प्रेमी (वीरयुः) हैं, कृपया हमारे भीतर भी वही वीरता और साहस स्थापित करें। 
            आप अत्यंत महान हैं, हमारे जीवन के संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें। 
            सच्ची वीरता वह नहीं जो केवल युद्ध में दिखे, बल्कि वह है जो हमें अपने विकारों पर विजय पाने की शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य का मार्ग प्रशस्त करने वाले योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के डर को समाप्त कर हमें निर्भीक और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति हमें विचलित नहीं कर सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम श्रेष्ठ बनें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल मन में नवीन ऊर्जा का संचार कर हमें कर्मयोग की ओर अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर गौरवशाली जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism and power (Virayuh); please instill that same valor and courage within us. 
            You are exceedingly great; grant firmness to the resolutions of our lives so that we are always ready for the defense of Dharma. 
            True heroism is not just seen in physical war, but in the power that enables us to conquer our own inner flaws and weaknesses. 
            By your grace, let us receive that vigor and luster which transform us into warriors who pave the way for Truth in society. 
            O King of Gods, graciously terminate the fear within us and make us profoundly fearless, steady, and self-confident. 
            When you sow the seed of courage in our hearts, no adverse circumstance of the world can ever sway or disturb us. 
            We worship you with devotion so that a fraction of your greatness reflects in our character and we become superior beings. 
            You are the power that infuses fresh energy into our lethargic minds, pushing us toward the path of selfless action (Karma Yoga). 
            O Indra, give us the spiritual capability to rise above worldly temptations and attain the true essence of the Divine Reality. 
            May your merciful gaze always remain upon us as we lead a glorious and fearless life under your supreme divine protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 12,
        sanskrit = "तमिन्द्रं वाजयामसि महे वृत्राय हन्तवे ।\nस वृषा वृषभो बभूविथ ॥ १२ ॥",
        hindiCommentary = """
            हम उन इन्द्रदेव को बल प्रदान करने वाली स्तुतियां अर्पित करते हैं ताकि वे महान शत्रु वृत्र का वध (महे वृत्राय हन्तवे) कर सकें। 
            वे स्वयं शक्ति के महान पुंज (वृषा) और श्रेष्ठ वीर (वृषभः) हैं, जो अधर्म का नाश करने के लिए सदैव शस्त्र धारण किए रहते हैं। 
            भक्तों की प्रार्थनाएं इन्द्र के वज्र को और अधिक प्रखर बनाती हैं, जिससे वे संसार की बाधाओं को नष्ट करने में सक्षम होते हैं। 
            वृत्र केवल एक राक्षस नहीं, बल्कि हमारे मार्ग में आने वाला वह हर अवरोध है जो हमें सत्य की प्राप्ति से रोकता है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारे भीतर के अज्ञान और जड़ता का अंत कर हमारे जीवन में प्रकाश का मार्ग खोलें। 
            आपकी विजय ही हमारी विजय है, और हम आपकी जय-जयकार करते हुए स्वयं को आपके कार्यों के लिए समर्पित करते हैं। 
            आपकी ऊर्जा हमारे शरीर में जीवनी शक्ति बनकर और मन में दृढ़ संकल्प बनकर बहती है, जिससे हम कभी हार नहीं मानते। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि आप हमारे जीवन के प्रत्येक संघर्ष में हमें सफलता की ओर ले जाने वाले सहायक बनें। 
            इन्द्रदेव की अजेय शक्ति हमें यह विश्वास दिलाती है कि अंततः जीत सदैव धर्म और सत्य की ही होती है, चाहे शत्रु कितना भी प्रबल हो। 
            हे इन्द्र, आप हमारे परम रक्षक हैं, हमें अपनी दिव्य ज्वाला में तपाकर शुद्ध करें और हमें दिव्यता के सर्वोच्च शिखर पर पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            We offer hymns that bestow strength to Lord Indra so that he may slay the great and formidable enemy, Vritra. 
            He is himself the immense mass of energy (Vrisha) and the supreme hero (Vrishabha), always armed to destroy unrighteousness. 
            The prayers of the devotees sharpen Indra's thunderbolt (Vajra), enabling him to effectively annihilate the world's obstacles. 
            Vritra is not just a demon but every single barrier in our path that prevents us from attaining the Supreme Truth. 
            O God, with your fierce power, end the ignorance and lethargy within us and open the pathway of light in our lives. 
            Your victory is our victory, and as we hail your name, we dedicate ourselves entirely to your divine and noble purposes. 
            Your energy flows within us as the vital force and as a firm resolution in the mind, ensuring we never give up in life. 
            We worship you with devotion so that you become our constant helper, leading us toward success in every life struggle. 
            The invincible power of Lord Indra reassures us that victory ultimately belongs to Dharma and Truth, no matter how strong the foe. 
            O Indra, you are our ultimate protector; refine us in your divine flame and lead us to the supreme heights of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 13,
        sanskrit = "इन्द्राय मधुमत्तमं सोमं पवस्व धारया ।\nशविष्ठाय मत्सराः ॥ १३ ॥",
        hindiCommentary = """
            हे सोमरस! आप अत्यंत मधुर (मधुमत्तमं) और आनंददायक होकर अपनी पवित्र धारा के साथ सबसे बलवान (शविष्ठाय) इन्द्र की ओर प्रवाहित हों। 
            यह सोम ही इन्द्र का आहार है, जिसे पीकर वे ब्रह्मांड की रक्षा के लिए अपनी अजेय शक्ति प्राप्त करते हैं और आनंदित होते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण के समस्त विकारों को धोकर हमें दिव्यता, शांति और ईश्वर के सानिध्य का अनुभव कराए। 
            जैसे सोम अग्नि में अर्पित होकर देव-लोक तक पहुँचता है, वैसे ही हमारे संकल्प भी आपकी शक्ति से परम पद को प्राप्त करें। 
            हे देव, आप ही वह माध्यम हैं जो हमारे प्रार्थनाओं को देवताओं के समूह तक सुरक्षित और शीघ्रता से पहुँचाने का कार्य करते हैं। 
            आपकी कृपा से हमारे जीवन के समस्त अमंगल और दुख दूर हों और हमें शाश्वत दैवीय सुख की अनुभूति प्राप्त हो सके। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आपके बिना कोई भी यज्ञ या आध्यात्मिक अनुष्ठान अपनी पूर्णता को प्राप्त नहीं कर सकता। 
            आपकी यह तेजस्वी और मधुर धारा हमारे भीतर के अज्ञान को जलाकर हमें सत्य के साक्षात्कार की ओर ले जाने का मार्ग दिखाए। 
            हे इन्द्र, आप इस मधुर रस का पान कर अत्यंत प्रसन्न हों और हमारे घरों को सुख, संपन्नता और शांति से भर देने की कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, being most sweet (Madhumattamam) and exhilarating, flow in a sacred stream toward the most powerful (Shavistha) Indra. 
            This Soma is the nourishment of Indra, by consuming which he gains invincible strength to protect the entire cosmos. 
            May this holy stream wash away all the stains and impurities of our inner self, filling us with divinity and profound peace. 
            Just as Soma offered in fire reaches the celestial realms, let our spiritual resolutions reach the supreme state through your power. 
            O God, you are the essential medium who carries our humble prayers safely and swiftly to the assembly of the divine gods. 
            By your grace, let all the inauspiciousness and sorrows of our lives be removed, granting us the experience of eternal bliss. 
            We worship you with deep devotion because no sacrifice or spiritual ritual can reach its completion without your presence. 
            May your radiant and sweet stream burn away the darkness of our ignorance and show us the pathway to realize the Truth. 
            O Indra, rejoice greatly by consuming this nectar and graciously fill our homes with happiness, prosperity, and enduring peace. 
            We offer our entire faith at your feet so that our lives remain meaningful, nourished, and filled with the Divine Presence in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 14,
        sanskrit = "प्र मंहिष्ठाय गायत ऋतावानं विचेतसम् ।\nइन्द्रं विश्वा अवीवृधन् ॥ १४ ॥",
        hindiCommentary = """
            आप उन अत्यंत उदार (मंहिष्ठाय), सत्य के रक्षक (ऋतावानं) और विशेष ज्ञानी (विचेतसम्) इन्द्रदेव के लिए भक्तिपूर्वक गान करें। 
            समस्त ब्रह्मांडीय शक्तियों और भक्तों की वाणियों ने इन्द्र की महिमा को निरंतर बढ़ाया है और उन्हें सर्वोच्च पद पर प्रतिष्ठित किया है। 
            इन्द्र ही वह चेतना हैं जो सत्य के मार्ग पर चलने वालों का मार्गदर्शन करती है और उन्हें अज्ञान के बंधनों से मुक्त कराती है। 
            उनकी उदारता की कोई सीमा नहीं है; वे अपने शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके कल्याण के लिए आवश्यक है। 
            हे देव, आप अपनी प्रखर बुद्धि से हमारे संशयों का नाश कर हमें वह स्पष्ट दृष्टि दें जिससे हम जीवन के रहस्यों को जान सकें। 
            आपकी महिमा का गान करने से हमारे मन की मलीनता दूर होती है और हम ईश्वर के अनंत प्रेम और शांति का अनुभव करने लगते हैं। 
            आप ही वह शक्ति हैं जो हमारे कठिन परिश्रम को ईश्वरीय फल में और हमारी छोटी प्रार्थनाओं को दिव्य आशीषों में बदलती हैं। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, यश और आध्यात्मिक उन्नति लाएं। 
            इन्द्रदेव की उपस्थिति मात्र से ही हमारे अभाव दूर हो जाते हैं और हम अपने भीतर एक अखंड पूर्णता और आनंद का अनुभव करते हैं। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहें और हमें दिव्यता के मार्ग पर निरंतर अग्रसर करते रहें।
        """.trimIndent(),
        englishCommentary = """
            Sing devotedly for the most generous (Mamhishthaya), the guardian of Truth (Rtavanam), and the highly wise (Vichetasam) Indra. 
            All cosmic forces and the voices of his devotees have continuously increased Indra's glory and established him at the supreme state. 
            Indra is that consciousness which guides those walking the path of Truth and liberates them from the heavy bonds of ignorance. 
            There is no limit to his generosity; he bestows upon his surrendered devotee everything that is necessary for their ultimate well-being. 
            O God, with your sharp intelligence, destroy our doubts and grant us that clear vision to understand the mysteries of existence. 
            Singing your glories removes the impurities of our minds and allows us to experience the infinite love and peace of the Divine. 
            You are the power that transforms our hard work into divine results and our simple prayers into magnificent celestial blessings. 
            We bow before you with devotion so that you bring abundance, fame, and spiritual evolution into every single aspect of our lives. 
            The mere presence of Lord Indra dissolves our scarcities, making us experience a sense of unbroken completeness and joy within. 
            O Indra, stay with us forever as our protector and nourisher, and continue to lead us steadily on the radiant path of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 15,
        sanskrit = "यस्य द्विता विधर्तुः साकमस्य सतो वशा ।\nस न इन्द्रः शिवः सखा ॥ १५ ॥",
        hindiCommentary = """
            जिन इन्द्रदेव की आज्ञा (वशा) और शासन इस ब्रह्मांड के दोनों लोकों (पृथ्वी और स्वर्ग) में विधिवत व्याप्त और प्रतिष्ठित है। 
            वे ही महान देव हमारे लिए एक कल्याणकारी (शिवः) और अत्यंत आत्मीय मित्र (सखा) बनकर हमारे जीवन में सदैव उपस्थित रहें। 
            इन्द्र का शासन केवल दंड पर नहीं, बल्कि न्याय और प्रेम पर आधारित है, जो संपूर्ण चराचर जगत को अनुशासित और संतुलित रखता है। 
            उनकी मित्रता हमें वह संबल प्रदान करती है जिससे हम जीवन के बड़े से बड़े युद्धों को अत्यंत शांति और धैर्य के साथ जीत सकते हैं। 
            हे देवराज, आप हमारे सबसे निकट के हितैषी बनकर हमें वह मार्गदर्शन दें जिससे हम कभी भी अधर्म के मार्ग पर न चलें। 
            जब आप हमारे सखा बनते हैं, तब संसार की कोई भी नकारात्मक शक्ति या परिस्थिति हमें अपने लक्ष्य से विचलित नहीं कर सकती। 
            हम श्रद्धापूर्वक आपकी अर्चना करते हैं ताकि हमारे जीवन में केवल शुभ का उदय हो और हम सदैव आपकी सुरक्षित छाया में रहें। 
            आपकी कृपा से ही हमारे परिवारों में एकता, प्रेम और धर्मनिष्ठा का वास होता है, जो हमारे सामाजिक जीवन को सुखमय बनाता है। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के शाश्वत प्रकाश की ओर ले जाने की कृपा करें। 
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा तथा मंगलकारी आशीष की याचना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            Lord Indra, whose command (Vasha) and governance are duly established and pervasive across both the realms (Earth and Heaven). 
            May that great deity remain forever present in our lives as a benevolent (Shivah) and highly intimate friend (Sakha). 
            Indra's rule is not based on mere punishment but on justice and love, which keeps the entire moving and non-moving world balanced. 
            His friendship provides us with that support through which we can win the greatest battles of life with peace and immense patience. 
            O King of Gods, become our nearest well-wisher and guide us so that we never walk the path of unrighteousness or vice. 
            When you become our companion, no negative force or worldly situation can ever sway or distract us from our spiritual goal. 
            We worship you with devotion so that only the auspicious arises in our lives and we always remain under your protective shadow. 
            By your grace alone, unity, love, and righteousness reside in our families, making our social life blissful and meaningful. 
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Supreme Truth. 
            We repeatedly bow before your divine and magnificent glory and seek your constant protection and auspicious blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 16,
        sanskrit = "अभित्वा शूर नोनुमो दुग्धा इव धेनवः ।\nईशानमस्य जगतः स्वर्दृशमीशानमिन्द्र तस्थुषः ॥ १६ ॥",
        hindiCommentary = """
            हे वीर इन्द्रदेव! जैसे दुधारू गौएँ अपने बछड़े की ओर प्रेमपूर्वक रंभाती हुई दौड़ती हैं, वैसे ही हम आपकी स्तुति करते हैं। 
            आप इस संपूर्ण चराचर जगत के स्वामी (ईशानम्) हैं, जो जड़ और चेतन दोनों पर शासन करने वाले महान देव हैं। 
            आपकी दृष्टि स्वर्ग (स्वर्दृशम्) तक व्याप्त है, और आप ही समस्त लोकों के वास्तविक नियन्ता और रक्षक हैं। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के अंधकार को दूर कर उसे ज्ञान के प्रकाश से भरते हैं। 
            आपकी कृपा से ही हमें वह सामर्थ्य प्राप्त होता है जिससे हम अपनी इंद्रियों और मन पर नियंत्रण पा सकें। 
            जैसे गौ अपने दूध से संसार का पोषण करती है, वैसे ही आप अपनी कृपा की वर्षा से भक्तों का कल्याण करते हैं। 
            आपकी महिमा का गान करने से हमारे भीतर के सोए हुए साहस और आत्मविश्वास का पुनर्जागरण होता है। 
            हे देवराज, आप हमारे हृदयों में भक्ति का ऐसा दीपक जलाएं जो कभी भी बुझने न पाए और हमें राह दिखाए। 
            हम श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमें आध्यात्मिक और भौतिक दोनों ही समृद्धियाँ प्रदान करें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल नहीं रहता, उसे ज्ञान और ऐश्वर्य की असीम प्रचुरता प्राप्त होती है। 
            हे अजेय वीर, आप हमारे रक्षक बनकर हमें सदैव धर्म के मार्ग पर दृढ़ रहने की दिव्य शक्ति प्रदान करने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O heroic Lord Indra, just as milch cows low affectionately toward their calves, we continuously chant your praises. 
            You are the sovereign Lord (Ishanam) of this entire universe, governing both the moving and the non-moving entities. 
            Your divine vision extends to the highest heavens (Svardrisham), and you are the ultimate controller and protector. 
            We worship you because you are the one who removes the darkness from our lives and fills them with wisdom. 
            It is only through your grace that we receive the strength to gain mastery over our senses and our wandering mind. 
            Just as a cow nourishes the world with its milk, you nourish your devotees with the showers of your divine grace. 
            Singing your glories awakens the dormant courage and self-confidence within us, enabling us to face life's battles. 
            O King of Gods, ignite such a lamp of devotion in our hearts that it never flickers and always guides our way. 
            We bow before your feet with deep faith so that you may grant us both spiritual evolution and material abundance. 
            A seeker who takes refuge in Lord Indra never remains weak; they attain an infinite abundance of knowledge and splendor. 
            O invincible hero, stay as our guardian and graciously provide us with the divine strength to remain firm on the path of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 17,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ १७ ॥",
        hindiCommentary = """
            हे मघवन् (ऐश्वर्यशाली) इन्द्र! आपके समान न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न कोई हुआ है और न होगा। 
            आपकी तुलना किसी से नहीं की जा सकती, आप अद्वितीय और सर्वोत्तम शक्तियों के स्वामी और रक्षक हैं। 
            हम शक्ति (अश्वयन्तः), विजय (वाजिनो) और गौओं (गव्यन्तः) की कामना करते हुए आपको यज्ञ में सादर बुलाते हैं। 
            आप ही वह शक्ति हैं जो हमारे जीवन में श्रेष्ठता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम आपकी शरण में हैं। 
            आपकी दिव्यता समस्त सीमाओं से परे है, और आप ही ऋत (सत्य) के मार्ग के सबसे बड़े संरक्षक और प्रहरी हैं। 
            जब हम आपका आह्वान करते हैं, तो हमारे भीतर एक नई ऊर्जा का संचार होता है जो हमें शत्रुओं पर विजय दिलाती है। 
            संसार की कोई भी बाधा आपके वज्र के सामने टिक नहीं सकती, आप हमारे मार्ग के समस्त कंटकों को दूर करें। 
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और सफल हों। 
            आपकी कृपा दृष्टि से हमारा कल्याण सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार वंदना करते हैं। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और अंधकार से शाश्वत प्रकाश की ओर ले चलें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक और मंगलमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan (Lord of Riches) Indra, there is none like you in the heavens, nor on earth; none has been born, nor will be. 
            You are incomparable and unique, the supreme master and guardian of the highest celestial and worldly powers. 
            Desiring strength (Ashvayantah), victory (Vajino), and abundance (Gavyantah), we call upon you in our sacrifice. 
            You are the only power capable of bringing excellence and plenty into our lives; we seek your divine refuge. 
            Your divinity transcends all boundaries, and you stand as the greatest protector and sentinel of the Cosmic Order (Rta). 
            When we invoke you, a new surge of energy flows through us, enabling us to achieve victory over our inner enemies. 
            No obstacle in this world can withstand your thunderbolt; please remove all the thorns from our life's pathway. 
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to attain success. 
            Our well-being is guaranteed under your merciful gaze; we repeatedly bow before your magnificent and invincible power. 
            O Indra, you are our Lord and Protector; lead us from ignorance to knowledge and from darkness to eternal light. 
            We offer our entire faith at your feet so that our lives remain meaningful, auspicious, and blessed in every possible way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 18,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानां पतिं चर्कृत्यम् ॥ १८ ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापक इन्द्रदेव की महिमा को निरंतर बढ़ाती और प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और विजयों (वाजानां) के अधिपति हैं, जिनकी बार-बार प्रशंसा और वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और समाहित हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल सारथी हैं, जो हमें संसार की बाधाओं के बीच से कुशलतापूर्वक निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और बुद्धिमत्ता से हमारे प्रयासों को सफलता के उच्चतम शिखर तक पहुँचाने की कृपा करें। 
            हमें वह 'वाज' (शक्ति और अन्न) प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से जागृत होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक बन जाता है। 
            आपकी दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और सच्ची कीर्ति का मार्ग दिखाए। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की कृपा करें। 
            हम आपकी इस विराट और भव्य महिमा को नमन करते हैं और आपके निरंतर आशीर्वाद की विनम्रतापूर्वक कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            All the hymns (Girah) continuously increase and illuminate the glory of Lord Indra, who is as vast as the ocean. 
            He is the foremost among charioteers (Rathitam) and the Lord of victories (Vajanam), worthy of being praised repeatedly. 
            The expanse of Indra's presence is infinite like the sky and the sea, within which all cosmic powers are contained. 
            He is the most skillful charioteers of our life's vessel, guiding us expertly through the turbulent obstacles of the world. 
            O God, with your fierce power and profound wisdom, graciously lead our humble efforts to the absolute peak of success. 
            Bestow upon us 'Vaja' (power and nourishment) so that we can assist the weak and keep the flag of righteousness high. 
            The continuous singing of your glories purifies our inner self and initiates our deep spiritual awakening and growth. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their helper. 
            Let your radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent and successful. 
            We bow before your vast and grand majesty and humbly seek your continuous and loving divine blessings for all time.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 19,
        sanskrit = "स नः शुभः शुभंभर इन्द्रो विश्वाभिरूतिभिः ।\nअस्मे धेहि श्रवश्च्यौतम् ॥ १९ ॥",
        hindiCommentary = """
            हे कल्याणकारी इन्द्रदेव! आप शुभ फल प्रदान करने वाले (शुभंभर) हैं, अपनी समस्त रक्षात्मक शक्तियों (ऊतिभिः) के साथ आएं। 
            आप हमारे जीवन में वह यश और ऐश्वर्य (श्रवः) स्थापित करें जो शत्रुओं के प्रभाव को जड़ से समाप्त कर देने वाला हो। 
            आपकी शुभता हमारे घर और मन को पवित्र करती है, जिससे हमारे भीतर सात्विक गुणों का निरंतर विकास होता है। 
            जब आप अपनी महान शक्तियों के साथ हमारे सहायक बनते हैं, तो सफलता स्वतः ही हमारे कदम चूमने लगती है। 
            हे देवराज, आप हमारे अज्ञान के शत्रुओं को नष्ट कर हमें वह कीर्ति प्रदान करें जो सत्य पर आधारित और स्थायी हो। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य कवच बनाती हैं जिसमें कोई नकारात्मकता प्रवेश नहीं कर सकती। 
            हम अपनी प्रार्थनाओं से आपकी उस शक्ति का आह्वान करते हैं जो असंभव को भी संभव बनाने का सामर्थ्य रखती है। 
            आप ही वह ऊर्जा हैं जो हमारे शिथिल पड़ते संकल्पों में नवीन प्राण फूंकती हैं और हमें विजयी बनाती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता के साथ हमारे यज्ञ को सफल बनाएं और हमें आध्यात्मिक उन्नति की ओर ले चलें। 
            आपकी कृपा दृष्टि से हमारा भविष्य सुरक्षित और उज्ज्वल है, हम आपकी अजेय शक्ति की बार-बार वंदना करते हैं। 
            हमें वह विवेक दें कि हम प्राप्त ऐश्वर्य का उपयोग लोक-कल्याण के लिए कर सकें और सदैव धर्मनिष्ठ बने रहें।
        """.trimIndent(),
        englishCommentary = """
            O auspicious Lord Indra, you are the bringer of good fortune (Shubham-bhara); come with all your protective powers. 
            Establish within us that fame and prosperity (Shravah) which has the power to shatter the influence of our enemies. 
            Your auspiciousness sanctifies our homes and minds, leading to the continuous development of virtuous qualities within us. 
            When you become our helper with your vast divine powers, success naturally begins to follow our every endeavor. 
            O King of Gods, destroy the internal enemies of ignorance and grant us fame that is rooted in Truth and is lasting. 
            Your protective energies form an impenetrable shield around us, through which no form of negativity can penetrate. 
            Through our prayers, we invoke that power of yours which possesses the capability to make the impossible possible. 
            You are the energy that breathes new life into our weakening resolutions and empowers us to emerge victorious. 
            O Indra, with your infinite generosity, make our sacrifice successful and lead us toward profound spiritual evolution. 
            Our future is safe and bright under your merciful gaze; we repeatedly bow before your invincible and majestic power. 
            Grant us the discernment to use our acquired abundance for the welfare of all and to always remain devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 20,
        sanskrit = "आ तू न इन्द्र क्षुमन्तं चित्रं ग्राभं सं गृभाय ।\nमहाहस्ती दक्षिणेन ॥ २० ॥",
        hindiCommentary = """
            हे विशाल हाथों वाले (महाहस्ती) इन्द्रदेव! आप अपने दाहिने हाथ (दक्षिणेन) से हमारे लिए अद्भुत और प्रचुर धन ग्रहण करें। 
            आप हमें वह अन्न और समृद्धि प्रदान करें जो हमारे परिवार का पोषण करे और हमें समाज में सम्मानित स्थान दिलाए। 
            आपके उदार हाथ सदैव भक्तों को देने के लिए उठे रहते हैं, कृपया हमारी प्रार्थनाओं को स्वीकार कर हमें निहाल करें। 
            हमें वह 'चित्रं ग्राभं' (अद्भुत पकड़/सफलता) दें जिससे हम अपने लक्ष्यों को दृढ़तापूर्वक प्राप्त करने में सफल हो सकें। 
            इन्द्रदेव की कृपा से प्राप्त ऐश्वर्य न केवल सुख देता है, बल्कि वह हमें धर्म के कार्यों में दान देने के योग्य भी बनाता है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारी दरिद्रता का नाश करें और हमारे जीवन में संपन्नता का सूर्य उदय करें। 
            जब आप अपनी महान भुजाओं से हमारी रक्षा करते हैं, तब हमें संसार की किसी भी असुर शक्ति से डरने की जरूरत नहीं। 
            आप ही वह शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के प्रत्येक अभाव को पूर्णता में बदलने वाले देव हैं। 
            हे इन्द्र, आप अपनी उदारता के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी दिव्य सुरक्षा में रखें। 
            आपकी कृपा दृष्टि से हमारा कल्याण सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति को बार-बार प्रणाम करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra with mighty hands (Mahahasti), with your right hand (Dakshinena), grasp for us wonderful and vast wealth. 
            Bestow upon us that nourishment and prosperity which sustains our family and earns us an honored place in society. 
            Your generous hands are always raised to bless your devotees; please accept our prayers and make us abundant. 
            Grant us 'Chitram Grabham'—that marvelous grasp and success—enabling us to firmly achieve all our noble goals. 
            Prosperity obtained through the grace of Indra not only provides comfort but also makes us capable of performing charity. 
            O God, with your fierce power, destroy our poverty and make the sun of prosperity rise within our daily lives. 
            When you protect us with your magnificent arms, we have no reason to fear any demonic or negative force of the world. 
            You are the power that makes our hard work meaningful and continuously drives us forward on the path of evolution. 
            We worship you with deep devotion because you are the deity who transforms every scarcity of our life into completeness. 
            O Indra, reside in our homes and hearts with your profound generosity and keep us forever under your divine protection. 
            Our well-being is guaranteed under your merciful gaze; we repeatedly bow before your magnificent and invincible power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 21,
        sanskrit = "का त उस्तिः शविष्ठ्य का मतिः का सुवृक्तिः ।\nकदा वसूनि भरसि ॥ २१ ॥",
        hindiCommentary = """
            हे अत्यंत बलवान (शविष्ठ्य) इन्द्रदेव! आपकी स्तुति (उस्तिः) करने का सही ढंग क्या है, और आपको प्रसन्न करने वाली बुद्धि (मतिः) कौन सी है? 
            वह कौन सा उत्तम कर्म (सुवृक्तिः) है जिससे आप संतुष्ट होते हैं, और आप हमें अपना अद्भुत ऐश्वर्य (वसूनि) कब प्रदान करेंगे? 
            भक्त का यह प्रश्न उसकी व्याकुलता और आपके सान्निध्य की तीव्र इच्छा को दर्शाता है, जो केवल समर्पण से ही शांत हो सकती है। 
            हम अपनी अल्प बुद्धि से आपकी विराट महिमा को समझने का प्रयास कर रहे हैं, कृपया हमें सही मार्ग और प्रज्ञा प्रदान करें। 
            हे देवराज, आप ही ज्ञान के अक्षय भंडार हैं, हमें वह संस्कार दें जिससे हम आपकी स्तुति करने के वास्तविक अधिकारी बन सकें। 
            जब मनुष्य अपने अहंकार को त्यागकर आपकी शरण में आता है, तभी उसे आपके दिव्य ऐश्वर्य और शांति की प्राप्ति होती है। 
            आपकी कृपा का समय आपकी इच्छा पर निर्भर है, परंतु हमारा कर्तव्य निरंतर आपकी उपासना और धर्म का पालन करना है। 
            आप ही वह शक्ति हैं जो हमारे जीवन के अंधकारमय संशयों को दूर कर हमें सत्य के साक्षात्कार की ओर ले जाती हैं। 
            हम विनम्र भाव से आपकी प्रतीक्षा करते हैं कि आप कब हमारे जीवन को अपनी वैभवशाली ज्योति से आलोकित करेंगे। 
            हे इन्द्र, आप हमारे गुरु और रक्षक बनकर हमें वह विवेक दें जिससे हम आपके रहस्यों को समझ सकें और सफल हों। 
            आपकी कृपा दृष्टि से ही हमारा उद्धार संभव है, हम आपकी अजेय और महान शक्ति की श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O most powerful (Shavisthya) Indra, what is the proper way to praise you (Ustih), and what is the intellect (Matih) that pleases you? 
            Which noble deed (Suvriktih) satisfies your divinity, and when will you bring forth your marvelous treasures (Vasuni) for us? 
            This inquiry of the devotee reflects his restlessness and intense longing for your presence, which is stilled only by surrender. 
            We are attempting to comprehend your vast majesty with our limited intellect; please grant us the right path and wisdom. 
            O King of Gods, you are the inexhaustible storehouse of knowledge; grant us the virtues to become worthy of your praise. 
            Only when a human renounces their ego and seeks your refuge do they attain your divine abundance and eternal peace. 
            The timing of your grace depends on your will, yet our duty is to remain engaged in your worship and the path of Dharma. 
            You are the power that removes the dark doubts of our lives and leads us toward the realization of the ultimate Truth. 
            We wait with humility for the moment you decide to illuminate our existence with your magnificent and radiant light. 
            O Indra, become our teacher and protector, granting us the discernment to understand your mysteries and succeed. 
            Our salvation is possible only through your merciful gaze; we worship your invincible and great power with deep faith.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 22,
        sanskrit = "कुविद्ङ्ग मघवन् कस्यचिद् गिरो ज्रयो वाजस्य गन्त ।\nएवा हि ते मनो विचेतसम् ॥ २२ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आप वास्तव में उन भक्तों की वाणियों (गिरो) और स्तुतियों के पास पहुँचते हैं जो विजय (वाजस्य) के लिए प्रयत्नशील हैं। 
            आपका मन अत्यंत विशेष ज्ञानी (विचेतसम्) और चतुर है, जो यह भली-भांति जानता है कि किस साधक को कब और क्या प्रदान करना है। 
            आपकी बुद्धि सूक्ष्म रहस्यों को भेदने वाली है, और आप केवल सच्ची श्रद्धा और पुरुषार्थ से ही प्रसन्न होने वाले देव हैं। 
            जब हम एकाग्र मन से आपकी महिमा गाते हैं, तो आपकी चेतना हमारे जीवन के संघर्षों में हमारा मार्गदर्शन करने लगती है। 
            हे देव, आप हमारे संकल्पों को वह गति दें जिससे हम अपने लक्ष्यों को शीघ्रता और पूर्णता के साथ प्राप्त कर सकें। 
            आपकी कृपा का प्रवाह उन लोगों की ओर स्वतः ही मुड़ जाता है जो धर्म की रक्षा और समाज के उत्थान के लिए समर्पित हैं। 
            हमें वह 'विचेतस' (विशेष चेतना) प्रदान करें जिससे हम सांसारिक भ्रमों से बचकर केवल शाश्वत सत्य की खोज कर सकें। 
            आप ही वह शक्ति हैं जो हमारे परिश्रम को ईश्वरीय फल में और हमारी छोटी प्रार्थनाओं को दिव्य आशीषों में बदलती हैं। 
            इन्द्रदेव की मित्रता हमें वह सुरक्षा प्रदान करती है जो हमें संसार के प्रलोभनों के बीच भी विचलित नहीं होने देती। 
            हे इन्द्र, आप हमारे रक्षक और मार्गदर्शक बनकर हमें दिव्यता के उस शिखर पर ले चलें जहाँ केवल आनंद और शांति हो। 
            आपकी महिमा अपार है, और हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित कर स्वयं को धन्य और कृतार्थ मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, you truly reach and attend to the voices (Girah) and hymns of those devotees who strive for victory (Vajasya). 
            Your mind is exceptionally wise (Vichetasam) and discerning, knowing exactly what to bestow upon which seeker and at what time. 
            Your intellect pierces through subtle mysteries, and you are a deity pleased only by sincere faith and dedicated human effort. 
            When we sing your glories with a focused mind, your consciousness begins to guide us through the various struggles of our life. 
            O God, grant our resolutions that momentum through which we can achieve our goals with speed, precision, and completeness. 
            The flow of your grace naturally turns toward those who are dedicated to the defense of Dharma and the upliftment of society. 
            Grant us that 'Vichetas' (special consciousness) which enables us to avoid worldly delusions and seek only the eternal Truth. 
            You are the power that transforms our hard work into divine results and our simple prayers into magnificent celestial blessings. 
            Indra's friendship provides us with a security that prevents us from wavering even amidst the strongest worldly temptations. 
            O Indra, stay with us as our protector and guide, and lead us to that peak of divinity where only joy and peace reside. 
            Your glory is infinite, and we consider ourselves blessed and fulfilled by offering our entire faith at your divine feet.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 23,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ २३ ॥",
        hindiCommentary = """
            हे शक्ति के पुंज (वृषन्) इन्द्र! आप हमारी स्तुतियों से प्रसन्न होकर (घृवाणो) हमारे प्रति दयालु भाव रखते हुए यहाँ पधारें। 
            आप अपनी महान और विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के युद्ध क्षेत्र में सहायक बनकर आएं। 
            आपकी उपस्थिति हमारे भीतर के आत्मविश्वास को जागृत करती है और हमें बड़ी से बड़ी विपदाओं से लड़ने का साहस देती है। 
            जब आप हमारे पक्ष में खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति या शत्रु हमें पराजित करने का साहस नहीं कर सकता। 
            हे देवराज, आप हमारे अज्ञान रूपी अंधकार को अपनी ज्योति से मिटाकर हमारे जीवन में ज्ञान और विवेक का प्रकाश फैलाएं। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख और शांति का ही वास होता है। 
            हम अपनी विनम्र प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी उदारता से पूर्ण कर दें। 
            आप ही वह शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी अनंत महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी दिव्य सुरक्षा में रखें। 
            आपकी कृपा दृष्टि से हमारा कल्याण और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार वंदना करते हैं। 
            हमें वह सामर्थ्य दें कि हम भी आपकी तरह धर्म की रक्षा के लिए सदैव तत्पर रहें और समाज के लिए एक आदर्श प्रस्तुत करें।
        """.trimIndent(),
        englishCommentary = """
            O mass of energy (Vrishan) Indra, being pleased by our hymns (Ghrivano) and harboring a kind intent toward us, please come here. 
            Arrive as our helper in the battlefield of our lives with your grand and vast protective powers and divine assistances (Mahibhih Utibhih). 
            Your presence awakens the self-confidence within us and grants us the courage required to battle the greatest of calamities. 
            When you stand on our side, no negative force or enemy in the world can ever dare to defeat or even disturb our peace. 
            O King of Gods, erase the darkness of our ignorance with your light and spread the radiance of wisdom and discernment in our lives. 
            Your protective energies build such a fortress of security around us within which only happiness and tranquility reside. 
            We invoke you with our humble supplications so that you may fulfill every single scarcity of our existence with your generosity. 
            You are the power that makes our hard work meaningful and continuously drives us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your infinite glory and keep us forever safe under your divine and supreme protection. 
            Our well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your invincible and great power. 
            Grant us the capability to always be ready for the defense of Dharma like you and to present a virtuous model for society.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 24,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ २४ ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो सोमरस का पान कर आनंदित होते हैं। 
            वे हमें ऐश्वर्य और धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महिमा भक्तों की वाणी से निरंतर बढ़ती रहती है। 
            जैसे माताएं और गौएँ अपने बछड़े (वत्सम्) की ओर प्रेमपूर्वक दौड़ती हैं, वैसे ही हमारी स्तुतियां और प्रार्थनाएं इन्द्र की ओर बढ़ती हैं। 
            आपकी उपस्थिति मात्र से हमारे मन की चंचलता समाप्त होती है और हम एकाग्र होकर आपकी दिव्य सत्ता का अनुभव करते हैं। 
            हे शक्तिशाली इन्द्र (वृषभम्), आप हमारे यज्ञ के आधार हैं और हमारे जीवन को ऊर्जस्वित करने वाले परम तेजस्वी देव हैं। 
            जैसे बछड़ा अपनी माँ से पोषण पाता है, वैसे ही हम आपकी कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्राप्त करते हैं। 
            आपकी उदारता की कोई सीमा नहीं है; आप अपने शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके सर्वांगीण विकास के लिए आवश्यक है। 
            हम अपनी मधुर और सत्य वाणी से आपको प्रसन्न करने का प्रयास करते हैं ताकि आप हमारे जीवन के समस्त दुखों का अंत कर सकें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी रिक्त नहीं रहता, उसे ज्ञान के प्रकाश और वैभव की प्रचुरता का वरदान मिलता है। 
            हे देवराज, आप हमारे हृदयों में अनन्य भक्ति का संचार करें और हमें सदैव अपनी दिव्य छाया में सुरक्षित और सुखी रखें। 
            हम आपकी इस विराट और भव्य महिमा को बार-बार नमन करते हैं और आपके निरंतर आशीर्वाद की विनम्रतापूर्वक कामना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O devotees, praise the wonderful Lord Indra, the subduer of enemies, who rejoices in the consumption of the Soma nectar. 
            He remains ever ready to bestow abundance and prosperity upon us, and his glory is continuously increased by the hymns of his followers. 
            Just as mothers and cows run affectionately toward their calf (Vatsam), our hymns and heartfelt prayers flow toward Indra's presence. 
            Your mere presence terminates the restlessness of our minds, allowing us to experience and worship your divine existence with focus. 
            O Mighty Indra (Vrishabham), you are the bedrock of our sacrifice and the supremely radiant deity who energizes our entire life. 
            As a calf receives vital nourishment from its mother, we receive spiritual peace and material plenty through your divine favor. 
            There is no limit to your generosity; you bestow upon your surrendered devotee everything necessary for their holistic development. 
            We strive to please you with our sweet and truthful voices so that you may bring a definitive end to all the sufferings of our life. 
            A seeker who takes refuge in Lord Indra never remains empty; they are blessed with the light of knowledge and vast abundance. 
            O King of Gods, infuse our hearts with exclusive devotion and keep us forever protected and happy under your divine shadow. 
            We bow repeatedly before your vast and grand majesty and humbly seek your continuous and loving divine blessings for all time.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 25,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ २५ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों और ऋषियों द्वारा स्तुतियों के माध्यम से संवर्धित और प्रदीप्त किए जाने वाले अत्यंत महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह शक्ति, अन्न और विजय (वाजां) लेकर आने की कृपा करें जो हमारे जीवन को उन्नत बना सके। 
            आप हमारे लिए एक कल्याणकारी (शिवः) और अत्यंत आत्मीय मित्र (सखा) बनकर हमारे जीवन की इस दुर्गम यात्रा को सुगम बनाएं। 
            आपकी मित्रता संसार के सभी अस्थायी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त को नहीं त्यागते। 
            हे देव, हमें वह आत्मबल और साहस प्रदान करें जिससे हम जीवन के संघर्षों में विजयी होकर समाज में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव न हो। 
            जब आप हमारे सखा बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक या भौतिक मार्ग में रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम को ईश्वरीय फल और सफलता में बदलने वाले देव हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह और चेतना बनकर बहती है, जो हमें सदैव श्रेष्ठ और परोपकारी कर्म करने के लिए प्रेरित करती है। 
            हे इन्द्र, आप हमारे रक्षक और मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, ज्ञानी और यशस्वी बनाने की कृपा करें। 
            इस संपूर्ण चराचर जगत में आपकी ही सत्ता और तेज व्याप्त है, हम आपकी शरण में आकर स्वयं को अत्यंत धन्य और कृतार्थ मानते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the great deity who is increased and glorified through the powerful hymns chanted by men and ancient sages. 
            Graciously bring to us very quickly that power, nourishment, and the spoils of victory (Vajan) which will elevate our lives. 
            Become a benevolent (Shivah) and highly intimate friend (Sakha) to us, making this difficult journey of life easy and successful. 
            Your friendship is superior to all temporary worldly relationships because you never abandon your devotee in times of great distress. 
            O God, provide us with the inner strength and courage required to emerge victorious and attain a position of honor in society. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources or peace in our households. 
            When you become our companion, no major obstacle of the world can ever block our spiritual or material progress and evolution. 
            We worship you with deep devotion, for it is you who transforms our hard labor and efforts into divine and successful results. 
            Your energy flows through our being as enthusiasm and consciousness, perpetually inspiring us to perform noble and altruistic deeds. 
            O Indra, stay with us as our protector and guide, graciously making us magnificent, knowledgeable, successful, and renowned. 
            Your sovereign power and luster pervade this entire universe; by seeking your refuge, we consider ourselves truly blessed and fulfilled.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 26,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ २६ ॥",
        hindiCommentary = """
            हे वृत्रहन् (अज्ञान और अंधकार का नाश करने वाले) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में कृपापूर्वक अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन में सहायक और रक्षक बनकर आएं। 
            आपकी उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता प्रदान करती है जिससे हम जीवन की किसी भी विषम परिस्थिति में कभी नहीं डगमगाते। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति, नकारात्मकता या बाधा से तनिक भी भयभीत होने की आवश्यकता नहीं। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का अंत कर हमारे मन में ज्ञान की निर्मल गंगा प्रवाहित करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा घेरा बनाती हैं जिसमें कोई भी बुराई या विकार कभी प्रवेश नहीं कर सकता। 
            हम अपनी विनम्र और हृदयस्पर्शी प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से सदा के लिए मिटा दें। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता और वैभव के साथ हमारे घर और हृदय में विराजें और हमें अपने मंगलकारी आशीषों से कृतार्थ करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धा से वंदना करते हैं। 
            हमें वह दृष्टि और विवेक दें कि हम संसार के मायाजाल को पहचान सकें और सदैव आपके सत्य स्वरूप के चिंतन में लीन रहकर आनंद प्राप्त करें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra (the darkness of ignorance), please do come graciously to our sacrificial ground and take our side. 
            Arrive in our lives as a helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your sacred presence provides our resolutions with that steel-like firmness needed to remain unshaken in any difficult life situation. 
            When you are with us, there is absolutely no need for us to fear any demonic force, negativity, or obstacle that the world presents. 
            O King of Gods, graciously destroy the Vritra of ignorance within our hearts and let the pure river of knowledge flow within our minds. 
            Your protective energies build such an impenetrable shield around us that no form of evil or impurity can ever find its way inside. 
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your divine light forever. 
            You are the supreme power that makes our hard work meaningful and carries us forward on the path of spiritual and material evolution. 
            O Indra, reside in our homes and hearts with your infinite generosity and splendor, and bless us with your most auspicious favors. 
            Our complete well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power. 
            Grant us the vision and discernment to recognize the illusions of the world and to remain joyfully immersed in meditating upon your Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 27,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ २७ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि (प्रमतिः), आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म और स्थूल देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन और जटिल निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और स्नेह की कोई सीमा नहीं है, और हम एक समर्पित संतान के रूप में आपकी पावन वंदना करते हैं। 
            आपकी असीम कृपा से ही हमें वह मानसिक शांति प्राप्त होती है जो संसार की किसी भी नश्वर और भौतिक वस्तु में अत्यंत दुर्लभ और अप्राप्य है। 
            हम अपनी संपूर्ण श्रद्धा, प्रेम और विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान के प्रकाश से भी आलोकित करें। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को समूल नष्ट कर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाए। 
            हम आपकी महिमा का निरंतर गान करते हैं ताकि हमारा हृदय सदैव आपकी दिव्य उपस्थिति के आनंद और शांति से सराबोर रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are established as our superior intellect (Pramatih), our supreme Father, and our most affectionate Mother. 
            You have manifested in our lives as the foundation of our entire existence and our sole well-wisher, continuously nurturing us. 
            Just as parents protect and nourish their innocent child from all kinds of dangers, you take care of our subtle and physical needs. 
            We seek from you that 'Sumnam' (supreme bliss and spiritual peace) which is only granted to true and sincere devotees seeking refuge. 
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the illusory web of ignorance. 
            O King of Gods, there is no limit to your maternal affection and love for us, and we worship you with the heart of a dedicated child. 
            By your boundless grace alone do we find the mental tranquility that is extremely rare and unattainable in any perishable worldly object. 
            We offer our complete faith, love, and trust at your divine feet so that you may forever keep us fully safe within your protective shadow. 
            O Indra, bring abundance into every field of our existence and make us successful while illuminating us with the light of Self-realization. 
            May your radiant stream completely destroy the root of our ignorance and successfully lead us to the realization of the Supreme Truth. 
            We constantly sing your glories so that our hearts remain forever saturated with the bliss and peace of your divine presence and grace.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 28,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ २८ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज (वृषा) के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान (सवन) में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव धर्म की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव, दुख और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर और नश्वर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वर के समीप रहें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक महान और सार्थक जीवन व्यतीत करने में सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session (Savana), we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
            It is through your divine energy that this entire universe and its movements are governed; by consuming Soma, you become more radiant. 
            O King of Gods, sanctify this ritual of ours with your holy presence and grant us the inner strength to always protect and serve Dharma. 
            Just as the thirsty earth is satisfied by raindrops, all the scarcities, sorrows, and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is totally rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine. 
            May your merciful gaze always remain upon us as we lead a fearless, great, and meaningful life successfully under your protection.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 29,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ २९ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं (चर्षणीनां) के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों (पुरूणाम्) के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सोए हुए साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें। 
            हम आपकी इस विराट और भव्य महिमा को नमन करते हैं और प्रार्थना करते हैं कि आपकी दिव्य कृपा की धारा हमारे जीवन में सदैव प्रवाहित होती रहे।
        """.trimIndent(),
        englishCommentary = """
            O devotees who know the divine powers, I praise Lord Indra, the supreme master of all subjects (Charshani) and the foremost among the strong. 
            He is the sole rightful recipient of many great sacrifices and ancient hymns (Purunam), and no being can ever surpass the limit of his might. 
            Indra is the supreme authority who utilizes his fierce and invincible power to maintain the justice, discipline, and balance of the universe. 
            Singing his glories with devotion awakens the dormant courage, heroism, and vigor within a person, enabling them to emerge victorious in life. 
            O God, remove every dark aspect of our existence and bestow upon us that brilliance which allows us to attain a place of honor in society. 
            By your grace, let us receive that wealth which is earned strictly by following the path of Truth and which is beneficial for all of humanity. 
            We worship you because you are the one who purifies our inner self and allows us to experience the proximity of God and spiritual peace. 
            You are the supreme power that transforms our hard labor into divine results and our desperate prayers into magnificent celestial blessings. 
            A seeker who takes refuge in Lord Indra never remains weak or helpless; they are blessed with the sharpness of self-knowledge and abundance. 
            O Indra, stay with us as our protector and eternal guide, and graciously make us great, successful, renowned, and devoted to Dharma. 
            We bow before your vast and grand majesty and pray that the stream of your divine grace remains forever flowing through our entire life.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 30,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ३० ॥",
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
            हम आपकी इस भव्य महिमा को बार-बार नमन करते हैं और आपसे यही याचना करते हैं कि आप सदैव हमारे रक्षक बनकर हमें सन्मार्ग पर गतिशील बनाए रखें।
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
            We repeatedly bow before your magnificent glory and pray that you remain our guardian forever, keeping us dynamic on the righteous path.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 31,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ३१ ॥",
        hindiCommentary = """
            हे असीम शक्ति के स्वामी इन्द्रदेव! आप हमारी प्रार्थनाओं और स्तुतियों से प्रसन्न होकर हमारे प्रति दयालु भाव रखते हुए यहाँ पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ हमारे जीवन के इस यज्ञ में सहायक और रक्षक बनकर आएं। 
            आपकी दिव्य उपस्थिति हमारे भीतर के आत्मविश्वास को जागृत करती है और हमें कठिन से कठिन परिस्थितियों से लड़ने का साहस प्रदान करती है। 
            जब आप हमारे पक्ष में खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति या मानसिक विकार हमें पराजित करने का साहस नहीं कर सकता। 
            हे देवराज, आप हमारे अज्ञान रूपी अंधकार को अपनी प्रखर ज्योति से मिटाकर हमारे जीवन में ज्ञान और विवेक का प्रकाश फैलाएं। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख, शांति और पवित्रता का वास होता है। 
            हम अपनी विनम्र और आर्त पुकार से आपको बुलाते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी अनंत उदारता से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी दिव्य महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी अजेय सुरक्षा की छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण और मंगल सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, the master of infinite power, being pleased by our sincere prayers and harboring a kind intent toward us, please manifest here. 
            Arrive in this sacrifice of our lives as a helper and guardian, accompanied by your grand and immensely vast protective divine powers. 
            Your sacred presence awakens the latent self-confidence within us and grants us the courage required to battle the most difficult life situations. 
            When you stand on our side, no negative force of the world or any mental affliction can ever dare to defeat or disturb our inner peace. 
            O King of Gods, erase the darkness of our ignorance with your intense light and spread the radiance of wisdom and discernment in our lives. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness, peace, and purity reside. 
            We invoke you with our humble and desperate cries so that you may fulfill every single scarcity of our existence with your infinite generosity. 
            You are the supreme authority that makes our hard work meaningful and continuously drives us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your divine glory and keep us forever safe under the shadow of your invincible protection. 
            Our ultimate well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 32,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ३२ ॥",
        hindiCommentary = """
            हे साधकों! आप उन अद्भुत और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो पवित्र सोमरस का पान कर अत्यंत आनंदित होते हैं। 
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
        id = 33,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ३३ ॥",
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
        id = 34,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ३४ ॥",
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
        id = 35,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ३५ ॥",
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
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को समूल नष्ट कर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाने की कृपा करे।
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
        id = 36,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ३६ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज (वृषा) के रूप में इस संपूर्ण ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान में आपको प्रसन्न करने के लिए अपनी स्तुतियों और अपार श्रद्धा के साथ आपकी अनन्य सेवा और अर्चना करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण चराचर जगत और इसकी समस्त गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक प्रदीप्त हो जाते हैं। 
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
        id = 37,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ३७ ॥",
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
        id = 38,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ३८ ॥",
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
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 39,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ३९ ॥",
        hindiCommentary = """
            समस्त स्तुतियां और प्रार्थनाएं समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और संसार में प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अथाह है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और दिव्य सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से कुशलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत और सचेत होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक और मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग दिखाए, यही प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and unfathomable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and divine charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 40,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ४० ॥",
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
        id = 41,
        sanskrit = "तमिन्द्रं वाजयामसि महे वृत्राय हन्तवे ।\nस वृषा वृषभो बभूविथ ॥ ४१ ॥",
        hindiCommentary = """
            हम उन इन्द्रदेव को बल और सामर्थ्य प्रदान करने वाली स्तुतियां अर्पित करते हैं ताकि वे महान शत्रु वृत्रासुर का समूल वध कर सकें। 
            वे स्वयं असीम शक्ति के महान पुंज और श्रेष्ठ वीरों में भी सर्वश्रेष्ठ हैं, जो अधर्म का नाश करने के लिए सदैव शस्त्र धारण किए रहते हैं। 
            भक्तों की श्रद्धापूर्ण प्रार्थनाएं इन्द्र के वज्र को और अधिक प्रखर और अजेय बनाती हैं, जिससे वे संसार की समस्त बाधाओं को नष्ट करने में सक्षम होते हैं। 
            वृत्र केवल एक पौराणिक राक्षस नहीं, बल्कि हमारे मार्ग में आने वाला वह हर सूक्ष्म अवरोध है जो हमें सत्य की प्राप्ति और आत्मोन्नति से रोकता है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारे भीतर के अज्ञान, जड़ता और आलस्य का अंत कर हमारे जीवन में परम प्रकाश का मार्ग सदा के लिए खोलें। 
            आपकी विजय ही हमारी वास्तविक विजय है, और हम आपकी निरंतर जय-जयकार करते हुए स्वयं को आपके दिव्य और कल्याणकारी कार्यों के लिए समर्पित करते हैं। 
            आपकी ऊर्जा हमारे शरीर में जीवनी शक्ति बनकर और मन में दृढ़ संकल्प बनकर अनवरत बहती है, जिससे हम जीवन के युद्ध में कभी हार नहीं मानते। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि आप हमारे जीवन के प्रत्येक संघर्ष में हमें सफलता और शांति की ओर ले जाने वाले महान सहायक बनें। 
            इन्द्रदेव की अजेय शक्ति हमें यह विश्वास दिलाती है कि अंततः जीत सदैव धर्म और सत्य की ही होती है, चाहे अंधकार का शत्रु कितना भी प्रबल क्यों न हो। 
            हे इन्द्र, आप हमारे परम रक्षक हैं, हमें अपनी दिव्य ज्वाला में तपाकर पूर्णतः शुद्ध करें और हमें दिव्यता के सर्वोच्च और पवित्र शिखर पर पहुँचाएँ।
        """.trimIndent(),
        englishCommentary = """
            We offer hymns that bestow strength and capability to Lord Indra so that he may completely slay the great and formidable enemy, Vritra. 
            He is himself the immense mass of infinite energy and the foremost among the great heroes, always armed to destroy unrighteousness. 
            The devoted prayers of his followers sharpen Indra's thunderbolt (Vajra), enabling him to effectively annihilate all the obstacles of the world. 
            Vritra is not just a mythological demon but every single subtle barrier in our path that prevents us from attaining Truth and Self-growth. 
            O God, with your fierce power, end the ignorance, lethargy, and laziness within us and open the pathway of supreme light in our lives forever. 
            Your victory is our true victory, and as we continuously hail your name, we dedicate ourselves to your divine and benevolent purposes. 
            Your energy flows within us as the vital force and as a firm resolution in the mind, ensuring we never give up in the battle of life. 
            We worship you with devotion so that you become our constant and great helper, leading us toward success and peace in every life struggle. 
            The invincible power of Lord Indra reassures us that victory ultimately belongs to Dharma and Truth, no matter how strong the enemy of darkness. 
            O Indra, you are our ultimate protector; refine us in your divine flame and lead us to the supreme and holy heights of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 42,
        sanskrit = "इन्द्राय मधुमत्तमं सोमं पवस्व धारया ।\nशविष्ठाय मत्सराः ॥ ४२ ॥",
        hindiCommentary = """
            हे सोमरस! आप अत्यंत मधुर, पवित्र और आनंददायक होकर अपनी पावन धारा के साथ सबसे बलवान और तेजस्वी इन्द्र की ओर निरंतर प्रवाहित हों। 
            यह सोम ही इन्द्रदेव का मुख्य आहार है, जिसे पीकर वे संपूर्ण ब्रह्मांड की रक्षा के लिए अपनी अजेय शक्ति प्राप्त करते हैं और परमानंदित होते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण के समस्त विकारों को धोकर हमें दिव्यता, अखंड शांति और साक्षात् ईश्वर के सान्निध्य का दिव्य अनुभव कराए। 
            जैसे सोम यज्ञ की अग्नि में अर्पित होकर सीधे देव-लोक तक पहुँचता है, वैसे ही हमारे पवित्र संकल्प भी आपकी शक्ति से उस परम पद को प्राप्त करें। 
            हे देव, आप ही वह दिव्य माध्यम हैं जो हमारे प्रार्थनाओं और भावनाओं को देवताओं के समूह तक सुरक्षित और अत्यंत शीघ्रता से पहुँचाने का कार्य करते हैं। 
            आपकी कृपा से हमारे जीवन के समस्त अमंगल, दरिद्रता और दुख सदा के लिए दूर हों और हमें शाश्वत दैवीय सुख की वास्तविक अनुभूति प्राप्त हो सके। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आपके बिना कोई भी महान यज्ञ या आध्यात्मिक अनुष्ठान अपनी पूर्णता और सार्थकता को प्राप्त नहीं कर सकता। 
            आपकी यह तेजस्वी और मधुर धारा हमारे भीतर के अज्ञान को जलाकर हमें सत्य के साक्षात्कार और आत्मज्ञान की ओर ले जाने का मार्ग प्रशस्त करे। 
            हे इन्द्र, आप इस मधुर रस का पान कर अत्यंत प्रसन्न हों और हमारे घरों और हृदयों को सुख, संपन्नता और शांति से भर देने की महान कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और पूर्णतः ईश्वरमय बना रहे, यही हमारी प्रार्थना है।
        """.trimIndent(),
        englishCommentary = """
            O Soma, being most sweet, holy, and exhilarating, flow in a sacred stream toward the most powerful and radiant Lord Indra. 
            This Soma is the primary nourishment of Indra, by consuming which he gains invincible strength to protect the entire cosmos and rejoices. 
            May this holy stream wash away all the stains and impurities of our inner self, filling us with divinity, peace, and the presence of God. 
            Just as Soma offered in the fire reaches the celestial realms directly, let our spiritual resolutions reach the supreme state through your power. 
            O God, you are the essential medium who carries our humble prayers and emotions safely and swiftly to the assembly of the divine gods. 
            By your grace, let all the inauspiciousness, poverty, and sorrows of our lives be removed, granting us the experience of eternal bliss. 
            We worship you with deep devotion because no great sacrifice or spiritual ritual can reach its completion and meaning without your presence. 
            May your radiant and sweet stream burn away the darkness of our ignorance and pave the way for us to realize the Truth and Self-knowledge. 
            O Indra, rejoice greatly by consuming this nectar and graciously fill our homes and hearts with happiness, prosperity, and enduring peace. 
            We offer our entire faith at your feet so that our lives remain meaningful, nourished, and completely God-conscious in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 43,
        sanskrit = "प्र मंहिष्ठाय गायत ऋतावानं विचेतसम् ।\nइन्द्रं विश्वा अवीवृधन् ॥ ४३ ॥",
        hindiCommentary = """
            आप उन अत्यंत उदार, सत्य के महान रक्षक और विशेष रूप से ज्ञानी इन्द्रदेव के लिए हृदय की गहराई से भक्तिपूर्वक गान और वंदना करें। 
            समस्त ब्रह्मांडीय शक्तियों और भक्तों की निष्कपट वाणियों ने इन्द्र की महिमा को निरंतर बढ़ाया है और उन्हें जगत के सर्वोच्च पद पर प्रतिष्ठित किया है। 
            इन्द्र ही वह चेतना हैं जो सत्य के मार्ग पर चलने वाले साधकों का मार्गदर्शन करती है और उन्हें अज्ञान के भयानक बंधनों से पूर्णतः मुक्त कराती है। 
            उनकी उदारता की कोई सीमा नहीं है; वे अपने प्रत्येक शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके वास्तविक कल्याण के लिए अनिवार्य है। 
            हे देव, आप अपनी प्रखर बुद्धि से हमारे समस्त संशयों का नाश कर हमें वह स्पष्ट दृष्टि दें जिससे हम जीवन के गूढ़ रहस्यों को सरलता से जान सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे मन की मलीनता दूर होती है और हम ईश्वर के अनंत प्रेम, दया और शांति का अनुभव करने लगते हैं। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे कठिन परिश्रम को ईश्वरीय फल में और हमारी छोटी-छोटी प्रार्थनाओं को दिव्य आशीषों में बदलने का सामर्थ्य रखती हैं। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, यश, कीर्ति और आध्यात्मिक उन्नति लाने की कृपा करें। 
            इन्द्रदेव की पावन उपस्थिति मात्र से ही हमारे समस्त अभाव दूर हो जाते हैं और हम अपने भीतर एक अखंड पूर्णता और दिव्य आनंद का अनुभव करते हैं। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहें और हमें दिव्यता के मार्ग पर निरंतर और सफलतापूर्वक अग्रसर करते रहें।
        """.trimIndent(),
        englishCommentary = """
            Sing devotedly from the depths of your heart for the most generous, the great guardian of Truth, and the highly wise Lord Indra. 
            All cosmic forces and the sincere voices of his devotees have continuously increased Indra's glory and established him at the universe's supreme state. 
            Indra is that consciousness which guides seekers walking the path of Truth and liberates them completely from the heavy bonds of ignorance. 
            There is no limit to his generosity; he bestows upon every surrendered devotee everything that is mandatory for their ultimate well-being. 
            O God, with your sharp intelligence, destroy all our doubts and grant us that clear vision to understand the deep mysteries of existence easily. 
            The continuous singing of your glories removes the impurities of our minds and allows us to experience the infinite love and peace of the Divine. 
            You are the supreme power that possesses the strength to transform our hard work into divine results and our simple prayers into blessings. 
            We bow before you with devotion so that you bring abundance, fame, and spiritual evolution into every single aspect of our lives. 
            The holy presence of Lord Indra dissolves all our scarcities, making us experience a sense of unbroken completeness and divine joy within. 
            O Indra, stay with us forever as our protector and nourisher, and continue to lead us steadily and successfully on the radiant path of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 44,
        sanskrit = "यस्य द्विता विधर्तुः साकमस्य सतो वशा ।\nस न इन्द्रः शिवः सखा ॥ ४४ ॥",
        hindiCommentary = """
            जिन इन्द्रदेव की आज्ञा और शासन इस ब्रह्मांड के दोनों लोकों (पृथ्वी और अंतरिक्ष) में विधिवत व्याप्त और अत्यंत गौरव के साथ प्रतिष्ठित है। 
            वे ही महान देव हमारे लिए एक कल्याणकारी और अत्यंत आत्मीय मित्र बनकर हमारे जीवन के प्रत्येक सुख-दुख में सदैव हमारे साथ उपस्थित रहें। 
            इन्द्र का शासन केवल कठोर दंड पर नहीं, बल्कि न्याय, व्यवस्था और प्रेम पर आधारित है, जो संपूर्ण चराचर जगत को अनुशासित और संतुलित रखता है। 
            उनकी मित्रता हमें वह अद्भुत संबल प्रदान करती है जिससे हम जीवन के बड़े से बड़े युद्धों को अत्यंत शांति, धैर्य और कुशलता के साथ जीत सकते हैं। 
            हे देवराज, आप हमारे सबसे निकट के हितैषी बनकर हमें वह श्रेष्ठ मार्गदर्शन दें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर कदम न बढ़ाएं। 
            जब आप हमारे सखा बनते हैं, तब संसार की कोई भी नकारात्मक शक्ति या प्रतिकूल परिस्थिति हमें अपने महान लक्ष्य से कभी विचलित नहीं कर सकती। 
            हम श्रद्धापूर्वक आपकी अर्चना करते हैं ताकि हमारे जीवन में केवल शुभ और मंगल का ही उदय हो और हम सदैव आपकी सुरक्षित छाया में निर्भय रहें। 
            आपकी कृपा से ही हमारे परिवारों में एकता, प्रेम और धर्मनिष्ठा का वास होता है, जो हमारे संपूर्ण सामाजिक और आध्यात्मिक जीवन को सुखमय बनाता है। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के शाश्वत और दिव्य प्रकाश की ओर ले जाने की महान कृपा करें। 
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा, शांति और मंगलकारी आशीष की हृदय से याचना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            Lord Indra, whose command and governance are duly established and pervasive with great glory across both the realms (Earth and Atmosphere). 
            May that great deity remain forever present in our lives as a benevolent and highly intimate friend through all our joys and sorrows. 
            Indra's rule is not based on mere harsh punishment but on justice, order, and love, which keeps the entire universe balanced and disciplined. 
            His friendship provides us with that amazing support through which we can win the greatest battles of life with peace, patience, and skill. 
            O King of Gods, become our nearest well-wisher and guide us excellently so that we never take a step on the path of unrighteousness or untruth. 
            When you become our companion, no negative force or adverse worldly situation can ever sway or distract us from our great spiritual goal. 
            We worship you with devotion so that only the auspicious arises in our lives and we always remain fearless under your protective divine shadow. 
            By your grace alone, unity, love, and righteousness reside in our families, making our entire social and spiritual life blissful and meaningful. 
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Supreme Truth. 
            We repeatedly bow before your divine and magnificent glory and seek your constant protection, peace, and auspicious blessings from our heart.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 45,
        sanskrit = "अभित्वा शूर नोनुमो दुग्धा इव धेनवः ।\nईशानमस्य जगतः स्वर्दृशमीशानमिन्द्र तस्थुषः ॥ ४५ ॥",
        hindiCommentary = """
            हे परम वीर इन्द्रदेव! जैसे दुधारू गौएँ अपने बछड़े की ओर अत्यंत प्रेम और व्याकुलता से रंभाती हुई दौड़ती हैं, वैसे ही हम आपकी स्तुति करते हैं। 
            आप इस संपूर्ण चराचर जगत के एकमात्र स्वामी हैं, जो जड़ (स्थिर) और चेतन (गतिशील) दोनों पर न्यायपूर्वक शासन करने वाले महान देव हैं। 
            आपकी दिव्य दृष्टि स्वर्ग की ऊँचाइयों तक व्याप्त है, और आप ही समस्त लोकों के वास्तविक नियन्ता, स्रष्टा और परम रक्षक के रूप में प्रतिष्ठित हैं। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के गहन अंधकार को दूर कर उसे ज्ञान और सत्य के अखंड प्रकाश से भर देने वाले देव हैं। 
            आपकी कृपा से ही हमें वह आत्मिक सामर्थ्य प्राप्त होता है जिससे हम अपनी अनियंत्रित इंद्रियों और चंचल मन पर पूर्ण विजय और नियंत्रण पा सकें। 
            जैसे गौ अपने अमृत तुल्य दूध से संसार का पोषण करती है, वैसे ही आप अपनी असीम कृपा की वर्षा से अपने भक्तों का सर्वांगीण कल्याण करते हैं। 
            आपकी महिमा का गान करने से हमारे भीतर के सोए हुए साहस, वीरता और आत्मविश्वास का पुनर्जागरण होता है, जो हमें कर्मक्षेत्र में विजयी बनाता है। 
            हे देवराज, आप हमारे हृदयों में भक्ति का ऐसा अखंड दीपक जलाएं जो अज्ञान की आँधियों में भी कभी न बुझे और हमें सदैव सही मार्ग दिखाता रहे। 
            हम श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमें आध्यात्मिक शांति और भौतिक संपन्नता दोनों ही प्रकार की श्रेष्ठ समृद्धियाँ प्रदान करें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या दरिद्र नहीं रहता, उसे ज्ञान और ऐश्वर्य की वह प्रचुरता प्राप्त होती है जो संसार में दुर्लभ है।
        """.trimIndent(),
        englishCommentary = """
            O supremely heroic Lord Indra, just as milch cows low with great love and longing toward their calves, we continuously chant your praises. 
            You are the sole sovereign Lord of this entire universe, governing both the non-moving (Jada) and the moving (Chetana) entities with justice. 
            Your divine vision extends to the absolute heights of the heavens, and you are established as the true controller, creator, and protector of all realms. 
            We worship you because you are the deity who removes the deep darkness of our lives and fills them with the eternal light of knowledge and truth. 
            It is only through your grace that we receive the spiritual strength required to gain total victory and mastery over our senses and mind. 
            Just as a cow nourishes the world with its nectar-like milk, you nourish your devotees' welfare with the constant showers of your infinite grace. 
            Singing your glories awakens the dormant courage, heroism, and self-confidence within us, enabling us to emerge victorious in the field of action. 
            O King of Gods, ignite such an eternal lamp of devotion in our hearts that it never flickers in the storms of ignorance and always shows us the path. 
            We bow before your feet with profound faith so that you may grant us superior prosperity in both spiritual peace and material abundance. 
            A seeker who takes refuge in Lord Indra never remains weak or poor; they attain that abundance of wisdom and splendor which is rare in the world.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 46,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ ४६ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आपके समान शक्तिशाली और दयालु न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न इतिहास में कोई हुआ है और न भविष्य में होगा। 
            आपकी महानता और शक्ति की तुलना किसी भी अन्य सत्ता से नहीं की जा सकती, आप अद्वितीय और सर्वोत्तम शक्तियों के परम स्वामी और रक्षक हैं। 
            हम शक्ति, अटूट विजय और प्रचुर संसाधनों (गौओं) की कामना करते हुए आपको अपने इस पवित्र यज्ञ में अत्यंत आदर के साथ आमंत्रित करते हैं। 
            आप ही वह एकमात्र शक्ति हैं जो हमारे जीवन में श्रेष्ठता, पूर्णता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम अपनी श्रद्धा के साथ आपकी शरण में हैं। 
            आपकी दिव्यता समस्त मानवीय और दैवीय सीमाओं से परे है, और आप ही ऋत (ब्रह्मांडीय व्यवस्था) के मार्ग के सबसे बड़े संरक्षक और सजग प्रहरी हैं। 
            जब हम आपका हृदय से आह्वान करते हैं, तो हमारे भीतर एक नई चेतना और ऊर्जा का संचार होता है जो हमें समस्त शत्रुओं और बाधाओं पर विजय दिलाती है। 
            संसार की कोई भी विघ्न-बाधा आपके अजेय वज्र के सामने क्षण भर भी टिक नहीं सकती, कृपया आप हमारे मार्ग के समस्त कंटकों को सदा के लिए दूर करें। 
            हमें वह दिव्य प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और अपने जीवन के प्रत्येक लक्ष्य में पूर्णतः सफल हों। 
            आपकी कृपा दृष्टि से हमारा कल्याण और सौभाग्य सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार हृदय से वंदना करते हैं। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम प्रकाश की ओर ले चलें और हमारा जीवन सार्थक बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, there is none as powerful and merciful as you in the heavens, nor on earth; none has existed in history, nor will exist. 
            Your greatness and might are beyond comparison with any other entity; you are the unique and supreme master and guardian of the highest powers. 
            Desiring spiritual strength, unbroken victory, and abundant resources, we call upon you in our sacred sacrificial ritual with the utmost respect. 
            You are the only power capable of bringing excellence, completeness, and plenty into our lives; we seek your divine refuge with total faith. 
            Your divinity transcends all human and celestial boundaries, and you stand as the greatest protector and alert sentinel of the Cosmic Order (Rta). 
            When we invoke you from our hearts, a new surge of consciousness and energy flows through us, granting us victory over all foes and hurdles. 
            No obstacle in this world can withstand your invincible thunderbolt for even a moment; please remove all the thorns from our path forever. 
            Grant us that divine wisdom and courage required to always be ready for the defense of Dharma and to be fully successful in every goal of life. 
            Our well-being and good fortune are guaranteed under your merciful gaze; we repeatedly bow before your magnificent and invincible power. 
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the Supreme Light and graciously make our lives meaningful.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 47,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानां पतिं चर्कृत्यम् ॥ ४७ ॥",
        hindiCommentary = """
            हे ज्ञानियों! समस्त पवित्र स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में प्रकाशित करती हैं। 
            वे दिव्य रथियों में सर्वश्रेष्ठ और समस्त विजयों के परम अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और गौरवपूर्ण वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत और अतुलनीय है, जिसमें संपूर्ण ब्रह्मांड की समस्त शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और शक्तिशाली सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से सफलतापूर्वक और निर्विघ्न निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक नेक प्रयास को सफलता के उच्चतम और श्रेष्ठ शिखर तक पहुँचाने की महान कृपा करें। 
            हमें वह आध्यात्मिक और मानसिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को सदैव इस जगत में ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की पूर्ण शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत, सचेत और पवित्र होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं संपूर्ण ब्रह्मांड का नायक उसका सहायक, रक्षक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का सही मार्ग दिखाए, यही हमारी विनम्र प्रार्थना है। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आत्मिक रूप से सुखी बनाने की महान कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O wise ones, all the sacred hymns continuously increase and illuminate the glory of Lord Indra, who is as vast and all-encompassing as the ocean. 
            He is the foremost among divine charioteers and the absolute Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite and incomparable like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful and powerful charioteer of our life's vessel, guiding us successfully and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every noble effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and mental power so that we can assist the weak and keep the flag of righteousness flying high in the world. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper, protector, and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and spiritually happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 48,
        sanskrit = "स नः शुभः शुभंभर इन्द्रो विश्वाभिरूतिभिः ।\nअस्मे धेहि श्रवश्च्यौतम् ॥ ४८ ॥",
        hindiCommentary = """
            हे कल्याणकारी इन्द्रदेव! आप शुभ फल और मंगल प्रदान करने वाले देव हैं, कृपया अपनी समस्त रक्षात्मक और दिव्य शक्तियों के साथ हमारे जीवन में पधारें। 
            आप हमारे जीवन में वह स्थायी यश और ऐश्वर्य स्थापित करें जो शत्रुओं और नकारात्मक शक्तियों के प्रभाव को जड़ से पूरी तरह समाप्त कर देने वाला हो। 
            आपकी शुभता हमारे घर, परिवार और मन को पवित्र करती है, जिससे हमारे भीतर सात्विक गुणों और दैवीय प्रवृत्तियों का निरंतर और तीव्र विकास होता है। 
            जब आप अपनी महान और अजेय शक्तियों के साथ हमारे सहायक बनते हैं, तो सफलता और संपन्नता स्वतः ही हमारे प्रत्येक कार्य का अनुसरण करने लगती है। 
            हे देवराज, आप हमारे अज्ञान रूपी शत्रुओं को नष्ट कर हमें वह कीर्ति प्रदान करें जो सत्य पर आधारित हो और जो काल के प्रवाह में सदैव स्थायी बनी रहे। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य और दिव्य कवच बनाती हैं जिसमें कोई भी नकारात्मकता, रोग या शोक कभी प्रवेश नहीं कर सकता। 
            हम अपनी हृदयस्पर्शी प्रार्थनाओं से आपकी उस शक्ति का आह्वान करते हैं जो असंभव को भी संभव बनाने और हमें विपदाओं से उबारने का सामर्थ्य रखती है। 
            आप ही वह आदि ऊर्जा हैं जो हमारे शिथिल पड़ते संकल्पों में नवीन प्राण और उत्साह फूंकती हैं और हमें जीवन के प्रत्येक क्षेत्र में विजयी बनाती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता के साथ हमारे यज्ञ को सिद्ध करें और हमें आध्यात्मिक उन्नति और आत्मसाक्षात्कार के परम मार्ग की ओर ले चलें। 
            आपकी कृपा दृष्टि से हमारा भविष्य पूर्णतः सुरक्षित और अत्यंत उज्ज्वल है, हम आपकी इस अजेय और भव्य शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O auspicious Lord Indra, you are the bringer of good fortune and prosperity; please manifest in our lives with all your protective and divine powers. 
            Establish within us that lasting fame and prosperity which has the divine strength to completely uproot the influence of all negative forces. 
            Your auspiciousness sanctifies our homes, families, and minds, leading to the rapid development of virtuous and celestial qualities within us. 
            When you become our helper with your vast and invincible powers, success and abundance naturally begin to follow our every noble endeavor. 
            O King of Gods, destroy the internal enemies of ignorance and grant us fame that is rooted in Truth and remains permanent through time. 
            Your protective energies form an impenetrable and divine shield around us, through which no form of negativity, disease, or sorrow can penetrate. 
            Through our heartfelt prayers, we invoke that power of yours which possesses the capability to make the impossible possible and rescue us from calamities. 
            You are the primordial energy that breathes new life and enthusiasm into our weakening resolutions and empowers us to emerge victorious in every field. 
            O Indra, with your infinite generosity, perfect our sacrifice and lead us toward the path of profound spiritual evolution and self-realization. 
            Our future is completely safe and immensely bright under your merciful gaze; we repeatedly bow before your invincible and magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 49,
        sanskrit = "आ तू न इन्द्र क्षुमन्तं चित्रं ग्राभं सं गृभाय ।\nमहाहस्ती दक्षिणेन ॥ ४९ ॥",
        hindiCommentary = """
            हे अत्यंत विशाल और शक्तिशाली हाथों वाले इन्द्रदेव! आप अपने उदार दाहिने हाथ से हमारे लिए अद्भुत, श्रेष्ठ और प्रचुर धन एवं ऐश्वर्य ग्रहण करें। 
            आप हमें वह अन्न, स्वास्थ्य और समृद्धि प्रदान करें जो हमारे संपूर्ण परिवार का पोषण करे और हमें समाज में एक सम्मानित और गौरवपूर्ण स्थान दिलाए। 
            आपके उदार हाथ सदैव अपने भक्तों को आशीष देने और उनकी झोलियाँ भरने के लिए उठे रहते हैं, कृपया हमारी विनम्र प्रार्थनाओं को स्वीकार कर हमें निहाल करें। 
            हमें वह 'अद्भुत पकड़' और अटूट सफलता प्रदान करें जिससे हम अपने जीवन के महान लक्ष्यों को दृढ़तापूर्वक और पूर्णता के साथ प्राप्त करने में सफल हो सकें। 
            इन्द्रदेव की विशेष कृपा से प्राप्त ऐश्वर्य न केवल सुख देता है, बल्कि वह हमें धर्म के महान कार्यों में दान देने और परोपकार करने के योग्य भी बनाता है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारी दरिद्रता और मानसिक संकीर्णता का नाश करें और हमारे जीवन में आध्यात्मिक एवं भौतिक संपन्नता का सूर्य उदय करें। 
            जब आप अपनी इन महान भुजाओं से हमारी रक्षा करते हैं, तब हमें संसार की किसी भी असुर शक्ति या प्रतिकूल परिस्थिति से तनिक भी डरने की आवश्यकता नहीं। 
            आप ही वह परम शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें सर्वांगीण उन्नति के पथ पर निरंतर और सफलतापूर्वक आगे बढ़ाती हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के प्रत्येक अभाव को पूर्णता में और प्रत्येक दुख को सुख में बदलने वाले एकमात्र देव हैं। 
            हे इन्द्र, आप अपनी दिव्य उदारता के साथ हमारे घर और हृदय में सदैव विराजें और हमें निरंतर अपनी अजेय और मंगलकारी सुरक्षा की छाया में रखें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra with immensely mighty and vast hands, with your generous right hand, grasp and bring for us wonderful, superior, and vast wealth. 
            Bestow upon us that nourishment, health, and prosperity which sustains our entire family and earns us an honored and dignified place in society. 
            Your generous hands are always raised to bless your devotees and fill their lives with abundance; please accept our humble prayers and bless us. 
            Grant us that 'marvelous grasp' and unbreakable success enabling us to firmly and completely achieve all the great and noble goals of our lives. 
            Prosperity obtained through the special grace of Indra not only provides comfort but also makes us capable of performing charity and noble deeds. 
            O God, with your fierce power, destroy our poverty and mental narrowness, and make the sun of spiritual and material plenty rise within our lives. 
            When you protect us with your magnificent and powerful arms, we have no reason to fear any demonic force or adverse worldly situation whatsoever. 
            You are the supreme power that makes our hard work meaningful and continuously drives us forward successfully on the path of holistic evolution. 
            We worship you with deep devotion because you are the only deity capable of transforming every scarcity of our life into absolute completeness. 
            O Indra, reside in our homes and hearts with your divine generosity and keep us forever protected under the shadow of your invincible grace.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 50,
        sanskrit = "का त उस्तिः शविष्ठ्य का मतिः का सुवृक्तिः ।\nकदा वसूनि भरसि ॥ ५० ॥",
        hindiCommentary = """
            हे अत्यंत बलवान और तेजस्वी इन्द्रदेव! आपकी स्तुति करने का वह सही और श्रेष्ठ ढंग क्या है, और आपको प्रसन्न करने वाली दिव्य बुद्धि कौन सी है? 
            वह कौन सा उत्तम और पवित्र कर्म है जिससे आप पूर्णतः संतुष्ट होते हैं, और आप हमें अपना वह अद्भुत और दिव्य ऐश्वर्य कब प्रदान करेंगे? 
            भक्त का यह जिज्ञासु प्रश्न उसकी आंतरिक व्याकुलता और आपके साक्षात् सान्निध्य की तीव्र इच्छा को दर्शाता है, जो केवल पूर्ण समर्पण से ही शांत हो सकती है। 
            हम अपनी इस अल्प और सीमित बुद्धि से आपकी विराट महिमा को समझने का निरंतर प्रयास कर रहे हैं, कृपया हमें सही मार्ग, विवेक और दिव्य प्रज्ञा प्रदान करें। 
            हे देवराज, आप ही समस्त ज्ञान के अक्षय भंडार हैं, हमें वह संस्कार और पवित्रता दें जिससे हम आपकी स्तुति करने के वास्तविक और योग्य अधिकारी बन सकें। 
            जब मनुष्य अपने अहंकार और 'मैं' के भाव को त्यागकर आपकी शरण में आता है, तभी उसे आपके दिव्य ऐश्वर्य, परम शांति और अखंड आनंद की प्राप्ति होती है। 
            आपकी कृपा का समय और रूप आपकी ही दिव्य इच्छा पर निर्भर है, परंतु हमारा परम कर्तव्य निरंतर आपकी निष्काम उपासना और धर्म का पालन करना ही है। 
            आप ही वह प्रकाशपुंज हैं जो हमारे जीवन के अंधकारमय संशयों और भयों को दूर कर हमें सत्य के साक्षात्कार और आत्मज्ञान की ओर सफलतापूर्वक ले जाते हैं। 
            हम विनम्र भाव से और धैर्यपूर्वक आपकी उस बेला की प्रतीक्षा करते हैं जब आप हमारे संपूर्ण जीवन को अपनी वैभवशाली ज्योति से सदा के लिए आलोकित करेंगे। 
            हे इन्द्र, आप हमारे सर्वोच्च गुरु और रक्षक बनकर हमें वह विवेक दें जिससे हम आपके रहस्यों को समझ सकें और अपने मानव जीवन के लक्ष्य में पूर्णतः सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O most powerful and radiant Indra, what is the proper and superior way to praise you, and what is the divine intellect that truly pleases you? 
            Which noble and holy deed satisfies your supreme divinity completely, and when will you bring forth your marvelous and divine treasures for us? 
            This curious inquiry of the devotee reflects his inner restlessness and intense longing for your presence, stilled only by absolute surrender. 
            We are continuously attempting to comprehend your vast majesty with our limited intellect; please graciously grant us the right path and wisdom. 
            O King of Gods, you are the inexhaustible storehouse of all knowledge; grant us the virtues and purity to become worthy of your divine praise. 
            Only when a human renounces their ego and the sense of 'I' to seek your refuge do they attain your divine abundance, peace, and eternal bliss. 
            The timing and form of your grace depend entirely on your divine will, yet our duty is to remain engaged in your selfless worship and Dharma. 
            You are the mass of light that removes the dark doubts and fears of our lives and leads us successfully toward the realization of Truth and Self. 
            We wait with humility and patience for that moment when you decide to illuminate our entire existence with your magnificent and radiant light forever. 
            O Indra, become our supreme teacher and protector, granting us the discernment to understand your mysteries and succeed in our human life.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 51,
        sanskrit = "कुविद्ङ्ग मघवन् कस्यचिद् गिरो ज्रयो वाजस्य गन्त ।\nएवा हि ते मनो विचेतसम् ॥ ५१ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आप वास्तव में उन अनन्य भक्तों की वाणियों और स्तुतियों के पास स्वयं पहुँचते हैं जो जीवन में विजय और सिद्धि के लिए निरंतर प्रयत्नशील हैं। 
            आपका मन अत्यंत विशेष ज्ञानी, सूक्ष्मदर्शी और चतुर है, जो यह भली-भांति जानता है कि किस साधक को किस समय और क्या प्रदान करना उसके लिए श्रेष्ठ है। 
            आपकी बुद्धि ब्रह्मांड के गूढ़तम रहस्यों को भेदने वाली है, और आप केवल सच्ची अंतरात्मा की पुकार, अटूट श्रद्धा और निरंतर पुरुषार्थ से ही प्रसन्न होने वाले देव हैं। 
            जब हम एकाग्र और शांत मन से आपकी दिव्य महिमा का गान करते हैं, तो आपकी चेतना हमारे जीवन के समस्त कठिन संघर्षों में साक्षात् मार्गदर्शन करने लगती है। 
            हे देव, आप हमारे संकल्पों को वह अजेय गति और शक्ति दें जिससे हम अपने महान लक्ष्यों को अत्यंत शीघ्रता, सटीकता और पूर्णता के साथ प्राप्त करने में सफल हों। 
            आपकी कृपा का प्रवाह उन निस्वार्थ आत्माओं की ओर स्वतः ही मुड़ जाता है जो सदैव धर्म की रक्षा, सत्य के प्रसार और समाज के उत्थान के लिए समर्पित रहती हैं। 
            हमें वह 'विचेतस' (उच्चतर चेतना) प्रदान करने की कृपा करें जिससे हम सांसारिक मायाजाल और भ्रमों से बचकर केवल शाश्वत सत्य और परमात्मा की खोज कर सकें। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे कठिन परिश्रम को ईश्वरीय प्रसाद में और हमारी आर्त प्रार्थनाओं को महान दिव्य आशीषों में बदलने का सामर्थ्य रखती हैं। 
            इन्द्रदेव की पवित्र मित्रता हमें वह अभेद्य सुरक्षा प्रदान करती है जो हमें संसार के भीषण प्रलोभनों और प्रतिकूलताओं के बीच भी कभी विचलित नहीं होने देती। 
            हे इन्द्र, आप हमारे परम रक्षक और मार्गदर्शक बनकर हमें दिव्यता के उस सर्वोच्च शिखर पर ले चलें जहाँ केवल अखंड आनंद, सत्य और शाश्वत शांति का वास हो।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, you truly reach and attend to the voices and hymns of those exclusive devotees who strive for victory and spiritual success. 
            Your mind is exceptionally wise, discerning, and astute, knowing exactly what to bestow upon which seeker and at what time for their best growth. 
            Your intellect pierces through the deepest mysteries of the cosmos, and you are a deity pleased only by the soul's call, faith, and dedicated effort. 
            When we sing your divine glories with a focused and calm mind, your consciousness begins to guide us personally through all of life's struggles. 
            O God, grant our resolutions that invincible momentum and strength through which we can achieve our great goals with speed, precision, and completeness. 
            The flow of your grace naturally turns toward those selfless souls who are dedicated to the defense of Dharma, the spread of Truth, and social upliftment. 
            Graciously grant us that 'Vichetas' (higher consciousness) which enables us to avoid worldly illusions and seek only the eternal Truth and God. 
            You are the supreme power that possesses the strength to transform our hard labor into divine grace and our desperate prayers into celestial blessings. 
            Indra's holy friendship provides us with an impenetrable security that prevents us from wavering amidst the strongest worldly temptations and adversities. 
            O Indra, stay with us as our protector and guide, and lead us to that peak of divinity where only unbroken bliss, truth, and eternal peace reside.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 52,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ५२ ॥",
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
        id = 53,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ५३ ॥",
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
        id = 54,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ५४ ॥",
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
            O Indra, stay with us as our supreme protector and teacher, graciously making us magnificent, knowledgeable, successful, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 55,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ५५ ॥",
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
        id = 56,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ५६ ॥",
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
        id = 57,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ५७ ॥",
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
        id = 58,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ५८ ॥",
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
        id = 59,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ५९ ॥",
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
        sanskrit = "अयं ते अस्तु हर्यतः सोमः पुनानो अद्रिभिः ।\nइन्द्र तं रत्नधातमं भर ॥ ६१ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! पत्थरों (अद्रिभिः) द्वारा निष्कासित और अत्यंत पवित्र किया गया यह सोमरस आपके लिए सुखद और प्रिय (हर्यतः) हो। 
            आप रत्नों और श्रेष्ठ धन को धारण करने वाले (रत्नधातमम्) देव हैं, कृपया हमारे लिए दिव्य ऐश्वर्य और वैभव लेकर आएं। 
            यह सोम केवल एक भौतिक रस नहीं है, बल्कि यह भक्त के हृदय की प्रगाढ़ श्रद्धा और एकाग्रता का प्रतीक है। 
            जैसे पत्थरों के घर्षण से रस निकलता है, वैसे ही तपस्या और निरंतर अभ्यास से हमारे भीतर ज्ञान का अमृत प्रकट होता है। 
            हे देवराज, आप इस मधुर और ऊर्जावान सोम का पान कर प्रसन्न हों और हमें वह शक्ति दें कि हम सत्य के मार्ग पर अडिग रहें। 
            आपकी प्रसन्नता ही हमारे जीवन की सफलता का आधार है, क्योंकि आपकी कृपा से ही असंभव कार्य भी सुलभ हो जाते हैं। 
            हमें वह 'रत्न' (श्रेष्ठ गुण) प्रदान करें जो हमारे चरित्र को उज्ज्वल बनाएँ और समाज में हमें प्रतिष्ठित करें। 
            आप ही वह शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों में बदलने का सामर्थ्य रखती हैं। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि हमारा अंतःकरण शुद्ध हो और हम ईश्वर के सान्निध्य का अनुभव करें। 
            हे इन्द्र, आप हमारे जीवन के रक्षक और मार्गदर्शक बनकर हमें दिव्यता के सर्वोच्च शिखर पर ले जाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, may this Soma juice, extracted by the stones (Adribhih) and thoroughly purified, be delightful and pleasing to you. 
            You are the foremost possessor of treasures and jewels (Ratnadhatamam); please bring forth divine wealth and splendor for us. 
            This Soma is not merely a physical extract but symbolizes the intense devotion and deep concentration of a seeker's heart. 
            Just as the juice is pressed out through the friction of stones, the nectar of wisdom manifests within us through penance and constant practice. 
            O King of Gods, rejoice by consuming this sweet and energetic Soma, and grant us the strength to remain steadfast on the path of Truth. 
            Your satisfaction is the very foundation of our life's success, for it is through your grace that the impossible becomes attainable. 
            Bestow upon us those 'gems' (virtuous qualities) that refine our character and earn us a place of honor in the world. 
            You are the power that possesses the capability to transform our subtle intentions into cosmic achievements and realizations. 
            We worship you with devotion so that our inner self may be purified and we may experience the proximity of the Divine. 
            O Indra, stay with us as our protector and guide, and lead us graciously to the supreme heights of spiritual evolution.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 62,
        sanskrit = "अस्य पिबा क्षुमतो मादस्येन्द्र सुतस्य मतिभिः ।\nमहाँ महीभिः ऊतिभिः ॥ ६२ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप हमारी श्रेष्ठ बुद्धियों (मतिभिः) द्वारा तैयार किए गए इस अन्नयुक्त और आनंददायक (क्षुमतो मादस्य) सोमरस का पान करें। 
            आप अपनी महान और विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे सहायक और रक्षक बनकर यहाँ पधारें। 
            जब हम अपनी चेतना को आपकी स्तुति में लगाते हैं, तो यह मधुर सोम और भी अधिक प्रभावशाली और पवित्र हो जाता है। 
            आपकी उपस्थिति हमारे संकल्पों को वह दृढ़ता प्रदान करती है जिससे हम संसार के किसी भी प्रलोभन के सामने नहीं झुकते। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी शत्रुओं का नाश कर हमारे जीवन में ज्ञान की अविरल धारा प्रवाहित करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा कवच बनाती हैं जिसमें केवल सकारात्मकता और शांति का वास होता है। 
            हम अपनी विनम्र प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी उदारता से पूर्ण कर दें। 
            आप ही वह शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल नहीं रहता, उसे आत्मज्ञान और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे परम स्वामी और रक्षक हैं, हमें अंधकार से प्रकाश की ओर और मृत्यु से अमरत्व की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, please drink of this nourishing and exhilarating (Kshumato Madasya) Soma juice prepared with our best thoughts (Matibhih). 
            Come as our helper and guardian along with your grand and immense protective divine powers (Mahibhih Utibhih). 
            When we engage our consciousness in your praise, this sweet Soma becomes even more potent and sanctified for the ritual. 
            Your presence provides our resolutions with that steel-like firmness that prevents us from bowing before worldly temptations. 
            O King of Gods, destroy the internal enemies of ignorance within us and let the continuous stream of knowledge flow in our lives. 
            Your protective energies build such a shield of security around us, within which only positivity and tranquility reside. 
            We invoke you with our humble supplications so that you may fulfill every single scarcity of our existence with your generosity. 
            You are the power that makes our hard work meaningful and carries us forward on the path of evolution and holistic growth. 
            A seeker who takes refuge in Lord Indra never remains weak; they are granted the boons of both Self-knowledge and abundance. 
            O Indra, you are our supreme Lord and Protector; lead us from darkness to light and from mortality to immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 63,
        sanskrit = "य इन्द्र सोमपातमो मदस्तं प्रत्नथा सहः ।\nअषाळ्हं सहमानं पृतन्यन्तं सं यन्मध्वो अदुद्रवत् ॥ ६३ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! जो सोम का रस अत्यंत आनंददायक और शक्तिशाली है, उसे आप प्राचीन परंपरा (प्रत्नथा) के अनुसार हर्षपूर्वक ग्रहण करें। 
            वह सोम आपको वह अजेय बल प्रदान करे जो किसी भी शत्रु द्वारा पराजित न होने वाला (अषाळ्हं) और सबको वश में करने वाला हो। 
            जब मधुर सोमरस का प्रवाह आपकी दिव्य चेतना में मिलता है, तब आप ब्रह्मांड की रक्षा के लिए अपनी पूरी सामर्थ्य में होते हैं। 
            हे देवराज, आप ही हमारे जीवन के युद्धों में वह योद्धा हैं जो शत्रुओं की विशाल सेनाओं को परास्त करने की शक्ति रखते हैं। 
            सोम का पान कर आप अपने भक्त की आर्त पुकार सुनते हैं और उसे संसार के भयों से मुक्त कर अभय प्रदान करते हैं। 
            आपकी वीरता समस्त लोकों में गुंजायमान है, और आप ही ऋत (सत्य) के मार्ग के सबसे बड़े रक्षक और प्रहरी हैं। 
            इस अमृत तुल्य रस के प्रभाव से आप प्रसन्न होकर हमारे यज्ञ को सिद्ध करते हैं और हमें वांछित फल प्रदान करते हैं। 
            हम श्रद्धापूर्वक आपको यह सोम अर्पित करते हैं ताकि आप हमें मानसिक दृढ़ता और शारीरिक आरोग्य प्रदान करें। 
            आपके सानिध्य में हमारा मन निर्भय होता है और हम श्रेष्ठ लक्ष्यों की प्राप्ति के लिए निरंतर पुरुषार्थ करते हैं। 
            हे इन्द्र, आप अपनी अनंत ऊर्जा से हमारे जीवन के अंधकारमय विरोधियों का समूल नाश कर हमें प्रकाश की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, please accept the Soma juice which is most exhilarating and powerful, following the ancient traditions (Pratnatha). 
            May this Soma grant you that invincible strength which cannot be conquered (Asalham) and which subdues all opposing forces. 
            When the flow of sweet Soma merges with your divine consciousness, you are in your full capacity to protect the entire cosmos. 
            O King of Gods, you are the warrior in our life's battles who possesses the power to defeat the vast armies of enemies. 
            Having consumed the Soma, you listen to the desperate cries of your devotees and grant them fearlessness from worldly terrors. 
            Your heroism echoes through all the realms, and you stand as the greatest protector and sentinel of the Eternal Law (Rta). 
            Satisfied by this nectar-like juice, you perfect our sacrifice and bestow upon us the desired and auspicious results. 
            We offer this Soma with deep devotion so that you may grant us mental firmness and physical well-being. 
            In your divine presence, our minds become bold, and we continuously strive with effort to achieve our highest and noble goals. 
            O Indra, with your infinite energy, completely destroy the dark adversaries of our life and lead us toward the light.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 64,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ६४ ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो सोमरस का पान कर आनंदित होते हैं। 
            वे हमें ऐश्वर्य और धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महिमा भक्तों की वाणी से निरंतर बढ़ती रहती है। 
            जैसे माताएं और गौएँ अपने बछड़े (वत्सम्) की ओर प्रेमपूर्वक दौड़ती हैं, वैसे ही हमारी स्तुतियां और प्रार्थनाएं इन्द्र की ओर बढ़ती हैं। 
            आपकी उपस्थिति मात्र से हमारे मन की चंचलता समाप्त होती है और हम एकाग्र होकर आपकी दिव्य सत्ता का अनुभव करते हैं। 
            हे शक्तिशाली इन्द्र (वृषभम्), आप हमारे यज्ञ के आधार हैं और हमारे जीवन को ऊर्जस्वित करने वाले परम तेजस्वी देव हैं। 
            जैसे बछड़ा अपनी माँ से पोषण पाता है, वैसे ही हम आपकी कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्राप्त करते हैं। 
            आपकी उदारता की कोई सीमा नहीं है; आप अपने शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके सर्वांगीण विकास के लिए आवश्यक है। 
            हम अपनी मधुर और सत्य वाणी से आपको प्रसन्न करने का प्रयास करते हैं ताकि आप हमारे जीवन के समस्त दुखों का अंत कर सकें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी रिक्त नहीं रहता, उसे ज्ञान के प्रकाश और वैभव की प्रचुरता का वरदान मिलता है। 
            हे देवराज, आप हमारे हृदयों में अनन्य भक्ति का संचार करें और हमें सदैव अपनी दिव्य छाया में सुरक्षित और सुखी रखें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, praise the wonderful Lord Indra, the subduer of enemies, who rejoices in the consumption of the Soma nectar. 
            He remains ever ready to bestow abundance and prosperity upon us, and his glory is continuously increased by the hymns of his followers. 
            Just as mothers and cows run affectionately toward their calf (Vatsam), our hymns and heartfelt prayers flow toward Indra's presence. 
            Your mere presence terminates the restlessness of our minds, allowing us to experience and worship your divine existence with focus. 
            O Mighty Indra (Vrishabham), you are the bedrock of our sacrifice and the supremely radiant deity who energizes our entire life. 
            As a calf receives vital nourishment from its mother, we receive spiritual peace and material plenty through your divine favor. 
            There is no limit to your generosity; you bestow upon your surrendered devotee everything necessary for their holistic development. 
            We strive to please you with our sweet and truthful voices so that you may bring a definitive end to all the sufferings of our life. 
            A seeker who takes refuge in Lord Indra never remains empty; they are blessed with the light of knowledge and vast abundance. 
            O King of Gods, infuse our hearts with exclusive devotion and keep us forever protected and happy under your divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 65,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ६५ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों और ऋषियों द्वारा स्तुतियों के माध्यम से संवर्धित और प्रदीप्त किए जाने वाले अत्यंत महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह शक्ति, अन्न और विजय (वाजां) लेकर आने की कृपा करें जो हमारे जीवन को उन्नत बना सके। 
            आप हमारे लिए एक कल्याणकारी (शिवः) और अत्यंत आत्मीय मित्र (सखा) बनकर हमारे जीवन की इस दुर्गम यात्रा को सुगम बनाएं। 
            आपकी मित्रता संसार के सभी अस्थायी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त को नहीं त्यागते। 
            हे देव, हमें वह आत्मबल और साहस प्रदान करें जिससे हम जीवन के संघर्षों में विजयी होकर समाज में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव न हो। 
            जब आप हमारे सखा बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक या भौतिक मार्ग में रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम को ईश्वरीय फल और सफलता में बदलने वाले देव हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह और चेतना बनकर बहती है, जो हमें सदैव श्रेष्ठ और परोपकारी कर्म करने के लिए प्रेरित करती है। 
            हे इन्द्र, आप हमारे रक्षक और मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, ज्ञानी, यशस्वी और धर्मनिष्ठ बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the great deity who is increased and glorified through the powerful hymns chanted by men and ancient sages. 
            Graciously bring to us very quickly that power, nourishment, and the spoils of victory (Vajan) which will elevate our lives. 
            Become a benevolent (Shivah) and highly intimate friend (Sakha) to us, making this difficult journey of life easy and successful. 
            Your friendship is superior to all temporary worldly relationships because you never abandon your devotee in times of great distress. 
            O God, provide us with the inner strength and courage required to emerge victorious and attain a position of honor in society. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources or peace in our households. 
            When you become our companion, no major obstacle of the world can ever block our spiritual or material progress and evolution. 
            We worship you with deep devotion, for it is you who transforms our hard labor and efforts into divine and successful results. 
            Your energy flows through our being as enthusiasm and consciousness, perpetually inspiring us to perform noble and altruistic deeds. 
            O Indra, stay with us as our protector and guide, graciously making us magnificent, knowledgeable, successful, and renowned.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 66,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ६६ ॥",
        hindiCommentary = """
            हे वृत्रहन् (अज्ञान और अंधकार का नाश करने वाले) इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में कृपापूर्वक अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन में सहायक और रक्षक बनकर आएं। 
            आपकी उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता प्रदान करती है जिससे हम जीवन की किसी भी विषम परिस्थिति में कभी नहीं डगमगाते। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति, नकारात्मकता या बाधा से तनिक भी भयभीत होने की आवश्यकता नहीं। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का अंत कर हमारे मन में ज्ञान की निर्मल गंगा प्रवाहित करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा घेरा बनाती हैं जिसमें कोई भी बुराई या विकार कभी प्रवेश नहीं कर सकता। 
            हम अपनी विनम्र और हृदयस्पर्शी प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के अंधकार को अपनी दिव्य ज्योति से सदा के लिए मिटा दें। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें आध्यात्मिक एवं भौतिक उन्नति के पथ पर ले चलती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता और वैभव के साथ हमारे घर और हृदय में विराजें और हमें अपने मंगलकारी और दिव्य आशीषों से कृतार्थ करें। 
            आपकी कृपा दृष्टि से हमारा संपूर्ण कल्याण और मंगल सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the slayer of Vritra (the darkness of ignorance), please do come graciously to our sacrificial ground and take our side. 
            Arrive in our lives as a helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your sacred presence provides our resolutions with that steel-like firmness needed to remain unshaken in any difficult life situation. 
            When you are with us, there is absolutely no need for us to fear any demonic force, negativity, or obstacle that the world presents. 
            O King of Gods, graciously destroy the Vritra of ignorance within our hearts and let the pure river of knowledge flow within our minds. 
            Your protective energies build such an impenetrable shield around us that no form of evil or impurity can ever find its way inside. 
            We invoke you with our humble and heartfelt supplications so that you may erase the darkness of our existence with your divine light forever. 
            You are the supreme power that makes our hard work meaningful and carries us forward on the path of spiritual and material evolution. 
            O Indra, reside in our homes and hearts with your infinite generosity and splendor, and bless us with your most auspicious and divine favors. 
            Our complete well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 67,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ६७ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि (प्रमतिः), आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म और स्थूल देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' (परम सुख और आत्मिक शांति) मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
            आपकी विलक्षण बुद्धिमत्ता हमें जीवन के कठिन और जटिल निर्णयों में सही दिशा दिखाती है और हमें अज्ञान के भ्रामक जाल से बाहर निकालती है। 
            हे देवराज, हमारे प्रति आपके वात्सल्य और स्नेह की कोई सीमा नहीं है, और हम एक समर्पित संतान के रूप में आपकी पावन वंदना करते हैं। 
            आपकी असीम कृपा से ही हमें वह मानसिक शांति प्राप्त होती है जो संसार की किसी भी नश्वर और भौतिक वस्तु में अत्यंत दुर्लभ और अप्राप्य है। 
            हम अपनी संपूर्ण श्रद्धा, प्रेम और विश्वास आपके चरणों में अर्पित करते हैं ताकि आप हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित रखें। 
            हे इन्द्र, आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता लाएं और हमें यशस्वी बनाने के साथ-साथ आत्मज्ञान के प्रकाश से भी आलोकित करें। 
            आपकी यह तेजस्वी धारा हमारे भीतर के अज्ञान को समूल नष्ट कर हमें परम सत्य और परमात्मा के साक्षात्कार की ओर सफलतापूर्वक ले जाए।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are established as our superior intellect (Pramatih), our supreme Father, and our most affectionate Mother. 
            You have manifested in our lives as the foundation of our entire existence and our sole well-wisher, continuously nurturing us. 
            Just as parents protect and nourish their innocent child from all kinds of dangers, you take care of our subtle and physical needs. 
            We seek from you that 'Sumnam' (supreme bliss and spiritual peace) which is only granted to true and sincere devotees seeking refuge. 
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the illusory web of ignorance. 
            O King of Gods, there is no limit to your maternal affection and love for us, and we worship you with the heart of a dedicated child. 
            By your boundless grace alone do we find the mental tranquility that is extremely rare and unattainable in any perishable worldly object. 
            We offer our complete faith, love, and trust at your divine feet so that you may forever keep us fully safe within your protective shadow. 
            O Indra, bring abundance into every field of our existence and make us successful while illuminating us with the light of Self-realization. 
            May your radiant stream completely destroy the root of our ignorance and successfully lead us to the realization of the Supreme Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 68,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ६८ ॥",
        hindiCommentary = """
            हे श्रेष्ठ मार्ग दिखाने वाले इन्द्र! आप इस पवित्र सोमरस का पान करें जो आपको अत्यंत हर्ष, आनंद और नवीन ऊर्जा प्रदान करने वाला है। 
            आपका यह आनंद समस्त प्रजाओं को तृप्त करने वाला है और आप स्वयं असीम शक्ति के पुंज (वृषा) के रूप में इस ब्रह्मांड में प्रतिष्ठित हैं। 
            हम इस विशेष यज्ञीय अनुष्ठान (सवन) में आपको प्रसन्न करने के लिए अपनी स्तुतियों और श्रद्धा के साथ आपकी अनन्य सेवा करते हैं। 
            आपकी दिव्य ऊर्जा से ही यह संपूर्ण जगत और इसकी गतियाँ संचालित होती हैं, और सोम का पान कर आप और अधिक प्रदीप्त और तेजस्वी हो जाते हैं। 
            हे देवराज, हमारे इस अनुष्ठान को अपनी पावन उपस्थिति से पवित्र करें और हमें वह आंतरिक बल दें कि हम सदैव धर्म की रक्षा कर सकें। 
            जैसे वर्षा की बूंदों से प्यासी धरती तृप्त होती है, वैसे ही आपकी कृपा से हमारे जीवन के समस्त अभाव, दुख और कष्ट सदा के लिए दूर हो जाते हैं। 
            हम अत्यंत श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमारे जीवन को सुख, अखंड शांति और भौतिक समृद्धि से परिपूर्ण कर दें। 
            आपकी यह दिव्य और अजेय शक्ति हमें संशय के अंधकार से बाहर निकालती है और हमें सत्यनिष्ठा तथा दृढ़ चरित्र की अद्भुत शक्ति प्रदान करती है। 
            हे इन्द्र, आप हमारे सबसे निकट के आत्मीय संबंधी बनकर हमें वह दिव्य सुख दें जो संसार की क्षणभंगुर और नश्वर वस्तुओं में सर्वथा दुर्लभ है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा हृदय सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम ईश्वर के समीप रहें।
        """.trimIndent(),
        englishCommentary = """
            O Indra, the leader on the most excellent path, please drink this holy Soma which grants you immense joy, exhilaration, and new energy. 
            Your bliss is that which satisfies and nourishes all living beings, and you are established in this universe as the source of infinite power. 
            In this special sacrificial session (Savana), we offer our exclusive service with hymns and deep faith to please and glorify your divinity. 
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
        id = 69,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ६९ ॥",
        hindiCommentary = """
            हे दिव्य शक्तियों के ज्ञाता भक्तों! मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त प्रजाओं (चर्षणीनां) के परम स्वामी और बलवानों में भी सर्वश्रेष्ठ वीर हैं। 
            वे अनेक महान यज्ञों और अत्यंत प्राचीन स्तुतियों (पुरूणाम्) के एकमात्र अधिकारी हैं, और उनकी शक्ति की सीमा का पार पाना किसी के लिए संभव नहीं। 
            इन्द्र ही वह सर्वोच्च सत्ता हैं जो ब्रह्मांड के न्याय, अनुशासन और संतुलन को बनाए रखने के लिए अपनी प्रचंड और अजेय शक्ति का प्रयोग करते हैं। 
            उनकी महिमा का भक्तिपूर्वक गान करने से मनुष्य के भीतर के सोए हुए साहस, वीरता और ओज का जागरण होता है, जिससे वह जीवन में विजयी बनता है। 
            हे देव, आप हमारे जीवन के प्रत्येक अंधकारमय पक्ष को दूर कर हमें वह तेज प्रदान करें जिससे हम समाज और राष्ट्र में गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा से हमें वह ऐश्वर्य और धन प्राप्त हो जो पूर्णतः सत्य के मार्ग पर चलकर अर्जित किया गया हो और जो समस्त मानवता के लिए कल्याणकारी हो। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर हमें ईश्वर के वास्तविक सान्निध्य और आत्मिक शांति का अनुभव कराते हैं। 
            आप ही वह पराशक्ति हैं जो हमारे द्वारा किए गए कठिन परिश्रम को ईश्वरीय फल में और हमारी आर्त प्रार्थनाओं को दिव्य आशीर्वाद में बदलती हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल या असहाय नहीं रहता, क्योंकि उसे आत्मज्ञान की प्रखरता और भौतिक संपन्नता दोनों का वरदान मिलता है। 
            हे इन्द्र, आप हमारे रक्षक और शाश्वत मार्गदर्शक के रूप में सदैव हमारे साथ रहकर हमें महान, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O devotees who know the divine powers, I praise Lord Indra, the supreme master of all subjects (Charshani) and the foremost among the strong. 
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
        id = 70,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ७० ॥",
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
            O God, riding upon your radiant horses that are as swift as the wind, come into the difficult struggles of our life and destroy all our enemies. 
            Grant us that unshakable devotion and focus which enables us to experience your vast and omnipresent existence within us and remain calm. 
            By your grace, remove every lack from our lives and grant us the divine power and inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow inwardly. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts, fears, and sorrows, making us bold. 
            O Indra, you are our supreme Lord, Protector, and Teacher; lead us out of the darkness of ignorance toward the light of Self-realization and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 71,
        sanskrit = "यो राजा चर्षणीनां इन्द्रो नाम विश्रुततः ।\nतद्वः सुम्नमीमहे ॥ ७१ ॥",
        hindiCommentary = """
            जिन इन्द्रदेव का नाम इस संपूर्ण सृष्टि में अत्यंत प्रसिद्ध (विश्रुततः) है और जो समस्त प्रजाओं के न्यायप्रिय राजा के रूप में जाने जाते हैं। 
            हम उन महान देव से वह सुख और आत्मिक शांति (सुम्नम्) मांगते हैं जो हमारे जीवन को सार्थक, आनंदमयी और भयमुक्त बना दे। 
            इन्द्र का राजा होना इस बात का प्रतीक है कि ब्रह्मांड की व्यवस्था एक परम चेतना द्वारा अत्यंत कुशलता और अनुशासन के साथ संचालित है। 
            उनकी प्रसिद्धि केवल उनकी शक्ति के कारण नहीं, बल्कि उनके द्वारा किए गए धर्म की रक्षा और अधर्म के नाश के कारण है। 
            हे देवराज, आप हमारे जीवन के प्रत्येक क्षेत्र में अपना शासन स्थापित करें ताकि हमारे विचार और कर्म सदैव आपकी मर्यादा में रहें। 
            आपकी कृपा से ही हमें वह मानसिक बल प्राप्त होता है जिससे हम अपनी भीतरी अराजकता और विकारों पर पूर्ण विजय पा सकते हैं। 
            हमें वह शांति प्रदान करें जो केवल आपके दिव्य सान्निध्य में ही संभव है और जो संसार की किसी भी वस्तु से नहीं मिल सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी न्यायपूर्ण दृष्टि हमें सदैव उन्नति और समृद्धि के मार्ग पर अग्रसर करती रहे। 
            इन्द्रदेव की शरण में आने वाला प्रत्येक प्राणी सुरक्षा और सुख का अनुभव करता है, क्योंकि वे ही ऋत (ब्रह्मांडीय कानून) के सर्वोच्च प्रहरी हैं। 
            हे इन्द्र, आप हमारे रक्षक और स्वामी बनकर हमें अज्ञान के गर्त से बाहर निकालें और हमें दिव्यता के सर्वोच्च प्रकाश की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            Lord Indra, whose name is world-renowned (Vishrutatah) across the entire creation and who is known as the just King of all subjects. 
            We seek from that great deity that happiness and spiritual peace (Sumnam) which makes our life meaningful, blissful, and fearless. 
            Indra being the King symbolizes that the universe's order is governed by a supreme consciousness with extreme skill and discipline. 
            His fame is not just due to his immense power, but because of his dedicated protection of Dharma and the destruction of unrighteousness. 
            O King of Gods, establish your sovereign rule in every area of our lives so that our thoughts and deeds always stay within your divine bounds. 
            It is only through your grace that we receive the mental strength required to gain total victory over our inner chaos and personal flaws. 
            Grant us that peace which is only possible in your divine proximity and which cannot be obtained from any material object in the world. 
            We worship you with devotion so that your just gaze continuously steers us toward the path of progress, evolution, and prosperity. 
            Every being that takes refuge in Lord Indra experiences deep security and joy, for he is the supreme sentinel of the Cosmic Order (Rta). 
            O Indra, stay with us as our protector and Lord; pull us out of the pit of ignorance and lead us toward the highest light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 72,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ७२ ॥",
        hindiCommentary = """
            हे शक्ति के अक्षय पुंज इन्द्रदेव! आप हमारी स्तुतियों और प्रार्थनाओं से प्रसन्न होकर हमारे प्रति दयालु भाव रखते हुए यहाँ पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों (महीभिः ऊतिभिः) के साथ हमारे जीवन के संघर्षों में सहायक और रक्षक बनकर आएं। 
            आपकी दिव्य उपस्थिति हमारे भीतर के सुप्त आत्मविश्वास को जागृत करती है और हमें बड़ी से बड़ी विपदाओं से लड़ने का साहस प्रदान करती है। 
            जब आप हमारे पक्ष में खड़े होते हैं, तो संसार की कोई भी नकारात्मक शक्ति या मानसिक विकार हमें पराजित करने का साहस नहीं कर सकता। 
            हे देवराज, आप हमारे अज्ञान रूपी अंधकार को अपनी प्रखर ज्योति से मिटाकर हमारे जीवन में ज्ञान और विवेक का प्रकाश फैलाएं। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा सुरक्षा दुर्ग बनाती हैं जिसमें केवल सुख, शांति और पवित्रता का ही निरंतर वास होता है। 
            हम अपनी विनम्र और आर्त पुकार से आपको पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी अनंत उदारता से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे इन्द्र, आप अपनी दिव्य महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी अजेय सुरक्षा की शीतल छाया में रखें। 
            आपकी कृपा दृष्टि से हमारा परम कल्याण और मंगल सुनिश्चित है, हम आपकी इस भव्य शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, the fountain of inexhaustible energy, being pleased by our hymns and prayers, please come here with a kind intent. 
            Arrive in our lives as a helper and guardian along with your grand and immensely vast protective powers and divine assistances. 
            Your divine presence awakens the dormant self-confidence within us and grants us the courage required to battle the greatest of life's calamities. 
            When you stand on our side, no negative force or mental affliction in the world can ever dare to defeat or disturb our inner peace. 
            O King of Gods, erase the darkness of our ignorance with your intense light and spread the radiance of wisdom and discernment in our lives. 
            Your protective energies build such an impenetrable fortress of security around us, within which only happiness, peace, and purity reside. 
            We invoke you with our humble and desperate cries so that you may fulfill every single scarcity of our existence with your infinite generosity. 
            You are the supreme authority that makes our hard work meaningful and continuously drives us forward on the path of evolution and growth. 
            O Indra, reside in our homes and hearts with your divine glory and keep us forever safe under the cool shadow of your invincible protection. 
            Our ultimate well-being and auspiciousness are guaranteed under your merciful gaze; we repeatedly bow before your magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 73,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ७३ ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो पवित्र सोमरस का पान कर अत्यंत आनंदित होते हैं। 
            वे हमें ऐश्वर्य और दिव्य धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महिमा भक्तों की श्रद्धापूर्ण वाणी से निरंतर बढ़ती रहती है। 
            जैसे माताएं और गौएँ अपने प्रिय बछड़े की ओर वात्सल्य भाव से दौड़ती हैं, वैसे ही हमारी स्तुतियां और हृदय की पुकार इन्द्र की ओर प्रवाहित होती हैं। 
            आपकी दिव्य उपस्थिति मात्र से हमारे मन की चंचलता और अशांति समाप्त होती है और हम एकाग्र होकर आपकी असीम सत्ता का साक्षात् अनुभव करते हैं। 
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
        id = 74,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ७४ ॥",
        hindiCommentary = """
            हे इन्द्रदेव! आप मनुष्यों और ऋषियों द्वारा अपनी पवित्र स्तुतियों के माध्यम से संवर्धित और प्रदीप्त किए जाने वाले अत्यंत महान देव हैं। 
            आप हमारे लिए शीघ्र ही वह आंतरिक शक्ति, प्रचुर अन्न और विजय लेकर आने की कृपा करें जो हमारे जीवन को हर दृष्टि से उन्नत बना सके। 
            आप हमारे लिए एक कल्याणकारी और अत्यंत आत्मीय मित्र बनकर हमारे जीवन की इस दुर्गम और चुनौतीपूर्ण यात्रा को सुगम और सफल बनाएं। 
            आपकी यह दिव्य मित्रता संसार के सभी अस्थायी संबंधों से श्रेष्ठ है क्योंकि आप विपत्ति के समय कभी भी अपने भक्त का साथ नहीं छोड़ते। 
            हे देव, हमें वह आत्मबल और साहस प्रदान करें जिससे हम जीवन के कठिन संघर्षों में विजयी होकर समाज में एक गौरवपूर्ण स्थान प्राप्त कर सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे ताकि हमारे घरों और परिवारों में संसाधनों और सुख-शांति का कभी भी लेशमात्र भी अभाव न होने पाए। 
            जब आप हमारे सखा और मार्गदर्शक बनते हैं, तब संसार की कोई भी बड़ी बाधा हमारे आध्यात्मिक या भौतिक मार्ग में रुकावट नहीं बन सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे कठिन परिश्रम और पुरुषार्थ को ईश्वरीय फल और महान सफलता में बदलने वाले देव हैं। 
            आपकी ऊर्जा हमारे प्राणों में उत्साह, आशा और चेतना बनकर बहती है, जो हमें सदैव श्रेष्ठ, पवित्र और परोपकारी कर्म करने के लिए निरंतर प्रेरित करती है। 
            हे इन्द्र, आप हमारे परम रक्षक और गुरु के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, ज्ञानी, यशस्वी और धर्मनिष्ठ बनाने की असीम कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Lord Indra, you are the magnificent deity who is increased and glorified through the powerful sacred hymns chanted by men and ancient sages. 
            Graciously bring to us very quickly that inner power, abundant nourishment, and the spoils of victory which will elevate our lives in every aspect. 
            Become a benevolent and highly intimate friend to us, making this difficult and challenging journey of life smooth, easy, and successful. 
            Your divine friendship is superior to all temporary worldly relationships because you never abandon your devotee in times of great distress. 
            O God, provide us with the inner strength and courage required to emerge victorious in life's struggles and attain a dignified position in society. 
            May your merciful gaze remain upon us so that there is never even a trace of shortage of resources or peace within our homes and families. 
            When you become our companion and guide, no major obstacle of the world can ever block our spiritual or material progress and evolution. 
            We worship you with deep devotion, for it is you who transforms our hard labor and efforts into divine results and magnificent successes. 
            Your energy flows through our being as enthusiasm, hope, and consciousness, perpetually inspiring us to perform noble, holy, and altruistic deeds. 
            O Indra, stay with us as our supreme protector and teacher, graciously making us magnificent, knowledgeable, successful, and devoted to Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 75,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ७५ ॥",
        hindiCommentary = """
            हे वृत्रहन् इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में अपनी असीम दया और कृपा के साथ अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ हमारे जीवन के प्रत्येक संघर्ष में एक सजग सहायक और रक्षक बनकर आएं। 
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
            O Indra, the slayer of Vritra, please do come graciously to our sacrificial ground and take our side with your boundless mercy. 
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
        id = 76,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ ७६ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप ही हमारी श्रेष्ठ बुद्धि और विवेक हैं, आप ही हमारे परम पिता और आप ही हमारी स्नेहमयी माता के रूप में प्रतिष्ठित हैं। 
            आप ही हमारे संपूर्ण अस्तित्व के आधार और एकमात्र सच्चे हितैषी बनकर हमारे जीवन में प्रकट हुए हैं और निरंतर हमारा लालन-पालन और पोषण कर रहे हैं। 
            जैसे माता-पिता अपने अबोध बालक की हर प्रकार के ज्ञात और अज्ञात संकटों से रक्षा और पोषण करते हैं, वैसे ही आप हमारी सूक्ष्म और स्थूल देखभाल करते हैं। 
            हम आपसे वह 'सुम्नम्' मांगते हैं जो केवल आपकी शरण में आने वाले सच्चे और निष्कपट भक्तों को ही प्राप्त होता है। 
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
            We seek from you that 'Sumnam' which is only granted to true and sincere devotees seeking your holy refuge and protection. 
            Your extraordinary intelligence shows us the right direction during life's complex decisions and pulls us out of the illusory web of ignorance. 
            O King of Gods, there is no limit to your maternal affection and love for us, and we worship you with the simple heart of a dedicated child. 
            By your boundless grace alone do we find the mental tranquility and stability that is extremely rare and unattainable in any perishable worldly object. 
            We offer our complete faith, love, and unwavering trust at your divine feet so that you may forever keep us fully safe and happy within your shadow. 
            O Indra, bring abundance into every field of our existence and make us successful while illuminating us with the light of Self-realization. 
            May your radiant stream completely destroy the root of our ignorance and successfully lead us to the realization of the Supreme Truth and God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 77,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ ७७ ॥",
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
        id = 78,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ७८ ॥",
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
        id = 79,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ७९ ॥",
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
        id = 80,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ८० ॥",
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
        id = 81,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ ८१ ॥",
        hindiCommentary = """
            मैं उन इन्द्रदेव की स्तुति करता हूँ जो समस्त मानव जातियों (चर्षणीनां) के परम रक्षक और बलशालियों में भी सर्वश्रेष्ठ वृषभ (शक्तिशाली) के समान हैं। 
            वे अनेक यज्ञों और स्तुतियों के अधिपति हैं, जिनकी शक्ति का गान प्राचीन काल से ऋषि-मुनि करते आ रहे हैं। 
            इन्द्र का 'वृषभ' स्वरूप यह दर्शाता है कि वे भक्तों पर कृपा और सामर्थ्य की वर्षा करने वाले उदार देव हैं। 
            उनकी शक्ति केवल युद्धों तक सीमित नहीं है, बल्कि वे हमारे जीवन के प्रत्येक क्षेत्र में अनुशासन और संतुलन बनाए रखते हैं। 
            जब हम उनकी वंदना करते हैं, तो हमारे भीतर के सुप्त साहस और ओज का पुनर्जागरण होता है, जिससे हम चुनौतियों का सामना कर पाते हैं। 
            वे प्रजाओं के वास्तविक राजा हैं, जिनकी आज्ञा से यह संपूर्ण चराचर जगत व्यवस्थित रूप से संचालित होता है। 
            आपकी कृपा से हमें वह ऐश्वर्य प्राप्त हो जो सत्य और न्याय के मार्ग पर चलकर अर्जित किया गया हो। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आपकी न्यायपूर्ण दृष्टि हमें सदैव उन्नति के मार्ग पर अग्रसर रखे। 
            आप ही वह शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों और भौतिक प्रचुरता में बदलने का सामर्थ्य रखती हैं। 
            हे इन्द्र, आप हमारे रक्षक और स्वामी बनकर हमें अज्ञान के अंधकार से निकालकर दिव्यता के प्रकाश की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            I praise Lord Indra, who is the sovereign protector of all human races (Charshani) and stands as the foremost among the mighty, like a powerful bull (Vrishabha). 
            He is the lord of numerous sacrifices and hymns, whose prowess has been sung by ancient seers and sages since time immemorial. 
            The 'Vrishabha' aspect of Indra symbolizes his role as the generous bestower who showers grace, strength, and abundance upon his devotees. 
            His power is not confined to physical battles alone; he maintains discipline and cosmic balance across all spheres of existence. 
            By worshipping him, we awaken our dormant courage and vigor, enabling us to face the various challenges of life with steadfastness. 
            He is the true King of all beings, under whose command the entire moving and non-moving universe functions in an orderly manner. 
            Through your grace, may we receive that prosperity which is earned through the path of truth and righteousness. 
            We bow before you with devotion so that your just gaze continuously steers us toward the path of progress and spiritual evolution. 
            You are the ultimate power that possesses the capability to transform our subtle intentions into cosmic achievements and material plenty. 
            O Indra, stay with us as our protector and Lord; lead us out of the darkness of ignorance toward the highest light of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 82,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ ८२ ॥",
        hindiCommentary = """
            हे मित्रों! आप उन इन्द्रदेव के लिए आनंददायक (मादनं) गीतों का गान करें जो सुनहरे घोड़ों (हर्यश्वाय) के स्वामी और सोम के पानकर्ता हैं। 
            आपकी मधुर वाणी से निकले हुए ये पवित्र भजन इन्द्र को प्रसन्न करते हैं और उन्हें हमारे इस यज्ञीय अनुष्ठान में पधारने के लिए आमंत्रित करते हैं। 
            इन्द्रदेव की अजेय शक्ति का रहस्य सोम के श्रद्धापूर्ण पान और भक्तों की निष्कपट पुकार में छिपा है, जो उन्हें अजेय बनाता है। 
            जब हम सामूहिक रूप से उनकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक और दिव्य वातावरण का निर्माण स्वतः होने लगता है। 
            हे देव, आप अपने तेजस्वी घोड़ों पर सवार होकर हमारे जीवन के कठिन संघर्षों में आएं और हमारे समस्त शत्रुओं का संहार करें। 
            हमें वह अटूट भक्ति प्रदान करें जिससे हम आपकी विराट सत्ता का अनुभव अपने भीतर कर सकें और सदैव मानसिक रूप से शांत रहें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव को दूर कर हमें पूर्णता, अखंड सौभाग्य और आध्यात्मिक श्रेष्ठता प्राप्त करने की प्रेरणा मिले। 
            हम श्रद्धापूर्वक आपकी आराधना करते हैं ताकि हमारा जीवन सदैव लोक-कल्याण, परोपकार और सत्य की सेवा में लगा रहे। 
            इन्द्रदेव की पवित्र मित्रता हमारे लिए वह अभेद्य सुरक्षा कवच है जो हमारे समस्त संशयों और भयों को जड़ से समाप्त कर देती है। 
            हे इन्द्र, आप हमारे परम स्वामी और रक्षक हैं; हमें अज्ञान के अंधकार से निकालकर आत्मज्ञान के परम प्रकाश की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O friends and seekers, sing exhilarating (Madanam) songs for Lord Indra, who is the master of bay horses (Haryashva) and the drinker of Soma. 
            These sacred hymns arising from your sweet voices delight Indra and invite him to manifest personally within our sacrificial ritual today. 
            The secret of Indra's invincible might lies in the devoted consumption of Soma and the sincere calls of his devotees, making him unsurpassed. 
            When we collectively sing his glories, an extremely positive, energetic, and divine atmosphere begins to manifest around us automatically. 
            O God, riding upon your radiant horses, come into the difficult struggles of our life and destroy all our internal and external enemies. 
            Grant us that unshakable devotion which enables us to experience your vast and omnipresent existence within us and remain mentally calm. 
            By your grace, remove every lack from our lives and grant us the divine inspiration to attain completeness and spiritual excellence. 
            We worship you with devotion so that our life remains dedicated to public welfare, altruism, and the service of Truth, helping us grow. 
            The holy friendship of Lord Indra is that impenetrable shield for us which completely uproots all our doubts and deep-seated fears. 
            O Indra, you are our supreme Lord and Protector; lead us out of the darkness of ignorance toward the radiant light of Self-realization.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 83,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ८३ ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और पूरे संसार में प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और पूर्णतः समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल सारथी हैं, जो हमें संसार की समस्त बाधाओं के बीच से कुशलतापूर्वक निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम शिखर तक पहुँचाने की कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक और परम मित्र बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और शाश्वत कीर्ति का मार्ग दिखाए। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और सुखी बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            All the hymns and prayers continuously increase and illuminate the glory of Lord Indra, who is as vast as the ocean. 
            He is the foremost among divine charioteers and the Lord of all victories, worthy of being praised and glorified with deep devotion. 
            The expanse of Indra's presence is infinite like the sky and the sea, within which all cosmic powers are safely contained. 
            He is the most skillful charioteer of our life's vessel, guiding us expertly and safely through the various obstacles of the world. 
            O God, with your fierce power and immense wisdom, graciously lead our every effort to the absolute peak of success and excellence. 
            Bestow upon us both spiritual and material power so that we can assist the weak and keep the flag of righteousness flying high. 
            The continuous singing of your glories completely purifies our inner self and initiates our constant spiritual awakening and divine awareness. 
            A seeker who takes refuge in Lord Indra is never defeated, for the hero of the entire universe becomes their personal helper and friend. 
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 84,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ ८४ ॥",
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
        id = 85,
        sanskrit = "तमिन्द्रं वाजयामसि महे वृत्राय हन्तवे ।\nस वृषा वृषभो बभूविथ ॥ ८५ ॥",
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
        id = 86,
        sanskrit = "इन्द्राय मधुमत्तमं सोमं पवस्व धारया ।\nशविष्ठाय मत्सराः ॥ ८६ ॥",
        hindiCommentary = """
            हे सोमरस! आप अत्यंत मधुर और आनंददायक होकर अपनी पावन धारा के साथ सबसे बलवान और तेजस्वी इन्द्र की ओर निरंतर प्रवाहित हों। 
            यह सोम ही इन्द्रदेव का मुख्य आहार है, जिसे पीकर वे संपूर्ण ब्रह्मांड की रक्षा के लिए अपनी अजेय शक्ति प्राप्त करते हैं और आनंदित होते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण के समस्त विकारों को धोकर हमें दिव्यता, शांति और साक्षात् ईश्वर के सान्निध्य का अनुभव कराए। 
            जैसे सोम यज्ञ की अग्नि में अर्पित होकर देव-लोक तक पहुँचता है, वैसे ही हमारे पवित्र संकल्प भी आपकी शक्ति से परम पद को प्राप्त करें। 
            हे देव, आप ही वह दिव्य माध्यम हैं जो हमारे प्रार्थनाओं को देवताओं के समूह तक सुरक्षित और शीघ्रता से पहुँचाने का कार्य करते हैं। 
            आपकी कृपा से हमारे जीवन के समस्त अमंगल और दुख दूर हों और हमें शाश्वत दैवीय सुख की वास्तविक अनुभूति प्राप्त हो सके। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आपके बिना कोई भी महान यज्ञ या आध्यात्मिक अनुष्ठान अपनी पूर्णता को प्राप्त नहीं कर सकता। 
            आपकी यह तेजस्वी और मधुर धारा हमारे भीतर के अज्ञान को जलाकर हमें सत्य के साक्षात्कार की ओर ले जाने का मार्ग प्रशस्त करे। 
            हे इन्द्र, आप इस मधुर रस का पान कर अत्यंत प्रसन्न हों और हमारे घरों को सुख, संपन्नता और शांति से भर देने की महान कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, being most sweet and exhilarating, flow in a sacred stream toward the most powerful and radiant Lord Indra. 
            This Soma is the primary nourishment of Indra, by consuming which he gains invincible strength to protect the entire cosmos and rejoices. 
            May this holy stream wash away all the stains and impurities of our inner self, filling us with divinity, peace, and the presence of God. 
            Just as Soma offered in fire reaches the celestial realms, let our spiritual resolutions reach the supreme state through your power. 
            O God, you are the essential medium who carries our humble prayers and emotions safely and swiftly to the assembly of the divine gods. 
            By your grace, let all the inauspiciousness and sorrows of our lives be removed, granting us the experience of eternal bliss. 
            We worship you with deep devotion because no great sacrifice or spiritual ritual can reach its completion without your presence. 
            May your radiant and sweet stream burn away the darkness of our ignorance and pave the way for us to realize the Truth. 
            O Indra, rejoice greatly by consuming this nectar and graciously fill our homes and hearts with happiness, prosperity, and enduring peace. 
            We offer our entire faith at your feet so that our lives remain meaningful, nourished, and filled with the Divine Presence in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 87,
        sanskrit = "प्र मंहिष्ठाय गायत ऋतावानं विचेतसम् ।\nइन्द्रं विश्वा अवीवृधन् ॥ ८७ ॥",
        hindiCommentary = """
            आप उन अत्यंत उदार, सत्य के महान रक्षक और विशेष रूप से ज्ञानी इन्द्रदेव के लिए भक्तिपूर्वक गान और वंदना करें। 
            समस्त ब्रह्मांडीय शक्तियों और भक्तों की निष्कपट वाणियों ने इन्द्र की महिमा को निरंतर बढ़ाया है और उन्हें सर्वोच्च पद पर प्रतिष्ठित किया है। 
            इन्द्र ही वह चेतना हैं जो सत्य के मार्ग पर चलने वाले साधकों का मार्गदर्शन करती है और उन्हें अज्ञान के बंधनों से पूर्णतः मुक्त कराती है। 
            उनकी उदारता की कोई सीमा नहीं है; वे अपने शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके कल्याण के लिए अनिवार्य है। 
            हे देव, आप अपनी प्रखर बुद्धि से हमारे समस्त संशयों का नाश कर हमें वह स्पष्ट दृष्टि दें जिससे हम जीवन के रहस्यों को जान सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे मन की मलीनता दूर होती है और हम ईश्वर के अनंत प्रेम और शांति का अनुभव करने लगते हैं। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे कठिन परिश्रम को ईश्वरीय फल में और हमारी छोटी प्रार्थनाओं को दिव्य आशीषों में बदलने का सामर्थ्य रखती हैं। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, यश और आध्यात्मिक उन्नति लाएं। 
            इन्द्रदेव की पावन उपस्थिति मात्र से ही हमारे अभाव दूर हो जाते हैं और हम अपने भीतर एक अखंड पूर्णता और दिव्य आनंद का अनुभव करते हैं। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहें और हमें दिव्यता के मार्ग पर निरंतर अग्रसर करते रहें।
        """.trimIndent(),
        englishCommentary = """
            Sing devotedly for the most generous, the great guardian of Truth, and the highly wise Lord Indra. 
            All cosmic forces and the sincere voices of his devotees have continuously increased Indra's glory and established him at the supreme state. 
            Indra is that consciousness which guides seekers walking the path of Truth and liberates them completely from the heavy bonds of ignorance. 
            There is no limit to his generosity; he bestows upon his surrendered devotee everything that is mandatory for their ultimate well-being. 
            O God, with your sharp intelligence, destroy our doubts and grant us that clear vision to understand the deep mysteries of existence. 
            The continuous singing of your glories removes the impurities of our minds and allows us to experience the infinite love and peace of the Divine. 
            You are the supreme power that possesses the strength to transform our hard work into divine results and our simple prayers into blessings. 
            We bow before you with devotion so that you bring abundance, fame, and spiritual evolution into every single aspect of our lives. 
            The holy presence of Lord Indra dissolves our scarcities, making us experience a sense of unbroken completeness and divine joy within. 
            O Indra, stay with us forever as our protector and nourisher, and continue to lead us steadily on the radiant path of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 88,
        sanskrit = "यस्य द्विता विधर्तुः साकमस्य सतो वशा ।\nस न इन्द्रः शिवः सखा ॥ ८८ ॥",
        hindiCommentary = """
            जिन इन्द्रदेव की आज्ञा और शासन इस ब्रह्मांड के दोनों लोकों में विधिवत व्याप्त और अत्यंत गौरव के साथ प्रतिष्ठित है। 
            वे ही महान देव हमारे लिए एक कल्याणकारी और अत्यंत आत्मीय मित्र बनकर हमारे जीवन के प्रत्येक सुख-दुख में सदैव उपस्थित रहें। 
            इन्द्र का शासन केवल कठोर दंड पर नहीं, बल्कि न्याय और प्रेम पर आधारित है, जो संपूर्ण चराचर जगत को अनुशासित और संतुलित रखता है। 
            उनकी मित्रता हमें वह अद्भुत संबल प्रदान करती है जिससे हम जीवन के बड़े से बड़े युद्धों को अत्यंत शांति और धैर्य के साथ जीत सकते हैं। 
            हे देवराज, आप हमारे सबसे निकट के हितैषी बनकर हमें वह मार्गदर्शन दें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें। 
            जब आप हमारे सखा बनते हैं, तब संसार की कोई भी नकारात्मक शक्ति या प्रतिकूल परिस्थिति हमें अपने लक्ष्य से विचलित नहीं कर सकती। 
            हम श्रद्धापूर्वक आपकी अर्चना करते हैं ताकि हमारे जीवन में केवल शुभ का उदय हो और हम सदैव आपकी सुरक्षित छाया में निर्भय रहें। 
            आपकी कृपा से ही हमारे परिवारों में एकता, प्रेम और धर्मनिष्ठा का वास होता है, जो हमारे सामाजिक जीवन को सुखमय बनाता है। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के शाश्वत प्रकाश की ओर ले जाने की कृपा करें। 
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा और मंगलकारी आशीष की याचना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            Lord Indra, whose command and governance are duly established and pervasive with glory across both the realms. 
            May that great deity remain forever present in our lives as a benevolent (Shivah) and highly intimate friend (Sakha). 
            Indra's rule is not based on mere harsh punishment but on justice and love, which keeps the entire universe balanced and disciplined. 
            His friendship provides us with that amazing support through which we can win the greatest battles of life with peace and patience. 
            O King of Gods, become our nearest well-wisher and guide us so that we never walk the path of unrighteousness or untruth. 
            When you become our companion, no negative force or adverse worldly situation can ever sway or distract us from our spiritual goal. 
            We worship you with devotion so that only the auspicious arises in our lives and we always remain fearless under your protective shadow. 
            By your grace alone, unity, love, and righteousness reside in our families, making our social life blissful and meaningful. 
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Supreme Truth. 
            We repeatedly bow before your divine and magnificent glory and seek your constant protection and auspicious blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 89,
        sanskrit = "अभित्वा शूर नोनुमो दुग्धा इव धेनवः ।\nईशानमस्य जगतः स्वर्दृशमीशानमिन्द्र तस्थुषः ॥ ८९ ॥",
        hindiCommentary = """
            हे परम वीर इन्द्रदेव! जैसे दुधारू गौएँ अपने बछड़े की ओर अत्यंत प्रेम से रंभाती हुई दौड़ती हैं, वैसे ही हम आपकी स्तुति करते हैं। 
            आप इस संपूर्ण चराचर जगत के स्वामी हैं, जो जड़ और चेतन दोनों पर न्यायपूर्वक शासन करने वाले महान देव हैं। 
            आपकी दृष्टि स्वर्ग तक व्याप्त है, और आप ही समस्त लोकों के वास्तविक नियन्ता और परम रक्षक के रूप में प्रतिष्ठित हैं। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के अंधकार को दूर कर उसे ज्ञान के प्रकाश से भर देने वाले देव हैं। 
            आपकी कृपा से ही हमें वह सामर्थ्य प्राप्त होता है जिससे हम अपनी इंद्रियों और चंचल मन पर पूर्ण नियंत्रण पा सकें। 
            जैसे गौ अपने दूध से संसार का पोषण करती है, वैसे ही आप अपनी कृपा की वर्षा से भक्तों का सर्वांगीण कल्याण करते हैं। 
            आपकी महिमा का गान करने से हमारे भीतर के सोए हुए साहस, वीरता और आत्मविश्वास का पुनर्जागरण होता है। 
            हे देवराज, आप हमारे हृदयों में भक्ति का ऐसा अखंड दीपक जलाएं जो अज्ञान की आँधियों में भी कभी न बुझे। 
            हम श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमें आध्यात्मिक शांति और भौतिक संपन्नता दोनों ही प्रदान करें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल नहीं रहता, उसे ज्ञान और ऐश्वर्य की प्रचुरता प्राप्त होती है। 
            हे अजेय वीर, आप हमारे रक्षक बनकर हमें सदैव धर्म के मार्ग पर दृढ़ रहने की दिव्य शक्ति प्रदान करने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O heroic Lord Indra, just as milch cows low affectionately toward their calves, we continuously chant your praises. 
            You are the sovereign Lord of this entire universe, governing both the moving and the non-moving entities with justice. 
            Your divine vision extends to the highest heavens, and you are established as the true controller and protector of all realms. 
            We worship you because you are the deity who removes the darkness of our lives and fills them with the light of knowledge. 
            It is only through your grace that we receive the strength required to gain mastery over our senses and our wandering mind. 
            Just as a cow nourishes the world with its milk, you nourish your devotees' welfare with the constant showers of your grace. 
            Singing your glories awakens the dormant courage, heroism, and self-confidence within us, enabling us to face life's battles. 
            O King of Gods, ignite such an eternal lamp of devotion in our hearts that it never flickers and always guides our way. 
            We bow before your feet with profound faith so that you may grant us both spiritual peace and material abundance. 
            A seeker who takes refuge in Lord Indra never remains weak; they attain an infinite abundance of wisdom and splendor. 
            O invincible hero, stay as our guardian and graciously provide us with the divine strength to remain firm on the path of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 90,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ ९० ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आपके समान शक्तिशाली और दयालु न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न कोई हुआ है और न होगा। 
            आपकी तुलना किसी भी अन्य सत्ता से नहीं की जा सकती, आप अद्वितीय और सर्वोत्तम शक्तियों के परम स्वामी और रक्षक हैं। 
            हम शक्ति, विजय और प्रचुर संसाधनों (गौओं) की कामना करते हुए आपको अपने यज्ञ में अत्यंत आदर के साथ बुलाते हैं। 
            आप ही वह एकमात्र शक्ति हैं जो हमारे जीवन में श्रेष्ठता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम आपकी शरण में हैं। 
            आपकी दिव्यता समस्त सीमाओं से परे है, और आप ही ऋत (सत्य) के मार्ग के सबसे बड़े संरक्षक और सजग प्रहरी हैं। 
            जब हम आपका हृदय से आह्वान करते हैं, तो हमारे भीतर एक नई ऊर्जा का संचार होता है जो हमें शत्रुओं पर विजय दिलाती है। 
            संसार की कोई भी बाधा आपके अजेय वज्र के सामने टिक नहीं सकती, आप हमारे मार्ग के समस्त कंटकों को दूर करें। 
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और अपने लक्ष्यों में सफल हों। 
            आपकी कृपा दृष्टि से हमारा कल्याण सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार हृदय से वंदना करते हैं। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और अंधकार से शाश्वत प्रकाश की ओर ले चलें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक और मंगलमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, there is none as powerful and merciful as you in the heavens, nor on earth; none has existed, nor will exist. 
            Your greatness is beyond comparison; you are the unique and supreme master and guardian of the highest celestial and worldly powers. 
            Desiring strength, victory, and abundant resources, we call upon you in our sacrificial ritual with the utmost respect. 
            You are the only power capable of bringing excellence and plenty into our lives; we seek your divine refuge with total faith. 
            Your divinity transcends all boundaries, and you stand as the greatest protector and alert sentinel of the Cosmic Order (Rta). 
            When we invoke you from our hearts, a new surge of energy flows through us, granting us victory over all our foes and hurdles. 
            No obstacle in this world can withstand your invincible thunderbolt; please remove all the thorns from our path forever. 
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to be successful in our goals. 
            Our well-being is guaranteed under your merciful gaze; we repeatedly bow before your magnificent and invincible power. 
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the Supreme Light and make our lives meaningful. 
            We offer our entire faith at your feet so that our lives remain auspicious and blessed in every possible way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 91,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ९१ ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और संसार में प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और शक्तिशाली सारथी हैं, जो हमें संसार की बाधाओं के बीच से कुशलतापूर्वक निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम शिखर तक पहुँचाने की कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और सच्ची कीर्ति का मार्ग दिखाए। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और सुखी बनाने की कृपा करें।
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
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 92,
        sanskrit = "स नः शुभः शुभंभर इन्द्रो विश्वाभिरूतिभिः ।\nअस्मे धेहि श्रवश्च्यौतम् ॥ ९२ ॥",
        hindiCommentary = """
            हे कल्याणकारी इन्द्रदेव! आप शुभ फल प्रदान करने वाले देव हैं, कृपया अपनी समस्त रक्षात्मक शक्तियों के साथ हमारे जीवन में पधारें। 
            आप हमारे जीवन में वह यश और ऐश्वर्य स्थापित करें जो शत्रुओं और नकारात्मक शक्तियों के प्रभाव को जड़ से समाप्त कर देने वाला हो। 
            आपकी शुभता हमारे घर और मन को पवित्र करती है, जिससे हमारे भीतर सात्विक गुणों का निरंतर और तीव्र विकास होता है। 
            जब आप अपनी महान और अजेय शक्तियों के साथ हमारे सहायक बनते हैं, तो सफलता स्वतः ही हमारे प्रत्येक कार्य का अनुसरण करने लगती है। 
            हे देवराज, आप हमारे अज्ञान रूपी शत्रुओं को नष्ट कर हमें वह कीर्ति प्रदान करें जो सत्य पर आधारित हो और स्थायी बनी रहे। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य कवच बनाती हैं जिसमें कोई भी नकारात्मकता या रोग कभी प्रवेश नहीं कर सकता। 
            हम अपनी प्रार्थनाओं से आपकी उस शक्ति का आह्वान करते हैं जो असंभव को भी संभव बनाने और हमें विपदाओं से उबारने का सामर्थ्य रखती है। 
            आपही वह ऊर्जा हैं जो हमारे शिथिल पड़ते संकल्पों में नवीन प्राण और उत्साह फूंकती हैं और हमें जीवन के प्रत्येक क्षेत्र में विजयी बनाती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता के साथ हमारे यज्ञ को सिद्ध करें और हमें आध्यात्मिक उन्नति के मार्ग की ओर ले चलें। 
            आपकी कृपा दृष्टि से हमारा भविष्य सुरक्षित और उज्ज्वल है, हम आपकी अजेय और भव्य शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O auspicious Lord Indra, you are the bringer of good fortune; please manifest in our lives with all your protective and divine powers. 
            Establish within us that fame and prosperity which has the strength to completely shatter the influence of negative forces. 
            Your auspiciousness sanctifies our homes and minds, leading to the rapid development of virtuous and celestial qualities within us. 
            When you become our helper with your vast and invincible powers, success and abundance naturally begin to follow our every endeavor. 
            O King of Gods, destroy the internal enemies of ignorance and grant us fame that is rooted in Truth and remains permanent. 
            Your protective energies form an impenetrable shield around us, through which no form of negativity, disease, or sorrow can penetrate. 
            Through our prayers, we invoke that power of yours which possesses the capability to make the impossible possible and rescue us from calamities. 
            You are the energy that breathes new life and enthusiasm into our weakening resolutions and empowers us to emerge victorious in every field. 
            O Indra, with your infinite generosity, perfect our sacrifice and lead us toward the path of profound spiritual evolution. 
            Our future is safe and immensely bright under your merciful gaze; we repeatedly bow before your invincible and magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 93,
        sanskrit = "आ तू न इन्द्र क्षुमन्तं चित्रं ग्राभं सं गृभाय ।\nमहाहस्ती दक्षिणेन ॥ ९३ ॥",
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
        id = 94,
        sanskrit = "का त उस्तिः शविष्ठ्य का मतिः का सुवृक्तिः ।\nकदा वसूनि भरसि ॥ ९४ ॥",
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
        id = 95,
        sanskrit = "कुविद्ङ्ग मघवन् कस्यचिद् गिरो ज्रयो वाजस्य गन्त ।\nएवा हि ते मनो विचेतसम् ॥ ९५ ॥",
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
        id = 96,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ९६ ॥",
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
        id = 97,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ९७ ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत और शत्रुओं का दमन करने वाले इन्द्रदेव की स्तुति करें जो सोमरस का पान कर आनंदित होते हैं। 
            वे हमें ऐश्वर्य और धन प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महिमा भक्तों की वाणी से निरंतर बढ़ती रहती है। 
            जैसे माताएं और गौएँ अपने बछड़े की ओर प्रेमपूर्वक दौड़ती हैं, वैसे ही हमारी स्तुतियां और प्रार्थनाएं इन्द्र की ओर बढ़ती हैं। 
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
        id = 98,
        sanskrit = "नृभिरतक्षितो वाजां अभि प्र गाहा मक्षूणी ।\nस सखा शिवो भव ॥ ९८ ॥",
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
        id = 99,
        sanskrit = "आ तू न इन्द्र वृत्रहन् अस्माकं अर्धमा गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ९९ ॥",
        hindiCommentary = """
            हे वृत्रहन् इन्द्र! आप हमारे इस यज्ञीय स्थल और हमारे पक्ष में अपनी असीम कृपा के साथ अवश्य पधारें। 
            आप अपनी महान और अत्यंत विशाल रक्षात्मक शक्तियों के साथ हमारे जीवन के प्रत्येक संघर्ष में सहायक और रक्षक बनकर आएं। 
            आपकी उपस्थिति हमारे संकल्पों को वह फौलादी दृढ़ता प्रदान करती है जिससे हम जीवन की किसी भी विषम परिस्थिति में नहीं डगमगाते। 
            जब आप हमारे साथ होते हैं, तब हमें संसार की किसी भी असुर शक्ति या बाधा से तनिक भी भयभीत होने की आवश्यकता नहीं। 
            हे देवराज, आप हमारे भीतर के अज्ञान रूपी वृत्रासुर का अंत कर हमारे मन में ज्ञान की पवित्र गंगा प्रवाहित करने की कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा घेरा बनाती हैं जिसमें कोई भी बुराई कभी प्रवेश नहीं कर सकती। 
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
        id = 100,
        sanskrit = "त्वं हि नः प्रमतिस्त्वं पिता त्वं माता शतक्रतो बभूविथ ।\nअधा ते सुम्नमीमहे ॥ १०० ॥",
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
        id = 101,
        sanskrit = "तं घेमित्था नमस्विन उप स्वराजमासते ।\nहोत्रभिरिन्द्रं वावृधुः ॥ १०१ ॥",
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
        id = 102,
        sanskrit = "पिबा सोममिन्द्र सुप्रणीते मदो यस्ते चर्षणिप्रा वृषा हि ।\nअधा ते अस्मिनन् सवने विवाससि ॥ १०२ ॥",
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
            Just as the thirsty earth is satisfied by raindrops, all the scarcities and afflictions of our lives vanish forever by your grace. 
            We bow before your feet with profound devotion so that you may fill our lives with happiness, unbroken peace, and material prosperity. 
            Your divine and invincible power pulls us out of the darkness of doubt and grants us the amazing strength of integrity and firm character. 
            O Indra, become our nearest and most intimate relative and bestow upon us that divine bliss which is rare in fleeting worldly things. 
            We constantly sing your glories so that our hearts remain forever illuminated with the light of devotion and knowledge near the Divine.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 103,
        sanskrit = "य इन्द्र चर्षणीनां वृषभा न वृषाणाम् ।\nतद्वः स्तुषे पुरूणाम् ॥ १०३ ॥",
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
        id = 104,
        sanskrit = "प्र व इन्द्राय मादनं हर्यश्वाय गायत ।\nसखायः सोमपाव्ने ॥ १०४ ॥",
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
        id = 105,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ १०५ ॥",
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
        id = 106,
        sanskrit = "एवा ह्यासि वीरयुरेतदस्मासु धेहि ।\nमहाँ हि शतक्रतो ॥ १०६ ॥",
        hindiCommentary = """
            हे शतक्रतो इन्द्र! आप वास्तव में वीरता, पराक्रम और आत्मबल के प्रेमी हैं, कृपया हमारे भीतर भी वही वीरता और साहस स्थापित करें। 
            आप अत्यंत महान और तेजस्वी हैं, हमारे जीवन के श्रेष्ठ संकल्पों को दृढ़ता प्रदान करें ताकि हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें। 
            सच्ची वीरता वह नहीं जो केवल बाह्य युद्ध में दिखे, बल्कि वह है जो हमें अपने भीतर के विकारों और शत्रुओं पर विजय पाने की अद्भुत शक्ति प्रदान करती है। 
            आपकी कृपा से हमें वह ओज और तेज प्राप्त हो जिससे हम समाज में सत्य और न्याय का मार्ग प्रशस्त करने वाले योद्धा बन सकें। 
            हे देवराज, आप हमारे भीतर के प्रत्येक सूक्ष्म डर को समाप्त कर हमें पूर्णतः निर्भीक और आत्मविश्वासी बनाने की महान कृपा करें। 
            जब आप हमारे हृदय में साहस का बीज बोते हैं, तब संसार की कोई भी प्रतिकूल परिस्थिति हमें अपने मार्ग से विचलित नहीं कर सकती। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी महानता का एक अंश हमारे चरित्र में भी झलके और हम मानवता के लिए श्रेष्ठ बनें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल मन में नवीन ऊर्जा का संचार कर हमें निरंतर कर्मयोग की ओर सफलतापूर्वक अग्रसर करती हैं। 
            हे इन्द्र, हमें वह आध्यात्मिक सामर्थ्य दें कि हम सांसारिक प्रलोभनों से ऊपर उठकर ईश्वर के वास्तविक और शाश्वत सत्य स्वरूप को पा सकें। 
            आपकी कृपा दृष्टि हम पर सदैव बनी रहे और हम आपके संरक्षण में सदैव निर्भय होकर एक गौरवशाली और सार्थक जीवन व्यतीत करने में सफल हों।
        """.trimIndent(),
        englishCommentary = """
            O Shatakratu Indra, you are truly the lover of heroism, valor, and inner strength; please instill that same valor and courage within us. 
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
        id = 107,
        sanskrit = "तमिन्द्रं वाजयामसि महे वृत्राय हन्तवे ।\nस वृषा वृषभो बभूविथ ॥ १०७ ॥",
        hindiCommentary = """
            हम उन इन्द्रदेव को बल और सामर्थ्य प्रदान करने वाली स्तुतियां अर्पित करते हैं ताकि वे महान शत्रु वृत्रासुर का समूल वध कर सकें। 
            वे स्वयं असीम शक्ति के महान पुंज और श्रेष्ठ वीरों में भी सर्वश्रेष्ठ हैं, जो अधर्म का नाश करने के लिए सदैव शस्त्र धारण किए रहते हैं। 
            भक्तों की श्रद्धापूर्ण प्रार्थनाएं इन्द्र के वज्र को और अधिक प्रखर बनाती हैं, जिससे वे संसार की समस्त बाधाओं को नष्ट करने में सक्षम होते हैं। 
            वृत्र केवल एक राक्षस नहीं, बल्कि हमारे मार्ग में आने वाला वह हर सूक्ष्म अवरोध है जो हमें सत्य की प्राप्ति और आत्मोन्नति से रोकता है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारे भीतर के अज्ञान और जड़ता का अंत कर हमारे जीवन में परम प्रकाश का मार्ग सदा के लिए खोलें। 
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
        id = 108,
        sanskrit = "इन्द्राय मधुमत्तमं सोमं पवस्व धारया ।\nशविष्ठाय मत्सराः ॥ १०८ ॥",
        hindiCommentary = """
            हे सोमरस! आप अत्यंत मधुर और आनंददायक होकर अपनी पावन धारा के साथ सबसे बलवान और तेजस्वी इन्द्र की ओर निरंतर प्रवाहित हों। 
            यह सोम ही इन्द्रदेव का मुख्य आहार है, जिसे पीकर वे संपूर्ण ब्रह्मांड की रक्षा के लिए अपनी अजेय शक्ति प्राप्त करते हैं और आनंदित होते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण के समस्त विकारों को धोकर हमें दिव्यता, शांति और साक्षात् ईश्वर के सान्निध्य का अनुभव कराए। 
            जैसे सोम यज्ञ की अग्नि में अर्पित होकर देव-लोक तक पहुँचता है, वैसे ही हमारे पवित्र संकल्प भी आपकी शक्ति से परम पद को प्राप्त करें। 
            हे देव, आप ही वह दिव्य माध्यम हैं जो हमारे प्रार्थनाओं को देवताओं के समूह तक सुरक्षित और शीघ्रता से पहुँचाने का कार्य करते हैं। 
            आपकी कृपा से हमारे जीवन के समस्त अमंगल और दुख दूर हों और हमें शाश्वत दैवीय सुख की वास्तविक अनुभूति प्राप्त हो सके। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आपके बिना कोई भी महान यज्ञ या आध्यात्मिक अनुष्ठान अपनी पूर्णता को प्राप्त नहीं कर सकता। 
            आपकी यह तेजस्वी और मधुर धारा हमारे भीतर के अज्ञान को जलाकर हमें सत्य के साक्षात्कार की ओर ले जाने का मार्ग प्रशस्त करे। 
            हे इन्द्र, आप इस मधुर रस का पान कर अत्यंत प्रसन्न हों और हमारे घरों को सुख, संपन्नता और शांति से भर देने की महान कृपा करें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक, पुष्ट और ईश्वरमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Soma, being most sweet and exhilarating, flow in a sacred stream toward the most powerful and radiant Lord Indra. 
            This Soma is the primary nourishment of Indra, by consuming which he gains invincible strength to protect the entire cosmos and rejoices. 
            May this holy stream wash away all the stains and impurities of our inner self, filling us with divinity, peace, and the presence of God. 
            Just as Soma offered in fire reaches the celestial realms, let our spiritual resolutions reach the supreme state through your power. 
            O God, you are the essential medium who carries our humble prayers and emotions safely and swiftly to the assembly of the divine gods. 
            By your grace, let all the inauspiciousness and sorrows of our lives be removed, granting us the experience of eternal bliss. 
            We worship you with deep devotion because no great sacrifice or spiritual ritual can reach its completion without your presence. 
            May your radiant and sweet stream burn away the darkness of our ignorance and pave the way for us to realize the Truth. 
            O Indra, rejoice greatly by consuming this nectar and graciously fill our homes and hearts with happiness, prosperity, and enduring peace. 
            We offer our entire faith at your feet so that our lives remain meaningful, nourished, and filled with the Divine Presence in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 109,
        sanskrit = "प्र मंहिष्ठाय गायत ऋतावानं विचेतसम् ।\nइन्द्रं विश्वा अवीवृधन् ॥ १०९ ॥",
        hindiCommentary = """
            आप उन अत्यंत उदार, सत्य के महान रक्षक और विशेष रूप से ज्ञानी इन्द्रदेव के लिए भक्तिपूर्वक गान और वंदना करें। 
            समस्त ब्रह्मांडीय शक्तियों और भक्तों की निष्कपट वाणियों ने इन्द्र की महिमा को निरंतर बढ़ाया है और उन्हें सर्वोच्च पद पर प्रतिष्ठित किया है। 
            इन्द्र ही वह चेतना हैं जो सत्य के मार्ग पर चलने वाले साधकों का मार्गदर्शन करती है और उन्हें अज्ञान के बंधनों से पूर्णतः मुक्त कराती है। 
            उनकी उदारता की कोई सीमा नहीं है; वे अपने प्रत्येक शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके कल्याण के लिए अनिवार्य है। 
            हे देव, आप अपनी प्रखर बुद्धि से हमारे समस्त संशयों का नाश कर हमें वह स्पष्ट दृष्टि दें जिससे हम जीवन के रहस्यों को जान सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे मन की मलीनता दूर होती है और हम ईश्वर के अनंत प्रेम और शांति का अनुभव करने लगते हैं। 
            आप ही वह सर्वोच्च शक्ति हैं जो हमारे कठिन परिश्रम को ईश्वरीय फल में और हमारी छोटी प्रार्थनाओं को दिव्य आशीषों में बदलने का सामर्थ्य रखती हैं। 
            हम श्रद्धापूर्वक आपके सम्मुख नतमस्तक हैं ताकि आप हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, यश और आध्यात्मिक उन्नति लाएं। 
            इन्द्रदेव की पावन उपस्थिति मात्र से ही हमारे अभाव दूर हो जाते हैं और हम अपने भीतर एक अखंड पूर्णता और दिव्य आनंद का अनुभव करते हैं। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहें और हमें दिव्यता के मार्ग पर निरंतर अग्रसर करते रहें।
        """.trimIndent(),
        englishCommentary = """
            Sing devotedly for the most generous, the great guardian of Truth, and the highly wise Lord Indra. 
            All cosmic forces and the sincere voices of his devotees have continuously increased Indra's glory and established him at the supreme state. 
            Indra is that consciousness which guides seekers walking the path of Truth and liberates them completely from the heavy bonds of ignorance. 
            There is no limit to his generosity; he bestows upon every surrendered devotee everything that is mandatory for their ultimate well-being. 
            O God, with your sharp intelligence, destroy our doubts and grant us that clear vision to understand the deep mysteries of existence. 
            The continuous singing of your glories removes the impurities of our minds and allows us to experience the infinite love and peace of the Divine. 
            You are the supreme power that possesses the strength to transform our hard work into divine results and our simple prayers into blessings. 
            We bow before you with devotion so that you bring abundance, fame, and spiritual evolution into every single aspect of our lives. 
            The holy presence of Lord Indra dissolves our scarcities, making us experience a sense of unbroken completeness and divine joy within. 
            O Indra, stay with us forever as our protector and nourisher, and continue to lead us steadily on the radiant path of divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 110,
        sanskrit = "यस्य द्विता विधर्तुः साकमस्य सतो वशा ।\nस न इन्द्रः शिवः सखा ॥ ११० ॥",
        hindiCommentary = """
            जिन इन्द्रदेव की आज्ञा और शासन इस ब्रह्मांड के दोनों लोकों में विधिवत व्याप्त और अत्यंत गौरव के साथ प्रतिष्ठित है। 
            वे ही महान देव हमारे लिए एक कल्याणकारी और अत्यंत आत्मीय मित्र बनकर हमारे जीवन के प्रत्येक सुख-दुख में सदैव उपस्थित रहें। 
            इन्द्र का शासन केवल कठोर दंड पर नहीं, बल्कि न्याय और प्रेम पर आधारित है, जो संपूर्ण चराचर जगत को अनुशासित और संतुलित रखता है। 
            उनकी मित्रता हमें वह अद्भुत संबल प्रदान करती है जिससे हम जीवन के बड़े से बड़े युद्धों को अत्यंत शांति और धैर्य के साथ जीत सकते हैं। 
            हे देवराज, आप हमारे सबसे निकट के हितैषी बनकर हमें वह मार्गदर्शन दें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें। 
            जब आप हमारे सखा बनते हैं, तब संसार की कोई भी नकारात्मक शक्ति या प्रतिकूल परिस्थिति हमें अपने लक्ष्य से विचलित नहीं कर सकती। 
            हम श्रद्धापूर्वक आपकी अर्चना करते हैं ताकि हमारे जीवन में केवल शुभ का उदय हो और हम सदैव आपकी सुरक्षित छाया में निर्भय रहें। 
            आपकी कृपा से ही हमारे परिवारों में एकता, प्रेम और धर्मनिष्ठा का वास होता है, जो हमारे सामाजिक जीवन को सुखमय बनाता है। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अंधकारमय अज्ञान से हटाकर परम सत्य के शाश्वत प्रकाश की ओर ले जाने की कृपा करें। 
            हम आपकी इस दिव्य और भव्य महिमा की बार-बार वंदना करते हैं और आपसे निरंतर सुरक्षा और मंगलकारी आशीष की याचना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            Lord Indra, whose command and governance are duly established and pervasive with glory across both the realms. 
            May that great deity remain forever present in our lives as a benevolent and highly intimate friend through all situations. 
            Indra's rule is not based on mere harsh punishment but on justice and love, which keeps the entire universe balanced and disciplined. 
            His friendship provides us with that amazing support through which we can win the greatest battles of life with peace and patience. 
            O King of Gods, become our nearest well-wisher and guide us so that we never walk the path of unrighteousness or untruth. 
            When you become our companion, no negative force or adverse worldly situation can ever sway or distract us from our spiritual goal. 
            We worship you with devotion so that only the auspicious arises in our lives and we always remain fearless under your protective shadow. 
            By your grace alone, unity, love, and righteousness reside in our families, making our social life blissful and meaningful. 
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the eternal and radiant light of the Supreme Truth. 
            We repeatedly bow before your divine and magnificent glory and seek your constant protection and auspicious blessings.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 111,
        sanskrit = "अभित्वा शूर नोनुमो दुग्धा इव धेनवः ।\nईशानमस्य जगतः स्वर्दृशमीशानमिन्द्र तस्थुषः ॥ १११ ॥",
        hindiCommentary = """
            हे परम वीर इन्द्रदेव! जैसे दुधारू गौएँ अपने बछड़े की ओर अत्यंत प्रेम से रंभाती हुई दौड़ती हैं, वैसे ही हम आपकी स्तुति करते हैं। 
            आप इस संपूर्ण चराचर जगत के स्वामी हैं, जो जड़ और चेतन दोनों पर न्यायपूर्वक शासन करने वाले महान देव हैं। 
            आपकी दृष्टि स्वर्ग तक व्याप्त है, और आप ही समस्त लोकों के वास्तविक नियन्ता और परम रक्षक के रूप में प्रतिष्ठित हैं। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के अंधकार को दूर कर उसे ज्ञान के प्रकाश से भर देने वाले देव हैं। 
            आपकी कृपा से ही हमें वह सामर्थ्य प्राप्त होता है जिससे हम अपनी इंद्रियों और चंचल मन पर पूर्ण नियंत्रण पा सकें। 
            जैसे गौ अपने दूध से संसार का पोषण करती है, वैसे ही आप अपनी कृपा की वर्षा से भक्तों का सर्वांगीण कल्याण करते हैं। 
            आपकी महिमा का गान करने से हमारे भीतर के सोए हुए साहस, वीरता और आत्मविश्वास का पुनर्जागरण होता है। 
            हे देवराज, आप हमारे हृदयों में भक्ति का ऐसा अखंड दीपक जलाएं जो अज्ञान की आँधियों में भी कभी न बुझे। 
            हम श्रद्धापूर्वक आपके चरणों में नमन करते हैं ताकि आप हमें आध्यात्मिक शांति और भौतिक संपन्नता दोनों ही प्रदान करें। 
            इन्द्रदेव की शरण में आने वाला साधक कभी निर्बल नहीं रहता, उसे ज्ञान और ऐश्वर्य की प्रचुरता प्राप्त होती है। 
            हे अजेय वीर, आप हमारे रक्षक बनकर हमें सदैव धर्म के मार्ग पर दृढ़ रहने की दिव्य शक्ति प्रदान करने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O heroic Lord Indra, just as milch cows low affectionately toward their calves, we continuously chant your praises. 
            You are the sovereign Lord of this entire universe, governing both the moving and the non-moving entities with justice. 
            Your divine vision extends to the highest heavens, and you are established as the true controller and protector of all realms. 
            We worship you because you are the deity who removes the darkness of our lives and fills them with the light of knowledge. 
            It is only through your grace that we receive the strength required to gain mastery over our senses and our wandering mind. 
            Just as a cow nourishes the world with its milk, you nourish your devotees' welfare with the constant showers of your grace. 
            Singing your glories awakens the dormant courage, heroism, and self-confidence within us, enabling us to face life's battles. 
            O King of Gods, ignite such an eternal lamp of devotion in our hearts that it never flickers and always guides our way. 
            We bow before your feet with profound faith so that you may grant us both spiritual peace and material abundance. 
            A seeker who takes refuge in Lord Indra never remains weak; they attain an infinite abundance of wisdom and splendor. 
            O invincible hero, stay as our guardian and graciously provide us with the divine strength to remain firm on the path of Dharma.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 112,
        sanskrit = "न त्वावाँ अन्यो दिव्यो न पार्थिवो न जातो न जनिष्यते ।\nअश्वयन्तो मघवन्निन्द्र वाजिनो गव्यन्तस्त्वा हवामहे ॥ ११२ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आपके समान शक्तिशाली और दयालु न तो कोई दिव्य लोक में है, न इस पृथ्वी पर, न कोई हुआ है और न होगा। 
            आपकी तुलना किसी भी अन्य सत्ता से नहीं की जा सकती, आप अद्वितीय और सर्वोत्तम शक्तियों के परम स्वामी और रक्षक हैं। 
            हम शक्ति, विजय और प्रचुर संसाधनों की कामना करते हुए आपको अपने यज्ञ में अत्यंत आदर के साथ बुलाते हैं। 
            आप ही वह एकमात्र शक्ति हैं जो हमारे जीवन में श्रेष्ठता और प्रचुरता लाने का सामर्थ्य रखती हैं, हम आपकी शरण में हैं। 
            आपकी दिव्यता समस्त सीमाओं से परे है, और आप ही ऋत के मार्ग के सबसे बड़े संरक्षक और सजग प्रहरी हैं। 
            जब हम आपका हृदय से आह्वान करते हैं, तो हमारे भीतर एक नई ऊर्जा का संचार होता है जो हमें शत्रुओं पर विजय दिलाती है। 
            संसार की कोई भी बाधा आपके अजेय वज्र के सामने टिक नहीं सकती, आप हमारे मार्ग के समस्त कंटकों को दूर करें। 
            हमें वह प्रज्ञा और साहस प्रदान करें जिससे हम धर्म की रक्षा के लिए सदैव तत्पर रह सकें और अपने लक्ष्यों में सफल हों। 
            आपकी कृपा दृष्टि से हमारा कल्याण सुनिश्चित है, हम आपकी इस भव्य और अजेय शक्ति की बार-बार हृदय से वंदना करते हैं। 
            हे इन्द्र, आप हमारे स्वामी और रक्षक हैं, हमें अज्ञान से ज्ञान की ओर और अंधकार से शाश्वत प्रकाश की ओर ले चलें। 
            हम अपनी संपूर्ण श्रद्धा आपके चरणों में अर्पित करते हैं ताकि हमारा जीवन हर दृष्टि से सार्थक और मंगलमय बना रहे।
        """.trimIndent(),
        englishCommentary = """
            O Maghavan Indra, there is none as powerful and merciful as you in the heavens, nor on earth; none has existed, nor will exist. 
            Your greatness is beyond comparison; you are the unique and supreme master and guardian of the highest celestial and worldly powers. 
            Desiring strength, victory, and abundant resources, we call upon you in our sacrificial ritual with the utmost respect. 
            You are the only power capable of bringing excellence and plenty into our lives; we seek your divine refuge with total faith. 
            Your divinity transcends all boundaries, and you stand as the greatest protector and alert sentinel of the Cosmic Order (Rta). 
            When we invoke you from our hearts, a new surge of energy flows through us, granting us victory over all our foes and hurdles. 
            No obstacle in this world can withstand your invincible thunderbolt; please remove all the thorns from our path forever. 
            Grant us the wisdom and courage required to always be ready for the defense of Dharma and to be successful in our goals. 
            Our well-being is guaranteed under your merciful gaze; we repeatedly bow before your magnificent and invincible power. 
            O Indra, you are our Lord and Protector; lead us away from dark ignorance toward the Supreme Light and make our lives meaningful. 
            We offer our entire faith at your feet so that our lives remain auspicious and blessed in every possible way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 113,
        sanskrit = "इन्द्रं विश्वा अवीवृधन्त्समुद्रव्यचसं गिरः ।\nरथीतं रथीनां वाजानीं पतिं चर्कृत्यम् ॥ ११३ ॥",
        hindiCommentary = """
            समस्त स्तुतियां समुद्र के समान विशाल और सर्वव्यापी इन्द्रदेव की महिमा को निरंतर बढ़ाती और संसार में प्रकाशित करती हैं। 
            वे रथियों में श्रेष्ठ और समस्त विजयों के अधिपति हैं, जिनकी बार-बार अत्यंत श्रद्धा के साथ प्रशंसा और वंदना की जानी चाहिए। 
            इन्द्र की व्यापकता आकाश और समुद्र की तरह अनंत है, जिसमें संपूर्ण ब्रह्मांड की शक्तियाँ सुरक्षित और समाहित रहती हैं। 
            वे हमारे जीवन रूपी रथ के सबसे कुशल और शक्तिशाली सारथी हैं, जो हमें संसार की बाधाओं के बीच से कुशलतापूर्वक निकाल ले जाते हैं। 
            हे देव, आप अपनी प्रचंड शक्ति और अपार बुद्धिमत्ता से हमारे प्रत्येक प्रयास को सफलता के उच्चतम शिखर तक पहुँचाने की कृपा करें। 
            हमें वह आध्यात्मिक और भौतिक शक्ति प्रदान करें जिससे हम निर्बलों की सहायता कर सकें और धर्म की ध्वजा को ऊँचा रख सकें। 
            आपकी महिमा का निरंतर गान करने से हमारे अंतःकरण की शुद्धि होती है और हम आध्यात्मिक रूप से निरंतर जागृत होने लगते हैं। 
            इन्द्रदेव की शरण में आने वाला साधक कभी भी पराजित नहीं होता, क्योंकि स्वयं ब्रह्मांड का नायक उसका सहायक बन जाता है। 
            आपकी दिव्य दीप्ति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव, यश और सच्ची कीर्ति का मार्ग दिखाए। 
            हे इन्द्र, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और सुखी बनाने की कृपा करें।
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
            Let your divine radiance illuminate every dark corner of our existence and show us the pathway to fame, splendor, and eternal glory. 
            O Indra, always remain with us as our protector and nourisher, graciously making our lives magnificent, successful, and truly happy.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 114,
        sanskrit = "स नः शुभः शुभंभर इन्द्रो विश्वाभिरूतिभिः ।\nअस्मे धेहि श्रवश्च्यौतम् ॥ ११४ ॥",
        hindiCommentary = """
            हे कल्याणकारी इन्द्रदेव! आप शुभ फल प्रदान करने वाले देव हैं, कृपया अपनी समस्त रक्षात्मक शक्तियों के साथ हमारे जीवन में पधारें। 
            आप हमारे जीवन में वह यश और ऐश्वर्य स्थापित करें जो शत्रुओं और नकारात्मक शक्तियों के प्रभाव को जड़ से समाप्त कर देने वाला हो। 
            आपकी शुभता हमारे घर और मन को पवित्र करती है, जिससे हमारे भीतर सात्विक गुणों का निरंतर और तीव्र विकास होता है। 
            जब आप अपनी महान और अजेय शक्तियों के साथ हमारे सहायक बनते हैं, तो सफलता स्वतः ही हमारे प्रत्येक कार्य का अनुसरण करने लगती है। 
            हे देवराज, आप हमारे अज्ञान रूपी शत्रुओं को नष्ट कर हमें वह कीर्ति प्रदान करें जो सत्य पर आधारित हो और स्थायी बनी रहे। 
            आपकी रक्षात्मक शक्तियाँ हमारे चारों ओर एक ऐसा अभेद्य कवच बनाती हैं जिसमें कोई भी नकारात्मकता या रोग कभी प्रवेश नहीं कर सकता। 
            हम अपनी प्रार्थनाओं से आपकी उस शक्ति का आह्वान करते हैं जो असंभव को भी संभव बनाने और हमें विपदाओं से उबारने का सामर्थ्य रखती है। 
            आप ही वह ऊर्जा हैं जो हमारे शिथिल पड़ते संकल्पों में नवीन प्राण और उत्साह फूंकती हैं और हमें जीवन के प्रत्येक क्षेत्र में विजयी बनाती हैं। 
            हे इन्द्र, आप अपनी अनंत उदारता के साथ हमारे यज्ञ को सिद्ध करें और हमें आध्यात्मिक उन्नति के मार्ग की ओर ले चलें। 
            आपकी कृपा दृष्टि से हमारा भविष्य सुरक्षित और उज्ज्वल है, हम आपकी अजेय और भव्य शक्ति की बार-बार श्रद्धापूर्वक वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O auspicious Lord Indra, you are the bringer of good fortune; please manifest in our lives with all your protective and divine powers. 
            Establish within us that fame and prosperity which has the strength to completely shatter the influence of negative forces. 
            Your auspiciousness sanctifies our homes and minds, leading to the rapid development of virtuous and celestial qualities within us. 
            When you become our helper with your vast and invincible powers, success and abundance naturally begin to follow our every endeavor. 
            O King of Gods, destroy the internal enemies of ignorance and grant us fame that is rooted in Truth and remains permanent. 
            Your protective energies form an impenetrable shield around us, through which no form of negativity, disease, or sorrow can penetrate. 
            Through our prayers, we invoke that power of yours which possesses the capability to make the impossible possible and rescue us from calamities. 
            You are the energy that breathes new life and enthusiasm into our weakening resolutions and empowers us to emerge victorious in every field. 
            O Indra, with your infinite generosity, perfect our sacrifice and lead us toward the path of profound spiritual evolution. 
            Our future is safe and immensely bright under your merciful gaze; we repeatedly bow before your invincible and magnificent power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 115,
        sanskrit = "आ तू न इन्द्र क्षुमन्तं चित्रं ग्राभं सं गृभाय ।\nमहाहस्ती दक्षिणेन ॥ ११५ ॥",
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
        id = 116,
        sanskrit = "का त उस्तिः शविष्ठ्य का मतिः का सुवृक्तिः ।\nकदा वसूनि भरसि ॥ ११६ ॥",
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
        id = 117,
        sanskrit = "कुविद्ङ्ग मघवन् कस्यचिद् गिरो ज्रयो वाजस्य गन्त ।\nएवा हि ते मनो विचेतसम् ॥ ११७ ॥",
        hindiCommentary = """
            हे मघवन् इन्द्र! आप वास्तव में उन भक्तों की वाणियों और स्तुतियों के पास पहुँचते हैं जो विजय और सिद्धि के लिए निरंतर प्रयत्नशील हैं। 
            आपका मन अत्यंत विशेष ज्ञानी और चतुर है, जो यह भली-भांति जानता है कि किस साधक को कब और क्या प्रदान करना उसके लिए श्रेष्ठ है। 
            आपकी बुद्धि सूक्ष्म रहस्यों को भेदने वाली है, और आप केवल सच्ची श्रद्धा और पुरुषार्थ से ही प्रसन्न होने वाले महान देव हैं। 
            जब हम एकाग्र मन से आपकी महिमा गाते हैं, तो आपकी चेतना हमारे जीवन के संघर्षों में साक्षात् मार्गदर्शन करने लगती है। 
            हे देव, आप हमारे संकल्पों को वह गति दें जिससे हम अपने लक्ष्यों को शीघ्रता और पूर्णता के साथ प्राप्त करने में सफल हों। 
            आपकी कृपा का प्रवाह उन लोगों की ओर स्वतः ही मुड़ जाता है जो धर्म की रक्षा और समाज के उत्थान के लिए समर्पित हैं। 
            हमें वह 'विचेतस' प्रदान करें जिससे हम सांसारिक भ्रमों से बचकर केवल शाश्वत सत्य की खोज कर सकें। 
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
            Grant us that 'Vichetas' which enables us to avoid worldly illusions and seek only the eternal Truth. 
            You are the power that transforms our hard labor into divine results and our simple prayers into magnificent celestial blessings. 
            Indra's friendship provides us with a security that prevents us from wavering even amidst the strongest worldly temptations. 
            O Indra, stay with us as our protector and guide, and lead us to that peak of divinity where only joy and peace reside.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 118,
        sanskrit = "आ तू न इन्द्र मद्र्यग् घृवाणो वृषन् आ गहि ।\nमहाँ महीभिः ऊतिभिः ॥ ११८ ॥",
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
    )
)
