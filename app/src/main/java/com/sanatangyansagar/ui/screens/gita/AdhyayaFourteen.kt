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
fun AdhyayaFourteen() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaFourteenShlokas.indexOfFirst { it.id == shlokaNum }
            if (targetIndex != -1) {
                coroutineScope.launch {
                    listState.animateScrollToItem(targetIndex)
                }
                keyboardController?.hide()
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (1 - 27)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { performSearch() }),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump to Shloka")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            itemsIndexed(adhyayaFourteenShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaFourteenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            श्रीभगवानुवाच |
            परं भूयः प्रवक्ष्यामि ज्ञानानां ज्ञानमुत्तमम् |
            यज्ज्ञात्वा मुनयः सर्वे परां सिद्धिमितो गताः || १ ||
        """.trimIndent(),
        hindi = """
            भगवान श्रीकृष्ण एक बार फिर से सभी ज्ञानों में सर्वश्रेष्ठ परम ज्ञान का उपदेश देना आरंभ करते हैं।
            वे अर्जुन से कहते हैं कि यह ज्ञान इतना महान है कि इसे जानकर बड़े-बड़े मुनियों ने परम सिद्धि प्राप्त की है।
            इस भौतिक संसार के बंधनों को काटने के लिए यह ज्ञान सबसे शक्तिशाली और अचूक हथियार माना गया है।
            पिछले अध्याय में भगवान ने शरीर और आत्मा का भेद बताया था और अब वे प्रकृति के तीन गुणों का रहस्य खोलेंगे।
            यह ज्ञान इंसान को संसार की इस उलझी हुई मैट्रिक्स के पीछे के असली कोड को समझने में मदद करता है।
            जब मनुष्य इस परम सत्य को गहराई से जान लेता है तो वह जन्म और मृत्यु के खौफनाक चक्र से बाहर निकल जाता है।
            ईश्वर का यह उपदेश उन सभी के लिए है जो अज्ञानता के अंधेरे से निकलकर शाश्वत प्रकाश में जाना चाहते हैं।
            इस ज्ञान की महिमा इतनी अपार है कि यह सीधे परमेश्वर के निवास तक पहुँचने का मार्ग प्रशस्त करता है।
            अर्जुन को यह सर्वोच्च विज्ञान इसलिए दिया जा रहा है क्योंकि वह भगवान का अत्यंत प्रिय और योग्य शिष्य है।
            प्रकृति और उसके गुणों का यह रहस्यमयी ज्ञान ही मानव जीवन को उसकी असली मंजिल और शांति तक ले जाता है।
        """.trimIndent(),
        english = """
            Lord Sri Krishna once again begins to impart the absolute supreme knowledge, the highest of all wisdom.
            He declares to Arjuna that by flawlessly mastering this knowledge, great sages have attained ultimate perfection.
            This transcendental science is officially recognized as the most powerful weapon to sever all material bondage.
            Having explained the difference between the body and soul previously, the Lord now decodes the three modes of nature.
            This profound wisdom helps a human being understand the underlying source code of this complex material matrix.
            When a person deeply internalizes this ultimate truth, he successfully escapes the terrifying cycle of birth and death.
            This divine instruction is meant for anyone desperate to step out of the darkness of ignorance into eternal light.
            The staggering glory of this knowledge paves a direct, non-stop pathway to the eternal abode of the Supreme Godhead.
            Arjuna is specifically receiving this elite cosmic science because he is a highly qualified and fiercely devoted disciple.
            Understanding the deep mystery of material nature and its modes is the only way to reach the ultimate destination of peace.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            इदं ज्ञानमुपाश्रित्य मम साधर्म्यमागताः |
            सर्गेऽपि नोपजायन्ते प्रलये न व्यथन्ति च || २ ||
        """.trimIndent(),
        hindi = """
            इस श्रेष्ठ ज्ञान का आश्रय लेकर जो मनुष्य मेरे ईश्वरीय स्वभाव और दिव्य गुणों को प्राप्त कर लेते हैं।
            वे सृष्टि की शुरुआत यानी नए ब्रह्मांड के निर्माण के समय भी दोबारा इस संसार में जन्म नहीं लेते हैं।
            और जब महाप्रलय का भयंकर समय आता है तब भी वे किसी प्रकार के भय या व्याकुलता का अनुभव नहीं करते हैं।
            यह श्लोक आत्मज्ञान की उस परम शक्ति को दर्शाता है जो जीव को भौतिक अस्तित्व की सीमाओं से हमेशा के लिए मुक्त कर देती है।
            भगवान के स्वभाव को प्राप्त करने का अर्थ है जन्म और मृत्यु के कठोर प्राकृतिक कानूनों से पूरी तरह बाहर निकल जाना।
            ज्ञानी व्यक्ति ईश्वर की तरह ही शाश्वत और अमर हो जाता है जिस पर समय या विनाश का कोई प्रभाव नहीं पड़ता।
            वह भौतिक शरीरों के बनने और बिगड़ने के इस अंतहीन और थकाऊ नाटक का अब हिस्सा नहीं रहता।
            प्रलय के समय जब पूरी दुनिया खौफ में काँप रही होती है तब वह मुक्त आत्मा असीम शांति में स्थिर रहती है।
            सच्चा आध्यात्मिक ज्ञान केवल किताबी नहीं है बल्कि यह हमारी चेतना को सीधे ईश्वर की चेतना से जोड़ देता है।
            यही मुक्ति का वास्तविक अर्थ है जहाँ आत्मा अपने परम घर को पाकर सभी प्रकार के सांसारिक दुखों से पार हो जाती है।
        """.trimIndent(),
        english = """
            By taking absolute shelter of this supreme knowledge, one flawlessly attains a transcendental nature identical to My own.
            Such liberated souls are absolutely never forced to take birth again, even at the cosmic dawn of a new universal creation.
            Furthermore, they remain completely undisturbed and feel zero terror even during the apocalyptic annihilation at the time of Doomsday.
            This verse powerfully illustrates the ultimate result of self-realization, completely freeing the entity from all biological limitations.
            Attaining the nature of God officially means permanently hacking and escaping the brutal natural laws of birth, aging, and death.
            The enlightened sage becomes entirely eternal and immortal exactly like the Lord, completely immune to the destructive forces of Time.
            He ceases to be a pathetic participant in the exhausting, repetitive, and endless cosmic drama of acquiring new physical bodies.
            While the entire multiverse violently trembles in panic during total annihilation, the liberated soul remains perfectly anchored in supreme peace.
            True spiritual knowledge is absolutely not mere academic theory; it fundamentally upgrades human consciousness to match the Divine frequency.
            This is the absolute definition of ultimate Moksha, where the soul reaches its eternal home and completely transcends all material suffering.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            मम योनिर्महद्ब्रह्म तस्मिन्गर्भं दधाम्यहम् |
            सम्भवः सर्वभूतानां ततो भवति भारत || ३ ||
        """.trimIndent(),
        hindi = """
            हे भारत! मेरी यह विशाल भौतिक प्रकृति जिसे महत्-ब्रह्म भी कहा जाता है वही संपूर्ण चराचर जगत की मूल योनि या गर्भ है।
            मैं इसी विशाल प्राकृतिक गर्भ में चेतन जीवात्मा रूपी बीज को स्थापित करता हूँ जिससे सृष्टि का आरंभ होता है।
            इसी जड़ प्रकृति और चेतन आत्मा के मिलन से ही इस ब्रह्मांड के सभी छोटे-बड़े प्राणियों का जन्म संभव हो पाता है।
            भगवान यहाँ सृष्टि के निर्माण का अत्यंत सूक्ष्म और वैज्ञानिक रहस्य अर्जुन के सामने स्पष्ट कर रहे हैं।
            प्रकृति केवल एक निर्जीव और अंधी मशीन के समान है जिसमें स्वयं कुछ भी नया पैदा करने की शक्ति नहीं होती।
            जब ईश्वर उस निर्जीव मशीन के भीतर आत्मा का चेतन बीज डालते हैं तब जाकर जीवन की शुरुआत होती है।
            यह भौतिक दुनिया माता के समान है और परमेश्वर साक्षात् उस पिता के समान हैं जो इस जीवन का मूल कारण हैं।
            हमारे शरीर का हर एक हिस्सा उसी महान प्रकृति के तत्वों से बना है जबकि हमारी चेतना सीधे ईश्वर का अंश है।
            इस ज्ञान को समझने से इंसान का यह भ्रम टूट जाता है कि वह केवल रसायनों और मिट्टी का बना हुआ एक पुतला है।
            सृष्टि का यह अद्भुत हाइब्रिड मॉडल यह साबित करता है कि हम सभी परमेश्वर के बच्चे हैं और प्रकृति हमारी पालनहार है।
        """.trimIndent(),
        english = """
            O son of Bharata, the total material substance, known as Brahman or material nature, is the vast cosmic womb of all creation.
            I personally impregnate this massive material womb by injecting the living spiritual entities into it as the original seed.
            It is strictly from this specific union of dead matter and conscious spirit that the birth of absolutely all living beings becomes possible.
            The Lord is explicitly decoding the incredibly profound and highly scientific secret behind the genesis of the entire multiverse.
            Material nature on its own is merely a dark, lifeless, and blind machine completely lacking the independent power to generate life.
            Biological life only successfully activates when the Supreme Creator forcibly inserts the highly conscious spiritual seed into that dead machinery.
            This massive physical universe acts exactly as the Mother, while the Supreme Lord officially serves as the absolute, original Father.
            Every single biological component of our body is manufactured from natural elements, while our internal consciousness is a direct spark of God.
            Understanding this cosmic mechanism permanently shatters the atheistic illusion that humans are merely accidental combinations of random chemicals.
            This spectacular hybrid model of creation mathematically proves that we are all eternal children of God, temporarily housed in nature's vessel.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            सर्वयोनिषु कौन्तेय मूर्तयः सम्भवन्ति याः |
            तासां ब्रह्म महद्योनिरहं बीजप्रदः पिता || ४ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र! ब्रह्मांड की सभी योनियों में जितने भी अलग-अलग प्रकार के शरीर वाले प्राणी जन्म लेते हैं।
            उन सभी अनगिनत शरीरों को धारण करने वाली और आकार देने वाली मूल माता यह विशाल भौतिक प्रकृति ही है।
            और उन सभी भौतिक शरीरों के भीतर जीवन का चेतन बीज डालने वाला परम पिता साक्षात् मैं ही हूँ।
            यह श्लोक पूरी मानव जाति और सभी जीवों की असली वंशावली और उनके माता-पिता का परिचय देता है।
            चाहे वह कोई देवता हो, इंसान हो, जानवर हो या कोई छोटा सा कीड़ा, सबके भौतिक शरीर इसी प्रकृति की मिट्टी से बने हैं।
            हम सभी जीवों का बाहरी कवर या हार्डवेयर अलग हो सकता है लेकिन हम सबके भीतर बैठा हुआ सॉफ्टवेयर एक ही पिता से आया है।
            जब हम इस बात को गहराई से समझ लेते हैं तो हमारे मन से ऊंच-नीच और जाति-पाति का सारा घमंड पूरी तरह मिट जाता है।
            दुनिया के हर जीव के प्रति हमारे भीतर एक स्वाभाविक प्रेम और सम्मान पैदा होता है क्योंकि हम सब एक ही परिवार का हिस्सा हैं।
            ईश्वर केवल इंसानों के भगवान नहीं हैं बल्कि वे इस सृष्टि के हर छोटे-बड़े जीव के जन्मदाता और रक्षक हैं।
            यह ज्ञान हमें प्रकृति का सम्मान करना सिखाता है और यह याद दिलाता है कि हमारी असली पहचान इस शरीर से परे है।
        """.trimIndent(),
        english = """
            O son of Kunti, it should be understood that all species of life and all physical forms manifest in this universe are born of material nature.
            This vast, complex material nature acts flawlessly as the ultimate, universal Mother that biological supplies the bodies for everyone.
            And I am officially the absolute, original seed-giving Father who injects the living consciousness into all these diverse material forms.
            This spectacular verse establishes the absolute, authentic cosmic genealogy and true parentage of every single living entity in the matrix.
            Whether it is a highly elevated demigod, a human, an animal, or a microscopic bacterium, every physical body is manufactured from the exact same nature.
            While our external biological covers and hardware drastically differ, the internal spiritual software within us originates strictly from the exact same Father.
            When a human deeply internalizes this profound truth, the toxic, arrogant illusions of racial superiority and caste discrimination are instantly eradicated.
            A natural, spontaneous love and universal respect naturally awaken for all creatures because we officially belong to one massive cosmic family.
            God is absolutely not just a localized deity for humans; He is the undisputed Creator and protector of every single micro-organism in the multiverse.
            This wisdom demands absolute respect for Mother Nature while constantly reminding us that our true, eternal identity lies far beyond biological flesh.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            सत्त्वं रजस्तम इति गुणाः प्रकृतिसम्भवाः |
            निबध्नन्ति महाबाहो देहे देहिनमव्ययम् || ५ ||
        """.trimIndent(),
        hindi = """
            हे महाबाहु अर्जुन! भौतिक प्रकृति से तीन मुख्य गुण उत्पन्न होते हैं जिन्हें सत्त्व, रजस और तमस कहा जाता है।
            ये तीनों गुण इस भौतिक शरीर के भीतर निवास करने वाली उस अविनाशी और स्वतंत्र आत्मा को मजबूती से बाँध देते हैं।
            प्रकृति के ये गुण एक प्रकार के अदृश्य रस्सों या जंजीरों की तरह काम करते हैं जो आत्मा को शरीर की जेल में कैद कर लेते हैं।
            सत्त्व गुण अच्छाई और ज्ञान का प्रतीक है, रजोगुण लालच और वासना का, तथा तमोगुण अज्ञान और आलस्य का प्रतीक है।
            आत्मा स्वभाव से पूरी तरह स्वतंत्र, शुद्ध और अमर होती है लेकिन शरीर में आते ही वह इन गुणों के प्रभाव में फँस जाती है।
            इन गुणों के कारण ही इंसान कभी बहुत खुश होता है, कभी भागदौड़ करता है और कभी डिप्रेशन या नींद में डूब जाता है।
            यह संसार एक प्रकार का मैट्रिक्स है और ये तीन गुण वो खतरनाक सॉफ्टवेयर हैं जो हमारे दिमाग को पूरी तरह कंट्रोल करते हैं।
            हम जो कुछ भी सोचते या करते हैं वह हमारी अपनी मर्जी नहीं होती बल्कि इन्हीं तीनों गुणों का हम पर हावी होना होता है।
            आध्यात्मिक जीवन का सबसे पहला और मुख्य लक्ष्य इन तीनों गुणों की चालबाजी को पहचानना और समझना है।
            जब हम यह जान लेते हैं कि हम इन गुणों के गुलाम हैं तब हम ईश्वर की मदद से इन जंजीरों को तोड़ने का असली प्रयास शुरू करते हैं।
        """.trimIndent(),
        english = """
            O mighty-armed Arjuna! Material nature consists of exactly three fundamental modes, known as goodness (Sattva), passion (Rajas), and ignorance (Tamas).
            When the eternal, indestructible living entity comes into contact with nature, he becomes tightly bound and heavily conditioned by these three powerful modes.
            These specific modes of nature operate exactly like invisible, unbreakable titanium chains that forcefully imprison the free soul within the biological cage.
            Sattva represents purity and knowledge, Rajas represents toxic greed and endless desires, while Tamas represents laziness, madness, and dark ignorance.
            The soul is fundamentally entirely free, pure, and immortal by default, but it tragically gets entangled in these psychological algorithms upon taking a physical body.
            Due strictly to the influence of these modes, a human fluctuates between feeling peacefully happy, violently greedy, or hopelessly depressed and lethargic.
            The material world is a highly complex matrix, and these three modes are the core operating software algorithms that relentlessly hijack human consciousness.
            Our daily thoughts, aggressive ambitions, and lazy habits are rarely our own free will; they are heavily dictated by whichever mode is currently dominating our brain.
            The absolute primary objective of all spiritual practice is to scientifically recognize and decode the subtle manipulations of these three material modes.
            Once we realize our pathetic enslavement to this natural software, we can aggressively endeavor to shatter these chains by seeking the intervention of the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            तत्र सत्त्वं निर्मलत्वात्प्रकाशकमनामयम् |
            सुखसङ्गेन बध्नाति ज्ञानसङ्गेन चानघ || ६ ||
        """.trimIndent(),
        hindi = """
            हे निष्पाप अर्जुन! इन तीनों गुणों में से 'सत्त्व गुण' अत्यंत निर्मल, पवित्र और शांत होने के कारण प्रकाश देने वाला है।
            यह गुण इंसान के मन से सभी प्रकार के पापों और विकारों को दूर करके उसे एक बहुत ही स्वस्थ और शांत जीवन प्रदान करता है।
            परंतु यह पवित्र सत्त्व गुण भी आत्मा को सांसारिक 'सुख' और सांसारिक 'ज्ञान' के अहंकार में फँसाकर बाँध देता है।
            सत्त्व गुणी इंसान बहुत अच्छे काम करता है, समाज की भलाई करता है और उसे अपने अच्छे होने पर बहुत गर्व महसूस होता है।
            यही गर्व और इस शांतिपूर्ण सुख से चिपके रहने की आदत उसके लिए एक बहुत सुंदर 'सोने की जंजीर' बन जाती है।
            वह सोचता है कि मैं बहुत बड़ा ज्ञानी हूँ और दुनिया में सबसे सुखी हूँ, और यही सोच उसे भगवान की असली भक्ति से दूर कर देती है।
            लोहे की जंजीर की तरह सोने की जंजीर भी इंसान को आज़ाद नहीं रहने देती बल्कि उसे इस दुनिया के बंधनों में ही कैद रखती है।
            पुण्य करने वाला यह इंसान स्वर्ग तो जाता है लेकिन वहां से उसे फिर दोबारा इसी दुखों भरी धरती पर वापस आना पड़ता है।
            इसलिए भगवान चेतावनी दे रहे हैं कि अच्छे कर्म करना बहुत ज़रूरी है लेकिन उन कर्मों के अहंकार में फँसना खतरनाक है।
            सच्चे साधक को सत्त्व गुण के इस सुखदायक जाल को भी पार करके सीधे ईश्वर के परम स्वरूप तक पहुँचना होता है।
        """.trimIndent(),
        english = """
            O sinless one! Among these three modes, the mode of goodness (Sattva) is the purest, being illuminating, flawless, and completely free from all sinful reactions.
            This specific mode thoroughly cleanses the mind of all toxic impurities, granting the individual a highly peaceful, healthy, and luminous existence.
            However, even this incredibly pure mode of goodness severely conditions and binds the eternal soul by creating a deep attachment to worldly 'Happiness' and earthly 'Knowledge'.
            A person in the mode of goodness executes noble deeds, helps society, and tragically develops a bloated, toxic pride regarding his own righteousness and high intellect.
            This arrogant pride and intense addiction to his peaceful, comfortable lifestyle slowly morphs into a beautiful but inescapable 'Chain of Solid Gold'.
            He arrogantly hallucinates, "I am the most intelligent scholar and the happiest man alive," and this subtle ego completely distracts him from surrendering to the Supreme Lord.
            Just like a dirty iron chain, a glittering golden chain equally restricts freedom and keeps the soul heavily imprisoned within the material matrix.
            This highly pious human earns enough karma to immigrate to the heavenly planets, but he is mathematically guaranteed to be kicked back down to earth once his pious balance hits zero.
            Therefore, the Lord issues a strict warning: Performing noble acts is essential, but becoming toxically attached to the resulting pride and comfort is a fatal spiritual trap.
            An elite seeker must aggressively transcend even this exceptionally comfortable and deceptive mode of goodness to reach the unadulterated, absolute dimension of God.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            रजो रागात्मकं विद्धि तृष्णासङ्गसमुद्भवम् |
            तन्निबध्नाति कौन्तेय कर्मसङ्गेन देहिनम् || ७ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र! तुम 'रजो गुण' को राग यानी सांसारिक आकर्षण और असीम लालसा का साक्षात् स्वरूप ही समझो।
            यह भयंकर रजोगुण इंसान के भीतर कभी न खत्म होने वाली इच्छाओं और दुनिया की चीज़ों से चिपकने की भावना से पैदा होता है।
            यह गुण आत्मा को सकाम कर्मों यानी फल की इच्छा से किए जाने वाले कामों के भयंकर जाल में पूरी तरह बाँध देता है।
            जब रजोगुण हावी होता है तो इंसान दिन-रात पैसे कमाने, बड़ा घर बनाने और दुनिया में अपना नाम चमकाने के लिए पागलों की तरह भागता है।
            उसे कभी भी शांति या संतुष्टि नहीं मिलती क्योंकि उसकी एक इच्छा पूरी होते ही दस नई इच्छाएं तुरंत उसके दिमाग में पैदा हो जाती हैं।
            वह सफलता पाने के लिए परिवार, स्वास्थ्य और सुकून सबको दांव पर लगा देता है पर फिर भी अंदर से खाली ही रहता है।
            रजोगुण से बंधा इंसान सोचता है कि उसकी मेहनत ही सब कुछ है और वह अपने अहंकार में ईश्वर की सत्ता को पूरी तरह भूल जाता है।
            यह एक ऐसी आग है जिसमें इंसान जितना घी डालता है वह आग बुझने के बजाय और अधिक भड़कती ही चली जाती है।
            आधुनिक दुनिया के ज़्यादातर लोग इसी रजोगुण के गुलाम हैं जो मशीन की तरह काम करते हुए अपनी पूरी ज़िंदगी बर्बाद कर देते हैं।
            भगवान कहते हैं कि इन अंतहीन इच्छाओं और कर्मों की जंजीर को काटे बिना इंसान कभी भी सच्ची आज़ादी और शांति नहीं पा सकता।
        """.trimIndent(),
        english = """
            O son of Kunti! You must understand that the mode of passion (Rajas) is born of intense, unlimited desires, deep cravings, and toxic worldly attractions.
            This highly aggressive mode originates entirely from an insatiable, burning thirst for material enjoyment and a desperate clinging to worldly possessions.
            This specific mode brutally binds the eternal, embodied soul through an obsessive, frantic attachment to fruitive actions and their material results.
            When Rajas violently dominates the brain, a human runs like a maniac 24/7, relentlessly hustling to hoard billions, build mega-mansions, and aggressively expand his social clout.
            He is completely stripped of all mental peace and satisfaction because the exact microsecond one desire is fulfilled, ten new toxic cravings instantly hijack his mind.
            He ruthlessly sacrifices his health, family, and inner peace on the altar of ambition, yet remains profoundly empty and miserable inside his soul.
            A human paralyzed by passion arrogantly believes his own hustle is the supreme power, conveniently forgetting the absolute authority and existence of God.
            This mode operates exactly like a raging forest fire; pouring the fuel of sensory gratification into it only makes the flames roar higher and burn more aggressively.
            The vast majority of the modern corporate matrix is hopelessly enslaved by this mode of passion, exhausting their entire lifespans grinding endlessly like biological machines.
            The Lord explicitly declares that unless a human violently severs the chains of these endless desires and toxic hustle, achieving genuine freedom and peace is mathematically impossible.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            तमस्त्वज्ञानजं विद्धि मोहनं सर्वदेहिनाम् |
            प्रमादालस्यनिद्राभिस्तन्निबध्नाति भारत || ८ ||
        """.trimIndent(),
        hindi = """
            हे भारत! तुम 'तमो गुण' को घोर अज्ञानता से पैदा होने वाला और सभी जीवों को भयंकर मोह या भ्रम में डालने वाला समझो।
            यह सबसे नीचा और खतरनाक गुण है जो इंसान की सोचने-समझने की शक्ति को पूरी तरह से नष्ट कर देता है और उसे अंधा बना देता है।
            यह तमोगुण आत्मा को प्रमाद (पागलपन), आलस्य (सुस्ती) और निद्रा (ज़रूरत से ज्यादा नींद) की लोहे की जंजीरों में जकड़ लेता है।
            जब इंसान पर तमोगुण हावी होता है तो वह अपने ज़रूरी कामों को टालता रहता है और बिना किसी कारण के उदास या नशे में डूबा रहता है।
            उसे क्या सही है और क्या गलत है इसका कोई होश नहीं रहता और वह अपनी ज़िंदगी का कीमती समय केवल सोने या फालतू कामों में बर्बाद करता है।
            तमोगुणी इंसान हमेशा शॉर्टकट ढूँढता है और मेहनत करने के बजाय भाग्य को कोसता रहता है या दूसरों पर अपनी नाकामी का इल्ज़ाम डालता है।
            इस गुण के प्रभाव में इंसान जानवरों जैसी सोच रखने लगता है जहाँ उसकी चेतना का स्तर सबसे निचले दर्जे पर गिर जाता है।
            प्रमाद का अर्थ है वह पागलपन जिसमें इंसान जानबूझकर गलत काम करता है और अपने ही विनाश की ओर तेजी से भागता है।
            यह गुण मनुष्य को अध्यात्म, ज्ञान और तरक्की से कोसों दूर ले जाकर एक अंधेरे और ठंडे कुएं में हमेशा के लिए धकेल देता है।
            भगवान चेतावनी देते हैं कि तमोगुण मनुष्य का सबसे बड़ा और खामोश दुश्मन है जिससे तुरंत बाहर निकलना अत्यंत आवश्यक है।
        """.trimIndent(),
        english = """
            O son of Bharata! Know definitively that the mode of darkness and ignorance (Tamas) is born of absolute delusion and completely bewilders all embodied living entities.
            This is the absolute lowest, most toxic, and dangerous operating algorithm that violently crashes a human's intelligence and renders his consciousness entirely blind.
            This mode of ignorance brutally binds and suffocates the eternal soul using the heavy, rusty iron chains of madness (Pramada), chronic laziness (Alasya), and excessive sleep (Nidra).
            When Tamas aggressively hijacks the brain, a human constantly procrastinates critical duties, sinking deep into unjustified depression, toxic apathy, or severe substance addiction.
            He completely loses all basic common sense regarding right and wrong, tragically wasting his highly precious biological timeline merely sleeping or engaging in utterly useless activities.
            A human infected with ignorance constantly hunts for cheap shortcuts, violently cursing his destiny and blaming everyone else for his own pathetic failures instead of working hard.
            Under this heavy influence, human consciousness rapidly degrades to a primitive, animalistic level where spiritual and intellectual awareness hits absolute rock bottom.
            'Pramada' signifies that specific toxic madness where a human knowingly commits horrific mistakes and aggressively sprints full-speed directly toward his own inevitable destruction.
            This mode violently drags a person light-years away from any spiritual growth, enlightenment, or success, permanently tossing him into a freezing, pitch-black well of despair.
            The Lord sternly warns that the mode of ignorance is humanity's absolute greatest, silent assassin, and executing an immediate, forceful exit from its grip is a matter of absolute survival.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            सत्त्वं सुखे सञ्जयति रजः कर्मणि भारत |
            ज्ञानमावृत्य तु तमः प्रमादे सञ्जयत्युत || ९ ||
        """.trimIndent(),
        hindi = """
            हे भारत अर्जुन! सत्त्व गुण मनुष्य को ज्ञान और शांति से मिलने वाले सांसारिक सुख के असीम मोह में बांध देता है।
            रजोगुण इंसान को कभी न खत्म होने वाले भौतिक कर्मों, धन कमाने की अंधी दौड़ और महत्वाकांक्षाओं में बुरी तरह उलझा देता है।
            परंतु तमोगुण इंसान के ज्ञान को पूरी तरह ढककर उसे प्रमाद, आलस्य, नशे और पागलपन के गहरे गर्त में धकेल देता है।
            यह श्लोक इन तीनों गुणों की कार्यप्रणाली का एक बहुत ही शानदार और सटीक सारांश प्रस्तुत करता है।
            सत्त्व गुण का सुख एक बहुत ही साफ़ और सुंदर कमरे की तरह है जहाँ इंसान आराम से बैठ जाता है और आगे बढ़ना भूल जाता है।
            रजोगुण एक ऐसी ट्रेडमिल की तरह है जिस पर इंसान पागलों की तरह दौड़ता रहता है लेकिन अंत में कहीं भी पहुँच नहीं पाता।
            और तमोगुण एक अंधेरी और दमघोंटू जेल की तरह है जहाँ इंसान अपनी सुध-बुध खोकर बस पड़े रहने का ही चुनाव करता है।
            तीनों ही गुण आत्मा को अपनी-अपनी तरह से कैद करते हैं बस उनकी जंजीरों की धातु (सोना, चाँदी या लोहा) अलग-अलग होती है।
            भगवान हमें यह समझाना चाहते हैं कि जब तक हम इन तीनों गुणों की पहचान नहीं करेंगे तब तक हम इनके मायाजाल में फँसे ही रहेंगे।
            सच्ची मुक्ति तभी मिलती है जब इंसान इन तीनों रस्सियों को काटकर अपने असली ईश्वरीय स्वरूप को पहचान लेता है।
        """.trimIndent(),
        english = """
            O son of Bharata! The mode of goodness strictly conditions one to become toxically attached to a peaceful sense of happiness and intellectual satisfaction.
            The mode of passion heavily entangles a human being in a relentless, never-ending cycle of frantic fruitive activities, blind hustle, and aggressive material ambitions.
            But the mode of ignorance completely covers and deletes a person's knowledge, violently dragging him down into the dark abyss of madness, laziness, and toxic intoxication.
            This spectacular verse provides the absolute, ultimate, and highly precise executive summary of exactly how these three specific modes hack and operate human consciousness.
            The happiness of the Sattva mode is like a flawlessly clean, luxurious hotel room where a human gets too comfortable and completely forgets his ultimate journey home.
            The Rajas mode operates exactly like a terrifying, high-speed treadmill where a human sprints furiously 24/7, sweating blood, but ultimately arrives absolutely nowhere in the end.
            And the Tamas mode is akin to a freezing, suffocating, pitch-black dungeon where a human loses all sanity and pathetically chooses to just rot away in silence.
            All three modes effectively imprison the eternal soul in their own unique ways; the only difference lies in the specific metal of their chains (solid gold, silver, or rusty iron).
            The Lord is explicitly training our intelligence to scientifically recognize these sophisticated traps, warning us that ignorance of these modes guarantees our continued enslavement in the matrix.
            Absolute, true liberation is achieved only when a human violently shatters all three of these psychological chains and reclaims his original, pristine, spiritual identity in God.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            रजस्तमश्चाभिभूय सत्त्वं भवति भारत |
            रजः सत्त्वं तमश्चैव तमः सत्त्वं रजस्तथा || १० ||
        """.trimIndent(),
        hindi = """
            हे भारत! कभी रजोगुण और तमोगुण को दबाकर इंसान के मन में सत्त्व गुण प्रमुख हो जाता है और वह बहुत शांत और ज्ञानी महसूस करता है।
            कभी सत्त्व और तमोगुण को पीछे छोड़कर इंसान पर रजोगुण हावी हो जाता है और वह पैसे या सफलता के लिए पागलों की तरह भागने लगता है।
            और कभी सत्त्व और रजोगुण को कुचलकर तमोगुण ऊपर आ जाता है, तब इंसान का मन उदास, आलसी और नींद से भर जाता है।
            हमारे शरीर और मन के भीतर इन तीनों गुणों के बीच हर समय एक भयंकर और कभी न रुकने वाला युद्ध चलता रहता है।
            यह बिल्कुल एक म्यूजिकल चेयर या सत्ता की लड़ाई की तरह है जहाँ कोई भी गुण हमेशा के लिए राजा बनकर नहीं रह सकता।
            सुबह उठकर इंसान शांत (सत्त्व) होता है, दिन में ऑफिस में वह पैसे के लिए लड़ता है (रजस), और रात को थककर सो जाता है (तमस)।
            हमारी भावनाएं और हमारे विचार हमारे कंट्रोल में नहीं होते, वे बस इस बात पर निर्भर करते हैं कि उस वक्त कौन सा गुण जीत रहा है।
            जब इंसान को यह विज्ञान समझ आ जाता है तो वह अपने मूड स्विंग्स को लेकर ज्यादा परेशान या दुखी नहीं होता।
            वह इन गुणों के खेल को एक दूर बैठे अंपायर की तरह केवल शांति से देखता है और उनमें शामिल नहीं होता।
            यही वह ज्ञान है जो हमें अपनी ही भावनाओं की गुलामी से आज़ाद करके एक स्थिर और शांत योगी बना देता है।
        """.trimIndent(),
        english = """
            O son of Bharata! Sometimes the mode of goodness becomes prominent, violently defeating the modes of passion and ignorance, causing the human to feel highly peaceful and wise.
            At other times, the mode of passion aggressively suppresses goodness and ignorance, completely hijacking the brain and forcing the human to wildly chase money and success.
            And sometimes, the mode of ignorance brutally crushes both goodness and passion, drowning the human consciousness in a toxic wave of deep depression, laziness, and sleep.
            Directly inside our biological bodies and minds, a terrifying, relentless, and brutal 24/7 war for total supremacy is constantly raging between these three modes.
            It operates exactly like a brutal game of cosmic musical chairs or a political power struggle; absolutely no single mode can maintain its dictatorial rule permanently.
            A human wakes up feeling peaceful (Sattva), aggressively hustles in the corporate office for cash (Rajas), and eventually collapses into exhausted sleep at night (Tamas).
            Our daily fleeting emotions and spontaneous thoughts are rarely under our true control; they are strictly dictated by whichever specific mode is currently winning the internal war.
            When a human scientifically comprehends this psychological mechanism, he absolutely stops having massive panic attacks or guilt trips over his random, unpredictable mood swings.
            He begins to objectively observe this brutal clash of modes exactly like a detached, neutral umpire sitting far away, refusing to participate in the toxic drama.
            This specific, highly classified knowledge successfully frees us from the pathetic slavery of our own biological emotions, elevating us into a steady, unshakable, and peaceful Yogi.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            सर्वद्वारेषु देहेऽस्मिन्प्रकाश उपजायते |
            ज्ञानं यदा तदा विद्याद्विवृद्धं सत्त्वमित्युत || ११ ||
        """.trimIndent(),
        hindi = """
            जब इस शरीर के सभी नौ द्वारों या दरवाजों (आँखें, कान, नाक आदि) में ज्ञान का अत्यंत स्पष्ट प्रकाश और चेतना उत्पन्न हो जाती है।
            तब यह निश्चित रूप से समझ लेना चाहिए कि इस समय मनुष्य के भीतर सत्त्व गुण पूरी तरह से हावी हो चुका है और बढ़ गया है।
            यह श्लोक एक इंसान के भीतर सत्त्व गुण के सक्रिय (एक्टिव) होने का सबसे बड़ा और साइंटिफिक लक्षण बताता है।
            जब इंसान का दिमाग सत्त्व गुण में होता है तो उसे चीजें बहुत साफ़-साफ़ (क्लियरली) समझ में आने लगती हैं, कोई कंफ्यूजन नहीं रहता।
            उसकी आँखें दुनिया की गंदगी के बजाय केवल अच्छाई देखती हैं और उसके कान केवल ज्ञान की बातें सुनना पसंद करते हैं।
            उसका शरीर एकदम हल्का और स्वस्थ महसूस करता है तथा मन में किसी भी प्रकार की बेवजह की कोई बेचैनी या तनाव नहीं होता।
            वह जो भी फैसला लेता है वह बिल्कुल सटीक, तार्किक और धर्म के अनुसार होता है क्योंकि उसका सारा ज्ञान प्रकाशित हो चुका होता है।
            यह वह अवस्था है जब इंसान का मन एक ठहरे हुए साफ तालाब की तरह होता है जिसमें वह अपनी आत्मा की गहराई को देख सकता है।
            लेकिन भगवान यह भी याद दिला रहे हैं कि यह अवस्था भी परमानेंट नहीं है और रजोगुण आकर इसे कभी भी बिगाड़ सकता है।
            इसलिए साधक को इस सात्त्विक प्रकाश का उपयोग केवल और केवल ईश्वर के ध्यान और उनसे जुड़ने के लिए ही करना चाहिए।
        """.trimIndent(),
        english = """
            When the clear, illuminating light of absolute knowledge flawlessly manifests through all the nine gates (senses) of the biological body.
            Then it should be definitively understood and concluded that the pure mode of goodness (Sattva) has become completely predominant and highly elevated.
            This spectacular verse provides the absolute, ultimate, and highly scientific symptom confirming that the mode of goodness has fully activated within a human's system.
            When a human brain operates strictly within the Sattva mode, it processes reality with crystal-clear, high-definition clarity, completely devoid of any toxic confusion or mental fog.
            His eyes naturally seek out purity instead of filth, and his ears actively prefer absorbing profound philosophical knowledge rather than cheap, toxic gossip.
            His biological machine feels incredibly light, vibrant, and healthy, and his psychological software is entirely free from unnecessary, crippling anxiety or restless stress.
            Every single decision he executes is mathematically precise, highly logical, and perfectly aligned with Dharma, because his entire field of intelligence is fully illuminated.
            This is the exact pristine state where the human mind resembles a perfectly calm, crystal-clear lake, allowing the individual to look deep into the reflection of his own soul.
            However, the Lord implicitly reminds us that even this highly elevated state is absolutely not permanent, and the aggressive mode of passion can ambush it at any moment.
            Therefore, an elite spiritual seeker must urgently utilize this temporary window of Sattvic illumination strictly to meditate on the Supreme Lord and solidify his eternal connection.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            लोभः प्रवृत्तिरारम्भः कर्मणामशमः स्पृहा |
            रजस्येतानि जायन्ते विवृद्धे भरतर्षभ || १२ ||
        """.trimIndent(),
        hindi = """
            हे भरतवंशियों में श्रेष्ठ अर्जुन! जब मनुष्य के भीतर रजोगुण बहुत अधिक बढ़ जाता है तो उसके मन में भयंकर लालच (लोभ) पैदा हो जाता है।
            वह सांसारिक सुखों को पाने के लिए पागलों की तरह बहुत अधिक मेहनत करता है और स्वार्थ से भरे नए-नए बड़े प्रोजेक्ट्स की शुरुआत करता है।
            उसके मन की शांति पूरी तरह खत्म हो जाती है (अशम) और उसे हर समय कुछ नया हासिल करने की एक अतृप्त और भयंकर प्यास (स्पृहा) लगी रहती है।
            यह श्लोक आज की आधुनिक दुनिया और कॉर्पोरेट जीवन की असलियत का एक बहुत ही परफेक्ट और कड़वा आईना है।
            रजोगुणी इंसान के पास चाहे करोड़ों रुपये आ जाएं, लेकिन उसका पेट कभी नहीं भरता और वह हमेशा और ज्यादा पैसे के लिए रोता रहता है।
            वह कभी चैन से नहीं बैठ सकता, उसका दिमाग हमेशा नई डील और नए मुनाफे की कैलकुलेशन में मशीन की तरह दौड़ता रहता है।
            वह दूसरों को कुचलकर आगे बढ़ने की कोशिश करता है और अपनी सफलता के अहंकार में वह अपने स्वास्थ्य और परिवार को भी बर्बाद कर देता है।
            यह कोई तरक्की नहीं है, बल्कि यह रजोगुण नाम के सॉफ्टवेयर का एक भयंकर वायरस है जो इंसान को अंदर से खोखला कर देता है।
            ऐसे इंसान के पास दुनिया की सारी सुख-सुविधाएं होती हैं लेकिन एक अच्छी नींद और दिमाग की शांति के लिए वह हमेशा तरसता है।
            भगवान कहते हैं कि रजोगुण की इस जलती हुई आग में पड़ने वाला इंसान कभी सुखी नहीं हो सकता, वह केवल एक मजदूर बनकर रह जाता है।
        """.trimIndent(),
        english = """
            O chief of the Bharatas! When the mode of passion (Rajas) violently increases and dominates, toxic symptoms of intense greed, endless fruitive activities, and intense endeavor rapidly develop.
            The human becomes aggressively driven to launch massively selfish, ego-driven new projects, working frantically like a maniac to acquire immense material wealth and worldly power.
            His baseline peace of mind is completely annihilated (Ashama), and he is perpetually tortured by an uncontrollable, burning thirst and insatiable craving (Spriha) to acquire more.
            This spectacular verse acts as the absolute, flawlessly perfect, and brutally honest mirror reflecting the toxic reality of the modern, ultra-competitive corporate world.
            Even if a human operating in Rajas successfully hoards billions of dollars, his psychological hunger is absolutely never satisfied; he perpetually cries and bleeds for more cash.
            He is biologically incapable of sitting peacefully in a room; his overheated brain runs 24/7 like a frantic supercomputer, constantly calculating the next massive deal or profit margin.
            He ruthlessly attempts to crush his competitors to climb the social ladder, and blinded by his toxic arrogance and ambition, he tragically destroys his own health and family.
            This is absolutely not genuine 'Progress'; it is a horrifying, lethal virus injected by the mode of passion that aggressively hollows out the human soul from the inside.
            Such a person may possess the absolute best luxury mansions and supercars on earth, yet he pathetically begs and starves for a single night of genuine, undisturbed peaceful sleep.
            The Lord explicitly warns that a human burning alive in the roaring fire of Rajas can never taste true happiness; he is reduced to a pathetic, highly-paid biological slave.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            अप्रकाशोऽप्रवृत्तिश्च प्रमादो मोह एव च |
            तमस्येतानि जायन्ते विवृद्धे कुरुनन्दन || १३ ||
        """.trimIndent(),
        hindi = """
            हे कुरुनन्दन! जब इंसान के शरीर और मन में तमोगुण बहुत ज्यादा बढ़ जाता है, तो उसके भीतर ज्ञान का प्रकाश पूरी तरह से गायब (अप्रकाश) हो जाता है।
            वह अपने ज़रूरी काम और ड्यूटी करने से पूरी तरह कतराता है (अप्रवृत्ति) और हर समय बिना किसी काम के सुस्त या खाली बैठा रहता है।
            उसके मन में प्रमाद यानी पागलपन और ऐसा भयंकर मोह पैदा हो जाता है कि वह सही और गलत के बीच का फर्क भी भूल जाता है।
            यह श्लोक डिप्रेशन, आलस्य और मानसिक पतन (Mental Degradation) की सबसे सटीक और वैज्ञानिक परिभाषा देता है।
            तमोगुणी व्यक्ति का दिमाग हमेशा एक धुंध और अंधेरे से भरा रहता है जहाँ कोई भी अच्छी या प्रेरणादायक बात उसे समझ नहीं आती।
            वह न तो समाज के लिए कुछ अच्छा करना चाहता है और न ही अपने खुद के भविष्य को सुधारने के लिए कोई मेहनत करता है।
            वह हमेशा नशे, नींद या फालतू के मनोरंजन में डूबा रहना पसंद करता है और ज़िम्मेदारी से भागने के बहाने ढूँढता रहता है।
            उसे अपनी बर्बादी साफ़ दिखाई देती है लेकिन फिर भी वह प्रमाद के कारण जानबूझकर गलत रास्ते पर ही चलता रहता है।
            भगवान अर्जुन को समझा रहे हैं कि यह तमोगुण इंसान का सबसे बड़ा दुश्मन है जो उसे इंसान से वापस जानवर की स्थिति में गिरा देता है।
            इस जानलेवा बीमारी से बचने के लिए इंसान को तुरंत एक्शन लेना चाहिए और अपने जीवन में ज्ञान और सत्त्व गुण को बढ़ाना चाहिए।
        """.trimIndent(),
        english = """
            O son of Kuru! When the mode of darkness and ignorance (Tamas) aggressively increases and dominates, absolute darkness, total inertia, madness, and deep illusion visibly manifest.
            The illumination of knowledge is completely blacked out (Aprakasha), and the human violently avoids executing his mandatory duties, choosing to remain pathetically inactive and heavily lethargic (Apravritti).
            His brain is violently hijacked by toxic madness (Pramada) and severe delusion (Moha), completely obliterating his fundamental common sense and the ability to distinguish between right and wrong.
            This incredible verse provides the absolute most precise, scientific, and clinical definition of clinical depression, chronic laziness, and total mental degradation.
            The brain of a human infected with Tamas is perpetually suffocated by a dense, toxic mental fog, making him entirely immune to any positive inspiration, logic, or uplifting wisdom.
            He possesses absolutely zero drive to contribute anything positive to society, and he aggressively refuses to put in even the minimal effort required to fix his own collapsing future.
            His ultimate, toxic preference is to remain permanently submerged in heavy intoxication, excessive sleep, or mindless entertainment, constantly inventing pathetic excuses to escape basic responsibilities.
            He can visually see his entire life crashing into absolute ruin, yet driven by the sheer madness of Pramada, he stubbornly and willfully sprints full-speed down the path of his own destruction.
            The Lord is forcefully warning Arjuna that this mode of ignorance is humanity's absolute most lethal enemy, violently downgrading a highly evolved human back into the pathetic state of a primitive animal.
            To survive this lethal psychological disease, a human must urgently force himself into violent, aggressive action and desperately seek the illuminating light of knowledge and goodness to reboot his system.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            यदा सत्त्वे प्रवृद्धे तु प्रलयं याति देहभृत् |
            तदोत्तमविदां लोकानमलान्प्रतिपद्यते || १४ ||
        """.trimIndent(),
        hindi = """
            जब किसी मनुष्य की मृत्यु ऐसे समय पर होती है जब उसके भीतर सत्त्व गुण पूरी तरह से बढ़ा हुआ और हावी होता है।
            तब वह जीवात्मा अपने इस शरीर को छोड़ने के बाद सीधे उन निर्मल और अत्यंत पवित्र लोकों को प्राप्त करती है जहाँ महान ज्ञानी और सिद्ध पुरुष रहते हैं।
            यह श्लोक 'द साइंस ऑफ डेथ एंड आफ्टरलाइफ' (The Science of Death and Afterlife) का सबसे बड़ा और महत्वपूर्ण नियम बताता है।
            मृत्यु के समय इंसान का जो 'माइंडसेट' (Mindset) या चेतना होती है, वही तय करती है कि उसे अगला जन्म कहाँ और कैसा मिलेगा।
            अगर इंसान ने पूरी ज़िंदगी अच्छे काम किए हैं, ज्ञान हासिल किया है और मृत्यु के समय उसका मन एकदम शांत और भगवान में लगा है।
            तो ब्रह्मांड का सिस्टम (System) उसे किसी आम योनि में नहीं डालता, बल्कि उसे 'महर्लोक' या 'ब्रह्मलोक' जैसे अत्यंत उच्च और वीआईपी लोकों में भेज देता है।
            वहाँ उसे कोई बीमारी या दुःख नहीं सताता और वह बड़े-बड़े ज्ञानियों के साथ रहकर अपनी आध्यात्मिक यात्रा को आगे बढ़ाता है।
            लेकिन यहाँ ध्यान देने वाली बात यह है कि वह अभी भी पूरी तरह मुक्त (मोक्ष) नहीं हुआ है, क्योंकि वह अभी भी प्रकृति के 'गुणों' (सत्त्व) के अधीन है।
            उसे उन उच्च लोकों से भी एक न एक दिन वापस आना ही पड़ता है जब उसके पुण्यों का सारा बैलेंस खत्म हो जाता है।
            इसलिए केवल सत्त्व गुण में मरना अच्छा तो है, लेकिन यह इंसान की आखिरी मंजिल या परम लक्ष्य बिल्कुल भी नहीं हो सकता।
        """.trimIndent(),
        english = """
            When a human being finally dies and his physical body meets destruction at a time when the mode of goodness (Sattva) is at its absolute peak and strongly predominant.
            Then that specific soul seamlessly ascends to the pure, highly elevated, and unpolluted higher planetary systems where the great, enlightened sages and perfected entities reside.
            This spectacular verse explicitly reveals the absolute, governing 'Science of Death and the Afterlife', decoding exactly how the cosmic routing system operates.
            The precise psychological 'Mindset' and dominant frequency of consciousness possessed by a human at the exact microsecond of death mathematically dictates his specific future destination.
            If a human has spent his entire timeline executing highly noble deeds and absorbing knowledge, and his brain remains flawlessly calm and focused on truth during his final breath.
            The universal software absolutely does not dump him into a random animal womb; it officially upgrades him to ultra-VIP, premium dimensions like Maharloka or Brahmaloka.
            In those elite realms, he suffers absolutely zero biological diseases or miseries, continuing his advanced spiritual evolution in the exclusive company of the multiverse's greatest scholars.
            However, there is a massive, highly critical cosmic 'Catch': He is absolutely NOT entirely liberated (Moksha) yet, because he is still legally operating within the jurisdiction of the material modes (Sattva).
            He is mathematically guaranteed to eventually fall back down to the earthly matrix the exact microsecond his massive bank balance of pious karma is officially exhausted.
            Therefore, while dying in the mode of goodness is a magnificent upgrade, it is absolutely, definitively NOT the final destination or the ultimate goal of human existence.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            रजसि प्रलयं गत्वा कर्मसङ्गिषु जायते |
            तथा प्रलीनस्तमसि मूढयोनिषु जायते || १५ ||
        """.trimIndent(),
        hindi = """
            जब किसी मनुष्य की मृत्यु रजोगुण के बहुत अधिक बढ़े होने पर होती है, तो वह सकाम कर्म करने वाले (यानी लालची और स्वार्थी) मनुष्यों के बीच जन्म लेता है।
            और उसी प्रकार, यदि किसी की मृत्यु तमोगुण के छाए रहने पर होती है, तो वह पशु, पक्षी या कीड़े-मकोड़ों जैसी अत्यंत मूढ़ (अज्ञानी) योनियों में जाकर जन्म लेता है।
            यह ब्रह्मांड का सबसे अचूक और कठोर नियम है कि इंसान की 'लास्ट थॉट' (Last Thought) ही उसकी 'नेक्स्ट डेस्टिनेशन' (Next Destination) को फिक्स करती है।
            अगर कोई इंसान मरते वक्त अपने पैसों, बिज़नेस या अधूरी इच्छाओं के बारे में पागलों की तरह सोच रहा है (रजोगुण), तो प्रकृति उसे फिर से इसी धरती पर किसी लालची और भागदौड़ करने वाले परिवार में इंसान बनाकर फेंक देती है।
            और यदि कोई इंसान ज़िंदगी भर आलसी रहा है, नशे में डूबा रहा है, या मरते समय अज्ञानता और मोह में फँसा है (तमोगुण)।
            तो ब्रह्मांड का एल्गोरिदम (Algorithm) यह तय करता है कि इस आत्मा को इंसान का दिमाग चाहिए ही नहीं, इसलिए इसे सीधे किसी जानवर या कीड़े के शरीर में डाउनलोड कर दिया जाए!
            जानवर की योनि (मूढ़योनि) में इंसान न तो कुछ नया सोच सकता है और न ही अपना विकास कर सकता है, वह बस अपनी पुरानी प्रवृत्तियों का गुलाम बनकर दुःख भोगता है।
            भगवान यहाँ बहुत ही कड़वी चेतावनी दे रहे हैं कि आपकी आज की आदतें और आपके शौक ही यह तय कर रहे हैं कि कल आप क्या बनने वाले हैं।
            यह कोई सज़ा नहीं है, बल्कि प्रकृति आपके ही विचारों के अनुसार आपको एक नया और उपयुक्त 'हार्डवेयर' (Hardware) प्रोवाइड कर रही है।
            इसलिए इंसान को जीते-जी अपने दिमाग को रजोगुण और तमोगुण की इस गंदगी से बाहर निकालकर हमेशा सतर्क और ज्ञानी बने रहना चाहिए।
        """.trimIndent(),
        english = """
            When a human dies while the mode of passion (Rajas) is heavily dominating his brain, he is forcefully reborn on earth directly among those who are entirely engaged in fruitive, selfish activities.
            And similarly, when a human physically expires while heavily submerged in the mode of ignorance (Tamas), he takes birth in the highly degraded, animalistic wombs of foolish and ignorant species.
            This is the absolute most flawless, unforgiving, and mathematical law of the cosmos: A human's 'Last Thought' and frequency at death irrevocably locks in his exact 'Next Destination'.
            If a man dies with his brain frantically obsessed over his billion-dollar empire, corporate deals, or unfulfilled lust (Rajas), nature ruthlessly respawns him right back on this stressful earth into a greedy, hustling family.
            And if a mortal has wasted his entire timeline being toxically lazy, heavily intoxicated, or dies trapped in blind delusion and deep ignorance (Tamas).
            The cosmic algorithm clinically determines that this specific soul absolutely does not require advanced human intelligence, and instantly downloads his consciousness into the biological body of an animal, bird, or insect!
            Inside an animalistic vessel (Mudha-yoni), the soul possesses absolutely zero capacity to philosophize or spiritually evolve; it merely suffers helplessly as a pathetic slave to primitive biological instincts.
            The Supreme Lord is issuing a brutally harsh warning here: Your current daily habits and toxic addictions are actively, right now, manufacturing the exact biological blueprint of your future body.
            This is absolutely not a vindictive punishment from God; it is simply Mother Nature flawlessly providing you with the exact biological 'Hardware' that perfectly matches your degraded software.
            Therefore, a human must urgently and violently drag his consciousness out of the toxic filth of passion and ignorance while he is still alive, remaining hyper-alert and deeply spiritual.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            कर्मणः सुकृतस्याहुः सात्त्विकं निर्मलं फलम् |
            रजसस्तु फलं दुःखमज्ञानं तमसः फलम् || १६ ||
        """.trimIndent(),
        hindi = """
            महान विद्वानों का यह कहना है कि सात्त्विक भाव से किए गए अच्छे और पुण्य कर्मों का फल हमेशा निर्मल, शुद्ध और सुख देने वाला होता है।
            परंतु रजोगुण के प्रभाव में आकर किए गए कर्मों का अंतिम फल हमेशा केवल 'दुःख' और भयंकर तनाव ही होता है।
            और तमोगुण के प्रभाव में आकर किए गए उल्टे-सीधे कर्मों का अंतिम रिज़ल्ट केवल घोर अज्ञान, अंधकार और पूरी बर्बादी ही होता है।
            यह श्लोक इंसान के किए गए एक्शन्स (Actions) और उनके फाइनल रिज़ल्ट्स (Final Results) का एक पक्का बैलेंस शीट (Balance Sheet) बता रहा है।
            जब आप बिना किसी स्वार्थ के, ईमानदारी और शांति के साथ कोई काम (सत्त्व) करते हैं, तो उसका नतीजा हमेशा मन की शांति और समाज का भला होता है।
            लेकिन जब आप केवल पैसे की भूख या दूसरों को नीचा दिखाने की होड़ में दिन-रात पागलों की तरह काम (रजस) करते हैं।
            तो बाहर से आपको कितनी भी बड़ी सफलता क्यों न मिल जाए, अंदर से वह सफलता आपको केवल ब्लड-प्रेशर, स्ट्रेस और भयंकर दुःख (Misery) ही देगी।
            और जो इंसान आलस्य में पड़कर या नशे में कोई गलत काम (तमस) करता है, उसका अंतिम परिणाम केवल मूर्खता और पतन (Downfall) ही होता है।
            भगवान कहते हैं कि इंसान को कोई भी कदम उठाने से पहले यह सोच लेना चाहिए कि वह किस 'गुण' के प्रभाव में आकर वह काम कर रहा है।
            अगर बीज ज़हर का है तो उससे अमृत का फल कभी नहीं मिल सकता, यह कर्म का एक अटल और बहुत ही कड़ा वैज्ञानिक नियम है।
        """.trimIndent(),
        english = """
            Great sages and elite scholars officially declare that the ultimate result of pious actions performed in the mode of goodness is entirely pure, flawless, and brings true happiness.
            But the inevitable, absolute final result of actions executed passionately in the mode of passion is strictly nothing but pure misery, devastating stress, and grief.
            And the final, inescapable consequence of actions performed blindly in the mode of ignorance is sheer foolishness, absolute darkness, and complete ruin.
            This spectacular verse provides the absolute, guaranteed 'Cosmic Balance Sheet' detailing exactly how specific actions (Karma) yield highly predictable final results.
            When you execute a task with titanium integrity, zero selfishness, and total inner peace (Sattva), the output is guaranteed to be flawlessly clean, generating profound mental satisfaction and societal welfare.
            But when you violently hustle 24/7 like a maniac, driven purely by a toxic hunger for billions and a desperate ego to crush competitors (Rajas).
            No matter how massive and glamorous your external financial success appears, internally that exact success will generate nothing but high blood pressure, crippling anxiety, and brutal 'Misery' (Duhkham).
            And for the ignorant human who acts out of toxic laziness, deep intoxication, or violent delusion (Tamas), the final product is mathematically guaranteed to be absolute stupidity and catastrophic downfall.
            The Lord demands that before a human executes any physical action, he must ruthlessly audit his own brain to check exactly which 'Mode' is currently supplying the fuel for that action.
            If you plant a highly toxic, poisonous seed, it is biologically impossible to harvest the nectar of immortality; this is the unbreakable, scientific law of karmic reaction.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            सत्त्वात्सञ्जायते ज्ञानं रजसो लोभ एव च |
            प्रमादमोहौ तमसो भवतोऽज्ञानमेव च || १७ ||
        """.trimIndent(),
        hindi = """
            सत्त्व गुण के लगातार प्रभाव से मनुष्य के भीतर वास्तविक 'ज्ञान' और सही-गलत को समझने की स्पष्ट दृष्टि पैदा होती है।
            रजोगुण के प्रभाव से मनुष्य के अंदर भयंकर 'लोभ' यानी धन और सांसारिक सुखों की कभी न खत्म होने वाली प्यास पैदा होती है।
            और तमोगुण के प्रभाव से इंसान के अंदर 'प्रमाद' (पागलपन), 'मोह' (चीज़ों से अंधा लगाव) और घोर 'अज्ञान' (मूर्खता) ही पैदा होता है।
            यह श्लोक इन तीनों गुणों की फैक्ट्री (Factory) से निकलने वाले मेन प्रोडक्ट्स (Main Products) की बहुत ही सटीक लिस्ट देता है।
            अगर आप किसी इंसान के अंदर बहुत ज्यादा 'ज्ञान', समझदारी और शांत स्वभाव देखते हैं, तो समझ लीजिए कि उसका इंजन 'सत्त्व गुण' के ईंधन से चल रहा है।
            अगर आपको कोई ऐसा व्यक्ति दिखे जो हमेशा पैसों के पीछे भाग रहा है, जो कभी संतुष्ट नहीं होता और हमेशा बेचैन रहता है, तो उसका सॉफ्टवेयर 100% 'रजोगुण' से हैक हो चुका है।
            और अगर आपको कोई ऐसा इंसान मिले जो दिन भर सोता रहता है, नशे में रहता है, और अपनी बर्बादी देखकर भी नहीं सुधरता, तो वह 'तमोगुण' का गुलाम बन चुका है।
            भगवान अर्जुन को एक साइकोलॉजिस्ट (Psychologist) की तरह यह टूल (Tool) दे रहे हैं जिससे वह खुद को और दुनिया को आसानी से जज (Judge) कर सके।
            यह जानकर इंसान खुद का 'सेल्फ-असेसमेंट' (Self-assessment) कर सकता है कि वह अभी ज़िंदगी में किस गुण के रास्ते पर जा रहा है।
            ज्ञान की रोशनी, लालच की आग और अज्ञान का अंधेरा—यही इन तीनों गुणों की असली और एकमात्र पहचान है।
        """.trimIndent(),
        english = """
            From the mode of goodness, genuine, illuminating knowledge and crystal-clear vision of reality naturally and spontaneously develop.
            From the mode of passion, intense, toxic greed and a burning, insatiable thirst for material wealth and power exclusively develop.
            And from the mode of ignorance, absolute madness (Pramada), blinding delusion (Moha), and sheer, pathetic foolishness (Ajnana) inevitably manifest.
            This spectacular verse provides the exact, highly precise list of the ultimate 'Main Products' biologically manufactured by the factories of these three modes.
            If you witness a human operating with staggeringly profound 'Wisdom', deep emotional stability, and a completely calm demeanor, you must instantly know his internal engine runs strictly on the premium fuel of 'Sattva'.
            If you observe a manic individual relentlessly sprinting after billions, absolutely never satisfied, and perpetually vibrating with toxic anxiety, his psychological software has been 100% hijacked by 'Rajas'.
            And if you encounter a tragic entity who sleeps endlessly, remains heavily intoxicated, and willfully destroys his own life without a shred of common sense, he is completely enslaved by the dark chains of 'Tamas'.
            The Lord is equipping Arjuna with the ultimate, elite psychological diagnostic 'Tool' to flawlessly read and judge both his own mind and the entire global population.
            Armed with this highly classified data, a human can execute a brutal 'Self-Assessment' to accurately pinpoint exactly which trajectory his life is currently spiraling towards.
            The brilliant light of knowledge, the roaring fire of greed, and the pitch-black darkness of ignorance—these are the absolute, undeniable fingerprints of the three material modes.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            ऊर्ध्वं गच्छन्ति सत्त्वस्था मध्ये तिष्ठन्ति राजसाः |
            जघन्यगुणवृत्तिस्था अधो गच्छन्ति तामसाः || १८ ||
        """.trimIndent(),
        hindi = """
            जो लोग सत्त्व गुण में स्थित होते हैं, वे मृत्यु के बाद ऊपर की ओर यानी उच्च और पवित्र लोकों (स्वर्ग आदि) में जाते हैं।
            जो लोग रजोगुण में डूबे रहते हैं, वे बीच में ही लटके रहते हैं यानी वे बार-बार इसी मनुष्य लोक (पृथ्वी) में ही जन्म लेते और मरते रहते हैं।
            और जो लोग सबसे घटिया और नीच तमोगुण की प्रवृत्तियों में फँसे रहते हैं, वे हमेशा नीचे की ओर यानी पशु-पक्षियों की योनियों या भयंकर नर्कों में गिर जाते हैं।
            यह श्लोक ब्रह्मांड के 'ग्रेविटेशनल लॉ' (Gravitational Law / आकर्षण के नियम) का आध्यात्मिक और सबसे सटीक वर्ज़न (Version) है।
            सत्त्व गुण एक 'हीलियम बैलून' (Helium Balloon) की तरह बहुत हल्का होता है; इसलिए सात्त्विक इंसान की आत्मा स्वाभाविक रूप से ऊपर (ऊर्ध्वं) के महान लोकों की तरफ उठ जाती है।
            रजोगुण इंसान को दुनिया की वासनाओं और इच्छाओं के भारी वज़न से बाँध कर रखता है; इसलिए वह आत्मा न तो ऊपर उड़ पाती है और न नीचे गिरती है, वह 'पृथ्वी' (Earth) पर ही अटकी रहती है।
            तमोगुण सबसे भारी और कचरे के समान होता है; इसलिए तमोगुणी आत्मा एक पत्थर की तरह सीधे नीचे (अधो) जाकर पाताल या जानवरों की डरावनी योनियों में धंस जाती है।
            ब्रह्मांड का यह सिस्टम किसी के साथ कोई भेदभाव या नाइंसाफी नहीं करता; वह सिर्फ आपके गुणों के वज़न के हिसाब से आपकी जगह तय कर देता है।
            इंसान खुद अपनी आज की आदतों से अपनी आत्मा के लिए लिफ्ट (Elevator) का बटन दबा रहा है—कि उसे ऊपर जाना है, बीच में रहना है, या सीधे नीचे नर्क में जाना है।
            यह बहुत ही सीधी और डरावनी चेतावनी है कि अपनी प्रकृति (स्वभाव) को सुधारना क्यों सबसे ज्यादा ज़रूरी है।
        """.trimIndent(),
        english = """
            Those perfectly situated in the mode of goodness gradually go upward to the higher, supremely pure planetary systems (Heavenly realms).
            Those who are heavily absorbed in the mode of passion remain permanently stuck in the middle, continuously taking birth as struggling mortals on this earthly planet.
            And those pathetically trapped in the abominable, lowest mode of ignorance violently glide downwards into the hellish worlds and degraded animal species.
            This phenomenal verse acts as the absolute spiritual version of the universe's strict 'Law of Gravity', flawlessly detailing the exact trajectory of the soul.
            The mode of goodness acts exactly like a highly buoyant 'Helium Balloon'; it makes the consciousness so incredibly light and pure that the soul naturally floats 'Upwards' (Urdhvam) to elite, celestial dimensions.
            The mode of passion violently weighs the soul down with the heavy luggage of toxic desires and massive earthly ambitions, keeping it permanently grounded and 'Stuck' strictly within this middle earthly matrix.
            The mode of ignorance is incredibly dense, toxic, and heavy like a massive boulder; therefore, a Tamasic soul rapidly plummets straight 'Downwards' (Adho) into the terrifying abyss of hellish dimensions or mindless animal wombs.
            The cosmic operating system possesses zero bias and executes absolutely no unfair judgments; it simply automatically routes your soul based entirely on the specific 'Weight' of the psychological modes you carry.
            A human being, through his daily biological habits, is actively pressing the buttons on his soul's 'Elevator' right now—choosing whether to ascend, stagnate, or violently crash down into the basement of existence.
            This is a brutally straightforward and terrifying cosmic warning emphasizing exactly why forcefully upgrading your internal character is the ultimate matter of spiritual survival.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            नान्यं गुणेभ्यः कर्तारं यदा द्रष्टानुपश्यति |
            गुणेभ्यश्च परं वेत्ति मद्भावं सोऽधिगच्छति || १९ ||
        """.trimIndent(),
        hindi = """
            जब कोई ज्ञानी दृष्टा (देखने वाला) यह भली-भांति जान लेता है कि इस संसार के सभी कर्मों को करने वाले केवल ये 'तीन गुण' ही हैं और इनके अलावा दूसरा कोई कर्ता नहीं है।
            और जब वह उस परमेश्वर को जान लेता है जो इन तीनों भौतिक गुणों से पूरी तरह परे (ऊपर) है, तब वह ज्ञानी मेरे ही ईश्वरीय स्वरूप (मद्भावं) को प्राप्त कर लेता है।
            यह श्लोक 'द मैट्रिक्स' (The Matrix) के इस खेल से बाहर निकलने का सबसे बड़ा और अंतिम 'चीट-कोड' (Cheat-code) बताता है!
            भगवान कहते हैं कि जब तक तुम सोचते हो कि "मैं यह काम कर रहा हूँ," तब तक तुम फंसे हुए हो। लेकिन जिस दिन तुम एक 'ऑब्ज़र्वर' (Observer / दृष्टा) बन जाते हो...
            तब तुम देखते हो कि तुम्हारे अंदर का गुस्सा, लालच, या प्यार तुम्हारी आत्मा नहीं कर रही; यह सब तो केवल प्रकृति के 3 गुण (सॉफ़्टवेयर) आपस में कर रहे हैं।
            तुम बस शांति से पीछे बैठकर उस मशीन (शरीर) के ड्रामे को देखते हो और खुद को उस मशीन से 100% अलग (Detached) कर लेते हो।
            और फिर तुम उस 'परमेश्वर' से जुड़ जाते हो जो इन तीनों गुणों से भी ऊपर (परं) का सुप्रीम कंट्रोलर (Supreme Controller) है।
            जैसे ही इंसान का दिमाग इस लेवल का 'सुपर-अवेयरनेस' (Super-awareness) हासिल कर लेता है, प्रकृति के गुण उस पर अपना जादू करना बंद कर देते हैं।
            वह इंसान जीते-जी इस दुनिया की सारी मोह-माया से आज़ाद हो जाता है और मरने के बाद वह सीधा भगवान के परम धाम (वैकुंठ) में वीआईपी एंट्री पा लेता है।
            प्रकृति को प्रकृति का काम करने दो और तुम आत्मा बनकर परमात्मा से जुड़ जाओ—यही मुक्ति का अचूक फॉर्मूला है।
        """.trimIndent(),
        english = """
            When a highly enlightened seer properly perceives that in all activities absolutely no other agent is at work besides these three modes of nature.
            And when he fundamentally knows and realizes the Supreme Lord, who is completely transcendental and situated infinitely beyond all these modes, he flawlessly attains My divine spiritual nature.
            This spectacular verse drops the absolute ultimate 'Cheat-Code' required to successfully permanently hack and exit the terrifying material 'Matrix'!
            The Lord explicitly declares that as long as your ego violently screams, "I am the doer of this action," you remain hopelessly imprisoned. But the exact day you upgrade your consciousness to become a neutral, silent 'Observer' (Drashta)...
            You brilliantly realize that your intense anger, toxic greed, or even your deep empathy are absolutely NOT generated by your pure soul; they are merely the three pre-programmed modes (Software) interacting mechanically with each other.
            You calmly sit back deep within your consciousness, completely detaching your eternal identity from the chaotic biological drama happening inside your physical machine.
            Simultaneously, you connect your focus entirely to the Supreme Godhead, who is the ultimate 'Admin' existing completely independent and far 'Beyond' (Param) these three restricting algorithms.
            The microsecond a human brain achieves this staggering altitude of 'Super-Awareness', the material modes instantly lose their hypnotic power to control or manipulate him.
            He becomes completely, flawlessly liberated (A Jivan-mukta) while still breathing in this world, and upon his biological death, he secures a direct, non-stop VIP flight into God's eternal kingdom.
            Let dead nature perform nature's work, while you act as the pure spirit connecting exclusively to the Supreme Spirit—this is the absolute, foolproof formula for ultimate liberation.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            गुणानेतानतीत्य त्रीन्देही देहसमुद्भवान् |
            जन्ममृत्युजरादुःखैर्विमुक्तोऽमृतमश्नुते || २० ||
        """.trimIndent(),
        hindi = """
            जब यह शरीर धारी जीव (आत्मा) इस भौतिक शरीर को उत्पन्न करने वाले इन तीनों गुणों (सत्त्व, रजस, तमस) को पूरी तरह से लांघ (पार कर) जाता है।
            तब वह जन्म, मृत्यु, बुढ़ापा और सभी प्रकार के भयंकर दुखों से हमेशा के लिए मुक्त होकर परम 'अमृत' (अमरता और ईश्वरीय आनंद) का स्वाद चखता है।
            पिछले श्लोक में भगवान ने गुणों से बाहर निकलने का तरीका बताया था, और इस श्लोक में वे उसका 'अल्टीमेट रिज़ल्ट' (Ultimate Result / परम फल) बता रहे हैं।
            जब इंसान इन तीनों गुणों से ऊपर उठकर 'गुणातीत' (Transcendental) बन जाता है, तो उसके ऊपर से प्रकृति के सारे कड़े नियम (Laws of Nature) हटा लिए जाते हैं।
            उसका शरीर तो दुनिया में रहता है, लेकिन आत्मा उन चार सबसे खौफनाक दुश्मनों—जन्म, बुढ़ापा, बीमारी और मौत (मृत्यु)—की पहुँच से हमेशा के लिए बाहर हो जाती है।
            हम इंसान दुनिया की महंगी क्रीम (Creams) या दवाइयों से बुढ़ापा और मौत रोकना चाहते हैं, लेकिन वो नामुमकिन है।
            भगवान गारंटी देते हैं कि जो इंसान मेरे ज्ञान से इन तीन गुणों को हरा देता है, उसे असल में 'अमृत' (Immortality) मिल जाता है।
            यह अमृत कोई पीने वाली चीज़ नहीं है, यह वो 'सुप्रीम स्टेट ऑफ माइंड' (Supreme State of Mind) है जहाँ इंसान को दुनिया का कोई दुःख छू तक नहीं सकता।
            वह इंसान मौत आने से पहले ही मौत को जीत चुका होता है और हमेशा के लिए एक आनंदमयी और अमर अवस्था में पहुँच जाता है।
            यह श्लोक साबित करता है कि इंसान का असली लक्ष्य केवल अच्छे काम करके स्वर्ग जाना नहीं, बल्कि गुणों से पूरी तरह मुक्त होकर भगवान को पाना है।
        """.trimIndent(),
        english = """
            When the embodied soul successfully transcends and completely crosses beyond these three modes of material nature associated with the biological body.
            He becomes utterly and eternally freed from the horrific miseries of birth, death, agonizing old age, and all distress, successfully tasting the nectar of absolute immortality (Amritam) even in this very life.
            In the previous verse, the Lord revealed the exact mechanism to escape the modes; in this spectacular verse, He announces the 'Ultimate Grand Prize' (Result) of executing that hack.
            When a human violently elevates his consciousness above all three modes to become 'Gunatita' (Transcendental), all the brutal, restricting laws of material nature are instantly deactivated for him.
            His physical vessel continues to exist in the matrix, but his internal soul is permanently relocated far beyond the reach of humanity's four absolute most terrifying predators: Birth, Disease, Aging, and Death.
            Ignorant mortals desperately waste billions on fake anti-aging cosmetics and advanced medical surgeries to outrun death, which is biologically impossible.
            The Lord signs a titanium guarantee: Any human who successfully defeats these three psychological modes utilizing My supreme knowledge literally attains true 'Immortality' (Amritam).
            This nectar is absolutely not a physical drink; it is an impenetrable 'Supreme State of Consciousness' where absolutely no worldly tragedy or pain can scratch or penetrate his mind.
            He has definitively conquered the Grim Reaper long before his physical heartbeat stops, permanently locking himself into a state of infinite, indestructible, ecstatic bliss.
            This verse powerfully proves that the ultimate target of human life is absolutely not merely doing good deeds to earn a temporary vacation in Heaven, but completely shattering the modes to attain the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            अर्जुन उवाच |
            कैर्लिङ्गैस्त्रीन्गुणानेतानतीतो भवति प्रभो |
            किमाचारः कथं चैतांस्त्रीन्गुणानतिवर्तते || २१ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने पूछा: हे प्रभो! जो मनुष्य इन तीनों भौतिक गुणों को पार कर चुका है (गुणातीत हो गया है), उसके लक्षण (पहचानने के चिन्ह) क्या होते हैं?
            उसका आचरण (व्यवहार और बर्ताव) कैसा होता है? और वह मनुष्य किस विशेष उपाय के द्वारा इन तीनों गुणों को लांघकर उनसे ऊपर उठता है?
            भगवान की बातें सुनकर अर्जुन का जिज्ञासु और विश्लेषणात्मक (Analytical) दिमाग बहुत तेज़ी से काम करने लगता है।
            अर्जुन समझ गए हैं कि 'गुणातीत' (Transcendental) होना ही जीवन का सबसे बड़ा और अल्टीमेट लक्ष्य है।
            लेकिन अर्जुन कोई हवा-हवाई बात नहीं चाहते; वे भगवान से एक 'चेकलिस्ट' (Checklist) या व्यावहारिक (Practical) लक्षण मांगते हैं ताकि वे ऐसे महान इंसान को पहचान सकें।
            अर्जुन सीधे 3 बहुत ही टू-द-पॉइंट (To-the-point) सवाल पूछते हैं:
            पहला सवाल: "उस ज्ञानी इंसान की पहचान ('लिङ्गैः') क्या है? मैं उसे भीड़ में कैसे पहचानूंगा?"
            दूसरा सवाल: "उसका बर्ताव ('आचारः') कैसा होता है? वह आम इंसानों की तरह रोता या हंसता है, या उसका व्यवहार कुछ अलग होता है?"
            तीसरा और सबसे ज़रूरी सवाल: "उसने इन तीनों गुणों के जाल को तोड़ा 'कैसे' ('कथं')? मुझे वह सटीक प्रक्रिया (Process) बताइए जिससे मैं भी आज़ाद हो सकूँ।"
            अर्जुन के ये 3 सवाल पूरे मानव इतिहास के सबसे ज़रूरी सवाल हैं, जिनका जवाब भगवान अगले 6 श्लोकों में बहुत ही विस्तार और गहराई से देंगे।
        """.trimIndent(),
        english = """
            Arjuna inquisitively asked: O my dear Lord! By which specific symptoms and clear signs can one recognize a person who is completely transcendental to these three modes of nature?
            What exactly is his behavior and daily conduct? And by what specific, actionable process does he successfully transcend and conquer these three powerful modes?
            Upon hearing the Lord's staggering revelations, Arjuna's highly inquisitive and razor-sharp 'Analytical' brain immediately kicks into high gear.
            Arjuna has perfectly realized that becoming 'Gunatita' (Transcendental to the modes) is the absolute greatest and ultimate objective of the human experience.
            But Arjuna absolutely despises vague, theoretical philosophy; he aggressively demands a practical, clinical 'Checklist' of observable symptoms so he can easily identify such an elite, superhuman entity in the real world.
            Arjuna fires exactly 3 highly specific, point-blank, and profoundly critical questions directly at the Lord:
            Question 1: "What are the exact physiological and psychological 'Symptoms' (Lingaih) of such a master? How do I spot him in a massive crowd?"
            Question 2: "What is his exact 'Behavior' (Acharah) under extreme pressure? Does he react to tragedy and joy exactly like an ordinary, ignorant mortal, or is his reaction fundamentally alien?"
            Question 3 (The most critical): "EXACTLY HOW ('Katham') did he successfully hack and break out of this terrifying three-mode matrix? Give me the precise step-by-step procedure so I can execute my own escape."
            These 3 specific questions from Arjuna are arguably the most important inquiries in human history, to which the Lord will generously provide the ultimate, detailed answers in the upcoming 6 verses.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            श्रीभगवानुवाच |
            प्रकाशं च प्रवृत्तिं च मोहमेव च पाण्डव |
            न द्वेष्टि सम्प्रवृत्तानि न निवृत्तानि काङ्क्षति || २२ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 22 से 25 तक भगवान उन 3 सवालों के जवाब दे रहे हैं)
            श्री भगवान ने कहा: हे पाण्डव! जो मनुष्य सत्त्व गुण के 'प्रकाश' (ज्ञान), रजोगुण की 'प्रवृत्ति' (कामकाज), और तमोगुण के 'मोह' (नींद या अज्ञान) के उत्पन्न होने पर उनसे नफरत (द्वेष) नहीं करता है।
            और जब ये तीनों गुण उसके जीवन से चले जाते हैं (निवृत्त हो जाते हैं), तो वह उनके वापस आने की कोई लालसा या इच्छा (काङ्क्षति) भी नहीं करता है... (वह गुणातीत है)।
            भगवान यहाँ अर्जुन के पहले सवाल (उसकी पहचान क्या है?) का सबसे शानदार और मनोवैज्ञानिक (Psychological) जवाब दे रहे हैं।
            साधारण इंसान हमेशा 'रिएक्ट' (React) करता है; जब उसका दिमाग शांत (सत्त्व) होता है तो वह खुश होता है, और जब वह आलस (तमस) में होता है तो खुद से नफरत करता है।
            लेकिन 'गुणातीत' (मुक्त) इंसान का दिमाग एक शांत दर्शक (Observer) बन चुका होता है।
            जब उसके शरीर या मन में बहुत ज्ञान और शांति (प्रकाश) आती है, तो वह उसमें लिप्त नहीं होता; और जब उसे भयंकर नींद या आलस (मोह) आता है, तो वह खुद को गालियां नहीं देता ('न द्वेष्टि')।
            वह जानता है कि ये सारे गुण केवल 'शरीर रूपी मशीन' में आ और जा रहे हैं; आत्मा का इनसे कोई लेना-देना नहीं है।
            इसलिए वह इन गुणों के आने पर न तो उछलता है और न ही इनके जाने पर उदास होकर इन्हें वापस बुलाने की कोशिश करता है ('न काङ्क्षति')।
            उसकी सबसे बड़ी पहचान यही है कि वह अपने ही शरीर और मन के भीतर होने वाले नाटकों को 100% डिटैचमेंट (Detachment) के साथ चुपचाप देखता रहता है।
        """.trimIndent(),
        english = """
            (From Verse 22 to 25, the Lord systematically answers Arjuna's 3 questions)
            The Supreme Personality of Godhead declared: O son of Pandu! He who absolutely does not hate or despise illumination (the effect of goodness), active attachment (the effect of passion), or blinding delusion (the effect of ignorance) when they visibly manifest in his body.
            And who absolutely does not intensely long for them, crave them, or cry for them when they completely disappear and pass away... (he is said to have transcended the modes).
            The Lord is delivering the absolute most spectacular, highly psychological answer to Arjuna's first question (What are his identifying symptoms?).
            An ordinary, ignorant mortal is a pathetic slave to his reactions; he is highly ecstatic when his brain is peaceful (Sattva), and he violently hates himself when he succumbs to toxic laziness (Tamas).
            But the elite, 'Gunatita' (Liberated) master has successfully upgraded his consciousness to become an entirely neutral, silent 'Observer'.
            When his biological machine is flooded with brilliant knowledge and peace (Prakasha), he absolutely does not become arrogantly attached to it; and when temporary waves of extreme lethargy or delusion (Moha) strike, he does not hurl toxic abuse at himself ('Na dveshti').
            He possesses the flawless scientific understanding that these modes are merely temporary algorithms randomly passing through his 'Biological Hardware'; his pure soul remains entirely unaffected.
            Therefore, he neither violently rejoices when these modes enter his system, nor does he pathetically crave or violently beg for them ('Na kankshati') when they naturally evaporate.
            His absolute greatest identifying symptom is his terrifyingly calm 'Detachment'; he watches the chaotic chemical drama unfolding directly inside his own brain with 100% cold, objective neutrality.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            उदासीनवदासीनो गुणैर्यो न विचाल्यते |
            गुणा वर्तन्त इत्येव योऽवतिष्ठति नेङ्गते || २३ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य एक 'उदासीन' (तटस्थ / Neutral Umpire) की तरह स्थित रहता है, और प्रकृति के इन गुणों (सुख-दुख) के द्वारा जो कभी भी विचलित (Disturb) नहीं किया जा सकता।
            वह यह पक्का समझकर कि "केवल गुण ही अपने-अपने कार्यों में बरत रहे हैं (मशीन काम कर रही है)", हमेशा अपनी आत्मा में ही स्थित रहता है और अपनी स्थिति से एक इंच भी नहीं हिलता (नेङ्गते)।
            भगवान यहाँ अर्जुन के दूसरे सवाल (उसका बर्ताव कैसा होता है?) का जवाब दे रहे हैं।
            उस महान ज्ञानी का व्यवहार दुनिया के लिए बहुत ही अजीब और हैरान करने वाला होता है। वह दुनिया के बीच रहकर भी 'उदासीन' (Completely Neutral) होता है।
            जैसे क्रिकेट के मैदान में खिलाड़ी लड़ते और दौड़ते हैं, लेकिन 'अंपायर' (Umpire) किसी भी टीम से नहीं जुड़ता, वह केवल शांति से तमाशा देखता है; ठीक वैसे ही वह ज्ञानी रहता है।
            अगर उसे बहुत बड़ा नुकसान हो जाए या बहुत बड़ी जीत मिल जाए, तो भी प्रकृति के गुण उसके दिमाग के बैलेंस (Balance) को 'हिला नहीं सकते' (न विचाल्यते)।
            क्यों? क्योंकि उसका लॉजिक (Logic) एकदम क्लियर है! वह जानता है कि "गुणा वर्तन्त" (यह जो भी ड्रामा हो रहा है, यह सिर्फ प्रकृति के गुणों का आपस में खेल है; मेरी आत्मा का इसमें कोई नुकसान नहीं हो रहा है)।
            इस भयंकर और पक्के ज्ञान के कारण, वह किसी भी तूफ़ान में अपनी जगह से 'टस से मस नहीं होता' (नेङ्गते)। उसका मन एक भारी चट्टान की तरह स्थिर हो जाता है।
            यह 'इमोशनल स्टेबिलिटी' (Emotional Stability) का सबसे ऊँचा और सुप्रीम लेवल है जहाँ इंसान दुनिया की हर परिस्थिति से 100% आज़ाद हो जाता है।
        """.trimIndent(),
        english = """
            He who is situated strictly as neutral, completely unconcerned, and utterly aloof, and who is absolutely never agitated or disturbed by the volatile interactions of the material modes.
            He remains totally firm, unshakeable, and unmoving (Nengate), operating on the absolute scientific conviction that "Only the material modes are actively engaged in performing these actions."
            The Lord is brilliantly answering Arjuna's second question here regarding the exact 'Behavior' and daily conduct of a liberated master.
            The behavior of such an elite sage appears incredibly bizarre and astonishing to the ignorant masses; he actively lives in the chaotic matrix but remains staggeringly 'Udasina' (100% Coldly Neutral).
            Imagine a brutal, high-stakes football match where players are violently tackling each other, but the 'Referee' absolutely refuses to emotionally attach himself to either team, merely watching the drama objectively; the sage operates his life exactly like that Referee.
            Even if a catastrophic financial loss strikes or a massive global victory is achieved, the turbulent modes of nature absolutely fail to 'Shake or Agitate' (Na vichalyate) his titanium mental equilibrium.
            Why? Because his underlying quantum logic is flawlessly clear! He scientifically knows, "Guna vartanta" (This entire terrifying drama is merely the pre-programmed algorithms of nature blindly interacting with each other; my eternal soul is totally unharmed).
            Armed with this brutal, undeniable truth, he remains deeply anchored in his spiritual identity, completely refusing to flinch or vibrate even a single millimeter ('Nengate') during the worst cosmic hurricanes.
            This represents the absolute, supreme pinnacle of 'Emotional Stability', where a human being achieves 100% psychological immunity and unshakeable freedom from every extreme situation the universe can throw at him.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            समदुःखसुखः स्वस्थः समलोष्टाश्मकाञ्चनः |
            तुल्यप्रियाप्रियो धीरस्तुल्यनिन्दात्मसंस्तुतिः || २४ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 24 और 25 एक ही विचार का हिस्सा हैं)
            वह ज्ञानी मनुष्य दुःख और सुख को बिल्कुल एक समान (बराबर) समझता है (समदुःखसुखः), वह हमेशा अपने आत्म-स्वरूप में ही स्थित रहता है (स्वस्थः), और वह मिट्टी के ढेले, पत्थर और सोने को भी एक समान (बराबर मूल्य का) ही मानता है (समलोष्टाश्मकाञ्चनः)।
            वह धीर (बुद्धिमान) पुरुष अपने लिए प्रिय (अच्छी) और अप्रिय (बुरी) लगने वाली चीज़ों में समान रहता है, तथा अपनी निंदा (कठोर बुराई) और स्तुति (झूठी तारीफ) को भी बिल्कुल एक जैसा ही समझता है।
            भगवान उस 'गुणातीत' (मुक्त) मनुष्य के व्यवहार की और भी गहरी और हैरान करने वाली डिटेल्स (Details) दे रहे हैं।
            उसकी नज़र में इस भौतिक दुनिया का सबसे बड़ा झूठ 'वैल्यू सिस्टम' (Value System) है। 
            हम इंसान 'सोने' (Gold) के लिए खून कर सकते हैं और मिट्टी को लात मारते हैं, लेकिन उस ज्ञानी के लिए मिट्टी, पत्थर और 24-कैरेट का सोना... तीनों की वैल्यू 100% बराबर है! क्योंकि वह जानता है कि मरने के बाद तीनों यहीं पड़े रहने वाले हैं।
            उसका रिमोट कंट्रोल उसके अपने हाथ में होता है ('स्वस्थः')। जब कोई उसकी बहुत भयंकर बेइज़्जती (निंदा) करता है, या जब कोई उसे माला पहनाकर उसकी झूठी तारीफ (स्तुति) करता है...
            तो वह न तो डिप्रेशन में जाता है और न ही अहंकार से फूलता है। उसके लिए ताली और गाली दोनों केवल 'साउंड वेव्स' (Sound-waves / हवा की आवाज़) हैं।
            वह सुख-दुःख और अच्छे-बुरे हालातों में एक अजेय चट्टान की तरह 'धीर' (Steadfast) बना रहता है। उसका यह समभाव (Equanimity) ही उसकी सबसे बड़ी ताकत है।
        """.trimIndent(),
        english = """
            (Verses 24 and 25 form a continuous, spectacular description of a liberated soul)
            That truly wise person treats devastating distress and euphoric happiness as completely equal and identical (Sama-duhkha-sukhah). He is permanently situated in the self (Sva-sthah), and he objectively views a lump of earth, a stone, and solid gold as possessing the exact same value.
            He is profoundly steady and unshakeable (Dhirah), remaining absolutely equal and indifferent toward both the favorable and the unfavorable, and he mathematically equates the worst vicious defamation with the highest glorious praise (Tulya-nindatma-samstutih).
            The Lord continues to drop mind-bending, highly detailed specifics regarding the bizarre, superhuman 'Behavior' of a soul who has successfully hacked the material modes.
            In his elite perspective, the absolute biggest scam in the physical universe is humanity's completely fake, toxic 'Value System'.
            Ignorant mortals will ruthlessly murder each other for a block of 'Solid Gold' while kicking dirt aside, but to the enlightened master, a lump of mud, a random rock, and a 24-karat gold bar possess exactly 100% identical value! He scientifically knows all three are just temporary atoms that will be left behind at death.
            He holds the master 'Remote Control' to his own brain ('Sva-sthah'). When toxic society hurls vicious, soul-crushing insults (Defamation) at him, or when sycophants blindly worship and shower him with heavy praises (Honor)...
            He absolutely does not spiral into suicidal depression, nor does his ego inflate like a toxic balloon. To him, both the applause and the abuses are literally nothing but empty, meaningless 'Sound-Waves' vibrating through the air.
            He remains firmly anchored like an invincible, titanium mountain ('Dhirah') through all catastrophic tragedies and massive successes. This terrifying, unshakeable 'Equanimity' is his absolute greatest superpower.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            मानापमानयोस्तुल्यस्तुल्यो मित्रारिपक्षयोः |
            सर्वारम्भपरित्यागी गुणातीतः स उच्यते || २५ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य समाज में मिलने वाले बहुत बड़े सम्मान (मान) और भयंकर बेइज़्जती (अपमान) में भी बिल्कुल एक समान (तुल्य) रहता है, और जो अपने सच्चे मित्रों (दोस्तों) तथा भयंकर शत्रुओं (दुश्मनों) के प्रति भी एक समान भाव रखता है।
            तथा जिसने अहंकारवश शुरू किए जाने वाले सभी नए कर्मों और सांसारिक प्रोजेक्ट्स (सर्वारम्भ) का पूरी तरह से त्याग कर दिया है (परित्यागी)... ऐसा व्यक्ति ही वास्तव में तीनों गुणों से पार (गुणातीतः) कहा जाता है।
            यह श्लोक 'गुणातीत' इंसान की प्रोफाइल (Profile) का ग्रैंड-फिनाले (Grand Finale) है, जहाँ वह दुनिया के सबसे मुश्किल 'सोशल टेस्ट' (Social Test) को भी पास कर लेता है।
            समाज में 'मान और अपमान' इंसान को अंदर से तोड़ देते हैं, लेकिन ज्ञानी व्यक्ति के लिए ये दोनों चीज़ें बिल्कुल बराबर ('तुल्य') होती हैं।
            उससे भी बड़ी बात! वह अपने सबसे प्यारे दोस्त और अपने खून के प्यासे दुश्मन को एक ही नज़र से देखता है। वह किसी से कोई 'पक्षपात' (Bias) नहीं करता, क्योंकि वह जानता है कि दोनों के अंदर एक ही परमात्मा बैठा है।
            और उसका सबसे बड़ा एक्शन (Action) क्या होता है? "सर्वारम्भपरित्यागी"! वह अपना नाम कमाने या अरबपति बनने के लिए कोई भी नया 'स्टार्टअप' (Startup) या फालतू का 'बखेड़ा' शुरू नहीं करता। 
            वह केवल वही ज़रूरी काम करता है जो भगवान ने उसे दिए हैं या जो समाज के भले के लिए ज़रूरी हैं। उसके सारे काम स्वार्थ-रहित होते हैं।
            जिस इंसान के अंदर ये सारी अकल्पनीय (Unimaginable) क्वालिटीज़ आ जाती हैं, भगवान उसी इंसान को ऑफिशियली 'गुणातीत' (The Liberated Master) घोषित करते हैं।
        """.trimIndent(),
        english = """
            He who remains completely unflinching, treating profound honor and brutal dishonor as mathematically equal (Manapamanayos tulyas), and who maintains an identical, perfectly equal disposition toward both his dearest friends and his most lethal enemies (Tulyo mitrari-pakshayoh).
            And who has completely, entirely renounced all massive material endeavors and selfish, ego-driven new projects (Sarvarambha-parityagi)... such a phenomenal human is officially declared to have successfully transcended all the modes of material nature (Gunatitah sa uchyate).
            This verse serves as the absolute 'Grand Finale' profiling the Gunatita entity, demonstrating how he flawlessly passes the universe's absolute most difficult, brutal 'Social Stress Test'.
            In toxic society, immense prestige or public humiliation can easily shatter a normal human's psyche, but to the enlightened master, these two extremes are literally identical ('Tulya') illusions.
            Even more staggeringly, he genuinely perceives and treats his absolute most beloved best friend and his most bloodthirsty, lethal enemy with the exact same, flawless equality. He harbors zero toxic 'Bias', scientifically knowing that the exact same Supreme Lord resides deep inside the hearts of both.
            And what is his ultimate defining physical action? "Sarvarambha-parityagi"! He completely and violently ceases launching massive, stressful new 'Startups', massive corporate projects, or complicated worldly dramas purely to inflate his own bank account or fake ego.
            He strictly executes only those essential, mandatory duties assigned by God or necessary for the genuine welfare of humanity, acting completely without selfish motivation.
            When a human successfully installs and operates these unimaginable, superhuman qualities, the Supreme Lord officially and legally certifies him as 'Gunatita' (The Ultimate Liberated Master).
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            मां च योऽव्यभिचारेण भक्तियोगेन सेवते |
            स गुणान्समतीत्यैतान्ब्रह्मभूयाय कल्पते || २६ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य 'अव्यभिचारिणी भक्ति' (यानी बिना किसी मिलावट और भटकाव के 100% शुद्ध प्रेम) के द्वारा निरंतर मेरी ही सेवा और पूजा (सेवते) करता है।
            वह मेरा परम भक्त प्रकृति के इन तीनों (सत्त्व, रजस, तमस) गुणों को बहुत ही आसानी से पूरी तरह लांघ (पार कर) जाता है (समतीत्यैतान्), और वह साक्षात् 'ब्रह्म' के स्तर (ईश्वरीय अवस्था) को प्राप्त करने के योग्य (कल्पते) हो जाता है।
            यहाँ भगवान अर्जुन के तीसरे और सबसे महत्वपूर्ण सवाल का जवाब दे रहे हैं: "इन गुणों के जाल को तोड़ा 'कैसे' (कथं) जाए? वह अचूक तरीका क्या है?"
            भगवान दुनिया का सबसे आसान और सबसे ताकतवर 'मास्टर-की' (Master-key / उपाय) दे रहे हैं: "भक्तियोग" (Pure Devotion)!
            भगवान कहते हैं कि प्रकृति के ये तीन गुण (माया) इतने ताकतवर हैं कि कोई इंसान अपनी खुद की बुद्धि या तपस्या से इन्हें कभी हरा नहीं सकता।
            लेकिन अगर इंसान अपना दिमाग लगाना छोड़कर एक छोटे बच्चे की तरह 'अव्यभिचारिणी भक्ति' (यानी केवल और केवल मुझसे बिना किसी लालच के प्यार) करने लगे...
            तो मैं खुद उसे इन तीनों खतरनाक गुणों की जेल से खींचकर बाहर निकाल लेता हूँ!
            जब कोई 24 घंटे मेरी सेवा में लगा रहता है, तो प्रकृति के ये गुण उस पर अपना जादू करना बंद कर देते हैं और वो बड़ी आसानी से इन्हें पार कर ('समतीत्य') जाता है।
            और इसका सबसे बड़ा इनाम क्या है? वह इंसान जीते-जी ही 'ब्रह्मभूयाय' (ब्रह्म की अवस्था / God-like state) में पहुँच जाता है। वह भगवान के बिल्कुल बराबर के लेवल पर आकर खड़ा हो जाता है!
            भक्ति ही वह एकमात्र रॉकेट है जो इंसान को माया की ग्रेविटी (Gravity) से बाहर निकाल सकता है।
        """.trimIndent(),
        english = """
            And one who engages entirely in My pure devotional service, serving Me constantly with 100% unfailing, unadulterated, and unswerving love without any deviation (Mam cha yo 'vyabhicharena bhakti-yogena sevate).
            That pure devotee flawlessly and completely transcends all three modes of material nature with absolute ease (Sa gunan samatityaitan), and he instantly becomes fully qualified to attain the supreme spiritual platform of Brahman (Brahma-bhuyaya kalpate).
            Here, the Lord definitively answers Arjuna's third and absolute most critical question: "EXACTLY HOW ('Katham') does one successfully hack and shatter the inescapable trap of these three modes?"
            The Lord drops the universe's absolute easiest, yet most terrifyingly powerful 'Master-Key' to escape the matrix: "Bhakti Yoga" (Unconditional, Pure Devotion)!
            The Lord emphasizes that the three modes of material nature (Maya) are so overwhelmingly powerful that absolutely no human can ever defeat them using his own puny biological intelligence or brutal physical austerities.
            But if a human completely abandons his arrogant logic, surrenders like a helpless child, and relentlessly executes 'Avyabhicharini Bhakti' (100% exclusive, pure love for ME without begging for cheap material bribes)...
            I personally intervene and effortlessly yank him right out of the suffocating, three-layered prison of the material matrix!
            When a soul is engaged 24/7 exclusively in My loving service, the magnetic pull of the material modes is permanently deactivated, and he successfully bypasses them ('Samatitya') without any struggle.
            And what is the ultimate, massive cosmic reward? That human instantly attains 'Brahma-bhuyaya' (The Absolute God-like State); he is officially elevated to exist on the exact same spiritual frequency as the Supreme Lord Himself!
            Pure, unalloyed Bhakti is the absolute ONLY cosmic rocket powerful enough to successfully break free from the gravitational pull of Maya.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            ब्रह्मणो हि प्रतिष्ठाहममृतस्याव्ययस्य च |
            शाश्वतस्य च धर्मस्य सुखस्यैकान्तिकस्य च || २७ ||
        """.trimIndent(),
        hindi = """
            क्योंकि उस निराकार 'परब्रह्म' (Brahman) का, उस 'अविनाशी अमृत' (Immortality / मोक्ष) का, हमेशा रहने वाले 'शाश्वत धर्म' (Eternal Religion) का...
            और उस परम, असीम तथा 'अखंड आनंद' (Ultimate Happiness / सुखस्यैकान्तिकस्य) का एकमात्र मूल आश्रय (Foundation / आधार / प्रतिष्ठा) साक्षात् 'मैं' (श्रीकृष्ण) ही हूँ!
            यह चौदहवें अध्याय (गुणत्रय विभाग योग) का सबसे भयंकर, राजसी और 'माइक-ड्रॉप' (Mic-drop) ग्रैंड-फिनाले (Grand Finale) श्लोक है!
            पिछले श्लोक में भगवान ने कहा था कि मेरा भक्त 'ब्रह्म' (परम सत्य) को प्राप्त कर लेता है। तो लोग सोच सकते थे कि शायद 'ब्रह्म' कृष्ण से भी बड़ा है और कृष्ण केवल वहां तक पहुँचने का एक रास्ता हैं।
            भगवान श्रीकृष्ण इस घोर गलतफहमी को एक झटके में और बहुत ही एग्रेसिव (Aggressive) तरीके से हमेशा के लिए कुचल देते हैं!
            वे डंके की चोट पर ऐलान करते हैं: "ब्रह्मणो हि प्रतिष्ठाहम्" (अरे बेवकूफों! वह जो चमकता हुआ विशाल 'निराकार ब्रह्म' है, उसका 'आधार' और उसकी 'नींव' (Foundation) साक्षात् मैं ही हूँ!)। 
            जैसे सूरज की किरणें सूरज पर टिकी होती हैं, वैसे ही वह असीम ब्रह्म मेरी ही बॉडी (Body) से निकलने वाली रोशनी है। 'मैं' ब्रह्म से नहीं निकला, 'ब्रह्म' मुझसे निकला है!
            दुनिया में जो भी 'अमरता' (अमृत) है, जो भी असली 'धर्म' है, और जो वो सबसे ऊँचा 'परम आनंद' (सुख) है जिसे पाने के लिए योगी जन्मों तक तरसते हैं... उन सबकी 'फैक्ट्री' (Source) केवल और केवल 'मैं' ही हूँ।
            इसलिए जो मुझे (श्रीकृष्ण के साकार रूप को) पा लेता है, उसे ब्रह्म, मोक्ष और आनंद अपने-आप, फ्री (Free) में मिल जाते हैं। कृष्ण ही सुप्रीम गॉड (Supreme God) हैं, इसके ऊपर कोई और सत्य है ही नहीं।
        """.trimIndent(),
        english = """
            For I am the absolute, supreme resting place and the ultimate foundation of the impersonal Brahman (Brahmano hi pratishthaham), as well as the ultimate source of the immortal, imperishable, and indestructible nectar of liberation (Amritasyavyayasya cha).
            I am the sole basis of the eternal, constitutional religion (Shashvatasya cha dharmasya), and I am the ultimate foundation of the absolute, supreme, and uninterrupted ecstatic bliss (Sukhasyaikantikasya cha)!
            This is the absolute most terrifying, majestic, and aggressive 'MIC-DROP' Grand Finale verse of the Fourteenth Chapter (The Yoga of the Three Modes)!
            In the previous verse, the Lord stated that His pure devotee attains the level of 'Brahman' (The Supreme Truth). Ignorant philosophers might foolishly hallucinate that 'Brahman' is somehow superior to Krishna, and Krishna is merely a stepping stone to reach it.
            Lord Sri Krishna violently, ruthlessly, and permanently crushes this toxic misconception in one single, explosive stroke!
            He loudly and officially declares: "Brahmano hi pratishthaham" (You fools! I AM the absolute foundation, the source, and the resting place of that glowing, formless, massive 'Brahman'!). 
            Just as the blinding rays of sunshine rest entirely upon the Sun globe, the infinite, formless Brahman is merely the blinding aura radiating directly from MY personal, physical body. I do not come from Brahman; Brahman comes from ME!
            Whatever 'Immortality' (Amrita) exists, whatever the ultimate 'Eternal Dharma' is, and whatever that absolute 'Supreme Ecstatic Bliss' (Sukha) is that elite yogis starve for millions of lifetimes to achieve... I am the absolute, exclusive 'Factory' and Source of it all!
            Therefore, a human who successfully attains ME (Krishna's personal form) automatically receives Brahman, Moksha, and Infinite Bliss entirely for 'Free' as a byproduct. Krishna is the Ultimate Supreme Boss; absolutely zero truth exists above Him.
        """.trimIndent()
    )
)