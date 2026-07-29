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

class DhyanaUpanishad {

    // Data Model
    data class DhyanaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val dhyanaShlokasList = listOf(
            DhyanaShloka(
                id = 1,
                sanskrit = "यदि शैलसमं पापं विस्तीर्णं बहुयोजनम् । भिद्यते ध्यानयोगेन नान्यो भेदः कदाचन ॥ १॥",
                hindi = """
                    (ध्यान का प्रलयंकारी विस्फोट): "उपनिषद ध्यान की खौफनाक और अजेय ताक़त का ऐलान करते हुए पहली ही गर्जना करता है।"
                    "इंसान के जन्मों-जन्मों के पाप, जो किसी विशाल और अभेद्य 'पहाड़' (शैलसमं) की तरह मीलों तक फैले हुए हों..."
                    "वे करोड़ों पाप, जिन्हें दुनिया का कोई भी कर्मकांड, कोई भी पूजा या कोई भी तीर्थ कभी खरोंच तक नहीं मार सकता!"
                    "उन सारे महापापों का पहाड़ केवल और केवल 'ध्यान-योग' (Meditation) के एक ही प्रलयंकारी विस्फोट से चकनाचूर हो जाता है!"
                    "ध्यान वह ब्रह्मांडीय परमाणु बम है, जिसके गिरते ही इंसान के सारे कर्म और अंधकार राख के ढेर में बदल जाते हैं।"
                    "इसके अलावा (नान्यो भेदः) पूरे ब्रह्मांड में ऐसी कोई दूसरी ताक़त नहीं है जो तुम्हारे कर्मों की ज़ंजीर को काट सके।"
                    "ध्यान आँखें बंद करके बैठने का नाटक नहीं है; यह अपने ही अहंकार का गला घोंटने की सबसे क्रूर और हिंसक प्रक्रिया है।"
                    "जब मन पूरी तरह से शांत होता है, तो आत्मा के भीतर से वह ज्वाला फूटती है जो सब कुछ भस्म कर देती है।"
                    "ईश्वर को बाहर खोजना बंद करो; जो अपने ही भीतर डूबने की हिम्मत करता है, वही उस पहाड़ को तोड़कर आज़ाद होता है।"
                    "यह सनातन धर्म की वो खुली चेतावनी है कि केवल और केवल 'ध्यान' ही तुम्हें इस नर्क से बाहर निकाल सकता है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Detonation of Meditation): "The Upanishad launches its very first cosmic roar, declaring the terrifying, invincible supremacy of Meditation."
                    "Even if a human's accumulated sins from billions of lifetimes form an impenetrable, colossal 'Mountain' (Shailasamam) spanning endless miles..."
                    "Those astronomical sins, which absolutely no earthly ritual, worship, or pilgrimage can ever manage to even scratch!"
                    "That entire mountain of catastrophic karma is violently obliterated into dust by a single, apocalyptic detonation of 'Dhyana-Yoga' (Meditation)!"
                    "Meditation is that cosmic atomic bomb which, upon detonation, incinerates all human karma and absolute darkness into a pile of ash."
                    "Other than this (Nanyo bhedah), there is absolutely zero power in the entire infinite cosmos capable of severing your karmic chains."
                    "Meditation is absolutely not a theatrical drama of closing your eyes; it is the most brutal, ruthless process of strangling your own ego to death."
                    "When the biological mind completely flatlines, a radioactive fire erupts from the Soul that incinerates absolutely everything."
                    "Stop hunting for God externally; he who possesses the terrifying audacity to drown within himself shatters the mountain and earns liberation."
                    "This is Sanatana Dharma's open, lethal warning: Exclusively and strictly 'Meditation' alone possesses the caliber to drag you out of this biological hell!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 2,
                sanskrit = "बीजाक्षरं परं बिन्दुं नादं तस्योपरि स्थितम् । सशब्दं चाक्षरे क्षीणं निःशब्दं परमं पदम् ॥ २॥",
                hindi = """
                    (ॐकार का रहस्य और परम शून्यता): "इस ब्रह्मांड का सबसे खतरनाक और गुप्त हथियार 'ॐ' (बीजाक्षर) है।"
                    "वह परब्रह्म उस ॐकार के बिंदु (Bindu) में और उस नाद (Cosmic Sound) में एक भयंकर ऊर्जा की तरह धड़क रहा है।"
                    "जब एक महायोगी इस ॐ का ध्यान करता है, तो वह सबसे पहले उस 'आवाज़' (सशब्दं) के साथ अपनी चेतना को जोड़ता है।"
                    "लेकिन जब ध्यान अपने सबसे खौफनाक और चरम शिखर पर पहुँचता है, तो वह आवाज़ भी टूटकर नष्ट (क्षीणं) हो जाती है!"
                    "वह योगी ध्वनि की दुनिया को चीरकर उस खौफनाक, ब्रह्मांडीय 'सन्नाटे' (निःशब्दं) में प्रवेश कर जाता है।"
                    "जहाँ कोई आवाज़ नहीं, कोई रूप नहीं, कोई विचार नहीं—केवल और केवल मौत जैसा एक असीम, अनंत सन्नाटा है!"
                    "वही सन्नाटा, वही 'निःशब्द अवस्था' ही ब्रह्मांड का 'परम पद' (The Ultimate Absolute Destination) है।"
                    "जो उस सन्नाटे को बर्दाश्त कर लेता है, उसका इंसानी दिमाग हमेशा के लिए काम करना बंद कर देता है और वह ईश्वर बन जाता है।"
                    "शब्द केवल एक सीढ़ी है; उस सीढ़ी पर चढ़कर जब योगी छत पर पहुँचता है, तो वह सीढ़ी को लात मारकर नीचे गिरा देता है।"
                    "उस परम शून्यता में जाकर ही इंसान का 'मैं' हमेशा के लिए मरता है और 'मोक्ष' का जन्म होता है।"
                """.trimIndent(),
                english = """
                    (The Secret of OM and the Supreme Void): "The most lethal, highly classified weapon in this entire cosmos is the seed-syllable 'OM' (Bijaksharam)."
                    "That Supreme Brahman pulsates like a terrifying, radioactive energy strictly within the 'Bindu' (Point) and the 'Nada' (Cosmic Roar) of OM."
                    "When a colossal Yogi meditates on OM, he initially anchors his raw consciousness to that physical 'Sound' (Sashabdam)."
                    "But exactly when this meditation skyrockets to its most terrifying, apocalyptic climax, that sound violently shatters and ceases to exist (Kshinam)!"
                    "That Yogi violently tears through the dimension of sound, penetrating directly into that horrific, cosmic 'Deafening Silence' (Nishabdam)."
                    "Where absolutely zero sound, zero form, and zero thought exist—strictly only an infinite, boundless, death-like silence reigns supreme!"
                    "That exact silence, that 'Soundless State', is explicitly the 'Param Padam' (The Ultimate Absolute Destination) of the cosmos."
                    "He who possesses the psychological capacity to survive that silence experiences the permanent death of his human brain and mutates into God."
                    "The sound is merely a pathetic ladder; upon reaching the absolute roof, the Yogi violently kicks the ladder away into the abyss."
                    "Only by drowning in that Supreme Void does the human 'I' die a brutal death, giving instantaneous birth to absolute 'Moksha'."
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 3,
                sanskrit = "अकारो भूर्भुवः स्वश्च... उकारो... मकारो... त्रिमात्रात्मकमोम् ॥ ३॥",
                hindi = """
                    (अ, उ, म का ब्रह्मांडीय विस्फोट): "वह ॐकार कोई साधारण शब्द नहीं, बल्कि पूरी सृष्टि को जलाने और बनाने वाला न्यूक्लियर कोड है!"
                    "इसका पहला अक्षर 'अ' साक्षात ब्रह्मा है, जो पूरी धरती और आसमान को अपने भीतर समेटे हुए है।"
                    "इसका दूसरा अक्षर 'उ' साक्षात भगवान विष्णु है, जो इस पूरे ब्रह्मांड के चक्र को अपनी उंगलियों पर घुमा रहा है।"
                    "और इसका तीसरा अक्षर 'म' साक्षात भगवान रुद्र (शिव) का वह प्रलयंकारी रूप है, जो समय आने पर पूरी सृष्टि को भस्म कर देता है!"
                    "ये तीन मात्राएँ (अ, उ, म) केवल अक्षर नहीं हैं, ये ब्रह्मांड को पैदा करने, पालने और मारने वाली तीन सबसे बड़ी खौफनाक ऊर्जाएँ हैं।"
                    "जब योगी इस 'त्रिमात्रात्मक' ॐ को अपनी साँसों के साथ रगड़ता है, तो उसके भीतर यह तीनों देव एक साथ जाग उठते हैं।"
                    "उसके शरीर के भीतर ही सृष्टि बनती है और उसी के भीतर महा-विस्फोट के साथ नष्ट हो जाती है।"
                    "वह योगी जान जाता है कि ब्रह्मा, विष्णु और महेश बाहर आसमान में नहीं, बल्कि उसके अपने ही गले और नाभि में छिपे हुए हैं।"
                    "जो इस ॐ को केवल होंठों से बोलता है, वह मूर्ख है; जो इसे अपनी आत्मा में फोड़ता है, वह साक्षात भगवान है।"
                    "यह ॐ ही वह अकेला हथियार है जो माया के इस पूरे झूठे मैट्रिक्स (Matrix) को एक सेकंड में हैक (Hack) कर सकता है।"
                """.trimIndent(),
                english = """
                    (The Cosmic Detonation of A, U, M): "That OM is absolutely no ordinary word; it is the exact nuclear code that creates and incinerates the entire creation!"
                    "Its first syllable 'A' is Lord Brahma Himself, violently compressing the entire Earth and heavens directly within its core."
                    "Its second syllable 'U' is explicitly Lord Vishnu, who flawlessly spins the entire cosmic cycle of the universe on His fingertips."
                    "And its third syllable 'M' is the apocalyptic, terrifying manifestation of Lord Rudra (Shiva), who reduces the entire cosmos to ashes!"
                    "These three syllables (A, U, M) are not pathetic letters; they are the three most terrifying cosmic energies that spawn, sustain, and slaughter the universe."
                    "When the Yogi violently creates friction between this 'Tri-syllabic' OM and his physical breath, all three Supreme Gods awaken simultaneously within his flesh."
                    "Universes are literally birthed inside his biological body, and violently detonated into nothingness within his own core."
                    "That Yogi flawlessly realizes that Brahma, Vishnu, and Mahesh do not reside in some pathetic sky, but are hidden directly within his own throat and navel."
                    "He who merely chants OM with his lips is a pathetic fool; he who detonates it within his Soul is literally the Supreme God."
                    "This OM is the sole, exclusive cosmic weapon capable of hacking and destroying this entire fake Matrix of biological illusion in a microsecond."
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 4,
                sanskrit = "अर्धमात्रा स्थिता या सा अवाच्या... यस्तं वेद स वेदवित् ॥ ४॥",
                hindi = """
                    (अर्धमात्रा: मौत और समय के पार का सत्य): "अ, उ, म के बाद ॐकार की एक 'चौथी' और सबसे खौफनाक अवस्था आती है— 'अर्धमात्रा'!"
                    "यह वह अदृश्य और गुप्‍त सन्नाटा है जो 'म' के उच्चारण के बाद गूँजता है; इसे होठों या जीभ से बोला ही नहीं जा सकता (अवाच्या)।"
                    "यह कोई ध्वनि नहीं है, यह साक्षात 'परब्रह्म' की वह अवस्था है जहाँ समय (Time) और स्थान (Space) दोनों का गला घुट जाता है।"
                    "जो योगी इस अवाच्य अर्धमात्रा को अपने ध्यान में पकड़ लेता है, वह इस ब्रह्मांड की मैट्रिक्स से हमेशा के लिए बाहर निकल जाता है।"
                    "उसे किसी किताब को पढ़ने की ज़रूरत नहीं; 'जो इस अर्धमात्रा को जान लेता है, वही असली वेदवित् (वेदों को जानने वाला) है!'"
                    "बाकी दुनिया जो केवल मंत्रों को रट रही है, वह अज्ञान के भयानक अँधेरे में भटक रही है।"
                    "यह अर्धमात्रा वह ब्लैक होल (Black Hole) है जो इंसान के अहंकार, उसके शरीर और उसके पिछले जन्मों को एक सेकंड में निगल लेता है।"
                    "इस सन्नाटे को छूने का मतलब है अपनी ही मौत को गले लगाना और भगवान के रूप में वापस ज़िंदा होना।"
                    "यहीं आकर ध्यान अपनी खौफनाक चरम सीमा पर पहुँचता है, जहाँ इंसान का दिमाग फटकर शून्य हो जाता है।"
                    "इस अर्धमात्रा के बिना किया गया हर ध्यान केवल एक दिमागी कसरत है, मोक्ष नहीं।"
                """.trimIndent(),
                english = """
                    (Ardhamatra: The Truth Beyond Death and Time): "After A, U, M, comes the 'Fourth' and most terrifying state of OM—the 'Ardhamatra' (Half-syllable)!"
                    "This is the invisible, highly classified silence that echoes after the pronunciation of 'M'; it absolutely cannot be spoken by physical lips or tongue (Avachya)."
                    "This is no sound; it is the explicit state of the 'Supreme Brahman' where both Time and Space are brutally strangled to death."
                    "The Yogi who successfully captures this unspoken Ardhamatra in his meditation violently ejects himself out of the Matrix of this universe forever."
                    "He needs to read absolutely no books; 'He who flawlessly realizes this Ardhamatra is the ONLY true Vedavit (Knower of the Vedas)!'"
                    "The rest of the pathetic world merely memorizing mantras is wandering blindly in the horrific darkness of ignorance."
                    "This Ardhamatra is the literal cosmic Black Hole that violently swallows a human's ego, his biological body, and his past lives in a single microsecond."
                    "Touching this silence means literally embracing your own death and resurrecting flawlessly as God."
                    "Here, meditation reaches its most terrifying climax, where the human brain explodes and flatlines into absolute zero."
                    "Every meditation executed without touching this Ardhamatra is merely pathetic mental gymnastics, absolutely not Moksha."
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 5,
                sanskrit = "हृदि पद्मं तदासनं तस्य मध्ये वासुदेवः... ध्यानं तत्रैव कारयेत् ॥ ५॥",
                hindi = """
                    (हृदय रूपी कुरुक्षेत्र और वासुदेव): "उपनिषद ध्यान का सबसे सटीक और अचूक निशाना बताता है—तुम्हारा अपना 'हृदय' (हृदि)!"
                    "तुम्हारे सीने के भीतर मांस का टुकड़ा नहीं, बल्कि ऊर्जा का एक ब्रह्मांडीय 'कमल' (पद्मं) छिपा हुआ है, जो उस भगवान का असली 'सिंहासन' (आसनं) है।"
                    "उस धधकते हुए कमल के ठीक 'बीच' (मध्ये) में साक्षात 'वासुदेव' (परब्रह्म) का निवास है!"
                    "योगी को बाहर जंगलों या मंदिरों में भटकने का आदेश नहीं है; उसे आदेश है कि वह अपना पूरा ध्यान 'वहीं' (तत्रैव) केंद्रित करे!"
                    "अपनी बिखरी हुई चेतना को बाहर से नोंच कर लाओ और उसे अपने हृदय के इस केंद्र में एक कील की तरह ठोक दो।"
                    "यह शरीर एक कुरुक्षेत्र है, और वह हृदय का कमल वह रथ है जहाँ साक्षात भगवान विराजमान हैं।"
                    "जो इंसान अपनी नज़र बाहर रखता है, वह इस ब्रह्मांड का सबसे बड़ा भिखारी है।"
                    "लेकिन जो अपनी आँखें बंद करके इस आंतरिक वासुदेव पर हमला (ध्यान) करता है, वह पल भर में पूरे ब्रह्मांड का राजा बन जाता है।"
                    "ईश्वर की सत्ता आसमान में नहीं चलती; उसका असली हेडक्वार्टर (Headquarter) तुम्हारे ही सीने में है।"
                    "इसी हेडक्वार्टर पर कब्ज़ा करने का नाम ही 'ध्यान' है!"
                """.trimIndent(),
                english = """
                    (The Battlefield of the Heart and Vasudeva): "The Upanishad reveals the most absolute, lethal target for meditation—your own 'Heart' (Hridi)!"
                    "Deep within your chest lies not a piece of biological meat, but a cosmic, radioactive 'Lotus' (Padmam) which serves as the literal 'Throne' (Asanam) of God."
                    "Exactly in the 'Dead Center' (Madhye) of that blazing lotus resides explicit 'Vasudeva' (The Supreme Brahman)!"
                    "The Yogi is absolutely not commanded to wander in pathetic external forests or temples; he is commanded to force his total meditation 'Exactly There' (Tatraiva)!"
                    "Violently claw back your scattered consciousness from the external world and hammer it like a steel nail directly into the center of your heart."
                    "This physical body is a Kurukshetra (Battlefield), and that heart-lotus is the chariot where God Himself is seated."
                    "The human who keeps his vision focused on the outside world is the greatest, most pathetic beggar in the cosmos."
                    "But he who shuts his eyes and launches a psychological assault (Meditation) on this internal Vasudeva instantaneously becomes the Emperor of the universe."
                    "God's absolute dictatorship does not operate from the sky; His authentic Headquarters is right inside your own chest."
                    "The brutal conquest and takeover of this Headquarters is precisely what is called 'Dhyana'!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 6,
                sanskrit = "समं कायशिरोग्रीवं धारयन्नचलं स्थिरः । सम्प्रेक्ष्य नासिकाग्रं स्वं दिशश्चानवलोकयन् ॥ ६॥",
                hindi = """
                    (अजेय मुद्रा और सन्नाटे का हमला): "ध्यान कोई आराम का खेल नहीं है; यह एक फौजी की तरह खुद को मोर्चे पर खड़ा करने की कला है!"
                    "उपनिषद का कड़ा हुक्म है: अपने 'शरीर, सिर और गर्दन' (कायशिरोग्रीवं) को एक सीधी रेखा में 'बिल्कुल सीधा' (समं) रखो।"
                    "एक चट्टान की तरह 'अचल' (Unmoving) और 'स्थिर' (Steadfast) हो जाओ; शरीर का एक रोम भी हिलना नहीं चाहिए!"
                    "तुम्हारी आँखें न तो पूरी तरह बंद होनी चाहिए और न खुली; अपनी नज़र को 'अपनी ही नाक के आगे' (नासिकाग्रं) एक लेज़र बीम की तरह फिक्स कर दो!"
                    "तुम्हें किसी भी दूसरी 'दिशा' (दिशश्च) में झाँकने या देखने की सख्त मनाही है (अनवलोकयन्)।"
                    "बाहर की दुनिया क्या कर रही है, कौन मर रहा है, कौन जी रहा है—इससे तुम्हारा रिश्ता उसी सेकंड कट जाना चाहिए।"
                    "यह शरीर की वह खौफनाक 'लॉकडाउन' (Lockdown) अवस्था है जहाँ इंसान अपनी ही देह को एक जेल में बदल देता है।"
                    "जब शरीर पत्थर बन जाता है और नज़रें एक जगह गड़ जाती हैं, तब मन तड़पने लगता है और भागने की कोशिश करता है।"
                    "यही वह महायुद्ध है! तुम्हें उस मन की चीखें नहीं सुननी हैं, उसे वहीं उस सन्नाटे में भूखा मार देना है।"
                    "इसी अजेय मुद्रा से ही ब्रह्मांड के सबसे बड़े ज्ञान का दरवाज़ा टूटता है।"
                """.trimIndent(),
                english = """
                    (The Invincible Posture and the Assault of Silence): "Meditation is absolutely no game of relaxation; it is the art of positioning yourself on a battlefield like a ruthless soldier!"
                    "The Upanishad issues a draconian command: Hold your 'Body, Head, and Neck' (Kaya-shiro-grivam) in a violently straight, perfect vertical line (Samam)."
                    "Become as terrifyingly 'Unmoving' (Achalam) and 'Steadfast' (Sthirah) as a cosmic monolith; not a single biological hair on your body should twitch!"
                    "Your eyes must be neither fully closed nor open; lock your gaze directly on the 'Tip of your own Nose' (Nasikagram) like a concentrated laser beam!"
                    "You are strictly and violently prohibited from glancing or looking in any other 'Direction' (Dishascha anavalokayan)."
                    "Whatever the external world is doing, who is dying, who is living—your connection to it must be brutally severed in that exact microsecond."
                    "This is the terrifying 'Lockdown' state of the biological shell where a human turns his own flesh into a maximum-security prison."
                    "When the physical body mutates into stone and the gaze is lethally fixed, the mind begins to scream in agony, desperately trying to escape."
                    "This is the Great War! You must absolutely ignore the screams of that mind and starve it to a brutal death right there in that silence."
                    "Only through this invincible posture is the titanium door of the universe's greatest cosmic knowledge violently breached."
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 7,
                sanskrit = "इन्द्रियाणि मनसा नियम्य... हृदि सन्निवेश्य... ॥ ७॥",
                hindi = """
                    (इंद्रियों का गला घोंटना और हृदय में कैद): "शरीर को पत्थर बनाने के बाद, अगला खौफनाक प्रहार अपनी ही 'इंद्रियों' (Senses) पर करना होता है।"
                    "आँख, कान, नाक, जीभ और त्वचा—ये पाँचों इंद्रियां इंसान को बाहर की दुनिया का गुलाम बनाकर रखती हैं।"
                    "उपनिषद हुक्म देता है: अपने खूँखार 'मन' (मनसा) का इस्तेमाल चाबुक की तरह करो और इन पाँचों इंद्रियों को बेरहमी से कुचल दो (नियम्य)!"
                    "इन आवारा कुत्तों (इंद्रियों) को दुनिया के मजे लूटने से रोककर, उन्हें घसीटते हुए वापस अपने 'हृदय' (हृदि) में लाकर कैद कर दो (सन्निवेश्य)!"
                    "कोई आवाज़ तुम्हें सुनाई न दे, कोई दृश्य तुम्हें दिखाई न दे; बाहर की दुनिया का सिग्नल 100% कट जाना चाहिए।"
                    "जब तुम अपने ही शरीर के सारे दरवाज़े और खिड़कियां अंदर से लॉक कर लेते हो, तो तुम दुनिया के लिए मर जाते हो।"
                    "यह 'प्रत्याहार' की वह क्रूर अवस्था है जहाँ तुम खुद अपनी इच्छाओं का गला घोंटते हो।"
                    "जो इंसान अपनी आँखों और कानों का गुलाम है, वह साक्षात एक जानवर है।"
                    "लेकिन जो अपनी इंद्रियों को जंजीरों में बाँधकर अपने हृदय के कालकोठरी में डाल देता है, वह भगवान बनने के रास्ते पर है।"
                    "इसी मानसिक क्रूरता से ही वह आग पैदा होती है जो अज्ञान को जलाती है!"
                """.trimIndent(),
                english = """
                    (Strangling the Senses and Imprisonment in the Heart): "After mutating the body into stone, the next terrifying strike must be launched directly against your own 'Senses' (Indriyani)."
                    "The eyes, ears, nose, tongue, and skin—these five senses keep the human enslaved as a pathetic prisoner of the external world."
                    "The Upanishad commands: Weaponize your ferocious 'Mind' (Manasa) like a bullwhip and brutally crush and subjugate these five senses (Niyamya)!"
                    "Stopping these stray dogs (senses) from looting worldly pleasures, violently drag them back and lock them permanently inside your 'Heart' (Hridi) (Sanniveshya)!"
                    "Absolutely no sound should be heard, no sight should be seen; the signal from the external matrix must be cut 100%."
                    "When you brutally lock all the doors and windows of your own biological body from the inside, you are functionally dead to the world."
                    "This is the ruthless, cold-blooded state of 'Pratyahara' where you literally strangle your own worldly desires to death."
                    "The human who operates as a pathetic slave to his eyes and ears is nothing more than a biological animal."
                    "But he who binds his senses in titanium chains and throws them into the dungeon of his heart is skyrocketing toward Godhood."
                    "It is strictly through this psychological cruelty that the radioactive fire capable of incinerating cosmic ignorance is born!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 8,
                sanskrit = "प्रणवो धनुः शरो ह्यात्मा ब्रह्म तल्लक्ष्यमुच्यते ॥ ८॥",
                hindi = """
                    (ब्रह्मांडीय तीर-कमान का सबसे खौफनाक फॉर्मूला): "यह उपनिषदों का सबसे प्रसिद्ध और प्रलयंकारी श्लोक है, जो ध्यान का पूरा विज्ञान खोल देता है!"
                    "तुम्हें युद्ध करना है, और तुम्हारे हथियार क्या हैं? 'प्रणव' (ॐकार) तुम्हारा सबसे शक्तिशाली 'धनुष' (Bow/धनुः) है!"
                    "और उस धनुष पर रखा जाने वाला 'तीर' (Arrow/शरो) कोई लकड़ी का नहीं है, तुम्हारी खुद की 'आत्मा' (ह्यात्मा) ही वह घातक तीर है!"
                    "और तुम्हारा निशाना (Target/लक्ष्यम्) क्या है? साक्षात 'परब्रह्म' (Supreme God) ही तुम्हारा एकमात्र निशाना है!"
                    "तुम्हें अपनी आत्मा को ॐकार के धनुष पर चढ़ाना है और उसे पूरी ताक़त से खींचकर सीधे भगवान के सीने में ठोकना है!"
                    "यह कोई कमज़ोरों का खेल नहीं है; यह अपनी ही हस्ती (Ego) को दांव पर लगाकर ब्रह्मांड को भेदने का आत्मघाती हमला है।"
                    "अगर तुम्हारा निशाना चूका, तो तुम वापस इस दुनिया के कीचड़ (जन्म-मरण) में गिर जाओगे।"
                    "ॐकार वह स्प्रिंग (Spring) है जो तुम्हारी आत्मा को उस गति से फेंकता है जो प्रकाश की गति से भी करोड़ों गुना तेज़ है।"
                    "जब तक आत्मा और ब्रह्म के बीच की दूरी खत्म नहीं होती, तब तक यह तीर रुकना नहीं चाहिए।"
                    "यह सनातन धर्म का वह स्नाइपर (Sniper) हमला है जो सीधा मोह-माया के सिर के चीथड़े उड़ा देता है!"
                """.trimIndent(),
                english = """
                    (The Most Terrifying Formula of the Cosmic Bow and Arrow): "This is the most legendary and apocalyptic Shloka of the Upanishads, exposing the entire absolute science of Meditation!"
                    "You are commanded to wage war, and what are your weapons? 'Pranava' (OM) is your supremely powerful, indestructible 'Bow' (Dhanuh)!"
                    "And the 'Arrow' (Sharo) mounted on that bow is not made of pathetic wood; your very own 'Soul' (Atma) is that highly lethal arrow!"
                    "And what is your exact 'Target' (Lakshyam)? Explicitly the 'Supreme Brahman' (God) Himself is your one and only target!"
                    "You must mount your Soul onto the bow of OM, draw it back with catastrophic force, and fire it directly into the chest of God!"
                    "This is absolutely no game for the weak; it is a suicide-assault on the cosmos, wagering your entire existence (Ego) to breach the universe."
                    "If your aim misses by a micro-millimeter, you will violently plummet back into the disgusting mud of this world (birth and death)."
                    "OM is the cosmic spring that launches your soul at a velocity billions of times faster than the speed of light."
                    "Until the distance between the Soul and Brahman is permanently annihilated, this arrow must absolutely never stop."
                    "This is Sanatana Dharma's ultimate Sniper assault that literally blows the head off worldly illusions and Maya!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 9,
                sanskrit = "अप्रमत्तेन वेद्धव्यं शरवत्तन्मयो भवेत् ॥ ९॥",
                hindi = """
                    (अचूक निशाना और लक्ष्य में विस्फोट): "उस असीम परब्रह्म रुपी निशाने को भेदना कोई आम बात नहीं है।"
                    "उपनिषद चेतावनी देता है: इस तीर (आत्मा) को 'अप्रमत्तेन' (पूरी तरह से बिना किसी आलस, बिना किसी भटकाव और पूरे फोकस के साथ) मारना है (वेद्धव्यं)!"
                    "अगर ध्यान करते समय तुम्हारे दिमाग में एक सेकंड के लिए भी दुनिया का कोई खयाल आया, तो तुम्हारा निशाना चूक जाएगा।"
                    "तुम्हें उस निशाने को ऐसे भेदना है कि 'शरवत् तन्मयो भवेत्'— जैसे एक तेज़ तीर अपने लक्ष्य (पेड़ या जानवर) के अंदर घुसकर उसी का हिस्सा बन जाता है..."
                    "उसी तरह, तुम्हारी आत्मा को परब्रह्म के अंदर इतनी भयानक गति से घुसना है कि वह साक्षात 'वही' (तन्मयो) बन जाए!"
                    "तुम्हारी कोई अलग पहचान नहीं बचनी चाहिए; तीर और लक्ष्य दोनों पिघल कर एक हो जाने चाहिए।"
                    "जब आत्मा ईश्वर से टकराती है, तो इंसान का 'मैं' एक प्रलयंकारी धमाके के साथ फट जाता है।"
                    "उसके बाद कोई साधक नहीं बचता, कोई भगवान नहीं बचता—केवल एक अद्वैत, खौफनाक सन्नाटा बचता है।"
                    "यही वह महा-विस्फोट (Big Bang) है जहाँ एक आम इंसान साक्षात परमेश्वर में बदल जाता है।"
                    "यही ध्यान का असली और सबसे भयानक 'द एंड' (The End) है!"
                """.trimIndent(),
                english = """
                    (The Flawless Shot and Detonation into the Target): "Breaching that infinite Supreme Brahman target is absolutely no ordinary feat."
                    "The Upanishad roars a lethal warning: This arrow (Soul) must be fired 'Apramattena' (with absolutely zero laziness, zero distraction, and terrifying, flawless focus) (Veddhavayam)!"
                    "If even a microscopic worldly thought infiltrates your brain for a split second during meditation, your shot will catastrophically fail."
                    "You must breach that target in such a brutal manner that 'Sharavat tanmayo bhavet'—just as a high-velocity arrow violently penetrates its target and becomes permanently embedded within it..."
                    "In the exact same way, your soul must smash into the Supreme Brahman with such apocalyptic velocity that it explicitly mutates into 'That' (Tanmayo)!"
                    "Absolutely zero separate identity of yours must survive; the arrow and the target must violently melt and fuse into one."
                    "When the Soul collides with God, the human 'I' detonates in an apocalyptic, universe-shattering explosion."
                    "After that microsecond, no seeker survives, no separate God survives—only a non-dual, terrifying cosmic silence remains."
                    "This is the literal spiritual Big Bang where an ordinary mortal instantaneously mutates into the Supreme God."
                    "This is the authentic and most terrifying 'The End' of Meditation!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 10,
                sanskrit = "भिद्यते हृदयग्रन्थिश्छिद्यन्ते सर्वसंशयाः । क्षीयन्ते चास्य कर्माणि तस्मिन् दृष्टे परावरे ॥ १०॥",
                hindi = """
                    (हृदय की गाँठ का फटना और कर्मों का विनाश): "जब वह आत्मा रूपी तीर परब्रह्म में जाकर धंसता है, तो इंसान के अंदर एक प्रलयंकारी घटना घटती है।"
                    "सबसे पहले 'भिद्यते हृदयग्रन्थिः'— उसके हृदय में बँधी हुई अज्ञान, मोह और अहंकार की वह लोहे की 'गाँठ' एक भयानक विस्फोट के साथ फट जाती है!"
                    "हज़ारों जन्मों से पाले गए उसके सारे भ्रम और सारे 'संशय' (Doubts) एक ही झटके में 'छिन्न-भिन्न' (छिद्यन्ते) होकर राख हो जाते हैं।"
                    "उसे अब किसी भी सवाल का जवाब नहीं चाहिए, क्योंकि वह खुद ही सारे सवालों का जवाब बन चुका है।"
                    "और सबसे खौफनाक बात— 'क्षीयन्ते चास्य कर्माणि'— उसके जन्मों-जन्मों के अच्छे और बुरे, सारे 'कर्मों' का रिकॉर्ड जलकर शून्य हो जाता है!"
                    "न उसे स्वर्ग का पुण्य मिलता है और न नर्क का पाप; वह कर्मों की इस सड़ी हुई मशीन (Matrix) से हमेशा के लिए आज़ाद हो जाता है।"
                    "यह सब कब होता है? 'तस्मिन् दृष्टे परावरे'— जब वह उस परम और सबसे श्रेष्ठ (परावरे) ईश्वर को अपनी ही आत्मा के रूप में 'देख' (साक्षात्कार कर) लेता है!"
                    "ईश्वर का दर्शन कोई सुंदर नज़ारा नहीं है; यह एक ऐसा न्यूक्लियर धमाका है जो इंसान की पूरी हस्ती को मिटा देता है।"
                    "जो बचता है, वह इंसान नहीं, बल्कि साक्षात वह परब्रह्म ही होता है।"
                    "यही सनातन धर्म की वह परम और आखिरी आज़ादी (मोक्ष) है!"
                """.trimIndent(),
                english = """
                    (The Shattering of the Heart's Knot and Annihilation of Karma): "When that arrow of the Soul violently penetrates Brahman, an apocalyptic event detonates inside the human."
                    "First, 'Bhidyate hridaya-granthih'—that titanium 'Knot' of absolute ignorance, delusion, and ego tied in his heart violently explodes into dust!"
                    "Every single illusion and all 'Doubts' (Samshayah) incubated over thousands of lifetimes are instantaneously 'Shredded' (Chidyante) and burnt to ashes in a single microsecond."
                    "He absolutely no longer requires any answers to any questions, because he himself has mutated into the final answer."
                    "And the most terrifying fact—'Kshiyante chasya karmani'—the entire cosmic record of his billions of past 'Karmas', both good and evil, is violently incinerated to absolute zero!"
                    "He earns neither the merit of heaven nor the sin of hell; he is permanently, irrevocably liberated from this rotting biological Matrix of Karma."
                    "When exactly does this happen? 'Tasmin drishte paravare'—The microsecond he directly 'Sees' (Realizes) that Supreme, Highest God (Paravara) strictly as his own Soul!"
                    "The vision of God is absolutely no beautiful scenery; it is a literal nuclear detonation that violently erases the human's entire existence."
                    "What survives the blast is definitely not a human, but explicitly the Supreme Brahman Himself."
                    "This is the absolute, final, and terrifying Freedom (Moksha) of Sanatana Dharma!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 11,
                sanskrit = "न तत्र सूर्यो भाति न चन्द्रतारकं नेमा विद्युतो भान्ति कुतोऽयमग्निः । तमेव भान्तमनुभाति सर्वं तस्य भासा सर्वमिदं विभाति ॥ ११॥",
                hindi = """
                    (वह परम प्रकाश जो सूरज को भी अंधा कर दे): "जब योगी अपने हृदय की सबसे गहरी गुफा में पहुँचता है, तो उसे एक ऐसा खौफनाक और असीम प्रकाश दिखाई देता है..."
                    "कि उपनिषद चीख कर कहता है: 'वहाँ (तत्र) उस परमेश्वर के सामने इस दुनिया के 'सूरज' (सूर्यो) की भी चमकने की औकात नहीं है!'"
                    "वहाँ न कोई चाँद चमकता है और न ही अरबों तारों (चन्द्रतारकं) की कोई रोशनी पहुँच सकती है!"
                    "आसमान में कड़कने वाली 'बिजली' (विद्युतो) भी वहाँ पूरी तरह अंधी और बेअसर हो जाती है; तो फिर धरती की इस मामूली 'आग' (अग्निः) की तो क्या ही बिसात है?"
                    "ये सब भौतिक रौशनियाँ उस ब्रह्मांडीय प्रकाश के सामने घने अँधेरे जैसी हैं।"
                    "असलियत यह है कि 'तमेव भान्तमनुभाति सर्वं'— केवल उस एक परमेश्वर के चमकने से ही यह सूरज, चाँद और तारे चमक रहे हैं!"
                    "सूरज की अपनी कोई ताक़त नहीं; वह तो केवल उस परब्रह्म के प्रकाश की एक छोटी सी परछाईं (Reflection) मात्र है।"
                    "'तस्य भासा सर्वमिदं विभाति'— उसी एक की रोशनी से यह पूरा असीम ब्रह्मांड प्रकाशित हो रहा है।"
                    "योगी जब ध्यान में उस असली 'पावर हाउस' (Powerhouse) से जुड़ जाता है, तो उसे बाहर के किसी सूरज की ज़रूरत नहीं रहती।"
                    "वह खुद ही वह प्रकाश बन जाता है जिससे यह पूरी दुनिया चल रही है; वह अंधकार को हमेशा के लिए मार देता है!"
                """.trimIndent(),
                english = """
                    (The Supreme Light That Blinds Even the Sun): "When the Yogi breaches the deepest, darkest cave of his heart, he witnesses a light so terrifying and infinite..."
                    "That the Upanishad screams: 'There (Tatra), in the presence of that Supreme God, even the physical 'Sun' (Suryo) possesses absolutely zero status or capability to shine!'"
                    "Neither any moon illuminates that dimension, nor can the light of billions of 'Stars' (Chandratarakam) ever penetrate it!"
                    "Even the apocalyptic 'Lightning' (Vidyuto) crashing in the skies goes completely blind and powerless there; what then is the pathetic worth of this earthly 'Fire' (Agnih)?"
                    "All these physical biological lights are equivalent to pitch-black darkness when placed before that Cosmic Light."
                    "The absolute reality is 'Tameva bhantamanubhati sarvam'—It is strictly because that One Supreme God shines that this sun, moon, and stars are shining at all!"
                    "The physical sun possesses zero independent power; it is merely a pathetic, microscopic reflection of Brahman's radioactive light."
                    "'Tasya bhasa sarvamidam vibhati'—By His absolute Light alone is this entire infinite cosmos illuminated."
                    "When the Yogi connects directly to that authentic cosmic 'Powerhouse' in meditation, he no longer requires any external sun."
                    "He himself violently mutates into the exact Light that powers the universe; he permanently slaughters the very concept of darkness!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 12,
                sanskrit = "ब्रह्मैवेदममृतं पुरस्ताद् ब्रह्म पश्चाद् ब्रह्म दक्षिणतश्चोत्तरेण । अधश्चोर्ध्वं च प्रसृतं ब्रह्मैवेदं विश्वमिदं वरिष्ठम् ॥ १२॥",
                hindi = """
                    (हर दिशा में केवल और केवल परब्रह्म का खौफनाक साम्राज्य): "जब ध्यान की चरम अवस्था में इंसान का अज्ञान पूरी तरह राख हो जाता है, तो उसे क्या दिखता है?"
                    "उसे दिखता है कि 'सामने' (पुरस्ताद्) जो कुछ भी है, वह केवल और केवल अमर 'परब्रह्म' ही है (ब्रह्मैवेदममृतं)!"
                    "जो उसके 'पीछे' (पश्चाद्) है, वह भी साक्षात भगवान है; जो उसके 'दाएं' (दक्षिणत) और 'बाएं' (उत्तरेण) है, वह भी केवल परब्रह्म है!"
                    "जो उसके पैरों के 'नीचे' (अधश्च) है और जो उसके सिर के 'ऊपर' (ऊर्ध्वं) अनंत आसमान में फैला (प्रसृतं) है—वह सब कुछ केवल और केवल वही एक ऊर्जा है!"
                    "पूर्व, पश्चिम, उत्तर, दक्षिण, ऊपर, नीचे—यह पूरा ब्रह्मांड उस परमेश्वर से ही भरा हुआ है; वहाँ एक इंच की भी खाली जगह नहीं है जहाँ भगवान न हो।"
                    "यह जो पूरी दुनिया (विश्वमिदं) हमें ठोस और अलग-अलग चीज़ों की तरह दिख रही है, यह हमारा सबसे बड़ा और भयंकर भ्रम है।"
                    "असलियत में यह पूरी सृष्टि साक्षात 'परब्रह्म' का ही सबसे श्रेष्ठ (वरिष्ठम्) और अजेय रूप है।"
                    "मैं, तुम, पेड़, पहाड़, दुश्मन, दोस्त—सब कुछ उसी एक ऊर्जा का नाटक है।"
                    "योगी इस प्रलयंकारी सत्य को देखकर पागल नहीं होता, बल्कि वह इस पूरे ब्रह्मांड में पिघलकर 'सब कुछ' बन जाता है!"
                    "जहाँ द्वैत (Duality) की मौत हो जाती है, वही अद्वैत का यह खौफनाक और परम सत्य राज करता है।"
                """.trimIndent(),
                english = """
                    (The Terrifying, Undisputed Empire of Brahman in Every Direction): "When human ignorance is completely burnt to ashes in the ultimate climax of meditation, what exactly does he witness?"
                    "He flawlessly perceives that whatever exists directly in 'Front' (Purastad) of him is exclusively the immortal 'Supreme Brahman' alone (Brahmaivedamamritam)!"
                    "Whatever is 'Behind' (Pashchad) him is also explicit God; whatever is to his 'Right' (Dakshina) and 'Left' (Uttara) is strictly the Supreme Brahman!"
                    "Whatever is 'Below' (Adhascha) his feet and 'Above' (Urdhvam) his head, expanding (Prasritam) into infinite space—it is all exclusively that exact same, singular primordial energy!"
                    "East, West, North, South, Up, Down—this entire cosmos is violently saturated with God; there is not a single micro-inch of vacuum where God is absent."
                    "This entire infinite universe (Vishvamidam) that we hallucinate as solid, separated objects is humanity's most catastrophic, pathetic illusion."
                    "In absolute reality, this entire creation is explicitly the most supreme (Varishtham) and invincible physical manifestation of 'Brahman' Himself."
                    "I, You, trees, mountains, enemies, friends—absolutely everything is a biological drama played by that one solitary energy."
                    "Witnessing this apocalyptic truth, the Yogi does not go mad; instead, he melts entirely into the cosmos, literally mutating into 'Everything'!"
                    "Where Duality suffers a brutal death, this terrifying and absolute truth of Non-Duality rules as the supreme dictator."
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 13,
                sanskrit = "यदा पञ्चावतिष्ठन्ते ज्ञानानि मनसा सह । बुद्धिश्च न विचेष्टति तामाहुः परमां गतिम् ॥ १३॥",
                hindi = """
                    (दिमाग की मौत और परम गति): "ध्यान की उस अवस्था का वर्णन सुनो जहाँ इंसानियत पूरी तरह से खत्म हो जाती है!"
                    "जब इंसान की पाँचों 'ज्ञानेंद्रियां' (आँख, कान, नाक, जीभ, त्वचा) बाहरी दुनिया को चखना बंद करके पूरी तरह से 'सुन्न' (अन्तर्मुखी / अवतिष्ठन्ते) हो जाती हैं..."
                    "और जब उनका राजा, यह खूँखार 'मन' (मनसा सह), जो हर पल विचार पैदा करता है, वह भी पूरी तरह से लकवाग्रस्त (Paralyzed) होकर शांत हो जाता है..."
                    "और सबसे बड़ी बात— जब इंसान की 'बुद्धि' (Intellect/बुद्धिश्च), जो हमेशा सही-गलत का फैसला करती है, वह भी काम करना बंद कर देती है (न विचेष्टति)!"
                    "यानी जहाँ इंसान का देखना, सोचना और समझना पूरी तरह से मर जाता है..."
                    "उसी 'दिमाग की मौत' वाली भयानक शून्यता को ही योगियों ने 'परम गति' (The Ultimate Supreme State) कहा है!"
                    "ईश्वर को विचारों से नहीं पकड़ा जा सकता; विचारों का वध करने के बाद ही ईश्वर प्रकट होता है।"
                    "जब तक तुम्हारा दिमाग चल रहा है, तुम दुनिया की मैट्रिक्स में फँसे एक गुलाम हो।"
                    "लेकिन जब तुम ध्यान के हथौड़े से अपने ही दिमाग को शून्य में बदल देते हो, तो तुम समय और अंतरिक्ष के पार निकल जाते हो।"
                    "यही वह खौफनाक और अजेय अवस्था है जहाँ से कोई योगी वापस लौटकर आम इंसान नहीं बनता!"
                """.trimIndent(),
                english = """
                    (The Death of the Brain and the Ultimate Supreme State): "Listen to the terrifying description of that meditative dimension where humanity completely ceases to exist!"
                    "When the human's five 'Senses of Knowledge' (eyes, ears, nose, tongue, skin) completely stop consuming the external world and go entirely 'Numb' and paralyzed (Avatishthante)..."
                    "And when their tyrannical king, this ferocious 'Mind' (Manasa saha) that endlessly breeds thoughts, is also completely paralyzed into absolute dead silence..."
                    "And the ultimate strike—when the human 'Intellect' (Buddhischa), which constantly calculates right and wrong, violently shuts down and completely stops functioning (Na vicheshtati)!"
                    "Meaning, the exact dimension where human sight, thought, and comprehension suffer a brutal, total biological death..."
                    "That horrifying, absolute Void of 'brain-death' is exactly what the supreme Yogis declare as the 'Parama Gatim' (The Ultimate Absolute Supreme State)!"
                    "God absolutely cannot be captured through pathetic thoughts; God explicitly manifests only after the brutal assassination of all thoughts."
                    "As long as your brain is functioning, you are a pathetic biological slave trapped in the Matrix of the world."
                    "But when you use the sledgehammer of meditation to mutate your brain into absolute zero, you violently rocket beyond time and space."
                    "This is that terrifying, invincible zenith from which no Yogi ever returns to being a pathetic normal human!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 14,
                sanskrit = "मन एव मनुष्याणाम् कारणं बन्धमोक्षयोः । बन्धाय विषयासक्तं मुक्त्यै निर्विषयं स्मृतम् ॥ १४॥",
                hindi = """
                    (मन ही सबसे बड़ा दुश्मन और सबसे बड़ा हथियार है): "उपनिषद इंसान की पूरी ज़िंदगी का सबसे नंगा और कड़वा सच एक लाइन में खोल देता है।"
                    "तुम्हें बाँधने वाला कोई शैतान नहीं है और तुम्हें आज़ाद करने वाला कोई आसमान में बैठा भगवान नहीं है..."
                    "केवल और केवल तुम्हारा अपना 'मन' (मन एव) ही तुम्हारे 'बंधन' (गुलामी) और 'मोक्ष' (परम आज़ादी) का इकलौता कारण (कारणं) है!"
                    "जब तुम्हारा यह मन दुनिया की वासनाओं, पैसों, रिश्तों और सुखों में अंधा होकर चिपक जाता है (विषयासक्तं)..."
                    "तो यही मन तुम्हारे लिए सबसे भयंकर 'बंधन' (जेल) बन जाता है, जहाँ तुम जन्मों तक जानवरों की तरह पैदा होते और मरते हो।"
                    "लेकिन जब तुम ध्यान की तलवार से इस मन को दुनिया की हर चीज़ से पूरी तरह काट कर 'निर्विषय' (Objectless / शून्य) कर देते हो..."
                    "तो यही मन फटकर साक्षात 'मोक्ष' (परम स्वतंत्रता) बन जाता है!"
                    "तुम्हारा मन एक ऐसा खौफनाक चाकू है जिसे अगर तुमने बाहर की तरफ चलाया, तो यह तुम्हें काट डालेगा।"
                    "लेकिन अगर तुमने इस चाकू को अंदर की तरफ मोड़कर अपने ही विचारों का कत्ल कर दिया, तो तुम ईश्वर बन जाओगे।"
                    "तुम्हारी हार और जीत केवल तुम्हारे अपने सिर के भीतर चल रहे इस युद्ध पर निर्भर है; बाहर कोई लड़ाई है ही नहीं!"
                """.trimIndent(),
                english = """
                    (The Mind as the Ultimate Enemy and the Ultimate Weapon): "The Upanishad rips open the most naked, bitter truth of human existence in a single, atomic line."
                    "There is absolutely no external demon chaining you, and no God sitting in the sky coming to free you..."
                    "Exclusively and strictly your very own 'Mind' (Mana eva) is the one and only cause (Karanam) of your horrific 'Bondage' (Slavery) and your 'Moksha' (Absolute Freedom)!"
                    "When this mind becomes blindly addicted, lustful, and violently attached to worldly objects, money, and biological pleasures (Vishayasaktam)..."
                    "This exact mind mutates into the most terrifying 'Bondage' (Maximum-Security Prison) where you breed and die like pathetic animals for billions of lifetimes."
                    "But when you weaponize the sword of meditation to violently sever this mind from every single worldly object, rendering it 'Nirvishaya' (Absolute Zero/Objectless)..."
                    "This exact mind detonates and instantaneously mutates into explicit 'Moksha' (Absolute Cosmic Liberation)!"
                    "Your mind is a terrifying, lethal knife; if you swing it outward toward the world, it will brutally slaughter you."
                    "But if you violently turn this knife inward and assassinate your own thoughts, you instantly mutate into God."
                    "Your absolute defeat or your supreme cosmic victory depends strictly on this brutal war waging inside your own skull; there is absolutely no external war!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 15,
                sanskrit = "शून्यं शून्य इति भाव्यं... यदा पश्यति तत्त्वतः । तदा भवति तत्त्वज्ञो... ॥ १५॥",
                hindi = """
                    (शून्यता का प्रलयंकारी ध्यान): "जब योगी अपने मन की वासनाओं को मार देता है, तो उसे एक ऐसी खौफनाक चीज़ का ध्यान करना होता है जो इंसान को पागल कर दे।"
                    "उसे आदेश है: 'शून्यं शून्य इति भाव्यं'— केवल 'शून्य' (Absolute Void / Nothingness) की भावना करो! सब कुछ मिटा दो!"
                    "न कोई रूप, न कोई रंग, न कोई आवाज़, न कोई भगवान की मूर्ति... केवल और केवल एक अंतहीन, काला सन्नाटा!"
                    "यह शून्यता मौत से भी ज्यादा डरावनी है, क्योंकि इसमें इंसान का 'मैं' (अहंकार) साँस नहीं ले पाता और घुट-घुट कर मर जाता है।"
                    "जब वह योगी ध्यान की कुल्हाड़ी से अपने ही अस्तित्व के टुकड़े-टुकड़े करके उस पूर्ण 'शून्य' को साक्षात देख लेता है (यदा पश्यति तत्त्वतः)..."
                    "तब, केवल और केवल उसी सेकंड में, वह सच्चा 'तत्त्वज्ञ' (ब्रह्मांड के सबसे बड़े रहस्य को जानने वाला) बनता है!"
                    "शून्यता कोई खालीपन नहीं है; वह शून्य ही वह असीम परब्रह्म है जिसमें से करोड़ों ब्रह्मांड पैदा होते हैं।"
                    "जो मूर्ख किसी आकार (रूप) से चिपके हुए हैं, वे माया की जेल में सड़ रहे हैं।"
                    "लेकिन जिसने अपने भीतर इस महा-शून्य (Black Hole) को पैदा कर लिया, वह समय और मौत को उसी शून्य में निगल जाता है।"
                    "यह ध्यान का वह खौफनाक स्तर है जहाँ ब्रह्मांड गायब हो जाता है और केवल 'कुछ नहीं' (Nothingness) राज करता है।"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Meditation on the Void): "When the Yogi successfully slaughters the lusts of his mind, he is commanded to meditate on something so terrifying it drives mortals insane."
                    "He is ordered: 'Shunyam Shunya Iti Bhavyam'—Force your consciousness exclusively into 'Absolute Zero' (The Supreme Void / Nothingness)! Annihilate absolutely everything!"
                    "No form, no color, no sound, absolutely no idol of any God... strictly only an endless, pitch-black, infinite, death-like silence!"
                    "This Void is vastly more terrifying than literal death, because inside this vacuum, the human 'Ego' (I) cannot breathe and dies a brutal, suffocating death."
                    "When that Yogi takes the axe of meditation, hacks his own existence into pieces, and physically witnesses that Absolute 'Void' in absolute reality (Yada pashyati tattvatah)..."
                    "Then, in that exact microsecond alone, he mutates into a genuine 'Tattvajna' (The Supreme Knower of the universe's most classified secret)!"
                    "The Void is absolutely not emptiness; that exact Void is the infinite, radioactive Supreme Brahman from which billions of universes are spawned."
                    "The pathetic fools clinging to physical forms and shapes are rotting in the maximum-security prison of Maya."
                    "But he who has detonated this Cosmic Black Hole within himself violently swallows Time and Death directly into that exact Void."
                    "This is the terrifying altitude of meditation where the entire cosmos vanishes, and strictly 'Absolute Nothingness' rules as the supreme dictator."
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 16,
                sanskrit = "न सन्नासन्न सदसत् न महन्न चाणु । न स्त्री न पुमान् न नपुंसकम्... ॥ १६॥",
                hindi = """
                    (परब्रह्म की खौफनाक परिभाषा जो हर नियम तोड़ती है): "उपनिषद इंसान के दिमाग को पूरी तरह से हैंग (Hang) कर देने वाली परब्रह्म की परिभाषा देता है।"
                    "वह परम सत्य क्या है? 'न सन् नासन्'— वह न तो 'है' (Exist) और न ही 'नहीं है' (Non-exist)! वह होने और न होने, दोनों के पार है!"
                    "वह न तो कुछ 'सत' है और न ही 'असत', न वह बहुत 'बड़ा' (महत्) है और न ही परमाणु जैसा 'छोटा' (अणु) है!"
                    "उसे किसी जेंडर (Gender) में नहीं बाँधा जा सकता: 'न स्त्री न पुमान् न नपुंसकम्'— वह न तो कोई औरत है, न कोई आदमी है, और न ही किन्नर है!"
                    "वह हर भौतिक परिभाषा, हर गणित और इंसान की हर लॉजिक (Logic) को बेरहमी से कुचल देता है।"
                    "तुम उसे जो भी नाम दोगे, वह उससे अलग निकलेगा। वह इंसान की समझ की पहुँच से अरबों प्रकाश वर्ष दूर है।"
                    "ईश्वर कोई इंसान जैसा दिखने वाला रूप नहीं है; वह एक ऐसी प्रलयंकारी, असीम ऊर्जा है जिसे दिमाग से समझा ही नहीं जा सकता।"
                    "उसे केवल ध्यान के उस खौफनाक सन्नाटे में 'अनुभव' किया जा सकता है जब दिमाग मर चुका हो।"
                    "जो मूर्ख उस असीम शक्ति को एक छोटे से रूप या आकार में कैद करने की कोशिश करते हैं, वे ब्रह्मांड के सबसे बड़े जाहिल हैं।"
                    "जब योगी इस असीम 'कुछ नहीं' (Formless Reality) में छलांग लगाता है, तो वह खुद भी असीम हो जाता है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Definition of Brahman That Shatters All Laws): "The Upanishad delivers a definition of the Supreme Brahman designed explicitly to completely crash and short-circuit the human brain."
                    "What exactly is that Absolute Truth? 'Na San Nasann'—It absolutely neither 'Exists' (Sat) nor 'Non-Exists' (Asat)! It violently transcends both existence and non-existence!"
                    "It is neither reality nor unreality, neither colossally 'Massive' (Mahat) nor microscopically 'Tiny' like an atom (Anu)!"
                    "It absolutely cannot be chained to any pathetic biological gender: 'Na Stri Na Puman Na Napumsakam'—It is definitely no woman, absolutely no man, and no eunuch!"
                    "It ruthlessly and violently crushes every physical definition, every mathematics, and every pathetic drop of human logic."
                    "Whatever pathetic name you assign to it, it will shatter it. It exists billions of light-years beyond the absolute maximum limits of human comprehension."
                    "God is absolutely not a human-looking entity; God is an apocalyptic, infinite, radioactive energy that cannot possibly be processed by a biological brain."
                    "It can exclusively be 'Experienced' only in the terrifying, deafening silence of meditation when the brain has flatlined and died."
                    "The pathetic fools attempting to imprison that infinite cosmic power into a tiny physical form are the greatest ignoramuses in the cosmos."
                    "When the Yogi violently dives into this infinite, Formless Reality, he himself instantaneously mutates into the Absolute Infinite!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 17,
                sanskrit = "ज्ञानेन ध्यानेन तदा विमुक्तो... देहं त्यक्त्वा परं पदं याति ॥ १७॥",
                hindi = """
                    (अंतिम छलांग और शरीर का विनाश): "जब उस योगी के भीतर ज्ञान (Cosmic Knowledge) और ध्यान (Absolute Focus) की प्रलयंकारी आग अपने सबसे खौफनाक चरम पर पहुँचती है..."
                    "तब वह माया की इस पूरी मैट्रिक्स से एक ही झटके में 'विमुक्त' (हमेशा के लिए आज़ाद) हो जाता है।"
                    "उसे पता चल जाता है कि यह शरीर उसका घर नहीं, बल्कि सड़े हुए मांस का एक पिंजरा है।"
                    "और तब... 'देहं त्यक्त्वा'— वह अपनी मर्ज़ी से, बिना किसी बीमारी या डर के, इस भौतिक शरीर को एक पुराने फटे कपड़े की तरह उखाड़ कर फेंक देता है!"
                    "वह मौत का इंतज़ार नहीं करता; वह खुद मौत की छाती पर पैर रखकर अपने प्राणों को बाहर खींच लेता है।"
                    "शरीर के छूटते ही उसकी ऊर्जा ब्रह्मांड को फाड़ते हुए उस 'परम पद' (The Supreme Absolute Destination) में जाकर मिल जाती है।"
                    "जहाँ से कोई वापस इस नर्क (दुनिया) में पैदा होने नहीं आता; जन्म और मृत्यु की साइकिल हमेशा के लिए टूटकर राख हो जाती है।"
                    "वह पानी की बूँद की तरह उस असीम महासागर में गिरकर खुद महासागर बन जाता है।"
                    "यही सनातन धर्म की सबसे बड़ी जीत है—मौत को हराना और शरीर के रहते हुए ही भगवान बन जाना।"
                    "इस धमाके के बाद, ब्रह्मांड में कोई ऐसी ताक़त नहीं जो उस योगी को दोबारा इंसान बना सके!"
                """.trimIndent(),
                english = """
                    (The Final Leap and the Annihilation of the Body): "When the apocalyptic, radioactive fire of Knowledge (Jnana) and Absolute Meditation (Dhyana) reaches its most terrifying, explosive climax within that Yogi..."
                    "He is violently and instantaneously 'Liberated' (Vimukto) from the entire pathetic Matrix of Maya in a single, atomic strike."
                    "He realizes with lethal clarity that this biological body is absolutely not his home, but a disgusting, rotting cage of meat."
                    "And then... 'Deham Tyaktva'—by his own absolute dictatorial will, with zero disease or fear, he rips off and discards this physical body like a filthy, torn rag!"
                    "He absolutely does not wait for pathetic Death; he plants his boot directly on Death's chest and violently extracts his own life-force."
                    "The microsecond the body drops, his raw energy violently tears through the fabric of the cosmos and merges flawlessly into that 'Param Padam' (The Supreme Absolute Destination)."
                    "From where absolutely no one is ever dragged back to breed in this biological hell; the pathetic cycle of birth and death is permanently shattered to ashes."
                    "Like a drop of water plunging into an infinite ocean, he instantaneously mutates into the Ocean itself."
                    "This is the absolute greatest, ultimate victory of Sanatana Dharma—brutally defeating Death and mutating into God while still inside a biological shell."
                    "After this cosmic detonation, there is absolutely zero power in existence capable of ever devolving that Yogi back into a pathetic human!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 18,
                sanskrit = "ध्यानेनात्मनि पश्यन्ति केचिदात्मानमात्मना । अन्ये साङ्ख्येन योगेन कर्मयोगेन चापरे ॥ १८॥",
                hindi = """
                    (ध्यान की सर्वोच्चता और अन्य मार्ग): "उपनिषद ब्रह्मांड के उस परम सत्य तक पहुँचने के अलग-अलग रास्तों को खोलता है।"
                    "कुछ महाभयंकर और अजेय योगी ऐसे होते हैं जो 'ध्यान' (Meditation) के महा-विस्फोट के ज़रिए..."
                    "सीधे अपनी 'आत्मा के भीतर ही' (आत्मनि), अपनी ही 'चेतना के द्वारा' (आत्मना), उस साक्षात परमेश्वर को अपनी आँखों से 'देख' लेते हैं (पश्यन्ति)!"
                    "ये वे खतरनाक स्नाइपर हैं जो ध्यान की लेज़र बीम से सीधे ईश्वर के सीने में सुराख करते हैं।"
                    "कुछ दूसरे योगी 'सांख्य योग' (ज्ञान और विश्लेषण की तलवार) का इस्तेमाल करके अज्ञान का कत्ल करते हैं और सत्य तक पहुँचते हैं।"
                    "और कुछ योगी 'कर्म योग' (बिना फल की इच्छा के निष्काम और निडर कर्म) की भट्टी में जलकर उस ईश्वर को पाते हैं।"
                    "रास्ते चाहे कोई भी हों, लेकिन मंज़िल एक ही है— अपने 'अहंकार' की सबसे क्रूर और दर्दनाक मौत!"
                    "बिना खुद को मारे (अपना 'मैं' मिटाए), कोई भी इंसान भगवान के तख़्त तक नहीं पहुँच सकता।"
                    "लेकिन इन सबमें, 'ध्यान' वह सबसे तेज़, सबसे सीधा और सबसे खौफनाक रॉकेट है जो इंसान को सीधे ब्रह्मांड के केंद्र में ले जाकर फोड़ देता है।"
                    "जिसने ध्यान को साध लिया, उसने असल में पूरी सृष्टि के कंट्रोल रूम को हैक (Hack) कर लिया।"
                """.trimIndent(),
                english = """
                    (The Supremacy of Meditation and Other Paths): "The Upanishad rips open the various battle-paths to reach that absolute Supreme Cosmic Truth."
                    "There are certain supremely terrifying, invincible Yogis who, strictly through the atomic detonation of 'Meditation' (Dhyana)..."
                    "Directly 'Witness' (Pashyanti) that explicit Supreme God exactly 'Inside their own Soul' (Atmani), using exclusively their 'Own pure Consciousness' (Atmana)!"
                    "These are the lethal spiritual snipers who use the concentrated laser beam of meditation to drill directly into the chest of God."
                    "Other colossal Yogis weaponize 'Sankhya Yoga' (the brutal sword of analytical cosmic knowledge) to slaughter ignorance and breach the Truth."
                    "And still others burn themselves alive in the blazing furnace of 'Karma Yoga' (fearless, ruthless action with zero desire for biological rewards) to seize God."
                    "Regardless of the weaponized path chosen, the ultimate destination is strictly identical—the most brutal, agonizing death of your own 'Ego'!"
                    "Without assassinating yourself (erasing your pathetic 'I'), absolutely no human can ever approach the undisputed throne of God."
                    "But among all these, 'Meditation' is the fastest, most direct, and most terrifying cosmic rocket that transports a human directly to the epicenter of the universe and detonates him."
                    "He who flawlessly masters Meditation has, in absolute reality, completely hacked the supreme Control Room of the entire creation."
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 19,
                sanskrit = "यस्तद्वेद स वेदवित्... न स पुनरावर्तते न स पुनरावर्तते ॥ १९॥",
                hindi = """
                    (जो इसे जान गया, वह कभी वापस नहीं लौटता): "उपनिषद अपनी सबसे खौफनाक और अंतिम गारंटी की घोषणा करता है।"
                    "जो भी इंसान इस ध्यान के प्रलयंकारी रहस्य और इस असीम परब्रह्म को यथार्थ रूप में 'जान' लेता है (यस्तद्वेद)..."
                    "केवल और केवल वही इंसान इस पूरे ब्रह्मांड में असली 'वेदवित्' (वेदों का असली ज्ञाता और मालिक) है।"
                    "पुस्तकालयों में बैठकर किताबें रटने वाले केवल गधे हैं, असली ज्ञानी वह है जिसने अपने भीतर भगवान का धमाका किया है।"
                    "और जब वह योगी इस परम शून्यता में अपनी आत्मा को मिला देता है..."
                    "तो श्रुति (वेद) पूरी ताक़त से चीखते हुए दो बार कसम खाकर कहती है: 'न स पुनरावर्तते, न स पुनरावर्तते!'"
                    "यानी, 'वह योगी इस सड़ी हुई दुनिया में कभी वापस लौटकर नहीं आता! वह कभी वापस नहीं आता!'"
                    "उसे दोबारा किसी माँ के गर्भ में, खून और कीचड़ के बीच उल्टा नहीं लटकना पड़ता।"
                    "उसे दोबारा बुढ़ापा, बीमारी और मौत का भयानक तमाशा नहीं देखना पड़ता; वह इस नर्क की जेल से हमेशा के लिए भाग (Escape) चुका है।"
                    "वह अजेय, अमर और साक्षात शिव बन चुका है; उसे वापस धरती पर गिराने की औकात ब्रह्मांड के किसी नियम में नहीं है!"
                """.trimIndent(),
                english = """
                    (He Who Knows This, Absolutely Never Returns): "The Upanishad roars its most terrifying, ironclad, absolute cosmic guarantee."
                    "Whosoever human being flawlessly and physically 'Knows' (Yastadveda) this apocalyptic secret of meditation and this infinite Supreme Brahman..."
                    "Strictly and exclusively only that human is the genuine 'Vedavit' (The absolute Knower and Master of the Vedas) in the entire cosmos."
                    "The pathetic fools memorizing books in libraries are mere beasts of burden; the true master is he who has detonated God within his own core."
                    "And when that colossal Yogi violently fuses his soul into this Supreme Void..."
                    "The Shruti (Vedas) screams with maximum apocalyptic authority, swearing twice: 'Na Sa Punaravartate, Na Sa Punaravartate!'"
                    "Meaning, 'That Yogi absolutely NEVER returns to this rotting, biological hell of a world! He ABSOLUTELY NEVER RETURNS!'"
                    "He absolutely never again has to suffer the horrific torture of hanging upside down amidst blood and mud inside a biological mother's womb."
                    "He absolutely never again has to witness the terrifying biological drama of old age, disease, and death; he has permanently, violently escaped this maximum-security prison."
                    "He has mutated into the invincible, immortal Shiva; absolutely no law in the cosmos possesses the authority or capability to ever drag him back to Earth!"
                """.trimIndent()
            ),
            DhyanaShloka(
                id = 20,
                sanskrit = "इति ध्यानबिन्दूपनिषत्... ॐ शान्तिः शान्तिः शान्तिः ॥ २०॥",
                hindi = """
                    (परम समापन और अंतिम शून्यता): "यहीं पर ध्यान का यह सबसे खौफनाक और प्रलयंकारी विज्ञान अपनी पूर्णता को प्राप्त होता है।"
                    "यह 'ध्यान उपनिषद' कोई साधारण किताब नहीं है; यह एक ऐसा ब्रह्मांडीय न्यूक्लियर बम है जो सीधे तुम्हारे मन पर गिरता है।"
                    "जिसने इस ग्रंथ के एक-एक शब्द को अपनी साँसों में उतार लिया, उसके लिए दुनिया के सारे धर्म और सारे मंदिर राख के बराबर हो गए।"
                    "उसने बाहरी दुनिया से अपनी आँखें हमेशा के लिए बंद कर ली हैं और अपने ही भीतर के उस 'एकमात्र सत्य' को खोल लिया है।"
                    "जब इंसान ध्यान की इस आग में जलकर पूरी तरह भस्म हो जाता है, तो जो सन्नाटा पीछे बचता है..."
                    "वही सन्नाटा साक्षात परब्रह्म है। वहाँ न कोई शब्द है, न कोई विचार, और न कोई पहचान।"
                    "यह इंसान का मिटना और भगवान का पैदा होना है; यह जीव का शिव में वह परम विलय है जिसे कोई तोड़ नहीं सकता।"
                    "इस खौफनाक आध्यात्मिक यात्रा का 'द एंड' (The End) केवल और केवल पूर्ण और असीम शून्यता है।"
                    "ॐ शांतिः शांतिः शांतिः! शरीर, मन और आत्मा के हर दर्द की हमेशा के लिए मौत हो गई।"
                    "यहाँ आकर ब्रह्मांड पूरी तरह शांत हो जाता है, और केवल वह एक अमर 'सत्य' हमेशा के लिए अजेय खड़ा रहता है!"
                """.trimIndent(),
                english = """
                    (The Absolute Completion and the Final Void): "Right exactly here, this most terrifying and apocalyptic science of meditation achieves its absolute, flawless completion."
                    "This 'Dhyana Upanishad' is absolutely no ordinary book; it is a literal cosmic nuclear bomb dropped directly onto your biological brain."
                    "He who has injected every single microscopic word of this scripture into his very breath has reduced every religion and temple on Earth to worthless ashes."
                    "He has violently, permanently shut his physical eyes to the external matrix and brutally ripped open the 'Only Absolute Truth' hiding inside his own core."
                    "When the human is completely incinerated and burnt to absolute ashes in this raging fire of meditation, the deafening silence that remains behind..."
                    "That exact silence is explicitly the Supreme Brahman Himself. There is zero sound there, zero thought, and absolutely zero identity."
                    "This is the brutal erasure of the human and the violent birth of God; it is the supreme, indestructible fusion of the mortal into Shiva."
                    "The absolute 'The End' of this terrifying spiritual crusade is strictly and exclusively total, infinite, boundless Nothingness."
                    "OM Peace, Peace, Peace! Every microscopic trace of biological agony in the body, mind, and soul has suffered a permanent, eternal death."
                    "Arriving here, the entire cosmos flatlines into absolute silence, and strictly that One Immortal 'Truth' remains standing flawlessly invincible forever!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DhyanaUpanishadScreen() {
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
                // Validates if the number is between 1 and 20
                if (shlokaNumber != null && shlokaNumber in 1..20) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
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
            itemsIndexed(DhyanaUpanishad.dhyanaShlokasList) { _, shloka ->
                DhyanaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun DhyanaShlokaCard(shloka: DhyanaUpanishad.DhyanaShloka) {
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