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
data class NadabinduShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NadabinduUpanishadScreen() {
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
            itemsIndexed(nadabinduShlokasList) { _, shloka ->
                NadabinduShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun NadabinduShlokaCard(shloka: NadabinduShloka) {
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

val nadabinduShlokasList: List<NadabinduShloka> = listOf(
    NadabinduShloka(
        id = 1,
        sanskrit = "अकारो दक्षिणः पक्ष उकारस्त्वितरः स्मृतः । मकारं पुच्छमित्याहुरर्धमात्रा तु मस्तकम् ॥ १ ॥",
        hindi = """
            नादबिंदु उपनिषद की शुरुआत ॐकार (प्रणव) को एक विशाल पक्षी (हंस) के रूप में ध्यान करने से होती है।
            इस ॐ रूपी पक्षी का दाहिना पंख (Right wing) 'अ' कार है, जो जाग्रत अवस्था का प्रतीक है।
            इसका बायां पंख (Left wing) 'उ' कार है, जो स्वप्न अवस्था और सूक्ष्म जगत का प्रतिनिधित्व करता है।
            विद्वान लोग 'म' कार को इस पक्षी की पूंछ (Tail) कहते हैं, जो सुषुप्ति (गहरी नींद) का प्रतीक है।
            और ॐ के ऊपर स्थित जो 'अर्धमात्रा' (बिंदु/चंद्राकार) है, वह इस पक्षी का मस्तक (Head) है।
            यह रूपक (Metaphor) साधक को ध्यान के लिए एक अत्यंत शक्तिशाली और सुंदर चित्र प्रदान करता है।
            हम केवल एक ध्वनि (Sound) का उच्चारण नहीं कर रहे हैं, बल्कि हम एक लौकिक उड़ान भर रहे हैं।
            पंख संतुलन (Balance) के प्रतीक हैं; शरीर और मन का संतुलन ही ध्यान में उड़ने की पहली शर्त है।
            पूंछ (म-कार) स्थिरता देती है, और मस्तक (अर्धमात्रा) वह सर्वोच्च चेतना है जहाँ ज्ञान का प्रकाश है।
            जब साधक इस रूप में ॐ का ध्यान करता है, तो उसका मन संसार से उठकर ब्रह्मांडीय ऊँचाइयों को छूता है।
        """.trimIndent(),
        english = """
            The Nadabindu Upanishad begins by visualizing the sacred syllable OM (Pranava) as a magnificent cosmic bird (Hamsa).
            The right wing of this OM-bird is the letter 'A', perfectly symbolizing the waking state of consciousness.
            Its left wing is the letter 'U', representing the dream state and the subtle internal world.
            The wise sages declare the letter 'M' to be the tail of this bird, symbolizing deep, dreamless sleep.
            And the 'Ardhamatra' (the crescent dot above OM) represents the majestic head of this divine bird.
            This profound metaphor provides the meditating seeker with an incredibly powerful and beautiful mental image.
            We are not merely pronouncing a sound; we are actively taking a cosmic flight toward liberation.
            Wings symbolize absolute balance; the balance of body and mind is the first condition to fly in meditation.
            The tail (M) provides stability, and the head (Ardhamatra) is that supreme consciousness holding the light of wisdom.
            When a seeker meditates on OM in this form, his mind rises from the world and touches infinite cosmic heights.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 2,
        sanskrit = "पादादीनि रजोऽस्येखौ सत्त्वं देहमुदाहृतम् । धर्मोऽस्य दक्षिणं चक्षुरधर्मोऽपरमुच्यते ॥ २ ॥",
        hindi = """
            इस ॐ रूपी पक्षी के पैर आदि अंग 'रजोगुण' (सक्रियता और चंचलता) के बने हुए माने गए हैं।
            और इस पक्षी का मुख्य शरीर (धड़) 'सत्त्वगुण' (पवित्रता, शांति और प्रकाश) का बना हुआ कहा गया है।
            इस दिव्य पक्षी की दाहिनी आँख (Right eye) को 'धर्म' (पुण्य और सही आचरण) का स्वरूप माना जाता है।
            तथा इसकी बायीं आँख (Left eye) को 'अधर्म' (पाप और अज्ञान) के रूप में वर्णित किया गया है।
            यह श्लोक प्रकृति के तीन गुणों (सत्व, रज, तम) को ध्यान के रूपक में बड़ी ही बारीकी से पिरोता है।
            पैर चलने के काम आते हैं, इसलिए उन्हें रजोगुण कहा गया है क्योंकि रजोगुण कर्म और गति का प्रतीक है।
            शरीर का मुख्य हिस्सा सत्त्वगुण है, जो यह दर्शाता है कि आत्मा का मूल स्वभाव शुद्ध और शांत है।
            दाहिनी आँख सूर्य और प्रकाश (धर्म) की प्रतीक है, जबकि बायीं आँख चंद्रमा और अंधेरे (अधर्म) की प्रतीक है।
            इस प्रकार, संपूर्ण सृष्टि (अच्छाई-बुराई, शांति-गति) ॐकार के इस एक चित्र में ही पूरी तरह समाहित है।
            योगी जब इस पक्षी का ध्यान करता है, तो वह पूरी प्रकृति (Universe) को अपने ही भीतर संतुलित कर लेता है।
        """.trimIndent(),
        english = """
            The feet and lower limbs of this OM-bird are said to be composed of 'Rajoguna' (activity and mobility).
            And the main body (torso) of this majestic bird is declared to be made entirely of 'Sattvaguna' (purity and peace).
            The right eye of this divine cosmic bird is perfectly considered to be the embodiment of 'Dharma' (righteousness).
            Whereas its left eye is described as representing 'Adharma' (unrighteousness, sin, and ignorance).
            This verse meticulously weaves the three qualities of nature (Sattva, Rajas, Tamas) into the metaphor of meditation.
            Feet are used for moving, hence they represent Rajoguna, as Rajas is the primary symbol of action and motion.
            The main body is Sattva, profoundly indicating that the fundamental core nature of the Soul is pure and tranquil.
            The right eye symbolizes the sun and light (Dharma), while the left eye symbolizes the moon and darkness (Adharma).
            Thus, the entire creation (good-evil, peace-motion) is flawlessly encapsulated within this single image of OM.
            When a Yogi meditates on this bird, he effectively balances the entire cosmic nature (Universe) right within himself.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 3,
        sanskrit = "भूर्लोकः पादयोरस्य भुवर्लोकोऽस्य जानुनि । स्वर्लोको मध्यदेशे तु महर्लोको नाभिमण्डले ॥ ३ ॥",
        hindi = """
            (अब ब्रह्मांड के लोकों को शरीर में स्थापित किया जा रहा है): इस पक्षी के पैरों में 'भूर्लोक' (पृथ्वी लोक) स्थित है।
            इसके दोनों घुटनों में 'भुवर्लोक' (अंतरिक्ष या वायु लोक) का वास माना गया है।
            इस दिव्य पक्षी के मध्य भाग (कमर के क्षेत्र) में 'स्वर्लोक' (स्वर्ग लोक) की स्थिति बताई गई है।
            और इसकी नाभि (Navel) के गोल घेरे (मंडल) में 'महर्लोक' (महान संतों का लोक) स्थापित है।
            यह वेदान्त और तंत्र शास्त्र की एक बहुत ही रहस्यमयी और शक्तिशाली प्रक्रिया है जिसे 'न्यास' कहते हैं।
            हम सोचते हैं कि ब्रह्मांड बाहर है, पर उपनिषद कहता है कि पूरा का पूरा ब्रह्मांड (Microcosm = Macrocosm) हमारे भीतर है।
            पैर धरती पर टिकते हैं, इसलिए उन्हें भूर्लोक कहा गया है; यह हमारी भौतिक चेतना का सबसे निचला स्तर है।
            जैसे-जैसे हम शरीर में ऊपर की ओर (नाभि तक) बढ़ते हैं, चेतना का स्तर सूक्ष्म और पवित्र होता जाता है।
            ध्यान के समय साधक को यह महसूस करना होता है कि वह कोई छोटा जीव नहीं, बल्कि साक्षात् ब्रह्मांड है।
            इस विराट (Cosmic) भावना से इंसान का छोटा 'अहंकार' पूरी तरह से टूटकर विशाल हो जाता है।
        """.trimIndent(),
        english = """
            (Now locating the cosmic worlds within the body): 'Bhurloka' (the Earth realm) is situated in the feet of this bird.
            In both its knees, the 'Bhuvarloka' (the intermediate space or atmospheric realm) is considered to reside.
            In the middle region (the waist area) of this divine bird, the 'Svarloka' (the Heavenly realm) is located.
            And right in the absolute center of its navel (Nabhi-mandala), the 'Maharloka' (the realm of great saints) is established.
            This is an exceedingly mystical and powerful process of Vedanta and Tantra science known deeply as 'Nyasa'.
            We falsely think the universe is outside, but the Upanishad declares the entire cosmos (Macrocosm) is right within us.
            Feet rest on the earth, hence called Bhurloka; this represents the absolute lowest, grossest level of our consciousness.
            As we move upward through the body (to the navel), the level of consciousness steadily becomes subtler and purer.
            During meditation, the seeker must intensely feel that he is not a petty creature, but the literal Cosmos itself.
            Through this vast cosmic feeling, the human's petty 'Ego' completely shatters and seamlessly expands into infinity.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 4,
        sanskrit = "जनलोको हृदि स्थाने तपोलोकः कण्ठदेशके । सत्यलोको भ्रुवोर्मध्ये भालमध्येऽवटोदितः ॥ ४ ॥",
        hindi = """
            इस ॐ रूपी पक्षी के हृदय स्थान (Heart) में 'जनलोक' (देवताओं और ऋषियों का लोक) स्थित है।
            इसके कण्ठ (गले / Throat) के प्रदेश में 'तपोलोक' (तपस्वियों का पवित्र लोक) का वास माना गया है।
            इसकी दोनों भौंहों के बीच (आज्ञा चक्र / Bhrumadhya) में सर्वोच्च 'सत्यलोक' (ब्रह्मा का लोक) स्थित है।
            और इसके मस्तक (भाल) के भी मध्य भाग (सहस्रार) में वह परम अव्यक्त तत्व (ब्रह्म) उदित होता है।
            यह श्लोक शरीर के चक्रों (Chakras) को ब्रह्मांड के सात लोकों के साथ बहुत ही वैज्ञानिक ढंग से जोड़ता है।
            हृदय (अनाहत चक्र) प्रेम और करुणा का केंद्र है, इसलिए यहाँ जनलोक की कल्पना की गई है।
            गला (विशुद्धि चक्र) वाणी और तप का केंद्र है, इसलिए यहाँ तपोलोक माना गया है।
            भौंहों के बीच का स्थान अद्वैत ज्ञान की तीसरी आँख है, इसलिए इसे सबसे ऊँचा 'सत्यलोक' कहा गया है।
            जब साधक की ऊर्जा (प्राण) पैरों से उठकर भौंहों के मध्य में पहुँचती है, तो वह सत्य को पा लेता है।
            यह ध्यान की वह यात्रा है जहाँ इंसान धरती (पैर) से उठकर सीधे सत्य (मस्तक) तक पहुँच जाता है।
        """.trimIndent(),
        english = """
            In the heart region of this OM-bird, the 'Janaloka' (the pristine realm of gods and sages) is perfectly situated.
            In the region of its throat (Kantha), the 'Tapoloka' (the sacred realm of severe ascetics) is considered to reside.
            Exactly between its two eyebrows (Ajna Chakra), the supreme 'Satyaloka' (the highest realm of Brahma) is located.
            And right in the absolute center of its forehead (Crown/Sahasrara), that supreme unmanifest principle (Brahman) rises.
            This verse highly scientifically correlates the energy centers (Chakras) of the body with the seven cosmic worlds.
            The heart (Anahata Chakra) is the supreme center of love and mercy, hence Janaloka is visualized here.
            The throat (Vishuddhi Chakra) is the center of speech and penance, hence Tapoloka is established here.
            The space between the eyebrows is the third eye of non-dual wisdom, hence called the ultimate 'Satyaloka'.
            When the seeker's vital energy (Prana) rises from the feet and reaches between the eyebrows, he attains the Truth.
            This is the profound journey of meditation where a human rises from the gross earth (feet) straight to absolute Truth (head).
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 5,
        sanskrit = "सहस्रभानुसङ्काशः सर्वव्याप्यवलोकितः । मात्रास्तु द्वादश प्रोक्तास्तासां भेदमथोच्यते ॥ ५ ॥",
        hindi = """
            वह ॐकार (अर्धमात्रा रूपी मस्तक) एक हजार सूर्यों (सहस्रभानु) के समान अत्यंत तेजस्वी और प्रकाशमान है।
            वह सर्वव्यापी (हर जगह फैला हुआ) है, और योगियों द्वारा उसी रूप में उसका साक्षात्कार (अवलोकन) किया जाता है।
            इस ॐ (नाद) की कुल बारह (12) मात्राएँ (Kalas / सूक्ष्म कंपन) ऋषियों द्वारा बताई गई हैं।
            अब मैं उन 12 मात्राओं के भेद और उनके फलों का बहुत ही विस्तार से वर्णन करता हूँ।
            यहाँ उपनिषद ॐकार के स्थूल रूप (अ, उ, म) से आगे बढ़कर उसके अत्यंत सूक्ष्म (Subtle) विज्ञान में प्रवेश कर रहा है।
            हजार सूर्यों का प्रकाश कोई भौतिक आग नहीं है, बल्कि वह 'ज्ञान का प्रकाश' है जो अज्ञान के घने अंधेरे को मिटाता है।
            जब हम ॐ का उच्चारण करके चुप होते हैं, तो उसके बाद जो गूँज (Vibration) बचती है, उसे मात्रा या कला कहते हैं।
            यह गूँज धीरे-धीरे 12 सूक्ष्म स्तरों में बँटती हुई अंत में शून्य (मौन) में विलीन हो जाती है।
            इन 12 कंपनों पर ध्यान टिकाना ही नाद-अनुसंधान का सबसे गहरा रहस्य है।
            अगले श्लोकों में बताया जाएगा कि यदि योगी इनमें से किसी एक मात्रा पर ध्यान करते हुए प्राण त्यागे, तो उसे क्या गति मिलेगी।
        """.trimIndent(),
        english = """
            That Omkara (the head represented by Ardhamatra) is as incredibly radiant and brilliant as a thousand blazing suns.
            He is completely all-pervading (omnipresent), and is directly perceived and realized in that very form by great Yogis.
            There are exactly twelve (12) Matras (Kalas / subtle micro-vibrations) of this OM declared by the ancient sages.
            Now I shall expound the profound differences and specific fruits of meditating upon those 12 subtle Matras.
            Here the Upanishad profoundly moves beyond the gross form of OM (A, U, M) and enters its extremely subtle science.
            The light of a thousand suns is not a physical fire, but the absolute 'Light of Wisdom' destroying dark ignorance.
            When we chant OM and fall silent, the lingering subtle echo (vibration) that remains is called a Matra or Kala.
            This echo slowly and systematically divides into 12 micro-levels before finally dissolving into absolute zero (Silence).
            Focusing the mind intensely on these 12 fading vibrations is the deepest, ultimate secret of Nada meditation.
            The following verses reveal exactly what destination a Yogi attains if he sheds his body while meditating on a specific Matra.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 6,
        sanskrit = "घोषिणी प्रथमा मात्रा विद्युन्मात्रा द्वितीया । पतङ्गिनी तृतीया तु वायुवेगा चतुर्थी ॥ ६ ॥",
        hindi = """
            (अब 12 सूक्ष्म मात्राओं के नाम बताए जा रहे हैं): ॐकार की जो सबसे पहली मात्रा है, उसका नाम 'घोषिणी' (गूँजने वाली) है।
            इसकी दूसरी अत्यंत सूक्ष्म मात्रा का नाम 'विद्युन्मात्रा' (बिजली के समान चमकने वाली) है।
            इसकी तीसरी मात्रा का नाम 'पतंगिनी' (पक्षी की तरह उड़ने वाली) कहा गया है।
            और इसकी चौथी मात्रा का नाम 'वायुवेगा' (हवा के समान अत्यंत तीव्र गति वाली) है।
            ये नाम केवल शब्द नहीं हैं; ये ॐ की गूँज के अनुभव (Experience) को दर्शाते हैं।
            जब ॐ की ध्वनि समाप्त होती है, तो पहली गूँज बहुत स्पष्ट होती है (घोषिणी)।
            फिर वह गूँज बिजली की तरह मन में कौंधती है (विद्युन्मात्रा), और फिर वह ध्यान में ऊपर की ओर उठने लगती है (पतंगिनी)।
            चौथी मात्रा तक पहुँचते-पहुँचते चेतना हवा की गति से (वायुवेगा) सांसारिक विचारों को पीछे छोड़ने लगती है।
            यह एक ऐसा थर्मामीटर है जिससे साधक यह नाप सकता है कि उसका ध्यान कितना गहरा जा चुका है।
            जैसे-जैसे हम आगे की मात्राओं में जाते हैं, मन का अस्तित्व (Existence) पिघल कर सूक्ष्म होता जाता है।
        """.trimIndent(),
        english = """
            (Now naming the 12 subtle Matras): The absolute first Matra (vibration) of Omkara is named 'Ghoshini' (the echoing one).
            Its second, extremely subtle Matra is known perfectly as 'Vidyunmatra' (flashing brilliantly like lightning).
            The third mystical Matra of this sound is specifically called 'Patangini' (the one that flies upwards like a bird).
            And its fourth Matra is declared to be 'Vayuvega' (possessing the intense, rapid speed of the wind).
            These names are not mere words; they precisely describe the actual internal experience of OM's fading echo.
            When the audible sound of OM ends, the very first internal echo is highly clear and resounding (Ghoshini).
            Then that echo flashes powerfully in the mind like lightning (Vidyunmatra), and begins to rise upwards (Patangini).
            By the time the fourth Matra is reached, consciousness leaves worldly thoughts behind with the speed of wind (Vayuvega).
            This serves as an exact internal thermometer for the seeker to accurately measure how deep his meditation has gone.
            As we successfully advance into the higher Matras, the very existence of the mind continuously melts and becomes subtler.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 7,
        sanskrit = "पञ्चमी नामधेया तु षष्ठी चैन्द्रीमुदाहृता । सप्तमी वैष्णवी नाम अष्टमी शाङ्करी तथा ॥ ७ ॥",
        hindi = """
            ॐकार की पाँचवीं सूक्ष्म मात्रा का नाम 'नामधेया' (नाम-रूप से जुड़ी हुई) है।
            इसकी छठी मात्रा को विद्वानों द्वारा 'ऐन्द्री' (इंद्र से संबंधित/इंद्रियों को जीतने वाली) कहा गया है।
            इसकी सातवीं पवित्र मात्रा का नाम 'वैष्णवी' (भगवान विष्णु की सर्वव्यापक शक्ति) है।
            तथा इसकी आठवीं मात्रा को 'शांकरी' (भगवान शिव की कल्याणकारी शक्ति) के नाम से जाना जाता है।
            जैसे-जैसे ध्वनि शांत होती है, वैसे-वैसे चेतना ब्रह्मांड की सर्वोच्च शक्तियों के साथ जुड़ने लगती है।
            छठी मात्रा (ऐन्द्री) तक आते-आते साधक अपनी सभी इंद्रियों पर पूरी तरह से विजय (Control) प्राप्त कर लेता है।
            सातवीं मात्रा (वैष्णवी) में साधक को अपने भीतर एक विशालता और सर्वव्यापकता (Vishnu) का अहसास होता है।
            आठवीं मात्रा (शांकरी) में पहुँचकर मन पूरी तरह से शांत, शीतल और कल्याणमय (Shiva) हो जाता है।
            यह कोई बाहरी देवी-देवताओं की पूजा नहीं है; ये हमारे ही भीतर चेतना के अलग-अलग 'पॉवर लेवल' (Power levels) हैं।
            ध्यान में गहराई का अर्थ है अपनी चेतना को जीव के स्तर से उठाकर शिव के स्तर तक ले जाना।
        """.trimIndent(),
        english = """
            The fifth subtle Matra of Omkara is named 'Namadheya' (that which is associated with names and forms).
            Its sixth Matra is profoundly declared by the wise scholars to be 'Aindri' (related to Indra/conquering the senses).
            The seventh highly sacred Matra of this sound is named 'Vaishnavi' (the all-pervading power of Lord Vishnu).
            And its eighth subtle Matra is deeply known as 'Shankari' (the absolute auspicious power of Lord Shiva).
            As the internal sound becomes progressively quieter, consciousness begins to unite with the cosmos's supreme powers.
            By reaching the sixth Matra (Aindri), the seeker successfully achieves total and absolute victory over all his senses.
            In the seventh Matra (Vaishnavi), the seeker intensely feels a profound vastness and omnipresence (Vishnu) within himself.
            Upon reaching the eighth Matra (Shankari), the mind becomes exceptionally tranquil, cool, and fully auspicious (Shiva).
            This is not the worship of external deities; these are exactly the different 'Power Levels' of consciousness right inside us.
            Depth in meditation strictly means elevating one's consciousness from the level of a mere creature up to the level of Shiva.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 8,
        sanskrit = "नवमी महती नाम धृतिर्नाम दशमी । एकादशी तु नारी स्याद् ब्राह्मी द्वादशमी तथा ॥ ८ ॥",
        hindi = """
            इस नाद की नौवीं मात्रा का नाम 'महती' (अत्यंत महान और विशाल) है।
            इसकी दसवीं मात्रा को 'धृति' (परम धैर्य और स्थिरता) के नाम से जाना जाता है।
            ग्यारहवीं अत्यंत सूक्ष्म मात्रा का नाम 'नारी' (सृजन की मूल शक्ति) कहा गया है।
            और इसकी सबसे अंतिम, बारहवीं मात्रा का नाम 'ब्राह्मी' (साक्षात् ब्रह्म स्वरूप) है।
            दसवीं मात्रा (धृति) तक पहुँचने पर साधक का मन पहाड़ की तरह अचल (Stable) हो जाता है; उसे कोई विचार हिला नहीं सकता।
            ग्यारहवीं मात्रा (नारी) वह आदि-शक्ति है जहाँ से यह पूरा ब्रह्मांड पैदा हुआ है (Cosmic Mother)।
            और बारहवीं मात्रा (ब्राह्मी) वह अंतिम बिंदु है जहाँ गूँज (Vibration) पूरी तरह से शून्य (Silence) में बदल जाती है।
            ब्राह्मी मात्रा में पहुँचने का मतलब है—अहंकार का 100% मिट जाना और साक्षात् ब्रह्म बन जाना।
            इसके बाद कोई तेरहवीं मात्रा नहीं है, क्योंकि इसके बाद 'मैं' बचता ही नहीं जो कुछ अनुभव कर सके।
            यह 12 सीढ़ियों का एक नक्शा है जो इंसान को शोर-शराबे से निकालकर पूर्ण मौन (निर्वाण) में ले जाता है।
        """.trimIndent(),
        english = """
            The ninth exceedingly subtle Matra of this Nada is named 'Mahati' (the supremely great and vast one).
            Its tenth Matra is deeply known by the name 'Dhriti' (representing absolute supreme patience and steadiness).
            The eleventh incredibly subtle Matra is called 'Nari' (representing the primordial power of cosmic creation).
            And its absolute final, twelfth Matra is named 'Brahmi' (representing the direct embodiment of Brahman Itself).
            Upon reaching the tenth Matra (Dhriti), the seeker's mind becomes as unshakeable as a mountain; no thought can move it.
            The eleventh Matra (Nari) is that primordial energy (Cosmic Mother) from which this entire universe was originally born.
            And the twelfth Matra (Brahmi) is that ultimate final point where the vibration transforms completely into zero Silence.
            Reaching the Brahmi Matra strictly means the 100% annihilation of the ego and directly becoming Brahman.
            There is absolutely no thirteenth Matra after this, because the 'I' simply does not survive to experience anything further.
            This is a precise 12-step map that safely guides a human from chaotic noise entirely into absolute Silence (Nirvana).
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 9,
        sanskrit = "प्रथमायां प्राणोत्क्रान्तौ भारते वर्ष उत्तमे । चक्रवर्ती भवेद्राजा सार्वभौमः प्रतापवान् ॥ ९ ॥",
        hindi = """
            (अब ध्यान करते हुए प्राण त्यागने का फल बताया जा रहा है): यदि कोई साधक ॐ की 'पहली मात्रा' (घोषिणी) का ध्यान करते हुए अपने प्राण त्यागता है।
            तो वह अगले जन्म में इस श्रेष्ठ भारतवर्ष (कर्मभूमि) में जन्म लेता है।
            और वह एक महान चक्रवर्ती, संपूर्ण पृथ्वी का स्वामी (सार्वभौम) और अत्यंत प्रतापी राजा बनता है।
            यह श्लोक कर्म और ध्यान के विज्ञान को बहुत गहराई से समझाता है।
            पहली मात्रा सबसे स्थूल (Gross) है; यदि मन यहीं अटका रहा, तो इसका मतलब है कि साधक के अंदर अभी दुनिया पर राज करने की इच्छा (Ego) बाकी है।
            प्रकृति कोई सजा नहीं देती; वह केवल हमारी अधूरी इच्छाओं को पूरा करने का साधन देती है।
            चूंकि उसने ॐ का ध्यान किया था, इसलिए उसे कोई साधारण जीवन नहीं, बल्कि एक राजा का जीवन मिलता है।
            परंतु उपनिषद इशारा कर रहा है कि राजा बनना भी एक 'बंधन' (Bondage) ही है, मोक्ष नहीं।
            जब तक वासना पूरी तरह भस्म नहीं होती, तब तक इंसान को वापस इसी धरती पर लौटना ही पड़ता है।
            यह साधकों के लिए चेतावनी है कि साधना के बीच में मिलने वाली सिद्धियों और ताकतों (Powers) से संतोष नहीं करना चाहिए।
        """.trimIndent(),
        english = """
            (Now explaining the fruits of leaving the body during meditation): If a seeker sheds his vital breath while meditating firmly on the 'First Matra' (Ghoshini) of OM.
            He is inevitably reborn in his next life in this highly excellent land of Bharatavarsha (the land of karma).
            And he becomes a magnificent Chakravartin (emperor), the absolute lord of the entire earth (Sarvabhauma), and a highly glorious King.
            This verse very profoundly explains the intricate science of karma and the exact effects of meditation.
            The first Matra is the grossest; if the mind gets stuck here, it implies the seeker still harbors a secret desire (Ego) to rule the world.
            Nature does not punish; it simply provides the exact physical means to fulfill our unfulfilled, lingering desires.
            Because he meditated on OM, he doesn't get an ordinary life, but is rewarded with the grand life of an Emperor.
            But the Upanishad subtly hints that becoming an Emperor is still fundamentally a 'Bondage', not absolute Moksha.
            As long as lusts are not burnt completely, a human being is helplessly forced to return to this very earth.
            This is a strict warning for seekers absolutely not to settle for the magical powers or siddhis encountered midway through practice.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 10,
        sanskrit = "द्वितीयायामुत्क्रान्तस्तु यक्षो भवति मारिष । विद्याधरो तृतीयायां चतुर्थ्यां गन्धर्व एव च ॥ १० ॥",
        hindi = """
            हे आर्य (मारिष)! यदि साधक ॐ की 'दूसरी मात्रा' (विद्युन्मात्रा) में ध्यान लगाते हुए प्राण छोड़ता है, तो वह महान 'यक्ष' (कुबेर के लोक का वासी) बनता है।
            यदि वह 'तीसरी मात्रा' (पतंगिनी) में ध्यान करते हुए शरीर त्यागता है, तो वह 'विद्याधर' (जादुई शक्तियों वाला देव) बनता है।
            और यदि वह 'चौथी मात्रा' (वायुवेगा) में ध्यान करते हुए प्राण त्यागता है, तो वह स्वर्ग में 'गंधर्व' (स्वर्गीय संगीतकार) का रूप प्राप्त करता है।
            जैसे-जैसे ध्यान गहरा होता है (मात्राएं बढ़ती हैं), साधक का अगला जन्म धरती से उठकर सूक्ष्म लोकों (स्वर्ग) में होने लगता है।
            यक्ष, विद्याधर और गंधर्व—ये सभी देवताओं की अलग-अलग श्रेणियां (Categories) हैं, जिनके पास इंसानों से ज्यादा सुख और शक्तियां होती हैं।
            परंतु ये सब भी माया (Illusion) के ही हिस्से हैं; यहाँ सुख तो बहुत है, पर यहाँ भी 'जन्म और मृत्यु' का कानून लागू होता है।
            जब उनके पुण्यों का बैंक-बैलेंस (Bank balance) खत्म हो जाता है, तो गंधर्वों को भी वापस धरती पर गिरना पड़ता है (क्षीण पुण्ये मर्त्यलोकं विशन्ति)।
            इसलिए यमराज या गुरु शिष्य को बताते हैं कि इन देव-लोकों के लालच में मत फँसना।
            ध्यान का उद्देश्य कोई जादुई शक्ति (विद्याधर) पाना या स्वर्ग में संगीत (गंधर्व) सुनना नहीं है।
            ध्यान का एकमात्र उद्देश्य उस सत्य को पाना है जो इन सभी लोकों से परे और हमेशा रहने वाला है।
        """.trimIndent(),
        english = """
            O Noble One (Marisha)! If the seeker sheds his breath while meditating on the 'Second Matra' (Vidyunmatra), he becomes a great 'Yaksha' (dweller of Kubera's realm).
            If he leaves his physical body while profoundly meditating on the 'Third Matra' (Patangini), he becomes a 'Vidyadhara' (a celestial possessing magical powers).
            And if he sheds his vital breath while meditating intensely on the 'Fourth Matra' (Vayuvega), he successfully attains the form of a 'Gandharva' (celestial musician) in heaven.
            As meditation systematically deepens (Matras increase), the seeker's next birth is elevated from the physical earth to the subtle heavenly realms.
            Yakshas, Vidyadharas, and Gandharvas—these are all specific categories of celestials who possess vastly more joy and powers than ordinary humans.
            However, all of these are still fundamentally parts of Maya (Illusion); there is immense pleasure here, but the law of 'Birth and Death' still perfectly applies.
            When their bank balance of merits is fully exhausted, even the great Gandharvas are forced to fall back down to earth.
            Therefore, the Guru strictly instructs the disciple absolutely not to get trapped by the extreme greed for these celestial realms.
            The goal of meditation is not to acquire cheap magical powers (Vidyadhara) or listen to heavenly music (Gandharva).
            The sole, absolute goal of meditation is to attain that Truth which exists completely beyond all these realms and lasts forever.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 11,
        sanskrit = "पञ्चम्यामुत्क्रान्तस्तु भवति देवतुण्डितः । षष्ठ्यामिन्द्रसलोकः स्यात्सप्तम्यां वैष्णवं पदम् ॥ ११ ॥",
        hindi = """
            यदि साधक 'पांचवीं मात्रा' (नामधेया) में ध्यान करते हुए प्राण त्यागता है, तो वह 'सोमलोक' (चंद्रमा के देवताओं के लोक) में जन्म लेकर पूजनीय (देवतुण्डित) होता है।
            यदि वह 'छठी मात्रा' (ऐन्द्री) में ध्यान करते हुए शरीर छोड़ता है, तो वह देवराज इंद्र के लोक (इन्द्रसलोक) को प्राप्त करता है।
            और यदि वह 'सातवीं मात्रा' (वैष्णवी) में पूर्ण एकाग्रता के साथ प्राण त्यागता है, तो वह साक्षात् भगवान 'विष्णु के परम पद' (वैकुंठ) को प्राप्त कर लेता है।
            पाँचवीं मात्रा से स्वर्ग के सबसे ऊँचे और सुखदायी लोकों की प्राप्ति शुरू हो जाती है।
            छठी मात्रा का नाम ही 'ऐन्द्री' था, इसलिए इस पर ध्यान करने से सीधे इंद्र (देवताओं के राजा) की कुर्सी के बराबर का सुख मिलता है।
            सातवीं मात्रा से साधक देवताओं की सीमा को भी पार कर जाता है और सीधे त्रिमूर्ति (विष्णु) के लोक में प्रवेश करता है।
            वैकुंठ (वैष्णव पद) वह स्थान है जहाँ जाने के बाद जीव को सांसारिक दुखों का सामना नहीं करना पड़ता।
            यह एक अत्यंत उच्च आध्यात्मिक अवस्था है, जहाँ साधक का हृदय पूरी तरह से पवित्र और विष्णु के समान सर्वव्यापी हो जाता है।
            यहाँ तक पहुँचने के लिए मन का लगभग 90% अज्ञान और स्वार्थ जलकर राख हो चुका होता है।
            परंतु अद्वैत वेदान्त कहता है कि जब तक 'मैं' और 'विष्णु' दो अलग हैं, तब तक यात्रा पूरी नहीं हुई।
        """.trimIndent(),
        english = """
            If the seeker sheds his breath meditating on the 'Fifth Matra' (Namadheya), he takes birth in the 'Somaloka' (realm of moon gods) and becomes highly revered (Devatundita).
            If he leaves his physical body while meditating flawlessly on the 'Sixth Matra' (Aindri), he directly attains the supreme realm of Indra, the King of gods (Indrasaloka).
            And if he sheds his breath with absolute concentration on the 'Seventh Matra' (Vaishnavi), he successfully attains the 'Supreme Abode of Lord Vishnu' (Vaikuntha).
            From the fifth Matra onwards, the attainment of the absolute highest and most pleasurable realms of heaven officially begins.
            The sixth Matra itself was named 'Aindri', hence meditating on it grants happiness exactly equal to the royal throne of Indra (King of Gods).
            By the seventh Matra, the seeker completely crosses even the boundaries of the gods and enters straight into the realm of the Trinity (Vishnu).
            Vaikuntha (the Vaishnava abode) is that magnificent place entering which the soul never has to face worldly sorrows again.
            This is an exceedingly high spiritual state, where the seeker's heart becomes totally pure and omnipresent exactly like Lord Vishnu.
            To successfully reach this level, nearly 90% of the mind's ignorance and petty selfishness has already been burnt to ashes.
            However, Advaita Vedanta declares that as long as 'I' and 'Vishnu' remain two separate entities, the ultimate journey is not yet complete.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 12,
        sanskrit = "अष्टम्यां पारशुपतमेति रुद्रसलोकताम् । नवम्यां महर्लोकं तु दशम्यां जनलौकिकम् ॥ १२ ॥",
        hindi = """
            यदि साधक 'आठवीं मात्रा' (शांकरी) में ध्यान करते हुए प्राण छोड़ता है, तो वह पशुपतिनाथ (भगवान शिव) के लोक 'रुद्रलोक' को प्राप्त करता है।
            यदि वह 'नौवीं मात्रा' (महती) में ध्यान करते हुए शरीर त्यागता है, तो वह महान संतों के लोक 'महर्लोक' में जाता है।
            और यदि वह 'दसवीं मात्रा' (धृति) में ध्यान करते हुए मृत्यु को प्राप्त होता है, तो वह देवताओं के उच्च लोक 'जनलोक' को प्राप्त करता है।
            आठवीं मात्रा साक्षात् शिव (महादेव) की स्थिति है; जो इस अवस्था में मरता है, वह जन्म-मरण के भय (पशुता) से मुक्त होकर 'पशुपति' में समा जाता है।
            नौवीं और दसवीं मात्राएं ब्रह्मांड के उन सबसे ऊँचे लोकों (महर्लोक और जनलोक) की ओर ले जाती हैं जहाँ केवल महान ऋषि और सिद्ध आत्माएं ही रहती हैं।
            इन लोकों में किसी भी प्रकार का भौतिक सुख या भोग नहीं है; यहाँ केवल शुद्ध ज्ञान और तपस्या का आनंद है।
            इन मात्राओं तक पहुँचने वाले योगी के मन में संसार का रत्ती भर भी आकर्षण शेष नहीं बचता।
            उसका मन अब एक अत्यंत सूक्ष्म और दिव्य 'कॉस्मिक' (Cosmic) फ्रीक्वेंसी पर वाइब्रेट (Vibrate) कर रहा होता है।
            मौत के समय हमारा मन जिस अवस्था में होता है, हमारी चेतना उसी 'लोक' को चुंबक (Magnet) की तरह खींच लेती है।
            इसलिए जीवन भर ध्यान का अभ्यास किया जाता है, ताकि अंत समय में मन किसी तुच्छ इच्छा में न फँसे।
        """.trimIndent(),
        english = """
            If the seeker sheds his breath while meditating on the 'Eighth Matra' (Shankari), he successfully attains 'Rudraloka', the supreme realm of Lord Pashupati (Shiva).
            If he leaves his physical body meditating on the 'Ninth Matra' (Mahati), he directly goes to 'Maharloka', the exceptionally high realm of great saints.
            And if he achieves death while profoundly meditating on the 'Tenth Matra' (Dhriti), he successfully attains 'Janaloka', the higher realm of cosmic deities.
            The eighth Matra is the direct state of Shiva (Mahadeva); he who dies in this state is freed from the fear of rebirth (animality) and merges into 'Pashupati'.
            The ninth and tenth Matras lead directly to those absolute highest realms of the cosmos (Maharloka and Janaloka) where only great sages and perfected souls reside.
            In these elevated realms, there is absolutely zero physical pleasure or indulgence; there is exclusively the profound joy of pure wisdom and severe penance.
            The mind of a Yogi reaching these advanced Matras harbors not even a single ounce of worldly attraction anymore.
            His mind is now actively vibrating at an exceedingly subtle, divine, and purely 'Cosmic' frequency.
            Whatever exact state our mind is deeply in at the time of death, our consciousness draws that specific 'realm' toward itself exactly like a magnet.
            Therefore, meditation is rigorously practiced life-long, purely so that at the final moment, the mind doesn't get trapped in any petty, trivial desire.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 13,
        sanskrit = "एकादश्यां तपोलोकं द्वादश्यां शाश्वतं पदम् । ततो विशुद्धमात्मानं चिन्तयेद्विजितेन्द्रियः ॥ १३ ॥",
        hindi = """
            यदि साधक 'ग्यारहवीं मात्रा' (नारी) में ध्यान करते हुए प्राण त्यागता है, तो वह महान 'तपोलोक' को प्राप्त करता है।
            और अंततः, यदि वह 'बारहवीं मात्रा' (ब्राह्मी) में पूर्ण रूप से लीन होकर प्राण छोड़ता है, तो वह उस 'शाश्वत परम पद' (मोक्ष/ब्रह्म) को प्राप्त कर लेता है, जहाँ से कभी लौटना नहीं पड़ता।
            इसलिए, अपनी सभी इंद्रियों को पूरी तरह जीत लेने वाले (विजितेन्द्रिय) साधक को उस अत्यंत विशुद्ध और परम आत्मा का निरंतर चिंतन करना चाहिए।
            ग्यारहवीं मात्रा तक भी लोकों (Worlds) की बात हो रही थी, पर बारहवीं मात्रा आते ही सारे लोक खत्म हो जाते हैं।
            'शाश्वत पद' का मतलब है वह सत्य जो कभी बदलता नहीं, जो स्वर्ग और नर्क दोनों के परे है।
            बारहवीं मात्रा (मौन/शून्यता) में मरने वाला व्यक्ति फिर कभी किसी भी योनि (Womb) में जन्म नहीं लेता; वह साक्षात् भगवान हो जाता है।
            उपनिषद यहाँ एक बहुत बड़ा निष्कर्ष (Conclusion) दे रहा है: चंचल इंद्रियों के साथ कभी भी मोक्ष नहीं मिल सकता।
            केवल 'विजितेन्द्रिय' (जिसने अपनी वासनाओं पर 100% कंट्रोल कर लिया है) वही इस बारहवीं मात्रा के सन्नाटे को झेल सकता है।
            अहंकारी आदमी मौन से डरता है, पर एक सच्चा योगी उसी मौन में अपने 'विशुद्ध आत्मा' को खोजता है।
            इस प्रकार ॐकार की 12 मात्राओं का यह ब्रह्मांडीय विज्ञान (Cosmic Science) यहाँ पूरा होता है।
        """.trimIndent(),
        english = """
            If the seeker sheds his breath meditating on the 'Eleventh Matra' (Nari), he successfully attains the magnificent 'Tapoloka'.
            And finally, if he leaves his breath completely absorbed in the 'Twelfth Matra' (Brahmi), he attains that 'Eternal Supreme Abode' (Moksha/Brahman) from which there is absolutely no return.
            Therefore, the seeker who has completely conquered all his senses (Vijitendriya) must continuously contemplate upon that exceedingly pure, Supreme Soul.
            Up to the eleventh Matra, there was still talk of specific realms (Worlds), but the exact moment the twelfth Matra arrives, all worlds vanish completely.
            The 'Eternal Abode' specifically means that absolute Truth which never changes, which exists entirely beyond both heaven and hell.
            The person dying in the twelfth Matra (Silence/Void) is never, ever reborn in any womb again; he literally becomes God Himself.
            The Upanishad provides a massive conclusion here: Moksha can absolutely never be attained with restless, uncontrolled senses.
            Only a 'Vijitendriya' (one who has 100% control over his lusts) can possibly withstand the profound silence of this twelfth Matra.
            An arrogant, egoistic man is terrified of silence, but a true Yogi intensely searches for his 'Pure Soul' strictly within that very silence.
            Thus, this profound cosmic science (Cosmic Science) of the 12 Matras of Omkara is beautifully completed right here.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 14,
        sanskrit = "प्रणवेन निरुद्धेन निरुच्छ्वासो जितासनः । आदावन्ते च मध्ये च नादं ब्रह्मानुचिन्तयेत् ॥ १४ ॥",
        hindi = """
            (अब ध्यान की प्रैक्टिकल विधि बताई जा रही है): साधक को किसी स्थिर आसन को जीत लेना चाहिए (जितासनः / अर्थात् बिना हिले-डुले बैठने का अभ्यास करना चाहिए)।
            फिर ॐकार (प्रणव) के द्वारा अपने मन और श्वास को पूरी तरह रोककर (निरुच्छ्वास) स्थिर कर देना चाहिए।
            उस अवस्था में साधक को शुरुआत में, बीच में, और अंत में (यानी हर समय) उस भीतर गूँजने वाले 'नाद' (ध्वनि) को ही साक्षात् ब्रह्म मानकर उसका चिंतन करना चाहिए।
            नाद योग (Sound Meditation) के लिए सबसे पहली शर्त है शरीर का पत्थर की तरह अचल होना (जितासन)।
            जब शरीर हिलता है, तो मन हिलता है; और जब मन हिलता है, तो भीतर का सूक्ष्म नाद (ध्वनि) सुनाई नहीं देता।
            श्वास को धीमा और स्थिर (निरुच्छ्वास) करना जरूरी है, क्योंकि गहरी सांसों के शोर में अंदर की सूक्ष्म आवाज़ दब जाती है।
            साधक को ॐ (प्रणव) का मानसिक जप तब तक करना चाहिए जब तक कि मन पूरी तरह से लॉक (Lock) न हो जाए।
            जब मन लॉक हो जाता है, तब अंदर एक प्राकृतिक 'नाद' (गूँज) पैदा होती है; साधक को उसी आवाज़ पर 100% फोकस करना है।
            उसे यह नहीं सोचना है कि यह आवाज़ केवल एक आवाज़ है; उसे उस आवाज़ को ही 'ईश्वर' (ब्रह्म) मानना है।
            चाहे ध्यान की शुरुआत हो, गहराई हो या अंत हो—मन को उस नाद से एक सेकंड के लिए भी हटने नहीं देना है।
        """.trimIndent(),
        english = """
            (Now the highly practical method of meditation is given): The seeker must thoroughly conquer a steady posture (Jitasana / perfectly practicing sitting without making any movement).
            Then, firmly using the Omkara (Pranava), he must completely restrain and still his chaotic mind and breath (Nirucchvasa).
            In that perfectly still state, in the absolute beginning, the middle, and the end (meaning, at all times), the seeker must continuously contemplate that resonating internal 'Nada' (sound) strictly as Brahman Himself.
            The absolute first condition for Nada Yoga (Sound Meditation) is for the physical body to become as unmoving as a rock (Jitasana).
            When the body shakes, the mind shakes; and when the mind shakes, the exceedingly subtle inner Nada (sound) simply cannot be heard.
            Slowing down and perfectly stilling the breath (Nirucchvasa) is mandatory, because the loud noise of heavy breathing easily drowns out the subtle inner voice.
            The seeker must perform continuous mental chanting of OM until his restless mind is completely locked and paralyzed.
            When the mind is fully locked, a natural, uncreated 'Nada' (echo) arises inside; the seeker must place his 100% focus purely on that sound.
            He absolutely must not think of it as merely a sound; he must profoundly consider that very sound to be 'God' (Brahman).
            Whether at the very beginning, the deep middle, or the final end of meditation—he must not let the mind slip away from that Nada for even a single second.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 15,
        sanskrit = "नादश्रवणयोगेन निष्पापो जायते नरः । सिद्धासने स्थितो योगी मुद्रां सन्धाय वैष्णवीम् ॥ १५ ॥",
        hindi = """
            इस 'नाद' (आंतरिक ध्वनि) को निरंतर सुनने के योग (नाद-श्रवण-योग) के अभ्यास से मनुष्य पूरी तरह से 'निष्पाप' (सभी पापों से मुक्त) हो जाता है।
            योगी को 'सिद्धासन' (एक अत्यंत पवित्र और ऊर्जावान योग मुद्रा) में दृढ़ता से बैठना चाहिए।
            और फिर उसे अपनी आँखों से 'वैष्णवी मुद्रा' (आँखें खुली होने पर भी बाहर कुछ न देखना, ध्यान भीतर रखना) धारण करनी चाहिए।
            पाप केवल वे बुरे कर्म नहीं हैं जो हम करते हैं; पाप हमारे मन का वह भटकाव (Distraction) है जो हमें सत्य से दूर रखता है।
            जब मन नाद (Sound) में पूरी तरह डूब जाता है, तो कोई विचार पैदा ही नहीं होता; और जहाँ विचार नहीं, वहाँ कोई पाप कैसे टिक सकता है?
            सिद्धासन को योग में सबसे श्रेष्ठ माना गया है क्योंकि यह ऊर्जा (Kundalini) को सीधे ऊपर की ओर धकेलता है।
            वैष्णवी मुद्रा बहुत ही रहस्यमयी है: इसमें योगी की आँखें आधी या पूरी खुली रहती हैं, पर उसकी 'दृष्टि' बाहर नहीं, बल्कि भीतर होती है।
            वह दुनिया को देखते हुए भी दुनिया को नहीं देख रहा होता; उसका पूरा का पूरा फोकस कानों के भीतर गूँजने वाले नाद पर होता है।
            यह मुद्रा साधक को नींद (तन्द्रा) में जाने से बचाती है और उसे 100% अलर्ट (Alert) रखती है।
            यह श्लोक नाद योग का सबसे पक्का और आजमाया हुआ वैज्ञानिक 'फॉर्मूला' (Formula) दे रहा है।
        """.trimIndent(),
        english = """
            By the continuous, dedicated practice of listening to this 'Nada' (Nada-Shravana-Yoga), a human being becomes completely 'Nishpapa' (entirely freed from all sins).
            The Yogi must sit firmly and steadily in the 'Siddhasana' (an exceptionally sacred and highly energetic yogic posture).
            And then he must successfully adopt the 'Vaishnavi Mudra' with his eyes (keeping the eyes open but seeing absolutely nothing outside, keeping the entire focus strictly within).
            Sins are not merely the bad actions we commit; sin is essentially the deep distraction of our mind that keeps us far away from the Truth.
            When the mind completely drowns in the Nada (Sound), absolutely no thought is born; and where there is no thought, how can any sin possibly survive?
            Siddhasana is universally considered the absolute best in Yoga because it directly and forcefully pushes the energy (Kundalini) upwards.
            The Vaishnavi Mudra is highly mystical: here, the Yogi's eyes remain half or fully open, but his 'Vision' is absolutely not outside, but entirely inward.
            Even while looking at the world, he is not seeing the world at all; his 100% focus is strictly locked on the Nada echoing deep inside his ears.
            This powerful Mudra actively prevents the seeker from falling into dull sleep (lethargy) and keeps him 100% exceptionally alert.
            This magnificent verse provides the most foolproof, rigorously tested scientific 'Formula' for mastering Nada Yoga.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 16,
        sanskrit = "शृणुयाद्दक्षिणे कर्णे नादमन्तर्गतं सदा । अभ्यस्यमानो नादोऽयं बाह्यमावृणुते ध्वनिम् ॥ १६ ॥",
        hindi = """
            वैष्णवी मुद्रा में बैठकर योगी को हमेशा अपने दाहिने कान (Right ear) में गूँजने वाले उस 'अंतर्गत नाद' (भीतरी ध्वनि) को बहुत ध्यान से सुनना चाहिए।
            जब इस नाद को सुनने का निरंतर अभ्यास (Practice) गहरा होने लगता है, तो यह नाद एक ढाल (Shield) बन जाता है।
            और यह आंतरिक नाद बाहर की सभी प्रकार की ध्वनियों (बाह्य ध्वनि) और शोरगुल को पूरी तरह से ढँक (आवृणुते) देता है।
            नाद योग में विशेष रूप से 'दाहिने कान' पर फोकस करने को कहा जाता है, क्योंकि यह सूर्य नाड़ी (पिंगला) और तार्किक मस्तिष्क (Logical brain) को शांत करता है।
            शुरुआत में साधक को बहुत ध्यान लगाना पड़ता है कि वह अंदर की आवाज़ पकड़े।
            पर जब अभ्यास पक्का हो जाता है, तो वह अंदर की गूँज इतनी तेज (Loud) और मीठी हो जाती है कि बाहर का शोर (ट्रैफिक, लोगों की आवाज़) सुनाई ही नहीं देता।
            यह कोई बहरापन (Deafness) नहीं है; यह 'प्रत्याहार' (Withdrawal of senses) की चरम सीमा है।
            जैसे हेडफोन (Headphones) लगाने पर बाहर का शोर कट जाता है, वैसे ही नाद हमारे मन को दुनिया से पूरी तरह कट-ऑफ (Cut-off) कर देता है।
            जब बाहरी दुनिया की आवाज़ें मन तक नहीं पहुँचतीं, तभी मन को असली और गहरा विश्राम (Rest) मिलता है।
            यही वह तरीका है जिससे एक योगी बाज़ार के शोर के बीच बैठकर भी हिमालय जैसी शांति का आनंद ले सकता है।
        """.trimIndent(),
        english = """
            Sitting firmly in the Vaishnavi Mudra, the Yogi must always and very attentively listen to that 'Internal Nada' (inner sound) echoing strictly in his Right Ear.
            When the continuous, dedicated practice of listening to this Nada becomes profoundly deep, this Nada transforms into an impenetrable shield.
            And this powerful internal Nada completely covers, blocks, and drowns out (Avrinute) all external sounds and worldly noise.
            In Nada Yoga, seekers are specifically instructed to focus purely on the 'Right Ear', as it actively calms the Surya Nadi (Pingala) and the highly logical brain.
            In the very beginning, the seeker has to apply extreme concentration just to successfully catch that faint internal voice.
            But when the practice becomes perfectly solidified, that inner echo becomes so incredibly loud and sweet that external noise (traffic, people talking) simply cannot be heard.
            This is absolutely not physical deafness; it is the absolute peak, the ultimate limit of 'Pratyahara' (complete withdrawal of the senses).
            Just as wearing noise-canceling headphones cuts off external noise, the Nada completely and flawlessly 'Cuts-off' our mind from the external world.
            Only when the loud noises of the external world fail to reach the mind does the mind finally receive true, infinitely deep rest.
            This is the exact method by which a master Yogi can sit right in the middle of a noisy market and flawlessly enjoy the profound peace of the Himalayas.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 17,
        sanskrit = "पक्षाद्विक्षेपमखिलं जित्वा तुर्यं पदं व्रजेत् । श्रूयते प्रथमाभ्यासे नादो नानाविधो महान् ॥ १७ ॥",
        hindi = """
            इस नाद के निरंतर अभ्यास से साधक केवल पंद्रह दिन (एक पक्ष / Fortnight) में ही मन के सभी विक्षेपों (Distractions/भटकाव) को पूरी तरह जीत लेता है।
            और मन के भटकने को जीतकर वह सीधे 'तुरीय पद' (आत्म-साक्षात्कार की चौथी अवस्था) को प्राप्त कर लेता है।
            जब साधक पहली बार (प्रथमाभ्यासे) इस नाद को सुनने का अभ्यास शुरू करता है, तो उसे कई अलग-अलग प्रकार की (नानाविधो) बहुत ऊँची और स्थूल ध्वनियां सुनाई देती हैं।
            नाद योग की शक्ति (Power) का अंदाजा इसी बात से लगाया जा सकता है कि उपनिषद '15 दिन' की गारंटी दे रहा है!
            दुनिया का कोई और ध्यान इतनी जल्दी मन के हजारों विक्षेपों (लाखों विचारों के तूफानों) को शांत नहीं कर सकता।
            ध्वनि (Sound) मन को बाँधने के लिए दुनिया की सबसे मजबूत रस्सी है।
            तुरीय पद वह है जहाँ इंसान जागने, सोने और सपने देखने की सीमाओं को पार करके साक्षात् ईश्वर बन जाता है।
            जब हम शुरुआत में कान बंद करते हैं, तो अंदर बहुत शोर (खून का बहना, दिल की धड़कन) होता है।
            यह कोई गलती नहीं है; यह एक स्वाभाविक (Natural) शुरुआत है।
            जैसे समुद्र के किनारे खड़ा आदमी पहले केवल लहरों का भारी शोर सुनता है, वैसे ही साधक को शुरुआत में भारी और स्थूल ध्वनियां ही सुनाई देती हैं।
        """.trimIndent(),
        english = """
            By the continuous, unbroken practice of this Nada, the seeker completely conquers all mental distractions (Vikshepa) in just a fortnight (15 days / Paksha).
            And having flawlessly conquered the mind's endless wandering, he directly and successfully attains the 'Turiya State' (the fourth state of absolute Self-realization).
            When the seeker begins the absolute first practice (Prathamabhyase) of listening to this Nada, he clearly hears many different, highly varied (Nanavidha), extremely loud, and gross sounds.
            The sheer, unimaginable Power of Nada Yoga can be accurately estimated by the fact that the Upanishad is giving a solid '15-day' guarantee!
            Absolutely no other meditation in the world can so quickly silence the thousands of powerful mental distractions (storms of millions of chaotic thoughts).
            Sound (Nada) is undeniably the strongest, most unbreakable rope in the world for firmly tying down a highly restless mind.
            The Turiya state is where a human permanently crosses the limits of waking, sleeping, and dreaming to literally become God Himself.
            When we first close our ears initially, there is massive internal noise (the loud rushing of blood, heavy heartbeat).
            This is absolutely not a mistake; it is a perfectly natural, expected beginning of the practice.
            Just as a man standing strictly on the seashore initially hears only the loud, crashing roar of the heavy waves, the seeker initially hears only very heavy and gross sounds.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 18,
        sanskrit = "ततो वर्धमानेऽभ्यासे श्रूयते सूक्ष्मसूक्ष्मकः । आदौ जलधिजीमूतभेरीझर्झरसंभवः ॥ १८ ॥",
        hindi = """
            फिर जैसे-जैसे नाद सुनने का वह अभ्यास बढ़ता है (वर्धमाने), और साधक गहराई में उतरता है।
            वैसे-वैसे वे आवाज़ें बदल जाती हैं और उसे अत्यंत सूक्ष्म से भी सूक्ष्म (सूक्ष्मसूक्ष्मकः) ध्वनियां सुनाई देने लगती हैं।
            अभ्यास के बिल्कुल आरंभ (आदौ) में उसे समुद्र (जलधि) की भारी गर्जना, या घने बादलों (जीमूत) की गड़गड़ाहट जैसी आवाज़ आती है।
            या फिर किसी बहुत बड़ी 'भेरी' (नगाड़ा) और 'झर्झर' (झरने या भारी झांझ) के बजने जैसी अत्यंत भारी और स्थूल ध्वनियां सुनाई पड़ती हैं।
            यह श्लोक नाद योग के विकास (Evolution) का एक बहुत ही स्पष्ट और प्रैक्टिकल (Practical) चार्ट दे रहा है।
            ध्यान का मतलब केवल आँख बंद करके बैठना नहीं है; यह स्थूल (Gross) से सूक्ष्म (Subtle) की ओर जाने की एक साफ यात्रा है।
            शुरुआत में हमारा मन बहुत चंचल होता है, इसलिए उसे पकड़ने के लिए अंदर की आवाज़ें भी बहुत तेज और भारी (समुद्र जैसी) होती हैं।
            अगर आवाज़ भारी न हो, तो चंचल मन उसे सुन ही नहीं पाएगा और वापस दुनिया की बातों में भाग जाएगा।
            समुद्र की गर्जना और बादलों की गड़गड़ाहट साधक के अंदर के सारे सांसारिक विचारों (Worldly thoughts) को एक ही झटके में धो डालती हैं।
            जब मन का भारी कचरा साफ हो जाता है, तब वह उन बारीक (सूक्ष्म) ध्वनियों को सुनने के लायक (Qualified) बनता है।
        """.trimIndent(),
        english = """
            Then, exactly as that practice of listening to the Nada systematically increases (Vardhamane) and the seeker descends deeper.
            Those sounds drastically change, and he clearly begins to hear sounds that are infinitely subtler than the subtlest (Sukshmasukshmakah).
            In the absolute, very beginning (Adau) of the practice, he distinctly hears sounds exactly like the heavy, roaring ocean (Jaladhi) or the deep thundering of dark clouds (Jimuta).
            Or he clearly hears exceedingly heavy, loud, and gross sounds exactly like the beating of a massive 'Kettle-drum' (Bheri) and crashing 'Cymbals' or waterfalls (Jharjhara).
            This magnificent verse provides a highly clear, exceptionally practical chart of the exact Evolution of Nada Yoga.
            Meditation does not merely mean sitting with closed eyes; it is a clear, highly precise journey from the Gross entirely to the Subtle.
            In the beginning, our mind is intensely restless, so to successfully catch it, the inner sounds are also exceedingly loud and heavy (like the roaring ocean).
            If the sound wasn't extremely heavy, the restless mind simply wouldn't be able to hear it at all and would instantly run right back to worldly thoughts.
            The roaring of the ocean and the thundering of clouds flawlessly wash away all the worldly thoughts inside the seeker in a single, massive stroke.
            Only when the heavy garbage of the mind is completely cleaned out does it become truly Qualified to hear those highly refined (subtle) sounds.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 19,
        sanskrit = "मध्ये मर्द्दलशङ्खोत्थघण्टाकाहलजस्तथा । अन्ते तु किङ्किणीवंशवीणाभ्रमरनिःस्वनः ॥ १९ ॥",
        hindi = """
            फिर अभ्यास के मध्य भाग (बीच की अवस्था) में साधक को 'मर्दल' (पखावज/ढोलक) के बजने जैसी लयबद्ध ध्वनि सुनाई देती है।
            तथा शंख की गूँज, बड़ी घंटी (घंटा) और 'काहल' (तुतही/तुरही - एक प्रकार का बाजा) जैसी सुरीली आवाजें प्रकट होती हैं।
            और फिर अभ्यास के सबसे अंतिम चरण (अन्ते) में, अत्यंत बारीक 'किंकिणी' (छोटी घुंघरुओं) की मीठी आवाज़ सुनाई देती है।
            तथा बांसुरी (वंश), वीणा के तारों की झंकार, और भँवरे (भ्रमर) के गुनगुनाने जैसी अत्यंत सूक्ष्म ध्वनियां सुनाई पड़ती हैं।
            यह ध्यान की यात्रा का क्लाइमेक्स (Climax) है जहाँ स्थूलता पूरी तरह खत्म हो जाती है और केवल 'रस' बचता है।
            मध्य अवस्था में आने पर शंख और घंटी की आवाज़ें मन को पूरी तरह से पवित्र (Purify) कर देती हैं।
            यहाँ तक आते-आते शरीर का भान (Body consciousness) लगभग खत्म हो जाता है।
            अंतिम अवस्था में घुंघरू, बांसुरी और भँवरे की आवाज़ें इतनी बारीक और मीठी होती हैं कि मन खुशी से पागल (Blissful) हो जाता है।
            भँवरे (Bee) की गूँज वह आखिरी स्टेशन है; यह इतनी सूक्ष्म होती है कि मन को इस पर टिकने के लिए खुद को पूरी तरह मिटाना (Zero) पड़ता है।
            जब मन भँवरे की उस गूँज में खो जाता है, तो वह नाद सीधे उस परम शून्यता (ब्रह्म) में जाकर खुलता है।
        """.trimIndent(),
        english = """
            Then, exactly in the middle stage of practice, the seeker clearly hears a highly rhythmic sound exactly like the beating of a 'Mardala' (a drum or Pakhavaj).
            And melodious, resonant sounds perfectly emerge exactly like the echoing of a Conch, a large Bell (Ghanta), and a 'Kahala' (a horn or trumpet).
            And then, entirely in the absolute final, ultimate stage of practice (Ante), the incredibly sweet, highly refined sound of tiny jingling 'Bells' (Kinkini) is heard.
            Along with profoundly subtle sounds exactly like the playing of a Flute (Vamsha), the vibrating strings of a Veena (Lute), and the gentle, continuous humming of a 'Bee' (Bhramara).
            This is the absolute Climax of the meditation journey where all grossness is completely destroyed and only pure 'Juice' (Bliss) remains.
            Upon reaching the middle stage, the deeply resonant sounds of the conch and bell completely and flawlessly Purify the human mind.
            By the time the seeker successfully arrives here, his entire Body consciousness is almost completely annihilated.
            In the final stage, the sounds of tiny bells, flute, and bee are so incredibly refined and sweet that the mind goes completely mad with pure Bliss.
            The humming of the Bee is the absolute last station; it is so profoundly subtle that to anchor on it, the mind has to reduce itself entirely to Zero.
            When the mind gets completely lost in that bee's humming, that Nada opens up straight into that Supreme Void (Brahman).
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 20,
        sanskrit = "इति नानाविधा नादाः श्रूयन्ते देहमध्यगाः । महति श्रूयमाणे तु महाभेरीध्वनौ तथा ॥ २० ॥",
        hindi = """
            इस प्रकार, साधक को अपने ही शरीर के भीतर (देहमध्यगाः) गूँजने वाले ये अनेक प्रकार के (नानाविधा) रहस्यमयी नाद सुनाई देते हैं।
            परंतु उपनिषद एक अत्यंत महत्वपूर्ण चेतावनी देता है: जब साधक को उस महान (महति) 'महाभेरी' (विशाल नगाड़े) या बादलों जैसी भारी ध्वनि सुनाई दे रही हो।
            (अर्थात जब वह स्थूल नाद को सुन रहा हो, तो उसे सूक्ष्म नाद की ओर बढ़ने का ही प्रयास करना चाहिए, और सूक्ष्म को सुनते हुए स्थूल की ओर नहीं लौटना चाहिए)।
            यह श्लोक यह सिद्ध करता है कि भगवान या शांति को खोजने के लिए हमें हिमालय या किसी गुफा में जाने की जरूरत नहीं है।
            पूरा का पूरा 'कॉस्मिक ऑर्केस्ट्रा' (Cosmic Orchestra) हमारे अपने ही शरीर के बिल्कुल बीचोबीच (देहमध्यगाः) बज रहा है।
            बस हमने अपने कान बाहर की फालतू बातों और शोरगुल में लगा रखे हैं, इसलिए हम इस दिव्य संगीत को सुन नहीं पाते।
            यहाँ यह नियम पक्का किया गया है कि साधक को कभी भी वापस पीछे (स्थूल की ओर) नहीं लौटना है।
            जब भँवरे की आवाज़ (सूक्ष्म) सुनाई देने लगे, तो वापस नगाड़े (स्थूल) की आवाज़ की तरफ ध्यान नहीं ले जाना चाहिए।
            ध्यान एक 'वन-वे टिकट' (One-way ticket) है; हमें लगातार अपने मन को और अधिक बारीक और सूक्ष्म करते जाना है।
            जब सबसे सूक्ष्म ध्वनि भी अंत में शांत हो जाती है, तो जो 'सन्नाटा' बचता है, वही साक्षात् परब्रह्म है।
        """.trimIndent(),
        english = """
            Thus, in this precise manner, the sincere seeker clearly hears these manifold, highly mystical Nadas (sounds) echoing entirely within his very own body (Dehamadhyagah).
            However, the Upanishad issues an exceptionally crucial warning: when the seeker is actively hearing that highly 'Gross' and massive sound like the 'Great Kettle-drum' (Mahabheri) or thunder.
            (Meaning, when he is hearing the gross Nada, he must persistently strive to advance purely towards the subtle Nada, and while hearing the subtle, he must absolutely never revert to the gross).
            This magnificent verse flawlessly proves that we absolutely do not need to travel to the Himalayas or any cave to find God or peace.
            The entire 'Cosmic Orchestra' is actively, continuously playing right in the exact center of our very own body (Dehamadhyagah).
            We have simply plugged our ears entirely into useless external gossip and worldly noise, which is exactly why we fail to hear this divine music.
            The strict rule is solidified here that the seeker must absolutely never turn back (toward the gross) under any circumstance.
            When the extremely subtle humming of the bee is heard, one must never pull the attention back to the loud, gross beating of the drum.
            Meditation is strictly a 'One-way ticket'; we must continuously refine and make our mind progressively subtler and finer.
            When even the absolute subtlest sound finally falls completely silent at the end, the 'Silence' that remains is the direct Supreme Brahman.
        """.trimIndent()
    ),
// ... Continuing nadabinduShlokasList from ID 21

    NadabinduShloka(
        id = 21,
        sanskrit = "तत्र सूक्ष्मं सूक्ष्मतरं नादमेव परामृशेत् । घनमुत्सृज्य वा सूक्ष्मे सूक्ष्ममुत्सृज्य वा घने ॥ २१ ॥",
        hindi = """
            उस ध्यान की अवस्था में साधक को सूक्ष्म से भी अत्यंत सूक्ष्म नाद (ध्वनि) पर ही अपना पूरा ध्यान केंद्रित करना चाहिए।
            यदि मन स्थूल (भारी) नाद को छोड़कर स्वतः ही सूक्ष्म नाद में चला जाए, तो उसे उस सूक्ष्म में ही पूरी तरह टिकने देना चाहिए।
            और यदि वह सूक्ष्म को छोड़कर फिर से स्थूल नाद में वापस आ जाए, तो उसे वहीँ से फिर से पकड़ कर ऊपर ले जाना चाहिए।
            यह उपनिषद मन को नियंत्रित करने का एक अत्यंत ही व्यावहारिक और कोमल (Gentle) तरीका सिखाता है।
            मन को जबरदस्ती किसी एक जगह हिंसक रूप से नहीं बाँधना है, क्योंकि बलपूर्वक दबाया गया मन दुगनी ताकत से भड़कता है।
            जैसे कोई बच्चा खेलता है, वैसे ही मन स्थूल (नगाड़े) और सूक्ष्म (भँवरे) ध्वनियों के बीच खेल सकता है, पर उसे नाद से बाहर नहीं जाने देना है।
            जब तक मन नाद (Sound) की परिधि में है, तब तक वह पूरी तरह से सुरक्षित है और बाहरी दुनिया के विकारों से कटा हुआ है।
            स्थूल नाद मन को बाहरी सांसारिक विचारों से छुड़ाता है, और सूक्ष्म नाद मन को सीधे परमात्मा में विलीन कर देता है।
            इसलिए दोनों ही ध्वनियां योगी के लिए एक अत्यंत उपयोगी सीढ़ी की तरह काम करती हैं जो उसे पूर्ण शून्य की ओर ले जाती हैं।
            ध्यान कोई कठोर जेल नहीं है, बल्कि यह चेतना का वह अत्यंत सुंदर नृत्य है जो नाद के साथ-साथ परम सूक्ष्म होता जाता है।
        """.trimIndent(),
        english = """
            In that deep state of meditation, the seeker must anchor his entire focus purely on the subtler and absolutely subtlest Nada (sound).
            If the mind naturally leaves the gross (heavy) sound and successfully enters the subtle, it should be allowed to rest peacefully there.
            And if it slips from the subtle and returns to the gross sound, it must be gently guided back upwards from there.
            This Upanishad teaches an exceptionally practical, highly gentle, and profound method to control the restless human mind.
            One must not forcefully or violently choke the mind, because a suppressed mind always rebels with double the fierce intensity.
            Just as a child plays, the mind may temporarily play between gross and subtle sounds, but it must absolutely never leave the Nada.
            As long as the mind remains strictly within the boundary of the Nada, it is perfectly safe and completely cut off from the external world.
            Gross sounds detach the mind from worldly thoughts, while subtle sounds dissolve it seamlessly and directly into God.
            Therefore, both types of sound effectively serve as a perfect, highly useful ladder leading the Yogi directly toward the absolute void.
            Meditation is absolutely not a harsh prison, but a beautiful, graceful dance of consciousness becoming infinitely subtler with the Nada.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 22,
        sanskrit = "रममाणमपि क्षिप्तं नान्यत्र चालयेन्मनः । सर्वचिन्तां परित्यज्य सर्वचेष्टाविवर्जितः ॥ २२ ॥",
        hindi = """
            यदि यह चंचल मन नाद में रमण करते (आनंद लेते) हुए भी कभी बाहर की ओर विक्षिप्त (भटक) हो जाए, तो उसे दूसरी जगह जाने नहीं देना चाहिए।
            साधक को चाहिए कि वह दुनिया की सभी प्रकार की चिंताओं और विचारों (सर्वचिन्तां) का पूरी तरह से परित्याग कर दे।
            और वह अपने शरीर और मन की सभी शारीरिक और मानसिक चेष्टाओं (कोशिशों/हलचल) से पूरी तरह से रहित (विवर्जित) हो जाए।
            इस अवस्था में केवल और केवल नाद (आंतरिक ध्वनि) का ही निरंतर अनुसंधान (गहरा ध्यान) करना चाहिए।
            मन की यह पुरानी आदत है कि वह सुखद चीज़ों से भी ऊबकर नई चीज़ें ढूँढने बाहर भागता है।
            जब ध्यान में मन को नाद का आनंद आ रहा होता है, तब भी अचानक कोई पुराना विचार उसे बाहर खींच सकता है।
            यहीं पर साधक की असली परीक्षा होती है; उसे तुरंत सतर्क होकर अपने मन को वापस उस नाद पर लाना होता है।
            'सर्वचिन्तां परित्यज्य' का अर्थ है कल क्या होगा और कल क्या हुआ था—इन दोनों बोझों को हमेशा के लिए उतार कर फेंक देना।
            जब शरीर बिल्कुल अचल हो जाता है और मन चिंता-मुक्त हो जाता है, तभी असली 'योग' घटित होता है।
            यह पूर्ण समर्पण की अवस्था है जहाँ साधक अपने अहंकार को छोड़कर पूरी तरह से नाद (ईश्वर) के हवाले हो जाता है।
        """.trimIndent(),
        english = """
            Even while blissfully enjoying the Nada, if this highly restless mind gets distracted or thrown outward, it must absolutely not be allowed to wander elsewhere.
            The sincere seeker must completely and ruthlessly abandon all types of worldly worries, anxieties, and scattered thoughts (Sarvachintam).
            And he must become entirely devoid and completely free from all physical and mental efforts or restless movements (Sarvacheshta).
            In this pure state, he must continuously and profoundly investigate (meditate deeply upon) the inner Nada and absolutely nothing else.
            It is the mind's ancient, toxic habit to get bored even with pleasant things and desperately run outside seeking novelty.
            Even when the mind is enjoying the sweet bliss of Nada, an old thought can suddenly drag it violently back to the world.
            This is exactly where the seeker's true test lies; he must instantly become highly alert and force the mind right back to the Nada.
            'Abandoning all worries' means permanently throwing away the heavy, suffocating burdens of what happened yesterday and what will happen tomorrow.
            Only when the physical body becomes rock-solid and the mind becomes completely worry-free does true 'Yoga' finally occur.
            This is a state of absolute surrender where the seeker completely drops his ego and gives himself entirely to the Nada (God).
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 23,
        sanskrit = "नादमेवानुसन्दध्यान्नादे चित्तं विलीयते । मकरन्दं पिबन् भृङ्गो गन्धं नापेक्षते यथा ॥ २३ ॥",
        hindi = """
            साधक को निरंतर केवल उस परम नाद का ही ध्यान और अनुसंधान करना चाहिए, जिससे उसका चित्त उसी नाद में पूरी तरह विलीन हो जाए।
            जिस प्रकार फूलों का मीठा रस (मकरन्द) पीने में पूरी तरह मग्न हुआ भँवरा (भृंग) फिर उस फूल की सुगंध (गन्ध) की बिल्कुल परवाह नहीं करता।
            ठीक उसी प्रकार, नाद के परमानंद में डूबा हुआ मन भी बाहरी दुनिया के किसी भी विषय (सुख) की कोई इच्छा या परवाह नहीं करता।
            यह श्लोक ध्यान के विज्ञान का एक अत्यंत सुंदर और सटीक प्राकृतिक उदाहरण (Metaphor) प्रस्तुत करता है।
            भँवरे को फूल की सुगंध केवल तब तक आकर्षित करती है जब तक उसे असली 'रस' (Nectar) नहीं मिल जाता।
            एक बार जब भँवरा रस पीने लगता है, तो वह इतना खो जाता है कि अगर उसे फूल में बंद भी कर दिया जाए तो वह परवाह नहीं करता।
            हमारा मन भी बिल्कुल उस भँवरे की तरह ही है; यह दुनिया की सुगंध (पैसा, मान, वासना) के पीछे पागलों की तरह भागता है।
            पर जिस दिन इस मन को भीतर के नाद (आत्मा) का असली रस मिल जाता है, इसका सारा बाहरी भटकाव हमेशा के लिए खत्म हो जाता है।
            नाद योग कोई जबरदस्ती की तपस्या नहीं है; यह तो मन को एक ऐसा ऊँचा और मीठा सुख (Taste) देना है जिसके सामने दुनिया के सुख फीके पड़ जाएं।
            जब मन को सबसे बड़ा खजाना (ईश्वर) मिल जाता है, तो वह तुच्छ कंकड़-पत्थरों (सांसारिक इच्छाओं) को अपने-आप छोड़ देता है।
        """.trimIndent(),
        english = """
            The seeker must continuously and strictly meditate exclusively upon that Supreme Nada, so his mind completely and permanently dissolves into it.
            Exactly just as a bee (Bhringa) deeply engrossed in drinking the sweet nectar of flowers completely ignores and stops caring about the flower's fragrance.
            In the exact same way, the human mind totally drowned in the supreme bliss of Nada absolutely stops desiring or caring for any external worldly objects.
            This magnificent verse presents an exceptionally beautiful, perfectly accurate natural metaphor explaining the profound science of meditation.
            The flower's fragrance actively attracts the bee only until the bee successfully finds and tastes the actual, real 'Nectar' (Juice).
            Once the bee begins drinking the sweet nectar, it becomes so blissfully lost that even if trapped inside the flower, it simply doesn't care.
            Our human mind is exactly, identically like that restless bee; it runs like a maniac after the fragrance of the world (money, fame, lust).
            But the exact day this mind tastes the real, ultimate nectar of the inner Nada (Soul), all its external wandering ends permanently forever.
            Nada Yoga is not a forced, brutal penance; it is simply giving the mind such a highly superior, sweet taste that all worldly joys instantly fade.
            When the mind finally discovers the absolute greatest treasure (God), it automatically drops the trivial, useless pebbles (worldly desires).
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 24,
        sanskrit = "नादासक्तं तथा चित्तं विषयान्न हि काङ्क्षते । बद्धं तु नादबन्धेन सदानन्दमयीं व्रजेत् ॥ २४ ॥",
        hindi = """
            उस परम नाद (आंतरिक गूँज) में पूरी तरह आसक्त और डूबा हुआ चित्त (मन) फिर कभी भी सांसारिक विषयों (भोगों) की इच्छा बिल्कुल नहीं करता।
            नाद रूपी मजबूत रस्सी के बंधन से बँधा हुआ वह मन हमेशा के लिए उस 'सदानंदमयी' (हमेशा रहने वाले आनंद) अवस्था को प्राप्त कर लेता है।
            यह श्लोक 'आसक्ति' (Attachment) की दिशा बदलने का महान रहस्य बताता है।
            मन का स्वभाव है कि उसे किसी न किसी चीज़ की आसक्ति (लगाव) चाहिए ही चाहिए; वह खाली नहीं रह सकता।
            इसलिए, अगर हम मन से दुनिया की आसक्ति छीनेंगे, तो वह डिप्रेशन (Depression) में चला जाएगा।
            परंतु यदि हम मन की आसक्ति को दुनिया से हटाकर उस मधुर नाद (ईश्वर) में लगा दें, तो वह परम शांत हो जाता है।
            नाद कोई लोहे की जंजीर नहीं है; यह एक अत्यंत प्रेमपूर्ण और आनंददायक बंधन है जो इंसान को वास्तव में आज़ाद करता है।
            जैसे एक पागल हाथी को वश में करने के लिए एक मजबूत खूँटे की जरूरत होती है, वैसे ही मन रूपी हाथी के लिए नाद वह खूँटा है।
            सदानंदमयी अवस्था वह है जहाँ सुख कभी खत्म नहीं होता, क्योंकि इसका स्रोत (आत्मा) कभी नहीं मिटता।
            यही 'योग' की अंतिम सफलता है—जहाँ संसार का रस पूरी तरह सूख जाता है और ब्रह्मानंद की बाढ़ आ जाती है।
        """.trimIndent(),
        english = """
            The mind (Chitta) that is totally attached to and completely drowned in that Supreme Nada absolutely never craves or desires worldly objects ever again.
            Firmly bound by the unbreakable, sweet bond of the Nada, that restless mind permanently and successfully attains the state of 'Sadanandamayi' (Eternal Bliss).
            This profound verse reveals the magnificent, ultimate secret of completely changing the entire direction of 'Attachment' (Asakti).
            It is the fundamental nature of the mind to demand attachment to something; it simply cannot exist in a completely empty vacuum.
            Therefore, if we forcefully snatch worldly attachments away from the mind, it will instantly plunge into deep, terrifying depression.
            But if we actively shift the mind's attachment from the world directly onto that sweet Nada (God), it becomes supremely tranquil.
            Nada is not an iron chain; it is an exceptionally loving, immensely blissful bond that actually and truly liberates a human being.
            Just as a strong peg is absolutely required to tame a mad elephant, the Nada is that unbreakable peg for the mad elephant of the mind.
            The state of eternal bliss is where joy absolutely never ends, simply because its ultimate source (the Soul) never perishes.
            This is the absolute, crowning success of 'Yoga'—where the juice of the world dries up completely and the flood of cosmic bliss arrives.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 25,
        sanskrit = "विक्षेपाखिलमुत्सृज्य प्राणानिलपुरःसरम् । अन्तरङ्गस्य सारङ्गबन्धने वागुरायते ॥ २५ ॥",
        hindi = """
            यह नाद मन के सभी प्रकार के भटकावों और विक्षेपों (Distractions) को पूरी तरह से नष्ट कर देता है और प्राण वायु को स्थिर कर देता है।
            जिस प्रकार जंगल में भागते हुए एक चंचल हिरण (सारंग) को पकड़ने के लिए शिकारी एक मजबूत जाल (वागुरा) बिछाता है।
            ठीक उसी प्रकार, यह नाद हमारे अत्यंत चंचल और भीतर भटकने वाले मन रूपी हिरण (अन्तरङ्ग सारङ्ग) को पकड़ने और बाँधने के लिए एक अचूक जाल बन जाता है।
            मन की तुलना हमेशा एक डरे हुए और चंचल हिरण से की जाती है जो जंगल (संसार) में यहाँ-वहाँ भागता रहता है।
            हिरण को संगीत (नाद) बहुत पसंद होता है; शिकारी अक्सर मधुर संगीत बजाकर हिरण को सम्मोहित करके पकड़ लेते हैं।
            ऋषियों ने इस मनोविज्ञान का उपयोग ध्यान में किया: नाद का दिव्य संगीत इस मन रूपी हिरण को पूरी तरह सम्मोहित (Hypnotize) कर लेता है।
            जब मन नाद को सुनता है, तो वह इतना मुग्ध हो जाता है कि वह अपनी सारी भाग-दौड़ भूलकर वहीं रुक जाता है।
            'वागुरायते' का अर्थ है कि यह नाद कोई सजा नहीं, बल्कि एक मीठा जाल है जो मन को मुक्ति के लिए कैद करता है।
            जब मन का हिरण इस जाल में फँस जाता है, तो हमारी प्राण ऊर्जा (सांसें) अपने-आप अत्यंत शांत और गहरी हो जाती हैं।
            यह श्लोक सिद्ध करता है कि मन को लड़कर नहीं, बल्कि प्रेम और दिव्य आनंद का लालच देकर ही जीता जा सकता है।
        """.trimIndent(),
        english = """
            This Nada completely and flawlessly destroys all kinds of mental distractions (Vikshepas) and perfectly stabilizes the vital Prana breath.
            Just as a hunter meticulously lays out a strong, unbreakable net (Vagura) to capture a highly restless, wildly running deer (Saranga) in the forest.
            Exactly similarly, this supreme Nada becomes an infallible, foolproof net to successfully catch and firmly bind our highly restless, inwardly wandering mind-deer.
            The human mind is universally and constantly compared to a terrified, highly restless deer wildly running here and there in the forest (world).
            Deer inherently possess a deep, natural love for sweet music; hunters often play highly melodious music to hypnotize and capture them.
            The ancient sages brilliantly utilized this psychology in meditation: the divine music of Nada completely and flawlessly Hypnotizes the mind-deer.
            When the mind vividly hears the Nada, it becomes so utterly enchanted that it completely forgets all its chaotic running and stops perfectly still.
            'Vagurayate' profoundly means this Nada is not a harsh punishment, but an incredibly sweet net that captures the mind purely for its own liberation.
            When the deer of the mind gets firmly caught in this divine net, our vital Prana energy (breath) automatically becomes exceptionally calm and deep.
            This verse definitively proves that the mind cannot be conquered by fighting it, but strictly by tempting it with supreme love and divine bliss.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 26,
        sanskrit = "अन्तरङ्गसमुद्रस्य मर्यादा नाद एव च । ब्रह्मप्रणवसंलग्नं नादो ज्योतिर्मयात्मकः ॥ २६ ॥",
        hindi = """
            यह परम नाद हमारे मन रूपी अत्यंत विशाल और अशांत समुद्र (अन्तरङ्ग-समुद्र) के लिए एक मजबूत किनारे (मर्यादा) के समान काम करता है।
            (अर्थात यह नाद विचारों की तूफानी लहरों को रोककर मन के समुद्र को अपनी सीमा में शांत रखता है)।
            यह नाद साक्षात् उस परब्रह्म और पवित्र ॐकार (प्रणव) के साथ पूरी तरह से जुड़ा (संलग्न) हुआ है।
            और यह नाद कोई जड़ ध्वनि नहीं है, बल्कि यह स्वयं ज्योतिर्मय (दिव्य प्रकाश और चेतना से भरा हुआ) है।
            समुद्र में जब तूफान आता है तो वह अपनी मर्यादा (सीमा) तोड़कर सब कुछ डुबो देता है; हमारा मन भी बिल्कुल ऐसा ही है।
            वासनाओं के तूफान से मन का समुद्र उफनने लगता है और इंसान को डिप्रेशन और अपराधों में डुबो देता है।
            परंतु नाद योग का अभ्यास उस मन के समुद्र के चारों ओर एक इतना मजबूत किनारा (तट) बना देता है कि वह शांत हो जाता है।
            नाद केवल कानों में बजने वाली कोई सामान्य सीटी (Ring) नहीं है; यह उस ॐकार का साक्षात् रूप है जिससे ब्रह्मांड पैदा हुआ।
            यह 'ज्योतिर्मय' है, जिसका मतलब है कि जब आप इस ध्वनि में डूबते हैं, तो आपको केवल आवाज़ ही नहीं, बल्कि भीतर एक दिव्य प्रकाश भी दिखता है।
            यही वह प्रकाश है जो अज्ञान के सारे अंधेरे को चीरकर आत्मा को उसके सबसे शुद्ध और असली रूप में प्रकट कर देता है।
        """.trimIndent(),
        english = """
            This supreme Nada acts exactly like a highly formidable, strong shore (Maryada) for the incredibly vast, restless ocean of our mind (Antaranga-samudra).
            (Meaning, this Nada completely stops the stormy, destructive waves of chaotic thoughts and keeps the ocean of the mind peacefully within its limits).
            This profound Nada is intimately, perfectly, and completely united (Samlagna) with the Supreme Brahman and the sacred Omkara (Pranava).
            And this Nada is absolutely not an inert, dead sound; rather, it is inherently Jyotirmaya (brilliantly illuminated and entirely filled with divine light).
            When a violent storm strikes the ocean, it breaks its shores and drowns everything; our uncontrolled human mind is exactly identically like this.
            The fierce storm of deep lusts makes the mind's ocean surge violently, mercilessly drowning the human in deep depression and terrible crimes.
            But the dedicated practice of Nada Yoga instantly builds such an incredibly strong, unbreakable shore around that mental ocean that it becomes perfectly calm.
            Nada is absolutely not a common, ordinary ringing sound in the ears; it is the direct manifestation of that very Omkara from which the cosmos was born.
            It is 'Jyotirmaya', which profoundly means when you drown in this sound, you don't just hear noise, you also clearly see a brilliant divine light within.
            This is the exact supreme light that tears through all the thick darkness of ignorance and reveals the Soul in its absolute purest, most original form.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 27,
        sanskrit = "मनोमत्तगजेन्द्रस्य विषयोद्यानचारिणः । नियमने समर्थोऽयं निनादो निशिताङ्कुशः ॥ २७ ॥",
        hindi = """
            यह हमारा चंचल मन एक अत्यंत 'पागल और मतवाले हाथी' (मत्तगजेन्द्र) के समान है।
            जो इस संसार के भोगों और वासनाओं रूपी बगीचे (विषयोद्यान) में बेलगाम होकर घूमता और उसे नष्ट करता रहता है।
            उस बेलगाम और पागल हाथी को पूरी तरह से नियंत्रित (नियमन) करने के लिए यह नाद अत्यंत समर्थ और शक्तिशाली है।
            क्योंकि यह नाद उस पागल हाथी को वश में करने वाला एक अत्यंत तीक्ष्ण और धारदार 'अंकुश' (निशितांकुश) है।
            उपनिषद यहाँ मन की एक और अत्यंत सटीक और भयंकर उपमा (Metaphor) देता है: एक पागल हाथी।
            जब हाथी पागल हो जाता है, तो वह किसी की नहीं सुनता; वह पूरे बगीचे (हमारे जीवन और शांति) को कुचल कर रख देता है।
            हमारा मन भी जब काम, क्रोध और लोभ में पागल होता है, तो वह हमारे सारे पुण्यों और सुकून को एक पल में कुचल देता है।
            महावत (Mahout) उस पागल हाथी को किसी रस्सी से नहीं, बल्कि एक छोटे पर बहुत तेज 'अंकुश' (Goad) से कंट्रोल करता है।
            ध्यान में गूँजने वाला यह नाद (Sound) ही वह तेज अंकुश है जो मन के घमंड और पागलपन को तुरंत भेद देता है।
            जैसे ही नाद का अंकुश मन पर पड़ता है, वह पागल हाथी घुटने टेक देता है और एक अत्यंत आज्ञाकारी सेवक बन जाता है।
        """.trimIndent(),
        english = """
            This highly restless mind of ours is exactly like an extremely 'Mad, intoxicated, and wild Elephant' (Mattagajendra).
            Which continuously roams utterly unchecked, destroying everything in the lush garden of worldly pleasures and deep lusts (Vishayodyana).
            To flawlessly and completely control (Niyamana) that wild, highly unbridled, and completely mad elephant, this Nada is supremely capable.
            Because this absolute Nada is the most exceedingly sharp, pointed, and powerful 'Goad' (Nishitankusha) designed to tame that mad elephant perfectly.
            The Upanishad provides another exceedingly accurate and terrifying metaphor for the human mind here: a violently mad elephant.
            When an elephant goes completely mad, it listens to absolutely no one; it mercilessly crushes the entire beautiful garden (our life and peace) into dust.
            Similarly, when our mind goes mad with fierce lust, blinding anger, and greed, it crushes all our hard-earned merits and peace in a single second.
            The Mahout does not control that mad elephant with a mere rope, but strictly with a small, yet exceptionally sharp 'Goad' (Ankusha).
            This specific Nada (Sound) echoing in deep meditation is that exact sharp goad that instantly pierces the arrogance and utter madness of the mind.
            The very moment the goad of Nada strikes the mind, that mad elephant instantly falls to its knees and flawlessly becomes a highly obedient, tame servant.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 28,
        sanskrit = "मनःसर्पस्य बन्धने नादः पाशायते खलु । निनादप्रणवोद्धारं यावच्छब्दः प्रवर्तेत ॥ २८ ॥",
        hindi = """
            यह हमारा मन एक अत्यंत जहरीले और चंचल 'साँप' (मनःसर्प) के समान है जो हमेशा फुफकारता और डसने को तैयार रहता है।
            उस खतरनाक साँप को पकड़ने और बाँधने के लिए यह नाद एक अत्यंत अचूक जाल या फंदे (पाश) के समान काम करता है।
            जब सपेरा बीन (संगीत) बजाता है, तो वह जहरीला साँप अपनी सारी आक्रामकता भूलकर उस धुन में पूरी तरह खो जाता है।
            ठीक उसी तरह, ॐकार (प्रणव) की यह दिव्य गूँज हमारे मन रूपी साँप को पूरी तरह से सम्मोहित (Hypnotize) कर देती है।
            जब तक शरीर में यह नाद रूपी शब्द (ध्वनि) गूँजता और प्रवृत्त रहता है, तब तक मन भी पूरी तरह से वश में रहता है।
            यह श्लोक मन की तीसरी और सबसे खतरनाक उपमा देता है: एक ज़हरीला साँप जो हर पल चिंताओं का ज़हर उगल रहा है।
            हम अपने ही दिमाग के डसे हुए (Bitten) लोग हैं, जहाँ 'ओवरथिंकिंग' (Overthinking) का ज़हर हमारी नसों में दौड़ रहा है।
            इस साँप को लाठी से मारना संभव नहीं है; इसे केवल नाद (Sound) की मीठी और रहस्यमयी धुन से ही कीला (काबू किया) जा सकता है।
            जब मन की वृत्तियाँ नाद में उलझ जाती हैं, तो उसका फन हमेशा के लिए नीचे गिर जाता है और वह शांत होकर लेट जाता है।
            यही नाद योग का असली जादू है जो बिना किसी शारीरिक संघर्ष के सबसे भयंकर मन को भी अपना गुलाम बना लेता है।
        """.trimIndent(),
        english = """
            This mind of ours is exactly like an exceptionally highly venomous and restless 'Snake' (Manahsarpa) that constantly hisses and is always ready to bite.
            To successfully capture and firmly bind that highly dangerous snake, this Nada acts exactly like an infallible, inescapable net or snare (Pasha).
            When a snake charmer plays his flute (music), that venomous snake instantly forgets all its lethal aggression and becomes completely lost in that tune.
            In the exact same way, this highly divine echo of the Omkara (Pranava) flawlessly and completely Hypnotizes our deadly snake-like mind.
            As long as this specific Nada (Sound) continues to echo and actively reverberate within the body, the mind remains flawlessly and totally under absolute control.
            This verse provides the third and most highly dangerous metaphor for the mind: a venomous snake continuously spewing the lethal poison of endless anxieties.
            We are all people severely bitten by our very own brains, where the toxic poison of constant 'Overthinking' actively courses fiercely through our veins.
            It is absolutely impossible to kill this snake with a stick; it can only be effectively tamed and charmed by the sweet, highly mystical melody of Nada (Sound).
            When the mental modifications get deeply entangled in the Nada, its hood instantly drops down forever and it peacefully lies down perfectly still.
            This is the real, absolute magic of Nada Yoga which effortlessly enslaves the most terrifying, venomous mind completely without any physical struggle.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 29,
        sanskrit = "नादश्रवणतश्चित्तमन्तरङ्गं विलीयते । विस्मृत्य सकलं बाह्यं नादे दुग्धाम्बुवत्स्तितम् ॥ २९ ॥",
        hindi = """
            इस परम नाद (आंतरिक गूँज) को निरंतर और अत्यंत गहराई से सुनने मात्र से ही, मनुष्य का चित्त (मन) पूरी तरह से पिघल कर विलीन हो जाता है।
            वह मन बाहरी दुनिया (बाह्य) के सभी विषयों, आकर्षणों और झंझटों को पूरी तरह से भूल (विस्मृत्य) जाता है।
            और वह मन उस नाद के अंदर बिल्कुल उसी प्रकार एकरूप होकर मिल जाता है, जैसे 'दूध में मिलाया गया पानी' (दुग्धाम्बुवत्)।
            यह ध्यान की वह अत्यंत गहरी अवस्था है जहाँ 'मैं' (Individual identity) का पूरी तरह से नाश (Dissolution) हो जाता है।
            मन हमेशा कुछ न कुछ सोचना चाहता है, पर जब उसे नाद की असीम मिठास मिल जाती है, तो वह सोचकर अपनी ऊर्जा बर्बाद नहीं करता।
            बाहरी दुनिया की याददाश्त (Memory) का पूरी तरह मिट जाना ही समाधि की सबसे बड़ी निशानी है।
            जैसे दूध और पानी को मिलाने के बाद आप उन्हें अलग नहीं कर सकते, वैसे ही नाद और मन मिलकर एक अखंड तत्व बन जाते हैं।
            उस अवस्था में यह पता ही नहीं चलता कि नाद मन को सुन रहा है, या मन नाद को सुन रहा है; केवल 'सुनना' शेष रहता है।
            यही वह परम विश्राम (Absolute Rest) है जहाँ इंसान को अपने जीवन के सारे तनावों से हमेशा के लिए आज़ादी मिल जाती है।
            नाद योग की यह प्रक्रिया मन को मारने की नहीं, बल्कि मन को उसके सबसे सुंदर और शुद्ध रूप में विलीन (Melt) करने की है।
        """.trimIndent(),
        english = """
            Merely by continuously and profoundly listening to this Supreme Nada (inner echo), the human mind (Chitta) completely melts and flawlessly dissolves away.
            That mind completely and absolutely forgets (Vismritya) all the external objects, blinding attractions, and chaotic entanglements of the outside world.
            And that mind perfectly merges and becomes entirely one with that Nada, exactly like 'water seamlessly mixed into pure milk' (Dugdhambuvat).
            This is that exceedingly deep, ultimate state of meditation where the 'I' (Individual identity) completely and permanently undergoes total dissolution.
            The mind perpetually wants to think about something, but when it discovers the infinite sweetness of Nada, it no longer wastes its energy in useless thinking.
            The absolute, total erasure of all memory of the external world is the absolute greatest, most confirmed sign of true Samadhi.
            Just as you can never separate water from milk once mixed, the Nada and the mind merge perfectly to become one single, unbroken element.
            In that high state, one cannot possibly distinguish whether the Nada is hearing the mind, or the mind is hearing the Nada; only pure 'Hearing' remains.
            This is exactly that absolute, Supreme Rest (Absolute Rest) where a human being gains permanent, eternal freedom from all the harsh stresses of his life.
            This profound process of Nada Yoga is absolutely not about killing the mind violently, but about flawlessly melting it into its most beautiful, purest form.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 30,
        sanskrit = "उदासीनस्ततो भूत्वा नक्तन्दिनमखेदयन् । काष्ठे प्रवर्त्तितो वह्निः काष्ठेन सह शाम्यति ॥ ३० ॥",
        hindi = """
            साधक को चाहिए कि वह बाहरी दुनिया के प्रति पूरी तरह से 'उदासीन' (तटस्थ / Unattached) हो जाए।
            और वह दिन-रात (नक्तन्दिनम्) बिना किसी खेद, दुख या आलस्य के केवल इसी नाद के ध्यान में लगा रहे।
            जिस प्रकार सूखी लकड़ी (काष्ठ) में लगाई गई आग (वह्नि) उस पूरी लकड़ी को जलाकर अंत में उस लकड़ी के साथ ही शांत (शाम्यति) हो जाती है।
            ठीक उसी प्रकार, नाद में लगा हुआ मन भी अंततः उसी नाद के साथ परम शून्यता में शांत हो जाता है।
            उदासीन होने का अर्थ बेपरवाह होना नहीं है; इसका अर्थ है दुनिया के नाटकों में कोई भी 'रिएक्शन' (Reaction) न देना।
            चाहे कोई गाली दे या तारीफ करे, साधक का मन एक पत्थर की तरह स्थिर रहता है; उसकी ऊर्जा केवल नाद पर केंद्रित होती है।
            यहाँ आग (ध्यान/नाद) और लकड़ी (मन/विचार) का बहुत ही शानदार और वैज्ञानिक रूपक (Metaphor) दिया गया है।
            ध्यान की आग सबसे पहले मन के सारे गंदे विचारों (लकड़ी) को जलाकर राख कर देती है।
            परंतु जब जलाने के लिए कोई विचार (लकड़ी) नहीं बचता, तो वह ध्यान की आग भी खुद-ब-खुद बुझ जाती है।
            पीछे केवल राख (Egoless state) और परम सन्नाटा बचता है; यही 'अमन' (No-mind) की अवस्था है जहाँ पूर्ण मोक्ष है।
        """.trimIndent(),
        english = """
            The sincere seeker must become entirely 'Udasina' (completely neutral, detached, and unattached) toward the entire external world.
            And he must engage strictly in the meditation of this Nada day and night (Naktandinam) without absolutely any regret, sorrow, or laziness.
            Exactly just as a blazing fire (Vahni) ignited perfectly within a piece of dry wood (Kastha) completely burns that wood and finally extinguishes (Shamyati) along with it.
            In the exact same way, the highly focused mind engaged in the Nada ultimately becomes perfectly quiet and extinguishes into supreme void along with the Nada.
            Being detached absolutely does not mean being careless; it means giving zero 'Reactions' to the endless, chaotic dramas of the world.
            Whether someone insults or praises, the seeker's mind remains as still as a rock; his vital energy is strictly and entirely focused on the Nada.
            A highly magnificent, flawless scientific metaphor of fire (meditation/Nada) and wood (mind/thoughts) is beautifully presented here.
            The intense fire of meditation absolutely first burns all the dirty, chaotic thoughts (wood) of the mind entirely to ashes.
            But when absolutely no thought (wood) remains left to be burnt, that very fire of meditation automatically and naturally extinguishes itself.
            Only pure ashes (Egoless state) and absolute, supreme Silence remain behind; this is the 'Amana' (No-mind) state where absolute Moksha exists.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 31,
        sanskrit = "तथा नादं समाश्रित्य चित्तं नादे विलीयते । घण्टादिनादप्रणवध्वनिर्यः... ॥ ३१ ॥",
        hindi = """
            (पिछले श्लोक को पूरा करते हुए): ठीक उसी आग और लकड़ी के समान, जो चित्त (मन) इस परम 'नाद' का पूरी तरह से आश्रय (सहारा) ले लेता है।
            वह मन अंततः उसी नाद (आंतरिक ध्वनि) में पूरी तरह से विलीन (खत्म) होकर परम शून्यता को प्राप्त हो जाता है।
            वह योगी जो अपने भीतर गूँजने वाले घंटी, शंख, और ॐकार (प्रणव) की परम ध्वनियों को निरंतर सुनता है।
            उसका वह चंचल मन हमेशा के लिए नष्ट हो जाता है और वह सीधे ब्रह्म से जुड़ जाता है।
            यह श्लोक 'लय योग' (Yoga of Dissolution) का सबसे अंतिम और सबसे महान सिद्धांत (Ultimate principle) है।
            मन कभी भी अपने-आप नहीं मर सकता; उसे मारने (शांत करने) के लिए नाद जैसी किसी अत्यंत शक्तिशाली चीज़ का आश्रय लेना ही पड़ता है।
            जब मन नाद को पकड़ता है, तो नाद मन को ऐसे खा जाता है जैसे आग कपूर (Camphor) को खा जाती है।
            घंटी और ॐ की ध्वनियां कोई साधारण आवाज़ें नहीं हैं; ये ब्रह्मांड की वे चाबियां हैं जो सीधे आत्मा के ताले खोलती हैं।
            विलीन होने का अर्थ मरना नहीं है, बल्कि अपनी छोटी और सीमित पहचान (Ego) को छोड़कर एक विराट और असीम (Infinite) सत्ता बन जाना है।
            यही वह अवस्था है जहाँ इंसान और ईश्वर के बीच की आखिरी दीवार भी हमेशा के लिए टूट कर गिर जाती है।
        """.trimIndent(),
        english = """
            (Completing the previous verse): Exactly like that fire and wood, the mind (Chitta) that completely and flawlessly takes absolute refuge in this Supreme 'Nada'.
            That mind ultimately totally dissolves (vanishes) completely into that very Nada (inner sound) and successfully attains the supreme Void.
            That true Yogi who continuously and profoundly hears the supreme cosmic sounds of the bell, conch, and Omkara (Pranava) echoing right within him.
            His highly restless mind is completely destroyed forever, and he directly and flawlessly unites with the Supreme Brahman.
            This verse is the absolute final and most magnificent ultimate principle of 'Laya Yoga' (the Yoga of Total Dissolution).
            The mind can absolutely never die on its own; to kill (silence) it, one must essentially take the firm refuge of something exceedingly powerful like the Nada.
            When the mind firmly grasps the Nada, the Nada swallows the mind completely, exactly as blazing fire effortlessly consumes pure camphor.
            The sounds of the bell and OM are absolutely not ordinary noises; they are the supreme cosmic keys that directly open the locks of the Soul.
            Dissolving absolutely does not mean dying, but completely dropping one's tiny, limited identity (Ego) to flawlessly become a colossal, Infinite reality.
            This is exactly that supreme state where the absolute final wall standing between a human and God permanently shatters and falls away.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 32,
        sanskrit = "तत्रान्तःकरणं विलीयते । तद्विष्णोः परमं पदम् ॥ ३२ ॥",
        hindi = """
            जब वह घंटी और ॐ की ध्वनि पूर्ण शून्यता में शांत होती है, तब वहाँ (तत्र) साधक का पूरा 'अन्तःकरण' (मन, बुद्धि, चित्त और अहंकार) भी पूरी तरह विलीन (Melt) हो जाता है।
            और जब अहंकार और मन पूरी तरह मिट जाते हैं, तब जो परम अवस्था प्रकट होती है, वही साक्षात् 'भगवान विष्णु का परम पद' (तद्विष्णोः परमं पदम्) है।
            यह उपनिषद की सबसे ऊँची और सबसे स्पष्ट घोषणाओं (Declarations) में से एक है।
            अंतःकरण हमारी वह 'सॉफ्टवेयर' (Software) मशीन है जो सारी इच्छाएं, यादें और घमंड (Ego) पैदा करती है।
            जब तक यह मशीन चालू है, इंसान स्वर्ग तो जा सकता है, पर उसे भगवान (विष्णु) का 'परम पद' कभी नहीं मिल सकता।
            विष्णु का परम पद कोई सोने का सिंहासन नहीं है; यह चेतना की वह असीम और सर्वव्यापी (Omnipresent) अवस्था है जो हर जगह मौजूद है।
            नाद की अंतिम सीढ़ी यही है कि आवाज़ के साथ-साथ 'सुनने वाला' (The Listener) भी हमेशा के लिए गायब हो जाए।
            जब सुनने वाला ही नहीं बचा, तो कौन दुखी होगा और कौन डरेगा?
            यह परम पद ही हमारी असली घर-वापसी (Homecoming) है, जिसके बाद आत्मा को किसी भी शरीर के किराये के मकान में नहीं जाना पड़ता।
            यहाँ नाद योग की सम्पूर्ण प्रक्रिया अपनी चरम और परम सफलता (Absolute success) पर पहुँच जाती है।
        """.trimIndent(),
        english = """
            When that divine sound of the bell and OM falls perfectly silent into absolute void, right there (Tatra) the seeker's entire 'Antahkarana' (Mind, Intellect, Memory, and Ego) completely dissolves (Melts).
            And exactly when the ego and mind are completely annihilated, the supreme state that flawlessly manifests is the direct, absolute 'Supreme Abode of Lord Vishnu' (Tadvishnoh paramam padam).
            This is undeniably one of the absolute highest, most crystal-clear declarations of the entire Upanishad.
            The Antahkarana is our internal 'Software' machine that actively produces absolutely all our worldly desires, memories, and toxic pride (Ego).
            As long as this machine is running, a human might go to heaven, but he can absolutely never attain the 'Supreme Abode' of God (Vishnu).
            Vishnu's supreme abode is absolutely not a golden throne; it is that infinite, completely Omnipresent state of consciousness existing everywhere.
            The absolute final step of Nada is that along with the sound, the 'Listener' himself must disappear completely forever.
            When the listener himself no longer exists, who will possibly feel sorrow and who will ever feel fear?
            This Supreme Abode is our true, ultimate 'Homecoming', after which the Soul absolutely never has to enter the rented house of any physical body again.
            Right here, the entire, profound process of Nada Yoga flawlessly reaches its absolute, ultimate, and extreme success.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 33,
        sanskrit = "यावच्छब्दः प्रवर्तेत तावदाकाशसंकल्पः । निःशब्दं तत्परं ब्रह्म परमात्मेति गीयते ॥ ३३ ॥",
        hindi = """
            जब तक साधक के भीतर वह नाद रूपी 'शब्द' (ध्वनि) गूँजता और प्रवृत्त (चलना) रहता है, तब तक उसके मन में 'आकाश' (स्पेस/अस्तित्व) का संकल्प (ख्याल) बना रहता है।
            परंतु जब वह ध्वनि पूरी तरह से शांत होकर 'निःशब्द' (पूर्ण मौन/शून्यता) में बदल जाती है।
            तब उस निःशब्द (शब्द-रहित) और परम शांत अवस्था को ही साक्षात् 'परब्रह्म' और 'परमात्मा' के रूप में गाया (कहा) जाता है।
            यह श्लोक अद्वैत वेदान्त की गहराई को छूता है; ध्वनि भी एक प्रकार की उपाधि (Limitation) ही है।
            ध्यान में आवाज़ (नाद) बहुत अच्छी है, पर वह भी अंतिम सत्य नहीं है; वह केवल सत्य तक पहुँचने की नाव (Boat) है।
            जब तक आवाज़ है, तब तक आकाश (Space) है, क्योंकि आवाज़ आकाश में ही गूँजती है (शब्दगुणकमाकाशम्)।
            परंतु ब्रह्म तो आकाश से भी परे है; वह उस जगह रहता है जहाँ न हवा है, न आकाश है, और न ही कोई आवाज़ है।
            इसलिए साधक को आवाज़ के मज़े में ही नहीं रुकना है; उसे आवाज़ के खत्म होने पर आने वाले उस भयानक 'सन्नाटे' (Silence) में छलांग लगानी है।
            यही निःशब्द अवस्था वह जगह है जहाँ सारे वेद और शास्त्र चुप हो जाते हैं (नेति नेति)।
            वह सन्नाटा ही असली परमात्मा है जो कभी बोलता नहीं, पर जिसके होने से सब कुछ होता है।
        """.trimIndent(),
        english = """
            As long as that 'Shabda' (Sound) in the form of Nada continues to echo and actively reverberate within the seeker, the profound concept (resolve) of 'Akasha' (Space/existence) remains in his mind.
            But when that divine sound falls completely, perfectly silent and transforms entirely into 'Nishabda' (Absolute Silence/Soundless void).
            Then that exact Nishabda (wordless) and supremely tranquil state is directly sung (declared) by the sages strictly as the 'Supreme Brahman' and the 'Paramatma'.
            This magnificent verse intimately touches the absolute profound depth of Advaita Vedanta; even divine sound is ultimately a subtle limitation.
            The sound (Nada) in meditation is incredibly good, but even it is absolutely not the final Truth; it is merely the necessary boat to reach the Truth.
            As long as there is sound, there is Akasha (Space), because sound flawlessly reverberates strictly within space.
            But Brahman is completely beyond even Space; He exclusively resides precisely where there is no wind, no space, and absolutely zero sound.
            Therefore, the seeker must absolutely not stop at the mere pleasure of the sound; he must courageously jump straight into that terrifying 'Silence' that follows the sound's end.
            This exact soundless state is the ultimate place where absolutely all Vedas and scriptures fall completely silent (Neti Neti).
            That profound Silence itself is the real, ultimate Supreme Lord who never speaks, yet by whose mere presence absolutely everything happens.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 34,
        sanskrit = "नादो यावन्मनस्तावन्नादान्तेऽपि मनोन्मनी । सशब्दश्चाक्षरे क्षीणे निःशब्दं परमं पदम् ॥ ३४ ॥",
        hindi = """
            जब तक भीतर वह 'नाद' (ध्वनि) रहता है, केवल तभी तक इस 'मन' का भी अस्तित्व रहता है (नाद और मन साथ-साथ चलते हैं)।
            परंतु जब वह नाद पूरी तरह से समाप्त (अंत) हो जाता है, तो यह मन भी नष्ट होकर 'मनोन्मनी' (मन-रहित / शून्यता) अवस्था को प्राप्त हो जाता है।
            जब वह ध्वनि (सशब्द) पूरी तरह क्षीण (नष्ट) होकर उस 'अक्षर' (अविनाशी ब्रह्म) में लीन हो जाती है।
            तब जो परम 'निःशब्द' (सन्नाटा) बचता है, वही वास्तव में सबसे सर्वोच्च और 'परम पद' है।
            यह श्लोक विज्ञान के उस नियम को बताता है कि मन और आवाज़ का बहुत गहरा संबंध है।
            मन हमेशा किसी न किसी आवाज़ या विचार (Internal dialogue) पर टिका रहता है।
            जब हम नाद (Cosmic sound) पर फोकस करते हैं, तो मन के बाकी सारे फालतू विचार खत्म हो जाते हैं।
            और जब वह नाद भी अंत में शून्य हो जाता है, तो मन के पास टिकने के लिए कोई जगह (Support) नहीं बचती, इसलिए मन 'मर' जाता है।
            मन के मरने (मनोन्मनी) का अर्थ है अहंकार का मिट जाना और आत्मा का पूर्ण रूप से जाग जाना।
            यही वह निःशब्द 'परम पद' है जहाँ पहुँचने के बाद इंसान को दुनिया का कोई भी शोर या दुख कभी छू नहीं सकता।
        """.trimIndent(),
        english = """
            As long as that 'Nada' (Sound) continues to exist within, only exactly until then does this 'Mind' also maintain its existence (Nada and mind travel tightly together).
            But exactly when that Nada comes to a complete, absolute end, this mind is also destroyed and successfully attains the 'Manonmani' (Mindless / No-mind) state.
            When that sound (Sashabda) decays, completely fades away, and entirely merges into that 'Akshara' (Imperishable Brahman).
            Then the supreme 'Nishabda' (Absolute Silence) that remains is indeed, in reality, the absolute highest and most 'Supreme Abode' (Paramam Padam).
            This profound verse states the scientific rule that the human mind and sound share an exceptionally deep, inseparable connection.
            The mind is perpetually anchored on some internal sound or constant thought (Internal dialogue).
            When we firmly focus on the Nada (Cosmic sound), absolutely all other useless, chaotic thoughts of the mind are instantly destroyed.
            And when that Nada itself finally becomes zero, the mind has absolutely zero place (Support) left to stand on, hence the mind 'dies'.
            The death of the mind (Manonmani) strictly means the total annihilation of the ego and the complete, flawless awakening of the Soul.
            This is that soundless 'Supreme Abode' reaching which absolutely no worldly noise or sorrow can ever touch the human again.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 35,
        sanskrit = "सदा नादानुसन्धानात् क्षीयन्ते पापसञ्चयाः । निरञ्जने विलीयेते निश्चितं प्राणमानसौ ॥ ३५ ॥",
        hindi = """
            इस परम 'नाद' (आंतरिक ध्वनि) का निरंतर (सदा) और गहराई से अनुसंधान (ध्यान) करने से।
            साधक के करोड़ों जन्मों के इकट्ठे किए गए सभी पापों के पहाड़ (पाप-संचय) पूरी तरह से क्षीण (नष्ट/भस्म) हो जाते हैं।
            और यह बिल्कुल निश्चित (तय) है कि उस नाद के प्रभाव से साधक का 'प्राण' (श्वास) और उसका 'मानस' (मन)।
            ये दोनों उस परम शुद्ध और दाग-रहित (निरंजन) परमात्मा में हमेशा के लिए विलीन (Melt/गायब) हो जाते हैं।
            हम सोचते हैं कि पाप धोने के लिए हमें नदियों में नहाना पड़ेगा या दान करना पड़ेगा।
            पर उपनिषद कहता है कि अज्ञान ही सबसे बड़ा पाप है, और नाद का ध्यान उस अज्ञान को जड़ से जला देता है।
            जब मन नाद में डूबता है, तो नया पाप तो होता नहीं, और पुराने पाप ध्यान की आग में जल जाते हैं।
            'प्राण' और 'मन' एक ही सिक्के के दो पहलू हैं; जब मन भागता है तो सांस तेज होती है, जब मन शांत होता है तो सांस रुक जाती है।
            नाद योग इन दोनों (प्राण और मन) को एक साथ पकड़कर उस 'निरंजन' (जहाँ माया का कोई दाग नहीं) ब्रह्म में डुबो देता है।
            यह कोई शायद वाली बात नहीं है, उपनिषद 'निश्चितं' (Guaranteed) कहकर इस सफलता की पूरी मोहर लगा रहा है।
        """.trimIndent(),
        english = """
            By the continuous (Sada) and profoundly deep investigation and meditation upon this Supreme 'Nada' (Inner Sound).
            The massive mountains of all accumulated sins (Papa-sanchaya) from millions of the seeker's past births are completely destroyed and burnt to ashes (Kshiyante).
            And it is absolutely certain and guaranteed (Nishchitam) that by the supreme power of that Nada, the seeker's 'Prana' (Vital breath) and his 'Manas' (Mind).
            Both of these completely and permanently dissolve (Melt/vanish) directly into that supremely pure, spotless, and untainted (Niranjana) Supreme Lord.
            We falsely think that to wash away our sins, we absolutely must bathe in rivers or give massive physical charity.
            But the Upanishad declares that ignorance is the absolute greatest sin, and meditating on Nada burns that ignorance from its very roots.
            When the mind drowns in Nada, absolutely no new sin is committed, and all old sins are instantly burnt in the blazing fire of meditation.
            'Prana' and 'Mind' are two sides of the exact same coin; when the mind runs, breath is fast; when the mind is perfectly calm, breath stops.
            Nada Yoga forcefully grabs both of these (Prana and mind) simultaneously and drowns them entirely in that 'Niranjana' (spotless) Brahman.
            This is absolutely not a matter of 'maybe'; the Upanishad puts a complete, undeniable seal on this success by firmly saying 'Nishchitam' (Guaranteed).
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 36,
        sanskrit = "शङ्खदुन्दुभिनादं च न शृणोति कदाचन । काष्ठवज्जायते देह उन्मन्यावस्थया ध्रुवम् ॥ ३६ ॥",
        hindi = """
            जब योगी उस शून्यता (मनोन्मनी) की अत्यंत गहरी अवस्था में पहुँच जाता है, तब वह बाहरी दुनिया की किसी भी आवाज़ को बिल्कुल नहीं सुनता।
            यहाँ तक कि अगर उसके कान के पास कोई जोर से शंख बजाए या बहुत बड़े नगाड़े (दुन्दुभि) पीटे, तो भी उसे कदापि कुछ सुनाई नहीं देता।
            उस 'उन्मनी अवस्था' (जहाँ मन पूरी तरह से विचार-शून्य होकर ब्रह्म में लीन हो गया है) के प्रभाव से।
            उस योगी का भौतिक शरीर पूरी तरह से एक सूखी लकड़ी (काष्ठवत्) के समान जड़, सुन्न और अचल (ध्रुवम्) हो जाता है।
            यह समाधि की सबसे चरम और वैज्ञानिक (Scientific) अवस्था का बहुत ही सटीक वर्णन है।
            हम आवाज़ कानों से नहीं, बल्कि मन (Attention) से सुनते हैं; जब मन ही नहीं है (उन्मनी), तो कान खुली होने पर भी आवाज़ अंदर नहीं जाती।
            योगी का शरीर लकड़ी (काष्ठ) की तरह इसलिए हो जाता है क्योंकि उसकी चेतना (Consciousness) शरीर से पूरी तरह निकलकर आत्मा में सिकुड़ गई है।
            अगर उस समय उसके शरीर को कोई काटे या जलाए, तो भी उसे कोई दर्द महसूस नहीं होता।
            यह कोई बेहोशी (Coma) नहीं है; यह अति-जागरूकता (Super-consciousness) है जहाँ इंसान अपने शरीर की छोटी सी जेल से बाहर निकल चुका है।
            दुनिया वाले उसे पत्थर या लकड़ी समझ सकते हैं, पर भीतर वह परमानंद की सबसे बड़ी सुनामी का अनुभव कर रहा होता है।
        """.trimIndent(),
        english = """
            When the Yogi successfully reaches that immensely deep state of absolute void (Manonmani), he hears absolutely no sound from the external world whatsoever.
            Even if someone violently blows a loud Conch or fiercely beats massive Drums (Dundubhi) right next to his ears, he hears absolutely nothing at any time.
            Due to the supreme power of that 'Unmani State' (where the mind has become completely thoughtless and dissolved flawlessly into Brahman).
            That Yogi's physical body instantaneously becomes entirely rigid, numb, and absolutely motionless exactly like a piece of dead, dry wood (Kasthavat).
            This is an exceedingly accurate and highly scientific description of the absolute, most extreme state of deep Samadhi.
            We hear sounds not merely with our physical ears, but with our mind (Attention); when the mind itself is totally absent (Unmani), no sound enters even if the ears are open.
            The Yogi's body becomes exactly like a piece of dead wood because his entire Consciousness has completely withdrawn from the body and shrunk purely into the Soul.
            If someone were to cut or burn his physical body at that exact moment, he would absolutely feel zero pain whatsoever.
            This is not a medical coma; it is profound Super-consciousness where the human has completely broken out of the tiny prison of his physical body.
            The worldly people may view him as a mere stone or wood, but deep inside, he is actively experiencing the greatest, most massive tsunami of Supreme Bliss.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 37,
        sanskrit = "न जानाति शीतोष्णं न दुःखं न सुखं तथा । न मानं नापमानं च च्छोड़ित्वा मुनिरासते ॥ ३७ ॥",
        hindi = """
            उस उन्मनी (समाधि) की परम अवस्था में पहुँचने के बाद, वह योगी शरीर पर पड़ने वाली भयंकर सर्दी (शीत) या चिलचिलाती गर्मी (उष्ण) को बिल्कुल नहीं जानता (महसूस नहीं करता)।
            वह सांसारिक जीवन के किसी भी गहरे दुख (पीड़ा) को और किसी भी प्रकार के शारीरिक या मानसिक सुख को भी महसूस नहीं करता।
            दुनिया वाले उसे जो भी सम्मान (मान) दें या उसका कितना भी घोर अपमान (अपमान) करें, उसे इन सबका कोई भी भान (ज्ञान) नहीं रहता।
            वह सच्चा मुनि इन सभी सांसारिक द्वंद्वों (Dualities) को हमेशा के लिए पीछे छोड़कर (त्याग कर) साक्षात् ब्रह्म-रूप होकर अचल बैठ जाता है (आसते)।
            यह श्लोक सिद्ध करता है कि आत्मज्ञान कोई केवल दिमागी विचार (Intellectual idea) नहीं है; यह एक प्रैक्टिकल, शरीर को सुन्न कर देने वाला अनुभव है।
            सुख-दुख और सर्दी-गर्मी केवल त्वचा और नर्वस सिस्टम (Nervous system) के खेल हैं; आत्मा पर इनका कोई असर नहीं होता।
            जब योगी अपनी पहचान शरीर से हटाकर आत्मा में फिक्स (Fix) कर लेता है, तो शरीर के दर्द आत्मा तक नहीं पहुँच पाते।
            मान और अपमान अहंकार (Ego) की खुराक हैं; जब अहंकार ही मर गया, तो अपमान किसे लगेगा?
            यह वह अवस्था है जहाँ इंसान सच में 'बुलेटप्रूफ' (Bulletproof) हो जाता है—दुनिया का कोई भी हथियार या शब्द उसे घाव नहीं दे सकता।
            यही एक सच्चे मुनि की असली पहचान है; वह दुनिया में रहता है, पर दुनिया की कोई भी परिस्थिति उसे हिला नहीं सकती।
        """.trimIndent(),
        english = """
            After successfully reaching that supreme state of Unmani (Samadhi), that Yogi absolutely does not know (or feel) terrifying cold (Shita) or scorching heat (Ushna) falling upon his body.
            He absolutely does not feel any deep worldly sorrow (Pain) nor does he experience any kind of physical or mental pleasure (Sukha) whatsoever.
            Whatever great honor (Mana) the worldly people give him, or however severely they insult (Apamana) him, he remains completely oblivious and totally unaware of it all.
            That true, realized sage permanently leaves behind (renounces) absolutely all these worldly dualities and sits perfectly unmoving (Asate) as the direct embodiment of Brahman.
            This magnificent verse flawlessly proves that Self-knowledge is not merely an intellectual idea; it is a highly practical, body-numbing, profound living experience.
            Joy-sorrow and heat-cold are merely the petty games of the skin and the nervous system; they have absolutely zero effect on the Soul.
            When the Yogi permanently shifts his identity from the physical body and fixes it entirely on the Soul, the body's pain simply cannot reach the Soul.
            Honor and insult are the daily food of the Ego; when the ego itself is completely dead, who exactly will feel insulted?
            This is the supreme state where a human being truly and literally becomes 'Bulletproof'—absolutely no worldly weapon or harsh word can ever wound him.
            This is the absolute, true hallmark of a genuine Muni; he lives physically in the world, yet absolutely no circumstance of the world can ever possibly shake him.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 38,
        sanskrit = "अवस्थात्रयमुत्सृज्य चिन्तात्रयविवर्जितः । मृतवत्तिष्ठते योगी स मुक्तो नात्र संशयः ॥ ३८ ॥",
        hindi = """
            वह योगी जाग्रत (जागना), स्वप्न (सपने देखना) और सुषुप्ति (गहरी नींद)—इन तीनों अवस्थाओं (अवस्थात्रय) की सीमाओं को पूरी तरह से त्याग देता है (उत्सृज्य)।
            और वह भूतकाल की यादों, भविष्य की चिंताओं और वर्तमान की बेचैनी—इन तीनों प्रकार की चिंताओं (चिन्तात्रय) से पूरी तरह मुक्त (विवर्जित) हो जाता है।
            उस परम समाधि में वह योगी बाहर से देखने पर बिल्कुल एक मरे हुए व्यक्ति (मृतवत्) के समान अत्यंत अचल और शांत खड़ा या बैठा रहता है।
            "वह योगी निश्चित रूप से पूर्ण मुक्त (मोक्ष प्राप्त) है", इसमें मुझे रत्ती भर भी कोई संशय (शक) नहीं है।
            यहाँ 'मृतवत्' (मुर्दे के समान) का मतलब यह नहीं कि वह मर गया है; इसका मतलब है कि उसमें दुनिया के प्रति कोई भी 'रिएक्शन' (Reaction) नहीं बचा है।
            मुर्दे को आप सोने का मुकुट पहनाएं या उसे गालियां दें, उसे कोई फर्क नहीं पड़ता; यही हालत एक जीवन्मुक्त योगी की होती है।
            आम इंसान हमेशा तीनों अवस्थाओं (जागना, सोना, सपने देखना) की जेल में फँसा रहता है, पर योगी इनसे पार (तुरीय में) चला जाता है।
            चिंता हमेशा 'समय' (Time) में होती है (कल क्या होगा?); जो समय से पार चला गया, उसकी सारी चिंताएं हमेशा के लिए मर जाती हैं।
            यह कोई उदासी (Depression) वाली स्थिति नहीं है; यह तो जीवन का सबसे बड़ा उत्सव है जहाँ सारा डर खत्म हो गया है।
            उपनिषद अत्यंत दृढ़ता से गारंटी (न संशयः) देता है कि जिसने भी इस अवस्था को पा लिया, उसका मोक्ष पक्का है।
        """.trimIndent(),
        english = """
            That realized Yogi completely and flawlessly abandons (Utsrijya) the strict limitations of the three states (Avasthatraya): waking, dreaming, and deep, dreamless sleep.
            And he becomes entirely, permanently free (Vivarjita) from the three types of devastating anxieties (Chintatraya): painful memories of the past, worries of the future, and restlessness of the present.
            In that supreme Samadhi, when viewed from the outside, that Yogi stands or sits absolutely unmoving and perfectly still, exactly like a dead person (Mritavat).
            "That Yogi is undoubtedly and unconditionally fully liberated (has attained Moksha)", there is absolutely no doubt (Samshaya) in this fact whatsoever.
            Here, 'Mritavat' (like a corpse) absolutely does not mean he is dead; it profoundly means he has zero 'Reaction' left toward anything in the entire world.
            Whether you place a solid gold crown on a corpse or scream harsh insults at it, it simply doesn't care; this is the exact condition of a Jivanmukta Yogi.
            An ordinary human is perpetually trapped strictly in the prison of the three states, but the Yogi flawlessly transcends them (into Turiya).
            Anxiety always exists strictly within 'Time' (What will happen tomorrow?); for one who has transcended time, all anxieties instantly die forever.
            This is absolutely not a state of sad depression; it is the absolute greatest celebration of life where all terrifying fear has been completely annihilated.
            The Upanishad gives an extremely firm, unbreakable guarantee (Na samshayah) that whoever attains this state, his ultimate liberation is 100% certain.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 39,
        sanskrit = "उत्पन्ने तत्त्वविज्ञाने प्रारब्धं नैव मुञ्चति । तत्त्वज्ञानोदयादूर्ध्वं प्रारब्धं नैव विद्यते ॥ ३९ ॥",
        hindi = """
            (अब यहाँ से कर्म सिद्धांत और ज्ञानी के प्रारब्ध का एक बहुत बड़ा रहस्य सुलझाया जा रहा है):
            अज्ञानी लोग ऐसा मानते हैं कि "जब मनुष्य के भीतर परम तत्त्व का सच्चा ज्ञान उत्पन्न हो जाता है, तब भी उसका 'प्रारब्ध कर्म' (Past destiny) उसे नहीं छोड़ता (उसे कर्मफल भोगने ही पड़ते हैं)।"
            परंतु उपनिषद कहता है: यह बात बिल्कुल गलत है! "सच्चे तत्त्वज्ञान के उदय (जागने) के बाद, उस ज्ञानी के लिए किसी भी प्रकार का कोई प्रारब्ध कर्म (Destiny) बचता ही नहीं है (नैव विद्यते)।"
            यह वेदान्त का एक बहुत बड़ा और प्रसिद्ध विवाद (Debate) है: क्या ज्ञानी पुरुष को भी अपने पुराने पापों का फल भोगना पड़ता है?
            साधारण नियम कहता है कि तीर अगर धनुष से छूट गया (प्रारब्ध), तो वह निशाने पर लगेगा ही, चाहे आप ज्ञानी ही क्यों न बन जाएं।
            इसलिए लोग कहते हैं कि ज्ञानी को भी बीमारियां या दुख आते हैं, जो उसके पिछले जन्मों का 'प्रारब्ध' है।
            पर नादबिंदु उपनिषद एक बहुत ही क्रांतिकारी (Revolutionary) बात कह रहा है: ज्ञान होने के बाद प्रारब्ध की कोई वैल्यू (Value) नहीं रहती।
            क्यों? क्योंकि प्रारब्ध 'शरीर' और 'अहंकार' का होता है। जब ज्ञानी ने यह मान ही लिया कि "मैं शरीर हूँ ही नहीं", तो प्रारब्ध किस पर असर करेगा?
            अगर बैंक का कर्ज़दार (Ego) ही मर गया, तो बैंक (Karma) किससे वसूली करेगा?
            ज्ञान की आग इतनी भयंकर होती है कि वह केवल भविष्य के कर्मों को नहीं, बल्कि प्रारब्ध (Past) को भी राख कर देती है।
            ज्ञानी के शरीर को जो भी दुख आते हैं, वे केवल बाहर वालों को दुख लगते हैं; ज्ञानी को उनसे कोई पीड़ा नहीं होती।
        """.trimIndent(),
        english = """
            (Now a massive secret regarding the Theory of Karma and a Jnani's destiny is unraveled here):
            Ignorant people often falsely believe that "Even when the true knowledge of the Supreme Principle arises perfectly within a human, his 'Prarabdha Karma' (Past destiny) still absolutely does not leave him (he must suffer the fruits)."
            But the Upanishad boldly declares: This is completely false! "After the supreme dawn (rising) of true Knowledge, absolutely no Prarabdha Karma (Destiny) exists (Naiva Vidyate) for that realized sage whatsoever."
            This is a highly massive and famously debated topic in Vedanta: Does an enlightened sage still have to suffer the painful fruits of his past sins?
            The ordinary rule strongly states that if an arrow has already left the bow (Prarabdha), it will definitely hit the target, even if you become a wise sage.
            Therefore, people argue that even sages suffer from terrible diseases or sorrows, which is strictly their 'Prarabdha' from past births.
            But the Nadabindu Upanishad is making an exceptionally Revolutionary statement here: After true enlightenment, Prarabdha has absolutely zero value.
            Why? Because Prarabdha strictly belongs to the 'Physical Body' and the 'Ego'. When the sage has flawlessly realized "I am absolutely not this body," upon whom will the Prarabdha act?
            If the bank's debtor (Ego) is completely dead, from whom exactly will the bank (Karma) recover its heavy debt?
            The blazing fire of true Wisdom is so incredibly fierce that it burns to ashes not only future karmas, but strictly annihilates the Prarabdha (Past) as well.
            Whatever physical pains affect the sage's body appear as sorrows only to the ignorant outsiders; the sage himself feels absolutely zero agony from them.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 40,
        sanskrit = "देहादीनामसत्त्वात्तु यथैवाज्ञानतो जगे । स्वप्नदेहो यथाध्यस्तस्तथैवायं हि देहकः ॥ ४० ॥",
        hindi = """
            (ज्ञानी का प्रारब्ध क्यों नहीं होता, इसका कारण बताते हैं): क्योंकि तत्त्वज्ञान होने पर यह सिद्ध हो जाता है कि यह भौतिक देह (शरीर) आदि बिल्कुल 'असत्' (False/अवास्तविक) हैं।
            जिस प्रकार अज्ञान (नींद) के कारण मनुष्य स्वप्न (सपने) के संसार में एक 'स्वप्न-शरीर' (Dream body) धारण कर लेता है, और उसे सच मान लेता है।
            और जैसे जागने पर वह स्वप्न का शरीर पूरी तरह से झूठा (अध्यस्त/कल्पित) साबित हो जाता है।
            ठीक उसी प्रकार (तथैव), अज्ञान की नींद से जागने पर यह जाग्रत अवस्था का भौतिक शरीर भी पूरी तरह से एक झूठा सपना (अध्यस्त) ही साबित होता है।
            प्रारब्ध कर्म केवल 'शरीर' पर असर कर सकता है (उसे बीमारी या गरीबी दे सकता है), आत्मा पर नहीं।
            जब ज्ञानी पुरुष ज्ञान से जाग जाता है, तो उसे यह साफ दिखाई देता है कि यह जो शरीर साँस ले रहा है, यह तो केवल माया का एक भ्रम (Illusion) है।
            जैसे सपने में आपको कोई गोली मार दे, पर जब आप सुबह बिस्तर पर जागते हैं, तो आपको न दर्द होता है न घाव मिलता है, क्योंकि सपने का शरीर सच नहीं था।
            उसी तरह, ज्ञानी के लिए यह जाग्रत दुनिया और यह शरीर भी एक 'सपना' मात्र है।
            जब शरीर ही सच नहीं है (असत्त्वात्), तो उस झूठे शरीर का 'प्रारब्ध' सच कैसे हो सकता है?
            यह श्लोक अद्वैत वेदान्त का सबसे तगड़ा लॉजिक (Logic) है जो कर्म सिद्धांत को ज्ञान के आगे पूरी तरह से झुका देता है।
        """.trimIndent(),
        english = """
            (Explaining exactly why a Jnani has no Prarabdha): Because upon attaining true Knowledge, it is flawlessly proven that this physical body and its attributes are completely 'Asat' (False/unreal).
            Just exactly as, due to sheer ignorance (sleep), a human being assumes a 'Dream-body' (Svapnadeha) in the vivid dream world and foolishly believes it to be totally real.
            And just as upon waking up, that dream body is instantly proven to be entirely false, illusory, and merely a projection (Adhyasta).
            In the exact same way (Tathaiva), upon fully waking up from the dark sleep of ignorance, this waking physical body is also proven to be nothing but a complete, false, projected dream.
            Prarabdha karma can actively affect only the 'Physical Body' (giving it disease or poverty), absolutely never the immortal Soul.
            When the wise sage fully awakens through wisdom, he sees crystal clearly that this breathing physical body is merely an illusion of Maya.
            Just as if someone shoots you in a vivid dream, but when you wake up in your bed, you have absolutely zero pain or wound, because the dream body wasn't real.
            In the exact same manner, for the enlightened sage, this waking physical world and this fleshy body are also merely a 'Dream'.
            When the physical body itself is entirely untrue (Asattvat), how on earth can the 'Prarabdha' of that false body possibly be true?
            This magnificent verse is the absolute strongest Logic of Advaita Vedanta, which completely forces the Theory of Karma to bow down utterly before True Wisdom.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 41,
        sanskrit = "अध्यस्तस्य कुतो जन्म जन्माभावे कुतः स्थितिः । अभावे च कुतो नाशः प्रारब्धमसतः कुतः ॥ ४१ ॥",
        hindi = """
            जो शरीर केवल अज्ञान के कारण 'अध्यस्त' (एक भ्रम / Projection) है, उसका वास्तव में 'जन्म' कैसे हो सकता है? (अर्थात भ्रम का जन्म नहीं होता)।
            और जब उस शरीर का वास्तव में कोई जन्म ही नहीं हुआ है, तो उसकी इस संसार में 'स्थिति' (Existence / जीवन) कैसे हो सकती है?
            और जब उसकी कोई स्थिति (अस्तित्व) ही नहीं है, तो फिर उस शरीर का 'नाश' (मृत्यु) भी कैसे हो सकता है?
            और जो शरीर इस प्रकार तीनों कालों में पूरी तरह से 'असत्' (False / है ही नहीं) है, उस झूठे शरीर का भला 'प्रारब्ध' (Destiny) कहाँ से आ सकता है?
            यह श्लोक 'अजातवाद' (Theory of Non-creation) का सबसे बड़ा ब्रह्मास्त्र है।
            वेदान्त कहता है कि जैसे बंजर ज़मीन पर दूर से पानी (मृगतृष्णा / Mirage) दिखाई देता है, पर असल में वहाँ पानी की एक बूँद भी पैदा नहीं हुई।
            उसी तरह, हमें लगता है कि हमारा जन्म हुआ है, पर ईश्वर की नज़रों में यह शरीर कभी पैदा हुआ ही नहीं; यह केवल माया का एक 'प्रोजेक्शन' (Hologram) है।
            जब आप पैदा ही नहीं हुए, तो आप जियेंगे कैसे? और जब आप जिये ही नहीं, तो आप मरेंगे कैसे?
            और जब शरीर नाम की कोई चीज़ असल में है ही नहीं, तो उस झूठे होलोग्रैम को पिछले जन्मों का 'कर्म' या 'प्रारब्ध' कैसे लग सकता है?
            ज्ञानी पुरुष इस महान सत्य को जान लेता है, इसलिए वह प्रारब्ध के अच्छे-बुरे फलों को देखकर हँसता है, क्योंकि वह जानता है कि यह सब एक 3D मूवी (Movie) से ज्यादा कुछ नहीं है।
        """.trimIndent(),
        english = """
            For a physical body that is merely 'Adhyasta' (a false projection/illusion) due to sheer ignorance, how can it possibly have a real 'Birth'? (Meaning, an illusion is never truly born).
            And when that body was absolutely never genuinely born in reality, how can it possibly have any true 'Existence' (Sthiti / life) in this world?
            And when it has absolutely zero existence (Abhava) to begin with, how on earth can that body possibly suffer 'Destruction' (Death)?
            And for a body that is completely 'Asat' (False / totally non-existent) in all three periods of time, from where can the 'Prarabdha' (Destiny) of such a false body possibly come?
            This stunning verse is the absolute greatest, ultimate weapon of 'Ajatavada' (The Theory of Absolute Non-creation).
            Vedanta declares that just as water appears from a distance on barren land (Mirage), but in reality, not even a single drop of water was ever born there.
            Similarly, we foolishly feel that we are born, but in God's absolute vision, this body was never born at all; it is merely a highly realistic 'Projection' (Hologram) of Maya.
            When you were absolutely never born, how will you live? And when you never truly lived, how will you ever die?
            And when a thing called the physical body absolutely does not exist in truth, how can the 'Karma' or 'Prarabdha' of past lives possibly attach to a fake hologram?
            The enlightened sage perfectly realizes this monumental truth, hence he simply laughs at the good or bad fruits of Prarabdha, knowing perfectly well that it is nothing more than a realistic 3D Movie.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 42,
        sanskrit = "ज्ञानेनाज्ञानकार्ये तु समूलं नाशमागते । अयं देहः कथं तिष्ठेत् प्रारब्धं तत्र कल्प्यते ॥ ४२ ॥",
        hindi = """
            जब आत्म-ज्ञान (Wisdom) रूपी अग्नि के द्वारा वह 'अज्ञान' (Ignorance) और उस अज्ञान के सभी कार्य (यह शरीर और संसार) अपनी मूल जड़ (समूलं) के साथ पूरी तरह नाश को प्राप्त हो जाते हैं।
            तो फिर अज्ञान से बना हुआ यह भौतिक 'देह' (शरीर) आखिर कैसे सच मानकर खड़ा (तिष्ठेत्) रह सकता है?
            (और जब शरीर ही सच नहीं रहा), तो फिर केवल अज्ञानी लोगों को समझाने के लिए ही उस झूठे शरीर के साथ 'प्रारब्ध' की कोरी 'कल्पना' (कल्प्यते / Assumption) की जाती है।
            यह श्लोक गुरुओं और शास्त्रों के पढ़ाने के तरीके (Teaching methodology) का एक बहुत बड़ा सीक्रेट (Secret) खोल रहा है।
            लोग अक्सर संतों से पूछते हैं: "अगर ज्ञानी को शरीर का भान नहीं है, तो ज्ञानी को जब पत्थर लगता है तो खून क्यों निकलता है? उसे कैंसर क्यों होता है?"
            तो ज्ञानी की रक्षा करने और आम अज्ञानी लोगों के लॉजिक (Logic) को संतुष्ट करने के लिए शास्त्र कह देते हैं: "अरे, यह तो ज्ञानी का प्रारब्ध कर्म है जो कट रहा है।"
            पर उपनिषद आज सच बता रहा है: प्रारब्ध की यह कहानी (कल्पना) केवल अज्ञानी बच्चों (सामान्य लोगों) को चुप कराने के लिए गढ़ी गई है।
            सच तो यह है कि ज्ञान की आग में जब अज्ञान की जड़ (अहंकार) ही जल गई, तो शरीर रूपी पेड़ कैसे हरा रह सकता है?
            ज्ञानी के लिए न कोई देह है, न कोई बीमारी है, और न ही कोई प्रारब्ध है; यह सब केवल देखने वालों की आँखों का धोखा है।
            प्रारब्ध केवल अज्ञानियों की डिक्शनरी (Dictionary) का शब्द है, ब्रह्मज्ञानियों की नहीं।
        """.trimIndent(),
        english = """
            When, by the blazing fire of true Self-Knowledge, that 'Ignorance' and absolutely all the effects of that ignorance (this body and world) are completely and utterly destroyed along with their very roots (Samulam).
            Then how on earth can this physical 'Body' (Deha), manufactured purely out of that dead ignorance, possibly continue to stand and be accepted as real (Tishthet)?
            (And when the body itself is no longer real), then strictly only to pacify and explain things to ignorant people, the mere empty 'Assumption' (Kalpyate / imagination) of 'Prarabdha' is associated with that false body.
            This phenomenal verse exposes a massively profound Secret regarding the exact teaching methodology of Gurus and ancient scriptures.
            People often question saints: "If the sage has no body-consciousness, then why does he bleed when hit by a stone? Why does he get cancer?"
            So, simply to protect the sage and satisfy the petty, highly limited logic of ordinary ignorant people, scriptures casually say: "Oh, it is merely the sage's Prarabdha Karma burning away."
            But the Upanishad reveals the absolute truth today: this entire story (assumption) of Prarabdha is manufactured strictly just to silence ignorant children (ordinary people).
            The absolute truth is, when the very root of ignorance (Ego) is burnt in the fire of wisdom, how can the tree of the body remain green and real?
            For the realized sage, there is absolutely no body, no disease, and absolutely zero Prarabdha; all this is merely an optical illusion in the eyes of the ignorant onlookers.
            Prarabdha is a word existing exclusively in the dictionary of the ignorant, absolutely never in the dictionary of the Brahma-Jnanis.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 43,
        sanskrit = "अज्ञानजनबोधार्थं प्रारब्धं वदति श्रुतिः । क्षीयते चास्य कर्माणि तस्मिन्दृष्टे परावरे ॥ ४३ ॥",
        hindi = """
            यह श्रुति (वेद और उपनिषद) केवल और केवल 'अज्ञानी जनों को समझाने के लिए' (अज्ञान-जन-बोधार्थं) ही प्रारब्ध कर्मों की बात (वदति) करती है।
            (वास्तविक सत्य तो यह है कि) उस 'परावर' (परम श्रेष्ठ और सबसे सूक्ष्म / कारण और कार्य से परे) परब्रह्म का साक्षात् दर्शन (दृष्टे) हो जाने पर।
            उस ज्ञानी पुरुष के सभी प्रकार के कर्म (चाहे वह संचित हों, आगामी हों या प्रारब्ध हों) पूरी तरह से क्षीण (नष्ट / भस्म) हो जाते हैं।
            यह मुण्डक उपनिषद (2.2.8) के एक बहुत ही प्रसिद्ध श्लोक का सीधा संदर्भ (Reference) है।
            वेद माता की तरह बहुत दयालु हैं; वे जानती हैं कि अगर आम आदमी को अचानक कह दिया जाए कि "कर्म कुछ नहीं होते", तो दुनिया में अराजकता (Chaos) और पाप फैल जाएगा।
            इसलिए वेद आम इंसान को डराने और सही रास्ते पर रखने के लिए प्रारब्ध और कर्मों के फल की लंबी-चौड़ी थ्योरी (Theory) पढ़ाते हैं।
            पर जब वही इंसान साधना करके क्लास में टॉप (Top) कर लेता है और सत्य को देख (दृष्टे) लेता है, तो वेद उसे असली सीक्रेट बता देते हैं।
            सीक्रेट यह है कि भगवान (परावर) के दर्शन होते ही सारे कर्मों का खाता (Account) हमेशा के लिए डिलीट (Delete) कर दिया जाता है।
            ज्ञानी के लिए न पीछे का कोई पाप बचता है (संचित), न आगे का कोई फल बनता है (आगामी), और न ही वर्तमान का प्रारब्ध उसे रुला सकता है।
            ज्ञान की एक लौ करोड़ों जन्मों के कर्मों के कूड़े के पहाड़ को एक सेकंड में जलाकर परम आज़ादी दे देती है।
        """.trimIndent(),
        english = """
            This Shruti (the sacred Vedas and Upanishads) actively speaks (Vadati) about Prarabdha Karma solely and exclusively 'to instruct and pacify the ignorant people' (Ajnana-jana-bodhartham).
            (The absolute reality is that) immediately upon directly seeing and realizing (Drishte) that 'Paravara' (the Supreme, highest, and subtlest Brahman completely beyond cause and effect).
            Absolutely all types of karmas of that realized sage (whether accumulated Sanchita, future Agami, or present Prarabdha) are completely and permanently destroyed and reduced to ashes (Kshiyate).
            This is a highly direct reference to a very famous and monumental verse from the Mundaka Upanishad (2.2.8).
            The Vedas are exceptionally compassionate like a loving mother; they know perfectly well that if common men are suddenly told "Karmas are unreal," terrifying chaos and sin will spread globally.
            Therefore, strictly to discipline the common man and keep him on the righteous path, the Vedas intensely teach the long, strict theory of Prarabdha and karmic fruits.
            But when that exact same human performs intense Sadhana, tops the spiritual class, and directly 'sees' (Drishte) the Truth, the Vedas reveal the ultimate Secret to him.
            The grand secret is that the exact moment God (Paravara) is realized, the entire heavy account of all karmas is permanently and irrevocably Deleted.
            For the wise sage, absolutely no past sins remain (Sanchita), no future fruits are generated (Agami), and no present Prarabdha can ever make him cry.
            A single, tiny spark of Wisdom effortlessly burns the massive garbage mountain of millions of lifetimes of karmas in one second, granting absolute, eternal freedom.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 44,
        sanskrit = "तस्मिन्दृष्टे परावरे... यत्रैतदद्वयं ब्रह्म नेह नानास्ति किंचन ॥ ४४ ॥",
        hindi = """
            उस परम श्रेष्ठ (परावर) परब्रह्म का साक्षात् दर्शन हो जाने पर, ज्ञानी पुरुष यह स्पष्ट रूप से देख लेता है कि:
            "जहाँ केवल यह एक अद्वितीय (अद्वयं / जिसके जैसा दूसरा कोई नहीं) परब्रह्म ही पूर्ण रूप से व्याप्त है।
            वहाँ इस संसार में 'नाना' (अनेकता, भेद, या द्वैत) नाम की कोई भी चीज़ रत्ती भर भी (किंचन) बिल्कुल नहीं है (नेह नानास्ति किंचन)।"
            यह उपनिषदों की सबसे बड़ी महा-घोषणा है: ब्रह्मांड में अनेकता (Multiplicity) एक बहुत बड़ा भ्रम है।
            हम अपनी अंधी आँखों से करोड़ों अलग-अलग इंसान, जानवर, पेड़ और ग्रह देखते हैं, और सोचते हैं कि सब अलग हैं।
            पर जिस योगी ने अपने भीतर के 'नाद' (Sound) के माध्यम से उस सत्य की गहराई में गोता लगा लिया है, उसकी दृष्टि बदल जाती है।
            उसे दिखाई देता है कि जो मिट्टी घड़े में है, वही मिट्टी दीये में है; नाम और आकार (Name and Form) अलग हैं, पर तत्व केवल एक है।
            जब सब कुछ केवल एक ही भगवान (ब्रह्म) है, तो कौन किसको मारेगा? कौन किससे नफरत करेगा? और कौन किससे ईर्ष्या करेगा?
            'नेह नानास्ति किंचन'—यहाँ अनेकता बिल्कुल नहीं है; यह एक ऐसा ब्रह्मास्त्र है जो इंसान के सारे डरों और नफरतों की जड़ काट देता है।
            अद्वैत का यह अनुभव ही मानव चेतना का सबसे ऊँचा और अंतिम शिखर (Ultimate peak) है।
        """.trimIndent(),
        english = """
            Upon attaining the direct, profound vision of that supremely highest (Paravara) Brahman, the enlightened sage clearly and flawlessly sees that:
            "Where only this One, non-dual (Advayam / having no second or equal) Supreme Brahman pervades absolutely completely.
            There, in this entire world, there is absolutely not even the slightest trace (Kinchan) of anything called 'Nana' (Multiplicity, difference, or duality) whatsoever (Neha nanasti kinchana)."
            This is undeniably the greatest, most colossal grand declaration of the Upanishads: Multiplicity in the cosmos is a massive, blinding illusion.
            With our blind physical eyes, we see millions of different humans, animals, trees, and planets, and foolishly believe they are all completely separate.
            But the Yogi who has dived into the infinite depths of Truth through the inner 'Nada' (Sound), has his entire vision radically transformed.
            He sees crystal clearly that the exact same clay inside a pot is the clay inside a lamp; the Names and Forms are different, but the Essence is strictly One.
            When absolutely everything is merely one single God (Brahman), who will kill whom? Who will hate whom? And who will be jealous of whom?
            'Neha nanasti kinchana'—There is absolutely no multiplicity here; this is the ultimate cosmic weapon that severs the very root of all human fears and hatreds.
            This profound, living experience of Advaita (Non-duality) is the absolute highest, ultimate peak of human consciousness.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 45,
        sanskrit = "यथाकाशो घटे नष्टे महाकाशो भवेत्स्वयम् । तथा जीवो ह्युपाधौ तु नष्टे ब्रह्मैव केवलम् ॥ ४५ ॥",
        hindi = """
            जिस प्रकार एक मिट्टी के घड़े (घटे) के पूरी तरह से टूट कर नष्ट हो जाने पर।
            उस घड़े के अंदर बंद 'घटाकाश' (घड़े का आकाश) स्वतः (अपने-आप) उस असीम 'महाकाश' (विशाल आकाश) में मिलकर एक हो जाता है।
            ठीक उसी प्रकार, जब ज्ञान के द्वारा अज्ञान की 'उपाधि' (अर्थात यह शरीर और अहंकार का बर्तन) पूरी तरह से नष्ट हो जाती है।
            तो यह 'जीव' (जीवात्मा) भी अपने-आप पूर्ण रूप से केवल 'ब्रह्म' (परमात्मा) ही हो जाता है।
            यह श्लोक अद्वैत दर्शन का सबसे प्यारा और आसानी से समझ में आने वाला उदाहरण (Example) है।
            एक घड़े के अंदर जो खाली जगह (Space) है, और घड़े के बाहर जो पूरा आसमान है, क्या वे दोनों अलग-अलग हैं? बिल्कुल नहीं!
            केवल मिट्टी की उस दीवार (घड़े) ने एक झूठा बॉर्डर (Boundary) बना रखा है जिससे हमें लगता है कि अंदर का आकाश छोटा है।
            जैसे ही किसी ने हथौड़ा मारकर घड़े को तोड़ा, अंदर का आकाश तुरंत बाहर के महाकाश में मिल जाता है; उसे कहीं सफर करके नहीं जाना पड़ता।
            इसी तरह, हमारा 'अहंकार' और 'शरीर' वह मिट्टी का घड़ा है जिसने हमारी असीम आत्मा (जीव) को छोटा सा इंसान बना रखा है।
            नाद योग और ज्ञान के हथौड़े से जब यह अहंकार टूटता है, तो जीव को पता चलता है कि वह तो हमेशा से साक्षात् भगवान (ब्रह्म) ही था!
        """.trimIndent(),
        english = """
            Exactly just as when a small earthen pot (Ghate) is completely broken and entirely destroyed.
            The 'Ghatakasha' (the space trapped inside the pot) automatically and effortlessly merges and becomes completely one with the boundless 'Mahakasha' (the vast, infinite sky).
            In the precise same manner, when the 'Upadhi' (the limiting condition/the pot of the physical body and Ego) is completely destroyed by the hammer of Wisdom.
            This 'Jiva' (the individual soul) also automatically and flawlessly becomes absolutely nothing but pure 'Brahman' (the Supreme Lord) alone.
            This magnificent verse is the absolute most beloved and easily comprehensible, flawless example in Advaita philosophy.
            The empty space enclosed tightly inside a pot, and the infinite, vast sky stretching outside the pot—are they genuinely two different things? Absolutely not!
            Only that fragile wall of clay (the pot) has actively created a false, illusory boundary making us foolishly think the space inside is petty and small.
            The exact moment someone powerfully smashes the pot with a hammer, the inner space instantly merges with the infinite space; it absolutely doesn't have to travel anywhere.
            Similarly, our toxic 'Ego' and physical 'Body' are that exact clay pot that has severely restricted our infinite Soul (Jiva) into a tiny, helpless human being.
            When this ego shatters completely through the heavy hammer of Nada Yoga and wisdom, the Jiva joyously realizes that it was indeed always God (Brahman) Himself!
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 46,
        sanskrit = "न निरोधो न चोत्पत्तिर्न बद्धो न च साधकः । न मुमुक्षुर्न वै मुक्त इत्येषा परमार्थता ॥ ४६ ॥",
        hindi = """
            (जब वह घड़ा टूट जाता है और जीव ब्रह्म हो जाता है, तब उसे यह परम सत्य दिखाई देता है):
            वास्तविक और परमार्थ (Ultimate) सत्य की दृष्टि से देखा जाए तो—न तो कभी इस ब्रह्मांड का कोई 'निरोध' (प्रलय/विनाश) होता है।
            और न ही कभी इस संसार में किसी नई चीज़ की 'उत्पत्ति' (जन्म/Creation) होती है।
            न तो यहाँ अज्ञान की जंजीरों में 'बँधा' हुआ कोई जीव है, और न ही मोक्ष पाने के लिए साधना करने वाला कोई 'साधक' है।
            न तो यहाँ मुक्ति की तीव्र इच्छा रखने वाला कोई 'मुमुक्षु' है, और न ही कोई बंधनों से आज़ाद हुआ 'मुक्त' पुरुष है।
            यही एकमात्र परम और अंतिम सत्य (परमार्थता) है।
            यह श्लोक भारतीय दर्शन के 'अजातवाद' (Theory of Non-creation) का सबसे बड़ा शिखर (Peak) है।
            यह हमारी सामान्य बुद्धि को पूरी तरह से हिला कर रख देता है। हम सोचते हैं कि हम बँधे हैं और हमें आज़ाद होना है।
            पर ईश्वर के दृष्टिकोण (God's perspective) से जब आप देखते हैं, तो केवल एक अनंत, अचल और शांत परब्रह्म ही मौजूद है।
            वहाँ समय (Time) नहीं है, इसलिए न कुछ बन रहा है और न कुछ बिगड़ रहा है।
            जब बीमारी ही झूठी (Illusion) थी, तो फिर मरीज कैसा, इलाज कैसा, डॉक्टर कैसा और ठीक होना (मोक्ष) कैसा? सब कुछ केवल एक सपना था।
        """.trimIndent(),
        english = """
            (When that pot shatters and the soul becomes Brahman, he clearly sees this Ultimate Truth):
            When viewed strictly from the perspective of the absolute and Ultimate (Paramartha) Truth—there is absolutely no 'Nirodha' (dissolution/destruction) of this cosmos whatsoever.
            Nor is there ever any fresh 'Utpatti' (creation/birth) of anything new in this universe at any time.
            There is absolutely no soul 'Bound' in the terrifying chains of ignorance, nor is there any 'Seeker' (Sadhaka) practicing austerities to attain Moksha.
            There is absolutely no 'Mumukshu' intensely desiring supreme liberation, nor is there any 'Liberated' (Mukta) man freed from bondage.
            This, and strictly this alone, is the absolute, ultimate, and final Truth (Paramarthata).
            This staggering verse is the absolute highest, unmatched peak of 'Ajatavada' (The Theory of Non-creation) in Indian philosophy.
            It completely and utterly shakes our ordinary, limited human intellect to its very core. We falsely think we are bound and fiercely need to become free.
            But when you look flawlessly from God's absolute perspective, there exists exclusively one infinite, unmoving, and perfectly tranquil Brahman.
            There is absolutely zero Time there, hence absolutely nothing is ever being created and nothing is ever being destroyed.
            When the terrible disease (ignorance) itself was completely fake (an illusion), then what patient, what treatment, what doctor, and what recovery (Moksha)? Everything was merely a dream.
        """.trimIndent()
    ),
    NadabinduShloka(
        id = 47,
        sanskrit = "इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ ४७ ॥",
        hindi = """
            (उपसंहार): इस प्रकार यह अत्यंत रहस्यमयी और महान 'नादबिंदु उपनिषद' का दिव्य ज्ञान यहाँ पूर्ण रूप से संपन्न (इत्युपनिषत्) होता है।
            यह उपनिषद कोई साधारण किताब नहीं है; यह एक ऐसा अत्यंत शक्तिशाली 'नक्शा' (Map) है जो इंसान को आवाज़ के रास्ते परम सन्नाटे (ईश्वर) तक ले जाता है।
            इसने हमें ॐकार रूपी पक्षी की 12 सूक्ष्म मात्राओं का वह गहरा विज्ञान सिखाया जिसे बड़े-बड़े ऋषि भी मुश्किल से समझ पाते हैं।
            इसने हमें बताया कि किस प्रकार नाद (Sound) का उपयोग करके हम अपने पागल हाथी जैसे मन को आसानी से वश में कर सकते हैं।
            और अंत में, इसने यह सिद्ध कर दिया कि जीव और ब्रह्म वास्तव में दो नहीं, बल्कि एक ही आकाश (सत्य) हैं।
            ॐ शांतिः शांतिः शांतिः।
            (भगवान करे कि हमारे भौतिक शरीर में पूर्ण शांति हो)।
            (हमारे चंचल मन और विचारों में असीम शांति स्थापित हो)।
            (और हमारी आत्मा अंततः उस परम ब्रह्मानंद की अखंड शांति में हमेशा के लिए विलीन हो जाए)।
            नाद योग का यह परम पवित्र ज्ञान मानव जाति के लिए सबसे बड़ा वरदान है।
        """.trimIndent(),
        english = """
            (Conclusion): Thus, the highly divine, exceptionally mystical, and magnificently great wisdom of the 'Nadabindu Upanishad' is completely and perfectly concluded here (Ityupanishat).
            This Upanishad is absolutely no ordinary book; it is an incredibly powerful 'Map' that guides a human straight through the path of sound perfectly into the Supreme Silence (God).
            It has flawlessly taught us the profoundly deep science of the 12 subtle Matras of the OM-bird, which even great ancient sages struggle to comprehend.
            It has clearly shown us exactly how, by skillfully utilizing the Nada (Sound), we can effortlessly and permanently tame our violent, mad, elephant-like mind.
            And ultimately, it has irrefutably proven that the individual soul and Brahman are absolutely not two, but strictly the exact same infinite Space (Truth).
            OM Peace, Peace, Peace.
            (May there be absolute, perfect peace firmly established in our gross physical body).
            (May there be boundless, supreme peace continuously flowing in our highly restless mind and chaotic thoughts).
            (And may our pure Soul finally and permanently dissolve flawlessly into the unbroken, eternal peace of Supreme Brahman).
            This supremely sacred wisdom of Nada Yoga is undeniably the absolute greatest blessing for all of humanity.
        """.trimIndent()
    )
)