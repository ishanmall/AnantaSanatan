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
data class BahvrichaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BahvrichaUpanishadScreen() {
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
                // Range for Bahvricha Upanishad is 1..28
                if (shlokaNumber != null && shlokaNumber in 1..28) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-28)") },
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
            itemsIndexed(bahvrichaShlokasList) { _, shloka ->
                BahvrichaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun BahvrichaShlokaCard(shloka: BahvrichaShloka) {
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

// Complete List of All 28 Shlokas properly formatted
val bahvrichaShlokasList = listOf(
    BahvrichaShloka(
        id = 1,
        sanskrit = "ॐ देवि ह्येकाग्र आसीत् । सैव जगदण्डमसृजत । कामकलेति ज्ञायते शृङ्गारकलेति ज्ञायते ॥ १॥",
        hindi = """
            (परम सत्ता केवल देवी है): उपनिषदों के सबसे प्रलयंकारी और गुप्त ज्ञान का यह महा-आरंभ है।
            "सृष्टि की शुरुआत में, जब न समय था, न स्थान था और न ही शून्य था—तब केवल और केवल 'देवी' (परम शक्ति) ही अकेली विद्यमान थीं।"
            उस वक्त न तो ब्रह्मा थे, न विष्णु थे और न ही महेश (रुद्र) का कोई वजूद था; केवल एक अद्वैत, असीम मातृ-शक्ति का राज था।
            उसी महा-देवी ने अपने भीतर से इस पूरे 'ब्रह्मांडीय अंडे' (जगदण्ड - Cosmic Egg) को जन्म दिया।
            वह देवी कोई साधारण स्त्री या देवता नहीं है; वह साक्षात 'काम-कला' (सृष्टि को रचने वाली सर्वोच्च इच्छा) है।
            वही 'शृंगार-कला' है, जो इस पूरे ब्रह्मांड को सुंदरता, जीवन और आकर्षण से भर देती है।
            जब इंसान यह जान लेता है कि यह दुनिया किसी निर्जीव ऊर्जा से नहीं, बल्कि एक असीम, चेतन 'माँ' के गर्भ से निकली है...
            तो दुनिया को देखने का उसका पूरा नज़रिया हमेशा के लिए टूटकर एक नई आध्यात्मिक चमक में बदल जाता है।
            वह जान जाता है कि सृष्टि का हर कण उसी देवी की धड़कन है, और उसके अलावा ब्रह्मांड में कोई दूसरा सत्य है ही नहीं।
            यह श्लोक सनातन धर्म के शाक्त दर्शन की वह चोटी है, जहाँ भगवान को पिता नहीं, बल्कि परम सत्ता 'माँ' के रूप में देखा जाता है।
        """.trimIndent(),
        english = """
            (The Supreme Absolute is Exclusively the Goddess): This is the colossal, apocalyptic inception of the most classified wisdom in the Upanishads.
            "Before the violent explosion of creation, when neither time, nor space, nor even the void existed—strictly and exclusively, the 'Devi' (Supreme Cosmic Power) existed alone."
            In that absolute nothingness, there was no Brahma, no Vishnu, and absolutely no trace of Shiva (Rudra); only an infinite, non-dual Mother-Consciousness reigned supreme.
            That exact Supreme Goddess violently manifested this entire 'Cosmic Egg' (Jagadanda - the observable universe) directly from within Her own infinite womb.
            She is definitively not a mundane female deity; she is explicitly the literal 'Kama-Kala' (the Supreme, absolute primeval desire that triggers creation).
            She is the 'Shringara-Kala', the catastrophic force of attraction and beauty that violently floods this entire universe with biological and spiritual life.
            When a human irrevocably realizes that this physical matrix was not spawned by dead, mechanical energy, but birthed by a conscious, limitless 'Mother'...
            His entire psychological perception of reality shatters permanently, mutating into a blinding spiritual brilliance.
            He realizes every microscopic atom is literally throbbing with the Goddess's heartbeat, and absolutely no other truth exists.
            This verse is the terrifying zenith of Shakta philosophy, where the Ultimate God is realized not as a Father, but entirely as the Supreme Cosmic Mother.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 2,
        sanskrit = "तस्या एव ब्रह्मा अजीजनत् । विष्णुरजीजनत् । रुद्रोऽजीजनत् ।",
        hindi = """
            (त्रिमूर्ति की उत्पत्ति): यह श्लोक उन लोगों के अहंकार और अज्ञान पर एक खौफनाक प्रहार है, जो देवी को देवताओं से नीचा मानते हैं।
            "उसी एक, अकेली और असीम महा-देवी के अंश से साक्षात 'ब्रह्मा' (सृष्टि के रचयिता) का जन्म हुआ।"
            "उसी देवी की कोख से साक्षात 'विष्णु' (सृष्टि के पालनहार) उत्पन्न हुए।"
            "और उसी परम शक्ति ने साक्षात 'रुद्र' (सृष्टि का विनाश करने वाले शिव) को जन्म दिया।"
            यह ब्रह्मांड का सबसे बड़ा रहस्य है कि जिसे दुनिया भगवान (त्रिमूर्ति) मानकर पूजती है, वे तीनों भी उसी एक देवी के बच्चे हैं!
            देवी उनके नियंत्रण में नहीं है; बल्कि ब्रह्मा, विष्णु और महेश उसी देवी की आज्ञा से अपने-अपने कार्य करते हैं।
            अगर देवी अपनी शक्ति वापस खींच ले, तो ब्रह्मा कुछ रच नहीं सकते, विष्णु कुछ पाल नहीं सकते और शिव संहार नहीं कर सकते।
            वह देवी ही 'मूल-प्रकृति' (Root Nature) है, जिसके बिना बड़े से बड़ा देवता भी एक निर्जीव लाश (शव) के समान है।
            जो इस परम अद्वैत सत्य को जान लेता है, वह धर्म के छोटे-मोटे भेदों और देवताओं की तुलना करने के मायाजाल से आज़ाद हो जाता है।
            उसे समझ आ जाता है कि सारे देवता, सारे अवतार और सारे भगवान केवल उसी एक 'माँ' के अलग-अलग रूप और मुखौटे हैं।
        """.trimIndent(),
        english = """
            (The Genesis of the Trinity): This verse is a brutal, unforgivable strike against the toxic ignorance of those who demote the Goddess below male deities.
            "From the infinite essence of that exact singular, supreme Maha-Devi, Lord 'Brahma' (the Creator) was violently birthed."
            "From the cosmic womb of that very Goddess, Lord 'Vishnu' (the Preserver) was explicitly manifested."
            "And that exact Supreme Power literally spawned Lord 'Rudra' (Shiva - the Annihilator)."
            This is the most terrifying secret in the cosmos: the supreme Trinity worshipped by humanity are entirely the biological children of that ONE Goddess!
            She is absolutely not under their command; rather, Brahma, Vishnu, and Shiva operate their cosmic duties strictly under Her absolute, dictatorial orders.
            If the Goddess ruthlessly retracts Her power, Brahma cannot create an atom, Vishnu cannot preserve a breath, and Shiva becomes incapable of destruction.
            She is the literal 'Mula-Prakriti' (Root Nature); without Her, even the greatest God is reduced to an utterly paralyzed, dead corpse (Shava).
            He who completely grasps this supreme non-dual truth is violently liberated from the pathetic matrix of religious divisions and deity comparisons.
            He realizes that all cosmic gods, all avatars, and all divine entities are merely different masks worn by that single Supreme 'Mother'.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 3,
        sanskrit = "सर्वे मरुद्गणा अजीजनन् । गन्धर्वाप्सरसः किन्नरा वादित्रवादनः समन्तादजीजनन् ।",
        hindi = """
            (समस्त शक्तियों और लोकों की रचना): उपनिषद यहाँ देवी की असीम और खौफनाक रचनात्मक शक्ति (Creation Power) का विस्तार बताता है।
            "उसी देवी से हवाओं को चलाने वाले और तूफानों के स्वामी 'मरुद्गण' (४९ वायु देवता) पैदा हुए।"
            "स्वर्ग के गायक 'गंधर्व', सुंदरता की चरम सीमा 'अप्सराएं', और संगीत के उस्ताद 'किन्नर'—सब उसी से प्रकट हुए।"
            अंतरिक्ष में गूंजने वाली हर ध्वनि, हर वाद्य यंत्र (Music) की गूंज और ब्रह्मांड का पूरा संगीत उसी देवी के कंठ से फूटता है।
            सृष्टि में जो भी सुंदर है, जो भी भयंकर है, और जो भी जादुई है—वह सब उस एक माँ का ही खेल है।
            देवता कोई आसमान से टपके हुए अलग जीव नहीं हैं; वे उसी देवी की ऊर्जा के अलग-अलग रूप (Manifestations) हैं।
            जब इंसान इस ब्रह्मांडीय सच को अपनी नसों में महसूस करता है, तो उसे हर आवाज़ में देवी का ही मंत्र सुनाई देता है।
            हवा का चलना, बादलों का गरजना और पंछियों का गाना—यह सब कोई भौतिक घटना नहीं, बल्कि उस देवी की जीवित उपस्थिति है।
            वह इंसान फिर कभी दुनिया में अकेलापन महसूस नहीं करता, क्योंकि उसे हर दिशा में, हर कण में अपनी परम माँ दिखाई देती है।
            यह श्लोक सृष्टि को विज्ञान की नज़र से नहीं, बल्कि एक असीम चेतना (Consciousness) के विस्फ़ोट के रूप में देखने की ताक़त देता है।
        """.trimIndent(),
        english = """
            (The Creation of All Powers and Realms): The Upanishad here elaborates on the terrifying, boundless, and explosive creative power of the Goddess.
            "From Her alone, the 'Marudganas' (the 49 storm deities), masters of violent winds and cosmic tempests, were violently birthed."
            "The celestial musicians 'Gandharvas', the apex of lethal beauty 'Apsaras', and the masters of cosmic harmony 'Kinnaras'—all spawned explicitly from Her."
            Every single frequency echoing in deep space, every vibration of musical instruments, and the entire acoustic architecture of the universe erupt directly from Her throat.
            Whatever is mesmerizingly beautiful, whatever is catastrophically terrifying, and whatever is profoundly magical in creation—is entirely the divine play of that One Mother.
            Cosmic deities are not independent alien entities; they are strictly different wavelengths and manifestations of Her raw energy.
            When a human physically feels this cosmic truth throbbing in his veins, he literally hears the Goddess's secret mantra in every single worldly sound.
            The howling winds, the roaring thunder, and the singing birds are absolutely not dead physical phenomena, but the literal, living presence of the Goddess.
            That human permanently loses the pathetic biological feeling of loneliness, because he perceives his Supreme Mother in every direction and every microscopic atom.
            This verse violently forces humanity to perceive reality not as dead material science, but as a catastrophic, conscious explosion of Supreme Energy.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 4,
        sanskrit = "भोग्यमजीजनत् । सर्वमजीजनत् । सर्वं शक्तिमयं जगत् ॥ ४॥",
        hindi = """
            (सब कुछ देवी है - शक्तिवाद का महाघोष): यह श्लोक अद्वैत दर्शन का सबसे प्रलयंकारी और अंतिम सत्य है।
            "इस दुनिया में जो कुछ भी 'भोग्य' है (अर्थात जिसे खाया जा सकता है, देखा जा सकता है, या महसूस किया जा सकता है), वह सब देवी ने ही पैदा किया।"
            "यहाँ तक कि जो कुछ भी मौजूद है (सर्वमजीजनत्), वह सब उसी से निकला है।"
            "यह पूरा का पूरा विशाल और असीम ब्रह्मांड केवल और केवल 'शक्तिमय' (Energy Incarnate) है!"
            विज्ञान जिसे आज 'Energy' (ऊर्जा) कहता है, उपनिषद उसे हज़ारों साल पहले साक्षात 'शक्ति' (देवी) घोषित कर चुके हैं।
            मैटर (पदार्थ) और चेतना (Consciousness) अलग-अलग नहीं हैं; जो पत्थर है, वह भी शक्ति है, और जो दिमाग है, वह भी शक्ति है।
            अगर ब्रह्मांड का हर एक कण 'शक्तिमय' है, तो फिर पाप-पुण्य, अच्छा-बुरा, अपना-पराया सब उसी देवी का हिस्सा बन जाता है।
            जब यह ज्ञान इंसान के भीतर परमाणु बम की तरह फटता है, तो उसके सारे डर, नफरत और भ्रम हमेशा के लिए राख हो जाते हैं।
            वह जान जाता है कि न तो मारने वाला कोई दूसरा है, और न मरने वाला; यह दुनिया केवल एक देवी का अपने ही साथ खेला जा रहा खेल है।
            सच्चा योगी वही है जो दुनिया को माया या भ्रम कहकर कोसता नहीं, बल्कि उसे साक्षात 'माँ का स्वरूप' मानकर नमन करता है।
        """.trimIndent(),
        english = """
            (Everything is Goddess - The Grand Declaration of Shaktism): This verse is the most apocalyptic, ultimate absolute truth of Non-Dual philosophy.
            "Absolutely everything in this matrix that is 'Bhogya' (consumable, observable, or capable of being physically experienced) was violently birthed exclusively by the Goddess."
            "Literally 'Everything' (Sarvam) that exists, ever existed, or will exist, spawned directly from Her."
            "This entire colossal, boundless, terrifying universe is entirely and exclusively 'Shaktimaya' (The literal incarnation of Supreme Energy)!"
            What pathetic modern science identifies today merely as 'Energy', the Upanishads declared thousands of years ago as the living, conscious Goddess (Shakti).
            Matter and Consciousness are absolutely not separate; the dense physical stone is Shakti, and the biological human brain is also explicitly Shakti.
            If every single microscopic atom in the cosmos is 'Shaktimaya', then concepts of sin-merit, good-evil, self-other completely collapse into the Goddess.
            When this lethal knowledge detonates like an atomic bomb inside a human, all his biological fears, hatred, and illusions are permanently incinerated to dust.
            He realizes there is strictly no 'other' to kill, and no 'other' to die; this reality is entirely the Goddess playing a cosmic game exclusively with Herself.
            The true, terrifyingly awake Yogi does not curse the world as a pathetic illusion (Maya); he aggressively worships the physical world as the literal body of the Mother.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 5,
        sanskrit = "सैवाण्डजं स्वेदजमुद्भिज्जं जरायुजं यत्किञ्चैतत्प्राणिस्थाङ्गमजङ्गमं च ।",
        hindi = """
            (सभी योनियों में माँ का वास): उपनिषद यहाँ जीवन की हर एक छोटी और बड़ी योनि (Species) का रहस्य खोलता है।
            "अंडे से पैदा होने वाले (अण्डज) जीव जैसे पक्षी और सांप, उसी देवी का रूप हैं।"
            "पसीने और गंदगी से पैदा होने वाले (स्वेदज) जीव जैसे कीड़े और बैक्टीरिया, उसी देवी की ऊर्जा से पनपते हैं।"
            "ज़मीन फाड़कर निकलने वाले (उद्भिज्ज) पेड़-पौधे और जंगल, उसी देवी का विस्तार हैं।"
            "और गर्भ से पैदा होने वाले (जरायुज) इंसान और जानवर, सब के सब उसी परम मातृ-शक्ति से निकले हैं।"
            चाहे वह जीव चलता-फिरता (जङ्गम) हो, या पहाड़ और पेड़ों की तरह एक जगह स्थिर (स्थावर) हो—हर चीज़ साक्षात देवी है।
            दुनिया का सबसे बड़ा अज्ञान यह सोचना है कि भगवान केवल मंदिरों में या आसमान में कहीं छुप कर बैठा है।
            सच्चाई यह है कि तुम्हारे सामने खड़ा हर इंसान, तुम्हारे पैरों के नीचे की ज़मीन, और हवा में उड़ता हुआ कीड़ा भी साक्षात परमेश्वर (देवी) ही है।
            जब योगी इस भयानक और असीम सच को अपनी आँखों से देखने लगता है, तो वह किसी जीव से नफरत नहीं कर सकता।
            वह समझ जाता है कि किसी जानवर को सताना या किसी इंसान का दिल दुखाना सीधे ब्रह्मांड की माँ पर वार करना है।
            यह श्लोक इंसान की बुद्धि के चिथड़े उड़ा देता है और उसे हर जगह केवल 'एक ही शक्ति' को देखने के लिए मजबूर कर देता है।
        """.trimIndent(),
        english = """
            (The Mother Resides in All Species): The Upanishad forcefully rips open the terrifying secret behind every single microscopic and colossal species in existence.
            "Entities violently birthed from eggs (Andaja) like birds and reptiles, are the exact literal forms of the Goddess."
            "Creatures spawned from sweat and filth (Svedaja) like parasites and bacteria, aggressively thrive solely through Her energy."
            "Trees and colossal forests that rip through the earth to grow (Udbhijja), are the direct physical expansion of the Goddess."
            "And mammals/humans birthed from biological wombs (Jarayuja), all explicitly erupt from that exact Supreme Mother-Power."
            Whether a biological entity is highly mobile (Jangama), or paralyzed and static like a mountain or tree (Sthavara)—absolutely everything is explicitly the Goddess.
            The most catastrophic ignorance in the world is hallucinating that God is hiding pathetically in temples or sitting in the sky.
            The terrifying absolute reality is that the human standing before you, the dirt beneath your feet, and the insect flying in the air are exactly the Supreme God (Devi).
            When a master Yogi begins physically observing this horrifying, infinite truth with his bare eyes, he becomes biologically incapable of hatred.
            He realizes that torturing an animal or breaking a human heart is a direct, violent strike against the Mother of the Cosmos.
            This verse violently shreds human logic into pieces and forcefully compels the brain to perceive strictly 'One Power' everywhere.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 6,
        sanskrit = "तदियमेव सर्वं यदयं तदेतद्ब्रह्म तदेतदक्षरम् ।",
        hindi = """
            (वही अद्वैत परब्रह्म है): यहाँ देवी को उपनिषदों के सर्वोच्च लक्ष्य—'परब्रह्म' (The Absolute Reality) के रूप में स्थापित किया गया है।
            "यह जो कुछ भी विशाल और असीम संसार दिखाई दे रहा है, वह सब 'यही देवी' है। और जो यह देवी है, वही 'वह परब्रह्म' है।"
            "यह देवी ही वह 'अक्षर' (Imperishable) तत्व है, जिसका कभी नाश नहीं होता, जिसे कभी मिटाया नहीं जा सकता।"
            वेदांत में जिसे निराकार, निर्गुण और अनंत कहा गया है, शाक्त दर्शन उसी परम ऊर्जा को 'देवी' कहता है; नाम अलग हैं, सत्य एक है।
            इंसान पूरी ज़िंदगी भगवान को बाहर खोजता है, लेकिन यह श्लोक चीख कर कह रहा है कि जो दृश्य (दुनिया) है, वही द्रष्टा (भगवान) है!
            ब्रह्म कोई शून्य या खाली स्थान नहीं है; ब्रह्म यह धड़कता हुआ, सांस लेता हुआ, जीवित ब्रह्मांड है, जिसे देवी चला रही है।
            जब यह अद्वैत (Non-Duality) का ज्ञान इंसान के दिमाग में उतरता है, तो उसका 'छोटा मैं' (Ego) हमेशा के लिए मर जाता है।
            वह जान जाता है कि जिसे वह भगवान मानकर डर रहा था, वह कोई और नहीं, बल्कि ब्रह्मांड की सबसे कृपालु शक्ति (माँ) है।
            जो नाशवान (शरीर) है, उसके भीतर यह देवी ही विनाश-रहित (अक्षर) चेतना बनकर बैठी है।
            यहाँ इंसान और भगवान के बीच की दूरी का पर्दा हमेशा के लिए गिर जाता है; केवल सत्य शेष रहता है।
        """.trimIndent(),
        english = """
            (She is the Non-Dual Supreme Brahman): Here, the Goddess is violently and explicitly established as the ultimate apex target of all Upanishads—the 'Supreme Brahman'.
            "Absolutely everything that constitutes this colossal, boundless, visible matrix, is explicitly 'This Goddess'. And exactly what this Goddess is, is 'That Supreme Brahman'."
            "This Goddess is undeniably that 'Akshara' (The Imperishable Element), which absolutely cannot be destroyed, erased, or annihilated by any cosmic force."
            What Vedanta clinically describes as formless, attributeless, and infinite, Shakta philosophy violently recognizes as the exact same supreme energy—'The Devi'; the labels vary, the absolute truth is strictly one.
            Humans spend their pathetic lives frantically searching for God externally, but this verse screams that the exact visible matrix (Creation) is identical to the Creator!
            Brahman is definitively not a dead void or empty vacuum; Brahman is this violently throbbing, breathing, living universe aggressively operated by the Goddess.
            When this explosive knowledge of Non-Duality (Advaita) crashes into a human's brain, his pathetic 'tiny ego' starves to death permanently.
            He realizes that the exact entity he was terrified of as 'God', is explicitly none other than the most merciful, fiercely protective power (Mother) of the cosmos.
            Inside this rapidly decaying biological shell, it is this exact Goddess who sits securely as the indestructible (Akshara) consciousness.
            Here, the pathetic curtain of separation between the human and God collapses permanently; strictly the Absolute Truth remains.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 7,
        sanskrit = "तदेतत्प्राणस्तदेतत्पुंस्त्वं तदेतत्स्त्रीत्वं तदेतन्नपुंसकत्वम् ।",
        hindi = """
            (लिंग-भेद का विनाश): यह उपनिषदों की सबसे क्रांतिकारी और प्रलयंकारी घोषणा है, जो इंसान की छोटी सोच को जड़ से उखाड़ देती है।
            "वह देवी ही साक्षात 'प्राण' (Life-Force) है। वही देवी इस दुनिया में 'पुरुषत्व' (Masculinity) है।"
            "वही महा-देवी इस ब्रह्मांड में 'स्त्रीत्व' (Femininity) है, और वही देवी 'नपुंसकत्व' (Genderless/Neutral) भी है!"
            भगवान का कोई एक जेंडर (लिंग) नहीं होता। जिसे लोग पुरुष (शिव/विष्णु) मानकर पूजते हैं, वह भी देवी ही है।
            जिसे लोग स्त्री मानकर पूजते हैं, वह भी देवी है, और जो इन दोनों से परे है, वह भी उसी का रूप है।
            आत्मा का कोई लिंग नहीं होता; जो अज्ञानी इंसान भगवान को केवल पुरुष या केवल स्त्री मानता है, वह अभी अंधकार में जी रहा है।
            देवी वह परम चेतना (Consciousness) है जो पुरुष के शरीर में मर्द बनकर और स्त्री के शरीर में औरत बनकर खेल रही है।
            जब यह ज्ञान पैदा होता है, तो समाज के बनाए हुए लिंग-भेद (Gender Discrimination) और शारीरिक अहंकार हमेशा के लिए राख हो जाते हैं।
            इंसान यह समझ जाता है कि शरीर तो केवल एक कपड़े की तरह है; अंदर धड़कने वाला प्राण केवल और केवल उसी देवी की ऊर्जा है।
            सच्चा योगी पुरुष या स्त्री नहीं देखता; वह हर शरीर के भीतर सीधे उस असीम परब्रह्म को धड़कते हुए देखता है।
        """.trimIndent(),
        english = """
            (The Annihilation of Gender Dualism): This is the most radically revolutionary, catastrophic declaration of the Upanishads, designed to violently uproot microscopic human logic.
            "That exact Goddess is the literal 'Prana' (Supreme Life-Force). She exactly is the essence of 'Masculinity' (Pumstva) in this universe."
            "That exact Maha-Devi is explicitly the essence of 'Femininity' (Stritva), and She absolutely is the 'Neutral/Genderless' (Napumsakatva) state as well!"
            The Supreme God possesses absolutely no biological gender. The exact entity that humanity worships as male (Shiva/Vishnu) is literally the Goddess in disguise.
            What people worship as female is Her, and whatever transcends both categories is explicitly Her exact manifestation.
            The cosmic Soul has absolutely zero gender; the ignorant human who hallucinates God as strictly male or strictly female is currently existing in dark delusion.
            The Goddess is that supreme, terrifying Consciousness playing the game as a male inside a man's biology, and as a female inside a woman's biology.
            When this lethal knowledge violently awakens, all societal gender discrimination and biological arrogance are permanently incinerated to ash.
            The human explicitly realizes that the biological body is merely a cheap costume; the violently throbbing life-force inside is exclusively the Goddess's raw energy.
            A supreme Yogi absolutely never sees 'man' or 'woman'; his eyes violently pierce the flesh to observe the infinite Brahman directly throbbing inside every shell.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 8,
        sanskrit = "तदेतदहं तदेतद्वयं तदेतद्यूयं तदेतत्सर्वे ते तदेतत्सर्वास्ताः ।",
        hindi = """
            (मैं, तुम और सब कुछ वही है): यह श्लोक अद्वैत वेदांत की वह महा-गर्जना है, जहाँ दुनिया के सारे फासले शून्य हो जाते हैं।
            "वह परम देवी ही साक्षात 'मैं' (अहं - I) हूँ! वही देवी साक्षात 'हम' (वयं - We) हैं!"
            "वही देवी साक्षात 'तुम सब' (यूयं - You all) हो! वही देवी वे 'सभी पुरुष' (सर्वे ते) हैं!"
            "और वही महा-देवी वे 'सभी स्त्रियां' (सर्वास्ताः) हैं!"
            यह ब्रह्मांड का सबसे खौफनाक और प्रलयंकारी सत्य है—इस दुनिया में तुम्हारे अलावा कोई दूसरा इंसान है ही नहीं।
            जो मैं बोल रहा हूँ, वह भी देवी है; जो तुम सुन रहे par, वह भी देवी है; और जो भीड़ सड़क पर चल रही है, वह भी देवी है।
            यह 'मैं अलग हूँ और दुनिया अलग है' की सोच ही इंसान के दुख, डिप्रेशन और मौत के डर की सबसे बड़ी जड़ है।
            जब यह भ्रम परमाणु बम की तरह फट जाता है, तो इंसान को समझ आता है कि पूरा ब्रह्मांड केवल एक ही आत्मा (माँ) का विस्तार है।
            कोई किसी को कैसे धोखा दे सकता है? कोई किसी को कैसे मार सकता है? जब मारने वाला और मरने वाला दोनों एक ही हों!
            यह श्लोक इंसान के अहंकार को कुचलकर उसे पूरे ब्रह्मांड के साथ एक कर देता है; यही असली 'मोक्ष' है।
        """.trimIndent(),
        english = """
            (I, You, and Everything is Her): This verse is the deafening, cosmic roar of Non-Dual Vedanta, where absolutely all worldly distances collapse into dead zero.
            "That exact Supreme Goddess is literally 'I' (Aham)! That exact Goddess is undeniably 'We' (Vayam)!"
            "That exact Goddess is explicitly 'All of You' (Yuyam)! That Goddess is absolutely 'All those Men' (Sarve te)!"
            "And that exact Maha-Devi is unequivocally 'All those Women' (Sarvastah)!"
            This is the most terrifying, apocalyptic absolute truth in the cosmos—there is strictly no 'other' human being in existence besides Her.
            The entity speaking right now is the Goddess; the entity listening right now is the Goddess; the entire crowd walking on the streets is exactly the Goddess.
            The pathetic hallucination that 'I am separate and the world is separate' is the singular root cause of all human agony, clinical depression, and biological fear of death.
            When this toxic delusion detonates like an atomic bomb, the human irrevocably realizes the entire universe is strictly the violent expansion of ONE singular Soul (Mother).
            How can anyone betray anyone? How can anyone assassinate anyone? When the assassin and the victim are explicitly the exact same entity!
            This verse violently crushes the human ego into dust, forcing a flawless fusion with the entire cosmos; this is the literal definition of 'Moksha'.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 9,
        sanskrit = "यदेतत्किञ्च तत्सर्वं तदेतत्सत्यं तदेतद्विज्ञानं तदेतदानन्दम् ।",
        hindi = """
            (सत्य, विज्ञान और आनंद का महा-स्वरूप): उपनिषद यहाँ देवी के असली स्वरूप (Nature) की सबसे गहरी परिभाषा दे रहा है।
            "इस ब्रह्मांड में जो कुछ भी थोड़ा बहुत या असीम अस्तित्व रखता है, वह 'सब कुछ' (तत्सर्वं) केवल वही है।"
            "वही देवी साक्षात 'सत्य' (Absolute Truth) है, जो कभी बदलता नहीं, जो न पैदा होता है और न मरता है।"
            "वही देवी साक्षात 'विज्ञान' (Supreme Consciousness/Knowledge) है; दुनिया की सारी बुद्धि और ज्ञान उसी से निकलता है।"
            "और वही देवी साक्षात 'आनंद' (Infinite Bliss) है; दुनिया का सारा सुख केवल उसी के आनंद की एक छोटी सी बूँद है।"
            वेदांत में जिसे 'सच्चिदानंद' (सत्य-चित्त-आनंद) कहा जाता है, वह कोई निर्गुण शून्य नहीं, बल्कि यह जीवंत देवी ही है।
            इंसान दुनिया की चीज़ों में सुख (आनंद) ढूंढता है, लेकिन चीज़ें नष्ट हो जाती हैं और उसे दुख मिलता है।
            लेकिन जब वह अपनी चेतना (विज्ञान) को भीतर की ओर मोड़कर उस परम सत्य (सत्यम) माँ से जुड़ता है...
            तो उसके भीतर एक ऐसा खौफनाक और असीम आनंद फटता है, जिसे दुनिया का कोई दुख, कोई बीमारी या मौत भी नहीं छीन सकती।
            सच्चा योगी बाहर की दुनिया में नहीं भटकता, वह अपने ही भीतर की इस देवी (सच्चिदानंद) में डूबकर ब्रह्मांड का राजा बन जाता है।
        """.trimIndent(),
        english = """
            (The Grand Embodiment of Truth, Consciousness, and Bliss): The Upanishad here delivers the most profoundly terrifying definition of the Goddess's absolute core nature.
            "Whatever microscopic or colossal entity possesses even a trace of existence in this cosmos, 'Absolutely All of it' (Tat Sarvam) is strictly Her alone."
            "That exact Goddess is the literal 'Satyam' (Absolute Truth), which absolutely never mutates, is never born, and can never die."
            "That exact Goddess is explicitly 'Vijnanam' (Supreme Cosmic Consciousness); every single trace of intelligence and physics in reality erupts solely from Her."
            "And that exact Goddess is unequivocally 'Anandam' (Infinite, Bottomless Bliss); all worldly pleasure is merely a microscopic, pathetic drop of Her roaring bliss."
            What Vedanta clinically defines as 'Satchidananda' (Truth-Consciousness-Bliss) is definitively not a dead void, but this exact, violently alive Goddess.
            Humans pathetically hunt for pleasure (Ananda) in temporary material objects, but matter rots, guaranteeing agonizing pain.
            But when a human violently pivots his consciousness (Vijnanam) inward, violently crashing into that Absolute Truth (Satyam) Mother...
            A terrifying, boundless, apocalyptic Bliss detonates inside his biology, which no earthly tragedy, catastrophic disease, or death can ever steal.
            The authentic Yogi absolutely never wanders in the external matrix; he violently drowns in this internal Goddess (Satchidananda), claiming the absolute throne of the Universe.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 10,
        sanskrit = "तदेतद्ब्रह्मेत्युपदिदिशुः । सैषा भार्गवी वारुणी विद्या ।",
        hindi = """
            (यही ब्रह्म विद्या है): ऋषियों ने सदियों की घोर तपस्या के बाद जिस सत्य को खोजा, उसका ऐलान यहाँ किया गया है।
            "प्राचीन काल के महान ऋषियों और गुरुओं ने अपने शिष्यों को साफ़ शब्दों में यही उपदेश दिया है कि—'यही देवी परब्रह्म है'।"
            यह कोई साधारण पूजा-पाठ या मंत्र-तंत्र नहीं है; इसे वेदों में 'भार्गवी-वारुणी विद्या' (ब्रह्म को जानने की सर्वोच्च विद्या) कहा गया है।
            महर्षि भृगु ने वरुण देव (अपने पिता) से घोर तपस्या करके जो परम रहस्य जाना था, वह यही शाक्त-ज्ञान था।
            उन्होंने जाना कि अन्न, प्राण, मन, और विज्ञान सब ब्रह्म के रूप हैं, लेकिन अंत में 'आनंद' (देवी) ही सबसे बड़ा सत्य है।
            यह विद्या इंसान को अंधकार से खींचकर सीधे ब्रह्मांड के केंद्र में पटक देती है।
            जो इंसान इस विद्या को जान लेता है, उसे फिर कोई शास्त्र पढ़ने या बाहरी यज्ञ करने की आवश्यकता नहीं रह जाती।
            वह अपने ही शरीर को शिव मान लेता है और अपनी चेतना को देवी (शक्ति) मानकर परम अद्वैत में स्थापित हो जाता है।
            यह ज्ञान कोई ऐसी चीज़ जिसे किताबों से रटा जाए; यह एक मानसिक विस्फ़ोट है, जो इंसान की पुरानी पहचान को जलाकर राख कर देता है।
            यह श्लोक साबित करता है कि ब्रह्म और शक्ति में कोई अंतर नहीं; आग और उसकी गर्मी को कभी अलग नहीं किया जा सकता।
        """.trimIndent(),
        english = """
            (This Exactly is Brahma-Vidya): The absolute cosmic truth, ruthlessly extracted by ancient sages through centuries of terrifying penance, is explicitly declared here.
            "The supreme ancient masters and seers have violently, without any ambiguity, instructed their disciples thus—'This exact Goddess is the Supreme Brahman'."
            This is absolutely not a superficial ritual or cheap magical trick; the Vedas explicitly designate this as the 'Bhargavi-Varuni Vidya' (The ultimate, supreme science of realizing Brahman).
            The profound, classified secret that Maharishi Bhrigu violently extracted from Lord Varuna (his father) through agonizing meditation, was this exact Shakta-Wisdom.
            He ruthlessly pierced reality to discover that matter, vital breath, mind, and intellect are layers of Brahman, but ultimately, 'Ananda' (The Goddess/Bliss) is the final absolute truth.
            This lethal science forcefully drags a human out of the dark matrix, slamming him directly into the blinding center of the cosmos.
            The human who aggressively masters this exact Vidya absolutely never requires reading another scripture or performing external pathetic rituals ever again.
            He explicitly realizes his own physical body as Shiva, and his internal consciousness as the Goddess (Shakti), establishing himself permanently in supreme Non-Duality.
            This knowledge cannot be mechanically memorized from books; it is a violent psychological atomic explosion that permanently incinerates the human's old fake identity to ashes.
            This verse permanently proves there is zero difference between Brahman and Shakti; exactly as fire and its blazing heat can absolutely never be separated.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 11,
        sanskrit = "परमे व्योमन्प्रतिष्ठिता । य एतं वेद । स मृत्युमत्येति ।",
        hindi = """
            (परम आकाश में निवास और मृत्यु पर विजय): उपनिषद यहाँ उस स्थान का वर्णन करता है जहाँ यह देवी (ब्रह्म विद्या) निवास करती है।
            "यह महा-विद्या (देवी) उस 'परम व्योम' (Supreme Cosmic Void / हृदय के सबसे गहरे आकाश) में प्रतिष्ठित है।"
            यह देवी आसमान में बादलों के ऊपर नहीं बैठी है; यह तुम्हारे हृदय के भीतर मौजूद उस अनंत शून्यता (व्योम) में धड़क रही है।
            "जो भी परम साधक इस खौफनाक और असीम सत्य को जान लेता है (य एतं वेद)... वह साक्षात 'मृत्यु' को पार कर जाता है (मृत्युमत्येति)!"
            मौत केवल शरीर की होती है, प्राणों की होती है। लेकिन जब इंसान खुद को उस देवी (शक्ति) का ही रूप मान लेता है...
            तो मृत्यु उसका बाल भी बांका नहीं कर सकती, क्योंकि ऊर्जा (Energy/Shakti) को दुनिया की कोई ताक़त मार नहीं सकती।
            यह अद्वैत ज्ञान इंसान को मौत के डर से हमेशा के लिए आज़ाद कर देता है; वह जीते जी अमर हो जाता है।
            यमराज का डर केवल उन अज्ञानियों को लगता है जो खुद को हाड़-मांस का पुतला मानते हैं।
            जिसने अपने हृदय के इस 'परम आकाश' में देवी को देख लिया, उसके लिए मौत महज़ एक पुराना कपड़ा बदलने जैसी घटना रह जाती है।
            यह उपनिषदों की सबसे बड़ी गारंटी है—आत्म-ज्ञान ही मृत्यु पर अंतिम और स्थायी विजय है!
        """.trimIndent(),
        english = """
            (Residence in the Supreme Void and the Conquest of Death): The Upanishad here explicitly locates the exact dimensional coordinate where this Goddess (Brahma-Vidya) permanently resides.
            "This absolute Maha-Vidya (Goddess) is firmly established strictly in that 'Parama Vyoman' (The Supreme Cosmic Void / the deepest infinite space within the heart)."
            This Goddess is definitely not sitting pathetically on some clouds in the sky; She is violently throbbing right inside the boundless, terrifying emptiness (Void) of your own heart.
            "Absolutely any supreme seeker who flawlessly realizes this horrific, infinite truth (Ya etam veda)... literally and violently transcends 'Death' itself (Mrityumatyeti)!"
            Biological death only annihilates the physical shell and vital breath. But when a human explicitly identifies entirely as the exact manifestation of that Goddess (Shakti)...
            Death is rendered completely impotent against him, because absolutely no cosmic force in existence can kill or destroy raw Energy (Shakti).
            This lethal Non-Dual knowledge permanently liberates the human from the pathetic biological fear of death; he literally becomes immortal while still breathing.
            The terrifying Lord of Death (Yamaraja) only haunts the ignorant fools who hallucinate themselves as pathetic puppets of flesh and bone.
            He who has violently crashed into the Goddess inside this 'Supreme Cosmic Space' of his heart, treats physical death merely as the trivial act of discarding a rotting piece of clothing.
            This is the absolute, ultimate guarantee of the Upanishads—Supreme Self-Realization is the final, irrevocable, and violent conquest over Death!
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 12,
        sanskrit = "सैषा महात्रिपुरसुन्दरी । अभ्यान्तरबाह्यस्था सैव ।",
        hindi = """
            (महात्रिपुरसुंदरी ही सब कुछ है): अब उपनिषद उस असीम परम सत्ता का सबसे गुप्त और शक्तिशाली नाम उजागर करता है।
            "वह परम सत्य, वह परब्रह्म, वह मूल-प्रकृति कोई और नहीं, साक्षात 'महा-त्रिपुर-सुंदरी' (तीनों लोकों की सबसे परम सुंदर शक्ति) है!"
            त्रिपुर का अर्थ है—तीन लोक (स्वर्ग, पृथ्वी, पाताल), तीन शरीर (स्थूल, सूक्ष्म, कारण) और तीन अवस्थाएं (जाग्रत, स्वप्न, सुषुप्ति)।
            इन तीनों 'पुरों' (Cities/States) के भीतर रहने वाली और इन पर राज करने वाली एकमात्र चेतना ही महात्रिपुरसुंदरी है।
            "वह बाहर की भौतिक दुनिया (बाह्य) में भी मौजूद है, और वह इंसान के मन और आत्मा के भीतर (अभ्यांतर) भी पूरी तरह से स्थापित है।"
            कोई ऐसी जगह नहीं, कोई ऐसा कण नहीं जहाँ वह माँ मौजूद न हो; वह भीतर और बाहर एक समान रूप से फैली हुई है।
            लोग उसे मूर्तियों में खोजते हैं, लेकिन वह तो खून में दौड़ती हुई लालिमा और दिमाग में चमकती हुई बुद्धि बनकर बैठी है।
            जब यह रहस्य खुलता है, तो योगी को समझ आता है कि 'सुंदरता' केवल शरीर की नहीं होती; असली सुंदरता वह शक्ति है जो ब्रह्मांड को चला रही है।
            यह श्री-विद्या (Shri Vidya) का सबसे बड़ा मंत्र है। जो इसे समझ लेता है, उसके लिए यह ब्रह्मांड एक जेल नहीं, बल्कि माँ का भव्य महल बन जाता है।
            वह अपने ही शरीर को उस महात्रिपुरसुंदरी का सबसे पवित्र श्री-यंत्र (Shri Yantra) मानकर उसकी पूजा करने लगता है।
        """.trimIndent(),
        english = """
            (Maha-Tripura-Sundari is Absolute Everything): Now, the Upanishad violently unveils the most highly classified, lethal, and supreme name of that Absolute Reality.
            "That Absolute Truth, that Supreme Brahman, that Root-Nature is explicitly none other than 'Maha-Tripura-Sundari' (The Supreme, Absolute Beauty governing all three dimensions)!"
            'Tripura' literally designates—the three cosmic realms (Heaven, Earth, Underworld), the three biological/spiritual bodies (Gross, Subtle, Causal), and the three states of consciousness (Waking, Dreaming, Deep Sleep).
            The exclusive, absolute Consciousness that permanently resides within and dictatorially rules over these three 'Cities' (Puras) is Maha-Tripura-Sundari.
            "She is violently present in the external physical material matrix (Bahya), and She is flawlessly, entirely established deep inside the human mind and soul (Abhyantara)."
            There is absolutely zero space, not a single microscopic atom, where the Mother does not exist; She expands equally, boundlessly, inside and outside.
            Fools pathetically search for Her in stone idols, while She sits directly as the red heat racing in the blood and the blinding intelligence flashing in the brain.
            When this terrifying secret is unlocked, the Yogi realizes that 'Beauty' is not biological; true absolute beauty is the sheer raw power relentlessly operating the cosmos.
            This is the supreme apex declaration of 'Shri Vidya'. He who grasps this, no longer views the universe as a biological prison, but as the magnificent, colossal palace of the Mother.
            He explicitly begins worshipping his own biological body as the most hyper-sacred 'Shri Yantra' of that exact Maha-Tripura-Sundari.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 13,
        sanskrit = "सैव पञ्चकोशान्तरगुहायामास्ते । सैव जाग्रत्स्वप्नसुषुप्त्यवस्थासु ।",
        hindi = """
            (पाँचों कोशों और अवस्थाओं में देवी): यह श्लोक इंसान की शारीरिक और मानसिक संरचना को भेदकर भीतर बैठी देवी को दिखाता है।
            "वही महा-देवी इंसान के शरीर के पाँचों कोशों (अन्नमय, प्राणमय, मनोमय, विज्ञानमय और आनंदमय कोश) की सबसे गहरी गुफा में छिपी बैठी है।"
            शरीर (अन्न) से लेकर आत्मा के परम आनंद तक, हर परत (Layer) उसी देवी की ऊर्जा से बनी और चल रही है।
            "वही देवी इंसान के जाग्रत (जागने), स्वप्न (सपने देखने) और सुषुप्ति (गहरी, बिना सपने की नींद) की तीनों अवस्थाओं को कंट्रोल करती है।"
            जब तुम जाग रहे हो, तो दुनिया देखने वाली चेतना वह देवी ही है; जब तुम सपने देख रहे हो, तो सपनो का ब्रह्मांड रचने वाली शक्ति भी वही है।
            और जब तुम गहरी नींद में होते हो, जहाँ 'मैं' का नाम-ओ-निशान मिट जाता है, उस परम शांति और शून्यता में भी केवल वही देवी जाग रही होती है।
            इंसान यह सोचता है कि उसका दिमाग और शरीर उसका अपना है, लेकिन सच यह है कि वह केवल एक किराये का घर है जिसकी असली मालकिन यह देवी है।
            जो ध्यान के ज़रिए अपने पाँचों कोशों (Physical to Spiritual layers) को पार कर लेता है, उसे गुफा के अंत में असीम प्रकाश (देवी) के दर्शन होते हैं।
            यह एक ऐसा खौफनाक और प्रलयंकारी अनुभव है, जहाँ इंसान को पता चलता है कि उसका अपना कोई निजी वजूद था ही नहीं।
            सब कुछ उस परम माँ का ही एक भव्य और भयानक खेल (Play/Leela) है, जिसमें हम केवल कठपुतलियां हैं।
        """.trimIndent(),
        english = """
            (The Goddess in the Five Sheaths and All States): This verse violently pierces through the human biological and psychological architecture to expose the Goddess hiding deep inside.
            "That exact Maha-Devi sits flawlessly concealed in the absolute deepest, darkest cave of the human's Five Sheaths (Physical, Vital, Mental, Intellectual, and Bliss layers/Koshas)."
            From the gross physical flesh (Food sheath) straight down to the supreme bliss of the soul, every single microscopic layer is synthesized and operated strictly by Her energy.
            "That exact Goddess completely, dictatorially controls all three states of human existence: Waking (Jagrat), Dreaming (Svapna), and Deep, Dreamless Sleep (Sushupti)."
            When you are awake, the consciousness observing the matrix is Her; when you dream, the violent force synthesizing that dream-universe is explicitly Her.
            And when you crash into deep dreamless sleep, where the pathetic 'Ego' is utterly annihilated into nothingness, in that absolute terrifying silence and void, only She remains awake.
            Humans pathetically hallucinate that their brain and biology belong to them, but the horrifying truth is they are merely rented biological shells owned absolutely by this Goddess.
            He who aggressively pierces through his Five Koshas (Physical to Spiritual layers) via lethal Meditation, violently encounters the blinding infinite light (Goddess) at the end of the cave.
            This is a catastrophically terrifying, apocalyptic experience, where the human abruptly realizes he never actually possessed an independent personal existence.
            Absolutely everything is entirely a magnificent, horrifying cosmic Play (Leela) orchestrated by that Supreme Mother, in which we are merely biological puppets.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 14,
        sanskrit = "सैव तुरीया । सैव तुरीयातीता ।",
        hindi = """
            (तुरीय और उसके पार भी वही है): उपनिषद चेतना की सबसे ऊँची और अंतिम अवस्थाओं का रहस्य खोल रहा है।
            "तीनों अवस्थाओं (जागना, सोना, सपने देखना) के बाद जो चौथी और परम अवस्था 'तुरीय' (Turiya) है, वह साक्षात वही देवी है!"
            तुरीय वह अवस्था है जहाँ इंसान समाधि (Deepest Meditation) में होता है; जहाँ समय रुक जाता है, मन मर जाता है और केवल 'होने' (Existence) का एहसास बचता है।
            लेकिन बात यहीं खत्म नहीं होती! उपनिषद एक और बड़ा धमाका करता है—"वह देवी 'तुरीयातीत' (तुरीय अवस्था से भी परे) है!"
            तुरीयातीत वह अवस्था है जिसके बारे में इंसान का दिमाग कुछ सोच ही नहीं सकता, जिसके लिए कोई शब्द बने ही नहीं हैं।
            वह एक ऐसी असीम, खौफनाक और परम शून्यता है, जहाँ ब्रह्मांड भी एक धूल के कण से छोटा लगता है।
            देवी केवल हमारी चेतना (Consciousness) तक सीमित नहीं है; वह उस पार भी है जहाँ चेतना भी खत्म हो जाती है।
            ज्ञान की कोई ऐसी सीमा नहीं है जिसे देवी ने ना लांघा हो; वह हर रूप में है और हर रूप से आज़ाद (Formless) भी है।
            जब एक योगी तुरीयातीत अवस्था में पहुँचता है, तो उसका शरीर भले ही धरती पर हो, लेकिन उसकी आत्मा पूरे ब्रह्मांड को निगल चुकी होती है।
            यह श्लोक साबित करता है कि शाक्त दर्शन इंसान को ब्रह्मांड की सबसे चरम और परम ऊंचाई (Absolute Apex) तक ले जाता है।
        """.trimIndent(),
        english = """
            (She is Turiya and Beyond Turiya): The Upanishad is now violently tearing open the absolute highest, ultimate, unmapped states of pure consciousness.
            "Beyond the three mundane biological states (Waking, Dreaming, Sleeping), the fourth, absolute supreme state of 'Turiya' (The Witness/Samadhi), is explicitly that Goddess!"
            Turiya is the terrifying state where a human enters catastrophic Samadhi (Deepest Meditation); where Time abruptly stops, the Mind dies, and strictly pure 'Existence' remains.
            But the revelation absolutely does not stop there! The Upanishad drops an even more apocalyptic bomb—"That Goddess is literally 'Turiyatita' (Absolutely Beyond even the Turiya state)!"
            Turiyatita is the horrifying, unmapped, absolute dimension which the human biological brain is physically incapable of processing, for which absolutely zero vocabulary exists.
            It is an infinite, spine-chilling, absolute Supreme Void, where the entire colossal universe appears smaller than a microscopic speck of dust.
            The Goddess is definitely not restricted merely to our highest recognizable Consciousness; She reigns supremely in that absolute terrifying beyond where even consciousness ceases to exist.
            There is strictly zero limit or boundary of knowledge that the Goddess has not violently transcended; She embodies every form, yet is utterly, terrifyingly Formless.
            When a master Yogi crashes into this Turiyatita state, his physical shell may remain on Earth, but his soul has already violently swallowed the entire cosmos.
            This verse permanently proves that Shakta philosophy forcefully launches humanity into the absolute, terrifying, unmapped Apex of the entire cosmic architecture.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 15,
        sanskrit = "सैवाहमस्मीति भावयेत् । तदेतदद्वैतं यदेतद्विज्ञानं तदेतदानन्दम् ॥ १५॥",
        hindi = """
            (अहं ब्रह्मास्मि - मैं ही देवी हूँ): यह पंद्रहवां श्लोक पूरी भवृच उपनिषद का सबसे बड़ा आदेश (Command) और महावाक्य है।
            "हर साधक को अपने भीतर इस प्रलयंकारी सत्य की भावना (Meditation) करनी चाहिए कि—'वह परम देवी मैं स्वयं ही हूँ!' (सैवाहमस्मीति)।"
            यहाँ भगवान की भीख माँगने या उनके सामने रोने-गिड़गिड़ाने की कोई जगह नहीं है; यह सीधे भगवान का सिंहासन छीन लेने का मंत्र है!
            तुम्हें यह मानना होगा कि ब्रह्मांड को रचने वाली, पालने वाली और भस्म करने वाली वह महा-शक्ति कोई और नहीं, तुम्हारी अपनी आत्मा है।
            "यही परम 'अद्वैत' (Non-Duality) है! जहाँ दो नहीं बचते, जहाँ भगवान और भक्त का भेद हमेशा के लिए मिट जाता है।"
            जब यह भावना पक्की हो जाती है, तो वही साक्षात 'विज्ञान' (Supreme Cosmic Knowledge) बन जाती है।
            और अंततः, यह ज्ञान इंसान को उस 'आनंद' (Absolute Boundless Bliss) में डुबो देता है, जिसके बाद कोई दुख पास नहीं फटक सकता।
            जिस इंसान ने इस सत्य को अपनी रगों में उतार लिया, उसे दुनिया की कोई ताकत डरा नहीं सकती, कोई लालच डिगा नहीं सकता।
            वह इंसान नहीं रहता, वह चलता-फिरता परब्रह्म बन जाता है, और उसकी हर साँस से पूरी दुनिया का कल्याण होता है।
            यहीं आकर इंसान की सारी आध्यात्मिक खोज एक भयानक और असीम शांति (Peace) में विलीन हो जाती है।
        """.trimIndent(),
        english = """
            (Aham Brahmasmi - I Myself am the Goddess): This fifteenth verse is the absolute, ultimate, dictatorial cosmic Command (Mahavakya) of the entire Bahvricha Upanishad.
            "Every single supreme seeker must violently and aggressively force this apocalyptic realization into his biology through Meditation—'I Myself am explicitly that Supreme Goddess!' (Saivahamasmiti)."
            There is absolutely zero room here for pathetically begging God or crying in front of idols; this is the lethal mantra to directly seize the throne of the Almighty!
            You must ruthlessly accept that the colossal Maha-Shakti which creates, operates, and violently incinerates the cosmos is none other than your own exact Soul.
            "This exactly is the Supreme 'Advaita' (Non-Duality)! Where the illusion of 'two' collapses entirely, where the pathetic distance between God and devotee is permanently erased into dust."
            When this terrifying realization becomes biologically permanent, it literally mutates into 'Vijnanam' (The Absolute Supreme Cosmic Knowledge).
            And ultimately, this exact atomic knowledge forcefully drowns the human in that 'Anandam' (Absolute Boundless Bliss), after which no earthly agony dare approach him.
            The human who has injected this absolute truth into his veins can absolutely never be terrified by any cosmic force, nor destabilized by any biological greed.
            He entirely ceases to be human; he mutates into a walking, breathing, living Supreme Brahman, and every single breath he takes violently radiates welfare to the universe.
            Exactly at this threshold, all human spiritual seeking violently dissolves into a terrifying, infinite, and absolute cosmic Peace.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 16,
        sanskrit = "यदस्ति सन्मात्रम् । यद्विभाति चिन्मात्रम् ।",
        hindi = """
            (सत्ता और चेतना का महा-रहस्य): उपनिषद यहाँ ब्रह्मांड के अस्तित्व (Existence) का सबसे खौफनाक और प्रलयंकारी विश्लेषण कर रहा है।
            "इस असीम और अनंत ब्रह्मांड में जो कुछ भी 'अस्तित्व' में है (यदस्ति), वह केवल और केवल 'सन्मात्र' (Pure Absolute Being) है।"
            और वह सन्मात्र कोई शून्य या खाली ऊर्जा नहीं, बल्कि साक्षात उसी देवी (परम माँ) का भौतिक और आध्यात्मिक वजूद है।
            "और इस दुनिया में जो कुछ भी चमक रहा है, जो भी जाना जा सकता है, या जहाँ भी थोड़ी सी बुद्धि है, वह केवल 'चिन्मात्र' (Pure Consciousness) है।"
            विज्ञान जिसे पदार्थ (Matter) कहता है, वह देवी की 'सत्ता' (Existence) है; और जिसे चेतना (Consciousness) कहता है, वह देवी का 'ज्ञान' है।
            इसके बाहर, इस ब्रह्मांड में एक सुई की नोक के बराबर भी कोई ऐसी जगह नहीं है जहाँ देवी के अलावा कुछ और मौजूद हो।
            जब यह ज्ञान इंसान की नसों में उतरता है, तो उसे यह दुनिया पत्थरों और तारों से बनी मशीन नहीं लगती।
            उसे पूरा ब्रह्मांड एक जीवित, धड़कता हुआ और साँस लेता हुआ शरीर (देवी का स्वरूप) दिखाई देता है।
            मैं जो बोल रहा हूँ वह 'चिन्मात्र' (चेतना) है, और मेरा जो शरीर है वह 'सन्मात्र' (सत्ता) है—और ये दोनों केवल उसी माँ के हैं।
            यह अद्वैत दर्शन की वह परम चोटी है, जहाँ इंसान के अंदर का 'मैं' (Ego) हमेशा के लिए जलकर भस्म हो जाता है।
        """.trimIndent(),
        english = """
            (The Grand Secret of Existence and Consciousness): The Upanishad here executes the most terrifying, apocalyptic analysis of cosmic existence itself.
            "Absolutely whatever fundamentally exists in this boundless, infinite cosmos (Yadasti), is strictly and exclusively 'Sanmatram' (Pure Absolute Being)."
            And that Sanmatram is definitively not a dead void or blind mechanical energy, but the literal physical and spiritual existence of the Goddess (Supreme Mother) Herself.
            "And whatever radiates, shines, or possesses the microscopic capacity to perceive and know, is entirely 'Chinmatram' (Pure Absolute Consciousness)."
            What pathetic material science identifies as Matter, is explicitly the Goddess's raw 'Existence'; and what it calls Consciousness, is Her blinding 'Knowledge'.
            Beyond this, there is absolutely not a single millimeter of space, not even the tip of a needle, where anything other than the Goddess exists.
            When this lethal knowledge violently injects into a human's veins, he stops perceiving the universe as a dead machine made of rocks and burning gas.
            He physically observes the entire colossal matrix as a violently alive, throbbing, breathing, biological body of the Goddess.
            The entity speaking is 'Chinmatram' (Consciousness), and the physical shell acting is 'Sanmatram' (Matter)—and both belong exclusively to the Mother.
            This is the absolute supreme zenith of Non-Dual philosophy, where the pathetic human 'Ego' is permanently incinerated to ashes.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 17,
        sanskrit = "यत्प्रियमानन्दं तदेतत् पूर्वाकारा महात्रिपुरसुन्दरी ।",
        hindi = """
            (प्रेम और आनंद ही महात्रिपुरसुंदरी है): इंसान पूरी ज़िंदगी सुख, प्यार और आनंद के पीछे पागलों की तरह भागता है, लेकिन उपनिषद इसका स्रोत बता रहा है।
            "इस दुनिया में जो कुछ भी हमें सबसे ज़्यादा 'प्रिय' (Dear/Beloved) लगता है, और जिससे भी हमें ज़रा सा भी 'आनंद' (Bliss) मिलता है..."
            "वह कोई भौतिक वस्तु, इंसान या पैसा नहीं है! वह साक्षात 'महात्रिपुरसुंदरी' (देवी) का ही आदिकालीन (पूर्वाकारा) और परम स्वरूप है।"
            जब एक माँ अपने बच्चे को चूमती है, या जब इंसान को अपनी सफलता से खुशी मिलती है, तो वह खुशी उस वस्तु से नहीं आ रही होती।
            वह आनंद सीधे उस देवी की ऊर्जा का एक बहुत छोटा सा, सूक्ष्म रिसाव (Leak) है, जो इंसान के मन को छू जाता है।
            अज्ञानी इंसान चीज़ों में सुख ढूंढता है और जब चीज़ें टूटती हैं, तो वह डिप्रेशन और मौत के डर में घुटने लगता है।
            लेकिन योगी यह जान लेता है कि ब्रह्मांड की सारी सुंदरता, सारा प्रेम और सारा परमानंद केवल उस देवी की परछाई है।
            वह बाहरी चीज़ों (माया) को लात मारकर सीधे उस असीम आनंद के महासागर (महात्रिपुरसुंदरी) में छलांग लगा देता है।
            उसके बाद दुनिया का कोई भी लालच, कोई भी सुंदरता और कोई भी नशा उस योगी को अपनी ओर नहीं खींच सकता।
            क्योंकि जिसे साक्षात आनंद (Goddess of Bliss) मिल गई हो, वह मिट्टी के खिलौनों (दुनिया) से कभी नहीं खेलता।
        """.trimIndent(),
        english = """
            (Love and Bliss are Maha-Tripura-Sundari Herself): Humans spend their entire pathetic lives sprinting madly after pleasure, love, and happiness, but the Upanishad exposes the absolute source here.
            "Whatever entity or object is perceived as intensely 'Dear' (Priya) in this matrix, and whatever generates even a micro-drop of 'Ananda' (Supreme Bliss)..."
            "That is definitely not a dead material object, a human body, or wealth! It is explicitly the literal, primeval, absolute form (Purvakara) of 'Maha-Tripura-Sundari' Herself."
            When a mother kisses her child, or when a human derives pleasure from success, that joy is absolutely not originating from that temporary biological event.
            That bliss is a direct, microscopic leakage of the Goddess's blinding infinite energy temporarily touching the human mind.
            Ignorant fools hunt for pleasure in rotting material objects; when those objects inevitably shatter, they suffocate in catastrophic depression and biological fear.
            But the awake Yogi realizes that absolutely all cosmic beauty, all profound love, and all supreme ecstasy are merely the shadow of the Goddess.
            He violently kicks away external material illusions (Maya) and leaps directly into the bottomless ocean of absolute Bliss (Maha-Tripura-Sundari).
            After that atomic realization, absolutely no earthly greed, no biological beauty, and no material intoxication can ever drag him down.
            Because the sovereign King who has possessed the absolute Goddess of Bliss, never again plays with cheap, rotting mud toys of the world.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 18,
        sanskrit = "त्वं चाहं च सर्वं विश्वं सर्वदेवता इतरत् सर्वं महात्रिपुरसुन्दरी ।",
        hindi = """
            (मैं, तुम और ब्रह्मांड केवल देवी हैं): यह श्लोक अद्वैत दर्शन की वह महा-गर्जना है, जहाँ दुनिया के सारे फासले शून्य हो जाते हैं।
            "हे साधक! 'तुम' (त्वं), 'मैं' (अहं), यह 'पूरा का पूरा ब्रह्मांड' (सर्वं विश्वं), 'सभी देवता' (सर्वदेवता)..."
            "और इनके अलावा ब्रह्मांड में जो कुछ भी है (इतरत् सर्वं), वह सब केवल और केवल साक्षात 'महात्रिपुरसुंदरी' ही है।"
            यह कोई कविता नहीं, यह ब्रह्मांड का सबसे खौफनाक और प्रलयंकारी सत्य है—इस दुनिया में तुम्हारे अलावा कोई दूसरा इंसान है ही नहीं!
            जो मैं बोल रहा हूँ, वह देवी है; जो तुम सुन रहे हो, वह देवी है; जो देवता आसमान में हैं, वह भी उसी माँ के मुखौटे हैं।
            यह 'मैं अलग हूँ और दुनिया अलग है' की सोच ही इंसान के दुख, डिप्रेशन और मौत के डर की सबसे बड़ी जड़ है।
            जब यह भ्रम परमाणु बम की तरह फट जाता है, तो इंसान को समझ आता है कि पूरा ब्रह्मांड केवल एक ही आत्मा (माँ) का विस्तार है।
            कोई किसी को कैसे धोखा दे सकता है? कोई किसी को कैसे मार सकता है? जब मारने वाला और मरने वाला दोनों एक ही हों!
            यह श्लोक इंसान के 'छूटे अहंकार' को बेरहमी से कुचलकर उसे पूरे ब्रह्मांड के साथ एक कर देता है।
            यही असली 'मोक्ष' है; जब दूसरा कोई बचता ही नहीं, तो डर किसका?
        """.trimIndent(),
        english = """
            (I, You, and the Universe are Solely the Goddess): This verse is the deafening, cosmic roar of Non-Dual Vedanta, where absolutely all worldly distances collapse into dead zero.
            "O Seeker! 'You' (Tvam), 'I' (Aham), this 'entire colossal Universe' (Sarvam Vishvam), 'all cosmic deities' (Sarvadevata)..."
            "And absolutely everything else in existence beyond this (Itarat Sarvam), is strictly, violently, and exclusively the literal 'Maha-Tripura-Sundari'."
            This is definitively not poetry; it is the most terrifying, apocalyptic absolute truth in the cosmos—there is strictly no 'other' human being in existence besides Her!
            The entity speaking is the Goddess; the entity listening is the Goddess; the supreme gods in heaven are merely different masks worn by that exact Mother.
            The pathetic hallucination that 'I am separate and the world is separate' is the singular, toxic root cause of all human agony, clinical depression, and fear of death.
            When this toxic delusion detonates like an atomic bomb, the human irrevocably realizes the entire universe is strictly the violent expansion of ONE singular Soul.
            How can anyone betray anyone? How can anyone assassinate anyone? When the assassin and the victim are explicitly the exact same entity!
            This verse violently and mercilessly crushes the pathetic human ego into dust, forcing a flawless fusion with the entire cosmic architecture.
            This is the literal definition of 'Moksha'; when absolutely no 'other' survives, who is left to fear?
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 19,
        sanskrit = "सत्यमेकं ललिताख्यं वस्तु तदद्वितीयमखण्डार्थं परं ब्रह्म ॥",
        hindi = """
            (ललिता ही एकमात्र परब्रह्म है): उपनिषद अब दुनिया के सारे भ्रमों को काटकर उस परम शक्ति का असली और सबसे रहस्यमयी नाम उजागर करता है।
            "इस असीम और अनंत ब्रह्मांड में केवल एक ही परम सत्य है, जिसे 'ललिता' (ललिता महात्रिपुरसुंदरी) कहा जाता है।"
            यह दुनिया जो हर पल बदलती है, मरती है और टूटती है, वह झूठ (माया) है; केवल ललिता ही एकमात्र अटल सत्य (वस्तु) है।
            "वही ललिता वह 'अद्वितीय' (जिसका कोई दूसरा नहीं), 'अखंड' (जिसे कभी तोड़ा या बाँटा नहीं जा सकता) और सर्वोच्च 'परब्रह्म' है।"
            लोग सोचते हैं कि ब्रह्म कोई निर्गुण, बिना आकार वाला और सन्नाटे से भरा शून्य है; यह उनकी सबसे बड़ी भूल है।
            उपनिषद यहाँ चीख कर कह रहा है कि वह परब्रह्म कोई शून्य नहीं, बल्कि यह असीम सुंदरता, प्रेम और शक्ति से भरी देवी 'ललिता' है।
            देवताओं की पूजा करने से इंसान स्वर्ग तक जा सकता है, लेकिन ललिता को जान लेने से वह खुद साक्षात भगवान बन जाता है।
            जिसके भीतर यह अखंड ज्ञान पैदा हो गया, उसके मन में अब देवताओं और भगवान को लेकर कोई उलझन (Confusion) नहीं रहती।
            वह जान जाता है कि चाहे राम कहो, शिव कहो या कृष्ण—वह सब केवल उस परम ललिता के ही अलग-अलग नाम और खेल हैं।
            यह श्लोक सनातन धर्म के शाक्त दर्शन का वह ब्रह्मास्त्र है, जिसके आगे दुनिया के सारे दार्शनिक विचार घुटने टेक देते हैं।
        """.trimIndent(),
        english = """
            (Lalita is the Sole Supreme Brahman): The Upanishad now violently slaughters all cosmic illusions and unveils the truest, most classified name of that Supreme Power.
            "In this infinite, terrifying cosmos, there exists strictly only ONE absolute Truth, universally designated as 'Lalita' (The Supreme Beautiful Goddess Maha-Tripura-Sundari)."
            This physical matrix that constantly mutates, decays, and dies is a pathetic lie (Maya); Lalita alone is the sole unshakeable, eternal Truth (Vastu).
            "That exact Lalita is the 'Non-Dual' (Without a second), 'Unbreakable' (Indivisible), and the ultimate absolute 'Supreme Brahman'."
            Ignorant fools hallucinate that Brahman is merely an attributeless, formless, dead void filled with silence; this is a catastrophic error.
            The Upanishad screams here that the Supreme Brahman is definitively not a void, but this violently alive Goddess 'Lalita', overflowing with infinite beauty, love, and raw power.
            Worshipping lesser deities can merely grant a human temporary heaven, but realizing Lalita literally forces the human to mutate into the Almighty God Himself.
            He whose biology has been penetrated by this unbroken cosmic knowledge, permanently loses all psychological confusion regarding gods and religions.
            He realizes that whether you chant Rama, Shiva, or Krishna—they are entirely just different names and localized plays of that Supreme Lalita.
            This verse is the absolute nuclear weapon (Brahmastra) of Shakta philosophy, forcing all other pathetic philosophical theories to violently drop to their knees.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 20,
        sanskrit = "पञ्चरूपपरित्यागा दर्वरूपप्रहाणतः ।",
        hindi = """
            (पाँचों कोशों और सभी रूपों का विनाश): ज्ञान की इस परम अवस्था तक पहुँचने का खौफनाक और प्रलयंकारी रास्ता इस श्लोक में बताया गया है।
            "जब इंसान ध्यान के प्रहार से अपने पाँचों नकली शरीरों (अन्नमय, प्राणमय, मनोमय, विज्ञानमय और आनंदमय कोश) का पूरी तरह परित्याग (विनाश) कर देता है..."
            इंसान खुद को शरीर, साँस, या दिमाग मानकर जी रहा है; यह पाँचों परतें (रूप) केवल आत्मा को कैद करने वाली एक जेल हैं।
            "और जब वह इस दुनिया के सभी भौतिक आकारों, चेहरों, और बनावटों (सर्वरूप) के भ्रम को अपनी चेतना से पूरी तरह भस्म (प्रहाण) कर देता है..."
            कोई भी आकार (Form) सत्य नहीं है, क्योंकि हर आकार मौत के बाद मिट्टी में मिल जाता है।
            जब तक इंसान आकारों (सुंदरता, पैसा, शरीर) से चिपका हुआ है, वह परम शक्ति को कभी नहीं देख सकता।
            सच्चा योगी अपनी आँखों से दुनिया के सभी रूपों को मिटा देता है; वह पत्थर में पत्थर नहीं, और इंसान में इंसान नहीं देखता।
            वह अपने मन के भीतर एक ऐसा भयानक सन्नाटा और वैराग्य पैदा करता है, जहाँ ब्रह्मांड की कोई भी भौतिक चीज़ उसे लुभा नहीं सकती।
            पाँचों कोशों की यह मौत कोई आत्महत्या नहीं है; यह 'देहाध्यास' (Ego of the body) की सबसे क्रूर और हिंसक हत्या है।
            जब यह कचरा जलकर राख होता है, तभी इंसान के भीतर वह परम प्रकाश (ब्रह्म) अपनी पूरी ताक़त से फटता है।
        """.trimIndent(),
        english = """
            (The Annihilation of the Five Sheaths and All Forms): The terrifying, apocalyptic path to reach this supreme state of knowledge is explicitly detailed in this verse.
            "When a human, through the violent strike of lethal Meditation, completely abandons and incinerates his five fake biological/spiritual bodies (The Physical, Vital, Mental, Intellectual, and Bliss Koshas)..."
            Humans pathetically exist hallucinating themselves as a body, breath, or mind; these five layers (forms) are strictly a biological prison locking away the soul.
            "And when he brutally slaughters and burns the illusion of all physical forms, faces, and material structures (Sarvarupa) in the matrix entirely from his consciousness..."
            Absolutely no physical form is true, because every single form rots and disintegrates into dirt after biological death.
            As long as a human remains pathetically attached to physical forms (beauty, wealth, flesh), he can never, ever witness the Supreme Power.
            The true, awake Yogi permanently erases all worldly forms from his vision; he does not see a stone in a stone, nor a human in a human.
            He synthesizes such a terrifying, deathly silence and detachment within his brain that absolutely no physical object in the cosmos can tempt him.
            This biological death of the five sheaths is definitively not physical suicide; it is the most brutal, merciless assassination of 'Dehadhyasa' (Physical Ego).
            Only when this biological garbage is burnt to ashes, does that Supreme Light (Brahman) detonate with absolute nuclear force within the human.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 21,
        sanskrit = "अधिष्ठानं परं तत्त्वमेकं सच्छिष्यते महत् ॥",
        hindi = """
            (केवल एक परम सत्य शेष रहता है): पिछले श्लोक में जो प्रलयंकारी विनाश हुआ, उसके बाद क्या बचता है, यह श्लोक उसका उत्तर है।
            "...तब इन सभी नकली पर्दों, शरीरों और दुनिया के सारे आकारों के जल जाने के बाद, केवल और केवल एक ही असीम तत्त्व (Supreme Reality) शेष बचता है।"
            वह जो बचता है, वह कोई शून्य (Zero/Void) नहीं है, बल्कि वह इस पूरे ब्रह्मांड का 'अधिष्ठान' (Foundation/Base) है।
            जिस तरह पर्दे पर फिल्म चलती है, लेकिन फिल्म खत्म होने पर केवल सफेद पर्दा बचता है, वैसे ही यह दुनिया मिटने पर केवल वह देवी बचती है।
            यह 'महत' (Colossal/Supreme) तत्त्व इतना विशाल है कि पूरा ब्रह्मांड इसके एक छोटे से बाल के बराबर भी नहीं है।
            जब योगी के मन में दुनिया मर जाती है, तो उसे यह अधिष्ठान साक्षात दिखाई देता है।
            उसे पता चलता है कि वह हवा में नहीं लटक रहा था; उसका और पूरे ब्रह्मांड का असली आधार केवल वह 'परम तत्त्व' (ललिता) ही है।
            यह वह स्थिति है जहाँ मौत भी आकर खड़ी हो जाए, तो योगी हँसते हुए उसे भगा देता है।
            क्योंकि जो चीज़ (शरीर) मर सकती थी, उसे तो उसने पहले ही योग की आग में जलाकर राख कर दिया है!
            अब वह केवल वह 'अधिष्ठान' बनकर अमर हो गया है, जिसे न कोई आग जला सकती है, न कोई हथियार काट सकता है।
        """.trimIndent(),
        english = """
            (Only One Supreme Truth Remains): After the apocalyptic annihilation executed in the previous verse, this verse dictates exactly what survives.
            "...Then, after all these fake biological curtains, physical bodies, and worldly structures are violently burnt to ashes, strictly only one infinite, colossal Reality (Tattva) survives."
            That which remains is definitively not a dead Zero or empty Void; it is the absolute, unshakeable 'Adhishthana' (Foundation/Base) of the entire cosmos.
            Exactly as an entire movie plays out on a screen, but when the film ends only the solid white screen remains, when this matrix is erased, solely the Goddess remains.
            This 'Mahat' (Colossal/Supreme) element is so terrifyingly massive that the entire observable universe doesn't equal even a microscopic hair on it.
            When the physical world dies violently inside the Yogi's mind, he physically perceives this Adhishthana in its absolute raw form.
            He realizes he was never hanging aimlessly in space; his absolute, unbreakable foundation, and that of the cosmos, is exclusively that 'Supreme Element' (Lalita).
            This is the terrifying dimensional state where even if Death personified stands before him, the Yogi laughs and violently dismisses it.
            Because whatever biological shell could be killed, he has already ruthlessly incinerated it to dust in the fire of Yoga!
            He has now permanently mutated into that exact 'Adhishthana', rendering him instantly immortal; no fire can burn him, no weapon can ever cut him.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 22,
        sanskrit = "प्रज्ञानं ब्रह्मेति वा अहं ब्रह्मास्मीति वा भाष्यते ।",
        hindi = """
            (महावाक्यों की असली परिभाषा): उपनिषद अब वेदों के सबसे शक्तिशाली मंत्रों (महावाक्यों) का असली और खौफनाक रहस्य खोल रहा है।
            "वेदों में जो यह बार-बार कहा गया है कि 'प्रज्ञानं ब्रह्म' (परम चेतना ही साक्षात भगवान है)..."
            "या यह जो सबसे बड़ी गर्जना की गई है कि 'अहं ब्रह्मास्मि' (मैं ही साक्षात परब्रह्म हूँ)..."
            यह कोई किताबी ज्ञान, दार्शनिक विचार या ऋषियों की कोई अच्छी कविता नहीं है!
            जब वेद यह सब बोलते (भाष्यते) हैं, तो वे असल में सीधे-सीधे उसी परम देवी (ललिता महात्रिपुरसुंदरी) का साक्षात वर्णन कर रहे होते हैं।
            अज्ञानी लोग 'अहं ब्रह्मास्मि' का मतलब केवल एक खाली आत्मा से निकालते हैं, लेकिन शाक्त दर्शन कहता है कि तुम्हारा 'अहं' (मैं) साक्षात देवी की धड़कन है।
            जब इंसान पूरी ताक़त से यह महसूस करता है कि 'मैं ब्रह्म हूँ', तो वह असल में अपने भीतर सोई हुई उस ब्रह्मांडीय देवी (कुण्डलिनी) को जगा रहा होता है।
            यह श्लोक इंसान के दिमाग में एक बम की तरह गिरता है, जो यह साबित करता है कि वेदों का परम लक्ष्य कोई निर्गुण पुरुष नहीं, बल्कि यह असीम शक्ति (माँ) है।
            तुम्हारे दिमाग के भीतर जो 'प्रज्ञान' (बुद्धि/Understanding) है, वह तुम्हारा नहीं है; वह सीधे उस देवी का एक हिस्सा है।
            जब यह ज्ञान सिद्ध हो जाता है, तो इंसान खुद एक चलता-फिरता वेद बन जाता है।
        """.trimIndent(),
        english = """
            (The Authentic Definition of the Great Directives): The Upanishad now violently unlocks the true, terrifying secret behind the most powerful mantras (Mahavakyas) of the Vedas.
            "When the Vedas repeatedly and aggressively declare 'Prajnanam Brahma' (Supreme Consciousness is literally the Almighty God)..."
            "Or when they unleash the most colossal cosmic roar: 'Aham Brahmasmi' (I exactly am the Supreme Brahman)..."
            These are absolutely not academic knowledge, philosophical theories, or pretty poetry written by ancient seers!
            When the Vedas dictate (Bhashyate) these laws, they are explicitly and directly describing the literal physical and spiritual form of that exact Supreme Goddess (Lalita Maha-Tripura-Sundari).
            Ignorant fools interpret 'Aham Brahmasmi' merely as a dead, empty soul, but Shakta philosophy screams that your 'Aham' (I-ness) is the literal heartbeat of the Goddess.
            When a human forcefully realizes with absolute violence that 'I am Brahman', he is actively detonating and awakening the cosmic Goddess (Kundalini) sleeping within him.
            This verse drops like an atomic bomb into the human brain, permanently proving that the ultimate target of the Vedas is not a formless male entity, but this Infinite Power (Mother).
            The 'Prajnana' (Intelligence/Understanding) flashing inside your brain is absolutely not yours; it is a direct, live wire connected to the Goddess.
            When this lethal knowledge is perfectly mastered, the human literally mutates into a walking, breathing Veda.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 23,
        sanskrit = "तत्त्वमसीत्येव संभाष्यते । अयमात्मा ब्रह्मेति वा ब्रह्मैवाहमस्मीति वा ॥",
        hindi = """
            (तत्त्वमसि और आत्मा ही ब्रह्म है): वेदों के बाकी बचे हुए महावाक्यों को भी उपनिषद यहाँ देवी के चरणों में लाकर रख देता है।
            "और जब गुरु शिष्य की आँखों में आँखें डालकर यह खौफनाक उपदेश देता है कि 'तत्त्वमसि' (तुम साक्षात वही परब्रह्म हो)..."
            "या जब उपनिषद यह रहस्य खोलते हैं कि 'अयमात्मा ब्रह्म' (यह शरीर में मौजूद आत्मा ही पूरा का पूरा ब्रह्म है)..."
            "या जब योगी समाधि में चीख उठता है कि 'ब्रह्मैवाहमस्मीति' (ब्रह्म के अलावा मैं और कुछ हूँ ही नहीं!)..."
            यह सब भी केवल और केवल उसी 'महात्रिपुरसुंदरी' की सत्ता का ऐलान है!
            उपनिषद यहाँ इंसान के 'मैं' (Ego) को जड़ से उखाड़ कर फेंक रहा है; तुम एक मामूली इंसान नहीं हो, तुम साक्षात परब्रह्म (देवी) की ही एक लहर हो।
            जब तक तुम खुद को एक छोटा सा जीव मानते हो, तुम पाप-पुण्य और स्वर्ग-नरक के चक्कर में पिसते रहोगे।
            लेकिन जैसे ही तुम 'तत्त्वमसि' की इस गर्जना को अपनी रगों में उतार लेते हो, मौत और जन्म का सारा खेल एक सेकंड में रुक जाता है।
            तुम्हारी यह आत्मा कोई छोटा सा प्रकाश नहीं है; यह ब्रह्मांड के सारे सूर्यों से भी ज़्यादा विशाल है।
            भगवान आसमान में नहीं बैठा है, वह तुम्हारी हर साँस में 'मैं' बनकर धड़क रहा है।
            यही वो ज्ञान है जिसे पा लेने के बाद भगवान की पूजा खत्म हो जाती है, और इंसान खुद भगवान की कुर्सी पर बैठ जाता है।
        """.trimIndent(),
        english = """
            (Tat Tvam Asi and the Soul is Brahman): The Upanishad violently drags the remaining cosmic directives (Mahavakyas) of the Vedas and slams them at the feet of the Goddess.
            "And when the Supreme Master looks directly into the disciple's eyes and issues the terrifying command 'Tat Tvam Asi' (You are exactly That Supreme Brahman)..."
            "Or when the Upanishads violently rip open the secret 'Ayam Atma Brahma' (This exact Soul locked in the body is the entire Brahman)..."
            "Or when the Yogi in cataclysmic Samadhi screams 'Brahmaivahamasmiti' (I am absolutely nothing else but Brahman!)..."
            All of these are strictly and exclusively the absolute declaration of the authority of that exact 'Maha-Tripura-Sundari'!
            The Upanishad is brutally uprooting the human 'I' (Ego) from its foundation; you are definitively not a pathetic mundane human, you are a lethal cosmic wave of the Goddess Herself.
            As long as you pathetically hallucinate yourself as a tiny creature, you will be violently crushed in the matrix of sin-merit and heaven-hell.
            But the microsecond you inject the atomic roar of 'Tat Tvam Asi' into your veins, the entire pathetic game of birth and death violently halts.
            Your soul is definitely not a tiny spark of light; it is infinitely more colossal and terrifying than all the suns in the cosmos combined.
            God is absolutely not sitting on a cloud; He is throbbing violently as the 'I' in every single breath you take.
            This is the ultimate knowledge where the worship of God terminates, and the human violently seizes the throne of God for himself.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 24,
        sanskrit = "योऽहमस्मीति वा सोहमस्मीति वा योऽसौ सोऽहमस्मीति वा या भाव्यते ।",
        hindi = """
            (सोऽहं का महा-ध्यान): यह श्लोक योग और ध्यान (Meditation) की उस सबसे खौफनाक और प्रलयंकारी चोटी का वर्णन करता है।
            "ध्यान की उस भयानक और अंतिम अवस्था में, जहाँ साधक अपने मन को चीरकर यह परम भावना (Meditation) करता है..."
            "कि 'जो मैं हूँ, वही वह परम सत्ता है' (योऽहमस्मीति), या 'वह परब्रह्म साक्षात मैं ही हूँ' (सोऽहमस्मीति)..."
            "या यह कि 'जो वह दूर बैठा ब्रह्मांड का रचयिता है, वह कोई और नहीं, बल्कि वह साक्षात मैं स्वयं ही हूँ' (योऽसौ सोऽहमस्मीति)..."
            यह कोई साधारण ध्यान नहीं है; यह एक मानसिक परमाणु बम है जो इंसान के दिमाग की सारी पुरानी संरचना (Programming) को उड़ा देता है।
            जब यह ध्यान ('भाव्यते') अपनी चरम सीमा पर पहुँचता है, तो इंसान का शरीर काँपने लगता है और उसकी चेतना शरीर से बाहर फैल जाती है।
            वह देखता है कि भगवान और उसके बीच का जो पर्दा था, वह एक बहुत बड़ा झूठ था।
            कोई दूसरा है ही नहीं! यह पूरा ब्रह्मांड उसी साधक के भीतर समा जाता है।
            यह 'सोऽहं' (मैं वह हूँ) का मंत्र इंसानियत का सबसे बड़ा हथियार है, जो सीधे ईश्वरत्व (Godhood) का दरवाज़ा तोड़ देता है।
            इस भावना के बिना किए गए सारे कर्मकांड, सारे उपवास और सारे यज्ञ केवल राख में फूंके गए साँसों के समान व्यर्थ हैं।
        """.trimIndent(),
        english = """
            (The Supreme Meditation of So'ham): This verse violently describes the most terrifying, apocalyptic, and ultimate peak of Yoga and Meditation.
            "In that absolute, horrifying climax of Meditation, where the seeker violently rips through his mind to lock into this supreme realization..."
            "That 'Whatever I fundamentally am, That exact entity is the Supreme Power' (Yo'hamasmiti), or 'I am explicitly That Supreme Brahman' (So'hamasmiti)..."
            "Or that 'Whoever that distant Creator of the cosmos is, He is absolutely none other than I Myself' (Yo'asau So'hamasmiti)..."
            This is definitively not an ordinary meditation; it is a psychological atomic bomb that permanently incinerates all old biological programming in the human brain.
            When this lethal meditation ('Bhavyate') hits its terrifying absolute peak, the human biological shell trembles violently, and his consciousness explodes out of the body.
            He physically observes that the pathetic curtain separating him from God was a catastrophic, toxic lie.
            There is strictly no 'Other'! The entire colossal universe violently collapses directly into the soul of that exact seeker.
            This roaring mantra of 'So'ham' (I am That) is humanity's most lethal weapon, designed to violently shatter the gates of direct Godhood.
            Without this apocalyptic realization, all external rituals, all starving fasts, and all religious sacrifices are utterly useless, like blowing breath into dead ashes.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 25,
        sanskrit = "सैषा षोडशी श्रीविद्या पञ्चदशाक्षरी श्रीमहात्रिपुरसुन्दरी ।",
        hindi = """
            (यही श्रीविद्या और महात्रिपुरसुंदरी है): जब साधक 'सोऽहं' की परम स्थिति में पहुँच जाता है, तो उसे असली मंत्र (विद्या) का दर्शन होता है।
            "...यह जो अद्वैत की परम भावना और ज्ञान है, वही साक्षात 'श्रीविद्या' (ब्रह्मांड का सबसे गुप्त, मारक और शक्तिशाली तंत्र) है!"
            "यही ज्ञान पंद्रह अक्षरों (पंचदशाक्षरी - क ए ई ल ह्रीं...) और सोलह अक्षरों (षोडशी) वाले महामंत्र की साक्षात 'श्रीमहात्रिपुरसुंदरी' है।"
            लोग श्रीविद्या को केवल एक मंत्र मानकर किताबों में खोजते हैं या उसे जपने से अमीर बनने के सपने देखते हैं।
            उपनिषद यहाँ चीख कर कह रहा है कि असली श्रीविद्या कोई शब्द या कागज़ पर लिखा मंत्र नहीं है; यह इंसान का 'ब्रह्म-ज्ञान' (Self-Realization) है!
            जब 'मैं' और 'ब्रह्म' एक हो जाते हैं, तो इंसान का शरीर ही साक्षात श्री-यंत्र बन जाता है, और उसकी साँसें ही श्रीविद्या का मंत्र बन जाती हैं।
            महात्रिपुरसुंदरी कोई आसमान से उतरने वाली औरत नहीं है; वह यह परम चेतना है जो इस ब्रह्मांड को अपनी इच्छा से चला रही है।
            जिसके भीतर यह विद्या (ज्ञान) जाग जाती है, वह त्रिलोकी (तीनों लोकों) का राजा बन जाता है।
            देवता भी ऐसे ज्ञानी इंसान के सामने हाथ जोड़कर खड़े रहते हैं, क्योंकि वह इंसान साक्षात उस परम माँ का जीवित स्वरूप बन चुका होता है।
            सनातन धर्म में श्रीविद्या से बड़ा, इससे रहस्यमयी और इससे ज़्यादा ताक़तवर कोई दूसरा मार्ग पूरे ब्रह्मांड में नहीं है।
        """.trimIndent(),
        english = """
            (This Exactly is Shri Vidya and Maha-Tripura-Sundari): When the seeker crashes violently into the absolute state of 'So'ham', the true Mantra (Vidya) reveals itself.
            "...This exact apocalyptic realization and supreme knowledge of Non-Duality is literally the 'Shri Vidya' (The most classified, lethal, and powerful Tantra in the cosmos)!"
            "This exact blinding knowledge is the literal 'Shri-Maha-Tripura-Sundari' of the fifteen-syllabled (Panchadashakshari - Ka E I La Hrim...) and sixteen-syllabled (Shodashi) supreme mantra."
            Ignorant fools hunt for Shri Vidya in paper books merely as a spell, or hallucinate about becoming wealthy by mechanically chanting it.
            The Upanishad screams here that authentic Shri Vidya is absolutely not a written word or sound; it is the literal 'Self-Realization' (Brahma-Jnana) of the human!
            When the 'I' and 'Brahman' violently fuse into one, the human biological shell mutates directly into the Shri-Yantra, and his mechanical breaths become the literal mantra of Shri Vidya.
            Maha-Tripura-Sundari is definitely not a woman descending from the sky; She is this exact Supreme Consciousness dictating the cosmos by Her sheer will.
            He inside whom this Vidya (Atomic Knowledge) violently awakens, instantaneously becomes the absolute Emperor of the three dimensions (Triloki).
            Even the highest cosmic deities stand paralyzed with folded hands before such an enlightened human, because he has literally mutated into the living, breathing form of that Supreme Mother.
            In all of Sanatana Dharma, there is absolutely no path in the entire cosmos more massive, more secretive, and more lethal than the Shri Vidya.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 26,
        sanskrit = "बालांबिकेति बगलेति वा मातंगीति स्वयंवरकल्याणीति भुवनेश्वरीति चामुण्डेति चण्डेति वाराहीति तिरस्करिणीति राजमातंगीति वा ।",
        hindi = """
            (सभी देवियाँ उसी के रूप हैं - भाग १): अब उपनिषद एक-एक करके दुनिया की सारी शक्तियों को उसी एक माँ के चरणों में लाकर मिला देता है।
            "वही एक असीम शक्ति साक्षात 'बालांबिका' (नौ साल की मासूम लेकिन अजेय बच्ची) का रूप है।"
            "वही 'बगलामुखी' है (जो दुश्मनों की जीभ खींचकर उन्हें लकवा मार देती है)। वही 'मातंगी' (ज्ञान और संगीत की परम देवी) है।"
            "वही 'स्वयंवरकल्याणी' है और वही पूरे ब्रह्मांड पर राज करने वाली 'भुवनेश्वरी' (तीनों लोकों की महारानी) है।"
            "वही युद्ध के मैदान में राक्षसों का खून पीने वाली खौफनाक 'चामुंडा' है, और वही प्रचंड क्रोध से भरी 'चंडी' है, जिसके नाम से मौत भी काँपती है।"
            "वही सूअर के मुख वाली प्रलयंकारी 'वाराही' है, जो दुश्मनों को ज़मीन में गाड़ देती है। वही माया का पर्दा डालने वाली 'तिरस्करिणी' और 'राजमातंगी' भी है।"
            यह श्लोक इंसान के दिमाग को फाड़ देता है कि दुनिया में जितनी भी देवियाँ हैं—चाहे वह सुंदर हों या खून से लथपथ—वह सब केवल एक ही हैं!
            भगवान केवल शांत और मुस्कुराता हुआ नहीं होता; जब वह पापियों का संहार करता है, तो वह चंडी और चामुंडा जैसी भयंकर और खौफनाक शक्ति बन जाता है।
            सच्चा साधक देवी के सुंदर और मारक, दोनों रूपों को एक समान प्यार करता है, क्योंकि वह जानता है कि यह सब उसी माँ का खेल है।
        """.trimIndent(),
        english = """
            (All Goddesses are Her Manifestations - Part 1): Now, the Upanishad violently drags every single cosmic power in existence and dissolves them directly at the feet of that One Mother.
            "That single infinite Power is literally 'Balambika' (The innocent but completely invincible nine-year-old child form)."
            "She is exactly 'Bagalamukhi' (The lethal force that rips out enemies' tongues and paralyzes them). She is 'Matangi' (The supreme Goddess of radical wisdom and cosmic music)."
            "She is exactly 'Svayamvarakalyani' and the absolute 'Bhuvaneshvari' (The sovereign Empress dictatorially ruling all three dimensions of the cosmos)."
            "She is the terrifying, demon-blood drinking 'Chamunda' on the battlefield, and She is the violently wrathful 'Chandi', whose very name causes Death itself to tremble."
            "She is the apocalyptic, boar-faced 'Varahi' who ruthlessly buries enemies into the dirt. She is explicitly 'Tiraskarini' (the weaver of the impenetrable illusion) and 'Rajamatangi'."
            This verse violently shreds the human brain, proving that absolutely every Goddess in existence—whether mesmerizingly beautiful or drenched in blood—is strictly ONE entity!
            God is definitely not always peaceful and smiling; when annihilating toxic sinners, God mutates into the horrifying, blood-curdling forms of Chandi and Chamunda.
            A true, awake seeker loves both the beautiful and the lethal forms of the Goddess absolutely equally, for he realizes it is entirely the cosmic play of that exact Mother.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 27,
        sanskrit = "शुकश्यामलेति वा लघुश्यामलेति वा अश्वारूढेति वा प्रत्यंगिरा धूमावती सावित्री गायत्री सरस्वती ब्रह्मानन्दकलेति ॥",
        hindi = """
            (सभी देवियाँ उसी के रूप हैं - भाग २): उपनिषद यहाँ देवियों की सूची को पूरा करते हुए उस परम शक्ति के सबसे रहस्यमयी रूपों का ऐलान करता है।
            "वही माँ 'शुकश्यामला' और 'लघुश्यामला' है, और वही घोड़ों की सेना पर सवार होकर युद्ध करने वाली अजेय 'अश्वारूढ़ा' है।"
            "तंत्र की सबसे खौफनाक, मारक और उल्टे मंत्रों को नष्ट करने वाली शक्ति 'प्रत्यंगिरा' (शेर के मुख वाली) भी साक्षात वही महात्रिपुरसुंदरी है।"
            "श्मशान में बैठने वाली, कौवों वाले रथ पर सवार विधवा रूप 'धूमावती' भी वही है, जो दुनिया के विनाश (प्रलय) का प्रतीक है।"
            "और जो वेदों की साक्षात माता हैं—'सावित्री' और 'गायत्री', और जो असीम ज्ञान की स्रोत 'सरस्वती' हैं, वह भी केवल उसी देवी के अलग-अलग मुखौटे हैं।"
            "अंततः, वह देवी केवल एक मूर्ति या देवता नहीं है, वह साक्षात 'ब्रह्मानंदकला' (परब्रह्म के असीम और अनंत आनंद की जीवित मूर्ति) है।"
            जो इंसान यह जान लेता है कि गायत्री मंत्र की शांति और प्रत्यंगिरा मंत्र की मारक शक्ति, दोनों एक ही स्रोत से निकल रही हैं...
            उसका धर्म को लेकर सारा भ्रम और पाखंड टूट जाता है।
            वह जान जाता है कि यह ब्रह्मांड एक सिक्का है; इसके एक तरफ जीवन (सरस्वती/गायत्री) है और दूसरी तरफ मौत (धूमावती/प्रत्यंगिरा)—और यह सिक्का केवल माँ का है।
            यही शाक्त दर्शन का परम अद्वैत है, जहाँ सृजन (Creation) और विनाश (Destruction) दोनों को गले लगाया जाता है।
        """.trimIndent(),
        english = """
            (All Goddesses are Her Manifestations - Part 2): Concluding the explosive roster of Goddesses, the Upanishad declares the most highly classified forms of that Supreme Power.
            "That exact Mother is 'Shukashyamala' and 'Laghushyamala', and She is explicitly the invincible cavalry-commander charging into war, 'Ashvarudha'."
            "The most terrifying, lethal, and destructive force in Tantra that violently obliterates black magic, 'Pratyangira' (The lion-faced Goddess), is literally that exact Maha-Tripura-Sundari."
            "The terrifying widow-form 'Dhumavati', sitting in the cremation grounds on a chariot of crows, representing absolute cosmic annihilation, is also Her."
            "And the literal Mothers of the Vedas—'Savitri' and 'Gayatri', along with the infinite source of all cosmic wisdom, 'Saraswati', are merely different masks worn by Her."
            "Ultimately, She is definitively not a mere stone idol or a local deity; She is explicitly 'Brahmanandakala' (The living, breathing incarnation of the Supreme Brahman's infinite bliss)."
            The human who realizes that the supreme peace of the Gayatri mantra and the lethal strike of the Pratyangira mantra erupt from the exact same source...
            Has his entire religious confusion and hypocrisy violently shattered into dust.
            He realizes the universe is a coin; one side is Life (Saraswati) and the other is violent Death (Dhumavati)—and this coin belongs exclusively to the Mother.
            This is the absolute Non-Duality of Shakta philosophy, where both catastrophic Creation and apocalyptic Destruction are embraced with equal ferocity.
        """.trimIndent()
    ),
    BahvrichaShloka(
        id = 28,
        sanskrit = "ऋचो अक्षरे परमे व्योमन् । यस्मिन् देवा अधि विश्वे निषेदुः । यस्तन्न वेद किं ऋचा करिष्यति। य इत्तद्विदुस्त इमे समासते। इत्युपनिषत् ॥",
        hindi = """
            (वेदों का अंतिम निष्कर्ष और चुनौती): यह भवृच उपनिषद का अंतिम श्लोक है, जो ऋग्वेद का एक महामंत्र है और अज्ञानियों के मुँह पर एक तमाचा है।
            "ऋग्वेद के सारे पवित्र मंत्र (ऋचाएं) उसी 'अक्षर' (अविनाशी) और 'परम आकाश' (उस देवी रूपी शून्यता) में निवास करते हैं।"
            "उसी परम देवी के असीम आकाश में ब्रह्मांड के सारे देवता छुपकर (निषेदुः) बैठे हुए हैं; देवी के बिना उनका कोई वजूद नहीं।"
            "जो मूर्ख और अज्ञानी इंसान उस असीम देवी (सत्य) को नहीं जानता, वह वेदों की ऋचाएं (मंत्र) पढ़कर क्या उखाड़ लेगा? (किं ऋचा करिष्यति)।"
            बिना आत्म-ज्ञान के अगर कोई पूरी ज़िंदगी वेद रट ले या मंदिर में घंटी बजाता रहे, तो वह केवल एक गधा है जो किताबों का बोझ ढो रहा है!
            "लेकिन जो परम योगी उस देवी (परम सत्य) को अपने भीतर जान लेते हैं (य इत्तद्विदुस्त)... वे इसी जीवन में पूर्णता प्राप्त करके हमेशा के लिए परब्रह्म में स्थापित हो जाते हैं (समासते)!"
            धर्म का मतलब किताबें पढ़ना नहीं है, धर्म का मतलब उस परम शक्ति को अपनी नसों में महसूस करना है।
            जिसने यह जान लिया, उसे फिर कुछ और जानने की ज़रूरत नहीं; वह मौत को जीतकर साक्षात ब्रह्मांड का राजा बन जाता है।
            यहीं पर यह रोंगटे खड़े कर देने वाला, प्रलयंकारी और सत्य से भरा 'भवृच उपनिषद' पूर्ण रूप से समाप्त होता है। ॐ शांति!
        """.trimIndent(),
        english = """
            (The Ultimate Conclusion and Challenge of the Vedas): This is the absolute final verse of the Bahvricha Upanishad, a colossal mantra from the Rigveda, acting as a brutal slap to the face of ignorant fools.
            "Absolutely all the sacred mantras (Richas) of the Rigveda reside permanently in that 'Imperishable' (Akshara) 'Supreme Cosmic Space' (The terrifying Void that is the Goddess)."
            "Exactly within the infinite cosmic space of that Supreme Goddess, all the deities of the universe sit completely concealed (Nisheduh); without Her, they possess zero existence."
            "What pathetic, microscopic use are the Vedic hymns to a blind fool who does not physically realize that Infinite Goddess? (Kim richa karishyati)."
            If a human mechanically memorizes the Vedas for his entire life without Self-Realization, he is merely a pathetic donkey carrying a heavy load of paper books!
            "But those supreme master Yogis who violently realize Her within their own biology (Ya ittadvidusta)... instantly achieve absolute perfection and seize their permanent throne in the Supreme Brahman! (Samasate)."
            Authentic religion is definitely not reading paper books; religion is the violent, physical realization of that Supreme Power detonating in your veins.
            He who has realized this, absolutely never requires knowing anything else; he slaughters Death and mutates into the absolute Emperor of the Cosmos.
            Right exactly here concludes this spine-chilling, apocalyptic, and profoundly terrifying 'Bahvricha Upanishad'. OM Peace!
        """.trimIndent()
    )
)