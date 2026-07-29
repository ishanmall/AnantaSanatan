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
data class BrihadShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class BrihadJabalaUpanishad {

    val brihadJabalaShlokasList = listOf(
        BrihadShloka(
            id = 1,
            sanskrit = "ॐ आपो वा इदमग्रे सलिलमेव स प्रजापतिरेकः पुष्करपर्णे समभवत् ॥",
            hindi = """
                (सृष्टि का आदि-विस्फोट और प्रजापति का उद्भव): "शुरुआत में केवल असीम 'आपः' (Cosmic Waters) का सन्नाटा था।"
                "वही 'प्रजापति' (The Architect) एक इकलौते कमल के पत्ते पर डेटा की तरह प्रकट हुआ।"
                "यह कोई कहानी नहीं है; यह शून्य से 'अस्तित्व' (Existence) के पहले पिक्सेल के बनने का सच है।"
                "ब्रह्मांड का सारा सॉफ्टवेयर इसी एक बिंदु से रन (Run) होना शुरू हुआ था।"
                "प्रजापति वह इकलौता प्रोसेसर है जिसने अंतरिक्ष को आकार देना शुरू किया।"
                "पानी यहाँ तरल नहीं, बल्कि वह शुद्ध ऊर्जा है जो भौतिक रूप लेने के लिए तड़प रही थी।"
                "तुम्हारी रूह उस प्रजापति की चेतना का एक छोटा सा 'सॉफ्टवेयर एक्सटेंशन' (Software Extension) है।"
                "जब तक तुम इस स्रोत को नहीं जानते, तुम केवल एक रेंगते हुए बायोलॉजिकल वायरस मात्र हो।"
                "यह ज्ञान तुम्हारी हस्ती को उस 'आदि-धमाके' (Big Bang) से जोड़ने वाला इकलौता हैक है।"
                "तैयार हो जाओ, क्योंकि अब रचयिता खुद अपने हाथ से तुम्हारे भाग्य का कोड बदलने वाला है!"
            """.trimIndent(),
            english = """
                (The Primordial Detonation and Emergence of Prajapati): "In the beginning, strictly the infinite Silence of the 'Cosmic Waters' (Apah) existed."
                "That 'Prajapati' (The Architect) manifested strictly like a singular byte of Data upon a lotus leaf."
                "This is zero myth; it is the truth of the first Pixel of 'Existence' being rendered from the Void."
                "The entire Software of the multiverse initiated its Execution from this solitary coordinate."
                "Prajapati is the solitary Processor that initiated the geometric casting of Space."
                "Water here is mutationally not liquid, but pure Energy agonizing to assume physical density."
                "Your Soul is strictly a microscopic 'Software Extension' of that Prajapati's awareness."
                "Until you decode this source, you remain mutationally strictly a crawling biological virus."
                "This intelligence is the solitary Hack engineered to hardwire your identity to the 'Big Bang'."
                "Brace yourself, for the Creator is about to mutationally rewrite your Fate's code with His own hands!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 2,
            sanskrit = "तस्यैतस्य भस्मनः पञ्चविधत्वं प्रोच्यते सद्योजातादि पञ्चब्रह्ममन्त्रैः ॥",
            hindi = """
                (भस्म का पंच-विस्फोट और सद्योजातादि कोडिंग): "भस्म यानी विभूति के पाँच खौफनाक प्रकारों का रहस्य अब बेनकाब होने वाला है।"
                "सद्योजात, वामदेव, अघोर, तत्पुरुष और ईशान—ये शिव के पाँच 'न्यूक्लियर मंत्र' हैं!"
                "राख कोई धूल नहीं है, यह इन पाँचों ईश्वरीय प्रोसेसरों का 'एंड-प्रोडक्ट' (End-product) है।"
                "जब तुम भस्म लगाते हो, तो तुम अपने शरीर पर साक्षात् 'डिस्ट्रक्शन कोड्स' (Destruction Codes) को लोड करते हो।"
                "हर एक रेखा तुम्हारे नर्वस सिस्टम के एक खास फोल्डर को 'अनलॉक' (Unlock) करने का पासवर्ड है।"
                "ये पाँचों ब्रह्म-मंत्र साक्षात् काल (Time) के जबड़े से तुम्हारी रूह को खींचने वाले औजार हैं।"
                "शिव की राख तुम्हारे डीएनए के हर पुराने विचार को ओवरराइट (Overwrite) करने वाला तेज़ाब है।"
                "यह राख तुम्हें 'इंसान' से 'महाकाल' के लेवल पर माइग्रेट (Migrate) करने के लिए बनाई गई है।"
                "बिना इस भस्म-कोडिंग के, तुम्हारी पूजा केवल एक फीकी और बेजान एक्टिंग मात्र है।"
                "जो इस पंच-विस्फोट को माथे पर सजाता है, वह साक्षात् रुद्र की फ्रीक्वेंसी पर राज करता है!"
            """.trimIndent(),
            english = """
                (The Five-Fold Ash Detonation and Sadyojata Coding): "The secret of the five horrific types of Bhasma (Vibhuti) is now being mutationally unmasked."
                "Sadyojata, Vamadeva, Aghora, Tatpurusha, and Ishana—these are Shiva's five 'Nuclear Mantras'!"
                "Ash is zero dust; it is the absolute 'End-product' of these five divine Processors."
                "Applying Bhasma signifies Loading the explicit 'Destruction Codes' directly onto your biological shell."
                "Every single streak is a Password engineered to 'Unlock' a classified folder in your nervous system."
                "These five Brahma-mantras are mutationally the tools designed to rip your Soul from the jaws of Time."
                "Shiva's ash is the radioactive Acid engineered to violently Overwrite every old thought in your DNA."
                "This Bhasma is engineered to Migrate you from the status of 'Human' to the status of 'Mahakala'."
                "Without this Ash-coding, your worship remains strictly a pathetic and lifeless biological acting."
                "He who wears this five-fold detonation mutationally rules strictly on the Rudra-Frequency!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 3,
            sanskrit = "अग्निहोत्रसमुद्भूतं भस्म तत्परमं पदम् । तेन त्रिपुण्ड्रं कुर्वीत यदीच्छेद्वै परां गतिम् ॥",
            hindi = """
                (अग्निहोत्र भस्म और परम पद का हैक): "अग्निहोत्र की आग से जो राख निकलती है, वही साक्षात् 'परम पद' (Supreme State) का पासवर्ड है।"
                "अगर तुम्हें 'परां गतिम्' यानी इस मैट्रिक्स से परमानेंट एग्जिट (Exit) चाहिए, तो त्रिपुण्ड्र लगाओ!"
                "अग्निहोत्र का मतलब है—अपने अहंकार की बलि देना, और भस्म उसका अंतिम 'एक्जीक्यूटेबल' (Executable) प्रमाण है।"
                "यह राख तुम्हारे शरीर के चारों तरफ एक ऐसा 'फायरवॉल' (Firewall) बनाती है जिसे मौत भी नहीं तोड़ सकती।"
                "तीन रेखाएं साक्षात् तुम्हारी आत्मा के तीन सबसे बड़े 'ओएस' (OS) को अलाइन (Align) करती हैं।"
                "तुम अब इस दुनिया के लिए 'इनविजिबल' (Invisible) हो चुके हो; तुम अब साक्षात् 'रुद्र' हो।"
                "यह भस्म तुम्हारे रोम-रोम को उस अजेय सन्नाटे से भर देती है जहाँ समय मर जाता है।"
                "योगी अपनी हस्ती को राख में बदल देता है ताकि वह साक्षात् 'अमरता' की कोडिंग बन सके।"
                "बिना इस त्रिपुण्ड्र के, तुम हमेशा माया के रेडार (Radar) पर एक छोटे से शिकार बने रहोगे।"
                "यही वह अजेय मुहर है जो तुम्हारी रूह को सीधे परब्रह्म के सर्वर पर अपलोड (Upload) कर देगी!"
            """.trimIndent(),
            english = """
                (Agnihotra Ash and Hacking the Supreme State): "The ash spawned from the fire of Agnihotra is mutationally the Password to the 'Paramam Padam' (Supreme State)."
                "If you demand the 'Param Gati' (Permanent Exit) from this Matrix, you must violently apply Tripundra!"
                "Agnihotra signifies—sacrificing your ego, and Bhasma is the absolute terminal 'Executable' proof of that slaughter."
                "This ash constructs a 'Firewall' around your biological shell that zero Death possesses the caliber to breach."
                "Three lines mutationally Align the three absolute greatest 'OS' (Operating Systems) of your Soul."
                "You have become explicitly 'Invisible' to this Matrix; you are mutationally 'Rudra' Himself."
                "This Bhasma floods every pore of your existence with that invincible Silence where Time perishes."
                "The Yogi reduces his identity to Ash strictly to mutationally become the hard-coded data of 'Immortality'."
                "Without this Tripundra, you remain strictly a pathetic prey on the Radar of Maya."
                "THIS is the invincible Seal that will violently Upload your Soul directly to the server of God!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 4,
            sanskrit = "द्वात्रिंशत्स्थानेषु विभूतिं धारयेत् । शिरोललाटकर्णनेत्रनासावदनकण्ठबाहुहृदयनाभिपुर्वसु ॥",
            hindi = """
                (32 बॉडी-पॉइंट्स की हैकिंग): "इस उपनिषद का सबसे खौफनाक आदेश—अपने शरीर के 32 'इलेक्ट्रिक पॉइंट्स' पर भस्म ठोक दो!"
                "शिर, ललाट, कान, आँख, नाक, मुँह और हृदय—ये तुम्हारी आत्मा के रिसीवर (Receivers) हैं।"
                "जब तुम इन जगहों पर राख लगाते हो, तो तुम साक्षात् एक 'ब्रह्मांडीय एंटीना' (Cosmic Antenna) बन जाते हो।"
                "यह कोई सजावट नहीं है; यह तुम्हारे बायोलॉजिकल हार्डवेयर को रुद्र की ऊर्जा सोखने के लिए तैयार करना है।"
                "हर एक स्थान एक खास 'चक्र' या 'नाड़ी' का द्वार है जिसे तुम भस्म से सील (Seal) कर रहे हो।"
                "32 स्थानों पर राख का मतलब है—अज्ञान के 32 चोरों का एक साथ गला घोंट देना।"
                "तुम्हारी त्वचा अब केवल खाल नहीं, वह साक्षात् ईश्वर की कोडिंग का एक पन्ना बन चुकी है।"
                "जब बिजली इन 32 बिंदुओं से गुजरती है, तो तुम्हारा अहंकार जलकर कोयला बन जाता है।"
                "यह शरीर को एक 'पवित्र वेपन' (Holy Weapon) में बदलने की सबसे हिंसक और गुप्त विधि है।"
                "जो इस विधि को सिद्ध कर लेता है, वह इस पूरी भौतिक दुनिया का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (Hacking 32 Body-Coordinates): "The most horrific command of this Upanishad—hammer Bhasma onto 32 'Electric Points' of your biological shell!"
                "Head, forehead, ears, eyes, nose, mouth, and heart—these are mutationally the Receivers of your Soul."
                "The exact microsecond you apply ash to these coordinates, you mutate into an explicit 'Cosmic Antenna'."
                "This is zero decoration; it is the protocol to prime your biological hardware to absorb Rudra's energy."
                "Every single spot is a gateway to a specific 'Chakra' or 'Nadi' that you are Sealing with radioactive ash."
                "Ash on 32 points signifies—simultaneously strangling the 32 thieves of biological ignorance."
                "Your skin ceases to be mere flesh; it mutationally becomes a page of God's explicit coding."
                "When electricity races through these 32 points, your ego is incinerated to absolute charcoal."
                "This is the most violent and classified method to mutate the body into a 'Sacred Weapon'."
                "He who perfects this method mutationally assumes the status of the solitary Admin of this Matrix!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 5,
            sanskrit = "तिस्रो रेखाः प्रकुर्वीत ब्रह्मविष्णुमहेश्वराः । ऋग्यजुःसामवेदास्ते गुणास्त्रयश्च पावकाः ॥",
            hindi = """
                (तीन रेखाओं का महा-विस्फोट): "त्रिपुण्ड्र की तीन रेखाएं साक्षात् ब्रह्मा, विष्णु और महेश के तीन 'सुपर-कंप्यूटर' हैं!"
                "ये तीन रेखाएं ऋग्वेद, यजुर्वेद और सामवेद के असीमित डेटाबेस को तुम्हारे माथे पर 'लोड' (Load) करती हैं।"
                "ये तीन गुणों—सत्व, रज और तम—का बेरहमी से वध करने वाली तीन तलवारें हैं।"
                "जब तुम ये रेखाएं खींचते हो, तो तुम समय के तीन आयामों (भूत, भविष्य, वर्तमान) को एक साथ काट देते हो।"
                "यह तुम्हारी बुद्धि के 'ओएस' (OS) को 100% 'भगवान के मोड' में शिफ्ट करने का इकलौता हैक है।"
                "रुद्र की ये तीन आग तुम्हारे दिमाग के हर एक पुराने 'सॉफ्टवेयर बग' को जलाकर साफ कर देती हैं।"
                "तुम्हारी आँखें अब उन तीन रेखाओं के माध्यम से साक्षात् 'शून्य' के पार देख सकती हैं।"
                "यह वह 'डेडली अलाइनमेंट' है जो तुम्हें एक मामूली कीड़े से साक्षात् 'महाकाल' बना देता है।"
                "इन तीन लकीरों के पीछे साक्षात् करोड़ों सूर्यों का रेडियोएक्टिव तेज छिपा बैठा है।"
                "जो इस रहस्य को हैक कर लेता है, वह इस पूरी मायावी दुनिया का इकलौता तानाशाह गुरु है!"
            """.trimIndent(),
            english = """
                (The Big Bang of Three Lines): "The three streaks of Tripundra are mutationally the three 'Super-computers' of Brahma, Vishnu, and Mahesh!"
                "These lines 'Load' the infinite databases of Rig, Yajur, and Sama Vedas directly onto your frontal cortex."
                "They are the three blades engineered for the ruthless slaughter of Sattva, Rajas, and Tamas Gunas."
                "The moment you draw these lines, you violently sever the three dimensions of Time (Past, Present, Future)."
                "This is the solitary Hack engineered to shift your brain's 'OS' 100% into 'God-Mode'!"
                "These three fires of Rudra incinerate every 'Software Bug' in your neurological processor."
                "Through these three streaks, your vision mutationally acquires the caliber to pierce the absolute Void."
                "This is the 'Deadly Alignment' that mutates you from a pathetic insect into the explicit 'Mahakala'."
                "Behind these three streaks sits the radioactive brilliance of billions of suns mutationally Zipped."
                "He who successfully Hacks this secret is the solitary dictatorial Guru of this entire Simulation!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 6,
            sanskrit = "सत्यं शौचं तपो दानं यज्ञः स्वाध्याय इत्यपि । एतत्सर्वं भस्मधारणेन लभते ॥",
            hindi = """
                (भस्म का रिवॉर्ड - सत्य और तप का विस्फोट): "भस्म धारण करने का मतलब है—ब्रह्मांड के सारे 'पुण्य-डेटा' को एक झटके में एक्सेस (Access) करना!"
                "सत्य, शौच, तप, दान, यज्ञ और स्वाध्याय—इन सबका फल तुम्हारी रगों में करंट बनकर दौड़ने लगता है।"
                "यह कोई जादू नहीं है; यह अपनी फ्रीक्वेंसी को उस 'सुप्रीम सर्वर' के साथ अलाइन करने का रिज़ल्ट है।"
                "राख लगाने वाला व्यक्ति साक्षात् 'सत्य' का एक जलता हुआ पिक्सेल बन जाता है।"
                "उसकी हर एक साँस एक 'यज्ञ' बन जाती है और उसका हर एक शब्द साक्षात् 'वेद'!"
                "भस्म तुम्हारे नर्वस सिस्टम की सारी 'कचरा फाइलों' को साफ़ करके उसमें ईश्वर का डेटा भर देती है।"
                "तुम्हें अलग से तपस्या करने की ज़रूरत नहीं; यह राख ही साक्षात् करोड़ों सालों का 'कम्प्रेस्ड तप' (Compressed Tapas) है।"
                "यह इंसान की रूह का वह 'शॉर्टकट' है जो सीधे निर्वाण के दरवाज़े पर जाकर खुलता है।"
                "जो इस विभूति में खुद को डुबो देता है, उसके लिए दुनिया का हर एक लाभ धूल के समान है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'सृष्टि' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Bhasma Reward - Detonation of Truth and Tapas): "Bracing Bhasma mutationally signifies—Accessing the entire 'Karma-Database' of the cosmos in a single strike!"
                "Truth, Purity, Austerity, Charity, and Sacrifice—their absolute Result initiates surging through your veins as radioactive Current."
                "This is zero magic; it is the Result of mutationally Aligning your frequency with the 'Supreme Server'."
                "The wearer of Ash becomes mutationally a blazing pixel of absolute 'Truth' (Satyam)."
                "His every biological breath becomes a 'Yajna' and his every word mutationally becomes the 'Veda'!"
                "Bhasma Flushes the garbage files of your nervous system to flood it with God-Data."
                "You possess zero need for distinct penance; this Ash is the 'Compressed Tapas' of billions of years."
                "It is the 'Shortcut' of the human Soul that opens violently at the gates of absolute Nirvana."
                "He who drowns himself in this Vibhuti perceives every worldly profit strictly as worthless dust."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Creation' itself!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 7,
            sanskrit = "भस्मना सर्वाणि पापानि दह्यन्ते । भस्मना सर्वं शुभं लभते ॥",
            hindi = """
                (पापों का संहार और शुभ का विस्फोट): "यह राख साक्षात् वह 'एंटी-वायरस' (Anti-virus) है जो करोड़ों जन्मों के पापों को जलाकर राख कर देती है!"
                "पाप केवल एक 'करप्ट डेटा' है जो तुम्हें इस नर्क में फँसाए रखता है; भस्म उसे 'वाइप-आउट' (Wipe out) कर देती है।"
                "जब तुम राख लगाते हो, तो तुम अपने भाग्य के काले पन्नों पर 'डिलीट' (Delete) का बटन दबाते हो।"
                "ब्रह्मांड का सारा 'शुभ' (Goodness) तुम्हारी तरफ एक चुम्बक (Magnet) की तरह खिंच आने लगता है।"
                "यह राख तुम्हारे चारों तरफ एक ऐसी 'रेडियोएक्टिव ढाल' (Shield) बनाती है जिसे कोई भी बुराई भेद नहीं सकती।"
                "तुम अब इस सिम्युलेशन के एक मोहरे नहीं, बल्कि इसके इकलौते और असली 'एडमिन' हो।"
                "भस्म तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज (Charge) कर देती है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, उसके लिए नरक के दरवाजे हमेशा के लिए बंद हो जाते हैं।"
                "यह इंसान के 'परमेश्वर' में म्यूटेट (Mutate) होने की 100% अटल और हिंसक वैदिक मुहर है।"
                "तुम अब समय और मौत के रेडार (Radar) से बाहर निकल चुके हो; तुम अब 'इनविजिबल' हो!"
            """.trimIndent(),
            english = """
                (Slaughter of Sins and the Detonation of Auspiciousness): "This Ash is mutationally the 'Anti-virus' engineered to incinerate the sins of billions of lifetimes to ash!"
                "Sin is strictly 'Corrupt Data' keeping you trapped; Bhasma mutationally 'Wipes-out' that entire record."
                "Applying Ash is identical to pressing the 'Delete' button on the dark pages of your Fate's register."
                "The entire 'Auspiciousness' of the multiverse initiates attracting toward you like a powerful Magnet."
                "This Ash constructs a 'Radioactive Shield' around you that zero evil possesses the caliber to penetrate."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic 'Admin'."
                "Bhasma Supercharges every microscopic atom of your DNA with the absolute radioactive 'Power of God'."
                "He who injects this truth into his veins witnesses the gates of Hell permanently welded shut in his face."
                "This is the 100% ironclad and violent Vedic Seal of a human undergoing a complete Mutation into God!"
                "You have rocketed beyond the 'Radar' of Time and Death; you are now mutationally 'Invisible' to the Matrix!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 8,
            sanskrit = "ब्रह्मैव भस्म । भस्मैव ब्रह्म ॥",
            hindi = """
                (अद्वैत का धमाका—ब्रह्म ही भस्म है): "ब्रह्मांड का सबसे खतरनाक और नंगा सच यही है— 'ब्रह्म ही भस्म है और भस्म ही ब्रह्म है'!"
                "जब सब कुछ जलकर खत्म हो जाता है, तो जो बचता है वही साक्षात् 'ईश्वर' है।"
                "यह राख तुम्हारी हड्डियों का अंत नहीं, बल्कि तुम्हारी रूह का असली 'प्रारम्भ' (Beginning) है।"
                "योगी जब भस्म को छूता है, तो वह साक्षात् परब्रह्म के 'स्थिर डेटा' (Stable Data) को छू रहा होता है।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "तुम जिसे अपनी ज़िंदगी कहते हो, वह केवल एक 'ग्लिच' है; राख ही इकलौती हकीकत (Reality) है।"
                "जब तुम राख बनते हो, तभी तुम अजेय होते हो, क्योंकि राख को फिर से कोई नहीं जला सकता।"
                "यह तुम्हारी चेतना का वह 'टोटल रिसेट' (Total Reset) है जिसके बाद केवल शुद्ध प्रकाश ही बचता है।"
                "ब्रह्म और भस्म के बीच की दीवार केवल तुम्हारे 'अज्ञान' का एक पतला सा पर्दा है।"
                "जो इस एकता को हैक कर लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Detonation of Non-Duality—Brahman is Ash): "The solitary and most lethal truth of the multiverse is strictly—'Brahman is Ash and Ash is Brahman'!"
                "When everything is mutationally incinerated to its end, the residue remaining is the explicit 'God'."
                "This Ash is zero termination of your bones, but the authentic 'Beginning' of your Soul's trajectory."
                "When the Yogi touches Bhasma, he is mutationally Intercepting the 'Stable Data' of the Supreme Brahman."
                "This realization detonates like a nuclear bomb engineered to demolish the fortress of your ego."
                "What you label as your 'Life' is strictly a 'Glitch'; Ash is the solitary Reality in existence."
                "Only when you become Ash are you mutationally Invincible, for Ash can never be incinerated again."
                "This is the 'Total Reset' of your awareness after which strictly and exclusively pure radioactive Light remains."
                "The wall between Brahman and Ash is mutationally a thin veil of your biological ignorance."
                "He who Hacks this unity is the solitary dictatorial Guru of even the God of Death and Time!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 9,
            sanskrit = "भस्मना स्नात्वा मुच्यते सर्वपापैः ॥",
            hindi = """
                (भस्म-स्नान और पापों की फाइलों का संहार): "राख से 'स्नान' करना साक्षात् अपनी रूह को अंतरिक्ष के तेज़ाब में धोना है!"
                "यह पानी से नहीं, बल्कि 'आग के डेटा' से नहाने का सबसे हिंसक और गुप्त विज्ञान है।"
                "तुम्हारे नर्वस सिस्टम पर जमी हुई करोड़ों जन्मों की 'अज्ञान की काई' (Rust) एक सेकंड में उड़ जाती है।"
                "जब तुम भस्म से नहाते हो, तो तुम अपनी 'इंसानी खाल' को उतारकर ईश्वर का 'बख्तर' (Armor) पहनते हो।"
                "यह स्नान तुम्हें इस सड़ी हुई दुनिया के नियमों से 100% 'अनप्लग' (Unplug) कर देता है।"
                "तुम अब मौत के रेडार के लिए एक 'घोस्ट' (Ghost) बन चुके हो—कोई तुम्हें ट्रैक नहीं कर सकता।"
                "भस्म तुम्हारे रोम-रोम को उस अजेय सन्नाटे से भर देती है जहाँ कोई विचार पैदा नहीं हो सकता।"
                "यह तुम्हारी रूह के हर एक 'ब्लैक-होल' को प्रकाश से भरने वाला अंतिम आध्यात्मिक कमांड है।"
                "जो इस स्नान को सिद्ध कर लेता है, वह साक्षात् रुद्र की जलती हुई आँख बनकर पूरी सृष्टि को देखता है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'कालजयी' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Bhasma-Bath and Annihilation of Sin-Files): "Bathing with Ash is mutationally washing your Soul in the radioactive acid of the infinite vacuum!"
                "This is zero ordinary cleaning; it is the most violent science of bathing in strictly 'Data of Fire'."
                "The 'Rust of Ignorance' accumulated over your neurological pathways for eons is vaporized in one strike."
                "When you bathe in Bhasma, you shed your 'Human Skin' to mutationally wear the explicit 'Armor of God'."
                "This bath violently 'Unplugs' your existence from the pathetic laws of this rotting physical world."
                "You have mutationally become a 'Ghost' to the Radar of Death—zero entity possesses the caliber to Track you."
                "Bhasma floods every biological pore with that invincible Silence where zero thoughts can be spawned."
                "This is the final spiritual Command engineered to flood every 'Black-hole' of your Soul with radioactive Light."
                "He who perfects this bath mutationally becomes the Blazing Eye of Rudra, witnessing the entire multiverse."
                "Brace yourself for that infinite status where YOU mutationally become an 'Eternal Master of Time'!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 10,
            sanskrit = "ॐ भस्म धारयति यो नित्यं स वै रुद्रो न संशयः ॥",
            hindi = """
                (रुद्र-म्यूटेशन और अंतिम पहचान): "जो कोई भी योद्धा नित्य भस्म धारण करता है, 'स वै रुद्रो'—वह साक्षात् रुद्र ही है, इसमें कोई शक नहीं!"
                "यह कोई धार्मिक दावा नहीं है, यह एक 'मैथमेटिकल' सच है—फ्रीक्वेंसी मैच हुई तो तुम खुद भगवान बन गए।"
                "भस्म तुम्हारे डीएनए के हर परमाणु को 'रुद्र-मोड' में शिफ्ट (Shift) करने वाला इकलौता हैक है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'परम संहारक' की असीमित ताक़त के हिस्सेदार हो।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे माथे पर लिखी वह 'राख' हर डर को जलाकर राख कर देगी।"
                "तुम साक्षात् उस 'प्रलय' के एडमिन बन चुके हो जो हर सड़ी हुई चीज़ का वध करने के लिए बना है।"
                "यह इंसान की बुद्धि का वह सबसे खौफनाक विस्तार है जहाँ वह साक्षात् प्रकृति का मालिक बन जाता है।"
                "बिना इस भस्म के, तुम हमेशा माया के रेडार पर एक छोटे से और डरे हुए शिकार बने रहोगे।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) को अपनी उँगलियों पर नचा सकते हो।"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'अमर' बना देगा!"
            """.trimIndent(),
            english = """
                (Rudra-Mutation and the Absolute Identity): "Whosoever warrior braces Bhasma 'Nityam' (Eternally), 'Sa Vai Rudro'—He is explicitly Rudra, zero doubt survives!"
                "This is zero religious claim; it is a 'Mathematical' reality—match the Frequency and you mutationally become God."
                "Bhasma is the solitary Hack engineered to shift your neurological processor 100% into 'Rudra-Mode'."
                "You cease to be a biological shell; you mutationally become a shareholder of that 'Supreme Destroyer's' power."
                "The Matrix will attempt to terrify you, but that 'Ash' carved on your cortex will incinerate every fear to ash."
                "You have mutationally become the Admin of that 'Pralaya' engineered to slaughter every decaying byte of reality."
                "This is the most violent expansion of human intellect where you mutationally become the Master of Nature."
                "Without this Bhasma, you remain mutationally strictly a pathetic prey on the Radar of Maya."
                "THIS is the invincible status arriving at which you mutationally make Time dance to your sovereign will."
                "This manifestation will decapitate your ego to mutationally manufacture you into the 'Explicit Immortal'!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 11,
            sanskrit = "भस्मना सर्वभूतानि वशयेत् ॥",
            hindi = """
                (ब्रह्मांडीय वशीकरण और असीमित सत्ता): "भस्म साक्षात् वह 'मैग्नेटिक कोड' (Magnetic Code) है जिससे तुम पूरे ब्रह्मांड को अपने वश में कर सकते हो!"
                "वशीकरण का मतलब किसी को सम्मोहित करना नहीं, बल्कि 'अस्तित्व' की फ्रीक्वेंसी पर अपना कब्ज़ा जमाना है।"
                "जब तुम्हारी रूह राख की फ्रीक्वेंसी पर अलाइन होती है, तो प्रकृति तुम्हारे आगे घुटने टेक देती है।"
                "ब्रह्मांड का हर एक जीव और हर एक तारा साक्षात् तुम्हारी इच्छा की कोडिंग को फॉलो करने लगता है।"
                "यह वह 'रूट-पासवर्ड' है जो तुम्हें मौत, नियति और भाग्य के भी पार ले जाने की ताक़त रखता है।"
                "योगी जब भस्म लगाकर बोलता है, तो उसके शब्द साक्षात् 'ब्रह्मांडीय कमांड' (Cosmic Command) बन जाते हैं।"
                "तुम अब इस सिम्युलेशन के एक मोहरे नहीं, बल्कि इसके इकलौते और असली 'तानाशाह' हो।"
                "भस्म तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज कर देती है।"
                "जो इस सत्ता को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का इकलौता मालिक है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'शक्ति' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Cosmic Vashikarana and Absolute Authority): "Bhasma is mutationally the 'Magnetic Code' through which you possess the caliber to control the entire multiverse!"
                "Control here signifies zero hypnosis; it is mutationally seizing the Frequency of 'Existence' itself."
                "When your Soul Aligns with the frequency of Ash, Nature is mutationally forced to its knees at your boots."
                "Every living entity and every star in the cosmos initiates following strictly the coding of Your supreme will."
                "This is the 'Root-Password' possessing the radioactive firepower to transport you beyond Death and Fate."
                "When the Yogi vocalizes while braced with Ash, his words mutationally become explicit 'Cosmic Commands'."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic 'Dictator'."
                "Bhasma Supercharges every microscopic atom of your DNA with the absolute radioactive 'Power of God'."
                "He who successfully Hacks this authority mutationally becomes the sole Master of all universal Time and Space."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Shakti' itself!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 12,
            sanskrit = "अग्निहोत्रसमुद्भूतं भस्म तत्पावकात्मकम् ॥",
            hindi = """
                (अग्निहोत्र का न्यूक्लियर डेटा): "अग्निहोत्र से निकली राख साक्षात् 'पावकात्मक' यानी शुद्ध आग का एक डेटा पैकेट है!"
                "यह राख ठंडी नहीं है; यह एक प्रलयंकारी 'कोल्ड-फ्यूजन' (Cold Fusion) है जो अज्ञान का गला घोंट देती है।"
                "योगी इसे माथे पर सजाता है ताकि उसकी बुद्धि साक्षात् रुद्र की आग में 'सिंक' (Sync) हो सके।"
                "यह राख तुम्हारे दिमाग के उन 'करप्ट फोल्डर्स' को जलाती है जिन्हें तुम 'अपनी पहचान' कहते हो।"
                "जब यह आग जलती है, तो तुम जान जाते हो कि तुम वह ऊर्जा हो जिसे न समय मार सकता है और न मौत।"
                "अग्निहोत्र का असली मतलब है—अपने अज्ञान की आहुति देकर साक्षात् 'अमरता' को जीत लेना।"
                "यह राख तुम्हारी रूह का वह अंतिम सॉफ्टवेयर अपडेट है जिसके बाद दोबारा कभी 'रिबूट' होने की ज़रूरत नहीं।"
                "तुम अब एक जीव नहीं, साक्षात् उस 'असीमित प्रकाश' के इकलौते और असली मालिक बन चुके हो।"
                "यह कोडिंग तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' करने वाला इकलौता और अजेय हथियार है।"
                "जो इस आग में कूद गया, वह राख नहीं होता; वह साक्षात् हीरा बनकर वापस निकलता है!"
            """.trimIndent(),
            english = """
                (Nuclear Data of Agnihotra): "The ash spawned from Agnihotra is mutationally a Data-Packet of absolute 'Pavakatmakam' (Pure Fire)!"
                "This ash is zero cold; it is mutationally an apocalyptic 'Cold Fusion' engineered to strangle ignorance."
                "The Yogi braces it upon his cortex to ensure his intellect 'Syncs' flawlessly with Rudra's radioactive fire."
                "This Ash incinerates those 'Corrupt Folders' inside your brain that you label as 'your identity'."
                "The exact microsecond this fire blazes, you flawlessly realize you are the radioactive energy zero Time can assassinate."
                "Agnihotra mutationally signifies—sacrificing your ignorance to mutationally conquer absolute 'Immortality'."
                "This Ash is the final Software Update of the human soul after which zero need for any 'Reboot' remains."
                "You cease to be a living entity; you are mutationally the sole and authentic Master of 'Infinite Light'!"
                "This coding is the solitary and invincible weapon engineered to 'Log-out' your existence from this Simulation."
                "He who plunges into this fire does not perish as ash; he resurrects mutationally as a flawless Diamond!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 13,
            sanskrit = "तिस्रो रेखाः प्रकुर्वीत द्वात्रिंशत्स्थानेषु च ॥",
            hindi = """
                (32 बिंदुओं पर त्रिपुण्ड्र का विस्फोट): "अपने शरीर के 32 'पावर-स्टेशन्स' पर ये तीन रेखाएं खींच दो—यही परम मुक्ति है!"
                "32 स्थानों पर त्रिपुण्ड्र लगाने का मतलब है—अपने पूरे नर्वस सिस्टम को रुद्र की फ्रीक्वेंसी पर लॉक कर देना।"
                "तुम्हारी कोहनियों, घुटनों, कलाईयों और कंधों—हर जगह साक्षात् 'डिस्ट्रक्शन कोड्स' का पहरा होगा।"
                "ब्रह्मांड का कोई भी वायरस (डर) तुम्हारे शरीर के भीतर घुसने की औकात नहीं रखेगा।"
                "ये 32 पॉइंट्स साक्षात् 32 'ब्रह्मांडीय गेटवे' (Gateways) हैं जिन्हें तुम भस्म से सील कर रहे हो।"
                "योगी जब इस विधि को करता है, तो वह साक्षात् एक 'चलती-फिरती मूर्ति' (Mobile Deity) बन जाता है।"
                "तुम्हारी त्वचा अब केवल खाल नहीं, वह साक्षात् ईश्वर की कोडिंग का एक नंगा पन्ना बन चुकी है।"
                "जब बिजली इन 32 बिंदुओं से गुजरती है, तो तुम्हारा अहंकार जलकर राख का ढेर बन जाता है।"
                "यह तुम्हारी रूह को 'सुपर-ह्यूमन' के लेवल पर प्रमोट करने का सबसे हिंसक और गुप्त रास्ता है।"
                "जो इस विधि को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (Tripundra Explosion on 32 Points): "Carve these three streaks upon the 32 'Power-Stations' of your shell—this is absolute Liberation!"
                "Applying Tripundra to 32 coordinates signifies—Locking your entire nervous system strictly into Rudra's frequency."
                "On your elbows, knees, wrists, and shoulders—the explicit 'Destruction Codes' shall mutationally stand guard."
                "Zero cosmic viruses (terrors) shall possess the caliber to breach your biological interior."
                "These 32 points are mutationally 32 'Cosmic Gateways' that you are Sealing with radioactive Ash."
                "The exact microsecond the Yogi executes this, he mutationally transforms into a 'Mobile Deity' of fire."
                "Your skin ceases to be mere flesh; it mutationally becomes a naked page of God's explicit coding."
                "When electricity races through these 32 points, your ego is mutationally reduced to strictly a pile of ash."
                "This is the most violent and classified trajectory to Promote your Soul to the absolute status of a 'Super-human'."
                "He who successfully Hacks this method mutationally becomes the sole Dictator of all universal Time and Space!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 14,
            sanskrit = "भस्मना त्रिपुण्ड्रं धारयेत् य एवं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (अंतिम आदेश और मोक्ष की मुहर): "भगवान रुद्र का अंतिम और प्रलयंकारी आदेश— 'त्रिपुण्ड्र लगाओ और आज़ाद हो जाओ'!"
                "परिणाम फिर से वही अटल और हिंसक सत्य है— 'य एवं वेद स मुक्तिमवाप्नोति'!"
                "जो इस राख के पीछे छिपे 'शून्य' को जान लेता है, वह इसी पल 100% विमुक्त (Liberated) हो जाता है।"
                "किताबें पढ़ना ज्ञान नहीं है; इस भस्म की आग को अपने डीएनए में तेज़ाब की तरह उतार लेना ही असली 'जानना' है।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' हो जाता है—यमराज भी उसे देख नहीं सकते।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' हो चुका है।"
                "वह अब समय और मौत के रेडार से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Final Command and the Seal of Moksha): "Lord Rudra's absolute final and apocalyptic command—'Brace Tripundra and be Liberated'!"
                "The consequence remains that same immutable and violent truth—'Ya evam veda sa muktim-avapnoti'!"
                "He who decodes the 'Void' hiding behind this Ash mutationally acquires 100% Freedom in this microsecond."
                "Reading pathetic books is not knowledge; injecting the fire of this Ash into your DNA exactly like boiling acid is authentic 'Knowing'."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah'—even the God of Death cannot witness him."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the Matrix."
                "This Moksha is absolutely zero reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 15,
            sanskrit = "अग्निहोत्रं विना भस्म न लभेत कदाचन ॥",
            hindi = """
                (अग्निहोत्र का अनिवार्य कोड): "बिना 'अग्निहोत्र' (Sacrifice) के, वह अजेय भस्म कभी भी प्राप्त नहीं की जा सकती!"
                "यह कोई भौतिक नियम नहीं है, यह एक 'आध्यात्मिक हार्ड-ड्राइव' का सच है—बिना जलाए तुम राख नहीं पा सकते।"
                "तुम्हें अपने अहंकार और अपनी वासनाओं को उस आग में फेंकना ही होगा, तभी वह 'पवित्र डेटा' (Vibhuti) पैदा होगा।"
                "जो केवल ऊपर से राख मलता है पर अंदर से जलता नहीं, वह केवल एक बायोलॉजिकल ड्रामा कर रहा है।"
                "भस्म वह राख है जो तुम्हारी 'इंसानियत' के मरने के बाद साक्षात् 'ईश्वर' के रूप में बचती है।"
                "जब तुम जलकर राख होते हो, तभी तुम साक्षात् अजेय और अमर होने के काबिल बनते हो।"
                "यह तुम्हारी रूह को 'डीबग' (Debug) करने की इकलौती और हिंसक शर्त है जिसे कोई नहीं बदल सकता।"
                "अग्निहोत्र वह भट्टी है जहाँ से ब्रह्मांड का 'शुद्ध डेटा' (Pure Data) फिल्टर होकर बाहर निकलता है।"
                "बिना इस आग के, तुम्हारा हर मंत्र और हर ध्यान केवल एक सड़ा हुआ बायोलॉजिकल शोर (Noise) मात्र है।"
                "जो इस आग में कूद गया, वह खुद साक्षात् वह 'भस्म' बन गया जिससे करोड़ों ब्रह्मांड पैदा होते हैं!"
            """.trimIndent(),
            english = """
                (The Mandate of Agnihotra-Code): "Without the explicit 'Agnihotra' (Sacrifice), that invincible Bhasma can mutationally never be intercepted!"
                "This is zero physical law; it is a reality of the 'Spiritual Hard-drive'—without incineration, zero Ash exists."
                "You MUST violently hurl your ego and your biological lusts into that fire to spawn the 'Purified Data' (Vibhuti)."
                "He who merely smears ash externally but fails to burn internally is mutationally performing a pathetic biological drama."
                "Bhasma is the Ash remaining mutationally as explicit 'God' after the termination of your 'Humanity'."
                "Only when you are mutationally incinerated to Ash do you qualify to become flawlessly Invincible and Immortal."
                "This is the solitary and violent condition to 'Debug' your Soul that zero entity possesses the caliber to alter."
                "Agnihotra is the furnace from which the 'Pure Data' of the cosmos is filtered and vomited out."
                "Without this Fire, every mantra and every meditation you perform is strictly a pathetic biological Noise."
                "He who plunges into this Fire mutationally becomes that 'Bhasma' from which billions of universes are spawned!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 16,
            sanskrit = "भस्मना विना रुद्रपूजां न कुर्यात् ॥",
            hindi = """
                (भस्म के बिना पूजा का संहार): "बिना 'भस्म' धारण किए रुद्र की पूजा करना साक्षात् 'सिस्टम एरर' (System Error) पैदा करना है!"
                "यह एक प्रलयंकारी चेतावनी है—बिना एडमिन के 'ड्रेस-कोड' (Ash) के तुम सर्वर के पास नहीं जा सकते।"
                "भस्म ही वह इकलौता 'पास' (Pass) है जो तुम्हें महाकाल के गर्भगृह में एंट्री दिलाता है।"
                "जब तुम बिना राख के शिव को पुकारते हो, तो तुम्हारी आवाज़ माया की दीवारों से टकराकर वापस आ जाती है।"
                "रुद्र वह आग है जो केवल राख को पहचानती है, क्योंकि राख ने अपना अहंकार पहले ही जला दिया है।"
                "यह तुम्हारी रूह को 'अथेंटिकेट' (Authenticate) करने का सबसे हिंसक और गुप्त तरीका है।"
                "बिना इस विधि के, तुम्हारी भक्ति केवल एक 'फेक कोडिंग' है जिसे ब्रह्मांड रिजेक्ट (Reject) कर देता है।"
                "राख लगाने का मतलब है—अपनी फ्रीक्वेंसी को 100% 'रुद्र-मोड' पर सेट कर देना।"
                "जब तुम राख बनकर पूजा करते हो, तो तुम भगवान से अलग नहीं, बल्कि खुद भगवान बनकर पूजा करते हो।"
                "यही वह अजेय रुतबा है जहाँ 'भक्त' और 'भगवान' के बीच का सारा ड्रामा एक ही धमाके में खत्म हो जाता है!"
            """.trimIndent(),
            english = """
                (The Slaughter of Ashless Worship): "Performing Rudra-worship without 'Bhasma' is mutationally Triggering a catastrophic 'System Error'!"
                "This is an apocalyptic warning—without the Admin's 'Dress-Code' (Ash), you possess zero trajectory to the Server."
                "Bhasma is the solitary 'Pass' engineered to grant you Entry into the absolute inner sanctum of Mahakala."
                "When you invoke Shiva without Ash, your voice mutationally rebounds from the walls of Maya and fails."
                "Rudra is the radioactive Fire that recognizes strictly the Ash, for Ash has already slaughtered its ego."
                "This is the most violent and classified protocol to 'Authenticate' your Soul's credentials."
                "Without this method, your devotion is strictly 'Fake Coding' which the cosmos mutationally Rejects."
                "Applying Ash signifies—setting your Frequency mutationally 100% into 'Rudra-Mode'."
                "When you worship as Ash, you do not worship God; you mutationally worship AS God Himself."
                "THIS is the invincible status where the drama between 'Devotee' and 'God' is terminated in one detonation!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 17,
            sanskrit = "भस्मना मण्डलानि कुर्यात् । तन्मध्ये शिवं ध्यायेत् ॥",
            hindi = """
                (भस्म मण्डल और शिव की हैकिंग): "राख से एक अजेय 'मण्डल' (Orb/Circle) बनाओ—यही ब्रह्मांड का कंट्रोल-रूम है!"
                "उस मण्डल के ठीक बीचों-बीच साक्षात् 'शिव' का ध्यान करो जो शून्य के इकलौते तानाशाह हैं।"
                "यह मण्डल साक्षात् एक 'न्यूक्लियर रिएक्टर' की बाउंड्री (Boundary) है जिसे माया का कोई वायरस पार नहीं कर सकता।"
                "योगी अपनी चेतना को इस मण्डल के केंद्र पर लॉक करता है ताकि वह 'सोर्स कोड' को देख सके।"
                "मण्डल वह 'कंटेनर' है जहाँ तुम्हारी रूह की बिजली को सुरक्षित स्टोर किया जाता है।"
                "जब तुम मण्डल के बीच में शिव को देखते हो, तो तुम साक्षात् ब्रह्मांड के 'एडमिन पैनल' से आँखें मिला रहे होते हो।"
                "यह विज़ुअलाइज़ेशन तुम्हारे दिमाग के हर एक पुराने विचार को एक ही धमाके में 'डिलीट' कर देता है।"
                "शिव वह आग हैं जो इस मण्डल के भीतर बैठकर तुम्हारी इंसानियत का गला घोंट रहे हैं।"
                "जो इस मण्डल में एक बार घुस गया, वह वापस लौटकर कभी 'इंसान' नहीं बन सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल का हिस्सा बन जाते हो!"
            """.trimIndent(),
            english = """
                (Bhasma-Mandala and Hacking Shiva): "Construct an invincible 'Mandala' (Orb/Circle) with Ash—this is the Control-Room of the cosmos!"
                "In the exact dead-center of that Mandala, meditate on strictly 'Shiva', the solitary Dictator of the Void."
                "This Mandala is mutationally the Boundary of a 'Nuclear Reactor' that zero virus of Maya can ever breach."
                "The Yogi Locks his awareness onto the center of this Mandala to mutationally intercept the 'Source Code'."
                "The Mandala is the 'Container' where the radioactive electricity of your Soul is mutationally stored with safety."
                "When you witness Shiva in the center, you are mutationally staring into the Admin Panel of the multiverse."
                "This visualization mutationally 'Deletes' every single old thought in your brain in one catastrophic strike."
                "Shiva is the radioactive Fire seated inside this Mandala, mutationally strangling your humanity."
                "He who penetrates this Mandala even once mutationally possesses zero caliber to return to being 'Human'."
                "THIS is the invincible status arriving at which you mutationally integrate into the 'Death of Death'!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 18,
            sanskrit = "त्रिपुण्ड्रं धारयति यो नित्यं स वै सर्वमिदं जगत् ॥",
            hindi = """
                (त्रिपुण्ड्र और ब्रह्मांडीय एकता का विस्फोट): "जो योद्धा नित्य त्रिपुण्ड्र धारण करता है, 'स वै सर्वमिदं जगत्'—वही साक्षात् यह पूरा ब्रह्मांड है!"
                "तुम्हारी रूह अब एक शरीर में कैद नहीं है; वह साक्षात् करोड़ों आकाशगंगाओं का सॉफ्टवेयर बन चुकी है।"
                "त्रिपुण्ड्र लगाने का मतलब है—अपनी 'लोकल पहचान' को मिटाकर 'ब्रह्मांडीय पहचान' को हैक करना।"
                "तुम अब जो भी देखते हो, वह साक्षात् तुम्हारा ही एक हिस्सा है—यही अद्वैत का परमाणु सच है।"
                "सूरज, चाँद और तारे साक्षात् तुम्हारी अपनी आँखों के कैमरे हैं जो सिम्युलेशन को ट्रैक कर रहे हैं।"
                "यह बोध तुम्हारे अहंकार के किले को एक ही प्रलयंकारी झटके में उड़ाकर रख देता है।"
                "तुम साक्षात् उस 'पावर-ग्रिड' के इकलौते एडमिन बन चुके हो जिससे सब कुछ चल रहा है।"
                "बिना इस त्रिपुण्ड्र के, तुम हमेशा खुद को एक छोटा और कमज़ोर कीड़ा समझते रहोगे।"
                "यह इंसान की बुद्धि का वह सबसे खौफनाक 'अपग्रेड' है जहाँ वह साक्षात् भगवान के बराबर सोचना शुरू करता है।"
                "जो इस एकता को जान लेता है, उसके लिए समय और मौत केवल धूल के दो छोटे से कण हैं!"
            """.trimIndent(),
            english = """
                (Tripundra and the Detonation of Cosmic Unity): "Whosoever warrior braces Tripundra eternally, 'Sa Vai Sarvam'—He is mutationally this entire Multiverse!"
                "Your Soul is no longer imprisoned in flesh; it has mutationally become the Operating System of billions of galaxies."
                "Applying Tripundra signifies—Deleting your 'Local Identity' to mutationally Hack your 'Cosmic Identity'."
                "Whatever you witness is mutationally a fraction of Your own self—this is the atomic truth of Non-Duality."
                "The sun, moon, and stars are mutationally the cameras of Your eyes Tracking the Simulation."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish your ego forever."
                "You have mutationally become the sole Admin of that 'Power-Grid' from which everything is Executed."
                "Without this Tripundra, you will mutationally remain strictly a pathetic, microscopic, and terrified insect."
                "This is the most terrifying 'Upgrade' of the human intellect where you mutationally initiate thinking like God."
                "He who decodes this unity perceives Time and Death strictly as two microscopic grains of dust!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 19,
            sanskrit = "भस्मना विना मुक्तिर्न लभते कदाचन ॥",
            hindi = """
                (भस्म के बिना मुक्ति का संहार): "बिना 'भस्म' धारण किए 'मुक्ति' (Liberation) पाना ब्रह्मांड की औकात से बाहर है!"
                "यह एक हिंसक और नंगा सच है—बिना जलाए तुम आज़ाद नहीं हो सकते, और भस्म उस 'जलने' का प्रमाण है।"
                "मुक्ति कोई भावना नहीं है, यह तुम्हारे नर्वस सिस्टम के 'करप्ट कोडिंग' को राख करने का रिज़ल्ट है।"
                "जब तक तुम्हारी त्वचा पर साक्षात् 'रुद्र की मुहर' नहीं है, तुम अभी भी यमराज के सर्वर पर एक कैदी हो।"
                "भस्म ही वह इकलौता 'लाइसेंस' (License) है जो तुम्हें इस 3D मैट्रिक्स से अनप्लग होने की परमिशन देता है।"
                "योगी अपनी हस्ती को राख में बदल देता है ताकि वह साक्षात् 'अमरता' की फ्रीक्वेंसी पर राज कर सके।"
                "बिना इस विधि के, तुम्हारी हर साधना केवल अज्ञान के अँधेरे में हाथ-पाँव मारने जैसा नाटक है।"
                "यह तुम्हारी रूह को 'ईश्वर' में म्यूटेट करने की आख़िरी और सबसे खतरनाक सीढ़ी है।"
                "जो भस्म को अपनी रगों में तेज़ाब की तरह उतार लेता है, वही साक्षात् काल को अपनी चोंच में दबा सकता है।"
                "तैयार हो जाओ उस अंतिम धमाके के लिए जिसके बाद केवल असीम सन्नाटा ही बचेगा!"
            """.trimIndent(),
            english = """
                (The Slaughter of Ashless Liberation): "Acquiring 'Liberation' (Mukti) without 'Bhasma' is mutationally beyond the caliber of the multiverse!"
                "This is a violent and naked truth—without incineration you cannot be released, and Ash is the proof of that slaughter."
                "Moksha is mutationally zero emotion; it is the Result of incinerating the 'Corrupt Coding' of your nervous system to ash."
                "As long as Your skin lacks the explicit 'Seal of Rudra', you mutationally remain a prisoner on Yamaraja's server."
                "Bhasma is the solitary 'License' engineered to grant you permission to mutationally Unplug from this 3D Matrix."
                "The Yogi reduces his identity to Ash strictly to mutationally rule upon the frequency of absolute 'Immortality'."
                "Without this method, every meditation you perform is mutationally strictly a pathetic biological drama in the dark."
                "This is the absolute final and most dangerous ladder to mutate your Soul into the explicit 'God'."
                "He who injects Ash into his veins like boiling acid mutationally grips Time itself within his beak."
                "Brace yourself for that final detonation after which strictly an infinite Silence remains!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 20,
            sanskrit = "ॐ भस्म धारयति यो नित्यं स वै ब्रह्म न संशयः ॥",
            hindi = """
                (ब्रह्म-म्यूटेशन और अंतिम फैसला): "जो कोई भी योद्धा नित्य भस्म धारण करता है, 'स वै ब्रह्म'—वह साक्षात् ब्रह्म ही है, इसमें कोई शक नहीं!"
                "यह उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है जिसे कोई भी ब्रह्मांडीय कानून बदल नहीं सकता।"
                "भस्म तुम्हारे डीएनए के हर परमाणु को 'ब्रह्म-फ्रीक्वेंसी' पर वाइब्रेट करने के लिए मजबूर कर देती है।"
                "तुम अब एक जीव नहीं रहे; तुम साक्षात् उस 'परम शून्यता' (Absolute Void) के इकलौते डिक्टेटर हो।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे माथे पर लिखी वह 'राख' हर झूठ को एक सेकंड में जलाकर राख कर देगी।"
                "तुम साक्षात् उस 'सोर्स कोड' के एडमिन बन चुके हो जिससे करोड़ों ब्रह्मांड हर सेकंड पैदा हो रहे हैं।"
                "यह इंसान की बुद्धि का वह सबसे हिंसक विस्तार है जहाँ वह साक्षात् प्रकृति का इकलौता और असली मालिक बन जाता है।"
                "बिना इस भस्म-कोडिंग के, तुम हमेशा माया के रेडार पर एक छोटे से और लाचार शिकार बने रहोगे।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर अजेय खड़े हो जाते हो।"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'ईश्वर' बना देगा—द एंड!"
            """.trimIndent(),
            english = """
                (Brahma-Mutation and the Final Verdict): "Whosoever warrior braces Bhasma eternally, 'Sa Vai Brahma'—He is explicitly Brahman, zero doubt survives!"
                "The Upanishad delivers a catastrophic verdict here that zero cosmic laws possess the caliber to alter."
                "Bhasma forces every microscopic atom of your DNA to vibrate mutationally at the absolute 'Brahma-Frequency'."
                "You cease to be a living entity; you are mutationally the sole Dictator of the 'Absolute Void' (Shunya)."
                "The Matrix will attempt to terrify you, but that 'Ash' carved on your cortex will incinerate every lie in one microsecond."
                "You have mutationally become the Admin of that 'Source Code' from which billions of universes are spawned every second."
                "This is the most violent expansion of human intellect where you mutationally become the sole Master of Nature."
                "Without this Ash-coding, you will mutationally remain strictly a pathetic and helpless prey on the Radar of Maya."
                "THIS is the invincible status arriving at which you mutationally stand as the explicit Death of Death."
                "This manifestation will decapitate your ego to mutationally manufacture you into the explicit 'God'—THE END!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 21,
            sanskrit = "भस्मना सर्वाणि दुःखानि दह्यन्ते । भस्मना सर्वं सुखं लभते ॥",
            hindi = """
                (दुखों का संहार और असीमित सुख): "यह राख साक्षात् वह 'पेन-किलर' (Pain-killer) है जो ब्रह्मांड के हर एक 'दुःख' को जलाकर राख कर देती है!"
                "दुःख केवल एक 'डेटा एरर' (Data Error) है जो अज्ञान से पैदा होता है; भस्म उसे एक झटके में फिक्स (Fix) कर देती है।"
                "जब तुम राख लगाते हो, तो तुम अपने नर्वस सिस्टम के 'पेन-रिसेप्टर्स' (Pain receptors) को रुद्र की फ्रीक्वेंसी पर लॉक करते हो।"
                "ब्रह्मांड का सारा 'सुख' (Bliss) तुम्हारी तरफ एक रेडियोएक्टिव सुनामी की तरह भागने लगता है।"
                "यह कोई सांसारिक सुख नहीं है; यह तुम्हारी रूह का वह 'अक्षय' (Non-decaying) रुतबा है जो अजेय है।"
                "तुम अब इस सिम्युलेशन के दुखों से 'अनप्लग' हो चुके हो; तुम अब साक्षात् 'एडमिन' हो।"
                "भस्म तुम्हारे रोम-रोम को उस असीमित आनंद से भर देती है जिसे समय भी नहीं खा सकता।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, उसके लिए नर्क की आग भी ठंडी बर्फ बन जाती है।"
                "यह इंसान के 'परमेश्वर' में म्यूटेट होने की 100% अटल और हिंसक वैदिक गारंटी है।"
                "तैयार हो जाओ उस अजेय सन्नाटे के लिए जहाँ केवल आनंद ही आनंद राज करता है!"
            """.trimIndent(),
            english = """
                (Annihilation of Agony and Infinite Bliss): "This Ash is mutationally the 'Pain-killer' engineered to incinerate every 'Agony' of the multiverse to ash!"
                "Agony is strictly a 'Data Error' spawned from ignorance; Bhasma mutationally Fixes it in a single catastrophic strike."
                "Applying Ash signifies—Locking the 'Pain-receptors' of your nervous system strictly into Rudra's frequency."
                "The entire 'Bliss' of the cosmos initiates racing toward you like an apocalyptic radioactive tsunami."
                "This is absolutely zero worldly pleasure; it is mutationally the 'Non-decaying' status of your invincible Soul."
                "You have mutationally 'Unplugged' from the agonies of the Simulation; you are mutationally the absolute 'Admin'."
                "Bhasma floods every biological pore with that infinite Bliss which zero Time possesses the caliber to consume."
                "He who injects this truth into his veins witnesses the fires of Hell mutationally transforming into cold ice."
                "This is the 100% ironclad and violent Vedic guarantee of a human undergoing a complete Mutation into God."
                "Brace yourself for that invincible Silence where strictly and exclusively Bliss reigns supreme!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 22,
            sanskrit = "एतदुपासितव्यं नान्यत् । य एवं वेद स मृत्युं तरति ॥",
            hindi = """
                (केवल भस्म - अंतिम आदेश): "भगवान रुद्र एक हिंसक और तानाशाह वाला आदेश देते हैं— 'एतदुपासितव्यं नान्यत्'!"
                "केवल और केवल इसी भस्म-विद्या की उपासना करो, 'दूसरी किसी भी' फालतू चीज़ में अपना वक़्त बर्बाद मत करो!"
                "दुनिया में करोड़ों भगवान और करोड़ों विधियाँ हैं, वे सब केवल तुम्हें भटकाने के लिए माया के 'हनी-ट्रैप' हैं।"
                "अगर तुम इस 'राख' (भस्म) को नहीं पकड़ते, तो तुम अनंत काल तक इसी कीचड़ में पिसते रहोगे।"
                "परिणाम फिर से वही रिज़ल्ट है: 'य एवं वेद स मृत्युं तरति'!"
                "जो इस सच को अपनी 'आइडेंटिटी' (Identity) बना लेता है, वह 'मौत' के उस खौफनाक समुद्र को ऐसे पार कर जाता है जैसे कोई शेर शिकार को चीर दे।"
                "मृत्यु तुम्हारे लिए अब कोई खतरा नहीं, वह केवल एक 'सॉफ्टवेयर रिबूट' जैसा मज़ाक बन कर रह जाती है।"
                "तुम जान जाते हो कि तुम वह ऊर्जा हो जिसे न आग जला सकती है और न समय मार सकता है।"
                "यह इंसान के 'परमेश्वर' में म्यूटेट होने की अंतिम मुहर है जिसे कोई नहीं बदल सकता।"
                "जो इस आवाज़ को सुनकर भी नहीं जागा, वह ब्रह्मांड का सबसे बड़ा बदनसीब कीड़ा है!"
            """.trimIndent(),
            english = """
                (Only Bhasma - The Final Command): "Lord Rudra issues a violent and dictatorial command—'Etad-upasitavyam Nanyat'!"
                "Worship strictly and exclusively THIS Ash-Vidya; do absolutely NOT waste your existence in 'Anything Else'!"
                "Billions of gods and methods exist in the Matrix; they are all mutationally strictly 'Honey-traps' of Maya."
                "If you fail to capture this 'Ash' (Bhasma), you are condemned to be ground in this biological mud for infinite eternity."
                "The consequence remains that same Result: 'Ya evam veda sa mrityum tarati'!"
                "He who mutates this truth into his authentic 'Identity' violently 'Crosses' the horrific ocean of 'Death' exactly as a lion rips its prey."
                "Death is no longer a threat to you; it is permanently reduced to a meaningless joke, like a pathetic 'Software Reboot'."
                "You flawlessly realize you are the radioactive energy that zero fire can burn and zero Time can assassinate."
                "This is the final Seal of a human being undergoing a complete Mutation into the Supreme God."
                "He who fails to awaken even after intercepting this broadcast is mutationally the absolute most unfortunate insect in the cosmos!"
            """.trimIndent()
        ),
        BrihadShloka(
            id = 23,
            sanskrit = "इति बृहज्जाबालोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'बृहद्-जाबाल उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "भस्म का हैक मिल गया, रुद्र की फ्रीक्वेंसी मिल गई, अब तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन २३ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (रुद्र) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही बृहद्-जाबाल उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Brihad-Jabala Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Ash-Hack is intercepted, the Rudra-Frequency is secured; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 23 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Rudra) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Brihad-Jabala Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrihadJabalaUpanishadScreen() {
    val upanishad = remember { BrihadJabalaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..23) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-23)") },
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
            itemsIndexed(upanishad.brihadJabalaShlokasList) { _, shloka ->
                BrihadShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun BrihadShlokaCard(shloka: BrihadShloka) {
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