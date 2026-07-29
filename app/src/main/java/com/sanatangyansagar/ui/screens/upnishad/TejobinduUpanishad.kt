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
data class TejobinduShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TejobinduUpanishadScreen() {
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
            itemsIndexed(tejobinduShlokasList) { _, shloka ->
                TejobinduShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun TejobinduShlokaCard(shloka: TejobinduShloka) {
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

val tejobinduShlokasList: List<TejobinduShloka> = listOf(
    TejobinduShloka(
        id = 1,
        sanskrit = "तेजोबिन्दुं परं ध्यानं विश्वात्मन् हृदि संस्थितम् । अणुमात्रं परं शान्तं तद्ब्रह्म परमव्ययम् ॥ १ ॥",
        hindi = """
            यह उपनिषद 'तेजोबिन्दु' (परम प्रकाश के बिंदु) के श्रेष्ठ ध्यान का वर्णन करता है।
            वह तेजोबिन्दु साक्षात् विश्वात्मा (संपूर्ण ब्रह्मांड की आत्मा) है, जो मनुष्य के हृदय में स्थित है।
            वह अत्यंत सूक्ष्म (अणुमात्र), परम शांत, और साक्षात् वह सर्वोच्च अविनाशी परब्रह्म है।
            उपनिषद की शुरुआत एक अत्यंत गहरे ध्यान के विषय से होती है—तेजोबिन्दु का ध्यान।
            यहाँ तेजोबिन्दु कोई भौतिक प्रकाश नहीं है, बल्कि वह चेतना की असीम और शुद्ध चमक है।
            हमारा हृदय वह पवित्र स्थान है जहाँ यह विराट ब्रह्मांडीय चेतना एक बिंदु के रूप में मौजूद है।
            'अणुमात्र' का अर्थ है कि वह इतना सूक्ष्म है कि कोई भी भौतिक यंत्र उसे नाप नहीं सकता।
            परंतु उसी एक छोटे से बिंदु (चेतना) में पूरे ब्रह्मांड का प्रकाश और ज्ञान समाया हुआ है।
            जब साधक बाहरी दुनिया से आँखें हटाकर उस 'प्रकाश के बिंदु' पर मन टिकाता है, तो उसे परम शांति मिलती है।
            यही वह अविनाशी ब्रह्म है जिसे पाने के बाद मनुष्य का कभी नाश नहीं होता।
        """.trimIndent(),
        english = """
            This Upanishad profoundly describes the supreme meditation upon the 'Tejobindu' (the point of ultimate light).
            That Tejobindu is the direct Vishwatman (Soul of the universe), firmly established strictly within the human heart.
            It is exceedingly subtle (atomic), supremely peaceful, and is exactly that absolute, indestructible Supreme Brahman.
            The Upanishad magnificently opens with the subject of highly profound meditation—the meditation on Tejobindu.
            Here, Tejobindu is absolutely not a physical light, but the infinite, pure brilliance of absolute Consciousness.
            Our heart is that deeply sacred space where this colossal cosmic consciousness perfectly exists as a tiny point.
            'Subtle as an atom' profoundly implies that absolutely no physical instrument can ever possibly measure it.
            Yet, within that single, tiny point of consciousness, the light and wisdom of the entire cosmos are perfectly contained.
            When the seeker withdraws his eyes from the world and anchors his mind on that 'Point of Light', he attains supreme peace.
            This is exactly that indestructible Brahman, attaining which a human being never undergoes destruction.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 2,
        sanskrit = "दुःसाध्यं च दुराराध्यं दुष्प्रेक्ष्यं च दुराश्रयम् । दुर्लक्ष्यं दुस्तरं ध्यानं मुनीनां च तदाश्रयम् ॥ २ ॥",
        hindi = """
            उस तेजोबिन्दु ब्रह्म को प्राप्त करना अत्यंत कठिन (दुःसाध्य) और उसकी आराधना करना बहुत दुर्लभ है।
            उसे भौतिक आँखों से देखना असंभव (दुष्प्रेक्ष्य) है और उसका आश्रय लेना साधारण मनुष्यों के लिए बहुत कठिन है।
            उस पर लक्ष्य साधना (ध्यान लगाना) और उसके रहस्य को पार करना अत्यंत दुस्तर (कठिन) है।
            परंतु महान मुनियों (ज्ञानियों) के लिए वही तेजोबिन्दु एकमात्र आश्रय और परम ध्यान का विषय है।
            यह श्लोक अज्ञानी और ज्ञानी के बीच के फर्क को बहुत ही स्पष्ट रूप से सामने रखता है।
            जिसका मन वासनाओं और दुनियादारी में फँसा है, उसके लिए इस प्रकाश-बिंदु पर ध्यान लगाना लोहे के चने चबाने जैसा है।
            ईश्वर कोई वस्तु नहीं है जिसे खरीदा जा सके या आँखों से देखा जा सके, इसलिए वह 'दुष्प्रेक्ष्य' है।
            चंचल मन कभी भी उस निराकार और शांत बिंदु पर नहीं टिक सकता, वह बार-बार बाहर भागता है।
            परंतु जिस मुनि ने अपने मन की लहरों को शांत कर लिया है, उसके लिए वह ब्रह्म ही सबसे सुरक्षित घर है।
            सत्य की राह आम लोगों के लिए बहुत कठिन है, पर सच्चे साधक के लिए यह एकमात्र जीवन है।
        """.trimIndent(),
        english = """
            Attaining that Tejobindu Brahman is exceedingly difficult (Duhsadhya), and worshipping it is exceptionally rare.
            It is absolutely impossible to see with physical eyes (Dushprekshya), and taking its refuge is terribly hard for ordinary men.
            Fixing one's focus on it and crossing its profound mystery is supremely difficult to accomplish (Dustara).
            However, for the great Munis (wise sages), that very Tejobindu is their sole refuge and ultimate subject of meditation.
            This magnificent verse flawlessly highlights the stark contrast between an ignorant person and an enlightened sage.
            For one whose mind is deeply trapped in lusts and worldliness, meditating on this point of light is like chewing iron.
            God is absolutely not a physical object to be bought or seen with eyes, hence He is termed 'Dushprekshya'.
            A highly restless mind can never remain anchored on that formless, peaceful point; it repeatedly flees outside.
            But for the Sage who has completely calmed his mental waves, that Brahman is his most secure, permanent home.
            The path of Truth is terribly hard for the masses, but for a true seeker, it is his only authentic life.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 3,
        sanskrit = "जलाहारा वाय्वाहाराः पर्णाहाराश्च ये नराः । तेषां यदुस्तरं ध्यानं मुनीनां च तदाश्रयम् ॥ ३ ॥",
        hindi = """
            जो मनुष्य अत्यंत कठोर तपस्या करते हुए केवल जल पीकर, या केवल हवा खाकर जीवित रहते हैं।
            या जो लोग केवल सूखे पत्ते (पर्ण) खाकर अपना जीवन बिताते हैं (अर्थात जो शरीर को घोर कष्ट देते हैं)।
            उन कठोर तपस्वियों के लिए भी उस परब्रह्म का ध्यान करना अत्यंत कठिन और दुर्लभ (दुस्तर) ही रहता है।
            परंतु आत्मज्ञानी मुनियों के लिए वह ब्रह्म অত্যন্ত सहज है और वही उनका एकमात्र सच्चा आश्रय है।
            यह श्लोक हठयोग और शारीरिक तपस्या के अहंकार पर एक बहुत बड़ा और गहरा प्रहार है।
            लोग सोचते हैं कि भूखे रहने से, शरीर को सुखाने से या हवा पीकर जीने से भगवान मिल जाएंगे।
            उपनिषद कहता है कि शरीर को भूखा मारने से पेट सिकुड़ सकता है, पर इससे 'अहंकार' नहीं मरता।
            जब तक मन में 'मैं इतना बड़ा तपस्वी हूँ' का घमंड है, तब तक तेजोबिन्दु का ध्यान संभव ही नहीं है।
            ईश्वर शरीर की कसरतों से नहीं, बल्कि मन की शुद्धि और गहरी समझ (Wisdom) से मिलता है।
            ज्ञानी मुनि शरीर को कष्ट नहीं देता, वह सीधे अपने मन को शांत करके उस परब्रह्म की शरण में चला जाता है।
        """.trimIndent(),
        english = """
            Those men who perform exceptionally severe penances, surviving merely by drinking water or consuming only air.
            Or those who spend their entire lives eating only dry leaves (meaning, inflicting horrific torture on the body).
            Even for those extreme ascetics, meditating on that Supreme Brahman remains exceedingly difficult and rare (Dustara).
            But for the self-realized Munis, that Brahman is completely natural and remains their absolute, only true refuge.
            This stunning verse is a massive, profound strike against the arrogant ego of Hatha Yoga and severe physical austerities.
            People foolishly believe that by starving, emaciating the physical body, or living on air, they will attain God.
            The Upanishad boldly declares that starving the body may shrink the stomach, but it absolutely does not kill the 'Ego'.
            As long as the toxic pride of "I am a great ascetic" remains, meditating on the Tejobindu is completely impossible.
            God is absolutely never attained through bodily gymnastics, but strictly through mental purity and profound Wisdom.
            A wise sage does not torture his body; he simply calms his restless mind and seamlessly takes refuge in that Brahman.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 4,
        sanskrit = "पञ्चाग्निसाधका ये च ये चैकपादोर्ध्ववासिनः । तेषां यदुस्तरं ध्यानं मुनीनां च तदाश्रयम् ॥ ४ ॥",
        hindi = """
            जो लोग चारों ओर आग जलाकर और ऊपर तपते सूरज के बीच बैठकर पंचाग्नि तपस्या करते हैं।
            या जो लोग एक पैर पर खड़े होकर (एकपाद) या अपने दोनों हाथ ऊपर उठाकर सालों तक तपस्या करते हैं।
            उन घोर और हठी तपस्वियों के लिए भी उस निराकार ब्रह्म का ध्यान करना अत्यंत ही कठिन (दुस्तर) है।
            परंतु शांत और ज्ञानी मुनियों के लिए वही ब्रह्म एकमात्र विश्राम-स्थल और परम आश्रय है।
            प्राचीन काल में लोग भगवान को पाने के लिए शरीर को अत्यंत भयानक कष्ट देते थे (जैसे पंचाग्नि तप)।
            वे एक पैर पर खड़े होकर सोचते थे कि उनकी यह शारीरिक मेहनत भगवान को खुश कर देगी।
            परन्तु वेदान्त कहता है कि शारीरिक कष्ट से केवल सिद्धियां (Magical powers) मिल सकती हैं, मोक्ष नहीं।
            जब तक मन वासनाओं से भरा है, तब तक बाहर से एक पैर पर खड़े होने का कोई आध्यात्मिक फायदा नहीं है।
            सच्चा तप शरीर को तोड़ना नहीं, बल्कि 'अहंकार' (Ego) को तोड़ना है।
            ज्ञानी मुनि जान जाता है कि ब्रह्म तो भीतर ही है, इसलिए वह शारीरिक दिखावे को छोड़कर सीधे आत्मा में स्थित हो जाता है।
        """.trimIndent(),
        english = """
            Those who rigorously practice the Panchagni penance (sitting amidst four fires with the blazing sun above).
            Or those who fiercely perform austerities for years standing firmly on one leg or keeping their arms raised high.
            Even for those severe, stubborn ascetics, deeply meditating on that formless Brahman remains exceptionally difficult (Dustara).
            But for the perfectly tranquil and wise Munis, that exact Brahman is their sole resting place and supreme refuge.
            In ancient times, people inflicted horrifying torture on their bodies (like Panchagni) purely to attain God.
            Standing on one leg, they foolishly believed that their brutal physical labor would somehow please the Supreme Lord.
            But Vedanta strictly declares that physical torture can only grant cheap magical powers (Siddhis), absolutely never Moksha.
            As long as the mind is filled with lust, standing on one leg externally has absolutely zero spiritual benefit whatsoever.
            True penance is absolutely not breaking the physical body, but flawlessly breaking the stubborn 'Ego' entirely.
            The wise sage perfectly knows Brahman is inside, hence he drops physical show-offs and instantly establishes himself in the Soul.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 5,
        sanskrit = "अहङ्कारविहीना ये तदा ध्यानं सुदुर्लभम् । विज्ञानं चैव मेधावी ज्ञानविज्ञानतत्परः ॥ ५ ॥",
        hindi = """
            जब तक मनुष्य के भीतर 'अहंकार' मौजूद है, तब तक उस परब्रह्म का ध्यान करना अत्यंत दुर्लभ (सुदुर्लभ) है।
            केवल वे ही लोग जो पूरी तरह से 'अहंकार-विहीन' (Ego-less) हो चुके हैं, उस ध्यान को साध सकते हैं।
            वह मेधावी (बुद्धिमान) पुरुष जो निरंतर 'ज्ञान' (शास्त्रों के बोध) और 'विज्ञान' (आत्मानुभव) में तत्पर रहता है।
            वही उस तेजोबिन्दु के परम रहस्य को वास्तव में जान पाता है।
            उपनिषद ने यहाँ पिछले श्लोकों का सारांश दे दिया: मोक्ष में सबसे बड़ी रुकावट शरीर नहीं, बल्कि 'अहंकार' है।
            "मैं एक महान साधु हूँ" या "मैं बहुत दान करता हूँ"—यह सूक्ष्म अहंकार इंसान को भगवान से कोसों दूर कर देता है।
            अहंकार उस दीवार की तरह है जो हमारे और परमात्मा के बीच में खड़ी है।
            'ज्ञान' का अर्थ है गुरु से सत्य को सुनना, और 'विज्ञान' का अर्थ है उस सत्य को खुद अपने भीतर महसूस करना।
            केवल किताबों को रट लेना काफी नहीं है; उस ज्ञान को विज्ञान (Experience) में बदलना ही असली साधना है।
            जब अहंकार जीरो (Zero) हो जाता है, तभी इंसान ईश्वर की अनंतता को ग्रहण करने के लायक बनता है।
        """.trimIndent(),
        english = """
            As long as 'Ego' actively exists within a human being, successfully meditating on that Supreme Brahman remains exceptionally rare (Sudurlabha).
            Only those individuals who have become absolutely and completely 'Ego-less' can genuinely master that profound meditation.
            That highly intelligent (Medhavi) sage who remains perpetually engaged in 'Jnana' (scriptural wisdom) and 'Vijnana' (direct self-experience).
            He alone is successfully able to truly comprehend the ultimate, profound mystery of the Tejobindu.
            The Upanishad has flawlessly summarized the previous verses here: the greatest obstacle to Moksha is not the body, but the 'Ego'.
            "I am a great monk" or "I give massive charity"—this highly subtle ego pushes a human millions of miles away from God.
            Ego acts exactly like a massive, impenetrable wall standing solidly between our soul and the Supreme Lord.
            'Jnana' means hearing the Truth from a Guru, and 'Vijnana' means directly experiencing that Truth right within oneself.
            Merely cramming books is absolutely never enough; successfully converting that knowledge into Vijnana (Experience) is the real practice.
            Only exactly when the ego drops completely to Zero does a human become genuinely qualified to receive God's infinity.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 6,
        sanskrit = "अगम्यं सर्वभूतानां मुनीनां च तदाश्रयम् । वाङ्मनोऽगोचरं शान्तं सर्वप्राणिहृदि स्थितम् ॥ ६ ॥",
        hindi = """
            वह ब्रह्म अज्ञानी और सांसारिक प्राणियों के लिए पूरी तरह से 'अगम्य' (पहुँच से बाहर) है।
            परंतु ज्ञानी मुनियों के लिए वही ब्रह्म उनका एकमात्र निवास और परम आश्रय है।
            वह ब्रह्म वाणी (शब्दों) और मन की पहुँच से पूरी तरह बाहर (अगोचर) है, तथा अत्यंत शांत स्वरूप है।
            वही परम शांत चेतना संसार के सभी छोटे-बड़े प्राणियों के हृदय में समान रूप से स्थित है।
            जो लोग दुनिया की वासनाओं में अंधे हैं, वे इस सत्य को कभी नहीं देख सकते; उनके लिए यह 'अगम्य' है।
            ईश्वर को शब्दों से समझाया नहीं जा सकता (वाङ् अगोचरं), क्योंकि शब्द बहुत छोटे हैं और ईश्वर असीम है।
            मन केवल उसी चीज़ को सोच सकता है जिसकी कोई सीमा या आकार हो; इसलिए मन भी भगवान को नहीं पकड़ सकता।
            वह 'शांत' है, जिसका मतलब है कि दुनिया में चाहे कितना भी शोर और तूफान हो, वह भीतर हमेशा स्थिर रहता है।
            वह किसी सातवें आसमान पर नहीं, बल्कि एक चींटी से लेकर हाथी तक—सबके हृदय (Heart) में धड़क रहा है।
            जो अपने ही हृदय में झाँकना सीख लेता है, वह उस अगम्य सत्य को आसानी से पा लेता है।
        """.trimIndent(),
        english = """
            That Brahman is completely 'Agamya' (entirely beyond the reach) of all ignorant and highly worldly creatures.
            But for the truly enlightened Munis, that exact Brahman is their sole residence and absolute supreme refuge.
            That Brahman is completely beyond the grasp (Agochara) of human speech and the mind, and is supremely tranquil by nature.
            That exact same profoundly peaceful consciousness is equally and firmly established within the hearts of all living beings.
            Those who are totally blinded by worldly lusts can never possibly see this Truth; for them, it is strictly 'Agamya'.
            God simply cannot be explained through words (Vak Agocharam), because words are highly limited and God is infinite.
            The mind can only think of objects possessing limits or forms; hence, the mind also can absolutely never capture God.
            He is 'Peaceful', meaning no matter how much terrifying noise and storm exists in the world, He remains forever still within.
            He is absolutely not sitting in some seventh heaven, but is actively pulsating in the hearts of everyone, from an ant to an elephant.
            He who successfully learns to look deep into his very own heart easily finds that highly inaccessible, supreme Truth.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 7,
        sanskrit = "तदेवेदमहं वेद्मि मुनीनां च तदाश्रयम् । यमादिगुणसम्पन्नो नियमैश्च समन्वितः ॥ ७ ॥",
        hindi = """
            "वह परब्रह्म जो सबके हृदय में है, वह मैं ही हूँ"—ऐसा मैं (साधक) पूर्ण निश्चय के साथ जानता (वेद्मि) हूँ।
            और यह जानकर मैं उसी ब्रह्म का आश्रय लेता हूँ जो सभी मुनियों का परम आश्रय है।
            इस ज्ञान को प्राप्त करने के लिए साधक को 'यम' आदि श्रेष्ठ गुणों से पूरी तरह संपन्न होना चाहिए।
            और उसे 'नियम' आदि दिव्य आचरणों के साथ भी पूरी तरह से जुड़ा (समन्वित) होना चाहिए।
            यहाँ से तेजोबिन्दु उपनिषद का सबसे क्रांतिकारी (Revolutionary) हिस्सा शुरू होता है।
            पहले साधक यह घोषणा करता है कि "मैं कोई तुच्छ जीव नहीं, मैं ही वह परब्रह्म हूँ।"
            लेकिन यह केवल मुँह से बोलने की बात नहीं है; इसे अनुभव करने के लिए साधक को तैयार (Qualify) होना पड़ता है।
            वह तैयारी क्या है? वह है 'यम' और 'नियम' का पालन करना।
            पतंजलि के योग में यम-नियम शारीरिक और नैतिक होते हैं (जैसे चोरी न करना, सच बोलना)।
            परंतु तेजोबिन्दु उपनिषद आगे के श्लोकों में इन यम-नियमों की एक बिल्कुल ही नई 'वेदान्तिक' (Vedantic) परिभाषा देने वाला है।
        """.trimIndent(),
        english = """
            "That Supreme Brahman residing in everyone's heart is absolutely ME"—this I (the seeker) know (Vedmi) with ultimate conviction.
            And knowing this profound truth, I take complete refuge in that very Brahman which is the supreme refuge of all sages.
            To successfully attain this high wisdom, a seeker must absolutely be endowed with excellent qualities like 'Yama'.
            And he must also be completely and perfectly aligned (Samanvita) with divine conducts like 'Niyama'.
            Exactly from here begins the most profoundly Revolutionary section of the entire Tejobindu Upanishad.
            First, the seeker boldly declares that "I am not a petty, trivial creature; I myself am that Supreme Brahman."
            But this is absolutely not mere lip service; to truly experience this, the seeker must intensely Qualify himself.
            What exactly is that preparation? It is the strict, unwavering observance of 'Yama' and 'Niyama'.
            In Patanjali's Yoga, Yama and Niyama are largely physical and moral (like not stealing, speaking the truth).
            But the Tejobindu Upanishad, in the following verses, is about to provide an entirely new, deeply 'Vedantic' definition of them.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 8,
        sanskrit = "अमानमददम्भाद्यैर्विहीनश्चेद्भवत्यसौ । पञ्चविंशात्मकं पिण्डं त्यक्त्वा चेत्परमव्ययम् ॥ ८ ॥",
        hindi = """
            वह साधक जो अपने भीतर से मान (सम्मान की चाह), मद (घमंड), और दंभ (पाखंड/दिखावा) से पूरी तरह विहीन (मुक्त) हो जाता है।
            और जो पच्चीस (25) तत्वों से बने हुए इस भौतिक शरीर (पिण्ड) के प्रति अपनी आसक्ति को पूरी तरह त्याग (त्यक्त्वा) देता है।
            केवल वही साधक उस परम और अविनाशी (परमव्ययम्) ब्रह्म को प्राप्त करने का सच्चा अधिकारी बनता है।
            आध्यात्मिक मार्ग पर मान, मद और दंभ सबसे बड़े और सबसे खतरनाक कांटे (Thorns) हैं।
            जब इंसान सोचता है "लोग मेरी तारीफ करें" (मान), या "मैं सबसे श्रेष्ठ हूँ" (मद), तो वह ब्रह्म से कोसों दूर हो जाता है।
            दिखावा (दंभ) करने वाला साधक दुनिया को तो धोखा दे सकता है, पर वह परमात्मा को कभी नहीं पा सकता।
            हमारा शरीर सांख्य दर्शन के अनुसार 25 तत्वों (पंचभूत, मन, बुद्धि, अहंकार आदि) का एक ढांचा मात्र है।
            जब तक हम इस ढांचे (पिण्ड) को ही अपना 'मैं' मानते रहेंगे, तब तक हम अमरता का स्वाद नहीं चख सकते।
            शरीर को त्यागने का अर्थ आत्महत्या करना नहीं है; इसका अर्थ शरीर के 'मोह' (Attachment) को जड़ से मिटाना है।
            जब झूठे घमंड की दीवारें गिरती हैं, तभी अविनाशी ब्रह्म का साक्षात् दर्शन होता है।
        """.trimIndent(),
        english = """
            That seeker who becomes completely and entirely free (Vihina) from the desire for honor (Mana), pride (Mada), and sheer hypocrisy (Dambha).
            And who permanently completely abandons (Tyaktva) his deep attachment to this physical body (Pinda) made of twenty-five (25) elements.
            Only that highly purified seeker becomes the true, legitimate candidate to successfully attain that supreme, indestructible (Paramavyayam) Brahman.
            On the spiritual path, the desire for honor, toxic pride, and sheer hypocrisy are the absolute biggest and most dangerous thorns.
            When a human thinks "People must praise me" (Honor), or "I am the absolute best" (Pride), he moves millions of miles away from Brahman.
            A hypocritical seeker (Dambha) might easily deceive the world, but he can absolutely never, ever attain the Supreme Lord.
            According to Sankhya philosophy, our body is merely a framework constructed of exactly 25 elements (five gross elements, mind, intellect, ego, etc.).
            As long as we fiercely consider this framework (Pinda) to be our true 'I', we can never taste real immortality.
            Abandoning the body absolutely does not mean committing suicide; it strictly means destroying the 'Attachment' to the body from its very roots.
            Only exactly when the heavy walls of false pride fall does the direct, living vision of the indestructible Brahman occur.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 9,
        sanskrit = "षड्विंशकं तु परमात्मा सप्तविंशोऽथवा भवेत् । तावन्नियम्यतेऽन्तःस्थं यावन्नायाति तत्परम् ॥ ९ ॥",
        hindi = """
            उन 25 भौतिक तत्वों से परे जो छब्बीसवां (26th) तत्व है, वह जीवात्मा (Individual soul) है; और जो सत्ताईसवां (27th) तत्व है, वह परमात्मा (Supreme Soul) है।
            (वेदान्त के अनुसार जीव और परमात्मा एक ही हैं, इसलिए अद्वैत में आत्मा ही अंतिम सत्य है)।
            साधक को अपने भीतर (अन्तःस्थं) स्थित मन और इंद्रियों को तब तक पूरी तरह से नियंत्रित (नियम्यते) करके रखना चाहिए।
            जब तक कि वह उस 'परम तत्व' (ब्रह्म) को साक्षात् प्राप्त (नायाति) नहीं कर लेता।
            शरीर के 25 तत्वों के पार जाने पर हमें अपना जीव भाव (26वां तत्व) मिलता है, जो कर्मों के चक्र में फँसा है।
            और जब हम उस जीव भाव के भी पार जाते हैं, तो हमें वह 27वां तत्व (परमात्मा) मिलता है जो हमेशा शुद्ध और आज़ाद है।
            सच्ची साधना यह है कि जब तक हमें वह 27वां तत्व (ब्रह्म) नहीं मिल जाता, तब तक हमें रुकना नहीं है।
            मन बहुत चालाक है; वह बीच में मिलने वाली सिद्धियों (Magical powers) या शांति पर ही रुक जाना चाहता है।
            उपनिषद चेतावनी देता है कि लक्ष्य मिलने से पहले अपने संयम और अनुशासन (Discipline) को बिल्कुल ढीला मत छोड़ो।
            जब तक नदी समुद्र में नहीं मिल जाती, तब तक उसे अपने किनारों के भीतर (नियंत्रण में) ही बहना चाहिए।
        """.trimIndent(),
        english = """
            Completely beyond those 25 material elements is the twenty-sixth (26th) principle, the Jivatma (individual soul); and the twenty-seventh (27th) principle is the Paramatma (Supreme Soul).
            (According to strict Advaita Vedanta, the Jiva and Paramatma are identically one, making the Soul the ultimate, final Truth).
            The sincere seeker must profoundly and completely control (Niyamyate) his internal mind and senses (Antahstham) relentlessly.
            Exactly until he directly, successfully, and fully attains (Nayati) that 'Supreme Principle' (Brahman) in absolute reality.
            Going completely beyond the 25 bodily elements, we discover our Jiva-nature (26th element), which is trapped in the cycle of karma.
            And when we successfully transcend even that Jiva-nature, we discover the 27th element (God), which is eternally pure and absolutely free.
            True, hardcore spiritual practice demands that until we successfully attain that 27th element (Brahman), we must absolutely never stop.
            The mind is incredibly cunning; it desires to permanently stop at intermediate magical powers (Siddhis) or initial glimpses of peace.
            The Upanishad firmly warns: absolutely do not relax your strict restraint and discipline until the absolute final goal is perfectly reached.
            Exactly until a river seamlessly merges completely into the ocean, it must strictly continue to flow securely within its banks (under control).
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 10,
        sanskrit = "ततो निर्विषयस्यास्य मनसो मुक्तिरिष्यते । अतो निर्विषयं नित्यं मनः कार्यं मुमुक्षुणा ॥ १० ॥",
        hindi = """
            जब मन को पूरी तरह से नियंत्रित कर लिया जाता है, तब वह बाहरी विषयों (भोगों) से पूरी तरह रहित (निर्विषय) हो जाता है।
            और उसी निर्विषय (इच्छा-रहित) मन से ही मनुष्य की परम मुक्ति (मोक्ष) की प्राप्ति संभव होती है।
            इसलिए, मुक्ति की तीव्र इच्छा रखने वाले (मुमुक्षु) साधक को चाहिए कि वह अपने मन को निरंतर (नित्यं) निर्विषय बनाए रखे।
            मन का असली स्वभाव ही यह है कि वह हमेशा किसी न किसी विषय (आवाज़, रूप, स्वाद) को पकड़ कर रखना चाहता है।
            जब हम उसे बाहरी विषयों से काट देते हैं, तो वह शुरुआत में बहुत तड़पता है और भागने की कोशिश करता है।
            पर लगातार अभ्यास से जब मन की खुराक (विषय) बंद हो जाती है, तो वह 'निर्विषय' होकर शांत हो जाता है।
            यह श्लोक एक बहुत बड़ा रहस्य बताता है: मोक्ष भगवान का कोई उपहार नहीं है, बल्कि यह आपके अपने मन की एक अवस्था है।
            जिसका मन वासनाओं से खाली हो गया है, वह इसी पल, इसी शरीर में रहते हुए पूर्ण रूप से मुक्त है।
            मुमुक्षु को दिन में 24 घंटे (नित्यं) पहरेदार की तरह अपने मन पर नजर रखनी पड़ती है कि कहीं कोई इच्छा वापस तो नहीं आ रही।
            मन की शून्यता ही ब्रह्मांड की पूर्णता (ईश्वर) के प्रवेश का एकमात्र रास्ता है।
        """.trimIndent(),
        english = """
            When the highly restless mind is completely and perfectly controlled, it becomes entirely devoid (Nirvishaya) of all external worldly objects and lusts.
            And it is exclusively through that perfectly object-free (desireless) mind that a human's absolute, supreme Liberation (Moksha) becomes truly possible.
            Therefore, the dedicated seeker intensely desiring liberation (Mumukshu) must actively and continuously (Nityam) keep his mind completely free from all objects.
            The true, fundamental nature of the mind is that it constantly wants to tightly grasp and hold onto some external object (sound, form, taste).
            When we completely cut it off from external objects, it initially writhes in terrifying agony and desperately attempts to escape.
            But with relentless practice, when the mind's daily food (objects) is entirely shut off, it becomes 'Nirvishaya' and flawlessly calm.
            This verse reveals a massive, profound secret: Moksha is absolutely not a gift from God, but strictly a purified state of your very own mind.
            He whose mind has become completely empty of lusts is absolutely and flawlessly liberated at this very second, while still in this body.
            A Mumukshu must actively guard his mind exactly like a strict watchman 24 hours a day (Nityam) to ensure absolutely no desire sneaks back in.
            The absolute emptiness of the human mind is the one and only guaranteed pathway for the absolute fullness of the Universe (God) to enter.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 11,
        sanskrit = "निरस्तविषयासङ्गं सन्निरुद्धं मनो हृदि । यदा यात्यात्मनो भावं तदा तत्परमं पदम् ॥ ११ ॥",
        hindi = """
            जब मन बाहरी विषयों की सभी प्रकार की आसक्ति और लगाव (विषयासङ्गं) को पूरी तरह से त्याग (निरस्त) देता है।
            और जब वह अपनी सारी चंचलता को रोककर हृदय के भीतर पूरी तरह से स्थिर (सन्निरुद्धं) हो जाता है।
            उस अवस्था में जब वह मन साक्षात् अपनी असली 'आत्मा के भाव' (स्वरूप) को प्राप्त कर लेता है।
            तभी उस अवस्था को सर्वोच्च और अंतिम स्थिति यानी 'परम पद' कहा जाता है।
            यह श्लोक ध्यान की अंतिम मंजिल का बहुत ही स्पष्ट नक्शा (Roadmap) प्रस्तुत कर रहा है।
            पहली शर्त है 'आसक्ति' (Attachment) का टूटना; जब तक दुनिया प्यारी लग रही है, तब तक आत्मा का अनुभव नहीं हो सकता।
            दूसरी शर्त है मन का 'हृदय' में रुकना; मन को बाहर से खींचकर अंदर लाना पड़ता है।
            जब मन बाहर जाना बंद कर देता है, तो वह एक साफ शीशे की तरह हो जाता है जिसमें आत्मा की परछाईं चमकती है।
            मन जब आत्मा का भाव ले लेता है, तो मन खुद भी आत्मा ही बन जाता है; जैसे लोहे को आग में डालने पर लोहा भी आग बन जाता है।
            यही वह 'परम पद' है जिसके बाद संसार में इंसान के लिए कुछ भी पाना या जानना बाकी नहीं रह जाता।
        """.trimIndent(),
        english = """
            When the highly restless mind completely and permanently abandons (Nirasta) absolutely all forms of attachment and deep clinging to worldly objects (Vishayasangam).
            And when, stopping all its chaotic wandering, it becomes perfectly and firmly restrained (Sanniruddham) directly within the absolute center of the heart.
            In that profoundly quiet state, when that mind successfully and flawlessly attains the exact, pure 'State of the Soul' (True Nature).
            Only exactly then is that ultimate state profoundly declared to be the highest and final destination, the 'Supreme Abode' (Paramam Padam).
            This magnificent verse presents an exceptionally clear, foolproof roadmap to the absolute final destination of all meditation.
            The first strict condition is the breaking of 'Attachment'; as long as the external world seems highly attractive, the Soul simply cannot be experienced.
            The second strict condition is the mind halting perfectly in the 'Heart'; the mind must be forcefully withdrawn from the outside and brought inward.
            When the mind completely stops going outward, it flawlessly becomes like a pristine, clear mirror in which the Soul's radiant reflection shines brilliantly.
            When the mind absorbs the nature of the Soul, the mind itself becomes the Soul; exactly as iron placed in blazing fire effectively becomes fire itself.
            This is that exact 'Supreme Abode' after which absolutely nothing whatsoever remains left to be achieved or known by a human in this universe.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 12,
        sanskrit = "तावदेव निरोद्धव्यं यावद्धृदि गतं क्षयम् । एतज्ज्ञानं च ध्यानं च शेषो न्यायस्य विस्तरः ॥ १२ ॥",
        hindi = """
            (अमृतबिंदु उपनिषद के समान ही तेजोबिन्दु भी कहता है): साधक को अपने मन को तब तक बलपूर्वक रोक कर (निरोध) रखना चाहिए।
            जब तक कि वह चंचल मन हृदय के भीतर पहुँचकर पूरी तरह से नष्ट (क्षय) या लीन न हो जाए।
            बस, यही मन का क्षय होना ही सबसे सच्चा 'ज्ञान' है और यही सबसे वास्तविक 'ध्यान' है।
            इसके अलावा शास्त्रों की जितनी भी लंबी-चौड़ी बातें या तर्क-वितर्क (न्यायस्य विस्तरः) हैं, वे सब केवल समय की बर्बादी हैं।
            यह श्लोक बौद्धिक अहंकार (Intellectual ego) पर सबसे बड़ा हथौड़ा मारता है।
            लोग बड़ी-बड़ी किताबें पढ़कर और दर्शन (Philosophy) पर बहस करके खुद को बहुत बड़ा ज्ञानी मान लेते हैं।
            पर उपनिषद कहता है कि असली ज्ञान वो नहीं जो जीभ पर हो, असली ज्ञान वो है जहाँ मन पूरी तरह 'मर' चुका हो।
            जब तक मन जिंदा है और सवाल पूछ रहा है, तब तक आप अज्ञान में ही हैं।
            ध्यान का मतलब घंटों बैठना नहीं, बल्कि 'मैं' (अहंकार) के शोर को पूरी तरह से 'क्षय' (Zero) कर देना है।
            सत्य बहुत ही सीधा और सरल है; बाकी सारी फिलॉसफी (न्याय-विस्तार) केवल भटके हुए दिमागों का एक फालतू खेल है।
        """.trimIndent(),
        english = """
            (Similar to Amritabindu, Tejobindu also declares): The sincere seeker must forcefully and firmly restrain and control (Nirodha) his highly restless mind.
            Exactly and strictly until that extremely chaotic mind fully reaches within the heart and completely undergoes total destruction (Kshaya) or dissolution.
            This, and strictly this absolute destruction of the mind alone, is the truest 'Wisdom', and this alone is the most genuine 'Meditation'.
            Apart from this, absolutely all the lengthy, complex scriptural arguments and philosophical debates (Nyayasya vistarah) are merely a total waste of time.
            This powerful verse strikes the absolute heaviest hammer-blow against human intellectual arrogance (Intellectual ego).
            People falsely assume themselves to be great, wise scholars simply by reading massive books and relentlessly debating complex philosophy.
            But the Upanishad fiercely declares that true wisdom is not what dances on the tongue; true wisdom is exactly where the mind has completely 'died'.
            As long as the mind is actively alive and continuously asking chaotic questions, you are undoubtedly still in deep ignorance.
            Meditation does not merely mean sitting for hours, but completely reducing the loud noise of 'I' (Ego) to absolute 'Kshaya' (Zero).
            The Truth is exceptionally straight and simple; all other complex philosophy (Nyaya-vistara) is merely a completely useless game of utterly distracted brains.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 13,
        sanskrit = "नैव चिन्त्यं न चाचिन्त्यं न चिन्त्यं चिन्त्यमेव च । पक्षपातविनिर्मुक्तं ब्रह्म सम्पद्यते तदा ॥ १३ ॥",
        hindi = """
            वह परब्रह्म न तो सोचने (चिन्त्य) का विषय है (क्योंकि वह असीम है), और न ही वह पूरी तरह से न सोचे जा सकने (अचिन्त्य) वाला है।
            वह न तो केवल चिंतन के योग्य है, और न ही वह चिंतन की सीमा में आता है (वह इन दोनों से परे है)।
            जब साधक का मन 'यह है' और 'यह नहीं है' जैसे सभी मानसिक पक्षों और धारणाओं (पक्षपात) से पूरी तरह मुक्त (विनिर्मुक्त) हो जाता है।
            केवल तभी (तदा) वह साधक उस परम और अद्वैत ब्रह्म को साक्षात् प्राप्त (सम्पद्यते) कर लेता है।
            हमारा दिमाग बाइनरी (Binary) में काम करता है—या तो कोई चीज़ अच्छी है या बुरी, है या नहीं है।
            परंतु भगवान दिमाग की इस बाइनरी भाषा (द्वैत) से पूरी तरह बाहर है; वह किसी फ्रेम (Frame) में फिट नहीं होता।
            अगर हम सोचें कि हम भगवान को 'सोच' लेंगे, तो वह हमारी कल्पना (Imagination) होगी, असली भगवान नहीं।
            पक्षपात-विनिर्मुक्त का अर्थ है मन का पूरी तरह से 'न्यूट्रल' (Neutral/शून्य) हो जाना।
            जब हम अपनी सारी राय (Opinions) और लॉजिक (Logic) को कूड़ेदान में फेंक देते हैं, तभी सत्य खुद-ब-खुद प्रकट होता है।
            भगवान को पकड़ने की कोशिश छोड़ दो, बस खुद के विचारों को खाली कर दो—ईश्वर खुद तुम में भर जाएगा।
        """.trimIndent(),
        english = """
            That Supreme Brahman is absolutely not a subject of thought (Chintya) (because He is infinite), nor is He something that is entirely unthinkable (Achintya).
            He is neither merely worthy of contemplation, nor does He ever fall within the strict boundaries of any mental thought (He is completely beyond both).
            When the sincere seeker's mind becomes completely and flawlessly free (Vinirmukta) from all mental biases, assumptions, and partialities (Pakshapata) like 'it is' and 'it is not'.
            Only exactly then (Tada) does that seeker directly and successfully attain (Sampadyate) that supreme, absolute, and non-dual Brahman.
            Our human brain operates strictly in Binary—either something is good or bad, either it exists or it doesn't.
            But God exists completely and entirely outside this binary language (duality) of the brain; He simply does not fit into any mental frame.
            If we arrogantly think we can 'think' of God, that will merely be our own cheap imagination, absolutely not the real God.
            Being free from partiality (Pakshapata-vinirmukta) profoundly means the mind becoming 100% absolutely 'Neutral' (Void/Zero).
            Only exactly when we ruthlessly throw all our stubborn opinions and complex logic into the garbage bin does Truth manifest completely on its own.
            Drop the arrogant attempt to mentally capture God, just empty your own chaotic thoughts—God will automatically fill you completely.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 14,
        sanskrit = "मन्त्रो योगो न तत्रैव न तत्रैव क्रिया तथा । न तत्रैव शमो दमो न तत्रैव नियम्यते ॥ १४ ॥",
        hindi = """
            उस परम अवस्था (ब्रह्म-साक्षात्कार) में पहुँचने के बाद, साधक के लिए कोई 'मंत्र' जपना शेष नहीं रहता।
            वहाँ किसी भी प्रकार का कोई 'योग' (आसन या प्राणायाम) या कोई भी 'क्रिया' (कर्मकांड) भी बाकी नहीं रहती।
            उस सर्वोच्च स्थिति में मन को शांत करने (शम) और इंद्रियों को दबाने (दम) की भी कोई जरूरत नहीं पड़ती।
            और न ही वहाँ यम-नियम आदि किसी भी प्रकार के अनुशासन (नियम्यते) का पालन करना बाकी रहता है।
            यह श्लोक अध्यात्म की सभी सीढ़ियों (Tools) को पार कर जाने की अवस्था का वर्णन करता है।
            मंत्र, योग, और नियम—ये सब दवाइयों (Medicines) की तरह हैं जो मन की बीमारी (अज्ञान) को ठीक करने के लिए हैं।
            जब बीमारी पूरी तरह ठीक हो गई (मोक्ष मिल गया), तो दवाई खाते रहना बेवकूफी है।
            ज्ञानी पुरुष को अपने मन को 'शांत' (शम) नहीं करना पड़ता, क्योंकि उसका मन पहले से ही हमेशा के लिए मर चुका है।
            उसे इंद्रियों को 'दबाना' (दम) नहीं पड़ता, क्योंकि उसके अंदर वासना का बीज ही जल चुका है।
            वह पूर्ण स्वतंत्र और आज़ाद हो जाता है; उसके लिए दुनिया का कोई भी धार्मिक नियम या कर्मकांड लागू नहीं होता।
        """.trimIndent(),
        english = """
            After successfully reaching that absolute supreme state (Self-realization), absolutely no chanting of any 'Mantra' remains left for the seeker to perform.
            There, absolutely no form of 'Yoga' (physical postures or breath control) or any religious 'Activity' (Kriya/rituals) remains existing anymore.
            In that absolute highest state, there is absolutely no need whatsoever to artificially calm the mind (Shama) or forcefully suppress the physical senses (Dama).
            Nor is there any requirement left there to strictly follow any kind of strict discipline (Niyamyate) like Yama and Niyama.
            This magnificent verse profoundly describes the ultimate state of having completely transcended absolutely all tools and ladders of spirituality.
            Mantras, Yoga, and strict rules—these are all exactly like powerful Medicines specifically prescribed to cure the terrible disease of the mind (ignorance).
            When the deadly disease is completely and permanently cured (Moksha is attained), continuing to eagerly swallow medicine is sheer foolishness.
            An enlightened sage absolutely does not have to actively 'calm' (Shama) his mind, simply because his mind is already permanently dead forever.
            He doesn't have to forcefully 'suppress' (Dama) his senses, because the very poisonous seed of lust has been completely burnt to ashes within him.
            He becomes absolutely and perfectly independent and free; absolutely no religious rule or rigid ritual of the world applies to him anymore.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 15,
        sanskrit = "यमो हि नियमस्त्यागो मौनं देशश्च कालता । आसनं मूलबन्धश्च देहसाम्यं च दृक्स्थितिः ॥ १५ ॥",
        hindi = """
            (अब यहाँ से 'वेदान्तिक योग' के 15 अंगों का वर्णन शुरू होता है): 
            तेजोबिन्दु उपनिषद के अनुसार योग के पंद्रह (15) अंग हैं: 
            1. यम (Yama), 2. नियम (Niyama), 3. त्याग (Tyaga), 4. मौन (Mauna), 5. देश (Desha / पवित्र स्थान), 6. काल (Kala / समय)।
            7. आसन (Asana), 8. मूलबंध (Mula-bandha), 9. देहसाम्य (Deha-samya / शरीर का संतुलन), और 10. दृक्स्थिति (Drik-sthiti / दृष्टि की स्थिरता)।
            महर्षि पतंजलि ने 'अष्टांग योग' (8 अंग) दिए थे, पर यह उपनिषद 'पञ्चदशांग योग' (15 अंग) प्रस्तुत करता है।
            यह योग शरीर को मोड़ने या साँसें रोकने पर नहीं, बल्कि मन की दृष्टि (Perspective) बदलने पर जोर देता है।
            इसमें जो 15 सीढ़ियाँ बताई गई हैं, वे पूरी तरह से अद्वैत ज्ञान (Non-duality) पर आधारित हैं।
            यहाँ 'आसन' का मतलब पद्मासन में बैठना नहीं होगा, बल्कि 'सत्य में स्थिर होना' होगा।
            अगले श्लोक में बाकी 5 अंगों के नाम बताए गए हैं, और फिर एक-एक करके इनकी अत्यंत रहस्यमयी और नई परिभाषा दी जाएगी।
            साधक को यह समझना होगा कि शारीरिक कसरत से भगवान नहीं मिलता; ज्ञान और समझ से मिलता है।
            यह 15 अंगों वाला योग इंसान को सीधे परमेश्वर की कुर्सी (ब्रह्म-भाव) पर ले जाकर बैठा देता है।
        """.trimIndent(),
        english = """
            (Now begins the profound description of the 15 limbs of 'Vedantic Yoga'): 
            According to the magnificent Tejobindu Upanishad, there are exactly fifteen (15) limbs of Yoga: 
            1. Yama, 2. Niyama, 3. Tyaga (Renunciation), 4. Mauna (Silence), 5. Desha (Sacred Space), 6. Kala (Time).
            7. Asana (Posture), 8. Mulabandha (Root Lock), 9. Dehasamya (Bodily Equipoise), and 10. Drik-sthiti (Steadiness of Vision).
            Sage Patanjali famously provided the 'Ashtanga Yoga' (8 limbs), but this Upanishad boldly presents the highly advanced 'Panchadashanga Yoga' (15 limbs).
            This specific Yoga absolutely does not focus on twisting the physical body or fiercely holding the breath, but on completely changing the mind's Perspective.
            The exact 15 steps detailed here are entirely and strictly based on the supreme wisdom of Non-duality (Advaita).
            Here, 'Asana' absolutely will not mean sitting physically in the Lotus pose, but will profoundly mean 'being firmly established in Truth'.
            The very next verse flawlessly lists the names of the remaining 5 limbs, and then their highly mystical, entirely new definitions will be provided one by one.
            A sincere seeker must perfectly understand that God is absolutely never attained through physical gymnastics; He is attained purely through supreme wisdom and understanding.
            This 15-limbed Yoga flawlessly and directly takes a human and seats him right on the ultimate throne of the Supreme Lord (Brahma-bhava).
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 16,
        sanskrit = "प्राणसंयमनं चैव प्रत्याहारश्च धारणा । आत्मध्यानं समाधिश्च प्रोक्तान्यङ्गानि वै क्रमात् ॥ १६ ॥",
        hindi = """
            (योग के बाकी 5 अंगों के नाम): 
            11. प्राणसंयमन (Pranayama / प्राणों का नियंत्रण), 12. प्रत्याहार (Pratyahara / इंद्रियों को विषयों से हटाना)।
            13. धारणा (Dharana / मन को एकाग्र करना), 14. आत्मध्यान (Atma-dhyana / आत्मा का निरंतर चिंतन)।
            और 15. समाधि (Samadhi / पूर्ण रूप से ब्रह्म में लीन हो जाना)—विद्वानों द्वारा ये योग के 15 अंग इसी क्रम (Sequence) में बताए गए हैं।
            यह पूरी 15 सीढ़ियों की यात्रा इंसान को बाहर (संसार) से शुरू करके बिल्कुल अंदर (आत्मा) तक ले जाती है।
            शुरुआत में हमें अपने व्यवहार (यम-नियम) को सुधारना है, फिर अपने शरीर और प्राण को स्थिर करना है।
            और अंत में अपने पूरे मन को केवल और केवल उस परम आत्मा (ब्रह्म) के ध्यान में डुबो देना है।
            यहाँ 'आत्मध्यान' शब्द का प्रयोग किया गया है; इसका मतलब है कि ध्यान किसी मूर्ति या मंत्र का नहीं, बल्कि खुद के असली स्वरूप (मैं कौन हूँ) का करना है।
            और जब ध्यान करते-करते ध्यान करने वाला (Ego) पूरी तरह मिट जाए, तो वही 'समाधि' है।
            यह 15 अंगों का रास्ता कोई शारीरिक व्यायाम (Workout) नहीं है, बल्कि यह चेतना का एक अत्यंत वैज्ञानिक ऑपरेशन (Surgery) है।
            अब अगले श्लोकों में इन शब्दों की असली वेदान्तिक परिभाषा (Vedantic definition) दी जाएगी जो आपकी आँखें खोल देगी।
        """.trimIndent(),
        english = """
            (The names of the remaining 5 limbs of Yoga): 
            11. Pranashamyamana (Pranayama / Supreme control of vital breath), 12. Pratyahara (Total withdrawal of senses from worldly objects).
            13. Dharana (Perfect concentration of the mind), 14. Atma-dhyana (Continuous, unbroken contemplation upon the pure Soul).
            And 15. Samadhi (Absolute, perfect absorption into Brahman)—These exact 15 limbs of Yoga have been declared by wise scholars precisely in this strict sequence.
            This entire magnificent journey of 15 steps flawlessly takes a human from the absolute outside (world) straight into the deepest absolute inside (Soul).
            In the very beginning, we must rigorously correct our external behavior (Yama-Niyama), then perfectly stabilize our physical body and vital breath.
            And ultimately, we must completely drown our entire mind solely and exclusively in the profound meditation of that Supreme Soul (Brahman).
            Here, the specific word 'Atma-dhyana' is highly intentionally used; it means meditation is absolutely not on any idol or mantra, but strictly on one's own true nature (Who am I).
            And when, through intense meditation, the meditator himself (Ego) is completely wiped out, that exact zero-state is 'Samadhi'.
            This 15-limbed path is absolutely not a physical workout; it is an exceedingly precise, highly scientific spiritual Surgery of human consciousness.
            Now, in the subsequent verses, the true, mind-blowing Vedantic definitions of these words will be provided, which will completely open your eyes.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 17,
        sanskrit = "सर्वं ब्रह्मेति विज्ञानादिन्द्रियग्रामसंयमः । यमोऽयमिति सम्प्रोक्तो ह्यभ्यसनीयो मुहुर्मुहुः ॥ १७ ॥",
        hindi = """
            (1. यम की वेदान्तिक परिभाषा): "यह सब कुछ (संपूर्ण ब्रह्मांड) केवल परब्रह्म ही है"—इस परम विज्ञान (ज्ञान) के द्वारा।
            जब साधक अपनी सभी इंद्रियों के समूह (इंद्रियग्राम) को स्वाभाविक रूप से शांत और संयमित (संयम) कर लेता है।
            उसे ही सच्चे ज्ञानियों द्वारा असली 'यम' (Yama) कहा गया है; और साधक को इसी भाव का बार-बार (मुहुर्मुहुः) अभ्यास करना चाहिए।
            पतंजलि योग में 'यम' का अर्थ अहिंसा, सत्य, ब्रह्मचर्य आदि नियमों का पालन करना है (जो कभी-कभी बहुत कठिन लगता है)।
            पर तेजोबिन्दु उपनिषद एक बहुत ही क्रांतिकारी (Revolutionary) और आसान तरीका बताता है।
            जब आप यह जान लेते हैं कि दुनिया की हर खूबसूरत चीज़, हर इंसान और हर सुख साक्षात् 'ब्रह्म' ही है।
            तो फिर आप किससे नफरत करेंगे? (अहिंसा अपने-आप आ गई)। आप किसे धोखा देंगे? (सत्य अपने-आप आ गया)।
            इंद्रियों को जबरदस्ती डंडे से मार कर कंट्रोल नहीं करना है; जब सब जगह भगवान दिखने लगे, तो इंद्रियां खुद-ब-खुद शांत हो जाती हैं।
            यह 'यम' मन को दबाने (Suppression) का नहीं, बल्कि मन को सत्य की समझ (Understanding) से बदलने का तरीका है।
            "सब कुछ ब्रह्म है"—दिन-रात इसी बात को खुद को याद दिलाना ही सबसे बड़ा और असली 'यम' है।
        """.trimIndent(),
        english = """
            (1. Vedantic Definition of Yama): "Absolutely everything (the entire cosmos) is exclusively the Supreme Brahman alone"—strictly through this supreme Vijnana (Wisdom).
            When a sincere seeker naturally and effortlessly calms and perfectly controls (Samyama) his entire group of physical senses (Indriyagrama).
            That alone is profoundly declared by the true, enlightened sages to be the real 'Yama'; and the seeker must rigorously practice this exact feeling again and again (Muhurmuhuh).
            In Patanjali Yoga, 'Yama' means strictly practicing non-violence, truthfulness, celibacy, etc. (which often feels extremely difficult and forced).
            But the Tejobindu Upanishad boldly presents an exceptionally Revolutionary and profoundly easier method.
            When you perfectly realize that every beautiful thing, every single human, and every joy in the world is the direct manifestation of 'Brahman' itself.
            Then whom will you ever hate? (Non-violence arrives automatically). Whom will you ever cheat? (Truthfulness arrives automatically).
            You absolutely do not have to forcefully beat and control your senses with a strict stick; when God is clearly seen everywhere, the senses automatically become perfectly calm.
            This 'Yama' is absolutely not a method of toxic Suppression, but a flawless method of transforming the mind through the sheer Understanding of Truth.
            "Everything is strictly Brahman"—constantly reminding oneself of this exact ultimate truth day and night is the absolute greatest and most genuine 'Yama'.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 18,
        sanskrit = "सजातीयप्रवाहश्च विजातीयतिरस्कृतिः । नियमो हि परानन्दो नियमात्क्रियते बुधैः ॥ १८ ॥",
        hindi = """
            (2. नियम की वेदान्तिक परिभाषा): अपने मन में निरंतर केवल 'ब्रह्म' (परमात्मा) के सजातीय (उसी के समान) विचारों का ही प्रवाह बनाए रखना।
            और ब्रह्म से अलग (विजातीय / सांसारिक) विचारों का पूरी तरह से तिरस्कार (त्याग या रिजेक्शन) कर देना।
            यही असली 'नियम' (Niyama) है, जो साधक को परम आनंद (परानन्दो) प्रदान करता है; ज्ञानी पुरुष इसी नियम का निरंतर पालन करते हैं।
            पतंजलि योग में 'नियम' का अर्थ नहाना-धोना (शौच), संतोष और तपस्या आदि करना है।
            पर वेदान्त कहता है कि केवल शरीर को साबुन से धोने से कुछ नहीं होगा, असली गंदगी तो हमारे विचारों की है।
            'सजातीय प्रवाह' का अर्थ है मन में 24 घंटे केवल एक ही नदी बहनी चाहिए: "मैं ब्रह्म हूँ, ईश्वर सत्य है।"
            और 'विजातीय तिरस्कृति' का मतलब है कि जैसे ही मन में पैसे, वासना या ईर्ष्या का कोई भी फालतू विचार आए, उसे तुरंत डस्टबिन (Dustbin) में फेंक दो।
            जैसे दूध में नींबू की एक बूँद भी उसे फाड़ देती है, वैसे ही ब्रह्म-विचार में संसार का एक भी विचार (विजातीय) ध्यान को तोड़ देता है।
            जब मन में केवल सत्य का ही विचार बहता है, तो इंसान को वह परम आनंद मिलता है जो कभी खत्म नहीं होता।
            असली नियम घड़ियों या कैलेंडरों का गुलाम होना नहीं, बल्कि अपनी सोच का एक सख्त और शानदार पहरेदार (Watchman) बनना है।
        """.trimIndent(),
        english = """
            (2. Vedantic Definition of Niyama): Continuously and flawlessly maintaining a steady, unbroken flow of purely homogenous (Sajatiya) thoughts strictly about 'Brahman' (God) within the mind.
            And ruthlessly, completely rejecting and completely discarding (Tiraskriti) absolutely all heterogenous (Vijatiya / worldly) thoughts completely different from Brahman.
            This, and strictly this alone, is the real 'Niyama', which instantly grants absolute supreme bliss (Paranando) to the seeker; truly wise men flawlessly practice this Niyama constantly.
            In Patanjali Yoga, 'Niyama' refers to physical bathing (Shaucha), contentment, physical penance, etc.
            But Vedanta fiercely declares that merely washing the physical body with cheap soap achieves absolutely nothing; the real, toxic filth is strictly in our thoughts.
            'Sajatiya Pravaha' profoundly means that for 24 hours, only one single river must flow uninterrupted in the mind: "I am Brahman, God is Truth."
            And 'Vijatiya Tiraskriti' strictly means that the exact moment any useless thought of money, lust, or deep jealousy enters the mind, ruthlessly throw it instantly into the garbage bin.
            Just as a single drop of lemon completely ruins pure milk, even one single worldly thought (Vijatiya) instantly shatters the profound meditation on Brahman.
            When only the pure thought of Truth flows unbroken in the mind, the human gains that supreme, ultimate bliss which absolutely never ends.
            Real Niyama is absolutely not being a pathetic slave to clocks or calendars, but actively becoming an exceptionally strict, brilliant Watchman of your own thoughts.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 19,
        sanskrit = "त्यागः प्रपञ्चरूपस्य चिदात्मत्वावलोकनात् । त्यागो हि महतां पूज्यः सद्यो मोक्षप्रदायकः ॥ १९ ॥",
        hindi = """
            (3. त्याग की वेदान्तिक परिभाषा): यह संपूर्ण प्रपञ्च (दिखाई देने वाला संसार) केवल एक भ्रम है, और सब कुछ केवल 'चिदात्मा' (शुद्ध चेतना/ब्रह्म) ही है।
            इस गहरे बोध (अवलोकन) के द्वारा मन से इस झूठे संसार की वास्तविकता (Reality) को पूरी तरह से छोड़ देना ही असली 'त्याग' (Tyaga) है।
            इस प्रकार का मानसिक त्याग ही महान संतों द्वारा पूजनीय (श्रेष्ठ) माना गया है, और यही वह त्याग है जो सद्यः (तुरंत / Instant) मोक्ष प्रदान करता है।
            आम इंसान सोचता है कि 'त्याग' का मतलब है अपना बैंक बैलेंस, घर और बीवी-बच्चों को छोड़कर जंगल भाग जाना।
            पर उपनिषद हँसता है: अगर तुम जंगल भी गए, पर तुम्हारे दिमाग में अभी भी 'संसार' सच है, तो तुमने कुछ नहीं छोड़ा!
            असली त्याग भौतिक चीजों को छोड़ना नहीं है, बल्कि इस बात को गहराई से समझ लेना है कि "यह संसार एक सपना है।"
            जब आप मूवी (Movie) देखते हैं, तो आप जानते हैं कि स्क्रीन पर दिखने वाला खून असली नहीं है; यही समझ 'त्याग' है।
            संसार को सच मानना ही सबसे बड़ा 'ग्रहण' (पकड़ना) है; और संसार को झूठ (Illusion) जानकर उसे मन से छोड़ देना ही असली 'त्याग' है।
            जिस दिन यह बात 100% समझ आ जाती है, उसी एक सेकंड (सद्यः) में इंसान मुक्त हो जाता है; मोक्ष के लिए सालों इंतजार नहीं करना पड़ता।
            महान लोग कपड़े नहीं बदलते, वे केवल अपनी समझ (Vision) को बदलते हैं, और यही सबसे बड़ा सन्यास है।
        """.trimIndent(),
        english = """
            (3. Vedantic Definition of Tyaga): This entire Prapancha (visible physical world) is merely a grand illusion, and absolutely everything is exclusively the 'Chidatma' (Pure Consciousness/Brahman) alone.
            Strictly through this profoundly deep realization (Avalokana), completely dropping and abandoning the false reality of this illusory world from the mind is true 'Tyaga' (Renunciation).
            This specific type of profound mental renunciation is considered highly worshipful (supreme) by the great saints, and this alone is the exact renunciation that grants absolute Moksha instantly (Sadyah).
            A common human falsely assumes that 'Renunciation' implies abandoning his bank balance, physical home, and helpless family to foolishly run away into the dense forest.
            But the Upanishad laughs: even if you run to the forest, but the 'World' still remains completely real in your mind, you have absolutely renounced nothing!
            True renunciation is absolutely not dropping physical material objects, but deeply, flawlessly understanding the absolute fact that "This entire world is merely a fleeting dream."
            When you watch a violent Movie, you know perfectly well that the blood splashing on the screen is not real at all; this exact profound understanding is 'Tyaga'.
            Falsely accepting the world as real is the greatest 'Grasping'; and knowing the world as an illusion and dropping it entirely from the mind is the only true 'Renunciation'.
            The exact day this fact is 100% perfectly understood, a human being is absolutely liberated in that very same split-second (Sadyah); one absolutely does not have to wait years for Moksha.
            Truly great people absolutely do not change their physical clothes; they strictly and profoundly change their Vision (understanding), and this alone is the greatest absolute Sannyasa.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 20,
        sanskrit = "यस्माद्वाचो निवर्तन्ते अप्राप्य मनसा सह । यन्मौनं योगिभिर्गम्यं तद्भवेत्सर्वदा बुधः ॥ २० ॥",
        hindi = """
            (4. मौन की वेदान्तिक परिभाषा): वह परम तत्व (ब्रह्म) जिसे प्राप्त किए बिना ही हमारी वाणी (शब्द) और हमारा चंचल मन हार मानकर वापस लौट आते हैं (निवर्तन्ते)।
            उस असीम और अगम्य तत्व के सामने अपनी बुद्धि का पूरी तरह शांत हो जाना ही असली 'मौन' (Mauna) है, जिसे केवल महान योगियों द्वारा ही प्राप्त (गम्यं) किया जाता है।
            बुद्धिमान (बुधः) साधक को चाहिए कि वह हमेशा (सर्वदा) उसी परम मौन की अवस्था में ही स्थिर रहे।
            साधारण भाषा में मौन का मतलब है 'मुँह से कुछ न बोलना'; पर वेदान्त कहता है कि अगर मुँह बंद है पर दिमाग में हजारों विचार चल रहे हैं, तो वह मौन नहीं, शोर है!
            असली मौन तब होता है जब दिमाग को यह समझ आ जाए कि "भगवान इतना विशाल है कि मैं उसे कभी सोच या बोल नहीं सकता।"
            जब इंसान की बुद्धि (Intellect) अपनी हार मान लेती है और सरेंडर (Surrender) कर देती है, तब दिमाग में एक अत्यंत गहरा सन्नाटा छा जाता है।
            वह सन्नाटा (मौन) कोई खालीपन (Emptiness) नहीं है; वह भगवान की असली उपस्थिति (Presence) है।
            वाणी (शब्द) हमेशा सीमित (Limited) चीजों का वर्णन कर सकती है; अनंत (Infinite) को केवल उस 'मौन' में ही महसूस किया जा सकता है।
            महान योगी होंठों को सीने की मेहनत नहीं करते, वे बस अपनी सोच को उस शून्य में विलीन कर देते हैं।
            दुनिया के शोरगुल के बीच रहते हुए भी भीतर से उस असीम शून्यता में टिके रहना ही सबसे श्रेष्ठ और सच्चा 'मौन' है।
        """.trimIndent(),
        english = """
            (4. Vedantic Definition of Mauna): That Supreme Principle (Brahman) failing to attain which, our speech (words) and our highly restless mind completely accept defeat and return empty-handed (Nivartante).
            The absolute, total silencing and surrender of one's intellect before that infinite and utterly inaccessible reality is true 'Mauna' (Silence), which is successfully attained (Gamyam) exclusively by great Yogis.
            A truly wise (Budhah) seeker must actively strive to constantly and perfectly remain established exclusively in that supreme state of profound absolute Silence at all times (Sarvada).
            In ordinary language, silence merely means 'not speaking with the mouth'; but Vedanta fiercely declares that if the mouth is firmly shut but thousands of chaotic thoughts are violently running in the brain, that is absolutely not silence, it is sheer noise!
            Real, ultimate Silence occurs strictly when the brain profoundly understands that "God is so incredibly vast that I can absolutely never think of or describe Him."
            When a human being's Intellect totally accepts its ultimate defeat and completely Surrenders, an exceedingly deep, profound stillness instantly descends upon the brain.
            That absolute stillness (Mauna) is absolutely not a dead Emptiness; it is the extremely vibrant, real, and undeniable Presence of God Himself.
            Speech (words) can only successfully describe highly Limited things; the absolute Infinite can be purely felt and experienced exclusively in that 'Silence' alone.
            Great Yogis absolutely do not waste their vital energy forcefully sewing their lips shut; they simply dissolve their entire thinking process flawlessly into that void.
            Successfully remaining anchored completely within that infinite inner void, even while actively living amidst the chaotic, loud noise of the world, is the absolute highest and truest 'Mauna'.
        """.trimIndent()
    ),
// ... Continuing tejobinduShlokasList from ID 21

    TejobinduShloka(
        id = 21,
        sanskrit = "आदावन्ते च मध्ये च जनो यस्मिन्न विद्यते । येनेदं सततं व्याप्तं स देशो विजनः स्मृतः ॥ २१ ॥",
        hindi = """
            (5. देश की वेदान्तिक परिभाषा): वह पवित्र स्थान (देश) जहाँ शुरुआत, मध्य और अंत में कोई भी जन (प्राणी या भीड़) मौजूद नहीं है।
            और जिस एक अखंड तत्व से यह संपूर्ण ब्रह्मांड निरंतर (सतत) और पूर्ण रूप से व्याप्त है।
            उसी अनंत और असीम तत्व (ब्रह्म) को ही योगियों द्वारा असली और परम एकांत 'देश' (स्थान) माना गया है।
            सामान्य योग में साधक ध्यान करने के लिए किसी शांत गुफा या हिमालय (देश) की खोज करता है।
            परन्तु वेदान्त कहता है कि बाहरी जगह बदलने से मन का शोर और दुनिया की भीड़ कभी खत्म नहीं होती।
            असली 'एकांत स्थान' वह परम चेतना है, जहाँ कोई 'दूसरा' जीव कभी प्रवेश ही नहीं कर सकता।
            जब आप उस ब्रह्म में स्थित होते हैं, तो पूरी दुनिया का शोर भी आपके एकांत को भंग नहीं कर सकता।
            इस शरीर को या किसी भौतिक जगह को अपना स्थायी निवास मत मानो; अपनी असीम आत्मा को ही अपना घर मानो।
            ब्रह्म ही वह एकमात्र स्थान है जिसकी कोई सीमा (Boundaries) नहीं है और जो हमेशा निर्जन (एकांत) है।
            उसी शुद्ध चेतना में अपने मन को ठहराना ही 'देश' नामक योग के इस पांचवें अंग का सच्चा पालन है।
        """.trimIndent(),
        english = """
            (5. Vedantic Definition of Desha): That sacred space (Desha) where absolutely no individual (person or crowd) exists in the beginning, middle, or end.
            And that one unbroken, infinite principle by which this entire visible cosmos is continuously and thoroughly pervaded.
            That boundless, infinite Reality alone is deeply considered by true Yogis to be the real and supremely solitary 'Place' (Desha).
            In ordinary Yoga, a seeker desperately searches for a quiet physical cave or the Himalayas (Desha) to practice deep meditation.
            But Vedanta fiercely declares that merely changing your physical location never actually eliminates the mind's loud noise or the world's crowd.
            The real 'Solitary Place' is that Supreme Consciousness (Brahman), where absolutely no 'other' creature can ever possibly enter.
            When you are flawlessly established in that Brahman, even the screaming noise of the entire world cannot disturb your absolute solitude.
            Absolutely do not consider this perishable physical body or any earthly location as your residence; accept your infinite Soul as your true home.
            Brahman alone is that exclusive, supreme space which possesses absolutely zero boundaries and remains eternally desolate (peacefully solitary).
            Firmly anchoring your mind exactly within that pure consciousness is the true observance of this fifth limb of Yoga called 'Desha'.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 22,
        sanskrit = "कलनात्सर्वभूतानां ब्रह्मादीनां निमेषतः । कालशब्देन निर्दिष्टो ह्यखण्डानन्दमद्वयम् ॥ २२ ॥",
        hindi = """
            (6. काल की वेदान्तिक परिभाषा): यह वह परम तत्व है जो पलक झपकने (निमेष) मात्र के समय में ब्रह्मा आदि सभी देवताओं की उत्पत्ति और नाश कर देता है।
            उस एक अद्वितीय (अद्वय) और अखंड आनंद-स्वरूप (अखंडानंद) परब्रह्म को ही सच्चे ज्ञानियों द्वारा असली 'काल' (Time) कहा गया है।
            साधारण योग में 'काल' का अर्थ है ध्यान के लिए शुभ मुहूर्त (जैसे सुबह 4 बजे या शाम का समय) तय करना।
            पर उपनिषद कहता है कि घड़ी का समय एक बहुत ही छोटा और झूठा भ्रम है जो सूरज और धरती के घूमने से बना है।
            असली 'समय' वह भगवान है जिसने इस पूरे ब्रह्मांड और समय की घड़ी को पैदा किया है।
            वह ब्रह्म समय की कैद में नहीं है; वह समय का भी महा-समय (काल का भी काल) है, जो पल भर में सृष्टि को लीन कर सकता है।
            जब साधक उस 'अखंड आनंद' (Unbroken bliss) में डूब जाता है, तो उसके लिए भूतकाल और भविष्यकाल हमेशा के लिए मिट जाते हैं।
            वहाँ केवल एक शाश्वत 'वर्तमान' (Eternal Now) बचता है, जहाँ घड़ियां और कैलेंडर पूरी तरह से अर्थहीन हो जाते हैं।
            ब्रह्म-साक्षात्कार का कोई फिक्स टाइम नहीं होता; जब मन पूरी तरह शांत हो जाए, वही सबसे शुभ और पवित्र 'काल' है।
            उस समय-रहित (Timeless) अनंत चेतना में स्थित होना ही योग के इस छठे अंग (काल) का सच्चा और परम अभ्यास है।
        """.trimIndent(),
        english = """
            (6. Vedantic Definition of Kala): It is that Supreme Principle which can create and destroy all beings, including great gods like Brahma, in a mere fraction of a second (Nimesha).
            That exact non-dual (Advaya) and unbroken, infinite bliss (Akhandananda) is exclusively declared by true sages as the real 'Time' (Kala).
            In ordinary Yoga, 'Kala' merely means fixing an auspicious physical time for meditation (like 4 AM or evening twilight).
            But the Upanishad profoundly states that clock-time is a very petty, false illusion created solely by the physical rotation of the earth and sun.
            True 'Time' is that Supreme God Himself who has actively manifested this entire universe and the very concept of the cosmic clock.
            That Brahman is absolutely not imprisoned by time; He is the ultimate Time of Time, capable of dissolving creation in a single blink.
            When the sincere seeker drowns perfectly in that 'Unbroken Bliss', past and future are completely and permanently annihilated for him.
            There remains exclusively one eternal 'Now' (Present), where physical clocks and paper calendars become utterly meaningless and irrelevant.
            There is absolutely no fixed time for Self-realization; the exact moment the mind becomes perfectly still is the most auspicious, sacred 'Kala'.
            Being perfectly established in that timeless (Timeless) infinite consciousness is the true, ultimate practice of this sixth limb of Yoga.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 23,
        sanskrit = "सुखेनैव भवेद्यस्मिन्नजस्रं ब्रह्मचिन्तनम् । आसनं तद्विजानीयादन्यत्स्यात्क्लेशकारणम् ॥ २३ ॥",
        hindi = """
            (7. आसन की वेदान्तिक परिभाषा): जिस अवस्था में साधक के लिए परब्रह्म का निरंतर (अजस्रं) और अत्यंत सुखपूर्वक चिंतन करना संभव हो जाए।
            उसी परम शांत और सुखद मानसिक अवस्था को ही ज्ञानी पुरुषों द्वारा सबसे सच्चा और श्रेष्ठ 'आसन' (Posture) जानना चाहिए।
            इसके अलावा शरीर को मोड़कर बैठने वाले अन्य सभी भौतिक आसन केवल क्लेश (पीड़ा और दुख) के ही कारण होते हैं।
            पतंजलि योग में आसन का मतलब पद्मासन या सिद्धासन में शरीर को बिना हिलाए घंटों तक बैठना होता है।
            पर उपनिषद कहता है कि अगर शरीर सीधा है लेकिन मन दुनिया के लालच और चिंताओं में टेढ़ा होकर भाग रहा है, तो वह आसन बेकार है।
            असली 'आसन' का अर्थ है अपने मन को 'ब्रह्म-विचार' की गद्दी पर अत्यंत सुख और आराम (सुखेनैव) के साथ बिठा देना।
            जब चेतना सत्य में टिक जाती है, तो इंसान चाहे चल रहा हो, लेट रहा हो या काम कर रहा हो, वह हमेशा अपने 'आसन' में ही होता है।
            शारीरिक आसनों से घुटने और कमर दर्द (क्लेश) हो सकता है, पर यह मानसिक आसन केवल और केवल परम शांति (Bliss) देता है।
            ईश्वर को पाने के लिए शरीर को टॉर्चर (Torture) करने की कोई आवश्यकता नहीं है; मन की सुखद स्थिरता ही सबसे बड़ी तपस्या है।
            ब्रह्म-चिंतन की इस अखंड और सुखमयी अवस्था में टिके रहना ही योग के इस सातवें अंग (आसन) की सच्ची सिद्धि है।
        """.trimIndent(),
        english = """
            (7. Vedantic Definition of Asana): That profound state in which the continuous (Ajasram) and completely effortless contemplation of the Supreme Brahman becomes flawlessly possible for the seeker.
            That exact supremely peaceful and blissful mental state alone should be thoroughly recognized by the wise as the truest and highest 'Asana' (Posture).
            Apart from this, absolutely all other physical postures that involve twisting the body are merely the direct cause of severe distress (Klesha/pain).
            In Patanjali Yoga, an Asana strictly means sitting physically motionless in the Lotus pose or Siddhasana for grueling hours.
            But the Upanishad fiercely declares that if the physical body is straight but the mind is running crookedly after worldly greed, that posture is utterly useless.
            The real 'Asana' profoundly means seating your mind supremely comfortably and joyfully (Sukhenaiva) directly on the majestic throne of 'Brahman-thought'.
            When consciousness is firmly anchored in Truth, whether the human is walking, lying down, or working, he is permanently established in his 'Asana'.
            Physical postures can easily cause severe knee and back pain (Klesha), but this ultimate mental posture grants absolutely nothing but supreme, infinite peace.
            There is absolutely no need to brutally torture the physical body to attain God; the blissful, effortless steadiness of the mind is the greatest penance.
            Remaining flawlessly established in this unbroken, joyful state of Brahman-contemplation is the true, ultimate perfection of this seventh limb of Yoga.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 24,
        sanskrit = "सिद्धं यत्सर्वभूतादि विश्वाधिष्ठानमव्ययम् । यस्मिन् सिद्धाः समाविष्टास्तत्सिद्धासनमुच्यते ॥ २४ ॥",
        hindi = """
            (सिद्ध आसन की विशेष परिभाषा): जो परब्रह्म सभी भौतिक प्राणियों और संपूर्ण जगत का मूल कारण (आदि) है।
            जो इस पूरे ब्रह्मांड का एकमात्र आधार (विश्वाधिष्ठान) है और जो हमेशा अव्यय (कभी नष्ट न होने वाला) है।
            जिस असीम और शाश्वत ब्रह्म के भीतर सभी महान सिद्ध पुरुष (ज्ञानी) पूरी तरह से समाविष्ट (लीन) हो चुके हैं।
            उसी परम सत्य के साथ अपनी चेतना को जोड़ लेना ही सच्चे योगियों द्वारा वास्तविक 'सिद्धासन' कहा गया है।
            हठयोग में 'सिद्धासन' एक खास तरीके से पैर मोड़कर बैठने की क्रिया है जो कुंडलिनी जगाने के लिए की जाती है।
            पर वेदान्त में शरीर को मोड़ना सिद्धासन नहीं है; बल्कि अपनी आत्मा को 'सिद्ध' (परमात्मा) में पूरी तरह से विलीन कर देना असली सिद्धासन है।
            यह ब्रह्मांड किसी शून्य पर नहीं टिका है; इसका अधिष्ठान (Base) वह चैतन्य ब्रह्म है जो कभी नहीं बदलता।
            जब साधक यह जान लेता है कि "मैं भी उसी ब्रह्म का हिस्सा हूँ जहाँ सारे सिद्ध संत गए हैं", तो उसका सारा डर खत्म हो जाता है।
            यह सिद्धासन शरीर की कसरत नहीं, बल्कि मन की वह पूर्ण विश्राम-अवस्था है जहाँ कोई भी बाहरी क्रिया बाकी नहीं रहती।
            जब मन अपने असली घर (ब्रह्म) में जाकर हमेशा के लिए बैठ जाता है, तभी योग का यह अत्यंत पवित्र सिद्धासन सिद्ध (सफल) होता है।
        """.trimIndent(),
        english = """
            (Special Definition of Siddhasana): That Supreme Brahman who is the absolute root cause (Origin) of all physical beings and the entire world.
            Who is the sole, unchanging foundation of this entire cosmos (Vishvadhisthana) and who is eternally indestructible (Avyaya).
            That infinite and eternal Brahman within whom all the great, perfected saints (Siddhas) have become completely absorbed and merged.
            Flawlessly uniting one's own consciousness with that Supreme Truth is unequivocally declared by true Yogis as the real 'Siddhasana'.
            In Hatha Yoga, 'Siddhasana' is merely the physical act of sitting with crossed legs in a specific way to awaken the Kundalini.
            But in Vedanta, twisting the physical body is absolutely not Siddhasana; seamlessly dissolving one's Soul completely into the 'Siddha' (God) is true Siddhasana.
            This vast universe does not rest on an empty void; its ultimate Base is that purely conscious Brahman who never undergoes any change.
            When the seeker profoundly realizes, "I too am a part of that exact Brahman where all perfected saints reside," all his fear vanishes instantly.
            This Siddhasana is absolutely not a physical workout, but that state of total mental rest where zero external activity remains.
            Only exactly when the mind successfully goes and sits permanently in its true, original home (Brahman) is this highly sacred Siddhasana perfectly accomplished.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 25,
        sanskrit = "यन्मूलं सर्वलोकानां यन्मूलं चित्तबन्धनम् । मूलबन्धः सदा सेव्यो योग्योऽसौ राजयोगिनाम् ॥ २५ ॥",
        hindi = """
            (8. मूलबन्ध की वेदान्तिक परिभाषा): जो परब्रह्म इस संपूर्ण दृश्यमान ब्रह्मांड और सभी लोकों का असली 'मूल' (जड़/Root) है।
            और जो ब्रह्म अत्यंत चंचल और भटकते हुए चित्त (मन) को पूरी तरह से बाँधने और एकाग्र करने का भी एकमात्र 'मूल' कारण है।
            उसी परम ब्रह्म रूपी मूल (जड़) का निरंतर सेवन (ध्यान) करना ही वास्तविक 'मूलबन्ध' (Mula-bandha) कहलाता है।
            यही वह महान और सच्चा मूलबन्ध है जो श्रेष्ठ राजयोगियों के लिए हमेशा अभ्यास करने योग्य (योग्योऽसौ) है।
            शारीरिक योग में मूलबन्ध का अर्थ है गुदा (Anus) की मांसपेशियों को सिकोड़कर ऊर्जा (अपान वायु) को ऊपर की ओर खींचना।
            पर तेजोबिन्दु उपनिषद कहता है कि शरीर की मांसपेशियों को सिकोड़ने से संसार की गहरी समस्याएँ खत्म नहीं होतीं।
            असली 'मूल' (जड़) यह अज्ञान है जिससे दुनिया पैदा हुई है, और असली 'बन्ध' (Lock) वह ज्ञान है जो इस मन को सत्य से बाँध दे।
            जब हम पेड़ की डालियों (संसार) को छोड़कर उसकी असली जड़ (परमात्मा) को मजबूती से पकड़ लेते हैं, तो वही सच्चा मूलबन्ध है।
            एक सच्चा राजयोगी अपने शरीर को कष्ट दिए बिना सीधे अपने मन को उस अनंत स्रोत के साथ लॉक (Lock) कर देता है।
            इस वेदान्तिक मूलबन्ध के सिद्ध होते ही मन की सारी भयंकर चंचलता हमेशा के लिए रुक जाती है और परमानंद प्राप्त होता है।
        """.trimIndent(),
        english = """
            (8. Vedantic Definition of Mulabandha): That Supreme Brahman who is the actual, absolute 'Root' (Mula) of this entire visible cosmos and all worlds.
            And that Brahman who is also the absolute root cause for perfectly binding and concentrating the highly restless, wandering mind (Chitta).
            Continuously meditating upon and thoroughly absorbing that Supreme Brahman as the ultimate Root is the true 'Mula-bandha' (Root Lock).
            This, and strictly this alone, is that magnificent and genuine Mulabandha which is always entirely worthy of practice for the greatest Raja Yogis.
            In physical Yoga, Mulabandha strictly means violently contracting the anal muscles to forcefully pull the downward energy (Apana) upwards.
            But the Tejobindu Upanishad profoundly declares that merely squeezing physical body muscles absolutely does not end the world's deep problems.
            The real 'Root' is the ignorance from which the world sprouted, and the real 'Lock' is the supreme wisdom that binds the mind to Truth.
            When we completely abandon the branches of the tree (world) and tightly grasp its original Root (God), that is the genuine Mulabandha.
            A true Raja Yogi, entirely without torturing his physical body, locks his mind directly and flawlessly with that infinite cosmic Source.
            The exact moment this Vedantic Mulabandha is perfected, all severe mental restlessness stops permanently forever and supreme bliss is attained.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 26,
        sanskrit = "अङ्गानां समतां विद्यात्समे ब्रह्मणि लीनताम् । नो चेदृजुत्वं शुष्कमिव वृक्षस्य न समानता ॥ २६ ॥",
        hindi = """
            (9. देहसाम्य की वेदान्तिक परिभाषा): इस भौतिक शरीर और इसके सभी अंगों को एक समान रूप से उस ब्रह्म में विलीन कर देना।
            अर्थात, अपनी चेतना को उस अत्यंत सम (समान और निर्विकार) परब्रह्म में पूरी तरह से लीन (लीनताम्) कर देना ही सच्चा 'देहसाम्य' है।
            यदि साधक ऐसा नहीं करता, तो केवल शरीर को सीधा (ऋजुत्वं) तान कर बैठने से कोई आध्यात्मिक समानता या सिद्धि नहीं मिलती।
            जैसे एक सूखे हुए पेड़ (शुष्क वृक्ष) का तना बिल्कुल सीधा खड़ा रहता है, पर उसमें कोई जीवन या 'समानता' (समत्व भाव) नहीं होता।
            साधारण हठयोग में देहसाम्य का मतलब है रीढ़ की हड्डी (Spine), गर्दन और सिर को बिल्कुल एक सीधी रेखा में तान कर बैठना।
            उपनिषद इस धारणा पर सीधा प्रहार करता है कि केवल शरीर को सीधा रखने से कोई ज्ञानी नहीं बन जाता; मुर्दा या सूखा पेड़ भी सीधा ही होता है।
            असली 'बैलेंस' (Balance / समता) तब आता है जब इंसान दुनिया के हर सुख और दुख को एक समान (Equal) भाव से देखने लगता है।
            जब शरीर का अहंकार टूटकर उस सम-ब्रह्म (जो सबमें एक है) में पिघल जाता है, तो इंसान का अंदरूनी ढांचा पूरी तरह सीधा हो जाता है।
            ध्यान में शरीर का अकड़ना (Stiffness) योग नहीं है; मन का उस असीम शांति में पूरी तरह रिलैक्स (Relax) हो जाना असली योग है।
            देहसाम्य का असली अर्थ है—यह महसूस करना कि यह देह (शरीर) भी उसी ब्रह्म का हिस्सा है और उससे अलग कुछ भी नहीं है।
        """.trimIndent(),
        english = """
            (9. Vedantic Definition of Dehasamya): Flawlessly dissolving this physical body and all its limbs equally into that Supreme Brahman.
            Meaning, completely and perfectly merging (Linatam) one's consciousness into that supremely equal (unwavering) Brahman is true 'Dehasamya' (Bodily Equipoise).
            If the seeker absolutely fails to do this, merely sitting with the physical body held perfectly straight (Rijutvam) grants zero spiritual equality or perfection.
            Just exactly as the trunk of a completely dried-up, dead tree (Shushka Vriksha) stands perfectly straight, but possesses absolutely no life or true 'Equality'.
            In ordinary Hatha Yoga, Dehasamya strictly means sitting with the spine, neck, and head aligned perfectly taut in one straight physical line.
            The Upanishad strikes a direct, massive blow to this idea, stating that merely keeping the body straight doesn't make one wise; a corpse or a dry tree is also perfectly straight.
            Real 'Balance' (Equality) arrives exclusively when a human begins to view absolutely every worldly joy and agonizing sorrow with a perfectly equal, detached mind.
            When the toxic ego of the body shatters and melts seamlessly into that equal-Brahman (who is one in all), the human's internal framework becomes truly straight.
            Stiffness of the physical body during meditation is absolutely not Yoga; the mind completely and flawlessly relaxing into that infinite peace is the real Yoga.
            The absolute true meaning of Dehasamya is deeply realizing that this physical body is also a part of that exact Brahman and is absolutely nothing separate from Him.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 27,
        sanskrit = "दृष्टिं ज्ञानमयीं कृत्वा पश्येद्ब्रह्ममयं जगत् । सा दृष्टिः परमोदारा न नासाग्रावलोकिनी ॥ २७ ॥",
        hindi = """
            (10. दृक्स्थिति की वेदान्तिक परिभाषा): साधक को अपनी दृष्टि (देखने के नजरिए) को पूरी तरह से 'ज्ञानमयी' (पूर्ण विवेक से युक्त) बना लेना चाहिए।
            और ज्ञान से भरी उस दिव्य दृष्टि के द्वारा उसे इस संपूर्ण चराचर जगत (संसार) को साक्षात् 'ब्रह्ममय' (परमात्मा का ही रूप) देखना चाहिए।
            ज्ञानी पुरुषों द्वारा केवल उसी दृष्टि को ही अत्यंत श्रेष्ठ, परम उदार (विशाल) और योग की सच्ची 'दृक्स्थिति' (Vision) माना गया है।
            अपनी दृष्टि को केवल अपनी नासिका (नाक) के अग्रभाग (आगे के हिस्से) पर गड़ाकर (नासाग्रावलोकिनी) रखना कोई असली दृक्स्थिति नहीं है।
            योग की किताबों में अक्सर कहा जाता है कि ध्यान करते समय अपनी आँखें आधी खुली रखो और नाक के टिप (Tip of the nose) को देखते रहो।
            वेदान्त इस शारीरिक कसरत का घोर विरोध करता है और कहता है कि नाक को घूरने से भगवान नहीं मिलेगा, यह केवल आँख भेंगी (Cross-eyed) करने का तरीका है।
            असली दृष्टि (Vision) वह है जो दुनिया की हर चीज़—पेड़, जानवर, दुश्मन और दोस्त—सबमें केवल भगवान (ब्रह्म) को देखे।
            जब आपकी आँखें ज्ञान से भर जाती हैं, तो यह संसार कोई माया या जाल नहीं लगता, बल्कि ईश्वर का साक्षात् मंदिर दिखाई देता है।
            'उदार दृष्टि' का अर्थ है छोटी सोच (Narrow-mindedness) को छोड़कर एक अत्यंत विशाल और ब्रह्मांडीय नजरिया (Cosmic perspective) अपनाना।
            अपनी आँखों की पुतलियों को नाक पर टिकाने के बजाय, अपने मन की दृष्टि को उस अनंत सत्य पर टिकाना ही योग का यह दसवां अंग है।
        """.trimIndent(),
        english = """
            (10. Vedantic Definition of Drik-sthiti): The sincere seeker must actively transform his vision (perspective) to make it entirely 'Jnanamayi' (full of supreme wisdom and discrimination).
            And strictly through that divine, wisdom-filled vision, he must profoundly behold this entire moving and unmoving world directly as 'Brahmamaya' (the exact manifestation of God).
            Only that specific, enlightened vision alone is deeply considered by wise sages to be the absolute highest, supremely noble, and true 'Drik-sthiti' (Steadiness of Vision) in Yoga.
            Merely fixing and staring intensely with one's physical eyes strictly at the tip of one's own nose (Nasagravalokini) is absolutely not the real Drik-sthiti.
            Traditional Yoga books constantly instruct seekers to keep their eyes half-open and continuously stare at the physical tip of the nose during meditation.
            Vedanta fiercely opposes this mere physical gymnastics, declaring that staring at the nose will never reveal God; it is merely a quick way to become cross-eyed.
            The real, authentic Vision is that which flawlessly sees only God (Brahman) in absolutely everything—trees, animals, deadly enemies, and loving friends.
            When your eyes are completely flooded with wisdom, this world no longer appears as a deceptive trap, but is seen clearly as the direct, magnificent temple of God.
            A 'Noble Vision' profoundly means permanently abandoning all narrow-mindedness and fully embracing a highly expansive, infinite Cosmic Perspective.
            Instead of uselessly anchoring the physical pupils on the nose, firmly anchoring the mind's vision directly on that infinite Truth is the exact tenth limb of true Yoga.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 28,
        sanskrit = "द्रष्टृदर्शनदृश्यानां विरामो यत्र वा भवेत् । दृष्टिस्तत्रैव कर्तव्या न नासाग्रावलोकिनी ॥ २८ ॥",
        hindi = """
            (दृक्स्थिति का एक और गहरा अर्थ): जहाँ पर द्रष्टा (देखने वाला अहंकार), दर्शन (देखने की क्रिया) और दृश्य (देखी जाने वाली वस्तु) इन तीनों का पूर्ण रूप से विराम (अंत) हो जाता है।
            साधक को अपनी 'दृष्टि' (ध्यान/Vision) केवल उसी परम शून्यता और अद्वैत अवस्था (ब्रह्म) पर पूरी तरह से स्थिर करनी (कर्तव्या) चाहिए।
            केवल अपनी नाक के अगले हिस्से को घूरते (नासाग्रावलोकिनी) रहना कोई वास्तविक आध्यात्मिक दृष्टि या ध्यान बिल्कुल भी नहीं है।
            यह श्लोक 'त्रिपुटी' (Triad) के नाश का सबसे महान सिद्धांत है: जब तक 'मैं' (द्रष्टा) और 'दुनिया' (दृश्य) अलग हैं, तब तक अज्ञान है।
            ध्यान का मतलब केवल आँखों का फोकस (Focus) नहीं है, बल्कि उस स्थिति में पहुँचना है जहाँ देखने वाला ही गायब हो जाए।
            जब आप बहुत गहरी नींद में होते हैं, तो आप (द्रष्टा) और सपने की दुनिया (दृश्य) दोनों गायब हो जाते हैं, बस शांति बचती है।
            उसी तरह, जाग्रत अवस्था में भी अपने मन को उस बिंदु पर टिकाना है जहाँ सब्जेक्ट (Subject) और ऑब्जेक्ट (Object) का भेद पूरी तरह मिट जाए।
            जब मन उस अद्वैत में टिक जाता है, तो इंसान को बाहर देखने की कोई जरूरत ही नहीं पड़ती, क्योंकि बाहर और भीतर एक ही हो जाता है।
            जो लोग केवल नाक को घूरकर सोचते हैं कि वे समाधि में हैं, वे खुद को और दुनिया को मूर्ख बना रहे हैं।
            असली दृष्टि (Vision) आँखों का खेल नहीं है, यह मन का उस असीम सत्य में पूरी तरह से घुल (Dissolve) जाना है।
        """.trimIndent(),
        english = """
            (Deeper meaning of Drik-sthiti): That absolute state where the Drashta (the Seer/Ego), the Darshana (the process of seeing), and the Drishya (the seen object) all come to a complete, final end (Virama).
            The seeker must actively and firmly fix (Kartavya) his 'Vision' (meditation/Drishti) exclusively upon that supreme void and non-dual state (Brahman) alone.
            Merely continuously staring with physical eyes strictly at the tip of one's own nose (Nasagravalokini) is absolutely not any real spiritual vision or meditation whatsoever.
            This verse presents the most magnificent principle of the destruction of the 'Triputi' (Triad): as long as 'I' (Seer) and the 'World' (Seen) are separate, ignorance reigns.
            Meditation does not merely mean the physical focus of the eyes, but successfully reaching that exact state where the 'Viewer' himself entirely disappears.
            When you are in very deep sleep, both you (the Seer) and the dream world (the Seen) vanish completely, and only pure peace remains.
            Similarly, even while fully awake, one must anchor the mind exactly at that point where the difference between Subject and Object is completely obliterated.
            When the mind anchors in that Non-duality, a human feels absolutely no need to look outside, because the outside and inside become perfectly One.
            Those who simply stare blankly at their noses and foolishly think they are in Samadhi are merely fooling themselves and the world.
            True Vision is absolutely not a cheap game of the physical eyes; it is the mind completely and flawlessly dissolving into that infinite Truth.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 29,
        sanskrit = "चित्तादिसर्वभावेषु ब्रह्मत्वेनैव भावनात् । निरोधः सर्ववृत्तीनां प्राणायामः स उच्यते ॥ २९ ॥",
        hindi = """
            (11. प्राणायाम की वेदान्तिक परिभाषा): अपने चित्त (मन) और ब्रह्मांड के सभी प्रकार के भावों (पदार्थों और विचारों) में।
            "यह सब कुछ केवल ब्रह्म (ईश्वर) ही है"—ऐसी अत्यंत दृढ़ भावना (भावनात्) को निरंतर बनाए रखना।
            इस ईश्वरीय भावना के द्वारा मन की सभी चंचल और सांसारिक वृत्तियों (विचारों) का पूरी तरह से रुक जाना (निरोधः) ही।
            सच्चे योगियों द्वारा असली और सर्वोच्च 'प्राणायाम' (Pranayama) कहा जाता है (स उच्यते)।
            शारीरिक योग में 'प्राणायाम' का मतलब होता है नाक से साँस खींचना, उसे अंदर रोकना और फिर धीरे-धीरे बाहर छोड़ना।
            परंतु उपनिषद यहाँ एक बहुत बड़ा बम फोड़ता है: केवल फेफड़ों (Lungs) में हवा भरने से मन की गंदगी साफ नहीं होती!
            असली सांस लेना वह है जहाँ आपकी हर साँस में यह विचार आए कि "इस दुनिया में केवल भगवान ही सच है।"
            जब इंसान को हर जगह, हर व्यक्ति में और हर परिस्थिति में ब्रह्म ही दिखने लगता है, तो उसके मन की सारी फालतू लहरें (वृत्तियाँ) खुद-ब-खुद मर जाती हैं।
            जब वृत्तियाँ मर जाती हैं, तो प्राण (Breath) अपने-आप शांत और सूक्ष्म हो जाता है।
            इसलिए 'सांसों को जबरदस्ती रोकने' के बजाय 'गलत विचारों को रोकना' ही वेदान्त का सच्चा और असली प्राणायाम है।
        """.trimIndent(),
        english = """
            (11. Vedantic Definition of Pranayama): In one's own mind (Chitta) and in absolutely all existing states, objects, and thoughts of the cosmos.
            Continuously maintaining the extremely firm, unwavering conviction (Bhavanat) that "Absolutely all of this is exclusively Brahman (God) alone."
            And strictly through this divine conviction, the complete and total cessation (Nirodhah) of all restless, worldly mental modifications (Vrittis) taking place.
            That, and strictly that alone, is profoundly declared by true Yogis to be the real and supreme 'Pranayama' (Sa uchyate).
            In physical Yoga, 'Pranayama' strictly means inhaling air through the nose, holding it forcefully inside, and then slowly exhaling it out.
            But the Upanishad drops a massive bombshell here: merely pumping air into the physical Lungs absolutely does not clean the severe filth of the mind!
            True breathing is that where, with every single breath, the profound thought arises: "In this entire world, only God is the Truth."
            When a human begins to flawlessly see Brahman everywhere, in every person and every circumstance, all useless ripples (Vrittis) of his mind automatically die.
            When the Vrittis die completely, the vital Prana (Breath) automatically and naturally becomes exceptionally calm, subtle, and still.
            Therefore, instead of 'forcefully holding the breath', actively 'stopping false worldly thoughts' is the absolute, true Pranayama of Vedanta.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 30,
        sanskrit = "निषेधनं प्रपञ्चस्य रेचकाख्यः समीरणः । ब्रह्मैवास्मीति या वृत्तिः पूरको वायुरीरितः ॥ ३० ॥",
        hindi = """
            (प्राणायाम के तीन हिस्से: रेचक, पूरक, कुम्भक की वेदान्तिक परिभाषा):
            इस सम्पूर्ण मायावी प्रपञ्च (दिखाई देने वाले झूठे संसार) का अपने मन से पूरी तरह 'निषेध' (नकारना / Rejection) कर देना ही।
            वेदान्त में 'रेचक' (साँस बाहर छोड़ना) नामक प्राणायाम कहा गया है (समीरणः)।
            तथा "मैं शरीर नहीं, मैं साक्षात् परब्रह्म ही हूँ" (ब्रह्मैवास्मीति)—मन में केवल इसी एक सत्य विचार (वृत्ति) को पूरी तरह भर लेना।
            ज्ञानी पुरुषों द्वारा असली 'पूरक' (साँस अंदर खींचना) नामक प्राणायाम बताया गया है (पूरको वायुरीरितः)।
            योग में रेचक का मतलब फेफड़ों की गंदी हवा बाहर निकालना है; पर वेदान्त कहता है कि फेफड़ों की हवा से ज्यादा खतरनाक दिमाग में भरा संसार का कूड़ा है।
            इसलिए दुनिया की मोह-माया और झूठी इच्छाओं को मन से बाहर फेंकना ही असली 'रेचक' (Exhalation) है।
            और योग में पूरक का मतलब ताजी ऑक्सीजन अंदर खींचना है; पर वेदान्त कहता है कि मन को ताजी 'सत्य की हवा' चाहिए।
            इसलिए "मैं ही ब्रह्म हूँ" इस महान और पवित्र विचार को अपने पूरे अस्तित्व में भर लेना ही असली 'पूरक' (Inhalation) है।
            जब इंसान सांसारिक विचारों को बाहर फेंकता है और ईश्वरीय विचारों को अंदर भरता है, तो उसका पूरा नर्वस सिस्टम (Nervous system) शुद्ध हो जाता है।
            यही वह प्राणायाम है जो बिना नाक पकड़े भी इंसान को चौबीसों घंटे 100% मोक्ष के रास्ते पर चलाता रहता है।
        """.trimIndent(),
        english = """
            (Vedantic definition of the three parts of Pranayama: Rechaka, Puraka, Kumbhaka):
            The absolute, total 'Negation' (Rejection / Nishedhana) of this entire illusory Prapancha (the false, visible material world) from one's own mind.
            This mental rejection alone is profoundly declared in Vedanta as the true 'Rechaka' (the exhalation of breath/Samiranah).
            And completely filling the mind exclusively with the single, absolute truthful thought (Vritti) that "I am not the body, I am indeed the Supreme Brahman" (Brahmaivasmiti).
            This exact mental filling is declared by enlightened sages to be the true 'Puraka' (the inhalation of breath/Vayuriritah).
            In Yoga, Rechaka means exhaling dirty air from the lungs; but Vedanta declares that the worldly garbage stuffed in the brain is infinitely more dangerous than lung air.
            Therefore, ruthlessly throwing the world's illusions and false desires out of the mind is the absolute, true 'Rechaka' (Exhalation).
            And in Yoga, Puraka means inhaling fresh oxygen; but Vedanta declares that the mind desperately needs the fresh 'Air of Truth'.
            Therefore, completely filling one's entire existence with the magnificent, sacred thought "I am Brahman" is the real, authentic 'Puraka' (Inhalation).
            When a human successfully throws worldly thoughts out and fills divine thoughts in, his entire Nervous System is flawlessly purified.
            This is exactly the Pranayama that, even completely without pinching the nose, keeps a human walking 100% on the path of Moksha 24 hours a day.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 31,
        sanskrit = "ततस्तद्वृत्तिनैश्चल्यं कुम्भकः प्राणसंयमः । अयं चापि प्रबुद्धानामज्ञानां घ्राणपीडनम् ॥ ३१ ॥",
        hindi = """
            "मैं ब्रह्म हूँ"—इस महान विचार (सद्वृत्ति) को मन में पूरी तरह से अचल (नैश्चल्यं) और स्थिर करके उसी में टिके रहना।
            यही वेदान्त का सच्चा 'कुम्भक' (साँस को भीतर रोककर रखना) और असली प्राण-संयम (प्राणायाम) है।
            यह महान और वास्तविक प्राणायाम केवल 'प्रबुद्ध' (जागृत और ज्ञानी) पुरुषों के लिए ही है।
            जबकि अज्ञानी और मूर्ख लोगों के लिए प्राणायाम केवल 'घ्राणपीडनम्' (अपनी ही नाक को उँगलियों से दबाकर पीड़ा देना) मात्र है।
            यह श्लोक योग की दुनिया में एक बहुत बड़ा धमाका (Explosion) है जो कोरे शारीरिक कर्मकांड की धज्जियां उड़ा देता है।
            कुम्भक का मतलब होता है साँस को अंदर होल्ड (Hold) करना। पर वेदान्त कहता है साँस होल्ड करने से कुछ नहीं होगा, 'सत्य' को होल्ड करो!
            जब "मैं ब्रह्म हूँ" का विचार मन में पूरी तरह लॉक (Lock) हो जाए और हिले नहीं, तो वही असली कुम्भक है।
            ज्ञानी पुरुष अपने मन को ज्ञान से बाँधते हैं, जबकि अज्ञानी लोग अपनी नाक को उँगलियों से कसकर दबाते (घ्राणपीडनम्) रहते हैं और सोचते हैं कि भगवान मिल जाएगा।
            साँस रोकना एक शारीरिक कसरत है जो सेहत दे सकती है, पर यह 'मोक्ष' कभी नहीं दे सकती।
            असली प्राणायाम वह है जहाँ शरीर को कोई पीड़ा (Pain) न हो, और मन ज्ञान के नशे में पूरी तरह शांत और स्थिर हो जाए।
        """.trimIndent(),
        english = """
            Making that magnificent thought "I am Brahman" absolutely motionless (Naishchalyam) and flawlessly steady, and remaining perfectly anchored strictly in it.
            This, and strictly this alone, is the true 'Kumbhaka' (Holding the breath inside) and the real Prana-samyama (Pranayama) of Vedanta.
            This magnificent and authentic Pranayama is exclusively meant only for the 'Prabuddha' (the fully awakened and truly wise sages).
            Whereas for the highly ignorant and foolish people, Pranayama is merely 'Ghranapidanam' (uselessly torturing and pinching one's own nose with fingers).
            This stunning verse is a massive Explosion in the Yoga world that completely shreds empty physical rituals into absolute pieces.
            Kumbhaka literally means Holding the breath inside. But Vedanta fiercely declares: holding the breath achieves nothing, you must Hold the 'Truth'!
            When the profound thought "I am Brahman" is completely locked in the mind and absolutely refuses to shake, that is the real Kumbhaka.
            Wise sages bind their minds firmly with profound wisdom, while ignorant fools tightly pinch their noses (Ghranapidanam), stupidly thinking they will attain God.
            Holding the breath is a mere physical workout that can certainly give health, but it can absolutely never, ever grant 'Moksha'.
            The real Pranayama is that where the physical body suffers absolutely zero pain, and the mind becomes flawlessly calm and steady, intoxicated with Truth.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 32,
        sanskrit = "विषयेष्वात्मतां दृष्ट्वा मनसश्चितिमज्जनम् । प्रत्याहारः स विज्ञेयोऽभ्यसनीयो मुमुक्षुभिः ॥ ३२ ॥",
        hindi = """
            (12. प्रत्याहार की वेदान्तिक परिभाषा): इस संसार के सभी बाहरी विषयों (वस्तुओं, व्यक्तियों और परिस्थितियों) में।
            साक्षात् अपनी ही आत्मा (परमात्मा) के दर्शन करके (दृष्ट्वा), अपने मन को उस शुद्ध चेतना (चिति) में पूरी तरह से डुबो (मज्जनम्) देना।
            महान ज्ञानियों द्वारा इसी अवस्था को ही असली 'प्रत्याहार' (Pratyahara) के रूप में जाना (विज्ञेय) गया है।
            और मोक्ष की तीव्र इच्छा रखने वाले मुमुक्षुओं को इसी प्रकार के प्रत्याहार का निरंतर अभ्यास (अभ्यसनीय) करना चाहिए।
            पतंजलि योग में प्रत्याहार का अर्थ है—कछुए की तरह अपनी इंद्रियों को बाहरी दुनिया (Sound, sight) से खींचकर भीतर बंद कर लेना।
            पर वेदान्त का तरीका बिल्कुल अलग और बहुत खूबसूरत है: यह कहता है कि दुनिया से भागो मत, आँखें बंद मत करो!
            बल्कि अपनी आँखें खोलो और हर चीज़ (पेड़, पत्थर, इंसान) में उसी एक भगवान (आत्मा) को देखना शुरू कर दो।
            जब आपको हर जगह केवल भगवान ही दिखेगा, तो आपका मन दुनिया की बुराइयों से अपने-आप कट जाएगा और भगवान में डूब जाएगा।
            इंद्रियों को जबरदस्ती दबाना बहुत कठिन और पीड़ादायक है; पर सबमें 'ब्रह्म' को देखना बहुत ही प्रेमपूर्ण और आसान है।
            सच्चा प्रत्याहार वह है जहाँ दुनिया मौजूद रहती है, पर वह दुनिया आपके लिए संसार न रहकर साक्षात् 'ईश्वर का रूप' बन जाती है।
        """.trimIndent(),
        english = """
            (12. Vedantic Definition of Pratyahara): In absolutely all external objects (things, people, and worldly circumstances) of this universe.
            Directly seeing and profoundly perceiving (Drishtva) one's very own Soul (God) within them, and completely drowning (Majjanum) the mind entirely in that pure Consciousness (Chiti).
            This exact, highly elevated state alone is profoundly known (Vigneyah) and declared by the great sages as the real 'Pratyahara'.
            And genuine seekers intensely desiring liberation (Mumukshus) must continuously practice (Abhyasaniya) exactly this specific type of Pratyahara.
            In Patanjali Yoga, Pratyahara strictly means violently pulling one's senses away from the external world (sound, sight) and shutting them inside exactly like a turtle.
            But Vedanta's method is completely different and incredibly beautiful: it loudly says, do not run from the world, do not shut your eyes!
            Instead, open your eyes fully and actively begin to see exactly that one God (Soul) in absolutely everything (trees, stones, humans).
            When you see exclusively God everywhere, your mind will automatically cut itself off from the world's evils and effortlessly drown entirely in God.
            Forcefully suppressing the senses is exceedingly difficult and painful; but seeing 'Brahman' in all is exceptionally loving and easy.
            True Pratyahara is exactly where the world continues to exist, but for you, it ceases to be a worldly trap and transforms flawlessly into the direct 'Form of God'.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 33,
        sanskrit = "यत्र यत्र मनो याति ब्रह्मणस्तत्र दर्शनात् । मनसो धारणं चैव धारणा सा परा मता ॥ ३३ ॥",
        hindi = """
            (13. धारणा की वेदान्तिक परिभाषा): यह चंचल मन जहाँ-जहाँ भी भाग कर जाता है (यत्र यत्र मनो याति)।
            वहाँ-वहाँ केवल और केवल साक्षात् परब्रह्म (परमात्मा) का ही दर्शन करने के अभ्यास के द्वारा।
            मन को उस ब्रह्म में ही पूरी तरह से धारण कर लेना (टिका देना / Focus करना) ही असली 'धारणा' है।
            और महान योगियों द्वारा इसी प्रकार की धारणा को सबसे श्रेष्ठ और 'परा' (सर्वोच्च) धारणा माना गया है (सा परा मता)।
            आम योग में धारणा का मतलब है मन को जबरदस्ती किसी एक बिंदु (जैसे मोमबत्ती की लौ या भ्रूमध्य) पर बाँध कर रखना।
            जब मन वहाँ से भागता है, तो साधक परेशान होता है और उसे वापस खींच कर लाता है (यह एक बहुत बड़ा संघर्ष है)।
            पर वेदान्त एक बहुत ही आज़ाद (Liberating) तरीका देता है: मन जहाँ भागना चाहता है, उसे भागने दो!
            बस एक चालाकी करो—मन जिस भी चीज़ (व्यक्ति, पैसे, विचार) पर जाकर बैठे, तुम उस चीज़ को ही 'ब्रह्म' मान लो।
            जब सब कुछ ही ब्रह्म है, तो मन जहाँ भी जाएगा, वह ब्रह्म पर ही जाकर टिकेगा; वह ब्रह्म के बाहर जा ही नहीं सकता!
            यह धारणा (Concentration) की सबसे ऊँची (परा) तकनीक है, जहाँ मन से लड़ना खत्म हो जाता है और ध्यान चौबीसों घंटे (24/7) चलता रहता है।
        """.trimIndent(),
        english = """
            (13. Vedantic Definition of Dharana): Wherever this highly restless mind wildly runs and wanders off to (Yatra yatra mano yati).
            Strictly through the profound practice of directly beholding and seeing exclusively the Supreme Brahman (God) right there in that very place.
            Completely holding, anchoring, and fixing (Dharanam) the mind entirely upon that Brahman is the true, authentic 'Dharana'.
            And this specific, exact type of Dharana is deeply considered by the greatest Yogis to be the absolute highest, supreme, and 'Para' (ultimate) Dharana (Sa para mata).
            In common Yoga, Dharana strictly means forcefully tying the mind down to one single physical point (like a candle flame or the eyebrow center).
            When the mind naturally escapes from there, the seeker gets frustrated and forcefully drags it back (this is a massive, exhausting struggle).
            But Vedanta offers an exceptionally Liberating, brilliant method: wherever the mind desperately wants to run, let it run!
            Just apply one brilliant trick—whatever object (person, money, thought) the mind goes and sits on, you simply recognize that very object as 'Brahman'.
            When absolutely everything is Brahman, wherever the mind goes, it will inevitably land purely on Brahman; it simply cannot step outside Brahman!
            This is the absolute highest (Para) technique of Concentration (Dharana), where fighting the mind completely ends, and deep meditation flawlessly continues 24/7.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 34,
        sanskrit = "ब्रह्मैवास्मीति सद्वृत्त्या निरालम्बतया स्थितिः । ध्यानशब्देन विख्याता परमानन्ददायिनी ॥ ३४ ॥",
        hindi = """
            (14. ध्यान की वेदान्तिक परिभाषा): "निश्चित रूप से मैं साक्षात् परब्रह्म ही हूँ" (ब्रह्मैवास्मीति)—केवल इसी एक शुद्ध और सत्य विचार (सद्वृत्ति) के द्वारा।
            सांसारिक विचारों और बाहरी आश्रयों से पूरी तरह मुक्त होकर उस निरालंब (बिना किसी बाहरी सहारे के) अवस्था में पूर्ण रूप से स्थित हो जाना।
            वही परम अवस्था वास्तव में 'ध्यान' (Dhyana) शब्द के नाम से पूरी दुनिया में विख्यात (प्रसिद्ध) है।
            और केवल यही असली ध्यान साधक को वह 'परमानंद' (Supreme Bliss) देने वाला है जो कभी खत्म नहीं होता।
            ध्यान का मतलब आँखें बंद करके घंटे भर बैठना या किसी कल्पना (Imagination) में खो जाना नहीं है।
            ध्यान का असली अर्थ है अपने आप को उस एक 'सद्वृत्ति' (The thought of Truth) से पूरी तरह भर लेना कि "मैं शरीर नहीं, ब्रह्म हूँ।"
            'निरालंब' का अर्थ है—मन को टिकने के लिए किसी मूर्ति, मंत्र या श्वास के सहारे की भी जरूरत न पड़ना।
            जब मन बिना किसी बैसाखी (Crutch) के अपने ही आत्म-स्वरूप में खड़ा हो जाता है, तो वह सच्चा ध्यान है।
            यह ध्यान कोई बोरिंग (Boring) काम नहीं है; यह 'परमानंददायिनी' है, यानी यह दुनिया का सबसे सुखद और रसीला अनुभव है।
            जब यह विचार पक्का हो जाता है कि 'मैं ही ईश्वर हूँ', तो इंसान के सारे दुख और डर हमेशा के लिए भाप बनकर उड़ जाते हैं।
        """.trimIndent(),
        english = """
            (14. Vedantic Definition of Dhyana): "I am undoubtedly and certainly the Supreme Brahman Himself" (Brahmaivasmiti)—strictly through this one single pure, truthful thought (Sadvritti).
            Becoming completely and flawlessly established in that Niralamba (Supportless/independent) state, entirely free from all worldly thoughts and external dependencies.
            That exact supreme state is in reality universally famous and widely renowned (Vikhyata) by the sacred word 'Dhyana' (Meditation).
            And strictly this authentic meditation alone is the absolute bestower of that 'Supreme Bliss' (Paramananda) which simply never ends.
            Meditation absolutely does not mean merely sitting for an hour with closed eyes or getting deeply lost in some wild Imagination.
            The real meaning of meditation is completely filling oneself entirely with that one 'Sadvritti' (Thought of Truth) that "I am not the body, I am Brahman."
            'Niralamba' profoundly means—the mind no longer requiring the crutch or support of any physical idol, chanted mantra, or even the breath to stay anchored.
            When the mind effortlessly stands entirely on its own true Soul-nature completely without any crutches, that is genuine meditation.
            This meditation is absolutely not a Boring task; it is 'Paramanandadayini', meaning it is the absolute most joyful, juicy experience in the world.
            When this single thought permanently solidifies that 'I myself am God', absolutely all human sorrows and terrifying fears instantly vaporize forever.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 35,
        sanskrit = "निर्विकारतया वृत्त्या ब्रह्माकारतया पुनः । वृत्तिविस्मरणं सम्यक् समाधिर्ज्ञानसंज्ञकः ॥ ३५ ॥",
        hindi = """
            (15. समाधि की वेदान्तिक परिभाषा): जब मन की वह सद्वृत्ति ("मैं ब्रह्म हूँ") पूरी तरह से निर्विकार (अचल/बिना किसी बदलाव के) हो जाती है।
            और जब वह मन पूरी तरह से 'ब्रह्माकार' (साक्षात् ब्रह्म के ही आकार और रूप वाला) बन जाता है।
            उस अवस्था में, स्वयं उस 'वृत्ति' (यह विचार कि "मैं ध्यान कर रहा हूँ") का भी पूरी तरह से भूल जाना (विस्मरणं सम्यक्)।
            यानी जब ध्याता (ध्यान करने वाला) खुद को भी भूल जाए—उसी परम शून्य अवस्था को ज्ञानियों द्वारा असली 'समाधि' (Samadhi) कहा गया है।
            यह योग के 15वें और सबसे अंतिम अंग की सबसे सटीक और वैज्ञानिक (Scientific) परिभाषा है।
            शुरुआत में हमें खुद को याद दिलाना पड़ता है कि "मैं ब्रह्म हूँ"; यह एक प्रयास (Effort) है जिसे 'वृत्ति' कहते हैं।
            पर जब यह प्रयास इतना गहरा हो जाए कि मन पूरी तरह से ब्रह्म के सांचे (Mould) में ढलकर ब्रह्माकार हो जाए।
            तो अंत में वह 'याद दिलाने वाला विचार' (वृत्ति) भी वैसे ही मिट जाता है जैसे आग कपूर को जलाकर खुद भी बुझ जाती है।
            जब आपको यह भी याद न रहे कि "मैं समाधि में हूँ", और केवल एक अनंत सन्नाटा और पूर्णता बच जाए, तो वही असली समाधि है।
            यहाँ पहुँचकर योग पूरा हो जाता है; जीव और शिव के बीच की आखिरी दीवार भी टूटकर राख हो जाती है।
        """.trimIndent(),
        english = """
            (15. Vedantic Definition of Samadhi): When that pure thought ("I am Brahman") becomes entirely Nirvikara (absolutely motionless and completely free from any change).
            And when that mind flawlessly and completely assumes the exact 'Brahmakara' (taking the absolute shape, form, and nature of Brahman Itself).
            In that supreme state, the complete and total forgetting (Vismaranam samyak) of even that very 'Vritti' (the conscious thought that "I am meditating").
            Meaning, when the meditator completely forgets even his own existence—that absolute zero state is declared by the wise as true 'Samadhi'.
            This is the absolute most precise and highly scientific definition of the 15th and final, ultimate limb of Yoga.
            In the beginning, we must constantly make an Effort to remind ourselves that "I am Brahman"; this effort is called a 'Vritti'.
            But when this effort becomes so infinitely deep that the mind is poured completely into the mold of Brahman and becomes Brahmakara.
            Then ultimately, even that 'reminding thought' (Vritti) completely vanishes, exactly as fire entirely burns the camphor and then extinguishes itself.
            When you don't even remember that "I am in Samadhi", and exclusively an infinite silence and total completeness remains, that is real Samadhi.
            Reaching here, Yoga is completely finished; the absolute final wall standing between the individual soul and Shiva shatters into mere ashes.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 36,
        sanskrit = "इमं चाकृत्रिमानन्दं तावत्साधु समभ्यसेत् । वश्यो यावत्क्षणात्पुंसः प्रयुक्तः सन्भवेत्स्वयम् ॥ ३६ ॥",
        hindi = """
            साधक को इस अत्यंत शुद्ध और 'अकृत्रिम आनंद' (Artificial या बाहरी साधनों से न मिलने वाला असली सुख) का तब तक भलीभांति (साधु) अभ्यास (समभ्यसेत्) करना चाहिए।
            जब तक कि यह परम अवस्था उस मनुष्य के पूरी तरह से वश (Control) में न आ जाए।
            और जब तक कि केवल इच्छा करते ही (प्रयुक्तः सन्), पलक झपकते ही (क्षणात्), यह समाधि की अवस्था स्वयं (अपने-आप) ही प्रकट न होने लगे।
            वेदान्त यह स्पष्ट करता है कि समाधि का एक या दो बार अनुभव हो जाना ही काफी नहीं है; यह कोई लॉटरी (Lottery) नहीं है।
            शुरुआत में मन बहुत मेहनत के बाद मुश्किल से एकाग्र होता है और वह शांति कुछ ही पलों के लिए टिकती है।
            इसलिए उपनिषद निर्देश देता है कि इस आनंद (ध्यान) का 'निरंतर' अभ्यास तब तक करो जब तक यह तुम्हारी दूसरी प्रकृति (Second nature) न बन जाए।
            'अकृत्रिम आनंद' का मतलब है वह सुख जो पैसे, शराब या किसी इंसान से नहीं मिलता; जो पूरी तरह से Natural और तुम्हारा अपना है।
            अभ्यास की पूर्णता (Perfection) तब मानी जाती है जब आपको ध्यान में जाने के लिए 1 घंटे का वार्म-अप (Warm-up) न करना पड़े।
            बल्कि आप जैसे ही चाहें, एक ही सेकंड (क्षणात्) में आपका मन दुनिया से कटकर उस शून्य (समाधि) में अपने-आप (स्वयम्) चला जाए।
            जब यह 'रिमोट कंट्रोल' (Remote control) आपके हाथ में आ जाए, तभी आप योग में वास्तव में सफल माने जाते हैं।
        """.trimIndent(),
        english = """
            The sincere seeker must thoroughly and properly (Sadhu) practice (Samabhyaset) this incredibly pure and 'Akrtrima Ananda' (real, non-artificial bliss not derived from any external objects).
            Exactly and continuously until this supreme state comes completely and permanently under that human's absolute, flawless control (Vashya).
            And strictly until, merely upon willing it (Prayuktah san), this deep state of Samadhi successfully manifests effortlessly and automatically (Svayam) in a mere split-second (Kshanat).
            Vedanta makes it crystal clear that experiencing Samadhi just once or twice is absolutely not enough; it is not a lucky Lottery.
            In the beginning, the mind concentrates only after immense, grueling effort, and that profound peace lasts for merely a few fleeting moments.
            Therefore, the Upanishad strictly instructs to practice this bliss (meditation) 'continuously' until it flawlessly becomes your very Second Nature.
            'Akrtrima Ananda' profoundly means that joy which is not obtained from money, alcohol, or humans; which is 100% Natural and entirely your own.
            Absolute Perfection of practice is strictly considered only when you do not need a 1-hour physical Warm-up just to enter deep meditation.
            Rather, the exact moment you desire it, your mind effortlessly cuts off from the world and automatically (Svayam) drops into that void (Samadhi) in a single second (Kshanat).
            Only exactly when this absolute 'Remote Control' permanently comes into your firm hands are you truly considered successful in Yoga.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 37,
        sanskrit = "ततः साधननिर्मुक्तः सिद्धो भवति योगिराट् । तत्स्वरूपं न चैतस्य विषयो मनसो गिराम् ॥ ३७ ॥",
        hindi = """
            जब वह समाधि इस प्रकार पलक झपकते ही अपने-आप सिद्ध (सफल) होने लगती है, तब वह योगी सभी प्रकार के 'साधनों' (Tools / अभ्यासों) से पूरी तरह मुक्त (निर्मुक्त) हो जाता है।
            और वह एक पूर्ण रूप से सिद्ध (Perfected) और महान 'योगिराट्' (योगियों का राजा / King of Yogis) बन जाता है।
            उस योगिराज का वह परम सत्य और साक्षात् 'स्वरूप' (True Nature) कैसा होता है? 
            वह परम स्वरूप न तो इस साधारण 'मन' के सोचने का विषय (विषयो मनसो) है, और न ही उसे 'वाणी' (गिराम् / शब्दों) के द्वारा कभी समझाया जा सकता है।
            यह श्लोक योग की अंतिम और सर्वोच्च मास्टर डिग्री (Ph.D. of Yoga) का वर्णन करता है।
            जब कोई व्यक्ति 'योगिराट्' बन जाता है, तो उसे ध्यान करने के लिए आसन बिछाने, आँखें बंद करने या मंत्र जपने की कोई आवश्यकता नहीं होती (साधन-निर्मुक्त)।
            ध्यान अब उसके लिए कोई 'क्रिया' (Action) नहीं रहा, बल्कि ध्यान उसका 'स्वभाव' (Nature) बन चुका है; वह चलते-फिरते भी समाधि में ही रहता है।
            दुनिया वाले अक्सर ज्ञानी से पूछते हैं कि "तुम्हें भगवान कैसा दिखता है? उसका वर्णन करो।"
            पर उपनिषद कहता है कि वह अनुभव इतना विशाल और असीम है कि दुनिया की कोई भी डिक्शनरी (Dictionary) उसे शब्दों में बयान नहीं कर सकती।
            दिमाग केवल सीमित (Limited) चीजों को समझ सकता है; वह अनंत (Infinite) की गहराई को नापने में पूरी तरह फेल (Fail) हो जाता है।
        """.trimIndent(),
        english = """
            When that Samadhi thus begins to naturally perfect itself automatically in a mere blink of an eye, that Yogi becomes completely and permanently free (Nirmukta) from absolutely all 'Sadhanas' (Tools / spiritual practices).
            And he flawlessly and undeniably becomes an absolutely perfected (Siddha), magnificent 'Yogirat' (the supreme King of all Yogis).
            What exactly is that ultimate Truth and direct 'Svarupa' (True Nature) of that magnificent Yogiraj like?
            That supreme true nature is absolutely not a subject for this ordinary, limited 'Mind' to think about (Vishayo manaso), nor can it ever be explained or described by 'Speech' (Giram / words).
            This spectacular verse describes the absolute final and supreme Master's Degree (Ph.D. of Yoga) of the spiritual journey.
            When a person successfully becomes a 'Yogirat', he has absolutely zero need to lay down a mat, close his eyes, or chant mantras to meditate (Sadhana-nirmukta).
            Meditation is no longer an 'Action' (Kriya) for him at all, but meditation has flawlessly become his very 'Nature' (Svabhava); he remains permanently in Samadhi even while walking and moving.
            Worldly people often foolishly ask the realized sage, "What does God look like to you? Please describe Him."
            But the Upanishad boldly declares that the experience is so incredibly vast and infinite that absolutely no Dictionary in the world can capture it in mere words.
            The brain can only successfully comprehend highly Limited things; it completely and utterly Fails to measure the profound depths of the Infinite.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 38,
        sanskrit = "समाधौ क्रियमाणे तु विघ्नान्यायान्ति वै बलात् । अनुसन्धानराहित्यमालस्यं भोगलालसम् ॥ ३८ ॥",
        hindi = """
            (अब ध्यान के रास्ते में आने वाली मनोवैज्ञानिक रुकावटों का वर्णन है): जब साधक पूरी लगन से इस समाधि (ध्यान) का अभ्यास कर रहा होता है।
            तब उसके मन में अत्यंत बलपूर्वक (बलात् / जबरदस्ती) कई प्रकार के भयंकर 'विघ्न' (रुकावटें / Obstacles) आकर खड़े हो जाते हैं।
            इन विघ्नों में सबसे पहला है 'अनुसन्धानराहित्य' (ब्रह्म के चिंतन या लक्ष्य से भटक जाना / Loss of focus)।
            दूसरा बड़ा विघ्न है 'आलस्य' (शरीर और मन में सुस्ती और भारीपन आ जाना)।
            और तीसरा सबसे खतरनाक विघ्न है 'भोगलालसा' (संसार के सुखों और वासनाओं को भोगने की तीव्र इच्छा का अचानक जाग उठना)।
            उपनिषद बहुत ही प्रैक्टिकल (Practical) है; यह जानता है कि मोक्ष का रास्ता फूलों की सेज नहीं है।
            जैसे ही आप आँख बंद करके ध्यान करने बैठते हैं, आपका अपना ही दिमाग आपका सबसे बड़ा दुश्मन बनकर आप पर हमला (बलात्) करता है।
            सबसे पहले आपका फोकस (Focus) टूटता है और आप ध्यान छोड़कर पुरानी यादों या ख्यालों में खो जाते हैं (अनुसन्धानराहित्य)।
            अगर आप उससे बच गए, तो शरीर में भयंकर आलस आता है और नींद आपको गिराने की कोशिश करती है।
            और अगर नींद से भी बच गए, तो अचानक मन में पैसे, काम-वासना या किसी स्वादिष्ट खाने की अत्यंत तीव्र लालसा (Craving) पैदा हो जाती है।
            यह कोई बाहरी शैतान नहीं, बल्कि हमारे ही अवचेतन मन (Subconscious) का कचरा है जो बाहर आ रहा है।
        """.trimIndent(),
        english = """
            (Now describing the severe psychological obstacles on the path of meditation): When the sincere seeker is diligently and actively practicing this deep Samadhi (Meditation).
            Then, extremely forcefully and violently (Balat), many terrifying and highly dangerous 'Vighnas' (Obstacles / Hindrances) suddenly arise and stand in his mind.
            Among these obstacles, the absolute first is 'Anusandhanarahitya' (completely wandering away from the contemplation of Brahman or entirely losing the primary focus).
            The second massive obstacle is 'Alasya' (deep laziness, severe lethargy, and extreme heaviness enveloping the body and mind).
            And the third, most lethal obstacle is 'Bhogalalasam' (the sudden, extremely intense awakening of a burning craving to enjoy worldly pleasures and lusts).
            The Upanishad is exceptionally Practical; it knows perfectly well that the path to Moksha is absolutely not a bed of roses.
            The exact moment you close your eyes and sit to meditate, your very own brain instantly becomes your absolute worst enemy and violently attacks you (Balat).
            First, your sharp Focus breaks entirely, and abandoning meditation, you get completely lost in old memories or random thoughts (Anusandhanarahitya).
            If you somehow survive that, terrifying laziness hits the physical body, and heavy sleep desperately tries to knock you down.
            And if you survive sleep, suddenly an extremely intense craving (Lalasa) for money, lust, or tasty food violently erupts in the mind.
            This is absolutely no external devil; it is simply the toxic garbage of our very own Subconscious mind aggressively surfacing.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 39,
        sanskrit = "लयस्तमश्च विक्षेपो रसास्वादश्च शून्यता । एवं यद्विघ्नबाहुल्यं त्याज्यं ब्रह्मविदा शनैः ॥ ३९ ॥",
        hindi = """
            (ध्यान के विघ्नों की सूची जारी है): चौथा विघ्न है 'लय' (मन का निद्रा या बेहोशी में डूब जाना)।
            पांचवां 'तमस' (अज्ञान और अंधकार का छा जाना), छठा 'विक्षेप' (मन का बहुत अधिक चंचल होकर इधर-उधर भागना)।
            सातवां विघ्न है 'रसास्वाद' (ध्यान में मिलने वाले छोटे-मोटे सुखों या चमत्कारों में ही उलझकर रुक जाना)।
            और आठवां विघ्न है 'शून्यता' (मन का बिल्कुल ब्लैंक/Blank हो जाना जिसे अज्ञानी लोग समाधि समझ लेते हैं)।
            इस प्रकार इन बहुत सारे भयंकर विघ्नों (विघ्नबाहुल्यं) की जो फ़ौज है, ब्रह्म को जानने वाले साधक (ब्रह्मवित्) को।
            अत्यंत सावधानी और विवेक के साथ धीरे-धीरे (शनैः) इन सभी रुकावटों को पूरी तरह से त्याग (त्याज्यं) देना चाहिए।
            ध्यान में 'लय' (नींद) और 'विक्षेप' (चंचलता) सबसे आम बीमारियां हैं; मन या तो सो जाता है या फिर बंदर की तरह कूदने लगता है।
            'रसास्वाद' बहुत खतरनाक है: जब ध्यान में थोड़ा सा अच्छा लगने लगता है (शांति या लाइट दिखती है), तो साधक उसी 'रस' में फँस जाता है और आगे नहीं बढ़ता।
            'शून्यता' का मतलब है दिमाग का सुन्न (Numb) हो जाना; यह मोक्ष नहीं है, यह केवल एक जड़ (Inert) अवस्था है।
            उपनिषद कहता है कि इन दुश्मनों से घबराकर भागना नहीं है; बल्कि धीरे-धीरे (शनैः) अपनी समझ और प्रैक्टिस (Practice) से इन्हें एक-एक करके हराना है।
        """.trimIndent(),
        english = """
            (Continuing the list of obstacles in meditation): The fourth obstacle is 'Laya' (the mind completely sinking into deep sleep or unconsciousness).
            The fifth is 'Tamas' (being overwhelmed by dark ignorance and dullness), the sixth is 'Vikshepa' (the mind becoming fiercely restless and violently running here and there).
            The seventh obstacle is 'Rasasvada' (getting disastrously entangled and stopping at the minor preliminary joys, tastes, or cheap miracles encountered in meditation).
            And the eighth obstacle is 'Shunyata' (the mind going completely blank/numb, which ignorant fools mistakenly assume to be Samadhi).
            Thus, this massive, terrifying army of numerous profound obstacles (Vighnabahulyam) must be meticulously handled by the true seeker of Brahman (Brahmavit).
            He must, with extreme caution and sharp discrimination, slowly and steadily (Shanaih) completely abandon and eradicate (Tyajyam) absolutely all these blockages.
            In meditation, 'Laya' (Sleep) and 'Vikshepa' (Restlessness) are the most common diseases; the mind either falls dead asleep or jumps wildly like a monkey.
            'Rasasvada' is highly dangerous: when meditation feels slightly good (seeing lights or feeling peace), the seeker gets trapped in that 'Juice' and stops advancing entirely.
            'Shunyata' strictly means the brain becoming totally Numb; this is absolutely not Moksha, it is merely a dead, inert state.
            The Upanishad declares that one must not panic and run from these enemies; instead, slowly (Shanaih), through profound understanding and consistent Practice, defeat them one by one.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 40,
        sanskrit = "भाववृत्त्या हि भावत्वं शून्यवृत्त्या हि शून्यता । ब्रह्मवृत्त्या हि पूर्णत्वं तथा पूर्णत्वमभ्यसेत् ॥ ४० ॥",
        hindi = """
            (यह श्लोक लॉ ऑफ अट्रैक्शन / Law of Attraction का सबसे बड़ा प्राचीन रहस्य है):
            यदि मनुष्य मन में किसी सांसारिक पदार्थ या 'भाव' की वृत्ति (विचार) करता है, तो वह निश्चित रूप से उसी भाव (पदार्थ) का रूप ले लेता है।
            यदि वह मन में 'शून्यता' (खालीपन) का विचार करता है, तो वह खुद भी पूरी तरह शून्य (जड़/सुन्न) हो जाता है।
            परंतु यदि वह अपने मन में 'ब्रह्म' (परमात्मा) की वृत्ति (विचार) करता है, तो वह निश्चित रूप से 'पूर्णत्व' (पूर्णता और परमानंद) को प्राप्त कर लेता है।
            इसलिए, साधक को हमेशा (तथा) उस 'पूर्णत्व' (अखंड ब्रह्म-भाव) का ही निरंतर अभ्यास (अभ्यसेत्) करना चाहिए।
            हमारा मन एक अत्यंत शक्तिशाली सांचा (Mould) है; हम इसमें जो भी विचार डालते हैं, हमारा जीवन बिल्कुल वैसा ही बन जाता है।
            यदि आप दिन भर पैसों और वासनाओं (भाव) के बारे में सोचेंगे, तो आप उसी कीचड़ का हिस्सा बन जाएंगे।
            यदि आप कुछ न सोचने (शून्यता) की कोशिश करेंगे, तो आपका दिमाग एक पत्थर की तरह मूर्ख (Dull) हो जाएगा।
            पर यदि आप चौबीसों घंटे यह सोचेंगे कि "मैं पूर्ण हूँ, मैं साक्षात् ब्रह्म हूँ", तो आप सच में ब्रह्मांड के मालिक बन जाएंगे।
            आप वही बनते हैं जो आप सोचते हैं (You become what you think); यही मनोविज्ञान (Psychology) का सबसे बड़ा सच है।
            इसलिए उपनिषद हमें निर्देश देता है कि अपने मन में हमेशा 'पूर्णता' (Perfection/God) का ही सॉफ्टवेयर रन (Run) करते रहो।
        """.trimIndent(),
        english = """
            (This verse is the absolute greatest ancient secret of the Law of Attraction):
            If a human being holds the Vritti (thought) of any worldly object or 'Bhava' (feeling) in his mind, he undoubtedly and certainly takes the exact form of that very object.
            If he continuously holds the thought of 'Shunyata' (Void/emptiness) in his mind, he himself becomes completely void (inert/numb).
            But if he profoundly holds the Vritti (thought) of 'Brahman' (the Supreme Lord) in his mind, he undoubtedly and successfully attains 'Purnatvam' (Absolute Fullness and Supreme Bliss).
            Therefore, the sincere seeker must always (Tatha) continuously and relentlessly practice (Abhyaset) solely that 'Purnatvam' (the unbroken state of infinite Brahman).
            Our human mind is an exceptionally powerful Mould; whatever specific thought we pour into it, our entire life flawlessly becomes exactly that.
            If you constantly think about money and intense lusts (Bhava) all day, you will inevitably become a miserable part of that very worldly mud.
            If you forcefully try to think of absolutely nothing (Shunyata), your brain will eventually become completely dull and stupid like a dead stone.
            But if you think 24/7 that "I am absolutely Complete, I am indeed Brahman," you will truly and literally become the majestic Master of the cosmos.
            You become exactly what you think; this is the absolute greatest, undeniable truth of all profound Psychology.
            Therefore, the Upanishad strictly instructs us to constantly Run the software exclusively of 'Absolute Perfection' (God) in our minds.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 41,
        sanskrit = "ये हि वृत्तिं जहत्येनां ब्रह्माख्यां पावनीं पराम् । वृथैव ते तु जीवन्ति पशुभिश्च समा नराः ॥ ४१ ॥",
        hindi = """
            जो लोग इस 'ब्रह्माख्या' (मैं ब्रह्म हूँ) नाम की अत्यंत पवित्र (पावनी) और सबसे श्रेष्ठ (परा) वृत्ति (विचार) को छोड़ (जहति) देते हैं।
            (अर्थात जो लोग यह भूल जाते हैं कि वे साक्षात् ईश्वर के अंश हैं और खुद को केवल एक शरीर मान लेते हैं)।
            वे मूर्ख लोग इस दुनिया में अपना जीवन बिल्कुल व्यर्थ (वृथैव) ही जी रहे हैं (उनके जीने का कोई अर्थ नहीं है)।
            वे मनुष्य दिखने में तो इंसान लगते हैं, पर वास्तव में वे पूरी तरह से जानवरों (पशुभिः) के ही समान (समा) हैं।
            यह उपनिषद की सबसे कठोर और कड़वी फटकार (Scolding) है उन लोगों के लिए जो केवल दुनियादारी में फँसे हैं।
            "मैं शरीर नहीं, मैं अनंत ब्रह्म हूँ"—यह एक विचार (वृत्ति) दुनिया का सबसे बड़ा 'सैनिटाइजर' (Sanitizer/पावनी) है जो दिमाग के सारे पापों को धो देता है।
            जो इंसान इस महान सोच को छोड़कर दिन-रात केवल रोटी, कपड़ा और मकान के जुगाड़ में लगा है, वह अपना जीवन बर्बाद कर रहा है।
            खाना, सोना, और बच्चे पैदा करना—यह सब काम तो जानवर (कुत्ते-बिल्लियाँ) भी बहुत अच्छी तरह कर लेते हैं।
            इंसान और जानवर में केवल एक ही फर्क है: इंसान के पास 'ब्रह्म' को जानने की बुद्धि है।
            अगर इंसान अपनी उस बुद्धि का इस्तेमाल भगवान को जानने के लिए नहीं करता, तो वह दो पैरों पर चलने वाला एक जानवर ही है।
        """.trimIndent(),
        english = """
            Those people who completely abandon and drop (Jahati) this exceptionally sacred, purifying (Pavani), and absolute highest (Para) Vritti (thought) known exactly as 'Brahmakhya' (I am Brahman).
            (Meaning, those who foolishly forget that they are the direct fragments of God and strictly consider themselves merely a physical body).
            Those ignorant fools are living their entire lives in this world absolutely and completely in vain (Vrithaiva) (their existence has zero purpose).
            Those humans may look like men from the outside, but in absolute reality, they are completely and exactly equal (Sama) to mere beasts (Pashubhih).
            This is the absolute harshest, most bitter, and fierce scolding (reprimand) by the Upanishad for those helplessly trapped purely in worldliness.
            "I am not the body, I am the infinite Brahman"—this one single thought (Vritti) is the world's greatest 'Sanitizer' (Pavani) that flawlessly washes away all sins of the brain.
            The human who drops this magnificent thought and remains engaged day and night merely in arranging food, clothing, and shelter is utterly wasting his life.
            Eating, sleeping, and reproducing—all these basic tasks are performed exceptionally well even by ordinary animals (dogs and cats).
            There is exactly only one fundamental difference between a human and an animal: the human possesses the intellect to realize 'Brahman'.
            If a human totally fails to use that intellect to know God, he is literally nothing but a mere animal walking on two legs.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 42,
        sanskrit = "ये हि वृत्तिं विजानन्ति ज्ञात्वाऽपि वर्धयन्ति ये । ते वै सत्पुरुषा धन्या वन्द्यास्ते भुवनत्रये ॥ ४२ ॥",
        hindi = """
            परंतु इसके विपरीत, जो लोग इस 'मैं ब्रह्म हूँ' वाली परम वृत्ति (विचार) को भलीभांति जान और समझ लेते हैं (विजानन्ति)।
            और इसे जानने के बाद जो लोग निरंतर अभ्यास करके अपने भीतर इस वृत्ति को और अधिक बढ़ाते (वर्धयन्ति) और मजबूत करते हैं।
            निश्चित रूप से वे ही लोग इस दुनिया में सच्चे 'सत्पुरुष' (महान संत) हैं, और उनका जीवन पूरी तरह से 'धन्य' (सफल) है।
            वे ही महान आत्माएं इन तीनों लोकों (स्वर्ग, पृथ्वी, पाताल) में सभी देवताओं और मनुष्यों द्वारा वंदनीय (पूजने योग्य) हैं।
            पिछले श्लोक में अज्ञानियों को जानवर कहा गया था, तो इस श्लोक में ज्ञानियों को तीनों लोकों का भगवान बताया गया है।
            'जानना' (Theory) काफी नहीं है; जानने के बाद उस विचार को अपने जीवन में 'बढ़ाना' (Practical application) बहुत जरूरी है।
            एक बार आपने सुन लिया कि 'आप ब्रह्म हैं', तो अब इसे अपने व्यवहार में लाइए—गुस्सा छोड़िए, डर छोड़िए, और सबसे प्यार कीजिए।
            जब यह विचार आपके खून की हर बूँद में बस जाता है, तो आप एक साधारण इंसान से 'सत्पुरुष' बन जाते हैं।
            फिर आपकी महिमा (Glory) इतनी बड़ी हो जाती है कि इंसान तो क्या, साक्षात् देवता भी आपके सामने अपना सिर झुकाते हैं (वन्द्या)।
            यही वह परम सफलता (धन्यता) है जिसके लिए यह मनुष्य का शरीर हमें दिया गया था।
        """.trimIndent(),
        english = """
            But on the absolute contrary, those people who thoroughly know and profoundly understand (Vijananti) this supreme Vritti (thought) that 'I am Brahman'.
            And after knowing it, those who rigorously and continuously practice to actively increase (Vardhayanti) and solidify this thought deep within themselves.
            Undoubtedly and certainly, they alone are the true 'Satpurushas' (great saints) in this world, and their lives are absolutely 'Dhanya' (supremely blessed and successful).
            Those magnificent souls alone are deeply worthy of being worshipped and revered (Vandya) by all gods and men throughout all the three worlds (Bhuvana-traye).
            In the previous verse, the ignorant were ruthlessly called animals, but in this verse, the wise ones are declared the absolute Gods of the three worlds.
            Merely 'Knowing' (Theory) is absolutely not enough; after knowing, actively 'Increasing' (Practical application) that thought in daily life is exceptionally vital.
            Once you have heard that 'You are Brahman', now actively bring it into your behavior—drop your anger, abandon your fear, and unconditionally love everyone.
            When this magnificent thought firmly settles into every single drop of your blood, you flawlessly transform from an ordinary human into a 'Satpurusha'.
            Then your sheer Glory becomes so incredibly immense that not just humans, but direct celestial Gods enthusiastically bow their heads before you (Vandya).
            This, and strictly this alone, is that ultimate, supreme success (Blessedness) for which this physical human body was originally given to us.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 43,
        sanskrit = "येषां वृत्तिः समा वृद्धा परिपक्वा च सा पुनः । ते वै सद्ब्रह्मतां प्राप्ता नेतरे शब्दवादिनः ॥ ४३ ॥",
        hindi = """
            जिन श्रेष्ठ साधकों के भीतर यह 'ब्रह्म-वृत्ति' (ईश्वरीय विचार) पूरी तरह से सम (समान/अचंचल), वृद्ध (बहुत अधिक बढ़ी हुई) हो जाती है।
            और फिर निरंतर अभ्यास के द्वारा जब वह वृत्ति उनके भीतर पूरी तरह से 'परिपक्व' (पक कर 100% मजबूत) हो जाती है।
            निश्चित रूप से केवल वे ही साधक साक्षात् 'सद्ब्रह्म' (परमेश्वर) के स्वरूप को प्राप्त (सफल) होते हैं।
            वे दूसरे (इतरे) पाखंडी लोग कभी ब्रह्म को प्राप्त नहीं होते, जो केवल मुँह से ज्ञान की बड़ी-बड़ी बातें (शब्दवादिनः) बनाते रहते हैं।
            यह श्लोक उन 'आध्यात्मिक तोतों' (Spiritual parrots) की पोल खोलता है जो केवल वेदान्त की बातें रट लेते हैं पर उसे जीते नहीं हैं।
            वृत्ति (विचार) का 'परिपक्व' (Mature/पक्का) होना बहुत जरूरी है।
            कच्चा विचार वैसा है कि मंदिर में तो आपको लगता है "सब ईश्वर है", पर दुकान पर जाते ही आप बेईमानी करने लगते हैं।
            पक्का विचार (परिपक्व वृत्ति) वह है जो सुख में, दुख में, नफे में और नुकसान में एक जैसा (सम) रहे, कभी न हिले।
            जब यह विचार पूरी तरह पक जाता है, तब इंसान 'शब्दों' की दुनिया से निकलकर साक्षात् 'ब्रह्म' की दुनिया में प्रवेश कर जाता है।
            केवल मुँह से "मैं ब्रह्म हूँ" चिल्लाने वाले (शब्दवादी) लोग अपने आप को धोखा दे रहे हैं, उन्हें कभी मोक्ष नहीं मिलता।
        """.trimIndent(),
        english = """
            Those excellent seekers within whom this 'Brahma-vritti' (Divine thought) becomes completely Sama (equal/unwavering) and Vriddha (immensely grown and expanded).
            And then, entirely through continuous, relentless practice, when that specific thought becomes perfectly 'Paripakva' (fully ripe, mature, and 100% solidified) within them.
            Undoubtedly and certainly, only those exact seekers flawlessly attain (Prapta) the absolute, direct state of 'Sadbrahman' (the Supreme Lord).
            Those other (Itare) hypocritical people absolutely never attain Brahman, who merely continuously make grand, empty speeches of wisdom strictly from their mouths (Shabdavadinah).
            This powerful verse brutally exposes those 'Spiritual Parrots' who merely memorize and regurgitate the words of Vedanta but absolutely fail to live them.
            The Vritti (thought) becoming 'Paripakva' (Mature/fully ripe) is exceptionally and undeniably crucial.
            A raw, unripe thought is like feeling "Everything is God" while sitting safely inside a temple, but the exact moment you reach your shop, you start violently cheating people.
            A fully ripe thought (Paripakva vritti) is that which flawlessly remains exactly the same (Sama) in joy, sorrow, profit, and heavy loss, never shaking even once.
            When this thought is completely cooked, the human permanently exits the cheap world of 'Words' and enters straight into the direct world of 'Brahman'.
            Those who merely scream "I am Brahman" from their mouths (Word-debaters) are simply deceiving themselves; they absolutely never, ever attain Moksha.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 44,
        sanskrit = "कुशला ब्रह्मवार्तायां वृत्तिहीनाः सुरागिणः । तेऽप्यज्ञानतया नूनं पुनरायान्ति यान्ति च ॥ ४४ ॥",
        hindi = """
            (उपनिषद उन झूठे ज्ञानियों की और अधिक निंदा करता है): जो लोग केवल ब्रह्म-ज्ञान की बड़ी-बड़ी 'वार्ता' (गपशप/बहस) करने में बहुत 'कुशल' (Expert/चतुर) हैं।
            परंतु जो भीतर से उस असली 'वृत्ति' (अनुभव) से पूरी तरह हीन (खाली) हैं, और जो दुनिया के भोगों में अत्यंत आसक्त (सुरागिणः / घोर लालची) हैं।
            वे पाखंडी लोग अपने उस भयंकर 'अज्ञान' (अंधेरे) के कारण, यह निश्चित (नूनं) है कि वे इस संसार में बार-बार लौटकर आते हैं (जन्म लेते हैं) और जाते हैं (मरते हैं)।
            आजकल ऐसे 'गुरुओं' और 'विद्वानों' की कोई कमी नहीं है जो माइक पर बैठकर घंटों तक आत्मा और ब्रह्म पर शानदार भाषण (वार्ता) देते हैं।
            वे बोलने में इतने 'कुशल' होते हैं कि लोग तालियां बजाते हैं; पर उनके अपने दिल में अभी भी पैसे, नाम और वासना का भारी लालच (सुरागिण) भरा होता है।
            वेदान्त स्पष्ट चेतावनी देता है कि भगवान को आपकी चालाकी भरी बातों से कोई मतलब नहीं है; वह आपका दिल देखता है।
            अगर आपके अंदर 'अनुभव' (वृत्ति) नहीं है और केवल 'लालच' है, तो आपकी सारी किताबें और भाषण कचरे के समान हैं।
            प्रकृति के कठोर नियम (Karma) ऐसे लोगों को बिल्कुल नहीं छोड़ते; उनका वह झूठा ज्ञान उन्हें मौत से नहीं बचा सकता।
            उन्हें अपने उस अज्ञान और पाखंड की सजा भुगतने के लिए बार-बार इसी दुखों से भरी दुनिया में जन्म लेना और मरना पड़ता है।
            सच्चा अध्यात्म 'बोलने' का नहीं, बल्कि 'जीने' और 'अंदर से खाली होने' का विषय है।
        """.trimIndent(),
        english = """
            (The Upanishad further condemns those false, fake scholars): Those people who are highly 'Kushala' (Expert/clever) merely in making grand 'Varta' (gossip/debates/speeches) about Brahma-Jnana.
            But who are entirely and completely empty (Hina) of that actual, real 'Vritti' (internal experience) from within, and who are intensely attached and fiercely greedy (Suraginah) for worldly pleasures.
            Those absolute hypocrites, strictly due to their terrifying 'Ignorance' (Ajnana), will undoubtedly and certainly (Nunam) return to this world repeatedly (take birth) and leave (die).
            Nowadays, there is absolutely no shortage of such fake 'Gurus' and 'Scholars' who sit on mics and deliver magnificent speeches (Varta) on the Soul and Brahman for grueling hours.
            They are so incredibly 'Expert' in speaking that crowds clap wildly; but inside their own dark hearts, the massive greed for money, fame, and heavy lust (Suraginah) is still fully packed.
            Vedanta gives a crystal-clear, fierce warning that God cares absolutely nothing for your clever, sweet words; He strictly watches your naked heart.
            If you possess zero 'Experience' (Vritti) inside and are filled solely with 'Greed', then absolutely all your massive books and grand speeches are exactly equal to useless garbage.
            The brutal, uncompromising laws of Nature (Karma) absolutely never spare such hypocrites; their fake, superficial knowledge simply cannot save them from terrifying death.
            To brutally suffer the punishment for their thick ignorance and hypocrisy, they are forced to be born and die in this miserable world over and over again.
            True spirituality is absolutely not a subject of 'Speaking', but entirely a subject of 'Living' it and becoming completely 'Empty from within'.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 45,
        sanskrit = "निमेषार्धं न तिष्ठन्ति वृत्तिं ब्रह्ममयीं विना । यथा तिष्ठन्ति ब्रह्माद्याः सनकाद्याः शुकादयः ॥ ४५ ॥",
        hindi = """
            (इसके विपरीत, जो सच्चे ज्ञानी हैं): वे अपने मन की उस 'ब्रह्ममयी वृत्ति' (मैं ब्रह्म हूँ, इस पवित्र अहसास) के बिना।
            एक 'आधे पल' (निमेषार्धं / Half a second) के लिए भी इस संसार में नहीं टिकते (अर्थात वे एक सेकंड के लिए भी भगवान को नहीं भूलते)।
            ठीक उसी प्रकार जैसे स्वयं भगवान 'ब्रह्मा' आदि महान देवता, 'सनक' आदि परम सिद्ध ऋषि, और 'शुकदेव' आदि महान परमहंस हर पल ब्रह्म-भाव में ही स्थित रहते हैं।
            यह श्लोक एक सिद्ध पुरुष (Enlightened being) के जीवन का सबसे बड़ा लक्षण (Symptom) बताता है: अखंड स्मरण।
            हम अज्ञानी लोग दिन भर में शायद 5 मिनट भगवान को याद करते हैं और बाकी 23 घंटे 55 मिनट दुनियादारी (पैसा, क्लेश) में डूबे रहते हैं।
            पर जो सच्चा ज्ञानी है, उसका कनेक्शन (Connection) भगवान के वाई-फाई (Wi-Fi) से एक सेकंड के आधे हिस्से के लिए भी डिस्कनेक्ट (Disconnect) नहीं होता।
            वह खाता है, पीता है, सोता है, पर बैकग्राउंड (Background) में उसका मन हमेशा यही गाता रहता है कि "सब ब्रह्म है।"
            सनक, नंदन, सनातन और सनत्कुमार (ब्रह्मा के चार मानस पुत्र) और ऋषि शुकदेव—ये हमारे इतिहास के सबसे महान आदर्श (Role models) हैं।
            वे कभी भी एक पल के लिए भी माया के जाल में नहीं फँसे; उनका मन हमेशा उस परम शांति में ही लॉक (Lock) रहा।
            हमें भी अपने जीवन को उसी स्तर तक उठाना है जहाँ हमारी हर साँस केवल उस सत्य की ही याद दिलाए।
        """.trimIndent(),
        english = """
            (On the absolute contrary, the true, genuine sages): Without that profound 'Brahmamayi Vritti' (the sacred, unbroken realization that I am Brahman) constantly in their minds.
            They absolutely do not exist or remain in this world for even 'Half a blink of an eye' (Nimeshardham / half a second) (Meaning, they never forget God even for a single split-second).
            Exactly in the precise same manner as the Supreme Lord 'Brahma' and other great gods, the perfected sages like 'Sanaka', and the great Paramahamsas like 'Shukadeva' permanently remain established in the Brahman-state.
            This magnificent verse powerfully reveals the absolute greatest symptom (hallmark) of the life of a perfectly Enlightened being: Unbroken remembrance.
            We ignorant fools perhaps remember God for barely 5 minutes a day, and spend the remaining 23 hours and 55 minutes completely drowned in worldly garbage (money, conflicts).
            But for the true, realized sage, his intimate Connection to God's Wi-Fi absolutely never Disconnects even for a fraction of a single second.
            He eats, he drinks, he sleeps, but running silently in the Background, his mind perpetually sings exclusively that "Everything is strictly Brahman."
            Sanaka, Sanandana, Sanatana, and Sanatkumara (the four mind-born sons of Brahma) and Sage Shukadeva—these are the absolute greatest Role Models in our entire history.
            They absolutely never fell into the deceptive trap of Maya even for a single moment; their minds remained permanently Locked strictly in that supreme peace.
            We too must actively strive to elevate our lives to that exact supreme level where absolutely every single breath reminds us exclusively of that ultimate Truth.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 46,
        sanskrit = "कार्ये कारणतायाता कारणे न हि कार्यता । कारणत्वं ततो गच्छेत्कार्याभावे विचारतः ॥ ४६ ॥",
        hindi = """
            (अब वेदान्त का एक अत्यंत गहरा तार्किक / Logical रहस्य समझाया जा रहा है):
            जो कार्य (Effect / पैदा हुई चीज़) है, उसके अंदर उसका कारण (Cause / जिससे वह पैदा हुई) हमेशा मौजूद रहता है।
            परंतु कारण (Cause) के अंदर कार्य (Effect) का होना बिल्कुल भी जरूरी नहीं है (कारण कार्य के बिना भी रह सकता है)।
            इसलिए, जब साधक गहरे 'विचार' (विवेक/Inquiry) के द्वारा इस कार्य (झूठे संसार) के अभाव (नाश) को समझ लेता है।
            तो फिर उस संसार को पैदा करने वाले 'कारणत्व' (कारण होने का भाव) का भी अपने-आप अंत (गच्छेत्) हो जाता है (और केवल शुद्ध ब्रह्म बचता है)।
            इसे एक उदाहरण से समझें: मिट्टी (कारण) से घड़ा (कार्य) बनता है। घड़े (कार्य) के अंदर मिट्टी (कारण) हमेशा मौजूद है।
            पर क्या मिट्टी के अंदर घड़े का होना जरूरी है? नहीं! मिट्टी बिना घड़े के (केवल मिट्टी के रूप में) आराम से रह सकती है।
            इसी तरह, यह संसार (घड़ा/कार्य) ब्रह्म (मिट्टी/कारण) से बना है। संसार में ब्रह्म है, पर ब्रह्म को संसार की कोई जरूरत नहीं है।
            जब योगी ध्यान (विचार) करता है, तो उसे समझ आता है कि यह संसार (कार्य) तो केवल एक झूठा रूप (Illusion) है, इसका असली सत्य केवल मिट्टी (ब्रह्म) है।
            जब मन से 'घड़े' (संसार) का ख्याल ही मिट गया, तो फिर मिट्टी को 'घड़े का कारण' (Creator) कौन कहेगा? वह तो बस शुद्ध मिट्टी (ब्रह्म) ही रह जाएगी।
            यही 'कार्य-कारण' (Cause and Effect) के जाल को तोड़ने की सबसे बड़ी दार्शनिक कुल्हाड़ी (Philosophical axe) है, जिससे इंसान सीधा अद्वैत में प्रवेश करता है।
        """.trimIndent(),
        english = """
            (Now an exceptionally profound Logical secret of Vedanta is being explained):
            In the Karya (the Effect / the created object), its Karana (the Cause / the source from which it was born) is always inherently and permanently present.
            However, it is absolutely not necessary for the Effect to exist within the Cause (the Cause can effortlessly exist completely without the Effect).
            Therefore, when the sincere seeker, strictly through profound 'Vichara' (Deep Inquiry/Discrimination), thoroughly understands the Abhava (total absence/destruction) of this Effect (the false world).
            Then the very concept of 'Karanatva' (the status of being a Cause) that produced this world also automatically comes to an absolute end (Gacchet) (leaving only the pure Brahman behind).
            Understand this flawlessly with an example: A pot (Effect) is made entirely out of clay (Cause). The clay (Cause) is perpetually present inside the pot (Effect).
            But is it absolutely necessary for a pot to exist inside the clay? No! Clay can effortlessly exist completely without any pot (purely as shapeless clay).
            Similarly, this entire world (Pot/Effect) is manufactured from Brahman (Clay/Cause). Brahman is in the world, but Brahman absolutely does not need the world at all.
            When the Yogi meditates (Inquires), he deeply realizes that this world (Effect) is merely a false form (Illusion), and its only true reality is the clay (Brahman).
            When the very thought of the 'Pot' (World) is completely erased from the mind, then who will call the clay the 'Cause of the pot' (Creator)? It will simply remain as pure clay (Brahman) alone.
            This is the absolute greatest Philosophical Axe to flawlessly shatter the complex web of 'Cause and Effect', through which a human enters straight into pure Non-duality.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 47,
        sanskrit = "अथ शुद्धं भवेद्वस्तु यद्वै वाचामगोचरम् । द्रष्टव्यं मृद्घटेनैव दृष्टान्तेन पुनः पुनः ॥ ४७ ॥",
        hindi = """
            कार्य और कारण (संसार और उसे बनाने वाले) के इस भेद के पूरी तरह मिट जाने के बाद (अथ)।
            केवल वह अत्यंत 'शुद्ध वस्तु' (परम सत्य/परब्रह्म) ही शेष बचती है, जो हमारी वाणी और शब्दों के लिए पूरी तरह 'अगोचर' (पहुँच से बाहर) है।
            साधक को 'मिट्टी और घड़े' (मृद्घटेनैव) के इस महान और सटीक दृष्टान्त (उदाहरण / Example) के द्वारा।
            उस परम शुद्ध सत्य का बार-बार (पुनः पुनः) चिंतन, विचार और साक्षात् दर्शन (द्रष्टव्यं) करना चाहिए।
            जब इंसान के दिमाग से यह सवाल ही खत्म हो जाता है कि "दुनिया किसने बनाई और क्यों बनाई?", तब जो सन्नाटा बचता है, वही 'शुद्ध वस्तु' (Pure Reality) है।
            वह सत्य इतना गहरा और विशाल है कि दुनिया की कोई भी भाषा, कोई भी किताब या कोई भी भाषण उसे 'समझा' नहीं सकता (वाचामगोचरम्)।
            उसे केवल 'महसूस' किया जा सकता है। और उसे महसूस करने का सबसे आसान तरीका (Shortcut) क्या है? 'मिट्टी और घड़ा'।
            उपनिषद कह रहा है कि इस एक उदाहरण (मिट्टी-घड़ा) को अपने दिमाग में 24 घंटे घुमाते (पुनः पुनः) रहो।
            जब भी तुम दुनिया का कोई रूप देखो (गाड़ी, घर, इंसान), तो तुरंत याद करो कि यह सिर्फ 'घड़े का डिज़ाइन' है, इसकी असली सच्चाई सिर्फ 'मिट्टी' (भगवान) है।
            यह बार-बार किया गया विचार (Contemplation) तुम्हारे दिमाग के सारे जालों को काट देगा और तुम्हें साक्षात् उस शुद्ध ब्रह्म के दर्शन करा देगा।
        """.trimIndent(),
        english = """
            After the complete and flawless obliteration of this strict division between Cause and Effect (the world and its creator) (Atha).
            Only that exceptionally 'Pure Object' (the Absolute Reality/Supreme Brahman) remains left behind, which is entirely and absolutely 'Agochara' (beyond the reach) of our speech and words.
            The sincere seeker, strictly through this magnificent and highly accurate Drishtanta (Example/Metaphor) of the 'Clay and the Pot' (Mridghatenaiva).
            Must continuously, again and again (Punah punah), deeply contemplate, intensely inquire, and directly behold (Drashtavyam) that absolute pure Truth.
            When the very question "Who created the world and why?" is permanently annihilated from a human's brain, the profound silence that remains is exactly that 'Pure Reality'.
            That Truth is so infinitely deep and colossal that absolutely no language, no book, and no grand speech in the world can ever 'explain' it (Vachamagocharam).
            It can exclusively be 'Felt'. And what is the absolute easiest Shortcut to feel it? The 'Clay and the Pot'.
            The Upanishad forcefully instructs you to keep rotating this one single example (Clay-Pot) in your brain 24 hours a day (Punah punah).
            Whenever you see any worldly form (car, house, human), instantly remember that this is merely the 'design of the pot'; its only actual, true reality is simply the 'Clay' (God).
            This repeatedly performed deep Contemplation will ruthlessly slice through all the deceptive webs of your brain and grant you the direct, living vision of that pure Brahman.
        """.trimIndent()
    ),
    TejobinduShloka(
        id = 48,
        sanskrit = "अनेनैव प्रकारेण वृत्तिर्ब्रह्मात्मिका भवेत् । उदेति शुद्धचित्तानां वृत्तिज्ञानं ततः परम् । ॐ शान्तिः शान्तिः शान्तिः ॥ ४८ ॥",
        hindi = """
            (उपसंहार): केवल इसी प्रकार के निरंतर और गहरे विचार-मंथन (अनेनैव प्रकारेण) के द्वारा ही।
            साधक की वह अज्ञानी वृत्ति (सोच) पूरी तरह से बदलकर 'ब्रह्मात्मिका वृत्ति' (मैं ही ब्रह्म हूँ, इस परम सत्य) में बदल (भवेत्) जाती है।
            जिन साधकों का चित्त (मन) इस अभ्यास के द्वारा पूरी तरह से शुद्ध (पवित्र/निर्मल) हो चुका है (शुद्धचित्तानां)।
            केवल उन्हीं के हृदय में इस परम 'वृत्ति-ज्ञान' (ब्रह्म-साक्षात्कार) का साक्षात् उदय (सूर्योदय) होता है; इसके बाद और कुछ पाना शेष नहीं रहता (ततः परम्)।
            तेजोबिन्दु उपनिषद यहाँ अपनी इस महान 'वेदान्तिक योग' की यात्रा को एक अत्यंत सुंदर और तार्किक (Logical) अंजाम पर पहुँचाता है।
            कोई भी रातों-रात भगवान नहीं बन जाता; 'इसी प्रकार' (लगातार मिट्टी-घड़े जैसे विचारों का अभ्यास करने से) ही इंसान के दिमाग की वायरिंग (Wiring) बदलती है।
            जब दिमाग की पुरानी गंदी वायरिंग (वासना, क्रोध, डर) पूरी तरह से साफ हो जाती है (शुद्धचित्त), तभी सत्य का सूरज वहाँ उग (उदेति) सकता है।
            गंदे और स्वार्थी मन में भगवान कभी प्रवेश नहीं करता।
            एक बार यह 'ब्रह्म-वृत्ति' जाग गई, तो इंसान हमेशा के लिए आज़ाद हो जाता है; यही मानव जीवन का 'द एंड' (The End) और परम लक्ष्य है।
            ॐ शांतिः शांतिः शांतिः—हमारे शरीर, मन और आत्मा में उस परब्रह्म की परम और असीम शांति हमेशा के लिए स्थापित हो जाए।
        """.trimIndent(),
        english = """
            (Conclusion): Strictly and exclusively through this exact method of continuous, profoundly deep contemplative churning (Anenaiva prakarena) alone.
            The seeker's highly ignorant Vritti (thought process) flawlessly and completely transforms (Bhavet) into the absolute 'Brahmatmika Vritti' (the supreme Truth that I am Brahman).
            Those incredibly sincere seekers whose minds (Chitta) have become entirely and flawlessly purified (immaculate) through this intense practice (Shuddhachittanam).
            Only exactly within their purified hearts does this supreme 'Vritti-Jnana' (direct realization of Brahman) actively rise like the blazing sun (Udeti); after this, absolutely nothing remains left to be attained (Tatah param).
            The Tejobindu Upanishad brings its magnificent, revolutionary journey of 'Vedantic Yoga' to an exceedingly beautiful and highly Logical conclusion right here.
            Absolutely nobody becomes God overnight; it is strictly 'through this exact method' (continuously practicing thoughts like the clay-pot) that the fundamental Wiring of a human's brain changes.
            Only exactly when the brain's old, toxic wiring (lust, anger, paralyzing fear) is completely wiped clean (Shuddhachitta), can the brilliant sun of Truth genuinely rise (Udeti) there.
            God absolutely never, ever enters a filthy, highly selfish mind.
            Once this 'Brahma-Vritti' flawlessly awakens, the human becomes completely and permanently free forever; this is 'The End' and the absolute ultimate goal of human life.
            OM Peace, Peace, Peace—May the supreme, infinite, and unbroken peace of that Supreme Brahman be permanently established in our body, mind, and immortal soul forever.
        """.trimIndent()
    )
)