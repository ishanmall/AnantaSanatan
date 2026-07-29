package com.sanatangyansagar.ui.screens.DurgaMaa

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

// 1. Data Model
data class RatriSuktaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RigVedoktamRatriSuktamScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 8
                if (shlokaNumber != null && shlokaNumber in 1..8) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-8)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        // Shloka List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(ratriSuktaList) { _, shloka ->
                RatriSuktaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun RatriSuktaCard(shloka: RatriSuktaShloka) {
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
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 22.sp)
        }
    }
}

// 4. Data List (Exactly 8 Shlokas of Rigvedoktam Ratri Suktam)
val ratriSuktaList: List<RatriSuktaShloka> = listOf(
    RatriSuktaShloka(
        id = 1,
        sanskrit = "रात्री व्यख्यदायती पुरुत्रा देव्यक्षभिः । विश्वा अधि श्रियोऽधित ॥ १ ॥",
        hindi = """
            हे दिव्य रात्रि! आप सब ओर व्याप्त होकर अपने नक्षत्र रूपी अनगिनत नेत्रों से संसार को देखती हैं।
            आपने इस संपूर्ण जगत की शोभा और ऐश्वर्य को अपने भीतर धारण कर लिया है।
            रात्रि यहाँ केवल अंधकार नहीं, बल्कि वह दिव्य चेतना है जो थके हुए जीवों को अपनी गोद में सुलाती है।
            माँ का यह रूप बताता है कि विश्राम भी उतना ही पवित्र है जितना कि कर्म।
            सितारों से भरी रात हमें यह सिखाती है कि घोर अंधकार में भी प्रकाश के बिंदु हमेशा विद्यमान रहते हैं।
            साधक माँ रात्रि से प्रार्थना करता है कि वे उसके जीवन के संकटों को शांत कर उसे शांति प्रदान करें।
        """.trimIndent(),
        english = """
            O Divine Night! You manifest everywhere, beholding the universe with Your countless starry eyes.
            You have assumed and hold within Yourself the absolute beauty and opulence of the entire world.
            Night here is not mere darkness, but the Divine Mother providing a sanctuary for weary souls.
            This form of the Mother signifies that rest is as sacred and essential as action itself.
            The starry night teaches us that even in the deepest darkness, points of light are always present.
            The seeker implores Mother Night to soothe his life's turmoils and grant him supreme peace.
        """.trimIndent()
    ),
    RatriSuktaShloka(
        id = 2,
        sanskrit = "ओर्वप्रा अमर्त्या निवतो देवीदुद्वतः । ज्योतिषा बाधते तमः ॥ २ ॥",
        hindi = """
            अविनाशी देवी रात्रि ने अपनी शक्ति से पृथ्वी की घाटियों, ऊँचाइयों और समस्त दिशाओं को भर दिया है।
            वे अपने दिव्य प्रकाश (नक्षत्रों और चन्द्रमा) के माध्यम से गहन अंधकार का नाश करती हैं।
            यह श्लोक अज्ञान रूपी अंधकार और ज्ञान रूपी प्रकाश के बीच के शाश्वत संतुलन को दर्शाता है।
            माँ रात्रि केवल सुलाती नहीं हैं, बल्कि वे रात के एकांत में आत्म-चिंतन का प्रकाश भी देती हैं।
            जब बाहरी दुनिया शांत होती है, तब माँ की ज्योति साधक के हृदय में सत्य का मार्ग प्रकाशित करती है।
            वे सर्वत्र व्याप्त हैं, यानी कोई भी स्थान उनकी ममतामयी और सुरक्षात्मक दृष्टि से बाहर नहीं है।
        """.trimIndent(),
        english = """
            The immortal Goddess Night has filled the valleys, the heights, and all directions with Her power.
            She ruthlessly drives away the dense darkness with Her divine radiance of stars and the moon.
            This verse illustrates the eternal balance between the darkness of ignorance and the light of wisdom.
            Mother Night does not just bring sleep; she offers the light of self-reflection in the silence of night.
            When the external world goes quiet, Her light illuminates the path of truth within the seeker's heart.
            She is omnipresent, meaning no corner of existence is outside Her loving and protective gaze.
        """.trimIndent()
    ),
    RatriSuktaShloka(
        id = 3,
        sanskrit = "निरु स्वसारमस्कृतोषसं देव्यायती । अपेदु हासते तमः ॥ ३ ॥",
        hindi = """
            अपनी बहन उषा (प्रातःकाल की देवी) के आने पर यह देवी रात्रि स्वयं का विस्तार कम कर लेती हैं।
            उनके आते ही अंधकार स्वतः ही गायब हो जाता है और सृष्टि में नई ऊर्जा का संचार होता है।
            उषा और रात्रि का यह संबंध सृष्टि के चक्रीय स्वभाव (Cyclic Nature) का एक सुंदर रूपक है।
            दुख के बाद सुख और अज्ञान के बाद ज्ञान का आना निश्चित है, यही माँ का दिव्य विधान है।
            रात्रि हमें वह गहराई और शांति देती है जो उषा की चमक को और भी मूल्यवान बना देती है।
            यह श्लोक हमें सिखाता है कि हर अंत एक नई और उज्ज्वल शुरुआत की केवल एक तैयारी मात्र है।
        """.trimIndent(),
        english = """
            The Goddess Night makes way for Her sister Usha (the Dawn), withdrawing Her dark mantle.
            Upon Her arrival, the darkness spontaneously flees, and fresh energy begins to flow into creation.
            This relationship between Dawn and Night is a beautiful metaphor for the cyclic nature of existence.
            Joy following sorrow and wisdom following ignorance is the absolute divine law of the Mother.
            Night provides the depth and stillness that make the brilliance of the Dawn truly precious.
            This verse teaches us that every ending is merely a preparation for a new and radiant beginning.
        """.trimIndent()
    ),
    RatriSuktaShloka(
        id = 4,
        sanskrit = "सा नो अद्य यस्यास्ते नि तेयामन्नविक्ष्महि । वृक्षे न वसतयः खगः ॥ ४ ॥",
        hindi = """
            हे माँ रात्रि! आप आज हम पर वैसी ही कृपा करें, जिससे हम आपके सान्निध्य में सुरक्षित विश्राम पा सकें।
            जैसे पक्षी शाम होने पर अपने घोंसलों (पेड़ों) में निश्चिंत होकर लौट आते हैं और चैन से सोते हैं।
            यह श्लोक पूर्ण सुरक्षा और निर्भरता का भाव जाग्रत करता है जो एक बच्चा अपनी माँ के प्रति रखता है।
            संसार की भागदौड़ के बाद माँ की शरण ही वह इकलौता घोंसला है जहाँ सच्ची शांति संभव है।
            पक्षियों का उदाहरण हमें याद दिलाता है कि हम सब प्रकृति की संतान हैं और माँ हमारा घर हैं।
            साधक यहाँ अपनी सभी चिंताओं को माँ के चरणों में छोड़कर गहरी निद्रा और शांति की याचना करता है।
        """.trimIndent(),
        english = """
            O Mother Night! Bestow Your grace upon us today, that we may find secure rest in Your proximity.
            Let us rest just as birds return to their nests in the trees at dusk, sleeping in total confidence.
            This verse awakens a sense of absolute safety and dependency, like that of a child toward its mother.
            After the world's chaos, the Mother's refuge is the only 'nest' where true tranquility is possible.
            The example of birds reminds us that we are all children of nature, and the Mother is our home.
            The seeker surrenders all his anxieties at Her feet, pleading for deep slumber and inner silence.
        """.trimIndent()
    ),
    RatriSuktaShloka(
        id = 5,
        sanskrit = "नि ग्रामासो अविक्षत नि पद्वन्तो नि पक्षिणः । नि श्येनासश्चिदर्भ्यः ॥ ५ ॥",
        hindi = """
            गाँव के लोग, पैदल चलने वाले यात्री, पशु-पक्षी और यहाँ तक कि शिकारी बाज भी विश्राम पा चुके हैं।
            हे रात्रि देवी! आपकी गोद में पूरी सृष्टि एक समान होकर शांतिपूर्वक सो रही है।
            माँ की दृष्टि में कोई बड़ा या छोटा नहीं है; वे राजा और रंक, शिकारी और शिकार सबको एक जैसी नींद देती हैं।
            यह श्लोक ब्रह्मांडीय एकता (Universal Unity) का प्रतीक है जहाँ सब कुछ शांत होकर एक में मिल जाता है।
            रात्रि वह समय है जब अहंकार मिट जाता है और जीव अपनी मूल जड़ों (ईश्वर) की ओर लौटता है।
            सभी का विश्राम करना माँ की उस विराट शक्ति को दर्शाता है जो पूरे विश्व का भरण-पोषण करती है।
        """.trimIndent(),
        english = """
            Villagers, travelers on foot, animals, birds, and even the fierce hawks have gone to rest.
            O Goddess Night! In Your lap, the entire creation sleeps peacefully as one unified whole.
            In the Mother's eyes, no one is superior; she grants the same sleep to kings, beggars, predators, and prey.
            This verse symbolizes universal unity, where everything becomes still and merges into the One.
            Night is the time when ego dissolves, and the soul returns toward its primordial roots (God).
            The resting of all beings highlights the Mother's vast power that sustains and nourishes the entire world.
        """.trimIndent()
    ),
    RatriSuktaShloka(
        id = 6,
        sanskrit = "यावया वृक्यं वृकं यवय स्तेनमूर्म्ये । अथा नः सुतरा भव ॥ ६ ॥",
        hindi = """
            हे माँ रात्रि! आप भेड़िये, भेड़िइन और चोरों (नकारात्मक शक्तियों) को हमसे दूर रखें।
            हमारे लिए सुखपूर्वक पार होने वाली बनें और हमें इस रात्रि के सागर से सुरक्षित निकालें।
            भेड़िया और चोर यहाँ हमारे मन के उन विकारों (क्रोध, लोभ, ईर्ष्या) के प्रतीक हैं जो शांति चुरा लेते हैं।
            साधक माँ से प्रार्थना करता है कि सोते समय भी उसकी चेतना बुरी प्रवृत्तियों से सुरक्षित रहे।
            'सुतरा' का अर्थ है वह नाव जो हमें भवसागर के थपेड़ों से बचाकर किनारे तक पहुँचा दे।
            यह श्लोक आध्यात्मिक और भौतिक—दोनों प्रकार की सुरक्षा का एक शक्तिशाली आह्वान है।
        """.trimIndent(),
        english = """
            O Mother Night! Keep the wolves, the she-wolves, and the thieves (negative forces) far away from us.
            Be easy for us to cross over, and carry us safely through the ocean of this night.
            Wolves and thieves here represent the mental vices (anger, greed, jealousy) that steal our peace.
            The seeker prays that even while sleeping, his consciousness remains protected from negative tendencies.
            'Sutara' implies the boat that saves us from the waves of existence and carries us to the shore.
            This verse is a powerful invocation for both spiritual and physical safety and divine protection.
        """.trimIndent()
    ),
    RatriSuktaShloka(
        id = 7,
        sanskrit = "उप मा पेपिशत्तमः कृष्णं व्यक्तमस्थित । उप ऋणैव यातय ॥ ७ ॥",
        hindi = """
            हे माँ! यह काला और घना अंधकार मेरे पास आ गया है, जिसने सब कुछ स्पष्ट रूप से ढक लिया है।
            हे देवी! आप इसे उसी प्रकार दूर करें जैसे सूर्य उदय होकर हमारे सभी ऋणों (कर्जों) को समाप्त कर देता है।
            अंधकार अविद्या और भ्रम का प्रतीक है जो हमारी बुद्धि को सत्य देखने से पूरी तरह रोकता है।
            ऋण का अर्थ है हमारे पिछले जन्मों के कर्मों का बोझ जो हमें अज्ञान के अंधेरे में बांधे रखता है।
            साधक माँ से याचना करता है कि वे अज्ञान के इस काले परदे को फाड़कर उसे आत्म-साक्षात्कार कराएं।
            जैसे ऋण मुक्त होने पर मनुष्य हल्का महसूस करता है, वैसे ही अज्ञान हटने पर आत्मा स्वतंत्र हो जाती है।
        """.trimIndent(),
        english = """
            O Mother! This black and dense darkness has approached me, clearly enveloping everything.
            O Goddess! Remove it just as the rising sun wipes away all our debts and burdens.
            Darkness symbolizes nescience and delusion that completely block our intellect from seeing the Truth.
            'Debt' (Rina) refers to the burden of past karmas that keep us bound in the shadows of ignorance.
            The seeker implores the Mother to tear through this black veil of ignorance and grant self-realization.
            Just as a debt-free person feels light, the soul becomes free and liberated when ignorance is removed.
        """.trimIndent()
    ),
    RatriSuktaShloka(
        id = 8,
        sanskrit = "उप ते गा इवाकरं वृणीष्व दुहितर्दिवः । रात्रि स्तोमं न जिग्युषे ॥ ८ ॥",
        hindi = """
            हे आकाश की पुत्री रात्रि देवी! मैंने यह स्तुति उसी प्रकार आपको अर्पित की है जैसे कोई ग्वाला अपनी गायें समर्पित करता है।
            हे माँ! आप मेरी इस भेंट को स्वीकार करें और शत्रुओं पर विजय पाने वाले योद्धा की तरह मुझ पर प्रसन्न हों।
            यह इस सुक्त का समापन है जहाँ साधक अपनी वाणी और श्रद्धा को माँ के चरणों में समर्पित कर देता है।
            गायों का उदाहरण सादगी और जीवन की सबसे कीमती ऊर्जा के अर्पण का प्रतीक है।
            ईश्वर हमारी बड़ी-बड़ी चीजों के नहीं, बल्कि हमारे हृदय के सच्चे और सरल भावों के भूखे होते हैं।
            यह प्रार्थना हमें माँ के साथ एक अत्यंत व्यक्तिगत और प्रेमपूर्ण संबंध बनाने की प्रेरणा देती है।
            ॥ इस प्रकार ऋग्वेदोक्त रात्रि सूक्त पूर्ण हुआ ॥
        """.trimIndent(),
        english = """
            O Goddess Night, Daughter of the Sky! I have offered this praise to You like a cowherd offering his kine.
            O Mother! Accept this gift of mine and be pleased with me like a warrior who has conquered his foes.
            This is the conclusion of the hymn where the seeker surrenders his speech and faith at the Mother's feet.
            The example of cows symbolizes the offering of simplicity and the most precious energy of one's life.
            God hungers not for grand possessions, but for the true and simple emotions of the human heart.
            This prayer inspires us to cultivate an extremely personal and loving relationship with the Mother.
            || Thus ends the Rigvedoktam Ratri Suktam ||
        """.trimIndent()
    )
)