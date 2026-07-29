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
data class BrahmaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

val brahmaShlokasList = listOf(
    BrahmaShloka(
        id = 1,
        sanskrit = "शौनको ह वै महाशालो भगवन्तं पिप्पलादमङ्गिरसमुपसम्पन्नः पप्रच्छ । दिव्ये ब्रह्मपुरे सम्प्रतिष्ठिता भवन्ति कथं सृज्यन्ते कस्यैष महिमा ॥ १॥",
        hindi = """
            (ब्रह्मपुर का रहस्य और शौनक का प्रलयंकारी प्रश्न): "सनातन धर्म के सबसे रहस्यमयी उपनिषदों में से एक की शुरुआत एक खौफनाक सवाल से होती है।"
            "महान गृहस्थ ऋषि शौनक ने साक्षात महर्षि पिप्पलाद के पास जाकर इंसानियत के सबसे गहरे रहस्य पर सीधा प्रहार किया।"
            "उन्होंने पूछा: 'हे भगवन्! यह भौतिक शरीर जो असल में एक दिव्य 'ब्रह्मपुर' (ईश्वर का नगर) है, इसे असल में कौन चलाता है?'"
            "'वह कौन सी अदृश्य और ब्रह्मांडीय शक्ति है जो इस हाड़-मांस के सड़े हुए पुतले में प्राण फूंकती है?'"
            "'और इस पूरे ब्रह्मांड का, तथा इस शरीर का असली रचयिता और परम मालिक (महिमा) कौन है?'"
            "यह कोई साधारण जिज्ञासा नहीं थी; यह उस परम ऊर्जा को बेनकाब करने की भयंकर प्यास थी जो मौत को भी नचाती है।"
            "इंसान अपनी पूरी ज़िंदगी इस शरीर को अपना मानता है, लेकिन उसे यह नहीं पता कि इसके भीतर कौन सा तानाशाह बैठा है।"
            "महर्षि पिप्पलाद ने मुस्कुराते हुए उस सत्य को खोलना शुरू किया जो कमज़ोर दिमागों को चकनाचूर कर देता है।"
            "उन्होंने कहा: 'वह जो तुम्हारे भीतर धड़कता है, वह कोई नश्वर जीव नहीं, साक्षात परमेश्वर है!'"
            "यहीं से बाहरी कर्मकांडों की मौत और आंतरिक आत्म-ज्ञान के सबसे बड़े विस्फोट की शुरुआत होती है।"
        """.trimIndent(),
        english = """
            (The Secret of Brahmapura and Shaunaka's Apocalyptic Question): "One of the most mysterious Upanishads of Sanatana Dharma detonates with a terrifying question."
            "The great householder sage Shaunaka directly approached Maharishi Pippalada, launching a brutal strike at humanity's deepest mystery."
            "He asked: 'O Lord! This biological physical body, which is in absolute reality a divine 'Brahmapura' (City of God), who actually operates it?'"
            "'What is that invisible, cosmic force that violently breathes life into this rotting puppet of flesh and bone?'"
            "'And who is the actual Creator and the supreme, undisputed Master (Mahima) of this entire cosmos and this body?'"
            "This was no ordinary curiosity; it was a terrifying thirst to unmask the supreme energy that makes even Death dance."
            "A human spends his entire life blindly believing he owns this body, completely ignorant of the Dictator sitting inside."
            "Maharishi Pippalada smiled and began unveiling the absolute truth that violently shatters weak human minds."
            "He declared: 'That which physically beats within your chest is absolutely no mortal creature, it is explicitly the Supreme God!'"
            "Right here begins the brutal death of external rituals and the greatest explosion of internal cosmic realization."
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 2,
        sanskrit = "प्राणो हि भगवान् स एष महिमा... स एष प्राणो ब्रह्मेति ॥ २॥",
        hindi = """
            (प्राण ही साक्षात परब्रह्म है): "महर्षि पिप्पलाद ने गर्जना करते हुए उत्तर दिया— 'यह जो साँस (प्राण) तुम्हारे भीतर चल रही है, वह केवल हवा नहीं है!'"
            "'यह प्राण ही साक्षात भगवान है! यह प्राण ही वह असीम महिमा है जो पूरे ब्रह्मांड को अपने हुक्म पर नचा रही है!'"
            "यह प्राण ही वह अदृश्य धागा है जिसने करोड़ों आकाशगंगाओं और तुम्हारे शरीर के एक-एक सेल को जकड़ कर रखा है।"
            "जब यह प्राण शरीर से बाहर निकलता है, तो दुनिया का सबसे खूबसूरत शरीर भी एक सेकंड में सड़ा हुआ 'मुर्दा' बन जाता है।"
            "यह प्राण कोई साधारण भौतिक शक्ति नहीं है, यह स्वयं 'परब्रह्म' (सर्वोच्च ईश्वर) का सबसे नग्न और साक्षात रूप है।"
            "जो मूर्ख इस प्राण को केवल ऑक्सीजन समझते हैं, वे ब्रह्मांड के सबसे बड़े अंधे हैं।"
            "तुम्हारे सीने में जो धड़क रहा है, वह तुम्हारी ज़िंदगी नहीं, वह साक्षात शिव का तांडव है जो तुम्हें ज़िंदा रखे हुए है।"
            "जिस दिन योगी इस प्राण को अपने कंट्रोल में कर लेता है, वह मौत की आँखों में आँखें डालकर उसे हरा देता है।"
            "इसलिए जान लो कि 'प्राण ही ब्रह्म है' (प्राणो ब्रह्मेति); इससे बड़ा कोई देवता नहीं और इससे बड़ी कोई शक्ति नहीं।"
            "इस एक सत्य को जान लेने पर इंसान का सारा अहंकार जलकर खाक हो जाता है।"
        """.trimIndent(),
        english = """
            (Prana is the Explicit Supreme Brahman): "Maharishi Pippalada roared his terrifying answer—'This breath (Prana) running inside you is absolutely not mere air!'"
            "'This Prana is the explicit, living God! This Prana is that infinite supremacy that makes the entire cosmos dance to its absolute command!'"
            "This Prana is the invisible cosmic chain that violently holds billions of galaxies and every single cell of your body together."
            "The microsecond this Prana exits the physical shell, the world's most beautiful body instantaneously mutates into a rotting 'Corpse'."
            "This Prana is no ordinary biological force; it is the most naked, direct, and explicit manifestation of the 'Supreme Brahman' Himself."
            "The pathetic fools who perceive this Prana merely as biological oxygen are the greatest blind men in the cosmos."
            "What beats violently within your chest is not your pathetic life; it is the literal cosmic dance of Shiva keeping you alive."
            "The day a Yogi asserts tyrannical control over this Prana, he stares directly into the eyes of Death and violently defeats it."
            "Therefore, know with lethal certainty that 'Prana is Brahman' (Prano Brahmeti); there is no greater deity and no greater power."
            "Upon experiencing this single atomic truth, the entirety of human ego is brutally burnt to absolute ashes."
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 3,
        sanskrit = "लूता तन्तुं सृजते सहरते च । तद्वत् प्राणः सृजते सहरते च ॥ ३॥",
        hindi = """
            (मकड़ी और जाले का प्रलयंकारी उदाहरण): "उपनिषद ब्रह्मांड की रचना का सबसे खौफनाक और सटीक उदाहरण देता है।"
            "'जैसे एक मकड़ी (लूता) अपने ही शरीर के भीतर से जाला (तन्तुं) पैदा करती है, उसमें खेलती है, और फिर उसे वापस अपने भीतर खींच (निगल) लेती है...'"
            "'ठीक उसी तरह, यह साक्षात 'प्राण' (परब्रह्म) इस पूरे असीम ब्रह्मांड को अपने ही भीतर से पैदा करता है!'"
            "ईश्वर ने दुनिया को बनाने के लिए बाहर से कोई मिट्टी या ईंट नहीं ली; उसने खुद को ही चीरकर यह ब्रह्मांड बनाया है!"
            "हम सब उस विशाल मकड़ी के जाले में फँसे हुए छोटे-छोटे कीड़े हैं, जो इसे सच मान बैठे हैं।"
            "और जब महा-प्रलय (Doomsday) का समय आता है, तो वह परमेश्वर इस पूरे ब्रह्मांड को वापस अपने भीतर निगल लेता है (सहरते च)।"
            "सितारे, ग्रह, इंसान और देवता—सब कुछ उसी एक ऊर्जा में वापस भस्म होकर शून्य हो जाते हैं।"
            "यह सत्य इंसान के इस घमंड को कुचल देता है कि इस दुनिया का कोई स्थायी वजूद है।"
            "जो पैदा हुआ है, वह वापस उसी प्राण के खौफनाक मुँह में खींचा जाएगा; बचने का कोई रास्ता नहीं है।"
            "केवल वह योगी बचता है जो जाले से मोह छोड़कर सीधे उस मकड़ी (ईश्वर) से एक हो जाता है!"
        """.trimIndent(),
        english = """
            (The Apocalyptic Metaphor of the Spider and the Web): "The Upanishad delivers the most terrifying and flawless metaphor for cosmic creation."
            "'Just as a literal spider (Luta) generates a web (Tantu) directly from within its own body, plays in it, and then violently sucks it back into itself...'"
            "'In the exact same brutal manner, this absolute 'Prana' (Supreme God) spawns this entire infinite universe directly from within His own core!'"
            "God absolutely did not use external dirt or bricks to build this world; He literally tore Himself open to manifest this cosmos!"
            "We mortals are merely pathetic, microscopic insects trapped in that colossal spider web, blindly hallucinating it to be permanent reality."
            "And when the exact microsecond of the Great Annihilation (Doomsday) strikes, that Supreme God violently swallows the entire cosmos back into Himself (Saharate cha)."
            "Stars, planets, humans, and gods—absolutely everything burns back into that single primordial energy, returning to absolute zero."
            "This lethal truth permanently crushes the human arrogance that this physical world possesses any permanent, solid existence."
            "Whatever has manifested will be violently dragged back into the terrifying mouth of that Prana; there is absolutely zero escape."
            "Only that supreme Yogi survives who brutally severs his attachment to the web and fuses directly with the Spider (God)!"
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 4,
        sanskrit = "नेत्रे जाग्रति वै प्राणः कण्ठे स्वप्नं समाविशेत् । सुप्तं तालुनि विद्यात्तु तुरीयं मूर्ध्नि संस्थितम् ॥ ४॥",
        hindi = """
            (चेतना के चार खौफनाक ठिकाने): "यह श्लोक इंसान की चेतना (Consciousness) के कंट्रोल रूम का रहस्य खोलता है।"
            "जब तुम 'जागते' (जाग्रत) हो, तो तुम्हारी आत्मा की ऊर्जा तुम्हारी 'आँखों' (नेत्रे) में आकर बैठ जाती है, और तुम दुनिया के भ्रम को सच मानते हो।"
            "जब तुम 'सपने' (स्वप्न) देखते हो, तो वह ऊर्जा खिसक कर तुम्हारे 'गले' (कण्ठे) में आ जाती है, और तुम्हारा दिमाग झूठी दुनिया बनाता है।"
            "जब तुम 'गहरी नींद' (सुषुप्ति) में होते हो जहाँ कोई सपना नहीं होता, तब वह ऊर्जा 'तालु' (Talate) में छिप जाती है।"
            "लेकिन... इन तीनों से परे एक चौथी अवस्था है जिसे 'तुरीय' (Turiya) कहते हैं, जो साक्षात 'भगवान की अवस्था' है!"
            "यह तुरीय अवस्था तुम्हारे 'मूर्धा' (सिर के सबसे ऊपरी हिस्से / Crown Chakra) में विस्फोट के इंतज़ार में सो रही है।"
            "जागना, सपना देखना और गहरी नींद—ये तीनों इंसानियत की बीमारियां हैं, जिनमें आत्मा भटकी हुई है।"
            "जो योगी अपनी चेतना को आँखों, गले और तालु से खींचकर सीधे 'सिर की चोटी' (मूर्धा) में ठोक देता है..."
            "उसी सेकंड उसका इंसानी दिमाग फट जाता है, और वह साक्षात ब्रह्मांड का मालिक बन जाता है!"
            "तुरीय में प्रवेश करने का मतलब है मौत को मार डालना और 100% परमेश्वर बन जाना।"
        """.trimIndent(),
        english = """
            (The Four Terrifying Headquarters of Consciousness): "This Shloka violently rips open the absolute control room of human Consciousness."
            "When you are 'Awake' (Jagrata), your soul's raw energy anchors exclusively in your 'Eyes' (Netre), forcing you to hallucinate this fake world as reality."
            "When you 'Dream' (Svapna), that energy slides brutally into your 'Throat' (Kanthe), and your brain begins fabricating terrifying fake universes."
            "When you are in 'Deep Dreamless Sleep' (Sushupti), that primordial energy hides deep within your 'Palate' (Talu)."
            "But... entirely beyond these three pathetic biological states lies a fourth dimension called 'Turiya', which is the literal 'State of God'!"
            "This apocalyptic Turiya state is lying dormant, waiting to detonate at the exact 'Crown of your Head' (Murdhna/Crown Chakra)."
            "Waking, dreaming, and deep sleep—these three are merely biological diseases of humanity in which the soul wanders completely lost."
            "The Yogi who violently drags his consciousness out of the eyes, throat, and palate, and hammers it directly into the 'Crown of his Skull'..."
            "In that exact microsecond, his human brain detonates into a cosmic explosion, and he becomes the literal Master of the universe!"
            "Penetrating Turiya explicitly means assassinating Death itself and mutating 100% into the Supreme God."
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 5,
        sanskrit = "हंसः प्राणो मयि प्राणे... सर्वे प्राणा मयि स्थिताः ॥ ५॥",
        hindi = """
            ('हंस' और ब्रह्मांडीय एकाकार): "उपनिषद कहता है कि हर इंसान के भीतर जो साँस (सो-हम्) चल रही है, वही साक्षात 'हंस' (आत्मा) है।"
            "वह योगी दहाड़ते हुए घोषणा करता है: 'मैं कोई शरीर नहीं हूँ, मैं ही वह हंस हूँ! मैं ही वह असीम प्राण हूँ!'"
            "जब यह अज्ञान जलकर राख हो जाता है कि मैं एक कमज़ोर इंसान हूँ, तब वह आत्मा अपने असली 'परमेश्वर स्वरूप' में जाग उठती है।"
            "वह कहता है: 'यह पूरा ब्रह्मांड मेरे भीतर नहीं है, बल्कि ब्रह्मांड के सारे प्राण, सारे जीव मुझमें ही स्थित हैं! (सर्वे प्राणा मयि स्थिताः)'।"
            "सूरज की गर्मी, हवा की रफ़्तार, और मौत की ताक़त—यह सब मेरी ही ऊर्जा के छोटे-छोटे हिस्से हैं।"
            "यह कोई अहंकार नहीं है, यह उस परम स्थिति का खौफनाक सच है जहाँ जीव और परमेश्वर की बाउंड्री टूट चुकी है।"
            "जो खुद को शरीर मानता है, वह कीड़ों की तरह पैदा होता है और कीड़ों की तरह मर जाता है।"
            "लेकिन जिसने खुद को यह 'हंस' (Supreme Swan) जान लिया, वह समय और अंतरिक्ष के सीने पर पैर रखकर खड़ा हो जाता है।"
            "उसके लिए कोई डर, कोई बीमारी, कोई दुख और कोई मौत नहीं बची।"
            "वह एक इंसान की लाश पर खड़ा होकर साक्षात ब्रह्मांड का भगवान बन चुका है!"
        """.trimIndent(),
        english = """
            (The 'Hamsa' and Cosmic Fusion): "The Upanishad dictates that the physical breath (So-Ham) violently operating inside every human is literally the 'Hamsa' (The Supreme Soul)."
            "That Yogi roars with apocalyptic authority: 'I am absolutely not a biological body, I am that precise Hamsa! I am that infinite Prana!'"
            "When the pathetic ignorance of being a weak human is burnt to literal ashes, the Soul violently awakens to its true 'Form of God'."
            "He declares: 'The universe is not outside me; absolutely all life forces and every soul in the cosmos are physically stationed inside ME! (Sarve prana mayi sthitah)'."
            "The scorching heat of the sun, the velocity of the wind, and the lethality of Death—these are strictly micro-fractions of my own personal energy."
            "This is absolutely not human ego; it is the terrifying, absolute truth of the dimension where the boundary between mortal and God is permanently annihilated."
            "He who hallucinates himself as a body breeds like a pathetic insect and dies exactly like an insect."
            "But he who has flawlessly realized himself as this 'Hamsa' (Supreme Swan) plants his boot directly on the chest of Space and Time."
            "For him, absolutely zero fear, zero disease, zero sorrow, and zero death remain."
            "Standing on the rotting corpse of his human identity, he has literally mutated into the God of the cosmos!"
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 6,
        sanskrit = "ज्ञानशिखी ज्ञाननिष्ठो ज्ञानयज्ञोपवीतवान् । शिखा ज्ञानमयी यस्य उपवीतं च तन्मयम् ॥ ६॥",
        hindi = """
            (सच्ची शिखा और सच्चे जनेऊ का प्रलयंकारी रहस्य): "यहाँ उपनिषद धर्म के ठेकेदारों और कर्मकांडियों के गाल पर सबसे ज़ोरदार तमाचा मारता है।"
            "असली ब्राह्मण वह नहीं है जो सिर पर बालों की चोटी (शिखा) रखता है और शरीर पर सूत का धागा (जनेऊ) पहनता है!"
            "सच्चा योगी वह है जिसकी शिखा 'ज्ञान' (Supreme Cosmic Knowledge) की बनी है! (ज्ञानशिखी)।"
            "वह हमेशा केवल और केवल उस परम सत्य के 'ज्ञान में ही निष्ठा' (ज्ञाननिष्ठो) रखता है; बाहरी दिखावों में नहीं।"
            "उसका यज्ञोपवीत (जनेऊ) किसी दर्ज़ी ने नहीं बनाया, बल्कि वह साक्षात 'ज्ञान का ही यज्ञोपवीत' पहनता है!"
            "जिस इंसान की चोटी ज्ञान की है और जिसका धागा भी उस परमेश्वर (तन्मयम्) का बना हुआ है..."
            "केवल और केवल वही इंसान पूरे ब्रह्मांड में सच्चा संन्यासी और सच्चा ज्ञानी कहलाने की औकात रखता है।"
            "बाकी जो लोग केवल शरीर पर धागे लटकाकर खुद को पवित्र समझते हैं, वे अज्ञान के भयानक अंधेरे में सड़ रहे हैं।"
            "जब आत्मा साक्षात भगवान बन गई, तो इस हाड़-मांस के पुतले पर धागे बाँधने का क्या मतलब?"
            "उपनिषद भौतिक प्रतीकों को बेरहमी से जलाकर आत्मा के नंगे और खौफनाक सत्य को सामने रख देता है।"
        """.trimIndent(),
        english = """
            (The Apocalyptic Secret of the True Tuft and Sacred Thread): "Here, the Upanishad delivers the most violent, resounding slap to religious contractors and ritualists."
            "An authentic Brahmin is absolutely not the pathetic fool who grows a physical tuft of hair (Shikha) and wears a cotton thread (Janeu) on his biological flesh!"
            "The genuine Yogi is the Titan whose tuft is explicitly constructed of 'Supreme Cosmic Knowledge' (Jnana-shikhi)!"
            "He maintains his absolute, terrifying loyalty strictly to that supreme absolute truth (Jnana-nishtho); absolutely never to external theatrical displays."
            "His sacred thread was not stitched by a mortal tailor; he literally wears the 'Yajnopavita of Absolute Cosmic Wisdom'!"
            "The specific human whose tuft is made of sheer knowledge and whose thread is constructed entirely of God Himself (Tanmayam)..."
            "Strictly and exclusively only that human possesses the terrifying caliber to be called a true Sannyasin and a supreme master in the entire cosmos."
            "The rest of the pathetic fools who merely hang cotton strings on their bodies and hallucinate purity are rotting in the horrific darkness of absolute ignorance."
            "When the Soul has physically mutated into God, what is the pathetic logic of tying cotton threads on a biological puppet of flesh?"
            "The Upanishad ruthlessly incinerates all physical symbols, exposing the completely naked, terrifying, and absolute truth of the Soul."
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 7,
        sanskrit = "स ब्राह्मणो वै स संन्यासी स एव तत्त्वमुच्यते । स एवाचार्यो वेदानां स एव परिकीर्तितः ॥ ७॥",
        hindi = """
            (सच्चे ज्ञानी का परम रुतबा): "यह श्लोक उस महायोगी की असीम ताक़त और औकात का ऐलान करता है जिसने बाहरी धागों को फेंक दिया है।"
            "जिसने 'ज्ञान' को ही अपना जनेऊ और शिखा बना लिया है, पूरे ब्रह्मांड में केवल 'वही असली ब्राह्मण' है!"
            "केवल वही इस धरती पर 'असली संन्यासी' कहलाने का हक़दार है, बाकी सब केवल पाखंड का नाटक कर रहे हैं।"
            "वह योगी अब कोई इंसान नहीं रहा, वह साक्षात 'परम तत्त्व' (The Ultimate Reality) में बदल चुका है (स एव तत्त्वमुच्यते)।"
            "उसे किसी किताब या वेद को पढ़ने की ज़रूरत नहीं है; वह खुद ही वेदों का साक्षात 'आचार्य' (मालिक) बन चुका है!"
            "पूरी सृष्टि में केवल उसी महापुरुष की कीर्ति (परिकीर्तितः) देवताओं द्वारा गाई जाती है।"
            "चाहे वह सड़क पर नंगा घूमे या महलों में रहे, उसकी आंतरिक स्थिति को दुनिया का कोई नियम नहीं बाँध सकता।"
            "वह धर्म के बनाए गए सभी पिंजरों को तोड़कर एक अजेय शेर की तरह बाहर आ चुका है।"
            "उसके मुँह से निकला हुआ एक-एक शब्द ही साक्षात वेद का मंत्र बन जाता है।"
            "यही सनातन धर्म की वह खौफनाक चोटी है जहाँ एक इंसान साक्षात 'सत्य' (Truth) का भौतिक रूप बन जाता है।"
        """.trimIndent(),
        english = """
            (The Absolute Supremacy of the True Knower): "This Shloka roars the boundless, terrifying power and authority of that colossal Yogi who has violently discarded external threads."
            "He who has weaponized 'Absolute Knowledge' as his literal thread and tuft—in the entire infinite cosmos, strictly 'He alone is the Authentic Brahmin'!"
            "He alone possesses the ironclad, undeniable right to be called a 'Genuine Sannyasin' on Earth; the rest are merely executing a pathetic hypocritical drama."
            "That Yogi is no longer a biological human; he has literally, physically mutated into the 'Ultimate Reality' itself (Sa eva tattvamuchyate)."
            "He has absolutely zero need to read any pathetic book or Veda; he himself has become the explicit 'Master and Origin' (Acharya) of the Vedas!"
            "In the entire creation, only the glory of that supreme Titan is sung by the gods themselves (Parikirtitah)."
            "Whether he roams completely naked on the streets or sits in palaces, absolutely no worldly law can bind his terrifying internal state."
            "He has violently shattered every single cage manufactured by religion and emerged as an invincible, immortal cosmic lion."
            "Every single word that physically escapes his mouth instantaneously becomes an absolute Vedic mantra."
            "This is the terrifying absolute zenith of Sanatana Dharma, where a mortal human becomes the literal, physical embodiment of 'The Absolute Truth'."
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 8,
        sanskrit = "शिखा ज्ञानमयी यस्य उपवीतं च तन्मयम् । ब्राह्मण्यं सकलं तस्य इति ब्रह्मविदो विदुः ॥ ८॥",
        hindi = """
            (असली ब्राह्मणत्व की प्रलयंकारी परिभाषा): "उपनिषद जातिवाद और बाहरी जन्म के ढोंग का सबसे क्रूरता से कत्ल करता है।"
            "ब्राह्मण वह नहीं है जो किसी विशेष जाति या घर में पैदा हुआ है; जन्म से कोई महान नहीं होता।"
            "महानता की केवल एक ही खौफनाक और अटल शर्त है— 'जिसकी शिखा (चोटी) केवल और केवल सर्वोच्च ज्ञान से बनी हो!'"
            "'और जिसका यज्ञोपवीत (जनेऊ) साक्षात उस परब्रह्म के असीम ज्ञान (तन्मयम्) से बुना गया हो!'"
            "केवल और केवल उसी इंसान के पास 'संपूर्ण ब्राह्मणत्व' (ब्राह्मण्यं सकलं) है!"
            "यही बात वे महापुरुष कहते हैं जिन्होंने साक्षात ईश्वर को अपनी आँखों से देखा है (ब्रह्मविदो विदुः)।"
            "यदि तुम्हारे भीतर सत्य का विस्फोट नहीं हुआ है, तो शरीर पर पहने गए सूत के धागे तुम्हें केवल एक पाखंडी बनाते हैं।"
            "ज्ञान के बिना किया गया हर कर्मकांड, हर पूजा और हर यज्ञ पूरी तरह से राख और कचरे के समान है।"
            "सनातन धर्म खून या जाति को नहीं, बल्कि चेतना (Consciousness) के उस परम धमाके को पूजता है जो इंसान को भगवान बनाता है।"
            "जो इस ज्ञान-रूपी जनेऊ को पहन लेता है, वह मौत के गाल पर तमाचा मार कर अमर हो जाता है।"
        """.trimIndent(),
        english = """
            (The Apocalyptic Definition of True Brahminhood): "The Upanishad executes the most brutal, cold-blooded slaughter of casteism and the hypocrisy of physical birth."
            "A Brahmin is absolutely not someone born into a specific family or caste; absolutely no one is born great from a biological womb."
            "There is strictly only one terrifying, ironclad condition for greatness—'He whose tuft is forged exclusively from Supreme Cosmic Knowledge!'"
            "'And he whose sacred thread is woven explicitly from the infinite realization of that Supreme God (Tanmayam)!'"
            "Strictly and exclusively only that specific human possesses 'Total, Absolute Brahminhood' (Brahmanyam Sakalam)!"
            "This is the absolute cosmic verdict declared by those colossal Titans who have seen God face-to-face (Brahmavido Viduh)."
            "If the atomic explosion of Truth has not detonated inside you, the physical cotton threads on your flesh merely make you a pathetic hypocrite."
            "Every ritual, every worship, and every fire-sacrifice performed without absolute cosmic knowledge is literally equal to rotting garbage and ashes."
            "Sanatana Dharma absolutely does not worship bloodlines or genetics; it worships that apocalyptic detonation of Consciousness that mutates a human into God."
            "He who wears this invisible thread of supreme knowledge slaps Death across the face and achieves literal immortality."
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 9,
        sanskrit = "इदं यज्ञोपवीतं तु परमं यत्परायणम् । स विद्वान् यज्ञोपवीती स्यात् स यज्ञः स च याज्ञिकः ॥ ९॥",
        hindi = """
            (असली यज्ञ और यज्ञकर्ता की पहचान): "यह जो 'आंतरिक ज्ञान का यज्ञोपवीत' है, यही पूरे ब्रह्मांड का सबसे 'परम' (Supreme) और अंतिम लक्ष्य है!"
            "यह धागा कपास से नहीं, बल्कि आत्मा की असीम शुद्धता से बनता है।"
            "जो महान विद्वान (ज्ञानी) इस ज्ञान-रूपी अदृश्य जनेऊ को अपनी आत्मा पर धारण करता है, वही दुनिया का सच्चा 'यज्ञोपवीती' है।"
            "सबसे खौफनाक और प्रलयंकारी सत्य यह है कि जब वह इस परम ज्ञान को पहन लेता है..."
            "तो उसे बाहर आग जलाकर कोई यज्ञ करने की ज़रूरत नहीं बचती, क्योंकि 'वह स्वयं ही साक्षात यज्ञ बन जाता है!' (स यज्ञः)।"
            "और केवल वही नहीं, वह खुद ही उस यज्ञ को करने वाला 'याज्ञिक' (पुरोहित) भी बन जाता है।"
            "हवन कुंड भी वह खुद है, जलाई जाने वाली आग भी वह खुद है, और आहुति भी वह खुद ही है!"
            "उसने द्वैत (Duality) के हर भ्रम को इतनी बेरहमी से मार डाला है कि अब सब कुछ केवल और केवल उसी का विस्तार है।"
            "जब इंसान की चेतना इस ब्रह्मांडीय स्तर तक फट कर फैल जाती है, तो सारे बाहरी कर्मकांड मिट्टी में मिल जाते हैं।"
            "यही उस अजेय संन्यासी का वह परम आध्यात्मिक रूप है जिसे कोई आग जला नहीं सकती और कोई पानी बुझा नहीं सकता।"
        """.trimIndent(),
        english = """
            (The Identity of the True Sacrifice and the Sacrificer): "This specific 'Sacred Thread of Internal Absolute Knowledge' is the absolute 'Supreme' (Paramam) and final destination of the entire cosmos!"
            "This thread is absolutely not manufactured from pathetic cotton, but is violently forged from the infinite purity of the Soul."
            "The colossal scholar (Vidwan) who wears this invisible, atomic thread of cosmic wisdom on his soul is the only true 'Yajnopaviti' in existence."
            "The most terrifying and apocalyptic truth is that the microsecond he adorns this supreme knowledge..."
            "He no longer needs to light any physical fire to perform a sacrifice, because 'He himself physically mutates into the literal Sacrifice!' (Sa Yajnah)."
            "And not just that, he himself simultaneously becomes the 'Yajnika' (The Supreme Priest) executing that exact sacrifice."
            "He himself is the fire pit, he himself is the raging cosmic fire, and he himself is the absolute oblation being offered!"
            "He has so ruthlessly assassinated every illusion of Duality that now, absolutely everything is merely a physical extension of Himself."
            "When human consciousness detonates and expands to this terrifying cosmic magnitude, all external rituals are violently reduced to dirt."
            "This is the supreme, invincible spiritual form of that monk which no fire can ever burn and no water can ever extinguish."
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 10,
        sanskrit = "बहिःसूत्रं त्यजेद्विप्रो योगमुत्तममास्थितः । ब्रह्मभावमिदं सूत्रं धारयेद्यः स चेतनः ॥ १०॥",
        hindi = """
            (सूत के धागे का विनाश और ब्रह्मभाव का धागा): "उपनिषद सबसे कठोर और क्रूर आदेश देता है: 'बहिःसूत्रं त्यजेत्'— शरीर पर लिपटे हुए इस बाहरी सूत के धागे को उखाड़ कर फेंक दो!"
            "जो श्रेष्ठ विप्र (ज्ञानी) योग की उस सर्वोच्च और सबसे भयंकर अवस्था (उत्तममास्थितः) पर पहुँच चुका है, उसे बाहरी धागों का कोई मोह नहीं होना चाहिए।"
            "यह धागा केवल उन अज्ञानियों के लिए है जो अभी भी धर्म की एबीसीडी (ABCD) सीख रहे हैं।"
            "लेकिन जिसने साक्षात भगवान को देख लिया हो, उसके लिए यह धागा एक झूठी बेड़ी से ज़्यादा कुछ नहीं है।"
            "तो फिर उसे क्या पहनना चाहिए? उसे 'ब्रह्मभाव' (मैं ही ईश्वर हूँ, इस परम अहसास) का धागा पहनना चाहिए!"
            "जो योगी इस प्रलयंकारी 'ब्रह्मभाव' को अपनी रगों में उतार लेता है, केवल और केवल वही इस दुनिया में असली 'चेतन' (Awakened/ज़िंदा) इंसान है!"
            "बाकी पूरी दुनिया जो केवल शरीर और कपड़ों में उलझी हुई है, वे सब के सब चलते-फिरते ज़िंदा लाशें हैं।"
            "यह 'अहं ब्रह्मास्मि' का धागा कोई बाज़ार में नहीं मिलता; इसे अहंकार की सबसे क्रूर मौत के बाद अपनी आत्मा से खींचा जाता है।"
            "जिसने यह आंतरिक धागा पहन लिया, वह समाज की नज़रों में गिरकर भी ब्रह्मांड के सबसे ऊँचे तख़्त पर बैठ जाता है।"
            "यह सनातन धर्म की वह खौफनाक बगावत है जो इंसान को सीधा ईश्वर बना देती है।"
        """.trimIndent(),
        english = """
            (The Annihilation of the Cotton Thread and the Thread of God-Consciousness): "The Upanishad issues the most brutal, merciless command: 'Bahih-sutram tyajet'—Violently rip off and discard this external cotton thread wrapped around your flesh!"
            "The supreme knower (Vipra) who has successfully ascended to the most terrifying, ultimate zenith of Yoga (Uttamam-asthitah) must possess zero attachment to physical strings."
            "This physical thread is strictly for pathetic ignoramuses who are still learning the basic ABCs of religion."
            "But for the Titan who has looked God directly in the eyes, this thread is absolutely nothing more than a fake, restrictive biological chain."
            "What then must he wear? He must wear the invisible, atomic thread of 'Brahmabhava' (The apocalyptic realization: 'I am God Himself')!"
            "The Yogi who violently injects this earth-shattering 'Brahmabhava' directly into his veins is the ONLY true 'Chetana' (Fully Awakened/Alive) being in this universe!"
            "The rest of the entire planet, hopelessly entangled in biological flesh and clothes, are strictly walking, rotting, living corpses."
            "This thread of 'Aham Brahmasmi' is not sold in any pathetic market; it is extracted strictly from your own soul only after the most brutal slaughter of your ego."
            "He who wears this internal thread, even if he plummets in the eyes of society, sits permanently on the highest, undisputed throne of the cosmos."
            "This is the terrifying, absolute rebellion of Sanatana Dharma that violently mutates a mortal directly into God."
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 11,
        sanskrit = "धारणात्तस्य सूत्रस्य नोच्छिष्टो नाशुचिर्भवेत् । सूत्रमन्तर्गतं येषां ज्ञानयज्ञोपवीतिनाम् ॥ ११॥",
        hindi = """
            (परम पवित्रता जहाँ कोई अशुद्धि नहीं): "जब वह महायोगी इस असीम 'ब्रह्मज्ञान' रूपी धागे को अपनी आत्मा पर धारण कर लेता है..."
            "तब उसके लिए इस दुनिया का कोई भी नियम लागू नहीं होता! वह कभी भी 'उच्छिष्ट' (जूठा या अपवित्र) नहीं हो सकता (नोच्छिष्टो)।"
            "चाहे वह श्मशान में सोए, चाहे वह किसी चांडाल का खाना खा ले, या चाहे वह कीचड़ में सना हो—वह कभी भी 'अशुचि' (अपवित्र) नहीं हो सकता!"
            "क्योंकि जो साक्षात परमेश्वर बन चुका है, उसे दुनिया की कौन सी धूल मैला कर सकती है?"
            "जिनके भीतर (अन्तर्गतं) यह ज्ञान रूपी प्रलयंकारी यज्ञोपवीत धड़क रहा है, वे ब्रह्मांड की हर भौतिक अशुद्धि से हमेशा के लिए मुक्त हो जाते हैं।"
            "पवित्रता और अपवित्रता केवल इस हाड़-मांस के शरीर के लिए है; आत्मा कभी गंदी नहीं होती।"
            "और जिसने अपना शरीर ही त्याग दिया और केवल आत्मा बनकर जी रहा है, उसके लिए नहाना या न नहाना सब बकवास है।"
            "वह समाज की झूठी 'पवित्रता' की धज्जियां उड़ा देता है; उसकी अपनी मौजूदगी ही सबसे बड़ा तीर्थ बन जाती है।"
            "वह उस खौफनाक और अजेय चोटी पर खड़ा है जहाँ से दुनिया के सारे नियम और कर्मकांड चींटियों की तरह छोटे और बेमानी लगते हैं।"
            "ज्ञान की आग ने उसकी हर अशुद्धि को जलाकर राख कर दिया है; वह अब केवल शुद्ध, धधकता हुआ प्रकाश है!"
        """.trimIndent(),
        english = """
            (Absolute Purity Where No Defilement Exists): "When that colossal Yogi successfully adorns this infinite, atomic thread of 'Brahma-Jnana' directly on his Soul..."
            "Absolutely zero rules of this pathetic world apply to him anymore! He can absolutely never become 'Uchchishta' (Defiled or Impure) (Nocchishto)."
            "Whether he sleeps on the burning ashes of a graveyard, eats the food of the lowest outcaste, or is covered in filthy mud—he can absolutely never become 'Ashuchi' (Polluted)!"
            "Because when a being has physically mutated into the Supreme God, what pathetic earthly dirt possesses the capability to stain him?"
            "Those inside whom (Antargatam) this apocalyptic thread of cosmic knowledge violently pulsates are permanently liberated from every single physical impurity in the cosmos."
            "Purity and pollution are strictly biological concepts for this puppet of flesh; the absolute Soul is never contaminated."
            "And for the Titan who has psychologically abandoned his body and lives purely as the Cosmic Soul, bathing or not bathing is absolute biological nonsense."
            "He violently shreds society's fake, hypocritical 'Purity' to dust; his mere physical presence mutates into the greatest pilgrimage site in existence."
            "He stands on that terrifying, invincible peak from where all worldly laws and rituals look as pathetic and meaningless as microscopic ants."
            "The catastrophic fire of Knowledge has burnt every ounce of his impurity to absolute ashes; he is now strictly pure, blazing, radioactive Light!"
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 12,
        sanskrit = "ते वै सूत्रविदो लोके ते च यज्ञोपवीतिनः । ज्ञानशिखिनो ज्ञाननिष्ठा ज्ञानमेव परं पदम् ॥ १२॥",
        hindi = """
            (सच्चे ज्ञानी ही ब्रह्मांड के असली मालिक हैं): "इस ब्रह्मांड में केवल और केवल वही लोग असली 'सूत्रवित्' (धागे के असली रहस्य को जानने वाले) हैं!"
            "केवल वे ही इस पूरी पृथ्वी पर सच्चे 'यज्ञोपवीती' (जनेऊ धारी) कहलाने के लायक हैं, जिन्होंने अपने अंदर ज्ञान का विस्फोट किया है।"
            "उनकी शिखा (चोटी) बालों की नहीं, बल्कि 'ज्ञान' की धधकती हुई आग से बनी है (ज्ञानशिखिनो)।"
            "उनकी निष्ठा किसी मूर्ति या मंदिर में नहीं, बल्कि केवल और केवल उस असीम परम सत्य (ज्ञाननिष्ठा) में फौलाद की तरह गड़ी हुई है।"
            "उपनिषद चीख कर ब्रह्मांड का सबसे अंतिम सत्य बताता है: 'ज्ञानमेव परं पदम्'— केवल 'ज्ञान' ही वह सबसे ऊँचा, सबसे खौफनाक और सबसे आखिरी मुकाम है!"
            "ज्ञान के अलावा इस दुनिया में कोई स्वर्ग नहीं, कोई मोक्ष नहीं और कोई भगवान नहीं।"
            "जो इस ज्ञान तक नहीं पहुँचा, वह कीड़ों की तरह अरबों बार पैदा होगा और अरबों बार मरेगा।"
            "लेकिन जिसने इस ज्ञान रूपी तलवार से अपने अहंकार की गर्दन काट दी, वह समय और मौत की पहुँच से हमेशा के लिए बाहर हो गया।"
            "वह इंसानियत की सीमा को पार करके साक्षात उस परम ऊर्जा का स्रोत बन चुका है जो दुनिया को चलाती है।"
            "वह अब खोज नहीं रहा है; वह स्वयं ही वह 'परम पद' (Ultimate Destination) बन चुका है!"
        """.trimIndent(),
        english = """
            (The True Knowers are the Absolute Masters of the Cosmos): "In this entire infinite universe, strictly and exclusively they alone are the genuine 'Sutravit' (The True Knowers of the Cosmic Thread)!"
            "Only those Titans who have detonated the atomic explosion of cosmic knowledge within themselves deserve to be called the authentic 'Yajnopaviti' on this Earth."
            "Their tuft (Shikha) is absolutely not made of biological hair, but is forged from the blazing, catastrophic fire of 'Absolute Knowledge' (Jnana-shikhino)."
            "Their loyalty is not tethered to pathetic physical idols or temples, but is anchored like indestructible steel strictly in that infinite Supreme Truth (Jnana-nishtha)."
            "The Upanishad screams the final, apocalyptic truth of the cosmos: 'Jnanameva Param Padam'—Only 'Absolute Knowledge' is the highest, most terrifying, and ultimate destination!"
            "Beyond this devastating Cosmic Knowledge, there is zero heaven, zero liberation, and zero God."
            "He who fails to reach this knowledge will breed like a pathetic insect and die billions of times in the mud of existence."
            "But the Titan who has brutally decapitated his own ego with this sword of Knowledge has permanently rocketed beyond the jurisdiction of Time and Death."
            "Violently breaching the boundaries of humanity, he has mutated into the literal, explicit source of the primordial energy that powers the universe."
            "He is no longer searching; he himself has violently mutated into that exact 'Param Padam' (The Ultimate Absolute Destination)!"
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 13,
        sanskrit = "एको देवः सर्वभूतेषु गूढः सर्वव्यापी सर्वभूतान्तरात्मा । कर्माध्यक्षः सर्वभूताधिवासः साक्षी चेता केवलो निर्गुणश्च ॥ १३॥",
        hindi = """
            (एकमात्र परमेश्वर की प्रलयंकारी घोषणा): "यह मंत्र उपनिषदों का सबसे शक्तिशाली और दिमाग को सुन्न कर देने वाला सत्य है।"
            "पूरे ब्रह्मांड में 'केवल एक ही भगवान' (एको देवः) है! कोई दूसरा नहीं है, कोई द्वैत नहीं है!"
            "और वह भगवान आसमान में नहीं बैठा, वह ब्रह्मांड के हर एक जीव (सर्वभूतेषु) के भीतर खौफनाक रूप से 'छिपा हुआ' (गूढः) है!"
            "वह हर जगह, हर कण में, हर परमाणु में एक साथ मौजूद है (सर्वव्यापी), और वही हर जीव की असली 'आत्मा' (सर्वभूतान्तरात्मा) है।"
            "तुम जो भी कर्म करते हो, वह तुम्हारे भीतर बैठकर सब कुछ देख रहा है और तुम्हारे हर कर्म का असली 'मालिक' (कर्माध्यक्षः) वही है।"
            "वही सभी जीवों का असली घर (अधिवासः) है। वह केवल एक 'साक्षी' (गवाह) की तरह तुम्हारे जीवन का नाटक देख रहा है।"
            "वह परम चेतना (चेता), पूरी तरह से 'अकेला' (केवलो) और हर भौतिक गुण या रूप से पूरी तरह आज़ाद (निर्गुणश्च) है।"
            "जब वह योगी खुद के भीतर छिपे इस 'एक देव' को बेनकाब कर लेता है, तो दुनिया का हर धर्म और हर मंदिर उसके लिए मिट्टी बन जाता है।"
            "वह जान जाता है कि जिसे वह बाहर खोज रहा था, वह तानाशाह तो उसी के अपने सीने में बैठा था।"
            "यह अहसास होते ही इंसान का 'मैं' एक भयानक धमाके के साथ फट जाता है और केवल 'वह एक ईश्वर' ही शेष रह जाता है!"
        """.trimIndent(),
        english = """
            (The Apocalyptic Declaration of the One Supreme God): "This mantra is the most violently powerful, mind-numbing absolute truth of the Upanishads."
            "In the entire infinite cosmos, there is strictly 'Only One Single God' (Eko Devah)! There is absolutely zero second, zero duality!"
            "And that God does not sit in some pathetic sky; He is terrifyingly 'Hidden' (Gudhah) deep inside the biological core of every single creature (Sarva-bhuteshu)!"
            "He is simultaneously present in every micro-particle, every atom everywhere (Sarvavyapi), and He is the exact literal 'Soul' of every entity (Sarva-bhutantaratma)."
            "Whatever pathetic action you perform, He sits directly inside you watching absolutely everything, as the supreme 'Master' and dictator of all your karma (Karmadhyakshah)."
            "He alone is the ultimate physical home (Adivasah) of all beings. He functions strictly as the silent, terrifying 'Witness' (Sakshi) watching the biological drama of your life."
            "He is Supreme Consciousness (Cheta), flawlessly 'Alone and Absolute' (Kevalo), and violently free from every single physical attribute or form (Nirgunashcha)."
            "When the Yogi successfully unmasks this 'One God' hiding inside his own flesh, every religion and temple on Earth instantly turns to worthless dirt."
            "He flawlessly realizes that the Supreme Dictator he was desperately hunting externally was sitting right inside his own chest."
            "The microsecond this is realized, the human 'Ego' detonates in a catastrophic explosion, leaving strictly only 'That One God' reigning supreme!"
        """.trimIndent()
    ),
    BrahmaShloka(
        id = 14,
        sanskrit = "आत्मानमराणिं कृत्वा प्रणवं चोत्तराणिम् । ध्याननिर्मथनाभ्यासाद्देवं पश्येन्निगूढवत् ॥ १४॥",
        hindi = """
            (परम मोक्ष का खौफनाक फॉर्मूला - 'द एंड'): "उपनिषद अपने इस ज्ञान रूपी परमाणु बम को एक सबसे शक्तिशाली रहस्य के साथ समाप्त करता है।"
            "अगर तुम उस छिपे हुए भगवान को देखना चाहते हो, तो यह प्रलयंकारी फॉर्मूला अपनाओ:"
            "अपनी 'आत्मा' को नीचे की लकड़ी (अरणिरणिं) बनाओ, और 'ॐ' (प्रणव) को ऊपर की लकड़ी बनाओ।"
            "फिर अपने 'ध्यान' (Meditation) की भयानक और अथक रगड़ (निर्मथन) से इन दोनों को आपस में तब तक ज़ोर से रगड़ो..."
            "जब तक कि तुम्हारे ही भीतर से ज्ञान की वह खौफनाक और धधकती हुई आग पैदा न हो जाए!"
            "इस ध्यान की आग में तुम्हारे अज्ञान, तुम्हारे अहंकार और तुम्हारी वासनाओं का पूरी तरह से वध हो जाएगा।"
            "और तब... उसी आग के बीच से तुम्हें वह 'निगूढ' (सबसे गहराई में छिपा हुआ) परमेश्वर अपनी पूरी भव्यता के साथ साक्षात नज़र आएगा (देवं पश्येत्)!"
            "वह भगवान कहीं बाहर से नहीं आएगा; वह तुम्हारे ही भीतर हुए इस ब्रह्मांडीय विस्फोट से प्रकट होगा।"
            "जिसने इस ध्यान की आग में खुद को जला दिया, वह हमेशा के लिए जन्म और मौत की मशीन से आज़ाद हो जाता है।"
            "यहीं पर यह अत्यंत महान, रोंगटे खड़े कर देने वाला और परम पवित्र 'ब्रह्म उपनिषद' पूर्ण रूप से संपन्न होता है! ॐ शांतिः शांतिः शांतिः!"
        """.trimIndent(),
        english = """
            (The Terrifying Formula for Ultimate Liberation - 'The End'): "The Upanishad detonates its atomic bomb of cosmic wisdom, concluding with the most powerful secret in existence."
            "If you possess the audacity to witness that hidden God, explicitly execute this apocalyptic formula:"
            "Make your own 'Soul' the bottom piece of friction-wood (Arani), and make 'OM' (Pranava) the top piece of wood."
            "Then, with the violent, relentless, and terrifying friction (Nirmathana) of your extreme 'Meditation' (Dhyana), rub them together brutally..."
            "Until the catastrophic, blazing, radioactive fire of Supreme Cosmic Knowledge violently erupts directly from within you!"
            "Inside this apocalyptic fire of meditation, your ignorance, your pathetic ego, and your biological lusts will be slaughtered to absolute ashes."
            "And then... right from the epicenter of that cosmic fire, you will explicitly, physically witness (Devam pashyet) that 'Hidden' (Nigudha) Supreme God in His absolute, terrifying glory!"
            "That God will absolutely not arrive from the outside; He will violently manifest from this atomic explosion inside your own core."
            "He who has willingly incinerated himself in this fire of meditation is permanently, irrevocably liberated from the pathetic biological machine of birth and death."
            "Right exactly here, this magnificent, spine-chilling, and profoundly sacred 'Brahma Upanishad' achieves its absolute glorious completion! OM Peace, Peace, Peace!"
        """.trimIndent()
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrahmaUpanishadScreen() {
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
                // Validates if the number is between 1 and 14
                if (shlokaNumber != null && shlokaNumber in 1..14) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-14)") },
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
            itemsIndexed(brahmaShlokasList) { _, shloka ->
                BrahmaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun BrahmaShlokaCard(shloka: BrahmaShloka) {
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