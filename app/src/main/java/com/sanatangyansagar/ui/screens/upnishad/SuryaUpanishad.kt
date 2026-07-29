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

class SuryaUpanishad {

    // Data Model
    data class SuryaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val suryaShlokasList = listOf(
            SuryaShloka(
                id = 1,
                sanskrit = "ॐ भद्रं कर्णेभिः शृणुयाम देवाः भद्रं पश्येमाक्षभिर्यजत्राः । स्थिरैरङ्गैस्तुष्टुवाग्‍ँसस्तनूभिर्व्यशेम देवहितं यदायुः ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
                hindi = """
                    (ब्रह्मांडीय युद्ध का प्रलयंकारी शांति मंत्र): "यह सूर्य उपनिषद सनातन धर्म का वह धधकता हुआ न्यूक्लियर कोर (Nuclear Core) है जो कमजोरों के लिए नहीं है।"
                    "योगी सीधे देवताओं को ललकारते हुए गर्जना करता है: 'हे खौफनाक देवताओं! हम अपने इन कानों से केवल और केवल परम सत्य (भद्रं) ही सुनें!'"
                    "'हे यज्ञ के रक्षकों! हम अपनी इन आँखों से इस सड़ी हुई दुनिया का कीचड़ नहीं, बल्कि केवल उस असीम परमेश्वर का प्रलयंकारी रूप ही देखें!'"
                    "इस ज्ञान को बर्दाश्त करने के लिए इंसान का शरीर फौलाद का होना चाहिए; कमज़ोर शरीर उस भगवान की ऊर्जा से जलकर खाक हो जाएगा।"
                    "इसीलिए योगी आदेश देता है: 'हमारे अंग (Limbs) और हमारा शरीर एक चट्टान की तरह अजेय और स्थिर (स्थिरैः) हो जाए!'"
                    "'ताकि हम अपने पूरे जीवनकाल में मौत से डरे बिना, साक्षात उस परमेश्वर की असीम ताक़त को अपने भीतर उतार सकें!'"
                    "यह शांति मंत्र कोई भीख नहीं है; यह अपने भौतिक शरीर (Biological Shell) को भगवान के वज्र (Titanium) में बदलने की खूँखार घोषणा है।"
                    "जब तक शरीर अजेय नहीं होगा, तब तक सूर्य की वह रेडियोएक्टिव (Radioactive) विद्या तुम्हें ज़िंदा जला देगी।"
                    "ॐ! मेरे शरीर, मन और आत्मा के तीनों खौफनाक तापों की हमेशा-हमेशा के लिए मौत हो जाए।"
                    "यह शांति पाठ इस बात का ऐलान है कि इंसान अब सीधे उस ब्रह्मांडीय सूर्य से आँखें मिलाने जा रहा है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Peace Invocation of the Cosmic War): "This Surya Upanishad is the blazing nuclear core of Sanatana Dharma, absolutely not engineered for the weak."
                    "The Yogi violently challenges the gods, roaring: 'O terrifying deities! May we hear strictly and exclusively the Absolute Truth (Bhadram) with these physical ears!'"
                    "'O protectors of the cosmic sacrifice! May we witness not the rotting mud of this world, but exclusively the apocalyptic glory of the Supreme God with these eyes!'"
                    "To endure this highly classified knowledge, the human body must be forged of indestructible steel; a weak biological shell will instantly incinerate to ash."
                    "Therefore, the Yogi issues a dictatorial command: 'May our limbs and our physical bodies mutate into something as invincible and steadfast (Sthiraih) as a cosmic monolith!'"
                    "'So that for our entire lifespan, without a micro-drop of fear of Death, we may successfully download the infinite power of God into our flesh!'"
                    "This peace mantra is absolutely no pathetic begging; it is the ruthless declaration of upgrading your biological shell into literal divine Titanium."
                    "Unless the body is rendered invincible, the radioactive, blazing science of the Sun will burn you alive."
                    "OM! May the three terrifying miseries of my physical body, biological mind, and soul suffer a brutal, permanent death."
                    "This peace invocation is the ultimate cosmic declaration that a mortal human is now preparing to stare directly into the eyes of the Cosmic Sun!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 2,
                sanskrit = "ॐ अथ सूर्याथर्वाङ्गिरसं व्याख्यास्यामः । ब्रह्मा ऋषिः । गायत्री छन्दः ।",
                hindi = """
                    (सूर्य की प्रलयंकारी विद्या का खौफनाक आरंभ): "अब अथर्ववेद के उस सबसे गुप्त और खतरनाक रहस्य (सूर्याथर्वाङ्गिरसं) का ताला तोड़ा जा रहा है।"
                    "यह कोई साधारण पाठ नहीं है; यह वह न्यूक्लियर कोड (Nuclear Code) है जो सीधे भगवान सूर्य के दिमाग से निकाला गया है।"
                    "इस प्रलयंकारी मंत्र के दृष्टा (खोजकर्ता) कोई आम इंसान नहीं, बल्कि साक्षात सृष्टि के रचयिता 'भगवान ब्रह्मा' (ब्रह्मा ऋषिः) हैं!"
                    "उन्होंने खुद इस असीम ऊर्जा को अपनी आत्मा में फोड़ा था और फिर इस मंत्र को ब्रह्मांड के लिए डिकोड (Decode) किया था।"
                    "इस भयंकर हथियार का जो 'छन्द' (Meter/Format) है, वह 'गायत्री' है; यह वह फ्रीक्वेंसी है जो सीधे इंसान के डीएनए को हैक करती है।"
                    "बिना ऋषि और छन्द जाने जो मूर्ख इस मंत्र को पढ़ता है, वह एक बिना पिन वाले ग्रेनेड (Grenade) से खेलने जैसा है।"
                    "सूर्य कोई आसमान में जलने वाला गैस का गोला नहीं है; वह साक्षात उस 'परब्रह्म' की भौतिक और धधकती हुई आँख है।"
                    "यह विद्या इंसान के भीतर सोए हुए उस अनंत सूरज को जगाने का काम करती है।"
                    "जब यह ज्ञान इंसान के दिमाग में उतरता है, तो उसके जन्मों का अँधेरा एक सेकंड में भाप बनकर उड़ जाता है।"
                    "तैयार हो जाओ, क्योंकि अब ब्रह्मांड की सबसे बड़ी ताक़त का पर्दाफाश होने वाला है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Genesis of the Apocalyptic Solar Science): "Now the absolute maximum-security lock of the Atharva Veda's most lethal secret (Suryatharvangirasam) is being violently smashed open."
                    "This is absolutely no ordinary recitation; it is the exact Nuclear Code extracted directly from the literal brain of the Sun God."
                    "The Seer (Discoverer) of this apocalyptic mantra is absolutely no mortal human, but explicitly the Creator of the cosmos, 'Lord Brahma' Himself (Brahma Rishih)!"
                    "He Himself detonated this infinite, radioactive energy inside His own soul and then Decoded this mantra for the entire universe."
                    "The 'Chhanda' (Meter/Rhythmic Format) of this terrifying weapon is 'Gayatri'; this is the exact frequency engineered to violently Hack human DNA."
                    "The pathetic fool who chants this mantra without knowing its Rishi and Meter is literally playing with a live, unpinned cosmic Grenade."
                    "The Sun is absolutely no physical ball of burning gas in the sky; it is the explicitly manifested, blazing, radioactive eye of the 'Supreme Brahman'."
                    "This highly classified science is engineered strictly to violently awaken the infinite, dormant Sun buried inside the human core."
                    "When this knowledge penetrates the biological brain, the pitch-black darkness of billions of lifetimes vaporizes into nothingness in one microsecond."
                    "Prepare yourself, because the absolute greatest, most terrifying power in the entire cosmos is about to be unmasked!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 3,
                sanskrit = "आदित्यो देवता । हंसः सोऽहमग्निनारायणयुक्तं बीजम् । हृल्लेखा शक्तिः ।",
                hindi = """
                    (हथियार का कोड: बीज और शक्ति का रहस्य): "इस खौफनाक ब्रह्मांडीय मिसाइल का निशाना (Target) और 'देवता' साक्षात 'आदित्य' (सूर्य) है।"
                    "लेकिन इसका ट्रिगर (Trigger) क्या है? 'हंसः सोऽहम्' (मैं ही वह परब्रह्म हूँ)— यह वह प्रलयंकारी 'बीज' (Seed Code) है!"
                    "यह बीज कोई मामूली शब्द नहीं है; यह 'अग्नि-नारायण' (Agni-Narayana) की खौफनाक और जला देने वाली ऊर्जा से पूरी तरह 'युक्त' (Charged) है।"
                    "यानी जब तुम 'सोऽहम्' कहते हो, तो तुम साक्षात नारायण की उस आग को अपने भीतर फोड़ते हो जो पूरे ब्रह्मांड को राख कर सकती है।"
                    "और इस हथियार की 'शक्ति' (Power Source) क्या है? 'हृल्लेखा शक्तिः' (ह्रीं - Hreem)!"
                    "यह 'ह्रीं' वह ब्रह्मांडीय फ्रीक्वेंसी है जो इंसान के माया के मैट्रिक्स (Matrix) को एक झटके में चीर कर रख देती है।"
                    "जब देवता, बीज और शक्ति—ये तीनों एक साथ एक योगी के दिमाग में मिलते हैं, तो एक ऐसा आध्यात्मिक धमाका होता है जो मौत को भी मार दे।"
                    "यह अपने ही शरीर के भीतर एक न्यूक्लियर रिएक्टर (Nuclear Reactor) को चालू करने का विज्ञान है।"
                    "जो इस बीज को अपने मन में गाड़ देता है, वह इंसान की श्रेणी से बाहर निकलकर सीधा परमेश्वर बन जाता है।"
                    "यह मंत्र नहीं है, यह इंसान के अहंकार का सबसे क्रूर और हिंसक कत्ल है!"
                """.trimIndent(),
                english = """
                    (The Weapon's Code: The Secret of the Seed and Power): "The absolute Target and presiding 'Deity' of this horrific cosmic missile is explicitly 'Aditya' (The Sun)."
                    "But what exactly is the Trigger? 'Hamsah So'ham' (I myself am that Supreme Brahman)—this is the apocalyptic 'Bija' (Seed Code)!"
                    "This Seed is absolutely no pathetic word; it is 100% violently 'Charged' (Yuktam) with the terrifying, incinerating radioactive energy of 'Agni-Narayana' (The Fire of God)."
                    "Meaning, when you roar 'So'ham', you are literally detonating the exact fire of Narayana inside your core, capable of reducing the entire cosmos to ashes."
                    "And what is the absolute 'Shakti' (Power Source) of this weapon? 'Hrllekha shaktih' (The explosive syllable Hreem)!"
                    "This 'Hreem' is the apocalyptic cosmic frequency engineered specifically to violently shred the Matrix of Maya in a single strike."
                    "When the Deity, the Seed, and the Power fuse simultaneously inside a Yogi's brain, a spiritual detonation occurs that slaughters Death itself."
                    "This is the precise, cold-blooded science of activating a literal Nuclear Reactor directly inside your own biological body."
                    "He who successfully implants this Seed into his mind is permanently ejected from humanity, mutating instantaneously into the Supreme God."
                    "This is no mantra; it is the most ruthless, violent, and explicit assassination of the human ego in existence!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 4,
                sanskrit = "वियदादिसर्गसमुत्पन्नकिरणं कीलकम् । चतुर्विधपुरुषार्थसिद्ध्यर्थे जपे विनियोगः ॥",
                hindi = """
                    (कील और महा-संकल्प का प्रहार): "हर ब्रह्मांडीय मिसाइल को लॉक (Lock) करने के लिए एक 'कीलक' (Pin/Password) होता है।"
                    "इस सूर्य-विद्या का कीलक क्या है? 'वियदादिसर्गसमुत्पन्नकिरणं'— सूरज की वो पहली खौफनाक और प्रलयंकारी किरणें..."
                    "जिनसे यह असीम अंतरिक्ष (Space/वियद) और यह पूरा का पूरा ब्रह्मांड पैदा हुआ था!"
                    "योगी उस भयंकर क्रिएशन-एनर्जी (Creation Energy) को अपने दिमाग में एक कील की तरह ठोक देता है, ताकि यह ऊर्जा बाहर लीक (Leak) न हो।"
                    "और वह यह आत्मघाती हमला क्यों कर रहा है? 'चतुर्विधपुरुषार्थसिद्ध्यर्थे'— धर्म, अर्थ, काम और मोक्ष (परम आज़ादी) को अपनी मुट्ठी में कुचलने के लिए!"
                    "यह जप (जपे विनियोगः) भगवान के सामने रोने या भीख मांगने के लिए नहीं किया जाता।"
                    "यह जप ब्रह्मांड के सारे खज़ानों और मौत से आज़ादी को ज़बरदस्ती (Forcefully) छीन लेने का एक हिंसक संकल्प है।"
                    "जब वह योगी इस कीलक को अपने मन में लॉक करता है, तो माया का कोई भी वायरस (Virus) उसे हैक नहीं कर सकता।"
                    "वह साक्षात ईश्वर के एडमिन पैनल (Admin Panel) में घुसकर सृष्टि के सारे नियम अपने हाथ में ले लेता है।"
                    "यह योग इंसान को भिखारी से सीधा इस ब्रह्मांड का इकलौता तानाशाह (Dictator) बना देता है!"
                """.trimIndent(),
                english = """
                    (The Pin and the Strike of the Cosmic Resolve): "Every single cosmic missile requires a 'Kilakam' (Safety Pin / Password) to violently Lock it in place."
                    "What is the Kilakam of this Solar Science? 'Viyadadisargasamutpannakiranam'—The very first, apocalyptic, and terrifying rays of the Sun..."
                    "From which this entire infinite 'Space' (Viyad) and the entire colossal universe were violently spawned!"
                    "The Yogi hammers that horrific Creation-Energy directly into his brain like a titanium nail, ensuring this radioactive power absolutely never Leaks out."
                    "And why exactly is he executing this suicide-assault? 'Chaturvidhapurusharthasiddhyarthe'—To brutally crush Dharma, Wealth, Desire, and Moksha (Absolute Freedom) directly within his fist!"
                    "This rigorous chanting (Jape viniyogah) is absolutely not executed to pathetically cry or beg before God."
                    "This Japa is a violent, ruthless resolution to Forcefully hijack all the treasures of the cosmos and snatch absolute freedom from Death."
                    "When the Yogi forcefully Locks this Kilakam into his mind, absolutely no Virus of Maya can ever hack his consciousness."
                    "He literally penetrates the Admin Panel of God, seizing every single law of the universe into his own hands."
                    "This Yoga violently mutates a human from a pathetic beggar into the sole, undisputed Dictator of the cosmos!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 5,
                sanskrit = "सूर्याद्भवन्ति भूतानि सूर्येण पालितानि तु । सूर्ये लयं प्राप्नुवन्ति यः सूर्यः सोऽहमेव च ॥",
                hindi = """
                    (ब्रह्मांड का सबसे नंगा सच - 'मैं ही वह सूर्य हूँ'): "यह श्लोक सनातन धर्म का वह एटम बम (Atom Bomb) है जो इंसान का दिमाग फाड़ देता है!"
                    "उपनिषद गर्जना करता है: 'सूर्याद्भवन्ति भूतानि'— इस ब्रह्मांड के सारे जीव, सारे ग्रह और सारी आकाशगंगाएं केवल इसी परम सूर्य से पैदा होते हैं!"
                    "'सूर्येण पालितानि तु'— यह सूर्य ही वह खौफनाक और असीम ऊर्जा है जो इस पूरी सृष्टि को हर सेकंड ज़िंदा रखे हुए है।"
                    "'सूर्ये लयं प्राप्नुवन्ति'— और जब महा-प्रलय (Doomsday) आती है, तो सब कुछ जलकर इसी सूर्य के ब्लैक होल (Black Hole) में राख हो जाता है।"
                    "सृष्टि की शुरुआत सूर्य है, बीच सूर्य है, और अंत भी सूर्य है; इसके अलावा कुछ है ही नहीं।"
                    "लेकिन सबसे प्रलयंकारी धमाका श्लोक के अंत में होता है: 'यः सूर्यः सोऽहमेव च'!"
                    "यानी 'वह जो असीम, ब्रह्मांड को बनाने और भस्म करने वाला सूर्य है... वह कोई और नहीं, केवल और केवल मैं ही हूँ!'"
                    "योगी चीखकर ऐलान करता है कि आसमान में जो चमक रहा है, वह मेरी ही ऊर्जा का एक छोटा सा कतरा है।"
                    "जब इंसान खुद को उस सूर्य से जोड़ लेता है, तो उसका 'छोटा मैं' (Human Ego) हमेशा के लिए मर जाता है।"
                    "वह हाड़-मांस का पुतला नहीं रहता; वह साक्षात वह परमेश्वर बन जाता है जो मौत को भी जला कर राख कर दे!"
                """.trimIndent(),
                english = """
                    (The Most Naked Truth of the Cosmos - 'I am that Exact Sun'): "This Shloka is the literal Atom Bomb of Sanatana Dharma engineered to violently tear the human brain to shreds!"
                    "The Upanishad roars: 'Suryadbhavanti bhutani'—Every single biological creature, every planet, and all galaxies in this cosmos are violently spawned strictly from this Supreme Sun!"
                    "'Suryena palitani tu'—This Sun is the horrific, infinite, radioactive energy that forcibly keeps this entire creation breathing every single microsecond."
                    "'Surye layam prapnuvanti'—And when the Great Annihilation (Doomsday) strikes, absolutely everything incinerates and turns to ash inside the Black Hole of this exact Sun."
                    "The genesis of creation is the Sun, the middle is the Sun, and the violent end is the Sun; absolutely nothing else exists."
                    "But the most apocalyptic detonation occurs at the very end: 'Yah Suryah So'hameva cha'!"
                    "Meaning, 'That infinite, terrifying Sun which violently spawns and incinerates the cosmos... is absolutely no one else, it is exclusively and explicitly ME!'"
                    "The Yogi screams and declares that the blazing star in the sky is merely a pathetic, microscopic fraction of his own personal energy."
                    "When the human violently merges his consciousness with that Sun, his 'Tiny I' (Human Ego) dies a brutal, permanent death."
                    "He ceases to be a puppet of flesh; he explicitly mutates into the Supreme God who can incinerate Death itself into absolute ashes!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 6,
                sanskrit = "चक्षुर्नो देवः सविता चक्षुर्न उत पर्वतः । चक्षुर्धाता दधातु नः ॥",
                hindi = """
                    (दिव्य चक्षु: ब्रह्मांडीय दृष्टि की मांग): "योगी को दुनिया देखने के लिए इन चमड़े की सड़ी हुई आँखों की कोई ज़रूरत नहीं है।"
                    "वह उस परम सूर्य से सीधा टकराता है और कहता है: 'चक्षुर्नो देवः सविता'— हे भगवान सूर्य! तुम ही हमारी असली 'आँख' (Cosmic Vision) बन जाओ!"
                    "'चक्षुर्न उत पर्वतः'— वह अजेय और अचल पर्वत भी हमारे लिए एक दिव्य दृष्टि बन जाए, ताकि हम सत्य को अडिग होकर देख सकें।"
                    "'चक्षुर्धाता दधातु नः'— सृष्टि को धारण करने वाला वह परम धाता (विधाता) हमारे भीतर उस खौफनाक और असली 'ब्रह्मांडीय दृष्टि' को स्थापित कर दे!"
                    "जब इंसान इस दिव्य चक्षु (Third Eye) को प्राप्त कर लेता है, तो यह माया (Illusion) का पर्दा हमेशा के लिए जल जाता है।"
                    "वह दीवारों के आर-पार, समय के आर-पार और मौत के आर-पार साक्षात उस सत्य को देखने लगता है।"
                    "उसके लिए कोई भी रहस्य, कोई भी डायमेंशन (Dimension) छिपा नहीं रह सकता।"
                    "यह कोई साधारण प्रार्थना नहीं है; यह अपने बायोलॉजिकल सिस्टम (Biological System) को हैक करके उसे कॉस्मिक रडार (Cosmic Radar) में बदलने का कमांड (Command) है।"
                    "जिसकी आँखें सूर्य बन जाएं, उसके जीवन में कभी कोई अँधेरा या कोई अज्ञान ज़िंदा नहीं बच सकता।"
                    "यह शरीर के सबसे बड़े अपग्रेड (Upgrade) की खौफनाक शुरुआत है!"
                """.trimIndent(),
                english = """
                    (The Divine Eye: The Demand for Cosmic Vision): "The Yogi possesses absolutely zero need for these rotting leather eyeballs to witness the universe."
                    "He collides head-on with that Supreme Sun and commands: 'Chakshurno devah Savita'—O Lord Sun! Mutate and literally become our true 'Cosmic Vision'!"
                    "'Chakshurna uta parvatah'—May that invincible, immovable cosmic mountain also mutate into our divine sight, so we may witness the Truth unflinchingly."
                    "'Chakshurdhata dadhatu nah'—May the Supreme Sustainer of creation forcibly implant that terrifying, authentic 'Universal Vision' directly inside our core!"
                    "When a human successfully seizes this Divine Eye (Third Eye), the curtain of Maya (Illusion) is permanently incinerated."
                    "He begins to flawlessly perceive the Absolute Truth directly through solid walls, straight through Time, and violently through Death itself."
                    "Absolutely no classified secret, no parallel Dimension can ever remain hidden from his terrifying gaze."
                    "This is no pathetic prayer; it is a direct biological Command to Hack your optical system and mutate it into a literal Cosmic Radar."
                    "He whose physical eyes mutate into the Sun can absolutely never harbor any darkness or biological ignorance in his existence."
                    "This is the horrific genesis of the greatest physical and spiritual Upgrade of the human shell!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 7,
                sanskrit = "आदित्य एव ब्रह्मा आदित्य एव विष्णुः आदित्य एव रुद्रः आदित्य एव ऋग्वेदो यजुर्वेदः सामवेदोऽथर्ववेदः ॥",
                hindi = """
                    (त्रिमूर्ति और वेदों का प्रलयंकारी विलय): "उपनिषद यहाँ देवताओं की अलग-अलग पहचान को एक ही झटके में हथौड़े से चकनाचूर कर देता है!"
                    "मूर्ख लोग ब्रह्मा, विष्णु और शिव को अलग-अलग मानते हैं, लेकिन यह श्लोक कहता है: 'आदित्य एव ब्रह्मा'!"
                    "यह धधकता हुआ सूर्य ही साक्षात 'ब्रह्मा' है जो सृष्टि को पैदा कर रहा है।"
                    "'आदित्य एव विष्णुः'— यही अजेय सूर्य साक्षात 'विष्णु' है जो इस पूरे ब्रह्मांड के मैट्रिक्स को चला रहा है।"
                    "और 'आदित्य एव रुद्रः'— यही खौफनाक सूर्य साक्षात 'रुद्र' (महाकाल शिव) है जो प्रलय के दिन सब कुछ जलाकर भस्म कर देगा!"
                    "न केवल देवता, बल्कि दुनिया का सारा ज्ञान— 'ऋग्वेद, यजुर्वेद, सामवेद और अथर्ववेद'— केवल इसी एक सूर्य की किरणें हैं!"
                    "धर्म के नाम पर अलग-अलग मूर्तियां पूजने वालों के लिए यह एक तमाचा है।"
                    "पूरे ब्रह्मांड में केवल एक ही ऊर्जा है, एक ही भगवान है, और वह यह 'परम सूर्य' (Brahman) है।"
                    "जब योगी इस बात को अपनी रगों में उतार लेता है, तो उसके लिए सारा द्वैत (Duality) हमेशा के लिए मर जाता है।"
                    "वह जान जाता है कि क्रिएटर (Creator), ऑपरेटर (Operator) और डिस्ट्रॉयर (Destroyer) केवल एक ही महा-विस्फोट (Big Bang) का हिस्सा हैं!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Fusion of the Trinity and the Vedas): "Here, the Upanishad takes a sledgehammer and violently shatters the pathetic illusion of separate deities in a single strike!"
                    "Fools hallucinate Brahma, Vishnu, and Shiva as distinct entities, but this Shloka roars: 'Aditya eva Brahma'!"
                    "This blazing, radioactive Sun is explicitly 'Brahma' Himself, actively spawning the entire creation."
                    "'Aditya eva Vishnuh'—This invincible Sun is literally 'Vishnu' Himself, flawlessly operating the Matrix of this entire cosmos."
                    "And 'Aditya eva Rudrah'—This terrifying Sun is explicitly 'Rudra' (Mahakala Shiva) Himself, who will incinerate absolutely everything to ashes on Doomsday!"
                    "Not just the gods, but absolutely all cosmic knowledge—'Rig Veda, Yajur Veda, Sama Veda, and Atharva Veda'—are strictly the radiation emitted by this single Sun!"
                    "This is a brutal slap to those who pathetically worship separate physical idols in the name of religion."
                    "In the entire infinite cosmos, there is strictly One Energy, One God, and that is this 'Supreme Sun' (Brahman)."
                    "When the Yogi injects this absolute truth into his veins, the entire concept of Duality dies a permanent, brutal death."
                    "He flawlessly realizes that the Creator, Operator, and Destroyer are strictly manifestations of one singular, apocalyptic Big Bang!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 8,
                sanskrit = "आदित्य एव वाङ्मनः प्राणा आदित्य एव श्रोत्रत्वक्चक्षूरसनघ्राणाः ।",
                hindi = """
                    (इंसानी शरीर और चेतना का ब्रह्मांडीय सोर्स): "यह श्लोक साबित करता है कि इंसान का यह शरीर कोई अलग मशीन नहीं, बल्कि सूर्य की ही एक बैटरी है।"
                    "उपनिषद चीख कर कहता है: 'आदित्य एव वाङ्मनः प्राणा'— तुम्हारी 'आवाज़' (Speech), तुम्हारा खूँखार 'मन' (Mind), और तुम्हारी धड़कती हुई 'साँसें' (Prana) साक्षात आदित्य ही हैं!"
                    "तुम्हारे दिमाग का हर एक विचार और तुम्हारी हर एक साँस उस परब्रह्म सूर्य की ऊर्जा से ही चल रही है।"
                    "'आदित्य एव श्रोत्रत्वक्चक्षूरसनघ्राणाः'— तुम्हारे 'कान', तुम्हारी 'त्वचा', तुम्हारी 'आँखें', तुम्हारी 'जीभ' और तुम्हारी 'नाक'..."
                    "ये पाँचों ज्ञानेंद्रियां (Senses) कोई बायोलॉजिकल पुर्जे नहीं हैं; ये साक्षात उस सूर्य की किरणें हैं जो तुम्हारे शरीर में फिट (Fit) हैं!"
                    "जब तुम कुछ देखते हो, सुनते हो या सूँघते हो, तो वह तुम नहीं कर रहे हो; वह परब्रह्म तुम्हारे ज़रिए इस दुनिया का अनुभव कर रहा है।"
                    "इंसान अपने शरीर पर झूठा घमंड करता है, जबकि उसकी अपनी कोई औकात या वजूद है ही नहीं।"
                    "जिस दिन सूर्य अपनी यह ऊर्जा (Plug) वापस खींच लेगा, तुम्हारा यह शरीर एक सेकंड में सड़ा हुआ मुर्दा बन जाएगा।"
                    "योगी इस सच को जानकर अपने 'मैं शरीर हूँ' के भ्रम (Ego) को बेरहमी से कुचल देता है।"
                    "वह अपनी इंद्रियों को बाहरी दुनिया से काटकर सीधे उनके असली सोर्स (Sun/God) से जोड़ देता है!"
                """.trimIndent(),
                english = """
                    (The Cosmic Source of the Human Body and Consciousness): "This Shloka explicitly proves that this human shell is no separate machine, but strictly a biological battery powered by the Sun."
                    "The Upanishad screams: 'Aditya eva vanmanah prana'—Your 'Speech' (Vak), your ferocious 'Mind' (Manas), and your violently beating 'Breath' (Prana) are explicitly Aditya Himself!"
                    "Every single microscopic thought in your brain and every biological breath is powered exclusively by the radioactive energy of that Supreme Sun."
                    "'Aditya eva shrotratvakchakshurasanaghranah'—Your 'Ears', your 'Skin', your 'Eyes', your 'Tongue', and your 'Nose'..."
                    "These five senses are absolutely no pathetic biological components; they are literal rays of that Sun explicitly installed inside your flesh!"
                    "When you witness, hear, or smell the world, it is absolutely not YOU doing it; it is the Supreme Brahman experiencing the matrix through your shell."
                    "Humans pathetically boast about their bodies, while in absolute reality, their independent existence is exactly zero."
                    "The exact microsecond the Sun pulls His Plug of energy, this biological body mutates instantaneously into a rotting corpse."
                    "Realizing this horrific truth, the Yogi ruthlessly crushes his hallucination (Ego) of 'I am this body' to dust."
                    "He violently severs his senses from the external matrix and Hardwires them directly into their authentic Source (The Sun/God)!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 9,
                sanskrit = "आदित्यो वै तेज ओजो बलं यशश्चक्षुः श्रोत्रमात्मा मनो मन्युर्मनुर्मृत्युः सत्यो मित्रो वायुराकाशः प्राणो लोकपालः कः किं कं तत्सत्यमन्नममृतो जीवो विश्वः कतमः स्वयम्भूः ब्रह्मैतदादित्यमण्डलम् ॥",
                hindi = """
                    (परमेश्वर का सबसे खौफनाक और असीम रूप): "यह श्लोक पूरे ब्रह्मांड की हर ताक़त, हर ऊर्जा और हर रहस्य को एक ही भगवान (सूर्य) के भीतर ठूंस देता है!"
                    "आदित्य ही 'तेज', 'ओज', 'बल' (Power), 'यश' और संपूर्ण विश्व की 'आँखें और कान' है।"
                    "वही सबकी 'आत्मा' है, वही 'मन' है, और वही विनाशकारी 'क्रोध' (मन्युः) है जो प्रलय लाता है!"
                    "वही 'मनु' (सृष्टिकर्ता) है, और सबसे खौफनाक बात— वही साक्षात 'मृत्युः' (Death) है जो सबको निगलेगी!"
                    "वही 'सत्य' है, वही 'वायु', वही असीम 'आकाश', और वही पूरे ब्रह्मांड का 'प्राण' (Life-force) है।"
                    "वही परम 'अमृत' है, वही 'जीव' है, वही 'अन्न' (खाना) है जिसे तुम खाते हो, और वही 'कः' (प्रजापति) है।"
                    "वही यह पूरा 'विश्व' है और वही साक्षात 'स्वयम्भू' (जो खुद से पैदा हुआ है) परब्रह्म है!"
                    "यह जो 'आदित्यमण्डल' (सूरज का धधकता हुआ गोला) तुम्हें आसमान में दिखता है, वह केवल एक सितारा नहीं..."
                    "वह साक्षात 'ब्रह्मैतद्'— वह 100% शुद्ध, असीम और प्रलयंकारी परमेश्वर का भौतिक (Physical) रूप है!"
                    "इस एक श्लोक ने दुनिया के हर द्वैत (Duality) को बम से उड़ा दिया है; सूरज के अलावा इस ब्रह्मांड में 'कुछ भी' नहीं है!"
                """.trimIndent(),
                english = """
                    (The Most Terrifying and Infinite Form of the Supreme God): "This Shloka violently crams every single power, energy, and cosmic secret of the entire universe strictly into ONE God (The Sun)!"
                    "Aditya alone is 'Brilliance', 'Vitality', 'Absolute Power' (Balam), 'Glory', and the literal 'Eyes and Ears' of the entire cosmos."
                    "He alone is the 'Soul' (Atma) of all, He is the 'Mind', and He is the apocalyptic 'Wrath' (Manyuh) that triggers Doomsday!"
                    "He is 'Manu' (The Creator), and the most terrifying fact—He is explicitly 'Death' (Mrityuh) itself that will ruthlessly swallow absolutely everything!"
                    "He is the 'Absolute Truth', He is the 'Wind', the infinite 'Space', and the universal 'Prana' (Life-force)."
                    "He is the supreme 'Nectar of Immortality', He is the 'Biological Soul', He is the 'Food' you consume, and He is 'Prajapati'."
                    "He alone is this entire 'Cosmos' (Vishvah) and He is the explicit 'Svayambhu' (Self-manifested) Supreme Brahman!"
                    "This 'Aditya-Mandala' (The blazing Solar Orb) you witness in the sky is absolutely no pathetic astronomical star..."
                    "It is literally 'Brahmaitad'—the 100% pure, infinite, and apocalyptic physical manifestation of the Supreme God!"
                    "This single Shloka has blown up every trace of Duality with cosmic dynamite; other than the Sun, absolutely 'Nothing' exists in this universe!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 10,
                sanskrit = "ॐ घृणिः सूर्य आदित्य ओम् इति ।",
                hindi = """
                    (ब्रह्मांड को हैक करने वाला अष्टाक्षर मंत्र): "अब उपनिषद उस खौफनाक और सबसे गुप्त पासवर्ड (Password) को उजागर करता है जिससे सूर्य का कंट्रोल रूम खुलता है।"
                    "यह मंत्र है: 'ॐ घृणिः सूर्य आदित्य ओम्'!"
                    "यह कोई सामान्य पूजा का मंत्र नहीं है; यह एक ऐसा न्यूक्लियर कोड (Nuclear Code) है जो सीधा इंसान के अहंकार को भस्म करता है।"
                    "'ॐ' से यह शुरू होता है, जो पूरे ब्रह्मांड की फ्रीक्वेंसी है; और 'ॐ' पर ही यह खत्म होता है।"
                    "'घृणिः' का मतलब है वह असीम और जला देने वाला प्रकाश जो अज्ञान के अँधेरे को एक सेकंड में खा जाए।"
                    "'सूर्य' वह है जो पूरी सृष्टि को पैदा करता है और चलाता है।"
                    "'आदित्य' वह है जो अंत में सब कुछ अपने भीतर खींचकर (Black Hole की तरह) नष्ट कर देता है।"
                    "जब योगी इस मंत्र को अपनी साँसों में धधकाता है, तो वह इन तीनों प्रलयंकारी ताक़तों को अपने शरीर में बुला लेता है।"
                    "इस एक मंत्र की गर्मी से जन्मों-जन्मों के पाप, कर्म और बीमारियां राख के ढेर में बदल जाती हैं।"
                    "यह माया (Matrix) को हैक करके साक्षात परमेश्वर की कुर्सी पर बैठने का सीधा और क्रूर हथियार है!"
                """.trimIndent(),
                english = """
                    (The Eight-Syllable Mantra that Hacks the Cosmos): "Now the Upanishad violently unmasks the horrific and most highly classified Password that unlocks the absolute Control Room of the Sun."
                    "This apocalyptic mantra is: 'OM Ghrinih Surya Aditya OM'!"
                    "This is absolutely no pathetic prayer mantra; it is a literal Nuclear Code engineered to directly incinerate the human ego to ashes."
                    "It detonates with 'OM', the exact frequency of the entire cosmos; and it brutally terminates with 'OM'."
                    "'Ghrinih' explicitly means that infinite, incinerating light which completely swallows the darkness of ignorance in a single microsecond."
                    "'Surya' is the terrifying entity that actively spawns and relentlessly operates the entire creation."
                    "'Aditya' is the apocalyptic force that ultimately sucks absolutely everything back into its core (exactly like a Black Hole) and destroys it."
                    "When the Yogi blazes this mantra within his breath, he summons all three of these apocalyptic cosmic forces directly into his biological shell."
                    "The sheer radioactive heat of this single mantra instantly reduces billions of lifetimes of sins, karma, and diseases into a pile of ash."
                    "This is the direct, cold-blooded weapon to perfectly Hack the Matrix (Maya) and violently seize the absolute throne of the Supreme God!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 11,
                sanskrit = "ॐ इति येकाक्षरं ब्रह्म । घृणिरिति द्वे अक्षरे । सूर्य इत्यक्षरद्वयम् ।",
                hindi = """
                    (मंत्र की माइक्रो-इंजीनियरिंग और परमाणु संरचना): "उपनिषद इस खौफनाक मंत्र को एक वैज्ञानिक की तरह खोलकर (Dissect करके) दिखाता है।"
                    "'ॐ' (OM)— यह वह एक अक्षर (येकाक्षरं) है जो साक्षात 'परब्रह्म' (The Ultimate God) का भौतिक और ध्वनि रूप (Sound Form) है।"
                    "ॐ के बिना ब्रह्मांड का कोई वजूद नहीं; यह हर परमाणु के भीतर गूँजने वाली वो आवाज़ है जो सृष्टि को टूटने से रोकती है।"
                    "'घृणिः' (Ghrinih)— इसमें 'दो अक्षर' (द्वे अक्षरे) हैं। यह वह प्रलयंकारी किरण (Ray) है जो इंसान के तीसरे नेत्र (Third Eye) को चीर कर खोलती है।"
                    "'सूर्य' (Surya)— इसमें भी 'दो अक्षर' (अक्षरद्वयम्) हैं। यह वह सुप्रीम इंजन (Supreme Engine) है जो ज़िंदगियों को चला रहा है।"
                    "यह मंत्र कोई शब्दों का खेल नहीं है; यह चेतना (Consciousness) की प्रोग्रामिंग (Programming) है।"
                    "जैसे एक बम को बनाने के लिए अलग-अलग केमिकल मिलाए जाते हैं, वैसे ही इन अक्षरों को मिलाकर यह ब्रह्मांडीय अस्त्र तैयार किया गया है।"
                    "हर एक अक्षर योगी के नर्वस सिस्टम (Nervous System) के एक खास हिस्से पर हथौड़े की तरह वार करता है।"
                    "जब योगी इस मंत्र का विच्छेदन (Anatomy) समझकर इसे जपता है, तो उसका असर करोड़ों गुना ज़्यादा घातक हो जाता है।"
                    "यह मंत्र माया की इस सड़ी हुई जेल (Matrix) के दरवाज़े को बम से उड़ाने का सटीक फॉर्मूला है!"
                """.trimIndent(),
                english = """
                    (The Micro-Engineering and Atomic Structure of the Mantra): "The Upanishad violently dissects this horrific mantra exactly like a ruthless cosmic scientist."
                    "'OM'—This is the 'Single Syllable' (Ekaksharam) which is the literal, physical, and acoustic manifestation (Sound Form) of the 'Supreme Brahman'!"
                    "Without OM, the universe possesses zero existence; it is the radioactive frequency echoing inside every atom that prevents creation from collapsing."
                    "'Ghrinih'—This consists of exactly 'Two Syllables' (Dve akshare). This is the apocalyptic ray of light that violently rips open the human's Third Eye."
                    "'Surya'—This also contains exactly 'Two Syllables' (Aksharadvayam). This is the Supreme Engine relentlessly driving all biological life."
                    "This mantra is absolutely no pathetic play of words; it is the explicit Programming code of absolute Consciousness."
                    "Just as highly volatile chemicals are combined to construct a nuclear bomb, these specific syllables are fused to forge this cosmic weapon."
                    "Every single syllable strikes a highly specific sector of the Yogi's Nervous System exactly like a sledgehammer."
                    "When the Yogi perfectly decodes the Anatomy of this mantra and fires it, its lethality skyrockets billions of times."
                    "This is the exact, flawless mathematical formula to blow the titanium door of this rotting Matrix prison to absolute shreds with dynamite!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 12,
                sanskrit = "आदित्य इति त्रीण्यक्षराणि । एतस्यैवाष्टक्षरो मनुः ॥",
                hindi = """
                    (ब्रह्मांड का अजेय आठ-अक्षरों वाला हथियार): "अब इस मंत्र का आखिरी और सबसे खतरनाक हिस्सा जुड़ता है।"
                    "'आदित्य' (Aditya)— इसमें 'तीन अक्षर' (त्रीण्यक्षराणि) हैं। यह वह शक्ति है जो मौत को भी अपने भीतर निगल लेती है।"
                    "और जब ॐ (1) + घृणि (2) + सूर्य (2) + आदित्य (3) को एक साथ मिलाया जाता है..."
                    "तो यह बनता है 'अष्टाक्षरो मनुः' (आठ अक्षरों वाला ब्रह्मांडीय महामंत्र)!"
                    "यह आठ अक्षरों का हथियार कोई आम मंत्र नहीं है; यह एक ऐसा मिसाइल (Missile) है जिसे सीधे माया (Matrix) के दिल में दागा जाता है।"
                    "आठ की संख्या अनंत (Infinity / ∞) का प्रतीक है; यानी यह मंत्र इंसान को समय और स्थान की हदों से बाहर निकालकर अमर कर देता है।"
                    "जो योगी इस आठ अक्षरों वाले मंत्र को अपनी साँसों के साथ लॉक (Lock) कर लेता है, उसका शरीर एक अभेद्य किला बन जाता है।"
                    "दुनिया की कोई बीमारी, कोई अस्त्र, कोई ग्रह (Planets) या कोई देवता उसे नुकसान नहीं पहुँचा सकता।"
                    "यह मंत्र इंसान के अज्ञान का सबसे क्रूरता से वध करता है और उसकी आत्मा को साक्षात सूर्य की आग में बदल देता है।"
                    "जो इस अष्टाक्षर मंत्र का मालिक बन गया, वह पूरे ब्रह्मांड के कंट्रोल रूम का मालिक बन गया!"
                """.trimIndent(),
                english = """
                    (The Invincible Eight-Syllable Weapon of the Cosmos): "Now the final and most catastrophically dangerous segment of this mantra locks into place."
                    "'Aditya'—This contains exactly 'Three Syllables' (Trinyaksharani). This is the apocalyptic force that violently swallows Death itself into its core."
                    "And when OM (1) + Ghrini (2) + Surya (2) + Aditya (3) are violently fused together..."
                    "It explicitly detonates into the 'Ashtaksharo Manuh' (The Eight-Syllabled Cosmic Maha-Mantra)!"
                    "This eight-syllable weapon is absolutely no ordinary chant; it is a literal cosmic Missile fired directly into the beating heart of the Matrix (Maya)."
                    "The number eight represents absolute Infinity (∞); meaning this exact mantra violently ejects the human beyond the pathetic limits of Space and Time, immortalizing him."
                    "The Yogi who successfully Locks this eight-syllable mantra to his biological breath mutates his flesh into an impenetrable titanium fortress."
                    "Absolutely zero biological disease, no weapon, no planetary alignment, and no God possesses the capacity to harm him."
                    "This mantra executes the most ruthless, cold-blooded assassination of human ignorance and mutates the soul into the blazing fire of the literal Sun."
                    "He who becomes the Master of this eight-syllable weapon instantaneously becomes the absolute Dictator of the universe's Control Room!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 13,
                sanskrit = "यः सदाहरहर्जपति स वै ब्राह्मणो भवति स वै ब्राह्मणो भवति ।",
                hindi = """
                    (असली ब्राह्मण की खौफनाक परिभाषा): "उपनिषद जातिवाद और जन्म के झूठे ढोंग का बेरहमी से गला घोंट देता है!"
                    "ब्राह्मण वह नहीं है जो किसी विशेष घर में पैदा हुआ है; जन्म से कोई इंसान महान नहीं होता।"
                    "'यः सदाहरहर्जपति'— जो कोई भी इंसान इस आठ अक्षरों वाले प्रलयंकारी सूर्य मंत्र को हर दिन, हर पल (सदा अहरहः) अपनी साँसों में धधकाता है..."
                    "जो अपने 'अहंकार' (Ego) को इस मंत्र की आग में ज़िंदा जला देता है..."
                    "'स वै ब्राह्मणो भवति'— केवल और केवल वही इंसान इस पूरे ब्रह्मांड में सच्चा और असली 'ब्राह्मण' (Brahmin / Knower of Brahman) है!"
                    "(इस 100% अटल सत्य की गारंटी देने के लिए श्रुति इस बात को दो बार चीख कर दोहराती है: 'स वै ब्राह्मणो भवति')!"
                    "असली ब्राह्मणत्व (Brahminhood) कोई जन्म का अधिकार नहीं है; यह अपनी ही वासनाओं का कत्ल करके छीना गया ब्रह्मांडीय रुतबा (Status) है।"
                    "अगर तुमने इस सत्य का विस्फोट अपने भीतर नहीं किया, तो शरीर पर सूत का धागा पहनने से तुम केवल एक पाखंडी बनते हो।"
                    "सनातन धर्म खून को नहीं, बल्कि चेतना (Consciousness) के इस खौफनाक अपग्रेड (Upgrade) को पूजता है।"
                    "जो इस मंत्र को सिद्ध कर लेता है, वह समाज के नियमों से ऊपर उठकर साक्षात भगवान की गद्दी पर बैठ जाता है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Definition of an Authentic Brahmin): "The Upanishad violently strangles the pathetic hypocrisy of casteism and physical birth to absolute death!"
                    "A Brahmin is absolutely not someone spawned in a specific biological household; absolutely no mortal is born great from a human womb."
                    "'Yah sadaharahar japati'—Whosoever human being constantly, every single microsecond (Sada aharahah), blazes this apocalyptic eight-syllable Solar Mantra in his breath..."
                    "He who burns his pathetic 'Ego' (I) alive in the radioactive fire of this exact mantra..."
                    "'Sa vai brahmano bhavati'—Strictly and exclusively ONLY that specific human is the genuine, authentic 'Brahmin' (Knower of Brahman) in the entire infinite cosmos!"
                    "(To stamp a 100% ironclad cosmic guarantee on this truth, the Shruti screams and repeats it twice: 'Sa vai brahmano bhavati')!"
                    "Authentic Brahminhood is absolutely no pathetic birthright; it is a cosmic Status violently snatched by executing the brutal slaughter of your own lusts."
                    "If you have not detonated this absolute truth inside your core, wearing a cotton thread on your flesh merely makes you a pathetic hypocrite."
                    "Sanatana Dharma absolutely does not worship bloodlines; it explicitly worships this terrifying, apocalyptic Upgrade of Consciousness."
                    "He who masters this mantra rockets completely beyond societal laws and sits explicitly on the undisputed throne of God!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 14,
                sanskrit = "भास्कराय विद्महे महद्द्युतिकराय धीमहि । तन्न आदित्यः प्रचोदयात् ॥",
                hindi = """
                    (सूर्य गायत्री: अज्ञान को अंधा करने वाला लेज़र): "यह सनातन धर्म की वह प्रलयंकारी 'सूर्य गायत्री' है, जिसे ब्रह्मांड का सबसे खतरनाक लेज़र बीम (Laser Beam) माना जाता है।"
                    "योगी गर्जना करता है: 'भास्कराय विद्महे'— हम उस साक्षात 'भास्कर' (जो असीम प्रकाश पैदा करता है) को जानते हैं और उसी पर अपने दिमाग को लॉक (Lock) करते हैं!"
                    "'महद्द्युतिकराय धीमहि'— जो 'महान द्युति' (Terrifying, Radioactive Brilliance) को पैदा करने वाला है, हम उसी की खौफनाक ऊर्जा का 'ध्यान' करते हैं!"
                    "हम अपना ध्यान किसी कमज़ोर या नश्वर चीज़ पर नहीं, बल्कि उस अजेय आग पर केंद्रित करते हैं जो पूरे ब्रह्मांड को भस्म कर सकती है।"
                    "'तन्न आदित्यः प्रचोदयात्'— वह साक्षात आदित्य (सूर्य भगवान) हमारी 'बुद्धि' (Intellect) को हैक करके उसे सही दिशा में फायर (Fire) करे!"
                    "इंसान की बुद्धि माया (Matrix) के वायरस से करप्ट (Corrupt) हो चुकी है; वह केवल वासना और पैसे के बारे में सोचती है।"
                    "यह गायत्री मंत्र इंसान की उस सड़ी हुई बुद्धि का सिस्टम फॉर्मेट (Format) कर देता है।"
                    "जब सूर्य की ऊर्जा इंसान के दिमाग में घुसती है, तो उसके सारे डर, डिप्रेशन (Depression) और अज्ञान एक सेकंड में राख हो जाते हैं।"
                    "यह मंत्र कोई प्रार्थना नहीं है; यह अपनी बुद्धि को साक्षात ईश्वर के सुपर-कंप्यूटर (Super-computer) से जोड़ने का डायरेक्ट प्लग (Direct Plug) है।"
                    "जिसकी बुद्धि को सूर्य चला रहा हो, उसे ब्रह्मांड की कौन सी ताक़त रोक सकती है?"
                """.trimIndent(),
                english = """
                    (Surya Gayatri: The Laser That Blinds Ignorance): "This is Sanatana Dharma's apocalyptic 'Surya Gayatri', recognized universally as the most lethal Laser Beam in the cosmos."
                    "The Yogi roars: 'Bhaskaray vidmahe'—We explicitly acknowledge that literal 'Bhaskara' (The Generator of Infinite Light) and violently Lock our brains exclusively onto Him!"
                    "'Mahaddyutikaraya dhimahi'—We forcefully 'Meditate' strictly on that catastrophic entity who unleashes 'Mahaddyuti' (Terrifying, Radioactive Cosmic Brilliance)!"
                    "We absolutely refuse to focus our meditation on pathetic mortal objects; we anchor our minds directly onto that invincible fire capable of incinerating the universe."
                    "'Tanna Adityah prachodayat'—May that explicit Aditya (Sun God) violently Hack our 'Intellect' (Buddhi) and Fire it directly toward the Absolute Truth!"
                    "The human intellect is severely Corrupted by the virus of the Matrix (Maya); it hallucinates strictly about lust and pathetic wealth."
                    "This Gayatri Mantra completely and ruthlessly Formats the rotting biological operating system of the human brain."
                    "When the Sun's radioactive energy penetrates the skull, all fear, depression, and cosmic ignorance are incinerated to ash in one microsecond."
                    "This mantra is absolutely no pathetic prayer; it is the Direct Plug to hardwire your biological intellect straight into the Super-computer of God."
                    "He whose intellect is explicitly driven by the Supreme Sun, what pathetic force in the cosmos possesses the capability to ever stop him?"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 15,
                sanskrit = "आदित्याभिमुखो जप्त्वा महाव्याधिभयान्मुच्यते । अलक्ष्मीर्नश्यति । अभक्ष्यभक्षणात् पूतो भवति । अगम्यागमनात् पूतो भवति । पतितसम्भाषणात् पूतो भवति ।",
                hindi = """
                    (पापों और बीमारियों का क्रूर संहार): "यह विद्या कोई दर्शन (Philosophy) नहीं, बल्कि एक 100% काम करने वाला ब्रह्मांडीय एंटी-वायरस (Anti-virus) है!"
                    "'आदित्याभिमुखो जप्त्वा'— जो योगी सीधे उस धधकते हुए सूर्य की आँखों में आँखें डालकर (सूर्य की ओर मुँह करके) इस न्यूक्लियर मंत्र को फायर करता है..."
                    "वह 'महाव्याधिभयान्मुच्यते'— शरीर की सबसे खौफनाक और लाइलाज 'महा-बीमारियों' (Cancer/Leprosy) और मौत के डर से एक झटके में आज़ाद हो जाता है!"
                    "'अलक्ष्मीर्नश्यति'— उसकी ज़िंदगी से भयंकर 'दरिद्रता' (Poverty) और बर्बादी हमेशा के लिए भस्म हो जाती है; यह ब्रह्मांड का कानून है।"
                    "और सबसे प्रलयंकारी बात: अगर उसने अनजाने में 'अभक्ष्यभक्षणात्' (न खाने लायक गंदी चीज़ें खा ली हों)..."
                    "या 'अगम्यागमनात्' (गलत और वर्जित इंसानों के साथ शारीरिक संबंध बनाए हों)..."
                    "या 'पतितसम्भाषणात्' (समाज के सबसे गिरे हुए पापियों से बातचीत का पाप किया हो)..."
                    "इस सूर्य-मंत्र की आग इतनी खूँखार है कि वह इन सारे महापापों को पल भर में जलाकर उसे 100% 'पवित्र' (पूतो भवति) कर देती है!"
                    "यह कोई माफ़ी नहीं है; यह सूर्य की उस असीम ज्वाला का न्याय है जो कचरे को भी सोने में बदल देती है।"
                    "इस मंत्र के प्रहार के सामने इंसान का कोई भी पुराना पाप एक सेकंड भी ज़िंदा नहीं बच सकता!"
                """.trimIndent(),
                english = """
                    (The Ruthless Annihilation of Sins and Diseases): "This Science is absolutely no pathetic philosophy, but a 100% functional, cosmic Anti-virus designed to purge the human shell!"
                    "'Adityabhimukho japtva'—The Titan who stares directly into the eyes of the blazing Sun (facing it) and Fires this nuclear mantra..."
                    "He 'Mahavyadhibhayanmuchyate'—is instantaneously, violently liberated from the most horrific, incurable 'Catastrophic Diseases' (Cancer/Leprosy) and the pathetic terror of Death!"
                    "'Alakshmirnashyati'—Horrific 'Poverty' (Alakshmi) and utter ruin are permanently incinerated from his existence; this is an ironclad cosmic law."
                    "And the most apocalyptic fact: If he has unknowingly committed 'Abhakshyabhakshanat' (consumed forbidden, filthy, rotting substances)..."
                    "Or 'Agamyagamanat' (engaged in biological, sexual relations with forbidden or degraded entities)..."
                    "Or 'Patitasambhashanat' (incurred the sin of conversing with the most utterly fallen, toxic sinners of society)..."
                    "The radioactive fire of this Solar Mantra is so ferocious that it instantaneously burns all these Catastrophic Sins to ash, mutating him into 100% 'Pure' (Puto bhavati)!"
                    "This is absolutely no pathetic forgiveness; it is the ruthless justice of the Sun's infinite inferno that mutates literal garbage into solid gold."
                    "Faced with the catastrophic strike of this mantra, absolutely zero past sins of a human can survive for even a microsecond!"
                """.trimIndent()
            ),
            SuryaShloka(
                id = 16,
                sanskrit = "प्रातर्धीयानो रात्रिकृतं पापं नाशयति । सायं धीयानो दिवसकृतं पापं नाशयति । मध्याह्ने सूर्याभिमुखः पठेत् सद्यः पञ्चमहापातकात् प्रमुच्यते । य एतां महाविद्यां ब्रह्माद्यां जपति स महापापात् प्रमुच्यते स महापापात् प्रमुच्यते । इत्युपनिषत् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
                hindi = """
                    (महापापों का विस्फोट और 'द एंड'): "उपनिषद इस ब्रह्मांडीय हथियार (महाविद्या) के अंतिम और सबसे खौफनाक परिणामों की घोषणा करता है।"
                    "जो योगी सुबह इसका ध्यान (फायर) करता है, वह रात के अँधेरे में किए गए हर पाप का बेरहमी से कत्ल कर देता है (पापं नाशयति)!"
                    "जो शाम को इसे धागता है, वह दिन के उजाले में किए गए हर कर्म और पाप को जलाकर राख कर देता है।"
                    "लेकिन सबसे प्रलयंकारी वार... जो दोपहर (मध्याह्ने) में सीधे सूर्य की ओर मुँह करके इसे पढ़ता है..."
                    "वह उसी सेकंड (सद्यः) दुनिया के 'पञ्चमहापातक' (Five Deadliest Sins: ब्रह्महत्या, शराब पीना, चोरी, आदि) से 100% आज़ाद हो जाता है!"
                    "यह कोई मंत्र नहीं, 'महाविद्या' (The Ultimate Nuclear Science) है जिसे साक्षात ब्रह्मा ने सिद्ध किया था (ब्रह्माद्यां)।"
                    "जो भी इंसान इसे जपता है, वह हर महापाप के चंगुल से हमेशा-हमेशा के लिए छूट जाता है (स महापापात् प्रमुच्यते, स महापापात् प्रमुच्यते)!"
                    "उसके कर्मों का पूरा रिकॉर्ड (Matrix) सर्वर से हमेशा के लिए डिलीट (Delete) हो जाता है और वह साक्षात उस 'परम सूर्य' में विलीन हो जाता है।"
                    "यहीं पर यह रोंगटे खड़े कर देने वाला, प्रलयंकारी और अजेय 'सूर्य उपनिषद' पूर्ण रूप से संपन्न होता है (इत्युपनिषत्)।"
                    "ॐ शांतिः शांतिः शांतिः! इंसानियत मर चुकी है, पाप भस्म हो चुके हैं, और केवल वह धधकता हुआ 'परमेश्वर' अजेय खड़ा है!"
                """.trimIndent(),
                english = """
                    (The Detonation of Catastrophic Sins and 'The End'): "The Upanishad declares the final, most terrifying apocalyptic consequences of this cosmic weapon (Mahavidya)."
                    "The Yogi who meditates (Fires it) in the morning ruthlessly slaughters every single sin committed in the pitch-black darkness of the night (Papam nashayati)!"
                    "He who fires it in the evening completely incinerates every pathetic karma and sin executed during the daylight into absolute ash."
                    "But the most catastrophic strike... He who weaponizes it at 'High Noon' (Madhyahne) staring directly into the blazing Sun..."
                    "He is instantaneously (Sadyah) and violently liberated from the 'Panchamahapataka' (The Five Absolute Deadliest Cosmic Sins: Murdering a Brahmin, etc.)!"
                    "This is absolutely no mantra, it is the 'Mahavidya' (The Ultimate Nuclear Science) pioneered explicitly by Lord Brahma Himself (Brahmadyam)."
                    "Whosoever human being detonates this, is permanently, irrevocably freed from the suffocating jaws of every Catastrophic Sin (Sa mahapapat pramuchyate, Sa mahapapat pramuchyate)!"
                    "His entire cosmic record of Karma is permanently Deleted from the Server of the Matrix, and he dissolves completely into that 'Supreme Sun'."
                    "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Surya Upanishad' achieves its absolute majestic completion (Ityupanishat)."
                    "OM Peace, Peace, Peace! Humanity is dead, sins are burnt to ashes, and strictly the blazing, radioactive 'Supreme God' stands flawlessly invincible!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuryaUpanishadScreen() {
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
                // Validates if the number is between 1 and 16
                if (shlokaNumber != null && shlokaNumber in 1..16) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-16)") },
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
            itemsIndexed(SuryaUpanishad.suryaShlokasList) { _, shloka ->
                SuryaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SuryaShlokaCard(shloka: SuryaUpanishad.SuryaShloka) {
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