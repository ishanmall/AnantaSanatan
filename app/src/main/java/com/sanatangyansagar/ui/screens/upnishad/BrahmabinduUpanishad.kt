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
data class BrahmabinduShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrahmabinduUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..12) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-12)") },
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
            itemsIndexed(brahmabinduShlokasList) { _, shloka ->
                BrahmabinduShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun BrahmabinduShlokaCard(shloka: BrahmabinduShloka) {
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

val brahmabinduShlokasList: List<BrahmabinduShloka> = listOf(
    BrahmabinduShloka(
        id = 1,
        sanskrit = "ॐकारं बिन्दुसंयुक्तं नित्यं ध्यायन्ति योगिनः । कामदं मोक्षदं चैव ॐकाराय नमो नमः ॥ १ ॥",
        hindi = """
            महान योगी और मुनि हमेशा उस 'ॐ' (ओम्) का निरंतर ध्यान करते हैं जो 'बिंदु' से संयुक्त है।
            बिंदु का अर्थ यहाँ वह परम एकाग्रता और शिव-शक्ति का मूल स्रोत (Source) है।
            यह पवित्र ॐकार मनुष्य की सभी सात्विक इच्छाओं (कामनाओं) को पूरा करने वाला (कामदं) है।
            और यही ॐकार मनुष्य को जन्म और मृत्यु के चक्र से हमेशा के लिए मुक्त करने वाला (मोक्षदं) भी है।
            उस परम कल्याणकारी और शक्तिस्वरूप ॐकार (प्रणव) को हमारा बार-बार नमस्कार है।
            यह श्लोक ब्रह्मबिन्दु उपनिषद का सबसे शक्तिशाली और आधारभूत ध्यान-मंत्र है।
            ॐ के ऊपर जो बिंदी (ं) होती है, वह उस शून्यता और निराकार ईश्वर का प्रतीक है।
            योगी जब अपनी पूरी चेतना को उस बिंदु (Point of focus) पर लगा देता है, तो उसका मन स्थिर हो जाता है।
            यह केवल एक ध्वनि नहीं, बल्कि वह चाबी है जो संसार के सुख और परम शांति दोनों के ताले खोलती है।
            ॐ का ध्यान करने से इंसान का बिखरा हुआ दिमाग एक 'बिंदु' में आकर परम शक्ति बन जाता है।
        """.trimIndent(),
        english = """
            The great yogis perpetually and continuously meditate upon 'OM' which is united with the 'Bindu' (the dot).
            The Bindu here represents the ultimate point of absolute concentration and the core source of Shiva-Shakti.
            This sacred Omkara is the complete fulfiller of all righteous desires and pure wishes (Kamadam).
            And this exact same Omkara is also the absolute bestower of ultimate liberation (Mokshadam) from the cycle of rebirth.
            To that supremely auspicious and immensely powerful Omkara, we offer our salutations again and again.
            This verse is the most powerful and foundational meditation mantra of the Brahmabindu Upanishad.
            The dot (Bindu) on top of the OM symbol signifies that absolute void and the formless Supreme God.
            When a yogi successfully anchors his entire consciousness on that single point, his mind becomes perfectly still.
            It is not merely a sound, but the master key that unlocks both worldly joy and supreme cosmic peace.
            By meditating on OM, a scattered human mind converges into a single 'Bindu' and becomes ultimate power.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 2,
        sanskrit = "अक्षरं परमं ब्रह्म तस्य ध्यानेन मुच्यते । अज्ञानात् त्रसते लोको ज्ञानादेव विमुच्यते ॥ २ ॥",
        hindi = """
            वह ॐकार रूपी अक्षर (जिसका कभी क्षरण या नाश नहीं होता) ही साक्षात् परम ब्रह्म है।
            उस अविनाशी परब्रह्म के निरंतर ध्यान और स्मरण से मनुष्य सभी बंधनों से मुक्त हो जाता है।
            यह पूरा संसार केवल और केवल 'अज्ञान' (सत्य को न जानने) के कारण ही डरता और कांपता (त्रसते) रहता है।
            मौत का डर, बीमारी का डर और दुखों का डर—यह सब केवल अज्ञान का ही परिणाम है।
            मनुष्य केवल सच्चे 'ज्ञान' (आत्म-साक्षात्कार) के द्वारा ही इन सभी डरों से पूरी तरह मुक्त हो सकता है।
            उपनिषद यहाँ बहुत स्पष्ट करता है कि संसार में दुख का कारण कोई भगवान या शैतान नहीं है।
            हमारी अज्ञानता ही हमारा सबसे बड़ा शैतान है जो हमें इस शरीर में कैद मानकर डराता है।
            अक्षर ब्रह्म वह सुरक्षित घर है जिसके भीतर पहुँचने के बाद दुनिया का कोई तूफान हमें हिला नहीं सकता।
            जैसे अंधेरे में रस्सी को साँप समझकर इंसान डरता है, वैसे ही ज्ञान का प्रकाश उस डर को खत्म कर देता है।
            ज्ञान से मुक्ति (ज्ञानादेव विमुच्यते) ही सनातन धर्म का सबसे ऊँचा और अटल सिद्धांत है।
        """.trimIndent(),
        english = """
            That syllable OM (which is utterly imperishable and never decays) is indeed the Supreme Brahman itself.
            By continuous, profound meditation upon that indestructible Brahman, a human being is absolutely liberated.
            This entire world constantly trembles, suffers, and fears (Trasate) solely and exclusively due to 'Ignorance'.
            The terrifying fear of death, disease, and sorrow—all of these are merely the direct results of this ignorance.
            A human being can be completely and permanently freed from all these fears exclusively through true 'Wisdom'.
            The Upanishad makes it crystal clear here that neither God nor any devil is the cause of our worldly sorrow.
            Our own ignorance is our greatest devil, terrifying us by making us believe we are trapped in this body.
            The Imperishable Brahman is that highly secure home where, once inside, no worldly storm can ever shake us.
            Just as a man fears a rope mistaking it for a snake in the dark, the light of wisdom instantly kills that fear.
            Liberation exclusively through Wisdom (Jnanadeva Vimuchyate) is the highest, unshakeable doctrine of Sanatana Dharma.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 3,
        sanskrit = "बिन्दुनादकलातीतः शान्तः शुद्धो निरञ्जनः । तमात्मानं शिवं ज्ञात्वा सर्वपापैः प्रमुच्यते ॥ ३ ॥",
        hindi = """
            वह परमात्मा बिंदु (शून्य), नाद (ध्वनि) और कला (प्रकृति के अंश) इन तीनों की सीमाओं से पूरी तरह अतीत (परे) है।
            वह परम शांत है, पूर्ण रूप से शुद्ध है, और निरंजन (माया और अज्ञान के दागों से बिल्कुल अछूता) है।
            उस परम कल्याणकारी (शिव) और महान आत्मा को यथार्थ रूप में जान लेने पर (ज्ञात्वा)।
            मनुष्य अपने करोड़ों जन्मों के सभी प्रकार के पापों और कर्म-बंधनों से पूरी तरह मुक्त (प्रमुच्यते) हो जाता है।
            ध्यान की शुरुआत 'बिंदु' (Focus) और 'नाद' (Sound/OM) से होती है, पर ईश्वर इन साधनों से भी आगे है।
            ईश्वर उस सन्नाटे (Silence) में रहता है जो नाद (आवाज़) के पूरी तरह खत्म हो जाने पर आता है।
            'निरंजन' का अर्थ है जिस पर दुनिया की कीचड़ का कोई असर नहीं होता, जैसे कमल के पत्ते पर पानी नहीं रुकता।
            भगवान को जानने का मतलब है उस 'शिव' (कल्याण) तत्व को अपने ही हृदय में साक्षात् महसूस करना।
            जब सत्य का सूरज उगता है, तो पापों का सारा अँधेरा चाहे वह कितना भी पुराना क्यों न हो, एक पल में नष्ट हो जाता है।
            पाप हमारे शरीर और अहंकार का मैल है, आत्मा तो हमेशा से पवित्र ही है।
        """.trimIndent(),
        english = """
            That Supreme Lord is completely beyond (Atita) the boundaries of Bindu (focus/void), Nada (sound), and Kala (parts/manifestation).
            He is perfectly tranquil, absolutely pure, and completely Niranjana (untouched by any stain of Maya or ignorance).
            Having truly realized and known that supremely auspicious (Shiva) and Great Soul within oneself.
            A human being becomes entirely completely liberated (Pramuchyate) from all sins of millions of past lifetimes.
            Meditation begins with 'Bindu' (focus) and 'Nada' (OM/sound), but God exists far beyond even these initial tools.
            God dwells strictly in that profound Silence which remains after the sound (Nada) has completely faded away.
            'Niranjana' means He upon whom worldly mud leaves zero impact, just as water cannot stick to a lotus leaf.
            Knowing God means directly feeling and experiencing that 'Shiva' (auspicious) principle right in one's own heart.
            When the sun of Truth rises, the darkness of all sins, no matter how ancient, is destroyed in a single second.
            Sin is merely the dirt of our physical body and ego; the Soul has always been immaculately pure.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 4,
        sanskrit = "अमन्त्रं चामनं चैव अवाचं निरुपाधिकम् । यस्तद्वेद स वेदवित् स मुनिः स च तत्त्ववित् ॥ ४ ॥",
        hindi = """
            वह परब्रह्म किसी मंत्र के उच्चारण (अमन्त्रं) से सीमित नहीं है और न ही वह मन की कल्पना (अमनं) का विषय है।
            वह वाणी (अवाचं) के द्वारा नहीं बोला जा सकता, और वह सभी प्रकार की सांसारिक उपाधियों (नाम, रूप, पद) से पूरी तरह मुक्त है।
            जो व्यक्ति उस परम निराकार और असीम तत्व को भलीभांति जान (वेद) लेता है।
            वही वेदों का असली ज्ञाता (वेदवित्) है, वही सच्चा मुनि है, और वही ब्रह्मांड का सबसे बड़ा तत्त्वज्ञानी (तत्त्ववित्) है।
            हम सोचते हैं कि कुछ खास मंत्र जपने से भगवान मिल जाएंगे, पर भगवान मंत्रों की आवाज़ से बहुत ऊपर है।
            मन केवल उसी चीज़ को सोच सकता है जो उसने देखी हो, इसलिए मन भगवान को कभी सोच (कवर) नहीं सकता।
            उपाधियां (जैसे राजा, रंक, इंसान, देवता) केवल शरीर के लिए होती हैं; ब्रह्म की कोई जाति या पद नहीं होता।
            ज्ञानी वह नहीं है जिसे सारे वेद मुँह-ज़बानी याद हों; ज्ञानी वह है जिसने वेदों के अंतिम लक्ष्य (ब्रह्म) को पा लिया है।
            जो मौन की भाषा समझता है और जो उस 'अमन' (No-mind) की स्थिति में ठहर जाता है, वही मुनि है।
            यह श्लोक कर्मकांडों (Rituals) से ऊपर उठकर सीधे आत्मज्ञान की ओर ले जाने का सबसे बड़ा निमंत्रण है।
        """.trimIndent(),
        english = """
            That Supreme Brahman cannot be confined by any chanted Mantra (Amantram), nor is He a subject of the mind's imagination (Amanam).
            He absolutely cannot be spoken or described by speech (Avacham), and He is completely free from all worldly titles and labels (Nirupadhikam).
            The person who truly and completely knows (Veda) that supreme formless and boundless principle.
            He alone is the true knower of the Vedas (Vedavit), he alone is a true sage (Muni), and he is the ultimate knower of Truth (Tattvavit).
            We falsely assume chanting specific mantras will capture God, but God exists far above the sounds of any mantras.
            The mind can only think of what it has already seen; therefore, the mind can never encompass or imagine God.
            Titles (like King, beggar, human, demigod) are strictly for the body; Brahman possesses no caste, rank, or label.
            A knower is not one who has memorized all the Vedas; a knower is he who has attained the final goal of the Vedas.
            He who understands the language of silence and becomes perfectly established in that 'No-mind' state is the true Muni.
            This verse is the greatest invitation to rise far above mere rituals and head straight toward absolute Self-knowledge.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 5,
        sanskrit = "ज्ञानेन मथ्यते सर्वं ज्ञेयं यत् तत् प्रकाशते । ज्ञाता ज्ञानं तथा ज्ञेयं त्रयमेतन्निरावलम्बम् ॥ ५ ॥",
        hindi = """
            ज्ञान रूपी मथानी (मथने वाला डंडा) से जब अज्ञान और शास्त्रों का निरंतर मन्थन (मथ्यते) किया जाता है।
            तब वह जो जानने योग्य परम सत्य (ज्ञेयं) है, वह अपने-आप हृदय में पूरी तरह प्रकाशित (प्रकाशते) हो उठता है।
            जब वह सत्य प्रकट होता है, तब ज्ञाता (जानने वाला), ज्ञान (जानने की प्रक्रिया), और ज्ञेय (जो जाना जा रहा है)।
            ये तीनों एक हो जाते हैं और निरावलंब (बिना किसी बाहरी सहारे के) केवल एक परम शून्य/पूर्णता में बदल जाते हैं।
            यह ध्यान और समाधि की सबसे ऊँची अवस्था (त्रिपुटी का नाश) का वर्णन है।
            जैसे दूध को मथने से उसमें छिपा हुआ मक्खन बाहर आ जाता है, वैसे ही मन को मथने से आत्मा प्रकट होती है।
            ध्यान के शुरुआती दौर में तीन चीजें होती हैं: मैं (ज्ञाता), मेरा ध्यान (ज्ञान), और भगवान (ज्ञेय)।
            पर जब ध्यान बहुत गहरा होता है, तो ये तीनों दीवारें टूट जाती हैं और केवल 'एक' ही बचता है।
            उस अवस्था में न कोई ध्यान करने वाला बचता है और न कोई वस्तु; बस एक अनंत और निराधार (निरावलंब) शांति होती है।
            यही वह अवस्था है जहाँ जाकर साधक स्वयं भगवान का ही रूप (ब्रह्म-स्वरूप) बन जाता है।
        """.trimIndent(),
        english = """
            When ignorance and scriptures are continuously churned (Mathyate) using the powerful churning-stick of Wisdom.
            Then that Supreme Truth which is worthy to be known (Jneyam) automatically shines and illuminates perfectly in the heart.
            When that Truth fully manifests, then the Knower (subject), the Knowledge (process), and the Known (object).
            These three completely merge into one and transform into an absolute, supportless (Niralambam) supreme void/fullness.
            This describes the absolute highest state of meditation and Samadhi (the destruction of the Triputi/triad).
            Just as churning milk brings out the hidden butter, churning the mind continuously reveals the hidden Soul.
            In the early stages of meditation, there are three: I (Knower), my meditation (Knowledge), and God (Known).
            But when meditation becomes infinitely deep, these three walls shatter entirely, and only 'One' remains.
            In that state, neither a meditator nor an object of meditation remains; there is only an infinite, supportless Peace.
            This is exactly the state where the seeker himself flawlessly becomes the very embodiment of God (Brahman).
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 6,
        sanskrit = "यत्र नास्ति जगत्सर्वं यत्र नास्ति विचारणा । तत्र यत्परमं तत्त्वं तदहमस्मि न संशयः ॥ ६ ॥",
        hindi = """
            जहाँ इस संपूर्ण दृश्यमान जगत (दुनिया) का कोई भी अस्तित्व बिल्कुल नहीं है (यत्र नास्ति जगत्सर्वं)।
            और जहाँ मन में उठने वाली किसी भी प्रकार की कोई विचारणा (सोच या कल्पना) भी शेष नहीं रहती है।
            उस अवस्था में जो एकमात्र महान और 'परम तत्त्व' (सर्वोच्च सत्य) शेष बचता है।
            "निश्चित रूप से मैं वही परम तत्व हूँ" (तदहमस्मि), इसमें किसी भी प्रकार का कोई संशय (शक) नहीं है।
            यह श्लोक अद्वैत वेदान्त की सबसे निडर (Fearless) और शक्तिशाली घोषणाओं में से एक है।
            जब हम गहरी समाधि में जाते हैं, तो यह दुनिया और इसके सारे नाटक पूरी तरह गायब हो जाते हैं।
            वहाँ दिमाग कुछ सोच नहीं रहा होता है, इसलिए वहाँ कोई दुख, कोई सुख और कोई डर नहीं होता।
            उस 'नो-माइंड' (No-mind) और 'नो-वर्ल्ड' (No-world) की स्थिति में जो शुद्ध 'मैं' (Awareness) बचता है, वही ईश्वर है।
            साधक डंके की चोट पर कहता है कि मुझे अब कोई शक नहीं है; मुझे अपना असली चेहरा (ब्रह्म) मिल गया है।
            यह वह ज्ञान है जो इंसान को भिखारियों की तरह दुनिया से सुख माँगने की आदत से हमेशा के लिए आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            Where this entire visible, physical world has absolutely zero existence whatsoever (Yatra nasti jagatsarvam).
            And where absolutely no thought, contemplation, or imagination of the mind remains existing anymore.
            In that ultimate state, whatever single, great 'Supreme Principle' (Absolute Truth) remains left over.
            "I am undoubtedly and certainly that exact Supreme Principle" (Tadaham asmi), there is absolutely no doubt about this.
            This verse is one of the most fearless, powerful, and majestic declarations in all of Advaita Vedanta.
            When we enter extremely deep Samadhi, this entire world and all its dramatic plays vanish completely.
            The brain isn't thinking anything there, hence there is absolutely no sorrow, no pleasure, and zero fear.
            In that state of 'No-mind' and 'No-world', the pure 'I' (unbroken Awareness) that remains is God Himself.
            The seeker declares with absolute authority that he has zero doubts left; he has found his true face (Brahman).
            This is the profound wisdom that permanently frees a human from the pathetic habit of begging the world for happiness.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 7,
        sanskrit = "आकाशमिव सर्वत्र व्याप्तं सर्वत्र सर्वदा । तदहमस्मि न संशयः ॥ ७ ॥",
        hindi = """
            जिस प्रकार यह विशाल आकाश (Space) हर जगह और हर वस्तु के भीतर और बाहर समान रूप से व्याप्त है।
            ठीक उसी प्रकार, जो परम तत्व हर जगह (सर्वत्र) और हर समय (सर्वदा) समान रूप से मौजूद है।
            "निश्चित रूप से मैं वही सर्वव्यापी और अनंत तत्व (ब्रह्म) हूँ", इसमें मुझे बिल्कुल भी कोई संशय (Doubt) नहीं है।
            आत्मा को समझाने के लिए पूरे ब्रह्मांड में 'आकाश' से बेहतर कोई दूसरा उदाहरण नहीं है।
            आकाश दीवार के अंदर भी है और दीवार के बाहर भी; दीवार आकाश को काट या बाँट नहीं सकती।
            इसी तरह, हमारी आत्मा इस शरीर के अंदर भी है और शरीर के बाहर पूरे ब्रह्मांड में भी फैली है।
            हम शरीर में कैद नहीं हैं; यह केवल हमारी सीमित सोच (Limiting belief) है जिसने हमें छोटा बना रखा है।
            जब साधक को अपनी इस 'आकाश जैसी' विशालता का अहसास होता है, तो उसका सारा अहंकार टूट कर गिर जाता है।
            फिर न तो जन्म उसे पैदा करता है और न ही मृत्यु उसे मिटा सकती है, क्योंकि आकाश कभी मरता नहीं।
            "मैं ही वह हूँ" (सोऽहम्)—यही वह परम मंत्र है जो जीव को शिव में बदल देता है।
        """.trimIndent(),
        english = """
            Exactly just as this vast space (Akasha) is completely and equally pervading everywhere, inside and outside of everything.
            In the precise same manner, that Supreme Principle which is equally present absolutely everywhere (Sarvatra) and at all times (Sarvada).
            "I am undoubtedly and certainly that exact all-pervading and infinite Principle (Brahman)," there is absolutely no doubt in this.
            To explain the Soul, there is absolutely no better example in the entire universe than 'Space' (Akasha).
            Space is inside the wall and outside the wall; the wall cannot possibly cut, divide, or restrict the space.
            Similarly, our Soul is inside this physical body and also spread endlessly throughout the entire cosmos outside the body.
            We are absolutely not imprisoned in bodies; it is merely our toxic limiting belief that makes us feel so small.
            When a seeker genuinely realizes this 'Space-like' vastness of his being, all his ego shatters and falls away.
            Then neither birth creates him nor can death destroy him, because Space simply never dies.
            "I am That" (So-ham)—this is that supreme mantra that permanently transforms the creature into Shiva.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 8,
        sanskrit = "न देहो न च जीवात्मा नेन्द्रियाणि मनो न च । अहमेव परं ब्रह्म न संशयः ॥ ८ ॥",
        hindi = """
            (साधक अपने झूठे आवरणों को नकारता है): मैं यह नाशवान और हड्डियों से बना हुआ भौतिक देह (शरीर) बिल्कुल नहीं हूँ।
            मैं वह 'जीवात्मा' (कर्मों के चक्र में फँसा हुआ जीव) भी नहीं हूँ, और न ही मैं ये देखने-सुनने वाली इंद्रियां हूँ।
            मैं यह चंचल और अशांत 'मन' भी बिल्कुल नहीं हूँ; (मैं इन सभी उपाधियों और सीमाओं से पूरी तरह मुक्त हूँ)।
            "वास्तव में, मैं तो केवल वह परम अविनाशी ब्रह्म हूँ", इसमें मुझे अब रत्ती भर भी संशय (शक) नहीं है।
            यह श्लोक 'नेति-नेति' (यह नहीं, यह नहीं) की सबसे महान वेदान्तिक प्रक्रिया का प्रत्यक्ष उदाहरण है।
            हम अपने जीवन भर खुद को शरीर, विचार या इंद्रियां मानकर उनके दुखों को अपना दुख मान लेते हैं।
            जब शरीर बीमार होता है, तो हम कहते हैं "मैं बीमार हूँ"; जब मन दुखी होता है, तो हम कहते हैं "मैं दुखी हूँ।"
            ज्ञानी पुरुष एक-एक करके इन सभी झूठे छिलकों (Layers) को उतार कर फेंक देता है।
            जब शरीर, मन और इंद्रियां मुझसे अलग हो जाते हैं, तो जो शुद्ध 'चेतना' बचती है, वही परब्रह्म है।
            सारे दुखों की जड़ गलत पहचान है; अपनी असली पहचान (ब्रह्म) को जानना ही जीवन की परम सफलता है।
        """.trimIndent(),
        english = """
            (The seeker negates his false coverings): I am absolutely not this perishable physical body made of flesh and bones.
            I am not that 'Jivatma' (the bound creature trapped in karma), nor am I these seeing and hearing physical senses.
            I am absolutely not this restless, unstable, and chaotic 'Mind' either; (I am completely free from all these limits).
            "In reality, I am exclusively that Supreme, indestructible Brahman alone," there is absolutely no doubt about this anymore.
            This verse is a direct and supreme example of the great Vedantic process of 'Neti-Neti' (Not this, Not this).
            All our lives we falsely identify as the body, thoughts, or senses, and foolishly accept their sorrows as our own.
            When the body is sick, we say "I am sick"; when the mind is sad, we say "I am sad."
            A wise, realized man strips away and ruthlessly throws out all these false, superficial layers one by one.
            When body, mind, and senses are completely separated from me, the pure 'Consciousness' that remains is Brahman.
            The root of all sorrow is false identity; knowing your real identity (Brahman) is the supreme success of life.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 9,
        sanskrit = "यथा जले जलं क्षिप्तं क्षीरे क्षीरं घृते घृतम् । अविशेषो भवेत्तद्वज्जीवात्मपरमात्मनोः ॥ ९ ॥",
        hindi = """
            जिस प्रकार शुद्ध जल में जब बाहर से दूसरा जल डाला जाता है, तो वे दोनों मिलकर पूरी तरह एक हो जाते हैं।
            जैसे दूध में दूध मिलाने पर, और घी में घी मिलाने पर उन दोनों में कोई भी भेद या अंतर (अविशेष) नहीं रह जाता।
            ठीक उसी प्रकार, जब ज्ञान के द्वारा अज्ञान का पर्दा हट जाता है।
            तो जीवात्मा (Individual soul) और परमात्मा (Supreme Soul) के बीच भी कोई भेद या अंतर शेष नहीं रहता, वे एक हो जाते हैं।
            यह अद्वैत (Non-duality) का सबसे सरल और सबसे गहरा प्राकृतिक उदाहरण है।
            पानी को पानी में मिलाने के बाद क्या आप बता सकते हैं कि कौन सा पानी कहाँ से आया था? बिल्कुल नहीं।
            हम सोचते हैं कि जीव और भगवान हमेशा अलग रहेंगे; जीव सेवक रहेगा और भगवान मालिक रहेगा।
            पर उपनिषद कहता है कि यह अलगाव (Separation) केवल तब तक है जब तक 'अहंकार' का बर्तन बीच में है।
            जब साधना से अहंकार का वह बर्तन टूट जाता है, तो जीव की चेतना भगवान की चेतना में हमेशा के लिए विलीन हो जाती है।
            इसी अवस्था को मोक्ष या निर्वाण कहते हैं, जहाँ قطरा (बूँद) स्वयं समंदर बन जाता है।
        """.trimIndent(),
        english = """
            Just as when pure water is poured directly into other pure water, they merge and become completely, indistinguishably one.
            Just as when milk is mixed with milk, and when ghee is mixed with ghee, absolutely no difference or distinction remains between them.
            In the exact same way, when the thick veil of ignorance is completely removed by the fire of wisdom.
            Absolutely no difference or separation remains between the Jivatma (individual soul) and Paramatma (Supreme Soul); they become completely One.
            This is the simplest and most profoundly deep natural example of Advaita (Non-duality).
            After mixing water with water, can you ever separate or identify which water came from where? Absolutely not.
            We falsely think that the soul and God will always remain separate; the soul a servant, and God the Master.
            But the Upanishad declares this separation lasts only as long as the pot of 'Ego' stands solidly between them.
            When that pot of ego shatters through Sadhana, the soul's consciousness dissolves permanently into God's consciousness.
            This exact state is called Moksha or Nirvana, where the tiny drop flawlessly becomes the vast ocean itself.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 10,
        sanskrit = "यदा सर्वं जगत्स्वप्नं पश्यति ज्ञानचक्षुषा । तदा स मुच्यते बन्धादहं ब्रह्मेति निश्चयः ॥ १० ॥",
        hindi = """
            जब कोई साधक अपनी 'ज्ञान रूपी आँख' (विवेक और अंतर्दृष्टि) के द्वारा।
            इस संपूर्ण दिखाई देने वाले जगत (दुनिया) को केवल एक 'स्वप्न' (सपने) के समान नाशवान और भ्रम देखने लगता है।
            तब वह साधक संसार के सभी दुखों, बंधनों और जन्म-मरण के चक्र से हमेशा के लिए मुक्त (मुच्यते) हो जाता है।
            और उसके हृदय में यह अटल निश्चय हो जाता है कि "निश्चित रूप से मैं ही वह परम ब्रह्म हूँ" (अहं ब्रह्मास्मि)।
            सपने में जब हम शेर देखते हैं तो डर जाते हैं, पर जागने के बाद हमें उस शेर से कोई डर नहीं लगता, क्योंकि वह झूठ था।
            उसी तरह, यह दुनिया भी अज्ञान की नींद में देखा जा रहा एक बहुत लंबा और असली लगने वाला सपना ही है।
            ज्ञानी व्यक्ति इस दुनिया में रहता है, काम करता है, पर वह जानता है कि यह सब केवल माया का एक खेल है।
            ज्ञान चक्षु (Eye of Wisdom) खुलने का मतलब है चीज़ों को उनके असली (Temporary) रूप में देखना।
            जब दुनिया सपना लगने लगती है, तो दुनिया की कोई भी चीज़ (पैसा, अपमान, दुख) आपको रुला नहीं सकती।
            यही मुक्ति है—जहाँ इंसान जाग जाता है और जान जाता है कि इस पूरे सपने को देखने वाला अमर ब्रह्म मैं ही हूँ।
        """.trimIndent(),
        english = """
            When a sincere seeker, through his fully awakened 'Eye of Wisdom' (discrimination and inner vision).
            Begins to see this entire visible physical world merely as a fleeting, perishable, and illusory 'Dream'.
            Then that seeker is permanently and completely liberated (Muchyate) from all worldly bonds, sorrows, and the cycle of rebirth.
            And an unbreakable, absolute conviction takes root in his heart: "I am undoubtedly that Supreme Brahman" (Aham Brahmasmi).
            When we see a lion in a dream, we get terrified, but upon waking, we don't fear it at all because it was false.
            Similarly, this physical world is just a very long, realistic-seeming dream being experienced in the sleep of ignorance.
            A wise man lives in this world and works, but he knows perfectly well that this is all merely a grand play of Maya.
            Opening the Eye of Wisdom means seeing worldly things in their true, inherently temporary and perishable nature.
            When the world feels like a dream, absolutely nothing in the world (money, insult, grief) can ever make you cry.
            This is true liberation—where a human wakes up and realizes that the immortal Brahman witnessing this entire dream is ME.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 11,
        sanskrit = "आनन्दमन्तरो नास्ति यत्रानन्दः प्रकाशते । स आनन्दः परं ब्रह्म सानन्दोऽहं न संशयः ॥ ११ ॥",
        hindi = """
            उस परमानंद (ब्रह्मानंद) के अंदर किसी भी प्रकार का कोई दूसरा आनंद या भेद (अन्तरो) बिल्कुल नहीं है।
            जहाँ वह शुद्ध और अखंड आनंद अपने आप प्रकाशित होता है (अर्थात जिसे किसी बाहरी कारण की जरूरत नहीं होती)।
            वह परम आनंद ही साक्षात् परम ब्रह्म है (ईश्वर आनंद का स्रोत नहीं, वह स्वयं ही आनंद है)।
            "मैं निश्चित रूप से वही पूर्ण आनंद-स्वरूप (सानन्दोऽहं) ब्रह्म हूँ", इसमें मुझे बिल्कुल भी कोई संशय नहीं है।
            दुनिया के सुख हमेशा किसी चीज़ से आते हैं (जैसे स्वादिष्ट खाना या पैसे मिलने पर), इसलिए वे 'कारण' पर टिके हैं।
            जब खाना खत्म, तो सुख खत्म। पर आत्मा का आनंद (Bliss) 'अकारण' है; वह किसी चीज़ का मोहताज नहीं है।
            वह आनंद हमारा असली स्वभाव है; जैसे चीनी का स्वभाव मीठा होना है, वैसे ही आत्मा का स्वभाव आनंद है।
            हम जीवन भर सुख बाहर ढूँढते हैं, जबकि सुख का महासागर हमारे ही भीतर लहरें मार रहा है।
            जब साधक को यह बात गहराई से समझ आ जाती है, तो वह बाहर भीख माँगना बंद कर देता है।
            "मैं ही आनंद हूँ"—इस एक सोच के पक्का होते ही जीवन के सारे दुख और निराशा हमेशा के लिए भाप बनकर उड़ जाते हैं।
        """.trimIndent(),
        english = """
            Within that supreme bliss (Brahmananda), there is absolutely no other inferior bliss or division (Antaro) whatsoever.
            Where that pure, unbroken bliss illuminates and shines completely by itself (meaning, it requires no external cause or object).
            That supreme bliss itself is the direct Supreme Brahman (God is not merely the source of bliss, He is Bliss itself).
            "I am undoubtedly and certainly that exact embodiment of supreme Bliss (Sanandoham)," there is absolutely no doubt in this.
            Worldly pleasures always come from an object (like tasty food or money), hence they are entirely dependent on a 'cause'.
            When the food is gone, the joy is gone. But the Bliss of the Soul is 'causeless'; it depends on absolutely nothing.
            That Bliss is our original nature; just as the nature of sugar is sweetness, the core nature of the Soul is Bliss.
            We spend our entire lives searching for joy outside, while the infinite ocean of bliss is violently waving right inside us.
            When a seeker understands this profoundly, he completely stops begging like a beggar from the outside world.
            "I am Bliss itself"—the moment this single thought solidifies, all miseries and depressions of life vaporize forever.
        """.trimIndent()
    ),
    BrahmabinduShloka(
        id = 12,
        sanskrit = "इति ब्रह्मबिन्दूपनिषत् समाप्ता ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
        hindi = """
            (उपसंहार): इस प्रकार यह अत्यंत पवित्र और ज्ञान से भरपूर 'ब्रह्मबिन्दु उपनिषद' यहाँ पूर्ण रूप से समाप्त (समाप्ता) होता है।
            इस उपनिषद ने हमें यह सिखाया है कि मन ही बंधन और मुक्ति का एकमात्र कारण है।
            इसने हमें ॐकार (बिंदु) के ध्यान के माध्यम से उस अविनाशी ब्रह्म तक पहुँचने का सीधा रास्ता दिखाया है।
            और इसने यह सिद्ध कर दिया है कि जीवात्मा और परमात्मा वास्तव में पानी में मिले पानी की तरह एक ही हैं।
            यह छोटा सा उपनिषद वेदान्त दर्शन का एक अत्यंत शक्तिशाली और गागर में सागर भरने वाला ग्रंथ है।
            इसका निरंतर पाठ और मनन साधक के भीतर से अज्ञान के सारे जालों को काटकर उसे अमृतत्व (अमरता) प्रदान करता है।
            ॐ शांतिः शांतिः शांतिः।
            (हमारे शरीर में शांति हो, हमारे मन में शांति हो, और हमारी आत्मा उस परम शांति में हमेशा के लिए विलीन हो जाए)।
            भगवान हमारे सभी आध्यात्मिक प्रयासों को सफल करें और हमें उस परम ब्रह्म का साक्षात् अनुभव प्रदान करें।
            इति शुभम्।
        """.trimIndent(),
        english = """
            (Conclusion): Thus, this exceedingly sacred, wisdom-filled 'Brahmabindu Upanishad' is completely and joyfully concluded (Samapta) here.
            This magnificent Upanishad has profoundly taught us that the mind alone is the absolute cause of both bondage and liberation.
            It has shown us the most direct and flawless path to reach the indestructible Brahman through meditation on the Omkara (Bindu).
            And it has flawlessly proven that the individual soul and the Supreme Soul are exactly one, like water mixed completely in water.
            This short Upanishad is a tremendously powerful text of Vedantic philosophy, perfectly holding an ocean within a single pot.
            Its continuous study and deep contemplation cuts through all webs of ignorance within the seeker, granting him absolute Immortality.
            OM Peace, Peace, Peace.
            (May there be perfect peace in our physical body, peace in our restless mind, and may our soul merge in that Supreme Peace forever).
            May the Supreme Lord crown all our sincere spiritual efforts with absolute success and grant us the direct, living experience of Brahman.
            Thus ends auspiciously.
        """.trimIndent()
    )
)