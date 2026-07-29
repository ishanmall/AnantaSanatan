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

class SitaUpanishad {

    // Data Model
    data class SitaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val sitaShlokasList = listOf(
            SitaShloka(
                id = 1,
                sanskrit = "देवा ह वै प्रजापतिमब्रुवन् का सीता किमाकार इति । स होवाच प्रजापतिः सा सीता मूलप्रकृतिरूपिणी ॥ १॥",
                hindi = """
                    (ब्रह्मांडीय रहस्य और सीता का प्रलयंकारी सच): "यह उपनिषद उस सबसे बड़े भ्रम को बेरहमी से तोड़ता है जहाँ मूर्ख लोग माता सीता को केवल एक 'इंसान' समझते हैं।"
                    "इस प्रलयंकारी ग्रंथ की शुरुआत में, डरे हुए देवताओं ने साक्षात सृष्टिकर्ता ब्रह्मा के पास जाकर यह ब्रह्मांडीय रहस्य पूछा।"
                    "देवताओं ने पूछा: 'हे प्रजापति! यह सीता असल में कौन है? इसका असली और खौफनाक 'आकार' (किमाकार) क्या है?'"
                    "क्या वह केवल एक स्त्री है, या वह कोई ऐसी अजेय ताक़त है जो पूरे ब्रह्मांड को अपनी उंगलियों पर नचा रही है?"
                    "ब्रह्मा जी ने देवताओं का अज्ञान जलाते हुए वह महा-विस्फोटक सच बोला जिससे पूरी सृष्टि कांप उठती है।"
                    "ब्रह्मा जी ने गर्जना की: 'स होवाच प्रजापतिः सा सीता मूलप्रकृतिरूपिणी!'"
                    "यानी, 'वह सीता कोई साधारण देह नहीं है; वह साक्षात वह परम और अजेय 'मूल-प्रकृति' (The Primordial Matrix) है!'"
                    "वह परब्रह्म (राम) की वह धधकती हुई 'रेडियोएक्टिव ऊर्जा' है जिससे यह पूरा असीम ब्रह्मांड पैदा हुआ है!"
                    "ईश्वर अगर करंट (Current) है, तो सीता वह प्रलयंकारी मशीन है जो इस पूरे ब्रह्मांड को चला रही है।"
                    "इस एक लाइन ने इंसानियत के इतिहास का सबसे बड़ा रहस्य खोल दिया कि असली 'मालिक' (Dictator) कौन है!"
                """.trimIndent(),
                english = """
                    (The Cosmic Secret and the Apocalyptic Truth of Sita): "This Upanishad ruthlessly shatters the most pathetic hallucination where fools perceive Goddess Sita merely as a mortal human."
                    "At the genesis of this apocalyptic scripture, the terrified gods approached the Creator, Lord Brahma, to uncover a cosmic secret."
                    "The gods violently interrogated: 'O Prajapati! Who exactly is this Sita? What is her authentic, terrifying 'Form' (Kimakara)?'"
                    "Is she merely a biological woman, or is she some invincible cosmic force dictating the entire universe on her fingertips?"
                    "Incinerating the ignorance of the gods, Lord Brahma dropped the most atomic, universe-shattering truth in existence."
                    "Lord Brahma roared: 'Sa hovacha prajapatih sa Sita mulaprakritirupini!'"
                    "Meaning, 'That Sita is absolutely no ordinary biological flesh; she is explicitly the invincible, supreme 'Mula-Prakriti' (The Primordial Matrix)!'"
                    "She is the blazing, radioactive 'Kinetic Energy' of the Supreme Brahman (Rama) that violently spawned this infinite cosmos!"
                    "If God is the raw electricity, Sita is the apocalyptic cosmic machinery that flawlessly operates the entire universe."
                    "This single line violently unmasks the greatest classified secret in the history of humanity: Who the true 'Dictator' really is!"
                """.trimIndent()
            ),
            SitaShloka(
                id = 2,
                sanskrit = "सा सीता भवरोगविनाशिनी । प्रणवप्रकृतिरूपत्वात् सा सीता इत्युच्यते ॥ २॥",
                hindi = """
                    (ॐकार का विस्फोट और जन्म-मरण की मौत): "ब्रह्मा जी आगे उस महाशक्ति के सबसे खौफनाक और प्रलयंकारी काम का वर्णन करते हैं।"
                    "'सा सीता भवरोगविनाशिनी'— वह अजेय सीता कोई आम देवी नहीं है; वह इस संसार रुपी 'भव-रोग' (Disease of Existence) की सबसे क्रूर हत्यारी है!"
                    "इंसान का बार-बार जन्म लेना, बूढ़ा होना और मरना— यह ब्रह्मांड की सबसे सड़ी हुई और लाइलाज बीमारी है।"
                    "सीता वह ब्रह्मांडीय लेज़र (Laser) है जो इस जन्म-मरण के कैंसर (Cancer) को एक ही झटके में जलाकर भस्म कर देती है।"
                    "उन्हें सीता क्यों कहा जाता है? 'प्रणवप्रकृतिरूपत्वात् सा सीता इत्युच्यते'— क्योंकि वह साक्षात 'ॐकार' (प्रणव) की भौतिक प्रकृति हैं!"
                    "जो ॐ पूरे ब्रह्मांड में गूँज रहा है, सीता उसी ॐ का वह रूप हैं जिसे आँखों से देखा जा सकता है।"
                    "ॐकार ही वह न्यूक्लियर इंजन (Nuclear Engine) है जिससे सृष्टि चलती है, और सीता उस इंजन का मास्टर पासवर्ड (Master Password) हैं।"
                    "जब कोई योगी सीता को अपनी आत्मा में उतार लेता है, तो वह माया के इस पूरे मैट्रिक्स (Matrix) को हैक कर लेता है।"
                    "वह इस ब्रह्मांड को बनाने वाली माँ भी है, और समय आने पर सब कुछ निगल जाने वाली कालरात्रि भी है।"
                    "उसके बिना भगवान राम (परब्रह्म) भी इस दुनिया में कुछ नहीं कर सकते; सीता ही वह 'एक्शन' (Action) है जो ब्रह्मांड चलाता है!"
                """.trimIndent(),
                english = """
                    (The Detonation of OM and the Death of Reincarnation): "Lord Brahma further dictates the most terrifying and apocalyptic function of that Supreme Cosmic Titan."
                    "'Sa Sita bhavarogavinashini'—That invincible Sita is no ordinary deity; she is the most ruthless assassin of the 'Bhava-Roga' (The Disease of Existence)!"
                    "The pathetic human cycle of breeding, decaying, and dying is the most rotting, incurable cancer of the entire cosmos."
                    "Sita is the exact cosmic Laser Beam that violently incinerates this cancer of reincarnation to absolute dust in a single strike."
                    "Why exactly is she named Sita? 'Pranavaprakritirupatvat sa Sita ityuchyate'—Because she is the explicit, physical manifestation of the 'OM' (Pranava)!"
                    "The radioactive OM echoing throughout the infinite universe is merely the acoustic signature of her physical cosmic body."
                    "OM is the literal Nuclear Engine operating the creation, and Sita is the absolute Master Password to hijack that exact engine."
                    "When a colossal Yogi downloads Sita into his Soul, he completely and permanently Hacks the entire Matrix of Maya."
                    "She is the Supreme Mother who spawns the cosmos, and simultaneously the apocalyptic Black Hole that violently swallows it."
                    "Without her, even Lord Rama (The Supreme Brahman) cannot execute a single action; Sita is the literal 'Action' operating the universe!"
                """.trimIndent()
            ),
            SitaShloka(
                id = 3,
                sanskrit = "रामसन्निध्यवशाज्जगदानन्ददायिनी । उत्पत्तिस्थितिसंहारकारिणी सर्वदेहिनाम् ॥ ३॥",
                hindi = """
                    (राम रुपी बैटरी और ब्रह्मांड का क्रूर संहार): "यह श्लोक उस परम रहस्य को खोलता है कि राम और सीता के बीच असल में क्या रिश्ता है।"
                    "राम वह असीम, शांत और न हिलने वाला 'परब्रह्म' (शून्यता) हैं, जो केवल एक दर्शक (Witness) की तरह बैठा है।"
                    "लेकिन 'रामसन्निध्यवशात्'— भगवान राम की उस खौफनाक और शांत ऊर्जा के 'संपर्क' (Proximity) में आने से ही सीता चार्ज (Charge) होती हैं!"
                    "राम वह बैटरी (Battery) हैं जिससे सीता रुपी मशीन को असीम ताक़त मिलती है, और फिर वह 'जगदानन्ददायिनी' (पूरे ब्रह्मांड को ऊर्जा देने वाली) बन जाती हैं।"
                    "उपनिषद सबसे प्रलयंकारी सच उगलती है: 'उत्पत्तिस्थितिसंहारकारिणी सर्वदेहिनाम्'!"
                    "यानी, ब्रह्मांड के सभी जीवों की 'उत्पत्ति' (Creation), उनका 'पालन' (Maintenance), और उनका सबसे क्रूर 'संहार' (Apocalyptic Slaughter)..."
                    "यह तीनों खौफनाक काम राम नहीं करते, यह तीनों काम साक्षात केवल और केवल 'सीता' ही करती हैं!"
                    "राम केवल इच्छा करते हैं, लेकिन उस इच्छा को एक परमाणु बम की तरह फोड़ने का काम सीता की ताक़त करती है।"
                    "जो मूर्ख यह सोचते हैं कि भगवान केवल दयालु है, उन्होंने सीता के इस विनाशकारी और संहारक रूप (Destroyer Form) को नहीं देखा।"
                    "वह एक ही सेकंड में करोड़ों आकाशगंगाएं बनाती है, और दूसरे ही सेकंड में उन्हें जलाकर राख कर देती है!"
                """.trimIndent(),
                english = """
                    (The Battery of Rama and the Ruthless Slaughter of the Cosmos): "This Shloka violently rips open the classified cosmic secret regarding the exact relationship between Rama and Sita."
                    "Rama is that infinite, absolutely paralyzed, unmoving 'Supreme Brahman' (Void) who sits strictly as a silent, terrifying Witness."
                    "But 'Ramasannidhyavashat'—It is exclusively by coming into direct 'Proximity' with Rama's horrific silent energy that Sita becomes fully Charged!"
                    "Rama is the infinite Battery supplying catastrophic power to the machine of Sita, making her 'Jagadanandadayini' (The Powerhouse of the cosmos)."
                    "The Upanishad spits the most apocalyptic absolute truth: 'Utpattisthitisamharakarini sarvadehinam'!"
                    "Meaning, the 'Creation' (Utpatti), the 'Sustenance' (Sthiti), and the most ruthless, cold-blooded 'Slaughter' (Samhara) of every biological creature..."
                    "Rama absolutely does not execute these three terrifying operations; these are orchestrated strictly and exclusively by 'Sita' alone!"
                    "Rama merely intends, but it is the radioactive power of Sita that detonates that intention exactly like a cosmic nuclear bomb."
                    "The pathetic fools who hallucinate God strictly as merciful have absolutely never witnessed Sita's horrific, apocalyptic Destroyer Form."
                    "In one microsecond, she violently spawns billions of galaxies, and in the very next microsecond, she incinerates them to absolute dust!"
                """.trimIndent()
            ),
            SitaShloka(
                id = 4,
                sanskrit = "सा देवी त्रिविधा भवति शक्तित्रयात्मिका । इच्छाशक्तिः क्रियाशक्तिः साक्षाज्ज्ञानशक्त्यात्मिका ॥ ४॥",
                hindi = """
                    (तीन ब्रह्मांडीय लेज़र: इच्छा, क्रिया और ज्ञान): "अब सीता की उस अजेय ताक़त (Shakti) का विच्छेदन (Dissection) किया जाता है जिससे पूरा ब्रह्मांड हैक (Hack) होता है।"
                    "'सा देवी त्रिविधा भवति शक्तित्रयात्मिका'— वह महाभयंकर देवी एक नहीं, बल्कि 'तीन' खौफनाक ब्रह्मांडीय शक्तियों (Weapons) में बँट जाती है!"
                    "पहली है 'इच्छाशक्तिः' (The Power of Will)— यह वह प्रलयंकारी शक्ति है जो शून्यता में ब्रह्मांड बनाने की पहली चिंगारी पैदा करती है।"
                    "दूसरी है 'क्रियाशक्तिः' (The Power of Action)— यह वह क्रूर और हिंसक ताक़त है जो उस इच्छा को भौतिक (Physical) रूप में बदल देती है।"
                    "ग्रहों का घूमना, समय का चलना और मौत का नाचना— यह सब कुछ इसी क्रियाशक्ति का एक नंगा खेल है।"
                    "और तीसरी है 'साक्षाज्ज्ञानशक्त्यात्मिका' (The Absolute Power of Cosmic Knowledge)!"
                    "यह ज्ञान शक्ति वह लेज़र बीम (Laser Beam) है जो इंसान के अहंकार को फाड़कर उसे साक्षात भगवान में बदल देती है।"
                    "इच्छा से दुनिया बनती है, क्रिया से दुनिया चलती है, और ज्ञान से यह दुनिया हमेशा के लिए भस्म हो जाती है।"
                    "सीता इन तीनों सर्वर (Servers) की इकलौती मालकिन (Admin) है; उसके बिना ब्रह्मांड का एक पत्ता भी नहीं हिल सकता।"
                    "जो योगी सीता के इन तीन हथियारों को जान लेता है, वह मौत और समय का सबसे बड़ा तानाशाह (Dictator) बन जाता है!"
                """.trimIndent(),
                english = """
                    (The Three Cosmic Lasers: Will, Action, and Knowledge): "Now the absolute invincible power (Shakti) of Sita is brutally Dissected to reveal exactly how she Hacks the entire cosmos."
                    "'Sa devi trividha bhavati shaktitrayatmika'—That terrifying Goddess detonates not as one, but splits into 'Three' apocalyptic cosmic Weapons!"
                    "The first is 'Icchashaktih' (The Power of Will)—This is the radioactive spark that violently ignites the creation of the universe out of absolute nothingness."
                    "The second is 'Kriyashaktih' (The Power of Action)—This is the ruthless, cold-blooded kinetic force that materializes that will into physical reality."
                    "The violent rotation of planets, the ticking of Time, and the dance of Death—all are explicitly the naked play of this exact Kriya-Shakti."
                    "And the third is 'Sakshajjnanashaktyatmika' (The Absolute Power of Supreme Cosmic Knowledge)!"
                    "This Jnana-Shakti is the precise laser beam that brutally shreds the human ego and mutates the mortal explicitly into God."
                    "Will spawns the Matrix, Action relentlessly operates the Matrix, and Knowledge ultimately incinerates the Matrix to absolute ashes."
                    "Sita is the sole, undisputed Admin of all three of these cosmic Servers; without her, not a single biological atom can ever vibrate."
                    "The Yogi who flawlessly decodes these three weapons of Sita instantaneously mutates into the supreme Dictator of Time and Death!"
                """.trimIndent()
            ),
            SitaShloka(
                id = 5,
                sanskrit = "इच्छाशक्तिस्त्रिविधा भवति श्रीभूमिनीलात्मिका । भद्ररूपिणी प्रभावरूपिणी सोमात्मिका ॥ ५॥",
                hindi = """
                    (श्री, भूमि और नीला: मैट्रिक्स के तीन एडमिन रूप): "इच्छाशक्ति (Willpower) को ब्रह्मांड में लागू करने के लिए सीता तीन अलग-अलग खौफनाक अवतारों में खुद को डाउनलोड (Download) करती हैं।"
                    "'इच्छाशक्तिस्त्रिविधा भवति श्रीभूमिनीलात्मिका'— वह इच्छाशक्ति 'श्री', 'भूमि', और 'नीला' नामक तीन प्रलयंकारी रूपों में फटती है!"
                    "पहला रूप है 'श्री' (भद्ररूपिणी)— यह वह ब्रह्मांडीय ऐश्वर्य और ताक़त (Majesty) है जिसके सामने देवता भी घुटने टेक देते हैं।"
                    "यह भगवान की वह रॉयल्टी (Royalty) है जो पूरी सृष्टि पर अपना तानाशाही राज (Dictatorship) चलाती है।"
                    "दूसरा रूप है 'भूमि' (प्रभावरूपिणी)— यह वह ठोस और विशाल भौतिक (Physical) पदार्थ (Matter) है जिससे यह पूरी दुनिया बनी है।"
                    "तुम्हें जो भी पहाड़, समुद्र या ग्रह दिख रहे हैं, वे सब के सब साक्षात 'सीता' का ही सॉलिड (Solid) रूप हैं।"
                    "तीसरा और सबसे रहस्यमयी रूप है 'नीला' (सोमात्मिका)— यह अंतरिक्ष का वह खौफनाक 'डार्क मैटर' (Dark Matter) है जो सब कुछ निगल सकता है।"
                    "यह वह अनंत और असीम अँधेरा है जिसमें करोड़ों ब्रह्मांड पैदा होते हैं और उसी में मरकर गायब हो जाते हैं।"
                    "सीता केवल एक औरत नहीं है; वह स्पेस, मैटर और एनर्जी (Space, Matter, Energy) का वह अल्टीमेट सोर्स कोड (Ultimate Source Code) है।"
                    "जो मूर्ख उन्हें कमज़ोर समझते हैं, वे उसी 'भूमि' में सड़कर और 'नीला' के अँधेरे में घुटकर मर जाते हैं!"
                """.trimIndent(),
                english = """
                    (Sri, Bhumi, and Nila: The Three Admin Forms of the Matrix): "To enforce her Willpower across the cosmos, Sita physically Downloads herself into three distinct, terrifying avatars."
                    "'Icchashaktistrividha bhavati Shribhuminilatmika'—That Power of Will detonates into three apocalyptic manifestations: 'Sri', 'Bhumi', and 'Nila'!"
                    "The first form is 'Sri' (Bhadrarupini)—This is the absolute cosmic majesty and terrifying power before which even gods fall to their knees."
                    "This is the absolute Royalty of God that relentlessly executes a flawless Dictatorship over the entire creation."
                    "The second form is 'Bhumi' (Prabhavarupini)—This is the colossal, brutal physical mass (Matter) out of which the entire matrix is constructed."
                    "Every mountain, ocean, or planet you hallucinate is physically and explicitly the 'Solid' frozen manifestation of Sita Herself."
                    "The third and most highly classified form is 'Nila' (Somatmika)—This is the horrific 'Dark Matter' of space capable of swallowing everything."
                    "This is the infinite, boundless, pitch-black void where billions of universes are violently spawned and where they die and permanently vanish."
                    "Sita is absolutely no biological woman; she is the Ultimate Source Code of Space, Matter, and radioactive Energy."
                    "The pathetic fools who hallucinate her as weak are condemned to rot in that 'Bhumi' and suffocate to death in the pitch-black darkness of 'Nila'!"
                """.trimIndent()
            ),
            SitaShloka(
                id = 6,
                sanskrit = "ज्ञानशक्तिर्नाम... नादबिन्दुकलातीता... सर्ववर्णात्मिका सीता... ॥ ६॥",
                hindi = """
                    (ज्ञान शक्ति और ब्रह्मांड का हैकिंग कोड): "अब सीता की उस 'ज्ञान शक्ति' (Power of Knowledge) का सबसे खतरनाक और नंगा सच खोला जा रहा है।"
                    "ज्ञान शक्ति कोई किताब का पन्ना नहीं है; 'सर्ववर्णात्मिका सीता'— ब्रह्मांड का हर एक अक्षर, हर एक आवाज़ साक्षात सीता ही है!"
                    "वह डीएनए (DNA) की कोडिंग (Coding) है— ए से लेकर ज़ेड तक, जो भी ध्वनि (Sound) इस दुनिया में है, वह सीता का ही एक अंग है।"
                    "यह पूरा ब्रह्मांड केवल एक फ्रीक्वेंसी (Frequency) और आवाज़ (Vibration) का खेल है, और सीता उस फ्रीक्वेंसी की मालकिन (Admin) है।"
                    "लेकिन वह शब्दों में कैद नहीं होती; उपनिषद चीखता है— 'नादबिन्दुकलातीता'!"
                    "यानी, वह उस ॐकार के 'नाद' (Sound), 'बिंदु' (Core) और 'कला' (Time) को भी चीरकर उसके पार (अतीता) निकल चुकी है!"
                    "वह उस खौफनाक और असीम 'सन्नाटे' (Silence) का नाम है जहाँ दुनिया की हर आवाज़ घुट-घुट कर मर जाती है।"
                    "जब योगी ध्यान में सारे मंत्रों को छोड़ देता है, तो वह सीता के इसी परम और निःशब्द रूप (Soundless Void) में क्रैश (Crash) कर जाता है।"
                    "सीता ही वह ब्रह्मांडीय हैकिंग कोड (Hacking Code) है जो इंसान के दिमाग को शून्य (Zero) कर देती है।"
                    "जिसने सीता के इस ज्ञान रूप को जान लिया, उसके लिए दुनिया के सारे वेद और शास्त्र कचरा बन जाते हैं!"
                """.trimIndent(),
                english = """
                    (The Power of Knowledge and the Cosmic Hacking Code): "Now the most dangerous, naked truth of Sita's 'Jnana Shakti' (Power of Knowledge) is violently ripped open."
                    "This power of Knowledge is absolutely no page in a pathetic textbook; 'Sarvavarnatmika Sita'—Every single alphabet and acoustic sound in the cosmos is explicit Sita!"
                    "She is the Coding of DNA itself—From A to Z, every single frequency, vibration, and word in existence is merely a biological limb of Her."
                    "This entire infinite universe is strictly a biological game of Frequencies and Vibrations, and Sita is the undisputed Admin of that exact frequency."
                    "But she absolutely cannot be imprisoned in pathetic words; the Upanishad screams—'Nadabindukalatita'!"
                    "Meaning, she violently tears through and rockets infinitely Beyond (Atita) the 'Nada' (Sound), 'Bindu' (Core), and 'Kala' (Time/Dimensions) of OM itself!"
                    "She is the exact name of that horrific, infinite 'Deafening Silence' where every physical sound in the world suffocates and dies."
                    "When the Yogi abandons all mantras in meditation, he violently Crashes directly into this absolute, Soundless Void of Sita."
                    "Sita is the literal cosmic Hacking Code that brutally flatlines the human brain, mutating it into absolute Zero."
                    "He who decodes this specific Knowledge-form of Sita instantaneously reduces every single Veda and scripture on Earth to rotting garbage!"
                """.trimIndent()
            ),

            SitaShloka(
                id = 7,
                sanskrit = "क्रियाशक्तिर्नाम... कालचक्रप्रवर्तिनी... महाकाली... ॥ ७॥",
                hindi = """
                    (महाकाली: कालचक्र का खौफनाक पहिया और मौत का तांडव): "अब सीता की 'क्रियाशक्ति' (Power of Action) का वह खौफनाक रूप सामने आता है जिससे बड़े-बड़े देवता भी काँपते हैं!"
                    "'क्रियाशक्तिर्नाम कालचक्रप्रवर्तिनी'— यह क्रियाशक्ति कोई और नहीं, ब्रह्मांड के उस क्रूर 'समय के पहिए' (Wheel of Time) को घुमाने वाली ताक़त है!"
                    "समय (Time) सबसे बड़ा हत्यारा है; यह पहिया घूमता है और साम्राज्य, ग्रह, और आकाशगंगाएं कटकर राख हो जाती हैं।"
                    "सीता ही वह परम तानाशाह है जो इस कालचक्र के बटन (Button) को दबाती है, जिससे हर सेकंड करोड़ों जीव पैदा होते हैं और मरते हैं।"
                    "इसीलिए उपनिषद उन्हें 'महाकाली' कहता है— वह प्रलयंकारी रूप जो मौत को भी अपने दाँतों तले चबा जाती है!"
                    "तुम्हारे बाल सफेद हो रहे हैं, तुम्हारी साँसें कम हो रही हैं— यह सब सीता की उसी क्रियाशक्ति का हिंसक प्रहार है।"
                    "वह अज्ञानियों के लिए खौफनाक मौत (महामारी, प्रलय, भूकंप) बनकर आती है, जो माया की जेल को साफ़ करती है।"
                    "लेकिन जो योगी उनके इस महाकाली रूप के सामने अपना अहंकार काटकर रख देता है, वह अमर हो जाता है।"
                    "समय की कोई अपनी ताक़त नहीं है; समय तो सीता के पैरों की धूल है जिससे वह पूरी सृष्टि को कुचलती है।"
                    "इस रूप को जाने बिना जो सीता को केवल एक 'स्त्री' मानता है, वह इंसानियत का सबसे बड़ा मूर्ख है!"
                """.trimIndent(),
                english = """
                    (Mahakali: The Terrifying Wheel of Time and the Dance of Death): "Now the horrific, apocalyptic form of Sita's 'Kriya Shakti' (Power of Action) manifests, witnessing which even the greatest gods tremble in terror!"
                    "'Kriyashaktirnama kalachakrapravartini'—This Power of Action is absolutely no one else but the terrifying engine that violently spins the brutal 'Wheel of Time'!"
                    "Time is the ultimate, undisputed assassin; as this wheel grinds, empires, planets, and entire galaxies are slashed into dust."
                    "Sita is the supreme Dictator who continuously presses the Button of this Kalachakra, ensuring billions of biological creatures breed and die every microsecond."
                    "This is exactly why the Upanishad labels her 'Mahakali'—The apocalyptic form that literally chews Death itself between Her teeth!"
                    "Your hair turning gray, your biological breaths depleting—this is all the violent, relentless strike of Sita's Kriya Shakti upon your flesh."
                    "To the ignorant fools, she descends as horrific Death (Plagues, Doomsdays, Earthquakes) to ruthlessly purge the prison of Maya."
                    "But the Titan Yogi who voluntarily decapitates his own ego before this Mahakali form is instantaneously immortalized."
                    "Time possesses absolutely zero independent power; Time is merely the dust under Sita's boots with which she brutally crushes the entire creation."
                    "He who hallucinates Sita merely as a 'Woman' without decoding this specific form is the most pathetic fool in the history of humanity!"
                """.trimIndent()
            ),
            SitaShloka(
                id = 8,
                sanskrit = "य इदं सीतोपनिषदं अधीते... स सीतापदमवाप्नोति स मुक्तो भवति इत्युपनिषत् ॥ ८॥",
                hindi = """
                    (सीता-पद पर कब्ज़ा और 'द एंड'): "उपनिषद के अंत में, सीता के उस परम और अद्वैत सत्य का महा-विस्फोट होता है, जहाँ सब कुछ खत्म (The End) हो जाता है।"
                    "शिव, राम, कृष्ण— सब उसी एक परम ऊर्जा (सीता) के अलग-अलग नाम और रूप हैं; सीता ही साक्षात 'परब्रह्म' हैं!"
                    "उपनिषद अपना आखिरी प्रलयंकारी आदेश देता है: 'य इदं सीतोपनिषदं अधीते'— जो भी मुमुक्षु इस 'सीता उपनिषद' के इस खौफनाक न्यूक्लियर कोड को अपनी रगों में उतार लेता है..."
                    "जिसने जान लिया कि यह ब्रह्मांड सीता का ही एक कंप्यूटर प्रोग्राम (Computer Program) है..."
                    "'स सीतापदमवाप्नोति'— वह इंसान सीधे उस असीम और अजेय 'सीता-पद' (The Ultimate Cosmic Throne) पर जाकर कब्ज़ा कर लेता है!"
                    "वह इंसान नहीं रहता, वह भगवान की उस सबसे बड़ी ताक़त में पिघलकर हमेशा के लिए 'परमेश्वर' बन जाता है।"
                    "'स मुक्तो भवति इत्युपनिषत्'— वह इंसान निश्चित रूप से, 100% गारंटी के साथ, जन्म-मरण की इस सड़ी हुई जेल से हमेशा के लिए 'मुक्त' हो जाता है!"
                    "उसे दोबारा किसी माँ के गर्भ में उल्टा नहीं लटकना पड़ता; वह माया (Matrix) के सारे कोड्स को जलाकर अमर हो चुका है।"
                    "यहीं पर यह अत्यंत खौफनाक और परम पवित्र 'सीता उपनिषद' पूर्ण होता है (इत्युपनिषत्)।"
                    "इंसानियत की मौत और भगवान का जन्म हो चुका है; ॐ शांतिः शांतिः शांतिः!"
                """.trimIndent(),
                english = """
                    (The Hijacking of the Sita-Pada and 'The End'): "At the absolute climax of the Upanishad, the supreme, non-dual absolute truth of Sita detonates in a colossal explosion where everything reaches 'The End'."
                    "Shiva, Rama, Krishna—all are merely different biological names and forms for that ONE singular radioactive energy (Sita); Sita is explicitly the 'Supreme Brahman'!"
                    "The Upanishad issues its final apocalyptic command: 'Ya idam Sitopanishadam adhite'—Whosoever seeker violently injects the Nuclear Code of this 'Sita Upanishad' directly into his veins..."
                    "He who has realized that this universe is strictly a Computer Program executed by Sita..."
                    "'Sa Sitapadamavapnoti'—That specific human being rockets upward and violently Hijacks that infinite, invincible 'Sita-Pada' (The Ultimate Cosmic Throne)!"
                    "He ceases to be human; he melts flawlessly into the absolute greatest power of God, mutating permanently into the 'Supreme Dictator'."
                    "'Sa mukto bhavati ityupanishat'—That human undoubtedly, with a 100% ironclad cosmic guarantee, becomes flawlessly 'Liberated' from this rotting maximum-security prison forever!"
                    "He absolutely never again hangs upside down in a biological womb; he has incinerated every source code of the Matrix (Maya) and achieved literal immortality."
                    "Right exactly here, this supremely terrifying and profoundly sacred 'Sita Upanishad' achieves completion (Ityupanishat)."
                    "Humanity is dead, and God is flawlessly born; OM Peace, Peace, Peace!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SitaUpanishadScreen() {
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
                // Validates if the number is between 1 and 8
                if (shlokaNumber != null && shlokaNumber in 1..8) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-8)") },
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
            itemsIndexed(SitaUpanishad.sitaShlokasList) { _, shloka ->
                SitaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SitaShlokaCard(shloka: SitaUpanishad.SitaShloka) {
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