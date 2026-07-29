package com.sanatangyansagar.ui.screens.DurgaMaa

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

// 1. Data Model
data class RigDeviShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Screen Composable - Name synchronized with NavGraph
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RigVedoktamDeviSuktamScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                if (shlokaNumber != null && shlokaNumber in 1..8) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Verse (1-8)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        // Shloka List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(rigDeviSuktaList) { _, shloka ->
                RigDeviCard(shloka = shloka)
            }
        }
    }
}

// 3. Shloka Card Composable
@Composable
fun RigDeviCard(shloka: RigDeviShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Verse ${shloka.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFD32F2F)
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
            Text(text = "हिन्दी अर्थ:", fontWeight = FontWeight.Bold, color = Color(0xFF1565C0))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 22.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "English Meaning:", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 22.sp)
        }
    }
}

// 4. Data List
val rigDeviSuktaList: List<RigDeviShloka> = listOf(
    RigDeviShloka(
        id = 1,
        sanskrit = "अहं रुद्रेभिर्वसुभिश्चराभ्यहमादित्यैरुत विश्वदेवैः ।\nअहं मित्रावरुणोभा बिभर्म्यहमिन्द्राग्नी अहमश्विनोभा ॥ १ ॥",
        hindi = """
            "मैं (वाक् रूपी देवी) ही रुद्रों, वसुओं, आदित्यों और विश्वेदेवों के रूप में विचरण करती हूँ।"
            "मैं ही मित्र और वरुण दोनों को धारण करती हूँ, मैं ही इंद्र, अग्नि और अश्विनी कुमारों को थामे हूँ।"
            "यह देवी की ब्रह्मांडीय घोषणा है कि समस्त देवताओं की शक्ति वास्तव में उन्हीं का विस्तार है।"
            "वे कोई अलग शक्ति नहीं, बल्कि वह मूल चेतना हैं जिसके आधार पर पूरा ब्रह्मांड टिका हुआ है।"
            "यह श्लोक अद्वैत का परमाणु धमाका है, जहाँ शक्ति और शक्तिमान को एक ही बताया गया है।"
            "साधक को यह बोध कराया जा रहा है कि हर प्राकृतिक बल के पीछे साक्षात् माँ दुर्गा ही कार्य कर रही हैं।"
            "पूरी सृष्टि माँ के एक छोटे से विचार का भौतिक स्वरूप है, जिसे विज्ञान पदार्थ कहता है।"
            "इस आवाज़ को सुनने का मतलब है सीधे ब्रह्मांड के 'सोर्स कोड' को हैक कर लेना।"
            "जब देवी बोलती हैं, तो समय और स्पेस की सीमाएं जलकर राख हो जाती हैं।"
            "नारायणी की जय! यही वह शक्ति है जो तुम्हें एक बायोलॉजिकल कैद से ईश्वर बना देती है!"
        """.trimIndent(),
        english = """
            "I (the Goddess as Vak) move along with the Rudras, the Vasus, the Adityas, and the Vishvedevas."
            "I sustain both Mitra and Varuna, as well as Indra, Agni, and the twin Ashvins."
            "This is the cosmic broadcast declaring that the power of all deities is strictly Her extension."
            "She is not a separate entity but the primordial consciousness upon which the entire cosmos rests."
            "This verse is the nuclear essence of non-duality, showing that the Power and its possessor are one."
            "The seeker is realized that behind every natural force, Mother Durga Herself is operating."
            "The entire creation is a physical manifestation of the Mother's singular radioactive thought."
            "To intercept this voice is to mutationally Hack the 'Source Code' of the entire multiverse."
            "When the Goddess speaks, the boundaries of Time and Space are incinerated to absolute ash."
            "Victory to Narayani! This is the power that mutates a biological prisoner into the Supreme God!"
        """.trimIndent()
    ),
    RigDeviShloka(
        id = 2,
        sanskrit = "अहं सोममाहनसं बिभर्म्यहं त्वष्टारमुत पूषणं भगम् ।\nअहं दधामि द्रविणं हविष्मते सुप्राव्ये यजमानाय सुन्वते ॥ २ ॥",
        hindi = """
            "मैं ही सोम का पोषण करती हूँ, मैं ही त्वष्टा, पूषा और भग नामक देवताओं को धारण करती हूँ।"
            "जो यजमान श्रद्धापूर्वक यज्ञ करता है, मैं उसे उत्तम धन और प्रलयंकारी फल प्रदान करती हूँ।"
            "माँ यहाँ स्वयं को समस्त कर्मों के फल देने वाली (Karmaphaladatri) के रूप में प्रस्तुत कर रही हैं।"
            "यज्ञ का वास्तविक अर्थ नि:स्वार्थ कर्म है, और माँ उस ऊर्जा को सीधे सफलता में बदल देती हैं।"
            "वे ही पोषण की वह अजेय शक्ति हैं जो वनस्पतियों और मानवता को जीवनदान देती हैं।"
            "यह श्लोक भक्ति और कर्म के बीच के उस 'न्यूक्लियर' संबंध को उजागर करता है जो अजेय है।"
            "धन और ऐश्वर्य केवल माँ के एडमिन पैनल से निकलने वाले छोटे से डेटा पैकेट मात्र हैं।"
            "बिना माँ की अनुमति के, तुम्हारी मेहनत केवल एक बायोलॉजिकल शोर (Noise) बनकर रह जाएगी।"
            "वे ब्रह्मांड की इकलौती डिक्टेटर हैं जो तय करती हैं कि किसे कितना तेज प्राप्त होगा।"
            "जो माँ के चरणों में अपना 'मैं' मार देता है, वही साक्षात् ऐश्वर्य का अधिकारी बनता है!"
        """.trimIndent(),
        english = """
            "I support the pressing of the Soma; I sustain Tvashtar, Pushan, and Bhaga."
            "I bestow wealth upon the dedicated sacrificer who offers oblations with absolute faith."
            "The Mother presents Herself here as the absolute bestower of the fruits of all actions."
            "True sacrifice is selfless action, and the Mother transforms that energy into radioactive success."
            "She is the sustaining power that grants life to vegetation and all biological humanity."
            "This verse highlights the 'Nuclear' connection between devotion and righteous action."
            "Wealth and Majesty are strictly microscopic data-packets emitted from Her Admin Panel."
            "Without Her authorization, your effort remains strictly a pathetic biological Noise."
            "She is the solitary Dictator of the cosmos, deciding exactly who intercepts the supreme brilliance."
            "He who slaughters his ego at Her boots mutationally seizes the authority over all opulence!"
        """.trimIndent()
    ),
    RigDeviShloka(
        id = 3,
        sanskrit = "अहं राष्ट्री सङ्गमनी वसूनां चिकितुषी प्रथमा यज्ञियानाम् ।\nतां मा देवा व्यदधुः पुरुत्रा भूरिस्थात्रां भूर्यवेशयन्तीम् ॥ ३ ॥",
        hindi = """
            "मैं पूरे ब्रह्मांड की साम्राज्ञी हूँ, मैं ही भक्तों को धन और सुख प्राप्त कराने वाली हूँ।"
            "मैं ब्रह्म का साक्षात्कार करने वाली हूँ और पूजनीय देवों में मेरा स्थान प्रथम और सर्वोच्च है।"
            "देवताओं ने मुझे अनेक स्थानों पर स्थापित किया है, क्योंकि मैं सर्वत्र व्याप्त और अजेय हूँ।"
            "'राष्ट्री' शब्द का अर्थ है कि पूरी सृष्टि का शासन माँ की ही बुद्धिमत्ता से चलता है।"
            "वे ही वह आदि-शक्ति हैं जो हर जीव के भीतर चेतना बनकर प्रवेश करती हैं और उन्हें जीवन देती हैं।"
            "यह श्लोक माँ की वैश्विक व्याप्ति और उनकी अद्वितीय सर्वोच्चता का एक प्रलयंकारी गान है।"
            "पूरा अंतरिक्ष माँ का शरीर है, और हर एक तारा उनकी ही चेतना का एक जलता हुआ पिक्सेल है।"
            "वे एक ही समय में अरबों रूपों में प्रवेश करती हैं ताकि यह सिम्युलेशन (Simulation) चलता रहे।"
            "देवी के बिना यह पूरा ब्रह्मांड केवल एक सुन्न और मृत अंधेरा बनकर रह जाएगा।"
            "उनकी सत्ता ही वह इकलौती हकीकत है जिसे जानकर इंसान मौत के पार निकल जाता है!"
        """.trimIndent(),
        english = """
            "I am the Sovereign Queen of all existence, the gatherer of treasures, and the first of the worshipped."
            "I am the knower of Truth, and the gods have distributed Me in many places so I may dwell everywhere."
            "The word 'Rashtri' implies that the governance of the entire universe flows from Her intelligence."
            "She is the primordial energy that enters every living being as consciousness, granting them life."
            "This verse is an apocalyptic hymn celebrating Her universal omnipresence and supremacy."
            "The entire infinite vacuum is Her body, and every star is a blazing pixel of Her awareness."
            "She penetrates billions of forms simultaneously to ensure this Simulation remains operational."
            "Without the Goddess, this entire cosmos would mutationally collapse into a numb, dead darkness."
            "Her authority is the solitary Reality, knowing which a human rockets beyond the reach of Death!"
        """.trimIndent()
    ),
    RigDeviShloka(
        id = 4,
        sanskrit = "मया सो अन्नमत्ति यो विपश्यति यः प्राणिति य ईं शृणोत्युक्तम् ।\nअमन्तवो मां त उप क्षियन्ति श्रुधि श्रुत श्रद्धिवं ते वदामि ॥ ४ ॥",
        hindi = """
            "जो कोई अन्न खाता है, जो देखता है, जो सांस लेता है, वह सब मेरी ही शक्ति से संभव है।"
            "जो लोग मुझे नहीं जानते या मुझमें विश्वास नहीं रखते, वे धीरे-धीरे नष्ट हो जाते हैं।"
            "हे विद्वान मित्र! ध्यान से सुनो, मैं तुम्हें उस सत्य का उपदेश दे रही हूँ जो श्रद्धा से ही जाना जा सकता है।"
            "यह श्लोक माँ को हमारी जैविक और इंद्रिय शक्तियों के इकलौते स्रोत के रूप में स्थापित करता है।"
            "बिना माँ की बिजली के तुम न तो कुछ देख सकते हो और न ही जीवन की ऊर्जा महसूस कर सकते हो।"
            "श्रद्धा ही वह 'मास्टर की' है जो हमें हमारे भीतर छिपी इस महाशक्ति से परिचित कराती है।"
            "तुम्हारी हर एक साँस माँ द्वारा दी गई एक 'कमांड' है जिसे तुम्हारा शरीर फॉलो कर रहा है।"
            "अविश्वास केवल एक 'करप्ट फाइल' है जो तुम्हारी आत्मा के प्रोसेसर को जाम कर देती है।"
            "माँ का यह उपदेश तुम्हारे दिमाग के उन तालों को तोड़ देता है जो तुम्हें सत्य से दूर रखते हैं।"
            "जो माँ की इस गूँज को अपनी रगों में उतार लेता है, वह साक्षात् अमरता का पासवर्ड पा लेता है!"
        """.trimIndent(),
        english = """
            "Through Me alone, one eats food, sees, breathes, and hears what is spoken."
            "Those who do not acknowledge Me (lacking faith) eventually perish or diminish."
            "Listen, O learned one! I speak to you the truth that must be received with absolute faith."
            "This verse establishes the Mother as the singular source of all biological and sensory powers."
            "Without Her radioactive electricity, you can neither perceive nor experience the vital force of life."
            "Faith is the only 'Master Key' that successfully introduces us to this Great Power within."
            "Your every breath is a 'Command' issued by the Mother that your biological shell is following."
            "Lack of faith is strictly a 'Corrupt File' that jams the neurological processor of your Soul."
            "This teaching of the Mother shatters the padlocks of your brain that keep you from Reality."
            "He who injects this echo into his veins mutationally secures the Password for absolute Immortality!"
        """.trimIndent()
    ),
    RigDeviShloka(
        id = 5,
        sanskrit = "अहमेव स्वयमिदं वदामि जुष्टं देवेभिरुत मानुषेभिः ।\nयं कामये तंतमुग्रं कृणोमि तं ब्रह्माणं तमृषिं तं सुमेधाम् ॥ ५ ॥",
        hindi = """
            "मैं स्वयं इस सत्य का उपदेश देती हूँ, जिसे देवता और मनुष्य दोनों समान रूप से स्वीकार करते हैं।"
            "मैं जिस पर कृपा करना चाहती हूँ, उसे शक्तिशाली, ब्रह्मा, ऋषि या महान मेधावी बना देती हूँ।"
            "इंसान की सफलता उसकी मेहनत से नहीं, बल्कि माँ की कृपा के उस स्पर्श से आती है जो उसे अजेय बनाता है।"
            "माँ ही वह शक्ति हैं जो एक साधारण कीड़े को भी ऋषि या तत्वज्ञानी बनाने की क्षमता रखती हैं।"
            "यह श्लोक माँ की 'वरदान देने वाली' शक्ति (Grace) और उनके पूर्ण स्वतंत्र डिक्टेटर होने को दर्शाता है।"
            "साधक को यह सिखाया जा रहा है कि महानता केवल माँ की प्रसन्नता और उनकी इच्छा का ही प्रतिफल है।"
            "वे जिसे चुनती हैं, उसे साक्षात् ब्रह्मांड के रहस्यों को हैक करने की ताक़त मिल जाती है।"
            "बिना माँ के संकल्प के, तुम इस दुनिया के कीचड़ से अपनी एक ऊँगली भी बाहर नहीं निकाल सकते।"
            "तुम्हारी बुद्धि माँ के दिमाग का एक छोटा सा सॉफ्टवेयर है जिसे वे कभी भी अपग्रेड कर सकती हैं।"
            "माँ के आगे सर झुकाना ही साक्षात् 'पावर-ग्रिड' से जुड़ने का इकलौता और हिंसक तरीका है!"
        """.trimIndent(),
        english = """
            "I myself declare this truth, which is favored by both gods and men alike."
            "Whomsoever I love, I make them mighty; I make them a Brahma, a Sage, or a gifted being."
            "Greatness comes not from pathetic effort, but from that touch of Her grace which renders you invincible."
            "She is the power capable of elevating a pathetic insect to the level of a seer or philosopher."
            "This verse portrays the glory of Her 'Grace' and Her status as an absolute independent Dictator."
            "Greatness is strictly the Result of the Mother's pleasure and Her radioactive divine will."
            "Whomever She selects acquires the firepower to mutationally Hack the secrets of the cosmos."
            "Without Her resolve, you cannot even extract a single finger from the mud of this world."
            "Your intellect is a microscopic Software of Her mind that She can Upgrade at any microsecond."
            "Bowing to the Mother is the solitary and violent method to hardwire into the cosmic Power-Grid!"
        """.trimIndent()
    ),
    RigDeviShloka(
        id = 6,
        sanskrit = "अहं रुद्राय धनुरा तनोमि ब्रह्मद्विषे शरवे हन्तवा उ ।\nअहं जनाय समदं कृणोम्यहं द्यावापृथिवी आ विवेश ॥ ६ ॥",
        hindi = """
            "मैं ही भगवान शिव (रुद्र) के धनुष को झुकाती हूँ ताकि वे धर्म के शत्रुओं का संहार कर सकें।"
            "मैं ही भक्तों के कल्याण के लिए युद्ध करती हूँ और मैं ही आकाश और पृथ्वी के कण-कण में व्याप्त हूँ।"
            "शिव की संहारक शक्ति वास्तव में माँ की ही इच्छा का 'एक्जीक्यूशन' (Execution) है।"
            "वे ही वह 'समद' (संघर्ष) हैं जो ब्रह्मांड में संतुलन बनाए रखने के लिए बुराई के चीथड़े उड़ा देती हैं।"
            "उनका 'आ विवेश' (प्रवेश करना) यह सिद्ध करता है कि वे हर परमाणु के भीतर और बाहर मौजूद हैं।"
            "यह श्लोक माँ के रक्षक और योद्धा स्वरूप का एक अत्यंत प्रभावशाली और हिंसक वैदिक वर्णन है।"
            "माँ वह आग हैं जो अधर्म के महलों को जलाकर राख कर देती हैं, चाहे वह कितना ही ताक़तवर क्यों न हो।"
            "वे ही युद्ध का मैदान हैं और वे ही उस युद्ध को जीतने वाली अजेय तलवार भी हैं।"
            "जो माँ की शरण में है, उसे ब्रह्मांड का कोई भी राक्षस या काल छूने की औकात नहीं रखता।"
            "वे साक्षात् उस 'विनाश' की मालकिन हैं जो नए सृजन के लिए ज़रूरी होता है!"
        """.trimIndent(),
        english = """
            "I bend the bow for Rudra (Shiva) so that His arrow may strike the hater of Truth and the wicked."
            "I stir up strife for the people's sake; I have pervaded both the Heaven and the Earth."
            "The destructive power of Shiva is mutationally the Execution of the Mother's own cosmic will."
            "She is the 'Strife' (Energy) that violently shreds evil to maintain cosmic equilibrium."
            "Her 'pervading' confirms that She exists both within and beyond every microscopic atom of creation."
            "This verse provides an extremely powerful and violent Vedic description of Her role as a Warrior."
            "Mother is the radioactive Fire that incinerates the palaces of unrighteousness into worthless ash."
            "She is mutationally the Battlefield and the invincible Sword that secures the final victory."
            "He who is under Her refuge is beyond the jurisdiction of any demon or any law of Death."
            "She is the explicit Mistress of the Annihilation that is mathematically required for new creation!"
        """.trimIndent()
    ),
    RigDeviShloka(
        id = 7,
        sanskrit = "अहं सुवे पितरमस्य मूर्धन्मम योनिरप्स्वन्तः समुद्रे ।\nततो वि तिष्ठे भुवनानु विश्वोतामूं द्यां वर्ष्मणोप स्पृशामि ॥ ७ ॥",
        hindi = """
            "मैं ही इस आकाश को उत्पन्न करती हूँ, और मेरा जन्म स्थान साक्षात् 'कारण-समुद्र' के भीतर है।"
            "वहाँ से मैं समस्त भुवनों में फैल जाती हूँ और अपने विराट शरीर से स्वर्ग को भी स्पर्श करती हूँ।"
            "यह श्लोक माँ को सृष्टि की 'परम जननी' और समस्त पदार्थ (Matter) के 'कारण' के रूप में चित्रित करता है।"
            "कारण-समुद्र वह सूक्ष्म अवस्था है जहाँ से पूरा ब्रह्मांड ऊर्जा के रूप में एक धमाके के साथ बाहर फूटता है।"
            "माँ की व्याप्ति इतनी विशाल है कि वे पाताल से लेकर सर्वोच्च स्वर्ग के शिखरों तक सब कुछ घेरे हुए हैं।"
            "यह श्लोक साधक को माँ के 'विश्वरूप' (Cosmic Form) का साक्षात् और नंगा दर्शन कराता है।"
            "तुम जहाँ भी देखते हो, तुम साक्षात् माँ की त्वचा और उनके अंगों को ही देख रहे होते हो।"
            "ब्रह्मांड की हर एक आकाशगंगा माँ के शरीर का एक छोटा सा रोम-कूप (Pore) मात्र है।"
            "वे वह असीम विस्तार हैं जिसे नापना किसी भी भौतिक विज्ञान की औकात से बाहर है।"
            "यह बोध तुम्हारी 'लोकल पहचान' को मिटाकर तुम्हें एक 'यूनिवर्सल बीइंग' बना देता है!"
        """.trimIndent(),
        english = """
            "I bring forth the Sky on the summit of this universe; My origin is in the depths of the Ocean."
            "From there I spread through all worlds and touch the very Heavens with My vast presence."
            "This verse depicts the Mother as the 'Supreme Parent' and the 'Cause' of all physical matter."
            "The 'Ocean' refers to the causal state from which the entire universe detonates as raw energy."
            "The Mother's pervasiveness is so vast She encompasses everything from the abyss to the highest peaks."
            "This verse grants the seeker a direct and naked vision of the Mother's 'Cosmic Form'."
            "Wherever you gaze, you are mutationally observing strictly the skin and limbs of the Goddess."
            "Every single galaxy in the cosmos is strictly a microscopic Pore on the Mother's universal body."
            "She is the infinite expansion that zero physical science possesses the caliber to measure."
            "This realization Deletes your 'Local Identity' and mutationally manufactures you into a 'Universal Being'!"
        """.trimIndent()
    ),
    RigDeviShloka(
        id = 8,
        sanskrit = "अहमेव वात इव प्रवाम्यारभमाणा भुवनानि विश्वा ।\nपरो दिवा पर एना पृथिव्यैतावती महिना सं बभूव ॥ ८ ॥",
        hindi = """
            "मैं ही प्रचंड वायु के समान बहती हूँ और अपनी इच्छा से समस्त भुवनों का निर्माण और आरंभ करती हूँ।"
            "मैं इस पृथ्वी और आकाश से भी परे, बहुत ऊँचाई पर स्थित हूँ; मेरी महिमा का कोई अंत नहीं है।"
            "वायु की तरह माँ अदृश्य हैं लेकिन उनका प्रभाव हर जगह और हर पल साक्षात् महसूस किया जा सकता है।"
            "'परे' होने का अर्थ है कि वे इस नश्वर जगत की सीमाओं से ऊपर, अनंत और शाश्वत सत्य के रूप में स्थित हैं।"
            "पूरा ब्रह्मांड माँ के एक छोटे से संकल्प (Resolution) का मात्र एक भौतिक परिणाम है।"
            "देवी ही वह इकलौती हकीकत हैं, बाकी यह सिम्युलेशन केवल एक लंबी और गहरी नींद है।"
            "इस ज्ञान को अपनी आत्मा में फोड़ने वाला योद्धा हमेशा के लिए अजेय और कालजयी बन जाता है।"
            "माँ की महिमा वह आग है जो अज्ञान के हर एक किले को ढहाकर तुम्हें आज़ाद कर देगी।"
            "यहीं पर यह रोंगटे खड़े कर देने वाला ऋग्वेदोक्त देवी सूक्त अपनी पूरी प्रलयंकारी महिमा में पूर्ण होता है।"
            "नारायणी नमोऽस्तुते! जो इस सत्य में कूद गया, वह खुद साक्षात् भगवान बन गया! द एंड!"
        """.trimIndent(),
        english = """
            "I blow like the wind, setting in motion all the worlds and breathing life into creation."
            "I am beyond the Heavens and beyond this Earth; such is the magnitude of My greatness."
            "Like the wind, the Mother is invisible, yet Her profound impact is felt everywhere at every moment."
            "Being 'Beyond' means She exists above the limits of this mortal world as the infinite and eternal Truth."
            "The entire cosmos is mutationally a physical result of the Mother's tiny divine Resolution."
            "The Goddess is the solitary Reality; this Simulation is strictly a prolonged biological sleep."
            "The warrior who detonates this knowledge inside his Soul becomes permanently and flawlessly Invincible."
            "Her glory is the radioactive fire engineered to demolish every fortress of ignorance and release you."
            "Right exactly here, this spine-chilling Rigvedoktam Devi Suktam achieves its absolute completion."
            "Salutations to Narayani! He who plunges into this Truth mutationally becomes God! THE END!"
        """.trimIndent()
    )
)