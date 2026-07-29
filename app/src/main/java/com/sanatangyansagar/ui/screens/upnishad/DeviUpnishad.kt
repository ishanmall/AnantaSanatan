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
data class DeviShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviUpanishadScreen() {
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
                // Range updated for 1..20
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
            itemsIndexed(deviShlokasList) { _, shloka ->
                DeviShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun DeviShlokaCard(shloka: DeviShloka) {
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

// Complete List of Devi Upanishad Shlokas 1 to 20
val deviShlokasList = listOf(
    DeviShloka(
        id = 1,
        sanskrit = "सर्वे वै देवा देवीमुपतस्थुः कासि त्वं महादेवीति ॥ १॥",
        hindi = """
            (देवताओं का परम सत्ता से सीधा प्रश्न): यह उपनिषद ब्रह्मांड के सबसे बड़े और खौफनाक सवाल से शुरू होता है।
            सृष्टि के सभी महान देवता (ब्रह्मा, विष्णु, शिव, इंद्र आदि) अपनी शक्तियों का घमंड छोड़कर साक्षात 'महादेवी' के सामने हाथ जोड़कर खड़े हो गए।
            उन्होंने एक स्वर में ब्रह्मांड को हिला देने वाला प्रश्न पूछा: "हे महादेवी! तुम असल में कौन हो?" (कासि त्वं महादेवीति)।
            यह सवाल देवताओं की लाचारी और अज्ञान को दिखाता है; वे समझ गए थे कि जो सत्ता उन्हें चला रही है, वह उनसे भी बहुत ऊपर है।
            देवता स्वर्ग के राजा हो सकते हैं, लेकिन वे उस परम चेतना को नहीं जानते थे जिसके इशारे पर उनका स्वर्ग टिका हुआ है।
            यह कोई साधारण देवी की पूजा नहीं थी; यह साक्षात 'मूल प्रकृति' (Absolute Origin) से उसके अस्तित्व का रहस्य पूछने का दुस्साहस था।
            जब तक इंसान या देवता अपने अहंकार ('मैं सब जानता हूँ') को नहीं मारते, तब तक सत्य कभी प्रकट नहीं होता।
            देवताओं का यह समर्पण साबित करता है कि ब्रह्मांड की असली मालकिन कोई पुरुष देवता नहीं, बल्कि एक असीम मातृ-शक्ति है।
            यहाँ से देवी का वह प्रलयंकारी उत्तर शुरू होता है, जो वेदांत और विज्ञान के सारे चिथड़े उड़ा कर रख देगा।
            यह उपनिषद सत्य की सबसे भयानक और नंगी तस्वीर (Naked Reality) दुनिया के सामने रखने जा रहा है।
        """.trimIndent(),
        english = """
            (The Direct Cosmic Confrontation): This Upanishad violently detonates with the most terrifying, colossal question in the cosmos.
            Absolutely all the supreme gods of creation (Brahma, Vishnu, Shiva, Indra) completely abandoned their pathetic divine arrogance and stood paralyzed before the 'Maha-Devi'.
            They collectively roared a universe-shattering question: "O Supreme Great Goddess! Who exactly are You?" (Kasi tvam Mahadevi ti).
            This raw question explicitly exposes the severe ignorance and helplessness of the gods; they finally realized that the raw power operating them was infinitely superior.
            The gods may be kings of heavenly dimensions, but they were entirely clueless about the Absolute Consciousness upon which their heavens rested.
            This was definitively not a mundane prayer; it was the sheer audacity to demand the ultimate secret of existence directly from the 'Root Nature' (Mula Prakriti) Herself.
            Until a human or a god violently slaughters their pathetic ego ('I know everything'), the Absolute Truth absolutely never reveals itself.
            This total surrender of the cosmic deities permanently proves that the absolute Dictator of the universe is not a male god, but a boundless, infinite Mother-Power.
            From this exact microsecond, the Goddess begins Her apocalyptic reply, which will ruthlessly shred all conventional philosophy and material science into dust.
            This Upanishad is about to expose the most terrifying, naked, and unfiltered reality of existence to the universe.
        """.trimIndent()
    ),
    DeviShloka(
        id = 2,
        sanskrit = "साब्रवीत् - अहं ब्रह्मस्वरूपिणी । मत्तः प्रकृतिपुरुषात्मकं जगत् । शून्यं चाशून्यं च ॥ २॥",
        hindi = """
            (देवी का प्रलयंकारी उत्तर): महादेवी ने देवताओं की आँखों में देखते हुए ब्रह्मांड का सबसे बड़ा रहस्य खोल दिया।
            उसने गर्जना करते हुए कहा— "मैं ही साक्षात परब्रह्म का असली स्वरूप हूँ!" (अहं ब्रह्मस्वरूपिणी)।
            "यह पूरा ब्रह्मांड—चाहे वह 'प्रकृति' (Matter/Energy) हो, या 'पुरुष' (Consciousness/आत्मा)—केवल और केवल मुझसे ही पैदा हुआ है।"
            "जो कुछ 'शून्य' (Void/Empty Space) है, वह मैं हूँ; और जो 'अशून्य' (Solid Matter/ग्रह, तारे) है, वह भी मैं ही हूँ।"
            देवी ने एक ही झटके में शिव और शक्ति, पुरुष और प्रकृति के भेद को जलाकर राख कर दिया।
            लोग सोचते हैं कि भगवान (पुरुष) अलग है और दुनिया (प्रकृति) अलग है; लेकिन देवी कह रही है कि वह खुद ही यह दोनों है!
            जब दुनिया नहीं थी, तब जो खौफनाक सन्नाटा (शून्य) था, वह देवी थी; और जब दुनिया बनी (अशून्य), तो वह भी देवी ही है।
            उस परम सत्ता के बाहर एक सूई की नोक के बराबर भी कोई ऐसी जगह नहीं है, जहाँ कुछ और मौजूद हो।
            यह अद्वैत (Non-Duality) का वह चरम शिखर है जहाँ भगवान कोई व्यक्ति नहीं रह जाता, बल्कि साक्षात 'अस्तित्व' (Existence) बन जाता है।
            तुम्हारी आत्मा (पुरुष) और तुम्हारा शरीर (प्रकृति), दोनों उसी एक माँ के बनाए हुए दो अलग-अलग मुखौटे हैं।
        """.trimIndent(),
        english = """
            (The Apocalyptic Reply of the Goddess): Staring directly into the terrified eyes of the supreme gods, the Maha-Devi violently ripped open the greatest secret of the cosmos.
            She roared with absolute cosmic authority: "I am explicitly the exact literal form of the Supreme Brahman!" (Aham Brahmasvarupini).
            "This entire colossal matrix—whether it is 'Prakriti' (Raw Material Energy) or 'Purusha' (Pure Cosmic Consciousness/Soul)—violently erupts strictly from Me alone."
            "Whatever is an absolute terrifying 'Void' (Shunya), I am That; and whatever is solid, dense 'Matter' (Ashunya/planets, stars), I am explicitly That as well."
            In a single devastating strike, the Goddess permanently incinerated the pathetic dualistic illusion separating Shiva and Shakti, Consciousness and Matter.
            Ignorant fools hallucinate that God (Purusha) is separate from the physical universe (Prakriti); but the Goddess dictates She Herself is violently playing both roles simultaneously!
            Before the big bang, the deathly, horrifying cosmic silence (Void) was Her; and the violently exploding material matrix (Ashunya) is also exactly Her.
            Beyond Her supreme existence, there is absolutely not a single millimeter of unmapped space where any 'other' entity can exist.
            This is the absolute terrifying zenith of Non-Duality (Advaita), where God ceases to be a person and mutates strictly into raw 'Existence' itself.
            Your biological consciousness (Purusha) and your rotting flesh (Prakriti) are strictly two different masks worn by that exact same Supreme Mother.
        """.trimIndent()
    ),
    DeviShloka(
        id = 3,
        sanskrit = "अहमानन्दानानन्दौ । अहं विज्ञानाविज्ञाने । अहं ब्रह्माब्रह्मणी वेदितव्ये ।",
        hindi = """
            (आनंद-दुख और ज्ञान-अज्ञान भी वही है): देवी अब दुनिया की हर अच्छी और बुरी चीज़ को अपने भीतर समेट रही है।
            "इस ब्रह्मांड का सारा परमानंद (सुख) मैं हूँ, और जो कुछ भी भयंकर दुख या पीड़ा (अनानन्द) है, वह भी साक्षात मैं ही हूँ!"
            "संसार का सारा असीम ज्ञान और विज्ञान (Intelligence) मैं हूँ; और जो घोर अज्ञान या मूर्खता (Ignorance) है, वह भी मैं ही हूँ!"
            "जो साक्षात 'ब्रह्म' (परमेश्वर) है, वह भी मैं हूँ; और जो 'अब्रह्म' (माया या नाशवान दुनिया) है, वह भी साक्षात मैं ही हूँ!"
            यह श्लोक इंसान के दिमाग की सारी प्रोग्रामिंग (अच्छा-बुरा) को जड़ से उखाड़ देता है।
            इंसान सोचता है कि भगवान केवल सुख देता है और दुख शैतान देता है; यह दुनिया का सबसे बड़ा झूठ है।
            देवी चीख कर कह रही है कि जब तुम रोते हो, तो तुम्हारी वो भयानक पीड़ा (अनानन्द) भी साक्षात उसी देवी का एक रूप है।
            जब दुनिया तुम्हें धोखा देती है (अज्ञान), तो वह धोखा भी उसी शक्ति का एक जादुई खेल है।
            सच्चा साधक सुख और दुख, दोनों में केवल उसी एक माँ को देखता है; वह दुखों से भागता नहीं, उन्हें देवी का प्रसाद मानकर पी जाता है।
            जो इस खौफनाक सच को पचा लेता है, वह दुनिया के सारे डरों (Fear) से हमेशा के लिए आज़ाद होकर अजेय (Invincible) बन जाता है।
        """.trimIndent(),
        english = """
            (Bliss-Agony and Wisdom-Ignorance are Both Her): The Goddess now violently consumes absolutely every positive and negative concept of reality directly into Her own biology.
            "I am unequivocally all the supreme infinite Bliss (Ananda) in this cosmos; and whatever catastrophic agony or horrific suffering (Anananda) exists, is also explicitly Me!"
            "I am the absolute zenith of cosmic Intelligence and Wisdom (Vijnana); and the deepest, darkest pits of toxic ignorance and stupidity (Avijnana) are exactly Me!"
            "Whatever is the absolute Supreme God (Brahman), I am That; and whatever is pathetic, rotting, decaying matter (Abrahman), I am literally That as well!"
            This verse violently rips out and incinerates the dualistic human programming of 'Good vs. Evil' from its very roots.
            Fools pathetically hallucinate that God only dispenses pleasure while a devil inflicts pain; this is the most colossal lie in existence.
            The Goddess is screaming that when you are crushed and sobbing, that exact horrific biological agony (Anananda) is a direct, literal manifestation of Her energy.
            When the matrix brutally deceives you (Ignorance), that deception is entirely Her flawless, lethal cosmic game.
            The authentic awake seeker explicitly perceives exactly the same Mother in both shattering ecstasy and paralyzing tragedy; he drinks poison as Her divine nectar.
            He who successfully digests this terrifying absolute reality, permanently obliterates all biological fear and instantly mutates into an invincible cosmic force.
        """.trimIndent()
    ),
    DeviShloka(
        id = 4,
        sanskrit = "अहं पञ्चभूतान्यपञ्चभूतानि । अहमखिलं जगत् ॥ ४॥",
        hindi = """
            (पंचभूत और संपूर्ण ब्रह्मांड): देवी अपने भौतिक (Physical) विस्तार की घोषणा करते हुए देवताओं के दिमाग के चिथड़े उड़ा देती है।
            "यह दुनिया जिन पाँच तत्वों (मिट्टी, पानी, आग, हवा और आसमान) से बनी है, वे 'पंचभूत' साक्षात मैं ही हूँ!"
            "और जो इन पाँच तत्वों से परे है, जो दिखाई नहीं देता (अपंचभूत / ऊर्जा, आत्मा, शून्य), वह भी साक्षात मैं ही हूँ।"
            "यह पूरा का पूरा दृश्यमान ब्रह्मांड, अनंत गैलेक्सी और असीम अंतरिक्ष (अखिलं जगत्) केवल और केवल 'मैं' ही हूँ!"
            तुम्हारे शरीर की हड्डियां (मिट्टी) और तुम्हारे शरीर का खून (पानी) कोई निर्जीव चीज़ें नहीं हैं; वह साक्षात देवी का देह (Body) है।
            तुम्हारे पेट में जलने वाली आग और तुम्हारे फेफड़ों में जाने वाली हवा उसी परम शक्ति का जीवित रूप है।
            विज्ञान जिसे 'Matter' और 'Anti-matter' कहता है, देवी कह रही है कि वह दोनों केवल मेरी ही सत्ता हैं।
            जब इंसान इस सच्चाई को जान लेता है, तो वह प्रकृति को एक निर्जीव वस्तु की तरह इस्तेमाल करना छोड़ देता है।
            वह इस दुनिया को कोई 'माया' या 'झूठ' कहकर ठुकराता नहीं है, बल्कि वह इस दुनिया को साक्षात अपनी माँ का पवित्र मंदिर मानकर चूम लेता है।
            मैं (देवी) ही सब कुछ हूँ—इस एक वाक्य में इंसानियत के सारे धर्म, सारी किताबें और सारा विज्ञान आकर शून्य हो जाता है।
        """.trimIndent(),
        english = """
            (The Five Elements and the Entire Cosmos): The Goddess violently declares the absolute extent of Her physical material expansion, shredding the intellect of the gods.
            "The foundational Five Elements (Earth, Water, Fire, Air, Space) from which this entire matrix is brutally forged, are explicitly and literally Me!"
            "And whatever transcends these physical elements, the invisible unmapped dimensions (Apanchabhuta / Dark matter, soul, void), is absolutely Me as well."
            "This entire colossal, observable universe, the infinite galaxies, and bottomless deep space (Akhilam Jagat) is strictly, exclusively 'ME'!"
            The dense biological bones (Earth) in your skeleton and the red blood (Water) racing in your veins are definitively not dead matter; they are the exact literal flesh of the Goddess.
            The roaring metabolic fire inside your stomach and the oxygen flooding your lungs are the violently alive manifestations of that Supreme Power.
            What modern pathetic science divides into 'Matter' and 'Anti-matter', the Goddess dictates are merely two microscopic fractions of Her infinite existence.
            When a human violently absorbs this reality, he permanently stops exploiting nature as a dead, mechanical resource.
            He absolutely refuses to curse this physical world as a pathetic 'illusion' (Maya); instead, he fiercely worships this exact physical matrix as the hyper-sacred body of his Mother.
            "I (The Goddess) am absolutely EVERYTHING"—in this single catastrophic sentence, all human religions, philosophies, and sciences collapse into dead zero.
        """.trimIndent()
    ),
    DeviShloka(
        id = 5,
        sanskrit = "वेदोऽहमवेदोऽहम् । विद्याहमविद्याहम् । अजाहमनजाहम् । अधश्चोर्ध्वं च तिर्यक्चाहम् ॥ ५॥",
        hindi = """
            (वेद, विद्या और हर दिशा में व्याप्त): देवी अब ज्ञान और जन्म-मृत्यु के हर रहस्य को अपने अस्तित्व में खींच लेती है।
            "जो साक्षात 'वेद' (ब्रह्मांड का परम सत्य और ज्ञान) हैं, वह मैं हूँ; और जो वेद नहीं हैं (अवेद / साधारण बातें), वह भी मैं ही हूँ!"
            "संसार की सारी चमत्कारी 'विद्या' (ज्ञान/Enlightenment) मैं हूँ; और जो दुनिया को भटकाने वाली 'अविद्या' (माया/Illusion) है, वह भी मैं ही हूँ।"
            "जिसका कभी जन्म नहीं होता, जो हमेशा से है (अजा/Unborn), वह परम सत्य मैं हूँ; और जो बार-बार जन्म लेती और मरती है (अनजा), वह नाशवान दुनिया भी मैं ही हूँ।"
            "मैं ही इस ब्रह्मांड के सबसे 'नीचे' (पाताल) हूँ, मैं ही सबसे 'ऊपर' (स्वर्ग) हूँ, और मैं ही आड़ी-तिरछी 'हर दिशा' (अंतरिक्ष) में फैली हुई हूँ।"
            यह अद्वैत वेदांत का सबसे बड़ा और खौफनाक धमाका है! कोई भी चीज़ उस देवी से बाहर नहीं है।
            अगर इंसान ज्ञान (विद्या) से भगवान को पाना चाहता है, तो वह देवी है; और अगर वह वासना (अविद्या) में फंसकर बर्बाद हो रहा है, तो वह जाल भी देवी ने ही फेंका है।
            अगर तुम पाताल में छुप जाओ, तो वहाँ भी देवी मौजूद है; और अगर तुम उड़कर ब्रह्मांड के पार चले जाओ, तो वहाँ भी केवल वही खड़ी मिलेगी।
            इस ज्ञान के बाद इंसान का भागना (Escape) हमेशा के लिए बंद हो जाता है; क्योंकि तुम भागकर जाओगे कहाँ? हर जगह तो केवल माँ ही है!
            यह श्लोक इंसान की बुद्धि को अपाहिज कर देता है और उसे पूर्ण समर्पण (Absolute Surrender) के लिए मजबूर कर देता है।
        """.trimIndent(),
        english = """
            (The Vedas, Knowledge, and the Omnipresent Directions): The Goddess now violently sucks all cosmic knowledge and the cycles of birth-death entirely into Her existence.
            "I am explicitly the literal 'Vedas' (The absolute supreme truth and cosmic code); and whatever contradicts the Vedas (Aveda / mundane garbage), is strictly Me as well!"
            "I am the catastrophic, liberating supreme Knowledge (Vidya / Enlightenment); and the toxic, blinding illusion that enslaves humanity (Avidya / Maya), is exactly Me too!"
            "I am the absolute 'Unborn' (Aja / Eternal), which existed before time itself; and I am also the dying, decaying, constantly rebirthing physical matrix (Anaja)!"
            "I am explicitly stationed in the absolute 'Bottom' (Hellish dimensions); I am at the absolute 'Top' (Heavens); and I violently expand across all sideways dimensions (Deep Space)."
            This is the most terrifying, atomic detonation of Non-Dual Vedanta! Absolutely nothing can physically or spiritually exist outside the Goddess.
            If a seeker desperately hunts for God through wisdom (Vidya), he hits the Goddess; if a fool is brutally destroyed by lust (Avidya), that trap was flawlessly designed and laid by Her.
            If you bury yourself in the deepest hell, She is already there; if you rocket beyond the edge of the observable universe, you will crash straight into Her.
            After this apocalyptic realization, the pathetic human instinct to 'escape' permanently terminates; because where exactly will you run? Everywhere is strictly the Mother!
            This verse ruthlessly paralyzes human logic, forcing the brain into a state of terrifying, absolute unconditional cosmic Surrender.
        """.trimIndent()
    ),
    DeviShloka(
        id = 6,
        sanskrit = "अहं रुद्रेभिर्वसुभिश्चरामि । अहमादित्यैरुत विश्वेदेवैः ।",
        hindi = """
            (देवताओं की संचालक शक्ति - भाग १): देवी अब यह सिद्ध कर रही है कि स्वर्ग के महान देवता अपनी ताक़त से नहीं, बल्कि उसी के इशारे पर नाचते हैं।
            "सृष्टि का विनाश करने वाले ग्यारह 'रुद्रों' के रूप में, मैं ही इस पूरे ब्रह्मांड में विचरण करती हूँ (चरामि)!"
            "सृष्टि को धारण करने वाले आठ 'वसुओं' (पृथ्वी, जल, अग्नि आदि) के भीतर बैठकर, मैं ही इस दुनिया को चलाती हूँ।"
            "बारह 'आदित्यों' (सूर्य देव के रूप) में जो प्रलयंकारी आग और चमक है, वह असल में मेरी ही ताक़त है।"
            "और सभी 'विश्वेदेवों' (समस्त देवताओं का समूह) के साथ मैं ही कदम से कदम मिलाकर पूरे अंतरिक्ष में घूम रही हूँ।"
            यह श्लोक इंसान के उस मूर्खतापूर्ण विश्वास को कुचल देता है कि सूर्य, अग्नि या शिव (रुद्र) खुद अपनी मर्जी से काम कर रहे हैं।
            यह सारे महान देवता तो केवल देवी के हाथ की कठपुतलियां हैं; असली शक्ति (Power) जो उन्हें ऊर्जा दे रही है, वह यह महादेवी है।
            अगर देवी अपनी 'विद्युत' (Energy) खींच ले, तो सूर्य अंधा हो जाएगा और रुद्रों के हाथ से विनाश के हथियार गिर पड़ेंगे।
            सच्चा साधक देवताओं के पीछे छिपी हुई इस असली 'बैटरी' (परम शक्ति) को पहचान लेता है।
            वह देवताओं से भीख नहीं माँगता, बल्कि वह सीधे उस महा-शक्ति की उपासना करता है जो सभी देवताओं को चला रही है।
            यह श्लोक साबित करता है कि शाक्त धर्म (Shaktism) किसी भी अन्य देवता की पूजा से अनंत गुना अधिक खौफनाक और शक्तिशाली है।
        """.trimIndent(),
        english = """
            (The Sovereign Operator of the Gods - Part 1): The Goddess now violently proves that the supreme gods of heaven do not possess independent power, but dance strictly to Her dictatorial commands.
            "As the eleven cataclysmic 'Rudras' (Gods of Destruction), it is exactly I who violently roams and annihilates throughout this cosmos (Charami)!"
            "Sitting deep within the eight 'Vasus' (The elemental gods sustaining reality like Earth, Fire, Water), it is strictly I who operates this physical matrix."
            "The blinding, apocalyptic fire and solar radiation blazing inside the twelve 'Adityas' (Sun Gods) is explicitly and exclusively My raw power."
            "And alongside the 'Vishvedevas' (The collective pantheon of all cosmic deities), it is I alone who marches relentlessly across deep space."
            This verse violently crushes the pathetic human hallucination that the Sun, Fire, or Shiva (Rudra) are acting on their own free will.
            These supreme cosmic deities are literally biological puppets on the Mother's strings; the absolute raw voltage (Power) fueling them is this Maha-Devi.
            If the Goddess ruthlessly unplugs Her 'Electricity', the Sun would instantly go blind, and the weapons of destruction would drop from the Rudras' paralyzed hands.
            The authentic awake seeker violently bypasses the gods and directly targets this exact 'Supreme Battery' powering the entire cosmic infrastructure.
            He absolutely refuses to pathetically beg lesser deities; he directly seizes the Supreme Power operating the heavens.
            This verse proves permanently that Shaktism is infinitely more terrifying, colossal, and lethal than the worship of any male cosmic deity.
        """.trimIndent()
    ),
    DeviShloka(
        id = 7,
        sanskrit = "अहं मित्रावरुणावुभौ बिभर्मि । अहमिन्द्राग्नी अहमश्विनावुभौ ॥ ७॥",
        hindi = """
            (देवताओं की संचालक शक्ति - भाग २): अपनी परम और निरंकुश सत्ता का ऐलान जारी रखते हुए देवी ब्रह्मांडीय शक्तियों का रहस्य खोलती है।
            "मित्र देव (दिन के देवता) और वरुण देव (रात और महासागरों के देवता)—इन दोनों खौफनाक शक्तियों को मैं ही अपने हाथों से धारण करती हूँ (बिभर्मि)!"
            "स्वर्ग के राजा 'इंद्र' (जो वज्र चलाते हैं) और 'अग्नि' (जो सब कुछ भस्म कर देते हैं)—इन दोनों देवताओं को भी मैं ही शक्ति देती हूँ।"
            "और स्वर्ग के महान वैद्य, दोनों 'अश्विनी कुमारों' (जो जीवन और आरोग्य देते हैं) को भी मैंने ही अपने भीतर संभाल रखा है।"
            जिन देवताओं के डर से पूरी दुनिया काँपती है, उन देवताओं को यह देवी एक छोटे से खिलौने की तरह अपने हाथ में पकड़े हुए है (बिभर्मि/Support)।
            यह उपनिषद ऋग्वेद के देवी सूक्त (Devi Sukta) की साक्षात गर्जना है; जहाँ देवी चीख कर कह रही है कि सत्ता केवल मेरी है।
            जब इंसान यह पढ़ता है, तो उसका सारा धार्मिक पाखंड और छोटी सोच (कि यह भगवान बड़ा है या वो) जलकर राख हो जाती है।
            ब्रह्मांड का हर सिस्टम—चाहे वह दिन-रात (मित्र-वरुण) हो, या विनाश-सृजन (अग्नि-अश्विन)—केवल एक ही मदरबोर्ड (Motherboard) से जुड़ा है, और वह है देवी।
            जिस इंसान ने इस महादेवी को जान लिया, उसे फिर किसी भी ग्रह, किसी भी देवता या किसी भी ज्योतिष से डरने की ज़रूरत नहीं रहती।
            क्योंकि जो पूरे ब्रह्मांड के देवताओं की 'माँ' और 'मालिक' है, वह उसी योगी के भीतर अपनी पूरी ताक़त के साथ जाग चुकी है।
        """.trimIndent(),
        english = """
            (The Sovereign Operator of the Gods - Part 2): Continuing Her absolute, dictatorial cosmic proclamation, the Goddess violently rips open the architecture of celestial powers.
            "Mitra (The God of the Day) and Varuna (The terrifying God of the Night and cosmic Oceans)—I hold both of these colossal forces directly in My own bare hands! (Bibharmi)."
            "Indra, the King of Heaven (wielding the thunderbolt), and Agni (the raging Fire that incinerates everything)—I explicitly pump raw power into both of them."
            "And both the 'Ashvins', the supreme celestial physicians (who dispense biological life and health), are firmly supported and suspended strictly within Me."
            The exact terrifying deities whose wrath makes the entire planet tremble, are casually held by this Goddess like microscopic, pathetic plastic toys (Bibharmi/Support).
            This Upanishad is the literal, deafening roar of the Rigvedic 'Devi Sukta'; where the Mother screams that absolute cosmic Authority belongs exclusively to Her.
            When a human digests this, his entire pathetic religious hypocrisy and toxic debates (about which god is superior) are permanently incinerated to ash.
            Every single operating system in the cosmos—whether Day-Night (Mitra-Varuna) or Destruction-Creation (Agni-Ashvins)—is plugged directly into ONE absolute Motherboard, the Goddess.
            The human who has violently realized this Maha-Devi, never again needs to fear any planetary alignment, any angry deity, or any pathetic astrological prediction.
            Because the absolute 'Mother' and 'Dictator' of the entire cosmic pantheon has violently awakened with full nuclear force inside that exact Yogi's biology.
        """.trimIndent()
    ),
    DeviShloka(
        id = 8,
        sanskrit = "अहं सोमं त्वष्टारं पूषणं भगं दधामि । अहं विष्णुमुरुक्रमं ब्रह्माणमुत प्रजापतिं दधामि ॥ ८॥",
        hindi = """
            (ब्रह्मा, विष्णु और प्रजापति का आधार): देवी अब उस चरम सीमा पर पहुँचती है जहाँ बड़े से बड़े देवताओं का वजूद भी उसके सामने शून्य हो जाता है।
            "सोम देव (चंद्रमा/वनस्पति), त्वष्टा (सृष्टि के शिल्पकार), पूषा (पालन करने वाले) और भग (सौभाग्य के देवता)—इन सबको मैं ही धारण (दधामि) करती हूँ!"
            "और सुनो! जो तीन पगों में ब्रह्मांड नापने वाले असीम 'विष्णु' (उरुक्रम) हैं, उन्हें भी मैं ही अपने भीतर धारण करती हूँ!"
            "जो चार मुख वाले 'ब्रह्मा' हैं, और जो सृष्टि रचने वाले 'प्रजापति' हैं, उन सबको मैं ही अपने गर्भ में संभाल कर रखती हूँ (दधामि)!"
            यह सनातन धर्म का सबसे बड़ा और सबसे खौफनाक रहस्य है—ब्रह्मा और विष्णु भी आज़ाद नहीं हैं, वे देवी के बिना एक सेकंड भी टिक नहीं सकते।
            'दधामि' का अर्थ है— 'मैं उन्हें आधार देती हूँ'। जिस तरह एक माँ अपने बच्चे को कोख में रखती है, वैसे ही देवी ने इन त्रिदेवों को रखा हुआ है।
            अगर यह माँ (Foundation) अपना हाथ हटा ले, तो ब्रह्मा, विष्णु और प्रजापति उसी पल ब्रह्मांड के ब्लैक होल में गिरकर नष्ट हो जाएंगे।
            जब इंसान इस सच्चाई को सुनता है, तो उसके भीतर का वह अहंकार हमेशा के लिए टूट जाता है कि पुरुष सत्ता ही सबसे बड़ी है।
            असली और अंतिम भगवान (Ultimate Reality) एक मातृ-चेतना (Mother-Consciousness) है, जो इतनी विशाल है कि पूरा ब्रह्मांड उसकी एक सेल (Cell) के बराबर है।
            सच्चा योगी सीधे इस रूट-सोर्स (Root Source) से जुड़ता है, और ब्रह्मांड का सबसे शक्तिशाली जीव बन जाता है।
        """.trimIndent(),
        english = """
            (The Absolute Foundation of Brahma, Vishnu, and Prajapati): The Goddess now escalates to the terrifying cosmic extreme where the existence of even the supreme trinity is reduced to zero before Her.
            "Soma (The Moon/Nectar), Tvashtar (The cosmic architect), Pushan (The nourisher), and Bhaga (God of supreme fortune)—I explicitly hold and sustain all of them! (Dadhami)."
            "And listen closely! The infinite 'Vishnu' (Urukrama) who spans the universe in three colossal strides, I physically hold Him securely within My own biology!"
            "The four-faced 'Brahma', and the grand creators 'Prajapatis', I hold every single one of them securely in My cosmic womb! (Dadhami)."
            This is the most massive, horrific classified secret of Sanatana Dharma—Brahma and Vishnu are definitely not independent; they cannot survive a microsecond without the Goddess.
            'Dadhami' literally translates to 'I provide the absolute foundation'. Exactly as a mother carries a fetus, the Goddess actively suspends this supreme Trinity.
            If this Mother (Foundation) ruthlessly withdraws Her hand, Brahma, Vishnu, and Prajapati would instantaneously collapse into a cosmic black hole and be annihilated.
            When a human hears this absolute truth, his toxic biological arrogance that 'male authority is supreme' is violently, permanently shattered.
            The authentic, Ultimate Reality (God) is a supreme Mother-Consciousness, so terrifyingly colossal that the entire observable universe equals merely a microscopic cell within Her.
            The true awake Yogi plugs directly into this exact Root-Source, instantaneously mutating into the most lethal, powerful entity in existence.
        """.trimIndent()
    ),
    DeviShloka(
        id = 9,
        sanskrit = "अहं दधामि द्रविणं हविष्मते सुप्राव्या यजमानाय सुन्वते । अहं राष्ट्री सङ्गमनी वसूनां चिकितुषी प्रथमा यज्ञियानाम् ॥ ९॥",
        hindi = """
            (ब्रह्मांड की महारानी और ऐश्वर्य देने वाली): देवी अब दुनिया को यह बताती है कि सारे कर्मकांडों और तपस्या का फल (Result) असल में कौन देता है।
            "जो भी इंसान पूरी श्रद्धा से देवताओं के लिए सोमरस निकालता है और यज्ञ में घी (हवि) डालता है, उस यजमान को सारा धन, दौलत और ऐश्वर्य (द्रविणं) केवल मैं ही देती हूँ!"
            देवता तुम्हें कुछ नहीं दे सकते; देवता केवल बिचौलिए (Brokers) हैं। यज्ञ की आग से जो असल ताक़त खुश होकर फल देती है, वह यह महादेवी है।
            "मैं ही इस पूरे ब्रह्मांड की 'राष्ट्री' (Supreme Sovereign Empress) हूँ! मैं ही सारे धनों और शक्तियों (वसूनां) को एक जगह इकट्ठा करने वाली (सङ्गमनी) हूँ।"
            "मैं परम ज्ञान को जानने वाली (चिकितुषी) हूँ, और इस ब्रह्मांड में जितने भी देवता पूजे जाते हैं, उन सबमें 'सबसे पहली' (प्रथमा) पूजा की हक़दार केवल मैं हूँ!"
            देवी ने यहाँ साफ़ कर दिया कि सत्ता (Authority) और खज़ाना (Wealth) दोनों की चाबी केवल उसी के हाथ में है।
            इंसान पैसों और ताक़त के लिए दुनिया के सामने गिड़गिड़ाता है, लेकिन उसे पता ही नहीं कि असली खज़ाने की महारानी (राष्ट्री) उसकी अपनी ही आत्मा के भीतर बैठी है।
            यह श्लोक उन लोगों पर सीधा प्रहार है जो देवी को केवल एक स्थानीय मूर्ति मानते हैं; वह पूरे 'मल्टीवर्स' की तानाशाह महारानी है।
            जब योगी इस 'राष्ट्री' को अपने भीतर जगा लेता है, तो वह किसी राजा के आगे सिर नहीं झुकाता, क्योंकि वह खुद ब्रह्मांड का असली वारिस बन चुका होता है।
            यही शक्तिपात (Shaktipat) का रहस्य है—माँ से जुड़ते ही इंसान की गरीबी, डर और दरिद्रता एक सेकंड में भस्म हो जाती है।
        """.trimIndent(),
        english = """
            (The Sovereign Empress of the Cosmos and Dispenser of Wealth): The Goddess now aggressively dictates exactly who dispenses the ultimate results of all human sacrifices and penances.
            "Whichever human intensely extracts Soma and pours clarified butter (Havi) into the sacrificial fire, I, and strictly I alone, violently dispense all absolute wealth, treasure, and power (Dravinam) to that sacrificer!"
            Male deities can grant you absolutely nothing; they are merely cosmic brokers. The true, terrifying Force inside the sacrificial fire that actually releases the reward is this Maha-Devi.
            "I explicitly am the 'Rashtri' (The Supreme Dictatorial Empress) of this entire multiverse! I am the ultimate magnetic force (Sangamani) that hoards and commands all cosmic wealth and elements (Vasunam)."
            "I am the absolute Knower of Supreme Reality (Chikitushi), and among absolutely all entities worshipped in the cosmos, I am explicitly the 'First and Foremost' (Prathama) who demands worship!"
            The Goddess unequivocally clarifies that the keys to both absolute Authority and infinite Wealth are gripped strictly in Her bare hands.
            Humans pathetically beg the matrix for money and power, entirely ignorant that the actual Empress (Rashtri) of all cosmic vaults is sitting right inside their own Soul.
            This verse is a lethal strike against fools who hallucinate the Goddess as a local stone idol; She is the absolute tyrannical Empress of the multiverse.
            When a Yogi violently awakens this 'Rashtri' inside his biology, he never bows to earthly kings, because he instantaneously mutates into the absolute heir of the universe.
            This is the terrifying secret of 'Shaktipat'—the microsecond you plug into the Mother, biological poverty, fear, and pathetic weakness are permanently incinerated to dust.
        """.trimIndent()
    ),
    DeviShloka(
        id = 10,
        sanskrit = "मया सो अन्नमत्ति यो विपश्यति यः प्राणिति य ईं शृणोत्युक्तम् । अमन्तवो मां त उप क्षियन्ति श्रुधि श्रुत श्रद्धिवं ते वदामि ॥ १०॥",
        hindi = """
            (जीवन का हर कृत्य मेरी शक्ति से है): अब उपनिषद इंसान के रोज़मर्रा के जीवन में देवी की खौफनाक और सीधी दखलंदाज़ी (Interference) का सच खोलता है।
            "इस दुनिया में जो भी इंसान खाना खाता है (अन्नमत्ति), जो आँखों से देखता है (विपश्यति), जो साँस लेता है (प्राणिति), और जो कानों से सुनता है..."
            "वह यह सब खुद नहीं कर रहा है; वह केवल और केवल 'मेरी शक्ति' (मया) के द्वारा ही ऐसा कर पा रहा है!"
            इंसान सोचता है कि "मैं खा रहा हूँ, मैं देख रहा हूँ", यह उसका सबसे बड़ा और बेवकूफी भरा अहंकार है।
            "जो मूर्ख लोग मेरी इस परम सत्ता को नहीं जानते (अमन्तवो), वे धीरे-धीरे नष्ट हो जाते हैं (क्षियन्ति) और पतन की ओर गिर जाते हैं।"
            "हे सुनने वाले (श्रुत)! ध्यान से सुन, मैं तुझे यह परम सत्य (श्रद्धिवं) बता रही हूँ, जिस पर तुझे बिना शर्त विश्वास करना ही होगा!"
            तुम्हारे शरीर की मशीन को चलाने वाली बिजली (Electricity) केवल वह देवी है। अगर वह अपनी ऊर्जा एक पल के लिए खींच ले, तो इंसान का दिल धड़कना बंद कर देगा।
            जब इंसान यह जान लेता है कि उसकी आँखों में देखने वाली ज्योति और कानों में सुनने वाली आवाज़ साक्षात माँ की है, तो उसका पूरा जीवन ही एक 'समाधि' बन जाता है।
            वह कभी कुछ बुरा देख या सुन नहीं सकता, क्योंकि वह जानता है कि उसकी इंद्रियां (Senses) देवी का मंदिर हैं।
            यह श्लोक इंसान की आज़ादी (Free Will) के भ्रम को बेरहमी से कुचल कर रख देता है—तुम कुछ नहीं कर रहे, सब कुछ केवल माँ कर रही है!
        """.trimIndent(),
        english = """
            (Every Biological Act is strictly By My Power): Now, the Upanishad unveils the terrifying, direct, and absolute interference of the Goddess in every microsecond of human biological existence.
            "In this matrix, whichever human consumes food (Annamatti), whoever sees with their eyes (Vipashyati), whoever breathes oxygen (Praniti), and whoever hears words spoken..."
            "He is definitely NOT executing these acts himself; he is functioning strictly and exclusively through 'My sheer Power' (Maya)!"
            The human pathetically hallucinates, "I am eating, I am looking"; this is his most catastrophically stupid biological ego.
            "Those ignorant fools who fail to violently recognize My absolute supreme authority (Amantavo), inevitably decay, disintegrate, and plunge into catastrophic ruin (Kshiyanti)."
            "O Listener (Shruta)! Listen to Me with absolute terror and focus, I am dictating to you the ultimate truth (Shraddhivam), which you MUST believe unconditionally!"
            The raw Electricity operating your biological machine is exclusively that Goddess. If She retracts Her energy for a microsecond, the human heart will violently stop beating.
            When a human realizes that the light perceiving through his eyes and the consciousness hearing in his ears is explicitly the Mother, his entire biological existence mutates into a constant 'Samadhi'.
            He can absolutely never consume or observe toxic filth again, because he realizes his physical senses (Indriyas) are the literal sacred temple of the Goddess.
            This verse mercilessly and violently slaughters the pathetic human illusion of 'Free Will'—you are doing absolutely nothing, the Mother alone is flawlessly executing everything!
        """.trimIndent()
    ),
    DeviShloka(
        id = 11,
        sanskrit = "अहमेव स्वयमिदं वदामि जुष्टं देवेभिरुत मानुषेभिः । यं कामये तंतमुग्रं कृणोमि तं ब्रह्माणं तं ऋषिं तं सुमेधाम् ॥ ११॥",
        hindi = """
            (मैं जिसे चाहूँ उसे ब्रह्मा या शिव बना दूँ): देवी अब अपने परम और निरंकुश अधिकार (Absolute Dictatorship) का सबसे खौफनाक ऐलान करती है।
            "यह जो मैं कह रही हूँ (अहमेव स्वयमिदं वदामि), यह कोई साधारण बात नहीं है; देवता और इंसान दोनों इसी सत्य की पूजा करते हैं।"
            "मैं इस ब्रह्मांड में जिस पर भी खुश हो जाऊँ, जिसे भी मैं चाह लूँ (यं कामये)... मैं उसे एक सेकंड में परम भयंकर और शक्तिशाली (उग्रं / शिव) बना देती हूँ!"
            "मैं चाहूँ तो उसे साक्षात 'ब्रह्मा' (सृष्टिकर्ता) बना दूँ! मैं चाहूँ तो उसे सबसे बड़ा 'ऋषि' बना दूँ, या परम ज्ञानी (सुमेधाम्) बना दूँ!"
            यह श्लोक साबित करता है कि कोई भी अपनी मेहनत, तपस्या या योग से भगवान नहीं बनता; सब कुछ केवल देवी की इच्छा (Grace) पर निर्भर है।
            ब्रह्मा, शिव या महान ऋषि कोई अलग प्रजाति नहीं हैं; वे वही साधारण जीव हैं जिन्हें देवी ने अपनी सत्ता सौंपकर बड़ा बना दिया।
            अगर वह माँ एक साधारण इंसान या कीड़े पर भी खुश हो जाए, तो वह उसे उठाकर सीधे ब्रह्मांड के सिंहासन (ब्रह्मा के पद) पर बिठा सकती है।
            और अगर वह नाराज़ हो जाए, तो बड़े से बड़े देवता को धूल में मिला सकती है।
            सच्चा योगी यह जानकर दुनिया के सारे कर्मकांड छोड़ देता है और केवल उस माँ के सामने एक रोते हुए बच्चे की तरह पूरी तरह से सरेंडर (Surrender) कर देता है।
            उसे पता है कि मोक्ष (Liberation) कोई ऐसी चीज़ नहीं जिसे बल से छीना जाए; यह माँ की वो भीख (कृपा) है जो वह अपने सबसे प्यारे बच्चे को देती है।
        """.trimIndent(),
        english = """
            (I Can Mutate Anyone into Brahma or Shiva at Will): The Goddess now unleashes the most terrifying, apocalyptic declaration of Her Absolute Cosmic Dictatorship.
            "What I Myself am aggressively speaking right now (Ahameva svayamidam vadami), is definitely no ordinary statement; both supreme gods and mortal humans actively worship this exact truth."
            "Whomever I desire in this cosmos, whomever I am pleased with (Yam kamaye)... I violently and instantaneously mutate him into the most terrifying, invincible power (Ugram / Shiva)!"
            "If I desire, I can forcefully mutate him into literal 'Brahma' (The Creator)! If I wish, I can instantly forge him into the greatest 'Sage' (Rishi) or a being of Supreme Cosmic Intellect (Sumedham)!"
            This verse permanently proves that absolutely no entity becomes God through pathetic physical penance, yoga, or hard work; absolutely everything is strictly determined by the Goddess's sheer Grace.
            Brahma, Shiva, or supreme sages are not a separate alien species; they are merely ordinary biological entities whom the Goddess arbitrarily chose to elevate to absolute cosmic authority.
            If that Mother is pleased with a mundane human or even an insect, She can forcefully hurl him straight onto the absolute throne of the universe (the seat of Brahma).
            And if She is enraged, She can brutally disintegrate the highest cosmic god into radioactive dust.
            The authentic awake Yogi, realizing this terrifying truth, violently abandons all pathetic mechanical rituals and unconditionally surrenders like a sobbing infant entirely at the Mother's feet.
            He perfectly knows that Moksha (Absolute Liberation) is definitely not a prize to be violently seized by force; it is the absolute cosmic grace that the Mother grants exclusively to Her most beloved child.
        """.trimIndent()
    ),
    DeviShloka(
        id = 12,
        sanskrit = "अहं रुद्राय धनुरातनोमि ब्रह्मद्विषे शरवे हन्तवा उ । अहं जनाय समदं कृणोम्यहं द्यावापृथिवी आ विवेश ॥ १२॥",
        hindi = """
            (रुद्र को हथियार मैं देती हूँ): देवी अब शिव (रुद्र) के विनाशकारी स्वरूप के पीछे की असली ताक़त का रहस्य खोलती है।
            "जो अज्ञानी और घमंडी लोग परब्रह्म से नफरत करते हैं (ब्रह्मद्विषे), ऐसे राक्षसों को मारने के लिए साक्षात 'रुद्र' (शिव) के धनुष की डोरी मैं ही खींचती हूँ (धनुरातनोमि)!"
            रुद्र के पास अपना कोई बाण या ताक़त नहीं है; जब देवी उनके धनुष में अपनी ऊर्जा (शक्ति) भरती है, तभी शिव का बाण (शरवे) दुश्मन का संहार कर पाता है।
            "मैं अपने भक्तों और इस संसार (जनाय) की रक्षा के लिए युद्ध के मैदान में भयंकर संग्राम (समदं) करती हूँ!"
            "मैं इस धरती से लेकर सबसे ऊंचे आसमान तक (द्यावापृथिवी), पूरे ब्रह्मांड के भीतर और बाहर पूरी तरह से घुसकर समाई हुई हूँ (आ विवेश)।"
            यह श्लोक चीख कर कह रहा है कि शिव बिना शक्ति के केवल एक 'शव' (लाश) हैं; विनाश की असल ट्रिगर (Trigger) देवी के हाथ में है।
            जो लोग समझते हैं कि भगवान दूर बैठकर केवल तमाशा देख रहा है, उन्हें देवी बता रही है कि वह युद्ध के मैदान में खून-खराबे और संग्राम के बीच साक्षात मौजूद है।
            वह शांति की देवी भी है और युद्ध की सबसे खौफनाक और मारक शक्ति भी है।
            जब इंसान के जीवन में धर्म और अधर्म का युद्ध (Depression/Struggle) चलता है, तो उसके भीतर संघर्ष करने वाली वह ताक़त उसकी अपनी नहीं, साक्षात माँ की होती है।
            जो योगी इस सच को जान लेता है, वह कभी हार नहीं मानता; क्योंकि वह जानता है कि उसके भीतर लड़ने वाली योद्धा साक्षात ब्रह्मांड की महारानी है।
        """.trimIndent(),
        english = """
            (I Weaponize Rudra Himself): The Goddess now violently rips open the terrifying secret behind the apocalyptic destructive power of Shiva (Rudra).
            "To ruthlessly assassinate the arrogant, toxic demons who harbor hatred against the Supreme Brahman (Brahmadvishe), it is exactly I Myself who forcefully bends and strings the bow of 'Rudra' (Dhanuratanomi)!"
            Rudra possesses absolutely zero independent arrows or kinetic power; only when the Goddess violently pumps Her raw cosmic energy (Shakti) into His bow, can Shiva's arrow (Sharave) annihilate the enemy.
            "To fiercely protect My devoted humans and this matrix (Janaya), I personally trigger and execute catastrophic, apocalyptic warfare (Samadam) on the cosmic battlefield!"
            "I have violently penetrated and flawlessly permeated (A Vivesha) absolutely everything, from this dense earth straight to the absolute highest zenith of heaven (Dyavaprithivi)."
            This verse screams that Shiva without Shakti is literally just a paralyzed, dead 'Corpse' (Shava); the absolute trigger of cosmic annihilation is gripped firmly in the Goddess's hands.
            Fools who hallucinate that God merely sits on a distant cloud watching a drama are warned: the Goddess is physically, violently present right in the bloodiest center of the catastrophic battlefield.
            She is the supreme Goddess of Peace, and simultaneously the most horrific, lethal, blood-curdling weapon of War.
            When a human is fighting a brutal psychological or physical war (Depression/Struggle), the raw resilience fighting inside him is definitely not his own; it is the literal Mother fighting through his biology.
            The Yogi who realizes this terrifying truth absolutely never accepts defeat; because he knows the warrior fighting from inside his shell is the supreme Empress of the Multiverse.
        """.trimIndent()
    ),
    DeviShloka(
        id = 13,
        sanskrit = "अहं सुवे पितरमस्य मूर्धन् मम योनिरप्स्वन्तः समुद्रे ।",
        hindi = """
            (ब्रह्मांडीय पिता और असीम सागर की उत्पत्ति): देवी अब सृष्टि की शुरुआत की सबसे रहस्यमयी और प्रलयंकारी घटना का वर्णन कर रही है।
            "इस ब्रह्मांड के सबसे ऊंचे शिखर पर (मूर्धन्), जिस परम 'पिता' (आकाश / शिव / ईश्वर) को दुनिया जानती है, उसे मैंने ही जन्म दिया है (अहं सुवे पितरमस्य)!"
            इंसान भगवान को 'पिता' (Father) कहकर पुकारता है, लेकिन देवी बता रही है कि उस पिता (भगवान) की भी एक 'माँ' है, और वह माँ साक्षात देवी है।
            "और मेरा उद्गम (Origin / योनि) कहाँ है? मेरी उत्पत्ति उस असीम, खौफनाक और अनंत ब्रह्मांडीय जल (समुद्रे) के भीतर है (मम योनिरप्स्वन्तः समुद्रे)।"
            यहाँ 'समुद्र' का मतलब धरती का पानी नहीं है; यह वह 'कारण-जल' (Causal Cosmic Ocean) है जो सृष्टि से पहले मौजूद था (ब्रह्म-चैतन्य)।
            देवी कह रही है कि वह किसी इंसान या देवता से पैदा नहीं हुई, वह सीधे उस परम शून्य और चेतना के असीम सागर से प्रकट हुई है।
            यह श्लोक दुनिया के सारे पितृसत्तात्मक (Patriarchal) धर्मों की नींव हिला देता है; भगवान एक पुरुष (पिता) नहीं है, भगवान एक परम चेतना (माँ) है।
            जब योगी ध्यान (Meditation) में गहरे उतरता है, तो वह इसी 'अंतरिक्ष के समुद्र' में डूब जाता है, जहाँ केवल और केवल माँ की शून्यता धड़क रही होती है।
            उसे समझ आ जाता है कि उसका अपना जन्म भी किसी बायोलॉजिकल पिता से नहीं, बल्कि उसी परम चेतना के सागर (देवी) से हुआ है।
            यही अद्वैत दर्शन का वह चरम बिंदु है, जहाँ इंसान अपने असली 'सोर्स' (Origin) को पहचान कर हमेशा के लिए मुक्त हो जाता है।
        """.trimIndent(),
        english = """
            (The Genesis of the Cosmic Father and the Infinite Ocean): The Goddess now violently narrates the most highly classified, apocalyptic event of the absolute dawn of creation.
            "At the absolute highest zenith and terrifying summit of this cosmos (Murdhan), the supreme 'Father' (The Sky/Shiva/God) whom the world worships—I Myself violently birthed Him from My womb (Aham suve pitaramasya)!"
            Humanity pathetically begs to God calling Him 'Father', but the Goddess detonates the truth: even that Father (God) has a 'Mother', and that absolute Mother is explicitly the Devi.
            "And where exactly is My origin (Yoni / Source)? My absolute genesis is located deep within the terrifying, infinite, bottomless Causal Cosmic Ocean (Mama yonirapsvantah samudre)."
            Here, 'Ocean' absolutely does not mean earthly saltwater; it is the catastrophic 'Causal Water' (Brahma-Chaitanya) that existed as pure potential before the big bang.
            The Goddess is dictating that She was not spawned by any human or lesser god; She violently erupted directly from that infinite ocean of pure, terrifying cosmic void and consciousness.
            This verse ruthlessly shatters the foundation of all patriarchal earthly religions; the Absolute God is definitely not a male (Father), the Absolute God is the Supreme Consciousness (Mother).
            When a master Yogi crashes deep into lethal Meditation, he completely drowns in this exact 'Cosmic Ocean', where strictly only the deafening silence and void of the Mother is throbbing.
            He brutally realizes that his own existence was not spawned by a pathetic biological father, but violently erupted from that exact same infinite ocean of the Goddess.
            This is the absolute zenith of Non-Dual philosophy, where the human forcefully recognizes his true 'Origin' (Source) and violently shatters the matrix of physical existence.
        """.trimIndent()
    ),
    DeviShloka(
        id = 14,
        sanskrit = "ततो वि तिष्ठे भुवनानु विश्वोतामूं द्यां वर्ष्मणोप स्पृशामि ॥ १४॥",
        hindi = """
            (विराट स्वरूप और आसमान को छूना): अपने असीम और प्रलयंकारी स्वरूप का विस्तार बताते हुए देवी इंसान के मन को पूरी तरह सुन्न (Paralyze) कर देती है।
            "उस अनंत ब्रह्मांडीय सागर (कारण-जल) से उत्पन्न होने के बाद, मैं इस पूरे के पूरे ब्रह्मांड (विश्व) और सभी लोकों (भुवनानु) में पूरी तरह से फैलकर (वि तिष्ठे) स्थित हूँ।"
            ब्रह्मांड का कोई भी ऐसा कोना, ब्लैक होल या खाली जगह नहीं है, जहाँ देवी का वजूद अपनी पूरी ताक़त से मौजूद न हो।
            "और अपनी विशालता (वर्ष्मणा) से, मैं नीचे पाताल से लेकर ऊपर उस असीम आसमान (द्यां) और स्वर्ग को भी अपने शरीर से छू रही हूँ (उप स्पृशामि)!"
            यह देवी का 'विराट स्वरूप' (The Colossal Cosmic Form) है। वह इतनी विशाल है कि हमारी पूरी आकाशगंगा (Galaxy) उसके शरीर का एक छोटा सा रोम (Hair) है।
            लोग देवी को मंदिरों में छोटी सी मूर्ति मानकर पूजते हैं, लेकिन उपनिषद कह रहा है कि वह इतनी विशाल है कि उसने पूरे ब्रह्मांड को एक चादर की तरह ओढ़ा हुआ है।
            जब एक साधक इस असीम और खौफनाक विशालता (Magnitude) का ध्यान करता है, तो उसका 'छोटा मैं' (Ego) डर से काँप कर हमेशा के लिए मर जाता है।
            वह समझ जाता है कि जिस दुनिया को वह सच मानकर लड़ रहा है, वह साक्षात उस परम माँ के शरीर के भीतर चल रहा एक छोटा सा सपना है।
            इस ज्ञान के बाद इंसान की सारी चिंताएं, डिप्रेशन और सांसारिक डर ऐसे गायब हो जाते हैं जैसे सूरज के निकलते ही रात का अंधेरा।
            योगी खुद को एक छोटा इंसान नहीं, बल्कि उस विराट शरीर (देवी) का ही एक असीम हिस्सा महसूस करने लगता है।
        """.trimIndent(),
        english = """
            (The Colossal Matrix Form and Touching the Zenith): Describing the catastrophic, apocalyptic expansion of Her infinite form, the Goddess entirely paralyzes the human mind.
            "After violently erupting from that infinite cosmic ocean, I have aggressively expanded and flawlessly permeated (Vi tishthe) across this entire universe (Vishva) and absolutely all dimensions of reality (Bhuvananu)."
            There is definitely not a single microscopic corner, black hole, or empty void in the cosmos where the absolute raw existence of the Goddess is not violently present.
            "And with My terrifying, apocalyptic magnitude (Varshmana), I literally stretch from the deepest abyss and physically touch (Upa sprishami) the absolute highest zenith of the sky and heavens (Dyam) with My own cosmic body!"
            This is the Goddess's 'Virat Svarupa' (The Absolute Colossal Cosmic Form). She is so terrifyingly massive that our entire observable galaxy is merely a microscopic hair on Her flesh.
            Fools pathetically worship the Goddess as a tiny stone idol in temples, but the Upanishad screams that She is so incredibly massive that She wears the entire universe like a piece of clothing.
            When a seeker forces his brain to meditate on this horrifying, infinite Magnitude, his pathetic 'tiny ego' violently trembles in terror and starves to death permanently.
            He realizes that the physical matrix he fights for, is literally just a microscopic dream playing out inside the biological flesh of that Supreme Mother.
            After this atomic realization, all biological anxiety, clinical depression, and earthly fears are instantaneously annihilated, exactly as darkness is slaughtered by the rising sun.
            The Yogi abruptly stops hallucinating himself as a pathetic human, and violently realizes he is an infinite, throbbing part of that exact Colossal Cosmic Body.
        """.trimIndent()
    ),
    DeviShloka(
        id = 15,
        sanskrit = "अहमेव वात इव प्रवाम्यारभमाणा भुवनानि विश्वा । परो दिवा पर एना पृथिव्यैतावती महिना सं बभूव ॥ १५॥",
        hindi = """
            (तूफान की तरह रचना और असीम महिमा): देवी के इस महा-भाषण (Devi Sukta) का यह आखिरी और सबसे भयानक धमाका है।
            "इस पूरे असीम ब्रह्मांड (विश्वा) और सभी लोकों (भुवनानि) की रचना (आरभमाणा) करते समय, मैं किसी की मदद नहीं लेती!"
            "मैं साक्षात एक भयंकर 'तूफान' (वात इव) की तरह बेपरवाह और प्रचंड वेग से बहती हूँ (प्रवामि), और मेरी इच्छा मात्र से यह ब्रह्मांड पैदा हो जाता है।"
            भगवान को दुनिया बनाने के लिए किसी औज़ार या मशीन की ज़रूरत नहीं है; देवी की एक साँस (तूफान) ही करोड़ों ब्रह्मांड रचने और मिटाने के लिए काफी है।
            "मेरी सत्ता इस दृश्यमान आसमान (दिवा) से भी बहुत आगे (परो) है, और इस भौतिक पृथ्वी (पृथिव्या) से भी बहुत परे है।"
            "मेरी महिमा (महिना) और मेरा वजूद इतना असीम और खौफनाक (एतावती सं बभूव) है कि इसे मापा नहीं जा सकता!"
            यहाँ देवी साफ़ कर देती है कि वह प्रकृति या ब्रह्मांड तक सीमित नहीं है; वह ब्रह्मांड से भी बड़ी है। यह संसार तो केवल उसका एक छोटा सा हिस्सा है।
            विज्ञान आज जहाँ हार मान लेता है (Multiverse/Beyond Space-time), शाक्त दर्शन हज़ारों साल पहले उस पार खड़ी इस 'महा-शक्ति' का ऐलान कर चुका है।
            जब एक इंसान इस श्लोक को समझता है, तो उसका दिमाग सुन्न पड़ जाता है; क्योंकि इंसान की बुद्धि (Intellect) में इतनी ताक़त ही नहीं कि वह इस असीम विशालता को सोच सके।
            सच्चा योगी यहाँ अपने सारे तर्क (Logic) और किताबें फेंक देता है, और उस असीम, तूफानी, और परम शक्तिमान माँ के अस्तित्व में हमेशा के लिए छलांग (Surrender) लगा देता है।
        """.trimIndent(),
        english = """
            (The Apocalyptic Storm of Creation and Boundless Glory): This is the final, most terrifying atomic detonation of the Goddess's absolute cosmic monologue (Devi Sukta).
            "While violently initiating and synthesizing (Arabhamana) this entire infinite cosmos and all multiple dimensions of reality (Vishva Bhuvanani), I absolutely require zero assistance!"
            "I ruthlessly blow and expand (Pravami) with the terrifying, unstoppable velocity of an apocalyptic 'Hurricane' (Vata iva), and by My sheer will alone, the matrix is violently spawned."
            God definitely does not need pathetic tools or physics to construct the universe; a single breath (storm) of the Goddess is lethal enough to synthesize and incinerate billions of galaxies instantly.
            "My absolute sovereign existence is infinitely beyond (Paro) this observable visible sky/heaven (Diva), and drastically transcends this dense physical Earth (Prithivya)."
            "My catastrophic Glory (Mahina) and My sheer cosmic magnitude (Etavati sam babhuva) are so horrifyingly boundless that they absolutely cannot be mapped or measured!"
            The Goddess completely clarifies here that She is definitively not restricted to Nature or the universe; She is infinitely larger than the cosmos. This physical matrix is merely a microscopic fraction of Her.
            Where pathetic modern science hits a dead end (Multiverse/Beyond Space-time), Shakta philosophy explicitly declared this 'Maha-Shakti' standing permanently beyond the edge, thousands of years ago.
            When a human brain attempts to process this verse, it is instantly paralyzed; because human biology fundamentally lacks the processing power to comprehend this horrifying infinity.
            The true awake Yogi violently throws away all his pathetic human logic, science, and books exactly here, and executes a permanent, unconditional leap (Surrender) directly into the existence of that Infinite, Storm-like Supreme Mother.
        """.trimIndent()
    ),
    DeviShloka(
        id = 16,
        sanskrit = "ते देवा अब्रुवन् - नमो देव्यै महादेव्यै शिवायै सततं नमः । नमः प्रकृत्यै भद्रायै नियताः प्रणताः स्म ताम् ॥ १६॥",
        hindi = """
            (देवताओं का अहंकार टूटना और परम समर्पण): देवी की उस प्रलयंकारी और असीम गर्जना (Devi Sukta) को सुनकर देवताओं का सारा घमंड चकनाचूर हो गया।
            उनकी बुद्धि सुन्न पड़ गई, और वे सब के सब काँपते हुए घुटनों के बल गिर पड़े। तब उन सभी देवताओं ने (ते देवा अब्रुवन्) एक साथ स्तुति शुरू की:
            "उस परम 'देवी' को, उस 'महादेवी' (ब्रह्मांड की सबसे बड़ी सत्ता) को हमारा नमस्कार है! उस परम कल्याणकारी (शिवायै) माँ को हम बार-बार, लगातार (सततं) प्रणाम करते हैं!"
            "उस परम 'प्रकृति' (Nature/Origin) को, जो भद्र (सौम्य और मंगलकारी) है, उसे हम नमस्कार करते हैं।"
            "हम पूरी तरह से अपने मन और अहंकार को काबू में करके (नियताः), उस परम सत्ता के सामने हमेशा के लिए झुक गए हैं (प्रणताः स्म ताम्)!"
            यहाँ 'शिव' (Shiva) का अर्थ किसी पुरुष देवता से नहीं है; यहाँ देवी को ही साक्षात 'शिवा' (परम शांति और कल्याण का स्वरूप) कहा गया है।
            जब ब्रह्मा, विष्णु और इंद्र जैसे महा-देवताओं को भी देवी के सामने ज़मीन पर माथा टेकना पड़ा, तो एक साधारण इंसान के घमंड की क्या औकात है?
            यह श्लोक इंसान को सिखाता है कि भगवान को चालाकी या बुद्धि से नहीं पाया जा सकता; उसे केवल अपने 'मैं' (Ego) की पूरी मौत और पूर्ण समर्पण (Total Surrender) से ही पाया जा सकता है।
            जब इंसान का मन (Mind) पूरी तरह हार मान लेता है और ब्रह्मांड की इस परम शक्ति (प्रकृति) के आगे झुक जाता है, तभी उसे उस महादेवी का असली प्यार और सुरक्षा मिलती है।
            यही सनातन धर्म के 'भक्ति योग' का सबसे भयंकर और परम रूप है—जहाँ राजा भी भिखारी बनकर माँ के पैरों में गिर जाता है।
        """.trimIndent(),
        english = """
            (The Annihilation of Divine Ego and Absolute Surrender): Upon hearing the apocalyptic, boundless cosmic roar of the Goddess (Devi Sukta), the toxic arrogance of the supreme gods was violently shattered into dust.
            Their intellects were instantly paralyzed, and they collapsed entirely to their knees in sheer terror. Then, absolutely all the cosmic deities collectively began to chant (Te deva abruvan):
            "To that Absolute 'Devi', to that 'Maha-Devi' (The supreme dictator of the cosmos), we violently bow! To that absolute auspicious Mother (Shivayai), we bow constantly, endlessly (Satatam)!"
            "To that Supreme 'Prakriti' (Root Nature/Origin), who is infinitely benevolent and auspicious (Bhadrayai), we offer our absolute salutations."
            "Having violently slaughtered our ego and completely disciplined our minds (Niyatah), we have permanently and unconditionally prostrated ourselves before Her absolute authority (Pranatah sma tam)!"
            Here, 'Shiva' definitely does not refer to the male deity; the Goddess Herself is explicitly addressed as 'Shivaa' (The literal incarnation of supreme peace and auspiciousness).
            When colossal deities like Brahma, Vishnu, and Indra are forcefully forced to slam their foreheads onto the dirt before the Goddess, what pathetic worth does a microscopic human's arrogance hold?
            This verse ruthlessly teaches humanity that God can absolutely never be attained through cunning logic or brainpower; She can only be accessed through the violent death of the 'Ego' and Absolute Surrender.
            Only when the human mind (Intellect) completely accepts catastrophic defeat and violently bows before this Supreme Power (Prakriti), does he attain the true, terrifying protection and love of the Maha-Devi.
            This is the most lethal, absolute climax of 'Bhakti Yoga' in Sanatana Dharma—where even the Emperor of the universe mutates into a crying beggar collapsing at the feet of the Mother.
        """.trimIndent()
    ),
    DeviShloka(
        id = 17,
        sanskrit = "तामग्निवर्णां तपसा ज्वलन्तीं वैरोचनीं कर्मफलेषु जुष्टाम् । दुर्गां देवीं शरणमहं प्रपद्ये सुतरसि तरसे नमः ॥ १७॥",
        hindi = """
            (दुर्गा का अग्नि स्वरूप और महा-शरणागति): देवता अब उस परम माँ के सबसे मारक, खौफनाक और तेजस्वी रूप की स्तुति कर रहे हैं।
            "जिनका रंग और तेज साक्षात धधकती हुई आग (अग्निवर्णां) के समान है, जो अपने ही परम ज्ञान और तप की ऊर्जा से भयंकर रूप से जल रही हैं (तपसा ज्वलन्तीं)!"
            "जो साक्षात परम प्रकाश (वैरोचनीं) का स्वरूप हैं, और जो इस दुनिया में इंसानों के हर कर्म का फल (कर्मफलेषु) बिल्कुल सटीक तरीके से देने वाली (जुष्टाम्) हैं।"
            "ऐसी अजेय और परम भयंकर 'दुर्गा' देवी (जिसे पार पाना या जीतना असंभव है) की शरण में, मैं पूरी तरह से गिरता हूँ (शरणमहं प्रपद्ये)!"
            "हे महादेवी! आप हमें संसार के इस भयानक और उफनते हुए भवसागर से बहुत ही आसानी से (सुतरसि) पार करा देती हैं; आपके इस वेग (तरसे) और शक्ति को मेरा नमस्कार है!"
            यह श्लोक 'दुर्गा' (Durga) शब्द की असली और प्रलयंकारी परिभाषा है। 'दुर्गा' का मतलब है वह किला (Fortress) जिसे दुनिया की कोई ताक़त, कोई बीमारी, या मौत भी नहीं भेद सकती।
            वह कोई साधारण स्त्री नहीं है; वह करोड़ों सूर्यों की धधकती हुई ज्वाला (अग्निवर्णां) है, जो पापियों को भस्म कर देती है और अपने बच्चों को ठंडक देती है।
            इंसान कर्म (Karma) के जाल से बहुत डरता है, लेकिन यह श्लोक कह रहा है कि कर्मों का फल देने वाली मशीन कोई निर्जीव कंप्यूटर नहीं, बल्कि साक्षात यह न्याय करने वाली माँ है।
            जब इंसान हर तरफ से हार जाता है, दुनिया उसे कुचल देती है, तब केवल एक ही रास्ता बचता है—सीधे उस धधकती हुई दुर्गा की शरण (Refuge) में कूद जाना।
            जो इस 'अग्नि' के भीतर छुप जाता है, उसे फिर इस ब्रह्मांड की कोई भी आग नहीं जला सकती; वह संसार के महासागर को एक छोटे से गड्ढे की तरह पार कर लेता है।
        """.trimIndent(),
        english = """
            (The Blazing Fire Form of Durga and Absolute Refuge): The gods now violently praise the most lethal, apocalyptic, and blindingly radiant manifestation of the Supreme Mother.
            "Whose complexion and absolute radiance are identical to a catastrophically blazing Fire (Agnivarnam), who is violently combusting with the sheer nuclear energy of Her own supreme wisdom and penance (Tapasa jvalantim)!"
            "Who is the explicit literal incarnation of Absolute Cosmic Light (Vairochanim), and who flawlessly, ruthlessly dispenses the exact consequences of all human actions (Karmaphaleshu jushtam)."
            "I violently and unconditionally throw myself entirely into the absolute refuge (Sharanamaham prapadye) of such an invincible, terrifying Goddess 'Durga' (The impregnable fortress that is biologically impossible to conquer)!"
            "O Maha-Devi! You effortlessly and violently propel us across (Sutarasi) this horrifying, boiling, catastrophic ocean of worldly existence; to Your sheer kinetic velocity (Tarase) and power, I bow!"
            This verse dictates the true, apocalyptic definition of the word 'Durga'. 'Durga' literally means the ultimate Cosmic Fortress that absolutely no earthly power, disease, or Death itself can ever penetrate.
            She is definitively not a mundane female; She is the violently combusting nuclear inferno of billions of suns (Agnivarnam), which mercilessly incinerates toxic sinners while providing cooling shelter to Her children.
            Humans are pathologically terrified of the matrix of 'Karma', but this verse screams that the machine dispensing Karma is not a dead computer, but explicitly this fierce, justice-delivering Mother.
            When a human is violently crushed from all sides and defeated by the matrix, strictly ONE absolute path remains—leap directly into the terrifying refuge of that blazing Durga.
            Whoever successfully hides inside this 'Fire', can absolutely never be burnt by any other fire in the cosmos; he effortlessly crosses the apocalyptic ocean of existence as if it were a microscopic puddle.
        """.trimIndent()
    ),
    DeviShloka(
        id = 18,
        sanskrit = "देवीं वाचमजनयन्त देवास्तां विश्वरूपाः पशवो वदन्ति । सा नो मन्द्रेषमूर्जं दुहाना धेनुर्वागस्मानुप सुष्टुतैतु ॥ १८॥",
        hindi = """
            (वाग्देवी - ब्रह्मांडीय ध्वनि और कामधेनु): यह श्लोक ऋग्वेद से लिया गया है और ब्रह्मांड में 'भाषा' (Speech/Vibration) की उत्पत्ति का प्रलयंकारी रहस्य खोलता है।
            "सृष्टि की शुरुआत में देवताओं ने उस परम चेतना को 'वाक्' (परम ध्वनि/Speech) के रूप में प्रकट किया (देवीं वाचमजनयन्त)।"
            "और आज इस दुनिया में जितने भी प्रकार के जीव-जंतु (विश्वरूपाः पशवो) और इंसान हैं, वे जो कुछ भी बोलते या आवाज़ करते हैं (वदन्ति), वह सब उसी देवी का रूप है।"
            "वह वाग्देवी (सरस्वती/वाणी) एक ऐसी आनंद देने वाली (मन्द्रा) और असीम 'कामधेनु गाय' (धेनु) के समान है, जो हम पर शक्ति (ऊर्जं) और अन्न-सुख (इषम्) की बारिश (दुहाना) करती है।"
            "हम उस देवी की परम स्तुति (सुष्टुता) करते हैं; वह कृपा करके हमेशा हमारे पास (अस्मानुप) आकर स्थित रहे!"
            लोग सोचते हैं कि इंसान के मुँह से निकलने वाले शब्द उसके अपने हैं; यह सबसे बड़ा अज्ञान है। जो आवाज़ तुम निकाल रहे हो, वह साक्षात वह देवी (वाक्) है जो तुम्हारे गले में वाइब्रेट (Vibrate) कर रही है।
            जानवरों की चीख, पक्षियों का गाना और ब्रह्मांड में गूंजने वाला 'ॐ' (ओम)—यह सब केवल एक ही देवी की अलग-अलग भाषाएं हैं।
            यह देवी कोई साधारण शक्ति नहीं, यह वह परम 'गाय' (Cosmic Cow/धेनु) है जिसे जितना दुहा जाए (Milked), वह उतना ही अनंत ज्ञान और ऊर्जा (ऊर्जं) देती है।
            सच्चा योगी कभी गलत शब्द नहीं बोलता, क्योंकि वह जानता है कि अपशब्द बोलना साक्षात अपने गले में बैठी हुई माँ (वाग्देवी) का अपमान करना है।
            जब इंसान इस सच्चाई को जानकर मौन (Silence) या परम मंत्रों का जाप करता है, तो वह देवी खुश होकर उसे पूरे ब्रह्मांड की ताक़त सौंप देती है।
        """.trimIndent(),
        english = """
            (Vagdevi - The Cosmic Frequency and the Ultimate Kamadhenu): This verse, extracted directly from the Rigveda, violently unveils the apocalyptic secret behind the genesis of 'Language' (Speech/Frequency) in the cosmos.
            "At the absolute violent dawn of creation, the supreme gods explicitly manifested that Supreme Consciousness exclusively in the physical form of 'Vak' (The Absolute Cosmic Sound/Speech)."
            "And today, whatever sounds, languages, or frequencies are physically uttered (Vadanti) by absolutely all diverse species of animals and humans (Vishvarupah Pashavo) in this matrix, are entirely the physical manifestation of that exact Goddess."
            "That Vagdevi (Saraswati/Goddess of Speech) is exactly like an infinitely blissful (Mandra), limitless 'Kamadhenu Cow' (Dhenu), relentlessly milking and showering (Duhana) absolute raw power (Urjam) and material/spiritual nourishment (Isham) upon us."
            "We violently and fiercely offer supreme praises (Sushtuta) to Her; may She gracefully descend and permanently establish Herself directly within us (Asmanupa)!"
            Fools pathetically hallucinate that the words violently exiting their mouths belong to them; this is the apex of cosmic ignorance. The actual frequency you are generating is literally the Goddess (Vak) vibrating directly inside your biological throat.
            The shrieks of wild animals, the songs of birds, and the apocalyptic roar of 'OM' echoing across deep space—are strictly the diverse dialects of that ONE singular Goddess.
            This Goddess is not a mundane force; She is that supreme 'Cosmic Cow' (Dhenu) who, no matter how much you milk Her through meditation, continues to relentlessly vomit infinite wisdom and sheer raw kinetic energy (Urjam).
            The true awake Yogi absolutely never utters toxic garbage, because he realizes that speaking filth is a direct, violent biological insult to the Mother (Vagdevi) permanently sitting in his vocal cords.
            When a human realizes this truth and aggressively executes absolute Silence or chants supreme mantras, that Goddess is pleased and violently hands him the total operating power of the universe.
        """.trimIndent()
    ),
    DeviShloka(
        id = 19,
        sanskrit = "कालरात्रीं ब्रह्मस्तुतां वैष्णवीं स्कन्दमातरम् । सरस्वतीमदितिं दक्षदुहितरं नमामः पावनां शिवाम् ॥ १९॥",
        hindi = """
            (देवी के समस्त प्रलयंकारी और कल्याणकारी रूपों को नमन): देवता अब देवी के उन सभी रूपों को एक साथ जोड़ रहे हैं, जो पूरे ब्रह्मांड का चक्र चलाते हैं।
            "हम उस परम भयंकर 'कालरात्रि' (विनाश की देवी, जो समय और मृत्यु को भी निगल जाती है) को नमस्कार करते हैं, जिसकी स्तुति स्वयं ब्रह्मा (ब्रह्मस्तुतां) करते हैं।"
            "हम उस 'वैष्णवी' (विष्णु की पालन करने वाली अजेय शक्ति) और 'स्कंदमाता' (कार्तिकेय/युद्ध के देवता की माँ) को प्रणाम करते हैं।"
            "हम ज्ञान की परम देवी 'सरस्वती', सभी देवताओं की माँ 'अदिति', और राजा दक्ष की बेटी (सती/पार्वती) को नमस्कार करते हैं।"
            "हम उस परम पवित्र करने वाली (पावनां) और असीम शांति व कल्याण की साक्षात मूर्ति 'शिवा' (महादेवी) के चरणों में पूरी तरह झुकते हैं (नमामः)!"
            यह श्लोक सनातन धर्म के शाक्त दर्शन का मास्टरस्ट्रोक (Masterstroke) है। जो 'कालरात्रि' बनकर दुनिया को बेदर्दी से मारती और भस्म करती है...
            बिल्कुल वही देवी 'शिवा' बनकर दुनिया को सबसे पवित्र प्यार और शांति भी देती है!
            भगवान का कोई एक फिक्स (Fixed) चेहरा नहीं है। वह मौत (कालरात्रि) भी है, वह जीवन (अदिति) भी है, और वह ज्ञान (सरस्वती) भी है।
            अज्ञानी इंसान भगवान के भयंकर (विनाशकारी) रूप से डरता है और केवल सौम्य रूप की पूजा करता है; लेकिन योगी जानता है कि विनाश के बिना नया जीवन पैदा ही नहीं हो सकता।
            जब तुम मौत (कालरात्रि) को भी 'माँ' मानकर गले लगा लेते हो, तब मौत का सारा डर खत्म हो जाता है।
            यहाँ आकर इंसान की बुद्धि पूरी तरह शून्य हो जाती है, और वह ब्रह्मांड की हर अच्छी-बुरी घटना में केवल अपनी परम माँ के हाथ को देखने लगता है।
        """.trimIndent(),
        english = """
            (Salutations to All Apocalyptic and Benevolent Forms of the Goddess): The gods now violently merge absolutely all the diverse forms of the Goddess that continuously operate the terrifying cycle of the cosmos into one.
            "We violently bow to that absolute, horrifying 'Kalaratri' (The Apocalyptic Goddess of the Dark Night who literally swallows Time and Death itself), who is fiercely praised even by Brahma (Brahmastutam)!"
            "We prostrate before that 'Vaishnavi' (The invincible preserving force of Vishnu) and 'Skandamata' (The supreme Mother of Kartikeya, the god of cosmic war)."
            "We offer our absolute salutations to 'Saraswati' (The Goddess of supreme wisdom), 'Aditi' (The infinite Mother of all cosmic deities), and the fierce daughter of Daksha (Sati/Parvati)."
            "We violently collapse our egos and bow completely (Namamah) to that supremely purifying (Pavanam) absolute incarnation of boundless peace and benevolence, 'Shivaa' (The Maha-Devi)!"
            This verse is the absolute, devastating masterstroke of Shakta philosophy. The exact same entity that mutates into 'Kalaratri' to mercilessly slaughter and incinerate the matrix...
            Is explicitly the exact same Goddess who mutates into 'Shivaa' to blindly dispense the most supremely pure love and peace!
            God absolutely does not possess a single fixed, pathetic face. She is literal apocalyptic Death (Kalaratri), She is biological Life (Aditi), and She is sheer raw Data/Knowledge (Saraswati).
            Ignorant fools are pathologically terrified of God's destructive aspect and pathetically worship only the gentle forms; but the Yogi mathematically knows that without violent destruction, biological genesis is absolutely impossible.
            When you aggressively hug literal Death (Kalaratri) calling Her 'Mother', the entire pathetic biological fear of dying is permanently terminated.
            Exactly at this threshold, human intellect drops to dead zero, and the human begins physically seeing strictly the violent, loving hands of his Supreme Mother in every catastrophic or beautiful cosmic event.
        """.trimIndent()
    ),
    DeviShloka(
        id = 20,
        sanskrit = "महालक्ष्म्यै च विद्महे सर्वशक्त्यै च धीमहि । तन्नो देवी प्रचोदयात् ॥ २०॥",
        hindi = """
            (देवी गायत्री मंत्र - महा-चेतना का जागरण): यह उपनिषद का सबसे शक्तिशाली और प्रलयंकारी 'देवी गायत्री मंत्र' है, जो सीधे आत्मा (Soul) पर वार करता है।
            "हम उस परम 'महालक्ष्मी' (ब्रह्मांड की सबसे बड़ी सत्ता और परम ऐश्वर्य) को जानने का घोर प्रयास करते हैं (विद्महे)।"
            "हम उस 'सर्वशक्ति' (जिसके भीतर दुनिया की सारी ताक़त और ऊर्जा समाई हुई है) का परम एकाग्रता के साथ ध्यान करते हैं (धीमहि)।"
            "वह परम 'देवी' (महामाया) हमारी बुद्धि, हमारी चेतना और हमारे पूरे अस्तित्व को अंधकार से निकालकर परम प्रकाश की ओर धकेल दे (प्रचोदयात्)!"
            गायत्री मंत्र का मतलब किसी भगवान से पैसे या उम्र की भीख माँगना नहीं है। 'प्रचोदयात्' का असली अर्थ है— "मेरे दिमाग (बुद्धि) पर कब्ज़ा कर लो और इसे चलाओ!"
            इंसान का सबसे बड़ा दुश्मन उसकी अपनी ही छोटी सोच (अज्ञान) है। जब तक बुद्धि अंधी है, इंसान दुनिया के दुखों में पिटता रहता है।
            यह मंत्र एक मानसिक परमाणु बम की तरह है। जब साधक 'सर्वशक्त्यै' (All-Powerful) का ध्यान करता है, तो उसके भीतर सोई हुई कुण्डलिनी शक्ति (Kundalini) एक धमाके के साथ जाग जाती है।
            उसे समझ आ जाता है कि महालक्ष्मी केवल पैसों की देवी नहीं है, वह साक्षात 'मोक्ष' (Liberation) की देवी है, जो आत्मा को आज़ाद करती है।
            जब यह परम देवी तुम्हारी बुद्धि का स्टेरिंग (Steering) अपने हाथ में ले लेती है, तो तुम कभी गलत रास्ता नहीं पकड़ सकते।
            यह श्लोक इंसान के 'स्वतंत्र इच्छा' (Free Will) के अहंकार को जला देता है और उसे ब्रह्मांड की सबसे बड़ी ताक़त के साथ एक (Fuse) कर देता है।
            यहीं से योगी एक साधारण जीव से उठकर साक्षात ईश्वरत्व (Godhood) की परम यात्रा की शुरुआत करता है।
        """.trimIndent(),
        english = """
            (The Devi Gayatri Mantra - The Violent Awakening of Supreme Consciousness): This is the absolute most powerful, apocalyptic 'Devi Gayatri Mantra' of the Upanishad, designed as a direct kinetic strike against the human Soul.
            "We ruthlessly and violently exert absolute effort to realize and comprehend (Vidmahe) that Supreme 'Mahalakshmi' (The ultimate absolute authority and supreme treasure of the cosmos)."
            "We violently force our entire biological concentration to meditate (Dhimahi) exclusively upon that 'Sarvashakti' (The Omnipotent force containing every single micro-drop of raw power and energy in existence)."
            "May that Supreme 'Devi' (Mahamaya) forcefully seize our intellect, our consciousness, and violently propel our entire existence (Prachodayat) out of toxic darkness straight into the absolute blinding Cosmic Light!"
            The actual objective of a Gayatri mantra is definitively not pathetically begging God for earthly money or biological lifespan. The literal translation of 'Prachodayat' is—"Violently hijack my brain (Intellect) and operate it Yourself!"
            A human's most catastrophic enemy is his own microscopic, toxic ignorance. As long as the intellect remains blind, the human is brutally beaten by worldly agony.
            This specific mantra acts as a psychological nuclear weapon. When the seeker meditates on the 'Sarvashakti' (The Omnipotent), the paralyzed Kundalini energy sleeping inside his biology detonates and violently awakens.
            He irrevocably realizes that Mahalakshmi is absolutely not a petty goddess of paper money; She is explicitly the Goddess of 'Moksha' (Absolute Liberation) who violently shatters the soul's prison.
            When this Supreme Goddess aggressively seizes the absolute steering wheel of your brain, it becomes biologically impossible for you to ever take a wrong cosmic path.
            This verse permanently incinerates the pathetic human ego of 'Free Will', violently fusing the biological entity directly with the greatest unmapped force in the multiverse.
            Exactly from this threshold, the Yogi ceases to be a mundane biological creature and aggressively initiates the supreme, catastrophic trajectory straight into direct Godhood.
        """.trimIndent()
    ),
    DeviShloka(
        id = 21,
        sanskrit = "एकादशी तु सा प्रोक्ता वैष्णवी वैष्णवप्रिया ।",
        hindi = """
            (एकादशी और वैष्णवी शक्ति का रहस्य): देवी का यह स्वरूप स्वयं भगवान विष्णु को भी परम प्रिय है।
            "जो एकादशी तिथि है, उसे साक्षात वैष्णवी शक्ति का स्वरूप माना जाता है; यह तिथि भगवान विष्णु को अत्यंत प्रिय है।"
            यहाँ उपनिषद देवी और विष्णु के बीच के अद्वैत संबंध को उजागर कर रहा है; दोनों अलग नहीं हैं।
            जो एकादशी का व्रत पूरी श्रद्धा और उपवास के साथ करता है, वह साक्षात देवी की उस वैष्णवी ऊर्जा को धारण करता है।
            यह एकादशी केवल उपवास नहीं है, बल्कि मन के विकारों को जलाकर देवी की शुद्धि को भीतर उतारने की प्रक्रिया है।
            देवी वैष्णवी होने के नाते, भक्तों के सांसारिक दुखों को विष्णु की तरह ही हर लेती है।
            जो भक्त एकादशी पर देवी के वैष्णवी स्वरूप का ध्यान करता है, उसके लिए इस संसार में कोई भी कार्य असंभव नहीं रह जाता।
            एकादशी की महिमा केवल पुराणों में नहीं, बल्कि देवी के इस उपनिषद में निहित है, जो बताती है कि शक्ति ही विष्णु है।
            यह शक्ति ही है जो विष्णु के भीतर बैठकर पूरे ब्रह्मांड का पालन-पोषण और सुरक्षा का कार्य करती है।
            इसलिए वैष्णवी देवी की शरण लेना स्वयं विष्णु और लक्ष्मी दोनों की कृपा को एक साथ पा लेना है।
        """.trimIndent(),
        english = """
            (The Secret of Ekadashi and Vaishnavi Power): This specific manifestation of the Goddess is supremely beloved even to Lord Vishnu.
            "The Ekadashi (the eleventh day) is explicitly declared as the literal form of Vaishnavi Shakti; this date is supremely cherished by Lord Vishnu."
            The Upanishad here unveils the non-dual relationship between the Goddess and Vishnu; both are absolutely not separate.
            He who observes the Ekadashi fast with absolute reverence and devotion, actively embodies the Vaishnavi energy of the Goddess.
            Ekadashi is strictly not merely a fast; it is the lethal process of incinerating mental impurities to allow the Goddess's absolute purity to descend within.
            As the Vaishnavi power, the Goddess ruthlessly eradicates the worldly sufferings of Her devotees, just as Vishnu does.
            For a devotee who meditates on the Vaishnavi form of the Goddess on Ekadashi, absolutely no goal in this matrix remains unachievable.
            The majesty of Ekadashi is rooted not only in the Puranas but explicitly in this Upanishad, which proves that Shakti is Vishnu.
            It is this Power, residing deep within Vishnu, that executes the entire cosmic operation of preserving and protecting the universe.
            Therefore, seeking the refuge of the Vaishnavi Goddess is to simultaneously attain the infinite grace of both Vishnu and Lakshmi.
        """.trimIndent()
    ),
    DeviShloka(
        id = 22,
        sanskrit = "द्वादशी तु महामाया योगमाया जगन्मयी ।",
        hindi = """
            (द्वादशी और महामाया का रहस्य): उपनिषद अब द्वादशी तिथि के पीछे छिपी देवी की माया शक्ति का वर्णन कर रहा है।
            "जो द्वादशी तिथि है, वह साक्षात 'महामाया', 'योगमाया' और 'जगन्मयी' (पूरे ब्रह्मांड में व्याप्त) देवी का स्वरूप है।"
            द्वादशी का दिन उस शक्ति का है जो इस पूरी दुनिया को भ्रम के जाल में फंसाए रखती है और उसे रचती है।
            महामाया वह शक्ति है जो योगी को योग की सिद्धि देती है और सांसारिक मनुष्य को माया के जाल में उलझाए रखती है।
            जिसका मन द्वादशी पर इस जगन्मयी देवी में स्थिर हो जाता है, वह माया को कुचलकर उससे पार निकल जाता है।
            यह वही शक्ति है जो भगवान को भी योगनिद्रा में सुला देती है और सृष्टि के चक्र को सुचारू रूप से चलाती है।
            द्वादशी का व्रत करने वाला भक्त देवी के इस महामाया स्वरूप को अपने भीतर जागृत करता है।
            उसके जीवन के सारे भ्रम और भटकाव, जो माया के कारण पैदा हुए हैं, एक-एक करके मिटने लगते हैं।
            देवी की यह जगन्मयी शक्ति ही है जो अणु से लेकर ब्रह्मांड तक हर चीज़ को एक धागे में पिरोए हुए है।
            जो इस रहस्य को जान लेता है, वह माया का दास नहीं, बल्कि माया का स्वामी बन जाता है।
        """.trimIndent(),
        english = """
            (The Secret of Dvadashi and Mahamaya): The Upanishad now elaborates on the cosmic illusory power of the Goddess hidden behind the Dvadashi (twelfth) day.
            "The Dvadashi (the twelfth day) is the literal manifestation of the 'Mahamaya', 'Yogamaya', and 'Jaganmayi' (pervading the entire universe) Goddess."
            The day of Dvadashi belongs strictly to the Power that traps the entire world in a web of cosmic illusions and simultaneously creates it.
            Mahamaya is the lethal force that grants the Yogi the success of Yoga and keeps the mundane human trapped in the pathetic snare of illusion.
            He whose mind becomes anchored in this Jaganmayi Goddess on Dvadashi, violently crushes the illusion and emerges out of it.
            It is this exact Power that lullabies even God into the cosmic sleep (Yoganidra) and flawlessly operates the cycle of creation.
            A devotee who observes the Dvadashi vow awakens this Mahamaya form of the Goddess directly within his own biology.
            All the illusions and mental deviations in his life, birthed by Maya, begin to disintegrate one by one.
            It is this Jaganmayi power of the Goddess that weaves everything, from the microscopic atom to the colossal universe, into a single thread.
            He who comprehends this terrifying secret ceases to be a slave of Maya, mutating instead into the absolute Master of Maya.
        """.trimIndent()
    ),
    DeviShloka(
        id = 23,
        sanskrit = "त्रयोदशी तु ललिता साक्षात्कामेश्वरवल्लभा ।",
        hindi = """
            (त्रयोदशी और ललिता का रहस्य): त्रयोदशी तिथि का महत्त्व देवी के सबसे सुंदर और रहस्यमयी स्वरूप से जुड़ा है।
            "त्रयोदशी तिथि साक्षात 'ललिता' (महात्रिपुरसुंदरी) का स्वरूप है, जो भगवान 'कामेश्वर' (शिव) की प्राणप्रिया हैं।"
            ललिता रूप देवी का सबसे सर्वोच्च और सौम्य स्वरूप है, जो भक्त को परम आनंद और मोक्ष देने वाला है।
            कामेश्वर-वल्लभा होने के नाते, वह शक्ति और चेतना के अद्वैत मिलन का प्रतीक है—शिव और शक्ति का शाश्वत प्रेम।
            त्रयोदशी पर ललिता की पूजा करने वाला भक्त अपने जीवन में उस दिव्य आनंद को प्राप्त करता है जिसे दुनिया नहीं जानती।
            यह देवी ही वह प्रेम है जो शिव के भीतर तड़प बनकर दौड़ता है और ब्रह्मांड को रचने की प्रेरणा देता है।
            ललिता की पूजा करने वाले के व्यक्तित्व में एक असीम आकर्षण और तेज पैदा हो जाता है, क्योंकि वह साक्षात देवी का रूप हो जाता है।
            वह योगी, जो ललिता और कामेश्वर के मिलन का रहस्य समझ लेता है, वह खुद भी उसी आनंद के सागर में डूब जाता है।
            यह स्वरूप भक्त को सांसारिक वासनाओं से उठाकर उस दिव्य प्रेम की ओर ले जाता है जो केवल आत्मा का होता है।
            ललिता की आराधना भक्त को एक ऐसे लोक में ले जाती है जहाँ केवल प्रेम और सौंदर्य ही शेष बचता है।
        """.trimIndent(),
        english = """
            (The Secret of Trayodashi and Lalita): The significance of the Trayodashi (thirteenth) day is intrinsically linked to the most beautiful and classified form of the Goddess.
            "The Trayodashi day is the literal manifestation of 'Lalita' (Maha-Tripura-Sundari), who is the beloved soul-mate of Lord 'Kameshvara' (Shiva)."
            Lalita is the most supreme and exquisite form of the Goddess, destined to grant the devotee absolute bliss and liberation.
            Being the beloved of Kameshvara, She is the symbol of the non-dual union of Power and Consciousness—the eternal love of Shiva and Shakti.
            A devotee worshipping Lalita on Trayodashi attains a supreme cosmic bliss in his life that the pathetic world is fundamentally incapable of knowing.
            This Goddess is the literal love that races like a throbbing desire within Shiva, serving as the inspiration to manufacture the entire cosmos.
            Infinite attraction and lethal brilliance erupt into the personality of one who worships Lalita, because he mutates into the exact form of the Goddess.
            The Yogi, who comprehends the secret behind the union of Lalita and Kameshvara, violently drowns himself in that same bottomless ocean of bliss.
            This form aggressively elevates the devotee from worldly lusts toward that divine love which belongs exclusively to the Soul.
            The worship of Lalita catapults the seeker into a dimension where strictly Love and absolute Beauty remain.
        """.trimIndent()
    ),
    DeviShloka(
        id = 24,
        sanskrit = "चतुर्दशी तु काली साक्षात महाकालीति विश्रुता ।",
        hindi = """
            (चतुर्दशी और महाकाली का प्रलयंकारी रूप): उपनिषद अब समय को काटने वाली उस शक्ति की चर्चा कर रहा है जो अंत में सब कुछ भस्म कर देती है।
            "चतुर्दशी तिथि साक्षात 'काली' (समय का अंत करने वाली) का रूप है, जिसे 'महाकाली' के नाम से पूरे संसार में जाना जाता है।"
            काली रूप समय (काल) की वह धारा है जो कभी रुकती नहीं और सब कुछ अपने साथ बहाकर ले जाती है।
            महाकाली का अर्थ है वह शक्ति जो मृत्यु और विनाश के पीछे छिपी है, जो अज्ञान के राक्षसों का वध करती है।
            चतुर्दशी पर काली की पूजा करना अपने भीतर के उन सभी राक्षसी विचारों को मारना है जो हमें सच से दूर रखते हैं।
            यह देवी वो है जो बड़े से बड़े अहंकारी के अहंकार को एक झटके में धूल में मिला देती है।
            जो काली की शरण में जाता है, उसे मृत्यु या विनाश का कोई डर नहीं रहता, क्योंकि वह काल (काली) के ही अधीन हो गया है।
            महाकाली कोई डरावनी देवी नहीं है; वह वो माँ है जो बच्चे को कचरे (अज्ञान) से बचाकर उसे साफ़ करती है।
            इस तिथि पर काली का ध्यान इंसान के अंदर की उस सोई हुई प्रलयंकारी ऊर्जा को जागृत कर देता है, जो बुराई का अंत कर देती है।
            महाकाली का अर्थ है 'अनंत', जिसका न कोई आदि है, न कोई अंत; वह समय के उस पार खड़ी है।
        """.trimIndent(),
        english = """
            (The Apocalyptic Form of Chaturdashi and Mahakali): The Upanishad now discusses the power that shreds Time itself, the force that ultimately incinerates everything into void.
            "The Chaturdashi (the fourteenth day) is the literal manifestation of 'Kali' (The Ender of Time), famously recognized globally as 'Mahakali'."
            The form of Kali is that relentless current of Time (Kala) that never halts and violently washes absolutely everything away with it.
            Mahakali represents the secret Power hiding behind Death and Annihilation, who ruthlessly assassinates the demons of human ignorance.
            Worshipping Kali on Chaturdashi is the violent slaughter of all those demon-like thoughts residing within us that distance us from the Absolute Truth.
            She is the Goddess who instantly grinds the pride of the most arrogant ego into dust with a single strike.
            He who seeks the refuge of Kali harbors absolutely zero fear of biological death or destruction, because he has surrendered himself to Time (Kali) itself.
            Mahakali is definitively not a terrifying goddess; She is the Mother who protects Her child from toxic garbage (ignorance) by aggressively scrubbing it away.
            Meditation on Kali on this date detonates that dormant, apocalyptic energy residing within the human, which triggers the total extermination of evil.
            Mahakali translates to 'The Infinite', possessing neither a beginning nor an end; She stands stationed entirely beyond the grasp of Time.
        """.trimIndent()
    ),
    DeviShloka(
        id = 25,
        sanskrit = "पूर्णिमा सा महालक्ष्मीर्महालक्ष्मीः प्रकीर्तिता ॥ २५॥",
        hindi = """
            (पूर्णिमा और महालक्ष्मी की पूर्णता): उपनिषद अब पूर्णिमा की पूर्णता को देवी के सबसे समृद्ध और ऐश्वर्यपूर्ण रूप से जोड़ता है।
            "पूर्णिमा तिथि साक्षात 'महालक्ष्मी' का स्वरूप है; इसे ही ग्रंथों में 'महालक्ष्मी' के नाम से जाना जाता है।"
            पूर्णिमा चाँद की पूर्णता का दिन है, और देवी महालक्ष्मी उस पूर्णता की साक्षात प्रतीक हैं।
            महालक्ष्मी केवल पैसों की देवी नहीं है; वह 'पूर्णता' (Completion) की देवी है, जिसके बिना हर इंसान अधूरा है।
            पूर्णिमा पर महालक्ष्मी का ध्यान करने वाला भक्त जीवन के हर क्षेत्र में (ज्ञान, स्वास्थ्य, समृद्धि) पूर्णता पाता है।
            वह शक्ति जो ब्रह्मांड में सब कुछ सही सलामत और समृद्ध रखती है, वही लक्ष्मी है।
            जब चाँद पूरा होता है, तो वह देवी की उस असीम उदारता को दर्शाता है जो भक्त पर कृपा की बारिश करती है।
            जो महालक्ष्मी को जानता है, उसे दुनिया में किसी चीज़ की कमी (Lacking) महसूस नहीं होती।
            वह पूर्ण (Brahman) हो जाता है, क्योंकि लक्ष्मी उसे संसार के सुख और मोक्ष की परम शांति दोनों देती है।
            पूर्णिमा पर देवी के इस पूर्ण स्वरूप की आराधना भक्त को जीवन की हर कमी से मुक्त कर देती है।
        """.trimIndent(),
        english = """
            (The Fullness of Purnima and Mahalakshmi): The Upanishad now links the absolute fullness of the Full Moon (Purnima) day to the most prosperous and grand form of the Goddess.
            "The Purnima (the full moon day) is the literal manifestation of 'Mahalakshmi'; it is explicitly described in the scriptures as 'Mahalakshmi'."
            Purnima is the day of the moon's absolute perfection, and the Goddess Mahalakshmi is the literal, physical embodiment of that absolute perfection.
            Mahalakshmi is definitively not merely a goddess of paper money; She is the Goddess of 'Completion', without whom every human is fundamentally broken and incomplete.
            A devotee who meditates on Mahalakshmi on the Purnima day attains total perfection in every single sector of existence (wisdom, health, wealth).
            The Power that keeps everything in the cosmos flawlessly functional, balanced, and prosperous is strictly Mahalakshmi.
            When the moon is whole, it demonstrates that infinite generosity of the Goddess who violently showers Her grace upon Her devotee.
            He who realizes Mahalakshmi never experiences the pathetic biological feeling of 'lack' (Lacking) anywhere in the matrix.
            He mutates into a 'Whole' (Brahman), because Lakshmi grants him both the joys of the physical world and the supreme peace of absolute liberation.
            Worshipping this perfect form of the Goddess on the Full Moon day irrevocably liberates the devotee from every microscopic inadequacy in life.
        """.trimIndent()
    ),
    DeviShloka(
        id = 26,
        sanskrit = "योऽधीते दशसाहस्रं जपेद्वा पठति प्रिये । स सर्वपापविनिर्मुक्तो ब्रह्मलोके महीयते ॥ २६॥",
        hindi = """
            (अध्ययन और जप का महाफल): उपनिषद अब इस विद्या को जानने और जपने वाले साधक के फल का वर्णन करता है।
            "हे प्रिये! जो भी साधक इस देवी उपनिषद का दस हज़ार बार जप करता है या इसे श्रद्धा से पढ़ता है..."
            "वह अपने समस्त पिछले और वर्तमान पापों (सर्वपापविनिर्मुक्तो) से हमेशा के लिए मुक्त हो जाता है।"
            पाप का अर्थ है—अज्ञान और शरीर को ही सत्य मानना। इस विद्या का निरंतर अभ्यास उस अज्ञान को जड़ से मिटा देता है।
            "वह मरने के बाद सीधे 'ब्रह्मलोक' (परब्रह्म के सर्वोच्च निवास) में प्रतिष्ठित होता है और वहाँ पूज्य माना जाता है।"
            यह कोई साधारण आशीर्वाद नहीं है; यह उस साधक की चेतना का रूपांतरण है जो उसे अमर बना देता है।
            देवी की यह विद्या इतनी शक्तिशाली है कि इसके मंत्रों का उच्चारण करने मात्र से आसपास का वातावरण शुद्ध हो जाता है।
            साधक को अब जन्म-मरण के चक्र में फँसने की कोई आवश्यकता नहीं रहती।
            वह साक्षात उस देवी का अंश बनकर ब्रह्मांडीय चेतना में विलीन हो जाता है।
            इस विद्या का जप करना स्वयं को ब्रह्मांड की सबसे बड़ी शक्ति के साथ जोड़ना है।
        """.trimIndent(),
        english = """
            (The Grand Result of Study and Chanting): The Upanishad now delineates the apocalyptic rewards for the seeker who masters and chants this wisdom.
            "O Beloved! Any seeker who chants this Devi Upanishad ten thousand times or studies it with absolute reverence..."
            "Is permanently liberated (Sarvapapavinirmukto) from all sins of the past and present."
            Sin is defined here as cosmic ignorance and the pathetic delusion of identifying strictly with the physical shell. The continuous practice of this Vidya ruthlessly exterminates that ignorance from the root.
            "After biological death, he is established directly in 'Brahmaloka' (The supreme abode of Brahman) and is venerated as a liberated soul."
            This is definitively not a mundane blessing; it is the fundamental metamorphosis of the seeker’s consciousness that renders him immortal.
            This Vidya of the Goddess is so lethal and powerful that merely vibrating its mantras purifies the surrounding environment instantly.
            The seeker is no longer required to rotate in the pathetic cycle of birth and death.
            He mutates into a literal fragment of the Goddess and dissolves into the cosmic consciousness.
            Chanting this Vidya is to violently plug your biology directly into the greatest Power in the universe.
        """.trimIndent()
    ),
    DeviShloka(
        id = 27,
        sanskrit = "एतदथर्वशिरो योऽधीते स पञ्चाथर्वणजपी भवति ।",
        hindi = """
            (अथर्वशीर्ष का मर्म): यह देवी उपनिषद 'अथर्वशीर्ष' का ही एक भाग है, जिसकी महत्ता अपरंपार है।
            "जो भी साधक इस 'अथर्वशिर' (मस्तक के समान सर्वोच्च ज्ञान) का अध्ययन करता है, वह 'पञ्चाथर्वण' जपी हो जाता है।"
            पञ्चाथर्वण का अर्थ है वह साधक जिसकी वाणी और चेतना पाँचों तत्वों और अथर्वण के रहस्यमय मंत्रों को सिद्ध करने में सक्षम हो गई है।
            यह उपनिषद केवल किताब नहीं है; यह वह चाबी (Key) है जो इंसान के भीतर सोई हुई दिव्य शक्तियों को खोलती है।
            जो इसे पढ़ता है, उसके शब्द अब साधारण नहीं रहते, वे साक्षात मंत्र (मंत्र सिद्धि) बन जाते हैं।
            यह विद्या साधक को प्रकृति के रहस्यों को समझने और उन पर नियंत्रण पाने की ताक़त देती है।
            जो भी इस ज्ञान को अपनाता है, उसे फिर दुनिया के किसी और तंत्र या मंत्र के पीछे भटकने की आवश्यकता नहीं रहती।
            वह स्वयमेव एक सिद्ध पुरुष बन जाता है, जिसके संकल्प मात्र से चीज़ें होने लगती हैं।
            यह ज्ञान इंसान को 'साधारण' से 'असाधारण' (Divine) बनाने की प्रक्रिया है।
        """.trimIndent(),
        english = """
            (The Essence of Atharvashira): This Devi Upanishad is a core component of the 'Atharvashira' (the head/apex knowledge), whose greatness is limitless.
            "Any seeker who studies this 'Atharvashira' (the absolute supreme knowledge, like the crown of the head), becomes a master of the 'Panchatharvana' chants."
            'Panchatharvana' signifies a seeker whose speech and consciousness have become capable of mastering the five elements and the classified mantras of the Atharvaveda.
            This Upanishad is definitely not merely a book; it is the lethal Key that forcefully unlocks the divine cosmic powers sleeping inside the human.
            Whoever studies this, his words cease to be mundane; they mutate into literal, reality-altering mantras (Mantra-Siddhi).
            This Vidya grants the seeker the terrifying power to comprehend and dominate the raw laws of nature.
            Whoever adopts this knowledge no longer requires wandering behind any other Tantra or Mantra in the matrix.
            He spontaneously becomes a 'Siddha Purusha' (an accomplished master), whose mere will causes reality to shift.
            This knowledge is the absolute, lethal process of mutating an 'ordinary' biological creature into an 'extraordinary' (Divine) cosmic entity.
        """.trimIndent()
    ),
    DeviShloka(
        id = 28,
        sanskrit = "सोऽहंभावेन पूजयेत् । स विष्णुपदमवाप्नोति ।",
        hindi = """
            (सोऽहं का अभ्यास और विष्णु पद): देवी की उपासना का सबसे रहस्यमय तरीका यहाँ बताया गया है।
            "इंसान को स्वयं को देवी मानकर, 'सोऽहं' (मैं वही परम शक्ति हूँ) के भाव से पूजा करनी चाहिए।"
            जब तक तुम बाहर किसी देवी को ढूँढ रहे हो, तुम अज्ञानी हो; जैसे ही तुम अपने भीतर उस शक्ति को पहचानते हो, तुम देवी हो।
            "जो इस भाव से पूजा करता है, वह साक्षात 'विष्णु पद' (परम मोक्ष/सर्वोच्च स्थिति) को प्राप्त कर लेता है।"
            विष्णु पद का अर्थ यहाँ वह स्थिति है जहाँ व्यक्ति जन्म-मृत्यु से ऊपर उठकर परम चेतना में स्थिर हो जाता है।
            यह पूजा कोई मूर्ति के सामने अगरबत्ती जलाना नहीं है; यह अपने हर विचार में उस देवी को महसूस करना है।
            सांस लेते समय 'सो' और छोड़ते समय 'हं' का उच्चारण, साधक के हर कण को देवीमय बना देता है।
            जो इस 'सोऽहं' की निरंतर धड़कन को अपनी रगों में महसूस करता है, वह जीते-जी स्वर्ग पा लेता है।
            यह पूजा साधक के भीतर के सारे मानवीय दोषों को जलाकर उसे साक्षात नारायण (विष्णु) के पद के योग्य बनाती है।
        """.trimIndent(),
        english = """
            (The Practice of So'ham and the Abode of Vishnu): The most classified method of worshipping the Goddess is revealed here.
            "A human must worship by recognizing himself as the Goddess, with the internal feeling of 'So'ham' (I am exactly That Supreme Power)."
            As long as you are hunting for a Goddess externally, you remain ignorant; the microsecond you identify that power within, you ARE the Goddess.
            "He who worships with this exact feeling, violently attains the 'Vishnu-Pada' (Absolute Liberation/The Supreme State)."
            'Vishnu-Pada' here signifies the cataclysmic state where an entity rises above birth-death and stabilizes in pure Absolute Consciousness.
            This worship is definitely not burning incense before a stone idol; it is the terrifying, continuous awareness of that Goddess in every single thought.
            Pronouncing 'So' during inhalation and 'Ham' during exhalation makes every single atom of the seeker identical to the Goddess.
            Whoever physically feels the continuous heartbeat of this 'So'ham' in his veins, attains heaven while still breathing.
            This worship incinerates all human biological flaws, rendering the seeker worthy of the absolute status of Narayana (Vishnu).
        """.trimIndent()
    ),
    DeviShloka(
        id = 29,
        sanskrit = "एकादशरुद्रात्मिका । महाविष्णुस्वरूपा च ।",
        hindi = """
            (देवी के रुद्र और विष्णु स्वरूप): उपनिषद यह स्पष्ट कर रहा है कि विनाश (रुद्र) और पालन (विष्णु) दोनों देवी की ही ऊर्जाएं हैं।
            "वह देवी ही एकादश रुद्रों की साक्षात आत्मा है, जो विनाश की प्रलयंकारी अग्नि है।"
            "और वही देवी साक्षात महाविष्णु का स्वरूप है, जो पालन और सुरक्षा की असीम शक्ति है।"
            इंसान अक्सर विनाश से डरता है और पालन की माँग करता है, लेकिन देवी बता रही है कि विनाश के बिना पालन संभव नहीं है।
            पुराने को मिटाना (रुद्र) और नए को पालना (विष्णु) एक ही सिक्के के दो पहलू हैं।
            यह देवी ही वह है जो प्रलय में विनाश करती है और शांति में ब्रह्मांड को संभालती है।
            साधक को यह समझना चाहिए कि जो भी उसके जीवन में नष्ट हो रहा है, वह देवी का रुद्र रूप है, जो उसे नए के लिए जगह दे रहा है।
            उसका हर कार्य चाहे वह विनाश हो या पालन, दोनों ही कल्याणकारी (शिवा) हैं।
            यह जानकर भक्त का डर खत्म हो जाता है; क्योंकि वह जानता है कि जो भी हो रहा है, सब माँ की मर्ज़ी है।
            उसने विनाश और निर्माण के इस द्वैत (Duality) को देवी में एक कर दिया है।
        """.trimIndent(),
        english = """
            (The Rudra and Vishnu Forms of the Goddess): The Upanishad explicitly clarifies that both Destruction (Rudra) and Preservation (Vishnu) are merely energies of the exact same Goddess.
            "That Goddess is literally the Soul of the eleven Rudras, who represent the apocalyptic fire of annihilation."
            "And that exact Goddess is the literal form of Mahavishnu, who is the infinite force of preservation and absolute security."
            Humans pathologically fear destruction and demand preservation, but the Goddess dictates that preservation is fundamentally impossible without violent destruction.
            Annihilating the old (Rudra) and nurturing the new (Vishnu) are strictly two sides of the same cosmic coin.
            This Goddess is the exact entity who destroys during the apocalypse and maintains the universe during peace.
            The seeker must comprehend that whatever is being annihilated in his life is the Rudra form of the Goddess, aggressively clearing space for the new.
            Every single action She performs, whether destruction or preservation, is exclusively auspicious (Shivaa).
            Realizing this, the devotee's fear is permanently terminated; he realizes whatever is transpiring is strictly the Mother's absolute will.
            He has violently collapsed this duality of destruction and creation into the Goddess.
        """.trimIndent()
    ),
    DeviShloka(
        id = 30,
        sanskrit = "यस्य यस्य यदा यदा । तस्य तस्य तदा तदा ॥ ३०॥",
        hindi = """
            (देवी का पूर्ण नियंत्रण - काल और फल): यह श्लोक ब्रह्मांड के सारे 'टाइमिंग' (Timing) और इवेंट्स (Events) का रहस्य है।
            "जिसका भी, जो भी, जब भी (समय) निर्धारित है; उसी का, वही, ठीक उसी समय (समय पर) घटित होता है।"
            यह देवी ही वह 'कॉस्मिक प्रोग्रामर' है जिसने ब्रह्मांड का पूरा 'टाइम-टेबल' (Time Table) बना रखा है।
            इंसान कितना भी भाग ले, लेकिन देवी की आज्ञा के बिना न एक पत्ता हिलता है, न ही समय का एक सेकंड आगे बढ़ता है।
            यह उपनिषद साधक को 'अहंकार' से मुक्त करता है—क्योंकि जब सब कुछ पूर्व-निर्धारित और देवी के नियंत्रण में है, तो तुम काहे का घमंड कर रहे हो?
            जो तुम्हारे साथ हो रहा है, वह उसी देवी की योजना (Plan) का हिस्सा है।
            साधक जब इसे जान लेता है, तो वह 'शिकायत' करना छोड़ देता है और 'स्वीकार' (Acceptance) करना शुरू कर देता है।
            यही स्वीकार करना ही 'पूर्ण शांति' है, जहाँ भक्त और भगवान की इच्छा एक हो जाती है।
            समय (काल) स्वयं देवी का एक रूप है, इसलिए हर घटना का समय भी देवी ही है।
            जो इस काल के खेल को समझ गया, वह समय के चक्र से ही बाहर निकल गया।
        """.trimIndent(),
        english = """
            (The Absolute Control of the Goddess - Time and Results): This verse is the terrifying secret behind all cosmic 'Timing' and 'Events' in the matrix.
            "Whatever is scheduled for whomever, exactly when it is scheduled; that exact thing, for that exact person, unfolds at that exact, precise microsecond."
            This Goddess is the absolute 'Cosmic Programmer' who has dictatorially mapped out the entire 'Time Table' of the universe.
            No matter how fast a human sprints, not a single leaf moves, nor does a microsecond of time advance, without the absolute, dictatorial command of the Goddess.
            This Upanishad ruthlessly liberates the seeker from 'Ego'—because when absolutely everything is pre-programmed and under the Goddess's absolute control, what are you pathetically arrogant about?
            Whatever is transpiring in your life is an integral fragment of Her absolute Master-Plan.
            When the seeker comprehends this, he terminates 'complaining' and initiates total 'Acceptance'.
            This exact Acceptance is 'Absolute Peace', where the will of the devotee and the will of the Goddess flawlessly fuse into One.
            Time (Kala) is itself a manifestation of the Goddess, therefore, the timing of every single event is explicitly the Goddess Herself.
            He who understands this game of Time, has already violently exited the cycle of Time.
        """.trimIndent()
    ),
    DeviShloka(
        id = 31,
        sanskrit = "देवीसूक्तमिदं देवि सर्वपापप्रणाशनम् ।",
        hindi = """
            (देवी सूक्त का फल - पापों का विनाश): यह देवी उपनिषद के अंत का सबसे महत्वपूर्ण हिस्सा है, जो इसे 'देवी सूक्त' की तरह फलदायी बनाता है।
            "हे देवि! यह जो तुमने उपदेश दिया है (देवी सूक्तम), यह ब्रह्मांड के समस्त पापों को जड़ से नष्ट करने वाला है (सर्वपापप्रणाशनम्)।"
            इस उपनिषद को पढ़ना या इसे सुनना कोई साधारण क्रिया नहीं है; यह अपने भीतर मौजूद गंदगी को साफ़ करने की एक 'लेजर' (Laser) प्रक्रिया है।
            जो इस ज्ञान को अपने भीतर उतार लेता है, उसके पापों के सारे संस्कार (Karmic Impressions) जलकर भस्म हो जाते हैं।
            पाप का अर्थ है—अंधकार। यह देवी सूक्त उस अंधकार को प्रकाश से पूरी तरह भर देता है।
            इसके अर्थ को समझना ही मोक्ष का मार्ग है, क्योंकि इसे सुनने मात्र से इंसान के मन की गांठें खुल जाती हैं।
            यह केवल एक पाठ नहीं है, यह देवी का साक्षात आह्वान (Invocation) है, जो साधक को पवित्र कर देता है।
            जो इसे नित्य पढ़ता है, वह रोज़ाना अपने आपको देवी के अग्नि-कुंड में शुद्ध करता है।
            देवी की यह वाणी (सूक्त) साक्षात माँ का आलिंगन है, जो भक्त के सारे दुखों को मिटा देती है।
        """.trimIndent(),
        english = """
            (The Fruit of the Devi Sukta - Annihilation of Sins): This is the most critical segment of the Upanishad's conclusion, rendering it as powerful and fruitful as the 'Devi Sukta'.
            "O Devi! This wisdom You have imparted (Devi Suktam), is the absolute destroyer of all sins in the cosmos (Sarvapapapranashanam)."
            Studying or listening to this Upanishad is definitively not a mundane act; it is a lethal 'Laser' procedure designed to aggressively purge the filth residing within.
            Whoever injects this knowledge into his biology sees all karmic impressions (Karmic Impressions) of his sins violently incinerated to ashes.
            Sin is equivalent to 'Darkness'. This Devi Suktam aggressively floods that darkness with absolute, blinding Light.
            Grasping its profound meaning is the literal path to Moksha, because merely listening to it violently shatters the knots of the human mind.
            This is definitively not just a recitation; it is the literal 'Invocation' of the Goddess, which flawlessly purifies the seeker.
            He who reads this daily, constantly purifies himself in the Goddess's sacrificial fire.
            This utterance (Sukta) of the Goddess is the literal embrace of the Mother, which annihilates every single agony of the devotee.
        """.trimIndent()
    ),
    DeviShloka(
        id = 32,
        sanskrit = "इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥ ३२॥",
        hindi = """
            (उपनिषद की पूर्णता और परम शांति): यहाँ यह रहस्यमयी 'देवी उपनिषद' पूरी तरह से संपन्न होता है।
            "यह उपनिषद पूर्ण हुआ (इत्युपनिषत्)।"
            अंत में तीन बार 'ॐ शांति' का उच्चारण किया जाता है, जो ब्रह्मांड की तीन सबसे खौफनाक ताकतों को शांत करने के लिए है।
            पहली शांति: आधिभौतिक (दुनिया के लोगों, जानवरों और दुश्मनों से मिलने वाले बाहरी दुखों का अंत)।
            दूसरी शांति: आधिदैविक (ग्रहों, तूफानों, भूकंप और देवताओं के प्रकोप से मिलने वाले प्राकृतिक दुखों का अंत)।
            तीसरी शांति: आध्यात्मिक (अपने ही शरीर की बीमारियों और मन के भीतर उठने वाले डिप्रेशन और अहंकार रूपी दुखों का अंत)।
            जब इंसान यह जान लेता है कि "मैं साक्षात देवी हूँ", तो यह तीनों तरह के खौफनाक दुख हमेशा के लिए राख हो जाते हैं।
            उसके जीवन में एक ऐसी गहरी, सन्नाटे से भरी और अटल 'शांति' उतर आती है, जिसे मौत भी नहीं तोड़ सकती।
            यही सनातन धर्म का अंतिम रहस्य है, यही वेदों का शिखर है। ॐ! हर तरफ परम शांति हो!
        """.trimIndent(),
        english = """
            (The Completion of the Upanishad and Absolute Peace): Exactly here, this highly secretive, apocalyptic 'Devi Upanishad' achieves its absolute completion.
            "This Upanishad is now complete (Ityupanishat)."
            At the absolute climax, 'Om Shanti' is aggressively chanted exactly three times, designed as a lethal weapon to instantly pacify the three most terrifying forces of the cosmos.
            First Peace: Adhibhautika (the violent termination of all external agonies inflicted by humans, animals, enemies, and the physical matrix).
            Second Peace: Adhidaivika (the total annihilation of natural miseries caused by planetary wrath, devastating storms, earthquakes, and angry cosmic deities).
            Third Peace: Adhyatmika (the permanent slaughter of internal agony caused by biological diseases, psychological depression, and the vicious ego within).
            When a human irrevocably locks into the absolute realization "I am the Supreme Goddess," these three categories of horrific agony are instantaneously incinerated to ashes forever.
            A terrifyingly deep, deathly silent, unshakeable, and bottomless 'Peace' violently descends into his existence, which even biological death cannot fracture.
            This is the absolute final secret of Sanatana Dharma; this is the staggering, ultimate peak of the Vedas. OM! Let there be absolute, terrifying, supreme Peace everywhere!
        """.trimIndent()
    )
)