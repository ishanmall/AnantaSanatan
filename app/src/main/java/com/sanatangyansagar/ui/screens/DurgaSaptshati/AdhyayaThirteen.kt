package com.sanatangyansagar.ui.screens.DurgaSaptshati

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaThirteenScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E1))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val targetId = query.toIntOrNull()
                if (targetId != null) {
                    val targetIndex = adhyayaThirteenShlokas.indexOfFirst { it.id == targetId }
                    if (targetIndex != -1) {
                        coroutineScope.launch {
                            listState.animateScrollToItem(targetIndex)
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka (1-29)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(adhyayaThirteenShlokas) { _, shloka ->
                SaptshatiCard(shloka = shloka)
            }
        }
    }
}

val adhyayaThirteenShlokas = listOf(
    SaptshatiShloka(
        id = 1,
        sanskrit = "ऋषिरुवाच ॥ १ ॥\nएतत्ते कथितं भूप देवीमाहात्म्यमुत्तमम् ।\nएवंप्रभावा सा देवी ययेदं धार्यते जगत् ॥ २ ॥",
        hindi = """
            (ऋषि का उपसंहार): "महर्षि मेधा ने कहा: हे राजन्! मैंने तुम्हें यह उत्तम 'देवी-माहात्म्य' विस्तार से सुना दिया है।"
            "यही वह प्रभाव है उस परम शक्ति का, जिसने इस संपूर्ण ब्रह्मांड को अपने भीतर धारण कर रखा है।"
            "यहाँ 'धार्यते' (धारण करना) शब्द का अर्थ है—वह शक्ति जो हर परमाणु को टूटने से बचाए रखती है।"
            "ऋषि राजा को याद दिला रहे हैं कि जो शक्ति असुरों को मार सकती है, वह तुम्हें जीवन भी दे सकती है।"
            "यह कथा केवल सूचना नहीं थी, बल्कि राजा के 'कन्फ्यूजन' को मिटाने के लिए एक तांत्रिक उपचार था।"
            "जब हम जान लेते हैं कि सत्य कितना शक्तिशाली है, तो हमारी छोटी परेशानियाँ अपने आप फीकी पड़ जाती हैं।"
            "ऋषि यहाँ गुरु की भूमिका निभा रहे हैं जो शिष्य को अज्ञान के अंधेरे से बाहर निकाल लाया है।"
            "सत्य का बोध (Realization) ही वह पहला कदम है जो राजा को अब 'एक्शन' की ओर ले जाएगा।"
            "यह समापन बताता है कि ब्रह्मांड का हर मूवमेंट एक 'डिवाइन इंटेलिजेंस' के तहत हो रहा है।"
            "अब राजा सुरथ का मन पूरी तरह से शांत और देवी की आराधना के लिए तैयार हो चुका है।"
        """.trimIndent(),
        english = """
            (The Sage's Epilogue): "The Sage Medha said: O King! I have narrated this supreme 'Glory of the Goddess' in detail."
            "Such is the power of that Supreme Being who perpetually sustains and holds this entire universe."
            "The word 'Dharyate' (Sustains) implies the energetic force that prevents every atom from disintegrating."
            "The Sage reminds the King that the power which slaughters demons can also rejuvenate human life."
            "This narrative was zero mere information, but a Tantric remedy to dissolve the King's profound confusion."
            "When we comprehend the magnitude of Truth, our petty worldly troubles automatically begin to fade."
            "The Sage acts as the Master who has successfully extracted the seeker from the shadows of ignorance."
            "The realization of Reality is the essential first step that will now drive the King toward Action."
            "This conclusion implies that every microscopic cosmic movement occurs under a singular Divine Intelligence."
            "King Suratha's mind is now entirely stabilized and prepared for the final stage of spiritual practice."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 2,
        sanskrit = "विद्या तथैव क्रियते भगवद्विष्णुमायया ।\nतयैतन्मोह्यते चैव सैव विश्वं प्रसूयते ॥ ३ ॥",
        hindi = """
            (विष्णुमाया का खेल): "वह परम ज्ञान (विद्या) और यह संसार, दोनों भगवान विष्णु की माया से ही निर्मित हैं।"
            "वे ही इस विश्व को मोह में डालती हैं और वे ही इस विश्व को जन्म (प्रसूयते) देती हैं।"
            "यहाँ 'विद्या' और 'अविद्या' (माया) के बीच के उस महीन बैलेंस को समझाया गया है।"
            "माया हमें बांधती है ताकि हम अनुभव ले सकें, और विद्या हमें खोलती है ताकि हम मुक्त हो सकें।"
            "प्रसूयते—ब्रह्मांड का जन्म कोई 'दुर्घटना' (Accident) नहीं, बल्कि एक सुनियोजित 'क्रिएशन' है।"
            "जब तक हम इस खेल को नहीं समझते, हम सुख-दुख के चक्कर में फँसे रहते हैं।"
            "देवी ही वह केंद्र हैं जहाँ से 'भ्रम' और 'जागृति' दोनों की शुरुआत होती है।"
            "यह श्लोक अद्वैत का सार है—कि बांधने वाला और छुड़ाने वाला तत्व वास्तव में एक ही है।"
            "जब हम इस रहस्य को जान लेते हैं, तो हमारा 'कर्ता-भाव' (Doership) हमेशा के लिए गिर जाता है।"
            "राजा अब समझ चुका था कि उसकी हार और जीत—सब उस महामाया का ही एक छोटा सा हिस्सा था।"
        """.trimIndent(),
        english = """
            (The Play of Vishnumaya): "Absolute Wisdom (Vidya) and this world are both manifestations of Lord Vishnu's divine Maya."
            "She alone deludes the entire world, and She alone gives birth to this complex universal structure."
            "This verse explains the delicate balance between 'Vidya' (Knowledge) and 'Avidya' (Illusion/Maya)."
            "Maya binds us to facilitate life experiences, while Vidya liberates us to achieve the ultimate Truth."
            "Prasuyate implies the birth of the cosmos is zero 'Accident', but a highly organized and divine creation."
            "As long as we fail to comprehend this cosmic game, we remain trapped in the cycles of pleasure and pain."
            "The Goddess is the singular axis from which both 'Delusion' and 'Awakening' originate and expand."
            "This verse captures the essence of Non-duality—the binding and liberating forces are mathematically identical."
            "Exactly when we realize this secret, our toxic 'Sense of Doership' collapses and vanishes forever."
            "The King now understood that his defeat and potential victory were merely fractions of Her grand play."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 3,
        sanskrit = "सा याचिता च विज्ञानं तुष्टा ऋद्धिं प्रयच्छति ॥ ४ ॥",
        hindi = """
            (प्रार्थना का फल): "प्रार्थना करने पर वे 'विज्ञान' (परम ज्ञान) देती हैं और प्रसन्न होने पर 'ऋद्धि' (समृद्धि) प्रदान करती हैं।"
            "यहाँ 'याचिता' (मांगना) का अर्थ है—हृदय की वह गहरी तड़प जो ईश्वरीय ऊर्जा को सक्रिय करती है।"
            "विज्ञान (Vijnana) केवल किताबी जानकारी नहीं, बल्कि 'अनुभव' से प्राप्त हुआ आत्मज्ञान है।"
            "ऋद्धि (Prosperity) का अर्थ है—जीवन में आने वाली वह सफलता जो पवित्र और स्थायी होती है।"
            "यह श्लोक बताता है कि देवी हमारे आध्यात्मिक और भौतिक—दोनों ही विकास की स्वामिनी हैं।"
            "जब मन शुद्ध होता है, तो मांगना 'लालच' नहीं, बल्कि एक 'संकल्प' (Resolution) बन जाता है।"
            "देवी की प्रसन्नता (Praseeda) ही वह चाबी है जो किस्मत के बंद दरवाजों को खोल देती है। "
            "अगर हमें शांति चाहिए तो विज्ञान मांगें, और अगर संसार में न्याय चाहिए तो ऋद्धि मांगें।"
            "भगवान कभी खाली हाथ नहीं भेजते, वे हमेशा भक्त की पात्रता के हिसाब से फल देते हैं।"
            "राजा और वैश्य अब समझ चुके थे कि उन्हें अपनी इच्छाओं के लिए अब क्या करना है।"
        """.trimIndent(),
        english = """
            (The Fruit of Petition): "Upon being petitioned, She bestows 'Vijnana' (Wisdom), and when pleased, She grants 'Riddhi' (Prosperity)."
            "'Yachita' (Requesting) implies that deep internal longing which activates the flow of Divine Energy."
            "Vijnana is zero mere theoretical data; it is the absolute Self-Realization achieved through direct experience."
            "Riddhi (Prosperity) refers to that form of success which is spiritually aligned and perpetually stable."
            "This verse proves that the Goddess governs both our spiritual evolution and our material well-being."
            "When the mind is purified, requesting is zero 'Greed', but becomes a focused cosmic 'Resolution'."
            "The pleasure of the Mother is the singular key that unlocks the absolute floodgates of human destiny."
            "Seek 'Vijnana' if You desire eternal peace, and seek 'Riddhi' if You desire to establish worldly justice."
            "God mathematically never returns a seeker empty-handed; She provides strictly according to spiritual eligibility."
            "The King and the Merchant now clearly realized the exact steps required to manifest their desires."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 4,
        sanskrit = "मार्कण्डेय उवाच ॥ ५ ॥\nइति तस्य वचः श्रुत्वा सुरथः स नराधिपः ।\nप्रणिपत्य महाभागं तमृषिं शंसितव्रतम् ॥ ६ ॥",
        hindi = """
            (राजा का गुरु को प्रणाम): "मार्कण्डेय जी ने कहा: महर्षि मेधा के इन वचनों को सुनकर, राजा सुरथ ने उन्हें प्रणाम किया।"
            "वे ऋषि अत्यंत 'महाभाग' (भाग्यशाली) और 'शंसितव्रत' (कठोर तपस्वी) थे, जिन्हें राजा ने नमन किया।"
            "प्रणिपत्य (झुकना)—यह अहंकार के पूरी तरह विसर्जित होने का पहला शारीरिक संकेत है।"
            "राजा अब 'नराधिप' (इंसानों का मालिक) होकर भी एक 'गुरु' के चरणों में साधारण शिष्य की तरह बैठा था।"
            "ज्ञान प्राप्त करने के बाद कृतज्ञता (Gratitude) प्रकट करना आध्यात्मिक प्रगति के लिए अनिवार्य है।"
            "शंसितव्रत—ऋषि की तपस्या ने ही उनके शब्दों में वह शक्ति भरी थी जिसने राजा का डिप्रेशन दूर किया।"
            "गुरु के प्रति सम्मान ही वह माध्यम है जिससे मिला हुआ ज्ञान जीवन में 'स्थिर' (Permanent) होता है।"
            "जब हम झुकते हैं, तो हम अपनी चेतना को उस 'हायर नॉलेज' के रिसीविंग मोड (Receiving mode) में लाते हैं।"
            "मार्कण्डेय जी यहाँ पूरी कथा को एक 'ब्रह्मांडीय साक्षी' (Cosmic Witness) के रूप में सुना रहे हैं।"
            "अब राजा सुरथ अपने अगले मिशन के लिए गुरु से विदा लेने और साधना शुरू करने वाले थे।"
        """.trimIndent(),
        english = """
            (The King Bows to the Master): "Markandeya said: Hearing the words of Sage Medha, King Suratha bowed down before him."
            "He offered his respects to that highly blessed Sage, who was famous for his strict and holy penance."
            "The act of 'Pranipatya' (Bowing) is the primary physical signal of the absolute dissolution of the Ego."
            "The King, despite being a 'Niradhipa' (Ruler of men), sat like a simple disciple at the Master's feet."
            "Expressing Gratitude after receiving Wisdom is a mathematical necessity for achieving spiritual progress."
            "The term 'Shamsita-vrata' implies that the Sage's words carried the weight of his own profound Tapasya."
            "Respect for the Master is the singular medium that renders the received knowledge Permanent in one's life."
            "By bowing, we calibrate our consciousness into the 'Receiving Mode' of the absolute Higher Knowledge."
            "Markandeya is narrating this entire history from the perspective of an absolute 'Cosmic Witness'."
            "Now King Suratha prepared to depart from the hermitage to initiate his personal spiritual mission."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 5,
        sanskrit = "निर्विण्णोऽतिममत्वेन राज्यापहरणेन च ।\nजगाम सद्यस्तपसे स च वैश्यो महामुने ॥ ७ ॥",
        hindi = """
            (तपस्या के लिए प्रस्थान): "राज्य छिन जाने के दुख और 'अत्यधिक मोह' (ममत्व) से परेशान होकर।"
            "वह राजा और वह वैश्य, दोनों तुरंत 'तपस्या' (तपसे) करने के लिए वन की ओर निकल पड़े।"
            "निर्विण्णः (Detached/Frustrated)—संसार की ठोकर ही अक्सर इंसान को ईश्वर के रास्ते पर लाती है।"
            "ममत्व (Attachment)—राजा और वैश्य समझ चुके थे कि उनका दुख उनकी 'चीज़ों से पकड़' के कारण था।"
            "सद्यः (तुरंत)—जब ज्ञान होता है, तो साधना शुरू करने में एक पल की भी देरी नहीं करनी चाहिए।"
            "वन (Forest) जाना वास्तव में अपनी 'अंतरात्मा' के एकांत में प्रवेश करने का एक भौतिक प्रतीक है।"
            "अहंकार और ममता को मिटाने के लिए 'तप' (Heat/Discipline) की अग्नि बहुत ज़रूरी होती है।"
            "यह श्लोक बताता है कि मुश्किल समय ही इंसान के 'इवोल्यूशन' (Evolution) का सबसे बड़ा अवसर होता है।"
            "राजा ने अब अपनी तलवार छोड़कर 'तपस्या का दण्ड' हाथ में ले लिया था।"
            "साधना ही वह एकमात्र तरीका है जिससे 'डेस्टिनी' (Destiny) को दोबारा लिखा जा सकता है।"
        """.trimIndent(),
        english = """
            (Departure for Penance): "Deeply distressed by the loss of his empire and the burden of 'Excessive Attachment' (Mamatva)."
            "The King and the Merchant instantaneously departed toward the forest to perform intense 'Penance' (Tapase)."
            "'Nirvinnah' implies that worldly frustration often serves as the primary catalyst for spiritual seeking."
            "Mamatva (Possessiveness) was recognized by them as the absolute root cause of their psychological suffering."
            "'Sadyah' (Immediately) teaches that once Wisdom is received, there must be zero delay in starting the practice."
            "Traveling to the forest is a physical symbol of entering the absolute solitude of one's own 'Inner Soul'."
            "To terminate Arrogance and Attachment, the fire of 'Tapas' (Discipline) is mathematically required."
            "This verse proves that periods of extreme hardship are the greatest opportunities for human Evolution."
            "The King had now traded his physical sword for the absolute spiritual rod of disciplined meditation."
            "Spiritual practice is the singular method through which a human can successfully rewrite their own Destiny."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 6,
        sanskrit = "संदर्शनार्थमम्बाया नदीपुलिनमास्थितः ।\nस च वैश्यस्तपस्तेपे देवीसूक्तं परं जपन् ॥ ८ ॥",
        hindi = """
            (नदी तट पर साधना): "वे दोनों जगदम्बा के दर्शन की इच्छा से एक नदी के तट (नदीपुलिनम्) पर बैठ गए।"
            "वहाँ वह वैश्य और राजा, दोनों 'देवी-सूक्त' का परम जप करते हुए भयंकर तपस्या करने लगे।"
            "नदी तट (Riverbank) मन के प्रवाह और चेतना की 'निरंतरता' का प्रतीक माना जाता है।"
            "देवी-सूक्त (Devi Suktam) वह वेदमंत्र है जो इंसान को यह अहसास कराता है कि वह खुद भी ईश्वर का अंश है।"
            "जप (Chanting) करना मन के 'शोर' को एक ही फ्रीक्वेंसी पर स्थिर करने की एक तांत्रिक तकनीक है।"
            "तपस्तेपे—तपस्या का अर्थ है अपनी इंद्रियों को बाहरी दुनिया से हटाकर अंदर की ओर मोड़ना।"
            "राजा और वैश्य का एक साथ बैठना यह दिखाता है कि सत्य की खोज में 'पद' (Status) का कोई महत्व नहीं है।"
            "दर्शन की इच्छा (Longing)—जितनी गहरी भक्त की प्यास होगी, उतनी ही जल्दी ईश्वर का प्रकटीकरण होगा।"
            "नदी का पानी मन की 'शुद्धि' और भावनाओं के 'बहाव' को शांत करने का इशारा करता है।"
            "अब उनके जीवन का एकमात्र लक्ष्य केवल और केवल 'महामाया' का साक्षात्कार करना था।"
        """.trimIndent(),
        english = """
            (Meditation on the Riverbank): "Desiring the vision of the Mother, they established themselves upon the sacred banks of a river."
            "The Merchant and the King initiated intense penance while continuously chanting the supreme 'Devi Suktam'."
            "The Riverbank flawlessly symbolizes the 'Flow of Mind' and the absolute continuity of pure consciousness."
            "Devi Suktam is the Vedic hymn that makes a human realize they are strictly a fraction of the Divine Being."
            "Chanting (Japa) is a scientific technique to stabilize mental 'Noise' onto a singular high cosmic frequency."
            "Tapas (Penance) implies withdrawing one's biological senses from the world and directing them Inward."
            "The King and the Merchant sitting together proves that 'Status' holds zero value in the hunt for Truth."
            "The Longing (Sandarshana-artham) determines the absolute speed at which the Divine Manifestation occurs."
            "The flowing river indicates the constant 'Purification' of thoughts and the calming of erratic emotions."
            "Their existence now possessed a singular, absolute target: the direct realization of the Supreme Mahamaya."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 7,
        sanskrit = "तस्थौ स तत्र पुलिने देव्याः कृत्वा महीमयीम् ।\nमूर्तिं ततश्चक्रतुः पूजां पुष्पधूपान्नतर्पणैः ॥ ९ ॥",
        hindi = """
            (मिट्टी की मूर्ति और पूजा): "उन्होंने नदी के तट पर मिट्टी (महीमयीम्) से देवी की एक सुंदर मूर्ति बनाई।"
            "और फिर वे दोनों पुष्प, धूप और अर्घ्य के द्वारा उस मूर्ति की विधिपूर्वक पूजा करने लगे।"
            "मिट्टी की मूर्ति (Clay Image) हमारे 'शरीर' और 'पृथ्वी तत्व' का प्रतीक है, जिसे हम दिव्य बनाना चाहते हैं।"
            "मूर्ति बनाना अज्ञानी मन को एक 'फोकस पॉइंट' (Focus Point) देने का एक मनोवैज्ञानिक तरीका है।"
            "पूजा (Worship) कोई बाहरी कर्मकांड नहीं, बल्कि श्रद्धा के साथ अपनी ऊर्जा को मूर्ति में 'प्रोजेक्ट' करना है।"
            "पुष्प (Flowers) हमारी कोमल भावनाओं का, और धूप हमारे जलते हुए 'अहंकार' का प्रतीक है।"
            "तर्पण (Offerings) का अर्थ है—अपने पास जो कुछ भी है, उसे ईश्वर के चरणों में समर्पित कर देना।"
            "जब हम हाथ से मूर्ति बनाते हैं, तो हमारा 'सृजन' (Creation) ईश्वर के प्रति प्यार में बदल जाता है।"
            "यह श्लोक 'सगुण भक्ति' की शक्ति को दर्शाता है, जहाँ निराकार ईश्वर को एक रूप दिया जाता है।"
            "अब उनकी साधना में वह 'एकाग्रता' आ चुकी थी जो किसी भी चमत्कार को जन्म दे सकती थी।"
        """.trimIndent(),
        english = """
            (The Clay Image and Worship): "Upon the riverbank, they constructed a beautiful image of the Goddess utilizing common 'Earth' (Clay)."
            "And then both initiated a ritualistic worship utilizing flowers, incense, and various sacred offerings."
            "The Clay Image (Mahimayim) symbolizes our 'Physical Body' and the earth element being sanctified."
            "Constructing an idol is a psychological method to provide the wandering mind with a singular Focus Point."
            "Worship is zero mere external ritual; it is the act of 'Projecting' one's vital energy into the divine form."
            "Flowers represent tender human emotions, while Incense symbolizes the burning away of the toxic Ego."
            "Tarpana (Offerings) implies surrendering everything one possesses to the absolute Source of Existence."
            "The act of creating with one's own hands transforms 'Creativity' into a profound expression of Love."
            "This verse demonstrates the power of 'Saguna Bhakti', where the formless Divine is given a physical shape."
            "Their spiritual practice had now achieved that intensity capable of triggering a cosmic manifestation."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 8,
        sanskrit = "निराहारौ यताहारौ तन्मनस्कौ समाहितौ ।\nददतुस्तौ बलिं चैव निजगात्रासृगुक्षितम् ॥ १० ॥",
        hindi = """
            (कठोर तपस्या और रक्त बलि): "वे कभी निराहार (बिना भोजन) रहते और कभी अत्यंत संयमित भोजन (यताहारौ) करते थे।"
            "उनका मन पूरी तरह देवी में लीन (तन्मनस्कौ) था और वे अपने 'शरीर के रक्त' (गात्रासृक्) से बलि देते थे।"
            "यताहारौ (Food Control)—भोजन पर नियंत्रण वास्तव में अपनी 'इच्छाओं' पर कंट्रोल करने का पहला कदम है।"
            "तन्मनस्कौ—यह वह अवस्था है जहाँ 'साधक' और 'साध्य' के बीच की दूरी पूरी तरह खत्म हो जाती है।"
            "रक्त की बलि (Blood Offering)—यह कोई हिंसक कृत्य नहीं, बल्कि अपनी 'अंतिम आसक्ति' (Life-force) का समर्पण है।"
            "खून इंसान की 'अस्तित्व की गहराई' का प्रतीक है; उसे देना मतलब—'माँ, मेरा जीवन भी आपका ही है'।"
            "जब साधना इस स्तर पर पहुँचती है कि इंसान खुद को मिटाने को तैयार हो जाए, तभी 'ईगो' मरता है।"
            "समाहितौ (Composed)—वे विचलित नहीं थे, बल्कि एक 'लेज़र-शार्प' फोकस के साथ अपनी तपस्या में डटे थे।"
            "यह श्लोक 'एक्स्ट्रीम डेडीकेशन' (Extreme Dedication) का चित्रण है जो ब्रह्मांड को हिलाने की ताकत रखता है।"
            "अब उनकी तीन वर्षों की कठोर साधना अपने 'क्लाइमेक्स' (Climax) की ओर पहुँच चुकी थी।"
        """.trimIndent(),
        english = """
            (Intense Penance and Blood Sacrifice): "They remained occasionally without food and sometimes followed a strictly controlled diet."
            "Their minds were entirely absorbed in the Goddess, and they offered oblations smeared with their own 'Blood'."
            "Controlled Diet (Yataharou) is the fundamental first step toward achieving absolute mastery over one's desires."
            "Tan-manaskou describes that state where the distance between the seeker and the Divine entirely dissolves."
            "Blood Sacrifice in this context is zero violent act, but the symbolic surrender of one's absolute 'Life-Force'."
            "Blood represents the absolute 'Depth of Existence'; offering it means—'Mother, my life belongs to You'."
            "Exactly when practice reaches a level where the seeker is ready to dissolve themselves, the Ego dies."
            "Samahitou (Composed) implies they possessed a laser-sharp focus that remained unshakeable through the trial."
            "This verse illustrates 'Extreme Dedication', which possesses the mathematical power to shake the entire cosmos."
            "Their three years of rigorous spiritual labor were now rapidly approaching their absolute final Climax."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 9,
        sanskrit = "एवं समाराधयतोस्त्रिभिर्वर्षैर्यतचतोः ।\nपरितुष्टा जगद्धात्री प्रत्यक्षं प्राह चण्डिका ॥ ११ ॥",
        hindi = """
            (देवी का प्रकटीकरण): "इस प्रकार तीन वर्षों (त्रिभिर्वर्षैः) तक निरंतर और कठोर आराधना करने के बाद।"
            "जगत का पालन करने वाली माता चण्डिका उन पर पूरी तरह प्रसन्न (परितुष्टा) हो गईं।"
            "देवी ने साक्षात् 'प्रत्यक्ष' (Manifested) होकर उनके सामने दर्शन दिए और मधुर वाणी में उनसे कहा।"
            "तीन वर्ष (3 Years)—यह समय 'धैर्य' (Patience) की उस परीक्षा का प्रतीक है जो हर बड़े बदलाव के लिए ज़रूरी है।"
            "जगद्धात्री—वे ही पूरे ब्रह्मांड को थामे हुए हैं, और आज वे अपने दो बच्चों के लिए सामने खड़ी थीं।"
            "प्रत्यक्ष होना (Physical Appearance)—यह सिद्ध करता है कि अगर पुकार सच्ची हो, तो एनर्जी साकार हो जाती है।"
            "प्रसन्नता (Pleasure)—भगवान की प्रसन्नता ही इंसान के दुखों का 'अंतिम इलाज' (Ultimate Cure) है।"
            "आराधना (Worship) जब आदत बन जाती है, तभी वह 'साक्षात्कार' (Realization) में बदलती है।"
            "राजा और वैश्य की आँखों के सामने अब वह 'महाप्रकाश' था जिसकी वे हज़ारों सालों से तलाश कर रहे थे।"
            "यह पल उनके जीवन के अंधकार के हमेशा के लिए मिट जाने का सबसे बड़ा गवाह था।"
        """.trimIndent(),
        english = """
            (The Manifestation of the Mother): "After performing continuous and rigorous worship for a period of exactly 'Three Years'."
            "Mother Chandika, the absolute sustainer of the universe (Jagaddhatri), became entirely pleased with them."
            "The Goddess 'Manifested' (Pratyaksham) physically before them and spoke in an exceptionally sweet tone."
            "Three Years symbolize the necessary test of 'Patience' required for any profound psychological transformation."
            "Jagaddhatri implies She holds the entire cosmos, yet She stood personally for Her two dedicated children."
            "Physical Manifestation proves that when the internal call is authentic, Energy systematically assumes a Form."
            "Divine Pleasure (Paritushta) is the absolute 'Ultimate Cure' for the collective suffering of a human being."
            "Worship systemically transforms into direct 'Realization' strictly only when it becomes a consistent way of life."
            "Before the King and the Merchant stood that 'Supreme Light' they had hunted across multiple lifetimes."
            "This exact moment was the absolute testimony to the permanent erasure of darkness from their existence."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 10,
        sanskrit = "देव्युवाच ॥ १२ ॥\nयत्प्रार्थ्यते त्वया भूप त्वया च कुलनन्दन ।\nमत्तस्तत्प्राप्यतां सर्वं परितुष्टा ददामि तत् ॥ १३ ॥",
        hindi = """
            (वरदान देने का वचन): "देवी ने कहा: 'हे राजन्! और हे अपने कुल को आनंद देने वाले वैश्य! सुनो'।"
            "'तुम दोनों जो कुछ भी मुझसे 'प्रार्थना' (प्रार्थ्यते) कर रहे हो, वह सब मुझसे प्राप्त कर लो'।"
            "'मैं तुम दोनों पर पूरी तरह प्रसन्न हूँ और तुम्हारी हर इच्छा को आज पूरा करती हूँ'।"
            "देवी यहाँ एक 'कम्पैशनेट मदर' (Compassionate Mother) की तरह बात कर रही हैं, जो सब कुछ देने को तैयार है।"
            "भूप (King) और कुलनन्दन (Merchant)—देवी ने दोनों को बराबर का सम्मान और प्यार दिया।"
            "प्रार्थ्यते (Desired)—ईश्वर जानता है कि हमारे मन में क्या है, पर उसे 'प्रकट' करना हमारी ज़िम्मेदारी है।"
            "ददामि (मैं देती हूँ)—यह ब्रह्मांड का सबसे बड़ा 'एश्योरेंस' (Assurance) है कि मेहनत कभी बेकार नहीं जाती।"
            "जब हम अपनी सारी नेगेटिविटी (बलि) दे देते हैं, तभी हम 'वरदान' पाने के पात्र बनते हैं।"
            "देवी का स्वर इतना कोमल था कि उसने राजा और वैश्य के सारे पुराने ज़ख्मों को एक पल में भर दिया।"
            "अब उन दोनों को अपनी-अपनी मांग देवी के सामने रखनी थी—एक को साम्राज्य चाहिए था, दूसरे को शांति।"
        """.trimIndent(),
        english = """
            (The Promise to Grant Boons): "The Goddess said: 'O King! And O Merchant who brings joy to your lineage! Listen carefully'."
            "'Whatever it is that You are 'Praying' (Prarthyate) for, receive all of that from Me today'."
            "'I am completely satisfied with both of You and I grant absolutely all Your desires right now'."
            "The Goddess is speaking identically like a 'Compassionate Mother', ready to provide infinite abundance."
            "By addressing them as King and Merchant, She provides equal dignity and love to both types of seekers."
            "Prarthyate implies that while God knows our heart, 'Expressing' the desire is our personal responsibility."
            "'I Grant' (Dadami) is the universe's absolute greatest 'Assurance' that sincere effort is never wasted."
            "Only after we surrender our entire negativity (Sacrifice) do we become eligible to receive a 'Boon'."
            "The Mother's voice was so tender that it instantaneously healed absolutely all their ancient psychological wounds."
            "Now both were required to present their specific requests—one sought an empire, the other sought peace."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 11,
        sanskrit = "मार्कण्डेय उवाच ॥ १४ ॥\nततो वव्रे नृपो राज्यं अविभ्रंश्यन्यजन्मनि ।\nअत्रैव च निजं राज्यं हतशत्रुबलं बलात् ॥ १५ ॥",
        hindi = """
            (राजा का वरदान): "मार्कण्डेय जी ने कहा: तब राजा सुरथ ने 'अविनाशी' (अविभ्रंशि) राज्य का वरदान माँगा।"
            "उन्होंने माँगा कि इसी जन्म में मुझे मेरा खोया हुआ राज्य 'बलपूर्वक' (बलात्) वापस मिल जाए।"
            "और अगले जन्म में भी मुझे एक ऐसा साम्राज्य मिले जो कभी नष्ट न हो सके।"
            "राजा का यह वरदान उसकी 'क्षत्रिय' प्रकृति और 'कर्तव्य' (Duty) के प्रति उसके लगाव को दर्शाता है।"
            "निजं राज्यं—खोया हुआ राज्य वास्तव में इंसान के 'आत्म-सम्मान' (Self-respect) का प्रतीक है।"
            "हतशत्रुबलं—शत्रुओं का नाश होना मतलब बाधाओं का पूरी तरह से क्लीन-अप (Clean-up) हो जाना।"
            "अविभ्रंशि (Unshakable)—राजा अब एक ऐसी सत्ता चाहता था जो केवल 'डर' पर नहीं, बल्कि 'धर्म' पर टिकी हो।"
            "यह वरदान दर्शाता है कि भौतिक सफलता पाना गलत नहीं है, यदि वह 'देवी की कृपा' से मिली हो।"
            "राजा सुरथ का 'ईगो' अब 'पवित्र' हो चुका था, इसलिए वे अब एक बेहतर 'लीडर' बनने के योग्य थे।"
            "माता ने मुस्कुराकर उनके इस क्षत्रिय संकल्प को अपनी स्वीकृति प्रदान कर दी।"
        """.trimIndent(),
        english = """
            (The King's Request): "Markandeya said: Then King Suratha requested the boon of an 'Indestructible' (Avibhranshi) kingdom."
            "He asked to regain his lost empire in this very life by 'Force' (Balat) after annihilating his enemies."
            "And he also requested an eternal empire in his next incarnation that could mathematically never perish."
            "The King's request reflects his 'Kshatriya' nature and his profound commitment to his royal 'Duty'."
            "His 'Own Kingdom' (Nijam Rajyam) symbolizes the restoration of human 'Self-respect' and internal dignity."
            "Slaughtering the enemy's strength implies the complete 'Clean-up' of all obstacles in his path of progress."
            "Unshakable (Avibhranshi)—The King now sought an authority based on 'Dharma' rather than just 'Terror'."
            "This boon proves that seeking material success is zero sin if it is achieved through 'Divine Grace'."
            "King Suratha's ego had been 'Purified', rendering him eligible to become an exceptionally superior 'Leader'."
            "The Mother smiled and provided Her absolute approval to this righteous and powerful warrior resolve."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 12,
        sanskrit = "सोऽपि वैश्यस्ततो ज्ञानं वव्रे निर्विण्णमानसः ।\nममेत्यहमिति प्राज्ञः सङ्गविच्युतिकारकम् ॥ १६ ॥",
        hindi = """
            (वैश्य का वरदान): "उधर उस बुद्धिमान वैश्य ने, जिसका मन संसार से विरक्त (निर्विण्णमानसः) हो चुका था, 'ज्ञान' माँगा।"
            "उसने एक ऐसा बोध माँगा जो 'मम' (मेरा) और 'अहम्' (मैं) जैसे मोह के बंधनों को जड़ से काट दे।"
            "सङ्गविच्युतिकारकम्—यह वह 'अटैचमेंट' से मुक्ति है जो इंसान को हर दुख से आज़ाद कर देती है।"
            "वैश्य (Samadhi) ने राजा के विपरीत 'बाहरी' साम्राज्य नहीं, बल्कि 'आंतरिक' साम्राज्य (शान्ति) माँगा।"
            "ममेत्यहमिति—'मैं' और 'मेरा' ही वह ज़हर है जो हमें जन्म-मृत्यु के चक्र में फँसाए रखता है।"
            "प्राज्ञः (Wise)—मार्कण्डेय जी ने उसे 'ज्ञानी' कहा क्योंकि उसने असली हीरे (मोक्ष) की पहचान कर ली थी।"
            "जब संसार की कड़वाहट (निर्विण्ण) हद से बढ़ती है, तभी इंसान 'सच्चे ज्ञान' की कीमत समझता है।"
            "यह वरदान 'अद्वैत' की उस अवस्था का है जहाँ इंसान खुद को ब्रह्मांड से अलग नहीं मानता।"
            "वैश्य की मांग यह सिद्ध करती है कि 'शांति' दुनिया के किसी भी सोने-चांदी से कहीं ज़्यादा कीमती है।"
            "माता चण्डिका यह देखकर अत्यंत प्रसन्न हुईं कि उनके एक भक्त ने साक्षात् 'मुक्ति' को चुना है।"
        """.trimIndent(),
        english = """
            (The Merchant's Request): "Meanwhile, that wise Merchant, whose mind was detached from the world, requested the boon of 'Wisdom'."
            "He sought that realization which severs the chains of 'I' (Aham) and 'Mine' (Mama) from their absolute roots."
            "'Sangha-vichyuti' signifies the termination of 'Attachment', which liberates a human from all possible suffering."
            "The Merchant requested zero 'External' empire, but strictly sought the 'Internal' empire of profound Peace."
            "'I' and 'Mine' are the psychological poisons that keep us perpetually trapped in the cycle of birth and death."
            "Wise (Prajnah)—Markandeya addressed him as wise because he successfully identified the authentic diamond: Moksha."
            "Only when worldly bitterness reaches its peak does a human truly comprehend the value of 'Absolute Wisdom'."
            "This boon represents the state of 'Non-duality' where a human ceases to perceive themselves as separate from the All."
            "The Merchant's request proves that Peace is mathematically infinitely more valuable than all the gold in existence."
            "Mother Chandika was extremely pleased to witness one of Her children choosing absolute 'Liberation' over temporary gains."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 13,
        sanskrit = "देव्युवाच ॥ १७ ॥\nस्वल्पैरहोभिर्नृपते स्वं राज्यं प्राप्स्यते भवान् ।\nहत्वा रिपूनस्खलितं तव तत्र भविष्यति ॥ १८ ॥",
        hindi = """
            (राजा को आशीर्वाद): "देवी ने कहा: 'हे राजन्! बहुत ही कम दिनों (स्वल्पैरहोभिः) में तुम्हें तुम्हारा राज्य वापस मिल जाएगा'।"
            "'तुम अपने सभी शत्रुओं को मारकर अपने अजेय और 'अस्खलित' (स्थिर) साम्राज्य का भोग करोगे'।"
            "स्वल्पैरहोभिः (कुछ ही दिनों में)—यह दिखाता है कि जब दैवीय शक्ति साथ हो, तो समय का पहिया तेज़ी से घूमता है।"
            "अस्खलितं—अब राजा का राज्य केवल ज़मीन का टुकड़ा नहीं, बल्कि 'धर्म' की एक अटूट व्यवस्था होगा।"
            "देवी राजा को कर्म करने की 'अनुमति' (Permission) दे रही हैं, जो उसके आत्मविश्वास को करोड़ों गुना बढ़ा देती है।"
            "शत्रुओं का मरना (हत्वा रिपून) अज्ञान के उन सभी बाहरी रूपों का अंत है जो राजा को परेशान कर रहे थे।"
            "यह वरदान यह सिद्ध करता है कि भगवान हमारी 'नेचुरल टेंडेंसी' (Kshatriya Nature) का सम्मान करते हैं।"
            "सत्य की जीत केवल मंदिर में नहीं, बल्कि 'राजनीति' और 'राजकाज' में भी होनी ज़रूरी है।"
            "राजा सुरथ को अब वह 'अथॉरिटी' मिल चुकी थी जिसे दुनिया की कोई भी ताकत अब छीन नहीं सकती थी।"
            "माता का यह वचन राजा के लिए एक 'नई सुबह' का सूरज बनकर चमका था।"
        """.trimIndent(),
        english = """
            (Boon to the King): "The Goddess said: 'O King! In strictly a few days (Svalpair-ahobhih), You shall regain Your empire'."
            "'After slaughtering Your enemies, You shall enjoy an unshakeable and 'Askhaliatam' (Stable) sovereign rule'."
            "In strictly a few days—This proves that when Divine Energy is active, the wheel of Time accelerates exponentially."
            "Askhaliatam implies the King's rule will zero be a mere piece of land, but an unbreakable system of Dharma."
            "The Mother is granting the King the 'Permission' to act, which multiplies his self-confidence by millions."
            "Slaughtering enemies refers to the termination of all external manifestations of ignorance troubling the King."
            "This boon proves that God respects our 'Natural Tendency' and inherent biological and social archetypes."
            "The victory of Truth must manifest zero merely in temples, but within 'Governance' and 'Leadership' as well."
            "King Suratha had now received that absolute 'Authority' which zero worldly power could mathematically snatch again."
            "The Mother's word shone like the sun of a brand-new morning for the resurrected warrior spirit of the King."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 14,
        sanskrit = "मृतश्च भूयः सम्प्राप्य जन्म देवाद्विवस्वतः ।\nसावर्णिको नाम मनुर्भवान् भुवि भविष्यति ॥ १९ ॥",
        hindi = """
            (अगले जन्म की भविष्यवाणी): "'और मृत्यु के बाद, तुम सूर्य देव (विवस्वतः) के अंश से दोबारा जन्म लोगे'।"
            "'तब इस पृथ्वी पर तुम 'सावर्णि' (Savarni) नाम के आठवें 'मनु' बनकर पूरे ब्रह्मांड पर शासन करोगे'।"
            "यह श्लोक 'इटरनल रिवॉर्ड' (Eternal Reward) का प्रतीक है—सच्ची भक्ति का फल कई जन्मों तक चलता है।"
            "सावर्णि मनु—मनु वह 'कॉस्मिक लीडर' होता है जो एक पूरे युग (Manvantara) की चेतना को गाइड करता है।"
            "देवी ने राजा को केवल एक 'छोटा राज्य' नहीं दिया, बल्कि उसे 'ब्रह्मांडीय इतिहास' का हिस्सा बना दिया।"
            "सूर्यपुत्र होना 'तेज़' और 'प्रकाश' के साथ जुड़ने का प्रतीक है, जहाँ अज्ञान की कोई जगह नहीं होती।"
            "यह भविष्यवाणी हमें सिखाता है कि जो हम आज 'बोते' (साधना) हैं, उसे हम युगों तक 'काटते' हैं।"
            "राजा सुरथ की यात्रा एक 'हारे हुए योद्धा' से शुरू हुई थी और एक 'मनु' (Creator/Leader) पर खत्म हुई।"
            "यह इंसान के 'सेल्फ-इवोल्यूशन' (Self-Evolution) की सबसे ऊँची और गौरवशाली कहानी है।"
            "अब राजा का भविष्य सूर्य की तरह चमक रहा था और उनका डर हमेशा के लिए दफन हो चुका था।"
        """.trimIndent(),
        english = """
            (Prophecy of the Next Life): "'And after Your death, You shall be reborn through the divine essence of the Sun God (Vivasvan)'."
            "'Then You shall manifest on Earth as the eighth 'Manu' named 'Savarni', ruling over the entire creation'."
            "This verse symbolizes the 'Eternal Reward'—proving that the fruits of authentic devotion span multiple lifetimes."
            "Savarni Manu—A Manu is a 'Cosmic Leader' who guides the collective consciousness of an entire era (Manvantara)."
            "The Goddess did zero merely grant him a 'Small Kingdom'; She made him an integral part of 'Cosmic History'."
            "Being a son of the Sun symbolizes a union with 'Radiance' and 'Light', where zero space remains for ignorance."
            "This prophecy teaches that what we 'Sow' today (Practice), we mathematically 'Reap' for countless ages."
            "King Suratha's journey initiated as a 'Defeated Warrior' and successfully concluded as a 'Manu' (Creator/Guide)."
            "This represents the absolute highest and most glorious narrative of human and spiritual 'Self-Evolution'."
            "The King's future was now radiating like the sun, and his psychological fear was buried for all eternity."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 15,
        sanskrit = "वैश्यवर्य त्वया यश्च वरोऽस्मत्तोऽभिवाञ्छितः ।\nतं प्रयच्छामि संसिद्ध्यै तव ज्ञानं भविष्यति ॥ २० ॥",
        hindi = """
            (वैश्य को आशीर्वाद): "देवी ने वैश्य से कहा: 'हे श्रेष्ठ वैश्य! तुमने जो वरदान मुझसे माँगा है'।"
            "'मैं उसे भी पूर्ण करती हूँ; तुम्हें वह 'परम ज्ञान' (Moksha) प्राप्त होगा जो जन्म-मरण से आज़ाद करता है'।"
            "वैश्यवर्य (Best of Merchants)—देवी ने उसकी 'पात्रता' को पहचाना क्योंकि उसने 'अस्थायी' की जगह 'शाश्वत' को चुना।"
            "संसिद्ध्यै (For Perfection)—यह वह ज्ञान है जो इंसान को 'परफेक्ट' (Perfect) और 'कम्प्लीट' (Complete) बना देता है।"
            "देवी यहाँ साक्षात् 'सरस्वती' और 'ब्रह्म-विद्या' बनकर वैश्य के हृदय में उतर रही थीं।"
            "यह वरदान सिद्ध करता है कि ईश्वर हर भक्त की 'अलग' ज़रूरत को समझते हैं और उसे वही देते हैं।"
            "राजा को 'पावर' मिली और वैश्य को 'पीस' (Peace)—क्योंकि दोनों के आत्मा की पुकार अलग थी।"
            "ज्ञान (Knowledge) ही वह अंतिम चाबी है जिससे संसार का यह 'मायावी ताला' खुलता है।"
            "वैश्य के लिए अब दुनिया का कोई भी दुख या मोह उसे विचलित करने की ताकत नहीं रखता था।"
            "माता की कृपा ने उसे एक 'साधारण व्यापारी' से एक 'मुक्त आत्मा' (Liberated Soul) में बदल दिया था।"
        """.trimIndent(),
        english = """
            (Boon to the Merchant): "The Goddess addressed the Merchant: 'O Excellent Merchant! Whatever boon You have desired from Me'."
            "'I grant that as well for Your absolute perfection; You shall attain that 'Supreme Wisdom' (Moksha)'."
            "Vaisya-varya (Best among merchants)—The Mother recognized his eligibility as he chose the 'Eternal' over the 'Temporary'."
            "Sam-siddhyai (For Perfection) refers to that wisdom which renders a human mathematically 'Perfect' and 'Complete'."
            "The Goddess was now descending into the Merchant's heart as the absolute manifestation of 'Brahma-Vidya'."
            "This boon confirms that the Divine understands every devotee's 'Unique' necessity and provides accordingly."
            "The King received 'Power' and the Merchant received 'Peace'—honoring the different yearnings of their souls."
            "Wisdom (Jnana) is the absolute final key that unlocks the 'Illusory Lock' of worldly existence."
            "For the Merchant, zero worldly sorrow or attachment now possessed the strength to distract his consciousness."
            "The Mother's grace successfully transformed him from an 'Ordinary Trader' into a 'Liberated Soul'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 16,
        sanskrit = "मार्कण्डेय उवाच ॥ २१ ॥\nइति दत्त्वा तयोर्देवी यथाभिलषितं वरम् ।\nबभूवान्तर्हिता सद्यो भक्त्या ताभ्यामभिष्टुता ॥ २२ ॥",
        hindi = """
            (देवी का विसर्जन): "मार्कण्डेय जी ने कहा: उन दोनों को उनकी इच्छा के अनुसार वरदान देकर माता चण्डिका।"
            "उनके द्वारा अत्यंत भक्तिपूर्वक स्तुति किए जाने पर उसी क्षण (सद्यः) वहाँ से 'अंतर्ध्यान' हो गईं।"
            "यथाभिलषितं (जैसा चाहा था)—भगवान हमारे संकल्प को ही फल के रूप में हमें वापस लौटाते हैं।"
            "देवी का गायब होना यह याद दिलाता है कि 'अनुभव' (Experience) के बाद 'एकाकीपन' और 'मौन' आता है।"
            "भक्त्या अभिष्टुता—उनकी विदाई भी आंसुओं और प्रेम की फ्रीक्वेंसी में डूबी हुई थी।"
            "जब काम पूरा हो जाता है, तो शक्ति वापस 'शून्य' (Void) में लौट जाती है ताकि 'शांति' बनी रहे।"
            "सद्यः (Immediately)—यह दिखाता है कि देवी किसी प्रशंसा या 'क्रेडिट' की भूखी नहीं हैं।"
            "उनका जाना वास्तव में भक्त के हृदय में उनके 'परमानेंट निवास' की शुरुआत थी।"
            "अब राजा और वैश्य केवल 'देख' नहीं रहे थे, वे देवी को अपने भीतर 'महसूस' कर रहे थे।"
            "यह दृश्य एक महान आध्यात्मिक अध्याय के भव्य और शांत समापन का प्रतीक है।"
        """.trimIndent(),
        english = """
            (The Goddess Departs): "Markandeya said: Having granted those two seekers the boons according to their specific desires."
            "Upon being praised with extreme devotion by them, the Mother instantaneously 'Disappeared' from that spot."
            "Yathabhilashitam (As desired)—God mathematically returns our own deepest Resolves to us as manifested results."
            "The Goddess's disappearance serves as a reminder that every 'Experience' must result in 'Solitude' and 'Silence'."
            "Bhaktaya Abhishtuta—Her departure was also saturated within the absolute frequency of pure Love and tears."
            "Once the cosmic task is achieved, Energy returns to the 'Void' to ensure the maintenance of universal Peace."
            "'Sadyah' (Immediately) proves that the Divine is zero percent hungry for praise, status, or individual credit."
            "Her physical exit was actually the initiation of Her 'Permanent Residence' strictly within the seeker's heart."
            "The King and the Merchant were zero longer merely 'Watching' Her; they were 'Feeling' Her within themselves."
            "This scene symbolizes the grand, quiet, and profound conclusion of a massive spiritual chapter."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 17,
        sanskrit = "एवं देव्या वरं लब्ध्वा सुरथः क्षत्रियर्षभः ।\nसूर्याज्जन्म समासाद्य सावर्णिर्भविता मनुः ॥ २३ ॥",
        hindi = """
            (सावर्णि मनु का जन्म): "इस प्रकार देवी से वरदान प्राप्त करके, क्षत्रियों में श्रेष्ठ राजा सुरथ।"
            "भविष्य में सूर्य के अंश से जन्म लेकर 'सावर्णि' नाम के महान मनु के रूप में प्रकट हुए।"
            "क्षत्रियर्षभः (Best among warriors)—साधना ने राजा की वीरता को 'पवित्र' और 'अजेय' बना दिया था।"
            "सावर्णि मनु—वे इंसानियत के उस नए चैप्टर के 'फाउंडर' (Founder) बने जो धर्म पर आधारित था।"
            "यह श्लोक सिद्ध करता है कि 'शक्ति' का सही उपयोग ही इंसान को 'देवत्व' (Divinity) की ओर ले जाता है।"
            "जन्म समासाद्य—पुनर्जन्म का यह सिद्धांत हमें 'लॉन्ग-टर्म विजन' (Long-term vision) रखने की सीख देता है।"
            "जो राजा अपना राज्य हार चुका था, आज वह पूरे 'मन्वंतर' (Epoch) का मालिक बन चुका था।"
            "यह 'जीरो से हीरो' बनने की सबसे बड़ी आध्यात्मिक और वास्तविक मिसाल है।"
            "जब हम खुद को देवी के चरणों में समर्पित करते हैं, तो वे हमारी 'डेस्टिनी' को सातवें आसमान पर पहुँचा देती हैं।"
            "राजा सुरथ का चरित्र हर उस इंसान के लिए प्रेरणा है जो हार के बाद दोबारा खड़ा होना चाहता है।"
        """.trimIndent(),
        english = """
            (The Birth of Savarni Manu): "In this manner, having received the boon from the Goddess, King Suratha, the best among warriors."
            "Achieved birth through the Sun God and became the great 'Manu' known as Savarni in the future."
            "Kshatriyarshabhah (Best Warrior)—Practice had rendered the King's valor mathematically pure and invincible."
            "Savarni Manu—He became the 'Founder' of a brand-new chapter of humanity strictly based upon absolute Dharma."
            "This verse proves that the righteous utilization of 'Power' leads a human directly toward absolute 'Divinity'."
            "Achieving Rebirth—This principle teaches us to maintain an exceptionally 'Long-term Vision' in our actions."
            "The King who had lost his small physical empire had now become the sovereign lord of an entire 'Epoch'."
            "This is the absolute greatest spiritual and actual example of transforming from 'Zero to a Cosmic Hero'."
            "When we surrender entirely at the Mother's feet, She elevates our 'Destiny' to the absolute highest dimensions."
            "King Suratha's character is the ultimate inspiration for every human seeking to rise again after a total fall."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 18,
        sanskrit = "इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये सुरथवैश्ययोर्वरप्रदानं नाम त्रयोदशोऽध्यायः ॥ १३ ॥",
        hindi = """
            (अध्याय का समापन): "यहीं पर श्री मार्कण्डेय पुराण में वर्णित 'सुरथ और वैश्य को वरदान' नामक तेरहवां अध्याय पूर्ण होता है।"
            "यह समापन केवल एक कहानी का अंत नहीं, बल्कि अज्ञान के ऊपर 'सत्य की पूर्ण विजय' की मुहर है।"
            "त्रयोदशोऽध्यायः—संख्या १३ तन्त्र में 'पूर्णता' और 'ट्रांसफॉर्मेशन' (Transformation) का प्रतीक मानी जाती है।"
            "सुरथ (शक्ति) और वैश्य (शांति) दोनों ने अपने-अपने लक्ष्यों को प्राप्त कर लिया, जो 'बैलेंस' का प्रतीक है।"
            "यह अध्याय हमें सिखाता है कि बिना 'गुरु' के मार्गदर्शन और बिना 'तप' के कुछ भी प्राप्त नहीं होता।"
            "देवी-माहात्म्य की यह पूरी यात्रा इंसान के मन की 'सफाई' से लेकर 'आत्मज्ञान' तक का सफर है।"
            "जब हम इसे पढ़ते हैं, तो हमारे अंदर के महिषासुर, शुम्भ और निशुम्भ एक-एक करके मिटते चले जाते हैं।"
            "अंतिम परिणाम हमेशा 'वरदान' और 'शांति' ही होता है, यदि हम अपनी साधना में अडिग रहें।"
            "यहीं पर वह दिव्य कथा विश्राम लेती है जिसने करोड़ों आत्माओं को प्रकाश दिखाया है।"
            "सत्यमेव जयते—सत्य की हमेशा जीत होती है और अज्ञान का अंत हमेशा सुखद होता है।"
        """.trimIndent(),
        english = """
            (Conclusion of the Chapter): "Right here successfully concludes the Thirteenth Chapter of the text, named 'The Bestowing of Boons'."
            "This conclusion is zero mere end of a story, but the official seal of the 'Total Victory of Truth' over ignorance."
            "Number 13 in advanced Tantra serves as the absolute symbol of 'Completeness' and profound 'Transformation'."
            "Suratha (Power) and the Merchant (Peace) both achieved their targets, symbolizing the 'Perfect Cosmic Balance'."
            "This chapter teaches that zero results are achieved strictly without the 'Master's Guidance' and 'Internal Penance'."
            "The entire journey of Devi Mahatmya spans from the 'Cleaning of the Mind' to absolute 'Self-Realization'."
            "As we engage with this text, our internal Mahishasura, Shumbha, and Nishumbha are systematically annihilated."
            "The final outcome is perpetually 'Blessings' and 'Peace', provided we remain unshakeable in our spiritual practice."
            "Right here rests the divine history that has illuminated billions of souls throughout the cycles of time."
            "Truth eternally reigns supreme—the termination of deep-seated ignorance is always a blissful cosmic event."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 19,
        sanskrit = "एतत्ते कथितं भूप देवीमाहात्म्यमुत्तमम् ।\nएवंप्रभावा सा देवी ययेदं धार्यते जगत् ॥ १९ ॥",
        hindi = """
            (ऋषि का दोहराव): "महर्षि ने फिर से इस बात पर जोर दिया कि यही देवी का उत्तम माहात्म्य है जो सबको तारने वाला है।"
            "यही वह प्रभाव है जिससे यह पूरा विश्व टिका हुआ है और संचालित हो रहा है।"
            "दोहराव (Repetition) यह सुनिश्चित करने के लिए है कि राजा के मन में कोई भी संशय बाकी न रहे।"
            "जब हम किसी महान सत्य को बार-बार सुनते हैं, तो वह हमारी 'बिलीफ सिस्टम' (Belief System) का हिस्सा बन जाता है।"
            "देवी की महिमा कोई जादू नहीं, बल्कि ब्रह्मांड का 'ऑपरेटिंग सिस्टम' (Operating System) है।"
            "राजा अब पूरी तरह से 'कन्विनस्ड' (Convinced) था कि उसका उद्धार केवल सत्य की शरण में है।"
            "यह श्लोक 'ज्ञान योग' की उस स्थिरता को दिखाता है जहाँ साधक सत्य में पूरी तरह स्थित हो जाता है।"
            "ब्रह्मांड को थामना (Dharyate) यह बताता है कि ईश्वर हमसे अलग नहीं, बल्कि हमारा 'आधार' है।"
            "जब हम इस आधार को पहचान लेते हैं, तो हमारा 'अकेलापन' और 'डर' हमेशा के लिए खत्म हो जाता है।"
            "ऋषि के ये शब्द राजा के लिए एक 'मेंटल शील्ड' (Mental Shield) की तरह काम कर रहे थे।"
        """.trimIndent(),
        english = """
            (The Sage's Reiteration): "The Sage emphasized once again that this supreme glory of the Goddess is the ultimate savior of all."
            "This is the absolute cosmic influence that sustains the world and keeps it functioning in perfect order."
            "Repetition is utilized strictly to ensure that zero 'Doubt' remains within the King's psychological framework."
            "When we listen to a Great Truth repeatedly, it systematically becomes an integral part of our 'Belief System'."
            "The Goddess's glory is zero mere magic; it is the absolute 'Operating System' of the manifested universe."
            "The King was now entirely 'Convinced' that his salvation resided exclusively in surrendering to the Truth."
            "This verse illustrates that stability of 'Jnana Yoga' where the seeker becomes firmly established in Reality."
            "Sustaining the cosmos (Dharyate) implies that God is zero separate from us, but is our absolute 'Foundation'."
            "Exactly when we recognize this foundation, our 'Loneliness' and 'Fear' are mathematically terminated forever."
            "The Sage's words functioned as an absolute 'Mental Shield' for the King against future psychological attacks."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 20,
        sanskrit = "विद्या तथैव क्रियते भगवद्विष्णुमायया ।\nतयैतन्मोह्यते चैव सैव विश्वं प्रसूयते ॥ २० ॥",
        hindi = """
            (माया का रहस्य - पुनः): "ज्ञान और अज्ञान का यह खेल केवल उस 'विष्णुमाया' की ही एक अद्भुत लीला है।"
            "वे ही सबको मोह में डालती हैं और वे ही इस पूरे ब्रह्मांड को जन्म देती हैं।"
            "यह श्लोक दोबारा यह याद दिलाता है कि 'कंट्रोल' हमारे हाथ में नहीं, बल्कि उस 'सुप्रीम पावर' के पास है।"
            "माया (Illusion) कोई दुश्मन नहीं है, बल्कि वह सीखने का एक 'प्लेटफॉर्म' (Platform) है।"
            "जब तक हम संसार के दुखों में उलझे हैं, हम माया के 'भोग' वाले हिस्से को देख रहे हैं।"
            "जब हम देवी की शरण में आते हैं, तो हम माया के 'योग' और 'विद्या' वाले हिस्से से जुड़ जाते हैं।"
            "प्रसूयते—सृष्टि का हर अंकुर उसी एक चेतना की इच्छा का परिणाम है।"
            "यह श्लोक इंसान को 'हम्बल' (Humble) बनाता है कि वह प्रकृति के विशाल खेल का एक छोटा सा हिस्सा है।"
            "अहंकार को लगता है कि वह सब जानता है, पर माया उसे हर मोड़ पर चुनौती देती है।"
            "सत्य का बोध होते ही यह माया 'माँ' बन जाती है और हमें रास्ता दिखाने लगती है।"
        """.trimIndent(),
        english = """
            (The Mystery of Maya - Revisited): "The cosmic game of knowledge and ignorance is strictly an astonishing play of 'Vishnumaya'."
            "She alone deludes absolutely everyone and She alone manifests this entire complex universe."
            "This verse serves as a recurring reminder that absolute 'Control' resides zero with us, but with the Supreme Power."
            "Maya (Illusion) is zero 'Enemy'; it is a 'Platform' constructed for the soul to gather cosmic experiences."
            "As long as we are entangled in worldly suffering, we are perceiving only the 'Consumption' aspect of Maya."
            "Exactly when we surrender to the Mother, we connect with the 'Yoga' and 'Wisdom' aspect of Her energy."
            "Prasuyate—Every sprout of creation is a mathematical result of that singular Consciousness's absolute Will."
            "This verse renders a human 'Humble', realizing they are strictly a microscopic part of Nature's grand play."
            "The Ego deludes itself thinking it knows everything, yet Maya challenges it at every dangerous turning point."
            "The moment Truth is realized, this Maya transforms into the 'Mother', guiding us toward our final destination."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 21,
        sanskrit = "सा याचिता च विज्ञानं तुष्टा ऋद्धिं प्रयच्छति ॥ २१ ॥",
        hindi = """
            (वरदान की गारंटी): "प्रार्थना करने पर वे 'ज्ञान' देती हैं और खुश होने पर 'समृद्धि' प्रदान करती हैं।"
            "यह लाइन इस पूरे अध्याय का 'एक्जीक्यूटिव समरी' (Executive Summary) है।"
            "विज्ञान (Wisdom) हमारे 'आंतरिक जीवन' को रोशन करता है, और ऋद्धि हमारे 'बाहरी जीवन' को।"
            "देवी का स्वभाव 'देने' का है (प्रयच्छति), पर हमें अपनी 'झोली' (पात्रता) फैलानी पड़ती है।"
            "यह श्लोक सिद्ध करता है कि साधना कभी भी 'अन-रिवॉर्डेड' (Unrewarded) नहीं जाती।"
            "जब आप देवी को 'याचिता' (पुकारते) हैं, तो ब्रह्मांड का पूरा खजाना आपका इंतज़ार करता है।"
            "संतुष्टि (Tushta) ही वह मुद्रा (Currency) है जिससे हम ईश्वरीय कृपा को खरीदते हैं।"
            "राजा और वैश्य को मिले वरदान इसी एक लाइन की सजीव हकीकत थे।"
            "यह मंत्र हर उस साधक के लिए है जो अपने जीवन में 'कंप्लीट रिज़ल्ट' (Complete Result) चाहता है।"
            "हम उस कल्पवृक्ष स्वरूपा माँ को नमन करते हैं जो हर इच्छा को मंगल में बदल देती हैं।"
        """.trimIndent(),
        english = """
            (Guarantee of the Boon): "Upon being petitioned, She grants 'Wisdom', and when satisfied, She bestows absolute 'Prosperity'."
            "This specific line serves as the absolute 'Executive Summary' of the entire concluding chapter."
            "Wisdom (Vijnana) illuminates our 'Internal Life', while Prosperity (Riddhi) brightens our 'External Existence'."
            "The Goddess's nature is fundamentally to 'Provide' (Prayachhati), yet we must expand our own 'Eligibility'."
            "This verse definitively proves that spiritual practice is mathematically never left 'Unrewarded' by the cosmos."
            "When You 'Petition' (Yachita) the Goddess, the entire treasury of the universe awaits Your acceptance."
            "Satisfaction (Tushta) is the spiritual 'Currency' utilized to attract and manifest Divine Grace."
            "The boons received by the King and Merchant were the living physical reality of this singular cosmic law."
            "This mantra is for every practitioner seeking 'Complete Results' across all dimensions of their existence."
            "We bow to the Mother manifest as the Wish-fulfilling Tree, transforming every desire into absolute welfare."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 22,
        sanskrit = "मार्कण्डेय उवाच ॥ २२ ॥\nइति तस्य वचः श्रुत्वा सुरथः स नराधिपः ।\nप्रणिपत्य महाभागं तमृषिं शंसितव्रतम् ॥ २३ ॥",
        hindi = """
            (अंतिम प्रणाम): "मार्कण्डेय जी ने कथा आगे बढ़ाई: राजा सुरथ ने महर्षि मेधा को अंतिम बार प्रणाम किया।"
            "वे ऋषि, जिन्होंने सत्य का रास्ता दिखाया, वे सच में वंदनीय और महान थे।"
            "प्रणिपत्य (Bowing)—यह क्रिया दिखाती है कि राजा का 'अहंकार' अब 100% मिट चुका था।"
            "जब हम गुरु के चरणों में झुकते हैं, तो हम अपनी 'पुरानी पहचान' को वहीं छोड़ देते हैं।"
            "राजा अब केवल एक 'भिखारी' नहीं था, बल्कि एक 'जागृत आत्मा' था जो अपना हक़ पाने निकला था।"
            "गुरु का काम रास्ता दिखाना है, और शिष्य का काम उस पर 'एक्शन' लेना है।"
            "यह श्लोक गुरु-शिष्य परंपरा की उस पवित्र गरिमा को दोबारा स्थापित करता है।"
            "बिना आभार (Gratitude) के, ज्ञान कभी भी मन में 'रूट' (Root) नहीं जमा सकता।"
            "सुरथ की यह विनम्रता ही उसे भविष्य में 'सावर्णि मनु' बनाने वाली थी।"
            "अब राजा और वैश्य अपने-अपने लक्ष्यों की प्राप्ति के लिए आश्रम से विदा हुए।"
        """.trimIndent(),
        english = """
            (The Final Salutation): "Markandeya continued the narrative: King Suratha offered his absolute final salutation to Sage Medha."
            "The Master who revealed the absolute path of Truth was indeed worthy of supreme worship and honor."
            "Bowing (Pranipatya) indicates that the King's 'Ego' was now mathematically 100% dissolved and removed."
            "When we bow at the Master's feet, we essentially abandon our 'Old Identity' and psychological baggage."
            "The King was zero longer merely a 'Beggar' of fate; he was an 'Awakened Soul' reclaiming his cosmic right."
            "The Master's role is to provide the Map, and the disciple's role is to execute the absolute 'Action'."
            "This verse re-establishes the sacred and profound dignity of the Master-Disciple (Guru-Shishya) tradition."
            "Without Gratitude, spiritual knowledge can mathematically never take absolute 'Root' within the human mind."
            "Suratha's profound humility was the primary catalyst that would eventually transform him into 'Savarni Manu'."
            "Now the King and the Merchant departed from the hermitage to systematically achieve their specific goals."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 23,
        sanskrit = "निर्विण्णोऽतिममत्वेन राज्यापहरणेन च ।\nजगाम सद्यस्तपसे स च वैश्यो महामुने ॥ २४ ॥",
        hindi = """
            (तपस्या का संकल्प): "राज्य के अपहरण और अत्यधिक मोह से दुखी होकर, वे दोनों तुरंत तपस्या के लिए चले गए।"
            "उन्होंने समझ लिया था कि बाहरी दुनिया के दुख का इलाज केवल 'भीतर' ही छिपा है।"
            "निर्विण्णः (Detached)—यह वह वैराग्य है जो इंसान को भीड़ से अलग करके खुद से मिलवाता है।"
            "ममत्व (Mine-ness)—उनका मोह अब टूटने लगा था, जो उनकी आध्यात्मिक जीत की पहली सीढ़ी थी।"
            "सद्यः (तुरंत)—आध्यात्मिक मार्ग पर 'कल' के लिए कुछ भी छोड़ना पतन का कारण बनता है।"
            "तपस्या (Penance) का अर्थ है—खुद को उस आग में तपाना जहाँ सारा अज्ञान जलकर राख हो जाए।"
            "राजा और वैश्य अब केवल 'सर्वाइवल' नहीं, बल्कि 'ट्रांसफॉर्मेशन' (Transformation) चाहते थे।"
            "यह श्लोक हमें सिखाता है कि जब दुनिया साथ छोड़ दे, तो 'स्वयं' का साथ पकड़ना चाहिए।"
            "उन्होंने शोर-शराबे वाली दुनिया को पीछे छोड़ दिया ताकि वे 'परम मौन' को सुन सकें।"
            "अब उनके जीवन का हर पल एक 'साधना' (Spiritual Discipline) बन चुका था।"
        """.trimIndent(),
        english = """
            (Resolve for Penance): "Shattered by the theft of his kingdom and excessive attachment, they both instantaneously sought penance."
            "They had realized that the absolute cure for external worldly sorrow resides strictly 'Within' the self."
            "'Nirvinnah' (Detachment) is that state which separates a human from the crowd to introduce them to themselves."
            "Mamatva (Attachment)—Their deluded possessiveness was now shattering, marking the first step of spiritual victory."
            "'Immediately' (Sadyah) proves that on the spiritual path, postponing anything until 'Tomorrow' leads to failure."
            "Penance (Tapasya) means incinerating oneself in that divine fire where all ignorance is reduced to common ashes."
            "The King and the Merchant now desired zero merely to 'Survive', but to achieve a total cosmic 'Transformation'."
            "This verse teaches that when the world abandons You, it is the absolute time to embrace Your 'Self'."
            "They left the noisy and chaotic world behind strictly to successfully hear the absolute 'Supreme Silence'."
            "Every microsecond of their existence had now successfully flawlessly transformed strictly into a 'Spiritual Discipline'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 24,
        sanskrit = "संदर्शनार्थमम्बाया नदीपुलिनमास्थितः ।\nस च वैश्यस्तपस्तेपे देवीसूक्तं परं जपन् ॥ २५ ॥",
        hindi = """
            (देवी-सूक्त का जाप): "वे दोनों नदी के तट पर बैठकर माँ के दर्शन के लिए 'देवी-सूक्त' का निरंतर जप करने लगे।"
            "देवी-सूक्त (Devi Suktam) ब्रह्मांड की वह पहली ध्वनि है जो 'स्वयं' को ईश्वर घोषित करती है।"
            "नदीपुलिनम् (नदी तट)—पानी की बहती धारा की तरह उनका जाप भी बिल्कुल 'लय' (Rhythm) में था।"
            "जप (Repetition) हमारे दिमाग के पुराने नेगेटिव कोडिंग को ओवर-राइट (Over-write) करने का तरीका है।"
            "दर्शन की तड़प (Longing)—उनकी आत्मा अब केवल उस 'महामाया' से मिलने के लिए छटपटा रही थी।"
            "जब हम देवी-सूक्त पढ़ते हैं, तो हम अपनी 'बाउंड्रीज़' (Boundaries) को तोड़कर 'विराट' हो जाते हैं।"
            "यह साधना का वह चरण है जहाँ शब्द 'ऊर्जा' (Energy) में बदलने लगते हैं।"
            "राजा और वैश्य अब दो अलग व्यक्ति नहीं, बल्कि दो 'साधक' थे जो एक ही सत्य को ढूंढ रहे थे।"
            "नदी की शांति और मंत्रों की गूँज ने वहां एक 'दिव्य पोर्टल' (Divine Portal) बना दिया था।"
            "अब देवी का प्रकट होना केवल 'समय' की बात थी, क्योंकि पात्रता पूरी हो चुकी थी।"
        """.trimIndent(),
        english = """
            (Chanting the Devi Suktam): "Seated upon the riverbank, they continuously chanted the 'Devi Suktam' to manifest the Mother's vision."
            "Devi Suktam is the primordial cosmic vibration that declares the 'Self' as the absolute Supreme Godhead."
            "Riverbank (Nadi-pulina) implies that like the flowing water, their chanting was in perfect rhythmic 'Flow'."
            "Chanting (Japa) is the psychological method to Over-write the ancient negative coding of the human biological brain."
            "The Longing (Sandarshanam)—Their souls were now desperately yearning exclusively for the union with Mahamaya."
            "When we recite the Devi Suktam, we systematically shatter our narrow 'Boundaries' to become 'Universal'."
            "This is the stage of spiritual practice where words begin transforming strictly into absolute pure 'Energy'."
            "The King and the Merchant were zero longer separate entities, but two 'Seekers' hunting the singular Truth."
            "The river's silence and the mantra's resonance successfully established a literal 'Divine Portal' in that space."
            "The manifestation of the Goddess was now strictly a matter of 'Time', as their eligibility was complete."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 25,
        sanskrit = "तस्थौ स तत्र पुलिने देव्याः कृत्वा महीमयीम् ।\nमूर्तिं ततश्चक्रतुः पूजां पुष्पधूपान्नतर्पणैः ॥ २६ ॥",
        hindi = """
            (मिट्टी की प्रतिमा): "उन्होंने नदी की पवित्र मिट्टी से देवी की एक मूर्ति बनाई और पूरी श्रद्धा से उसकी पूजा की।"
            "मिट्टी (Earth) यह याद दिलाती है कि हमारा शरीर भी इसी तत्व से बना है और अंततः इसी में मिलेगा।"
            "मूर्ति बनाना अज्ञानी मन को एक 'आधार' (Base) देने की क्रिया है ताकि ध्यान कहीं भटके नहीं।"
            "पूजा में पुष्प (Flowers) और धूप का उपयोग अपनी इंद्रियों को 'शांत' और 'रिसेप्टिव' बनाने के लिए था।"
            "जब हम अपने हाथों से ईश्वर को आकार देते हैं, तो हमारा 'ईगो' (Ego) कलाकार बन जाता है और झुक जाता है।"
            "अन्न-तर्पण—इसका अर्थ है अपनी 'भूख' और 'जरूरतों' को ईश्वर के चरणों में समर्पित करना।"
            "यह 'सगुण साधना' (Formal Worship) का वह स्तर है जहाँ पत्थर और मिट्टी भी भगवान बन जाते हैं।"
            "उनकी पूजा कोई औपचारिकता नहीं, बल्कि उनके खून-पसीने और आँसुओं का एक 'इन्वेस्टमेंट' थी।"
            "मिट्टी की वह मूर्ति अब उनकी 'साधना' की ऊर्जा से साक्षात् जीवंत (Alive) होने लगी थी।"
            "यह श्लोक सिखाता है कि श्रद्धा हो तो कंकड़ भी शंकर बन सकता है।"
        """.trimIndent(),
        english = """
            (The Earthly Image): "They constructed an image of the Goddess utilizing holy river clay and worshipped it with total faith."
            "Earth (Mahi) reminds us that our physical body is composed of this element and will eventually return to it."
            "Creating an idol is the psychological act of providing the mind with a 'Base' to prevent focus from wandering."
            "Utilizing Flowers and Incense in worship was intended to render the biological senses 'Peaceful' and 'Receptive'."
            "When we give shape to the Divine with our own hands, our 'Ego' transforms into an artist and surrenders."
            "Sacrificing grains (Anna-tarpana) symbolizes surrendering one's 'Hunger' and survival needs to the absolute Divine."
            "This is the level of 'Saguna Sadhana' where common stone and clay mathematically transform into God."
            "Their worship was zero formality, but an 'Investment' of their absolute sweat, blood, and profound tears."
            "That clay image was beginning to become vibrantly 'Alive' strictly due to the intensity of their spiritual energy."
            "This verse teaches that with authentic faith, even a pebble can mathematically manifest the absolute Supreme Shiva."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 26,
        sanskrit = "निराहारौ यताहारौ तन्मनस्कौ समाहितौ ।\nददतुस्तौ बलिं चैव निजगात्रासृगुक्षितम् ॥ २७ ॥",
        hindi = """
            (आत्म-बलिदान): "वे बिना भोजन के (निराहार) अपनी साधना में लीन रहे और अपने शरीर के रक्त से देवी को बलि दी।"
            "रक्त की बलि (Blood Offering)—यह अपने 'अस्तित्व' (Existence) को पूरी तरह दांव पर लगाने का प्रतीक है।"
            "जब इंसान खुद को मिटाने को तैयार हो जाता है, तभी उसे 'परम सत्ता' का अनुभव होता है।"
            "तन्मनस्कौ—उनका मन अब संसार की किसी भी चीज़ के बारे में नहीं सोच रहा था, केवल 'माँ' के बारे में था।"
            "समाहितौ (Fixed)—उनका फोकस इतना तीव्र था कि वे 'समय' और 'स्थान' के अहसास से भी ऊपर उठ गए थे।"
            "शरीर का खून देना यह बताता है कि वे अपनी 'अंतिम आसक्ति' (Final Attachment) को भी छोड़ रहे थे।"
            "यह 'रॉ' और 'अनफिल्टर्ड' (Unfiltered) तपस्या थी जिसने प्रकृति के नियमों को झुकने पर मजबूर कर दिया।"
            "अहंकार (शुम्भ) को मारने के लिए अपनी 'पहचान' (रक्त) का विसर्जन करना ही एकमात्र रास्ता है।"
            "यह श्लोक 'एक्स्ट्रीम डेडीकेशन' की वह मिसाल है जो बहुत कम साधक ही दे पाते हैं।"
            "अब उनकी तीन साल की मेहनत अपने 'ईश्वरीय फल' (Divine Fruit) के बहुत करीब थी।"
        """.trimIndent(),
        english = """
            (Self-Sacrifice): "They remained without food (Niraharou), absorbed in practice, offering oblations of their own biological blood."
            "Blood Offering symbolizes the absolute willingness to put one's entire 'Existence' at stake for the Truth."
            "Strictly when a human is ready to dissolve their identity does the 'Absolute Reality' begin to manifest."
            "Tan-manaskou describes the state where the mind thinks of zero worldly objects, focusing exclusively on the 'Mother'."
            "Samahitou (Composed) implies their focus was so intense they transcended the perceptions of 'Time' and 'Space'."
            "Offering blood indicates they were systematically relinquishing their absolute 'Final Attachment'—the life-force itself."
            "This was 'Raw' and 'Unfiltered' penance that mathematically forced the laws of Nature to yield and respond."
            "To terminate the inner Shumbha (Ego), the total dissolution of one's 'Identity' (Blood) is the only path."
            "This verse illustrates 'Extreme Dedication' that strictly only a few elite practitioners can ever demonstrate."
            "Their three years of rigorous spiritual labor were now strictly seconds away from yielding their 'Divine Fruit'."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 27,
        sanskrit = "एवं समाराधयतोस्त्रिभिर्वर्षैर्यतचतोः ।\nपरितुष्टा जगद्धात्री प्रत्यक्षं प्राह चण्डिका ॥ २८ ॥",
        hindi = """
            (दर्शन का क्षण): "तीन वर्षों तक इस प्रकार कठोर आराधना करने के बाद, जगद्धात्री चण्डिका उन पर प्रसन्न हो गईं।"
            "वे उनके सामने साक्षात् (प्रत्यक्ष) प्रकट हुईं और अत्यंत ममता भरी वाणी में उनसे बात की।"
            "तीन वर्ष (3 Years)—यह समय 'लॉ ऑफ इनक्यूबेशन' (Incubation) को दिखाता है, जहाँ धैर्य की परीक्षा होती है।"
            "जगद्धात्री—वह माँ जो पूरे ब्रह्मांड को 'दूध पिलाती' है, आज अपने दो रोते हुए बच्चों के सामने खड़ी थी।"
            "प्रत्यक्ष दर्शन—यह वह 'मिरकल' (Miracle) है जहाँ 'ऊर्जा' (Energy) एक 'शरीर' (Body) का रूप ले लेती है।"
            "परितुष्टा (Satisfied)—ईश्वर की संतुष्टि ही इंसान की मेहनत का सबसे बड़ा और अंतिम 'सर्टिफिकेट' है।"
            "जब चेतना प्रकट होती है, तो सारे दुख, पुरानी हार और डिप्रेशन एक पल में भाप बनकर उड़ जाते हैं।"
            "देवी के सामने खड़े होना ही 'पूर्ण मुक्ति' का द्वार खुलना है।"
            "उनकी आवाज़ इतनी मधुर थी कि उसने राजा और वैश्य के 'अंतर्मन' को पूरी तरह हील (Heal) कर दिया।"
            "यह पल उनके जीवन का सबसे महान और ऐतिहासिक मोड़ था।"
        """.trimIndent(),
        english = """
            (The Moment of Vision): "After three years of rigorous and absolute worship, Jagaddhatri Chandika became entirely pleased."
            "She manifested physically (Pratyaksham) before them and addressed them in an exceptionally loving and maternal voice."
            "Three Years represent the cosmic 'Law of Incubation', where the unshakeable patience of the seeker is tested."
            "Jagaddhatri implies the Mother who 'Nurses' the entire cosmos was now standing before Her two weeping children."
            "Physical Vision is that 'Cosmic Miracle' where pure 'Energy' assumes a 'Physical Format' for the devotee."
            "Paritushta (Satisfied) signifies that divine satisfaction is the absolute greatest and final 'Certificate' for human effort."
            "The moment Consciousness manifests, all sorrows, past defeats, and depressions evaporate like steam instantly."
            "Standing before the Goddess is equivalent to the opening of the absolute 'Gateway of Total Liberation'."
            "Her voice was so exceptionally sweet that it successfully and entirely Healed the inner psyche of the seekers."
            "This specific microsecond was the absolute greatest and most historic turning point of their entire existence."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 28,
        sanskrit = "यत्प्रार्थ्यते त्वया भूप त्वया च कुलनन्दन ।\nमत्तस्तत्प्राप्यतां सर्वं परितुष्टा ददामि तत् ॥ २८ ॥",
        hindi = """
            (इच्छा पूर्ति का वचन): "देवी ने कहा: 'हे राजन्! और हे वैश्य! तुम दोनों ने जो कुछ भी प्रार्थना की है, वह सब मुझसे ले लो'।"
            "'मैं तुम दोनों पर पूरी तरह प्रसन्न हूँ और तुम्हारी हर इच्छा को आज 'तथास्तु' कहती हूँ'।"
            "प्रार्थ्यते (प्रार्थना)—भगवान तभी देते हैं जब हम अपनी इच्छा को एक 'संकल्प' बनाकर उनके पास ले जाते हैं।"
            "कुलनन्दन—देवी ने वैश्य को उसके 'कुल' (वंश) का गौरव कहकर पुकारा, जो उसके सम्मान की वापसी थी।"
            "ददामि (मैं देती हूँ)—यह ब्रह्मांड की 'असीमित प्रचुरता' (Abundance) का प्रतीक है जो कभी कम नहीं होती।"
            "देवी एक 'ब्लैंक चेक' (Blank Check) दे रही हैं, क्योंकि वे जानती हैं कि अब उनकी नीयत साफ़ हो चुकी है।"
            "जब हम 'तपस्या' से गुज़रते हैं, तो हमारी 'इच्छाएं' खुद-ब-खुद 'पवित्र' (Sacred) हो जाती हैं।"
            "राजा अब अपना राज्य मांगेगा, और वैश्य अपनी आज़ादी—और दोनों को वही मिलेगा।"
            "देवी की ये लाइनें हर भक्त के लिए एक 'खुशखबरी' हैं कि माँ हमेशा सुनती हैं।"
            "अब उन दोनों की सालों की तड़प और इंतज़ार खत्म होने वाला था।"
        """.trimIndent(),
        english = """
            (Promise of Fulfillment): "The Goddess said: 'O King! And O Merchant! Whatever You have prayed for, receive it all from Me'."
            "'I am entirely satisfied with both of You, and I grant every single desire of Yours this very moment'."
            "Prarthyate (Prayed) implies that God provides strictly when we transform our desire into a focused 'Resolution'."
            "Kula-nandana—The Mother addressed the Merchant as the 'Pride of his Clan', restoring his lost dignity."
            "'I Grant' (Dadami) symbolizes the absolute 'Infinite Abundance' of the universe that mathematically never depletes."
            "The Goddess is effectively offering a 'Blank Check', knowing their intentions have been purified through fire."
            "Exactly when we pass through 'Penance' (Tapasya), our 'Desires' independently and automatically become 'Sacred'."
            "The King will request his kingdom, and the Merchant his freedom—and both shall receive exactly that."
            "These words of the Goddess are the 'Divine Good News' for every seeker, proving that the Mother always listens."
            "Now their years of profound longing and unshakeable waiting were finally destined to reach their end."
        """.trimIndent()
    ),
    SaptshatiShloka(
        id = 29,
        sanskrit = "इति श्रीमार्कण्डेयपुराणे सावर्णिके मन्वन्तरे देवीमाहात्म्ये सुरथवैश्ययोर्वरप्रदानं नाम त्रयोदशोऽध्यायः ॥ १३ ॥\n॥ ॐ ॥",
        hindi = """
            (पूर्ण समापन): "यहीं पर श्री मार्कण्डेय पुराण में वर्णित 'सुरथ और वैश्य को वरदान' नामक तेरहवां अध्याय पूर्ण होता है।"
            "यह समापन केवल एक कथा का अंत नहीं, बल्कि अज्ञान के ऊपर 'चेतना की पूर्ण विजय' का उत्सव है।"
            "राजा को अपना राज्य मिला और वैश्य को मोक्ष—यह दिखाता है कि देवी हर ज़रूरत की स्वामिनी हैं।"
            "सावर्णि मनु (राजा सुरथ का भविष्य) यह बताता है कि आज की साधना आने वाले युगों की नीव है।"
            "दुर्गा सप्तशती की यह यात्रा 'डर' (Suratha) से शुरू होकर 'वरदान' (Boon) पर खत्म होती है।"
            "जब हम इस पाठ को पूरा करते हैं, तो हमारे अंदर के सारे 'असुर' (विकार) शांत हो जाते हैं।"
            "ॐ—यह वह अंतिम ध्वनि है जो सब कुछ वापस 'शून्य' और 'शांति' में विलीन कर देती है।"
            "यहीं पर मार्कण्डेय ऋषि की यह महान औषधि (कथा) संपूर्ण होती है जो करोड़ों को हील कर चुकी है।"
            "साधक अब इस तेरहवें अध्याय के बाद एक 'नया इंसान' बनकर संसार में वापस लौटता है।"
            "सत्यमेव जयते—सत्य की हमेशा जीत होती है और अज्ञान का अंत हमेशा निश्चित और मंगलकारी होता है।"
        """.trimIndent(),
        english = """
            (The Final Completion): "Right here successfully concludes the Thirteenth Chapter named 'The Bestowing of Boons' from the text."
            "This conclusion is zero mere end of a story, but the celebration of 'Consciousness's Total Victory' over ignorance."
            "The King regained his empire and the Merchant attained Moksha—proving the Goddess satisfies every unique need."
            "Savarni Manu (the King's future) proves that today's spiritual practice is the foundation of future ages."
            "The journey of the Durga Saptashati initiates with 'Fear' (Suratha) and successfully terminates with a 'Boon'."
            "Exactly when we complete this recitation, absolutely all internal 'Demons' (vices) are systematically pacified."
            "Om—This is the final vibration that dissolves everything back into the absolute 'Void' and 'Silence'."
            "Right here concludes the majestic medicine (Narrative) of Sage Markandeya that has healed billions of souls."
            "The practitioner returns to the world as a 'Brand-New Person' following the completion of this Thirteenth Chapter."
            "Truth eternally reigns supreme—the termination of deep-seated ignorance is always certain and auspicious."
        """.trimIndent()
    )
)