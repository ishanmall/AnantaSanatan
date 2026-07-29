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
data class DhyanabinduShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DhyanabinduUpanishadScreen() {
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
            itemsIndexed(dhyanabinduShlokasList) { _, shloka ->
                DhyanabinduShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun DhyanabinduShlokaCard(shloka: DhyanabinduShloka) {
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

val dhyanabinduShlokasList: List<DhyanabinduShloka> = listOf(
    DhyanabinduShloka(
        id = 1,
        sanskrit = "यदि शैलसमं पापं विस्तीर्णं बहुयोजनम् । भिद्यते ध्यानयोगेन नान्यो भेदः कदाचन ॥ १ ॥",
        hindi = """
            (ध्यान की महिमा): यदि किसी मनुष्य का पाप एक विशाल पर्वत (शैल) के समान बहुत बड़ा हो।
            और वह पाप कई योजन (मीलों) तक फैला हुआ (विस्तीर्ण) और अत्यंत भयंकर हो।
            तो भी उस पाप रूपी पहाड़ को केवल 'ध्यान योग' (Meditation) के द्वारा ही पूरी तरह भेदा और नष्ट (भिद्यते) किया जा सकता है।
            इस ध्यान योग के अलावा इस पाप को नष्ट करने का दुनिया में कोई दूसरा (नान्यो) तरीका कभी भी (कदाचन) नहीं है।
            यह उपनिषद की सबसे बड़ी और राहत देने वाली घोषणा है: कोई भी पापी हमेशा के लिए पापी नहीं होता।
            हम सोचते हैं कि बुरे कर्मों से छुटकारा पाने के लिए हजारों जन्म लेने पड़ेंगे।
            पर उपनिषद कहता है कि ध्यान की अग्नि में करोड़ों जन्मों का पाप एक ही पल में जलकर राख हो जाता है।
            जब मन अपने असली और शुद्ध स्वरूप (आत्मा) से जुड़ जाता है, तो पुराना कोई भी अज्ञान टिक नहीं सकता।
            इसलिए साधक को अपने अतीत (Past) से डरना नहीं चाहिए, बल्कि ध्यान की शरण लेनी चाहिए।
            यही ध्यान की असीम और परम शक्ति है जो इंसान को तुरंत पवित्र कर देती है।
        """.trimIndent(),
        english = """
            (The Glory of Meditation): Even if a person's accumulated sin is as massive and colossal as a great mountain (Shaila).
            And even if that terrifying sin is vastly spread (Vistirnam) across many Yojanas (miles).
            Even that massive mountain of sin is completely shattered and destroyed (Bhidyate) exclusively by the power of 'Dhyana Yoga' (Meditation).
            Apart from this profound meditation, there is absolutely no other (Nanyo) method whatsoever at any time (Kadachana) to destroy it.
            This is the absolute greatest and most profoundly comforting declaration of the Upanishad: no sinner is a sinner forever.
            We often falsely believe that it will take thousands of births to get rid of our terrible past karmas.
            But the Upanishad firmly declares that the intense fire of meditation burns millions of lifetimes of sins into ashes in a single moment.
            When the restless mind successfully connects with its original, pure nature (Soul), absolutely no past ignorance can survive.
            Therefore, a sincere seeker must absolutely never fear his dark Past, but should immediately take absolute refuge in meditation.
            This is the limitless, ultimate power of Dhyana that instantly and flawlessly purifies a human being entirely.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 2,
        sanskrit = "बीजाक्षरं परं बिन्दुं नादं तस्योपरि स्थितम् । सशब्दं चाक्षरे क्षीणे निःशब्दं परमं पदम् ॥ २ ॥",
        hindi = """
            (ॐकार का स्वरूप): 'ॐ' वह परम बीज अक्षर है, जिसके ऊपर 'बिंदु' (अनुस्वार) स्थित है।
            और उस बिंदु के भी ऊपर 'नाद' (ध्वनि/गूँज) विराजमान है, जिसका ध्यान साधक को करना चाहिए।
            जब उस ॐकार का वह 'सशब्द' (ध्वनि वाला हिस्सा) धीरे-धीरे पूरी तरह से क्षीण (खत्म/शांत) हो जाता है।
            तब उस शब्द के मिटने के बाद जो परम 'निःशब्द' (पूर्ण मौन और सन्नाटा) बचता है, वही 'परम पद' है।
            ध्यान की शुरुआत हमेशा किसी न किसी सहारे (बीज अक्षर / ॐ) से करनी पड़ती है, क्योंकि मन खाली नहीं रह सकता।
            ॐ का उच्चारण करते समय जो गूँज (नाद) होती है, वह मन को बाहरी दुनिया से खींचकर अंदर ले जाती है।
            पर उपनिषद साफ कहता है कि आवाज़ (Sound) मंजिल नहीं है; आवाज़ केवल वह नाव है जो मौन (Silence) के किनारे तक ले जाती है।
            जैसे ही गूँज खत्म होती है, मन के पास सोचने के लिए कुछ नहीं बचता, और वह भी आवाज़ के साथ ही मर जाता है।
            उसी पूर्ण निःशब्द और विचार-रहित शून्यता में ही भगवान (परम पद) का असली निवास है।
            यह श्लोक नाद योग और ध्यान की सबसे वैज्ञानिक (Scientific) और सटीक प्रक्रिया को समझाता है।
        """.trimIndent(),
        english = """
            (The nature of Omkara): 'OM' is that supreme seed-syllable, directly above which the 'Bindu' (the dot) is firmly situated.
            And even above that dot, the 'Nada' (the cosmic echoing sound) perfectly resides, upon which the seeker must meditate.
            When that 'Sashabda' (the audible sounding part) of the Omkara gradually decays and becomes completely exhausted (Kshina).
            Then the absolute 'Nishabda' (profound silence and soundless void) that remains after the sound dies is the 'Supreme Abode'.
            Meditation must absolutely always begin with some solid support (seed-syllable / OM), because the mind simply cannot remain empty.
            The continuous echoing sound (Nada) while chanting OM successfully pulls the restless mind inward from the external world.
            But the Upanishad explicitly states that the sound is absolutely not the destination; the sound is merely the boat taking you to the shore of Silence.
            The exact moment the echo ends, the mind has absolutely nothing left to think about, and it flawlessly dies along with the fading sound.
            It is exclusively within that absolute soundless, thought-free void that the true residence of God (Supreme Abode) perfectly exists.
            This magnificent verse explains the most highly scientific and precise process of Nada Yoga and deep meditation.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 3,
        sanskrit = "अनाहतं तु यच्छब्दं तस्य शब्दस्य यत्परम् । तत्परं विन्दते यस्तु स योगी छिन्नसंशयः ॥ ३ ॥",
        hindi = """
            हृदय के भीतर जो 'अनाहत' (बिना किसी बाहरी टकराहट के उत्पन्न होने वाला) नाद या शब्द निरंतर गूँज रहा है।
            साधक को उस गूँजने वाले शब्द के भी परे (पार) जो परम तत्व है, उसे अच्छी तरह से जानना चाहिए।
            जो योगी उस अनाहत ध्वनि के परम स्रोत (परमात्मा) को प्राप्त कर लेता है, उसके सारे संशय (शक) कट जाते हैं।
            वह 'छिन्नसंशयः' (कटे हुए संशयों वाला) होकर उस परम शांति में हमेशा के लिए स्थिर हो जाता है।
            अनाहत नाद वह ईश्वरीय संगीत है जो हमारे हृदय चक्र में बिना किसी वाद्य-यंत्र के बज रहा है।
            शुरुआत में मन को एकाग्र करने के लिए इस नाद (ध्वनि) को सुनना बहुत ही जरूरी और लाभदायक है।
            परंतु उपनिषद चेतावनी देता है कि इस मीठी आवाज़ में ही फँस कर नहीं रुक जाना चाहिए।
            आवाज़ केवल एक रास्ता है; असली भगवान तो उस आवाज़ के पीछे छिपे हुए मौन (Silence) में है।
            जब योगी आवाज़ को छोड़कर उस सन्नाटे को पकड़ लेता है, तब उसके मन के सारे सवाल हमेशा के लिए खत्म हो जाते हैं।
            यही वह पूर्ण अवस्था है जहाँ ज्ञान का उदय होता है और जीव का सारा भटकाव शांत हो जाता है।
        """.trimIndent(),
        english = """
            That profound 'Anahata' (unstruck/uncreated) sound or Nada which is continuously echoing right within the human heart.
            The sincere seeker must actively strive to know and realize that Supreme Principle which exists completely beyond that echoing sound.
            The true Yogi who successfully attains the absolute source (God) of that uncreated sound has all his doubts completely destroyed.
            He becomes 'Chinnasamshayah' (one whose doubts are severed) and remains permanently established in that supreme peace forever.
            The Anahata Nada is that divine cosmic music actively playing in our heart chakra completely without any physical instrument.
            In the very beginning, carefully listening to this Nada (sound) is exceptionally necessary and highly beneficial for concentrating the mind.
            However, the Upanishad gives a strict warning that one must absolutely not get trapped and stop merely at this sweet sound.
            The sound is merely a pathway; the real God exists strictly in the profound Silence flawlessly hidden exactly behind that sound.
            When the Yogi completely drops the sound and firmly grasps that absolute silence, all his mental questions are permanently annihilated forever.
            This is exactly that supreme, perfect state where true wisdom dawns and all the wandering of the individual soul is perfectly calmed.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 4,
        sanskrit = "अकारो भूर्भवज्जीवो ब्रह्मा च चेतनः स्मृतः । अकारः पीतवर्णः स्याद्रजोगुण उदीरितः ॥ ४ ॥",
        hindi = """
            (अब ॐकार के अक्षरों का रहस्य बताया जा रहा है): ॐकार का जो पहला अक्षर 'अ' (अकार) है, उसे 'भूर्लोक' (पृथ्वी लोक) के रूप में जानना चाहिए।
            इस 'अ' कार को ही साक्षात् 'ब्रह्मा' (सृष्टि के रचयिता) और जाग्रत चेतना (चेतन जीव) के रूप में स्मरण किया गया है।
            इस प्रथम अक्षर 'अ' का रंग पीला (पीतवर्ण / स्वर्ण के समान) बताया गया है।
            और इसे सृष्टि की सक्रियता को बढ़ाने वाले 'रजोगुण' से पूरी तरह युक्त माना गया है।
            ॐ का उच्चारण करते समय यह पहली ध्वनि हमारे स्थूल शरीर और इस दिखाई देने वाली भौतिक दुनिया का प्रतिनिधित्व करती है।
            ब्रह्मा जी निर्माण के देवता हैं, और रजोगुण भी नई चीज़ें बनाने और कर्म करने (Activity) की भारी ऊर्जा है।
            जब हम 'अ' बोलते हैं, तो हमारे शरीर के निचले हिस्से (नाभि और पेट) में एक विशेष कंपन (Vibration) होता है।
            यह कंपन हमें धरती (भूर्लोक) की स्थिरता और भौतिक जीवन के सभी कर्मों के साथ गहराई से जोड़ता है।
            ध्यान में इस अक्षर का चिंतन करने से शरीर की सभी सुस्त ऊर्जाएं जाग जाती हैं और अत्यंत सक्रिय हो जाती हैं।
            यह वेदान्त का वह विज्ञान है जो एक छोटी सी ध्वनि के भीतर पूरे ब्रह्मांड के निर्माण की कहानी को समेट देता है।
        """.trimIndent(),
        english = """
            (Now the secret of Omkara's letters is revealed): The absolute first letter of Omkara, 'A' (Akara), must be profoundly known as 'Bhurloka' (the Earth realm).
            This exact letter 'A' is actively remembered and declared as the direct embodiment of Lord 'Brahma' (the Creator) and the waking consciousness (Jiva).
            The specific color of this primary, supreme syllable 'A' is explicitly described as yellow (Pitavarna / like pure gold).
            And it is considered to be heavily endowed with 'Rajoguna', the highly active quality that powerfully drives the creation.
            While beautifully chanting OM, this absolute first sound flawlessly represents our gross physical body and the entire visible material world.
            Lord Brahma is the supreme deity of creation, and Rajoguna is precisely the active energy required for making new things and performing actions.
            When we loudly chant 'A', a highly specific, powerful vibration occurs strictly in the lower part of our physical body (navel and stomach).
            This specific vibration deeply connects us directly with the stability of the earth (Bhurloka) and all physical karmic experiences.
            Deeply contemplating this syllable in meditation completely awakens and highly activates all the lazy, dormant energies of the body.
            This is that magnificent science of Vedanta which perfectly encapsulates the story of the entire cosmos's creation right within a single, tiny sound.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 5,
        sanskrit = "उकारो ह्यन्तरिक्षं च विष्णुश्चैव निगद्यते । उकारः सात्त्विको ज्ञेयः शुक्लवर्णस्तथैव च ॥ ५ ॥",
        hindi = """
            ॐकार का जो दूसरा अक्षर 'उ' (उकार) है, उसे 'भुवर्लोक' (अंतरिक्ष या वायु लोक) के रूप में जानना चाहिए।
            इस 'उ' कार को ही साक्षात् भगवान 'विष्णु' (सृष्टि के महान पालनहार) के रूप में वर्णित (निगद्यते) किया गया है।
            तत्त्व को जानने वाले योगियों द्वारा इसे शांति का प्रतीक 'सात्त्विक गुण' (सत्त्वगुण) माना गया है।
            और इसका रंग 'शुक्ल' (बिल्कुल सफेद और अत्यंत पवित्र) बताया गया है।
            जब हम 'उ' का उच्चारण करते हैं, तो यह हमारी चेतना को भौतिक शरीर से उठाकर सूक्ष्म शरीर (मन और भावनाओं) की ओर ले जाता है।
            विष्णु का कार्य पालन करना है; 'उ' की ध्वनि हमारे भीतर की आध्यात्मिक ऊर्जा का पोषण और पालन करती है।
            सत्त्वगुण शांति, पवित्रता और ज्ञान का प्रतीक है, जो इस ध्वनि के अभ्यास से हमारे स्वभाव में उतरने लगता है।
            इस ध्वनि का कंपन मुख्य रूप से हमारे सीने (Chest) और हृदय चक्र में बहुत गहराई से महसूस किया जाता है।
            सफेद रंग अज्ञान के सारे दागों को धोकर मन को दर्पण की तरह बिल्कुल साफ और पारदर्शी बना देने का सूचक है।
            साधक को 'उ' कार का जप करते हुए अपने भीतर उस परम रक्षक (विष्णु) और असीम शांति का साक्षात् अनुभव करना चाहिए।
        """.trimIndent(),
        english = """
            The absolute second letter of Omkara, 'U' (Ukara), must be profoundly recognized and known as 'Antariksha' (the intermediate space / Bhuvarloka).
            This exact letter 'U' is explicitly declared (Nigadyate) to be the direct embodiment of Lord 'Vishnu' (the great Sustainer of creation).
            By the Yogis who directly perceive truth, it is perfectly considered as the symbol of peace, the 'Sattvic quality' (Sattvaguna).
            And its specific color is profoundly described as 'Shukla' (pure, immaculate, and highly sacred white).
            When we actively chant 'U', it flawlessly elevates our consciousness from the gross physical body toward the subtle body (mind and emotions).
            Lord Vishnu's primary function is sustenance; the profound sound of 'U' actively nourishes and strictly sustains our internal spiritual energy.
            Sattvaguna represents absolute peace, purity, and wisdom, which naturally descends into our behavior through the intense practice of this sound.
            The powerful vibration of this specific sound is felt exceptionally deeply, primarily within our chest and the sacred heart chakra.
            The pure white color profoundly indicates washing away all dark stains of ignorance, making the mind flawlessly clean and transparent like a mirror.
            While fiercely chanting the letter 'U', the seeker must directly and vividly experience that Supreme Protector (Vishnu) and boundless peace within.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 6,
        sanskrit = "मकारो द्यौरिति ज्ञेयस्तामसः शिव उच्यते । कृष्णवर्णस्तथा ज्ञेयः सर्ववेदान्तपारगैः ॥ ६ ॥",
        hindi = """
            ॐकार का जो तीसरा अक्षर 'म' (मकार) है, उसे 'स्वर्लोक' (द्यौः / स्वर्ग या उच्च लोक) के रूप में जानना चाहिए।
            इस 'म' कार को साक्षात् भगवान 'शिव' (रुद्र / संहारक) और 'तमोगुण' (लय करने वाला गुण) कहा गया है।
            संपूर्ण वेदान्त के पार जाने वाले परम ज्ञानियों द्वारा इसका रंग 'कृष्ण' (काला या अत्यंत गहरा) बताया गया है।
            जब हम 'म' का उच्चारण करते हैं, तो ध्वनि होठों पर आकर बंद हो जाती है; यह संपूर्ण सृष्टि के 'प्रलय' (विनाश/लय) का प्रतीक है।
            शिव का कार्य अज्ञान और अहंकार को नष्ट करना है; 'म' की गूँज हमारे भीतर के सारे बुरे विचारों को पूरी तरह भस्म कर देती है।
            तमोगुण यहाँ अज्ञान का नहीं, बल्कि 'विश्राम' और 'लय' (गहरी नींद या सुषुप्ति) का प्रतीक है, जहाँ मन पूरी तरह शांत हो जाता है।
            इस ध्वनि का सूक्ष्म कंपन हमारे मस्तक (सिर के ऊपरी हिस्से) और आज्ञा चक्र में अत्यंत गहराई से अनुभव होता है।
            काला रंग ब्रह्मांड की उस शून्यता (Void) और रहस्यमयी गहराई का प्रतीक है जिसमें सब कुछ अंततः समा जाता है।
            इस प्रकार ॐ (अ-उ-म) केवल एक शब्द नहीं, बल्कि पूरी सृष्टि के बनने (ब्रह्मा), चलने (विष्णु) और मिटने (शिव) का पूरा विज्ञान है।
            साधक को 'म' कार की गूँज में अपने अहंकार को पूरी तरह मिटाकर उस शिव-स्वरूप परम शून्यता का साक्षात् अनुभव करना चाहिए।
        """.trimIndent(),
        english = """
            The absolute third letter of Omkara, 'M' (Makara), must be profoundly recognized and known as 'Svarloka' (Dyauh / the highest heavenly realm).
            This exact letter 'M' is explicitly declared to be the direct embodiment of Lord 'Shiva' (the Destroyer) and the symbol of 'Tamoguna' (the quality of dissolution).
            By the supreme, enlightened sages who have successfully crossed the ocean of Vedanta, its color is described as 'Krishna' (deep black or very dark).
            When we actively chant 'M', the sound is perfectly closed at the lips; this profoundly symbolizes the absolute 'Dissolution' (Pralaya) of all creation.
            Lord Shiva's ultimate function is destroying ignorance and ego; the deep echo of 'M' completely burns away absolutely all our toxic thoughts.
            Tamoguna here absolutely does not mean dark ignorance, but flawlessly represents 'Rest' and 'Dissolution' (deep, dreamless sleep) where the mind becomes perfectly still.
            The subtle vibration of this specific sound is experienced exceedingly deeply within our forehead (crown) and the powerful Ajna Chakra.
            The black color magnificently symbolizes that infinite, mysterious cosmic void into which absolutely everything ultimately merges and disappears completely.
            Thus, OM (A-U-M) is absolutely not just a word, but the entire flawless science of the universe's creation (Brahma), sustenance (Vishnu), and destruction (Shiva).
            In the fading echo of 'M', the seeker must completely annihilate his ego and directly experience that absolute, supreme Shiva-like void.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 7,
        sanskrit = "तैलधारामिवाच्छिन्नं दीर्घघण्टानिनादवत् । अवाच्यं प्रणवस्याग्रं यस्तं वेद स वेदवित् ॥ ७ ॥",
        hindi = """
            जिस प्रकार तेल की धार (तैल-धारा) बिना टूटे (अच्छिन्न) एक समान और लगातार नीचे की ओर गिरती रहती है।
            और जिस प्रकार एक बड़ी घंटी बजाने के बाद उसकी मधुर गूँज (निनाद) बहुत देर तक (दीर्घ) लगातार वातावरण में बनी रहती है।
            उसी प्रकार ॐकार (प्रणव) का जो सबसे अंतिम सिरा (अग्र) है, वह भी बिना टूटे गूँजता है और वह वाणी से बताने योग्य (अवाच्य) नहीं है।
            जो साधक ॐ की उस अंतिम, बिना टूटने वाली और शब्दों से परे गूँज (नाद) को भलीभांति जान लेता है (वेद)।
            वास्तव में वही मनुष्य सम्पूर्ण वेदों का सच्चा ज्ञाता (वेदवित्) और असली परम ज्ञानी है।
            यह श्लोक ध्यान करने वालों के लिए एक अत्यंत ही शक्तिशाली और प्रैक्टिकल (Practical) रहस्य (Secret) बताता है।
            ॐ का उच्चारण झटके से नहीं करना चाहिए; इसे तेल की धार की तरह अत्यंत स्मूथ (Smooth) और लगातार (Continuous) होना चाहिए।
            जब होंठ बंद हो जाते हैं, तब भी घंटी की तरह अंदर एक गूँज बजती रहती है; उसी गूँज (नाद) पर पूरा ध्यान टिकाना है।
            वह गूँज 'अवाच्य' है, यानी दुनिया की कोई भी भाषा उस शांति को समझा नहीं सकती; उसे केवल महसूस किया जा सकता है।
            किताबें रटने वाला ज्ञानी नहीं होता; जो इस ॐकार के अंतिम सन्नाटे (Silence) को सुन लेता है, वही वेदों का असली मास्टर है।
        """.trimIndent(),
        english = """
            Exactly just as a continuous stream of pure oil (Taila-dhara) falls downwards steadily and perfectly unbroken (Acchinna) without any interruption.
            And exactly just as the sweet, lingering echo (Ninada) of a large, struck bell remains continuously in the atmosphere for a very long time (Dirgha).
            In the exact same manner, the absolute final, subtle peak (Agra) of the Omkara (Pranava) resonates unbrokenly and is completely inexpressible by speech (Avachya).
            That sincere seeker who flawlessly knows and directly experiences (Veda) that final, unbroken, wordless echo of OM.
            In absolute reality, that human being alone is the true, ultimate knower of all the Vedas (Vedavit) and the genuine supreme sage.
            This magnificent verse reveals an exceptionally powerful and highly practical Secret specifically for deeply meditating seekers.
            The chanting of OM must absolutely never be jerky; it must be exceptionally Smooth and perfectly Continuous exactly like a flawless stream of pouring oil.
            Even when the lips close perfectly, an internal echo continues to ring like a struck bell; the entire focus must be firmly anchored strictly on that fading echo.
            That final echo is 'Avachya', meaning absolutely no language in the world can ever explain that profound peace; it can exclusively only be felt.
            A person memorizing books is absolutely not wise; he who successfully hears this absolute final Silence of Omkara is the true, ultimate Master of the Vedas.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 8,
        sanskrit = "हृत्पद्ममष्टदलं त्रिंशत्कन्दमवाङ्मुखम् । रेचकेनोर्ध्वमुत्क्षिप्य पूरकेण विकासयेत् ॥ ८ ॥",
        hindi = """
            मनुष्य के हृदय में आठ पंखुड़ियों (अष्टदलं) वाला एक अत्यंत पवित्र कमल (हृत्पद्म) है, जिसका मूल कंद (Base) तीस भागों वाला है।
            यह हृदय-कमल स्वाभाविक रूप से अज्ञान के कारण नीचे की ओर झुका हुआ (अवाङ्मुखम् / उल्टे मुँह वाला) रहता है।
            साधक को चाहिए कि वह 'रेचक' (प्राणायाम में श्वास को बाहर छोड़ने की क्रिया) के द्वारा उस उल्टे कमल को ऊपर की ओर उठाए (उत्क्षिप्य)।
            और फिर 'पूरक' (प्राणायाम में श्वास को अंदर खींचने की क्रिया) के द्वारा उस हृदय-कमल को पूरी तरह से खिला (विकासयेत्) दे।
            यह श्लोक कुण्डलिनी योग और ध्यान की एक अत्यंत गुप्त (Secret) और शक्तिशाली तकनीक (Technique) का वर्णन कर रहा है।
            साधारण इंसान का मन हमेशा वासनाओं और दुनियादारी में फँसा रहता है; यही कमल का 'नीचे की ओर झुका होना' है।
            जब हम गहरी और सचेत (Conscious) साँसें छोड़ते हैं (रेचक), तो हम अपने अंदर की सारी गंदी भावनाओं और स्वार्थ को बाहर फेंकते हैं।
            इस क्रिया से मन की दिशा (Direction) बदलती है और वह नीचे (संसार) से उठकर ऊपर (ईश्वर) की ओर देखने लगता है।
            और जब हम ताजी साँस भरते हैं (पूरक), तो वह ईश्वरीय ऊर्जा (प्राण) उस हृदय-कमल को पूरी तरह से प्रकाश और प्रेम से खिला देती है।
            यह प्राणायाम केवल हवा का खेल नहीं है, बल्कि यह अपने सोए हुए मन को जगाकर सीधा परमात्मा की ओर मोड़ देने का महा-विज्ञान है।
        """.trimIndent(),
        english = """
            Right within the human heart exists an exceptionally sacred lotus (Hrit-padma) possessing exactly eight petals (Ashtadalam) and a thirty-fold root-base (Kanda).
            Due to sheer, dark ignorance, this magnificent heart-lotus naturally remains facing directly downwards (Avangmukham / turned upside down) toward worldly desires.
            The sincere seeker must actively and forcefully lift that inverted lotus upwards (Utkshipya) strictly through the powerful process of 'Rechaka' (exhaling the vital breath).
            And then, he must completely and flawlessly bloom and expand (Vikasayet) that upward-facing heart-lotus strictly through 'Puraka' (inhaling the vital breath).
            This profound verse describes an exceedingly Secret and tremendously powerful Technique of Kundalini Yoga and deep meditation.
            An ordinary human's mind is perpetually trapped in deep lusts and worldly materialism; this is the exact meaning of the lotus 'facing downwards'.
            When we actively perform deep, highly Conscious exhalations (Rechaka), we ruthlessly throw out all our toxic emotions, dark ignorance, and petty selfishness.
            Through this supreme action, the exact Direction of the mind profoundly shifts; it stops looking down (world) and actively begins looking up (God).
            And when we inhale fresh breath (Puraka), that supreme divine energy (Prana) flawlessly blooms that heart-lotus completely with brilliant light and infinite love.
            This Pranayama is absolutely not a mere physical game of air, but the ultimate grand science of awakening the sleeping mind and turning it straight toward God.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 9,
        sanskrit = "मध्ये तु न्यस्येत् प्राणं प्राणोकारं तथाक्षरम् । बिन्दुनादमयं कृत्वा तं नादं प्रस्फुरेद्धृदि ॥ ९ ॥",
        hindi = """
            जब वह हृदय-कमल पूरी तरह खिल जाए, तब साधक को उस कमल के बिल्कुल मध्य (बीच) में अपने 'प्राण' (चेतना) को स्थापित (न्यस्येत्) करना चाहिए।
            उसी मध्य भाग में प्राण-स्वरूप 'उ' कार और अविनाशी 'अक्षर' (ॐ) को भी पूरी एकाग्रता के साथ स्थापित करना चाहिए।
            फिर उस ॐकार को 'बिंदु' और 'नाद' से युक्त (बिन्दुनादमयं) करके, यानी पूरे फोकस के साथ गूँज को सुनते हुए।
            उस परम नाद (ईश्वरीय ध्वनि) को अपने हृदय के भीतर पूरी तरह से प्रस्फुटित (गूँजने/चमकने) देना चाहिए (प्रस्फुरेद्धृदि)।
            यहाँ ध्यान को हृदय के बिल्कुल 'सेंटर' (Center point) पर लाने की बात कही गई है।
            जब तक मन इधर-उधर है, तब तक ॐ का कोई फायदा नहीं; ॐ को कमल के एकदम 'बीच' में रखना पड़ता है।
            'बिंदु' का अर्थ है फोकस (Focus) और 'नाद' का अर्थ है वह ध्वनि (Sound); इन दोनों को मिलाकर ध्यान करना है।
            जब यह नाद हृदय में फूटता (Explode) है, तो वह किसी बम की तरह अज्ञान के सारे अंधकार को उड़ा देता है।
            यह कोई साधारण कल्पना नहीं है; यह एक वाइब्रेशन (Vibration) है जिसे योगी सच में अपने सीने के बीच में महसूस करता है।
            यही वह जगह है जहाँ इंसान की ऊर्जा सीधे ब्रह्मांड की ऊर्जा से जुड़कर उसे एक 'सुपर-ह्यूमन' (Superhuman) बना देती है।
        """.trimIndent(),
        english = """
            When that heart-lotus is completely bloomed, the seeker must firmly establish and seat (Nyasyet) his 'Prana' (Consciousness) exactly in the absolute middle of that lotus.
            In that exact center, he must also establish the life-giving letter 'U' and the imperishable 'Akshara' (OM) with absolute, unwavering concentration.
            Then, actively making that Omkara fully endowed with the 'Bindu' and the 'Nada' (Bindunadamayam), meaning listening to the echo with total focus.
            He must allow that Supreme Nada (divine sound) to completely explode, pulse, and fiercely resonate (Prasphuret) right within his heart.
            Here, the instruction is to bring the meditation strictly and flawlessly to the absolute 'Center point' of the heart.
            As long as the mind wanders, OM is useless; OM must be forcefully seated exactly in the 'middle' of the lotus.
            'Bindu' means sharp Focus and 'Nada' means the Sound; one must meditate actively combining both of these.
            When this Nada explodes in the heart, it blows away all the dark ignorance exactly like a massive cosmic bomb.
            This is absolutely not ordinary imagination; it is a profound Vibration that the Yogi truly, physically feels right in the middle of his chest.
            This is exactly the place where a human's energy directly connects with the universe's energy, flawlessly making him a 'Superhuman'.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 10,
        sanskrit = "तन्मध्ये तु स्थिता देवा ब्रह्माविष्णुमहेश्वराः । तन्मध्ये सन्ततं ध्यायेत् सूर्यसोमाग्निमण्डलम् ॥ १० ॥",
        hindi = """
            उस खिले हुए हृदय-कमल के बिल्कुल मध्य भाग में साक्षात् ब्रह्मा, विष्णु और महेश्वर (शिव)—ये तीनों परम देव स्थित (विराजमान) हैं।
            साधक को उसी मध्य भाग में अत्यंत निरंतरता (सन्ततं) के साथ 'सूर्य-मंडल', 'चंद्र-मंडल' और 'अग्नि-मंडल' का भी गहराई से ध्यान करना चाहिए।
            यह श्लोक शरीर के भीतर ब्रह्मांड के सबसे बड़े देवताओं और शक्तियों के दर्शन (Visualization) की विधि है।
            ब्रह्मा (सृजन), विष्णु (पालन) और शिव (विनाश) कोई आसमान में बैठे व्यक्ति नहीं हैं; ये हमारी आत्मा की ही तीन शक्तियां हैं।
            जब हम अपने हृदय में ध्यान लगाते हैं, तो हम साक्षात् इन तीनों परम शक्तियों को एक ही जगह (Center) पर महसूस करते हैं।
            सूर्य-मंडल प्रकाश, ज्ञान और पुरुष-ऊर्जा (Pingala / Right brain) का प्रतीक है।
            चंद्र-मंडल शांति, करुणा और स्त्री-ऊर्जा (Ida / Left brain) का प्रतीक है।
            और अग्नि-मंडल कुण्डलिनी की वह परम ज्वाला (Sushumna) है जो इन दोनों के मिलन से हृदय में भड़कती है।
            जब साधक इन तीनों मंडलों को अपने सीने में एक साथ देखता है, तो उसका शरीर एक 'यज्ञ-वेदी' (Sacrificial altar) बन जाता है।
            इस ध्यान से शरीर और मन का सारा अंधकार हमेशा के लिए भस्म हो जाता है और जीव सीधे ईश्वर बन जाता है।
        """.trimIndent(),
        english = """
            Right in the absolute center of that fully bloomed heart-lotus, the Supreme Gods—Brahma, Vishnu, and Maheshwara (Shiva)—are directly seated and established.
            The sincere seeker must continuously and relentlessly (Santatam) meditate upon the 'Solar Mandala', the 'Lunar Mandala', and the 'Fire Mandala' exactly in that very center.
            This magnificent verse is the absolute method of Visualizing the cosmos's greatest gods and ultimate powers strictly within the physical body.
            Brahma (Creation), Vishnu (Sustenance), and Shiva (Destruction) are absolutely not persons in the sky; they are the three supreme powers of our very own Soul.
            When we meditate deeply in our heart, we directly feel and experience all three of these supreme powers simultaneously in one single Center.
            The Solar Mandala perfectly symbolizes light, profound wisdom, and masculine energy (Pingala / Right brain).
            The Lunar Mandala beautifully symbolizes ultimate peace, boundless compassion, and feminine energy (Ida / Left brain).
            And the Fire Mandala is that supreme, blazing flame of Kundalini (Sushumna) that fiercely erupts in the heart from the exact union of the two.
            When the seeker perfectly sees all three Mandalas together in his chest, his physical body instantly becomes a divine 'Sacrificial Altar' (Yajna-vedi).
            Through this supreme meditation, all the darkness of the body and mind is burnt to ashes forever, and the creature becomes God directly.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 11,
        sanskrit = "अकारो नेत्रयोर्मध्ये उकारः कण्ठदेशके । मकारो हृदये संस्थो बिन्दुर्नादस्तु मस्तकम् ॥ ११ ॥",
        hindi = """
            (ॐकार के अक्षरों का शरीर में स्थान): ॐ का पहला अक्षर 'अ' (अकार) साधक के दोनों नेत्रों (आँखों) के बिल्कुल मध्य (बीच) में स्थित है।
            ॐ का दूसरा अक्षर 'उ' (उकार) साधक के कंठ (गले) के प्रदेश (Vishuddhi Chakra) में स्थित माना जाता है।
            ॐ का तीसरा अक्षर 'म' (मकार) साधक के हृदय (Anahata Chakra) में पूरी तरह से स्थित (संस्थो) है।
            तथा ॐ के ऊपर का जो 'बिंदु' और 'नाद' (गूँज) है, वह साधक के मस्तक (सिर के ऊपरी हिस्से / Crown) में स्थित है।
            यहाँ ॐ की ध्वनि को हमारे नर्वस सिस्टम (Nervous System) और चक्रों (Chakras) के साथ जोड़ा गया है।
            जब हम 'अ' बोलते हैं, तो उसका फोकस दोनों आँखों के बीच (आज्ञा चक्र) पर रखना चाहिए, जो ज्ञान की तीसरी आँख है।
            जब 'उ' बोलते हैं, तो ध्यान गले पर आता है, जहाँ से हमारी वाणी और भावनाएं (Emotions) पैदा होती हैं।
            जब 'म' बोलते हैं (होंठ बंद करके), तो सारा कंपन (Vibration) सीधे छाती (हृदय) में उतर जाता है, जहाँ शांति है।
            और जब आवाज़ खत्म होने के बाद जो 'सन्नाटा' और गूँज (नाद) बचता है, वह सीधे हमारे दिमाग (मस्तक) को शून्य कर देता है।
            इस तरह ॐ का उच्चारण एक साधारण क्रिया नहीं, बल्कि पूरे शरीर को 'ट्यून' (Tune) करने की एक अत्यंत वैज्ञानिक प्रक्रिया है।
        """.trimIndent(),
        english = """
            (The exact physical locations of OM's letters in the body): The first letter 'A' (Akara) of OM is firmly situated exactly in the absolute middle of the seeker's two eyes.
            The second letter 'U' (Ukara) of OM is considered to be perfectly located strictly in the region of the seeker's throat (Vishuddhi Chakra).
            The third letter 'M' (Makara) of OM is completely and firmly established (Samstho) right within the seeker's heart (Anahata Chakra).
            And the 'Bindu' and 'Nada' (the echoing sound) positioned above OM are situated directly at the absolute top of the seeker's head (Crown/Mastaka).
            Here, the divine sound of OM is flawlessly and scientifically linked directly with our Nervous System and the subtle Chakras.
            When we actively chant 'A', the sharp focus must be strictly held between the two eyes (Ajna Chakra), which is the third eye of supreme wisdom.
            When chanting 'U', the profound attention naturally drops to the throat, from where all our speech and deep emotions are generated.
            When chanting 'M' (with lips perfectly closed), the entire powerful vibration descends straight into the chest (Heart), where ultimate peace resides.
            And the profound 'Silence' and subtle echo (Nada) that remains after the sound ends completely neutralizes and zeroes the entire brain (Crown).
            Thus, chanting OM is absolutely not an ordinary activity, but a highly scientific, supreme process of perfectly 'Tuning' the entire human body.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 12,
        sanskrit = "प्राणोऽपानः समानश्च उदानो व्यान एव च । पञ्चप्राणा इमे प्रोक्ताः शरीरेषु शरीरिणाम् ॥ १२ ॥",
        hindi = """
            मनुष्यों (शरीरियों) के भौतिक शरीरों (शरीरेषु) में मुख्य रूप से पाँच प्रकार की प्राण वायु (Vital energies) मौजूद होती हैं।
            इन पाँच मुख्य प्राणों के नाम हैं: 1. प्राण, 2. अपान, 3. समान, 4. उदान, और 5. व्यान।
            विद्वान ऋषियों द्वारा इन पाँचों को ही शरीर के भीतर कार्य करने वाले 'पञ्चप्राण' (Five Pranas) के रूप में कहा (प्रोक्ताः) गया है।
            यहाँ से उपनिषद सांसों के विज्ञान (Science of Breath/Prana) की एक अत्यंत गहरी चर्चा शुरू करता है।
            हम सोचते हैं कि हम जो हवा नाक से खींचते हैं, बस वही एक साँस (प्राण) है; पर योग विज्ञान कहता है कि यह ऊर्जा शरीर में पाँच अलग-अलग काम करती है।
            'प्राण' वह ऊर्जा है जो हवा को अंदर खींचती है और हमें जीवन देती है (Inward energy)।
            'अपान' वह ऊर्जा है जो शरीर से मल, मूत्र और गंदी हवा को नीचे की ओर धकेल कर बाहर निकालती है (Downward energy)।
            'समान' वह ऊर्जा है जो पेट में रहकर हमारे खाए हुए भोजन को पचाती (Digest) और रस बाँटती है।
            'उदान' ऊर्जा हमें बोलने की ताकत देती है और मौत के समय आत्मा को शरीर से बाहर निकालती है।
            'व्यान' पूरे शरीर में खून के साथ दौड़कर हर सेल (Cell) तक ताकत पहुँचाती है; इन पाँचों के बिना जीवन एक सेकंड भी नहीं चल सकता।
        """.trimIndent(),
        english = """
            Within the physical bodies (Sharireshu) of all embodied human beings, there essentially exist exactly five distinct types of vital air (Vital energies).
            The specific names of these five primary Pranas are: 1. Prana, 2. Apana, 3. Samana, 4. Udana, and 5. Vyana.
            These exact five are profoundly declared (Proktah) by the wise ancient sages as the 'Pancha-Pranas' (Five Pranas) functioning actively within the body.
            From here, the Upanishad brilliantly initiates an exceptionally profound discussion on the Science of Breath (Prana).
            We falsely assume that the physical air we pull through our nose is the only breath (Prana); but Yoga science declares this energy performs five completely different tasks in the body.
            'Prana' is the specific inward energy that actively pulls air inside and constantly provides us with vibrant life.
            'Apana' is the downward energy that forcefully pushes out and actively expels feces, urine, and toxic air completely out of the body.
            'Samana' is the balancing energy residing in the stomach that flawlessly digests our consumed food and perfectly distributes the nutrients.
            'Udana' is the upward energy that grants us the immense power of speech and violently ejects the soul out of the body at the exact moment of death.
            'Vyana' continuously rushes throughout the entire body with the blood, delivering raw power to every single cell; without these five, life cannot exist for even a second.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 13,
        sanskrit = "नागः कूर्मश्च कृकरो देवदत्तो धनञ्जयः । पञ्चोपप्राणनामानि... ॥ १३ ॥",
        hindi = """
            उन पाँच मुख्य प्राणों के अलावा, शरीर में पाँच 'उपप्राण' (Secondary Pranas / सहायक ऊर्जाएं) भी होते हैं।
            इन पाँच उपप्राणों के नाम हैं: 1. नाग, 2. कूर्म, 3. कृकर, 4. देवदत्त, और 5. धनञ्जय।
            शरीर की हर छोटी-बड़ी हरकत (Movement) के पीछे इन्ही ऊर्जाओं (प्राण और उपप्राण) का हाथ होता है।
            'नाग' उपप्राण वह ऊर्जा है जो हमें डकार (Burping) और हिचकी (Hiccups) लाती है; यह पेट की फालतू हवा निकालती है।
            'कूर्म' उपप्राण हमारी आँखों की पलकों को झपकाने (Blinking) का काम करता है; यह आँखों की रक्षा करता है।
            'कृकर' उपप्राण वह ऊर्जा है जो हमें छींक (Sneezing) और भूख-प्यास का अहसास कराती है।
            'देवदत्त' उपप्राण हमें जम्हाई (Yawning) लेने और नींद लाने का काम करता है।
            और सबसे रहस्यमयी है 'धनञ्जय'; यह वह उपप्राण है जो इंसान के मरने के बाद भी शरीर में कुछ समय तक रहता है और शरीर को फुलाता है।
            योग विज्ञान इंसान के शरीर को केवल हाड़-मांस का पुतला नहीं, बल्कि 10 अलग-अलग ऊर्जाओं (Winds) से चलने वाली एक अत्यंत जटिल मशीन (Machine) मानता है।
            योगी जब ध्यान करता है, तो वह इन दसों ऊर्जाओं को अपने कंट्रोल (Control) में ले लेता है।
        """.trimIndent(),
        english = """
            Apart from those five primary Pranas, there also actively exist five 'Upa-Pranas' (Secondary Pranas / auxiliary energies) strictly within the physical body.
            The specific names of these five Upa-pranas are: 1. Naga, 2. Kurma, 3. Krikara, 4. Devadatta, and 5. Dhananjaya.
            Absolutely every single minor and major physical movement of the body is perfectly orchestrated by the direct action of these specific energies (Pranas and Upa-pranas).
            The 'Naga' Upa-prana is the specific energy that directly causes us to burp and hiccup; it actively expels useless, trapped air from the stomach.
            The 'Kurma' Upa-prana flawlessly operates the rapid blinking of our eyelids; it actively and fiercely protects the sensitive eyes.
            The 'Krikara' Upa-prana is that specific energy that induces violent sneezing and intensely triggers the biological sensations of hunger and thirst.
            The 'Devadatta' Upa-prana actively causes us to yawn deeply and induces the heavy onset of sleep.
            And the most mystical is 'Dhananjaya'; this is the unique Upa-prana that remains actively in the body even after death and causes the corpse to bloat.
            Yoga science absolutely does not consider the human body as a mere puppet of flesh, but an exceptionally complex Machine driven flawlessly by 10 distinct winds (energies).
            When a true Yogi meditates deeply, he systematically brings all ten of these powerful energies under his absolute, flawless Control.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 14,
        sanskrit = "हृदि प्राणः गुदेऽपानः समानो नाभिमण्डले । उदानः कण्ठदेशे स्याद्व्यानः सर्वशरीरगः ॥ १४ ॥",
        hindi = """
            (अब पाँच मुख्य प्राणों का शरीर में स्थान बताया जा रहा है): जो मुख्य 'प्राण' वायु है, वह मनुष्य के हृदय (Chest/छाती) में स्थित है।
            'अपान' वायु का मुख्य निवास स्थान गुदा (Anus / शरीर का निचला हिस्सा) है, जहाँ से यह गंदगी को बाहर धकेलता है।
            'समान' वायु नाभि के घेरे (नाभिमंडल / Navel region) में रहती है, जहाँ यह पाचन (Digestion) की अग्नि को जलाए रखती है।
            'उदान' वायु का मुख्य स्थान कण्ठ (गला / Throat) है, जहाँ से यह आवाज़ और ऊर्जा को ऊपर ले जाती है।
            और 'व्यान' वायु किसी एक जगह नहीं, बल्कि संपूर्ण शरीर (सर्वशरीरगः) में नसों (Veins) के माध्यम से लगातार दौड़ती रहती है।
            यह श्लोक प्राचीन योग का पूरा 'एनाटॉमी' (Anatomy) चार्ट है।
            बीमारी तब होती है जब ये प्राण अपनी जगह से हट जाते हैं या इनका फ्लो (Flow) ब्लॉक (Block) हो जाता है।
            अगर 'समान' वायु कमजोर हो जाए, तो इंसान का खाना नहीं पचेगा (Indigestion)।
            अगर 'अपान' वायु ऊपर की ओर उल्टी चलने लगे, तो इंसान को कब्ज या गैस की भयंकर पीड़ा होगी।
            प्राणायाम (सांसों की एक्सरसाइज) का असली मकसद इन पाँचों प्राणों को उनकी सही जगह पर बैलेंस (Balance) करना है।
        """.trimIndent(),
        english = """
            (Now the exact locations of the five primary Pranas in the body are detailed): The main 'Prana' vayu is firmly located specifically in the human's heart (Chest region).
            The primary residence of the 'Apana' vayu is the anus (lower part of the body), from exactly where it forcefully pushes out bodily waste.
            The 'Samana' vayu permanently resides in the circular region of the navel (Nabhi-mandala), where it flawlessly maintains the blazing fire of Digestion.
            The primary location of the 'Udana' vayu is the throat (Kantha), from exactly where it powerfully carries the voice and upward-moving energy.
            And the 'Vyana' vayu absolutely does not stay in one place, but continuously and relentlessly rushes throughout the entire physical body (Sarvashariragah) via the blood veins.
            This magnificent verse is the absolute, complete 'Anatomy' chart of ancient Yoga science.
            Physical disease strictly occurs when these specific Pranas get displaced from their original locations or when their vital Flow gets severely Blocked.
            If the 'Samana' vayu becomes weak, the human's consumed food will simply fail to digest (severe Indigestion).
            If the 'Apana' vayu falsely reverses and starts moving upwards, the human will suffer terrifying agony from severe constipation or trapped gas.
            The actual, ultimate purpose of Pranayama (breathing exercises) is to flawlessly Balance all these five Pranas perfectly in their rightful, exact locations.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 15,
        sanskrit = "बद्धो येन सुवेगेन प्राणापानेन कर्षते । रज्जुबद्धो यथा श्येनो गतोऽप्याकृष्यते पुनः ॥ १५ ॥",
        hindi = """
            यह जीव (आत्मा) इस शरीर में प्राण और अपान वायु के द्वारा बहुत ही तेज गति से (सुवेगेन) कसकर बँधा (बद्धो) हुआ है और बार-बार ऊपर-नीचे खींचा (कर्षते) जाता है।
            ठीक उसी प्रकार, जैसे एक मजबूत रस्सी से बँधा (रज्जुबद्धो) हुआ बाज़ पक्षी (श्येनो) उड़कर दूर जाने पर भी (गतोऽपि)।
            उस रस्सी के खिंचाव के कारण फिर से वापस (पुनः) अपने मालिक के पास खींच (आकृष्यते) लिया जाता है।
            यह श्लोक इंसान की मजबूरी (Helplessness) का सबसे शानदार उदाहरण देता है।
            हम सोचते हैं कि हम आज़ाद हैं, पर सच तो यह है कि हमारी साँसें (प्राण और अपान) ही हमारी 'रस्सी' हैं।
            'प्राण' ऊर्जा हमें ऊपर की ओर खींचती है, और 'अपान' ऊर्जा हमें नीचे की ओर धकेलती है; यह रस्साकशी (Tug-of-war) दिन-रात चल रही है।
            जीव (आत्मा) एक पक्षी की तरह है जो आज़ाद होकर ब्रह्मांड में उड़ना चाहता है।
            पर जैसे ही वह उड़ना शुरू करता है, साँस की रस्सी उसे वापस इस हाड़-मांस के पिंजरे (शरीर) में खींच लाती है।
            जब तक यह साँस ऊपर-नीचे चल रही है, तब तक इंसान का मन कभी भी शांत (Stable) नहीं हो सकता।
            योगी प्राणायाम (कुम्भक) के द्वारा इस साँस की रस्सी को 'काट' देता है, ताकि पक्षी हमेशा के लिए आज़ाद होकर मोक्ष के आसमान में उड़ सके।
        """.trimIndent(),
        english = """
            This Jiva (individual soul) is bound (Baddho) exceptionally tightly in this body and is continuously and fiercely pulled up and down (Karshate) at extreme high speed (Suvegena) by the Prana and Apana breaths.
            Exactly in the same manner as a hunting falcon (Shyeno) tightly tied by a strong rope (Rajjubaddho), even after flying far away (Gato'pi).
            Is forcefully and inevitably dragged (Akrishyate) right back (Punah) to its master strictly due to the intense pulling of that heavy rope.
            This magnificent verse provides the absolute most brilliant example of human Helplessness and physical bondage.
            We falsely and arrogantly assume we are free, but the absolute truth is that our very own breaths (Prana and Apana) are our literal 'Rope'.
            The 'Prana' energy violently pulls us upwards, and the 'Apana' energy brutally pushes us downwards; this brutal Tug-of-war goes on fiercely day and night.
            The Jiva (Soul) is exactly like a majestic bird that desperately wants to fly freely in the infinite cosmos.
            But the exact moment it begins to fly, the heavy rope of breath violently drags it right back into this fleshy cage (the body).
            As long as this breath continues to move up and down, the human mind can absolutely never, ever become perfectly Stable or calm.
            A master Yogi, strictly through Pranayama (Kumbhaka), flawlessly 'Cuts' this heavy rope of breath, so the bird can fly permanently free in the infinite sky of Moksha.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 16,
        sanskrit = "प्राणापानवशो जीवो ह्यधश्चोर्ध्वं प्रधावति । वामदक्षिणमार्गेण चञ्चलत्वान्न दृश्यते ॥ १६ ॥",
        hindi = """
            यह बेचारा जीव (आत्मा) प्राण और अपान वायु के पूरी तरह से वश (गुलामी) में होने के कारण ही शरीर में हमेशा नीचे (अधः) और ऊपर (ऊर्ध्वं) की ओर दौड़ता (प्रधावति) रहता है।
            वह प्राण कभी बायीं नाड़ी (वाम/इड़ा/Left Nostril) से और कभी दाहिनी नाड़ी (दक्षिण/पिंगला/Right Nostril) के रास्ते (मार्गेण) से लगातार बहता रहता है।
            इस अत्यंत तेज चंचलता (चञ्चलत्वात्) और लगातार ऊपर-नीचे भागने के कारण ही, वह स्थिर आत्मा (ईश्वर) मनुष्य को कभी दिखाई (दृश्यते) नहीं देती।
            आप कभी गौर करें, आपकी साँस कभी बायें नथुने (Nostril) से चलती है, तो कभी दाहिने नथुने से।
            बायीं नाड़ी (इड़ा) चंद्र नाड़ी है जो शरीर को ठंडा करती है, और दाहिनी (पिंगला) सूर्य नाड़ी है जो शरीर को गर्म और एक्टिव (Active) करती है।
            जीव (हमारा मन) इन्हीं दोनों के बीच एक पेंडुलम (Pendulum) की तरह झूलता रहता है; कभी हम आलसी होते हैं, कभी हम बहुत गुस्से में होते हैं।
            साँसों की इसी भाग-दौड़ के कारण हमारा मन इतना अशांत रहता है कि हम अपने अंदर बैठे भगवान को देख ही नहीं पाते।
            जैसे हिलते हुए और गंदे पानी में आपको अपना चेहरा नहीं दिख सकता, वैसे ही भागती हुई साँस में आत्मा नहीं दिख सकती।
            आत्मा को देखने (साक्षात्कार) के लिए इन दोनों (इड़ा और पिंगला) की भाग-दौड़ को रोककर साँस को 'सुषुम्ना' (बीच के रास्ते) में लाना पड़ता है।
            यही कारण है कि हर ध्यान की शुरुआत 'साँसों पर फोकस' करने से होती है।
        """.trimIndent(),
        english = """
            This helpless Jiva (Soul), strictly because it is entirely under the absolute control and slavery (Vasha) of the Prana and Apana breaths, constantly runs (Pradhavati) forcefully downwards (Adhah) and upwards (Urdhvam) in the body.
            That vital breath flows continuously, sometimes strictly through the Left Nadi (Vama/Ida/Left Nostril) and sometimes through the path (Margena) of the Right Nadi (Dakshina/Pingala/Right Nostril).
            Strictly due to this extreme, rapid restlessness (Chanchalatvat) and continuous frantic running up and down, that perfectly still Soul (God) is absolutely never seen (Drisyate) by the human.
            If you carefully observe, your breath actively flows sometimes solely through the left nostril, and sometimes strictly through the right.
            The left Nadi (Ida) is the lunar channel that cools the body, and the right (Pingala) is the solar channel that violently heats and activates the body.
            The Jiva (our mind) fiercely swings exactly like a rapid Pendulum between these two; sometimes we are heavily lethargic, sometimes we are violently angry.
            Strictly because of this frantic, chaotic rushing of the breath, our mind remains so incredibly disturbed that we simply cannot see the God sitting inside us.
            Just as you absolutely cannot see your reflection in violently shaking, muddy water, you absolutely cannot see the Soul in a violently rushing breath.
            To successfully see (realize) the Soul, one must forcefully stop the chaotic running of both (Ida and Pingala) and strictly bring the breath into the 'Sushumna' (the absolute middle path).
            This is the exact reason why absolutely every profound meditation strictly begins with 'Focusing intensely on the breath'.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 17,
        sanskrit = "अपानः कर्षति प्राणं प्राणोऽपानं च कर्षति । रज्जुबद्धो यथा श्येनो गतोऽप्याकृष्यते पुनः ॥ १७ ॥",
        hindi = """
            (पिछले उदाहरण को और अधिक स्पष्ट करते हुए): शरीर में 'अपान' वायु (नीचे जाने वाली ऊर्जा) लगातार 'प्राण' वायु (ऊपर जाने वाली ऊर्जा) को अपनी ओर नीचे खींचती (कर्षति) है।
            और उसी समय 'प्राण' वायु भी उस 'अपान' को लगातार अपनी ओर ऊपर खींचती (कर्षति) रहती है (अर्थात शरीर के अंदर 24 घंटे एक रस्साकशी चल रही है)।
            ठीक वैसे ही, जैसे एक मजबूत रस्सी से बँधा हुआ बाज़ पक्षी (श्येनो) उड़कर दूर जाने पर भी (गतोऽपि)।
            उस रस्सी के भयंकर खिंचाव के कारण फिर से वापस (पुनः) नीचे अपने मालिक के पास खींच (आकृष्यते) लिया जाता है।
            यह श्लोक हमारे जीवन के सबसे बड़े संघर्ष (Struggle) को दिखाता है: जीवन (प्राण) और मृत्यु (अपान) की लड़ाई।
            जब हम साँस अंदर लेते हैं (प्राण), तो हमें जिंदगी मिलती है; पर साँस अंदर रुकती नहीं, अपान उसे धकेल कर बाहर (मौत की तरफ) ले जाता है।
            इंसान की सारी ताकत इसी साँसों की लड़ाई में खर्च हो रही है, इसलिए वह जल्दी बूढ़ा होकर मर जाता है।
            योगी इस बात को समझ लेता है; वह प्राण और अपान को आपस में लड़ाने के बजाय, प्राणायाम से इन दोनों को 'मिला' (Merge) देता है।
            जब प्राण और अपान आपस में मिल जाते हैं, तो वह 'रस्साकशी' खत्म हो जाती है, और शरीर में एक अद्भुत शांति (सुषुम्ना का जागरण) छा जाती है।
            उस शांति के आते ही मन रूपी पक्षी की रस्सी कट जाती है और वह मोक्ष के आसमान में हमेशा के लिए उड़ जाता है।
        """.trimIndent(),
        english = """
            (Further clarifying the previous profound example): In the physical body, the 'Apana' vayu (downward-moving energy) continuously and violently drags (Karshati) the 'Prana' vayu (upward-moving energy) downwards towards itself.
            And at the exact same moment, the 'Prana' vayu also relentlessly and forcefully pulls (Karshati) that 'Apana' upwards towards itself (meaning, a brutal 24-hour tug-of-war is fiercely happening inside the body).
            Exactly in the precise same manner as a hunting falcon (Shyeno) tightly tied by a strong rope, even after flying far away (Gato'pi).
            Is forcefully and inevitably dragged (Akrishyate) right back (Punah) down to its master strictly due to the intense, violent pulling of that heavy rope.
            This magnificent verse vividly showcases the absolute greatest Struggle of our human existence: the fierce battle between Life (Prana) and Death (Apana).
            When we actively inhale (Prana), we gain vibrant life; but the breath does not stay inside, Apana violently pushes it back out (towards death).
            All of a human's vital strength is being massively exhausted strictly in this brutal battle of breaths, which is exactly why he ages rapidly and dies.
            A master Yogi understands this perfectly; instead of letting Prana and Apana violently fight each other, he flawlessly 'Merges' them together strictly through Pranayama.
            When Prana and Apana completely merge into one, that brutal 'tug-of-war' ends permanently, and a miraculous, absolute peace (awakening of Sushumna) envelops the body.
            The exact moment that supreme peace arrives, the heavy rope of the mind-bird is permanently severed, and it flies freely into the infinite sky of Moksha forever.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 18,
        sanskrit = "ऊर्ध्वाधः संस्थितावेतौ यो वेद स हि योगवित् । हकारेण बहिर्याति सकारेण विशेत्पुनः ॥ १८ ॥",
        hindi = """
            जो व्यक्ति शरीर के भीतर ऊपर (ऊर्ध्व/प्राण) और नीचे (अधः/अपान) स्थित इन दोनों प्राणों के इस गुप्त खेल (रस्साकशी) को यथार्थ रूप में जान लेता है (यो वेद)।
            वास्तव में केवल वही मनुष्य योग का सच्चा ज्ञाता और असली 'योगवित्' (Master of Yoga) है।
            हमारा यह जीव (आत्मा/श्वास) हमेशा 'हं' (हकारेण) की ध्वनि (नाद) के साथ शरीर से बाहर की ओर निकलता है (बहिर्याति)।
            और फिर वह जीव 'सः' (सकारेण) की ध्वनि के साथ वापस शरीर के भीतर प्रवेश (विशेत्) करता है (अर्थात हर साँस 'हंस' का जाप कर रही है)।
            योग कोई जिमनास्टिक्स (Gymnastics) नहीं है; योग तो साँसों के इस विज्ञान को बारीकी से समझकर उसे कंट्रोल करने का नाम है।
            जो इस श्वास के विज्ञान को नहीं जानता, वह चाहे 50 साल तक आसन करे, वह कभी योगी नहीं बन सकता।
            हमारी हर साँस एक मंत्र है: बाहर जाते समय 'हं' और अंदर आते समय 'सः'।
            'हंस' (अहं सः) का अर्थ है: "मैं वह (परमात्मा) हूँ।" यह ब्रह्मांड का सबसे बड़ा और प्राकृतिक मंत्र (अजपा जाप) है।
            इंसान दिन भर में 21,600 बार साँस लेता है, यानी प्रकृति हमसे 21,600 बार बुलवाती है कि "मैं भगवान हूँ।"
            पर हम अज्ञानी इस मुफ्त के महामंत्र को अनसुना करके मंदिरों में पैसे देकर भगवान ढूँढते हैं।
        """.trimIndent(),
        english = """
            That specific person who thoroughly and precisely understands (Yo veda) this highly secret game (tug-of-war) of these two vital breaths located intensely upwards (Urdhva/Prana) and downwards (Adhah/Apana) within the body.
            In absolute reality, that human alone is the true, authentic knower of Yoga and the real 'Yogavit' (Master of Yoga).
            This Jiva (Soul/breath) of ours continuously and constantly goes out (Bahiryati) of the physical body strictly with the distinct sound of 'Ham' (Hakarena).
            And then that exact same Jiva powerfully enters back inside (Vishet) the body strictly with the sound of 'Sah' (Sakarena) (Meaning, every single breath is chanting 'Hamsa').
            Yoga is absolutely not mere physical Gymnastics; Yoga is the profound name of meticulously understanding and flawlessly controlling this exact science of the breath.
            He who absolutely does not know this deep science of breath, even if he performs physical postures for 50 years, can absolutely never become a true Yogi.
            Every single breath of ours is a supreme mantra: going out is 'Ham' and coming precisely in is 'Sah'.
            'Hamsa' (Aham Sah) literally means: "I am That (Supreme Lord)." This is the universe's absolute greatest and completely natural mantra (Ajapa Japa).
            A human breathes exactly 21,600 times a day, meaning Nature effortlessly makes us loudly declare 21,600 times a day that "I am God."
            But we ignorant fools completely ignore this free, ultimate Maha-mantra and foolishly go searching for God by paying money in physical temples.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 19,
        sanskrit = "हंस हंसेत्यमुं मन्त्रं जीवो जपति सर्वदा । षट्शतानि दिवारात्रौ सहस्राण्येकविंशतिः ॥ १९ ॥",
        hindi = """
            (पिछले श्लोक को स्पष्ट करते हुए): यह जीव (मनुष्य) अपनी हर एक साँस के साथ निरंतर "हंस हंस" (मैं वह परमात्मा हूँ) इस महामंत्र का हमेशा (सर्वदा) जाप करता रहता है।
            दिन और रात (दिवारत्रौ) के पूरे 24 घंटों को मिलाकर, यह जीव कुल इक्कीस हजार छः सौ (21,600) बार इस 'हंस' मंत्र का जप करता है।
            यह कोई ऐसा मंत्र नहीं है जिसे माला लेकर बैठना पड़े; यह प्रकृति का एक 'ऑटोमैटिक सिस्टम' (Automatic system) है जो पैदाइश से मौत तक चलता है।
            हम सो रहे हों, खा रहे हों, या लड़ रहे हों—हमारा शरीर लगातार भगवान का नाम पुकार रहा है।
            परंतु इस 'अजपा जाप' (बिना जपे होने वाला जाप) का फायदा हमें तब तक नहीं मिलता, जब तक हम इसके प्रति 'सचेत' (Aware) नहीं होते।
            जिस दिन साधक आँखें बंद करके अपनी साँसों में गूँजते इस 'हंस' (सोऽहम्) मंत्र को ध्यान से सुनने लगता है।
            उसी दिन से उसकी साधारण साँस 'साधना' (Spiritual practice) में बदल जाती है।
            फिर उसे किसी दूसरे गुरु मंत्र की जरूरत नहीं पड़ती; उसकी अपनी साँस ही उसकी सबसे बड़ी गुरु बन जाती है।
            21,600 का यह आंकड़ा प्राचीन भारतीय विज्ञान की अत्यंत बारीकी को दर्शाता है जो आधुनिक विज्ञान से बिल्कुल मेल खाता है।
            इस एक मंत्र को होशपूर्वक (Consciously) सुनने वाला इंसान बहुत जल्दी समाधि (Moksha) को प्राप्त कर लेता है।
        """.trimIndent(),
        english = """
            (Clarifying the previous verse): This Jiva (human being) continuously and flawlessly chants this ultimate Maha-mantra "Hamsa Hamsa" (I am That Supreme Lord) at all times (Sarvada) with every single breath.
            Combining the entire 24 hours of the day and night (Divaratrau), this Jiva strictly chants this 'Hamsa' mantra exactly twenty-one thousand six hundred (21,600) times.
            This is absolutely not a mantra where you have to sit holding physical prayer beads; this is Nature's flawless 'Automatic System' that actively runs non-stop from birth to death.
            Whether we are sleeping, frantically eating, or violently fighting—our physical body is continuously calling out the exact name of God.
            However, we absolutely do not receive the massive benefit of this 'Ajapa Japa' (un-chanted chanting) until we become completely 'Aware' (Conscious) of it.
            The exact day the seeker closes his eyes and begins to listen highly attentively to this 'Hamsa' (So-ham) mantra actively echoing in his breaths.
            From that very exact day, his ordinary, worldly breathing flawlessly transforms into absolute 'Sadhana' (Spiritual practice).
            Then he absolutely never needs any other external Guru-mantra; his very own breath flawlessly becomes his absolute greatest Guru.
            This highly precise figure of 21,600 perfectly showcases the astonishing exactness of ancient Indian science, perfectly matching modern biological science.
            The human who listens to this one single mantra Highly Consciously (with awareness) successfully attains Samadhi (Moksha) very, very quickly.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 20,
        sanskrit = "एतज्जपात्सुलभं मोक्षं प्राप्नोति सर्वदा । एतद्विद्यां न जानाति स वै योगी न जायते ॥ २० ॥",
        hindi = """
            इस प्राकृतिक 'हंस' (अजपा जाप) मंत्र के प्रति जागरूक होने और इसका ध्यानपूर्वक जप (जपात्) करने से।
            मनुष्य अत्यंत सरलता (सुलभं) से और हमेशा के लिए उस परम मोक्ष (मुक्ति) को प्राप्त कर लेता है।
            जो व्यक्ति इस अत्यंत रहस्यमयी और महान 'साँसों की विद्या' (एतद्विद्यां) को नहीं जानता और नहीं समझता।
            वह वास्तव में कभी भी एक सच्चा योगी नहीं बन सकता (स वै योगी न जायते), चाहे वह कितना भी शारीरिक अभ्यास क्यों न कर ले।
            यह ध्यानबिंदु उपनिषद का सबसे बड़ा और अंतिम निष्कर्ष (Conclusion) है।
            मोक्ष पाना कोई ऐसा काम नहीं है जिसके लिए पहाड़ तोड़ने पड़ें या भूखा मरना पड़े; यह अत्यंत 'सुलभ' (आसान) है यदि आपको सही तकनीक पता हो।
            और वह तकनीक सिर्फ इतनी है: अपनी साँसों के साथ जुड़ जाओ और यह महसूस करो कि हर साँस कह रही है "मैं ब्रह्म हूँ।"
            जो लोग शरीर को तोड़ने-मरोड़ने को ही योग समझते हैं, उनके मुँह पर यह श्लोक एक करारा तमाचा है।
            योग 'बाहर' (शरीर) से शुरू जरूर होता है, पर वह खत्म 'भीतर' (साँसों और चेतना के मिलन) पर ही होता है।
            इस हंस विद्या (विज्ञान) को जान लेने वाला इंसान दुनिया के बीच रहकर, साँसें लेते हुए ही भगवान बन जाता है।
        """.trimIndent(),
        english = """
            Strictly by becoming highly aware of this natural 'Hamsa' (Ajapa Japa) mantra and chanting it highly attentively (Japat).
            A human being successfully attains that supreme, absolute Moksha (Liberation) exceedingly easily (Sulabham) and permanently forever.
            That specific person who absolutely does not know and utterly fails to understand this highly mystical and great 'Science of Breath' (Etadvidyam).
            He can absolutely, in reality, never ever become a true, genuine Yogi (Sa vai yogi na jayate), no matter how much severe physical practice he aggressively performs.
            This is the absolute greatest and final, supreme Conclusion of the magnificent Dhyanabindu Upanishad.
            Attaining Moksha is absolutely not a harsh task requiring you to smash mountains or violently starve to death; it is extremely 'Sulabha' (easy) if you know the exact, right technique.
            And that supreme technique is simply this: connect intimately with your breaths and deeply feel that every single breath is loudly declaring "I am Brahman."
            For those ignorant people who fiercely consider twisting and breaking the physical body as the only Yoga, this verse is a massive, tight slap on their faces.
            Yoga certainly begins strictly on the 'Outside' (physical body), but it absolutely, perfectly ends strictly on the 'Inside' (the flawless union of breath and consciousness).
            The human who perfectly realizes this magnificent Hamsa Science (Vidya) literally becomes God right while living in the middle of the world, simply by taking breaths.
        """.trimIndent()
    ),
    // ... Continuing dhyanabinduShlokasList from ID 21

    DhyanabinduShloka(
        id = 21,
        sanskrit = "चतुर्दलं स्याद्वाधारं स्वाधिष्ठानं च षड्दलम् । नाभौ दशदलं पद्मं सूर्यसङ्ख्यं तु हृत्कमलम् ॥ २१ ॥",
        hindi = """
            (अब शरीर के सूक्ष्म चक्रों का वर्णन): हमारे भौतिक शरीर के भीतर मूलाधार चक्र (रीढ़ के सबसे नीचे) स्थित है, जिसमें चार पंखुड़ियां हैं।
            उसके ठीक ऊपर स्वाधिष्ठान चक्र (जननांग के पास) है, जिसमें छः पंखुड़ियां (षड्दल) होती हैं।
            नाभि (पेट) के स्थान पर मणिपुर चक्र मौजूद है, जो दस पंखुड़ियों (दशदलं) वाला एक अत्यंत प्रकाशमान कमल है।
            और छाती के मध्य में हमारा अनाहत (हृदय) चक्र स्थित है, जो बारह (सूर्य के समान) पंखुड़ियों वाला है।
            योग विज्ञान में इन चक्रों (Chakras) को ऊर्जा (Energy) के अत्यंत शक्तिशाली पावर हाउस (Powerhouses) माना गया है।
            ये कोई भौतिक अंग नहीं हैं जिन्हें सर्जरी से देखा जा सके; ये प्राण ऊर्जा के अत्यंत सूक्ष्म केंद्र (Subtle centers) हैं।
            हर चक्र हमारे जीवन के किसी न किसी खास मनोवैज्ञानिक और आध्यात्मिक हिस्से को चलाता है।
            जैसे मूलाधार सुरक्षा का केंद्र है, नाभि शक्ति का, और हृदय प्रेम व करुणा का केंद्र है।
            ध्यान के समय साधक की ऊर्जा इन्हीं चक्रों से होते हुए धीरे-धीरे नीचे से ऊपर की ओर यात्रा करती है।
            यह श्लोक ध्यान करने वालों के लिए एक अत्यंत स्पष्ट 'आंतरिक नक्शा' (Internal Map) प्रस्तुत कर रहा है।
        """.trimIndent(),
        english = """
            (Now describing the subtle Chakras): Within our physical body, at the very base of the spine, lies the Muladhara Chakra with exactly four petals.
            Right above it is the Svadhisthana Chakra (near the genitals), which flawlessly possesses exactly six petals (Shaddala).
            At the navel region exists the Manipura Chakra, which is a highly radiant lotus possessing exactly ten petals (Dashadalam).
            And exactly in the center of the chest is our Anahata (Heart) Chakra, adorned brilliantly with twelve sun-like petals.
            In the magnificent science of Yoga, these Chakras are profoundly considered exceptionally powerful Powerhouses of vital energy.
            They are absolutely not physical organs that can be seen through medical surgery; they are exceedingly subtle centers of Prana.
            Every single Chakra flawlessly controls and actively drives specific psychological and deep spiritual aspects of our human life.
            For example, Muladhara is the center of survival, the navel is power, and the heart is pure love and mercy.
            During deep meditation, the seeker's vital energy slowly and steadily travels upwards, passing strictly through these exact energy centers.
            This profound verse essentially provides an incredibly clear and flawless 'Internal Map' explicitly designed for dedicated meditating seekers.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 22,
        sanskrit = "कण्ठे स्यात् षोडशदलं भ्रूमध्यं द्विदलं तथा । सहस्रदलमाख्यातं ब्रह्मरन्ध्रे महापथे ॥ २२ ॥",
        hindi = """
            (चक्रों का वर्णन जारी है): मनुष्य के कण्ठ (गले) के स्थान पर 'विशुद्धि चक्र' स्थित है, जिसमें सोलह (16) पंखुड़ियां होती हैं।
            साधक की दोनों भौंहों के बिल्कुल बीच (भ्रूमध्य) में 'आज्ञा चक्र' स्थित है, जो केवल दो (2) पंखुड़ियों वाला कमल है।
            और सबसे अंत में, सिर के सर्वोच्च शिखर (ब्रह्मरन्ध्र / महापथे) पर 'सहस्रार चक्र' स्थित है जिसे हजार पंखुड़ियों वाला कमल कहा गया है।
            यहाँ तक आते-आते मानव चेतना अपनी सबसे स्थूल (Gross) अवस्था से निकलकर पूर्ण दिव्यता (Divinity) में प्रवेश कर जाती है।
            विशुद्धि चक्र (गला) हमारी वाणी, सच्चाई और आत्मा की शुद्धि का परम केंद्र है।
            आज्ञा चक्र (थर्ड आई / Third Eye) वह जगह है जहाँ साधक को भूत, भविष्य और वर्तमान का सीधा ज्ञान (Intuition) प्राप्त होता है।
            और सहस्रार चक्र (Crown) इंसान का अंतिम गंतव्य (Destination) है, जहाँ वह शिव (परमात्मा) के साथ पूरी तरह से एक हो जाता है।
            हजार पंखुड़ियों का अर्थ अनंतता (Infinity) है; यह वह महापथ (Great Path) है जहाँ से आत्मा सीधे मोक्ष में प्रवेश करती है।
            जब कुण्डलिनी ऊर्जा मूलाधार से उठकर इन सभी चक्रों को भेदती हुई सहस्रार में पहुँचती है, तो समाधि घटित होती है।
            इन चक्रों का ज्ञान योगियों को अपने भीतर छिपी हुई असीम शक्तियों को जगाने में मदद करता है।
        """.trimIndent(),
        english = """
            (Chakra description continues): At the exact location of the human throat exists the 'Vishuddhi Chakra', possessing sixteen (16) petals.
            Directly between the seeker's two eyebrows (Bhrumadhya) is the 'Ajna Chakra', which is a lotus possessing exactly two (2) petals.
            And finally, at the absolute supreme peak of the head (Brahmarandhra / Mahapatha), the 'Sahasrara Chakra' is described as a thousand-petaled lotus.
            Reaching this exact point, human consciousness completely exits its grossest physical state and flawlessly enters pure Divinity.
            The Vishuddhi Chakra (throat) is the absolute supreme center of truthful speech, profound expression, and purification of the soul.
            The Ajna Chakra (Third Eye) is the precise location where the seeker attains direct, flawless intuition and knowledge of the past, present, and future.
            And the Sahasrara Chakra (Crown) is the human's absolute final Destination, where he seamlessly becomes totally one with Shiva (God).
            A thousand petals profoundly signifies Infinity; this is the Great Path (Mahapatha) from where the soul directly enters absolute Moksha.
            When the Kundalini energy violently rises from the Muladhara, piercing all these Chakras, and reaches the Sahasrara, true Samadhi occurs.
            The deep knowledge of these Chakras actively helps Yogis perfectly awaken the boundless, infinite powers hidden right within themselves.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 23,
        sanskrit = "मूलाधारे स्थितं पद्मं चतुर्दलसमन्वितम् । तन्मध्ये बालसूर्याभं वाग्योनिरिति गीयते ॥ २३ ॥",
        hindi = """
            शरीर के सबसे निचले हिस्से (मूलाधार) में चार पंखुड़ियों वाला एक अत्यंत शक्तिशाली कमल स्थित है।
            उस मूलाधार कमल के बिल्कुल बीचों-बीच (मध्य में) एक ऐसा प्रकाश है जो उगते हुए नए सूरज (बाल-सूर्य) के समान चमकता है।
            उसी दिव्य और प्रकाशमान स्थान को महान योगियों द्वारा 'वाग्योनि' (समस्त वाणी और ध्वनि का मूल जन्म-स्थान) कहा गया है।
            मूलाधार चक्र वह फाउंडेशन (Foundation) है जिस पर इंसान की पूरी की पूरी आध्यात्मिक इमारत खड़ी होती है।
            हम जो भी बोलते हैं (शब्द/आवाज़), उसकी सबसे गहरी और सूक्ष्म शुरुआत (Origin) इसी मूलाधार (वाग्योनि) से होती है जिसे 'परा वाणी' कहते हैं।
            बाल-सूर्य (Rising Sun) का रंग लाल होता है, जो अपार ऊर्जा, जीवन-शक्ति और कुण्डलिनी के जागरण का प्रतीक है।
            जब तक यह फाउंडेशन कमजोर रहता है, इंसान हमेशा डर (Insecurity), लालच और शारीरिक सुखों में ही फँसा रहता है।
            लेकिन जब ध्यान के द्वारा यहाँ का सूरज चमकने लगता है, तो इंसान के अंदर एक अभूतपूर्व आत्मविश्वास और शक्ति आ जाती है।
            यही वह पवित्र स्थान है जहाँ से हमारी योग-यात्रा की पहली और सबसे महत्वपूर्ण सीढ़ी शुरू होती है।
            साधक को सबसे पहले अपने ध्यान को इसी 'रूट चक्र' (Root Chakra) पर टिकाकर उसे सिद्ध (Perfect) करना होता है।
        """.trimIndent(),
        english = """
            In the absolute lowest region of the body (Muladhara) is situated an exceedingly powerful lotus endowed perfectly with four petals.
            Exactly in the absolute center of that Muladhara lotus exists a brilliant light shining flawlessly like a rising, new sun (Bala-surya).
            That highly divine and radiantly luminous space is profoundly declared by great Yogis as 'Vagyoni' (the ultimate birthplace of all speech and sound).
            The Muladhara Chakra is the absolute foundational Base upon which the entire magnificent spiritual building of a human being solidly stands.
            Whatever we speak (words/sounds), its absolute deepest and most subtle origin flawlessly begins right from this Muladhara (Vagyoni), known as 'Para Vani'.
            The Rising Sun is deep red, powerfully symbolizing immense raw energy, vibrant life-force, and the explosive awakening of the Kundalini.
            As long as this specific foundation remains weak, a human constantly stays trapped in terrifying insecurity, deep greed, and basic physical pleasures.
            But when the sun of this chakra begins to intensely shine through deep meditation, an unprecedented, colossal self-confidence and power fills the human.
            This is exactly that highly sacred place from where the absolute first and most crucial step of our entire spiritual Yoga journey officially begins.
            The sincere seeker must absolutely first anchor his deep concentration right on this 'Root Chakra' to thoroughly perfect and master it.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 24,
        sanskrit = "तत्र कुण्डलिनी नाम सुप्ता सर्पाकारवत् । तत्र सुप्ता जागर्ति ध्यानयोगेन योगिनाम् ॥ २४ ॥",
        hindi = """
            उसी मूलाधार चक्र के बिल्कुल बीच में 'कुण्डलिनी' (Kundalini) नाम की एक अत्यंत रहस्यमयी और महान शक्ति स्थित है।
            वह शक्ति सामान्य अवस्था में एक कुण्डली मारे हुए 'साँप' (सर्पाकारवत्) की तरह गहरी नींद में सोई (सुप्ता) रहती है।
            परंतु जब योगी अत्यंत कठोर और गहरे 'ध्यान योग' का निरंतर अभ्यास करता है।
            तो वह गहरी नींद में सोई हुई (सुप्ता) कुण्डलिनी शक्ति अचानक पूरी तरह से जागृत (जागर्ति) हो उठती है।
            यह श्लोक प्राचीन योग विज्ञान के सबसे बड़े और सबसे चर्चित रहस्य (Secret)—'कुण्डलिनी जागरण' का खुलासा करता है।
            कुण्डलिनी वह 'ब्रह्मांडीय ऊर्जा' (Cosmic Energy) है जो हर इंसान के अंदर है, पर 99% लोगों में यह जन्म से मौत तक सोई ही रहती है।
            जब यह सोई रहती है, तो इंसान केवल खाना, सोना और पैसे कमाना—इन्हीं साधारण चीजों में उलझा रहता है।
            साँप (Serpent) की उपमा इसलिए दी गई है क्योंकि जब साँप कुंडली मार कर बैठता है तो शांत लगता है, पर जब फन उठाता है तो भयंकर शक्तिशाली होता है।
            ध्यान योग ही वह एकमात्र आग है जो इस सोए हुए 'साँप' को गर्माहट देकर जगाती है।
            जब कुण्डलिनी जागती है, तो इंसान की चेतना (Consciousness) एक साधारण जीव से उठकर साक्षात् भगवान के स्तर तक पहुँच जाती है।
        """.trimIndent(),
        english = """
            Exactly in the absolute center of that Muladhara Chakra exists an exceptionally mystical and supremely magnificent power perfectly named 'Kundalini'.
            In its ordinary, default state, that immense power remains in a very deep sleep (Supta), coiled up exactly like a resting 'Serpent' (Sarpakaravat).
            However, when a sincere Yogi relentlessly practices exceptionally severe and profoundly deep 'Dhyana Yoga' (Meditation).
            That deeply sleeping (Supta) Kundalini energy suddenly, violently, and completely awakens (Jagarti) to its absolute full potential.
            This phenomenal verse explicitly reveals the absolute greatest and most widely discussed secret of ancient Yoga science—the 'Awakening of Kundalini'.
            Kundalini is that raw 'Cosmic Energy' present within every human, but in 99% of people, it remains fast asleep from birth until death.
            While it remains asleep, a human stays helplessly entangled purely in ordinary tasks like eating, sleeping, and obsessively earning money.
            The metaphor of a 'Serpent' is profoundly used because a coiled snake appears completely docile, but when it raises its hood, it is terrifyingly powerful.
            Dhyana Yoga is the absolute only fire capable of providing enough intense heat to successfully awaken this deeply sleeping 'serpent'.
            When the Kundalini finally awakens, the human's consciousness shoots up flawlessly from the level of a mere creature straight to the level of God.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 25,
        sanskrit = "येन द्वारेण गन्तव्यं ब्रह्मस्थानं निरामयम् । मुखेनाच्छाद्य तद्वारं प्रसुप्ता परमेश्वरी ॥ २५ ॥",
        hindi = """
            जिस अत्यंत सूक्ष्म मार्ग (सुषुम्ना नाड़ी) से होकर साधक को उस रोग-रहित और परम पवित्र 'ब्रह्म-स्थान' (सहस्रार चक्र/मोक्ष) तक जाना होता है।
            यह सोई हुई परमेश्वरी कुण्डलिनी शक्ति अपने मुख (मुँह) से उसी परम द्वार (दरवाजे) को पूरी तरह से ढँक कर (आच्छाद्य) सो रही है।
            (अर्थात मोक्ष का दरवाजा इस सोई हुई कुण्डलिनी ने अपने ही शरीर से बंद कर रखा है)।
            यह श्लोक कुण्डलिनी योग की सबसे बड़ी समस्या (Obstacle) को बहुत ही स्पष्ट रूप से समझाता है।
            रीढ़ की हड्डी के बिल्कुल बीच में एक बहुत ही बारीक नली है जिसे 'सुषुम्ना' कहते हैं, यही वह लिफ्ट (Elevator) है जो आत्मा को भगवान तक ले जाती है।
            परंतु इस लिफ्ट का जो सबसे निचला दरवाजा है, उस पर यह 'परमेश्वरी' (कुण्डलिनी) कुंडली मारकर और मुँह से ताला लगाकर सोई हुई है।
            जब तक यह सो रही है, दरवाजे का ताला नहीं खुल सकता, और इंसान की ऊर्जा कभी भी ऊपर (दिमाग/सहस्रार की ओर) नहीं जा सकती।
            इस दरवाजे के बंद होने के कारण ही हमारी सारी ऊर्जा नीचे के चक्रों (वासना, पेट और डर) में ही बहकर बर्बाद हो जाती है।
            योग का पूरा संघर्ष इसी दरवाजे को खुलवाने का है; जब कुण्डलिनी जागकर अपना मुँह हटाती है, तभी दरवाजा खुलता है।
            यह परमेश्वरी (Supreme Goddess) कोई शैतान नहीं है; यह हमारी परीक्षा लेती है कि हम उस रास्ते पर जाने के लायक (Qualified) हैं या नहीं।
        """.trimIndent(),
        english = """
            The highly subtle pathway (Sushumna Nadi) through which the seeker must exclusively travel to successfully reach the disease-free, supreme 'Brahma-sthana' (Sahasrara/Moksha).
            This deeply sleeping Supreme Goddess (Parameshwari) Kundalini is profoundly slumbering, having completely covered and blocked (Acchadya) that exact door with her own mouth.
            (Meaning, the ultimate door to liberation is strictly locked and barricaded by this sleeping Kundalini with her very own coiled body).
            This magnificent verse exceptionally clearly explains the absolute greatest obstacle (Problem) in the entire practice of Kundalini Yoga.
            Exactly in the center of the spine lies an exceedingly microscopic tube called 'Sushumna'; this is the exact Elevator that takes the soul straight to God.
            But at the absolute lowest door of this elevator, this 'Parameshwari' (Kundalini) is sleeping deeply, coiled up, firmly locking it with her mouth.
            As long as she remains fast asleep, the lock simply cannot open, and the human's vital energy can absolutely never travel upwards (towards the brain/Crown).
            Strictly because this door is shut, all our raw energy is completely wasted, helplessly flowing out entirely through the lower chakras (lust, hunger, fear).
            The entire fierce struggle of Yoga is exclusively to force this door open; only exactly when Kundalini wakes up and moves her mouth does the supreme door unlock.
            This Parameshwari (Supreme Goddess) is absolutely not a devil; she is actively testing whether we are genuinely Qualified enough to travel on that divine path.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 26,
        sanskrit = "प्रबुद्धा वह्नियोगेन मनसा मरुता सह । सूचिवद्गुणमादाय सुषुम्नामार्गमाश्रिता ॥ २६ ॥",
        hindi = """
            जब वह कुण्डलिनी शक्ति योग की अग्नि (वह्नि), एकाग्र मन (मनसा), और प्राणायाम की श्वास (मरुता) के प्रबल प्रहार से जागृत (प्रबुद्धा) हो जाती है।
            तब वह एक सुई (सूचि) के समान अत्यंत तीक्ष्ण और सूक्ष्म आकार धारण करके ऊपर की ओर उठती है।
            और वह सीधा उस 'सुषुम्ना नाड़ी' के परम मार्ग में प्रवेश करके (आश्रिता) अपनी ऊर्ध्व (ऊपर की) यात्रा शुरू कर देती है।
            यह श्लोक कुण्डलिनी जागरण का 'पासवर्ड' (Password / Formula) बता रहा है।
            कुण्डलिनी को जगाने के लिए तीन चीजों की एक साथ (Simultaneously) जरूरत पड़ती है: 1. वह्नि (योग की गर्मी / कुम्भक), 2. मन (तीव्र फोकस), और 3. मरुत (साँसों का नियंत्रण)।
            जब ये तीनों एक साथ मूलाधार चक्र पर जोर से टकराते हैं, तो वह सोई हुई शक्ति घबराकर जाग उठती है।
            जागने के बाद वह मोटी नहीं रहती; वह 'सुई' (Needle) की तरह इतनी बारीक हो जाती है कि वह सुषुम्ना जैसी पतली नली में आसानी से घुस सके।
            यह कोई साधारण अनुभव नहीं है; जब यह सुई की तरह ऊपर उठती है, तो योगी की रीढ़ की हड्डी में एक भयंकर करंट (Electric current) जैसा महसूस होता है।
            जैसे ही वह सुषुम्ना में घुसती है (आश्रिता), इंसान का बाहर की दुनिया से संपर्क कट जाता है और वह समाधि में चला जाता है।
            यही वह जादुई यात्रा है जो इंसान के नर्वस सिस्टम (Nervous system) को पूरी तरह से 'रिबूट' (Reboot) कर देती है।
        """.trimIndent(),
        english = """
            When that formidable Kundalini power is violently and completely awakened (Prabuddha) by the intense strike of Yogic fire (Vahni), a concentrated mind (Manasa), and breath control (Maruta).
            She instantly assumes an exceptionally sharp, highly microscopic form, exactly resembling a piercing 'Needle' (Suchi), and forcefully rises upwards.
            And she directly and flawlessly enters (Ashrita) the supreme, divine pathway of the 'Sushumna Nadi' to aggressively commence her upward cosmic journey.
            This profound verse flawlessly reveals the exact 'Password' (Formula) strictly required for successfully awakening the mighty Kundalini.
            To awaken Kundalini, three things are absolutely required Simultaneously: 1. Vahni (Yogic heat / Kumbhaka), 2. Mind (Laser focus), and 3. Maruta (Breath control).
            When all three of these violently crash together precisely at the Muladhara Chakra, that deeply sleeping power wakes up in a sudden shock.
            Upon waking, she does not remain thick; she becomes so incredibly fine exactly like a 'Needle' so she can easily penetrate the microscopic tube of Sushumna.
            This is absolutely no ordinary experience; when she shoots up like a sharp needle, the Yogi feels a terrifying, massive 'Electric Current' strictly in his spine.
            The exact moment she enters the Sushumna (Ashrita), the human's connection to the outside world is permanently severed, and he enters deep Samadhi.
            This is exactly that magical, internal cosmic journey that completely and flawlessly 'Reboots' the human being's entire Nervous System from scratch.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 27,
        sanskrit = "उद्घाटयेत्कपाटं तु यथा कुञ्चिकया गृहम् । कुण्डलिन्या तथा योगी मोक्षद्वारं प्रभेदयेत् ॥ २७ ॥",
        hindi = """
            जिस प्रकार कोई व्यक्ति एक सही चाबी (कुञ्चिकया) के द्वारा अपने घर के बंद दरवाजे (कपाटं) के ताले को आसानी से खोल लेता है (उद्घाटयेत्)।
            ठीक उसी प्रकार, एक सच्चा योगी उस जागृत 'कुण्डलिनी' शक्ति रूपी चाबी के द्वारा।
            अपने 'मोक्ष' (परम मुक्ति और आत्मज्ञान) के बंद दरवाजे (मोक्षद्वारं) को पूरी तरह से खोल (प्रभेदयेत्) देता है।
            यह श्लोक कुण्डलिनी की असली वैल्यू (Value) और उसके काम करने के तरीके को एक बहुत ही शानदार उदाहरण (Metaphor) से समझा रहा है।
            मोक्ष कोई ऐसा गिफ्ट (Gift) नहीं है जो कोई भगवान आसमान से फेंक कर देगा; मोक्ष हमारे ही दिमाग के सबसे ऊपरी हिस्से (सहस्रार) में बंद है।
            पर उस मोक्ष के दरवाजे पर प्रकृति ने एक बहुत मजबूत ताला (Lock) लगा रखा है, ताकि कोई भी अज्ञानी या लालची इंसान वहाँ न पहुँच सके।
            कुण्डलिनी वह मास्टर-की (Master-key / चाबी) है जो इस दुनिया में केवल उसी योगी को मिलती है जो कठोर तपस्या करता है।
            जब यह कुण्डलिनी की ऊर्जा ऊपर जाकर उस ताले में लगती है, तो दिमाग के सारे 'लिमिटेशन' (Limitations) टूट कर गिर जाते हैं।
            ताला खुलते ही साधक एक छोटे से कमरे (Ego) से निकलकर अनंत आकाश (Brahman) में पहुँच जाता है।
            योग की पूरी मेहनत और संघर्ष केवल इस एक 'चाबी' को हासिल करने और ताले तक पहुँचाने के लिए ही है।
        """.trimIndent(),
        english = """
            Exactly just as a person easily and effortlessly unlocks and opens (Udghatayet) the closed, heavy door (Kapatam) of his locked house using the exact correct key (Kunchikaya).
            In the precise same flawless manner, a true Yogi, strictly using the fully awakened 'Kundalini' power as his master key.
            Completely and forcefully breaks open (Prabhedayet) the tightly locked 'Door of Moksha' (the supreme gateway to absolute liberation and Self-realization).
            This magnificent verse explains the absolute true Value of Kundalini and exactly how it operates, using a spectacularly brilliant Metaphor.
            Moksha is absolutely not a cheap Gift thrown down by some God from the sky; Moksha is tightly locked securely in the highest part of our very own brain (Sahasrara).
            But Nature has deliberately placed an exceptionally heavy, unbreakable Lock on that door of Moksha, purely so no ignorant or greedy human can ever access it.
            Kundalini is that exact supreme 'Master-key' obtained exclusively in this world solely by that Yogi who performs severe, uncompromising penance.
            When this raw energy of Kundalini travels upwards and is firmly inserted into that lock, all 'Limitations' of the human brain shatter instantly.
            The exact moment the lock opens, the seeker violently bursts out of the tiny, suffocating room of 'Ego' straight into the infinite, boundless sky of Brahman.
            Absolutely all the intense labor and fierce struggle of Yoga is strictly and solely designed to acquire this one specific 'Key' and successfully drive it into that lock.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 28,
        sanskrit = "कृत्वा सम्पुटितौ करौ दृढतरं बद्ध्वा तु पद्ममासनम् । गाढं वक्षसि सन्निधाय चुबुकं ध्यानं च तच्चेतसि ॥ २८ ॥",
        hindi = """
            (अब उस कुण्डलिनी को जगाने की शारीरिक विधि बताई जा रही है): साधक को चाहिए कि वह अपने दोनों हाथों को गोद में एक के ऊपर एक रखकर (सम्पुटितौ करौ) बैठे।
            और उसे अपने पैरों को बहुत ही मजबूती से कसकर (दृढतरं) 'पद्मासन' (Lotus posture) में बाँध लेना चाहिए।
            इसके बाद, अपनी ठुड्डी (Chin/चुबुकं) को छाती (वक्षसि) के ऊपरी हिस्से (गड्ढे) में बहुत ही गहराई और कसकर (गाढं) सटा लेना चाहिए (इसे 'जालन्धर बंध' कहते हैं)।
            और फिर अपने पूरे चित्त (मन/चेतसि) को बाहरी विचारों से हटाकर पूरी तरह से केवल और केवल 'ध्यान' में लगा देना चाहिए।
            कुण्डलिनी कोई बातों से नहीं जागती; इसके लिए शरीर को एक अत्यंत शक्तिशाली जनरेटर (Generator) की तरह सेट (Set) करना पड़ता है।
            हाथों को आपस में जोड़ने (सम्पुटित) से शरीर की ऊर्जा (Energy circuit) बाहर लीक (Leak) नहीं होती, वह अंदर ही गोल-गोल घूमने लगती है।
            पद्मासन से पैरों की नसें लॉक (Lock) हो जाती हैं, जिससे सारा खून और प्राण-ऊर्जा नीचे जाने के बजाय सीधे रीढ़ की हड्डी की ओर भागता है।
            ठुड्डी को छाती में कसने (Jalandhara Bandha) से साँस की नली और गर्दन की नसें लॉक हो जाती हैं, जिससे ऊर्जा दिमाग से बाहर नहीं उड़ पाती।
            जब शरीर नीचे और ऊपर दोनों तरफ से पूरी तरह 'सील' (Seal) हो जाता है, तो अंदर की ऊर्जा का दबाव (Pressure) कुकर (Pressure cooker) की तरह बढ़ जाता है।
            इसी भयंकर दबाव और एकाग्र ध्यान (Focus) के कारण सोई हुई कुण्डलिनी को जागने के लिए मजबूर होना पड़ता है।
        """.trimIndent(),
        english = """
            (Now the precise physical method to violently awaken that Kundalini is revealed): The seeker must sit firmly, placing both hands perfectly cupped one over the other (Samputitau karau) in his lap.
            And he must securely, exceptionally tightly, and firmly bind (Dridhataram) his legs exactly in the rigid 'Padmasana' (Lotus posture).
            After this, he must forcefully and deeply press his chin (Chubukam) highly tightly (Gadham) against the upper cavity of his chest (Vakshasi) (This is strictly known as 'Jalandhara Bandha').
            And then, actively withdrawing his entire mind (Chetasi) entirely from all external thoughts, he must plunge it absolutely and exclusively into deep 'Meditation'.
            Kundalini absolutely never awakens through mere sweet talk; to achieve this, the physical body must be perfectly Set up exactly like a highly explosive power Generator.
            Cupping the hands perfectly together physically ensures the body's Energy Circuit absolutely does not Leak outside, forcing it to violently circulate strictly inside.
            Padmasana forcefully locks the leg veins, actively forcing all blood and vital Prana energy to rush straight toward the spine instead of flowing downwards.
            Forcefully pressing the chin into the chest (Jalandhara Bandha) perfectly locks the windpipe and neck veins, strictly preventing the energy from flying out of the brain.
            When the physical body is completely 'Sealed' shut from both top and bottom, the internal energy Pressure builds up intensely exactly like a boiling Pressure Cooker.
            It is exclusively due to this terrifying internal pressure combined with laser-sharp Focus that the deeply sleeping Kundalini is brutally forced to wake up.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 29,
        sanskrit = "वारंवारमपानमूर्ध्वमनिलं प्रोच्चारयन् पूरितम् । मुञ्चन् प्राणमुपैति बोधमतुलं शक्तिप्रभावान्नरः ॥ २९ ॥",
        hindi = """
            उस मुद्रा में बैठने के बाद, साधक को बार-बार (वारंवारं) अपनी 'अपान' वायु (नीचे की ऊर्जा) को ऊपर की ओर खींचना (प्रोच्चारयन्) चाहिए।
            तथा श्वास से पूरी तरह भरे हुए (पूरितम्) अपने 'प्राण' वायु को (नीचे की ओर धकेलते हुए) धीरे-धीरे छोड़ना (मुञ्चन्) चाहिए (ताकि प्राण और अपान आपस में टकराएं)।
            इस भयंकर घर्षण (टकराव) से कुण्डलिनी शक्ति प्रचंड रूप से जागृत हो जाती है।
            और उस जाग्रत 'शक्ति के प्रभाव' (शक्तिप्रभावात्) से वह साधारण मनुष्य एक अतुलनीय (जिसकी कोई बराबरी न हो) परम ज्ञान (बोधं) को प्राप्त (उपैति) कर लेता है।
            यह श्लोक प्राण और अपान को आपस में लड़ाने (Fusion) का सबसे बड़ा 'न्यूक्लियर सीक्रेट' (Nuclear secret) है।
            नॉर्मल (Normal) जीवन में अपान नीचे जाता है (मल-मूत्र निकालने के लिए) और प्राण ऊपर रहता है; दोनों कभी मिलते नहीं।
            पर योगी गुदा (Anus) को सिकोड़कर (मूलबंध लगाकर) अपान को ज़बरदस्ती ऊपर खींचता है, और साँस को रोककर प्राण को नीचे धकेलता है।
            जब ये दोनों विपरीत ऊर्जाएं (Opposite forces) नाभि (मणिपुर चक्र) के पास जोर से टकराती हैं, तो वहाँ योग की भयंकर 'आग' पैदा होती है।
            यह आग सीधे उस सोई हुई कुण्डलिनी को जलाती है, जिससे वह तड़प कर सुई की तरह खड़ी हो जाती है और सुषुम्ना में घुस जाती है।
            जब यह शक्ति दिमाग (सहस्रार) में विस्फोट करती है, तो इंसान का दिमाग 100% खुल जाता है और उसे वह ज्ञान (Enlightenment) मिलता है जो दुनिया की किसी किताब में नहीं है।
        """.trimIndent(),
        english = """
            After sitting perfectly in that rigid posture, the seeker must repeatedly and relentlessly (Varamvaram) forcefully pull his 'Apana' vayu (downward energy) aggressively upwards (Proccharayan).
            And simultaneously, he must slowly release (Munchan) his fully inhaled (Puritam) 'Prana' vayu (forcefully pushing it downwards) (so that Prana and Apana violently crash into each other).
            Due to this terrifying, intense friction (collision), the mighty Kundalini power awakens with ferocious, explosive intensity.
            And strictly due to the massive 'Impact of that awakened Power' (Shaktiprabhavat), that ordinary human being successfully attains (Upaiti) an incomparable, unmatched (Atulam) supreme Wisdom (Bodham).
            This profound verse is the absolute greatest 'Nuclear Secret' of forcing Prana and Apana to violently fuse and collide together.
            In Normal life, Apana constantly moves down (to expel waste) and Prana stays up; the two absolutely never, ever meet.
            But the Yogi, by fiercely contracting the anus (Mulabandha), violently drags Apana upwards, and by holding the breath, aggressively pushes Prana downwards.
            When these two highly Opposite Forces violently crash together near the navel (Manipura Chakra), a terrifying 'Fire' of Yoga is instantly generated there.
            This blazing fire directly burns that sleeping Kundalini, causing her to shoot straight up like a sharp needle and aggressively enter the Sushumna.
            When this immense power violently explodes in the brain (Sahasrara), the human brain opens 100%, granting him that supreme Enlightenment (Wisdom) which exists in absolutely no book in the world.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 30,
        sanskrit = "अङ्गानां मर्दनं कृत्वा श्रमसंजातवारिणा । कट्वम्ललवणत्यागी क्षीरभोजनमाचरेत् ॥ ३० ॥",
        hindi = """
            (ध्यान और प्राणायाम के कड़े अभ्यास से) शरीर में जो पसीना (श्रमसंजातवारिणा) उत्पन्न होता है, योगी को उसे पोंछना नहीं चाहिए, बल्कि उसी पसीने से अपने शरीर के अंगों की मालिश (मर्दनं) करनी चाहिए।
            (इससे शरीर की ऊर्जा वापस शरीर में ही समा जाती है और शरीर फौलाद की तरह मजबूत होता है)।
            इस कठोर योग-मार्ग पर चलने वाले साधक को बहुत अधिक तीखे/कड़वे (कटु), खट्टे (अम्ल), और बहुत अधिक नमकीन (लवण) भोजन का पूरी तरह से त्याग (त्यागी) कर देना चाहिए।
            उसे मुख्य रूप से दूध (क्षीर) और सात्विक (हल्के) भोजन का ही आचरण (खाना) करना चाहिए।
            जब योगी प्राणायाम से कुण्डलिनी जगाने की कोशिश करता है, तो शरीर में भयंकर गर्मी पैदा होती है, जिससे बहुत पसीना आता है।
            अगर वह पसीना तौलिये से पोंछ दिया जाए, तो शरीर के अंदर की जरूरी 'धातु' (Minerals/Energy) बर्बाद हो जाती है।
            पसीने को शरीर पर रगड़ने से वह ऊर्जा (Electrolytes) वापस त्वचा के रास्ते अंदर चली जाती है, जिससे योगी कभी बीमार नहीं पड़ता।
            खाने के नियम (Diet rules) कुण्डलिनी योग में सबसे ज्यादा जरूरी (Strict) होते हैं।
            तीखा, खट्टा और ज्यादा नमक वाला खाना शरीर में 'रजोगुण' (चंचलता और गर्मी) बढ़ाता है, जिससे ध्यान में मन बुरी तरह भटकता है।
            केवल दूध और सादा खाना मन को 'सत्त्वगुण' (शांति) देता है, जो कुण्डलिनी के हाई-वोल्टेज (High-voltage) झटके को सहने के लिए शरीर को अंदर से ठंडा और मजबूत रखता है।
        """.trimIndent(),
        english = """
            (From the intense, severe practice of meditation and Pranayama), whatever sweat is generated by the massive exertion (Shramasamjatavarina), the Yogi must absolutely never wipe it off; instead, he must actively rub and massage (Mardanam) that exact sweat completely back into his bodily limbs.
            (This flawlessly ensures the body's raw energy is perfectly reabsorbed, making the physical body as unbreakable as solid steel).
            The sincere seeker walking this exceptionally rigorous Yogic path must completely and strictly renounce (Tyagi) food that is excessively pungent/bitter (Katu), highly sour (Amla), or heavily salted (Lavana).
            He must predominantly practice consuming (Acharet) a diet consisting entirely of Milk (Kshira) and highly Sattvic (light, pure) food.
            When a Yogi aggressively attempts to awaken the Kundalini via Pranayama, terrifying heat is instantly generated within the body, causing profuse, heavy sweating.
            If that sacred sweat is casually wiped away with a towel, the highly essential 'Dhatus' (Minerals/vital energy) of the body are completely and utterly wasted.
            By vigorously rubbing the sweat back onto the skin, those vital electrolytes (Energy) return seamlessly inside, flawlessly ensuring the Yogi never falls sick.
            Strict Diet Rules are the absolute most crucial and unforgiving aspect in the entire science of Kundalini Yoga.
            Pungent, highly sour, and heavily salted foods aggressively increase 'Rajoguna' (restlessness and heat) in the body, which violently scatters the mind during deep meditation.
            Only pure milk and simple food grant 'Sattvaguna' (profound peace) to the mind, keeping the physical body internally cool and exceptionally strong to safely withstand the massive High-Voltage shock of the awakened Kundalini.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 31,
        sanskrit = "ब्रह्मचारी मिताहारी योगी योगपरायणः । अब्जादूर्ध्वं भवेत्सिद्धो नात्र कार्या विचारणा ॥ ३१ ॥",
        hindi = """
            जो योगी पूरी तरह से 'ब्रह्मचारी' (अपनी यौन ऊर्जा/वीर्य को बचाने वाला) है और 'मिताहारी' (अपनी भूख से हमेशा थोड़ा कम और संतुलित खाने वाला) है।
            और जो पूरी लगन, समर्पण और दृढ़ता के साथ 'योग-परायण' (निरंतर योग के अभ्यास में डूबा हुआ) रहता है।
            वह साधक निश्चित रूप से एक वर्ष (अब्जात्) से कुछ ही अधिक समय (ऊर्ध्वं) में पूर्ण रूप से 'सिद्ध' (सफल/आत्मज्ञानी) हो जाता है।
            इस बात में किसी भी प्रकार का संदेह या विचार (विचारणा) बिल्कुल भी नहीं करना चाहिए (नात्र कार्या)।
            यह श्लोक योग की सफलता का 'टाइम-फ्रेम' (Time-frame / गारंटी) दे रहा है।
            मोक्ष पाने के लिए करोड़ों जन्मों का इंतज़ार करने की जरूरत नहीं है; अगर नियम सही हों, तो एक साल (One year) ही काफी है!
            परन्तु इसके लिए शर्तें (Conditions) बहुत ही सख्त (Strict) हैं: पहली शर्त 'ब्रह्मचर्य' है।
            वीर्य (Semen/Sexual energy) शरीर की सबसे बड़ी बैटरी (Battery) है; अगर यह लीक (Leak) हो रही है, तो कुण्डलिनी को ऊपर धकेलने का पावर (Power) कभी नहीं मिलेगा।
            दूसरी शर्त 'मिताहार' है; जो आदमी गले तक ठूँस कर खाता है, उसका सारा खून और ऊर्जा केवल पेट में खाना पचाने में लग जाती है, दिमाग (ध्यान) के लिए कुछ नहीं बचता।
            जो इन दोनों नियमों का कड़ाई से पालन करते हुए योग (ध्यान/प्राणायाम) करता है, उपनिषद स्टाम्प पेपर (Stamp paper) पर लिखकर गारंटी दे रहा है कि वह एक साल में भगवान बन जाएगा!
        """.trimIndent(),
        english = """
            That specific Yogi who is strictly a flawless 'Brahmachari' (one who absolutely preserves his sexual energy/semen) and is thoroughly 'Mitahari' (one who eats a highly balanced diet, always slightly less than his actual hunger).
            And who remains completely, intensely, and passionately 'Yogaparayanah' (entirely immersed in the relentless, daily practice of Yoga) with absolute dedication.
            That specific seeker undoubtedly and certainly becomes fully 'Siddha' (Perfected/Enlightened) in just a little over one single Year (Abjad urdhvam).
            There must absolutely be zero hesitation, doubt, or second thought (Na atra karya vicharana) regarding this absolute, guaranteed fact.
            This magnificent verse explicitly provides the exact 'Time-frame' (Ironclad Guarantee) for absolute, ultimate success in Yoga.
            There is absolutely zero need to foolishly wait millions of lifetimes to attain Moksha; if the strict rules are followed perfectly, just One Single Year is more than enough!
            However, the precise Conditions for this are exceptionally brutal and strict: the absolute first condition is flawless 'Brahmacharya'.
            Semen (Sexual energy) is undeniably the physical body's absolute largest Battery; if this continually Leaks, you will absolutely never generate enough raw Power to forcefully push the Kundalini upwards.
            The second strict condition is 'Mitahara'; a man who aggressively stuffs himself to the throat wastes his entire blood and vital energy purely on digesting food in the stomach, leaving exactly zero energy for the brain (Meditation).
            For the one who rigorously practices Yoga (Meditation/Pranayama) while flawlessly adhering to these two brutal rules, the Upanishad explicitly guarantees on a blank Stamp Paper that he will literally become God in exactly one year!
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 32,
        sanskrit = "कन्दोर्ध्वे कुण्डलीशक्तिरष्टधा कुण्डलाकृतिः । बन्धनाय च मूर्खाणां योगिनां मोक्षदा सदा ॥ ३२ ॥",
        hindi = """
            मूलाधार चक्र के 'कंद' (जड़/Base) के ठीक ऊपर वह परम 'कुण्डलिनी शक्ति' स्थित है।
            वह शक्ति बिल्कुल एक साँप की तरह आठ बार गोल-गोल चक्कर (अष्टधा कुण्डलाकृतिः) लगाकर (Coiled) बैठी हुई है।
            यह सोई हुई कुण्डलिनी शक्ति उन 'मूर्ख' (अज्ञानी और वासनाओं में फँसे हुए) जीवों के लिए हमेशा 'बंधन' (गुलामी और जन्म-मरण) का कारण बनती है।
            परंतु जो सच्चे 'योगी' इसे जगा लेते हैं, उनके लिए यही शक्ति हमेशा 'मोक्ष' (परम आज़ादी) देने वाली (मोक्षदा) बन जाती है।
            कुण्डलिनी कोई अलग से लाई गई चीज़ नहीं है; यह एक ही ऊर्जा है जो दो तरीके (Two ways) से काम करती है।
            आठ बार कुण्डली मारने का मतलब है कि इसने प्रकृति के आठों तत्वों (जल, अग्नि, वायु, पृथ्वी, आकाश, मन, बुद्धि, अहंकार) को जकड़ रखा है।
            जब यह सोई रहती है, तो यह हमारी एनर्जी (Energy) को नीचे (sex और पेट) की तरफ धकेलती है, जिससे मूर्ख इंसान दुनिया की जेल (बंधन) में फँसा रहता है।
            पर जब प्राणायाम से इसे जगाया जाता है, तो यही 'जहर' (Poison) योगी के लिए 'अमृत' (Nectar) बन जाता है।
            जैसे आग घर को जलाकर राख (बंधन) भी कर सकती है, और वही आग खाना पकाकर जीवन (मोक्ष) भी दे सकती है; यह सब उसके इस्तेमाल (Usage) पर निर्भर है।
            इसलिए कुण्डलिनी से डरना नहीं है; उसे सोता छोड़ना मूर्खता है, और उसे जगा लेना ही इंसान की सबसे बड़ी अक्लमंदी है।
        """.trimIndent(),
        english = """
            Exactly directly above the 'Kanda' (Root/Base bulb) of the Muladhara Chakra, that supreme 'Kundalini Power' is firmly situated.
            That magnificent power sits deeply resting, coiled exactly eight times in precise circular rings (Ashtadha kundalakritih), perfectly resembling a coiled serpent.
            This deeply sleeping Kundalini power acts perpetually as the absolute cause of brutal 'Bondage' (slavery and repeated rebirths) strictly for those 'Fools' (ignorant creatures deeply trapped in worldly lusts).
            But for those authentic, genuine 'Yogis' who successfully awaken her, this exact same power permanently and eternally becomes the absolute bestower of 'Moksha' (Supreme freedom/Mokshada).
            Kundalini is absolutely not an external entity brought from outside; it is exactly one single cosmic energy that aggressively operates in exactly Two different ways.
            Being coiled eight times profoundly implies that it has tightly gripped and locked all eight elements of nature (water, fire, air, earth, ether, mind, intellect, ego).
            While she remains fast asleep, she forcefully pushes our vital Energy downwards (toward sex and stomach), keeping the ignorant fool helplessly trapped in the world's brutal prison (Bondage).
            But when she is violently awakened via intense Pranayama, this exact same lethal 'Poison' instantly transforms into the ultimate 'Nectar' for the master Yogi.
            Just as blazing fire can completely burn a house to ashes (Bondage), and the exact same fire can cook food and grant life (Moksha); it strictly depends entirely on its correct Usage.
            Therefore, one must absolutely never fear the Kundalini; leaving her asleep is sheer stupidity, and successfully awakening her is undeniably human life's absolute greatest brilliance.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 33,
        sanskrit = "महामुद्रां नभोमुद्रां उड्डियानं जलन्धरम् । मूलबन्धं च यो वेत्ति स योगी मुक्तिभाजनः ॥ ३३ ॥",
        hindi = """
            (अब योग की सबसे रहस्यमयी 5 शारीरिक तकनीकों के नाम बताए जा रहे हैं):
            1. महामुद्रा (Maha-Mudra), 2. नभोमुद्रा (खेचरी मुद्रा / Nabho-Mudra), 3. उड्डियान बंध (Uddiyana Bandha), 4. जलन्धर बंध (Jalandhara Bandha), और 5. मूलबंध (Mula Bandha)।
            जो साधक इन पांचों परम गुप्त और शक्तिशाली योग-मुद्राओं और बंधों को यथार्थ रूप में 'जानता' और अभ्यास करता है (यो वेत्ति)।
            निश्चित रूप से केवल वही सच्चा योगी मोक्ष (परम मुक्ति) का सच्चा पात्र (अधिकारी / मुक्तिभाजनः) बनता है।
            पतंजलि योग के बाद हठयोग में इन 5 तकनीकों (मुद्राओं और बंधों) को सबसे बड़ा 'हथियार' (Weapon) माना गया है।
            आसन केवल शरीर को स्वस्थ रखते हैं; पर ये 5 'बंध' (Locks) सीधे आपके नर्वस सिस्टम (Nervous system) और प्राण ऊर्जा (Prana) को हैक (Hack) कर लेते हैं।
            'मुद्रा' का अर्थ होता है सील (Seal); ये तकनीकें शरीर के उन सभी रास्तों को सील कर देती हैं जहाँ से हमारी कीमती ऊर्जा बाहर बहकर बर्बाद होती है।
            जब ये 5 ताले (Locks) एक साथ शरीर पर लगते हैं, तो अंदर की ऊर्जा इतनी भयंकर हो जाती है कि वह सीधे दिमाग (सहस्रार) का ताला तोड़ देती है।
            बिना इन बंधों के कोई भी व्यक्ति कुण्डलिनी को नहीं जगा सकता, चाहे वह कितने भी मंत्र पढ़ ले।
            अगले श्लोकों में उपनिषद एक-एक करके इन महा-शक्तियों (Locks) को लगाने का गुप्त और सटीक तरीका बताने वाला है।
        """.trimIndent(),
        english = """
            (Now the names of Yoga's 5 absolute most highly mystical physical techniques are revealed):
            1. Maha-Mudra, 2. Nabho-Mudra (Khechari Mudra), 3. Uddiyana Bandha, 4. Jalandhara Bandha, and 5. Mula Bandha.
            That specific seeker who profoundly, accurately 'Knows' and rigorously practices (Yo vetti) these five extremely secret and massively powerful Yoga mudras and physical locks.
            Undoubtedly and undeniably, only that true, genuine Yogi becomes the rightful, fully qualified vessel (Candidate / Muktibhajanah) for absolute Moksha (Supreme Liberation).
            Following Patanjali Yoga, the ancient science of Hatha Yoga considers these exact 5 specific techniques (Mudras and Bandhas) as the absolute greatest, most lethal 'Weapons'.
            Physical postures (Asanas) merely keep the body physically healthy; but these 5 'Bandhas' (Locks) directly and aggressively Hack your entire Nervous System and vital Prana energy.
            'Mudra' literally translates to Seal; these extreme techniques perfectly Seal off absolutely all bodily pathways from where our highly precious cosmic energy mindlessly leaks and wastes away.
            When these 5 strict Locks are aggressively applied to the body simultaneously, the internal energy pressure becomes so terrifyingly fierce that it violently shatters the brain's ultimate lock (Sahasrara).
            Completely without mastering these specific locks, absolutely no human can ever possibly awaken the Kundalini, regardless of how many millions of mantras he blindly chants.
            In the highly anticipated following verses, the Upanishad will explicitly reveal the profoundly secret and highly precise method to apply each of these magnificent Powers (Locks) one by one.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 34,
        sanskrit = "पादमूलेन वामस्य योनिं सम्पीड्य दक्षिणम् । पादं प्रसार्य तं कृत्वा कराभ्यां धारयेद्दृढम् ॥ ३४ ॥",
        hindi = """
            (महामुद्रा की विधि भाग-1): साधक को अपने बाएँ पैर (वामस्य पाद) की एड़ी (मूल) से अपनी 'योनि' (गुदा और जननांग के बीच का हिस्सा / Perineum) को बहुत जोर से और मजबूती से दबाकर (सम्पीड्य) बैठना चाहिए।
            (इससे शरीर का सबसे निचला द्वार सील हो जाता है और ऊर्जा नीचे नहीं बहती)।
            इसके बाद, अपने दाहिने पैर (दक्षिणम् पादं) को सामने की ओर बिल्कुल सीधा फैला (प्रसार्य) देना चाहिए।
            और फिर अपने दोनों हाथों (कराभ्यां) से उस सीधे फैले हुए दाहिने पैर के अँगूठे को बहुत ही दृढ़ता (दृढम् / कड़ाई) के साथ पकड़ लेना चाहिए।
            यह 'महामुद्रा' (The Great Seal) का आधा हिस्सा है। यह देखने में स्ट्रेचिंग (Stretching) जैसी लग सकती है, पर यह एक 'एनर्जी सर्किट' (Energy circuit) बना रही है।
            बाएँ पैर की एड़ी से जब मूलाधार चक्र (योनि) को जोर से दबाया जाता है, तो वहाँ की सोई हुई कुण्डलिनी ऊर्जा पर सीधा दबाव (Pressure) पड़ता है।
            दाहिना पैर सीधा करने और उसे हाथों से पकड़ने से पीठ और रीढ़ की हड्डी (Spine) बिल्कुल एक तार की तरह तन (Stretch) जाती है।
            इस खिंचाव (Tension) के कारण सुषुम्ना नाड़ी का रास्ता जो मुड़ा हुआ था, वह बिल्कुल सीधा पाइप (Straight pipe) बन जाता है।
            यह महामुद्रा शरीर के अंदर एक ऐसा 'लूप' (Loop) तैयार करती है जिससे पैर की ऊर्जा वापस घूमकर सिर की ओर जाने के लिए मजबूर हो जाती है।
            (इसके आगे की श्वास-प्रक्रिया अगले श्लोक में बताई गई है)।
        """.trimIndent(),
        english = """
            (Method of Maha-Mudra Part 1): The seeker must sit firmly by fiercely and highly aggressively pressing (Sampidya) his 'Yoni' (the precise perineum area between the anus and genitals) using the strict heel (Root) of his Left Foot (Vamasya pada).
            (This completely and flawlessly Seals the absolute lowest door of the physical body, strictly preventing vital energy from leaking downwards).
            Immediately after this, he must extend and stretch (Prasarya) his Right Foot (Dakshinam padam) completely straight out directly in front of him.
            And then, firmly using both of his hands (Karabhyam), he must aggressively and exceptionally tightly (Dridham) grasp and hold the big toe of that outstretched right foot.
            This represents the first half of the magnificent 'Maha-Mudra' (The Great Seal). It may superficially look like a mere physical Stretch, but it is actively creating a highly explosive 'Energy Circuit'.
            When the Muladhara Chakra (Yoni) is brutally pressed with the heavy heel of the left foot, a massive, direct Pressure is instantly applied straight onto the deeply sleeping Kundalini energy located there.
            Extending the right leg flawlessly straight and tightly gripping it with both hands forces the entire back and Spine to stretch tightly, exactly like a high-tension wire.
            Strictly due to this extreme physical Tension, the normally bent and twisted pathway of the highly subtle Sushumna Nadi is instantly forced into a perfectly straight, clear Pipe.
            This Maha-Mudra perfectly engineers an enclosed, sealed 'Loop' strictly inside the body, violently forcing the leg's gross energy to circulate back and rush aggressively toward the head.
            (The highly critical, accompanying breathing process for this Mudra is explicitly detailed in the very next verse).
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 35,
        sanskrit = "चुबुकं हृदयस्योर्ध्वे स्थापयित्वा समं यमी । कुम्भकेन धरेत्प्राणं महामुद्रेयमुच्यते ॥ ३५ ॥",
        hindi = """
            (महामुद्रा की विधि भाग-2): पैरों और हाथों की वह स्थिति (Position) बनाने के बाद, उस संयमी योगी (यमी) को।
            अपनी ठुड्डी (चुबुकं / Chin) को अपनी छाती (हृदय) के ऊपरी हिस्से में बिल्कुल सीधा और कसकर स्थापित (स्थापयित्वा) कर लेना चाहिए (जालन्धर बंध लगा लेना चाहिए)।
            और फिर साँस को अंदर खींचकर 'कुम्भक' (प्राण को अंदर रोककर रखने की क्रिया) के द्वारा अपने प्राणों को अत्यंत दृढ़ता से रोक (धरेत्प्राणं) लेना चाहिए।
            ऋषियों द्वारा इसी परम शक्तिशाली और गुप्त प्रक्रिया को ही 'महामुद्रा' (Mahamudra / The Great Seal) कहा जाता है (मुद्रेयमुच्यते)।
            पिछले श्लोक में हमने नीचे से (एड़ी से) शरीर को सील (Seal) किया था; इस श्लोक में ठुड्डी (Chin) को छाती में गड़ाकर हमने ऊपर के दरवाजे (गले) को सील कर दिया है।
            अब शरीर ऊपर और नीचे, दोनों तरफ से पूरी तरह से पैक (Pack) हो चुका है।
            इसके बाद जब योगी साँस अंदर भरकर कुम्भक (Hold) करता है, तो फेफड़ों में भरी हुई वह हवा बाहर नहीं निकल पाती।
            वह फँसी हुई हवा (प्राण) और नीचे से दबाया हुआ अपान—ये दोनों जब आपस में टकराते हैं, तो शरीर के अंदर भयंकर गर्मी (Heat) और दबाव पैदा होता है।
            इसी दबाव के कारण कुण्डलिनी शक्ति तड़प कर जग जाती है और सीधे रीढ़ की हड्डी (सुषुम्ना) में रॉकेट (Rocket) की तरह शूट (Shoot) कर जाती है।
            महामुद्रा का यह अभ्यास मौत के डर को भी हरा देता है और इंसान को परम योगी बना देता है।
        """.trimIndent(),
        english = """
            (Method of Maha-Mudra Part 2): Immediately after perfectly securing that strict physical Position of the legs and hands, that highly disciplined Yogi (Yami).
            Must firmly and precisely establish (Sthapayitva) his chin (Chubukam) completely straight and exceptionally tightly directly into the upper cavity of his chest (Heart) (Actively applying the Jalandhara Bandha).
            And then, having inhaled the breath fully, he must aggressively and forcefully restrain and hold his vital breath (Dharet pranam) strictly through the powerful process of 'Kumbhaka' (breath retention).
            This exact, immensely powerful, and highly secret physiological process is profoundly declared by the ancient sages strictly as the 'Maha-Mudra' (The Great Seal / Mudreyamuchyate).
            In the absolute previous verse, we aggressively Sealed the physical body strictly from the bottom (using the heel); in this exact verse, by burying the chin firmly into the chest, we have successfully sealed the upper door (throat).
            Now, the entire physical body is 100% completely, flawlessly Packed and locked perfectly from both top and bottom simultaneously.
            After this, when the Yogi deeply inhales and aggressively performs Kumbhaka (Hold), that massive volume of air trapped in the lungs simply cannot escape out.
            That tightly trapped air (Prana) and the aggressively compressed Apana from below—when these two violently collide, a terrifying, massive Heat and extreme Pressure are instantly generated inside the body.
            Strictly due to this extreme, unbearable pressure, the Kundalini power thrashes, wakes up violently, and Shoots straight up the spine (Sushumna) exactly like a high-speed Rocket.
            This flawless practice of Mahamudra undeniably defeats even the terrifying fear of death and permanently transforms the human into a Supreme Yogi.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 36,
        sanskrit = "उदरं पश्चिमं तानं नाभेरूर्ध्वं तु कारयेत् । उड्डियानो ह्यसौ बन्धो मृत्युमातङ्गकेसरी ॥ ३६ ॥",
        hindi = """
            (3. उड्डियान बंध): साधक को अपनी साँस पूरी तरह बाहर निकालकर, अपने उदर (पेट / Abdomen) को।
            पीठ की तरफ (पश्चिमं / पीछे की ओर) और नाभि के ऊपर की तरफ (ऊर्ध्वं) बहुत ही जोर से खींचकर सिकोड़ना (कारयेत्) चाहिए (ताकि पेट बिल्कुल पीठ से चिपक जाए)।
            योग में इसी अत्यंत शक्तिशाली प्रक्रिया को ही निश्चित रूप से 'उड्डियान बंध' (Uddiyana Bandha) कहा गया है।
            और यह उड्डियान बंध 'मृत्यु रूपी विशाल हाथी' (मृत्यु-मातङ्ग) को मार गिराने वाले साक्षात् 'शेर' (केसरी / Lion) के समान है।
            यह हठयोग का सबसे चमत्कारी और पेट को स्वस्थ रखने वाला अभ्यास है।
            उड्डियान का शाब्दिक अर्थ है—'उड़ना' (To fly)। जब पेट को खाली करके ऊपर की ओर खींचा जाता है, तो नीचे फँसी हुई 'अपान' ऊर्जा अचानक ऊपर की ओर 'उड़ने' लगती है।
            यह बंध पेट के सारे अंगों (Liver, Intestines) की भयंकर मालिश (Massage) कर देता है, जिससे कोई भी पेट की बीमारी टिक नहीं सकती।
            परंतु इसका आध्यात्मिक फायदा इससे भी बड़ा है: यह प्राण ऊर्जा को सीधे सुषुम्ना में धकेल कर अमरता की ओर ले जाता है।
            उपनिषद की उपमा देखिए: मौत एक बहुत बड़ा और ताकतवर हाथी (मातङ्ग) है जो सबको कुचल देता है।
            पर यह 'उड्डियान बंध' वह खूंखार शेर (केसरी) है, जिसे देखते ही मौत का हाथी कांप कर भाग जाता है।
        """.trimIndent(),
        english = """
            (3. Uddiyana Bandha): The sincere seeker, having exhaled his breath absolutely completely, must aggressively and forcefully pull and contract his Udar (stomach / Abdomen).
            Violently drawing it far back strictly towards the spine (Pashchimam / backwards) and pulling it sharply upwards (Urdhvam) entirely above the navel (Karayet) (so the stomach literally sticks tightly to the back).
            In the grand science of Yoga, this exact, exceptionally powerful physical process is undoubtedly and specifically called the 'Uddiyana Bandha'.
            And this magnificent Uddiyana Bandha acts exactly like a fierce, roaring 'Lion' (Kesari) that mercilessly strikes down and slaughters the 'Massive Elephant of Death' (Mrityu-Matanga).
            This is undeniably Hatha Yoga's absolute most miraculous and supreme practice for keeping the entire stomach completely healthy.
            Uddiyana literally translates to—'To Fly' (Flying upwards). When the stomach is completely emptied and violently pulled up, the trapped 'Apana' energy instantly begins to 'Fly' forcefully upwards.
            This intense Bandha performs a terrifyingly deep Massage on absolutely all abdominal organs (Liver, Intestines), ensuring absolutely no stomach disease can ever survive.
            However, its spiritual benefit is infinitely greater: it aggressively shoves the vital Prana energy straight into the Sushumna, directly leading the Yogi toward absolute immortality.
            Look at the Upanishad's stunning metaphor: Death is a colossal, terrifyingly powerful elephant (Matanga) that mercilessly crushes absolutely everyone.
            But this 'Uddiyana Bandha' is that exact ferocious, unstoppable Lion (Kesari), upon merely seeing which, the massive elephant of death trembles in fear and violently runs away.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 37,
        sanskrit = "बद्ध्नाति हि सिराजालमर्थादधोगामिनं जलम् । ततो जलन्धरो बन्धः कण्ठदुःखौघनाशनः ॥ ३७ ॥",
        hindi = """
            (4. जलन्धर बंध): यह बंध गले की सभी नसों और नाड़ियों के जाल (सिराजालं) को पूरी तरह से कसकर बाँध (बद्ध्नाति) देता है।
            जिसके कारण (अर्थात्) मस्तक (सहस्रार/मस्तिष्क) से नीचे की ओर टपकने वाले (अधोगामिनं) 'अमृत रूपी जल' (जलम्) का गिरना पूरी तरह से रुक जाता है।
            इसीलिए ऋषियों द्वारा इसे 'जलन्धर बंध' (Jalandhara Bandha / अमृत-जल को रोकने वाला ताला) कहा गया है।
            और यह बंध गले (कण्ठ) में होने वाले सभी प्रकार के दुखों, कफ और बीमारियों के समूह (दुःखौघ) को पूरी तरह से नष्ट (नाशनः) कर देता है।
            हठयोग का एक बहुत बड़ा रहस्य है: हमारे सिर (सहस्रार/चंद्रमा) से लगातार एक अत्यंत कीमती 'अमृत' (Nectar/ऊर्जा) टपकता रहता है।
            यह अमृत नीचे नाभि (सूर्य/जठराग्नि) में गिरकर भस्म हो जाता है, और इसी ऊर्जा के रोज जलने के कारण इंसान बूढ़ा होकर मर जाता है।
            जलन्धर बंध (ठुड्डी को छाती से कसकर दबाना) गले के पास एक बैरियर (Barrier/दीवार) बना देता है।
            इस दीवार के कारण सिर से टपकने वाला वह 'अमृत' (जल) नीचे पेट की आग में गिरकर जलने से बच जाता है।
            जब योगी इस अमृत को बचा लेता है, तो उसके शरीर में बुढ़ापा नहीं आता और वह मौत को धोखा दे देता है।
            यह बंध थायराइड ग्रंथि (Thyroid gland) को भी एक्टिवेट (Activate) करता है और गले की सारी बीमारियों को जड़ से मिटा देता है।
        """.trimIndent(),
        english = """
            (4. Jalandhara Bandha): This specific strict lock violently, perfectly, and completely ties and binds up (Baddhnati) the entire complex network of all veins and subtle nadis situated strictly in the throat (Sirajalam).
            Due to which (Arthat), the continuous, deadly downward-dripping (Adhogaminam) of the highly precious 'Nectar-like Water' (Jalam) cascading directly from the brain (Sahasrara) is completely, instantly halted.
            That is exactly why this technique is profoundly declared by ancient sages as the 'Jalandhara Bandha' (the absolute lock that successfully catches and holds the dropping nectar-water).
            And this specific powerful Bandha entirely and flawlessly destroys (Nashanah) the entire massive collection of all sorrows, excessive phlegm, and diseases (Dukhaugha) originating strictly in the throat (Kantha).
            There is a massively profound secret in Hatha Yoga: an exceptionally precious 'Amrita' (Nectar/Vital energy) continuously and relentlessly drips down strictly from our head (Sahasrara/Moon).
            This precious nectar falls directly down into the navel (Sun/digestive fire) and is brutally burnt to ashes; strictly because this raw energy burns daily, a human rapidly ages and painfully dies.
            Jalandhara Bandha (fiercely pressing the chin tightly into the chest) successfully creates a massive, impenetrable physical Barrier (Wall) right at the throat.
            Strictly due to this wall, that dripping 'Amrita' (Water) from the head is permanently saved from falling down and being brutally burnt in the intense stomach fire.
            When the master Yogi successfully saves and hoards this nectar, harsh old age absolutely never touches his physical body, and he successfully cheats terrifying death itself.
            This Bandha also actively and perfectly activates the Thyroid gland, flawlessly eradicating absolutely all throat diseases from their very roots.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 38,
        sanskrit = "पाणिभागेन सम्पीड्य योनिमाकुञ्चयेद्गुदम् । अपानमूर्ध्वमाकृष्य मूलबन्धोऽयमुच्यते ॥ ३८ ॥",
        hindi = """
            (5. मूलबंध): साधक को अपनी एड़ी के पिछले हिस्से (पाणिभागेन) से अपनी 'योनि' (गुदा और जननांग के बीच का स्थान / Perineum) को बहुत जोर से दबाना (सम्पीड्य) चाहिए।
            और फिर उसे अपने गुदा मार्ग (गुदम् / Anus) की मांसपेशियों को अत्यंत बलपूर्वक सिकोड़ना (आकुञ्चयेत् / Contract) चाहिए।
            इस तीव्र सिकुड़न के द्वारा, स्वाभाविक रूप से नीचे की ओर जाने वाली 'अपान' वायु को जबरदस्ती ऊपर की ओर (ऊर्ध्वम्) खींच (आकृष्य) लेना चाहिए।
            योगियों द्वारा इसी अत्यंत गुप्त और शक्तिशाली शारीरिक क्रिया को ही 'मूलबंध' (Mula Bandha / Root Lock) कहा जाता है।
            मूलाधार (Root) हमारे शरीर का सबसे निचला दरवाजा है जहाँ से हमारी ऊर्जा (अपान) मल-मूत्र के रूप में धरती की ओर बहती है।
            जब तक यह दरवाजा खुला है, आप कितना भी ध्यान कर लें, आपकी ऊर्जा नीचे से लीक (Leak) होकर बह जाएगी (जैसे छेद वाली बाल्टी में पानी)।
            मूलबंध उस छेद वाली बाल्टी में कॉर्क (Cork / ढक्कन) लगाने का काम करता है।
            एड़ी से दबाना और मांसपेशियों को सिकोड़ना—यह एक मैकेनिकल (Mechanical) तरीका है जिससे अपान वायु का रास्ता ब्लॉक (Block) हो जाता है।
            रास्ता बंद होने पर अपान वायु को मजबूरी में उल्टा (ऊपर की ओर) मुड़ना पड़ता है और वह पेट की ओर भागती है।
            यही उल्टी बहती हुई अपान ऊर्जा जब नाभि में जाकर प्राण से टकराती है, तो कुण्डलिनी का विस्फोट (Explosion) होता है।
        """.trimIndent(),
        english = """
            (5. Mula Bandha): The sincere seeker must fiercely and violently press (Sampidya) his 'Yoni' (the exact perineum region strictly between the anus and genitals) using the back portion of his heavy heel (Panibhagena).
            And then he must aggressively, forcefully, and violently contract and squeeze (Akunchayet) the internal physical muscles of his anal passage (Gudam / Anus).
            Through this intense, extreme contraction, he must forcefully and violently drag (Akrishya) the naturally downward-flowing 'Apana' vayu aggressively upwards (Urdhvam).
            This exact, exceptionally highly secret, and terrifically powerful physiological action is profoundly called the 'Mula Bandha' (The Root Lock) by the master Yogis.
            The Muladhara (Root) is the absolute lowest, bottom door of our physical body from where our vital energy (Apana) constantly flows out towards the earth in the form of waste.
            As long as this specific bottom door remains wide open, no matter how much you intensely meditate, your precious energy will continuously Leak and drain out from below (exactly like pouring water into a severely leaking bucket).
            Mula Bandha effectively functions exactly like permanently jamming a tight Cork (Lid) straight into that leaking bucket.
            Pressing heavily with the physical heel and violently contracting the internal muscles—this is a brutal Mechanical method that completely Blocks the downward path of the Apana air.
            With its downward path entirely shut, the trapped Apana air is helplessly forced to reverse its direction (upwards) and violently rushes straight towards the stomach.
            When this exact, reversed Apana energy hits the navel and violently collides with the Prana, the massive, explosive awakening (Explosion) of the Kundalini instantly occurs.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 39,
        sanskrit = "अपानप्राणयोरैक्यं कृत्वा मूत्रपुरीषयोः । युवा भवति वृद्धोऽपि सततं मूलबन्धनात् ॥ ३९ ॥",
        hindi = """
            (मूलबंध का चमत्कारी परिणाम): इस मूलबंध के अत्यंत कठोर अभ्यास के द्वारा 'अपान' (नीचे की ऊर्जा) और 'प्राण' (ऊपर की ऊर्जा) का पूर्ण रूप से मिलन (ऐक्यं / एकता) कर देने पर।
            और मल (पुरीष) तथा मूत्र (पेशाब) का शरीर से गिरना बहुत कम हो जाने पर (अर्थात शरीर की व्यर्थ ऊर्जा का क्षरण रुक जाने पर)।
            इस 'मूलबंध' का अत्यंत निरंतर (सततं) और दृढ़ अभ्यास करने से एक अत्यंत बूढ़ा और जर्जर व्यक्ति (वृद्धोऽपि) भी।
            फिर से साक्षात् एक जवान लड़के (युवा) के समान अत्यंत शक्तिशाली और ऊर्जावान हो (भवति) जाता है।
            यह श्लोक हठयोग के 'एंटी-एजिंग' (Anti-aging / उम्र रोकने वाले) विज्ञान की सबसे बड़ी गारंटी है।
            बुढ़ापा कोई बीमारी नहीं है; यह केवल हमारे शरीर की प्राण-ऊर्जा (बैटरी) के खत्म होने का परिणाम है।
            जब प्राण और अपान दोनों अलग-अलग दिशाओं में भागते हैं, तो शरीर की मशीन (Machine) घिसने लगती है और इंसान बूढ़ा हो जाता है।
            परंतु जब मूलबंध लगाकर इन दोनों को आपस में जोड़ (ऐक्यं) दिया जाता है, तो शरीर का बैटरी-लॉस (Battery loss) 100% रुक जाता है।
            चूंकि ऊर्जा शरीर से बाहर (मल-मूत्र के रूप में) नहीं निकल पाती, इसलिए वह वापस शरीर की सेल्स (Cells) को रिपेयर (Repair) करने लगती है।
            इसीलिए कहा गया है कि इसका लगातार (सतत) अभ्यास करने वाला अस्सी साल का बूढ़ा भी बीस साल के जवान जैसी ताकत पा लेता है।
        """.trimIndent(),
        english = """
            (The miraculous absolute result of Mula Bandha): By completely and flawlessly achieving the perfect, absolute union (Aikyam / Oneness) of the 'Apana' (downward energy) and 'Prana' (upward energy) strictly through the severe practice of this Mula Bandha.
            And upon the physical dropping of feces (Purisha) and urine (Mutra) from the body becoming exceedingly highly minimized (meaning, the toxic draining of the body's useless energy completely stops).
            Strictly by performing the exceptionally continuous (Satatam), unbroken, and firm practice of this specific 'Mula Bandha', even an extremely decrepit, completely old man (Vriddho'pi).
            Flawlessly, physically, and literally transforms (Bhavati) back into an incredibly powerful, highly energetic young boy (Yuva) once again.
            This phenomenal verse is the absolute greatest, ironclad guarantee of Hatha Yoga's magnificent 'Anti-Aging' (Age-reversing) biological science.
            Old age is absolutely not a medical disease; it is merely the direct, unavoidable result of our physical body's vital Prana-energy (Battery) constantly running out.
            When Prana and Apana continuously rush wildly in entirely opposite directions, the physical body's biological Machine actively wears out rapidly, and the human grows old.
            But exactly when these two are violently joined and fused together (Aikyam) by applying the Mula Bandha, the body's massive Battery-loss is stopped 100%.
            Since the raw energy simply cannot escape out of the body (in the form of gross waste), it is forced to actively and aggressively Repair the dying body Cells.
            This is exactly why it is explicitly declared that an eighty-year-old man who practices this relentlessly (Satatam) flawlessly regains the terrifying raw strength of a twenty-year-old youth.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 40,
        sanskrit = "एवं यद्विघ्नबाहुल्यं त्याज्यं ब्रह्मविदा शनैः । ध्यानादेतदवाप्नोति तद्विष्णोः परमं पदम् ॥ ४० ॥",
        hindi = """
            (उपनिषद का अंतिम उपसंहार): इस प्रकार ध्यान के मार्ग में आने वाले इन अनेक प्रकार के भयंकर विघ्नों (रुकावटों / विघ्नबाहुल्यं) और शारीरिक सीमाओं को।
            ब्रह्म को जानने की इच्छा रखने वाले सच्चे साधक (ब्रह्मविदा) को बहुत ही धैर्य के साथ और धीरे-धीरे (शनैः) पूरी तरह से त्याग (त्याज्यं) देना चाहिए।
            केवल इसी प्रकार के अत्यंत गहरे और निरंतर 'ध्यान' (Meditation) के अभ्यास से ही (ध्यानात्)।
            वह साधक निश्चित रूप से साक्षात् भगवान 'विष्णु के उस परम पद' (मोक्ष / तद्विष्णोः परमं पदम्) को प्राप्त (अवाप्नोति) कर लेता है।
            ध्यानबिंदु उपनिषद यहाँ अपनी इस महान योग-यात्रा को एक अत्यंत सुंदर और प्रेरणादायक निष्कर्ष (Conclusion) पर पहुँचाता है।
            रास्ते में बहुत सी रुकावटें (नींद, वासना, भटकाव) और शारीरिक कष्ट (बंध लगाने की मेहनत) आएंगे, पर घबराना नहीं है।
            'शनैः' (धीरे-धीरे) का मतलब है कि कुण्डलिनी योग में हड़बड़ी (Haste) जानलेवा हो सकती है; इसे अभ्यास और वैराग्य से धीरे-धीरे ही साधना चाहिए।
            जब साधक इन सारे बंधों, मुद्राओं और नाद (Sound) की सीढ़ियों को पार कर लेता है, तो वह शरीर की सीमाओं को हमेशा के लिए तोड़ देता है।
            विष्णु का परम पद कोई आसमान में स्थित महल नहीं है; यह चेतना की वह अमर अवस्था है जहाँ इंसान खुद भगवान बन जाता है।
            ॐ शांतिः शांतिः शांतिः—यहाँ 'ध्यान' का यह सबसे बड़ा और महान विज्ञान (ध्यानबिंदु उपनिषद) अपनी पूर्णता को प्राप्त होता है।
        """.trimIndent(),
        english = """
            (The ultimate final conclusion of the Upanishad): Thus, this entire terrifying, massive army of numerous severe obstacles (Vighnabahulyam) and physical limitations actively encountered exactly on the path of meditation.
            Must be completely, ruthlessly, and permanently abandoned and discarded (Tyajyam) with immense patience, exceptionally slowly and steadily (Shanaih), strictly by the true, sincere seeker of Brahman (Brahmavida).
            It is solely and exclusively through the relentless, unbroken practice of exactly this exceptionally profound 'Dhyana' (Meditation / Dhyanat) alone.
            That the dedicated seeker undoubtedly and successfully attains (Avapnoti) that absolute, direct 'Supreme Abode of Lord Vishnu Himself' (Moksha / Tadvishnoh paramam padam).
            The Dhyanabindu Upanishad profoundly brings its magnificent, unparalleled Yoga-journey to an exceedingly beautiful and highly inspiring Conclusion right here.
            There will undoubtedly be numerous massive obstacles (sleep, deep lust, severe distraction) and extreme physical hardships (the intense labor of applying locks) exactly on the path, but one must absolutely never panic.
            'Shanaih' (Slowly) explicitly means that sheer Haste in Kundalini Yoga can be literally fatal; it must be mastered exceptionally slowly, strictly through relentless practice and detachment.
            When the true seeker successfully crosses all these specific stairs of physical Bandhas, Mudras, and internal Nada (Sound), he shatters the strict boundaries of the physical body forever.
            Vishnu's supreme abode is absolutely not a physical palace situated high up in the sky; it is that immortal, absolute state of pure consciousness where the human literally becomes God Himself.
            OM Peace, Peace, Peace—Here, this absolute greatest and most magnificent science of 'Dhyana' (The Dhyanabindu Upanishad) flawlessly achieves its perfect, absolute completion.
        """.trimIndent()
    ),
// ... Continuing dhyanabinduShlokasList from ID 41

    DhyanabinduShloka(
        id = 41,
        sanskrit = "कपालकुहरे जिह्वा प्रविष्टा विपरीतगा । भ्रुवोरन्तर्गता दृष्टिर्मुद्रा भवति खेचरी ॥ ४१ ॥",
        hindi = """
            (खेचरी मुद्रा की विधि): साधक को अपनी जीभ (जिह्वा) को उलटकर (विपरीतगा) अपने तालू के ऊपर स्थित 'कपाल-कुहर' (गड्ढे) में प्रवेश कराना चाहिए।
            और इसके साथ ही, अपनी दृष्टि (आँखों के फोकस) को दोनों भौंहों के बीच (भ्रूमध्य / आज्ञा चक्र) में पूरी तरह से स्थिर कर लेना चाहिए।
            महान सिद्ध योगियों द्वारा इसी अत्यंत गुप्त और शक्तिशाली शारीरिक प्रक्रिया को 'खेचरी मुद्रा' (Khechari Mudra) कहा जाता है।
            यह हठयोग और कुण्डलिनी योग की सबसे सर्वोच्च और रहस्यमयी मुद्रा मानी गई है जो आम इंसान की पहुँच से बाहर है।
            जीभ को तालू के छेद में घुसाने से शरीर के ऊपर (सहस्रार) से टपकने वाला अमृत (Nectar) सीधा जीभ पर गिरता है और पेट की आग में नहीं जलता।
            भ्रूमध्य में दृष्टि टिकाने से मन की सारी चंचलता तुरंत खत्म हो जाती है और शरीर पूरी तरह से सुन्न (Lock) हो जाता है।
            'खेचरी' का शाब्दिक अर्थ है—'आकाश (खे) में विचरण (चरी) करने वाली'; यह मुद्रा चेतना को शरीर से निकालकर ब्रह्मांड में उड़ा देती है।
            इस मुद्रा को सिद्ध करने के लिए बहुत लंबे समय तक जीभ को लंबा करने का अभ्यास करना पड़ता है।
            जब यह मुद्रा लग जाती है, तो इंसान का श्वास (Breath) अपने-आप रुक जाता है और वह पूर्ण समाधि में चला जाता है।
            यह कोई साधारण शारीरिक क्रिया नहीं है; यह मौत को धोखा देकर शरीर को अमर (Immortal) बना देने की संजीवनी विद्या है।
        """.trimIndent(),
        english = """
            (The Method of Khechari Mudra): The seeker must roll his tongue backwards (Viparitaga) and forcefully insert it deep into the 'Kapala-kuhara' (the cranial cavity) above the palate.
            And simultaneously, he must perfectly and firmly fix his vision (gaze) exactly in the absolute middle of the two eyebrows (Bhrumadhya / Ajna Chakra).
            This incredibly secret and tremendously powerful physiological process is profoundly declared by great perfected Yogis as the 'Khechari Mudra'.
            This is universally considered the absolute highest and most deeply mystical Mudra in Hatha and Kundalini Yoga, lying far beyond the reach of ordinary humans.
            By inserting the tongue into the cranial cavity, the precious nectar dripping from the Crown (Sahasrara) falls directly onto the tongue, completely escaping the destructive stomach fire.
            Firmly anchoring the gaze between the eyebrows instantaneously obliterates all mental restlessness, perfectly locking the physical body into a numb, motionless state.
            'Khechari' literally means—'that which moves (Chari) in the vast sky/space (Khe)'; this Mudra ejects consciousness from the body, making it fly in the cosmos.
            To successfully perfect this extreme Mudra, one must undergo prolonged, rigorous physical practices to actively lengthen the tongue.
            The exact moment this magnificent Mudra is applied perfectly, the human breath automatically stops entirely, and the Yogi plunges into absolute, deep Samadhi.
            This is absolutely not an ordinary physical exercise; it is the ultimate life-giving science (Sanjeevani) that successfully cheats death and renders the physical body immortal.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 42,
        sanskrit = "न रोगो मरणं तन्द्रा न निद्रा न क्षुधा तृषा । न च मूर्च्छा भवेत्तस्य यो मुद्रां वेत्ति खेचरीम् ॥ ४२ ॥",
        hindi = """
            (खेचरी मुद्रा के चमत्कार): जो योगी इस परम 'खेचरी मुद्रा' को भलीभांति जानता (वेत्ति) है और इसे सफलतापूर्वक सिद्ध कर लेता है।
            उस योगी के शरीर में कभी कोई भयंकर 'रोग' (बीमारी) प्रवेश नहीं कर सकता, और न ही उसे कभी अकाल 'मृत्यु' (मरणं) का सामना करना पड़ता है।
            उसे कभी आलस्य (तन्द्रा), गहरी बेहोशी वाली नींद (निद्रा), भूख (क्षुधा), या भयंकर प्यास (तृषा) बिल्कुल नहीं सताती।
            और उस योगी को कभी भी किसी भी परिस्थिति में मूर्च्छा (बेहोशी या कोमा) नहीं आती; वह हमेशा पूरी तरह जाग्रत रहता है।
            यह श्लोक खेचरी मुद्रा के उन मेडिकल (Medical) चमत्कारों का वर्णन करता है जो आधुनिक विज्ञान को भी हैरान कर देते हैं।
            जब जीभ तालू के छेद को ब्लॉक (Block) कर देती है, तो शरीर का ऑक्सीजन (Oxygen) का खर्च लगभग जीरो (Zero) हो जाता है।
            इस अवस्था में योगी का मेटाबॉलिज्म (Metabolism) पूरी तरह से रुक जाता है, जिससे उसे न भूख लगती है और न प्यास।
            यह मुद्रा शरीर की बायोलॉजिकल घड़ी (Biological Clock) को रोक देती है; इसी कारण योगी बिना खाए-पिए गुफाओं में सालों तक जिंदा रहते हैं।
            जब शरीर की ऊर्जा खर्च ही नहीं हो रही है, तो बुढ़ापा और बीमारियां शरीर पर अपना कोई असर नहीं दिखा पातीं।
            खेचरी मुद्रा इंसान के शरीर को एक 'हाइबरनेशन' (Hibernation) मोड में डाल देती है, जहाँ शरीर सोता है पर आत्मा 100% जाग्रत (Awake) रहती है।
        """.trimIndent(),
        english = """
            (The Miracles of Khechari Mudra): That supreme Yogi who thoroughly knows (Vetti) and successfully perfects this ultimate 'Khechari Mudra'.
            Absolutely no terrifying 'Disease' (Roga) can ever enter his physical body, nor does he ever have to face untimely 'Death' (Maranam).
            He is never, ever tormented by heavy lethargy (Tandra), deep unconscious sleep (Nidra), severe hunger (Kshudha), or extreme thirst (Trisha).
            And that Yogi absolutely never suffers from swooning (Murcha / coma) under any circumstance whatsoever; he remains eternally, completely awake.
            This magnificent verse explicitly describes the profound Medical miracles of Khechari Mudra that completely baffle even modern science.
            When the rolled tongue completely Blocks the cranial cavity, the physical body's Oxygen consumption drops to practically Zero.
            In this extreme state, the Yogi's entire Metabolism comes to an absolute halt, completely eliminating the biological need for food and water.
            This Mudra actively stops the physical body's Biological Clock; this is exactly how Yogis survive for decades in caves entirely without food or water.
            When the body's raw energy is simply not being consumed at all, old age and fatal diseases absolutely fail to exert any effect on the body.
            Khechari Mudra violently forces the human body into a deep 'Hibernation' mode, where the physical body sleeps deeply but the Soul remains 100% perfectly Awake.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 43,
        sanskrit = "पीड्यते न स रोगेण लिप्यते न च कर्मणा । बाध्यते न स कालेन यो मुद्रां वेत्ति खेचरीम् ॥ ४३ ॥",
        hindi = """
            (खेचरी की महिमा जारी है): जो योगी इस रहस्यमयी खेचरी मुद्रा को सिद्ध कर लेता है, वह किसी भी शारीरिक या मानसिक रोग से पीड़ित (पीड्यते) नहीं होता।
            वह योगी संसार में कोई भी कार्य करते हुए उस 'कर्म' के अच्छे या बुरे फलों से कभी लिप्त (लिप्यते / गंदा) नहीं होता।
            और सबसे बड़ी बात, वह योगी 'काल' (समय / Time) के द्वारा भी कभी बाँधा (बाध्यते) नहीं जा सकता (समय उसका कुछ नहीं बिगाड़ सकता)।
            यह मुद्रा केवल शरीर को नहीं बचाती, बल्कि यह इंसान को कर्मों के भयंकर जाल (Karmic Web) से भी हमेशा के लिए आज़ाद कर देती है।
            जब साधक खेचरी लगाता है, तो उसका मन दुनिया से पूरी तरह कटकर 'सहस्रार' (ब्रह्म) में लीन हो जाता है।
            जहाँ मन ही नहीं है, वहाँ कर्मों का फल (पाप या पुण्य) किस पर चिपकेगा? इसलिए वह 'कर्मणा न लिप्यते' (कर्मों से अछूता) हो जाता है।
            'काल' (समय) का असर केवल उस पर होता है जो साँसें लेता है; योग में साँसों की गिनती से ही उम्र तय होती है।
            खेचरी मुद्रा में साँस (Breath) लगभग रुक जाती है; जब साँस ही नहीं चल रही, तो इंसान की उम्र बढ़नी भी रुक जाती है।
            इसलिए मृत्यु का देवता (काल) भी उस योगी को छूने से डरता है जिसने इस मुद्रा के द्वारा समय की घड़ी को ही रोक दिया हो।
            यह श्लोक सिद्ध करता है कि एक सच्चा योगी प्रकृति के नियमों (Laws of Nature) का गुलाम नहीं, बल्कि उनका साक्षात् मालिक (Master) होता है।
        """.trimIndent(),
        english = """
            (The glory of Khechari continues): That Yogi who successfully masters this mystical Khechari Mudra is never afflicted or tormented (Pidyate) by any physical or mental disease.
            While performing any action whatsoever in this world, that Yogi is absolutely never tainted or stained (Lipyate) by the good or bad fruits of that 'Karma'.
            And most importantly, that supreme Yogi can absolutely never be bound or restricted (Badhyate) by 'Kala' (Time) (Time can do absolutely no harm to him).
            This Mudra does not merely protect the physical body; it completely and permanently frees a human from the terrifying, complex Karmic Web forever.
            When the seeker applies Khechari, his mind is entirely severed from the world and flawlessly dissolves straight into the 'Sahasrara' (Brahman).
            Where the mind itself does not exist, upon whom will the fruits of karma (sin or merit) attach? Hence he becomes 'Karmana na lipyate' (untouched by karma).
            'Kala' (Time) exclusively affects only those who actively breathe; in Yoga, human lifespan is strictly measured by the exact number of breaths.
            In Khechari Mudra, the breath (Prana) practically stops entirely; when breathing stops, the human's aging process also completely halts.
            Therefore, even the God of Death (Time) fears touching that Yogi who has aggressively stopped the very clock of time through this Mudra.
            This magnificent verse flawlessly proves that a true Yogi is absolutely not a pathetic slave to the Laws of Nature, but their direct, absolute Master.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 44,
        sanskrit = "चित्तं चरति खे यस्माज्जिह्वा चरति खेगता । तेनैषा खेचरी नाम मुद्रा सिद्धैर्निरूपिता ॥ ४४ ॥",
        hindi = """
            (खेचरी नाम का अर्थ स्पष्ट किया जा रहा है): इस मुद्रा के अभ्यास से योगी का 'चित्त' (मन/चेतना) ब्रह्मांड के असीम 'खे' (आकाश / Void) में विचरण (चरति) करने लगता है।
            और उसकी जो भौतिक जीभ (जिह्वा) है, वह भी तालू के ऊपर स्थित 'खे' (कपाल कुहर रूपी शून्य आकाश) में जाकर विचरण करती है।
            चूंकि इसमें मन और जीभ दोनों ही 'आकाश' (खे) में गति (चरी) करते हैं, इसी कारण से महान सिद्ध योगियों द्वारा।
            इस परम मुद्रा का नाम अत्यंत सटीक रूप से 'खेचरी' (खे + चरी = आकाश में उड़ने वाली) निर्धारित (निरूपिता) किया गया है।
            प्राचीन ऋषियों ने योग के हर शब्द को बहुत ही गहरे वैज्ञानिक (Scientific) और तार्किक (Logical) आधार पर रखा है।
            यह मुद्रा इंसान के अंदर की स्थूल (Physical) और सूक्ष्म (Subtle) दुनिया के बीच का एक सीधा पुल (Bridge) है।
            शारीरिक रूप से, जीभ (Tongue) हमारे शरीर के सबसे निचले हिस्से (अन्नमय कोष) का प्रतीक है।
            और वह कपाल-कुहर (Cranial cavity) शरीर का सबसे ऊँचा आकाश (सहस्रार) है।
            जब नीचे की जीभ ऊपर के आकाश (तालू) में जाती है, तो यह एक भौतिक सर्किट (Circuit) को पूरा करती है।
            और जैसे ही यह फिजिकल सर्किट जुड़ता है, हमारा मन (चित्त) तुरंत शरीर की जेल से आज़ाद होकर ब्रह्मांड (Cosmic space) में उड़ने लगता है।
        """.trimIndent(),
        english = """
            (The exact meaning of the name Khechari is clarified): By the rigorous practice of this Mudra, the Yogi's 'Chitta' (Mind/Consciousness) begins to roam freely (Charati) in the infinite 'Khe' (Sky/Void) of the cosmos.
            And his gross physical tongue (Jihva) also aggressively enters and moves within the 'Khe' (the empty, sky-like void of the cranial cavity) situated high above the palate.
            Strictly because both the mind and the tongue actively move (Chari) entirely within the 'Space/Sky' (Khe), exactly for this reason, by the great perfected Yogis.
            The name of this supreme Mudra has been highly accurately and flawlessly determined (Nirupita) precisely as 'Khechari' (Khe + Chari = that which flies in the sky).
            The ancient sages named every single yogic term on an exceptionally profound, highly Scientific, and deeply Logical foundation.
            This Mudra acts exactly as a direct, flawless Bridge connecting the gross Physical world with the infinitely Subtle inner world of a human being.
            Physically speaking, the tongue represents the absolute lowest, grossest part of our consumption (Annamaya Kosha).
            And that Cranial Cavity is the absolute highest, supreme sky (Sahasrara) of the human physical body.
            When the lower tongue aggressively enters the upper sky (palate), it successfully completes a highly explosive physical Circuit.
            And the exact split-second this physical circuit connects, our mind (Chitta) instantly breaks free from the body's prison and begins flying boundlessly in Cosmic Space.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 45,
        sanskrit = "बिन्दूमूलशरीराणि सिरास्तत्रैव तिष्ठति । तस्मात्सर्वप्रयत्नेन बिन्दुं संरक्षयेद्यती ॥ ४५ ॥",
        hindi = """
            मनुष्य का यह भौतिक शरीर पूरी तरह से 'बिंदु' (वीर्य / Semen / Vital Life Energy) पर ही आधारित (मूल) है।
            शरीर की सभी नसों और नाड़ियों (सिरा) का पूरा जाल उसी 'बिंदु' की अपार ऊर्जा के सहारे ही टिक कर काम करता है (तिष्ठति)।
            इसलिए, एक सच्चे यती (संन्यासी / योगी) को अपनी पूरी ताकत और सभी संभव प्रयासों (सर्वप्रयत्नेन) के द्वारा।
            उस बहुमूल्य 'बिंदु' (ऊर्जा) की हर कीमत पर रक्षा (संरक्षयेत्) करनी चाहिए (उसे नष्ट या स्खलित नहीं होने देना चाहिए)।
            यह श्लोक हठयोग और कुण्डलिनी योग के सबसे बड़े और कठोर नियम (ब्रह्मचर्य) की घोषणा कर रहा है।
            'बिंदु' केवल शारीरिक वीर्य (Sperm) नहीं है; यह हमारे शरीर में मौजूद सबसे शक्तिशाली 'क्रिएटिव एनर्जी' (Creative Energy) है।
            इसी एक बूंद से एक पूरे नए इंसान का जन्म हो सकता है; सोचिए इसमें कितनी भयंकर ऊर्जा (Power) छिपी है!
            आम इंसान इस ऊर्जा को थोड़े से शारीरिक सुख (Sex) के लिए शरीर से बाहर फेंक कर अपनी बैटरी (Battery) को खत्म कर देता है।
            परंतु योगी जानता है कि अगर इस ऊर्जा को नीचे बहने से रोक लिया जाए, तो यही ऊर्जा कुण्डलिनी को जगाने का ईंधन (Fuel) बन जाती है।
            बिना बिंदु को बचाए (ब्रह्मचर्य के बिना), मोक्ष या समाधि की बात करना केवल एक मूर्खतापूर्ण कल्पना (Fantasy) है।
        """.trimIndent(),
        english = """
            This gross physical body of a human being is entirely and absolutely founded upon (Mula) the 'Bindu' (Semen / Vital Life Energy).
            The entire complex network of all physical veins and subtle Nadis (Sira) functions and survives (Tishthati) strictly reliant upon the immense raw power of that 'Bindu'.
            Therefore, a true Yati (ascetic / Yogi) must aggressively, with his absolute full strength and all possible efforts (Sarvaprayatnena).
            Relentlessly protect and hoard (Samrakshayet) that highly precious 'Bindu' (energy) at absolutely any cost (he must never let it be destroyed or discharged).
            This magnificent verse fiercely declares the absolute greatest and strictest rule (Brahmacharya) of Hatha and Kundalini Yoga.
            'Bindu' is absolutely not just physical semen (Sperm); it is the most incredibly powerful, raw 'Creative Energy' existing within the human body.
            From this single tiny drop, an entire new human being can be born; imagine the terrifying, immense Power hidden flawlessly within it!
            An ordinary human carelessly throws this supreme energy out of the body for a few seconds of cheap physical pleasure (Sex), rapidly draining his life's Battery.
            But the master Yogi knows perfectly well that if this energy is aggressively stopped from flowing downward, it instantly becomes the highly explosive Fuel to awaken the Kundalini.
            Without ruthlessly preserving the Bindu (without strict Brahmacharya), even talking about Moksha or Samadhi is merely a foolish, impossible Fantasy.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 46,
        sanskrit = "मरणं बिन्दुपातेन जीवनं बिन्दुधारणात् । तस्माद्रेतोगतं योगं रक्षयेत्सततं यती ॥ ४६ ॥",
        hindi = """
            इस अत्यंत कीमती 'बिंदु' (वीर्य/ऊर्जा) के पतन (शरीर से बाहर निकलने / स्खलित होने) का सीधा अर्थ 'मृत्यु' (मरणं) है।
            और इस बिंदु को शरीर के भीतर मजबूती से धारण करने (बचाने) का ही दूसरा नाम असली 'जीवन' (Life) है।
            इसलिए, योग के मार्ग पर चलने वाले संन्यासी (यती) को अत्यंत सावधानी के साथ निरंतर (सततं)।
            अपने 'रेतस' (वीर्य/बिंदु) की रक्षा करके अपनी इस योग-साधना को सफल बनाना चाहिए।
            यह श्लोक स्पष्ट रूप से बताता है कि बुढ़ापा और मौत कोई प्राकृतिक (Natural) बीमारियां नहीं हैं।
            इंसान इसलिए मरता है क्योंकि वह अपनी लाइफ-फोर्स (Life-force / बिंदु) को लगातार शरीर से बाहर फेंक कर खुद को खोखला कर लेता है।
            जब शरीर की यह सबसे गाढ़ी और शक्तिशाली ऊर्जा (बिंदु) खत्म हो जाती है, तो नर्वस सिस्टम (Nervous system) टूट जाता है।
            परंतु जो योगी इस बिंदु को 'उर्ध्वरेता' (Upward flowing) बना लेता है, उसका शरीर लोहे (Steel) के समान मजबूत हो जाता है।
            यही बिंदु जब प्राणायाम की गर्मी से भाप (Vapor) बनकर दिमाग (सहस्रार) में पहुँचता है, तो इंसान को 'परम ज्ञान' (Enlightenment) प्राप्त होता है।
            इसलिए जो ब्रह्मचर्य का पालन नहीं करता, उसके लिए योग की सारी किताबें और आसन बिल्कुल बेकार (Useless) हैं।
        """.trimIndent(),
        english = """
            The unnecessary fall (discharge / ejection from the body) of this highly precious 'Bindu' (Semen/Energy) literally and directly translates to 'Death' (Maranam).
            And firmly hoarding and perfectly retaining this Bindu strictly inside the physical body is the only true definition of real 'Life' (Jivanam).
            Therefore, the dedicated ascetic (Yati) actively walking the rigorous path of Yoga must continuously (Satatam) and with extreme caution.
            Protect and violently guard his 'Retas' (Semen/Bindu) to ensure the absolute, complete success of his Yogic practice.
            This blunt verse explicitly states that rapid old age and death are absolutely not inevitable, natural biological diseases.
            A human being dies painfully strictly because he continuously throws his vital Life-Force (Bindu) out of his body, making himself entirely hollow and weak.
            When this absolute thickest and most powerful energy (Bindu) of the body is completely exhausted, the entire Nervous System breaks down and collapses.
            But the master Yogi who successfully makes this Bindu 'Urdhvareta' (flowing upwards) transforms his physical body to become as unbreakable as solid Steel.
            When this exact Bindu vaporizes through the intense heat of Pranayama and reaches the brain (Sahasrara), the human flawlessly attains 'Supreme Enlightenment'.
            Therefore, for one who absolutely does not practice strict Brahmacharya, all Yoga books and physical postures are completely and utterly Useless.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 47,
        sanskrit = "यावद्बिन्दुः स्थिरो देहे तावन्मृत्युभयं कुतः । यावन्निरुद्धा नभोमुद्रा तावद्बिन्दुर्न गच्छति ॥ ४७ ॥",
        hindi = """
            जब तक यह परम 'बिंदु' (ऊर्जा) योगी के शरीर में पूरी तरह से स्थिर (बचा हुआ) रहता है, तब तक उसे 'मृत्यु का भय' (मौत का डर) कहाँ से हो सकता है? (अर्थात वह अमर है)।
            और जब तक साधक अपने शरीर में 'नभोमुद्रा' (खेचरी मुद्रा) को पूरी दृढ़ता के साथ लगाए (निरुद्धा) रखता है।
            तब तक वह बहुमूल्य बिंदु किसी भी कीमत पर शरीर से नीचे गिरकर नष्ट (न गच्छति) नहीं हो सकता।
            यहाँ उपनिषद 'मृत्यु पर विजय' पाने का 100% फुलप्रूफ (Foolproof) विज्ञान समझा रहा है।
            मौत केवल उसी शरीर को मार सकती है जिसकी ऊर्जा (बैटरी) खत्म हो चुकी हो; जिसकी बैटरी हमेशा फुल (Full) है, मौत उसे छू भी नहीं सकती।
            परंतु इस भयंकर 'बिंदु' (सेक्सुअल एनर्जी / Sexual energy) को कंट्रोल करना इंसान के लिए सबसे मुश्किल काम है।
            उपनिषद इसके लिए एक हैक (Hack/तकनीक) बताता है: 'नभोमुद्रा' (जीभ को तालू में लगाना)।
            जब जीभ तालू में फिक्स (Fix) हो जाती है, तो शरीर का नर्वस सिस्टम लॉक (Lock) हो जाता है और नीचे की वासनाओं (Lust) का स्विच ऑफ (Switch off) हो जाता है।
            इस मुद्रा के लगते ही मन की सारी गंदी इच्छाएं अपने-आप मर जाती हैं, और बिंदु सुरक्षित रहता है।
            इसलिए खेचरी मुद्रा और ब्रह्मचर्य दोनों एक-दूसरे के सबसे पक्के साथी हैं जो योगी को भगवान बना देते हैं।
        """.trimIndent(),
        english = """
            As long as this supreme 'Bindu' (Energy) remains perfectly and fully stabilized (hoarded) strictly within the Yogi's body, from where can the 'Fear of Death' possibly arise? (Meaning, he is totally immortal).
            And exactly as long as the sincere seeker keeps the 'Nabhomudra' (Khechari Mudra) firmly and fiercely applied and locked (Niruddha) in his body.
            Until exactly then, that highly precious Bindu can absolutely never, at any cost, fall downward and be destroyed (Na gacchati).
            Here, the Upanishad is profoundly explaining the 100% Foolproof, absolute science of successfully 'Conquering Death'.
            Death can forcefully kill only that physical body whose internal energy (Battery) has completely run out; Death cannot even touch someone whose battery remains eternally Full.
            However, successfully controlling this terrifying, immense 'Bindu' (Sexual energy) is undoubtedly the most difficult task for any human being.
            The Upanishad reveals a brilliant Hack (technique) for this: 'Nabhomudra' (firmly locking the tongue entirely into the upper palate).
            When the tongue is perfectly Fixed in the palate, the body's entire nervous system is locked, and the switch for lower worldly lusts is instantly turned Off.
            The exact moment this Mudra is applied, all filthy desires of the mind automatically die, and the precious Bindu remains 100% secure.
            Therefore, Khechari Mudra and Brahmacharya are the absolute closest, infallible companions that flawlessly transform a Yogi directly into God.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 48,
        sanskrit = "स चालितोऽपि बिन्दुस्तु सम्प्राप्तो योनिमण्डलम् । व्रजत्यूर्ध्वं हतः शक्त्या निबद्धो योनिमुद्रया ॥ ४८ ॥",
        hindi = """
            यदि किसी कारणवश वह बिंदु (वीर्य/ऊर्जा) अपने स्थान से विचलित (चालितोऽपि) हो भी जाए, और नीचे खिसक कर 'योनि-मंडल' (मूलाधार/जननांग के पास) तक पहुँच भी जाए।
            तो भी, यदि योगी ने अत्यंत शक्तिशाली 'योनि मुद्रा' (Yoni Mudra) का दृढ़ता से अभ्यास (निबद्धो) किया हुआ है।
            तो वह योनि मुद्रा उस गिरते हुए बिंदु पर अपनी 'शक्ति' का भयंकर प्रहार (हतः) करती है।
            और उस प्रहार के कारण वह गिरता हुआ बिंदु तुरंत वापस उल्टा घूमकर ऊपर की ओर (ऊर्ध्वं) सहस्रार चक्र की तरफ भाग (व्रजति) जाता है।
            यह हठयोग की सबसे 'एडवांस्ड' (Advanced) और सीक्रेट (Secret) इमरजेंसी ब्रेक (Emergency brake) है।
            कई बार योगी का मन ध्यान से भटक जाता है, और उसकी ऊर्जा (बिंदु) नीचे वासना के रास्ते बहने लगती है।
            साधारण इंसान का बिंदु अगर नीचे खिसक गया, तो वह शरीर से बाहर (स्खलित) होकर ही मानता है।
            परंतु एक सिद्ध योगी 'योनि मुद्रा' (मूलाधार को सिकोड़ना और विशेष ध्यान) लगाकर उस गिरती हुई ऊर्जा पर एक जोर का 'झटका' मारता है।
            इस झटके (Vajroli/Yoni Mudra) से वह ऊर्जा शरीर से बाहर निकलने के बजाय वापस 'यू-टर्न' (U-turn) ले लेती है और सीधे रीढ़ की हड्डी में चढ़ जाती है।
            यह विज्ञान दिखाता है कि योग में ऊर्जा को नष्ट होने से बचाने का हर संभव 'बैकअप प्लान' (Backup plan) मौजूद है।
        """.trimIndent(),
        english = """
            If, due to some rare distraction, that Bindu (Semen/Energy) accidentally becomes displaced (Chalitopi) from its secure location and slides all the way down, successfully reaching the 'Yoni-mandala' (Muladhara/near the genitals).
            Even then, if the master Yogi has firmly and flawlessly practiced and applied (Nibaddho) the exceptionally powerful 'Yoni Mudra'.
            That intense Yoni Mudra aggressively launches a violent, powerful strike (Hatah) of raw 'Shakti' directly onto that falling Bindu.
            And strictly due to that massive strike, that falling Bindu instantly reverses its direction entirely and violently rushes back upwards (Urdhvam) directly toward the Sahasrara Chakra (Vrajati).
            This is undeniably Hatha Yoga's absolute most 'Advanced', highly Secret, and foolproof Emergency Brake.
            Sometimes, even a Yogi's mind momentarily wanders from deep meditation, and his highly volatile energy (Bindu) begins to slide aggressively downward through the path of lust.
            If an ordinary human's Bindu slides down, it absolutely does not stop until it is completely discharged (lost) entirely out of the body.
            But a perfected Yogi actively applies 'Yoni Mudra' (violently contracting the Muladhara with specific focus) and delivers a massive, forceful 'Shock' directly to that falling energy.
            Due to this intense shock (Vajroli/Yoni Mudra), instead of escaping the body, that raw energy takes a violent 'U-Turn' and shoots straight back up the spine.
            This profound science flawlessly demonstrates that Yoga possesses absolutely every possible, foolproof 'Backup Plan' to strictly prevent the destruction of vital energy.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 49,
        sanskrit = "ऊर्ध्वनाभेरधस्तात्तु मेढ्रादुपरि तिष्ठति । योनिर्महाप्राणमुख्या तत्र कन्दं विनिर्दिशेत् ॥ ४९ ॥",
        hindi = """
            (अब उस 'योनि-मंडल' और 'कंद' की सटीक लोकेशन बताई जा रही है): वह स्थान नाभि (Navel) से नीचे की तरफ (अधस्तात्) होता है।
            और वह पुरुष के मेढ्र (जननांग / Genitals) के ठीक ऊपर (उपरि) की ओर स्थित (तिष्ठति) होता है (यानी नाभि और जननांग के बिल्कुल बीच में)।
            वही अत्यंत रहस्यमयी स्थान 'योनि' कहलाता है, जो हमारे 'महाप्राण' (मुख्य जीवन ऊर्जा / कुण्डलिनी) का सबसे मुख्य (मुख्या) केंद्र है।
            उसी परम पवित्र और ऊर्जावान स्थान पर ही सभी नाड़ियों का मूल 'कंद' (रूट / Bulb / Root of Nadis) स्थित है, ऐसा ऋषियों द्वारा निर्देश (विनिर्दिशेत्) दिया गया है।
            यह श्लोक प्राचीन मेडिकल साइंस (Medical Science) और चक्र-विज्ञान का एक अत्यंत पक्का और स्पष्ट एड्रेस (Address) है।
            लोग अक्सर 'कंद' और 'योनि' का मतलब गलत समझ लेते हैं; उपनिषद ने यहाँ एकदम मिलीमीटर (Millimeter) की सटीकता के साथ जगह बता दी है।
            यह वह जगह है (Perineum area) जहाँ शरीर की सभी 72,000 नाड़ियां (Nerves) आकर एक साथ जुड़ती हैं, जैसे एक पेड़ की सारी जड़ें तने (Bulb) में जुड़ती हैं।
            जब योगी इस 'कंद' पर अपनी ऊर्जा का प्रहार करता है (जैसे मूलबंध या योनि मुद्रा में), तो उसका असर सीधे पूरे 72,000 नसों के नेटवर्क पर पड़ता है।
            यह कंद ही हमारे शरीर का असली 'सर्वर रूम' (Server room) है; यहीं पर हमारी सारी सोई हुई कुण्डलिनी शक्ति छुपी हुई है।
            इस जगह पर ध्यान टिकाने से ही वह विस्फोट (Explosion) होता है जो इंसान को भगवान से मिला देता है।
        """.trimIndent(),
        english = """
            (Now the exact, precise location of that 'Yoni-mandala' and 'Kanda' is revealed): That specific location is situated perfectly downwards (Adhastat) strictly below the navel (Nabhi).
            And it is firmly established (Tishthati) directly upwards (Upari) exactly above the male Medhra (Genitals) (Meaning, precisely in the absolute middle between the navel and the genitals).
            That highly mystical, exact location is called the 'Yoni', which is the absolute primary (Mukhya) center of our 'Maha-Prana' (Main life energy / Kundalini).
            Right in that extremely sacred and highly energetic space, the fundamental 'Kanda' (Root / Bulb of all Nadis) is perfectly situated; this is explicitly directed (Vinirdishet) by the great sages.
            This profound verse provides an exceptionally rock-solid, crystal-clear Address from ancient Medical Science and Chakra-physiology.
            People often falsely misunderstand the terms 'Kanda' and 'Yoni'; the Upanishad has provided the exact location here with flawless, Millimeter-level precision.
            This is the exact specific place (Perineum area) where absolutely all 72,000 subtle Nadis (Nerves) of the body converge and join together, exactly like all roots of a tree joining at the central Bulb.
            When the master Yogi aggressively strikes his energy directly onto this 'Kanda' (as in Mulabandha or Yoni Mudra), the massive impact is instantly felt across the entire network of 72,000 nerves.
            This Kanda is undeniably the true, absolute 'Server Room' of our physical body; this is exactly where our entire sleeping Kundalini power is deeply hidden.
            Focusing intense meditation strictly on this exact spot triggers that massive Explosion which seamlessly unites the human directly with God.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 50,
        sanskrit = "यदा प्राणापानौ नादबिन्दू मूलाम्बुजे तथा । एकत्वं च गताः सर्वे तदा योगः प्रवर्त्तते ॥ ५० ॥",
        hindi = """
            जब साधक के शरीर में ऊपर की ओर जाने वाला 'प्राण' और नीचे की ओर जाने वाला 'अपान' (ये दोनों वायु)।
            तथा ध्यान में गूँजने वाला परम 'नाद' (ध्वनि) और संरक्षित किया हुआ 'बिंदु' (वीर्य/ऊर्जा)।
            जब ये चारों (प्राण, अपान, नाद, बिंदु) मूलाधार चक्र के उस मूल-कमल (मूलाम्बुजे) में एक साथ आकर टकराते हैं।
            और जब ये सब मिलकर पूरी तरह से 'एकत्व' (Oneness / एकता) को प्राप्त (गताः) हो जाते हैं (इनमें कोई भेद नहीं रहता)।
            केवल और केवल तभी (तदा) मनुष्य के भीतर असली 'योग' (परमात्मा से मिलन) प्रवृत्त (घटित / घटता) होता है।
            यह श्लोक कुण्डलिनी योग का सबसे अंतिम और सबसे महान 'महासमीकरण' (Grand Equation) है।
            योग (Yoga) का मतलब कसरत करना नहीं है; 'युज्' धातु का अर्थ है 'जोड़ना' (To Unite)।
            साधारण इंसान में साँसें (प्राण-अपान) अलग भाग रही हैं, और ध्यान (नाद-बिंदु) अलग भटक रहा है; वह इंसान 'टूटा हुआ' है।
            पर जब योगी अपनी भयंकर तपस्या से इन चारों विपरीत शक्तियों को एक ही पॉइंट (मूलाधार) पर लाकर आपस में क्रैश (Crash) कराता है।
            तो वहाँ एक ऐसा आध्यात्मिक 'बिग बैंग' (Big Bang) होता है जहाँ सारी चीजें पिघल कर केवल एक शुद्ध प्रकाश (ब्रह्म) बन जाती हैं; यही असली 'योग' है।
        """.trimIndent(),
        english = """
            When the upward-moving 'Prana' and the downward-moving 'Apana' (both these vital breaths) within the seeker's physical body.
            Along with the profoundly echoing supreme 'Nada' (Sound) in meditation, and the strictly preserved 'Bindu' (Semen/vital energy).
            When all four of these (Prana, Apana, Nada, Bindu) aggressively collide together directly within that root-lotus (Mulambuje) of the Muladhara Chakra.
            And when they absolutely all seamlessly merge and flawlessly attain total 'Ekatvam' (Absolute Oneness / Unity) (leaving zero distinction between them).
            Only, and strictly only then (Tada), does the actual, true 'Yoga' (the ultimate union with the Supreme Lord) truly occur and perfectly manifest (Pravartate) within the human.
            This magnificent verse is the absolute final, most supreme 'Grand Equation' of the entire science of Kundalini Yoga.
            Yoga absolutely does not mean doing physical workouts; the Sanskrit root 'Yuj' strictly means 'To Unite' (To Join).
            In an ordinary human, the breaths (Prana-Apana) are wildly running apart, and focus (Nada-Bindu) is wandering elsewhere; that human is completely 'Broken'.
            But when a master Yogi, through terrifyingly intense penance, forces all four of these highly opposite powers to violently Crash together at one single point (Muladhara).
            A massive spiritual 'Big Bang' instantly occurs there, where absolutely everything melts to become only one pure, blinding Light (Brahman); this is true 'Yoga'.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 51,
        sanskrit = "अनाहतस्य शब्दस्य तस्य शब्दस्य ये विदुः । तदन्तर्गतमव्यक्तं तत्परं ब्रह्म निश्चितम् ॥ ५१ ॥",
        hindi = """
            (अब नाद-योग के परम रहस्य की ओर वापसी): हृदय में बिना किसी टकराहट के निरंतर गूँजने वाले उस 'अनाहत शब्द' (नाद) को।
            जो महान साधक अत्यंत गहराई से सुनते हैं और उसे पूरी तरह से जान (विदुः) लेते हैं।
            वे यह भी जान जाते हैं कि उस गूँजने वाले शब्द के बिल्कुल भीतर (तदन्तर्गतम्) एक और भी सूक्ष्म 'अव्यक्त' (जो सुनाई या दिखाई न दे) शून्यता छिपी हुई है।
            और वह अव्यक्त शून्यता ही साक्षात् 'परब्रह्म' (Supreme God) है, यह बात बिल्कुल 100% निश्चित (Guaranteed) है।
            यह श्लोक ध्यान की गहराई की सबसे अंतिम सीमा (Limit) को दर्शाता है।
            शुरुआत में योगी को ॐकार या घंटी की बहुत ही मीठी और स्पष्ट आवाज़ (अनाहत शब्द) सुनाई देती है।
            पर अगर वह उस आवाज़ को बहुत ध्यान से सुने (Microscopic focus), तो उसे पता चलेगा कि उस आवाज़ के पीछे एक भयंकर 'सन्नाटा' (Silence) है।
            वह सन्नाटा (अव्यक्त) ही उस आवाज़ को पैदा कर रहा है और उसे अपने भीतर समेट रहा है।
            वह सन्नाटा कोई 'खाली जगह' नहीं है; वह खुद साक्षात् भगवान है (परं ब्रह्म निश्चितम्)।
            जो योगी उस आवाज़ (Sound) के पार जाकर उस 'सन्नाटे' (Silence) में छलांग लगा देता है, वह हमेशा के लिए भगवान में विलीन हो जाता है।
        """.trimIndent(),
        english = """
            (Returning to the supreme secret of Nada-Yoga): That profound 'Anahata Shabda' (the unstruck cosmic sound) continuously and effortlessly echoing right within the human heart.
            Those great, sincere seekers who listen to it exceptionally deeply and come to thoroughly know and realize it (Viduh).
            They perfectly realize that completely hidden exactly within (Tadantargatam) that echoing sound is an infinitely subtler, 'Avyakta' (unmanifest/unheard) absolute Void.
            And that specific unmanifest, soundless Void is exactly the direct 'Supreme Brahman' (God Himself); this fact is 100% absolutely certain and guaranteed (Nishchitam).
            This magnificent verse flawlessly demonstrates the absolute ultimate, highest Limit of the profound depth of meditation.
            In the very beginning, the Yogi clearly hears the incredibly sweet, distinct sound (Anahata Shabda) of Omkara or a loud ringing bell.
            But if he intensely listens to that sound with absolute Microscopic Focus, he will realize that hiding perfectly behind that sound is an overwhelmingly terrifying 'Silence'.
            That exact Silence (Avyakta) itself is actively creating that sound and ultimately folding it back entirely into itself.
            That profound Silence is absolutely not an 'Empty Space'; it is the direct, living God Himself (Param Brahma Nishchitam).
            The master Yogi who fearlessly goes beyond the Sound and boldly jumps directly into that 'Silence', merges perfectly into God forever.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 52,
        sanskrit = "पुष्पमध्ये यथा गन्धः पयोमध्ये यथा घृतम् । तिलमध्ये यथा तैलं पाषाणेष्विव काञ्चनम् ॥ ५२ ॥",
        hindi = """
            जिस प्रकार एक सुंदर फूल (पुष्प) के बिल्कुल मध्य भाग (भीतर) में उसकी मीठी सुगंध (गन्ध) हमेशा छिपी रहती है।
            जिस प्रकार दूध (पयः) के प्रत्येक कण के मध्य में शुद्ध घी (घृतम्) गुप्त रूप से छिपा होता है।
            जिस प्रकार छोटे से तिल (तिल) के दाने के बीच में उसका चिकना तेल (तैलं) हमेशा विद्यमान रहता है।
            और जिस प्रकार कठोर पत्थरों (पाषाणेषु) की चट्टानों के भीतर अत्यंत कीमती सोना (काञ्चनम्) छिपा रहता है।
            (ठीक उसी प्रकार, उस नाद के भीतर वह परब्रह्म छिपा हुआ है)।
            यह श्लोक ईश्वर की उपस्थिति को समझाने के लिए प्रकृति के सबसे शानदार चार उदाहरण (Metaphors) एक साथ देता है।
            हम फूल को देख सकते हैं, पर उसकी सुगंध को नहीं देख सकते; दूध दिखता है, पर उसमें छिपा घी सीधे नहीं दिखता।
            सोना पत्थर के अंदर है, पर उसे पाने के लिए पत्थर को बहुत मेहनत से तोड़ना और पिघलाना पड़ता है।
            उसी तरह, भगवान इस शरीर और 'नाद' (Sound) के अंदर पूरी तरह से छिपे हुए हैं, पर वो अज्ञानी आँखों को दिखते नहीं हैं।
            भगवान को बाहर ढूँढना बेवकूफी है; योग (Meditation) वह प्रक्रिया है जो दूध को मथकर (Churn) उसमें से 'घी' (आत्मा) को बाहर निकाल लेती है।
        """.trimIndent(),
        english = """
            Exactly just as the incredibly sweet fragrance (Gandha) always remains intimately hidden right in the absolute middle (inside) of a beautiful flower (Pushpa).
            Exactly just as pure, rich ghee (Ghritam) remains secretly and flawlessly concealed within every single drop of milk (Payah).
            Exactly just as smooth oil (Tailam) is perpetually and inherently present right in the exact middle of a tiny sesame seed (Tila).
            And exactly just as exceedingly highly precious solid gold (Kanchanam) remains deeply hidden inside hard, rigid rocks (Pashaneshu).
            (In the precise same manner, that Supreme Brahman remains flawlessly hidden directly within that Nada).
            This spectacular verse brilliantly provides four of Nature's most magnificent examples (Metaphors) together to flawlessly explain the exact presence of God.
            We can easily see the physical flower, but we cannot physically see its fragrance; we clearly see milk, but the hidden ghee is not directly visible.
            Gold is deeply embedded inside the stone, but to successfully extract it, one must painstakingly smash and melt the rock with immense labor.
            Exactly similarly, God is completely and perfectly hidden right inside this physical body and the 'Nada' (Sound), but He absolutely cannot be seen by ignorant eyes.
            Searching for God externally is pure stupidity; Yoga (Meditation) is the exact precise process that vigorously Churns the milk to successfully extract the 'Ghee' (Soul) out of it.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 53,
        sanskrit = "हृदि स्थाने तथात्मासौ ज्योतिर्विद्भिर्निरीक्ष्यते । यदा सर्वमयं पश्येत् तदा स मुच्यते भवात् ॥ ५३ ॥",
        hindi = """
            ठीक उन्हीं (फूल, दूध, तिल और पत्थर) के समान, वह परम 'आत्मा' भी हमारे हृदय के स्थान (हृदि स्थाने) में अत्यंत गहराई से छिपी हुई है।
            और केवल वे ही योगी जो उस दिव्य 'ज्योति' (आंतरिक प्रकाश) को जानने वाले हैं (ज्योतिर्विद्भिः), वे ध्यान के द्वारा उस आत्मा को साक्षात् देख (निरीक्ष्यते) पाते हैं।
            जब वह आत्मज्ञानी योगी इस संपूर्ण ब्रह्मांड को केवल और केवल उस एक 'आत्मा' (ब्रह्म) का ही रूप (सर्वमयं) देखने लगता है।
            केवल तभी (तदा) वह इस भयंकर जन्म-मरण रूपी भवसागर (भवात्) से हमेशा के लिए मुक्त (मुच्यते) हो जाता है।
            फूल में से सुगंध निकालने के लिए नाक चाहिए, दूध से घी निकालने के लिए मंथन (Churning) चाहिए।
            उसी तरह, हृदय में छिपी हुई उस आत्मा को देखने के लिए साधक को 'ज्योतिर्विद्' (Meditation expert) बनना पड़ता है।
            आम इंसान हृदय में केवल धड़कन (Blood pump) को महसूस करता है; पर योगी उसी हृदय में ईश्वर की 'ज्योति' को चमकता हुआ देखता है।
            ज्ञान की अंतिम परीक्षा यह नहीं है कि आपको बंद आँखों से प्रकाश दिखा; अंतिम परीक्षा खुली आँखों की है।
            जब आप आँख खोलें, तो आपको अपने दुश्मन में, कुत्ते में और पत्थर में भी वही 'सर्वमयं' (सबमें व्याप्त) भगवान नजर आना चाहिए।
            जिस दिन यह 'एकता' (Oneness) का अनुभव पक्का हो जाता है, उसी सेकंड इंसान का मोक्ष (मुक्ति) हो जाता है।
        """.trimIndent(),
        english = """
            Exactly similar to those (flower, milk, seeds, and rocks), that Supreme 'Soul' is also exceedingly deeply hidden directly within the sacred space of our heart (Hridi sthane).
            And strictly only those master Yogis who are the true knowers of that divine 'Jyoti' (inner Light / Jyotirvidbhih), are successfully able to directly behold and see (Nirikshyate) that Soul through intense meditation.
            When that fully enlightened Yogi actively begins to clearly see this entire cosmos purely and exclusively as the exact manifestation (Sarvamayam) of that one single 'Soul' (Brahman) alone.
            Only exactly then (Tada) is he completely and permanently liberated (Muchyate) forever from this terrifying ocean of continuous birth and death (Bhavat).
            To extract fragrance from a flower you need a nose; to extract ghee from milk you strictly need rigorous Churning.
            Similarly, to successfully see that deeply hidden Soul right in the heart, the seeker must absolutely become a 'Jyotirvid' (an Expert in deep meditation).
            An ordinary human merely feels a physical blood pump in the heart; but a true Yogi clearly sees the brilliant 'Light' of God blazing exactly in that very same heart.
            The ultimate test of Wisdom is absolutely not seeing light with closed eyes; the ultimate test is with wide open eyes.
            When you open your eyes, you must flawlessly see exactly that same 'Sarvamayam' (all-pervading) God in your deadly enemy, a dog, and a stone alike.
            The exact split-second this profound experience of 'Oneness' is solidified, the human being's Moksha (Liberation) instantly occurs.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 54,
        sanskrit = "पद्मपत्रमिवाम्भोजे न लिप्यते कर्मभिस्तथा । न कर्म लिप्यते तस्य यो ब्रह्मणि सदा स्थितः ॥ ५४ ॥",
        hindi = """
            (उस मुक्त ज्ञानी की स्थिति कैसी होती है?): जिस प्रकार कमल का पत्ता (पद्मपत्रम्) पानी (अम्भोजे) में ही पैदा होता है और पानी में ही रहता है।
            परन्तु फिर भी वह उस पानी से बिल्कुल भी लिप्त (गीला या चिपका हुआ) नहीं होता; पानी की एक बूँद भी उस पर नहीं ठहरती।
            ठीक उसी प्रकार, वह महाज्ञानी पुरुष इस संसार में रहते हुए हजारों कार्य करता है, पर वह कभी उन कर्मों (पाप या पुण्य) से लिप्त (न लिप्यते) नहीं होता।
            जो व्यक्ति हमेशा (सदा) उस परम 'ब्रह्म' की चेतना में ही पूरी तरह से स्थित (ठहरा हुआ) रहता है, उसे कोई भी कर्म कभी बाँध नहीं सकता।
            यह श्लोक अद्वैत वेदान्त का सबसे प्रसिद्ध और सुंदर 'कमल का उदाहरण' (Lotus metaphor) प्रस्तुत करता है।
            लोग सोचते हैं कि मोक्ष पाने के लिए हिमालय भाग जाना चाहिए क्योंकि समाज में रहेंगे तो कर्म (पाप) तो होंगे ही।
            पर उपनिषद कहता है कि भागना कायरता (Cowardice) है; असली योगी कीचड़ (संसार) के बिल्कुल बीचोबीच रहता है।
            वह ऑफिस जाता है, परिवार पालता है, पर उसके मन पर 'अहंकार' का कोई भी पानी चिपकता नहीं है।
            क्योंकि वह जानता है कि "मैं कर्ता नहीं हूँ, सब कुछ भगवान कर रहा है।"
            जब कर्तापन (Doership) की गोंद (Glue) ही खत्म हो गई, तो कर्मों का कोई भी फल (अच्छा या बुरा) उस योगी की आत्मा पर चिपक ही नहीं सकता।
        """.trimIndent(),
        english = """
            (What exactly is the state of that liberated sage?): Just exactly as a beautiful lotus leaf (Padmapatram) is born directly in the water (Ambhoje) and constantly lives strictly in the water.
            Yet, despite that, it absolutely never gets tainted, soaked, or clings to that water at all; not even a single tiny drop of water ever stays on it.
            In the exact same flawless manner, that supremely wise man aggressively performs thousands of tasks while actively living in this world, yet he is absolutely never tainted (Na lipyate) by those actions (sins or merits).
            That specific person who always (Sada) remains perfectly and completely established (anchored) strictly in the pure consciousness of 'Brahman', can absolutely never be bound by any karma whatsoever.
            This magnificent verse beautifully presents Advaita Vedanta's absolute most famous and gorgeous 'Lotus Metaphor'.
            Ignorant people falsely assume that to attain Moksha one must run away to the Himalayas, because living in society will inevitably cause karma (sins).
            But the Upanishad fiercely declares that running away is sheer Cowardice; a real, true Yogi lives exactly right in the absolute middle of the mud (the world).
            He goes to the office, actively raises a family, but absolutely no water of 'Ego' ever clings to his pure mind.
            Because he knows with absolute certainty that "I am absolutely not the doer, God is seamlessly doing everything."
            When the highly sticky Glue of Doership is completely destroyed, absolutely no fruit of karma (good or bad) can ever possibly stick to that Yogi's immortal Soul.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 55,
        sanskrit = "नादानुसन्धानमथात ऊर्ध्वं नादे विलीने परमं पदं तत् । यत्र नादो लयं याति तद्विष्णोः परमं पदम् ॥ ५५ ॥",
        hindi = """
            इसके बाद (अथातः), साधक को अपनी चेतना को उस आंतरिक 'नाद' (ध्वनि) के अनुसंधान (ध्यान) में बहुत ही ऊपर (ऊर्ध्वं/गहराई में) ले जाना चाहिए।
            जब वह मन उस गूँजते हुए नाद में पूरी तरह से विलीन (पिघलकर खत्म) हो जाता है, तो वही वास्तव में 'परम पद' (सर्वोच्च अवस्था) है।
            जहाँ जाकर वह नाद (ध्वनि) भी अंततः स्वयं ही पूर्ण शून्यता में लय (शांत / समाप्त) हो जाता है।
            वही परम शांत और निःशब्द अवस्था साक्षात् भगवान 'विष्णु का परम पद' (मोक्ष) कहलाती है।
            यहाँ फिर से नाद योग का वह अंतिम निष्कर्ष (Conclusion) दोहराया जा रहा है जो किसी भी योगी के लिए सबसे जरूरी है।
            ध्यान में आवाज़ (नाद) सुनना बहुत आनंददायक है, पर अगर साधक उसी आवाज़ से चिपक गया, तो वह आगे नहीं बढ़ पाएगा।
            आवाज़ (Sound) केवल एक 'गाइड' (Guide) है जो हमें भगवान के दरवाजे तक ले जाती है; दरवाजे के अंदर केवल सन्नाटा (Silence) है।
            जैसे नदी जब समंदर में मिलती है (लय याति), तो नदी की अपनी आवाज़ और नाम दोनों हमेशा के लिए खत्म हो जाते हैं।
            उसी तरह, जब नाद (आवाज़) उस परम ब्रह्म (समंदर) में मिलता है, तो नाद भी शांत हो जाता है और मन भी।
            विष्णु का परम पद कोई जगह (Place) नहीं, बल्कि यह पूर्ण मौन और अद्वैत की वह स्थिति है जहाँ केवल 'होना' (Being) ही शेष रहता है।
        """.trimIndent(),
        english = """
            Thereafter (Athatah), the sincere seeker must forcefully actively elevate and take his consciousness infinitely higher (Urdhvam / deeper) strictly into the deep investigation (meditation) of that internal 'Nada' (Sound).
            When that highly restless mind completely and flawlessly dissolves (melts and vanishes) into that echoing Nada, that exactly is in reality the 'Supreme Abode' (Paramam Padam / the highest state).
            Exactly where that very Nada (sound) itself ultimately undergoes complete and total dissolution (Layam yati / falls entirely silent) into absolute void.
            That exact supremely tranquil and perfectly wordless state is directly declared to be the absolute 'Supreme Abode of Lord Vishnu' (Moksha).
            Here, the absolute final and greatest Conclusion of Nada Yoga is powerfully reiterated, which is exceptionally crucial for any Yogi to perfectly understand.
            Hearing the divine sound (Nada) in meditation is incredibly blissful, but if the seeker stubbornly clings to that very sound, he will absolutely never advance further.
            Sound is merely a reliable 'Guide' that successfully takes us straight to the exact door of God; but strictly inside the door, there is absolutely nothing but pure Silence.
            Just exactly as when a roaring river perfectly merges into the vast ocean (Laya yati), both the river's loud voice and its very name are permanently destroyed forever.
            Similarly, when the Nada (sound) merges flawlessly into that Supreme Brahman (Ocean), both the Nada and the mind become perfectly and permanently silent.
            Vishnu's supreme abode is absolutely not a physical Place, but that ultimate state of absolute profound Silence and Non-duality where exclusively pure 'Being' remains left.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 56,
        sanskrit = "नाद एवामृतं साक्षात् नाद एव निरामयम् । नादेनैव हि मुक्तः स्यादत्र नास्ति विचारणा ॥ ५६ ॥",
        hindi = """
            यह भीतर गूँजने वाला परम 'नाद' (Sound) ही साक्षात् 'अमृत' (कभी न मरने वाला तत्व) है।
            यह नाद ही स्वयं पूरी तरह से 'निरामय' (सभी प्रकार के शारीरिक और मानसिक रोगों से मुक्त) है।
            केवल और केवल इसी नाद (नादेनैव) के गहरे ध्यान के द्वारा ही मनुष्य निश्चित रूप से मुक्त (मोक्ष प्राप्त) हो सकता है।
            इस परम सत्य के विषय में किसी भी प्रकार का कोई शक या विचार (विचारणा) बिल्कुल भी नहीं करना चाहिए (अत्र नास्ति विचारणा)।
            उपनिषद यहाँ नाद योग की 'सुप्रीम गारंटी' (Supreme Guarantee) दे रहा है।
            दुनिया का हर इंसान अमृत (Immortality) की तलाश में है, पर वह उसे बाहर की दवाइयों में ढूँढ रहा है।
            सच्चा अमृत हमारे ही कानों के भीतर बजने वाली वह ॐ की गूँज है; जो इसे पी लेता है, वह मृत्यु के पार चला जाता है।
            निरामय का मतलब है जहाँ कोई बीमारी (Stress, Depression, Cancer) टिक नहीं सकती; नाद का वाइब्रेशन (Vibration) शरीर की हर सेल (Cell) को हील (Heal) कर देता है।
            मोक्ष पाने के लिए आपको करोड़ों मंत्र रटने या जंगल में भूखे मरने की कोई जरूरत नहीं है।
            केवल अपने भीतर की इस आवाज़ को सुनिए; उपनिषद डंके की चोट पर कह रहा है कि बिना किसी शक के केवल इसी से मोक्ष मिल जाएगा!
        """.trimIndent(),
        english = """
            This supreme internal echoing 'Nada' (Sound) is itself the direct, absolute 'Amrita' (the immortal nectar that never dies).
            This Nada itself is completely and perfectly 'Niramayam' (entirely free from absolutely all forms of physical and mental diseases).
            Solely and exclusively strictly through the profound meditation on this very Nada alone (Nadenaiva) can a human being undoubtedly become fully liberated (attain Moksha).
            There must absolutely be zero doubt, hesitation, or second thought (Atra nasti vicharana) regarding this absolute, ultimate, supreme Truth whatsoever.
            The Upanishad is powerfully delivering the 'Supreme Guarantee' of the infallible science of Nada Yoga right here.
            Every single human in the world is desperately searching for Amrita (Immortality), but he foolishly searches for it in external, physical medicines.
            The real, true Amrita is exactly that sweet echo of OM vibrating right inside our own ears; he who successfully drinks it, effortlessly crosses entirely beyond death.
            Niramaya profoundly means a state where absolutely no disease (Stress, Depression, Cancer) can ever survive; the raw Vibration of Nada flawlessly Heals every single Cell of the body.
            To successfully attain Moksha, there is absolutely zero need for you to blindly memorize millions of mantras or brutally starve yourself to death in a dense forest.
            Simply listen intently to this divine voice right within you; the Upanishad loudly declares with absolute authority that without any doubt, Moksha will be guaranteed by this alone!
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 57,
        sanskrit = "नादानुसन्धाननमोऽस्तु तुभ्यं त्वां मन्महे तत्त्वपदं प्रदातुम् । त्वमेव साक्षात्परमं हि तत्त्वं त्वमेव विद्या परमो गुरुश्च ॥ ५७ ॥",
        hindi = """
            हे नाद-अनुसंधान (नाद के ध्यान के परम विज्ञान)! आपको मेरा बार-बार और कोटि-कोटि नमस्कार है (नमोऽस्तु तुभ्यं)।
            हम यह भलीभांति मानते (मन्महे) हैं कि केवल आप ही हमें वह परम 'तत्त्व-पद' (मोक्ष का स्थान) प्रदान (प्रदातुम्) करने में पूरी तरह समर्थ हैं।
            हे नाद! वास्तव में आप ही साक्षात् वह 'परम तत्त्व' (Supreme Reality) हैं।
            आप ही सबसे सच्ची और श्रेष्ठ 'विद्या' (ज्ञान) हैं, और आप ही हमारे सबसे 'परम गुरु' (Highest Teacher) भी हैं।
            यह श्लोक नाद (Sound) के प्रति एक अत्यंत भावपूर्ण और गहरी कृतज्ञता (Gratitude) की प्रार्थना है।
            साधक यहाँ समझ चुका है कि कोई भी बाहरी इंसान या किताब उसे भगवान तक नहीं पहुँचा सकती।
            उसके अपने ही भीतर गूँजने वाली यह आवाज़ (नाद) ही उसकी एकमात्र तारणहार है।
            यह नाद केवल एक साधन (Tool) नहीं है; साधक को अब अहसास हो गया है कि यह नाद ही साक्षात् भगवान (परम तत्त्व) है।
            बाहरी गुरु केवल रास्ता दिखा सकता है, पर जब साधक आँखें बंद करता है, तो अंदर यह नाद ही उसका हाथ पकड़कर (परम गुरु बनकर) उसे मंजिल तक ले जाता है।
            जब इस विज्ञान के प्रति इतना गहरा प्रेम और समर्पण जगता है, तो समाधि का रास्ता बहुत आसान और मीठा हो जाता है।
        """.trimIndent(),
        english = """
            O Nada-Anusandhana (the supreme science of deep meditation on Nada)! I offer my millions of repeated and profound salutations strictly to You (Namostu tubhyam).
            We completely and firmly believe and acknowledge (Manmahe) that You alone are absolutely capable of flawlessly granting (Pradatum) us that supreme 'Tattva-padam' (the ultimate state of Moksha).
            O Nada! In absolute reality, You Yourself are the direct, living 'Supreme Principle' (Supreme Reality) incarnate.
            You alone are the absolute truest and highest 'Vidya' (Wisdom), and You alone are undoubtedly our ultimate 'Supreme Guru' (Highest Teacher).
            This magnificent verse is a highly emotional, profoundly deep prayer of absolute Gratitude specifically dedicated directly to the Nada (Sound).
            The seeker has perfectly realized here that absolutely no external human or physical book can ever possibly take him to God.
            This divine voice (Nada) constantly echoing right inside his very own being is his one and only absolute Savior.
            This Nada is not merely a practice Tool; the seeker has now profoundly realized that this Nada is literally the direct God (Supreme Principle) Himself.
            An external Guru can only point out the path, but when the seeker closes his eyes, it is exclusively this internal Nada that firmly holds his hand (acting as the Supreme Guru) and successfully guides him to the final destination.
            When such incredibly deep love and total surrender awaken towards this divine science, the tough path to Samadhi instantly becomes exceptionally easy and sweet.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 58,
        sanskrit = "ब्रह्मानन्दं परमं सुखं केवलं ज्ञानमूर्तिम् । द्वन्द्वातीतं गगनसदृशं तत्त्वमस्यादिलक्ष्यम् ॥ ५८ ॥",
        hindi = """
            (वह नाद या परब्रह्म कैसा है?): वह साक्षात् 'ब्रह्मानंद' (ब्रह्म का असीम आनंद) है, जो दुनिया का सबसे 'परम सुख' (Highest Joy) है।
            वह 'केवल' (एकमात्र / Non-dual) है, और वह साक्षात् 'ज्ञान की मूर्ति' (Pure embodiment of Knowledge) है।
            वह सभी प्रकार के 'द्वंद्वों' (सुख-दुख, सर्दी-गर्मी, हार-जीत) से पूरी तरह 'अतीत' (परे / Beyond) है।
            वह उस असीम 'गगन' (आकाश / Space) के बिल्कुल समान (सदृशं) विशाल और निर्लेप है।
            और वह 'तत्त्वमसि' (तुम वही हो) आदि वेदान्त के महान वाक्यों का एकमात्र और अंतिम 'लक्ष्य' (Target) है।
            यहाँ उस अवस्था का वर्णन है जिसे योगी नाद के माध्यम से प्राप्त करता है।
            दुनिया का सुख हमेशा किसी दुख के साथ जुड़ा होता है (द्वंद्व); जैसे मीठा खाने के बाद पेट खराब होने का डर।
            पर ब्रह्मानंद वह सुख है जिसके साथ कोई दुख या कोई शर्त (Condition) नहीं जुड़ी है; वह एब्सोल्यूट (Absolute) है।
            आकाश (गगन) का उदाहरण फिर से दिया गया है, क्योंकि आकाश में चाहे कितने भी काले बादल आएं, आकाश गंदा नहीं होता।
            उसी तरह, "तत्त्वमसि" (Thou art That) का असली मतलब यही है कि तुम वो शरीर नहीं जो बीमार पड़ता है, तुम वो 'गगन' हो जो हमेशा शुद्ध और आज़ाद रहता है।
        """.trimIndent(),
        english = """
            (What exactly is that Nada or Supreme Brahman like?): He is the direct 'Brahmananda' (the infinite bliss of Brahman), which is undeniably the absolute 'Paramam Sukham' (Highest Joy) in existence.
            He is 'Kevalam' (the Absolute Only One / Non-dual), and He is the direct, living 'Jnana-murtim' (the pure embodiment of Supreme Knowledge itself).
            He is completely and flawlessly 'Dvandvatitam' (entirely Beyond all worldly dualities like joy-sorrow, heat-cold, victory-defeat).
            He is exactly identical (Sadrisham) to that boundless, infinite 'Gagana' (Sky / Space), remaining massively vast and utterly untainted.
            And He is the one and only absolute ultimate 'Lakshyam' (Target/Goal) of the great Vedantic Mahavakyas like 'Tat Tvam Asi' (Thou art That).
            This perfectly describes that exact supreme state which the master Yogi successfully attains directly through the power of Nada.
            Worldly joy is always tightly tied to some inevitable sorrow (Duality); like the underlying fear of a stomach ache right after eating sweet food.
            But Brahmananda is that absolute joy attached to absolutely no sorrow or Condition whatsoever; it is perfectly Absolute.
            The powerful example of the Sky (Gagana) is given again, because no matter how many dark, toxic clouds enter it, the sky never gets dirty.
            Similarly, the absolute true meaning of "Tat Tvam Asi" is that you are absolutely not the fragile body that gets sick; you are that exact 'Sky' that remains eternally pure and flawlessly free.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 59,
        sanskrit = "एकं नित्यं विमलमचलं सर्वधीसाक्षिभूतम् । भावातीतं त्रिगुणरहितं सद्गुरुं तं नमामि ॥ ५९ ॥",
        hindi = """
            वह परब्रह्म (या नाद) केवल 'एक' (अद्वितीय) है, वह 'नित्य' (हमेशा रहने वाला) है, और वह 'विमल' (पूरी तरह से पवित्र और दाग-रहित) है।
            वह 'अचल' (कभी न बदलने या हिलने वाला) है, और वह सभी प्राणियों की बुद्धि (धी) का एकमात्र 'साक्षी' (देखने वाला / Witness) है।
            वह सभी प्रकार के सांसारिक 'भावों' (विचारों या भावनाओं) से पूरी तरह 'अतीत' (परे) है।
            और वह प्रकृति के तीनों गुणों (सत्व, रज, तम) से पूरी तरह 'रहित' (स्वतंत्र) है।
            उस परम सत्य रूपी साक्षात् 'सद्गुरु' (True Guru) को मैं (साधक) अत्यंत भक्तिभाव से प्रणाम (नमामि) करता हूँ।
            जब योगी ध्यान की आखिरी सीढ़ी पर पहुँचता है, तो उसे पता चलता है कि उसका असली 'गुरु' बाहर कोई शरीर धारी इंसान नहीं था।
            उसका असली 'सद्गुरु' तो उसके अपने ही भीतर बैठा वह 'साक्षी' (Witnessing consciousness) है जो हमेशा से उसे देख रहा था।
            यह साक्षी कभी दुखी या खुश नहीं होता (भावातीत); यह कभी किसी कर्म में फँसता नहीं (अचल)।
            दुनिया की हर चीज़ बदल रही है (बुद्धि, शरीर, उम्र), पर यह साक्षी तत्व बचपन से लेकर बुढ़ापे तक एक जैसा ही रहता है।
            उसी एक, नित्य और पवित्र साक्षी तत्व को पहचान लेना और उसके आगे अपना अहंकार झुका देना ही सबसे सच्ची 'गुरु वंदना' है।
        """.trimIndent(),
        english = """
            That Supreme Brahman (or Nada) is strictly 'Ekam' (the Unique Only One), He is 'Nityam' (eternally existing), and He is completely 'Vimalam' (flawlessly pure and utterly stainless).
            He is 'Achalam' (absolutely unmoving and never changing), and He is the one and only absolute 'Sakshi' (Witness) of the intellect (Dhi) of all living beings.
            He is entirely 'Bhavatitam' (completely Beyond all worldly emotions, thoughts, and mental states).
            And He is completely 'Trigunarahitam' (entirely free and completely devoid of the three physical qualities of nature: Sattva, Rajas, and Tamas).
            To that direct Supreme Truth acting as the ultimate, true 'Sadguru' (True Guru), I (the seeker) bow down and offer my profound, loving salutations (Namami).
            When the Yogi finally reaches the absolute final step of meditation, he profoundly realizes that his real 'Guru' was never an external human in a physical body.
            His actual 'Sadguru' is exactly that internal 'Sakshi' (Witnessing consciousness) sitting right inside him, who had been flawlessly watching him all along.
            This Witness absolutely never becomes sad or happy (Bhavatita); it never, ever gets entangled in any worldly karma (Achala).
            Everything in the world is constantly changing (intellect, physical body, age), but this pure Witnessing element remains exactly identical from childhood to old age.
            Profoundly recognizing that one, eternal, and immaculate Witnessing element and surrendering one's toxic ego completely before It is the truest, absolute highest 'Guru Vandana' (Worship of the Guru).
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 60,
        sanskrit = "तमेवं विद्वानमृत इह भवति नान्यः पन्था विद्यतेऽयनाय । इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ ६० ॥",
        hindi = """
            (उपनिषद का परम निष्कर्ष): जो भी मनुष्य उस परब्रह्म (या नाद) को इस यथार्थ रूप में 'जान' (विद्वान) लेता है।
            वह मनुष्य इसी धरती पर और 'इसी शरीर में रहते हुए' (इह) हमेशा के लिए 'अमर' (अमृत) हो जाता है।
            परम मुक्ति (मोक्ष / अयनाय) तक पहुँचने के लिए इस ज्ञान (नाद-अनुसंधान और आत्मज्ञान) के अलावा दुनिया में दूसरा कोई भी 'रास्ता' (पन्था) बिल्कुल भी मौजूद नहीं है (नान्यः पन्था विद्यते)।
            इस प्रकार यह अत्यंत पवित्र और महान 'ध्यानबिंदु उपनिषद' यहाँ पूर्ण रूप से संपन्न (इत्युपनिषत्) होता है।
            ॐ शांतिः शांतिः शांतिः।
            यह श्लोक श्वेताश्वतर उपनिषद (3.8) की भी हुबहू घोषणा है जो सनातन धर्म का सबसे बड़ा सच है।
            मोक्ष मरने के बाद मिलने वाली कोई पेंशन (Pension) नहीं है; मोक्ष इसी क्षण (Right now) और इसी शरीर (इह) में मिलता है।
            जब इंसान जान लेता है कि "मैं शरीर हूँ ही नहीं", तो शरीर के मरने पर उसे डर क्यों लगेगा? डर का खत्म होना ही 'अमर' होना है।
            उपनिषद बहुत ही सख्ती से कहता है कि इसके अलावा कोई 'शॉर्टकट' (Shortcut) या दूसरा रास्ता (नान्यः पन्था) नहीं है; आपको ध्यान की आग से गुजरना ही होगा।
            (भगवान करे कि यह परम ज्ञान हमारे शरीर, मन और आत्मा में पूर्ण शांति स्थापित करे)।
        """.trimIndent(),
        english = """
            (The Ultimate Conclusion of the Upanishad): Whosoever 'Knows' and profoundly realizes (Vidvan) that Supreme Brahman (or Nada) strictly in this exact, authentic manner.
            That human being becomes permanently 'Immortal' (Amrita) right here on this earth and 'strictly while living within this very physical body' (Iha).
            To successfully attain supreme Liberation (Moksha / Ayanaya), there is absolutely no 'Other Path' (Nanyah pantha) existing whatsoever anywhere in the entire world, except this exact wisdom (Nada-meditation and Self-knowledge).
            Thus, this exceptionally sacred, profound, and magnificently great 'Dhyanabindu Upanishad' is completely and joyfully concluded here (Ityupanishat).
            OM Peace, Peace, Peace.
            This phenomenal verse is also the exact verbatim declaration of the Shvetashvatara Upanishad (3.8), which is the absolute greatest truth of Sanatana Dharma.
            Moksha is absolutely not some cheap Pension to be received after dying; Moksha is flawlessly attained right at this exact moment (Right now) and strictly within this very body (Iha).
            When a human completely realizes that "I am absolutely not this physical body," why on earth would he fear when the body dies? The complete annihilation of this fear is being 'Immortal'.
            The Upanishad strictly and fiercely declares that there is absolutely no 'Shortcut' or alternative road (Nanyah pantha) besides this; you absolutely must pass through the intense fire of deep meditation.
            (May this supreme wisdom firmly establish absolute, unbroken peace within our physical body, restless mind, and immortal soul forever).
        """.trimIndent()
    ),
    // ... Continuing dhyanabinduShlokasList from ID 80

    DhyanabinduShloka(
        id = 81,
        sanskrit = "अमनस्कं तदोदेति निर्मलं तत्परं पदम् । यत्र गत्वा न शोचन्ति तद्विष्णोः परमं पदम् ॥ ८१ ॥",
        hindi = """
            (अमनस्क योग की चरम अवस्था): जब शाम्भवी मुद्रा के अभ्यास से मन पूरी तरह से शांत और विचार-शून्य हो जाता है।
            तब साधक के भीतर वह अत्यंत निर्मल और पवित्र 'अमनस्क' (No-mind / मन-रहित) परम पद अपने-आप उदित (जाग्रत) होता है।
            जहाँ पहुँचने के बाद मनुष्य कभी भी किसी भी प्रकार का कोई शोक (दुख या पश्चाताप) बिल्कुल नहीं करता (न शोचन्ति)।
            वही परम शांति की अवस्था साक्षात् 'भगवान विष्णु का परम पद' (सर्वोच्च मोक्ष) है।
            अमनस्क का अर्थ है मन का पूरी तरह से 'स्विच-ऑफ' (Switch off) हो जाना; जब सोचने वाली मशीन ही बंद हो गई, तो चिंता कौन करेगा?
            हम जीवन भर अपने ही विचारों के जाल में फँसकर रोते रहते हैं; यह अवस्था उस जाल को हमेशा के लिए काट देती है।
            जब मन मिटता है, तो केवल 'शुद्ध चेतना' (Pure Awareness) बचती है, जिसमें कोई दाग या खोट (निर्मल) नहीं होता।
            यह कोई डिप्रेशन या बेहोशी नहीं है, बल्कि यह वह 'सुपर-चेतना' (Super-consciousness) है जहाँ इंसान को असली आज़ादी मिलती है।
            जो योगी इस अवस्था को एक बार छू लेता है, उसके जीवन से डर और दुख की डिक्शनरी हमेशा के लिए डिलीट हो जाती है।
            यही ध्यान की वह सबसे अंतिम और महान सफलता है जिसके लिए सारी योग साधनाएं की जाती हैं।
        """.trimIndent(),
        english = """
            (The ultimate state of Amanaska Yoga): When the mind becomes completely still and thoughtless through the practice of Shambhavi Mudra.
            Then that exceptionally immaculate, pure, and 'Amanaska' (No-mind / mindless) supreme state automatically rises (dawns) within the seeker.
            Successfully reaching that absolute state, a human being absolutely never grieves, repents, or feels any sorrow ever again (Na shochanti).
            That exact state of supreme, boundless peace is the direct 'Supreme Abode of Lord Vishnu' (Absolute Moksha).
            Amanaska profoundly means the complete 'Switch-off' of the mind; when the thinking machine itself is shut down, who will worry?
            We spend our entire lives crying, hopelessly trapped in the complex web of our very own thoughts; this state cuts that web forever.
            When the mind is destroyed, exclusively 'Pure Awareness' remains behind, possessing absolutely no stain or flaw (Nirmala).
            This is absolutely not depression or unconsciousness; it is that Super-consciousness where a human gains his real, true freedom.
            The Yogi who touches this supreme state even once has the entire dictionary of fear and sorrow permanently deleted from his life.
            This is the absolute final and most magnificent success of all meditation, for which all yogic practices are rigorously performed.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 82,
        sanskrit = "कर्पूरमिव पावके सैन्धवं सलिले यथा । तथा चिदात्मनि लीनं मनस्तत्परमं पदम् ॥ ८२ ॥",
        hindi = """
            जिस प्रकार आग (पावक) में डाला गया कपूर (कर्पूर) पूरी तरह से जलकर उसी आग में विलीन हो जाता है (उसका कोई नाम-निशान नहीं बचता)।
            और जिस प्रकार पानी (सलिल) में डाला गया नमक (सैन्धव) पूरी तरह से घुलकर उसी पानी का रूप ले लेता है।
            ठीक उसी प्रकार, जब साधक का यह चंचल मन उस 'चिदात्मा' (शुद्ध और परम चेतना) में पूरी तरह से लीन (घुल) जाता है।
            तो मन के उस पूर्ण विलय (Dissolution) की अवस्था को ही 'परम पद' (सर्वोच्च मोक्ष) कहा जाता है।
            यह श्लोक 'लय योग' (Yoga of Dissolution) का सबसे शानदार और सटीक वैज्ञानिक उदाहरण (Metaphor) प्रस्तुत करता है।
            कपूर और नमक जब तक बाहर हैं, तब तक उनका अपना एक अलग आकार और एक अलग नाम (अहंकार) है।
            पर जैसे ही वे अपने स्रोत (आग या पानी) से मिलते हैं, वे हमेशा के लिए अपनी उस छोटी सी पहचान को मिटा देते हैं।
            मन भी जब तक दुनिया में भाग रहा है, तब तक वह 'जीव' है; पर ध्यान की आग में वह कपूर की तरह जलकर ईश्वर बन जाता है।
            विलीन होने का मतलब मरना नहीं है; इसका मतलब है कि वह छोटी सी बूँद अब एक अनंत समंदर बन चुकी है।
            यही इंसान की सबसे सच्ची 'घर-वापसी' (Homecoming) है, जहाँ द्वैत (Duality) हमेशा के लिए खत्म हो जाता है।
        """.trimIndent(),
        english = """
            Exactly just as pure camphor (Karpura) thrown directly into a blazing fire completely burns and dissolves perfectly into that fire (leaving zero trace).
            And exactly just as a solid lump of salt (Saindhava) dropped into water completely dissolves and entirely takes the form of that water.
            In the precise same flawless manner, when the highly restless mind completely dissolves and melts entirely into that 'Chidatma' (Pure Consciousness).
            That absolute state of complete mental dissolution is profoundly declared by the sages as the 'Supreme Abode' (Highest Moksha).
            This magnificent verse presents the absolute most brilliant and highly accurate scientific metaphor for 'Laya Yoga' (Yoga of Dissolution).
            As long as the camphor and salt remain outside, they possess a distinct, separate physical shape and a different name (Ego).
            But the exact moment they merge with their ultimate source (fire or water), they permanently erase that petty, limited identity forever.
            Similarly, as long as the mind runs wildly in the world, it is a 'Jiva'; but in the fire of meditation, it burns like camphor and becomes God.
            Dissolving absolutely does not mean dying; it profoundly means that the tiny, helpless drop has now become an infinite, boundless ocean.
            This is undeniably the truest 'Homecoming' of a human being, where all painful duality is permanently and completely annihilated.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 83,
        sanskrit = "न तस्य व्याधिजं दुःखं न तस्य भवजं भयम् । योऽहं ब्रह्मेति निश्चित्य वीतशोकः परिभ्रमेत् ॥ ८३ ॥",
        hindi = """
            उस आत्मज्ञानी योगी को किसी भी शारीरिक बीमारी (व्याधि) से उत्पन्न होने वाला कोई भी 'दुख' (पीड़ा) कभी स्पर्श नहीं कर सकता।
            और न ही उसे इस संसार (भव) में जन्म लेने या मरने का कोई 'भय' (डर) कभी सता सकता है।
            जो योगी "निश्चित रूप से मैं ही वह साक्षात् परब्रह्म हूँ" (योऽहं ब्रह्मेति)—ऐसा अटल निश्चय (निश्चित्य) कर लेता है।
            वह योगी पूरी तरह से शोकरहित (वीतशोकः / दुख-मुक्त) होकर इस पृथ्वी पर अत्यंत स्वतंत्रता के साथ विचरण (परिभ्रमेत्) करता है।
            हम जीवन भर केवल दो ही चीजों से डरते हैं: पहला बीमारियों का दर्द, और दूसरा मौत (संसार छूटने का डर)।
            पर उपनिषद कहता है कि ये दोनों बीमारियां केवल उस 'मन' को लगती हैं जो खुद को यह कमजोर शरीर मानता है।
            जब योगी के मन में यह 'ब्रह्म-भाव' 100% पक्का हो जाता है कि वह तो अनंत आकाश के समान है, तो उसका सारा डर भाप बन जाता है।
            बीमारी शरीर को लग सकती है, पर वह उस दर्द को अपनी आत्मा तक पहुँचने ही नहीं देता; वह दर्द का भी केवल एक शांत 'साक्षी' (Witness) रहता है।
            वह दुनिया में किसी से डरकर या छुपकर नहीं रहता; वह एक शेर की तरह निडर होकर पूरी दुनिया में आज़ाद घूमता है।
            यह श्लोक 'जीवन्मुक्ति' (Liberation while alive) का सबसे बड़ा और स्पष्ट प्रमाण (Proof) है।
        """.trimIndent(),
        english = """
            That self-realized Yogi can absolutely never be touched or afflicted by any 'Sorrow' (Pain) originating from physical diseases (Vyadhi).
            Nor can he ever be tormented by the terrifying 'Fear' (Bhayam) of taking birth or dying in this worldly existence (Bhava).
            The Yogi who establishes the absolute, unbreakable conviction (Nishchitya) that "I am undoubtedly that exact Supreme Brahman" (Yo'ham Brahmeti).
            That magnificent Yogi becomes completely 'Vitashokah' (flawlessly free from all grief) and wanders (Paribhramet) this earth with absolute, supreme freedom.
            Throughout our lives, we fear exactly only two things: first, the pain of severe diseases, and second, death (the fear of losing the world).
            But the Upanishad declares that both these diseases afflict exclusively that 'Mind' which foolishly considers itself a weak physical body.
            When the 'Brahma-bhava' solidifies 100% in the Yogi's mind that he is like the infinite sky, absolutely all his fear instantly vaporizes.
            Disease may strike the physical body, but he absolutely never allows that pain to reach his Soul; he remains merely a silent 'Witness' to the pain.
            He does not live in the world hiding or fearing anyone; he roams freely and fearlessly across the entire world exactly like a majestic lion.
            This phenomenal verse is the absolute greatest and most crystal-clear Proof of 'Jivanmukti' (Supreme Liberation while fully alive).
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 84,
        sanskrit = "जाग्रत्स्वप्नसुषुप्त्यादिप्रपञ्चं यत्प्रकाशते । तद्ब्रह्माहमिति ज्ञात्वा सर्वबन्धैः प्रमुच्यते ॥ ८४ ॥",
        hindi = """
            जो परम चेतना (आत्मा) मनुष्य की जाग्रत (जागना), स्वप्न (सपने देखना) और सुषुप्ति (गहरी नींद) आदि अवस्थाओं को प्रकाशित करती है।
            तथा जो चेतना इस संपूर्ण दिखाई देने वाले प्रपञ्च (संसार) को अपने ही प्रकाश से दिखाती (प्रकाशते) है।
            "निश्चित रूप से मैं वही साक्षात् परब्रह्म हूँ" (तद्ब्रह्माहमिति)—इस परम सत्य को यथार्थ रूप में जानकर (ज्ञात्वा)।
            मनुष्य इस संसार के सभी प्रकार के बंधनों और जंजीरों से पूरी तरह मुक्त (प्रमुच्यते) हो जाता है।
            हम सोचते हैं कि हमारी आँखें दुनिया को देख रही हैं, पर विज्ञान (Science) और वेदान्त दोनों कहते हैं कि आँखों के पीछे एक 'चेतना' है जो सब देख रही है।
            जब हम सपने देखते हैं, तो हमारी आँखें बंद होती हैं, फिर भी अंदर का सिनेमा (Cinema) कौन देख रहा होता है?
            वह देखने वाला (Observer) ही वह 'परम प्रकाश' है जो कभी नहीं सोता, जो हमारे तीनों अवस्थाओं (जागना, सोना, सपने देखना) का साक्षी है।
            जब इंसान को यह गहरा अहसास हो जाता है कि वह यह शरीर या मन नहीं, बल्कि वह 'देखने वाला प्रकाश' (ब्रह्म) है।
            तो उसे दुनिया की कोई भी वासना, कोई भी कर्म या कोई भी अज्ञान बाँध नहीं सकता; उसके सारे 'बन्धन' तुरंत कट जाते हैं।
            यह श्लोक 'मैं कौन हूँ' (Who am I?) का सबसे परफेक्ट और अल्टीमेट (Ultimate) जवाब देता है।
        """.trimIndent(),
        english = """
            That supreme Consciousness (Soul) which brilliantly illuminates the human states of waking (Jagrat), dreaming (Svapna), and deep sleep (Sushupti).
            And that exact same Consciousness which reveals and illuminates (Prakashate) this entire visible, complex world (Prapancha) with its own light.
            "I am undoubtedly and certainly that exact Supreme Brahman" (Tadbrahmahamiti)—by profoundly and truly realizing (Jnatva) this absolute Truth.
            A human being becomes completely and permanently liberated (Pramuchyate) from absolutely all types of worldly bonds and heavy chains.
            We falsely assume our physical eyes are seeing the world, but both Science and Vedanta declare there is a 'Consciousness' behind the eyes seeing everything.
            When we dream, our physical eyes are firmly shut, yet who exactly is flawlessly watching that vivid internal Cinema?
            That silent Observer is exactly that 'Supreme Light' which never sleeps, which is the constant Witness of our three states (waking, dreaming, sleep).
            When a human gains the profound realization that he is not this body or mind, but strictly that 'Observing Light' (Brahman).
            Absolutely no worldly lust, no karma, and no ignorance can ever bind him; absolutely all his 'Bonds' are instantly and permanently severed.
            This magnificent verse flawlessly provides the absolute most perfect and Ultimate answer to the greatest question: 'Who am I?'.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 85,
        sanskrit = "अविद्यानाशनेनैव यदा विद्या प्रबुध्यते । तदा स्वयंप्रकाशोऽसौ चिदात्मा हि प्रकाशते ॥ ८५ ॥",
        hindi = """
            ध्यान और योग के निरंतर अभ्यास से जब 'अविद्या' (अज्ञान और मोह) का पूरी तरह से नाश (नाशनेनैव) हो जाता है।
            और जब मनुष्य के भीतर वह असली 'विद्या' (आत्मज्ञान / True Wisdom) पूरी तरह से जागृत (प्रबुध्यते) हो जाती है।
            केवल और केवल तभी (तदा) वह 'स्वयंप्रकाश' (जिसे चमकने के लिए किसी और रोशनी की जरूरत नहीं) परमात्मा प्रकट होता है।
            और वह परम 'चिदात्मा' (शुद्ध चेतना) साक्षात् रूप से साधक के हृदय में पूरी तरह प्रकाशित (प्रकाशते) हो उठती है।
            ईश्वर को कहीं बाहर से 'लाना' नहीं पड़ता; वह तो हमारे ही भीतर हमेशा से मौजूद और चमक रहा है।
            दिक्कत सिर्फ इतनी है कि हमारे मन के 'अज्ञान' (वासनाओं और घमंड) ने उस प्रकाश को एक काले परदे की तरह ढँक रखा है।
            योग की सारी मेहनत उस 'काले परदे' (अविद्या) को हटाने के लिए ही की जाती है, भगवान को बनाने के लिए नहीं।
            जैसे ही हवा से बादल हटते हैं, तो सूरज अपने-आप चमकने लगता है; सूरज को किसी टॉर्च की जरूरत नहीं होती (स्वयंप्रकाश)।
            उसी तरह, जैसे ही अज्ञान का पर्दा कटता है, आत्मा का वह परम प्रकाश अपने-आप हमारे पूरे वजूद को रोशन कर देता है।
            यही विद्या (Wisdom) का असली चमत्कार है जो इंसान को अंधकार से निकालकर सीधे अनंत प्रकाश में खड़ा कर देता है।
        """.trimIndent(),
        english = """
            When 'Avidya' (dark ignorance and delusion) is completely and flawlessly destroyed (Nashanenaiva) through the continuous practice of deep meditation and Yoga.
            And exactly when that real, true 'Vidya' (Self-knowledge / Supreme Wisdom) is perfectly and fully awakened (Prabudhyate) within the human being.
            Only, and strictly only then (Tada), does that 'Svayamprakasha' (Self-luminous Supreme Lord who needs no other light to shine) manifest Himself.
            And that absolute 'Chidatma' (Pure Consciousness) directly and fully illuminates (Prakashate) with brilliant radiance right within the seeker's heart.
            God absolutely does not need to be 'brought' in from the outside; He is already perpetually present and constantly shining right inside us.
            The only severe problem is that the 'Ignorance' (deep lusts and toxic pride) of our mind has entirely covered that light exactly like a thick black veil.
            All the intense labor of Yoga is performed exclusively to remove that 'Black Veil' (Avidya), absolutely not to artificially manufacture God.
            Just as when the wind blows the clouds away, the sun automatically begins to shine; the sun needs no external flashlight (Self-luminous).
            Similarly, the exact split-second the veil of ignorance is cut, the supreme light of the Soul automatically and flawlessly illuminates our entire existence.
            This is the absolute true miracle of Vidya (Wisdom) that violently pulls a human from dark ignorance and places him directly in infinite Light.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 86,
        sanskrit = "शुष्कपर्णमिवाक्रीडन् मारुतेन यतस्ततः । प्रारब्धकर्मवेगेन नीयते देहकस्तथा ॥ ८६ ॥",
        hindi = """
            (आत्मज्ञानी का शरीर कैसे काम करता है?): जिस प्रकार पेड़ से टूटा हुआ कोई 'सूखा पत्ता' (शुष्कपर्णम्) हवा (मारुतेन) के झोंकों के साथ।
            बिना किसी अपनी मर्जी के (अक्रीडन्), हवा जहाँ भी ले जाए, यहाँ-वहाँ (यतस्ततः) बेफिक्री से उड़ता और खेलता रहता है।
            ठीक उसी प्रकार (तथा), आत्मज्ञानी पुरुष का यह भौतिक शरीर (देहकः) भी बिना किसी अहंकार या मर्जी के।
            केवल अपने पिछले जन्मों के 'प्रारब्ध कर्मों के वेग' (Momentum of past destiny) के द्वारा ही संसार में संचालित (नीयते) होता रहता है।
            यह श्लोक 'सरेंडर' (Letting go / पूर्ण समर्पण) का दुनिया का सबसे खूबसूरत और सटीक उदाहरण है।
            सूखे पत्ते की अपनी कोई मर्जी नहीं होती; हवा उसे नाले में गिरा दे या भगवान की मूर्ति पर चढ़ा दे, पत्ता कभी शिकायत नहीं करता।
            उसी तरह, जिस ज्ञानी का अहंकार (Ego) मर चुका है, उसकी अपनी कोई पर्सनल इच्छा (Personal desire) नहीं बचती।
            उसके शरीर को जो भी दुख या सुख मिलते हैं, वह उन्हें अपने पुराने कर्मों का 'मोमेंटम' (Momentum) मानकर हँसते हुए स्वीकार कर लेता है।
            वह शरीर को चलाने की कोशिश नहीं करता; वह बस एक शांत 'साक्षी' (Witness) बनकर देखता है कि प्रकृति इस शरीर को कहाँ ले जा रही है।
            यही वह अवस्था है जहाँ इंसान सच में 'टेंशन-फ्री' (Tension-free) हो जाता है, क्योंकि उसे पता है कि "अब मुझे कुछ नहीं करना, सब भगवान कर रहा है।"
        """.trimIndent(),
        english = """
            (How does an enlightened sage's body function?): Exactly just as a detached 'Dry Leaf' (Shushkaparnam) caught in the strong gusts of the wind (Marutena).
            Without absolutely any personal will or effort (Akridan), flies and plays carelessly here and there (Yatastatah) wherever the wind blows it.
            In the precise same flawless manner (Tatha), this physical body (Dehakah) of the self-realized, enlightened sage, completely devoid of any ego or personal will.
            Is seamlessly driven and operated (Niyate) in the world solely and strictly by the massive 'Momentum of Prarabdha Karma' (past destiny) alone.
            This magnificent verse is the absolute most beautiful and accurate example of ultimate 'Surrender' (Letting go) in the entire world.
            A dry leaf has absolutely zero personal will; whether the wind drops it in a filthy gutter or places it on an idol of God, the leaf never complains.
            Similarly, the wise sage whose 'Ego' is completely dead retains absolutely zero Personal Desire or stubborn will of his own.
            Whatever worldly joy or agonizing sorrow his physical body receives, he joyfully accepts it merely as the fading 'Momentum' of his past actions.
            He absolutely stops trying to violently control the body; he simply becomes a silent 'Witness', purely observing where Nature takes this physical frame.
            This is exactly that supreme state where a human truly and literally becomes 100% 'Tension-Free', because he knows perfectly, "I have to do nothing now, God is doing everything."
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 87,
        sanskrit = "देहाभिमाने गलिते विज्ञाते परमात्मनि । यत्र यत्र मनो याति तत्र तत्र समाधयः ॥ ८७ ॥",
        hindi = """
            जब साधक का "मैं यह शरीर हूँ"—यह घोर 'देहाभिमान' (Physical Ego) पूरी तरह से पिघलकर नष्ट (गलिते) हो जाता है।
            और जब वह अपने भीतर स्थित उस साक्षात् 'परमात्मा' को यथार्थ रूप में अनुभव करके भलीभांति जान लेता है (विज्ञाते)।
            तो उसके बाद उस योगी का यह चंचल मन जहाँ-जहाँ भी (यत्र यत्र) जाता (याति) है या जिस भी वस्तु को देखता है।
            उसे वहाँ-वहाँ (तत्र तत्र) केवल साक्षात् परब्रह्म ही दिखाई देता है, और उसकी हर एक अवस्था 'सहज समाधि' (समाधयः) बन जाती है।
            यह श्लोक 'सहज समाधि' (Natural, effortless Enlightenment) का सबसे बड़ा और स्पष्ट प्रमाण है।
            शुरुआत में हमें समाधि लगाने के लिए आँखें बंद करनी पड़ती हैं और एक शांत कमरे की जरूरत होती है।
            पर जब 'अहंकार' पूरी तरह से गल जाता है (Melt हो जाता है), तो योगी को भगवान देखने के लिए आँखें बंद नहीं करनी पड़तीं।
            वह ऑफिस में हो, बाज़ार में हो, या युद्ध के मैदान में हो; उसका मन जिस भी चीज़ (व्यक्ति, पैसे, समस्या) पर जाता है, उसे उसमें केवल भगवान ही दिखता है।
            उसके लिए अब पूरी दुनिया ही एक मंदिर बन चुकी है; उसे ध्यान 'करना' नहीं पड़ता, उसका पूरा जीवन ही 'ध्यान' बन जाता है।
            यह वेदान्त की वह सर्वोच्च मंजिल (Ultimate Destination) है जहाँ इंसान संसार में रहते हुए भी संसार से 100% मुक्त (Liberated) रहता है।
        """.trimIndent(),
        english = """
            When the seeker's terrifying 'Dehabhimana' (Physical Ego / the illusion that "I am this body") completely melts away and is flawlessly destroyed (Galite).
            And exactly when he profoundly experiences and thoroughly knows (Vijnate) that direct 'Paramatman' (Supreme Lord) situated perfectly within himself.
            After that, wherever (Yatra yatra) the highly restless mind of that Yogi goes (Yati) or whatever worldly object it happens to look at.
            Right there and then (Tatra tatra), he sees absolutely nothing but the direct Supreme Brahman alone, and every single state of his effortlessly becomes 'Sahaja Samadhi' (Samadhayah).
            This phenomenal verse is the absolute greatest and clearest proof of 'Sahaja Samadhi' (Natural, effortless, continuous Enlightenment).
            In the very beginning, we absolutely must close our eyes and desperately need a quiet room just to force ourselves into Samadhi.
            But when the 'Ego' melts away completely, the master Yogi absolutely does not have to close his eyes to see God clearly.
            Whether he is in a busy office, a noisy market, or a violent battlefield; whatever object his mind lands on (person, money, problem), he sees exclusively God inside it.
            For him, the entire vast world has flawlessly transformed into a massive sacred temple; he no longer has to 'do' meditation, his entire life itself seamlessly becomes 'Meditation'.
            This is the absolute Ultimate Destination of Vedanta, where a human being lives fully actively in the world, yet remains 100% permanently Liberated from it.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 88,
        sanskrit = "पृथिवी सलिले लीना सलिलं ज्वलने तथा । ज्वलनो मरुति लीनो मरुद्व्योम्नि विलीयते ॥ ८८ ॥",
        hindi = """
            (अब ब्रह्मांडीय प्रलय / Cosmic Dissolution की प्रक्रिया का वर्णन): यह ठोस 'पृथ्वी' (Earth) तत्व पिघल कर पूरी तरह 'जल' (Water / सलिले) तत्व में विलीन (लीना) हो जाता है।
            और वह 'जल' तत्व पूरी तरह सूख कर 'अग्नि' (Fire / ज्वलने) तत्व में समा (लीन) जाता है।
            वह 'अग्नि' तत्व भी शांत होकर 'वायु' (Air / मरुति) तत्व में पूरी तरह विलीन हो जाता है।
            और अंततः, वह 'वायु' तत्व भी उस असीम और खाली 'आकाश' (Space / व्योम्नि) तत्व में जाकर पूरी तरह से गायब (विलीयते) हो जाता है।
            ध्यान केवल मन को शांत करना नहीं है; यह 'रिवर्स इंजीनियरिंग' (Reverse Engineering) की एक बहुत ही शक्तिशाली और ब्रह्मांडीय (Cosmic) प्रक्रिया है।
            सृष्टि के बनने का क्रम था: आकाश से हवा, हवा से आग, आग से पानी, और पानी से मिट्टी (पृथ्वी/शरीर) बनी।
            योगी जब ध्यान में गहरा उतरता है, तो वह इस पूरी सृष्टि को उल्टे क्रम (Reverse order) में समेटना (लय करना) शुरू कर देता है।
            सबसे पहले उसे अपने ठोस शरीर (पृथ्वी) का भान मिटाना होता है, फिर भावनाओं (जल), फिर शरीर की गर्मी (अग्नि), और फिर अपनी साँसों (वायु) को।
            जब साँसें (वायु) भी शांत होकर 'आकाश' (शून्यता) में विलीन हो जाती हैं, तो योगी का मन पूरी तरह से स्पेस (Space) के समान खाली और असीम हो जाता है।
            यह श्लोक दिखाता है कि इंसान का शरीर पूरे ब्रह्मांड का एक छोटा सा मॉडल (Microcosm) है जिसे ध्यान से डिकोड (Decode) किया जा सकता है।
        """.trimIndent(),
        english = """
            (Now describing the profound process of Cosmic Dissolution / Laya): This solid 'Earth' (Prithvi) element melts and completely dissolves (Lina) strictly into the 'Water' (Salile) element.
            And that 'Water' element completely dries up and flawlessly merges (Lina) straight into the 'Fire' (Jvalane) element.
            That blazing 'Fire' element also calms down and completely dissolves into the 'Air' (Maruti) element.
            And ultimately, that subtle 'Air' element also flawlessly vanishes and dissolves entirely (Viliyate) into that infinite, empty 'Space/Ether' (Vyomni) element.
            Meditation is absolutely not merely calming the mind; it is an incredibly powerful, deeply Cosmic process of pure 'Reverse Engineering'.
            The exact sequence of creation was: Space created Air, Air created Fire, Fire created Water, and Water created the solid Earth (physical body).
            When the master Yogi descends exceptionally deep into meditation, he aggressively begins to collapse and dissolve (Laya) this entire creation in exact Reverse Order.
            First, he must completely obliterate the gross awareness of his solid body (Earth), then his emotions (Water), then bodily heat (Fire), and finally his very breaths (Air).
            When even the breaths (Air) become perfectly still and dissolve into 'Space' (Void), the Yogi's mind effortlessly becomes exactly as empty and infinite as space itself.
            This magnificent verse flawlessly demonstrates that the human body is an exact, microscopic model (Microcosm) of the entire cosmos that can be completely Decoded through meditation.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 89,
        sanskrit = "व्योम चाहङ्कृतौ लीनमङ्कारो महत्तत्त्वे । महत्तत्त्वं च प्रकृतौ प्रकृतिः पुरुषे तथा ॥ ८९ ॥",
        hindi = """
            (लय की प्रक्रिया आगे बढ़ती है): वह असीम 'आकाश' (व्योम) तत्व भी अंततः 'अहंकार' (Ego / मैं-पन) में पूरी तरह लीन (विलीन) हो जाता है।
            वह 'अहंकार' भी अपनी सीमाओं को छोड़कर 'महत्तत्त्व' (समष्टि बुद्धि / Cosmic Intellect) में पूरी तरह समा जाता है।
            और वह 'महत्तत्त्व' भी अपनी उत्पत्ति के मूल कारण 'प्रकृति' (माया / Cosmic Energy) में जाकर लीन हो जाता है।
            और अंत में, वह विशाल 'प्रकृति' भी उस परम, शुद्ध और निर्गुण 'पुरुष' (परमात्मा / Supreme Consciousness) में पूरी तरह से विलीन (तथा) हो जाती है।
            पिछले श्लोक में हमने पंचभूतों (भौतिक दुनिया) को आकाश (Space) में खत्म किया था; पर यात्रा यहाँ खत्म नहीं होती!
            आकाश भी इंसान के 'अहंकार' (Ego) से पैदा हुआ है (क्योंकि जब 'मैं' हूँ, तभी 'जगह' का अहसास है)।
            योगी अपने उस आकाश जैसे विशाल अनुभव को भी अपने 'अहंकार' में समेट लेता है; फिर वह उस छोटे से 'मैं' (अहंकार) को ब्रह्मांडीय बुद्धि (Mahat) में पिघला देता है।
            जब ब्रह्मांडीय बुद्धि भी अपनी माता (प्रकृति/माया) में सो जाती है, तो केवल वह शुद्ध चेतना (पुरुष) बचती है जो हमेशा से अकेली और पूर्ण थी।
            यह 'लय योग' (Yoga of Dissolution) का सबसे बड़ा और अंतिम सीक्रेट (Secret) है: दुनिया को छोड़ना नहीं है, उसे अपने अंदर समेट लेना है।
            जैसे मकड़ी अपने जाले को वापस अपने अंदर खींच लेती है, वैसे ही योगी पूरे ब्रह्मांड को वापस उसी परमात्मा (पुरुष) में खींच लेता है जहाँ से वह निकला था।
        """.trimIndent(),
        english = """
            (The process of Dissolution advances further): That boundless 'Space' (Vyoma) element ultimately completely dissolves and seamlessly merges (Lina) straight into the 'Ego' (Ahamkritau / I-ness).
            That 'Ego' also perfectly abandons its petty limits and flawlessly merges entirely into the 'Mahat-Tattva' (the Cosmic Intellect).
            And that vast 'Mahat-Tattva' also goes and dissolves completely into its absolute root source of origin, 'Prakriti' (Maya / Cosmic Energy).
            And finally, that colossal, infinite 'Prakriti' herself dissolves perfectly and flawlessly (Tatha) entirely into that supreme, pure, and attributeless 'Purusha' (Paramatma / Supreme Consciousness).
            In the previous verse, we successfully collapsed the five gross elements (physical world) entirely into Space; but the journey absolutely does not end there!
            Even Space is born strictly from the human 'Ego' (because only when the 'I' exists, does the awareness of 'Space' exist).
            The Yogi collapses even that massive space-like experience entirely back into his 'Ego'; then he brilliantly melts that tiny 'I' (Ego) straight into the Cosmic Intellect (Mahat).
            When even the cosmic intellect falls fast asleep in its Mother (Prakriti/Maya), absolutely only that pure Consciousness (Purusha) remains, which was always alone and perfectly complete.
            This is the absolute greatest and final Secret of 'Laya Yoga' (Yoga of Dissolution): you do not have to leave the world; you have to completely fold it back inside yourself.
            Exactly as a spider flawlessly pulls its vast web completely back inside itself, the Yogi pulls the entire cosmos right back into that exact God (Purusha) from where it originally emerged.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 90,
        sanskrit = "पुरुषान्न परं किञ्चित् सा काष्ठा सा परा गतिः । अत्रैवाखिलभूतानां प्रलयो हि विधीयते ॥ ९० ॥",
        hindi = """
            उस परम 'पुरुष' (परमात्मा / शुद्ध चेतना) से परे या उससे बड़ा इस पूरे ब्रह्मांड में कुछ भी (किञ्चित्) नहीं है।
            वही परम पुरुष सभी चीजों की सबसे अंतिम सीमा (काष्ठा) है, और वही सभी जीवों की परम और सबसे श्रेष्ठ गति (मंजिल / परा गति) है।
            केवल और केवल इसी परम पुरुष (अत्रैव) के भीतर ही, इस संपूर्ण ब्रह्मांड और सभी प्राणियों (अखिलभूतानां) का।
            सबसे अंतिम और पूर्ण 'प्रलय' (महा-विनाश / महा-विलय) निश्चित रूप से घटित (विधीयते) होता है।
            यह श्लोक कठोपनिषद (3.11) की ही वह महान घोषणा है जो यहाँ 'लय योग' को पूरी तरह से प्रमाणित (Validate) करती है।
            जब प्रकृति (Maya) भी पुरुष में विलीन हो गई, तो अब आगे जाने का कोई रास्ता नहीं है, क्योंकि आगे कुछ है ही नहीं (फुलस्टॉप / Full Stop)।
            विज्ञान (Science) ऊर्जा (Energy/Prakriti) तक पहुँच कर रुक जाता है, पर वेदान्त कहता है कि ऊर्जा भी उस 'चेतना' (पुरुष) से पैदा हुई है।
            प्रलय का मतलब दुनिया का पानी में डूब जाना नहीं है; प्रलय का असली मतलब है इंसान के दिमाग से 'द्वैत' (Duality) का हमेशा के लिए मिट जाना।
            जब योगी ध्यान में इस अवस्था को प्राप्त कर लेता है, तो उसके लिए दुनिया का महा-प्रलय (End of the world) इसी जीवन में घटित हो जाता है।
            वह परम पुरुष (God) ही वह एकमात्र 'ब्लैक होल' (Black Hole) है जिसमें यह पूरा का पूरा ब्रह्मांड समाकर हमेशा के लिए शांत हो जाता है।
        """.trimIndent(),
        english = """
            There is absolutely nothing (Kinchit) whatsoever in this entire cosmos that is higher than, or beyond, that Supreme 'Purusha' (God / Pure Consciousness).
            That Supreme Person is undeniably the absolute ultimate limit (Kastha) of everything, and He alone is the supreme, highest, and final destination (Para gati) for all living beings.
            Only, and strictly only within this exact Supreme Purusha (Atraiva), does the absolute, final, and complete 'Pralaya' (Great Dissolution / Grand Annihilation).
            Of this entire massive universe and absolutely all living beings (Akhilabhutanam) undoubtedly and flawlessly take place (Vidhiyate).
            This phenomenal verse is the exact magnificent declaration from the Katha Upanishad (3.11) which completely and perfectly Validates 'Laya Yoga' here.
            When even Prakriti (Maya) has flawlessly dissolved into the Purusha, there is absolutely zero path to go any further, simply because nothing exists beyond Him (It is the absolute Full Stop).
            Modern Science reaches up to raw Energy (Prakriti) and stops, but Vedanta boldly declares that even Energy is born strictly from that 'Consciousness' (Purusha).
            Pralaya absolutely does not mean the physical world drowning in water; true Pralaya means the permanent annihilation of 'Duality' from the human brain forever.
            When the master Yogi successfully attains this state in deep meditation, the absolute End of the World (Maha-Pralaya) literally happens for him right in this very lifetime.
            That Supreme Purusha (God) is the one and only true, ultimate 'Black Hole' into which this entire massive universe flawlessly merges and becomes perfectly silent forever.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 91,
        sanskrit = "यदा सर्वाणि भूतानि स्वात्मन्येवानुपश्यति । सर्वभूतेषु चात्मानं ततो न विजुगुप्सते ॥ ९१ ॥",
        hindi = """
            (ईशावास्य उपनिषद 6 का साक्षात् प्रमाण): जब वह ज्ञानी पुरुष इस संसार के सभी छोटे-बड़े प्राणियों (सर्वाणि भूतानि) को।
            केवल और केवल अपनी ही आत्मा (स्वात्मन्येव) के भीतर स्थित (यानी अपनी ही आत्मा का विस्तार) देखता (अनुपश्यति) है।
            और जब वह अपनी उस परम आत्मा (आत्मानं) को ही इस ब्रह्मांड के सभी प्राणियों (सर्वभूतेषु) के भीतर पूर्ण रूप से मौजूद देखता है।
            तो ऐसा महान और दिव्य अनुभव हो जाने के बाद (ततः), वह योगी फिर कभी भी किसी भी प्राणी से घृणा, नफरत या निंदा (विजुगुप्सते) बिल्कुल नहीं करता।
            यह श्लोक अद्वैत वेदान्त का सबसे महान 'सोशल लॉ' (Social Law / सामाजिक नियम) है।
            हम दूसरों से नफरत या ईर्ष्या (Jealousy) क्यों करते हैं? क्योंकि हम उन्हें खुद से 'अलग' (Separate) और दुश्मन मानते हैं।
            पर जिस योगी ने ध्यान में पूरे ब्रह्मांड को अपने अंदर (लय योग) समेट लिया है, उसकी आँखें पूरी तरह से बदल जाती हैं।
            उसे भिखारी में, राजा में, कुत्ते में और कीड़े में केवल अपना ही 'चेहरा' (आत्मा) दिखाई देता है।
            जब आपको पता हो कि सामने वाला इंसान कोई 'दूसरा' नहीं, बल्कि आप 'खुद' ही दूसरे रूप में खड़े हैं, तो आप उससे नफरत कैसे कर सकते हैं?
            नफरत (Hatred) केवल अज्ञान की बीमारी है; आत्मज्ञान होते ही इंसान के दिल से नफरत का नामोनिशान हमेशा के लिए मिट जाता है।
        """.trimIndent(),
        english = """
            (Direct proof from Isha Upanishad 6): When that deeply enlightened sage flawlessly and clearly sees (Anupashyati) absolutely all minor and major living creatures of this world (Sarvani bhutani).
            Strictly and exclusively situated exactly within his very own Soul (Svatmanyeva) (meaning, as the direct extension of his own Soul).
            And exactly when he clearly sees that exact same Supreme Soul of his (Atmanam) perfectly and completely existing within absolutely all living beings of this cosmos (Sarvabhuteshu).
            Then, immediately after attaining such a magnificent and divine experience (Tatah), that Yogi absolutely never, ever hates, despises, or condemns (Vijugupsate) any creature whatsoever.
            This phenomenal verse provides Advaita Vedanta's absolute greatest and most magnificent 'Social Law'.
            Why do we constantly hate or feel intense Jealousy toward others? Strictly because we falsely consider them to be 'Separate' from us and view them as enemies.
            But the master Yogi who has flawlessly folded the entire cosmos into himself in deep meditation (Laya Yoga) has his physical eyes radically transformed.
            He clearly sees exclusively his very own 'Face' (Soul) vividly in the beggar, the king, the dog, and the worm alike.
            When you know with absolute certainty that the person standing before you is not 'Another', but strictly 'You' yourself standing in a different form, how on earth can you ever hate him?
            Hatred is strictly a disease born purely of dark ignorance; the exact split-second Self-knowledge dawns, the very trace of hatred is permanently obliterated from the human heart forever.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 92,
        sanskrit = "यस्मिन्सर्वाणि भूतानि आत्मैवाभूद्विजानतः । तत्र को मोहः कः शोक एकत्वमनुपश्यतः ॥ ९२ ॥",
        hindi = """
            (ईशावास्य उपनिषद 7 का प्रमाण): जिस परम अवस्था (यस्मिन्) को प्राप्त कर लेने पर, सत्य को भलीभांति जानने वाले (विजानतः) उस ज्ञानी पुरुष के लिए।
            इस संसार के सभी प्राणी (सर्वाणि भूतानि) केवल साक्षात् उसकी अपनी ही 'आत्मा' (आत्मैवाभूत्) बन जाते हैं (अर्थात कुछ भी अलग नहीं बचता)।
            उस अवस्था (तत्र) में पहुँचने के बाद, जहाँ वह योगी केवल पूर्ण 'एकता' (एकत्वम् / Oneness) का ही साक्षात् दर्शन (अनुपश्यतः) कर रहा है।
            वहाँ उस ज्ञानी पुरुष के लिए कौन सा 'मोह' (Delusion / भ्रम) और कौन सा 'शोक' (दुख / Sorrow) बाकी रह सकता है? (अर्थात कोई दुख नहीं बचता)।
            यह श्लोक वेदान्त का सबसे बड़ा मनोवैज्ञानिक (Psychological) इलाज (Treatment) है।
            इंसान रोता (शोक) क्यों है? क्योंकि उसकी कोई प्यारी चीज़ (पैसा, रिश्तेदार) उससे दूर हो गई है या छिन गई है।
            और इंसान मोह (Delusion) में क्यों फँसता है? क्योंकि उसे लगता है कि कोई बाहरी चीज़ उसे हमेशा के लिए सुखी बना देगी।
            पर जब ज्ञानी को यह समझ आ गया कि "पूरी दुनिया ही मैं हूँ" (एकत्वम्), तो उससे कुछ छिन कैसे सकता है? जो कुछ भी है, वह तो उसी के अंदर है!
            जब कुछ 'बाहर' है ही नहीं, तो खोने का डर (शोक) और पाने का लालच (मोह) दोनों एक ही सेकंड में हमेशा के लिए खत्म हो जाते हैं।
            यही 'अद्वैत' का वह अजेय (Invincible) कवच (Armor) है, जिसे पहनने के बाद दुनिया की कोई भी पीड़ा इंसान को रुला नहीं सकती।
        """.trimIndent(),
        english = """
            (Proof from Isha Upanishad 7): Upon successfully attaining that supreme state (Yasmin), for that highly enlightened sage who perfectly knows and realizes the Truth (Vijanatah).
            Absolutely all living beings (Sarvani bhutani) of this world flawlessly and literally become exactly his very own 'Soul' alone (Atmaivabhut) (meaning, nothing separate remains).
            After successfully reaching that ultimate state (Tatra), where that Yogi is directly and continuously beholding (Anupashyatah) absolutely nothing but pure 'Oneness' (Ekatvam).
            Exactly what kind of 'Moha' (Delusion / blind attachment) and what kind of 'Shoka' (Sorrow / grief) can possibly remain left for that wise sage? (Meaning, absolutely zero sorrow survives).
            This magnificent verse is Vedanta's absolute greatest and most supreme Psychological Treatment (Cure).
            Why exactly does a human cry (Shoka)? Strictly because some highly beloved thing (money, relatives) has gone far away or been brutally snatched from him.
            And why does a human get trapped in Moha (Delusion)? Because he foolishly thinks some external object will make him permanently happy.
            But when the wise sage profoundly understands that "I myself am the entire world" (Ekatvam), how can anything possibly be snatched from him? Whatever exists, is already strictly inside him!
            When absolutely nothing exists 'Outside', the terrifying fear of losing (Sorrow) and the toxic greed of acquiring (Delusion) are both instantly annihilated forever in a single second.
            This is that invincible (Unbreakable) Armor of 'Advaita'; after wearing it, absolutely no agonizing pain in the world can ever make a human cry again.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 93,
        sanskrit = "अपाणिपादो जवनो ग्रहीता पश्यत्यचक्षुः स शृणोत्यकर्णः । स वेत्ति वेद्यं न च तस्यास्ति वेत्ता तमाहुरग्र्यं पुरुषं महान्तम् ॥ ९३ ॥",
        hindi = """
            (श्वेताश्वतर उपनिषद 3.19 का साक्षात् प्रमाण): वह परब्रह्म बिना हाथ-पैरों (अपाणिपादो) के भी अत्यंत तेज दौड़ने वाला (जवनो) और सब कुछ पकड़ने वाला (ग्रहीता) है।
            वह बिना भौतिक आँखों (अचक्षुः) के भी इस पूरे ब्रह्मांड को बिल्कुल स्पष्ट रूप से देखता है (पश्यति), और बिना कानों (अकर्णः) के भी सब कुछ सुनता है (शृणोति)।
            इस संसार में जो कुछ भी जानने योग्य (वेद्यं) है, वह उन सबको पूरी तरह से जानता (वेत्ति) है; परंतु पूरी दुनिया में उसे (भगवान को) पूरी तरह जानने वाला (वेत्ता) कोई नहीं है।
            महान ज्ञानी ऋषियों ने उसी निराकार और सर्वशक्तिमान सत्ता को ही सबसे श्रेष्ठ (अग्र्यं) और 'महान पुरुष' (परमात्मा) कहकर पुकारा है (तमाहुः)।
            यह श्लोक ईश्वर के असली, निराकार (Formless) स्वरूप का सबसे शक्तिशाली और अचूक (Infallible) वर्णन करता है।
            हम अज्ञानवश भगवान को एक इंसान की तरह दो हाथ-पैर वाला मान लेते हैं; पर उपनिषद कहता है कि भगवान कोई 'इंसान' नहीं है, वह एक असीम 'चेतना' (Awareness) है।
            उसके पास भौतिक आँखें नहीं हैं, फिर भी दुनिया के हर कोने में जो भी हो रहा है, वह उसे एक ही पल में देख रहा है (क्योंकि वह सब जगह मौजूद है)।
            हम अपने छोटे से दिमाग से उस अनंत भगवान को 'जानने' (Measure करने) की कोशिश करते हैं, पर यह असंभव है (न च तस्यास्ति वेत्ता)।
            जैसे एक छोटा सा कप (Cup) पूरे समंदर को नहीं नाप सकता, वैसे ही हमारा दिमाग भगवान को नहीं नाप सकता।
            उसे जानने का केवल एक ही तरीका है—अपने अहंकार (Cup) को तोड़कर खुद समंदर (महान पुरुष) में मिल जाना (ध्यानबिंदु)।
        """.trimIndent(),
        english = """
            (Direct proof from Shvetashvatara Upanishad 3.19): That Supreme Brahman, entirely without any physical hands or feet (Apanipado), is exceptionally swift (Javano) and the absolute Grasper (Grahita) of everything.
            He flawlessly and vividly sees (Pashyati) this entire cosmos entirely without any physical eyes (Achakshuh), and He perfectly hears (Shrinoti) absolutely everything completely without any ears (Akarnah).
            Absolutely whatever is worthy to be known (Vedyam) in this universe, He knows (Vetti) it completely; but in the entire world, there is absolutely no Knower (Vetta) who can fully comprehend Him.
            The exceptionally great, wise sages have profoundly declared (Tamahuh) that exact formless, omnipotent Reality as the absolute highest (Agryam) and the 'Great Person' (Mahan Purusham / God).
            This spectacular verse provides the absolute most powerful and Infallible description of God's true, Formless (Nirakara) original nature.
            Out of thick ignorance, we falsely assume God to be just like a human with two physical hands and feet; but the Upanishad declares God is absolutely no 'Human', He is a boundless 'Awareness'.
            He possesses absolutely zero physical eyes, yet whatever is happening in every single dark corner of the world, He sees it flawlessly in a single split-second (because He is omnipresent).
            We foolishly attempt to 'know' (Measure) that infinite God with our tiny, pathetic brains, but this is absolutely impossible (Na cha tasyasti vetta).
            Just exactly as a tiny Cup can absolutely never measure the vast, infinite ocean, our limited brain can never measure God.
            There is strictly only one way to know Him—ruthlessly smash your Ego (Cup) and seamlessly merge directly into that vast Ocean (Great Person) through deep meditation (Dhyanabindu).
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 94,
        sanskrit = "वेदाहमेतं पुरुषं महान्तमादित्यवर्णं तमसः परस्तात् । तमेव विदित्वाति मृत्युमेति नान्यः पन्था विद्यतेऽयनाय ॥ ९४ ॥",
        hindi = """
            (श्वेताश्वतर उपनिषद 3.8 / ध्यान का अंतिम अनुभव): (ज्ञानी उद्घोष करता है): "मैं उस 'महान पुरुष' (परमेश्वर) को अब भलीभांति जान गया हूँ (वेदाहमेतं)।"
            "वह महान परमात्मा सूर्य के समान अत्यंत प्रकाशमान (आदित्यवर्णं) है, और वह अज्ञान रूपी घोर अंधकार (तमसः) से पूरी तरह परे (परस्तात्) है।"
            "केवल और केवल उसी एक परमात्मा को यथार्थ रूप में जानकर (तमेव विदित्वा), मनुष्य मृत्यु (जन्म-मरण के चक्र) को पूरी तरह से पार (अति मृत्युमेति) कर जाता है।"
            "उस परम मोक्ष (अयनाय) तक पहुँचने के लिए, इस आत्मज्ञान के अलावा दुनिया में दूसरा कोई भी 'रास्ता' (पन्था) बिल्कुल भी मौजूद नहीं है (नान्यः पन्था विद्यते)।"
            यह श्लोक किसी भी योगी के जीवन का 'विनिंग मोमेंट' (Winning Moment / जीत का क्षण) है, जब वह छाती ठोककर कहता है: "हाँ, मैंने भगवान को देख लिया है!"
            यह कोई घमंड नहीं, बल्कि पूर्ण आत्मविश्वास (Absolute Conviction) है। भगवान अँधेरे (अज्ञान) में नहीं रहता; वह 10,000 सूर्यों (आदित्य) के प्रकाश जैसा है।
            लोग मौत से बचने के लिए दवाइयां खाते हैं या छुपते हैं, पर उपनिषद कहता है कि मौत को हराने की इकलौती दवा 'आत्मज्ञान' (Self-knowledge) है।
            जब इंसान जान लेता है कि "मैं तो वह सूरज (चेतना) हूँ जो कभी नहीं बुझता", तो मौत हार मानकर उसके पैरों में गिर जाती है।
            उपनिषद यहाँ एक बहुत ही कठोर सत्य (Harsh truth) कह रहा है: आप चाहे कितनी भी पूजा करें या दान दें, बिना 'ज्ञान' (विदित्वा) के मोक्ष कभी नहीं मिलेगा।
            मोक्ष का दूसरा कोई 'शॉर्टकट' (Shortcut) या गली (नान्यः पन्था) नहीं है; आपको ध्यान की अग्नि से गुजरकर उस प्रकाश को जानना ही होगा।
        """.trimIndent(),
        english = """
            (Shvetashvatara 3.8 / The ultimate experience of meditation): (The sage boldly declares): "I have now thoroughly known and realized (Vedahametam) that 'Great Person' (Supreme Lord)."
            "That magnificent Supreme Lord is exceptionally brilliant and radiant exactly like the sun (Adityavarnam), and He exists completely and absolutely beyond (Parastat) the thick darkness of ignorance (Tamasah)."
            "Solely and exclusively by truly realizing and knowing Him alone (Tameva viditva), a human being completely and flawlessly crosses over (Ati mrityumeti) terrifying Death (the cycle of rebirth)."
            "To successfully reach that supreme Liberation (Ayanaya), there is absolutely no 'Other Path' (Nanyah pantha) existing whatsoever anywhere in the world, besides this pure Self-knowledge (Nanyah pantha vidyate)."
            This phenomenal verse represents the absolute 'Winning Moment' of any Yogi's life, when he proudly beats his chest and loudly declares: "Yes, I have definitively seen God!"
            This is absolutely not toxic arrogance, but perfect, unbroken Absolute Conviction. God does not dwell in the dark (ignorance); He is exactly like the blinding light of 10,000 suns (Aditya).
            People blindly swallow medicines or hide desperately to escape death, but the Upanishad fiercely declares that the only absolute medicine to defeat death is 'Self-knowledge' (Jnana).
            When a human perfectly realizes "I am that exact Sun (Consciousness) that absolutely never extinguishes," Death helplessly accepts defeat and falls right at his feet.
            The Upanishad is brutally declaring a very Harsh Truth here: no matter how much you blindly worship or give massive charity, without absolute 'Wisdom' (Viditva), Moksha is permanently impossible.
            There is absolutely no other cheap 'Shortcut' or alternative alleyway (Nanyah pantha) to Moksha; you absolutely must pass through the blazing fire of meditation and directly know that Light.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 95,
        sanskrit = "अणोरणीयान्महतो महीयानात्मास्य जन्तोर्निहितो गुहायाम् । तमक्रतुः पश्यति वीतशोको धातुप्रसादान्महिमानमात्मनः ॥ ९५ ॥",
        hindi = """
            (कठोपनिषद 1.2.20 का प्रमाण): यह परमात्मा सबसे छोटे 'परमाणु' (अणु) से भी अत्यंत सूक्ष्म (अणीयान्) है, और यह महान से महान आकाश से भी अत्यंत विशाल (महीयान्) है।
            यह परम असीम 'आत्मा' इस संसार के प्रत्येक प्राणी (जन्तोः) के हृदय रूपी गुफा (गुहायाम्) में अत्यंत गहराई से छिपी (निहितो) हुई है।
            वह साधक जिसकी सभी सांसारिक इच्छाएं और कामनाएं पूरी तरह से खत्म हो चुकी हैं (अक्रतुः / Desireless)।
            केवल वही निष्काम पुरुष, परमेश्वर की विशेष 'कृपा' (धातुप्रसादात्) के द्वारा अपनी ही आत्मा की इस महान 'महिमा' (महिमानं) को साक्षात् देखता (पश्यति) है।
            और उस महिमा को देखकर वह हमेशा के लिए शोकरहित (वीतशोको / सारे दुखों से मुक्त) हो जाता है।
            ईश्वर का कोई एक फिक्स (Fix) साइज नहीं है; वह चींटी के दिल में फिट होने जितना छोटा भी है, और पूरे ब्रह्मांड को निगलने जितना बड़ा भी है।
            हम उसे ढूँढने के लिए आसमान में दूरबीन (Telescope) लगाते हैं, जबकि वह हमारे ही दिल की 'गुफा' (Cave) में चुपचाप बैठा है।
            उसे देखने की सबसे पहली शर्त क्या है? 'अक्रतुः' (Desireless होना)। जब तक आपके मन में "मुझे यह चाहिए, मुझे वह चाहिए" का शोर है, आप उसे नहीं देख सकते।
            जब मन की सारी इच्छाएं शांत हो जाती हैं, तो ध्यान (Dhyana) लगता है; पर अंतिम दर्शन (Vision) आपकी मेहनत से नहीं, बल्कि भगवान की 'कृपा' (Grace/प्रसाद) से ही होता है।
            जब वह कृपा बरसती है, तो इंसान के जीवन भर का सारा डिप्रेशन, टेंशन और शोक (Sorrow) एक ही पल में राख हो जाता है (वीतशोको)।
        """.trimIndent(),
        english = """
            (Proof from Katha Upanishad 1.2.20): This Supreme Lord is infinitely subtler and smaller (Aniyan) than the absolute smallest 'Atom' (Anu), and He is incredibly vastly greater (Mahiyan) than the greatest magnitude (Space).
            This supreme, boundless 'Soul' is exceptionally deeply hidden and firmly seated (Nihito) right inside the cave of the heart (Guhayam) of absolutely every single living creature (Jantoh) in this world.
            That specific sincere seeker whose worldly desires, deep lusts, and cravings have been completely and totally annihilated (Akrutuh / Desireless).
            Only that perfectly desireless man, strictly through the special, absolute 'Grace' of the Creator (Dhatuprasadat), directly and flawlessly sees (Pashyati) this magnificent 'Glory' (Mahimanam) of his very own Soul.
            And by vividly beholding that supreme glory, he becomes completely and permanently free from all agonizing sorrow and grief forever (Vitashoko).
            God absolutely does not have a single fixed Size; He is miraculously small enough to fit perfectly in an ant's tiny heart, and unimaginably massive enough to swallow the entire cosmos.
            We foolishly point powerful Telescopes at the sky to aggressively search for Him, while He sits perfectly quietly strictly within the 'Cave' of our very own heart.
            What is the absolute first strict condition to see Him? Being 'Akrutuh' (Desireless). As long as the toxic noise of "I want this, I need that" rages in your mind, you simply cannot see Him.
            When all chaotic mental desires become perfectly still, deep meditation (Dhyana) naturally occurs; but the absolute final Vision happens not merely by your labor, but strictly by God's absolute 'Grace' (Prasada).
            When that divine grace furiously showers down, all the severe depression, heavy tension, and deep sorrow of a human's entire life are burnt to ashes in a single split-second (Vitashoko).
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 96,
        sanskrit = "सर्वेन्द्रियगुणाभासं सर्वेन्द्रियविवर्जितम् । सर्वस्य प्रभुमीशानं सर्वस्य शरणं सुहृत् ॥ ९६ ॥",
        hindi = """
            (श्वेताश्वतर उपनिषद 3.17): वह परब्रह्म शरीर की 'सभी इंद्रियों' और उनके गुणों (देखना, सुनना आदि) के माध्यम से प्रकाशित (आभासं) और कार्य करता हुआ प्रतीत होता है।
            परंतु वास्तविकता में, वह स्वयं सभी प्रकार की भौतिक इंद्रियों और सीमाओं से पूरी तरह 'रहित' (विवर्जितम् / Free) है (उसकी अपनी कोई भौतिक आँख या कान नहीं है)।
            वही एक परमात्मा इस पूरे ब्रह्मांड और सभी प्राणियों का एकमात्र 'प्रभु' (मालिक) और 'ईशान' (परम शासक / Controller) है।
            और वही ईश्वर सभी असहाय जीवों का एकमात्र परम 'शरण' (Refuge / सुरक्षित घर) और बिना किसी स्वार्थ के प्रेम करने वाला सच्चा 'सुहृत्' (परम मित्र / Friend) है।
            यह श्लोक ईश्वर के अत्यंत रहस्यमयी और प्यारे स्वरूप (Nature) का वर्णन करता है।
            हम जो कुछ भी अपनी आँखों से देख रहे हैं या कानों से सुन रहे हैं, वह काम हमारी आँखें नहीं कर रहीं; उनके पीछे वह 'परमात्मा' ही हमारी इंद्रियों को पावर (Power) दे रहा है।
            पर वो भगवान खुद इन आँखों का गुलाम नहीं है (विवर्जितम्); अगर आँखें फूट भी जाएं, तो भी उसकी चेतना कम नहीं होती।
            वह पूरी दुनिया का कड़क 'ईशान' (शासक) है जो कर्मों का फल देता है; पर साथ ही वह बहुत ही दयालु है।
            जब इंसान दुनिया के धक्के खाकर थक जाता है, तो उसे अंत में केवल उसी भगवान की 'शरण' (Shelter) में आना पड़ता है।
            वह हमारा 'सुहृत्' है; दुनिया के दोस्त मतलब के लिए प्यार करते हैं, पर भगवान इकलौता ऐसा 'दोस्त' है जो हमारी अनगिनत गलतियों के बावजूद हमसे निस्वार्थ प्यार करता है।
        """.trimIndent(),
        english = """
            (Shvetashvatara 3.17): That Supreme Brahman flawlessly appears to shine (Abhasam) and actively function perfectly through 'All the physical senses' and their specific qualities (seeing, hearing, etc.) of the body.
            But in absolute reality, He Himself is completely and totally 'Devoid' and flawlessly free (Vivarjitam) from absolutely all forms of physical senses and their tight limits (He has no physical eyes or ears of His own).
            That exact same, one Supreme Lord is the one and only absolute 'Prabhu' (Master) and 'Ishana' (Supreme Ruler / Controller) of this entire massive cosmos and all living creatures.
            And that exact God is the sole, ultimate 'Sharana' (Refuge / perfectly safe Home) for all helpless beings, and the only true 'Suhrit' (Supreme Friend) who loves unconditionally without any selfishness.
            This magnificent verse profoundly describes the exceptionally mystical, highly paradoxical, and intensely loving true Nature of God.
            Whatever we are actively seeing with our eyes or hearing with our ears, our physical eyes are absolutely not doing the work; strictly behind them, it is exactly that 'Paramatma' providing raw Power to our senses.
            But that God Himself is absolutely not a pathetic slave to these physical eyes (Vivarjitam); even if the physical eyes are completely destroyed, His infinite consciousness does not diminish an inch.
            He is the exceptionally strict 'Ishana' (Ruler) of the whole world who dispenses karmic fruits; but simultaneously, He is unbelievably deeply compassionate.
            When a human gets brutally exhausted from the harsh blows of the world, he ultimately has absolutely no choice but to desperately run to the 'Refuge' (Shelter) of that God alone.
            He is our 'Suhrit'; worldly friends love strictly for selfish motives, but God is the absolute only 'Friend' who deeply, unconditionally loves us relentlessly despite our millions of terrible mistakes.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 97,
        sanskrit = "नित्यो नित्यानां चेतनश्चेतनानामेको बहूनां यो विदधाति कामान् । तमात्मस्थं येऽनुपश्यन्ति धीरास्तेषां शान्तिः शाश्वती नेतरेषाम् ॥ ९७ ॥",
        hindi = """
            (कठोपनिषद 2.2.13): वह परमात्मा इस संसार की सभी अनित्य (नाशवान) वस्तुओं के बीच एकमात्र 'नित्य' (हमेशा रहने वाला / Eternal) सत्य है।
            वह सभी चेतन जीवों (आत्माओं) की परम 'चेतना' (Consciousness) है; और वह अकेला (एको) होकर भी अनगिनत (बहूनां) जीवों की सभी इच्छाओं (कामान्) को पूरा करता है।
            उस परमेश्वर को जो धीर (ज्ञानी और धैर्यवान) पुरुष अपनी ही आत्मा के भीतर (आत्मस्थं) विराजमान देखते और साक्षात् अनुभव (अनुपश्यन्ति) करते हैं।
            केवल और केवल उन्हीं ज्ञानी पुरुषों को 'शाश्वती शान्तिः' (कभी न मिटने वाली परमानंदमयी शांति) प्राप्त होती है, दूसरों (अज्ञानियों / इतरेषाम्) को कभी नहीं।
            यह श्लोक ध्यान और योग की सबसे बड़ी गारंटी (Guarantee card) है।
            दुनिया की हर चीज़—हमारा शरीर, रिश्ते, पैसे—सब कुछ 'अनित्य' (Temporary) है, जो आज है और कल मिट जाएगा; पर उस मिटने वाली दुनिया का जो बेस (Base) है, वह 'नित्य' ईश्वर है।
            हम जो भी मांगते हैं, वह हमें कोई बॉस (Boss) या सरकार नहीं देती; हमारी कर्मों की इच्छाएं (कामान्) पूरी करने वाला वह एक ही (एको) ईश्वर है।
            हम बाहर कितनी भी संपत्ति इकट्ठी कर लें, मन की शांति पैसे से या दुनिया में भागने से नहीं खरीदी जा सकती।
            'शाश्वत शांति' (Permanent Peace) केवल तब मिलती है जब इंसान अपनी आँखें बंद करके भगवान को कहीं आसमान में नहीं, बल्कि 'अपने ही अंदर' (आत्मस्थं) महसूस करता है।
            जब तक इंसान बाहर (इतरेषाम्) सुख खोजेगा, वह अशांत रहेगा; जब वह आत्मा से जुड़ता है, तो वह हमेशा के लिए परम शांत हो जाता है।
        """.trimIndent(),
        english = """
            (Katha Upanishad 2.2.13): That Supreme Lord is the one and absolute only 'Eternal' (Nitya) Truth solidly existing amidst all these highly transient, perishable things of this world.
            He is the supreme 'Consciousness' (Chetana) of absolutely all conscious living souls; and though He is strictly One (Eko), He flawlessly fulfills the endless desires (Kaman) of countless, multiple beings (Bahunam).
            Those exceptionally wise and highly patient men (Dhira) who directly perceive and vividly experience (Anupashyanti) that Lord as reigning supremely right within their very own souls (Atmastham).
            Exclusively and strictly only to those wise ones belongs 'Shashvati Shantih' (eternal, everlasting, never-ending absolute peace), and absolutely never, ever to the ignorant others (Itaresham).
            This phenomenal verse is the absolute greatest, ironclad Guarantee Card of deep meditation and Yoga.
            Absolutely everything in the world—our fragile body, relationships, money—is strictly 'Temporary' (Anitya), here today and gone tomorrow; but the ultimate, solid Base of this perishable world is that 'Eternal' God.
            Whatever we actively demand is absolutely not given by a mortal boss or government; it is that one single (Eko) God alone who flawlessly dispenses the fruits of all our desires (Kaman).
            No matter how much massive wealth we aggressively accumulate externally, peace of mind can absolutely never be bought with money or by running wildly in the world.
            'Permanent Peace' is attained exclusively and strictly only when a human closes his eyes and profoundly feels God not in some distant sky, but exactly 'right inside himself' (Atmastham).
            As long as a person blindly searches for joy on the outside (Itaresham), he will remain perpetually restless; the exact split-second he connects to the Soul, he becomes perfectly, eternally peaceful forever.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 98,
        sanskrit = "ज्ञात्वा देवं सर्वपाशापहानिः क्षीणैः क्लेशैर्जन्ममृत्युप्रहाणिः । तस्याभिध्यानात्तृतीयं देहभेदे विश्वैश्वर्यं केवल आप्तकामः ॥ ९८ ॥",
        hindi = """
            (श्वेताश्वतर 1.11): उस परम देव (परमात्मा) को यथार्थ रूप में जान लेने पर (ज्ञात्वा), मनुष्य के सभी प्रकार के पाश (अज्ञान, मोह, और कर्म के बंधन) पूरी तरह से कट कर गिर जाते हैं (सर्वपाशापहानिः)।
            अविद्या आदि सभी क्लेशों (दुखों) के पूरी तरह क्षीण (नष्ट) हो जाने पर, उस साधक का जन्म और मृत्यु का भयंकर चक्र हमेशा के लिए छूट (प्रहाणिः) जाता है।
            उस परमात्मा के निरंतर ध्यान (अभिध्यानात्) से, इस भौतिक शरीर के छूटने (मृत्यु / देहभेदे) के बाद एक तीसरी (जाग्रत-स्वप्न-सुषुप्ति से परे) परम अवस्था प्राप्त होती है।
            वह अवस्था 'विश्वैश्वर्य' (संपूर्ण ईश्वरीय ऐश्वर्य और अद्वैत) की है, जहाँ वह पूरी तरह 'केवल' (पूर्ण रूप से अकेला/मुक्त) और 'आप्तकाम' (जिसकी सभी इच्छाएं पूरी हो चुकी हों) हो जाता है।
            बंधन कोई लोहे की जंजीरें नहीं हैं; हमारा गुस्सा, हमारा लालच और हमारा घमंड (पाश) ही असली बंधन हैं जो ज्ञान की तलवार से ही कटते हैं।
            क्लेश (Kleshas) ही हमारे बार-बार जन्म लेने का असली कारण हैं; जब ध्यान की आग में वे क्लेश जल जाते हैं, तो धरती पर दोबारा वापसी नहीं होती।
            यह श्लोक योग और वेदान्त का सर्वोच्च परिणाम (Ultimate Result) बता रहा है—मरने के बाद स्वर्ग नहीं, साक्षात् ईश्वर का पूर्ण ऐश्वर्य (विश्वैश्वर्य) पा लेना।
            'केवल' (Kaivalya) का अर्थ है कि अब वह किसी भी 'दूसरे' (Second element) पर निर्भर नहीं है, वह पूर्ण रूप से आज़ाद है।
            और 'आप्तकाम' वह महापुरुष है जिसे अब इस पूरे ब्रह्मांड में कुछ भी पाना शेष नहीं रहा, क्योंकि वह स्वयं ही पूरा का पूरा ब्रह्मांड बन चुका है।
            यही ध्यानबिंदु उपनिषद का सबसे महान और अंतिम पुरस्कार (Trophy) है।
        """.trimIndent(),
        english = """
            (Shvetashvatara 1.11): By truly and flawlessly knowing and realizing that Supreme Deity (Jnatva), absolutely all the fetters (the tight bonds of ignorance, delusion, and karma) of the human completely drop away and are destroyed (Sarvapashapahanih).
            With the total, absolute destruction and decay of all afflictions and miseries like thick ignorance (Kshinaih kleshaih), the terrifying, endless cycle of birth and death ceases completely forever (Prahani).
            Strictly through continuous, profoundly deep meditation on Him (Abhidhyanat), exactly after the complete shedding of this gross physical body (death / Dehabhede), a third supreme state (entirely beyond waking-dreaming-sleep) is successfully attained.
            That ultimate state is of 'Vishvaishvaryam' (universal, absolute divine lordship and pure non-duality), where he flawlessly becomes 'Kevala' (absolutely alone, non-dual, and isolated/free) and 'Aptakamah' (one whose all possible desires are perfectly fulfilled forever).
            Bonds are absolutely not physical iron chains; our blazing anger, our toxic greed, and our blind arrogance (Pasha) are the actual, real bonds that are violently cut strictly by the sharp sword of Wisdom alone.
            Afflictions (Kleshas) are undeniably the absolute real root reason for our repeated rebirths; when those kleshas are brutally burnt to ashes in the intense fire of meditation, there is absolutely zero return back to this earth.
            This phenomenal verse explicitly presents the absolute highest, ultimate Result of Yoga and Vedanta—not merely going to cheap heaven after death, but seamlessly attaining God's complete, absolute, and full cosmic glory (Vishvaishvarya).
            'Kevala' (Kaivalya) profoundly means he is now entirely completely independent and relies absolutely on zero 'Second Element' whatsoever; he is 100% flawlessly Free.
            And an 'Aptakama' is that magnificent sage who has absolutely nothing left to attain in the entire universe anymore, purely because he himself has flawlessly and literally become the entire universe.
            This is undeniably the absolute greatest, ultimate Trophy and final grand prize of the Dhyanabindu Upanishad.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 99,
        sanskrit = "स यो ह वै तत् परमं ब्रह्म वेद ब्रह्मैव भवति नास्याब्रह्मवित् कुले भवति । तरति शोकं तरति पाप्मानं गुहाग्रन्थिभ्यो विमुक्तोऽमृतो भवति ॥ ९९ ॥",
        hindi = """
            (मुण्डक उपनिषद 3.2.9 का साक्षात् प्रमाण): जो कोई भी भाग्यशाली मुमुक्षु उस 'परम ब्रह्म' को यथार्थ रूप में 'जान' (वेद) लेता है, वह निश्चित रूप से साक्षात् 'ब्रह्म ही हो जाता है' (ब्रह्मैव भवति)।
            (इतना ही नहीं), उस महाज्ञानी पुरुष के कुल (वंश / Family) में फिर कभी कोई ऐसा व्यक्ति जन्म नहीं लेता जो ब्रह्म को न जानने वाला (अब्रह्मवित्) हो (यानी उसका पूरा कुल पवित्र हो जाता है)।
            वह ज्ञानी पुरुष संसार के सभी प्रकार के 'शोकों' (दुखों/Tears) को पूरी तरह पार कर जाता है (तरति शोकं), और वह सभी प्रकार के 'पापों' (Sins) के सागर को भी हमेशा के लिए पार कर जाता है (तरति पाप्मानं)।
            वह अपने हृदय की गुफा (गुहा) में लगी हुई अज्ञान की सभी 'गाँठों' (ग्रंथियों / Knots of Ego) से पूरी तरह मुक्त (विमुक्तो) होकर, साक्षात् 'अमर' (अमृतो) हो जाता है।
            यह वेदान्त का सबसे प्रसिद्ध और सबसे शक्तिशाली महावाक्य है: "ब्रह्मविद् ब्रह्मैव भवति" (The knower of Brahman becomes Brahman).
            अध्यात्म में 'जानने' का मतलब केवल 'इन्फॉर्मेशन' (Information) नहीं है। अगर आप भगवान को 'जान' गए, तो आप इंसान नहीं बचे, आप खुद भगवान बन गए!
            जैसे एक लोहे का टुकड़ा जब पारस पत्थर को 'छू' (जान) लेता है, तो वह लोहा नहीं रहता, वह खुद सोना बन जाता है।
            आत्मज्ञान इतना शक्तिशाली है कि वह केवल आपके दिमाग को ही नहीं, बल्कि आपके खून (DNA) और आपके आने वाले पूरे वंश (कुल) को भी महान और पवित्र कर देता है।
            हृदय की गाँठें (गुहाग्रन्थि) वे छुपी हुई वासनाएं और अज्ञान हैं जो हमें शरीर से बाँधे रखती हैं; जब ध्यान की कैंची से वे गाँठें कट जाती हैं, तो इंसान 'अमर' हो जाता है।
            अब न कोई रोना (शोक) बाकी है, न कोई पछतावा (पाप); वह एक असीम और अनंत प्रकाश बनकर ब्रह्मांड में विलीन हो जाता है।
        """.trimIndent(),
        english = """
            (Direct proof from Mundaka Upanishad 3.2.9): Whosoever fortunate, sincere seeker truly 'Knows' and directly realizes (Veda) that 'Supreme Brahman', he undoubtedly, absolutely, and literally 'becomes exactly Brahman Himself' (Brahmaiva bhavati).
            (Not only that), in the entire future lineage (Kula / Family) of that supremely wise sage, absolutely no one is ever born who is completely ignorant of Brahman (Abrahmavit) (meaning, his entire bloodline is instantly purified).
            That enlightened sage flawlessly and permanently crosses entirely beyond (Tarati) all types of worldly 'Sorrows' (Shokam/Tears), and he successfully crosses completely beyond the massive, terrifying ocean of all 'Sins' (Papmanam) forever.
            Being completely and perfectly liberated (Vimukto) from all the tight 'Knots' (Granthibhyo / Knots of Ego and ignorance) deeply hidden in the cave (Guha) of his heart, he undeniably becomes completely 'Immortal' (Amrito bhavati).
            This is Advaita Vedanta's absolute most famous, iconic, and tremendously powerful Mahavakya (Grand Declaration): "Brahmavid brahmaiva bhavati" (The knower of Brahman becomes Brahman).
            In deep spirituality, 'Knowing' absolutely does not mean merely acquiring cheap textbook 'Information'. If you truly 'know' God, you do not remain a human, you seamlessly transform into God Himself!
            Exactly just as when a piece of cheap iron 'touches' (knows) the legendary Philosopher's Stone, it absolutely does not remain iron; it instantly and magically transforms entirely into pure solid gold itself.
            Self-knowledge is so terrifyingly powerful that it does not merely purify your brain, it flawlessly purifies your very blood (DNA) and elevates your entire future lineage to absolute greatness.
            The knots of the heart (Guhagranthi) are those deeply hidden, toxic lusts and dark ignorance that forcefully tie us to the body; when those heavy knots are violently cut by the sharp scissors of meditation, the human instantly becomes 'Immortal'.
            Now absolutely no crying (Sorrow) remains left, nor any agonizing regret (Sin); he seamlessly transforms into a boundless, infinite, brilliant Light and seamlessly dissolves completely into the cosmos.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 100,
        sanskrit = "ॐ पूर्णमदः पूर्णमिदं पूर्णात्पूर्णमुदच्यते । पूर्णस्य पूर्णमादाय पूर्णमेवावशिष्यते ॥ ॐ शान्तिः शान्तिः शान्तिः ॥ १०० ॥",
        hindi = """
            (उपनिषद का परम शांति मंत्र और अंतिम उपसंहार): 'ॐ वह परब्रह्म' (अदः) अपने-आप में सर्वथा पूर्ण (Complete / Infinite) है। 'यह दिखाई देने वाला संसार' (इदं) भी उस ब्रह्म से उत्पन्न होने के कारण पूरी तरह से पूर्ण है।
            उस 'पूर्ण' (परमात्मा) में से ही यह 'पूर्ण' (संसार) उत्पन्न (उदच्यते / Manifests) हुआ है।
            यदि उस परम 'पूर्ण' (परमात्मा) में से इस 'पूर्ण' (संसार) को पूरी तरह निकाल (आदाय / Subtract) भी लिया जाए।
            तो भी पीछे जो शेष (अवशिष्यते) बचता है, वह केवल 'पूर्ण' (परमात्मा) ही है (उसमें कोई कमी नहीं आती)।
            ॐ शांतिः शांतिः शांतिः! (हमारे शरीर में शांति हो, हमारे मन में शांति हो, और हमारी आत्मा में परम शांति हो)। इस प्रकार यह महान 'ध्यानबिंदु उपनिषद' पूर्ण रूप से संपन्न होता है।
            यह मंत्र (ईशावास्य उपनिषद से) भारतीय गणित (Mathematics) और वेदान्त का सबसे बड़ा 'इन्फिनिटी' (Infinity / ∞) का नियम है।
            भगवान एक असीम (Infinite) समंदर है। अगर आप समंदर (पूर्ण) में से एक बाल्टी पानी (यह दुनिया) निकाल लें, तो क्या समंदर कम हो जाएगा? बिल्कुल नहीं, वह 'पूर्ण' ही रहेगा।
            यह दुनिया भगवान से ही बनी है, इसलिए यह भी अपने-आप में परफेक्ट (Perfect) है। पर भगवान दुनिया बनने के बाद भी रत्ती भर भी कम (Exhaust) नहीं हुआ है।
            हम इंसान भी उसी 'पूर्ण' का हिस्सा हैं; जब हम यह जान लेते हैं कि "मैं भी पूर्ण हूँ (I am complete)", तो दुनिया से कुछ भी माँगने का सारा 'भिखारीपन' (Begging mentality) हमेशा के लिए खत्म हो जाता है।
            यहीं पर योग, ध्यान, नाद, और वेदान्त की यह सबसे महान और रहस्यमयी यात्रा पूरी तरह से अपनी परम सफलता (Absolute Success) को प्राप्त होती है।
        """.trimIndent(),
        english = """
            (The Supreme Peace Mantra and ultimate conclusion of the Upanishad): 'OM That Supreme Brahman' (Adah) is absolutely, infinitely 'Full' (Purnam / Complete / Infinite). 'This entire visible created world' (Idam) is also entirely 'Full' precisely because it is born directly from that Brahman.
            It is exclusively from that infinite 'Fullness' (God) that this colossal 'Fullness' (Universe) flawlessly emerges and manifests (Udachyate).
            Even if this entire massive 'Fullness' (the created Universe) is completely taken away or completely extracted (Adaya / Subtracted) directly from that supreme 'Fullness' (God).
            Absolutely whatever permanently remains left over behind (Avashishyate) is still undeniably and strictly that absolute infinite 'Fullness' (God) alone (He absolutely never diminishes or decreases).
            OM Peace, Peace, Peace! (May there be absolute peace in our body, deep peace in our restless mind, and supreme eternal peace in our Soul). Thus, this magnificent 'Dhyanabindu Upanishad' flawlessly achieves perfect, absolute completion.
            This spectacular mantra (from Isha Upanishad) represents the absolute greatest, ultimate law of 'Infinity' (∞) in both ancient Indian Mathematics and supreme Vedanta.
            God is a completely boundless, infinite Ocean. If you successfully scoop out an entire bucket of water (this physical world) from that infinite Ocean (Fullness), does the ocean decrease at all? Absolutely not, it flawlessly remains 'Full'.
            This massive world is manufactured strictly from God, hence it is also mathematically and perfectly 'Complete' (Perfect) in itself. Yet God absolutely does not diminish or exhaust even a single millimeter after creating it.
            We humans are also a direct, flawless fraction of that exact 'Fullness'; when we profoundly realize that "I too am entirely Complete," absolutely all the pathetic 'Begging Mentality' to desperately ask the world for happiness permanently ends forever.
            Right here, this absolute greatest, profoundly mystical, and supreme journey of Yoga, deep Meditation, Nada, and Advaita Vedanta flawlessly achieves its absolute, ultimate, and unconditional Success.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 101,
        sanskrit = "ज्ञानामृतेन तृप्तस्य कृतकृत्यस्य योगिनः । नैवास्ति किञ्चित्कर्तव्यमस्ति चेन्न स तत्त्ववित् ॥ १०१ ॥",
        hindi = """
            (ज्ञानी के लक्षण): जिस योगी ने ज्ञान रूपी अमृत को पीकर पूर्ण तृप्ति (संतुष्टि) प्राप्त कर ली है।
            और जो 'कृतकृत्य' (जिसने जीवन में जो कुछ भी करने योग्य था, वह सब कर लिया है) हो चुका है।
            उस महापुरुष के लिए इस संसार में कोई भी कर्म या कर्तव्य (Duty) करना शेष (बाकी) नहीं रहता।
            यदि उसे लगता है कि उसे अभी भी कुछ करना बाकी है, तो वह वास्तव में तत्त्वज्ञानी (सत्य को जानने वाला) नहीं है।
            यह श्लोक कर्म और ज्ञान के बीच की अंतिम सीमा रेखा (Finish line) खींचता है।
            जब तक इंसान अज्ञानी है, उसे दुनिया और समाज के नियमों (Duties) का पालन करना ही पड़ता है।
            परन्तु जब वह ज्ञान के महासागर में डूब जाता है, तो उसके लिए कोई सांसारिक नियम लागू नहीं होता।
            जैसे स्नातक (Graduation) की डिग्री मिलने के बाद स्कूल जाने की जरूरत नहीं रहती।
            उसी तरह ब्रह्मानंद का अमृत पीने के बाद, योगी को किसी पूजा, पाठ या सामाजिक कर्तव्य की कोई जरूरत नहीं बचती।
            वह पूर्ण रूप से आज़ाद है; और अगर कोई साधु बनकर भी कर्मों के बोझ से दबा है, तो वह सच्चा ज्ञानी नहीं है।
        """.trimIndent(),
        english = """
            (Characteristics of the Enlightened): That supreme Yogi who has become completely and absolutely satisfied (Tripta) by drinking the magnificent nectar of Wisdom.
            And who has flawlessly become 'Kritakritya' (one who has successfully accomplished absolutely everything that needed to be done in life).
            For that monumental, great soul, absolutely no worldly action or binding duty (Kartavya) whatsoever remains left to be performed in this world.
            If he still falsely feels that he has some mandatory duty left to do, then he is absolutely not a true knower of Truth (Tattvavit).
            This phenomenal verse definitively draws the absolute final finish line strictly between worldly karma and supreme wisdom.
            As long as a human remains ignorant, he is strictly forced to blindly follow the rigid rules and binding duties of society.
            But exactly when he flawlessly drowns in the vast ocean of wisdom, absolutely no worldly rule or law applies to him anymore.
            Just as after successfully receiving a Graduation degree, there is absolutely zero need to forcefully attend primary school again.
            Similarly, after drinking the ultimate nectar of cosmic bliss, the Yogi requires absolutely no rituals, worship, or social duties.
            He is 100% flawlessly free; and if someone claiming to be a monk still feels crushed by duties, he is absolutely not a true sage.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 102,
        sanskrit = "आत्मानं सततं जानन् कालं नय महामते । प्रारब्धमखिलं भुञ्जन् नोद्वेगं कर्तुमर्हसि ॥ १०२ ॥",
        hindi = """
            हे महाबुद्धिमान (महामते) साधक! तुम निरंतर (सततं) केवल अपनी शुद्ध 'आत्मा' को ही जानते हुए अपना समय (काल) व्यतीत करो।
            और अपने शरीर पर आने वाले संपूर्ण 'प्रारब्ध' (पिछले जन्मों के बचे हुए कर्मफलों) को केवल एक शांत साक्षी (Witness) बनकर भोगते (भुञ्जन्) रहो।
            तुम्हें उन कर्मफलों के कारण अपने मन में कोई भी उद्वेग (Anxiety / बेचैनी या घबराहट) बिल्कुल नहीं करना चाहिए (नोद्वेगं कर्तुमर्हसि)।
            यह श्लोक 'जीवन्मुक्त' (जीते-जी मुक्त) योगी के जीवन जीने का तरीका (Lifestyle) स्पष्ट रूप से समझा रहा है।
            ज्ञान होने के बाद भी योगी का शरीर कुछ समय तक धरती पर रहता है, जब तक कि उस शरीर की बैटरी (प्रारब्ध) खत्म न हो जाए।
            उस बचे हुए समय (Time) को काटने का सबसे अच्छा तरीका क्या है? केवल आत्मा के आनंद में मस्त रहना।
            अगर शरीर पर कोई बीमारी आए या कोई अपमान करे (जो कि प्रारब्ध है), तो योगी को रोना या परेशान (उद्वेग) नहीं होना चाहिए।
            उसे यह जानना चाहिए कि यह सब कुछ केवल इस मिट्टी के शरीर के साथ हो रहा है, मेरी आत्मा के साथ नहीं।
            जब आप सिनेमाघर में फिल्म देखते हैं, तो परदे पर हीरो को चोट लगने से आप दर्द से नहीं तड़पते, क्योंकि आप जानते हैं कि वह आप नहीं हैं।
            उसी तरह, योगी अपने ही शरीर को एक फिल्म की तरह देखता है और पूरी तरह से बेचैनी-मुक्त (Anxiety-free) रहता है।
        """.trimIndent(),
        english = """
            O highly intelligent and wise seeker (Mahamate)! You must spend all your remaining time (Kala) continuously and exclusively (Satatam) knowing and realizing only your pure 'Soul'.
            And you must continue to flawlessly experience and exhaust (Bhunjan) your entire 'Prarabdha' (the fading momentum of past karmic fruits) remaining purely as a silent, detached Witness.
            You absolutely must not allow any kind of severe 'Udvega' (anxiety, panic, or restless agitation) to arise in your mind due to those karmic fruits.
            This magnificent verse exceptionally clearly explains the exact daily Lifestyle of a 'Jivanmukta' (one who is completely liberated while alive).
            Even after attaining supreme enlightenment, the Yogi's physical body remains on earth precisely until its residual battery (Prarabdha) completely runs out.
            What exactly is the absolute best way to spend that remaining leftover time? By remaining intoxicated exclusively in the infinite bliss of the Soul.
            If a terrible disease strikes the body or someone flings a harsh insult (which is merely Prarabdha), the Yogi must absolutely never cry or panic (Udvega).
            He must flawlessly know that absolutely all of this is happening strictly to this physical puppet of dirt, absolutely never to his immortal Soul.
            When you watch a Movie in a theater, you absolutely do not writhe in pain when the hero is attacked, because you know flawlessly that it isn't you.
            In the exact same way, the master Yogi watches his very own physical body exactly like a movie and remains 100% flawlessly Anxiety-Free.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 103,
        sanskrit = "अन्तर्बहिस्तत्पूर्णं सर्वव्यापि यदाकाशम् । तद्वत्पूर्णमनाद्यन्तमखण्डं ब्रह्म तत्त्वतः ॥ १०३ ॥",
        hindi = """
            जिस प्रकार यह भौतिक आकाश (Space) किसी भी बर्तन या घर के भीतर (अन्तर्) और बाहर (बहिः) पूरी तरह से भरा (पूर्णं) हुआ है।
            और वह आकाश सभी दिशाओं में बिना किसी रुकावट के सर्वव्यापी (हर जगह फैला हुआ) है।
            ठीक उसी प्रकार (तद्वत्), वह परम ब्रह्म भी अंदर और बाहर पूरी तरह से पूर्ण (Complete) और सर्वव्यापी है।
            वास्तविक तत्त्व (सत्य) की दृष्टि से वह ब्रह्म अनादि (जिसकी कोई शुरुआत न हो), अनंत (जिसका कोई अंत न हो) और अखंड (जिसके टुकड़े न किए जा सकें) है।
            यहाँ फिर से 'आकाश' (Space) का अत्यंत सटीक और वैज्ञानिक उदाहरण (Scientific metaphor) दिया गया है।
            क्या आप कमरे के अंदर के आकाश और कमरे के बाहर के आकाश को कैंची से काट सकते हैं? बिल्कुल नहीं।
            क्या आप आकाश को गंदा कर सकते हैं या उसे जला सकते हैं? नहीं। आकाश हमेशा अखंड और पूर्ण रहता है।
            ईश्वर (ब्रह्म) बिल्कुल उसी आकाश की तरह है; वह हमारे शरीर के अंदर भी है और पूरे ब्रह्मांड में भी।
            हम उसे टुकड़ों में बाँट कर यह नहीं कह सकते कि "भगवान केवल मंदिर में है" या "भगवान केवल मस्जिद में है।"
            वह अखंड है; उसे सीमाओं (Boundaries) में बाँधना ही सबसे बड़ा अज्ञान है, और उसे सर्वव्यापी (Omnipresent) रूप में जानना ही असली मोक्ष है।
        """.trimIndent(),
        english = """
            Exactly just as this physical space (Akasha) is completely, fully, and perfectly filled (Purnam) both inside (Antar) and strictly outside (Bahis) any pot or physical house.
            And that boundless space is effortlessly all-pervading (Sarvayapi) across absolutely all directions entirely without any physical obstruction whatsoever.
            In the precise same flawless manner (Tadvat), that Supreme Brahman is also perfectly Complete (Full) and totally omnipresent both inside and outside.
            From the perspective of the absolute real Truth (Tattvatah), that Brahman is Anadi (having absolutely no beginning), Ananta (having absolutely no end), and Akhanda (entirely indivisible).
            Here once again, the highly accurate and absolutely brilliant Scientific Metaphor of 'Space' (Akasha) is profoundly utilized.
            Can you possibly use sharp scissors to cut the space inside a room completely apart from the space outside? Absolutely not.
            Can you possibly make space physically dirty or burn it with blazing fire? No. Space forever remains completely unbroken and perfectly full.
            God (Brahman) is exactly, identically like that boundless space; He is flawlessly present right inside our physical body and throughout the entire infinite cosmos simultaneously.
            We absolutely cannot divide Him into petty pieces and falsely claim "God is strictly only in the temple" or "God is strictly only in the mosque."
            He is perfectly Akhanda (indivisible); attempting to confine Him within physical boundaries is the greatest ignorance, and knowing Him as flawlessly Omnipresent is true Moksha.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 104,
        sanskrit = "यतो वाचो निवर्तन्ते अप्राप्य मनसा सह । आनन्दं ब्रह्मणो विद्वान् न बिभेति कदाचन ॥ १०४ ॥",
        hindi = """
            (तैत्तिरीय उपनिषद 2.4.1): वह परब्रह्म ऐसा है जहाँ तक पहुँचने में असफल होकर (अप्राप्य), हमारी वाणी (वाचो / शब्द) और हमारा मन (मनसा) दोनों ही हार मानकर वापस लौट आते हैं (निवर्तन्ते)।
            (अर्थात ईश्वर को न तो शब्दों से समझाया जा सकता है और न ही दिमाग से सोचा जा सकता है)।
            उस परब्रह्म के असीम और अवर्णनीय 'आनंद' (ब्रह्मानंद) को जो ज्ञानी पुरुष (विद्वान्) साक्षात् अनुभव कर लेता है।
            वह ज्ञानी इस संसार में या मृत्यु के बाद कभी भी, किसी भी चीज़ से बिल्कुल नहीं डरता (न बिभेति कदाचन)।
            यह श्लोक वेदान्त का एक अत्यंत शक्तिशाली और प्रसिद्ध महावाक्य है जो ईश्वर की असीमता (Infinity) को दर्शाता है।
            इंसान का दिमाग केवल उन्हीं चीजों को 'सोच' सकता है जिनकी कोई सीमा (Limit) हो या जिन्हें उसने देखा हो।
            पर भगवान असीम (Limitless) है; इसलिए जब दिमाग भगवान को सोचने जाता है, तो वह क्रैश (Crash) हो जाता है और हार मान लेता है।
            भाषा (Language) बहुत छोटी है; हम 'मीठा' शब्द बोल सकते हैं, पर चीनी की मिठास का अनुभव शब्दों में नहीं डाल सकते।
            उसी तरह, ब्रह्मानंद का वह सुख केवल 'पीकर' ही जाना जा सकता है; और जिसने उसे एक बार पी लिया, उसका सारा 'डर' (Fear) हमेशा के लिए खत्म हो जाता है।
            डर हमेशा 'अज्ञान' से पैदा होता है; पूर्ण ज्ञान में केवल पूर्ण निर्भयता (Fearlessness) और आनंद ही निवास करता है।
        """.trimIndent(),
        english = """
            (Taittiriya Upanishad 2.4.1): That Supreme Brahman is exactly such that, completely failing to reach or grasp Him (Aprapya), both our speech (Vacho / words) and our mind (Manasa) accept utter defeat and return completely empty-handed (Nivartante).
            (Meaning, God can absolutely never be adequately explained by limited words, nor can He ever be comprehended by the human brain).
            That profoundly wise sage (Vidvan) who directly experiences and fully realizes that infinite, indescribable 'Bliss' (Brahmananda) of that Supreme Brahman.
            That enlightened sage absolutely never, ever fears (Na bibheti kadachana) anything whatsoever, either in this world or after physical death.
            This magnificent verse is an exceptionally powerful and famous Mahavakya of Vedanta that perfectly highlights the absolute Infinity of God.
            The human brain can strictly only 'think' of those specific objects that possess a distinct Limit or which it has previously seen physically.
            But God is entirely Limitless; therefore, when the petty brain aggressively attempts to 'think' of God, it instantly Crashes and accepts total defeat.
            Human Language is highly limited; we can say the word 'sweet', but we simply cannot pack the actual, real experience of sugar's sweetness into mere words.
            Similarly, the supreme joy of Brahmananda can be known strictly only by 'Drinking' it; and he who drinks it even once has all his 'Fear' permanently annihilated forever.
            Fear is perpetually born strictly out of 'Ignorance'; within absolute perfect wisdom, exclusively absolute Fearlessness and infinite bliss permanently reside.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 105,
        sanskrit = "तिलेषु तैलं दधनीव सर्पिरापः स्रोतःस्वरणीषु चाग्निः । एवमात्माऽत्मनि गृह्यतेऽसौ सत्येनैनं तपसा योऽनुपश्यति ॥ १०५ ॥",
        hindi = """
            (श्वेताश्वतर उपनिषद 1.15): जिस प्रकार तिलों (तिलेषु) के अंदर तेल छिपा होता है, और दही (दधनि) के अंदर घी (सर्पि) छिपा रहता है।
            जिस प्रकार सूखी नदी के स्रोतों (स्रोतः) के नीचे पानी (आपः) छिपा होता है, और जिस प्रकार अरणियों (सूखी लकड़ियों) के अंदर आग (अग्नि) छिपी होती है।
            ठीक उसी प्रकार (एवम्), यह परम 'आत्मा' भी हमारे अपने ही शरीर और मन (आत्मनि) के भीतर अत्यंत गहराई से छिपी हुई है।
            जो साधक पूर्ण सत्य (सत्येन) और कठोर ध्यान रूपी तपस्या (तपसा) के द्वारा खोज करता है, वही उस आत्मा को अपने भीतर पकड़ (गृह्यते) और साक्षात् देख (अनुपश्यति) पाता है।
            यह श्लोक 'प्रयास और साधन' (Effort and Tool) की आवश्यकता पर बहुत ही सुंदर और तार्किक (Logical) जोर देता है।
            तिल में तेल है, पर तिल को केवल देखने से तेल नहीं निकलता; उसे कोल्हू में पीसना (Crush) पड़ता है।
            दही में घी है, पर उसे मथना (Churn) पड़ता है; लकड़ी में आग है, पर उसे बहुत जोर से रगड़ना (Rub) पड़ता है।
            उसी तरह, यह सच है कि भगवान हम सबके अंदर मौजूद है; पर केवल यह बात जान लेने से भगवान के दर्शन नहीं हो जाते।
            उस भगवान को बाहर निकालने के लिए हमें 'सत्य' (ईमानदारी) और 'तपस्या' (ध्यान की भयंकर रगड़/Friction) का इस्तेमाल करना ही पड़ेगा।
            बिना ध्यान की मेहनत के, अंदर का वह भगवान हमेशा एक रहस्य (Secret) ही बना रहेगा।
        """.trimIndent(),
        english = """
            (Shvetashvatara Upanishad 1.15): Exactly just as oil is secretly hidden entirely within sesame seeds (Tileshu), and rich ghee (Sarpi) remains deeply concealed directly within curd (Dadhani).
            Just as pure water (Apah) remains hidden deep underground beneath dry riverbeds (Srotah), and exactly just as blazing fire (Agni) is perfectly concealed completely within dry wooden sticks (Aranishu).
            In the exact same flawless manner (Evam), this supreme 'Soul' (Atman) is also exceptionally deeply hidden strictly within our very own physical body and mind (Atmani).
            That sincere seeker who aggressively searches strictly through absolute Truth (Satyena) and the severe penance (Tapasa) of deep meditation, he alone successfully captures (Grihyate) and directly perceives (Anupashyati) that Soul right within himself.
            This magnificent verse beautifully and highly logically emphasizes the absolute, strict necessity of intense 'Effort and proper Tools' in spirituality.
            Oil is definitely inside the sesame seed, but merely staring blankly at the seed yields absolutely zero oil; it absolutely must be aggressively Crushed in a heavy press.
            Ghee is inside the curd, but it must be rigorously Churned; fire is inside the wood, but it absolutely must be violently Rubbed together.
            Similarly, it is the absolute truth that God is perfectly present right inside all of us; but merely knowing this cheap textbook fact absolutely does not grant the direct vision of God.
            To successfully extract that God outside, we absolutely must relentlessly utilize absolute 'Truth' (honesty) and severe 'Tapasya' (the terrifying, intense Friction of deep meditation).
            Completely without the rigorous hard work of intense meditation, that inner God will permanently remain an undiscovered, locked Secret forever.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 106,
        sanskrit = "सर्वव्यापिनमात्मानं क्षीरे सर्पिरिवार्पितम् । आत्मविद्यातपोमूलं तद्ब्रह्मोपनिषत्परम् ॥ १०६ ॥",
        hindi = """
            (श्वेताश्वतर 1.16): वह परमात्मा इस संपूर्ण ब्रह्मांड में 'सर्वव्यापी' (हर जगह मौजूद) है, ठीक वैसे ही जैसे दूध (क्षीरे) के हर एक कण में घी (सर्पि) पूर्ण रूप से मौजूद (अर्पितम्) रहता है।
            उस परम आत्मा (ब्रह्म) को प्राप्त करने का एकमात्र मूल आधार (मूलं) केवल और केवल 'आत्मविद्या' (Self-knowledge / ज्ञान) और 'तप' (Meditation / ध्यान) ही है।
            वही परम तत्व साक्षात् 'परम ब्रह्म' है, जिसे इन महान उपनिषदों (ब्रह्मोपनिषत्परम्) के द्वारा अत्यंत गुप्त रूप से सिखाया गया है।
            यहाँ फिर से दूध और घी का अत्यंत प्रसिद्ध और वैज्ञानिक उदाहरण (Scientific metaphor) दोहराया गया है।
            दूध को आप जहाँ से भी पिएं, उसमें घी का अंश होता ही है; आप दूध के किसी एक हिस्से को दिखाकर यह नहीं कह सकते कि "घी केवल यहाँ है।"
            उसी प्रकार, भगवान 'सर्वव्यापी' (Omnipresent) है; वह मंदिर की मूर्ति में भी है, और सड़क के पत्थर में भी है। उसे किसी एक जगह पर कैद करना इंसान की सबसे बड़ी मूर्खता है।
            पर उस सर्वव्यापी भगवान को देखने के लिए दो चीजों की सबसे ज्यादा जरूरत है: 1. आत्मविद्या (सही थ्योरी / Right Theory) और 2. तप (सही प्रैक्टिकल / Right Practical)।
            बिना सही समझ के की गई तपस्या केवल शरीर को कष्ट देती है; और बिना तपस्या के पढ़ी गई विद्या केवल दिमागी घमंड बढ़ाती है।
            जब ज्ञान और ध्यान दोनों का भयंकर संगम होता है, तभी उपनिषदों का वह महान 'ब्रह्म' साक्षात् प्रकट होकर दर्शन देता है।
        """.trimIndent(),
        english = """
            (Shvetashvatara 1.16): That Supreme Lord is absolutely 'All-pervading' (Omnipresent) throughout this entire massive cosmos, exactly just as rich ghee (Sarpi) is completely and thoroughly present (Arpitam) in absolutely every single microscopic drop of pure milk (Kshire).
            The one and absolute only fundamental root base (Mulam) for successfully attaining that Supreme Soul (Brahman) is strictly and exclusively 'Atma-Vidya' (Self-knowledge) combined perfectly with 'Tapas' (Deep Meditation).
            That exact supreme principle is the direct 'Supreme Brahman' Himself, who is highly secretly and profoundly taught directly by these magnificent Upanishads (Brahmopanishatparam).
            Here again, the exceptionally famous and highly Scientific Metaphor of milk and ghee is powerfully reiterated for maximum clarity.
            From whichever part you drink the milk, the exact essence of ghee is unavoidably present in it; you absolutely cannot point to one tiny section of milk and falsely claim "Ghee is strictly only here."
            In the exact same manner, God is completely 'Omnipresent' (All-pervading); He is flawlessly in the temple idol, and He is equally in the ordinary stone on the street. Attempting to imprison Him in one single physical place is humanity's absolute greatest stupidity.
            But to successfully see that omnipresent God, exactly two things are desperately required: 1. Atma-Vidya (the exact Right Theory) and 2. Tapas (the intense Right Practical application).
            Severe penance performed completely without the right understanding merely tortures the physical body; and reading deep philosophy entirely without actual meditation merely massively inflates the intellectual ego.
            Only exactly when the terrifying, explosive confluence of both pure Wisdom and intense Meditation occurs, does that magnificent 'Brahman' of the Upanishads directly manifest and grant His supreme vision.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 107,
        sanskrit = "इदं रहस्यं परमं गुह्यं ज्ञेयं प्रयत्नतः । नाप्रशान्ताय दातव्यं नापुत्राय शिष्याय वा ॥ १०७ ॥",
        hindi = """
            (ज्ञान की गोपनीयता): उपनिषद का यह परम ज्ञान अत्यंत 'रहस्यमयी' (Secret) और सबसे अधिक 'गुह्य' (Hidden / गुप्त रखने योग्य) है, जिसे बहुत प्रयास (प्रयत्नतः) से जानना चाहिए।
            इस पवित्र ज्ञान को किसी भी ऐसे व्यक्ति को बिल्कुल नहीं देना चाहिए (न दातव्यं) जिसका मन अत्यंत चंचल और 'अशांत' (नाप्रशान्ताय) हो।
            यह महान विद्या केवल एक सच्चे, योग्य और शांत 'पुत्र' या अत्यंत समर्पित 'शिष्य' (शिष्याय वा) को ही प्रदान करनी चाहिए।
            प्राचीन काल में ज्ञान को इंटरनेट या किताबों में बाँटा नहीं जाता था; इसे अत्यंत गुप्त (Classified) रखा जाता था।
            क्यों? क्योंकि यह ज्ञान एक 'परमाणु बम' (Nuclear bomb) की तरह है; अगर यह गलत इंसान के हाथ लग जाए, तो वह इसका दुरुपयोग (Misuse) करेगा।
            अशांत और लालची इंसान (जिसका मन पैसों और वासनाओं में है) इस ज्ञान को सुनकर कहेगा: "अरे, जब मैं ही ब्रह्म हूँ, तो फिर पाप क्या और पुण्य क्या? मैं तो कुछ भी कर सकता हूँ!"
            अधूरा और गलत समझा गया अद्वैत ज्ञान इंसान को महा-पापी और अहंकारी बना सकता है।
            इसलिए गुरु लोग इस ज्ञान को केवल उसी 'पुत्र' (जो गुरु को पिता समान माने) या 'शिष्य' को देते थे, जिसने वर्षों तक सेवा और तपस्या करके अपने मन को 'प्रशांत' (पूरी तरह शांत) कर लिया हो।
            यह श्लोक गुरु-शिष्य परंपरा (Master-Disciple tradition) की सबसे बड़ी मर्यादा और क्वालिटी-कंट्रोल (Quality Control) को स्पष्ट करता है।
        """.trimIndent(),
        english = """
            (The Secrecy of Wisdom): This supreme knowledge of the Upanishad is exceptionally 'Secret' (Rahasya) and the absolute most 'Hidden' (Guhyam / highly classified), which must be known and acquired strictly through immense, agonizing effort (Prayatnatah).
            This profoundly sacred wisdom must absolutely never, under any circumstance, be given or taught (Na datavyam) to any person whose mind is highly restless, chaotic, and completely 'Unpeaceful' (Naprashantaya).
            This magnificent, ultimate science must be explicitly imparted exclusively only to a truly worthy, perfectly tranquil 'Son' or to an exceptionally dedicated and tested 'Disciple' (Shishyaya va).
            In ancient times, this supreme wisdom was absolutely not carelessly distributed on the internet or in cheap books; it was kept exceptionally highly Classified.
            Why exactly? Because this profound wisdom is exactly like a terrifying 'Nuclear Bomb'; if it falls into the wrong, dirty hands, the ignorant person will violently Misuse it.
            A highly restless, incredibly greedy person (whose mind is trapped in money and lust) will hear this wisdom and falsely conclude: "Oh! If I myself am Brahman, then what is sin and what is merit? I can do whatever evil I want!"
            Incomplete and severely misunderstood Advaita knowledge can easily transform an ordinary human into a colossal, arrogant sinner.
            Therefore, true Gurus imparted this extreme wisdom strictly only to that 'Son' (who views the Guru exactly as a father) or 'Disciple' who had perfectly 'Tranquilized' his mind through decades of severe service and brutal penance.
            This magnificent verse flawlessly clarifies the absolute highest boundary and incredibly strict Quality Control of the ancient Master-Disciple (Guru-Shishya) tradition.
        """.trimIndent()
    ),
    DhyanabinduShloka(
        id = 108,
        sanskrit = "य इदं पठते नित्यं स मुक्तो नात्र संशयः । स ब्रह्मलोकमाप्नोति ॐ शान्तिः शान्तिः शान्तिः ॥ १०८ ॥",
        hindi = """
            (फलश्रुति और समापन): जो भी साधक इस अत्यंत पवित्र 'ध्यानबिन्दु उपनिषद' का प्रतिदिन निरंतर (नित्यं) पाठ (पठते) करता है और इसके रहस्यों पर मनन करता है।
            वह साधक निश्चित रूप से सभी बंधनों से 'मुक्त' (मोक्ष प्राप्त) हो जाता है, इसमें किसी भी प्रकार का कोई संशय या शक (नात्र संशयः) बिल्कुल भी नहीं है।
            वह अपने इस भौतिक शरीर को त्यागने के बाद उस परम और शाश्वत 'ब्रह्मलोक' (परमात्मा के सर्वोच्च पद) को हमेशा के लिए प्राप्त (आप्नोति) कर लेता है।
            ॐ शांतिः शांतिः शांतिः! (आध्यात्मिक, आधिभौतिक और आधिदैविक—तीनों प्रकार के ताप और दुख हमेशा के लिए शांत हो जाएं)।
            यह श्लोक इस महान उपनिषद की 'फलश्रुति' (Benefits of reading) है, जो साधक को एक 100% फुलप्रूफ गारंटी (Guarantee) दे रहा है।
            'पाठ करने' (पठते) का मतलब केवल तोते की तरह रटना नहीं है; पाठ करने का असली मतलब है इसके एक-एक शब्द को समझना और उसे ध्यान (Meditation) में उतारना (Apply करना)।
            जो व्यक्ति रोज खुद को याद दिलाता है कि "मैं शरीर नहीं हूँ, मैं ब्रह्म हूँ, मेरी साँसें ॐ का जाप कर रही हैं"—उसका अज्ञान टिक ही नहीं सकता।
            ब्रह्मलोक कोई ऐसी जगह नहीं है जहाँ सोने के महल हों; ब्रह्मलोक का अर्थ है 'ब्रह्म का लोक' (Realm of Pure Consciousness), जहाँ जाने के बाद इंसान फिर कभी लौटकर इस दुखों भरी दुनिया में नहीं आता।
            यहीं पर योग, नाद, कुण्डलिनी और अद्वैत वेदान्त का यह सबसे महान और शक्तिशाली खजाना 'ध्यानबिन्दु उपनिषद' पूर्ण रूप से और अत्यंत शुभता के साथ संपन्न (Complete) होता है।
        """.trimIndent(),
        english = """
            (Phala Shruti and Final Conclusion): Whosoever sincere seeker continuously and daily (Nityam) reads, chants (Pathate), and profoundly contemplates the deep secrets of this exceptionally sacred 'Dhyanabindu Upanishad'.
            That specific seeker undoubtedly and certainly becomes fully 'Liberated' (attains absolute Moksha) from all karmic bonds; there is absolutely zero doubt or hesitation whatsoever in this ultimate fact (Natra samshayah).
            After finally shedding this gross physical body, he flawlessly and permanently attains (Apnoti) that absolute supreme and eternal 'Brahmaloka' (the highest state of the Supreme Lord) forever.
            OM Peace, Peace, Peace! (May all three types of terrifying worldly afflictions—spiritual, physical, and supernatural—be completely and permanently pacified forever).
            This phenomenal verse is the absolute 'Phala Shruti' (the supreme benefits of reading) of this magnificent Upanishad, aggressively giving the seeker a 100% foolproof Ironclad Guarantee.
            'Reading' (Pathate) absolutely does not mean merely memorizing and blindly repeating exactly like a mindless parrot; true reading strictly means profoundly understanding every single word and actively Applying it flawlessly in deep Meditation.
            The person who forcefully reminds himself daily that "I am absolutely not the body, I am Brahman, my breaths are continuously chanting OM"—his thick ignorance simply cannot possibly survive.
            Brahmaloka is absolutely not a physical place containing cheap golden palaces; Brahmaloka strictly means the 'Realm of Pure Consciousness', successfully reaching which a human absolutely never returns to this miserable, sorrowful world ever again.
            Right exactly here, this absolute greatest, most terrifyingly powerful treasure of Yoga, Nada, Kundalini, and Advaita Vedanta—the magnificent 'Dhyanabindu Upanishad'—is perfectly, flawlessly, and highly auspiciously Completed.
        """.trimIndent()
    )
)
