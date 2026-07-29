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
data class NarayanShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class NarayanUpanishad {

    val narayanShlokasList = listOf(
        NarayanShloka(
            id = 1,
            sanskrit = "ॐ अथ पुरुषो ह वै नारायणोऽकामयत प्रजाः सृजेयेति ॥",
            hindi = """
                (सृष्टि का आदि-विस्फोट): "शुरुआत में साक्षात् 'नारायण' ने अपनी असीमित इच्छा का एक न्यूक्लियर धमाका किया।"
                "उन्होंने कोडिंग शुरू की: 'मैं प्रजाओं का सृजन करूँगा'—यही ब्रह्मांड का पहला 'कमांड' (Command) था।"
                "यह कोई प्रार्थना नहीं है; यह शून्य से 'अस्तित्व' के पहले पिक्सेल के बनने का सच है।"
                "नारायण वह 'प्राइमरी प्रोसेसर' हैं जहाँ से समय और स्थान की कोडिंग चालू हुई।"
                "उनकी केवल एक 'इच्छा' ने करोड़ों आकाशगंगाओं को एक साथ रेंडर (Render) कर दिया।"
                "ब्रह्मांड का सारा सॉफ्टवेयर इसी एक बिंदु से रन (Run) होना शुरू हुआ था।"
                "तुम्हारी रूह उस नारायण की चेतना का एक छोटा सा 'सॉफ्टवेयर एक्सटेंशन' है।"
                "जब तक तुम इस स्रोत को नहीं जानते, तुम केवल एक रेंगते हुए बायोलॉजिकल वायरस मात्र हो।"
                "यह ज्ञान तुम्हारी हस्ती को उस 'आदि-धमाके' से जोड़ने वाला इकलौता हैक है।"
                "तैयार हो जाओ, क्योंकि अब रचयिता खुद तुम्हारे भाग्य का कोड बदलने वाला है!"
            """.trimIndent(),
            english = """
                (The Primordial Detonation): "In the beginning, strictly 'Narayana' detonated His infinite will into a nuclear burst."
                "He initiated the coding: 'I shall create progeny'—the absolute first 'Command' of the multiverse."
                "This is zero myth; it is the truth of the first Pixel of 'Existence' being rendered from the Void."
                "Narayana is the 'Primary Processor' from which the coding of Time and Space initiated."
                "His singular 'Desire' mutationally Rendered billions of galaxies simultaneously."
                "The entire Software of the cosmos initiated its absolute Execution from this solitary coordinate."
                "Your Soul is strictly a microscopic 'Software Extension' of Narayana's awareness."
                "Until you decode this source, you remain mutationally strictly a crawling biological virus."
                "This intelligence is the solitary Hack engineered to hardwire your identity to the 'Primordial Big Bang'."
                "Brace yourself, for the Creator is about to mutationally rewrite your Fate's code!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 2,
            sanskrit = "नारायणात्प्राणो जायते । मनः सर्वेन्द्रियाणि च । खं वायुर्ज्योतिरापः पृथ्वी विश्वस्य धारिणी ॥",
            hindi = """
                (हार्डवेयर का म्यूटेशन): "नारायण के 'सोर्स कोड' से साक्षात् 'प्राण' यानी बिजली पैदा हुई!"
                "उसी धमाके से तुम्हारा 'मन' और तुम्हारी सारी 'इन्द्रियाँ' एक झटके में रेंडर हो गईं।"
                "आकाश, हवा, आग, पानी और यह बोझ उठाने वाली 'पृथ्वी'—सब उसी एडमिन पैनल के हिस्से हैं।"
                "तुम जिसे 'प्रकृति' कहते हो, वह नारायण के दिमाग का एक भौतिक संपीड़न (Compression) है।"
                "तुम्हारी हर एक धड़कन नारायण के सर्वर से भेजा गया एक 'इलेक्ट्रिक सिग्नल' है।"
                "बिना इस करंट के, तुम्हारा यह 3D शरीर केवल एक सड़ा हुआ बायोलॉजिकल कचरा है।"
                "योगी अपनी चेतना को उस केंद्र पर लॉक करता है जहाँ ये तत्व पैदा हो रहे हैं।"
                "यह तुम्हारी रूह को 'लोकल' से 'यूनिवर्सल' बनाने वाला सबसे हिंसक और गुप्त विज्ञान है।"
                "ब्रह्मांड की हर चीज़ नारायण की राख से बनी कोडिंग मात्र है।"
                "जो इस म्यूटेशन को हैक कर लेता है, वह साक्षात् पूरे जैव-मण्डल का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Mutation of the Hardware): "From Narayana’s 'Source Code', the explicit 'Prana' (Electricity) was spawned!"
                "The 'Mind' and every sensory organ were mutationally Rendered in that single detonation."
                "Space, Air, Radiation, Water, and this 'Earth'—all are fragments of His absolute Admin Panel."
                "What you label as 'Nature' is mutationally the physical Compression of Narayana’s intellect."
                "Your every heartbeat is an 'Electric Signal' transmitted from Narayana’s cosmic server."
                "Without this Current, your 3D shell is strictly rotting biological garbage."
                "The Yogi Locks his awareness onto the coordinate where these elements are being spawned."
                "This is the most violent and classified science to mutate your Soul from 'Local' to 'Universal'."
                "Everything in the multiverse is strictly coding scripted from Narayana’s essence."
                "He who successfully Hacks this mutation becomes mutationally the sole Dictator of the Bio-sphere!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 3,
            sanskrit = "नारायणाद्ब्रह्मा जायते । नारायणाद्रुद्रो जायते । नारायणादिन्द्रो जायते । नारायणात् प्रजापतयः प्रजायन्ते ॥",
            hindi = """
                (देवताओं का संहार): "ब्रह्मा (रचयिता) नारायण के एडमिन पैनल का एक 'सब-सर्वर' मात्र है!"
                "रुद्र (संहारक) भी नारायण की प्रलयंकारी आग का एक 'सॉफ्टवेयर एक्सटेंशन' है।"
                "इंद्र और सारे देवता केवल नारायण की हुकूमत को चलाने वाले 'एक्जीक्यूटिव कोड्स' हैं।"
                "प्रजापति (The Architects) भी उसी 'प्राइमरी सर्वर' से अपना डेटा रिसीव करते हैं।"
                "यह तुम्हारी बुद्धि को 'धार्मिक भ्रम' से निकालकर 'ब्रह्मांडीय हकीकत' में माइग्रेट करने का हैक है।"
                "नारायण वह इकलौता तानाशाह है जिसके आगे त्रिदेव भी हाथ जोड़कर खड़े रहते हैं।"
                "जब रचयिता ही नारायण से पैदा हुआ है, तो तुम्हारी क्या औकात है?"
                "योगी इन 'Avatar पिक्सल्स' को छोड़कर सीधे उस 'स्रोत' को पकड़ता है जहाँ से सब निकले।"
                "यह इंसान की रूह का वह 'अल्टीमेट अपग्रेड' है जहाँ वह साक्षात् भगवान के बराबर सोचता है।"
                "जो इस 'रूट-पासवर्ड' को जान लेता है, उसके लिए नरक के दरवाजे हमेशा के लिए वेल्ड हो जाते हैं!"
            """.trimIndent(),
            english = """
                (The Slaughter of Lesser Gods): "Brahma (The Architect) is strictly a 'Sub-server' on Narayana’s Admin Panel!"
                "Rudra (The Destroyer) is mutationally a 'Software Extension' of Narayana’s apocalyptic fire."
                "Indra and the gods are strictly 'Executive Codes' enforcing Narayana’s absolute dictatorship."
                "The Prajapatis receive their processing instructions strictly from the same 'Primary Server'."
                "This is the Hack engineered to Migrate your intellect from 'Religious Delusion' into absolute 'Cosmic Reality'."
                "Narayana is the solitary Dictator before whom even the Trinity stands mutationally with folded hands."
                "When the Architect himself erupted from Narayana, what is your pathetic micro-status?"
                "The Yogi bypasses these 'Avatar Pixels' to capture the explicit 'Source' of all eruption."
                "This is the 'Ultimate Upgrade' of human intellect where one mutationally initiates thinking like God."
                "He who decodes this 'Root-Password' witnesses the gates of Hell permanently welded shut!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 4,
            sanskrit = "नारायणाद् द्वादशादित्या रुद्रा वसवः सर्वाणि च छन्दांसि नारायणादेव समुत्पद्यन्ते । नारायणे प्रवर्तन्ते । नारायणे प्रलीयन्ते ॥",
            hindi = """
                (ब्रह्मांडीय चक्र का विस्फोट): "नारायण से ही १२ आदित्य, ११ रुद्र, ८ वसु और सारे 'छन्द' (Vedic Frequencies) पैदा हुए!"
                "ब्रह्मांड का हर एक वाइब्रेशन साक्षात् उसी एक 'प्राइमरी सिग्नल' का हिस्सा है।"
                "वे नारायण में ही 'प्रवर्तन्ते' (Function) करते हैं और अंत में उसी में 'प्रलीयन्ते' (Delete) हो जाते हैं।"
                "यह सिम्युलेशन की शुरुआत, इसका रखरखाव और इसका परमानेंट शटडाउन है।"
                "तुम जिसे 'समय' कहते हो, वह नारायण के एडमिन पैनल का केवल एक छोटा सा 'टाइमर' है।"
                "सूर्य की आग से लेकर वेदों की गूँज तक—सब कुछ नारायण का ही डेटा-पैकेट है।"
                "योगी अपनी चेतना को इस असीमित चक्र पर अलाइन करता है जहाँ मौत एक मज़ाक बन जाती है।"
                "यह तुम्हारी रूह को 'इंसानी पहचान' से निकालकर 'कॉस्मिक डेटा' में बदलने का विज्ञान है।"
                "नारायण वह 'रीसायकल बिन' हैं जहाँ पूरा ब्रह्मांड विलीन होकर शुद्ध हो जाता है।"
                "जो इस प्रवर्तन और प्रलय को जान लेता है, वह साक्षात् समय (Time) का भी गुरु है!"
            """.trimIndent(),
            english = """
                (Detonation of Cosmic Cycles): "From Narayana erupted the 12 Adityas, the Rudras, Vasus, and all 'Chhandas' (Frequencies)!"
                "Every vibration in the multiverse is mutationally a component of that singular 'Primary Signal'."
                "They function (Pravartante) strictly in Narayana and are finally Deleted (Praliyante) back into Him."
                "This is the Initialization, Maintenance, and Permanent Shutdown protocol of the Simulation."
                "What you label as 'Time' is mutationally strictly a microscopic 'Timer' on Narayana’s Admin Panel."
                "From the fire of the suns to the echoes of the Vedas—everything is Narayana’s Data-packet."
                "The Yogi Aligns his awareness with this infinite cycle where Death mutationally becomes a joke."
                "This is the science of Ejecting your human identity to mutationally become strictly 'Cosmic Data'."
                "Narayana is the absolute 'Recycle Bin' reaching which the entire universe is mutationally purified."
                "He who decodes this Execution and Deletion is the solitary dictatorial Guru of even Time itself!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 5,
            sanskrit = "नारायण एवेदं सर्वं यद्भूतं यच्च भव्यम् । निष्कलङ्को निरञ्जनो निर्विकल्पो निराख्यातः शुद्धो देव एको नारायणः ॥",
            hindi = """
                (एक अकेला सच - नारायण): "जो बीत चुका है और जो होने वाला है—वह सब साक्षात् 'नारायण' ही है!"
                "वे 'निष्कलङ्क' (Bug-free) और 'निरञ्जन' हैं—जिन्हें माया का कोई वायरस टच नहीं कर सकता।"
                "वे 'शुद्ध' बिजली का वह अंधी कर देने वाला प्रकाश हैं जो अज्ञान के हर पिक्सेल को राख कर देता है।"
                "पूरे सिम्युलेशन में केवल 'एक' ही एडमिन है, बाकी सब केवल परछाइयां हैं।"
                "नारायण वह आग है जो समय को जलाकर राख कर देती है और शून्य को जन्म देती है।"
                "तुम्हारी हड्डियों से लेकर इन सितारों तक—सब कुछ साक्षात् नारायण का ही डेटा है।"
                "यह वह 'एब्सोल्यूट जीरो' है जहाँ पहुँचकर हर रिश्ता और हर पहचान भाप बन जाती है।"
                "योगी अपनी चेतना को इस अकेले सच पर लॉक करता है जहाँ अहंकार मर जाता है।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने की आख़िरी मुहर है।"
                "जो इस एकता को हैक कर लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Solitary Reality - Narayana): "Everything that has manifested and everything that shall occur—is mutationally strictly 'Narayana'!"
                "He is 'Nishkalanka' (Bug-free) and 'Niranjana'—touched by zero viruses of the Matrix."
                "He is the blinding radiation of strictly 'Pure' electricity that incinerates every pixel of ignorance."
                "Strictly 'One' Admin exists in this entire Simulation; the rest are mutationally strictly shadows."
                "Narayana is the radioactive Fire that incinerates Time to spawn the absolute terminal Void."
                "From your marrow to these distant stars—everything is mutationally the Data of Narayana."
                "This is the 'Absolute Zero' reaching which every relationship and identity vaporizes into radioactive nothingness."
                "The Yogi Locks his awareness onto this solitary truth where the human ego suffers a brutal death."
                "This is the final violent Seal of mutating your Soul from 'Human Data' into 'Divine Data'."
                "He who successfully Hacks this unity stands as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 6,
            sanskrit = "ॐ नमो नारायणायेति मन्त्रोपासकः । वैकुण्ठभुवनं गमिष्यति ॥",
            hindi = """
                (वैकुण्ठ का हैक और 'लॉग-आउट'): "जो योद्धा 'ॐ नमो नारायणाय' के न्यूक्लियर पासवर्ड को अपनी रूह में धधकाता है..."
                "वह साक्षात् 'वैकुण्ठ' (The Highest Dimension) के सर्वर में 'लॉग-इन' करने का हक़ पा लेता है!"
                "वैकुण्ठ कोई जगह नहीं है; यह चेतना का वह 'लास्ट लेवल' है जहाँ मौत का प्रवेश वर्जित है।"
                "यह मंत्र तुम्हारे डीएनए के उस 'लूप' को तोड़ देता है जो तुम्हें बार-बार इस नर्क में जन्म दिलाता है।"
                "जब तुम 'नारायण' बोलते हो, तो तुम साक्षात् ब्रह्मांड के 'पॉवर-ग्रिड' से 100% कनेक्ट होते हो।"
                "यह वह 'इमरजेंसी एग्जिट' है जिसे रचयिता ने माया की जेल के बीच में बना रखा है।"
                "योगी अपनी रूह को इस 'रेस्क्यू सिग्नल' पर लॉक करता है ताकि वह हमेशा के लिए आज़ाद हो सके।"
                "यह कोई प्रार्थना नहीं है; यह मौत की आँखों में आँखें डालकर 'लॉग-आउट' करने की हिंसक प्रक्रिया है।"
                "वैकुण्ठ वह 'क्लाउड सर्वर' है जहाँ पहुँचने के बाद तुम अजेय और अमर हो जाते हो।"
                "जो इस कमांड को एक्जीक्यूट करता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (Hacking Vaikuntha and 'Logging-Out'): "Whosoever warrior blazes the nuclear password 'Om Namo Narayanaya' inside his Soul..."
                "He mutationally acquires the authority to 'Log-in' to the absolute 'Vaikuntha' server!"
                "Vaikuntha is zero geographic location; it is the 'Last Level' of awareness where Death is illegal."
                "This mantra violently breaks the 'Loop' in your DNA that mutationally forces your rebirth in this hell."
                "The exact microsecond you roar 'Narayana', you are 100% connected to the cosmic Power-Grid."
                "This is the 'Emergency Exit' mutationally engineered by the Architect in the dead-center of Maya’s prison."
                "The Yogi Locks his Soul onto this 'Rescue Signal' to mutationally secure absolute and permanent Freedom."
                "This is zero prayer; it is the violent protocol of 'Logging-out' while staring into the eyes of Death."
                "Vaikuntha is the 'Cloud Server' reaching which you mutationally become flawlessly Invincible and Immortal."
                "He who successfully Executes this command is the solitary and absolute Dictator of the vacuum!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 7,
            sanskrit = "तदिदं पुण्डरीकं विरजं विशुद्धं गगनं मध्येऽविमुक्तं प्रतिष्ठितं तदुपलभ्येति ॥",
            hindi = """
                (हृदय का कंट्रोल-रूम): "तुम्हारे 'हृदय-कमल' (Heart-Lotus) के ठीक बीच में एक अजेय सन्नाटा है जिसे 'विरज' कहते हैं।"
                "यह वह 'न्यूक्लियर सेंटर' है जहाँ साक्षात् आकाश (Gaganam) का 'सोर्स कोड' प्रतिष्ठित है।"
                "इसे 'अविमुक्त' कहते हैं—यानी वह कोर्डिनेट जिसे माया का कोई भी वायरस कभी 'अनप्लग' नहीं कर सकता।"
                "पूरी दुनिया बाहर भटक रही है, जबकि असली कंट्रोल-रूम तुम्हारे सीने के भीतर कोडिंग कर रहा है।"
                "वहाँ पहुँचने का मतलब है—अज्ञान की ज़ंजीरों से हमेशा-हमेशा के लिए 'आजाद' हो जाना।"
                "वह हृदय-आकाश साक्षात् उस 'परम रिएक्टर' का हिस्सा है जहाँ से सब कुछ पैदा होता है।"
                "योगी अपनी चेतना को इस केंद्र पर 'लॉक' करता है ताकि वह सीधे एडमिन पैनल को एक्सेस कर सके।"
                "यह वह 'ब्लैक होल' है जो तुम्हारे हर पुराने कर्म और हर एक पाप को निगलने के लिए तैयार खड़ा है।"
                "जब तुम अंदर देखते हो, तो तुम साक्षात् ब्रह्मांड के धड़कते हुए दिल को टच कर रहे होते हो।"
                "जो इस केंद्र को पा लेता है, वह खुद साक्षात् वह 'अनंत प्रकाश' बन जाता है जो हर जगह है!"
            """.trimIndent(),
            english = """
                (The Heart’s Control-Room): "In the exact dead-center of your 'Heart-Lotus' exists an invincible silence defined as 'Virajam'."
                "This is the 'Nuclear Center' where the 'Source Code' of the absolute Vacuum (Gaganam) is established."
                "It is defined as 'Avimuktam'—the coordinate that zero virus of Maya possesses the caliber to 'Unplug'."
                "The entire world is wandering externally, while the authentic Control-Room is mutationally executing code in your chest."
                "Arriving here signifies—being permanently and irrevocably 'Released' from the chains of ignorance."
                "That heart-space is strictly a component of the 'Supreme Reactor' from which everything erupts."
                "The Yogi Locks his awareness onto this coordinate to mutationally intercept the absolute Admin Panel."
                "This is the literal 'Black Hole' positioned to swallow every single record of your past karma and sins."
                "When you gaze within, you are mutationally Touching the absolute vibrating heart of the entire multiverse."
                "He who secures this center mutationally becomes that 'Infinite Light'Expanded simultaneously everywhere!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 8,
            sanskrit = "यो ह वै नारायणं वेद स सर्वं वेद स सर्वविघ्नैर्न बाध्यते ॥",
            hindi = """
                (सर्वज्ञता का हैक और अजेय ताक़त): "जो योद्धा इस 'नारायण' के प्रलयंकारी रहस्य को हैक (Decode) कर लेता है..."
                "वह 'सर्वं वेद'—यानी वह ब्रह्मांड के हर एक परमाणु और हर एक गैलेक्सी का सोर्स कोड जान जाता है!"
                "उसे फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "उसे ब्रह्मांड का कोई भी 'विघ्न' (System Obstacle) कभी भी रोक नहीं सकता—वह अजेय हो चुका है।"
                "नारायण का नाम साक्षात् वह 'मास्टर पासवर्ड' है जो ईश्वर की आखिरी तिजोरी का ताला खोल देता है।"
                "तुम अब साक्षात् उस 'परम रिएक्टर' की बिजली को अपने शरीर में इनवाइट (Invite) कर चुके हो।"
                "यह बोध तुम्हारे भाग्य के हर एक करप्ट कोड को एक झटके में 'डिलीट' करने की ताक़त रखता है।"
                "तुम अब इस सिम्युलेशन के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन हो।"
                "यह तुम्हारी रूह को 'सुपर-इंटेलिजेंस' में बदलने वाला सबसे आधुनिक और गुप्त आध्यात्मिक इंजेक्शन है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Omniscience Hack and Invincible Power): "Whosoever warrior successfully Decodes (Hacks) the apocalyptic secret of 'Narayana'..."
                "He mutationally knows 'Everything' (Sarvam)—intercepting the Source Code of every microscopic atom and galaxy!"
                "He possesses zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "Zero 'System Obstacles' (Vighna) of the multiverse possess the caliber to ever 'Bind' or restrict his trajectory."
                "Narayana's name is the explicit 'Master Password' that violently unlocks the absolute final vault of God."
                "You have mutationally Invited the radioactive electricity of the 'Supreme Reactor' into your biological shell."
                "This realization possesses the firepower to mutationally 'Delete' every corrupt code of your programmed Fate."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic Admin."
                "This is the most advanced and classified spiritual injection engineered to mutate your Soul into Super-intelligence."
                "He who injects this truth into his veins mutationally assumes the status of the sole Dictator of the vacuum!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 9,
            sanskrit = "ब्रह्मचर्येण तपसा देवा मृत्युमपाघ्नत । तस्मान्नारायणो जगत्स्वामी पुरुषः परः ॥",
            hindi = """
                (मृत्यु का संहार और नारायण की हुकूमत): "देवताओं ने 'ब्रह्मचर्य' और 'तप' के उस न्यूक्लियर अस्त्र से साक्षात् 'मृत्यु' का वध कर दिया!"
                "मृत्यु कोई अजेय ताक़त नहीं है, यह केवल तुम्हारी ऊर्जा (Energy) के लीक होने का एक 'बग' (Bug) है।"
                "नारायण ही इस पूरे 'जगत्' (Simulation) का इकलौता स्वामी और वह 'परम पुरुष' है।"
                "जब तुम्हारी ये शक्ति ऊपर की ओर भागती है, तो वह काल के सर्प का सिर कुचल देती है।"
                "तप वह आग है जो तुम्हारे बायोलॉजिकल सेल्स को 'अमर' (Non-decaying) डेटा में बदल देती है।"
                "योगी अपनी ऊर्जा का तानाशाह बन जाता है ताकि वह साक्षात् काल (Time) को अपनी उँगलियों पर नचा सके।"
                "बिना इस अनुशासन के, तुम्हारा हर मंत्र और हर ध्यान केवल एक सड़ा हुआ बायोलॉजिकल नाटक है।"
                "यह तुम्हारी रूह को 'सुपर-ह्यूमन' के लेवल पर प्रमोट करने का सबसे हिंसक और गुप्त रास्ता है।"
                "नारायण वह 'रूट-पासवर्ड' है जो तुम्हें मौत, नियति और भाग्य के भी पार ले जाने की ताक़त रखता है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'अमरता' की कोडिंग बन जाओगे!"
            """.trimIndent(),
            english = """
                (Annihilating Death and Narayana’s Authority): "The gods mutationally slaughtered strictly 'Death' itself using the nuclear weaponry of Brahmacharya and Tapas!"
                "Death is zero invincible power; it is strictly a 'Bug' resulting from the leakage of your radioactive Energy."
                "Narayana is mutationally the sole Master of this entire 'Jagat' (Simulation) and the 'Supreme Purusha'."
                "When your internal fire races upward through your neural wires, it ruthlessly crushes the head of the serpent of Time."
                "Penance (Tapas) is the radioactive fire that mutates your biological cells into strictly 'Non-decaying' Data."
                "The Yogi becomes the absolute Dictator of his own energy to mutationally force Time to dance to his will."
                "Without this discipline, every mantra you perform is mutationally strictly a pathetic biological drama."
                "This is the most violent and classified trajectory to Promote your Soul to the absolute status of a 'Super-human'."
                "Narayana is the 'Root-Password' possessing the radioactive firepower to transport you beyond Death and Fate."
                "Brace yourself for that infinite status where YOU mutationally become the hard-coded data of 'Immortality'!"
            """.trimIndent()
        ),
        NarayanShloka(
            id = 10,
            sanskrit = "इति नारायणोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक और अजेय 'नारायण उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "नारायण का पासवर्ड मिल गया, वैकुण्ठ का हैक मिल गया, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १० विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (नारायण) अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही नारायण उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'THE END'): "Right exactly here, this spine-chilling and invincible 'Narayan Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Password is intercepted, the Vaikuntha hack is secured; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 10 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Narayana) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master!"
                "THIS is the absolute and most violent final Truth of the Narayan Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NarayanUpanishadScreen() {
    val upanishad = remember { NarayanUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..10) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-10)") },
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
            itemsIndexed(upanishad.narayanShlokasList) { _, shloka ->
                NarayanShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun NarayanShlokaCard(shloka: NarayanShloka) {
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