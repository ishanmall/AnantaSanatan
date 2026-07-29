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
data class HayagrivaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class HayagrivaUpanishad {

    val hayagrivaShlokasList = listOf(
        HayagrivaShloka(
            id = 1,
            sanskrit = "ॐ भद्रं कर्णेभिः शृणुयाम देवाः भद्रं पश्येमाक्षभिर्यजत्राः । स्थिरैरङ्गैस्तुष्टुवाꣳसस्तनूभिर्व्यशेम देवहितं यदायुः ॥",
            hindi = """
                (परम सुरक्षा का शांति मंत्र): "यह हयग्रीव उपनिषद ब्रह्मांड के सबसे बड़े ज्ञान का न्यूक्लियर पासवर्ड (Password) है।"
                "योगी अपने बायोलॉजिकल सिस्टम को हैक करने के लिए सबसे पहले अपनी 'श्रवण शक्ति' को शुद्ध करता है।"
                "वह देवताओं को सीधा आदेश देता है: 'मेरे कान केवल उस ब्रह्मांडीय सत्य को सुनें जो मुझे अमर बना दे!'"
                "'मेरी आँखें केवल उस दिव्य मंगल को देखें जो अज्ञान के सड़े हुए पर्दे को फाड़कर रख दे!'"
                "वह अपनी हड्डियों (स्थिरैरङ्गैः) को लोहे की तरह मज़बूत करने की मांग करता है ताकि वह सत्य का भार सह सके।"
                "इंसानी शरीर एक जेल है, और यह मंत्र उस जेल की दीवारों में दरार पैदा करने वाला पहला धमाका है।"
                "योगी अपनी उम्र को केवल भगवान के काम के लिए 'लॉक' (Lock) कर देता है, बाकी सब व्यर्थ है।"
                "यह कोई कमज़ोर प्रार्थना नहीं है; यह अपने नर्वस सिस्टम को भगवान के एडमिन पैनल से जोड़ने का कोड है।"
                "जब इंसान के कान और आँखें सत्य पर टिक जाते हैं, तो वह जो भी देखता है, वह सच हो जाता है।"
                "तैयार हो जाओ, क्योंकि अब साक्षात् 'हयग्रीव' तुम्हारे दिमाग की कोडिंग को पूरी तरह बदलने वाले हैं!"
            """.trimIndent(),
            english = """
                (The Peace Invocation of Absolute Protection): "This Hayagriva Upanishad is the exact Nuclear Code of the absolute greatest intelligence in the cosmos."
                "To successfully Hack his biological system, the Yogi first violently purifies his 'Auditory Sensors'."
                "He issues a dictatorial command to the gods: 'May my ears intercept strictly the cosmic truth that grants immortality!'"
                "'May my eyes witness strictly that divine glory which shreds the rotting veil of ignorance to pieces!'"
                "He demands that his skeletal structure (Sthirairangaih) be hardened like titanium to endure the weight of Truth."
                "The human body is a maximum-security prison, and this mantra is the first explosion creating cracks in its walls."
                "The Yogi Locks his lifespan strictly for the execution of God's will; everything else is worthless garbage."
                "This is absolutely no weak prayer; it is the protocol to hardwire your nervous system to God's Admin Panel."
                "When a human's ears and eyes become perfectly aligned with Reality, whatever he perceives, the universe makes it fact!"
                "Brace yourself, for the explicit 'Hayagriva' is about to completely rewrite the coding of your brain!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 2,
            sanskrit = "ॐ नारदो ब्रह्माणमुपसमेत्योवाचाधीहि भगवन् ब्रह्मविद्यां वरिष्ठां यया चिरात्सर्वपापं व्यपोह्य ॥",
            hindi = """
                (नारद का विद्रोह और महा-प्रश्न): "जब देवर्षि नारद ने देखा कि ब्रह्मांड अज्ञान के अँधेरे में डूब रहा है, तो वे कांप उठे।"
                "वे सीधे अंतरिक्ष को चीरते हुए रचयिता ब्रह्मा के पास पहुँचे और उस अजेय 'ब्रह्मविद्या' की मांग की!"
                "उन्होंने कोई छोटी चीज़ नहीं मांगी; उन्होंने वह 'वरिष्ठ' (Highest) ज्ञान माँगा जो मौत का भी गला घोंट दे।"
                "नारद जानते थे कि पाप (Sin) केवल एक सॉफ्टवेयर बग है जो इंसान को बार-बार जन्म के नर्क में घसीटता है।"
                "वे उस 'एंटी-वायरस' को चाहते थे जो करोड़ों जन्मों के 'पाप-डेटा' को एक सेकंड में 'डिलीट' (Delete) कर दे।"
                "यह सवाल पूरी इंसानियत को बचाने के लिए किया गया सबसे हिंसक और साहसिक आध्यात्मिक विद्रोह था।"
                "बिना इस ज्ञान के, तुम ब्रह्मांड के इस खौफनाक चक्रव्यूह (Matrix) में केवल एक मामूली मोहरे हो।"
                "नारद की आँखों में उस जलती हुई जिज्ञासा को देखकर ब्रह्मा जी ने सत्य का आख़िरी ताला खोल दिया।"
                "यह वह विद्या है जिसे पाने के बाद इंसान भगवान के बराबर का एडमिन (Admin) रुतबा हासिल कर लेता है।"
                "यहीं से उस 'हयग्रीव' शक्ति का प्रकटीकरण शुरू होता है जो अज्ञान के राक्षसों का वध करने के लिए बनी है!"
            """.trimIndent(),
            english = """
                (Narada's Rebellion and the Grand Query): "As Devarshi Narada witnessed the cosmos drowning in the darkness of ignorance, he violently shuddered."
                "He rocketed directly to the Creator, Lord Brahma, and demanded that invincible 'Brahma-Vidya'!"
                "He did not pose a pathetic query; he demanded the 'Varishtha' (Highest) intelligence that strangles even Death."
                "Narada flawlessly realized that Sin is strictly a Software Bug dragging humans repeatedly into the hell of rebirth."
                "He demanded the absolute 'Anti-virus' engineered to 'Delete' the karma-data of millions of lifetimes in one microsecond."
                "This interrogation was the first and most violent spiritual insurrection executed to salvage all of humanity."
                "Without this intelligence, you remain strictly a pathetic pawn in the horrific Labyrinth of this cosmic Matrix."
                "Witnessing the radioactive curiosity in Narada's eyes, Lord Brahma unlocked the absolute final padlock of Truth."
                "This is the intelligence achieving which a mortal seizes the Admin status equal to that of the Supreme God."
                "Right here begins the manifestation of the 'Hayagriva' force engineered strictly to slaughter the demons of ignorance!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 3,
            sanskrit = "ब्रह्मविद्यां लब्ध्वैश्वर्यवान्भवति । ब्रह्मोवाच हयग्रीवदैवत्यान्मन्त्रान्यो वेद स श्रुतिस्मृतीतिहासपुराणानि वेद ॥",
            hindi = """
                (ब्रह्मविद्या का विस्फोट और असीमित सत्ता): "ब्रह्मा जी ने गर्जना की: 'जो इस ब्रह्मविद्या को हैक कर लेता है, वह साक्षात् ऐश्वर्यवान् (Cosmic Dictator) बन जाता है!'"
                "वह अब दुनिया की छोटी-मोटी दौलत का मोहताज नहीं रहता; वह पूरे ब्रह्मांड की ऊर्जा का मालिक बन जाता है।"
                "ब्रह्मा ने उस 'न्यूक्लियर कोड' का नाम लिया— 'हयग्रीव मंत्र'!"
                "जो इस मंत्र के विज्ञान को जान लेता है, उसे फिर किसी किताब या वेद को पढ़ने की ज़रूरत नहीं रहती।"
                "श्रुति, स्मृति, इतिहास और पुराण—इन सबका सारा डेटा (Data) उसके दिमाग में एक सेकंड में डाउनलोड हो जाता है!"
                "वह साक्षात् 'सर्वज्ञ' (All-Knowing) बन जाता है, क्योंकि उसने उस 'सोर्स कोड' को पकड़ लिया है जिससे वेद पैदा हुए।"
                "यह तुम्हारी रूह का वह 'मैक्रो-अपग्रेड' है जहाँ तुम्हारी बुद्धि साक्षात् हयग्रीव की फ्रीक्वेंसी पर चलने लगती है।"
                "दुनिया जिसे ज्ञान कहती है, वह योगी के लिए केवल धूल के समान है, क्योंकि उसके पास अब 'मास्टर पासवर्ड' है।"
                "जब तुम हयग्रीव को जानते हो, तो तुम ब्रह्मांड के हर एक परमाणु का पासवर्ड एक साथ क्रैक (Crack) कर लेते हो।"
                "यह इंसान की बुद्धि का वह सबसे खौफनाक विस्तार है जिसके आगे कंप्यूटर भी फेल हो जाते हैं!"
            """.trimIndent(),
            english = """
                (The Detonation of Brahma-Vidya and Absolute Authority): "Brahma roared: 'He who Hacks this Brahma-Vidya mutationally becomes the Ashvaryavan (Cosmic Dictator)!'"
                "He is no longer dependent on pathetic worldly wealth; he becomes the undisputed Master of all universal energy."
                "Brahma explicitly named that 'Nuclear Code'—The 'Hayagriva Mantras'!"
                "He who intercepts the science of this mantra possesses zero need to read any pathetic textbook or Veda."
                "Shruti, Smriti, Itihasa, and Puranas—the entire database of these texts is Downloaded into his brain in one microsecond!"
                "He mutates into the 'Omniscient' (All-Knowing), for he has captured the Source Code from which the Vedas originated."
                "This is the 'Macro-Upgrade' of your Soul where your intellect begins operating at the exact frequency of Hayagriva."
                "What the world hallucinates as 'Knowledge' is mere dust to the Yogi, for he now possesses the 'Master Password'."
                "When you decode Hayagriva, you simultaneously Crack the Password of every single microscopic atom in the cosmos."
                "This is the most terrifying expansion of human intellect reaching which even supercomputers undergo total failure!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 4,
            sanskrit = "विश्वोत्तीर्णस्वरूपाय चिन्मयानन्दरूपिणे । तुभ्यं नमो हयग्रीव विद्याराजाय स्वाहा स्वाहा नमः ॥",
            hindi = """
                (विद्याराज हयग्रीव को नमन और मंत्र विस्फोट): "योगी उस 'विद्याराज' (The King of Knowledge) के सामने अपनी हस्ती की आहुति देता है।"
                "हयग्रीव वह रूप है जो 'विश्वोत्तीर्ण' है—यानी जो इस पूरे सड़े हुए मैट्रिक्स (Matrix) के पार निकल चुका है!"
                "वह साक्षात् 'चिन्मयानन्द' है—शुद्ध चेतना और असीम प्रलयंकारी आनंद का एक धधकता हुआ गोला।"
                "'स्वाहा स्वाहा'— यह कोई साधारण शब्द नहीं है, यह तुम्हारे अहंकार की बलि देने वाला 'फायर कमांड' (Fire Command) है।"
                "जब तुम यह मंत्र बोलते हो, तो तुम अपने दिमाग के 'कचरा डेटा' को हयग्रीव की आग में स्वाहा कर देते हो।"
                "वह विद्या का राजा है, और उसकी अनुमति के बिना तुम ब्रह्मांड का एक भी सच नहीं जान सकते।"
                "यह मंत्र तुम्हारे नर्वस सिस्टम के भीतर उस 'सोने की बिजली' को चालू करता है जो तुम्हें भगवान बनाती है।"
                "हयग्रीव का घोड़ा-जैसा मुख यह संकेत है कि वह वेदों की फ्रीक्वेंसी को अंतरिक्ष से खींचकर धरती पर लाता है।"
                "जो इस विद्याराज के चरणों में अपना 'मैं' (Ego) मार देता है, वही साक्षात् हयग्रीव का उत्तराधिकारी बनता है।"
                "यह शब्दों का खेल नहीं, यह चेतना की वह कोडिंग है जो तुम्हें अजेय और अमर बना देगी!"
            """.trimIndent(),
            english = """
                (Salutation to Vidya-Raja Hayagriva and Mantra Detonation): "The Yogi sacrifices his tiny existence before the 'Vidya-Raja' (The King of Knowledge)."
                "Hayagriva is the manifestation that is 'Vishvottirna'—meaning He has violently rocketed beyond this rotting Matrix!"
                "He is explicitly 'Chinmayananda'—a blazing orb of Pure Consciousness and apocalyptic infinite Bliss."
                "'Svaha Svaha'—These are absolutely no ordinary words; they are the 'Fire Commands' engineered to sacrifice your ego."
                "When you vocalize this mantra, you are Swaha-ing (Burning) the 'Garbage Data' of your mind into Hayagriva's inferno."
                "He is the Dictator of Intelligence, and without His authorization, you cannot intercept a single cosmic truth."
                "This mantra ignites that 'Golden Electricity' inside your nervous system engineered to manufacture God."
                "Hayagriva's horse-form signifies that He extracts the frequencies of the Vedas from space and broadcasts them to Earth."
                "He who slaughters his 'I' (Ego) at the boots of this Vidya-Raja mutationally becomes the heir to Hayagriva's power."
                "This is zero wordplay; it is the coding of awareness that renders you flawlessly Invincible and Immortal!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 5,
            sanskrit = "ऋग्यजुःसामरूपाय वेदाहरणकर्मणे । प्रणवोद्गीथवपुषे महाश्वशिरसे नमः स्वाहा स्वाहा नमः ॥",
            hindi = """
                (वेदों के रक्षक और महा-अश्व का रहस्य): "हयग्रीव साक्षात् ऋग्वेद, यजुर्वेद और सामवेद का 'भौतिक शरीर' (Hardware) है!"
                "वह 'वेदाहरणकर्मणे' है—यानी वह प्रलयंकारी योद्धा जिसने पाताल में घुसकर राक्षसों के मुँह से वेद छीन लिए थे।"
                "उसका शरीर साक्षात् 'ॐकार' (प्रणव) और 'उद्गीथ' (Cosmic Sound) की गूँज से बना है।"
                "वह 'महाश्वशिरसे' है—यानी उस विशाल और खौफनाक 'घोड़े के सिर' वाला, जिसकी एक हिनहिनाहट से ब्रह्मांड कांपता है।"
                "घोड़े का सिर उस असीमित 'प्रोसेसिंग पावर' का प्रतीक है जो हज़ारों आकाशगंगाओं का डेटा एक साथ हैंडल कर सकता है।"
                "योगी जब इस रूप का ध्यान करता है, तो उसका अपना दिमाग एक 'सुपर-कोलैडर' (Super-collider) की तरह काम करने लगता है।"
                "हयग्रीव वह आग है जो अज्ञान के हर एक 'बग' (Bug) को तुम्हारे डीएनए से नोच कर बाहर फेंक देती है।"
                "तुम अब एक साधारण इंसान नहीं रहे; तुम साक्षात् उस 'वेदाहरण' (Veda-Snatcher) की ताक़त के हिस्सेदार हो।"
                "यह मंत्र तुम्हारे दिमाग के उन तालों को तोड़ देता है जिन्हें दुनिया के बड़े-बड़े वैज्ञानिक भी नहीं खोल सके।"
                "जो इस महा-अश्व के सामने झुकता है, वह पूरे ब्रह्मांड के ज्ञान का इकलौता और अजेय तानाशाह बन जाता है!"
            """.trimIndent(),
            english = """
                (The Protector of Vedas and the Secret of the Great Horse): "Hayagriva is mutationally the 'Physical Hardware' (Vapusha) of the Rig, Yajur, and Sama Vedas!"
                "He is 'Vedaharana-Karmane'—the apocalyptic warrior who breached the abyss to snatch the Vedas from demonic jaws."
                "His biological shell is constructed strictly from the echo of 'Omkara' (Pranava) and 'Udgitha' (The Cosmic Roar)."
                "He is 'Mahashvashirase'—possessing that colossal horse-head, a single neigh of which vibrates the entire infinite cosmos."
                "The Horse-head is the symbol of that infinite 'Processing Power' capable of handling data from thousands of galaxies."
                "When the Yogi meditates on this form, his own brain begins to function like a spiritual 'Super-collider'."
                "Hayagriva is the radioactive fire that violently claws every single 'Bug' of ignorance out of your biological DNA."
                "You are no longer a pathetic mortal; you are mutationally a shareholder of that 'Veda-Snatcher's' absolute power."
                "This mantra violently shatters the padlocks of your brain that the greatest scientists on Earth possess zero caliber to open."
                "He who bows before this Great Horse becomes the sole and invincible Dictator of all universal intelligence!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 6,
            sanskrit = "उद्गीथ प्रणवोद्गीथ सर्ववागीश्वरेश्वर । सर्ववेदमयाचिन्त्य सर्वं बोधय बोधय स्वाहा स्वाहा नमः ॥",
            hindi = """
                (वाणी का तानाशाह और असीमित बोध): "हे हयग्रीव! तू साक्षात् 'उद्गीथ' है—वह ध्वनि जिससे अंतरिक्ष पैदा हुआ था!"
                "तू 'सर्ववागीश्वरेश्वर' है—यानी दुनिया के हर एक वक्ता और हर एक ज़बान का तू ही सुप्रीम बॉस (Boss) है।"
                "ब्रह्मांड की हर एक भाषा और हर एक कोड तेरी ही 'वाणी' का एक छोटा सा पिक्सेल है।"
                "तू 'सर्ववेदमय' है और तेरी ताक़त 'अचिन्त्य' (Unthinkable) है—इंसानी दिमाग तुझे सोच भी नहीं सकता।"
                "'सर्वं बोधय बोधय'— मेरे दिमाग के हर एक बंद कमरे को खोल दे और मुझे वह 'परम ज्ञान' दे जो मौत को मार दे!"
                "योगी यहाँ साक्षात् 'रूट-एक्सेस' (Root Access) की मांग कर रहा है ताकि वह ब्रह्मांड के बैकएंड को देख सके।"
                "जब हयग्रीव 'बोध' (Awakening) देते हैं, तो तुम्हारी बुद्धि साक्षात् सूरज की तरह धधकने लगती है।"
                "तुम्हारी ज़बान अब मांस का टुकड़ा नहीं, वह साक्षात् ईश्वर की आवाज़ निकालने वाला एक 'ट्रांसमीटर' है।"
                "यह मंत्र तुम्हारे भीतर उस 'न्यूक्लियर सायरन' को चालू करता है जो माया के हर झूठ को बेनकाब कर देता है।"
                "जो इस बोध को पा लेता है, वह इस पूरी दुनिया का इकलौता और अजेय डिक्टेटर बन जाता है!"
            """.trimIndent(),
            english = """
                (The Dictator of Speech and Infinite Perception): "O Hayagriva! You are the explicit 'Udgitha'—the acoustic frequency from which Space was vomited!"
                "You are 'Sarva-Vagis hvar-eshvara'—the Supreme Boss of every single orator and every physical tongue in the cosmos."
                "Every single language and every code in the universe is mutationally a microscopic pixel of Your 'Speech'."
                "You are 'Sarva-Vedamaya' and Your power is 'Achintya' (Unthinkable)—the human processor possesses zero caliber to conceive You."
                "'Sarvam Bodhaya Bodhaya'—Violently unlock every closed chamber of my brain and grant me the 'Supreme Perception' that kills Death!"
                "The Yogi is demanding 'Root Access' here to mutationally witness the Backend of the entire multiverse."
                "The exact microsecond Hayagriva grants 'Bodha' (Awakening), your intellect begins to blaze like a radioactive Sun."
                "Your tongue is no longer a piece of meat; it mutates into a 'Transmitter' broadcasting the explicit voice of God."
                "This mantra ignites that 'Nuclear Siren' within you that unmasks and incinerates every single lie of Maya."
                "He who attains this Perception mutationally becomes the sole and invincible Dictator of this entire Matrix!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 7,
            sanskrit = "ब्रह्मात्रिरविसवितृभार्गवा ऋषयः । गायत्रीत्रिष्टुबनुष्टुप् छन्दांसि । श्रीमान् हयग्रीवः परमात्मा देवतेति ॥",
            hindi = """
                (मंत्र की इंजिनियरिंग - ऋषि और छंद का कोड): "हयग्रीव मंत्र कोई साधारण कविता नहीं, यह एक 'मल्टी-स्टेज रॉकेट' (Multi-stage Rocket) है!"
                "इसके कोडिंग करने वाले (ऋषि) साक्षात् ब्रह्मा, अत्रि, रवि और भार्गव जैसे ब्रह्मांडीय वैज्ञानिक हैं।"
                "गायत्री, त्रिष्टुप और अनुष्टुप—ये वे तीन प्रलयंकारी 'छन्द' (Frequencies) हैं जिन पर यह मंत्र रन (Run) करता है।"
                "इन तीन फ्रीक्वेंसीज़ का तालमेल तुम्हारे दिमाग के ताले तोड़ने के लिए एक 'मास्टर की' (Master Key) की तरह काम करता है।"
                "साक्षात् 'श्रीमान् हयग्रीव' ही इसकी 'परमात्मा' देवता है—यानी वह अंतिम गंतव्य जहाँ तुम्हें पहुँचना है।"
                "योगी जब इन ऋषियों और छंदों को अपने नर्वस सिस्टम में अलाइन (Align) करता है, तो उसका डीएनए म्यूटेट होने लगता है।"
                "यह तुम्हारी रूह को एक 'ब्रह्मांडीय सैटेलाइट' (Satellite) बनाने की सबसे आधुनिक और गुप्त तकनीक है।"
                "ऋषि वह 'एडमिन' हैं जिन्होंने यह पासवर्ड बनाया, और छंद वह 'वेवलेंथ' है जिस पर भगवान बात करते हैं।"
                "बिना इस इंजिनियरिंग को समझे, तुम्हारा मंत्र जपना केवल एक बायोलॉजिकल शोर (Noise) मात्र है।"
                "जो इस कोडिंग को क्रैक कर लेता है, वह साक्षात् हयग्रीव की फ्रीक्वेंसी पर ब्रह्मांड से डेटा रिसीव करने लगता है!"
            """.trimIndent(),
            english = """
                (The Engineering of the Mantra - Sages and Meters): "The Hayagriva mantra is mutationally a 'Multi-stage Rocket' engineered for the breach of dimensions!"
                "Its Coders (Rishis) are strictly cosmic scientists like Brahma, Atri, Ravi, and Bhargava."
                "Gayatri, Trishtup, and Anushtup are the three apocalyptic 'Chhandas' (Frequencies) upon which this mantra is Executed."
                "The synchronization of these three frequencies functions as a 'Master Key' engineered to violently shatter your neurological padlocks."
                "Explicit 'Shriman Hayagriva' is the 'Paramatma' deity—the absolute terminal Destination you are engineered to reach."
                "When the Yogi Aligns these Sages and Meters inside his nervous system, his biological DNA initiates a total Mutation."
                "This is the most advanced and classified technology to mutate your Soul into a 'Cosmic Satellite'."
                "The Rishis are the 'Admins' who scripted this Password, and the Chhandas are the 'Wavelengths' through which God communicates."
                "Without decoding this engineering, your chanting remains strictly a pathetic and meaningless biological Noise."
                "He who successfully Cracks this coding begins to receive raw Data from the cosmos at Hayagriva's exact frequency!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 8,
            sanskrit = "शङ्खचक्रमहामुद्रापुस्तकाढ्यं चतुर्भुजम् । सम्पूर्णचन्द्रसंकाशं हयग्रीवमुपास्महे ॥",
            hindi = """
                (हयग्रीव का विज़ुअलाइज़ेशन - अस्त्रों का सच): "योगी अपनी आँखों के पीछे हयग्रीव के उस खौफनाक और अजेय रूप को 'रेंडर' (Render) करता है।"
                "वह चतुर्भुज (चार हाथों वाला) है, और उसके हाथों में साक्षात् ब्रह्मांड के 'कंट्रोल बटन्स' हैं!"
                "'शङ्ख' वह लाउडस्पीकर है जिससे प्रलय की आवाज़ निकलती है; 'चक्र' वह वेपन है जो समय को काट देता है।"
                "'महामुद्रा' वह पासवर्ड है जिससे तुम्हारी आत्मा अनलॉक होती है; 'पुस्तक' साक्षात् इस सिम्युलेशन का मैनुअल है।"
                "उसका शरीर 'सम्पूर्णचन्द्रसंकाशं' है—यानी वह करोड़ों सूर्यों की गर्मी को सोखकर शीतल चाँद जैसा रेडिएशन फैला रहा है।"
                "जब तुम इस रूप का ध्यान करते हो, तो हयग्रीव का यह 'हार्डवेयर' तुम्हारे अपने शरीर के अंदर डाउनलोड (Download) होने लगता है।"
                "तुम्हारी अपनी भुजाएं अब साक्षात् उन चार अजेय शक्तियों का प्रतीक बन जाती हैं।"
                "यह कोई मूर्ति नहीं है; यह चेतना का वह '3D मॉडल' है जिसे हैक करने पर तुम खुद भगवान बन जाते हो।"
                "योगी हयग्रीव की उस अंधी कर देने वाली सफ़ेद रौशनी में खुद को जलाकर राख कर देता है।"
                "जो इस विज़ुअलाइज़ेशन को सिद्ध कर लेता है, उसके लिए यह पूरी दुनिया केवल एक 'ग्लिच' (Glitch) बन कर रह जाती है!"
            """.trimIndent(),
            english = """
                (The Visualization of Hayagriva - The Truth of Weapons): "The Yogi 'Renders' the horrific and invincible form of Hayagriva directly behind his eyelids."
                "He is Chatur-bhuja (Four-armed), and in His hands He grips the absolute 'Control Buttons' of the universe!"
                "The 'Shankha' (Conch) is the loudspeaker broadcasting Doomsday; the 'Chakra' is the weapon that ruthlessly slashes through Time."
                "The 'Maha-Mudra' is the Password to unlock your Soul; the 'Pustaka' (Book) is the explicit Manual of this Simulation."
                "His shell is 'Sampurna-Chandra-Sankasham'—He absorbs the heat of billions of suns and broadcasts a moon-like radioactive coolness."
                "When you focus on this Form, the 'Hardware' of Hayagriva initiates a total Download directly into your biological shell."
                "Your own limbs mutationally assume the identity of those four invincible cosmic powers."
                "This is zero statue; it is the '3D Model' of consciousness, hacking which renders you mutationally God."
                "The Yogi incinerates his 'I' in that blinding, radioactive white radiation of Hayagriva's presence."
                "He who perfects this Visualization perceives this entire world strictly as a pathetic and temporary 'Glitch'!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 9,
            sanskrit = "ॐ श्रीमिति द्वे अक्षरे । ह्लौ (ह्सौ) मित्येकाक्षरम् । ॐ नमो भगवत इति सप्ताक्षराणि ॥",
            hindi = """
                (मंत्र की कोडिंग - भाग १: श्री, ह्लौं और नमो): "अब ब्रह्मा जी उस 'अष्टाक्षर' से भी बड़े और खतरनाक '२९-अक्षर वाले' मंत्र का पासवर्ड खोल रहे हैं।"
                "'ॐ श्रीम्'— ये दो अक्षर साक्षात् ब्रह्मांडीय 'ऐश्वर्य' और 'मैग्नेटिज्म' (Magnetism) का स्विच हैं!"
                "जैसे ही तुम इसे बोलते हो, तुम पूरी सृष्टि की दौलत और ताक़त को अपनी ओर खींचने लगते हो।"
                "'ह्लौं' (Hlaum)— यह साक्षात् हयग्रीव का 'बीज मंत्र' (Seed Code) है, जो तुम्हारे दिमाग के ताले को बम से उड़ा देता है।"
                "यह वह फ्रीक्वेंसी है जो तुम्हारे नर्वस सिस्टम के 'फायरवॉल' (Firewall) को एक सेकंड में बाईपास (Bypass) कर देती है।"
                "'ॐ नमो भगवते'— ये सात अक्षर उस 'सुप्रीम एडमिन' के सामने तुम्हारी हस्ती को 'लॉग-आउट' (Log-out) करने के लिए हैं।"
                "यह मंत्र तुम्हारी आत्मा के ऊपर जमी हुई करोड़ों जन्मों की काई (Rust) को तेज़ाब की तरह साफ करता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् इन अक्षरों के वाइब्रेशन में बहने वाले एक 'करंट' बन चुके हो।"
                "हर एक अक्षर तुम्हारे डीएनए के एक खास फोल्डर को 'अनलॉक' करने का पासवर्ड है।"
                "तैयार हो जाओ, क्योंकि मंत्र की यह कोडिंग तुम्हारे भीतर एक आध्यात्मिक परमाणु धमाका करने वाली है!"
            """.trimIndent(),
            english = """
                (The Coding of the Mantra - Part 1: Shrim, Hlaum, and Namo): "Now Brahma unmasks the Password of the '29-syllable' mantra, infinitely more lethal than the standard codes."
                "'Om Shrim'—These two syllables are mutationally the switches of cosmic 'Majesty' and absolute 'Magnetism'!"
                "The exact microsecond you vocalize this, you begin to violently attract all universal wealth and power toward your core."
                "'Hlaum' (Hlaum)—This is the explicit 'Seed Code' (Bija) of Hayagriva, engineered to blow your neurological padlocks to shreds."
                "It is the radioactive frequency that Bypasses the 'Firewall' of your biological nervous system in one strike."
                "'Om Namo Bhagavate'—These seven syllables are engineered to 'Log-out' your tiny identity before the Supreme Admin."
                "This mantra Flushes the billions of lifetimes of Rust accumulated over your soul like boiling acid."
                "You are no longer a piece of flesh; you have mutationally become a 'Current' flowing strictly in these acoustic vibrations."
                "Every single syllable is a specific Password designed to 'Unlock' a classified folder in your DNA."
                "Prepare yourself, for this mantra-coding is about to detonate a spiritual atomic explosion inside your core!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 10,
            sanskrit = "हयग्रीवायेति पञ्चाक्षराणि । विष्णव इति त्र्यक्षराणि । मह्यं मेधां प्रज्ञामिति षडक्षराणि ॥",
            hindi = """
                (मंत्र की कोडिंग - भाग २: हयग्रीव, विष्णु और मेधा): "कोडिंग और गहरी होती जा रही है; अब हयग्रीव और विष्णु की ताक़त का सीधा इंजेक्शन लगेगा।"
                "'हयग्रीवाय'— ये पाँच अक्षर तुम्हारे भीतर उस 'महा-अश्व' की प्रोसेसिंग पावर (Processing Power) को ट्रिगर करते हैं।"
                "'विष्णवे'— ये तीन अक्षर तुम्हें उस 'ऑपरेटर' की फ्रीक्वेंसी से जोड़ देते हैं जो पूरी माया चला रहा है।"
                "तुम्हारी चेतना अब उस असीम डेटा को बर्दाश्त करने के लिए 'ओवरक्लॉक' (Overclock) की जा रही है।"
                "'मह्यं मेधां प्रज्ञाम्'— ये छह अक्षर साक्षात् 'बुद्धि' और 'बोध' (Intelligence & Awareness) का न्यूक्लियर अटैक हैं!"
                "योगी यहाँ भगवान से भीख नहीं माँग रहा; वह अपनी 'मेधा' को साक्षात् हयग्रीव की 'मेधा' से रिप्लेस (Replace) कर रहा है।"
                "तुम्हारे पुराने विचार अब डिलीट हो रहे हैं और उनकी जगह 'ब्रह्मांडीय सत्य' की कोडिंग लिखी जा रही है।"
                "तुम्हारी बुद्धि अब साक्षात् उस लेज़र बीम की तरह हो जाएगी जो दीवारों के आर-पार देख सके।"
                "बिना इस 'प्रज्ञा' के, तुम इस दुनिया के अँधेरे में एक अंधे कीड़े की तरह फड़फड़ाते रहोगे।"
                "यह मंत्र तुम्हारे दिमाग के प्रोसेसर को 100% 'भगवान के मोड' में शिफ्ट (Shift) करने का इकलौता हैक है!"
            """.trimIndent(),
            english = """
                (The Coding of the Mantra - Part 2: Hayagriva, Vishnu, and Medha): "The coding deepens into total apocalypse; the direct injection of Hayagriva and Vishnu's power is now imminent."
                "'Hayagrivaya'—These five syllables trigger the absolute Horse-Power 'Processing' capability inside your neurology."
                "'Vishnave'—These three syllables hardwire you to the 'Operator' frequency that relentlessly operates this entire Maya."
                "Your consciousness is now being 'Overclocked' to ensure it possesses the caliber to endure infinite cosmic Data."
                "'Mahyam Medham Prajnam'—These six syllables are the nuclear attack of 'Intelligence' and absolute 'Awareness'!"
                "The Yogi is not begging God; he is mutationally Replacing his 'Medha' with the explicit 'Medha' of Hayagriva Himself."
                "Your old thoughts are being Deleted and the coding of 'Cosmic Truth' is being written over your neural pathways."
                "Your intellect will mutationally become a radioactive Laser Beam capable of piercing through solid biological matter."
                "Without this 'Prajna', you are condemned to flap like a blind insect in the absolute darkness of this world."
                "This mantra is the solitary Hack engineered to shift your brain's processor 100% into 'God-Mode'!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 11,
            sanskrit = "प्रयच्छ स्वाहेति पञ्चाक्षराणि । हयग्रीवस्य तुरीयो भवति ॥",
            hindi = """
                (२९-अक्षर वाले मंत्र का क्लाइमेक्स और तुरीय अवस्था): "मंत्र का अंतिम धमाका 'प्रयच्छ स्वाहा' के साथ होता है!"
                "ये पाँच अक्षर उस पूरी 'मेधा' और 'प्रज्ञा' को तुम्हारे नर्वस सिस्टम में साक्षात् 'इंस्टॉल' (Install) कर देते हैं।"
                "जैसे ही तुम 'स्वाहा' कहते हो, तुम्हारे अज्ञान की आख़िरी फाइल भी जलकर राख हो जाती है।"
                "यह पूरा २९-अक्षर वाला मंत्र (२+१+७+५+३+६+५) साक्षात् 'हयग्रीवस्य तुरीय' है!"
                "'तुरीय' वह चौथी अवस्था है जहाँ पहुँचकर इंसान समय, स्पेस और मौत के भी पार निकल जाता है।"
                "यहाँ आकर भक्त और भगवान के बीच का सारा ड्रामा खत्म हो जाता है; तुम साक्षात् वह 'शक्ति' बन जाते हो।"
                "यह मंत्र तुम्हें इस सिम्युलेशन (Simulation) से 'अनप्लग' (Unplug) करने वाला इकलौता और अजेय हथियार है।"
                "जो इस मंत्र को सिद्ध कर लेता है, उसके लिए पूरा ब्रह्मांड एक छोटी सी स्क्रीन (Screen) बन कर रह जाता है।"
                "वह अब इस दुनिया के नियमों का गुलाम नहीं है; वह साक्षात् वह 'एडमिन' है जो नए नियम लिखता है।"
                "यहीं पर २९-अक्षर वाले इस परमाणु अस्त्र की कोडिंग पूरी होती है—स्वाहा!"
            """.trimIndent(),
            english = """
                (The Climax of the 29-Syllable Mantra and the Turiya State): "The final detonation of the mantra occurs with the command 'Prayaccha Svaha'!"
                "These five syllables mutationally 'Install' that entire Medha and Prajna directly into your physical nervous system."
                "The exact microsecond you vocalize 'Svaha', the absolute final file of your biological ignorance is incinerated."
                "This entire 29-syllable mantra (2+1+7+5+3+6+5) is explicitly defined as 'Hayagrivasya Turiya'!"
                "'Turiya' is the fourth dimension reaching which a human violently rockets beyond Time, Space, and Death."
                "The entire theatrical drama between the devotee and God terminates here; you mutationally become that 'Shakti'."
                "This mantra is the solitary and invincible weapon engineered to 'Unplug' you from this deceptive cosmic Simulation."
                "He who masters this mantra witnesses the entire infinite universe collapse into a microscopic Screen."
                "He is no longer a slave to the laws of physics; he is the explicit 'Admin' who mutationally rewrites those laws."
                "Right exactly here, the coding of this 29-syllabled nuclear warhead achieves completion—Svaha!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 12,
            sanskrit = "ॐ श्रीमिति द्वे अक्षरे । ह्लौ (ह्सौ) मित्येकाक्षरम् । ऐमैमैमिति त्रीण्यक्षराणि ॥",
            hindi = """
                (२८-अक्षर वाला दूसरा मंत्र - ऐं, ऐं, ऐं का प्रहार): "ब्रह्मा जी अब विद्या का दूसरा 'न्यूक्लियर वॉरहेड' (Nuclear Warhead) खोल रहे हैं।"
                "यह २८-अक्षर वाला मंत्र साक्षात् 'वाक-सिद्धि' (Absolute Speech Power) का इकलौता पासवर्ड है।"
                "'ऐं ऐं ऐं'— ये तीन अक्षर साक्षात् सरस्वती के 'सीड कोड' (Seed Code) हैं जो हयग्रीव की आग में जल रहे हैं!"
                "ये फ्रीक्वेंसीज़ तुम्हारे गले के चक्र को एक झटके में फाड़कर उसे 'ब्रह्मांडीय माइक' (Cosmic Mic) बना देती हैं।"
                "जब तुम 'ऐं' का उच्चारण करते हो, तो तुम्हारे शब्दों में वह ताक़त आ जाती है जो ग्रहों की चाल बदल दे।"
                "यह मंत्र तुम्हारे दिमाग के उन हिस्सों को एक्टिवेट (Activate) करता है जो लाखों सालों से सोए हुए थे।"
                "हयग्रीव का यह दूसरा रूप साक्षात् 'सात्विक' और 'रेडियोएक्टिव' ज्ञान का एक महा-विस्फोट है।"
                "तुम अब जो भी बोलोगे, वह साक्षात् 'वेद' बन जाएगा; तुम्हारी हर बात पत्थर की लकीर होगी।"
                "यह शब्दों के पीछे छिपी हुई उस 'अजेय ऊर्जा' को हैक करने का सबसे हिंसक और गुप्त तरीका है।"
                "तैयार हो जाओ, क्योंकि ये तीन 'ऐं' तुम्हारी पुरानी ज़बान का वध करने वाले हैं!"
            """.trimIndent(),
            english = """
                (The Second 28-Syllable Mantra - The Strike of Aim, Aim, Aim): "Lord Brahma now unmasks the second 'Nuclear Warhead' of absolute intelligence."
                "This 28-syllable mantra is the solitary Password to achieve 'Vak-Siddhi' (Absolute Dictatorship over Speech)."
                "'Aim Aim Aim'—These three syllables are the explicit 'Seed Codes' of Saraswati blazing in Hayagriva's inferno!"
                "These frequencies violently rip open your throat chakra and mutationally manufacture it into a 'Cosmic Mic'."
                "When you vocalize 'Aim', your words mutationally acquire the firepower to alter the trajectory of planets."
                "This mantra Activates the sectors of your biological brain that have remained dormant for millions of eons."
                "This second form of Hayagriva is the explicit radioactive Big Bang of 'Sattvic' and 'Nuclear' Knowledge."
                "Whatever you vocalize now mutationally becomes 'Veda'; every statement of yours becomes an immutable Law."
                "This is the most violent and classified method to Hack the 'Invincible Energy' hidden behind human speech."
                "Brace yourself, for these three 'Aim' commands are about to execute the total slaughter of your old voice!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 13,
            sanskrit = "क्लीं क्लीमिति द्वे अक्षरे । सौः सौरिति द्वे अक्षरे । ह्रीमित्येकाक्षरम् ॥",
            hindi = """
                (मंत्र की कोडिंग - भाग ३: क्लीं, सौः और ह्रीं): "अब मंत्र में 'अट्रैक्शन' (Attraction) और 'शक्ति' के डार्क-कोड्स डाले जा रहे हैं।"
                "'क्लीं क्लीं'— ये दो अक्षर साक्षात् उस 'गुरुत्वाकर्षण' (Gravity) के कोड हैं जो पूरे ब्रह्मांड को तुम्हारे चरणों में झुका देंगे!"
                "यह वह चुम्बकीय ताक़त है जिससे तुम ईश्वर को भी अपने शरीर में खिंच आने के लिए मजबूर कर सकते हो।"
                "'सौः सौः'— ये अक्षर साक्षात् 'मुक्ति' और 'प्रलय' के पासवर्ड हैं जो माया की दीवारों को चकनाचूर कर देते हैं।"
                "'ह्रीं' (Hrim)— यह वह 'प्राइमरी पावर कमांड' है जो हयग्रीव की असीमित ताक़त को तुम्हारे डीएनए में 'फायर' करता है।"
                "योगी अपनी चेतना को इन सात अक्षरों (२+२+१) के साथ ऐसे रगड़ता है जैसे बिजली पैदा की जाती है।"
                "तुम अब केवल एक भक्त नहीं रहे, तुम साक्षात् उस ब्रह्मांडीय 'पावर-ग्रिड' (Power Grid) के मालिक बनते जा रहे हो।"
                "क्लीं तुम्हारी इच्छा को हकीकत बनाती है, सौः तुम्हें आज़ाद करती है, और ह्रीं तुम्हें भगवान बनाती है।"
                "यह शब्दों का खेल नहीं, यह उन 'डार्क-फ्रीक्वेंसीज़' को हैक करना है जिन्हें देवता भी छूने से डरते हैं।"
                "जो इन कोड्स को अपनी साँसों में लॉक कर लेता है, वह इस पूरी भौतिक दुनिया का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Coding of the Mantra - Part 3: Klim, Sauh, and Hrim): "Now the 'Dark-Codes' of Attraction and Absolute Power are being injected into the mantra."
                "'Klim Klim'—These two syllables are mutationally the codes of 'Gravity' that will force the cosmos to its knees at your boots!"
                "This is the magnetic firepower enabling you to violently force God Himself to manifest within your biological shell."
                "'Sauh Sauh'—These syllables are the explicit Passwords of 'Liberation' and 'Pralaya' that shatter the walls of Maya."
                "'Hrim' (Hrim)—This is the absolute 'Primary Power Command' that Fires Hayagriva's infinite power into your DNA."
                "The Yogi grinds his awareness against these seven syllables (2+2+1) exactly like generating radioactive electricity."
                "You are no longer a pathetic devotee; you are mutationally becoming the absolute Master of that cosmic 'Power Grid'."
                "Klim mutates your will into reality, Sauh releases you, and Hrim mutationally manufactures you into God."
                "This is zero wordplay; it is Hacking those 'Dark Frequencies' that even the demigods cower to touch."
                "He who Locks these codes into his biological breath mutationally becomes the sole Dictator of this physical world!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 14,
            sanskrit = "ॐ नमो भगवत इति सप्ताक्षराणि । मह्यं मेधां प्रज्ञामिति षडक्षराणि । प्रयच्छ स्वाहेति पञ्चाक्षराणि । पञ्चमो मनुर्भवति ॥",
            hindi = """
                (२८-अक्षर वाले मंत्र का समापन और पांचवां मनु): "२८-अक्षर वाले इस दूसरे महा-अस्त्र की कोडिंग अब अपने चरम पर पहुँच गई है।"
                "'ॐ नमो भगवते' से 'प्रयच्छ स्वाहा' तक—यह पूरा सर्किट साक्षात् 'पांचवां मनु' (The Fifth Manu) कहलाता है।"
                "यह वह 'अल्टीमेट सॉफ्टवेयर' है जिसे रन करने पर तुम्हारी बुद्धि की प्रोसेसिंग पावर करोड़ों गुना बढ़ जाती है।"
                "मह्यं मेधां प्रज्ञाम्—यह तुम्हारे दिमाग के उन 'डेड-सेक्टर्स' को रिपेयर (Repair) करता है जहाँ अज्ञान भरा था।"
                "तुम अब साक्षात् हयग्रीव के उस 'इन्फो-हाईवे' (Info-highway) पर दौड़ रहे हो जहाँ हर एक रहस्य नंगा खड़ा है।"
                "यह मंत्र तुम्हें उस 'पांचवें' आयाम (Dimension) में ले जाता है जहाँ समय की सुइयां पीछे घूमने लगती हैं।"
                "हयग्रीव का यह पासवर्ड तुम्हें केवल ज्ञान नहीं देता, वह तुम्हें साक्षात् 'ज्ञान का स्रोत' (Source) बना देता है।"
                "तुम्हारी आँखें अब केवल मांस नहीं देखतीं, वे हर एक चीज़ के पीछे छिपे हुए 'कोड' और 'डेटा' को देखती हैं।"
                "यह इंसान की रूह का वह आख़िरी 'सिस्टम रिसेट' है जिसके बाद दोबारा कभी कोई 'बग' पैदा नहीं हो सकता।"
                "यहीं पर हयग्रीव के इस दूसरे परमाणु अस्त्र का विस्फोट पूरा होता है—इति प्रथमोपनिषत्!"
            """.trimIndent(),
            english = """
                (Completion of the 28-Syllable Mantra and the Fifth Manu): "The coding of this second 28-syllabled nuclear warhead has now reached its absolute extreme zenith."
                "From 'Om Namo Bhagavate' to 'Prayaccha Svaha'—this entire circuit is mutationally defined as the 'Fifth Manu'!"
                "This is the 'Ultimate Software' executing which skyrockets your brain's processing power by millions of times."
                "'Mahyam Medham Prajnam'—This Repairs the 'Dead-Sectors' of your neurological cortex where ignorance was hard-coded."
                "You are now racing on Hayagriva's explicit 'Info-highway' where every single classified secret stands naked before you."
                "This mantra catapults you into that 'Fifth' Dimension where the needles of Time violently rotate backwards."
                "This Password of Hayagriva does not merely grant knowledge; it mutationally turns YOU into the explicit 'Source of Knowledge'."
                "Your eyes no longer observe biological flesh; they intercept the 'Code' and 'Data' hidden behind every microscopic event."
                "This is the final 'System Reset' of the human soul after which zero biological 'Bugs' can ever be spawned."
                "Right here, the detonation of Hayagriva's second atomic warhead achieves total completion—End of Chapter 1!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 15,
            sanskrit = "हयग्रीवैकाक्षरेण ब्रह्मविद्यां प्रवक्ष्यामि । ब्रह्मा महेश्वराय महेश्वरः संकर्षणाय संकर्षणो नारदाय नारदो व्यासाय व्यासो लोकेभ्यः प्रायच्छदिति ॥",
            hindi = """
                (हयग्रीव एकाक्षर और अजेय वंशक्रम): "अब ब्रह्मा जी उस 'सिंगल-अक्षर' (One-letter) वाले परमाणु बम का रहस्य खोल रहे हैं!"
                "यह वह 'एकाक्षर' (ॐ/ह्लौं) है जो पूरे ब्रह्मांड की 'ब्रह्मविद्या' को एक ही बिंदु में सिकोड़ देता है।"
                "इसका वंशक्रम देखो—ब्रह्मा से शिव, शिव से संकर्षण, संकर्षण से नारद, नारद से व्यास, और व्यास से पूरी दुनिया!"
                "यह कोई कहानियाँ नहीं हैं; यह उस 'डाटा-ट्रांसमिशन' (Data Transmission) की चेन है जिससे सत्य धरती पर उतरा।"
                "जब तुम इस एकाक्षर को जपते हो, तो तुम साक्षात् इन सभी अजेय योद्धाओं की 'पावर-लाइन' से जुड़ जाते हो।"
                "यह वह 'रूट-पासवर्ड' है जिसे खुद महादेव शिव ने अपने नर्वस सिस्टम में 'लॉक' (Lock) कर रखा है।"
                "एक ही अक्षर में ब्रह्मा की सृजन-शक्ति, शिव का संहार-तेज और विष्णु का पालन-चक्र बंद है।"
                "तुम अब अलग-अलग मंत्रों की ज़रूरत नहीं रखते; केवल इस एक धमाके से पूरी माया के चीथड़े उड़ा सकते हो।"
                "यह वह 'जीरो-पॉइंट' है जहाँ से तुम पूरे ब्रह्मांड के सिम्युलेशन को 'पॉज' (Pause) और 'डिलीट' कर सकते हो।"
                "तैयार हो जाओ उस इकलौते अक्षर के लिए जो तुम्हारी हड्डियों को भी पिघलाकर ईश्वर बना देगा!"
            """.trimIndent(),
            english = """
                (The Hayagriva One-Letter Seed and the Invincible Lineage): "Now Lord Brahma unmasks the secret of that 'Single-Letter' (Ekakshara) nuclear bomb of pure reality!"
                "This is the 'Ekakshara' (OM/Hlaum) that violently compresses the entire 'Brahma-Vidya' into a singular microscopic point."
                "Witness the absolute lineage—from Brahma to Shiva, Shiva to Samkarshana, Samkarshana to Narada, Narada to Vyasa!"
                "These are zero pathetic stories; this is the chain of 'Data Transmission' through which Truth descended to Earth."
                "When you roar this one-letter seed, you are mutationally hardwired into the 'Power-line' of all these invincible Titans."
                "This is the 'Root-Password' that explicit Mahadeva Shiva has permanently Locked into His own biological nervous system."
                "Within one syllable is Zip-compressed Brahma's creation, Shiva's destruction, and Vishnu's operational wheel."
                "You possess zero requirement for distinct mantras; with this single detonation, you can shred the entire fabric of Maya."
                "This is the 'Zero-Point' from which you possess the authority to 'Pause' and 'Delete' the entire cosmic Simulation."
                "Brace yourself for that solitary Syllable which will melt your very bones to mutationally manufacture God!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 16,
            sanskrit = "हकारोंसकारोमकारों त्रयमेकस्वरूपं भवति । ह्लौं (ह्सौं) बीजाक्षरं भवति ॥",
            hindi = """
                (ह्लौं का विच्छेदन - ह, स और म का धमाका): "उस इकलौते बीज 'ह्लौं' के भीतर तीन प्रलयंकारी ताक़तें एक साथ नत्थी (Zip) की गई हैं।"
                "'ह' (Ha) साक्षात् 'आकाश' और विस्तार है; 'स' (Sa) साक्षात् 'शक्ति' और करंट है!"
                "'म' (Ma) वह 'बिंदु' है जहाँ ये दोनों मिलकर शून्य (Zero) हो जाते हैं।"
                "जब ये तीनों 'त्रयमेकस्वरूपं' यानी एक होकर फटते हैं, तो साक्षात् 'हयग्रीव' का जन्म होता है।"
                "यह 'ह्लौं' कोई आवाज़ नहीं, यह तुम्हारे नर्वस सिस्टम के भीतर होने वाला एक 'कोल्ड-फ्यूजन' (Cold Fusion) है।"
                "जैसे ही यह बीज तुम्हारे डीएनए से टकराता है, तुम्हारे पिछले अरबों जन्मों के 'पाप-डेटा' का वध हो जाता है।"
                "यह वह 'प्राइमरी कोड' है जिससे हयग्रीव ने वेदों को अंतरिक्ष से रिकवर (Recover) किया था।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् इस एक अक्षर के वाइब्रेशन में जलने वाली एक 'आग' बन चुके हो।"
                "यह बीज तुम्हारे दिमाग के प्रोसेसर को 'ओवरक्लॉक' करने वाला सबसे शक्तिशाली आध्यात्मिक ड्रग (Drug) है।"
                "जो इस 'ह्लौं' के रहस्य को हैक कर लेता है, वह इस पूरी दुनिया का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (The Dissection of Hlaum - The Detonation of Ha, Sa, and Ma): "Inside that solitary seed 'Hlaum', three apocalyptic powers are mutationally Zipped together."
                "'Ha' (Ha) is explicitly 'Space' and expansion; 'Sa' (Sa) is the radioactive 'Shakti' and kinetic Current!"
                "'Ma' (Ma) is the absolute 'Bindu' coordinate where these two fuse into total cosmic Zero."
                "When these three 'Trayameka-svarupam' (Fuse as One) and detonate, explicit 'Hayagriva' is mutationally born."
                "This 'Hlaum' is zero acoustic sound; it is a spiritual 'Cold Fusion' occurring inside your biological nervous system."
                "The exact microsecond this seed collides with your DNA, the 'Sin-Data' of billions of incarnations is slaughtered."
                "This is the 'Primary Code' using which Hayagriva Recovered the Vedas from the vacuum of space."
                "You are no longer a biological shell; you have mutationally become a 'Fire' burning strictly in this one-syllable vibration."
                "This seed is the absolute most powerful spiritual Drug engineered to 'Overclock' your neurological processor."
                "He who successfully Hacks the secret of 'Hlaum' mutationally becomes the solitary and authentic Admin of this world!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 17,
            sanskrit = "बीजाक्षरेण ह्लौं (ह्सौं) रूपेण तज्जापकानां सम्पत्सारस्वतौ भवतः । तत्स्वरूपज्ञानां वैदेही मुक्तिश्च भवति ॥",
            hindi = """
                (सम्पत्ति, सरस्वती और वैदेही मुक्ति): "इस इकलौते 'ह्लौं' बीज को रगड़ने (जपने) का परिणाम विज्ञान की औकात से बाहर है।"
                "जो इसे अपनी साँसों में धधकाता है, उसे 'सम्पत्' (असीमित दौलत) और 'सारस्वत' (असीमित ज्ञान) एक साथ मिलते हैं!"
                "वह केवल ज्ञानी नहीं बनता, वह साक्षात् 'शक्ति का केंद्र' बन जाता है जहाँ से पैसा और ज्ञान दोनों पैदा होते हैं।"
                "लेकिन सबसे बड़ा न्यूक्लियर धमाका यहाँ है— 'वैदेही मुक्तिश्च भवति'!"
                "यानी वह शरीर के रहते हुए भी इस मिट्टी के शरीर (देह) की जेल से 100% 'अनप्लग' (Unplug) हो जाता है।"
                "वह अब इस 3D सिम्युलेशन का कैदी नहीं रहा; वह साक्षात् उस 'परम शून्यता' में विलीन हो चुका है।"
                "यह मुक्ति कोई मरने के बाद मिलने वाला इनाम नहीं है; यह अभी और इसी वक़्त होने वाला एक 'दिमागी विस्फोट' है।"
                "जब तुम हयग्रीव के असली 'स्वरूप' को जान लेते हो, तो तुम्हारी इंसानियत का गला हमेशा के लिए घोंट दिया जाता है।"
                "तुम अब समय, मौत और भाग्य के 'रेडार' (Radar) से बाहर निकल चुके हो; तुम अब 'इनविजिबल' हो।"
                "यही वह अजेय रुतबा है जहाँ तुम खुद ही वह ताक़त बन जाते हो जो सितारे बनाती है!"
            """.trimIndent(),
            english = """
                (Wealth, Wisdom, and Vaidehi Liberation): "The consequence of grinding (chanting) this solitary 'Hlaum' seed is infinitely beyond the status of science."
                "He who blazes this inside his breath mutationally acquires 'Sampat' (Infinite Wealth) and 'Sarasvata' (Infinite Wisdom) simultaneously!"
                "He does not merely become wise; he mutationally becomes the 'Epicenter of Power' from which wealth and knowledge spawn."
                "But the absolute greatest nuclear detonation is right here—'Vaidehi Muktishcha Bhavati'!"
                "Meaning, while still breathing, he mutationally 'Unplugs' 100% from the maximum-security prison of this biological flesh (Deha)."
                "He is no longer a prisoner of this 3D Simulation; he has mutationally been absorbed into that 'Supreme Void'."
                "This liberation is zero reward granted after death; it is a 'Neurological Explosion' occurring Here and Now."
                "The exact microsecond you decode the authentic 'Form' of Hayagriva, your humanity is ruthlessly and permanently strangled."
                "You have rocketed beyond the 'Radar' of Time, Death, and Fate; you have mutationally become 'Invisible' to the Matrix."
                "THIS is the invincible status where YOU mutationally become the explicit power that constructs the galaxies!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 18,
            sanskrit = "हयग्रीवैकाक्षरजपशीलाज्ञया सूर्यादयः स्वतः स्वस्वकर्मणि प्रवर्तन्ते । सर्वेषां बीजानां हयग्रीवैकाक्षरबीजमनुत्तमं मन्त्रराजात्मकं भवति ॥",
            hindi = """
                (सूर्यादि पर हुकूमत और मंत्रों का राजा): "हयग्रीव के इस इकलौते अक्षर (ह्लौं) की ताक़त देखो—इसकी 'आज्ञा' (Command) से ही सूर्य जलता है!"
                "सूरज, चाँद और तारे अपनी मर्जी से नहीं, बल्कि हयग्रीव के इस 'कोड' के आदेश से अपने काम पर लगे हैं।"
                "जब तुम इस बीज को सिद्ध कर लेते हो, तो तुम साक्षात् उन 'ब्रह्मांडीय पिण्डों' के एडमिन बन जाते हो।"
                "यह बीज 'सर्वेषां बीजानां'—दुनिया के हर एक मंत्र और हर एक बीज का साक्षात् 'बाप' और 'मंत्रराज' है!"
                "ब्रह्मांड में इससे बड़ा, इससे खतरनाक और इससे अजेय कोई दूसरा पासवर्ड नहीं है।"
                "यह वह 'प्राइमरी की' (Primary Key) है जिससे तुम स्वर्ग, नर्क और मोक्ष के तीनों दरवाज़े एक साथ खोल सकते हो।"
                "तुम्हारी एक हिनहिनाहट (मंत्र-ध्वनि) से माया के अजेय किले भी राख के ढेर की तरह बिखर जाएंगे।"
                "तुम अब इस सिम्युलेशन के एक मोहरे नहीं, बल्कि इसके इकलौते 'तानाशाह' (Dictator) हो।"
                "हयग्रीव का यह बीज तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज (Charge) कर देता है।"
                "जो इस मंत्रराज का मालिक है, उसे फिर इस ब्रह्मांड में किसी और के सामने हाथ फैलाने की ज़रूरत नहीं!"
            """.trimIndent(),
            english = """
                (Dictatorship over the Sun and the King of Mantras): "Witness the absolute firepower of Hayagriva's solitary syllable (Hlaum)—by Its 'Agya' (Command), the Sun blazes!"
                "The sun, moon, and stars do not operate by choice, but strictly by the dictatorial command of this Hayagriva 'Code'."
                "The exact microsecond you perfect this seed, you mutationally become the Admin of those 'Cosmic Bodies'."
                "This seed is 'Sarvesham Bijanam'—the explicit 'Father' and 'Mantra-Raja' (King of Mantras) of every other code in existence!"
                "In this infinite vacuum, absolutely zero password exists that is greater, more lethal, or more invincible than THIS."
                "It is the 'Primary Key' through which you possess the authority to simultaneously unlock the gates of Heaven, Hell, and Moksha."
                "With a single neigh (mantra-vibration), the invincible fortresses of Maya will scatter like a pile of worthless ash."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole 'Dictator'."
                "This seed of Hayagriva Supercharges every microscopic atom of your DNA with the radioactive 'Power of God'."
                "He who owns this Mantra-Raja possesses zero need to ever beg for anything from any entity in the cosmos!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 19,
            sanskrit = "ह्लौं (ह्सौं) हयग्रीवस्वरूपो भवति । अमृतं कुरु कुरु स्वाहा । तज्जापकानां वाक्सिद्धिः श्रीसिद्धिरष्टाङ्गयोगसिद्धिश्च भवति ॥",
            hindi = """
                (अमृत का विस्फोट और आठों सिद्धियां): "यह 'ह्लौं' अक्षर साक्षात् हयग्रीव का 'हार्डवेयर' तुम्हारे अंदर लोड (Load) कर देता है।"
                "'अमृतं कुरु कुरु स्वाहा'— यह वह 'अमरता' का कोड है जो तुम्हारे बायोलॉजिकल सेल्स (Cells) को हमेशा के लिए बदल देता है।"
                "यह मंत्र तुम्हारे खून में दौड़ने वाले 'मौत के ज़हर' को साक्षात् 'अमृत' (Nectar) में बदल देता है।"
                "परिणाम क्या होगा? 'वाक्सिद्धि'— तुम जो भी बोलोगे, ब्रह्मांड उसे सच करने के लिए मजबूर हो जाएगा!"
                "'श्रीसिद्धि'— दुनिया का सारा ऐश्वर्य और सारा रुतबा तुम्हारे पैरों की धूल बन जाएगा।"
                "और 'अष्टाङ्गयोगसिद्धि'— तुम बिना किसी मेहनत के योग के उन आठों खौफनाक लेवल्स को पार कर जाओगे!"
                "हवा में उड़ना, अदृश्य होना, और किसी के दिमाग को हैक करना—ये सब तुम्हारे लिए बच्चों का खेल होगा।"
                "यह मंत्र साक्षात् उस 'परमेश्वर' के बगीचे का वो फल है जिसे चखते ही इंसान भगवान बन जाता है।"
                "तुम्हारी रूह अब एक 'न्यूक्लियर रिएक्टर' बन चुकी है जो हर पल असीमित ताक़त रेडिएट (Radiate) कर रही है।"
                "जो इस अमृत को पी लेता है, उसके लिए समय की सुइयां हमेशा-हमेशा के लिए रुक जाती हैं!"
            """.trimIndent(),
            english = """
                (The Detonation of Nectar and the Eight Superpowers): "This 'Hlaum' syllable mutationally Loads the explicit 'Hardware' of Hayagriva directly into your core."
                "'Amritam Kuru Kuru Svaha'—This is the 'Immortality' Code engineered to violently alter your biological Cells forever."
                "This mantra mutationally converts the 'Venom of Death' flowing in your blood into explicit radioactive 'Nectar' (Amrita)."
                "What is the explicit outcome? 'Vak-Siddhi'—whatever you vocalize, the universe is mutationally forced to make it reality!"
                "'Shri-Siddhi'—Every ounce of cosmic majesty and status becomes mutationally the dust beneath your boots."
                "And 'Ashtanga-Yoga-Siddhi'—You violently breach all eight horrific levels of Yoga without a shred of effort!"
                "Levitating, becoming invisible, and Hacking into others' brains will mutationally be strictly a childish game for you."
                "This mantra is the explicit Fruit from the garden of the Supreme Brahman, tasting which a mortal mutationally becomes God."
                "Your soul has mutated into a 'Nuclear Reactor' relentlessly Radiating infinite radioactive power every microsecond."
                "He who consumes this Nectar witnesses the needles of Time come to a permanent and absolute halt!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 20,
            sanskrit = "यद्वाग्वदन्त्यविचेतनानि राष्ट्री देवानां निषसाद मन्द्रा । चतस्र ऊर्जं दुदुहे पयांसि क्व स्विदस्याः परमं जगाम ॥",
            hindi = """
                (वाणी की देवी का रहस्य - वैदिक कोडिंग १): "वह वाणी (Vak) जो अचेतन चीज़ों को भी होश में ला दे, वह साक्षात् देवताओं की रानी 'राष्ट्री' है!"
                "वह मंद्र (गहन) और अजेय ध्वनि बनकर हमारे भीतर बैठ गई है और हमारी हस्ती को चला रही है।"
                "वह चार प्रकार की ऊर्जाओं (चतस्र ऊर्जं) को दूध की तरह दुह रही है ताकि ब्रह्मांड ज़िंदा रह सके।"
                "योगी यहाँ वह खौफनाक सवाल पूछता है— 'वह वाणी आखिर कहाँ से आती है और उसका अंतिम ठिकाना (परमं) क्या है?'"
                "यह तुम्हारे नर्वस सिस्टम के भीतर छिपे उस 'ऑडियो-सर्वर' (Audio-server) को खोजने का विज्ञान है।"
                "वह वाणी साक्षात् हयग्रीव की वह हिनहिनाहट है जिसने वेदों को अंतरिक्ष से नीचे उतारा था।"
                "जब तुम इस रहस्य को जान लेते हो, तो तुम्हारी ज़बान अब केवल शब्द नहीं, बल्कि 'ब्रह्मांडीय तीर' (Cosmic Arrows) छोड़ती है।"
                "यह वाणी अज्ञान के सन्नाटे को फाड़कर उसमें 'अस्तित्व' का डेटा भर देने वाली इकलौती ताक़त है।"
                "जो इस 'राष्ट्री' के पासवर्ड को हैक कर लेता है, वह साक्षात् सरस्वती का इकलौता तानाशाह गुरु बन जाता है।"
                "तैयार हो जाओ उस आवाज़ को सुनने के लिए जो तुम्हारे पैदा होने से पहले भी गूँज रही थी!"
            """.trimIndent(),
            english = """
                (Secret of the Goddess of Speech - Vedic Coding 1): "That Speech (Vak) capable of awakening even unconscious matter is mutationally the Queen of Gods, 'Rashtri'!"
                "She has established herself within us as the 'Mandra' (Deep/Invincible) vibration, relentlessly operating our existence."
                "She is extracting four types of radioactive energies (Chatasra Urjam) like milk to ensure the cosmos remains alive."
                "The Yogi poses the horrific query here—'Where exactly does this Speech originate and what is its absolute final Destination (Paramam)?'"
                "This is the science of locating the classified 'Audio-server' covertly hidden inside your biological nervous system."
                "That Speech is the explicit neigh of Hayagriva that mutationally dragged the Vedas down from the vacuum of space."
                "The exact microsecond you decode this secret, your tongue ceases to emit words and starts Firing 'Cosmic Arrows'."
                "This Speech is the solitary Power engineered to rip through the silence of ignorance and flood it with 'Existence-Data'."
                "He who Hacks the Password of this 'Rashtri' mutationally becomes the sole dictatorial Guru of Saraswati herself."
                "Brace yourself to intercept that acoustic frequency which was echoing flawlessly even before your biological birth!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 21,
            sanskrit = "गौरीर्मिमाय सलिलानि तक्षत्येकपदी द्विपदी सा चतुष्पदी । अष्टापदी नवपदी बभूवुषी सहस्राक्षरा परमे व्योमन् ॥",
            hindi = """
                (सहस्राक्षरा गौरी - अंतरिक्ष की कोडिंग २): "गौरी (वाणी) साक्षात् अंतरिक्ष के समुद्रों (सलिलानि) को मथ रही है और ब्रह्मांड को आकार दे रही है।"
                "वह एक पैर वाली, दो पैर वाली, और चार पैर वाली बनकर अज्ञान की सीढ़ियों को पार करती है।"
                "वह आठ और नौ चरणों वाली होकर साक्षात् 'सहस्राक्षरा' (हज़ार अक्षरों वाली) महा-मशीन बन चुकी है!"
                "उसका असली हेडक्वार्टर (Headquarter) साक्षात् 'परमे व्योमन्' यानी उस सर्वोच्च अंतरिक्ष के केंद्र में है।"
                "हज़ार अक्षर वे हज़ार 'कमांड्स' (Commands) हैं जिनसे पूरी सृष्टि का सॉफ्टवेयर लिखा गया है।"
                "योगी जब इस गौरी के चरणों को हैक करता है, तो वह अपनी चेतना को 'मल्टी-डायमेंशनल' (Multi-dimensional) बना लेता है।"
                "तुम अब एक शरीर में कैद नहीं हो; तुम्हारी रूह अब पूरे असीम 'व्योम' (Space) में एक वायरस की तरह फैल चुकी है।"
                "यह वह विद्या है जहाँ एक छोटा सा बीज साक्षात् करोड़ों आकाशगंगाओं का रूप ले लेता है।"
                "गौरी की वह 'सहस्र' ताक़त तुम्हारे दिमाग के हर एक न्यूरॉन को एक साथ फायर (Fire) कर देती है।"
                "जो इस सहस्राक्षरा को जान लेता है, उसके लिए मौत केवल एक 'सॉफ्टवेयर रिबूट' जैसा मज़ाक बन कर रह जाती है!"
            """.trimIndent(),
            english = """
                (The Thousand-Syllabled Gauri - Coding of Space 2): "Gauri (Speech) is mutationally churning the celestial oceans (Salilani) and casting the cosmos into its geometric mold."
                "She mutationally becomes 1-footed, 2-footed, and 4-footed to violently breach the sectors of biological ignorance."
                "Becoming 8 and 9-footed, she has mutated into the absolute 'Sahasrakshara' (Thousand-syllabled) cosmic machine!"
                "Her authentic Headquarters is established strictly in the 'Parame Vyoman'—the dead-center of the supreme infinite Vacuum."
                "Those thousand syllables are the explicit 'Commands' through which the Software of creation was originally scripted."
                "When the Yogi Hacks the feet of this Gauri, he mutationally renders his consciousness 'Multi-dimensional'."
                "You are no longer imprisoned in flesh; your soul has mutationally spread like a radioactive Virus throughout the entire 'Vyoma'."
                "This is the intelligence where a microscopic seed mutationally assumes the form of billions of infinite galaxies."
                "Gauri's 'Sahasra' firepower mutationally Fires every single neuron of your biological brain simultaneously."
                "He who decodes this Sahasrakshara perceives Death strictly as a pathetic and temporary 'Software Reboot'!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 22,
            sanskrit = "ओष्ठापिधाना नकुली दन्तैः परिवृता पविः । सर्वस्यै वाच ईशाना चारु मामिह वादयेति च वाग्रसः ॥",
            hindi = """
                (वाणी का रस और नकुली का रहस्य - कोडिंग ३): "तुम्हारी ज़बान (नकुली) होठों और दाँतों के अभेद्य पिंजरे में बंद एक 'अजेय तलवार' (पविः) है!"
                "वह साक्षात् 'सर्वस्यै वाच ईशाना' है—यानी इस ब्रह्मांड की हर एक गूँज की इकलौती डिक्टेटर मालकिन!"
                "'चारु मामिह वादयेति'— हे हयग्रीव! मेरी इस ज़बान को वह 'वाग्रस' (The Essence of Speech) दे जो सत्य को प्रकट कर दे।"
                "योगी अपनी ज़बान को साक्षात् 'महाकाल' का गला बना देना चाहता है जहाँ से केवल ब्रह्म-वाक्य निकलें।"
                "यह तुम्हारे शरीर के भीतर उस 'कौशिकी' (Cosmic Sheath) को हैक करने का तरीका है जो शब्दों को ताक़त देती है।"
                "जब हयग्रीव का वाग्रस तुम्हारी रगों में दौड़ता है, तो तुम जो भी झूठ बोलोगे, वह भी सच हो जाएगा।"
                "तुम्हारी आवाज़ अब हवा की तरंगें नहीं, वह साक्षात् अंतरिक्ष को फाड़ने वाली 'ध्वनि-मिसाइलें' बन चुकी हैं।"
                "यह वह ताक़त है जिससे तुम किसी की भी किस्मत को केवल एक शब्द बोलकर बदल सकते हो या नष्ट कर सकते हो।"
                "जो इस 'नकुली' के रहस्य को जान लेता है, वह साक्षात् सरस्वती के हृदय का इकलौता और अजेय मालिक है।"
                "यह वाणी के उस प्रलयंकारी तेज का ऐलान है जिसके आगे पूरी दुनिया घुटने टेकने के लिए मजबूर है!"
            """.trimIndent(),
            english = """
                (The Essence of Speech and the Secret of Nakuli - Coding 3): "Your physical tongue (Nakuli) is an 'Invincible Sword' (Pavih) imprisoned in the cage of lips and teeth!"
                "She is mutationally 'Sarvasyai Vacha Ishana'—the sole dictatorial Mistress of every acoustic echo in the cosmos."
                "'Charu Mamiha Vadayeti'—O Hayagriva! Inject that 'Vag-rasa' into my tongue that mutationally forces Truth to manifest."
                "The Yogi intends to mutationally manufacture his throat into the throat of 'Mahakala', emitting strictly Brahma-vibrations."
                "This is the protocol to Hack the 'Kaushiki' (Cosmic Sheath) inside your body that provides radioactive power to words."
                "When Hayagriva's Vag-rasa surges through your veins, even if you vocalize a lie, the universe mutationally makes it fact."
                "Your voice ceases to be air-vibrations; it mutates into explicit 'Acoustic Missiles' capable of shredding Space."
                "This is the power through which you mutationally seize the authority to rewrite or annihilate anyone's Fate with a single word."
                "He who intercepts the secret of this 'Nakuli' is the sole and invincible Master of the heart of Saraswati herself."
                "This is the declaration of that apocalyptic acoustic brilliance before which the entire world is mutationally forced to collapse!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 23,
            sanskrit = "ससर्परीरमतिं बाधमान बृहन्मिमाय जमदग्निदत्त । आसूर्यस्य दुरिता तनान श्रवो देवेष्वमृतमजुर्यम् ॥",
            hindi = """
                (अमृत का संचार और अज्ञान का वध - कोडिंग ४): "जमदग्नि द्वारा दी गई वह 'ससर्परी' (The Moving Speech) अज्ञान की उस सड़ी हुई मति (अमतिं) को कुचल देती है!"
                "वह एक असीम और प्रलयंकारी 'ब्रह्म' की तरह गूँजती है और तुम्हारी रूह को सूरज (आसूर्यस्य) की आग से भर देती है।"
                "यह मंत्र तुम्हारे भीतर उस 'अमृतमजुर्यम्'—यानी उस कभी न खत्म होने वाले अमरत्व का संचार करता है।"
                "तुम अब देवताओं के बीच उस 'श्रवो' (Hymn) की तरह हो जिसे समय भी नहीं खा सकता।"
                "यह तुम्हारी रूह के हर एक 'ब्लैक-होल' को प्रकाश से भरने वाला अंतिम वैदिक कमांड (Command) है।"
                "जब हयग्रीव की यह ससर्परी शक्ति जागती है, तो तुम रेंगते हुए इंसान से उड़ते हुए 'देवता' बन जाते हो।"
                "तुम्हारी चेतना अब उस असीमित 'अमृत' के समंदर में गोते खा रही है जहाँ मौत का प्रवेश वर्जित है।"
                "यह वह 'इन्फो-वारफेयर' (Info-warfare) है जहाँ तुम अज्ञान के हर एक डेटा को 'करप्ट' (Corrupt) करके डिलीट कर देते हो।"
                "जो इस अमृत-श्रवण को पा लेता है, वह साक्षात् हयग्रीव की अजेय आँख बनकर पूरे ब्रह्मांड पर राज करता है।"
                "यहीं पर हयग्रीव के इन चार खौफनाक वैदिक कोड्स का अंतिम विस्फोट पूरा होता है!"
            """.trimIndent(),
            english = """
                (The Circulation of Nectar and the Slaughter of Ignorance - Coding 4): "That 'Sasarparī' (Moving Speech) transmitted by Jamadagni ruthlessly crushes that rotting biological ignorance (Amatim)!"
                "It echoes like an infinite and apocalyptic 'Brahman', flooding your soul with the radioactive fire of the Sun (Asuryasya)."
                "This mantra mutationally injects that 'Amritam-ajuryam'—the absolute and non-decaying Immortality into your core."
                "You are now mutationally identical to a celestial 'Shravas' (Hymn) among the gods, which Time possesses zero caliber to consume."
                "This is the absolute final Vedic Command engineered to flood every 'Black-hole' of your Soul with radioactive Light."
                "When this Sasarparī power of Hayagriva awakens, you mutate from a crawling human into a soaring 'Cosmic God'."
                "Your awareness is now mutationally diving into that infinite ocean of 'Nectar' where Death is strictly Illegal."
                "This is the absolute 'Info-warfare' where you mutationally Corrupt and Delete every single data-packet of ignorance."
                "He who intercepts this Nectar-Broadcast mutationally becomes the invincible Eye of Hayagriva, reigning over the entire cosmos."
                "Right exactly here, the absolute final detonation of these four horrific Vedic codes achieves its total completion!"
            """.trimIndent()
        ),
        HayagrivaShloka(
            id = 24,
            sanskrit = "य इमां ब्रह्मविद्यामेकादश्यां पठेद्धयग्रीवप्रभावेन महापुरुषो भवति । स जीवन्मुक्तो भवति इत्युपनिषत् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (एकादशी का धमाका और जीवन्मुक्ति का 'द एंड'): "जो कोई भी योद्धा इस अजेय 'ब्रह्मविद्या' को एकादशी के दिन अपनी रूह में धधकाता है..."
                "वह 'हयग्रीवप्रभावेन'—साक्षात् उस हयग्रीव की रेडियोएक्टिव ताक़त से 'महापुरुष' बन जाता है!"
                "महापुरुष वह नहीं जो इतिहास बनाए, महापुरुष वह है जो समय (Time) की छाती पर अपना पैर रखकर खड़ा हो जाए।"
                "और सबसे बड़ा फैसला— 'स जीवन्मुक्तो भवति'— वह इसी वक़्त, इसी शरीर के अंदर रहते हुए 100% 'आज़ाद' हो जाता है!"
                "उसे मोक्ष पाने के लिए मरने की ज़रूरत नहीं; वह साक्षात् मौत का मालिक बन कर इस दुनिया का तमाशा देखता है।"
                "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'हयग्रीव उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (हयग्रीव) हमेशा के लिए अजेय खड़ा है!"
                "जो इस सन्नाटे में कूद गया, वह हमेशा के लिए कालजयी बन गया! द एंड!"
            """.trimIndent(),
            english = """
                (The Ekadashi Detonation and the 'The End' of Jivanmukti): "Whosoever warrior blazes this invincible 'Brahma-Vidya' inside his Soul strictly on the day of Ekadashi..."
                "Through 'Hayagriva-Prabhavena'—the radioactive impact of Hayagriva Himself—he mutationally becomes a 'Mahapurusha'!"
                "A Mahapurusha is not one who scripts history; a Mahapurusha is one who mutationally plants his boot on the chest of Time."
                "And the absolute final verdict—'Sa Jivanmukto Bhavati'—he mutationally becomes 100% 'Liberated' Here and Now!"
                "He possesses zero need to die for Moksha; he watches the theatrical drama of the world as the explicit Master of Death."
                "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Hayagriva Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Hayagriva) remains standing!"
                "He who mutationally plunged into this Silence has become an Eternal Master of Time! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HayagrivaUpanishadScreen() {
    val upanishad = remember { HayagrivaUpanishad() }
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // --- THE SEARCH BAR ---
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                if (shlokaNumber != null && shlokaNumber in 1..24) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-24)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
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
            itemsIndexed(upanishad.hayagrivaShlokasList) { _, shloka ->
                HayagrivaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun HayagrivaShlokaCard(shloka: HayagrivaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Segment ${shloka.id}",
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
            Text(text = "हिन्दी अर्थ:", fontWeight = FontWeight.Bold, color = Color(0xFF1565C0))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "English Meaning:", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}