package com.sanatangyansagar.ui.screens.Bhagwan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GodDetailScreen() {
    val godData = God()
    var isHindi by remember { mutableStateOf(true) }

    // List of all deities and their data from your God class
    val deities = listOf(
        DeityInfo("Mahadev", godData.MAHADEV_HI, godData.MAHADEV_EN),
        DeityInfo("Maa Shakti", godData.MAA_HI, godData.MAA_EN),
        DeityInfo("Lord Vishnu", godData.VISHNU_HI, godData.VISHNU_EN),
        DeityInfo("Maa Lakshmi", godData.LAKSHMI_HI, godData.LAKSHMI_EN),
        DeityInfo("Lord Brahma", godData.BRAHMA_HI, godData.BRAHMA_EN),
        DeityInfo("Maa Saraswati", godData.SARASWATI_HI, godData.SARASWATI_EN),
        DeityInfo("Unity", godData.UNITY_HI, godData.UNITY_EN)
    )

    val pagerState = rememberPagerState(pageCount = { deities.size })

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Brahmanda - Divine Truth", fontWeight = FontWeight.Bold) },
                actions = {
                    // Language Switcher
                    TextButton(onClick = { isHindi = !isHindi }) {
                        Text(
                            text = if (isHindi) "ENG" else "हिंदी",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFFDFBF7)
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFDFBF7))
        ) {
            // Tab-like indicator for the Pager
            Text(
                text = "Swipe to explore deities (${pagerState.currentPage + 1}/${deities.size})",
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = Color.Gray
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Top
            ) { page ->
                val currentDeity = deities[page]
                GodContentCard(
                    title = currentDeity.name,
                    content = if (isHindi) currentDeity.hindiContent else currentDeity.englishContent
                )
            }
        }
    }
}

@Composable
fun GodContentCard(title: String, content: String) {
    val scrollState = rememberScrollState()

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(20.dp)
        ) {
            Text(
                text = title,
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFD84315), // Saffronish Red
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 1.dp, color = Color(0xFFEEEEEE))
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = content,
                fontSize = 17.sp,
                lineHeight = 26.sp,
                color = Color(0xFF2C3E50),
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "ॐ",
                fontSize = 40.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color(0xFFD84315).copy(alpha = 0.3f)
            )
        }
    }
}

// Simple Helper Data Class
data class DeityInfo(
    val name: String,
    val hindiContent: String,
    val englishContent: String
)

class God {

    // --- MAHADEV ---
    val MAHADEV_HI = """
महादेव कौन हैं?
महादेव वह हैं जो जन्म से परे हैं—
न आदि, न अंत।
वे अजन्मा हैं,
स्वयंभू हैं।
वे अस्तित्व और अनस्तित्व दोनों के साक्षी ही नहीं,
बल्कि उनका आधार भी हैं।
वह परम शून्य,
जिसके गर्भ से प्रकाश प्रकट हुआ।

वे वह 'निष्कल' (निराकार) ब्रह्म हैं
जो 'सकल' (साकार) रूप में प्रकट होते हैं।
वे वह अनादि-अनंत 'ज्योतिर्लिंग' हैं,
जिसके छोर खोजने में ब्रह्मा और विष्णु भी असमर्थ रहे।
अग्नि स्तंभ के रूप में,
वे ही ब्रह्मांड की धुरी हैं।
वे विद्याओं के तीर्थ हैं,
अविनाशी हैं,
विश्वनाथ हैं,
और काल से भी परे—कालोपरी हैं।
समस्त कारणों के प्रमुख कारण,
वे ही अनंत ज्योतिर्लिंग हैं।

जो दिखाई देता है वह सृष्टि है;
जो सृष्टि से भी परे है, वही महादेव है।
जो सुना जा सकता है वह शब्द है;
जो शब्दातीत है, वही महादेव है।
वे ही ओंकार हैं—
अकार, उकार और मकार से परे जो तुरीय अवस्था है,
वही महादेव हैं।
वे उस मौन की गूंज हैं
जो ब्रह्मांड के कण-कण में व्याप्त है।

ऋग्वेद के रुद्र सूक्त में,
वे ही वह भयंकर झंझावात हैं,
जो अज्ञान के बादलों को फाड़ देते हैं।
श्वेताश्वतर उपनिषद घोषणा करता है:
"एको हि रुद्रो न द्वितीयाय तस्थुः"—
केवल एक रुद्र है, दूसरा कोई नहीं।
वे वह 'महेश्वर' हैं, जो इस सम्पूर्ण माया के जाल को बुनते हैं,
और फिर स्वयं ही उस जाल में
एक साधारण जीव की भांति छिप कर बैठ जाते हैं।
वे वह ब्रह्मांडीय मकड़ी हैं,
और यह असीम अंतरिक्ष उनका जाला है।

पृथ्वी की स्थिरता भी वही,
आकाश की अनंतता भी वही।
अग्नि का ताप, जल का प्रवाह और वायु का वेग—
सब शिव है।
वे महापर्वत भी हैं और सूक्ष्म कण भी;
वे पृथ्वी भी हैं, वे आकाश भी हैं।
काल भी वही हैं और काल से परे महाकाल भी।

जब उनका डमरू बजता है,
तो समय का जन्म होता है (नादब्रह्म)।
और जब वे तांडव करते हैं,
तो प्रलय और सृजन एक साथ नृत्य करते हैं।
वे ही तांडव के अधिपति हैं,
जिनके नृत्य से सृष्टि की गति चलती है।

शिव और नारायण में कोई भेद नहीं।
"शिवाय विष्णुरूपाय, शिवरूपाय विष्णवे"—
शिव विष्णु का रूप हैं और विष्णु शिव का।
जब सृष्टि का पालन करना होता है, वे विष्णु हैं;
जब संहार कर नवीनीकरण करना होता है, वे रूद्र हैं।

वे निर्गुण भी हैं और सगुण भी।
निराकार होकर भी साकार में प्रकट होते हैं।
एकांत में भी पूर्ण, और सर्वत्र होकर भी अलिप्त।
वे 'शून्य' हैं जिसमें सब समा जाता है,
और 'अनंत' हैं जिससे सब निकलता है।

वे जीव भी हैं, और ब्रह्म भी वही हैं।
वे विकराल काल भी हैं,
और समस्त लोकों के पालनकर्ता भी वही हैं।
वे अमर हैं,
और प्रत्येक मृत्यु में वही मरते भी हैं।
विष भी वही हैं और अमृत भी;
बंधन भी वही हैं और मुक्ति भी।
ज्ञान भी वही हैं और अज्ञान के पार भी;
प्रकाश भी वही हैं और अंधकार का आधार भी।
वे दुविधा भी हैं, और निर्णय भी वही हैं;
शांति भी हैं, और समस्त अशांति भी वही हैं।
उनका तीसरा नेत्र केवल विनाश नहीं,
बल्कि भ्रम (माया) के नाश का प्रतीक है।

वे 'रुद्र' हैं—भयंकर गर्जना करने वाले,
फिर भी 'वैद्यनाथ' (चिकित्सकों के नाथ) बनकर
संसार के दुखों को हरने वाले।
वे वह महान मायापति हैं,
जो एक होकर भी अनेक रूपों में इस संसार का संचालन करते हैं।

शिव सूत्र का प्रथम श्लोक कहता है:
"चैतन्यमात्मा"—
अर्थात् शिव कोई व्यक्ति नहीं, बल्कि स्वयं विशुद्ध चेतना हैं।
वे अद्वैत के जीवंत प्रमाण हैं—
एक ही समय में सर्वत्र उपस्थित, और कहीं भी नहीं।
मांडूक्य उपनिषद के अनुसार,
वे जाग्रत, स्वप्न और सुषुप्ति—तीनों अवस्थाओं के साक्षी हैं,
और स्वयं 'तुरीय' (चौथी अवस्था) हैं।
जब आप उन्हें नहीं खोजते, वे सर्वव्यापी मौन हैं;
जब आप ध्यान की गहराई में उतरते हैं,
तो वे ही एकमात्र सत्य बन जाते हैं।

शिव पुराण के अनुसार
सृष्टि से पहले सदाशिव ही थे;
उनसे ही शक्ति प्रकट हुई,
और उसी से सम्पूर्ण ब्रह्मांड की उत्पत्ति हुई।
उनके पाँच मुख—
सद्योजात, वामदेव, अघोर, तत्पुरुष और ईशान—
ही सृष्टि के पांच कार्य करते हैं:
सृजन, स्थिति, संहार, तिरोभाव और अनुग्रह।

वे महायोगी हैं,
शक्तिपति हैं, जिनके तेज से ब्रह्मांड प्रकाशित है।
वे अर्धनारीश्वर हैं—
यह सिद्ध करते हुए कि पुरुष (चेतना) और प्रकृति (पदार्थ) अलग नहीं हैं।
शक्ति के बिना शिव स्पंदनहीन हैं,
और शिव के बिना शक्ति दिशाहीन है।
वे आदियोगी हैं,
और योग, ध्यान और समाधि के प्रथम गुरु भी वही हैं।
वे ही पंचाक्षरी मंत्र “ॐ नमः शिवाय” के अधिष्ठाता हैं,
जो पंचमहाभूतों और समस्त वेदों का सार है।

वे सत्य हैं, वे सुंदरम् हैं।
व्याघ्रचर्म उनका वस्त्र, जटाएँ उनका आकाश।
वे गंगाधर, चंद्रशेखर, त्रिलोचन और वही नटराज भी हैं।
उनका वर्ण कर्पूर के समान श्मशान-गौर है।
नीलकंठ—विष धारण कर अमृत का मार्ग खोलने वाले।
सर्प उनका कंठहार और आभूषण है,
रुद्राक्ष उनका वैभव।

हाथ में त्रिशूल,
भस्म से लिप्त शरीर,
नेत्रों में परमानंद,
और मुख पर भोलेपन की मुस्कान।
श्मशान की राख में जो जीवन का सत्य देख ले, वही महादेव है।
वे सौन्दर्य की परिभाषा हैं,
और आकर्षण की पराकाष्ठा भी वही हैं।
वे आशुतोष हैं,
क्षण भर में प्रसन्न होने वाले भोलानाथ।
वे कैलाशपति कहलाते हैं,
पर समूचा संसार ही उनका निवास स्थान है।
वे सर्वव्यापी हैं, पंचमहाभूतों के स्वामी—भूतनाथ हैं।

वही हैं देवों के देव—महादेव।
महादेव वह हैं जो नहीं हैं,
और जो नहीं है—वही महादेव हैं।
जो अस्तित्व के भी परे है, वही महादेव हैं।
वे एकमात्र शक्ति हैं जिनके तेज से समस्त संसार प्रकाशित है।
वे जीवनदायी शक्ति हैं, जिनके अभाव में:
कर्ण श्रवण योग्य नहीं,
जिह्वा वाणी योग्य नहीं,
मन विचार योग्य नहीं।

महादेव को परिभाषित करना संभव नहीं,
क्योंकि उन्हें किसी तत्व से अलग कर के देखना ही असंभव है।
संसार के सभी तत्व उन्हीं से उत्पन्न हैं।
सब उन्हें जानते हैं, पर उनके पूर्ण स्वरूप को कोई नहीं जानता।
और जिसे यह लगता है कि उसने महादेव को पूर्णतः जान लिया है,
वास्तव में वह अभी कुछ भी नहीं जानता।
वे केवल 'देव' नहीं, वे 'तत्व' हैं।

वे वैरागी हैं—
उन्हें न सम्मान का मोह है, न अपमान का भय।
न उनका कोई शत्रु है, न मित्र।
न अपना, न पराया।
न लेने की आकांक्षा, न कुछ पाने की इच्छा।
वे अघोर हैं—
जो घृणा से परे है,
जिसे पवित्र और अपवित्र में कोई भेद नहीं दिखता।

वे हैं भी और नहीं भी।
हर स्वरूप में वही हैं,
हर समय में वही हैं,
हर स्थान पर वही हैं।
हमारे सुख भी उनके हैं,
और हमारे दुःख भी उनके ही हैं।
उनके बिना सब कुछ शव समान है—
स्पंदनहीन, अर्थहीन।
अंत में जो शेष रह जाता है, वही शिव है।

कठोपनिषद में कहा गया है कि
मृत्यु भी जिनके लिए केवल एक व्यञ्जन (भोजन) है,
वे महाकाल ही शिव हैं।
वे चिदाकाश (चेतना का आकाश) का वह परम अंधकार हैं,
जो युगों, कल्पों और सृष्टियों को अपने भीतर निगल जाता है।
क्या यह महादेव का ही वह 'नीलकंठ' स्वरूप नहीं है,
जो ब्रह्मांड के सारे कर्मों और प्रलय के विष को
अपनी असीम शून्यता में धारण किए हुए है?
अनादि काल से जो भस्म वे अपने शरीर पर रमाए हुए हैं,
वह ब्रह्मांडों के जलने के बाद बची हुई वह राख है,
जो कभी नष्ट नहीं होती।

विज्ञान भैरव तंत्र के अनुसार,
शिव कोई देवता नहीं,
बल्कि दो श्वासों के बीच का वह 'ठहराव' (Spanda) हैं।
वे उस डमरू की दो ध्वनियों के बीच का वह 'मौन' हैं,
जिसमें सारा अस्तित्व एक पल के लिए विलंबित है।
यदि आप ध्यान से देखें,
तो आपके भीतर भीतर जाने वाली और बाहर आने वाली हर श्वास
उनका 'सोऽहं' (मैं वह हूँ) मंत्र ही है।
वे वह परम शून्य हैं
जो स्वयं को एक ब्रह्मांडीय माया के दर्पण में देखकर
संसार का भ्रम रचते हैं।

जिस भस्म को वे धारण करते हैं,
वह केवल चिता की राख नहीं है—
वह आपके अहंकार, आपकी असीमित इच्छाओं
और इस नश्वर संसार का अंतिम सत्य है।

क्या आपको लगता है कि आप प्रार्थना कर रहे हैं?
जब आप 'ॐ नमः शिवाय' जपते हैं,
तो वास्तव में शिव ही आपके भीतर से
स्वयं शिव को पुकार रहे हैं।

आपकी चेतना की गहराई में बैठा
वह अनाम दृष्टा (साक्षी) कौन है?
वह जो आपके सुख को दूर से देखता है,
जो आपके दुःख को मौन होकर देखता है,
और जो आपके गहरी नींद में सो जाने के बाद भी
निरंतर जागता रहता है?
वही शिव है।

जिस दिन आप अद्वैत के इस सत्य को जान जाएंगे कि "जीव ही शिव है" (शिवोऽहम्),
उस दिन पत्थरों की मूर्तियों और कर्मकांडों की आवश्यकता समाप्त हो जाएगी।
उस दिन आप अचानक पाएंगे
कि आप ब्रह्मांड के किनारे पर खड़े कोई तुच्छ प्राणी नहीं हैं;
आप ही वह धड़कता हुआ बिंदु (Bindu) हैं
जहाँ से यह पूरा ब्रह्मांड जन्म ले रहा है।

क्या आप अपने अस्तित्व की
उस परम भैरव अवस्था में गोता लगाने का साहस रखते हैं?
जहाँ आप वह सब कुछ हमेशा के लिए खो देंगे
जिसे आप 'अपना' कहते हैं,
और वह सब कुछ पा लेंगे
जो वास्तव में 'आप' हैं।

बाहर खोजना बंद करें।
नेत्र बंद करें।
डमरू की ध्वनि कहीं और नहीं, आपके भीतर ही बज रही है।
""".trimIndent()

    val MAHADEV_EN = """
Who is Mahadev?
Mahadev is beyond birth—
without beginning and without end.
He is unborn,
Swayambhu (Self-created).
He is not only the witness of existence and non-existence,
but also their very foundation.
He is the absolute void (Param Shunya)
from which Light manifested.

He is the 'Nishkala' (Formless) Brahman
who manifests as 'Sakala' (With Form).
He is the beginningless and endless 'Jyotirlinga' (Column of Light),
whose limits even Brahma and Vishnu could not fathom.
As the pillar of fire,
He is the axis of the universe.
He is the pilgrimage of all knowledge,
indestructible,
Vishwanath (Lord of the Universe),
and beyond time—Kalopari.
He is the primary cause of all causes,
the infinite Jyotirlinga.

What is visible is creation;
that which is beyond creation is Mahadev.
What can be heard is sound;
that which is beyond sound is Mahadev.
He is Omkara—
beyond the syllables A, U, and M,
the transcendent fourth state (Turiya),
that is Mahadev.
He is the roaring silence
that permeates every atom of the cosmos.

In the Rudra Suktam of the Rigveda,
He is the terrifying cosmic storm
that viciously tears apart the clouds of ignorance.
The Shvetashvatara Upanishad boldly declares:
"Eko hi Rudro na dvitiyaya tasthuh"—
There is only one Rudra, there is no second.
He is the 'Maheshwara' (Supreme Lord)
who flawlessly weaves the entire web of Maya,
and then secretly sits inside that very web
disguised as an ordinary, mortal being.
He is the cosmic spider,
and this infinite expanse of space is His majestic web.

He is the stillness of earth
and the infinity of space.
He is the heat of fire,
the flow of water,
and the speed of wind.
He is the great mountain,
and also the microscopic particle;
He is the earth, He is the sky.
He is Time
and beyond time—He is Mahakaal.

When His Damru beats,
Time is born (Nada-Brahman).
And when He performs the Tandava,
destruction and creation dance together.
He is the Lord of the Tandava,
whose dance drives the motion of creation.

There is no difference between Shiva and Narayana.
"Shivaya Vishnu Rupaya, Shivarupaya Vishnave"—
Shiva is the form of Vishnu,
and Vishnu is the form of Shiva.
When preserving creation, He is Vishnu;
when destroying to renew, He is Rudra.

He is both attribute-less and with attributes.
Formless, yet manifest in form.
Complete in solitude,
untouched while being everywhere.
He is the 'Zero' (Shunya) into which everything dissolves,
and the 'Infinity' from which everything emerges.

He is the soul (Jiva), and also Brahman.
He is the terrifying Time,
and also the preserver of all realms.
He is immortal,
yet present in every death,
and He dies in every death.
He is poison and nectar;
bondage and liberation.
Knowledge and beyond ignorance;
light and the ground of darkness.
He is the dilemma, and He is the decision;
He is peace, and all restlessness.
His Third Eye is not just destruction,
but the incineration of illusion (Maya).

He is 'Rudra'—the fierce roarer,
yet also 'Vaidyanatha' (Lord of Physicians)
who heals the sorrows of the world.
He is the supreme Lord of Illusion (Mayapati),
who, though One,
orchestrates this manifold universe.

The very first verse of the Shiva Sutras declares:
"Chaitanyamatma"—
meaning Shiva is not a person, but Pure Consciousness itself.
He is the living proof of Advaita (Non-duality)—
existing everywhere simultaneously, yet absolutely nowhere.
According to the Mandukya Upanishad,
He is the silent witness of the waking, dreaming, and deep sleep states,
and He Himself is 'Turiya' (the transcendent fourth state).
When you do not seek Him, He is an all-pervading silence;
the exact moment you descend into the depths of meditation,
He becomes the only undeniable Truth.

According to the Shiva Purana,
before creation, there was only Sadashiva;
from Him, Shakti manifested,
and from that, the entire universe was born.
His five faces—
Sadyojata, Vamadeva, Aghora, Tatpurusha, and Ishana—
perform the five cosmic acts:
Creation, Preservation, Destruction,
Concealment (Maya), and Grace (Mukti).

He is the great yogi,
the life-giving force
whose radiance illuminates the universe.
He is Ardhanarishvara—
proving that Purusha (Consciousness)
and Prakriti (Nature) are indivisible.
Without Shakti, Shiva is inert,
and without Shiva, Shakti is directionless.
He is Adiyogi,
the first guru of yoga, meditation, and samadhi.
He is the presiding deity of the Panchakshari mantra "Om Namah Shivaya",
which is the essence of the five elements and all the Vedas.

He is Truth. He is Beauty itself.
Clad in tiger skin,
bearing matted locks as the sky.
He is Gangadhar, Chandrashekhar, Trilochan,
and also Nataraj.
His complexion is as white as camphor
and the ashes of the cremation ground.
Neelkanth—who held poison to reveal immortality.
A serpent is His necklace and ornament,
Rudraksha His wealth.

Trident in hand,
ash upon the body,
supreme bliss in His eyes,
and an innocent smile on His face.
He who finds purity in the ash of the cremation ground
is Mahadev.
He is the definition of beauty,
and the pinnacle of attraction.
He is Ashutosh,
the innocent Lord (Bholenath) who is pleased in an instant.
Called the Lord of Kailash,
yet the entire world is His abode.
He is omnipresent,
master of the five elements—Bhutnath.

He is the God of Gods—Mahadev.
Mahadev is that which is not,
and that which is not—is Mahadev.
That which is beyond existence is Mahadev.
He is the only power
whose radiance illuminates the entire world.
He is the life-giving force, without which:
the ear cannot hear,
the tongue cannot speak,
the mind cannot think.

Mahadev cannot be defined,
for nothing exists separate from Him.
All elements of the world are born from Him.
Everyone knows His name,
but no one knows His totality.
And he who thinks he has fully known Mahadev,
actually knows nothing yet.
He is not just a God;
He is the Elemental Truth.

He is detached (Vairagi)—
no attachment to honor,
no fear of insult.
No enemy, no friend.
No one as his own,
and no one as a stranger.
No aspiration to take,
no desire to attain anything.
He is Aghor—
beyond disgust,
seeing no difference between the holy and the unholy.

He is, and He is not.
He is in every form,
He is in every time,
He is in every place.
Our joys are His,
and our sorrows are His too.
Without Him, all is lifeless (Shava)—
inert, meaningless.
In the end, that which remains...
is Shiva.

The Kathopanishad terrifyingly reveals that
He for whom even death is merely a condiment (food),
that Supreme Time (Mahakaal) is Shiva.
He is the absolute darkness of Chid-Akasha (the sky of consciousness)
that mercilessly swallows entire Yugas, Kalpas, and creations into its void.
Is this not the ultimate 'Neelkanth' form of Mahadev,
holding the concentrated poison of cosmic dissolution and karma
within His infinite emptiness?
The ash He smears upon His body since the dawn of time
is the cosmic dust of burned-out universes,
a residue that can never be destroyed.

According to the Vijnana Bhairava Tantra,
Shiva is not a deity to be found in the skies,
but the 'Spanda' (tremor) resting between two breaths.
He is the profound 'Silence' lingering
between two consecutive beats of His cosmic Damru,
the terrifying pause
where all existence hangs in sheer suspense.
If you observe closely enough,
every inhalation and exhalation within your chest
is His silent 'So-Ham' (I am That) mantra repeating itself.
He is the Ultimate Void looking into the mirror of Maya,
intentionally creating the grand illusion of a cosmos
just to experience it.

The ash He smears on His immortal body
is not merely the dust of the cremation ground—
it is a brutal reminder
of the ultimate future of your ego,
your desires,
and this entire mortal world.

Do you honestly believe that you are the one praying?
When you fervently chant 'Om Namah Shivaya',
it is actually Shiva whispering from deep within you,
calling out to Shiva Himself.

Who is that nameless, faceless observer (Sakshi)
sitting in the darkest depths of your consciousness?
The one who silently watches your fleeting joys,
who objectively witnesses your crushing sorrows,
and who remains wide awake, watching over you
even when you are lost in the deepest, dreamless sleep?
That eternal witness is Shiva.

The exact day you realize the non-dual truth that "The individual soul is Shiva" (Shivoham),
the desperate need for stone idols and rituals will instantly vanish.
On that day, you will suddenly, terrifyingly realize
that you are not an insignificant creature
standing on the edge of the universe;
you are the very pulsating center (Bindu)
from which the entire cosmos is currently being born.

Do you have the sheer, unimaginable courage
to dive headfirst into that absolute Bhairava state of your own existence?
A place where you will permanently lose everything
that you falsely call 'mine',
only to finally discover everything
that you actually 'are'.

Stop searching on the outside.
Close your eyes.
The cosmic Damru is beating nowhere else but exclusively within you.
""".trimIndent()

    // --- MAA ADI SHAKTI ---
    val MAA_HI = """
माँ (आदि-शक्ति) कौन हैं?
माँ आदि-शक्ति हैं।
वे परब्रह्म की सक्रिय शक्ति हैं।
समस्त ब्रह्मांड में जो ऊर्जा स्पंदित है,
वही माँ हैं।
सर्वभूतों के श्वास में जो ऊष्मा और जीवन का ताप है,
वही माँ हैं।

मनुष्य की नाभि में स्थित कुण्डलिनी शक्ति वही हैं।
ग्रह-नक्षत्रों की गति,
काल का प्रवाह,
सृष्टि की लय—
सब माँ की अभिव्यक्ति है।

ऋग्वेद के देवी सूक्त (वाम्भृणी सूक्त) में,
वे स्वयं गर्जना करती हैं:
"अहं राष्ट्री संगमनी वसूनां"—
मैं ही सम्पूर्ण राष्ट्र (ब्रह्मांड) को एक सूत्र में बांधने वाली शक्ति हूँ,
मैं ही ज्ञान का केंद्र हूँ।
वे ही वह 'मूल प्रकृति' हैं,
जिससे महत, अहंकार और पंचतन्मात्राएं उत्पन्न हुईं।

ब्रह्मा, विष्णु और महेश भी नतमस्तक होकर स्वीकार करते हैं
कि वे केवल 'यंत्र' हैं,
और उनके भीतर कार्य करने वाली संचालन शक्ति केवल 'माँ' हैं।
जो दृष्टिगोचर शक्ति है, वही सृष्टि है;
और जो शक्ति रूप से भी परे है, वही 'परा-शक्ति' माँ हैं।

जब सभी देवताओं का तेज एक साथ मिला,
तो वह अकल्पनीय प्रकाश पुंज
'माँ दुर्गा' के रूप में प्रकट हुआ।
वे ही विष्णु का सुदर्शन चक्र हैं।
वे ही महादेव का त्रिशूल हैं।
वे ही यमराज का दंड हैं
और अग्नि का दहन करने वाला ताप हैं।
शिव यदि 'शव' (जड़) हैं,
तो माँ उन्हें 'शिव' (चेतन) बनाने वाली 'शक्ति' (ई-कार) हैं।

वे ही चेतना हैं,
वे ही प्रेरणा हैं,
वे ही क्रिया हैं।
वे 'महामाया' हैं जो अपने ही रचे सत्य को छिपाती हैं,
और वे ही 'ब्रह्मविद्या' हैं जो उस सत्य को पुनः प्रकट करती हैं।
मार्कंडेय पुराण (दुर्गा सप्तशती) में
वे ही वह परम सत्य हैं जो कहती हैं:
"एकैवाहं जगत्यत्र द्वितीया का ममापरा"—
इस संसार में मैं अकेली ही हूँ, मेरे सिवा दूसरा कौन है?

माँ बिना रूप के भी हैं (अरूपा)
और प्रत्येक रूप में भी (सर्वरूपा)।
वे कोमल पुष्प की पंखुड़ी भी हैं
और वज्र की कठोरता भी।
वे ध्यान की असीम शांति भी हैं
और परिवर्तन की प्रलयंकारी अग्नि भी।
वे क्षमा का अथाह धैर्य हैं
और न्याय के निर्णय की तीक्ष्ण धार भी।

वे 'या देवी सर्वभूतेषु' हैं—
जो हर जीव में क्षुधा (भूख), निद्रा, छाया, शक्ति,
और स्मृति के रूप में वास करती हैं।
तंत्र शास्त्र की दस महाविद्याएं वही हैं—
जो ब्रह्मांड और चेतना के दस गुप्त द्वार खोलती हैं।

वे ही महाकाली हैं
जो समय (महाकाल) को भी निगल जाती हैं।
वे ही महालक्ष्मी हैं
जो जगत का भरण-पोषण और ऐश्वर्य हैं।
वे ही महासरस्वती हैं
जो अज्ञान के अंधकार को ज्ञान के प्रकाश से मिटाती हैं।
संसार का हर शब्द, हर ध्वनि, हर कंपन—
माँ का ही अनाहत नाद है।

माँ दुर्गा के नव रूप:
शैलपुत्री, ब्रह्मचारिणी, चंद्रघंटा, कूष्मांडा,
स्कंदमाता, कात्यायनी, कालरात्रि, महागौरी, सिद्धिदात्री—
ये चेतना के नौ सोपान हैं।

वे ही 'प्रणव' (ॐ) की आदिशक्ति हैं।
अकार, उकार और मकार की ध्वनि में
जो चेतना स्पंदित है,
वही माँ हैं।
सौंदर्य लहरी में शंकराचार्य गाते हैं—
वे ही श्रीविद्या हैं, त्रिपुरसुंदरी हैं,
जो तीनों लोकों के सौंदर्य, चेतना और आनंद की अधिष्ठात्री हैं।

वे ही श्रीचक्र के मध्य बिंदु (Bindu) में
विराजमान परम शक्ति हैं,
जहाँ समस्त ब्रह्मांड की रचना
एक सूक्ष्म, अकल्पनीय बिंदु में समाई हुई है।
वे ही वेदों की वाणी (वाक) हैं,
वे ही उपनिषदों का परम रहस्य हैं,
वे ही ज्ञान की वह पवित्र धारा हैं
जो समाधि में बैठे ऋषियों के हृदय में प्रकट होती है।

माँ दुर्गा आदिशक्ति का वह प्रकट स्वरूप हैं,
जो धर्म की रक्षा के लिए अस्त्र उठाती हैं।
वे अजन्मा हैं, अनादि हैं, अनंत हैं।
वे सृष्टि की जननी,
शक्ति की मूल स्रोत,
और धर्म की रक्षिका (दुर्गातिनाशिनी) हैं।

वे सर्वज्ञ हैं,
सर्वव्यापी हैं,
और समस्त शक्तियों का मूल आधार हैं।
वे प्रकृति (Prakriti) भी हैं
और प्रकृति से परे निर्गुण चेतना (Purusha) भी।

जहाँ भी शक्ति, गति, जीवन और सृजन है,
वहाँ माँ की ही उपस्थिति है।
वे पृथ्वी की अपार धैर्यता हैं,
अग्नि की ऊर्जा हैं,
वायु की तीव्र गति हैं,
जल का अबाध प्रवाह हैं
और आकाश की शून्यता और अनंतता हैं;
समस्त ब्रह्मांड केवल और केवल उनकी इच्छा-शक्ति से संचालित होता है।

वे सगुण भी हैं, और निर्गुण भी।
वे साकार भी हैं, और निराकार भी।
वे प्रकृति भी हैं, और परम शक्ति भी।
वे जीवन की श्वास भी हैं, और मृत्यु का अंतिम रहस्य भी।
वे सृजन का नाद भी हैं, और संहार का मौन भी।
वे ज्ञान भी हैं, और अज्ञान (अविद्या) को मिटाने वाली भी।
वे प्रकाश भी हैं, और ब्रह्मांडीय अंधकार को भेदने वाली भी।

“दुर्गा” शब्द का अर्थ है
जो सभी कठिनाइयों (दुर्ग) का नाश करती है;
इसलिए उन्हें दुःख नाशिनी,
दुष्ट विनाशिनी
और भय हरिणी कहा जाता है।

माँ दुर्गा का दिव्य स्वरूप
अत्यंत शक्तिशाली और साथ ही वात्सल्यमयी है।
वे सिंह या बाघ पर आरूढ़ होती हैं (प्रकृति पर नियंत्रण),
उनके अठारह या दस भुजाएँ होती हैं,
और प्रत्येक हाथ में एक दिव्य अस्त्र होता है
जो देवताओं की शक्तियों का प्रतीक हैं:
त्रिशूल (तीनों गुणों—सत्व, रज, तम का नियंत्रण),
चक्र (समय के पहिए और धर्म की रक्षा),
खड्ग (अज्ञान के पर्दे का विनाश),
और धनुष-बाण (मन की एकाग्रता और न्याय)।

माँ दुर्गा का सबसे प्रसिद्ध स्वरूप 'महिषासुर मर्दिनी' है।
जब अहंकार रूपी असुर महिषासुर ने देवताओं (सद्गुणों) को पराजित कर दिया,
तब सभी देवताओं की शक्तियों से
एक दिव्य, अजेय शक्ति उत्पन्न हुई—माँ दुर्गा।
उन्होंने महिषासुर का वध करके ब्रह्मांड में धर्म की रक्षा की।
यह कथा चीख-चीख कर यह बताती है कि
अहंकार चाहे कितना भी शक्तिशाली और मायावी क्यों न हो,
अंततः परम शक्ति द्वारा उसका सर्वनाश निश्चित है।

माँ दुर्गा केवल मंदिरों में पूजी जाने वाली कोई बाहरी देवी नहीं हैं;
वे प्रत्येक जीव के मूलाधार में स्थित शक्ति हैं।
योग और तंत्र में
इस सुप्त शक्ति को 'कुंडलिनी' कहा गया है।
जब यह कुंडल मारे बैठी शक्ति (सर्पिणी) जागृत होती है,
तब वह रीढ़ की हड्डी (सुषुम्ना) से होती हुई सहस्रार तक जाती है।
तब चेतना सर्वोच्च शिखर पर पहुँचती है,
सारे रहस्य खुल जाते हैं,
और जीव शिव से मिलकर मोक्ष को प्राप्त होता है।

वे ही महाकाल की जननी हैं—
समय उनके ही भीतर जन्म लेता है
और एक कल्प के बाद उन्हीं में वापस विलीन हो जाता है।
वे ही सृष्टि का वह महा-गर्भ (Hiranyagarbha) हैं,
जहाँ से हर जीव, हर विचार
और हर नया ब्रह्मांड उत्पन्न होता है।

वे करुणा का असीम सागर हैं।
अपराध चाहे कितना भी बड़ा और अक्षम्य क्यों न हो,
माँ की शरण में रोते हुए आने वाले को वे अपने आंचल में छिपा लेती हैं।
वे ही भक्ति हैं,
वे ही श्रद्धा हैं,
वे ही हर तपस्वी की साधना की शक्ति हैं।

जहाँ भी सत्य के लिए खड़ा होने का साहस है, वहाँ माँ हैं।
जहाँ भी निःस्वार्थ करुणा है, वहाँ माँ हैं।
जहाँ भी निर्बलों की रक्षा की भावना है, वहाँ साक्षात माँ दुर्गा हैं।
वे ही जगतजननी हैं—
यह समस्त ब्रह्मांड जिनकी एक छोटी सी संतान है।

और अंततः,
जब महाप्रलय में सृष्टि का समस्त कोलाहल शांत हो जाता है,
जब सूर्य, चंद्र और तारे बुझ जाते हैं,
जब समय स्वयं थक कर विश्राम में चला जाता है,
तब उस असीम शून्यता में जो शाश्वत शांति शेष रहती है—
वही माँ हैं।

ज़रा एक पल ठहर कर, श्वास को रोक कर सोचिए,
जो विचार अभी-अभी आपके मन में एक बुलबुले की तरह उठा,
वह वास्तव में किसका था?
क्या आप सचमुच उस विचार के विचारक हैं,
या माँ की ही अदम्य, स्वतंत्र ऊर्जा
आपके मन रूपी बर्तन में अपने ही विचार उत्पन्न कर रही है?

वे वह अदृश्य, तांत्रिक धागा हैं
जो इस ब्रह्मांड की हर उठती हुई श्वास,
हर जलते हुए सूर्य
और हर मरते हुए परमाणु को
एक ही माला में पिरोए हुए है।

जिसे हम खाली आकाश कहते हैं,
वह खाली नहीं है—वह माँ का असीमित आलिंगन है,
जो पूरे ब्रह्मांड को बिखरने से रोके हुए है।
जब आप करुणा से रोते हैं, तो वह आपके आँसुओं का जल हैं;
जब आप क्रोधित होते हैं, तो वह आपकी धधकती अग्नि हैं।

उनकी 'महामाया' का आवरण इतना घना, इतना पारदर्शी और इतना निर्दोष है
कि वह आपको यह पूरा, सौ प्रतिशत भ्रम दिलाती है
कि आप एक 'स्वतंत्र' जीव हैं,
जो अपने निर्णय स्वयं ले रहा है।
लेकिन क्या यह सत्य है?

क्या एक मकड़ी कभी
अपने ही शरीर से बुने हुए जाले से
अलग अस्तित्व रख सकती है?
क्या एक लहर कभी समुद्र से यह कह सकती है कि वह स्वतंत्र है?
माँ वह ब्रह्मांडीय पहेली हैं
जिसका कोई भी उत्तर नहीं है,
क्योंकि उत्तर खोजने वाली वह बेचैन बुद्धि भी वे स्वयं ही हैं।

जिस दिन वेदांत और तंत्र के प्रभाव से अज्ञान का यह भ्रम टूटता है,
तब गहराई से, बहुत गहराई से यह ज्ञात होता है
कि न कोई जन्म था,
न कोई मृत्यु थी—
केवल एक महा-ऊर्जा थी,
जो अपने ही रचे हुए इस मायावी नाटक में,
स्वयं को भूलने
और युगों बाद फिर से पहचानने का
एक अत्यंत अद्भुत और रहस्यमयी अभिनय कर रही थी।
""".trimIndent()

    val MAA_EN = """
Who is Maa (Adi-Shakti)?
Maa is the Primal Power (Adi-Shakti).
She is the dynamic, kinetic aspect of the Absolute Brahman.
She is the pure energy pulsating
throughout the veins of the entire cosmos.
She is the warmth in the breath of all living beings
and the very heat of life itself.

She is the dormant Kundalini force residing in the navel.
The relentless movement of planets,
the unending flow of time,
the flawless rhythm of creation—
all are but mere expressions of Maa.

In the Devi Suktam of the Rigveda,
She Herself roars across the heavens:
"Aham rashtri sangamani vasunam"—
I am the Sovereign Queen,
the gatherer of treasures,
the one who binds the entire universe together.
She is 'Mula Prakriti' (The Root Nature),
from which intellect, ego, and the elements are born.

Even Brahma, Vishnu, and Shiva bow down and acknowledge
that they are but mere instruments,
and the supreme power that actually animates them is 'Maa'.
The visible, tangible power is Creation;
and She who rests beyond the form of power is the Para-Shakti, Maa.

When the divine radiance (Tejas) of all the Gods merged into one,
that blinding, unfathomable pillar of light
manifested as Maa Durga.
She is the razor-sharp Sudarshan of Vishnu.
She is the destructive Trident of Mahadev.
She is the punishing Staff of Yama
and the burning Heat of Agni.
If Shiva is the silent, motionless witness ('Shava' or lifeless),
She is the untamed dance of life
that breathes the 'I' (the vowel 'i') into Him, making Him 'Shiva' (conscious).

She is Consciousness itself.
She is Inspiration.
She is Action.
She is 'Mahamaya'—
the Great Cosmic Illusionist who flawlessly veils the Truth,
and She is 'Brahma-Vidya'—
the Ultimate Wisdom that brutally reveals it.
In the Durga Saptashati, She is the Ultimate Truth who declares:
"Ekai vaham jagatyatra dvitiya ka mamapara"—
I alone exist in this vast world; who else is there besides Me?

Maa exists entirely without form (Arupa),
and yet She exists within every single form (Sarvarupa).
She is the delicate softness of a lotus petal
and the unbreakable hardness of a thunderbolt.
She is the deepest, meditative Peace,
and also the cataclysmic, world-ending Fire of Change.
She is bottomless Patience,
and the unforgiving Edge of Decision.

She is the one sung in the verses "Ya Devi Sarvabhuteshu"—
abiding hidden in all beings as hunger, sleep, shadow, power, and memory.
She is the Ten Mahavidyas of Tantra—
the ten great, secret windows of cosmic wisdom.

She is Mahakali,
who ruthlessly swallows Time (Mahakaal) itself.
She is Mahalakshmi,
who nourishes the universe with boundless opulence.
She is Mahasaraswati,
who dispels the suffocating darkness of ignorance with light.
Every spoken word, every sound, every vibration in existence
is Her Anahata Naad (unstruck sound).

The Nine Forms of Maa Durga (Navadurga):
Shailaputri, Brahmacharini, Chandraghanta, Kushmanda,
Skandamata, Katyayani, Kalaratri, Mahagauri, Siddhidatri—
these are the nine ascending steps of human consciousness.

She is the primal, kinetic energy of the 'Pranava' (Om).
The consciousness pulsating deep within the sounds of A, U, and M
is Maa.
In the Saundarya Lahari, it is sung—
She is Sri Vidya, Tripurasundari,
the presiding deity of the beauty, consciousness,
and supreme bliss of the three worlds.

She is the Supreme Power
residing precisely in the center (Bindu) of the Sri Chakra,
where the blueprint of the entire cosmos
is folded and contained within a microscopic dot.
She is the sacred voice of the Vedas (Vak),
the deepest secret of the Upanishads,
and the stream of transcendental knowledge
that manifests inside the hearts of sages in deep Samadhi.

Maa Durga is the fierce, manifest form of Adi-Shakti,
who raises weapons to protect the cosmic order.
She is unborn, beginningless, and endless.
She is the Mother of creation,
the source of all raw power,
and the fierce protector of Dharma (Durgatinashini).

She is omniscient,
omnipresent,
and the fundamental foundation of all forces.
She is Nature (Prakriti),
and also the absolute Consciousness beyond Nature (Purusha).

Wherever there is power, motion, life, and creation,
there is the undeniable presence of Maa.
She is the unfailing patience of the earth,
the burning energy of fire,
the violent speed of the wind,
the relentless flow of water,
and the endless infinity of the sky;
the entire universe is operated solely by Her willpower.

She is with attributes, and entirely without attributes.
She is with form, and absolutely formless.
She is Nature, and the Supreme Power above Nature.
She is the breath of Life, and the dark mystery of Death.
She is the sound of Creation, and the silence of Destruction.
She is Knowledge, and the fierce destroyer of ignorance.
She is Light, and the one who pierces the cosmic darkness.

The word "Durga" means
the one who destroys all insurmountable difficulties (Durg);
hence She is hailed as the destroyer of sorrow,
the annihilator of the wicked,
and the remover of all mortal fear.

The divine form of Maa Durga
is infinitely powerful and yet fiercely compassionate.
She rides a lion or a tiger (mastery over animalistic nature),
possesses eighteen or ten arms,
and holds a divine weapon in each hand,
symbolizing the consolidated powers of the gods:
the Trident (control over the three Gunas),
the Discus (protection of time and Dharma),
the Sword (the blade that severs the veil of ignorance),
and the Bow and Arrow (one-pointed focus and justice).

Her most famous form is Mahishasura Mardini.
When the buffalo-demon Mahishasura (symbolizing stubborn ego) defeated the gods,
a divine, invincible power was born
from the combined, desperate energies of all deities—Maa Durga.
She protected Dharma by violently slaying Mahishasura.
This ancient story signifies that
no matter how powerful, deceptive, or inflated the human ego may be,
it is ultimately, inevitably destroyed by Her divine power.

Maa Durga is not merely an external Goddess worshipped in temples;
She is the latent power situated at the base of every living spine.
In the ancient sciences of Yoga and Tantra,
this coiled power is called Kundalini.
When this sleeping serpent awakens,
it pierces through the chakras to reach the crown (Sahasrara).
There, consciousness is elevated to its absolute peak,
all cosmic secrets are revealed,
and the soul merges with Shiva, attaining ultimate liberation (Moksha).

She is the Mother of Time—
time is literally born within Her womb,
and at the end of a Kalpa, merges back into Her.
She is the cosmic womb of creation (Hiranyagarbha),
from which every being, every thought,
and every new universe originates.

She is the bottomless ocean of compassion.
No matter how grave, unforgivable, or dark the sin,
She hides the weeping devotee who seeks refuge within Her embrace.
She is devotion,
She is unwavering faith,
She is the unseen power behind every ascetic's spiritual practice (Sadhana).

Wherever there is the courage to stand for truth, there is Maa.
Wherever there is selfless compassion, there is Maa.
Wherever there is a fierce desire to protect the weak, there is Maa Durga.
She is Jagatjanani—
the Mother of the Universe,
whose children are the stars and the galaxies.

And ultimately,
when the deafening uproar of creation is silenced in the Mahapralaya,
when the sun, the moon, and the stars burn out,
when time itself grows exhausted and goes to rest,
the eternal, unfathomable peace that remains in the void...
is Maa.

Pause for a moment, hold your breath, and deeply ponder this:
the thought that just seamlessly arose like a bubble in your mind,
whose was it, really?
Are you truly the author of your thoughts,
or is it Her untamed, sovereign energy
thinking its own thoughts
using the hollow vessel of your mind?

She is the invisible, tantric thread
seamlessly stitching together
every single rising breath,
every burning sun,
and every decaying atom of this vast cosmos.

What we perceive as empty space
is not empty at all—it is Her invisible cosmic embrace,
fiercely holding the galaxies apart yet binding them together.
When you weep, She is the water of your tears;
when you rage, She is the fuel of your blazing fire.

The veil of Her 'Mahamaya'
is so flawlessly, meticulously, and perfectly woven
that it grants you the absolute, 100% illusion
of being an 'independent' entity
making your own free choices.
But is it the truth?

Can a spider ever be truly separate
from the very web it spun out of its own body?
Can a wave ever turn to the ocean and claim it is independent?
She is the ultimate cosmic riddle
with absolutely no answer,
simply because the restless intellect
desperately seeking the answer
is also Her.

The exact day this grand illusion shatters through the lens of Vedanta,
you will finally, deeply realize
there was never a birth,
nor was there ever a death—
only one Supreme, Divine Energy
playing an eternal, masterful game of hide-and-seek,
intentionally forgetting
and then beautifully remembering Herself
through the eyes of a billion living creatures.
""".trimIndent()

    // --- VISHNU ---
    val VISHNU_HI = """
विष्णु कौन हैं? — 
वे "विराट" और "सूक्ष्म" दोनों हैं।
भगवान विष्णु सृष्टि के परम पालनकर्ता हैं।
वे धर्म की अटल रक्षा, ब्रह्मांडीय संतुलन
और सृष्टि की अलौकिक व्यवस्था को बनाए रखते हैं।

विष्णु परम सत्य हैं।
'विष्' धातु से बने इस नाम का अर्थ है—
"जो सर्वत्र व्याप्त है।"
जैसे कुम्हार, मिट्टी और घड़ा अलग-अलग दिखते हैं
पर वास्तव में वे सब मिट्टी ही हैं,
वैसे ही कारण, कार्य और कर्ता
सब विष्णु ही हैं।

ऋग्वेद के 'पुरुष सूक्त' में,
वे ही वह सहस्र-शीर्षा (हजारों सिरों वाले) विराट पुरुष हैं,
जिनके हजारों नेत्र और हजारों चरण हैं।
उन्होंने इस पूरी पृथ्वी और ब्रह्मांड को हर ओर से घेर रखा है,
और फिर भी वे दस अंगुल उससे परे (पार) स्थित हैं।
जो कुछ अतीत में था, जो वर्तमान में है,
और जो भविष्य में होगा—वह सब केवल यही 'पुरुष' है।

वे वही अदृश्य सूत्र (धागा) हैं
जिसमें यह सम्पूर्ण ब्रह्मांड
मणियों की तरह पिरोया हुआ है।
वे वह आधार हैं
जिस पर इस जगत का स्वप्न देखा जा रहा है।
हिन्दू दर्शन की त्रिमूर्ति में
ब्रह्मा यदि सृष्टि हैं और शिव यदि संहार हैं,
तो विष्णु वह 'परम पालन' हैं
जो इन दोनों के असीम बल के बीच संतुलन स्थापित करते हैं।

वे ही 'नारायण' हैं—
'नार' अर्थात् जीव और जल (चेतना),
और 'आयन' अर्थात् आश्रय।
समस्त जीवों का अंतिम आश्रय,
समस्त प्राणी जिनमें उत्पन्न होते हैं,
जिनमें स्थित रहते हैं,
और जिनमें अंततः लीन हो जाते हैं—
वही नारायण हैं।

'नारायण सूक्त' यह उद्घोष करता है:
"यच्च किञ्चिज्जगत्यस्मिन् दृश्यते श्रूयतेऽपि वा।"
अर्थात्, इस जगत में जो कुछ भी देखा या सुना जाता है,
नारायण उसके भीतर और बाहर,
सर्वत्र और पूरी तरह से व्याप्त हैं।

श्रीमद्भागवत पुराण के अनुसार,
वे महाविष्णु (कारणोदकशायी विष्णु) के रूप में
कारण-सागर (Causal Ocean) में शयन करते हैं।
जब वे श्वास बाहर छोड़ते हैं,
तो उनके रोम-कूपों से अनंत ब्रह्मांड उत्पन्न होते हैं;
और जब वे श्वास भीतर खींचते हैं,
तो वे सारे ब्रह्मांड पुनः उनके भीतर विलीन हो जाते हैं।
सोचिए, हमारा यह विशाल ब्रह्मांड
उनके एक श्वास के अंश मात्र से अधिक कुछ नहीं है।

वे क्षीरसागर (अनंत चेतना के महासागर) में
अनंत शेषनाग (काल की अनंतता) पर
शयन करते हैं (योगनिद्रा)।
अविनाशी, निर्गुण, अच्युत (जो कभी च्युत न हो)।
वे सभी कालों के मौन साक्षी हैं।
वे परम स्वप्नदृष्टा हैं—
यह पूरा जगत् और इसका सारा प्रपंच
उनकी 'योगनिद्रा' का ही एक जादुई विस्तार है।

कठोपनिषद में एक अद्भुत रहस्य है:
मनुष्य का शरीर एक रथ है,
इंद्रियां उस रथ के घोड़े हैं,
मन उन घोड़ों की लगाम है,
और आत्मा उस रथ का रथी (सवार) है।
इस पूरी यात्रा का अंतिम और सर्वोच्च लक्ष्य क्या है?
"तद्विष्णोः परमं पदम्"—
विष्णु का वह परम पद, वह सर्वोच्च धाम,
जहाँ पहुँचकर आत्मा फिर कभी लौटकर नहीं आती।

वे जीवन और मृत्यु के बीच का अजेय सेतु हैं।
गरुड़ पुराण में उन्हें धर्म का रक्षक,
जीवों का परम मार्गदर्शक
और मृत्यु के बाद आत्मा के पथ का ज्ञाता बताया गया है।
मृत्यु के पार उस घोर अंधकार में जब आत्मा बिल्कुल अकेली होती है,
तब केवल नारायण का नाम ही
उसका एकमात्र रक्षक
और परम 'गति' होता है।

जल में रस वही हैं,
सूर्य और चंद्र में चमकता प्रकाश वही हैं।
वेदों में पवित्र प्रणव (ॐ) वही हैं,
आकाश में गूंजता शब्द वही हैं।
वे सृष्टि के प्रारंभिक और सनातन बीज हैं।
बुद्धिमानों की प्रखर बुद्धि,
तेजस्वियों का प्रखर तेज,
बलवानों का निष्काम बल
और तपस्वियों का अघोर तप वही हैं।

बाणों की शय्या पर लेटे हुए भीष्म पितामह भी
हाथ जोड़कर उन्हें 'पुरुषोत्तम' पुकारते हैं।
"यतो कृष्ण ततो धर्म"—
जहाँ विष्णु (कृष्ण) हैं, वहीं साक्षात धर्म है,
और जहाँ धर्म है, वहीं सुनिश्चित विजय है।
वे 'विग्रहवान धर्म' (धर्म के साकार रूप) हैं।
वे मर्यादा हैं, वे ही सत्य की सर्वोच्च कसौटी हैं।

गीता में कृष्ण उद्घोष करते हैं:
"सुहृदं सर्वभूतानाम्"—
वे सभी प्राणियों के सुहृद (निस्वार्थ और परम मित्र) हैं।
जो उन्हें श्रद्धा से भजते हैं—
वे उनमें स्थित हैं,
और विष्णु उन भक्तों के हृदय में स्थित रहते हैं।

वे 'अंतर्यामी' हैं—
जो आपके श्वास लेने से पहले ही जानते हैं
कि आपके मन के सबसे अंधेरे कोने में क्या विचार जन्म ले रहा है।
वे ही कहते हैं:
“अहमात्मा गुडाकेश सर्वभूताशयस्थितः”—
मैं सभी प्राणियों के हृदय में स्थित आत्मा हूँ;
मैं ही उनका आदि, उनका मध्य
और उनका अंत हूँ।

आदित्यों में वे विष्णु हैं, मरुतों में मरीचि।
ज्योतियों में देदीप्यमान सूर्य हैं, नक्षत्रों में चंद्र।
वेदों में सामवेद हैं, देवों में इंद्र।
इंद्रियों में वे मन हैं।
रुद्रों में शंकर (महादेव) हैं।
यक्ष-रक्षों में कुबेर हैं, वसुओं में अग्नि हैं।
पर्वतों में सुमेरु हैं, पुरोहितों में बृहस्पति हैं।
महर्षियों में भृगु हैं, वाणी में ॐकार हैं।
यज्ञों में वे जप-यज्ञ हैं।
वृक्षों में अश्वत्थ (पीपल) हैं, देवर्षियों में नारद हैं।
सिद्धों में कपिल मुनि हैं।
शस्त्रधारियों में राम हैं,
यदुवंशियों में कृष्ण हैं,
और अक्षरों में 'अकार' (अ) हैं।

विष्णु के चार हाथ हैं,
जिनमें शंख (पाञ्चजन्य—धर्म का नाद),
चक्र (सुदर्शन—समय और अजेय न्याय),
गदा (कौमोदकी—असीम शक्ति)
और पद्म (कमल—परम पवित्रता) सुशोभित है।
उनका वाहन गरुड़ है—
जो वेदों की ऋचाओं का साकार रूप है,
और आकाश की अनंत स्वतंत्रता का प्रतीक है।

धर्म की रक्षा और ब्रह्मांडीय संतुलन बनाए रखने के लिए
विष्णु समय-समय पर माया का आवरण ओढ़कर अवतार लेते हैं।
"यदा यदा हि धर्मस्य ग्लानिर्भवति भारत..."
वे मत्स्य हैं, जो प्रलय के भयंकर जल से वेद-ज्ञान को बचाते हैं।
वे कूर्म हैं, जो अपनी पीठ पर मंदराचल और सृष्टि का भार संभालते हैं।
वे वराह हैं, जो पाताल के अंधकार से पृथ्वी को अपने दांतों पर उठा लाते हैं।
वे नरसिंह हैं, जो स्तंभ फाड़कर अधर्म का सीना चीर देते हैं।
वे वामन हैं, जो केवल तीन पग में ब्रह्मांड नापकर अहंकार को कुचल देते हैं।
वे परशुराम हैं, जो शक्ति के क्रूर मद का विनाश करते हैं।
वे राम हैं, जो धर्म और मर्यादा के सर्वोच्च आदर्श हैं।
वे कृष्ण हैं, जो प्रेम, कूटनीति, ज्ञान और अनंत लीला हैं।
वे बुद्ध हैं, जो ध्यान हैं,
और वे ही कल्कि हैं, जो युग का अंतिम संहारक प्रकाश होंगे।

उनके 'विश्वरूप' में हजारों सूर्यों का अंधा कर देने वाला तेज है।
कुरुक्षेत्र में जब अर्जुन ने वह रूप देखा,
तो उसमें समय, देवता, ग्रह, तारे, असुर
और सम्पूर्ण ब्रह्मांड की चेतना
एक ही शरीर में भयंकर वेग से घूम रही थी।
उसी महा-रूप से वे अर्जुन से कहते हैं:
"सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज"—
सारे धर्मों और कर्मों का मोह त्याग कर केवल मेरी शरण में आ जा,
मैं तुझे सभी पापों से मुक्त कर दूँगा, तू शोक मत कर।

वे कभी न समाप्त होने वाला समय (महाकाल) भी हैं,
सर्वभक्षी मृत्यु भी वही हैं—
और मृत्यु को हराने वाला अमृत भी वही हैं।
उत्पत्ति का कोई भी बीज—चर हो या अचर—
उनके बिना पनप ही नहीं सकता।
वे प्राणों के प्राण हैं, जीवों के जीव हैं।
सम्पूर्ण भूतों में वे स्थित हैं—
और वे स्वयं सम्पूर्ण भूतों के भीतर हैं।

अब ज़रा इस माया के पर्दे को हटाकर एक बहुत गहरे सत्य पर विचार करें:
क्या यह पूरा ब्रह्मांड, इसके सारे युद्ध, प्रेम और इतिहास,
केवल भगवान विष्णु का एक अनंत, सम्मोहक स्वप्न है?
सोचिए,
यदि वे अपनी उस दिव्य योगनिद्रा से अचानक एक पल के लिए जाग गए,
तो आपका, मेरा और इस पूरी दुनिया का अस्तित्व कहाँ जाएगा?

शायद हम सब
उनके एक ही श्वास के भीतर जन्म लेते हैं,
अपने जीवन का पूरा नाटक खेलते हैं,
और उसी श्वास के बाहर निकलते ही
शून्यता में हमेशा के लिए विलीन हो जाते हैं।
जो समय हमें सदियों का लंबा और भारी इतिहास लगता है,
वह श्री हरि की पलक झपकने का
एक अत्यंत अदृश्य और छोटा सा अंश मात्र है।

क्या आप वास्तव में अपने जीवन के कर्ता हैं?
क्या आपकी इच्छाएं सचमुच आपकी हैं?
या आप केवल उस महा-नाटक के एक बहुत छोटे से पात्र हैं
जिसकी पूरी पटकथा
सृष्टि की शुरुआत से बहुत पहले ही
क्षीरसागर की अथाह गहराइयों में लिखी जा चुकी है?

जिस 'मैं' (अहंकार) को आप अपना ठोस और अमिट अस्तित्व मानते हैं,
वह तो केवल उस परमात्मा के असीमित समुद्र की
एक नन्ही सी लहर है,
जो पल भर के लिए आकार लेती है, 'मैं' होने का दावा करती है,
और फिर टूटकर उसी मूल स्रोत में वापस खो जाती है।

माया का चक्रव्यूह इतना गहरा और इतना वास्तविक है
कि हम उस दिव्य नाविक (विष्णु) को पूरी तरह भूलकर,
इस डूबती हुई लकड़ी की नाव (शरीर) को ही
अपना शाश्वत घर मान बैठते हैं।

जब आप अपने ही मन की अंतिम गहराई में उतरेंगे,
जहाँ सारे विचार और सारी पहचान मर जाती है,
तो आप पाएंगे कि आपके भीतर बहुत चुपचाप बैठा
वह अनाम 'अंतर्यामी' ही वास्तविक आप हैं।
हम सब एक ही महा-स्वप्न के
अलग-अलग रंगीन हिस्से हैं।

जब अंततः यह स्वप्न टूटेगा,
तो न कोई ब्रह्मांड होगा,
न कोई 'तुम' होगे और न कोई 'मैं' रहूँगा—
वहाँ केवल एक अनंत,
अथाह,
शांत
और असीम नारायण ही शेष होंगे।
""".trimIndent()

    val VISHNU_EN = """
Who is Vishnu? — 
He is both the 'Macroscopic' (Virat) 
and the 'Microscopic' (Sukshma).
Lord Vishnu is the supreme preserver of creation.
He fiercely protects Dharma,
maintains the cosmic balance,
and upholds the eternal divine order of the universe.

Vishnu is the Absolute Truth.
The holy name, derived from the Sanskrit root 'Vish',
translates to "The All-Pervading One."
Just as the potter, the spinning wheel, the clay, and the pot
appear to be entirely different but are essentially just clay,
similarly, the cause, the effect, and the doer
are all flawlessly Vishnu.

In the mystical 'Purusha Suktam' of the Rigveda,
He is described as the thousand-headed Cosmic Being (Virat Purusha),
possessing a thousand eyes and a thousand feet.
He completely envelops the entire earth and the cosmos from all sides,
and yet, He transcends it by the width of ten fingers.
Whatever existed in the ancient past, whatever breathes in the present,
and whatever will manifest in the future—is nothing but this 'Purusha'.

He is the invisible cosmic thread
upon which this entire, staggeringly vast universe
is beautifully strung like glowing pearls.
He is the ultimate Foundation
upon which the vivid dream of the universe is currently playing out.
In the sacred Hindu Trinity,
if Brahma represents creation and Shiva embodies destruction,
Vishnu is the 'Supreme Preservation'
that establishes a flawless equilibrium between those two infinite forces.

He is 'Narayana'—
'Nara' meaning water and living beings (consciousness),
and 'Ayana' meaning the ultimate resting place.
The absolute refuge of all living entities;
the One from whom all creatures are miraculously born,
the One in whom they sustain their existence,
and the One into whom they ultimately merge at the end of time—
that is Narayana.

The 'Narayana Suktam' boldly declares:
"Yaccha kinchit jagatyasmin drishyate shruyatepi va."
Meaning, whatever is seen or heard in this entire universe,
Narayana flawlessly pervades it all,
from both the inside and the outside.

According to the esoteric cosmology of the Srimad Bhagavatam,
He rests in the dark Causal Ocean (Karana Ocean) as Maha-Vishnu.
With every single exhalation of His divine breath,
billions of magnificent universes bubble out from the pores of His skin;
and with every single inhalation,
all those universes are violently sucked back into His absolute void.
Imagine—our entire, incomprehensibly vast universe
is nothing more than a microscopic fraction of His single breath.

He reclines majestically upon Ananta Shesha
(the infinite, coiled serpent representing endless Time)
in the vast Ocean of Milk (the ocean of infinite consciousness).
This state is His 'Yoga Nidra' (the divine, cosmic sleep).
He is imperishable, completely attribute-less, and Achyuta (the Infallible One).
He is the silent, motionless witness of all ages and epochs.
He is the Great Dreamer—
and this entire physical world, with all its complexities,
is merely a magical projection born from His 'Yoga Nidra'.

The Katha Upanishad reveals a staggering secret:
The human body is merely a chariot,
the senses are the wild, untamed horses,
the mind is the reins holding them,
and the eternal Soul (Atman) is the passenger.
And what is the ultimate, final destination of this perilous journey?
"Tad Vishnoh Paramam Padam"—
The Supreme Abode of Vishnu,
reaching which, the soul never returns to the cycle of illusions.

He is the unbreakable bridge between life and death.
The Garuda Purana describes Him
as the fierce protector of Dharma,
the ultimate guide of living beings,
and the absolute Knower of the soul's dark path after death.
When the soul crosses the threshold of mortality and journeys utterly alone,
the holy name of Narayana is its only true companion
and its final, supreme destination.

He is the sweet taste in the water,
the blinding brilliance in the sun and the moon.
He is the sacred Pranava (Om) vibrating in the Vedas,
the primordial sound echoing in the ether.
He is the original, eternal seed of all existences.
He is the sharp intelligence of the intelligent,
the radiant splendor of the splendid,
the selfless, unshakeable strength of the strong,
and the fierce penance of the silent ascetics.

Even the grand patriarch Bhishma, bleeding on a bed of arrows,
folds his hands and hails Him as 'Purushottama' (The Supreme Being).
"Yato Krishna Tato Dharma"—
Wherever there is Vishnu (Krishna), there is absolute Dharma;
and wherever there is Dharma, there is inevitable Victory.
He is "Vigrahavaan Dharmah"—the very personification of Righteousness.
He is the strict boundary (Maryada) of cosmic conduct
and the ultimate, flawless test of Truth.

In the Bhagavad Gita, Krishna compassionately declares:
"Suhridam sarva-bhutanam"—
He is the selfless, unconditional friend (Suhrid) of all beings,
holding absolutely no discrimination of dear or enemy.
Those who worship Him with unyielding devotion—
He permanently resides within their hearts,
and they reside safely within Him.

He is the 'Antaryami'—
the Inner Controller who knows the darkest thoughts forming in your mind
even before you take your next breath.
He declares with absolute authority:
"Aham atma gudakesha sarva-bhutashaya-sthitah"—
I am the Supersoul seated deep within the hearts of all living entities;
I am the beginning, the middle,
and the absolute end of all beings.

Among Adityas, He is Vishnu; among Maruts, Marichi.
Among luminaries, the radiant Sun; among stars, the Moon.
Among the Vedas, the Samaveda; among gods, Indra.
Among the senses, He is the Mind.
Among Rudras, Shankara (Mahadev).
Among Yakshas and Rakshasas, Kubera; among Vasus, Agni.
Among mountains, Mount Meru; among priests, Brihaspati.
Among great sages, Bhrigu; among speech, the eternal Omkara.
Among sacrifices, the silent chanting of Japa-yajna.
Among trees, the sacred Peepal; among divine sages, Narada.
Among perfected beings, Kapila Muni.
Among wielders of weapons, Lord Rama;
among the Yadavas, Krishna;
and among all letters, the primary letter 'A'.

Vishnu possesses four magnificent arms, holding:
The Conch (Panchajanya—the roaring sound of cosmic Dharma),
The Discus (Sudarshana—the unstoppable wheel of time and justice),
The Mace (Kaumodaki—supreme, crushing power),
and The Lotus (Padma—absolute purity amidst the mud of existence).
His vehicle is the mighty eagle Garuda—
the personification of the Vedic hymns,
symbolizing brilliance, extreme courage, and the absolute freedom of the skies.

To protect Dharma and relentlessly maintain the cosmic balance,
Vishnu wraps Himself in the cloak of Maya and incarnates age after age.
"Yada yada hi dharmasya glanirbhavati bharata..."
He is Matsya, the great fish who saves Vedic wisdom from the apocalyptic deluge.
He is Kurma, the giant tortoise bearing the crushing weight of creation on His back.
He is Varaha, the fierce boar lifting the drowning earth from the dark abyss.
He is Narasimha, the terrifying half-man, half-lion who tears open the chest of Adharma.
He is Vamana, the dwarf who crushes cosmic arrogance in just three strides.
He is Parashurama, the warrior-sage who annihilates the intoxication of absolute power.
He is Rama, the perfect embodiment of righteousness and moral boundaries (Maryada).
He is Krishna, the master of love, diplomacy, cosmic wisdom, and divine play (Leela).
He is Buddha, the silence of meditation,
and He is Kalki, the blazing, apocalyptic light that will end the dark age.

His 'Vishvarupa' (Universal Form)
blazes with the blinding intensity of a thousand suns.
When Arjuna witnessed this terrifying form on the battlefield,
time, gods, planets, stars, demons,
and the consciousness of the entire universe
were spinning violently within a single, magnificent body.
From that overwhelming form, He commands Arjuna:
"Sarva-dharman parityajya mamekam sharanam vraja"—
Abandon all varieties of religion, duties, and attachments,
and simply surrender unto Me alone;
do not fear, for I shall deliver you from all sins.

He is inexhaustible, all-devouring Time (Mahakala).
He is Death itself—
and He is also the ultimate Victory over death (Amrit).
No seed of creation—whether moving or unmoving—
can ever exist without Him.
He is the Breath of breaths, the Life of lives.
He completely pervades all beings—
and He exists simultaneously within all beings.

Now, pull back the heavy curtain of Maya and ponder a terrifyingly deep truth:
Is it entirely possible that this grand, complex universe,
with all its brutal wars, epic loves, and long histories,
is merely a fleeting, mesmerizing dream in the mind of Lord Vishnu?
Think deeply about it—
what happens to your existence, and to all of us,
if He suddenly wakes up from His cosmic Yoganidra for just one second?

Perhaps we are all miraculously born
within a single, massive inhalation of His divine breath,
we violently play out our entire lives and histories,
and we dissolve completely into absolute nothingness
the exact moment He exhales.
What feels like long, exhausting centuries of human evolution to us
is merely a microscopic, unnoticed fraction
of a blink of Sri Hari's eyes.

Are you truly the autonomous, independent doer of your life's actions?
Are your desires actually your own?
Or are you just a temporary, scripted character
playing a pre-assigned, inescapable role in a grand cosmic play
whose complete script was already written aeons ago
in the silent depths of the Ocean of Milk?

The 'I' (Ego) that you so fiercely defend as your solid existence
is merely a momentary, fragile wave
on the infinite ocean of the Supreme.
It proudly rises for a fraction of a second, claims to be an individual,
and then violently crashes back, losing itself entirely in its infinite source.

The labyrinth of Maya is so perfectly and flawlessly designed
that we completely forget the Divine Boatman (Vishnu),
and tragically mistake this sinking, decaying wooden boat (the body)
for our permanent, eternal home.

If you dare to dive deep enough into your own consciousness,
stripping away all thoughts, labels, and memories,
you will suddenly realize that the nameless 'Antaryami' (Inner Controller)
sitting quietly in the pitch dark within you
is the only real 'You'.
We are all just fragmented, vividly colored pieces
of a single, colossal dream.

When this cosmic dream finally shatters at the end of time,
there will be no physical world left,
there will be no 'You',
and there will be no 'I'—
only an infinite,
fathomless,
silent,
and boundless Narayana will remain.
""".trimIndent()


    // --- MAA LAKSHMI ---
    val LAKSHMI_HI = """
लक्ष्मी कौन हैं? — 
वे केवल 'धन' नहीं, 
वे 'श्री' (ब्रह्मांडीय वैभव) हैं।
माँ लक्ष्मी परम समृद्धि, सौभाग्य, ऐश्वर्य
और सृष्टि के सर्वोच्च संतुलन की देवी हैं।

वे केवल क्षुद्र भौतिक धन की देवी नहीं हैं;
वे जीवन में पूर्णता, संतुलन, समृद्धि
और शुभता की आदि-ऊर्जा का प्रतिनिधित्व करती हैं।
'श्री' केवल मुद्राओं का ढेर नहीं है—
वह अंतहीन सौंदर्य है,
परम संतुलन है,
अखंड मंगल है,
और जीवन की समृद्धि का वह दिव्य प्रवाह है
जो कभी सूखता नहीं।

नारायण यदि प्रखर सूर्य हैं,
तो लक्ष्मी उनका वह तेज (प्रकाश) हैं
जिससे पूरी सृष्टि प्रकाशित होती है;
सूर्य और उसका प्रकाश कभी एक दूसरे से अलग नहीं हो सकते।
नारायण यदि 'धर्म' की अचल स्थापना हैं,
तो लक्ष्मी वह 'समृद्धि' हैं जो परछाई की तरह धर्म के पीछे चलती हैं।
विष्णु यदि सृष्टि के 'पालनहार' हैं,
तो लक्ष्मी वह अनंत 'संसाधन' (पोषण) हैं
जिससे वह पालन किसी भी युग में संभव होता है।
वे वह परम पूर्णता हैं जो ब्रह्मांड के हर अभाव को मिटाती हैं।

“लक्ष्मी” शब्द संस्कृत के “लक्ष” से बना है,
जिसका अर्थ है—लक्ष्य, चिह्न, और शुभ संकेत;
अर्थात् जो इस भटकते हुए जीवन को परम उद्देश्य,
सौभाग्य और समृद्धि प्रदान करती हैं।

ऋग्वेद के 'श्री सूक्त' में
उन्हें 'हिरण्यवर्णां' (सोने के समान कांति वाली)
और 'सुवर्णरजतस्रजाम्' (स्वर्ण और रजत की माला धारण करने वाली) कहा गया है।
वे अग्नि के समान तेजस्विनी
और सूर्य की भांति प्रज्वलित हैं।
ऋषियों ने पुकार कर कहा:
"तां म आवह जातवेदो लक्ष्मीमनपगामिनीम्"—
हे अग्निदेव! उस लक्ष्मी को मेरे लिए आवाहन करें,
जो कभी नष्ट न हो, जो कभी मुझे छोड़कर न जाए।

विष्णु पुराण के अनुसार माँ लक्ष्मी का प्राकट्य
अमृत की खोज में हुए 'समुद्र मंथन' से हुआ।
जब देव और असुरों ने वासुकि नाग की डोरी बनाकर
मंदराचल पर्वत से क्षीरसागर को मथा,
तब अनंत गहराई से लक्ष्मी पूर्ण खिले हुए कमल से प्रकट हुईं।
अपने हाथ में वैजयंती माला लेकर,
उन्होंने देवताओं और दानवों को दरकिनार करते हुए,
स्वयं नारायण (विष्णु) को अपना पति
और अपना शाश्वत आश्रय चुना।

इसका एक अत्यंत गहरा और दार्शनिक अर्थ है:
ब्रह्मांड की सबसे बड़ी समृद्धि (लक्ष्मी) वहीं स्थायी रहती है,
जहाँ असीम शक्ति के साथ-साथ परम संरक्षण और 'धर्म' (विष्णु) होता है।

वे विष्णु के वक्षस्थल (श्रीवत्स) में सदा के लिए निवास करती हैं,
क्योंकि ब्रह्मांडीय शक्ति को शक्तिमान से कभी अलग नहीं किया जा सकता।
वे 'प्रकृति' का वह असीम रूप हैं जो हर जीव का मौन रहकर पोषण करता है।
खेतों में लहलहाती हरी-भरी फसल वही हैं;
तपस्वियों और ज्ञानियों के जीवन में जो सौभाग्य और आंतरिक संतुलन है,
वह साक्षात लक्ष्मी हैं।
विजयी योद्धा के माथे का चमकता तेज
और एक चक्रवर्ती राजा का अखंड ऐश्वर्य—
सब कुछ केवल और केवल लक्ष्मी है।

माँ लक्ष्मी का स्वरूप
अत्यंत मंगलमय, शांत और प्रकाशमान माना जाता है।
वे लाल या स्वर्ण वस्त्र धारण करती हैं,
और उनके खुले हाथों से स्वर्ण और जीवनदायी अन्न की अविरल वर्षा होती है।

वे पूर्ण रूप से खिले हुए कमल पर विराजमान होती हैं (कमल-वासिनी)।
कमल हमेशा गहरे कीचड़ और दलदल में उगता है
पर उसके गंदे पानी से पूरी तरह अछूता रहता है;
लक्ष्मी अपनी इस मुद्रा से हमें सिखाती हैं कि
संसार (माया) के घोर भौतिक वैभव और आकर्षणों के बीच रहो,
पर उससे हमेशा निर्लिप्त और मुक्त रहो।
कमल का अर्थ ही है—
संसार में रहते हुए भी भीतर से पूर्णतः पवित्र और निर्मल रहना।

कई प्राचीन मूर्तियों और शास्त्रों में
माँ लक्ष्मी के साथ हाथी (गज) दिखाई देते हैं,
जो अपनी सूंड से उन पर अमृत का कलश उंडेलते हैं।
हाथी हमेशा शक्ति, राजसत्ता,
विवेक और अचल स्थिरता का प्रतीक है;
यह रूप 'गजलक्ष्मी' कहलाता है।

वे अपनी अष्ट-लक्ष्मी के रूप में
मानव जीवन के आठ सबसे महत्वपूर्ण आयामों को पूर्ण करती हैं:
आदि लक्ष्मी (सृष्टि की मूल शक्ति और शांति),
धन लक्ष्मी (धन और ऐश्वर्य का असीमित प्रवाह),
धान्य लक्ष्मी (अन्न और प्रकृति का पोषण),
गज लक्ष्मी (राजसी शक्ति, पशुधन और प्रतिष्ठा),
संतान लक्ष्मी (उत्तराधिकारी, संतान और वंश का विस्तार),
वीर लक्ष्मी (कठिनाइयों से लड़ने का अदम्य साहस और शक्ति),
विजय लक्ष्मी (हर युद्ध और कार्य में अंतिम सफलता और विजय),
और विद्या लक्ष्मी (सर्वोच्च आध्यात्मिक और सांसारिक ज्ञान)।

उनका सबसे बड़ा और पवित्र उत्सव दीपावली है,
जब अमावस्या की घोर अंधकारमयी रात में
घरों में दीप जलाए जाते हैं
और समृद्धि तथा मंगल की कामना की जाती है।
वे केवल बाहरी तिजोरियों में रखा धन नहीं,
बल्कि मनुष्य के हृदय की आंतरिक समृद्धि का भी सर्वोच्च प्रतीक हैं।

लोक परंपरा में वे 'चंचला' हैं—
जो मूर्ख मनुष्य उन्हें केवल लोभ, चालाकी और अहंकार से बांधना चाहता है,
उसके पास वे एक पल के लिए भी नहीं टिकतीं।
लेकिन वे 'अचला' भी हैं—
जो भक्त नारायण (सत्य और धर्म) के चरणों में पूरी तरह समर्पित है,
वे वहां बिना मांगे ही सदा के लिए स्थिर हो जाती हैं।

लक्ष्मी के बिना यह ब्रह्मांड पूरी तरह दरिद्र (शून्य) है,
परंतु नारायण से अलग हुई लक्ष्मी
राक्षसों का भोजन बन जाती हैं और कभी स्थायी नहीं रहतीं।
रावण ने लक्ष्मी (सीता) को बिना नारायण (राम) के चुराना चाहा,
और परिणाम स्वरूप उसका पूरा साम्राज्य भस्म हो गया।
इसलिए, बुद्धिमान ज्ञानी कभी केवल लक्ष्मी को नहीं मांगते,
वे हमेशा 'लक्ष्मीनारायण' को एक साथ मांगते हैं।

जहाँ निस्वार्थ धर्म है, वहाँ लक्ष्मी हैं।
जहाँ मन की स्वच्छता और शरीर का घोर परिश्रम है, वहाँ लक्ष्मी हैं।
जहाँ विचारों का सौंदर्य, जीवन का संतुलन और मंगल है,
वहीं लक्ष्मी का स्थायी निवास है।
वही श्री हैं।
वही समृद्धि हैं।
वही मंगलमयी जगन्माता लक्ष्मी हैं।

क्या आपने कभी इस घोर रहस्य पर विचार किया है
कि आप जीवन भर जिसे अपनी मुट्ठी में 'पाना' और जकड़ना चाहते हैं,
वह मुट्ठी बांधते ही
क्यों रेत की तरह आपके हाथों से फिसल कर गिर जाता है?
लक्ष्मी बहते हुए निर्मल जल की तरह हैं;
यदि आप अपनी तिजोरी में इसे एक जगह बांधने का प्रयास करेंगे,
तो यह जल सड़ जाएगा और आपके ही विनाश का कारण बनेगा,
लेकिन यदि आप इसे खुले हाथों से बहने देंगे,
तो यह सूखे पड़े खेतों और मृत सभ्यताओं को भी नया जीवन दे देगा।

उपनिषद हमें सिखाते हैं कि
असली दरिद्रता भौतिक सिक्कों या अन्न की कमी नहीं है,
बल्कि 'और अधिक' पाने की वह नर्क जैसी अतृप्त प्यास है
जो मनुष्य की आत्मा को भीतर से खोखला कर देती है।
क्या तिजोरी के घुप अंधेरे में बंद वह सोना सचमुच आपका है,
या आप उस पीले, चमकीले पत्थर के
एक अवैतनिक, डरे हुए और चिंतित पहरेदार मात्र बन गए हैं?

तंत्र शास्त्रों के अनुसार,
माँ लक्ष्मी वह अदृश्य 'श्री-तत्व' हैं
जो प्रकृति के हर खुलते हुए पत्ते,
हर शंख की बनावट
और इस अनंत आकाशगंगा के गणित में पूरी तरह छिपा हुआ है।
जो मनुष्य उन्हें केवल भौतिक वस्तुओं, महलों और सिक्कों में खोजता है,
वह जीवन भर एक तपते हुए रेगिस्तान में
मृगतृष्णा (Illusion) के पीछे हांफता हुआ भागता रहता है।

वे तो उस अलौकिक, अकारण संतोष में बसती हैं
जो बिना किसी भौतिक कारण के, गहराई से भीतर से उपजता है।
जब आप नारायण के सत्य, न्याय और धर्म को
अपने हृदय की गहराइयों में उतार कर उसे अपना स्वभाव बना लेते हैं,
तो आपको लक्ष्मी के पीछे भागना नहीं पड़ता—
वे स्वयं इस पूरे ब्रह्मांड को पार करते हुए,
आपके द्वार तक चलकर आती हैं।

अस्तित्व का सबसे बड़ा और सबसे गुप्त रहस्य यह है
कि इस ब्रह्मांड का सारा ऐश्वर्य, सारी पूर्णता
पहले से ही आपके भीतर एक बीज रूप में मौजूद है।
आप बाहर भिखारी की तरह भीख मांग रहे हैं,
जबकि आप एक राजा के खजाने पर सोए हुए हैं;
बस आपको मोह की नींद से जागकर
उसे देखने वाली आंतरिक दृष्टि को खोलना है।
""".trimIndent()

    val LAKSHMI_EN = """
Who is Lakshmi? — 
She is not merely 'Wealth', 
She is 'Shri' (The Ultimate Divine Splendor).
Maa Lakshmi is the supreme Goddess of prosperity,
fortune, cosmic opulence, and absolute balance.

She is not merely the shallow Goddess of material wealth;
She represents the deep, primal energy of balance,
prosperity, and the highest auspiciousness in life.
'Shri' is not just a collection of gold coins—
it is breathtaking beauty,
perfect cosmic balance,
unbroken auspiciousness,
and the divine, never-ending flow of life's true prosperity.

If Lord Narayana is the blazing Sun,
Lakshmi is His brilliant Radiance that illuminates creation;
the Sun and its Light can never be separated from each other.
If Narayana is the immovable foundation of 'Dharma' (Righteousness),
Lakshmi is the 'Prosperity' that flawlessly follows Dharma like a shadow.
Vishnu is the ultimate 'Preserver' of the universe,
and Lakshmi is the infinite 'Resource' (nourishment)
that makes His preservation possible across all ages.
She is the absolute 'Fullness' that eradicates every lack in the cosmos.

The Sanskrit word "Lakshmi" is derived from the root "Laksh",
which translates to target, sign, or an auspicious symbol;
meaning She is the one who provides ultimate purpose,
fortune, and meaningful prosperity to a wandering life.

In the sacred 'Sri Suktam' of the Rigveda,
She is glorified as 'Hiranyavarnam' (the one with a golden complexion)
and 'Suvarnarajatastrajam' (the one adorned with garlands of gold and silver).
She is as radiant as the fire and as blazing as the sun.
The ancient sages loudly invoked Her, chanting:
"Tam ma avaha Jatavedo Lakshmimanapagaminim"—
O Agni! Invoke for me that Goddess Lakshmi
who is eternal, and who will never, ever abandon me.

According to the Vishnu Purana, Maa Lakshmi manifested
from the legendary Samudra Manthan (the churning of the cosmic ocean).
When the gods and demons desperately churned the Ocean of Milk
using the king of serpents as a rope,
Lakshmi miraculously emerged from the unfathomable depths on a fully bloomed lotus.
Holding a divine garland in Her hands,
ignoring all the greedy deities and demons,
She chose Narayana (Vishnu) as Her eternal husband and absolute refuge.

This ancient mythological event signifies a profound philosophical truth:
True, everlasting prosperity (Lakshmi) remains permanent
only in the presence of supreme protection and unwavering 'Dharma' (Vishnu).

She eternally resides in the chest of Vishnu (Shrivatsa),
for the Cosmic Energy can never be separated from the Energetic Source.
She is the silent aspect of Nature (Prakriti) that continuously nourishes all life.
She is the lush, golden harvest swaying in the fields;
the profound fortune, peace, and internal balance in the lives of the wise—
that is entirely Lakshmi.
The radiant glow on a victorious warrior's forehead
and the unshakeable majesty of a righteous King—
all of it is Lakshmi.

The divine form of Maa Lakshmi
is considered supremely auspicious, peaceful, and radiant.
She wears majestic red or golden garments,
and from Her open palms, endless showers of gold and life-giving grain cascade down.

She is Kamal-Vaasini (the one seated gracefully on the lotus).
The lotus always blooms in the thick, murky mud,
yet its petals remain completely untouched and unblemished by the dirt;
through this posture, Lakshmi silently teaches us how to live
amidst the intoxicating opulence of the world (Maya),
yet remain completely detached and mentally free from it.
The lotus signifies the ultimate spiritual state:
remaining pure, immaculate, and uncorrupted while navigating the material world.

In many ancient scriptures and temple carvings, 
elephants (Gaja) are seen standing beside Maa Lakshmi,
pouring pots of divine nectar over Her.
The elephant is the ultimate symbol of royal power,
wisdom, and unshakeable stability;
this magnificent form is worshipped as Gaja-Lakshmi.

She fulfills the eight critical dimensions of human life
as the Ashta-Lakshmi:
Adi Lakshmi (The Primal Power and cosmic peace),
Dhana Lakshmi (The endless flow of Wealth and Opulence),
Dhanya Lakshmi (The provider of Food and agricultural Nourishment),
Gaja Lakshmi (The bestower of Royal Power, livestock, and Prestige),
Santana Lakshmi (The granter of Progeny and the continuation of Lineage),
Veera Lakshmi (The fierce Courage and Strength to overcome life's battles),
Vijaya Lakshmi (The ultimate Success and Victory in all endeavors),
and Vidya Lakshmi (The highest spiritual and worldly Knowledge).

Her greatest, most celebrated festival is Diwali,
when on the darkest night of the new moon,
lamps are lit in millions of homes,
and fervent prayers are offered for prosperity and auspiciousness.
She is not just the external wealth locked in a safe;
She is the ultimate symbol of the soul's inner, spiritual prosperity.

In folklore, She is famously known as 'Chanchala' (The Restless One)—
She never stays for even a moment with those foolish enough
to try to bind Her with greed, arrogance, and cunning tricks.
But She is also 'Achala' (The Immovable One)—
She stays forever, unasked, in the home of the one
who is completely surrendered to Narayana (Truth and Righteousness).

Without Lakshmi, this entire universe is Daridra (barren and impoverished),
but if forcefully separated from Narayana,
Lakshmi turns into the food of demons and brings sheer destruction.
Ravana tried to steal Lakshmi (Sita) without Narayana (Rama),
and as a direct result, his entire golden empire was burned to ashes.
Therefore, the truly wise never ask for Lakshmi alone;
they always pray for 'Lakshmi-Narayana' together.

Where there is selfless Dharma, there is Lakshmi.
Where there is purity of mind and hard, honest work, there is Lakshmi.
Where there is beauty of thought, cosmic balance, and auspiciousness,
there permanently resides Lakshmi.
She is Shri.
She is Absolute Prosperity.
She is the supremely auspicious Jagadamba, Maa Lakshmi.

Have you ever stopped in the silence of the night to wonder
why the very thing you desperately try to 'hold' and possess
slips away like dry sand
the exact moment you forcefully clench your fist around it?
Lakshmi behaves exactly like pure, flowing water;
try to hoard and trap it in one place, and it stagnates, rots, and breeds disease,
but let it flow freely from your open hands,
and it will give boundless life to dead fields and entire civilizations.

The Upanishads whisper that true poverty is not the physical absence of coins,
but the unquenchable, hellish, burning thirst for 'more'
that leaves the human soul entirely hollow and diseased.
Is the heavy gold locked safely in the pitch dark of your vault truly yours,
or have you merely reduced yourself to
an unpaid, highly anxious security guard of a shiny yellow metal?

According to Tantric geometry, Maa Lakshmi is the unseen 'Shri-Tattva'
hidden perfectly in the unfurling of every green leaf,
the spiral of every ocean seashell,
and the magnificent mathematics of every swirling galaxy in the cosmos.
He who seeks Her exclusively in dead material objects and towering mansions
spends his entire, exhausted life endlessly chasing
a cruel, mocking mirage in a burning desert.

She actually resides
in that profound, quiet, causeless contentment
that blooms spontaneously from the deepest part of your being.
When you firmly anchor the absolute truth and Dharma of Narayana
within the core of your heart, making it your very nature,
you no longer have to frantically run out to seek Lakshmi—
She will cross the vastness of the cosmos to find you at your door.

The greatest, most hidden mystery of existence is this:
the boundless, unimaginable opulence of the entire universe
is already flawlessly encoded within your spirit like a dormant seed.
You are crying like a beggar in the streets,
while sleeping on top of an emperor's buried treasure;
you only need to wake up from the illusion of Maya
and open the inner eyes capable of seeing it.
""".trimIndent()

    // --- LORD BRAHMA ---
    val BRAHMA_HI = """
ब्रह्मा कौन हैं? — 
वे "विधाता" हैं, अस्तित्व के प्रथम शिल्पकार।
सृष्टि के रचयिता माने जाते हैं।
हिन्दू दर्शन में उन्हें सृष्टि के आरंभ का देवता कहा गया है।

यदि विष्णु 'पालन की चेतना' हैं
और शिव 'परम चेतना' हैं,
तो ब्रह्मा वह 'बुद्धि' हैं 
जो असीम निराकार को एक निश्चित आकार देती है।

पुराणों के अनुसार,
सृष्टि के प्रारम्भ में केवल एक घोर, अनंत जल (प्रलय) था।
उस अथाह अंधकारमयी जल पर विष्णु योगनिद्रा में विराजमान थे।
तब विष्णु की नाभि से एक अलौकिक कमल उत्पन्न हुआ,
और उस कमल के मध्य में ब्रह्मा प्रकट हुए—
इसलिए उन्हें 'कमलज' (कमल से उत्पन्न) कहा जाता है।
वे ही 'हिरण्यगर्भ' हैं—
वह आदिम सुनहरा महा-गर्भ,
जिसके फूटने से इस सम्पूर्ण ब्रह्मांड का जन्म हुआ।

इसका अर्थ है कि 'सृजन' का जन्म
केवल 'पालन' के आधार पर ही हो सकता है।
विष्णु अपनी योगनिद्रा में सृष्टि का स्वप्न देखते हैं,
और ब्रह्मा उस मौन स्वप्न को
ईंट-पत्थर, ग्रहों, नक्षत्रों और प्राणों का भौतिक रूप देते हैं।

ब्रह्मा का स्वरूप अत्यंत प्रतीकात्मक और गूढ़ है।
वे 'चतुर्मुखी' हैं,
जो चारों दिशाओं में ज्ञान के निर्बाध प्रसार का प्रतीक है।
उनके चार मुखों से ही चार वेदों का नाद हुआ—
ऋग्वेद, यजुर्वेद, सामवेद और अथर्ववेद—
इसलिए वे इस ब्रह्मांड में ज्ञान के प्रथम प्रवर्तक माने जाते हैं।
उनके चार मुख समय के चार युगों (सतयुग, त्रेता, द्वापर, कलियुग)
और मानव जीवन के चार आश्रमों के भी साक्षी हैं।

उनकी चार भुजाएँ सृजन की शक्तियों की प्रतीक हैं;
उनके हाथों में वेद (ज्ञान का शाश्वत स्रोत),
अक्षमाला (समय और श्वासों की निरंतर गणना),
स्रुवा (यज्ञ और कर्मकांड का प्रतीक),
और कमंडल (सृष्टि का आदिम जल) है।

वे कमल पर विराजमान हैं
जो सृष्टि के घोर कीचड़ में भी शुद्धता के जन्म का प्रतीक है।
उनका वाहन 'हंस' है,
जिसे 'नीर-क्षीर विवेक' प्राप्त है—
अर्थात् वह जो पानी में से केवल दूध को ग्रहण कर लेता है।
यह हंस उस परम विवेक का प्रतीक है,
जो सत्य (आत्मा) और असत्य (माया) को अलग करने की क्षमता रखता है।
सरस्वती (परम ज्ञान) उनकी आदि-शक्ति हैं;
क्योंकि ज्ञान और विवेक के बिना,
कोई भी सृजन केवल एक अंधा विध्वंस बन जाता है।

वे 'काल' (Cosmic Time) के महा-रचयिता हैं।
उनका एक दिन, जिसे 'कल्प' कहा जाता है,
अरबों मानव वर्षों के बराबर होता है।
जब ब्रह्मा का दिन आरम्भ होता है, तो सुप्त सृष्टि जाग्रत होकर प्रकट होती है;
और जब उनकी रात्रि आती है,
तो यह पूरा दृश्यमान जगत घोर प्रलय के जल में डूबकर लय में चला जाता है।

वे 'रजोगुण' के परम स्वामी हैं—
वह अथाह और बेचैन ऊर्जा जो स्थिर को निरंतर गतिशील बनाती है।
वे अपने मानस पुत्रों—
मरिचि, अत्रि, अंगिरा, पुलस्त्य, पुलह, क्रतु, वशिष्ठ, और नारद—
के माध्यम से सृष्टि का विस्तार करते हैं।
वे ही हर जीव के माथे पर उसका भाग्य (विधि) लिखते हैं,
पर वे स्वयं भी कर्म के अटल नियमों से बंधे हुए हैं।

ब्रह्मा की पूजा पृथ्वी पर कम क्यों होती है?
पुराणों में एक प्रसिद्ध कथा है
कि एक बार ब्रह्मा और विष्णु के बीच श्रेष्ठता का विवाद हुआ।
तब महादेव एक अनंत, प्रज्वलित ज्योति स्तंभ के रूप में प्रकट हुए।
ब्रह्मा ने उस स्तंभ का अंत खोजने के लिए हंस का रूप धरा,
परंतु अंत न मिलने पर उन्होंने 'केतकी' के फूल के साथ मिलकर असत्य कहा।
सत्य को छिपाने के इस प्रयास के कारण
उन्हें शिव का श्राप मिला कि उनकी पूजा पृथ्वी पर नहीं होगी।

किन्तु ऋषियों के अनुसार, इसका एक बहुत गहरा दार्शनिक अर्थ भी है—
ब्रह्मा 'मन' और 'सृजन की बुद्धि' के प्रतीक हैं।
मन ही इस मायावी संसार को बनाता है,
मन ही संसार के आकर्षणों में बुरी तरह उलझता है,
और मन ही 'मैं' और 'तू' का भेद (द्वैत) पैदा करता है।
मोक्ष (मुक्ति) पाने के लिए,
मनुष्य को अपने मन (ब्रह्मा) की सीमाओं से परे जाकर,
विशुद्ध आत्मा (शिव/विष्णु) में लीन होना पड़ता है।
हम उस घर (सृजन) का सम्मान तो करते हैं,
पर हमारा अंतिम लक्ष्य उस घर को बनाने वाले से परे 'सत्य' को पाना है।

लेकिन अब वेदांत की गहराई में उतर कर इस रहस्य पर विचार करें:
क्या कोई भी रची गई वस्तु वास्तव में अपने ही रचयिता को पूरी तरह समझ सकती है?
क्या एक चित्र कभी उस चित्रकार की आँख को देख सकता है जिसने उसे रंगा है?
ऋग्वेद का 'नासदीय सूक्त' सृष्टि के इस सबसे बड़े रहस्य पर प्रश्न उठाता है:
"सृष्टि के आरम्भ में न असत् था, न सत् था।
न अंतरिक्ष था, न आकाश था।
तब यह सृष्टि कहाँ से आई?
क्या वह परम अध्यक्ष, जो परम व्योम में बैठा है, वह इसे जानता है?
या शायद, वह भी नहीं जानता!"

ब्रह्मा वह परम रहस्य हैं
जहाँ मानवीय तर्क, बुद्धि और दर्शन की सभी सीमाएँ
पूरी तरह से टूट कर शून्यता में गिर जाती हैं।
हम हर दिन, हर पल अपने अनगिनत विचारों से
अपने ही एक नए मानसिक ब्रह्मांड की रचना करते हैं—
क्या हम सब अपने भीतर एक छोटे 'ब्रह्मा' नहीं हैं?
जब आप रात में गहरी नींद में एक स्वप्न देखते हैं,
तो उस स्वप्न के विशाल पेड़, पहाड़ और लोग कहाँ से आते हैं?
वे केवल आपके ही मन के संकल्प से उपजते हैं,
और आँख खुलते ही लुप्त हो जाते हैं।

ठीक उसी प्रकार,
यह संपूर्ण भौतिक जगत,
इसके अनंत तारे, आकाशगंगाएँ और इसका विस्तृत इतिहास,
ब्रह्मा के विशाल मन का एक उठा हुआ विचार मात्र है।
जिस दिन आपके भीतर विचारों का यह कोलाहल पूरी तरह शांत हो जाएगा,
उस दिन ब्रह्मा की यह विशाल, जटिल सृष्टि
आपके लिए हमेशा के लिए तिरोहित (गायब) हो जाएगी।
तब आप उस नग्न 'सत्य' को देख पाएंगे
जो इस ब्रह्मांड की रचना से पहले भी अचल था
और इसके भस्म होने के बाद भी अचल रहेगा।

नियति (विधि) जो ब्रह्मा ने लिखी है,
वह पत्थर पर उकेरी गई कोई बेजान लकीर नहीं है,
बल्कि आपके जन्म-जन्मांतर के संस्कारों और कर्मों का
एक अत्यंत सूक्ष्म, जीवित और स्पंदित लेखा-जोखा है।
आप केवल किसी पुरानी कहानी को जी नहीं रहे हैं,
बल्कि अपनी हर श्वास और अपनी जाग्रत चेतना से
हर पल उस नियति को फिर से लिख रहे हैं।

ज़रा आँखें बंद करके इस शून्यता में सोचिए:
क्या यह संभव है कि यह अनंत ब्रह्मांड
बाहर किसी दिशाहीन अंधकार में नहीं फैल रहा है,
बल्कि आपके अपने ही मन की
अनंत और रहस्यमयी परतों के बहुत भीतर खुल रहा हो?
जिस दिन आप अपने 'मन' (ब्रह्मा) के पार चले जाएंगे,
आपको ज्ञात होगा कि जिसे आप दुनिया समझ रहे थे,
वह केवल आपके ही विचारों की एक परछाई थी।
""".trimIndent()

    val BRAHMA_EN = """
Who is Brahma? — 
The Cosmic Architect (Vidhaata).
He is considered the ultimate creator of the universe,
the supreme deity of the beginning of creation in Hindu philosophy.

If Vishnu represents the 'Consciousness of Preservation'
and Shiva embodies the 'Supreme Consciousness',
Brahma is the profound 'Intellect'
that gives a definite, intricate form to the Formless.

According to the ancient Puranas,
in the very beginning, there was only the endless, dark cosmic water (Pralaya).
Upon those unfathomable waters, Vishnu rested in His Yogic sleep (Yoganidra).
From the navel of the sleeping Vishnu, a magnificent, glowing lotus emerged,
and seated perfectly in the center of that lotus, Brahma manifested—
hence He is revered as 'Kamalaja' (The Lotus-born).
He is 'Hiranyagarbha'—
the primordial, golden cosmic womb,
the bursting of which gave violent birth to this entire multiverse.

This deeply signifies that 'Creation' can only rise
from the unshakeable foundation of 'Preservation'.
Vishnu silently dreams the cosmos in His cosmic slumber,
and Brahma takes that silent dream
and meticulously builds its physical stage with matter, planets, and life force.

His physical form is deeply symbolic and profoundly esoteric.
He is Chaturmukha (Four-Faced),
representing the absolute dissemination of cosmic knowledge
in all four cardinal directions.
From His four divine mouths echoed the sacred sounds of the four Vedas—
Rigveda, Yajurveda, Samaveda, and Atharvaveda—
making Him the primal, ultimate source of wisdom in the universe.
His four faces also bear witness to the four Yugas (epochs of time)
and the four ashramas (stages) of human life.

His four arms represent the supreme powers of creation;
He holds the Vedas (the eternal, unwritten source of knowledge),
the Akshamala or Rosary (representing the relentless calculation of time and breaths),
the Sruva (the ladle representing sacrifice and action),
and the Kamandalu (the pot holding the primal water of creation).

Seated upon a pure lotus,
He symbolizes the birth of absolute purity even from the chaotic mud of existence.
His vehicle is the majestic swan (Hamsa),
a bird mythologically known for 'Neer-Ksheer Viveka'—
the extraordinary ability to drink only the pure milk mixed within water.
This swan represents the ultimate discernment,
the supreme intellect required to separate the eternal Truth (Atman) from the grand illusion (Maya).
Saraswati (Supreme Wisdom) is His divine consort and power;
because without wisdom and discernment,
any act of creation inevitably devolves into blind destruction.

He is the undisputed Master of Cosmic Time (Kala).
A single day of Brahma, known as a 'Kalpa',
spans over billions of human years.
When the day of Brahma finally dawns, the slumbering creation wakes up and manifests;
and when His night arrives,
the entire visible universe drowns in the apocalyptic waters of dissolution.

He embodies 'Rajo Guna'—
the restless, dynamic, and passionate energy that sets stagnant matter into motion.
He expands the universe through His 'Manas Putras' (Mind-born sons)—
the great sages like Marichi, Atri, Narada, and Vashistha.
He is the one who writes the destiny (Vidhi) on the forehead of every living being,
yet He Himself remains strictly bound by the inescapable laws of Karma.

Why is Brahma so rarely worshipped on Earth?
A famous Puranic legend tells of a fierce dispute
between Brahma and Vishnu over absolute supremacy.
To test them, Lord Shiva appeared as an endless, blazing pillar of light (Jyotirlinga).
Brahma took the form of a swan to find its top,
but failing to do so, He conspired with the Ketaki flower and told a lie.
Because of this desperate attempt to veil the truth,
He was cursed by Shiva that He would not be worshipped in temples.

But the ancient sages reveal a much deeper, philosophical meaning to this curse—
Brahma perfectly represents the 'Mind' and the 'Intellect of Creation'.
It is the Mind that creates this illusory world,
it is the Mind that gets deeply entangled in its own desires,
and it is the Mind that breeds the illusion of duality (Me versus You).
To attain ultimate liberation (Moksha),
a seeker must transcend the boundaries of the Mind (Brahma)
and completely merge with the pure, thoughtless Soul (Shiva/Vishnu).
We deeply respect the builder of the house,
but our ultimate goal is to step outside the house to find the infinite sky of 'Truth'.

But ponder this absolute mystery, buried deep in the Vedas:
How can any created intellect possibly comprehend its own creator?
Can a painted canvas ever turn around and see the brush that painted it?
The 'Nasadiya Sukta' of the Rigveda questions the very foundation of creation:
"In the beginning, there was neither existence nor non-existence.
There was no atmosphere, nor the sky beyond it.
From where did this creation arise?
Does the Supreme Overseer in the highest heaven know?
Or perhaps, even He does not know!"

Brahma is the ultimate, mind-bending mystery
where the borders of human logic, philosophy, and reason
simply dissolve into absolute nothingness.
Think about it—we weave our own personal universes
every single moment through our ceaseless thoughts.
Are we not all miniature Brahmas in our own right?
When you fall asleep and enter a vivid dream,
where do the giant trees, mountains, and the strangers in that dream come from?
They are entirely projected by the sheer willpower of your own mind,
and they vanish the second your eyes open.

In the exact same way,
this staggering physical reality,
with all its burning stars, galaxies, and endless history,
is nothing but a fleeting, rising thought inside the colossal mind of Brahma.
The very moment the relentless, deafening noise of your own thoughts ceases,
the intricate creation of Brahma will vanish from your perception,
revealing the naked, terrifying 'Truth'
that existed long before the first star was born, and will remain after the last star dies.

The destiny (Vidhi) He has written on your forehead
is not a rigid script carved helplessly into stone;
it is a highly subtle, living ledger of your own past karmas and deep-rooted Samskaras.
You are not just blindly acting out a pre-written story;
you are actively rewriting it with every single pulse of your awakened consciousness.

Close your eyes and stare into the void:
Is it entirely possible
that this boundless universe is not expanding out there in the dark, empty space,
but is actually unfolding deep within the infinite, mysterious folds of your own mind?
The day you finally step beyond your 'Mind' (Brahma),
you will realize that the world you thought was so real,
was only ever a shadow cast by your own thoughts.
""".trimIndent()

    // --- MAA SARASWATI ---
    val SARASWATI_HI = """
सरस्वती कौन हैं? — 
वे "वाक" (दिव्य वाणी) और "विवेक" (परम सत्य का ज्ञान) हैं।
माँ सरस्वती असीम ज्ञान, तीक्ष्ण बुद्धि, नाद, कला और विद्या की आदि-देवी हैं।
वे विशुद्ध चेतना की वह जीवंत अभिव्यक्ति हैं
जो अज्ञान के घने अंधकार को
ब्रह्म-ज्ञान के तीखे प्रकाश से चीर देती हैं।

यदि ब्रह्मा 'रचना' का आधार हैं,
तो सरस्वती वह 'ज्ञान' हैं जिसके बिना कोई भी रचना संभव नहीं।
ब्रह्मा यदि चलायमान 'मन' हैं,
तो सरस्वती वह स्थिर 'बुद्धि' हैं जो उस मन को सही दिशा देती है।
उनके बिना ब्रह्मा का विशाल सृजन
केवल मृत पत्थर, गैस और मिट्टी का एक अर्थहीन ढेर है;
सरस्वती ही उस जड़ पदार्थ को 'अर्थ', 'नाम' और 'चेतना' देती हैं।
उन्हें वाग्देवी, शारदा, वीणापाणी,
और संपूर्ण ब्रह्मांड की विद्या की देवी कहा जाता है। 

“सरस्वती” शब्द का संस्कृत अर्थ है:
'सरस' (निरंतर बहने वाला ज्ञान या प्रवाह)
और 'वती' (उसे धारण करने वाली)।
अर्थात् वह जो ज्ञान और चेतना के
कभी न रुकने वाले प्रवाह को अपने भीतर धारण करती हैं।

वे 'सरस-वती' हैं—
वह जो एक शाश्वत नदी की भांति सतत प्रवाहमान है।
वे ज्ञान की वह रहस्यमयी, अदृश्य नदी हैं
जो बाहर भूमि पर नहीं, बल्कि हर जीवात्मा के भीतर
'अंतर्ज्ञान' (Intuition) बनकर बहती है।
शब्दों के भीतर छिपा हुआ जो गहरा अर्थ है,
कंठ से निकलने वाले स्वर में जो संगीत है,
और गहरे मौन में जो अचानक उपजने वाली समझ है—
वही साक्षात सरस्वती हैं।

माँ सरस्वती का रूप
अत्यंत शांत, स्थिर और परम पवित्र माना जाता है।
वे पूर्णतः श्वेत-वस्त्रा हैं;
संसार के सभी चटकीले रंगों (राग, द्वेष, क्रोध, और लोभ) से परे,
वे परम शांति
और 'सत्व गुण' (विशुद्ध पवित्रता) का अंतिम प्रतीक हैं।

वे एक श्वेत कमल पर विराजमान हैं,
जो यह दर्शाता है कि सच्चा ज्ञान हमेशा अहंकार के कीचड़ से ऊपर,
अत्यंत पवित्र और निर्मल होता है।
उनके चार हाथों में वीणा (संगीत और ब्रह्मांडीय नाद),
पुस्तक (वेद और अनंत ज्ञान),
स्फटिक की माला (गहरा ध्यान और एकाग्रता),
और कमंडल (पवित्र जल) है।

उनके हाथों की वीणा कोई साधारण वाद्ययंत्र नहीं है;
यह हमें जीवन का सबसे बड़ा रहस्य सिखाती है।
वीणा के तार न तो बहुत ढीले होने चाहिए (आलस्य और प्रमाद),
और न ही बहुत अधिक कसे हुए होने चाहिए (क्रोध और तनाव);
केवल एक पूर्ण संतुलन में ही जीवन का असली संगीत प्रकट होता है।
उनका वाहन 'हंस' है (हंस-वाहिनी)।
हंस सत्य और असत्य में,
दूध और पानी में सटीक भेद करने की कुशाग्र बुद्धि का प्रतीक है।
सरस्वती मनुष्य को वह अमोघ 'विवेक' देती हैं
जिससे वह इस नश्वर संसार और अनश्वर आत्मा के बीच स्पष्ट भेद कर सके।

तंत्र और वेदों के गूढ़ ज्ञान के अनुसार,
वे केवल शब्दों की देवी नहीं, बल्कि 'नाद ब्रह्म' (Sound as the Ultimate Reality) हैं।
वेदों की वाणी सरस्वती हैं।
तंत्र में वाणी के चार स्तर बताए गए हैं:
परा (नाभि में स्थित वह विचार जो अभी तक शब्द नहीं बना),
पश्यंती (हृदय में स्थित वह विचार जिसे केवल महसूस किया जा सकता है),
मध्यमा (गले में स्थित वह विचार जिसे मन ने आकार दे दिया है),
और वैखरी (मुख से निकला हुआ वह भौतिक शब्द जो दुनिया सुनती है)।
माँ सरस्वती इन चारों वाणियों की अधिष्ठात्री हैं।
वे उस बिंदु (Sphota) की स्वामिनी हैं जहाँ निर्गुण मौन,
सगुण शब्द बनकर फूट पड़ता है।

जगत में जो भी विद्या है—
चाहे वह भौतिक विज्ञान हो, खगोल शास्त्र हो, कला हो, या गहन अध्यात्म—
वह सब उसी एक महा-चेतना की बिखरी हुई किरणें हैं।
लक्ष्मी (धन) अत्यंत चंचला है, वह आज है और कल नहीं;
पर ज्ञान की देवी सरस्वती पूर्णतः स्थिर हैं।
जो ज्ञान और विवेक एक बार भीतर उतर गया,
उसे दुनिया का कोई चोर चुरा नहीं सकता,
और कोई क्रूर राजा उसे छीन नहीं सकता।

प्राचीन काल में गुरुकुल में विद्या आरंभ करने से पहले
ऋषि और विद्यार्थी सबसे पहले माँ सरस्वती की ही उपासना करते थे।
उनका प्रमुख उत्सव बसंत पंचमी है,
जो प्रकृति के नव-निर्माण और ज्ञान के प्रस्फुटन का दिन है।
ब्रह्मा (सृजन) को पूजने से पहले
सरस्वती (ज्ञान) को साधना इसलिए परम आवश्यक है,
क्योंकि अज्ञानी मनुष्य के हाथों में दी गई सृजन की शक्ति
अंततः स्वयं उसके और संसार के विनाश का कारण बनती है।

माँ सरस्वती केवल मंदिरों में पूजी जाने वाली कोई बाहरी मूर्ति नहीं हैं;
वे मनुष्य के मस्तिष्क और हृदय के भीतर स्थित जाग्रत प्रज्ञा हैं।
जब मन पूरी तरह शांत होता है और विचार स्थिर होते हैं,
तब भीतर सरस्वती तत्व प्रकट होता है।
वे अज्ञान (अविद्या) के घने अंधकार को हमेशा के लिए मिटा देने वाली प्रभात हैं।

लेकिन इस अद्वैत सत्य की गहराई में उतर कर विचार करें:
कल्पना कीजिए कि यदि इस दुनिया के सभी शब्द, सभी भाषाएँ,
और ताड़पत्रों से लेकर सर्वरों तक की सभी पुस्तकें रातों-रात जलकर राख हो जाएं,
तो क्या 'ज्ञान' समाप्त हो जाएगा? नहीं।
माँ सरस्वती उस असीम, अथाह मौन (Silence) की देवी हैं
जो सभी शब्दों और सभी ध्वनियों के जन्म का असली कारण है।

जो ज्ञान हम बाहरी किताबों या गुरुओं के शब्दों में खोजते हैं,
वह केवल एक मृत सूचना (Information) है।
असली ज्ञान (प्रज्ञा) तो वह 'शून्यता' है
जहाँ से हर मौलिक विचार, हर कविता और हर मंत्र
ब्रह्मांड में पहली बार जन्म लेता है।
वीणा के तारों को पीटने से संगीत पैदा नहीं होता,
असली संगीत तो
उन तारों के बीच मौजूद उस अदृश्य खाली जगह (Space) से उत्पन्न होता है
जो उस कंपन (Vibration) को गूंजने की अनुमति देती है।

क्या आपने कभी एकांत में ध्यान दिया है
कि जब आप अत्यंत गहरे विचार या पूर्ण मौन में होते हैं,
तो एक अदृश्य, बिना आवाज़ की आवाज़ आपके भीतर आपसे बात करती है?
वह आवाज़ किसकी है?
वह आपकी अपनी जाग्रत आत्मा, साक्षात सरस्वती हैं।

वे आपको यह सबसे कठोर सत्य सिखाती हैं
कि मानव बुद्धि का सबसे बड़ा शिखर यह जानना है
कि आप इस रहस्यमयी ब्रह्मांड के बारे में वास्तव में कुछ भी नहीं जानते।
जिस क्षण एक मनुष्य अपने 'मैं सब जानता हूँ' के अहंकार को त्याग कर,
अपने पूर्ण अज्ञान को पूरी तरह स्वीकार कर लेता है,
तब एक बहुत बड़ा चमत्कार घटित होता है—
ब्रह्मांड के सभी गूढ़ रहस्य उसके सामने अपने आप खुलने लगते हैं।

जिसे आप अपनी कुशाग्र बुद्धि का चमत्कार मानकर अहंकार करते हैं,
वह तो केवल उस महा-चेतना की एक अत्यंत छोटी सी किरण है
जो संयोग से आपके मन के मैले दर्पण पर पड़ रही है।
अंतिम सत्य को कभी किसी किताब में पढ़ा नहीं जा सकता,
उसे केवल अपनी चेतना में 'अनुभव' किया जा सकता है।
जिस दिन आप दुनिया के शब्दों में उत्तर खोजना हमेशा के लिए बंद कर देंगे,
उसी दिन भीतर बैठी सरस्वती
आपके कानों में 'अहं ब्रह्मास्मि' (मैं ही ब्रह्म हूँ) का सबसे बड़ा रहस्य
मौन रहकर फुसफुसाएंगी।
""".trimIndent()

    val SARASWATI_EN = """
Who is Saraswati? — 
She is "Vak" (The Supreme Divine Speech) and "Viveka" (Absolute Discrimination).
Maa Saraswati is the primordial Goddess of knowledge,
intellect, profound speech, pure arts, and all cosmic learning.
She is the ultimate expression of pure, unadulterated consciousness
that mercilessly dispels the thick, suffocating darkness of ignorance
with the blinding light of self-realization and wisdom.

If Lord Brahma represents the brutal 'Construction' of reality,
Saraswati is the divine 'Blueprint' without which nothing can be built.
If Brahma is the restless, wandering 'Mind',
Saraswati is the sharp, unwavering 'Intellect' that guides and reigns in that Mind.
Without Her divine presence,
Brahma's massive creation is merely a chaotic pile of dead matter and dust;
It is Saraswati alone who breathes 'Meaning', 'Name', and 'Purpose' into it.
She is reverently known as Vagdevi (Goddess of Speech), Sharada, Veenapani,
and the supreme Mother of all universal wisdom.

The sacred Sanskrit word "Saraswati" translates to:
'Saras' (the endless, flowing essence of knowledge)
and 'Wati' (the one who profoundly possesses it).
Meaning, She is the one who eternally holds
the continuous, unbreaking flow of supreme wisdom and cosmic intellect.

She is 'Saras-wati'—
She who flows continuously like a sacred, hidden river.
She is the invisible, subterranean river of spiritual wisdom
that does not flow on earth, but deep within every living being as 'Intuition'.
The hidden meaning locked deep within spoken words,
the soul-stirring music that rises from the throat,
and the sudden, profound understanding that blossoms in absolute silence—
that is entirely Saraswati.

The divine form of Maa Saraswati
is universally considered to be supremely peaceful, still, and untainted.
She is always clad in brilliant White (Shveta-Vastra);
standing completely beyond the worldly colors of passion, hatred, anger, and greed,
She represents the ultimate, undisturbed Peace
and the absolute pinnacle of 'Sattva Guna' (Flawless Purity).

Seated upon a pristine white lotus,
She symbolizes that true knowledge remains pure and elevated,
completely untouched by the muddy waters of human ego and worldly desires.
In Her four divine hands, She holds the Veena (the instrument of cosmic music and Naad),
the sacred Book (the Vedas and all infinite knowledge),
the Crystal Rosary (symbolizing deep focus, meditation, and concentration),
and the Kamandalu (the pot holding the pure water of consciousness).

The Veena She plays is not merely an instrument of art;
it is a profound teacher of the greatest philosophy of life.
It teaches that the strings of a human life
should neither be too loose (leading to lethargy and failure)
nor pulled too tight (leading to anxiety, anger, and snapping);
only in a state of perfect, mindful balance does the beautiful music of life truly emerge.

She rides the majestic Swan (Hamsa-Vahini).
In ancient Vedic lore, the Swan is the ultimate symbol of the awakened intellect,
said to possess the mythical ability to drink pure milk and leave the water behind.
Saraswati grants the spiritual seeker this exact 'Viveka' (Discrimination)—
the razor-sharp ability to clearly distinguish between the eternal Truth (Atman)
and the temporary, deceiving illusions of the material world (Maya).

According to the esoteric knowledge of Tantra and the Vedas,
She is not just the Goddess of words, but 'Nada Brahman'—the Universe as Sound.
The voice of the sacred Vedas is Saraswati Herself.
Tantric philosophy divides speech into four profound levels:
Para (the transcendent thought resting in the navel),
Pashyanti (the perceived thought moving to the heart),
Madhyama (the formulated thought reaching the throat),
and Vaikhari (the physical word finally spoken to the world).
Maa Saraswati is the absolute sovereign of all these four states of speech.
She is the master of 'Sphota'—the exact, explosive moment when silent thought bursts into meaning.

Every single form of knowledge in this vast universe—
be it quantum mechanics, astronomy, classical arts, or deep spiritual awakening—
is merely a scattered ray of Her infinite, blinding light.
Wealth (Lakshmi) is notoriously restless and moving; it is here today and gone tomorrow.
But Wisdom (Saraswati) is unshakeably stable.
Wisdom, once truly attained and realized within the soul,
can never be stolen by a thief in the night,
nor can it ever be seized by the most powerful king.

Before acquiring any form of learning,
ancient sages, students, artists, and writers
always bow their heads and pray to Maa Saraswati for divine inspiration.
Before one can worship Brahma (the power of Creativity),
one must strictly invoke Saraswati (the power of Wisdom),
because granting the power of creation to an ignorant, foolish mind
will ultimately and inevitably lead to horrific destruction.

Maa Saraswati is not merely an external Goddess carved in white marble;
She is the raw power of knowledge situated deep within the human brain and spirit.
When the mind becomes completely still and the turbulent intellect clears,
the Saraswati element organically manifests from within.
She is the golden Dawn that permanently dispels the suffocating darkness
of cosmic Ignorance (Avidya).

But consider this terrifying, deeply profound reality of Vedanta:
If every single word ever spoken by humanity,
every ancient palm leaf, and every written book were to be mysteriously burned to ashes,
would wisdom cease to exist? No.
Maa Saraswati is the Goddess of that profound, terrifying Silence
which acts as the eternal womb for all sounds and all creations.

The knowledge we frantically search for from external teachers and ancient scriptures
is merely dead data and borrowed information;
true, awakened wisdom is the absolute 'Emptiness' (Shunyata)
from which every original thought, every poem, and every mantra springs forth for the first time.
Realize that the true, mesmerizing music of the Veena
does not come from the aggressive plucking of the physical strings themselves,
but from the empty, silent space vibrating between those strings.

Have you ever noticed, in the dead of the night,
that in your deepest moments of contemplation and utter silence,
an invisible, soundless voice begins to speak to you from within?
Whose voice is that?
That is your awakened soul. That is Saraswati.

She teaches us the hardest, most ego-crushing lesson of all:
that the absolute zenith of human intelligence
is the humble, devastating realization that you know absolutely nothing about this cosmos.
When a human being completely and utterly surrenders
to their own profound ignorance, shedding the heavy armor of the ego,
a magnificent miracle happens—
the universe begins to organically decode its deepest, most guarded secrets directly into their soul.

What you proudly and arrogantly consider the brilliant flashes of your own intellect
is merely a microscopic, passing ray of Her infinite cosmic consciousness
briefly reflecting off the dirty mirror of your human mind.
The ultimate Truth of the universe cannot ever be read in a book;
it can only be vividly, intensely 'experienced'.
The exact day you completely stop looking for answers in the noise of the outside world,
the Saraswati sitting silently within you
will lean in and whisper the universe's greatest secret—'Aham Brahmasmi' (I am the Cosmos)—
directly into your awakened soul.
""".trimIndent()


    // --- UNITY IN MULTIVERSE (ADVAITA) ---
    val UNITY_HI = """
सारांश — 
अनंत ब्रह्मांड और परम अद्वैत (The Ultimate Non-Duality)।
क्या आप जानते हैं कि ब्रह्मा, विष्णु और महेश
केवल एक-एक ही नहीं हैं?
वेद और पुराण अत्यंत गूढ़ स्वर में उद्घोष करते हैं
कि यह दृश्यमान ब्रह्मांड (Universe) केवल एक नहीं है,
बल्कि 'अनंत कोटि ब्रह्मांड' (Infinite Universes) हैं।

महाविष्णु और सदाशिव
इस पूरी अनंत सृष्टि के एकमात्र मूल (कारण) हैं।
कारणार्णवशायी (महाविष्णु) उस घोर, अथाह 'कारण-सागर' में
गहरी योगनिद्रा में लेटे हुए हैं।
जब वे अपनी नासिका से श्वास बाहर छोड़ते हैं,
तो उनके रोम-कूपों से अरबों-खरबों बुलबुले निकलते हैं—
और हर एक बुलबुला अपने आप में एक पूरा, स्वतंत्र 'ब्रह्मांड' है।

इसी तरह, सदाशिव
वह परम, विशुद्ध चेतना हैं,
जो निराकार, अनादि ज्योति रूप में
इन सभी अनंत ब्रह्मांडों का एकमात्र मौन आधार हैं।

हर उस एक 'बुलबुले' (ब्रह्मांडीय अंडे) के भीतर
उसकी अपनी एक अलग त्रिमूर्ति जन्म लेती है:
सृजन के लिए एक अलग ब्रह्मा,
पालन के लिए एक अलग विष्णु,
और अंततः संहार के लिए एक अलग रुद्र या महादेव।

जैसे आकाश में चमकता हुआ एक ही सूर्य
धरती पर रखे लाखों जलपात्रों में अलग-अलग दिखाई देता है;
और मूर्ख यह समझते हैं कि हर बर्तन का सूर्य अलग है,
वैसे ही वह एक परब्रह्म
प्रत्येक ब्रह्मांड में अलग त्रिमूर्ति के रूप में
केवल अपने कार्यों का अभिनय कर रहा है।

सृष्टि की मूल ऊर्जा 'आदि-शक्ति' (परा-शक्ति) हैं।
हर ब्रह्मांड के भीतर कार्य करने के लिए
वे स्वयं को तीन भिन्न-भिन्न रूपों में प्रकट करती हैं:
ब्रह्म-ज्ञान के लिए 'सरस्वती',
पोषण और ऐश्वर्य के लिए 'लक्ष्मी',
और पूर्ण परिवर्तन तथा संहार के लिए 'पार्वती या काली'।

यह सब अलग-अलग दिखते हुए भी
वास्तव में एक-दूसरे से बिल्कुल भी अलग नहीं हैं।
जैसे सोना तो एक ही होता है,
चाहे उसे पिघलाकर मुकुट बना दिया जाए या पैरों की पायल।
जैसे जल तो एक ही है,
चाहे वह बर्फ बने, भाप बने या नदी बनकर बहे।
वैसे ही, ऋग्वेद का महावाक्य है:
'एकं सद्विप्रा बहुधा वदन्ति'—
सत्य केवल एक है,
किन्तु ज्ञानी पुरुष उसके कार्यों के अनुसार उसे अनेक नामों से पुकारते हैं।

हरि (विष्णु) और हर (शिव)
सदा एक-दूसरे का ध्यान करते हैं।
विष्णु के हृदय में शिव का वास है,
और शिव के हृदय में विष्णु का।
विशुद्ध पुरुष (चेतना) और मूल प्रकृति (शक्ति)
मिलकर ही इस ब्रह्मांड की 'पूर्णता' को जन्म देते हैं।

जो सबके भीतर छिपा है
और फिर भी सबसे कोसों दूर, सबसे परे है;
जो कण-कण में सर्वत्र गतिमान है
और फिर भी अपनी जगह पर पूरी तरह से अचल है—
वही 'ब्रह्म' है।

उपनिषदों के महावाक्य गर्जना करते हैं:
'अहं ब्रह्मास्मि'—वह अनंत चेतना मैं ही हूँ।
'तत्त्वमसि'—वह परम सत्य तुम भी हो।
'प्रज्ञानं ब्रह्म'—विशुद्ध ज्ञान ही ब्रह्म है।
'अयमात्मा ब्रह्म'—यह आत्मा ही ब्रह्म है।

अंत में,
जिसे आप बाहर मंदिरों में, मूर्तियों में
और तीर्थों में जीवन भर खोजते रहते हैं,
वह आपके ही भीतर आपकी 'आत्मा' होकर
अत्यंत शांति से बैठा हुआ है।
ब्रह्मांड अनंत हैं,
आकार अनंत हैं,
पर उन सबको प्राण देने वाली और चलाने वाली चेतना (परमात्मा) केवल एक ही है। 

इसलिए,
ब्रह्मांड अनेक हैं,
देवताओं के रूप और नाम अनेक हैं,
जन्म अनेक हैं, और मृत्यु अनेक हैं,
पर सत्य केवल एक ही है। 
वही अद्वैत ब्रह्म है। 
वही परमात्मा है। 
वही परम आत्मा है।

परंतु इस वेदांत की सबसे गहरी शून्यता में उतर कर देखिए:
क्या यह संभव है
कि आप और मैं वास्तव में
अलग-अलग जीव हैं ही नहीं?
कल्पना कीजिए कि यह असीम सत्ता एक विशाल ब्रह्मांडीय दर्पण है,
जो माया के आघात से टूट कर अरबों टुकड़ों में बिखर गया है,
और हर एक छोटे से टुकड़े को यह प्रबल भ्रम हो गया है
कि वह स्वयं एक पूरा, स्वतंत्र अस्तित्व है।

अद्वैत वेदांत और अष्टावक्र गीता का सबसे गहरा,
सबसे डरावना और सबसे मुक्त करने वाला रहस्य यह है
कि इस पूरे अस्तित्व में कोई 'दूसरा' है ही नहीं (नेह नानास्ति किंचन)।
इस धरती पर जिसे आप बिना शर्त प्रेम करते हैं,
और जिससे आप घोर घृणा करते हैं,
वह कोई 'अन्य' नहीं,
बल्कि वह सब आप ही की चेतना का एक भिन्न रूप है।

यह अनंत सृष्टि
परमात्मा के 'इंद्रजाल' (ब्रह्मांडीय भ्रम) की तरह है,
जिसे वह परब्रह्म स्वयं अपने ही भीतर,
अपनी ही योगमाया से,
केवल अपनी 'लीला' (Divine Play) के लिए रच रहा है।
मुंडक उपनिषद कहता है कि
जैसे मकड़ी अपने ही भीतर से जाला बुनती है
और फिर स्वयं उसी में विचरण करती है,
वैसे ही ब्रह्म इस जगत को रचता है और उसी में प्रवेश कर जाता है।

जब मृत्यु का यह भारी पर्दा अंततः गिरेगा,
तो आसमान में बादलों के ऊपर कोई न्याय करने वाला भगवान
तराजू लेकर बाहर नहीं बैठा होगा;
आप स्वयं अपनी चेतना के सर्वोच्च आयाम से जाग उठेंगे,
अपने इस छोटे से मानव जीवन के हर पल को देखेंगे,
और एक गहरी मुस्कान के साथ जानेंगे
कि यह सब केवल एक महा-स्वप्न था।

आप समुद्र की वह छोटी, कमज़ोर लहर नहीं हैं
जो कुछ पल बाद उठकर किनारे के पत्थरों से टकराकर टूट जाएगी;
आप स्वयं वह गहरा, अनंत और शांत महासागर हैं
जो केवल कुछ पल के लिए 'लहर' होने का झूठा अनुभव कर रहा है।

अवधूत गीता पूछती है:
"जब मैं ही वह पूर्ण ब्रह्म हूँ, तो मैं किसके सामने सिर झुकाऊँ?"
उस परम सत्य की खोज में
आप न जाने कितने युगों से, कितने शरीरों में भटक रहे हैं,
जबकि वह सत्य कहीं बाहर नहीं है,
वह वास्तव में
खोज करने वाले की आँखों के पीछे से ही बैठकर बाहर देख रहा है।

आँख स्वयं को नहीं देख सकती,
चाकू स्वयं को नहीं काट सकता,
अग्नि स्वयं को नहीं जला सकती,
और 'आप' उस परमात्मा को बाहर कभी नहीं खोज सकते—
क्योंकि आप स्वयं ही वह परमात्मा हैं।

कोई खोजने वाला नहीं है,
और कुछ खोजना भी शेष नहीं है।
जिस दिन खोज समाप्त होती है,
उस दिन यह ब्रह्मांड भी समाप्त हो जाता है,
और केवल विशुद्ध, अनंत चेतना शेष रह जाती है।
यही परम अद्वैत है।
यही इस अस्तित्व का अंतिम, नग्न सत्य है।
""".trimIndent()

    val UNITY_EN = """
Summary — 
The Infinite Universes & The Ultimate Non-Duality (Advaita).
Did you know there isn't just one single
Brahma, Vishnu, or Shiva?
The ancient Vedas and Puranas loudly proclaim in profound tones
that there is not just one Universe,
but 'Ananta Koti Brahmanda' (Infinite Millions of Universes).

Maha-Vishnu and Sada-Shiva
are the absolute Root Cause (The Ultimate Source) of all creation.
Karanodakashayi Vishnu (Maha-Vishnu) lies deeply submerged
in His divine Yoganidra within the unfathomable 'Causal Ocean'.
When He slowly exhales from His divine nostrils,
billions and trillions of bubbles emerge from the pores of His cosmic skin—
and every single bubble is an entire, independent 'Universe'.

Similarly, Sada-Shiva
is the Supreme, formless Consciousness,
acting as the eternal, blazing pillar of light (Jyotirlinga)
that serves as the silent, unmoving foundation of all these universes.

Inside every single one of those bubbles (Cosmic Eggs),
a specific, distinct Trinity is born to govern it:
a specific Brahma solely to construct it,
a specific Vishnu solely to maintain it,
and a specific Rudra or Mahadev solely to eventually dissolve it.

Just as a single, brilliantly shining Sun in the sky
appears as millions of different reflections in millions of clay pots filled with water;
and the ignorant foolishly believe that every pot contains a different Sun,
the singular Supreme Truth (Brahman) operates
as a distinct Trinity in every universe,
merely playing out its different cosmic roles.

The Primordial Energy is 'Adi-Shakti' (Para-Shakti).
To carry out the vast functions within every universe,
She manifests Herself into three distinct functional forms:
'Saraswati' for absolute Cosmic Knowledge,
'Lakshmi' for infinite Resources and Opulence,
and 'Parvati or Kali' for absolute Power, Transformation, and Destruction.

Despite this staggering visual complexity,
they are absolutely not separate entities.
Just as gold is fundamentally one,
whether it is melted down to forge a royal crown or an ankle bracelet.
Just as water is fundamentally one,
whether it takes the form of solid ice, invisible steam, or a raging river.
Similarly, the Rigveda delivers the ultimate decree:
"Ekam Sat Vipra Bahudha Vadanti"—
The Truth is only One,
but the enlightened sages call It by many names according to Its functions.

Hari (Vishnu) and Hara (Shiva)
are in a state of eternal meditation upon each other.
Shiva eternally resides in the heart of Vishnu,
and Vishnu eternally resides in the heart of Shiva.
The union of the pure Purusha (Consciousness) and Prakriti (Cosmic Energy)
is the only force that creates the 'Completeness' of this multiverse.

That which is hidden intimately within everyone,
yet stands infinitely far beyond everything;
that which moves everywhere in every atom,
yet remains completely, eternally immovable—
that is Brahman.

The Upanishadic Mahavakyas (Great Sayings) fiercely declare:
'Aham Brahmasmi'—I am that exact infinite Consciousness.
'Tat Tvam Asi'—You are also that absolute Truth.
'Prajnanam Brahma'—Pure, unconditioned Knowledge is Brahman.
'Ayamatma Brahma'—This very Soul is Brahman.

Ultimately,
the Divinity you spend your entire life desperately searching for
in stone idols, distant temples, and holy pilgrimages,
is sitting utterly silent, breathing right within you
as your own 'Soul' (Atman).
The Universes are unquestionably infinite,
the shapes and forms are infinite,
but the Consciousness (Paramatma) that breathes life into them is strictly One. 

Therefore,
the universes are many,
the forms and names of the deities are many,
the births are many, and the deaths are many,
but the Truth is only One. 
That is the Non-Dual Brahman. 
That is Paramatma. 
That is the Supreme Soul.

But dare to descend into the absolute void of Vedanta:
Is it entirely, terrifyingly possible
that you and I
are not actually separate living beings at all?
Imagine if this absolute reality is just one colossal, cosmic mirror
that was struck by the force of Maya and shattered into billions of fragments,
and every single tiny shard falsely and stubbornly believes
it is an independent, whole universe.

The deepest, most terrifying,
and most liberating secret of Advaita Vedanta and the Ashtavakra Gita
is that there is absolutely no 'Other' (Neha Nanasti Kinchana).
The person on this earth whom you love unconditionally,
and the person whom you passionately and violently despise,
are simply different, masked iterations of your own consciousness.

This infinite Multiverse operates
like an unfathomably complex 'Indrajala' (Cosmic Magic/Illusion),
a grand cosmic play
that the Supreme Brahman is projecting entirely within Himself,
solely for the joy of the experience (Divine Leela).
The Mundaka Upanishad beautifully explains that
just as a spider weaves a massive web completely out of its own body
and then freely walks upon it,
Brahman creates this entire universe from Himself and then enters into it.

When the final, heavy curtain of death falls,
you will not find a judgmental deity sitting on a throne above the clouds
waiting to weigh your sins and virtues;
you will simply awaken into the highest dimension of your own consciousness,
review every fleeting second of your brief human life,
and smile deeply, realizing it was all just a magnificent Great Dream.

You are not a tiny, fragile wave on the surface of the ocean,
destined to rise, crash against the rocks, and disappear forever;
you are the deep, infinite, and eternal ocean itself,
temporarily choosing to experience
the false limitation of what it feels like to be a wave.

The Avadhuta Gita boldly asks:
"When I am the Supreme Brahman, to whom shall I bow down?"
You have been frantically searching for the Supreme Truth
wandering through countless epochs and countless bodies,
entirely unaware that the Truth is not waiting "out there."
The Truth is actually the one sitting right behind your eyes,
silently looking out into the world.

An eye can never turn around to see itself,
a sharp knife can never cut itself,
fire can never burn itself,
and 'You' can never go out and find God—
because you *are* God.

There is no one left to search,
and there is absolutely nothing left to be found.
The exact day the search completely ends,
this illusory universe also ends,
and only Pure, Infinite Consciousness remains.
This is the ultimate Advaita (Non-Duality).
This is the final, naked truth of all existence.
""".trimIndent()
}