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
data class MaitreyaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaitreyaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..7) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-7)") },
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
            itemsIndexed(maitreyaShlokasList) { _, shloka ->
                MaitreyaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun MaitreyaShlokaCard(shloka: MaitreyaShloka) {
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

val maitreyaShlokasList: List<MaitreyaShloka> = listOf(
    MaitreyaShloka(
        id = 1,
        sanskrit = "मैत्रेयः कैलासं जगाम । तत्र गत्वा महादेवमपृच्छत् । भो भगवन् परमतत्त्वरहस्यमनुब्रूहीति ॥ १ ॥",
        hindi = """
            महर्षि मैत्रेय परम ज्ञान की खोज में अत्यंत पवित्र 'कैलाश' पर्वत पर गए (मैत्रेयः कैलासं जगाम)।
            वहाँ जाकर उन्होंने देवाधिदेव भगवान महादेव (शिव) को प्रणाम किया और उनसे अत्यंत विनीत भाव से पूछा।
            "हे भगवन्! कृपया मुझे उस 'परम तत्त्व' का सबसे गहरा और अंतिम रहस्य (परमतत्त्वरहस्यं) बताइए जिससे मोक्ष मिलता है।"
            यह उपनिषद एक सच्चे जिज्ञासु (शिष्य) और सबसे महान गुरु (शिव) के बीच का सीधा संवाद है।
            कैलाश कोई साधारण पहाड़ नहीं है; योग में यह चेतना का वह सबसे ऊँचा शिखर (सहस्रार) है जहाँ साक्षात् शिव का वास है।
            जब इंसान दुनिया के सभी सुखों से पूरी तरह थक जाता है, तभी उसके मन में मैत्रेय की तरह सत्य को जानने की असली प्यास जगती है।
            भगवान शिव केवल प्रलय या विनाश के देवता नहीं हैं; वे साक्षात् 'आदि-गुरु' (First Teacher) हैं जो अज्ञान का पूरी तरह से विनाश करते हैं।
            यह प्रश्न यह दर्शाता है कि दुनिया की सारी लौकिक विद्याएं जानने के बाद भी, आत्मज्ञान के बिना इंसान पूरी तरह अधूरा ही रहता है।
            सच्चे गुरु के पास जाने का सही तरीका अपने अहंकार को छोड़कर पूरी तरह से खाली होकर (Humbly) प्रश्न पूछना ही है।
            यहीं से भगवान शिव उस परम वैराग्य और अद्वैत ज्ञान का उपदेश शुरू करते हैं जो इंसान को सीधा भगवान (शिव-स्वरूप) बना देता है।
        """.trimIndent(),
        english = """
            Sage Maitreya journeyed directly to the highly sacred Mount Kailash in his absolute quest for supreme spiritual wisdom.
            Having successfully reached there, he bowed deeply and asked Lord Mahadeva (Shiva) with the utmost humility and intense devotion.
            "O Supreme Lord! Please explicitly reveal to me the ultimate, profound secret of the absolute 'Highest Principle' (Paramatattva)."
            This magnificent Upanishad is a direct, tremendously powerful dialogue strictly between a true seeker and the absolute greatest Guru (Shiva).
            Kailash is absolutely not an ordinary physical mountain; in Yoga, it symbolizes the absolute highest peak of consciousness (Sahasrara) where Shiva resides.
            Only exactly when a human is completely exhausted and frustrated by worldly pleasures does the burning thirst for Truth awaken like Maitreya's.
            Lord Shiva is absolutely not merely the god of physical destruction; He is the direct 'Adi-Guru' (First Teacher) who ruthlessly destroys dark ignorance.
            This profound question clearly demonstrates that even after acquiring all worldly knowledge, a human remains completely incomplete entirely without Self-realization.
            The absolute correct way to physically approach a Guru is to drop all toxic ego and ask questions with a completely empty, highly humble mind.
            Exactly from here, Lord Shiva actively begins His magnificent teachings on absolute detachment and non-duality that flawlessly transforms a human directly into God.
        """.trimIndent()
    ),
    MaitreyaShloka(
        id = 2,
        sanskrit = "मातापित्रोर्मलोद्भूतं मलमयमिदं शरीरम् । तस्माद्वैराग्यमाश्रयेत् ॥ २ ॥",
        hindi = """
            (भगवान शिव उत्तर देते हैं): यह भौतिक शरीर माता और पिता के अत्यंत गंदे 'मलों' (रक्त और वीर्य) से ही उत्पन्न (उद्भूतं) हुआ है।
            और यह पूरा का पूरा शरीर जन्म से लेकर मृत्यु तक केवल मल-मूत्र और गंदगी (मलमयमिदं) से ही भरा हुआ है।
            इसलिए (तस्माद्), बुद्धिमान मनुष्य को इस गंदे शरीर से आसक्ति (मोह) हटाकर पूर्ण रूप से 'वैराग्य' (Detachment) का आश्रय (आश्रयेत्) लेना चाहिए।
            शिव जी यहाँ साधक के मन से शरीर के प्रति होने वाले भयंकर 'घमंड' (Body-Ego) पर सबसे बड़ा हथौड़ा मार रहे हैं।
            हम दिन भर शीशे के सामने खड़े होकर अपने इस शरीर को सजाते हैं और सोचते हैं कि हम बहुत सुंदर हैं।
            परंतु वेदान्त कहता है कि अगर इस शरीर की चमड़ी (Skin) हटा दी जाए, तो इसके अंदर खून, मांस और मल के अलावा कुछ भी नहीं है।
            इस गंदे पुतले से प्यार करना और इसी को अपना असली रूप ('मैं') मान लेना इंसान की सबसे बड़ी मूर्खता और अज्ञान है।
            'वैराग्य' का अर्थ शरीर से नफरत करना या इसे जला देना नहीं है; इसका अर्थ है इस शरीर की 'असली औकात' (Reality) को समझ लेना।
            जब इंसान को यह समझ आ जाता है कि शरीर केवल एक बदबूदार थैला है, तो वह इसमें परमानेंट सुख (Permanent joy) ढूँढना बंद कर देता है।
            शरीर के इस मोह का टूटना ही आध्यात्मिक यात्रा (Spiritual Journey) का सबसे पहला और सबसे जरूरी कदम है।
        """.trimIndent(),
        english = """
            (Lord Shiva answers): This gross physical body is born and produced (Udbhutam) entirely from the extremely filthy 'impurities' (blood and semen) of the mother and father.
            And this entire physical structure is thoroughly and completely filled purely with feces, urine, and filthy dirt (Malamayamidam) from birth to death.
            Therefore (Tasmad), an intelligent human being must ruthlessly strip away all toxic attachment to this dirty body and completely take absolute refuge (Ashrayet) in 'Vairagya' (Detachment).
            Lord Shiva is striking the absolute heaviest hammer blow here directly on the seeker's terrifying 'Body-Ego' (physical pride).
            We spend our entire days standing foolishly before the mirror, endlessly decorating this physical body, arrogantly thinking we are exceptionally beautiful.
            But Vedanta fiercely declares that if the external Skin of this body is peeled off, there is absolutely nothing inside except blood, raw flesh, and feces.
            Falling madly in love with this filthy puppet and falsely accepting it as our true identity ('I') is humanity's absolute greatest stupidity and ignorance.
            'Vairagya' absolutely does not mean fiercely hating the body or burning it; it profoundly means flawlessly understanding the exact 'Reality' (worth) of this physical frame.
            When a human perfectly understands that the body is merely a stinking bag of dirt, he completely stops searching for Permanent Joy within it.
            The absolute shattering of this blind physical infatuation is undeniably the very first and most essential step of the entire Spiritual Journey.
        """.trimIndent()
    ),
    MaitreyaShloka(
        id = 3,
        sanskrit = "देहो देवालयः प्रोक्तो स जीवः केवलः शिवः । त्यजेदज्ञाननिर्माल्यं सोऽहंभावेन पूजयेत् ॥ ३ ॥",
        hindi = """
            (अत्यंत प्रसिद्ध वेदान्तिक घोषणा): यह भौतिक 'देह' (शरीर) ही वास्तव में साक्षात् 'देवालय' (भगवान का पवित्र मंदिर) कहा गया है (देहो देवलयः प्रोक्तो)।
            और इस शरीर रूपी मंदिर के भीतर बैठा हुआ यह 'जीव' (आत्मा) ही वह साक्षात् परम 'शिव' (ईश्वर) है।
            इसलिए साधक को चाहिए कि वह अपने मन से उस 'अज्ञान' (मैं शरीर हूँ, इस भ्रम) रूपी बासी और सड़े हुए फूलों के कचरे (निर्माल्य) को पूरी तरह से बाहर निकालकर फेंक दे (त्यजेत्)।
            और फिर "मैं ही वह शिव हूँ" (सोऽहं / So-ham) की परम पवित्र और शुद्ध भावना के साथ उस भीतर बैठे भगवान (अपनी ही आत्मा) की निरंतर पूजा (पूजयेत्) करे।
            (नोट: यह श्लोक अद्वैत योग के कई ग्रंथों में है, और मैत्रेय उपनिषद का हृदय है)।
            हम भगवान को ढूँढने के लिए ईंट और पत्थर के बने मंदिरों में मीलों की लाइन लगाते हैं, पर असली और जीता-जागता 'मंदिर' तो हमारा अपना ही शरीर है!
            और उस मंदिर की जो असली 'मूर्ति' है, वह कोई निर्जीव पत्थर नहीं, बल्कि हमारी अपनी ही शुद्ध चेतना (जीव/शिव) है।
            मंदिर को साफ रखने के लिए जैसे पुराने और सड़े हुए फूलों (निर्माल्य) को बाहर फेंकना पड़ता है; वैसे ही मन के मंदिर से 'अज्ञान और अहंकार' का बदबूदार कचरा बाहर फेंकना है।
            भगवान की असली पूजा (Worship) घंटी बजाना या अगरबत्ती जलाना नहीं है; असली पूजा है 'सोऽहं' (मैं शिव हूँ) का गहरा अहसास।
            जब इंसान को यह समझ आ जाता है कि "मैं खुद ही एक चलता-फिरता मंदिर हूँ", तो उसका पूरा जीवन ही एक अखंड पूजा (Worship) बन जाता है।
        """.trimIndent(),
        english = """
            (Highly famous Vedantic declaration): This highly gross physical 'Body' (Deha) itself is, in absolute reality, profoundly declared to be the direct 'Devalaya' (the highly sacred, holy Temple of God) (Deho devalayah prokto).
            And this 'Jiva' (Soul) intimately seated right inside this temple of the body is undeniably exactly that supreme 'Shiva' (God) Himself.
            Therefore, the sincere seeker must aggressively and completely throw out and permanently discard (Tyajet) the stale, rotting 'Nirmalya' (the garbage of old, dead flowers) of 'Ignorance' (the illusion that I am the body) entirely from his mind.
            And then, strictly and exclusively with the supremely sacred and pure profound feeling of "So-ham" (I am That Shiva), he must continuously and relentlessly worship (Pujayet) that God sitting right inside (his very own Soul).
            (Note: This spectacular verse appears in many texts of Advaita Yoga, and forms the absolute beating heart of the Maitreya Upanishad).
            We foolishly stand in mile-long queues at physical temples built entirely of cheap bricks and stones aggressively searching for God, but the actual, real, and breathing 'Temple' is our very own physical body!
            And the real, true 'Idol' safely housed strictly inside that temple is absolutely not a dead stone, but our very own pure Consciousness (Jiva/Shiva).
            Just as to keep a physical temple clean, the old, rotting, and foul-smelling flowers (Nirmalya) must be ruthlessly thrown out; exactly similarly, the stinking garbage of 'Ignorance and Ego' must be thrown entirely out of the temple of the mind.
            The real, authentic Worship (Puja) of God is absolutely not ringing brass bells or burning cheap incense sticks; the actual, supreme worship is the profound, unbroken realization of 'So-ham' (I am Shiva).
            When a human being profoundly understands that "I myself am literally a walking, breathing temple," his entire earthly life instantly transforms perfectly into an unbroken, eternal Worship.
        """.trimIndent()
    ),
    MaitreyaShloka(
        id = 4,
        sanskrit = "न बाह्यवारिणा शुद्धिर्नापि मृद्भस्मवारिभिः । चित्तशुद्धिः परा शुद्धिः सर्वपापप्रणाशिनी ॥ ४ ॥",
        hindi = """
            (सच्चे स्नान / Purity की परिभाषा): शरीर को केवल 'बाहर के पानी' (बाह्यवारिणा) से नहा लेने से आत्मा की कोई वास्तविक 'शुद्धि' (पवित्रता) बिल्कुल नहीं होती।
            न ही शरीर पर केवल मिट्टी (मृद्), पवित्र राख (भस्म) और गंगाजल (वारिभिः) मल लेने से इंसान अंदर से शुद्ध हो जाता है।
            महान ऋषियों के अनुसार, अपने 'चित्त' (मन) को मलिन विचारों से साफ करना (चित्तशुद्धिः) ही दुनिया की सबसे 'परम शुद्धि' (Highest purity) है।
            और केवल यही मन की पवित्रता इंसान के करोड़ों जन्मों के 'सभी पापों को पूरी तरह से नष्ट' (सर्वपापप्रणाशिनी) करने वाली है।
            यह श्लोक बाहरी कर्मकांडों (External rituals) और पाखंड पर एक बहुत ही करारा और सीधा तमाचा है।
            लोग सोचते हैं कि कुंभ के मेले में या गंगा नदी में डुबकी लगाने से उनके सारे पाप धुल जाएंगे।
            पर भगवान शिव मैत्रेय से कहते हैं कि पानी केवल शरीर के पसीने और कीचड़ को धो सकता है; पानी तुम्हारे 'दिमाग' के लालच और नफरत को कैसे धोएगा?
            अगर नदी में नहाने से मोक्ष मिलता, तो मछलियां और मेंढक सबसे पहले भगवान बन जाते!
            असली 'स्नान' (Bath) तब होता है जब आप ध्यान और आत्मज्ञान के द्वारा अपने दिमाग से क्रोध, ईर्ष्या और वासना की गंदगी को धो डालते हैं।
            जब मन का आईना पूरी तरह साफ हो जाता है, तो उसमें ईश्वर का चेहरा अपने-आप चमकने लगता है; यही असली तीर्थ और असली शुद्धि है।
        """.trimIndent(),
        english = """
            (The absolute definition of true Snana / Purity): Merely washing the gross physical body extensively with 'external water' (Bahyavarina) absolutely does not grant any real, genuine 'Purity' (Shuddhi) to the Soul whatsoever.
            Nor does vigorously rubbing holy mud (Mrid), sacred ash (Bhasma), and river water onto the skin make a human being truly pure from the inside.
            According to the greatest ancient sages, actively cleansing one's 'Chitta' (Mind) from all filthy, toxic thoughts (Chittashuddhih) is the absolute 'Highest Purity' (Para shuddhi) in the entire world.
            And exclusively this pure perfection of the mind alone is fully capable of 'completely annihilating all terrifying sins' (Sarvapapapranashini) accumulated over millions of lifetimes.
            This magnificent verse is an exceptionally tight, fierce slap directly against empty external rituals (Karmakanda) and blind religious hypocrisy.
            Ignorant people foolishly believe that merely taking a quick physical dip in the Ganga river or at the Kumbh Mela will magically wash away all their heavy sins.
            But Lord Shiva fiercely tells Maitreya that physical water can strictly only wash away bodily sweat and mud; how on earth can physical water wash away the intense greed and hatred locked deep inside your 'Brain'?
            If merely bathing in a river granted Moksha, then the fish and frogs would undoubtedly become God first!
            The actual, absolute true 'Bath' (Snana) occurs exactly when you aggressively wash away the toxic filth of anger, jealousy, and deep lust from your brain strictly through meditation and Self-knowledge.
            When the mirror of the mind becomes 100% flawlessly clean, the radiant face of God automatically shines brilliantly within it; this is the absolute true pilgrimage and ultimate purity.
        """.trimIndent()
    ),
    MaitreyaShloka(
        id = 5,
        sanskrit = "न दण्डधारणं सत्यं न मुण्डनं न चीवरम् । मनसो विषयत्यागः स संन्यास इतीरितः ॥ ५ ॥",
        hindi = """
            (सच्चे संन्यास / Renunciation की परिभाषा): केवल हाथ में एक 'लकड़ी का डंडा' (दण्डधारणं) पकड़ लेना ही सच्चा संन्यास (सत्यं) बिल्कुल नहीं है।
            न ही सिर के बालों को पूरी तरह छिलवा लेना (मुण्डनं), और न ही गेरुआ या भगवा कपड़े (चीवरम्) पहन लेना असली संन्यास है।
            महान ज्ञानियों द्वारा कहा गया है कि अपने 'मन' से सांसारिक भोगों और इच्छाओं का पूरी तरह से त्याग (मनसो विषयत्यागः) कर देना।
            केवल और केवल वही अवस्था वास्तव में 'सच्चा संन्यास' (स संन्यास इतीरितः) कहलाती है।
            भारत में लाखों लोग केवल कपड़े बदलकर और सिर मुंडवाकर खुद को 'संन्यासी' या 'साधु' घोषित कर देते हैं।
            परंतु मैत्रेय उपनिषद इस दिखावे (Show-off) को पूरी तरह से नकारता है; कपड़े तो कोई बहरूपिया या एक्टर (Actor) भी पहन सकता है!
            अगर आपने गेरुआ कपड़ा पहन लिया, पर आपके दिमाग में अभी भी 'पैसा, नाम और वासना' की भूख चल रही है, तो आप एक पाखंडी (Hypocrite) हैं।
            संन्यास कोई कपड़ों का फैशन (Fashion) नहीं है; संन्यास मन की वह अत्यंत ऊँची अवस्था है जहाँ दुनिया का कोई भी लालच आपको हिला नहीं सकता।
            राजा जनक जैसे लोग रेशमी कपड़े और मुकुट पहनकर भी अंदर से 'संन्यासी' थे, क्योंकि उनके मन में कोई मोह (Attachment) नहीं था।
            जब मन से 'मैं और मेरा' का भाव 100% मिट जाता है, तो इंसान चाहे कोट-पैंट पहने या नंगा रहे, वह दुनिया का सबसे बड़ा संन्यासी है।
        """.trimIndent(),
        english = """
            (The absolute definition of true Sannyasa / Renunciation): Merely holding a 'wooden staff' (Dandadharanam) in the physical hand is absolutely not true Sannyasa (Satyam) whatsoever.
            Nor is aggressively shaving off absolutely all the hair on one's head (Mundanam), nor is simply wearing ochre or saffron robes (Chivaram) the mark of genuine renunciation.
            It is profoundly declared by the greatest enlightened sages that the complete, absolute internal abandonment of all worldly lusts and desires strictly from the 'Mind' (Manaso vishayatyagah).
            That, and strictly that absolute mental state alone, is genuinely and officially called 'True Sannyasa' (Sa sannyasa itiritah).
            Millions of people in India falsely declare themselves as 'Sannyasis' or 'Sadhus' merely by changing their physical clothes and shaving their heads.
            But the Maitreya Upanishad utterly and ruthlessly rejects this cheap Show-off; even a deceptive actor or fraud can easily wear those physical clothes!
            If you wear a sacred saffron robe, but the intense, burning hunger for 'money, fame, and heavy lust' is still actively running in your brain, you are a complete Hypocrite.
            Sannyasa is absolutely not a cheap clothing Fashion; Sannyasa is that exceptionally elevated, supreme state of the mind where absolutely no worldly greed can ever shake you.
            Great men like King Janaka were completely 'Sannyasis' from the inside even while actively wearing royal silk clothes and golden crowns, strictly because their minds held absolutely zero Attachment.
            When the toxic feeling of 'I and Mine' is 100% annihilated from the mind, whether the human wears a western suit or roams completely naked, he is undeniably the world's greatest Sannyasi.
        """.trimIndent()
    ),
    MaitreyaShloka(
        id = 6,
        sanskrit = "चिदाकाशे विलीनात्मा सर्वं पश्यति चिन्मयम् । न तस्य बन्धनं किञ्चिन्न च मोक्षस्य काङ्क्षणा ॥ ६ ॥",
        hindi = """
            (जीवन्मुक्त योगी की अवस्था): जिस ज्ञानी की 'आत्मा' (चेतना) उस असीम और शुद्ध 'चिदाकाश' (चेतना रूपी आकाश / Supreme Consciousness) में पूरी तरह से विलीन (पिघलकर एक) हो चुकी है।
            वह योगी इस पूरे ब्रह्मांड और हर एक वस्तु को केवल और केवल 'चिन्मय' (चेतना का ही एक रूप / Divine) के रूप में ही साक्षात् देखता (पश्यति) है।
            उस महापुरुष के लिए इस संसार में किसी भी प्रकार का कोई 'बंधन' (बन्धनं किञ्चित् / गुलामी या कर्म) बिल्कुल भी शेष नहीं रहता।
            और सबसे बड़ी बात, उसे अब 'मोक्ष' (आज़ादी) पाने की भी कोई इच्छा या लालसा (काङ्क्षणा) बिल्कुल नहीं रहती (क्योंकि वह पहले से ही मुक्त है)।
            यह अद्वैत वेदान्त का वह शिखर है जहाँ इंसान और ईश्वर के बीच की आखिरी लकीर भी मिट जाती है।
            जब एक बर्फ की गुड़िया (Ego) समंदर (चिदाकाश) में पिघल जाती है, तो वह गुड़िया नहीं रहती, वह साक्षात् समंदर ही बन जाती है।
            जब योगी इस स्थिति में आता है, तो उसे दुनिया में कोई 'बुरी' या 'गंदी' चीज़ नहीं दिखती; उसे पत्थर, दुश्मन और कुत्ते सबमें वही 'चिन्मय' भगवान दिखता है।
            हम मोक्ष (Moksha) के लिए इसलिए तड़पते हैं क्योंकि हम खुद को 'बँधा हुआ' (Bound) मानते हैं।
            पर जब ज्ञानी को यह समझ आ जाता है कि "मैं तो आकाश की तरह हूँ, जिसे कोई बाँध ही नहीं सकता", तो उसकी मोक्ष पाने की इच्छा भी खत्म हो जाती है।
            बंधन ही झूठ था, इसलिए मोक्ष पाना भी एक झूठ ही है; आत्मा हमेशा से ही 100% आज़ाद और पूर्ण थी, बस इस सच को जानना ही सब कुछ है।
        """.trimIndent(),
        english = """
            (The supreme state of the Jivanmukta Yogi): That highly enlightened sage whose 'Soul' (Consciousness) has completely and flawlessly dissolved and merged (Vilina) entirely into the infinite 'Chidakasha' (the boundless Sky of Pure Consciousness).
            That magnificent Yogi directly and flawlessly sees (Pashyati) this entire massive cosmos and absolutely everything within it strictly as 'Chinmayam' (the exact, divine manifestation of pure consciousness alone).
            For that colossal, great soul, absolutely no trace of any 'Bondage' (Bandhanam kinchit / slavery or karmic chain) whatsoever remains existing in this world.
            And most profoundly, he absolutely no longer harbors even the slightest desire or craving (Kankshana) to attain 'Moksha' (Liberation) (simply because he is already absolutely free).
            This is the absolute highest peak of Advaita Vedanta where the final, microscopic line standing between a human and God is permanently erased.
            When an ice doll (Ego) completely melts directly into the vast Ocean (Chidakasha), it absolutely ceases to be a doll; it flawlessly and literally becomes the Ocean itself.
            When the Yogi successfully reaches this state, he sees absolutely no 'evil' or 'dirty' thing in the world; he sees exclusively that exact 'Chinmaya' God in the stone, his deadly enemy, and a dog alike.
            We desperately thrash and crave Moksha strictly because we falsely and deeply believe ourselves to be 'Bound' (imprisoned).
            But when the sage profoundly realizes, "I am exactly like the infinite sky, which absolutely nothing can ever possibly bind," his intense desire to 'attain' Moksha also dies completely.
            The bondage itself was a massive lie, hence 'attaining' Moksha is also a lie; the Soul was always 100% perfectly free and complete, just realizing this exact Truth is absolutely everything.
        """.trimIndent()
    ),
    MaitreyaShloka(
        id = 7,
        sanskrit = "अहं शिवोऽहं शिवोऽस्मि सच्चिदानन्दलक्षणः । इत्येवं निश्चितं यस्य स मुक्तो नात्र संशयः ॥ ७ ॥",
        hindi = """
            (अंतिम उद्घोषणा / The Ultimate Declaration): "निश्चित रूप से मैं ही वह साक्षात् शिव हूँ, हाँ, मैं ही वह परम शिव हूँ" (अहं शिवोऽहं शिवोऽस्मि)।
            "और मैं किसी भी रूप या नाम में नहीं बँधा हूँ, मेरा असली स्वरूप तो केवल 'सत्-चित्-आनंद' (सच्चिदानन्दलक्षणः / शाश्वत सत्य, शुद्ध चेतना और परम सुख) ही है।"
            जिस भी साधक के हृदय में यह परम ज्ञान एक अत्यंत 'दृढ़ निश्चय' (निश्चितं) के रूप में हमेशा के लिए पक्का हो जाता है (यस्य)।
            "वह मनुष्य निश्चित रूप से पूर्ण मुक्त (मोक्ष प्राप्त) है", इसमें मुझे रत्ती भर भी कोई संशय (शक) बिल्कुल भी नहीं है (नात्र संशयः)।
            मैत्रेय उपनिषद का यह अंतिम श्लोक सनातन धर्म का सबसे शक्तिशाली 'मास्टर-स्ट्रोक' (Master-stroke) है।
            भगवान शिव मैत्रेय को बता रहे हैं कि तुम्हें किसी बाहर के शिव की पूजा नहीं करनी है; तुम्हें खुद 'शिव' बनना है!
            'शिवोऽहम्' (मैं शिव हूँ) का मतलब अहंकार नहीं है; इसका मतलब है कि मेरे अंदर का छोटा सा 'इंसान' (डरपोक, लालची जीव) अब पूरी तरह से मर चुका है।
            जब इंसान का 'मैं' मर जाता है, तो उसके अंदर जो जगह खाली होती है, उसे 'ईश्वर' (शिव) पूरी तरह से भर देता है।
            यह कोई ऐसा विचार नहीं है जो आज है और कल गायब हो जाए; उपनिषद कहता है 'निश्चितं' (यह 100% रॉक-सॉलिड कनविक्शन होना चाहिए)।
            जिस दिन यह 'शिवोऽहम्' आपके खून की हर बूँद में गूँजने लगेगा, मौत और डर आपके सामने घुटने टेक देंगे, और आप हमेशा के लिए ब्रह्मांड के राजा बन जाएंगे। ॐ शांतिः!
        """.trimIndent(),
        english = """
            (The Ultimate Declaration): "I am undoubtedly and certainly that exact Shiva Himself; yes, I am indeed that Supreme Shiva" (Aham shivo'ham shivo'smi).
            "And I am absolutely not bound by any petty physical form or name; my true, absolute original nature is strictly 'Sat-Chit-Ananda' (Satchidanandalakshanah / Eternal Truth, Pure Consciousness, and Supreme Bliss) alone."
            Whichever sincere seeker permanently and flawlessly solidifies this supreme wisdom in his heart as an exceptionally 'Rock-Solid Conviction' (Nishchitam).
            "That specific human being is undoubtedly and unconditionally fully liberated (has attained Moksha)"; there is absolutely no doubt, hesitation, or second thought in this fact whatsoever (Natra samshayah).
            This final, spectacular verse of the Maitreya Upanishad is Sanatana Dharma's absolute most terrifyingly powerful 'Master-Stroke'.
            Lord Shiva is explicitly telling Sage Maitreya that you absolutely do not have to worship any external Shiva; you must flawlessly become 'Shiva' yourself!
            'Shivoham' (I am Shiva) absolutely does not signify toxic arrogance; it profoundly means that the tiny, pathetic 'Human' (the cowardly, greedy creature) inside me is now completely, permanently dead.
            When a human's petty 'I' flawlessly dies, the massive empty space created inside is instantly and completely filled entirely by 'God' (Shiva).
            This is absolutely not a fleeting thought that exists today and vanishes tomorrow; the Upanishad explicitly uses the word 'Nishchitam' (it must be a 100% Rock-Solid Conviction).
            The exact day this 'Shivoham' actively begins echoing in every single drop of your blood, terrifying death and fear will drop to their knees before you, and you will become the immortal King of the universe forever. OM Peace!
        """.trimIndent()
    )
)