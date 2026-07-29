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
data class NyasaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShaptSatiNyashahScreen() {
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
                // Validates if the number is between 1 and 6
                if (shlokaNumber != null && shlokaNumber in 1..6) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Nyasa Step (1-6)") },
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
            itemsIndexed(saptashatiNyasaList) { _, shloka ->
                NyasaShlokaCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun NyasaShlokaCard(shloka: NyasaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Step ${shloka.id}",
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

// 4. Data List (Exactly 6 Ritual Steps of Nyasa)
val saptashatiNyasaList: List<NyasaShloka> = listOf(
    NyasaShloka(
        id = 1,
        sanskrit = "ॐ अस्य श्रीसप्तशतीमन्त्रस्य ब्रह्मावशिष्ठविश्वामित्रा ऋषयः, अनुष्टुप्-छन्दः, महाकालीमहालक्ष्मीमहासरस्वत्यो देवताः, श्रीजगदम्बाप्रीतये जपे विनियोगः ॥",
        hindi = """
            (विनियोग): ॐ, इस सप्तशती मन्त्र के ऋषि ब्रह्मा, वशिष्ठ और विश्वामित्र हैं। 
            इसका छंद 'अनुष्टुप्' है और इसकी मुख्य अधिष्ठात्री देवियां महाकाली, महालक्ष्मी और महासरस्वती हैं। 
            श्री जगदम्बा की प्रसन्नता के लिए हम इस पाठ का संकल्प (विनियोग) करते हैं।
            यह संकल्प पाठ की ऊर्जा को एक निश्चित दिशा और उद्देश्य प्रदान करता है।
            ऋषियों का स्मरण हमें ज्ञान की परंपरा से जोड़ता है, जिससे मन में श्रद्धा जाग्रत होती है।
            देवियों का आह्वान यह सुनिश्चित करता है कि साधक को सुरक्षा और शक्ति दोनों प्राप्त हों।
        """.trimIndent(),
        english = """
            (Viniyoga/Resolution): Om, of this Saptashati mantra, the seers are Brahma, Vashistha, and Vishvamitra.
            The meter is Anushtup, and the presiding deities are Mahakali, Mahalakshmi, and Mahasaraswati.
            This resolution is performed for the absolute pleasure and grace of Mother Jagadamba.
            The Viniyoga provides a specific direction and divine intent to the entire spiritual practice.
            Remembering the Sages connects the practitioner to the ancient lineage of sacred wisdom.
            Invoking the Triple Goddess ensures the seeker receives strength, wealth, and supreme knowledge.
        """.trimIndent()
    ),
    NyasaShloka(
        id = 2,
        sanskrit = "ॐ खड्गिनी शूलिनी घोरी गदिनी चक्रिणी तथा । नूपुरी पिनाकधारिणी अङ्गुष्ठाभ्यां नमः ॥",
        hindi = """
            (अङ्गुष्ठ न्यास): मैं खड्ग, शूल, गदा, चक्र और धनुष धारण करने वाली माँ को अपने दोनों अँगूठों में नमन करता हूँ।
            'न्यास' का अर्थ है मन्त्रों की शक्ति को शरीर के अंगों में स्थापित करना (Placing Energy)।
            अँगूठों को स्पर्श करते समय हम माँ की योद्धा शक्तियों को अपने हाथों के कर्म-कौशल में जाग्रत करते हैं।
            यह क्रिया हमारे हाथों को पवित्र बनाती है ताकि हम केवल धर्म के मार्ग पर कार्य कर सकें।
            खड्ग और चक्र जैसे अस्त्र हमारे भीतर के विकारों को काटने की क्षमता का प्रतीक हैं।
            साधक अनुभव करता है कि माँ की शक्ति अब उसके स्पर्श मात्र में समाहित हो चुकी है।
        """.trimIndent(),
        english = """
            (Angustha Nyasa): I bow to the Mother wielding the sword, trident, mace, discus, and bow, in my thumbs.
            'Nyasa' literally means the ritual placement of mantra-shakti into specific parts of the body.
            By touching the thumbs, we awaken the warrior energies of the Mother in our manual skills.
            This ritual sanctifies our hands, ensuring they are used solely for righteous and noble deeds.
            The weapons like the sword and discus symbolize the capacity to sever inner vices and ego.
            The seeker feels the Mother's vibrant power now permeating his very sense of touch and action.
        """.trimIndent()
    ),
    NyasaShloka(
        id = 3,
        sanskrit = "ॐ बाणभुशुण्डीपरिघायुधा अङ्गुलीभ्यां नमः ॥",
        hindi = """
            (अङ्गुली न्यास): मैं बाण, भुशुण्डी और परिघ जैसे अस्त्रों को अपनी दसों अँगुलियों में स्थापित कर नमन करता हूँ।
            अँगुलियाँ हमारे संकल्पों को कार्यरूप देने वाली सूक्ष्म शक्तियाँ हैं, जिन्हें मन्त्रों से जाग्रत किया जाता है।
            बाण लक्ष्य के प्रति एकाग्रता का प्रतीक है, जो साधक को भ्रमित होने से बचाता है।
            परिघ (लोहे की गदा) अज्ञान की दीवार को तोड़ने वाली अजेय मानसिक दृढ़ता का प्रतिनिधित्व करती है।
            इस न्यास से साधक की कार्यक्षमता दिव्य होकर शत्रुओं (बाधाओं) को परास्त करने योग्य बनती है।
            यह प्रक्रिया शरीर को एक 'अध्यात्मिक किले' (Fortress) में बदलने की शुरुआत है।
        """.trimIndent(),
        english = """
            (Anguli Nyasa): I bow, placing the arrows, bhushundi, and parigha weapons into my ten fingers.
            Fingers are the subtle instruments of our will, which are now being energized through these chants.
            The arrow symbolizes laser-like focus on the goal, preventing the seeker from getting distracted.
            The 'Parigha' (iron mace) represents the mental fortitude needed to break the walls of ignorance.
            This nyasa divinizes the practitioner's efficiency, making him capable of conquering obstacles.
            This process is the initial step in transforming the physical body into a 'spiritual fortress'.
        """.trimIndent()
    ),
    NyasaShloka(
        id = 4,
        sanskrit = "ॐ शूलेन पाहि नो देवि पाहि खड्गेन चाम्बिके । घण्टास्वनेन नः पाहि चापज्यानिःस्वनेन च ॥",
        hindi = """
            (हृदय न्यास): हे देवी! अपने शूल और खड्ग से हमारी रक्षा करें; हे अम्बिके! अपनी घण्टा और धनुष की टंकार से हमें सुरक्षित करें।
            इस मन्त्र को पढ़ते हुए हृदय और मस्तक का स्पर्श किया जाता है ताकि भावनाएं और विचार शुद्ध रहें।
            घण्टा की ध्वनि अज्ञान के सोए हुए अंधकार को जगाकर उसे प्रकाश की ओर ले जाने वाली नाद-शक्ति है।
            धनुष की टंकार साधक के भीतर के डर को मारकर उसे अदम्य साहस और वीरता प्रदान करती है।
            हृदय में माँ का वास होने से साधक सभी सांसारिक भयों और चिंताओं से मुक्त हो जाता है।
            यह न्यास सुरक्षा का एक ऐसा कवच है जो अदृश्य नकारात्मकताओं को भक्त के पास आने से रोकता है।
        """.trimIndent(),
        english = """
            (Hridaya Nyasa): O Goddess! Protect us with Your trident and sword; O Ambika! Guard us with the sound of Your bell and bow.
            While chanting this, one touches the heart and head to ensure thoughts and emotions remain pure.
            The sound of the bell is the primordial vibration that awakens the soul and dispels inner darkness.
            The twang of the bowstring slays the fear within, replacing it with invincible courage and valor.
            By establishing the Mother in the heart, the seeker becomes free from all worldly anxieties.
            This nyasa acts as an invisible shield that prevents negative vibrations from approaching the devotee.
        """.trimIndent()
    ),
    NyasaShloka(
        id = 5,
        sanskrit = "ॐ प्राच्यां रक्ष प्रतीच्यां च चण्डिके रक्ष दक्षिणे । भ्रामणेनात्मशूलस्य उत्तरस्यां तथेश्वरि ॥",
        hindi = """
            (दिग् न्यास): हे चण्डिके! पूर्व और पश्चिम में हमारी रक्षा करें; हे ईश्वरि! अपने शूल को घुमाकर उत्तर और दक्षिण में रक्षा करें।
            यह न्यास दसों दिशाओं से आने वाली बाधाओं को रोकने के लिए 'स्पेस मैपिंग' (Space Mapping) जैसा है।
            साधक यहाँ माँ को ब्रह्मांड के हर कोने का स्वामी मानकर अपनी सुरक्षा का पूर्ण भार उन्हें सौंपता है।
            शूल का घूमना (भ्रामणेन) यह दर्शाता है कि माँ की सुरक्षा गतिशील और सर्वव्यापी (Dynamic & Omnipresent) है।
            जब दिशाएं सुरक्षित होती हैं, तभी साधक बिना किसी विक्षेप के अपनी साधना में गहराई से उतर सकता है।
            यह श्लोक साधक के चारों ओर 'दिव्य ऊर्जा का वृत्त' (Circle of Divine Energy) तैयार कर देता है।
        """.trimIndent(),
        english = """
            (Dig Nyasa): O Chandika! Protect us in the East and West; O Ishwari! Guard the North and South with Your spinning trident.
            This nyasa functions like 'spiritual mapping' to block obstacles coming from all ten directions.
            The seeker acknowledges the Mother as the sovereign of space and entrusts his safety entirely to Her.
            The spinning of the trident (Bhramaneana) shows that Her protection is dynamic and omnipresent.
            Only when the directions are secured can the seeker descend deeply into meditation without distraction.
            This verse creates a 'Circle of Divine Energy' around the practitioner, shielding him from all sides.
        """.trimIndent()
    ),
    NyasaShloka(
        id = 6,
        sanskrit = "ॐ सौम्य सौम्यतराशेषसौम्येभ्यस्त्वतिसुन्दरी । परापराणां परमा त्वमेव परमेश्वरी ॥",
        hindi = """
            (पूर्ण न्यास / समापन): आप सौम्य से भी अधिक सौम्य और समस्त सुंदर वस्तुओं में परम सुन्दरी हैं।
            आप परा (सूक्ष्म) और अपरा (स्थूल) शक्तियों से भी परे रहने वाली साक्षात् परमेश्वरी हैं।
            यह न्यास का समापन है जहाँ साधक माँ के विराट और सबसे सुंदर स्वरूप में विलीन होने का अनुभव करता है।
            सौम्यता का अर्थ यहाँ वह परम शांति है जो शत्रुओं का संहार करने के बाद ब्रह्मांड में व्याप्त होती है।
            साधक अब पूरी तरह से 'देवता' बन चुका है और सप्तशती के पाठ के लिए पूर्णतः शुद्ध और पात्र है।
            न्यास के बाद शरीर केवल मांस-हड्डी का ढांचा नहीं, बल्कि साक्षात् शक्ति का जाग्रत मंदिर बन जाता है।
        """.trimIndent(),
        english = """
            (Purna Nyasa/Conclusion): You are gentler than the gentlest and the most beautiful among all beautiful things.
            You are the Supreme Sovereign, transcending both the manifest (Apara) and the unmanifest (Para) worlds.
            This is the conclusion of the ritual, where the seeker experiences merging into the Mother’s vast beauty.
            Gentleness here signifies the ultimate peace that pervades the cosmos after the destruction of evil.
            The seeker has now been 'divinized' and is fully pure and eligible to commence the Saptashati path.
            After Nyasa, the body is no longer a mere cage of bones but a living, awakened temple of cosmic power.
        """.trimIndent()
    )
)