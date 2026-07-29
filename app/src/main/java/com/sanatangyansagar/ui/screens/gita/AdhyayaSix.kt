package com.sanatangyansagar.ui.screens.gita

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AdhyayaSix() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaSixShlokas.indexOfFirst { it.id == shlokaNum }
            if (targetIndex != -1) {
                coroutineScope.launch {
                    listState.animateScrollToItem(targetIndex)
                }
                keyboardController?.hide()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (e.g., 5)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { performSearch() }
            ),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump to Shloka")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(adhyayaSixShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaSixShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            श्रीभगवानुवाच |
            अनाश्रितः कर्मफलं कार्यं कर्म करोति यः |
            स संन्यासी च योगी च न निरग्निर्न चाक्रियः || १ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: जो मनुष्य अपने कर्मों के फलों (रिज़ल्ट्स) पर आश्रित (निर्भर) न होकर, अपने करने योग्य कर्तव्य-कर्मों को पूरी निष्ठा से करता है...
            वही वास्तव में सच्चा 'संन्यासी' भी है और वही सच्चा 'योगी' भी है। केवल अग्नि (यज्ञ) को त्याग देने वाला या शारीरिक क्रियाओं (काम) को छोड़ देने वाला संन्यासी नहीं होता।
            छठे अध्याय की शुरुआत में भगवान श्रीकृष्ण समाज में फैले संन्यास के झूठे दिखावे पर सबसे बड़ी चोट करते हैं।
            प्राचीन काल में लोग संन्यासी बनने के लिए अपने घर की 'अग्नि' (रसोई और यज्ञ की आग) बुझा देते थे और काम करना ('अक्रियः') छोड़ देते थे। उन्हें लगता था कि कपड़े बदलने और काम छोड़ने से वे भगवान को पा लेंगे।
            लेकिन श्रीकृष्ण एक 'क्रांतिकारी परिभाषा' (Revolutionary Definition) देते हैं। संन्यास किसी ड्रेस-कोड (Dress-code) या काम से भागने का नाम नहीं है।
            सच्चा संन्यासी वह है जो अपनी ड्यूटी ('कार्यं कर्म') पूरी मेहनत से करता है, लेकिन वह उस काम के बदले मिलने वाले 'फल' (प्रॉफिट, सैलरी, नाम) के आसरे ('अनाश्रितः') नहीं जीता।
            उसका मानसिक सॉफ्टवेयर (Software) कहता है: "मेरा काम केवल ड्यूटी करना है, फल भगवान का है।" जो व्यक्ति इस मनोविज्ञान (Psychology) के साथ जीवन जीता है, वही असली संन्यासी और परफेक्ट योगी है।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead elegantly declared: One who is completely unattached to the fruits of his work (Anashritah karma-phalam) and who works simply as a matter of duty (Karyam karma)...
            is the true renunciate (Sannyasi) and the true mystic (Yogi), and absolutely not he who merely lights no fire (Niragnir) or performs no physical work (Akriyah).
            At the magnificent dawn of the Sixth Chapter, Lord Sri Krishna delivers a devastating, surgical strike against the false, hypocritical show of renunciation prevalent in society.
            In ancient times, ignorant people believed that to become a 'Sannyasi', one must physically extinguish their household 'Fire' (abandoning rituals/cooking) and become totally physically inactive ('Akriyah'). They foolishly thought changing their clothes and abandoning their jobs made them holy.
            But Sri Krishna establishes a highly 'Revolutionary Definition'. True renunciation is absolutely not a physical dress code or cowardly escapism from duty.
            The authentic Sannyasi is that elite master who relentlessly executes his prescribed duties ('Karyam karma'), but absolutely refuses to take shelter of or depend upon ('Anashritah') the material fruits (profits, fame, salary) of that work.
            His internal operating system runs a simple code: "My sole jurisdiction is flawless action; the results belong exclusively to God." A human who operates with this exact psychology is the ultimate Sannyasi and the perfect Yogi.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            यं संन्यासमिति प्राहुर्योगं तं विद्धि पाण्डव |
            न ह्यसंन्यस्तसङ्कल्पो योगी भवति कश्चन || २ ||
        """.trimIndent(),
        hindi = """
            हे पाण्डव (अर्जुन)! ज्ञानी लोग जिसे 'संन्यास' कहते हैं, तुम उसी को 'योग' (कर्मयोग) जानो।
            क्योंकि अपने स्वार्थी संकल्पों (इच्छाओं और कामनाओं) का संन्यास (त्याग) किए बिना, कोई भी मनुष्य कभी सच्चा योगी नहीं बन सकता।
            यह श्लोक 'संन्यास' और 'योग' के बीच के कंफ्यूजन को हमेशा के लिए मिटा देता है।
            साधारण लोग सोचते हैं कि संन्यासी (जो सब कुछ छोड़ देता है) और योगी (जो ईश्वर से जुड़ने के लिए कर्म करता है) दो अलग-अलग रास्तों पर हैं।
            लेकिन भगवान कहते हैं कि ये दोनों शब्द अंदर से बिल्कुल एक (Identical) हैं। क्यों?
            क्योंकि जब तक इंसान अपने 'संकल्प' (Selfish Motives / 'मुझे यह चाहिए' वाली इच्छा) को नहीं छोड़ता ('असंन्यस्तसङ्कल्पो'), तब तक वह न तो संन्यासी बन सकता है और न ही योगी।
            संन्यास का असली अर्थ घर छोड़ना नहीं, बल्कि 'इच्छाओं' को छोड़ना है। और योग का असली अर्थ ध्यान लगाना नहीं, बल्कि स्वार्थ को छोड़कर 'ईश्वर से जुड़ना' है।
            जब इंसान अपने 'मैं और मेरा' के संकल्प को छोड़ देता है, तो वह घर बैठे-बैठे ही महान संन्यासी और महान योगी दोनों बन जाता है।
        """.trimIndent(),
        english = """
            O son of Pandu (Arjuna)! What the great learned scholars call renunciation (Sannyasa), you should know to be exactly the same as Yoga (linking with the Supreme).
            Because absolutely no one can ever become a true Yogi unless he completely renounces his selfish desires and personal motives for sense gratification (Asannyasta-sankalpo).
            This spectacular verse permanently bridges the illusionary gap and confusion between the concepts of 'Sannyasa' and 'Yoga'.
            Ignorant masses falsely assume that a Sannyasi (who abandons the world) and a Yogi (who actively seeks union with God) are walking two completely contradictory paths.
            But the Lord declares that psychologically and spiritually, these two words are 100% Identical. Why?
            Because unless a human being violently forcefully renounces his 'Sankalpa' (his highly toxic, selfish motives and the constant mental chatter of "I want this, I need that"), he can absolutely never become a true Yogi or a Sannyasi.
            True renunciation is absolutely not abandoning your house; it is abandoning your 'Selfish Desires'. And true Yoga is not just sitting cross-legged; it is connecting with God by dropping your ego.
            When a person successfully drops the toxic virus of 'I and Mine', he simultaneously becomes an elite Sannyasi and a grandmaster Yogi right inside his own living room.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            आरुरुक्षोर्मुनेर्योगं कर्म कारणमुच्यते |
            योगारूढस्य तस्यैव शमः कारणमुच्यते || ३ ||
        """.trimIndent(),
        hindi = """
            अष्टांग योग (ध्यान योग) के शिखर पर चढ़ने की इच्छा रखने वाले (आरुरुक्षोः) नए मुनि (साधक) के लिए निष्काम 'कर्म' करना ही इस योग में पहुँचने का कारण (सीढ़ी) कहा जाता है।
            परंतु जब वही साधक योग के सर्वोच्च शिखर पर पहुँच जाता है (योगारूढस्य), तब उसके लिए सभी सांसारिक कर्मों का शांत हो जाना (शमः / पूर्ण शांति) ही कारण कहा जाता है।
            भगवान श्रीकृष्ण यहाँ आध्यात्मिक यात्रा (Spiritual Journey) के दो अलग-अलग लेवल्स (Levels) या स्टेजेस (Stages) का वर्णन कर रहे हैं: 'बिगिनर' (Beginner) और 'एडवांस' (Advanced)।
            १. बिगिनर (आरुरुक्षु): जो इंसान अभी योग के रास्ते पर नया है, उसका मन बहुत चंचल और अशुद्ध होता है। अगर उसे सीधा ध्यान (Meditation) में बिठा दिया जाए, तो वह सो जाएगा या दुनिया के बारे में सोचेगा। इसलिए उसके लिए 'कर्म' (एक्टिव ड्यूटी) करना ज़रूरी है, ताकि समाज की सेवा करके उसका मन शुद्ध हो सके।
            २. एडवांस योगी (योगारूढ): जब वह इंसान सालों तक निष्काम कर्म करके पूरी तरह से पवित्र हो जाता है और योग के शिखर पर पहुँच जाता है, तब उसके लिए बाहरी भाग-दौड़ करना ज़रूरी नहीं रहता।
            तब उसके लिए 'शमः' (पूर्ण शांति / मन को सब ओर से समेट कर गहरे ध्यान में डूब जाना) ही उसकी आगे की यात्रा का साधन बन जाता है।
            अर्थात्, कर्मयोग वह सीढ़ी है जो आपको ध्यान (Dhyana) की छत तक ले जाती है; एक बार छत पर पहुँच गए, तो सीढ़ी (बाहरी कर्म) छूट जाती है।
        """.trimIndent(),
        english = """
            For the neophyte sage who has just begun and wishes to climb the supreme heights of the eightfold yoga system (Arurukshoh), active selfless work (Karma) is said to be the means.
            But for that exact same sage who has successfully attained the ultimate heights of yoga (Yogarudhasya), the complete cessation of all material activities and absolute mental tranquility (Shamah) is said to be the means.
            Lord Sri Krishna is brilliantly categorizing the spiritual journey into two highly distinct, evolutionary phases: The 'Beginner' phase and the 'Ultra-Advanced' phase.
            1. The Beginner (Arurukshu): A novice who is just starting on the spiritual path has a highly chaotic, wildly impure mind. If you force him to sit silently in meditation, he will either fall asleep or constantly daydream about money and sex. Therefore, for him, 'Karma' (Intense, active, selfless duty) is strictly prescribed as the mandatory 'ladder' to aggressively scrub his mind clean.
            2. The Advanced Master (Yogarudha): Once that practitioner executes years of flawless selfless action and successfully reaches the supreme summit of Yoga, running around performing external physical duties is no longer required.
            At that staggering altitude, 'Shamah' (Absolute silence, complete cessation of material activities, and deep, unbroken meditative trance) becomes his primary mode of operation.
            Meaning: Karma Yoga is the essential staircase that elevates you to the roof of deep Meditation (Dhyana); once you reach the roof, you naturally leave the staircase behind.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            यदा हि नेन्द्रियार्थेषु न कर्मस्वनुषज्जते |
            सर्वसङ्कल्पसंन्यासी योगारूढस्तदोच्यते || ४ ||
        """.trimIndent(),
        hindi = """
            जिस काल (समय) में मनुष्य न तो इन्द्रियों के भोगों (विषयों) में आसक्त होता है (नेन्द्रियार्थेषु), और न ही भौतिक कर्मों में आसक्त होता है (न कर्मसु अनुषज्जते)...
            और जब वह अपनी सारी भौतिक इच्छाओं और संकल्पों का पूरी तरह त्याग (सर्वसङ्कल्पसंन्यासी) कर देता है, तब उस महापुरुष को 'योगारूढ' (योग के सर्वोच्च शिखर पर पहुँचा हुआ) कहा जाता है।
            यह श्लोक 'योगारूढ' (एक परफेक्ट एडवांस्ड योगी / Perfect Advanced Yogi) की बिल्कुल स्पष्ट परिभाषा (Definition) देता है।
            हम कैसे पहचानें कि कोई इंसान अध्यात्म के टॉप लेवल (Top Level) पर पहुँच गया है? भगवान उसके तीन प्रमुख 'चेक-मार्क' (Check-marks) बताते हैं:
            १. इन्द्रियों के विषयों में आसक्ति नहीं: उसे अच्छे खाने, महंगे कपड़े या सुख-सुविधाओं की कोई लालसा (Craving) नहीं होती।
            २. कर्मों में आसक्ति नहीं: वह काम तो करता है, लेकिन उस काम के रिज़ल्ट (सक्सेस, पैसा, अवार्ड) से उसे कोई अटैचमेंट (Attachment) नहीं होता।
            ३. 'सर्वसङ्कल्पसंन्यासी' (सबसे महत्वपूर्ण): 'संकल्प' का मतलब है भविष्य के लिए भौतिक प्लानिंग करना ("मैं यह करूँगा तो मुझे वह मिलेगा")। जो इंसान अपने दिमाग से इस 'स्वार्थी प्लानिंग' को पूरी तरह डिलीट (Delete) कर देता है, वही सच्चा संन्यासी है।
            जब किसी इंसान का माइंडसेट (Mindset) इन तीन शर्तों को पूरा कर लेता है, तो भगवान उसे ऑफिशियली 'योगारूढ' (मास्टर योगी) घोषित कर देते हैं।
        """.trimIndent(),
        english = """
            When a human being is absolutely no longer attached to the objects of sense gratification (Nendriyartheshu), nor is he attached to the fruitive results of his material activities (Na karmasv anushajjate)...
            and when he has violently and completely renounced all selfish, mental concoctions and material desires (Sarva-sankalpa-sannyasi), he is officially declared to be elevated to the highest summit of yoga (Yogarudhas).
            This phenomenal verse provides the absolute, clinical definition and the exact psychological profile of a 'Yogarudha' (A perfected, Ultra-Advanced Yogi).
            How do we accurately identify if a human has reached the absolute Top Level of spiritual perfection? The Lord lays down three brutal 'Check-marks':
            1. Zero attachment to sense objects: He possesses absolutely no toxic cravings or addictions for gourmet food, luxury properties, or physical pleasures.
            2. Zero attachment to actions: He operates flawlessly, but he has absolutely no psychological dependency or attachment to the rewards (success, money, fame) of his actions.
            3. 'Sarva-sankalpa-sannyasi' (The Ultimate Key): 'Sankalpa' means aggressive material planning ("If I manipulate this, I will gain that profit in the future"). The human who completely deletes this 'selfish blueprinting' from his brain's hard drive is the true renunciate.
            When a practitioner's mindset flawlessly satisfies these three extremely severe conditions, the Supreme Lord officially crowns him as 'Yogarudha' (The Grandmaster of Yoga).
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            उद्धरेदात्मनात्मानं नात्मानमवसादयेत् |
            आत्मैव ह्यात्मनो बन्धुरात्मैव रिपुरात्मनः || ५ ||
        """.trimIndent(),
        hindi = """
            मनुष्य को चाहिए कि वह अपने मन (आत्मा) के द्वारा अपना स्वयं का उद्धार करे (उद्धरेत्), और अपने आपको कभी नीचे न गिराए (अवसादयेत्)।
            क्योंकि यह मन (आत्मा) ही मनुष्य का अपना सबसे बड़ा 'मित्र' (बन्धु) है, और यह मन ही मनुष्य का सबसे बड़ा 'शत्रु' (रिपु) है।
            यह भगवद्गीता के सबसे महान, सशक्त और 'सेल्फ-हेल्प' (Self-Help) से जुड़े श्लोकों में से एक है। यह श्लोक इंसान को उसकी 'जिम्मेदारी' (Responsibility) का अहसास कराता है।
            अक्सर इंसान अपनी नाकामियों के लिए भगवान को, किस्मत को, या समाज को दोष देता है। लेकिन भगवान श्रीकृष्ण कहते हैं, "तुम्हारा उद्धार कोई दूसरा नहीं करेगा, तुम्हें खुद अपने मन की शक्ति से खुद को ऊपर उठाना होगा।"
            तुम्हारा असली दोस्त कौन है? क्या बाहर के लोग तुम्हारे दोस्त हैं? नहीं! अगर तुम्हारा 'मन' तुम्हारे कंट्रोल में है, तो वह मन दुनिया का सबसे वफादार और ताकतवर 'दोस्त' (Friend) है, जो तुम्हें स्वर्ग या मोक्ष तक ले जाएगा।
            और तुम्हारा असली दुश्मन कौन है? अगर तुम्हारा 'मन' तुम्हारे कंट्रोल में नहीं है (वासना, लालच और आलस्य से भरा है), तो तुम्हें बर्बाद करने के लिए किसी बाहरी दुश्मन की जरूरत नहीं है। तुम्हारा अपना ही मन तुम्हें नर्क के सबसे गहरे गड्ढे में गिरा देगा (शत्रु/Enemy)।
            यह श्लोक साबित करता है कि इंसान अपनी किस्मत का खुद निर्माता (Creator) है; सारी शक्ति हमारे अपने ही मन (Mind) के भीतर मौजूद है।
        """.trimIndent(),
        english = """
            A man must actively and forcefully elevate and deliver himself by the power of his own mind, and not degrade or ruin himself (Navasadayet).
            For the mind is undoubtedly the absolute best friend of the conditioned soul (Bandhur), and this very same mind is exactly his worst, most terrifying enemy (Ripur).
            This is universally regarded as one of the most powerful, empowering, and ultimate 'Self-Help' verses in the entire Bhagavad Gita. It places the absolute burden of 'Responsibility' squarely on the human's own shoulders.
            Ignorant humans constantly play the victim card, pathetically blaming God, society, or bad luck for their failures. But Lord Sri Krishna aggressively intervenes: "Absolutely no one is coming to save you; you must brutally pull yourself out of this hell using the sheer horsepower of your own mind."
            Who is your actual best friend? Are external people your friends? No! If your 'Mind' is successfully trained and strictly under your control, it acts as the most fiercely loyal, titanium-grade 'Best Friend' in the universe, effortlessly elevating you to supreme liberation.
            And who is your deadliest enemy? If your 'Mind' is untamed, wild, and heavily addicted to toxic lust, laziness, and greed, you absolutely do not need an external rival to destroy you. Your very own mind will violently drag you down and crush you in the deepest abyss of hell (Enemy).
            This spectacular verse proves that a human being is the absolute, undisputed Creator of his own destiny; the ultimate superpower resides entirely within the human Mind.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            बन्धुरात्मात्मनस्तस्य येनात्मैवात्मना जितः |
            अनात्मनस्तु शत्रुत्वे वर्तेतात्मैव शत्रुवत् || ६ ||
        """.trimIndent(),
        hindi = """
            जिस मनुष्य ने अपनी आत्मा (स्वयं की इच्छा शक्ति) के द्वारा अपने मन और इन्द्रियों को पूरी तरह जीत लिया है (वश में कर लिया है), उस मनुष्य के लिए उसका मन ही उसका सबसे बड़ा 'मित्र' (बंधु) है।
            परंतु जो मनुष्य अपने मन और इन्द्रियों को नहीं जीत पाया है (अनात्मनः), ऐसे व्यक्ति के लिए उसका अपना ही मन एक कट्टर 'शत्रु' (दुश्मन) के समान उसके खिलाफ काम करता है।
            पिछले श्लोक में भगवान ने बताया था कि मन दोस्त भी है और दुश्मन भी। अब इस श्लोक में वे उसका 'फॉर्मूला' (Formula) बता रहे हैं कि मन कब दोस्त बनता है और कब दुश्मन।
            कल्पना कीजिए कि मन एक बेहद शक्तिशाली लेकिन जंगली घोड़ा (Wild Horse) है।
            अगर आप (आत्मा/बुद्धि) उस घोड़े को कड़ी ट्रेनिंग देकर उस पर लगाम कस लेते हैं (जितात्मा), तो वह घोड़ा आपकी सबसे बड़ी ताकत बन जाता है। वह आपको जीवन की हर जंग जिता सकता है (यह मन का 'मित्र' रूप है)।
            लेकिन अगर आप उस घोड़े को खुला छोड़ देते हैं, तो वह आपको ही कुचल देगा और खाई में गिरा देगा। जो इंसान अपनी जीभ के स्वाद, अपनी कामवासना और अपने गुस्से को रोक नहीं पाता, उसका अपना मन ही उसके शरीर को बीमारियों और उसके जीवन को बर्बादी की ओर ले जाता है (यह मन का 'शत्रु' रूप है)।
            दुनिया का सबसे बड़ा युद्ध बाहर नहीं, बल्कि इंसान के अपने ही दिमाग के भीतर चल रहा है। 'मन को जीतना' ही दुनिया की सबसे बड़ी विजय है।
        """.trimIndent(),
        english = """
            For him who has successfully conquered and fully mastered his mind by his intelligence (Jitah), the mind is undeniably his absolute best friend (Bandhur).
            But for one who has utterly failed to conquer his mind and senses (Anatmanah), his very own mind operates violently against him, acting exactly like his most bitter, hostile enemy (Shatruvat).
            In the previous verse, the Lord declared the mind as both friend and foe. In this verse, He provides the exact, clinical 'Formula' that determines whether it becomes a friend or a terrifying enemy.
            Imagine the human mind as a staggeringly powerful, aggressively wild, unbridled horse.
            If you (the soul/intelligence) brutally discipline, train, and mount a titanium bridle upon that wild horse (Jitatma), that mind instantly transforms into your absolute greatest asset. It will effortlessly carry you to victory in every single battle of life (This is the mind as a 'Friend').
            But if you lazily leave that wild horse uncontrolled, it will violently trample you and drag you off a cliff. A human who pathetically fails to restrict his toxic tongue, his blazing lust, and his violent anger finds that his own mind actively sabotages his life, pulling him into chronic diseases and catastrophic ruin (This is the mind acting as a 'Lethal Enemy').
            The absolute greatest World War is not fought on a physical battlefield; it is fought entirely inside the human brain. Conquering the mind is the ultimate, supreme victory in the universe.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            जितात्मनः प्रशान्तस्य परमात्मा समाहितः |
            शीतोष्णसुखदुःखेषु तथा मानापमानयोः || ७ ||
        """.trimIndent(),
        hindi = """
            जिसने अपने मन को पूरी तरह जीत लिया है (जितात्मनः) और जो पूरी तरह से शांत (प्रशान्तस्य) हो चुका है, ऐसे महापुरुष का परब्रह्म परमात्मा के साथ सीधा और पक्का संपर्क (समाहितः) हो चुका है।
            ऐसे व्यक्ति के लिए सर्दी और गर्मी (शीतोष्ण), सुख और दुःख, तथा सम्मान (मान) और अपमान (अपमान) बिल्कुल एक समान होते हैं।
            यह श्लोक 'मन को जीतने' के बाद मिलने वाले 'सुपरपावर' (Superpower) का वर्णन करता है।
            जब इंसान का मन जीत लिया जाता है, तो उसके भीतर चलने वाला विचारों का शोर (Noise) पूरी तरह बंद हो जाता है और वह 'प्रशांत' (Deeply Peaceful) हो जाता है।
            जैसे ही मन शांत होता है, इंसान को बाहर के मंदिरों में भगवान ढूँढने की जरूरत नहीं पड़ती; उसके अपने ही हृदय में बैठे 'परमात्मा' से उसका सीधा 'वाई-फाई कनेक्शन' (Wi-Fi Connection / समाहितः) जुड़ जाता है।
            और जब इंसान साक्षात् परमात्मा से जुड़ जाता है, तो इस दुनिया की छोटी-मोटी चीज़ें उस पर असर करना बंद कर देती हैं।
            चाहे मौसम की 'सर्दी-गर्मी' हो (Physical level), चाहे मन का 'सुख-दुःख' हो (Mental level), या फिर समाज का 'सम्मान और बेइज्जती' हो (Social/Ego level)—वह योगी इन सब में एक चट्टान की तरह अचल (Unaffected) रहता है। 
            यह श्लोक बताता है कि सच्ची स्पिरिचुअलिटी (Spirituality) आपको दुनिया के हर प्रकार के स्ट्रेस (Stress) से 'बुलेटप्रूफ' (Bulletproof) बना देती है।
        """.trimIndent(),
        english = """
            For one who has perfectly conquered the mind (Jitatmanah) and has thereby attained profound, absolute tranquility (Prashantasya), the Supersoul (Paramatma) is already fully reached and permanently realized (Samahitah).
            To such a highly elevated man, the dualities of severe cold and scorching heat, extreme happiness and deep distress, as well as grand honor and brutal dishonor, are all exactly the same.
            This phenomenal verse vividly describes the absolute 'Superpower' and transcendental upgrades unlocked instantly upon 'Conquering the Mind'.
            When the mind is completely conquered, the chaotic, deafening noise of toxic thoughts is brutally silenced, and the practitioner enters a state of 'Prashanta' (Profound, Absolute Silence).
            The exact microsecond the mind hits perfect stillness, the human absolutely no longer needs to hunt for God in external temples; a direct, high-speed, unbreakable 'Wi-Fi Connection' (Samahitah) is instantly established with the 'Paramatma' (Supersoul) residing right inside his own heart.
            And when a human is securely plugged directly into the Supreme Lord, the petty fluctuations of this material matrix completely lose their ability to affect him.
            Whether it is 'Cold and Heat' (Physical bodily level), 'Joy and Sorrow' (Mental emotional level), or massive 'Honor and Insult' (Social Ego level)—the Yogi stands completely unaffected, like an impenetrable titanium fortress.
            This verse proves that authentic spirituality acts as absolute, cosmic 'Body Armor', making a human 100% bulletproof against all worldly stress and depression.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            ज्ञानविज्ञानतृप्तात्मा कूटस्थो विजितेन्द्रियः |
            युक्त इत्युच्यते योगी समलोष्टाश्मकाञ्चनः || ८ ||
        """.trimIndent(),
        hindi = """
            जिसका अंतःकरण (मन) शास्त्रों के सैद्धांतिक 'ज्ञान' और परमात्मा के साक्षात् अनुभव ('विज्ञान') से पूरी तरह तृप्त (संतुष्ट) हो चुका है...
            जो अपनी आत्मा में कूटस्थ (एक पहाड़ की तरह बिल्कुल अचल) स्थित है, जिसने अपनी सभी इन्द्रियों को पूरी तरह जीत लिया है (विजितेन्द्रियः)...
            और जिसके लिए मिट्टी का ढेला (लोष्ट), पत्थर (अश्म) और शुद्ध सोना (काञ्चन) बिल्कुल एक बराबर हैं; ऐसे महापुरुष को ही सच्चा और 'युक्त' (ईश्वर से जुड़ा हुआ) योगी कहा जाता है।
            श्रीकृष्ण एक 'परफेक्ट योगी' (Perfect Yogi) का सबसे कड़ा और अंतिम टेस्ट (Ultimate Test) यहाँ बता रहे हैं।
            कोई इंसान योगी है या नहीं, यह इस बात से तय नहीं होता कि वह कितनी अच्छी किताबें पढ़ता है ('ज्ञान')। उसे उस ज्ञान का असली 'एक्सपीरियंस' (Experience/विज्ञान) भी होना चाहिए।
            जब उसे वह दिव्य आनंद मिल जाता है, तो वह 'कूटस्थ' (लोहार के निहाई की तरह, जिस पर कितना भी हथौड़ा मारो, वह नहीं टूटती) हो जाता है।
            लेकिन उसका सबसे बड़ा 'लक्षण' (Symptom) उसकी दृष्टि में होता है। एक साधारण इंसान की नज़र में मिट्टी बेकार है और 'सोना' (Gold) सबसे कीमती है; वह सोने के लिए झूठ बोल सकता है या किसी की हत्या कर सकता है।
            लेकिन एक सिद्ध योगी की नज़र में मिट्टी का एक ढेला और 24-कैरेट का शुद्ध सोना दोनों बिल्कुल 'बराबर' (समान) हैं। क्यों? क्योंकि वह जानता है कि दोनों ही भौतिक प्रकृति (माया) के अलग-अलग रूप हैं, और दोनों ही आत्मा की भूख नहीं मिटा सकते।
            जब इंसान के मन से 'धन और सोने' का लालच पूरी तरह ज़ीरो (Zero) हो जाता है, तभी वह असली 'योगी' कहलाता है।
        """.trimIndent(),
        english = """
            A person is officially declared to be established in self-realization and is called a perfect yogi (Yuktah) when he is completely, 100% satisfied by virtue of both theoretical scriptural knowledge (Jnana) and direct, realized spiritual experience (Vijnana).
            Such a person is situated unshakeably and firmly on the spiritual platform (Kuta-stho), has achieved absolute titanium mastery over his senses (Vijitendriyah)...
            and looks upon a lump of common dirt (Loshta), a piece of ordinary stone (Ashma), and pure, solid gold (Kanchanah) with absolute, perfect equality.
            Sri Krishna is laying down the absolute hardest, most uncompromising, and 'Ultimate Test' to verify a 'Perfect Yogi' here.
            A human being is absolutely not classified as a Yogi merely by memorizing massive libraries of philosophy ('Jnana'). He must possess the blistering, direct, experiential realization ('Vijnana') of that truth.
            When he tastes that explosive divine ecstasy, he becomes 'Kuta-stha' (exactly like a blacksmith's heavy iron anvil—no matter how violently you hammer it, it remains completely unbroken and unmoved).
            But his absolute greatest, mind-bending 'Symptom' lies entirely in his vision. In the eyes of an ignorant mortal, dirt is useless trash, and 'Gold' is the ultimate prize; mortals will lie, cheat, and murder ruthlessly for gold.
            But in the flawless eyes of an elite Yogi, a worthless lump of mud and a shining brick of 24-karat solid gold hold the exact same 'Equal' zero value. Why? Because he scientifically knows both are merely temporary, cheap manifestations of material nature (Maya) that absolutely cannot feed the eternal soul.
            When the blinding lust for 'Wealth and Gold' drops to absolute Zero in a human's brain, only then is he officially crowned a true 'Yogi'.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            सुहृन्मित्रार्युदासीनमध्यस्थद्वेष्यबन्धुषु |
            साधुष्वपि च पापेषु समबुद्धिर्विशिष्यते || ९ ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति बिना स्वार्थ के भलाई करने वाले (सुहृद्), साधारण मित्र (मित्र), शत्रु (अरि), किसी से भी मतलब न रखने वाले (उदासीन), दोनों पक्षों का भला चाहने वाले (मध्यस्थ), नफरत करने योग्य (द्वेष्य), और अपने सगे संबंधियों (बंधुओं) में...
            तथा अत्यंत पवित्र साधु पुरुषों (साधुषु) और घोर पापी लोगों (पापेषु) में भी एक समान बुद्धि (समबुद्धि) रखता है, वह महापुरुष सबसे अत्यंत श्रेष्ठ (विशिष्यते) है।
            पिछले श्लोक में भगवान ने बताया था कि योगी को 'वस्तुओं' (जैसे सोना और मिट्टी) के प्रति समान होना चाहिए। इस श्लोक में भगवान उस सिद्धांत को 'इंसानों' (Human Relationships) पर लागू कर रहे हैं, जो दुनिया का सबसे मुश्किल काम है।
            इंसान के लिए सोने को मिट्टी समझना फिर भी आसान हो सकता है, लेकिन क्या वह अपने 'सगे भाई' और अपने 'सबसे बड़े दुश्मन' को एक नज़रों से देख सकता है?
            भगवान यहाँ समाज के हर प्रकार के इंसान की लिस्ट देते हैं: दोस्त, दुश्मन, तटस्थ लोग, रिश्तेदार, बड़े-बड़े संत (साधु) और यहाँ तक कि भयंकर पापी!
            साधारण इंसान हमेशा गुटबाजी (Bias) करता है: "यह मेरा दोस्त है, मैं इसके साथ अच्छा करूँगा; यह मेरा दुश्मन है, मैं इसे बर्बाद कर दूँगा।"
            लेकिन 'समबुद्धि' वाला योगी इन सारे लेबल्स (Labels) को फाड़ कर फेंक देता है। वह जानता है कि चाहे सामने वाला पापी हो या साधु, उसके अंदर मौजूद 'आत्मा' एक ही परमेश्वर का अंश है।
            इसलिए उसका 'प्यार और सम्मान' पापी और साधु दोनों के लिए 100% बराबर होता है। इस स्तर (Level) का अनकंडीशनल लव (Unconditional Love) और समानता हासिल करने वाला इंसान पूरी मानव जाति में 'विशिष्यते' (सबसे श्रेष्ठ / The Ultimate Best) माना जाता है।
        """.trimIndent(),
        english = """
            A person is considered supremely highly advanced (Vishishyate) when he looks with flawless, equal intelligence (Sama-buddhir) upon the selfless well-wisher (Suhrid), the affectionate friend (Mitra), the bitter enemy (Ari), the indifferent neutral (Udasina), the mediator (Madhyastha), the envious (Dveshya), and his own blood relatives (Bandhushu)...
            and when he maintains this exact same equal vision even between highly pious saints (Sadhushu) and the most horrific sinners (Papeshu).
            In the previous verse, the Lord commanded that a Yogi must be perfectly equal toward 'Material Objects' (like gold and dirt). In this mind-bending verse, the Lord applies that exact extreme standard to 'Human Relationships', which is the hardest task in the cosmos.
            It might be possible for a human to view gold as dirt, but can he possibly view his 'Beloved Brother' and his 'Most Bitter Enemy' with the exact same eyes?
            The Lord provides an exhaustive list of the entire social spectrum: friends, lethal enemies, neutrals, relatives, pure holy saints (Sadhus), and even horrific, blood-soaked sinners!
            An ignorant mortal constantly operates on toxic tribalism and bias: "He is my friend, I will favor him; he is my enemy, I will violently destroy him."
            But the Yogi operating with 'Sama-buddhi' (Equal Intelligence) completely rips off and burns all these superficial social 'Labels'. He scientifically knows that whether the body belongs to a saint or a serial killer, the 'Soul' inside is an identical, pure spark of God.
            Therefore, his internal 'Love and Respect' flows 100% equally toward the saint and the sinner. A human being who successfully unlocks this staggering altitude of 'Unconditional Love and Equality' is officially declared 'Vishishyate' (The Absolute Supreme Best) among all mankind.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            योगी युञ्जीत सततमात्मानं रहसि स्थितः |
            एकाकी यतचित्तात्मा निराशीरपरिग्रहः || १० ||
        """.trimIndent(),
        hindi = """
            एक योगी (ध्यान करने वाले साधक) को चाहिए कि वह एकांत (अकेलेपन) स्थान में स्थित होकर (रहसि स्थितः), बिल्कुल अकेला (एकाकी) रहते हुए, और अपने मन तथा शरीर को पूरी तरह वश में (यतचित्तात्मा) रखकर...
            तथा सभी प्रकार की सांसारिक इच्छाओं (निराशीः) और संग्रह करने की प्रवृत्ति (अपरिग्रहः) से मुक्त होकर, हमेशा (सततम्) अपनी आत्मा को परमात्मा के ध्यान में लगाए (युञ्जीत)।
            यहाँ से भगवान श्रीकृष्ण 'अष्टांग ध्यान योग' (Meditation) का प्रॉपर 'प्रैक्टिकल मैनुअल' (Practical Manual) शुरू कर रहे हैं। ध्यान लगाने के लिए बाहर और अंदर की क्या तैयारी होनी चाहिए, यह उसका ब्लूप्रिंट (Blueprint) है।
            सबसे पहले बाहरी तैयारी:
            १. 'रहसि स्थितः' और 'एकाकी': ध्यान कोई भीड़-भाड़ वाली जगह (जैसे बाज़ार या ड्राइंग रूम) में नहीं हो सकता। आपको एक ऐसा 'एकांत' कमरा या जगह चाहिए जहाँ कोई आपको डिस्टर्ब (Disturb) न करे। आपको बिल्कुल 'अकेला' होना पड़ेगा; ध्यान ग्रुप (Group) में गपशप करते हुए नहीं होता।
            अब अंदर की तैयारी (जो ज्यादा मुश्किल है):
            २. 'निराशीः': जब आप आँखें बंद करके बैठें, तो दिमाग में कोई 'आशा' या भविष्य का सपना नहीं होना चाहिए कि "ध्यान के बाद मुझे यह फायदा होगा।"
            ३. 'अपरिग्रहः': आपके मन में यह चिंता नहीं होनी चाहिए कि "मेरा बैंक बैलेंस कितना है, मेरी प्रॉपर्टी कौन देखेगा।" चीजों पर मालकियत (Ownership) का भाव शून्य (Zero) होना चाहिए।
            जब इंसान बाहर से पूरी तरह अकेला हो और अंदर से पूरी तरह खाली (बिना इच्छा और चिंता के) हो, केवल उसी शांत स्थिति में वह अपने मन को लगातार ('सततम्') ईश्वर के साथ 'कनेक्ट' (Connect / युञ्जीत) कर सकता है।
        """.trimIndent(),
        english = """
            A transcendentalist (Yogi) should always consistently and continuously engage his mind and soul in deep meditation on the Supreme (Satatam atmanam yunjita)...
            He should live entirely alone (Ekaki) in a secluded, secret place (Rahasi sthitah), having his mind and physical body strictly under his control (Yata-chittatma)...
            and he should be completely free from all material desires and expectations (Nirashir) and entirely free from the possessive desire to hoard wealth or belongings (Aparigrahah).
            From this exact verse, Lord Sri Krishna officially opens the ultimate 'Practical Operations Manual' for 'Ashtanga Dhyana Yoga' (Deep Trance Meditation). This is the exact blueprint of the external and internal prerequisites required before initiating meditation.
            First, the External Preparation:
            1. 'Rahasi sthitah' & 'Ekaki': Deep meditation absolutely cannot be executed in a chaotic, crowded environment (like a market or a noisy living room). You must secure an absolutely 'Secluded', highly private space where zero interruptions occur. You must be strictly 'Alone'; supreme meditation is a solitary flight, not a social group activity.
            Now, the Internal Preparation (which is far more brutal):
            2. 'Nirashir': The exact moment you close your eyes, your brain must be violently scrubbed clean of all 'Hopes' and future daydreams like, "I hope this meditation makes me rich or famous."
            3. 'Aparigrahah': Your brain must possess zero anxiety regarding your physical assets ("What will happen to my bank account or property?"). The toxic concept of 'Ownership' must drop to absolute Zero.
            When a human being is physically isolated on the outside, and 100% empty (devoid of desire and anxiety) on the inside, only in that flawless, pristine vacuum can he continuously ('Satatam') establish a direct 'Connection' (Yunjita) with the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            शुचौ देशे प्रतिष्ठाप्य स्थिरमासनमात्मनः |
            नात्युच्छ्रितं नातिनीचं चैलाजिनकुशोत्तरम् || ११ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 11 और 12 ध्यान की प्रक्रिया हैं)
            पवित्र और साफ-सुथरे स्थान पर (शुचौ देशे), कुशा (पवित्र घास), मृगछाला (हिरण की छाल) और कपड़े—इन तीनों को एक के ऊपर एक बिछाकर...
            अपना जो आसन (Seat) लगाया जाए, वह न तो बहुत अधिक ऊँचा होना चाहिए (नात्युच्छ्रितं) और न ही बहुत अधिक नीचा होना चाहिए (नातिनीचं), और उसे पूरी तरह से स्थिर (हिलने-डुलने से रहित) होना चाहिए।
            भगवान श्रीकृष्ण यहाँ एक मास्टर-ट्रेनर (Master-Trainer) की तरह ध्यान के लिए बिल्कुल परफेक्ट 'भौतिक सेटअप' (Physical Setup / Infrastructure) समझा रहे हैं।
            ध्यान करने के लिए आप कहीं भी नहीं बैठ सकते।
            १. 'शुचौ देशे': जगह पूरी तरह साफ-सुथरी और पवित्र होनी चाहिए। गंदी जगह पर नेगेटिव एनर्जी (Negative Energy) होती है जो मन को भटकती है।
            २. आसन कैसा हो? भगवान एक लेयरिंग सिस्टम (Layering System) बताते हैं: सबसे नीचे 'कुशा' (एक खास प्रकार की घास जो शरीर की बिजली/ऊर्जा को ज़मीन में जाने से रोकती है - Insulator), उसके ऊपर जानवरों से रक्षा के लिए 'मृगछाला', और सबसे ऊपर आराम के लिए एक मुलायम 'कपड़ा' (चैल)।
            ३. 'नात्युच्छ्रितं नातिनीचं': आसन बहुत ऊँचा नहीं होना चाहिए, वरना ध्यान लगते ही गिरने और चोट लगने का डर रहेगा। और आसन ज़मीन से बहुत नीचा भी नहीं होना चाहिए, वरना कीड़े-मकोड़े या ज़मीन की नमी परेशान करेगी।
            यह श्लोक दिखाता है कि आध्यात्मिकता (Spirituality) केवल हवा-हवाई बातें नहीं हैं; यह एक बहुत ही बारीक और सटीक 'विज्ञान' (Science) है जहाँ शरीर के पोस्चर (Posture) और पर्यावरण (Environment) का सीधा असर आपके दिमाग पर पड़ता है।
        """.trimIndent(),
        english = """
            (Verses 11 and 12 describe the exact process of meditation)
            To practice classical yoga, one should go to a highly sanctified, completely clean, and pure place (Shuchau deshe) and meticulously prepare a firm, stable seat (Sthiram asanam) for himself...
            This seat should be neither too high (Natyucchritam) nor too low (Natinicham), and it should be specifically constructed by laying sacred Kusha grass, a deerskin, and a soft cloth, one over the other (Chailajina-kushottaram).
            Lord Sri Krishna acts exactly like a supreme 'Master-Trainer' here, meticulously laying out the absolute perfect 'Physical Infrastructure and Setup' required to launch deep meditation.
            You absolutely cannot just sit anywhere randomly to execute high-level yoga.
            1. 'Shuchau deshe': The immediate physical environment must be impeccably clean, pristine, and spiritually sanctified. A filthy, messy room generates intense negative psychological energy that instantly distracts the mind.
            2. What is the architecture of the seat? The Lord prescribes a highly specific, scientific 'Layering System': At the absolute bottom is 'Kusha grass' (a powerful natural insulator that violently prevents the body's spiritual electrical energy from grounding into the earth), topped with a 'Deerskin' to repel insects/snakes, and finally covered by a soft 'Cloth' for basic physical comfort.
            3. 'Natyucchritam Natinicham': The seat must absolutely not be too high; otherwise, when the Yogi enters a deep trance and loses bodily consciousness, he risks a fatal fall. Nor should it be too low, exposing him to damp soil or crawling insects.
            This astonishing verse perfectly proves that Vedic spirituality is not just vague, airy philosophy; it is a brutally precise, hardcore 'Science' where physical posture, atmospheric physics, and environmental ergonomics directly and violently dictate the success of your mental focus.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            तत्रैकाग्रं मनः कृत्वा यतचित्तेन्द्रियक्रियः |
            उपविश्यासने युञ्ज्याद्योगमात्मविशुद्धये || १२ ||
        """.trimIndent(),
        hindi = """
            उस स्थिर आसन पर बैठकर (उपविश्यासने), अपने चित्त (मन) और इन्द्रियों की सभी बाहरी क्रियाओं (गतिविधियों) को पूरी तरह से वश में करके (यतचित्तेन्द्रियक्रियः)...
            अपने मन को केवल एक ही बिंदु (परमात्मा) पर पूरी तरह एकाग्र करके (एकाग्रं मनः कृत्वा), योगी को केवल अपने अंतःकरण (आत्मा) की शुद्धि के लिए (आत्मविशुद्धये) ही इस योग का अभ्यास (युञ्ज्याद्योगम्) करना चाहिए।
            आसन (Physical Setup) तैयार करने के बाद, अब भगवान उस आसन पर बैठकर किए जाने वाले 'मानसिक सेटअप' (Mental Setup) का ऑर्डर दे रहे हैं।
            जैसे ही योगी आसन पर बैठता है, उसे अपने शरीर की सभी हरकतों (हिलना-डुलना, खुजलाना) और इन्द्रियों के कामों को पूरी तरह से 'फ्रीज़' (Freeze / यतचित्तेन्द्रियक्रियः) कर देना होता है।
            फिर उसे अपने मन को जो कि हज़ारों दिशाओं में भागता है, उसे खींचकर एक लेज़र-बीम (Laser-beam) की तरह केवल एक ही जगह (ईश्वर) पर 'एकाग्र' (100% Concentrated) करना होता है।
            सबसे महत्वपूर्ण बात भगवान अंतिम लाइन में बताते हैं: यह सारी भयंकर मेहनत और ध्यान क्यों करना है? क्या कोई जादुई शक्तियां (Superpowers / सिद्धियां) पाने के लिए? या हवा में उड़ने के लिए?
            श्रीकृष्ण स्पष्ट कहते हैं: "नहीं! यह सारा योग केवल और केवल 'आत्मविशुद्धये' (Self-Purification) के लिए करना है।"
            ध्यान का असली मकसद अपनी आत्मा से करोड़ों जन्मों की वासनाओं, अहंकार और गंदगी को धोकर उसे शीशे की तरह चमकाना है, ताकि उसमें भगवान का चेहरा दिखाई दे सके।
        """.trimIndent(),
        english = """
            Having firmly taken his seat on that prepared asana (Upavishyashane), the yogi should make his mind entirely, one-pointedly focused (Ekagram manah kritva)...
            and violently restraining all the activities of his wandering mind and physical senses (Yata-chittendriya-kriyah), he should intensely practice this yoga exclusively for the sole purpose of purifying his heart and soul (Atma-vishuddhaye).
            Now that the physical 'Hardware Setup' (the seat) is perfectly configured, the Lord issues the direct command for the highly complex 'Mental Software Setup'.
            The exact microsecond the Yogi firmly takes his seat, he must execute a brutal, total 'Freeze' on all external biological movements (fidgeting, scratching) and completely paralyze the erratic activities of his senses (Yata-chittendriya-kriyah).
            Then, he must aggressively lasso his wildly fluctuating mind—which naturally splinters into a million different directions—and forcefully concentrate it like a blinding, highly focused 'Laser-Beam' onto one singular point (God).
            But the absolute most critical, game-changing instruction is dropped in the final line: Exactly why are you executing this unimaginably grueling meditation? Is it to acquire cheap mystical superpowers (Siddhis) like reading minds or levitating in the air?
            Sri Krishna violently rejects this: "Absolutely not! You must execute this intense Yoga entirely, exclusively, and solely for 'Atma-vishuddhaye' (Absolute Self-Purification)."
            The ultimate, singular objective of true meditation is to ruthlessly scrub away and incinerate the toxic grime, blinding lust, and massive ego accumulated over millions of lifetimes, polishing the soul into a flawless mirror so it can finally reflect the face of God.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            समं कायशिरोग्रीवं धारयन्नचलं स्थिरः |
            सम्प्रेक्ष्य नासिकाग्रं स्वं दिशश्चानवलोकयन् || १३ ||
        """.trimIndent(),
        hindi = """
            योगी को चाहिए कि वह अपने शरीर (धड़), सिर (माथा) और गर्दन को बिल्कुल सीधा (समं) और अचल (बिना हिलाए) धारण करके (रखकर) पूरी तरह स्थिर (स्थिरः) हो जाए।
            और किसी भी अन्य दिशा (इधर-उधर) में बिल्कुल न देखते हुए (दिशश्चानवलोकयन्), अपनी दृष्टि को केवल अपनी नाक के अग्रभाग (टिप / Tip) पर ही टिकाए रखे (सम्प्रेक्ष्य नासिकाग्रं स्वं)।
            यह श्लोक 'बॉडी पोस्चर' (Body Posture) यानी ध्यान में बैठने की सबसे परफेक्ट और वैज्ञानिक (Scientific) शारीरिक मुद्रा का वर्णन करता है।
            १. 'समं काय-शिरो-ग्रीवं': शरीर का मुख्य हिस्सा (कमर), गर्दन और सिर—ये तीनों एक बिल्कुल 'सीधी रेखा' (Straight line / 90 degrees) में होने चाहिए। अगर इंसान झुककर या टेढ़ा बैठेगा, तो उसकी रीढ़ की हड्डी (Spinal Cord) सीधी नहीं रहेगी, जिससे प्राण-ऊर्जा (Energy) का प्रवाह रुक जाएगा और उसे तुरंत नींद आ जाएगी।
            २. 'अचलं स्थिरः': एक मूर्ति (Statue) की तरह बिल्कुल बिना हिले-डुले बैठना है। शरीर का ज़रा सा भी हिलना मन को डिस्टर्ब (Disturb) कर देता है।
            ३. 'नासिकाग्रं सम्प्रेक्ष्य': अपनी आँखों को आधा बंद (Half-closed) करके अपने ध्यान (Focus) को अपनी ही नाक के सबसे आगे वाले हिस्से (Tip of the nose) पर टिकाना है।
            अगर आँखें पूरी तरह बंद कर लीं, तो इंसान सपनों में खो जाएगा या सो जाएगा। अगर आँखें पूरी तरह खुली रखीं, तो इधर-उधर की चीजें ('दिशश्चानवलोकयन्') देखकर मन भटक जाएगा।
            इसलिए आधी खुली आँखों से नाक के टिप पर देखने से दिमाग की सारी बाहरी गतिविधियां लॉक (Lock) हो जाती हैं और मन 100% सेंटर (Center) में आ जाता है। यह न्यूरोसाइंस (Neuroscience) का एक कमाल का हैक (Hack) है।
        """.trimIndent(),
        english = """
            The yogi must hold his physical body, his neck, and his head entirely erect and in a perfectly straight, unbroken line (Samam kaya-shiro-grivam), maintaining absolute, statuesque stillness (Achalam sthirah).
            He should completely restrain his vision from wandering or looking in any other direction whatsoever (Dishash chanavalokayan), and must steadily gaze and lock his focus exclusively on the very tip of his own nose (Samprekshya nasikagram svam).
            This spectacular verse provides the absolute, flawless 'Scientific Body Posture' and exact ergonomic alignment required to successfully execute deep meditation.
            1. 'Samam kaya-shiro-grivam': The main trunk of the body, the neck, and the head must be rigidly aligned in one absolute, perfect 'Straight Line' (90 degrees to the ground). If the human slouches or bends, the spinal cord bends, instantly choking the upward flow of vital spiritual energy (Prana), which will rapidly and inevitably force the brain into deep sleep.
            2. 'Achalam sthirah': You must sit absolutely frozen, completely motionless, exactly like an inanimate stone statue. Even a microscopic physical twitch instantly sends a disruptive shockwave into the delicate mind.
            3. 'Nasikagram samprekshya': Keep your eyelids exactly 'Half-Closed', and forcefully lock your visual targeting system solely onto the extreme tip of your own nose.
            If you shut your eyes 100%, your brain will immediately drift into toxic daydreams or violently crash into sleep. If you keep them 100% open, you will start foolishly scanning the room ('Dishash chanavalokayan'), instantly shattering your focus.
            Therefore, maintaining a half-closed gaze locked purely on the nose-tip acts as a staggering 'Neuroscientific Hack'; it physically blocks all external sensory inputs and forcefully centralizes the brain's entire processing power.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            प्रशान्तात्मा विगतभीर्ब्रह्मचारिव्रते स्थितः |
            मनः संयम्य मच्चित्तो युक्त आसीत मत्परः || १४ ||
        """.trimIndent(),
        hindi = """
            पूरी तरह से शांत अंतःकरण (मन) वाला (प्रशान्तात्मा), हर प्रकार के डर से पूरी तरह मुक्त (विगतभीः), और ब्रह्मचर्य के कठोर व्रत में पूरी तरह स्थित (ब्रह्मचारिव्रते स्थितः) होकर...
            उस योगी को चाहिए कि वह अपने मन को भली-भांति रोककर (कंट्रोल करके), अपने पूरे चित्त (ध्यान) को केवल मुझमें (श्रीकृष्ण में) ही लगाए (मच्चित्तो), और मुझे ही अपना परम लक्ष्य (मत्परः) मानकर योग में बैठे (युक्त आसीत)।
            शारीरिक मुद्रा (Posture) के बाद, भगवान यहाँ उस ध्यानी योगी की 'मेंटल स्टेट' (Mental State / मानसिक अवस्था) के 5 सबसे जरूरी नियम बता रहे हैं:
            १. 'प्रशान्तात्मा': मन में किसी भी चीज़ को लेकर कोई हलचल या स्ट्रेस नहीं होना चाहिए।
            २. 'विगतभीः' (Fearless / निडर): ध्यान में बैठने वाले को मौत या दुनिया का कोई डर नहीं होना चाहिए। डरपोक इंसान कभी समाधि में नहीं जा सकता क्योंकि उसका दिमाग हमेशा 'सर्वाइवल मोड' (Survival mode) में रहता है।
            ३. 'ब्रह्मचारिव्रते': यह सबसे कड़ा नियम है। 'ब्रह्मचर्य' का मतलब केवल शारीरिक सेक्स (Sex) से दूर रहना नहीं है, बल्कि मन में भी किसी प्रकार की कामवासना (Lust) का न होना है। वासना इंसान की सारी ऊर्जा (Energy) को नीचे गिरा देती है; बिना ब्रह्मचर्य के योग में ऊपर उठना असंभव है।
            ४. 'मनः संयम्य': मन की लगाम को ज़ोर से खींचकर पकड़ना।
            ५. 'मच्चित्तो मत्परः': यह पूरी प्रक्रिया का 'क्लाइमेक्स' (Climax) है। तुमने आँखें बंद कर लीं, मन को रोक लिया, लेकिन अब उस खाली मन को लगाना कहाँ है? शून्य (Zero) में नहीं! भगवान कहते हैं, "अपने उस पूरे फोकस को 'मुझ पर' (साकार ईश्वर पर) लॉक कर दो।"
            ईश्वर ही अंतिम लक्ष्य है, कोई रहस्यमयी शक्ति या शून्य नहीं।
        """.trimIndent(),
        english = """
            With an absolutely serene, profoundly peaceful unagitated soul (Prashantatma), completely entirely free from every trace of fear (Vigata-bhih), and strictly situated in the rigid vow of absolute celibacy (Brahmachari-vrate sthitah)...
            the yogi should completely subdue and control his mind (Manah samyamya), fix his entire consciousness exclusively upon Me (Mac-chitto), and sit in meditation viewing Me as the absolute supreme, ultimate goal of life (Mat-parah).
            After perfectly aligning the physical body posture, the Lord now strictly enforces the 5 absolute, non-negotiable rules for the Yogi's 'Internal Mental State':
            1. 'Prashantatma': The internal consciousness must be flawlessly serene, totally devoid of the slightest microscopic ripple of worldly stress or chaotic agitation.
            2. 'Vigata-bhih' (Absolutely Fearless): The meditating Yogi must violently eradicate all fear (especially the terror of death). A cowardly, fearful brain is permanently locked in biological 'Survival Mode' and can absolutely never penetrate the higher dimensions of Samadhi.
            3. 'Brahmachari-vrate': This is the absolute strictest law. 'Brahmacharya' (Celibacy) does not merely mean abstaining from physical sex; it demands the violent, total annihilation of all mental sexual fantasies and lust. Lust rapidly drains the body's supreme spiritual energy downwards; without strict celibacy, elevating consciousness is a biological impossibility.
            4. 'Manah samyamya': Brutally strangling and locking down the flickering mind.
            5. 'Mac-chitto Mat-parah': This is the grand 'Climax' of the entire operation. You have closed your eyes and stopped the mind, but where exactly do you point that blank mind? Not at a void or a black hole! The Lord commands: "Lock your 100% laser-focus exclusively on ME (The Supreme Personality)."
            God Himself is the absolute final destination, not some vague, formless void or mystical energy.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            युञ्जन्नेवं सदात्मानं योगी नियतमानसः |
            शान्तिं निर्वाणपरमां मत्संस्थामधिगच्छति || १५ ||
        """.trimIndent(),
        hindi = """
            इस प्रकार ऊपर बताए गए तरीके से अपने मन को लगातार अपने पूरे वश में रखते हुए (नियतमानसः), और अपनी आत्मा को निरंतर मुझमें (परमात्मा में) लगाते हुए (युञ्जन्नेवं सदात्मानं)...
            वह योगी उस परम शांति (शान्तिं) को प्राप्त कर लेता है, जो 'निर्वाण' (भौतिक अस्तित्व के पूर्ण अंत) की सर्वोच्च अवस्था है, और जो मेरे ही स्वरूप में स्थित है (मत्संस्थाम्)।
            भगवान श्रीकृष्ण यहाँ उस अष्टांग योग (Meditation) का 'अंतिम इनाम' (Ultimate Reward) बता रहे हैं जो पिछले श्लोकों में सिखाया गया है।
            जब कोई योगी लगातार (सदा), बिना किसी छुट्टी (Break) के, अपने मन को एक सख्त मिलिट्री-डिसिप्लिन (Military Discipline / नियतमानसः) में रखता है और अपना 100% फोकस भगवान (मत्संस्थाम्) पर लॉक कर देता है...
            तो उसे क्या मिलता है? उसे कोई जादुई शक्ति या दुनिया का खजाना नहीं मिलता; उसे वह चीज़ मिलती है जो ब्रह्मांड में सबसे दुर्लभ (Rarest) है—'निर्वाणपरमां शान्तिं'।
            यह कोई साधारण शांति (Peace) नहीं है जो अच्छी नींद सोने के बाद मिलती है। यह वह 'अल्टीमेट शांति' है जहाँ मन के सारे शोर, जन्म-मरण के सारे डर, और इच्छाओं की सारी आग हमेशा के लिए बुझ जाती है ('निर्वाण' का अर्थ है आग का पूरी तरह बुझ जाना)।
            और यह शांति कहीं आसमान में नहीं मिलती; यह भगवान कहते हैं "मत्संस्थाम्"—यह शांति मेरा ही स्वरूप है। जब इंसान इस शांति को छूता है, तो वह सीधे ईश्वर के अस्तित्व में प्रवेश कर जाता है।
            यही मानव जीवन का सबसे बड़ा और अंतिम अचीवमेंट (Achievement) है।
        """.trimIndent(),
        english = """
            By thus continuously constantly engaging his body, mind, and soul in this strict, uninterrupted practice of yoga, keeping his mind always perfectly disciplined and controlled (Niyata-manasah)...
            the mystic transcendentalist (Yogi) flawlessly attains the supreme kingdom of unadulterated peace (Shantim) culminating in absolute liberation (Nirvana-paramam), which abides entirely in Me (Mat-samstham).
            Lord Sri Krishna is officially declaring the absolute 'Ultimate Reward' and the staggering grand prize for successfully executing the hardcore Ashtanga Yoga described in the previous verses.
            When a dedicated Yogi continuously ('Sada'), without a single day's break, subjects his mind to brutal, uncompromising 'Military-Grade Discipline' (Niyata-manasah) and permanently locks his 100% focus directly onto the Supreme Lord...
            What exactly does he win? He absolutely does not win cheap magical superpowers (Siddhis) or billion-dollar earthly treasures; he unlocks the single rarest substance in the entire cosmos—'Nirvana-paramam Shantim'.
            This is absolutely not the cheap, temporary 'Peace' an ordinary mortal feels after a good night's sleep. This is the 'Ultimate, Titanium Cosmic Peace' where the deafening noise of the mind, the terrifying fear of death, and the raging fire of worldly lust are permanently extinguished forever ('Nirvana' literally means the complete blowing out of a fire).
            And this staggering peace is not found floating randomly in empty space; the Lord declares "Mat-samstham"—this absolute peace resides exclusively within MY very own nature. When a human touches this peace, he has literally penetrated and entered the very existence of God.
            This is the absolute highest, ultimate achievement possible in human existence.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            नात्यश्नतस्तु योगोऽस्ति न चैकान्तमनश्नतः |
            न चाति स्वप्नशीलस्य जाग्रतो नैव चार्जुन || १६ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! यह योग (ध्यान या समाधि) न तो बहुत अधिक खाने वाले व्यक्ति (अत्यश्नतः) से सिद्ध होता है, और न ही बिल्कुल कुछ भी न खाने वाले (उपवास करने वाले / अनश्नतः) से सिद्ध होता है।
            तथा यह योग न तो बहुत अधिक सोने वाले (अति स्वप्नशीलस्य) से सिद्ध होता है, और न ही हमेशा (ज़रूरत से ज़्यादा) जागने वाले व्यक्ति से ही सिद्ध होता है।
            यह भगवद्गीता का सबसे व्यावहारिक (Highly Practical) और 'कॉमन सेंस' (Common Sense) वाला श्लोक है, जो इंसान की लाइफस्टाइल (Lifestyle) के लिए है।
            भगवान श्रीकृष्ण किसी भी प्रकार के 'एक्स्ट्रीम' (Extreme / अति) को पूरी तरह से रिजेक्ट (Reject) कर रहे हैं। योग का अर्थ शरीर को टॉर्चर (Torture) करना नहीं है।
            १. खाना: अगर आप गले तक ठूंस-ठूंस कर (Overeating) खाएंगे, तो शरीर सुस्त हो जाएगा और ध्यान में सिर्फ नींद आएगी। और अगर आप भूखे मरेंगे (Fasting extremely), तो शरीर में कमज़ोरी आ जाएगी और दिमाग सिर्फ खाने के बारे में सोचेगा, भगवान के बारे में नहीं।
            २. सोना: अगर आप 12 घंटे सोएंगे (Oversleeping), तो आप आलस्य के शिकार हो जाएंगे। और अगर आप हठ करके सोना ही छोड़ देंगे (Insomnia/Over-staying awake), तो आपका दिमाग क्रैश (Crash) हो जाएगा और पागलपन (Madness) आ जाएगा।
            श्रीकृष्ण एक लाइफ-कोच (Life Coach) की तरह समझा रहे हैं कि अध्यात्म (Spirituality) में किसी भी प्रकार की 'अति' (Extremism) बहुत खतरनाक है।
            जो इंसान अपनी बेसिक शारीरिक जरूरतों (Basic biological needs) को बैलेंस (Balance) नहीं कर सकता, वह कभी भगवान तक नहीं पहुँच सकता। मिडिल पाथ (The Middle Path) ही सफलता की चाबी है।
        """.trimIndent(),
        english = """
            O Arjuna! There is absolutely no possibility of one successfully becoming a yogi if one eats too much voraciously (Atyashnatas), or if one eats completely nothing at all (Anashnatah).
            Nor can one achieve this yoga if one sleeps far too much (Ati-svapna-shilasya), or if one forcefully does not sleep enough and remains awake unnecessarily (Jagrato).
            This is undeniably one of the most highly practical, exceptionally grounded, and ultimate 'Common Sense' lifestyle verses in the entire Bhagavad Gita.
            Lord Sri Krishna is aggressively and completely rejecting all forms of toxic 'Extremism' or fanaticism. Yoga absolutely does not mean brutally torturing your own biological machine.
            1. Eating: If you voraciously gorge yourself and overeat like a glutton, your biological system will crash into massive lethargy, and you will simply fall asleep the second you try to meditate. Conversely, if you violently starve yourself to death (severe fasting), your body will become pathetically weak, and your brain will hallucinate 24/7 purely about food, not God.
            2. Sleeping: If you lazily sleep for 12 hours a day, you will be consumed by the dark mode of ignorance (Tamas). And if you stubbornly try to artificially conquer sleep and stay awake 24/7, your neurological system will violently break down, leading to literal madness.
            Acting as the ultimate, supreme Life Coach, Sri Krishna clarifies that any form of 'Extreme fanatical behavior' in spirituality is highly dangerous and self-destructive.
            A human who cannot even intelligently balance his basic biological needs can absolutely never reach the highly advanced altitude of God-realization. 'The Middle Path' (Absolute Balance) is the exclusive master-key to success.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            युक्ताहारविहारस्य युक्तचेष्टस्य कर्मसु |
            युक्तस्वप्नावबोधस्य योगो भवति दुःखहा || १७ ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति अपने आहार (भोजन) और विहार (मनोरंजन/घूमना-फिरना) को पूरी तरह से युक्त (संतुलित और नियमित) रखता है, जो अपने सभी कर्मों में संतुलित रूप से चेष्टा (प्रयास) करता है...
            तथा जिसके सोने (स्वप्न) और जागने (अवबोध) का समय बिल्कुल नियमित (बैलेंस्ड) है, ऐसे अनुशासित मनुष्य के लिए ही यह 'योग' उसके सभी दुःखों को जड़ से नष्ट करने वाला (दुःखहा) बन जाता है।
            पिछले श्लोक में यह बताने के बाद कि क्या "नहीं करना है" (Extremes), इस श्लोक में भगवान बता रहे हैं कि "क्या करना है" (The Perfect Lifestyle)।
            सफलता का सबसे बड़ा सीक्रेट (Secret) है: 'युक्त' (Balanced / Regulated / अनुशासित)।
            १. 'युक्ताहारविहारस्य': आपका खाना आपकी भूख और स्वास्थ्य के अनुसार बैलेंस होना चाहिए। 'विहार' मतलब आपका खाली समय या मनोरंजन (Recreation) भी बैलेंस होना चाहिए (न तो दिन भर टीवी देखें, न ही 24 घंटे काम करें)।
            २. 'युक्तचेष्टस्य कर्मसु': अपने काम (Job/Duty) में बहुत ज्यादा पागलपन (Overwork) भी नहीं दिखाना है कि परिवार और स्वास्थ्य टूट जाए, और न ही काम से भागना है। 100% सही और बैलेंस प्रयास करना है।
            ३. 'युक्तस्वप्न': आपके सोने और उठने का एक पक्का रूटीन (Routine) होना चाहिए।
            भगवान गारंटी देते हैं कि जो इंसान अपनी डेली लाइफ (Daily life) को इस तरह एक मशीन की तरह अनुशासित (Disciplined) कर लेता है, उसके लिए यह 'योग' उसके जीवन के सारे स्ट्रेस, डिप्रेशन और दुःखों को एक झटके में खत्म कर देता है ('दुःखहा')।
            यानी, अगर आपकी लाइफस्टाइल (Lifestyle) खराब है, तो कोई भी ध्यान (Meditation) या भगवान का नाम आपके दुखों को दूर नहीं कर सकता। योग तभी काम करता है जब ज़िंदगी बैलेंस (Balanced) हो।
        """.trimIndent(),
        english = """
            He who is strictly regulated and perfectly balanced in his habits of eating and recreation (Yuktahara-viharasya), who is highly disciplined and regulated in performing all his prescribed works and actions (Yukta-cheshtasya karmasu)...
            and who is flawlessly regulated in his sleeping and wakeful hours (Yukta-svapnavabodhasya), for such a disciplined person, this mystic Yoga system successfully becomes the absolute destroyer of all material miseries and pains (Duhkha-ha).
            After brutally striking down toxic "Extremes" in the previous verse, the Lord now delivers the exact, flawless blueprint of "What to actually do" (The Perfect Lifestyle).
            The absolute master-secret to supreme success is the word: 'Yukta' (Perfectly Balanced / Highly Regulated / Disciplined).
            1. 'Yuktahara-viharasya': Your diet must be impeccably balanced strictly according to your biological health. 'Vihara' means your recreation and downtime must also be heavily regulated (do not binge-watch TV for 10 hours, nor should you work 24/7 without rest).
            2. 'Yukta-cheshtasya karmasu': You must execute your corporate or worldly duties with perfect, regulated effort. Do not become a toxic workaholic who destroys his health and family, nor a lazy shirker. Apply 100% perfectly balanced effort.
            3. 'Yukta-svapnavabodhasya': Your sleep cycle and waking hours must operate on a strict, unbreakable, military-grade routine.
            The Lord issues a massive guarantee: For a human being who disciplines his daily lifestyle with such mechanical precision, this 'Yoga' violently and permanently incinerates absolutely all worldly stress, severe depression, and physical miseries ('Duhkha-ha').
            Meaning: If your foundational daily lifestyle is a chaotic disaster, absolutely no amount of mystical meditation or chanting will ever cure your miseries. Yoga only unlocks its godlike powers when it is planted on the rock-solid foundation of a 'Balanced Lifestyle'.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            यदा विनियतं चित्तमात्मन्येवावतिष्ठते |
            निःस्पृहः सर्वकामेभ्यो युक्त इत्युच्यते तदा || १८ ||
        """.trimIndent(),
        hindi = """
            जिस काल (समय) में योगाभ्यास के द्वारा पूरी तरह वश में किया हुआ (विनियतं) मनुष्य का चित्त (मन) केवल और केवल अपनी 'आत्मा' में ही भली-भांति स्थिर (अवतिष्ठते) हो जाता है...
            और जब वह मनुष्य सभी प्रकार की सांसारिक इच्छाओं और भोगों से पूरी तरह लालसारहित (निःस्पृहः) हो जाता है, ठीक उसी क्षण उसे 'युक्त' (यानी योग में पूरी तरह परफेक्ट/Perfect) कहा जाता है।
            लाइफस्टाइल (Lifestyle) को बैलेंस करने के बाद, भगवान अब 'परफेक्ट योगी' (The Perfected Yogi) का अंतिम सर्टिफिकेट (Final Certificate) जारी कर रहे हैं।
            हम कैसे मान लें कि किसी का 'ध्यान' (Meditation) सफल हो गया है? क्या उसके सिर पर लाइट जलने लगती है? नहीं। भगवान दो बहुत ही क्लियर साइकोलॉजिकल पैरामीटर्स (Psychological Parameters) बताते हैं:
            १. 'विनियतं चित्तम्': उसका भटकता हुआ, पागल मन अब 100% उसके कंट्रोल में है। वह मन दुनिया की चीज़ों (पैसे, लोगों) में नहीं भागता, बल्कि वह एक सुपर-ग्लू (Super-glue) की तरह केवल अपनी 'आत्मा' (Self/God) पर चिपक गया है और वहीं स्थिर रहता है।
            २. 'निःस्पृहः सर्वकामेभ्यो': यह सबसे बड़ी निशानी है। वह दुनिया की किसी भी चीज़ (सर्वकामेभ्यो) को पाने की 'लालसा' (Craving / स्पृहा) से पूरी तरह आज़ाद हो चुका है। उसे कोई फर्क नहीं पड़ता कि उसे कल क्या खाने को मिलेगा या समाज उसका कितना सम्मान करेगा।
            जब इंसान का अंदर का इंजन (मन) ईश्वर पर लॉक (Lock) हो जाए, और बाहर की दुनिया से कोई भी डिमांड (Demand) ज़ीरो (Zero) हो जाए, तब श्रीकृष्ण उसे ऑफिशियली 'युक्त' (A Master Yogi / सिद्ध पुरुष) की उपाधि दे देते हैं।
        """.trimIndent(),
        english = """
            When the yogi, through highly disciplined practice, brings his completely controlled and restrained mind (Viniyatam chittam) to settle and become perfectly situated solely within the spiritual self (Atmany evavatishthate)...
            and when he becomes utterly and permanently devoid of all cravings and desires for any material sense enjoyment (Nihsprihah sarva-kamebhyo), at that exact moment, he is officially declared to be completely perfectly situated in yoga (Yuktah).
            After perfectly regulating the external lifestyle, the Lord is now officially issuing the 'Final Graduation Certificate' of a 'Perfected Yogi'.
            How do we clinically verify if a human's 'Meditation' has actually succeeded? Does a glowing halo magically appear over his head? No. The Lord provides two brutally clear Psychological Parameters:
            1. 'Viniyatam chittam': His wild, previously chaotic, schizophrenic mind is now 100% under his absolute titanium control. The mind completely stops running after worldly trash (money, validation) and instead glues itself permanently, like industrial super-glue, exclusively upon the 'Eternal Soul' (Self/God).
            2. 'Nihsprihah sarva-kamebhyo': This is the absolute ultimate acid test. He has completely and violently eradicated every single microscopic 'Craving' (Spriha) for absolutely all material enjoyments (Sarva-kamebhyo) from his brain. He holds zero anxiety about what he will eat tomorrow or whether society will worship him.
            When a human's internal engine (the mind) flawlessly 'Locks' onto God, and his demand from the external material matrix drops to absolute Zero, Sri Krishna officially crowns him with the supreme title of 'Yuktah' (The Grandmaster Yogi).
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            यथा दीपो निवातस्थो नेङ्गते सोपमा स्मृता |
            योगिनो यतचित्तस्य युञ्जतो योगमात्मनः || १९ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार किसी हवा रहित (निवातस्थो - जहाँ हवा का एक झोंका भी न हो) स्थान पर रखा हुआ दीपक (दीपक की लौ) बिल्कुल भी हिलता-डुलता नहीं है (नेङ्गते)...
            ठीक उसी प्रकार की उपमा (तुलना) उस योगी के लिए दी गई है, जिसका मन पूरी तरह से उसके वश में (यतचित्तस्य) है और जो हमेशा अपनी आत्मा के ध्यान (योग) में मग्न रहता है।
            यह पूरी भगवद्गीता के सबसे सुंदर, काव्यात्मक (Poetic) और विज़ुअल (Visual) उदाहरणों (Analogies) में से एक है। भगवान 'ध्यान' (Concentration) की सबसे ऊँची अवस्था को एक तस्वीर में समझा रहे हैं।
            अगर आप किसी दीपक (दीये) को बाहर खुली हवा में रख दें, तो उसकी लौ (Flame) हवा के झोंकों से हमेशा फड़फड़ाती (Flicker) रहती है और कभी भी बुझ सकती है।
            हमारा साधारण मन उसी फड़फड़ाते हुए दीये की तरह है, और दुनिया की इच्छाएं, टेंशन और वासनाएं वह 'हवा' हैं जो हमारे मन को कभी टिकने नहीं देतीं।
            लेकिन जब एक योगी अपनी इन्द्रियों और विचारों की सारी 'हवा' को बंद कर देता है (अपने मन को बाहरी दुनिया से 100% काट लेता है), तो उसके दिमाग में एक 'हवा-रहित' (Windless) कमरा बन जाता है।
            उस परम शांत स्थिति में, उसके मन का फोकस (Focus) उस दीये की लौ की तरह बिल्कुल सीधा, चमकदार और 'अचल' (बिना हिले-डुले) हो जाता है।
            यही वह स्टेट (State) है जहाँ मन का सारा शोर खत्म हो जाता है और इंसान को साक्षात् 'ईश्वर' के दर्शन होते हैं। 100% लेज़र-शार्प फोकस (Laser-sharp focus) ही यह 'दीपक' है।
        """.trimIndent(),
        english = """
            Just as a blazing lamp placed in a completely windless, sheltered place absolutely does not waver or flicker even slightly (Yatha dipo nivata-stho nengate)...
            exactly so is the comparison (Upama) used to describe a highly advanced transcendentalist (Yogi) whose mind is entirely controlled (Yata-chittasya) and who remains flawlessly and steadily absorbed in meditation on the transcendent Self.
            This is universally celebrated as one of the absolute most breathtaking, poetic, and highly visual analogies in the entire Bhagavad Gita. The Lord paints a stunning masterpiece to illustrate the absolute highest peak of 'Concentration'.
            If you place a lit candle outside in the open air, its fragile flame will constantly violently flutter, dance, and flicker due to the erratic gusts of wind, always on the terrifying verge of being blown out.
            An ordinary human mind is exactly like that violently flickering flame, and the endless material desires, toxic anxieties, and worldly lusts act as the hurricane 'Winds' that never let the mind rest for a microsecond.
            But when a master Yogi forcefully shuts out all the 'Winds' of sensory inputs and desires (completely unplugging his mind from the external matrix), he creates an absolute vacuum, a 'Windless' (Nivata) titanium chamber inside his brain.
            In that profound, deafening silence, the focus of his mind stands as perfectly straight, blindingly brilliant, and 'Motionless' as a frozen flame in a windless room.
            This is the exact ultimate 'State' where all mental noise completely dies, and the human being directly witnesses the Supreme Lord. This 100% unflickering, laser-sharp focus is the 'Lamp'.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            यत्रोपरमते चित्तं निरुद्धं योगसेवया |
            यत्र चैवात्मनात्मानं पश्यन्नात्मनि तुष्यति || २० ||
        """.trimIndent(),
        hindi = """
            (श्लोक 20 से 23 तक समाधि का वर्णन है)
            जिस अवस्था में योग (ध्यान) के निरंतर अभ्यास द्वारा पूरी तरह से रोका हुआ (निरुद्धं) चित्त (मन) संसार के सभी विषयों से पूरी तरह हटकर परम शांति (उपरमते) को प्राप्त हो जाता है...
            और जिस अवस्था में वह शुद्ध हुआ मनुष्य अपनी ही शुद्ध सूक्ष्म बुद्धि (आत्मा) के द्वारा साक्षात् परमात्मा (आत्मानं) का दर्शन (पश्यन्) करता हुआ, केवल अपनी ही आत्मा में पूरी तरह संतुष्ट और मग्न (तुष्यति) रहता है...
            यहाँ से भगवान श्रीकृष्ण 'समाधि' (Samadhi - Trance) नामक उस अंतिम और सर्वोच्च अवस्था का वर्णन शुरू कर रहे हैं, जो इंसान के जीवन का अल्टीमेट गोल (Ultimate Goal) है।
            योग के अभ्यास (योगसेवया) से जब इंसान का मन बाहरी दुनिया (पैसा, रिश्ते, नाम) से पूरी तरह कट जाता है, तो मन बिल्कुल 'निरुद्ध' (Locked down / 100% Stopped) हो जाता है।
            जब मन का यह भागना रुकता है, तो इंसान को वह 'परम शांति' (उपरमते) मिलती है जिसे शब्दों में नहीं बताया जा सकता।
            और उस सन्नाटे (Silence) में क्या होता है? क्या उसे नींद आ जाती है? नहीं!
            उस समय वह अपनी 'शुद्ध चेतना' (Pure Consciousness) के रूप में जागता है और अपने ही अंदर बैठे उस अनंत 'परमात्मा' (God) का सीधा 'लाइव दर्शन' (Live Vision / पश्यन्) करता है।
            उस ईश्वर को देखकर वह इतना ज्यादा 'संतुष्ट' (तुष्यति) और आनंद से पागल हो जाता है कि फिर उसे ब्रह्मांड की कोई भी चीज़ लुभा नहीं सकती। यह आत्मा का परमात्मा से मिलन है।
        """.trimIndent(),
        english = """
            (Verses 20-23 describe the ultimate state of Samadhi)
            In that ultimate stage of perfection called trance (Samadhi), when the mind is completely restrained and permanently withdrawn from all material mental activities by the intense practice of yoga (Niruddham yoga-sevaya)...
            and in that supreme state, when the pure living entity is able to directly and flawlessly see the Supreme Self (the Lord) by the pure mind (Atmana atmanam pashyan), he rejoices and finds absolute, infinite satisfaction solely within the Self (Atmani tushyati)...
            From this exact point, Lord Sri Krishna initiates the breathtaking description of 'Samadhi' (Absolute Trance), the ultimate, supreme, and final destination of all human existence.
            Through the grueling, relentless practice of Yoga (Yoga-sevaya), when a human's mind is completely severed and unplugged from the external matrix (money, relationships, ego), the mind hits an absolute, titanium 'Lockdown' (Niruddham - 100% Stopped).
            When this chaotic mental running violently halts, the human achieves an unimaginable, staggering 'Supreme Silence' (Uparamate) that simply cannot be decoded by material words.
            And what exactly happens in that deafening silence? Does he just fall asleep into a black void? NO!
            In that exact microsecond, he aggressively awakens as 'Pure Consciousness' and scores a direct, blinding 'Live Vision' (Pashyan) of the infinite 'Supreme Lord' (Paramatma) sitting right inside his own heart.
            Upon directly beholding God, he becomes so explosively intoxicated, 'Satisfied' (Tushyati), and drowning in pure ecstasy that absolutely no treasure in the entire cosmos can ever tempt him again. This is the absolute merger of the soul with the Supreme.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            सुखमात्यन्तिकं यत्तद्बुद्धिग्राह्यमतीन्द्रियम् |
            वेत्ति यत्र न चैवायं स्थितश्चलति तत्त्वतः || २१ ||
        """.trimIndent(),
        hindi = """
            उस समाधि की अवस्था में जो असीम और अनंत आनंद (सुखमात्यन्तिकं) मिलता है, वह केवल शुद्ध बुद्धि के द्वारा ही ग्रहण किया जा सकता है (बुद्धिग्राह्यम्) और वह हमारी भौतिक इन्द्रियों की पहुँच से बिल्कुल परे (अतीन्द्रियम्) होता है।
            और जब यह योगी उस परमानंद को जान लेता है (वेत्ति), तो वह उस परम सत्य (तत्त्वतः) की अवस्था से कभी भी (एक इंच भी) विचलित (चलति) नहीं होता।
            भगवान श्रीकृष्ण यहाँ उस 'सुपर-एक्सटसी' (Super-Ecstasy / परमानंद) का वर्णन कर रहे हैं जो समाधि में मिलती है।
            हम इंसानों को लगता है कि दुनिया का सबसे बड़ा सुख पैसे, सत्ता या शारीरिक संबंधों (इन्द्रियों) से मिलता है। लेकिन भगवान कहते हैं कि वह 'इन्द्रिय सुख' बहुत ही छोटा और खत्म हो जाने वाला है।
            असली, अनंत और कभी न खत्म होने वाला सुख (आत्यन्तिकं सुखं) 'अतीन्द्रिय' है—यानी वह शरीर या इन्द्रियों से महसूस नहीं होता; वह आपकी शुद्ध आत्मा और परम बुद्धि के द्वारा महसूस होता है।
            यह एक ऐसा 'ब्रह्मांडीय नशा' (Cosmic Intoxication) है कि जब इंसान इसे एक बार चख लेता है, तो दुनिया की कोई भी पार्टी, कोई भी नशा या कोई भी दौलत उसे उस अवस्था से 'डिस्ट्रैक्ट' (Distract / विचलित) नहीं कर सकती।
            वह योगी उस परम सत्य (ईश्वर) के साथ इस तरह फेविकोल (Super-glue) की तरह चिपक जाता है कि वह उससे कभी अलग होना ही नहीं चाहता।
        """.trimIndent(),
        english = """
            In that joyous state of Samadhi, one is situated in boundless, infinite transcendental happiness (Sukham atyantikam) which is realized entirely through pure intelligence (Buddhi-grahyam) and completely transcends the physical senses (Atindriyam).
            And once the Yogi perfectly establishes and realizes himself in this supreme reality (Vetti), he absolutely never departs or deviates (Chalati) from the absolute truth (Tattvatah).
            Lord Sri Krishna is vividly describing the unimaginable 'Super-Ecstasy' and ultimate high that is unlocked in deep Samadhi.
            Ignorant humans falsely hallucinate that the absolute highest pleasure in existence is derived from billions of dollars, immense political power, or physical sexual contact (sensory pleasures). But the Lord declares that such 'sensory happiness' is pathetically tiny and inevitably expires.
            The true, infinite, and eternally climaxing ecstasy (Atyantikam Sukham) is completely 'Atindriyam'—meaning it is physically impossible to perceive it through the biological senses; it is exclusively downloaded directly into the purified spiritual intelligence and soul.
            It is such a staggering, blinding 'Cosmic Intoxication' that once a human being successfully tastes it, absolutely no wild party, no earthly drug, and no billionaire's fortune can ever 'Distract' or dislodge him from that state.
            The Yogi becomes so flawlessly and permanently locked onto the Supreme Truth (God) that he absolutely never wishes to deviate even a microscopic millimeter away from it.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            यं लब्ध्वा चापरं लाभं मन्यते नाधिकं ततः |
            यस्मिन्स्थितो न दुःखेन गुरुणापि विचाल्यते || २२ ||
        """.trimIndent(),
        hindi = """
            उस (परमानंद की) अवस्था को प्राप्त कर लेने (लब्ध्वा) के बाद, मनुष्य किसी भी दूसरे भौतिक लाभ (दौलत, सत्ता) को उससे अधिक बड़ा नहीं मानता (मन्यते नाधिकं ततः)।
            और उस परम अवस्था में स्थित हो जाने पर (यस्मिन्स्थितो), वह योगी बड़े से बड़े और सबसे भयंकर दुःखों (गुरुणापि दुःखेन) के आने पर भी बिल्कुल विचलित (विचाल्यते) नहीं होता।
            यह श्लोक 'परफेक्ट समाधि' (Perfect Trance) का सबसे बड़ा एसिड-टेस्ट (Acid-Test) और 'एंटी-वायरस' (Anti-virus) है।
            इंसान हमेशा किसी न किसी चीज़ के पीछे भागता रहता है, क्योंकि उसे लगता है कि "शायद इससे बड़ी कोई चीज़ मुझे मिल जाए।" लेकिन जब योगी भगवान को पा लेता है, तो उसकी 'खोज' (Search) हमेशा के लिए खत्म हो जाती है। 
            वह समझ जाता है कि मुझे ब्रह्मांड का 'जैकपॉट' (Jackpot) मिल गया है; अब दुनिया का कोई भी राजा अगर उसे पूरी पृथ्वी का राज्य भी दे, तो वह उसे कचरे के समान (नाधिकं) लगेगा।
            और इसका दूसरा सबसे बड़ा फायदा क्या है? 'शॉक एब्जॉर्बर' (Ultimate Shock-Absorber)।
            जिंदगी में जब कैंसर जैसी भयंकर बीमारी, दीवालियापन (Bankruptcy), या परिवार के किसी सदस्य की मौत ('गुरुणा दुःखेन' - सबसे भारी दुःख) आती है, तो आम इंसान टूट कर बिखर जाता है।
            लेकिन वह योगी एक पहाड़ की तरह अडिग रहता है। वह रोता या डिप्रेशन में नहीं जाता, क्योंकि उसकी चेतना इस नाशवान शरीर के लेवल पर है ही नहीं। दुनिया का कोई भी भारी दुःख उस योगी को हिला (विचलित कर) नहीं सकता।
        """.trimIndent(),
        english = """
            Upon gaining this supreme absolute reality (Yam labdhva), the yogi perfectly concludes that there is absolutely no higher gain or greater treasure in the entire universe (Manyate nadhikam tatah).
            And being flawlessly situated in such an exalted position (Yasmin sthitah), he is absolutely never shaken or disturbed (Vichalyate), even in the midst of the most terrifying and heaviest of all sorrows (Gurenapi duhkhena).
            This phenomenal verse acts as the absolute, ultimate 'Acid-Test' and supreme titanium 'Anti-Virus' of Perfect Samadhi.
            A normal human being is perpetually running on a never-ending hamster wheel, desperately chasing wealth and relationships because his brain constantly thinks, "Maybe there is a bigger, better prize out there." But when the Yogi attains God, his eternal 'Search' violently and permanently ends.
            He realizes he has hit the absolute 'Cosmic Jackpot'; if an emperor were to offer him the undisputed rulership of the entire earth, he would view it as worthless trash (Nadhikam).
            And what is the second, most staggering Superpower unlocked? 'The Ultimate Shock-Absorber'.
            When catastrophic tragedies like a fatal cancer diagnosis, total financial bankruptcy, or the brutal death of a loved one ('Guruna duhkhena' - the heaviest sorrows) strike, an ordinary mortal violently crumbles into suicidal depression.
            But the Yogi stands completely unfazed, exactly like an immovable granite mountain. He absolutely does not shatter, because his consciousness is completely unplugged from this temporary material matrix. Absolutely no earthly tragedy can ever shake him.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            तं विद्याद् दुःखसंयोगवियोगं योगसञ्ज्ञितम् |
            स निश्चयेन योक्तव्यो योगोऽनिर्विण्णचेतसा || २३ ||
        """.trimIndent(),
        hindi = """
            दुःख के संपर्क (संयोग) से पूरी तरह अलग (वियोग) हो जाने की अवस्था को ही वास्तव में 'योग' (योगसञ्ज्ञितम्) के नाम से जानना चाहिए (तं विद्याद्)।
            उस योग का अभ्यास पूरे दृढ़ निश्चय (निश्चयेन) के साथ और बिना थके, बिना निराश हुए (अनिर्विण्णचेतसा) उत्साहपूर्वक करना चाहिए।
            भगवान श्रीकृष्ण यहाँ 'योग' की एक और अत्यंत ही शानदार और नकारात्मक (Negative definition) परिभाषा दे रहे हैं।
            साधारणतया 'योग' का मतलब 'जुड़ना' (To Connect) होता है (यानी भगवान से जुड़ना)। लेकिन यहाँ भगवान कहते हैं कि "दुःखों से हमेशा के लिए कट जाना (वियोग/Disconnect)" ही असली योग है।
            हमारी आत्मा गलती से इस भौतिक शरीर और संसार के दुःखों के साथ 'कनेक्ट' (संयोग) हो गई है। जब हम ध्यान और ज्ञान के जरिए इस दुःख के कनेक्शन को 'काट' देते हैं, तो हम ऑटोमैटिक रूप से योग में आ जाते हैं।
            लेकिन यह 'वाइ-फाई' (Wi-Fi) का कनेक्शन एक दिन में नहीं टूटता। इसलिए भगवान एक बहुत ही ज़रूरी प्रैक्टिकल (Practical) सलाह देते हैं: "अनिर्विण्णचेतसा"।
            इसका मतलब है: "निराश मत होना!" (Do not get frustrated)।
            जब आप ध्यान (Meditation) शुरू करेंगे, तो मन 100 बार भागेगा, आप फेल (Fail) होंगे, आपको लगेगा कि यह मेरे बस की बात नहीं है। भगवान कहते हैं कि हार मत मानना! पूरी जिद (निश्चय) और असीम उत्साह के साथ रोज़ इस योग की प्रैक्टिस (Practice) करो, अंततः तुम जीत जाओगे।
        """.trimIndent(),
        english = """
            This exact supreme state of absolute severance and complete disconnection (Viyogam) from all contact with material miseries (Duhkha-samyoga) is what should actually be known as true 'Yoga' (Yoga-sanjnitam).
            This specific yoga must be practiced with absolute, iron-clad determination (Nischayena) and with a heart completely free from pessimism, depression, or frustration (Anirvinna-chetasa).
            Lord Sri Krishna is delivering another spectacularly brilliant, unconventional (Negative) definition of 'Yoga' here.
            Usually, 'Yoga' translates literally to 'Connection' (meaning to connect with God). But here, the Lord ingeniously defines it as "The absolute, permanent Disconnection (Viyoga) from all miseries."
            Our eternal soul has tragically and mistakenly 'Connected' (Samyoga) itself to the temporary physical body and its endless worldly miseries. When we violently cut and sever this toxic connection through deep meditation, we automatically achieve true Yoga.
            But hacking and destroying this deeply rooted karmic 'Wi-Fi' connection absolutely does not happen overnight. Therefore, the Lord issues a highly practical, survival command: "Anirvinna-chetasa".
            This profoundly means: "Do NOT get frustrated or depressed!" (Zero pessimism).
            When you attempt to meditate, your wild mind will run away a thousand times, you will fail miserably, and you will feel like giving up. The Lord commands: Never surrender! Practice this yoga with brutal, stubborn determination (Nischaya) and fierce enthusiasm, and you will ultimately conquer the matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            सङ्कल्पप्रभवान्कामांस्त्यक्त्वा सर्वानशेषतः |
            मनसैवेन्द्रियग्रामं विनियम्य समन्ततः || २४ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 24 और 25 एक ही प्रक्रिया का हिस्सा हैं)
            अपने स्वार्थी विचारों और संकल्पों (प्लानिंग) से पैदा होने वाली (सङ्कल्पप्रभवान्) सभी प्रकार की भौतिक इच्छाओं (कामान्) को पूरी तरह से बिना कुछ बचाए (अशेषतः) त्याग कर (त्यक्त्वा)...
            तथा अपने 'मन' के द्वारा ही (मनसैव) अपनी सभी इन्द्रियों के समूह (इन्द्रियग्रामं) को सब ओर से (समन्ततः) भली-भांति रोककर (विनियम्य / कंट्रोल करके)...
            भगवान श्रीकृष्ण यहाँ 'ध्यान' (Meditation) में उतरने की स्टेप-बाय-स्टेप (Step-by-step) प्रक्रिया बता रहे हैं।
            सबसे पहला काम है: इच्छाओं को मारना। लेकिन इच्छाएं पैदा कहाँ से होती हैं? 'संकल्प' (Sankalpa) से।
            संकल्प का मतलब है मन में बैठ कर प्लानिंग (Planning) करना कि "कल मैं यह करूँगा, फिर मुझे यह फायदा होगा, फिर मैं यह गाड़ी खरीदूँगा।" भगवान कहते हैं कि अपनी इन सारी स्वार्थी 'प्लानिंग्स' को 100% (अशेषतः) कूड़ेदान में डाल दो। एक भी इच्छा अंदर बचनी नहीं चाहिए।
            जब इच्छाएं खत्म होंगी, तभी मन शांत होगा।
            दूसरा काम है: 'मन' को एक 'डिक्टेटर' (Dictator/तानाशाह) की तरह इस्तेमाल करना। आँखें टीवी देखना चाहेंगी, कान गॉसिप (Gossip) सुनना चाहेंगे (इन्द्रियग्रामं)। तुम्हें अपने 'मन' की ताकत से इन सभी इन्द्रियों को चारों तरफ से (समन्ततः) बेरहमी से ब्लॉक (Block) करना होगा।
            अपनी इन्द्रियों को बाहर की दुनिया से पूरी तरह काट देना ही ध्यान (Focus) की पहली शर्त है।
        """.trimIndent(),
        english = """
            (Verses 24 and 25 form a continuous process)
            One must completely, entirely, and without a single exception (Asheshatah) abandon all material desires (Kaman) that are born from mental concoctions and selfish planning (Sankalpa-prabhavan)...
            and using the sheer force of the purified mind (Manasaiva), one must aggressively control and regulate the entire network of the senses (Indriya-gramam) from all sides and directions (Samantatah)...
            Lord Sri Krishna is outlining the brutal, step-by-step psychological warfare required to successfully enter deep 'Meditation' (Dhyana).
            The absolute first mandate is: Slaughter all desires. But where do desires originate? From 'Sankalpa' (Mental Planning).
            Sankalpa means sitting idle and actively fantasizing, "Tomorrow I will manipulate this, gain this massive profit, and buy that luxury car." The Lord commands you to take 100% of these toxic, selfish future 'Plannings' and violently throw them into the trash (Asheshatah). Not a single microscopic desire must be left alive.
            Once the desires are executed, the second mandate is: Turn your 'Mind' into a ruthless 'Dictator'. The physical eyes will desperately beg to see entertainment, the ears will crave toxic gossip (the network of senses). You must use the sheer, brute willpower of your 'Mind' to aggressively blockade and lock down these senses from every possible direction (Samantatah).
            Violently unplugging the physical senses from the external material matrix is the absolute foundational prerequisite for true Focus.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            शनैः शनैरुपरमेद्बुद्ध्या धृतिगृहीतया |
            आत्मसंस्थं मनः कृत्वा न किञ्चिदपि चिन्तयेत् || २५ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 24 के बाद)... इस प्रकार दृढ़ निश्चय और धैर्य से युक्त बुद्धि के द्वारा (बुद्ध्या धृतिगृहीतया), योगी को धीरे-धीरे, स्टेप-बाय-स्टेप (शनैः शनैः) अपने मन को पूरी तरह शांत (उपरमेद्) करना चाहिए।
            और अपने उस मन को पूरी तरह अपनी 'आत्मा' में ही स्थिर (आत्मसंस्थं) करके, उसे किसी भी अन्य बाहरी चीज़ के बारे में बिल्कुल कुछ भी नहीं सोचना चाहिए (न किञ्चिदपि चिन्तयेत्)।
            यह ध्यान (Meditation) का क्लाइमेक्स (Climax) है! जब इन्द्रियां बंद हो जाएं, तो अंदर मन का क्या करना है?
            भगवान एक बहुत ही प्रैक्टिकल (Practical) बात कहते हैं: "शनैः शनैः" (धीरे-धीरे)। मन कोई टीवी का स्विच (Switch) नहीं है जिसे एक सेकंड में बंद किया जा सके। 
            अगर आप मन से ज़बरदस्ती लड़ेंगे, तो वह और भड़केगा। इसलिए अपनी तेज़ और दृढ़ बुद्धि (धृतिगृहीतया) का इस्तेमाल करके, बहुत धैर्य (Patience) के साथ मन को धीरे-धीरे शांत करें।
            जब मन पूरी तरह शांत हो जाए, तो उसे खुला न छोड़ें। उस खाली मन को 'आत्मसंस्थं' करें (यानी उसे अपनी अमर आत्मा या परमात्मा के ऊपर सुपर-ग्लू की तरह चिपका दें)।
            और फिर भगवान सबसे आखिरी और सबसे कड़ा नियम बताते हैं: "न किञ्चिदपि चिन्तयेत्" (अब तुम्हें एक भी विचार नहीं सोचना है)। 
            दुनिया का कोई ख्याल—चाहे वह आपके परिवार का हो, आपके बैंक बैलेंस का हो, या खुद आपके शरीर का हो—दिमाग में नहीं आना चाहिए। 100% शून्य (Zero thoughts)! यही असली 'समाधि' है।
        """.trimIndent(),
        english = """
            (Continuing from Verse 24)... With an intelligence firmly sustained by unshakeable conviction and extreme patience (Buddhya dhriti-grihitaya), the yogi should gradually, step by step (Shanaih shanaih), bring the mind to a complete halt and absolute tranquility (Uparamet).
            And having perfectly fixed the mind purely on the spiritual Self alone (Atma-samstham), he must strictly ensure that he does not think of absolutely anything else whatsoever (Na kinchid api chintayet).
            This is the absolute grand 'Climax' of the meditative process! Once the external senses are violently locked down, what do you do with the chaotic mind inside?
            The Lord drops an incredibly practical, psychological hack: "Shanaih shanaih" (Slowly, gradually). The human mind is absolutely not a TV switch that can be brutally flicked off in one microsecond.
            If you aggressively wrestle with your mind, it will violently rebel and explode. Therefore, using your razor-sharp, patient, and titanium-willed intelligence (Dhriti-grihitaya), you must gently but firmly coax the mind into absolute silence.
            Once the mind hits total tranquility, do not leave it floating empty. Make it 'Atma-samstham' (Aggressively super-glue the mind directly onto the eternal Soul or God).
            And then, the Lord issues the final, most terrifyingly difficult rule: "Na kinchid api chintayet" (You must absolutely not generate even a single microscopic thought).
            Absolutely zero thoughts of the material matrix—not your beloved family, not your bank account, not even your own physical body—must enter your brain. 100% Absolute Zero Thoughts! This is the true definition of 'Samadhi'.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            यतो यतो निश्चरति मनश्चञ्चलमस्थिरम् |
            ततस्ततो नियम्यैतदात्मन्येव वशं नयेत् || २६ ||
        """.trimIndent(),
        hindi = """
            यह स्वभाव से ही चंचल (चञ्चलम्) और अस्थिर (भटकने वाला) मन जहाँ-जहाँ भी (यतो यतो) भागकर सांसारिक विषयों में जाता है...
            योगी को चाहिए कि वह अपने मन को वहाँ-वहाँ से (ततस्ततो) खींचकर वापस लाए (नियम्य), और उसे बलपूर्वक अपनी आत्मा (ईश्वर) के ही पूर्ण नियंत्रण में करे (आत्मन्येव वशं नयेत्)।
            ध्यान करने वाले हर साधक की सबसे बड़ी समस्या (Problem) का यह एकमात्र इलाज (Solution) है।
            जब इंसान आँखें बंद करके ध्यान (Meditate) करने बैठता है, तो उसका मन 5 मिनट भी एक जगह नहीं टिकता। वह अचानक ऑफिस, किसी की कही हुई बुरी बात, या खाने-पीने की चीज़ों (यतो यतो) की तरफ भाग जाता है।
            श्रीकृष्ण इसे डांटते नहीं हैं, वे स्वीकार करते हैं कि मन का 'नेचर' (Nature) ही चंचल और अस्थिर (चञ्चलम् अस्थिरम्) है। यह उसका सॉफ्टवेयर (Software) है।
            लेकिन भगवान का आदेश (Order) बहुत सख्त है। वे कहते हैं: "तुम हार मत मानो!"
            तुम्हारा मन जहाँ भी भागे, एक सख्त 'सिक्योरिटी गार्ड' (Security Guard) की तरह उसे वहाँ से पकड़ कर ('ततस्ततो नियम्य') वापस लाओ। अगर मन 100 बार भागे, तो 100 बार उसे कॉलर (Collar) से पकड़ कर वापस 'आत्मा' (ईश्वर के ध्यान) पर बिठाओ।
            यही खींच-तान का जो संघर्ष (Struggle) है, वही 'अभ्यास' (Practice) है। इसी लगातार अभ्यास से एक दिन यह जिद्दी मन हार मान लेगा और हमेशा के लिए आत्मा का गुलाम (वशं) बन जाएगा।
        """.trimIndent(),
        english = """
            From whatever and wherever (Yato yato) the highly restless (Chanchalam) and totally unsteady (Asthiram) mind violently wanders and runs away due to its flickering nature...
            the yogi must forcefully drag it back from all those very locations (Tatas tato niyamya) and bring it strictly back under the absolute control of the Self alone (Atmany eva vasham nayet).
            This verse provides the absolute, singular 'Ultimate Solution' to the greatest, most frustrating problem faced by every single meditation practitioner in the world.
            When a human closes his eyes to meditate, the mind absolutely refuses to sit still even for 5 minutes. It violently escapes and runs wildly towards past traumas, corporate office stress, or sexual fantasies (Yato yato).
            Sri Krishna absolutely does not scold the Yogi for this; He officially acknowledges that the fundamental 'Nature' (Software) of the mind is 'Chanchalam Asthiram' (inherently restless, flickering, and unsteady).
            But the Lord's counter-order is fiercely strict: "Do not surrender to it!"
            Wherever your rogue mind escapes to, you must act exactly like an aggressive, titanium 'Security Guard'. Violently grab it by the collar ('Tatas tato niyamya') and drag it kicking and screaming back to the center. If it escapes 1,000 times, you must drag it back 1,000 times and force it to sit entirely on the 'Soul' (God).
            This exhausting, brutal psychological tug-of-war is the exact definition of 'Practice'. Through this relentless warfare, the stubborn mind will eventually break and become the permanent, submissive slave of the soul.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            प्रशान्तमनसं ह्येनं योगिनं सुखमुत्तमम् |
            उपैति शान्तरजसं ब्रह्मभूतमकल्मषम् || २७ ||
        """.trimIndent(),
        hindi = """
            जिस योगी का मन पूरी तरह से अत्यंत शांत (प्रशान्तमनसं) हो चुका है, जिसके मन से 'रजोगुण' (वासनाओं और लालच की चंचलता) पूरी तरह शांत (खत्म) हो चुका है (शान्तरजसं)...
            और जो पापों से पूरी तरह मुक्त (अकल्मषम्) होकर साक्षात् 'ब्रह्म' (ईश्वर के समान शुद्ध) रूप हो चुका है (ब्रह्मभूतम्), ऐसे उस महान योगी को निश्चित रूप से 'उत्तम सुख' (परमानंद) की प्राप्ति होती है (उपैति)।
            जब एक योगी 26वें श्लोक की उस भयंकर 'खींच-तान' (Mind-control struggle) को जीत लेता है, तो उसे यह अकल्पनीय 'रिवॉर्ड' (Reward / इनाम) मिलता है।
            उसका मन जो पहले तूफानी था, अब एक बिना लहरों वाली गहरी झील की तरह 100% 'प्रशांत' (Supreme Peace) हो जाता है।
            उसकी शांति का कारण क्या है? 'शान्तरजसम्' (रजोगुण का अंत)। रजोगुण इंसान को लालच, वासना और पैसे के पीछे पागलों की तरह भगाता है। जब यह रजोगुण मर जाता है, तो भाग-दौड़ खत्म हो जाती है और इंसान रिलैक्स (Relax) हो जाता है।
            उसके सारे पाप ('कल्मष') भस्म हो जाते हैं, और उसका चेतना का स्तर इतना ऊपर उठ जाता है कि वह इंसान होकर भी 'ब्रह्मभूत' (God-like) बन जाता है।
            इस ईश्वरीय अवस्था में उसे दुनिया का कोई टेंपररी (Temporary) सुख नहीं मिलता, बल्कि उसे 'उत्तम सुख' (The Ultimate, Supreme Bliss) मिलता है। यह वह आनंद है जिसे दुनिया का कोई भी नशा या पैसा कभी नहीं खरीद सकता; यह शुद्ध अध्यात्म (Spirituality) का नशा है।
        """.trimIndent(),
        english = """
            The yogi whose mind has become supremely pacified and flawlessly tranquil (Prashanta-manasam), whose passions and restless mode of material desires (Rajo-guna) are completely completely silenced (Shanta-rajasam)...
            and who has become utterly freed from all sins (Akalmasham), having achieved qualitative identity with the Supreme (Brahma-bhutam)—such a grandmaster undeniably attains the absolute highest, supreme transcendental bliss (Sukham uttamam upaiti).
            When a Yogi successfully wins the brutal psychological tug-of-war detailed in Verse 26, the Supreme Lord officially grants him this unimaginable, cosmic 'Ultimate Reward'.
            His mind, which was previously a chaotic hurricane, instantly transforms into a 100% perfectly still, waveless, bottomless lake of 'Prashanta' (Supreme Peace).
            What is the exact biological and spiritual reason for this peace? 'Shanta-rajasam' (The complete assassination of Rajo-guna). The mode of passion (Rajas) is the toxic engine that aggressively forces humans to run madly after greed, lust, and billions of dollars. When this toxic engine is permanently destroyed, the frantic running stops, and absolute relaxation kicks in.
            All his accumulated karmic sins ('Kalmasha') are violently incinerated, and his consciousness elevates to such a staggering altitude that, despite being in a human body, he becomes 'Brahma-bhutam' (Qualitatively God-like).
            In this divine dimension, he does not experience cheap, temporary worldly thrills; he unlocks 'Sukham Uttamam' (The Absolute Supreme Bliss). This is an intoxicating ecstasy that absolutely no earthly drug or infinite wealth can ever purchase; it is the ultimate high of pure spirituality.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            युञ्जन्नेवं सदात्मानं योगी विगतकल्मषः |
            सुखेन ब्रह्मसंस्पर्शमत्यन्तं सुखमश्नुते || २८ ||
        """.trimIndent(),
        hindi = """
            इस प्रकार ऊपर बताए गए तरीके से निरंतर (सदा) अपनी आत्मा (मन) को परमात्मा में लगाने वाला (युञ्जन्नेवं), और सभी पापों से पूरी तरह मुक्त हुआ (विगतकल्मषः) वह महान योगी...
            बहुत ही आसानी से (सुखेन) उस परब्रह्म परमात्मा के साक्षात् स्पर्श (मिलन) से उत्पन्न होने वाले असीम और अत्यंत (Infinite) आनंद को हमेशा भोगता है (अत्यन्तं सुखमश्नुते)।
            यह श्लोक 'परम सिद्धि' (Ultimate Perfection) का साक्षात् वर्णन है।
            श्रीकृष्ण बताते हैं कि जब योगी सारे पापों (वासनाओं और लालच) से आज़ाद ('विगतकल्मषः') हो जाता है, तो उसे ध्यान लगाने के लिए कोई स्ट्रगल (Struggle) या संघर्ष नहीं करना पड़ता।
            अब उसका योग (ध्यान) 'सुखेन' (बहुत ही नैचुरल और आसानी से / Effortlessly) हो जाता है।
            और उसे ध्यान में क्या मिलता है? 'ब्रह्म-संस्पर्श'! (The physical and spiritual TOUCH of God)।
            यह कोई काल्पनिक (Imaginary) चीज़ नहीं है। जब आत्मा उस अनंत ईश्वर को सीधे 'छूती' है (अनुभव करती है), तो उस 'कनेक्शन' से जो करंट (Current) या आनंद पैदा होता है, वह 'अत्यन्तं सुखम्' (Infinite, Mind-blowing Bliss) होता है।
            साधारण इंसान भौतिक चीज़ों (पैसे, शरीर) को छूकर सुख ढूंढता है जो कुछ सेकंड में खत्म हो जाता है। लेकिन योगी सीधा 'ईश्वर' को छूता है, और वह ऐसा नशा है जो हमेशा के लिए इंसान को परमानंद (Ecstasy) में डुबा देता है।
        """.trimIndent(),
        english = """
            Thus engaging himself continuously in this flawless practice of yoga (Yunjann evam sada), that highly elevated yogi, entirely freed from all material contamination and sins (Vigata-kalmashah)...
            effortlessly and joyfully (Sukhena) achieves the absolute highest, infinite, and staggering stage of perfect happiness (Atyantam sukham ashnute) resulting directly from his continuous intimate touch and contact with the Supreme Brahman (Brahma-samsparsham).
            This spectacular verse vividly describes the absolute 'Ultimate Perfection' of a self-realized Yogi.
            Sri Krishna explains that when the Yogi finally becomes 100% 'Vigata-kalmashah' (permanently freed from the heavy, toxic baggage of all sins, lust, and greed), he absolutely no longer has to violently struggle or fight with his brain to meditate.
            Now, his meditation operates entirely 'Sukhena' (Effortlessly, naturally, and highly joyfully).
            And what is the ultimate prize he accesses during this deep trance? 'Brahma-samsparsham'! (The literal, direct, experiential TOUCH and contact with the Supreme Godhead).
            This is absolutely not some vague psychological hallucination. When the pure eternal soul directly 'Touches' (Plugs into) the infinite Supreme Lord, the cosmic voltage generated from that exact connection results in 'Atyantam Sukham' (Infinite, staggering, mind-blowing Bliss).
            An ignorant mortal constantly tries to extract cheap pleasure by 'touching' temporary physical bodies and dead material objects. But the elite Yogi directly touches the 'Supreme Lord' Himself, plunging into an eternal ocean of blinding ecstasy that never ends.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            सर्वभूतस्थमात्मानं सर्वभूतानि चात्मनि |
            ईक्षते योगयुक्तात्मा सर्वत्र समदर्शनः || २९ ||
        """.trimIndent(),
        hindi = """
            जिसका मन पूर्ण रूप से योग में स्थित है (योगयुक्तात्मा), और जिसकी दृष्टि (नज़र) हर जगह और हर किसी में पूरी तरह से समान (भेदभाव-रहित) हो चुकी है (सर्वत्र समदर्शनः)...
            ऐसा वह महापुरुष अपनी ही आत्मा (परमात्मा) को ब्रह्मांड के सभी प्राणियों में स्थित देखता है (सर्वभूतस्थमात्मानं), और ब्रह्मांड के सभी प्राणियों को अपनी आत्मा (ईश्वर) के ही भीतर स्थित देखता है (सर्वभूतानि चात्मनि)।
            यहाँ भगवान श्रीकृष्ण 'सुप्रीम विज़न' (Supreme Vision / गॉड-आई / God-Eye) का वर्णन कर रहे हैं जो एक सिद्ध योगी को प्राप्त होती है।
            साधारण इंसान हमेशा 'भेदभाव' (Discrimination) करता है: "यह हिंदू है, यह मुसलमान है, यह इंसान है, यह कुत्ता है, यह दोस्त है, यह दुश्मन है।" हम दुनिया को उसके 'बाहरी शरीर' (Cover/Hardware) से देखते हैं।
            लेकिन जब इंसान 'योगयुक्तात्मा' (ईश्वर में 100% लीन) हो जाता है, तो उसे 'समदर्शनः' (Universal Equal Vision) की सुपरपावर (Superpower) मिल जाती है।
            उसकी आँखें 3D दुनिया से हटकर 'स्पिरिचुअल डायमेंशन' (Spiritual Dimension) में खुल जाती हैं। 
            १. वह देखता है कि जो 'आत्मा' (ईश्वर का अंश) मेरे अंदर धड़क रही है, बिल्कुल वही सेम (Same) आत्मा सामने वाले एक गरीब भिखारी, एक चींटी, और एक दुश्मन के अंदर भी मौजूद है।
            २. और वह यह भी देखता है कि यह पूरी की पूरी सृष्टि (सारे ग्रह, इंसान, जानवर) कहीं और नहीं, बल्कि उस एक ही अनंत 'परमात्मा' (ईश्वर) के भीतर तैर रहे हैं।
            जब आप हर चीज़ में भगवान को देखेंगे, और भगवान के अंदर हर चीज़ को देखेंगे, तो आप दुनिया में किसी से नफरत कैसे कर सकते हैं? यही 'अद्वैत' (Oneness) का चरम शिखर है।
        """.trimIndent(),
        english = """
            A true yogi perfectly united with the Supreme (Yoga-yuktatma), whose vision has become entirely equal and flawless everywhere (Sarvatra sama-darshanah)...
            clearly and unhesitatingly sees the Supreme Soul (or his own true self) situated identically in all living beings across the universe (Sarva-bhuta-stham atmanam), and he perfectly sees every single living being situated right within the Supreme Soul (Sarva-bhutani chatmani).
            Lord Sri Krishna is vividly revealing the absolute 'Supreme Vision' (God-Eye / Cosmic Consciousness) granted to a fully perfected, enlightened Yogi.
            An ordinary, ignorant mortal violently operates on toxic 'Discrimination': "He is my friend, he is my enemy, he is rich, this is a dog." We pathetically judge the universe strictly by its superficial 'Biological Hardware' (the external body).
            But when a human successfully upgrades to a 'Yoga-yuktatma' (100% absorbed in God), he instantly unlocks the staggering superpower of 'Sama-darshanah' (Universal Equal Vision).
            His vision forcefully transcends the 3D material matrix and directly perceives the underlying 'Spiritual Dimension'.
            1. He flawlessly perceives that the exact same eternal 'Soul' (spark of God) powering his own biological machine is identically powering a billionaire, a stray dog, and a terrifying enemy.
            2. Furthermore, he directly witnesses that this entire colossal material universe (all planets, galaxies, and living entities) is not floating randomly in space, but is actually existing and swimming perfectly right inside the infinite body of the 'Supreme Lord'.
            When a human being literally sees God in every single atom, and every single atom inside God, how can he possibly hate anyone? This is the absolute ultimate peak of 'Advaita' (Cosmic Oneness).
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            यो मां पश्यति सर्वत्र सर्वं च मयि पश्यति |
            तस्याहं न प्रणश्यामि स च मे न प्रणश्यति || ३० ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य मुझे (परमेश्वर को) हर जगह (सभी प्राणियों और वस्तुओं में) देखता है (यो मां पश्यति सर्वत्र), और जो कुछ भी इस ब्रह्मांड में मौजूद है, उन सबको केवल मुझमें (ईश्वर में) ही देखता है (सर्वं च मयि पश्यति)...
            उसके लिए मैं कभी भी अदृश्य (नष्ट/दूर) नहीं होता (तस्याहं न प्रणश्यामि), और वह भी मेरी दृष्टि से कभी अदृश्य (दूर) नहीं होता (स च मे न प्रणश्यति)।
            यह पूरी भगवद्गीता के सबसे 'रोमांटिक' (Romantic), भक्तिपूर्ण और भगवान के सीधे 'प्रॉमिस' (Promise) से भरे श्लोकों में से एक है।
            श्रीकृष्ण एक बहुत ही खूबसूरत और पर्सनल गारंटी (Personal Guarantee) दे रहे हैं।
            जब एक भक्त की आँखें प्यार से इतनी भर जाती हैं कि उसे पेड़ों में, हवा में, अपने परिवार में, और यहाँ तक कि अपने दुश्मनों में भी केवल 'कृष्ण' ही 'कृष्ण' दिखाई देते हैं...
            और उसे यह पक्का एहसास हो जाता है कि यह पूरी दुनिया भगवान के ही अंदर बसी हुई है; तो भगवान उसके साथ एक ऐसा अटूट और परमानेंट 'रिलेशनशिप' (Relationship) बना लेते हैं जो कभी नहीं टूटता।
            "मैं उसके लिए कभी नहीं खोता!"—यानी चाहे वह भक्त कितनी भी बड़ी मुसीबत में हो, युद्ध में हो, या मौत के बिस्तर पर हो, भगवान हमेशा उसके बिल्कुल सामने (साक्षात) खड़े रहते हैं। भगवान उसे कभी अकेला नहीं छोड़ते।
            "और वह मेरे लिए कभी नहीं खोता!"—यानी करोड़ों लोगों की भीड़ में भी भगवान की नज़र हमेशा 24/7 केवल उसी भक्त पर टिकी रहती है। भगवान उसे अपनी नज़रों से एक सेकंड के लिए भी ओझल नहीं होने देते। यह ईश्वर और भक्त के बीच सबसे असीम प्रेम की गारंटी है।
        """.trimIndent(),
        english = """
            For one who clearly sees Me everywhere and in every single thing (Yo mam pashyati sarvatra), and who flawlessly sees everything existing entirely within Me (Sarvam cha mayi pashyati)...
            I am absolutely never lost to him or hidden from his vision (Tasyaham na pranashyami), nor is he ever lost to Me or out of My sight (Sa cha me na pranashyati).
            This is universally celebrated as one of the most incredibly 'Romantic', intensely devotional, and breathtakingly personal 'Guarantee' verses in the entire Bhagavad Gita.
            Lord Sri Krishna is issuing a profoundly beautiful, intimate, and iron-clad cosmic promise to His pure devotee.
            When a devotee's heart is so violently flooded with pure spiritual love that he literally sees only 'Krishna' functioning inside the trees, the oceans, his family members, and even his most bitter enemies...
            and when he practically realizes that this entire universe is safely nested right inside God's body, the Supreme Lord instantly establishes an unbreakable, permanent 'Personal Relationship' with him.
            "I am absolutely never lost to him!"—Meaning, whether that devotee is burning in a horrific crisis, fighting a bloody world war, or lying on his terrifying deathbed, the Supreme Lord stands visibly and powerfully right in front of his eyes. God absolutely never abandons him to the dark matrix.
            "And he is absolutely never lost to Me!"—Meaning, out of billions of souls, the Supreme Lord's divine, protective gaze is permanently locked onto that specific devotee 24/7. God refuses to let him out of His sight for even a microsecond. This is the ultimate, supreme promise of infinite divine protection and love.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            सर्वभूतस्थितं यो मां भजत्येकत्वमास्थितः |
            सर्वथा वर्तमानोऽपि स योगी मयि वर्तते || ३१ ||
        """.trimIndent(),
        hindi = """
            जो योगी 'एकत्व' (अद्वैत भाव / सबमें एक ही ईश्वर है, इस भाव) में पूरी तरह स्थित होकर...
            सभी प्राणियों के हृदय में स्थित मुझ परमात्मा को ही प्रेम से भजता है (पूजता है - भजति)...
            वह योगी संसार के सभी प्रकार के कर्मों को करते हुए भी (सर्वथा वर्तमानोऽपि), वास्तव में हमेशा मुझमें ही (ईश्वर में ही) निवास करता है (मयि वर्तते)।
            यह श्लोक 'ज्ञान' (Knowledge) और 'भक्ति' (Devotion) का सबसे परफेक्ट कॉम्बिनेशन (Perfect Combination) है।
            एक योगी को केवल यह 'जानना' नहीं है कि सबके अंदर भगवान हैं; उसे इस ज्ञान के साथ-साथ हर जीव की 'सेवा और प्रेम' (भजति) भी करना है।
            जब इंसान को यह एहसास हो जाता है कि सामने वाला गरीब इंसान या जानवर भी ईश्वर का ही चलता-फिरता मंदिर है, तो वह किसी को धोखा नहीं दे सकता, किसी को गाली नहीं दे सकता। वह सबसे 'एकत्व' (Oneness / एकता) का भाव रखता है।
            ऐसे इंसान के लिए भगवान एक बहुत बड़ा सर्टिफ़िकेट (Certificate) देते हैं।
            दुनिया को लगता है कि भगवान को पाने के लिए हिमालय में जाकर बैठना पड़ेगा। लेकिन भगवान कहते हैं, "सर्वथा वर्तमानोऽपि"—वह इंसान चाहे राजनीति कर रहा हो, बिज़नेस कर रहा हो, या शादी-शुदा ज़िंदगी जी रहा हो...
            अगर उसकी भावना हर जीव में मुझे देखने की है, तो वह जहाँ भी खड़ा है, वह भौतिक दुनिया में नहीं, बल्कि सीधे 'मुझमें' (Vaikuntha / ईश्वर के हृदय में) ही जी रहा है। भगवान ऐसे कर्मयोगी को सन्यासियों से भी श्रेष्ठ मानते हैं।
        """.trimIndent(),
        english = """
            Such a supreme yogi, being perfectly situated in absolute oneness (Ekatvam ashthitah), engages in the pure devotional service and worship of Me, knowing Me to be situated within the hearts of all living beings (Sarva-bhuta-sthitam yo mam bhajati).
            Such a highly elevated yogi, regardless of whatever diverse worldly circumstances or activities he may remain engaged in (Sarvatha vartamano 'pi), in truth continually resides solely in Me (Sa yogi mayi vartate).
            This spectacular verse operates as the absolute 'Perfect Combination' and ultimate fusion of 'Jnana' (Supreme Knowledge) and 'Bhakti' (Pure Devotion).
            It is absolutely not enough for a Yogi to merely 'intellectualize' that God resides in everyone; he must actively translate that profound knowledge into offering pure 'Love and Service' (Bhajati) to all living entities.
            When a human being experientially realizes that the poor beggar on the street or a stray animal is a literal, walking, breathing temple of the Supreme Lord, he can absolutely never cheat, abuse, or hate anyone. He operates purely on the frequency of 'Ekatvam' (Cosmic Oneness).
            For such a superhuman entity, the Lord issues a massive, revolutionary Certificate of Liberation.
            Ignorant society dictates that to live in God, one must abandon the city and sit silently in the freezing Himalayas. But the Lord declares, "Sarvatha vartamano 'pi"—Even if that Yogi is aggressively running a global corporation, engaging in hardcore politics, or raising a massive family...
            if his underlying consciousness perceives God in everyone, he is absolutely not living in the toxic material matrix; he is physically and spiritually residing directly "Inside ME" (within the heart of God / Vaikuntha). The Lord considers such an active, loving Yogi superior to passive monks.
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            आत्मौपम्येन सर्वत्र समं पश्यति योऽर्जुन |
            सुखं वा यदि वा दुःखं स योगी परमो मतः || ३२ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! जो योगी अपनी ही आत्मा के समान (आत्मौपम्येन) तुलना करके, संसार के सभी प्राणियों में हर जगह (सर्वत्र) बिल्कुल समानता (समं) देखता है...
            अर्थात् जो दूसरों के सुख (सुखं) और दूसरों के दुःख (दुःखं) को बिल्कुल अपना ही सुख और दुःख मानता है, मेरी नज़र में वह योगी परम श्रेष्ठ (परमो मतः) है।
            यह श्लोक 'एम्पैथी' (Empathy) और 'करुणा' (Compassion) का पूरी दुनिया का सबसे महान और सर्वोच्च नियम (Golden Rule) है।
            भगवान श्रीकृष्ण बता रहे हैं कि उनके हिसाब से दुनिया का सबसे 'बेस्ट योगी' (The Ultimate Best Yogi) कौन है। वह नहीं जो पानी पर चल सकता हो या जो महीनों तक भूखा रह सकता हो!
            सबसे बड़ा योगी वह है जो दूसरों के दर्द को ऐसे महसूस करता है जैसे वह उसका खुद का दर्द हो ('आत्मौपम्येन')।
            साधारण इंसान बहुत स्वार्थी होता है। जब उसके खुद के पैर में कांटा चुभता है, तो वह रोता है; लेकिन जब किसी दूसरे के पैर में कांटा चुभता है, तो वह उसे इग्नोर (Ignore) कर देता है।
            लेकिन 'परम योगी' यह जानता है कि जैसे मुझे दर्द होता है, वैसे ही हर जीव (यहाँ तक कि जानवर) को भी दर्द होता है। वह किसी भी जीव को दुःख नहीं पहुँचाता और सबके सुख में खुश होता है।
            जो व्यक्ति पूरी मानव जाति और जीवों के साथ इतना गहराई से जुड़ चुका है कि उनका दर्द उसे अपना दर्द लगता है, भगवान डिक्लेयर (Declare) करते हैं कि वही मेरा सबसे प्रिय और 'परम' (Supreme) योगी है।
        """.trimIndent(),
        english = """
            O Arjuna! He who measures and perceives the true equality of all living beings everywhere (Sarvatra samam pashyati) entirely by comparison to his own self (Atmaupamyena)...
            and who perceives the happiness (Sukham) and the distress (Duhkham) of others strictly as his very own, that specific yogi is officially considered by Me to be the absolute highest and most supreme of all (Paramo matah).
            This verse is universally hailed as the absolute, undisputed 'Golden Rule' and supreme zenith of 'Empathy' and 'Cosmic Compassion' in the history of the world.
            Lord Sri Krishna is explicitly declaring exactly who He considers to be the absolute 'Best Yogi in the Universe' (The Ultimate Master). It is absolutely not the mystical wizard who can walk on water, levitate, or starve for 6 months!
            The undisputed Supreme Yogi is that ultra-rare human being who physically and emotionally feels the agonizing pain of others exactly as if it were his own intense personal pain ('Atmaupamyena').
            An ordinary, ignorant mortal is highly toxic and brutally selfish. When a thorn pierces his own foot, he violently cries in agony; but when a thorn pierces someone else's foot, he callously ignores it.
            But the 'Parama Yogi' possesses the profound scientific realization that the exact same intense pain and joy he feels is identically felt by every single living entity (even tiny animals). Therefore, he never harms a fly and actively rejoices in the success of others.
            A human being who is so staggeringly connected to the universal soul that the world's pain becomes his own personal pain is officially declared by the Supreme Lord as His most beloved and 'Supreme' (Paramo) Yogi.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            अर्जुन उवाच |
            योऽयं योगस्त्वया प्रोक्तः साम्येन मधुसूदन |
            एतस्याहं न पश्यामि चञ्चलत्वात्स्थितिं स्थिराम् || ३३ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने कहा: हे मधुसूदन! आपने मन की समानता (समभाव / साम्येन) वाले जिस योग का वर्णन अभी-अभी किया है...
            मन के अत्यंत चंचल (चञ्चलत्वात्) और अस्थिर होने के कारण, मैं इस योग की किसी पक्की और स्थायी स्थिति (स्थितिं स्थिराम्) को नहीं देख पा रहा हूँ (अर्थात् मुझे यह व्यावहारिक या प्रैक्टिकल नहीं लग रहा है)।
            भगवान श्रीकृष्ण ने पिछले कई श्लोकों में 'परफेक्ट माइंड कंट्रोल' (Perfect Mind Control) और हर हाल में 'समभाव' (समान रहने) की बहुत ऊँची फिलॉसफी समझाई।
            अर्जुन कोई अंधभक्त नहीं हैं; वे एक अत्यंत प्रैक्टीकल (Practical) और सीधे बात करने वाले योद्धा हैं। वे तुरंत बीच में टोकते हैं!
            अर्जुन कहते हैं: "हे कृष्ण! आपने जो यह थ्योरी (Theory) बताई कि इंसान को सुख-दुःख, सोने-मिट्टी और दोस्त-दुश्मन में एकदम 'समान' रहना चाहिए, यह सुनने में तो बहुत ही शानदार (Ideal) लग रही है।"
            "लेकिन रियलिटी (Reality) यह है कि यह 'इंसानी मन' (Human Mind) बहुत ही ज्यादा चंचल और भागने वाला है। इस पागल मन को इतनी शांति में और इतनी लंबी अवधि तक 'स्थिर' (Stable) रखना मुझे इंसान के बस की बात नहीं लग रही है।"
            अर्जुन का यह डाउट (Doubt) दुनिया के हर उस इंसान का डाउट है जो ध्यान (Meditation) या अध्यात्म शुरू करता है। सबको लगता है कि भगवान की बातें किताबी हैं और असल ज़िंदगी में मन को कंट्रोल करना नामुमकिन है।
        """.trimIndent(),
        english = """
            Arjuna honestly objected: O Madhusudana! This profound system of yoga which You have just comprehensively summarized, centered entirely on absolute equanimity and sameness of mind (Samyena)...
            I simply cannot see any practical possibility of its steady, enduring endurance (Sthitim sthiram), precisely because the human mind is intensely restless and violently flickering by nature (Chanchalatvat).
            In the preceding verses, Lord Sri Krishna delivered an incredibly lofty, high-altitude philosophy detailing 'Perfect Mind Control' and existing in a state of flawless 'Equanimity' (Samatvam) under all extreme conditions.
            Arjuna is absolutely not a blind, unquestioning follower; he is a highly pragmatic, brutally honest, straight-talking elite warrior. He instantly interrupts the Lord!
            Arjuna essentially argues: "O Krishna! This spectacular, utopian Theory You just preached—demanding that a human remain flawlessly equal in joy and tragedy, seeing gold and dirt identically, and loving enemies like friends—sounds absolutely magnificent on paper."
            "But the brutal 'Reality' on the ground is that this biological 'Human Mind' is violently, intensely restless, chaotic, and schizophrenic by default. Keeping this mad, hurricane-like mind 'Stable' (Sthiram) in such a frozen state of peace for a long period seems practically and biologically impossible for any mortal to me."
            Arjuna's piercing doubt perfectly echoes the desperate frustration of every single human being on earth who has ever attempted to meditate or control their addictions. Everyone initially feels that these spiritual demands are theoretically beautiful but practically impossible to execute.
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            चञ्चलं हि मनः कृष्ण प्रमाथि बलवद्दृढम् |
            तस्याहं निग्रहं मन्ये वायोरिव सुदुष्करम् || ३४ ||
        """.trimIndent(),
        hindi = """
            क्योंकि हे कृष्ण! यह मन बहुत ही ज्यादा चंचल (चञ्चलं), मथ डालने वाला (प्रमाथि - तूफानी), अत्यंत जिद्दी और बलवान (बलवद्दृढम्) है।
            इसलिए, इस भयंकर मन को वश में करना (निग्रहं), मुझे तो हवा (वायु) को मुट्ठी में बांधने से भी ज्यादा मुश्किल और असंभव (सुदुष्करम्) लगता है।
            यह भगवद्गीता के सबसे 'रिलेटेबल' (Relatable) और इंसानी साइकोलॉजी (Human Psychology) का सबसे सटीक वर्णन करने वाले श्लोकों में से एक है।
            अर्जुन मन की 4 सबसे खतरनाक बीमारियां (Features) बता रहे हैं:
            १. 'चञ्चलं' (Restless): यह एक बंदर की तरह है जो एक सेकंड भी टिक कर नहीं बैठ सकता, यह हमेशा एक विचार से दूसरे विचार पर छलांग मारता रहता है।
            २. 'प्रमाथि' (Turbulent): यह कोई शांत बंदर नहीं है; यह एक ऐसा तूफान है जो इंसान की सारी अच्छी बुद्धि और लॉजिक (Logic) को मथ कर (Crush करके) रख देता है। (जैसे गुस्से या वासना के समय)।
            ३. 'बलवत्' (Powerful): यह मन इतना ताकतवर है कि बड़े-बड़े तपस्वियों और ज्ञानियों को भी अपने घुटनों पर ला देता है।
            ४. 'दृढम्' (Stubborn/जिद्दी): अगर आप मन से कहेंगे कि "मुझे इस बुरी आदत को छोड़ना है", तो मन और ज्यादा ज़िद करेगा उसी काम को करने की।
            अर्जुन एक बहुत ही शानदार उदाहरण देते हैं: "हे कृष्ण! अगर आप मुझे भयंकर तूफानी 'हवा' (Hurricane) को अपनी मुट्ठी में कैद करने को कहें, तो शायद मैं अपने तीरों से वह भी कर लूँ; लेकिन इस 'मन' को कंट्रोल करना मुझे हवा को रोकने से भी ज्यादा 'इम्पॉसिबल' (Impossible) लग रहा है!"
        """.trimIndent(),
        english = """
            For the human mind is undeniably incredibly restless (Chanchalam), turbulent and violently churning (Pramathi), exceptionally obstinate, and staggeringly powerful (Balavad dridham), O Krishna.
            Therefore, I personally consider forcefully subduing and successfully controlling this mind (Nigraham) to be far more difficult and impossible (Sudushkaram) than trying to catch and control the raging, blowing wind (Vayor iva).
            This is undeniably one of the most universally 'Relatable', brutally honest, and flawlessly accurate psychological verses defining the human condition in the entire Gita.
            Arjuna expertly diagnoses the 4 most terrifying, default features of the human operating system (The Mind):
            1. 'Chanchalam' (Restless): It behaves exactly like a hyperactive monkey; it absolutely refuses to sit still for even a microsecond, violently swinging from one random thought to another.
            2. 'Pramathi' (Turbulent): It is not just restless; it is a violent, churning hurricane that aggressively crushes and overpowers a human's rational logic and good sense (especially during intense anger or lust).
            3. 'Balavat' (Staggeringly Powerful): This mind is so brutally strong that it effortlessly brings the world's most disciplined monks, scholars, and elite warriors to their knees.
            4. 'Dridham' (Obstinate/Stubborn): If you aggressively command your mind, "Stop doing this toxic habit!", the mind acts like a stubborn rebel and violently pushes you to do it even more.
            Arjuna drops an incredibly spectacular analogy: "O Krishna! If You command me to physically catch a raging Category 5 'Hurricane' (Vayu) and lock it inside my bare fist, I might actually achieve that using my mystical arrows; but subduing this rogue 'Mind' feels infinitely more 'Impossible' and difficult to me than stopping the wind!"
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            श्रीभगवानुवाच |
            असंशयं महाबाहो मनो दुर्निग्रहं चलम् |
            अभ्यासेन तु कौन्तेय वैराग्येण च गृह्यते || ३५ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे महाबाहु (अर्जुन)! इसमें कोई शक नहीं (असंशयं) है कि यह मन अत्यंत चंचल (चलम्) है और इसे कंट्रोल करना (निग्रह करना) बहुत ही ज्यादा मुश्किल (दुर्निग्रहं) है।
            परंतु हे कुन्तीपुत्र (कौन्तेय)! लगातार 'अभ्यास' (Practice) करने से, और 'वैराग्य' (Detachment / संसार से मोह तोड़ने) के द्वारा, इस भयंकर मन को भी वश में (कंट्रोल) किया जा सकता है (गृह्यते)।
            जब एक शिष्य अपनी कमजोरी गुरु के सामने रखता है, तो एक सच्चा गुरु उसे डांटता नहीं है। भगवान श्रीकृष्ण अर्जुन की बात को 100% 'वैलिडेट' (Validate/स्वीकार) करते हैं।
            वे कहते हैं, "अर्जुन, तुम बिल्कुल सही कह रहे हो (असंशयं)! यह मन सच में बहुत खतरनाक, भागने वाला और कंट्रोल करने में बहुत मुश्किल है।"
            लेकिन फिर भगवान उम्मीद (Hope) की सबसे बड़ी किरण जगाते हैं। मुश्किल ज़रूर है, लेकिन 'असंभव' (Impossible) बिल्कुल नहीं है! 
            भगवान 'माइंड कंट्रोल' (Mind Control) का दुनिया का सबसे अचूक और वैज्ञानिक (Scientific) '2-स्टेप फॉर्मूला' (2-Step Formula) देते हैं:
            १. 'अभ्यास' (Practice): मन एक जंगली जानवर की तरह है; वह भागेगा। लेकिन आपको रोज़, लगातार (Consistency के साथ) उसे पकड़कर वापस ध्यान और अच्छी आदतों में लगाना होगा। जैसे जिम (Gym) जाने से धीरे-धीरे मसल (Muscle) बनती है, वैसे ही 'अभ्यास' से मन की मसल भी कंट्रोल में आती है।
            २. 'वैराग्य' (Detachment): केवल अभ्यास काम नहीं करेगा अगर आप कचरा खाना बंद न करें। 'वैराग्य' का मतलब है उन बुरी चीज़ों (Social Media, लालच, वासना) से अपना नाता तोड़ना जो मन को भड़काती हैं।
            अगर आप इन दोनों (अभ्यास और वैराग्य) का इस्तेमाल एक साथ करेंगे, तो दुनिया का सबसे पागल मन भी आपका 100% गुलाम बन जाएगा।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead warmly replied: O mighty-armed son of Kunti (Maha-baho)! It is absolutely undoubtedly true (Asamshayam) that the restless mind is exceedingly difficult to curb and wildly flickering (Mano durnigraham chalam).
            But O Kaunteya, it is entirely possible to conquer and successfully bring it under strict control (Grihyate) through constant, relentless practice (Abhyasena) and by cultivating deep detachment (Vairagyena).
            When an honest disciple vulnerably exposes his deepest weakness, a true Grandmaster does not scold him. Lord Sri Krishna 100% completely 'Validates' and agrees with Arjuna's terrifying psychological diagnosis.
            He compassionately assures: "Arjuna, you are absolutely, 100% correct (Asamshayam)! This human mind is genuinely a terrifyingly chaotic, wildly restless, and incredibly stubborn beast to control."
            But then, the Lord ignites the ultimate, blinding ray of Cosmic Hope. It is undeniably insanely difficult, but it is absolutely NOT 'Impossible'!
            The Lord dispenses the universe's most infallible, heavily scientific '2-Step Master-Formula' for absolute 'Mind Control':
            1. 'Abhyasa' (Relentless Practice): The mind is exactly like a wild, unbroken stallion; it WILL violently run away. But you must ruthlessly, consistently, every single day, drag it back and force it to focus on good habits and meditation. Just as lifting weights daily builds physical muscle, relentless 'Abhyasa' builds the neurological muscle of discipline.
            2. 'Vairagya' (Absolute Detachment): Practice alone will fatally fail if you continue feeding the mind toxic garbage. 'Vairagya' means violently cutting off the oxygen supply (addictive social media, toxic lust, greed) that actively inflames and triggers the mind.
            If you aggressively deploy both these massive weapons (Practice + Detachment) simultaneously, even the most schizophrenic, rogue mind in the universe will eventually break and become your 100% submissive slave.
        """.trimIndent()
    ),
    Shloka(
        id = 36,
        sanskrit = """
            असंयतात्मना योगो दुष्प्राप इति मे मतिः |
            वश्यात्मना तु यतता शक्योऽवाप्तुमुपायतः || ३६ ||
        """.trimIndent(),
        hindi = """
            जिस मनुष्य ने अपने मन (और इन्द्रियों) को वश में नहीं किया है (असंयतात्मना), ऐसे असंयमी पुरुष के लिए 'योग' (परमात्मा की प्राप्ति) का मिलना बहुत ही ज्यादा कठिन (दुष्प्राप) है, ऐसा मेरा पक्का मत (मतिः) है।
            परंतु जिसने अपने मन को अपने वश में कर लिया है (वश्यात्मना), ऐसा प्रयत्नशील मनुष्य (यतता) सही उपायों (अभ्यास और वैराग्य) के द्वारा इस 'योग' को निश्चित रूप से प्राप्त करने में सफल (शक्योऽवाप्तुम्) हो सकता है।
            भगवान श्रीकृष्ण यहाँ 'सफलता' (Success) की सबसे कड़वी और स्पष्ट शर्त (Condition) सामने रख रहे हैं।
            वे साफ शब्दों में अपनी राय (Opinion / मे मतिः) देते हैं कि अगर कोई इंसान 'असंयतात्मा' है (यानी उसका खुद की जीभ पर, अपनी नींद पर, और अपनी वासनाओं पर कोई कंट्रोल नहीं है), और वह सोचता है कि वह भगवान को पा लेगा या जीवन में कोई बड़ी सफलता हासिल कर लेगा... तो यह बिल्कुल 'असंभव' (दुष्प्राप) है।
            बिना सेल्फ-कंट्रोल (Self-control) के इंसान चाहे कितने भी मंदिर चला जाए या कितनी भी किताबें पढ़ ले, वह कभी योग (ईश्वर/सफलता) को नहीं पा सकता।
            लेकिन इसका पॉजिटिव (Positive) पहलू क्या है?
            जो इंसान 'वश्यात्मा' है (जिसने अपने मन रूपी जंगली घोड़े को पालतू बना लिया है), और जो सही उपाय (उपायतः - राइट टेक्निक / Right Technique) के साथ लगातार मेहनत (यतता) करता है...
            उसके लिए दुनिया में कुछ भी नामुमकिन नहीं है। वह इंसान 100% गारंटी के साथ उस सर्वोच्च योग (ईश्वर के साथ मिलन) को पा लेगा। सारा खेल 'मन के मैनेजमेंट' (Mind Management) का है।
        """.trimIndent(),
        english = """
            For one whose mind remains completely unbridled and totally uncontrolled (Asamyatatmana), the perfection of self-realization (Yoga) is exceptionally difficult to attain (Dushprapa); this is My absolute opinion and strict conclusion (Me matih).
            But for him who has successfully mastered and subjugated his mind (Vashyatmana), and who relentlessly strives and endeavors (Yatata) using the proper correct means (Upayatah), success is absolutely guaranteed and entirely possible (Shakyo 'vaptum).
            Lord Sri Krishna is laying down the most brutally honest, unsugarcoated, and absolute 'Condition' for any form of ultimate 'Success' here.
            He bluntly declares His supreme cosmic verdict (Me matih): If a human being is 'Asamyatatmana' (meaning he has absolutely zero discipline over his toxic tongue, his lazy sleep, and his dirty lust), and he foolishly hallucinates that he will somehow achieve God-realization or massive success in life... it is a biological and spiritual 'Impossibility' (Dushprapa).
            Without ruthless titanium 'Self-Control', no matter how many hundreds of temples a man visits or how many libraries he memorizes, he will absolutely never attain Yoga (God/Ultimate Success).
            But what is the spectacular, Positive flip-side?
            For the elite warrior who is 'Vashyatmana' (who has brutally whipped his wild mind into a submissive, disciplined pet), and who relentlessly hustles and grinds (Yatata) executing the 'Right Techniques' (Upayatah - practice and detachment)...
            absolutely nothing in the entire cosmos is impossible for him. It is a 100% mathematical guarantee that he will achieve the supreme zenith of Yoga (union with God). The entire game of life is purely a game of 'Mind Management'.
        """.trimIndent()
    ),
    Shloka(
        id = 37,
        sanskrit = """
            अर्जुन उवाच |
            अयतिः श्रद्धयोपेतो योगाच्चलितमानसः |
            अप्राप्य योगसंसिद्धिं कां गतिं कृष्ण गच्छति || ३७ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने बहुत चिंता से पूछा: हे कृष्ण! जो मनुष्य शुरुआत में पूरी श्रद्धा (ईश्वर में पक्के विश्वास) के साथ योग के मार्ग पर चलता है, परंतु बाद में पर्याप्त मेहनत न कर पाने के कारण (अयतिः)...
            और सांसारिक आकर्षणों के कारण जिसका मन योग से भटक जाता है (योगाच्चलितमानसः), ऐसा साधक 'योग की पूर्ण सिद्धि' (मोक्ष) को प्राप्त न करके (अप्राप्य), अंत में किस भयंकर गति (अवस्था/Fate) को प्राप्त होता है?
            अर्जुन यहाँ दुनिया के 99% आध्यात्मिक साधकों (Spiritual Seekers) का सबसे बड़ा, सबसे डरावना और सबसे लॉजिकल (Logical) 'डर' (Fear) भगवान के सामने रख रहे हैं।
            हर इंसान को डर लगता है: "अगर मैं भगवान की भक्ति के लिए दुनिया के मजे (पार्टी, पैसा, बेईमानी) छोड़ दूँ, और सालों तक ध्यान (Meditation) करूँ... लेकिन बीच में ही मेरा मन भटक जाए और मैं फेल (Fail) हो जाऊं, तो क्या होगा?"
            अर्जुन कहते हैं कि उस इंसान के पास 'श्रद्धा' (Faith) तो थी, लेकिन उसमें मेहनत ('अयतिः') की कमी रह गई और उसका मन दुनिया की वासनाओं ('चलितमानसः') में फिसल गया।
            अब उस इंसान को न तो 'योग की सिद्धि' (भगवान/मोक्ष) मिली, और न ही उसने संसारी लोगों की तरह दुनिया के मजे लूटे।
            अर्जुन की चिंता है कि ऐसा इंसान तो 'धोबी के कुत्ते' (न घर का न घाट का) की तरह हो गया! उसकी सारी ज़िंदगी की मेहनत बर्बाद हो गई। मरने के बाद उस 'योग-भ्रष्ट' (Unsuccessful Yogi) इंसान का आखिर होता क्या है?
        """.trimIndent(),
        english = """
            Arjuna anxiously inquired: O Krishna! What is the ultimate destiny and final fate (Kam gatim gacchati) of an unsuccessful transcendentalist, who begins the path of self-realization with great faith (Shraddhayopeto), but who later heavily lacks the required persistent endeavor (Ayatih)...
            and whose mind eventually totally wanders and violently deviates away from the path of yoga due to worldly temptations (Yogach chalita-manasah), thereby completely failing to attain the supreme perfection of mysticism (Aprapya yoga-samsiddhim)?
            Arjuna is voicing the absolute biggest, most terrifying, and deeply logical 'Fear' that paralyzes 99% of all spiritual seekers in the entire world here.
            Every human is secretly terrified: "What if I aggressively sacrifice all worldly pleasures (parties, toxic wealth, cheating) to pursue God, and I meditate fiercely for years... but somewhere in the middle, my mind breaks, I relapse into lust, and I completely Fail?"
            Arjuna points out that this specific practitioner definitely had pure 'Faith' (Shraddha), but he fatally lacked the brutal discipline and persistent effort ('Ayatih'), causing his fragile mind to slip back into worldly addictions ('Chalita-manasah').
            Now, this tragic human has neither attained the 'Perfection of Yoga' (God/Liberation), nor did he brutally enjoy the toxic material pleasures of the world like ordinary greedy men.
            Arjuna is deeply worried that this person has become a pathetic 'Loser on both sides' (neither enjoying earth nor attaining heaven)! His entire life's immense sacrifice seems utterly wasted. What exactly happens to such an 'Unsuccessful Yogi' (Yoga-bhrashta) after death?
        """.trimIndent()
    ),
    Shloka(
        id = 38,
        sanskrit = """
            कच्चिन्नोभयविभ्रष्टश्छिन्नाभ्रमिव नश्यति |
            अप्रतिष्ठो महाबाहो विमूढो ब्रह्मणः पथि || ३८ ||
        """.trimIndent(),
        hindi = """
            हे महाबाहु (कृष्ण)! क्या वह दोनों ही रास्तों से (अर्थात् सांसारिक सुख और आध्यात्मिक मोक्ष दोनों से) भटका हुआ (उभयविभ्रष्टः), और ईश्वर प्राप्ति के मार्ग में बुरी तरह भ्रमित हुआ (विमूढो) वह आश्रयहीन (अप्रतिष्ठो) मनुष्य...
            हवा से छिन्न-भिन्न हुए (फटे हुए) एक छोटे से बादल की तरह (छिन्नाभ्रमिव) पूरी तरह से नष्ट (बर्बाद) तो नहीं हो जाता?
            अर्जुन अपने पिछले सवाल (डर) को एक बहुत ही शानदार और डरावने उदाहरण (Analogy) के साथ समझा रहे हैं: 'फटा हुआ बादल' (Torn Cloud)।
            कल्पना कीजिए कि एक छोटा सा बादल एक बहुत बड़े काले बादल से अलग होकर उड़ता है, यह सोचकर कि वह किसी दूसरे बड़े बादल से जाकर जुड़ जाएगा।
            लेकिन बीच रास्ते में ही एक तेज़ हवा का झोंका आता है और उस छोटे से बादल को पूरी तरह फाड़ कर (छिन्न-भिन्न करके) आसमान में गायब (नष्ट) कर देता है। अब वह बादल न तो पहले वाले के पास रहा, और न दूसरे तक पहुँचा।
            अर्जुन पूछते हैं कि क्या उस 'असफल योगी' (Unsuccessful Yogi) की हालत भी इसी फटे हुए बादल जैसी तो नहीं हो जाती?
            उसने भगवान को पाने के लिए (ब्रह्मणः पथि) दुनिया के सुख छोड़ दिए (पहला बादल छोड़ा), लेकिन वह भगवान (दूसरे बादल) तक पहुँचने से पहले ही वासनाओं की हवा में भटक गया (विमूढो)।
            क्या ऐसे 'अप्रतिष्ठो' (जिसका कोई सहारा या बैकअप प्लान/Backup Plan नहीं है) इंसान का जीवन पूरी तरह से 'नष्ट' (बर्बाद) हो जाता है? क्या उसकी सारी साधना ज़ीरो (Zero) हो जाती है?
        """.trimIndent(),
        english = """
            O mighty-armed Krishna! Does not such a man, having violently fallen from both paths of material and spiritual success (Ubhaya-vibhrashtah), and having no solid foundation or shelter anywhere (Apratishtho)...
            completely perish and vanish into nothingness, exactly like a riven, torn cloud (Chinnabhram iva) scattered by the wind, being totally bewildered and lost on the supreme path of transcendence (Vimudho brahmanah pathi)?
            Arjuna perfectly amplifies his terrifying doubt using one of the most spectacularly poetic and frightening analogies in the Gita: 'The Torn Cloud' (Chinnabhram).
            Imagine a tiny cloud bravely detaches itself from a massive, dark thundercloud, hoping to fly across the sky and merge with another massive cloud system.
            But midway through the journey, a violent hurricane wind suddenly strikes and brutally rips that tiny cloud to microscopic shreds, completely obliterating it into thin air. Now, that cloud belongs neither to the first group nor did it reach the second.
            Arjuna urgently asks: Doesn't the tragic fate of that 'Unsuccessful Yogi' mirror the exact terrifying destruction of this torn cloud?
            He violently abandoned all material, worldly pleasures (left the first cloud) strictly to walk the supreme path of God (Brahmanah pathi), but before he could reach God (the second cloud), he was blown away and bewildered by the hurricane of worldly lust (Vimudho).
            Does such an 'Apratishtho' (a man with absolutely zero shelter or backup plan) completely and utterly 'Perish' (Nashyati)? Does his entire lifetime of severe spiritual austerity get deleted to absolute Zero?
        """.trimIndent()
    ),
    Shloka(
        id = 39,
        sanskrit = """
            एतन्मे संशयं कृष्ण छेत्तुमर्हस्यशेषतः |
            त्वदन्यः संशयस्यास्य छेत्ता न ह्युपपद्यते || ३९ ||
        """.trimIndent(),
        hindi = """
            हे कृष्ण! मेरे मन के इस अत्यंत गहरे संदेह (संशयं) को आप ही पूरी तरह से, जड़ से (अशेषतः) काटने (दूर करने) में समर्थ हैं (छेत्तुमर्हसि)।
            क्योंकि आपके सिवा इस ब्रह्मांड में दूसरा कोई भी ऐसा व्यक्ति या ज्ञानी नहीं है, जो मेरे इस भयानक संशय को पूरी तरह काट सके (न ह्युपपद्यते)।
            अर्जुन का यह प्रश्न बहुत ही गहरा, दार्शनिक और आत्मा के भविष्य (Afterlife) से जुड़ा हुआ है।
            अर्जुन जानते हैं कि इस सवाल का जवाब दुनिया का कोई भी आम इंसान, कोई बड़ा से बड़ा राजा, या यहाँ तक कि कोई किताबी पंडित (Scholar) भी नहीं दे सकता।
            क्यों? क्योंकि किसी भी इंसान ने मृत्यु के बाद की दुनिया (Afterlife) नहीं देखी है। कोई नहीं जानता कि कर्मों का अकाउंटिंग सिस्टम (Karmic Accounting System) कैसे काम करता है और मरने के बाद उस फेल हुए योगी के साथ क्या होता है।
            यह सिस्टम केवल उसी ने बनाया है जो इस पूरे ब्रह्मांड का रचयिता (Creator) है।
            इसलिए अर्जुन भगवान श्रीकृष्ण के सामने पूरी तरह सरेंडर (Surrender) करते हैं। वे कहते हैं कि, "हे कृष्ण! आप सर्वज्ञ (All-knowing) हैं। केवल आप ही वह सुप्रीम अथॉरिटी (Supreme Authority) हैं जो मेरे इस डर को 'अशेषतः' (100% बिना कुछ छोड़े) मिटा सकते हैं।"
            यह श्लोक एक आदर्श शिष्य की पहचान बताता है—जब दिमाग में कोई बहुत बड़ा डाउट (Doubt) आए, तो इधर-उधर के अज्ञानी लोगों से पूछने के बजाय, सीधे सबसे उच्च और प्रामाणिक स्रोत (ईश्वर/सद्गुरु) की शरण लेनी चाहिए।
        """.trimIndent(),
        english = """
            O Krishna! This is my massive, tormenting doubt (Samshayam), and I beg You to completely, entirely, and without a trace (Asheshatah) slash it to pieces and dispel it (Chettum arhasi).
            For other than You, absolutely no one is to be found in this entire universe who can perfectly destroy and permanently eradicate this profound doubt (Tvad-anyah samshayasyasya chetta na hy upapadyate).
            Arjuna's profound question is incredibly deep, highly philosophical, and deals directly with the heavily classified cosmic secrets of the Afterlife and Karmic justice.
            Arjuna perfectly realizes that absolutely no ordinary mortal, no massive emperor, and not even the most elite, highly decorated academic scholar can ever answer this terrifying question.
            Why? Because absolutely no human being has ever seen the Afterlife. No mortal knows the exact, classified algorithms of the 'Karmic Accounting System' and what exactly happens to a failed Yogi after physical death.
            That infinitely complex system was engineered exclusively by the Supreme Creator of the cosmos.
            Therefore, Arjuna executes a complete, total surrender before Lord Sri Krishna. He essentially declares: "O Krishna! You are Omniscient. You are the absolute, undisputed 'Supreme Authority'. Only You possess the cosmic clearance to slash this fear to pieces 'Asheshatah' (100%, leaving zero trace behind)."
            This spectacular verse demonstrates the exact symptom of a perfect disciple—when a massive, paralyzing doubt attacks the brain, instead of taking advice from ignorant fools, one must immediately take absolute shelter of the highest, most authentic source of Truth (God/Guru).
        """.trimIndent()
    ),
    Shloka(
        id = 40,
        sanskrit = """
            श्रीभगवानुवाच |
            पार्थ नैवेह नामुत्र विनाशस्तस्य विद्यते |
            न हि कल्याणकृत्कश्चिद्दुर्गतिं तात गच्छति || ४० ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने अत्यंत प्रेम से कहा: हे पृथा-पुत्र (पार्थ)! उस (असफल योगी) का न तो इस लोक (इह) में विनाश (पतन) होता है, और न ही परलोक (अमुत्र) में उसका कोई विनाश होता है।
            क्योंकि हे मेरे प्यारे बच्चे (तात)! कोई भी ऐसा व्यक्ति जो कभी भी कोई शुभ या कल्याणकारी कार्य (कल्याणकृत्) करता है, वह कभी भी किसी बुरी गति (दुर्गतिं) या नर्क को प्राप्त नहीं होता (न गच्छति)।
            यह पूरी भगवद्गीता का सबसे 'आश्वासन देने वाला' (Most Reassuring) और भगवान के असीम प्रेम को दर्शाने वाला श्लोक है।
            अर्जुन डरे हुए थे कि भगवान की राह पर चलकर फेल होने वाला इंसान बर्बाद हो जाता है। भगवान श्रीकृष्ण अर्जुन को 'तात' (मेरे प्यारे बच्चे / My dear son) कहकर अत्यंत स्नेह से उनके इस डर को जड़ से उखाड़ फेंकते हैं।
            भगवान ब्रह्मांड का सबसे बड़ा 'गारंटी कार्ड' (Cosmic Guarantee Card) जारी करते हैं!
            वे कहते हैं कि आध्यात्मिक रास्ते (Spirituality) में 'विनाश' (Loss / Destruction) नाम का कोई शब्द ही नहीं है। दुनिया के बिज़नेस में आप फेल होकर ज़ीरो (Zero) हो सकते हैं, लेकिन भगवान के बैंक (Account) में आप कभी ज़ीरो नहीं होते।
            "न हि कल्याणकृत् दुर्गतिं गच्छति"—जिस इंसान ने अपने जीवन में भगवान का नाम लेने का, ध्यान करने का या कोई भी अच्छा काम (कल्याण) करने का थोड़ा सा भी प्रयास किया है, भगवान उसे कभी नर्क (दुर्गति) में नहीं जाने देते।
            चाहे वह इंसान बीच रास्ते में भटक ही क्यों न गया हो, उसका किया गया वह थोड़ा सा प्रयास भी उसके लिए एक 'परमानेंट इंश्योरेंस' (Permanent Insurance) बन जाता है। भगवान कभी अपने बच्चों की मेहनत को बेकार नहीं जाने देते।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead most affectionately replied: O son of Pritha (Partha)! For such an unsuccessful transcendentalist, there is absolutely no destruction or ruin whatsoever, neither in this present material world (Iha) nor in the next spiritual world (Amutra).
            For be absolutely assured, My dear friend and son (Tata), that anyone who performs genuinely auspicious, good, and spiritual activities (Kalyana-krit) absolutely never, ever meets with an evil destiny, degradation, or hell (Durgatim na gacchati).
            This is universally celebrated as the absolute 'Most Reassuring', comforting, and intensely loving verse in the entire Bhagavad Gita, showcasing the Lord's infinite affection.
            Arjuna was violently terrified that a human who tries to follow God but fails is utterly doomed and destroyed. Lord Sri Krishna addresses Arjuna with intense, fatherly affection using the word 'Tata' (My dear child/friend) and completely annihilates this terrifying fear from its very root.
            The Lord officially issues the absolute greatest 'Cosmic Guarantee Card' in the universe!
            He declares that in the realm of Spirituality, the word 'Destruction' (Loss/Failure) simply does not exist. In a worldly business, you can go bankrupt and hit absolute Zero, but in God's Bank Account, you absolutely never drop to zero.
            "Na hi kalyana-krit durgatim gacchati"—Any human being who has made even a microscopic, genuine attempt to chant God's name, meditate, or perform any auspicious spiritual act (Kalyana), is strictly protected by God from ever falling into a hellish condition (Durgati).
            Even if that person tragically relapses and fails midway, that tiny spiritual effort instantly becomes a 'Permanent Cosmic Insurance Policy'. The Supreme Lord is so unfathomably merciful that He never, ever lets His child's spiritual effort go to waste.
        """.trimIndent()
    ),
    Shloka(
        id = 41,
        sanskrit = """
            प्राप्य पुण्यकृतां लोकानुषित्वा शाश्वतीः समाः |
            शुचीनां श्रीमतां गेहे योगभ्रष्टोऽभिजायते || ४१ ||
        """.trimIndent(),
        hindi = """
            वह योग से भटका हुआ (योगभ्रष्टः) असफल साधक मरने के बाद महान पुण्यवानों (पुण्यकृतां) को मिलने वाले श्रेष्ठ लोकों (जैसे स्वर्ग आदि) को प्राप्त करता है, और वहाँ बहुत लंबे समय (शाश्वतीः समाः) तक सुखपूर्वक निवास करता है।
            उसके बाद, वह इंसान इस पृथ्वी पर अत्यंत पवित्र (शुचीनां) और अत्यंत धनवान/समृद्ध (श्रीमतां) लोगों के घर में दोबारा जन्म (अभिजायते) लेता है।
            श्रीकृष्ण अब उस 'असफल योगी' (Yoga-bhrashta) के मरने के बाद की पूरी 'आफ्टरलाइफ जर्नी' (Afterlife Journey / आगे की यात्रा) का बहुत ही स्पष्ट विवरण दे रहे हैं।
            जब योगी ध्यान छोड़कर दुनिया के सुखों (वासनाओं) की तरफ भागता है, तो भगवान उसे सज़ा (नर्क) नहीं देते। भगवान इतने दयालु हैं कि वे कहते हैं, "अच्छा, तुम्हारी कुछ सुख भोगने की इच्छा बाकी रह गई थी? कोई बात नहीं!"
            मरने के बाद भगवान उसे सीधा 'स्वर्ग' (पुण्यवानों के लोक) में भेज देते हैं। वहाँ वह योगी हज़ारों सालों ('शाश्वतीः समाः') तक उन सारे सुखों को जी-भर कर भोगता है जिनके लिए उसका मन भटका था।
            जब स्वर्ग में उसकी वे सारी अधूरी इच्छाएं (Cravings) पूरी तरह शांत हो जाती हैं, तो उसका 'सफर' खत्म नहीं होता।
            उसे वापस धरती पर भेजा जाता है, लेकिन किसी साधारण या गरीब परिवार में नहीं! उसे एक ऐसे घर में जन्म मिलता है जो 'शुचीनां' (बहुत ही पवित्र, संस्कारी और धार्मिक) हो, और 'श्रीमतां' (बहुत ही अमीर और धनवान) हो।
            अमीर घर में जन्म क्यों? ताकि उसे इस जन्म में पेट पालने या पैसे कमाने के लिए दिन-रात मजदूरी न करनी पड़े, और वह अपना सारा समय और पैसा अपनी अधूरी 'आध्यात्मिक यात्रा' को पूरी करने में लगा सके।
        """.trimIndent(),
        english = """
            The unsuccessful yogi (Yoga-bhrashtah), after death, first attains the highly elevated, heavenly planets reserved exclusively for those who perform exceedingly pious activities (Prapya punya-kritam lokan), and he dwells there in great joy for many, many thousands of years (Ushitva shashvatih samah).
            After that period of immense enjoyment is over, he is born again on this earth specifically into a family of highly aristocratic, exceptionally pure (Shuchinam), and immensely wealthy and prosperous people (Shrimatam gehe).
            Sri Krishna is now explicitly decoding the highly classified, exact 'Afterlife Journey' of that 'Unsuccessful Yogi' (Yoga-bhrashta) who fell from the path.
            When a Yogi unfortunately breaks his meditation because his mind is violently attracted to worldly pleasures and lust, the Lord absolutely does not punish him with hell. The Lord is so boundlessly merciful that He essentially says, "Oh, you still had some lingering desires to enjoy material pleasures? No problem at all!"
            After physical death, the Lord grants him a VIP pass directly to 'Heaven' (the upper planetary systems). There, the fallen Yogi enjoys absolute, staggering celestial pleasures for thousands of years ('Shashvatih samah'), fully satisfying all the toxic cravings that distracted him in the first place.
            Once that intense craving is entirely exhausted and pacified in heaven, his spiritual journey does not end.
            He is sent back to earth, but absolutely not into some ordinary, struggling family! He is given a highly strategic birth in a family that is 'Shuchinam' (extremely pure, aristocratic, and deeply cultured) and 'Shrimatam' (massively wealthy and prosperous).
            Why a billionaire's family? So that in his new life, he doesn't have to waste 24 hours a day desperately slaving away just to buy food; having massive wealth allows him the ultimate free time and resources to comfortably resume and finish his uncompleted 'Spiritual Journey'.
        """.trimIndent()
    ),
    Shloka(
        id = 42,
        sanskrit = """
            अथवा योगिनामेव कुले भवति धीमताम् |
            एतद्धि दुर्लभतरं लोके जन्म यदीदृशम् || ४२ ||
        """.trimIndent(),
        hindi = """
            अथवा (यदि वह योगी बहुत उच्च स्तर का था, तो) वह स्वर्ग जाने के बजाय सीधे अत्यंत बुद्धिमान (धीमताम्) और सिद्ध योगियों (योगिनामेव) के ही कुल (परिवार) में जन्म लेता है।
            निश्चित रूप से (हि), इस प्रकार का (आध्यात्मिक परिवार में) जन्म मिल पाना इस संसार में अत्यंत ही दुर्लभ (दुर्लभतरं) और महान सौभाग्य की बात है।
            पिछले श्लोक में भगवान ने उस योगी की बात की थी जो भौतिक सुखों (पैसे/वासना) के कारण योग से गिरा था (उसे अमीर घर में जन्म मिला)।
            इस श्लोक में भगवान उस 'एडवांस्ड योगी' (Advanced Yogi) की बात कर रहे हैं, जो सुखों के लालच में नहीं गिरा, बल्कि शायद उम्र कम होने के कारण या किसी और कारण से समाधि तक पहुँचने से पहले ही मर गया।
            चूँकि उसके मन में सुखों की कोई इच्छा थी ही नहीं, इसलिए भगवान उसे स्वर्ग (टाइम वेस्ट करने के लिए) नहीं भेजते।
            भगवान उसे सीधे (Directly) किसी 'महान योगी' या 'सिद्ध संतों' के परिवार में जन्म देते हैं (जैसे किसी बड़े आश्रम या ज्ञानी माता-पिता के घर)।
            यह जन्म पिछले वाले अमीर घर के जन्म से भी करोड़ों गुना बेहतर है! क्योंकि अमीर घर में इंसान के फिर से भटकने का डर रहता है, लेकिन एक 'योगी के घर' में बच्चा जन्म से ही आध्यात्मिक माहौल (Spiritual Environment) में पलता है। उसे बचपन से ही गीता और ध्यान का ज्ञान मिलने लगता है।
            श्रीकृष्ण कहते हैं कि ऐसा जन्म (ईश्वर के भक्तों के घर पैदा होना) दुनिया के सबसे अमीर राजा के घर पैदा होने से भी 'दुर्लभतरं' (सबसे दुर्लभ / Rarest of the rare) है। यह भगवान का सबसे बड़ा आशीर्वाद है।
        """.trimIndent(),
        english = """
            Or (if he was unsuccessful after a very long practice of yoga), he is directly born into a highly elevated family of exceedingly wise, self-realized transcendentalists and elite yogis (Yoginam eva kule bhavati dhimatam).
            Undoubtedly, to naturally obtain such a highly auspicious birth (in a family of advanced spiritual masters) is exceedingly rare and extraordinarily difficult to achieve (Durlabhataram) in this material world.
            In the previous verse, the Lord described the fate of a Yogi who fell purely due to a lingering craving for material wealth and lust (he was given a billionaire's birth).
            In this spectacular verse, the Lord describes the fate of a highly 'Advanced Yogi' who absolutely did not fall due to cheap material greed, but perhaps failed to achieve ultimate Samadhi simply because his lifespan ran out before he could finish.
            Since he possessed absolutely zero desire for material enjoyment, the Lord does not waste his time by sending him to heaven.
            Instead, the Lord directly transfers his soul into the womb of a family of 'Elite Yogis' or 'Highly enlightened saints' (Dhimatam).
            This specific birth is a billion times infinitely superior to the billionaire's birth! In a wealthy family, there is a massive risk of becoming corrupted again by money. But in a 'Yogi's household', the child is incubated in a 100% pure spiritual environment from day one, absorbing advanced meditation and Gita wisdom right from childhood.
            Sri Krishna officially declares that obtaining such a birth (being born to pure devotees of God) is 'Durlabhataram' (The absolute Rarest of the rare phenomenon), far superior to being born as the richest emperor on earth. It is God's ultimate blessing.
        """.trimIndent()
    ),
    Shloka(
        id = 43,
        sanskrit = """
            तत्र तं बुद्धिसंयोगं लभते पौर्वदेहिकम् |
            यतते च ततो भूयः संसिद्धौ कुरुनन्दन || ४३ ||
        """.trimIndent(),
        hindi = """
            हे कुरुनन्दन (अर्जुन)! उस नए जन्म में (योगी के घर में पैदा होने पर), वह मनुष्य अपने पूर्व जन्म की (पौर्वदेहिकम्) उस 'बुद्धि के संयोग' (आध्यात्मिक ज्ञान और संस्कारों) को बिना किसी मेहनत के अपने-आप प्राप्त कर लेता है (लभते)।
            और फिर वह उन पिछले जन्म के संस्कारों के प्रभाव से, परम सिद्धि (मोक्ष) को प्राप्त करने के लिए पहले से भी कहीं अधिक ज़ोरदार प्रयास और मेहनत (यतते च ततो भूयः) करने लगता है।
            यह श्लोक 'पुनर्जन्म' (Reincarnation) और 'स्पिरिचुअल इवोल्यूशन' (Spiritual Evolution) का सबसे बड़ा विज्ञान (Science) है।
            जब इंसान मरता है, तो उसका बैंक बैलेंस, घर और डिग्रियां सब यहीं छूट जाती हैं; अगले जन्म में उसे एबीसीडी (ABCD) से पढ़ाई शुरू करनी पड़ती है।
            लेकिन 'अध्यात्म' (Spirituality) दुनिया की इकलौती ऐसी चीज़ है जो 'मौत' के बाद भी डिलीट (Delete) नहीं होती।
            भगवान कहते हैं कि वह 'योग-भ्रष्ट' व्यक्ति जब नया जन्म लेता है, तो उसकी आत्मा के हार्ड-ड्राइव (Hard-drive) में पिछले जन्म की सारी आध्यात्मिक 'बुद्धि' (Knowledge and Meditation levels) पूरी तरह सेफ (Save) रहती है।
            यही कारण है कि हम देखते हैं कि कुछ बच्चे बचपन से ही बहुत ज्ञानी होते हैं या उनका भगवान में बहुत मन लगता है (जैसे प्रह्लाद या शंकराचार्य)। यह कोई चमत्कार नहीं है; यह उनके 'पौर्वदेहिकम्' (पिछले जन्म के) योग का बचा हुआ बैलेंस (Balance) है जो एक्टिवेट (Activate) हो जाता है।
            जहाँ उसने पिछले जन्म में ध्यान छोड़ा था, इस जन्म में वह बिल्कुल उसी पॉइंट (Point) से अपना योग दोबारा शुरू करता है। और चूँकि उसे पिछली गलतियों का अवचेतन (Subconscious) ज्ञान होता है, इसलिए वह इस जन्म में और भी ज्यादा जोश और स्पीड (ततो भूयः) से भगवान की तरफ दौड़ता है और अंततः मोक्ष पा लेता है।
        """.trimIndent(),
        english = """
            Upon taking such a highly auspicious birth there, O descendant of Kuru (Arjuna), he instantly and automatically revives the divine consciousness and profound spiritual intelligence from his previous body (Tatra tam buddhi-samyogam labhate paurva-dehikam).
            And being completely empowered by those past impressions, he then vigorously strives and intensely endeavors (Yatate) even harder than before (Tato bhuyah) to achieve the supreme perfection of liberation (Samsiddhau).
            This phenomenal verse exposes the absolute greatest science behind 'Reincarnation' and continuous 'Spiritual Evolution'.
            When an ordinary human dies, his massive bank balance, real estate, and PhD degrees are instantly reduced to zero; in his next birth, he must pathetically start learning the alphabet from scratch.
            But 'Spirituality' is the absolute only asset in the entire universe that survives physical death and defies formatting.
            The Lord reveals that when this 'Fallen Yogi' takes his new birth, his soul's internal hard-drive has flawlessly 'Saved' 100% of his spiritual 'Intelligence' (Buddhi) and meditational progress from his previous lifetime (Paurva-dehikam).
            This perfectly explains why certain rare children display staggering spiritual genius or intense devotion to God right from birth (like Prahlada or Adi Shankaracharya). It is absolutely not a random miracle; it is simply their suspended 'Karmic Spiritual Balance' from their past life being instantly reactivated.
            He flawlessly resumes his Yoga exactly from the specific checkpoint where he died in his last life. And because his subconscious carries the bitter lessons of his previous failure, he now sprints towards the Supreme Lord with massively upgraded, explosive intensity (Tato bhuyah), guaranteeing his final, ultimate liberation.
        """.trimIndent()
    ),
    Shloka(
        id = 44,
        sanskrit = """
            पूर्वाभ्यासेन तेनैव ह्रियते ह्यवशोऽपि सः |
            जिज्ञासुरपि योगस्य शब्दब्रह्मातिवर्तते || ४४ ||
        """.trimIndent(),
        hindi = """
            क्योंकि वह मनुष्य अपने उस पूर्व जन्म के अभ्यास (पूर्वाभ्यासेन) के कारण ही, न चाहते हुए भी (अवशोऽपि), भगवान की ओर (योग की ओर) अपने-आप खिंचा चला जाता है (ह्रियते)।
            योग (ईश्वर) के स्वरूप को जानने की केवल 'जिज्ञासा' (इच्छा) रखने वाला ऐसा साधक भी, वेदों के सकाम कर्मकांडों (शब्दब्रह्म) की सीमा को लांघकर उनसे बहुत ऊपर उठ जाता है (अतिवर्तते)।
            श्रीकृष्ण यहाँ 'आध्यात्मिक संस्कारों' (Spiritual Impressions) की भयंकर ताकत (Magnetic Power) का वर्णन कर रहे हैं।
            मान लीजिए कि वह व्यक्ति किसी बहुत अमीर घर में पैदा हुआ है, जहाँ सब लोग केवल पैसे और विलासिता (Luxury) में डूबे हैं। वह व्यक्ति खुद भी शायद सोचे कि "मैं भी मजे करूँगा।"
            लेकिन भगवान कहते हैं कि उसके पिछले जन्म का जो योग का 'अभ्यास' है, वह एक बहुत शक्तिशाली चुंबक (Magnet) की तरह काम करता है। वह इंसान न चाहते हुए भी (अवश होकर / Helplessly) अध्यात्म, शांति और ईश्वर की तरफ खिंचता चला जाएगा।
            दुनिया की कोई भी चकाचौंध उसे रोक नहीं पाएगी। उसके संस्कार उसे क्लब (Club) से खींचकर मंदिर या ध्यान में ले आएंगे।
            भगवान एक बहुत बड़ी बात कहते हैं कि अगर किसी इंसान के मन में भगवान को जानने की केवल सच्ची 'जिज्ञासा' (Curiosity) भी पैदा हो जाए, तो वह व्यक्ति भी उन लोगों से करोड़ गुना श्रेष्ठ हो जाता है जो केवल वेदों के कर्मकांडों (शब्दब्रह्म) में उलझकर स्वर्ग और पैसे की पूजा कर रहे हैं।
            योग (ईश्वर से जुड़ने) की एक छोटी सी इच्छा भी इंसान को सारे धार्मिक दिखावों से बहुत ऊपर उठा देती है।
        """.trimIndent(),
        english = """
            By virtue of the powerful divine consciousness and intense practice accumulated in his previous life (Purvabhyasena), he is irresistibly and automatically attracted (Hriyate) towards the yogic principles, even without his conscious seeking or against his will (Avasho 'pi sah).
            Such a person, who is even merely an inquisitive seeker (Jijnasur api) of the supreme principles of yoga, instantly transcends and flies far above the ritualistic principles and fruitive commands of the Vedas (Shabda-brahmativartate).
            Sri Krishna is brilliantly detailing the terrifying, undeniable 'Magnetic Power' of pure 'Spiritual Impressions' (Samskaras) carried over from a past life.
            Suppose this yogi takes his new birth in a billionaire family where everyone is completely submerged in toxic luxury, drugs, and corporate greed. The yogi himself might initially think, "I too will enjoy this wild, materialistic lifestyle."
            But the Lord declares that his 'Abhyasa' (Yoga practice) from his previous life acts like a colossally powerful, invisible electromagnet. Even against his own conscious will or biological desires (Helplessly / Avasho api), he will be violently dragged and irresistibly pulled towards spirituality, meditation, and God.
            Absolutely no earthly temptation can stop him. His dormant spiritual software will literally drag him out of a toxic nightclub and force him to sit in a temple or meditate.
            The Lord drops a staggering truth: If a human being possesses even a tiny, genuine spark of 'Curiosity' (Jijnasu) to understand God and Yoga, he instantly becomes a billion times superior to those foolish priests who merely memorize and blindly execute the fruitive rituals of the Vedas (Shabda-brahma) hoping for heaven.
            Even a microscopic desire for true Yoga elevates a human far, far above all superficial religious rituals.
        """.trimIndent()
    ),
    Shloka(
        id = 45,
        sanskrit = """
            प्रयत्नाद्यतमानस्तु योगी संशुद्धकिल्बिषः |
            अनेकजन्मसंसिद्धस्ततो याति परां गतिम् || ४५ ||
        """.trimIndent(),
        hindi = """
            परंतु जो योगी पिछले जन्म के संस्कारों के साथ-साथ इस जन्म में भी पूरी ताकत और सच्चे प्रयत्न के साथ मेहनत करता है (प्रयत्नाद्यतमानस्तु)...
            वह योगी अपने सभी पापों से पूरी तरह शुद्ध होकर (संशुद्धकिल्बिषः), और इस प्रकार अनेक जन्मों की लगातार साधना से पूर्ण सिद्धि (अनेकजन्मसंसिद्धः) प्राप्त करके, अंततः उस सर्वोच्च परम गति (मोक्ष/परमात्मा) को प्राप्त कर ही लेता है (ततो याति परां गतिम्)।
            यह श्लोक अर्जुन के उस डर का 'फाइनल और हैप्पी एंडिंग' (Final Happy Ending) है जो उन्होंने 37वें श्लोक में पूछा था कि "फेल हुए योगी का क्या होता है?"
            भगवान कहते हैं कि फेल होने वाला योगी कभी बर्बाद नहीं होता। जब वह नए जन्म में आता है, तो वह पिछले जन्म के संस्कारों पर निर्भर होकर आलसी नहीं बैठता।
            वह इस नए जन्म में अपनी साधना में और भी ज्यादा 'प्रयत्न' (Extreme Hard work) झोंक देता है। 
            जब पिछले जन्म का बैलेंस (Balance) और इस जन्म की भयंकर मेहनत दोनों मिल जाते हैं, तो उसके जन्मों-जन्मों के सारे पाप और गंदगी ('किल्बिष') पूरी तरह से धुलकर साफ हो जाते हैं।
            'अनेकजन्मसंसिद्धः' का अर्थ है कि किसी को भी एक ही दिन में मोक्ष नहीं मिलता। यह आत्मा की एक लंबी यात्रा है। इंसान जन्म-दर-जन्म योग की सीढ़ियां चढ़ता है।
            और अंततः, सारे प्रयासों के बाद, वह उस 'परां गतिम्' (The Supreme Destination) तक पहुँच जाता है—अर्थात् वह जन्म-मरण के चक्र से हमेशा के लिए आज़ाद होकर भगवान के परम धाम में पहुँच जाता है।
            इससे यह सिद्ध होता है कि ईश्वर के मार्ग में की गई मेहनत कभी फेल (Fail) नहीं होती, वह बस अगले जन्म में कैरी फॉरवर्ड (Carry Forward) हो जाती है जब तक कि आप 100% सफल न हो जाएं।
        """.trimIndent(),
        english = """
            But when the yogi engages himself with highly sincere, intense endeavor in making further progress (Prayatnad yatamanas tu), being completely washed clean of all possible sins and contaminations (Samshuddha-kilbishah)...
            then ultimately, achieving ultimate perfection through the accumulated practice of many, many births (Aneka-janma-samsiddhas), he finally attains the supreme, absolute destination (Tato yati param gatim).
            This spectacular verse provides the absolute 'Final Happy Ending' to Arjuna's terrifying doubt from Verse 37 regarding the fate of the "Failed Yogi".
            The Lord absolutely guarantees that a failed Yogi is never destroyed. When he takes his new upgraded birth, he absolutely does not sit lazily relying purely on his past-life spiritual balance.
            Instead, he injects extreme, aggressive, and highly sincere 'Endeavor' (Prayatna) into his spiritual practice in this new life.
            When his massive past-life balance collides with his hardcore present-life hustle, every single microscopic trace of toxic sin and karmic dirt ('Kilbisha') from millions of lifetimes is violently washed away and purified.
            'Aneka-janma-samsiddhah' profoundly reveals that ultimate God-realization is rarely a one-day achievement. It is a spectacular, infinite journey of the soul. The soul steadily climbs the staircase of Yoga, birth after birth.
            And ultimately, accumulating the momentum of all these lifetimes, he violently shatters the matrix and attains 'Param Gatim' (The Absolute Supreme Destination)—meaning he completely escapes the brutal cycle of reincarnation and enters the eternal kingdom of God.
            This flawless science proves that effort invested in God absolutely never 'Fails'; it is simply 'Carried Forward' across lifetimes until you hit 100% absolute perfection.
        """.trimIndent()
    ),
    Shloka(
        id = 46,
        sanskrit = """
            तपस्विभ्योऽधिको योगी ज्ञानिभ्योऽपि मतोऽधिकः |
            कर्मिभ्यश्चाधिको योगी तस्माद्योगी भवार्जुन || ४६ ||
        """.trimIndent(),
        hindi = """
            एक 'योगी' (जो निष्काम भाव से ईश्वर से जुड़ता है) वह कठोर तपस्या करने वाले तपस्वियों (तपस्विभ्यो) से भी बहुत श्रेष्ठ (अधिकः) है; वह शास्त्रों का ज्ञान रखने वाले ज्ञानियों (ज्ञानिभ्यो) से भी श्रेष्ठ माना गया है...
            और सकाम कर्म (फल की इच्छा से पूजा या काम) करने वाले कर्मकाण्डियों (कर्मिभ्यः) से भी योगी बहुत अधिक श्रेष्ठ है। इसलिए हे अर्जुन! तुम हर हाल में 'योगी' ही बनो (तस्माद्योगी भवार्जुन)।
            यहाँ भगवद्गीता के छठे अध्याय का सबसे बड़ा 'कन्क्लूज़न' (Conclusion / निष्कर्ष) दिया जा रहा है।
            समाज में लोग भगवान को पाने के लिए अलग-अलग रास्ते अपनाते हैं। कुछ लोग शरीर को भयंकर कष्ट देते हैं (तपस्वी)। कुछ लोग दिन-रात केवल किताबें और शास्त्र पढ़ते हैं (ज्ञानी)। और कुछ लोग पैसे और स्वर्ग के लिए बड़े-बड़े यज्ञ करते हैं (कर्मी)।
            भगवान श्रीकृष्ण इन तीनों को रिजेक्ट (Reject) नहीं करते, लेकिन वे स्पष्ट घोषणा करते हैं कि एक सच्चा 'योगी' (जो अपने मन को वश में करके निस्वार्थ भाव से सीधे परमात्मा से जुड़ता है) इन सबसे करोड़ों गुना 'श्रेष्ठ' (Superior) है।
            क्यों? क्योंकि तपस्वी को अपने शरीर का अहंकार हो सकता है, ज्ञानी को अपनी विद्या का अहंकार हो सकता है, और कर्मी तो स्वार्थी होता ही है।
            लेकिन योगी का कोई अहंकार नहीं होता; उसका केवल एक लक्ष्य होता है—'ईश्वर से मिलन' (Union with God)।
            इसलिए श्रीकृष्ण अर्जुन को एक डायरेक्ट और सुप्रीम कमांड (Supreme Command) देते हैं: "तस्माद्योगी भवार्जुन" (इन छोटे-मोटे रास्तों को छोड़ो, और तुम सीधे एक 'योगी' बनो!)। यह गीता का एक बहुत ही ऐतिहासिक आदेश है।
        """.trimIndent(),
        english = """
            A true yogi is vastly strictly superior to the ascetic who subjects himself to severe physical austerities (Tapasvibhyo 'dhiko yogi), he is undeniably superior to the empirical philosophers and scholars (Jnanibhyo 'pi mato 'dhikah)...
            and he is infinitely superior to the fruitive workers who perform actions for material rewards (Karmibhyash chadhiko yogi). Therefore, O Arjuna, in all circumstances, be a true yogi (Tasmad yogi bhavarjuna).
            Here, Lord Sri Krishna delivers the absolute, monumental 'Grand Conclusion' of the entire Sixth Chapter of the Bhagavad Gita.
            In human society, people adopt various methodologies to reach the Divine. Some subject their physical bodies to brutal, extreme torture (Ascetics/Tapasvis). Some spend their entire lives merely reading heavy libraries of scriptures (Intellectual Philosophers/Jnanis). And some execute massive rituals purely to extract money and heavenly rewards (Fruitive Workers/Karmis).
            The Lord does not entirely reject them, but He explicitly and officially declares that a genuine 'Yogi' (one who flawlessly controls his mind and selflessly seeks direct connection with the Supreme Lord) is billions of times infinitely 'Superior' (Adhikah) to all of them combined.
            Why? Because an ascetic can develop massive ego regarding his bodily tolerance, a scholar can become heavily intoxicated by academic arrogance, and a ritualistic worker is biologically selfish.
            But a true Yogi possesses absolutely zero ego; his single, laser-focused target is 'Absolute Union with God'.
            Therefore, Sri Krishna issues a highly direct, ultimate Supreme Command to His beloved friend: "Tasmad yogi bhavarjuna" (Abandon all these lesser, inferior paths, and under all circumstances, YOU MUST BECOME A YOGI!). This is one of the most legendary, historic directives in the Gita.
        """.trimIndent()
    ),
    Shloka(
        id = 47,
        sanskrit = """
            योगिनामपि सर्वेषां मद्गतेनान्तरात्मना |
            श्रद्धावान्भजते यो मां स मे युक्ततमो मतः || ४७ ||
        """.trimIndent(),
        hindi = """
            और उन सभी प्रकार के योगियों में से भी (योगिनामपि सर्वेषां), जो योगी पूर्ण श्रद्धा (अटूट विश्वास) से युक्त होकर (श्रद्धावान्)...
            अपने अंतःकरण (मन और आत्मा) को पूरी तरह मुझमें लगाकर (मद्गतेनान्तरात्मना), निरंतर मेरा ही भजन और स्मरण (प्रेमपूर्वक भक्ति) करता है (भजते यो मां)...
            वह योगी मुझे सबसे अधिक श्रेष्ठ, सबसे निकट और परम पूर्ण (युक्ततमो) मान्य है (स मे युक्ततमो मतः)।
            यह छठे अध्याय का अंतिम और पूरी भगवद्गीता के सबसे महान और राजसी (Majestic) श्लोकों में से एक है। यह 'भक्तियोग' (Bhakti Yoga) का ट्रेलर (Teaser) है जो अगले 6 अध्यायों में चलने वाला है।
            पिछले श्लोक में भगवान ने अर्जुन से कहा था कि "तुम योगी बनो।" अब अर्जुन सोच सकते हैं कि "मैं कौन सा योगी बनूँ? ध्यान योगी, अष्टांग योगी, या हठ योगी?"
            श्रीकृष्ण एक बहुत बड़ा सीक्रेट (Secret) खोलते हैं। वे कहते हैं कि योगियों की भी बहुत सारी वैरायटी (Variety) होती है, लेकिन उन सभी योगियों में जो 'टॉप मोस्ट' (Top-most / युक्ततमो) योगी है, वह 'भक्त' (Devotee) है।
            भक्त क्यों सबसे महान है? क्योंकि बाकी योगी अपनी इन्द्रियों और सांसों को रोकने में अपनी ताकत लगाते हैं (जो बहुत मुश्किल और रूखा रास्ता है)।
            लेकिन जो 'श्रद्धावान्' भक्त है, वह अपना पूरा दिल और आत्मा (अन्तरात्मा) चुपचाप भगवान (कृष्ण) के चरणों में रख देता है ('मद्गतेन')। वह प्रेम (भक्ति) के माध्यम से भगवान से जुड़ता है।
            भगवान आधिकारिक रूप से डिक्लेयर (Declare) करते हैं कि जो इंसान मुझसे 'प्यार' (भक्ति) करता है, वही मेरा सबसे 'परफेक्ट योगी' (The Ultimate Yogi) है।
            यहाँ 'ध्यान योग' नामक छठा अध्याय पूर्ण होता है, और 'भक्ति' की महान यात्रा का दरवाज़ा खुलता है।
        """.trimIndent(),
        english = """
            And of all the different types of yogis in existence (Yoginam api sarvesham), the one who possesses absolute, unflinching faith (Shraddhavan)...
            and who always abides in Me, with his inner self and consciousness completely, deeply absorbed within Me (Mad-gatenantaratmana), continuously worshiping Me in pure, loving transcendental service (Bhajate yo mam)...
            he is the most intimately united with Me in yoga, and is officially considered by Me to be the absolute highest and most supreme of all (Sa me yuktatamo matah).
            This is the final, ultimate verse of the Sixth Chapter, and universally recognized as one of the most magnificent, majestic, and paradigm-shifting verses in the entire Bhagavad Gita. It serves as the explosive 'Teaser Trailer' for the path of 'Bhakti Yoga' (Pure Devotion) that will dominate the next six chapters.
            In the previous verse, the Lord commanded Arjuna: "Become a Yogi." Arjuna could naturally wonder: "Which specific type of Yogi should I become? An Ashtanga Yogi? A Hatha Yogi?"
            Sri Krishna drops the ultimate, supreme Secret here. He declares that there are hundreds of varieties of elite Yogis, but out of absolutely all of them, the 'Top-Most, Supreme Zenith' (Yuktatamo) Yogi is the 'Pure Devotee' (Bhakta).
            Why is the loving devotee the absolute greatest? Because other mystics fiercely rely on their own puny willpower to painfully suppress their breath and physical senses (which is an incredibly dry, frustrating path).
            But the 'Shraddhavan' (faithful devotee) simply takes his entire heart, soul, and consciousness and places it tenderly and completely at the lotus feet of the Supreme Lord ('Mad-gatena'). He connects with God exclusively through the staggering power of 'Love'.
            The Supreme Lord officially and permanently declares that the human being who 'Loves' Him (Bhakti) is His most beloved, highest, and 'Ultimate Perfect Yogi'.
            Here flawlessly concludes the Sixth Chapter, 'Dhyana Yoga', spectacularly unlocking the grand, majestic doors to the supreme journey of Pure Devotion.
        """.trimIndent()
    )
)