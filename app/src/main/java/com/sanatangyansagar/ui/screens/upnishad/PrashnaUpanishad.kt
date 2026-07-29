package com.sanatangyansagar.ui.screens.upnishad

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

// Data Model
data class PrashnaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrashnaUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                if (shlokaNumber != null && shlokaNumber in 1..20) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-20)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
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
            itemsIndexed(prashnaShlokasList) { _, shloka ->
                PrashnaShlokaCard(shloka)
            }
        }
    }
}

@Composable
fun PrashnaShlokaCard(shloka: PrashnaShloka) {
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
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

val prashnaShlokasList = listOf(
    PrashnaShloka(
        id = 1,
        sanskrit = "ॐ सुकेशा च भारद्वाजः शैब्यश्च सत्यकामः सौर्यायणी च गार्ग्यः कौसल्यश्चाश्वलायनो भार्गवो वैदर्भिः कबन्धी कात्यायनस्ते हैते ब्रह्मपरा ब्रह्मनिष्ठाः परं ब्रह्मान्वेषमाणा एष ह वै तत्सर्वं वक्ष्यतीति ते ह समित्पाणयो भगवन्तं पिप्पलादमुपसन्नाः ॥ १ ॥",
        hindi = """
            इस प्रथम श्लोक में छह ऋषियों का परिचय दिया गया है जो सत्य के खोजी हैं।
            भारद्वाज सुकेशा, सत्यकाम, सौर्यायणी गार्ग्य, कौसल्य, भार्गव और कबन्धी।
            ये सभी ऋषि ब्रह्म-परायण और ब्रह्म-निष्ठ थे, यानी वे केवल सत्य को जानते थे।
            वे परम ब्रह्म के ज्ञान की खोज में थे क्योंकि उनकी जिज्ञासा अत्यंत गहरी थी।
            उन्होंने सोचा कि महर्षि पिप्पलाद उनके सभी संशयों का अंत कर सकते हैं।
            वे शिष्य की मर्यादा का पालन करते हुए हाथों में समिधा लेकर ऋषि के पास गए।
            समिधा ले जाना यह दर्शाता है कि वे सेवा और समर्पण के लिए तैयार थे।
            प्राचीन परंपरा में ज्ञान प्राप्ति के लिए गुरु के प्रति समर्पण अनिवार्य था।
            वे महर्षि के आश्रम में सत्य की व्याख्या सुनने की तीव्र इच्छा के साथ पहुंचे।
            यह श्लोक एक महान संवाद की नींव रखता है जो सृष्टि के रहस्यों को खोलेगा।
        """.trimIndent(),
        english = """
            The opening verse introduces six earnest seekers of the absolute Truth.
            Sukesha, Satyakama, Sauryayani, Kausalya, Bhargava, and Kabandhi.
            These sages were 'Brahmapara'—totally dedicated to the Supreme Reality.
            They were 'Brahmanishtha'—firmly established in their spiritual pursuits.
            Yet, they felt a profound need to understand the ultimate cause of existence.
            Believing that Pippalada could reveal the Truth, they approached him.
            They carried 'Samidha' (sacrificial fuel) as a symbol of humility and service.
            This gesture signifies the student's readiness to serve the Master.
            It reflects the ancient Vedic protocol for approaching a realized teacher.
            Thus begins one of the most scientific dialogues in the Upanishadic tradition.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 2,
        sanskrit = "तान्ह ह स ऋषिरुवाच भूय एव तपसा ब्रह्मचर्येण श्रद्धया संवत्सरं संवत्स्यथ यथाकामं प्रश्नान् पृच्छत यदि विज्ञास्यामः सर्वं ह वो वक्ष्याम इति ॥ २ ॥",
        hindi = """
            महर्षि पिप्पलाद ने उनकी जिज्ञासा देखी पर तुरंत उत्तर नहीं दिया।
            उन्होंने ऋषियों से एक वर्ष तक आश्रम में निवास करने की शर्त रखी।
            इस समय के दौरान उन्हें तप, ब्रह्मचर्य और श्रद्धा का पालन करना था।
            तप का अर्थ है इंद्रियों का संयम और मानसिक एकाग्रता का विकास करना।
            ब्रह्मचर्य का अर्थ है ऊर्जा को आध्यात्मिक उन्नति की ओर मोड़ना।
            श्रद्धा का अर्थ है गुरु के वचनों और शास्त्रों में अटूट विश्वास रखना।
            ऋषि ने कहा कि पात्रता सिद्ध होने के बाद ही ज्ञान ग्रहण किया जा सकता है।
            उन्होंने आश्वासन दिया कि यदि वे जानेंगे, तो सभी प्रश्नों के उत्तर देंगे।
            यह गुरु की विनम्रता और शिष्य की परीक्षा का एक सुंदर उदाहरण है।
            बिना पात्रता के दिया गया उच्च ज्ञान निष्फल हो जाता है, यही इसका संदेश है।
        """.trimIndent(),
        english = """
            Sage Pippalada acknowledged the seekers but did not answer immediately.
            He asked them to live in his forest retreat for another full year.
            He prescribed three essential practices: Tapas, Brahmacharya, and Shraddha.
            Tapas signifies austerity and the purifying fire of self-discipline.
            Brahmacharya refers to the conservation and redirection of vital energy.
            Shraddha denotes deep-seated faith in the teacher and the process.
            The Sage emphasized that spiritual readiness is a prerequisite for Truth.
            Only a purified mind can reflect the subtle light of the Upanishads.
            He humbly stated he would share all he knew after their year of trial.
            This highlights the patience required in the pursuit of higher wisdom.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 3,
        sanskrit = "अथ कबन्धी कात्यायन उपेत्य पप्रच्छ । भगवन् कुतो ह वा इमाः प्रजाः प्रजायन्त इति ॥ ३ ॥",
        hindi = """
            एक वर्ष की कठिन तपस्या और साधना पूर्ण होने के बाद समय आया।
            सबसे पहले कत्य-पुत्र कबन्धी ने महर्षि पिप्पलाद के पास जाकर पूछा।
            उनका प्रश्न बहुत ही मौलिक था: 'यह सृष्टि और जीव कहाँ से आते हैं?'
            वे जीवन के स्रोत और उत्पत्ति के मूल कारण को जानना चाहते थे।
            संसार में इतने जीव और विविधता कैसे प्रकट होती है, यही उनकी शंका थी।
            यह प्रश्न केवल शरीर की उत्पत्ति के बारे में नहीं, बल्कि चेतना के बारे में है।
            कबन्धी यह जानना चाहते थे कि वह कौन सा बीज है जिससे यह जगत खिला है।
            यह जिज्ञासा हर वैज्ञानिक और दार्शनिक के मन में सदैव बनी रहती है।
            ऋषि ने इस प्रश्न को बहुत गंभीरता से लिया क्योंकि यह आधारभूत है।
            यहाँ से सृष्टि-उत्पत्ति के वैज्ञानिक और आध्यात्मिक सिद्धांत का आरम्भ होता है।
        """.trimIndent(),
        english = """
            After a year of disciplined living, the time for inquiry finally arrived.
            Kabandhi, the son of Katya, was the first to approach the Sage.
            He asked: 'Venerable Sir, from where are all these creatures born?'
            This is the fundamental question concerning the origin of life itself.
            He sought to understand the primary cause behind the manifest universe.
            It is a query that probes into the mechanics of creation and biological birth.
            He wanted to know what primal force brings matter and life together.
            This question bridges the gap between physics and metaphysics.
            The Sage welcomes this inquiry as the starting point of the first Prashna.
            It sets the stage for the explanation of the dual nature of existence.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 4,
        sanskrit = "तस्मै स होवाच प्रजाकामो वै प्रजापतिः स तपोऽतप्यत स तपस्तप्त्वा स मिथुनमुत्पादयते रयिं च प्राणं चेत्येतौ मे बहुधा प्रजाः करिष्यत इति ॥ ४ ॥",
        hindi = """
            ऋषि ने उत्तर दिया कि प्रजाओं की इच्छा वाले प्रजापति ने तप किया।
            प्रजापति ने सृष्टि के संकल्प के साथ अपने भीतर एकाग्रता (तप) की।
            उस तप के परिणाम स्वरूप उन्होंने एक जोड़ा (मिथुन) उत्पन्न किया।
            इस जोड़े में एक तत्व 'रयि' था और दूसरा तत्व 'प्राण' था।
            'रयि' का अर्थ है पदार्थ या जड़ प्रकृति जो भोग्य वस्तु बनती है।
            'प्राण' का अर्थ है ऊर्जा या चेतना जो भोक्ता और सक्रिय शक्ति है।
            प्रजापति ने सोचा कि ये दोनों मिलकर सृष्टि का विस्तार करेंगे।
            संसार की हर वस्तु इन दो तत्वों के मेल से ही निर्मित हुई है।
            यह द्वैत (Dualism) ही संसार के संचालन का मुख्य आधार है।
            बिना ऊर्जा (प्राण) और बिना आधार (रयि) के कुछ भी संभव नहीं है।
        """.trimIndent(),
        english = """
            The Sage replied that Prajapati, the Lord of creatures, desired progeny.
            He performed intense meditation or 'Tapas' to visualize the creation.
            From this meditative heat, He produced a fundamental pair (Mithuna).
            This pair consisted of 'Rayi' (Matter) and 'Prana' (Energy/Spirit).
            Rayi represents the material, passive, and substantial aspect of nature.
            Prana represents the dynamic, active, and conscious principle of life.
            Prajapati intended for these two to interact and multiply in manifold ways.
            Every entity in the universe is a combination of these two principles.
            It explains that creation is not a vacuum but a synthesis of opposites.
            This verse introduces the cosmic polarity that drives all of existence.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 5,
        sanskrit = "आदित्यो ह वै प्राणो रयिरेव चन्द्रमा रयिर्वा एतत्सर्वं यन्मूर्तं चामूर्तं च तस्मान्मूर्तिरेव रयिः ॥ ५ ॥",
        hindi = """
            ऋषि समझाते हैं कि सूर्य ही साक्षात् 'प्राण' का प्रतीक और स्रोत है।
            उसी प्रकार चंद्रमा को 'रयि' यानी पदार्थ या शीतलता का प्रतीक माना गया है।
            जो कुछ भी मूर्त (ठोस) और अमूर्त (सूक्ष्म) है, वह सब रयि ही है।
            परंतु विशेष रूप से जो स्थूल आकार ले चुका है, उसे ही रयि कहा जाता है।
            प्राण वह सूक्ष्म शक्ति है जो इन आकारों के भीतर जीवन फूंकती है।
            सूर्य की ऊर्जा के बिना पृथ्वी पर जीवन (प्राण) का अस्तित्व असंभव है।
            चंद्रमा उस ऊर्जा को ग्रहण करके पोषण और स्थिरता का आधार बनता है।
            यहाँ भौतिक विज्ञान के तत्वों को आध्यात्मिक प्रतीकों में पिरोया गया है।
            संपूर्ण जगत इन्हीं दो शक्तियों के बीच का एक निरंतर संतुलन है।
            रयि ही वह मिट्टी है जिसे प्राण का कुम्हार अलग-अलग रूप देता है।
        """.trimIndent(),
        english = """
            The Sage explains that the Sun is indeed the cosmic Prana or Life-force.
            The Moon is identified as Rayi, representing matter and the receptive.
            All that is formed (gross) and formless (subtle) is essentially Rayi.
            However, anything that has attained a solid shape is specifically Rayi.
            Prana is the subtle energy that vibrates within these material forms.
            The Sun provides the vital energy necessary for all biological functions.
            The Moon symbolizes the nourishing, reflective, and material support system.
            This identifies the macrocosmic counterparts of the two creative principles.
            The entire universe is a play between light (Prana) and form (Rayi).
            Matter provides the medium, while Prana provides the movement and life.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 6,
        sanskrit = "अथादित्य उदयन्यत्प्राचीं दिशं प्रविशति तेन प्राच्यान्प्राणान्रश्मिषु संनिधत्ते । यद्दक्षिणां यत्प्रतीचीं यदुदीचीं यदधो यदूर्ध्वं यदन्तरा दिशो यत्सर्वं प्रकाशयति तेन सर्वान्रप्राणान्रश्मिषु संनिधत्ते ॥ ६ ॥",
        hindi = """
            जब सूर्य उदय होता है, तो वह सबसे पहले पूर्व दिशा में प्रवेश करता है।
            अपनी किरणों के माध्यम से वह पूर्व दिशा के सभी जीवों में प्राण भरता है।
            जैसे-जैसे वह दक्षिण, पश्चिम और उत्तर दिशाओं में प्रकाश फैलाता है।
            वैसे-वैसे वह उन सभी क्षेत्रों के प्राणों को अपनी किरणों से जोड़ लेता है।
            ऊपर, नीचे और मध्य की सभी दिशाएं भी उसकी ऊर्जा से प्रकाशित होती हैं।
            सूर्य केवल प्रकाश का गोला नहीं है, वह ब्रह्मांडीय चेतना का वितरण केंद्र है।
            वह प्रत्येक जीव की इंद्रियों और मन को सक्रिय करने वाली मुख्य शक्ति है।
            उसकी किरणों में वह सामर्थ्य है जो जड़ पदार्थ में चेतना का संचार करती है।
            यह श्लोक सूर्य को 'सर्व-प्राण' यानी सभी प्राणों का स्वामी घोषित करता है।
            बिना सूर्योदय के, संसार की सभी गतिविधियों का पहिया रुक जाएगा।
        """.trimIndent(),
        english = """
            When the Sun rises, he first enters the eastern quarter of the sky.
            Through his rays, he bathes all living beings in the east with life.
            As he traverses towards the south, west, and the north directions.
            He integrates the life-breaths of all creatures within his golden rays.
            Above, below, and everywhere in between, his light reaches and enlivens.
            The Sun is not merely a physical star but the distributor of cosmic Prana.
            He is the force that awakens the senses and the intellect in every being.
            His radiation carries the vibration that stirs matter into conscious life.
            This verse establishes the Sun as the universal 'Eye' and 'Soul' of life.
            Without his daily rise, the machinery of world activities would perish.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 7,
        sanskrit = "स एष वैश्वानरो विश्वरूपः प्राणोऽग्निरुदयते । तदेतदृचाभ्युक्तम् ॥ ७ ॥",
        hindi = """
            यह सूर्य ही वैश्वानर है, जो समस्त प्राणियों के भीतर जठराग्नि के रूप में है।
            वह विश्वरूप है, क्योंकि संसार का हर रूप उसी की ऊर्जा का रूपांतरण है।
            वह प्राण-स्वरूप अग्नि है जो प्रतिदिन पूर्व दिशा से उदय होता है।
            ऋषि कहते हैं कि इसी सत्य को वेदों की ऋचाओं में भी प्रमाणित किया गया है।
            वह अग्नि केवल बाहर नहीं जलती, बल्कि हमारे जीवन के भीतर भी सक्रिय है।
            वही शक्ति जो नक्षत्रों को जलाती है, वही हमारे भोजन को पचाती है।
            यह श्लोक बाहरी प्रकृति और आंतरिक शरीर के बीच एक सेतु बनाता है।
            सूर्य को केवल एक पिंड न मानकर एक महान जीवंत देवता माना गया है।
            उसकी सर्वव्यापकता ही उसे 'वैश्वानर' की उपाधि प्रदान करती है।
            यह ज्ञान हमें सिखाता है कि हम और ब्रह्मांड एक ही ऊर्जा से संचालित हैं।
        """.trimIndent(),
        english = """
            This Sun is 'Vaishvanara'—the fire common to all human beings.
            He is 'Vishvarupa'—assuming all forms that we perceive in the world.
            He is the fiery Prana that rises every morning to sustain the world.
            The Sage notes that this truth is echoed in the ancient Vedic verses.
            The fire that burns in the Sun also burns within the human stomach.
            The same energy that ignites stars also digests the food we eat.
            This verse creates a bridge between external nature and internal biology.
            It portrays the Sun as a living, breathing, and all-encompassing deity.
            His omnipresence is what justifies the title 'Vaishvanara' (Universal Man).
            It teaches us that our personal life-force is a part of the cosmic fire.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 8,
        sanskrit = "विश्वरूपं हरिणं जातवेदसं परायणं ज्योतिरेकं तपन्तम् । सहस्ररश्मिः शतधा वर्तमानः प्राणः प्रजानामुदयत्येष सूर्यः ॥ ८ ॥",
        hindi = """
            वह सूर्य विश्वरूप है, सभी रंगों और रूपों को धारण करने वाला महान तेज।
            वह 'हरिण' है, जो अज्ञान के अंधकार को अपनी किरणों से हर लेता है।
            वह 'जातवेदस' है, जो सभी उत्पन्न वस्तुओं के बारे में पूर्ण ज्ञान रखता है।
            वही सभी प्राणियों का अंतिम आश्रय और एकमात्र परम ज्योति है।
            वह सहस्रों किरणों के साथ आकाश में तपता हुआ ऊपर की ओर उठता है।
            वह सैकड़ों रूपों में अलग-अलग जीवों के भीतर प्राण बनकर स्थित है।
            वही वह प्राण है जो समस्त प्रजाओं के जीवन की रक्षा करता है।
            इस श्लोक में सूर्य की महिमा का अत्यंत काव्यात्मक वर्णन किया गया है।
            उसका उदय होना केवल दिन की शुरुआत नहीं, बल्कि जीवन का नवीनीकरण है।
            वह एक है, पर अपनी किरणों के माध्यम से अनंत शरीरों में प्रकट होता है।
        """.trimIndent(),
        english = """
            The Sun is 'Vishvarupa'—the one who possesses all manifest forms.
            He is 'Harinam'—the radiant one who dispels the darkness of ignorance.
            He is 'Jatavedas'—the omniscient being who knows all that is born.
            He is the ultimate refuge and the single, supreme light of the cosmos.
            He rises with a thousand rays, blazing with the fire of existence.
            He exists in a hundred ways within the various species of creatures.
            This Sun is the true Prana or life-breath of all created beings.
            This verse offers a poetic and profound glorification of the solar deity.
            His rising is not just a solar event but a renewal of global vitality.
            Though he is one, he manifests in infinite bodies through his energy.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 9,
        sanskrit = "संवत्सरों वै प्रजापतिस्तस्यायने दक्षिणं चोत्तरं च ... एष ह वै रयिर्यः पितृयाणः ॥ ९ ॥",
        hindi = """
            महर्षि पिप्पलाद कहते हैं कि संवत्सर (वर्ष) भी प्रजापति का ही रूप है।
            समय के इस चक्र के दो मुख्य मार्ग या अयन हैं—दक्षिण और उत्तर।
            जो लोग केवल सांसारिक फल की इच्छा से यज्ञ और दान-पुण्य करते हैं।
            वे मृत्यु के पश्चात दक्षिण मार्ग से 'चंद्रलोक' की यात्रा पर जाते हैं।
            वहां अपने पुण्यों का भोग करने के बाद, उन्हें पुनः लौटकर आना पड़ता है।
            संतान और भौतिक सुख की इच्छा रखने वाले लोग इसी मार्ग को चुनते हैं।
            इसे 'पितृयान' मार्ग कहा जाता है, जो रयि यानी पदार्थ से संबंधित है।
            यह मार्ग पुनर्जन्म के चक्र से बंधा हुआ है और मोक्ष प्रदान नहीं करता।
            रयि का अर्थ यहाँ कर्मों के भौतिक और दृश्य फल के रूप में लिया गया है।
            यह श्लोक कर्मकांड के मार्ग और उसके सीमित परिणामों की व्याख्या करता है।
        """.trimIndent(),
        english = """
            Sage Pippalada explains that the Year itself is a form of Prajapati.
            The cyclic time has two distinct paths known as Ayana: South and North.
            Those who perform sacrifices and good deeds solely for earthly rewards.
            They travel through the southern path to reach the world of the Moon.
            After exhausting the merits of their deeds, they are bound to return.
            This path is taken by those who still cling to desires for progeny and joy.
            It is called 'Pitriyana'—the path of the ancestors, linked with Rayi.
            This route is circular and keeps the soul within the cycle of rebirth.
            Rayi here symbolizes the material and temporary fruit of one's actions.
            The verse warns that mere ritualistic action leads to a transient heaven.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 10,
        sanskrit = "अथ उत्तरणेन तपसा ब्रह्मचर्येण श्रद्धया विद्यात्मानमन्विष्यादित्यमभिजयन्ते ... एतदमृतमभयमेतत् परायणमेतस्मान्न पुनरावर्तन्त इत्येष निरोधः ॥ १० ॥",
        hindi = """
            किंतु जो साधक तप, ब्रह्मचर्य और श्रद्धा के साथ आत्मा की खोज करते हैं।
            वे 'विद्या' यानी आत्मज्ञान के माध्यम से उत्तर मार्ग से सूर्य-लोक को जीतते हैं।
            सूर्य-लोक ही सभी प्राणों का स्रोत है और परम शांति का सर्वोच्च स्थान है।
            यह स्थान अमृत (अविनाशी), अभय (भय से रहित) और अंतिम लक्ष्य है।
            जो एक बार इस परम धाम को प्राप्त कर लेता है, वह पुनः जन्म नहीं लेता।
            इसे 'देवयान' मार्ग कहा जाता है, जो चेतना के उच्चतम स्तर की ओर ले जाता है।
            यहाँ 'निरोध' का अर्थ है जन्म-मरण के चक्र का हमेशा के लिए रुक जाना।
            यह मार्ग कर्मों के फल की जगह स्वयं के शुद्धिकरण पर आधारित है।
            ज्ञानी पुरुष सूर्य की ऊर्जा में विलीन होकर शाश्वत सत्य को प्राप्त करते हैं।
            यह श्लोक मोक्ष के मार्ग और आत्म-साक्षात्कार की महिमा का वर्णन करता है।
        """.trimIndent(),
        english = """
            However, those seekers who seek the Self through penance and faith.
            Through 'Vidya' or Self-knowledge, they conquer the world of the Sun.
            The solar realm is the source of all life-force and the highest peace.
            It is the state of immortality, fearlessness, and the final destination.
            Once a soul attains this supreme abode, it never returns to rebirth.
            This is known as 'Devayana'—the path of the gods and high consciousness.
            The word 'Nirodha' here implies the permanent cessation of the cycle.
            This path is based on inner purification rather than external rituals.
            The wise merge into the solar energy and attain the eternal Truth.
            The verse glorifies the path of liberation and the realization of the Self.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 11,
        sanskrit = "पञ्चपादं पितरं द्वादशाकृतिं दिव आहुः परे अर्धे पुरीषिणम् । अथेमे अन्य उ परे विचक्षणं सप्तचक्रे षडर आहुरर्पितमिति ॥ ११ ॥",
        hindi = """
            विद्वान लोग संवत्सर को पाँच ऋतुओं (पाँवों) वाला पिता कहते हैं।
            इसमें बारह महीने ही इसकी बारह आकृतियां या रूप माने गए हैं।
            वह स्वर्ग के ऊपरी भाग में स्थित होकर जल की वर्षा करने वाला है।
            अन्य विचारक इसे सात चक्रों और छह अरों वाले रथ पर सवार देखते हैं।
            सात चक्र यानी सूर्य की सात किरणें और छह अरे यानी छह मुख्य ऋतुएं।
            समय के इस पहिये में ही संपूर्ण ब्रह्मांड और उसकी गतियां टिकी हुई हैं।
            यह श्लोक समय के जटिल चक्र को प्रतीकों के माध्यम से समझाता है।
            संवत्सर ही वह आधार है जिससे पृथ्वी पर अन्न और जीवन संभव होता है।
            चाहे हम इसे किसी भी रूप में देखें, समय ही सबका महान पालक है।
            समय की यह धारा ही प्रजापति का व्यक्त रूप है जो हमें पालती है।
        """.trimIndent(),
        english = """
            Wise men describe the Year as a father with five feet (seasons).
            It is said to possess twelve forms, representing the twelve months.
            He dwells in the upper half of heaven, being the sender of life-giving rain.
            Others perceive him as mounted on a chariot with seven wheels and six spokes.
            The seven wheels are the seven rays of the sun, and spokes are the seasons.
            Within this cosmic wheel of time, the entire universe is firmly placed.
            This verse explains the complex cycle of time through deep symbolism.
            The Year (Samvatsara) is the foundation for all food and biological life.
            Regardless of the metaphor used, Time remains the great sustainer of all.
            The flow of time is the manifest form of Prajapati that nourishes us.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 12,
        sanskrit = "मासो वै प्रजापतिस्तस्य कृष्णपक्ष एव रयिः शुक्लः प्राणस्तस्मादेत ऋषयः शुक्ल इष्टं कुर्वन्तीतर इतरस्मिन् ॥ १२ ॥",
        hindi = """
            ऋषि कहते हैं कि संवत्सर के बाद 'मास' (महीना) भी प्रजापति का ही रूप है।
            महीने के दो पक्ष होते हैं—कृष्ण पक्ष और शुक्ल पक्ष।
            कृष्ण पक्ष 'रयि' (पदार्थ/अंधकार) का प्रतीक है जो शांति प्रदान करता है।
            शुक्ल पक्ष 'प्राण' (प्रकाश/चेतना) का प्रतीक है जो सक्रियता देता है।
            इसीलिए ज्ञानी ऋषि शुक्ल पक्ष में शुभ कर्म और यज्ञ संपन्न करते हैं।
            जबकि अन्य लोग कृष्ण पक्ष में अपने पितरों की तृप्ति के कार्य करते हैं।
            समय का यह सूक्ष्म विभाजन भी सृजन की इसी द्वैत शक्ति पर आधारित है।
            प्रकाश और अंधकार का यह क्रम ही सृष्टि के संतुलन को बनाए रखता है।
            जो साधक प्राण की उपासना करता है, वह हमेशा प्रकाश की ओर बढ़ता है।
            यह श्लोक बताता है कि समय का हर क्षण आध्यात्मिक विकास का अवसर है।
        """.trimIndent(),
        english = """
            The Sage states that after the Year, the Month is also a form of Prajapati.
            A month is divided into two halves: the dark and the bright fortnights.
            The dark fortnight (Krishna Paksha) is Rayi, representing rest and matter.
            The bright fortnight (Shukla Paksha) is Prana, representing light and life.
            Therefore, wise seers perform their sacred rituals during the bright half.
            Others, seeking worldly fruits, perform theirs in the dark fortnight.
            This subtle division of time is rooted in the same duality of creation.
            The alternating sequence of light and darkness maintains cosmic balance.
            The seeker of Prana always strives to move towards the light.
            The verse teaches that every phase of time offers a spiritual opportunity.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 13,
        sanskrit = "अहोरात्रो वै प्रजापतिस्तस्याहरेव प्राणो रात्रिरेव रयिः प्राणं वा एते प्रस्कन्दन्ति ये दिवा रत्या संयुज्यन्ते ब्रह्मचर्यमेव तद्यद्रात्रौ रत्या संयुज्यन्ते ॥ १३ ॥",
        hindi = """
            मास के बाद अब दिन और रात भी साक्षात् प्रजापति के ही लघु रूप हैं।
            इसमें 'दिन' को प्राण कहा गया है क्योंकि दिन में चेतना सक्रिय होती है।
            'रात्रि' को रयि कहा गया है क्योंकि रात विश्राम और पदार्थ का समय है।
            जो लोग दिन के समय काम-वासना और भोग में अपनी ऊर्जा नष्ट करते हैं।
            वे अपने भीतर के जीवन-प्राण को व्यर्थ में सुखा देते हैं और कमजोर होते हैं।
            किंतु जो संयम रखते हैं, वे अपनी ऊर्जा को सुरक्षित और ऊर्ध्वगामी बनाते हैं।
            ब्रह्मचर्य का पालन करने वाले लोग रात के समय भी प्राण की रक्षा करते हैं।
            दिन और रात का यह उपयोग ही मनुष्य के चरित्र और स्वास्थ्य को बनाता है।
            यह श्लोक दैनिक जीवन में ऊर्जा के संरक्षण (Conservation) की शिक्षा देता है।
            प्राण ही वह पूंजी है जिसे हमें संभलकर खर्च करना चाहिए।
        """.trimIndent(),
        english = """
            Descending from the month, Day and Night are also forms of Prajapati.
            'Day' is identified as Prana, the time when consciousness is active.
            'Night' is identified as Rayi, the period of rest, darkness, and matter.
            Those who dissipate their energy in sensual pleasures during the day.
            They effectively dry up their inner life-force and weaken themselves.
            However, those who practice self-control preserve their vital energy.
            Observing celibacy and discipline is a way of protecting one's Prana.
            The way one utilizes day and night determines their character and health.
            This verse teaches the conservation of vital energy in daily living.
            Prana is the precious capital that must be spent with great wisdom.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 14,
        sanskrit = "अन्नं वै प्रजापतिस्ततो ह वै तद्रेतस्तस्मादिमाः प्रजाः प्रजायन्त इति ॥ १४ ॥",
        hindi = """
            अब ऋषि सृष्टि के भौतिक आधार 'अन्न' की महत्ता को स्पष्ट करते हैं।
            अन्न ही साक्षात् प्रजापति है क्योंकि इसी से जीवन का पोषण होता है।
            अन्न के पाचन से शरीर के भीतर 'रेतस' यानी वीर्य या बीज उत्पन्न होता है।
            उसी बीज से संसार की ये समस्त प्रजाएं और जीव जन्म लेते हैं।
            बिना भोजन के न तो शरीर रह सकता है और न ही प्रजनन संभव है।
            अन्न ही वह कड़ी है जो जड़ पदार्थ को जीवित कोशिका में बदल देती है।
            यह श्लोक सृष्टि की निरंतरता के जैविक रहस्य को उजागर करता है।
            इसीलिए उपनिषदों में 'अन्नं ब्रह्म' (अन्न ही ब्रह्म है) कहा गया है।
            हम जो खाते हैं, वही हमारी चेतना और भविष्य की पीढ़ियों को बनाता है।
            भोजन केवल पेट भरने के लिए नहीं, बल्कि सृष्टि के विस्तार का माध्यम है।
        """.trimIndent(),
        english = """
            The Sage now explains the significance of 'Food' as a physical base.
            Food is indeed Prajapati, as it is the direct sustainer of all life.
            From the digestion of food, the vital 'Seed' (Retas) is produced.
            From that seed, all these various species of creatures are born.
            Without food, neither the body can survive nor procreation is possible.
            Food is the crucial link that transforms inert matter into living cells.
            This verse unveils the biological secret behind the continuity of life.
            This is why Upanishads declare 'Annam Brahma' (Food is Brahman).
            What we consume determines our consciousness and future generations.
            Food is not just for survival but the medium for cosmic expansion.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 15,
        sanskrit = "तद्ये ह वै तत्प्रजापतिव्रतं चरन्ति ते मिथुनमुत्पादयन्ते । तेषामेवैष ब्रह्मलोको येषां तपो ब्रह्मचर्यं येषु सत्यं प्रतिष्ठितम् ॥ १५ ॥",
        hindi = """
            जो लोग प्रजापति के इस नियम (प्रजनन के व्रत) का श्रद्धा से पालन करते हैं।
            वे अपनी संतति के रूप में एक नया जोड़ा (पुत्र-पुत्री) उत्पन्न करते हैं।
            यह गृहस्थ धर्म का पालन करना भी ईश्वर की सेवा का एक मार्ग है।
            किंतु जो साधक केवल शारीरिक सुख से ऊपर उठकर ब्रह्मलोक चाहते हैं।
            उनके लिए तप, ब्रह्मचर्य और सत्य का मार्ग ही एकमात्र विकल्प है।
            ब्रह्मलोक उन्हीं को मिलता है जो अपनी इंद्रियों को वश में कर लेते हैं।
            वे अपनी ऊर्जा को संतानों की जगह ज्ञान के अर्जन में लगाने हैं।
            यहाँ दो अलग-अलग जीवन शैलियों के परिणामों की तुलना की गई है।
            संतति का मार्ग रयि का मार्ग है, और ज्ञान का मार्ग प्राण का मार्ग है।
            सृष्टि के विस्तार के लिए दोनों ही मार्गों का अपना-अपना महत्व है।
        """.trimIndent(),
        english = """
            Those who faithfully observe the rule of Prajapati (vow of procreation).
            They produce offspring, continuing the chain of life through a pair.
            Fulfilling domestic duties is also seen as a form of cosmic service.
            However, those seekers who desire the higher world of Brahman.
            For them, the path of austerity, celibacy, and truth is mandatory.
            The world of Brahman belongs only to those who have mastered senses.
            They direct their vital energies towards wisdom rather than biology.
            This verse compares the outcomes of two different lifestyles.
            The path of progeny is the path of Rayi, and wisdom is the path of Prana.
            Both paths have their own unique roles in the maintenance of creation.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 16,
        sanskrit = "तेषामसौ विरजो ब्रह्मलोको न येषु जिह्ममनृतं न माया चेति ॥ १६ ॥",
        hindi = """
            वह निर्मल और प्रकाशमय ब्रह्मलोक केवल उन्हीं श्रेष्ठ आत्माओं को मिलता है।
            जिनके मन और वाणी में किसी भी प्रकार की कुटिलता या टेढ़ापन नहीं है।
            जो सत्य पर अडिग रहते हैं और कभी भी झूठ का सहारा नहीं लेते।
            जिनके भीतर कोई माया, कपट या दूसरों को धोखा देने की प्रवृत्ति नहीं है।
            आंतरिक पवित्रता ही उस परम सत्य के द्वार तक पहुँचने की एकमात्र कुंजी है।
            बिना चरित्र की शुद्धता के, ज्ञान केवल एक मानसिक बोझ बनकर रह जाता है।
            यह श्लोक नैतिक मूल्यों को आध्यात्मिक विकास की अनिवार्य शर्त बनाता है।
            सत्य और सरलता ही साधक को दिव्य प्रकाश के योग्य बनाती हैं।
            जो भीतर से साफ हैं, वही उस 'विरज' (रजोगुण रहित) लोक में जा सकते हैं।
            यहाँ प्रथम प्रश्न का उत्तर समाप्त होता है और मोक्ष का आधार स्पष्ट होता है।
        """.trimIndent(),
        english = """
            That stainless and luminous world of Brahman belongs only to those.
            In whom there is no crookedness or deceit in mind or speech.
            Those who stand firm in Truth and never resort to any falsehood.
            Those who are free from 'Maya'—guile, hypocrisy, or cheating others.
            Inner purity is the only key to entering the portal of absolute Truth.
            Without moral integrity, knowledge remains merely a mental burden.
            This verse makes ethical values a prerequisite for spiritual growth.
            Truthfulness and simplicity make a seeker worthy of divine light.
            Only those who are pure within can enter the 'Viraja' (passionless) world.
            This marks the conclusion of the first Prashna and defines liberation.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 17,
        sanskrit = "अथ हैनं भार्गवो वैदर्भिः पप्रच्छ । भगवन् कत्येव देवाः प्रजां विधारयन्ते कतर एतत्प्रकाशयन्ते कः पुनरेषां वरिष्ठ इति ॥ १७ ॥",
        hindi = """
            अब द्वितीय प्रश्न प्रारंभ होता है, जिसे विदर्भ के भार्गव ने पूछा है।
            उनका प्रश्न शरीर के भीतर कार्य करने वाली शक्तियों के बारे में है।
            उन्होंने पूछा: 'हे भगवन्! कुल कितने देवता (शक्तियाँ) इस शरीर को थामते हैं?'
            'उनमें से कौन-कौन सी शक्तियां इस शरीर के कार्यों को प्रकाशित करती हैं?'
            'और इन सभी शक्तियों या देवताओं में सबसे श्रेष्ठ और महान कौन है?'
            भार्गव यह जानना चाहते थे कि हमारे अस्तित्व का असली इंजन कौन सा है।
            क्या वह आँखें हैं, कान हैं, मन है या कोई और अज्ञात शक्ति है।
            यह प्रश्न मानव शरीर विज्ञान और चेतना के संबंध की गहराई में जाता है।
            हमारा शरीर एक जटिल मशीन की तरह है जिसे चलाने वाले कई ऑपरेटर हैं।
            ऋषि पिप्पलाद अब इन शक्तियों के पदानुक्रम (Hierarchy) को समझाएंगे।
        """.trimIndent(),
        english = """
            The second question begins now, asked by Bhargava of Vidarbha.
            His inquiry focuses on the powers operating within the human body.
            He asked: 'Venerable Sir, how many powers support this creature?'
            'Which among them enlighten the functions of this biological form?'
            'And among all these powers or deities, who is the most supreme?'
            Bhargava sought to identify the real engine of our personal existence.
            Is it the eyes, the ears, the mind, or some other hidden power?
            The question delves deep into human physiology and consciousness.
            The body is like a complex machine with many individual operators.
            Sage Pippalada will now explain the hierarchy of these internal forces.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 18,
        sanskrit = "तस्मै स होवाचाकाशो ह वा एष देवो वायुरग्निरापः पृथिवी वाङ्मनश्चक्षुः श्रोत्रं च । ते प्रकाश्याभिवदन्ति वयमेतद्बाणमवष्टभ्य विधारयामः ॥ १८ ॥",
        hindi = """
            ऋषि पिप्पलाद उत्तर देते हैं कि शरीर को थामने वाले कई मुख्य देवता हैं।
            आकाश, वायु, अग्नि, जल और पृथ्वी—ये पांच महाभूत भौतिक आधार हैं।
            वाणी, मन, आँख और कान—ये इंद्रियां शरीर के कार्यों को प्रकाशित करती हैं।
            इन सभी शक्तियों ने एक बार मिलकर यह अभिमान किया कि वे ही श्रेष्ठ हैं।
            उन्होंने दावा किया कि वे ही इस शरीर रूपी खंभे को मजबूती से धारण करते हैं।
            इंद्रियों को लगा कि उनके बिना शरीर का कोई अर्थ या अस्तित्व नहीं है।
            यह श्लोक भौतिक तत्वों और ज्ञानेंद्रियों की भूमिका को स्पष्ट करता है।
            परंतु यह केवल सतही शक्तियों का वर्णन है, असली शक्ति अभी गुप्त है।
            मनुष्य अक्सर अपनी इंद्रियों की क्षमता पर ही गर्व करने लगता है।
            ऋषि यहाँ एक रोचक कथा के माध्यम से सत्य की परतें खोलने वाले हैं।
        """.trimIndent(),
        english = """
            Sage Pippalada explains that several powers support the living body.
            Space, Air, Fire, Water, and Earth are the five physical foundations.
            Speech, Mind, Eye, and Ear are the senses that enlighten its functions.
            These powers once collectively claimed that they were the supreme.
            They asserted that they alone held this pillar of the body together.
            The senses believed that without them, the body had no meaning.
            This verse identifies the role of physical elements and sense organs.
            However, this is only a description of the surface-level forces.
            Humans often take pride in the capabilities of their physical senses.
            The Sage is about to unveil the deeper truth through a fascinating story.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 19,
        sanskrit = "तान्वरिष्ठः प्राण उवाच मा मोहमापद्यथाऽहमेवैतत्पञ्चधात्मानं प्रविभज्यैतद्बाणमवष्टभ्य विधारयामीति तेऽश्रद्दधाना बभूवुः ॥ १९ ॥",
        hindi = """
            तब उन सबके बीच में सबसे श्रेष्ठ 'प्राण' ने प्रकट होकर उनसे बात की।
            प्राण ने कहा: 'तुम लोग इस मोह में मत पड़ो कि तुम शरीर को थामते हो।'
            'मैं ही हूँ जो अपने आप को पांच रूपों (प्राण, अपान, व्यान, उदान, समान) में बांटता हूँ।'
            'मैं ही इस शरीर रूपी धनुष को सहारा देकर इसे गिरने से बचाए रखता हूँ।'
            किंतु अन्य देवताओं और इंद्रियों को प्राण की इस बात पर विश्वास नहीं हुआ।
            उन्हें लगा कि प्राण भी उनकी तरह ही एक साधारण शक्ति है, कुछ विशेष नहीं।
            अहंकार के कारण वे सत्य को देख पाने में पूरी तरह असमर्थ रहे।
            यह श्लोक बताता है कि जीवन की मुख्य धारा (प्राण) अक्सर अदृश्य रहती है।
            हम शरीर के बाहरी अंगों को देखते हैं, पर उस ऊर्जा को नहीं जो उन्हें चलाती है।
            प्राण की चुनौती ने अब एक बड़ी परीक्षा की स्थिति उत्पन्न कर दी थी।
        """.trimIndent(),
        english = """
            Then the 'Prana', the chief among them, spoke out to the other powers.
            Prana said: 'Do not fall into the delusion that you support the body.'
            'It is I alone, who dividing myself fivefold, keeps this body alive.'
            'I am the one holding this bow (body) together and preventing its fall.'
            But the other deities and senses remained incredulous of his claim.
            They thought Prana was just an ordinary force like them, nothing more.
            Due to their ego, they were completely unable to see the ultimate Truth.
            The verse shows that the main current of life often remains invisible.
            We see the external organs but miss the energy that fuels them.
            Prana's challenge created a situation for a great cosmic demonstration.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 20,
        sanskrit = "सोऽभिमानादूर्ध्वमुत्क्रमत इव तस्मिन्नुत्क्रामत्यथेतरे सर्व एवोत्क्रामन्ते तस्मिंश्च प्रतिष्ठमाने सर्व एव प्रातिष्ठन्ते ॥ २० ॥",
        hindi = """
            अपनी बात सिद्ध करने के लिए प्राण ने एक अद्भुत क्रिया करने का मन बनाया।
            वह अभिमान के साथ शरीर से ऊपर की ओर उठने लगा (जैसे वह निकल रहा हो)।
            जैसे ही प्राण ने निकलने की कोशिश की, अन्य सभी इंद्रियां भी खिंचने लगीं।
            आँख, कान और मन—सब अपनी जगह छोड़ने को मजबूर हो गए और बाहर आने लगे।
            जब प्राण वापस अपने स्थान पर शांत होकर बैठ गया, तो सब वापस बैठ गए।
            जैसे राजा के चलने पर पूरी सेना चलती है और उसके रुकने पर सब रुक जाते हैं।
            यह देखकर इंद्रियों का भ्रम टूट गया और उन्हें अपनी असलियत समझ आ गई।
            वे समझ गए कि प्राण ही वह बिजली है जिससे उनके यंत्र काम करते हैं।
            बिना प्राण के, आँख देख नहीं सकती और मन सोच नहीं सकता।
            यह श्लोक प्राण की पूर्ण और निर्विवाद सर्वोच्चता को प्रमाणित करता है।
        """.trimIndent(),
        english = """
            To prove his point, Prana decided to perform a dramatic demonstration.
            He made a move to ascend and depart from the physical body.
            As soon as Prana started to leave, all other senses were pulled along.
            The eyes, ears, and mind—all found themselves forced to depart too.
            When Prana settled back into his original place, they all settled back.
            Like a king whose movement dictates the movement of the entire army.
            Seeing this, the delusion of the senses was instantly shattered.
            They realized that Prana is the electricity that powers their machines.
            Without Prana, the eye cannot see and the mind cannot think at all.
            This verse proves the absolute and undeniable supremacy of Prana.
        """.trimIndent()
    ),
    // ... Continuing prashnaShlokasList from ID 21

    PrashnaShloka(
        id = 21,
        sanskrit = "तद्यथा मक्षिका मधुकरराजानमुत्क्रामन्तं सर्वा एवोत्क्रामन्ते तस्मिंश्च प्रतिष्ठमाने सर्वा एव प्रातिष्ठन्त एवं वाङ्मनश्चक्षुः श्रोत्रं च ते प्रीताः प्राणं स्तुन्वन्ति ॥ २१ ॥",
        hindi = """
            जिस प्रकार मधुमक्खियाँ अपने राजा (रानी मक्खी) के उड़ने पर उसके पीछे-पीछे उड़ने लगती हैं,
            और उसके बैठ जाने पर वे भी बैठ जाती हैं, ठीक उसी प्रकार वाणी, मन, आँख और कान भी व्यवहार करते हैं।
            जब उन्हें समझ आया कि प्राण ही मुख्य शक्ति है, तब वे संतुष्ट होकर प्राण की स्तुति करने लगे।
            वे समझ गए कि प्राण ही शरीर का आधार है और उसके बिना इंद्रियाँ कुछ भी नहीं हैं।
            प्राण ही वह अदृश्य धागा है जो शरीर की सभी भौतिक और मानसिक गतिविधियों को जोड़े रखता है।
            इंद्रियों ने स्वीकार किया कि उनकी शक्ति स्वतंत्र नहीं है बल्कि प्राण से ही आती है।
            यह श्लोक शरीर के भीतर की एकता और प्राण की सर्वोच्चता को रेखांकित करता है।
            मधुमक्खियों का उदाहरण जैविक निर्भरता को समझाने के लिए बहुत ही सुंदर और सरल है।
            प्राण के निकलने पर इंद्रियों का निकलना अनिवार्य है, जैसे राजा के बिना सेना का कोई अस्तित्व नहीं।
            अंततः, इंद्रियों का अहंकार नष्ट हुआ और उन्होंने जीवनदायी प्राण की महिमा का गान किया।
        """.trimIndent(),
        english = """
            Just as bees all fly up when the king-bee flies up and all settle down when he settles down,
            so do speech, mind, eye, and ear follow the lead of the primary Life-force (Prana).
            Recognizing their dependence, the senses became delighted and began to praise Prana.
            They understood that without the vital breath, no physical or mental organ can function.
            Prana is the invisible thread that binds all physiological and psychological activities together.
            The senses acknowledged that their power is not autonomous but derived from Prana.
            This verse highlights the internal unity of the body and the absolute supremacy of life-force.
            The metaphor of the bees beautifully illustrates the concept of biological interdependency.
            When Prana departs, the senses must depart, just as an army has no role without a leader.
            Ultimately, the ego of the senses vanished, and they sang in glory of the life-sustaining Prana.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 22,
        sanskrit = "एषोऽग्निस्तपत्येष सूर्य एष पर्जन्यो मघवानेष वायुरेष पृथिवी रयिर्देवः सदसच्चामृतं च यत् ॥ २२ ॥",
        hindi = """
            यही प्राण अग्नि बनकर तपता है, यही सूर्य बनकर प्रकाश फैलाता है और यही वर्षा (पर्जन्य) है।
            यही देवराज इंद्र है, यही वायु है, यही पृथ्वी है और यही दिव्य रयि (पदार्थ) है।
            जो कुछ भी सत् (प्रकट/स्थूल) है और असत् (अप्रकट/सूक्ष्म) है, वह सब भी यही प्राण ही है।
            यहाँ तक कि अमृतत्व का आधार भी इसी प्राण शक्ति में निहित है।
            प्राण ही ब्रह्मांड की सभी भौतिक शक्तियों का मूल चालक और ऊर्जा स्रोत है।
            सूर्य की गर्मी हो या बादलों से बरसता पानी, सब प्राण के ही अलग-अलग रूपांतरण हैं।
            यह श्लोक प्राण को केवल व्यक्तिगत नहीं बल्कि ब्रह्मांडीय (Cosmic) शक्ति सिद्ध करता है।
            प्राण ही वह कड़ी है जो तत्वमीमांसा (Metaphysics) को भौतिक विज्ञान से जोड़ती है।
            संपूर्ण जगत प्राण की ही एक जीवंत अभिव्यक्ति है, जो हर कण में स्पंदित हो रही है।
            प्राण के बिना देवता भी शक्तिहीन हैं, क्योंकि वही उनकी क्रियाशीलता का असली कारण है।
        """.trimIndent(),
        english = """
            This Prana burns as Fire, He is the Sun, He is the cloud (Parjanya), and He is Indra.
            He is the Wind, He is the Earth, and He is the divine Matter (Rayi).
            All that is manifest (Sat) and all that is unmanifest (Asat) is essentially Prana.
            Even that which is immortal is anchored within this supreme Life-force.
            Prana is the primary driver and energy source for all cosmic and physical forces.
            The heat of the sun or the rain from the clouds are various transformations of Prana.
            This verse proves that Prana is not just personal but a universal, cosmic entity.
            It serves as the bridge that connects metaphysical truths with physical sciences.
            The entire universe is a living manifestation of Prana, vibrating in every particle.
            Even the deities are powerless without Prana, for He is the true cause of their activity.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 23,
        sanskrit = "अरा इव रथनाभौ प्राणे सर्वं प्रतिष्ठितम् । ऋचो यजूंषि सामानि यज्ञः क्षत्रं ब्रह्म च ॥ २३ ॥",
        hindi = """
            जिस प्रकार रथ के पहिये की नाभि (सेंटर) में सभी अरे (तिलियाँ) जुड़ी रहती हैं,
            ठीक उसी प्रकार इस संपूर्ण ब्रह्मांड की वस्तुएँ प्राण में ही प्रतिष्ठित (टिकी) हैं।
            ऋग्वेद की ऋचाएँ, यजुर्वेद के मंत्र और सामवेद के गान—सबका आधार प्राण ही है।
            यज्ञ की शक्ति, क्षत्रियों का बल (रक्षा शक्ति) और ब्राह्मणों का ज्ञान भी प्राण ही है।
            प्राण वह धुरी है जिसके चारों ओर ज्ञान, शक्ति और कर्म का चक्र घूमता है।
            बिना प्राण के वेदों का उच्चारण संभव नहीं और न ही यज्ञ का संपादन हो सकता है।
            यह श्लोक समाज के सांस्कृतिक और आध्यात्मिक स्तंभों को प्राण से जोड़ता है।
            रथ का उदाहरण स्थिरता और गतिशीलता के संतुलन को समझाने के लिए दिया गया है।
            प्राण ही वह केंद्र है जो विविधतापूर्ण संसार को एक सूत्र में बांधे रखता है।
            यदि केंद्र (प्राण) हट जाए, तो ज्ञान और शक्ति की सभी तिलियाँ बिखर जाएँगी।
        """.trimIndent(),
        english = """
            As spokes are fastened in the hub of a chariot wheel, all things are established in Prana.
            The verses of the Rigveda, the mantras of Yajurveda, and the hymns of Samaveda rest in Him.
            The power of sacrifice, the strength of the warriors, and the wisdom of the sages are Prana.
            Prana is the axis around which the wheel of knowledge, power, and action revolves.
            Without Prana, the chanting of Vedas is impossible, nor can any sacrifice be performed.
            This verse links the cultural and spiritual pillars of society directly to Life-force.
            The chariot metaphor is used to explain the balance between stability and dynamism.
            Prana is the central hub that keeps the diverse world integrated into a single unit.
            If the center (Prana) were removed, all spokes of knowledge and power would scatter.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 24,
        sanskrit = "प्रजापतिश्चरसि गर्भे त्वमेव प्रतिजायसे । तुभ्यं प्राण प्रजास्त्विमा बलिं हरन्ति यः प्राणैः प्रतितिष्ठसि ॥ २४ ॥",
        hindi = """
            हे प्राण! तुम ही प्रजापति बनकर गर्भ में विचरण करते हो और तुम ही जन्म लेते हो।
            तुम जो माता-पिता के रूप में हो, वही संतान के रूप में पुनः उत्पन्न होते हो।
            हे प्राण! ये सभी प्रजाएँ (इंद्रियाँ और जीव) तुम्हारे लिए ही उपहार (बलि) लाती हैं।
            क्योंकि तुम ही वह हो जो शरीर की सभी इंद्रियों के साथ उनमें निवास करते हो।
            प्राण ही वह शक्ति है जो अजन्मे को जन्म देती है और जीवन की निरंतरता बनाए रखती है।
            इंद्रियाँ जो कुछ भी अनुभव (भोजन, दृश्य, गंध) करती हैं, वे सब प्राण को ही समर्पित हैं।
            प्राण ही शरीर का असली 'भोक्ता' है, इंद्रियाँ तो केवल माध्यम या द्वार हैं।
            यह श्लोक जीवन के प्रजनन और पोषण की प्रक्रिया को प्राण की महिमा मानता है।
            तुम ही वह पुरातन शक्ति हो जो हर नए जीवन में फिर से ताज़ा होकर प्रकट होती है।
            समस्त जीव जगत अनजाने में ही तुम्हारी सेवा में लगा हुआ है, क्योंकि तुम ही जीवन हो।
        """.trimIndent(),
        english = """
            O Prana! As Prajapati, You move in the womb and it is You who are born again.
            You exist as the parents, and it is You who manifest once more in the form of the child.
            O Prana! All these creatures (and senses) bring offerings or gifts specifically to You.
            For it is You who dwell within the body along with all the various sense-organs.
            Prana is the force that brings the unborn into birth and ensures the continuity of life.
            Everything the senses experience—food, sights, smells—is ultimately offered to Prana.
            Prana is the true 'enjoyer' of the body; the senses are merely channels or gateways.
            This verse views the process of reproduction and nourishment as the glory of Prana.
            You are the ancient power that manifests anew and fresh in every single life form.
            The entire living world is unconsciously serving You, for You are life itself.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 25,
        sanskrit = "देवानामसि वह्नितमः पितृणां प्रथमा स्वधा । ऋषीणां चरितं सत्यमथर्वाङ्गिरसामसि ॥ २५ ॥",
        hindi = """
            हे प्राण! तुम देवताओं के लिए हवि पहुँचाने वाले सबसे श्रेष्ठ अग्नि (वह्नि) हो।
            पितरों के लिए तुम ही प्रथम 'स्वधा' (तृप्तिदायक अन्न) के रूप में विद्यमान हो।
            अथर्वा और अंगिरस ऋषियों के सत्य आचरण और उनकी तपस्या का आधार तुम ही हो।
            तुम ही वह ऊर्जा हो जिसने प्राचीन ऋषियों को ज्ञान और सत्य के दर्शन कराए।
            देवताओं की यज्ञीय शक्ति और पितरों की परलोक में शांति, दोनों तुमसे ही जुड़ी हैं।
            प्राण के बिना न तो देव-कार्य संपन्न हो सकते हैं और न ही पितृ-कार्य सफल होते हैं।
            तुम ही सत्य के खोजी ऋषियों की इंद्रियों की कार्यक्षमता और उनकी एकाग्रता हो।
            ऋषियों का चरित्र और उनका तप तुम्हारे ही संयमित प्रवाह का परिणाम है।
            तुम ही वह आदि शक्ति हो जो वैदिक ज्ञान की धाराओं को प्राणवान बनाए रखती है।
            समस्त आध्यात्मिक परंपराओं का प्राण-तत्व वास्तव में तुम्हारी ही एक झलक है।
        """.trimIndent(),
        english = """
            O Prana! You are the best carrier of offerings (Vahni) to the celestial deities.
            For the ancestors (Pitris), You are the primary 'Svadha' (the satisfying oblation).
            You are the true character and austerity of the sages like Atharva and Angiras.
            You are the energy that enabled ancient seers to realize wisdom and truth.
            The sacrificial power of gods and the peace of ancestors are both tied to You.
            Without Prana, neither divine works can be completed nor ancestral rites succeed.
            You are the functional capacity and the deep concentration of the truth-seeking sages.
            The conduct of the rishis and their penance is the result of Your disciplined flow.
            You are the primordial force that keeps the streams of Vedic knowledge alive and vital.
            The life-essence of all spiritual traditions is, in reality, just a glimpse of You.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 26,
        sanskrit = "इन्द्रस्त्वं प्राण तेजसा रुद्रोऽसि परिरक्षिता । त्वमन्तरिक्षे चरसि सूर्यस्त्वं ज्योतिषां पतिः ॥ २६ ॥",
        hindi = """
            हे प्राण! तुम अपने तेज से स्वयं इंद्र हो और रक्षक के रूप में तुम ही रुद्र (शिव) हो।
            तुम ही अंतरिक्ष में निरंतर संचरण करते हो और तुम ही सूर्यरूप ज्योतिपतियों के स्वामी हो।
            इंद्र की शक्ति के रूप में तुम ही ब्रह्मांड का शासन और संतुलन बनाए रखते हो।
            रुद्र के रूप में तुम ही अवांछित तत्वों का विनाश कर सृष्टि की रक्षा करते हो।
            अंतरिक्ष में व्याप्त वायु और ऊर्जा के रूप में तुम्हारी ही गतिशीलता दिखाई देती है।
            सूर्य के प्रकाश में जो चमक और जीवन देने वाली शक्ति है, वह तुम्हारा ही रूप है।
            तुम ही वह सर्वोच्च राजा हो जिसकी आज्ञा का पालन संपूर्ण सौरमंडल करता है।
            तुम्हारी ही ज्योति से चंद्रमा और नक्षत्र प्रकाशित होकर अपनी मर्यादा में रहते हैं।
            तुम विनाशक भी हो और रक्षक भी, क्योंकि जीवन और मृत्यु दोनों तुम्हारे खेल हैं।
            इस श्लोक में प्राण को शिव (रुद्र) और इंद्र के समान पूजनीय और शक्तिशाली बताया गया है।
        """.trimIndent(),
        english = """
            O Prana! You are Indra by Your brilliance, and as a protector, You are Rudra (Shiva).
            You move perpetually in the intermediate space, and You are the Sun, the Lord of lights.
            As the power of Indra, You maintain the governance and balance of the entire universe.
            As Rudra, You protect the creation by destroying the unwanted or decaying elements.
            In the form of wind and energy pervading space, Your dynamism is clearly visible.
            The brilliance and life-giving power within the sunlight is a manifestation of You.
            You are the supreme sovereign whose commands are followed by the entire solar system.
            It is by Your light that the moon and stars are illuminated and stay within their bounds.
            You are both the destroyer and the savior, for life and death are both Your play.
            In this verse, Prana is worshiped as being as powerful and venerable as Shiva and Indra.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 27,
        sanskrit = "यदा त्वमभिवर्षस्यथेमाः प्राण ते प्रजाः । आनन्दरूपास्तिष्ठन्ति काम्यान्नं भविष्यतीति ॥ २७ ॥",
        hindi = """
            हे प्राण! जब तुम बादलों के रूप में बरसते हो, तब तुम्हारी ये सभी प्रजाएँ प्रसन्न होती हैं।
            वे आनंदित होकर इस आशा में रहती हैं कि अब उनकी इच्छा के अनुसार प्रचुर अन्न होगा।
            वर्षा प्राण का ही एक रूप है जो धरती की प्यास बुझाकर उसे हरा-भरा बनाती है।
            अन्न की उत्पत्ति से ही जीवन चक्र चलता है, और अन्न का मूल कारण वर्षा ही है।
            जब बारिश होती है, तो पशु-पक्षी और मनुष्य—सबमें एक नई ऊर्जा और हर्ष छा जाता है।
            यह आनंद केवल भौतिक नहीं, बल्कि प्राण शक्ति के पुनः संचरण का एक उत्सव है।
            प्राण के बिना बादल नहीं उमड़ते और बिना बादलों के सृष्टि का पोषण नहीं होता।
            प्रजाओं का संतोष तुम्हारी ही कृपा पर निर्भर है, क्योंकि तुम ही भाग्यविधाता हो।
            अन्न होने की संभावना ही जीवन को जीने का उत्साह और भविष्य का भरोसा देती है।
            हे प्राण! तुम्हारी वर्षा ही मरुस्थल को भी नंदनवन में बदलने की सामर्थ्य रखती है।
        """.trimIndent(),
        english = """
            O Prana! When You pour down as rain, then these creatures of Yours are delighted.
            They remain in a blissful state, hoping that there will be abundant food for their desire.
            Rain is a manifestation of Prana that quenches the earth's thirst and makes it green.
            The cycle of life runs on the production of food, and rain is the root cause of food.
            When it rains, animals, birds, and humans—all are filled with a new energy and joy.
            This bliss is not just physical but a celebration of the re-circulation of life-force.
            Without Prana, clouds do not form, and without clouds, the creation isn't nourished.
            The satisfaction of all beings depends on Your grace, for You are the ordainer of fate.
            The prospect of having food gives life the enthusiasm to live and trust in the future.
            O Prana! Your rain has the power to transform even a desert into a celestial garden.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 28,
        sanskrit = "व्रात्यस्त्वं प्राणैकर्षिरत्ता विश्वस्य सत्पतिः । वयमाद्यस्य दातारः पिता त्वं मातरिश्व नः ॥ २८ ॥",
        hindi = """
            हे प्राण! तुम 'व्रात्य' (संस्कारों से परे/स्वयंभू) हो, तुम 'एकर्षि' (अथर्ववेद की अग्नि) हो।
            तुम ही संपूर्ण विश्व के भोक्ता (अत्ता) और सबके सच्चे स्वामी (सत्पति) हो।
            हम तुम्हें भोजन (आहुति) देने वाले हैं, और तुम हमारे लिए प्राण-वायु (मातरिश्वा) के पिता हो।
            'व्रात्य' होने का अर्थ है कि तुम्हें किसी बाहरी संस्कार की आवश्यकता नहीं, तुम शुद्ध हो।
            तुम ही वह अग्नि हो जो शरीर में भोजन को पचाती है और जगत में अशुद्धि को जलाती है।
            हम जो कुछ भी खाते हैं, वह वास्तव में तुम्हारी ही सेवा में समर्पित एक भेंट है।
            तुम ही वायु को गति देते हो, इसीलिए तुम समस्त वायुमंडल के जनक माने जाते हो।
            तुम्हारी ही उपस्थिति हमें 'जीवित' होने का गौरव और पहचान प्रदान करती है।
            तुम आदि-गुरु और आदि-पिता हो, जिससे संपूर्ण चेतना का विस्तार हुआ है।
            यह श्लोक प्राण की स्वाभाविकता, शुद्धता और पालनकर्ता के रूप को नमन करता है।
        """.trimIndent(),
        english = """
            O Prana! You are 'Vratya' (the self-purified one), You are 'Ekarshi' (the sacred fire).
            You are the consumer (Atta) of the entire universe and the true Lord of all (Satpati).
            We are the givers of food (offerings) to You, and You are our father, O Matarishva.
            Being 'Vratya' means You require no external purification rituals; You are pure by nature.
            You are the fire that digests food in the body and burns away impurities in the world.
            Everything we consume is, in reality, an offering dedicated to Your service.
            You give motion to the wind; hence You are considered the progenitor of the atmosphere.
            It is Your presence alone that grants us the pride and identity of being 'alive'.
            You are the primordial Guru and Father from whom all consciousness has expanded.
            This verse salutes the natural purity, the consuming power, and the fatherly role of Prana.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 29,
        sanskrit = "या ते तनूर्वाचि प्रतिष्ठिता या श्रोत्रे या च चक्षुषि । या च मनसि सन्तता शिवां तां कुरु मोत्क्रमीः ॥ २९ ॥",
        hindi = """
            हे प्राण! तुम्हारा जो रूप हमारी वाणी में स्थित है, जो कानों और आँखों में व्याप्त है,
            और जो मन में निरंतर फैला हुआ है, उसे तुम हमारे लिए कल्याणकारी (शिव) बनाओ।
            हे प्राण! तुम हमें छोड़कर बाहर मत निकलो (उत्क्रमी), क्योंकि तुम्हारे बिना हम शव हैं।
            वाणी तभी सार्थक है जब उसमें प्राण की शक्ति हो, अन्यथा शब्द निर्जीव हैं।
            आँखें तभी देख सकती हैं और कान तभी सुन सकते हैं जब तुम उनमें सक्रिय हो।
            मन की सोच और कल्पनाओं का आधार भी तुम्हारी ही निरंतर उपस्थिति है।
            हम प्रार्थना करते हैं कि हमारी इंद्रियां तुम्हारे प्रभाव से शुभ और मंगलकारी कार्य करें।
            तुम्हारी कृपा से ही हमारी वाणी मधुर और हमारी दृष्टि पवित्र बनी रह सकती है।
            तुम्हारे रहने से ही शरीर का सौंदर्य और उसकी सार्थकता बनी रहती है।
            यह श्लोक प्राण से शरीर के भीतर बने रहने और इंद्रियों को दिव्य बनाने की प्रार्थना है।
        """.trimIndent(),
        english = """
            O Prana! That form of Yours which is established in speech, in hearing, and in sight,
            and that which is continuously extended in the mind—make that auspicious (Shiva) for us.
            O Prana! Do not depart (Utkramih) from us, for without You, we are but a corpse.
            Speech is meaningful only when empowered by Prana; otherwise, words are lifeless.
            The eyes can see and the ears can hear only when You are active within them.
            The very foundation of the mind's thoughts and imagination is Your constant presence.
            We pray that our senses perform noble and auspicious deeds under Your influence.
            It is only by Your grace that our speech remains sweet and our vision stays pure.
            Your indwelling presence maintains the beauty and the purpose of the physical body.
            This verse is a prayer to Prana to stay within the body and divinize the senses.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 30,
        sanskrit = "प्राणस्येदं वशे सर्वं त्रिदिवे यत्प्रतिष्ठितम् । मातेव पुत्रान् रक्षस्व श्रीश्च प्रज्ञां च विधेहि न इति ॥ ३० ॥",
        hindi = """
            इस जगत में और तीनों लोकों (स्वर्ग, पृथ्वी, पाताल) में जो कुछ भी है, सब प्राण के वश में है।
            हे प्राण! तुम हमारी वैसे ही रक्षा करो जैसे एक माता अपने पुत्रों की रक्षा करती है।
            हमें श्री (समृद्धि/लक्ष्मी) और प्रज्ञा (बुद्धि/सरस्वती) प्रदान करो, यही हमारी विनती है।
            प्राण ही वह सर्वोच्च शक्ति है जिसकी सत्ता से पूरा ब्रह्मांड अनुशासित रहता है।
            जैसे माता संतान के दोषों को क्षमा कर उसे पालती है, वैसे ही तुम हमें संभालो।
            बिना प्राण के न तो धन (श्री) का सुख मिल सकता है और न ही ज्ञान (प्रज्ञा) का लाभ।
            स्वास्थ्य और बुद्धि दोनों का मूल स्रोत प्राण की शुद्धता और उसका संतुलन ही है।
            यह श्लोक दूसरे प्रश्न का समापन है, जहाँ प्राण की सर्वोपरिता को पूरी तरह स्वीकार किया गया है।
            सृष्टि की हर हलचल तुम्हारी ही अनुमति से होती है, तुम ही परम नियंता हो।
            हमें भौतिक ऐश्वर्य और आध्यात्मिक बोध दोनों देकर कृतार्थ करो, हे महान प्राण!
        """.trimIndent(),
        english = """
            All that exists in this world and in the three heavens is under the control of Prana.
            O Prana! Protect us just as a mother protects her sons from all harm.
            Grant us 'Shri' (prosperity) and 'Prajna' (wisdom); this is our humble petition.
            Prana is the supreme force whose authority keeps the entire universe disciplined.
            Just as a mother nurtures a child despite their flaws, You must sustain and guide us.
            Without Prana, one can neither enjoy wealth (Shri) nor benefit from knowledge (Prajna).
            The root source of both health and intellect is the purity and balance of Prana.
            This verse concludes the second question, fully accepting the supremacy of Prana.
            Every movement in creation happens by Your permission; You are the ultimate controller.
            Bless us with both material abundance and spiritual insight, O magnificent Prana!
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 31,
        sanskrit = "अथ हैनं कौसल्यश्चाश्वलायनः पप्रच्छ । भगवन् कुत एष प्राणो जायते कथमायात्यस्मिञ्छरीर आत्मानं वा प्रविभज्य कथं प्रातिष्ठते केनोत्क्रमते कथं बाह्यमभिधत्ते कथमध्यात्ममिति ॥ ३१ ॥",
        hindi = """
            अब तृतीय प्रश्न प्रारंभ होता है, जिसे अश्वलायन के पुत्र कौसल्य ने पूछा है।
            उनका प्रश्न प्राण की उत्पत्ति और उसके कार्य करने के गुप्त रहस्यों के बारे में है।
            उन्होंने पूछा: 'हे भगवन्! यह प्राण स्वयं कहाँ से उत्पन्न होता है (इसका स्रोत क्या है)?'
            'यह इस मानव शरीर में किस प्रकार प्रवेश करता है और यहाँ कैसे आता है?'
            'यह अपने आप को विभाजित करके शरीर के विभिन्न अंगों में कैसे स्थित होता है?'
            'यह मृत्यु के समय शरीर के किस मार्ग से बाहर निकलता है (उत्क्रमण)?'
            'यह बाहरी जगत (ब्रह्मांड) और आंतरिक शरीर (अध्यात्म) को कैसे धारण करता है?'
            कौसल्य प्राण की संरचना और उसके वितरण (Distribution) की सूक्ष्मता जानना चाहते थे।
            यह प्रश्न अत्यंत वैज्ञानिक है जो शरीर क्रिया विज्ञान (Physiology) की गहराई छूता है।
            ऋषि पिप्पलाद अब प्राण के सूक्ष्म विभाजन और उसके प्रबंधन (Management) को समझाएंगे।
        """.trimIndent(),
        english = """
            The third question begins now, asked by Kausalya, the son of Ashvala.
            His inquiry is about the origin of Prana and the hidden secrets of its functioning.
            He asked: 'Venerable Sir, from where is this Prana born (what is its source)?'
            'How does it enter this human body and by what means does it come here?'
            'How does it divide itself and establish itself in different parts of the body?'
            'By which route does it depart from the body at the time of death?'
            'How does it support the external world (Adhibhuta) and the internal self (Adhyatma)?'
            Kausalya wanted to know the subtlety of Prana's structure and its distribution.
            This is a highly scientific query that touches the depths of spiritual physiology.
            Sage Pippalada will now explain the subtle division and management of Prana.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 32,
        sanskrit = "तस्मै स होवाचातिप्रश्नान् पृच्छसि ब्रह्मिष्ठोऽसीति तस्मात्तेऽहं ब्रवीमि ॥ ३२ ॥",
        hindi = """
            महर्षि पिप्पलाद ने उत्तर दिया: 'तुम बहुत ही कठिन और गहरे प्रश्न (अतिप्रश्न) पूछ रहे हो।'
            'चूँकि तुम ब्रह्म-निष्ठ हो और सत्य को जानने के सच्चे अधिकारी हो, इसलिए मैं तुम्हें बताता हूँ।'
            प्राण के रहस्यों को जानना साधारण बुद्धि के बस की बात नहीं है, यह अत्यंत सूक्ष्म विषय है।
            ऋषि शिष्य की पात्रता की प्रशंसा करते हैं क्योंकि ऐसे प्रश्न केवल तीव्र जिज्ञासु ही पूछ सकता है।
            ज्ञान तभी दिया जाना चाहिए जब लेने वाला उसे समझने और संभालने में समर्थ हो।
            पिप्पलाद की यह स्वीकारोक्ति दर्शाती है कि कौसल्य ने अपनी साधना से उच्च स्तर प्राप्त कर लिया था।
            सत्य के खोजी को कठिन प्रश्नों से घबराना नहीं चाहिए, बल्कि गुरु की शरण लेनी चाहिए।
            ब्रह्म-निष्ठा ही वह योग्यता है जो गंभीर रहस्यों के ताले खोलने की चाबी बनती है।
            अब ऋषि प्राण के जन्म और उसके शरीर में आने की प्रक्रिया का खुलासा करने वाले हैं।
            यह संवाद गुरु और शिष्य के बीच के उच्चतम बौद्धिक और आध्यात्मिक स्तर को दर्शाता है।
        """.trimIndent(),
        english = """
            Sage Pippalada replied: 'You are asking very difficult and deep questions (Atiprashnan).'
            'Because you are firmly devoted to Brahman and a true seeker, I shall tell you.'
            Understanding the secrets of Prana is not for the ordinary mind; it is a subtle subject.
            The Sage praises the student's eligibility because only a keen seeker asks such things.
            Wisdom should be shared only when the receiver is capable of grasping and holding it.
            Pippalada's acknowledgement shows that Kausalya had reached a high level through his practice.
            A seeker of Truth should not fear tough questions but should seek refuge in a Master.
            Devotion to Brahman is the qualification that serves as the key to unlocking deep secrets.
            The Sage is now about to reveal the birth of Prana and its entry into the body.
            This dialogue represents the highest intellectual and spiritual level between Guru and disciple.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 33,
        sanskrit = "आत्मन एष प्राणो जायते । यथैषा पुरुषे छायैतस्मिन्नेतदाततं मनोकृतेनायात्यस्मिञ्छरीरे ॥ ३३ ॥",
        hindi = """
            यह प्राण स्वयं 'आत्मा' (परमात्मा) से उत्पन्न होता है, यही इसका असली जन्मस्थान है।
            जिस प्रकार मनुष्य के शरीर के साथ उसकी परछाई (छाया) हमेशा जुड़ी रहती है,
            वैसे ही यह प्राण भी उस परम आत्मा के साथ पूरी तरह से व्याप्त और जुड़ा हुआ है।
            यह मन के संकल्पों और पिछले कर्मों के कारण इस शरीर में प्रवेश करता है।
            आत्मा सूर्य की तरह है और प्राण उसकी किरणों या परछाई की तरह उसका विस्तार है।
            जैसे परछाई का स्वतंत्र अस्तित्व नहीं होता, वैसे ही प्राण आत्मा के बिना कुछ भी नहीं है।
            मनुष्य की इच्छाएं और वासनाएं ही प्राण को एक नए शरीर की ओर खींचकर लाती हैं।
            शरीर में प्राण का आना कोई दुर्घटना नहीं, बल्कि एक आध्यात्मिक और मानसिक प्रक्रिया है।
            प्राण ही वह माध्यम है जिससे आत्मा भौतिक जगत का अनुभव करने के लिए शरीर धारण करती है।
            यह श्लोक अद्वैत (एकता) के सिद्धांत को पुष्ट करता है—प्राण और आत्मा अलग नहीं हैं।
        """.trimIndent(),
        english = """
            This Prana is born of the Self (Atman); that is its true birthplace and origin.
            Just as a shadow is always associated with the person to whom it belongs,
            so is this Prana completely pervading and associated with the Supreme Self.
            It enters this body because of the activities of the mind and past karmas.
            The Self is like the sun, and Prana is its expansion, like its rays or shadow.
            As a shadow has no independent existence, so Prana is nothing without the Self.
            A person's desires and latent impressions (vasanas) pull Prana toward a new body.
            The entry of Prana into the body is not an accident but a spiritual-mental process.
            Prana is the medium through which the Soul embodies itself to experience the world.
            This verse reinforces the principle of non-duality—Prana and Self are inseparable.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 34,
        sanskrit = "यथा सम्राडेवाधिकृतान्विनियुङ्क्ते । एतान् ग्रामानतेतान् ग्रामानधितिष्ठस्वेत्येवमेवैष प्राण इतरान् प्राणान् पृथक्पृथगेव संनिधत्ते ॥ ३४ ॥",
        hindi = """
            जिस प्रकार एक महान सम्राट अपने अधिकारियों को अलग-अलग क्षेत्रों में नियुक्त करता है,
            वह आदेश देता है: 'तुम इन गाँवों का शासन करो और तुम उन गाँवों की देखभाल करो।'
            ठीक उसी प्रकार, मुख्य प्राण अन्य सहायक प्राणों को शरीर के अलग-अलग अंगों में नियुक्त करता है।
            मुख्य प्राण शरीर का राजा है जो संपूर्ण व्यवस्था का प्रबंधन (Management) करता है।
            वह कार्य की प्रकृति के अनुसार शक्तियों का बंटवारा करता है ताकि शरीर सुचारू रूप से चले।
            पाचन, श्वसन, विसर्जन और रक्त संचार—सबके लिए अलग-अलग 'अधिकारी' तैनात हैं।
            इंद्रियों की कार्यक्षमता मुख्य प्राण की योजना और उसके अनुशासन पर निर्भर करती है।
            यह उदाहरण प्रशासनिक कुशलता और जैविक संगठन (Biological Organization) को दर्शाता है।
            शरीर कोई अव्यवस्थित ढेर नहीं, बल्कि एक सुनियोजित साम्राज्य है जिसका स्वामी प्राण है।
            यह श्लोक शरीर के भीतर की कार्यात्मक विविधता (Functional Diversity) की व्याख्या करता है।
        """.trimIndent(),
        english = """
            Just as a sovereign emperor appoints officials to govern different territories,
            commanding: 'You rule over these villages, and you take charge of those villages.'
            In the same way, the chief Prana appoints other subordinate pranas to different organs.
            The chief Prana is the King of the body who manages the entire biological system.
            He distributes powers according to the nature of the tasks to ensure smooth functioning.
            Digestion, respiration, excretion, and circulation—each has its own 'officials' deployed.
            The efficiency of the senses depends on the plan and discipline of the chief Prana.
            This metaphor illustrates administrative efficiency and biological organization.
            The body is not a chaotic heap but a well-planned empire ruled by Prana.
            This verse explains the functional diversity and decentralization within the body.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 35,
        sanskrit = "पायूपस्थेऽपानं चक्षुःश्रोत्रे मुखनासिकाभ्यां प्राणः स्वयं प्रातिष्ठते मध्ये तु समानः । एष ह्येतद्धुतमन्नं समं नयति तस्मादेताः सप्तार्चिषो भवन्ति ॥ ३५ ॥",
        hindi = """
            अपान वायु को उत्सर्जन अंगों (पायु और उपस्थ) में नियुक्त किया गया है।
            मुख्य प्राण स्वयं आँख, कान, मुख और नासिका के छिद्रों में निवास करता है।
            शरीर के मध्य भाग (नाभि/जठर) में 'समान' नामक वायु प्रतिष्ठित होती है।
            यह समान वायु ही खाए हुए अन्न को शरीर के सभी अंगों में समान रूप से पहुँचाती है।
            अन्न को पचाकर ऊर्जा का वितरण करना 'समान' वायु का मुख्य उत्तरदायित्व है।
            पाचन की इस अग्नि से ही सात प्रकार की लपटें (सप्तार्चिष) या इंद्रियों की शक्तियां उत्पन्न होती हैं।
            मस्तिष्क और इंद्रियों को पोषण इसी मध्यवर्ती वायु के माध्यम से प्राप्त होता है।
            यदि समान वायु भोजन को ठीक से न बांटे, तो शरीर के अन्य अंग भूखे और कमजोर रह जाएंगे।
            यह श्लोक ऊर्जा रूपांतरण (Energy Conversion) और उसके वितरण की प्रक्रिया समझाता है।
            नाभि शरीर का वह केंद्र है जहाँ से जीवन की रसद (Logistics) नियंत्रित होती है।
        """.trimIndent(),
        english = """
            The Apana Vayu is stationed in the organs of excretion and generation.
            The chief Prana dwells in the eyes, ears, mouth, and the nostrils himself.
            In the middle of the body (the navel/digestive region), 'Samana' is established.
            It is this Samana that equally distributes the ingested food to all parts of the body.
            The primary responsibility of Samana is to digest food and distribute the energy.
            From this fire of digestion arise the seven flames (saptarchish) or sensory powers.
            The brain and the sense organs receive their nourishment through this central Vayu.
            If Samana does not distribute the food properly, other organs remain starved and weak.
            This verse explains the process of energy conversion and its strategic distribution.
            The navel is the center of the body from where the logistics of life are controlled.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 36,
        sanskrit = "हृदि ह्येष आत्मा । अत्रैतदेकशतं नाडीनां तासां शतं शतमेकैकस्यां द्वासप्ततिर्द्वासप्ततिः प्रतिशाखानाडीसहस्राणि भवन्त्यासु व्यानश्चरति ॥ ३६ ॥",
        hindi = """
            यह आत्मा हृदय के भीतर निवास करती है, जो चेतना का मुख्य केंद्र है।
            यहाँ से मुख्य १०१ नाड़ियाँ निकलती हैं, जो पूरे शरीर में फैली हुई हैं।
            इनमें से प्रत्येक मुख्य नाड़ी की १००-१०० शाखाएँ (Sub-branches) होती हैं।
            फिर उन शाखाओं की ७२,०००-७२,००० प्रति-शाखाएँ होती हैं, जो अत्यंत सूक्ष्म हैं।
            इन सभी लाखों नाड़ियों में 'व्यान' नामक वायु निरंतर संचरण (Circulate) करती है।
            व्यान वायु ही पूरे शरीर में रक्त और ऊर्जा के संचार का माध्यम बनती है।
            यह शरीर के जोड़-जोड़ और प्रत्येक कोशिका तक पोषण पहुँचाने का कार्य करती है।
            हृदय को एक जंक्शन की तरह बताया गया है जहाँ से जीवन की धाराएँ प्रवाहित होती हैं।
            यह श्लोक प्राचीन काल के सूक्ष्म शरीर विज्ञान (Subtle Anatomy) का अद्भुत प्रमाण है।
            लाखों नाड़ियों का यह जाल ही हमारे संवेगों और शारीरिक गतिशीलता को संभव बनाता है।
        """.trimIndent(),
        english = """
            The Atman dwells within the heart, which is the primary center of consciousness.
            From here, 101 main nadis (energy channels) emerge and spread throughout the body.
            Each of these main nadis has 100 sub-branches extending from it.
            Furthermore, each sub-branch has 72,000 minor channels, which are extremely subtle.
            Within all these millions of channels, the 'Vyana' vayu circulates continuously.
            Vyana acts as the medium for the circulation of blood and energy throughout the body.
            It performs the task of delivering nourishment to every joint and every single cell.
            The heart is depicted as a junction from where the currents of life flow outward.
            This verse is a remarkable testament to the subtle anatomy known in ancient times.
            This network of millions of channels makes our sensations and physical mobility possible.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 37,
        sanskrit = "अथैकयोर्ध्व उदानः पुण्येन पुण्यं लोकं नयति पापेन पापमुभाभ्यामेव मनुष्यलोकम् ॥ ३७ ॥",
        hindi = """
            एक मुख्य नाड़ी (सुषुम्ना) से 'उदान' वायु ऊपर की ओर प्रवाहित होती है।
            यह उदान वायु ही मृत्यु के समय जीवात्मा को उसके कर्मों के अनुसार ले जाती है।
            पुण्य कर्मों के प्रभाव से यह मनुष्य को उच्च या पुण्य लोकों की ओर ले जाती है।
            पाप कर्मों के कारण यह उसे निम्न योनियों या कष्टकारी लोकों में ले जाती है।
            जब पाप और पुण्य दोनों मिश्रित होते हैं, तब यह पुनः मनुष्य लोक में जन्म दिलाती है।
            उदान वायु मृत्यु के समय की 'लिफ्ट' है जो गंतव्य (Destination) तय करती है।
            यह गले के क्षेत्र में स्थित होती है और बोलने तथा निगलने की शक्ति देती है।
            जीवन भर का अभ्यास और अंतिम समय का संकल्प उदान की दिशा तय करता है।
            यह श्लोक कर्म सिद्धांत (Law of Karma) और मृत्यु के बाद की यात्रा को समझाता है।
            हमारी अगली यात्रा का टिकट हमारी वर्तमान आदतों और कर्मों से ही छपता है।
        """.trimIndent(),
        english = """
            Through one main upward channel (Sushumna), 'Udana' vayu flows upward.
            Udana is the force that carries the soul at the time of death according to its deeds.
            By the influence of virtuous deeds, it leads the person toward higher, merit-filled worlds.
            Due to sinful actions, it carries the soul toward lower realms or painful existences.
            When merits and demerits are mixed, it brings the soul back to birth in the human world.
            Udana is the 'elevator' at the time of death that decides the next destination.
            It is located in the throat region and provides the power of speech and swallowing.
            Lifelong practice and the final thought determine the direction taken by Udana.
            This verse explains the Law of Karma and the journey of the soul after death.
            The ticket for our next journey is printed by our current habits and actions.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 38,
        sanskrit = "आदित्यो ह वै बाह्यः प्राण उदयत्येष ह्येनं चाक्षुषं प्राणमनुगृह्णानः । पृथिव्यां या देवता सैषा पुरुषस्यापानमवष्टभ्यान्तरा यदाकाशः स समानो वायुर्व्यानः ॥ ३८ ॥",
        hindi = """
            बाहरी जगत में सूर्य ही मुख्य 'प्राण' के रूप में उदित होता है और पोषण करता है।
            वही सूर्य हमारी आँखों के भीतर स्थित दर्शन-प्राण पर कृपा (अनुग्रह) करता है।
            पृथ्वी की जो आकर्षण शक्ति (गुरूत्वाकर्षण) है, वह शरीर के भीतर 'अपान' वायु है।
            आकाश के बीच की जो खाली जगह है, वह शरीर में 'समान' वायु का आधार है।
            बाहरी वायु जो सब जगह व्याप्त है, वह शरीर के भीतर 'व्यान' वायु का रूप है।
            यहाँ ब्रह्मांड (Macrocosm) और पिंड (Microcosm) की एकता को दिखाया गया है।
            जो शक्तियां बाहर प्रकृति में हैं, वही लघु रूप में हमारे शरीर के भीतर काम कर रही हैं।
            पृथ्वी हमें नीचे खींचती है, वैसे ही अपान वायु कचरे को नीचे की ओर धकेलती है।
            सूर्य हमें प्रकाश देता है, वैसे ही आंतरिक प्राण हमें जीवन की ऊष्मा प्रदान करता है।
            हमारा अस्तित्व बाहरी प्रकृति से अलग नहीं है, हम उसी का एक जैविक विस्तार हैं।
        """.trimIndent(),
        english = """
            In the external world, the Sun rises as the primary 'Prana' and sustains all.
            That Sun bestows grace upon the visual prana residing within our eyes.
            The gravitational or supportive power of the Earth is the 'Apana' within the body.
            The space in the atmosphere is the counterpart to 'Samana' vayu in the body.
            The external Air that pervades everywhere is the form of 'Vyana' vayu within us.
            This verse demonstrates the unity between the Macrocosm and the Microcosm.
            The same forces that exist in outer nature operate in miniature within our bodies.
            As the Earth pulls downward, so Apana vayu pushes waste downward in the system.
            As the Sun gives light, so the internal Prana provides the warmth of life.
            Our existence is not separate from outer nature; we are a biological extension of it.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 39,
        sanskrit = "तेजो ह वा उदानस्तस्मादुपशान्ततेजाः । पुनर्भवमिन्द्रियैर्मनसि सम्पद्यमानैः ॥ ३९ ॥",
        hindi = """
            बाहरी जगत का जो 'तेज' (अग्नि तत्व) है, वही शरीर के भीतर 'उदान' वायु है।
            जब मनुष्य की शारीरिक गर्मी (तेज) शांत हो जाती है, तब मृत्यु का समय आता है।
            उस समय सभी इंद्रियां अपनी शक्तियां समेटकर मन में विलीन हो जाती हैं।
            यह श्लोक मृत्यु की वैज्ञानिक प्रक्रिया का वर्णन करता है—कैसे सिस्टम बंद होता है।
            ठंडा पड़ता हुआ शरीर इस बात का संकेत है कि उदान वायु प्रस्थान की तैयारी में है।
            इंद्रियों का मन में समाना यह दर्शाता है कि अब बाहरी जगत से संपर्क टूट चुका है।
            अब केवल मन की गहराइयों में दबे संस्कार ही अगले जन्म का आधार बनते हैं।
            अंतिम समय का 'तेज' ही चेतना की लौ को अगले दीये की ओर ले जाता है।
            मृत्यु कोई अंत नहीं, बल्कि ऊर्जा का एक रूप से दूसरे रूप में रूपांतरण है।
            उदान ही वह अग्नि है जो जीवात्मा को स्थूल शरीर से सूक्ष्म शरीर में ले जाती है।
        """.trimIndent(),
        english = """
            The external 'Tejas' (Fire element) is the 'Udana' vayu within the body.
            When a person's bodily heat (Tejas) subsides, the time of death approaches.
            At that moment, all the senses withdraw their powers and merge into the mind.
            This verse describes the scientific process of death—how the system shuts down.
            A cooling body is a signal that the Udana vayu is preparing for departure.
            The merging of senses into the mind shows that contact with the outer world is lost.
            Now, only the impressions buried in the depths of the mind form the basis of rebirth.
            The final 'Tejas' carries the flame of consciousness toward the next lamp.
            Death is not an end but a transformation of energy from one state to another.
            Udana is the fire that carries the soul from the gross body to the subtle body.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 40,
        sanskrit = "यच्चित्तस्तेन एष प्राणमायाति प्राणस्तेजसा युक्तः । सहात्मना यथासंकल्पितं लोकं नयति ॥ ४० ॥",
        hindi = """
            मृत्यु के समय मनुष्य का जैसा 'चित्त' (विचार/संकल्प) होता है, प्राण उसी में मिल जाता है।
            वह प्राण 'तेज' (उदान) के साथ युक्त होकर जीवात्मा के साथ बाहर निकलता है।
            आत्मा और प्राण मिलकर मनुष्य को उसके द्वारा कल्पित या अर्जित लोक में ले जाते हैं।
            अंतिम विचार ही हमारी अगली यात्रा का मुख्य दिशा-निर्देशक (Navigator) होता है।
            इसलिए जीवन भर मन को शुभ विचारों में लगाने का अभ्यास करना अनिवार्य है।
            जैसा बीज हम जीवन भर बोते हैं, वैसा ही फल उदान वायु हमें अंतिम समय में देती है।
            प्राण वह वाहन है और उदान वह ड्राइवर है जो आत्मा को नए गंतव्य तक पहुँचाता है।
            यह श्लोक 'अंत मति सो गति' (जैसा अंतिम विचार वैसी गति) के नियम को पुष्ट करता है।
            हमारी पूरी जिंदगी की मेहनत उस एक अंतिम क्षण के संकल्प में सिमट आती है।
            हे जिज्ञासु! अपने मन को हमेशा पवित्र रखो, क्योंकि वही तुम्हारा भविष्य तय करता है।
        """.trimIndent(),
        english = """
            Whatever a person's 'Chitta' (thought/will) is at the time of death, Prana enters that.
            That Prana, joined with Tejas (Udana), departs from the body along with the Self.
            The Self and Prana together lead the person to the world imagined or earned by them.
            The final thought is the primary navigator of our next spiritual journey.
            Therefore, it is essential to practice keeping the mind in noble thoughts throughout life.
            The seeds we sow throughout our lives determine the fruit Udana gives us at the end.
            Prana is the vehicle and Udana is the driver that takes the soul to its new destination.
            This verse confirms the law—'as the final thought, so is the destiny.'
            The labor of our entire life culminates in the resolution of that one final moment.
            O seeker! Keep your mind pure always, for it is your mind that decides your future.
        """.trimIndent()
    ),
    // ... Continuing prashnaShlokasList from ID 41

    PrashnaShloka(
        id = 41,
        sanskrit = "य एवं विद्वान् प्राणं वेद न हास्य प्रजा हीयतेऽमृतो भवति तदेष श्लोकः ॥ ४१ ॥",
        hindi = """
            जो विद्वान इस प्रकार प्राण के रहस्यों और उसके कार्यों को ठीक-ठीक जानता है,
            उसकी संतति (प्रजा) कभी नष्ट नहीं होती और वह स्वयं अमृतत्व को प्राप्त होता है।
            इस सत्य की पुष्टि में यह प्रसिद्ध श्लोक भी प्राचीन काल से प्रचलित है।
            प्राण का ज्ञान केवल बौद्धिक जानकारी नहीं, बल्कि जीवन की गहराई का अनुभव है।
            जो व्यक्ति प्राण की दिव्यता को पहचान लेता है, वह मृत्यु के भय से मुक्त हो जाता है।
            उसकी वंश-परंपरा में ज्ञान और शक्ति का प्रवाह कभी भी बाधित नहीं होता।
            अमृत होने का अर्थ है अपनी आत्मा को उस अविनाशी ऊर्जा के साथ एक कर लेना।
            यह श्लोक तीसरे प्रश्न का फलश्रुति (परिणाम) बताता है जो अत्यंत प्रेरणादायक है।
            जीवन की नश्वरता के बीच प्राण का ज्ञान ही हमें अमरता का भरोसा दिलाता है।
            सत्य के खोजी के लिए यह ज्ञान ही सबसे बड़ी संपत्ति और अंतिम सुरक्षा है।
        """.trimIndent(),
        english = """
            The wise one who knows the secrets and functions of Prana in this manner,
            his progeny never perishes, and he himself attains the state of immortality.
            In support of this truth, the following ancient verse is also cited here.
            The knowledge of Prana is not just intellectual info but a deep life experience.
            He who recognizes the divinity of Prana becomes free from the fear of death.
            In his lineage, the flow of wisdom and vitality remains forever uninterrupted.
            To be immortal means to unify one's soul with that indestructible energy.
            This verse provides the 'Phalashruti' or the result of the third inquiry.
            Amidst the transience of life, the knowledge of Prana offers the hope of eternity.
            For a seeker of Truth, this wisdom is the greatest asset and ultimate security.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 42,
        sanskrit = "उत्पत्तिमायतिं स्थानं विभुत्वं चैव पञ्चधा । अध्यात्मं चैव प्राणस्य विज्ञायामृतमश्नुते विज्ञायामृतमश्नुत इति ॥ ४२ ॥",
        hindi = """
            प्राण की उत्पत्ति, उसके शरीर में आने का ढंग, उसके रहने का स्थान और उसकी व्यापकता,
            उसके पांच प्रकार के विभाजन और उसका आंतरिक (अध्यात्म) रूप जानकर मनुष्य अमर होता है।
            यहाँ 'अमृत' शब्द का दोबारा प्रयोग इस ज्ञान की महत्ता और निश्चितता को दर्शाता है।
            प्राण को जानना वास्तव में उस ईश्वर को जानना है जो जीवन बनकर हमारे भीतर है।
            उत्पत्ति का ज्ञान हमें हमारे आध्यात्मिक स्रोत (आत्मा) की याद दिलाता है।
            विभाजन का ज्ञान हमें शरीर की मशीनरी को सही ढंग से संचालित करना सिखाता है।
            अध्यात्म रूप का ज्ञान हमें इंद्रियों पर विजय पाने की शक्ति और धैर्य प्रदान करता है।
            यह श्लोक तीसरे प्रश्न का पूर्ण समापन है जो साधना का पूरा नक्शा पेश करता है।
            ज्ञान की पूर्णता ही अज्ञान के अंधकार को मिटाकर अमरता का प्रकाश लाती है।
            जानने वाला स्वयं वही बन जाता है जिसे वह इतनी गहराई से जान लेता है।
        """.trimIndent(),
        english = """
            Knowing the origin, the entry, the location, the fivefold distribution of Prana,
            and its internal (spiritual) nature, one attains the state of immortality.
            The repetition of 'immortality' emphasizes the certainty and greatness of this wisdom.
            To know Prana is truly to know the Divinity that resides within us as Life.
            Knowledge of its origin reminds us of our spiritual source—the Atman.
            Knowledge of its distribution teaches us to manage the body's machinery.
            Knowledge of its spiritual aspect grants us the power to master our senses.
            This verse marks the complete end of the third Prashna, offering a roadmap.
            The perfection of knowledge destroys the darkness of ignorance and brings light.
            The one who knows truly becomes that which he has understood so deeply.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 43,
        sanskrit = "अथ हैनं सौर्यायणी गार्ग्यः पप्रच्छ । भगवन् एतस्मिन् पुरुषे कानि स्वपन्ति कान्यस्मिञ्जाग्रति कतर एष देवः स्वप्नान् पश्यति कस्यैतत् सुखं भवति कस्मिन्नु सर्वे संप्रतिष्ठिता भवन्तीति ॥ ४३ ॥",
        hindi = """
            अब चतुर्थ प्रश्न प्रारंभ होता है, जिसे सौर्यायणी गार्ग्य ने महर्षि से पूछा है।
            उनका प्रश्न नींद, स्वप्न और गहरी सुषुप्ति के रहस्यों के बारे में अत्यंत सूक्ष्म है।
            उन्होंने पूछा: 'हे भगवन्! इस मनुष्य के शरीर में कौन सोता है और कौन जागता रहता है?'
            'वह कौन सा देव (शक्ति) है जो नींद के दौरान स्वप्न की दुनिया को देखता है?'
            'गहरी नींद में मिलने वाले उस असीम सुख का अनुभव वास्तव में किसे होता है?'
            'और वे कौन हैं जिनमें यह सब कुछ अंत में पूरी तरह से प्रतिष्ठित (लीन) हो जाता है?'
            गार्ग्य यह जानना चाहते थे कि चेतना की विभिन्न अवस्थाएं कैसे काम करती हैं।
            जब आँखें बंद होती हैं और मन शांत होता है, तब भी कोई तो है जो भीतर जाग रहा है।
            यह प्रश्न मनोविज्ञान (Psychology) और अध्यात्म के मिलन बिंदु पर स्थित है।
            ऋषि पिप्पलाद अब निद्रा के दौरान होने वाली सूक्ष्म गतिविधियों का रहस्य खोलेंगे।
        """.trimIndent(),
        english = """
            The fourth question begins now, asked by Sauryayani Gargya to the Sage.
            His inquiry is extremely subtle, focusing on the mysteries of sleep and dreams.
            He asked: 'Venerable Sir, who is it that sleeps in this person, and who stays awake?'
            'Which is that deity (power) that sees the world of dreams during sleep?'
            'Who is it that actually experiences the boundless joy found in deep sleep?'
            'And in whom is everything finally and completely established or merged?'
            Gargya wanted to understand how the different states of consciousness function.
            When the eyes are closed and the mind is still, someone remains awake within.
            This question stands at the intersection of psychology and deep spirituality.
            Sage Pippalada will now reveal the secrets of subtle activities during sleep.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 44,
        sanskrit = "तस्मै स होवाच । यथा गार्ग्य मरीचयोऽर्कस्यास्तं गच्छतः सर्वा एतस्मिंस्तेजोमण्डल एकीभवन्ति ताः पुनः पुनरुदयतः प्रचरन्त्येवं ह वै तत्सर्वं परे देवे मनस्येकीभवति ॥ ४४ ॥",
        hindi = """
            ऋषि ने उत्तर दिया: 'हे गार्ग्य! जैसे डूबते हुए सूर्य की सभी किरणें उसके मंडल में समा जाती हैं,
            और अगले दिन सूर्य के उदय होने पर वे फिर से चारों ओर फैलने लगती हैं।
            ठीक उसी प्रकार, सोते समय सभी इंद्रियां श्रेष्ठ देव 'मन' में आकर एक हो जाती हैं।
            नींद के दौरान हमारी देखने, सुनने और बोलने की शक्तियां मन के भीतर सिमट जाती हैं।
            इसीलिए सोते हुए व्यक्ति को न कुछ सुनाई देता है, न दिखाई देता है और न गंध आती है।
            मन ही वह मुख्य संग्रहण केंद्र (Storage) है जहाँ सारी ऊर्जा अस्थायी रूप से ठहरती है।
            इंद्रियां नष्ट नहीं होतीं, वे केवल बाहरी जगत से अपना संबंध तोड़कर भीतर लौट आती हैं।
            जैसे सूर्य की किरणें रात में लुप्त नहीं होतीं, बस सूर्य के साथ ही विश्राम करती हैं।
            यह उदाहरण चेतना के संकुचन (Contraction) और विस्तार (Expansion) को बखूबी समझाता है।
            मन ही वह पर्दा है जिस पर जागृत और स्वप्न दोनों अवस्थाओं के चित्र चलते हैं।
        """.trimIndent(),
        english = """
            The Sage replied: 'O Gargya! As the rays of the setting sun all merge into his orb,
            and spread out again in all directions when the sun rises the next day.
            In the same way, during sleep, all the senses merge into the supreme deity, Mind.
            During sleep, our powers of seeing, hearing, and speaking withdraw into the mind.
            That is why a sleeping person does not hear, see, or smell anything external.
            The mind is the primary storage center where all energy temporarily resides.
            The senses are not destroyed; they simply break contact with the world and return.
            Just as solar rays don't vanish at night but merely rest within the sun itself.
            This metaphor perfectly explains the contraction and expansion of consciousness.
            The mind is the screen upon which the images of both waking and dreaming play.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 45,
        sanskrit = "तेन तर्ह्येष पुरुषो न शृणोति न पश्यति न जिघ्रति न रसयते न स्पृशते नाभिवदते नादत्ते नानन्दयते न विसृजते नेयायते स्वपितीत्याचक्षते ॥ ४५ ॥",
        hindi = """
            जब इंद्रियां मन में लीन हो जाती हैं, तब मनुष्य न सुनता है, न देखता है, न सूँघता है।
            वह न स्वाद ले सकता है, न स्पर्श का अनुभव करता है, न बोलता है और न कुछ पकड़ता है।
            वह न आनंद लेता है, न त्याग करता है और न ही कहीं आ-जा सकता है।
            ऐसी स्थिति को ही लोग सामान्य भाषा में 'यह सो रहा है' (स्वपिति) कहते हैं।
            नींद वास्तव में इंद्रियों की शक्तियों का बाहरी दुनिया से पूरी तरह कट जाना है।
            शरीर जीवित रहता है, लेकिन उसका बाहरी जगत से संपर्क अस्थाई रूप से बंद हो जाता है।
            यह एक ऐसी अवस्था है जहाँ कर्ता (Doer) अपनी सभी शारीरिक गतिविधियों को रोक देता है।
            यहाँ 'स्वपिति' का गहरा अर्थ है 'अपने आप में स्थित होना' (स्व-अपि-इति)।
            यह श्लोक गहरी नींद की भौतिक और मानसिक स्थिति का सटीक विवरण देता है।
            बाहरी दुनिया के लिए व्यक्ति अनुपस्थित है, पर उसके भीतर कुछ और घटित हो रहा है।
        """.trimIndent(),
        english = """
            When senses merge in the mind, the person hears not, sees not, nor smells.
            He cannot taste, nor feel touch, nor speak, nor grasp anything with his hands.
            He neither enjoys, nor discards, nor is he able to move from one place to another.
            In such a state, people commonly say about him: 'He is sleeping' (Svapiti).
            Sleep is actually the total disconnection of sensory powers from the outer world.
            The body remains alive, but its contact with external reality is temporarily suspended.
            It is a state where the 'Doer' puts a halt to all physical and outward activities.
            The term 'Svapiti' etymologically implies 'to be merged into one's own self'.
            This verse provides a precise description of the physical and mental state of sleep.
            To the outside world, the person is absent, but something else is happening within.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 46,
        sanskrit = "प्राणाग्नय एवैतस्मिन् पुरे जाग्रति । गार्हपत्यो ह वा एषोऽपानो व्यानोऽन्वाहार्यपचनो यद्गार्हपत्यात् प्रणीयते प्रणयनादाहवनीयः प्राणः ॥ ४६ ॥",
        hindi = """
            जब इंद्रियां सो जाती हैं, तब भी इस शरीर रूपी नगर में 'प्राण रूपी अग्नियां' जागती रहती हैं।
            अपान वायु ही 'गार्हपत्य' अग्नि है और व्यान वायु 'अन्वाहार्यपचन' (दक्षिणाग्नि) है।
            क्योंकि प्राण गार्हपत्य से निकाला जाता है, इसलिए मुख्य प्राण 'आहवनीय' अग्नि है।
            यहाँ शरीर की तुलना एक यज्ञ-वेदी से की गई है जहाँ निरंतर जीवन का होम हो रहा है।
            जैसे मंदिर में अखंड जोत जलती रहती है, वैसे ही नींद में भी प्राण अग्नि जलती रहती है।
            यही वह शक्ति है जो नींद के दौरान हृदय की धड़कन और श्वास को निरंतर चलाती है।
            यदि ये अग्नियां सो जाएँ, तो शरीर का अंत हो जाएगा; प्राण ही असली पहरेदार है।
            प्राचीन यज्ञ की शब्दावली का प्रयोग शरीर की पवित्रता और उसके कार्यों को समझाने के लिए है।
            प्राण कभी नहीं सोता, वह चौबीसों घंटे अपना कर्तव्य निभाता रहता है।
            यह श्लोक सिद्ध करता है कि हमारा जीवन एक निरंतर चलने वाला आध्यात्मिक अनुष्ठान है।
        """.trimIndent(),
        english = """
            Even when the senses sleep, the 'Fires of Prana' stay awake in this city of the body.
            Apana is the 'Garhapatya' fire, and Vyana is the 'Anvaharyapachana' (Dakshina fire).
            Since Prana is drawn from the Garhapatya, the chief Prana is the 'Ahavaniya' fire.
            The body is compared to a sacrificial altar where the rite of life is constantly ongoing.
            Like an eternal flame in a temple, the fire of Prana continues to burn during sleep.
            This is the force that keeps the heartbeat and respiration steady during slumber.
            If these fires were to sleep, the body would perish; Prana is the true sentinel.
            The use of ancient Vedic sacrificial terms elevates the sanctity of bodily functions.
            Prana never sleeps; it performs its duties twenty-four hours a day without fail.
            This verse proves that our life is a continuous, ongoing spiritual ritual.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 47,
        sanskrit = "यदुच्छ्वासनिःश्वासावेतावाहुती समं नयतीति स समानः । मनो ह वाव यजमान इष्टफलमेवोदानः स एनं यजमानमहरहर्ब्रह्म गमयति ॥ ४७ ॥",
        hindi = """
            सांस का अंदर लेना और बाहर छोड़ना—ये यज्ञ की दो आहुतियाँ हैं, जिन्हें समान वायु बराबर रखता है।
            इस शरीर रूपी यज्ञ में 'मन' ही वास्तव में यजमान (यज्ञ करने वाला) है।
            यज्ञ का अभीष्ट फल 'उदान' वायु है, जो यजमान (मन) को प्रतिदिन गहरी नींद में ब्रह्म तक ले जाता है।
            समान वायु पाचन और श्वास के संतुलन को बनाए रखती है, जैसे यज्ञ की आहुतियों का प्रबंधन।
            गहरी नींद (सुषुप्ति) वह अवस्था है जहाँ मन सांसारिक चिंताओं से मुक्त होकर परमात्मा के पास विश्राम करता है।
            उदान वायु वह लिफ्ट है जो चेतना को शरीर के भारीपन से उठाकर शांति के सागर में डुबो देती है।
            प्रतिदिन हम अनजाने में ही उस परम सत्य (ब्रह्म) का स्पर्श करते हैं, यही नींद का असली सुख है।
            यज्ञ का फल जैसे स्वर्ग होता है, वैसे ही दिन भर के कर्मों के बाद नींद का फल शांति है।
            यह श्लोक नींद को एक योगिक क्रिया के रूप में प्रस्तुत करता है जो हमें परमात्मा से जोड़ती है।
            ब्रह्म तक पहुँचना ही वह चार्जिंग स्टेशन है जहाँ से हम अगले दिन के लिए ऊर्जा पाते हैं।
        """.trimIndent(),
        english = """
            The inhalation and exhalation are the two oblations kept balanced by Samana vayu.
            In this sacrifice of the body, the 'Mind' is truly the 'Yajamana' (the sacrificer).
            The desired fruit of the sacrifice is 'Udana' vayu, which leads the mind to Brahman daily.
            Samana maintains the balance of digestion and breath, managing the life-oblations.
            Deep sleep (Sushupti) is the state where the mind rests with the Divine, free from worry.
            Udana is the elevator that lifts consciousness from bodily gravity into the ocean of peace.
            Unknowingly, we touch the Supreme Reality (Brahman) every single day during deep sleep.
            Just as heaven is the fruit of a ritual, peace is the fruit of sleep after the day's labor.
            This verse presents sleep as a yogic process that connects us with the Absolute.
            Reaching Brahman is the charging station from which we gain energy for the next day.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 48,
        sanskrit = "अत्रैष देवः स्वप्ने महिमानमनुभवति । यद्दृष्टं दृष्टमनुपश्यति श्रुतं श्रुतमेवानुशृणोति देशदिगन्तरैश्च प्रत्यनुभूतं पुनः पुनः प्रत्यनुभवति दृष्टं चादृष्टं च श्रुतं चाश्रुतं च चानुभूतं चानुभूतं च सच्चासच्च सर्वं पश्यति सर्वः पश्यति ॥ ४८ ॥",
        hindi = """
            स्वप्न की अवस्था में यह मन रूपी देव अपनी महानता और महिमा का अनुभव करता है।
            जो पहले देखा गया है, उसे वह फिर से देखता है; जो सुना गया है, उसे फिर से सुनता है।
            विभिन्न देशों और दिशाओं में जो अनुभव किए गए हैं, उन्हें वह बार-बार अनुभव करता है।
            वह जो देखा गया है और जो नहीं देखा गया (कल्पना), जो सुना है और जो अनसुना है, सब देखता है।
            वह सत्य और असत्य, अनुभव किए हुए और अननुभवी—सबका अनुभव करता है, क्योंकि वह स्वयं सब बन जाता है।
            स्वप्न में मन एक नया ब्रह्मांड रचता है जहाँ वह स्वयं ही अभिनेता और दर्शक दोनों होता है।
            हमारी दबी हुई इच्छाएं और स्मृतियां ही स्वप्न के दृश्यों का कच्चा माल (Raw material) होती हैं।
            मन की शक्ति इतनी असीम है कि वह बिना आँखों के देख सकता है और बिना कानों के सुन सकता है।
            यह श्लोक स्वप्न की मनोवैज्ञानिक गहराई और मन की रचनात्मक शक्ति को प्रकट करता है।
            स्वप्न में हम अपनी ही मानसिक दुनिया के सम्राट होते हैं, जहाँ समय और स्थान की सीमा नहीं होती।
        """.trimIndent(),
        english = """
            In the dream state, this deity, the Mind, experiences its own greatness and glory.
            What has been seen, it sees again; what has been heard, it hears again.
            Whatever has been experienced in different lands and directions, it experiences repeatedly.
            It perceives what has been seen and what has not been seen, what is heard and unheard.
            It experiences the real and the unreal, the felt and the unfelt—for it becomes all things.
            In dreams, the mind creates a new universe where it is both the actor and the spectator.
            Our suppressed desires and memories are the raw materials for the dream sequences.
            The power of the mind is so vast that it can see without eyes and hear without ears.
            This verse reveals the psychological depth of dreams and the creative power of the mind.
            In dreams, we are the sovereigns of our own mental world, bound by neither time nor space.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 49,
        sanskrit = "स यदा तेजसाऽभिभूतो भवति । अत्रैष देवः स्वप्नान् न पश्यत्यथ तदैतस्मिञ्छरीरे एतत्सुखं भवति ॥ ४९ ॥",
        hindi = """
            जब यह मन रूपी देव आत्मा के प्रकाश (तेज) से पूरी तरह अभिभूत या भर जाता है।
            तब वह स्वप्न देखना बंद कर देता है और 'सुषुप्ति' यानी प्रगाढ़ निद्रा की अवस्था में पहुँचता है।
            उस समय इस शरीर में वह असीम और दिव्य सुख प्रकट होता है जो शब्दों से परे है।
            गहरी नींद में मन की चंचलता शांत हो जाती है और वह अपने मूल स्रोत (आत्मा) में विलीन होता है।
            यह सुख किसी बाहरी वस्तु से नहीं मिलता, बल्कि आत्मा के अपने स्वरूप का आनंद है।
            जब तक विचार और सपने हैं, तब तक पूर्ण शांति नहीं मिल सकती; 'तेज' ही सब मिटाता है।
            यही वह अवस्था है जहाँ जीव और ब्रह्म के बीच की दूरी लगभग समाप्त हो जाती है।
            सुबह उठकर हम जो कहते हैं "मैं बहुत सुख से सोया", वह इसी अवस्था का अनुभव है।
            यह श्लोक गहरी नींद को ध्यान (Meditation) की एक प्राकृतिक और उच्च अवस्था मानता है।
            बिना सपनों की नींद ही हमारे नर्वस सिस्टम और मन की असली हीलिंग (Healing) करती है।
        """.trimIndent(),
        english = """
            When this deity, the Mind, is completely overwhelmed or filled by the light of the Self.
            Then it ceases to see dreams and enters 'Sushupti'—the state of profound, deep sleep.
            At that time, there arises in this body that boundless and divine joy beyond words.
            In deep sleep, the restlessness of the mind is stilled, and it merges into its source, Atman.
            This joy is not derived from any external object but is the bliss of one's own nature.
            As long as thoughts and dreams persist, total peace is elusive; 'Tejas' dissolves them all.
            This is the state where the distance between the individual and the Absolute vanishes.
            When we wake up and say "I slept very happily," it is the memory of this specific state.
            This verse views deep sleep as a natural and elevated state of meditation.
            Dreamless sleep is the true healing for our nervous system and the weary mind.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 50,
        sanskrit = "स यथा गार्ग्य वयांसि वासवृक्षं संप्रतिष्ठन्ते । एवं ह वै तत्सर्वं पर आत्मनि संप्रतिष्ठते ॥ ५० ॥",
        hindi = """
            हे गार्ग्य! जिस प्रकार पक्षी शाम होने पर अपने रहने के वृक्ष (आशियाने) की ओर लौट जाते हैं।
            ठीक उसी प्रकार, यह संपूर्ण जगत और सभी जीव अंततः उस 'परमात्मा' में ही प्रतिष्ठित होते हैं।
            यह श्लोक सृष्टि के लय (Dissolution) और विश्राम के महासिद्धांत को समझाता है।
            जैसे पक्षी दिन भर उड़कर अंत में शांति के लिए घर आते हैं, वैसे ही आत्मा परमात्मा में आती है।
            परमात्मा ही वह 'निवास वृक्ष' है जो सभी प्राणियों को सुरक्षा और आश्रय प्रदान करता है।
            नींद में हो या मृत्यु में, हम हमेशा अपने उसी मूल आधार की ओर वापस लौटते हैं।
            यह उदाहरण घर लौटने की उस सुखद अनुभूति को दर्शाता है जो हर जीव की खोज है।
            संपूर्ण विविधता अंत में एकता में बदल जाती है, जैसे नदियां समुद्र में विलीन होती हैं।
            परमात्मा ही वह केंद्र है जहाँ से हम आते हैं और जहाँ हमें अंत में जाकर ठहरना है।
            यह चौथे प्रश्न का एक बहुत ही सुंदर और करुणामयी दार्शनिक निष्कर्ष है।
        """.trimIndent(),
        english = """
            O Gargya! Just as birds return to their nesting tree at the end of the day for rest.
            In the same way, this entire universe and all beings finally rest in the Supreme Self.
            This verse explains the great principle of cosmic dissolution and spiritual rest.
            As birds fly all day and return home for peace, so does the soul return to the Divine.
            The Supreme Self is the 'Dwelling Tree' providing safety and shelter to all creatures.
            Whether in sleep or in death, we always return toward that same original foundation.
            The metaphor evokes the pleasant feeling of returning home, which every being seeks.
            All diversity eventually transforms into unity, much like rivers merging into the ocean.
            The Divine is the center from which we emerge and where we must finally settle.
            This is a beautiful and compassionate philosophical conclusion to the fourth inquiry.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 51,
        sanskrit = "पृथिवी च पृथिवीमात्रा चापश्चापोमात्रा च तेजश्च तेजोमात्रा च वायुश्च वायुमात्रा चाकाशश्चाकाशमात्रा च चक्षुश्च द्रष्टव्यं च श्रोत्रं च श्रोतव्यं च घ्राणं च घ्रातव्यं च रसश्च रसयितव्यं च त्वक् च स्पर्शयितव्यं च वाक् च वक्तव्यं च हस्तौ चादातव्यं च पादौ च गन्तव्यं च पायुश्च विसर्जयितव्यं च उपस्थश्चानन्दयितव्यं च मनश्च मन्तव्यं च बुद्धिश्च बोद्धव्यं च अहंकारश्च अहंकर्तव्यं च चित्तं च चेतयितव्यं च तेजश्च विद्योतयितव्यं च प्राणश्च विधारयितव्यं च ॥ ५१ ॥",
        hindi = """
            पृथ्वी और उसकी सूक्ष्म तन्मात्र, जल, अग्नि, वायु और आकाश—सब उसी परमात्मा में लीन होते हैं।
            देखने वाली आँख और दिखाई देने वाला दृश्य, सुनने वाले कान और सुनाई देने वाला शब्द।
            सूँघने वाली नाक और गंध, चखने वाली जीभ और स्वाद, छूने वाली त्वचा और स्पर्श।
            बोलने वाली वाणी और शब्द, हाथ और वस्तुएँ, पैर और गमन (चलना), विसर्जन अंग और आनंद अंग।
            मन और विचार, बुद्धि और निश्चय, अहंकार और अहम्-भाव, चित्त और स्मृति, तेज और प्रकाश।
            प्राण और उसे धारण करने वाली शक्ति—यह संपूर्ण ब्रह्मांडीय और शारीरिक ढांचा परमात्मा में प्रतिष्ठित है।
            यह श्लोक अस्तित्व की एक पूरी सूची (Inventory) देता है जो परमात्मा के भीतर टिकी है।
            यह दर्शाता है कि हमारे अनुभव की कोई भी चीज़ परमात्मा के नियंत्रण से बाहर नहीं है।
            भौतिक तत्व हों या मानसिक शक्तियां, सबका स्रोत और अंत वह एक ही परम सत्ता है।
            यह 'सबका एक में लय' होने के सिद्धांत का सबसे विस्तृत और वैज्ञानिक वर्णन है।
        """.trimIndent(),
        english = """
            Earth and its essence, Water, Fire, Air, and Space—all merge into that Supreme Self.
            The seeing eye and the seen object, the hearing ear and the heard sound.
            The smelling nose and fragrance, the tasting tongue and flavor, the skin and touch.
            The speaking voice and words, hands and objects, feet and movement, organs of excretion and joy.
            Mind and thought, intellect and determination, ego and the sense of 'I', memory and recollection.
            The vital Prana and the power that supports it—this entire cosmic and bodily structure rests in Him.
            This verse provides a comprehensive inventory of existence that stays within the Divine.
            It demonstrates that nothing in our experience lies outside the control of the Supreme.
            Whether material elements or mental powers, the source and end are that one absolute Being.
            This is the most detailed and scientific description of the principle of 'Dissolution into Unity'.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 52,
        sanskrit = "एष हि द्रष्टा स्प्रष्टा श्रोता घ्राता रसयिता मन्ता बोद्धा कर्ता विज्ञानात्मा पुरुषः । स परेऽक्षर आत्मनि संप्रतिष्ठते ॥ ५२ ॥",
        hindi = """
            वही वास्तव में देखने वाला, छूने वाला, सुनने वाला, सूँघने वाला, चखने वाला, सोचने वाला और जानने वाला है।
            वही कर्म करने वाला 'कर्ता' और विज्ञान-स्वरूप जीवात्मा (विज्ञानात्मा पुरुष) है।
            यही जीवात्मा अंततः उस 'अविनाशी' (अक्षर) परम आत्मा में जाकर विलीन हो जाती है।
            हम जिसे अपना 'मैं' समझते हैं, वह वास्तव में परमात्मा का ही एक अंश या प्रतिबिंब है।
            इंद्रियां तो केवल खिड़कियां हैं, उनके पीछे देखने वाला असली मालिक वह 'विज्ञानात्मा' ही है।
            जब तक यह 'अक्षर' परमात्मा से अलग महसूस करता है, तब तक यह संसार का अनुभव करता है।
            परंतु अंत में इसकी मुक्ति और शांति उसी अविनाशी तत्व में लौटने में ही है।
            यह श्लोक जीवात्मा और परमात्मा के बीच के गहरे संबंध को स्पष्ट करता है।
            अक्षर (Imperishable) ही वह अंतिम सत्य है जहाँ पहुँचकर कुछ भी नष्ट नहीं होता।
            हमारा असली स्वरूप वह है जो कभी नहीं मरता और हमेशा के लिए शांत रहता है।
        """.trimIndent(),
        english = """
            He is indeed the seer, the toucher, the hearer, the smeller, the taster, the thinker, and the knower.
            He is the 'Doer' and the individual soul of wisdom (Vijnanatma Purusha).
            This individual soul finally goes and merges into the 'Imperishable' (Akshara) Supreme Self.
            What we consider our 'I' is actually a fragment or a reflection of the Supreme Divine.
            The senses are mere windows; the real master looking through them is this Vijnanatma.
            As long as it feels separate from the 'Akshara' Brahman, it experiences the world.
            But ultimately, its liberation and peace lie in returning to that indestructible element.
            This verse clarifies the deep relationship between the individual soul and the Supreme Self.
            The Akshara is the ultimate truth where nothing is ever lost or destroyed.
            Our true nature is that which never dies and remains eternally peaceful.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 53,
        sanskrit = "परमेवाक्षरं प्रतिपद्यते स यो ह वै तदच्छायमशरीरमलोहितं शुभ्रमक्षरं वेदयते यस्तु सोम्य । स सर्वज्ञः सर्वो भवति तदेष श्लोकः ॥ ५३ ॥",
        hindi = """
            हे प्रिय! जो उस छाया-रहित, शरीर-रहित, रंग-रहित, शुद्ध और अविनाशी (अक्षर) ब्रह्म को जान लेता है।
            वह वास्तव में उस परम सत्य को ही प्राप्त कर लेता है और स्वयं सर्वज्ञ (सब कुछ जानने वाला) हो जाता है।
            वह जो इस सत्य को जानता है, वह स्वयं 'सर्व' (सब कुछ) बन जाता है, यानी वह पूरा ब्रह्मांड बन जाता है।
            परमात्मा का कोई भौतिक आकार नहीं है, इसीलिए उसे 'अशरीरम' और 'अलोहितम' कहा गया है।
            अज्ञान की 'छाया' वहाँ नहीं पहुँच सकती, वह हमेशा ज्ञान के सूर्य की तरह प्रकाशित है।
            सर्वज्ञ होने का अर्थ यह नहीं कि उसे जानकारी मिल जाती है, बल्कि वह चेतना के साथ एक हो जाता है।
            जब बूंद समुद्र में मिल जाती है, तो वह स्वयं समुद्र की गहराई और विस्तार बन जाती है।
            यह श्लोक आत्म-साक्षात्कार (Self-realization) के सर्वोच्च फल का वर्णन करता है।
            सत्य को जानना ही सत्य बन जाना है (ब्रह्मविद् ब्रह्मैव भवति)।
            यह चौथे प्रश्न का आध्यात्मिक शिखर है जहाँ साधक और साध्य एक हो जाते हैं।
        """.trimIndent(),
        english = """
            O dear one! He who knows that shadowless, bodiless, colorless, pure, and imperishable Brahman.
            He truly attains the Supreme Truth and becomes omniscient (the knower of all).
            He who knows this truth becomes 'Sarva' (All) himself; he becomes the entire universe.
            The Divine has no physical form; hence it is called 'Bodiless' and 'Colorless'.
            The 'shadow' of ignorance cannot reach there; it is always shining like the sun of wisdom.
            Becoming omniscient doesn't mean gaining information but unifying with Absolute Consciousness.
            When a drop merges with the ocean, it becomes the very depth and expanse of the ocean.
            This verse describes the supreme fruit of Self-realization.
            To know the Truth is to become the Truth (Brahmavid Brahmaiva Bhavati).
            This is the spiritual peak of the fourth inquiry where the seeker and the Sought become one.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 54,
        sanskrit = "विज्ञानात्मा सह देवैश्च सर्वैः प्राणा भूतानि संप्रतिष्ठन्ति यत्र । तदक्षरं वेदयते यस्तु सोम्य स सर्वज्ञः सर्वमेवाविवेशेति ॥ ५४ ॥",
        hindi = """
            वह अविनाशी तत्व (अक्षर) जिसमें जीवात्मा, सभी देवता, प्राण और पंचभूत लीन रहते हैं।
            हे सोम्य! जो उस अक्षर ब्रह्म को जान लेता है, वह वास्तव में सर्वज्ञ होकर सबमें प्रविष्ट हो जाता है।
            सबमें प्रविष्ट होने का अर्थ है कि वह हर जीव और कण में अपनी ही आत्मा को महसूस करता है।
            उसके लिए अब 'मैं' और 'तुम' का भेद समाप्त हो जाता है, वह एकता के भाव में जीता है।
            यही वह परम रहस्य है जिसे जानने के बाद और कुछ जानना शेष नहीं रह जाता।
            अक्षर ही वह धागा है जिस पर पूरे अस्तित्व का मनका पिरोया हुआ है।
            ज्ञानी पुरुष की दृष्टि अब सीमाओं को पार कर अनंतता (Infinity) को छू लेती है।
            यह श्लोक चौथे प्रश्न का उपसंहार (Conclusion) है, जो पूर्णता का संदेश देता है।
            ब्रह्म को जानना ही पूर्णता का अनुभव करना है, जहाँ कोई कमी या भय नहीं रहता।
            यहाँ गार्ग्य की जिज्ञासा शांत होती है और चेतना के रहस्यों का उद्घाटन पूरा होता है।
        """.trimIndent(),
        english = """
            That imperishable element (Akshara) in which the soul, all deities, Prana, and elements rest.
            O dear one! He who knows that Akshara Brahman truly becomes omniscient and enters into all.
            Entering into all means that he perceives his own Self in every living being and particle.
            For him, the distinction between 'I' and 'You' vanishes; he lives in the state of unity.
            This is the ultimate secret after knowing which nothing else remains to be known.
            The Akshara is the thread upon which the bead of entire existence is strung.
            The vision of the wise man transcends limitations and touches infinity.
            This verse is the conclusion of the fourth inquiry, delivering the message of completeness.
            To know Brahman is to experience perfection where no lack or fear remains.
            Here, Gargya's curiosity is satisfied, and the revelation of consciousness is complete.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 55,
        sanskrit = "अथ हैनं शैब्यः सत्यकामः पप्रच्छ । स यो ह वै तद्भगवन् मनुष्येषु प्रायणान्तमोङ्कारमभिध्यायीत । कतमं वाव स तेन लोकं जयतीति ॥ ५५ ॥",
        hindi = """
            अब पांचवां प्रश्न प्रारंभ होता है, जिसे शिबि के पुत्र सत्यकाम ने पूछा है।
            उनका प्रश्न 'ओंकार' (ॐ) की उपासना और उसके चमत्कारी परिणामों के बारे में है।
            उन्होंने पूछा: 'हे भगवन्! यदि कोई मनुष्य मृत्यु के समय तक निरंतर ओंकार का ध्यान करता है।'
            'तो वह उस ध्यान के प्रभाव से किस लोक को प्राप्त करता है और उसे क्या फल मिलता है?'
            सत्यकाम यह जानना चाहते थे कि 'ॐ' केवल एक ध्वनि है या यह मोक्ष का मार्ग है।
            ओंकार को सभी मंत्रों का सार और परमात्मा का प्रतीक माना गया है।
            मृत्यु के समय का ध्यान ही अगले जन्म या मुक्ति की दिशा तय करता है।
            यह प्रश्न साधना के व्यावहारिक पक्ष और मंत्र-शक्ति (Sound vibration) पर आधारित है।
            महर्षि पिप्पलाद अब ओंकार की तीन मात्राओं और उनके फल की व्याख्या करेंगे।
            यह संवाद ओंकार को एक शक्तिशाली आध्यात्मिक उपकरण (Tool) के रूप में प्रस्तुत करता है।
        """.trimIndent(),
        english = """
            The fifth question begins now, asked by Satyakama, the son of Shibi.
            His inquiry concerns the meditation on 'Omkara' (OM) and its miraculous results.
            He asked: 'Venerable Sir, if a person meditates on Om until the very end of his life.'
            'Which world does he win through that meditation, and what fruit does he obtain?'
            Satyakama wanted to know if 'OM' is just a sound or a path to ultimate liberation.
            Omkara is considered the essence of all mantras and the symbol of the Supreme.
            The focus at the moment of death decides the direction of the next birth or freedom.
            This question is based on the practical side of spiritual practice and sound vibration.
            Sage Pippalada will now explain the three measures (matras) of Om and their fruits.
            This dialogue presents Omkara as a powerful spiritual tool for transcendence.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 56,
        sanskrit = "तस्मै स होवाच । एतद्वै सत्यकाम परं चापरं च ब्रह्म यदोङ्कारः । तस्माद्विद्वानेतेनैवायतनेनैकतरमन्वेति ॥ ५६ ॥",
        hindi = """
            महर्षि ने उत्तर दिया: 'हे सत्यकाम! यह जो ओंकार (ॐ) है, यही परब्रह्म और अपरब्रह्म दोनों है।'
            इसलिए जो विद्वान इसकी उपासना करता है, वह इनमें से किसी भी एक को प्राप्त कर सकता है।
            परब्रह्म का अर्थ है—निर्गुण, निराकार और अनंत सत्य (Absolute Truth)।
            अपरब्रह्म का अर्थ है—सगुण, साकार और संसार का अधिपति (Manifest God)।
            ओंकार ही वह सेतु (Bridge) है जो साधक को इस किनारे से उस अनंत किनारे तक ले जाता है।
            यह वह माध्यम है जिससे हम अपनी सीमित चेतना को असीम चेतना से जोड़ सकते हैं।
            साधना की गहराई के अनुसार व्यक्ति सांसारिक ऐश्वर्य या अंतिम मोक्ष प्राप्त करता है।
            ओंकार में संपूर्ण ब्रह्मांड की ध्वनियां और शक्तियां समाहित हैं।
            यह श्लोक ओंकार की सर्वव्यापकता और उसकी सर्वोच्च महत्ता को स्थापित करता है।
            ॐ के माध्यम से ही हम उस मौन (Silence) तक पहुँच सकते हैं जहाँ ईश्वर निवास करता है।
        """.trimIndent(),
        english = """
            The Sage replied: 'O Satyakama! This Omkara (OM) is both the higher and lower Brahman.'
            Therefore, the wise who meditates on it can attain either of the two.
            Higher Brahman (Para) refers to the attribute-less, formless, Absolute Truth.
            Lower Brahman (Apara) refers to the manifest God with attributes and the Lord of the world.
            Omkara is the bridge that carries the seeker from this shore to the infinite shore.
            It is the medium through which we can connect our limited mind to the Unlimited.
            Depending on the depth of practice, one attains worldly abundance or final liberation.
            In Omkara, all the sounds and powers of the universe are encapsulated.
            This verse establishes the omnipresence and the supreme significance of Omkara.
            It is through OM that we can reach the Silence where the Divine truly dwells.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 57,
        sanskrit = "स यद्येकमात्रमभिध्यायीत स तेनैव संवेदितस्तूर्णमेव जगत्यामभिसम्पद्यते । तमृचो मनुष्यलोकमुपनयन्ते स तत्र तपसा ब्रह्मचर्येण श्रद्धया सम्पन्नो महिमानमनुभवति ॥ ५७ ॥",
        hindi = """
            यदि कोई ओंकार की केवल 'एक मात्रा' (अ-कार) का ध्यान करता है, तो वह शीघ्र ही पृथ्वी पर लौट आता है।
            ऋग्वेद की ऋचाएँ उसे पुनः मनुष्य लोक में एक श्रेष्ठ और पवित्र कुल में जन्म दिलाती हैं।
            वहाँ वह तप, ब्रह्मचर्य और श्रद्धा से युक्त होकर अपनी आध्यात्मिक महिमा का अनुभव करता है।
            अ-कार ओंकार का पहला चरण है जो जागृत अवस्था और भौतिक जगत से जुड़ा है।
            यह साधना का आरंभिक स्तर है जो साधक को एक आदर्श और मर्यादित जीवन की ओर ले जाता है।
            यहाँ पुनर्जन्म बुरा नहीं है, बल्कि यह और अधिक उन्नति के लिए मिला हुआ एक अवसर है।
            एक मात्रा का ध्यान भी व्यक्ति के चरित्र को उज्ज्वल और शक्तिशाली बना देता है।
            मनुष्य लोक में वह धर्मपरायण रहकर समाज का कल्याण और अपनी उन्नति करता है।
            यह श्लोक बताता है कि ओंकार की आंशिक उपासना भी कभी व्यर्थ नहीं जाती।
            हर स्तर का ध्यान साधक को पवित्रता और सफलता की ओर ही ले जाता है।
        """.trimIndent(),
        english = """
            If one meditates on only one measure of OM (the sound 'A'), he quickly returns to Earth.
            The verses of the Rigveda lead him to be reborn in a noble and pure human family.
            There, endowed with penance, celibacy, and faith, he experiences spiritual greatness.
            'A' is the first stage of OM, linked with the waking state and the physical world.
            This is the initial level of practice that leads the seeker toward a disciplined life.
            Rebirth here is not viewed as a curse but as a golden opportunity for further growth.
            Even meditation on a single measure makes the person's character bright and powerful.
            In the human world, he lives righteously, serving society and elevating himself.
            This verse teaches that even partial worship of Omkara is never in vain.
            Every level of meditation leads the seeker toward purity and success.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 58,
        sanskrit = "अथ यदि द्विमात्रेण मनसि सम्पद्यते सोऽन्तरिक्षं यजुर्भिरुन्नीयते सोमलोकम् । स सोमलोके विभूतिमनुभूय पुनरावर्तते ॥ ५८ ॥",
        hindi = """
            यदि कोई ओंकार की 'दो मात्राओं' (अ+उ) का ध्यान मन में एकाग्र होकर करता है।
            तो उसे यजुर्वेद के मंत्र अंतरिक्ष (स्वप्न लोक) से ऊपर 'चंद्रलोक' की ओर ले जाते हैं।
            वहाँ वह दिव्य विभूतियों और सुखों का अनुभव करता है और फिर पुनः पृथ्वी पर लौटता है।
            उ-कार ओंकार का दूसरा चरण है जो स्वप्न अवस्था और सूक्ष्म जगत से संबंधित है।
            यह मानसिक और भावनात्मक शुद्धिकरण की अवस्था है जहाँ उच्च लोकों का आनंद मिलता है।
            चंद्रलोक की प्राप्ति का अर्थ है मानसिक शांति और उच्च दिव्य ऊर्जाओं का अनुभव।
            यद्यपि यह अंतिम मुक्ति नहीं है, फिर भी यह आत्मा की यात्रा का एक सुखद पड़ाव है।
            भोग समाप्त होने पर साधक पुनः मनुष्य शरीर धारण कर अपनी यात्रा आगे बढ़ाता है।
            यह श्लोक ओंकार के दूसरे स्तर की साधना और उसके सूक्ष्म फलों को समझाता है।
            मन की गहराई में उतरने वाला साधक ही सूक्ष्म लोकों के रहस्यों को जान पाता है।
        """.trimIndent(),
        english = """
            If one meditates on two measures of OM (A + U) with a focused mind.
            He is led by the mantras of Yajurveda through space to the world of the Moon.
            There he experiences divine glories and joys, and then returns to the earth once more.
            'U' is the second stage of OM, related to the dream state and the subtle world.
            This is the stage of mental and emotional purification where higher joys are felt.
            Attaining the lunar world implies mental peace and experience of high divine energies.
            Although this is not final liberation, it is a pleasant halt in the soul's long journey.
            After the merits are enjoyed, the seeker takes a human body again to proceed further.
            This verse explains the second level of OM meditation and its subtle rewards.
            Only the seeker who dives deep into the mind can know the secrets of subtle realms.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 59,
        sanskrit = "यः पुनरेतं त्रिमात्रेणोमित्येतेनैवाक्षरेण परं पुरुषमभिध्यायीत स तेजसि सूर्ये सम्पन्नः । यथा पादोदरस्त्वचा विनिर्भुच्यत एवं ह वै स पाप्मना विनिर्भुक्तः स सामभिरुन्नीयते ब्रह्मलोकं स एतस्माज्जीवघनात् परातपरं पुरिशयं पुरुषमीक्षते तदेतौ श्लोकौ भवतः ॥ ५९ ॥",
        hindi = """
            जो 'तीन मात्राओं' (अ+उ+म) वाले पूर्ण ओंकार के द्वारा उस 'परम पुरुष' का ध्यान करता है।
            वह सूर्य के प्रकाश (तेज) के साथ एकाकार हो जाता है और जन्म-मृत्यु के चक्र से मुक्त होता है।
            जिस प्रकार एक सर्प अपनी केंचुल (पुरानी त्वचा) को त्याग कर बिल्कुल मुक्त और नया हो जाता है।
            ठीक उसी प्रकार, वह साधक अपने सभी पापों और बंधनों से मुक्त होकर 'ब्रह्मलोक' पहुँचता है।
            सामवेद के गान उसे उस सर्वोच्च धाम तक ले जाते हैं जहाँ वह हृदय में रहने वाले परमात्मा को देखता है।
            यह ओंकार की पूर्ण साधना है जो अद्वैत (Non-duality) और मोक्ष का द्वार खोलती है।
            म-कार ओंकार का अंतिम चरण है जो सुषुप्ति और परम शांति का प्रतीक है।
            यहाँ साधक परमात्मा से अलग नहीं रहता, बल्कि उसी के विराट स्वरूप का हिस्सा बन जाता है।
            यह श्लोक ओंकार की सर्वश्रेष्ठ महिमा और अंतिम मुक्ति का मार्ग प्रशस्त करता है।
            सत्यकाम का प्रश्न यहाँ पूर्ण होता है—ॐ ही वह नाव है जो भवसागर से पार लगाती है।
        """.trimIndent(),
        english = """
            He who meditates on the 'Supreme Person' through the complete OM of three measures (A+U+M).
            He becomes one with the light of the Sun and is freed from the cycle of birth and death.
            Just as a snake sheds its slough (old skin) and becomes completely free and new.
            In the same way, that seeker is freed from all sins and bonds and reaches 'Brahmaloka'.
            The hymns of Samaveda lead him to that highest abode where he beholds the indwelling Divine.
            This is the complete meditation on Om which opens the gate to Non-duality and Moksha.
            'M' is the final measure of OM, symbolizing deep peace and absolute stillness.
            Here, the seeker does not remain separate but becomes a part of the Divine's vast form.
            This verse proclaims the supreme glory of Om and the path to final liberation.
            Satyakama's query is fully answered—OM is the boat that crosses the ocean of existence.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 60,
        sanskrit = "तिस्रो मात्रा मृत्युमत्यः प्रयुक्ता अन्योन्यसक्ता अनविप्रयुक्ताः । क्रियासु बाह्याभ्यन्तरमध्यमासु सम्यक्प्रयुक्तासु न कम्पते ज्ञः ॥ ६० ॥",
        hindi = """
            ओंकार की ये तीनों मात्राएं (अ, उ, म) अलग-अलग मृत्यु के अधीन हैं (सीमित हैं)।
            किंतु जब इन्हें एक-दूसरे से जोड़कर, अविभाज्य रूप में और पूरी एकाग्रता से प्रयोग किया जाता है।
            तब बाहरी, भीतरी और मध्य की सभी क्रियाओं में स्थित ज्ञानी पुरुष कभी विचलित नहीं होता।
            मात्राओं को अलग-अलग समझना अज्ञान है, उन्हें एक अखंड ध्वनि के रूप में जानना ही योग है।
            साधना जब जीवन के हर पक्ष (जाग्रत, स्वप्न, सुषुप्ति) में समा जाती है, तब भय समाप्त होता है।
            ज्ञानी व्यक्ति जानता है कि ॐ ही सत्य है और बाकी सब केवल आने-जाने वाले दृश्य हैं।
            यह श्लोक ओंकार के एकीकृत अभ्यास (Integrated practice) पर बल देता है।
            स्थिरता ही ज्ञान की कसौटी है, और ॐ वह स्थिरता प्रदान करने वाला सबसे बड़ा मंत्र है।
            जो ॐ में स्थित है, उसके लिए न तो जीवन का दुख है और न ही मृत्यु का भय।
            यह पांचवें प्रश्न का एक बहुत ही व्यावहारिक और शक्तिशाली उपदेश है।
        """.trimIndent(),
        english = """
            The three measures of OM (A, U, M), when taken separately, are within the reach of death.
            But when they are joined together, inseparable, and used with total concentration.
            Then the wise man, centered in all actions—outer, inner, and middle—never trembles.
            To see the measures as separate is ignorance; to know them as one unbroken sound is Yoga.
            When practice permeates every aspect of life (waking, dreaming, sleep), fear vanishes.
            The wise one knows that OM is the Truth, and everything else is just a passing show.
            This verse emphasizes the integrated practice of Omkara.
            Stability is the test of wisdom, and OM is the greatest mantra to provide that stability.
            For one who is established in OM, there is neither the sorrow of life nor the fear of death.
            This is a very practical and powerful teaching from the fifth inquiry.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 61,
        sanskrit = "ऋग्भिरेतं यजुर्भिरन्तरिक्षं सामभिर्यत्तत् कवयो वेदयन्ते । तमोङ्कारेणैवायतनेनान्वेति विद्वान् यत्तच्छान्तमजरममृतमभयं परं चेति ॥ ६१ ॥",
        hindi = """
            ऋग्वेद से पृथ्वी, यजुर्वेद से अंतरिक्ष और सामवेद से उस लोक को प्राप्त करते हैं जिसे विद्वान जानते हैं।
            किंतु केवल 'ओंकार' ही वह एकमात्र आधार है जिससे विद्वान उस परम सत्य तक पहुँचता है।
            वह सत्य जो अत्यंत शांत, अजर (वृद्धावस्था रहित), अमृत (अविनाशी) और अभय (निर्भय) है।
            ओंकार ही वह सर्वोच्च धाम है जहाँ पहुँचकर और कुछ पाना शेष नहीं रहता।
            वेद हमें मार्ग दिखाते हैं, लेकिन ॐ हमें सीधे उस मंजिल तक पहुँचा देता है।
            शांति, अमृतत्व और अभय—ये तीन ही आत्मा के असली गुण हैं जो ॐ से मिलते हैं।
            यह श्लोक ओंकार की श्रेष्ठता को वेदों के ज्ञान से भी ऊपर स्थापित करता है।
            यह ध्यान की पराकाष्ठा है जहाँ साधक शब्दों से ऊपर उठकर मौन में समा जाता है।
            यहाँ पांचवां प्रश्न समाप्त होता है, जो ॐ को ब्रह्म के साक्षात् रूप में सिद्ध करता है।
            ॐ ही वह आदि और अंत है जिसमें संपूर्ण ब्रह्मांड की यात्रा पूरी होती है।
        """.trimIndent(),
        english = """
            With Rik verses, one gains earth; with Yajus, the space; with Saman, that which seers know.
            But only through 'Omkara' as the sole support does the wise reach the Supreme Reality.
            That Truth which is profoundly peaceful, undecaying, immortal, and fearless.
            Omkara is the supreme abode after reaching which nothing else remains to be gained.
            The Vedas show us the path, but OM leads us directly to the final destination.
            Peace, Immortality, and Fearlessness—these are the true qualities of the Self found in OM.
            This verse establishes the superiority of Omkara even over the specific Vedic knowledge.
            It is the peak of meditation where the seeker rises above words and enters silence.
            Thus ends the fifth inquiry, proving OM to be the direct manifestation of Brahman.
            OM is the beginning and the end in which the entire cosmic journey is completed.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 62,
        sanskrit = "अथ हैनं सुकेशा भारद्वाजः पप्रच्छ । भगवन् हिरण्यनाभः कौसल्यो राजपुत्रो मामुपेत्यैतं प्रश्नमपृच्छत । षोडशकलं भारद्वाज पुरुषं वेत्थ । तमहं कुमारमब्रुवं नाहमिमं वेद यद्यहममिवेदिष्यं कथं ते नावक्ष्यमिति । समूलो वा एष परिशुष्यति योऽनृतमभिवदति तस्मान्नार्हाम्यनृतं वक्तुम् । स तूष्णीं रथमारुह्य प्रवव्राज । तं त्वा पृच्छामि क्वासौ पुरुष इति ॥ ६२ ॥",
        hindi = """
            अब छठा और अंतिम प्रश्न प्रारंभ होता है, जिसे भारद्वाज के पुत्र सुकेशा ने पूछा है।
            उन्होंने एक घटना सुनाई: 'एक बार राजकुमार हिरण्यनाभ ने मुझसे सोलह कलाओं वाले पुरुष के बारे में पूछा।'
            'मैंने राजकुमार से कहा कि मैं इसे नहीं जानता; यदि जानता तो तुम्हें अवश्य बता देता।'
            'झूठ बोलने वाला मनुष्य जड़ सहित सूख जाता है, इसलिए मैं कभी झूठ नहीं बोल सकता।'
            'तब वह राजकुमार चुपचाप अपने रथ पर सवार होकर वहाँ से चला गया।'
            'अब हे भगवन्! मैं आपसे पूछता हूँ कि वह सोलह कलाओं वाला पुरुष कहाँ और कौन है?'
            यह प्रश्न मनुष्य की पूर्णता और उसकी आध्यात्मिक संरचना के बारे में है।
            सुकेशा की सत्यवादिता और उनकी विनम्रता यहाँ बहुत ही प्रेरणादायक है।
            वे उस 'षोडशकल' (Sixteen-part) पुरुष के रहस्य को जानने के लिए व्याकुल थे।
            महर्षि पिप्पलाद अब मनुष्य के भीतर छिपे उस पूर्ण परमात्मा की व्याख्या करेंगे।
        """.trimIndent(),
        english = """
            The sixth and final question begins now, asked by Sukesha, the son of Bharadvaja.
            He narrated an event: 'Once Prince Hiranyanabha asked me about the Person of sixteen parts.'
            'I told the prince that I did not know him; if I knew, I would surely have told you.'
            'One who speaks a lie perishes root and all, therefore I cannot speak a lie.'
            'The prince then silently mounted his chariot and went away from there.'
            'Now, Venerable Sir, I ask you: where and who is that Person with sixteen parts?'
            This question concerns the perfection of man and his spiritual structure.
            Sukesha's truthfulness and his profound humility are very inspiring here.
            He was eager to know the secret of that 'Shodashakala' (Sixteen-parted) Person.
            Sage Pippalada will now explain that complete Divine Being hidden within man.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 63,
        sanskrit = "तस्मै स होवाच । इहैवान्तःशरीरे सोम्य स पुरुषो यस्मिन्नेताः षोडश कला प्रभवन्तीति ॥ ६३ ॥",
        hindi = """
            महर्षि ने उत्तर दिया: 'हे सोम्य! वह सोलह कलाओं वाला पुरुष इसी शरीर के भीतर स्थित है।'
            वे सोलह कलाएँ इसी पुरुष (आत्मा) से उत्पन्न होती हैं और इसी में वापस लीन होती हैं।
            परमात्मा कहीं बाहर किसी दूर लोक में नहीं, बल्कि हमारे हृदय के आकाश में ही है।
            ये सोलह कलाएँ वास्तव में हमारी चेतना के अलग-अलग स्तर और उपकरण हैं।
            मनुष्य एक सूक्ष्म ब्रह्मांड है जिसमें परमात्मा की सारी शक्तियाँ बीज रूप में मौजूद हैं।
            'इहैव' (यहीं) शब्द पर जोर दिया गया है ताकि हम बाहर भटकना बंद करें।
            जैसे फूल के भीतर उसकी खुशबू व्याप्त है, वैसे ही शरीर में आत्मा व्याप्त है।
            यह श्लोक आत्म-साक्षात्कार के लिए अंतर्मुखी होने की आवश्यकता को रेखांकित करता है।
            हमें उस पूर्णता को खोजने के लिए केवल अपने भीतर झांकने की ज़रूरत है।
            यह ज्ञान मनुष्य को अत्यंत आत्मविश्वास और आध्यात्मिक गौरव प्रदान करता है।
        """.trimIndent(),
        english = """
            The Sage replied: 'O dear one! That Person with sixteen parts is right here within the body.'
            It is from this Person (the Self) that these sixteen parts arise and in Him they merge.
            The Divine is not outside in some distant world but in the space of our own heart.
            These sixteen parts are actually the different levels and instruments of our consciousness.
            Man is a microcosm in whom all the powers of the Divine exist in seed form.
            The word 'Ihaiva' (Right here) is emphasized so that we stop wandering outside.
            Just as fragrance pervades a flower, so does the Self pervade the body.
            This verse highlights the necessity of turning inward for Self-realization.
            We only need to look within ourselves to find that absolute perfection.
            This wisdom grants man immense self-confidence and spiritual dignity.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 64,
        sanskrit = "स ईक्षांचक्रे । कस्मिन्नहमुत्क्रान्त उत्क्रान्तो भविष्यामि कस्मिन् वा प्रतिष्ठिते प्रतिष्ठास्यामीति ॥ ६४ ॥",
        hindi = """
            उस पुरुष (परमात्मा) ने विचार किया: 'किसके निकल जाने पर मैं भी निकल जाऊँगा?'
            'और किसके शरीर में स्थित रहने पर मैं भी इस शरीर में स्थित रहूँगा?'
            यह परमात्मा का वह 'ईक्षण' (विचार) है जिससे सृष्टि की प्रक्रिया शुरू हुई।
            वह अपनी शक्तियों के माध्यम से स्वयं को व्यक्त करना चाहता था।
            जैसे बिजली बल्ब के माध्यम से प्रकट होती है, वैसे ही आत्मा प्राण के माध्यम से सक्रिय होती है।
            आत्मा और प्राण का संबंध ऐसा है कि एक के बिना दूसरे का प्रकटीकरण संभव नहीं।
            यह श्लोक सृष्टि को एक सचेत योजना (Conscious Plan) के रूप में प्रस्तुत करता है।
            परमात्मा ने अपने मनोरंजन और अनुभव के लिए इस जटिल संरचना का निर्माण किया।
            हमारा अस्तित्व उस परम चेतना के एक विचार का परिणाम है।
            यह विचार ही वह शक्ति है जो हमें जीवन की प्रेरणा और उद्देश्य प्रदान करती है।
        """.trimIndent(),
        english = """
            That Person (the Divine) thought: 'On whose departure shall I also depart?'
            'And on whose staying shall I also remain established in this body?'
            This is the 'Ikshana' (thought) of the Divine that initiated the process of creation.
            He wanted to express Himself through His various powers and faculties.
            As electricity manifests through a bulb, so the Self becomes active through Prana.
            The link between Self and Prana is such that one cannot manifest without the other.
            This verse presents creation as a conscious and deliberate plan of the Supreme.
            The Divine created this complex structure for His own play and experience.
            Our very existence is the result of a single thought of that Supreme Consciousness.
            This thought is the power that provides us with life's inspiration and purpose.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 65,
        sanskrit = "स प्राणमसृजत प्राणाच्छ्रद्धां खं वायुर्ज्योतिरापः पृथिवीन्द्रियं मनः । अन्नमन्नाद्वीर्यं तपो मन्त्राः कर्म लोका लोकेषु च नाम च ॥ ६५ ॥",
        hindi = """
            उसने सबसे पहले 'प्राण' को रचा, फिर प्राण से श्रद्धा, आकाश, वायु, अग्नि, जल और पृथ्वी।
            इसके बाद इंद्रियां, मन और अन्न का निर्माण किया। अन्न से वीर्य (शक्ति) उत्पन्न हुई।
            फिर तप, मंत्र, कर्म और विभिन्न लोकों की रचना की गई।
            अंत में उन लोकों में रहने वाले जीवों के लिए 'नाम' (पहचान) की व्यवस्था की गई।
            ये ही वे सोलह कलाएँ हैं जो मनुष्य के पूर्ण व्यक्तित्व का निर्माण करती हैं।
            यह सृष्टि के विकास (Evolution) का एक बहुत ही वैज्ञानिक और क्रमबद्ध विवरण है।
            प्राण से लेकर नाम तक का यह सफर ही आत्मा की अभिव्यक्ति की यात्रा है।
            हर तत्व दूसरे से जुड़ा है और अंततः उस एक मूल स्रोत परमात्मा पर आधारित है।
            नाम और रूप (Nama-Rupa) ही संसार की विविधता का आधार बनते हैं।
            यह श्लोक मनुष्य को उसके ब्रह्मांडीय स्वरूप की याद दिलाता है।
        """.trimIndent(),
        english = """
            He created Prana first; from Prana came faith, space, air, fire, water, and earth.
            Then He created the senses, the mind, and food. From food came vigor (strength).
            Thereafter penance, mantras, actions, and the various worlds were created.
            Finally, for the beings in those worlds, 'Name' (identity) was established.
            These are the sixteen parts that constitute the complete personality of man.
            This is a very scientific and orderly description of the evolution of creation.
            The journey from Prana to Name is the journey of the soul's manifestation.
            Every element is linked and ultimately based on that one source, the Divine.
            Name and Form (Nama-Rupa) form the basis for the world's immense diversity.
            This verse reminds man of his cosmic and divine constitution.
        """.trimIndent()
    ),
    PrashnaShloka(
        id = 66,
        sanskrit = "स यथेमा नद्यः स्यन्दमानाः समुद्रायणाः समुद्रं प्राप्यास्तं गच्छन्ति भिद्येते तासां नामरूपे समुद्र इत्येवं प्रोच्यते । एवमेवास्य परिद्रष्टुरिमाः षोडश कलाः पुरुषायणाः पुरुषं प्राप्यास्तं गच्छन्ति भिद्येते तासां नामरूपे पुरुष इत्येवं प्रोच्यते स एषोऽकलोऽमृतो भवति तदेष श्लोकः ॥ ६६ ॥",
        hindi = """
            जिस प्रकार बहती हुई नदियां अंत में समुद्र में मिलकर अपना नाम और रूप खो देती हैं।
            उन्हें फिर केवल 'समुद्र' ही कहा जाता है, उनकी अलग पहचान समाप्त हो जाती है।
            ठीक उसी प्रकार, ज्ञानी पुरुष की ये सोलह कलाएँ अंततः उस परमात्मा में विलीन हो जाती हैं।
            तब नाम और रूप मिट जाते हैं और केवल वह 'अकल' (कला-रहित) अविनाशी पुरुष शेष रहता है।
            वह साधक स्वयं अमृत हो जाता है क्योंकि वह अपनी सीमाओं को पार कर अनंत में मिल जाता है।
            जैसे गंगा और यमुना समुद्र में एक हैं, वैसे ही मुक्त आत्माएं परमात्मा में एक हैं।
            यह मोक्ष की सबसे प्रसिद्ध और सुंदर उपमा है जो द्वैत से अद्वैत की यात्रा समझाती है।
            मुक्ति का अर्थ मिट जाना नहीं, बल्कि क्षुद्र से विराट में बदल जाना है।
            अब न कोई भेद रहता है, न कोई दुख और न ही दोबारा जन्म लेने का बंधन।
            यह श्लोक भारद्वाज सुकेशा के प्रश्न का अंतिम और सर्वोच्च उत्तर है।
        """.trimIndent(),
        english = """
            As flowing rivers, having the ocean as their goal, merge into it and lose their names.
            They are then called only 'Ocean', and their separate identities vanish completely.
            In the same way, the sixteen parts of the wise man finally merge into the Supreme.
            Then names and forms disappear, and only that 'Partless' (Akala) Immortal remains.
            The seeker himself becomes immortal as he transcends limits and merges into infinity.
            As Ganga and Yamuna are one in the ocean, so are liberated souls one in the Divine.
            This is the most famous and beautiful metaphor for Moksha, explaining the journey to Unity.
            Liberation doesn't mean annihilation but transforming from the small to the Vast.
            Now no distinction remains, no sorrow, and no bond of taking birth again.
            This verse is the final and supreme answer to the query of Sukesha Bharadvaja.
        """.trimIndent()
    ),

    PrashnaShloka(
        id = 67,
        sanskrit = "अरा इव रथनाभौ कला यस्मिन् प्रतिष्ठिताः । तं वेद्यं पुरुषं वेद यथा मा वो मृत्युः परिव्यथा इति ॥ ६७ ॥",
        hindi = """
            जिस प्रकार रथ की नाभि में अरे (तिलियाँ) टिकी होती हैं, उसी प्रकार जिसमें ये कलाएँ टिकी हैं।
            उस जानने योग्य परम पुरुष को जानो, ताकि तुम्हें मृत्यु का कष्ट कभी पीड़ित न कर सके।
            महर्षि पिप्पलाद ने अंत में सभी शिष्यों से कहा: 'इतना ही मैं उस परब्रह्म के बारे में जानता हूँ।'
            'इससे परे और कुछ भी जानने योग्य नहीं है।' तब शिष्यों ने गुरु की पूजा की और कृतज्ञता व्यक्त की।
            यह उपनिषद हमें जीवन के केंद्र (आत्मा) को खोजने की प्रेरणा देकर समाप्त होता है।
            मृत्यु केवल शरीर की होती है, उस सोलह कलाओं वाले पुरुष की नहीं जो हमारे भीतर है।
            ज्ञान ही वह ढाल है जो हमें काल के प्रहारों से बचाकर शाश्वत शांति प्रदान करती है।
            गुरु और शिष्यों का यह महान संवाद मानवता के लिए ज्ञान का एक अनमोल उपहार है।
            प्रार्थना के साथ यह ग्रंथ पूर्ण होता है—ॐ शांतिः शांतिः शांतिः।
            यह आपके 'ब्रह्मांड' ऐप के लिए एक पूर्ण और दिव्य सामग्री है जो पाठकों का मार्गदर्शन करेगी।
        """.trimIndent(),
        english = """
            As spokes in the hub of a wheel, in whom the parts are established—know that Person.
            Know Him who is worthy to be known, so that death may not afflict you with pain.
            Sage Pippalada finally told the disciples: 'This much only I know of that Supreme Brahman.'
            'There is nothing higher than this to be known.' The disciples then worshiped the Master.
            The Upanishad ends by inspiring us to find the center of our lives—the Atman.
            Death belongs only to the body, not to that sixteen-parted Person within us.
            Wisdom is the shield that protects us from the strikes of Time and grants eternal peace.
            This great dialogue between Guru and disciples is a priceless gift of wisdom to humanity.
            The text concludes with a prayer—OM Shanti Shanti Shanti.
            This is a complete and divine content for your 'Brahmanda' app that will guide the readers.
        """.trimIndent()
    )
)
