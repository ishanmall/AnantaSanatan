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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AdhyayaSeven() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaSevenShlokas.indexOfFirst { it.id == shlokaNum }
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
        // The fully functional Search Bar!
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (1 - 30)") },
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

        // The Scrollable List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(adhyayaSevenShlokas) { _, shloka ->
                // Using the ShlokaCard defined in AdhyayaOne.kt to avoid duplicate errors
                ShlokaCard(shloka)
            }
        }
    }
}

// ALL 30 Shlokas for Chapter 7
val adhyayaSevenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            श्रीभगवानुवाच |
            मय्यासक्तमनाः पार्थ योगं युञ्जन्मदाश्रयः |
            असंशयं समग्रं मां यथा ज्ञास्यसि तच्छृणु || १ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे पार्थ (अर्जुन)! अब तुम यह सुनो कि मुझमें पूरी तरह से आसक्त मन वाला होकर (मय्यासक्तमनाः), केवल मेरी ही शरण लेकर (मदाश्रयः), और योग का अभ्यास करते हुए (योगं युञ्जन्)...
            तुम बिना किसी संशय (असंशयं) के मुझे मेरे पूर्ण (समग्रं) और साक्षात् रूप में किस प्रकार जान लोगे।
            सातवें अध्याय (ज्ञान-विज्ञान योग) की शुरुआत के साथ ही भगवद्गीता का 'गियर' (Gear) पूरी तरह से बदल जाता है। पहले 6 अध्याय 'कर्म' (स्वयं को जानने) पर थे, अब बीच के 6 अध्याय 'भक्ति' (ईश्वर को जानने) पर हैं।
            भगवान श्रीकृष्ण अब एक बहुत ही शक्तिशाली शब्द इस्तेमाल करते हैं: 'मय्यासक्तमनाः' (मुझमें अटैचमेंट/Attachment रखना)।
            अभी तक भगवान ने अर्जुन को हर चीज़ (फल, पैसे, रिश्तों) से 'अनासक्त' (Detached) होना सिखाया था। लेकिन मन कभी खाली नहीं रह सकता। जब आप दुनिया से डिटैच (Detach) होते हैं, तो आपको कहीं न कहीं तो 'अटैच' (Attach) होना पड़ेगा।
            भगवान कहते हैं, "अपने उस खाली मन को अब 'मुझसे' (ईश्वर से) चिपका दो!"
            जब इंसान का मन भगवान के प्यार में 100% आसक्त (Addicted) हो जाता है, और वह केवल भगवान को अपना इकलौता आसरा (मदाश्रयः) मान लेता है...
            तभी वह ईश्वर को 'समग्रं' (पूरी तरह से / 360-डिग्री) जान सकता है। भगवान को केवल किताबी ज्ञान से नहीं, बल्कि पूर्ण समर्पण और प्रेम की 'आसक्ति' से ही बिना किसी डाउट (असंशयं) के जाना जा सकता है।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead declared: O son of Pritha (Partha)! Now hear from Me exactly how, by practicing yoga in full consciousness of Me, with your mind completely attached to Me (Mayy asakta-manah)...
            and making Me your absolute, sole refuge (Mad-ashrayah), you can flawlessly know Me in full (Samagram mam), completely entirely free from all possible doubts (Asamshayam).
            With the dawn of the Seventh Chapter (Jnana-Vijnana Yoga), the 'Gear' of the Bhagavad Gita radically shifts. The first 6 chapters forcefully established 'Karma' (discovering the self); the middle 6 chapters now unveil 'Bhakti' (discovering God).
            Lord Sri Krishna deploys a staggeringly powerful psychological command here: 'Mayy asakta-manah' (Make your mind hopelessly Addicted/Attached to ME).
            Up until this exact point, the Lord violently preached absolute 'Detachment' from everything (money, family, results). But the human mind can never remain in an empty vacuum. When you aggressively detach from the material matrix, you must violently 'Attach' to something else.
            The Lord commands: "Take that newly purified, empty mind and Super-Glue it directly onto ME!"
            When a human's brain becomes 100% attached, deeply obsessed, and passionately in love with God, accepting Him as the absolute sole shelter (Mad-ashrayah)...
            only then can he decode and comprehend the Supreme Lord 'Samagram' (In totality / 360-degrees). God can absolutely never be understood through dry academic books; He reveals Himself entirely, without a microscopic drop of doubt (Asamshayam), only to a mind completely 'Attached' to Him through pure love.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            ज्ञानं तेऽहं सविज्ञानमिदं वक्ष्याम्यशेषतः |
            यज्ज्ञात्वा नेह भूयोऽन्यज्ज्ञातव्यमवशिष्यते || २ ||
        """.trimIndent(),
        hindi = """
            मैं तुम्हारे लिए इस आध्यात्मिक 'ज्ञान' को 'विज्ञान' (साक्षात् अनुभव / Realized knowledge) के सहित पूरी तरह (बिना कुछ छिपाए / अशेषतः) कहूँगा।
            इस परम ज्ञान को जान लेने (यज्ज्ञात्वा) के बाद, इस संसार में तुम्हारे लिए फिर कुछ भी और जानना बाकी नहीं रह जाएगा (नेह भूयोऽन्यज्ज्ञातव्यमवशिष्यते)।
            भगवान श्रीकृष्ण यहाँ ब्रह्मांड के सबसे बड़े ज्ञान का वादा (Promise) कर रहे हैं।
            वे दो अलग-अलग शब्दों का प्रयोग करते हैं: 'ज्ञान' और 'विज्ञान'।
            'ज्ञान' (Knowledge) का अर्थ है थियोरेटिकल (Theoretical) ज्ञान—जैसे किताबों में पढ़ना कि "आग गर्म होती है।" 'विज्ञान' (Vijnana/Wisdom) का अर्थ है प्रैक्टिकल (Practical) अनुभव—जैसे अपनी उंगली आग में डालकर वास्तव में महसूस करना कि आग जलाती है।
            भगवान कह रहे हैं कि मैं तुम्हें केवल थ्योरी (Theory) नहीं पढ़ाऊंगा, बल्कि तुम्हें ईश्वर का साक्षात् 'एक्सपीरियंस' (Experience) भी कराऊंगा।
            और यह ज्ञान कैसा होगा? "अशेषतः"—यानी इसमें कोई फिल्टर (Filter) या सेंसरशिप (Censorship) नहीं होगी। मैं तुम्हें ब्रह्मांड का पूरा 'मास्टर-कोड' (Master-code) दे दूँगा।
            इस ज्ञान की ताकत इतनी भयंकर है कि एक बार इसे डिकोड (Decode) कर लेने के बाद, इंसान के दिमाग में दुनिया का कोई भी सवाल नहीं बचता।
            चाहे विज्ञान हो, फिलॉसफी हो या ब्रह्मांड के रहस्य, जब इंसान उस 'एक' (ईश्वर) को जान लेता है जिससे सब कुछ बना है, तो उसे बाकी सब कुछ अपने आप समझ में आ जाता है। उसके लिए जानने को कुछ शेष (बाकी) नहीं रहता।
        """.trimIndent(),
        english = """
            I shall now declare unto you completely, without holding anything back (Asheshatah), both phenomenal theoretical knowledge (Jnanam) and absolute realized spiritual wisdom (Sa-vijnanam).
            By profoundly knowing this (Yaj jnatva), there shall absolutely remain nothing further to be known by you in this entire universe (Neha bhuyo 'nyaj jnatavyam avashishyate).
            Lord Sri Krishna is making the absolute greatest, most mind-bending pedagogical promise in the history of the cosmos here.
            He deliberately employs two highly distinct terms: 'Jnana' and 'Vijnana'.
            'Jnana' (Knowledge) signifies theoretical, academic data—like reading in a chemistry textbook that "Fire burns." 'Vijnana' (Realized Wisdom) is the hardcore, practical, experiential truth—like actually thrusting your physical finger into the blazing fire and directly experiencing the burn.
            The Lord guarantees: I will absolutely not just lecture you on dry theory; I will inject the direct, explosive 'Experience' of the Supreme Godhead straight into your consciousness.
            And how will this be delivered? "Asheshatah"—Meaning with zero filters, zero censorship, and nothing held back. I will hand you the ultimate 'Master-Code' of the universe.
            The sheer staggering power of this specific knowledge is that once a human successfully downloads it, his brain hits an absolute culmination.
            Whether it is quantum physics, deep philosophy, or the secrets of the galaxy—when a human finally understands the 'One' Source from which everything emanates, he automatically understands everything else. Absolutely zero questions remain to be asked.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            मनुष्याणां सहस्रेषु कश्चिद्यतति सिद्धये |
            यततामपि सिद्धानां कश्चिन्मां वेत्ति तत्त्वतः || ३ ||
        """.trimIndent(),
        hindi = """
            हज़ारों मनुष्यों में से कोई एक ही मनुष्य आध्यात्मिक पूर्णता (सिद्धि/मोक्ष) प्राप्त करने का सच्चा प्रयास (यतति) करता है।
            और इस प्रकार प्रयास करके सिद्धि प्राप्त करने वाले उन हजारों योगियों में से भी, मुश्किल से कोई एक ही मुझे वास्तव में 'तत्त्व' (सच्चाई) से जान पाता है (मां वेत्ति तत्त्वतः)।
            भगवान श्रीकृष्ण यहाँ आध्यात्मिक सफलता (Spiritual Success) की एक बहुत ही चौंकाने वाली 'कठोर सच्चाई' (Harsh Reality / Statistical truth) बता रहे हैं।
            दुनिया की ज़्यादातर आबादी (99.9%) केवल चार कामों में लगी है: खाना, सोना, बच्चे पैदा करना और पैसे के पीछे भागना।
            लाखों-करोड़ों लोगों में से मुश्किल से कोई 'एक' इंसान ऐसा होता है जो इन जानवरों वाले कामों से ऊपर उठकर 'मोक्ष' या 'सच्चाई' ढूँढने की कोशिश ('यतति') करता है।
            लेकिन बात यहीं खत्म नहीं होती! जो हजारों लोग हिमालय जाकर या मंदिरों में बैठकर 'सिद्धि' (योग या ध्यान) का प्रयास कर भी रहे हैं...
            उन हजारों तपस्वियों और योगियों में से भी मुश्किल से कोई एक विरला ही होता है जो भगवान श्रीकृष्ण के 'असली तत्त्व' (कि वे साक्षात् परमेश्वर हैं, कोई आम इंसान नहीं) को गहराई से समझ पाता है।
            ज़्यादातर योगी केवल निराकार ब्रह्म (ज्योति) या जादुई शक्तियों (Siddhis) तक पहुँच कर रुक जाते हैं। भगवान के व्यक्तिगत 'साकार रूप' (Personal Form) को जानना इस ब्रह्मांड की सबसे दुर्लभ (Rarest of the rare) अचीवमेंट (Achievement) है।
        """.trimIndent(),
        english = """
            Out of many, many thousands of ordinary men (Manushyanam sahasreshu), hardly one actually endeavors for spiritual perfection (Kashchid yatati siddhaye).
            And even among those thousands of perfected yogis who have successfully endeavored, hardly one truly and flawlessly knows Me in absolute truth (Kashchin mam vetti tattvatah).
            Lord Sri Krishna drops an incredibly shocking, statistically brutal 'Harsh Reality' regarding the extreme rarity of ultimate spiritual success here.
            The overwhelming, tragic vast majority (99.9%) of the human population operates purely on basic biological animal instincts: aggressively hoarding money, eating, sleeping, and mating.
            Out of millions of such ignorant mortals, barely 'One' exceptional individual awakens, violently rejects the matrix, and actively 'Endeavors' (Yatati) to achieve ultimate perfection (Moksha).
            But the terrifying cosmic filtering does not end there! Out of thousands of elite, highly disciplined ascetics and Yogis who actually meditate in the freezing Himalayas or temples...
            barely one ultra-rare, singular Grandmaster successfully cracks the final code and profoundly realizes the absolute 'Truth' (Tattvatah)—that Sri Krishna is not just an ordinary historical human, but the Supreme Personality of Godhead Himself.
            Most Yogis plateau and stop upon merely experiencing the formless, blinding light of God (Brahman) or acquiring cheap mystical powers (Siddhis). Penetrating that light to truly 'Know' and love the personal, original form of the Supreme Lord is the absolute rarest achievement in existence.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            भूमिरापोऽनलो वायुः खं मनो बुद्धिरेव च |
            अहङ्कार इतीयं मे भिन्ना प्रकृतिरष्टधा || ४ ||
        """.trimIndent(),
        hindi = """
            पृथ्वी (भूमि), जल (आपः), अग्नि (अनलः), वायु (वायुः), आकाश (खं), मन (मनः), बुद्धि (बुद्धिः) और अहंकार (अहङ्कारः)—
            इस प्रकार यह आठ (अष्टधा) प्रकार से विभाजित (भिन्ना) हुई मेरी अपनी ही 'भौतिक प्रकृति' (अपरा/जड़ प्रकृति) है।
            यहाँ से भगवान श्रीकृष्ण 'क्वांटम फिजिक्स' (Quantum Physics) और सृष्टि के निर्माण (Creation of Universe) का सबसे महान वैज्ञानिक ज्ञान दे रहे हैं।
            वे बताते हैं कि यह पूरी की पूरी भौतिक दुनिया (Material World)—चाहे वह बड़े-बड़े ग्रह हों, तारे हों, या आपका अपना शरीर हो—केवल 'आठ' बुनियादी तत्वों (8 Basic Elements) से मिलकर बनी है।
            इन 8 तत्वों में से 5 'स्थूल' (Gross/Physical) तत्व हैं जिन्हें हम देख या महसूस कर सकते हैं: पृथ्वी (Solid), जल (Liquid), अग्नि (Plasma/Heat), वायु (Gas), और आकाश (Space/Vacuum)। आधुनिक विज्ञान (Modern Science) भी मुख्य रूप से इन्हीं 5 चीज़ों पर काम करता है।
            लेकिन भगवान 3 और अत्यंत सूक्ष्म (Subtle/Invisible) तत्व बताते हैं जिन्हें आज तक कोई माइक्रोस्कोप (Microscope) नहीं देख पाया है: मन (Mind), बुद्धि (Intelligence), और अहंकार (False Ego - 'मैं यह शरीर हूँ' की भावना)।
            ये आठों चीज़ें मिलकर भगवान की 'अपरा प्रकृति' (Inferior/Material Energy) बनाती हैं।
            यह समझना बहुत जरूरी है कि इंसान का 'मन' और 'बुद्धि' कोई आध्यात्मिक चीज़ (आत्मा) नहीं है; वे भी 'मिट्टी और पानी' की तरह भगवान की एक मेकेनिकल (Mechanical/Jada) भौतिक ऊर्जा ही हैं। असली 'हम' (आत्मा) इन 8 चीज़ों से बिल्कुल अलग हैं!
        """.trimIndent(),
        english = """
            Earth (Bhumir), water (Apah), fire (Analo), air (Vayuh), ether/space (Kham), mind (Manah), intelligence (Buddhir), and false ego (Ahankarah)—
            all these strictly together comprise exactly My separated, eightfold (Ashtadha) inferior material energies (Prakritih).
            From this exact point, Lord Sri Krishna begins downloading the absolute supreme scientific knowledge of 'Cosmic Quantum Physics' and Universal Creation into Arjuna's mind.
            He ruthlessly deconstructs this entire, unfathomably massive Material Matrix—whether it is gigantic galaxies, blazing stars, or your very own physical body—proving it is all manufactured entirely from just 'Eight' basic, foundational building blocks.
            Out of these 8 elements, 5 are 'Gross/Physical' components that can be empirically perceived: Earth (Solid), Water (Liquid), Fire (Plasma/Thermal energy), Air (Gas), and Ether (Space/Vacuum). Modern empirical science primarily operates strictly within these 5 observable domains.
            But the Lord reveals 3 more incredibly 'Subtle/Invisible' elements that no high-tech electron microscope has ever captured: Mind (Manas), Intelligence (Buddhi), and False Ego (Ahankara - the toxic software generating the "I am this physical body" illusion).
            These exact 8 components collectively form God's 'Apara Prakriti' (The Inferior, Dead Material Energy/Hardware).
            It is absolutely critical to realize here that a human's 'Mind' and 'Intelligence' are NOT spiritual (they are not the soul); they are merely invisible, mechanical, dead material energies exactly like dirt and water. The true 'We' (the eternal Soul) is entirely separate from these 8 elements!
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            अपरेयमितस्त्वन्यां प्रकृतिं विद्धि मे पराम् |
            जीवभूतां महाबाहो ययेदं धार्यते जगत् || ५ ||
        """.trimIndent(),
        hindi = """
            हे महाबाहु (अर्जुन)! यह आठ तत्वों वाली भौतिक प्रकृति (जिसका मैंने अभी वर्णन किया) तो 'अपरा' (निम्न या जड़ / Inferior) प्रकृति है।
            परंतु इसके अलावा तुम मेरी एक दूसरी 'परा' (श्रेष्ठ और चेतन / Superior) प्रकृति को जानो (विद्धि मे पराम्), जो 'जीवात्मा' (जीवभूतां) के रूप में है, और जिसके द्वारा यह सम्पूर्ण जगत (ब्रह्मांड) धारण किया जाता है (चलाया जा रहा है)।
            चौथे श्लोक में भगवान ने मशीन (Hardware/भौतिक शरीर) के बारे में बताया था। लेकिन बिना करंट (Electricity) के कोई मशीन नहीं चलती।
            इस श्लोक में भगवान उस 'चेतन शक्ति' (Conscious Energy) का रहस्य खोल रहे हैं।
            वे कहते हैं कि मिट्टी, पानी और यहाँ तक कि तुम्हारा मन और बुद्धि भी 'जड़' (Dead matter / अपरा) हैं। उनमें खुद से सोचने या हिलने की कोई ताकत नहीं है।
            लेकिन इन मरी हुई चीजों (शरीर) के अंदर जो चीज़ 'जान' (Life) डालती है, वह भगवान की 'परा प्रकृति' (Superior Energy) है। और वह सुप्रीम एनर्जी क्या है? 'जीवभूतां' (हम और आप यानी आत्माएं / The living entities)।
            हम आत्माएं भगवान की ही सुप्रीम ऊर्जा (Supreme energy) का एक छोटा सा अंश हैं।
            "ययेदं धार्यते जगत्"—यह बहुत बड़ी लाइन है। इसका मतलब है कि यह पूरा भौतिक ब्रह्मांड (चाँद, तारे, शहर, मशीनें) केवल इसलिए चल रहा है क्योंकि हम 'चेतन आत्माएं' (Conscious souls) इसका उपयोग कर रही हैं। अगर दुनिया से सारी आत्माएं (परा प्रकृति) निकल जाएं, तो यह पूरा ब्रह्मांड एक सेकंड में मिट्टी के ढेर की तरह बेकार होकर गिर जाएगा।
            हम (आत्मा) इस शरीर को चला रहे हैं, न कि शरीर हमें चला रहा है।
        """.trimIndent(),
        english = """
            O mighty-armed Arjuna! Besides this inferior, dead material nature (Apareyam), you must understand that there is another, completely distinct, and highly superior energy of Mine (Prakritim param).
            This superior energy strictly comprises the conscious living entities (Jiva-bhutam) who are actively exploiting the resources of this material, inferior nature and by whom this entire universe is sustained (Yayedam dharyate jagat).
            In the 4th verse, the Lord mapped out the completely dead 'Hardware' (The physical body/Universe). But absolutely no highly complex machine can ever function without a power source (Electricity).
            In this spectacular verse, the Lord unveils the absolute secret of the 'Conscious Energy' that powers the matrix.
            He declares that dirt, water, and even your highly complex mind and intelligence are entirely 'Jada' (Dead, inferior matter / Apara). They possess absolutely zero independent ability to think, move, or feel.
            But the exact, divine substance that injects blinding 'Life' and consciousness into these dead machines is God's 'Para Prakriti' (The Superior, Anti-material Energy). And what exactly is this supreme energy? 'Jiva-bhutam' (We, the eternal individual souls / the living entities).
            We, the conscious souls, are direct, microscopic sparks of the Supreme Lord's own ultimate energy.
            "Yayedam dharyate jagat"—This is an explosive statement. It profoundly means that this entire gigantic material cosmos (cities, planets, computers) is operating and sustained exclusively because we 'Conscious Souls' are exploiting and driving it. If every single soul (Para Prakriti) evacuated the universe right now, the entire cosmos would instantly collapse into a useless pile of dead dirt.
            WE (the soul) are driving the biological body; the body is absolutely not driving us.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            एतद्योनीनि भूतानि सर्वाणीत्युपधारय |
            अहं कृत्स्नस्य जगतः प्रभवः प्रलयस्तथा || ६ ||
        """.trimIndent(),
        hindi = """
            तुम यह भली-भांति जान लो (उपधारय) कि ब्रह्मांड के सभी प्राणी और वस्तुएं (सर्वाणि भूतानि) केवल इन्हीं दोनों (अपरा और परा) प्रकृतियों से ही उत्पन्न होते हैं (एतद्योनीनि)।
            इस प्रकार, मैं (परमेश्वर) ही इस सम्पूर्ण जगत (ब्रह्मांड) की उत्पत्ति (प्रभवः / Creator) का मूल कारण हूँ, और मैं ही इसका पूर्ण विनाश (प्रलयः / Destroyer) हूँ।
            यह श्लोक 'कॉस्मोलॉजी' (Cosmology/सृष्टि विज्ञान) का अंतिम निष्कर्ष (Final Conclusion) है।
            भगवान श्रीकृष्ण स्पष्ट करते हैं कि दुनिया का हर जीव—चाहे वह एक कीड़ा हो, कोई इंसान हो, या स्वर्ग का देवता हो—वह केवल दो ही चीज़ों का कॉम्बिनेशन (Combination / मिश्रण) है: 
            १. 'जड़' शरीर (मिट्टी, मन, पानी - अपरा प्रकृति) और २. 'चेतन' आत्मा (परा प्रकृति)।
            इन दो ऊर्जाओं (Energies) के बाहर इस ब्रह्मांड में और कुछ भी मौजूद नहीं है।
            और सबसे बड़ा धमाका (Revelation) भगवान अंतिम लाइन में करते हैं: "ये दोनों ऊर्जाएं कहाँ से आती हैं? मुझसे!"
            भगवान कहते हैं, "अहं कृत्स्नस्य जगतः प्रभवः"—अर्थात् इस पूरे ब्रह्मांड (मैटर और आत्मा दोनों) का असली 'सोर्स कोड' (Source Code / जनक) केवल 'मैं' (श्रीकृष्ण) हूँ। मेरे बिना एक अणु (Atom) भी नहीं बन सकता।
            और जब समय पूरा होता है, तो यह पूरा ब्रह्मांड वापस 'मुझमें' ही विलीन होकर नष्ट (प्रलय) हो जाता है।
            यह श्लोक साबित करता है कि श्रीकृष्ण कोई अवतार या देवता नहीं हैं; वे साक्षात् 'सुप्रीम क्रिएटर' (Supreme Creator) और ब्रह्मांड के परम पिता हैं।
        """.trimIndent(),
        english = """
            You should flawlessly understand and conclude (Upadharaya) that absolutely all created beings (Sarvani bhutani) have their source of birth and existence strictly within these two distinct natures (Etad-yonini).
            Of all that is material and of all that is spiritual in this entire cosmos, know for certain that I am the absolute original source of creation (Prabhavah) and the ultimate end of dissolution (Pralayah).
            This staggering verse is the absolute 'Final Conclusion' of all cosmic science and universal Cosmology.
            Lord Sri Krishna makes it undeniably clear that absolutely every single entity in existence—whether it is a microscopic bacteria, a human being, or a highly powerful celestial demigod—is strictly a hybrid combination of exactly two things:
            1. The 'Dead' biological hardware (dirt, mind, water - Apara Prakriti) and 2. The 'Conscious' software driver (The Soul - Para Prakriti).
            Outside the absolute combination of these two energies, absolutely nothing else exists in the matrix.
            And the Lord drops the ultimate, explosive Revelation in the final line: "Where exactly do both these massive energies originate from? FROM ME!"
            The Lord declares, "Aham kritsnasya jagatah prabhavah"—meaning, "I (Sri Krishna) am the absolute, original 'Source Code' and Supreme Creator of this entire cosmos (both the material matter and the spiritual souls). Without Me, not a single atom can manifest."
            And when the cosmic timer expires, this entire gigantic universe violently collapses and dissolves entirely back into ME (Pralaya).
            This monumental verse definitively proves that Sri Krishna is not merely a saint, an avatar, or a demigod; He is explicitly declaring Himself to be the 'Absolute Supreme Creator' and Ultimate Father of the multiverse.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            मत्तः परतरं नान्यत्किञ्चिदस्ति धनञ्जय |
            मयि सर्वमिदं प्रोतं सूत्रे मणिगणा इव || ७ ||
        """.trimIndent(),
        hindi = """
            हे धनञ्जय (अर्जुन)! इस ब्रह्मांड में मेरे अतिरिक्त (मुझसे ऊपर) दूसरा कोई भी परम सत्य या कारण (परतरं नान्यत् किञ्चिद्) बिल्कुल भी नहीं है।
            जिस प्रकार धागे में गूंथे हुए मोतियों के दाने (सूत्रे मणिगणा इव) उस धागे पर ही टिके होते हैं, ठीक उसी प्रकार यह संपूर्ण ब्रह्मांड और उसकी हर चीज़ केवल मुझमें ही गुंथी हुई (पिरोई हुई / प्रोतम्) है।
            यह भगवद्गीता के सबसे महान, सबसे प्रसिद्ध और सबसे खूबसूरत श्लोकों में से एक है। भगवान यहाँ अपनी 'सर्वोच्चता' (Absolute Supremacy) की घोषणा कर रहे हैं।
            दुनिया में बहुत से दार्शनिक (Philosophers) बहस करते हैं कि कृष्ण के ऊपर भी कोई 'निराकार शक्ति' (Formless energy) या 'शून्य' है। श्रीकृष्ण इस थ्योरी (Theory) को एक ही झटके में काट देते हैं।
            वे स्पष्ट कहते हैं: "मत्तः परतरं नान्यत्"—अर्थात् मेरे ऊपर (Beyond Me) कोई और ईश्वर, कोई और ऊर्जा या कोई और सच्चाई है ही नहीं। मैं ही 'अल्टीमेट फुल-स्टॉप' (Ultimate Full-stop) हूँ।
            इसे समझाने के लिए वे मोतियों की माला (Necklace of Pearls) का दुनिया का सबसे बेहतरीन उदाहरण देते हैं।
            जब आप एक मोतियों की माला देखते हैं, तो आपको बाहर से केवल चमकते हुए मोती (यानी दुनिया के ग्रह, तारे, इंसान) दिखाई देते हैं। लेकिन उन सारे मोतियों को गिरने और बिखरने से कौन रोक रहा है? वह 'अदृश्य धागा' (Invisible Thread) जो उन सबके अंदर से गुजर रहा है!
            भगवान कह रहे हैं कि मैं ही वह अदृश्य धागा हूँ। यह पूरी दुनिया (मोती) केवल मेरी ही शक्ति (धागे) पर टिकी है। अगर मैं अपना धागा खींच लूँ, तो यह पूरा ब्रह्मांड एक सेकंड में बिखर कर नष्ट हो जाएगा।
        """.trimIndent(),
        english = """
            O conqueror of wealth (Dhananjaya)! There is absolutely no truth, no force, and no entity superior to or beyond Me (Mattah parataram nanyat kinchid asti).
            Everything that completely exists in this entire cosmos rests entirely upon Me (Mayi sarvam idam protam), exactly as millions of glittering pearls are strung perfectly on a single, invisible thread (Sutre mani-gana iva).
            This is universally celebrated as one of the most majestic, most famous, and breathtakingly beautiful verses in the entire Bhagavad Gita. The Lord is officially stamping His 'Absolute Supremacy' over the cosmos.
            Many arrogant philosophers and ignorant scholars debate that there must be some 'Formless void' or 'Mystical energy' that is higher or superior to the personal form of Krishna. Sri Krishna violently crushes this fake theory in a single blow.
            He bluntly declares: "Mattah parataram nanyat"—meaning there is absolutely NO God, NO energy, and NO higher truth operating beyond Me. I am the absolute, final 'Ultimate Full-Stop' of all existence.
            To brilliantly illustrate this staggering cosmic engineering, He provides the world's most flawless analogy: The Necklace of Pearls.
            When you look at a stunning pearl necklace, your physical eyes only see the glittering, beautiful pearls (representing all the planets, stars, humans, and demigods in the universe). But what exactly stops those millions of pearls from violently scattering and crashing to the floor? It is the 'Invisible Thread' running silently through the core of every single pearl!
            The Lord reveals: I am that exact invisible, underlying Thread. This entire gigantic universe (the pearls) is suspended and resting entirely on My absolute power (the Thread). If I simply pull My thread back, this entire multiverse will instantly violently scatter into non-existence.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            रसोऽहमप्सु कौन्तेय प्रभास्मि शशिसूर्ययोः |
            प्रणवः सर्ववेदेषु शब्दः खे पौरुषं नृषु || ८ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! मैं ही जल (पानी) का 'स्वाद' (रस) हूँ; मैं ही सूर्य और चंद्रमा का प्रकाश (प्रभा) हूँ;
            मैं ही सम्पूर्ण वेदों में 'ॐ' (प्रणव/Om) कार हूँ; मैं ही आकाश (ईथर) में गूंजने वाला 'शब्द' (ध्वनि) हूँ; और मैं ही मनुष्यों में उनका 'पौरुष' (बल/सामर्थ्य) हूँ।
            भगवान श्रीकृष्ण अर्जुन को यह सिखा रहे हैं कि एक आम इंसान अपनी रोज़मर्रा की ज़िंदगी में भगवान को कैसे 'देख' (Perceive) और 'महसूस' कर सकता है।
            भगवान कोई ऐसी चीज़ नहीं हैं जो सिर्फ मंदिरों में बैठे हों; वे हर चीज़ का 'मूल तत्व' (Essence) हैं।
            १. पानी पीते समय जो प्यास बुझाने वाला 'स्वाद' (रस) है, वह कोई केमिकल नहीं, वह साक्षात् कृष्ण हैं। अगर पानी में से 'रस' निकाल दो, तो पानी का वजूद ही खत्म हो जाएगा।
            २. जब तुम सूरज या चाँद की रोशनी (प्रभा) देखते हो, तो वह लाइट बल्ब नहीं है, वह सीधे ईश्वर की चमक है।
            ३. जब कोई मंत्र पढ़ा जाता है, तो उसमें जो सबसे पवित्र वाइब्रेशन (Vibration) 'ॐ' है, वह भगवान का ही 'साउंड फॉर्म' (Sound Form) है।
            ४. अंतरिक्ष (Space/आकाश) में जो 'ध्वनि' (Sound waves) ट्रैवल करती है, वह शक्ति भी ईश्वर है।
            ५. और जब तुम किसी इंसान में कोई बहुत बड़ा 'टैलेंट' (Talent), बहादुरी या मेहनत करने की ताकत (पौरुष) देखते हो, तो उस इंसान की तारीफ मत करो, क्योंकि वह टैलेंट भी वास्तव में भगवान का ही है।
            भगवान अर्जुन से कह रहे हैं: "तुम्हें मुझे ढूँढने के लिए हिमालय जाने की ज़रूरत नहीं है। अपनी आँखें खोलो, दुनिया की हर श्रेष्ठ और मूल चीज़ में मैं ही मौजूद हूँ।"
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya)! I am the original, quenching taste of water (Raso 'ham apsu), and I am the blinding, illuminating light of both the sun and the moon (Prabhasmi shashi-suryayoh).
            I am the sacred syllable Om (Pranavah) in all the Vedic mantras; I am the original sound in ether/space (Shabdah khe), and I am the unparalleled ability and prowess in human beings (Paurusham nrishu).
            Lord Sri Krishna is profoundly teaching Arjuna exactly how an ordinary human being can literally 'See' and 'Perceive' the Supreme Godhead functioning dynamically in everyday, ordinary life.
            God is absolutely not just an idle statue locked inside a temple building; He is the absolute 'Core Essence' (Operating Principle) of everything that exists.
            1. When you drink a glass of water, that profoundly satisfying, thirst-quenching 'Taste' (Rasa) is not a random chemical reaction; it is literally Krishna Himself. If you surgically extract 'taste' from water, water completely ceases to exist.
            2. When you look up and are blinded by the roaring light (Prabha) of the sun or the soothing glow of the moon, you are literally looking at the direct illumination of God.
            3. Whenever any highly complex Vedic mantra is chanted, the supreme, vibrating seed-syllable 'OM' (Pranava) at its core is the direct 'Sound Avatar' of the Lord.
            4. The very fundamental physics that allows 'Sound' waves to travel through the vacuum of Space (Ether) is powered exclusively by God.
            5. And when you witness a human being displaying staggering, superhuman 'Talent', bravery, or intense capability (Paurusha) in any field, do not blindly worship that human's ego. That magnificent talent is literally a borrowed spark of God's own ability.
            The Lord is commanding Arjuna: "You do not need to escape to a freezing mountain to find Me. Open your eyes; I am physically and spiritually present as the absolute essence of everything glorious around you."
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            पुण्यो गन्धः पृथिव्यां च तेजश्चास्मि विभावसौ |
            जीवनं सर्वभूतेषु तपश्चास्मि तपस्विषु || ९ ||
        """.trimIndent(),
        hindi = """
            मैं ही इस पृथ्वी (मिट्टी) की अत्यंत पवित्र और मूल 'सुगंध' (पुण्यो गन्धः) हूँ; और मैं ही अग्नि (आग) का 'तेज' (ताप या गर्मी) हूँ।
            मैं ही इस ब्रह्मांड के सभी प्राणियों का 'जीवन' (प्राण / Life-force) हूँ; और मैं ही सभी तपस्वियों (योगियों) की 'तपस्या' (सहनशीलता की शक्ति) हूँ।
            भगवान अपनी सर्वव्यापकता (All-pervasiveness) के कुछ और अत्यंत सुंदर और गहरे उदाहरण (Examples) दे रहे हैं।
            १. 'पुण्यो गन्धः': जब पहली बारिश सूखी मिट्टी पर गिरती है, तो जो एक बहुत ही पवित्र, मीठी और मूल 'सोंधी खुशबू' आती है, वह खुशबू कोई केमिकल परफ्यूम (Chemical Perfume) नहीं है। वह इस धरती (पृथ्वी) की मूल सुगंध है, और भगवान कहते हैं कि वह 'सुगंध' साक्षात् मैं हूँ।
            २. 'तेजश्चास्मि विभावसौ': आग का काम है जलाना और रोशनी देना (तेज)। अगर आग में से गर्माहट (Heat) निकाल दी जाए, तो आग की कोई वैल्यू नहीं है। आग की वह जलाने की ताकत (Essence) ही ईश्वर है।
            ३. 'जीवनं सर्वभूतेषु': दुनिया के सारे जीव (इंसान, जानवर, पेड़) एक मांस के टुकड़े से ज्यादा कुछ नहीं हैं। उनके अंदर जो चीज़ धड़क रही है, जो 'लाइफ-फोर्स' (Life-force) उन्हें जिंदा रखे हुए है, वह 'जीवन' कृष्ण ही हैं।
            ४. 'तपश्चास्मि तपस्विषु': जब कोई महान साधु हिमालय की ठंड में या भूख में अपनी बॉडी को टॉर्चर (Torture) करके तपस्या करता है, तो लोग उसकी वाहवाही करते हैं कि "क्या ज़बरदस्त विलपावर (Willpower) है!"
            भगवान कहते हैं, उस योगी को घमंड नहीं करना चाहिए, क्योंकि उसके अंदर सर्दी और भूख को सहने की जो 'सहनशक्ति' (तपस्या) है, वह ताकत भी मैं ही हूँ। सब कुछ मेरा ही है।
        """.trimIndent(),
        english = """
            I am the original, pure, and highly sacred fragrance of the earth (Punyo gandhah prithivyam), and I am the blazing heat and brilliant light in the fire (Tejash chasmi vibhavasau).
            I am the essential life-force residing in all living entities (Jivanam sarva-bhuteshu), and I am the supreme penance and fierce austerity within all ascetics (Tapash chasmi tapasvishu).
            The Lord continues to drop mind-bending, spectacular examples detailing exactly how He is 'All-Pervading' (omnipresent) within the deepest architecture of the material matrix.
            1. 'Punyo Gandhah': When the first monsoon raindrops hit the dry, parched soil, that incredibly sacred, sweet, and original 'earthy fragrance' (Petrichor) that emerges is absolutely not a random chemical reaction or artificial perfume. It is the original, pure scent of the Earth element, and the Lord declares, "I am literally that very fragrance."
            2. 'Tejash chasmi vibhavasau': The entire identity of fire relies strictly on its ability to generate heat and light (Tejas). If you successfully hack physics and extract the 'Heat' out of fire, the fire instantly becomes totally worthless. That core burning intensity of the fire is God Himself.
            3. 'Jivanam sarva-bhuteshu': Every single biological entity in the universe (humans, apex predators, microscopic bacteria) is essentially just a rotting sack of meat and chemicals. The exact 'Life-Force' (Jivana) currently making that dead meat breathe, move, and think is the direct presence of Krishna.
            4. 'Tapash chasmi tapasvishu': When a hardcore ascetic sits in the freezing, sub-zero Himalayas for decades without food, ignorant society wildly applauds him, screaming, "What staggering, superhuman willpower!"
            The Lord severely checks that ascetic's ego: The Yogi should absolutely never become arrogant, because the exact titanium 'Willpower and Tolerance' (Tapasya) that allows him to withstand that brutal freezing torture is purely borrowed directly from Me. I am the very essence of everything.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            बीजं मां सर्वभूतानां विद्धि पार्थ सनातनम् |
            बुद्धिर्बुद्धिमतामस्मि तेजस्तेजस्विनामहम् || १० ||
        """.trimIndent(),
        hindi = """
            हे पार्थ (अर्जुन)! तुम मुझे ही संपूर्ण चर-अचर प्राणियों (दुनिया के हर जीव और वस्तु) का 'सनातन बीज' (कभी नष्ट न होने वाला मूल कारण / Original Seed) जानो।
            मैं ही सभी बुद्धिमान (Intelligent) मनुष्यों की 'बुद्धि' (Intelligence) हूँ; और मैं ही सभी तेजस्वी (शक्तिशाली/Brilliant) पुरुषों का 'तेज' (शक्ति) हूँ।
            यह श्लोक सृष्टि के निर्माण (Creation) का सबसे बड़ा सूत्र (Master-code) है।
            दुनिया की हर चीज़ (जैसे एक विशाल बरगद का पेड़) एक बहुत छोटे से 'बीज' (Seed) से पैदा होती है। लेकिन वह पेड़ एक दिन मर जाता है। 
            भगवान कहते हैं कि "बीजं मां सर्वभूतानां सनातनम्"—मैं इस पूरे ब्रह्मांड का वह 'सनातन' (Original & Eternal) बीज हूँ, जिससे यह पूरी दुनिया पैदा हुई है, लेकिन जो बीज खुद कभी नहीं मरता। पूरी सृष्टि कृष्ण नाम के बीज से ही अंकुरित हुई है।
            इसके बाद भगवान इंसानी अहंकार (Human Ego) पर सबसे बड़ी चोट करते हैं:
            दुनिया में लोग अपने दिमाग (IQ/बुद्धि) पर बहुत घमंड करते हैं कि "मैं बहुत बड़ा साइंटिस्ट (Scientist) या बिज़नेसमैन (Businessman) हूँ।" भगवान कहते हैं, तुम्हारे अंदर जो 'लॉजिक' (Logic) या 'आइडिया' (Idea) पैदा करने वाली 'बुद्धि' है, वह तुम्हारी नहीं है, वह 'मैं' (कृष्ण) हूँ।
            और जो लोग अपने 'करिश्मा' (Charisma), फेम (Fame) या ताकत (तेज) पर इतराते हैं (जैसे बड़े-बड़े राजा, एक्टर्स या योद्धा), भगवान कहते हैं कि वह चमक (Aura/तेज) भी साक्षात् 'मैं' ही हूँ।
            यानी तुम्हारे पास जो कुछ भी 'खास' (Special) है, वह तुम्हारा है ही नहीं, वह ईश्वर की दी हुई एक उधार की शक्ति है। इसलिए इंसान को कभी घमंड नहीं करना चाहिए।
        """.trimIndent(),
        english = """
            O son of Pritha (Partha)! Know definitively that I am the absolute, original, and eternal seed of all existences and living entities (Bijam mam sarva-bhutanam viddhi sanatanam).
            I am the pure, razor-sharp intelligence of the highly intelligent (Buddhir buddhimatam asmi), and I am the blinding prowess and brilliance of all powerful, majestic men (Tejas tejasvinam aham).
            This spectacular verse drops the absolute, ultimate 'Master-Code' behind the genesis and creation of the entire multiverse.
            Every single massive structure in the natural world (like a gigantic, towering Banyan tree) originates purely from a microscopic, tiny 'Seed' (Bija). But eventually, that massive tree dies.
            The Lord emphatically declares: "Bijam mam sarva-bhutanam sanatanam"—I am the 'Sanatana' (Absolute Original and Eternal) Seed of this entire universe. The entire cosmos sprouted and expanded directly from Me, yet unlike an earthly seed, I absolutely never perish or diminish.
            Following this, the Lord delivers the most brutal, devastating strike against the arrogant 'Human Ego':
            Ignorant mortals constantly strut around, violently boasting about their high IQ, screaming, "I am a genius scientist, I am a billionaire visionary." The Lord brutally corrects them: The exact 'Intelligence' (Logic/Processing power) sparking those brilliant ideas inside your physical brain is absolutely not yours; it is literally 'ME' (Krishna).
            And those arrogant celebrities, emperors, or fierce warriors who desperately show off their dazzling 'Charisma', fame, and magnetic aura (Tejas), the Lord declares: That blinding brilliance radiating from you is entirely 'ME'.
            Meaning: Absolutely everything that makes you 'Special' or 'Superior' is completely 100% borrowed energy directly from God. Therefore, harboring even a microscopic drop of toxic pride is the height of supreme human stupidity.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            बलं बलवतां चाहं कामरागविवर्जितम् |
            धर्माविरुद्धो भूतेषु कामोऽस्मि भरतर्षभ || ११ ||
        """.trimIndent(),
        hindi = """
            हे भरतवंशियों में श्रेष्ठ (भरतर्षभ)! मैं बलवान (ताकतवर) पुरुषों का वह 'बल' (शक्ति) हूँ, जो 'काम' (वासना) और 'राग' (स्वार्थ/आसक्ति) से पूरी तरह रहित (विवर्जितम्) है।
            और हे अर्जुन! मैं ही सभी प्राणियों (जीवों) के भीतर मौजूद वह 'काम' (इच्छा या यौन संबंध) हूँ, जो 'धर्म' (शास्त्रों के नियमों) के बिल्कुल विरुद्ध (खिलाफ) नहीं है (धर्माविरुद्धो)।
            भगवान श्रीकृष्ण यहाँ ताकत (Power) और कामवासना (Desire/Sex) की सबसे पवित्र और सटीक परिभाषा (Definition) दे रहे हैं।
            १. 'बल' (Strength): दुनिया में ताकतवर लोग अपनी ताकत का इस्तेमाल कमजोरों को लूटने, पैसे कमाने (काम) और अपने स्वार्थ (राग) के लिए करते हैं। वह राक्षसी बल है।
            भगवान कहते हैं, "मैं वह बल नहीं हूँ!" मैं वह 'बल' हूँ जिसका इस्तेमाल एक पुलिसवाला या सैनिक बिना किसी स्वार्थ के, समाज की और कमजोरों की 'रक्षा' करने के लिए करता है। (जैसे अर्जुन का बल)।
            २. 'काम' (Desire/Sex): दुनिया के सारे धर्म 'कामवासना' को पाप मानते हैं। लेकिन श्रीकृष्ण एक बहुत बड़ी और साइंटिफिक (Scientific) बात कहते हैं।
            वे कहते हैं, "मैं ही 'काम' हूँ!" लेकिन कौन सा काम? वह काम (Sex) जो केवल मज़े के लिए या अवैध तरीके (Illegal/Immoral) से नहीं किया गया हो।
            बल्कि वह काम (यौन संबंध) जो 'धर्म के अनुकूल' हो—अर्थात् जो शादी के पवित्र रिश्ते के अंदर, अच्छी और संस्कारी संतान (Family) को जन्म देने के उद्देश्य से किया जाता है। वह वासना पाप नहीं है, वह साक्षात् भगवान का रूप है, क्योंकि उसी से यह दुनिया आगे बढ़ती है।
        """.trimIndent(),
        english = """
            O best of the Bharatas (Bharatarshabha)! I am the supreme strength of the highly strong (Balam balavatam chaham), but solely that strength which is utterly devoid of toxic lust and selfish attachment (Kama-raga-vivarjitam).
            And I am that sex life or pure desire within all living entities (Kamo 'smi bhuteshu) which is entirely un-contradictory to religious principles and prescribed sacred duties (Dharmaviruddho).
            Lord Sri Krishna is executing the absolute most pristine, sacred, and surgically precise definition of 'Power' and 'Sexual Desire' (Lust) here.
            1. 'Bala' (Strength): In the toxic matrix, arrogant, highly powerful men ruthlessly exploit their physical or political strength purely to oppress the weak, hoard billions (Kama), and satisfy their bloated egos (Raga). That is purely demonic strength.
            The Lord clarifies: "I am absolutely NOT that corrupt strength!" I am specifically that pure, titanium 'Strength' deployed by a selfless soldier or a righteous protector strictly to defend the innocent and uphold absolute justice (exactly like the strength Arjuna must use).
            2. 'Kama' (Desire/Sex): Almost all superficial global religions blindly condemn 'Sex' as an inherent, dirty sin. But Sri Krishna drops an incredibly profound, highly scientific truth.
            He boldly declares, "I AM Sex life (Kama)!" But which specific type? Absolutely not the cheap, toxic lust chased merely for animalistic pleasure, adultery, or exploitation.
            I am that sacred, deeply profound sexual desire executed strictly within the sanctified boundaries of religious marriage (Dharma), with the sole, divine purpose of procreating and raising highly cultured, God-conscious children. That specific desire is not a sin; it is the literal manifestation of God ensuring the righteous continuity of the human race.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            ये चैव सात्त्विका भावा राजसास्तामसाश्च ये |
            मत्त एवेति तान्विद्धि न त्वहं तेषु ते मयि || १२ ||
        """.trimIndent(),
        hindi = """
            और जो भी 'सात्त्विक' भाव (शांति, ज्ञान) हैं, जो भी 'राजसिक' भाव (दौड़-धूप, लालच) हैं, और जो भी 'तामसिक' भाव (आलस्य, अज्ञान) हैं...
            तुम यह भली-भांति जान लो कि वे सभी केवल 'मुझसे' (मेरी ही शक्ति से) उत्पन्न होते हैं। परंतु फिर भी, मैं उनके अधीन (उनमें फँसा हुआ) नहीं हूँ, बल्कि वे सब मेरे अधीन (मुझमें) हैं।
            यह श्लोक भगवान की 'सुप्रीम इंडिपेंडेंस' (Supreme Independence / परम स्वतंत्रता) को दर्शाता है।
            दुनिया का हर इंसान या जानवर प्रकृति के इन्हीं तीन गुणों (सत्त्व, रज, तम) के कंट्रोल (Control) में काम करता है। कोई बहुत शांत और ज्ञानी है (सत्त्व), कोई पैसे के लिए दिन-रात भाग रहा है (रजस), और कोई शराब पीकर 12 घंटे सो रहा है (तमस)।
            भगवान कहते हैं कि ये तीनों 'मोड्स' (Modes of Nature / सॉफ्टवेयर) मैंने ही बनाए हैं और ये मेरी ही एनर्जी (Energy) से निकलते हैं।
            लेकिन इंसान में और भगवान में सबसे बड़ा फर्क क्या है?
            "न त्वहं तेषु"—इंसान इन तीन गुणों का गुलाम (Slave) बन जाता है। जब रजोगुण आता है, तो इंसान मजबूरी में लालची हो जाता है; जब तमोगुण आता है, तो इंसान आलसी हो जाता है। इंसान प्रकृति की कठपुतली है।
            लेकिन भगवान कहते हैं कि यद्यपि यह सिस्टम मैंने बनाया है, "मैं इन गुणों के अंदर कैद नहीं हूँ!" ईश्वर कभी आलसी (तमस) या लालची (रजस) नहीं होता।
            "ते मयि"—ये सारे गुण (माया) मेरे 'अंडर' (Under) काम करते हैं। मैं माया का गुलाम नहीं, बल्कि मैं 'मायापति' (मास्टर/Master) हूँ।
        """.trimIndent(),
        english = """
            And you should definitively know that all states of existence—whether they be of the mode of goodness (Sattvika), the mode of passion (Rajasa), or the mode of ignorance (Tamasa)—
            are manifested completely and strictly by My energy alone (Matta eveti tan viddhi). In one absolute sense I am everything, but I am entirely independent. I am absolutely not under the control of these modes of material nature (Na tv aham teshu), for they, on the contrary, are strictly under My control and within Me (Te mayi).
            This spectacular verse vividly demonstrates the absolute, staggering 'Supreme Independence' and ultimate boss-status of the Supreme Lord over His own creation.
            Every single mortal human or animal in the matrix operates completely enslaved under the strict control of these three modes of material nature (Sattva, Rajas, Tamas). One man is serene and philosophical (Sattva), another hustles brutally for billions (Rajas), and another is a toxic, lazy drunkard (Tamas).
            The Lord confirms that He Himself engineered these three 'Modes' (Software algorithms) and they radiate directly from His supreme energy.
            But what is the colossal, infinite difference between a mortal and God?
            "Na tv aham teshu"—A human being becomes a pathetic, helpless 'Slave' to these modes. When the Rajas algorithm triggers, the human is biologically forced to become greedy; when Tamas hits, he collapses into laziness. Man is a literal puppet of nature.
            But the Lord drops the ultimate mic: Although I wrote this code, "I am absolutely NOT trapped inside these modes!" God never ever becomes lazy (Tamas) or greedily passionate (Rajas).
            "Te mayi"—All these powerful modes (Maya) operate strictly 'Under' My supreme command. I am absolutely not the slave of Maya; I am the absolute, undisputed 'Maya-pati' (The Ultimate Master of Illusion).
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            त्रिभिर्गुणमयैर्भावैरेभिः सर्वमिदं जगत् |
            मोहितं नाभिजानाति मामेभ्यः परमव्ययम् || १३ ||
        """.trimIndent(),
        hindi = """
            प्रकृति के इन तीनों गुणों (सत्त्व, रज और तम) के कार्यों (भावों) द्वारा यह पूरा का पूरा संसार (जगत) पूरी तरह से मोहित (भ्रमित / Hypnotized) हो रहा है।
            इसी कारण (मोह के कारण) यह अज्ञानी संसार इन तीनों गुणों से अत्यंत परे (ऊपर) और 'अव्यय' (कभी न बदलने वाले / अविनाशी) मुझ परमेश्वर को बिल्कुल नहीं जान पाता (नाभिजानाति)।
            भगवान श्रीकृष्ण यहाँ यह बता रहे हैं कि दुनिया के 99.9% लोग ईश्वर को क्यों नहीं समझ पाते? उन्हें भगवान दिखाई क्यों नहीं देते?
            इसका कारण है 'माया का इल्यूज़न' (Illusion of Maya)। यह दुनिया एक बहुत बड़े 'थ्री-कलर फ़िल्टर' (3-Color Filter) से ढकी हुई है—सत्त्व, रज और तम।
            हर इंसान सुबह से शाम तक इन्हीं तीन चीज़ों के प्रभाव (Effects) में उलझा रहता है:
            कभी वह बहुत खुश और शांत होता है (सत्त्व), कभी उसे पैसा कमाने और दूसरों को हराने की आग लगी होती है (रजस), और कभी वह दुःख, डिप्रेशन या नशे में डूब जाता है (तमस)।
            इंसान की पूरी ज़िंदगी इन्हीं तीन भावनाओं (Emotions) के चक्रव्यूह में गोल-गोल घूमती रहती है ('मोहितं')। वह इसी को अपनी असली ज़िंदगी (Reality) मान लेता है।
            चूँकि उसका पूरा ध्यान केवल इस 'माया' (सॉफ्टवेयर) पर टिका होता है, इसलिए वह कभी भी इस माया को बनाने वाले उस 'प्रोग्रामर' (Programmer/ईश्वर) को देख ही नहीं पाता।
            भगवान इन तीनों गुणों से 'परम्' (बहुत ऊँचे) और 'अव्यय' (जो कभी नहीं बदलते) हैं। जब तक इंसान इन तीन गुणों के नाटक (Drama) से बाहर नहीं निकलता, वह ईश्वर को नहीं जान सकता।
        """.trimIndent(),
        english = """
            Deluded and entirely hypnotized by the interactions of these three modes of material nature (Tribhir guna-mayair bhavaih), this entire world (Sarvam idam jagat)...
            is completely bewildered and absolutely knows Me not (Mohitam nabhijanati), who am situated completely above and beyond these modes (Param) and who am inexhaustible and imperishable (Avyayam).
            Lord Sri Krishna is profoundly diagnosing the ultimate cosmic tragedy here: Why exactly do 99.9% of all human beings completely fail to understand or even perceive the existence of God?
            The absolute root cause is the 'Illusion of Maya'. This entire material universe is heavily coated by a massive, highly toxic '3-Color Filter'—Sattva (Goodness), Rajas (Passion), and Tamas (Ignorance).
            Every single mortal is violently tangled 24/7 in the extreme emotional roller-coaster generated by these three algorithms:
            Sometimes he feels peaceful and happy (Sattva), sometimes he burns with a frantic, greedy obsession to crush competitors and make billions (Rajas), and sometimes he collapses into toxic depression, laziness, or intoxication (Tamas).
            A human's entire lifespan is brutally exhausted just spinning endlessly in the dizzying vortex of these three emotions ('Mohitam'). He foolishly accepts this pathetic simulation as ultimate 'Reality'.
            Because his entire brain capacity is aggressively hijacked by interacting with this 'Maya' (Software), he absolutely never possesses the bandwidth to perceive the supreme 'Programmer' (God) who actually coded it.
            The Lord is completely 'Param' (infinitely above) and 'Avyayam' (imperishable and unchangeable by these modes). Until a human forcefully breaks out of this cheap, 3-mode 3D Drama, he can absolutely never know the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            दैवी ह्येषा गुणमयी मम माया दुरत्यया |
            मामेव ये प्रपद्यन्ते मायामेतां तरन्ति ते || १४ ||
        """.trimIndent(),
        hindi = """
            प्रकृति के तीनों गुणों (सत्त्व, रज, तम) से बनी हुई यह मेरी 'दैवी माया' (Divine Illusion) अत्यंत पार करने में कठिन (दुरत्यया / Unconquerable) है।
            परंतु जो मनुष्य केवल 'मेरी ही' (ईश्वर की ही) पूरी तरह से शरण लेते हैं (मामेव ये प्रपद्यन्ते), वे इस भयंकर माया के सागर को बहुत आसानी से पार कर जाते हैं (तरन्ति ते)।
            यह पूरी भगवद्गीता के सबसे प्रसिद्ध और सबसे ज्यादा 'होप' (Hope/आशा) देने वाले श्लोकों में से एक है।
            पिछले श्लोक में भगवान ने बताया था कि माया कितनी खतरनाक है। अब वे बता रहे हैं कि इस माया से बाहर निकलने का 'चीट कोड' (Cheat Code) क्या है।
            श्रीकृष्ण एक बहुत ही भयानक सच स्वीकार करते हैं: "मम माया दुरत्यया" (मेरी इस माया को हराना इंसान के बस की बात नहीं है)।
            क्यों? क्योंकि यह माया कोई साधारण जादूगर का खेल नहीं है; यह 'दैवी' (Divine) माया है। इसे खुद भगवान ने बनाया है! अगर आप सोचें कि "मैं अपनी बुद्धिमानी से, अपने पैसों से, या बहुत ध्यान (Meditation) करके अपने अहंकार (माया) को हरा दूँगा", तो आप 100% फेल (Fail) हो जाएंगे। इंसान की ताकत भगवान की माया को नहीं हरा सकती।
            तो फिर इंसान इस चक्रव्यूह से कैसे निकले? 
            भगवान दुनिया का सबसे आसान और सबसे शक्तिशाली फॉर्मूला देते हैं: "सरेंडर" (Surrender / प्रपद्यन्ते)।
            अगर कोई बच्चा समंदर में डूब रहा हो, तो वह खुद तैरकर नहीं बच सकता। लेकिन अगर वह ज़ोर से अपने पिता को पुकारे, तो पिता उसे तुरंत गोदी में उठा लेता है। 
            भगवान कहते हैं, "जो अपना ईगो (Ego) छोड़कर 100% मेरे पैरों में गिर जाता है, मैं खुद आकर उसे इस माया के भयंकर समंदर से बाहर निकाल लेता हूँ।" केवल भगवान ही अपनी माया को हटा सकते हैं।
        """.trimIndent(),
        english = """
            This divine energy of Mine (Daivi hy esha), consisting of the three modes of material nature (Guna-mayi mama maya), is incredibly difficult and practically impossible to overcome (Duratyaya).
            But those who completely and utterly surrender unto Me exclusively (Mam eva ye prapadyante), they can easily cross beyond this terrifying ocean of illusion (Mayam etam taranti te).
            This is universally celebrated as one of the most spectacularly famous and overwhelmingly 'Hope-giving' verses in the entire Bhagavad Gita.
            In the previous verse, the Lord established how terrifyingly inescapable the Matrix of Maya is. Now, He graciously drops the absolute, ultimate 'Cheat-Code' to flawlessly hack and escape it.
            Sri Krishna officially admits a brutally terrifying truth: "Mama maya duratyaya" (It is absolutely biologically and spiritually impossible for a tiny human to defeat My Maya on his own).
            Why? Because this Maya is not some cheap, street-magician's trick; it is 'Daivi' (Divine/Supreme) Maya. It was engineered by the Supreme God Himself! If you arrogantly think, "I will defeat lust, ego, and this matrix using my high IQ, my billions, or by doing severe meditation alone," you will fail 100%. A microscopic human's power cannot defeat God's ultimate software.
            So, how on earth does a mortal escape this inescapable labyrinth?
            The Lord dispenses the universe's easiest yet most powerful master-formula: "Total Surrender" (Prapadyante).
            If a tiny toddler is violently drowning in a raging ocean, he absolutely cannot swim to shore himself. But if he screams and surrenders to his powerful Father, the Father instantly lifts him out of the water.
            The Lord promises, "The exact microsecond a human throws away his toxic ego and surrenders 100% exclusively at My feet, I personally step in and effortlessly lift him right out of this terrifying ocean of Maya." Only God possesses the ultimate clearance code to shut down His own Maya.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            न मां दुष्कृतिनो मूढाः प्रपद्यन्ते नराधमाः |
            माययापहृतज्ञाना आसुरं भावमाश्रिताः || १५ ||
        """.trimIndent(),
        hindi = """
            चार प्रकार के अत्यंत बुरे कर्म करने वाले पापी (दुष्कृतिनः) मेरी शरण में कभी नहीं आते (न प्रपद्यन्ते):
            १. 'मूढ़' (महामूर्ख - जो गधों की तरह केवल मेहनत करते हैं), २. 'नराधम' (मनुष्यों में सबसे नीच), ३. 'मायायापहृतज्ञानाः' (जिनका ज्ञान माया द्वारा पूरी तरह लूट लिया गया है), और ४. 'आसुरं भावमाश्रिताः' (जो असुरों/राक्षसों जैसे स्वभाव वाले हैं)।
            पिछले श्लोक में भगवान ने कहा कि "जो मेरी शरण लेगा, वह माया को पार कर जाएगा।" तो एक स्वाभाविक सवाल उठता है: "फिर दुनिया के सारे लोग भगवान की शरण (Surrender) क्यों नहीं ले लेते?"
            भगवान इसका बहुत ही कड़वा जवाब देते हैं और समाज के 4 सबसे खतरनाक (Toxic) प्रकार के लोगों का 'क्लासिफिकेशन' (Classification) करते हैं, जो कभी भगवान के पास नहीं जाते:
            १. 'मूढ़' (The Fools): ये वे लोग हैं जो गधों (Donkey) की तरह दिन-रात 15 घंटे काम करते हैं, केवल अपना और परिवार का पेट भरने के लिए। इनके पास भगवान या अध्यात्म के बारे में सोचने का समय (Time) ही नहीं है।
            २. 'नराधम' (The Lowest of Mankind): ये वे लोग हैं जिन्हें बहुत अच्छी सोसाइटी (Society) या शिक्षा मिली, लेकिन फिर भी वे अपने मनुष्य जीवन का इस्तेमाल केवल चोरी, भ्रष्टाचार और बुरे कामों में करते हैं।
            ३. 'मायायापहृतज्ञानाः' (The Deluded Intellectuals): ये वे बड़े-बड़े साइंटिस्ट (Scientists) और फिलॉसफर (Philosophers) हैं, जिनके पास दुनिया की बड़ी-बड़ी डिग्रियां (PhD) हैं। लेकिन माया ने उनका दिमाग ऐसा हैक (Hack) किया है कि वे इतने पढ़े-लिखे होकर भी कहते हैं, "भगवान है ही नहीं, दुनिया तो एक एक्सीडेंट (Accident) है।"
            ४. 'आसुरं भावमाश्रिताः' (The Demonic): ये सबसे खतरनाक हैं (जैसे रावण या कंस)। ये जानते हैं कि भगवान है, लेकिन ये खुलेआम भगवान से नफरत (Hate) करते हैं और दुनिया को बर्बाद करना चाहते हैं।
            ये चार प्रकार के 'दुष्कृति' (बुरे इंसान) कभी अपना ईगो (Ego) छोड़कर भगवान के सामने नहीं झुक सकते।
        """.trimIndent(),
        english = """
            Those highly miscreant and grossly foolish people (Dushkritino mudhah) absolutely never surrender unto Me (Na mam prapadyante). They are strictly divided into four categories:
            1. 'Mudhas' (The grossly foolish beasts of burden), 2. 'Naradhamas' (The absolute lowest among mankind), 3. 'Mayayapahrita-jnanah' (Those whose vast knowledge has been entirely stolen by illusion), and 4. 'Asuram bhavam ashritah' (Those who partake of the blatantly atheistic, demonic nature).
            In the previous verse, the Lord offered an open invitation: "Whoever surrenders to Me will easily cross the matrix." This triggers a highly logical question: "Then why doesn't every single human on earth just surrender to God immediately?"
            The Lord delivers a brutally harsh, politically incorrect answer, meticulously profiling the 4 most toxic categories of humans who absolutely refuse to surrender to God:
            1. 'Mudha' (The Fools): These are humans who operate exactly like mindless donkeys. They relentlessly slave away 15 hours a day merely to hoard money, eat, and sleep. Their brain bandwidth is so pathetically low that they literally have 'Zero Time' to even think about spirituality or God.
            2. 'Naradhama' (The Lowest of Mankind): These are humans who were granted the staggeringly rare, supreme opportunity of human birth (and civilized society), yet they completely waste it by acting exactly like animals—engaging solely in corruption, addiction, and immorality, ignoring self-realization entirely.
            3. 'Mayayapahrita-jnanah' (The Deluded Intellectuals): These are the elite, arrogant scientists and philosophers holding massive PhDs. But Maya has completely 'Hijacked' their intelligence so badly that despite their massive education, they arrogantly conclude: "God is a myth; the universe is just a random chemical accident."
            4. 'Asuram bhavam ashritah' (The Demonic): These are the absolute most dangerous (like Ravana or terrorists). They secretly know God exists, but they blatantly 'Hate' Him. They aggressively challenge God's authority and violently desire to rule and destroy the world.
            These 4 categories of 'Dushkritis' (evil-doers) possess egos so massively bloated that they physically and psychologically cannot bend their knees to surrender to God.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            चतुर्विधा भजन्ते मां जनाः सुकृतिनोऽर्जुन |
            आर्तो जिज्ञासुरर्थार्थी ज्ञानी च भरतर्षभ || १६ ||
        """.trimIndent(),
        hindi = """
            हे भरतवंशियों में श्रेष्ठ अर्जुन! चार प्रकार के पुण्य कर्म करने वाले (सुकृतिनः / अच्छे) मनुष्य मेरा भजन (मेरी पूजा या मेरी शरण) करते हैं:
            १. 'आर्तः' (दुःख या संकट में फँसा हुआ व्यक्ति), २. 'जिज्ञासुः' (ईश्वर और सत्य को जानने की तीव्र इच्छा रखने वाला), ३. 'अर्थार्थी' (धन, सफलता या भौतिक चीजों की इच्छा रखने वाला), और ४. 'ज्ञानी' (परम सत्य को जान चुका महापुरुष)।
            पिछले श्लोक में भगवान ने उन 4 बुरे लोगों को बताया जो भगवान के पास 'नहीं' आते। इस श्लोक में भगवान उन 4 प्रकार के अच्छे लोगों (सुकृतिनः) का वर्गीकरण (Classification) कर रहे हैं जो भगवान के पास 'आते' हैं।
            १. 'आर्त' (The Distressed): जब इंसान पर कोई भयंकर मुसीबत आती है (बीमारी, कोर्ट-केस, या गरीबी) और दुनिया के सारे दरवाजे बंद हो जाते हैं, तब वह रोते हुए भगवान को पुकारता है (जैसे गजेंद्र या द्रौपदी ने पुकारा था)।
            २. 'अर्थार्थी' (The Wealth-seeker): यह वह व्यक्ति है जो कोई बिज़नेस डील (Business deal), नौकरी, या बहुत सारा पैसा चाहता है। वह मंदिरों में जाकर मन्नत मांगता है कि "हे भगवान! मेरा यह काम करा दो" (जैसे ध्रुव महाराज ने राज्य माँगा था)।
            ३. 'जिज्ञासु' (The Inquisitive): इस व्यक्ति को कोई दुःख या पैसे की भूख नहीं है। वह एक साइंटिस्ट (Scientist) या दार्शनिक की तरह है जो सच्चाई जानना चाहता है कि "यह दुनिया किसने बनाई? भगवान कौन है? मैं कौन हूँ?"
            ४. 'ज्ञानी' (The Man in Knowledge): यह सबसे टॉप (Top) लेवल का भक्त है। इसे न तो पैसा चाहिए, न ही इसके मन में कोई सवाल (Doubt) बचा है। वह पूरी तरह जान चुका है कि कृष्ण ही परम सत्य हैं, और वह केवल 'प्यार' (Love) के कारण भगवान की पूजा करता है।
            ये चारों ही भगवान की नज़र में 'सुकृति' (पुण्यवान) हैं, क्योंकि इन्होंने अपनी प्रॉब्लम (Problem) सॉल्व (Solve) करने के लिए किसी गलत रास्ते का नहीं, बल्कि 'ईश्वर' का दरवाज़ा खटखटाया है।
        """.trimIndent(),
        english = """
            O best among the Bharatas (Arjuna), four kinds of pious and righteous men (Sukritinah) begin to render devotional service unto Me (Bhajante mam):
            1. The distressed (Artah), 2. The inquisitive searcher for knowledge (Jijnasur), 3. The desirer of material wealth (Artharthi), and 4. The man who is already situated in absolute knowledge of the Absolute Truth (Jnani).
            In stark contrast to the 4 categories of evil fools who aggressively reject God in the previous verse, the Lord now brilliantly profiles the 4 categories of 'Pious' (Sukritinah) humans who actually approach and surrender to God.
            1. 'Arta' (The Distressed): When a human is violently struck by a catastrophic tragedy (a fatal disease, massive bankruptcy, or a lethal threat) and absolutely every earthly door slams shut in his face, he falls to his knees, weeping, and desperately cries out to God for rescue (exactly like Queen Draupadi or Gajendra).
            2. 'Artharthi' (The Wealth-Seeker): This person approaches God entirely as a business partner. He desires a high-paying job, billions of dollars, or a massive political empire. He visits temples and strikes a deal: "O Lord, please grant me this massive wealth" (exactly like the young Dhruva Maharaja).
            3. 'Jijnasu' (The Inquisitive): This person is absolutely not dying of pain, nor does he want cheap money. He operates like a hardcore spiritual scientist. He is consumed by a burning intellectual curiosity: "Who engineered this cosmos? Who exactly is God? What is the soul?"
            4. 'Jnani' (The Man in Knowledge): This is the absolute 'Elite Top-Tier' devotee. He requires zero money from God, and his brain has zero remaining doubts. He possesses the absolute, flawless realization that Krishna is the Supreme Truth, and he worships God entirely and exclusively out of pure, unadulterated 'Love'.
            The Lord generously officially labels all four of them as 'Sukriti' (Highly Pious). Why? Because instead of turning to crime, alcohol, or atheism to solve their massive problems, they correctly chose to knock on the ultimate door of the 'Supreme Lord'.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            तेषां ज्ञानी नित्ययुक्त एकभक्तिर्विशिष्यते |
            प्रियो हि ज्ञानिनोऽत्यर्थमहं स च मम प्रियः || १७ ||
        """.trimIndent(),
        hindi = """
            उन चारों प्रकार के भक्तों में से, वह 'ज्ञानी' भक्त जो हमेशा मुझमें पूरी तरह से लगा हुआ है (नित्ययुक्तः) और जिसकी भक्ति केवल मुझ एक में ही (एकभक्तिः) अनन्य भाव से स्थिर है, वह सबसे अत्यंत श्रेष्ठ (विशिष्यते) है।
            क्योंकि उस ज्ञानी भक्त को मैं अत्यधिक (अत्यर्थं) प्रिय हूँ, और वह ज्ञानी भक्त भी मुझे बहुत अधिक प्रिय है।
            पिछले श्लोक में भगवान ने 4 प्रकार के अच्छे लोग बताए थे जो उनके पास आते हैं। अब भगवान उन चारों में से अपने 'सबसे फेवरेट' (Favorite / V.V.I.P) भक्त की घोषणा कर रहे हैं।
            भगवान स्पष्ट कहते हैं कि 'ज्ञानी' भक्त नंबर 1 (सबसे श्रेष्ठ) है।
            क्यों? क्योंकि जो 'आर्त' (दुःखी) या 'अर्थार्थी' (पैसे का भूखा) भक्त है, उसका भगवान के साथ रिश्ता 'कंडीशनल' (Conditional / शर्तों वाला) होता है। जैसे ही उसका दुःख दूर होगा या उसे पैसा मिल जाएगा, वह शायद भगवान को भूल जाए। उसका फोकस (Focus) भगवान पर कम और अपनी प्रॉब्लम (Problem) पर ज्यादा होता है।
            लेकिन ज्ञानी भक्त का क्या है? वह 'नित्ययुक्त' (हमेशा 24/7 भगवान से जुड़ा हुआ) और 'एकभक्ति' (जिसका प्यार केवल भगवान के लिए है, किसी भौतिक चीज़ के लिए नहीं) होता है।
            ज्ञानी भगवान से कभी कोई 'डिमांड' (Demand / मांग) नहीं करता। वह भगवान से इसलिए प्यार नहीं करता कि भगवान उसे कुछ देंगे; वह केवल इसलिए प्यार करता है क्योंकि भगवान 'भगवान' हैं।
            इसलिए भगवान कहते हैं कि "वह ज्ञानी मुझे सबसे ज़्यादा प्यार करता है, तो 당연 सी बात है कि मैं भी पूरी दुनिया में सबसे ज़्यादा प्यार उसी ज्ञानी भक्त से करता हूँ।" यह 100% प्योर और अनकंडीशनल लव (Pure Unconditional Love) है।
        """.trimIndent(),
        english = """
            Of these four, the one who is situated in full absolute knowledge (Jnani) and who is always constantly engaged in pure devotional service exclusively to Me (Nitya-yukta eka-bhaktir) is undeniably the absolute best and most superior (Vishishyate).
            For I am exceptionally, exceedingly dear (Priyo atyartham) to him, and he is infinitely dear to Me.
            In the previous verse, the Lord listed the 4 categories of pious humans who approach Him. Now, He officially declares His absolute 'Number 1 V.V.I.P. Favorite' among them.
            The Lord emphatically declares that the 'Jnani' (The fully enlightened devotee) is the absolute supreme best (Vishishyate).
            Why? Because the 'Arta' (Distressed) and 'Artharthi' (Wealth-seeker) operate on a highly 'Conditional' and transactional relationship with God. The exact microsecond their massive problem is solved or their bank account is filled, they are highly likely to completely forget God. Their primary focus is 90% on their personal problem and only 10% on God.
            But what about the Jnani? He is 'Nitya-yukta' (permanently plugged into God 24/7) and 'Eka-bhaktir' (his love is 100% singular, exclusive, and unadulterated; he desires absolutely zero material things).
            The Jnani places zero 'Demands' before God. He absolutely does not love God to extract cheap favors; he loves God purely because God is the Supreme Absolute Truth.
            Therefore, the Lord passionately declares: "Because that Jnani loves Me infinitely more than anything else in existence, it is a cosmic guarantee that I love that Jnani more than anyone else in the entire universe." This is the ultimate, flawless state of 100% Pure, Unconditional Love.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            उदाराः सर्व एवैते ज्ञानी त्वात्मैव मे मतम् |
            आस्थितः स हि युक्तात्मा मामेवानुत्तमां गतिम् || १८ ||
        """.trimIndent(),
        hindi = """
            निस्संदेह, ये सभी चारों प्रकार के भक्त अत्यंत उदार (महान और नेक) हैं; परंतु वह 'ज्ञानी' भक्त तो साक्षात् 'मेरी ही आत्मा' (मेरा ही स्वरूप / आत्मैव) है, ऐसा मेरा पक्का मत है।
            क्योंकि वह योग में पूरी तरह स्थिर मन वाला (युक्तात्मा) ज्ञानी भक्त केवल मुझे ही (मामेव) अपनी सर्वोच्च और अंतिम गति (अनुत्तमां गतिम्) मानकर पूरी तरह से मुझमें ही स्थित है।
            पिछले श्लोक में भगवान ने कहा था कि ज्ञानी सबसे 'बेस्ट' (Best) है। इससे बाकी के तीन भक्तों (दुःखी, पैसे चाहने वाले, और जिज्ञासु) को बुरा लग सकता था कि "क्या हम भगवान के लिए बुरे हैं?"
            भगवान श्रीकृष्ण बहुत ही दयालु हैं। वे तुरंत उन तीनों का दिल रखने के लिए कहते हैं: "उदाराः सर्व एवैते"—यानी, मेरे पास आने वाले ये चारों ही लोग बहुत 'उदार' (Magnanimous / बहुत महान) हैं!
            कम से कम ये लोग अपनी प्रॉब्लम्स (Problems) लेकर शराबखाने या किसी गलत इंसान के पास तो नहीं गए; ये मेरे पास तो आए। इसलिए मैं इन सबका बहुत सम्मान करता हूँ।
            लेकिन! भगवान अपने ज्ञानी भक्त की महिमा (Glory) को एक ऐसे स्तर पर ले जाते हैं जो कल्पना से परे है।
            वे कहते हैं, "ज्ञानी त्वात्मैव मे मतम्"—अर्थात्, वह ज्ञानी भक्त मुझसे अलग नहीं है; वह साक्षात् 'मेरी ही आत्मा' (My very own Self) बन चुका है।
            यह ईश्वर की तरफ से दिया गया सबसे बड़ा मेडल (Medal) है। जब एक इंसान भगवान को छोड़कर दुनिया की किसी भी चीज़ (स्वर्ग, पैसा, यहाँ तक कि मोक्ष भी) की इच्छा नहीं रखता ('अनुत्तमां गतिम्'), तो भगवान उस इंसान को खुद के ही बराबर (Equal) बना लेते हैं।
        """.trimIndent(),
        english = """
            Undoubtedly, all these four types of devotees are exceedingly magnanimous and highly noble souls (Udarah sarva evaite), but he who is situated in absolute knowledge (Jnani) is officially considered by Me to be exactly like My own very self (Atmaiva me matam).
            Because he is perfectly situated in pure devotional service and his mind is completely locked on Me (Yuktatma), he is sure to attain Me, the absolute highest, supreme, and ultimate destination (Anuttaman gatim).
            In the previous verse, the Lord declared the 'Jnani' as the absolute best. This could easily have crushed the hearts of the other three devotees (the distressed, the wealth-seeker, and the curious), making them feel, "Are we rejected by God?"
            The Supreme Lord is unfathomably compassionate. He instantly heals their hearts by emphatically declaring: "Udarah sarva evaite"—Meaning, absolutely ALL four of you who approach Me are extraordinarily 'Magnanimous' (Great and Noble) souls!
            He acknowledges: At least when these people were crushed by massive tragedies or poverty, they didn't run to toxic drugs or demons for help; they chose to knock on MY door. Therefore, I highly respect all of them.
            BUT! The Lord elevates the glory of the 'Jnani' to an altitude that shatters human comprehension.
            He drops a cosmic bombshell: "Jnani tv atmaiva me matam"—Meaning, that enlightened devotee is no longer separate from Me; I officially consider him to be "My very own Self / My very own Soul."
            This is the absolute highest, supreme 'Medal of Honor' God can ever bestow upon a human. When a mortal violently rejects absolutely every temptation in the universe (including heaven and cheap liberation) and accepts ONLY the Lord as his ultimate, final destination ('Anuttaman gatim'), the Supreme Lord elevates that human to become qualitatively equal to Himself.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            बहूनां जन्मनामन्ते ज्ञानवान्मां प्रपद्यते |
            वासुदेवः सर्वमिति स महात्मा सुदुर्लभः || १९ ||
        """.trimIndent(),
        hindi = """
            अनेक (बहुत से) जन्मों के बिल्कुल अंत में (बहूनां जन्मनामन्ते), वह वास्तव में ज्ञान प्राप्त किया हुआ व्यक्ति (ज्ञानवान्) मेरी पूरी तरह से शरण में आ जाता है (मां प्रपद्यते)।
            "यह सब कुछ (जो भी दिखाई दे रहा है) वासुदेव (श्रीकृष्ण) ही हैं"—ऐसा समझने वाला वह महान आत्मा (महात्मा) इस संसार में अत्यंत ही दुर्लभ (सुदुर्लभः) है।
            यह पूरी भगवद्गीता के सबसे 'प्रसिद्ध' और 'परम निष्कर्ष' (Ultimate Conclusion) वाले श्लोकों में से एक है।
            श्रीकृष्ण बताते हैं कि जो 'ज्ञानी' भक्त की बात उन्होंने पिछले श्लोक में की थी, वह कोई एक दिन का कोर्स (Course) करके या एक किताब पढ़कर नहीं बना है।
            आध्यात्मिक विकास (Spiritual Evolution) एक बहुत लंबी यात्रा है। इंसान जन्म-दर-जन्म योग और ज्ञान का अभ्यास करता है ('बहूनां जन्मनामन्ते' - करोड़ों जन्मों के बाद)।
            और जब उसके सारे जन्मों का ज्ञान 100% 'मैच्योर' (Mature / पक जाता है) हो जाता है, तो उसका अंतिम रिज़ल्ट (Final Result) क्या होता है?
            वह एक बहुत ही सिंपल (Simple) लेकिन सबसे पावरफुल (Powerful) लाइन समझ जाता है: "वासुदेवः सर्वमिति" (सब कुछ वासुदेव ही है)।
            उसे समझ आ जाता है कि पेड़, पहाड़, इंसान, ब्रह्मांड और यहाँ तक कि उसकी अपनी आत्मा भी उस एक परमेश्वर (वासुदेव) का ही हिस्सा है। ईश्वर के सिवा दुनिया में कुछ 'है' ही नहीं।
            जब यह 'अल्टीमेट रियलाइजेशन' (Ultimate Realization) हो जाता है, तो वह पूरी तरह से भगवान के चरणों में सरेंडर (Surrender / प्रपद्यते) कर देता है। भगवान कहते हैं कि ऐसा परफेकट (Perfect) 'महात्मा' दुनिया में करोड़ों में से कोई एक (सुदुर्लभः / Extremely Rare) ही होता है।
        """.trimIndent(),
        english = """
            After many, many births and millions of lifetimes of spiritual practice (Bahunam janmanam ante), he who is actually situated in true knowledge (Jnanavan) completely surrenders unto Me (Mam prapadyate).
            Profoundly realizing that "Lord Vasudeva is absolutely everything and the original cause of all causes" (Vasudevah sarvam iti), such a great, enlightened soul (Mahatma) is exceptionally, exceedingly rare (Su-durlabhah).
            This is universally recognized as one of the absolute most 'Famous', legendary, and 'Ultimate Conclusion' verses in the entire Bhagavad Gita.
            Sri Krishna explicitly clarifies that the elite 'Jnani' devotee He glorified in the previous verse absolutely did not reach that staggering altitude by casually reading a book over the weekend.
            True Spiritual Evolution is an unimaginably long, grueling cosmic journey. A human soul painstakingly practices yoga and gathers knowledge lifetime after lifetime ('Bahunam janmanam ante' - after millions of reincarnations).
            And when that accumulated knowledge from billions of years finally hits 100% absolute 'Maturity', what is the exact 'Final Result' that clicks in his brain?
            He realizes one incredibly simple yet infinitely powerful cosmic equation: "Vasudevah sarvam iti" (Lord Vasudeva IS Absolutely Everything).
            He achieves the explosive realization that the galaxies, the oceans, humanity, and even his own eternal soul are merely intimate parts and parcels of the One Supreme Lord (Vasudeva). Outside of God, absolutely nothing 'Exists'.
            The exact microsecond this 'Ultimate Realization' violently explodes in his consciousness, he flawlessly and completely surrenders (Prapadyate) at the lotus feet of the Lord. The Lord officially declares that such a perfect, flawless 'Mahatma' is 'Su-durlabhah' (The absolute Rarest of the Rare; one in a billion) in this universe.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            कामैस्तैस्तैर्हृतज्ञानाः प्रपद्यन्तेऽन्यदेवताः |
            तं तं नियममास्थाय प्रकृत्या नियताः स्वया || २० ||
        """.trimIndent(),
        hindi = """
            परंतु अपनी अलग-अलग भौतिक इच्छाओं (कामनाओं) के कारण जिनका ज्ञान पूरी तरह से लुट चुका है (हृतज्ञानाः / चोरी हो गया है)...
            वे अपनी-अपनी जन्मजात भौतिक प्रकृति (स्वभाव) से विवश होकर (प्रकृत्या नियताः स्वया), उन देवताओं की पूजा के जो अलग-अलग कड़े नियम हैं (तं तं नियममास्थाय), उनका पालन करते हुए अन्य देवताओं की शरण में जाते हैं (प्रपद्यन्तेऽन्यदेवताः)।
            यह श्लोक 'मल्टी-गॉड वरशिप' (Multi-God Worship / देवताओं की पूजा) के मनोविज्ञान (Psychology) का सबसे बड़ा पर्दाफाश (Expose) है।
            अगर वासुदेव (परमेश्वर) ही सब कुछ हैं (जैसा पिछले श्लोक में बताया गया), तो फिर दुनिया में लोग हज़ारों अलग-अलग देवी-देवताओं की पूजा क्यों करते हैं?
            भगवान इसका बहुत ही कड़वा और सीधा कारण बताते हैं: "कामैस्तैस्तैर्हृतज्ञानाः" (उनका असली ज्ञान 'भौतिक लालच और वासनाओं' ने हाईजैक/Hijack कर लिया है)।
            इंसान को तुरंत नौकरी चाहिए, पैसा चाहिए, या बीमारी से छुटकारा चाहिए। वह परमेश्वर के पास नहीं जाता, क्योंकि परमेश्वर मोक्ष देते हैं और इंसान को मोक्ष नहीं, 'मटेरियल चीज़ें' (Material things) चाहिए।
            इसलिए इंसान अपने 'स्वभाव' (अगर वह लालची है) के कारण ब्रह्मांड के विभागीय मंत्रियों (Departmental Ministers / देवताओं) के पास जाता है।
            देवताओं से काम निकलवाने के लिए इंसान बहुत कड़े-कड़े नियम ('तं तं नियममास्थाय' - जैसे कई दिनों का उपवास, खास मंत्र) पालता है। भगवान कहते हैं कि ये लोग अंधे हैं; वे असली खजाने (ईश्वर) को छोड़कर केवल कुछ रुपयों (टेम्परेरी सुख) के लिए देवताओं के चक्कर काट रहे हैं।
        """.trimIndent(),
        english = """
            But those whose pure spiritual knowledge has been completely stolen away and hijacked by intense material desires and lust (Kamais tais tair hrita-jnanah)...
            completely surrender themselves unto other various demigods (Prapadyante 'nya-devatah), rigidly following the specific, strict rules and regulations of worship exactly according to their own ignorant material natures (Prakritya niyatah svaya).
            This verse is the absolute greatest, most brutal psychological 'Expose' of the underlying motive behind 'Demigod Worship' (Polytheism) in the material world.
            A massive logical question arises: If Lord Vasudeva is indeed the Supreme Absolute Truth and 'Everything' (as established in the previous verse), then why on earth do millions of people aggressively worship thousands of lesser demigods?
            The Lord drops a highly bitter, razor-sharp diagnosis: "Kamais tais tair hrita-jnanah" (Their pure spiritual intelligence has been violently robbed, hijacked, and stolen by their blinding lust for cheap material pleasures).
            An ignorant mortal desperately wants an instant job promotion, massive wealth, or a quick cure for a disease. He explicitly avoids the Supreme Lord because the Lord grants eternal Moksha (Liberation), and this foolish mortal absolutely does not want Moksha; he wants cheap 'Material Toys'.
            Therefore, driven entirely by his own greedy 'Nature' (Prakriti), he approaches the cosmic departmental managers (the Demigods).
            To extract these cheap favors from the demigods, the human performs incredibly difficult rituals and observes brutally strict vows ('Tam tam niyamam asthaya' - severe fasting, complex mantras). The Lord brands such people as intellectually blind; they foolishly ignore the Ultimate Infinite Treasure (God) just to beg for a few pennies (temporary material relief) from the demigods.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            यो यो यां यां तनुं भक्तः श्रद्धयार्चितुमिच्छति |
            तस्य तस्याचलां श्रद्धां तामेव विदधाम्यहम् || २१ ||
        """.trimIndent(),
        hindi = """
            जो-जो भक्त (इच्छाओं की पूर्ति के लिए) जिस-जिस देवता के स्वरूप (तनुं) को पूरी श्रद्धा और विश्वास के साथ पूजना चाहता है (श्रद्धयार्चितुमिच्छति)...
            मैं उस-उस भक्त की उसी देवता के प्रति जो श्रद्धा (Faith) है, उसे पूरी तरह से पक्का और अचल (अचलां) कर देता हूँ (तामेव विदधाम्यहम्)।
            यह श्लोक ईश्वर की परम उदारता (Supreme Generosity) और इंसान की 'फ्री विल' (Free Will / आज़ादी) का सम्मान करने का सबसे बड़ा प्रमाण है।
            लोग अलग-अलग देवताओं (जैसे इंद्र, कुबेर) की पूजा करते हैं। श्रीकृष्ण (परमेश्वर) ऐसा नहीं करते कि "अरे, तुम मेरी पूजा छोड़कर देवताओं की पूजा क्यों कर रहे हो? मैं तुम्हें सज़ा दूँगा!"
            इसके विपरीत, भगवान एक बहुत ही महान पिता की तरह व्यवहार करते हैं। अगर कोई इंसान अपनी इच्छा पूरी करने के लिए किसी देवता की मूर्ति के सामने खड़ा होता है, तो भगवान उसके मन में उस देवता के प्रति और भी ज़्यादा 'श्रद्धा' (Faith) भर देते हैं ताकि वह इंसान कम से कम नास्तिक (Atheist) तो न बने और किसी ईश्वरीय शक्ति पर तो विश्वास करे।
            भगवान किसी की भी आस्था को तोड़ते नहीं हैं ('अचलां श्रद्धां')। 
            वे उस इंसान को आज़ादी देते हैं कि "ठीक है, अगर तुम्हें अभी मुझसे मोक्ष नहीं चाहिए और तुम्हें केवल इस देवता से पैसे चाहिए, तो मैं तुम्हारे विश्वास को पक्का करूँगा।" भगवान अंदर बैठकर ही उस भक्त के विश्वास को चलाते हैं।
        """.trimIndent(),
        english = """
            Whatever celestial form of a demigod (Yam yam tanum) a devotee desires to worship with absolute faith (Shraddhayarchitum icchati)...
            I Myself, sitting within his heart, make his faith entirely steady and unflinching (Achalam shraddham) so that he can perfectly devote himself to that very particular deity (Tam eva vidadhamy aham).
            This spectacular verse serves as the absolute greatest testament to God's Supreme Generosity and His profound respect for human 'Free Will'.
            People worship various localized demigods (like Indra or Kubera) for material gains. The Supreme Lord (Krishna) absolutely does not act like a jealous, insecure dictator screaming, "How dare you worship a demigod instead of Me? I will punish you!"
            On the contrary, the Lord behaves like a supremely loving Father. If a human stands before the statue of a demigod hoping to fulfill a desire, the Lord, sitting as the Supersoul inside his heart, actively 'Injects' and fortifies even more intense 'Faith' (Shraddha) into that person's mind toward that specific demigod.
            The Lord absolutely never breaks anyone's faith ('Achalam shraddham'). He wants the human to at least believe in higher spiritual authorities rather than becoming a toxic atheist.
            God grants absolute freedom: "Alright, if your spiritual level is currently so low that you don't want eternal liberation from Me, and you just want cheap money from this demigod, I will personally guarantee and stabilize your faith in him."
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            स तया श्रद्धया युक्तस्तस्याराधनमीहते |
            लभते च ततः कामान्मयैव विहितान्हि तान् || २२ ||
        """.trimIndent(),
        hindi = """
            वह भक्त उस अचल श्रद्धा (जिसको मैंने पक्का किया है) से युक्त होकर, उस विशेष देवता की पूरी मेहनत से पूजा (आराधना) करता है (तस्याराधनमीहते)...
            और उस देवता से वह अपनी मनचाही सभी कामनाओं (इच्छाओं) को निश्चित रूप से प्राप्त कर लेता है (लभते च ततः कामान्)। परंतु वास्तव में वे सभी इच्छाएं मेरे द्वारा ही पूरी (विहितान्) की जाती हैं (मयैव विहितान्हि तान्)।
            यह श्लोक 'देवताओं की पूजा' के पीछे का असली मेकैनिज़्म (Mechanism / सिस्टम) समझाता है।
            जब इंसान किसी देवता की पूजा करता है और उसकी मन्नत पूरी हो जाती है (उसे नौकरी या पैसा मिल जाता है), तो वह इंसान सोचता है कि "वाह! मेरे इस देवता ने मुझे यह वरदान दे दिया!"
            लेकिन श्रीकृष्ण उस पर्दे के पीछे का असली सच खोलते हैं। वे कहते हैं कि ब्रह्मांड के किसी भी देवता के पास अपना खुद का कोई 'स्वतंत्र बैंक अकाउंट' (Independent Bank Account) या ताकत नहीं है जिससे वे किसी को कुछ दे सकें।
            देवता केवल ब्रह्मांड के अधिकारी (Government Officers) हैं। जब वे किसी इंसान को कोई वरदान (फायदा) देते हैं, तो वह आशीर्वाद वास्तव में 'मेरे द्वारा ही अप्रूव' (Approved by ME / मयैव विहितान्) होता है।
            यानी आप किसी भी देवता से कुछ भी मांगें, फाइनल 'साइन' (Signature) परमेश्वर (श्रीकृष्ण) के ही होते हैं।
            यह बिल्कुल ऐसा है जैसे आप किसी बैंक के क्लर्क (Clerk) से पैसे लेते हैं, लेकिन वह पैसा वास्तव में बैंक के मालिक (Owner) का होता है, क्लर्क का नहीं।
        """.trimIndent(),
        english = """
            Endowed with such firm, unwavering faith (Tayā shraddhaya yuktah), he strictly endeavors to worship that specific demigod (Tasyaradhanam ihate)...
            and he undoubtedly obtains all his desired material results (Labhate cha tatah kaman). But in absolute reality, these benefits are bestowed exclusively and strictly by Me alone (Mayaiva vihitan hi tan).
            This profound verse flawlessly decodes the exact, hidden 'Mechanism' operating behind all 'Demigod Worship'.
            When a human fervently prays to a demigod and his wish is successfully granted (he gets a promotion or wealth), that ignorant human arrogantly assumes, "Wow! This specific demigod independently granted me this massive boon!"
            But Sri Krishna violently pulls back the cosmic curtain to reveal the absolute truth. He declares that absolutely no demigod in the universe possesses an 'Independent Bank Account' or sovereign power to grant any boons on their own.
            Demigods are merely cosmic Government Officers (Ministers). When they grant a boon or material benefit to a worshiper, that exact transaction is officially, 100% 'Authorized and Approved by ME' (Mayaiva vihitan).
            Meaning, no matter which demigod you beg for favors, the final authoritative 'Signature' on the cosmic check always belongs exclusively to the Supreme Lord (Krishna).
            It is exactly like withdrawing cash from a bank clerk; the clerk hands you the money, but the cash actually belongs entirely to the Owner of the Bank.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            अन्तवत्तु फलं तेषां तद्भवत्यल्पमेधसाम् |
            देवान्देवयजो यान्ति मद्भक्ता यान्ति मामपि || २३ ||
        """.trimIndent(),
        hindi = """
            परंतु उन अल्प बुद्धि वाले (कम समझ वाले / अल्पमेधसाम्) लोगों को देवताओं से जो भी फल (सुख/वरदान) मिलता है, वह 'अन्तवत्' (हमेशा खत्म होने वाला / Temporary) ही होता है।
            देवताओं की पूजा करने वाले लोग मरने के बाद देवताओं के लोकों (स्वर्ग) में जाते हैं (देवान्देवयजो यान्ति); परंतु जो मेरे शुद्ध भक्त हैं, वे अंततः केवल मेरे ही परम धाम को प्राप्त होते हैं (मद्भक्ता यान्ति मामपि)।
            इस श्लोक में भगवान श्रीकृष्ण बता रहे हैं कि देवताओं से मन्नतें मांगना एक बहुत ही 'घाटे का सौदा' (Bad Deal) क्यों है।
            भगवान ऐसे लोगों को बहुत ही साफ शब्दों में 'अल्पमेधसाम्' (Small-minded / कम दिमाग वाले) कहते हैं।
            क्यों? क्योंकि इंसान ने मेहनत तो बहुत की, पूजा की, व्रत रखे, लेकिन बदले में क्या माँगा? पैसा, गाड़ी, या कुछ सालों के लिए स्वर्ग का टिकट। ये सारी चीजें 'अन्तवत्' (Temporary) हैं। एक दिन पैसा खत्म हो जाएगा और स्वर्ग से वापस धरती पर धकेल दिया जाएगा।
            जब आप उस परमेश्वर से जुड़ सकते हैं जो आपको 'हमेशा के लिए आज़ादी' (मोक्ष) दे सकता है, तो फिर इन छोटी-मोटी चीज़ों के पीछे क्यों भागना?
            ब्रह्मांड का कड़ा नियम है: "आप जिसकी पूजा करेंगे, आप वहीं जाएंगे।"
            अगर आप देवताओं (इंद्र आदि) की पूजा करेंगे, तो आप उनके लोक (स्वर्ग) में जाएंगे, जो खुद एक दिन नष्ट हो जाएगा। 
            लेकिन अगर आप परमेश्वर (कृष्ण) की भक्ति करेंगे, तो आप उनके उस अजर-अमर धाम (वैकुंठ) में जाएंगे, जहाँ से वापस लौटने का कोई दुःख नहीं है। चॉइस (Choice) आपकी है!
        """.trimIndent(),
        english = """
            However, the material fruits and boons achieved by men of small, poor intelligence (Alpa-medhasam) are entirely temporary and strictly perishable (Antavat tu phalam tesham).
            Those who worship the demigods simply go to the planets of the demigods (Devan deva-yajo yanti); but My pure devotees ultimately and eternally reach My supreme abode (Mad-bhakta yanti mam api).
            In this highly striking verse, Lord Sri Krishna perfectly explains why begging for boons from demigods is a massively 'Terrible Deal' and a poor long-term investment.
            The Lord uses brutally honest vocabulary, officially branding such materialistic worshipers as 'Alpa-medhasam' (Men of exceptionally tiny, short-sighted intelligence).
            Why? Because the human executes immense hard work, undergoes severe fasting, and performs complex rituals, but what does he beg for in return? A temporary car, some cash, or a short 10-year vacation in heaven. All these rewards are strictly 'Antavat' (Guaranteed to expire/Perishable). One day the cash burns out, and he gets violently kicked out of heaven back to earth.
            When you possess the VIP access to connect directly with the Supreme Creator who can grant you 'Permanent Eternal Freedom' (Moksha), why act like a beggar chasing pennies?
            The absolute Cosmic Rule is: "You go exactly to whom you worship."
            If you worship the demigods, you will be transported to their celestial planets (Heaven), which themselves are destined to be destroyed one day.
            But if you execute pure devotion to the Supreme Lord (Krishna), you are guaranteed to reach His indestructible, eternal Kingdom (Vaikuntha), from which you never return to this matrix of suffering. The absolute Choice is yours!
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            अव्यक्तं व्यक्तिमापन्नं मन्यन्ते मामबुद्धयः |
            परं भावमजानन्तो ममाव्ययमनुत्तमम् || २४ ||
        """.trimIndent(),
        hindi = """
            जिन लोगों के पास बिल्कुल भी बुद्धि नहीं है (मूर्ख लोग / अबुद्धयः), वे मेरे उस परम भाव (सर्वोच्च और दिव्य स्वरूप) को नहीं जानते, जो पूरी तरह से अविनाशी (अव्ययम्) और सबसे श्रेष्ठ (अनुत्तमम्) है।
            इसी अज्ञान के कारण वे यह मान लेते हैं कि मैं (ईश्वर) पहले 'अव्यक्त' (निराकार/बिना रूप का) था, और अब मैंने एक साधारण इंसान की तरह यह शरीर (व्यक्तिम्) धारण किया है (अव्यक्तं व्यक्तिमापन्नं मन्यन्ते)।
            यह भगवद्गीता के सबसे गहरे दार्शनिक (Philosophical) श्लोकों में से एक है। यहाँ भगवान उन लोगों की अज्ञानता को दूर करते हैं जो कहते हैं कि "ईश्वर का कोई रूप (Form) नहीं होता, वह केवल एक रौशनी है।"
            बहुत से बड़े-बड़े विद्वान (जिन्हें भगवान 'अबुद्धयः' यानी बुद्धिहीन कह रहे हैं) यह सोचते हैं कि परब्रह्म केवल एक 'निराकार' (Formless/अव्यक्त) ऊर्जा (Energy) है, और जब उसे धरती पर आना होता है तो वह राम या कृष्ण के रूप में एक 'भौतिक (Material) शरीर' धारण कर लेता है।
            श्रीकृष्ण इस थ्योरी को 100% गलत बताते हैं!
            भगवान कहते हैं: "मेरा यह साकार रूप (राम/कृष्ण का शरीर) कोई भौतिक मिट्टी या मांस का नहीं बना है। मेरा यह रूप 'अव्ययम्' (कभी नष्ट न होने वाला) और 'अनुत्तमम्' (सबसे सुप्रीम) है।"
            ईश्वर मूल रूप से ही 'साकार' (Personal Form) हैं। वह रोशनी या निराकार ब्रह्म तो केवल उनके शरीर से निकलने वाली एक चमक (Aura) है। 
            जो लोग भगवान को केवल एक 'निराकार शक्ति' मानते हैं और उनके साकार रूप को 'साधारण इंसान' समझते हैं, वे भगवान के असली रहस्य ('परं भावम्') को बिल्कुल नहीं जानते।
        """.trimIndent(),
        english = """
            Unintelligent and foolish men (Abuddhayah), who absolutely do not know My supreme, ultimate nature (Param bhavam ajananto), which is completely imperishable and supreme (Avyayam anuttamam)...
            falsely think that I, the Supreme Personality of Godhead, was previously formless and unmanifested (Avyaktam), and have now recently assumed this personal, human-like form and personality (Vyaktim apannam manyante).
            This is one of the most profoundly philosophical, paradigm-shifting verses in the Gita. Here, the Lord completely shatters the arrogant illusion of the 'Impersonalists' (those who claim God is merely a formless white light or energy).
            Many highly educated, yet spiritually blind scholars (whom the Lord bluntly labels 'Abuddhayah' - Brainless fools) fiercely propagate a toxic theory: "The Ultimate Truth is a 'Formless' (Avyakta) energy, and when It descends to earth, It temporarily borrows a 'Material Physical Body' to become Rama or Krishna."
            Sri Krishna violently rejects this theory as 100% fake and ignorant!
            The Lord declares: "My Personal Form (this body of Krishna) is absolutely NOT manufactured from cheap material dirt or biological flesh. My personal form is 'Avyayam' (Eternally Indestructible) and 'Anuttamam' (The Absolute Supreme Highest)."
            The Supreme Godhead is originally and eternally a 'Person' with a Form. That blinding, formless white light (Brahman) is merely the glowing Aura radiating from His transcendental body.
            Those who arrogantly reduce God to a mere 'Formless Energy' and disrespect His Personal Form as a 'temporary human disguise' are completely ignorant of His absolute supreme reality ('Param Bhavam').
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            नाहं प्रकाशः सर्वस्य योगमायासमावृतः |
            मूढोऽयं नाभिजानाति लोको मामजमव्ययम् || २५ ||
        """.trimIndent(),
        hindi = """
            मैं अपनी 'योगमाया' (दिव्य जादुई शक्ति) के परदे से पूरी तरह ढका हुआ (समावृतः) रहता हूँ, इसलिए मैं हर किसी के सामने (सर्वस्य) प्रकट (प्रकाशः) नहीं होता (यानी सबको दिखाई नहीं देता)।
            यही कारण है कि यह मूर्ख (मूढः) संसार मुझे 'अजन्मा' (जिसका कभी जन्म नहीं होता) और 'अविनाशी' (कभी न मिटने वाला / अव्ययम्) परमेश्वर के रूप में बिल्कुल नहीं पहचान पाता (नाभिजानाति)।
            अगर भगवान साक्षात् कृष्ण के रूप में महाभारत के मैदान में खड़े थे, तो दुर्योधन जैसे लोगों को वे 'भगवान' के रूप में क्यों नहीं दिखे? दुर्योधन ने उन्हें सिर्फ एक साधारण ग्वाला या राजा क्यों माना?
            इस श्लोक में भगवान उस बहुत बड़े सवाल का जवाब दे रहे हैं: "द कर्टेन ऑफ योगमाया" (The Curtain of Yogamaya / योगमाया का पर्दा)।
            ईश्वर अपने आप को दुनिया के हर मूर्ख और स्वार्थी इंसान के सामने 'एक्सपोज़' (Expose) नहीं करते। भगवान ने अपने चारों तरफ 'योगमाया' नाम का एक बहुत ही भयंकर और पारदर्शी पर्दा (Illusionary Curtain) लगा रखा है।
            जब कोई अहंकारी या पापी इंसान (मूढः) कृष्ण को देखता है, तो योगमाया का पर्दा उसे अंधा कर देता है। उसे कृष्ण केवल एक इंसान, एक चालाक राजनीतिज्ञ या एक योद्धा ही दिखाई देते हैं। उसे उनका 'अजन्मा' और 'अविनाशी' (ईश्वरीय) रूप नहीं दिखता।
            भगवान अपना असली रूप केवल उसी को दिखाते हैं (प्रकाशः) जिसके दिल में उनके लिए सच्चा प्यार और भक्ति होती है (जैसे अर्जुन)।
            ईश्वर कोई पब्लिक प्रॉपर्टी (Public Property) नहीं है जिसे हर कोई देख सके; वे केवल प्रेम से ही देखे जा सकते हैं।
        """.trimIndent(),
        english = """
            I am absolutely never manifest or openly revealed to the foolish and unintelligent masses (Naham prakashah sarvasya), for I am heavily covered and completely concealed by My internal divine potency (Yoga-maya-samavritah).
            Therefore, this bewildered, foolish world (Mudho 'yam lokah) absolutely cannot understand or recognize Me (Nabhijanati), who am entirely unborn (Ajam) and completely infallible and imperishable (Avyayam).
            If the Supreme God was standing physically right there on the Mahabharata battlefield as Krishna, why didn't arrogant tyrants like Duryodhana recognize Him as 'God'? Why did they treat Him merely as a clever politician or a cowherd boy?
            In this spectacular verse, the Lord provides the ultimate answer: "The Titanium Curtain of Yoga-Maya".
            The Supreme Creator absolutely refuses to randomly 'Expose' His divine majesty to every toxic, arrogant, or selfish human being. The Lord has engineered a highly classified, impenetrable, illusionary shield around Himself called 'Yoga-Maya'.
            When a massively bloated, egoistic sinner (Mudhah) attempts to look at Krishna, the Yoga-Maya curtain instantly blinds his spiritual vision. He merely sees Krishna as a biological human, a smart diplomat, or an ordinary prince. He completely fails to perceive the Lord's 'Unborn' and 'Imperishable' Divine Supremacy.
            The Lord actively 'Reveals' (Prakashah) His true, blinding majestic form strictly and exclusively only to those rare souls whose hearts are melting with pure, unadulterated devotion (like Arjuna).
            God is absolutely not cheap public property available for empiric visual testing; He can only be unlocked and seen through the lens of pure Love.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            वेदाहं समतीतानि वर्तमानानि चार्जुन |
            भविष्याणि च भूतानि मां तु वेद न कश्चन || २६ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! जो प्राणी भूतकाल (Past) में हो चुके हैं (समतीतानि), जो वर्तमान (Present) में मौजूद हैं, और जो भविष्य (Future) में होने वाले हैं...
            मैं उन सभी प्राणियों को और सभी घटनाओं को पूरी तरह से जानता हूँ (वेदाहं)। परंतु मुझे (मेरे असली ईश्वरीय स्वरूप को) कोई भी व्यक्ति पूरी तरह से नहीं जानता (मां तु वेद न कश्चन)।
            यह श्लोक ईश्वर की 'ओमनिशिएंस' (Omniscience / सर्वज्ञता / सब कुछ जानने की शक्ति) की सबसे बड़ी घोषणा है।
            साधारण इंसान की मेमोरी (Memory) बहुत कमज़ोर है; हम यह भी भूल जाते हैं कि हमने कल रात खाने में क्या खाया था। भविष्य जानना तो हमारे लिए बिल्कुल नामुमकिन है।
            लेकिन भगवान 'टाइम और स्पेस' (Time and Space) से पूरी तरह बाहर हैं। वे समय के रचयिता हैं।
            इसलिए श्रीकृष्ण स्पष्ट कहते हैं: "मैं इस ब्रह्मांड के एक-एक कीड़े, एक-एक इंसान और एक-एक तारे की पूरी 'हिस्ट्री' (Past), 'करंट स्टेटस' (Present), और 'डेस्टिनी' (Future) को 100% सटीकता से जानता हूँ।"
            ईश्वर के लिए कोई सरप्राइज़ (Surprise) नहीं होता, क्योंकि सब कुछ उनकी आँखों के सामने एक खुली किताब की तरह है।
            लेकिन इसका दूसरा हिस्सा बहुत चौंकाने वाला है: "मां तु वेद न कश्चन" (मुझे कोई नहीं जानता)।
            इंसान चाहे कितना भी बड़ा साइंटिस्ट (Scientist) या योगी क्यों न बन जाए, वह ईश्वर की पूरी शक्ति और उनके रहस्य को कभी 100% डिकोड (Decode) नहीं कर सकता। क्योंकि एक छोटा सा मटका (इंसान का दिमाग) पूरे समंदर (ईश्वर) को अपने अंदर कैसे समा सकता है?
        """.trimIndent(),
        english = """
            O Arjuna! As the Supreme Personality of Godhead, I flawlessly and perfectly know absolutely everything that has happened in the past (Samatitani), all that is happening in the present (Vartamanani), and all things that are yet to come in the future (Bhavishyani).
            I also intimately know all living entities (Bhutani); but Me, absolutely no one perfectly or fully knows (Mam tu veda na kashchana).
            This spectacular verse is the absolute, ultimate declaration of God's 'Omniscience' (The staggering power of knowing absolutely everything infinitely).
            An ordinary mortal's biological memory is pathetically fragile; we easily forget what we ate for dinner three days ago. Predicting the future is a biological impossibility for us.
            But the Supreme Lord exists completely outside the dimensions of 'Time and Space'. He is the absolute Creator of Time itself.
            Therefore, Sri Krishna explicitly declares: "I possess the exact, flawless 100% data of the entire 'History' (Past), the 'Current Status' (Present), and the precise 'Destiny' (Future) of every single microscopic insect, human being, and galaxy in this multiverse."
            There are absolutely zero 'Surprises' for the Supreme Creator; the entire timeline of the cosmos is laid out before Him like a fully opened map.
            But the second half of the verse is mind-bending: "Mam tu veda na kashchana" (But absolutely no one knows ME).
            No matter how incredibly advanced a quantum physicist or how powerful a mystic Yogi a human becomes, he can never, ever 100% decode or comprehend the infinite, staggering magnitude of God. Because how can a tiny, pathetic teacup (the human brain) ever hope to contain the entire infinite ocean (God)?
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            इच्छाद्वेषसमुत्थेन द्वन्द्वमोहेन भारत |
            सर्वभूतानि सम्मोहं सर्गे यान्ति परन्तप || २७ ||
        """.trimIndent(),
        hindi = """
            हे भारत! हे परन्तप (अर्जुन)! इस भौतिक संसार में जन्म लेने के साथ ही (सर्गे), 'इच्छा' (चीजों को पाने की लालसा) और 'द्वेष' (चीजों से नफरत) से उत्पन्न होने वाले...
            सुख-दुःख रूपी 'द्वंद्वों के मोह' (Illusion of Dualities) के कारण, संसार के सभी प्राणी (सर्वभूतानि) अत्यंत भयंकर भ्रम (सम्मोहं) और अज्ञान में फँस जाते हैं (यान्ति)।
            अगर हम सब आत्मा हैं और भगवान के अंश हैं, तो हम इस 'मैट्रिक्स' (Matrix/संसार) के दुःखों में फँसे कैसे? हम इस धरती पर जन्म लेकर रो क्यों रहे हैं?
            भगवान श्रीकृष्ण इस श्लोक में इंसान के इस 'पतन' (Fall) का असली 'रूट-कॉज़' (Root-cause / मूल कारण) बता रहे हैं।
            यह सब दो बहुत ही खतरनाक वायरसों (Viruses) के कारण हुआ है: 'इच्छा' (Desire / Attraction) और 'द्वेष' (Hate / Repulsion)।
            जब आत्मा भगवान को भूलकर खुद इस भौतिक दुनिया का 'बॉस' (Enjoyer) बनना चाहती है ('इच्छा'), और जब उसे अपनी मर्जी की चीज़ नहीं मिलती तो वह गुस्सा ('द्वेष') करती है, तो वह तुरंत एक मायाजाल ('द्वंद्वमोह') में गिर जाती है।
            जन्म लेते ही (सर्गे) यह माया इंसान को हैक (Hack) कर लेती है। इंसान सोचने लगता है: "यह मेरी बीवी है, यह मेरा दुश्मन है, यह मुझे सुख देगा, यह मुझे दुःख देगा।"
            इसी 'सुख-दुःख' और 'अच्छा-बुरा' के भयंकर भ्रम ('सम्मोहं') के कारण दुनिया का एक-एक इंसान (सर्वभूतानि) पागलपन की तरह भाग रहा है। यह श्लोक इंसान की बीमारी का सबसे सटीक 'एमआरआई' (MRI) है।
        """.trimIndent(),
        english = """
            O scion of Bharata, O conqueror of the foe (Parantapa)! All living entities are born directly into total, blinding illusion (Sarge sammoham yanti)...
            completely bewildered by the terrifying dualities (Dvandva-mohena) that violently arise from intense material desire and attraction (Iccha) and bitter hatred and aversion (Dvesha).
            If every single human is actually an eternal, blissful spirit soul, a pure spark of God, then how on earth did we all get violently trapped in this miserable, toxic 'Matrix' of birth and death?
            In this phenomenal verse, Lord Sri Krishna reveals the absolute, clinical 'Root-Cause' of humanity's tragic cosmic 'Fall'.
            This entire catastrophe was triggered purely by two highly lethal psychological viruses: 'Iccha' (Toxic Desire/Magnetic Attraction) and 'Dvesha' (Bitter Hatred/Violent Repulsion).
            When the pure soul foolishly desires to artificially become the 'Supreme Boss and Enjoyer' of the material world instead of serving God ('Iccha'), and fiercely reacts with anger when things don't go its way ('Dvesha'), it instantly plummets into the terrifying illusion of dualities ('Dvandva-moha').
            The exact microsecond a soul takes birth in this physical matrix (Sarge), this heavy illusion completely 'Hacks' its consciousness. The human begins hallucinating: "This object will give me immense joy; that person will give me deep misery."
            It is solely due to this blinding, schizophrenic illusion ('Sammoham') of 'Joy vs. Sorrow' and 'Friend vs. Enemy' that absolutely every single living entity (Sarva-bhutani) is running around madly in endless suffering. This verse is the ultimate, flawless 'MRI Scan' of the human disease.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            येषां त्वन्तगतं पापं जनानां पुण्यकर्मणाम् |
            ते द्वन्द्वमोहनिर्मुक्ता भजन्ते मां दृढव्रताः || २८ ||
        """.trimIndent(),
        hindi = """
            परंतु जिन पुण्य कर्म करने वाले (सदाचारी) मनुष्यों के सारे 'पाप' (पिछले जन्मों के और इस जन्म के) पूरी तरह से नष्ट (अन्तगतं) हो चुके हैं...
            वे मनुष्य 'इच्छा और द्वेष' से पैदा होने वाले इस 'द्वंद्व-मोह' (सुख-दुःख के भ्रम) से पूरी तरह मुक्त (निर्मुक्ता) हो जाते हैं, और अत्यंत दृढ़ निश्चय (दृढव्रताः) के साथ केवल मेरी ही भक्ति (भजन्ते मां) करते हैं।
            पिछले श्लोक में भगवान ने 'बीमारी' (इच्छा और द्वेष का मोह) बताई थी। इस श्लोक में भगवान उस बीमारी से बाहर निकलने का 'इलाज' (Cure) बता रहे हैं।
            कौन सा इंसान भगवान की सच्ची और अडिग (Unshakeable) भक्ति कर सकता है? क्या कोई भी चलते-फिरते भगवान का शुद्ध भक्त बन सकता है? नहीं!
            भगवान एक बहुत बड़ी 'कंडीशन' (Condition) लगाते हैं: "येषां त्वन्तगतं पापं" (जिस इंसान का पाप अकाउंट/Sin Account पूरी तरह से ज़ीरो/Zero हो चुका है)।
            जब कोई इंसान लगातार कई जन्मों तक 'पुण्य कर्म' (परोपकार, निस्वार्थ सेवा) करता है, तो उसके दिल का सारा कचरा (पाप) साफ हो जाता है।
            जब पाप खत्म होता है, तो इंसान के दिमाग से वह 'द्वंद्व-मोह' (कि मुझे केवल सुख चाहिए और दुःख से भागना है) का पर्दा हट जाता है। उसका दिमाग बिल्कुल 'क्लियर' (Clear) हो जाता है।
            और ऐसा शुद्ध इंसान 'दृढव्रताः' (Titanium Determination) के साथ भगवान की भक्ति करता है। फिर चाहे उसकी लाइफ में कितनी भी बड़ी प्रॉब्लम (Problem) आ जाए, वह कभी भगवान को नहीं छोड़ता। उसकी भक्ति 'कंडीशनल' (Conditional) नहीं, बल्कि 100% पक्की होती है।
        """.trimIndent(),
        english = """
            But those exceptionally pious persons (Jananam punya-karmanam) whose all sinful reactions and toxic karma have been completely and entirely eradicated and brought to a final end (Yesham tv anta-gatam papam)...
            they become utterly, permanently freed from the terrifying illusion of all dualities (Dvandva-moha-nirmukta), and they engage themselves in My pure devotional service with absolute, unshakeable, titanium determination (Bhajante mam dridha-vratah).
            In the previous verse, the Lord accurately diagnosed the terrifying 'Disease' (The illusion of desire and hate). In this spectacularly powerful verse, He provides the exact 'Ultimate Cure' and escape route.
            Who is actually capable of executing flawless, unshakeable devotional service to God? Can any random person walking on the street instantly become a pure devotee? Absolutely Not!
            The Lord lays down a massive, rigorous 'Condition': "Yesham tv anta-gatam papam" (Only that human whose entire 'Sin Account' from millions of lifetimes has been violently scrubbed to absolute Zero).
            When a human executes highly 'Pious Actions' (selfless charity, intense welfare, pure duties) continuously across multiple lifetimes, the dense, toxic garbage (Sins) clogging his heart is completely incinerated.
            Once the sins are eradicated, the blinding veil of 'Dvandva-moha' (the schizophrenic illusion of chasing joy and fleeing sorrow) is permanently destroyed. His intelligence becomes flawlessly crystal clear.
            And such an impeccably purified human engages in God's service with 'Dridha-vratah' (Titanium-grade, rock-solid Determination). Even if his entire world crashes down in a fiery tragedy, he absolutely never abandons the Lord. His devotion is not cheap or conditional; it is absolute.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            जरामरणमोक्षाय मामाश्रित्य यतन्ति ये |
            ते ब्रह्म तद्विदुः कृत्स्नमध्यात्मं कर्म चाखिलम् || २९ ||
        """.trimIndent(),
        hindi = """
            जो बुद्धिमान मनुष्य केवल मेरी ही शरण (आश्रय) लेकर, 'बुढ़ापा' (जरा) और 'मृत्यु' (मरण) से हमेशा के लिए मुक्त (मोक्षाय) होने का सच्चा प्रयास (यतन्ति) करते हैं...
            वे मनुष्य उस 'परब्रह्म' (ईश्वर) को, 'अध्यात्म' (आत्मा के पूरे विज्ञान) को, और सम्पूर्ण 'कर्म' (कर्म के असली रहस्य) को पूरी तरह (कृत्स्नम् / 100%) जान लेते हैं।
            यह श्लोक इंसान की सबसे बड़ी 'दो डरावनी सच्चाइयों' (Two Biggest Fears) पर वार करता है: बुढ़ापा (जरा) और मौत (मरण)।
            दुनिया का हर इंसान एंटी-एजिंग क्रीम (Anti-aging creams) लगाता है और अस्पतालों में लाखों रुपए खर्च करता है, सिर्फ इसलिए कि उसे बुढ़ापे और मौत से भयंकर डर लगता है। लेकिन कोई भी विज्ञान (Science) इन्हें रोक नहीं सकता।
            श्रीकृष्ण बताते हैं कि इन दोनों भयंकर बीमारियों का केवल एक ही परमानेंट इलाज (Permanent Cure) है: 'मोक्ष' (जन्म-मरण के चक्र से बाहर निकल जाना)।
            और यह मोक्ष कैसे मिलेगा? "मामाश्रित्य" (मेरी यानी भगवान की 100% शरण लेकर)।
            जो ज्ञानी व्यक्ति दुनिया की झूठी एंटी-एजिंग (Anti-aging) चीजों में समय बर्बाद करने के बजाय, सीधे भगवान की शरण लेता है और मोक्ष पाने के लिए दिन-रात मेहनत ('यतन्ति') करता है...
            भगवान उसका दिमाग इस तरह खोल देते हैं कि वह इस पूरे ब्रह्मांड के 'मास्टर-कोड' (Master-code) को समझ जाता है। 
            वह पूरी तरह समझ जाता है कि 'ब्रह्म' (परमात्मा) क्या है, 'अध्यात्म' (आत्मा का मैकेनिज्म) क्या है, और 'कर्म' (पाप-पुण्य की गणित) कैसे काम करती है। उसे दुनिया का कोई रहस्य जानना बाकी नहीं रहता।
        """.trimIndent(),
        english = """
            Those highly intelligent persons who constantly endeavor and strive hard for ultimate liberation from the terrors of old age and death (Jara-marana-mokshaya), taking absolute and exclusive shelter in Me (Mam ashritya yatanti ye)...
            they flawlessly and completely understand the Supreme Brahman (Te brahma tad viduh), they know the entire vast science of the transcendental Self (Kritsnam adhyatmam), and they fully comprehend the entire complex mechanics of all fruitive activities (Karma chakhilam).
            This phenomenally powerful verse aggressively targets and destroys the two absolute 'Biggest and Most Terrifying Fears' of the entire human race: Old Age (Jara) and Death (Marana).
            Ignorant mortals desperately spend billions of dollars on fake anti-aging cosmetics and advanced medical surgeries purely out of a paralyzing terror of wrinkling and dying. But absolutely no material science in the cosmos can permanently stop these two biological realities.
            Sri Krishna declares that there is strictly only ONE permanent, ultimate 'Cure' for these terrifying diseases: 'Moksha' (Permanently hacking and escaping the agonizing matrix of reincarnation).
            And exactly how is this ultimate hack executed? "Mam ashritya" (By violently dropping all material hopes and taking 100% absolute, titanium shelter exclusively in the Supreme Lord).
            An elite seeker who stops wasting time on cheap earthly survival tactics and relentlessly strives ('Yatanti') for eternal liberation under God's shelter receives a massive, cosmic intelligence upgrade.
            The Lord completely unlocks his brain, allowing him to flawlessly download the absolute 'Master-Code' of the multiverse. He completely understands the exact nature of 'Brahman' (The Supreme Godhead), 'Adhyatma' (the absolute science of the Soul), and 'Karma' (the complex quantum physics of action and reaction). Absolutely zero cosmic secrets remain hidden from him.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            साधिभूताधिदैवं मां साधियज्ञं च ये विदुः |
            प्रयाणकालेऽपि च मां ते विदुर्युक्तचेतसः || ३० ||
        """.trimIndent(),
        hindi = """
            जो ज्ञानी मनुष्य मुझे 'अधिभूत' (पूरी भौतिक प्रकृति का मालिक), 'अधिदैव' (सभी देवताओं का परम नियंत्रक), और 'अधियज्ञ' (सभी यज्ञों का परम भोक्ता) के रूप में पूरी तरह जानता है (विदुः)...
            मुझमें पूरी तरह रमे हुए मन (युक्तचेतसः) वाले वे महापुरुष, अपने जीवन के अंतिम क्षण (मृत्यु के समय / प्रयाणकालेऽपि) में भी मुझे (ईश्वर को) ही याद रखते हैं और मुझे ही प्राप्त करते हैं।
            यह सातवें अध्याय (ज्ञान-विज्ञान योग) का अत्यंत ही राजसी और 'ग्रैंड फिनाले' (Grand Finale) श्लोक है!
            भगवान श्रीकृष्ण यहाँ अपनी 'सुप्रीम अथॉरिटी' (Supreme Authority) का सबसे बड़ा 3D विज़न (Vision) दे रहे हैं:
            १. 'अधिभूत': यह जो पूरी फिजिकल दुनिया (ग्रह, तारे, शरीर) है, इसका सुप्रीम बॉस कृष्ण हैं।
            २. 'अधिदैव': ब्रह्मांड को चलाने वाले सारे बड़े-बड़े देवता (इंद्र, ब्रह्मा) भी जिनके अंडर (Under) काम करते हैं, वे कृष्ण हैं।
            ३. 'अधियज्ञ': इंसान जो भी पूजा, तपस्या या यज्ञ करता है, वह फाइनल (Final) क्रेडिट (Credit) जिसके बैंक अकाउंट में जाता है, वे कृष्ण हैं।
            जो व्यक्ति भगवान को इतने विशाल और संपूर्ण रूप में समझ लेता है, उसका मन 24 घंटे भगवान में लॉक (युक्तचेतसः) हो जाता है।
            और इसका सबसे बड़ा फायदा क्या है? "प्रयाणकालेऽपि" (मौत के समय)!
            मौत का समय इतना भयंकर और दर्दनाक होता है कि बड़े-बड़े योगियों का दिमाग क्रैश (Crash) हो जाता है और वे भगवान को भूल जाते हैं। लेकिन जिस इंसान ने पूरी जिंदगी भगवान को 'सुप्रीम बॉस' मानकर प्यार किया है, मौत के उस खौफनाक समय में भी उसका दिमाग स्थिर रहता है, वह केवल कृष्ण को याद करता है, और सीधा उनके परम धाम (वैकुंठ) में एंट्री पा लेता है!
        """.trimIndent(),
        english = """
            Those fully in consciousness of Me, who flawlessly know and understand Me to be the absolute Supreme Lord governing the entire material manifestation (Sādhibhutam), the supreme controller of all the demigods (Sādhidaivam), and the ultimate enjoyer of all sacrifices (Sādhiyajnam)...
            such highly elevated, firmly united souls, with their minds completely locked onto Me (Yukta-chetasah), remember and know Me perfectly even at the absolute, terrifying final moment of death (Prayana-kale 'pi).
            This is the highly majestic, breathtakingly spectacular 'Grand Finale' verse of the Seventh Chapter (Jnana-Vijnana Yoga)!
            Lord Sri Krishna is unleashing the absolute, ultimate 3D Panoramic Vision of His 'Supreme Cosmic Authority' here:
            1. 'Adhibhuta': He is the absolute, undisputed Supreme Proprietor of this entire physical, material multiverse (all galaxies, planets, and biological bodies).
            2. 'Adhidaiva': He is the Ultimate CEO and supreme commander of all the highly powerful cosmic demigods (like Brahma and Indra), who simply operate as His obedient department managers.
            3. 'Adhiyajna': He is the absolute, final beneficiary and Supreme Enjoyer of every single sacrifice, charity, and religious ritual ever performed in existence.
            When a human being profoundly comprehends God in this staggeringly massive, infinite magnitude, his mind becomes permanently and fiercely 'Locked' onto the Lord 24/7 (Yukta-chetasah).
            And what is the absolute ultimate, life-saving Superpower he gains? "Prayana-kale 'pi" (Survival at the exact moment of Death)!
            The exact moment of physical death is so horrifyingly painful and violently traumatizing that even advanced scholars suffer total mental system failure and completely forget God. But the elite master who has spent his entire life fiercely absorbing this supreme knowledge maintains an absolutely titanium, unshakeable focus even amidst the agonizing terror of death. He flawlessly remembers Krishna and shoots straight into the eternal Spiritual Sky (Vaikuntha)!
        """.trimIndent()
    )
)