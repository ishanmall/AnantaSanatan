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

class AkshiUpanishad {

    // Data Model
    data class AkshiShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val akshiShlokasList = listOf(
            AkshiShloka(
                id = 1,
                sanskrit = "ॐ सह नाववतु । सह नौ भुनक्तु । सह वीर्यं करवावहै । तेजस्वि नावधीतमस्तु मा विद्विषावहै ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
                hindi = """
                    (ब्रह्मांडीय युद्ध का शांति मंत्र): "यह उपनिषद सनातन धर्म के सबसे खौफनाक ज्ञान का दरवाज़ा है, इसलिए यह एक प्रलयंकारी शांति मंत्र से शुरू होता है।"
                    "हे परब्रह्म! हम दोनों (गुरु और शिष्य) की एक साथ, एक खूँखार ढाल की तरह इस ब्रह्मांडीय युद्ध में रक्षा करें।"
                    "हम दोनों एक साथ इस असीम और रेडियोएक्टिव (Radioactive) ज्ञान रुपी ऊर्जा को निगलें और हज़म करें।"
                    "हम दोनों एक साथ मिलकर उस अजेय और खौफनाक ब्रह्मांडीय ताक़त (वीर्यं) को अपने भीतर पैदा करें!"
                    "हमारा अध्ययन और यह परम ज्ञान सूरज की तरह धधकता हुआ और इतना प्रलयंकारी हो कि अज्ञान जलकर राख हो जाए।"
                    "हमारे बीच कभी भी रत्ती भर नफरत या द्वेष पैदा न हो; हम एक ही लक्ष्य (अहंकार की मौत) के लिए लड़ें।"
                    "इस ज्ञान को बर्दाश्त करना कमज़ोरों के बस की बात नहीं है; इसके लिए दिमाग का फौलाद होना ज़रूरी है।"
                    "गुरु एक स्नाइपर (Sniper) की तरह शिष्य के अहंकार के ठीक बीचों-बीच निशाना लगाता है।"
                    "ॐ! मेरे शरीर, मन और आत्मा के तीनों खौफनाक तापों की हमेशा-हमेशा के लिए मौत हो जाए।"
                    "यह शांति पाठ इस बात का ऐलान है कि माया (Matrix) के खिलाफ अब अंतिम युद्ध शुरू हो चुका है!"
                """.trimIndent(),
                english = """
                    (The Peace Invocation of the Cosmic War): "This Upanishad is the gateway to Sanatana Dharma's most terrifying knowledge, thus detonating with an apocalyptic peace mantra."
                    "O Supreme Brahman! Violently protect both of us (Master and Disciple) together like an impenetrable titanium shield in this cosmic warfare."
                    "May we together swallow and flawlessly digest this infinite, radioactive energy of absolute cosmic wisdom."
                    "May we violently generate and weaponize that invincible, terrifying cosmic power (Viryam) together directly within our cores!"
                    "May our study and this supreme knowledge blaze like a catastrophic sun, completely incinerating all ignorance into absolute dust."
                    "May there absolutely never breed a micro-drop of hatred between us; we fight strictly for one singular target—the assassination of the ego."
                    "Enduring this apocalyptic knowledge is absolutely not for weak mortals; it requires a brain forged of indestructible steel."
                    "The Master acts as a lethal sniper, aiming his crosshairs directly at the dead-center of the disciple's pathetic ego."
                    "OM! May the three terrifying miseries of my physical body, biological mind, and soul suffer a brutal, permanent death."
                    "This peace invocation is the ultimate cosmic declaration that the final war against the Matrix of Maya has now officially begun!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 2,
                sanskrit = "अथ साङ्कृतिर्भगवन्तमादित्यमुपसमेत्य पप्रच्छ भो भगवन् चाक्षुषीं विद्यां मे ब्रूहीति ॥ २॥",
                hindi = """
                    (सांकृति का दुस्साहस और ब्रह्मांडीय दृष्टि की मांग): "इस उपनिषद की शुरुआत किसी इंसान से नहीं, साक्षात सूरज (आदित्य) और महर्षि सांकृति के टकराव से होती है।"
                    "महर्षि सांकृति ने सीधे आसमान को चीरते हुए उस प्रलयंकारी और धधकते हुए 'भगवान सूर्य' (आदित्य) के सामने जाकर एक भयानक सवाल पूछा।"
                    "उन्होंने कहा: 'हे ब्रह्मांड को अपनी आग से ज़िंदा रखने वाले भगवन्! मुझे वह परम गुप्त 'चाक्षुषी विद्या' (The Cosmic Vision) दीजिए!'"
                    "'मुझे वह खौफनाक दृष्टि (आँख) चाहिए जिससे मैं इस माया के झूठे मैट्रिक्स के आर-पार देख सकूँ!'"
                    "इंसान की यह चमड़े की आँखें केवल इस सड़ी हुई भौतिक दुनिया को देखती हैं; सांकृति ने इस जैविक दृष्टि (Biological sight) को लात मार दी।"
                    "वे भगवान सूर्य से वह 'तीसरी आँख' मांग रहे थे जो अज्ञान के अँधेरे को एक सेकंड में जलाकर राख कर दे।"
                    "यह कोई साधारण प्रार्थना नहीं थी; यह देवताओं के सबसे बड़े रहस्य को छीन लेने का खौफनाक दुस्साहस था।"
                    "जब तक इंसान अपनी इन चमड़े की आँखों का गुलाम है, वह एक जानवर की तरह अंधा होकर इस दुनिया में भटकता रहेगा।"
                    "असली दुनिया वह है जो इन आँखों के बंद होने के बाद दिखाई देती है; और सांकृति उसी दुनिया का कोड (Code) मांग रहे थे।"
                    "भगवान सूर्य ने इस दुस्साहस को देखकर उस महा-विस्फोटक ज्ञान को खोलना शुरू किया!"
                """.trimIndent(),
                english = """
                    (Sankriti's Audacity and the Demand for Cosmic Vision): "This Upanishad detonates not with a mortal, but with the direct confrontation between Maharishi Sankriti and the literal Sun (Aditya)."
                    "Violently tearing through the sky, Maharishi Sankriti approached the apocalyptic, blazing 'Lord Surya' and launched a terrifying demand."
                    "He roared: 'O Lord who keeps the cosmos alive with your radioactive fire! Hand over that highly classified 'Chakshushi Vidya' (The Supreme Cosmic Vision) to me!'"
                    "'I demand that terrifying eyesight which can violently pierce straight through this fake Matrix of Maya!'"
                    "Humanity's pathetic leather eyes merely perceive this rotting physical world; Sankriti violently kicked away this biological sight."
                    "He was directly demanding from the Sun God that 'Third Eye' which instantaneously incinerates the darkness of ignorance to ashes in a microsecond."
                    "This was absolutely no pathetic prayer; it was the terrifying audacity to hijack the greatest classified secret of the gods."
                    "As long as a human remains a slave to his physical eyeballs, he will wander blindly in this universe exactly like a pathetic animal."
                    "The absolute reality is what is witnessed only after these biological eyes are brutally shut; Sankriti demanded the exact Code to that reality."
                    "Witnessing this colossal audacity, the Sun God began detonating the most highly explosive knowledge in existence!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 3,
                sanskrit = "तस्मै स होवाचादित्यश्चाक्षुषीं विद्याम्... चक्षुरोगोपशमनीम् ॥ ३॥",
                hindi = """
                    (सूर्य का उत्तर और आँखों के रोगों का विनाश): "महर्षि के उस प्रलयंकारी प्रश्न को सुनकर साक्षात सूर्य भगवान (आदित्य) ने वह गुप्त रहस्य खोल दिया।"
                    "उन्होंने उस 'चाक्षुषी विद्या' का ज्ञान दिया, जो इंसान के भौतिक और आध्यात्मिक, दोनों तरह के 'अंधेपन' (चक्षुरोग) का क्रूरता से वध कर देती है।"
                    "सूर्य कहते हैं: 'यह विद्या कोई साधारण दवा नहीं है; यह एक ऐसा ब्रह्मांडीय लेज़र (Laser) है जो आँखों की हर बीमारी को जला डालता है।'"
                    "इंसान की आँखें माया के कीचड़ में इतनी धंस चुकी हैं कि उसे केवल पैसा, वासना और शरीर ही दिखाई देता है।"
                    "यही इंसान की आँखों का सबसे बड़ा 'रोग' (Disease) है; और इस रोग की एक ही सज़ा है— बार-बार जन्म लेना और मरना।"
                    "यह विद्या उस सड़ी हुई बायोलॉजिकल दृष्टि (Biological vision) को जड़ से उखाड़ फेंकती है और वहाँ एक 'दिव्य चक्षु' (Divine Eye) को फिट कर देती है।"
                    "जब यह विद्या काम करती है, तो इंसान की आँखें एक्सरे (X-ray) मशीन की तरह हर इंसान के भीतर बैठे भगवान को देखने लगती हैं।"
                    "उसे अब यह दुनिया ठोस नहीं, बल्कि एक होलोग्राम (Hologram) की तरह दिखाई देती है।"
                    "सूर्य ने इस रहस्य को देकर महर्षि सांकृति को पूरे ब्रह्मांड का सबसे अजेय दृष्टा (Observer) बना दिया।"
                    "जो इस विद्या को जान लेता है, उसका 'अंधापन' हमेशा के लिए मौत के घाट उतर जाता है!"
                """.trimIndent(),
                english = """
                    (The Sun's Reply and the Annihilation of Blindness): "Hearing that apocalyptic demand, the literal Sun God (Aditya) ripped open the highly classified cosmic secret."
                    "He explicitly transmitted that 'Chakshushi Vidya', which ruthlessly slaughters both the physical and spiritual 'Blindness' (Chakshu-roga) of a human being."
                    "The Sun roared: 'This Vidya is absolutely no pathetic medicine; it is a cosmic Laser beam that violently incinerates every disease of the eyes to dust.'"
                    "Mortal eyes are so deeply submerged in the mud of Maya that they exclusively hallucinate only money, lust, and biological flesh."
                    "This is the supreme, horrific 'Disease' of human eyes; and the only punishment for this disease is breeding and dying millions of times."
                    "This Vidya violently uproots that rotting biological vision and permanently implants a terrifying 'Divine Eye' in its place."
                    "When this radioactive Vidya operates, the human's eyes function like an X-ray machine, witnessing the explicit God sitting inside every creature."
                    "He no longer perceives this world as solid matter, but entirely as a pathetic, glitching Hologram."
                    "By handing over this secret, the Sun God mutated Maharishi Sankriti into the most invincible Observer in the entire cosmos."
                    "He who weaponizes this Vidya brutally executes his own 'Blindness', sending it to its absolute permanent grave!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 4,
                sanskrit = "ॐ नमो भगवते सूर्याय अक्षितेजसे नमः । खेचराय नमः महते नमः रजसे नमः तमसे नमः ॥ ४॥",
                hindi = """
                    (चाक्षुषी विद्या का महा-मंत्र): "यह वह प्रलयंकारी मंत्र है जिसे जपने से इंसान की आँखों में साक्षात सूर्य का न्यूक्लियर प्रकाश (अक्षितेजसे) उतर आता है!"
                    "योगी गर्जना करते हुए सूर्य को नमन करता है: 'ॐ नमो भगवते सूर्याय!'— उस भगवान सूर्य को मेरा प्रणाम जो पूरे ब्रह्मांड का इंजन है।"
                    "'खेचराय नमः'— उस खौफनाक ऊर्जा को प्रणाम जो असीम अंतरिक्ष (Space) को चीरते हुए आगे बढ़ती है।"
                    "'महते नमः'— उस ब्रह्मांडीय महानता को नमन जिसके सामने इंसान की कोई औकात नहीं।"
                    "'रजसे नमः, तमसे नमः'— सृष्टि को बनाने वाले रजोगुण और उसे भस्म करने वाले तमोगुण की प्रलयंकारी शक्तियों को मेरा सीधा नमन!"
                    "यह मंत्र केवल शब्द नहीं है; यह एक ऐसा हैकिंग कोड (Hacking Code) है जो इंसान के डीएनए (DNA) को बदलकर उसे सूर्य के समान धधकता हुआ बना देता है।"
                    "इस मंत्र की भयानक गर्मी से इंसान के दिमाग के सारे कचरे, सारे डर और सारा अज्ञान एक सेकंड में पिघल जाते हैं।"
                    "जब योगी इस मंत्र को अपनी आँखों में स्थापित करता है, तो उसकी नज़र से मौत भी घबरा कर पीछे हट जाती है।"
                    "वह दुनिया के सबसे गहरे और काले अँधेरे में भी उस परम सत्य को देख लेता है।"
                    "यह है सनातन धर्म का वह सबसे खतरनाक हथियार जो इंसान को अंधकार के चंगुल से हमेशा के लिए आज़ाद कर देता है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Mantra of Chakshushi Vidya): "This is the cataclysmic mantra whose detonation physically downloads the nuclear light of the Sun directly into the human's eyes (Akshitejase)!"
                    "The Yogi roars his salutation to the Sun: 'Om Namo Bhagavate Suryaya!'—I bow to that Lord Sun who is the literal engine of the entire universe."
                    "'Khecharaya Namah'—I salute that terrifying, radioactive energy that violently rips and tears through infinite Space."
                    "'Mahate Namah'—I salute that colossal cosmic greatness before which human existence has absolutely zero status."
                    "'Rajase Namah, Tamase Namah'—My direct salute to the apocalyptic powers of creation (Rajas) and ultimate annihilation (Tamas)!"
                    "This mantra is absolutely no combination of pathetic words; it is a direct Hacking Code that alters human DNA, mutating him to blaze like a literal sun."
                    "The horrific heat of this mantra instantaneously melts every ounce of garbage, fear, and ignorance from the biological brain in a microsecond."
                    "When the Yogi explicitly installs this mantra into his eyeballs, even Death panics and retreats from his terrifying gaze."
                    "He flawlessly perceives the Absolute Truth even in the deepest, most pitch-black darkness of the cosmos."
                    "This is Sanatana Dharma's most lethal weapon that permanently and violently liberates a human from the suffocating jaws of darkness!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 5,
                sanskrit = "अन्धो न जायते... य एवं वेद स वेदवित्... इत्येषा चाक्षुषी विद्या ॥ ५॥",
                hindi = """
                    (अंधेपन की मौत और विद्या का परिणाम): "उपनिषद इस प्रलयंकारी विद्या का परिणाम बताते हुए अपनी अंतिम गारंटी की मुहर लगाता है।"
                    "जो योगी इस सूर्य-रूपी ज्ञान को अपनी रगों में उतार लेता है, 'अन्धो न जायते'— वह ब्रह्मांड में कभी भी, किसी भी जन्म में अंधा नहीं हो सकता!"
                    "यह केवल भौतिक आँखों के अंधेपन की बात नहीं है; यह अज्ञान (Ignorance) के उस अंधेपन की मौत है जो इंसान को माया में फँसाता है।"
                    "जो इस विद्या को यथार्थ रूप में 'जान' (वेद) लेता है, केवल और केवल वही पूरे ब्रह्मांड में असली 'वेदवित्' (वेदों का असली मालिक) है।"
                    "किताबें और श्लोक रटने वाले केवल गधे हैं; जिसने अपनी आँखें खोल लीं, वही साक्षात भगवान है।"
                    "यह चाक्षुषी विद्या इंसान की नज़रों को इतना खतरनाक और अजेय बना देती है कि वह सीधे ईश्वर के सीने के पार देख सकता है।"
                    "उसके लिए यह पूरी दुनिया पारदर्शी (Transparent) हो जाती है; कोई भी झूठ या धोखा उसके सामने टिक नहीं सकता।"
                    "वह अज्ञान के पूरे साम्राज्य को अपनी एक नज़र से जलाकर राख कर देने की ताक़त रखता है।"
                    "इस विद्या के बाद, इंसान को कोई दूसरा गुरु या कोई दूसरी किताब नहीं चाहिए।"
                    "यहीं पर आँखों की यह खौफनाक विद्या पूरी होती है, और इंसान परम 'दृष्टा' (The Absolute Observer) बन जाता है!"
                """.trimIndent(),
                english = """
                    (The Death of Blindness and the Result of the Vidya): "The Upanishad stamps its final, ironclad guarantee regarding the consequence of this apocalyptic science."
                    "The Yogi who injects this solar-knowledge into his veins, 'Andho na jayate'—absolutely never, in any incarnation in the cosmos, can he ever be born blind!"
                    "This is absolutely not about the pathetic blindness of biological eyeballs; it is the violent death of the 'Blindness of Ignorance' that traps a human in Maya."
                    "He who explicitly and physically 'Knows' (Veda) this Vidya is strictly and exclusively the only true 'Vedavit' (Absolute Master of the Vedas) in the universe."
                    "The pathetic fools memorizing books are mere beasts of burden; he who has ripped his inner eyes open is the explicit God."
                    "This Chakshushi Vidya mutates human vision into something so lethal and invincible that he can stare straight through the chest of God."
                    "To his eyes, this entire physical world becomes completely Transparent; absolutely zero lies or deception can survive his gaze."
                    "He possesses the terrifying capability to incinerate the entire empire of ignorance to ashes with a single glance."
                    "After detonating this Vidya, the human requires absolutely zero external gurus and zero pathetic books."
                    "Here, this terrifying science of vision achieves completion, mutating the human into the 'Absolute Observer' of the cosmos!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 6,
                sanskrit = "अथ ह साङ्कृतिरादित्यं पप्रच्छ भो भगवन् ब्रह्मविद्यां मे ब्रूहीति ॥ ६॥",
                hindi = """
                    (ब्रह्मविद्या की खौफनाक मांग): "आँखों का अंधापन दूर होने के बाद महर्षि सांकृति की भूख मिटी नहीं, बल्कि वह एक खूँखार शेर की तरह और भड़क उठी!"
                    "जब उनकी आँखें ब्रह्मांड को देखने लायक हो गईं, तब उन्होंने भगवान सूर्य पर अपना सबसे बड़ा और अंतिम मानसिक प्रहार किया।"
                    "उन्होंने दहाड़ते हुए कहा: 'हे भगवन्! अब मुझे कोई छोटी-मोटी विद्या नहीं चाहिए; अब मुझे सीधे वह परम 'ब्रह्मविद्या' (The Absolute Cosmic Knowledge) चाहिए!'"
                    "'मुझे वह ज्ञान दो जिससे यह पूरा ब्रह्मांड पैदा हुआ है और जिसमें यह नष्ट होता है; मुझे सीधा परब्रह्म को जानना है!'"
                    "यह इंसान का ईश्वर से सीधे उसकी गद्दी (Throne) मांग लेने जैसा खौफनाक दुस्साहस था।"
                    "वह जानना चाहते थे कि इस माया के मैट्रिक्स को हैक करके उस परम शून्यता में कैसे प्रवेश किया जाए।"
                    "ब्रह्मविद्या कोई किताब का पाठ नहीं है; यह वह न्यूक्लियर कोड (Nuclear Code) है जो इंसान के दिमाग को फाड़कर उसे भगवान बना देता है।"
                    "सूर्य समझ गए कि अब यह योगी रुकने वाला नहीं है; यह मौत को भी लात मारकर उस परम सत्य को चबाने के लिए तैयार है।"
                    "और तब सूर्य ने मुस्कुराते हुए योग और ज्ञान की वह सात खौफनाक सीढ़ियां (Bhoomikas) खोलनी शुरू कीं..."
                    "जहाँ से कोई इंसान आज तक वापस लौटकर आम इंसान नहीं बन पाया!"
                """.trimIndent(),
                english = """
                    (The Terrifying Demand for Brahma-Vidya): "After executing the blindness of his eyes, Maharishi Sankriti's hunger absolutely did not subside; it erupted furiously like a bloodthirsty lion!"
                    "When his eyes mutated to a caliber capable of witnessing the cosmos, he launched his final, most massive psychological strike on the Sun God."
                    "He roared: 'O Lord! I absolutely no longer desire any microscopic sciences; hand over to me the ultimate 'Brahma-Vidya' (The Absolute Cosmic Knowledge)!'"
                    "'Give me the exact formula that spawns this entire infinite universe and slaughters it; I demand to know the Supreme Brahman directly!'"
                    "This was the terrifying audacity of a mortal directly demanding God to hand over His absolute undisputed throne."
                    "He violently demanded to know how to hack the Matrix of Maya and penetrate directly into that Supreme Void."
                    "Brahma-Vidya is no pathetic textbook lesson; it is the ultimate Nuclear Code that literally tears the human brain apart and mutates him into God."
                    "The Sun flawlessly realized that this Yogi was now unstoppable; he was ready to kick Death in the face and chew on the Absolute Truth."
                    "And then, with a cosmic smile, the Sun God began unleashing the Seven Terrifying Dimensions (Bhoomikas) of Yoga and Knowledge..."
                    "From which absolutely no human has ever returned to being a normal, pathetic mortal!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 7,
                sanskrit = "तस्मै स होवाचादित्यः... ज्ञानभूमिः सप्तधा भवति । शुभेच्छा विचारणा तनुमानसी सत्त्वापत्तिरसंसक्तिः पदार्थभावनी तुर्यगा चेति ॥ ७॥",
                hindi = """
                    (ज्ञान की सात प्रलयंकारी भूमिकाओं का ऐलान): "भगवान सूर्य ने उस अजेय योगी को पूरे योग विज्ञान का सबसे खौफनाक नक्शा (Blueprint) सौंप दिया।"
                    "सूर्य ने गर्जना की: 'हे सांकृति! उस परमेश्वर तक पहुँचने की कोई एक सीढ़ी नहीं है; ज्ञान की सात खौफनाक और प्रलयंकारी भूमिकाएँ (Stages) होती हैं!'"
                    "सुनो उन सात सीढ़ियों के नाम जो इंसान को जलाकर राख करती हैं और फिर उसे साक्षात शिव में बदल देती हैं:"
                    "१. शुभेच्छा (सत्य को जानने की खूँखार भूख), २. विचारणा (अहंकार को चीरने वाली आत्म-खोज), ३. तनुमानसी (मन का भूख से सूखकर मर जाना)।"
                    "४. सत्त्वापत्ति (शुद्ध ऊर्जा का विस्फोट), ५. असंसक्ति (पूरी दुनिया से भयंकर अलगाव और शून्यता), ६. पदार्थभावनी (दुनिया के हर भौतिक रूप की मौत)।"
                    "और अंत में सबसे खौफनाक और अंतिम अवस्था— ७. तुर्यगा (तुरीय: जहाँ इंसानियत पूरी तरह से खत्म होकर केवल ईश्वर बचता है)!"
                    "ये सात सीढ़ियां कोई मज़ाक नहीं हैं; हर एक सीढ़ी पर इंसान का पुराना 'मैं' तड़प-तड़प कर मरता है।"
                    "पहली सीढ़ी से लेकर सातवीं तक का सफर खून-खराबे का सफर है— खून किसी और का नहीं, अपने ही विचारों और इच्छाओं का बहता है।"
                    "जो कमज़ोर दिल वाले हैं, वे दूसरी या तीसरी सीढ़ी पर ही पागल हो जाते हैं या वापस दुनिया के कीचड़ में गिर जाते हैं।"
                    "लेकिन जो सातों सीढ़ियों को पार कर लेता है, वह इस ब्रह्मांड का इकलौता तानाशाह (Dictator) बन जाता है!"
                """.trimIndent(),
                english = """
                    (The Declaration of the Seven Apocalyptic Stages of Knowledge): "The Sun God handed over the most terrifying, ultimate Blueprint of the entire science of Yoga to that invincible Yogi."
                    "The Sun roared: 'O Sankriti! There is no single pathetic ladder to reach that Supreme God; there are exactly Seven Terrifying and Apocalyptic Dimensions (Bhoomikas) of Cosmic Knowledge!'"
                    "Listen to the names of these seven dimensions that incinerate a human to ash and mutate him explicitly into Shiva:"
                    "1. Subheccha (The bloodthirsty hunger for Truth), 2. Vicarana (The ruthless self-inquiry that slices the ego), 3. Tanumanasi (The literal starvation and death of the mind)."
                    "4. Sattvapatti (The atomic explosion of pure energy), 5. Asamsakti (Horrific detachment and total Void from the world), 6. Padarthabhavani (The brutal death of all physical forms)."
                    "And finally, the most terrifying and ultimate dimension—7. Turyaga (Turiya: Where humanity completely ceases to exist, leaving exclusively God)!"
                    "These seven dimensions are absolutely no joke; on every single step, the human's old 'I' dies a screaming, agonizing death."
                    "The journey from the first step to the seventh is a journey of extreme bloodshed—not physical blood, but the violent slaughter of one's own thoughts and lusts."
                    "Weak-hearted mortals go completely insane on the second or third step and plummet violently back into the worldly mud."
                    "But he who successfully breaches all seven dimensions instantaneously becomes the sole, undisputed Dictator of the entire cosmos!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 8,
                sanskrit = "वैराग्यपूर्वमिच्छा या... सा शुभेच्छेति कथ्यते ॥ ८॥",
                hindi = """
                    (पहली सीढ़ी - शुभेच्छा: वैराग्य का भयंकर विस्फोट): "भगवान सूर्य पहली सीढ़ी का रहस्य खोलते हुए कहते हैं— 'शुभेच्छा'!"
                    "यह कोई आम इच्छा नहीं है; यह वह खौफनाक और प्रलयंकारी प्यास है जो सबसे गहरे 'वैराग्य' (Detachment) से पैदा होती है।"
                    "जब इंसान को यह दुनिया, इसके सारे रिश्ते, सारा पैसा और सारी सफलताएँ एक सड़े हुए कचरे की तरह लगने लगती हैं..."
                    "जब वह अपने ही जीवन को देखकर थूक देता है और चीखता है कि 'मैं इस माया की जेल में और नहीं सडूँगा!'"
                    "उस भयंकर नफरत और वैराग्य के गर्भ से जो 'सत्य को जानने की खूँखार भूख' जन्म लेती है, उसे 'शुभेच्छा' कहते हैं।"
                    "यह इंसान के भीतर लगने वाली वह पहली आग है जो उसके आराम (Comfort Zone) को जलाकर खाक कर देती है।"
                    "इस अवस्था में इंसान पागलों की तरह शास्त्रों को पढ़ता है, गुरुओं को खोजता है और अपने ही दिमाग को नोचने लगता है।"
                    "वह दुनिया के सबसे बड़े करोड़पति को भी एक भिखारी की तरह देखता है, क्योंकि उसे अब वह दौलत चाहिए जो कभी नष्ट न हो।"
                    "यह मोक्ष के खूनी युद्ध की पहली घोषणा है; यहीं से इंसान का अपनी ही पुरानी पहचान से कटना शुरू होता है।"
                    "बिना इस खौफनाक 'शुभेच्छा' के, कोई भी ध्यान या योग केवल एक पाखंड और समय की बर्बादी है!"
                """.trimIndent(),
                english = """
                    (The First Dimension - Subheccha: The Terrifying Detonation of Vairagya): "The Sun God violently rips open the secret of the first dimension—'Subheccha'!"
                    "This is absolutely no ordinary desire; this is an apocalyptic, bloodthirsty thirst that detonates strictly from the deepest abyss of 'Vairagya' (Absolute Detachment)."
                    "When the human begins perceiving this entire world, all relationships, money, and success exactly like rotting, repulsive garbage..."
                    "When he literally spits at his own biological existence and screams, 'I absolutely refuse to rot in this prison of Maya for another microsecond!'"
                    "From the womb of that horrific hatred and detachment, the 'ruthless hunger to seize the Absolute Truth' is born, explicitly known as 'Subheccha'."
                    "This is the very first radioactive fire ignited within the human that completely incinerates his pathetic 'Comfort Zone' to ashes."
                    "In this state, the human violently devours scriptures like a maniac, hunts for true Masters, and begins physically clawing at his own brain."
                    "He perceives even the wealthiest billionaire on Earth exactly as a pathetic beggar, because he now demands a wealth that absolutely never perishes."
                    "This is the very first declaration of the bloody war for Moksha; right here begins the violent severing of the human from his old identity."
                    "Without this terrifying 'Subheccha', every single meditation or Yoga is strictly a hypocritical drama and a pathetic waste of time!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 9,
                sanskrit = "शास्त्रसज्जनसम्पर्कवैराग्याभ्यासपूर्वकम् । सदाचारप्रवृत्तिर्या विचारणेति सा स्मृता ॥ ९॥",
                hindi = """
                    (दूसरी सीढ़ी - विचारणा: अज्ञान पर ज्ञान की कुल्हाड़ी): "जब शुभेच्छा की आग तेज़ हो जाती है, तो योगी दूसरी खौफनाक सीढ़ी 'विचारणा' पर पैर रखता है।"
                    "यह कोई आम सोच-विचार नहीं है; यह अपने ही अहंकार की गर्दन पर 'ज्ञान की कुल्हाड़ी' मारने की सबसे क्रूर प्रक्रिया है।"
                    "योगी शास्त्रों के सत्य और साक्षात 'सज्जनों' (ब्रह्मज्ञानियों) के संपर्क से अपने दिमाग के हर भ्रम को बेरहमी से चीर देता है।"
                    "वह 'सदाचार' (Absolute Discipline) और भयंकर वैराग्य का ऐसा खूनी अभ्यास (Practice) करता है जिससे उसकी सारी बुरी आदतें तड़प कर मर जाती हैं।"
                    "वह खुद से यह प्रलयंकारी सवाल पूछता है: 'मैं कौन हूँ? यह ब्रह्मांड क्या है? यह मौत क्या है?'"
                    "इस 'विचारणा' (Self-Inquiry) की धार इतनी तेज़ होती है कि इंसान की सारी पुरानी मान्यताएं और धर्म कटकर राख हो जाते हैं।"
                    "वह किसी भी चीज़ को आँख बंद करके नहीं मानता; वह भगवान को भी तब तक नहीं मानता जब तक उसे खुद ना देख ले।"
                    "यह इंसान के मन का एक भयंकर ऑपरेशन (Surgery) है जिसे वह खुद बिना बेहोश हुए (बिना Anesthesia के) कर रहा है।"
                    "जो इस सीढ़ी पर टिक जाता है, वह अपने भीतर के सारे जालों को काटकर एकदम साफ़ और नंगा हो जाता है।"
                    "विचारणा वह लेज़र बीम है जो अज्ञान के सबसे कठोर लोहे को भी पल भर में पिघला देती है!"
                """.trimIndent(),
                english = """
                    (The Second Dimension - Vicarana: The Axe of Knowledge upon Ignorance): "When the radioactive fire of Subheccha intensifies, the Yogi plants his boot on the second terrifying dimension: 'Vicarana'."
                    "This is absolutely no ordinary thinking; it is the most brutal process of swinging the 'Axe of Absolute Knowledge' directly at the neck of one's own ego."
                    "The Yogi ruthlessly slices through every single hallucination of his brain using the truth of the scriptures and the direct collision with 'Sajjanas' (Brahman-Knowers)."
                    "He executes such a bloody, tyrannical practice of 'Sadachara' (Absolute Discipline) and horrific detachment that every single bad biological habit dies screaming in agony."
                    "He violently interrogates himself with the apocalyptic question: 'Who exactly am I? What is this cosmos? What is Death?'"
                    "The edge of this 'Vicarana' (Self-Inquiry) is so lethally sharp that all human conditioning and pathetic religions are shredded to ashes."
                    "He absolutely refuses to believe anything blindly; he rejects even God until he physically and explicitly witnesses Him firsthand."
                    "This is a horrific, brutal psychological Surgery that the human performs entirely upon his own brain without any anesthesia."
                    "He who survives this dimension violently slashes through all internal webs, becoming absolutely clean and terrifyingly naked."
                    "Vicarana is the exact cosmic laser beam that instantaneously melts even the hardest titanium of biological ignorance!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 10,
                sanskrit = "विचारणाशुभेच्छेभ्यामिन्द्रियार्थेष्वसक्तता । यत्र सा तनुतामेति प्रोच्यते तनुमानसी ॥ १०॥",
                hindi = """
                    (तीसरी सीढ़ी - तनुमानसी: मन का भूख से सूखकर मरना): "शुभेच्छा और विचारणा के खौफनाक प्रहारों के बाद इंसान तीसरी सीढ़ी 'तनुमानसी' में प्रवेश करता है।"
                    "यहाँ योगी का दिमाग पूरी दुनिया के मज़ों (इन्द्रियार्थेषु) से इतनी बेरहमी से कट जाता है कि उसे किसी भी चीज़ में कोई रस नहीं आता (असक्तता)।"
                    "चाहे उसके सामने अप्सराएं नाचें या मौत खड़ी हो, उसका मन किसी भी चीज़ को पकड़ता (Attach) ही नहीं है।"
                    "जब मन को बाहर से खुराक (वासनाएं और विचार) मिलनी बंद हो जाती है, तो वह मन भयानक रूप से 'सूखने' और कमज़ोर (तनुताम्) होने लगता है।"
                    "यही 'तनुमानसी' है— मन का एक सड़े हुए और सूखे पत्ते की तरह इतना पतला हो जाना कि हवा के एक झोंके से वह राख बन जाए!"
                    "इंसान अपनी पूरी ज़िंदगी अपने मन को मोटा और ताक़तवर बनाने में लगा देता है, लेकिन योगी जानबूझकर अपने मन को भूखा मारता है।"
                    "यह शरीर ज़िंदा है, लेकिन इसके भीतर का वह खूँखार जानवर (Mind) तड़प-तड़प कर अपनी आखिरी साँसें गिन रहा है।"
                    "जब मन मरता है, तभी आत्मा अपनी पूरी प्रलयंकारी ताक़त के साथ फटने के लिए तैयार होती है।"
                    "यह अवस्था एक खौफनाक रेगिस्तान की तरह है, जहाँ कोई विचार, कोई इच्छा और कोई जज़्बात पैदा नहीं हो सकता।"
                    "मन को इस तरह भूखा मारकर सुखा देना ही योग की सबसे बड़ी और क्रूर जीत है!"
                """.trimIndent(),
                english = """
                    (The Third Dimension - Tanumanasi: The Literal Starvation and Death of the Mind): "Following the brutal, apocalyptic strikes of Subheccha and Vicarana, the human breaches the third dimension: 'Tanumanasi'."
                    "Here, the Yogi's brain is so ruthlessly severed from all sensory worldly pleasures (Indriyartheshu) that he registers absolutely zero interest in anything (Asaktata)."
                    "Whether celestial nymphs dance naked before him or Death itself stands with a scythe, his mind absolutely refuses to attach to anything."
                    "When the mind is permanently denied its biological food (lusts and thoughts) from the outside world, it begins to horrifically 'wither' and weaken (Tanutam)."
                    "This is precisely 'Tanumanasi'—the psychological state where the mind becomes so emaciated, exactly like a rotting dry leaf, that a single breeze reduces it to ash!"
                    "Mortals spend their entire pathetic lives fattening and strengthening their minds, but the Yogi deliberately, cold-bloodedly starves his mind to death."
                    "The biological body is still breathing, but the ferocious beast inside (the Mind) is agonizingly counting its final breaths."
                    "Only when the mind dies a brutal death does the Soul prepare to detonate with its full, apocalyptic, radioactive power."
                    "This dimension is exactly like a terrifying, barren desert where absolutely zero thoughts, zero desires, and zero emotions can possibly breed."
                    "Starving and dehydrating the biological mind to this horrific extent is the greatest, most ruthless absolute victory of Yoga!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 11,
                sanskrit = "भूमिकात्रयमभ्यस्य... जाग्रदित्युच्यते... ॥ ११॥",
                hindi = """
                    (तीनों सीढ़ियों का पार होना और जाग्रत का अंत): "सूर्य भगवान कहते हैं कि ये पहली तीन सीढ़ियां (शुभेच्छा, विचारणा, तनुमानसी) ही इंसान की 'जाग्रत' (Waking state) अवस्था हैं।"
                    "इन तीन सीढ़ियों तक इंसान अभी भी इस दुनिया से जुड़ा होता है और वह प्रयास (Effort) कर रहा होता है।"
                    "यह वह युद्ध है जहाँ इंसान का पसीना बहता है, उसका अहंकार लड़ता है, और वह लगातार अपने अज्ञान को कुचलने की कोशिश करता है।"
                    "लेकिन जब योगी इन तीनों खौफनाक सीढ़ियों को पूरी तरह से 'जीत' (अभ्यस्य) लेता है..."
                    "तब उसकी यह सामान्य इंसानी 'जागने की अवस्था' हमेशा-हमेशा के लिए मौत के घाट उतर जाती है।"
                    "वह अब इस दुनिया के लिए जागना बंद कर देता है; यह माया का मैट्रिक्स उसके लिए पूरी तरह से ऑफ (Turned off) हो जाता है।"
                    "इसके बाद जो कुछ भी होता है, वह इंसान की कोशिश से नहीं, बल्कि ब्रह्मांडीय ऊर्जा के महा-विस्फोट से अपने आप होता है।"
                    "यह वो बॉर्डर (Boundary) है जिसे पार करने के बाद इंसान वापस पलटकर नहीं देख सकता; उसका पिछला अस्तित्व राख बन चुका है।"
                    "जाग्रत अवस्था का मरना ही उस प्रलयंकारी आध्यात्मिक अवस्था की शुरुआत है जिसे दुनिया के लोग पागलपन कहते हैं।"
                    "अब वह सीधे भगवान की उस खौफनाक ज़ोन (Zone) में घुसने वाला है जहाँ से कोई सिग्नल वापस नहीं आता!"
                """.trimIndent(),
                english = """
                    (The Breaching of the Three Dimensions and the Death of the Waking State): "The Sun God declares that these first three dimensions (Subheccha, Vicarana, Tanumanasi) explicitly constitute the human's 'Jagrat' (Waking state)."
                    "Up to these three terrifying dimensions, the human is still biologically connected to this world and is manually exerting ferocious 'Effort'."
                    "This is the active warzone where the human sweats blood, his ego violently resists, and he continuously attempts to crush his ignorance."
                    "But when the Yogi successfully and completely 'Conquers' (Abhyasya) all three of these catastrophic dimensions..."
                    "His normal, pathetic human 'Waking State' is put to a permanent, brutal death forever."
                    "He completely ceases to be 'awake' to this physical world; this Matrix of Maya is permanently Turned Off for him."
                    "Whatever manifests after this point is absolutely not caused by human effort, but happens automatically through the atomic detonation of cosmic energy."
                    "This is the absolute Boundary; once breached, the human can never look back—his previous existence has been completely burnt to ashes."
                    "The assassination of the waking state is the precise genesis of that apocalyptic spiritual dimension which mortal fools label as sheer insanity."
                    "He is now about to violently penetrate directly into God's terrifying Zone, from which absolutely zero signal ever returns!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 12,
                sanskrit = "सत्त्वापत्तिश्चतुर्थी स्यात्... स्वप्नावस्था... ॥ १२॥",
                hindi = """
                    (चौथी सीढ़ी - सत्त्वापत्ति: शुद्ध ऊर्जा का विस्फोट और स्वप्न अवस्था): "जब मन पूरी तरह मर जाता है, तो योगी चौथी प्रलयंकारी सीढ़ी 'सत्त्वापत्ति' में छलांग लगाता है।"
                    "यहाँ इंसान के दिमाग का हर कचरा (रजोगुण और तमोगुण) भस्म हो जाता है, और उसके भीतर 'शुद्ध सत्त्व' (Absolute Pure Energy) का भयंकर विस्फोट होता है!"
                    "यह अवस्था आम इंसान के लिए एक 'स्वप्न' (Dream state) की तरह है।"
                    "जैसे सपने में तुम्हें पता होता है कि तुम जो देख रहे हो वह सच नहीं है, ठीक वैसे ही योगी इस पूरी भौतिक दुनिया को एक सड़े हुए 'सपने' की तरह देखता है।"
                    "उसके लिए यह पहाड़, ये लोग, यह ज़मीन और आसमान—सब कुछ केवल एक होलोग्राम (Hologram) बन कर रह जाते हैं।"
                    "दुनिया में आग लग जाए या पूरी पृथ्वी फट जाए, वह योगी उस तमाशे को ऐसे देखता है जैसे कोई फिल्म देख रहा हो!"
                    "उसे दुनिया के किसी भी इंसान, रिश्ते या दर्द से रत्ती भर भी कोई फर्क नहीं पड़ता।"
                    "वह साक्षात 'ईश्वर' के नज़रिए (Perspective) से इस ब्रह्मांड को देख रहा है।"
                    "उसका मन अब काम नहीं कर रहा, बल्कि उसकी आत्मा पूरी दुनिया को एक स्क्रीन (Screen) पर देख रही है।"
                    "यह इंसान का वह खौफनाक अपग्रेड (Upgrade) है जहाँ दुनिया की वास्तविकता (Reality) हमेशा के लिए ज़ीरो (Zero) हो जाती है।"
                """.trimIndent(),
                english = """
                    (The Fourth Dimension - Sattvapatti: Explosion of Pure Energy and the Dream State): "When the mind dies completely, the Yogi violently leaps into the fourth apocalyptic dimension: 'Sattvapatti'."
                    "Here, every ounce of garbage in the human brain (Rajas and Tamas) is incinerated, and an atomic detonation of 'Pure Sattva' (Absolute Pure Cosmic Energy) erupts within him!"
                    "This terrifying state is exactly equivalent to a 'Dream' (Svapna) for an ordinary human."
                    "Just as in a lucid dream you know precisely that what you are witnessing is fake, the Yogi perceives this entire physical world exactly like a rotting 'Dream'."
                    "To his eyes, these mountains, these mortals, this Earth, and the sky—everything is reduced to a glitching, pathetic Hologram."
                    "Even if the entire world catches fire or the Earth literally rips apart, that Yogi watches the drama exactly as if watching a movie screen!"
                    "He registers absolutely zero effect, zero reaction, and zero empathy toward any human, relationship, or biological pain."
                    "He is now witnessing the entire cosmos explicitly and directly through the absolute 'Perspective of God'."
                    "His biological brain is completely dead; his Soul is now merely watching the universe play out on a cosmic screen."
                    "This is that terrifying, apocalyptic Upgrade of the human where the 'Reality' of the world violently drops to absolute Zero forever."
                """.trimIndent()
            ),
            AkshiShloka(
                id = 13,
                sanskrit = "स्वप्ने जगदवलोकयन्... समः शान्तो... ॥ १३॥",
                hindi = """
                    (योगी की खौफनाक शांति और दुनिया का तमाशा): "चौथी सीढ़ी पर खड़ा योगी इस दुनिया को एक 'स्वप्न' (जगदवलोकयन्) की तरह देखता हुआ बिल्कुल सुन्न हो जाता है।"
                    "उसके चेहरे पर कोई भाव नहीं आता; वह एक चट्टान की तरह 'सम' (Equanimous) और मौत की तरह 'शांत' (शान्तो) हो जाता है।"
                    "कोई उसे तलवार से काट दे या कोई उसे सोने के सिंहासन पर बिठा दे, उसके भीतर की यह प्रलयंकारी शांति रत्ती भर भी नहीं टूटती।"
                    "वह जानता है कि सपने में अगर कोई उसे मार भी दे, तो हकीकत में उसे कुछ नहीं होता।"
                    "यही कारण है कि वह अपने ही शरीर के कटने का तमाशा भी एक दर्शक (Audience) की तरह बिना पलक झपकाए देख सकता है।"
                    "यह कोई कमज़ोरी नहीं है; यह ब्रह्मांड की सबसे भयंकर और अजेय ताक़त है।"
                    "उसकी शून्यता इतनी खतरनाक होती है कि उसके पास जाने वाले इंसानों का अहंकार भी पिघलने लगता है।"
                    "वह इंसान की तरह साँस ले रहा है, लेकिन अंदर से वह पूरी तरह से एक 'ब्रह्मांडीय रोबोट' (Cosmic Entity) बन चुका है।"
                    "इस दुनिया की कोई भी ताक़त, कोई भी लालच या कोई भी खौफ इस योगी की नाड़ी (Pulse) को तेज़ नहीं कर सकता।"
                    "वह साक्षात शिव के उस स्वरूप में आ चुका है जहाँ प्रलय का तांडव भी उसे केवल एक खेल लगता है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Silence of the Yogi and the Spectacle of the World): "Standing on the fourth dimension, watching this world purely as a glitching 'Dream' (Jagadavalokayan), the Yogi goes completely numb."
                    "Absolutely zero biological emotion registers on his face; he becomes as ruthlessly 'Equanimous' (Sama) as a monolith and as 'Silent' (Shanto) as literal death."
                    "Whether someone hacks his flesh with a sword or seats him on a solid gold throne, his apocalyptic internal silence absolutely does not break by a micro-millimeter."
                    "He possesses the lethal realization that even if he is slaughtered in a dream, in absolute reality, absolutely nothing happens to him."
                    "This is the exact reason he can watch his own biological body being sliced into pieces completely unblinking, purely as an Audience member."
                    "This is absolutely no weakness; it is the most terrifying, invincible, radioactive power in the entire cosmos."
                    "His Void is so catastrophic and lethal that the ego of any mortal approaching him instantly begins to melt and vaporize."
                    "He breathes biologically like a human, but internally he has completely mutated into a perfectly numb 'Cosmic Entity'."
                    "Absolutely zero force on Earth, zero greed, and zero horror can ever accelerate the pulse of this Titan."
                    "He has explicitly downloaded the form of Shiva, where even the apocalyptic dance of cosmic annihilation looks to him like a pathetic child's game!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 14,
                sanskrit = "पञ्चमीं भूमिकामेत्य... असंसक्तिर्नामिका... सुषुप्तपदम् ॥ १४॥",
                hindi = """
                    (पाँचवीं सीढ़ी - असंसक्ति: अलगाव का ब्लैक होल और सुषुप्ति): "अब योगी पाँचवीं और अधिक प्रलयंकारी सीढ़ी पर पैर रखता है— 'असंसक्ति' (Absolute Non-Attachment)!"
                    "यहाँ तक आते-आते दुनिया के सपने का भी अंत हो जाता है; योगी पूरी तरह से हर चीज़ से कटकर एक 'ब्लैक होल' बन जाता है।"
                    "यह अवस्था आम इंसान की 'सुषुप्ति' (Deep Dreamless Sleep) के बराबर है।"
                    "जैसे गहरी नींद में इंसान को अपने शरीर, दुनिया, यहाँ तक कि अपने 'मैं' (Ego) का भी कोई होश नहीं रहता..."
                    "ठीक वैसे ही यह महायोगी खुली आँखों से ज़िंदा रहते हुए इस गहरी 'सुषुप्ति' (सुषुप्तपदम्) में चला जाता है!"
                    "उसे बाहर की दुनिया का कोई होश नहीं है; उसे पता ही नहीं कि वह कपड़े पहने है या नंगा है।"
                    "उसे भूख, प्यास, सर्दी या गर्मी का सिग्नल उसके दिमाग तक पहुँचता ही नहीं है; उसका न्यूरोलॉजिकल सिस्टम (Neurological system) दुनिया के लिए शटडाउन (Shut down) हो चुका है।"
                    "वह अंदर से पूरी तरह से 'परब्रह्म' की असीम रोशनी में धधक रहा है, लेकिन बाहर से वह एक पत्थर या मुर्दे की तरह पड़ा रहता है।"
                    "यह शरीर और आत्मा का सबसे खौफनाक अलगाव (Disconnection) है, जिसे कोई भी मेडिकल साइंस नहीं समझ सकता।"
                    "वह साक्षात ईश्वर की उस परम शून्यता में गोते खा रहा है जहाँ से आवाज़ भी वापस नहीं आती!"
                """.trimIndent(),
                english = """
                    (The Fifth Dimension - Asamsakti: The Black Hole of Detachment and Deep Sleep): "Now the Yogi plants his boot on the fifth and even more apocalyptic dimension—'Asamsakti' (Absolute Cosmic Non-Attachment)!"
                    "By the time he reaches here, even the hallucination of the dream completely ends; the Yogi violently severs from absolutely everything, mutating into a literal 'Black Hole'."
                    "This state is exactly mathematically equivalent to a mortal's 'Sushupti' (Deep, Dreamless, Comatose Sleep)."
                    "Just as in deep comatose sleep a human possesses absolutely zero awareness of his body, the world, or even his own 'I' (Ego)..."
                    "In the exact same brutal manner, this colossal Yogi, with his physical eyes wide open and breathing, plunges directly into this profound 'Sushupti' (Sushuptapadam)!"
                    "He possesses absolutely zero awareness of the external matrix; he literally does not know if he is clothed or completely naked."
                    "The biological signals of hunger, thirst, freezing cold, or scorching heat absolutely fail to reach his brain; his neurological system has completely Shut Down to the world."
                    "Internally, he is blazing violently in the infinite radioactive light of the 'Supreme Brahman', but externally he lies exactly like a lifeless stone or a rotting corpse."
                    "This is the most terrifying, apocalyptic Disconnection between the biological body and the Soul, which absolutely no medical science can ever fathom."
                    "He is violently diving deep into that Supreme Void of God from which not even sound can ever escape back!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 15,
                sanskrit = "अन्तर्मुखतया नित्यं बहिर्वृत्तिविवर्जितः । श्रान्तः सुप्त इव... ॥ १५॥",
                hindi = """
                    (अन्तर्मुखी अवस्था और बाहरी दुनिया की मौत): "पाँचवीं सीढ़ी पर बैठे उस योगी की हालत का सबसे खौफनाक वर्णन यहाँ है।"
                    "वह 'अन्तर्मुखतया नित्यं'— यानी उसकी चेतना 100% हमेशा-हमेशा के लिए अंदर की तरफ मुड़ चुकी है (Locked inwards)!"
                    "वह 'बहिर्वृत्तिविवर्जितः' है— उसके दिमाग से बाहरी दुनिया की ओर जाने वाला एक भी विचार या सिग्नल हमेशा के लिए कट चुका है।"
                    "बाहर से देखने पर वह कैसा लगता है? 'श्रान्तः सुप्त इव'— जैसे कोई इंसान बहुत ज़्यादा थका हुआ गहरी नींद में सो रहा हो, या बेहोश पड़ा हो!"
                    "तुम उसके सामने ढोल बजाओ, उसे हिलाओ, या आग लगा दो—उसकी आँखें खुली हो सकती हैं, लेकिन वह तुम्हें देख नहीं रहा है।"
                    "वह इंसान की तरह रिएक्ट (React) करना पूरी तरह से भूल चुका है; उसका इंसानी सॉफ्टवेयर क्रैश (Crash) हो चुका है।"
                    "उसके भीतर एक असीम ब्रह्मांडीय ऊर्जा का विस्फोट हो रहा है, लेकिन उसका भौतिक शरीर पूरी तरह से लकवाग्रस्त (Paralyzed) हो गया है।"
                    "वह उस परम सत्य (भगवान) को इतनी गहराई से चख रहा है कि उसे अब इस सड़ी हुई दुनिया की कोई परवाह नहीं।"
                    "यह कोई कोमा (Coma) नहीं है; यह ब्रह्मांड की सबसे ऊँची 'सुपर-अवेयरनेस' (Super-Awareness) है जिसे मूर्ख लोग बेसुध समझते हैं।"
                    "वह बाहर से एक लाश की तरह है, लेकिन अंदर से वह पूरे ब्रह्मांड को अपने भीतर समाए हुए है!"
                """.trimIndent(),
                english = """
                    (The Inward-Locked State and the Death of the External World): "Here is the most terrifying description of the exact biological and psychological state of the Yogi stationed on the fifth dimension."
                    "He is 'Antarmukhataya nityam'—Meaning, his raw consciousness has turned and 'Locked Inwards' 100% permanently and forever!"
                    "He is 'Bahirvritti-vivarjitah'—Not a single microscopic thought or neurological signal travels outward from his brain to the external matrix; the connection is permanently severed."
                    "How does he appear from the outside? 'Shrantah supta iva'—Exactly like a human exhausted to the absolute brink, sleeping in a deep coma, or lying utterly unconscious!"
                    "You can violently beat drums in his face, shake him brutally, or literally set a fire before him—his biological eyes may be wide open, but he absolutely does not see you."
                    "He has completely and permanently forgotten how to React like a human; his human biological software has suffered a catastrophic Crash."
                    "An infinite cosmic energy is detonating inside his core, but his physical shell is completely, terrifyingly Paralyzed."
                    "He is devouring and tasting that Absolute Truth (God) so profoundly that he possesses zero care for this rotting external world."
                    "This is absolutely no Coma; this is the universe's most supreme 'Super-Awareness' which pathetic fools hallucinate as unconsciousness."
                    "Externally he is equivalent to a dead corpse, but internally he violently contains the entire infinite cosmos directly within his chest!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 16,
                sanskrit = "षष्ठीं पदार्थभावनीं... परप्रयुक्तेन... व्युत्थानं... ॥ १६॥",
                hindi = """
                    (छठी सीढ़ी - पदार्थभावनी: वस्तुओं की मौत और मुर्दा अवस्था): "अब वह योगी उस छठी और रोंगटे खड़े कर देने वाली अवस्था 'पदार्थभावनी' में गिरता है।"
                    "यहाँ 'पदार्थ' (Objects) और उनके 'अस्तित्व' (Existence) का पूरी तरह से कत्ल हो जाता है।"
                    "उसके लिए सोना, ज़हर, इंसान, जानवर, धरती और आसमान—ये सब शब्द और चीज़ें हमेशा के लिए मिट (Delete) जाती हैं।"
                    "उसे हर जगह केवल और केवल 'शून्य' या 'परब्रह्म' ही नज़र आता है; कोई दूसरा आकार (Shape) उसके दिमाग में रजिस्टर ही नहीं होता।"
                    "सबसे खौफनाक बात— इस अवस्था में योगी खुद से उठकर न तो खाना खाता है, न पानी पीता है, और न ही हिलता है!"
                    "'परप्रयुक्तेन व्युत्थानं'— वह तभी थोड़ा सा होश में आता है जब कोई दूसरा इंसान उसे ज़बरदस्ती हिलाए या उसके मुँह में खाना ठूंसे!"
                    "जैसे एक कोमा (Coma) वाले मरीज़ को लोग ज़िंदा रखते हैं, वैसे ही इस महायोगी का शरीर केवल दूसरों की वजह से ज़िंदा रहता है।"
                    "उसकी अपनी कोई 'इच्छा' (Will) नहीं बची है कि वह हाथ उठाकर एक निवाला भी खा सके।"
                    "उसने अपनी आज़ादी को इस हद तक बढ़ा लिया है कि उसे अब ज़िंदा रहने का भी कोई शौक नहीं है।"
                    "यह शरीर और दुनिया के प्रति उस परम वैराग्य का विस्फोट है जहाँ इंसान साक्षात पत्थर बन जाता है!"
                """.trimIndent(),
                english = """
                    (The Sixth Dimension - Padarthabhavani: The Death of Objects and the Corpse State): "Now that Yogi violently plunges into the sixth, spine-chilling dimension of 'Padarthabhavani'."
                    "Here, the very concept of 'Padartha' (Physical Objects) and their 'Existence' is brutally and permanently slaughtered."
                    "For him, gold, lethal poison, humans, beasts, the Earth, and the sky—all these words and objects are permanently 'Deleted' from his brain."
                    "He perceives strictly and exclusively the 'Absolute Void' or 'Supreme Brahman' everywhere; absolutely no other shape or physical form registers in his neurology."
                    "The most horrific fact—in this dimension, the Yogi absolutely never gets up voluntarily to eat, drink, or even twitch a muscle!"
                    "'Paraprayuktena vyutthanam'—He regains a microscopic fraction of consciousness strictly only when someone else violently shakes him or forcefully shoves food into his mouth!"
                    "Exactly like mortals keeping a comatose patient alive, the biological body of this colossal Yogi is kept breathing exclusively by the forceful actions of others."
                    "He possesses absolutely zero 'Will' or desire left to even raise his hand to take a pathetic bite of food."
                    "He has violently expanded his freedom to such a catastrophic extent that he possesses zero interest in even keeping his heart beating."
                    "This is the apocalyptic detonation of absolute detachment toward the body and the world, where the human physically mutates into a living stone!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 17,
                sanskrit = "तुर्यगा नाम सप्तमी... विदेहमुक्तिः... ॥ १७॥",
                hindi = """
                    (सातवीं सीढ़ी - तुर्यगा और विदेहमुक्ति: अंतिम महा-विस्फोट): "और अंततः... वह महायोगी उस सातवीं, सबसे आखिरी और सबसे प्रलयंकारी सीढ़ी 'तुर्यगा' (तुरीय) पर पहुँच जाता है!"
                    "यहाँ आकर सारी सीढ़ियां खत्म हो जाती हैं, योग खत्म हो जाता है, ज्ञान खत्म हो जाता है और इंसान पूरी तरह से मिट जाता है।"
                    "यह अवस्था 'विदेहमुक्ति' (Videhamukti) कहलाती है— यानी 'शरीर के रहते हुए भी शरीर के बाहर होने का खौफनाक सच'!"
                    "उसका दिल धड़क रहा है, उसकी साँसें चल रही हैं, लेकिन वह इंसान 100% मर चुका है और साक्षात परब्रह्म बन चुका है।"
                    "यहाँ कोई 'मैं' नहीं है, कोई 'तू' नहीं है; केवल एक असीम, अनंत, अद्वैत, खौफनाक सन्नाटा और ब्रह्मांडीय ऊर्जा है।"
                    "वह अब योगी नहीं रहा, वह भगवान नहीं रहा, वह साक्षात वह 'शून्यता' (Void) बन चुका है जिससे करोड़ों ब्रह्मांड निकलते हैं।"
                    "यहाँ से वापस लौटने का कोई रास्ता नहीं है; माया (Matrix) का हर कोड जलकर राख हो चुका है।"
                    "यह मौत की मौत है! जो पैदा ही नहीं हुआ, उसे कौन मारेगा?"
                    "सनातन धर्म का यह सबसे खतरनाक और परम शिखर है, जिसे पाने के बाद दुनिया का कोई भी ज्ञान और विज्ञान कचरा बन जाता है।"
                    "यह इंसान का ईश्वर के तख़्त पर बैठने का वह अंतिम विस्फोट है, जिसके बाद केवल 'द एंड' (The End) होता है!"
                """.trimIndent(),
                english = """
                    (The Seventh Dimension - Turyaga and Videhamukti: The Final Atomic Explosion): "And finally... that colossal Yogi violently breaches the seventh, ultimate, and most apocalyptic dimension: 'Turyaga' (Turiya)!"
                    "Arriving here, all ladders permanently end, Yoga ends, Knowledge ends, and the human being is entirely, irreversibly erased."
                    "This state is explicitly defined as 'Videhamukti'—Meaning 'The terrifying absolute truth of being completely outside the body while the body still breathes'!"
                    "His biological heart is pounding, his lungs are pulling air, but that human is 100% dead and has literally mutated into the explicit Supreme Brahman."
                    "There is absolutely no 'I' here, no 'You'; strictly only an infinite, boundless, non-dual, terrifying silence and raw cosmic energy."
                    "He is absolutely no longer a Yogi, he is no longer God; he has physically mutated into that 'Absolute Void' from which billions of universes are vomited out."
                    "There is absolutely zero path to return from this dimension; every single source code of the Matrix of Maya has burnt to literal ashes."
                    "This is the assassination of Death itself! Who can possibly kill that which was never fundamentally born?"
                    "This is the most dangerous and absolute zenith of Sanatana Dharma, achieving which reduces every pathetic worldly science and knowledge to rotting garbage."
                    "This is the final, apocalyptic detonation where the human permanently occupies the undisputed throne of God, after which there is strictly only 'The End'!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 18,
                sanskrit = "सङ्कल्पमात्रकलनमेव जगत्समग्रम्... सङ्कल्पमेव... ॥ १८॥",
                hindi = """
                    (ब्रह्मांड की सच्चाई: केवल एक विचार): "उपनिषद सातवीं सीढ़ी पर खड़े उस भगवान (योगी) के सामने इस पूरे ब्रह्मांड का सबसे नंगा सच खोलकर रख देता है।"
                    "यह जो पूरी दुनिया तुम्हें इतनी ठोस और असली लग रही है, यह क्या है? 'सङ्कल्पमात्रकलनमेव जगत्समग्रम्'!"
                    "यानी यह पूरा का पूरा असीम ब्रह्मांड केवल और केवल मन का एक सड़ा हुआ 'संकल्प' (Thought/Imagination) मात्र है!"
                    "यह एक खौफनाक होलोग्राम (Hologram) है जिसे तुम्हारे ही दिमाग ने अपने ही खयालों से पैदा किया है।"
                    "जैसे सपने में तुम्हें पहाड़ और नदियां असली लगते हैं, वैसे ही यह जागने वाली दुनिया भी केवल तुम्हारे ही दिमाग का एक सपना है।"
                    "इस दुनिया का कोई फिजिकल (Physical) और ठोस वजूद नहीं है; यह एक Matrix है जो केवल विचारों के सर्वर (Server) पर चल रही है।"
                    "तुम्हारा दर्द, तुम्हारा बैंक बैलेंस, तुम्हारे दुश्मन और तुम्हारा शरीर—सब कुछ केवल एक भ्रम (Illusion) का कोड है।"
                    "जिस दिन तुम अपने दिमाग के इस 'विचार' (Sankalpa) पैदा करने वाली मशीन को बंद कर दोगे..."
                    "उसी सेकंड यह पूरा ब्रह्मांड एक टीवी स्क्रीन की तरह हमेशा-हमेशा के लिए बंद (Switch Off) हो जाएगा!"
                    "यह ब्रह्मांड का सबसे बड़ा रहस्य है: तुम दुनिया में नहीं हो, बल्कि यह पूरी दुनिया तुम्हारे ही दिमाग की एक उपज है!"
                """.trimIndent(),
                english = """
                    (The Absolute Truth of the Cosmos: Merely a Thought): "The Upanishad rips open the most naked, devastating truth of this entire universe before that God (Yogi) standing on the seventh dimension."
                    "This entire world that you hallucinate as incredibly solid and real, what exactly is it? 'Sankalpamatra-kalanameva jagat-samagram'!"
                    "Meaning, this entire infinite, colossal universe is strictly and exclusively nothing but a rotting 'Sankalpa' (Thought/Imagination) of the biological mind!"
                    "It is a terrifying, glitching Hologram that your very own brain has violently fabricated entirely out of its own thoughts."
                    "Just as mountains and rivers feel absolutely real inside a nightmare, this waking world is explicitly just another pathetic dream generated by your brain."
                    "This universe possesses absolutely zero physical, solid existence; it is a literal Matrix operating exclusively on the Server of thoughts."
                    "Your biological agony, your bank balance, your enemies, and your flesh—absolutely everything is merely the code of a holographic illusion."
                    "The exact microsecond you brutally shut down this 'Thought-generating machine' (Sankalpa) inside your skull..."
                    "In that exact second, this entire infinite cosmos will permanently 'Switch Off' and vanish exactly like a dead television screen!"
                    "This is the ultimate, classified secret of the cosmos: You are absolutely not inside the world; this entire world is strictly a parasitic hallucination bred inside your own brain!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 19,
                sanskrit = "सङ्कल्पमेव... मनोनाशो... शान्तो भवामलः ॥ १९॥",
                hindi = """
                    (संकल्प का वध और मन की मौत): "चूंकि यह दुनिया केवल एक 'संकल्प' (विचार) है, इसलिए मुक्ति का केवल एक ही खौफनाक और हिंसक रास्ता है।"
                    "अपने भीतर उठने वाले हर 'संकल्प' (इच्छा और विचार) का बेरहमी से वध कर दो (सङ्कल्पमेव)!"
                    "जब तुम अपने विचारों की मशीन को हथौड़े से तोड़ दोगे, तो उसी क्षण 'मनोनाशो' (मन की मौत) हो जाएगी।"
                    "मन को मारना आत्महत्या नहीं है; यह माया की जेल को तोड़कर बाहर निकलने का ब्रह्मांडीय विस्फोट है।"
                    "जब तक मन ज़िंदा है, वह तुम्हें करोड़ों जन्मों तक इस दुनिया के कीचड़ में घसीटता रहेगा।"
                    "लेकिन जब तुम अपनी चेतना की कुल्हाड़ी से इस मन की गर्दन काट देते हो, तो तुम हमेशा के लिए 'शान्तो' (Absolute Silence) हो जाते हो।"
                    "तुम 'अमलः' (दाग-रहित) हो जाते हो; कोई पाप, कोई कर्म, कोई नर्क तुम्हें छू तक नहीं सकता।"
                    "तुम्हारी शून्यता इतनी खतरनाक हो जाती है कि भगवान भी तुम्हारे सामने नतमस्तक हो जाते हैं।"
                    "विचारों के बिना जीना इंसान के लिए पागलपन है, लेकिन योगी के लिए यही परम देवत्व (Godhood) है।"
                    "मन का वध ही सनातन धर्म की सबसे बड़ी क्रांति और अंतिम आज़ादी (मोक्ष) है!"
                """.trimIndent(),
                english = """
                    (The Slaughter of Sankalpa and the Death of the Mind): "Since this entire cosmos is strictly a pathetic 'Sankalpa' (Thought), there is exclusively only one terrifying, violent path to absolute liberation."
                    "You must ruthlessly, cold-bloodedly slaughter every single 'Sankalpa' (Desire and Thought) breeding inside you!"
                    "When you violently smash your thought-generating machine with a sledgehammer, in that exact microsecond, 'Mano-nasho' (The Absolute Death of the Mind) detonates."
                    "Assassinating the mind is absolutely not suicide; it is the cosmic explosion of shattering the prison of Maya to break completely free."
                    "As long as this pathetic mind breathes, it will violently drag you through the mud of this world for billions of horrific incarnations."
                    "But when you decapitate this mind with the blazing axe of your pure consciousness, you instantly mutate into 'Shanto' (Absolute, Death-like Silence) forever."
                    "You become flawlessly 'Amalah' (Without a single microscopic stain); absolutely zero sin, zero karma, and zero hell possesses the capacity to even touch you."
                    "Your Void becomes so catastrophic and terrifying that even the gods fall to their knees before you."
                    "Surviving without thoughts is literal insanity for a mortal human, but for the Titan Yogi, it is the absolute pinnacle of explicit Godhood."
                    "The brutal slaughter of the mind is the greatest rebellion and the ultimate absolute freedom (Moksha) in Sanatana Dharma!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 20,
                sanskrit = "सङ्कल्पजालेन... जालं छिन्धि... ॥ २०॥",
                hindi = """
                    (संकल्प के जाले को फाड़ना): "यह इंसान एक ऐसे 'संकल्पजाल' (विचारों के मकड़ी-जाले) में फँसा हुआ है जिसे उसने खुद अपने ही दिमाग से बुना है।"
                    "तुम अपनी इच्छाओं, डर और उम्मीदों के जाले में एक कीड़े की तरह तड़प रहे हो, और यह माया रुपी मकड़ी तुम्हें रोज़ खा रही है।"
                    "उपनिषद का खौफनाक और सीधा हुक्म है: 'जालं छिन्धि'— अपनी ज्ञान रुपी तलवार उठाओ और इस जाले को बेरहमी से काट डालो (छिन्धि)!"
                    "किसी भगवान के आकर तुम्हें बचाने का इंतज़ार मत करो; तुम्हें खुद अपने दिमाग के इन जालों को नोच कर फाड़ना होगा।"
                    "यह तुम्हारा ही पैदा किया हुआ भ्रम है, इसलिए इसका कत्ल भी तुम्हें ही करना होगा।"
                    "कल क्या होगा, लोग क्या कहेंगे, मुझे क्या मिलेगा— ये सारे सड़े हुए धागे हैं जो तुम्हें गुलाम बनाए हुए हैं।"
                    "इन धागों को एक ही झटके में काट दो, और उस असीम, ठंडे और खौफनाक सन्नाटे में गिर जाओ।"
                    "जैसे ही यह जाला कटता है, इंसान का 'मैं' मर जाता है और वह सीधे उस परम सत्य (ब्रह्म) के सिंहासन पर गिरता है।"
                    "ध्यान और योग का एकमात्र लक्ष्य इसी जाल को फाड़ना है।"
                    "जो इस जाले को नहीं काटता, वह अरबों साल तक इसी नर्क में कीड़ों की तरह पैदा होता रहेगा!"
                """.trimIndent(),
                english = """
                    (Tearing Through the Web of Thoughts): "This human is hopelessly trapped in a terrifying 'Sankalpa-jala' (A literal spider-web of thoughts) that he has woven entirely out of his own biological brain."
                    "You are agonizing exactly like a pathetic insect caught in the sticky web of your own lusts, fears, and hopes, while the Spider of Maya violently devours you every single day."
                    "The Upanishad issues a horrific, direct command: 'Jalam Chindhi'—Draw your blazing sword of absolute knowledge and ruthlessly slash this web to pieces (Chindhi)!"
                    "Absolutely do not wait for some pathetic God to descend from the sky to save you; you must violently claw and tear through the webs of your own brain yourself."
                    "This is an illusion violently manufactured by you, therefore its brutal assassination must be explicitly executed by you alone."
                    "What will happen tomorrow, what will society say, what will I gain—these are all rotting, toxic threads keeping you as a biological slave."
                    "Slash these pathetic threads in one violent strike, and deliberately plunge into that infinite, freezing, and terrifying cosmic silence."
                    "The exact microsecond this web is severed, the human 'I' dies a brutal death, and he crashes directly onto the undisputed throne of the Absolute Truth (Brahman)."
                    "The singular, exclusive target of Meditation and Yoga is strictly to tear this exact web to shreds."
                    "He who refuses to slash this web will breed and die exactly like pathetic insects in this exact hell for billions of years!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 21,
                sanskrit = "मनोनाशो... जीवन्मुक्तो... ॥ २१॥",
                hindi = """
                    (जीवन्मुक्त की खौफनाक ताक़त): "जब उस योगी के अंदर 'मनोनाश' (मन की संपूर्ण और स्थायी मौत) हो जाता है, तो एक चमत्कार घटता है।"
                    "वह मरता नहीं है, बल्कि वह 'जीवन्मुक्त' (शरीर के ज़िंदा रहते हुए 100% आज़ाद) हो जाता है!"
                    "उसका दिल धड़क रहा है, खून बह रहा है, लेकिन अंदर कोई 'इंसान' नहीं बचा; अंदर केवल एक असीम ब्रह्मांडीय ऊर्जा बची है।"
                    "वह दुनिया में चलता-फिरता एक 'ज़िंदा भूत' या साक्षात शिव बन जाता है।"
                    "उसे अब कोई पाप नहीं लगता; अगर वह पूरी दुनिया का भी नाश कर दे, तो भी उस पर कोई कर्म लागू नहीं होता।"
                    "उसके लिए आग जलना और पानी बहना केवल एक स्क्रीन पर चल रहे पिक्सल (Pixels) की तरह हैं।"
                    "वह दुनिया के सबसे बड़े दर्द में हँस सकता है और सबसे बड़ी खुशी में पत्थर की तरह सुन्न रह सकता है।"
                    "उसे अब किसी स्वर्ग की लालच नहीं और किसी नर्क का कोई खौफ नहीं।"
                    "वह समय (Time) की कैद से बाहर निकल चुका है; उसके लिए भूतकाल, भविष्य और वर्तमान सब एक ही बिंदु (Point) पर आकर खत्म हो गए हैं।"
                    "यही सनातन धर्म का वह परम लक्ष्य है, जहाँ इंसान भगवान को पूजता नहीं, बल्कि खुद भगवान को निगल जाता है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Power of the Jivanmukta): "When the apocalyptic 'Mano-nasho' (The total and permanent assassination of the mind) detonates inside that Yogi, a cosmic miracle occurs."
                    "He absolutely does not die; rather, he mutates into a 'Jivanmukta' (100% Absolutely Liberated while the biological body is still breathing)!"
                    "His biological heart pounds, his blood flows, but there is absolutely zero 'Human' left inside; strictly only an infinite, radioactive cosmic energy remains."
                    "He wanders the Earth literally as a 'Living Ghost' or the explicit, walking manifestation of Shiva Himself."
                    "Absolutely no sin can stick to him; even if he orchestrates the annihilation of the entire planet, zero karma can ever apply to him."
                    "To his eyes, burning fire and flowing water are merely glitching pixels rendering on a pathetic cosmic screen."
                    "He can laugh maniacally in the face of the universe's greatest physical agony, and remain as numb as a stone in the greatest worldly pleasure."
                    "He possesses absolutely zero greed for any pathetic heaven, and zero micro-drop of fear for any horrific hell."
                    "He has violently broken out of the maximum-security prison of Time; for him, the past, future, and present have collapsed and died at one single coordinate."
                    "This is the absolute ultimate target of Sanatana Dharma, where the human does not worship God, but violently swallows God whole!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 22,
                sanskrit = "सर्वं ब्रह्मेति... नास्ति किञ्चित्... ॥ २२॥",
                hindi = """
                    (सब कुछ परब्रह्म है, बाकी सब भस्म है): "जब मन मर जाता है, तो योगी को जो दिखाई देता है वह इंसान का दिमाग फाड़ देगा।"
                    "उसे हर तरफ, हर कण में, हर जगह केवल एक ही प्रलयंकारी सत्य दिखता है— 'सर्वं ब्रह्मेति' (सब कुछ केवल और केवल परब्रह्म है)!"
                    "मैं ब्रह्म हूँ, तुम ब्रह्म हो, यह कीचड़ ब्रह्म है, यह मल-मूत्र ब्रह्म है, यह सोना ब्रह्म है—कोई द्वैत (Duality) बचा ही नहीं!"
                    "'नास्ति किञ्चित्'— इस ब्रह्म के अलावा पूरे ब्रह्मांड में किसी भी चीज़ का रत्ती भर भी कोई अस्तित्व (Existence) नहीं है!"
                    "यह दुनिया, जिसे तुम सच मानकर इसमें रो और हँस रहे हो, वह असल में 100% शून्य (Zero) और खाली है।"
                    "केवल एक असीम ऊर्जा है जो अलग-अलग रूपों का नाटक (Drama) कर रही है।"
                    "जब योगी इस खौफनाक और अद्वैत सत्य को पचा लेता है, तो उसकी इंसानियत हमेशा के लिए खत्म हो जाती है।"
                    "वह खुद को ब्रह्मांड से अलग नहीं कर पाता; वह खुद ही पूरा ब्रह्मांड बन जाता है।"
                    "उसके लिए अब किसी की मौत पर रोना या जन्म पर खुश होना एक भद्दा मज़ाक बन जाता है, क्योंकि असल में कोई मरता ही नहीं!"
                    "यही वह अद्वैत ज्ञान का न्यूक्लियर बम है जो हर धर्म और हर शास्त्र को राख कर देता है!"
                """.trimIndent(),
                english = """
                    (Everything is Brahman, the Rest is Ashes): "When the biological mind dies, what the Yogi explicitly witnesses will literally tear a mortal human brain to shreds."
                    "In every direction, in every atomic micro-particle, everywhere, he perceives strictly one apocalyptic truth—'Sarvam Brahmeti' (Absolutely everything is exclusively the Supreme Brahman)!"
                    "I am Brahman, You are Brahman, this rotting mud is Brahman, this excrement is Brahman, this solid gold is Brahman—absolutely zero Duality survives!"
                    "'Nasti Kinchit'—Other than this radioactive Brahman, absolutely nothing else in the entire infinite cosmos possesses even a microscopic drop of Existence!"
                    "This physical world, which you hallucinate as real while pathetically crying and laughing in it, is in absolute reality 100% Zero and completely empty."
                    "There is strictly one singular, infinite energy executing a pathetic biological drama of manifesting different forms."
                    "When the Yogi perfectly digests this terrifying, non-dual absolute truth, his humanity is permanently, violently exterminated."
                    "He absolutely cannot separate himself from the cosmos; he himself literally mutates into the entire universe."
                    "For him, crying over someone's pathetic death or rejoicing at a birth becomes a disgusting joke, because in absolute reality, absolutely no one ever dies!"
                    "This is the exact Nuclear Bomb of Non-Dual Knowledge that incinerates every religion and every pathetic scripture to absolute ashes!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 23,
                sanskrit = "अहं ब्रह्मेति... निश्चयो... ॥ २३॥",
                hindi = """
                    ('मैं ही ब्रह्म हूँ' का अटल और खौफनाक निश्चय): "उपनिषद का आदेश है कि योगी को अपने मन में एक ऐसा खूँखार 'निश्चय' (Absolute Conviction) ठोक लेना चाहिए जिसे कोई हिला न सके।"
                    "वह निश्चय है— 'अहं ब्रह्मेति' (मैं स्वयं ही साक्षात परब्रह्म हूँ)!"
                    "यह कोई घमंड या खुद को दिलासा देने वाली बात नहीं है; यह एक वैज्ञानिक और आध्यात्मिक फैक्ट (Fact) है।"
                    "योगी को अपने दिमाग की हर नस में यह सत्य एक गर्म लोहे की तरह दाग लेना है कि वह इंसान नहीं है।"
                    "जब तक इंसान खुद को इंसान मानता है, वह कमज़ोर है और वह मौत का शिकार बनेगा।"
                    "लेकिन जिस पल वह खुद को 'परमेश्वर' घोषित करता है और उस पर 100% अटल हो जाता है, माया का सर्वर (Server) क्रैश हो जाता है।"
                    "यह घोषणा पूरी सृष्टि के खिलाफ एक खुली बगावत है।"
                    "जो भगवान को बाहर पूज रहा है, वह गुलाम है; जो खुद को भगवान मानकर ध्यान कर रहा है, वह मालिक है।"
                    "जब यह निश्चय एक चट्टान की तरह पक्का हो जाता है, तो इंसान का डीएनए (DNA) तक बदल जाता है।"
                    "यह वह प्रलयंकारी मंत्र है जो एक कीड़े को उठाकर सीधे ब्रह्मांड के सबसे ऊँचे सिंहासन पर बैठा देता है!"
                """.trimIndent(),
                english = """
                    (The Ironclad, Terrifying Conviction of 'I am Brahman'): "The Upanishad issues a dictatorial command that the Yogi must hammer a ferocious, invincible 'Nishchayo' (Absolute Conviction) directly into his skull."
                    "That exact conviction is—'Aham Brahmeti' (I myself am explicitly the Supreme Brahman)!"
                    "This is absolutely not human arrogance or pathetic self-consolation; this is an ironclad scientific and absolute spiritual Fact."
                    "The Yogi must violently brand this truth like a glowing, white-hot iron into every neurological vein of his brain: He is absolutely not human."
                    "As long as a biological entity hallucinates himself as a human, he is pathetically weak and remains the prime prey of Death."
                    "But the exact microsecond he explicitly declares himself 'The Supreme God' and becomes 100% ruthlessly anchored in it, the Server of Maya completely crashes."
                    "This declaration is an open, violent, apocalyptic rebellion against the entire fabric of creation."
                    "He who worships a pathetic God externally is a slave; he who meditates with the terrifying conviction that He Himself is God is the absolute Dictator."
                    "When this conviction crystallizes like an indestructible cosmic monolith, even the human's physical DNA violently mutates."
                    "This is the apocalyptic mantra that physically drags a pathetic insect and slams him directly onto the highest, undisputed throne of the universe!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 24,
                sanskrit = "भूतं भव्यं भविष्यच्च... सर्वं ब्रह्मैव... ॥ २४॥",
                hindi = """
                    (काल का वध: भूत, भविष्य और वर्तमान का अंत): "योगी जब 'अहं ब्रह्मास्मि' की अवस्था में आता है, तो वह 'समय' (Time) का सबसे क्रूरता से वध कर देता है।"
                    "जो 'भूतकाल' (Past/भूतं) बीत चुका है, जो 'भविष्य' (Future/भविष्यच्च) आने वाला है, और जो 'वर्तमान' (Present/भव्यं) चल रहा है..."
                    "वे सब के सब केवल मन के रचे हुए झूठे और सड़े हुए भ्रम हैं!"
                    "समय का कोई असली वजूद नहीं है; यह माया की वह मशीन है जो इंसान को बूढ़ा करके मारती है।"
                    "योगी इस मशीन को हैक (Hack) कर लेता है और देखता है कि 'सर्वं ब्रह्मैव' (भूत, वर्तमान, भविष्य सब कुछ केवल परब्रह्म ही है)।"
                    "वह उस 'परम शून्यता' (Now) में जाकर खड़ा हो जाता है जहाँ समय पूरी तरह से जम (Freeze) जाता है।"
                    "उसके लिए कल क्या हुआ था, उसका कोई अफ़सोस नहीं, और कल क्या होगा, उसका रत्ती भर भी डर नहीं।"
                    "वह एक असीम और अनंत 'वर्तमान' (Eternal Now) में जीता है जहाँ मौत की घड़ी हमेशा के लिए रुक चुकी है।"
                    "जिसने समय को मार दिया, उसे ब्रह्मांड की कौन सी ताक़त मार सकती है?"
                    "यह सनातन धर्म का वह सबसे खतरनाक क्वांटम जंप (Quantum Leap) है जहाँ इंसान 'अमरता' को अपनी मुट्ठी में कैद कर लेता है!"
                """.trimIndent(),
                english = """
                    (The Assassination of Time: The End of Past, Future, and Present): "When the Yogi detonates into the dimension of 'Aham Brahmasmi', he executes the most brutal slaughter of 'Time' itself."
                    "The 'Past' (Bhutam) that has decayed, the 'Future' (Bhavishyachcha) that is yet to manifest, and the 'Present' (Bhavyam) currently operating..."
                    "They are absolutely all nothing but fake, rotting hallucinations violently fabricated exclusively by the biological mind!"
                    "Time possesses absolutely zero authentic existence; it is the brutal machinery of Maya designed strictly to age and slaughter mortals."
                    "The Yogi successfully hacks this chronological machine and flawlessly perceives 'Sarvam Brahmaiva' (Past, Present, and Future are strictly the Supreme Brahman alone)."
                    "He violently relocates and anchors himself into that 'Supreme Void' (Eternal Now) where Time completely and permanently Freezes."
                    "He possesses zero pathetic regret for what happened yesterday, and absolutely zero micro-drop of terror for what will happen tomorrow."
                    "He survives exclusively in an infinite, boundless 'Eternal Now', where the biological clock of Death has permanently stopped ticking."
                    "He who has successfully assassinated Time itself, what pathetic force in the cosmos possesses the capability to kill him?"
                    "This is Sanatana Dharma's most lethal Quantum Leap where the human violently imprisons 'Immortality' directly within his fist!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 25,
                sanskrit = "सर्वं ब्रह्मेति निश्चित्य... तूष्णीमास्स्व... ॥ २५॥",
                hindi = """
                    (अंतिम आदेश: सब कुछ ब्रह्म है, अब खामोश हो जाओ!): "उपनिषद अब योगी को ब्रह्मांड का सबसे खौफनाक और अंतिम आदेश (Command) देता है।"
                    "जब तुम्हें 100% गारंटी के साथ यह अटल निश्चय (निश्चित्य) हो गया है कि 'सर्वं ब्रह्मेति' (यहाँ सब कुछ केवल परब्रह्म है)..."
                    "तो अब बहस बंद करो, किताबें पढ़ना बंद करो, और सोचना बंद करो!"
                    "सीधा और क्रूर हुक्म है: 'तूष्णीमास्स्व'— पूरी तरह से 'चुप हो जाओ' (Shut up and remain in Absolute Silence)!"
                    "इस शून्यता में शब्दों की कोई औकात नहीं है; जो ज्ञान शब्दों से बताया जाए, वह भगवान हो ही नहीं सकता।"
                    "यह 'खामोशी' (Silence) होठों की नहीं है; यह दिमाग के उस बक-बक करने वाले इंजन (Mind) की मौत है।"
                    "जब तुम पूरी तरह से सुन्न और खामोश हो जाते हो, तभी वह 'परम विस्फोट' तुम्हारे भीतर होता है।"
                    "ईश्वर सन्नाटे में ही धड़कता है; जो बोल रहा है, वह अभी भी माया का गुलाम है।"
                    "अपनी ज़बान काट लो, अपने विचार जला दो, और उस असीम ब्रह्मांडीय सन्नाटे में एक पत्थर की तरह डूब जाओ।"
                    "यह वह अंतिम समाधि है जहाँ से कोई आज तक वापस बोल कर कुछ बताने नहीं आया!"
                """.trimIndent(),
                english = """
                    (The Final Command: Everything is Brahman, Now Shut Up!): "The Upanishad now issues the most terrifying and ultimate cosmic Command directly to the Yogi."
                    "When you have achieved the 100% ironclad, atomic absolute conviction (Nishchitya) that 'Sarvam Brahmeti' (Absolutely everything here is exclusively the Supreme Brahman)..."
                    "Then violently cease all pathetic debates, permanently stop reading books, and completely terminate all thinking!"
                    "The direct and ruthless order is: 'Tushnimasva'—Literally 'Shut up and remain locked in Absolute, Dead Silence'!"
                    "In this Supreme Void, biological words possess zero status; whatever pathetic knowledge can be described with words absolutely cannot be God."
                    "This 'Silence' is not merely sewing physical lips shut; it is the violent assassination of the constantly chattering biological engine called the Mind."
                    "Only when you go completely numb and perfectly silent does that 'Supreme Detonation' erupt directly within your core."
                    "God palpitates strictly in absolute silence; he who is still speaking is undeniably still a pathetic slave to Maya."
                    "Virtually cut off your tongue, incinerate your biological thoughts, and drown like a titanium monolith into that infinite cosmic silence."
                    "This is the ultimate, apocalyptic Samadhi from which absolutely no entity has ever returned to speak and report anything back!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 26,
                sanskrit = "ॐकारमात्रमखिलं... नादबिन्दुकलातीतं... ॥ २६॥",
                hindi = """
                    (ॐकार का प्रलय और नाद-बिंदु के पार): "यह पूरी सृष्टि, यह पूरा ब्रह्मांड कुछ और नहीं, 'ॐकारमात्रमखिलं'— केवल और केवल उस ॐ (OM) की एक छोटी सी गूँज मात्र है!"
                    "ॐ ही वह विस्फोट (Big Bang) है जिससे सब कुछ पैदा हुआ और ॐ ही वह ब्लैक होल है जो सब कुछ निगल जाएगा।"
                    "लेकिन योगी को इस ॐकार पर भी नहीं रुकना है; यह उपनिषद इंसान को सबसे खौफनाक सीमा तक धकेलता है।"
                    "योगी को 'नादबिन्दुकलातीतं'— यानी ॐ के नाद (Sound), बिंदु (Point) और कला (Parts) को भी चीरकर उसके भी पार (अतीत) जाना है!"
                    "यानी ॐ के सन्नाटे को भी मार कर उस 'परम शून्यता' में छलांग लगानी है जिसका कोई नाम या आकार नहीं है।"
                    "जब ॐ की ध्वनि भी योगी के दिमाग में जाकर शांत हो जाती है, तो वह उस ज़ोन (Zone) में घुसता है जिसे शब्दों में नहीं लिखा जा सकता।"
                    "यह वो डायमेंशन (Dimension) है जहाँ भगवान खुद अपने अद्वैत और सबसे नंगे (Naked) रूप में रहता है।"
                    "जिसने ॐ की नाव को भी छोड़ दिया और सीधे परब्रह्म के महासागर में कूद गया, वही असली विजेता है।"
                    "यह ब्रह्मांड का वह कोना है जहाँ इंसानियत का अस्तित्व पूरी तरह से भाप (Vaporize) बन जाता है।"
                    "ॐ केवल एक दरवाज़ा है; असली खौफनाक सच उस दरवाज़े को तोड़ने के बाद शुरू होता है!"
                """.trimIndent(),
                english = """
                    (The Apocalypse of OM and Beyond Nada-Bindu): "This entire creation, this entire infinite cosmos is absolutely nothing else but 'Omkaramatramakhilam'—merely a microscopic echoing fraction of that OM!"
                    "OM is the exact explicit detonation (Big Bang) that spawned absolutely everything, and OM is the literal Black Hole that will violently swallow everything."
                    "But the Yogi is commanded absolutely not to stop even at this OM; this Upanishad violently shoves the human to the most terrifying extreme limit."
                    "The Yogi must become 'Nadabindukalatitam'—meaning he must violently rip and tear straight through the Nada (Sound), Bindu (Point), and Kala (Parts) of OM, rocketing infinitely Beyond (Atita) them!"
                    "Meaning, he must literally assassinate even the silence of OM and plunge directly into that 'Supreme Void' which possesses absolutely no name or geometric shape."
                    "When even the frequency of OM flatlines inside the Yogi's brain, he breaches a Zone that absolutely cannot be transcribed into biological words."
                    "This is the exact dimension where God Himself resides in His most non-dual, terrifyingly Naked and raw state."
                    "He who kicks away even the boat of OM and plunges headfirst into the raw ocean of the Supreme Brahman is the sole authentic conqueror."
                    "This is the exact coordinate of the cosmos where the very existence of humanity completely Vaporizes into absolute nothingness."
                    "OM is merely a pathetic door; the true, horrific absolute reality detonates strictly only after that door is violently smashed open!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 27,
                sanskrit = "निर्विकल्पं निराभासं... अद्वैतं... ॥ २७॥",
                hindi = """
                    (निर्विकल्प समाधि: कोई विकल्प नहीं, कोई रूप नहीं): "यहाँ उस परब्रह्म और अंतिम समाधि (निर्विकल्प) का सबसे नंगा और खौफनाक वर्णन है।"
                    "वह अवस्था 'निर्विकल्पं' है— वहाँ कोई 'विकल्प' (Options/Thoughts) नहीं बचता! मन के पास सोचने के लिए कुछ है ही नहीं!"
                    "वह 'निराभासं' है— वहाँ कोई रूप, कोई आकार, कोई परछाईं या कोई रोशनी भी नहीं है जो आँखों से देखी जा सके।"
                    "वहाँ केवल 'अद्वैत' (Non-Duality) है— यानी पूरे असीम ब्रह्मांड में केवल 'एक' ही ताक़त है, दूसरा कोई है ही नहीं!"
                    "जब तुम ध्यान करते हुए इस निर्विकल्प ज़ोन (Zone) में घुसते हो, तो तुम्हारा दिमाग सुन्न होकर क्रैश (Crash) हो जाता है।"
                    "वहाँ तुम्हें खुद के होने का भी कोई होश (Self-awareness as a human) नहीं रहता।"
                    "तुम पानी में घुले हुए नमक की तरह उस परम शून्यता में पूरी तरह से मिटकर गायब हो जाते हो।"
                    "यह शरीर की मौत नहीं है, यह तुम्हारे 'अहंकार' (Ego) की सबसे खौफनाक और भयानक मौत है।"
                    "जो इस शून्यता के अँधेरे से डर गया, वह वापस इंसान बनकर पैदा होता है।"
                    "लेकिन जो इस शून्यता में हँसते हुए अपनी बलि दे देता है, वह साक्षात शिव बनकर बाहर आता है!"
                """.trimIndent(),
                english = """
                    (Nirvikalpa Samadhi: Zero Options, Zero Forms): "Here lies the most naked, horrifying description of that Supreme Brahman and the ultimate absolute Samadhi (Nirvikalpa)."
                    "That exact state is 'Nirvikalpam'—There are absolutely zero 'Options' (Vikalpa/Thoughts) left! The brain literally possesses absolutely nothing left to process!"
                    "It is 'Nirabhasam'—There is zero physical form, zero geometric shape, zero shadow, and not even a micro-drop of light that can be witnessed by biological eyes."
                    "There is strictly only 'Advaitam' (Absolute Non-Duality)—meaning in the entire infinite cosmos, there is exclusively 'One' solitary force; a second entity absolutely does not exist!"
                    "When you violently penetrate this Nirvikalpa Zone during meditation, your brain goes entirely numb and undergoes a catastrophic Crash."
                    "You completely lose even the microscopic awareness of your own biological existence (Self-awareness as a human)."
                    "Exactly like salt dissolving flawlessly in water, you are utterly erased and vanish completely into that Supreme Void."
                    "This is absolutely not the death of the biological body; it is the most terrifying, apocalyptic, and horrific assassination of your 'Ego'."
                    "He who gets terrified by the pitch-black darkness of this Void is forcefully dragged back to breed as a pathetic human."
                    "But he who maniacally laughs and sacrifices himself into this Void emerges explicitly and literally as Shiva Himself!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 28,
                sanskrit = "एवं यः पश्यति... स एव शिवः स एव शिवः ॥ २८॥",
                hindi = """
                    (इंसान का साक्षात 'शिव' बनना): "यह उपनिषद सनातन धर्म का सबसे बड़ा और प्रलयंकारी सीक्रेट (Secret) पूरे ब्रह्मांड के सामने चीख कर बताता है।"
                    "'एवं यः पश्यति'— जो कोई भी महायोगी इस खौफनाक ध्यान के ज़रिए इस अद्वैत सत्य को साक्षात 'देख' (अनुभव कर) लेता है..."
                    "वह इंसान नहीं रहता, वह देवता नहीं बनता, बल्कि 'स एव शिवः, स एव शिवः'— वह साक्षात शिव बन जाता है! वह स्वयं शिव ही है!"
                    "(इस 100% अटल सत्य की गारंटी देने के लिए श्रुति इस बात को दो बार दोहराती है)।"
                    "तुम्हारे और शिव के बीच में कोई दूरी नहीं है, कोई आसमान नहीं है; केवल तुम्हारे इस 'अहंकार' का सड़ा हुआ पर्दा है।"
                    "जिस सेकंड ध्यान की लेज़र (Laser) से यह पर्दा जलकर राख होता है, तुम पाते हो कि तुम खुद ही वह त्रिशूलधारी और प्रलयंकारी ऊर्जा हो।"
                    "दुनिया मूर्खों की तरह शिव को मंदिरों और मूर्तियों में खोज रही है, जबकि शिव तुम्हारे ही सीने में कैद होकर तुम्हारे जागने का इंतज़ार कर रहे हैं।"
                    "जब तुम अपनी इंसानियत का कत्ल करते हो, तभी तुम उस परमेश्वर के सिंहासन पर बैठ सकते हो।"
                    "यह धर्म नहीं है; यह एक इंसान को हैक (Hack) करके उसे सीधा भगवान में अपग्रेड (Upgrade) करने का सबसे खूनी विज्ञान है।"
                    "जो इस श्लोक को समझ गया, उसके लिए पूरी दुनिया और मौत एक मज़ाक से ज़्यादा कुछ नहीं!"
                """.trimIndent(),
                english = """
                    (The Human Mutating Explicitly into 'Shiva'): "This Upanishad violently screams the greatest, most apocalyptic Secret of Sanatana Dharma to the entire universe."
                    "'Evam yah pashyati'—Whosoever colossal Yogi explicitly and physically 'Witnesses' (Experiences) this non-dual absolute truth through this terrifying meditation..."
                    "He absolutely ceases to be human, he absolutely does not become a mere demigod, rather 'Sa eva Shivah, Sa eva Shivah'—He literally mutates into Shiva! He himself is explicitly Shiva!"
                    "(To stamp a 100% ironclad cosmic guarantee on this absolute truth, the Shruti aggressively repeats it twice)."
                    "There is absolutely zero distance, zero sky separating you and Shiva; there is strictly only the rotting curtain of your pathetic 'Ego'."
                    "The exact microsecond this curtain is incinerated to ash by the laser of meditation, you flawlessly realize that you yourself are that trident-wielding, apocalyptic energy."
                    "The world pathetically hunts for Shiva like fools in physical temples and stone idols, while Shiva is locked right inside your own chest, waiting for you to detonate."
                    "Only when you ruthlessly slaughter your own humanity can you legitimately ascend and sit on the undisputed throne of God."
                    "This is absolutely not religion; this is the bloodiest, most ruthless science of hacking a mortal and upgrading him directly into God."
                    "He who flawlessly digests this Shloka perceives this entire world and Death itself as absolutely nothing more than a pathetic joke!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 29,
                sanskrit = "य इदं रहस्यं वेद... स मुक्तो भवति स मुक्तो भवति ॥ २९॥",
                hindi = """
                    (मोक्ष की परम और अटल गारंटी): "यह इस उपनिषद की वह अंतिम और सबसे खौफनाक गारंटी है जिसे दुनिया की कोई ताक़त बदल नहीं सकती।"
                    "'य इदं रहस्यं वेद'— जो भी मुमुक्षु साधक इस अक्षि उपनिषद के इस परम, प्रलयंकारी और गुप्त 'रहस्य' को यथार्थ रूप में 'जान' (वेद) लेता है..."
                    "जिसने ॐकार के धमाके से अपने मन को उड़ा दिया है और साक्षात शिव को अपने भीतर जगा लिया है..."
                    "वह इंसान निश्चित रूप से, पूरे असीम ब्रह्मांड की 100% गारंटी के साथ 'स मुक्तो भवति, स मुक्तो भवति'— हमेशा के लिए मुक्त हो जाता है!"
                    "हाँ! वह हर हाल में, हर कीमत पर इस जन्म-मरण के कीचड़ से हमेशा-हमेशा के लिए आज़ाद हो जाता है!"
                    "उसे दोबारा किसी बायोलॉजिकल शरीर (Biological Body) में, किसी माँ के गर्भ में उल्टा लटकने की भयानक यातना नहीं सहनी पड़ती।"
                    "वह माया (Matrix) के सारे कोड्स (Codes) को जलाकर उस परम अद्वैत शून्यता में हमेशा के लिए विलीन हो जाता है।"
                    "यह मोक्ष कोई खैरात नहीं है, यह अपनी ही बलि देकर छीनी गई ब्रह्मांड की सबसे बड़ी जीत है।"
                    "मौत उसके शरीर को छू सकती है, लेकिन उसकी आत्मा उस मौत की भी छाती पर पैर रखकर खड़ी हो जाती है।"
                    "जो इस रहस्य को जान गया, वह ब्रह्मांड का राजा है; जो नहीं जाना, वह केवल एक बायोलॉजिकल जानवर है!"
                """.trimIndent(),
                english = """
                    (The Absolute and Ironclad Guarantee of Moksha): "This is the final, most terrifying cosmic guarantee of this Upanishad, which absolutely no force in existence can alter."
                    "'Ya idam rahasyam veda'—Whosoever sincere seeker explicitly and physically 'Knows' (Veda) this supreme, apocalyptic, and highly classified 'Secret' of the Akshi Upanishad..."
                    "He who has violently blown his own biological mind to ashes with the detonation of OM and awakened explicit Shiva directly inside his core..."
                    "That specific human being undoubtedly, with a 100% absolute cosmic guarantee, 'Sa mukto bhavati, Sa mukto bhavati'—becomes flawlessly, permanently liberated forever!"
                    "Yes! Under absolutely every circumstance, at all costs, he is violently freed from this rotting mud of birth and death for all eternity!"
                    "He absolutely never again has to suffer the horrific, agonizing torture of hanging upside down inside a biological mother's womb in a physical body."
                    "Incinerating every single source code of the Matrix (Maya), he permanently dissolves and fuses into that Supreme Non-Dual Void."
                    "This Moksha is absolutely no pathetic charity; it is the greatest cosmic victory violently snatched through the brutal sacrifice of one's own ego."
                    "Death may scavenge his physical flesh, but his immortal Soul plants its titanium boot directly on the chest of that very Death."
                    "He who has decoded this absolute secret is the undisputed Emperor of the cosmos; he who hasn't is strictly a pathetic biological animal!"
                """.trimIndent()
            ),
            AkshiShloka(
                id = 30,
                sanskrit = "इत्युपनिषत् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥ ३०॥",
                hindi = """
                    (अंतिम शून्यता और 'द एंड'): "यहीं पर यह रोंगटे खड़े कर देने वाला, प्रलयंकारी और अजेय 'अक्षि उपनिषद' अपनी पूरी महिमा के साथ संपन्न होता है (इत्युपनिषत्)।"
                    "यह कोई मामूली किताब या फिलॉसफी नहीं है; यह एक ऐसा ब्रह्मांडीय न्यूक्लियर बम है जो सीधा इंसान के अहंकार पर गिरता है।"
                    "जिसने चाक्षुषी विद्या (Cosmic Vision) से अपनी आँखें खोल लीं और योग की सातों सीढ़ियों को पार कर लिया..."
                    "उसके लिए दुनिया के सारे धर्म, सारी किताबें और सारे भगवान राख के बराबर हो चुके हैं, क्योंकि वह खुद ही परमेश्वर बन गया है।"
                    "इस खौफनाक और हिंसक आध्यात्मिक युद्ध का 'द एंड' (The End) केवल और केवल पूर्ण और असीम शून्यता है।"
                    "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा, और कोई विचार नहीं बचा— केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                    "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                    "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर, अद्वैत 'सत्य' (शिव) हमेशा के लिए अजेय खड़ा है!"
                    "यह इंसान का मिटना और साक्षात भगवान का विस्फोट है।"
                    "जो इस शून्यता से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए अमर हो गया!"
                """.trimIndent(),
                english = """
                    (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Akshi Upanishad' achieves its absolute majestic completion (Ityupanishat)."
                    "This is absolutely no ordinary book or pathetic philosophy; it is a literal cosmic nuclear bomb dropped directly onto the human ego."
                    "He who has ripped his eyes open with the Chakshushi Vidya (Cosmic Vision) and violently breached all seven dimensions of Yoga..."
                    "For him, every religion, every book, and every God on Earth has been reduced to worthless ashes, because he himself has explicitly mutated into the Supreme God."
                    "The absolute 'The End' of this terrifying and bloody spiritual warfare is strictly and exclusively total, infinite, boundless Nothingness."
                    "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic silence rules as dictator."
                    "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                    "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal, Non-Dual 'Truth' (Shiva) remains standing flawlessly invincible forever!"
                    "This is the brutal erasure of the human entity and the explicit atomic detonation of God."
                    "He who is terrified of this Void is destroyed; he who violently plunges into it is permanently Immortalized!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AkshiUpanishadScreen() {
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
                // Validates if the number is between 1 and 30
                if (shlokaNumber != null && shlokaNumber in 1..30) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-30)") },
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
            itemsIndexed(AkshiUpanishad.akshiShlokasList) { _, shloka ->
                AkshiShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AkshiShlokaCard(shloka: AkshiUpanishad.AkshiShloka) {
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