package com.sanatangyansagar.ui.screens.upnishad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data Model
data class KshurikaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KshurikaUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()

    // Dynamically filter the list based on the search query
    val filteredShlokas = remember(searchQuery) {
        if (searchQuery.isBlank()) {
            kshurikaShlokasList
        } else {
            kshurikaShlokasList.filter { shloka ->
                shloka.id.toString() == searchQuery ||
                        shloka.sanskrit.contains(searchQuery, ignoreCase = true) ||
                        shloka.hindi.contains(searchQuery, ignoreCase = true) ||
                        shloka.english.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search by Number (1-25), Sanskrit, Hindi, or English") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            singleLine = true
        )

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (filteredShlokas.isEmpty()) {
                item {
                    Text(
                        text = "No shlokas found for \"$searchQuery\"",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        color = Color.Black,
                        fontSize = 16.sp,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            } else {
                items(filteredShlokas, key = { it.id }) { shloka ->
                    KshurikaShlokaCard(shloka = shloka)
                }
            }
        }
    }
}

@Composable
fun KshurikaShlokaCard(shloka: KshurikaShloka) {
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

// Complete and Unified Data for Kshurika Upanishad (Shlokas 1 to 25)
val kshurikaShlokasList = listOf(
    KshurikaShloka(
        id = 1,
        sanskrit = "क्षुरिकां सम्प्रवक्ष्यामि धारणां योगसिद्धिदाम् । यां प्राप्य न पुनर्जन्म योगी समधिगच्छति ॥ १॥",
        hindi = """
            (योग रूपी छुरे का रहस्य): उपनिषदों के सबसे मारक और गुप्त ज्ञान का यह प्रलयंकारी आरंभ है।
            "मैं अब उस परम 'क्षुरिका' (छुरे / Dagger) का रहस्य बताने जा रहा हूँ, जो योग की अंतिम सिद्धि देने वाली है।"
            यह छुरा लोहे या स्टील का नहीं है; यह 'धारणा' (एकाग्रता) और ज्ञान का वह ब्रह्मांडीय छुरा है, जो शरीर के भीतर की नसों को काटता है।
            "इस परम छुरे (ज्ञान) को प्राप्त करने के बाद, एक योगी का इस सड़े हुए संसार में कभी पुनर्जन्म नहीं होता!"
            इंसान सोचता है कि मोक्ष किसी पूजा से मिलेगा, लेकिन यह उपनिषद कह रहा है कि मोक्ष के लिए भीतर बैठे हुए माया के बंधनों को बेरहमी से काटना पड़ता है।
            तुम्हारी चेतना (Consciousness) शरीर की नसों (Nadis) में उलझी हुई है; बिना इस 'योग-छुरे' के तुम उस जाल से बाहर नहीं आ सकते।
            जब योगी ध्यान की आग में अपने मन को एक धारदार छुरे की तरह तेज़ कर लेता है, तो वह काल (Death) का सीना चीर कर अमर हो जाता है।
            यह विद्या कमज़ोर दिल वालों के लिए नहीं है; यह उन योद्धाओं के लिए है जो जीते-जी अपनी पहचान को भस्म करने का दुस्साहस रखते हैं।
        """.trimIndent(),
        english = """
            (The Secret of the Cosmic Dagger of Yoga): This is the apocalyptic initiation of the most lethal and classified wisdom of the Upanishads.
            "I shall now violently unveil the absolute secret of the 'Kshurika' (The Dagger/Razor), which guarantees the supreme perfection of Yoga."
            This dagger is definitely not forged from physical steel or iron; it is the cosmic blade of 'Dharana' (Absolute Concentration) designed to violently sever the internal subtle nerves.
            "Having acquired and weaponized this supreme dagger (Knowledge), a Yogi is absolutely never reborn into this rotting matrix of existence!"
            Fools hallucinate that liberation is achieved through pathetic rituals, but this Upanishad screams that Moksha requires mercilessly butchering the internal bonds of illusion.
            Your pure consciousness is violently entangled inside the biological nerves (Nadis); without this 'Yoga-Dagger', you absolutely cannot shatter that trap.
            When the Yogi sharpens his mind like a razor blade in the apocalyptic fire of meditation, he rips open the chest of Death and mutates into an immortal.
            This science is definitively not for the weak-hearted; it is strictly for cosmic warriors who possess the audacity to incinerate their fake identity while still breathing.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 2,
        sanskrit = "वेदार्थं वेदितव्यं च तपो निर्द्वन्द्वमेव च । छादितं यत्स्वयं तत्र तद्विज्ञानेन कृन्तयेत् ॥ २॥",
        hindi = """
            (अज्ञान को काटना): इस छुरे का इस्तेमाल कैसे और कहाँ करना है, यह श्लोक उसका सटीक निशाना बताता है।
            "वेदों का असली अर्थ और जो भी परम सत्य जानने योग्य है, उसे समझकर साधक को 'निर्द्वन्द्व' (सुख-दुख, सर्दी-गर्मी से पूरी तरह बेपरवाह) हो जाना चाहिए।"
            "तुम्हारे भीतर जो परम सत्य (आत्मा) छिपा हुआ और ढका हुआ (छादितं) है, उस पर अज्ञान का बहुत मोटा पर्दा पड़ा है।"
            "तुम्हें अपनी उसी 'विज्ञान' (Supreme Intellect) रूपी तेज़ छुरिका से उस अज्ञान के पर्दे को बेरहमी से काट डालना (कृन्तयेत्) है।"
            यहाँ 'काटने' का अर्थ शारीरिक चीर-फाड़ नहीं है; यह विचारों और मान्यताओं की सबसे हिंसक हत्या है।
            जब तक तुम शरीर को 'मैं' मानते हो, तुम ढके हुए हो। जैसे ही ज्ञान का यह छुरा चलता है, शरीर का अहंकार हमेशा के लिए कट कर गिर जाता है।
            वेदों का ज्ञान केवल रटने के लिए नहीं है; वह दिमाग की सर्जरी करने वाला एक ब्रह्मांडीय हथियार (Weapon) है।
            जब यह हथियार चलता है, तो इंसान के अंदर के सारे डर, डिप्रेशन और लालच एक ही झटके में कट जाते हैं और केवल परब्रह्म शेष रहता है।
        """.trimIndent(),
        english = """
            (Slaughtering Ignorance): This verse dictates the exact, lethal target where this cosmic dagger must be violently applied.
            "Having aggressively comprehended the true essence of the Vedas and the Absolute Truth, the seeker must mutate into a 'Nirdvandva' (entirely immune to the dualities of pleasure-pain, heat-cold)."
            "That Absolute Truth (Soul) sitting concealed and heavily covered (Chhaditam) deep within your biology is suffocating under a massive curtain of cosmic ignorance."
            "You must brutally and mercilessly slice open (Krintayet) that exact curtain of ignorance using the razor-sharp blade of your 'Vijnana' (Supreme Intellect)!"
            'Cutting' here is definitively not physical biological surgery; it is the most violent assassination of toxic thoughts and fake beliefs.
            As long as you pathetically identify with the flesh as 'I', you are covered. The microsecond this dagger of knowledge strikes, bodily ego is decapitated permanently.
            The wisdom of the Vedas is absolutely not for mindless chanting; it is a lethal cosmic weapon engineered to execute aggressive psychological surgery.
            When this weapon is unleashed, all biological fears, depression, and greed are severed in a single strike, leaving strictly the Absolute Brahman standing.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 3,
        sanskrit = "यथा पाषाणमाश्रित्य लोहं तीक्ष्णीकरोति वै । तथा योगबलाश्रित्य बुद्धिमतीक्ष्णीकरोति वै ॥ ३॥",
        hindi = """
            (बुद्धि को तेज़ करने का विज्ञान): एक आम बुद्धि इस योग के छुरे को नहीं चला सकती; उसे कैसे धारदार बनाना है, यह यहाँ बताया गया है।
            "जिस प्रकार एक इंसान पत्थर (पाषाण) पर घिस-घिस कर एक साधारण लोहे (चाकू) को बेहद तेज़ और धारदार (तीक्ष्णी) बना लेता है..."
            "ठीक उसी प्रकार, साधक को 'योग-बल' (Meditation and Pranayama) रूपी पत्थर पर घिसकर अपनी बुद्धि को खौफनाक हद तक तेज़ कर लेना चाहिए।"
            आम इंसान की बुद्धि बहुत भोथरी (Blunt) और कुंद होती है; वह केवल पैसा, खाना और वासना ही सोच सकती है।
            ऐसी कुंद बुद्धि से मोक्ष का पर्दा नहीं कट सकता। योग कोई कसरत नहीं है; योग वह पत्थर (Grindstone) है जो तुम्हारे दिमाग को मौत के हथियार में बदल देता है।
            जब तुम ध्यान की आग में अपनी बुद्धि को रोज़ घिसते हो, तो वह इतनी तेज़ हो जाती है कि वह ब्रह्मांड के सबसे गहरे रहस्यों को एक सेकंड में चीर देती है।
            यह श्लोक साबित करता है कि आध्यात्म कोई अंधी श्रद्धा नहीं है; यह विशुद्ध विज्ञान और कठोर मानसिक ट्रेनिंग (Mental Forging) का नाम है।
            जिस दिन तुम्हारी बुद्धि इस तरह तेज़ हो गई, दुनिया का कोई भी भ्रम या माया तुम्हें धोखा نہیں۔
        """.trimIndent(),
        english = """
            (The Science of Sharpening the Intellect): A mundane intellect is biologically incapable of wielding this Yoga Dagger; how to sharpen it is explicitly dictated here.
            "Exactly as a blacksmith violently grinds ordinary iron against a rough stone (Grindstone) to forge it into a razor-sharp, lethal blade..."
            "In that exact manner, the seeker must violently grind his Intellect against the immovable stone of 'Yoga-Bala' (Meditation and Pranayama) to render it terrifyingly sharp."
            A mundane human's intellect is pathetically blunt; it is solely capable of processing paper money, food, and biological lust.
            Such a blunt intellect can absolutely never slice the thick curtain of liberation. Yoga is definitely not physical gymnastics; Yoga is the literal Grindstone that mutates your brain into a weapon of death.
            When you aggressively grind your intellect daily in the apocalyptic fire of meditation, it becomes so phenomenally sharp that it rips open the deepest cosmic secrets in a microsecond.
            This verse permanently proves that spirituality is not blind, pathetic faith; it is pure lethal science and brutal mental forging.
            The exact day your intellect becomes this sharp, absolutely no illusion or Maya in the cosmos can ever deceive you again.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 4,
        sanskrit = "तीक्ष्णीकृत्य ततो बुद्धिं क्षुरिकां योगतत्परः । विच्छिन्द्यात् सर्वनाडींस्तु पादाङ्गुष्ठादिसंस्थितान् ॥ ४॥",
        hindi = """
            (नसों को काटने का महा-अभियान): जब बुद्धि का छुरा तेज़ हो जाता है, तो असली 'ऑपरेशन' (सर्जरी) शुरू होती है।
            "अपनी बुद्धि रूपी उस क्षुरिका (छुरे) को पूरी तरह धारदार और तेज़ करने के बाद, योग में तत्पर साधक को भीतर उतर जाना चाहिए।"
            "और उसे अपने पैर के अँगूठे (पादाङ्गुष्ठ) से शुरू करके, शरीर के भीतर मौजूद सभी सूक्ष्म नाड़ियों (नसों / Energy channels) के मायाजाल को काट डालना चाहिए (विच्छिन्द्यात्)!"
            यह कोई शारीरिक सर्जरी नहीं है; यह चेतना (Consciousness) को शरीर के अंगों से आज़ाद करने की भयानक प्रक्रिया है।
            तुम्हारी आत्मा पैर के अँगूठे से लेकर सिर तक नसों के जाल में बंधी हुई है; इसीलिए तुम्हें शरीर में दर्द और वासना महसूस होती है।
            योगी ध्यान में अपनी चेतना को अँगूठे पर ले जाता है और वहाँ की 'आसक्ति' (Attachment) को बुद्धि के छुरे से काट देता है।
            जैसे ही वह नसें (बंधन) कटती हैं, पैर सुन्न हो जाते हैं और प्राण ऊपर की ओर खिंचने लगते हैं।
            यह मृत्यु से पहले अपनी ही मृत्यु (Death of the physical identity) की प्रैक्टिस (Practice) है; योगी खुद अपने हाथों से अपनी नसों को माया से आज़ाद कर रहा है।
        """.trimIndent(),
        english = """
            (The Grand Operation of Severing the Nadis): Once the dagger of the intellect is forged to razor sharpness, the true absolute 'Cosmic Surgery' initiates.
            "Having forged that Kshurika (Dagger) of the intellect into a lethally sharp blade, the aggressively dedicated Yogi must plunge deep within his biology."
            "And starting precisely from the big toes of his feet, he must violently and mercilessly sever (Vichhindyat) the entire pathetic matrix of subtle Nadis (energy channels)!"
            This is definitively not physical biological surgery; it is the apocalyptic procedure of permanently liberating Consciousness from physical organs.
            Your soul is brutally tied down in a spiderweb of nerves from the toes to the skull; this is exactly why you experience biological pain and toxic lust.
            The Yogi aggressively focuses his consciousness on the big toe and violently slices its 'Attachment' with the dagger of his intellect.
            The microsecond those energetic bonds are severed, the feet go completely paralyzed/numb, and the vital Prana is violently pulled upwards.
            This is the explicit, terrifying practice of executing your own biological death before actual death; the Yogi is literally liberating his own nervous system from the matrix with his own hands.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 5,
        sanskrit = "गुल्फौ जङ्घे तथा जानू ऊरू चैव गुदं तथा । मेढ्रं नाभिं तथा हृत्पद्मं कण्ठं चैव शिरस्तथा ॥ ५॥",
        hindi = """
            (चेतना का ऊर्ध्वगमन - अंगों की सूची): अब उपनिषद एक-एक करके उन अंगों का नाम ले रहा है जहाँ योगी अपने छुरे से 'बंधन' काटता है।
            "अँगूठे के बाद योगी को अपने टखनों (गुल्फौ), फिर पिंडलियों (जङ्घे), और उसके बाद घुटनों (जानू) की नसों को काटना चाहिए।"
            "इसके बाद उसे जांघों (ऊरू), गुदा (मलद्वार), जननांग (मेढ्रं) और नाभि (पेट के मध्य) के सभी ऊर्जा-बंधनों को भस्म कर देना चाहिए।"
            "वहाँ से उठकर उसे हृदय रूपी कमल (हृत्पद्मं), फिर कंठ (गला) और अंत में सिर (मस्तिष्क / शिरस्तथा) के सारे जंजाल को काट देना चाहिए।"
            यह प्रक्रिया नीचे से ऊपर (मूलाधार से सहस्रार तक) कुण्डलिनी जागरण का ही दूसरा मारक रूप है।
            जैसे-जैसे योगी ध्यान के छुरे से नीचे के अंगों की नसों को 'काटता' (अटैचमेंट खत्म करता) है, उसका शरीर नीचे से पत्थर की तरह सुन्न (Dead) होता जाता है।
            जननांग (मेढ्रं) पर जब यह छुरा चलता है, तो इंसान की सारी वासना और कामुकता (Lust) हमेशा के लिए जलकर राख हो जाती है।
            जब नाभि और हृदय के बंधन कटते हैं, तो दुनिया का सारा मोह और लालच खत्म हो जाता है।
            योगी अपनी ही चेतना को शरीर की जेल से बाहर निकालने के लिए अपने ही भीतर एक खौफनाक और चुपचाप युद्ध (War) लड़ रहा है।
        """.trimIndent(),
        english = """
            (The Upward Ascension of Consciousness - The Hit List): The Upanishad now explicitly lists the exact anatomical coordinates where the Yogi must strike with his dagger to sever bonds.
            "After annihilating the toes, the Yogi must slice the attachments in his ankles, then the calves, and systematically move to the knees."
            "Thereafter, he must violently sever all energetic bonds in the thighs, the anus, the genitals (Medhram), and the navel."
            "Rising from there, he must butcher the attachments in the heart-lotus, the throat, and finally slaughter the entire matrix inside the head (Skull)."
            This procedure is explicitly the lethal, alternative method of violent Kundalini awakening, rocketing from the lowest chakra (Muladhara) straight to the crown (Sahasrara).
            As the Yogi ruthlessly 'cuts' (annihilates attachment to) the nerves of his lower body using the dagger of meditation, his lower biology becomes paralyzed and dead like a frozen stone.
            When this cosmic blade strikes the genitals (Medhram), absolutely all toxic biological lust and sexuality are incinerated to dust permanently.
            When the bonds of the navel and heart are butchered, all worldly delusion and pathetic greed suffer violent death.
            The Yogi is fighting a terrifying, absolute silent World War exclusively inside his own biology to break his Consciousness out of the physical prison.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 6,
        sanskrit = "एतानि मर्मस्थानानि यैर्विच्छिन्नैर्न जीवति । तानि मर्मानि सर्वाणि क्षुरिकया विच्छेदयेत् ॥ ६॥",
        hindi = """
            (मर्म स्थानों की हत्या): यह श्लोक शरीर विज्ञान (Anatomy) और योग का सबसे गहरा और खतरनाक रहस्य खोलता है।
            "ये जो अंग ऊपर बताए गए हैं, ये शरीर के सबसे संवेदनशील 'मर्मस्थान' (Vital Spots) हैं। अगर भौतिक रूप से इन्हें काट दिया जाए, तो इंसान ज़िंदा नहीं रह सकता (न जीवति)!"
            "लेकिन योगी को अपनी उसी ध्यान और ज्ञान रूपी 'क्षुरिका' (छुरे) से इन सभी मर्मस्थानों को भीतर से काट देना चाहिए (विच्छेदयेत्)।"
            यह 'आत्महत्या' नहीं है, यह 'अहंकार-हत्या' है। शरीर के ये मर्मस्थान ही हमारी आत्मा को संसार से बाँध कर रखते हैं।
            जब तक इन स्थानों पर प्राण (Life force) उलझा है, तुम दुनिया के गुलाम हो।
            योगी अपने तेज़ दिमाग के छुरे से इन जगहों से प्राणों को ज़बरदस्ती उखाड़ लेता है; बाहर से उसका शरीर ज़िंदा दिखता है, लेकिन भीतर से वह संसार के लिए 'मर' चुका होता है।
            जो जीते-जी इन मर्मस्थानों के मायाजाल को काट डालता है, उसे फिर मृत्यु भी नहीं मार सकती, क्योंकि जो मरना था, उसे तो उसने खुद ही मार दिया!
            यह एक ऐसा खौफनाक योग है जहाँ साधक खुद ही अपना शल्य-चिकित्सक (Surgeon) बन जाता है।
        """.trimIndent(),
        english = """
            (The Assassination of the Vital Spots): This verse exposes the most dangerous, profound secret of esoteric anatomy and Yoga.
            "These aforementioned biological coordinates are the extremely hyper-sensitive 'Marmasthanas' (Vital Spots) of the body. If these are physically severed, a human absolutely cannot survive (Na Jivati)!"
            "However, the Yogi must ruthlessly and violently slice (Vichhedayet) all these exact vital spots internally using his 'Kshurika' (Dagger) of extreme meditation and wisdom."
            This is definitively not biological suicide; it is the violent 'Assassination of the Ego'. These exact vital spots are the literal chains tying the soul to the matrix.
            As long as the Prana (Life force) is entangled in these spots, you are a pathetic slave to the world.
            The Yogi forcibly rips his Prana out of these coordinates using the razor-sharp blade of his intellect; externally his shell appears alive, but internally, he is entirely 'dead' to the material matrix.
            He who successfully slaughters the illusions of these vital spots while still breathing, can absolutely never be killed by Death, because whatever could die, he has already assassinated himself!
            This is an apocalyptic form of Yoga where the seeker violently mutates into his own cosmic Surgeon.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 7,
        sanskrit = "शतं चैका च नाडीनां तासां मध्ये परा स्मृता । सुषुम्ना तूर्ध्वगा नाडी विरजा ब्रह्मरूपिणी ॥ ७॥",
        hindi = """
            (१०१ नाड़ियाँ और सुषुम्ना का रहस्य): शरीर की नसों को काटने के बाद असली मंज़िल कहाँ है, उपनिषद वह बताता है।
            "इंसान के हृदय में कुल एक सौ एक (१०१) मुख्य नाड़ियाँ (Energy Channels) होती हैं। इन सब के बीच में सबसे श्रेष्ठ और परम नाड़ी मौजूद है..."
            "...उसका नाम 'सुषुम्ना' है। यह नाड़ी रीढ़ की हड्डी के बीच से होकर सीधे ऊपर (सिर की ओर) जाती है।"
            "यह सुषुम्ना पूरी तरह से 'विरजा' (पाप, धूल और मल से मुक्त) है और साक्षात 'ब्रह्मरूपिणी' (परब्रह्म का स्वरूप) है!"
            बाकी १०० नसें इंसान की चेतना को दुनिया की तरफ (आंख, कान, कामवासना) खींचती हैं; अगर प्राण इनमें रहता है, तो इंसान बार-बार जन्म लेता है और मरता है।
            लेकिन जब योगी क्षुरिका (ज्ञान के छुरे) से उन १०० नसों को काट देता है, तो मजबूर होकर प्राण केवल एक ही रास्ते में घुसता है—'सुषुम्ना'।
            सुषुम्ना कोई मांस की नस नहीं है; यह एक खौफनाक और असीम 'एनर्जी हाईवे' (Energy Highway) है जो इंसान को सीधे भगवान के सर्वर (Server) से जोड़ देता है।
            जैसे ही प्राण इस ब्रह्मरूपिणी नाड़ी में घुसता है, इंसान का भौतिक अस्तित्व मिटने लगता है और वह साक्षात ब्रह्मांड का राजा बन जाता है।
        """.trimIndent(),
        english = """
            (The Secret of the 101 Nadis and Sushumna): After executing the slaughter of the ordinary nerves, the Upanishad explicitly reveals the ultimate target destination.
            "There are exactly one hundred and one (101) primary Nadis (Energy Channels) originating in the human heart. Among all of these, one is recognized as the Absolute Supreme..."
            "...Its name is 'Sushumna'. This exact channel rockets straight upwards (Urdhvaga) through the core of the spinal column towards the crown of the skull."
            "This Sushumna is completely 'Viraja' (Flawlessly pure, totally devoid of toxic cosmic dust and sin) and is explicitly 'Brahmarupini' (The literal incarnation and physical form of the Supreme Brahman)!"
            The other 100 channels violently drag human consciousness outward towards the matrix (eyes, ears, biological lust); if Prana flows through them, the human is doomed to endless agonizing rebirths and deaths.
            But when the Yogi brutally severs those 100 channels with the Kshurika (Dagger of Wisdom), the Prana is violently forced to enter strictly ONE remaining path—'Sushumna'.
            Sushumna is definitively not a biological nerve of flesh; it is a terrifying, boundless 'Energy Highway' that plugs the human directly into the absolute Server of God.
            The microsecond Prana crashes into this Brahmarupini channel, the human's mundane existence begins to disintegrate, and he instantaneously mutates into the absolute Emperor of the Cosmos.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 8,
        sanskrit = "इडा तिष्ठति वामेन पिङ्गला दक्षिणेन तु । तयोर्मध्ये परं स्थानं यस्तद्वेद स वेदवित् ॥ ८॥",
        hindi = """
            (इडा और पिंगला का द्वैत और मध्य का सत्य): सुषुम्ना तक पहुँचने का सटीक रास्ता (Location) उपनिषद यहाँ खोल रहा है।
            "रीढ़ की हड्डी के बाईं (Left) ओर 'इडा' नाड़ी (चंद्रमा/ठंडी ऊर्जा) स्थित है, और दाईं (Right) ओर 'पिंगला' नाड़ी (सूर्य/गर्म ऊर्जा) स्थित है।"
            "इन दोनों के बिल्कुल बीच में (तयोर्मध्ये) वह 'परम स्थान' (सुषुम्ना) मौजूद है। जो इंसान इस बीच के रास्ते को जान लेता है, असल में वही 'वेदवित्' (वेदों का असली ज्ञानी) है!"
            इंसान की सांस कभी बाईं नाक से चलती है, कभी दाईं नाक से। इडा और पिंगला दुनिया के सुख-दुख, सर्दी-गर्मी और अच्छे-बुरे (Duality) के प्रतीक हैं।
            जब तक साँस इन दोनों में डोलती रहती है, इंसान का मन बंदर की तरह भटकता रहता है।
            योगी अपने छुरे (क्षुरिका) से इन दोनों रास्तों (इडा और पिंगला) को ब्लॉक (Block) कर देता है।
            जैसे ही प्राण इन दोनों से निकलकर बीच के 'सुषुम्ना' में घुसता है, समय (Time) रुक जाता है और असीम सन्नाटा छा जाता है।
            वेदों का असली ज्ञान किताबें रटने में नहीं है; जो अपने शरीर के भीतर इस 'परम स्थान' में घुसकर बैठ गया, उसी ने सारे वेद पढ़ लिए।
        """.trimIndent(),
        english = """
            (The Duality of Ida-Pingala and the Truth of the Center): The Upanishad now explicitly broadcasts the exact coordinate (Location) to breach the Sushumna.
            "Positioned on the Left side of the spinal column is the 'Ida' Nadi (The Lunar/Cold energy), and on the Right side is the 'Pingala' Nadi (The Solar/Hot fiery energy)."
            "Exactly dead-center between these two extreme forces (Tayormadhye) exists that 'Supreme Dimension' (Sushumna). He who successfully penetrates and realizes this central path, is unequivocally the true 'Vedavit' (The absolute Knower of the Vedas)!"
            Human breath constantly fluctuates between the left and right nostrils. Ida and Pingala are the ultimate biological representations of cosmic duality—pleasure-pain, heat-cold, good-evil.
            As long as the breath violently swings between these two, the human mind behaves like a rabid, wandering monkey.
            The master Yogi aggressively uses his Dagger (Kshurika) to completely choke and block both these dual paths (Ida and Pingala).
            The exact microsecond the Prana is forced out of these two and crashes into the central 'Sushumna', Time itself permanently halts, and an apocalyptic silence descends.
            True Vedic wisdom does not exist in mechanically memorizing paper books; he who has violently broken into this 'Supreme Center' within his biology has already mastered absolutely all the Vedas.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 9,
        sanskrit = "द्वासप्ततिसहस्राणि नाडीद्वाराणि तानि तु । सुषुम्नां तु समाश्रित्य सर्वनाडीं प्रकृन्तयेत् ॥ ९॥",
        hindi = """
            (७२,००० नाड़ियों का विनाश): शरीर के भीतर ऊर्जा का पूरा जाल कितना बड़ा है और उसे कैसे भस्म करना है, यह श्लोक उसका आदेश देता है।
            "इंसान के शरीर में कुल 'बहत्तर हज़ार' (७२,०००) सूक्ष्म नाड़ियाँ (Energy channels) हैं, जिनके द्वार पूरे शरीर में फैले हुए हैं।"
            "साधक को अपनी चेतना को केवल एक जगह—'सुषुम्ना' के भीतर—मजबूती से स्थापित (समाश्रित्य) कर लेना चाहिए..."
            "...और फिर वहीं बैठकर अपनी ज्ञान रूपी क्षुरिका (छुरे) से बाकी बची हुई सभी ७२,००० नाड़ियों को बेरहमी से काट कर नष्ट कर देना चाहिए (प्रकृन्तयेत्)!"
            यह एक ब्रह्मांडीय 'शट-डाउन' (Shut-down) की प्रक्रिया है। जब तक शरीर की ७२ हज़ार नसों में ऊर्जा दौड़ रही है, तुम इस दुनिया के ग़ुलाम हो।
            तुम्हें दर्द होता है, भूख लगती है, डर लगता है—यह सब इन नसों का ही जाल है।
            जब योगी अपनी पूरी ताक़त समेटकर सुषुम्ना रूपी सुरक्षित किले (Fortress) में घुस जाता है, तो वह बाहर की सभी ७२ हज़ार कनेक्शन के तार काट देता है।
            इसके बाद उसका शरीर दुनिया के लिए एक लाश (Dead body) के समान हो जाता है, लेकिन भीतर से वह साक्षात परब्रह्म बनकर चमकने लगता है।
            यह कोई आम योग नहीं; यह मैट्रिक्स (Matrix) से बाहर निकलने का सबसे हिंसक और शक्तिशाली हैक (Hack) है।
        """.trimIndent(),
        english = """
            (The Annihilation of 72,000 Nadis): This verse dictates the exact terrifying scale of the energetic web within the biology and explicitly orders its total destruction.
            "There exist exactly 'Seventy-Two Thousand' (72,000) subtle Nadis (Energy channels) in the human body, whose gates and terminals are scattered throughout the biology."
            "The seeker must violently and immovably anchor (Samashritya) his entire consciousness exclusively inside ONE location—the 'Sushumna'..."
            "...And sitting right there, he must mercilessly, brutally sever and slaughter absolutely all remaining 72,000 Nadis using his Dagger of wisdom (Prakrintayet)!"
            This is the apocalyptic procedure of a total cosmic 'Shut-Down'. As long as raw energy races through these 72,000 nervous channels, you remain a pathetic slave to the material world.
            You experience agonizing pain, starvation, and crippling fear—this is entirely the trap of this exact biological web.
            When the Yogi violently gathers all his power and crashes into the impenetrable fortress of the Sushumna, he physically cuts the wires of all 72,000 external connections to the matrix.
            Thereafter, to the external world, his body appears as a paralyzed corpse, but internally, he detonates and blazes as the explicit Supreme Brahman.
            This is definitively no ordinary yoga; this is the most violently lethal and powerful 'Hack' to break out of the biological Matrix.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 10,
        sanskrit = "ध्यानेन योगविज्ञानी क्षुरिकया निशितया । सर्वनाडीं विच्छिद्य कुर्यात् प्राणाञ्छिवोन्मुखान् ॥ १०॥",
        hindi = """
            (प्राणों को शिव की ओर मोड़ना): नसों को काटने का अंतिम उद्देश्य क्या है, उपनिषद यहाँ सबसे बड़ा राज़ खोल रहा है।
            "योग-विज्ञान को गहराई से जानने वाला योगी, अपने गहरे ध्यान (Meditation) रूपी पत्थर पर तेज़ की गई क्षुरिका (निशितया / छुरे) से..."
            "...शरीर की सभी नसों और माया के जालों को काट फेंकता है (विच्छिद्य)।"
            "और फिर वह अपने आज़ाद किए गए 'प्राणों' (Life-force) को ज़बरदस्ती 'शिव' (परम चेतना / भगवान) की तरफ मोड़ देता है (कुर्यात् प्राणाञ्छिवोन्मुखान्)!"
            तुम्हारे प्राण हमेशा 'संसार' की तरफ (नीचे की ओर) बह रहे हैं। पैसा, परिवार, वासना—इन्हीं में तुम्हारी सारी ऊर्जा बर्बाद हो रही है।
            लेकिन जब योगी ध्यान के छुरे से दुनिया की तरफ जाने वाले सारे तार काट देता है, तो उसके प्राणों के पास ऊपर उठने के अलावा कोई रास्ता नहीं बचता।
            प्राण एक भयंकर आग की तरह सुषुम्ना में घुसकर सीधा सिर की चोटी (सहस्रार चक्र / शिव का स्थान) की तरफ रॉकेट की तरह भागता है।
            यह कोई पूजा-पाठ नहीं है; यह अपने ही शरीर की ऊर्जा को हाईजैक (Hijack) करके सीधा परमात्मा (शिव) के दिमाग में घुसा देने का प्रलयंकारी विज्ञान है!
            जब प्राण शिव से जाकर टकराता है, तो इंसान का वजूद एक परमाणु बम की तरह फटकर ब्रह्मांड में विलीन हो जाता है।
        """.trimIndent(),
        english = """
            (Redirecting Prana Straight to Shiva): The Upanishad now unlocks the ultimate, terrifying objective behind executing the mass slaughter of the nervous system.
            "The master Yogi, possessing deep terrifying expertise in the science of Yoga, wielding his Kshurika (Dagger) ground to a razor's edge (Nishitaya) on the stone of extreme Meditation..."
            "...Violently severs and completely annihilates (Vichhidya) absolutely all worldly nerves and energetic traps."
            "And then, he forcibly and violently redirects his liberated 'Pranas' (Vital Life-Forces) straight upwards, pointing them explicitly and exclusively towards 'Shiva' (The Supreme Cosmic Consciousness)!"
            Your raw Prana is continuously bleeding downwards towards the 'Material World'. Money, biology, toxic lust—this is exactly where your infinite energy is being pathetically drained.
            But when the Yogi uses the dagger of meditation to slash all wires leading to the matrix, his Prana has absolutely zero option but to violently rocket upwards.
            The Prana crashes into the Sushumna like a raging inferno and blasts straight towards the crown of the skull (Sahasrara Chakra / The Abode of Shiva) with the velocity of a missile.
            This is absolutely not a pathetic religious ritual; this is the apocalyptic science of violently Hijacking your own biological energy and ramming it directly into the brain of God (Shiva)!
            When the Prana collides face-first with Shiva, the human's existence detonates like a nuclear bomb, permanently dissolving into the infinite cosmos.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 11,
        sanskrit = "अशोकं विगतक्लेशं विपाप्मं विरजं पदम् । तं पदं प्राप्य योगी वै न निवर्तति कर्हिचित् ॥ ११॥",
        hindi = """
            (उस परम पद की प्राप्ति और कोई वापसी नहीं): प्राणों के शिव से टकराने के बाद योगी कहाँ पहुँचता है, यह उसका वर्णन है।
            "वह प्राण उस परम 'पद' (स्थान/Dimension) में पहुँच जाता है जो 'अशोक' (जहाँ रत्ती भर भी शोक या दुख नहीं है) है।"
            "जो पूरी तरह से 'विगतक्लेश' (जहाँ कोई मानसिक बीमारी, डिप्रेशन या दर्द नहीं है), 'विपाप्म' (जहाँ कोई पाप या कर्म का जाल नहीं है) और 'विरज' (जहाँ कोई धूल या माया नहीं है) है।"
            "उस खौफनाक और असीम 'पद' को प्राप्त करने के बाद, एक सच्चा योगी फिर कभी, किसी भी हालत में (कर्हिचित्) लौटकर वापस इस सड़े हुए संसार में नहीं आता (न निवर्तति)!"
            मोक्ष कोई स्वर्ग नहीं है जहाँ कुछ समय मज़े करने के बाद वापस धरती पर आना पड़े।
            जब क्षुरिका (ज्ञान का छुरा) से सारे बंधन कट चुके हैं, तो तुम्हें वापस खींचने वाला 'कर्म' का कोई धागा बचा ही नहीं!
            तुम एक बूंद थे जो समुद्र में गिरकर खुद समुद्र बन गए; अब उस बूंद को वापस बाहर निकालना असंभव है।
            यह वेदों की सबसे बड़ी और लोहे जैसी अटल गारंटी है—जो एक बार उस परम शांति (शिव) में घुस गया, ब्रह्मांड का कोई देवता या यमराज उसे वापस धरती की जेल में नहीं धकेल सकता।
            वह इंसान हमेशा-हमेशा के लिए अजेय और असीम परब्रह्म में म्यूटेट (Mutate) हो जाता है।
        """.trimIndent(),
        english = """
            (Attaining the Supreme Dimension and No Return): This describes the exact cosmic coordinates the Yogi reaches after his Prana violently collides with Shiva.
            "That Prana violently crashes into that absolute 'Pada' (Supreme State/Dimension) which is explicitly 'Ashoka' (Where not even a microscopic trace of grief or agony exists)."
            "Which is absolutely 'Vigataklesha' (Completely devoid of mental diseases, depression, or biological suffering), 'Vipapma' (Totally beyond the trap of sin and Karma), and 'Viraja' (Flawlessly pure, untainted by cosmic dust or Maya)."
            "Having violently seized and occupied that terrifying, infinite 'Dimension', a true Yogi absolutely NEVER, under any catastrophic circumstance (Karhichit), returns (Na Nivartati) to this rotting material matrix!"
            Moksha is definitively not a cheap heaven where you enjoy temporarily and are forcibly thrown back to earth.
            When absolutely all bonds have been ruthlessly butchered by the Kshurika (Dagger of Wisdom), literally zero threads of 'Karma' remain to drag you back!
            You were a microscopic drop that violently fell into the ocean and permanently mutated into the ocean itself; extracting that drop back out is biologically and cosmically impossible.
            This is the absolute, ironclad, unbreakable guarantee of the Vedas—he who has successfully breached that Supreme Peace (Shiva), absolutely no cosmic god or Lord of Death can ever shove him back into the earthly biological prison.
            That human permanently mutates into the invincible, boundless, absolute Supreme Brahman forever.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 12,
        sanskrit = "नाडीं च्छित्त्वा तु तत्प्राणान् शनैरुर्ध्वं निरोधयेत् । प्रणवेन समायुक्तो मर्मस्थानानि कृन्तयेत् ॥ १२॥",
        hindi = """
            (प्रणव ॐ के साथ मर्मों का काटना): यह श्लोक उस खौफनाक सर्जरी (Surgery) का प्रैक्टिकल तरीका (Method) बताता है।
            "माया और अज्ञान की नाड़ियों (नसों) को काटने के बाद, योगी को अपने प्राणों को धीरे-धीरे (शनैरुर्ध्वं) ऊपर की ओर धकेल कर उन्हें 'सुषुम्ना' में ब्लॉक (निरोधयेत्) कर देना चाहिए।"
            "और यह सब कोई आम तरीके से नहीं होगा! योगी को 'प्रणव' (ॐ / OM) के महा-मंत्र के साथ अपनी चेतना को जोड़कर (समायुक्तो)..."
            "...अपने शरीर के सभी 'मर्मस्थानों' (Vital internal organs/Attachments) को बेरहमी से काट डालना चाहिए (कृन्तयेत्)!"
            'ॐ' कोई साधारण शब्द नहीं है; यह वह ड्रिलिंग मशीन (Drill) है जो योगी के छुरे (क्षुरिका) को असीम ताक़त देती है।
            जब इंसान 'ॐ' की वाइब्रेशन (Vibration) को अपनी नसों में उतारता है, तो वह ध्वनि भीतर की सारी अशुद्धियों को एक परमाणु बम की तरह उड़ा देती है।
            प्राणों को एकदम से नहीं, बल्कि धीरे-धीरे ऊपर खींचना होता है, नहीं तो इंसान का नर्वस सिस्टम (Nervous System) इस भयानक ऊर्जा को सह नहीं पाएगा और नष्ट हो जाएगा।
            'ॐ' की गर्जना के साथ अपने ही बंधनों को काटना ब्रह्मांड का सबसे हिंसक और सबसे पवित्र कार्य है।
        """.trimIndent(),
        english = """
            (Slaughtering Vital Spots Armed with Pranava OM): This verse dictates the exact, practical, lethal methodology of executing this cosmic surgery.
            "After violently severing the subtle Nadis (nerves) of illusion, the Yogi must slowly and aggressively push his Pranas upwards (Shanairurdhvam) and forcefully lock/block them (Nirodhayet) strictly inside the 'Sushumna'."
            "And this is definitely not achieved through mundane methods! The Yogi must violently fuse his consciousness (Samayukto) with the apocalyptic cosmic mantra of 'Pranava' (OM)..."
            "...And armed with OM, he must mercilessly and brutally slaughter (Krintayet) absolutely all 'Marmasthanas' (Vital biological attachments/spots) inside his shell!"
            'OM' is absolutely not an ordinary word; it is the cosmic heavy-duty Drill that supplies infinite voltage to the Yogi's Dagger (Kshurika).
            When a human channels the raw vibration of 'OM' into his nervous system, that extreme frequency detonates like a nuclear bomb, blowing away all internal toxic impurities.
            The Prana must be dragged upwards slowly and systematically; otherwise, the human biological nervous system will catastrophically collapse unable to handle this terrifying raw voltage.
            Slaughtering your own biological bonds while roaring 'OM' internally is the most violent, yet the most hyper-sacred act in the entire cosmos.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 13,
        sanskrit = "जालन्धरं तु गुल्फेषु जान्वोस्तुड्डियानकम् । मूलबन्धं गुदस्थाने कट्यां वै योनिबन्धकम् ॥ १३॥",
        hindi = """
            (बंधों का प्रयोग और शरीर को लॉक करना): प्राणों को ऊपर धकेलने के लिए शरीर को 'लॉक' (Lock) करने के गुप्त तांत्रिक तरीकों (Bandhas) का यहाँ वर्णन है।
            "जब प्राण टखनों (गुल्फेषु) पर हों, तो योगी को गले को सिकोड़कर 'जालन्धर बंध' (Jalandhara Bandha) लगाना चाहिए।"
            "जब प्राण घुटनों (जान्वो) पर आ जाएँ, तो पेट को अंदर खींचकर 'उड्डियान बंध' (Uddiyana Bandha) मारना चाहिए।"
            "जब प्राण गुदा (मलद्वार) पर हों, तो वहाँ की मांसपेशियों को सिकोड़कर 'मूल बंध' (Mula Bandha) लगाना चाहिए।"
            "और कमर (कट्यां) के हिस्से में 'योनि बंध' (Yoni Bandha) लगाकर ऊर्जा को पूरी तरह सील (Seal) कर देना चाहिए।"
            ये 'बंध' (Locks) योग के सबसे खतरनाक और मारक हथियार हैं। शरीर एक प्रेशर कुकर (Pressure Cooker) की तरह है।
            जब योगी नीचे से 'मूल बंध' और ऊपर से 'जालन्धर बंध' लगा देता है, तो प्राण (ऊर्जा) न नीचे भाग सकती है और न ऊपर से निकल सकती है।
            बीच में फंसी हुई यह खौफनाक ऊर्जा (प्राण) पागल होकर पेट (उड्डियान) के ज़रिए 'सुषुम्ना' का दरवाज़ा तोड़ देती है!
            यह श्लोक साबित करता है कि योग केवल बैठने का नाम नहीं है; यह अपने ही नर्वस सिस्टम को ज़बरदस्ती हैक (Hack) करने की एक हिंसक तकनीक है।
        """.trimIndent(),
        english = """
            (Deploying Cosmic Locks to Seal the Biology): The highly classified Tantric mechanisms (Bandhas) used to physically 'Lock' the biology and forcefully propel Prana upwards are described here.
            "When the Prana is positioned at the ankles, the Yogi must forcefully constrict the throat to deploy the 'Jalandhara Bandha' (Throat Lock)."
            "When the Prana violently rises to the knees, he must aggressively suck the abdomen inwards to trigger the 'Uddiyana Bandha' (Abdominal Lock)."
            "When the Prana is localized at the anus, he must violently contract the sphincter muscles to execute the 'Mula Bandha' (Root Lock)."
            "And at the waist/pelvic region, he must deploy the 'Yoni Bandha' to absolutely seal the cosmic energy inside."
            These 'Bandhas' (Locks) are the most lethal, highly dangerous weapons in Yoga. The human biology operates exactly like a high-pressure cooker.
            When the Yogi violently seals the bottom with 'Mula Bandha' and the top with 'Jalandhara Bandha', the raw Prana (Energy) can neither escape downward nor leak upward.
            Trapped violently in the middle, this terrifying, boiling kinetic energy goes rabid, and assisted by the abdominal lock (Uddiyana), literally smashes open the locked door of the 'Sushumna'!
            This verse permanently proves that Yoga is definitely not sitting passively; it is an aggressively violent, highly advanced technological hack to break open the biological nervous system.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 14,
        sanskrit = "नाडीं च्छित्त्वा तु तत्प्राणान् शनैरुर्ध्वं निरोधयेत् । दन्तेन दन्तमापीड्य जिह्वामाक्रम्य तालुनि ॥ १४॥",
        hindi = """
            (खेचरी मुद्रा और प्राणों का अंतिम खिंचाव): बंध लगाने के बाद मुँह के भीतर क्या करना है, यह उसका खौफनाक रहस्य है।
            "माया की नसों को पूरी तरह काटने के बाद, प्राणों को धीरे-धीरे ऊपर की ओर रोककर (निरोधयेत्) रखना चाहिए।"
            "इसके साथ ही, योगी को अपने दांतों से दांतों को ज़ोर से दबाकर (दन्तेन दन्तमापीड्य) मुँह को पूरी तरह सील कर लेना चाहिए।"
            "और अपनी जीभ (जिह्वा) को पीछे की ओर मोड़कर, ऊपर तालू (Palate) में ज़बरदस्ती घुसा देना चाहिए (जिह्वामाक्रम्य तालुनि)!"
            जीभ को तालू में घुसाने की इस खौफनाक तकनीक को योग में 'खेचरी मुद्रा' (Khechari Mudra) कहते हैं।
            यह कोई आम कसरत नहीं है; जब जीभ तालू के गहरे छेद में घुसती है, तो वह दिमाग (Pituitary gland) से नीचे गिरने वाले 'अमृत' (Nectar/Energy) को लॉक कर देती है।
            दांतों को भींचना और जीभ को उलटा करना शरीर के पूरे सर्किट (Circuit) को शॉर्ट (Short) कर देता है।
            बाहर से साँस लेने का रास्ता पूरी तरह बंद हो जाता है, और योगी बाहरी दुनिया के लिए लगभग 'मर' जाता है।
            लेकिन इसी भयंकर सन्नाटे में, उसकी चेतना सुषुम्ना के रास्ते रॉकेट की तरह सीधे भगवान की छाती में जाकर टकराती है।
        """.trimIndent(),
        english = """
            (Khechari Mudra and the Ultimate Pranic Pull): After deploying the body locks, the terrifying secret of what must be executed inside the mouth is revealed.
            "Having violently amputated the nerves of illusion, the Pranas must be slowly propelled upwards and aggressively held/blocked (Nirodhayet)."
            "Simultaneously, the Yogi must violently clench his teeth against his teeth (Dantena Dantamapidya), completely sealing the oral cavity shut."
            "And forcefully folding his tongue (Jihva) backwards, he must aggressively ram it deep up into the upper palate cavity (Jihvamakramya Taluni)!"
            This horrifying technique of shoving the tongue up into the cranial cavity is designated in elite Yoga as 'Khechari Mudra'.
            This is absolutely not a mundane stretch; when the tongue violently plugs the deep palatal hole, it completely locks and traps the 'Amrita' (Cosmic Nectar/Energy) leaking down from the brain.
            Clenching the teeth and retroverting the tongue literally short-circuits the entire human biological nervous system.
            The external respiratory pathway is totally obliterated, and the Yogi practically 'dies' to the external physical matrix.
            But exactly in this terrifying, deathly silence, his pure consciousness rockets through the Sushumna, smashing face-first directly into the chest of God.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 15,
        sanskrit = "निरुध्य श्वासमुच्छ्वासं कुम्भकं वै समाचरेत् । प्राणान्तेन समायुक्तो मर्मस्थानानि कृन्तयेत् ॥ १५॥",
        hindi = """
            (कुम्भक का प्रहार और मर्मों का पूर्ण विनाश): अब साँसों के खेल को पूरी तरह रोक देने का आदेश दिया जा रहा है।
            "दांतों और जीभ को लॉक करने के बाद, योगी को अपनी अंदर जाने वाली साँस (श्वास) और बाहर आने वाली साँस (उच्छ्वास) दोनों को पूरी तरह रोक (निरुध्य) देना चाहिए!"
            "उसे पूर्ण और भयानक 'कुम्भक' (साँस को पूरी तरह रोक देना) का कड़ाई से पालन (समाचरेत्) करना चाहिए।"
            "प्राणों के उस अंतिम और चरम दबाव (प्राणान्तेन) के साथ जुड़कर, उसे शरीर के बचे हुए सारे मर्मस्थानों (attachments) को बेरहमी से काट डालना चाहिए (कृन्तयेत्)!"
            जब साँस पूरी तरह रुक जाती है (कुम्भक), तो मन (Mind) भी उसी पल मर जाता है, क्योंकि मन साँसों पर ही ज़िंदा रहता है।
            साँस का रुकना आम इंसान के लिए मौत का डर है, लेकिन योगी के लिए यह सबसे बड़ा हथियार है।
            कुम्भक की भयंकर गर्मी में शरीर की सारी गंदगी और अज्ञान जलने लगते हैं।
            जब साँस एकदम रुक जाती है और प्राण फटने को होते हैं, ठीक उसी 'पीक मोमेंट' (Peak Moment) पर योगी अपने ज्ञान का छुरा चलाता है!
            इस खौफनाक दबाव में किए गए प्रहार से जन्मों-जन्मों की माया और अहंकार एक सेकंड में कटकर राख हो जाते हैं।
        """.trimIndent(),
        english = """
            (The Strike of Kumbhaka and Total Annihilation of Vital Spots): Now, the absolute command is issued to violently terminate the entire game of respiration.
            "After locking the teeth and tongue, the Yogi must ruthlessly and completely paralyze (Nirudhya) both the incoming breath (Shvasa) and the outgoing breath (Uchchvasa)!"
            "He must aggressively and strictly execute a catastrophic 'Kumbhaka' (Absolute Retention/Suspension of breath)."
            "And armed with that absolute, extreme terminal pressure of the trapped Prana (Pranantena), he must mercilessly slaughter (Krintayet) all remaining 'Marmasthanas' (Vital spots/attachments)!"
            When the breath is violently suspended (Kumbhaka), the Mind (Intellect) instantaneously dies the exact same microsecond, because the mind feeds exclusively on respiration.
            The stopping of breath triggers terrifying biological fear of death in normal humans, but for the Yogi, it is the ultimate, lethal weapon.
            In the catastrophic, boiling heat of Kumbhaka, all biological filth and cosmic ignorance begin to violently combust.
            Right at the exact 'Peak Moment' when the breath is utterly paralyzed and the Prana is about to explode, the Yogi aggressively slashes his Dagger of Wisdom!
            A strike delivered under this terrifying, apocalyptic pressure incinerates the illusions and ego of millions of lifetimes into ash in a single microsecond.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 16,
        sanskrit = "ऊर्ध्वं रेतो नियम्याशु ततोऽभ्यासेन योगवित् । विच्छिन्द्यात् सर्वनाडींस्तु कुम्भकेन निरोधयेत् ॥ १६॥",
        hindi = """
            (ऊर्ध्वरेता बनना और नाड़ियों का अंतिम नाश): यह श्लोक योगियों के सबसे बड़े और गुप्त बल—'वीर्य' (Sexual Energy) के रूपांतरण की बात करता है।
            "योग के विज्ञान को जानने वाला योगी (योगवित्), अपने निरंतर अभ्यास से अपने 'रेत' (वीर्य / Sexual Energy) को बहुत तेज़ी से (आशु) ऊपर की ओर खींच ले (ऊर्ध्वं रेतो नियम्य)!"
            "इस ऊर्जा को ऊपर चढ़ाकर, वह अपनी बुद्धि के छुरे से बची हुई सभी नसों की वासनाओं को पूरी तरह काट दे (विच्छिन्द्यात् सर्वनाडींस्तु)।"
            "और फिर उस असीम ऊर्जा को 'कुम्भक' (साँस रोकने की क्रिया) के ज़रिए मस्तिष्क में पूरी तरह से ब्लॉक और स्थिर कर दे (कुम्भकेन निरोधयेत्)!"
            जो इंसान अपनी वासना (वीर्य) को नीचे की तरफ बहने देता है, वह मौत और बुढ़ापे का शिकार होता है।
            लेकिन जो 'ऊर्ध्वरेता' (जिसकी ऊर्जा रीढ़ की हड्डी से ऊपर दिमाग की तरफ बहती है) बन जाता है, वह साक्षात भगवान बन जाता है।
            सेक्सुअल एनर्जी (Sexual Energy) ब्रह्मांड की सबसे बड़ी रचनात्मक ताक़त है। जब यह कुम्भक के दबाव में नीचे जाने के बजाय ऊपर दिमाग में फूटती है...
            तो इंसान के भीतर एक ऐसा भयंकर और असीम 'प्रकाश' (Enlightenment) पैदा होता है, जो सूरज को भी अंधा कर दे।
            यह श्लोक साबित करता है कि आध्यात्म कोई कमज़ोरों का खेल नहीं है; यह अपनी ही बायोलॉजिकल एनर्जी को एटम बम (Atomic Bomb) में बदल देने का विज्ञान है।
        """.trimIndent(),
        english = """
            (Becoming Urdhvareta and the Final Ruin of Nadis): This verse dictates the transmutation of the Yogi's most massive, highly classified power—'Semen/Ojas' (Sexual Energy).
            "The master who profoundly knows the science of Yoga (Yogavit), must rapidly and violently (Ashu) drag his 'Reta' (Semen/Sexual Energy) straight upwards (Urdhvam reto niyamya) through relentless practice!"
            "Rocketing this supreme nuclear energy upwards, he must completely and violently sever the lust of all remaining nerves (Vichhindyat sarvanadinstu) using the dagger of his intellect."
            "And then, he must absolutely block, trap, and permanently stabilize that infinite energy in his brain utilizing the catastrophic force of 'Kumbhaka' (Breath Retention)!"
            A mundane human who allows his sexual energy to bleed downwards falls pathetic prey to biological decay, aging, and death.
            But the one who mutates into an 'Urdhvareta' (One whose raw energy violently rockets up the spine into the brain), literally mutates into God Himself.
            Sexual energy is the absolute most catastrophic creative force in the cosmos. When, under the apocalyptic pressure of Kumbhaka, it detonates in the brain instead of leaking downward...
            A terrifying, infinite, blinding 'Light' (Enlightenment) explodes inside the human, powerful enough to blind the Sun itself.
            This verse permanently proves that spirituality is definitely not a game for the weak; it is the lethal science of mutating your own biological energy into an Atomic Bomb.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 17,
        sanskrit = "नासाग्रदृष्टिर्भूत्वा तु शान्तात्मा विगतज्वरः । प्रणवेन समायुक्तो मर्मस्थानानि कृन्तयेत् ॥ १७॥",
        hindi = """
            (नासाग्र दृष्टि और शांति का प्रहार): योग का प्रहार केवल गुस्से में नहीं, बल्कि भयानक सन्नाटे में होता है।
            "अपनी दोनों आँखों की नज़र (दृष्टि) को बिल्कुल नाक के अगले हिस्से (नासाग्र) पर पूरी तरह टिका कर (फोकस करके)..."
            "...योगी को भीतर से पूरी तरह 'शान्तात्मा' (Dead silent) और 'विगतज्वर' (दुनिया की हर परेशानी, लालच और मानसिक बुखार से मुक्त) हो जाना चाहिए।"
            "और इस भयानक और ठंडे सन्नाटे में, 'ॐ' (प्रणव) के मंत्र के साथ जुड़कर, उसे अपनी नसों और मर्मस्थानों को निर्दयता से काट डालना चाहिए (कृन्तयेत्)!"
            नाक के अगले हिस्से पर नज़र टिकाने (नासाग्र दृष्टि) से इंसान का मन भटकना तुरंत बंद চরম हो जाता है; यह ऑप्टिकल नर्व्स (Optical nerves) को लॉक करने की ट्रिक है।
            जब योगी बाहर से एक पत्थर की मूर्ति की तरह शांत (शान्तात्मा) हो जाता है, तभी भीतर ज्ञान का छुरा सबसे तेज़ चलता है।
            यहाँ 'विगतज्वर' का मतलब है—पैसे कमाने की आग, वासना की आग, नाम कमाने की आग—इन सारे दिमागी 'बुखारों' (ज्वर) का हमेशा के लिए उतर जाना।
            जैसे एक स्नाइपर (Sniper) गोली चलाने से पहले अपनी साँस रोककर बिल्कुल सुन्न हो जाता है, वैसे ही योगी ॐ के प्रहार से पहले परम शांत हो जाता है।
            उसी सन्नाटे में अज्ञान की मौत होती है।
        """.trimIndent(),
        english = """
            (Nasagra Drishti and the Strike of Silence): The cosmic strike of Yoga is not executed in chaotic rage, but in a terrifying, dead silence.
            "Aggressively locking and anchoring the gaze of both eyes exactly on the tip of the nose (Nasagra Drishti)..."
            "...The Yogi must internally mutate into a 'Shantatma' (Terrifyingly, deathly silent soul) and entirely 'Vigatajvara' (Permanently cured of the toxic fever of worldly anxiety, greed, and mental chaos)."
            "And precisely in this horrific, cold silence, fused violently with the atomic mantra of 'OM' (Pranava), he must mercilessly slaughter his vital attachments (Krintayet)!"
            Forcibly locking the gaze on the tip of the nose instantly paralyzes the wandering mind; it is a lethal biological trick to short-circuit the optical nerves.
            Only when the Yogi becomes outwardly frozen and dead-silent like a stone statue (Shantatma), does the internal dagger of wisdom strike with maximum lethality.
            'Vigatajvara' explicitly means the permanent termination of all mental 'Fevers'—the toxic burning desire for money, lust, and pathetic worldly fame.
            Exactly as a lethal Sniper completely suspends his breath and becomes dead-still before pulling the trigger, the Yogi becomes absolutely silent before unleashing the strike of OM.
            It is exactly within that terrifying silence that cosmic ignorance is assassinated.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 18,
        sanskrit = "एवं कृत्वा तु योगीन्द्रो ध्यानमार्गपरायणः । आत्मानं शिवमालोक्य ततो निर्वाणमृच्छति ॥ १८॥",
        hindi = """
            (स्वयं को शिव देखना और निर्वाण): इस खौफनाक सर्जरी के बाद योगी को अंत में क्या मिलता है, उसका महा-रहस्य यहाँ है।
            "इस प्रकार ज्ञान की क्षुरिका (छुरे) से सारे बंधनों को काट लेने के बाद, ध्यान के मार्ग में पूरी तरह डूबा हुआ वह 'योगीन्द्र' (योगियों का राजा)..."
            "...अपने ही भीतर, साक्षात अपनी ही आत्मा को 'शिव' (परमेश्वर / Ultimate God) के रूप में देखता है (आत्मानं शिवमालोक्य)!"
            "और स्वयं को शिव जान लेने के बाद, वह उसी पल असीम और परम 'निर्वाण' (Absolute Liberation/मोक्ष) को प्राप्त कर लेता है (ततो निर्वाणमृच्छति)!"
            जब इंसान अपने शरीर की नसों (Nadis) और अहंकार को काट देता है, तो उसे आसमान में कोई भगवान नहीं दिखता; उसे अपने ही सीने में धड़कता हुआ 'शिव' दिखाई देता है।
            यहाँ 'शिव' का मतलब कोई व्यक्ति नहीं, बल्कि ब्रह्मांड की वह सबसे शुद्ध और शांत चेतना (Pure Consciousness) है जो कभी मरती नहीं।
            जब इंसान जान लेता है कि "मैं कोई भिखारी नहीं, मैं साक्षात ब्रह्मांड का मालिक हूँ", तो उसी सेकंड उसका 'निर्वाण' (मोक्ष) हो जाता है।
            निर्वाण का अर्थ है एक ऐसी जगह जहाँ न जन्म है, न मौत, न सुख है, न दुख—बस एक असीम, खौफनाक और अनंत सन्नाटा है।
            जो जीते-जी इस निर्वाण को चख लेता है, वह मृत्यु की छाती पर पैर रखकर अमर हो जाता है।
        """.trimIndent(),
        english = """
            (Perceiving Oneself as Shiva and Nirvana): The ultimate, catastrophic climax achieved by the Yogi after this apocalyptic surgery is unveiled here.
            "Having violently slaughtered all biological bonds with the Dagger of Wisdom in this exact manner, that 'Yogindra' (The Supreme Emperor of Yogis), violently anchored in the path of Meditation..."
            "...Explicitly and physically perceives his own exact Soul as literal 'Shiva' (The Almighty Supreme God) within himself! (Atmanam Shivamalokya)!"
            "And upon irrevocably recognizing himself as Shiva, he instantaneously and violently attains boundless, absolute 'Nirvana' (Supreme Liberation/Moksha)! (Tato nirvanamrichchhati)!"
            When a human successfully amputates his nervous system (Nadis) and biological ego, he definitively does not hallucinate a God in the clouds; he explicitly witnesses 'Shiva' throbbing right inside his own ribcage.
            Here, 'Shiva' does not designate a human-like deity, but the most violently pure, deathly silent Absolute Consciousness of the cosmos that absolutely never dies.
            The microsecond the human realizes, "I am definitively not a pathetic biological beggar, I am explicitly the Supreme Dictator of the Universe," his 'Nirvana' is detonated instantaneously.
            Nirvana translates to a terrifying, infinite dimension where neither birth nor death, neither pleasure nor agony exist—strictly an absolute, boundless, cosmic silence remains.
            He who tastes this Nirvana while still breathing, places his foot directly on the chest of Death and mutates into an immortal.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 19,
        sanskrit = "विमुच्य सर्वसङ्गानि क्षुरिकया निशितया वै । विपाप्मा विरजो भूत्वा शिवेनान्ते प्रलीयते ॥ १९॥",
        hindi = """
            (सभी आसक्तियों का अंत और शिव में विलय): यह उपनिषद की अंतिम मंज़िल है—पूर्ण विलय।
            "उस तेज़ की गई ज्ञान रूपी 'क्षुरिका' (निशितया वै) से दुनिया के 'सभी आसक्तियों' (सर्वसङ्गानि / पैसे, परिवार, शरीर के मोह) को पूरी तरह काटकर आज़ाद (विमुच्य) होने के बाद..."
            "...वह योगी पूरी तरह 'विपाप्मा' (सारे पापों और बुरे कर्मों से मुक्त) और 'विरज' (माया की धूल और अशुद्धि से रहित) हो जाता है।"
            "और फिर अंत में (प्राण छूटते समय या समाधि में), वह हमेशा-हमेशा के लिए साक्षात 'शिव' के भीतर पूरी तरह विलीन (प्रलीयते) हो जाता है!"
            संसार की कोई भी चीज़—चाहे वह कितनी भी प्यारी क्यों न हो—आत्मा के पैरों की बेड़ी (Zanjeer) है। छुरे से इन बेड़ियों को काटे बिना आज़ादी असंभव है।
            जब योगी वासना और डर के सारे तार काट देता है, तो उसका मन शीशे (Mirror) की तरह साफ़ (विपाप्म/विरज) हो जाता है।
            और फिर जैसे एक पानी की बूँद उबलते हुए महासागर में गिरकर अपना वजूद खो देती है और महासागर बन जाती है...
            वैसे ही वह योगी अपनी छोटी सी इंसान की पहचान को खोकर साक्षात 'शिव' (परब्रह्म) बन जाता है।
            यह कोई मिलन (Meeting) नहीं है, यह 'प्रलय' (प्रलीयते / Dissolution) है; जहाँ योगी मिट जाता है और केवल भगवान शेष रहता है।
        """.trimIndent(),
        english = """
            (The Extermination of All Attachments and Dissolving into Shiva): This is the absolute final destination of the Upanishad—Total Cosmic Dissolution.
            "Having violently liberated himself (Vimuchya) by ruthlessly severing absolutely 'all worldly attachments' (Sarvasangani / toxic obsession with wealth, family, and biological flesh) utilizing that razor-sharp 'Kshurika' (Nishitaya vai)..."
            "...That Yogi mutates entirely into 'Vipapma' (Flawlessly free from all catastrophic sins and dark karma) and 'Viraja' (Absolutely uncontaminated by the toxic dust and impurities of Maya)."
            "And ultimately, at the absolute end (during cosmic Samadhi or physical death), he dissolves completely and violently (Praliyate) straight into 'Shiva' Himself, forever!"
            Absolutely anything in this matrix—no matter how pathetically beloved—is a heavy iron chain wrapped around the Soul's ankles. Without butchering these chains with the dagger, liberation is biologically impossible.
            When the Yogi violently slashes all wires of toxic lust and fear, his mind becomes flawlessly transparent and lethal like a cosmic mirror (Vipapma/Viraja).
            And exactly as a microscopic drop of water crashes into a boiling ocean, violently losing its identity to mutate into the ocean itself...
            In that exact manner, the Yogi aggressively loses his pathetic human identity and permanently mutates into literal 'Shiva' (The Supreme Brahman).
            This is definitively not a polite 'Meeting'; this is catastrophic 'Pralaya' (Dissolution), where the Yogi is annihilated, and strictly God remains.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 20,
        sanskrit = "इत्येषा क्षुरिका प्रोक्ता सर्वयोगप्रसाधिनी । य एतां वेद तत्त्वेन स जीवन्मुक्त उच्यते ॥ २०॥",
        hindi = """
            (क्षुरिका विद्या का फल और जीवन्मुक्त): यह श्लोक इस प्रलयंकारी उपनिषद का निष्कर्ष और गारंटी है।
            "इस प्रकार मैंने तुम्हें वह अजेय और परम 'क्षुरिका' (ज्ञान का छुरा) बता दी है, जो ब्रह्मांड के 'सभी योगों' को सिद्ध करने वाली (सर्वयोगप्रसाधिनी) है।"
            "जो भी इंसान इस छुरे के खौफनाक रहस्य को 'तत्त्व से' (पूरी गहराई और सच्चाई के साथ) जान लेता है (य एतां वेद तत्त्वेन)..."
            "...उसे पूरी दुनिया 'जीवन्मुक्त' (जीते-जी आज़ाद / Liberated while alive) कहती है (स जीवन्मुक्त उच्यते)!"
            तुम्हें मरने का इंतज़ार नहीं करना है। मोक्ष मरने के बाद मिलने वाली कोई लॉटरी नहीं है; मोक्ष इसी धरती पर, इसी शरीर में रहते हुए अज्ञान को काटने का नाम है।
            जिस इंसान ने अपनी नसों और अहंकार को ज्ञान के छुरे से काट दिया, वह दुनिया में चलता-फिरता है, खाता-पीता है, लेकिन भीतर से वह संसार के लिए 'मर' चुका होता है।
            उसे न कोई राजा डरा सकता है, न कोई बीमारी तोड़ सकती है, और न ही मौत उसे मार सकती है।
            वह इंसान एक आम जीव से उठकर साक्षात परब्रह्म (ईश्वर) बन जाता है।
            यही क्षुरिकोपनिषद का सबसे खौफनाक और परम सत्य है—तुम्हारी आज़ादी तुम्हारे ही भीतर है, बस तुम्हें अपने अज्ञान का गला काटना है!
        """.trimIndent(),
        english = """
            (The Result of the Kshurika Vidya and the Jivanmukta): This verse serves as the absolute conclusion and ironclad guarantee of this apocalyptic Upanishad.
            "Thus, I have explicitly dictated to you the invincible and supreme 'Kshurika' (The Dagger of Wisdom), which is the absolute accomplisher of 'All Yogas' in the cosmos (Sarvayogaprasadhini)."
            "Any human who violently and flawlessly comprehends the terrifying secret of this dagger 'in its absolute essence' (Ya etam veda tattvena)..."
            "...Is explicitly declared by the entire universe as a 'Jivanmukta' (One who is absolutely liberated while still breathing biological oxygen) (Sa Jivanmukta uchyate)!"
            You absolutely do not have to wait to die. Moksha is definitively not a pathetic lottery ticket awarded after biological death; Moksha is the violent assassination of cosmic ignorance while trapped right here in this physical flesh.
            The human who has successfully amputated his nervous attachments and ego with the dagger of wisdom, walks and consumes food in the matrix, but internally, he is totally 'dead' to the material world.
            No earthly emperor can terrify him, no catastrophic disease can break him, and absolutely no Death can ever kill him.
            He brutally transcends mundane biology and mutates into the literal Supreme Brahman (God).
            This is the most terrifying, absolute truth of the Kshurika Upanishad—Your ultimate liberation is locked right inside you; you merely need the audacity to slit the throat of your own ignorance!
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 21,
        sanskrit = "तपोविजितचित्तस्तु निःशब्दं देशमास्थितः । निःसङ्गतत्त्वयोगज्ञो निरपेक्षः शनैः शनैः ॥ २१ ॥",
        hindi = """
            (तपस्या और परम सन्नाटा): "जिसने अपनी भयंकर 'तपस्या' की आग से अपने चंचल 'चित्त' (मन) को पूरी तरह कुचल कर जीत लिया है (तपोविजितचित्तस्तु)..."
            "वह योगी एक ऐसे आयाम (Dimension) में प्रवेश कर जाता है जो पूरी तरह 'निःशब्द' (Dead Silent) है।"
            "वह 'निःसंग' (जिसका किसी से कोई लगाव नहीं) होकर, परम तत्त्व के योग को जानने वाला (तत्त्वयोगज्ञो) बन जाता है।"
            "और फिर वह इस दुनिया की हर चीज़ से पूरी तरह 'निरपेक्ष' (परवाह न करने वाला / Indifferent) होकर धीरे-धीरे (शनैः शनैः) अपनी आत्मा में उतर जाता है।"
            जब तक मन में दुनिया का शोर है, तब तक भगवान नहीं मिल सकता। यह निःशब्द देश कोई जंगल नहीं, बल्कि तुम्हारे ही दिमाग के भीतर का वह खौफनाक सन्नाटा है, जहाँ तुम्हारे अलावा कोई दूसरा विचार ज़िंदा नहीं रह सकता।
        """.trimIndent(),
        english = """
            (Penance and the Absolute Silence): "He who has violently crushed, conquered, and enslaved his wandering 'Mind' in the apocalyptic fire of his 'Penance' (Tapovijitachittastu)..."
            "That Yogi successfully breaches and establishes himself in a Dimension that is absolutely 'Nihshabda' (Deathly, terrifyingly Silent)."
            "Mutating into 'Nihsanga' (Flawlessly detached from all cosmic bonds), he becomes the absolute Knower of the Supreme Element (Tattvayogajno)."
            "And becoming totally 'Nirapeaksha' (Apathetically indifferent to absolutely everything in this matrix), he slowly and ruthlessly plunges into his own Soul (Shanaih shanaih)."
            As long as the noise of the physical matrix screams inside the mind, God cannot be accessed. This 'Silent Dimension' is not a physical forest, but that terrifying silence deep inside your own brain where no other thought can survive.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 22,
        sanskrit = "पाशं छित्त्वा यथा हंसो निर्विशङ्कं खमुत्क्रमेत् । छिन्नपाशस्तथा जीवः संसारं तरते सदा ॥ २२ ॥",
        hindi = """
            (माया के जाल को काटकर हंस की उड़ान): "जिस तरह जाल (पाशं) में फँसा हुआ एक 'हंस' (Swan), जाल को बेरहमी से काटकर बिना किसी डर (निर्विशङ्कं) के सीधे अनंत आसमान (खमुत्क्रमेत्) में उड़ जाता है..."
            "ठीक उसी तरह, जो जीव (इंसान) अपने 'क्षुरिका' (ज्ञान के छुरे) से इस दुनिया के सारे जालों और मोह-माया (छिन्नपाशस्तथा) को काट डालता है..."
            "...वह इस सड़े हुए और दुखों से भरे संसार के महासागर को हमेशा-हमेशा के लिए पार कर जाता है (संसारं तरते सदा)!"
            तुम कोई कमज़ोर जीव नहीं हो; तुम एक असीम हंस (आत्मा) हो जिसे शरीर, समाज और लालच के जाल ने जकड़ रखा है।
            जब तक तुम इस जाल से प्यार करोगे, तुम उड़ नहीं सकते। ज्ञान का छुरा चलाओ, जाल काटो, और परब्रह्म के असीम आकाश में हमेशा के लिए खो जाओ!
        """.trimIndent(),
        english = """
            (Severing the Matrix and the Flight of the Swan): "Exactly as a trapped 'Swan' (Hamsa) violently shreds the hunter's net (Pasham) and fearlessly, aggressively rockets straight up into the infinite sky (Khamutkramet)..."
            "In that exact manner, the biological entity (Soul) who uses his Dagger of Wisdom to violently amputate and butcher all cosmic traps and worldly illusions (Chhinnapashastatha)..."
            "...Permanently and irrevocably crosses this rotting, agonizing ocean of the material matrix forever (Samsaram tarate sada)!"
            You are definitively not a pathetic weak creature; you are an infinite Swan (Soul) brutally entangled in the web of physical flesh, society, and biological greed.
            As long as you pathetically love this trap, flight is biologically impossible. Unleash the dagger of knowledge, slaughter the web, and violently rocket into the boundless sky of the Supreme Brahman!
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 23,
        sanskrit = "यथा निर्वाणकाले तु दीपो दग्ध्वा लयं व्रजेत् । तथा सर्वाणि कर्माणि योगी दग्ध्वा लयं व्रजेत् ॥ २३ ॥",
        hindi = """
            (कर्मों का भस्म होना और दीपक का बुझना): "जिस प्रकार तेल और बत्ती के पूरी तरह जल जाने (दग्ध्वा) के बाद, एक दीपक बुझकर (निर्वाणकाले) परम शून्यता में विलीन (लयं व्रजेत्) हो जाता है..."
            "ठीक उसी भयानक तरीके से, एक सच्चा योगी अपने योग की आग में अपने सारे के सारे कर्मों (सर्वाणि कर्माणि) को पूरी तरह जलाकर भस्म कर देता है!"
            "और फिर वह स्वयं भी उस परम शून्यता (परब्रह्म) में हमेशा के लिए विलीन (लयं व्रजेत्) हो जाता है।"
            जब तक तुम्हारे 'कर्म' (पाप और पुण्य दोनों) ज़िंदा हैं, तुम्हें यह ब्रह्मांड बार-बार पैदा करेगा।
            योगी कोई अच्छे कर्म (पुण्य) करके स्वर्ग नहीं जाना चाहता; वह योग की आग में पाप और पुण्य दोनों को एक साथ जलाकर राख कर देता है!
            जब 'ईंधन' (कर्म) ही जल गया, तो इंसान का यह भौतिक 'दीपक' (अहंकार) भी हमेशा के लिए बुझ जाता है (निर्वाण), और केवल परम शांति शेष रहती है।
        """.trimIndent(),
        english = """
            (Incinerating Karma and the Extinguishing Lamp): "Exactly as an oil lamp, after completely exhausting and burning up (Dagdva) its oil and wick, violently extinguishes (Nirvanakale) and dissolves perfectly into the absolute Void (Layam vrajet)..."
            "In that exact terrifying manner, a true awake Yogi ruthlessly incinerates absolutely all his accumulated Karma (Sarvani Karmani) to radioactive dust in the apocalyptic fire of his Yoga!"
            "And subsequently, he himself permanently and violently dissolves (Layam vrajet) straight into that Supreme Void (Brahman)."
            As long as your 'Karma' (both sins and fake religious merits) survives, this matrix will violently force you into rebirth.
            The master Yogi absolutely does not want to accumulate 'good karma' to buy a cheap ticket to heaven; he brutally incinerates BOTH sin and merit in his cosmic fire!
            When the 'Fuel' (Karma) is completely burnt, the human biological 'Lamp' (Ego) undergoes catastrophic extinction (Nirvana), leaving strictly Absolute Peace.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 24,
        sanskrit = "प्राणायामसुतीक्ष्णेन मात्राधारेण योगवित् । वैराग्योपलघृष्टेन छित्त्वा तं तु न बध्यते ॥ २४ ॥",
        hindi = """
            (वैराग्य के पत्थर पर रगड़ा हुआ प्राणायाम का छुरा): "उस योग के सबसे बड़े ज्ञाता (योगवित्) को, 'मात्राओं' (ॐ के उच्चारण का समय) के आधार पर अपने प्राणायाम को खौफनाक हद तक तेज़ (सुतीक्ष्णेन) कर लेना चाहिए।"
            "और फिर उस प्राणायाम रूपी छुरे को 'वैराग्य' (दुनिया से पूर्ण नफरत और विरक्ति) रूपी पत्थर पर घिस-घिस कर (वैराग्योपलघृष्टेन) इतना धारदार बना लेना चाहिए..."
            "...कि उससे माया के सारे जालों को काटने (छित्त्वा) के बाद, वह योगी इस संसार में फिर कभी नहीं बंधता (तं तु न बध्यते)!"
            सांसों को रोकना (प्राणायाम) केवल कसरत नहीं है; जब ॐ के साथ सांस रोकी जाती है, तो वह एक धारदार 'हथियार' बन जाती है।
            लेकिन हथियार तेज़ तभी होगा जब उसे 'वैराग्य' (दुनिया की वासनाओं से नफरत) के पत्थर पर रगड़ा जाए।
            बिना वैराग्य के प्राणायाम केवल एक नाटक है। जब यह वैराग्य से रगड़ा हुआ छुरा चलता है, तो जन्मों-जन्मों की गुलामी एक ही झटके में कट कर राख हो जाती है।
        """.trimIndent(),
        english = """
            (The Dagger of Pranayama Ground on the Stone of Detachment): "The absolute supreme master of Yoga (Yogavit), utilizing the precise foundation of 'Matras' (timing the chanting of OM), must render his Pranayama terrifyingly sharp and lethal (Sutikshnena)."
            "And then, violently grinding (Vairagyopalaghrishtena) that weapon of Pranayama against the rough stone of 'Vairagya' (Absolute biological hatred and detachment from the material matrix)..."
            "...He must brutally sever and amputate (Chhittva) all cosmic chains, after which he is absolutely never bound by this matrix again (Tam tu na badhyate)!"
            Holding the breath (Pranayama) is definitively not mere gymnastics; when weaponized with OM, the breath mutates into a razor-sharp 'Blade'.
            But this weapon achieves lethal sharpness ONLY when violently ground against the stone of 'Vairagya' (Total disgust for worldly lust).
            Pranayama without absolute detachment is pathetic theatrics. When this Vairagya-sharpened dagger strikes, the slavery of millions of lifetimes is butchered to dust in a single microsecond.
        """.trimIndent()
    ),
    KshurikaShloka(
        id = 25,
        sanskrit = "अमृतत्वं समाप्नोति यदा कामात्स मुच्यते । सर्वैषणाविनिर्मुक्तश्छित्त्वा तं तु न बध्यत इत्युपनिषत् ॥ २५ ॥",
        hindi = """
            (अमृतत्व की प्राप्ति और उपनिषद का महा-निष्कर्ष): यह इस प्रलयंकारी उपनिषद का अंतिम और सबसे बड़ा विस्फोट है!
            "इंसान साक्षात 'अमरता' (अमृतत्वं) को उसी पल प्राप्त (समाप्नोति) कर लेता है, जिस पल वह अपने मन की 'वासनाओं और लालच' (कामात्) से पूरी तरह आज़ाद (मुच्यते) हो जाता है!"
            "दुनिया की सभी भयंकर इच्छाओं (पैसे की इच्छा, संतान की इच्छा, स्वर्ग की इच्छा) से पूरी तरह मुक्त होकर (सर्वैषणाविनिर्मुक्तः)..."
            "...ज्ञान के इस छुरे से अज्ञान को काटने वाला योगी फिर कभी इस संसार में नहीं फँसता (न बध्यते)।"
            यहीं पर यह महान और रौंगटे खड़े कर देने वाला 'क्षुरिका उपनिषद' पूर्ण रूप से समाप्त होता है (इत्युपनिषत्)!
            मोक्ष के लिए तुम्हें मरने का इंतज़ार नहीं करना है। जिस सेकंड तुम्हारे दिमाग से वासना (Lust/Desire) का कीड़ा हमेशा के लिए मर गया, उसी सेकंड तुम भगवान (अमर) बन गए!
            यह उपनिषद इंसानियत के लिए सबसे बड़ा हथियार (क्षुरिका) है; जो इसे चलाएगा, वह दुनिया का मालिक बन जाएगा। ॐ शांति!
        """.trimIndent(),
        english = """
            (The Attainment of Immortality and the Absolute Climax): This is the final, apocalyptic nuclear detonation of this terrifying Upanishad!
            "A human violently and instantly achieves explicit 'Immortality' (Amritatvam samapnoti) the exact microsecond he is absolutely liberated (Muchyate) from the toxic infection of 'Lust and Desire' (Kamat)!"
            "Having violently purged himself completely from all absolute earthly cravings (Sarvaishana-vinirmuktah - the lust for wealth, biology, and heaven)..."
            "...The Yogi who amputates his cosmic ignorance with this Dagger is never, ever trapped in this matrix again (Na badhyate)."
            Exactly here, this spine-chilling, lethal, and supreme 'Kshurika Upanishad' achieves its absolute completion (Ityupanishat)!
            You absolutely do not have to wait for biological death to attain Moksha. The precise microsecond the parasite of Lust/Desire drops dead in your brain, you instantaneously mutate into the Immortal God!
            This Upanishad is the ultimate cosmic Weapon (Kshurika) handed to humanity; whoever wields it, seizes the absolute throne of the Universe. OM Peace!
        """.trimIndent()
    )
)
