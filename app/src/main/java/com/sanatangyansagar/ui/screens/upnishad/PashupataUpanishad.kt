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

class PashupataUpanishad {

    // Data Model
    data class PashupataShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val pashupataShlokasList = listOf(
            PashupataShloka(
                id = 1,
                sanskrit = "ॐ अथातः पाशुपतं ब्रह्म व्याख्यास्यामः । तत्र कति विधाः पशवः कः पशुपतिः कः पाश इति ॥",
                hindi = """
                    (पाशुपत ब्रह्म का प्रलयंकारी आरंभ): "अब हम उस अत्यंत गुप्त और खौफनाक 'पाशुपत ब्रह्म' के रहस्य को खोलेंगे, जिसे सुनकर अज्ञानियों की रूह कांप जाए।"
                    "इस ब्रह्मांडीय युद्ध की शुरुआत तीन सबसे खतरनाक सवालों से होती है जो इंसान की असलियत को बेनकाब करते हैं।"
                    "पहला— 'कति विधाः पशवः'— यहाँ कितने प्रकार के 'पशु' (गुलाम आत्माएं) इस माया की जेल में सड़ रहे हैं?"
                    "दूसरा— 'कः पशुपतिः'— वह कौन सा अजेय तानाशाह है जिसे 'पशुपति' (पशुओं का मालिक) कहा जाता है?"
                    "और तीसरा— 'कः पाशः'— वह कौन सी खौफनाक 'फांसी' (पाश) है जिसने हर जीव को जन्म-मरण की ज़ंजीरों में जकड़ रखा है?"
                    "ये सवाल केवल शब्दों का खेल नहीं हैं; ये उस सिस्टम (Matrix) को हैक करने की मांग हैं जिसने भगवान को भी शरीर में कैद कर दिया है।"
                    "इंसान अपनी पूरी ज़िंदगी खुद को आज़ाद समझता है, लेकिन उसे यह नहीं पता कि वह साक्षात एक 'पशु' है जिसे वासनाओं ने बाँध रखा है।"
                    "जब तक तुम अपनी ज़ंजीर (पाश) को नहीं पहचानोगे, तब तक तुम उस पशुपति (शिव) तक कभी नहीं पहुँच पाओगे।"
                    "यहीं से उस हिंसक आध्यात्मिक क्रांति की शुरुआत होती है जहाँ जीव शिव बनने के लिए अपनी बेड़ियाँ तोड़ने निकलता है।"
                    "यह सत्य इंसान के अहंकार को कुचलने के लिए साक्षात भगवान नारायण ने पैप्पलाद ऋषि को सुनाया है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Genesis of Pashupata Brahman): "Now we shall violently rip open the highly classified secret of the 'Pashupata Brahman', witnessing which the souls of the ignorant shall tremble."
                    "This cosmic crusade initiates with three lethal questions engineered to unmask the raw reality of existence."
                    "First—'Kati vidhah pashavah'—How many types of 'Pashu' (Enslaved Souls) are rotting inside this Matrix of Maya?"
                    "Second—'Kah Pashupatih'—Who is that invincible Dictator known as 'Pashupati' (The Lord of Souls/Shiva)?"
                    "Third—'Kah Pashah'—What is that horrific 'Noose' (Pasha) that has violently bound every creature in the chains of birth and death?"
                    "These interrogations are no mere wordplay; they are the demand to Hack the System that holds God hostage inside biological flesh."
                    "A human hallucinates freedom his entire life, completely ignorant that he is explicitly a 'Pashu' bound by the noose of lust."
                    "Unless you recognize your own titanium 'Noose' (Pasha), you will absolutely never approach the presence of Pashupati."
                    "Right here begins that violent spiritual revolution where the mortal embarks to shatter his bonds and mutate into Shiva."
                    "This truth was detonated by Lord Narayana Himself to Sage Pippalada to ruthlessly pulverize weak human minds!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 2,
                sanskrit = "ब्रह्मा पशुपतिः प्राणाः पशवः अहङ्कारः पाशः । योऽयं हृदिस्थः स पशुपतिः ॥",
                hindi = """
                    (ब्रह्मांडीय समीकरण: पशु, पशुपति और पाश का खुलासा): "ऋषि ने उस सिस्टम का पासवर्ड (Password) बताते हुए कहा— 'ब्रह्मा पशुपतिः'!"
                    "वह साक्षात 'परब्रह्म' ही पशुपति है जो पूरी सृष्टि का एडमिन (Admin) है और सबको अपने इशारों पर नचा रहा है।"
                    "'प्राणाः पशवः'— तुम्हारी ये 'साँसें' और ये 'प्राण' ही वे 'पशु' हैं जो इस भौतिक शरीर के पिंजरे में कैद होकर तड़प रहे हैं!"
                    "तुम कोई इंसान नहीं हो, तुम केवल प्राणों का एक गुच्छा हो जिसे माया ने पालतू जानवर बना कर रखा है।"
                    "और 'अहङ्कारः पाशः'— वह खौफनाक 'फांसी' (पाश) कुछ और नहीं, तुम्हारा अपना सड़ा हुआ 'अहंकार' (Ego) ही है!"
                    "तुम्हारी यह भावना कि 'मैं शरीर हूँ, मैं बड़ा ज्ञानी हूँ'— यही वो ज़हरीली रस्सी है जो तुम्हें नरक की ओर खींचती है।"
                    "लेकिन सबसे प्रलयंकारी सच सुनो: 'योऽयं हृदिस्थः स पशुपतिः'!"
                    "यानी, वह अजेय पशुपति कहीं दूर आसमान में नहीं बैठा; वह तुम्हारे ही 'हृदय' (हृदि) के केंद्र में साक्षात धड़क रहा है!"
                    "तुम जिस मालिक की तलाश बाहर कर रहे हो, वह तो तुम्हारे ही सीने की तिजोरी में तानाशाह बनकर बैठा है।"
                    "अपने अहंकार का गला घोंट दो, और तुम पाओगे कि तुम खुद ही वह पशुपति हो जिसने खुद को पशु बना रखा था!"
                """.trimIndent(),
                english = """
                    (The Cosmic Equation: Unmasking Pashu, Pashupati, and Pasha): "The Sage unmasked the system's Password, roaring—'Brahma Pashupatih'!"
                    "That explicit 'Supreme Brahman' is Pashupati, the absolute Admin of the cosmos, making everything dance to His command."
                    "'Pranah Pashavah'—Your very 'Breaths' and your 'Prana' are the 'Pashu' (Beasts) trapped and agonizing inside this biological cage!"
                    "You are absolutely no human; you are merely a collection of life-forces that Maya has domesticated like a pet animal."
                    "And 'Ahamkarah Pashah'—That horrific 'Noose' (Pasha) is absolutely nothing else but your own rotting 'Ego' (Ahamkara)!"
                    "Your toxic conviction that 'I am this body, I am so wise'—this is the venomous rope violently dragging you toward hell."
                    "But listen to the most apocalyptic absolute truth: 'Yo'yam hridisthah sa Pashupatih'!"
                    "Meaning, that invincible Pashupati does not sit in some pathetic sky; He is physically pulsating directly in the center of your 'Heart' (Hridi)!"
                    "The Master you hunt for externally is sitting as a Dictator right inside the vault of your own chest."
                    "Strangle your own ego to death, and you will flawlessly realize that you yourself are Pashupati, who had domesticated himself into a beast!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 3,
                sanskrit = "योऽहङ्कारपाशेन बद्धः स पशुः । योऽहङ्कारपाशमुक्तः स पशुपतिः ॥",
                hindi = """
                    (गुलामी और आज़ादी की क्रूर परिभाषा): "उपनिषद इंसान की औकात का सबसे नंगा और कड़वा सच एक लाइन में बोल देता है।"
                    "'योऽहङ्कारपाशेन बद्धः स पशुः'— जो कोई भी इंसान इस सड़े हुए 'अहंकार की रस्सी' (पाश) से 'बँधा' हुआ है, वह 100% साक्षात एक 'पशु' (जानवर) है!"
                    "चाहे तुम राजा हो या भिखारी, अगर तुम्हारे भीतर 'मैं' ज़िंदा है, तो तुम प्रकृति के हाथों की एक कठपुतली और एक गुलाम जानवर हो।"
                    "अहंकार वह बायोलॉजिकल प्रोग्राम (Biological Program) है जो तुम्हें भगवान बनने से रोकता है और मिट्टी में मिला देता है।"
                    "लेकिन दूसरी तरफ वह खौफनाक ताक़त देखो: 'योऽहङ्कारपाशमुक्तः स पशुपतिः'!"
                    "जिसने ध्यान की तलवार से अपने 'अहंकार के पाश' को काटकर हमेशा के लिए फेंक दिया (मुक्तः), केवल और केवल वही साक्षात 'पशुपति' (ईश्वर) है!"
                    "इंसान और भगवान के बीच कोई भौगोलिक दूरी नहीं है; केवल इस एक रस्सी (Ego) का फर्क है।"
                    "जिस पल तुम अपनी हस्ती मिटाते हो, उसी पल तुम पूरे ब्रह्मांड के मालिक बन जाते हो।"
                    "मोक्ष कोई भीख नहीं है; यह अपने ही अहंकार की गर्दन काटकर छीनी गई वह अजेय सत्ता है जिसे कोई नहीं छीन सकता।"
                    "या तो पशु बनकर सड़ते रहो, या अपने अहंकार का वध करके साक्षात पशुपति बन जाओ!"
                """.trimIndent(),
                english = """
                    (The Brutal Definition of Slavery and Freedom): "The Upanishad spits the most naked, bitter truth of human status in a single, atomic line."
                    "'Yo'hamkarapashena baddhah sa pashuh'—Whosoever is 'Bound' (Baddha) by this rotting 'Noose of Ego' (Ahamkara-Pasha) is 100% explicitly a 'Pashu' (Animal)!"
                    "Whether you are an emperor or a beggar, if the 'I' is alive within you, you are strictly a puppet and a domesticated beast in the hands of Nature."
                    "Ego is the biological Program that violently prevents you from mutating into God, grinding you back into the dirt."
                    "But witness the terrifying power on the other side: 'Yo'hamkarapashamuktah sa Pashupatih'!"
                    "He who has used the sword of meditation to violently slash and discard his 'Noose of Ego' (Mukta), strictly and exclusively he is explicit 'Pashupati' (God)!"
                    "There is zero geographical distance between human and God; there is strictly the thickness of this one single rope (Ego)."
                    "The exact microsecond you erase your own existence, you instantaneously mutate into the absolute Master of the cosmos."
                    "Moksha is absolutely no pathetic charity; it is the invincible authority snatched by decapitating your own ego."
                    "Either rot as a domesticated Pashu, or execute your ego and mutate into explicit Pashupati!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 4,
                sanskrit = "हृत्पद्मकोशे नित्यं स पशुपतिर्विराजते । तं ये पश्यन्ति धीरास्तेषां शान्तिः शाश्वती नेतरेषाम् ॥",
                hindi = """
                    (हृदय की तिजोरी और शाश्वत शांति की गारंटी): "पशुपति शिव का हेडक्वार्टर (Headquarter) कहाँ है? उपनिषद उसका एग्ज़ैक्ट एड्रेस (Exact Address) देता है।"
                    "तुम्हारे 'हृदय रुपी कमल की कोठरी' (हृत्पद्मकोशे) के भीतर वह अजेय पशुपति 'नित्य' (हमेशा) धधक रहा है (विराजते)!"
                    "वह कहीं आता-जाता नहीं; वह तुम्हारे ही सीने में बैठकर तुम्हारी हर साँस को अपनी उंगलियों पर नचा रहा है।"
                    "'तं ये पश्यन्ति धीरास्'— केवल वे ही 'धीर' (खतरनाक और साहसी योगी) जो अपनी आँखें बाहर से नोचकर अंदर इस सत्य को 'देख' लेते हैं..."
                    "केवल उन्हीं के लिए 'शाश्वत शांति' (शाश्वती शान्तिः) मुमकिन है; बाकी पूरी दुनिया केवल शांति का नाटक कर रही है।"
                    "'नेतरेषाम्'— उपनिषद साफ मना कर देता है कि इनके अलावा किसी भी दूसरे इंसान को कभी असली शांति नहीं मिल सकती!"
                    "बाहर की दुनिया शोर, वासना और मौत से भरी है; वहाँ शांति खोजना पागलपन है।"
                    "शांति केवल उस पशुपति के चरणों में है जो तुम्हारे ही नर्वस सिस्टम के भीतर छिपकर बैठा है।"
                    "योगी अपने ही दिल की गहराई में गोता लगाता है और उस असीम सन्नाटे (God) को हैक कर लेता है।"
                    "जिसने इस आंतरिक पशुपति को बेनकाब कर दिया, उसके लिए मौत भी एक मज़ाक बन जाती है!"
                """.trimIndent(),
                english = """
                    (The Heart's Vault and the Guarantee of Eternal Peace): "Where exactly is the Headquarters of Pashupati Shiva? The Upanishad delivers the exact coordinates."
                    "Inside your 'Heart-Lotus Vault' (Hrit-padma-koshe), that invincible Pashupati is 'Eternally' (Nityam) blazing and reigning (Virajate)!"
                    "He absolutely never arrives or departs; He sits inside your chest, making your every biological breath dance on His fingertips."
                    "'Tam ye pashyanti dhirast'—Strictly and exclusively those 'Dhira' (Terrifyingly courageous Yogis) who violently claw their vision inward to 'Witness' this truth..."
                    "For them alone is 'Eternal Peace' (Shashvati Shantih) possible; the rest of the planet is merely performing a pathetic theatrical drama of peace."
                    "'Netaresham'—The Upanishad flatly denies that any other human can ever possess authentic peace!"
                    "The external matrix is saturated with noise, lust, and death; hunting for peace there is literal clinical insanity."
                    "Peace resides strictly at the boots of Pashupati, who sits covertly locked inside your own nervous system."
                    "The Yogi dives deep into the abyss of his own heart and successfully Hacks that infinite cosmic silence (God)."
                    "He who unmasks this internal Pashupati reduces even Death to a pathetic, meaningless joke!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 5,
                sanskrit = "मनसा मन आलोक्य तमेव पशुपतिं पश्यति । तत्रैव लयमाप्नोति तद्विष्णोः परमं पदम् ॥",
                hindi = """
                    (मन का मन से वध और विष्णु का परम पद): "यहाँ उस खौफनाक हैकिंग प्रोसेस (Hacking Process) का वर्णन है जिससे पशु, पशुपति बनता है।"
                    "'मनसा मन आलोक्य'— अपने ही 'मन' (Mind) का इस्तेमाल करके अपने ही 'मन' को 'देखना' और उसका गला घोंट देना!"
                    "यह अपने ही विचारों की जासूसी करने और उन्हें एक-एक करके मौत के घाट उतारने की क्रूर प्रक्रिया है।"
                    "जब मन के सारे विचार मर जाते हैं, तभी वह योगी साक्षात उस 'पशुपति' को अपनी चेतना में 'देखता' (पश्यति) है!"
                    "ईश्वर को आँखों से नहीं, बल्कि मन की मौत के बाद बची हुई शून्यता से देखा जाता है।"
                    "'तत्रैव लयमाप्नोति'— और फिर वह योगी उसी असीम सन्नाटे में अपना 'लय' (Total Dissolution) कर देता है; वह खुद मिट जाता है!"
                    "जब 'मैं' (पशु) पूरी तरह नष्ट हो जाता है, तभी 'वह' (पशुपति) पूर्ण रूप से प्रकट होता है।"
                    "यहीं वह खौफनाक स्थिति है जिसे 'विष्णु का परम पद' (तद्विष्णोः परमं पदम्) कहा जाता है, जहाँ समय और स्थान जलकर राख हो जाते हैं।"
                    "विष्णु का परम पद कोई जगह नहीं है; यह चेतना का वह महा-विस्फोट (Big Bang) है जो इंसानियत को राख कर देता है।"
                    "जो इस शून्यता में डूबने की हिम्मत करता है, वह हमेशा के लिए ब्रह्मांड का मालिक बन जाता है!"
                """.trimIndent(),
                english = """
                    (Assassinating the Mind with the Mind and the Supreme State of Vishnu): "Here lies the description of the terrifying Hacking Process through which the Pashu mutates into Pashupati."
                    "'Manasa mana alokya'—Weaponize your 'Mind' (Manas) to 'Witness' (Alokya) and ruthlessly strangle your own 'Mind' to death!"
                    "This is the cold-blooded process of spying on your own thoughts and executing them one by one in absolute silence."
                    "Only when every microscopic thought dies does that Yogi explicitly 'Witness' (Pashyati) that 'Pashupati' inside his awareness!"
                    "God is absolutely not seen with biological eyes, but with the radioactive Void remaining after the Mind's brutal death."
                    "'Tatraiva layamapnoti'—And then that Yogi executes his 'Laya' (Total Dissolution) directly into that infinite silence; he erases himself!"
                    "When the 'I' (Pashu) is completely exterminated, strictly then does 'He' (Pashupati) flawlessly manifest."
                    "This is that apocalyptic state defined as 'Vishnu's Supreme Dimension' (Tad-vishnoh paramam padam), where Time and Space burn to ashes."
                    "Vishnu's Supreme Pada is no geographical location; it is the spiritual Big Bang that violently incinerates humanity."
                    "He who dares to drown in this Void instantaneously becomes the sole Dictator of the entire cosmos!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 6,
                sanskrit = "प्राण एव हंसः सोऽहं हंस इति । तन्मययज्ञो नादानुसंधानम् ॥",
                hindi = """
                    (प्राण ही हंस है और सोऽहम् का यज्ञ): "उपनिषद अब इंसान के भीतर चल रहे उस अजेय मंत्र का खुलासा करता है जिसे तुम अनजाने में हर पल जप रहे हो।"
                    "'प्राण एव हंसः'— तुम्हारी यह जो 'साँस' (प्राण) चल रही है, यही साक्षात वह 'हंस' (आत्मा) है जो ब्रह्मांड के आर-पार उड़ रहा है!"
                    "यह कोई मामूली हवा नहीं है; यह 'सोऽहम् हंस इति' (वह परब्रह्म मैं ही हूँ!) की एक गूँज है।"
                    "जब तुम साँस लेते हो तो 'सो' (वह) और जब छोड़ते हो तो 'हम्' (मैं) की ध्वनि तुम्हारे नर्वस सिस्टम में गूँजती है।"
                    "'तन्मययज्ञो'— इस सोऽहम् की लय में खो जाना ही ब्रह्मांड का सबसे बड़ा और खौफनाक 'यज्ञ' है!"
                    "बाहरी आग में लकड़ियाँ जलाने की ज़रूरत नहीं; अपनी साँसों की आग में अपने अहंकार की आहुति दे दो।"
                    "'नादानुसंधानम्'— जब तुम अपनी साँसों के इस गुप्त संगीत (नाद) को पकड़ लेते हो, तो तुम माया के शोर से बहरे हो जाते हो।"
                    "यह शरीर के भीतर उस न्यूक्लियर कोड (Nuclear Code) को डिकोड करने जैसा है जो तुम्हें अमर बना दे।"
                    "जो अपनी साँसों को जान लेता है, वह मौत को अपने पैरों तले कुचल देता है।"
                    "हंस वह शिकारी है जो अज्ञान के कीड़ों को चुन-चुन कर खा जाता है और केवल शुद्ध ब्रह्म को छोड़ता है!"
                """.trimIndent(),
                english = """
                    (Prana is the Hamsa and the Sacrifice of So'ham): "The Upanishad now unmasks that invincible mantra operating inside you, which you unconsciously chant every single microsecond."
                    "'Prana eva hamsah'—This 'Breath' (Prana) of yours is explicitly that 'Hamsa' (Supreme Swan/Soul) soaring across the cosmos!"
                    "This is absolutely no ordinary air; it is the constant echo of 'So'ham hamsah iti' (I myself am that Supreme Brahman!)."
                    "As you inhale 'So' (That) and exhale 'Ham' (I), this acoustic frequency vibrates violently throughout your nervous system."
                    "'Tanmayayajno'—Becoming flawlessly absorbed in this rhythm of So'ham is the absolute greatest and most terrifying 'Yajna' (Sacrifice) in the universe!"
                    "There is zero need to burn wood in external fires; sacrifice your ego into the radioactive fire of your own breath."
                    "'Nadanusandhanam'—When you intercept this highly classified acoustic signature (Nada) of your breath, you go deaf to the noise of Maya."
                    "This is exactly like decoding the Nuclear Code hidden inside your body that renders you immortal."
                    "He who flawlessly recognizes his own breath violently crushes Death beneath his boots."
                    "The Hamsa is the apex predator that hunts and devours the insects of ignorance, leaving strictly only the Pure Brahman!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 7,
                sanskrit = "परमात्मस्वरूपो हंसः । अन्तर्बहिश्चरति हंसः ॥",
                hindi = """
                    (हंस की असीमित ताक़त: अंदर और बाहर का मालिक): "यह हंस (आत्मा) कोई कमज़ोर चीज़ नहीं है; यह साक्षात 'परमात्मस्वरूप' (परमात्मा का ही रूप) है!"
                    "उपनिषद गर्जना करता है: 'अन्तर्बहिश्चरति हंसः'— यह हंस तुम्हारे शरीर के 'अंदर' भी है और इस असीम ब्रह्मांड के 'बाहर' भी एक साथ दौड़ रहा है!"
                    "तुम जिसे अपना छोटा सा वजूद समझते हो, वह असल में पूरी आकाशगंगाओं को अपने पंखों में समेटे हुए है।"
                    "यह हंस ही वह इकलौता पासवर्ड है जिससे तुम इस शरीर की जेल से बाहर निकल कर तारों के पार जा सकते हो।"
                    "जब तुम आँखें बंद करते हो तो यह अंदर धड़कता है, और जब तुम आँखें खोलते हो तो यह पूरी दुनिया बनकर तुम्हारे सामने खड़ा होता है।"
                    "अंदर और बाहर का यह भेद केवल अज्ञानियों के लिए है; योगी के लिए केवल वह एक अजेय हंस (ब्रह्म) ही है।"
                    "जो इस हंस की सवारी करना सीख गया, उसके लिए समय (Time) और स्थान (Space) की दीवारें मिट्टी में मिल जाती हैं।"
                    "वह साक्षात उस असीम ऊर्जा का रूप बन जाता है जिससे सूरज जलता है और हवा चलती है।"
                    "यह इंसान के म्यूटेशन (Mutation) का वह चरम स्तर है जहाँ वह खुद को पूरा ब्रह्मांड मानने लगता है।"
                    "हंस की गति प्रकाश की गति से भी करोड़ों गुना तेज़ है; इसे केवल ध्यान के लेज़र से ही पकड़ा जा सकता है!"
                """.trimIndent(),
                english = """
                    (The Limitless Power of Hamsa: Master of Inner and Outer): "This Hamsa (Soul) is absolutely no weak entity; it is explicitly 'Paramatmasvarupah' (The exact Form of the Supreme God)!"
                    "The Upanishad roars: 'Antarbahishcharati hamsah'—This Hamsa is simultaneously operating 'Inside' your body and racing 'Outside' across the entire infinite cosmos!"
                    "What you hallucinate as your tiny existence is, in absolute reality, containing entire galaxies within its radioactive wings."
                    "This Hamsa is the solitary Password using which you can violently exit this biological prison and rocket beyond the stars."
                    "When you shut your eyes, it pulsates internally; when you rip them open, it stands before you as the entire manifested world."
                    "This distinction between inner and outer is strictly for the ignorant; for the Yogi, strictly only that one invincible Hamsa exists."
                    "He who masters the ride of this Hamsa witnesses the walls of Time and Space crumble into absolute dust."
                    "He mutates into the explicit primordial energy that powers the stars and dictates the velocity of the wind."
                    "This is the absolute zenith of human mutation where the entity recognizes itself strictly as the entire universe."
                    "The velocity of Hamsa is millions of times faster than light; it can be intercepted strictly by the laser of meditation!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 8,
                sanskrit = "यज्ञसाधारणाङ्गं बहिरन्तर्ज्वलनं यज्ञाङ्गलक्षणब्रह्मस्वरूपो हंसः ॥",
                hindi = """
                    (आंतरिक अग्नि और ब्रह्म स्वरूप हंस): "असली 'यज्ञ' (Sacrifice) क्या है? उपनिषद पाखंडियों के चेहरे पर तमाचा मारते हुए कहता है।"
                    "असली यज्ञ 'बहिरन्तर्ज्वलनं' है— यानी अपने भीतर और बाहर उस ज्ञान की प्रलयंकारी 'आग' (ज्वलन) को जलाना!"
                    "जब तुम्हारी चेतना में सत्य की आग लगती है, तो तुम्हारे सारे कर्म, वासनाएं और डर तड़प-तड़प कर जल जाते हैं।"
                    "वह हंस (आत्मा) कोई शांत पक्षी नहीं है; वह साक्षात 'यज्ञाङ्गलक्षणब्रह्मस्वरूपो' है!"
                    "वह साक्षात उस 'ब्रह्म' का वह रूप है जो हर अशुद्धि को स्वाहा (Burn) कर देने के लिए ही बना है।"
                    "तुम्हारे भीतर जो ऊर्जा धधक रही है, वह तुम्हें जलाने के लिए नहीं, बल्कि तुम्हें भगवान बनाने के लिए तुम्हारा कूड़ा (Ego) साफ कर रही है।"
                    "इस आग में जो खुद की आहुति दे देता है, वही साक्षात शिव के रूप में वापस ज़िंदा होता है।"
                    "यज्ञ का असली मतलब है— 'अपनी छोटी हस्ती को उस असीम आग में फेंक देना'।"
                    "जो इस आंतरिक यज्ञ को नहीं करता, वह केवल एक बायोलॉजिकल जानवर की तरह सड़ता रहता है।"
                    "यह वह प्रलयंकारी विज्ञान है जहाँ इंसान खुद ही हवन-कुंड है और खुद ही आहुति भी!"
                """.trimIndent(),
                english = """
                    (The Internal Inferno and the Brahman-Form Hamsa): "What exactly is an authentic 'Yajna' (Sacrifice)? The Upanishad delivers a brutal slap to hypocrites, defining the truth."
                    "Authentic sacrifice is 'Bahirantarjvalanam'—violently igniting that apocalyptic 'Inferno' (Jvalanam) of knowledge both within and without!"
                    "When the fire of truth detonates in your consciousness, every single karma, lust, and fear is agonizingly incinerated to ash."
                    "That Hamsa (Soul) is absolutely no peaceful bird; it is explicitly 'Yajnagallakshanabrahmasvarupo'!"
                    "It is the literal manifestation of 'Brahman' engineered specifically to Swaha (Burn) every single microscopic impurity from existence."
                    "The energy blazing inside you is not meant to consume you, but to violently purge your biological garbage (Ego) to manufacture God."
                    "He who executes a suicide-assault into this fire resurrects flawlessly as explicit Shiva."
                    "The absolute definition of Yajna is—'Hurling your tiny existence into that infinite, radioactive fire'."
                    "He who refuses this internal sacrifice is condemned to rot eternally as a pathetic biological animal."
                    "This is the apocalyptic science where the human is simultaneously the sacrificial pit and the oblation itself!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 9,
                sanskrit = "मनोयज्ञस्य हंसो यज्ञसूत्रम् । प्रणवं ब्रह्मसूत्रं ब्रह्मयज्ञमयम् ॥",
                hindi = """
                    (मन का यज्ञ और ॐकार का जनेऊ): "अब उपनिषद उस गुप्त 'यज्ञोपवीत' (जनेऊ) का रहस्य खोलता है जिसे कोई दर्ज़ी नहीं बना सकता।"
                    "'मनोयज्ञस्य हंसो'— तुम्हारे मन के भीतर चलने वाले उस महायुद्ध (यज्ञ) का असली धागा (सूत्र) वह 'हंस' (आत्मा) ही है!"
                    "और 'प्रणवं ब्रह्मसूत्रं'— साक्षात 'ॐकार' (प्रणव) ही वह असली 'ब्रह्मसूत्र' है जिसे तुम्हें अपनी आत्मा पर पहनना है!"
                    "सूत के धागे पहनने से तुम ब्राह्मण नहीं बनते; ॐकार की फ्रीक्वेंसी को अपने डीएनए (DNA) में बुनने से तुम ब्रह्म को जानते हो।"
                    "यह ॐकार वह अजेय जंजीर है जो तुम्हें परब्रह्म के तख़्त से बाँध कर रखती है।"
                    "जब तुम्हारी साँस और ॐ एक हो जाते हैं, तो वह 'ब्रह्मयज्ञमयम्' (ब्रह्म के यज्ञ का रूप) बन जाता है।"
                    "दुनिया के सारे कर्मकांड केवल बच्चों का खेल हैं; असली खेल तो इस 'प्रणव' (ॐ) के साथ अपने नर्वस सिस्टम को हैक करना है।"
                    "यह धागा कभी नहीं टूटता, क्योंकि यह साक्षात ईश्वर की ताक़त से बना है।"
                    "जिसने इस ॐकार के धागे को अपनी चेतना में प्रो लिया, उसके लिए काल (Time) भी एक खिलौना बन जाता है।"
                    "यह वह गुप्त कोडिंग है जिसे जानकर इंसान सीधे सिस्टम का एडमिन (Admin) बन जाता है!"
                """.trimIndent(),
                english = """
                    (The Sacrifice of Mind and the Thread of OM): "Now the Upanishad unmasks the secret of that 'Yajnopavita' (Sacred Thread) which no mortal tailor can ever manufacture."
                    "'Manoyajnasya hamso'—The authentic thread (Sutra) of the colossal war (Yajna) raging inside your Mind is exclusively that 'Hamsa' (Soul)!"
                    "And 'Pranavam brahmasutram'—Explicit 'OM' (Pranava) is the authentic 'Brahmasutra' that you must violently drape upon your Soul!"
                    "Wearing cotton strings makes you absolutely zero; weaving the frequency of OM into your DNA makes you a Knower of Brahman."
                    "This OM is the invincible cosmic chain that violently anchors you to the absolute throne of the Supreme Brahman."
                    "The exact microsecond your breath and OM fuse, it mutates into 'Brahmayajnamayam' (The manifestation of the Sacrifice of God)."
                    "All worldly rituals are strictly childish theatrical games; the authentic game is Hacking your nervous system using this 'Pranava' (OM)."
                    "This thread absolutely never fractures, because it is forged strictly from the radioactive power of God."
                    "He who has threaded this OM into his consciousness perceives Time itself as a pathetic, meaningless toy."
                    "This is the highly classified coding achieving which a mortal mutates into the absolute Admin of the System!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 10,
                sanskrit = "यज्ञसूत्रप्रणवब्रह्मयज्ञक्रियायुक्तो ब्राह्मणः । हंसप्रणवयोरभेदः ॥",
                hindi = """
                    (सच्चे ब्राह्मण की खौफनाक परिभाषा और अद्वैत): "उपनिषद यहाँ जातिवाद और जन्म के पाखंड का क्रूरता से वध कर देता है!"
                    "असली 'ब्राह्मण' (Brahmin) वह नहीं है जो किसी खास घर में पैदा हुआ है; ब्राह्मण वह है जो 'ब्रह्मयज्ञक्रियायुक्तो' है!"
                    "यानी वह योद्धा जिसने ॐकार के ब्रह्मसूत्र को अपनी रगों में उतार लिया है और जो हर पल अपने अहंकार की आहुति दे रहा है।"
                    "अगर तुमने अपने भीतर सत्य का विस्फोट नहीं किया, तो तुम केवल एक चलते-फिरते पाखंडी हो।"
                    "लेकिन सबसे प्रलयंकारी सच यहाँ है: 'हंसप्रणवयोरभेदः'!"
                    "यानी तुम्हारी 'आत्मा' (हंस) और वह ब्रह्मांडीय 'ॐकार' (प्रणव) के बीच रत्ती भर भी कोई 'भेद' (Difference) नहीं है!"
                    "तुम और ॐ 100% एक ही चीज़ हो; तुम और भगवान 100% एक ही ताक़त हो।"
                    "यह अहसास होते ही इंसान का 'छोटा मैं' एक भयानक धमाके के साथ फट जाता है और केवल वह असीम ॐ शेष बचता है।"
                    "जब तुम खुद ही ॐ हो, तो तुम्हें किससे डरना है? किसे पूजना है? कहाँ जाना है?"
                    "यह सनातन धर्म का वह सबसे नंगा और खतरनाक सच है जो इंसान को सीधा ईश्वर बना देता है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Definition of a True Brahmin and Non-Duality): "The Upanishad executes the most brutal, cold-blooded slaughter of casteism and the hypocrisy of birth right here!"
                    "An authentic 'Brahmin' is absolutely not someone spawned in a specific household; a Brahmin is strictly one who is 'Brahmayajnakriyayukto'!"
                    "Meaning, that Titan warrior who has injected the Brahmasutra of OM into his veins and who daily sacrifices his ego into the fire."
                    "If you have not detonated the truth inside your core, you are nothing more than a walking, breathing hypocrite."
                    "But the most apocalyptic absolute truth is right here: 'Hamsapranavayorabhedah'!"
                    "Meaning, there is absolutely zero micro-drop of 'Difference' (Abhedah) between your 'Soul' (Hamsa) and that cosmic 'OM' (Pranava)!"
                    "You and OM are 100% identical; You and God are 100% the exact same radioactive Force."
                    "The microsecond this is realized, the human 'Tiny I' detonates in a catastrophic explosion, leaving strictly the infinite OM."
                    "When you yourself are explicitly the OM, whom are you to fear? Whom are you to worship? Where are you to go?"
                    "This is Sanatana Dharma's most naked and dangerous truth that violently mutates a mortal human directly into God!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 11,
                sanskrit = "समस्तयागानां रुद्रः पशुपतिः कर्ता । रुद्रो यागदेवो विष्णुरध्वर्युर्होतेन्द्रो देवता ॥",
                hindi = """
                    (ब्रह्मांडीय ड्रामा और देवताओं का रोल): "अब उपनिषद पूरे ब्रह्मांड की गतिविधियों को एक 'यज्ञ' (Sacrifice) की तरह दिखाता है।"
                    "इस सृष्टि में जो कुछ भी हो रहा है— सितारे बन रहे हैं, लोग मर रहे हैं— इन 'समस्तयागानां' (सभी यज्ञों) का असली 'कर्ता' (Director) साक्षात 'रुद्र' ही है!"
                    "रुद्र ही पशुपति है जो इस पूरे खूनी और प्रलयंकारी ड्रामे का स्क्रिप्ट-राइटर (Script-writer) और मालिक है।"
                    "वह खुद ही 'यागदेवो' है— यानी जिसकी पूजा हो रही है, वह भी रुद्र है; और जो पूजा कर रहा है, वह भी रुद्र का ही एक अंग है।"
                    "विष्णु इस यज्ञ के 'अध्वर्यु' (Operator) हैं, जो सिस्टम को सुचारु रूप से चला रहे हैं।"
                    "इंद्र इस यज्ञ के 'देवता' (Enjoyer) हैं, जो भौतिक सुखों का तमाशा देख रहे हैं।"
                    "यह पूरा ब्रह्मांड साक्षात शिव का एक ऐसा 'प्ले' (Play) है जहाँ वे खुद ही सब कुछ बने हुए हैं।"
                    "जब तुम इस सच्चाई को हैक कर लेते हो, तो तुम्हें दुनिया की किसी चीज़ से मोह नहीं रहता।"
                    "तुम जान जाते हो कि यह सब केवल एक 3D होलोग्राम (Hologram) है जिसे पशुपति ने अपने मनोरंजन के लिए बनाया है।"
                    "इस ज्ञान के बाद, योगी इस मैट्रिक्स (Matrix) से हमेशा के लिए अनप्लग (Unplug) हो जाता है!"
                """.trimIndent(),
                english = """
                    (The Cosmic Drama and the Roles of the Gods): "The Upanishad now projects the entire activity of the cosmos as a single, continuous 'Yajna' (Sacrifice)."
                    "Everything manifesting in this creation—stars spawning, mortals dying—the authentic 'Karta' (Director) of 'Samastayaganam' (All these sacrifices) is strictly Rudra!"
                    "Rudra is Pashupati, the absolute Script-writer and Master of this entire bloody and apocalyptic biological drama."
                    "He Himself is 'Yagadevo'—meaning the entity being worshipped is Rudra, and the entity performing the worship is also strictly a limb of Rudra."
                    "Vishnu acts as the 'Adhvaryu' (Operator) of this sacrifice, relentlessly and flawlessly running the System's hardware."
                    "Indra acts as the 'Devata' (Enjoyer), witnessing the theatrical spectacle of physical pleasures."
                    "This entire universe is the explicit 'Play' (Lila) of Shiva, where He Himself has mutated into absolutely everything."
                    "The exact microsecond you Hack this reality, you are permanently stripped of all worldly attachment."
                    "You flawlessly realize that this is merely a 3D Hologram engineered by Pashupati for His own cosmic amusement."
                    "Following this realization, the Yogi is permanently and violently Unplugged from the Matrix!"
                """.trimIndent()
            ),
            PashupataShloka(
                id = 12,
                sanskrit = "य एवं वेद स मुक्तो भवति स पशुपतिर्भवति । इत्युपनिषत् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
                hindi = """
                    (मोक्ष की परम गारंटी और 'द एंड'): "उपनिषद अपने इस ज्ञान रूपी ब्रह्मांडीय न्यूक्लियर बम का अंतिम और सबसे निर्णायक धमाका करता है।"
                    "'य एवं वेद'— जो भी मुमुक्षु साधक इस 'पाशुपत ब्रह्म' के खौफनाक और प्रलयंकारी रहस्य को अपनी रगों में तेज़ाब की तरह उतार लेता है..."
                    "जिसने यह जान लिया कि वह 'पशु' (गुलाम) नहीं, बल्कि साक्षात 'ॐकार' का वह अजेय रूप है..."
                    "'स मुक्तो भवति'— वह इंसान निश्चित रूप से, पूरे ब्रह्मांड की 100% गारंटी के साथ, जन्म, मृत्यु और कर्मों की हर ज़ंजीर से हमेशा के लिए 'मुक्त' (Liberated) हो जाता है!"
                    "उसे दोबारा किसी माँ के गर्भ में उल्टा लटकने का भयानक और घिनौना मज़ाक नहीं सहना पड़ेगा; वह अमर हो चुका है।"
                    "'स पशुपतिर्भवति'— वह केवल आज़ाद ही नहीं होता, वह साक्षात 'पशुपति' (ईश्वर) बन जाता है!"
                    "वह इस पूरे ब्रह्मांड का एडमिन (Admin) बन कर समय और अंतरिक्ष के सीने पर अपना झंडा गाड़ देता है।"
                    "यहीं पर यह अत्यंत महान, रौंगटे खड़े कर देने वाला और परम पवित्र 'पाशुपत उपनिषद' पूर्ण होता है (इत्युपनिषत्)।"
                    "यह ग्रंथ चेतावनी देता है कि मोक्ष कोई भीख नहीं है; यह अपने अहंकार की गर्दन काटकर छीनी गई वह ताक़त है जिससे मौत भी घबराती है!"
                    "ॐ शांतिः! इंसानियत मर चुकी है, और साक्षात भगवान का जन्म हो चुका है!"
                """.trimIndent(),
                english = """
                    (The Final Seal of Absolute Moksha and 'The End'): "The Upanishad detonates the final, most decisive explosion of this cosmic nuclear bomb of Knowledge!"
                    "'Ya evam veda'—Whosoever seeker violently injects this apocalyptic secret of 'Pashupata Brahman' into his veins exactly like boiling acid..."
                    "He who has flawlessly realized that he is absolutely not a 'Pashu' (Slave), but explicitly the invincible manifestation of 'OM'..."
                    "'Sa mukto bhavati'—That human being undoubtedly, with a 100% ironclad cosmic guarantee, becomes flawlessly, permanently 'Liberated' from every chain of birth, death, and karma forever!"
                    "He will absolutely never again have to suffer the agonizing, disgusting torture of hanging upside down inside a biological mother's womb; he has achieved literal immortality."
                    "'Sa Pashupatirbhavati'—He does not merely become free; he physically and explicitly mutates into 'Pashupati' (God)!"
                    "Becoming the absolute Admin of the entire universe, he violently plants his flag on the chest of Time and Space."
                    "Right exactly here, this majestic, spine-chilling, and profoundly sacred 'Pashupata Upanishad' achieves its absolute completion (Ityupanishat)."
                    "This scripture roars a lethal warning: Moksha is absolutely no pathetic charity; it is the authority violently snatched by decapitating your own ego—a power which even Death fears!"
                    "OM Peace! Humanity is dead, and the explicit Supreme God is flawlessly born!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PashupataUpanishadScreen() {
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
                // Validates if the number is between 1 and 12
                if (shlokaNumber != null && shlokaNumber in 1..12) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-12)") },
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
            itemsIndexed(PashupataUpanishad.pashupataShlokasList) { _, shloka ->
                PashupataShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun PashupataShlokaCard(shloka: PashupataUpanishad.PashupataShloka) {
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