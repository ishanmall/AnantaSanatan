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
fun SargaTenScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaTenData
        } else {
            sargaTenData.filter {
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
                        Text("दशम सर्ग - दशरथ की अंग देश यात्रा", fontWeight = FontWeight.ExtraBold)
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

val sargaTenData = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "श्रुत्वा तद् वचनं राजा सुमन्त्रस्य सुभाषितम् ।\nउवाच हर्षसम्पन्नो वसिष्ठं मन्त्रिभिः सह ॥ १ ॥",
        hindiCommentary = """
            मंत्री सुमन्त्र के उन अत्यंत शुभ, सत्य और कल्याणकारी वचनों (सुभाषितम्) को पूरी तरह सुनकर (श्रुत्वा), राजा दशरथ का हृदय असीम हर्ष (हर्षसम्पन्नो) से भर गया।
            उस परमानंद की अवस्था में, राजा ने अपने सभी प्रमुख मंत्रियों (मन्त्रिभिः सह) के साथ जाकर अपने कुलगुरु महर्षि वसिष्ठ से यह अत्यंत महत्वपूर्ण बात कही (उवाच)।
            यह श्लोक दशरथ की उस 'प्रशासनिक मर्यादा' (Administrative Decorum) को दर्शाता है जहाँ कोई भी बड़ा कदम उठाने से पहले गुरु का आशीर्वाद लेना अनिवार्य माना जाता था।
            सुमन्त्र ने योजना तो बता दी थी, परंतु उस योजना पर अंतिम मुहर (Final Approval) केवल वसिष्ठ जी ही लगा सकते थे, क्योंकि वे राज्य के सर्वोच्च आध्यात्मिक मार्गदर्शक थे।
            'हर्षसम्पन्नो' शब्द यह प्रमाणित करता है कि राजा के भीतर की वह वर्षों पुरानी पीड़ा और निराशा अब पूरी तरह से समाप्त हो चुकी थी।
            दशरथ अकेले नहीं गए; वे अपने मंत्रियों को साथ लेकर गए, जो यह सिद्ध करता है कि वे पूरी राज्य-मशीनरी को इस महान कार्य (यज्ञ) के लिए एकजुट कर रहे थे।
            वाल्मीकि जी यहाँ बता रहे हैं कि जब एक शासक अपने गुरु और अपने सलाहकारों के बीच सही तालमेल बैठा लेता है, तो राष्ट्र का कोई भी कार्य असफल नहीं हो सकता।
            राजा का यह कदम उस ऐतिहासिक 'पुत्रेष्टि यज्ञ' की दिशा में उठाया गया पहला व्यावहारिक (Practical) और आधिकारिक (Official) कदम था।
            यहीं से अयोध्या के राजमहल में वह आध्यात्मिक हलचल शुरू होती है जो अंततः साक्षात् नारायण को पृथ्वी पर लाने का माध्यम बनेगी।
        """.trimIndent(),
        englishCommentary = """
            Having thoroughly heard (Shrutva) those highly auspicious, truthful, and beneficial words (Subhashitam) from Sumantra, King Dasharatha became filled with boundless, supreme joy (Harshasampanno).
            In that state of absolute ecstasy, the King, accompanied by all his principal ministers (Mantribhih saha), approached his family preceptor, Maharishi Vashistha, and spoke (Uvacha) these incredibly crucial words.
            This verse brilliantly illustrates Dasharatha’s strict adherence to 'Administrative Decorum'; in ancient India, initiating any monumental state action required the mandatory blessing and final approval of the Guru.
            Sumantra had successfully provided the strategic blueprint, but the ultimate, absolute validation could only be granted by Vashistha, the state's highest spiritual authority.
            The term 'Harshasampanno' certifies that the decades-old agony, depression, and despair lingering within the King's heart had now been completely and permanently eradicated.
            Dasharatha did not go alone; He took His ministers along, proving that He was actively uniting and mobilizing the entire state machinery for this colossal endeavor (the Yajna).
            Valmiki highlights here that when a ruler successfully establishes perfect harmony between his spiritual guide and his political advisors, no national project can ever fail.
            This specific action by the King marks the very first practical and official step taken toward the historic and universe-altering 'Putreshti Yajna.'
            From this moment, the profound spiritual mobilization begins within Ayodhya's palace, an energy that will ultimately compel the Supreme Lord Narayana to descend upon the earth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 2,
        sanskrit = "भगवन्मम यज्ञायानुज्ञां दातुमर्हसि ।\nऋष्यशृङ्गं मुनिश्रेष्ठं आनेष्यामि सुसत्कृतम् ॥ २ ॥",
        hindiCommentary = """
            राजा दशरथ ने अत्यंत विनम्रता से कहा—"हे भगवन् (वसिष्ठ जी)! पुत्र प्राप्ति के लिए मैं जो महान अश्वमेध यज्ञ करना चाहता हूँ, कृपया आप मुझे उसकी अनुमति (अनुज्ञां) प्रदान करने की कृपा करें (दातुमर्हसि)।"
            "मैं अंग देश जाकर उन मुनिश्रेष्ठ ऋष्यशृंग को अत्यंत आदर और सत्कार (सुसत्कृतम्) के साथ यहाँ अयोध्या लाने का संकल्प ले चुका हूँ (आनेष्यामि)।"
            एक चक्रवर्ती सम्राट होने के बावजूद, दशरथ का गुरु के सामने इस प्रकार 'अनुमति' (Permission) माँगना भारतीय संस्कृति में गुरु के सर्वोच्च और आदरणीय स्थान को प्रमाणित करता है।
            राजा ने केवल यज्ञ की अनुमति नहीं माँगी, बल्कि उन्होंने अपनी उस कूटनीतिक योजना (ऋष्यशृंग को लाना) को भी गुरु के सामने पूर्ण पारदर्शिता (Transparency) के साथ प्रस्तुत कर दिया।
            'सुसत्कृतम्' (पूर्ण सत्कार के साथ) शब्द का प्रयोग कर दशरथ ने वसिष्ठ जी को आश्वस्त किया कि वे मुनि का कोई अपमान नहीं करेंगे, बल्कि उन्हें साक्षात् देवता मानकर ही अयोध्या लाएंगे।
            वाल्मीकि जी यहाँ यह स्पष्ट कर रहे हैं कि आध्यात्मिक कार्यों में राजा की सत्ता नहीं, बल्कि गुरु का निर्देश ही सर्वोपरि होता है।
            वसिष्ठ जी की अनुमति के बिना ऋष्यशृंग जैसे सिद्ध संत अयोध्या में प्रवेश करने में संकोच कर सकते थे, इसलिए गुरु की सहमति कूटनीतिक रूप से भी अत्यंत आवश्यक थी।
            दशरथ का यह 'आनेष्यामि' (मैं लाऊंगा) का दृढ़ संकल्प यह बताता है कि वे अब इस कार्य को दूसरों पर नहीं छोड़ना चाहते थे; एक पिता के रूप में वे स्वयं यह दायित्व उठा रहे थे।
            यहाँ से उस महान यात्रा की रूपरेखा तैयार होती है जो अयोध्या और अंग देश के संबंधों को एक नई ऊंचाई पर ले जाने वाली थी।
        """.trimIndent(),
        englishCommentary = """
            King Dasharatha spoke with utmost humility: "O Venerable Lord (Vashistha)! Please be gracious enough to grant me your formal permission (Anujnam datumarkhasi) to commence the grand Ashvamedha sacrifice for obtaining an heir."
            "I have firmly resolved to travel to the Kingdom of Anga and bring back (Aneshyami) the pre-eminent Sage Rishyashringa with the most supreme, unblemished honors and respect (Susatkritam)."
            Despite being a universal emperor, Dasharatha explicitly seeking 'Permission' from his Guru perfectly validates the supreme, unchallengeable, and revered status of the spiritual teacher in Sanatan culture.
            The King did not merely ask for permission for the ritual; He presented His entire strategic diplomatic plan (bringing Rishyashringa) before His Guru with absolute, pristine Transparency.
            By deliberately using the word 'Susatkritam' (with complete honors), Dasharatha assured Vashistha that He would not treat the sage arrogantly, but would bring him to Ayodhya treating him precisely like a visiting Deity.
            Valmiki explicitly clarifies here that in all spiritual and transcendental matters, it is not the Monarch's temporal power, but the Guru's divine directive that reigns absolutely supreme.
            Without Vashistha’s formal consent, a perfected saint like Rishyashringa might have hesitated to enter Ayodhya; thus, the Guru's approval was also a highly critical diplomatic necessity.
            Dasharatha’s firm declaration 'Aneshyami' (I will bring) proves that He refused to delegate this monumental task to subordinates; as a desperate father, He was personally shouldering this massive responsibility.
            From here, the exact blueprint of that historic journey is drafted—a journey destined to elevate the diplomatic relations between Ayodhya and Anga to an unprecedented, golden zenith.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 3,
        sanskrit = "वसिष्ठोऽपि तथेत्युक्त्वा राजानमभिनन्द्य च ।\nगच्छ शीघ्रमिति प्राह मुनिमानय सत्वरम् ॥ ३ ॥",
        hindiCommentary = """
            महर्षि वसिष्ठ ने राजा के इस अत्यंत पवित्र संकल्प को सुनकर अत्यंत प्रसन्नतापूर्वक "तथा अस्तु" (ऐसा ही हो - तथेत्युक्त्वा) कहा और राजा का भूरि-भूरि अभिनंदन (अभिनन्द्य) किया।
            उन्होंने राजा को तत्काल आदेश दिया—"हे राजन्! अब आप बिना एक भी पल गँवाए शीघ्र अति शीघ्र अंग देश जाइए (गच्छ शीघ्रम्) और उन मुनि को आदरपूर्वक यहाँ ले आइए (मुनिमानय सत्वरम्)।"
            वसिष्ठ जी जैसे त्रिकालदर्शी (Past, Present, Future seer) गुरु की ओर से 'तथा अस्तु' मिलना इस बात की अंतिम मुहर थी कि दशरथ की यह योजना शत-प्रतिशत सफल होने वाली है।
            वसिष्ठ जी जानते थे कि ऋष्यशृंग का आगमन केवल दशरथ के लिए पुत्र-प्राप्ति का साधन नहीं है, बल्कि यह साक्षात् परब्रह्म के अवतार की वह पूर्व-निश्चित प्रक्रिया है जिसकी प्रतीक्षा स्वयं देवता कर रहे हैं।
            गुरु का अभिनंदन (अभिनन्द्य) यह सिद्ध करता है कि दशरथ ने जो निर्णय लिया, वह धर्म, नीति और काल (Time) के बिल्कुल अनुकूल था।
            'शीघ्रम्' और 'सत्वरम्' (जल्दी करो) जैसे शब्दों का प्रयोग वसिष्ठ जी की उस उतावली और उत्साह को दर्शाता है जो वे ईश्वर के अवतार को पृथ्वी पर देखने के लिए महसूस कर रहे थे।
            वाल्मीकि जी यहाँ बता रहे हैं कि जब शिष्य का संकल्प शुद्ध होता है, तो गुरु उसे केवल आशीर्वाद ही नहीं देते, बल्कि उसे कर्म करने के लिए पूरी शक्ति के साथ धकेल देते हैं।
            इस आज्ञा के मिलते ही राजा दशरथ के भीतर का वह अंतिम संकोच भी पूरी तरह से मिट गया जो एक राजा को दूसरे राजा के पास याचना करने जाने में हो सकता था।
            अयोध्या के राजमहल में अब एक उत्सव जैसा माहौल बन गया था, क्योंकि गुरु की हरी झंडी (Green Signal) मिल चुकी थी।
        """.trimIndent(),
        englishCommentary = """
            Upon hearing the King's highly sacred resolve, Maharishi Vashistha became extremely pleased, declared "Tatha Astu" (So be it - Tathetyuktva), and enthusiastically congratulated and welcomed the King's decision (Abhinandya).
            The Guru instantly commanded the King: "O Monarch! You must depart for the Kingdom of Anga immediately (Gaccha shighram) without wasting a single moment, and bring that sage here with extreme swiftness (Munimanaya satvaram)."
            Receiving a "Tatha Astu" from an omniscient, clairvoyant Guru like Vashistha acted as the absolute, final, infallible seal guaranteeing that Dasharatha’s entire masterplan would achieve one hundred percent success.
            Vashistha profoundly knew that Rishyashringa’s arrival was not merely a mechanism for Dasharatha to get a son; it was the highly pre-ordained process facilitating the incarnation of the Supreme Absolute, an event eagerly awaited by the celestial gods themselves.
            The Guru’s congratulatory blessing (Abhinandya) conclusively proves that Dasharatha’s decision was flawlessly aligned with Dharma, state ethics, and the precise timing of the cosmic clock.
            The deliberate use of urgent words like 'Shighram' and 'Satvaram' (do it swiftly) vividly reflects Vashistha’s own intense eagerness and overwhelming enthusiasm to witness the physical descent of God upon the earth.
            Valmiki demonstrates here that when a disciple's resolve is flawlessly pure, a true Guru does not merely offer passive blessings; he actively, forcefully propels the disciple into dynamic action.
            Upon receiving this explicit command, any residual, microscopic hesitation Dasharatha might have harbored about visiting another king as a supplicant was entirely and permanently obliterated.
            A deeply festive, highly charged atmosphere instantly erupted within the royal palace of Ayodhya, as the ultimate, divine 'Green Signal' had officially been granted.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 4,
        sanskrit = "ततो राजा दशरथो वसिष्ठेनाभ्यनुज्ञातः ।\nअन्तःपुरमुपागम्य कौसल्यामिदमब्रवीत् ॥ ४ ॥",
        hindiCommentary = """
            महर्षि वसिष्ठ द्वारा उस महान यज्ञ और यात्रा की पूर्ण अनुमति (अभ्यनुज्ञातः) प्राप्त करने के पश्चात् (ततो), राजा दशरथ सीधे अपने महल के भीतर गए।
            वे तुरंत अपने रनिवास (अन्तःपुरम्) में पहुँचे और वहाँ जाकर अपनी पटरानी कौशल्या (कौसल्याम्) से अत्यंत हर्षपूर्वक यह अत्यंत सुखद समाचार (इदमब्रवीत्) कहा।
            यह श्लोक दशरथ के एक 'आदर्श पति' (Ideal Husband) होने का साक्ष्य है; वे राज्य का इतना बड़ा निर्णय लेने के बाद अपनी उस पत्नी को सबसे पहले बताने गए जो पुत्रहीनता के दुख में उनके साथ बराबर की भागीदार थी।
            अन्तःपुर में जाना यह दर्शाता है कि यह विषय (पुत्र-प्राप्ति) केवल एक 'स्टेट अफेयर' (State Affair) नहीं था, बल्कि यह उनके परिवार की सबसे गहरी और व्यक्तिगत पीड़ा का समाधान था।
            कौशल्या रघुकुल की पटरानी (Chief Queen) थीं, इसलिए राजा के किसी भी बड़े धार्मिक अनुष्ठान (जैसे अश्वमेध यज्ञ) में उनकी सहमति और उपस्थिति अत्यंत अनिवार्य थी।
            वाल्मीकि जी यहाँ राजकाज और पारिवारिक जीवन (Family Life) के बीच के उस सुंदर संतुलन (Balance) को दिखा रहे हैं जिसे राजा दशरथ बहुत अच्छी तरह निभाते थे।
            दशरथ जानते थे कि वसिष्ठ जी की अनुमति के बाद कौशल्या का दुख हमेशा के लिए समाप्त होने वाला है, इसलिए वे स्वयं यह 'गुड न्यूज़' (Good News) उन्हें देना चाहते थे।
            गुरु का आशीर्वाद लेकर सीधा पत्नी के पास जाना यह सिद्ध करता है कि प्राचीन भारत में स्त्रियों को घर के हर बड़े और महत्वपूर्ण निर्णय में समान रूप से सम्मिलित किया जाता था।
            यहाँ से कथा उस यज्ञ की तैयारियों और परिवार के उस उल्लास की ओर बढ़ती है जिसने अयोध्या के राजमहल को एक नई ऊर्जा से भर दिया था।
        """.trimIndent(),
        englishCommentary = """
            Following the complete, formal approval and authorization (Abhyanujnatah) granted by Maharishi Vashistha for the grand sacrifice and journey, King Dasharatha (Tato) proceeded directly into His palace.
            He immediately entered His private royal chambers (Antahpuram), approached His Chief Queen, Kaushalya (Kausalyam), and joyfully communicated (Idamabravit) this incredibly auspicious news to her.
            This verse stands as profound evidence of Dasharatha being an 'Ideal Husband'; having secured a monumental state decision, He prioritized sharing it first with the very wife who had equally shared the devastating, agonizing burden of their heirlessness.
            Entering the Antahpuram (inner chambers) signifies that this issue (obtaining progeny) was not merely a sterile 'State Affair'; it was the ultimate, divine resolution to their family's deepest, most agonizing personal tragedy.
            Kaushalya was the Chief Queen of the Solar Dynasty; therefore, her active consent, emotional alignment, and physical presence were absolutely mandatory for the execution of any massive religious ritual like the Ashvamedha Yajna.
            Valmiki beautifully showcases the flawless 'Balance' King Dasharatha maintained seamlessly between His rigorous political duties (Rajkaj) and His highly sensitive familial obligations (Family Life).
            Dasharatha knew with absolute certainty that after Vashistha's blessing, Kaushalya's lifelong sorrow was destined to end permanently; hence, He fiercely desired to deliver this ultimate 'Good News' to her personally.
            Going directly to the wife after receiving the Guru's blessing proves conclusively that in ancient Indian society, women were equally and respectfully included in every major, life-altering familial and spiritual decision.
            From this point, the narrative rapidly advances toward the massive logistical preparations for the Yajna, infusing the royal household of Ayodhya with an unprecedented, vibrant surge of divine energy.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 5,
        sanskrit = "पुत्रार्थं हयमेधेन यक्ष्यामीति सुव्रते ।\nतथा च मे मुनिश्रेष्ठो ऋष्यशृङ्गो भविष्यति ॥ ५ ॥",
        hindiCommentary = """
            राजा दशरथ ने माता कौशल्या से कहा—"हे उत्तम व्रतों का पालन करने वाली (सुव्रते)! अब मैंने यह दृढ़ संकल्प कर लिया है कि मैं पुत्र-प्राप्ति के उद्देश्य से (पुत्रार्थं) 'अश्वमेध यज्ञ' (हयमेधेन) का अनुष्ठान करूँगा (यक्ष्यामीति)।"
            "और इस महान कार्य को सिद्ध करने के लिए, मुनियों में श्रेष्ठ (मुनिश्रेष्ठो) ऋष्यशृंग साक्षात् हमारे पुरोहित (तथा च मे) बनकर यहाँ अयोध्या में उपस्थित होंगे (भविष्यति)।"
            दशरथ का कौशल्या को 'सुव्रते' कहना यह दर्शाता है कि कौशल्या ने पुत्र-प्राप्ति के लिए वर्षों तक अत्यंत कठोर उपवास, व्रत और ईश्वरीय आराधना की थी; राजा उनके उस तप का पूरा सम्मान कर रहे थे।
            'यक्ष्यामीति' (मैं यज्ञ करूँगा) यह घोषणा कौशल्या के लिए उसी प्रकार थी जैसे किसी बंजर धरती को पहली बार बादलों के बरसने की सूचना दी जाए; यह उनके जीवन की सबसे बड़ी और बहुप्रतीक्षित खबर थी।
            ऋष्यशृंग का नाम लेना यह प्रमाणित करता है कि राजा केवल एक खोखली योजना नहीं बता रहे थे, बल्कि उनके पास इस यज्ञ को सफल बनाने का 'ब्रह्मास्त्र' (ऋष्यशृंग) पूरी तरह से तैयार था।
            वाल्मीकि जी ने यहाँ एक पति और पत्नी के बीच के उस अत्यंत भावुक और आशा से भरे संवाद (Emotional Dialogue) को बहुत ही सटीकता से उकेरा है।
            कौशल्या को यह जानकर अपार शांति मिली होगी कि जिस मुनि ने अंग देश का अकाल मिटाया था, वही मुनि अब उनकी सूनी गोद को भरने वाले हैं।
            दशरथ का आत्मविश्वास अब चरम पर था; वे अब एक असहाय राजा नहीं, बल्कि एक ऐसे पिता के रूप में बात कर रहे थे जो अपने भविष्य को लेकर पूरी तरह आश्वस्त हो चुका है।
            यह श्लोक रामायण की कथा के उस 'प्रिपरेशन फेज' (Preparation Phase) का आरंभ है जहाँ पूरा राज्य अब एक ही दिशा (यज्ञ) में कार्य करने वाला है।
        """.trimIndent(),
        englishCommentary = """
            King Dasharatha joyously declared to Queen Kaushalya: "O observer of excellent vows (Suvrate)! I have firmly resolved that I shall actively perform (Yakshyamiti) the grand 'Ashvamedha Yajna' (Hayamedhena) specifically for the purpose of obtaining a son (Putrartham)."
            "And to absolutely guarantee the success of this monumental endeavor, that foremost of sages (Munishreshtho), Rishyashringa, shall personally serve as our high priest (Tatha cha me) and will soon be present here in Ayodhya (Bhavishyati)."
            Dasharatha addressing Kaushalya as 'Suvrate' is highly significant; it acknowledges that the Queen had performed unimaginably severe fasts, rigorous vows, and intense prayers for years to obtain a son; the King was profoundly honoring her silent, ascetic sacrifices.
            The powerful declaration 'Yakshyamiti' (I will perform the sacrifice) fell upon Kaushalya’s ears exactly like the highly anticipated announcement of torrential rain to a totally barren, dying earth; it was the absolute greatest news of her entire existence.
            Explicitly naming Rishyashringa proves that the King was not merely sharing a hollow, theoretical plan; He already possessed the ultimate, infallible 'Brahmastra' (Rishyashringa) necessary to ensure the Yajna's absolute, one hundred percent success.
            Valmiki has precisely and beautifully captured this highly emotional, hope-drenched dialogue (Emotional Dialogue) occurring between an aging husband and his deeply devoted wife.
            Kaushalya must have experienced unfathomable, profound peace knowing that the very sage who had miraculously eradicated the horrific famine of Anga was now officially destined to fill her empty, sorrowful lap.
            Dasharatha’s self-confidence was now operating at its absolute zenith; He was no longer speaking as a helpless, depressed monarch, but as a revitalized father completely and totally assured of His glorious future.
            This verse forcefully initiates the 'Preparation Phase' of the epic's core narrative, where the entire machinery of the state is about to mobilize in one unified direction toward the grand sacrifice.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 6,
        sanskrit = "एवमुक्त्वा तु कौसल्यां सान्त्वयित्वा च पार्थिवः ।\nप्रतस्थे स तदा राजा रोमपादपुरं प्रति ॥ ६ ॥",
        hindiCommentary = """
            महारानी कौशल्या से इस प्रकार वह शुभ समाचार कहकर (एवमुक्त्वा) और उनके संतप्त हृदय को पूरी तरह से सांत्वना (सान्त्वयित्वा) देकर, वे पृथ्वीपति (पार्थिवः) राजा दशरथ वहाँ से बाहर आए।
            तत्पश्चात (तदा), राजा ने बिना कोई और समय नष्ट किए अपनी सेना और मंत्रियों के साथ अपने मित्र रोमपाद के नगर (अंग देश) की ओर तुरंत प्रस्थान कर दिया (प्रतस्थे)।
            'सान्त्वयित्वा' का अर्थ है कि दशरथ ने कौशल्या के आंसुओं को पोंछा और उन्हें विश्वास दिलाया कि अब उनके दुख के दिन हमेशा के लिए समाप्त हो चुके हैं; यह एक पति का सबसे बड़ा धर्म है।
            महारानी को आश्वस्त करने के बाद, दशरथ ने एक क्षण का भी आराम नहीं किया; 'प्रतस्थे' यह दर्शाता है कि वे अपने लक्ष्य के प्रति कितने अधिक 'फोकस्ड' (Focused) और व्याकुल थे।
            रोमपाद का नगर (रोमपादपुरं) कोई साधारण गंतव्य (Destination) नहीं था; वह दशरथ के लिए उस 'संजीवनी' (ऋष्यशृंग) का प्राप्ति-स्थल था जो रघुकुल को अमर बनाने वाली थी।
            वाल्मीकि जी यहाँ राजा के उस 'स्विफ्ट एक्शन' (Swift Action) को रेखांकित कर रहे हैं जो एक कुशल शासक की पहचान होती है; योजना बनते ही उसे तुरंत 'एग्जीक्यूट' (Execute) करना।
            राजा का यह प्रस्थान कोई साधारण यात्रा नहीं थी; यह एक ऐसे युग की शुरुआत की यात्रा थी जिसमें ईश्वर स्वयं मनुष्य रूप में पृथ्वी पर आने वाले थे।
            इस यात्रा में दशरथ के साथ कोई बड़ा युद्ध-सरंजाम नहीं था, बल्कि यह एक 'शांतिपूर्ण और कूटनीतिक मिशन' (Peaceful & Diplomatic Mission) था, जो मित्रता के आधार पर संपन्न होना था।
            यहाँ से कथा का वह 'रोड-ट्रिप' (Road-trip) वाला हिस्सा शुरू होता है जहाँ अवध का राजा अपने भाग्य की चाबी लेने के लिए अंग देश की सीमा में प्रवेश करने वाला है।
        """.trimIndent(),
        englishCommentary = """
            Having communicated this highly auspicious news to Queen Kaushalya in this manner (Evamuktva) and having completely, profoundly consoled her grieving heart (Santvayitva), that Lord of the Earth (Parthivah), King Dasharatha, stepped out of the chambers.
            Thereafter (Tada), without wasting a single additional moment, the King immediately commenced His royal journey (Pratasthe), heading straight toward the capital city of His dear friend, King Romapada (Romapadapuram prati).
            'Santvayitva' implies that Dasharatha lovingly wiped away Kaushalya's tears, instilling an unbreakable conviction within her that their long, dark days of sorrow were permanently over; fulfilling the ultimate Dharma of a devoted husband.
            After totally reassuring the Queen, Dasharatha did not rest for even a microsecond; the word 'Pratasthe' vividly highlights how incredibly 'Focused', restless, and deeply determined He was regarding His ultimate target.
            Romapada’s city was no ordinary destination; for Dasharatha, it was the exact location of the ultimate 'Sanjeevani' (Sage Rishyashringa) that was historically destined to immortalize the entire Solar Dynasty.
            Valmiki emphasizes the King's 'Swift Action' here, which is the undeniable hallmark of a highly efficient ruler: the moment a flawless plan is approved, it must be instantly 'Executed' on the ground without hesitation.
            The King’s departure was absolutely no ordinary journey; it was a highly monumental, historic pilgrimage marking the dawn of a new era wherein the Supreme Absolute Himself would descend upon the earth in human form.
            Dasharatha did not travel with a massive, aggressive military armada; this was an entirely 'Peaceful and Diplomatic Mission,' designed to be accomplished strictly on the solid foundation of profound, mutual friendship.
            From this point, the 'Road-trip' segment of the narrative commences, where the great Emperor of Ayodhya is about to cross into the borders of Anga to personally retrieve the ultimate key to His destiny.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 7,
        sanskrit = "स गत्वा तं वनं सर्वं यत्र स मुनिपुङ्गवः ।\nरोमपादेन सानीतो यथैव मुनिपुङ्गवः ॥ ७ ॥",
        hindiCommentary = """
            (कथा का प्रवाह अंग देश की ओर मुड़ता है)—राजा दशरथ अपनी यात्रा करते हुए उन सभी वनों और मार्गों (वनं सर्वं) से होकर गुजरे, जहाँ से होकर उस मुनिश्रेष्ठ (मुनिपुङ्गवः) को लाया गया था।
            वे ठीक उसी मार्ग से अंग देश की ओर बढ़ रहे थे जिस मार्ग से और जिस युक्ति से राजा रोमपाद ने (रोमपादेन) उन मुनि को अपने राज्य में प्रवेश कराया था (सानीतो यथैव)।
            (यह श्लोक मूल रामायण के कुछ संस्करणों में यात्रा के भौगोलिक और कूटनीतिक 'रूट' (Route) को दर्शाने के लिए प्रयुक्त हुआ है।)
            राजा दशरथ का उसी वन के मार्ग से जाना यह दर्शाता है कि वे उस पूरे 'मनोवैज्ञानिक और भौगोलिक परिवेश' (Psychological and Geographical environment) को अपनी आँखों से देखना चाहते थे जहाँ से मुनि को निकाला गया था।
            यह एक प्रकार का 'ऑन-साइट इंस्पेक्शन' (On-site Inspection) था, जहाँ एक राजा दूसरे राजा की सफलता के पदचिह्नों (Footsteps) पर चलकर उसकी रणनीति का गहराई से अध्ययन कर रहा था।
            'मुनिपुङ्गवः' शब्द का बार-बार प्रयोग मुनि के उस सर्वोच्च और निर्विवाद सम्मान को पुष्ट करता है जो दशरथ के मन में उनके प्रति पहले से ही स्थापित हो चुका था।
            वाल्मीकि जी यहाँ यह सिद्ध कर रहे हैं कि दशरथ की यह यात्रा केवल एक शारीरिक यात्रा नहीं थी, बल्कि यह उनके मन की भी एक यात्रा थी, जहाँ वे अपने अहंकार को छोड़कर एक याचक (Seeker) के रूप में जा रहे थे।
            जब एक महान राजा अपनी आवश्यकता के लिए स्वयं मीलों की यात्रा करता है, तो यह उसके लक्ष्य के प्रति उसके असीम समर्पण और 'डेडीकेशन' (Dedication) को दर्शाता है।
            यात्रा का यह वर्णन कथा में एक 'ट्रांज़िशन' (Transition) का कार्य करता है, जो अयोध्या के महल से श्रोता को सीधे रोमपाद के राज्य में ले जाता है।
        """.trimIndent(),
        englishCommentary = """
            (The narrative flow shifts towards Anga)—Continuing His royal journey, King Dasharatha meticulously traveled through all those dense forests and pathways (Vanam sarvam) from where that pre-eminent sage (Munipungavah) had been originally extracted.
            He was deliberately advancing towards the Kingdom of Anga tracing the exact same geographical route and contemplating the precise strategy by which King Romapada (Romapadena) had successfully brought (Sanito yathaiva) the sage into his realm.
            (This verse is utilized in certain recensions to specifically highlight the exact geographical and diplomatic 'Route' undertaken by the Emperor during this historic journey.)
            Dasharatha traveling precisely through that same forest indicates that He actively desired to witness and personally analyze the entire 'Psychological and Geographical environment' from which the great ascetic had been drawn out.
            This was essentially an 'On-site Inspection' by a master statesman, where one grand monarch was meticulously tracing the triumphant footsteps of another to deeply study and absorb his highly successful strategy.
            The repeated use of the term 'Munipungavah' (foremost of sages) firmly solidifies the supreme, unquestionable, and profound reverence that had already been permanently established within Dasharatha’s heart for Rishyashringa.
            Valmiki proves here that Dasharatha’s expedition was not merely a physical journey; it was a deeply internal, spiritual pilgrimage where He was leaving behind His royal ego to travel purely as a humble 'Seeker.'
            When a universally powerful monarch voluntarily undertakes a grueling journey spanning hundreds of miles to fulfill a need, it acts as the ultimate testament to His boundless 'Dedication' and total surrender to His goal.
            This vivid description of the journey serves as a flawless narrative 'Transition,' seamlessly transporting the listener's focus from the opulent palaces of Ayodhya directly to the bustling borders of King Romapada's state.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 8,
        sanskrit = "ततो रोमपदं दृष्ट्वा सखा सखायमागतम् ।\nप्रत्युद्गम्य मुदा युक्तः पूजयामास शास्त्रतः ॥ ८ ॥",
        hindiCommentary = """
            "तत्पश्चात (ततो), जब राजा रोमपाद ने देखा (दृष्ट्वा) कि उनके सबसे घनिष्ठ मित्र (सखा) और महान सम्राट दशरथ स्वयं चलकर उनके राज्य में आए हैं (सखायमागतम्)।"
            "तो वे अत्यंत आनंद और उल्लास से भर गए (मुदा युक्तः), और तुरंत आगे बढ़कर उनका भव्य स्वागत (प्रत्युद्गम्य) किया तथा शास्त्रों की विधि के अनुसार (शास्त्रतः) उनकी उचित पूजा और सत्कार (पूजयामास) किया।"
            यह श्लोक दो महान और शक्तिशाली राजाओं के उस अत्यंत आत्मीय और 'ऐतिहासिक मिलन' (Historic Meeting) का वर्णन करता है जो कूटनीति से अधिक 'मित्रता' पर आधारित था।
            'सखा सखायमागतम्' (मित्र का मित्र के पास आना) यह स्पष्ट करता है कि दशरथ वहाँ किसी साम्राज्यवादी (Imperial) एजेंडे के तहत नहीं, बल्कि विशुद्ध रूप से एक मित्र के रूप में सहायता माँगने गए थे।
            रोमपाद का 'प्रत्युद्गम्य' (आगे बढ़कर स्वागत करना) यह सिद्ध करता है कि यद्यपि वे स्वयं एक बड़े राजा थे, परंतु वे दशरथ के प्रताप और उनके साथ अपनी पुरानी मित्रता का अत्यंत गहरा सम्मान करते थे।
            शास्त्रों के अनुसार पूजा करने का अर्थ है कि अतिथि देवो भवः की उस महान सनातन परंपरा का निर्वहन किया गया जहाँ एक राजा दूसरे राजा को भगवान के समान आदर देता है।
            वाल्मीकि जी यहाँ बता रहे हैं कि राजनीति में जब दो राष्ट्रों के बीच मित्रता सच्ची होती है, तो वहाँ अहंकार (Ego) या 'प्रोटोकॉल' (Protocol) की दीवारें अपने आप गिर जाती हैं।
            रोमपाद की इस 'मुदा' (प्रसन्नता) का कारण यह भी था कि दशरथ जैसे चक्रवर्ती सम्राट का उनके राज्य में आना अंग देश के लिए एक बहुत बड़े गौरव और सौभाग्य की बात थी।
            दशरथ के लिए यह स्वागत इस बात का 'संकेत' (Signal) था कि उनका मित्र उनकी वह प्रार्थना (ऋष्यशृंग को ले जाने की) कभी नहीं ठुकराएगा जिसके लिए वे इतनी दूर से आए हैं।
            यहाँ से उस वार्तालाप का 'स्टेज' (Stage) सेट होता है जहाँ दोनों मित्र अपने राज्यों के भविष्य पर चर्चा करने वाले थे।
        """.trimIndent(),
        englishCommentary = """
            "Thereafter (Tato), the moment King Romapada saw (Drishtva) that his absolute closest friend (Sakha) and the great Emperor Dasharatha had personally arrived in his kingdom (Sakhayamagatam)."
            "He was instantly filled with overwhelming delight and supreme joy (Muda yuktah); he immediately rushed forward to warmly receive Him (Pratyudgamya) and worshipped Him with grand honors strictly according to the scriptures (Shastratah pujayamasa)."
            This verse brilliantly captures the highly intimate and 'Historic Meeting' of two immensely powerful monarchs, an encounter grounded far more heavily in pure 'Friendship' than in calculating diplomacy.
            The profound phrase 'Sakha sakhayamagatam' (a friend coming to a friend) explicitly clarifies that Dasharatha had not arrived with a hostile or 'Imperial' agenda, but purely as a humble friend seeking vital assistance.
            Romapada stepping forward to receive Him (Pratyudgamya) proves that despite being a highly powerful ruler himself, he maintained an incredibly deep, unwavering respect for Dasharatha’s superior majesty and their ancient bond.
            Worshipping strictly according to the Shastras means that the grand, eternal Sanatan tradition of 'Atithi Devo Bhava' (The Guest is God) was executed flawlessly, where one sovereign honors another precisely like a visiting Deity.
            Valmiki demonstrates here that in the realm of high politics, when the friendship between two nations is genuinely authentic, the rigid walls of 'Ego' and cold, bureaucratic 'Protocols' automatically and instantly collapse.
            Romapada’s 'Muda' (boundless joy) also stemmed from the undeniable fact that a universal Emperor (Chakravarti) like Dasharatha personally visiting his state was a matter of unprecedented, colossal pride and honor for the Anga kingdom.
            For Dasharatha, this incredibly warm reception functioned as the ultimate, highly positive 'Signal'—a firm guarantee that his dear friend would never reject the desperate prayer (to take Rishyashringa) for which He had traveled so far.
            From this exact moment, the 'Stage' is perfectly set for the intimate, pivotal conversation where the two great friends will decide the ultimate, intertwined future of their respective empires.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 9,
        sanskrit = "ऋष्यशृङ्गो मुनिसुतस्तथा शान्ता च राजपुत्री ।\nउभौ तौ पूजयामास दशरथं नृपोत्तमम् ॥ ९ ॥",
        hindiCommentary = """
            "रोमपाद के भव्य स्वागत के पश्चात्, वहाँ उपस्थित उन मुनि-पुत्र ऋष्यशृंग और राजपुत्री शान्ता—इन दोनों (उभौ तौ) ने भी आगे बढ़कर राजाओं में श्रेष्ठ दशरथ (दशरथं नृपोत्तमम्) का अत्यंत आदरपूर्वक वंदन और पूजन (पूजयामास) किया।"
            यह श्लोक इस कथा का एक अत्यंत भावुक और आत्मीय (Emotional and Intimate) क्षण है; दशरथ पहली बार उस मुनि से मिल रहे थे जिनके हाथों में उनके वंश का भविष्य था।
            'शान्ता' वास्तव में राजा दशरथ की ही पुत्री थीं, जिन्हें उन्होंने रोमपाद को गोद दिया था; अतः शान्ता का दशरथ को पूजना एक पुत्री द्वारा अपने 'जैविक पिता' (Biological Father) को दिया गया आदर था।
            ऋष्यशृंग ने यद्यपि दशरथ को एक महान सम्राट के रूप में पूजा, परंतु वास्तव में वे अनजाने में अपने ससुर के मित्र और (अप्रत्यक्ष रूप से) अपने पिता-तुल्य व्यक्ति का ही सम्मान कर रहे थे।
            वाल्मीकि जी ने 'नृपोत्तमम्' (राजाओं में श्रेष्ठ) शब्द का प्रयोग कर यह बताया है कि दशरथ का व्यक्तित्व इतना प्रभावशाली था कि एक सिद्ध तपस्वी भी उनके तेज के आगे स्वतः ही नतमस्तक हो गया।
            दशरथ का हृदय उस समय दोहरे आनंद से भरा होगा—एक ओर अपनी पुत्री शान्ता को सुखी देखना, और दूसरी ओर उस 'तपोनिधि' (ऋष्यशृंग) को साक्षात् अपने सामने पाना जिसकी उन्हें सबसे अधिक आवश्यकता थी।
            यह श्लोक 'शिष्टाचार' (Etiquette) और पारिवारिक संस्कारों का वह उत्कृष्ट उदाहरण प्रस्तुत करता है जो प्राचीन राजघरानों में कड़ाई से पालन किया जाता था।
            मुनि का दशरथ के प्रति यह आदर इस बात की गारंटी था कि जब दशरथ उन्हें अयोध्या चलने का आमंत्रण देंगे, तो मुनि उसे सहर्ष स्वीकार कर लेंगे; मनोवैज्ञानिक रूप से 'कनेक्शन' (Connection) स्थापित हो चुका था।
            यहीं से राजा दशरथ की उस महान योजना का आधा कार्य बिना कुछ कहे ही सिद्ध हो गया था।
        """.trimIndent(),
        englishCommentary = """
            "Following the grand, royal reception by Romapada, the sage's son Rishyashringa and the royal Princess Shanta—both of them together (Ubhau tau) stepped forward and offered their profound reverence and worship (Pujayamasa) to Dasharatha, the most excellent of kings (Nripottamam)."
            This verse marks an incredibly emotional, highly 'Intimate' moment in the narrative; Dasharatha was laying His eyes for the very first time upon the exact sage who held the absolute future of His entire lineage in his hands.
            'Shanta' was, in absolute reality, King Dasharatha’s own biological daughter, whom He had previously given in adoption to Romapada; thus, Shanta's worship was the profound, tearful reverence of a daughter toward her 'Biological Father.'
            Although Rishyashringa respectfully worshipped Dasharatha as a great Emperor, he was unknowingly offering deep reverence to his father-in-law's closest friend and a figure who was indirectly like a father to him.
            Valmiki deliberately uses the term 'Nripottamam' (best among kings) to emphasize that Dasharatha’s royal persona was so magnetically powerful that even a perfected, detached ascetic automatically bowed down before His blazing aura.
            Dasharatha’s heart must have been overflowing with a dual, massive joy at that moment—the immense relief of seeing His daughter Shanta so happily settled, and the sheer ecstasy of finally finding the 'Treasure of Penance' (Rishyashringa) He so desperately needed.
            This verse serves as an outstanding, flawless example of the high 'Etiquette' and profound familial values that were strictly and beautifully maintained within the ancient royal households of India.
            The sage's profound respect toward Dasharatha acted as an ironclad guarantee that when the King eventually invited him to Ayodhya, the sage would happily accept; the psychological 'Connection' had been successfully and permanently established.
            It is exactly at this moment that half of King Dasharatha’s monumental objective was achieved effortlessly, even before a single word of request had been formally spoken.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 10,
        sanskrit = "सप्ताष्टौ दिवसान् राजा तत्रोषित्वा नराधिपः ।\nरोमपादमुवाचेदं वचो दशरथो नृपः ॥ १० ॥",
        hindiCommentary = """
            "उन नराधिप राजा दशरथ ने वहाँ अंग देश में अपने मित्र के अतिथि के रूप में सात-आठ दिन (सप्ताष्टौ दिवसान्) अत्यंत सुखपूर्वक निवास किया (तत्रोषित्वा)।"
            "उन आनंदमय दिनों के बीत जाने के पश्चात्, राजा दशरथ ने एक उचित अवसर देखकर अपने मित्र रोमपाद से यह अत्यंत महत्वपूर्ण और हृदय की बात (वचो) कही (उवाचेदं)।"
            'सात-आठ दिन' रुकना कूटनीति (Diplomacy) का एक बहुत ही परिपक्व और शांत 'अप्रोच' (Approach) दर्शाता है; दशरथ वहाँ पहुँचते ही अपने काम की बात (मांगना) शुरू नहीं कर दिए, जो कि एक अभद्रता होती।
            उन्होंने पहले अपनी मित्रता को समय दिया, अपनी पुत्री शान्ता और दामाद ऋष्यशृंग के साथ एक पारिवारिक संबंध (Family Bonding) स्थापित किया, और जब विश्वास पूरी तरह से पक्का हो गया, तब वे अपने मुख्य उद्देश्य पर आए।
            वाल्मीकि जी यहाँ बता रहे हैं कि 'पेशेंस' (Patience/धैर्य) किसी भी बड़े शासक का सबसे बड़ा हथियार होता है; जल्दबाजी में लिए गए निर्णय या रखी गई मांगें अक्सर ठुकरा दी जाती हैं।
            इन सात-आठ दिनों में ऋष्यशृंग भी दशरथ के अत्यंत निकट आ गए होंगे और उनके मन में दशरथ के प्रति एक पिता-तुल्य सम्मान और अगाध प्रेम उत्पन्न हो गया होगा; यही दशरथ की असली 'रणनीति' (Strategy) थी।
            'रोमपादमुवाचेदं' (रोमपाद से कहा) यह स्पष्ट करता है कि दशरथ ने सीधे मुनि से बात नहीं की, बल्कि 'प्रोटोकॉल' (Protocol) का पालन करते हुए पहले उस राज्य के स्वामी (रोमपाद) से ही अनुमति माँगना उचित समझा।
            राजा का यह व्यवहार उनके उस 'मर्यादा-पुरुषोत्तम' स्वरूप की पूर्व-झलक है जिसे बाद में उनके पुत्र राम ने पूरे विश्व के सामने चरितार्थ किया।
            अब वह बहुप्रतीक्षित (Highly Anticipated) क्षण आ गया था जहाँ दशरथ अपने मित्र के सामने अपनी वह झोली फैलाने वाले थे जो पिछले कई दशकों से सूनी पड़ी थी।
        """.trimIndent(),
        englishCommentary = """
            "That ruler of men, King Dasharatha, resided there comfortably in the Kingdom of Anga as the highly honored guest of his friend for seven or eight days (Saptashtau divasan)."
            "After those blissful days had peacefully passed (Tatroshitva), King Dasharatha, sensing the absolute perfect, highly opportune moment, finally spoke (Uvachedam) these profoundly important words (Vacho) to Romapada."
            Staying for 'seven or eight days' elegantly showcases a highly mature, incredibly patient diplomatic 'Approach'; Dasharatha did not crudely demand His objective the very moment He arrived, which would have been a gross violation of royal etiquette.
            He first invested quality time in honoring their deep friendship, establishing a strong, intimate 'Family Bonding' with His daughter Shanta and son-in-law Rishyashringa; only when absolute trust was cemented did He pivot to His primary mission.
            Valmiki highlights a massive political truth here: 'Patience' is arguably the greatest, most lethal weapon in the arsenal of a supreme ruler; demands made in hasty desperation are overwhelmingly likely to be rejected outright.
            During these seven or eight days, Sage Rishyashringa must have naturally grown incredibly close to Dasharatha, developing a deep, father-like reverence and love for Him; this was, in fact, Dasharatha’s true, underlying 'Strategy.'
            'Romapadamuvachedam' (spoke to Romapada) clearly indicates that Dasharatha did not bypass the system to ask the sage directly; strictly honoring 'Protocol,' He appropriately sought the permission of the sovereign lord of that state first.
            This flawless, highly dignified conduct of the King serves as a brilliant precursor to the supreme 'Maryada' (propriety) that His yet-to-be-born son, Lord Rama, would later establish before the entire universe.
            The highly anticipated, extremely emotional moment had finally arrived—the exact moment where the great Emperor of Ayodhya was about to spread His empty hands before His friend, begging to fill a void that had haunted Him for decades.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 11,
        sanskrit = "यज्ञार्थं यक्षमाणस्य मम सखा त्वमानय ।\nऋष्यशृङ्गं मुनिश्रेष्ठं सभार्यं तत्र गच्छतु ॥ ११ ॥",
        hindiCommentary = """
            राजा दशरथ ने अत्यंत आत्मीयता से कहा—"हे सखा (मित्र)! मैं संतान-प्राप्ति के लिए एक अत्यंत महान यज्ञ करने का संकल्प ले चुका हूँ (यक्षमाणस्य)।"
            "उस यज्ञ को निर्विघ्न संपन्न कराने के लिए (यज्ञार्थं), आप कृपा करके अपनी पत्नी (शान्ता) सहित (सभार्यं) इन मुनिश्रेष्ठ ऋष्यशृंग को मेरे राज्य अयोध्या में भेज दें (तत्र गच्छतु)।"
            दशरथ ने अपने उद्देश्य को घुमा-फिराकर नहीं, बल्कि अत्यंत स्पष्ट और सीधे शब्दों में रोमपाद के सामने रख दिया; यह सच्चे मित्रों के बीच होने वाले संवाद की सबसे बड़ी विशेषता है।
            'सखा' शब्द का प्रयोग दशरथ ने एक 'इमोशनल लिवरेज' (Emotional Leverage) के रूप में किया, जिसका अर्थ था कि "एक राजा के रूप में नहीं, बल्कि एक मित्र के रूप में मैं तुमसे यह सहायता माँग रहा हूँ।"
            'सभार्यं' (पत्नी सहित) बुलाने का अर्थ है कि दशरथ केवल मुनि को नहीं ले जाना चाहते थे, बल्कि वे अपनी पुत्री शान्ता को भी अपने घर ले जाना चाहते थे, जिससे मुनि को अयोध्या में बिल्कुल भी परायापन या अकेलापन महसूस न हो।
            यज्ञ के लिए ऋष्यशृंग की अनिवार्यता दशरथ ने रोमपाद को उसी प्रकार समझा दी जिस प्रकार रोमपाद को अपने राज्य में वर्षा के लिए मुनि की आवश्यकता थी।
            वाल्मीकि जी यहाँ यह स्थापित कर रहे हैं कि संसार में कोई भी व्यक्ति पूरी तरह से आत्मनिर्भर (Self-sufficient) नहीं होता; बड़े से बड़े सम्राट को भी अपने संकट के समय दूसरों के 'तप' और 'मित्रता' की आवश्यकता पड़ती ही है।
            रोमपाद के लिए यह एक बहुत बड़ा 'धर्मसंकट' (Dilemma) हो सकता था—कि वे अपने राज्य के रक्षक (ऋष्यशृंग) को कैसे जाने दें—परंतु मित्र का ऋण चुकाने का यह सबसे बड़ा अवसर भी था।
            दशरथ की यह याचना रामायण के उस महान यज्ञ की अंतिम और सबसे बड़ी 'चेकलिस्ट' (Checklist) को पूरा कर रही थी।
        """.trimIndent(),
        englishCommentary = """
            King Dasharatha spoke with profound intimacy: "O true Friend (Sakha)! I have taken a firm, unbreakable vow to actively perform a grand, monumental sacrifice (Yakshamanasya) for the specific purpose of obtaining an heir."
            "To successfully execute and accomplish that sacrifice (Yajnartham), I earnestly request you to please send (Tatra gacchatu) that foremost of sages, Rishyashringa, along with his wife Shanta (Sabharyam), to my kingdom of Ayodhya."
            Dasharatha did not beat around the bush; He laid out His ultimate, desperate objective before Romapada in the most absolute, direct, and transparent terms, showcasing the supreme hallmark of a conversation between two genuine friends.
            The deliberate use of the word 'Sakha' (friend) acted as a powerful 'Emotional Leverage'; it implicitly meant, "I am not demanding this as the Emperor of the world, but I am begging for this crucial assistance purely as your closest, oldest friend."
            Inviting the sage 'Sabharyam' (along with his wife) implies that Dasharatha did not merely want the priest; He profoundly desired to bring His own daughter Shanta back home, ensuring the naive sage would feel absolutely no alienation or loneliness in Ayodhya.
            Dasharatha clearly communicated the absolute indispensability of Rishyashringa for His sacrifice, drawing a direct parallel to how desperately Romapada had previously needed the very same sage to bring rain to his dying kingdom.
            Valmiki establishes a massive, universal truth here: no human being, regardless of their status, is ever entirely 'Self-sufficient'; even the most powerful universal emperors inevitably require the 'Penance' and 'Friendship' of others during their darkest crises.
            For Romapada, this could have posed a significant 'Dilemma'—how to let go of the literal savior and protective shield of his state—yet it simultaneously presented the absolute greatest opportunity to repay a massive, lifelong debt to his dearest friend.
            This earnest, deeply emotional plea from Dasharatha was actively ticking off the final, and absolutely most critical, item on the 'Checklist' required to initiate the greatest Yajna in the history of the Ramayana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 12,
        sanskrit = "तथेति च प्रतिज्ञाय रोमपादो नराधिपः ।\nमुनिमानय तं शीघ्रं उपायेन नराधिप ॥ १२ ॥",
        hindiCommentary = """
            (यहाँ श्लोक में पुनरावृत्ति का भाव है जो रोमपाद की स्वीकृति को दर्शाता है)
            अपने घनिष्ठ मित्र दशरथ की उस अत्यंत भावुक और धर्म-सम्मत प्रार्थना को सुनकर, नराधिप राजा रोमपाद ने बिना किसी संकोच के "तथा अस्तु" (वैसा ही होगा - तथेति) कहकर अपनी पूर्ण स्वीकृति दे दी (प्रतिज्ञाय)।
            उन्होंने तुरंत अपने मंत्रियों और सेवकों को आदेश दिया कि वे उन मुनि को अपनी पत्नी सहित राजा दशरथ के साथ अयोध्या जाने के लिए शीघ्रता से (शीघ्रं) तैयार करें।
            'तथेति प्रतिज्ञाय' (हाँ कहकर प्रतिज्ञा करना) रोमपाद की उस महान 'मित्रता' (Friendship) और 'कृतज्ञता' (Gratitude) का सबसे बड़ा और ऐतिहासिक प्रमाण है।
            रोमपाद जानते थे कि यदि ऋष्यशृंग अंग देश से चले गए, तो राज्य पर फिर से संकट आ सकता है, परंतु उन्होंने अपने 'स्वार्थ' को अपने मित्र के 'कल्याण' के सामने अत्यंत छोटा मानकर त्याग दिया।
            यह श्लोक यह सिद्ध करता है कि प्राचीन काल में मित्रता केवल सुख बाँटने तक सीमित नहीं थी; मित्र के लिए अपना सर्वस्व न्योछावर कर देना ही सच्ची मित्रता मानी जाती थी।
            दशरथ ने जिस 'उपाय' और विनम्रता से यह बात कही थी, उसने रोमपाद के हृदय को पूरी तरह से जीत लिया था; किसी भी प्रकार के 'वीटो' (Veto) या मना करने का कोई प्रश्न ही नहीं उठा।
            रोमपाद का यह 'निर्णय' रामायण के इतिहास का एक बहुत बड़ा 'कैटलिस्ट' (Catalyst) है; यदि रोमपाद मना कर देते, तो शायद राम का जन्म कभी नहीं हो पाता।
            वाल्मीकि जी यहाँ राजाओं के उस 'विशाल हृदय' (Magnanimity) का वर्णन कर रहे हैं जो एक-दूसरे के राष्ट्र-निर्माण (Nation-building) में पूरी तरह से सहयोग करते थे।
            रोमपाद की इस 'हाँ' के साथ ही दशरथ के जीवन का सबसे बड़ा 'मिशन' अपनी अंतिम और सफल मंजिल तक पहुँच गया था।
        """.trimIndent(),
        englishCommentary = """
            (This verse contains a narrative continuation highlighting Romapada's unhesitating acceptance)
            Upon hearing that highly emotional and thoroughly righteous plea from his most intimate friend, the ruler of men, King Romapada, instantly and without a single shred of hesitation gave his absolute, formal consent, declaring "Tatha Astu" (So be it - Tatheti).
            Having made this firm promise (Pratijnaya), he immediately ordered his ministers to swiftly (Shighram) prepare the great sage, along with his royal wife, to depart for Ayodhya alongside Emperor Dasharatha.
            'Tatheti Pratijnaya' (making the vow by saying 'Yes') stands as the absolute greatest, most historic testament to Romapada’s profound 'Friendship' and limitless 'Gratitude.'
            Romapada was acutely aware that if Rishyashringa left Anga, his kingdom might potentially be exposed to future crises; yet, he overwhelmingly prioritized his friend's ultimate 'Welfare' and salvation over his own state's narrow 'Self-interest.'
            This verse conclusively proves that in the ancient era, true friendship was never confined merely to sharing joyous moments; being entirely willing to sacrifice one's most prized possession for a friend was the ultimate, golden standard of a true alliance.
            The extreme humility and diplomatic perfection with which Dasharatha had made his request completely conquered Romapada’s heart; the very question of applying a 'Veto' or outright refusal never even entered his mind.
            Romapada’s highly selfless 'Decision' acts as a massive 'Catalyst' in the grand history of the Ramayana; had he selfishly refused, the divine incarnation of Lord Rama might have never historically materialized.
            Valmiki describes the incredible 'Magnanimity' (Vishal Hriday) of these ancient monarchs here, brilliantly showcasing how they proactively, selflessly cooperated in each other's 'Nation-building' and spiritual endeavors.
            With this single, monumental "Yes" from Romapada, the absolute greatest, most agonizing 'Mission' of King Dasharatha's entire life had successfully and definitively reached its final, triumphant destination.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 13,
        sanskrit = "ऋष्यशृङ्गं ततो राजा सभार्यं सपरिच्छदम् ।\nपूजयित्वा विसर्गाथं गमनायोपचक्रमे ॥ १३ ॥",
        hindiCommentary = """
            रोमपाद की पूर्ण स्वीकृति प्राप्त करने के पश्चात (ततो), राजा रोमपाद ने मुनि ऋष्यशृंग, उनकी पत्नी शान्ता (सभार्यं) और उनके साथ जाने वाले सभी सेवकों व सामग्रियों (सपरिच्छदम्) की अत्यंत भव्य रूप से पूजा और सत्कार (पूजयित्वा) किया।
            तत्पश्चात, राजा रोमपाद ने उन्हें अत्यंत सम्मान और भारी मन से अयोध्या की ओर प्रस्थान (विसर्गाथं) करने के लिए विदा किया (गमनायोपचक्रमे)।
            यह श्लोक 'विदाई समारोह' (Farewell Ceremony) का अत्यंत भावपूर्ण और राजसी चित्रण प्रस्तुत करता है; अंग देश अपने तारणहार को एक बहुत बड़ी और गौरवशाली विदाई दे रहा था।
            'सपरिच्छदम्' का अर्थ है कि मुनि को अकेले नहीं भेजा गया; उनके आराम और यज्ञ की आवश्यक सामग्रियों के साथ पूरा एक राजसी 'काफिला' (Entourage) उनके साथ अयोध्या भेजा गया।
            रोमपाद द्वारा उनकी पूजा करना (पूजयित्वा) यह सिद्ध करता है कि मुनि अब उनके अधीन नहीं थे, बल्कि वे एक ऐसे पूजनीय अतिथि थे जो एक महान उद्देश्य के लिए दूसरे राज्य जा रहे थे।
            दशरथ के लिए यह क्षण उनके जीवन का सबसे बड़ा 'विजय-क्षण' (Moment of Victory) था; जो संपत्ति वे माँगने आए थे, वह अब उन्हें पूर्ण सत्कार के साथ सौंपी जा रही थी।
            वाल्मीकि जी यहाँ बता रहे हैं कि प्राचीन भारत में संतों और बेटियों की विदाई किस प्रकार अत्यंत आदर, उपहारों और भारी मन के साथ की जाती थी (यहाँ शान्ता की भी विदाई हो रही थी)।
            ऋष्यशृंग का वह रथ जो अब अंग देश से अयोध्या की ओर बढ़ने वाला था, वह वास्तव में त्रेता युग के भाग्य (Destiny) का रथ था, जिस पर भगवान राम के अवतरण की चाबी रखी हुई थी।
            यह दृश्य उन दोनों राजाओं की असीम खुशी और संतोष का प्रतीक है जिन्होंने मिलकर एक असंभव से दिखने वाले ईश्वरीय कार्य को संभव बना दिया था।
        """.trimIndent(),
        englishCommentary = """
            Having secured Romapada's absolute consent (Tato), King Romapada organized an incredibly grand, majestic worship and farewell reception (Pujayitva) for Sage Rishyashringa, his wife Shanta (Sabharyam), and their entire vast retinue of servants and royal supplies (Saparicchadam).
            Thereafter, with the most supreme honors and a highly emotional, heavy heart, King Romapada formally bid them farewell (Visargatham), officially initiating their momentous departure (Gamanayopachakrame) towards the Kingdom of Ayodhya.
            This verse presents an exceedingly poignant, emotional, and highly majestic depiction of the 'Farewell Ceremony'; the entire Kingdom of Anga was tearfully yet gloriously bidding adieu to its ultimate, miraculous savior.
            'Saparicchadam' implies that the sage was absolutely not sent alone; an entire, massive royal 'Entourage' complete with immense comforts, wealth, and necessary sacrificial materials was dispatched alongside him to Ayodhya.
            Romapada worshipping him (Pujayitva) before his departure proves definitively that the sage was not viewed as a subordinate subject, but as a supremely revered, divine guest traveling specifically to execute a monumental, cosmic objective.
            For King Dasharatha, this exact moment represented the absolute, unparalleled 'Moment of Victory' of His entire existence; the priceless, life-giving treasure He had come to beg for was now being handed over to Him with the absolute highest royal honors.
            Valmiki highlights here exactly how deeply, respectfully, and emotionally the departure of perfected saints and beloved daughters was conducted in ancient India, accompanied by massive gifts and profound tears (as Shanta was also essentially returning home).
            The royal chariot carrying Rishyashringa that was now mobilizing from Anga toward Ayodhya was, in absolute reality, the 'Chariot of Destiny' of the Treta Yuga, securely carrying the ultimate key to the divine incarnation of Lord Rama.
            This highly majestic scene serves as the ultimate symbol of the boundless, mutual joy and profound satisfaction of two great kings who had seamlessly collaborated to transform an apparently impossible, divine mandate into an absolute physical reality.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 14,
        sanskrit = "स च तं प्रतिजग्राह दशरथः प्रीतिमान् नृपः ।\nरोमपादं च राजानं आश्लिष्य मुदितो ययौ ॥ १४ ॥",
        hindiCommentary = """
            राजा दशरथ ने अत्यंत प्रीति और असीम उल्लास (प्रीतिमान्) के साथ उन मुनि ऋष्यशृंग और अपनी पुत्री शान्ता को अपने साथ सहर्ष स्वीकार किया (प्रतिजग्राह)।
            वहाँ से प्रस्थान करने से ठीक पूर्व, अत्यंत प्रसन्न और मुदित (मुदितो) राजा दशरथ ने अपने परम मित्र राजा रोमपाद को अपने हृदय से लगा लिया (आश्लिष्य), और फिर अयोध्या की ओर अपनी यात्रा आरंभ की (ययौ)।
            'प्रतिजग्राह' (स्वीकार किया) का अर्थ है कि दशरथ ने उन्हें किसी वस्तु की तरह नहीं, बल्कि भगवान के एक अत्यंत दुर्लभ और पवित्र 'वरदान' (Boon) की तरह अपने हाथों में ग्रहण किया।
            'प्रीतिमान्' (प्रेम से भरे हुए) होना यह दर्शाता है कि दशरथ के भीतर का वह राजा अब पूरी तरह से एक भावुक और कृतज्ञ पिता में बदल चुका था; उनकी वर्षों की 'तपस्या' सफल हो गई थी।
            रोमपाद को गले लगाना (आश्लिष्य) कूटनीति के उस सबसे सुंदर रूप को दर्शाता है जहाँ कोई औपचारिक धन्यवाद (Formal Thank You) काम नहीं आता; यह एक मित्र का दूसरे मित्र के प्रति उस ऋण (Debt) की स्वीकृति थी जिसे जीवन भर नहीं चुकाया जा सकता।
            वाल्मीकि जी ने यहाँ उस अत्यंत मार्मिक 'विदाई-मिलन' (Farewell Hug) का वर्णन किया है जो दो महानायकों के बीच उनके साझा 'मिशन' की सफलता पर हुआ।
            दशरथ अब खाली हाथ नहीं लौट रहे थे; वे अपने साथ अयोध्या के लिए साक्षात् 'उद्धार' (Salvation) लेकर लौट रहे थे।
            उनका वह प्रस्थान (ययौ) अयोध्या की उस सूनी धरती के लिए एक बहुत बड़ी आशा की किरण लेकर आ रहा था, जहाँ प्रजा अपने राजा के लौटने की व्याकुलता से प्रतीक्षा कर रही थी।
            यह श्लोक दशरथ के अंग देश के उस पूरे 'डिप्लोमैटिक अभियान' (Diplomatic Campaign) के अत्यंत 'सक्सेसफुल' (Successful) और भावपूर्ण समापन का प्रतीक है।
        """.trimIndent(),
        englishCommentary = """
            Overflowing with immense love and boundless, ecstatic joy (Pritiman), King Dasharatha gladly, reverently, and gratefully accepted (Pratijagraha) Sage Rishyashringa and His daughter Shanta into His royal care.
            Right before initiating His departure, the intensely delighted and highly elated (Mudito) King Dasharatha warmly, tightly embraced (Ashlishya) His ultimate friend, King Romapada, and then finally set forth (Yayau) on His historic journey back to Ayodhya.
            'Pratijagraha' (accepted) implies that Dasharatha did not receive them merely as strategic assets, but held them precisely as the most unimaginably rare, holy, and priceless 'Boon' directly bestowed by the Supreme Lord Himself.
            Being 'Pritiman' (filled with love) illustrates that the stern, powerful Emperor within Dasharatha had now completely melted into a highly emotional, profoundly grateful father; His decades of agonizing 'penance' had finally, conclusively borne fruit.
            Embracing Romapada (Ashlishya) beautifully showcases the absolute pinnacle of elite diplomacy, where mere formal words of 'Thank You' are entirely inadequate; it was a deeply physical, tearful acknowledgment of an astronomical, lifelong 'Debt' that could never be fully repaid.
            Valmiki brilliantly describes this incredibly poignant and highly emotional 'Farewell Hug' occurring between two monumental heroes celebrating the absolute, one hundred percent success of their shared, cosmic 'Mission.'
            Dasharatha was absolutely no longer returning empty-handed; He was physically transporting the literal, living 'Salvation' back to His grand capital of Ayodhya.
            His triumphant departure (Yayau) carried an impossibly massive, blinding ray of ultimate hope toward that desolate soil of Ayodhya, where millions of loyal subjects were restlessly, desperately awaiting the return of their beloved Monarch.
            This verse stands as the ultimate, highly emotional, and incredibly triumphant symbol marking the flawless conclusion of Dasharatha’s entire 'Diplomatic Campaign' in the Kingdom of Anga.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 15,
        sanskrit = "पौराः शृण्वन्तु मे सर्वे प्रहृष्टाः सन्तु सर्वदा ।\nइत्युक्त्वा स तदा राजा त्वरितं पुरमागतः ॥ १५ ॥",
        hindiCommentary = """
            अयोध्या के समीप पहुँचते ही, राजा दशरथ ने अपने दूतों को यह आदेश दिया—"मेरे नगर के सभी नागरिक (पौराः) यह शुभ समाचार सुनें (शृण्वन्तु) और वे सभी अब हमेशा के लिए अत्यंत हर्षित और आनंदित (प्रहृष्टाः सन्तु सर्वदा) हो जाएँ।"
            यह अत्यंत उत्साहवर्धक आदेश देकर (इत्युक्त्वा), वे महान राजा अत्यंत शीघ्रता और वेग (त्वरितं) के साथ अपनी राजधानी अयोध्या (पुरम्) के भीतर प्रवेश कर गए (आगतः)।
            'पौराः शृण्वन्तु' यह प्रमाणित करता है कि राजा का दुख केवल उनका व्यक्तिगत दुख नहीं था, बल्कि पूरी अयोध्या की प्रजा राजा की पुत्रहीनता के कारण निरंतर शोक में डूबी रहती थी; राजा उन्हें सबसे पहले इस पीड़ा से मुक्त करना चाहते थे।
            दूतों को पहले भेजकर यह 'गुड न्यूज़' (Good News) सुनाना यह सुनिश्चित करता था कि जब मुनि ऋष्यशृंग का नगर में प्रवेश हो, तो पूरा नगर एक भव्य उत्सव (Festival) के रूप में उनका स्वागत करने के लिए पहले से ही तैयार रहे।
            'प्रहृष्टाः सन्तु सर्वदा' (हमेशा के लिए आनंदित हो जाएं) यह एक राजा का अपनी प्रजा के लिए सबसे बड़ा और सच्चा 'कमिटमेंट' (Commitment) है; दशरथ उन्हें यह आश्वस्त कर रहे थे कि अब अयोध्या का अंधकार हमेशा के लिए मिटने वाला है।
            'त्वरितं' (अत्यंत शीघ्रता से) नगर में आना यह बताता है कि दशरथ अब एक भी क्षण का विलंब नहीं चाहते थे; उनका हृदय मुनि को अपनी रानियों और गुरु वसिष्ठ से मिलाने के लिए अत्यंत व्याकुल हो रहा था।
            वाल्मीकि जी यहाँ उस 'मास कम्युनिकेशन' (Mass Communication) का एक बहुत ही शानदार उदाहरण दे रहे हैं जो प्राचीन राजतंत्र में शुभ समाचारों को फैलाने के लिए प्रयोग किया जाता था।
            राजा के आने की खबर सुनते ही पूरी अयोध्या नगरी में जो खुशी की लहर दौड़ी होगी, उसकी केवल कल्पना ही की जा सकती है; नगर के हर घर में मानो दीवाली मनने लगी थी।
            यह श्लोक दशरथ की उस 'विजय-यात्रा' (Victory Parade) की शुरुआत है जहाँ एक राजा ने अपने पुरुषार्थ से अपनी नियति (Destiny) को पूरी तरह से बदल दिया था।
        """.trimIndent(),
        englishCommentary = """
            As He approached the immediate outskirts of Ayodhya, King Dasharatha urgently commanded His messengers: "Let all the citizens of my city (Paurah) immediately hear (Shrinvantu) this highly auspicious news, and let them all become absolutely, permanently ecstatic and overjoyed forever (Prahrishtah santu sarvada)!"
            Having issued this incredibly exhilarating and triumphant command (Ityuktva), that great King entered (Agatah) His grand capital city (Puram) with extreme swiftness, immense speed, and blazing excitement (Tvaritam).
            'Paurah shrinvantu' perfectly authenticates that the King’s sorrow was absolutely not merely His personal, isolated tragedy; the entire populace of Ayodhya had been continuously drowning in deep mourning due to their monarch's heirlessness; He fiercely desired to liberate them from this agony first and foremost.
            Dispatching elite heralds ahead to forcefully broadcast this 'Good News' was a highly strategic move, ensuring that the exact moment Sage Rishyashringa physically entered the city, the entire capital would be fully mobilized and lavishly prepared to welcome him like an unprecedented, monumental 'Festival.'
            'Prahrishtah santu sarvada' (be overjoyed forever) acts as a monarch's absolute greatest, truest, and most profound 'Commitment' to his people; Dasharatha was giving them an ironclad, divine assurance that the dark, depressing era of Ayodhya was now permanently, irreversibly over.
            Entering the city 'Tvaritam' (with extreme swiftness) clearly indicates that Dasharatha refused to tolerate even a single microsecond of delay; His heart was intensely, desperately restless to immediately introduce the miraculous sage to His anxious queens and His Guru, Vashistha.
            Valmiki provides a spectacularly brilliant example of ancient 'Mass Communication' here, demonstrating exactly how highly critical, joyous state intelligence was rapidly and effectively disseminated throughout a vast, ancient kingdom.
            One can only begin to imagine the explosive, unimaginable tidal wave of pure ecstasy that must have instantly swept across the entire city of Ayodhya upon hearing this news; every single house must have spontaneously erupted into a massive celebration resembling Diwali.
            This verse marks the glorious, explosive commencement of Dasharatha’s ultimate 'Victory Parade,' unequivocally showcasing how a resolute king had utilized his targeted human effort to completely, miraculously rewrite his own absolute Destiny.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 16,
        sanskrit = "ततः प्रहृष्टाः पौरजनाः श्रुत्वा मुनिमुपागतम् ।\nप्रत्युज्जग्मुर्मुदा युक्ताः शक्रं देवा इवापरम् ॥ १६ ॥",
        hindiCommentary = """
            अपने राजा के दूतों द्वारा यह अत्यंत शुभ समाचार सुनकर कि वे महान मुनि (ऋष्यशृंग) साक्षात् अयोध्या में पधार चुके हैं (श्रुत्वा मुनिमुपागतम्), अयोध्या के सभी नागरिक (पौरजनाः) असीम उल्लास से भर उठे (प्रहृष्टाः)।
            वे सभी नागरिक अत्यंत आनंद से भरकर (मुदा युक्ताः) उस मुनिराज के स्वागत के लिए उसी प्रकार अपने घरों से बाहर दौड़ पड़े (प्रत्युज्जग्मुर्), जैसे स्वर्ग के देवता अपने राजा इन्द्र (शक्रं) का दर्शन करने के लिए व्याकुल होकर दौड़ पड़ते हैं (देवा इवापरम्)।
            यह श्लोक अयोध्या की उस 'पब्लिक रिस्पॉन्स' (Public Response) और जन-उत्साह का अत्यंत सजीव चित्रण है; पूरी नगरी मुनि की एक झलक पाने के लिए सड़कों पर उमड़ पड़ी थी।
            नागरिकों को यह भली-भांति ज्ञात था कि ऋष्यशृंग कोई साधारण अतिथि नहीं हैं; वे वह 'संजीवनी' हैं जो उनके राजा को पुत्र और उनके राज्य को एक अमर उत्तराधिकारी (Heir) देने वाले हैं।
            इन्द्र (शक्रं) की उपमा देकर वाल्मीकि जी ने यह सिद्ध किया है कि अयोध्या की जनता के लिए ऋष्यशृंग का आगमन किसी बहुत बड़ी और ईश्वरीय 'सेलिब्रिटी' (Celebrity) के आगमन से भी अधिक भव्य और महत्वपूर्ण था।
            'प्रत्युज्जग्मुर्' (आगे बढ़कर स्वागत करना) यह बताता है कि प्रजा ने केवल अपने घरों से नहीं देखा, बल्कि वे मुनि के रथ के आगे-आगे चलकर उन पर पुष्प वर्षा कर रहे थे और उनका जय-जयकार कर रहे थे।
            इस असीम 'मुदा' (आनंद) का कारण राजा के प्रति उनका वह अगाध प्रेम था; वे राजा के दुख को अपना दुख मानते थे, और आज राजा की सफलता उनकी अपनी सबसे बड़ी सफलता बन चुकी थी।
            वाल्मीकि जी यहाँ बता रहे हैं कि जब एक शासक अपनी प्रजा से इतना गहरा 'इमोशनल कनेक्ट' (Emotional Connect) रखता है, तो राज्य की हर घटना एक पारिवारिक उत्सव (Family Festival) में बदल जाती है।
            अयोध्या की वह पावन धरती, जो अब तक एक उदास और शांत राजधानी थी, आज ऋष्यशृंग के चरणों के स्पर्श से एक अत्यंत जीवंत, ऊर्जावान और कोलाहलपूर्ण स्वर्ग में परिवर्तित हो चुकी थी।
        """.trimIndent(),
        englishCommentary = """
            Upon hearing the incredibly auspicious news from the royal heralds that the great sage Rishyashringa had actually, physically arrived in Ayodhya (Shrutva munimupagatam), all the citizens of the capital (Paurajanah) instantly erupted into a state of supreme, ecstatic jubilation (Prahrishtah).
            Filled with absolutely boundless joy and massive excitement (Muda yuktah), the entire populace frantically rushed out of their homes and surged forward to welcome the sage (Pratyujjagmur), exactly as the eager celestial gods rush forward to catch a divine glimpse of their supreme King, Lord Indra (Shakram deva ivaparam).
            This verse provides an incredibly vivid, highly electrifying depiction of the massive 'Public Response' and unprecedented mass enthusiasm; the entire, sprawling metropolis had literally poured out onto the streets just to catch a single, fleeting glimpse of the miracle-working sage.
            The citizens were acutely, profoundly aware that Rishyashringa was no ordinary royal guest; he was the ultimate 'Sanjeevani' (life-giving elixir) who was absolutely destined to bless their beloved King with a son and their empire with an immortal, glorious Heir.
            By deploying the exceptionally powerful metaphor of Indra (Shakram), Valmiki conclusively proves that for the people of Ayodhya, the arrival of Rishyashringa was infinitely grander, more significant, and far more divine than the arrival of the greatest earthly 'Celebrity.'
            'Pratyujjagmur' (rushing forward to welcome) indicates that the subjects did not merely observe passively from their balconies; they actively marched ahead of the sage's royal chariot, relentlessly showering cascades of flowers upon him and loudly chanting his glorious praises.
            The root cause of this infinite 'Muda' (joy) was their incredibly deep, unshakeable love for their King; they had internalized His agonizing sorrow as their own, and today, His historic triumph had become their absolute greatest, personal victory.
            Valmiki highlights here that when a ruler successfully maintains such a profoundly deep, resonant 'Emotional Connect' with his subjects, every single major state event instantaneously transforms into a massive, intimate 'Family Festival.'
            The holy, sacred soil of Ayodhya, which until this moment had been a somewhat gloomy, somber, and overly quiet capital, was today completely, miraculously transformed into an incredibly vibrant, highly energetic, and joyously roaring paradise the very moment it was touched by Rishyashringa's holy feet.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 17,
        sanskrit = "अन्तःपुरं प्रविश्याशु मुनिं तं सपुरोहितम् ।\nपूजयामास विधिवत् सत्कारेण सुविस्तरम् ॥ १७ ॥",
        hindiCommentary = """
            उस असीम जन-सैलाब और उल्लास के बीच, राजा दशरथ ने अत्यंत शीघ्रता (आशु) के साथ अपने राजमहल के भीतरी भाग (अन्तःपुरं) में प्रवेश (प्रविश्य) किया।
            वहाँ पहुँचकर, राजा ने अपने कुलगुरु (पुरोहित वसिष्ठ जी) के साथ मिलकर (सपुरोहितम्), उन मुनिश्रेष्ठ ऋष्यशृंग की अत्यंत विस्तृत (सुविस्तरम्), भव्य और पूर्णतः शास्त्रोक्त विधि (विधिवत्) से पूजा और महान सत्कार (पूजयामास) किया।
            'आशु' (शीघ्रता से) शब्द यह दर्शाता है कि राजा अब बाहरी दिखावे या दरबार की औपचारिकताओं में समय नष्ट नहीं करना चाहते थे; उनका एकमात्र लक्ष्य मुनि को सुरक्षित और सम्मानपूर्वक महल के भीतर लाना था।
            'अन्तःपुरं' (रनिवास) में मुनि का प्रवेश कराना यह सिद्ध करता है कि दशरथ ने ऋष्यशृंग को केवल एक राज्य-अतिथि नहीं माना, बल्कि उन्हें अपने परिवार के सबसे अंतरंग (Intimate) और पूजनीय सदस्य का दर्जा दे दिया था।
            'सपुरोहितम्' (पुरोहित के साथ) का अर्थ है कि महर्षि वसिष्ठ स्वयं उस पूजा में उपस्थित थे; यह एक अत्यंत दुर्लभ दृश्य था जहाँ अयोध्या का सर्वोच्च गुरु एक युवा मुनि का सत्कार कर रहा था, जो ऋष्यशृंग के तपोबल की अथाह महानता को प्रमाणित करता है।
            'विधिवत्' पूजा करने का तात्पर्य है कि मुनि के स्वागत में वेदों का कोई भी नियम या मंत्र नहीं छोड़ा गया; उन्हें साक्षात् 'नारायण' मानकर ही अर्घ्य और पाद्य अर्पित किए गए।
            'सत्कारेण सुविस्तरम्' यह बताता है कि मुनि के लिए जो व्यवस्थाएं की गईं, वे उस समय की सबसे श्रेष्ठ, राजसी और अत्यंत भव्य व्यवस्थाएं थीं, ताकि मुनि को अयोध्या में किसी भी प्रकार का कोई कष्ट या कमी महसूस न हो।
            वाल्मीकि जी यहाँ बता रहे हैं कि जब घर में साक्षात् 'ज्ञान और तपस्या' का प्रवेश होता है, तो उसका स्वागत पूरी विनम्रता और शास्त्रों की मर्यादा के अनुसार ही किया जाना चाहिए।
            यह श्लोक 'हॉस्पिटैलिटी' (Hospitality) के उस सर्वोच्च भारतीय मानक (Supreme Indian Standard) को दर्शाता है जिसे राजा दशरथ ने मुनि के लिए स्थापित किया था।
            यहाँ से अयोध्या के उस राजमहल में वह अत्यंत पवित्र और आध्यात्मिक वातावरण तैयार हो जाता है जो अब साक्षात् 'पुत्रेष्टि यज्ञ' की वेदी बनने वाला है।
        """.trimIndent(),
        englishCommentary = """
            Amidst that boundless, roaring ocean of humanity and sheer ecstasy, King Dasharatha entered (Pravishya) the deep, inner chambers of His royal palace (Antahpuram) with extreme, focused swiftness (Ashu).
            Upon arriving inside, the King, in the highly revered company of His family preceptor Sage Vashistha (S Purohitam), conducted an incredibly expansive (Suvistaram), flawlessly scriptural (Vidhivat), and profoundly grand worship and reception (Pujayamasa) for that pre-eminent Sage Rishyashringa.
            The word 'Ashu' (swiftly) clearly indicates that the King absolutely refused to waste any precious time on external, superficial pomp or standard court formalities; His singular, laser-focused objective was to safely and respectfully escort the sage deep into the highly secure palace.
            Granting the sage entry directly into the 'Antahpuram' (inner private chambers) definitively proves that Dasharatha did not treat Rishyashringa merely as a distinguished state guest, but had instantly elevated him to the status of the most 'Intimate' and supremely worshipped member of His own immediate family.
            'S Purohitam' (along with the priest) signifies that Maharishi Vashistha himself was actively present and participating in this worship; this was an exceptionally rare, monumental sight where the supreme Guru of Ayodhya was personally honoring a young sage, acting as irrefutable proof of the unfathomable, terrifying magnitude of Rishyashringa’s penance.
            Worshipping him 'Vidhivat' strictly implies that absolutely not a single Vedic rule, protocol, or sacred mantra was omitted during the reception; the sage was treated, worshipped, and offered Arghya exactly as if the Supreme Lord Narayana Himself had physically entered the palace.
            'Satkarena suvistaram' reveals that the logistical arrangements and comforts provided for the sage were the absolute most superior, regal, and extraordinarily grand arrangements possible in that era, meticulously designed to ensure the sage never felt the slightest discomfort or lack in Ayodhya.
            Valmiki profoundly illustrates here that when literal, living 'Knowledge and Penance' enters one's home, its reception must be executed with absolute, unyielding humility and in strict, flawless accordance with the highest scriptural propriety.
            This verse brilliantly showcases the absolute 'Supreme Indian Standard' of unparalleled 'Hospitality' that King Dasharatha flawlessly established for the miracle-working sage.
            From this exact, sacred moment, that highly purified, deeply spiritual atmosphere is perfectly constructed within the royal palace of Ayodhya, priming it to serve as the ultimate, holy altar for the impending, cosmic 'Putreshti Yajna.'
        """.trimIndent()
    ),
    RamayanVerse(
        id = 18,
        sanskrit = "शान्तां च दृष्ट्वा तां कन्यां दशरथस्य चकासतीम् ।\nकौसल्याद्याश्च ताः सर्वाः प्रहृष्टाः स्युः स्त्रियस्तदा ॥ १८ ॥",
        hindiCommentary = """
            राजा दशरथ के उस महल में, अपनी उस अत्यंत सुंदर और तेज से चमकती हुई (चकासतीम्) कन्या 'शान्ता' को साक्षात् अपने सामने देखकर (दृष्ट्वा), महारानी कौशल्या अत्यंत गदगद हो गईं।
            कौशल्या सहित रनिवास की वे सभी अन्य रानियाँ और स्त्रियाँ (कौसल्याद्याश्च ताः सर्वाः स्त्रियः) उस समय (तदा) शान्ता को अपने बीच पाकर असीम हर्ष और उल्लास से पूरी तरह भर उठीं (प्रहृष्टाः स्युः)।
            यह श्लोक रामायण का एक अत्यंत मार्मिक और 'इमोशनल रीयूनियन' (Emotional Reunion) का दृश्य है; शान्ता, जो दशरथ और कौशल्या की ही पुत्री थीं और जिन्हें बहुत पहले रोमपाद को गोद दे दिया गया था, वे आज एक लंबे समय के बाद अपने 'मायके' (Maternal Home) लौटी थीं।
            'चकासतीम्' (तेज से चमकती हुई) विशेषण यह बताता है कि शान्ता के चेहरे पर अब एक सिद्ध मुनि की पत्नी होने का वह परम 'ब्रह्म-तेज' (Spiritual Aura) भी जुड़ गया था, जिसने उनके रूप और गरिमा को अनंत गुना बढ़ा दिया था।
            कौशल्या का यह 'हर्ष' (प्रहृष्टाः) केवल यज्ञ की आशा के कारण नहीं था, बल्कि यह एक माँ का वह शुद्ध और स्वाभाविक आनंद था जो अपनी बिछड़ी हुई पुत्री को इतने वर्षों बाद इतने ऊँचे और सुरक्षित स्थान पर देखकर उत्पन्न होता है।
            रनिवास की अन्य सभी स्त्रियाँ भी शान्ता के स्वागत में उसी प्रकार मग्न थीं मानो अयोध्या में कोई बहुत बड़ा और पवित्र उत्सव आ गया हो; पूरा रनिवास प्रेम और वात्सल्य के सागर में डूब गया था।
            वाल्मीकि जी ने यहाँ एक बहुत ही सूक्ष्म 'पारिवारिक मनोविज्ञान' (Family Psychology) को छुआ है; जब कोई बेटी अपने घर वापस आती है, तो वह पूरे घर के वातावरण को एक अजीब सी सकारात्मक ऊर्जा (Positive Energy) से भर देती है।
            शान्ता की उपस्थिति ने उस 'पुत्रेष्टि यज्ञ' के माहौल को केवल एक कर्मकांड नहीं, बल्कि एक पारिवारिक और भावनात्मक अनुष्ठान बना दिया था।
            दशरथ के लिए यह क्षण उनके जीवन की सबसे बड़ी सफलताओं में से एक था, जहाँ उनकी पुत्री भी उनके पास थी, और उनका भविष्य (संतान-प्राप्ति) भी सुनिश्चित हो चुका था।
            यहीं से उस महान अनुष्ठान की आध्यात्मिक और पारिवारिक 'हार्मनी' (Harmony) पूरी तरह से स्थापित हो जाती है, जो ईश्वर के अवतरण के लिए सबसे आवश्यक शर्त है।
        """.trimIndent(),
        englishCommentary = """
            Within that grand palace of King Dasharatha, upon finally seeing (Drishtva) that exquisitely beautiful, radiantly glowing (Chakasatim) royal daughter 'Shanta' standing right before them, Queen Kaushalya became profoundly, emotionally overwhelmed.
            At that exact moment (Tada), Queen Kaushalya, along with all the other queens and royal women of the inner chambers (Kausalyadyashcha tah sarvah striyah), were instantly filled with absolute, boundless joy and immense ecstasy (Prahrishtah syuh) at having Shanta back amidst them.
            This verse depicts an incredibly poignant, highly 'Emotional Reunion' within the Ramayana; Shanta, who was actually the biological daughter of Dasharatha and Kaushalya given in adoption to Romapada long ago, had finally returned to her 'Maternal Home' (Mayeka) after an incredibly long, agonizing separation.
            The powerful adjective 'Chakasatim' (radiantly glowing) implies that Shanta’s face was now brilliantly illuminated not just by her natural beauty, but by the supreme 'Brahma-Tejas' (Spiritual Aura) of being the devoted wife of a perfected sage, multiplying her royal dignity infinitely.
            Kaushalya’s 'Harsha' (Prahrishtah) was not merely a selfish joy regarding the impending Yajna; it was the pure, natural, and overwhelming bliss of a mother who finally sees her long-lost daughter returning home, beautifully settled and occupying an incredibly elevated, highly secure status in life.
            All the other women of the royal household were equally engrossed in welcoming Shanta, celebrating exactly as if a massive, holy festival had spontaneously erupted in Ayodhya; the entire Antahpuram was completely submerged in a deep, warm ocean of maternal love and pure affection.
            Valmiki touches upon incredibly subtle 'Family Psychology' here; when a beloved daughter returns to her maternal home, she effortlessly, magically infuses the entire atmosphere of the house with a highly unique, overwhelming 'Positive Energy' and vibrant life.
            Shanta’s physical presence instantaneously transformed the atmosphere of the impending 'Putreshti Yajna' from a rigid, formal religious ritual into a deeply intimate, highly emotional familial celebration.
            For King Dasharatha, this exact moment stood as one of the absolute greatest, crowning triumphs of His entire life; His beloved daughter was finally back in His arms, and His desperately sought future (obtaining an heir) had now been completely, undeniably guaranteed.
            It is exactly from this point that the absolute spiritual and familial 'Harmony' required for the grand ritual is flawlessly established, serving as the most mandatory, ultimate prerequisite for the divine descent of the Supreme Lord.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 19,
        sanskrit = "पूजिता सा तदा ताभिः शान्ता भर्त्रा सहानघ ।\nतत्रोवास सुखं राजन् सर्वासां च प्रहर्षिणी ॥ १९ ॥",
        hindiCommentary = """
            "हे निष्पाप राजा (अनघ)! उस समय (तदा) रनिवास की उन सभी रानियों और स्त्रियों द्वारा अत्यंत भव्य रूप से पूजी और सम्मानित की गई (पूजिता ताभिः) वह राजकुमारी शान्ता अपने पति (भर्त्रा सह) ऋष्यशृंग के साथ वहाँ अयोध्या में निवास करने लगी।"
            "हे राजन्! वह शान्ता वहाँ सभी लोगों के हृदयों को असीम प्रसन्नता (प्रहर्षिणी) प्रदान करती हुई अत्यंत सुखपूर्वक (सुखं) रहने लगी (तत्रोवास)।"
            (यह श्लोक सुमन्त्र द्वारा राजा दशरथ को कथा सुनाने के संदर्भ में नहीं है, बल्कि महर्षि वाल्मीकि द्वारा स्वयं श्रोता को रामायण की घटना बताने के रूप में है, जहाँ 'अनघ' और 'राजन्' जैसे शब्द संबोधन के लिए प्रयुक्त हुए हैं।)
            'पूजिता' शब्द यह बताता है कि शान्ता को केवल एक बेटी के रूप में नहीं, बल्कि एक 'महान तपस्वी की अर्धांगिनी' के रूप में भी वह सर्वोच्च सम्मान दिया गया जो किसी देवी को दिया जाता है।
            अपने 'भर्त्रा' (पति ऋष्यशृंग) के साथ उनका वह निवास दशरथ के महल के लिए एक बहुत बड़ा रक्षा-कवच बन गया था; जहाँ ये दोनों उपस्थित थे, वहाँ किसी भी प्रकार का दुख या अमंगल प्रवेश ही नहीं कर सकता था।
            'सर्वासां च प्रहर्षिणी' यह सिद्ध करता है कि शान्ता का स्वभाव अत्यंत मधुर और विनम्र था; वे अपने राजसी और आध्यात्मिक तेज से महल की हर स्त्री, हर दासी और हर नागरिक के चेहरे पर केवल और केवल मुस्कान ला रही थीं।
            वाल्मीकि जी यहाँ यह स्पष्ट कर रहे हैं कि एक सद्गुणी और संस्कारी स्त्री जिस भी घर में जाती है, वह उस घर के पूरे वातावरण को 'स्वर्ग' के समान सुखद और सकारात्मक बना देती है।
            उनका वह 'सुखपूर्वक निवास' (तत्रोवास सुखं) इस बात का संकेत है कि मुनि ऋष्यशृंग को भी अयोध्या का वातावरण पूरी तरह से रास आ गया था; उन्हें वहाँ कोई परायापन या अस्वस्थता (Discomfort) महसूस नहीं हुई।
            यह श्लोक उस अत्यंत आवश्यक 'अडेप्टेशन फेज' (Adaptation Phase) को दर्शाता है जहाँ यज्ञ शुरू होने से पहले मुनि और शान्ता को अयोध्या के उस नए माहौल में पूरी तरह से 'सेट' (Set) किया जा रहा था।
            इन सुखद पलों ने राजा दशरथ के भीतर उस 'महायज्ञ' को प्रारंभ करने का पूरा आत्मविश्वास और ऊर्जा भर दी थी, जो रामायण का सबसे बड़ा टर्निंग पॉइंट बनने वाला है।
        """.trimIndent(),
        englishCommentary = """
            "O sinless King (Anagha)! At that highly auspicious time (Tada), having been grandly, reverently worshipped and honored (Pujita tabhih) by all the queens of the inner chambers, Princess Shanta began to reside there in Ayodhya alongside her revered husband (Bhartra saha), Sage Rishyashringa."
            "O King! Imparting absolute, boundless joy and profound delight (Praharshini) to the hearts of everyone present, Shanta began to live (Tatrovasa) there in a state of supreme, undisturbed happiness and extreme comfort (Sukham)."
            (Note: This verse is a direct narration by Sage Valmiki to the listener/reader of the epic, utilizing terms like 'Anagha' and 'Rajan' as respectful modes of address, rather than Sumantra speaking to Dasharatha.)
            The word 'Pujita' (worshipped) indicates that Shanta was not merely welcomed back as a beloved daughter, but was accorded the absolute supreme, goddess-like reverence specifically reserved for the 'better half of a monumental ascetic.'
            Her residence alongside her 'Bhartra' (husband Rishyashringa) essentially functioned as an impenetrable, divine protective shield for Dasharatha’s palace; where this holy couple resided, absolutely no form of sorrow, inauspiciousness, or dark energy could ever dare to enter.
            'Sarvasam cha praharshini' firmly proves that Shanta’s disposition was incredibly sweet, gentle, and profoundly humble; utilizing her royal grace and blazing spiritual aura, she effortlessly brought nothing but pure, radiant smiles to the faces of every queen, maid, and citizen of the palace.
            Valmiki explicitly clarifies here that whenever a highly virtuous, deeply cultured woman enters any household, she instantly, miraculously transforms the entire atmosphere of that home into a highly positive, literal manifestation of 'Heaven.'
            Her 'living happily' (Tatrovasa sukham) serves as a vital, highly positive signal that Sage Rishyashringa himself had also completely, comfortably adapted to the bustling atmosphere of Ayodhya; he experienced absolutely no alienation or psychological 'Discomfort' in that massive urban palace.
            This verse beautifully illustrates the highly critical 'Adaptation Phase,' where, right before the commencement of the grueling sacrifice, both the sage and Shanta were being perfectly, seamlessly integrated and 'Set' into their brand-new, royal environment.
            These intensely blissful, perfectly harmonious moments successfully infused King Dasharatha with the absolute, ultimate self-confidence and explosive energy required to finally initiate that 'Maha-Yajna,' which stands as the absolute greatest turning point in the Ramayana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 20,
        sanskrit = "स तत्रैव वसन् विप्रो जामाता तस्य भूपतेः ।\nततः काले व्यतीते तु वसन्तमृतुमागतम् ॥ २० ॥",
        hindiCommentary = """
            वे महान विप्र (ब्राह्मण ऋष्यशृंग) उस भूपति (राजा दशरथ) के अत्यंत सम्मानित दामाद (जामाता) बनकर वहीं अयोध्या में ही (तत्रैव) अत्यंत सुखपूर्वक निवास करने लगे (वसन्)।
            तत्पश्चात (ततो), इसी प्रकार आनंद में बहुत सारा समय बीत जाने पर (काले व्यतीते तु), प्रकृति का सबसे सुंदर और मादक समय, अर्थात् 'वसंत ऋतु' (वसन्तमृतुम्) का पूर्ण रूप से आगमन हो गया (आगतम्)।
            यह श्लोक समय के उस अत्यंत शांत और तैयारी वाले 'बफर पीरियड' (Buffer Period) को दर्शाता है जहाँ मुनि को यज्ञ के लिए मानसिक रूप से पूरी तरह तैयार किया जा रहा था; वे अब कोई बाहरी अतिथि नहीं, बल्कि अयोध्या के 'स्थायी सदस्य' (Permanent member) बन चुके थे।
            राजा दशरथ के 'दामाद' (जामाता) होने का अर्थ है कि मुनि को वह सर्वोच्च पारिवारिक अधिकार और सुरक्षा प्राप्त थी जो उस काल में किसी को भी दी जा सकती थी; राजा ने उन्हें अपने पुत्र के समान ही दर्जा दे दिया था।
            'काले व्यतीते तु' यह सिद्ध करता है कि दशरथ ने मुनि के आते ही जल्दबाजी में यज्ञ शुरू नहीं किया; उन्होंने मुनि को अयोध्या के वातावरण, वहाँ के लोगों और वहाँ की ऊर्जा के साथ पूरी तरह से 'सिंक' (Sync) होने का पूरा समय दिया, जो एक कुशल 'प्रोजेक्ट मैनेजमेंट' (Project Management) का हिस्सा है।
            'वसंत ऋतु' का आगमन इस कथा का सबसे बड़ा और प्राकृतिक 'मेटाफर' (Metaphor) है; वसंत प्रकृति में नव-जीवन, सृजन (Creation) और हरियाली का प्रतीक है, और ठीक यही 'नव-जीवन' (संतान के रूप में) अब दशरथ के सूने जीवन में भी आने वाला था।
            वसंत ऋतु यज्ञ और शुभ कार्यों के लिए शास्त्रों में सबसे उत्तम और फलदायी समय माना गया है; प्रकृति स्वयं भी अब दशरथ के उस महान 'पुत्रेष्टि यज्ञ' के लिए पूरी तरह से अनुकूल (Favorable) और सज्ज हो चुकी थी।
            वाल्मीकि जी यहाँ बता रहे हैं कि महान कार्य (जैसे ईश्वर का अवतरण) कभी भी हड़बड़ी में नहीं होते; वे ब्रह्मांडीय 'टाइमिंग' (Cosmic Timing) और प्रकृति के पूर्ण सहयोग से ही संपन्न होते हैं।
            यह श्लोक उस लंबी प्रतीक्षा के समाप्त होने और एक बहुत बड़े 'एक्शन' (यज्ञ की शुरुआत) के बिल्कुल मुहाने (Brink) पर खड़े होने का सीधा संकेत है।
            जैसे ही वसंत की ठंडी और सुगंधित हवाएं अयोध्या में चलीं, दशरथ के भीतर का वह संकल्प एक बार फिर पूरी ज्वाला के साथ जाग्रत हो उठा, जिसकी प्रतीक्षा वे वर्षों से कर रहे थे।
        """.trimIndent(),
        englishCommentary = """
            That great Brahmin (Vipra), Sage Rishyashringa, having become the highly honored and deeply revered son-in-law (Jamata) of that King (Bhupateh - Dasharatha), began to comfortably and permanently reside (Vasan) right there (Tatraiva) in Ayodhya.
            Thereafter (Tato), as a significant amount of time passed completely in this blissful state (Kale vyatite tu), the most exquisitely beautiful, highly intoxicating, and perfect season of the year—the 'Season of Spring' (Vasantamritum)—formally and fully arrived (Agatam).
            This verse perfectly captures that profoundly quiet, highly crucial 'Buffer Period' of preparation, where the sage was being mentally, completely acclimated for the gruelling sacrifice; he was no longer an external, foreign guest, but an absolute 'Permanent Member' of the royal family.
            Becoming the 'Son-in-law' (Jamata) of King Dasharatha explicitly means the sage was instantly granted the absolute highest familial authority and impenetrable security that could possibly be bestowed in that era; the King had essentially elevated him to the exact status of His own biological son.
            'Kale vyatite tu' (as time passed) definitively proves that Dasharatha did not impatiently or hastily initiate the sacrifice the moment the sage arrived; He brilliantly provided the sage with ample time to completely 'Sync' with the atmosphere, the people, and the specific energy of Ayodhya, a hallmark of elite 'Project Management.'
            The sudden arrival of the 'Spring Season' is the absolute greatest, most natural 'Metaphor' in this narrative; Spring is the universal symbol of brand-new life, raw fertility, and massive 'Creation' in nature, flawlessly mirroring the exact 'New Life' (in the form of heirs) that was about to violently erupt into Dasharatha’s barren existence.
            According to the Shastras, the Spring season is universally considered the absolute most supreme, highly fruitful, and auspicious period for executing massive sacrifices; Nature herself had now become totally, one hundred percent 'Favorable' and fully primed for Dasharatha’s colossal 'Putreshti Yajna.'
            Valmiki demonstrates here that monumental, history-altering events (such as the descent of the Supreme Lord) are never executed in panicked haste; they are accomplished strictly in perfect, flawless synchronization with precise 'Cosmic Timing' and the absolute cooperation of Nature.
            This verse acts as the direct, undeniable signal that the agonizingly long wait is finally over, and the narrative is now standing on the absolute, highly explosive 'Brink' of massive 'Action' (the commencement of the Yajna).
            The very moment the cool, intoxicatingly fragrant breezes of Spring began to sweep through Ayodhya, that dormant, fiery resolve within Dasharatha’s soul awakened with an explosive, blazing intensity that He had been desperately waiting for over decades.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 21,
        sanskrit = "तं दृष्ट्वा वसन्तं राजा दशरथः प्रहर्षितः ।\nअब्रवीत् तत्र तं विप्रं ऋष्यशृङ्गं सुसत्कृतम् ॥ २१ ॥",
        hindiCommentary = """
            प्रकृति में उस अत्यंत मनमोहक और नव-सृजन के प्रतीक 'वसंत ऋतु' (वसन्तं) को पूरी तरह से छाया हुआ देखकर (दृष्ट्वा), राजा दशरथ अत्यंत प्रसन्न और उत्साहित (प्रहर्षितः) हो गए।
            उस असीम उत्साह से भरकर, राजा ने वहीं पर (तत्र) उन परम तपस्वी और पूर्ण आदर-सत्कार से युक्त (सुसत्कृतम्) महान विप्र ऋष्यशृंग से यह अत्यंत महत्वपूर्ण बात कही (अब्रवीत्)।
            यह श्लोक दशरथ के 'इनीशिएशन' (Initiation) का क्षण है; वसंत ऋतु को देखकर उन्हें यह पूर्ण विश्वास हो गया कि अब ईश्वर और प्रकृति दोनों ही उनके उस 'महान संकल्प' को पूरा करने के लिए अपनी पूरी सहमति (Green Signal) दे चुके हैं।
            'प्रहर्षितः' (अत्यंत प्रसन्न) होना यह दर्शाता है कि दशरथ के भीतर अब कोई भी तनाव (Stress) या संदेह (Doubt) नहीं था; वे अब एक ऐसे योद्धा के समान थे जिसे युद्ध जीतने का पूरा भरोसा हो चुका हो।
            ऋष्यशृंग को 'सुसत्कृतम्' (अत्यंत सत्कार से युक्त) कहने का अर्थ है कि दशरथ ने उन महीनों में मुनि की इतनी अधिक और इतनी निष्काम सेवा की थी कि मुनि अब राजा के किसी भी अनुरोध को ठुकराने की स्थिति में ही नहीं थे; मुनि राजा के प्रेम के पूरी तरह से ऋणी (Indebted) हो चुके थे।
            दशरथ ने सीधे मुनि से बात की (अब्रवीत्), जो यह सिद्ध करता है कि अब बीच में किसी मंत्री या मध्यस्थ (Mediator) की आवश्यकता नहीं थी; ससुर और दामाद के बीच एक अत्यंत सीधा, स्पष्ट और आत्मीय 'कम्युनिकेशन' (Communication) स्थापित हो चुका था।
            वाल्मीकि जी यहाँ बता रहे हैं कि किसी भी बड़े कार्य को कहने का एक 'सही समय' (Perfect Timing) होता है; दशरथ ने पूरे धैर्य के साथ उस वसंत का इंतजार किया और जैसे ही वह आया, उन्होंने अपने बाण (प्रार्थना) को छोड़ दिया।
            यह श्लोक उस 'मुख्य प्रार्थना' (Core Request) की बिल्कुल सटीक 'भूमिका' (Setup) तैयार करता है जिसके लिए यह पूरा अष्टम और नवम सर्ग रचा गया था—अर्थात् 'पुत्रेष्टि यज्ञ' का औपचारिक प्रस्ताव।
            राजा दशरथ की यह प्रसन्नता वास्तव में पूरे इक्ष्वाकु वंश के उस अंधकारमय युग के अंत की प्रसन्नता थी, जो अब साक्षात् 'राम-सूर्य' के उदय के साथ समाप्त होने वाला था।
            यहाँ से अब मुनि और राजा के बीच वह ऐतिहासिक संवाद होगा जो पृथ्वी के इतिहास को हमेशा के लिए बदल कर रख देगा।
        """.trimIndent(),
        englishCommentary = """
            Upon seeing (Drishtva) that the highly enchanting 'Season of Spring' (Vasantam)—the ultimate, universal symbol of fresh fertility and massive new creation—had completely blossomed across nature, King Dasharatha became exceedingly, overwhelmingly delighted and thrilled (Praharshitah).
            Filled with that boundless, blazing enthusiasm, the King approached and spoke (Abravit) right there (Tatra) to that highly ascetic, supremely honored, and impeccably respected (Susatkritam) great Brahmin, Sage Rishyashringa.
            This verse captures the exact, monumental moment of Dasharatha’s 'Initiation'; witnessing the full bloom of Spring provided Him with the absolute, ironclad conviction that both the Supreme Lord and Mother Nature had finally granted their ultimate 'Green Signal' to execute His grand, cosmic resolve.
            Being 'Praharshitah' (overwhelmingly delighted) clearly indicates that Dasharatha was now completely, entirely devoid of any residual 'Stress' or microscopic 'Doubt'; He was acting precisely like a highly confident warrior who already knows with absolute certainty that the war is won.
            Describing Rishyashringa as 'Susatkritam' (accorded the highest honors) implies that Dasharatha had served the sage so selflessly, extensively, and flawlessly over those months that the sage was now utterly incapable of rejecting any request from the King; the sage was profoundly, deeply 'Indebted' to the King's pure love.
            Dasharatha spoke directly (Abravit) to the sage, proving definitively that there was absolutely no longer any need for a minister or a 'Mediator' to intervene; a highly direct, crystal-clear, and deeply intimate 'Communication' channel had been successfully established between the father-in-law and the son-in-law.
            Valmiki demonstrates a profound truth here: there is an absolute 'Perfect Timing' for initiating any massive, life-altering request; Dasharatha had waited with unfathomable patience for this specific Spring, and the exact millisecond it arrived, He released His target arrow (the prayer).
            This verse flawlessly and meticulously prepares the exact 'Setup' for the 'Core Request' around which the entire Eighth and Ninth Sargas were meticulously woven—namely, the formal, official proposal for the 'Putreshti Yajna.'
            King Dasharatha’s sheer joy was, in absolute reality, the triumphant joy marking the definitive end of the dark, heirless era of the Ikshvaku dynasty, an era that was now destined to vanish entirely with the imminent rising of the 'Rama-Sun.'
            From this precise point, the historic, world-altering dialogue between the Monarch and the Sage will formally commence, permanently changing the entire trajectory of earthly history.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 22,
        sanskrit = "यज्ञार्थं प्रसवार्थं च त्वां वृणे मुनिपुङ्गव ।\nतथा कुरु मुनिश्रेष्ठ यथा मे स्युः सुता विभो ॥ २२ ॥",
        hindiCommentary = """
            राजा दशरथ ने अत्यंत आर्त और विनम्र भाव से हाथ जोड़कर कहा—"हे मुनियों में श्रेष्ठ (मुनिपुङ्गव)! मैं पुत्र-प्राप्ति (प्रसवार्थं) और उस महान यज्ञ को संपन्न कराने (यज्ञार्थं) के लिए आपको अपना मुख्य पुरोहित चुनता हूँ (त्वां वृणे)।"
            "हे मुनिश्रेष्ठ! हे सर्वसमर्थ (विभो)! आप कृपा करके कोई ऐसा अचूक उपाय या अनुष्ठान कीजिए (तथा कुरु), जिससे मुझे अत्यंत शीघ्र तेजस्वी पुत्रों की प्राप्ति (यथा मे स्युः सुता) हो सके।"
            यह श्लोक रामायण के पूरे 'बालकाण्ड' का सबसे बड़ा और सबसे महत्वपूर्ण 'संकल्प-वाक्य' (Vow of Resolution) है; राजा दशरथ ने दशकों तक जिस पीड़ा को अपने सीने में दबाकर रखा था, वह आज एक स्पष्ट प्रार्थना के रूप में फूट पड़ी थी।
            'त्वां वृणे' (मैं आपको चुनता हूँ) यह शब्द बहुत गहरा अर्थ रखता है; दशरथ के पास वसिष्ठ, वामदेव जैसे महान ऋषि थे, परंतु उन्होंने इस विशिष्ट 'ऑपरेशन' (Operation) के लिए ऋष्यशृंग को ही चुना, क्योंकि केवल उन्हीं के विशुद्ध ब्रह्मचर्य में वह शक्ति थी जो देवताओं को साक्षात् पृथ्वी पर उतरने को विवश कर सके।
            'प्रसवार्थं' (पुत्र-प्राप्ति के लिए) का स्पष्ट उल्लेख यह बताता है कि यह यज्ञ किसी राज्य-विस्तार, धन या स्वर्ग की प्राप्ति के लिए नहीं था; यह केवल और केवल 'रघुकुल' (Solar Dynasty) के अस्तित्व को बचाने की एक अंतिम और हताश पुकार (Desperate Call) थी।
            'विभो' (सर्वसमर्थ) कहकर दशरथ ने मुनि को यह अहसास कराया कि अब मेरे राज्य, मेरे जीवन और मेरे वंश की पूरी चाबी केवल और केवल आपके हाथों में है; मैं पूरी तरह से आपके तपोबल पर निर्भर हूँ (Absolute Surrender)।
            वाल्मीकि जी ने इस श्लोक में एक पिता की उस 'वल्नरेबिलिटी' (Vulnerability) को बहुत ही सजीव कर दिया है जो दुनिया का सबसे शक्तिशाली राजा होते हुए भी, संतान के लिए एक सन्यासी के सामने भिखारी की तरह खड़ा है।
            'तथा कुरु' (वैसा ही कीजिए) यह कोई राजा का 'ऑर्डर' (Order) नहीं था, बल्कि यह एक भक्त की उस भगवान से की गई प्रार्थना थी जो असंभव को भी संभव करने की क्षमता रखता है।
            इस प्रार्थना के साथ ही दशरथ ने अपना पूरा 'ईगो' (Ego) ऋष्यशृंग के चरणों में समर्पित कर दिया था, और यही वह समर्पण था जो ईश्वर के अवतार की सबसे पहली और अनिवार्य शर्त होती है।
            यह श्लोक उस 'कॉस्मिक ट्रिगर' (Cosmic Trigger) का कार्य करता है जिसने 'पुत्रेष्टि यज्ञ' की अग्नि को प्रज्वलित किया और रावण के वध की उल्टी गिनती (Countdown) शुरू कर दी।
        """.trimIndent(),
        englishCommentary = """
            With folded hands and an incredibly earnest, humble demeanor, King Dasharatha pleaded: "O foremost among sages (Munipungava)! For the specific, desperate purpose of obtaining an heir (Prasavartham) and to flawlessly execute that monumental sacrifice (Yajnartham), I officially and formally choose you as my supreme priest (Tvam vrine)."
            "O absolute best of sages! O all-powerful, highly capable Lord (Vibho)! Please, kindly execute such an infallible ritual or deploy such a divine method (Tatha kuru), by which I may definitively and swiftly be blessed with radiant sons (Yatha me syuh suta)."
            This verse stands as the absolute greatest, most historically significant 'Vow of Resolution' (Sankalpa-vakya) in the entire Bala Kanda; the agonizing, soul-crushing pain that Dasharatha had suppressed within His chest for decades finally erupted today in the form of this crystal-clear, desperate prayer.
            The phrase 'Tvam vrine' (I deliberately choose you) carries massive weight; Dasharatha already possessed supreme sages like Vashistha and Vamadeva, yet He specifically selected Rishyashringa for this elite 'Operation,' knowing absolutely that only Rishyashringa’s unblemished, absolute celibacy possessed the sheer gravitational force to physically drag the Gods down to earth.
            The explicit mention of 'Prasavartham' (for obtaining offspring) conclusively proves that this sacrifice was absolutely not for imperial expansion, hoarding wealth, or attaining heaven; it was exclusively the final, highly 'Desperate Call' to physically save the very existence of the 'Raghukula' (Solar Dynasty) from total extinction.
            By addressing him as 'Vibho' (All-powerful), Dasharatha made the sage acutely realize that the entire key to His kingdom, His very life, and His future lineage now rested exclusively in his hands; it was a state of 'Absolute Surrender' to the sage's power of penance.
            Valmiki has incredibly vividly captured the raw 'Vulnerability' of a father here—demonstrating how the most powerful, undisputed Emperor in the world stands entirely like a helpless beggar before an ascetic, solely for the desperate desire of a child.
            'Tatha kuru' (please do it) was absolutely not a royal 'Order'; it was the deeply emotional, tearful prayer of a true devotee directed toward a god-like figure who possessed the proven capability to render the scientifically impossible into an absolute reality.
            With this singular prayer, Dasharatha completely surrendered His entire royal 'Ego' at the holy feet of Rishyashringa, and it is precisely this total surrender that serves as the first, absolute mandatory prerequisite for the divine incarnation of the Supreme Lord.
            This verse acts as the ultimate 'Cosmic Trigger' that formally ignited the blazing fire of the 'Putreshti Yajna' and instantly commenced the unstoppable, cosmic 'Countdown' for the brutal annihilation of the demon king, Ravana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 23,
        sanskrit = "तथेति स च राजानं उवाच मुनिपुङ्गवः ।\nकरिष्ये सर्वमेतत् ते यथैतद् भविता नृप ॥ २३ ॥",
        hindiCommentary = """
            राजा दशरथ की उस अत्यंत भावुक और धर्ममय प्रार्थना को सुनकर, उन मुनिश्रेष्ठ (मुनिपुङ्गवः) ऋष्यशृंग ने बिना एक भी क्षण का विलंब किए राजा से कहा—"तथा अस्तु" (ऐसा ही होगा - तथेति)।
            मुनि ने राजा को पूर्ण रूप से आश्वस्त करते हुए कहा—"हे नृप (राजा)! मैं आपके लिए यह सब कुछ (यज्ञ आदि) पूरी निष्ठा से करूँगा (करिष्ये सर्वमेतत् ते), जिससे (यथैतद्) आपको अत्यंत शीघ्र तेजस्वी पुत्रों की प्राप्ति निश्चित रूप से हो जाए (भविता)।"
            यह श्लोक दशरथ के जीवन का सबसे बड़ा 'विजय-घोष' (Declaration of Victory) है; जिस मुनि की एक 'हाँ' सुनने के लिए दशरथ ने अंग देश की यात्रा की, महीनों प्रतीक्षा की और इतना बड़ा कूटनीतिक जाल बुना, वह 'हाँ' (तथेति) आख़िरकार उन्हें मिल ही गई।
            'तथेति' (तथा अस्तु) कोई सामान्य शब्द नहीं है; जब यह शब्द किसी ऐसे सिद्ध ब्रह्मचारी और तपस्वी के मुख से निकलता है जिसने कभी कोई पाप न किया हो, तो वह शब्द साक्षात् 'ब्रह्मास्त्र' के समान अचूक हो जाता है, जिसे स्वयं विधाता भी नहीं टाल सकते।
            'करिष्ये सर्वमेतत् ते' (मैं आपके लिए यह सब करूँगा) यह सिद्ध करता है कि ऋष्यशृंग ने इस कार्य को किसी दबाव (Pressure) या राजसी लालच में नहीं स्वीकारा था; उन्होंने दशरथ के सच्चे प्रेम, वात्सल्य और उनकी पीड़ा को गहराई से समझकर यह दायित्व अपने कंधों पर लिया था।
            मुनि का यह वचन दशरथ के लिए साक्षात् भगवान के उस 'प्रॉमिस' (Promise) के समान था कि अब रघुकुल का कभी नाश नहीं होगा।
            वाल्मीकि जी यहाँ बता रहे हैं कि जब साधक (दशरथ) की पुकार में पूर्ण 'सत्य' और 'समर्पण' होता है, तो सिद्ध पुरुष (ऋष्यशृंग) उसकी सहायता करने से कभी पीछे नहीं हटते।
            इस 'हाँ' के साथ ही रामायण का वह 'प्रॉब्लम स्टेटमेंट' (Problem Statement)—कि दशरथ निपुत्र हैं—पूरी तरह से हल (Solve) होने के मार्ग पर अग्रसर हो गया था।
            अब केवल कर्मकांड (Rituals) शेष थे, परंतु 'रिजल्ट' (Result) की गारंटी तो मुनि के इन वचनों ने उसी क्षण दे दी थी; दशरथ का हृदय अब पूरी तरह से चिंतामुक्त (Stress-free) हो चुका था।
            यहीं से उस महान 'अश्वमेध' और 'पुत्रेष्टि यज्ञ' की वह अत्यंत तेज और भव्य तैयारी शुरू होती है जो पूरी अयोध्या को एक विशाल यज्ञ-शाला में बदल देने वाली है।
        """.trimIndent(),
        englishCommentary = """
            Instantly upon hearing King Dasharatha’s highly emotional and deeply righteous prayer, that pre-eminent sage (Munipungavah), Rishyashringa, replied to the King without a single microsecond of delay, declaring—"Tatha Astu" (So be it - Tatheti).
            Completely reassuring the King with absolute, ironclad certainty, the sage said: "O Monarch (Nripa)! I shall execute all of this (the sacrifices) for you with absolute dedication (Karishye sarvametat te), in such a flawless manner that you shall definitively and undoubtedly obtain radiant sons (Yathaitad bhavita)."
            This verse stands as the absolute greatest 'Declaration of Victory' in King Dasharatha’s entire existence; the single, magical "Yes" (Tatheti) for which He had traveled all the way to Anga, waited patiently for months, and woven such a massive diplomatic net, had finally, triumphantly been granted to Him.
            'Tatheti' (So be it) is absolutely no ordinary phrase; when this specific word emerges from the mouth of a perfected, sinless Brahmachari and highly severe ascetic, it essentially becomes as infallible and unstoppable as a literal 'Brahmastra,' a decree that even the Creator Brahma Himself cannot dare to override or alter.
            'Karishye sarvametat te' (I will do all this for you) definitively proves that Rishyashringa did not accept this colossal task under any form of political 'Pressure' or royal greed; he voluntarily shouldered this massive responsibility entirely because he had deeply understood Dasharatha’s pure love, profound affection, and agonizing pain.
            This solemn vow from the sage acted as a literal, divine 'Promise' directly from the Supreme Lord to Dasharatha, guaranteeing that the glorious Solar Dynasty would absolutely never face extinction.
            Valmiki demonstrates here that when the desperate cry of a true seeker (Dasharatha) contains absolute 'Truth' and total 'Surrender,' perfected saints (Rishyashringa) never hesitate to step forward and unconditionally provide their supreme assistance.
            With this monumental "Yes," the primary, core 'Problem Statement' of the Ramayana—that Dasharatha is heirless—was instantly propelled onto the unalterable path of being completely and permanently 'Solved.'
            Only the physical rituals remained to be executed, but the absolute guarantee of the 'Result' was firmly sealed the very second those words left the sage's lips; Dasharatha’s heart was now completely, entirely 'Stress-free' and liberated.
            It is exactly from this point that the highly accelerated, incredibly grand preparations for the colossal 'Ashvamedha' and 'Putreshti Yajna' aggressively commence, an event destined to transform the entire city of Ayodhya into one massive, holy sacrificial altar.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 24,
        sanskrit = "ततो राजा दशरथो मन्त्रिणः श्रेष्ठमब्रवीत् ।\nयज्ञोपकरणं सर्वं सज्जीकुरुत सत्वरम् ॥ २४ ॥",
        hindiCommentary = """
            मुनि ऋष्यशृंग की वह अंतिम और सुनिश्चित 'हाँ' प्राप्त करने के पश्चात् (ततो), राजा दशरथ ने तुरंत अपने सबसे श्रेष्ठ और विश्वसनीय मंत्रियों (मन्त्रिणः श्रेष्ठम्) को पास बुलाया और उनसे कहा (अब्रवीत्)।
            "हे मंत्रियों! अब तुम लोग अत्यंत शीघ्रता (सत्वरम्) के साथ इस महान अश्वमेध यज्ञ के लिए आवश्यक सभी सामग्रियों और उपकरणों (यज्ञोपकरणं सर्वं) को एकत्र करके पूरी तरह से तैयार करो (सज्जीकुरुत)।"
            यह श्लोक दशरथ के उस प्रचंड 'एक्शन मोड' (Action Mode) को दर्शाता है जो उनके भीतर वर्षों से दबा हुआ था; मुनि की स्वीकृति मिलते ही राजा ने एक पल भी व्यर्थ नहीं किया और पूरी राज्य-मशीनरी को तुरंत 'गियर' (Gear) में डाल दिया।
            'यज्ञोपकरणं' का अर्थ केवल लकड़ी या घी नहीं था; अश्वमेध यज्ञ के लिए सैकड़ों प्रकार के दुर्लभ रत्न, विशेष औषधियाँ, हजारों पशु, और दुनिया भर के राजाओं व ब्राह्मणों के ठहरने के लिए भव्य मंडपों का निर्माण शामिल था।
            यह कोई साधारण आयोजन नहीं था; यह एक 'मेगा-इवेंट' (Mega-event) था जिसे संपन्न करने के लिए पूरे राष्ट्र के आर्थिक और प्रशासनिक 'लॉजिस्टिक' (Logistics) को एक साथ जुटना था।
            'सत्वरम्' (तुरंत) शब्द यह बताता है कि दशरथ के भीतर कितनी असीम व्याकुलता (Restlessness) थी; वे जानते थे कि मुनि अब तैयार हैं और प्रकृति (वसंत ऋतु) भी अनुकूल है, अतः 'टाइमिंग' (Timing) बिल्कुल 'परफेक्ट' (Perfect) थी।
            वाल्मीकि जी यहाँ एक कुशल प्रशासक की उस 'एग्जीक्यूशन क्षमता' (Execution Capability) को स्पष्ट कर रहे हैं, जहाँ योजना के पास होते ही उसे धरातल पर उतारने में कोई देरी नहीं की जाती।
            राजा का आदेश मिलते ही पूरी अयोध्या नगरी, जो अब तक अत्यंत शांत थी, वह अचानक एक बहुत बड़ी 'कर्मभूमि' (Workplace) में बदल गई; हर मंत्री, हर सिपाही और हर नागरिक यज्ञ की तैयारी में जुट गया।
            यह श्लोक रामायण के उस खंड का श्रीगणेश करता है जहाँ अयोध्या का वैभव और उसकी क्षमता (Capacity) अपने सबसे चरम और भव्य रूप में पूरी दुनिया के सामने आने वाली थी।
            दशरथ का यह आदेश वास्तव में भगवान राम के उस दिव्य रथ को तैयार करने का आदेश था जिस पर बैठकर वे इस पृथ्वी पर पधारने वाले थे।
        """.trimIndent(),
        englishCommentary = """
            Immediately after securing that final, absolute, and guaranteed "Yes" from Sage Rishyashringa (Tato), King Dasharatha instantly summoned his absolute best, most highly trusted ministers (Mantrinah shreshtham) and issued a stern command (Abravit).
            "O ministers! You must act with extreme, immediate swiftness (Satvaram) to gather, organize, and completely prepare (Sajjikuruta) absolutely all the necessary materials, massive equipment, and resources required for this grand Ashvamedha sacrifice (Yajnopakaranam sarvam)."
            This verse vividly illustrates Dasharatha rapidly snapping into a fierce, hyper-active 'Action Mode' that had been suppressed within Him for decades; the very millisecond He received the sage's consent, the King wasted no time and instantly threw the entire state machinery into high 'Gear.'
            'Yajnopakaranam' (sacrificial materials) did not merely mean simple wood or ghee; an Ashvamedha Yajna demanded hundreds of incredibly rare gems, highly specific medicinal herbs, thousands of animals, and the massive, rapid construction of majestic pavilions to host visiting kings and Brahmins from across the globe.
            This was absolutely no ordinary function; it was an unprecedented 'Mega-event' that mandated the total, unified mobilization of the entire nation's highly complex economic and administrative 'Logistics.'
            The specific use of the word 'Satvaram' (immediately) highlights the immense, burning 'Restlessness' within Dasharatha; He knew with absolute certainty that the sage was fully ready and Nature herself (the Spring season) was completely favorable, making the 'Timing' absolutely, one hundred percent 'Perfect.'
            Valmiki explicitly demonstrates the massive 'Execution Capability' of a highly efficient administrator here—the moment a flawless plan receives the green light, its ground implementation must commence without a single fraction of a second's delay.
            Upon receiving the King’s royal mandate, the entire city of Ayodhya, which had been profoundly quiet and peaceful until now, suddenly and aggressively transformed into a massive, bustling 'Workplace' (Karmabhumi); every minister, soldier, and citizen instantly plunged into the intense preparations.
            This verse officially inaugurates that specific segment of the Ramayana where the unimaginable opulence, sheer wealth, and massive operational 'Capacity' of Ayodhya are about to be displayed in their absolute most majestic and extreme form before the entire world.
            Dasharatha’s explicit command was, in absolute reality, the direct order to begin constructing the very divine, golden chariot upon which Lord Rama was ultimately destined to descend onto the physical earth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 25,
        sanskrit = "अश्वाश्च विमुच्यन्तां सर्वलक्षणसंयुताः ।\nतथैव च शान्त्यर्थं ऋत्विजश्चान्ववेक्षताम् ॥ २५ ॥",
        hindiCommentary = """
            राजा दशरथ ने मंत्रियों को अपना अगला सबसे महत्वपूर्ण आदेश देते हुए कहा—"अश्वमेध यज्ञ के लिए जो घोड़े (अश्वाश्च) सभी उत्तम लक्षणों से पूरी तरह युक्त (सर्वलक्षणसंयुताः) हों, उन्हें विधि-विधान के साथ तुरंत स्वतंत्र छोड़ दिया जाए (विमुच्यन्तां)।"
            "और उसी प्रकार (तथैव च), राज्य में किसी भी प्रकार की बाधा या अमंगल न हो, इसके लिए शांति-पाठ और रक्षा-कवच (शान्त्यर्थं) स्थापित करने का कार्य हमारे महान पुरोहितों और ऋत्विजों द्वारा तुरंत शुरू कर दिया जाए (अन्ववेक्षताम्)।"
            यह श्लोक 'अश्वमेध यज्ञ' की उस सबसे बड़ी और 'सिग्नेचर' (Signature) प्रक्रिया का वर्णन करता है जहाँ एक अत्यंत विशिष्ट घोड़े को राज्य की शक्ति और संप्रभुता (Sovereignty) के प्रतीक के रूप में पूरे विश्व में घूमने के लिए खुला छोड़ दिया जाता है।
            'सर्वलक्षणसंयुताः' का अर्थ है कि वह घोड़ा कोई साधारण घोड़ा नहीं हो सकता था; उसका रंग, उसकी चाल और उसकी नस्ल शास्त्रों में बताए गए अत्यंत कड़े नियमों के अनुसार ही होनी चाहिए थी, जो अयोध्या की 'परफेक्शन' (Perfection) को दर्शाता है।
            घोड़े को छोड़ने का अर्थ यह भी था कि राजा दशरथ ने अब पूरे विश्व को यह खुली चुनौती (Open Challenge) दे दी थी कि यदि किसी में साहस है तो वह दशरथ के यज्ञ को रोक कर दिखाए; यह उनके अदम्य आत्मविश्वास का प्रतीक था।
            'शान्त्यर्थं' (शांति के लिए) का आदेश यह सिद्ध करता है कि दशरथ केवल बाहुबल पर निर्भर नहीं थे; वे जानते थे कि ऐसे महान यज्ञों में राक्षस (जैसे रावण के गुप्तचर) अवश्य विघ्न डालने का प्रयास करते हैं, इसलिए 'आध्यात्मिक सुरक्षा' (Spiritual Security) भी उतनी ही अनिवार्य थी।
            ऋत्विजों को यह कार्य सौंपना यह बताता है कि राजा ने 'फिजिकल डिफेन्स' (Physical Defense - घोड़े के साथ सेना) और 'मेटाफिजिकल डिफेन्स' (Metaphysical Defense - मंत्रों का कवच) दोनों को एक साथ 'एक्टिवेट' (Activate) कर दिया था।
            वाल्मीकि जी ने इस श्लोक में एक चक्रवर्ती सम्राट के उस 'रिस्क मैनेजमेंट' (Risk Management) का बहुत ही सुंदर उदाहरण दिया है जहाँ हर छोटी-से-छोटी संभावना (Possibility) को ध्यान में रखकर योजना बनाई जाती है।
            घोड़े का छूटना वास्तव में रामायण की उस घटना का 'काउन्टडाउन' (Countdown) था जिसके पूरा होते ही भगवान को पृथ्वी पर आना ही था।
            दशरथ का यह आदेश अयोध्या की सेना और पुरोहितों दोनों के लिए एक साथ युद्ध-स्तर (War-footing) पर काम शुरू करने का साक्षात् शंखनाद था।
        """.trimIndent(),
        englishCommentary = """
            Issuing His next, highly critical command to the ministers, King Dasharatha declared: "Let the horses (Ashvashcha) that are absolutely, flawlessly endowed with all the supreme, highly auspicious characteristics (Sarvalakshanasamyutah) be formally and immediately released (Vimuchyantam) to roam freely for the Ashvamedha sacrifice."
            "And in that exact same manner (Tathaiva cha), to ensure that absolutely no obstacles or inauspicious events disrupt this grand ritual, let our great royal priests immediately initiate and meticulously oversee (Anvavekshatam) the powerful peace-chants and spiritual protective shields (Shantyartham)."
            This verse describes the absolute grandest and the most defining 'Signature' process of the 'Ashvamedha Yajna,' where a highly specialized horse is released to roam freely across the globe, acting as the living, breathing symbol of the empire's ultimate power and unquestionable Sovereignty.
            'Sarvalakshanasamyutah' dictates that the horse could absolutely not be an ordinary animal; its exact color, specific gait, and pure breed had to strictly adhere to incredibly rigorous, stringent scriptural rules, perfectly reflecting Ayodhya’s unwavering commitment to absolute 'Perfection.'
            Releasing the horse essentially meant that King Dasharatha had now issued an 'Open Challenge' to the entire world, daring any monarch who possessed the sheer audacity to try and halt Dasharatha’s grand sacrifice; it was the ultimate symbol of His indomitable, soaring self-confidence.
            The command for 'Shantyartham' (for peace and spiritual protection) proves that Dasharatha did not rely solely on brute military force; He was acutely aware that massive sacrifices inherently attract destructive demons (like Ravana's spies), making an impenetrable 'Spiritual Security' grid absolutely mandatory.
            Assigning this specific task to the Ritvijas (priests) demonstrates that the King had simultaneously 'Activated' both His 'Physical Defense' (the army guarding the horse) and His 'Metaphysical Defense' (the invincible armor of Vedic mantras).
            Valmiki provides an outstanding, flawless example of a universal Emperor's elite 'Risk Management' here, meticulously factoring in every microscopic 'Possibility' and potential threat while formulating the master strategy.
            The physical release of the horse was, in absolute reality, the official 'Countdown' for that monumental Ramayana event upon whose completion the Supreme Lord was unequivocally bound to descend to earth.
            This explicit royal decree served as the ultimate conch-shell blast, instantly mobilizing both Ayodhya’s massive military and its elite priesthood to commence their operations strictly on a frantic 'War-footing.'
        """.trimIndent()
    ),
    RamayanVerse(
        id = 26,
        sanskrit = "तथेति च प्रतिज्ञाय मन्त्रिणो राजशासनात् ।\nचक्रुः सर्वं यथाज्ञाप्तं त्वरितं सर्वकारिणः ॥ २६ ॥",
        hindiCommentary = """
            राजा दशरथ के उस अत्यंत कठोर और स्पष्ट आदेश (राजशासनात्) को सुनकर, उन सभी अत्यंत योग्य और सभी कार्यों को करने में सक्षम (सर्वकारिणः) मंत्रियों ने बिना किसी संकोच के "तथा अस्तु" (वैसा ही होगा - तथेति) कहकर अपनी प्रतिज्ञा (प्रतिज्ञाय) कर ली।
            और फिर, उन मंत्रियों ने राजा द्वारा दी गई आज्ञा के ठीक अनुरूप (यथाज्ञाप्तं), अत्यंत शीघ्रता और स्फूर्ति (त्वरितं) के साथ उस पूरी योजना और उन सभी यज्ञीय कार्यों (सर्वं) को धरातल पर क्रियान्वित (चक्रुः) कर दिया।
            यह श्लोक अयोध्या की उस 'सुपर-एफिशिएंट' (Super-efficient) प्रशासनिक मशीनरी (Administrative Machinery) का सबसे बड़ा प्रमाण है; राजा के मुख से शब्द निकलता था और मंत्री उसे तुरंत 'रियलिटी' (Reality) में बदल देते थे।
            'प्रतिज्ञाय' (प्रतिज्ञा करना) यह दर्शाता है कि मंत्रियों ने उस आदेश को केवल एक सरकारी काम (Official Job) नहीं माना, बल्कि उसे एक 'संकल्प' (Vow) के रूप में लिया जिसे उन्हें हर हाल में पूरा करना था; उनके लिए असफलता का कोई विकल्प (Option) ही नहीं था।
            'सर्वकारिणः' विशेषण यह सिद्ध करता है कि वे मंत्री 'ऑल-राउंडर्स' (All-rounders) थे; चाहे वह सेना का प्रबंध हो, खजाने का उपयोग हो, या पुरोहितों का समन्वय (Coordination) हो, वे हर प्रकार के कठिन से कठिन कार्य को अत्यंत सरलता से संपन्न कर सकते थे।
            'यथाज्ञाप्तं' (जैसी आज्ञा दी गई) का अर्थ है कि उन्होंने राजा की योजना में अपनी ओर से कोई छेड़छाड़ (Manipulation) नहीं की; वे अपनी सीमा और अपने राजा की दूरदर्शिता (Foresight) का पूरा सम्मान करते थे।
            वाल्मीकि जी यहाँ यह स्पष्ट कर रहे हैं कि एक महान राजा केवल तभी महान बनता है जब उसके पास 'त्वरितं' (तुरंत) कार्य करने वाली एक अत्यंत वफादार (Loyal) और सक्षम टीम (Team) हो।
            मंत्रियों की इस तीव्र गति (Speed) के कारण ही अयोध्या में यज्ञ की तैयारी उस 'स्केल' (Scale) पर हो सकी जिसे देखकर देवता भी चकित रह गए थे।
            यहाँ यह भी सिद्ध होता है कि राजा और मंत्रियों के बीच का वह 'कम्युनिकेशन' (Communication) कितना सटीक और दोष-रहित (Flawless) था; राजा ने जो 'विज़न' (Vision) देखा, मंत्रियों ने उसे तुरंत मूर्त रूप दे दिया।
            इस श्लोक के साथ ही यज्ञ की सैद्धांतिक (Theoretical) तैयारियाँ समाप्त होती हैं और पूरी अयोध्या पूरी तरह से 'एक्शन' (Action) के उस महासागर में उतर जाती है जो राम के जन्म का कारण बनने वाला है।
        """.trimIndent(),
        englishCommentary = """
            Upon hearing that highly explicit, strict, and absolute royal command (Rajashasanat) from King Dasharatha, all those exceptionally capable ministers, who were absolute masters of executing all tasks (Sarvakarinah), instantly vowed "Tatha Astu" (So be it - Tatheti) without a single shred of hesitation (Pratijnaya).
            And then, entirely and strictly in accordance with the exact, precise instructions delivered by the King (Yathajnaptam), those ministers executed and materialized (Chakruh) that entire massive operation and all required tasks (Sarvam) with extreme, breathtaking swiftness and agility (Tvaritam).
            This verse acts as the ultimate, irrefutable proof of Ayodhya’s 'Super-efficient' and highly advanced 'Administrative Machinery'; the very moment a word left the King's lips, the ministers instantaneously and flawlessly translated it into physical 'Reality.'
            'Pratijnaya' (making a solemn vow) vividly demonstrates that the ministers did not treat this command merely as a routine 'Official Job'; they internalized it deeply as a sacred 'Vow' that had to be fulfilled at all costs; for them, failure was absolutely never an 'Option.'
            The powerful epithet 'Sarvakarinah' proves that those ministers were ultimate 'All-rounders'; whether it involved complex military logistics, massive treasury deployments, or meticulous 'Coordination' with the priesthood, they could execute the most impossibly difficult tasks with astonishing ease.
            'Yathajnaptam' (exactly as commanded) signifies that they strictly refrained from artificially tampering with or 'Manipulating' the King's flawless blueprint; they possessed an immense, unyielding respect for their own boundaries and their Monarch's profound 'Foresight.'
            Valmiki explicitly clarifies here that a truly great King only achieves his monumental greatness when he is backed by a fiercely 'Loyal' and exceptionally capable 'Team' that operates 'Tvaritam' (with absolute immediacy).
            It was entirely due to this incredible, blazing 'Speed' of the ministers that the massive preparations for the sacrifice in Ayodhya were executed on a staggering 'Scale' that left even the celestial gods utterly mesmerized and astounded.
            This also conclusively proves how highly accurate, precise, and completely 'Flawless' the 'Communication' channel was between the King and His cabinet; whatever grand 'Vision' the Monarch conceptualized, the ministers instantly transformed into a concrete, physical reality.
            With this powerful verse, the purely 'Theoretical' preparations for the Yajna conclude completely, and the entire city of Ayodhya plunges headfirst into that massive, roaring ocean of 'Action' that will inevitably and soon culminate in the divine birth of Lord Rama.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 27,
        sanskrit = "ततो द्विजान् स राजा तु सम्पूज्य प्रतिमान्य च ।\nविसर्जयामास तदा सर्वानवनीपतिः ॥ २७ ॥",
        hindiCommentary = """
            अपने मंत्रियों को कार्य सौंपने के पश्चात् (ततो), उस महान अवनीपति (पृथ्वी के स्वामी) राजा दशरथ ने वहाँ राजसभा में उपस्थित अपने गुरु वसिष्ठ सहित उन सभी महान द्विजों (ब्राह्मणों और ऋषियों) की अत्यंत श्रद्धापूर्वक पूजा की (सम्पूज्य) और उन्हें अत्यंत भव्य सम्मान (प्रतिमान्य च) प्रदान किया।
            उन सभी श्रेष्ठ ऋषियों का उचित रूप से सत्कार करने के बाद, राजा दशरथ ने उस समय (तदा) अत्यंत विनयपूर्वक उन सभी को अपने-अपने आश्रमों की ओर प्रस्थान करने के लिए ससम्मान विदा कर दिया (विसर्जयामास सर्वान्)।
            यह श्लोक राजा दशरथ के उस अत्यंत परिष्कृत (Refined) 'राजसी शिष्टाचार' (Royal Etiquette) को दर्शाता है जहाँ काम पूरा हो जाने के बाद भी गुरुओं और ज्ञानियों का सम्मान कम नहीं होता, बल्कि और भी अधिक बढ़ जाता है।
            'सम्पूज्य प्रतिमान्य च' (पूजा और सम्मान करके) यह प्रमाणित करता है कि राजा ने केवल आदेश देकर सभा समाप्त नहीं की; उन्होंने बाकायदा उठकर उन सभी ब्राह्मणों को यह अहसास कराया कि यह पूरा राज्य और यह राजा केवल उन्हीं के आशीर्वाद के कारण सुरक्षित है।
            प्राचीन भारत में ब्राह्मणों और ऋषियों को किसी भी राजसी कार्य का 'नैतिक कंपास' (Moral Compass) माना जाता था; दशरथ ने उन्हें विदा (विसर्जयामास) करते समय वही 'प्रोटोकॉल' (Protocol) निभाया जो साक्षात् देवताओं के लिए निभाया जाता है।
            'अवनीपतिः' (पृथ्वी का स्वामी) विशेषण यहाँ एक बहुत ही सुंदर 'कंट्रास्ट' (Contrast) पैदा करता है; जो व्यक्ति पूरी पृथ्वी का सबसे शक्तिशाली और अजेय मालिक है, वह भी उन वस्त्रहीन और वनवासी ब्राह्मणों के चरणों में पूरी तरह से झुका हुआ है; यही सनातन धर्म की सबसे बड़ी और शाश्वत सुंदरता है।
            वाल्मीकि जी यहाँ यह स्थापित कर रहे हैं कि एक शासक की महानता उसके खजाने से नहीं, बल्कि इस बात से मापी जाती है कि वह अपने समाज के 'बौद्धिक और आध्यात्मिक वर्ग' (Intellectual and Spiritual Class) का कितना अधिक सम्मान करता है।
            ऋषियों की विदाई का यह दृश्य इस बात का संकेत है कि अब 'मंत्रणा' (Planning) का वह पूरा चरण (Phase) आधिकारिक रूप से समाप्त हो चुका था; अब केवल और केवल 'कर्म' (Action) का समय शेष था।
            जब वे ऋषि दशरथ के दरबार से बाहर निकले होंगे, तो उनके हृदयों से दशरथ के लिए जो असीमित और स्वतः आशीर्वाद निकले होंगे, उन्हीं आशीर्वादों ने आगे चलकर 'राम-राज्य' की उस अभेद्य नींव को और भी अधिक मजबूत कर दिया था।
            यह श्लोक दशरथ के उस 'धार्मिक शासन' का एक ऐसा 'परफेक्ट क्लोजर' (Perfect Closure) है जो आज के आधुनिक शासकों के लिए भी एक बहुत बड़ी और प्रेरणादायक 'केस स्टडी' (Case Study) है।
        """.trimIndent(),
        englishCommentary = """
            After successfully assigning the massive tasks to His ministers (Tato), that great Lord of the Earth (Avanipatih), King Dasharatha, profoundly and highly reverently worshipped (Sampujya) and accorded the most supreme, grand honors (Pratimanya cha) to all the eminent Dvijas (Brahmins and sages), including His Guru Vashistha, who were present in that royal assembly.
            Having properly and flawlessly hosted all those superior seers, King Dasharatha then, at that exact moment (Tada), with the utmost humility, respectfully bade them all a grand farewell (Visarjayamasa sarvan), allowing them to depart gracefully toward their respective hermitages.
            This verse beautifully illustrates King Dasharatha’s highly 'Refined' and impeccable 'Royal Etiquette'; it proves that even after the primary objective is achieved, a true King's reverence for His Gurus and the wise does not diminish, but rather increases exponentially.
            'Sampujya pratimanya cha' (having worshipped and honored) certifies that the King did not merely issue cold commands and abruptly dismiss the court; He formally stood up and ensured that every single Brahmin felt deeply acknowledged, making them realize that the entire empire and the King Himself were secured exclusively through their divine blessings.
            In ancient India, Brahmins and sages were universally considered the absolute 'Moral Compass' of any royal endeavor; Dasharatha executed their farewell (Visarjayamasa) strictly adhering to the exact, high-level 'Protocol' reserved exclusively for directly worshipping the celestial gods.
            The powerful epithet 'Avanipatih' (Lord of the Earth) creates a stunning, highly profound 'Contrast' here; the very man who is the absolute most powerful, invincible master of the entire globe is seen bowing completely and humbly at the bare feet of forest-dwelling, ascetic Brahmins—this stands as the greatest, most eternal beauty of Sanatan Dharma.
            Valmiki establishes a deep truth here: a ruler's true greatness is never measured by his massive treasury or military might, but entirely by the exact depth of immense respect he accords to the 'Intellectual and Spiritual Class' of his society.
            This highly majestic scene of the sages' departure serves as the ultimate signal that the entire phase of 'Planning' (Mantrana) had now been officially and formally concluded; what remained now was absolutely nothing but hardcore, unyielding 'Action' (Karma).
            As those seers exited Dasharatha’s royal court, the limitless, spontaneous blessings that must have poured directly from their pure hearts played a massive, undeniable role in further solidifying the already impenetrable foundation of the legendary 'Ram-Rajya.'
            This verse acts as the 'Perfect Closure' to Dasharatha’s phase of 'Righteous Governance,' serving as an incredibly massive and highly inspiring 'Case Study' even for modern-day political leaders and global administrators.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 28,
        sanskrit = "गतेषु तेषु विप्रेषु मन्त्रिष्वपि नराधिपः ।\nस्वं वेश्म प्रविवेशाशु चिन्तयन् मुनिपुङ्गवम् ॥ २८ ॥\nइति वाल्मीकिरामायणे बालकाण्डे दशमः सर्गः ॥",
        hindiCommentary = """
            उन सभी महान विप्रों (विप्रेषु) के ससम्मान विदा होकर चले जाने (गतेषु तेषु) और सभी मंत्रियों (मन्त्रिष्वपि) के भी यज्ञ की अत्यंत भारी तैयारियों में लग जाने के पश्चात्, वे नराधिप (राजा दशरथ) वहाँ राजसभा में अकेले रह गए।
            तत्पश्चात, वे राजा दशरथ उन मुनिश्रेष्ठ ऋष्यशृंग (मुनिपुङ्गवम्) और अपने उस आसन्न (Impending) 'पुत्रेष्टि यज्ञ' के विषय में ही अत्यंत गहराई से चिंतन और मनन (चिन्तयन्) करते हुए, अत्यंत शीघ्रता से (आशु) अपने निजी महल (स्वं वेश्म) के भीतर प्रवेश कर गए (प्रविवेश)।
            यह श्लोक दशम सर्ग का 'अंतिम श्लोक' (Final Shloka) है, जो उस अत्यंत व्यस्त, ऐतिहासिक और 'एक्शन-पैक' (Action-packed) दिन का एक बहुत ही शांत, व्यक्तिगत (Personal) और मनोवैज्ञानिक (Psychological) समापन प्रस्तुत करता है।
            'गतेषु तेषु विप्रेषु मन्त्रिष्वपि' यह दर्शाता है कि अब दरबार पूरी तरह से खाली हो चुका था; जो लोग राजा के आदेश का पालन करने वाले थे, वे अपने-अपने 'टार्गेट' (Targets) को पूरा करने के लिए निकल चुके थे, और राजा का प्रशासनिक कार्य (Administrative Duty) उस दिन के लिए समाप्त हो चुका था।
            परंतु एक राजा या एक पिता का मस्तिष्क कभी नहीं सोता; 'चिन्तयन् मुनिपुङ्गवम्' यह सिद्ध करता है कि दशरथ के भीतर अब भी उस मुनि ऋष्यशृंग और अपने आने वाले पुत्रों के विचार अत्यंत तीव्रता से घूम रहे थे; वे उस पूरी 'रणनीति' (Strategy) का मानसिक रूप से 'रिवीजन' (Revision) कर रहे थे।
            'स्वं वेश्म प्रविवेशाशु' (अपने महल में शीघ्रता से जाना) यह बताता है कि दशरथ अब उस एकांत (Solitude) की तलाश में थे जहाँ वे बिना किसी राजसी मुखौटे (Royal Mask) के, केवल एक 'पिता' के रूप में अपनी भावनाओं को महसूस कर सकें और ईश्वर को धन्यवाद दे सकें।
            वाल्मीकि जी ने इस श्लोक में एक शासक के उस 'लोनलीनेस' (Loneliness) या 'प्राइवेट स्पेस' (Private Space) को बहुत ही सुंदरता से उकेरा है जो उसे इतनी बड़ी सफलता के बाद अनुभव होता है; जहाँ वह अपनी जीत को अपने भीतर पूरी तरह से आत्मसात (Absorb) करता है।
            इस प्रकार, वाल्मीकि रामायण के बालकाण्ड का यह अत्यंत ही महत्वपूर्ण और कूटनीतिक 'दशम सर्ग' यहाँ अपने पूर्ण गौरव, शांति और एक बहुत बड़ी आशा (Hope) के साथ समाप्त होता है।
            इस सर्ग ने उस 'पज़ल' (Puzzle) के सभी टुकड़ों (वसिष्ठ की अनुमति, रोमपाद की मित्रता, और ऋष्यशृंग की शक्ति) को एक साथ जोड़कर उस 'महायज्ञ' का एक एकदम 'परफेक्ट प्लेटफार्म' (Perfect Platform) तैयार कर दिया है।
            अब रामायण की कथा पूरी तरह से 'गियर' (Gear) बदल चुकी है; यहाँ से अब केवल उस ऐतिहासिक 'अश्वमेध यज्ञ' का वह अत्यंत भव्य और ब्रह्मांडीय (Cosmic) आयोजन होगा जो साक्षात् भगवान श्री राम के उस महान अवतरण (Incarnation) का मार्ग प्रशस्त करेगा जिसकी प्रतीक्षा पूरी सृष्टि कर रही है।
            ॥ दशम सर्ग सम्पूर्ण हुआ। जय श्री राम ॥
        """.trimIndent(),
        englishCommentary = """
            After all those great Brahmins (Vipreshu) had respectfully departed (Gateshu teshu), and even all the ministers (Mantrishvapi) had left to deeply immerse themselves in the massive preparations for the sacrifice, that ruler of men (King Dasharatha) was left alone in the royal assembly.
            Thereafter, deeply and intensely contemplating, analyzing, and meditating (Chintayan) solely upon that pre-eminent sage, Rishyashringa (Munipungavam), and the impending 'Putreshti Yajna,' King Dasharatha swiftly (Ashu) retreated and entered (Pravivesha) the absolute privacy of His own personal royal chambers (Svam veshma).
            This verse serves as the 'Final Shloka' of the Tenth Sarga, presenting an incredibly quiet, highly 'Personal,' and deeply 'Psychological' conclusion to a remarkably busy, historic, and 'Action-packed' day at the royal court.
            'Gateshu teshu vipreshu mantrishvapi' clearly indicates that the grand court was now entirely empty; the personnel designated to execute the King's commands had already dispersed to aggressively hit their respective 'Targets,' signaling that the King's active 'Administrative Duty' for the day had concluded.
            However, the hyper-active mind of a dedicated Monarch or a desperate father never truly sleeps; 'Chintayan munipungavam' conclusively proves that Dasharatha’s internal consciousness was still fiercely revolving around Sage Rishyashringa and His soon-to-be-born sons; He was essentially performing a rigorous mental 'Revision' of that entire, complex 'Strategy.'
            'Svam veshma praviveshashu' (swiftly entered his own chambers) illustrates that Dasharatha was now actively seeking that profound 'Solitude' where He could finally drop His heavy 'Royal Mask' and experience His overwhelming emotions purely as a highly grateful 'Father,' privately thanking the Supreme Lord.
            Valmiki has beautifully and accurately captured the intense 'Loneliness' or 'Private Space' of a supreme ruler here—that specific, quiet moment experienced right after orchestrating a massive success, where the leader silently and fully 'Absorbs' the sheer magnitude of His victory within His own soul.
            Thus, this incredibly crucial, highly diplomatic 'Tenth Sarga' of the Baal Kand in the Valmiki Ramayana reaches its glorious, peaceful completion right here, overflowing with an unprecedented, massive sense of 'Hope.'
            This specific Sarga has flawlessly connected all the scattered pieces of the 'Puzzle' (Vashistha's absolute permission, Romapada’s unwavering friendship, and Rishyashringa’s terrifying power) to meticulously construct an absolutely 'Perfect Platform' for the impending 'Maha-Yajna.'
            The epic narrative has now completely, violently shifted 'Gears'; from this precise point onwards, the world will witness the profoundly grand, highly 'Cosmic' execution of the historic 'Ashvamedha Yajna,' perfectly paving the unalterable path for the divine, ultimate 'Incarnation' of Lord Sri Rama, an event the entire creation has been breathlessly anticipating.
            || Thus ends the Tenth Sarga. Jai Shri Ram ||
        """.trimIndent()
    )
)