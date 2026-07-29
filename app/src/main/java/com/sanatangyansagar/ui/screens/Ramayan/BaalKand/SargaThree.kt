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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SargaThreeScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaThreeVerses
        } else {
            sargaThreeVerses.filter {
                it.id.toString().contains(searchQuery) ||
                        it.sanskrit.contains(searchQuery, ignoreCase = true) ||
                        it.hindiCommentary.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color.White)) {
                CenterAlignedTopAppBar(
                    title = {
                        Text("तृतीय सर्ग - कथा दर्शन", fontWeight = FontWeight.ExtraBold)
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
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

val sargaThreeVerses = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "श्रुत्वा वस्तु समग्रं तद्धर्मेण विदितात्मनः ।\nव्यक्तं विप्रर्षिणा तेन यदुक्तं नारदेन च ॥ १ ॥",
        hindiCommentary = """
            मुनि वाल्मीकि ने देवर्षि नारद के मुख से उस संपूर्ण कथा के सार को अत्यंत ध्यानपूर्वक सुना था।
            नारद जी ने श्री राम के चरित्र का जो खाका खींचा था, वह वाल्मीकि के मन में पूरी तरह स्पष्ट (व्यक्तं) हो चुका था।
            वे स्वयं धर्म के ज्ञाता थे और उन्होंने उस ज्ञान को अपनी आत्मा के भीतर गहराई से आत्मसात कर लिया था।
            नारद जी 'विप्रर्षि' थे, जिनकी वाणी में सत्य और दिव्यता का साक्षात् निवास था।
            वाल्मीकि जी समझ चुके थे कि यह कथा केवल एक राजा की कहानी नहीं, बल्कि जीवन जीने का दर्शन है।
            उनके मन में अब उस कथा के हर सूक्ष्म विवरण को जानने की तीव्र इच्छा जागृत हुई थी।
            ज्ञान की प्राप्ति के बाद उसका मनन और निदिध्यासन करना ऋषियों की एक अनिवार्य परंपरा रही है।
            यह श्लोक गुरु द्वारा दिए गए बीज-मंत्र की शक्ति और शिष्य की पात्रता को बहुत सुंदर ढंग से दर्शाता है।
            वाल्मीकि के भीतर अब एक ऐसी शक्ति जाग्रत हो रही थी जो समय की सीमाओं को लांघने वाली थी।
            नारद के शब्दों ने मुनि की चेतना को उस उच्च धरातल पर पहुँचा दिया था जहाँ से सत्य साक्षात् दिखता है।
            इस प्रकार, रामायण की विस्तृत रचना के लिए वैचारिक धरातल पूरी तरह तैयार हो चुका था।
        """.trimIndent(),
        englishCommentary = """
            Sage Valmiki had listened with profound attention to the entire essence of the narrative from Narada.
            The outline of Sri Rama's life provided by Narada was now vividly clear (Vyaktam) in Valmiki's mind.
            Being a knower of Dharma, he had deeply internalized that wisdom within his own soul.
            Narada, the 'Viprarshi,' possessed a speech that was the direct embodiment of Truth and Divinity.
            Valmiki realized that this was not just a king's story but a profound philosophy of human existence.
            An intense desire now arose within him to perceive every minute and hidden detail of that life.
            In the Vedic tradition, receiving knowledge is followed by deep reflection and total absorption.
            This verse illustrates the potency of the seed-wisdom given by the Guru and the eligibility of the disciple.
            A power was awakening within Valmiki that was destined to transcend the constraints of linear time.
            Narada's words had elevated the sage’s consciousness to a plane where Truth is experienced directly.
            Thus, the conceptual foundation for the expansive composition of the Ramayana was perfectly laid.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 2,
        sanskrit = "उपस्पृश्य मुनिस्तस्माद्धर्मेणान्वेषते ततः ।\nप्राञ्जलिः पूर्वमासीनः कुशेषु प्राङ्मुखस्तदा ॥ २ ॥",
        hindiCommentary = """
            मुनि वाल्मीकि ने हाथ-पैर धोकर आचमन किया और कुश के आसन पर पूर्व की ओर मुख करके बैठ गए।
            वे हाथ जोड़कर (प्राञ्जलिः) अत्यंत एकाग्रता के साथ धर्म के माध्यम से सत्य की खोज (अन्वेषते) करने लगे।
            कुश का आसन और पूर्व दिशा का चयन मानसिक शांति और आध्यात्मिक ऊर्जा प्राप्त करने के लिए किया गया था।
            मुनि की यह मुद्रा साक्षात् तपस्या का स्वरूप थी, जहाँ वे स्वयं को ब्रह्मांडीय चेतना से जोड़ रहे थे।
            उन्होंने अपनी बाहरी इंद्रियों को समेट लिया था और अंतर्दृष्टि से राम-कथा को देखना आरंभ किया।
            धर्म के मार्ग पर चलने वाला व्यक्ति ही सत्य को उसके वास्तविक स्वरूप में देखने का अधिकारी होता है।
            यह श्लोक एक महान कार्य के आरंभ से पहले की जाने वाली आत्म-अनुशासन की प्रक्रिया को दिखाता है।
            हाथ जोड़ना उनके भीतर के उस अगाध समर्पण और विनम्रता का प्रतीक था जो ज्ञान पाने के लिए आवश्यक है।
            वाल्मीकि जी अब एक ऐसी 'दिव्य-योग' की स्थिति में थे जहाँ भूत और भविष्य वर्तमान बन जाते हैं।
            उनका बैठना कोई साधारण बैठना नहीं था, बल्कि एक महाकाव्य के जन्म की आधिकारिक प्रतीक्षा थी।
            प्रकृति भी उस समय मौन थी, मानो वह भी मुनि के साथ उस महान सत्य के दर्शन करना चाहती हो।
        """.trimIndent(),
        englishCommentary = """
            After performing ritual purification, Valmiki sat on a seat of Kusha grass facing the East.
            With joined palms (Pranjalih), he began to seek the Truth (Anveshate) through the power of Dharma.
            The choice of Kusha grass and the Eastern direction was meant to maximize spiritual energy and peace.
            The sage’s posture was the embodiment of penance, as he aligned his consciousness with the Universe.
            He withdrew his external senses and began to perceive the story of Rama with his inner vision.
            Only an individual firmly established in Dharma is qualified to witness Truth in its pristine form.
            This verse demonstrates the process of self-discipline required before embarking on a monumental task.
            Joining palms symbolized the profound surrender and humility necessary for receiving higher wisdom.
            Valmiki entered a state of 'Divine Yoga' where the past and the future converge into the present.
            His sitting was not a casual act but a formal invitation for an epic to manifest within his soul.
            Even nature seemed silent, as if waiting alongside the sage to witness the unfolding of the Supreme Truth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 3,
        sanskrit = "रामलक्ष्मणसीताभिराजधान्या च भामिनीम् ।\nयच्च तेन पुरा वृत्तं रक्षसा च सुदुर्मते ॥ ३ ॥",
        hindiCommentary = """
            ध्यान में बैठे मुनि ने राम, लक्ष्मण और सीता को उनकी पूरी भव्यता के साथ साक्षात् देखा।
            उन्होंने उस राजधानी (अयोध्या) और उस दुर्मति राक्षस (रावण) द्वारा किए गए हर कृत्य को स्पष्ट देखा।
            वाल्मीकि की योग-शक्ति ने उन्हें उन घटनाओं का साक्षी बना दिया जो हजारों वर्ष पहले घटित हुई थीं।
            वे देख पा रहे थे कि कैसे राम का बचपन बीता और कैसे वे लक्ष्मण के साथ वन की ओर बढ़े।
            सीता जी की सुकुमारता और उनके महान पतिव्रत धर्म की आभा मुनि को साफ-साफ दिखाई दे रही थी।
            रावण के अहंकार और उसके द्वारा रचे गए मायावी जालों का पूरा दृश्य उनके सामने उभर आया।
            यहाँ 'भामिनीम्' शब्द सीता जी के उस तेजस्वी और गौरवमयी स्वरूप की ओर संकेत करता है।
            मुनि की दृष्टि अब किसी भी पर्दे या रुकावट की मोहताज नहीं थी, वे हर रहस्य को जान रहे थे।
            यह श्लोक सिद्ध करता है कि रामायण कोई कल्पना नहीं, बल्कि एक योगी द्वारा देखा गया सत्य है।
            पूरी कथा अब एक जीवंत चलचित्र (Cinema) की तरह मुनि के अंतर्मन के पर्दे पर चल रही थी।
            वाल्मीकि जी उस समय केवल एक दृष्टा थे, जो बिना किसी पक्षपात के सब कुछ देख रहे थे।
        """.trimIndent(),
        englishCommentary = """
            In his meditation, the sage beheld Rama, Lakshmana, and Sita in their full, divine splendor.
            He clearly witnessed the capital city of Ayodhya and every act committed by the evil demon Ravana.
            Valmiki's yogic power transformed him into a direct witness of events that had occurred long ago.
            He could see Rama’s childhood and His subsequent journey toward the forest with Lakshmana.
            The delicate grace of Sita and the brilliance of her unwavering virtue were visible to the sage.
            The monumental ego of Ravana and the intricate webs of his illusions emerged vividly before him.
            The word 'Bhaminim' points toward the radiant and dignified presence of Sita in the narrative.
            The sage’s vision was no longer bound by any veil or obstacle; he was perceiving every hidden secret.
            This verse proves that the Ramayana is not a work of fiction but a truth witnessed by a Master Yogi.
            The entire epic was now playing like a vivid motion picture on the screen of the sage's inner mind.
            At that moment, Valmiki was a pure observer, witnessing everything without any personal bias.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 4,
        sanskrit = "तत्सर्वं धर्मवीर्येण यथावत्सम्प्रपश्यति ।\nहसितं भाषितं चैव गतिर्या च यथातथम् ॥ ४ ॥",
        hindiCommentary = """
            मुनि वाल्मीकि ने धर्म की शक्ति (धर्मवीर्येण) से उन पात्रों के हँसने, बोलने और चलने को साक्षात् देखा।
            उन्होंने हर क्रिया को 'यथावत्' (बिल्कुल वैसा ही जैसा हुआ था) और 'यथातथम्' (सत्य रूप में) देखा।
            पात्रों के बीच के आपसी संवाद और उनके हाव-भाव भी मुनि की दिव्य दृष्टि से नहीं छिपे थे।
            धर्मवीर्य वह आत्मिक बल है जो मनुष्य को अज्ञान के अंधकार से निकालकर परम प्रकाश में ले आता है।
            वे देख रहे थे कि राम किस तरह मुस्कुराते थे और लक्ष्मण किस ओज के साथ अपनी बात कहते थे।
            सीता जी की वाणी की मधुरता और उनके चलने की गरिमा का मुनि ने साक्षात् अनुभव किया।
            यहाँ तक कि उनके मन में उठने वाले विचारों की तरंगों को भी वाल्मीकि जी पढ़ पा रहे थे।
            यह सूक्ष्मता ही रामायण को दुनिया का सबसे प्रभावशाली और जीवंत ग्रंथ बनाती है।
            सत्य को जैसा है वैसा ही देखना एक महान तपस्वी की सबसे बड़ी और दुर्लभ सिद्धि मानी गई है।
            मुनि की आँखों के सामने अब कोई भी घटना रहस्य नहीं रह गई थी, सब कुछ दर्पण की तरह साफ था।
            यह श्लोक रामायण की ऐतिहासिक प्रामाणिकता और उसकी भावनात्मक गहराई की पुष्टि करता है।
        """.trimIndent(),
        englishCommentary = """
            Through the power of Dharma (Dharmaviryena), Valmiki witnessed the laughter, speech, and movements of the characters.
            He observed every action 'Yathavat' (exactly as it happened) and 'Yathatatham' (in its true essence).
            The mutual dialogues and even the subtle gestures of the characters were not hidden from his divine eye.
            'Dharmavirya' is the spiritual strength that leads a man from the darkness of ignorance to ultimate light.
            He watched how Rama smiled and the vigor with which Lakshmana expressed His noble thoughts.
            The sage experienced directly the sweetness of Sita’s voice and the unparalleled dignity of her stride.
            He was even able to perceive the waves of thoughts and emotions rising within their hearts.
            This level of detail is what makes the Ramayana the most influential and living text in the world.
            To see Truth exactly as it is is considered the greatest and rarest achievement of an ascetic.
            Before the sage's eyes, no incident remained a mystery; everything was as clear as a mirror.
            This verse affirms the historical authenticity and the profound emotional depth of the Ramayana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 5,
        sanskrit = "तपोबलेन मुनिना यत्पश्यति सुव्रतः ।\nतच्चकार ततः सर्वं रामस्य चरितं महत् ॥ ५ ॥",
        hindiCommentary = """
            उस श्रेष्ठ व्रत वाले मुनि ने तपस्या के बल (तपोबलेन) से जो कुछ भी देखा, उसे काव्य का रूप देना शुरू किया।
            उन्होंने श्री राम के उस महान (महत्) और पवित्र चरित्र को शब्दों में पिरोकर रामायण की रचना की।
            तपस्या केवल शारीरिक कष्ट नहीं, बल्कि एकाग्रता की वह पराकाष्ठा है जो सत्य को मूर्त रूप देती है।
            वाल्मीकि जी ने देखा कि राम का जीवन केवल एक व्यक्ति की यात्रा नहीं, बल्कि धर्म का साक्षात् अवतार है।
            उन्होंने अपने अनुभव को लिपिबद्ध किया ताकि आने वाली पीढ़ियाँ उस महानता से लाभ उठा सकें।
            'सुव्रतः' शब्द मुनि के उन अटल नियमों और उनकी निष्ठा को दर्शाता है जिसने इस कार्य को संभव बनाया।
            लेखन की यह प्रक्रिया स्वयं में एक महान यज्ञ थी, जिसमें मुनि ने अपनी मेधा की आहुति दी थी।
            उन्होंने राम के गुणों को ऐसे शब्दों में ढाला जो स्वयं में मंत्र बन गए और आज भी पूजे जाते हैं।
            तपोबल वह ऊर्जा है जो काल के प्रभाव को रोककर प्राचीन सत्य को वर्तमान में जीवित रखती है।
            मुनि ने यह सुनिश्चित किया कि कथा का कोई भी अंश उनकी अपनी कल्पना का हिस्सा न हो।
            यह श्लोक रामायण के सृजन की उस दिव्य प्रक्रिया का समापन और ग्रंथ के आरंभ का परिचायक है।
        """.trimIndent(),
        englishCommentary = """
            The sage of noble vows, through the power of penance (Tapobalena), began to give form to what he saw.
            He wove the great (Mahat) and sacred life-story of Sri Rama into the verses of the Ramayana.
            Penance is not mere physical hardship, but the peak of concentration that renders the Truth tangible.
            Valmiki realized that Rama’s life was not just an individual journey but the personification of Dharma.
            He transcribed his transcendental experience so that future generations could benefit from that greatness.
            The term 'Suvratah' reflects the sage’s firm principles and dedication that made this monumental task possible.
            This process of writing was itself a grand sacrifice (Yajña) in which the sage offered his intellect.
            He molded Rama’s attributes into words that became mantras, revered by millions even today.
            'Tapobala' is the energy that suspends the effects of time, keeping ancient Truths alive in the present.
            The sage ensured that no part of the narrative was a product of his own mundane imagination.
            This verse marks the completion of the vision phase and the commencement of the actual composition.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 6,
        sanskrit = "तद्वर्णयितुमारेभे रामस्य चरितं मुनिः ।\nधर्मार्थकामसहितं पदैर्मुख्यैरन्वितम् ॥ ६ ॥",
        hindiCommentary = """
            मुनि वाल्मीकि ने राम के उस चरित्र का वर्णन करना आरंभ किया, जो धर्म, अर्थ और काम से परिपूर्ण था।
            उन्होंने इस महाकाव्य में मुख्य और प्रभावशाली शब्दों (पदैर्मुख्यैः) का प्रयोग किया जो हृदय को छू लेते हैं।
            रामायण का प्रत्येक श्लोक जीवन के इन तीन पुरुषार्थों—धर्म, अर्थ और काम—के बीच संतुलन सिखाता है।
            'वर्णयितुमारेभे' शब्द एक ऐसी यात्रा की शुरुआत है जिसने विश्व साहित्य के इतिहास को हमेशा के लिए बदल दिया।
            मुनि ने देखा कि राम ने कैसे अपने राज्य (अर्थ) और सुखों (काम) का धर्म के लिए सहर्ष त्याग किया।
            भाषा इतनी सरल और गहन थी कि वह विद्वानों और साधारण जनों—दोनों के लिए समान रूप से कल्याणकारी थी।
            पदों की मुख्यता का अर्थ है कि हर शब्द का एक निश्चित और गहरा आध्यात्मिक महत्व था।
            यह कथा मनुष्य को सिखाती है कि संसार में रहते हुए भी आध्यात्मिक ऊंचाइयों को कैसे छुआ जा सकता है।
            वाल्मीकि जी की शैली में वह ओज और माधुर्य था जो केवल एक सिद्ध ऋषि की वाणी में ही संभव है।
            उन्होंने राम के जीवन को एक ऐसे आदर्श के रूप में प्रस्तुत किया जो हर काल और परिस्थिति में प्रासंगिक है।
            यह श्लोक रामायण की साहित्यिक उत्कृष्टता और उसकी वैचारिक व्यापकता का साक्षात् प्रमाण है।
        """.trimIndent(),
        englishCommentary = """
            Sage Valmiki began to describe the character of Rama, which encompassed Dharma, Artha, and Kama.
            He employed significant and powerful words (Padairmukhyaiah) in this epic that touch the very core of the heart.
            Every verse of the Ramayana teaches the delicate balance between the three goals of life: Duty, Wealth, and Desire.
            The phrase 'Varnayitumarebhe' marks the start of a journey that altered the course of world literature forever.
            The sage saw how Rama gladly sacrificed His kingdom (Artha) and comforts (Kama) for the sake of Duty (Dharma).
            The language was so simple yet profound that it remained beneficial for both the learned and the common folk.
            The significance of the words implies that every syllable carried a precise and deep spiritual weight.
            This narrative teaches humans how to attain spiritual heights while living amidst the material world.
            Valmiki’s style possessed the vigor and sweetness possible only in the speech of a realized master.
            He presented Rama’s life as a standard that remains relevant across all eras and circumstances.
            This verse is a direct testament to the literary excellence and the philosophical vastness of the Ramayana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 7,
        sanskrit = "यथावदुक्तं नारदेन तत्सर्वं धर्मविद्विभुः ।\nपश्यति स्म तपोवीर्यात्ततः सर्वं यथातथम् ॥ ७ ॥",
        hindiCommentary = """
            धर्म के ज्ञाता और समर्थ मुनि वाल्मीकि ने नारद द्वारा कहे गए उस संपूर्ण वृत्तांत को साक्षात् देखा।
            अपनी तपस्या की शक्ति (तपोवीर्यात्) से उन्होंने सब कुछ 'यथातथम्' (बिल्कुल वैसा ही जैसा हुआ था) देखा।
            नारद के शब्द अब उनके लिए केवल ध्वनियाँ नहीं थीं, बल्कि आँखों के सामने घटित होने वाले जीवंत सत्य थे।
            'विभुः' शब्द मुनि की उस सामर्थ्य को बताता है जिसने उन्हें एक दिव्य दृष्टा की श्रेणी में खड़ा कर दिया।
            वे देख रहे थे कि कैसे विश्वामित्र आए और कैसे राम ने ताड़का का वध किया, जो नारद ने संक्षेप में बताया था।
            तपोवीर्य वह आध्यात्मिक पराक्रम है जो माया के आवरण को हटाकर वास्तविकता को प्रकट कर देता है।
            वाल्मीकि जी ने महसूस किया कि नारद जी की एक-एक बात सत्य की कसौटी पर पूरी तरह खरी उतर रही थी।
            योग की इस अवस्था में व्यक्ति काल और स्थान (Time and Space) के बंधनों से पूरी तरह मुक्त हो जाता है।
            उन्होंने उन स्थानों की गंध, हवा का स्पर्श और पात्रों के हृदय की धड़कन तक को अनुभव किया।
            यह श्लोक सिद्ध करता है कि रामायण की रचना में कोई भी अंश मुनि की कल्पना या अनुमान पर आधारित नहीं था।
            सत्य का ऐसा प्रत्यक्ष साक्षात्कार ही एक ऋषि को 'कवि' और उसकी वाणी को 'आर्ष-काव्य' बनाता है।
        """.trimIndent(),
        englishCommentary = """
            The wise and capable Valmiki witnessed exactly what had been narrated by the divine sage Narada.
            Through the potency of his penance (Tapoviryat), he saw everything 'Yathatatham' (precisely as it was).
            Narada’s words were no longer mere sounds to him but became living truths manifesting before his eyes.
            The word 'Vibhuh' highlights the sage’s divine capability that placed him in the rank of a celestial seer.
            He watched Vishwamitra’s arrival and the slaying of Tadaka, events Narada had briefly summarized earlier.
            'Tapovirya' is the spiritual prowess that removes the veil of illusion to reveal the ultimate reality.
            Valmiki realized that every single detail provided by Narada was perfectly anchored in absolute fact.
            In this state of Yoga, an individual becomes entirely free from the limitations of Time and Space.
            He experienced the scents of those locations, the touch of the breeze, and the heartbeats of the characters.
            This verse proves that no part of the Ramayana was based on the sage’s imagination or mere conjecture.
            Such a direct realization of Truth transforms a seer into a 'Poet' and his speech into 'Arsha-Kavya.'
        """.trimIndent()
    ),
    RamayanVerse(
        id = 8,
        sanskrit = "रामो रामो राम इति ह्यन्वब्रवीत्सदा ।\nअवाप मुनिराहादं दृष्ट्वा तच्चरितं महत् ॥ ८ ॥",
        hindiCommentary = """
            मुनि वाल्मीकि निरंतर 'राम राम राम' इस महामंत्र का मानसिक जाप करते हुए उस कथा में लीन थे।
            राम के उस महान (महत्) चरित्र को साक्षात् देखकर मुनि ने एक अलौकिक 'आह्लाद' (परम आनंद) प्राप्त किया।
            नाम का जाप करना उनके मन को स्थिर और उनकी दिव्य दृष्टि को और अधिक तीव्र बना रहा था।
            भगवान राम का चरित्र इतना पावन था कि उसे देखते हुए मुनि के हृदय के सारे क्लेश मिट गए थे।
            'आह्लाद' वह सुख है जो इंद्रियों से नहीं, बल्कि आत्मा के सीधे परमात्मा से जुड़ने पर प्राप्त होता है।
            वाल्मीकि जी ने अनुभव किया कि राम का जीवन स्वयं में एक अनंत शांति और मंगल का स्रोत है।
            वे उस कथा के समुद्र में इतने डूब गए थे कि उन्हें स्वयं के अस्तित्व का भी अब होश नहीं रहा था।
            यही वह आनंद है जिसे पीकर उन्होंने रामायण के श्लोकों में वह रस भरा जो आज भी पाठकों को तृप्त करता है।
            मुनि का बार-बार 'राम' कहना यह सिद्ध करता है कि वे अब राम-मय हो चुके थे, यानी दृष्टा और दृश्य एक हो गए थे।
            यह श्लोक भक्ति और सृजन के उस चरम आनंद का वर्णन करता है जो केवल संतों को ही सुलभ है।
            राम का चरित्र उनके लिए अब केवल एक विषय नहीं, बल्कि उनके जीवन का परम सत्य बन चुका था।
        """.trimIndent(),
        englishCommentary = """
            Sage Valmiki was absorbed in the story, constantly repeating the great mantra 'Rama Rama Rama.'
            Witnessing that great (Mahat) life-story of Rama, the sage experienced a supernatural bliss (Ahlada).
            Chanting the Name kept his mind steady and sharpened his divine vision to an extraordinary degree.
            The character of Lord Rama was so sacred that beholding it dissolved all the afflictions of the sage’s heart.
            'Ahlada' is the joy that originates not from the senses but from the direct communion of the soul with the Divine.
            Valmiki realized that Rama’s life was an infinite fountain of peace and auspiciousness for the world.
            He was so deeply immersed in the ocean of that narrative that he lost consciousness of his own ego.
            This is the very bliss he infused into the verses of the Ramayana, which continues to satisfy readers today.
            Repeating 'Rama' proves that he had become Rama-merged, where the observer and the observed became one.
            This verse describes the peak of devotion and creative bliss that is accessible only to realized saints.
            Rama’s character was no longer just a subject for him; it had become the ultimate truth of his existence.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 9,
        sanskrit = "जन्म रामस्य सुमहद्वीर्यं सर्वानुकूलताम् ।\nलोकाभिरामतां शान्तिं सत्यं प्रियहितं वचः ॥ ९ ॥",
        hindiCommentary = """
            मुनि ने राम के जन्म, उनके महान पराक्रम (वीर्यं) और उनकी सबके प्रति अनुकूलता के दर्शन किए।
            उन्होंने देखा कि कैसे राम पूरे लोक के लिए आनंददायक (लोकाभिरामता) और शांति के प्रतीक थे।
            राम के 'सत्य' और उनके अत्यंत प्रिय व हितकारी वचनों (प्रियहितं वचः) को भी मुनि ने साक्षात् सुना।
            राम का जन्म कोई साधारण घटना नहीं थी, बल्कि धर्म के सूर्य का उदय था जिसने संसार का अंधकार मिटाया।
            उनकी वीरता में कभी अहंकार नहीं था, बल्कि वह केवल सत्य और न्याय की रक्षा के लिए समर्पित थी।
            सर्वानुकूलता का अर्थ है—राम का व्यवहार हर व्यक्ति के साथ उसके स्वभाव के अनुसार अत्यंत श्रेष्ठ था।
            लोकाभिरामता सिद्ध करती है कि उनके दर्शन मात्र से ही हर दुखी हृदय को परम शीतलता प्राप्त होती थी।
            उनकी शांति हिमालय के समान अडिग थी, जिसे कोई भी संकट या अपमान विचलित नहीं कर सकता था।
            सत्य उनके जीवन का प्राण था और उनकी वाणी हमेशा दूसरों का भला चाहने वाली (हितकारी) होती थी।
            नारद जी ने जो संक्षेप में बताया था, मुनि अब उसके हर सूक्ष्म और गहरे पहलू का साक्षात्कार कर रहे थे।
            यह श्लोक राम के व्यक्तित्व के उन बुनियादी स्तंभों का वर्णन करता है जो उन्हें 'मर्यादा पुरुषोत्तम' बनाते हैं।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed Rama’s birth, His immense prowess (Viryam), and His universal benevolence.
            He saw how Rama was a source of delight (Lokabhiramata) for the entire world and a symbol of peace.
            Valmiki also directly heard Rama's commitment to Truth and His extremely sweet and beneficial speech.
            Rama's birth was not an ordinary event but the rise of the Sun of Dharma that dispelled global darkness.
            His valor was never tainted by ego; it was dedicated solely to the preservation of Truth and Justice.
            'Sarvanukulata' implies that Rama’s conduct was perfectly attuned to the nature and needs of everyone He met.
            Being 'Lokabhirama' proves that His mere presence provided supreme comfort to every distressed heart.
            His peace was as unshakable as the Himalayas, undisturbed by any crisis, insult, or trial.
            Truth was the very breath of His life, and His speech was always intended for the welfare (Hitakari) of others.
            Valmiki was now realizing every subtle and profound dimension of what Narada had briefly summarized.
            This verse describes the fundamental pillars of Rama’s persona that establish Him as 'Maryada Purushottama.'
        """.trimIndent()
    ),
    RamayanVerse(
        id = 10,
        sanskrit = "विश्वामित्रस्य चागमनं तथैवाश्रमवासिनाम् ।\nधनुर्भङ्गं च रामस्य विवाहं च सुसंस्कृतम् ॥ १० ॥",
        hindiCommentary = """
            मुनि ने विश्वामित्र का आगमन, आश्रम में रहने वाले ऋषियों का भय और राम द्वारा धनुष का भंग होना देखा।
            उन्होंने राम और सीता के उस अत्यंत सुसंस्कृत और पावन विवाह के दृश्य का भी साक्षात् अनुभव किया।
            विश्वामित्र के साथ राम की वह यात्रा उनके शौर्य के प्रथम सार्वजनिक प्रकटीकरण का क्षण थी।
            आश्रमवासियों की सुरक्षा के लिए राम का वहां जाना उनके 'रक्षक' स्वरूप की पहली बड़ी परीक्षा थी।
            शिव धनुष का टूटना केवल एक पराक्रम नहीं था, बल्कि वह पुराने जड़ तंत्र के अंत और नए धर्म के उदय का संकेत था।
            विवाह का सुसंस्कृत होना यह बताता है कि रघुकुल और जनकपुर के बीच संस्कारों का कितना गहरा मिलन था।
            वाल्मीकि जी ने उन मंत्रों की गूँज और उस पवित्र अग्नि की ऊष्मा को महसूस किया जो उस विवाह में साक्षी थी।
            वे देख रहे थे कि कैसे मर्यादा का पालन करते हुए राम ने समाज के सर्वोच्च पद को प्राप्त किया।
            सीता और राम का यह गठबंधन ब्रह्मांडीय शक्तियों के एकीकरण का एक महान उत्सव था।
            मुनि की दृष्टि में अब वह पूरा उत्सव जीवंत हो उठा था, जैसे वे स्वयं उस कालखंड में उपस्थित हों।
            यह श्लोक रामायण के उन प्रारंभिक और महत्वपूर्ण मोड़ों का वर्णन करता है जहाँ से कथा गति पकड़ती है।
        """.trimIndent(),
        englishCommentary = """
            The sage saw Vishwamitra’s arrival, the fear of the forest-dwellers, and the breaking of the bow by Rama.
            He also directly experienced the scene of the highly cultured and sacred marriage of Rama and Sita.
            Rama’s journey with Vishwamitra was the moment of the first public manifestation of His supreme prowess.
            Going there to protect the hermits was the first major test of His role as the divine Guardian.
            Breaking Shiva's bow was not just a feat of strength; it symbolized the end of an old order and the rise of Dharma.
            The 'Susamskritam' (highly cultured) nature of the wedding highlights the deep union of values between the two clans.
            Valmiki felt the resonance of the mantras and the heat of the sacred fire that bore witness to that union.
            He watched how Rama attained the highest social status while strictly adhering to the bounds of propriety.
            The alliance of Sita and Rama was a grand celebration of the unification of cosmic spiritual forces.
            The entire festivity became vivid in the sage’s vision, as if he were personally present in that era.
            This verse describes the early and pivotal turning points of the epic where the narrative gains momentum.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 11,
        sanskrit = "विवादं च परैः सार्धं गुणं रामस्य च प्रभुः ।\nयौवराज्यमभिषेकं च कैकेय्याश्चापि दुष्टताम् ॥ ११ ॥",
        hindiCommentary = """
            समर्थ मुनि ने दूसरों के साथ राम के विवाद (जैसे परशुराम संवाद) और उनके दिव्य गुणों को स्पष्ट देखा।
            उन्होंने राम के युवराज पद के अभिषेक की तैयारियाँ और रानी कैकेयी की उस 'दुष्टता' (कुटिलता) को भी देखा।
            परशुराम के साथ विवाद में भी राम की विनम्रता और उनके तेज का जो संतुलन था, उसे मुनि ने गहराई से समझा।
            अभिषेक की खुशियों के बीच अचानक कैकेयी का हृदय परिवर्तन होना नियति के एक कठोर खेल का हिस्सा था।
            कैकेयी की कुटिलता वास्तव में मंथरा के वचनों और देवताओं की योजना का एक मिश्रित परिणाम थी।
            वाल्मीकि जी ने उन आंसुओं और उस सन्नाटे को देखा जो अयोध्या के महलों में उस रात छा गया था।
            राम का 'प्रभु' स्वरूप वहाँ भी अडिग था, जहाँ वे राजपद के छिनने पर भी बिल्कुल शांत और स्थिर थे।
            यह श्लोक सुख और दुख के उन विपरीत ध्रुवों को दिखाता है जो राम के जीवन में एक साथ घटित हुए।
            मुनि देख रहे थे कि कैसे एक पल में पूरा साम्राज्य उत्सव के माहौल से शोक के सागर में डूब गया।
            कैकेयी के उन कठोर वचनों की ध्वनि आज भी मुनि के कानों में गूँज रही थी, जो उन्होंने ध्यान में सुनी।
            यहाँ से राम के 'त्याग' की वह महान गाथा शुरू होती है जो उन्हें ईश्वर के सिंहासन तक ले जाने वाली थी।
        """.trimIndent(),
        englishCommentary = """
            The capable sage witnessed Rama’s confrontation with others (like Parashurama) and His divine attributes.
            He saw the preparations for the coronation as Prince Regent and the 'wickedness' (guile) of Queen Kaikeyi.
            In the conflict with Parashurama, Valmiki deeply understood the balance between Rama’s humility and His radiance.
            The sudden change in Kaikeyi's heart amidst the coronation joy was part of a harsh play of destiny.
            Kaikeyi's guile was, in reality, a combined result of Manthara’s poison and the broader plan of the gods.
            Valmiki saw the tears and the heavy silence that descended upon the palaces of Ayodhya that night.
            Rama’s status as 'Prabhu' (Lord) remained steady even when His rightful throne was taken from Him.
            This verse illustrates the polar opposites of joy and sorrow that occurred simultaneously in Rama’s life.
            The sage watched how, in an instant, an entire empire plunged from celebration into an ocean of grief.
            The resonance of Kaikeyi’s harsh words, heard in his meditation, still echoed in the sage’s spiritual ears.
            From here begins the grand saga of Rama’s 'Sacrifice' that was destined to lead Him to the throne of God.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 12,
        sanskrit = "विघातं चाभिषेकस्य रामस्य च विवासनम् ।\nराज्ञः शोकं विलापं च परलोकगतिं तथा ॥ १२ ॥",
        hindiCommentary = """
            मुनि ने अभिषेक में पड़ा विघ्न, राम का वनवास (विवासनम्) और राजा दशरथ के असहनीय शोक को देखा।
            उन्होंने दशरथ के उस करुण विलाप और अंततः उनकी मृत्यु (परलोकगतिं) के दृश्य का भी साक्षात्कार किया।
            अभिषेक का रुकना केवल एक राजनीतिक घटना नहीं, बल्कि धर्म की एक बहुत बड़ी अग्नि-परीक्षा की शुरुआत थी।
            राम का वन जाना अयोध्या की आत्मा का शरीर छोड़कर चले जाने जैसा था, जिसे मुनि ने साक्षात् अनुभव किया।
            दशरथ का शोक एक पिता की लाचारी और सत्य के प्रति उनकी निष्ठा के बीच का एक भयंकर द्वंद्व था।
            विलाप की वे ध्वनियाँ आज भी वाल्मीकि के हृदय को झकझोर रही थीं, क्योंकि वे उसे साक्षात् देख रहे थे।
            राजा की मृत्यु रघुकुल के इतिहास का सबसे दुखद पन्ना था, जिसने पूरी प्रजा को अनाथ कर दिया था।
            वाल्मीकि जी ने देखा कि कैसे राम ने अपने पिता के वचनों की रक्षा के लिए अपने सारे सुखों की आहुति दे दी।
            सत्य की रक्षा के लिए इतना बड़ा मूल्य चुकाना केवल राम जैसे महामानव के लिए ही संभव था।
            यह श्लोक रामायण की उस गहरी करुणा और विछोह (Separation) का मर्मस्पर्शी चित्रण करता है।
            मुनि की आँखों के सामने अब वह पूरी त्रासदी एक बार फिर से जीवंत हो चुकी थी।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the interruption of the coronation, Rama’s exile (Vivasanam), and the King’s agony.
            He also perceived Dasharatha’s piteous lamentation and his eventual departure to the other world.
            The halting of the coronation was not just a political event but the start of a massive trial for Dharma.
            Rama leaving for the forest was akin to the soul of Ayodhya departing its body, as experienced by the sage.
            Dasharatha’s grief was a terrifying conflict between a father’s helplessness and his commitment to Truth.
            The sounds of that lamentation still shook Valmiki’s heart as he witnessed it directly in his vision.
            The King’s death was the saddest chapter in the history of the Solar clan, leaving the subjects orphaned.
            Valmiki saw how Rama sacrificed all His comforts to protect the sanctity of His father’s promised words.
            Paying such a high price for the sake of Truth was possible only for a supreme being like Rama.
            This verse provides a touching depiction of the deep pathos and separation that define the Ramayana.
            The entire tragedy was now manifesting vividly once again before the spiritual eyes of the sage.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 13,
        sanskrit = "प्रकृतीनां विषादं च विसर्जनं तथा जनैः ।\nनिषादाधिपतिं चैव सूतं च विनिवर्तितम् ॥ १३ ॥",
        hindiCommentary = """
            मुनि ने प्रजा का अपार दुख (विषादं) और राम द्वारा लोगों को वापस अयोध्या भेजने के दृश्य को देखा।
            उन्होंने निषादराज गुह से मिलन और सारथी सुमंत्र के खाली रथ के साथ वापस लौटने का भी अनुभव किया।
            प्रजा का राम के पीछे वन तक चले जाना यह सिद्ध करता था कि राम केवल राजा नहीं, बल्कि उनके प्राण थे।
            लोगों को समझा-बुझाकर वापस भेजना राम के संयम और उनके दृढ़ संकल्प का एक अनूठा उदाहरण था।
            निषादराज के साथ उनकी मित्रता ने यह संदेश दिया कि राम के लिए प्रेम ही सबसे बड़ा नाता है।
            सुमंत्र का खाली रथ लेकर लौटना अयोध्या के लिए एक ऐसा शोक था जिसकी कोई सीमा नहीं थी।
            वाल्मीकि जी ने देखा कि कैसे राम ने गंगा पार की और राजसी जीवन को हमेशा के लिए पीछे छोड़ दिया।
            वह विषाद केवल मनुष्यों का नहीं, बल्कि अयोध्या के पशु-पक्षियों और जड़ प्रकृति का भी था।
            राम की इस यात्रा ने समाज के हर वर्ग को एक सूत्र में पिरोना शुरू कर दिया था।
            मुनि देख रहे थे कि कैसे एक राजकुमार अब धीरे-धीरे एक 'तपस्वी' के रूप में परिवर्तित हो रहा था।
            यह श्लोक राम के लोक-संग्रह और उनके त्याग के उस भावुक विस्तार को बहुत स्पष्टता से दर्शाता है।
        """.trimIndent(),
        englishCommentary = """
            The sage saw the immense despair of the subjects and the scene of Rama sending the people back to Ayodhya.
            He also experienced the meeting with the Nishada chief Guha and the return of the charioteer with an empty chariot.
            The subjects following Rama into the woods proved that He was not just their king but their very life-breath.
            Persuading and sending the people back was a unique example of Rama’s self-restraint and firm resolve.
            His friendship with the Nishada chief conveyed the message that for Rama, love is the ultimate kinship.
            Sumantra returning with the empty chariot was a sorrow for Ayodhya that knew no bounds.
            Valmiki watched how Rama crossed the Ganges, leaving His royal life behind forever.
            That despair was shared not just by humans but by the animals and the very landscape of Ayodhya.
            This journey of Rama had already begun to weave every section of society into a single thread.
            The sage observed how a prince was gradually and gracefully transforming into a forest-ascetic.
            This verse clearly illustrates the emotional expanse of Rama’s outreach and His monumental sacrifice.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 14,
        sanskrit = "गङ्गायास्तरणं चैव भरद्वाजस्य दर्शनम् ।\nभरद्वाजवचनाच्च चित्रकूटस्य दर्शनम् ॥ १४ ॥",
        hindiCommentary = """
            मुनि ने गंगा नदी को पार करने, महर्षि भरद्वाज के दर्शन और उनके कहने पर चित्रकूट जाने का दृश्य देखा।
            गंगा का तट वह सीमा थी जहाँ से राम का असली वनवासी जीवन और ऋषियों का सान्निध्य शुरू हुआ।
            भरद्वाज मुनि का राम का स्वागत करना यह दर्शाता था कि तपस्वी समाज उनके अवतार को पहचान चुका था।
            भरद्वाज के वचनों ने राम को वह मार्ग दिखाया जो शांति और सुरक्षा के लिए सबसे उपयुक्त था।
            चित्रकूट का दर्शन मुनि के लिए अत्यंत सुखद था, क्योंकि वहाँ राम ने अपनी साधना का केंद्र बनाया था।
            वाल्मीकि जी ने देखा कि कैसे प्रकृति ने राम के स्वागत में अपने श्रेष्ठतम सौंदर्य को बिखेर दिया था।
            ऋषि और राजकुमार के बीच का वह संवाद धर्म और ज्ञान के सुंदर समन्वय का एक अनुपम उदाहरण था।
            गंगा को पार करना वास्तव में सांसारिक बंधनों को पार करने का एक बहुत बड़ा आध्यात्मिक संकेत था।
            चित्रकूट की उन पहाड़ियों और लताओं का मुनि ने साक्षात् अनुभव किया जहाँ राम विचरण करते थे।
            यह श्लोक राम की यात्रा के उस 'शांत' और 'आध्यात्मिक' चरण का वर्णन करता है जो संघर्ष से पहले का था।
            मुनि की दृष्टि अब उन स्थानों को पवित्रता के साथ देख रही थी जो आज भी तीर्थ के रूप में पूजे जाते हैं।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the crossing of the Ganges, the meeting with Sage Bharadwaja, and the visit to Chitrakoota.
            The banks of the Ganges served as the boundary where Rama’s true ascetic life and association with seers began.
            Sage Bharadwaja welcoming Rama demonstrated that the ascetic community had recognized His divine descent.
            Bharadwaja’s advice showed Rama the path that was most suitable for His peace and safety.
            The sight of Chitrakoota was delightful to the sage, for Rama established the center of His spiritual practice there.
            Valmiki watched how nature had unfolded its finest beauty to welcome Lord Rama into the wilderness.
            The dialogue between the sage and the prince was a peerless example of the harmony between Dharma and Wisdom.
            Crossing the Ganges was, in reality, a profound spiritual metaphor for transcending worldly attachments.
            The sage experienced directly the hills and creepers of Chitrakoota where Rama used to wander.
            This verse describes the 'peaceful' and 'spiritual' phase of Rama’s journey that preceded the major conflicts.
            The sage’s vision was now observing with sanctity the locations that are worshiped as pilgrimage sites today.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 15,
        sanskrit = "आश्रमस्य च निर्माणं भरतस्यागमनं तथा ।\nप्रसादनं च रामस्य पितुश्च सलिलक्रियाम् ॥ १५ ॥",
        hindiCommentary = """
            मुनि ने चित्रकूट में पर्णकुटी (आश्रम) का निर्माण और वहाँ भरत के व्याकुल होकर आने का दृश्य देखा।
            उन्होंने भरत द्वारा राम को मनाने (प्रसादनं) और राम द्वारा पिता के लिए 'तर्पण' (सलिलक्रियाम्) करने को देखा।
            कुटिया का निर्माण लक्ष्मण के सेवा-भाव और उनकी कलात्मकता का एक बहुत ही सुंदर प्रमाण था।
            भरत का आगमन अयोध्या के पश्चाताप और रघुकुल की श्रेष्ठ परंपराओं का एक शिखर क्षण था।
            राम द्वारा पिता की सलिलक्रिया (जल देना) यह दर्शाती थी कि वे वन में रहकर भी अपने पुत्र-धर्म को नहीं भूले।
            भरत की उन प्रार्थनाओं को मुनि ने सुना जिनमें वे राम को वापस लौटने के लिए बार-बार विनती कर रहे थे।
            वह मिलन प्रेम और कर्तव्य के बीच के एक महान युद्ध जैसा था, जहाँ अंततः सत्य की विजय हुई।
            वाल्मीकि जी ने देखा कि कैसे राम ने अपनी पादुकाएं देकर भरत के हृदय की पीड़ा को शांत किया।
            चित्रकूट का वह दृश्य करुण और वीर रस के एक अद्भुत संगम जैसा था, जिसे मुनि जी रहे थे।
            यह श्लोक पारिवारिक एकता और धर्म के प्रति अटूट निष्ठा का एक वैश्विक पाठ पढ़ाता है।
            मुनि की आँखों के सामने अब वह पूरी भावुक लहर चल रही थी जिसने अयोध्या के इतिहास को दिशा दी।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the construction of the hermitage and Bharata’s arrival there in a state of distress.
            He saw Bharata’s attempt to persuade Rama (Prasadanam) and Rama performing the libations (Salilakriyam) for His father.
            The building of the hut was a beautiful testimony to Lakshmana’s spirit of service and His artistic skill.
            Bharata’s arrival represented the peak of Ayodhya’s repentance and the superior traditions of the Solar clan.
            Rama performing the libations for His father showed that He never forgot His filial duty even in the wild.
            The sage heard Bharata’s prayers as he repeatedly begged Rama to return and assume the throne.
            That meeting was like a grand battle between love and duty, where eventually, Truth emerged victorious.
            Valmiki saw how Rama calmed the agony of Bharata’s heart by bestowing His sacred sandals (Padukas).
            The scene at Chitrakoota was a marvelous confluence of pathos and heroism, experienced fully by the sage.
            This verse teaches a universal lesson in familial unity and unbreakable commitment to Dharma.
            The entire emotional wave that shaped Ayodhya’s history was now playing vividly before the sage’s eyes.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 16,
        sanskrit = "पादुकाग्र्यमभिषेकं च नन्दिग्रामे निवासनम् ।\nदण्डकारण्यगमनं विराधस्य वधं तथा ॥ १६ ॥",
        hindiCommentary = """
            मुनि ने पादुकाओं के अभिषेक, भरत के नन्दिग्राम में निवास और राम के दण्डकारण्य प्रवेश को देखा।
            उन्होंने वीर राघव द्वारा विशालकाय राक्षस 'विराध' के वध के उस भयानक और अजेय युद्ध का भी अनुभव किया।
            पादुकाओं का राजा बनना विश्व के राजनीतिक इतिहास की एक सबसे अनोखी और आध्यात्मिक घटना थी।
            भरत का नन्दिग्राम में एक तपस्वी की तरह रहना राम के वनवास के समानांतर एक महान तपस्या थी।
            दण्डकारण्य में प्रवेश करना राम के अवतार-कार्य के सबसे सक्रिय और संघर्षपूर्ण चरण की शुरुआत थी।
            विराध का वध यह संकेत था कि अब अधर्म की शक्तियों के विनाश का समय पूरी तरह से आ चुका है।
            वाल्मीकि जी ने उन राक्षसों के आतंक और ऋषियों की पीड़ा को अपनी अंतरात्मा में साक्षात् महसूस किया।
            वे देख रहे थे कि कैसे राम के बाण राक्षसी माया को छिन्न-भिन्न कर रहे थे और शांति ला रहे थे।
            नन्दिग्राम की वह सादगी और दण्डकारण्य की वह भयंकरता—दोनों मुनि की दृष्टि में एक साथ थीं।
            यह श्लोक रक्षक के रूप में राम के उत्तरदायित्व और भक्त के रूप में भरत के त्याग को एक साथ पिरोता है।
            मुनि की लेखनी अब उन वीर गाथाओं को शब्द देने के लिए पूरी तरह से प्रज्वलित हो चुकी थी।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the consecration of the sandals, Bharata’s stay in Nandigrama, and Rama’s entry into Dandaka.
            He also experienced the terrifying and invincible battle where the heroic Rama slew the giant demon Viradha.
            The sandals assuming sovereignty was one of the most unique and spiritual events in world political history.
            Bharata living like an ascetic in Nandigrama was a monumental penance parallel to Rama’s own exile.
            Entering the Dandaka forest marked the start of the most active and combative phase of Rama’s divine mission.
            The slaying of Viradha was a signal that the time for the annihilation of dark forces had fully arrived.
            Valmiki personally felt the terror of the demons and the agony of the sages within his own inner being.
            He watched how Rama’s arrows dismantled demonic illusions and restored the prevailing peace.
            The simplicity of Nandigrama and the ferocity of Dandaka—both existed simultaneously in the sage’s vision.
            This verse weaves together Rama’s responsibility as a savior and Bharata’s sacrifice as a supreme devotee.
            The sage’s creative energy was now fully ignited to give voice to these heroic and transcendental tales.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 17,
        sanskrit = "शरभङ्गस्य दर्शनं सुतीक्ष्णस्य च दर्शनम् ।\nअनसूयासमागमनं अङ्गरागार्पणं तथा ॥ १७ ॥",
        hindiCommentary = """
            मुनि ने शरभङ्ग और सुतीक्ष्ण जैसे महान ऋषियों के दर्शन और माता अनसूया से सीता के मिलन को देखा।
            उन्होंने अनसूया द्वारा सीता को दिव्य 'अङ्गराग' (सौंदर्य लेप) भेंट करने के उस पावन दृश्य का अनुभव किया।
            ऋषियों का राम को देखकर आनंदित होना यह सिद्ध करता था कि वे उस परमात्मा के साक्षात् सान्निध्य में थे।
            अनसूया और सीता का संवाद नारी-धर्म और पतिव्रत की शिक्षा का एक अत्यंत उज्ज्वल और दिव्य अध्याय था।
            दिव्य अङ्गराग का मिलना यह संकेत था कि सीता की आभा वन के कष्टों में भी कभी फीकी नहीं पड़ेगी।
            वाल्मीकि जी ने देखा कि कैसे राम ने अपनी पत्नी को ऋषियों की पत्नियों के बीच गौरवान्वित महसूस कराया।
            उन आश्रमों की शांति और वहाँ के मृगों की निश्छलता मुनि के हृदय को परम शीतलता दे रही थी।
            राम की यह यात्रा वास्तव में भारतीय संस्कृति के आध्यात्मिक वैभव को एक सूत्र में बांधने की यात्रा थी।
            मुनि देख रहे थे कि कैसे ऋषि-मुनि अपनी सिद्धियों को राम के चरणों में अर्पित करने के लिए व्याकुल थे।
            यह श्लोक भक्ति, आशीर्वाद और दिव्य संबंधों के उस कोमल पक्ष को बहुत सुंदरता से उजागर करता है।
            आर्ष-काव्य की रचना के लिए मुनि को इन सूक्ष्म मानवीय संवेदनाओं का ज्ञान होना अत्यंत आवश्यक था।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the meetings with seers like Sarabhanga and Sutikshna and Sita’s encounter with Anasuya.
            He experienced the sacred scene of Anasuya gifting the divine 'Angaraga' (cosmetic unguent) to Sita.
            The joy of the sages upon beholding Rama proved that they were in the direct presence of the Supreme Being.
            The dialogue between Anasuya and Sita was a bright and divine chapter in the teachings of womanly duty.
            Receiving the divine unguent signified that Sita’s radiance would never fade, even amidst the forest trials.
            Valmiki saw how Rama ensured His wife felt honored and cherished among the consorts of the great sages.
            The tranquility of those hermitages and the innocence of the resident deer provided the sage with peace.
            Rama’s journey was, in reality, an odyssey intended to unify the spiritual grandeur of Indian culture.
            The sage watched how the seers were eager to offer their spiritual achievements at the feet of Lord Rama.
            This verse beautifully highlights the gentle aspects of devotion, blessings, and divine relationships.
            Knowledge of these subtle human sensitivities was essential for the sage to compose the sacred epic.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 18,
        sanskrit = "दर्शनं चाप्यगस्त्यस्य धनुषो ग्रहणं तथा ।\nशूर्पणख्याश्च संवादं विरूपकरणं तथा ॥ १८ ॥",
        hindiCommentary = """
            मुनि ने अगस्त्य मुनि के दर्शन, उनसे दिव्य धनुष ग्रहण करने और शूर्पणखा के साथ हुए संवाद को देखा।
            उन्होंने लक्ष्मण द्वारा उस राक्षसी को विरूपित (नाक-कान काटना) करने के उस निर्णायक दृश्य का अनुभव किया।
            अगस्त्य जी द्वारा अस्त्र-शस्त्र देना यह संकेत था कि अब धर्म-युद्ध की औपचारिक तैयारी पूर्ण हो चुकी थी।
            शूर्पणखा का संवाद वासना और अहंकार का वह रूप था जिसने रामायण की कथा को युद्ध की ओर मोड़ा।
            विरूपकरण का अर्थ केवल दंड नहीं, बल्कि आसुरी प्रवृत्तियों के दमन का एक कठोर और आवश्यक संदेश था।
            वाल्मीकि जी ने देखा कि कैसे राम ने अत्यंत धैर्य के साथ उस स्थिति का सामना किया और मर्यादा नहीं लांघी।
            अगस्त्य के आश्रम का वह तेज मुनि की आँखों को चकाचौंध कर रहा था, जहाँ ज्ञान और शक्ति का संगम था।
            यह घटना सिद्ध करती है कि सत्य के मार्ग में कभी-कभी कठोर निर्णय लेना धर्म की रक्षा के लिए अनिवार्य है।
            मुनि देख रहे थे कि कैसे एक छोटी सी घटना एक विशाल साम्राज्य के पतन का कारण बनने वाली थी।
            शूर्पणखा के विलाप और उसके प्रतिशोध की ज्वाला को मुनि ने अपनी अंतर्दृष्टि से साक्षात् महसूस किया।
            यह श्लोक शांति से संघर्ष की ओर बढ़ने वाले उस मोड़ का अत्यंत प्रभावशाली वर्णन करता है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the meeting with Agastya, the receiving of the divine bow, and the dialogue with Shurpanakha.
            He experienced the decisive scene where Lakshmana disfigured (cutting the nose and ears) the demoness.
            Agastya gifting the celestial weapons indicated that the formal preparation for the righteous war was complete.
            The dialogue with Shurpanakha represented lust and ego, turning the narrative toward eventual conflict.
            The disfigurement was not mere punishment but a harsh and necessary message for the suppression of demonic urges.
            Valmiki watched how Rama faced that situation with immense patience, never overstepping the bounds of propriety.
            The brilliance of Agastya’s hermitage, where wisdom met power, dazzled the spiritual eyes of the sage.
            This incident proves that on the path of Truth, taking tough decisions is sometimes essential for protecting Dharma.
            The sage saw how a seemingly small event was destined to cause the downfall of a massive, dark empire.
            He felt the flames of Shurpanakha’s lamentation and her thirst for revenge within his own inner vision.
            This verse provides an influential account of the turn from peace toward the inevitable struggle.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 19,
        sanskrit = "वधं खरत्रिशिरसोः उत्थानं रावणस्य च ।\nमारीचस्य वधं चैव वैदेह्या हरणं तथा ॥ १९ ॥",
        hindiCommentary = """
            मुनि ने खर और त्रिशिरा का वध, रावण का क्रोधित होना और मारीच के वध के दृश्य को स्पष्ट देखा।
            उन्होंने उस अत्यंत दुखद क्षण को भी देखा जब रावण ने छल से वैदेही (सीता) का हरण (हरणं) किया।
            खर और त्रिशिरा का अंत राम के उस अजेय योद्धा स्वरूप का प्रमाण था जिसने हजारों राक्षसों को धूल चटाई।
            रावण का उत्थान (उठना) उसके अहंकार की वह अंतिम अंगड़ाई थी जो उसे विनाश की ओर ले जा रही थी।
            मारीच का सोने का मृग बनना 'माया' का वह चरमोत्कर्ष था जिसने स्वयं भगवान को भी लीला में उलझा दिया।
            सीता हरण का वह दृश्य मुनि के हृदय को छलनी कर रहा था, क्योंकि वे उनके करुण विलाप को सुन रहे थे।
            वाल्मीकि जी ने देखा कि कैसे अधर्म ने साधु का वेष धरकर धर्म की सबसे पवित्र शक्ति को चुनौती दी।
            वह अपहरण केवल एक व्यक्ति का नहीं, बल्कि संपूर्ण विश्व की मर्यादाओं का अपमान था जिसे राम ने सहा।
            मुनि देख रहे थे कि कैसे राम और लक्ष्मण कुटिया से दूर थे और नियति अपना खेल खेल रही थी।
            यह श्लोक रामायण के उस सबसे बड़े संकट और त्रासदी का वर्णन करता है जिसने पूरे ब्रह्मांड को हिला दिया।
            मुनि की आँखों से अविरल अश्रु बह रहे थे, क्योंकि वे उस पीड़ा को साक्षात् अनुभव कर रहे थे।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the slaying of Khara and Trishira, the rise of Ravana’s wrath, and the killing of Maricha.
            He also beheld that profoundly tragic moment when Ravana deceitfully abducted Vaidehi (Sita).
            The end of Khara and Trishira was proof of Rama’s invincible warrior spirit that leveled thousands of demons.
            The 'rise' of Ravana was the final surge of his ego that was pulling him inexorably toward destruction.
            Maricha’s transformation into a golden deer was the peak of 'Maya' that distracted even the Lord in His play.
            The scene of Sita’s abduction pierced the sage’s heart as he listened to her piteous and desperate cries.
            Valmiki saw how unrighteousness donned the guise of a saint to challenge the holiest power of Dharma.
            That abduction was not just of an individual but was an insult to the moral order of the entire cosmos.
            The sage watched as Rama and Lakshmana were drawn away from the hut while destiny played its cruel game.
            This verse describes the greatest crisis and tragedy of the epic that shook the foundations of the universe.
            Tears flowed incessantly from the sage’s eyes as he directly experienced that immense and sacred pain.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 20,
        sanskrit = "राघवस्य विलापं च जटायोश्च विनाशनम् ।\nकबन्धदर्शनं चैव पम्पायाश्चापि दर्शनम् ॥ २० ॥",
        hindiCommentary = """
            मुनि ने राघव (राम) का विलाप, जटायु का वध और कबन्ध राक्षस के साथ हुई भेंट को साक्षात् देखा।
            उन्होंने पम्पा सरोवर के उस अत्यंत सुंदर और विरह से भरे हुए दृश्य का भी अपनी अंतर्दृष्टि से अनुभव किया।
            राम का विलाप उनकी अटूट प्रीति और उनके मानवीय हृदय की कोमलता का सबसे बड़ा प्रमाण था।
            जटायु का बलिदान यह सिखाता था कि जब तक प्राण हैं, अधर्म के विरुद्ध लड़ना ही जीव का धर्म है।
            कबन्ध का दर्शन उस दिशा-बोध का प्रतीक था जिसने राम को सुग्रीव और हनुमान तक पहुँचने का मार्ग दिया।
            पम्पा सरोवर की सुंदरता राम के विरह को और बढ़ा रही थी, जिसे मुनि ने अपनी संवेदनाओं में महसूस किया।
            वाल्मीकि जी ने देखा कि कैसे राम ने एक पक्षी (जटायु) का अंतिम संस्कार कर उसे मोक्ष प्रदान किया।
            प्रकृति के उन सुंदर दृश्यों के बीच राम की उदासी मुनि के हृदय को द्रवित कर देने वाली थी।
            वे देख रहे थे कि कैसे हर बाधा अब राम को उनके मुख्य सहायक—हनुमान—के करीब ला रही थी।
            यह श्लोक पीड़ा, बलिदान और नई उम्मीद के उस संक्रमण काल को बहुत सूक्ष्मता से उजागर करता है।
            मुनि की दृष्टि अब उस महान मिलन की ओर बढ़ रही थी जो रावण के अंत का सबसे बड़ा कारण बना।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed Rama’s lamentation, the destruction of Jatayu, and the meeting with the demon Kabandha.
            He also experienced the vision of the beautiful Pampa Lake, which was saturated with the pain of separation.
            Rama’s lament was the primary evidence of His unbreakable affection and the tenderness of His human heart.
            Jatayu’s sacrifice taught that as long as there is life, fighting against unrighteousness is one’s duty.
            Meeting Kabandha symbolized the guidance that provided Rama the path to reach Sugriva and Hanuman.
            The beauty of Pampa intensified Rama’s longing for Sita, a sentiment the sage felt in his own soul.
            Valmiki saw how Rama performed the last rites for a bird (Jatayu), granting him ultimate liberation.
            Rama’s sadness amidst those beautiful natural settings was deeply moving for the contemplative sage.
            He watched how every obstacle was now leading Rama closer to His primary ally—Hanuman.
            This verse highlights the transition period of pain, sacrifice, and the emergence of new hope.
            The sage’s vision was now moving toward the grand meeting that became the chief cause of Ravana’s end.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 21,
        sanskrit = "शबर्या दर्शनं चैव फलमूलाशनं तथा ।\nहनुमद्दर्शनं चैव पम्पायाश्चैव दर्शनम् ॥ २१ ॥",
        hindiCommentary = """
            मुनि ने शबरी के दर्शन और उसके द्वारा अर्पित किए गए कंद-मूल व फलों के आहार को साक्षात् देखा।
            उन्होंने पम्पा सरोवर के तट पर हनुमान जी के साथ श्री राम के प्रथम मिलन के दृश्य का अनुभव किया।
            शबरी का प्रेम जाति-पाति के बंधनों को तोड़कर साक्षात् भक्ति के सर्वोच्च शिखर को दर्शा रहा था।
            हनुमान जी का एक ब्राह्मण के वेष में आना उनकी कूटनीतिक चतुरता और विनम्रता का प्रमाण था।
            वाल्मीकि जी ने देखा कि कैसे पम्पा की प्राकृतिक छटा राम के विरह को और अधिक गहरा बना रही थी।
            पक्षी और मृग भी राम के दुख में दुखी होकर अपनी संवेदनाएं मूक रूप में व्यक्त कर रहे थे।
            राम द्वारा शबरी के जूठे बेरों को खाना यह सिद्ध करता था कि उनके लिए 'भाव' ही सर्वोपरि है।
            मुनि ने उस क्षण की पवित्रता को महसूस किया जहाँ भगवान और भक्त के बीच कोई दूरी नहीं रही थी।
            हनुमान के वचनों ने राम के हृदय में पहली बार सीता को पाने की एक निश्चित उम्मीद जगाई थी।
            पम्पा का तट अब एक नए गठबंधन और रावण के पतन की रणनीतियों का साक्षी बनने वाला था।
            यह श्लोक भक्ति के मधुर पक्ष और नई शक्तियों के जुड़ने के उस संधि-काल को प्रकट करता है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the meeting with Sabari and the humble offering of forest fruits and roots.
            He experienced the first encounter between Sri Rama and Hanuman at the banks of Lake Pampa.
            Sabari's love represented the pinnacle of devotion, transcending the artificial barriers of caste.
            Hanuman’s arrival in the guise of a Brahmin showcased His diplomatic wisdom and deep humility.
            Valmiki observed how the natural beauty of Pampa intensified Rama’s profound sense of separation.
            Even the birds and deer of the forest seemed to silently share the Prince's agonizing grief.
            Rama eating the berries offered by Sabari proved that for Him, 'Devotion' is the only currency.
            The sage felt the purity of that moment where the distance between God and devotee vanished.
            Hanuman’s words ignited the first concrete ray of hope in Rama's heart regarding Sita’s recovery.
            The shores of Pampa were set to witness a new alliance and the strategies for Ravana’s downfall.
            This verse reveals the sweet aspect of devotion and the transitional phase of gathering new allies.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 22,
        sanskrit = "ऋष्यमूकस्य गमनं सुग्रीवेण समागमम् ।\nसख्यं च प्रतिज्ञानं च वालि सुग्रीवविग्रहम् ॥ २२ ॥",
        hindiCommentary = """
            मुनि ने ऋष्यमूक पर्वत की यात्रा और वहाँ राजा सुग्रीव के साथ हुए पावन समागम को देखा।
            उन्होंने अग्नि को साक्षी मानकर की गई अटूट मित्रता और बाली वध की प्रतिज्ञा को साक्षात् सुना।
            बाली और सुग्रीव के बीच उस भयानक युद्ध (विग्रह) का दृश्य मुनि के हृदय को कंपा देने वाला था।
            सुग्रीव का भय और राम का उन्हें दिया गया अभय दान—दोनों ही मुनि की अंतर्दृष्टि में स्पष्ट थे।
            भाइयों के बीच का यह द्वेष अधर्म के उन बीजों का परिणाम था जिन्हें अब नष्ट होना अनिवार्य था।
            राम की प्रतिज्ञा एक राजा के न्यायप्रिय होने और अपने मित्र की रक्षा करने के धर्म को सिद्ध करती थी।
            ऋष्यमूक पर्वत उस समय का सबसे सुरक्षित शरण स्थल था, जो अब एक युद्ध का केंद्र बन गया था।
            वाल्मीकि जी ने देखा कि कैसे राम ने सुग्रीव के टूटे हुए आत्मविश्वास को अपने तेज से पुनः जीवित किया।
            वह संधि केवल दो व्यक्तियों के बीच नहीं, बल्कि न्याय की पुनर्स्थापना के लिए लिया गया महा-संकल्प था।
            बाली का बल और सुग्रीव की वेदना—दोनों को मुनि ने एक संतुलित न्यायाधीश की तरह अपनी दृष्टि में रखा।
            यह श्लोक रामायण के उस मोड़ का वर्णन है जहाँ से वानर शक्ति राम के साथ औपचारिक रूप से जुड़ी।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the journey to Mount Rishyamukha and the sacred alliance formed with Sugriva.
            He directly heard the vow of unbreakable friendship made before Fire and the promise to slay Bali.
            The vision of the terrifying conflict (Vigraham) between Bali and Sugriva was bone-chilling to the sage.
            Sugriva’s paralyzing fear and the boon of fearlessness granted by Rama were both clear in his vision.
            The enmity between the brothers was the fruit of unrighteousness that now required total eradication.
            Rama’s vow illustrated the duty of a just monarch to protect His allies and uphold moral law.
            Mount Rishyamukha, once a silent refuge, had now become the strategic center of a great war.
            Valmiki saw how Rama’s aura revived Sugriva’s shattered confidence and infused him with purpose.
            The treaty was not merely between two individuals but was a grand resolve to restore world justice.
            The sage observed Bali’s might and Sugriva’s agony with the balanced perspective of a divine judge.
            This verse describes the turn in the epic where the Vanara power formally integrated with Rama’s mission.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 23,
        sanskrit = "वालिप्रमथनं चैव सुग्रीवप्रतिपादनम् ।\nताराविलापं समयं वर्षाकालं च राघवम् ॥ २३ ॥",
        hindiCommentary = """
            मुनि ने बाली के वध (प्रमथनं) और सुग्रीव के राज्याभिषेक (प्रतिपादनम्) के दृश्यों को स्पष्ट देखा।
            उन्होंने बाली की पत्नी तारा के हृदयविदारक विलाप और राम द्वारा उसे दिए गए ज्ञान को महसूस किया।
            वर्षाकाल के दौरान प्रवर्षण पर्वत पर राघव (राम) के उस एकांत और विरहपूर्ण निवास का अनुभव किया।
            समय की मर्यादा का पालन करते हुए राम का चार महीने तक युद्ध टालना उनके धैर्य की पराकाष्ठा थी।
            तारा का विलाप केवल एक पत्नी का दुख नहीं, बल्कि एक साम्राज्य के पतन की करुण पुकार थी।
            सुग्रीव को राज्य देना राम की निस्वार्थता और उनके 'सत्यसंध' होने का एक और महान प्रमाण था।
            बादलों की गर्जना और बिजली की कड़क राम को सीता के वियोग में और अधिक व्याकुल कर रही थी।
            वाल्मीकि जी ने देखा कि कैसे राम प्रकृति के माध्यम से सीता की खोज के संदेश पढ़ रहे थे।
            धार्मिक समय (मर्यादा) का पालन करना राम के चरित्र की वह धुरी थी जो उन्हें देवताओं से ऊपर उठाती थी।
            मुनि देख रहे थे कि कैसे विजय के बाद भी राम विलासी नहीं बने, बल्कि निरंतर तपस्या में लीन रहे।
            यह श्लोक सफलता और प्रतीक्षा के बीच के उस मानवीय और आध्यात्मिक संतुलन का अद्भुत चित्रण है।
        """.trimIndent(),
        englishCommentary = """
            The sage saw the slaying (Pramathanam) of Bali and the subsequent installation of Sugriva as king.
            He felt the heart-rending lamentation of Tara and the spiritual wisdom Rama imparted to her in grief.
            He experienced Rama's solitary and longing-filled residence on Mount Pravarsana during the monsoon.
            Adhering to the ethics of time, Rama’s decision to halt operations for four months showed His patience.
            Tara’s lament was not just personal sorrow but the piteous outcry of a falling empire’s conscience.
            Establishing Sugriva on the throne was another testament to Rama’s selflessness and His integrity.
            The roar of clouds and flashes of lightning intensified Rama’s agony in the absence of Sita.
            Valmiki watched how Rama interpreted the messages of nature as He awaited news of His beloved.
            Adherence to the 'Samayam' (appointed time) was the axis of Rama’s character that elevated Him.
            The sage noted that even after victory, Rama did not turn toward luxury but remained in penance.
            This verse is an extraordinary depiction of the balance between worldly success and spiritual waiting.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 24,
        sanskrit = "कोपं राघवसिंहस्य बलविन्यासमर्जनम् ।\nदिशः प्रस्थापनं चैव पृथिव्याश्च निवेशनम् ॥ २४ ॥",
        hindiCommentary = """
            मुनि ने सुग्रीव की देरी पर राघव-सिंह (राम) के उस भयंकर और न्यायोचित कोप (क्रोध) को देखा।
            उन्होंने वानर सेना के विशाल 'बलविन्यास' (संगठन) और चारों दिशाओं में उनके प्रस्थान का अनुभव किया।
            पृथ्वी के कोने-कोने में सीता की खोज के लिए वानरों के भेजे जाने का दृश्य अत्यंत व्यापक था।
            लक्ष्मण का किष्किन्धा जाकर सुग्रीव को चेतावनी देना राम के अनुशासन का एक कठोर रूप था।
            राम का क्रोध केवल व्यक्तिगत नहीं था, बल्कि वह अधर्म और प्रमाद (आलस्य) के विरुद्ध एक चेतावनी थी।
            सेना का अर्जन (एकत्रित होना) यह सिद्ध करता था कि अब युद्ध एक वैश्विक अभियान बन चुका था।
            निवेशनम् का अर्थ है—पूरी पृथ्वी के भूगोल और वहाँ के रहस्यों का वानरों द्वारा सूक्ष्म निरीक्षण।
            वाल्मीकि जी ने देखा कि कैसे लाखों वानर अपने आराध्य के एक इशारे पर अपना घर छोड़कर चल दिए।
            यह संगठन की वह शक्ति थी जिसने सिद्ध किया कि निष्ठा हो तो पशु भी देवताओं जैसा कार्य कर सकते हैं।
            मुनि की दृष्टि अब उन हजारों वानर समूहों के साथ थी जो अलग-अलग दिशाओं में भटक रहे थे।
            यह श्लोक राम के प्रभावी नेतृत्व और उनकी सैन्य कुशलता के उस विराट स्वरूप को उजागर करता है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the fierce and justified wrath (Kopa) of the lion-like Rama at Sugriva’s delay.
            He experienced the massive mobilization (Balavinyasam) of the Vanara army and its deployment.
            The scene of monkeys being dispatched to every corner of the earth to find Sita was truly expansive.
            Lakshmana’s visit to Kishkindha to warn Sugriva showcased a sterner aspect of Rama’s discipline.
            Rama's anger was not petty; it was a divine warning against negligence and the decay of morality.
            The gathering (Arjanam) of the forces proved that the conflict had now become a global campaign.
            'Niveshanam' implies the thorough geographical exploration of the earth conducted by the Vanara scouts.
            Valmiki saw how millions of monkeys abandoned their homes at a single signal from their Lord.
            This was the power of organization, proving that with loyalty, even animals can perform divine deeds.
            The sage’s vision followed the thousands of monkey groups wandering in diverse and distant directions.
            This verse highlights the majestic scale of Rama’s effective leadership and His tactical brilliance.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 25,
        sanskrit = "अङ्गुलीयकदानं च हनुमान् यत्र चोदितः ।\nऋक्षबिलस्य दर्शनं गिरेश्चापि समुत्प्लवम् ॥ २५ ॥",
        hindiCommentary = """
            मुनि ने राम द्वारा हनुमान को अपनी 'अङ्गुलीयक' (अंगूठी) सौंपने के उस अत्यंत भावुक दृश्य को देखा।
            उन्होंने हनुमान को विशेष कार्य के लिए प्रेरित (चोदितः) करने और उनकी अगाध निष्ठा का अनुभव किया।
            वानरों द्वारा ऋक्षबिल (स्वयंप्रभा की गुफा) के दर्शन और वहाँ की मायावी स्थिति को मुनि ने समझा।
            समुद्र तट पर पहुँचकर महेंद्र पर्वत से हनुमान के उस महा-छलांग (समुत्प्लवम्) का दृश्य अलौकिक था।
            अंगूठी देना राम के हनुमान पर अटूट विश्वास और सीता के लिए उनके प्रेम का एक मूक संदेश था।
            ऋक्षबिल का प्रसंग यह सिखाता है कि जब मार्ग बंद दिखे, तो ईश्वर स्वयं कोई गुप्त द्वार खोल देते हैं।
            हनुमान का समुद्र लांघने का संकल्प ब्रह्मांड के इतिहास की सबसे बड़ी साहसिक यात्रा की शुरुआत थी।
            वाल्मीकि जी ने देखा कि कैसे हनुमान ने अपने शरीर को पर्वत के समान विशाल और वज्र जैसा बना लिया।
            उस छलांग के समय समुद्र की लहरें भी हनुमान के चरणों की वंदना कर रही थीं, जो मुनि को स्पष्ट दिखा।
            हनुमान के भीतर का वह 'राम-बल' अब उन्हें अजेय बना चुका था, जिससे देवता भी विस्मित थे।
            यह श्लोक 'सुन्दरकाण्ड' के उस महान प्रस्थान और अटूट सेवा-भाव का एक तेजस्वी वर्णन है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the deeply emotional scene of Rama handing His signet ring to Hanuman.
            He experienced Hanuman being specially commissioned (Choditah) and His profound sense of duty.
            He understood the discovery of the Rickshabila (the cave of Svayamprabha) and its illusory nature.
            The vision of Hanuman’s gargantuan leap (Samutplavam) from Mount Mahendra was transcendental.
            Giving the ring was a silent message of Rama’s absolute trust in Hanuman and His love for Sita.
            The incident of the Rickshabila teaches that when paths seem closed, God opens a secret door.
            Hanuman’s resolve to cross the ocean marked the beginning of the greatest odyssey in cosmic history.
            Valmiki observed how Hanuman expanded His form to be as vast as a mountain and firm as a diamond.
            During that leap, even the ocean waves seemed to prostrate before His feet, as seen by the sage.
            The 'Rama-power' within Hanuman had now rendered Him invincible, astonishing even the gods.
            This verse is a radiant description of the grand departure and the spirit of tireless service.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 26,
        sanskrit = "हनुमतः प्रतिज्ञानं समुद्रतरणं तथा ।\nमैनाकस्य च दर्शनं सुरसायाश्च दर्शनम् ॥ २६ ॥",
        hindiCommentary = """
            मुनि ने हनुमान की वह कठोर प्रतिज्ञा और समुद्र को सफलतापूर्वक पार करने (तरणं) के दृश्य को देखा।
            उन्होंने मार्ग में मैनाक पर्वत के दर्शन और हनुमान के प्रति उसके आदरपूर्ण व्यवहार का अनुभव किया।
            नागमाता सुरसा द्वारा ली गई हनुमान की परीक्षा और उनकी बुद्धिमत्ता के दर्शन मुनि को हुए।
            हनुमान का मार्ग बाधाओं से भरा था, पर उनका संकल्प किसी भी पर्वत से कहीं अधिक दृढ़ और अटल था।
            मैनाक का उठना यह बताता है कि प्रकृति भी राम-भक्तों को विश्राम और सहायता देना चाहती है।
            सुरसा का प्रसंग यह सिद्ध करता है कि बुद्धि और विवेक से बड़े से बड़े संकट को टाला जा सकता है।
            वाल्मीकि जी ने देखा कि कैसे हनुमान ने सूक्ष्म रूप धरकर सुरसा के मुख से बाहर निकलकर उसे विस्मित किया।
            समुद्र का विस्तार हनुमान के लिए केवल एक खेल था, क्योंकि वे राम-कार्य के मद में पूरी तरह डूबे थे।
            हर बाधा हनुमान के तेज को और अधिक निखार रही थी, जो मुनि की अंतर्दृष्टि में स्पष्ट दिखाई दे रहा था।
            यह यात्रा केवल दूरी तय करना नहीं, बल्कि एक भक्त की योग्यता की सर्वोच्च अग्नि-परीक्षा थी।
            यह श्लोक हनुमान के पराक्रम और उनकी विलक्षण मेधा (बुद्धि) का एक बहुत ही गौरवशाली विवरण है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed Hanuman’s firm vow and the successful crossing (Taranam) of the vast ocean.
            He experienced the vision of Mount Mainaka and its respectful hospitality toward the flying hero.
            He beheld the trial posed by Surasa, the mother of serpents, and Hanuman’s exceptional wit.
            Hanuman’s path was riddled with obstacles, yet His resolve was far more steadfast than any mountain.
            Mainaka’s emergence showed that nature itself desires to offer rest and aid to the devotees of Rama.
            The Surasa episode proves that with intellect and discernment, the greatest crises can be averted.
            Valmiki saw how Hanuman assumed a microscopic form to exit Surasa's mouth, leaving her awestruck.
            The vastness of the sea was but a playground for Hanuman, absorbed in the intoxication of Rama’s work.
            Every hurdle only served to polish Hanuman’s radiance, as observed clearly by the sage’s vision.
            This journey was not just about covering distance but was the ultimate test of a devotee’s merit.
            This verse is a glorious account of Hanuman’s prowess and His extraordinary intellectual brilliance.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 27,
        sanskrit = "सिंहिकायाश्च निधनं लङ्कादर्शनमेव च ।\nरात्रौ लङ्काप्रवेशं च लङ्कायाश्चापि दर्शनम् ॥ २७ ॥",
        hindiCommentary = """
            मुनि ने छाया पकड़ने वाली राक्षसी 'सिंहिका' के वध और लंकापुरी के प्रथम दर्शन के दृश्य को देखा।
            उन्होंने रात के समय हनुमान द्वारा लंका में प्रवेश करने और उस नगरी के वैभव को साक्षात् अनुभव किया।
            सिंहिका का अंत यह दर्शाता है कि जो अदृश्य रूप से बाधा डालते हैं, उनका विनाश भी अनिवार्य है।
            लंका का दर्शन हनुमान के लिए विस्मय और चुनौती दोनों था, क्योंकि वह नगरी स्वर्णमयी और अजेय थी।
            रात में प्रवेश करना हनुमान की उस बुद्धिमत्ता का प्रमाण था जो उन्हें एक महान गुप्तचर (Spy) बनाती है।
            वाल्मीकि जी ने देखा कि कैसे हनुमान ने लंकाधिष्ठात्री देवी (लंका) को पराजित कर नगर में प्रवेश पाया।
            लंका के महलों की चकाचौंध मुनि को वैसी ही दिख रही थी जैसी वह रावण के शासन काल में थी।
            हनुमान की दृष्टि अब केवल एक ही लक्ष्य पर टिकी थी—माता सीता, जिन्हें वे चप्पे-चप्पे में ढूँढ रहे थे।
            नगरी की सुरक्षा व्यवस्था अत्यंत कड़ी थी, पर राम-कृपा के सामने वे पहरे भी बेअसर साबित हुए।
            मुनि देख रहे थे कि कैसे एक छोटा सा वानर रूप उस असुर-साम्राज्य की नींव हिलाने के लिए आ गया था।
            यह श्लोक रहस्य, रोमांच और एक महान योद्धा के शत्रु के गढ़ में प्रवेश का अत्यंत सजीव वर्णन है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the slaying of the shadow-catching demoness Simhika and the first sight of Lanka.
            He experienced Hanuman’s entry into Lanka at night and His observation of the city's dark splendor.
            The end of Simhika illustrates that those who hinder through invisible means must also be destroyed.
            The sight of Lanka was both a marvel and a challenge to Hanuman, as the city was golden and invincible.
            Entering at night proved Hanuman’s strategic wisdom, establishing Him as a supreme intelligence agent.
            Valmiki saw how Hanuman subdued the presiding deity of the city to gain formal entry into the fortress.
            The dazzle of Lanka’s palaces appeared in the sage’s vision exactly as it did during Ravana’s reign.
            Hanuman’s focus was singular: Mother Sita, whom He sought in every corner of the demonic capital.
            The city’s security was incredibly tight, yet those guards were ineffective against the grace of Rama.
            The sage watched as a single, small monkey arrived to shake the very foundations of that demon empire.
            This verse is a vivid account of mystery, thrill, and a great warrior’s infiltration into the enemy camp.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 28,
        sanskrit = "अन्तःपुरस्य दर्शनं रावणस्य च दर्शनम् ।\nपुष्पकस्य च दर्शनं सीतादर्शनमेव च ॥ २८ ॥",
        hindiCommentary = """
            मुनि ने रावण के अंतःपुर (महल के भीतर), स्वयं रावण के और पुष्पक विमान के भव्य दर्शन किए।
            सबसे महत्वपूर्ण, उन्होंने अशोक वाटिका में बैठी परम पावन सीता जी के दर्शन का साक्षात् अनुभव किया।
            रावण का वैभव अपनी चरम सीमा पर था, पर हनुमान के लिए वह केवल एक तिनके के समान था।
            पुष्पक विमान की अलौकिक बनावट और उसका तेज मुनि की दिव्य दृष्टि में साक्षात् चमक रहा था।
            सीता जी का वह दृश्य अत्यंत कारुणिक था, जहाँ वे शोक के सागर में डूबी राम का चिंतन कर रही थीं।
            वाल्मीकि जी ने देखा कि कैसे रावण ने सीता को प्रलोभन देने की कोशिश की और उन्हें डराया।
            परन्तु सीता की वह 'अग्नि-शिखा' जैसी पवित्रता रावण के हर प्रयास को भस्म कर देने वाली थी।
            हनुमान जी का छिपकर उस पूरे संवाद को सुनना मुनि ने अपनी संवेदनाओं में गहराई से महसूस किया।
            वे देख रहे थे कि कैसे एक पतिव्रता नारी का तेज एक पूरे राक्षसी साम्राज्य पर भारी पड़ रहा था।
            यही वह क्षण था जहाँ हनुमान को विश्वास हुआ कि उनकी यात्रा पूरी तरह सफल और सार्थक हो गई है।
            यह श्लोक रामायण के उस सबसे पवित्र और निर्णायक खोज के पूर्ण होने का गौरवशाली वृत्तांत है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the inner apartments of the palace, Ravana himself, and the grand Pushpaka Vimana.
            Most importantly, he directly experienced the vision of the supremely holy Sita in the Ashoka Grove.
            Ravana’s opulence was at its zenith, yet for Hanuman, it appeared as insignificant as a piece of straw.
            The supernatural architecture and radiance of the Pushpaka Vimana shone in the sage’s divine vision.
            The sight of Sita was deeply piteous; she was submerged in grief, constantly meditating on Rama.
            Valmiki saw Ravana attempting to tempt and terrorize Sita into submission through various means.
            However, Sita’s purity, like a 'flame of fire,' was capable of incinerating every demonic effort.
            The sage deeply felt Hanuman’s hidden presence as He listened to that fateful and tense dialogue.
            He observed how the spiritual power of a devoted woman outweighed the entire might of a demon race.
            This was the precise moment when Hanuman realized His arduous journey had become fully successful.
            This verse is the glorious account of the completion of the holiest and most decisive quest in the epic.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 29,
        sanskrit = "अशोकवनिकायां च वानरस्य च दर्शनम् ।\nसीतया चापि संवादं अङ्गुलीयकदर्शनम् ॥ २९ ॥",
        hindiCommentary = """
            मुनि ने अशोक वाटिका में सीता जी द्वारा हनुमान (वानर) को देखने के उस चमत्कारी दृश्य को देखा।
            उन्होंने सीता और हनुमान के बीच हुए उस ऐतिहासिक संवाद और अंगूठी (अङ्गुलीयक) के दर्शन को अनुभव किया।
            सीता जी के लिए हनुमान का प्रकट होना एक स्वप्न जैसा था, जिसे मुनि ने अपनी अंतर्दृष्टि से साक्षात् देखा।
            अंगूठी को हाथ में लेकर सीता जी के अश्रुओं का बहना और उनकी प्रसन्नता मुनि को द्रवित कर रही थी।
            हनुमान ने कैसे राम के गुणों का गान करके सीता का विश्वास जीता, यह दृश्य अत्यंत भावुक और पवित्र था।
            राम की अंगूठी केवल एक आभूषण नहीं, बल्कि सीता के लिए पुनर्जीवन का एक दिव्य संदेश बनकर आई थी।
            वाल्मीकि जी ने उस संवाद की हर बारीक गूँज को सुना, जहाँ एक भक्त अपनी माता को ढांढस बंधा रहा था।
            सीता का हनुमान को अपना रक्षक मानना यह सिद्ध करता था कि अब विजय का मार्ग पूरी तरह खुल चुका है।
            वह अशोक वाटिका, जो पहले पीड़ा का स्थान थी, अब आशा और आनंद के संचार का केंद्र बन गई थी।
            नारद जी ने जो संक्षेप में बताया था, मुनि अब उसकी पूरी गहराई और गरिमा का साक्षात्कार कर रहे थे।
            यह श्लोक विश्वास, समर्पण और वियोग के अंत की उस पहली सुखद किरण का एक मार्मिक चित्रण है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the miraculous scene of Sita beholding Hanuman (the Vanara) in the Ashoka Grove.
            He experienced the historic dialogue between them and the presentation of the signet ring (Anguliyaka).
            For Sita, Hanuman’s appearance was like a divine dream, witnessed directly by the sage’s inner vision.
            The sight of Sita’s flowing tears and her subsequent joy upon holding the ring moved the sage deeply.
            The scene where Hanuman won Sita’s trust by singing the glories of Rama was profoundly sacred.
            Rama’s ring was not just an ornament; it arrived as a divine message of rebirth and hope for Sita.
            Valmiki heard every subtle resonance of that dialogue where a devotee provided solace to his Mother.
            Sita accepting Hanuman as her protector proved that the path to victory was now wide open.
            The Ashoka Grove, previously a place of intense agony, transformed into a center of hope and bliss.
            The sage was now realizing the full depth and dignity of what Narada had earlier summarized briefly.
            This verse is a poignant depiction of trust, surrender, and the first joyful ray marking the end of exile.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 30,
        sanskrit = "अक्षघ्नं च ततस्तत्र राक्षसस्य निपातनम् ।\nमन्त्रिपुत्रवधं चैव रावणस्य च दर्शनम् ॥ ३० ॥",
        hindiCommentary = """
            मुनि ने हनुमान द्वारा रावण के पुत्र 'अक्षकुमार' का वध और अन्य शक्तिशाली राक्षसों का पतन देखा।
            उन्होंने रावण के मंत्रियों के पुत्रों के वध और हनुमान की रावण के साथ उस भयानक भेंट को साक्षात् देखा।
            हनुमान का वह 'रुद्र' रूप लंका के लिए काल के समान था, जो मुनि की दृष्टि में अत्यंत ओजस्वी लग रहा था।
            अशोक वाटिका को उजाड़ना हनुमान की एक सोची-समझी रणनीति थी ताकि वे रावण के सामने पहुँच सकें।
            वाल्मीकि जी ने देखा कि कैसे हनुमान के एक ही प्रहार से रावण के श्रेष्ठ योद्धा धराशायी हो रहे थे।
            रावण के दरबार में हनुमान की वह निडरता और उनका गर्जन मुनि को साक्षात् सुनाई दे रहा था।
            एक बंदी के रूप में भी हनुमान की गरिमा किसी सम्राट से कम नहीं थी, जो मुनि ने गहराई से महसूस किया।
            रावण का क्रोध और उसका अहंकार अब अपने विनाश की ओर तेजी से बढ़ता हुआ दिखाई दे रहा था।
            हनुमान ने सिद्ध किया कि राम का एक साधारण दूत भी लंका के राजकुमारों पर भारी पड़ सकता है।
            मुनि देख रहे थे कि कैसे यह संघर्ष अब एक व्यक्तिगत खोज से निकलकर एक महायुद्ध में बदल रहा था।
            यह श्लोक वीरता, प्रतिशोध और शत्रु के गढ़ में मचाई गई उस भारी खलबली का अत्यंत साहसी वर्णन है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed Hanuman slaying Ravana’s son Aksayakumara and the fall of other mighty demons.
            He saw the slaughter of the ministers’ sons and Hanuman’s direct, formidable encounter with Ravana.
            Hanuman’s 'Rudra' (fierce) aspect appeared like Time personified for Lanka, as seen by the sage’s vision.
            Devastating the Ashoka Grove was a calculated strategy by Hanuman to ensure a face-off with Ravana.
            Valmiki watched how Ravana’s elite warriors were leveled by a single blow from the heroic Vanara.
            Hanuman’s fearlessness and His mighty roar in Ravana’s court were directly audible to the sage.
            Even as a captive, Hanuman’s dignity was no less than that of an emperor, as felt deeply by the sage.
            Ravana’s wrath and his monumental ego were now seen racing rapidly toward their own destruction.
            Hanuman proved that even a simple messenger of Rama could outweigh the princes of Lanka in combat.
            The sage observed how the conflict was now escalating from a personal search into a massive world war.
            This verse is a bold account of valor, retaliation, and the heavy chaos unleashed within the enemy camp.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 31,
        sanskrit = "लङ्कादहनं चैव तथा नगरमर्दनम् ।\nप्रत्यभिज्ञानदानं च राघवाय च निवेद्य च ॥ ३१ ॥",
        hindiCommentary = """
            मुनि ने हनुमान द्वारा स्वर्णमयी लंका को जलाकर राख करने और उस अजेय नगरी के मर्दन (विनाश) को देखा।
            उन्होंने हनुमान द्वारा सीता जी से प्राप्त 'चूड़ामणि' (पहचान) को राम को सौंपने का दृश्य साक्षात् देखा।
            लंका दहन केवल एक भौतिक विनाश नहीं था, बल्कि वह रावण के पापों के घड़े के फूटने का प्रतीक था।
            हनुमान का वह रौद्र रूप मुनि की अंतर्दृष्टि में साक्षात् काल की अग्नि के समान प्रज्वलित दिख रहा था।
            वाल्मीकि जी ने देखा कि कैसे हनुमान ने सीता का संदेश राम को दिया, जिससे राम की व्याकुलता शांत हुई।
            वह चूड़ामणि हाथ में लेकर राम के बहते अश्रुओं का स्पर्श मुनि ने अपनी संवेदनाओं में महसूस किया।
            मुनि देख रहे थे कि कैसे एक भक्त ने अपने प्रभु को जीवनदान दिया और युद्ध के लिए नया मार्ग खोला।
            लंका के दहन ने सिद्ध कर दिया था कि असुरों का वैभव धर्म की एक छोटी सी चिनगारी के सामने टिक नहीं सकता।
            हनुमान की यह सफलता राम-कथा का वह निर्णायक बिंदु थी जहाँ से 'विजय' की उल्टी गिनती शुरू हुई।
            यह श्लोक भक्ति की शक्ति और शत्रु के गढ़ को उसके अहंकार सहित जला देने के पराक्रम का वर्णन है।
            मुनि की दृष्टि अब समुद्र के उस विशाल विस्तार की ओर मुड़ गई थी जिसे अब पार किया जाना था।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the conflagration of Lanka and the systematic dismantling of that arrogant city.
            He clearly saw Hanuman presenting the 'Chudamani' (token of recognition) from Sita to Rama.
            The burning of Lanka was not just a physical destruction but a symbolic end to the reign of sin.
            Hanuman's fierce form appeared in the sage’s vision as if the very fire of dissolution had ignited.
            Valmiki observed how Hanuman’s report provided Rama with a new lease of life and purpose.
            The sage felt the warmth of Rama's tears as He held the jewel, a moment of profound emotional union.
            He watched as a devotee rescued his Lord from despair and carved the path for the upcoming war.
            The flames consuming Lanka proved that demonic opulence cannot withstand the spark of Dharma.
            Hanuman’s breakthrough was the pivotal moment from which the countdown to victory truly began.
            This verse describes the potency of devotion and the heroism of razing the enemy's ego to the ground.
            The sage’s inner eye was now turning toward the vast ocean that stood as the final physical barrier.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 32,
        sanskrit = "सागरस्य च सन्देशं नलसेतुं च दर्शनम् ।\nसमुद्रतरणं चैव रात्रौ लङ्काप्रपीडनम् ॥ ३२ ॥",
        hindiCommentary = """
            मुनि ने समुद्र के साथ राम का संवाद, समुद्र का मार्ग देना और नल द्वारा सेतु निर्माण को देखा।
            उन्होंने वानर सेना द्वारा समुद्र पार करने और रात के समय लंका की घेराबंदी (प्रपीडनम्) का अनुभव किया।
            पत्थरों का पानी पर तैरना राम के नाम की महिमा और वानरों के सामूहिक श्रम का एक अलौकिक चमत्कार था।
            वाल्मीकि जी ने देखा कि कैसे राम ने अपने बाणों से समुद्र को डराया और उसे अपनी मर्यादा सिखाई।
            सेतु का निर्माण भूगोल और इतिहास की सबसे बड़ी सामरिक विजय थी, जिसे मुनि ने साक्षात् देखा।
            रात के सन्नाटे में लंका को चारों ओर से घेर लेने का दृश्य राक्षसों के मन में भारी भय उत्पन्न कर रहा था।
            राम और लक्ष्मण सेना का नेतृत्व करते हुए लंका के द्वारों पर काल की तरह खड़े थे, यह मुनि को स्पष्ट दिखा।
            समुद्र का पार करना यह सिद्ध करता था कि संकल्प के सामने कोई भी प्राकृतिक बाधा स्थायी नहीं है।
            वानरों का उत्साह और उनके गर्जन से लंका की दीवारें कांप रही थीं, जिसे मुनि ने अपनी अंतर्दृष्टि से सुना।
            यह श्लोक संगठन, बुद्धिमत्ता और असंभव को संभव बनाने वाली 'राम-शक्ति' का एक तेजस्वी विवरण है।
            अब युद्ध की रणभेरी बज चुकी थी और विनाश का वह महान अध्याय शुरू होने वाला था।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed Rama’s dialogue with the Ocean, the path provided, and the construction of the bridge by Nala.
            He experienced the army crossing the sea and the nocturnal siege (Prapidanam) of the city of Lanka.
            The floating stones were a supernatural miracle representing the potency of Rama’s name and collective labor.
            Valmiki saw how Rama’s arrows compelled the Ocean-god to yield and acknowledge the limits of propriety.
            The construction of the Setu was the greatest strategic victory in history, witnessed directly by the sage.
            The scene of encircling Lanka under the cover of night struck absolute terror into the hearts of the demons.
            Rama and Lakshmana stood like harbingers of death at the gates of Lanka, as seen vividly by the seer.
            Crossing the ocean proved that no natural obstacle is permanent before a dedicated and holy resolve.
            The walls of Lanka trembled at the roars of the Vanaras, a sound heard by the sage in his deep meditation.
            This verse provides a radiant account of organization, wisdom, and the divine power that achieves the impossible.
            The trumpets of war had sounded, and the grand chapter of the final destruction was set to unfold.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 33,
        sanskrit = "विभीषणेन सख्यं च वधं रावणस्य च ।\nअभिषेकं च रामस्य सीतायाश्च विशोधनम् ॥ ३३ ॥",
        hindiCommentary = """
            मुनि ने विभीषण के साथ मित्रता, रावण के वध और राम के राज्याभिषेक की तैयारियाँ साक्षात् देखीं।
            उन्होंने अग्नि में प्रवेश कर सीता जी की शुद्धि (विशोधनम्) और उनकी पवित्रता के दिव्य प्रमाण को देखा।
            विभीषण का शरण में आना और राम का उसे अभय देना राम के 'शरणागत-वत्सल' स्वरूप का चरम था।
            रावण का वध अधर्म के अंत और ब्रह्मांडीय संतुलन की पुनर्स्थापना का एक महान उत्सव था।
            वाल्मीकि जी ने देखा कि कैसे राम ने युद्ध के बाद भी मर्यादा का पालन किया और विभीषण को राज्य सौंपा।
            सीता जी की अग्नि-परीक्षा वह मर्मस्पर्शी क्षण था जहाँ सत्य ने साक्षात् अग्नि की जलन को भी शीतल कर दिया।
            मुनि ने देवताओं को आकाश से पुष्प वर्षा करते और राम की स्तुति करते हुए अपनी दिव्य दृष्टि से देखा।
            यह विजय केवल एक युद्ध की जीत नहीं थी, बल्कि यह पूरी मानवता के लिए 'राम-राज्य' की भूमिका थी।
            रावण के दसों सिरों का गिरना मुनि की आँखों के सामने एक अधर्मी साम्राज्य के पतन का जीवंत चित्र था।
            यह श्लोक न्याय, सत्य और प्रेम की उस अंतिम विजय को समर्पित है जिस पर पूरी रामायण टिकी है।
            मुनि का हृदय अब तृप्त था, क्योंकि उन्होंने उस महान प्रकाश को देख लिया था जिसने अंधकार को मिटाया।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the alliance with Vibhishana, the slaying of Ravana, and the restoration of Rama’s kingdom.
            He beheld the purification of Sita (Vishodhanam) through the fire and the divine evidence of her sanctity.
            Vibhishana’s surrender and Rama’s protection of him was the peak of His role as the protector of refugees.
            The slaying of Ravana was a grand celebration of the end of sin and the restoration of cosmic equilibrium.
            Valmiki saw how Rama adhered to propriety even after victory by handing over the kingdom to Vibhishana.
            Sita’s trial by fire was the poignant moment where Truth rendered the very burning of the fire cool.
            The sage saw the celestial beings showering flowers and chanting hymns in praise of Lord Rama.
            This victory was not just a military conquest but the blueprint for 'Ram-Rajya' for all of humanity.
            The falling of Ravana’s ten heads was a vivid imagery of the downfall of a sinful empire before the sage.
            This verse is dedicated to the ultimate triumph of justice, truth, and love—the pillars of the epic.
            The sage’s heart was now fulfilled, having witnessed the Great Light that finally dispelled the darkness.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 34,
        sanskrit = "लङ्कायां राक्षसेन्द्रस्य विभीषणस्य च दर्शनम् ।\nपुष्पकस्य च दर्शनं अयोध्यागमनं तथा ॥ ३४ ॥",
        hindiCommentary = """
            मुनि ने लंका में राक्षसों के राजा के रूप में विभीषण को सिंहासन पर बैठे हुए स्पष्ट देखा।
            उन्होंने आकाशगामी पुष्पक विमान और उसके माध्यम से राम के अयोध्या लौटने के भव्य दृश्य को देखा।
            विभीषण का राजा बनना यह सिद्ध करता था कि राम केवल धर्म की स्थापना चाहते थे, राज्य का लोभ नहीं।
            पुष्पक विमान का आकाश में उड़ना राम की अजेय शक्ति और उनके राजसी गौरव का अलौकिक प्रतीक था।
            वाल्मीकि जी ने देखा कि कैसे राम ने विमान से अपनी पूरी सेना को अयोध्या की भूमि के दर्शन कराए।
            हवा में उड़ते हुए विमान से नीचे की नदियों और पर्वतों को देखने का अनुभव मुनि ने साक्षात् किया।
            अयोध्या की प्रजा का व्याकुल होकर अपने राजकुमार की प्रतीक्षा करना मुनि को हृदयस्पर्शी लग रहा था।
            यह यात्रा वनवास के कष्टों के अंत और एक सुखद भविष्य के प्रारंभ की ओर एक दिव्य उड़ान थी।
            राम की आँखों में अपनी मातृभूमि को देखने की जो चमक थी, उसे मुनि ने अपनी अंतर्दृष्टि से पढ़ लिया था।
            नारद जी ने जो संक्षेप में बताया था, मुनि अब उसकी हर भव्यता और उल्लास का साक्षात्कार कर रहे थे।
            यह श्लोक विजय के बाद के उस राजसी वैभव और घर वापसी के आनंद का अत्यंत सुंदर वर्णन है।
        """.trimIndent(),
        englishCommentary = """
            The sage clearly saw Vibhishana seated on the throne as the King of the demons in Lanka.
            He witnessed the sky-traveling Pushpaka Vimana and the majestic return of Rama to Ayodhya.
            Vibhishana’s coronation proved that Rama sought only the establishment of Dharma, not the acquisition of land.
            The flight of the Pushpaka was a supernatural symbol of Rama’s invincible power and His royal dignity.
            Valmiki saw how Rama showed His entire army the landscape of Ayodhya from the height of the vehicle.
            The sage experienced directly the vision of rivers and mountains passing beneath the soaring aircraft.
            The intense longing of the citizens of Ayodhya for their beloved Prince was deeply moving to the seer.
            This journey was a divine flight marking the end of the forest trials and the dawn of a blissful future.
            The sage read with his inner vision the spark in Rama’s eyes as He beheld His motherland once again.
            The grandeur summarized by Narada was now being fully experienced in all its vibrant glory by the sage.
            This verse is a beautiful account of the post-victory regal splendor and the sheer joy of returning home.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 35,
        sanskrit = "भरद्वाजाश्रमं गत्वा भरतस्य च दर्शनम् ।\nअभिषेकं च रामस्य सर्वाधिपत्यमेव च ॥ ३५ ॥",
        hindiCommentary = """
            मुनि ने राम द्वारा भरद्वाज आश्रम की यात्रा और वहाँ भरत के साथ उनके पुनर्मिलन को साक्षात् देखा।
            उन्होंने राम के राज्याभिषेक (अभिषेकं) और पूरी पृथ्वी पर उनके सर्वाधिपत्य (साम्राज्य) को स्पष्ट देखा।
            भरत का राम के चरणों में गिरना और राम का उन्हें गले लगाना प्रेम की पराकाष्ठा का एक दिव्य दृश्य था।
            राज्याभिषेक के समय अयोध्या के उत्सव और वेदमंत्रों की गूँज मुनि के कानों में साक्षात् सुनाई दे रही थी।
            वाल्मीकि जी ने देखा कि कैसे राम ने अपने भाइयों और वानरों को उचित सम्मान और अधिकार प्रदान किए।
            'सर्वाधिपत्य' का अर्थ है—राम का प्रभाव केवल अयोध्या नहीं, बल्कि संपूर्ण विश्व के न्याय और नीति पर था।
            भरद्वाज मुनि का आशीर्वाद राम की सफलता पर एक ऋषि की अंतिम और पवित्र मुहर के समान था।
            मुनि ने देखा कि कैसे राम ने राजपद को एक कर्तव्य के रूप में स्वीकार किया, भोग के रूप में नहीं।
            वह सिंहासन अब साक्षात् धर्म का सिंहासन बन चुका था, जिसकी आभा चारों दिशाओं में फैल रही थी।
            नारद जी की भविष्यवाणी अब मुनि की आँखों के सामने एक जीवंत और ऐतिहासिक सत्य बन चुकी थी।
            यह श्लोक रामायण के उस मांगलिक समापन और राम के वैश्विक प्रभुत्व का गौरवशाली वर्णन है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed Rama’s visit to Bharadwaja’s hermitage and His reunion with His brother Bharata.
            He clearly saw the formal coronation (Abhishekam) of Rama and His sovereignty (Sarvadhipatyam) over the earth.
            The sight of Bharata falling at Rama’s feet and Rama embracing him was the divine peak of selfless love.
            The celebrations in Ayodhya and the chanting of Vedic hymns during the ritual resonated in the sage’s ears.
            Valmiki saw how Rama distributed honors and responsibilities to His brothers and the Vanara chiefs.
            'Sarvadhipatyam' implies that Rama’s influence extended beyond Ayodhya to the justice and ethics of the world.
            Sage Bharadwaja’s blessing was like the final, sacred seal of a seer upon Rama’s ultimate success.
            The sage observed how Rama accepted the throne as a sacred duty, completely devoid of any selfish desire.
            The throne had now become the seat of Righteousness itself, its radiance spreading in all four directions.
            Narada’s prophecy had now materialized into a living, historical truth before the spiritual eyes of the sage.
            This verse is a glorious account of the auspicious conclusion and Rama’s undisputed global dominance.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 36,
        sanskrit = "नगरस्य च विन्यासमुत्थानं च राघवस्य च ।\nपुत्राणां च विभवं च लोके रामस्य कीर्तनम् ॥ ३६ ॥",
        hindiCommentary = """
            मुनि ने अयोध्या नगर की नवीन और व्यवस्थित रचना (विन्यासम्) और राम के उत्थान को देखा।
            उन्होंने राम के पुत्रों (लव-कुश) के वैभव (विभवं) और संसार में राम की कीर्ति के विस्तार को देखा।
            अयोध्या का विन्यास ऐसा था कि वहाँ स्वर्ग की पवित्रता और पृथ्वी की समृद्धि का संगम था।
            राम की कीर्ति (कीर्तनम्) केवल एक समय के लिए नहीं, बल्कि अनंत काल के लिए स्थापित हो चुकी थी।
            वाल्मीकि जी ने देखा कि कैसे राम के आदर्शों ने पूरी दुनिया के चरित्र और सोच को बदल दिया था।
            पुत्रों का वैभव उनकी शिक्षा और उनके पिता के प्रति समर्पण में छिपा था, जिसे मुनि ने साक्षात् देखा।
            नगर का हर नागरिक राम-राज्य की उस सुरक्षा और शांति का आनंद ले रहा था, जो अकल्पनीय थी।
            मुनि की दृष्टि अब भविष्य की उन सदियों को देख रही थी जहाँ लोग राम का नाम लेकर उद्धार पाएंगे।
            राम का 'उत्थान' वास्तव में मानवता के आत्म-सम्मान और गौरव का उत्थान था, जिसे मुनि ने जीया।
            यह श्लोक राम के शासन की स्थिरता और उनके वंश की निरंतरता का एक अत्यंत प्रभावशाली चित्रण है।
            मुनि को समझ आ गया था कि यह कथा कभी समाप्त नहीं होगी, यह निरंतर बहती रहने वाली एक नदी है।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the new layout and planning (Vinyasam) of Ayodhya and the rise of Rama’s glory.
            He observed the splendor (Vibhavam) of Rama’s sons and the spreading of Rama’s fame throughout the world.
            The planning of Ayodhya was such that it combined the purity of heaven with the prosperity of the earth.
            Rama’s fame (Kirtanam) was not merely for a temporary epoch but had been established for all eternity.
            Valmiki saw how Rama’s ideals had fundamentally altered the character and thought-process of the world.
            The splendor of His sons was rooted in their education and their total devotion to their father, as seen by the sage.
            Every citizen of the city was relishing the security and peace of Ram-Rajya, which was previously inconceivable.
            The sage’s vision was now observing the future centuries where people would attain salvation through Rama’s name.
            The 'rise' of Rama was actually the elevation of human self-respect and dignity, experienced by the seer.
            This verse is an influential depiction of the stability of Rama’s reign and the continuity of His lineage.
            The sage realized that this story would never truly end; it is a river that will flow unceasingly forever.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 37,
        sanskrit = "विसर्जनं च वानराणां रावणस्य च पातनम् ।\nसर्वं तद्भगवानृषिः चकार चरितं महत् ॥ ३७ ॥",
        hindiCommentary = """
            मुनि ने वानरों की ससम्मान विदाई और रावण के पतन के उन अंतिम रहस्यों को स्पष्ट रूप से देखा।
            भगवान वाल्मीकि ने उस 'महान' (महत्) चरित्र के हर पक्ष को अपनी दिव्य दृष्टि से पूर्णता प्रदान की।
            वानरों का विदा होना अत्यंत भावुक था, जहाँ राम ने हर पशु और जीव के प्रति अपनी कृतज्ञता व्यक्त की।
            रावण का पतन केवल एक युद्ध की घटना नहीं थी, बल्कि यह अहंकार के ऊपर विनय की शाश्वत विजय थी।
            वाल्मीकि जी ने महसूस किया कि अब उनका 'दर्शन' का कार्य पूरा हो चुका है और अब लेखन का समय है।
            'भगवान' शब्द यहाँ मुनि के उस पूर्ण ज्ञान को दर्शाता है जो उन्हें ब्रह्मा की कृपा से प्राप्त हुआ था।
            उन्होंने राम के जीवन को एक ऐसे ग्रंथ में ढाला जो आने वाली पीढ़ियों के लिए एक जीवित शास्त्र बन गया।
            महत् चरित्र का अर्थ है—एक ऐसा जीवन जो हर मानवीय सीमा को पार कर ईश्वरीय मर्यादा में प्रतिष्ठित है।
            मुनि ने सुनिश्चित किया कि कथा का कोई भी कोना उनकी दृष्टि से नहीं छूटा, सब कुछ 'यथातथम्' था।
            यह श्लोक मुनि की तपस्या के फल के रूप में रामायण के 'संपूर्ण' होने की पहली आधिकारिक घोषणा है।
            अब वाल्मीकि के पास वह सारा मसाला (Data) था जिससे वे २४,००० श्लोकों का प्रासाद खड़ा करने वाले थे।
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed the honorable dismissal of the Vanaras and the final secrets of Ravana’s downfall.
            The venerable Valmiki granted completeness to every aspect of that 'Great' (Mahat) character with His vision.
            The departure of the monkeys was deeply emotional, where Rama expressed His gratitude to every creature.
            Ravana’s fall was not just an event of war but the eternal victory of humility over monumental ego.
            Valmiki realized that His phase of 'vision' was now complete, and it was now time for transcription.
            The word 'Bhagavan' denotes the sage's complete knowledge attained through the grace of Lord Brahma.
            He molded Rama’s life into a text that became a living scripture for all generations to come.
            'Mahat Charitam' implies a life that transcends human limitations and is established in divine propriety.
            The sage ensured that no corner of the narrative escaped His vision; everything was 'exactly as it was.'
            This verse is the first formal announcement of the Ramayana's 'completeness' as the fruit of the sage’s penance.
            Valmiki now possessed the entire spiritual data required to build the magnificent edifice of 24,000 verses.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 38,
        sanskrit = "यथावदुक्तं नारदेन तत्सर्वं धर्मविद्विभुः ।\nपश्यति स्म तपोवीर्यात्ततः सर्वं यथातथम् ॥ ३८ ॥",
        hindiCommentary = """
            धर्म के ज्ञाता और समर्थ मुनि ने नारद द्वारा कहे गए उस संपूर्ण वृत्तांत को अपनी आँखों के सामने देखा।
            अपनी तपस्या की शक्ति (तपोवीर्यात्) से उन्होंने सब कुछ 'यथातथम्' (बिल्कुल वैसा ही जैसा हुआ था) देखा।
            नारद के शब्द अब उनके लिए केवल ध्वनियाँ नहीं थीं, बल्कि साक्षात् जीवंत और गतिशील सत्य थे।
            तपोवीर्य वह आत्मिक बल है जो काल के परदे को हटाकर भूतकाल को वर्तमान में बदल देता है।
            वाल्मीकि जी ने अनुभव किया कि नारद की एक-एक बात सत्य की कसौटी पर पूरी तरह से खरी उतर रही थी।
            उन्होंने देखा कि कैसे राम ने हर संकट में धर्म को पकड़े रखा और कभी भी मर्यादा नहीं लांघी।
            मुनि की यह अंतर्दृष्टि रामायण को दुनिया का सबसे विश्वसनीय और प्रामाणिक धर्मग्रंथ बनाती है।
            यह श्लोक सिद्ध करता है कि रामायण की रचना में कोई भी अंश मुनि की कल्पना का हिस्सा नहीं था।
            सत्य का ऐसा प्रत्यक्ष साक्षात्कार ही एक ऋषि को 'कवि' और उसकी वाणी को 'आदि-काव्य' बनाता है।
            मुनि अब उस दिव्य प्रेरणा से पूरी तरह भर चुके थे जो उन्हें लेखन की ऊर्जा प्रदान करने वाली थी।
            यहीं से मुनि की समाधि का वह उच्च शिखर पूर्ण होता है जहाँ से रामायण का शब्दों में अवतरण शुरू हुआ।
        """.trimIndent(),
        englishCommentary = """
            The wise and capable sage witnessed the entire narrative as told by Narada right before his eyes.
            Through the potency of his penance (Tapoviryat), he saw everything 'Yathatatham' (exactly as it happened).
            Narada’s words were no longer mere sounds to him but became living and dynamic truths in his vision.
            'Tapovirya' is the spiritual power that removes the veil of time and transforms the past into the present.
            Valmiki realized that every single detail provided by Narada stood the test of absolute Truth.
            He watched how Rama held onto Dharma in every crisis and never once overstepped His bounds.
            This insight makes the Ramayana the most reliable and authentic scripture in the world.
            This verse proves that no part of the Ramayana was a product of the sage’s mundane imagination.
            Such direct realization of Truth transforms a seer into a 'Poet' and his speech into 'Adi-Kavya.'
            The sage was now fully saturated with the divine inspiration that would fuel his writing.
            The peak of the sage’s meditative trance concludes here, marking the descent of the epic into words.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 39,
        sanskrit = "प्रविवेश अयोध्यां च भरतेन समागतः ।\nइति वाल्मीकिरामायणे बालकाण्डे तृतीयः सर्गः ॥ ३९ ॥",
        hindiCommentary = """
            मुनि ने राम के अयोध्या में प्रवेश और भरत के साथ उनके उस महान और अश्रुपूर्ण मिलन का साक्षात् दर्शन किया।
            भरत ने कैसे खड़ाऊँ सौंपकर राम का स्वागत किया, यह दृश्य मुनि के हृदय को परम शांति देने वाला था।
            इस प्रकार वाल्मीकि रामायण के बालकाण्ड का यह 'तृतीय सर्ग' यहाँ गौरव के साथ सम्पूर्ण होता है।
            यह सर्ग सिद्ध करता है कि वाल्मीकि ने जो कुछ भी लिखा, वह उन्होंने अपनी योग-दृष्टि से स्वयं जिया था।
            अयोध्या का वह उत्सव और राम का राज्याभिषेक मानवता के लिए एक नए युग की आधिकारिक शुरुआत थी।
            मुनि की यह अंतर्यात्रा अब सफल हो चुकी थी, क्योंकि उन्होंने राम के जीवन के हर सत्य को देख लिया था।
            तृतीय सर्ग रामायण के उस 'साक्षी' (Witness) स्वरूप को पुष्ट करता है जिस पर पूरे ग्रंथ का विश्वास टिका है।
            राम और भरत का वह आलिंगन भाईचारे और निस्वार्थ प्रेम की वह पराकाष्ठा थी जिसे दुनिया कभी नहीं भूलेगी।
            वाल्मीकि जी अब उस महाकाव्य को लिपिबद्ध करने के लिए पूरी तरह से मानसिक और आध्यात्मिक रूप से सज्ज थे।
            सृष्टिकर्ता ब्रह्मा की भविष्यवाणी और मुनि का यह साक्षात् दर्शन—दोनों मिलकर इस ग्रंथ को अमर बनाते हैं।
            ॥ तृतीय सर्ग सम्पूर्ण हुआ। सीताराम ॥
        """.trimIndent(),
        englishCommentary = """
            The sage witnessed Rama’s entry into Ayodhya and the grand, tearful reunion with His brother Bharata.
            The scene of Bharata returning the sandals and welcoming Rama brought ultimate peace to the sage’s heart.
            Thus, the 'Third Sarga' of the Baal Kand in the Valmiki Ramayana concludes with immense glory here.
            This chapter proves that whatever Valmiki wrote, he had personally lived through his yogic vision.
            The celebration in Ayodhya and Rama’s coronation marked the formal beginning of a new era for humanity.
            The sage’s internal journey was now successful, for he had perceived every truth of Rama’s life.
            The Third Sarga reinforces the 'Witness' status of the Ramayana upon which the faith of the entire text rests.
            The embrace between Rama and Bharata was the peak of fraternity and selfless love that the world will never forget.
            Valmiki was now fully, mentally, and spiritually prepared to transcribe the monumental epic into verse.
            The prophecy of the Creator Brahma and the sage’s direct vision together render this scripture immortal.
            || Thus ends the Third Sarga. Sita-Ram ||
        """.trimIndent()
    )
)