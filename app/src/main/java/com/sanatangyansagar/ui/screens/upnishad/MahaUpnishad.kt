package com.sanatangyansagar.ui.screens.upnishad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
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

data class MahaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MahaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..mahaShlokasList.size) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-17)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            },
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
            itemsIndexed(mahaShlokasList) { _, shloka ->
                MahaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun MahaShlokaCard(shloka: MahaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Shloka ${shloka.id}", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFFD84315))
            Spacer(modifier = Modifier.height(8.dp))
            Text(shloka.sanskrit, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text("हिन्दी अर्थ:", fontWeight = FontWeight.Bold, color = Color(0xFF1565C0))
            Text(shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text("English Meaning:", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
            Text(shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

val mahaShlokasList: List<MahaShloka> = listOf(
    MahaShloka(
        id = 1,
        sanskrit = "ॐ । महा उपनिषदम् व्याख्यास्यामः । तत्र येन महात्मना परब्रह्म परिज्ञायते स महापुरुषः ।",
        hindi = """
            (महा उपनिषद की प्रस्तावना): ॐ। अब हम महा उपनिषद की व्याख्या करेंगे। उस उपनिषद में, वह महान आत्मा (महात्मा) जिसके द्वारा परब्रह्म (परम सत्य) का साक्षात्कार किया जाता है, वही 'महापुरुष' कहलाता है।
            यह उपनिषद इस बात को स्पष्ट करता है कि महानता का पैमाना बाहरी उपलब्धियाँ नहीं, बल्कि ईश्वर का अनुभव है। कोई व्यक्ति चाहे कितना ही धनवान या विद्वान क्यों न हो, जब तक वह अपने अंदर की उस परम सत्ता को नहीं पहचान लेता, तब तक वह 'महापुरुष' नहीं है।
            'परब्रह्म' को जानना केवल किताबों का ज्ञान नहीं है, बल्कि यह एक भयंकर आंतरिक अनुभव है। जब इंसान को यह अहसास हो जाता है कि उसका 'मैं' (Ego) केवल एक भ्रम है और उसका असली स्वरूप वह अनंत ब्रह्मांडीय चेतना ही है, तो वही सच्चा 'महापुरुष' का जन्म होता है।
            महा उपनिषद का यह आरंभिक सूत्र ही हमें बता देता है कि यहाँ संकीर्णता का कोई स्थान नहीं है। महानता की परिभाषा यहाँ पूरी तरह से आध्यात्मिक और सार्वभौमिक (Universal) है।
            जो व्यक्ति इस सत्य को जी लेता है, वह न केवल खुद मुक्त हो जाता है, बल्कि उसके अस्तित्व से पूरी मानवता के लिए शांति और ज्ञान का संचार होता है। यही इस उपनिषद की मूल महिमा है।
        """.trimIndent(),
        english = """
            (Introduction to Maha Upanishad): Om. Now we shall expound upon the Maha Upanishad. In this text, that magnificent great soul (Mahatma) through whom the Supreme Brahman (the Ultimate Truth) is realized is truly and exclusively called a 'Mahapurusha' (Great Being).
            This Upanishad forcefully clarifies that the authentic yardstick for measuring true greatness is absolutely not external worldly achievements, but exclusively the profound direct realization of God. Regardless of how excessively wealthy or intellectually sharp an individual may be, unless he has violently and completely recognized that ultimate Supreme Reality within himself, he is strictly not a 'Mahapurusha'.
            Knowing 'Parabrahman' is absolutely not mere bookish knowledge; it is a terrifying, explosive, raw internal experience. Exactly when a human profoundly realizes that his tiny 'I' (Ego) is strictly nothing but a massive illusion and that his authentic nature is that identical Infinite Cosmic Consciousness, only then is the true 'Mahapurusha' genuinely born.
            This opening formula of the Maha Upanishad explicitly tells us that there is absolutely zero room for spiritual narrow-mindedness here. The definition of greatness here is entirely, absolutely spiritual and fundamentally Universal.
            The individual who genuinely lives this supreme truth does not merely become liberated himself, but his very existence violently radiates supreme peace and massive wisdom to all of humanity. This is the absolute ultimate glory of this Upanishad.
        """.trimIndent()
    ),
    MahaShloka(
        id = 2,
        sanskrit = "एको ह वै नारायण आसीत् न ब्रह्मा न ईशानो नापो नाग्नीषोमौ नेमे द्यावापृथिवी ।",
        hindi = """
            (सृष्टि से पहले केवल नारायण): सृष्टि के आरंभ से भी पहले, जब कुछ भी नहीं था, तब केवल और केवल एक 'नारायण' (परम चेतना / Supreme Consciousness) ही विद्यमान थे। 
            उस समय न ब्रह्मा थे, न शिव (ईशान) थे, न जल था, न अग्नि थी, न चंद्रमा था, और न ही यह आकाश और पृथ्वी (द्यावापृथिवी) थे। सब कुछ उसी एक परम शून्यता और पूर्णता में समाया हुआ था। 
            यह श्लोक इंसान के उस घमंड को चकनाचूर कर देता है जो सोचता है कि यह दुनिया और उसकी उपलब्धियां हमेशा रहेंगी। उपनिषद याद दिलाता है कि एक समय था जब यह पूरा ब्रह्मांड, तारे, ग्रह और देवता तक नहीं थे। 
            जो कुछ भी आज हमें ठोस और असली लग रहा है, वह एक दिन वापस उसी नारायण (Infinite Energy) में विलीन हो जाएगा। 
            जब केवल एक ही चेतना असली है, तो इंसान का यह अहंकार "मैं शरीर हूँ, मेरा बैंक बैलेंस, मेरा परिवार" कितना झूठा और हास्यास्पद है! 
            असली 'महापुरुष' वह है जो इस दुनिया के ड्रामे को देखकर फँसता नहीं, बल्कि उस परम नारायण को अपने दिल में देखता है जो सृष्टि के पहले भी था और प्रलय के बाद भी रहेगा।
        """.trimIndent(),
        english = """
            (Only Narayana existed before creation): Long before the absolute dawn of creation, when literally nothing existed, strictly and exclusively only one 'Narayana' (The Supreme Absolute Consciousness) existed. 
            At that exact dimensionless time, there was no Brahma, no Shiva (Ishaana), no cosmic waters, no fire, no moon, and absolutely neither this infinite sky nor this physical earth (Dyavaprithivi). Absolutely everything was entirely dissolved in that single Supreme Void and Absolute Fullness. 
            This terrifying verse violently shatters the massive human ego that foolishly believes this physical world and its cheap achievements will last forever. The Upanishad aggressively reminds us that there was a time when this entire cosmos, stars, planets, and even the highest gods simply did not exist. 
            Absolutely everything that appears solidly 'real' to us today will inevitably, violently dissolve exactly back into that identical Narayana (Infinite Energy). 
            When strictly only One Consciousness is real, how pathetically fake and utterly laughable is the human ego screaming, "I am this body, my bank balance, my family"! 
            The true 'Mahapurusha' is exactly he who refuses to get trapped in this cheap cosmic drama and directly beholds that Supreme Narayana in his heart—the One who existed before creation and will remain long after absolute universal destruction.
        """.trimIndent()
    ),
    MahaShloka(
        id = 3,
        sanskrit = "चित्तमेव हि संसारं तत्प्रयत्नेन शोधयेत् । यच्चित्तस्तन्मयो भवति गुह्यमेतत् सनातनम् ॥",
        hindi = """
            (मन ही संसार है): इंसान का अपना 'चित्त' (मन / Mind) ही वास्तव में यह पूरा 'संसार' (दुनिया) है! इसलिए पूरी ताकत और भयंकर प्रयत्नों से केवल अपने इस मन को ही शुद्ध (शोधयेत्) करना चाहिए। 
            मनुष्य का मन जैसा होता है, वह खुद साक्षात् वैसा ही बन जाता है (यच्चित्तस्तन्मयो भवति); यही सनातन धर्म का सबसे गहरा, छिपा हुआ और परम रहस्य (गुह्यमेतत् सनातनम्) है! 
            महा उपनिषद यहाँ सबसे बड़ा 'मनोवैज्ञानिक' (Psychological) विस्फोट कर रहा है। बाहर कोई नर्क या स्वर्ग नहीं है; बाहर कोई दुख या सुख नहीं है। दुनिया वैसी ही दिखती है जैसा तुम्हारा मन है। 
            अगर तुम्हारा मन वासना और लालच से भरा है, तो यह दुनिया तुम्हारे लिए एक भयंकर जेल (Jail) है। अगर तुम्हारा मन शांत और ईश्वर में लीन है, तो यही दुनिया साक्षात् मोक्ष का धाम है। 
            इसलिए बाहरी दुनिया को सुधारने में अपनी ऊर्जा बर्बाद मत करो। पूरी ताकत लगाकर अपने मन के अंदर के कचरे (Ego) को साफ करो। 
            जैसे ही चित्त (Mind) शांत होता है, संसार का यह सारा मायाजाल एक सेकंड में टूटकर बिखर जाता है और केवल परमात्मा शेष रह जाता है।
        """.trimIndent(),
        english = """
            (The Mind itself is the World): A human being's own 'Chitta' (Mind / Consciousness) is literally and completely the entirety of this 'Samsara' (Physical World)! Therefore, one must relentlessly, with terrifying supreme effort, violently purify strictly this mind alone (Shodhayet). 
            Whatever exact form a human's mind violently takes, he literally, physically becomes exactly that entirely (Yachchittastanmayo bhavati); this is undeniably the absolute deepest, most profoundly hidden, and ultimate eternal secret (Guhyametat sanatanam) of Sanatana Dharma! 
            The Maha Upanishad violently triggers the absolute greatest 'Psychological' explosion right here. There is absolutely no external hell or heaven; there is zero external sorrow or joy. The physical world appears exactly and strictly as your own mind dictates. 
            If your brain is heavily poisoned with toxic lust and blinding greed, this entire world is a terrifying, suffocating Jail for you. If your mind is flawlessly tranquil and merged in God, this exact identical world is the direct dimension of Moksha. 
            Therefore, absolutely stop wasting your precious life-force trying to fix the fake external world. Use your absolute total might exclusively to violently scrub away the toxic garbage (Ego) inside your own mind. 
            The exact split-second the Chitta (Mind) becomes completely silent, this entire terrifying matrix of Maya violently shatters into worthless dust, leaving absolutely nothing but the Supreme Lord alone.
        """.trimIndent()
    ),
    MahaShloka(
        id = 4,
        sanskrit = "वासना एव संसारो विनाशस्तस्य मोक्षता । तस्मात्सर्वप्रयत्नेन वासनां त्यज भिक्षुक ॥",
        hindi = """
            (वासना का नाश ही मोक्ष है): इंसान के अंदर बैठी हुई 'वासना' (गहरी इच्छाएँ / Desires) ही वास्तव में यह संसार है। और उन वासनाओं का पूरी तरह से नाश (विनाशस्तस्य) हो जाना ही साक्षात् 'मोक्ष' (Liberation) है। 
            इसलिए हे भिक्षुक (संन्यासी साधक)! अपनी पूरी जान और भयंकर ताकत लगाकर (सर्वप्रयत्नेन) अपने अंदर की वासनाओं को उखाड़ कर फेंक दे! 
            इंसान बार-बार इस धरती पर जन्म क्यों लेता है? क्योंकि मरते समय उसके दिमाग में कोई न कोई 'वासना' (मुझे यह पाना है, मुझे वह भोगना है) बची रह जाती है। 
            यही वासना इंसान को फिर से एक नए शरीर और नई तकलीफों में खींच लाती है। जब तक तुम्हारे अंदर दुनिया की किसी भी चीज़ को पाने की 'भूख' है, तब तक तुम आज़ाद नहीं हो सकते। 
            मोक्ष आसमान से टपकने वाला कोई वरदान नहीं है। मोक्ष केवल एक अवस्था है जहाँ तुम्हारी सारी इच्छाएँ 100% जलकर राख हो चुकी हैं। 
            जिस दिन तुम दुनिया से कुछ भी मांगना बंद कर दोगे, उसी दिन, उसी पल तुम साक्षात् भगवान बन जाओगे।
        """.trimIndent(),
        english = """
            (The destruction of desire is Moksha): The deep-rooted 'Vasana' (toxic cravings/desires) sitting violently inside a human being is strictly and literally the entirety of this Samsara (World). And the absolute complete, violent annihilation of those exact Vasanas (Vinashastasya) is explicitly the exact definition of 'Moksha' (Supreme Liberation). 
            Therefore, O Bhikshuka (seeker monk)! Use your absolute total life-force and terrifying supreme effort (Sarvaprayatnena) to ruthlessly uproot and violently kick away all internal desires forever! 
            Why exactly does a human pathetically take birth on this earth again and again? Purely because exactly at the moment of physical death, some toxic 'Vasana' ("I desperately want this, I must experience that") still secretly burns in his rotting brain. 
            This exact identical toxic Vasana violently drags the human straight back into a new dirt-body and fresh terrifying miseries. As long as you possess even a microscopic 'Hunger' to attain anything in this physical world, you can absolutely never be free. 
            Moksha is undeniably not some cheap magical boon dropping from the sky. Moksha is strictly exactly that supreme state where absolutely 100% of your pathetic desires have been violently burned to ash. 
            The exact split-second you permanently stop begging for absolutely anything from the physical world, in that exact moment, you instantly become God Himself.
        """.trimIndent()
    ),
    MahaShloka(
        id = 5,
        sanskrit = "जीवन्मुक्तः स विज्ञेयो यस्य नोदेति वासना । दुःखेष्वनुद्विग्नमनाः सुखेषु विगतस्पृहः ॥",
        hindi = """
            (जीवनमुक्त के साक्षात् लक्षण): दुनिया में 'जीवनमुक्त' (जीते जी मोक्ष पाने वाला) केवल उसी इंसान को जानना चाहिए (स विज्ञेयो), जिसके मन में अब कभी भी कोई नई 'वासना' (इच्छा) पैदा ही नहीं होती (नोदेति वासना)। 
            जो भयंकर से भयंकर दुखों के आने पर भी अंदर से बिल्कुल विचलित और परेशान नहीं होता (दुःखेष्वनुद्विग्नमनाः), और जो बड़े से बड़े सुखों के मिलने पर भी उनके प्रति कोई लालच या खुशी नहीं दिखाता (सुखेषु विगतस्पृहः)। 
            यह श्लोक एक आत्मज्ञानी योगी का असली 'एक्स-रे' (X-Ray) है। लोग सोचते हैं कि जीवनमुक्त वह है जो हवा में उड़ता हो या चमत्कार करता हो। 
            उपनिषद कहता है कि असली चमत्कार हवा में उड़ना नहीं है, असली चमत्कार है—जब तुम्हारा पूरा परिवार या संपत्ति नष्ट हो जाए, तब भी तुम्हारे मन की शांति 1% भी न हिले! 
            और जब तुम्हें दुनिया का सारा खजाना मिल जाए, तब भी तुम्हारी धड़कन तेज न हो। जो इंसान इस 'न्यूट्रल' (Neutral) अवस्था में आ गया, जिसके अंदर न पाने की खुशी बची है न खोने का डर, वही वास्तव में 24 घंटे साक्षात् ईश्वर की अवस्था में जी रहा है।
        """.trimIndent(),
        english = """
            (The explicit characteristics of a Jivanmukta): In this entire world, strictly exclusively only that specific individual must be recognized as a 'Jivanmukta' (one fully liberated while alive) (Sa vijneyo), within whose pure mind absolutely no new 'Vasana' (toxic desire) ever violently erupts again (Nodeti vasana). 
            He who completely flawlessly remains terrifyingly unagitated, undisturbed, and deeply peaceful (Duhkheshvanudvignamanah) directly amidst the most brutal, crushing miseries, and who aggressively displays absolutely zero toxic greed or cheap excitement (Sukheshu vigatasprihah) even when showered with the most extreme worldly pleasures. 
            This explosive verse is the absolute authentic 'X-Ray' of a truly enlightened master Yogi. Ignorant people foolishly believe a Jivanmukta is someone who magically flies in the air or performs cheap physical miracles. 
            The Upanishad fiercely roars that the true miracle is absolutely not flying; the real miracle is—when your entire physical wealth or family is brutally destroyed, your internal peace absolutely does not shake even by 1%! 
            And when you are violently handed the entire treasure of the planet, your heartbeat absolutely does not rise. The human who has flawlessly achieved this terrifyingly 'Neutral' state, possessing strictly zero joy of gaining and zero fear of losing, is undeniably living 24 hours a day exactly in the absolute state of God.
        """.trimIndent()
    ),
    MahaShloka(
        id = 6,
        sanskrit = "अयं निजो परो वेति गणना लघुचेतसाम् । उदारचरितानां तु वसुधैव कुटुम्बकम् ॥",
        hindi = """
            (वसुधैव कुटुम्बकम् - सनातन का सबसे बड़ा मंत्र): "यह मेरा अपना है, और वह पराया (दूसरे का) है" (अयं निजो परो वेति)—इस तरह का हिसाब-किताब और भेदभाव केवल छोटी और नीच बुद्धि वाले (लघुचेतसाम्) लोग ही करते हैं। 
            परंतु जो लोग विशाल हृदय वाले, महान और आत्मज्ञानी (उदारचरितानां) हैं, उनके लिए तो यह पूरी धरती और पूरा ब्रह्मांड ही उनका अपना साक्षात् 'परिवार' (वसुधैव कुटुम्बकम्) है। 
            महा उपनिषद का यह श्लोक दुनिया का सबसे महान और सबसे ज्यादा उद्धृत (Quoted) किया जाने वाला श्लोक है। यह श्लोक इंसान के अहंकार और उसकी बनाई हुई 'सरहदों' (Borders) को एक झटके में लात मार देता है! 
            हम लोग जाति, धर्म, देश और भाषा के नाम पर दीवारों में बंटे हुए हैं। हम अपने 4 लोगों के परिवार को बचाने के लिए दूसरों का गला काट देते हैं। 
            लेकिन एक महापुरुष (ज्ञानी) की चेतना इतनी बड़ी होती है कि वह एक पेड़, एक जानवर, और एक अजनबी इंसान को भी बिल्कुल अपने सगे भाई की तरह देखता है। 
            जब पूरी दुनिया में केवल एक ही 'आत्मा' (God) सांस ले रही है, तो पराया कौन है? अद्वैत वेदांत की यही सबसे बड़ी उड़ान है जहाँ इंसान का 'मैं' पूरे ब्रह्मांड के बराबर हो जाता है।
        """.trimIndent(),
        english = """
            (Vasudhaiva Kutumbakam - The absolute greatest mantra of Sanatana): "This exact person is my very own, and that person is an alien stranger" (Ayam nijo paro veti)—this pathetic, toxic calculation and cheap discrimination is performed strictly and exclusively by humans possessing a highly narrow, petty, and inferior intellect (Laghucetasam). 
            However, for those supreme, enlightened masters possessing a massively expansive heart and infinite consciousness (Udaracharitanam), this entire physical earth and the infinite cosmos is explicitly, literally their very own absolute 'Family' (Vasudhaiva Kutumbakam). 
            This phenomenal verse from the Maha Upanishad is undeniably the absolute most magnificent and widely quoted verse in the entire world. This verse violently, ruthlessly kicks away the human ego and absolutely all fake, man-made 'Borders' in a single terrifying stroke! 
            We ignorant humans remain pathetically divided behind massive fake walls of caste, toxic religion, nations, and languages. We aggressively slit the throats of others purely to blindly protect our own tiny family of 4 people. 
            But a Mahapurusha's (master's) consciousness is so terrifyingly massive that he flawlessly perceives a physical tree, an animal, and a total stranger exactly identically as his own biological brother. 
            When strictly only One 'Soul' (God) is violently breathing through the entire physical universe, who exactly is a stranger? This is the absolute highest flight of Advaita Vedanta where a human's tiny 'I' physically expands to flawlessly equal the entire infinite cosmos.
        """.trimIndent()
    ),
    MahaShloka(
        id = 7,
        sanskrit = "मांसपाञ्चालिकायास्तु यन्त्रलोलेऽङ्गपञ्जरे । स्नाय्वस्थिग्रन्थिशालिन्याः स्त्रियाः किमिव शोभनम् ॥",
        hindi = """
            (शरीर का चीरहरण और वैराग्य): यह मानव शरीर (विशेषकर जिसके प्रति वासना होती है) वास्तव में क्या है? यह केवल मांस की एक 'कठपुतली' (मांसपाञ्चालिका) है, जो हड्डियों के एक हिलते हुए पिंजरे (अङ्गपञ्जरे) रूपी मशीन (यन्त्र) पर टिकी है! 
            जो नसों, हड्डियों और गांठों (स्नाय्वस्थिग्रन्थि) से जकड़ी हुई है, ऐसी स्त्री या पुरुष के शरीर में भला 'सुंदरता' (शोभनम्) नाम की क्या चीज़ है? 
            यह श्लोक इंसान की 'कामवासना' (Lust) पर सबसे सीधा और सबसे भयंकर प्रहार करता है! दुनिया के 99% लोग शरीर की बाहरी चमड़ी (Skin) को देखकर पागल हैं और उसी के पीछे अपनी पूरी जिंदगी, पैसा और शांति बर्बाद कर देते हैं। 
            उपनिषद ऋषि यहाँ शरीर का साक्षात् 'पोस्टमार्टम' (Post-mortem) कर रहे हैं। वो कहते हैं कि चमड़ी को जरा सा हटाकर देखो—अंदर केवल खून, हड्डियां, नसें और मल-मूत्र भरा है! 
            तुम किस चीज़ से प्यार कर रहे हो? एक मांस की मशीन से? जब साधक इस सच्चाई को रोज ध्यान में देखता है, तो उसके मन से भयंकर वासना (Lust) एक झटके में राख हो जाती है और उसे साक्षात् वैराग्य प्राप्त होता है।
        """.trimIndent(),
        english = """
            (The brutal dissection of the body and detachment): What exactly is this highly praised human physical body (especially the one that triggers intense lust)? It is strictly and exclusively nothing but a pathetic 'Meat Puppet' (Mamsapanchalika), violently assembled exactly on a highly unstable, moving machine-like cage of raw bones (Angapanjare)! 
            Violently bound and tied together purely by strings of nerves, bloody bones, and gross biological knots (Snayvasthigranthi)—what exactly is even microscopically 'Beautiful' or 'Attractive' (Shobhanam) in such a physical male or female body? 
            This explosive verse launches the absolute most direct and terrifyingly brutal physical strike strictly against human 'Lust' (Kamavasana)! 99% of ignorant humans globally are pathetically entirely mad simply looking at the superficial outer biological 'Skin', violently ruining their entire precious lives, wealth, and supreme peace purely chasing it. 
            The Upanishadic sage here is aggressively performing a literal naked 'Post-mortem' of the physical dirt-body. He fiercely screams: simply peel away a millimeter of that fake skin—inside it is completely violently packed purely with raw blood, rotting bones, nervous tissue, and feces! 
            What exactly are you blindly falling in love with? A pathetic biological meat-machine? Exactly when the supreme seeker relentlessly meditates strictly upon this brutal reality daily, his terrifying, toxic blinding 'Lust' is permanently, violently slaughtered to ash in a single stroke, instantly unlocking absolute Vairagya.
        """.trimIndent()
    ),
    MahaShloka(
        id = 8,
        sanskrit = "यथैव स्वप्नजगन्मिथ्या जाग्रज्जगदपि तथा । मिथ्यात्वे सति सम्मूढो भ्राम्यत्यज्ञानतस्तथा ॥",
        hindi = """
            (जागृत संसार भी एक सपना है): जिस प्रकार इंसान को नींद में दिखने वाला 'सपनों का संसार' (स्वप्नजगत्) पूरी तरह से झूठा (मिथ्या) होता है, ठीक उसी प्रकार यह 'जागते हुए दिखने वाली दुनिया' (जाग्रज्जगत्) भी 100% एक भ्रम और झूठी है! 
            इस संसार के पूरी तरह से 'मिथ्या' (झूठा / Illusion) होने के बावजूद, यह भारी अज्ञानी और मूर्ख इंसान (सम्मूढो) अपने घोर अज्ञान के कारण (अज्ञानतस्तथा) इसी झूठी दुनिया में पागलों की तरह भटकता (भ्राम्यति) रहता है। 
            यह श्लोक अद्वैत वेदांत का 'मैट्रिक्स' (Matrix) मोमेंट है! जब आप सपने में होते हैं, तो सपने का बाघ (Tiger) और सपने का दर्द बिल्कुल असली लगता है। लेकिन जागने पर पता चलता है कि वह सब दिमाग का एक खेल था। 
            उपनिषद गर्जना करता है कि अभी आप खुली आँखों से जो गाड़ियाँ, बैंक बैलेंस, रिश्ते और अपनी इज्जत देख रहे हैं, वह सब भी एक बहुत लंबा 'सपना' (Dream) ही है! 
            मौत के समय यह सारा सपना एक झटके में टूट जाएगा। लेकिन अज्ञानी इंसान इस सपने को सच मानकर इसमें पैसा और पावर (Power) इकट्ठा करने में अपनी पूरी जिंदगी गँवा देता है। जो इस माया को समझ लेता है, वह इस दुनिया में एक 'गेम' (Game) की तरह जीता है, उसमें फँसता नहीं।
        """.trimIndent(),
        english = """
            (The waking world is strictly also a Dream): Exactly just as the highly vivid 'Dream World' (Svapnajagat) perceived blindly during deep sleep is entirely, flawlessly fake and fundamentally an illusion (Mithya), in the exact identical terrifying manner, this 'Waking Physical World' (Jagrajjagat) is strictly also 100% a massive cosmic illusion! 
            Despite this entire physical universe being flawlessly and absolutely 'Mithya' (Fake / A Matrix), this heavily ignorant, deeply deluded fool (Sammudho) blindly, pathetically endlessly wanders and violently struggles (Bhramyati) purely driven by his terrifying dark ignorance (Ajnana). 
            This spectacular verse is undeniably the absolute 'Matrix' realization moment of Advaita Vedanta! Exactly when you are deeply trapped in a nightmare, the dream-tiger and the dream-pain feel violently, physically real. But the exact split-second you awaken, you realize it was strictly nothing but a pathetic projection of your own brain. 
            The Upanishad fiercely roars that exactly right now, with wide-open eyes, the expensive cars, bank balances, fake relationships, and physical ego you fiercely defend are absolutely also strictly a prolonged cosmic 'Dream'! 
            Exactly at the precise moment of physical death, this entire fake dream will violently shatter in one stroke. But the deeply ignorant fool blindly considers this fake matrix as absolute reality, violently wasting his entire human life desperately accumulating fake physical power. The master who profoundly grasps this Maya flawlessly lives in this world exactly like playing a 'Game', absolutely never getting trapped in it.
        """.trimIndent()
    ),
    MahaShloka(
        id = 9,
        sanskrit = "न प्रहृष्यति सम्माने नापमाने कुप्यति । न चोद्विजति संसारे स मुक्त इति कथ्यते ॥",
        hindi = """
            (मुक्त पुरुष का व्यवहार): जो व्यक्ति दुनिया में बहुत बड़ा 'सम्मान' (इज्जत / Awards) मिलने पर बिल्कुल भी खुश होकर उछलता नहीं है (न प्रहृष्यति), और भयंकर 'अपमान' (Insult) होने पर जरा सा भी क्रोधित नहीं होता (नापमाने कुप्यति)। 
            जो इस भयानक और उतार-चढ़ाव वाले 'संसार' में कभी भी घबराता या विचलित नहीं होता (न चोद्विजति); वास्तव में केवल उसी इंसान को सच्चा 'मुक्त' (Liberated / आज़ाद) कहा जाता है। 
            यह श्लोक 'इमोशनल इंटेलिजेंस' (Emotional Intelligence) और आध्यात्म का सबसे ऊँचा शिखर है। हमारी सारी ऊर्जा (Energy) केवल दूसरों के 'रिएक्शन' (Reaction) को संभालने में चली जाती है। कोई तारीफ करे तो हम फूल जाते हैं, कोई गाली दे तो हम डिप्रेशन में चले जाते हैं। 
            हम एक कठपुतली (Puppet) हैं जिसका रिमोट कंट्रोल दुनिया के हाथ में है! 
            लेकिन जो 'मुक्त' महापुरुष है, उसने अपना रिमोट कंट्रोल दुनिया से छीन लिया है। उसकी नज़र में दुनिया की गालियां और दुनिया के अवॉर्ड (Awards) दोनों कचरे के समान हैं। 
            वह चट्टान की तरह स्थिर है। जब तुम्हारा 'ईगो' (Ego) मर जाता है, तो तुम्हें न कोई बेइज्जत कर सकता है, और न ही कोई झूठी तारीफ से तुम्हें फँसा सकता है।
        """.trimIndent(),
        english = """
            (The absolute behavior of a Liberated Master): That supreme individual who absolutely does not jump in cheap joy or physical excitement (Na prahrisyati) even when showered with massive global 'Honors' (Sammane), and who absolutely does not violently explode in toxic anger (Napamane kupyati) even when subjected to the most brutal, crushing 'Insults'. 
            He who completely flawlessly never panics, never gets terrified, and absolutely never becomes agitated (Na chodvijati) strictly amidst the terrifying chaos of this physical 'Samsara'; he, and exclusively strictly he alone, is genuinely, authentically called completely 'Liberated' (Mukta). 
            This explosive verse is undeniably the absolute highest ultimate summit of both 'Emotional Intelligence' and supreme spirituality. Literally all our precious life-energy is violently drained purely managing the cheap 'Reactions' of fake people. If someone blindly flatters us, our ego violently swells; if someone brutally insults us, we aggressively sink into deep depression. 
            We are strictly nothing but pathetic Puppets whose absolute remote control is permanently held strictly by ignorant society! 
            But the completely 'Liberated' Mahapurusha has violently ruthlessly snatched his remote control strictly back from the fake world. In his supreme flawless vision, the world's harshest insults and the world's grandest awards are absolutely completely identically worthless garbage. 
            He is terrifyingly immovable, exactly like a massive mountain. Exactly when your fake 'Ego' is permanently slaughtered, absolutely no one can ever possibly degrade you, nor can anyone ever trap you with cheap flattery.
        """.trimIndent()
    ),
    MahaShloka(
        id = 10,
        sanskrit = "देहाभिमानपाशेन बद्धो भवति देहभृत् । तदभावेन निर्मुक्तो जीवन्मुक्तः स उच्यते ॥",
        hindi = """
            (देह-अभिमान ही सबसे बड़ी जंजीर है): यह जीव (इंसान) केवल और केवल अपने 'देहाभिमान' (मैं यह शरीर हूँ—इस अहंकार) रूपी भयंकर फांसी के फंदे (पाशेन) से ही इस संसार में बंधा हुआ (बद्धो) है। 
            जब इंसान के अंदर से यह शरीर का अहंकार 100% खत्म (तदभावेन) हो जाता है, तब वह तुरंत सारी जंजीरों से पूरी तरह आज़ाद (निर्मुक्तो) हो जाता है, और उसी पल उसे 'जीवन्मुक्त' (जीते जी मुक्त) कहा जाता है। 
            पूरी दुनिया की सारी समस्याओं की जड़ केवल एक ही सोच है—"मैं यह शरीर हूँ।" इसी सोच के कारण इंसान को बीमारी से डर लगता है, मौत से डर लगता है, और वह शरीर को सजाने के लिए पैसे के पीछे भागता है। 
            महा उपनिषद चेतावनी देता है कि शरीर का यह घमंड लोहे की जंजीर नहीं, बल्कि एक मनोवैज्ञानिक (Psychological) फांसी का फंदा है जो तुमने खुद अपने गले में डाल रखा है! 
            ज्ञान की तलवार (वेदांत) से इस फंदे को काट दो। जैसे ही तुम गहराई से यह स्वीकार करते हो कि "मैं शरीर नहीं, बल्कि वो चेतना हूँ जो इस शरीर को चला रही है", मौत का सारा डर उसी पल राख हो जाता है और तुम 'जीवन्मुक्त' हो जाते हो!
        """.trimIndent(),
        english = """
            (Body-ego is the absolute ultimate chain): This biological living entity (human) is violently and exclusively permanently bound and chained (Baddho) to this terrifying physical Samsara strictly by the massive hangman's noose (Pashena) of 'Dehabhimana' (the toxic blinding arrogance screaming "I am strictly this physical dirt-body"). 
            Exactly the split-second this pathetic, toxic body-ego is 100% violently completely annihilated (Tadabhaven) entirely from the human mind, he instantly flawlessly becomes completely irreversibly liberated (Nirmukto) directly from absolutely all cosmic chains, and in that exact moment, he is profoundly called a 'Jivanmukta' (liberated while alive). 
            The absolute literal root cause of absolutely 100% of the entire world's massive suffering is strictly exclusively one single toxic thought—"I am this physical body." Strictly purely because of this one blinding delusion, a human is terrified of microscopic diseases, paralyzed by the fear of death, and blindly aggressively chases cheap money merely to decorate rotting flesh. 
            The Maha Upanishad fiercely warns that this massive toxic arrogance of the physical body is absolutely not a physical iron chain, but rather a terrifying psychological hangman's noose that you yourself have voluntarily blindly tightened exactly around your own neck! 
            Ruthlessly aggressively cut this toxic noose entirely using the blinding sword of Wisdom (Vedanta). The exact second you profoundly accept, "I am absolutely not this dirt-body, but undeniably the infinite Consciousness operating it," the entire terrifying fear of death is instantly permanently reduced to worthless ash, and you are flawlessly 'Jivanmukta'!
        """.trimIndent()
    ),
    MahaShloka(
        id = 11,
        sanskrit = "अहमेव परं ब्रह्म सुनिश्चित्य विचार्य च । देहाद्यभिमानं त्यक्त्वा तिष्ठेदानन्दवारिधौ ॥",
        hindi = """
            (मैं ही परब्रह्म हूँ): निरंतर आत्म-विचार (विचार्य) और गहरे ध्यान के द्वारा, यह 100% निश्चित (सुनिश्चित्य) कर लेने के बाद कि "मैं ही साक्षात् परम ब्रह्म हूँ" (अहमेव परं ब्रह्म); 
            योगी को चाहिए कि वह अपने इस भौतिक शरीर और मन के झूठे अहंकार (देहाद्यभिमानं) को पूरी तरह से त्याग (त्यक्त्वा) दे, और हमेशा के लिए 'परमानंद के महासागर' (आनन्दवारिधौ) में मग्न होकर स्थित (तिष्ठेत्) हो जाए। 
            यह श्लोक अद्वैत ज्ञान की सबसे ऊंची छलांग (Highest Leap) है। तुम भगवान से अलग नहीं हो, तुम भगवान का कोई अंश भी नहीं हो; तुम 'खुद' ही वह संपूर्ण परम शक्ति हो! 
            जब यह ज्ञान किताबों से निकलकर तुम्हारे 'अनुभव' (Experience) में उतरता है, तो तुम्हारे अंदर का वह छोटा सा इंसान (जो कल तक नौकरी, पैसे और इज्जत के लिए रोता था) हमेशा के लिए मर जाता है। 
            और उसकी जगह एक ऐसा शेर जन्म लेता है जो मौत को देखकर भी हँसता है। अहंकार को कूड़ेदान में फेंक दो, और उस अनंत 'आनंद के समंदर' (Ocean of Bliss) में छलांग लगा दो जो तुम्हारे खुद के हृदय में लहरें मार रहा है!
        """.trimIndent(),
        english = """
            (I Myself Am The Supreme Brahman): Through relentless, aggressive self-inquiry (Vicharya) and terrifyingly deep meditation, exactly after flawlessly permanently establishing the absolute 100% conviction (Sunishchitya) that "I Myself explicitly literally Am the Absolute Supreme Brahman" (Ahameva param Brahma); 
            The supreme Yogi must aggressively, ruthlessly, and permanently abandon and kick away (Tyaktva) absolutely all fake, toxic arrogance and attachment strictly to his physical dirt-body and mind (Dehadyabhimanam), and permanently establish himself entirely immersed strictly in the infinite 'Ocean of Supreme Bliss' (Anandavaridhau). 
            This spectacular explosive verse is the absolute Highest Leap of supreme Advaitic wisdom. You are absolutely not separate from God, you are undeniably not a tiny microscopic fraction of God; you 'Yourself' explicitly are the exact Complete Absolute Supreme Infinite Power! 
            Exactly when this terrifying wisdom aggressively jumps straight out of dead books and violently crashes entirely into your raw 'Experience', that pathetic tiny human inside you (who blindly wept purely for cheap jobs, fake money, and external respect yesterday) is violently permanently slaughtered forever. 
            And strictly exactly in his place, a terrifying Lion is instantly born who flawlessly laughs directly in the face of literal physical death. Ruthlessly throw your fake toxic ego directly into the garbage bin, and violently dive entirely into that infinite 'Ocean of Bliss' that is aggressively roaring strictly within your own chest!
        """.trimIndent()
    ),
    MahaShloka(
        id = 12,
        sanskrit = "ज्ञानाग्निः सर्वकर्माणि भस्मसात् कुरुते तथा । तस्मात् ज्ञानं सदाभ्यस्येत् मोक्षार्थी विगतज्वरः ॥",
        hindi = """
            (ज्ञानाग्नि सारे कर्मों को जला देती है): जिस प्रकार भयंकर आग लकड़ियों के बड़े से बड़े ढेर को जलाकर राख कर देती है, ठीक उसी प्रकार 'ज्ञान की आग' (ज्ञानाग्निः) इंसान के पिछले सभी जन्मों के करोड़ों संचित कर्मों (सर्वकर्माणि) को एक पल में भस्म (भस्मसात्) कर देती है! 
            इसलिए मोक्ष की इच्छा रखने वाले साधक (मोक्षार्थी) को चाहिए कि वह अपने मन की सारी चिंताओं और मानसिक बुखार (विगतज्वरः) को त्याग कर, हमेशा केवल 'आत्मज्ञान' का ही निरंतर अभ्यास (सदाभ्यस्येत्) करे। 
            लोग डरते हैं कि "मैंने बहुत पाप किए हैं, मेरा क्या होगा? मुझे अपने कर्मों की सजा भुगतनी पड़ेगी।" उपनिषद कहता है—बकवास! 
            अगर तुम अंधेरे कमरे में 100 साल से बैठे हो, तो क्या रोशनी को आने में 100 साल लगेंगे? नहीं! एक माचिस जलते ही 100 साल का अंधेरा एक सेकंड में गायब हो जाता है। 
            उसी तरह, 'मैं ब्रह्म हूँ'—इस ज्ञान का एक भी स्पार्क (Spark) तुम्हारे लाखों जन्मों के पापों और कर्मों के बही-खाते को एक झटके में जलाकर ज़ीरो (Zero) कर देता है। इसलिए डरना छोड़ो, और ज्ञान की इस आग को अपने अंदर जलाओ!
        """.trimIndent(),
        english = """
            (The Fire of Wisdom burns all Karma): Exactly just as a terrifying blazing fire ruthlessly burns even the most massive mountain of dry wood entirely into worthless ash, in the exact identical manner, the explosive 'Fire of Supreme Wisdom' (Jnanagnih) violently and permanently reduces exactly all accumulated millions of karmas (Sarvakarmani) strictly from infinite past births entirely into dead ash (Bhasmasat) in a single split-second! 
            Therefore, the supreme seeker desperately desiring ultimate Moksha (Moksharthi) must aggressively completely abandon absolutely all toxic psychological anxiety and mental fever (Vigatajvarah), and relentlessly, permanently exclusively practice and fiercely cultivate absolutely nothing but pure 'Self-knowledge' (Sadabhyasyet). 
            Deeply ignorant people are pathetically terrified screaming, "I have committed massive horrific sins, what will happen to me? I will brutally suffer for my karmas." The Upanishad fiercely screams—Utter nonsense! 
            If you have been sitting pathetically strictly in a pitch-black dark room for exactly 100 years, does the pure light literally take 100 years to enter? Absolutely not! The exact split-second a single match is struck, 100 years of dense darkness is violently annihilated in one second. 
            In the exact identical manner, even a single atomic Spark of the absolute realization "I Am Brahman" violently instantly burns the entire massive account book of millions of births of fake sins and karmas perfectly to Zero in one stroke. Therefore, aggressively abandon all cheap fear, and violently ignite this exact terrifying fire of Wisdom deep inside you!
        """.trimIndent()
    ),
    MahaShloka(
        id = 13,
        sanskrit = "न देहो न च जीवात्मा नेन्द्रियाणि मनो न च । अहमेवाव्ययं ब्रह्म नात्र कार्या विचारणा ॥",
        hindi = """
            (मैं केवल अव्यय ब्रह्म हूँ): मैं यह नाशवान 'शरीर' (देह) बिल्कुल नहीं हूँ, मैं जन्म-मरण के चक्र में फँसने वाला 'जीवात्मा' भी नहीं हूँ, मैं ये बाहरी 'इंद्रियां' (आंख, कान आदि) भी नहीं हूँ, और मैं यह चंचल 'मन' (Mind) भी बिल्कुल नहीं हूँ! 
            मैं तो साक्षात् केवल और केवल वह 'अव्यय' (जो कभी न बदले और न नष्ट हो) 'परम ब्रह्म' (अहमेवाव्ययं ब्रह्म) ही हूँ! इस परम सत्य में जरा सा भी विचार या संदेह (नात्र कार्या विचारणा) करने की कोई आवश्यकता नहीं है! 
            यह श्लोक ध्यान (Meditation) का सबसे बड़ा फॉर्मूला है, जिसे 'नेति-नेति' (Neti-Neti / यह नहीं, यह नहीं) कहा जाता है। जब तुम ध्यान में बैठते हो, तो अपने आप से कहो—"मैं शरीर नहीं हूँ, क्योंकि यह कट सकता है। मैं मन नहीं हूँ, क्योंकि यह लगातार बदल रहा है।" 
            जब तुम एक-एक करके इन सारे झूठे छिलकों (Layers) को उतार कर फेंक देते हो, तो अंत में जो शुद्ध, नंगी और शांत 'चेतना' (Pure Awareness) बचती है, वही तुम हो! 
            वह चेतना कभी जन्म नहीं लेती, कभी नहीं मरती। इस बात पर 99% नहीं, बल्कि पूरे 100% गारंटी के साथ यकीन करो, इसमें कोई शक (Doubt) मत रखो।
        """.trimIndent(),
        english = """
            (I Am Exclusively the Indestructible Brahman): I am absolutely undeniably NOT this perishable, rotting physical 'Body' (Deha), I am completely NOT the tiny 'Jivatma' pathetically trapped strictly in the endless cycle of birth and death, I am fiercely NOT these external physical 'Senses' (Indriyas like eyes, ears), and I am absolutely, completely NOT this wildly restless 'Mind' (Mano)! 
            I Myself explicitly, exclusively, and literally Am entirely that absolute 'Avyaya' (Imperishable, Indestructible, Unchanging) 'Supreme Brahman' (Ahamevavyayam Brahma)! There is absolutely zero room for even a microscopic fraction of a single doubt or hesitation (Natra karya vicharana) regarding this absolute ultimate truth! 
            This spectacular verse is undeniably the absolute greatest explicit formula for supreme Meditation, profoundly known exactly as 'Neti-Neti' (Not this, Not this). Exactly when you sit flawlessly still in deep meditation, aggressively violently declare to yourself—"I am strictly not this dirt-body, purely because it can be physically cut. I am absolutely not this mind, purely because it is violently continuously changing." 
            Exactly when you ruthlessly violently peel away and aggressively throw away absolutely all these fake, toxic biological and psychological layers one by one, the exact ultimate pure, naked, and terrifyingly silent 'Consciousness' (Pure Awareness) that flawlessly remains at the absolute core, exactly that alone is You! 
            That supreme consciousness absolutely never takes birth, absolutely never dies. Forcefully aggressively believe this entirely with absolute 100% guarantee, not 99%; maintain strictly absolutely zero toxic Doubt regarding this.
        """.trimIndent()
    ),
    MahaShloka(
        id = 14,
        sanskrit = "मनसो निग्रहायैव सर्वं वेदान्तमुच्यते । निर्विकल्पे समाधौ तु शान्तिरेवावशिष्यते ॥",
        hindi = """
            (मन को मारना ही वेदांत है): यह जितना भी विशाल 'वेदांत' (उपनिषद, गीता और शास्त्रों का ज्ञान) कहा गया है, उसका केवल एक ही मुख्य उद्देश्य है—इंसान के चंचल और विद्रोही 'मन' (मनसो) का पूरी तरह से निग्रह (कंट्रोल / नाश) करना! 
            जब यह मन पूरी तरह से शांत होकर उस 'निर्विकल्प समाधि' (वह अवस्था जहाँ मन में एक भी विचार या विकल्प न बचे) में डूब जाता है, तब अंत में केवल और केवल 'परम शांति' (शान्तिरेवावशिष्यते) ही बाकी रह जाती है। 
            वेदांत कोई दिमागी कसरत या डिबेट (Debate) करने का विषय नहीं है! अगर तुम 100 उपनिषद रट लो, लेकिन तुम्हारा मन अभी भी पैसे, वासना और ईगो के लिए भाग रहा है, तो तुम्हारी सारी पढ़ाई कचरा है। 
            वेद और उपनिषद केवल इसलिए बनाए गए हैं ताकि तुम्हारे इस 'बंदर जैसे मन' (Monkey-mind) को हमेशा के लिए मारा जा सके (Mano-nasha)। 
            जब मन मरता है, तो इंसान निर्विकल्प समाधि में चला जाता है। वहाँ कोई विचार नहीं, कोई 'मैं' नहीं, कोई दुनिया नहीं... वहाँ केवल एक ऐसा सन्नाटा और शांति होती है जो ब्रह्मांड के विस्फोट से भी ज्यादा शक्तिशाली है!
        """.trimIndent(),
        english = """
            (Slaughtering the Mind is the sole purpose of Vedanta): The absolute entirety of this massively expansive 'Vedanta' (the supreme wisdom of all Upanishads, Gita, and scriptures) is aggressively spoken and propagated strictly and exclusively for one absolute single supreme purpose—the complete, violent subjugation and total annihilation (Nigrahaya) of the hopelessly restless, rebellious human 'Mind' (Manaso)! 
            Exactly the split-second this chaotic mind becomes flawlessly entirely silent and violently plunges directly into that absolute 'Nirvikalpa Samadhi' (the terrifyingly supreme state where absolutely zero thoughts or mental modifications survive), then in the absolute end, purely and exclusively 'Supreme Infinite Peace' strictly alone remains (Shantirevavashishyate). 
            Vedanta is absolutely, undeniably not a cheap intellectual gymnastics exercise or a fake academic subject purely for arrogant Debate! If you blindly memorize 100 heavy Upanishads, but your pathetic mind still aggressively violently chases cheap money, toxic lust, and physical ego, your entire heavy scriptural study is literal worthless garbage. 
            The absolute supreme Vedas and Upanishads were forcefully constructed purely and exclusively to ruthlessly and permanently slaughter this toxic, bouncing 'Monkey-mind' forever (Mano-nasha). 
            Exactly when the fake mind is violently permanently slaughtered, the human seamlessly enters absolute Nirvikalpa Samadhi. There are absolutely zero thoughts there, strictly no fake 'I', absolutely no physical world... there is entirely exclusively exactly a terrifying silence and supreme peace that is infinitely vastly more powerful than a literal cosmic explosion!
        """.trimIndent()
    ),
    MahaShloka(
        id = 15,
        sanskrit = "सर्वं खल्विदं ब्रह्म नेह नानास्ति किञ्चन । य एवं वेद तत्त्वेन स जीवन्मुक्त उच्यते ॥",
        hindi = """
            (सब कुछ ब्रह्म है, दूसरा कुछ नहीं): यह जो कुछ भी सामने दिखाई दे रहा है, यह पूरा ब्रह्मांड और इसका कण-कण वास्तव में केवल 'साक्षात् ब्रह्म' (सर्वं खल्विदं ब्रह्म) ही है। इस पूरी सृष्टि में ब्रह्म के अलावा दूसरा कोई भी अलग (नाना / अनेक) अस्तित्व है ही नहीं (नेह नानास्ति किञ्चन)! 
            जो इंसान इस परम सत्य को गहराई से (तत्त्वेन) अपनी आत्मा में अनुभव कर लेता है (य एवं वेद), केवल उसी महापुरुष को वास्तव में 'जीवन्मुक्त' (स जीवन्मुक्त उच्यते) कहा जाता है। 
            यह श्लोक अद्वैत वेदांत का 'ग्रैंड फिनाले' (Grand Finale) है! विज्ञान (Quantum Physics) भी आज कह रहा है कि पूरा यूनिवर्स केवल एक ही ऊर्जा (Energy) का रूप है। 
            यहाँ न कोई तुम्हारा दोस्त है, न कोई दुश्मन। न यह फोन तुम्हारा है, न यह शरीर तुम्हारा है। जो तुम्हें लकड़ी दिख रही है, जो आग दिख रही है, वह सब केवल उसी एक भगवान की अलग-अलग 'ड्रेस' (Dress / रूप) है। 
            जब तुम हर चीज़ में, यहाँ तक कि अपने सबसे बड़े दुश्मन की आँखों में भी उसी परमेश्वर को देखने लगते हो, तो तुम्हारा सारा डर और नफरत हमेशा के लिए खत्म हो जाती है। इसी अवस्था का नाम जीवन्मुक्ति है!
        """.trimIndent(),
        english = """
            (Absolutely Everything is Brahman, nothing else exists): Absolutely everything that is vividly visibly appearing right exactly in front of you, this entire infinite physical cosmos and absolutely every microscopic atom of it, is strictly, literally, and explicitly exclusively 'The Supreme Brahman Itself' (Sarvam khalvidam Brahma). In this entire infinite absolute creation, there is strictly, flawlessly absolutely zero separate (Nana / multiple) or entirely different existence completely other than Brahman whatsoever (Neha nanasti kinchana)! 
            That supreme individual who flawlessly, profoundly violently experiences and perfectly realizes (Ya evam veda) this absolute ultimate truth directly in his own pure Soul strictly in essence (Tattvena), exclusively exactly that grand master is genuinely authentically called completely 'Jivanmukta' (Sa jivanmukta uchyate). 
            This explosive verse is undeniably the absolute 'Grand Finale' of Advaita Vedanta! Modern Quantum Physics is violently explicitly declaring exactly today that the entire infinite universe is strictly merely temporary manifestations of one absolute identical unified Energy. 
            There is absolutely no fake friend here, and strictly zero real enemy. This cheap physical phone is not yours, this rotting dirt-body is not yours. What vividly appears strictly as solid wood, or what physically appears exactly as blazing fire, is entirely exclusively exactly the absolute identical Supreme Lord simply wearing different temporary physical 'Dresses' (Forms). 
            Exactly the split-second you flawlessly violently begin perceiving that exact identical Supreme Lord strictly in everything, directly even in the physical eyes of your absolute worst terrifying enemy, all your cheap fear and toxic hatred are permanently brutally annihilated forever. Exactly this supreme ultimate state is profoundly named Jivanmukti!
        """.trimIndent()
    ),
    MahaShloka(
        id = 16,
        sanskrit = "तदेतत् सत्यं तदमृतं तद्वेद्धव्यं सोम्य विद्धि । यत्र गत्वा न निवर्तन्ते तद्धाम परमं मम ॥",
        hindi = """
            (वही सत्य है, वहीं जाना है): हे सोम्य (प्रिय शिष्य)! केवल और केवल वह परब्रह्म ही एकमात्र 'सत्य' (सत्यं) है, वही 'अमर' (अमृतं) है, और जीवन का एकमात्र लक्ष्य उसी परम सत्य को 'जानना' और बेधना (तद्वेद्धव्यं विद्धि) है। 
            वह ब्रह्म ही मेरी (ईश्वर की) वह परम और सर्वोच्च अवस्था (तद्धाम परमं मम) है, जहाँ पहुँचने के बाद इंसान का इस दुखों से भरे जन्म-मरण के संसार में दोबारा कभी 'लौटना नहीं' (न निवर्तन्ते) होता। 
            उपनिषद अब अपनी अंतिम मंज़िल पर पहुँच चुका है (श्लोक 17 से पहले)। भगवान चेतावनी दे रहे हैं कि यह दुनिया, ये रिश्ते, यह जवानी—सब कुछ झूठ और मरने वाला है। 
            केवल एक ही चीज़ असली है जो कभी नहीं मरेगी, और वह है तुम्हारे अंदर की 'चेतना' (Brahman)। अपने ध्यान को एक तीर (Arrow) की तरह बनाओ और उस सत्य को भेद दो! 
            एक बार जब तुम्हारी आत्मा उस परम अवस्था (State of Consciousness) में घुस जाती है, तो तुम हमेशा के लिए इस 'संसार रूपी जेल' से छूट जाते हो। फिर तुम्हें वापस इस धरती पर किसी माँ के गर्भ में रोने के लिए नहीं आना पड़ता। तुम खुद अनंत आकाश बन जाते हो!
        """.trimIndent(),
        english = """
            (That alone is the Truth, that is the ultimate destination): O Somya (dear disciple)! Strictly, exclusively, and completely ONLY that Supreme Brahman alone is the absolute undeniable 'Truth' (Satyam), exactly That alone is flawlessly 'Immortal' (Amritam), and the absolute single supreme purpose of human existence is strictly to aggressively 'Realize' and violently pierce exactly That Absolute Truth alone (Tadveddhavyam viddhi). 
            That exact Supreme Brahman alone is strictly My (the Supreme Lord's) absolute highest and ultimate supreme dimension/abode (Taddhama paramam mama), strictly reaching exactly where, the human absolutely never, ever 'Returns' (Na nivartante) entirely back into this terrifying, miserable, suffocating worldly cycle of physical birth and death. 
            The Upanishad has flawlessly completely reached its absolute final destination right here (strictly before Verse 17). The Supreme Lord is fiercely violently warning you that this physical world, these fake relationships, this temporary biological youth—absolutely everything is a pathetic lie and is entirely guaranteed to die. 
            Strictly exclusively exactly one single entity is undeniably authentic and will absolutely never die, and that is explicitly the pure 'Consciousness' (Brahman) aggressively beating inside you. Violently aggressively turn your supreme meditation exactly into a razor-sharp arrow (Arrow) and ruthlessly pierce that ultimate Truth! 
            Exactly the split-second your pure Soul violently penetrates and irreversibly merges directly into that absolute supreme state (State of Consciousness), you are permanently violently liberated entirely from this suffocating 'Jail of Samsara' forever. You absolutely never, ever have to return pathetically to this physical earth purely to weep helplessly in a biological mother's womb again. You literally physically become the exact infinite cosmic sky yourself!
        """.trimIndent()
    ),
    MahaShloka(
        id = 17,
        sanskrit = "इत्येतन्महापुण्यं महापुरुषलक्षणम् । यः पठति स महापुरुषो भवति ॥ १७ ॥",
        hindi = """
            (उपसंहार/फलश्रुति): यह जो 'महापुरुष' के लक्षणों का वर्णन किया गया है, यह अत्यंत पुण्यदायी और पवित्र ज्ञान है। जो भी साधक इस उपनिषद का निरंतर पाठ (अध्ययन और मनन) करता है, वह साक्षात् स्वयं 'महापुरुष' ही बन जाता है।
            यह केवल एक ग्रंथ नहीं है; यह एक 'इग्निशन की' (Ignition Key) है जो इंसान के अंदर छिपी हुई महानता को चालू कर देती है। जब आप बार-बार इन सत्यों को पढ़ते हैं, तो आपका मन धीरे-धीरे उन सीमित सीमाओं से बाहर निकलने लगता है।
            'महापुरुष बनना' का अर्थ कोई पदवी प्राप्त करना नहीं है; इसका अर्थ है—भय से मुक्त होना, नफरत को त्यागना और साक्षात् ईश्वर की चेतना में जीना। उपनिषद यहाँ गारंटी देता है कि अगर आप इस ज्ञान को अपनी जीवन शैली बना लेंगे, तो महानता आपकी स्वाभाविक अवस्था बन जाएगी।
            जैसे पानी में रहने वाला कमल कीचड़ से अछूता रहता है, वैसे ही जो इस ज्ञान को समझ लेता है, वह दुनिया की बुराइयों और दुखों के कीचड़ में रहते हुए भी पूरी तरह से पवित्र और मुक्त रहता है।
            यही महा उपनिषद का अंतिम लक्ष्य है—हर मनुष्य को उसके असली 'देवत्व' (Divinity) की याद दिलाना। आप तुच्छ नहीं हैं, आप महापुरुष हैं! ॐ शांतिः!
        """.trimIndent(),
        english = """
            (Conclusion/Phala-Shruti): This entire description of the supreme characteristics of the 'Mahapurusha' is undeniably immensely holy and profoundly meritorious knowledge. Whoever genuinely studies, chants, and continuously deeply meditates upon this Upanishad literally, physically becomes a 'Mahapurusha' himself.
            This is strictly not merely a book; it is a terrifyingly powerful 'Ignition Key' that violently activates the hidden supreme greatness trapped inside a human being. Exactly as you repeatedly, obsessively ingest these ultimate truths, your mind violently begins to shatter its pathetic, tiny self-imposed boundaries.
            'Becoming a Mahapurusha' absolutely does not mean attaining a social title; it explicitly means—becoming entirely liberated from all terrifying fear, ruthlessly slaughtering hatred, and living exclusively in the direct, absolute consciousness of God. The Upanishad here offers an absolute guarantee that if you aggressively transform this wisdom into your active lifestyle, supreme greatness will permanently become your natural, effortless state of existence.
            Exactly as a lotus growing in deep mud remains entirely flawlessly untouched by the filth, similarly, the human who perfectly grasps this supreme knowledge remains perfectly pure and absolutely liberated even while forcefully living in the middle of all the filth of worldly evil and suffering.
            This is the absolute ultimate, final objective of the Maha Upanishad—to forcefully remind every human being of his authentic, supreme 'Divinity'. You are absolutely not pathetic or insignificant; you are a Mahapurusha! OM Peace!
        """.trimIndent()
    )
)
