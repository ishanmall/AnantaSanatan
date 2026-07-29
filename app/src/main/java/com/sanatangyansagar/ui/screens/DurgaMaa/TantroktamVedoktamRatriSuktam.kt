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
data class TantroktamRatriShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TantroktamRatriSuktamScreen() {
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
                // Validates if the number is between 1 and 9
                if (shlokaNumber != null && shlokaNumber in 1..9) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-9)") },
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
            itemsIndexed(tantroktamRatriList) { _, shloka ->
                TantroktamRatriCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun TantroktamRatriCard(shloka: TantroktamRatriShloka) {
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

// 4. Data List (Exactly 9 Shlokas of Tantroktam Ratri Suktam)
val tantroktamRatriList: List<TantroktamRatriShloka> = listOf(
    TantroktamRatriShloka(
        id = 1,
        sanskrit = "विश्वेश्वरीं जगद्धात्रीं स्थितिसंहारकारिणीम् । निद्रां भगवतीं विष्णोरतुलां तेजसः प्रभुः ॥ १ ॥",
        hindi = """
            ब्रह्मा जी ने कहा: मैं उन भगवती निद्रा की स्तुति करता हूँ जो पूरे विश्व की स्वामिनी (विश्वेश्वरी) हैं।
            वे ही इस संसार को धारण करने वाली और इसके पालन तथा संहार की मुख्य कारण हैं।
            वे भगवान विष्णु की अतुलनीय योगनिद्रा हैं, जिनकी तेज और शक्ति की कोई बराबरी नहीं है।
            यहाँ माँ को उस शक्ति के रूप में देखा गया है जो स्वयं भगवान को भी विश्राम देने में समर्थ है।
            बिना इस शक्ति के स्वयं परमात्मा भी सृष्टि के कार्यों का संचालन नहीं कर सकते।
            यह श्लोक माँ की सर्वोच्च सत्ता को स्थापित करता है, जो पूरे ब्रह्मांड का आधार हैं।
        """.trimIndent(),
        english = """
            Lord Brahma said: I praise that Goddess Nidra, the supreme sovereign of the entire universe.
            She is the sustainer of the world and the primal cause of its maintenance and dissolution.
            She is the incomparable Yoganidra of Lord Vishnu, possessing power beyond all measure.
            Here, the Mother is recognized as the energy capable of providing rest even to the Supreme Lord.
            Without Her power, even God cannot function or manage the affairs of cosmic creation.
            This verse establishes Her absolute supremacy as the fundamental foundation of all existence.
        """.trimIndent()
    ),
    TantroktamRatriShloka(
        id = 2,
        sanskrit = "त्वं स्वाहा त्वं स्वधा त्वं हि वषट्कारः स्वरात्मिका । सुधा त्वमक्षरे नित्ये त्रिधा मात्रात्मिका स्थिता ॥ २ ॥",
        hindi = """
            हे माँ! आप ही 'स्वाहा' (देवताओं की आहुति) और 'स्वधा' (पितरों की तृप्ति) का साक्षात् स्वरूप हैं।
            आप ही मन्त्रों का 'वषट्कार' और स्वरों की आत्मा (संगीत और नाद) हैं।
            आप अविनाशी और नित्य सत्य हैं; आप ही देवताओं का अमृत और 'ॐ' की तीन मात्राएं (अ-उ-म) हैं।
            साधना के हर मार्ग में, चाहे वह यज्ञ हो या ध्यान, आपकी उपस्थिति ही सफलता का आधार है।
            आप वह 'अक्षर' हैं जो कभी नष्ट नहीं होता और हर शब्द के पीछे की असली चेतना है।
            यह श्लोक माँ को समस्त वैदिक और आध्यात्मिक ध्वनियों के स्रोत के रूप में वर्णित करता है।
        """.trimIndent(),
        english = """
            O Mother! You are Svaha (offering to gods) and Svadha (offering to ancestors) in their direct form.
            You are the sacred Vashatkara and the very soul of all musical notes and spiritual vibrations.
            You are the eternal, imperishable Truth; You are the divine nectar and the three measures of OM.
            In every path of spiritual practice, be it sacrifice or meditation, Your presence is the key.
            You are the 'Akshara' (Imperishable) that survives time and the consciousness behind every word.
            This verse describes the Mother as the primordial source of all Vedic and spiritual sounds.
        """.trimIndent()
    ),
    TantroktamRatriShloka(
        id = 3,
        sanskrit = "अर्धमात्रास्थिता नित्या यानुच्चार्या विशेषतः । त्वमेव संध्या सावित्री त्वं देवि जननी परा ॥ ३ ॥",
        hindi = """
            हे माँ! आप 'ॐ' की उस 'अर्धमात्रा' के रूप में स्थित हैं जिसका उच्चारण साधारण वाणी से संभव नहीं है।
            वही आपकी शाश्वत और नित्य स्थिति है जिसे केवल अनुभव के द्वारा ही जाना जा सकता है।
            आप ही संध्या (संधिकाल की देवी), सावित्री (सृजन की शक्ति) और इस संसार की परम जननी हैं।
            आप वह सूक्ष्म मौन हैं जो शब्दों के खत्म होने के बाद साधक के हृदय में गूँजता है।
            सृष्टि की हर शुरुआत और हर अंत के बीच के पवित्र समय की अधिष्ठात्री केवल आप ही हैं।
            यह श्लोक माँ की परा-प्रकृति (Transcendental Nature) और ममतामयी जननी रूप का सुंदर संगम है।
        """.trimIndent(),
        english = """
            O Mother! You exist as the 'Half-Measure' of OM, which cannot be uttered by ordinary speech.
            That is Your eternal and constant state, which can only be realized through direct experience.
            You are Sandhya (the dusk/dawn), Savitri (creative radiance), and the Supreme Mother of all.
            You are that subtle silence that resonates in the seeker's heart after all words have ceased.
            You are the presiding deity of those sacred junction points between the beginning and the end.
            This verse is a beautiful blend of Her transcendental nature and Her identity as the Divine Mother.
        """.trimIndent()
    ),
    TantroktamRatriShloka(
        id = 4,
        sanskrit = "त्वयैतद्धार्यते विश्वं त्वयैतत्सृज्यते जगत् । त्वयैतत्पाल्यते देवि त्वमत्स्यन्ते च सर्वदा ॥ ४ ॥",
        hindi = """
            हे देवी! यह संपूर्ण विश्व केवल आपके द्वारा ही धारण और संतुलित किया जाता है।
            इस जगत की रचना आप ही करती हैं और आप ही इसका प्रेमपूर्वक पालन-पोषण भी करती हैं।
            और हे माँ! समय आने पर आप ही इस पूरी सृष्टि को अपने भीतर समेटकर लीन कर लेती हैं।
            ब्रह्मा, विष्णु और महेश के कार्यों के पीछे वास्तव में आपकी ही एक अखंड शक्ति कार्य करती है।
            आप ही वह ऊर्जा हैं जो ग्रहों को घुमाती है और जीवन को मृत्यु के बाद नया रूप देती है।
            यह श्लोक माँ को सृष्टि, स्थिति और संहार—तीनों प्रक्रियाओं की एकमात्र स्वामिनी बताता है।
        """.trimIndent(),
        english = """
            O Goddess! This entire universe is supported and balanced exclusively by Your power.
            You alone create this world, and You alone nourish and preserve it with maternal love.
            And O Mother! At the end of the cycle, You absorb and consume this entire creation back into Yourself.
            Behind the functions of Brahma, Vishnu, and Shiva, it is Your singular power that operates.
            You are the energy that moves the planets and grants life a new form even after death.
            This verse identifies the Mother as the sole mistress of creation, preservation, and destruction.
        """.trimIndent()
    ),
    TantroktamRatriShloka(
        id = 5,
        sanskrit = "विसृष्टौ सृष्टिरूपा त्वं स्थितिरूपा च पालने । तथा संहृतिरूपान्ते जगतोऽस्य जगन्मये ॥ ५ ॥",
        hindi = """
            सृष्टि के समय आप स्वयं 'सृजन' का रूप बन जाती हैं, और पालन के समय आप 'मर्यादा और पोषण' हैं।
            हे जगन्मयी! इस संसार के अंत के समय आप ही भयंकर 'प्रलय और संहार' का स्वरूप धारण करती हैं।
            आप कोई अलग शक्ति नहीं हैं, बल्कि आप ही इस जगत का हर एक परमाणु और उसकी हर हलचल हैं।
            माँ का यह रूप बताता है कि बदलाव ही संसार का नियम है और माँ उस बदलाव की संचालक हैं।
            चाहे निर्माण हो या विनाश, सब कुछ आपकी ही इच्छा और आपके ही दिव्य नृत्य का हिस्सा है।
            यह श्लोक साधक को हर परिस्थिति में माँ की उपस्थिति देखने का दिव्य दृष्टिकोण प्रदान करता है।
        """.trimIndent(),
        english = """
            At the dawn of creation, You are the Creative Force; in preservation, You are Order and Nourishment.
            O You who fill the universe! At the time of the end, You assume the form of Dissolution.
            You are not a separate entity; You are every atom and every single vibration within this world.
            This form reveals that change is the law of nature, and the Mother is the Director of that change.
            Whether it is building or destroying, everything is part of Your will and Your divine cosmic dance.
            This verse provides the seeker with a divine vision to see the Mother's presence in every situation.
        """.trimIndent()
    ),
    TantroktamRatriShloka(
        id = 6,
        sanskrit = "महाविद्या महामाया महामेधा महास्मृतिः । महामोहा च भवती महादेवी महेश्वरी ॥ ६ ॥",
        hindi = """
            आप ही महाविद्या (परम ज्ञान), महामाया (ब्रह्मांडीय भ्रम) और महामेधा (असाधारण बुद्धि) हैं।
            आप ही महास्मृति (स्मरण शक्ति) हैं और आप ही महामोहा (अज्ञान का पर्दा) डालने वाली भी हैं।
            आप ही साक्षात् महादेवी और महान ईश्वरी (महेश्वरी) हैं, जिनके आगे सब नतमस्तक हैं।
            ज्ञान भी आप हैं और उस ज्ञान को ढंकने वाला अज्ञान भी आप ही हैं ताकि यह संसार का खेल चल सके।
            इंसान की बुद्धि और उसकी याददाश्त आपकी ही चेतना का एक छोटा सा प्रतिबिंब मात्र है।
            यह श्लोक माँ के उन मनोवैज्ञानिक और बौद्धिक गुणों का वर्णन है जो मनुष्य को ईश्वर से जोड़ते हैं।
        """.trimIndent(),
        english = """
            You are Mahavidya (Supreme Knowledge), Mahamaya (Cosmic Illusion), and Mahamedha (Vast Intellect).
            You are Mahasmriti (Universal Memory) and You are also Mahamoha (the Great Delusion).
            You are the Great Goddess (Mahadevi) and the Great Sovereign (Maheshwari) before whom all bow.
            You are wisdom itself, and also the ignorance that veils it so that the cosmic play can continue.
            A human's intellect and memory are merely tiny reflections of Your vast and infinite consciousness.
            This verse describes the Mother's psychological and intellectual attributes that connect man to God.
        """.trimIndent()
    ),
    TantroktamRatriShloka(
        id = 7,
        sanskrit = "प्रकृतिस्त्वं च सर्वस्य गुणत्रयविभाविनी । कालरात्रिर्महारात्रिर्मोहरात्रिश्च दारुणा ॥ ७ ॥",
        hindi = """
            आप ही सबकी मूल प्रकृति हैं जो सत्व, रज और तम—इन तीनों गुणों को उत्पन्न और नियंत्रित करती हैं।
            आप ही कालरात्रि (समय का नाश करने वाली), महारात्रि (प्रलय की रात) और दारुण मोहरात्रि (अज्ञान की रात) हैं।
            ये तीन रातें जीवन के तीन गहरे संकटों—मृत्यु, अज्ञान और मोह का प्रतिनिधित्व करती हैं।
            आप वह शक्ति हैं जो इन तीनों भयानक रातों को पार कराकर ज्ञान का नया सवेरा लाती हैं।
            गुणों के जाल में फँसाना भी आपका काम है और उस जाल को काट देना भी आपकी ही करुणा है।
            यह श्लोक माँ की उस रहस्यमयी शक्ति को समर्पित है जो समय और माया के चक्र को संचालित करती है।
        """.trimIndent(),
        english = """
            You are the Primordial Nature (Prakriti), producing and governing the three modes: Sattva, Rajas, and Tamas.
            You are Kalaratri (the Night of Time), Maharatri (the Night of Dissolution), and the terrible Moharatri (Night of Delusion).
            These 'three nights' represent the deep crises of human life—death, ignorance, and attachment.
            You are the power that carries the soul through these dark nights into the dawn of wisdom.
            Entangling souls in the web of Gunas is Your play; cutting that web is Your absolute mercy.
            This verse is dedicated to Her mysterious power that operates the cycles of time and cosmic illusion.
        """.trimIndent()
    ),
    TantroktamRatriShloka(
        id = 8,
        sanskrit = "त्वं श्रीस्त्वमीश्वरी त्वं ह्रीस्त्वं बुद्धिर्बोधलक्षणा । लज्जा पुष्टिस्तथा तुष्टिस्त्वं शान्तिः क्षान्तिरेव च ॥ ८ ॥",
        hindi = """
            हे माँ! आप ही श्री (लक्ष्मी), ईश्वरी (सत्ता), ह्री (लज्जा और विनम्रता) और बोधस्वरूपा बुद्धि हैं।
            आप ही लज्जा (मर्यादा), पुष्टि (समृद्धि), तुष्टि (संतोष), शांति और क्षमा (क्षान्ति) का रूप हैं।
            जीवन के जितने भी कोमल और शुभ गुण हैं, वे सब वास्तव में आपके ही दिव्य प्रकाश के रूप हैं।
            जहाँ संतोष है वहाँ आप हैं, जहाँ शांति है वहाँ आपकी करुणा का साक्षात् निवास है।
            आप केवल संहारक नहीं, बल्कि आप ही वह शक्ति हैं जो मनुष्य को शालीन और मर्यादित बनाती हैं।
            यह श्लोक माँ के उन सौम्य गुणों का गान है जो हमारे चरित्र को गढ़ते हैं और शांति प्रदान करते हैं।
        """.trimIndent(),
        english = """
            O Mother! You are Shri (Prosperity), Ishwari (Sovereignty), Hree (Modesty), and Wisdom defined by awareness.
            You are the embodiment of Modesty, Nourishment (Pushti), Contentment (Tushti), Peace, and Forgiveness.
            All the gentle and auspicious qualities found in life are directly manifestations of Your divine light.
            Wherever there is contentment, You are there; wherever there is peace, Your mercy resides.
            You are not just the destroyer; You are the civilizing force that makes humans noble and dignified.
            This verse celebrates the Mother's gentle attributes that shape our character and grant inner peace.
        """.trimIndent()
    ),
    TantroktamRatriShloka(
        id = 9,
        sanskrit = "खड्गिनी शूलिनी घोरी गदिनी चक्रिणी तथा । शङ्खिनी चापिनी बाणभुशुण्डीपरिघायुधा ॥ ९ ॥",
        hindi = """
            आप अपने हाथों में खड्ग, शूल, गदा, चक्र, शंख और धनुष धारण करने वाली महाशक्ति हैं।
            बाण, भुशुण्डी और परिघ जैसे अजेय अस्त्र-शस्त्र आपकी भुजाओं की शोभा और शत्रुओं का भय हैं।
            यह माँ का पूर्ण अस्त्र-शस्त्रों से सुसज्जित योद्धा स्वरूप है जो धर्म की रक्षा के लिए सदैव तैयार है।
            ये अस्त्र केवल बाहरी शत्रुओं के लिए नहीं, बल्कि हमारे मन के राक्षसों को मारने के लिए भी हैं।
            माँ का यह रूप साधक के भीतर अदम्य साहस और नकारात्मकता से लड़ने का संकल्प जाग्रत करता है।
            यह श्लोक स्तुति का वह भाग है जो हमें याद दिलाता है कि सत्य की रक्षा के लिए शक्ति का होना अनिवार्य है।
        """.trimIndent(),
        english = """
            You are the Great Power wielding the sword, the trident, the mace, the discus, the conch, and the bow.
            Arrows, Bhushundi, and the heavy iron-club (Parigha) adorn Your arms and terrify the wicked.
            This is the Mother's fully armed warrior aspect, eternally ready for the protection of Righteousness (Dharma).
            These weapons are meant not just for external foes, but for slaying the demons lurking in our own minds.
            This form awakens invincible courage and the resolve to fight negativity within the practitioner.
            This verse serves as a reminder that to protect the Truth, the possession of power and strength is essential.
        """.trimIndent()
    )
)