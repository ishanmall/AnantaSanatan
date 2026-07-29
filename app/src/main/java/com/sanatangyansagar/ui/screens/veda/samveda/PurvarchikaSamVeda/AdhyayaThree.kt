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
fun PurvarchikaAdhyayaThreeScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            purvarchikaAdhyayaThreeData
        } else {
            purvarchikaAdhyayaThreeData.filter {
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
                        Text("तृतीय अध्याय - पवमान पर्व", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFF9C4) // Golden Yellow tint for Soma (Nectar/Light)
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
                .background(Color(0xFFFFFDE7)),
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

// Data List for Adhyaya 3 (Mantras 1 to 20)



val purvarchikaAdhyayaThreeData = listOf(
    PurvarchikaVerse(
        id = 1,
        sanskrit = "उच्चा ते जातमन्धसो दिवि सद्भूम्याददे ।\nउग्रं शर्म महि श्रवः ॥ १ ॥",
        hindiCommentary = """
            हे सोमदेव! आपका जन्म अत्यंत उच्च और दिव्य लोकों में हुआ है, आप उस स्वर्ग के पुत्र हैं जो पृथ्वी पर हमारे कल्याण के लिए अवतरित हुए हैं। 
            आप वह दिव्य ओषधि हैं जिसे स्वर्ग से लाया गया है, और आपकी शक्ति समस्त ब्रह्मांड में व्याप्त होकर प्राणियों को जीवन प्रदान करती है। 
            हम पृथ्वी पर आपके इस दिव्य रस को प्राप्त करते हैं ताकि हमारे शरीर और आत्मा दोनों को नवीन ऊर्जा और पवित्रता प्राप्त हो सके। 
            आपकी कृपा से हमें वह उग्र और प्रचंड सामर्थ्य (उग्रं शर्म) प्राप्त हो जो हमारे शत्रुओं और बाधाओं का समूल नाश करने में सक्षम हो। 
            हे सोम, आप हमें वह 'महि श्रवः' (महान यश और कीर्ति) प्रदान करें जो धर्म के मार्ग पर चलकर अर्जित किया गया हो और जो स्थायी हो। 
            आपका प्रवाह हमारे अंतःकरण को शुद्ध करता है और हमें उच्चतर चेतना के स्तरों तक पहुँचने के लिए मानसिक शक्ति प्रदान करता है। 
            जैसे आप स्वर्ग से उतरकर पृथ्वी को सिंचित करते हैं, वैसे ही हमारे संकल्पों को भी दिव्यता से सिंचित कर उन्हें सफल बनाएं। 
            हम आपकी स्तुति करते हैं क्योंकि आप ही आनंद के स्रोत हैं और आपके सान्निध्य में समस्त दुखों का अंत स्वतः ही हो जाता है। 
            आपकी यह पावन ज्योति हमारे जीवन के अंधकारमय कोनों को प्रकाशित कर हमें सत्य के साक्षात्कार की ओर सफलतापूर्वक ले जाए। 
            हे पवमान सोम, आप हमारे यज्ञ में पधारें और हमें वह अमरत्व प्रदान करें जिसकी कामना समस्त ऋषि-मुनि निरंतर करते रहते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Soma, your birth is high and divine, originating in the celestial realms; you are the offspring of heaven descended to earth for our well-being. 
            You are that divine medicinal herb brought from the heights, whose power permeates the entire cosmos to grant life to all living beings. 
            We receive your sacred essence here on earth so that both our physical body and our soul may attain fresh energy and absolute purity. 
            By your grace, may we be endowed with that fierce and formidable strength (Ugram Sharma) which is capable of destroying all enemies and hurdles. 
            O Soma, bestow upon us 'Mahi Shravah'—the great fame and glory that is earned through the path of Dharma and which remains eternal. 
            Your divine flow purifies our inner self and provides the mental fortitude required to reach the higher states of cosmic consciousness. 
            Just as you descend from heaven to nourish the earth, please nourish our intentions with divinity and make them completely successful. 
            We worship you because you are the ultimate source of bliss, and in your holy presence, all worldly sufferings vanish naturally. 
            May your sacred light illuminate the dark corners of our existence and lead us successfully toward the realization of the Eternal Truth. 
            O Pavamana Soma, manifest within our sacrifice and grant us that immortality which the ancient seers and sages continuously long for.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 2,
        sanskrit = "स नः पवस्व व्योमनि विधर्मन् धारया सुतः ।\nअभि वाजं निक्षिपन् ॥ २ ॥",
        hindiCommentary = """
            हे निष्कासित (सुतः) सोमदेव! आप आकाश के विशाल विस्तार (व्योमनि) में अपनी पवित्र धारा के साथ प्रवाहित होकर हमें शुद्ध करने की कृपा करें। 
            आप ब्रह्मांडीय नियमों (विधर्मन्) को धारण करने वाले हैं, आपकी धारा हमारे जीवन में अनुशासन, सत्य और मर्यादा की स्थापना करे। 
            जैसे आप छननी से छनकर शुद्ध होते हैं, वैसे ही हमारी आत्मा भी संसार के प्रलोभनों से छनकर पूर्णतः पवित्र और दिव्य बन जाए। 
            आप हमें वह 'वाज' (शक्ति और प्रचुर अन्न) प्रदान करें जो हमारे पुरुषार्थ को सफल बनाए और हमें समाज में यशस्वी स्थान दिलाए। 
            आपकी यह पावन धारा हमारे मानसिक संशयों और विकारों को धोकर हमें स्पष्ट दृष्टि और सही निर्णय लेने की सामर्थ्य प्रदान करे। 
            हे सोम, आप ही देवताओं के प्रिय पेय हैं, आपकी ऊर्जा से ही इन्द्र आदि देव अपनी अजेय शक्ति प्राप्त कर असुरों का दमन करते हैं। 
            हमें भी वह आंतरिक बल दें कि हम अपने भीतर के काम, क्रोध और लोभ रूपी असुरों पर विजय प्राप्त कर आत्मवान और शांत बन सकें। 
            हम आपकी निरंतर वंदना करते हैं ताकि हमारे जीवन में आनंद का प्रवाह कभी न रुके और हम सदैव आपके दिव्य प्रेम में लीन रहें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें ईश्वर की सर्वव्यापकता का अनुभव कराने में परम सहायक सिद्ध हो, यही प्रार्थना है। 
            हे पवमान सोम, आप हमारे घरों और हृदयों को सुख, संपन्नता और शांति से भर देने वाले उदार संरक्षक के रूप में यहाँ विराजें।
        """.trimIndent(),
        englishCommentary = """
            O extracted (Sutah) Soma, flow in your sacred stream through the vast expanse of the sky (Vyomani) and graciously purify us. 
            You are the upholder of cosmic laws and orders (Vidharman); may your flow establish discipline, truth, and righteousness in our lives. 
            Just as you are purified by flowing through the filter, may our souls also be filtered from worldly temptations to become pure and divine. 
            Bestow upon us 'Vaja'—the power and abundant nourishment—that makes our human efforts successful and earns us an honored place in society. 
            May your holy stream wash away our mental doubts and afflictions, granting us clear vision and the capability to make righteous decisions. 
            O Soma, you are the favorite drink of the gods; it is from your energy that Indra and others gain invincible strength to subdue the demons. 
            Grant us also that inner strength so that we may conquer the internal demons of lust, anger, and greed to become self-realized and peaceful. 
            We continuously worship you so that the flow of bliss never stops in our lives and we remain forever immersed in your divine love. 
            Let your brilliance remove the veils of our ignorance and be a supreme aid in experiencing the omnipresence of God within us. 
            O Pavamana Soma, reside in our homes and hearts as the generous protector who fills our existence with happiness, prosperity, and peace.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 3,
        sanskrit = "पुनाति ते परिस्रुतं सोमं सूर्यस्य दुहिता ।\nवारेण शश्वता तना ॥ ३ ॥",
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
        id = 4,
        sanskrit = "पवस्व देव आयुष्यक् पवस्व वसुवित्तमः ।\nअग्नेः सख्ये शिवो भव ॥ ४ ॥",
        hindiCommentary = """
            हे दिव्य सोमदेव! आप आयु को बढ़ाने वाले (आयुष्यक्) होकर प्रवाहित हों और हमें समस्त ऐश्वर्यों को दिलाने वाले (वसुवित्तमः) स्वामी बनें। 
            आप अग्निदेव के साथ परम मित्रता (सख्ये) रखते हैं, कृपया हमारे लिए भी एक कल्याणकारी और मंगलमय (शिवः) मित्र बनकर प्रकट हों। 
            आपकी पावन धारा हमारे शरीर को आरोग्य और दीर्घायु प्रदान करे ताकि हम लंबी अवधि तक ईश्वर और मानवता की सेवा कर सकें। 
            अग्नि और सोम का मिलन ऊर्जा और आनंद का मिलन है, जो हमारे जीवन में शक्ति और शांति का सुंदर संतुलन स्थापित करने वाला है। 
            हे देव, आप हमारे घरों में वह प्रचुर धन और संसाधन लेकर आएं जिनका उपयोग हम धर्म और परोपकार के कार्यों में गर्व के साथ कर सकें। 
            आपकी मित्रता हमें वह अभय प्रदान करती है जिससे हम संसार के किसी भी संकट का सामना अत्यंत धैर्य और अटूट विश्वास के साथ करते हैं। 
            हमें वह आध्यात्मिक दृष्टि दें जिससे हम आपके दिव्य स्वरूप को प्रकृति के प्रत्येक कण में महसूस कर सकें और सदैव कृतज्ञ बने रहें। 
            जैसे आप यज्ञ की अग्नि को प्रदीप्त करते हैं, वैसे ही हमारे हृदय में ज्ञान की अग्नि को प्रज्वलित कर हमें अज्ञान से सदा के लिए मुक्त कर दें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन और परिवार में सदैव निरंतर बहता रहे। 
            हे इन्द्र के प्रिय सोम, आप हमारे रक्षक और गुरु बनकर हमें वह विवेक दें जिससे हम सत्य को पहचान कर मोक्ष के अधिकारी बन सकें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Soma, flow as the one who bestows longevity (Ayushyak) and become the supreme master who grants all riches (Vasuvittamah). 
            You hold a profound friendship with Lord Agni; please manifest for us also as a benevolent and auspicious (Shivah) friend. 
            May your holy stream provide health and a long life to our physical bodies so that we may serve God and humanity for a vast duration. 
            The union of Agni and Soma is the union of energy and bliss, establishing a beautiful balance of power and peace within our daily lives. 
            O God, bring into our homes that abundant wealth and resources which we can use for the works of Dharma and altruism with great pride. 
            Your friendship grants us the fearlessness through which we face any worldly crisis with extreme patience and unshakable faith. 
            Grant us that spiritual vision which enables us to feel your divine essence in every particle of nature and remain forever grateful. 
            Just as you kindle the sacrificial fire, kindle the fire of knowledge within our hearts to liberate us forever from the darkness of ignorance. 
            We worship you with devotion so that the flow of your immense generosity remains forever present in our lives and within our families. 
            O beloved Soma of Indra, stay as our guardian and teacher, granting us the discernment to recognize Truth and become worthy of liberation.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 5,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ ५ ॥",
        hindiCommentary = """
            हे सोमदेव! आप वाणी के अग्रणी (वाचो अग्रियः) और ज्ञान के समुद्र (अर्णवः) होकर अपनी दिव्य चेतना (चित्तिभिः) के साथ प्रवाहित हों। 
            आप गर्जना करते हुए (कनिक्रदत्) अपने दिव्य स्थान (योनिं) पर विराजमान हों, जो आपकी प्रचंड शक्ति और सर्वोच्चता का साक्षात् प्रतीक है। 
            आप ही वह शक्ति हैं जो ऋषियों की वाणी में मंत्रों का संचार करती हैं और उन्हें सत्य का उद्घाटन करने के लिए सामर्थ्यवान बनाती हैं। 
            जैसे समुद्र अथाह और रत्नों से भरा होता है, वैसे ही आपका ज्ञान भी अनंत है, जो हमें आध्यात्मिक समृद्धि प्रदान करने वाला है। 
            हे देव, आप हमारे कंठ में सत्य की वाणी बनकर विराजें ताकि हम सदैव मंगलकारी और कल्याणकारी शब्दों का ही उच्चारण करें। 
            आपकी गर्जना हमारे भीतर के आलस्य और तामसी प्रवृत्तियों को जगाकर हमें कर्म और साधना के मार्ग पर सक्रिय कर देने वाली है। 
            हमें वह मेधा शक्ति प्रदान करें जिससे हम वेदों के गूढ़ रहस्यों को समझ सकें और अपने जीवन को उनके सिद्धांतों के अनुरूप ढाल सकें। 
            आपकी कृपा से हमारा मन भी एक शांत और गहरे समुद्र की तरह बन जाए जिसमें आपकी भक्ति के रत्न सदैव सुरक्षित और चमकते रहें। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर उसे दिव्यता के निवास योग्य पवित्र स्थान बनाते हैं। 
            हे पवमान सोम, आप अपनी अनंत महिमा के साथ हमारे यज्ञ में प्रतिष्ठित हों और हमें सुख, शांति और परम ज्ञान का आशीर्वाद प्रदान करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow with your divine consciousness (Chittibhih) as the leader of speech (Vacho Agriyah) and the ocean of wisdom (Arnavah). 
            Manifesting with a roar (Kanikradat), seat yourself upon your divine source (Yonim), symbolizing your fierce power and ultimate supremacy. 
            You are the power that infuses sacred mantras into the speech of the seers and empowers them to reveal the Ultimate Truth to the world. 
            Just as the ocean is fathomless and filled with gems, your knowledge is infinite and capable of granting us immense spiritual prosperity. 
            O God, reside in our throats as the voice of Truth so that we may always utter only auspicious and benevolent words for all. 
            Your divine roar awakens us from lethargy and dark tendencies, activating us on the path of selfless action and spiritual practice. 
            Bestow upon us that intellectual capability through which we can understand the mysteries of the Vedas and shape our lives by them. 
            By your grace, may our minds also become like a calm and deep ocean in which the gems of your devotion remain safe and radiant. 
            We worship you with devotion because you are the one who purifies our inner self and makes it a fit dwelling for divine presence. 
            O Pavamana Soma, reside in our sacrifice with your infinite glory and grant us the blessings of happiness, peace, and supreme knowledge.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 6,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ ६ ॥",
        hindiCommentary = """
            हे पवमान कवि (क्रांतदर्शी) सोम! आपकी पवित्र और शक्तिशाली लहरें (ऊर्मिणः) रत्नों और ऐश्वर्यों की कामना करती हुई तीव्र गति से प्रवाहित हो रही हैं। 
            आप स्वयं ज्ञान के पुंज हैं और जब आप अपनी तरंगों के साथ बहते हैं, तो आप अपने भक्तों के लिए सौभाग्य और दिव्यता का संदेश लेकर आते हैं। 
            जैसे समुद्र की लहरें तट पर बहुमूल्य वस्तुएं लेकर आती हैं, वैसे ही आपकी धारा हमारे जीवन में सात्विक गुणों और आध्यात्मिक रत्नों को लाती है। 
            हे देव, आपकी ये लहरें हमारे मन के संताप और दुखों को बहा ले जाएं और हमें शांति के शीतल सागर में पूरी तरह से सराबोर कर दें। 
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करती है जिससे हम संसार के मायाजाल को भेदकर सत्य के वास्तविक स्वरूप का दर्शन करने में सफल होते हैं। 
            हमें वह 'रत्न' (श्रेष्ठ गुण) प्रदान करें जो हमारे चरित्र को बलवान और उज्ज्वल बनाएं ताकि हम समाज के लिए एक आदर्श प्रस्तुत कर सकें। 
            आप ही वह शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों में बदलने का सामर्थ्य रखती हैं, हम आपकी शरण में निरंतर हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी कृपा की वर्षा हमारे जीवन और परिवार में सदैव निरंतर और अखंड बनी रहे। 
            जैसे तरंगें निरंतरता का प्रतीक हैं, वैसे ही हमारी भक्ति भी आपके प्रति निरंतर और अटूट बनी रहे, यही हमारी आपसे प्रार्थना है। 
            हे दिव्य सोम, आप अपनी इन पावन लहरों के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे परमात्मा के साक्षात्कार के योग्य बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Kavi (wise seer) Soma, your holy and powerful waves (Urminah) flow with speed, seeking treasures and divine riches for us. 
            You are the mass of ultimate knowledge, and as you flow with your ripples, you bring messages of good fortune and divinity to your followers. 
            Just as ocean waves bring precious objects to the shore, your sacred current brings virtuous qualities and spiritual gems into our lives. 
            O God, let these waves wash away the heat of our sorrows and afflictions, immersing us completely in the cool and calm ocean of peace. 
            Your energy provides us with the capability to pierce through the illusions of the world and perceive the actual nature of the Truth. 
            Bestow upon us those 'gems' (superior traits) that make our character strong and bright, so we may present an ideal model for society. 
            You are the power that possesses the capability to transform our subtle intentions into cosmic achievements; we seek your refuge. 
            We worship you with devotion so that the rain of your grace remains continuous and unbroken within our lives and our families. 
            Just as waves represent continuity, may our devotion toward you remain constant and unbreakable; this is our humble prayer. 
            O Divine Soma, through these holy waves of yours, purify our inner self and make it worthy of the direct realization of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 7,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ७ ॥",
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
        id = 8,
        sanskrit = "तं वो दस्ममृतीषहं वसोर्मन्दानमन्धसः ।\nअभि वत्सं न मातरो गावो वर्धन्ति वृषभम् ॥ ८ ॥",
        hindiCommentary = """
            हे भक्तों! आप उन अद्भुत और कष्टों का दमन करने वाले सोमदेव की स्तुति करें जो अपने रस से देवताओं और मनुष्यों को आनंदित करते हैं। 
            वे हमें ऐश्वर्य और शांति प्रदान करने के लिए सदैव तत्पर रहते हैं, और उनकी महिमा भक्तों की श्रद्धापूर्ण वाणी से निरंतर बढ़ती रहती है। 
            जैसे गौएँ अपने बछड़े की ओर प्रेमपूर्वक दौड़ती हैं, वैसे ही हमारी स्तुतियां और हृदय की पुकार सोम की ओर निरंतर प्रवाहित होती हैं। 
            आपकी दिव्य उपस्थिति मात्र से हमारे मन की चंचलता और अशांति समाप्त होती है और हम एकाग्र होकर आपकी असीम सत्ता का अनुभव करते हैं। 
            हे शक्तिशाली सोम (वृषभम्), आप हमारे जीवन रूपी यज्ञ के मुख्य आधार हैं और हमारे अस्तित्व को ऊर्जस्वित करने वाले परम तेजस्वी देव हैं। 
            जैसे बछड़ा अपनी माँ से पोषण और जीवन प्राप्त करता है, वैसे ही हम आपकी कृपा से आध्यात्मिक शांति और भौतिक संपन्नता प्राप्त करते हैं। 
            आपकी उदारता की कोई सीमा नहीं है; आप अपने शरणागत भक्त को वह सब कुछ प्रदान करते हैं जो उसके सर्वांगीण और श्रेष्ठ विकास के लिए आवश्यक है। 
            हम अपनी मधुर और सत्यनिष्ठ वाणी से आपको प्रसन्न करने का निरंतर प्रयास करते हैं ताकि आप हमारे जीवन के समस्त क्लेशों का अंत कर सकें। 
            सोमदेव की पावन शरण में आने वाला साधक कभी रिक्त, निर्बल या असहाय नहीं रहता, उसे ज्ञान के अखंड प्रकाश और अनंत वैभव का वरदान मिलता है। 
            हे आनंद के देवराज, आप हमारे हृदयों में अनन्य भक्ति का संचार करें और हमें सदैव अपनी दिव्य छाया में पूर्णतः सुरक्षित और सुखी रखें।
        """.trimIndent(),
        englishCommentary = """
            O devotees, praise the wonderful Soma, the subduer of afflictions, who delights both gods and humans with his celestial nectar. 
            He remains ever ready to bestow abundance and peace upon us, and his glory is continuously enhanced by the devoted hymns of his followers. 
            Just as cows run affectionately toward their beloved calf, our hymns and heartfelt cries flow toward the presence of Soma. 
            Your divine presence alone terminates the restlessness and turmoil of our minds, allowing us to experience your infinite existence with focus. 
            O Mighty Soma (Vrishabham), you are the primary foundation of the sacrifice of our lives and the supremely radiant deity who energizes us. 
            As a calf receives vital nourishment and life from its mother, we receive spiritual peace and material plenty through your divine favor. 
            There is no limit to your generosity; you bestow upon every surrendered devotee everything necessary for their holistic and superior development. 
            We strive to please you with our sweet and truthful voices so that you may bring a definitive end to all the sufferings of our life. 
            A seeker who takes refuge in Lord Soma never remains empty, weak, or helpless; they are blessed with the light of knowledge and vast abundance. 
            O King of Bliss, infuse our hearts with exclusive devotion and keep us forever protected and happy under your supreme divine shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 9,
        sanskrit = "आ नो मित्रस्य वरुणस्य प्र यंसत् ।\nसोम रयिं सुवीर्यम् ॥ ९ ॥",
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
        id = 10,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ १० ॥",
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
            For us, your devoted chanters, bring forth that nourishing food and powerful vital energy that make our lives meaningful and successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we always remain prosperous, peaceful, and abundant. 
            O God, purify our inner self of all darkness and afflictions and grant us the divine vision to perceive the Presence of the Divine. 
            You are the supreme power that terminates the poverty and ignorance of our existence and leads us to the peaks of plenty and wisdom. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our physical body and soul and leads us toward divinity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary of our duty. 
            O Soma, come into our homes and hearts as the generous giver and grant us that permanent wealth which never perishes with time. 
            Let your light illuminate every dark corner of our existence and show us the pathway leading toward fame, splendor, and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever safe within your laws.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 11,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ११ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें समस्त पापों और उनके द्वारा उत्पन्न होने वाले भयानक संकटों से निरंतर और पूर्णतः सुरक्षित रखने की कृपा करें। 
            जो नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहते हैं, आप उनके प्रति सजग रहकर हमारे चारों ओर एक अभेद्य सुरक्षा कवच बनाएं। 
            हे अजर और अमर देव, आप अपनी अत्यंत तप्त और प्रखर ज्वालाओं से हमारे भीतर के समस्त विकारों और बाहरी विरोधियों को भस्म कर दें। 
            पाप वह गहन अंधकार है जो मनुष्य की बुद्धि को हर लेता है, आप अपनी दिव्य ज्योति से उस अंधकार का समूल विनाश करने की कृपा करें। 
            हम आपकी शरण में आए हैं क्योंकि आपके अतिरिक्त कोई भी हमें कर्मों के इन भयानक बंधनों और दुखों से मुक्त करने का सामर्थ्य नहीं रखता। 
            जैसे अग्नि अशुद्धियों को जलाकर सोने को शुद्ध कर देती है, वैसे ही आप हमारे जीवन के समस्त क्लेशों को नष्ट कर हमें पावन बना दें। 
            आपकी यह तपन हमारे लिए कष्टदायक नहीं, बल्कि हमारे उद्धार के लिए है ताकि हम पूर्णतः शुद्ध, सात्विक और तेजस्वी बन सकें। 
            हे तपिष्ठ, आपकी ज्वालाएं उन दुष्ट प्रवृत्तियों के लिए काल के समान हैं जो धर्म की हानि करना चाहती हैं, हमें सदैव धर्मनिष्ठ बनाए रखें। 
            हमें वह शक्ति और साहस दें कि हम स्वयं कभी भी पाप के मार्ग पर न चलें और सदैव आपकी दिव्य मर्यादाओं में सुरक्षित और सुखी रहें। 
            आपकी कृपा दृष्टि से हमारा कल्याण और आध्यात्मिक उत्थान सुनिश्चित है, हम आपकी इस तेजस्वी शक्ति की बार-बार श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously protect us always and completely from all sins and the terrible calamities arising from them. 
            Be vigilant against those negative forces or enemies who wish us harm, and create an impenetrable protective shield around our lives. 
            O Ageless and Immortal Deity, consume all our internal afflictions and external adversaries with your most intensely hot and radiant flames. 
            Sin is the profound darkness that robs a human of their intellect; graciously destroy that darkness completely with your divine light. 
            We have sought your refuge because none other than you possesses the capability to liberate us from these terrible bonds of action. 
            Just as fire burns away impurities to refine gold, please destroy all the afflictions of our life and make us pure and holy. 
            Your heat is not for our pain but for our ultimate salvation, ensuring we emerge as completely pure, virtuous, and radiant beings. 
            O Most Resplendent One, your flames act as Time itself for those evil tendencies that seek to harm Dharma; keep us always devoted. 
            Grant us the strength and courage to never walk the path of sin ourselves and to always remain safe and happy under your divine laws. 
            Our well-being and spiritual evolution are guaranteed under your merciful gaze; we repeatedly bow before your radiant and majestic power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 12,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ १२ ॥",
        hindiCommentary = """
            हे युवा और उत्तम रीति से आहुति प्राप्त करने वाले अग्निदेव! आप हमें समस्त द्वेषी शक्तियों और शत्रुओं से पूर्णतः सुरक्षित रखने की कृपा करें। 
            आपकी दिव्य ऊर्जा हमारे जीवन में ऐसा सकारात्मक वातावरण बनाए जहाँ कोई भी हमसे ईर्ष्या, नफरत या शत्रुता का भाव न रख सके। 
            हमें वह तेज और सुरक्षा प्रदान करें जिससे हम निर्भीक होकर अपने महान आध्यात्मिक और सांसारिक लक्ष्यों की ओर निरंतर आगे बढ़ सकें। 
            हे यविष्ठ्य, आप ऊर्जा के वह अक्षय स्रोत हैं जो कभी क्षीण नहीं होता, हमें भी अपनी उस अनंत और दिव्य ऊर्जा का एक अंश प्रदान करें। 
            यज्ञ में दी गई हमारी प्रत्येक आहुति आपकी कृपा से ही सार्थक होती है और हमें वह अभीष्ट फल देती है जो हमारे कल्याण के लिए आवश्यक है। 
            आप हमारे जीवन को सुरक्षित और वैभवशाली बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर करें। 
            द्वेष वह विष है जो मनुष्य के आत्मबल और यश को धीरे-धीरे खा जाता है, आप हमें इस विष से मुक्त कर अमृत तुल्य शांति प्रदान करें। 
            आपकी मित्रता हमारे लिए वह अमोघ सुरक्षा कवच है जो संसार की किसी भी नकारात्मक ऊर्जा को हमारे समीप आने से रोकने में समर्थ है। 
            हम आपकी मित्रता और संरक्षण में स्वयं को अत्यंत सौभाग्यशाली मानते हैं और आपकी इस विराट और दयालु महिमा की निरंतर वंदना करते हैं। 
            हे अग्नि, हमें और हमारे समस्त प्रियजनों को अपनी दिव्य छाया में रखें और हमें सदैव सुख-समृद्धि और सत्य के मार्ग पर ले जाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Ever-Youthful Agni, who receives offerings perfectly made, graciously protect us completely from all malicious forces and enemies. 
            May your divine energy create such a positive atmosphere in our lives where none can harbor jealousy, hatred, or enmity toward us. 
            Provide us with the brilliance and security that allow us to fearlessly and continuously advance toward our spiritual and worldly goals. 
            O Youngest One, you are the inexhaustible source of energy that never depletes; please grant us a portion of your infinite and divine power. 
            Every oblation offered in the sacrificial fire becomes meaningful only by your grace and grants us the fruits necessary for our well-being. 
            To make our lives secure and magnificent, expand a circle of your holy light around us and our entire family as a protective shield. 
            Malice is a poison that slowly consumes a person's inner strength and fame; free us from this poison and grant us nectar-like peace. 
            Your friendship is that infallible protective armor for us which is capable of preventing any negative energy of the world from approaching. 
            We consider ourselves extremely fortunate to be under your friendship and protection and continuously worship your vast and kind majesty. 
            O Agni, keep us and all our loved ones under your divine shadow and graciously lead us always on the path of prosperity and Truth.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 13,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ १३ ॥",
        hindiCommentary = """
            हे प्रदीप्त और पवित्र करने वाले अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी और जीवनदायी वैभव हमारे लिए लेकर आने की महान कृपा करें। 
            आप हमें वह पुष्टिकारक अन्न और जीवनी शक्ति प्रदान करें जिससे हमारी आयु लंबी हो और हम सदैव स्वस्थ रहकर धर्म के कार्यों में सक्रिय रहें। 
            आप समस्त ब्रह्मांडीय ऐश्वर्यों के अधिपति हैं, इसलिए हमें वह अद्भुत और विचित्र धन दें जो हमारे जीवन को वैभवशाली और सुखी बना दे। 
            हे पावक, आप हमारे समस्त पापों को अपनी ज्वाला में धोकर हमें दिव्य लोकों की कांति के समान अत्यंत शुद्ध, पवित्र और चमकदार बना दें। 
            आपकी कृपा से हमें वह पोषण प्राप्त हो जिससे हमारा परिवार और समाज दोनों ही पुष्ट, समृद्ध और परस्पर प्रेम के सूत्र में बंधे रहें। 
            आप केवल भौतिक सुख ही नहीं, बल्कि वह आत्मिक तेज भी प्रदान करते हैं जो स्वर्ग के समान सुखद और मोक्ष की ओर ले जाने वाला होता है। 
            हम आपकी निरंतर और अनन्य स्तुति करते हैं ताकि आपकी उदारता और कृपा का प्रवाह हमारे जीवन में सदैव गंगा की धारा की तरह बना रहे। 
            हे देव, आप हमारे दुखों और निराशाओं के अंधकार को अपनी प्रखर ज्योति से समाप्त कर हमें अखंड आनंद और उत्साह के मार्ग पर ले चलें। 
            आपकी पावन उपस्थिति मात्र से ही हमारे जीवन के समस्त अभाव दूर हो जाते हैं और हम पूर्णता तथा ईश्वर के सान्निध्य का अनुभव करने लगते हैं। 
            हे अग्नि, आप हमारे रक्षक और दाता के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और महान बनाने की असीम कृपा करने का कष्ट करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant and Purifying Agni, graciously bring to us a splendor and life-giving prosperity that is as brilliant as the Sun (Vivasvan). 
            Provide us with that nourishing food and vital energy which ensures a long life and keeps us healthy and active in the works of Dharma. 
            You are the sovereign lord of all cosmic riches; therefore, grant us that marvelous and extraordinary wealth that makes our lives blissful. 
            O Purifier, wash away all our sins in your flames and make us as pure, holy, and glowing as the radiance of the highest celestial realms. 
            By your grace, let us receive that nourishment which makes both our families and our society robust, prosperous, and united in love. 
            You do not just provide material comforts; you also grant that spiritual luster which is as pleasant as heaven and leads toward liberation. 
            We constantly sing your exclusive praises so that the flow of your immense generosity remains forever present in our lives like a sacred river. 
            O God, terminate the darkness of our sorrows and despairs with your intense light and lead us onto the path of unbroken joy and enthusiasm. 
            Your mere presence dissolves all the scarcities of our existence, making us experience a profound sense of completeness and divine proximity. 
            O Agni, always remain with us as our protector and provider, graciously making our lives magnificent, successful, and noble.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 14,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ १४ ॥",
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
            O Youngest One, your energy is what brings completeness, abundance, and self-contentment into every single field of our existence and being. 
            Worshipping you ensures the fulfillment of all our noble resolutions and grants us all-around development; this is your true divine glory. 
            Just as fire blazes brighter when fueled with wood, our soul becomes stronger and more vibrant under your divine inspiration and proximity. 
            Grant us that mental expansion and generosity which allows us to rise above narrow selfishness and work for the welfare of the entire world. 
            Elevate our consciousness to that high level where we can experience the omnipresence of God and see your image in every living entity. 
            You are the power that possesses the capability to transform our hard labor and honesty into divine blessings and magnificent successes. 
            O Agni, we adore you repeatedly so that our lives remain nourished, prosperous, meaningful, and completely righteous in every aspect.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 15,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ १५ ॥",
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
            For us, your devoted chanters, bring forth that powerful inspiration, virtuous food, and energy that makes our lives successful and ascending. 
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
        id = 16,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ १६ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप समस्त मानवीय यज्ञों और अनुष्ठानों के मुख्य पुरोहित (होता) और देवताओं को आह्वान करने वाले दिव्य और पवित्र दूत हैं। 
            आप हम मनुष्यों के बीच रहकर भी हमारा संबंध स्वर्ग के देवताओं से जोड़ते हैं, आप ही वास्तव में हमारे सबसे सच्चे और परम हितैषी देव हैं। 
            आपकी पावन उपस्थिति के बिना हमारा कोई भी यज्ञ, संकल्प या शुभ कर्म कभी पूर्ण नहीं हो सकता, क्योंकि आप ही यज्ञ की आत्मा और आधार हैं। 
            हे देव, आप हमारे भीतर दिव्य और सात्विक प्रवृत्तियों का विकास करें और हमें असुरत्व तथा बुराइयों के प्रभाव से सदैव सुरक्षित बचाकर रखें। 
            आपकी हितकारी दृष्टि हमें पतन और अज्ञान के मार्ग से हटाकर निरंतर प्रगति, आत्मोन्नति, सुख और शांति की दिशा में सफलतापूर्वक अग्रसर करती है। 
            जैसे अग्नि अशुद्धियों को जलाकर भस्म कर देती है, वैसे ही आप हमारे समस्त शारीरिक और मानसिक कर्मों को शुद्ध, पवित्र और कल्याणकारी बना दें। 
            हम आपकी वंदना करते हैं क्योंकि आप ही हमारे परिवारों में एकता, प्रेम, सुख-शांति और धार्मिक निष्ठा के मुख्य स्तंभ और परम रक्षक हैं। 
            आपकी दिव्य ऊर्जा हमारे प्राणों में चेतना बनकर निरंतर बहती है और हमें सदैव सत्य, न्याय और मानवता के मार्ग पर चलने की प्रेरणा प्रदान करती है। 
            हे अग्नि, आप हमारे सर्वोच्च गुरु और मार्गदर्शक बनकर हमें वह सत्य दिखाएं जहाँ हम ईश्वर की सर्वव्यापकता का साक्षात् अनुभव करने में सफल हों। 
            आपकी कृपा से हमारा जीवन दिव्य आशीषों से भरा रहे और हम सदैव मानवता की निस्वार्थ सेवा और धर्म की रक्षा के पुनीत कार्यों में लगे रहें।
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
        id = 17,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ १७ ॥",
        hindiCommentary = """
            हे दिव्य अग्निदेव! आप हमारे मन के समस्त द्वेष, क्रोध, अशांति और संशयों को शांत कर उसे अत्यंत निर्मल, पवित्र और शांत बना देने की कृपा करें। 
            आप हमें वह दृढ़, अटल और अडिग श्रद्धा प्रदान करें जिससे हम ईश्वर की न्यायपूर्ण व्यवस्था पर पूर्ण विश्वास कर सकें और सदैव सुखमय जीवन जिएं। 
            हमें उन सभी नकारात्मक शक्तियों और विचारों से सुरक्षित रखें जो हमारे मार्ग में बाधा डालती हैं और हमें धर्म के पथ से डिगाना चाहती हैं। 
            आपकी कृपा से ही मनुष्य का हृदय समस्त जीवों के प्रति निस्वार्थ प्रेम और करुणा से भर जाता है, हमें भी वही विशाल और दयालु हृदय प्रदान करें। 
            हे देव, श्रद्धा ही वह दिव्य कुंजी है जिससे ईश्वर के रहस्य प्रकट होते हैं, कृपया हमारे भीतर इस श्रद्धा की ज्योति को सदैव अखंड और जीवित रखें। 
            हम ईर्ष्या की विनाशकारी आग में जलने के बजाय आपके ज्ञान के प्रकाश में तपकर स्वयं को कुंदन की तरह श्रेष्ठ, तेजस्वी और महान व्यक्तित्व वाला बनाएं। 
            जब हमारा मन आपकी अटूट भक्ति और प्रेम में डूबा होता है, तब संसार का कोई भी अभाव, दुख या पीड़ा हमें अपनी शांति से विचलित नहीं कर सकती। 
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
        id = 18,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ १८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त और अज्ञान के संकटों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त और पवित्र ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, new energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage and deep mental peace. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 19,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ १९ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम कल्याण के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा उठें। 
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually higher. 
            O Agni, give us the luster to keep ourselves established in Dharma and to lead a glorious and meaningful life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 20,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ २० ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करें। 
            आप हमें वह जीवनी शक्ति और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ बने रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी देते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम आपकी शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve Dharma. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your guidance. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 21,
        sanskrit = "एते असृग्रमिन्दवस्तिरः पवित्रमाशवः ।\nविश्वान्यभि सौभगा ॥ २१ ॥",
        hindiCommentary = """
            ये अत्यंत तीव्र गति वाले सोमरस (इन्दवः) पवित्र छननी के माध्यम से निरंतर प्रवाहित हो रहे हैं। 
            इनका उद्देश्य हमें संसार के समस्त प्रकार के सौभाग्य, सुख और ऐश्वर्य (सौभगा) प्रदान करना है। 
            जैसे सोम की धाराएं पात्र में गिरती हैं, वैसे ही ईश्वर की कृपा हमारे जीवन के पात्र में गिरनी चाहिए। 
            पवित्रता ही वह माध्यम है जिससे ईश्वरीय शक्तियाँ हमारे निकट आती हैं और हमें अनुगृहीत करती हैं। 
            हे सोम, आप हमारे मन की चंचलता को शुद्ध कर उसे एकाग्र और दिव्य लक्ष्यों के प्रति समर्पित बना दें। 
            आपका यह प्रवाह अज्ञान के परदों को हटाकर हमें सत्य के दर्शन कराने में परम सहायक सिद्ध होता है। 
            हम आपकी वंदना करते हैं क्योंकि आप ही आनंद के अधिपति हैं और भक्तों के दुखों को हरने वाले हैं। 
            यज्ञ की इस अग्नि में आपकी आहुति समस्त देवताओं को पुष्ट करती है और ब्रह्मांड को ऊर्जा देती है। 
            हमें वह आध्यात्मिक सामर्थ्य प्रदान करें जिससे हम संसार के द्वंद्वों से ऊपर उठकर सदैव शांत रह सकें। 
            हे पवमान सोम, आपकी यह तेजस्वी धारा हमारे घरों को शांति और समृद्धि से भर देने वाली उदार शक्ति बने।
        """.trimIndent(),
        englishCommentary = """
            These swift-flowing Soma drops are moving through the sacred filter with great speed and purity. 
            Their ultimate purpose is to bring all forms of good fortune, happiness, and prosperity (Saubhaga) into our lives. 
            Just as the streams of Soma fall into the ritual vessel, may the grace of the Divine pour into the vessel of our existence. 
            Purity is the only medium through which divine forces approach us and bless our sincere spiritual efforts. 
            O Soma, purify the restlessness of our minds and make them focused and dedicated to divine and noble goals. 
            This flow of yours is a supreme aid in removing the veils of ignorance and allowing us to perceive the Ultimate Truth. 
            We worship you because you are the Lord of Bliss and the one who terminates the worldly sufferings of your devotees. 
            Your oblation in this sacrificial fire nourishes all the gods and provides vitalizing energy to the entire cosmos. 
            Grant us that spiritual capability through which we can rise above worldly dualities and remain forever peaceful. 
            O Pavamana Soma, let this radiant stream of yours become the generous power that fills our homes with peace and plenty.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 22,
        sanskrit = "अभि प्र मन्दिनं गिरः सोमं पवस्व धारया ।\nइन्द्राय पातवे सुतम् ॥ २२ ॥",
        hindiCommentary = """
            हे सोम! आप हमारी स्तुतियों (गिरः) के साथ अत्यंत आनंददायक (मन्दिनं) होकर अपनी धारा के साथ प्रवाहित हों। 
            आप इन्द्रदेव के पान करने के लिए (पातवे) उत्तम रीति से तैयार किए गए हैं, कृपया उन्हें तृप्त करने के लिए प्रस्थान करें। 
            इन्द्र और सोम का मिलन शक्ति और आनंद के उस अद्भुत संगम का प्रतीक है जो असुरों के विनाश के लिए अनिवार्य है। 
            जब आप इन्द्र की नसों में प्रवाहित होते हैं, तो वे अजेय बन जाते हैं और हमारे जीवन के शत्रुओं का दमन करते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण को शुद्ध कर हमें दिव्य अनुभूतियों के योग्य बनाने की सामर्थ्य रखती है। 
            हे देव, आप हमारे यज्ञ को सफल बनाएं और हमारे संकल्पों को देवताओं के महान आशीर्वादों के साथ जोड़ दें। 
            हमारी वाणी में वह सत्य और ओज भर दें कि हमारी पुकार सीधे आपके और इन्द्र के हृदय तक पहुँच सके। 
            आप ही वह अमृत हैं जो मृत्यु के भय को समाप्त कर मनुष्य को अमरता के पथ पर अग्रसर करता है। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का प्रवाह हमारे जीवन में निरंतर और शाश्वत बना रहे। 
            हे पवमान सोम, आप हमारे रक्षक और मार्गदर्शक बनकर हमें सफलता और दिव्यता के उच्चतम शिखर पर पहुँचाएं।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your sacred stream, accompanied by our devoted hymns (Girah), becoming most exhilarating and pleasant. 
            You have been perfectly extracted (Sutam) for the consumption of Lord Indra; please proceed to satisfy him. 
            The union of Indra and Soma represents that marvelous confluence of power and bliss essential for the destruction of evil. 
            When you flow through the being of Indra, he becomes invincible and subdues the internal and external enemies of our lives. 
            This holy stream of yours possesses the power to purify our inner self and make us worthy of profound divine realizations. 
            O God, make our sacrifice successful and connect our resolutions with the magnificent blessings of the celestial gods. 
            Fill our voices with such truth and vigor that our calls reach directly into your heart and the heart of Lord Indra. 
            You are the nectar that terminates the fear of death and drives a human forward on the path toward immortality. 
            We worship you with devotion so that the flow of your immense generosity remains forever constant and eternal in our lives. 
            O Pavamana Soma, stay as our protector and guide, leading us graciously to the highest peaks of success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 23,
        sanskrit = "तं वो मदाय घृष्वये सोमं विश्वाभिरूतिभिः ।\nइन्द्राय गायत सुतम् ॥ २३ ॥",
        hindiCommentary = """
            हे स्तोताओं! आप इन्द्र के उस 'घृष्वये' (शत्रुओं को कुचलने वाले) मद के लिए सोमरस का भक्तिपूर्वक गान करें। 
            आप समस्त रक्षात्मक शक्तियों (विश्वाभिरूतिभिः) के साथ इस पवित्र रस को इन्द्र के पान के लिए समर्पित करें। 
            इन्द्र की प्रसन्नता ही जगत के संतुलन का आधार है, और सोम ही उनकी उस प्रसन्नता और शक्ति का मुख्य स्रोत है। 
            जब हम मिल-जुलकर आपकी महिमा गाते हैं, तो हमारे चारों ओर एक अत्यंत सकारात्मक और ऊर्जावान सुरक्षा चक्र बनता है। 
            हे देव, आप अपनी प्रचंड शक्ति से हमारे जीवन के समस्त अमंगल और दारिद्रय को भस्म करने की महान कृपा करें। 
            आपकी रक्षात्मक शक्तियाँ हमारे संकल्पों को वह दृढ़ता प्रदान करती हैं जिससे हम धर्म के मार्ग पर कभी विचलित नहीं होते। 
            हम अपनी विनम्र प्रार्थनाओं से आपको पुकारते हैं ताकि आप हमारे जीवन के प्रत्येक अभाव को अपनी उदारता से पूर्ण कर दें। 
            आप ही वह सर्वोच्च सत्ता हैं जो हमारे परिश्रम को सार्थकता प्रदान करती हैं और हमें उन्नति के पथ पर निरंतर आगे बढ़ाती हैं। 
            हे सोम, आप अपनी अनंत महिमा के साथ हमारे घर और हृदय में विराजें और हमें सदैव अपनी दिव्य सुरक्षा में रखें। 
            आपकी कृपा दृष्टि से हमारा कल्याण सुनिश्चित है, हम आपकी इस भव्य और आनंदमयी शक्ति की बार-बार श्रद्धा से वंदना करते हैं।
        """.trimIndent(),
        englishCommentary = """
            O singers of hymns, chant devotedly for that exhilarating joy of Indra which subdues and crushes all enemies (Ghrishvaye). 
            Dedicate this extracted Soma for Indra's consumption along with all the diverse protective divine powers (Utibhih). 
            The satisfaction of Lord Indra is the foundation of cosmic balance, and Soma is the primary source of that joy and might. 
            When we collectively sing your glories, an extremely positive and energetic protective circle is formed around our lives. 
            O God, with your fierce power, please graciously burn away all the inauspiciousness and poverty from our existence. 
            Your protective energies provide our resolutions with that firmness through which we never waver from the path of Dharma. 
            We invoke you with our humble supplications so that you may fulfill every single scarcity of our life with your generosity. 
            You are the supreme authority that makes our hard work meaningful and continuously drives us forward on the path of growth. 
            O Soma, reside in our homes and hearts with your infinite glory and keep us forever safe under your divine protection. 
            Our well-being is guaranteed under your merciful gaze; we repeatedly bow before your magnificent and blissful power.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 24,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ २४ ॥",
        hindiCommentary = """
            हे पवमान कवि (क्रांतदर्शी) सोम! आपकी शक्तिशाली और पवित्र लहरें (ऊर्मिणः) रत्नों की कामना करती हुई प्रवाहित हो रही हैं। 
            आप स्वयं ज्ञान के पुंज हैं और जब आप अपनी तरंगों के साथ बहते हैं, तो आप देवताओं के प्रिय और उपासकों के रक्षक बन जाते हैं। 
            जैसे समुद्र की लहरें तट पर बहुमूल्य वस्तुएं लाती हैं, वैसे ही आपकी धारा हमारे जीवन में आध्यात्मिक रत्न और सद्गुण लाती है। 
            हे देव, आपकी ये पावन लहरें हमारे मन के समस्त संताप और अज्ञान को बहा ले जाएं और हमें शांति के सागर में डुबो दें। 
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करती है जिससे हम संसार के मायाजाल को भेदकर सत्य के वास्तविक स्वरूप को देख पाते हैं। 
            हमें वह 'रत्न' (ज्ञान और वैराग्य) प्रदान करें जो हमारे चरित्र को उज्ज्वल बनाएँ और समाज में हमें प्रतिष्ठित करें। 
            आप ही वह शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों में बदलने का अद्भुत और अमोघ सामर्थ्य रखती हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी कृपा की वर्षा हमारे जीवन और परिवार में सदैव निरंतर बनी रहे। 
            जैसे तरंगें निरंतरता का प्रतीक हैं, वैसे ही हमारी भक्ति भी आपके प्रति निरंतर और अटूट बनी रहे, यही हमारी प्रार्थना है। 
            हे दिव्य सोम, आप अपनी इन पावन लहरों के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे परमात्मा के सान्निध्य के योग्य बनाएं।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Kavi (wise seer) Soma, your powerful and holy waves (Urminah) flow forth, seeking treasures and divine riches. 
            You are the mass of ultimate knowledge, and as you flow with your ripples, you become dear to the gods and a protector of seekers. 
            Just as ocean waves bring precious objects to the shore, your sacred current brings spiritual gems and virtues into our lives. 
            O God, let these waves wash away all the heat of our sorrows and ignorance, immersing us completely in the ocean of peace. 
            Your energy provides us with the capability to pierce through the illusions of the world and perceive the actual nature of Truth. 
            Bestow upon us those 'gems' (knowledge and detachment) that refine our character and earn us a place of honor in society. 
            You are the power that possesses the capability to transform our subtle intentions into cosmic achievements and realizations. 
            We worship you with devotion so that the rain of your grace remains continuous and unbroken within our lives and families. 
            Just as waves represent continuity, may our devotion toward you remain constant and unbreakable; this is our humble prayer. 
            O Divine Soma, through these holy waves of yours, purify our inner self and make it worthy of the divine proximity of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 25,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ २५ ॥",
        hindiCommentary = """
            हे सोमदेव! आप वाणी के अधिपति और ज्ञान के विशाल समुद्र होकर अपनी दिव्य चेतना के साथ पवित्र होकर प्रवाहित हों। 
            आप दिव्य गर्जना करते हुए अपने मूल स्थान पर विराजमान हों, जो आपकी अजेय शक्ति और सर्वोच्चता का साक्षात् प्रतीक है। 
            आप ही वह ऊर्जा हैं जो ऋषियों के कंठ में वेदमंत्रों का संचार करती हैं और उन्हें जगत के कल्याण के लिए प्रेरित करती हैं। 
            जैसे समुद्र अथाह और रहस्यों से भरा होता है, वैसे ही आपका स्वरूप भी अनंत है, जो हमें आध्यात्मिक शांति प्रदान करने वाला है। 
            हे देव, आप हमारे विचारों में सत्य की वाणी बनकर विराजें ताकि हम सदैव मंगलकारी और कल्याणकारी मार्ग पर ही चलें। 
            आपकी गर्जना हमारे भीतर के अज्ञान और तमस को जगाकर हमें आत्मज्ञान और साधना के मार्ग पर सक्रिय कर देने वाली है। 
            हमें वह मेधा शक्ति प्रदान करें जिससे हम वेदों के गूढ़ अर्थों को समझ सकें और अपने जीवन को उनके अनुरूप ढाल सकें। 
            आपकी कृपा से हमारा मन एक शांत और गहरे सरोवर की तरह बन जाए जिसमें आपकी भक्ति का प्रकाश सदैव जगमगाता रहे। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं क्योंकि आप ही हमारे अंतःकरण को शुद्ध कर उसे दिव्यता के निवास योग्य बनाते हैं। 
            हे पवमान सोम, आप अपनी अनंत महिमा के साथ हमारे इस यज्ञ में प्रतिष्ठित हों और हमें परम ज्ञान का आशीर्वाद प्रदान करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, flow in your purified state with divine consciousness, being the leader of speech and the vast ocean of wisdom. 
            Seat yourself upon your primal source with a celestial roar, symbolizing your invincible power and ultimate supremacy. 
            You are the energy that infuses Vedic mantras into the throats of the seers and inspires them for the welfare of the world. 
            Just as the ocean is fathomless and filled with mysteries, your nature is infinite and capable of granting us spiritual peace. 
            O God, reside in our thoughts as the voice of Truth so that we may always walk on the path of auspiciousness and benevolence. 
            Your roar awakens us from internal ignorance and darkness, activating us on the path of Self-realization and discipline. 
            Bestow upon us that intellectual capability through which we can understand the deep meanings of the Vedas and shape our lives. 
            By your grace, may our minds become like a calm and deep lake in which the light of your devotion shines forever. 
            We worship you with devotion because you are the one who purifies our inner self and makes it a fit dwelling for divinity. 
            O Pavamana Soma, reside in our sacrifice with your infinite glory and grant us the blessings of supreme and holy knowledge.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 26,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ २६ ॥",
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
        id = 27,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ २७ ॥",
        hindiCommentary = """
            हे पवमान और पावक (पवित्र करने वाले) सोमदेव! आप स्वर्ग की दिव्य कांति के समान अद्भुत ऐश्वर्यों के परम स्वामी हैं। 
            आप हम स्तुति करने वाले भक्तों के लिए वह शक्तिशाली अन्न और जीवनी शक्ति लेकर आएं जो हमारे जीवन को सफल बनाए। 
            आपकी कृपा से हमारे जीवन में किसी भी वस्तु का अभाव न रहे और हम सदैव सुख, शांति और समृद्धि से परिपूर्ण बने रहें। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम परमात्मा की सर्वव्यापकता का अनुभव कर सकें। 
            आप ही वह शक्ति हैं जो हमारे जीवन की दरिद्रता और अज्ञान को समाप्त कर हमें प्रचुरता के शिखर पर पहुँचाने में समर्थ हैं। 
            हमें वह 'इषम्' (प्रेरणा और पोषण) प्रदान करें जो हमारे शरीर और आत्मा दोनों को तृप्त कर हमें दिव्यता की ओर ले जाने वाला हो। 
            आपकी महिमा का निरंतर गान करने से हमारे दुखों का नाश होता है और हमें वह नवीन उत्साह मिलता है जो कभी कम नहीं होता। 
            हे सोम, आप हमारे घर और हृदय में एक उदार दाता के रूप में पधारें और हमें वह स्थायी संपत्ति दें जो कभी नष्ट न हो। 
            आपकी ज्योति हमारे जीवन के प्रत्येक अंधकारमय कोने को प्रकाशित कर हमें वैभव और ईश्वर की ओर ले जाने वाला मार्ग दिखाए। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं कि आप हमें अपनी दिव्य छाया में रखें और हमारा मंगलमय जीवन सदैव सुरक्षित रहे।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana and Purifying Soma, you are the supreme master of marvelous riches that shine like celestial luster. 
            For us, your devoted chanters, bring forth that powerful nourishment and vital energy that make our lives successful. 
            By your grace, let there be no scarcity of any kind in our lives, and may we remain forever full of peace and prosperity. 
            O God, purify our inner self and grant us the divine vision to experience the omnipresence of the Supreme Being. 
            You are the power that possesses the strength to terminate the poverty and ignorance of our life and lead us to plenty. 
            Provide us with 'Isham'—divine inspiration and sustenance—that satisfies both our body and soul and leads us toward divinity. 
            Singing your glories destroys our sorrows and grants us a renewed sense of enthusiasm that ensures we never grow weary. 
            O Soma, come into our homes and hearts as the generous giver and grant us that permanent wealth which never perishes. 
            Let your light illuminate every dark corner of our existence and show us the pathway leading toward splendor and God. 
            We pray with devotion that you keep us under your divine shadow and that our auspicious life remains forever protected.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 28,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ २८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त और अज्ञान के संकटों से सदैव सुरक्षित रखने की अपनी महान कृपा बनाए रखें। 
            जो नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें बचाएं। 
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
        id = 29,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ २९ ॥",
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
        id = 30,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ३० ॥",
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
        id = 31,
        sanskrit = "आ ते वत्सो मनो यमत् परमाच्चित् सधस्थात् ।\nअग्ने त्वां कामये गिरा ॥ ३१ ॥",
        hindiCommentary = """
            हे अग्निदेव! भक्त का मन और उसकी वाणी आपको सर्वोच्च धाम से अपने हृदय में बुलाने के लिए निरंतर व्याकुल और प्रतीक्षारत है। 
            जैसे वत्स (बछड़ा) अपनी माता के लिए पुकार लगाता है, वैसे ही हम अपनी पवित्र वाणी (गिरा) से आपकी उपस्थिति की कामना करते हैं। 
            आपकी दिव्यता हमारे जीवन को स्पर्श करे और हमारे अंतःकरण में ज्ञान का अखंड दीप प्रज्वलित कर हमें अंधकार से मुक्त कर दे। 
            हम संसार की नश्वर और क्षणभंगुर वस्तुओं के बजाय आपके शाश्वत प्रेम और सान्निध्य की ही निरंतर इच्छा और प्रार्थना करते हैं। 
            हे देव, आप अपनी महिमा के शिखर से उतरकर हमारे तुच्छ जीवन को अपनी पावन उपस्थिति से कृतार्थ और धन्य करने की कृपा करें। 
            हमारी स्तुतियां केवल शब्द नहीं, बल्कि हमारे हृदय की वह गहन पुकार हैं जो आपको साक्षात् यहाँ आने के लिए विवश कर देती हैं। 
            आप ही वह परमानंद हैं जिसे प्राप्त करने के बाद मनुष्य को इस नश्वर संसार में अन्य कुछ भी पाने की लेशमात्र भी इच्छा नहीं रहती। 
            आपकी कृपा से हमारी वाणी में वह तेज और सत्यता आए कि वह सीधे आपके दिव्य कानों तक पहुँच सके और हमारा मार्ग प्रशस्त हो। 
            हमें वह आध्यात्मिक प्यास प्रदान करें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें पूर्णतः तृप्त कर दे। 
            हे अग्नि, आप हमारी इन प्रार्थनाओं को सहर्ष स्वीकार करें और हमारे संपूर्ण जीवन को अपनी दिव्य चेतना से सदा के लिए आलोकित करें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the mind and voice of the devotee are restless to call you from your supreme celestial abode into their waiting heart. 
            Just as a calf calls out for its mother with pure longing, we intensely desire and seek you with our sacred and holy speech. 
            May your divinity touch our lives and ignite the eternal lamp of knowledge within our deepest consciousness, freeing us from darkness. 
            Instead of worldly and perishable objects, we continuously long for your eternal love and divine presence as our ultimate goal. 
            O God, descend from the peak of your glory and bless our humble lives with your most sacred and holy presence today. 
            Our praises are not just mere words; they are the desperate cries of our hearts that compel you to manifest personally before us. 
            You are that supreme bliss after attaining which a human possesses no further desire to seek anything else in the entire material world. 
            By your grace, let our speech gain such brilliance and truth that it reaches directly into your divine ears, clearing our path. 
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence, leading us to absolute satisfaction. 
            O Agni, accept our humble prayers and illuminate our entire existence with your profound and divine consciousness forever.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 32,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ३२ ॥",
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
        id = 33,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ३३ ॥",
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
        id = 34,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ३४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त और अज्ञान के संकटों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त और पवित्र ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
            आपकी अग्नि केवल विनाश नहीं करती, बल्कि वह जीवन को एक नई दिशा, नई ऊर्जा और पूर्ण पावनता प्रदान कर मनुष्य का नया आध्यात्मिक जन्म करती है। 
            हम आपकी शरण में आकर पूर्ण सुरक्षा की याचना करते हैं क्योंकि आप ही समस्त लोकों के रक्षक, पालनहार और ब्रह्मांडीय न्याय के सर्वोच्च प्रहरी हैं। 
            हमें वह आत्मबल और साहस प्रदान करें जिससे हम कभी भी अधर्म या असत्य के मार्ग पर न चलें और सदैव आपकी दिव्य आज्ञाओं का पालन करते रहें। 
            आपकी ज्योति हमारे चारों ओर एक ऐसा अभेद्य सुरक्षा कवच बनाए जिसे संसार की कोई भी आसुरी शक्ति या विचार कभी भी भेद न सके, यही प्रार्थना है। 
            हे तपिष्ठ, आपकी ज्वालाएं सत्य की विजय और न्याय की स्थापना के लिए सदैव तत्पर रहती हैं, हमें भी सत्य का एक सच्चा और निष्ठावान योद्धा बनाएं। 
            जीवन के प्रत्येक संघर्ष और कठिन परीक्षा में आपकी रक्षात्मक शक्ति का अनुभव हमें अटूट साहस, मानसिक शांति और निरंतर प्रेरणा प्रदान करता है। 
            हे अग्नि, आप हमारे परम रक्षक हैं, हमें अज्ञान के अंधकार से ज्ञान के प्रकाश की ओर और मृत्यु के भय से अमरत्व के दिव्य आनंद की ओर ले चलें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, please graciously and continuously maintain your great protection over us from the terrible pit of sins and the calamities of ignorance. 
            Those negative forces that wish us harm, please foil all their conspiracies with your supreme intelligence and provide us with security. 
            O Ageless and Radiant Deity, consume all our internal flaws, mental afflictions, and evils from the root with your most intensely hot flames. 
            Your fire does not just destroy; it provides life with a new direction, new energy, and absolute purity, leading to a new spiritual birth. 
            We seek your refuge and pray for complete security, for you are the guardian of all worlds and the supreme sentinel of cosmic justice. 
            Grant us the inner strength and courage to never walk the path of unrighteousness or untruth and to always obey your divine commands. 
            Let your light create an impenetrable shield of protection around us that no demonic force or thought of the world can ever pierce through. 
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth. 
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage and deep mental peace. 
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 35,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ३५ ॥",
        hindiCommentary = """
            हे युवा और तेजस्वी अग्निदेव! आप हमारी उत्तम आहुतियों को स्वीकार कर हमें उन शक्तियों से बचाएं जो हमसे ईर्ष्या या द्वेष का भाव रखती हैं। 
            आपकी दिव्य ऊर्जा हमें वह अद्भुत सामर्थ्य प्रदान करे जिससे हम जीवन की समस्त चुनौतियों और विघ्नों का निर्भीकता से सामना कर विजयी हो सकें। 
            हमें वह आंतरिक शुद्धता और मानसिक विशालता दें जिससे हमारे मन में दूसरों के प्रति कभी भी संकीर्णता, घृणा या बुरी भावना उत्पन्न न होने पाए। 
            हे यविष्ठ्य, आपकी अक्षय और आदि शक्ति ही हमारे संपूर्ण जीवन का आधार है, हमें अपनी उस दिव्य सामर्थ्य का एक छोटा अंश प्रदान करने की कृपा करें। 
            यज्ञ की अग्नि में अर्पित हमारी प्रत्येक आहुति आपकी कृपा से ही सिद्ध होती है और हमें वह अभीष्ट फल प्रदान करती है जो हमारे परम कल्याण के लिए हो। 
            आप हमारे जीवन को पूर्णतः सुरक्षित और समृद्ध बनाने के लिए अपनी पवित्र ज्योति का एक सुरक्षा घेरा हमारे और हमारे परिवार के चारों ओर निरंतर रखें। 
            द्वेष की भावना मनुष्य की प्रगति को रोककर उसे अंधकार में ढकेल देती है, आप हमें इस अंधकार से निकालकर सफलता और प्रकाश की ओर ले चलें। 
            आपकी मित्रता हमारे लिए वह दिव्य सुरक्षा और औषधि है जो हमारे मन के समस्त भयों, संशयों और दुखों को सदा के लिए जड़ से समाप्त कर देती है। 
            हम श्रद्धापूर्वक आपकी प्रार्थना करते हैं ताकि हमारा जीवन सदैव निस्वार्थ सेवा और भक्ति में लगा रहे और हम निरंतर आत्मिक रूप से ऊँचा उठें। 
            हे अग्नि, हमें वह तेज दें कि हम स्वयं को धर्म में प्रतिष्ठित रख सकें और मानवता की सेवा करते हुए एक गौरवशाली और सार्थक जीवन व्यतीत करें।
        """.trimIndent(),
        englishCommentary = """
            O Youthful and Radiant Agni, accepting our best offerings, protect us from those forces that harbor envy or malice toward our well-being. 
            May your divine energy provide us with that amazing capability to face all of life's challenges and hurdles with absolute fearlessness. 
            Grant us that internal purity and mental vastness which ensures that no narrowness, hatred, or ill-will ever arises in our minds toward others. 
            O Youngest One, your inexhaustible and primordial power is the foundation of our existence; grant us a portion of your divine strength. 
            Every oblation offered in the sacrificial fire is fulfilled by your grace and leads us to the achievement of goals meant for our ultimate welfare. 
            Create a continuous circle of your sacred and holy light around us and our families to make our lives completely secure and prosperous. 
            The feeling of malice halts a person's progress and pushes them into darkness; lead us out of this darkness and toward the path of success. 
            Your friendship is that divine security and medicine for us which uproots all the fears, doubts, and sorrows of our wandering mind forever. 
            We pray to you with devotion so that our life remains dedicated to selfless service and devotion, helping us to rise spiritually higher. 
            O Agni, give us the luster to keep ourselves established in Dharma and to lead a glorious and meaningful life while serving entire humanity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 36,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ३६ ॥",
        hindiCommentary = """
            हे प्रदीप्त अग्निदेव! आप सूर्य (विवस्वान) के समान तेजस्वी, प्रचंड और जीवनदायी ऐश्वर्य हमारे घर, परिवार और हृदय में लेकर आने की महान कृपा करें। 
            आप हमें वह जीवनी शक्ति और आरोग्य प्रदान करें जिससे हम लंबी आयु तक स्वस्थ और क्रियाशील रहकर श्रेष्ठ धर्म और मानवता के कर्म कर सकें। 
            आप स्वर्ग के अनुपम वैभव और समस्त ब्रह्मांडीय धन के सर्वोच्च अधिपति हैं, हमें वह सुख प्रदान करें जो अविनाशी हो और जो हमें आत्मिक शांति दे। 
            हे पावक, आपकी पवित्रता हमारे रोम-रोम में समा जाए और हमें पूर्णतः निर्मल, कांतिवान और आध्यात्मिक ऊर्जा से ओत-प्रोत बना देने की कृपा करे। 
            आपकी कृपा से हमारे जीवन में किसी भी संसाधन या अन्न की कमी न रहे और हम सदैव दूसरों की सहायता और सेवा करने के लिए पूर्णतः समर्थ बने रहें। 
            आप केवल बाहरी धन ही नहीं, बल्कि वह प्रज्ञा, विवेक और उच्चतर ज्ञान भी देते हैं जो हमें मोक्ष और परम सत्य के साक्षात्कार के मार्ग पर ले जाता है। 
            हम निरंतर आपकी महिमा का गान करते हैं ताकि हमारा जीवन सदैव भक्ति और ज्ञान के अखंड प्रकाश से जगमगाता रहे और हम सदैव आपकी शरण में रहें। 
            हे देव, आप हमारे दुखों की काली छाया को सदा के लिए समाप्त कर हमारे जीवन में हर्ष, आनंद और नवीन उत्साह का दिव्य अमृत निरंतर घोलते रहें। 
            आपकी दीप्ति हमारे अज्ञान के पर्दों को हटाकर हमें वह स्पष्टता प्रदान करे जिससे हम ईश्वर की अनंत सत्ता को पहचान सकें और सदा शांत रह सकें। 
            हे अग्नि, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आध्यात्मिक रूप से पूर्ण बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Radiant Agni, bring into our homes, families, and hearts a splendor and prosperity as brilliant, fierce, and life-giving as the Sun. 
            Provide us with the vital energy and health that allow us to stay healthy and active for a long life to perform noble deeds and serve Dharma. 
            You are the sovereign lord of the unique abundance of heaven and all cosmic wealth; grant us that joy which is imperishable and peaceful. 
            O Purifier, let your holiness permeate every cell of our being, making us completely pure, radiant, and overflowing with spiritual energy. 
            By your grace, let there be no lack of resources or food in our lives, ensuring we are always capable of serving and assisting others. 
            You do not just provide external wealth; you also grant that wisdom, discernment, and higher knowledge which lead us toward liberation. 
            We constantly sing your glories so that our life remains forever illuminated with the light of devotion and knowledge under your guidance. 
            O God, eliminate the dark shadows of our sorrows forever and infuse our lives with the nectar of divine joy, bliss, and renewed enthusiasm. 
            Let your radiance erase the veils of our ignorance and grant us that clarity which enables us to recognize the infinite Reality of the Divine. 
            O Agni, always remain with us as our protector and nourisher, making our lives magnificent, successful, and spiritually complete.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 37,
        sanskrit = "एते असृग्रमिन्दवस्तिरः पवित्रमाशवः ।\nविश्वान्यभि सौभगा ॥ ३७ ॥",
        hindiCommentary = """
            हे पवमान सोम! ये तीव्र गति वाले सोम के कण पवित्र छननी के माध्यम से निरंतर प्रवाहित होकर समस्त प्रकार के सौभाग्य लेकर आ रहे हैं। 
            इनका यह वेगपूर्ण प्रवाह हमारे जीवन की जड़ता को नष्ट कर उसमें गतिशीलता और दिव्यता का संचार करने के लिए अत्यंत महत्वपूर्ण है। 
            जैसे सोम की धाराएं पात्र में गिरकर उसे भर देती हैं, वैसे ही आपकी कृपा हमारे जीवन को पूर्णता और प्रचुरता से भर देने वाली हो। 
            पवित्रता ही वह प्रथम द्वार है जिससे ईश्वरीय शक्तियाँ हमारे भीतर प्रवेश करती हैं और हमारे चरित्र का निर्माण उच्च आदर्शों पर करती हैं। 
            हे देव, आप हमारे मन की चंचलता को शुद्ध कर उसे एकाग्र और केवल श्रेष्ठ लक्ष्यों के प्रति पूर्णतः समर्पित बना देने की कृपा करें। 
            आपका यह निरंतर प्रवाह अज्ञान के काले परदों को हटाकर हमें सत्य के दर्शन कराने और हमें ईश्वर के समीप ले जाने में सहायक सिद्ध होता है। 
            हम आपकी अनन्य वंदना करते हैं क्योंकि आप ही आनंद के परम अधिपति हैं और अपने भक्तों के मानसिक संतापों को क्षण भर में हरने वाले हैं। 
            यज्ञ की इस पवित्र अग्नि में आपकी आहुति समस्त देवताओं को पुष्ट करती है और संपूर्ण चराचर ब्रह्मांड को जीवनी ऊर्जा प्रदान करती है। 
            हमें वह आध्यात्मिक सामर्थ्य और धैर्य प्रदान करें जिससे हम संसार के कठिन द्वंद्वों से ऊपर उठकर सदैव आंतरिक रूप से शांत और सुखी रह सकें। 
            हे पवमान सोम, आपकी यह तेजस्वी धारा हमारे घरों को सुख, शांति और दिव्य समृद्धि से भर देने वाली एक उदार और मंगलकारी शक्ति बने।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, these swift-flowing drops are moving through the sacred filter, bringing forth all forms of divine good fortune. 
            Their rapid and energetic flow is essential for destroying the lethargy of our lives and infusing them with dynamism and divinity. 
            Just as the streams of Soma fall into the ritual vessel to fill it, may your grace fill our existence with absolute completeness and plenty. 
            Purity is the primary gateway through which divine forces enter our being and build our character upon the highest spiritual ideals. 
            O God, purify the restlessness of our minds and make them focused and entirely dedicated to the pursuit of superior and noble goals. 
            Your continuous flow is a supreme aid in removing the dark veils of ignorance, helping us perceive Truth and drawing us closer to God. 
            We worship you exclusively because you are the supreme Lord of Bliss and the one who removes the mental afflictions of your followers instantly. 
            Your oblation in this sacred fire nourishes all the deities and provides vital energy to the entire moving and non-moving cosmos. 
            Grant us that spiritual capability and patience through which we can rise above the worldly dualities and remain internally calm and happy. 
            O Pavamana Soma, let this radiant stream of yours become the generous and auspicious power that fills our homes with peace and prosperity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 38,
        sanskrit = "अभि प्र मन्दिनं गिरः सोमं पवस्व धारया ।\nइन्द्राय पातवे सुतम् ॥ ३८ ॥",
        hindiCommentary = """
            हे दिव्य सोमदेव! आप हमारी श्रद्धापूर्ण स्तुतियों के साथ अत्यंत आनंददायक और हर्षित होकर अपनी पावन धारा के साथ यहाँ प्रवाहित हों। 
            आप विशेष रूप से इन्द्रदेव के पान करने के लिए तैयार किए गए हैं, कृपया उन्हें तृप्त करने और बल प्रदान करने के लिए दिव्य पात्रों की ओर बढ़ें। 
            इन्द्र और सोम का यह मिलन ब्रह्मांडीय शक्ति और आध्यात्मिक आनंद के उस संगम का प्रतीक है जो धर्म की रक्षा के लिए परम आवश्यक है। 
            जब आप इन्द्र के अस्तित्व में प्रवाहित होते हैं, तो वे अजेय और वज्र के समान शक्तिशाली बन जाते हैं और हमारे समस्त शत्रुओं का दमन करते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण को पूर्णतः शुद्ध कर हमें उच्चतर दिव्य अनुभूतियों और ईश्वर के साक्षात् के योग्य बनाने की सामर्थ्य रखती है। 
            हे देव, आप हमारे इस यज्ञ को सिद्ध और सफल बनाएं और हमारे श्रेष्ठ संकल्पों को देवताओं के महान आशीर्वादों के साथ सफलतापूर्वक जोड़ दें। 
            हमारी वाणी में वह सत्य, ओज और तेज भर दें कि हमारी भक्तिपूर्ण पुकार सीधे आपके और देवराज इन्द्र के हृदय के गहन स्तरों तक पहुँच सके। 
            आप ही वह दिव्य अमृत हैं जो मृत्यु के भय और सांसारिक दुखों को समाप्त कर मनुष्य को अमरता और मोक्ष के परम पथ पर अग्रसर करता है। 
            हम अत्यंत श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन और परिवार में सदैव निरंतर और शाश्वत बना रहे। 
            हे पवमान सोम, आप हमारे परम रक्षक और मार्गदर्शक बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च और पवित्रतम शिखर पर पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Soma, flow here in your sacred stream, being most exhilarating and joyful, accompanied by our profound and devoted hymns. 
            You have been specifically prepared for the consumption of Lord Indra; please proceed toward the divine vessels to satisfy and strengthen him. 
            This union of Indra and Soma symbolizes the confluence of cosmic power and spiritual bliss, which is essential for the defense of Dharma. 
            When you flow through Indra's existence, he becomes invincible and powerful like his thunderbolt, subduing all the enemies of our lives. 
            This holy stream of yours possesses the power to completely purify our inner self and make us worthy of higher divine realizations. 
            O God, make our sacrifice successful and meaningful, and successfully connect our noble resolutions with the great blessings of the gods. 
            Fill our voices with such truth, vigor, and brilliance that our devoted calls reach the deepest levels of your heart and Indra's heart. 
            You are the divine nectar that terminates the fear of death and worldly sorrows, driving humans forward on the path of immortality and liberation. 
            We worship you with profound devotion so that the nectar-like flow of your immense generosity remains forever constant and eternal in our lives. 
            O Pavamana Soma, stay as our supreme protector and guide, leading us graciously to the highest and holiest peaks of success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 39,
        sanskrit = "तं वो मदाय घृष्वये सोमं विश्वाभिरूतिभिः ।\nइन्द्राय गायत सुतम् ॥ ३९ ॥",
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
        id = 40,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ ४० ॥",
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
        id = 41,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ ४१ ॥",
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
        id = 42,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ४२ ॥",
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
        id = 43,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ४३ ॥",
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
        id = 44,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ४४ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त, अज्ञान के संकटों और अधर्म के प्रलोभनों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ या शत्रु हमारा अहित करना चाहते हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
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
            जब हम बार-बार आपकी स्तुति और वंदना करते हैं, तो हमारी बुद्धि और विचार भी आकाश की तरह अत्यंत विस्तृत, उदार, तेजस्वी और श्रेष्ठ दिशा की ओर बढ़ते हैं। 
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
            Instead of burning in the destructive fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 51,
        sanskrit = "एते असृग्रमिन्दवस्तिरः पवित्रमाशवः ।\nविश्वान्यभि सौभगा ॥ ५१ ॥",
        hindiCommentary = """
            हे पवमान सोम! ये अत्यंत वेगवान और पवित्र सोमरस के कण छननी के माध्यम से निरंतर प्रवाहित होकर हमारे जीवन में सौभाग्य लेकर आ रहे हैं।
            इनका यह तीव्र प्रवाह हमारे अंतःकरण की समस्त जड़ता और अशुद्धियों को समूल नष्ट कर उसमें दिव्य गति और ऊर्जा का संचार करता है।
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
        id = 52,
        sanskrit = "अभि प्र मन्दिनं गिरः सोमं पवस्व धारया ।\nइन्द्राय पातवे सुतम् ॥ ५२ ॥",
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
        id = 53,
        sanskrit = "तं वो मदाय घृष्वये सोमं विश्वाभिरूतिभिः ।\nइन्द्राय गायत सुतम् ॥ ५३ ॥",
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
        id = 54,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ ५४ ॥",
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
        id = 55,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ ५५ ॥",
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
        id = 56,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ५६ ॥",
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
        id = 57,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ५७ ॥",
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
        id = 58,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ५८ ॥",
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
        id = 59,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ५९ ॥",
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
        id = 60,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ६० ॥",
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
        id = 61,
        sanskrit = "आ ते वत्सो मनो यमत् परमाच्चित् सधस्थात् ।\nअग्ने त्वां कामये गिरा ॥ ६१ ॥",
        hindiCommentary = """
            हे अग्निदेव! भक्त का मन और उसकी वाणी आपको सर्वोच्च धाम से अपने हृदय में बुलाने के लिए निरंतर व्याकुल और प्रतीक्षारत है।
            जैसे वत्स (बछड़ा) अपनी माता के लिए पुकार लगाता है, वैसे ही हम अपनी पवित्र वाणी (गिरा) से आपकी उपस्थिति की कामना करते हैं।
            आपकी दिव्यता हमारे जीवन को स्पर्श करे और हमारे अंतःकरण में ज्ञान का अखंड दीप प्रज्वलित कर हमें अंधकार से मुक्त कर दे।
            हम संसार की नश्वर और क्षणभंगुर वस्तुओं के बजाय आपके शाश्वत प्रेम और सान्निध्य की ही निरंतर इच्छा और प्रार्थना करते हैं।
            हे देव, आप अपनी महिमा के शिखर से उतरकर हमारे तुच्छ जीवन को अपनी पावन उपस्थिति से कृतार्थ और धन्य करने की कृपा करें।
            हमारी स्तुतियां केवल शब्द नहीं, बल्कि हमारे हृदय की वह गहन पुकार हैं जो आपको साक्षात् यहाँ आने के लिए विवश कर देती हैं।
            आप ही वह परमानंद हैं जिसे प्राप्त करने के बाद मनुष्य को इस नश्वर संसार में अन्य कुछ भी पाने की लेशमात्र भी इच्छा नहीं रहती।
            आपकी कृपा से हमारी वाणी में वह तेज और सत्यता आए कि वह सीधे आपके दिव्य कानों तक पहुँच सके और हमारा मार्ग प्रशस्त हो।
            हमें वह आध्यात्मिक प्यास प्रदान करें जो केवल आपके सान्निध्य रूपी अमृत से ही शांत हो सके और हमें पूर्णतः तृप्त कर दे।
            हे अग्नि, आप हमारी इन प्रार्थनाओं को सहर्ष स्वीकार करें और हमारे संपूर्ण जीवन को अपनी दिव्य चेतना से सदा के लिए आलोकित करें।
        """.trimIndent(),
        englishCommentary = """
            O Agni, the mind and voice of the devotee are restless to call you from your supreme celestial abode into their waiting heart.
            Just as a calf calls out for its mother with pure longing, we intensely desire and seek you with our sacred and holy speech.
            May your divinity touch our lives and ignite the eternal lamp of knowledge within our deepest consciousness, freeing us from darkness.
            Instead of worldly and perishable objects, we continuously long for your eternal love and divine presence as our ultimate goal.
            O God, descend from the peak of your glory and bless our humble lives with your most sacred and holy presence today.
            Our praises are not just mere words; they are the desperate cries of our hearts that compel you to manifest personally before us.
            You are that supreme bliss after attaining which a human possesses no further desire to seek anything else in the entire material world.
            By your grace, let our speech gain such brilliance and truth that it reaches directly into your divine ears, clearing our path.
            Grant us that spiritual thirst which can only be quenched by the nectar of your presence, leading us to absolute satisfaction.
            O Agni, accept our humble prayers and illuminate our entire existence with your profound and divine consciousness forever.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 62,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ६२ ॥",
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
        id = 63,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ६३ ॥",
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
        id = 64,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ६४ ॥",
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
        id = 65,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ६५ ॥",
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
        id = 66,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ६६ ॥",
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
        id = 67,
        sanskrit = "एते असृग्रमिन्दवस्तिरः पवित्रमाशवः ।\nविश्वान्यभि सौभगा ॥ ६७ ॥",
        hindiCommentary = """
            हे पवमान सोम! ये तीव्र गति वाले सोम के कण पवित्र छननी के माध्यम से निरंतर प्रवाहित होकर समस्त प्रकार के सौभाग्य लेकर आ रहे हैं।
            इनका यह वेगपूर्ण प्रवाह हमारे जीवन की जड़ता को नष्ट कर उसमें गतिशीलता और दिव्यता का संचार करने के लिए अत्यंत महत्वपूर्ण है।
            जैसे सोम की धाराएं पात्र में गिरकर उसे भर देती हैं, वैसे ही आपकी कृपा हमारे जीवन को पूर्णता और प्रचुरता से भर देने वाली हो।
            पवित्रता ही वह प्रथम द्वार है जिससे ईश्वरीय शक्तियाँ हमारे भीतर प्रवेश करती हैं और हमारे चरित्र का निर्माण उच्च आदर्शों पर करती हैं।
            हे देव, आप हमारे मन की चंचलता को शुद्ध कर उसे एकाग्र और केवल श्रेष्ठ लक्ष्यों के प्रति पूर्णतः समर्पित बना देने की कृपा करें।
            आपका यह निरंतर प्रवाह अज्ञान के काले परदों को हटाकर हमें सत्य के दर्शन कराने और हमें ईश्वर के समीप ले जाने में सहायक सिद्ध होता है।
            हम आपकी अनन्य वंदना करते हैं क्योंकि आप ही आनंद के परम अधिपति हैं और अपने भक्तों के मानसिक संतापों को क्षण भर में हरने वाले हैं।
            यज्ञ की इस पवित्र अग्नि में आपकी आहुति समस्त देवताओं को पुष्ट करती है और संपूर्ण चराचर ब्रह्मांड को जीवनी ऊर्जा प्रदान करती है।
            हमें वह आध्यात्मिक सामर्थ्य और धैर्य प्रदान करें जिससे हम संसार के कठिन द्वंद्वों से ऊपर उठकर सदैव आंतरिक रूप से शांत और सुखी रह सकें।
            हे पवमान सोम, आपकी यह तेजस्वी धारा हमारे घरों को सुख, शांति और दिव्य समृद्धि से भर देने वाली एक उदार और मंगलकारी शक्ति बने।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, these swift-flowing drops are moving through the sacred filter, bringing forth all forms of divine good fortune.
            Their rapid and energetic flow is essential for destroying the lethargy of our lives and infusing them with dynamism and divinity.
            Just as the streams of Soma fall into the ritual vessel to fill it, may your grace fill our existence with absolute completeness and plenty.
            Purity is the primary gateway through which divine forces enter our being and build our character upon the highest spiritual ideals.
            O God, purify the restlessness of our minds and make them focused and entirely dedicated to the pursuit of superior and noble goals.
            Your continuous flow is a supreme aid in removing the dark veils of ignorance, helping us perceive Truth and drawing us closer to God.
            We worship you exclusively because you are the supreme Lord of Bliss and the one who removes the mental afflictions of your followers instantly.
            Your oblation in this sacred fire nourishes all the deities and provides vital energy to the entire moving and non-moving cosmos.
            Grant us that spiritual capability and patience through which we can rise above the worldly dualities and remain internally calm and happy.
            O Pavamana Soma, let this radiant stream of yours become the generous and auspicious power that fills our homes with peace and prosperity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 68,
        sanskrit = "अभि प्र मन्दिनं गिरः सोमं पवस्व धारया ।\nइन्द्राय पातवे सुतम् ॥ ६८ ॥",
        hindiCommentary = """
            हे दिव्य सोमदेव! आप हमारी श्रद्धापूर्ण स्तुतियों के साथ अत्यंत आनंददायक और हर्षित होकर अपनी पावन धारा के साथ यहाँ प्रवाहित हों।
            आप विशेष रूप से इन्द्रदेव के पान करने के लिए तैयार किए गए हैं, कृपया उन्हें तृप्त करने और बल प्रदान करने के लिए दिव्य पात्रों की ओर बढ़ें।
            इन्द्र और सोम का यह मिलन ब्रह्मांडीय शक्ति और आध्यात्मिक आनंद के उस संगम का प्रतीक है जो धर्म की रक्षा के लिए परम आवश्यक है।
            जब आप इन्द्र के अस्तित्व में प्रवाहित होते हैं, तो वे अजेय और वज्र के समान शक्तिशाली बन जाते हैं और हमारे समस्त शत्रुओं का दमन करते हैं।
            आपकी यह पावन धारा हमारे अंतःकरण को पूर्णतः शुद्ध कर हमें उच्चतर दिव्य अनुभूतियों और ईश्वर के साक्षात् के योग्य बनाने की सामर्थ्य रखती है।
            हे देव, आप हमारे इस यज्ञ को सिद्ध और सफल बनाएं और हमारे श्रेष्ठ संकल्पों को देवताओं के महान आशीर्वादों के साथ सफलतापूर्वक जोड़ दें।
            हमारी वाणी में वह सत्य, ओज और तेज भर दें कि हमारी भक्तिपूर्ण पुकार सीधे आपके और देवराज इन्द्र के हृदय के गहन स्तरों तक पहुँच सके।
            आप ही वह दिव्य अमृत हैं जो मृत्यु के भय और सांसारिक दुखों को समाप्त कर मनुष्य को अमरता और मोक्ष के परम पथ पर अग्रसर करता है।
            हम अत्यंत श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन और परिवार में सदैव निरंतर और शाश्वत बना रहे।
            हे पवमान सोम, आप हमारे परम रक्षक और मार्गदर्शक बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च और पवित्रतम शिखर पर पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Soma, flow here in your sacred stream, being most exhilarating and joyful, accompanied by our profound and devoted hymns.
            You have been specifically prepared for the consumption of Lord Indra; please proceed toward the divine vessels to satisfy and strengthen him.
            This union of Indra and Soma symbolizes the confluence of cosmic power and spiritual bliss, which is essential for the defense of Dharma.
            When you flow through Indra's existence, he becomes invincible and powerful like his thunderbolt, subduing all the enemies of our lives.
            This holy stream of yours possesses the power to completely purify our inner self and make us worthy of higher divine realizations.
            O God, make our sacrifice successful and meaningful, and successfully connect our noble resolutions with the great blessings of the gods.
            Fill our voices with such truth, vigor, and brilliance that our devoted calls reach the deepest levels of your heart and Indra's heart.
            You are the divine nectar that terminates the fear of death and worldly sorrows, driving humans forward on the path of immortality and liberation.
            We worship you with profound devotion so that the nectar-like flow of your immense generosity remains forever constant and eternal in our lives.
            O Pavamana Soma, stay as our supreme protector and guide, leading us graciously to the highest and holiest peaks of success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 69,
        sanskrit = "तं वो मदाय घृष्वये सोमं विश्वाभिरूतिभिः ।\nइन्द्राय गायत सुतम् ॥ ६९ ॥",
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
        id = 70,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ ७० ॥",
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
        id = 71,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ ७१ ॥",
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
        id = 72,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ७२ ॥",
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
        id = 73,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ७३ ॥",
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
        id = 74,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ७४ ॥",
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
            Grant us the inner strength to never walk the path of unrighteousness or untruth and to always obey your divine commands.
            Let your light create an impenetrable shield of protection around us that no demonic force or negative thought of the world can ever pierce.
            O Most Resplendent One, your flames are ever ready for the victory of Truth; please make us also true and loyal warriors of the Truth.
            The experience of your protective power in every struggle and difficult test of life gives us unbreakable courage, mental peace, and patience.
            O Agni, you are our supreme protector; lead us from the darkness of ignorance to light and from the fear of death to the bliss of immortality.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 75,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ७५ ॥",
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
            O Youthful and Radiant Agni, accepting our best and devoted offerings, protect us from those forces that harbor envy or malice toward our well-well-being.
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
        id = 76,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ७६ ॥",
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
        id = 77,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ७७ ॥",
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
        id = 78,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ७८ ॥",
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
        id = 79,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ७९ ॥",
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
        id = 80,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ८० ॥",
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
            Instead of burning in the destructive fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold.
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace.
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God.
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life.
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 81,
        sanskrit = "इन्दुरिन्द्राय पवत इति देवासो अब्रुवन् ।\nवाचस्पतिर्मखस्यते विश्वस्येशान ओजसा ॥ ८१ ॥",
        hindiCommentary = """
            देवताओं ने यह घोषणा की है कि यह पवित्र सोम की बूंद (इन्दु) इन्द्रदेव की तृप्ति और बलवर्धन के लिए प्रवाहित हो रही है। 
            यह सोम वाणी का स्वामी (वाचस्पति) है और अपने असीम ओज तथा सामर्थ्य से इस संपूर्ण ब्रह्मांड पर शासन करने वाला है। 
            जब सोम का प्रवाह यज्ञ की वेदी पर आरम्भ होता है, तो वह केवल एक भौतिक रस नहीं रह जाता, बल्कि ईश्वरीय वाणी बन जाता है। 
            सोम की शक्ति से ही हमारी वाणी में प्रभाव उत्पन्न होता है और हमारे वचन सत्य की शक्ति से ओत-प्रोत हो जाते हैं। 
            हे देव, आप हमारे अंतःकरण में उस दिव्य ओज का संचार करें जो हमें बुराइयों से लड़ने और धर्म पर चलने की शक्ति दे। 
            आपकी कृपा से ही इस जगत की समस्त चराचर व्यवस्था सुचारू रूप से संचालित होती है और सबको पोषण प्राप्त होता है। 
            हमें वह बौद्धिक स्पष्टता प्रदान करें जिससे हम सत्य और असत्य के सूक्ष्म भेद को पहचान कर सदैव सही निर्णय ले सकें। 
            आपकी यह पावन ज्योति हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, यश और आध्यात्मिक उन्नति लाने वाली एकमात्र शक्ति है। 
            हम श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन में सदैव निरंतर और अखंड बना रहे। 
            हे पवमान सोम, आप हमारे रक्षक और मार्गदर्शक बनकर हमें जीवन की पूर्णता और ईश्वर के परम सान्निध्य तक पहुँचाएं।
        """.trimIndent(),
        englishCommentary = """
            The gods have collectively declared that this sacred drop of Soma (Indu) flows exclusively for the gratification and strength of Lord Indra. 
            This Soma is the Lord of Speech (Vachaspati) and reigns over the entire universe through his boundless vigor and divine might. 
            When the flow of Soma commences upon the sacrificial altar, it transcends its physical form to become the very voice of the Divine. 
            It is through the power of Soma that our speech gains influence and our words become saturated with the strength of Truth. 
            O God, infuse our inner being with that celestial vigor which empowers us to fight against evil and remain steadfast in Dharma. 
            By your grace alone, the entire moving and non-moving order of this universe is governed and every being receives nourishment. 
            Bestow upon us that intellectual clarity which enables us to discern the subtle difference between truth and falsehood. 
            Your sacred radiance is the singular power that brings prosperity, fame, and spiritual evolution into every field of our existence. 
            We worship you with devotion so that the nectar-like flow of your immense generosity remains forever constant and eternal in our lives. 
            O Pavamana Soma, stay as our protector and guide, leading us toward the completeness of life and the realization of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 82,
        sanskrit = "सोमः पुनानो अर्षति सहस्रधारो अद्रिभिः ।\nइन्द्रस्य गच्छति निष्कृतम् ॥ ८२ ॥",
        hindiCommentary = """
            पवित्र किया गया सोम पत्थरों के घर्षण से निकलकर हजारों धाराओं (सहस्रधारो) के साथ वेगपूर्वक प्रवाहित हो रहा है। 
            यह सोम सीधे इन्द्रदेव के उस दिव्य स्थान (निष्कृतम्) की ओर बढ़ रहा है जहाँ देवताओं का मिलन और तृप्ति सुनिश्चित होती है। 
            हजारों धाराएं इस बात का प्रतीक हैं कि परमात्मा की कृपा और शक्ति अनगिनत रूपों में हमारे जीवन में प्रवेश करती है। 
            जैसे सोम छननी से छनकर अशुद्धियों को त्याग देता है, वैसे ही हमें भी अपने मन से संकीर्ण विचारों और द्वेष को त्यागना चाहिए। 
            हे सोम, आपकी यह दिव्य गति हमारे जीवन में नवीन उत्साह और चैतन्यता का संचार करने वाली है, हम आपकी शरण में हैं। 
            जब आप इन्द्र के समीप पहुँचते हैं, तो ब्रह्मांड की रक्षा के लिए उनका वज्र और भी अधिक प्रखर और शक्तिशाली हो जाता है। 
            हमें वह आंतरिक बल दें कि हम अपने शत्रुओं का डटकर सामना कर सकें और जीवन के प्रत्येक युद्ध में विजयी होकर उभरें। 
            आपकी कृपा से हमारे जीवन के प्रत्येक अभाव का नाश हो और हम पूर्णता, अखंड सौभाग्य और आत्मिक शांति का अनुभव कर सकें। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपके सान्निध्य में हमारा हृदय सदैव भक्ति और ज्ञान के प्रकाश से भरा रहे। 
            हे दिव्य सोम, आप अपनी इन पावन धाराओं के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे परमात्मा के निवास योग्य बनाएं।
        """.trimIndent(),
        englishCommentary = """
            The purified Soma, extracted by the friction of stones, flows forth with thousands of streams (Sahasradharo) in a powerful rush. 
            This Soma moves directly toward the appointed divine place of Lord Indra (Nishkritam), where the satisfaction of gods is ensured. 
            The thousands of streams symbolize that the grace and power of the Divine enter our lives in countless and multifaceted ways. 
            Just as Soma discards all impurities while passing through the filter, we must also discard narrow thoughts and malice from our minds. 
            O Soma, this celestial movement of yours is destined to infuse new enthusiasm and consciousness into our lives; we seek your refuge. 
            When you reach Indra, his thunderbolt becomes even more sharp and powerful for the protection and preservation of the entire cosmos. 
            Grant us that inner strength through which we can boldly face our enemies and emerge victorious in every battle of our existence. 
            By your grace, let every scarcity of our life be destroyed, allowing us to experience completeness and unbroken spiritual peace. 
            We sing your glories with devotion so that in your holy presence, our hearts remain forever filled with the light of wisdom. 
            O Divine Soma, through these holy streams of yours, purify our inner self and make it a fit and sacred dwelling for the Supreme Soul.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 83,
        sanskrit = "असर्जि सोमः सुत इन्द्राय मते ।\nपुनानो अर्षति रयिम् ॥ ८३ ॥",
        hindiCommentary = """
            इन्द्रदेव को आनंदित करने के लिए सोमरस का निष्कासन (असर्जि) किया गया है, जो अत्यंत पवित्र होकर यहाँ प्रवाहित हो रहा है। 
            यह सोम अपनी धारा के साथ हमारे लिए महान धन, ऐश्वर्य और आध्यात्मिक संपदा (रयिम्) लेकर आने वाला मंगलकारी देव है। 
            सोम का निष्कासन उस आध्यात्मिक प्रक्रिया का प्रतीक है जहाँ कठोर साधना से मन का शुद्ध रस परमात्मा को अर्पित किया जाता है। 
            जब हम अपनी भावनाओं को पवित्र करते हैं, तभी वे देवताओं द्वारा स्वीकार किए जाने योग्य और फलदायी बनती हैं। 
            हे देव, आप हमारे जीवन की दरिद्रता और मानसिक जड़ता को समाप्त कर हमें प्रचुरता और ज्ञान के सर्वोच्च मार्ग पर ले चलें। 
            आपकी कृपा से हमारे घर सुख और शांति के धाम बनें, जहाँ सदैव धर्म और सत्य की चर्चा हो और सबका मंगल हो। 
            आप ही वह ऊर्जा हैं जो हमारे शिथिल पड़ते संकल्पों में नवीन प्राण फूंकती हैं और हमें कर्मक्षेत्र में निरंतर सक्रिय रखती हैं। 
            हम विनम्र भाव से आपकी वंदना करते हैं क्योंकि आप ही हमारे जीवन के प्रत्येक अभाव को पूर्णता में बदलने का सामर्थ्य रखते हैं। 
            आपकी दीप्ति हमारे अज्ञान के बादलों को हटाकर हमें स्पष्ट दृष्टि और सही निर्णय लेने की अद्भुत क्षमता प्रदान करने वाली हो। 
            हे इन्द्र के प्रिय सोम, आप हमारे रक्षक और पालनहार बनकर हमें सदैव अपनी दिव्य सुरक्षा और सुखद छाया में रखने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            The Soma juice has been extracted (Asarji) to exhilarate Lord Indra, and it is now flowing here in its most purified and divine state. 
            This Soma is the auspicious deity who brings forth great wealth, abundance, and spiritual treasures (Rayim) along with its sacred stream. 
            The extraction of Soma symbolizes the spiritual process where the pure essence of the mind is offered to God through rigorous practice. 
            Only when we purify our emotions and intentions do they become worthy of acceptance by the gods and yield fruitful results for us. 
            O God, terminate the poverty and mental lethargy of our existence and lead us onto the supreme path of abundance and wisdom. 
            By your grace, let our homes become abodes of happiness and peace, where Dharma and Truth are discussed and all prosper together. 
            You are the energy that breathes new life into our weakening resolutions and keeps us perpetually active in the field of selfless action. 
            We worship you with humility because only you possess the capability to transform every single scarcity of our life into absolute fulfillment. 
            May your radiance remove the clouds of our ignorance and grant us clear vision and the amazing ability to make righteous decisions. 
            O beloved Soma of Indra, stay as our protector and nourisher, and graciously keep us always under your divine and pleasant shadow.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 84,
        sanskrit = "एते असृग्रमिन्दवस्तिरः पवित्रमाशवः ।\nविश्वान्यभि सौभगा ॥ ८४ ॥",
        hindiCommentary = """
            ये अत्यंत वेगवान और पवित्र सोमरस के कण (इन्दवः) छननी के माध्यम से निरंतर प्रवाहित होकर हमारे जीवन में सौभाग्य लेकर आ रहे हैं। 
            इनका यह तीव्र प्रवाह हमारे अंतःकरण की समस्त जड़ता और अशुद्धियों को नष्ट कर उसमें दिव्य गति और पवित्रता का संचार करता है। 
            जैसे सोम की धाराएं पात्र में गिरकर उसे पूर्णता प्रदान करती हैं, वैसे ही आपकी कृपा हमारे जीवन को आनंद और संपन्नता से भर दे। 
            पवित्रता ही वह दिव्य माध्यम है जिससे ईश्वरीय शक्तियाँ हमारे निकट आती हैं और हमारे संकल्पों को ईश्वरीय मार्ग से जोड़ती हैं। 
            हे देव, आप हमारे चंचल मन को अपनी पावन धारा से शुद्ध कर उसे एकाग्र, स्थिर और केवल श्रेष्ठ लक्ष्यों के प्रति समर्पित बना दें। 
            आपका यह निरंतर प्रवाह अज्ञान के काले आवरणों को हटाकर हमें सत्य के दर्शन कराने और हमें ईश्वर के समीप ले जाने में सहायक है। 
            हम आपकी वंदना करते हैं क्योंकि आप ही आनंद के परम स्रोत हैं और अपने भक्तों के मानसिक संतापों को हरने वाले दयालु देव हैं। 
            यज्ञ की इस पवित्र अग्नि में आपकी आहुति समस्त देवताओं को पुष्ट करती है और संपूर्ण ब्रह्मांड को नवीन ऊर्जा प्रदान करती है। 
            हमें वह आध्यात्मिक सामर्थ्य और धैर्य प्रदान करें जिससे हम संसार के द्वंद्वों से ऊपर उठकर सदैव शांत और सुखी रह सकें। 
            हे पवमान सोम, आपकी यह तेजस्वी धारा हमारे घरों को सुख, अखंड शांति और दिव्य समृद्धि से भर देने वाली मंगलकारी शक्ति बने।
        """.trimIndent(),
        englishCommentary = """
            These swift and holy drops of Soma (Indavah) are flowing continuously through the sacred filter, bringing forth immense good fortune. 
            Their rapid flow is essential for destroying the lethargy and impurities of our inner self, infusing it with divine dynamism and purity. 
            Just as the streams of Soma fall into the ritual vessel to bring it to fullness, may your grace fill our lives with joy and abundance. 
            Purity is the divine medium through which celestial forces approach us and align our individual intentions with the righteous path. 
            O God, purify our restless minds with your holy stream and make them focused, steady, and entirely dedicated to the pursuit of noble goals. 
            Your continuous flow acts as a catalyst in removing the dark veils of ignorance, helping us perceive Truth and drawing us closer to God. 
            We worship you as the ultimate source of bliss, the compassionate deity who removes the mental afflictions of your devoted followers. 
            Your oblation in this sacred fire nourishes all the deities and provides fresh, vitalizing energy to the entire moving and non-moving cosmos. 
            Grant us the spiritual capability and patience to rise above the dualities of the world and remain internally peaceful and happy always. 
            O Pavamana Soma, let this radiant stream of yours manifest as the auspicious power that fills our homes with peace and prosperity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 85,
        sanskrit = "अभि प्र मन्दिनं गिरः सोमं पवस्व धारया ।\nइन्द्राय पातवे सुतम् ॥ ८५ ॥",
        hindiCommentary = """
            हे दिव्य सोमदेव! आप हमारी श्रद्धापूर्ण स्तुतियों के साथ अत्यंत आनंददायक और हर्षित होकर अपनी पावन धारा के साथ यहाँ प्रवाहित हों। 
            आप विशेष रूप से इन्द्रदेव के पान करने के लिए तैयार किए गए हैं, कृपया उन्हें तृप्त करने और अजेय बल प्रदान करने के लिए आगे बढ़ें। 
            इन्द्र और सोम का यह मिलन ब्रह्मांडीय शक्ति और आध्यात्मिक आनंद के उस संगम का प्रतीक है जो धर्म की रक्षा के लिए परम आवश्यक है। 
            जब आप इन्द्र के अस्तित्व में प्रवाहित होते हैं, तो वे अजेय बन जाते हैं और हमारे जीवन के शत्रुओं का सफलतापूर्वक दमन करते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण को पूर्णतः शुद्ध कर हमें उच्चतर दिव्य अनुभूतियों और परमात्मा के साक्षात्कार के योग्य बनाती है। 
            हे देव, आप हमारे इस यज्ञ को सिद्ध करें और हमारे श्रेष्ठ संकल्पों को देवताओं के महान आशीर्वादों के साथ सफलतापूर्वक जोड़ देने की कृपा करें। 
            हमारी वाणी में वह सत्य, ओज और तेज भर दें कि हमारी भक्तिपूर्ण पुकार सीधे आपके और देवराज इन्द्र के हृदय के गहन स्तरों तक पहुँच सके। 
            आप ही वह दिव्य अमृत हैं जो मृत्यु के भय और सांसारिक दुखों को समाप्त कर मनुष्य को अमरता और मोक्ष के परम पथ पर अग्रसर करता है। 
            हम अत्यंत श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन और परिवार में सदैव निरंतर और शाश्वत बना रहे। 
            हे पवमान सोम, आप हमारे परम रक्षक और मार्गदर्शक बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च और पवित्रतम शिखर पर पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Soma, flow here in your sacred stream, being most exhilarating and joyful, accompanied by our profound and devoted hymns. 
            You have been specifically prepared for the consumption of Lord Indra; please proceed toward the divine vessels to satisfy and strengthen him. 
            This union of Indra and Soma symbolizes the confluence of cosmic power and spiritual bliss, which is essential for the defense of Dharma. 
            When you flow through Indra's existence, he becomes invincible and subdues all the internal and external enemies of our lives successfully. 
            This holy stream of yours possesses the power to completely purify our inner self and make us worthy of higher divine realizations. 
            O God, make our sacrifice successful and meaningful, and successfully connect our noble resolutions with the great blessings of the gods. 
            Fill our voices with such truth, vigor, and brilliance that our devoted calls reach the deepest levels of your heart and Indra's heart. 
            You are the divine nectar that terminates the fear of death and worldly sorrows, driving humans forward on the path of immortality. 
            We worship you with profound devotion so that the nectar-like flow of your immense generosity remains forever constant in our lives. 
            O Pavamana Soma, stay as our supreme protector and guide, leading us graciously to the highest and holiest peaks of success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 86,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ ८६ ॥",
        hindiCommentary = """
            हे पवमान कवि (क्रांतदर्शी) सोम! आपकी अत्यंत शक्तिशाली और पवित्र लहरें रत्नों और दिव्य गुणों की कामना करती हुई तीव्र गति से प्रवाहित हो रही हैं। 
            आप स्वयं शाश्वत ज्ञान के पुंज हैं और जब आप अपनी दिव्य तरंगों के साथ बहते हैं, तो आप अपने उपासकों के लिए सौभाग्य और शांति का संदेश लाते हैं। 
            जैसे समुद्र की लहरें तट पर बहुमूल्य वस्तुएं लेकर आती हैं, वैसे ही आपकी धारा हमारे जीवन में आध्यात्मिक रत्न और सद्गुणों का संचार करती है। 
            हे देव, आपकी ये पावन लहरें हमारे मन के समस्त संताप, अज्ञान और नकारात्मक विचारों को बहा ले जाएं और हमें शांति के सागर में सराबोर कर दें। 
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करती है जिससे हम संसार के भ्रामक मायाजाल को भेदकर ईश्वर के वास्तविक स्वरूप का दर्शन करने में सफल होते हैं। 
            हमें वह 'रत्न' प्रदान करने की कृपा करें जो हमारे चरित्र को बलवान और उज्ज्वल बनाएं ताकि हम समाज के लिए एक महान आदर्श प्रस्तुत कर सकें। 
            आप ही वह आदि शक्ति हैं जो हमारे सूक्ष्म संकल्पों को ब्रह्मांडीय सिद्धियों में बदलने का अद्भुत और अमोघ सामर्थ्य रखती हैं, हम आपकी शरण में हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का निरंतर गान करते हैं ताकि आपकी कृपा की वर्षा हमारे जीवन और परिवार में सदैव निरंतर और अखंड बनी रहे। 
            जैसे तरंगें निरंतरता का प्रतीक हैं, वैसे ही हमारी अटूट भक्ति भी आपके प्रति निरंतर और निष्काम बनी रहे, यही हमारी आपसे करबद्ध प्रार्थना है। 
            हे दिव्य सोम, आप अपनी इन पावन लहरों के माध्यम से हमारे अंतःकरण को शुद्ध कर उसे परमात्मा के शाश्वत सान्निध्य के योग्य बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Kavi (wise seer) Soma, your extremely powerful and holy waves flow with speed, seeking gems and divine qualities for our lives. 
            You are the mass of eternal knowledge, and as you flow with your divine ripples, you bring messages of good fortune and peace to your followers. 
            Just as ocean waves bring precious objects to the shore, your sacred current infuses spiritual gems and virtues into our daily existence. 
            O God, let these holy waves wash away all the heat of our sorrows, ignorance, and negative thoughts, immersing us in the ocean of peace. 
            Your energy provides us with the capability to pierce through the deceptive illusions of the world and perceive the actual nature of God. 
            Graciously bestow upon us those 'gems' that make our character strong and bright, so we may present a magnificent ideal for society. 
            You are the primordial power that possesses the strength to transform our subtle intentions into cosmic achievements; we seek your refuge. 
            We worship you with devotion so that the rain of your grace remains continuous and unbroken within our lives and our families. 
            Just as waves represent continuity, may our unshakable devotion toward you remain constant and selfless; this is our humble and heartfelt prayer. 
            O Divine Soma, through these holy waves of yours, purify our inner self and make it worthy of the eternal proximity of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 87,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ ८७ ॥",
        hindiCommentary = """
            हे सोमदेव! आप वाणी के अधिपति और ज्ञान के अथाह समुद्र होकर अपनी दिव्य चेतना के साथ अत्यंत पवित्र होकर यहाँ प्रवाहित हों। 
            आप दिव्य गर्जना करते हुए अपने शाश्वत स्थान पर विराजमान हों, जो आपकी अजेय शक्ति, दिव्यता और सर्वोच्चता का साक्षात् और अडिग प्रतीक है। 
            आप ही वह सर्वोच्च ऊर्जा हैं जो ऋषियों के पवित्र कंठ में वेदमंत्रों का संचार करती हैं और उन्हें जगत के परम कल्याण के लिए सदैव प्रेरित करती हैं। 
            जैसे समुद्र अथाह और अनंत रहस्यों से भरा होता है, वैसे ही आपका स्वरूप भी अनंत है, जो हमें शाश्वत आध्यात्मिक शांति प्रदान करने वाला है। 
            हे देव, आप हमारे विचारों और वचनों में सत्य की वाणी बनकर विराजें ताकि हम सदैव मंगलकारी और कल्याणकारी मार्ग पर ही अग्रसर रहें। 
            आपकी गर्जना हमारे भीतर के अज्ञान, आलस्य और तामसी प्रवृत्तियों को जगाकर हमें आत्मज्ञान और ईश्वर की साधना के मार्ग पर सक्रिय कर देने वाली है। 
            हमें वह मेधा शक्ति प्रदान करें जिससे हम वेदों के गूढ़ अर्थों को आत्मसात कर सकें और अपने जीवन को उनके श्रेष्ठ सिद्धांतों के अनुरूप ढाल सकें। 
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
            Bestow upon us that intellectual capability through which we can assimilate the meanings of the Vedas and shape our lives by them. 
            By your grace, may our minds become like a calm, cool, and deep lake in which the light of your devotion shines as brilliantly as the Sun. 
            We worship you with devotion because you are the one who completely purifies our inner self and makes it a holy fit dwelling for divinity. 
            O Pavamana Soma, reside in our sacrifice with your infinite glory and grant us the blessings of supreme knowledge and the attainment of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 88,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ ८८ ॥",
        hindiCommentary = """
            हे सोमदेव! आप हमारे लिए उत्तम शक्ति, श्रेष्ठतम ऐश्वर्य और अखंड दिव्य सुख प्रदान करने के लिए पूर्णतः पवित्र होकर यहाँ प्रवाहित हों। 
            आपकी यह पावन धारा हमारे जीवन के प्रत्येक क्षेत्र में संपन्नता, आरोग्यता और सामर्थ्य लाने वाली है, हम आपकी असीम और दयालु कृपा की याचना करते हैं। 
            शक्ति केवल बाह्य नहीं, बल्कि आंतरिक और आत्मिक भी होनी चाहिए, जो हमें धर्म के मार्ग पर अडिग रहने और सत्य का पक्ष लेने के लिए बल प्रदान करे। 
            हमें वह धन और संसाधन प्रदान करें जो न्यायपूर्ण रीति से प्राप्त किए गए हों और जिनका उपयोग हम मानवता की सेवा के लिए अत्यंत गौरव के साथ कर सकें। 
            आपकी कृपा से प्राप्त होने वाला सुख वह आत्मिक शांति है जो सांसारिक उथल-पुथल या दुखों से कभी भी विचलित नहीं होती और जो सदैव आनंदित रखती है। 
            हे देव, आप हमारे अंतःकरण को शुद्ध कर हमें वह दिव्य दृष्टि दें जिससे हम ईश्वर की महिमा और उपस्थिति को इस चराचर जगत के कण-कण में देख सकें। 
            आप ही वह पराशक्ति हैं जो हमारे जीवन की जड़ता और आलस्य को समाप्त कर हमें प्रचुरता, ज्ञान और सक्रियता के सर्वोच्च शिखर पर पहुँचाने में समर्थ हैं। 
            आपकी महिमा का निरंतर गान करने से हमारे समस्त कष्टों का निवारण होता है और हमें नवीन उत्साह, आशा और अटूट जीवनी शक्ति की प्राप्ति होती रहती है। 
            हे सोम, आप हमारे परम स्वामी और रक्षक के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली, यशस्वी और आध्यात्मिक रूप से पूर्ण बनाने की असीम कृपा करें। 
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
            O Soma, always stay with us as our protector and Lord, graciously making our lives magnificent, successful, and spiritually complete. 
            We offer our entire faith at your divine feet so that our lives remain meaningful, nourished, holy, and completely God-conscious in every way.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 89,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ८९ ॥",
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
        id = 90,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ९० ॥",
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
        id = 91,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ९१ ॥",
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
        id = 92,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ९२ ॥",
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
        id = 93,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ९३ ॥",
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
        id = 94,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ९४ ॥",
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
        id = 95,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ९५ ॥",
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
        id = 96,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ९६ ॥",
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
            Instead of burning in the destructive fire of jealousy, let us be refined in the light of your wisdom like pure, radiant, and great gold. 
            When our mind is immersed in your unshakable devotion and love, no worldly scarcity, sorrow, or pain can ever disturb our inner peace. 
            You are the power that destroys our internal darkness and shows us the actual path toward Self-realization and the proximity of God. 
            Bestow upon us the courage and fearlessness required to always be ready for the protection of Dharma and to lead a bold and ideal life. 
            May your merciful gaze remain upon us so that we stay virtuous and continue to experience the infinite bliss and supreme peace of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 97,
        sanskrit = "एते असृग्रमिन्दवस्तिरः पवित्रमाशवः ।\nविश्वान्यभि सौभगा ॥ ९७ ॥",
        hindiCommentary = """
            हे पवमान सोम! ये तीव्र गति वाले सोम के कण पवित्र छननी के माध्यम से निरंतर प्रवाहित होकर समस्त प्रकार के सौभाग्य लेकर आ रहे हैं। 
            इनका यह वेगपूर्ण प्रवाह हमारे जीवन की जड़ता को नष्ट कर उसमें गतिशीलता और दिव्यता का संचार करने के लिए अत्यंत महत्वपूर्ण है। 
            जैसे सोम की धाराएं पात्र में गिरकर उसे भर देती हैं, वैसे ही आपकी कृपा हमारे जीवन को पूर्णता और प्रचुरता से भर देने वाली हो। 
            पवित्रता ही वह प्रथम द्वार है जिससे ईश्वरीय शक्तियाँ हमारे भीतर प्रवेश करती हैं और हमारे चरित्र का निर्माण उच्च आदर्शों पर करती हैं। 
            हे देव, आप हमारे मन की चंचलता को शुद्ध कर उसे एकाग्र और केवल श्रेष्ठ लक्ष्यों के प्रति पूर्णतः समर्पित बना देने की कृपा करें। 
            आपका यह निरंतर प्रवाह अज्ञान के काले परदों को हटाकर हमें सत्य के दर्शन कराने और हमें ईश्वर के समीप ले जाने में सहायक सिद्ध होता है। 
            हम आपकी अनन्य वंदना करते हैं क्योंकि आप ही आनंद के परम अधिपति हैं और अपने भक्तों के मानसिक संतापों को क्षण भर में हरने वाले हैं। 
            यज्ञ की इस पवित्र अग्नि में आपकी आहुति समस्त देवताओं को पुष्ट करती है और संपूर्ण चराचर ब्रह्मांड को जीवनी ऊर्जा प्रदान करती है। 
            हमें वह आध्यात्मिक सामर्थ्य और धैर्य प्रदान करें जिससे हम संसार के कठिन द्वंद्वों से ऊपर उठकर सदैव आंतरिक रूप से शांत और सुखी रह सकें। 
            हे पवमान सोम, आपकी यह तेजस्वी धारा हमारे घरों को सुख, शांति और दिव्य समृद्धि से भर देने वाली एक उदार और मंगलकारी शक्ति बने।
        """.trimIndent(),
        englishCommentary = """
            O Pavamana Soma, these swift-flowing drops are moving through the sacred filter, bringing forth all forms of divine good fortune. 
            Their rapid and energetic flow is essential for destroying the lethargy of our lives and infusing them with dynamism and divinity. 
            Just as the streams of Soma fall into the ritual vessel to fill it, may your grace fill our existence with absolute completeness and plenty. 
            Purity is the primary gateway through which divine forces enter our being and build our character upon the highest spiritual ideals. 
            O God, purify the restlessness of our minds and make them focused and entirely dedicated to the pursuit of superior and noble goals. 
            Your continuous flow is a supreme aid in removing the dark veils of ignorance, helping us perceive Truth and drawing us closer to God. 
            We worship you exclusively because you are the supreme Lord of Bliss and the one who removes the mental afflictions of your followers instantly. 
            Your oblation in this sacred fire nourishes all the deities and provides vital energy to the entire moving and non-moving cosmos. 
            Grant us that spiritual capability and patience through which we can rise above the worldly dualities and remain internally calm and happy. 
            O Pavamana Soma, let this radiant stream of yours become the generous and auspicious power that fills our homes with peace and prosperity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 98,
        sanskrit = "अभि प्र मन्दिनं गिरः सोमं पवस्व धारया ।\nइन्द्राय पातवे सुतम् ॥ ९८ ॥",
        hindiCommentary = """
            हे दिव्य सोमदेव! आप हमारी श्रद्धापूर्ण स्तुतियों के साथ अत्यंत आनंददायक और हर्षित होकर अपनी पावन धारा के साथ यहाँ प्रवाहित हों। 
            आप विशेष रूप से इन्द्रदेव के पान करने के लिए तैयार किए गए हैं, कृपया उन्हें तृप्त करने और बल प्रदान करने के लिए दिव्य पात्रों की ओर बढ़ें। 
            इन्द्र और सोम का यह मिलन ब्रह्मांडीय शक्ति और आध्यात्मिक आनंद के उस संगम का प्रतीक है जो धर्म की रक्षा के लिए परम आवश्यक है। 
            जब आप इन्द्र के अस्तित्व में प्रवाहित होते हैं, तो वे अजेय और वज्र के समान शक्तिशाली बन जाते हैं और हमारे समस्त शत्रुओं का दमन करते हैं। 
            आपकी यह पावन धारा हमारे अंतःकरण को पूर्णतः शुद्ध कर हमें उच्चतर दिव्य अनुभूतियों और ईश्वर के साक्षात् के योग्य बनाने की सामर्थ्य रखती है। 
            हे देव, आप हमारे इस यज्ञ को सिद्ध और सफल बनाएं और हमारे श्रेष्ठ संकल्पों को देवताओं के महान आशीर्वादों के साथ सफलतापूर्वक जोड़ दें। 
            हमारी वाणी में वह सत्य, ओज और तेज भर दें कि हमारी भक्तिपूर्ण पुकार सीधे आपके और देवराज इन्द्र के हृदय के गहन स्तरों तक पहुँच सके। 
            आप ही वह दिव्य अमृत हैं जो मृत्यु के भय और सांसारिक दुखों को समाप्त कर मनुष्य को अमरता और मोक्ष के परम पथ पर अग्रसर करता है। 
            हम अत्यंत श्रद्धापूर्वक आपकी वंदना करते हैं ताकि आपकी उदारता का अमृत प्रवाह हमारे जीवन और परिवार में सदैव निरंतर और शाश्वत बना रहे। 
            हे पवमान सोम, आप हमारे परम रक्षक और मार्गदर्शक बनकर हमें जीवन की सफलता और दिव्यता के सर्वोच्च और पवित्रतम शिखर पर पहुँचाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Divine Soma, flow here in your sacred stream, being most exhilarating and joyful, accompanied by our profound and devoted hymns. 
            You have been specifically prepared for the consumption of Lord Indra; please proceed toward the divine vessels to satisfy and strengthen him. 
            This union of Indra and Soma symbolizes the confluence of cosmic power and spiritual bliss, which is essential for the defense of Dharma. 
            When you flow through Indra's existence, he becomes invincible and powerful like his thunderbolt, subduing all the enemies of our lives. 
            This holy stream of yours possesses the power to completely purify our inner self and make us worthy of higher divine realizations. 
            O God, make our sacrifice successful and meaningful, and successfully connect our noble resolutions with the great blessings of the gods. 
            Fill our voices with such truth, vigor, and brilliance that our devoted calls reach the deepest levels of your heart and Indra's heart. 
            You are the divine nectar that terminates the fear of death and worldly sorrows, driving humans forward on the path of immortality and liberation. 
            We worship you with profound devotion so that the nectar-like flow of your immense generosity remains forever constant and eternal in our lives. 
            O Pavamana Soma, stay as our supreme protector and guide, leading us graciously to the highest and holiest peaks of success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 99,
        sanskrit = "तं वो मदाय घृष्वये सोमं विश्वाभिरूतिभिः ।\nइन्द्राय गायत सुतम् ॥ ९९ ॥",
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
        id = 100,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ १०० ॥",
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
        id = 101,
        sanskrit = "पुनानः सोम धारया अपो वसानो अर्षसि ।\nआ रत्नधा योनिं ऋतस्य सीदसि ॥ १०१ ॥",
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
        id = 102,
        sanskrit = "अक्षण्वन्तः कर्णवन्तः सखायो मनोजवेषु असमा बभूवुः ।\nआदध्रास उपकक्षास उ त्वे ह्रदा इव स्त्रावा दृश्यन्ते ॥ १०२ ॥",
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
        id = 103,
        sanskrit = "यस्य ते द्युमतो मदा अच्छा विचेतसा ।\nसोम अर्षसि धारया ॥ १०३ ॥",
        hindiCommentary = """
            हे सोम! आपकी वह आनंददायक और मदहोश कर देने वाली धारा, जो विशेष ज्ञान (विचेतसा) से युक्त है, हमारे कल्याण के लिए प्रवाहित हो। 
            आप स्वयं प्रकाशमान (द्युमतः) हैं, और आपकी धारा हमारे जीवन के अंधकारमय मार्गों को अपनी ज्योति से आलोकित कर देने वाली है। 
            सोम का मद कोई सांसारिक नशा नहीं, बल्कि वह आध्यात्मिक आह्लाद है जो आत्मा को परमात्मा के साथ एकरूप कर देता है। 
            आपकी यह चेतना हमें वह शक्ति प्रदान करती है जिससे हम जीवन की जटिलताओं को समझकर सत्य का मार्ग चुनने में समर्थ होते हैं। 
            हे देव, आप हमारे यज्ञ में अपनी मधुर धारा के साथ पधारें और हमारे संकल्पों को दिव्यता की मिठास से पूरी तरह भर दें। 
            जब आपकी कृपा का प्रवाह हमारे जीवन में आता है, तो समस्त दुःख और दरिद्रता कपूर की तरह उड़कर सदा के लिए समाप्त हो जाते हैं। 
            हमें वह 'विचेतस' (विशेष बोध) प्रदान करें जिससे हम संसार के क्षणभंगुर आकर्षणों के प्रति अनासक्त होकर आपके प्रति समर्पित रहें। 
            आप ही वह शक्ति हैं जो हमारे शिथिल मन को ऊर्जावान बनाती हैं और हमें निरंतर प्रगति के पथ पर गतिशील रखती हैं। 
            हम श्रद्धापूर्वक आपकी महिमा का गान करते हैं ताकि आपकी उदारता का प्रवाह हमारे घर और हृदय में सदैव निरंतर बना रहे। 
            हे दिव्य सोम, आप हमारे रक्षक और पालनहार के रूप में सदैव हमारे साथ रहकर हमें वैभवशाली और यशस्वी बनाने की कृपा करें।
        """.trimIndent(),
        englishCommentary = """
            O Soma, may your exhilarating and intoxicating stream, combined with special wisdom (Vichetasa), flow for our welfare and peace. 
            You are self-radiant (Dyumatah), and your current is destined to illuminate the dark pathways of our existence with its eternal light. 
            The exhilaration of Soma is not a worldly intoxication but that spiritual bliss which unifies the individual soul with the Supreme Being. 
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
        id = 104,
        sanskrit = "एते असृग्रमिन्दवस्तिरः पवित्रमाशवः ।\nविश्वान्यभि सौभगा ॥ १०४ ॥",
        hindiCommentary = """
            ये अत्यंत तीव्र गति वाले सोमरस के कण (इन्दवः) पवित्र छननी के माध्यम से निरंतर प्रवाहित होकर हमारे लिए सौभाग्य लेकर आ रहे हैं। 
            इनका यह वेगपूर्ण प्रवाह हमारे अंतःकरण की समस्त जड़ता को नष्ट कर उसमें दिव्यता और सकारात्मक ऊर्जा का संचार करने वाला है। 
            जैसे सोम की धाराएं पात्र में गिरती हैं, वैसे ही ईश्वर की अनन्य कृपा हमारे जीवन के रिक्त पात्रों को प्रचुरता से भर देने वाली हो। 
            पवित्रता ही वह आवश्यक शर्त है जिससे ईश्वरीय शक्तियाँ हमारे समीप आती हैं और हमारे आध्यात्मिक पुरुषार्थ को सफल बनाती हैं। 
            हे देव, आप हमारे चंचल मन को अपनी पावन धारा से शुद्ध कर उसे एकाग्र और केवल उच्चादर्शों के प्रति समर्पित बना देने की कृपा करें। 
            आपका यह निरंतर प्रवाह अज्ञान के काले आवरणों को हटाकर हमें सत्य के दर्शन कराने और हमें ईश्वर के समीप ले जाने में सहायक है। 
            हम आपकी वंदना करते हैं क्योंकि आप ही आनंद के परम अधिपति हैं और अपने भक्तों के मानसिक संतापों को हरने वाले दयालु देव हैं। 
            यज्ञ की इस पवित्र अग्नि में आपकी आहुति समस्त देवताओं को पुष्ट करती है और संपूर्ण चराचर ब्रह्मांड को जीवनी ऊर्जा प्रदान करती है। 
            हमें वह आध्यात्मिक सामर्थ्य और धैर्य प्रदान करें जिससे हम संसार के द्वंद्वों से ऊपर उठकर सदैव आंतरिक रूप से शांत और सुखी रहें। 
            हे पवमान सोम, आपकी यह तेजस्वी धारा हमारे घरों को सुख, अखंड शांति और दिव्य समृद्धि से भर देने वाली एक मंगलकारी शक्ति बने।
        """.trimIndent(),
        englishCommentary = """
            These swift and holy drops of Soma (Indavah) are flowing continuously through the sacred filter, bringing forth immense good fortune. 
            Their rapid and energetic flow is essential for destroying the lethargy of our inner self and infusing it with divine dynamism. 
            Just as the streams of Soma fall into the ritual vessel, may the exclusive grace of God fill the empty vessels of our lives with plenty. 
            Purity is the mandatory condition through which celestial forces approach us and make our spiritual endeavors successful and holy. 
            O God, purify our restless minds with your holy stream and make them focused and entirely dedicated to the highest spiritual ideals. 
            Your continuous flow acts as a catalyst in removing the dark veils of ignorance, helping us perceive Truth and drawing us closer to God. 
            We worship you as the ultimate source of bliss, the compassionate deity who removes the mental afflictions of your devoted followers. 
            Your oblation in this sacred fire nourishes all the deities and provides fresh vitalizing energy to the entire moving and non-moving cosmos. 
            Grant us that spiritual capability and patience through which we can rise above worldly dualities and remain internally peaceful and happy. 
            O Pavamana Soma, let this radiant stream of yours manifest as the auspicious power that fills our homes with peace and prosperity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 105,
        sanskrit = "अभि प्र मन्दिनं गिरः सोमं पवस्व धारया ।\nइन्द्राय पातवे सुतम् ॥ १०५ ॥",
        hindiCommentary = """
            हे दिव्य सोमदेव! आप हमारी श्रद्धापूर्ण स्तुतियों के साथ अत्यंत आनंददायक होकर अपनी पावन धारा के साथ यहाँ निरंतर प्रवाहित हों। 
            आप विशेष रूप से देवराज इन्द्र के पान करने के लिए तैयार किए गए हैं, कृपया उन्हें तृप्त करने और अजेय बल प्रदान करने के लिए आगे बढ़ें। 
            इन्द्र और सोम का यह मिलन ब्रह्मांडीय शक्ति और आध्यात्मिक आनंद के उस महान संगम का प्रतीक है जो धर्म की रक्षा के लिए अनिवार्य है। 
            जब आप इन्द्र के अस्तित्व में प्रवाहित होते हैं, तो वे अजेय बन जाते हैं और हमारे जीवन के आंतरिक एवं बाह्य शत्रुओं का दमन करते हैं। 
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
            You are the divine nectar that terminates the fear of death and worldly attachments, driving humans toward the path of immortality and liberation. 
            We worship you with profound devotion so that the nectar-like flow of your immense generosity remains forever constant in our lives. 
            O Pavamana Soma, stay as our supreme protector and guide, leading us graciously to the highest and holiest peaks of success and divinity.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 106,
        sanskrit = "तं वो मदाय घृष्वये सोमं विश्वाभिरूतिभिः ।\nइन्द्राय गायत सुतम् ॥ १०६ ॥",
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
        id = 107,
        sanskrit = "पवमानस्य ते कवे वाजी ससर्ज ऊर्मिणः ।\nअभि रत्नानि देवयन् ॥ १०७ ॥",
        hindiCommentary = """
            हे पवमान कवि सोम! आपकी अत्यंत शक्तिशाली और पवित्र लहरें रत्नों और दिव्य गुणों की कामना करती हुई तीव्र गति से प्रवाहित हो रही हैं। 
            आप स्वयं शाश्वत ज्ञान के पुंज हैं और जब आप अपनी दिव्य तरंगों के साथ बहते हैं, तो आप अपने उपासकों के लिए सौभाग्य और शांति का संदेश लाते हैं। 
            जैसे समुद्र की लहरें तट पर बहुमूल्य और दुर्लभ वस्तुएं लेकर आती हैं, वैसे ही आपकी धारा हमारे जीवन में आध्यात्मिक रत्न और सद्गुणों का संचार करती है। 
            हे देव, आपकी ये पावन लहरें हमारे मन के समस्त संताप, अज्ञान और नकारात्मक विचारों को बहा ले जाएं और हमें शांति के सागर में सराबोर कर दें। 
            आपकी ऊर्जा हमें वह सामर्थ्य प्रदान करती है जिससे हम संसार के भ्रामक मायाजाल को भेदकर ईश्वर के वास्तविक और दिव्य स्वरूप का दर्शन करने में सफल होते हैं। 
            हमें वह 'रत्न' प्रदान करने की कृपा करें जो हमारे चरित्र को बलवान और उज्ज्वल बनाएं ताकि हम समाज के लिए एक महान आदर्श बन सकें। 
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
            Graciously bestow upon us those 'gems' that make our character strong and bright, so we may present a magnificent ideal for society. 
            You are the primordial power that possesses the strength to transform our subtle intentions into cosmic achievements; we seek your refuge. 
            We worship you with devotion so that the rain of your grace remains continuous, pleasant, and unbroken within our lives and our families. 
            Just as waves represent continuity, may our unshakable devotion toward you remain constant and selfless; this is our humble and heartfelt prayer. 
            O Divine Soma, through these holy and radiant waves of yours, purify our inner self and make it worthy of the eternal proximity of God.
        """.trimIndent()
    ),
    PurvarchikaVerse(
        id = 108,
        sanskrit = "पवस्व वाचो अग्रियः सोम चित्तिभिः अर्णवः ।\nयोनिं कनिक्रदत् आसदः ॥ १०८ ॥",
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
        id = 109,
        sanskrit = "आ तू नः सोम पवस्व सुवीर्यं पवस्व रयिम् ।\nपवस्व मयः ॥ १०९ ॥",
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
        id = 110,
        sanskrit = "पवमानो नः पावकः स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ११० ॥",
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
        id = 111,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ १११ ॥",
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
        id = 112,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ११२ ॥",
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
        id = 113,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ ११३ ॥",
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
        id = 114,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ ११४ ॥",
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
        id = 115,
        sanskrit = "स नः पावक दीविपश्चित्रं रयिं य ईशषे ।\nइषं स्तोतृभ्य आ भर ॥ ११५ ॥",
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
        id = 116,
        sanskrit = "त्वमग्ने यज्ञानां होता विश्वेषां हितः ।\nदेवेभिर्मानुषे जने ॥ ११६ ॥",
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
        id = 117,
        sanskrit = "अहेळता मनसा देव देवाञ्छ्रद्धायतः कुरु ।\nयुष्मत्तां अदि्वयस्वतः ॥ ११७ ॥",
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
        id = 118,
        sanskrit = "अग्ने रक्षा णो अंहसः प्रति ष्म देव रीषतः ।\nतपिष्ठैरजरो दह ॥ ११८ ॥",
        hindiCommentary = """
            हे अग्निदेव! आप हमें पापों के भयानक गर्त और अज्ञान के संकटों से सदैव सुरक्षित रखने की अपनी असीम और महान कृपा हम पर निरंतर बनाए रखें। 
            जो भी नकारात्मक शक्तियाँ हमारा अहित करना चाहती हैं, आप अपनी प्रखर बुद्धि से उनके समस्त षड्यंत्रों को विफल कर हमें पूर्ण सुरक्षा प्रदान करें। 
            हे अजर और तेजस्वी देव, आप अपनी अत्यंत तप्त और पवित्र ज्वालाओं से हमारे भीतर के समस्त दोषों, विकारों और बुराइयों को जड़ से जला डालें। 
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
        id = 119,
        sanskrit = "यविष्ठ्य स्वाहुत युष्मत्ताँ अदि्वयस्वतः ।\nअग्ने रक्षस्वतस्कृधि ॥ ११९ ॥",
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
        id = 120,
        sanskrit = "अग्ने विवस्वदा भर स्वाहुत ।\nवयस्वतः स नः पावक दीविपश्चित्रं रयिं य ईशषे ॥ १२० ॥",
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
        id = 121,
        sanskrit = "त्वामग्ने पुष्यन्ति पुष्टयः सप्रथस्व मतीः ।\nचर्कृत्यमाना यविष्ठ्य ॥ १२१ ॥",
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
    )
)