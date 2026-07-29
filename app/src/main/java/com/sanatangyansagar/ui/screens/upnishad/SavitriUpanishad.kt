package com.sanatangyansagar.ui.screens.upnishad

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

// Local Data Model
data class UpanishadVerse(
    val id: Int,
    val sanskrit: String,
    val hindiCommentary: String,
    val englishCommentary: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavitriUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            savitriUpanishadData
        } else {
            savitriUpanishadData.filter {
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
                        Text(
                            text = "सावित्री उपनिषद",
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFE65100) // Deep Saffron
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFF8E1) // Light Gold
                    )
                )
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("खोजें (श्लोक संख्या या शब्द)...") },
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
                UpanishadVerseCard(verse)
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

@Composable
fun UpanishadVerseCard(verse: UpanishadVerse) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "मंत्र ${verse.id}",
                color = Color(0xFFE65100),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = verse.sanskrit,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A237E),
                lineHeight = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "हिंदी भावार्थ:",
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFE91E63),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = verse.hindiCommentary,
                fontSize = 15.sp,
                color = Color.DarkGray,
                lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "English Commentary:",
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF2196F3),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = verse.englishCommentary,
                fontSize = 15.sp,
                color = Color.DarkGray,
                lineHeight = 24.sp
            )
        }
    }
}

val savitriUpanishadData = listOf(
    UpanishadVerse(
        id = 1,
        sanskrit = "सविता कः ? सावित्री का ? \nअग्निरेव सविता पृथिवी सावित्री। \nयत्राग्निस्तत्पृथिवी यत्र पृथिवी तत्राग्निः। \nते द्वे योनी। ते एकं मिथुनम् ॥ १ ॥",
        hindiCommentary = """
            शौनक ऋषि पूछते हैं—"सविता (सृष्टिकर्ता/पुरुष तत्त्व) कौन है? और सावित्री (सृजन-शक्ति/प्रकृति तत्त्व) क्या है?"
            उपनिषद उत्तर देता है—"अग्नि ही 'सविता' है और यह पृथ्वी ही 'सावित्री' है। ये दोनों एक-दूसरे से अविभाज्य हैं।"
            जहाँ अग्नि का वास है, वहीं पृथ्वी का अस्तित्व है; और जहाँ पृथ्वी है, वहाँ अग्नि (ऊर्जा/ताप) निश्चित रूप से विद्यमान है।
            ये दोनों (अग्नि और पृथ्वी) सृष्टि के मूल कारण (योनी) हैं। ये दोनों मिलकर ब्रह्मांड का एक पूर्ण जोड़ा (मिथुन) बनाते हैं।
            सावित्री उपनिषद इस श्लोक से ब्रह्मांड के अद्वैत (Non-dual) सिद्धांत को स्थापित करता है, जहाँ शिव और शक्ति, या पुरुष और प्रकृति अलग नहीं हैं।
            सविता उस ऊर्जा का स्रोत है जो गति प्रदान करता है, और सावित्री वह आधार है जिस पर वह ऊर्जा प्रकट होती है।
            पृथ्वी के बिना अग्नि का कोई आधार नहीं है, और अग्नि (ताप) के बिना पृथ्वी मृत और जड़ है।
            यह श्लोक विज्ञान के इस सिद्धांत को भी पुष्ट करता है कि पदार्थ (Matter - Earth) और ऊर्जा (Energy - Fire) एक ही सिक्के के दो पहलू हैं।
            इस 'मिथुन' (जोड़े) को समझने से ही गायत्री और सावित्री मंत्रों के वास्तविक अर्थ और शक्ति का बोध होता है।
            सनातन दर्शन में ईश्वर को कभी भी एक अकेला या एकांगी सत्ता नहीं माना गया है; वह हमेशा 'शक्ति' के साथ ही पूर्ण होता है।
        """.trimIndent(),
        englishCommentary = """
            Sage Shaunaka asks: "Who is Savita (the Creator/Masculine principle)? And what is Savitri (the Divine Energy/Feminine principle)?"
            The Upanishad answers: "Agni (Fire) is indeed Savita, and Prithvi (Earth) is Savitri. They are absolutely inseparable."
            Wherever there is Fire, Earth exists; and wherever Earth exists, Fire (thermal energy/heat) is inevitably present.
            These two are the fundamental wombs (Yoni) or cosmic causes of creation. Together, they form a single, perfect pair (Mithuna).
            The Savitri Upanishad establishes the profound philosophy of Non-duality (Advaita) here, illustrating that Shiva and Shakti, or Purusha and Prakriti, are never separate.
            Savita is the active source of energy, while Savitri is the material foundation upon which that cosmic energy manifests.
            Without Earth, Fire has no foundation to burn upon; without Fire (heat), the Earth would be a completely dead, frozen, and static entity.
            This verse profoundly aligns with the modern scientific principle that Matter (Earth) and Energy (Fire) are fundamentally interchangeable facets of the exact same reality.
            Understanding this 'Mithuna' (Cosmic Pair) is the ultimate key to decoding the true, hidden power of the Gayatri and Savitri mantras.
            In Sanatan philosophy, the Supreme God is never viewed in isolation; He is only complete and functional in eternal union with His Divine Energy.
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 2,
        sanskrit = "वरुण एव सविता आपः सावित्री। \nयत्र वरुणस्तदापो यत्रापस्तद्वरुणः। \nते द्वे योनी। ते एकं मिथुनम् ॥ २ ॥",
        hindiCommentary = """
            आगे बताया गया है—"वरुण देवता ही 'सविता' (प्रेरक/सृष्टिकर्ता) हैं और आपः (जल) ही 'सावित्री' (उनकी शक्ति) है।"
            "जहाँ-जहाँ वरुण का साम्राज्य है, वहाँ-वहाँ जल विद्यमान है; और जहाँ-जहाँ जल है, वहाँ साक्षात् वरुण उपस्थित हैं।"
            जल (Water) सृष्टि के जीवन का आधार है, परंतु उस जल के भीतर जो जीवन देने का गुण और रस (Essence) है, वह वरुण (सविता) है।
            ये दोनों (वरुण और जल) भी सृष्टि के निर्माण के मूल कारण (योनी) हैं और मिलकर एक पूर्ण जोड़ा (मिथुन) बनाते हैं।
            वरुण को वैदिक साहित्य में ब्रह्मांड के नैतिक नियमों (ऋत) और जलीय तत्वों का स्वामी माना गया है।
            जल सावित्री है, जो प्रकृति का वह तरल और कोमल रूप है जो बीजों को पोषण देकर जीवन उत्पन्न करती है।
            वरुण उस जल के भीतर का 'चेतन तत्त्व' (Conscious element) है, जो सुनिश्चित करता है कि जल अपना धर्म न भूले।
            अग्नि और पृथ्वी (पहले श्लोक में) जहाँ ठोस संरचना बनाते हैं, वहीं वरुण और जल जीवन को प्रवाह (Flow) और शीतलता प्रदान करते हैं।
            इस श्लोक से यह स्पष्ट होता है कि सावित्री कोई एक स्त्री नहीं है; वह ब्रह्मांड की हर सृजनात्मक शक्ति और भौतिक तत्व का नाम है।
            सविता और सावित्री का यह जोड़ा हमें सिखाता है कि देव (ईश्वर) और उसका रूप (प्रकृति) कभी अलग नहीं किए जा सकते।
        """.trimIndent(),
        englishCommentary = """
            The Upanishad continues: "The deity Varuna is Savita (the Inspirer), and Apah (Water) is Savitri (His divine power)."
            "Wherever the domain of Varuna exists, Water is present; and wherever Water flows, Varuna is directly and inherently manifest."
            Water is the absolute basis of biological life, but the intrinsic, life-giving essence and nourishing quality within that water is Varuna (Savita).
            These two (Varuna and Water) are also the fundamental causes (Yoni) of cosmic creation, merging flawlessly to form a complete, eternal pair (Mithuna).
            In Vedic literature, Varuna is celebrated as the sovereign lord of cosmic moral order (Rita) and all aquatic elements.
            Water represents Savitri—the fluid, gentle, and nurturing aspect of Nature (Prakriti) that germinates seeds and sustains all existence.
            Varuna is the 'Conscious Element' operating within that water, ensuring it strictly adheres to its life-giving Dharma.
            While Fire and Earth (in the previous verse) establish solid structure, Varuna and Water provide essential flow, adaptability, and cooling nourishment to creation.
            This verse makes it crystal clear that Savitri is not merely a single female deity; she is the universal name for every creative force and physical element in the cosmos.
            This divine pair of Savita and Savitri teaches the profound lesson that the Deity (God) and His manifestation (Nature) can never be divorced from one another.
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 3,
        sanskrit = "वायुरेव सविताकाशः सावित्री। \nयत्र वायुस्तदाकाशो यत्राकाशस्तद्वायुः। \nते द्वे योनी। ते एकं मिथुनम् ॥ ३ ॥",
        hindiCommentary = """
            उपनिषद कहता है—"वायु (पवन) ही 'सविता' है, और आकाश (अंतरिक्ष/Space) ही 'सावित्री' है।"
            "जहाँ वायु है, वहाँ आकाश का होना अनिवार्य है; और जहाँ आकाश है, वहाँ वायु का अस्तित्व स्वयं ही सिद्ध हो जाता है।"
            वायु गति और प्राण (Life-force) का प्रतीक है, जबकि आकाश वह अनंत शून्यता (Space) है जो उस वायु को बहने के लिए स्थान प्रदान करता है।
            ये दोनों (वायु और आकाश) सृजन के कारण (योनी) हैं और एक पूर्ण जोड़ा (मिथुन) हैं।
            आकाश के बिना वायु की कोई गति संभव नहीं है; यदि कोई खाली स्थान ही न हो, तो वायु कैसे बहेगी?
            उसी प्रकार, वायु के बिना आकाश एक मृत शून्यता (Dead Vacuum) मात्र रह जाएगा, उसमें जीवन का संचार नहीं हो सकेगा।
            सविता (वायु) पुरुष तत्त्व है जो क्रियाशील (Active) है, और सावित्री (आकाश) वह स्त्री तत्त्व है जो उस क्रिया को अपने भीतर धारण (Receptive) करती है।
            यह श्लोक भौतिक विज्ञान (Physics) के उस सिद्धांत को भी छूता है जहाँ 'स्पेस' और 'प्राण-ऊर्जा' मिलकर जीवन के आयाम (Dimensions) तय करते हैं।
            सावित्री मंत्र के ध्यान में साधक को इसी वायु और आकाश की एकता का चिंतन करना चाहिए, जिससे उसका मन असीम और शांत हो जाए।
            इन जोड़ों के माध्यम से उपनिषद हमें ब्रह्मांड की उस महान 'सिम्फनी' (Symphony) को समझा रहा है जो एक-दूसरे के पूरक तत्वों से बनी है।
        """.trimIndent(),
        englishCommentary = """
            The Upanishad declares: "Vayu (Wind/Air) is indeed Savita, and Akasha (Space/Ether) is Savitri."
            "Wherever there is Vayu, Akasha must inevitably exist; and wherever Akasha is present, the existence of Vayu is naturally established."
            Vayu symbolizes kinetic motion and the vital life-force (Prana), whereas Akasha represents the infinite, expansive void that provides the necessary space for Vayu to flow.
            These two (Air and Space) are the cosmic wombs (Yoni) of creation, existing together as an absolutely perfect, inseparable pair (Mithuna).
            Without the vastness of Space, the movement of Air is mathematically and physically impossible; if there is no empty void, how can the wind blow?
            Similarly, without Air, Space would remain a mere dead, stagnant vacuum, entirely devoid of any vibrant circulation of life.
            Savita (Vayu) acts as the active, dynamic Masculine principle, while Savitri (Akasha) acts as the receptive Feminine principle that gracefully holds and accommodates that action.
            This verse profoundly touches upon the physics of reality, where 'Space' and 'Kinetic Energy' combine to define the very dimensions of existence.
            While meditating on the Savitri mantra, a seeker must contemplate this absolute unity of Wind and Space, instantly expanding and tranquilizing the mind.
            Through these divine pairs, the Upanishad is masterfully orchestrating the grand 'Symphony' of the universe, built entirely upon flawlessly complementary elements.
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 4,
        sanskrit = "यज्ञ एव सविता छन्दांसि सावित्री। \nयत्र यज्ञस्तच्छन्दांसि यत्र छन्दांसि तद्यज्ञः। \nते द्वे योनी। ते एकं मिथुनम् ॥ ४ ॥",
        hindiCommentary = """
            अब आध्यात्मिक स्तर पर बात करते हुए उपनिषद कहता है—"महान 'यज्ञ' (Sacrifice) ही 'सविता' है, और वेदों के 'छंद' (Meters/Mantras) ही 'सावित्री' हैं।"
            "जहाँ यज्ञ होता है, वहाँ वैदिक छंदों का उच्चारण अनिवार्य रूप से होता है; और जहाँ वेदों के छंद गूँजते हैं, वहाँ स्वतः ही यज्ञ संपन्न हो जाता है।"
            यज्ञ वह क्रिया है जो ईश्वर को प्रसन्न करती है, और छंद वह ध्वनि या नियम (जैसे गायत्री, त्रिष्टुप) है जिसके द्वारा वह क्रिया संपन्न होती है।
            ये दोनों (यज्ञ और छंद) आध्यात्मिक सृजन के मूल (योनी) हैं और आपस में मिलकर एक पूर्ण और पवित्र जोड़ा (मिथुन) बनाते हैं।
            बिना मंत्रों (छंदों) के किया गया यज्ञ केवल एक कर्मकांड या अग्नि जलाना मात्र रह जाता है, उसमें कोई दैवीय शक्ति उत्पन्न नहीं होती।
            उसी प्रकार, बिना यज्ञ (समर्पण और त्याग) के केवल मंत्रों का रटना एक खोखली ध्वनि है, उसका कोई आध्यात्मिक फल नहीं मिलता।
            सविता (यज्ञ) क्रिया है, और सावित्री (छंद) उस क्रिया की आत्मा और विज्ञान है।
            वाल्मीकि रामायण के बालकाण्ड में राजा दशरथ ने जब पुत्रेष्टि यज्ञ किया था, तो वह इसी सिद्धांत पर आधारित था—महान यज्ञ और शुद्ध वैदिक छंदों का मिलन।
            इस श्लोक से यह सिद्ध होता है कि ईश्वर की प्राप्ति के लिए 'कर्म' (Action) और 'ज्ञान/मंत्र' (Knowledge) दोनों का एक साथ होना अत्यंत आवश्यक है।
            यही कारण है कि सावित्री (गायत्री) मंत्र को सभी यज्ञों की जननी और पूर्णता का प्रतीक माना जाता है।
        """.trimIndent(),
        englishCommentary = """
            Transitioning to the spiritual and ritualistic plane, the Upanishad states: "The grand 'Yajna' (Sacrifice) is Savita, and the Vedic 'Chandas' (Poetic Meters/Mantras) are Savitri."
            "Wherever a Yajna is performed, the chanting of Vedic meters inevitably occurs; and wherever sacred meters resonate, a Yajna is automatically established."
            Yajna is the supreme, selfless action designed to please the Divine, while Chandas (like Gayatri, Trishtubh) constitute the precise sonic formulas and rhythmic laws through which that action is successfully executed.
            These two (Sacrifice and Mantras) are the foundational wombs (Yoni) of all spiritual creation, merging perfectly to form a highly sacred, complete pair (Mithuna).
            A sacrifice conducted entirely without mantras (meters) is reduced to a mere mechanical lighting of fire, completely incapable of generating any divine, transcendental energy.
            Similarly, mindlessly reciting mantras without the core spirit of Yajna (surrender and sacrifice) is merely a hollow vibration yielding absolutely zero spiritual fruit.
            Savita (Yajna) represents the dynamic physical Action, whereas Savitri (Chandas) embodies the soul and exact science behind that action.
            When King Dasharatha performed the Putreshti Yajna in the Bala Kanda of the Ramayana, its absolute success was strictly rooted in this exact principle—the flawless union of grand sacrifice and pure Vedic meters.
            This verse proves that to attain the Supreme Lord, the simultaneous execution of both 'Karma' (Action) and 'Mantra/Jnana' (Knowledge) is an absolute, non-negotiable necessity.
            This is precisely why the Savitri (Gayatri) mantra is universally revered as the supreme mother and ultimate perfection of all Vedic sacrifices.
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 5,
        sanskrit = "स्तनयित्नुरेव सविता विद्युत्सावित्री। \nयत्र स्तनयित्नुस्तद्विद्युद् यत्र विद्युत्तत्स्तनयित्नुः। \nते द्वे योनी। ते एकं मिथुनम् ॥ ५ ॥",
        hindiCommentary = """
            प्राकृतिक शक्तियों का वर्णन करते हुए श्रुति कहती है—"स्तनयित्नु (मेघों की गर्जना/Thunder) ही 'सविता' है, और विद्युत् (आकाशीय बिजली/Lightning) ही 'सावित्री' है।"
            "जहाँ बादलों की भयंकर गर्जना होती है, वहाँ बिजली अवश्य चमकती है; और जहाँ बिजली चमकती है, वहाँ बादलों का नाद (गर्जना) अनिवार्य रूप से होता है।"
            स्तनयित्नु (गर्जना) ध्वनि (Sound) का प्रतीक है जो आकाश को गुंजा देती है, जबकि विद्युत् (बिजली) उस ध्वनि के साथ प्रकट होने वाला प्रचंड प्रकाश (Light) है।
            ये दोनों (गर्जना और बिजली) एक ही तूफ़ान या वर्षा-चक्र के मूल कारण (योनी) हैं और ये कभी अलग नहीं होते, ये एक पूर्ण जोड़ा (मिथुन) हैं।
            वैज्ञानिक दृष्टि से भी प्रकाश (Lightning) और ध्वनि (Thunder) एक ही मौसमी घटना के दो पहलू हैं; बस प्रकाश की गति अधिक होने के कारण वह पहले दिखाई देती है।
            गर्जना पुरुष तत्त्व (सविता) की उस ओजस्वी शक्ति को दर्शाती है जो संसार को जाग्रत करती है, और बिजली स्त्री तत्त्व (सावित्री) की उस चमक को दर्शाती है जो अंधकार को चीर देती है।
            वर्षा ऋतु में जब ये दोनों एक साथ मिलते हैं, तो धरती पर जीवन (खेती और जल) का नया संचार होता है; यह प्रकृति का 'सृजन-नृत्य' (Dance of Creation) है।
            सावित्री मंत्र के साधक को यह समझना चाहिए कि ईश्वरीय ऊर्जा शांत भी हो सकती है और आवश्यकता पड़ने पर बादलों की गर्जना और बिजली के समान प्रचंड भी।
            यह श्लोक सृष्टि की उस भयानक परंतु अत्यंत आवश्यक और सुंदर ऊर्जा का वर्णन करता है जो पुराने को नष्ट कर नए जीवन को जन्म देती है।
            प्रकृति में हर जोड़ा एक-दूसरे का पूरक है, यही अद्वैत दर्शन का मूल पाठ है।
        """.trimIndent(),
        englishCommentary = """
            Describing the fierce forces of nature, the Shruti states: "Stanayitnu (Thunder/the roaring of clouds) is Savita, and Vidyut (Lightning) is Savitri."
            "Wherever the terrifying roar of thunder echoes, lightning inevitably flashes; and wherever lightning fiercely strikes, the deep rumble of thunder is unconditionally present."
            Stanayitnu (Thunder) symbolizes raw, acoustic power (Sound) that violently shakes the heavens, whereas Vidyut (Lightning) is the blazing, blinding illumination (Light) that manifests alongside it.
            These two (Thunder and Lightning) are the fundamental causes (Yoni) of the storm and rain-cycle; they are eternally inseparable, forming a perfect, terrifying cosmic pair (Mithuna).
            Even from a strict scientific perspective, Lightning and Thunder are twin facets of the exact same meteorological event; lightning simply appears first because the speed of light exponentially exceeds the speed of sound.
            Thunder represents the masculine principle's (Savita) majestic, awakening roar, while Lightning embodies the feminine principle's (Savitri) brilliant, darkness-piercing radiance.
            When these two unite during the monsoons, they forcefully inject brand-new life (agriculture and water) into the earth; this represents Nature's violent yet beautiful 'Dance of Creation.'
            A dedicated seeker of the Savitri mantra must realize that divine energy can be profoundly peaceful, but when required, it can erupt with the terrifying ferocity of thunder and lightning.
            This verse captures the fearsome, highly essential, and breathtaking energy of the cosmos that aggressively destroys stagnation to birth fresh, vibrant existence.
            Every pair in nature perfectly complements the other, which is the foundational, ultimate lesson of Advaita (Non-dual) philosophy.
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 6,
        sanskrit = "आदित्य एव सविता द्यौः सावित्री। \nयत्रादित्यस्तद् द्यौर्यत्र द्यौस्तदादित्यः। \nते द्वे योनी। ते एकं मिथुनम् ॥ ६ ॥",
        hindiCommentary = """
            ब्रह्मांडीय स्तर (Cosmic level) पर उपनिषद कहता है—"आदित्य (सूर्य) ही 'सविता' है, और द्यौः (स्वर्ग/आकाशगंगा) ही 'सावित्री' है।"
            "जहाँ सूर्य देव का वास है, वहीं द्यौः (स्वर्ग/ब्रह्मांडीय आकाश) का अस्तित्व है; और जहाँ द्यौः है, वहाँ सूर्य का प्रकाश आवश्यक रूप से विद्यमान है।"
            सूर्य पूरे सौरमंडल का ऊर्जा-केंद्र और स्वामी (सविता) है, जबकि द्यौः वह विशाल और अनंत आकाशगंगा है जो उस सूर्य को अपने भीतर धारण करती है।
            ये दोनों (सूर्य और ब्रह्मांडीय आकाश) इस संपूर्ण सौर-सृष्टि के कारण (योनी) हैं और मिलकर एक अविभाज्य जोड़ा (मिथुन) बनाते हैं।
            यदि विशाल अंतरिक्ष (द्यौः) न हो, तो सूर्य अपनी किरणों का विस्तार कहाँ करेगा? उसका प्रकाश अर्थहीन हो जाएगा।
            और यदि सूर्य (आदित्य) न हो, तो वह विशाल आकाश केवल एक भयानक और अंधकारमय शून्यता (Dark Abyss) बनकर रह जाएगा।
            सविता (सूर्य) प्रकाश, ऊष्मा और जीवन-शक्ति का प्रतीक है; और सावित्री (द्यौः) उस शक्ति की माता और आश्रय-स्थली है।
            गायत्री मंत्र में जिस 'संवितुर' (सूर्य) का ध्यान किया जाता है, वह यही आदित्य है, और उसकी जो सर्वव्यापक रश्मियां हैं, वही सावित्री हैं।
            यह श्लोक हमें बताता है कि ईश्वर (सूर्य) और उसका धाम (द्यौः) कभी भी अलग नहीं हो सकते; वे शाश्वत रूप से एक ही सत्ता के दो स्वरूप हैं।
            यही वह परम प्रकाश है जो साधक की बुद्धि को अंधकार से निकालकर सत्य के मार्ग पर प्रेरित करता है (धियो यो नः प्रचोदयात्)।
        """.trimIndent(),
        englishCommentary = """
            Operating at the ultimate Cosmic level, the Upanishad declares: "Aditya (the Sun) is indeed Savita, and Dyaus (Heaven/the Cosmos) is Savitri."
            "Wherever the Sun God resides, Dyaus (the celestial heavens) inherently exists; and wherever Dyaus spreads, the blazing light of the Sun is mandatorily present."
            The Sun is the absolute central powerhouse and sovereign lord (Savita) of the entire solar system, whereas Dyaus is the vast, infinite galaxy that gracefully holds and accommodates that Sun within its expanse.
            These two (the Sun and the Cosmic Heavens) are the fundamental wombs (Yoni) of this entire solar creation, merging completely to form an indivisible, majestic pair (Mithuna).
            If the vast, infinite expanse of space (Dyaus) did not exist, where would the Sun propagate its brilliant rays? Its blinding light would become entirely meaningless.
            Conversely, if the Sun (Aditya) were absent, that colossal heaven would be reduced to a terrifying, pitch-black, and lifeless Dark Abyss.
            Savita (Sun) is the ultimate symbol of light, thermal heat, and vital life-force; Savitri (Dyaus) serves as the supreme mother and sanctuary for that very power.
            The 'Savitur' (Sun) meditated upon in the legendary Gayatri Mantra is this exact Aditya, and His all-pervading, illuminating rays are the essence of Savitri.
            This verse profoundly teaches that the Supreme Lord (Sun) and His eternal Abode (Dyaus) can absolutely never be separated; they are eternally twin expressions of the exact same Ultimate Reality.
            It is this supreme, cosmic light that aggressively extracts a seeker’s intellect from dark ignorance and forcefully inspires it toward the path of Absolute Truth (Dhiyo yo nah prachodayat).
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 7,
        sanskrit = "चन्द्र एव सविता नक्षत्राणि सावित्री। \nयत्र चन्द्रस्तन्नक्षत्राणि यत्र नक्षत्राणि तच्चन्द्रः। \nते द्वे योनी। ते एकं मिथुनम् ॥ ७ ॥",
        hindiCommentary = """
            रात्रिकालीन सौंदर्य का वर्णन करते हुए कहा गया है—"चन्द्रमा ही 'सविता' (प्रकाशक) है, और समस्त नक्षत्राणि (तारे/Constellations) ही 'सावित्री' हैं।"
            "जहाँ चन्द्रमा उदित होता है, वहाँ नक्षत्र भी चमकते हैं; और जहाँ नक्षत्रों का समूह है, वहाँ चन्द्रमा का अस्तित्व अनिवार्य रूप से जुड़ा होता है।"
            चन्द्रमा रात्रि के समय रस, शीतलता और मन की शांति का स्वामी है; और नक्षत्र उसकी उन शक्तियों का विस्तार और उसके मार्गदर्शक हैं।
            ये दोनों (चन्द्रमा और तारे) रात्रि के आकाश के निर्माण और उसके सौंदर्य के मूल कारण (योनी) हैं, और वे एक संपूर्ण जोड़ा (मिथुन) बनाते हैं।
            भारतीय ज्योतिष (Astrology) में चन्द्रमा को मन का कारक माना गया है और वह 27 नक्षत्रों (जो उसकी पत्नियां/सावित्री हैं) के माध्यम से अपनी यात्रा पूरी करता है।
            नक्षत्रों के बिना चन्द्रमा की यात्रा और काल (Time) की गणना असंभव है, और चन्द्रमा के बिना नक्षत्रों का वह अद्भुत सामंजस्य अधूरा है।
            सविता यहाँ सौम्य और शांति-प्रदायक ऊर्जा (चन्द्रमा) के रूप में है, और सावित्री उन चमकते हुए अनगिनत तारों के रूप में है जो उस ऊर्जा को पूरे ब्रह्मांड में बांटते हैं।
            वाल्मीकि जी यहाँ स्पष्ट कर रहे हैं कि सृजन केवल 'अग्नि' या 'गर्जना' जैसे उग्र तत्वों से नहीं होता; 'शीतलता' और 'शांति' (चन्द्र-नक्षत्र) भी सृष्टि के उतने ही महत्वपूर्ण हिस्से हैं।
            ध्यान के समय साधक का मन चन्द्रमा की तरह एकाग्र और शांत होना चाहिए, और उसके विचार नक्षत्रों की तरह शुद्ध और प्रकाशमान होने चाहिए।
            यह जोड़ा हमें सिखाता है कि ईश्वर के प्रचंड रूप (सूर्य) के साथ-साथ उनका सौम्य और करूणामयी रूप (चन्द्रमा) भी हमारे जीवन का आधार है।
        """.trimIndent(),
        englishCommentary = """
            Describing the profound beauty of the night sky, the text states: "Chandra (the Moon) is indeed Savita (the Illuminator), and all the Nakshatrani (Stars/Constellations) are Savitri."
            "Wherever the Moon rises, the constellations brilliantly shine; and wherever the cluster of stars exists, the presence of the Moon is inextricably and naturally linked."
            The Moon is the sovereign lord of cosmic nectar, soothing coolness, and profound mental peace during the night; the stars are the vast extension of his powers and his celestial guides.
            These two (the Moon and the Stars) are the foundational causes (Yoni) of the night sky's architecture and breathtaking beauty, forming an absolutely perfect, harmonious pair (Mithuna).
            In ancient Indian Astrology (Jyotisha), the Moon is considered the significator of the human mind, completing his cosmic journey exclusively by transiting through the 27 Nakshatras (symbolically his wives/Savitri).
            Without the constellations, the Moon's journey and the precise calculation of cosmic Time are mathematically impossible; and without the Moon, the magnificent symphony of the stars remains incomplete.
            Savita manifests here as the highly gentle, peace-bestowing energy (Moon), while Savitri takes the form of countless glittering stars distributing that exact energy across the vast universe.
            Valmiki clarifies here that creation is not solely driven by fierce, aggressive elements like 'Fire' or 'Thunder'; extreme 'Coolness' and profound 'Tranquility' (Moon-Stars) are equally critical, indispensable components of existence.
            During deep meditation, a seeker’s mind must become as profoundly concentrated and calm as the Moon, while his thoughts must remain as pure and brilliantly luminous as the constellations.
            This divine pair teaches us that alongside the Lord's terrifying, blazing form (Sun), His highly gentle, merciful, and soothing aspect (Moon) is equally foundational to our survival.
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 8,
        sanskrit = "मन एव सविता वाक् सावित्री। \nयत्र मनस्तद्वाग्यत्र वाक् तन्मनः। \nते द्वे योनी। ते एकं मिथुनम् ॥ ८ ॥",
        hindiCommentary = """
            अब मनुष्य के सूक्ष्म शरीर (Subtle body) का वर्णन करते हुए उपनिषद कहता है—"मन (Mind/विचार) ही 'सविता' है, और वाक् (Speech/वाणी) ही 'सावित्री' है।"
            "जहाँ मन (विचार) होता है, वहाँ वाणी (उस विचार की अभिव्यक्ति) अवश्य होती है; और जहाँ वाणी है, वहाँ उसके पीछे मन का कोई न कोई संकल्प अवश्य होता है।"
            मन वह अदृश्य और सूक्ष्म सृष्टिकर्ता (सविता) है जो विचारों को जन्म देता है, जबकि वाणी वह भौतिक शक्ति (सावित्री) है जो उन विचारों को संसार में प्रकट करती है।
            ये दोनों (मन और वाणी) मनुष्य के समस्त कर्मों और सृजन के मूल कारण (योनी) हैं, और ये दोनों मिलकर एक अत्यंत घनिष्ठ जोड़ा (मिथुन) बनाते हैं।
            बिना वाणी के मन के विचार गूंगे रह जाते हैं; उनका समाज में कोई प्रभाव या अस्तित्व (Existence) नहीं बन पाता।
            उसी प्रकार, बिना मन (विवेक) के बोली गई वाणी केवल एक अर्थहीन शोर (Noise) है, जो अक्सर विनाश का कारण बनती है।
            सविता (मन) बीज है, और सावित्री (वाक्) उस बीज से उत्पन्न होने वाला वृक्ष है।
            रामायण में मुनि वसिष्ठ या सुमन्त्र जब भी कुछ कहते हैं, तो उनका 'मन' और उनकी 'वाक्' पूरी तरह से एक (Aligned) होते हैं, इसलिए उनके शब्द अचूक (Infallible) होते हैं।
            सावित्री मंत्र के जाप का सबसे बड़ा नियम यही है कि जो मंत्र जिह्वा (वाक्) से बोला जा रहा है, मन भी उसी में पूरी तरह से डूबा होना चाहिए (Alignment of Thought and Speech)।
            जब मन और वाणी एक हो जाते हैं, तो मनुष्य जो भी बोलता है, वह सत्य हो जाता है (वाकसिद्धि), और यही इस 'मिथुन' का सबसे बड़ा रहस्य है।
        """.trimIndent(),
        englishCommentary = """
            Diving deep into the anatomy of the human subtle body, the Upanishad declares: "Manas (the Mind/Thought) is Savita, and Vak (Speech/Voice) is Savitri."
            "Wherever the Mind generates a thought, Speech (its physical expression) inevitably follows; and wherever Speech occurs, there is absolutely always a mental resolve or intention driving it from behind."
            The Mind is the highly invisible, subtle creator (Savita) that actively births internal thoughts, whereas Speech is the potent physical force (Savitri) that visibly manifests those exact thoughts into the material world.
            These two (Mind and Speech) are the absolute fundamental causes (Yoni) of all human actions and creations, merging together to form an incredibly intimate, powerful pair (Mithuna).
            Without the power of Speech, the profound thoughts of the Mind remain entirely mute; they fail to establish any tangible impact or physical existence within human society.
            Conversely, Speech uttered entirely without the firm backing of the Mind (discernment) is reduced to mere meaningless, destructive noise that often triggers catastrophe and conflict.
            Savita (Mind) is the silent, potent seed, and Savitri (Speech) is the visible, sprawling tree that violently erupts from that exact seed.
            In the Ramayana, whenever sages like Vashistha or Sumantra speak, their 'Mind' and 'Speech' are flawlessly, one hundred percent aligned, rendering their words completely infallible and reality-altering.
            The supreme, non-negotiable rule for chanting the Savitri (Gayatri) mantra is that the Mind must be utterly, completely absorbed in the exact vibrations the tongue (Vak) is physically producing (Absolute Alignment of Thought and Speech).
            When the Mind and Speech achieve absolute, total unity, whatever the human utters instantly manifests as absolute reality (Vak-Siddhi), uncovering the greatest, most terrifying secret of this cosmic 'Mithuna.'
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 9,
        sanskrit = "पुरुष एव सविता स्त्री सावित्री। \nयत्र पुरुषस्तत्स्त्री यत्र स्त्री तत्पुरुषः। \nते द्वे योनी। ते एकं मिथुनम् ॥ ९ ॥",
        hindiCommentary = """
            अंततः, मानवीय जीवन के सबसे बड़े सत्य को उद्घाटित करते हुए उपनिषद कहता है—"पुरुष (नर) ही 'सविता' है, और स्त्री (नारी) ही 'सावित्री' है।"
            "जहाँ पुरुष है, वहाँ स्त्री का अस्तित्व अनिवार्य है; और जहाँ स्त्री है, वहाँ पुरुष का होना भी प्रकृति का शाश्वत नियम है।"
            सृष्टि के निर्माण और उसके विस्तार के लिए पुरुष और स्त्री—दोनों ही अनिवार्य कारण (योनी) हैं, और ये दोनों मिलकर इस सृष्टि का सबसे पूर्ण और सुंदर जोड़ा (मिथुन) बनाते हैं।
            पुरुष 'सविता' (बीज-दाता और रक्षक) का भौतिक रूप है, और स्त्री 'सावित्री' (धारण करने वाली और सृजन करने वाली माता) का साक्षात् स्वरूप है।
            न तो पुरुष स्त्री के बिना पूर्ण हो सकता है, और न ही स्त्री पुरुष के बिना; प्रकृति ने दोनों को एक-दूसरे का 'पूरक' (Complementary) बनाया है, प्रतियोगी (Competitor) नहीं।
            यह श्लोक सनातन धर्म में 'नारी के उच्च स्थान' को प्रमाणित करता है; स्त्री को ईश्वर की साक्षात् 'सावित्री' (सृजनात्मक शक्ति) माना गया है।
            राजा दशरथ के महायज्ञ में जब ऋष्यशृंग आए, तो उन्हें उनकी पत्नी 'शान्ता' के साथ (सभार्यं) ही बुलाया गया था, क्योंकि बिना स्त्री (सावित्री) के कोई भी धार्मिक या सृजनात्मक कार्य पूर्ण नहीं माना जाता।
            जिस प्रकार शिव और पार्वती मिलकर 'अर्धनारीश्वर' बनते हैं, उसी प्रकार संसार का प्रत्येक पुरुष और स्त्री मिलकर ब्रह्मांड के इस 'अद्वैत' चक्र को आगे बढ़ाते हैं।
            यह श्लोक समाज को यह कड़ा संदेश देता है कि स्त्री का अपमान साक्षात् ब्रह्मांड की मूल शक्ति (सावित्री) का अपमान है, जो विनाश का कारण बनता है।
            इस 'मिथुन' (जोड़े) के पूर्ण सामंजस्य से ही एक सुखी परिवार, एक मजबूत राष्ट्र और एक श्रेष्ठ संतति (जैसे भगवान राम) का जन्म होता है।
        """.trimIndent(),
        englishCommentary = """
            Finally, unveiling the absolute greatest truth of human existence, the Upanishad proclaims: "Purusha (Man) is indeed Savita, and Stri (Woman) is Savitri."
            "Wherever Man exists, the existence of Woman is biologically and spiritually mandatory; and wherever Woman is present, the existence of Man is an eternal, unalterable law of nature."
            For the active continuation and massive expansion of cosmic creation, both Man and Woman act as the absolute, indispensable fundamental causes (Yoni), uniting flawlessly to form the most complete, beautifully divine pair (Mithuna) in existence.
            Man is the physical, living manifestation of 'Savita' (the seed-giver and ultimate protector), while Woman is the direct, literal embodiment of 'Savitri' (the cosmic mother who conceives, bears, and actively creates life).
            A man can absolutely never achieve total completeness without a woman, nor can a woman without a man; Nature deliberately engineered them as perfect 'Complements' to one another, never as hostile competitors.
            This verse acts as ironclad, indisputable proof of the 'Supreme Status of Women' in Sanatan Dharma; a woman is revered not as a subordinate, but as the literal, living 'Savitri' (Divine Creative Energy) of the Supreme Lord Himself.
            When Sage Rishyashringa was invited to King Dasharatha’s Maha-Yajna, he was strictly summoned alongside his wife 'Shanta' (Sabharyam), because no massive religious or creative ritual is ever considered valid or complete without the physical presence of the female energy (Savitri).
            Just as Lord Shiva and Goddess Parvati flawlessly merge to form the absolute 'Ardhanarishvara' (Androgynous Lord), every single man and woman on earth unites to relentlessly propel this 'Non-dual' (Advaita) cycle of the universe forward.
            This verse delivers a terrifying, stern warning to society: insulting a woman is a direct, unforgivable insult to the foundational energy of the entire cosmos (Savitri), an act that inevitably triggers mass annihilation.
            It is solely through the absolute, perfect harmony of this 'Mithuna' (Pair) that a blissful family, a terrifyingly strong nation, and ultimately, supreme divine offspring (like Lord Rama) are successfully birthed into the world.
        """.trimIndent()
    ),
    UpanishadVerse(
        id = 10,
        sanskrit = "अथ बलातिबलयोः ... विराट् पुरुष ऋषिः ... गायत्री छन्दः ... परमात्मदेवता ... क्षुत्पिपासादिनिवारणे विनियोगः ॥ १० ॥\n(इति सावित्र्युपनिषत् समाप्ता)",
        hindiCommentary = """
            (सविता और सावित्री के इस महान अद्वैत दर्शन को समझाने के बाद, उपनिषद अपने सबसे गुप्त और चमत्कारी रहस्य का उद्घाटन करता है)—"अब 'बला' और 'अतिबला' नामक विद्याओं (मंत्रों) का वर्णन किया जाता है।"
            "इन दोनों महामंत्रों के ऋषि साक्षात् 'विराट् पुरुष' (संपूर्ण ब्रह्मांड का विराट स्वरूप) हैं, इनका छंद 'गायत्री' है, और इन मंत्रों की इष्ट देवता स्वयं 'परमात्मा' (सर्वोच्च ईश्वर) हैं।"
            "इन मंत्रों का विनियोग (एप्लीकेशन/Application) मनुष्य की भूख, प्यास, थकान और सभी प्रकार के शारीरिक व मानसिक कष्टों का तत्काल निवारण (क्षुत्पिपासादिनिवारणे) करने के लिए किया जाता है।"
            यह श्लोक रामायण के बालकाण्ड से सीधा जुड़ता है! जब महर्षि विश्वामित्र युवा राम और लक्ष्मण को ताड़का वध के लिए वन में ले गए थे, तब उन्होंने रास्ते में राम को यही 'बला' और 'अतिबला' विद्या प्रदान की थी।
            इन मंत्रों के प्रभाव से राम और लक्ष्मण को वन की कठोर यात्रा में न तो कभी भूख लगी, न प्यास लगी, और न ही उनके चेहरे का तेज कभी कम हुआ; ये मंत्र शरीर को सुपर-ह्यूमन (Super-human) ऊर्जा से भर देते हैं।
            'विराट् पुरुष' का ऋषि होना यह बताता है कि यह विद्या किसी साधारण मुनि द्वारा नहीं, बल्कि साक्षात् ब्रह्मांडीय चेतना (Cosmic Consciousness) द्वारा रची गई है; यह प्रकृति के 'हार्डवेयर' (Hardware) को सीधे 'हैक' (Hack) करने का कोड है।
            'गायत्री' छंद यह सिद्ध करता है कि यह विद्या भी उसी 'सविता और सावित्री' के मूल स्रोत से निकली है जिसका वर्णन पहले के ९ श्लोकों में किया गया है।
            भूख और प्यास मनुष्य की सबसे बड़ी कमजोरियां हैं; जो इन पर विजय प्राप्त कर ले (बला-अतिबला के माध्यम से), वह साक्षात् ईश्वर के समान अजेय हो जाता है।
            इस प्रकार यह 'सावित्री उपनिषद' पूर्ण होता है। यह एक अत्यंत छोटा परंतु असीम ऊर्जा से भरा हुआ ग्रंथ है जो मनुष्य को अद्वैत ज्ञान से लेकर शारीरिक अजेयता तक का मार्ग दिखाता है।
            सनातन धर्म का यह एक अत्यंत दुर्लभ रहस्य है जहाँ उपनिषद का ज्ञान और रामायण की घटनाएँ आपस में मिलकर एक ही सत्य की गवाही देते हैं।
            ॥ सावित्री उपनिषद सम्पूर्ण हुआ ॥
        """.trimIndent(),
        englishCommentary = """
            (Having thoroughly decoded the grand, non-dual philosophy of Savita and Savitri, the Upanishad now unveils its most deeply guarded, highly miraculous secret)—"Now, the supreme knowledge and incantations of 'Bala' and 'Atibala' are formally revealed."
            "The seer (Rishi) who originally cognized these two mega-mantras is the literal 'Virat Purusha' (The Cosmic, Universal Form of the Supreme Being Himself); their meter is the highly sacred 'Gayatri,' and their presiding deity is the 'Paramatma' (The Absolute Supreme Soul)."
            "The direct application (Viniyoga) of these highly classified mantras is specifically utilized for the instant, total eradication (Nivarane) of hunger (Kshut), severe thirst (Pipasa), extreme physical exhaustion, and all bodily afflictions."
            This exact verse establishes a direct, monumental connection to the Bala Kanda of the Ramayana! When Sage Vishwamitra led the young princes Rama and Lakshmana into the terrifying forest to slay the demoness Tataka, he explicitly taught them these exact same 'Bala' and 'Atibala' Vidyas.
            Under the overwhelming, miraculous influence of these mantras, Rama and Lakshmana experienced absolutely zero hunger, zero thirst, and zero physical fatigue during their brutal journey; these spells literally saturate the human biology with terrifying, 'Super-human' energy and cosmic endurance.
            The 'Virat Purusha' acting as the Rishi definitively proves that this knowledge was not authored by a mere mortal ascetic; it was directly downloaded from the absolute 'Cosmic Consciousness,' functioning essentially as a divine cheat-code designed to completely 'Hack' the rigid 'Hardware' of physical nature.
            The 'Gayatri' meter flawlessly confirms that these twin mantras violently erupt from the exact same primordial source of 'Savita and Savitri' meticulously detailed in the previous 9 verses.
            Biological hunger and thirst are humanity's absolute greatest, most crippling vulnerabilities; a warrior who successfully conquers them (via Bala-Atibala) instantly elevates into an invincible, god-like entity.
            Thus concludes the highly mystical 'Savitri Upanishad.' Though remarkably brief, it is a hyper-dense, explosive reactor of cosmic energy, guiding a seeker seamlessly from high non-dual philosophy straight to practical, physical invincibility.
            This stands as an incredibly rare, magnificent secret of Sanatan Dharma, where the profound, abstract wisdom of the Upanishads and the hardcore, physical events of the Ramayana beautifully collide to testify to the exact same, Ultimate Truth.
            || Thus ends the Savitri Upanishad ||
        """.trimIndent()
    )
)