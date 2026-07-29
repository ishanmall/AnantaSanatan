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
data class IshaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IshaUpanishadScreen() {
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
                // Isha Upanishad has exactly 18 shlokas
                if (shlokaNumber != null && shlokaNumber in 1..ishaShlokasList.size) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-18)") },
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
            itemsIndexed(ishaShlokasList) { _, shloka ->
                IshaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun IshaShlokaCard(shloka: IshaShloka) {
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

val ishaShlokasList: List<IshaShloka> = listOf(
    IshaShloka(
        id = 1,
        sanskrit = "ॐ ईशा वास्यमिदँ सर्वं यत्किञ्च जगत्यां जगत् ।\nतेन त्यक्तेन भुञ्जीथा मा गृधः कस्यस्विद्धनम् ॥ १ ॥",
        hindi = """
            इस संपूर्ण ब्रह्मांड में जो कुछ भी जड़ या चेतन स्वरूप में विद्यमान है, वह सब साक्षात् परमेश्वर (ईश्वर) के द्वारा ही व्याप्त और आच्छादित है। यहाँ जो कुछ भी हिलता-डुलता या स्थिर है, वह ईश्वर का ही घर है। 
            जब तुम यह जान लेते हो कि यह पूरी सृष्टि केवल भगवान की है और तुम्हारा यहाँ अपना कुछ भी नहीं है, तो तुम्हें इस संसार का उपभोग 'त्याग' की भावना के साथ करना चाहिए। 
            हे मनुष्य! तुम कभी भी किसी दूसरे के धन या संपदा का लालच मत करो, क्योंकि धन वास्तव में किसका है? यह संपत्ति न तो कल तुम्हारी थी, न आज तुम्हारी है, और न ही कल तुम्हारी रहेगी; यह सब केवल उस परम सत्ता का है। 
            उपनिषद का यह पहला ही श्लोक मनुष्य के अहंकार और लालच पर सबसे बड़ा प्रहार करता है और सिखाता है कि जीवन में चीजों का उपयोग जरूर करो, लेकिन उनके प्रति अपने हृदय में कोई मोह या आसक्ति मत पालो। 
            यह श्लोक 'अद्वैत वेदांत' का सबसे बड़ा और सबसे शक्तिशाली आधार है जो संसार और संन्यास के बीच एक बहुत ही सुंदर संतुलन स्थापित करता है।
        """.trimIndent(),
        english = """
            Everything in this universe, whatsoever moves or remains entirely static in this ever-changing world, is profoundly and completely enveloped by the Supreme Lord (Isha) alone. 
            Since you now deeply realize that absolutely everything belongs exclusively to God and nothing is truly yours, you must enjoy and interact with this world purely through a profound sense of 'Renunciation' and absolute detachment. 
            O human! Never, ever covet or intensely desire anyone else's wealth or possessions, for whose wealth is it anyway? This material wealth never belonged to you in the past, it does not belong to you now, and it will never be yours in the future; it is strictly the property of the Supreme. 
            This magnificent opening verse delivers the absolute greatest strike against human ego and blinding greed, fiercely teaching us to utilize the resources of life without forming even a single drop of toxic attachment in our hearts. 
            It forms the absolute ultimate foundation of 'Advaita Vedanta', establishing an exceptionally beautiful and flawless balance between active worldly life and profound spiritual renunciation.
        """.trimIndent()
    ),
    IshaShloka(
        id = 2,
        sanskrit = "कुर्वन्नेवेह कर्माणि जिजीविषेच्छतँ समाः ।\nएवं त्वयि नान्यथेतोऽस्ति न कर्म लिप्यते नरे ॥ २ ॥",
        hindi = """
            इस संसार में मनुष्य को अपने निर्धारित और पवित्र कर्मों (कर्तव्यों) को निरंतर करते हुए ही पूरे सौ वर्षों (100 years) तक जीने की इच्छा करनी चाहिए। 
            उपनिषद यहाँ बहुत स्पष्ट रूप से घोषणा करता है कि अकर्मण्यता (आलस्य) या कर्मों से भाग जाना कोई आध्यात्मिकता नहीं है। अगर तुम निष्काम भाव से, बिना किसी स्वार्थ या फल की चिंता के अपने कर्म करते हो, तो यही एकमात्र सही रास्ता है। 
            इस प्रकार से जीवन जीने वाले मनुष्य के अंदर कर्मों का कोई भी बंधन या पाप (लिप्यते) कभी नहीं चिपकता। 
            संसार के साधारण लोग कर्म करते हैं और उसके फलों (success/failure) में फँसकर दुखी होते हैं, परंतु जो मनुष्य पहले श्लोक के ज्ञान (ईश्वर का साम्राज्य) को समझकर कर्म करता है, वह कर्म करते हुए भी बिल्कुल मुक्त और स्वतंत्र रहता है। 
            तुम्हारे लिए कर्म के बंधन से बचने का इसके अलावा दुनिया में कोई दूसरा मार्ग (नान्यथेतोऽस्ति) नहीं है। यह सीधे तौर पर भगवद्गीता के 'कर्म योग' का मूल सिद्धांत है।
        """.trimIndent(),
        english = """
            A human being must desire to live a full span of one hundred years in this world strictly while continuing to perform his righteous, prescribed duties and sacred actions (Karma) relentlessly. 
            The Upanishad makes a tremendously clear declaration here that sheer inaction, physical laziness, or cowardly running away from worldly duties is absolutely not true spirituality. If you continuously perform your duties with absolute selflessness, completely free from the toxic anxiety of the results, that is the only flawless path. 
            For a human who lives exactly in this detached manner, the binding chains of Karma (good or bad) absolutely never cling to him or pollute his pure soul. 
            Ordinary people of the world perform actions and instantly get suffocated by the intense attachment to their results (success or failure), but a wise person who works with the profound realization of the first verse remains entirely completely liberated and free even while executing the heaviest responsibilities. 
            There is absolutely no other alternative path (Nanyatheto'sti) in this universe for you to escape the terrifying bondage of Karma; this is the direct, unadulterated root of the Bhagavad Gita's 'Karma Yoga'.
        """.trimIndent()
    ),
    IshaShloka(
        id = 3,
        sanskrit = "असुर्या नाम ते लोका अन्धेन तमसावृताः ।\nताँस्ते प्रेत्याभिगच्छन्ति ये के चात्महनो जनाः ॥ ३ ॥",
        hindi = """
            उपनिषद चेतावनी देता है कि वे भयानक और भयंकर लोक, जिन्हें 'असुरों के लोक' (असुर्या नाम ते लोका) कहा जाता है, अज्ञानता और दुख के घने, अंधेरे अंधकार (अन्धेन तमसावृताः) से पूरी तरह घिरे हुए हैं। 
            जो भी मनुष्य इस जीवन में अपनी 'आत्मा की हत्या' (आत्महनो जनाः) करते हैं, वे मरने के बाद सीधे उन्हीं भयानक और अंधकारमयी दुनिया में जाकर गिरते हैं। 
            यहाँ 'आत्मा की हत्या' का मतलब शरीर से आत्महत्या करना नहीं है, बल्कि इसका मतलब है—मनुष्य का जन्म पाकर भी अपनी असली पहचान (आत्मा/ईश्वर) को भूल जाना और केवल शरीर, पैसे और भौतिक सुखों के पीछे जानवरों की तरह भागना। 
            जब हम अपनी चेतना की आवाज को कुचल कर केवल अज्ञानता में जीते हैं, तो हम खुद अपनी आत्मा के सबसे बड़े दुश्मन बन जाते हैं। 
            यह श्लोक उन लोगों के लिए एक बहुत बड़ा अलार्म है जो अपना पूरा जीवन टीवी, सोशल मीडिया और भोग-विलास में बर्बाद कर देते हैं और कभी यह नहीं सोचते कि "मैं कौन हूँ?" ऐसे लोग जीते जी भी नरक का अनुभव करते हैं और मरने के बाद भी गहरी अज्ञानता में डूब जाते हैं।
        """.trimIndent(),
        english = """
            The Upanishad issues a terrifying and absolute warning that those demonic and lowest dimensions of existence, explicitly known as the 'Worlds of Asuras' (demons), are entirely and violently enveloped in blind, impenetrable darkness and deep ignorance (Andhena Tamasavritah). 
            Whoever among human beings acts as the absolute 'Slayer of the Self' (Atmahano janah) is instantly and inevitably violently thrown into those miserable, dark dimensions immediately after death. 
            Here, 'Slaying the Self' absolutely does not strictly mean physical suicide; rather, it profoundly means completely forgetting your divine true nature (the Soul/God) despite getting a precious human birth, and running exactly like blind animals purely after bodily pleasures and cheap material wealth. 
            When we ruthlessly crush the inner voice of our pure consciousness and live purely in dark ignorance, we forcefully become the absolute worst enemies of our own soul. 
            This verse acts as a massive, blazing alarm for all those people who waste their entire precious human lives blindly chasing physical luxuries without ever deeply questioning "Who am I?"; such people experience literal hell while living and sink into endless, terrifying cosmic darkness after death.
        """.trimIndent()
    ),
    IshaShloka(
        id = 4,
        sanskrit = "अनेजदेकं मनसो जवीयो नैनद्देवा आप्नुवन्पूर्वमर्षत् ।\nतद्धावतोऽन्यानत्येति तिष्ठत्तस्मिन्नपो मातरिश्वा दधाति ॥ ४ ॥",
        hindi = """
            वह परम आत्मा (परमात्मा) हमेशा अपनी जगह पर 'अचल' (अनेजत्) और स्थिर है, उसका कोई आकार नहीं है, फिर भी वह इंसान के चंचल 'मन' से भी ज्यादा तेज दौड़ता है (मनसो जवीयो)। 
            देवता और हमारी इंद्रियां (आंख, कान, दिमाग) कभी भी उस परमात्मा तक नहीं पहुंच सकतीं, क्योंकि वह इंद्रियों के पहुंचने से पहले ही वहां मौजूद रहता है (पूर्वमर्षत्)। 
            भले ही वह एक जगह पर पूरी शांति से बैठा हुआ है, फिर भी वह दौड़ने वाले सभी देवी-देवताओं और शक्तियों को आसानी से पीछे छोड़ देता है। 
            उसी एक परमात्मा की महान शक्ति के आधार पर ही यह 'मातरिश्वा' (प्राण वायु / वायु देवता / जीवन शक्ति) पूरे ब्रह्मांड की सारी गतिविधियों और कर्मों को धारण करता है। 
            यह श्लोक विज्ञान और आध्यात्म का बहुत बड़ा रहस्य खोलता है। यह बताता है कि ईश्वर कोई व्यक्ति नहीं बल्कि वह 'स्पेस' (Space) या 'चेतना' (Consciousness) है जो पूरे यूनिवर्स में पहले से मौजूद है। मन जहां भी जाने की सोचता है, वह चेतना वहां पहले से ही होती है, इसलिए उसे कभी चलकर कहीं जाना नहीं पड़ता।
        """.trimIndent(),
        english = """
            That Supreme Absolute Self (Atman/Brahman) is permanently completely unmoving (Anejat) and perfectly still, strictly one without a second, yet it travels infinitely faster than the most restless human mind (Manaso javiyo). 
            Even the powerful gods and our sensory organs (eyes, ears, intellect) can absolutely never catch up to or reach it, precisely because it is always flawlessly present there long before they even begin their journey. 
            Even while remaining absolutely stationary and entirely motionless in one single place, it effortlessly and entirely outpaces all others who are aggressively running. 
            It is strictly and exclusively by the immense, absolute power of this Supreme Entity that 'Matarishva' (the cosmic life-breath / wind god) flawlessly supports and sustains all the activities, energies, and life forces of the entire physical universe. 
            This phenomenal verse reveals the absolute ultimate secret of quantum physics and deep spirituality; it profoundly explains that God is not a biological person but the absolute fabric of 'Consciousness' and 'Space' that permanently permeates the entire cosmos. Wherever the mind ever tries to aggressively reach, the pure Self is already permanently sitting there.
        """.trimIndent()
    ),
    IshaShloka(
        id = 5,
        sanskrit = "तदेजति तन्नैजति तद्दूरे तद्वन्तिके ।\nतदन्तरस्य सर्वस्य तदु सर्वस्यास्य बाह्यतः ॥ ५ ॥",
        hindi = """
            वह परमतत्त्व (ईश्वर) चलता भी है, और वह बिल्कुल भी नहीं चलता (तदेजति तन्नैजति)। वह अज्ञानियों के लिए बहुत, बहुत दूर है, लेकिन ज्ञानियों के लिए वह सबसे ज्यादा पास (अन्तिके) है। 
            वह परमात्मा इस पूरे ब्रह्मांड और इसके कण-कण के भीतर (अन्तरस्य) गहराई में बसा हुआ है, और वही परमात्मा इस पूरे ब्रह्मांड के बाहर (बाह्यतः) भी पूरी तरह से फैला हुआ है। 
            यह श्लोक ईश्वर के 'विरोधाभासी' (Paradoxical) स्वरूप को समझाता है। जब हम ईश्वर को अपनी भौतिक आंखों से देखने की कोशिश करते हैं, तो वह यूनिवर्स के अंत से भी ज्यादा दूर लगता है, लेकिन जब हम आंखें बंद करके ध्यान करते हैं, तो वह हमारी अपनी सांसों और धड़कनों से भी ज्यादा करीब महसूस होता है। 
            चलता हुआ वह इसलिए लगता है क्योंकि पूरी दुनिया उसी की शक्ति से चल रही है, लेकिन वह खुद इसलिए नहीं चलता क्योंकि ऐसी कोई जगह ही नहीं है जहां वह पहले से न हो (Infinity cannot move)। 
            वह हर इंसान, जानवर और पेड़ के दिल के अंदर भी है, और अंतरिक्ष की उन अंधेरी गहराइयों के बाहर भी है जहां आज तक कोई नहीं पहुंच सका। वह सब कुछ है!
        """.trimIndent(),
        english = """
            That Supreme Reality (Brahman) aggressively moves, and yet It absolutely does not move at all (Tadejati tannaijati). To the deeply ignorant, It is infinitely, terrifyingly far away, but to the enlightened, It is flawlessly and intimately the closest entity possible. 
            That magnificent Supreme Lord is permanently established entirely inside (Antarasya) every single microscopic atom of this universe, and exactly that same God is completely, flawlessly enveloping this entire physical universe absolutely from the outside (Bahyatah) as well. 
            This spectacular verse brilliantly explains the highly 'Paradoxical' nature of the Supreme Lord. When we desperately try to perceive God with our raw physical eyes, He appears infinitely farther than the darkest edge of the universe; but when we close our eyes in deep meditation, He is instantly felt closer than our very own heartbeat. 
            He vividly appears to move because the entire kinetic energy of the cosmos relies entirely on Him, yet He is permanently motionless because absolute Infinity cannot possibly move to an empty space (because there is no empty space without Him). 
            He is undeniably the absolute deep core inside every human and star, and He is the ultimate infinite boundary physically outside the entire known and unknown cosmos!
        """.trimIndent()
    ),
    IshaShloka(
        id = 6,
        sanskrit = "यस्तु सर्वाणि भूतानि आत्मन्येवानुपश्यति ।\nसर्वभूतेषु चात्मानं ततो न विजुगुप्सते ॥ ६ ॥",
        hindi = """
            जो महान इंसान (ज्ञानी/योगी) इस दुनिया के सभी छोटे-बड़े प्राणियों को, कीड़े-मकोड़ों से लेकर देवताओं तक को, केवल अपनी ही 'आत्मा' (Self) के भीतर देखता है। 
            और जो व्यक्ति अपनी आत्मा को ही संसार के सभी प्राणियों के भीतर भी मौजूद देखता है (सर्वभूतेषु चात्मानं)। ऐसा व्यक्ति इस ज्ञान को पा लेने के बाद कभी भी किसी से घृणा (न विजुगुप्सते), नफरत या द्वेष नहीं कर सकता। 
            यह श्लोक दुनिया में शांति और भाईचारे का सबसे बड़ा और सबसे असली फॉर्मूला है। जब तक हम दूसरों को खुद से 'अलग' समझते हैं, तब तक हमारे अंदर डर, नफरत और जलन पैदा होती है। 
            लेकिन जब योगी को यह समझ आ जाता है कि "जो चेतना मेरे अंदर सांस ले रही है, वही चेतना सामने वाले व्यक्ति, जानवर या दुश्मन के अंदर भी है," तो नफरत की कोई गुंजाइश ही नहीं बचती। 
            आप अपने ही हाथ से अपने ही पैर को नफरत कैसे कर सकते हैं? अद्वैत वेदांत की यही सबसे बड़ी ऊंचाई है, जहां 'मैं' और 'तुम' का अंतर हमेशा के लिए मिट जाता है और केवल एक ईश्वर ही दिखाई देता है।
        """.trimIndent(),
        english = """
            That magnificent, enlightened Yogi who flawlessly and continuously perceives absolutely all living and non-living beings—from the smallest microscopic insect to the highest gods—strictly within his own pure 'Self' (Atman). 
            And who simultaneously profoundly sees exactly his own pure Soul completely and vividly residing inside the hearts of all those beings (Sarvabhuteshu chatmanam). Such an absolute master, having attained this supreme cosmic vision, can absolutely never, ever feel hatred, disgust, or repulsion (Na vijugupsate) towards anyone or anything. 
            This explosive verse provides the absolute greatest and most authentic formula for world peace and pure universal brotherhood. As long as we blindly perceive others as completely 'separate' from our own self, deep fear, intense jealousy, and violent hatred naturally breed inside us. 
            But when a true Yogi violently shatters his ego and realizes, "The exact same pure consciousness violently breathing inside me is exactly what animates my fiercest enemy and every animal," absolutely zero room for hatred remains. 
            How can you possibly ever hate your own left hand with your right hand? This is the absolute ultimate summit of Advaita Vedanta, where the illusion of 'I' and 'You' permanently vaporizes, leaving behind purely one Infinite God.
        """.trimIndent()
    ),
    IshaShloka(
        id = 7,
        sanskrit = "यस्मिन्सर्वाणि भूतानि आत्मैवाभूद्विजानतः ।\nतत्र को मोहः कः शोक एकत्वमनुपश्यतः ॥ ७ ॥",
        hindi = """
            जिस अवस्था में पहुंचकर ज्ञानवान मनुष्य के लिए संसार के सभी प्राणी केवल साक्षात् 'आत्मा' (Self) ही बन जाते हैं (आत्मैवाभूद्विजानतः)। 
            उस परम अवस्था में, जहां व्यक्ति हर तरफ केवल एकत्व (Oneness / एक ही परमात्मा) को देखता है, भला उस इंसान के लिए कौन सा मोह (Attachment) और कौन सा शोक (Sorrow) बच सकता है? 
            उपनिषद यहाँ इंसान के सबसे बड़े दो दुश्मनों—'मोह' (अटैचमेंट) और 'शोक' (दुख)—का 100% इलाज बता रहा है। हम दुखी क्यों होते हैं? क्योंकि हम चीजों से चिपकते हैं और उन्हें खोने से डरते हैं। 
            लेकिन जिस योगी ने यह जान लिया है कि पूरा ब्रह्मांड उसी का अपना स्वरूप है, तो वह क्या खोएगा और क्या पाएगा? जब कोई दूसरा है ही नहीं, तो धोखा कौन देगा? जब कोई अजनबी है ही नहीं, तो डर किस बात का? 
            यह श्लोक 'जीवनमुक्ति' (Enlightenment) की घोषणा करता है। जो इंसान यह 'एकत्व' (One-ness) देख लेता है, वह इसी जन्म में, इसी शरीर में रहते हुए सारे दुखों और डिप्रेशन (Depression) से हमेशा के लिए आज़ाद हो जाता है।
        """.trimIndent(),
        english = """
            In that absolute supreme state of consciousness where, for the perfectly enlightened sage, absolutely all beings have profoundly and literally become his very own pure 'Self' alone (Atmaivabhudvijanatah). 
            In exactly that ultimate dimension, where the master exclusively perceives absolute and flawless 'Oneness' (Ekatvam) everywhere, how can there possibly exist any toxic delusion (Moha) or any terrifying sorrow (Shoka) for him? 
            The Upanishad right here fiercely provides the absolute 100% perfect cure for humanity's two greatest psychological enemies—intense attachment and crushing depression/sorrow. Why exactly do we suffer? Because we blindly attach ourselves to temporary things and are terrified of losing them. 
            But for the supreme Yogi who has flawlessly realized that the entire infinite cosmos is literally his own physical extension, what could he possibly ever lose or gain? When absolutely no 'other' exists, who can ever betray him? When there are no strangers, where is the fear? 
            This magnificent verse fiercely broadcasts the ultimate state of 'Jivanmukti' (living liberation). The human who forcefully realizes this absolute 'Oneness' becomes permanently immune to all psychological depression and pain while still physically walking on this earth.
        """.trimIndent()
    ),
    IshaShloka(
        id = 8,
        sanskrit = "स पर्यगाच्छुक्रमकायमव्रणमस्नाविरँ शुद्धमपापविद्धम् ।\nकविर्मनीषी परिभूः स्वयम्भूर्याथातथ्यतोऽर्थान् व्यदधाच्छाश्वतीभ्यः समाभ्यः ॥ ८ ॥",
        hindi = """
            वह परमात्मा हर जगह फैला हुआ (पर्यगात्) है, वह परम प्रकाशवान (शुक्रम्) है, उसका कोई भौतिक शरीर नहीं है (अकायम्), उसे कभी घाव या चोट नहीं लग सकती (अव्रणम्), उसमें खून-हड्डियां या नसें नहीं हैं (अस्नाविरम्), वह परम शुद्ध है और पाप कभी उसे छू तक नहीं सकते (अपापविद्धम्)। 
            वह ईश्वर 'कवि' (सब कुछ देखने वाला/सर्वज्ञ), 'मनीषी' (सबके मनों को जानने वाला/नियंत्रक), 'परिभूः' (सबसे ऊपर और श्रेष्ठ) और 'स्वयंभू' (जो खुद से पैदा हुआ है, जिसे किसी ने नहीं बनाया) है। 
            उसी एक परमात्मा ने अनंत कालों (शाश्वतीभ्यः समाभ्यः) से सभी चीजों और कर्मों का बिल्कुल सही और उचित नियम (याथातथ्यतो) तय किया है। 
            यह श्लोक बहुत ही स्पष्ट रूप से साबित करता है कि असली ईश्वर का कोई इंसान जैसा 'शरीर' नहीं होता। वह किसी मूर्ति या इंसान के शरीर में कैद नहीं है। वह शुद्ध ऊर्जा, शुद्ध चेतना और परम सत्य है। 
            वही एक सुपरकंप्यूटर (Supercomputer) की तरह इस पूरे यूनिवर्स के ग्रेविटी, टाइम और कर्मों के कानूनों को अनंत काल से बिना किसी गलती के कंट्रोल कर रहा है।
        """.trimIndent(),
        english = """
            That Supreme Lord completely flawlessly all-pervading (Paryagat), absolutely radiant and resplendent (Shukram); He strictly has no physical, material body (Akayam), is absolutely invulnerable and completely without wounds (Avranam), possesses absolutely no muscles, veins, or bones (Asnaviram), is eternally pure, and is completely untouched and untainted by any sin or evil (Apapaviddham). 
            He is the absolute 'Kavi' (the omniscient ultimate seer of all), the 'Manishi' (the supreme controller of all minds), the 'Paribhuh' (transcendent and supremely above all), and the 'Svayambhu' (completely self-existent; created by absolutely no one). 
            It is exactly this exact same Supreme Being who has flawlessly and perfectly assigned the absolute exact duties, physical laws, and true purposes to all entities for absolute endless eternity (Shashvatibhyah samabhyah). 
            This explosive and spectacular verse explicitly permanently destroys the ignorant myth of a biological God. The true Supreme absolutely cannot be strictly confined inside human flesh or bones. He is purely unadulterated energy and supreme consciousness. 
            Like an absolute perfect cosmic Supercomputer, He has been flawlessly running the terrifying laws of gravity, time, and human karma completely perfectly since the exact infinite dawn of creation.
        """.trimIndent()
    ),
    IshaShloka(
        id = 9,
        sanskrit = "अन्धं तमः प्रविशन्ति येऽविद्यामुपासते ।\nततो भूय इव ते तमो य उ विद्यायाँ रताः ॥ ९ ॥",
        hindi = """
            उपनिषद कहता है: जो लोग केवल 'अविद्या' (कर्मकांड, अज्ञानता, अंधविश्वास और भौतिक संसार के कर्म) की उपासना करते हैं, वे अज्ञानता के घोर अंधकार (अन्धं तमः) में प्रवेश करते हैं। 
            परंतु जो लोग केवल 'विद्या' (केवल किताबी ज्ञान, शास्त्रों के अहंकार और बौद्धिक चर्चाओं) में ही डूबे रहते हैं (विद्यायाँ रताः), वे मानो उससे भी भयंकर और गहरे अंधकार में गिर जाते हैं! 
            यह श्लोक सनातन धर्म का सबसे बड़ा 'शॉक' (Shock) है! यहाँ ऋषि कह रहे हैं कि जो इंसान बिना सोचे-समझे केवल सांसारिक चीजों और कर्मकांडों (अविद्या) के पीछे भागता है, वह तो भटकेगा ही। 
            लेकिन जो इंसान सोचता है कि उसने 4 वेद पढ़ लिए हैं, बहुत बड़ा पंडित बन गया है, और केवल खोखली फिलॉसफी (विद्या) बघारता है, लेकिन कर्म नहीं करता, उसका अहंकार उसे पहले वाले अज्ञानी से भी बड़े नरक में धकेल देता है। 
            केवल थ्योरी (Theory) और केवल प्रैक्टिकल (Practical), दोनों अपने आप में अधूरे और खतरनाक हैं। सच्चा ज्ञान वह है जहाँ इंसान का ज्ञान और कर्म, दोनों आपस में जुड़ जाएं।
        """.trimIndent(),
        english = """
            The Upanishad fiercely declares: Those individuals who exclusively worship 'Avidya' (blind ignorance, mere rituals, and obsessive materialistic actions) absolutely fall headfirst into entirely blinding, pitch-black darkness (Andham Tamah). 
            However, those arrogant individuals who are obsessively and exclusively completely engrossed purely in 'Vidya' (empty theoretical knowledge, false scriptural ego, and useless intellectual debates) violently crash into an even more terrifying and infinitely deeper darkness! 
            This verse delivers the absolute most terrifying 'Shock' of Sanatana Dharma! The visionary sage is explicitly screaming that an ignorant human who blindly chases raw materialistic life and empty rituals (Avidya) is undeniably doomed. 
            But the massively arrogant scholar who foolishly thinks reading heavy scriptures magically makes him a master, aggressively vomiting empty philosophy (Vidya) while doing absolutely zero real action, goes to a hell exponentially worse strictly because of his massive spiritual ego. 
            Exclusive blind action and exclusive empty theory are both terrifying traps. True liberation demands the absolute, flawless fusion of supreme inner wisdom perfectly combined with selfless outward action.
        """.trimIndent()
    ),
    IshaShloka(
        id = 10,
        sanskrit = "अन्यदेवाहुर्विद्ययाऽन्यदाहुरविद्यया ।\nइति शुश्रुम धीराणां ये नस्तद्विचचक्षिरे ॥ १० ॥",
        hindi = """
            विद्वान और ज्ञानी महापुरुषों ने कहा है कि 'विद्या' (सच्चे ज्ञान / ईश्वर के अनुभव) से प्राप्त होने वाला फल बिल्कुल अलग (अन्यदेव) है, और 'अविद्या' (केवल सांसारिक कर्मों और अनुष्ठानों) से मिलने वाला फल भी बिल्कुल अलग है। 
            ऐसा हमने उन 'धीर' (बुद्धिमान और आत्मज्ञानी) ऋषियों से सुना है (इति शुश्रुम धीराणां), जिन्होंने हमें इन दोनों (विद्या और अविद्या) का बिल्कुल स्पष्ट और सही-सही रहस्य समझाया था (ये नस्तद्विचचक्षिरे)। 
            इस श्लोक में उपनिषद यह स्पष्ट करता है कि तुम जीवन में जो बोओगे, वही काटोगे। अगर तुम केवल दुनियावी तरक्की और पैसा कमाने (अविद्या) पर फोकस करोगे, तो तुम्हें पैसा मिल जाएगा, लेकिन मन की शांति नहीं मिलेगी। 
            वहीं, अगर तुम केवल भगवान (विद्या) की ओर भागोगे लेकिन दुनिया में अपने कर्तव्य पूरे नहीं करोगे, तो भी तुम अधूरे रह जाओगे। 
            प्राचीन ऋषियों ने यह साफ बताया है कि जीवन के दोनों हिस्सों का परिणाम अलग-अलग होता है, इसलिए इंसान को इन दोनों का सही मतलब समझना चाहिए और किसी एक में फँसकर अंधा नहीं होना चाहिए।
        """.trimIndent(),
        english = """
            The immensely wise and enlightened great masters have explicitly declared that the ultimate final result obtained purely through 'Vidya' (supreme spiritual wisdom/meditation) is absolutely completely different (Anyadeva), and the result obtained violently through 'Avidya' (purely materialistic actions and rituals) is also entirely and drastically different. 
            Thus have we profoundly heard exactly from those immensely 'Dhira' (supreme, unwavering, enlightened sages) (Iti shushruma dhiranam) who systematically and flawlessly explained and revealed this deep secret to us (Ye nastadvichachakshire). 
            In this exceptionally profound verse, the Upanishad fiercely clarifies that the universe strictly gives you exactly what you aggressively pursue. If you blindly worship worldly wealth and fame (Avidya), you will definitely get it, but you will completely permanently lose your internal peace. 
            Conversely, if you blindly chase exclusively theoretical spirituality (Vidya) while ruthlessly ignoring your active life duties, you will remain severely incomplete and deeply flawed. 
            The ancient masters fiercely clarified that the cosmic results of both extremes are entirely different, aggressively urging humanity to deeply understand both without becoming a pathetic blind slave to either extreme.
        """.trimIndent()
    ),
    IshaShloka(
        id = 11,
        sanskrit = "विद्यां चाविद्यां च यस्तद्वेदोभयँ सह ।\nअविद्यया मृत्युं तीर्त्वा विद्ययामृतमश्नुते ॥ ११ ॥",
        hindi = """
            जो मनुष्य 'विद्या' (आध्यात्मिक ज्ञान/चेतना) और 'अविद्या' (सांसारिक कर्म/कर्तव्य), इन दोनों के असली रहस्य को एक साथ (तद्वेदोभयँ सह) जान लेता है और अपने जीवन में उतार लेता है; 
            वह अविद्या (निष्काम कर्म) के द्वारा 'मृत्यु' (यानी जीवन के सारे संघर्षों, अज्ञान और दुखों) को पार कर लेता है (मृत्युं तीर्त्वा), और विद्या (सच्चे आत्मज्ञान) के द्वारा परम 'अमरता' (अमृतम्) को प्राप्त कर लेता है। 
            यह ईशावास्य उपनिषद का सबसे महत्वपूर्ण और 'मास्टर-स्ट्रोक' (Master-stroke) श्लोक है! यह दुनिया को बताता है कि तुम्हें न तो हिमालय में जाकर छुपने की जरूरत है (केवल विद्या) और न ही मशीनों की तरह 24 घंटे पैसे के पीछे भागने की (केवल अविद्या)। 
            सच्चा योगी वह है जो संसार में रहकर अपने परिवार और काम की जिम्मेदारी पूरी करता है (अविद्या से मृत्यु को पार करना) और साथ ही रोज ध्यान करके अपने अंदर के भगवान से भी जुड़ा रहता है (विद्या से अमरता पाना)। 
            कर्म से शरीर और दुनिया की रक्षा होती है, और ध्यान से आत्मा की। इन दोनों के बैलेंस (Balance) से ही एक इंसान 'सुपर-ह्यूमन' (Super-human) बनता है।
        """.trimIndent(),
        english = """
            That absolute master who flawlessly, simultaneously completely understands and integrates both 'Vidya' (Supreme spiritual knowledge) and 'Avidya' (selfless worldly action and duties) exactly together perfectly side by side (Tadvedobhayam saha); 
            He flawlessly crosses infinitely beyond 'Death' (meaning all worldly suffering, survival struggles, and deep ignorance) strictly through Avidya (perfect detached action), and he successfully and irreversibly attains ultimate infinite 'Immortality' (Amritam) entirely through Vidya (realized spiritual wisdom). 
            This is undeniably the absolute greatest and most explosive 'Master-stroke' verse of the Isha Upanishad! It aggressively teaches the world that you absolutely do not need to cowardly run to the Himalayas (exclusively Vidya) nor do you need to blindly slave away like a mindless money-making machine (exclusively Avidya). 
            The supreme ultimate Yogi is exactly he who stays fiercely in the brutal physical world, completely executing all heavy responsibilities (crossing death through Avidya), while simultaneously deeply anchoring himself in extreme daily meditation (attaining immortality through Vidya). 
            Action protects the physical body and society, while profound meditation fully liberates the Soul. Strictly through the aggressive flawless balance of both does a normal human become an absolute supreme 'Super-human'.
        """.trimIndent()
    ),
    IshaShloka(
        id = 12,
        sanskrit = "अन्धं तमः प्रविशन्ति येऽसम्भूतिमुपासते ।\nततो भूय इव ते तमो य उ सम्भूत्याँ रताः ॥ १२ ॥",
        hindi = """
            जो लोग केवल 'असम्भूति' (विनाशशील चीजों, प्रलय, या निराकार प्रकृति) की उपासना करते हैं, वे घोर अंधकार में प्रवेश करते हैं। 
            और जो लोग केवल 'सम्भूति' (पैदा होने वाली चीजों, मूर्तियों, या केवल इस भौतिक शरीर और संसार की रचनाओं) में ही पूरी तरह से रमे रहते हैं, वे मानो उससे भी गहरे और भयंकर अंधकार में डूब जाते हैं। 
            यह श्लोक श्लोक 9 जैसा ही है, लेकिन यहाँ विषय 'क्रिएशन' (Creation) और 'डिस्ट्रक्शन' (Destruction) का है। अगर आप केवल इस बात पर फोकस करते हैं कि दुनिया कैसे खत्म होगी, या केवल निराकार शून्य (Void) को मानते हैं, तो आप अज्ञान में हैं। 
            लेकिन जो लोग केवल बाहर की पैदा की गई चीजों (पैसा, बिल्डिंग्स, शरीर की सुंदरता, या केवल बाहरी मूर्तियों) को ही सब कुछ मान लेते हैं और भगवान की असली गहराई को भूल जाते हैं, उनका पतन और भी बुरा होता है। 
            ऋषि समझा रहे हैं कि क्रिएटर (बनाने वाला) और क्रिएशन (बनी हुई चीज), दोनों का सम्मान करो, पर किसी एक में बुरी तरह फँस कर अंधे मत बनो।
        """.trimIndent(),
        english = """
            Those ignorant individuals who blindly worship purely 'Asambhuti' (the unmanifested void, dissolution, or strictly the destructive aspects of nature) entirely violently fall into absolutely terrifying pitch-black darkness. 
            And those wildly arrogant people who are completely obsessively infatuated strictly with 'Sambhuti' (the manifested world, physical bodies, extreme material creation, and mere physical forms), violently crash headfirst into a vastly infinitely deeper and much more terrifying darkness. 
            This exceptionally powerful verse mirrors Verse 9 exactly, but specifically targets the profound extreme obsession with 'Creation' versus 'Destruction'. If you aggressively obsess over death, void, or nihilism (Asambhuti), you violently sink into absolute blinding depression and ignorance. 
            But those deeply foolish people who exclusively worship strictly external manifested creations (physical money, big buildings, superficial bodily beauty, or strictly blind idol worship without inner realization) suffer an incredibly worse and more terrifying intellectual collapse. 
            The supreme master aggressively warns humanity to respect both the unseen Creator and the seen Creation, actively commanding us absolutely never to become a blind, toxic slave to merely one narrow aspect of existence.
        """.trimIndent()
    ),
    IshaShloka(
        id = 13,
        sanskrit = "अन्यदेवाहुः सम्भवादन्यदाहुरसम्भवात् ।\nइति शुश्रुम धीराणां ये नस्तद्विचचक्षिरे ॥ १३ ॥",
        hindi = """
            विद्वानों का कहना है कि 'सम्भव' (उत्पन्न होने वाली चीजों / सगुण ईश्वर / संसार की रचना) की उपासना से मिलने वाला फल बिल्कुल अलग है, और 'असम्भव' (अविनाशी तत्त्व / प्रकृति का मूल कारण / निराकार) की उपासना से मिलने वाला फल बिल्कुल अलग है। 
            ऐसा हमने उन 'धीर' (ज्ञानी) ऋषियों से बहुत अच्छी तरह सुना और समझा है, जिन्होंने हमारे सामने इन दोनों बातों की बिल्कुल स्पष्ट और गहराई से व्याख्या की थी। 
            उपनिषद यहाँ सगुण (Form) और निर्गुण (Formless) दोनों तरह की भक्ति और ध्यान की बात कर रहा है। अगर आप केवल भगवान की मूर्ति की पूजा करते हैं, तो आपको मानसिक शांति मिलेगी (सम्भवात्)। 
            अगर आप भगवान के निराकार रूप (Energy/Space) का ध्यान करते हैं, तो आपका अहंकार टूटेगा और वैराग्य आएगा (असम्भवात्)। दोनों के परिणाम अलग हैं। 
            इसलिए प्राचीन महान ऋषियों ने यह स्पष्ट कर दिया है कि एक साधक को इन दोनों का मतलब पता होना चाहिए, ताकि वह जीवन में सही समय पर सही मार्ग का चुनाव कर सके।
        """.trimIndent(),
        english = """
            The profoundly enlightened masters have strictly explicitly declared that the exact ultimate fruit obtained strictly from the worship of 'Sambhava' (the manifest world, the Creator with attributes/form) is absolutely profoundly different, and the precise fruit obtained violently from 'Asambhava' (the Unmanifest, Formless Absolute, uncreated void) is drastically different. 
            Thus have we perfectly heard absolutely directly from those immensely 'Dhira' (unwavering, supreme sages) who effortlessly and flawlessly revealed and explained this massive secret to us with terrifying clarity. 
            The Upanishad here flawlessly tackles the epic massive debate between Saguna (God with form) and Nirguna (God without form). If you exclusively aggressively worship physical idols or forms, you definitely attain specific psychological comfort and emotional purification. 
            If you fiercely meditate purely on the invisible Formless cosmic energy/void (Asambhava), you aggressively shatter your massive ego and attain strict detachment. The exact cosmic results of both are wildly different. 
            Therefore, the ancient supreme masters completely and brilliantly laid out these exact consequences, violently urging a true seeker to flawlessly master both paths rather than foolishly arguing over which one is superficially better.
        """.trimIndent()
    ),
    IshaShloka(
        id = 14,
        sanskrit = "सम्भूतिं च विनाशं च यस्तद्वेदोभयँ सह ।\nविनाशेन मृत्युं तीर्त्वा सम्भूत्यामृतमश्नुते ॥ १४ ॥",
        hindi = """
            जो बुद्धिमान मनुष्य 'सम्भूति' (सृजन/आत्मा/ईश्वर/सत्य) और 'विनाश' (नष्ट होने वाली प्रकृति/शरीर/अहंकार), इन दोनों के असली रहस्य को एक साथ जान लेता है; 
            वह 'विनाश' (परिवर्तनशील संसार और शरीर के कर्तव्यों) के द्वारा मृत्यु (सभी शारीरिक कष्टों और दुखों) को पार कर लेता है, और 'सम्भूति' (परमात्मा के सच्चे ज्ञान) के द्वारा अमरता (मोक्ष) को प्राप्त कर लेता है। 
            यह श्लोक फिर से हमें 'बैलेंस' (Balance) करना सिखाता है। शरीर और यह दुनिया 'विनाश' (बदलने वाली) है। जब आप यह मान लेते हैं कि यह शरीर तो मरेगा ही और चीजें बदलेंगी, तो आप मौत के डर को जीत लेते हैं (विनाशेन मृत्युं तीर्त्वा)। 
            और जब आप अपने अंदर बैठी उस अमर चेतना (सम्भूति) को पहचान लेते हैं जो कभी नहीं मरती, तो आप साक्षात् भगवान का स्वरूप बन जाते हैं (सम्भूत्यामृतमश्नुते)। 
            मतलब, दुनिया की बदलती हुई चीजों (विनाश) को स्वीकार करो और उनसे मत चिपकें, और जो कभी नहीं बदलता (आत्मा), उसमें अपना घर बनाओ। यही जीवन जीने की सबसे बड़ी कला है!
        """.trimIndent(),
        english = """
            That absolute master who flawlessly, simultaneously perfectly understands and integrates both 'Sambhuti' (the Eternal manifest Truth/Supreme Spirit) and 'Vinasha' (the completely perishable nature of the physical body, ego, and material world) exactly together perfectly side by side; 
            He completely flawlessly crosses infinitely beyond 'Death' (shattering all terrifying fear, bodily suffering, and delusion) strictly through Vinasha (completely accepting the perishable nature of the world), and he successfully and irreversibly attains ultimate infinite 'Immortality' (Moksha/Liberation) entirely through Sambhuti (realization of the Eternal Spirit). 
            This massive verse once again furiously teaches humanity the ultimate supreme art of cosmic 'Balance'. Your physical dirt-body and this temporary world strictly represent 'Vinasha' (the perishable). When you violently accept that the body will undeniably rot and die, you permanently conquer the terrifying fear of death (Vinashena mrityum tirtva). 
            And when you profoundly deeply realize that supreme immortal pure consciousness (Sambhuti) violently burning inside you which absolutely never dies, you flawlessly become the exact direct embodiment of God (Sambhutya amritam ashnute). 
            Meaning, aggressively accept the violently changing world strictly without attachment, and fiercely anchor your soul exclusively in the Unchanging Absolute. This is the absolute ultimate art of living!
        """.trimIndent()
    ),
    IshaShloka(
        id = 15,
        sanskrit = "हिरण्मयेन पात्रेण सत्यस्यापिहितं मुखम् ।\nतत्त्वं पूषन्नपावृणु सत्यधर्माय दृष्टये ॥ १५ ॥",
        hindi = """
            हे ब्रह्मांड के रक्षक (पूषन् / सूर्यदेव)! उस परम सत्य (ईश्वर) का मुख एक बहुत ही चमकीले, सोने के बर्तन (हिरण्मयेन पात्रेण) से पूरी तरह से ढका हुआ है। 
            मुझ जैसे 'सत्यधर्म' (सत्य के उपासक) को उस परम सत्य का असली दर्शन कराने के लिए, कृपया आप उस सोने के ढक्कन को हटा दीजिए (अपावृणु)। 
            यहाँ उपनिषद बहुत ही काव्यात्मक और सुंदर बात कह रहा है। 'सोने का बर्तन' क्या है? यह बाहरी दुनिया की चमक-दमक, पैसा, शोहरत, और हमारा अपना अहंकार (Ego) है। 
            जब हम दुनिया की इस चमक में फँस जाते हैं, तो हमें इसके पीछे छिपा हुआ असली 'सत्य' (भगवान/आत्मा) दिखाई ही नहीं देता। 
            साधक यहाँ सूर्य देव (यानी ब्रह्मांडीय बुद्धि / Cosmic Intelligence) से प्रार्थना कर रहा है कि "हे प्रभु! मेरी आंखों के आगे से इस माया और लालच की चमकदार पट्टी को हटा दो, ताकि मैं उस नग्न और परम सत्य का साक्षात् दर्शन कर सकूं।"
        """.trimIndent(),
        english = """
            O Supreme Sustainer and Nourisher of the universe (Pushan / Sun God)! The true, absolute face of the Supreme Truth (Brahman) is currently completely tightly hidden and violently covered strictly by a dazzlingly brilliant, golden vessel (Hiranmayena Patrena). 
            For the exact pure purpose of strictly allowing me, a fierce practitioner of 'Satyadharma' (the absolute religion of Truth), to vividly and directly behold the ultimate Truth, kindly completely remove and ruthlessly pull away that blinding golden lid (Apavrinu)! 
            Here, the Upanishad fiercely uses an incredibly poetic and immensely powerful metaphor. What exactly is this 'Golden Vessel'? It is strictly the blinding, toxic glamour of the external materialistic world, physical wealth, superficial fame, and our own massive blinding Ego. 
            When we get aggressively trapped and hypnotized by this massive cheap shine of the external world, we become absolutely completely blind to the real, supreme 'Truth' (God/Soul) perfectly hiding right behind it. 
            The supreme seeker fiercely prays to the Cosmic Sun (the ultimate Cosmic Intelligence), aggressively begging: "O Lord! Ruthlessly tear away this blinding mask of Maya and toxic greed from my eyes, so I can directly and explicitly witness the Naked, Ultimate Supreme Truth!"
        """.trimIndent()
    ),
    IshaShloka(
        id = 16,
        sanskrit = "पूषन्नेकर्षे यम सूर्य प्राजापत्य व्यूह रश्मीन् समूह तेजः ।\nयत्ते रूपं कल्याणतमं तत्ते पश्यामि योऽसावसौ पुरुषः सोऽहमस्मि ॥ १६ ॥",
        hindi = """
            हे पूषन् (सबका पोषण करने वाले), हे एकर्षे (अकेले यात्रा करने वाले), हे यम (सबको कंट्रोल करने वाले), हे सूर्य, हे प्राजापत्य (प्रजापति के पुत्र)! कृपया अपनी इन तेज और झुलसाने वाली किरणों (रश्मीन्) को समेट लीजिए (समूह), और अपनी चमक को कम कर दीजिए। 
            ताकि मैं आपके उस रूप को देख सकूं जो सबसे ज्यादा सुंदर, शांत और कल्याणकारी (कल्याणतमं) है। (और जब मैं उस रूप को गहराई से देखता हूँ, तो मैं जान जाता हूँ कि) 
            "वह जो वहां सूर्य (या ब्रह्मांड) के भीतर 'पुरुष' (परम चेतना) बैठा है, वह कोई और नहीं, बल्कि 'मैं ही हूँ'!" (सोऽहमस्मि - He I Am). 
            यह श्लोक अद्वैत वेदांत का सबसे बड़ा विस्फोट (Explosion) है! साधक पहले भगवान से प्रार्थना करता है कि अपनी माया की चकाचौंध को हटाओ। 
            और जैसे ही माया हटती है, इंसान को यह अहसास होता है कि आसमान में चमकने वाले सूरज के पीछे जो भगवान है, और मेरे दिल के अंदर जो आत्मा है, दोनों 100% एक ही हैं! "सोऽहमस्मि" (मैं ही वह हूँ)—यही ज्ञान इंसान को भगवान बना देता है।
        """.trimIndent(),
        english = """
            O Supreme Nourisher (Pushan), O absolute lone Cosmic Traveler (Ekarshi), O terrifying Controller of all (Yama), O blazing Sun, O son of Prajapati! Kindly intensely gather your blinding, scorching rays (Rashmin) entirely together (Samuha), and fiercely withdraw your terrifying glare. 
            Do this precisely so that I may flawlessly and clearly behold that specific, absolute ultimate form of yours which is the most exceptionally beautiful, tranquil, and supremely auspicious (Kalyanatamam). (And exactly as I stare profoundly into that pure form, I suddenly violently realize:) 
            "That exact Supreme 'Purusha' (the absolute infinite pure consciousness) majestically seated out there deep inside the Sun (the cosmos), is absolutely no one else, but strictly 'I Myself Am He'!" (So'ham Asmi). 
            This magnificent verse is the absolute greatest and most terrifying violent explosion of Advaita Vedanta! The ultimate seeker initially intensely begs God to ruthlessly withdraw the blinding glare of physical Maya. 
            And the exact split-second that Maya is violently shattered, the human being experiences the terrifyingly beautiful realization that the exact God violently blazing behind the cosmic sun and the exact Soul beating inside his own chest are 100% identically exactly One! "So'ham Asmi" (I Am He)—this exact realization literally physically turns a human entirely into God.
        """.trimIndent()
    ),
    IshaShloka(
        id = 17,
        sanskrit = "वायुरनिलममृतमथेदं भस्मान्तं शरीरम् ।\nॐ क्रतो स्मर कृतं स्मर क्रतो स्मर कृतं स्मर ॥ १७ ॥",
        hindi = """
            (मृत्यु के समय की प्रार्थना): अब मेरा यह प्राण (वायु) बाहर के महान और अमर 'अमृत वायु' (Cosmic Breath) में जाकर पूरी तरह मिल जाए, और मेरा यह भौतिक शरीर जलकर बिल्कुल 'राख' (भस्मान्तं) हो जाए। 
            हे ॐ (परमात्मा)! हे मेरे मन (क्रतो)! अब तू केवल भगवान का स्मरण कर (स्मर)। तूने जीवन भर जो भी अच्छे-बुरे कर्म किए हैं (कृतं), अब केवल उन कर्मों को याद कर, और भगवान का नाम ले! 
            यह श्लोक सनातन धर्म में किसी भी इंसान के अंतिम समय (Deathbed) का सबसे महान मंत्र है। जब शरीर का अंत करीब होता है, तब इंसान को समझ आता है कि यह शरीर तो केवल राख का एक ढेर है। 
            योगी मौत के समय डरता नहीं है। वह खुशी-खुशी अपनी सांसों को यूनिवर्स की सांसों में मिला देता है और अपने मन से कहता है, "रो मत! ॐ का नाम ले, अपने कर्मों को देख और अब शांति से इस शरीर को छोड़ दे।" 
            यह श्लोक सिखाता है कि मौत कोई अंत नहीं है, बल्कि यह एक बूंद का समंदर में वापस मिल जाना है।
        """.trimIndent(),
        english = """
            (The supreme prayer exactly at the precise moment of physical death): Now, let this purely physical, limited life-breath (Vayu) forcefully and entirely merge seamlessly back completely into the infinite, immortal 'Cosmic Breath' (Amritam Anilam), and let this exact physical dirt-body violently burn and be reduced purely and strictly entirely to lifeless 'Ashes' (Bhasmantam). 
            O Supreme 'OM' (the absolute God)! O my own intellect/will (Krato)! Immediately and fiercely remember (Smara) ONLY the Supreme Lord right now! Violently and strictly remember precisely whatever exact actions (Kritam) you have performed throughout this entire life; remember deeply, and chant God's absolute name! 
            This terrifyingly beautiful verse is undeniably the absolute greatest and most powerful final Deathbed mantra in all of Sanatana Dharma. Exactly when physical death aggressively approaches, the wise human profoundly realizes that this temporary body is literally strictly nothing but a pathetic future pile of grey ash. 
            A true master Yogi absolutely never fears death even for a split-second. He joyously and fiercely merges his tiny breath into the massive breath of the physical universe, fiercely commanding his own mind: "Do not weep! Violently chant OM, witness your karmas, and peacefully kick away this dead physical body!" 
            This explosive verse fiercely teaches humanity that death is absolutely not a terrifying end; it is simply a tiny water drop effortlessly returning forcefully exactly back into the infinite, roaring Ocean.
        """.trimIndent()
    ),
    IshaShloka(
        id = 18,
        sanskrit = "अग्ने नय सुपथा राये अस्मान् विश्वानि देव वयुनानि विद्वान् ।\nयुयोध्यस्मज्जुहुराणमेनो भूयिष्ठां ते नम उक्तिं विधेम ॥ १८ ॥",
        hindi = """
            हे अग्निदेव (परम प्रकाश/ईश्वर)! आप हमारे सारे कर्मों और विचारों को बहुत अच्छी तरह से जानने वाले (विद्वान्) हैं। कृपया हमें आध्यात्मिक धन (राये / मोक्ष) तक पहुँचने के लिए सबसे 'सही और शुभ रास्ते' (सुपथा) से ले चलिए। 
            हमारे भीतर जो भी कुटिलता, छल-कपट और पाप (जुहुराणमेनो) हैं, कृपया उन सबको हमसे लड़कर नष्ट कर दीजिए (युयोध्यस्मत्)। हम आपको बार-बार, बार-बार सबसे गहरे हृदय से नमस्कार (भूयिष्ठां ते नम) करते हैं! 
            ईशावास्य उपनिषद का यह अंतिम श्लोक एक इंसान के पूर्ण समर्पण (Surrender) की आवाज़ है। 'अग्नि' यहाँ केवल आग नहीं है, बल्कि वह ज्ञान की लौ है जो हमारे अंदर जलती है। 
            साधक कह रहा है कि "हे भगवान, मैं अपने दम पर अपने पापों और अहंकार को नहीं मार सकता। आप खुद मेरे अंदर के बुरे कर्मों को जला दीजिए और मुझे सही रास्ता दिखाइए।" 
            इस तरह ज्ञान और कर्म के सारे भारी उपदेशों के बाद, उपनिषद 'भक्ति' और 'प्रार्थना' के सबसे मीठे और विनम्र नोट (Note) पर खत्म होता है। जब तक भगवान की कृपा (Grace) नहीं होती, तब तक कोई भी इंसान मोक्ष नहीं पा सकता। ॐ शांति!
        """.trimIndent(),
        english = """
            O Supreme Lord of Fire (Agni / the ultimate divine inner light)! You are the absolute supreme Knower (Vidvan) of literally all our secret actions, hidden thoughts, and entire cosmic history. Kindly securely flawlessly lead us exactly by the absolute 'Righteous and Noble Path' (Supatha) strictly to attain the ultimate supreme spiritual wealth (Raye / Liberation). 
            Whatever toxic deceit, crookedness, massive ego, and terrifying sins (Juhuranam eno) actively residing deep within us, please violently fight them and ruthlessly completely destroy them entirely from our pure souls (Yuyodhyasmat). We repeatedly, fiercely, and with the most extreme profound devotion offer our absolute highest and countless prostrations (Bhuyistham te nama) exclusively strictly to You! 
            This absolute final, magnificent verse of the Isha Upanishad is the ultimate, explosive cry of complete, 100% human unconditional Surrender. 'Agni' here is absolutely not mere physical fire; it is the absolute blazing fire of Supreme Wisdom fiercely violently burning inside us. 
            The supreme seeker fiercely cries out: "O Lord, I am completely powerless to kill my own massive sins and thick ego alone. You Yourself must violently burn away my dark karmas and forcefully drag me exactly to the right path." 
            Thus, entirely after delivering the absolute heaviest, most terrifyingly deep philosophy of pure knowledge and action, the grand Upanishad flawlessly uniquely ends entirely on the sweetest, most exceptionally humble note of pure 'Bhakti' (Devotion) and prayer. Without the absolute massive Grace of God, no human can ever possibly attain liberation. OM Peace!
        """.trimIndent()
    )
)