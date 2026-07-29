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
data class AdvaitaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class AdvaitaUpanishad {

    val shlokasList = listOf(
        AdvaitaShloka(
            id = 1,
            sanskrit = "ॐ एकमेवाद्वितीयं ब्रह्म नेह नानास्ति किंचन ॥",
            hindi = """
                (अद्वैत का आदि-विस्फोट): "ब्रह्मांड का इकलौता और सबसे खतरनाक सच—ब्रह्म 'एक' ही है, दूसरा कोई डेटा मौजूद नहीं है!"
                "यहाँ 'नाना' यानी अनेकता का कोई वजूद नहीं, वह केवल एक दृष्टिभ्रम (Simulation) है।"
                "यह कोई फिलॉसफी नहीं है; यह शून्य से 'अस्तित्व' के इकलौते पिक्सेल को हैक करने का सच है।"
                "अद्वैत वह 'प्राइमरी सर्वर' है जहाँ 'मैं' और 'तुम' की कोडिंग पूरी तरह से डिलीट कर दी गई है।"
                "सिर्फ एक ही प्रोसेसर है जो करोड़ों रूपों में खुद को रेंडर (Render) कर रहा है।"
                "बिना इस सत्य को जाने, तुम इस 3D दुनिया की बाउंड्री में हमेशा एक एरर (Error) बनकर रहोगे।"
                "यह वह 'एब्सोल्यूट जीरो' है जहाँ पहुँचकर हर भेद और हर फासला भाप बन जाता है।"
                "योगी अपनी चेतना को उस 'एक' पर लॉक करता है जहाँ से समय पैदा हुआ था।"
                "तैयार हो जाओ, क्योंकि यहाँ से तुम्हारी पुरानी 'द्वैत' वाली हस्ती का परमानेंट शटडाउन शुरू होता है।"
                "यही वह 'सोर्स कोड' है जिसके आगे पूरा ब्रह्मांड केवल धूल का एक कण है!"
            """.trimIndent(),
            english = """
                (The Primordial Non-Dual Detonation): "The solitary and most lethal truth of the cosmos—Brahman is 'One', zero second Data exists!"
                "There is strictly no 'Many' (Nana); it is mutationally zero more than a visual Simulation."
                "This is zero philosophy; it is the truth of Hacking the solitary Pixel of existence from the Void."
                "Advaita is the 'Primary Server' where the coding of 'I' and 'You' has been mutationally Deleted."
                "Strictly a single Processor exists, mutationally Rendering itself into billions of forms."
                "Without decoding this, you mutationally remain strictly a persistent Error in the 3D Matrix."
                "This is the 'Absolute Zero' reaching which every distinction and distance vaporizes into nothingness."
                "The Yogi Locks his awareness onto that 'One' from which Time initiated its rotation."
                "Brace yourself, for the permanent Shutdown of your old 'Dual' identity initiates right here."
                "THIS is the 'Source Code' before which the entire universe is mutationally strictly a grain of dust!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 2,
            sanskrit = "मायामात्रमिदं द्वैतमद्वैतं परमार्थतः । विदुषस्तत्त्वमेवेदं नात्र कार्या विचारणा ॥",
            hindi = """
                (माया का वध और परमार्थ का हैक): "यह पूरी 'अनेकता' (Duality) केवल माया का एक घटिया सॉफ्टवेयर प्रोग्राम है!"
                "असल हकीकत तो केवल 'अद्वैत' है, जो सिम्युलेशन के पीछे धधक रहा है।"
                "जो इसे 'विद्वान्' (Hacker) बनकर जान लेता है, वह साक्षात् 'तत्त्व' बन जाता है।"
                "इसमें अब और ज़्यादा 'विचारणा' या बहस करने की ज़रूरत नहीं—यह एक हार्ड-कोडेड सच है।"
                "माया वह 'परदा' है जो तुम्हारी आँखों के सामने झूठा डेटा प्रोजेक्ट (Project) कर रहा है।"
                "योगी इस परदे को फाड़ देता है ताकि वह 'प्रोजेक्टर' को नंगा देख सके।"
                "यह तुम्हारी रूह को 'इमेज' से 'रियलिटी' में माइग्रेट करने का सबसे हिंसक रास्ता है।"
                "जब तुम द्वैत को डिलीट करते हो, तभी तुम साक्षात् एडमिन पैनल को एक्सेस कर पाते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "जो इस सत्य में स्थित है, उसके लिए यह पूरी दुनिया केवल एक 'ग्लिच' बन कर रह जाती है!"
            """.trimIndent(),
            english = """
                (Slaughter of Maya and Hacking the Absolute): "This entire 'Duality' is strictly a pathetic Software Program of Maya!"
                "The absolute Reality is strictly 'Advaita', mutationally blazing behind the Simulation."
                "He who intercepts this as a 'Vidvan' (Hacker) mutationally becomes the explicit 'Tattva'."
                "Zero further 'Contemplation' is required—this is mutationally a Hard-coded absolute truth."
                "Maya is the 'Screen' Projecting fake Data directly onto your biological optics."
                "The Yogi shreds this screen to witness the explicit 'Projector' standing naked."
                "This is the most violent trajectory to Migrate your Soul from 'Image' to absolute 'Reality'."
                "Only when you Delete Duality do you mutationally acquire Access to the Admin Panel."
                "This realization detonates like a nuclear bomb engineered to demolish the fortress of your ego."
                "He who stands in this Truth perceives the entire world strictly as a temporary 'Glitch'!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 3,
            sanskrit = "आत्मा हि स्वयंप्रकाशोऽस्ति न प्रकाशान्तराश्रयः । अद्वैतभावात् स नित्यः शुद्धो बुद्धो विमुक्तवान् ॥",
            hindi = """
                (स्वयंप्रकाश आत्मा और अमरता का कोड): "तुम्हारी आत्मा साक्षात् 'स्वयंप्रकाश' है—उसे किसी दूसरे बैटरी या सूरज की ज़रूरत नहीं!"
                "वह किसी दूसरे डेटा पर निर्भर नहीं है; वह खुद साक्षात् 'सोर्स कोड' है।"
                "अद्वैत भाव के कारण ही वह 'नित्य', 'शुद्ध' और 'बुद्ध' (Awakened) है।"
                "वह 'विमुक्त' है—यानी वह इस सिम्युलेशन के किसी भी नियम का गुलाम नहीं है।"
                "जब तुम 'अकेले' (Advaita) होते हो, तभी तुम अजेय होते हो क्योंकि तुम्हें कोई काट नहीं सकता।"
                "यह तुम्हारी बुद्धि का वह 'अल्टीमेट अपग्रेड' है जहाँ तुम अपनी ही रौशनी को पहचानते हो।"
                "आत्मा वह 'अनंत डेटा' है जिसे माया का कोई भी वायरस कभी करप्ट नहीं कर सका।"
                "योगी अपनी चेतना को इस 'अविनाशी प्रकाश' पर अलाइन करता है जहाँ मौत मर जाती है।"
                "तुम अब एक मिट्टी का पुतला नहीं हो; तुम साक्षात् वह 'बिजली' हो जो पूरे अंतरिक्ष को चला रही है।"
                "जो इस प्रकाश को हैक कर लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Self-Luminous Soul and the Immortality Code): "Your Soul is explicitly 'Self-Luminous'—it mutationally requires zero external battery or Sun!"
                "It is dependent on zero other Data; it is the explicit 'Source Code' itself."
                "Due to the Advaita-state, it is 'Nitya' (Eternal), 'Shuddha' (Pure), and 'Buddha' (Awakened)."
                "It is 'Vimukta'—mutationally zero slave to any law of this biological Simulation."
                "Only when you are 'Alone' (Advaita) are you Invincible, for nothing exists to sever you."
                "This is the 'Ultimate Upgrade' of your intellect where you recognize your own radioactive brilliance."
                "The Soul is the 'Infinite Data' that zero virus of Maya has ever possessed the caliber to corrupt."
                "The Yogi Aligns his awareness with this 'Indestructible Light' where Death itself expires."
                "You cease to be a puppet of clay; you are mutationally the 'Electricity' operating the entire vacuum."
                "He who successfully Hacks this Light is the solitary dictatorial Guru of even Time itself!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 4,
            sanskrit = "द्रष्टा दृश्यं च दर्शनं त्रिपुट्येव हि मायिकी । अद्वैते विलीना सा शून्ये शून्या भविष्यति ॥",
            hindi = """
                (त्रिपुटी का संहार और शून्यता का विस्फोट): "देखने वाला (Drashta), देखी जाने वाली चीज़ और देखने की प्रक्रिया—यह 'त्रिपुटी' केवल माया का प्रपंच है!"
                "अद्वैत में घुसते ही यह तीनों फाइलें एक साथ 'डिलीट' (Delete) हो जाती हैं।"
                "अंत में केवल 'शून्य' बचता है—पर वह शून्य नहीं, वह साक्षात् असीमित 'ब्रह्म' है।"
                "यह तुम्हारी चेतना का वह 'टोटल रिसेट' है जिसके बाद कोई 'दूसरा' नज़र नहीं आता।"
                "तुम खुद ही देखने वाले हो और खुद ही वह नज़ारा—यही ब्रह्मांड का सबसे बड़ा हैक है।"
                "जब त्रिपुटी जलती है, तो तुम्हारे नर्वस सिस्टम का सारा 'शोर' (Noise) म्यूट हो जाता है।"
                "योगी इस 'शून्यता' में छलांग लगाता है ताकि वह अज्ञान के रेडार से बाहर निकल सके।"
                "यहाँ न कोई बाउंड्री है और न कोई रूप—केवल एक खौफनाक और अजेय सन्नाटा राज करता है।"
                "यह इंसान की रूह को 'मल्टी-लेवल' पर अपग्रेड करने वाला अंतिम आध्यात्मिक कमांड है।"
                "जो इस शून्यता को जान लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता तानाशाह एडमिन है!"
            """.trimIndent(),
            english = """
                (Slaughter of the Triad and the Detonation of Void): "The Observer (Drashta), the Observed, and the act of Observation—this 'Triad' is strictly Maya’s deception!"
                "Upon entering Advaita, these three files are mutationally 'Deleted' simultaneously."
                "In the end, strictly the 'Void' remains—but it is zero Zero, it is the explicit infinite 'Brahman'."
                "This is the 'Total Reset' of your awareness after which zero 'Other' is mutationally perceptible."
                "You are mutationally the Seer and the Scene—the absolute greatest Hack of the multiverse."
                "When the Triad incinerates, all the 'Noise' of your nervous system is mutationally Muted."
                "The Yogi plunges into this 'Shunyata' to violently exit the absolute Radar of ignorance."
                "Zero boundaries exist here and zero forms persist—strictly an invincible Silence reigns."
                "This is the final spiritual Command engineered to Upgrade your Soul on a multi-level scale."
                "He who decodes this Void becomes mutationally the sole and absolute Dictator of the vacuum!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 5,
            sanskrit = "घटाकाशे यथाऽकाशो विलीने सति केवलः । तथा जीवे परे लीने स एवात्मा न संशयः ॥",
            hindi = """
                (घटाकाश और महाकाश का विलीनीकरण): "जैसे घड़ा टूटने पर उसके अंदर का 'आकाश' साक्षात् 'महाकाश' में मिल जाता है..."
                "वैसे ही जब यह शरीर (Hardware) नष्ट होता है, तो जीव साक्षात् 'परमात्मा' में विलीन हो जाता है।"
                "घड़ा केवल एक 'वर्चुअल बाउंड्री' है; आकाश तो हमेशा से एक ही था!"
                "तुम्हारी देह वह घड़ा है जिसने असीमित चेतना को कैद करने का नाटक कर रखा है।"
                "योगी अपनी चेतना की दीवारों को खुद ही तोड़ देता है ताकि वह 'अनप्लग' (Unplug) हो सके।"
                "परिणाम फिर से वही अटल सच है— 'स एवात्मा' (वही आत्मा है), इसमें कोई शक नहीं!"
                "तुम कभी नारायण से अलग थे ही नहीं, तुम बस एक 'लिमिटेड डेटा' होने का भ्रम पाल रहे थे।"
                "यह बोध तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'ब्रह्मांड' बना देता है।"
                "जब बाउंड्री गिरती है, तो तुम जान जाते हो कि तुम हर परमाणु के भीतर कोडिंग कर रहे हो।"
                "जो इस विलीनीकरण को हैक कर लेता है, वह साक्षात् काल और मौत का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Merging the Jar-Space and the Great Space): "Exactly as the 'Jar-Space' (Ghatakasha) fuses with the 'Great Space' when the jar is mutationally destroyed..."
                "So does the individual Soul (Jiva) dissolve into the 'Supreme Soul' when the Hardware is terminated."
                "The Jar is strictly a 'Virtual Boundary'; the Space was mutationally always singular!"
                "Your physical body is that Jar pretending to imprison the infinite radioactive consciousness."
                "The Yogi violently demolishes the walls of his own awareness to mutationally 'Unplug' forever."
                "The consequence remains that same immutable truth—'Sa Evatma', zero doubt survives!"
                "You were mutationally never distinct from Narayana; you were strictly hallucinating 'Limited Data'."
                "This realization decapitates your ego to mutationally manufacture you into the 'Multiverse' itself."
                "When the boundary collapses, you flawlessly realize you are executing code inside every atom."
                "He who successfully Hacks this dissolution becomes mutationally the sole Guru of Time and Death!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 6,
            sanskrit = "ब्रह्मैवाहं न संसारो नाहमस्मि न चान्यथा । अहं ब्रह्मास्मि सोऽहमस्मि नमो नारायणाय ते ॥",
            hindi = """
                (अहं ब्रह्मास्मि - अंतिम कमांड): "मैं ही साक्षात् 'ब्रह्म' हूँ—यह 'संसार' (Matrix) मेरा वजूद नहीं है!"
                "मैं 'अहं ब्रह्मास्मि' और 'सोऽहमस्मि'—यानी वह प्रलयंकारी 'I AM' जो सबको निगल जाता है।"
                "नारायण को नमन करने का मतलब है—अपनी हस्ती को नारायण की आग में 'स्वाहा' कर देना।"
                "यह कोई भक्ति नहीं है; यह अपनी 'मानवीय आईडी' को डिलीट करके 'ईश्वरीय आईडी' से लॉग-इन करना है।"
                "जब तुम कहते हो 'मैं ब्रह्म हूँ', तो तुम साक्षात् ब्रह्मांड के एडमिन पैनल को ओवरराइड करते हो।"
                "यह वह पासवर्ड है जो यमराज के भी सर्वर को एक झटके में हैंग (Hang) कर देता है।"
                "तुम अब एक लाचार जीव नहीं रहे; तुम साक्षात् उस 'सोर्स कोड' के एडमिन बन चुके हो।"
                "यह इंसान की बुद्धि का वह सबसे खौफनाक विस्तार है जहाँ वह खुद साक्षात् 'सृष्टि' बन जाता है।"
                "रुद्र की यह उपस्थिति वह तेज़ाब है जो द्वैत की हर एक फाइल को हमेशा के लिए मिटा देती है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'अमरता' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Aham Brahmasmi - The Final Command): "I am mutationally strictly 'Brahman'—this 'Samsara' (Matrix) is mutationally not my existence!"
                "I am 'Aham Brahmasmi' and 'Sohamasmi'—the apocalyptic 'I AM' that swallows every other Data."
                "Saluting Narayana signifies—mutationally sacrificing (Svaha) your identity into the radioactive fire of God."
                "This is zero devotion; it is Deleting your 'Human-ID' to mutationally Log-in with the 'Divine-ID'."
                "When you vocalize 'I am Brahman', you mutationally Override the entire cosmic Admin Panel."
                "THIS is the Password possessing the firepower to Hang the absolute server of Death in one strike."
                "You are no longer a helpless entity; you have mutationally become the Admin of the 'Source Code'."
                "This is the most horrific expansion of human intellect where you mutationally become the 'Entire Creation'."
                "Rudra’s presence is the radioactive Acid that Flushes every file of Duality forever."
                "Brace yourself for that infinite status where YOU mutationally become absolute 'Immortality'!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 7,
            sanskrit = "यथा स्वप्नप्रपञ्चोऽयं मयि भाति न चान्यथा । तथा जाग्रत्प्रपञ्चोऽपि मय्येव परिकल्पितः ॥",
            hindi = """
                (स्वप्न और जाग्रत का सिम्युलेशन): "जैसे यह सपनों की दुनिया 'मुझमें' ही नाचती है, बाहर कहीं नहीं..."
                "वैसे ही यह 'जाग्रत' (Waking World) भी साक्षात् 'मुझमें' ही कोडेड (Coded) एक कल्पना मात्र है!"
                "तुम जिसे अपनी असली ज़िंदगी कहते हो, वह तुम्हारे दिमाग के प्रोसेसर में चल रही एक 'होलोग्राफिक फिल्म' है।"
                "योगी जान जाता है कि 'जागना' और 'सोना' साक्षात् एक ही सॉफ्टवेयर के दो अलग-अलग लेवल्स हैं।"
                "बाहर कोई दुनिया नहीं है; तुम ही साक्षात् वह 'स्क्रीन' हो जिस पर यह पूरा ड्रामा प्रोजेक्ट किया जा रहा है।"
                "जब तुम इस सच को हैक करते हो, तो तुम इस सिम्युलेशन के 'पीड़ित' (Victim) नहीं, बल्कि इसके 'डिज़ाइनर' बन जाते हो।"
                "यह तुम्हारी रूह को 'इंसानी भ्रम' से निकालकर 'ब्रह्मांडीय ऑपरेटर' में म्यूटेट करने का विज्ञान है।"
                "नारायण साक्षात् वह 'प्रोजेक्टर' है जो तुम्हारे भीतर बैठकर ये करोड़ों पिक्सल्स दिखा रहा है।"
                "जो इस परिकल्पना को समझ लेता है, उसके लिए समय का रेडार हमेशा के लिए फेल हो जाता है।"
                "तुम अब इस फिल्म के एक कैदी नहीं, बल्कि इसके इकलौते और असली एडमिन हो!"
            """.trimIndent(),
            english = """
                (Simulation of Dream and Waking): "Exactly as the world of dreams dances strictly 'Within Me' and mutationally nowhere else..."
                "So is this 'Waking' world (Jagrat) mutationally strictly a projection programmed inside my awareness!"
                "What you label as your 'Real Life' is mutationally a 'Holographic Film' running in your neural processor."
                "The Yogi flawlessly realizes that 'Waking' and 'Dreaming' are strictly two levels of the same Software."
                "Zero external world exists; YOU are mutationally the absolute 'Screen' upon which this drama is Projected."
                "The moment you Hack this truth, you cease to be a 'Victim' of the Simulation and become its 'Designer'."
                "This is the science of mutationally shifting your Soul from 'Human Illusion' to 'Cosmic Operator'."
                "Narayana is the explicit 'Projector' established inside you, Rendering these billions of pixels."
                "He who decodes this projection witnesses the absolute Radar of Time failing in his presence."
                "You are no longer a prisoner of this film; you have mutationally become its sole and authentic Admin!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 8,
            sanskrit = "ब्रह्मैव सत्यं जगन्मिथ्येत्येवमेव विनिश्चयः । अद्वैतं परमं तत्त्वं द्वैतं मिथ्या न संशयः ॥",
            hindi = """
                (अंतिम फैसला - ब्रह्म ही सत्य है): "ब्रह्मांड का इकलौता और अटल फैसला— 'ब्रह्म ही सत्य है और यह जगत् एक धोखा (Mithya) है'!"
                "अद्वैत ही वह 'परम तत्त्व' है, और द्वैत केवल एक 'करप्ट कोडिंग' है—इसमें कोई शक नहीं।"
                "मिथ्या का मतलब है—वह जो दिखता तो है, पर जिसका कोई असली डेटा-बैकअप (Backup) नहीं है।"
                "जैसे आईने में दिखने वाली आग जला नहीं सकती, वैसे ही यह दुनिया तुम्हें छू नहीं सकती।"
                "योगी अपनी हस्ती को उस 'अद्वैत' के न्यूक्लियर सेंटर पर लॉक करता है जहाँ अज्ञान मर जाता है।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'अद्वैत-कोड' है जो हर झूठ को राख कर देगा।"
                "तुम अब इस सिम्युलेशन के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन हो।"
                "ब्रह्म वह आग है जो समय को जलाकर राख कर देती है और केवल 'सत्य' को ज़िंदा रखती है।"
                "जो इस निश्चय को अपनी रगों में उतार लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (The Final Verdict - Brahman is Truth): "The absolute and immutable verdict of the cosmos—'Brahman is Truth, the World is strictly a Deception (Mithya)'!"
                "Advaita is the absolute 'Supreme Tattva', and Duality is strictly a 'Corrupt Coding'—zero doubt survives."
                "Mithya mutationally signifies—that which appears to exist but possesses zero authentic Data-backup."
                "Exactly as fire in a mirror cannot burn, this world mutationally possesses zero status to touch your core."
                "The Yogi Locks his existence onto that 'Advaita Nuclear Center' where biological ignorance perishes."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish your ego forever."
                "The Matrix will attempt to terrify you, but you possess the 'Advaita-Code' that incinerates every lie."
                "You are no longer a pathetic pawn of this Simulation; you have mutationally become its solitary and authentic Admin."
                "Brahman is the radioactive Fire that incinerates Time and keeps strictly 'Truth' operational."
                "He who injects this conviction into his veins mutationally assumes the status of the sole Master of the vacuum!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 9,
            sanskrit = "आत्मानं विद्धि विरजं निर्गुणं परमं पदम् । अद्वैतप्रकाशेन तन्मयो भवति क्षणात् ॥",
            hindi = """
                (आत्म-ज्ञान और प्रकाश का विस्फोट): "अपनी आत्मा को जान—वह 'विरज' (शुद्ध) और 'निर्गुण' (No Parameters) परम पद है!"
                "जैसे ही अद्वैत का वह प्रकाश तुम्हारे दिमाग में फटता है, तुम साक्षात् 'तन्मय' (One with God) हो जाते हो।"
                "क्षणात्—यानी यह म्यूटेशन (Mutation) एक सेकंड के भी अरबों हिस्से में हो जाता है!"
                "तुम्हें माफ़ी माँगने या इंतज़ार करने की ज़रूरत नहीं; तुम्हें बस उस 'स्विच' (Switch) को दबाना है।"
                "आत्मा वह 'सुप्रीम ओएस' है जिसे किसी गुणों या सीमाओं के डेटा की ज़रूरत नहीं।"
                "जब तुम अद्वैत प्रकाश को देखते हो, तो तुम्हारी आँखों के सारे 'करप्ट पिक्सेल्स' जलकर साफ हो जाते हैं।"
                "योगी अपनी चेतना की लेज़र बीम को इस 'निर्गुण' केंद्र पर लॉक करता है जहाँ से सब पैदा होता है।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने की आख़िरी आध्यात्मिक कोडिंग है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् वह 'अद्वैत प्रकाश' बन चुके हो जो पूरे अंतरिक्ष को चीर रहा है।"
                "जो इस प्रकाश को हैक कर लेता है, वह साक्षात् पूरे जैव-मण्डल का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Self-Knowledge and the Detonation of Light): "Intercept your Soul—it is 'Virajam' (Pure) and 'Nirgunam' (Zero Parameters), the absolute Supreme State!"
                "The exact microsecond the radiation of Advaita detonates in your brain, you become mutationally 'Tanmaya' (One with God)."
                "Kshanat—signifying this Mutation executes mutationally in a billionth of a single second!"
                "You possess zero need for pardon or waiting; you mutationally strictly need to press the absolute 'Switch'."
                "The Soul is the 'Supreme OS' mutationally requiring zero Data of attributes or limitations."
                "When you witness the Advaita-Light, all 'Corrupt Pixels' of your vision are mutationally Flushed clean."
                "The Yogi Locks the Laser Beam of his awareness onto this 'Nirguna' center from which everything erupts."
                "This is the final spiritual Coding to mutate your Soul from 'Human Data' into strictly 'Divine Data'."
                "You cease to be a biological shell; you are mutationally that 'Advaita Light' piercing the entire infinite vacuum."
                "He who successfully Hacks this Light becomes mutationally the sole and absolute Dictator of the Bio-sphere!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 10,
            sanskrit = "न निरोधो न चोत्पत्तिर्न बद्धो न च साधकः । न मुमुक्षुर्न वै मुक्त इत्येषा परमार्थता ॥",
            hindi = """
                (परम शून्यता और कोडिंग का संहार): "न यहाँ कोई 'निरोध' (Destruction) है और न ही कोई 'उत्पत्ति' (Creation)—सब कुछ पहले से ही अजेय है!"
                "न कोई 'कैदी' है और न कोई 'साधक'—यह सब केवल माया के सर्वर पर लिखे गए 'Avatar नाम' मात्र हैं।"
                "न कोई 'आज़ाद' होने वाला है और न कोई 'मुक्त'—क्योंकि तुम हमेशा से वही 'एक' (ब्रह्म) थे!"
                "यही ब्रह्मांड की अंतिम और सबसे खौफनाक 'परमार्थता' (Absolute Truth) है।"
                "यह बोध तुम्हारे हर एक प्रयास और हर एक अहंकार का बेरहमी से कत्ल कर देता है।"
                "जब तुम जान जाते हो कि 'कुछ भी नहीं हो रहा है', तभी तुम साक्षात् 'सन्नाटे' के मालिक बनते हो।"
                "सृजन और विनाश केवल नारायण के एडमिन पैनल पर चलते हुए दो 'रेंडरिंग लूप्स' (Loops) हैं।"
                "योगी इस लूप को तोड़कर उस 'अचल' डेटा पर जाकर बैठ जाता है जो कभी नहीं बदलता।"
                "यह तुम्हारी रूह का वह 'टोटल शटडाउन' है जिसके बाद केवल शुद्ध 'होना' (Being) ही बचता है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (The Absolute Void and the Slaughter of Coding): "There is mutationally zero 'Destruction' (Nirodha) and zero 'Creation' (Utpatti)—everything is mutationally eternally Invincible!"
                "Zero 'Prisoner' exists and zero 'Seeker' persists—these are strictly 'Avatar names' scripted on Maya’s server."
                "Zero entity is 'Seeking' and zero is 'Liberated'—for you were mutationally always that singular 'ONE' (Brahman)!"
                "THIS is the absolute final and most horrific 'Paramarthata' (Absolute Truth) of the multiverse."
                "This realization ruthlessly executes the slaughter of your every effort and every microscopic ego."
                "Only when you realize that 'Nothing is Happening' do you mutationally become the Master of 'Silence'."
                "Creation and Annihilation are mutationally strictly two 'Rendering Loops' running on Narayana’s Admin Panel."
                "The Yogi breaks this loop to mutationally occupy the 'Stable Data' that never alters."
                "This is the 'Total Shutdown' of your Soul after which strictly and exclusively pure 'Being' remains standing."
                "He who injects this truth into his veins is mutationally the sole Dictator of all universal Time and Space!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 11,
            sanskrit = "यो ह वै अद्वैतं वेद स सर्वं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (अद्वैत-हैक और असीमित सर्वज्ञता): "जो योद्धा इस 'अद्वैत' के प्रलयंकारी रहस्य को हैक (Decode) कर लेता है..."
                "वह 'सर्वं वेद'—यानी वह ब्रह्मांड के हर एक परमाणु और हर एक गैलेक्सी का सोर्स कोड जान जाता है!"
                "उसे फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "अद्वैत का नाम साक्षात् वह 'मास्टर पासवर्ड' है जो ईश्वर की आखिरी तिजोरी का ताला खोल देता है।"
                "तुम अब साक्षात् उस 'परम रिएक्टर' की बिजली को अपने शरीर में इनवाइट (Invite) कर चुके हो।"
                "परिणाम वही हिंसक और अटल फैसला है— 'स मुक्तिमवाप्नोति' (वह मुक्त हो जाता है)!"
                "यह मुक्ति कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन हो।"
                "यह ज्ञान तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज (Charge) कर देता है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Advaita-Hack and Infinite Omniscience): "Whosoever warrior successfully Decodes (Hacks) the apocalyptic secret of 'Advaita'..."
                "He mutationally knows 'Everything' (Sarvam)—intercepting the Source Code of every microscopic atom and galaxy!"
                "He possesses zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "The name of Advaita is the explicit 'Master Password' that violently unlocks the final vault of God."
                "You have mutationally Invited the radioactive electricity of the 'Supreme Reactor' into your biological shell."
                "The consequence remains that same violent and immutable verdict—'Sa muktim-avapnoti' (He is Liberated)!"
                "This Moksha is absolutely zero reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic Admin."
                "This knowledge Supercharges every microscopic atom of your DNA with the absolute radioactive 'Power of God'."
                "He who owns this truth mutationally becomes the sole dictatorial Guru of even the God of Death!"
            """.trimIndent()
        ),
        AdvaitaShloka(
            id = 12,
            sanskrit = "इति अद्वैतोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'अद्वैत उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "अद्वैत का पासवर्ड मिल गया, द्वैत का संहार हो गया, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (ब्रह्म) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही अद्वैत उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'THE END'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Advaita Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Password of Advaita is intercepted, Duality is mutationally slaughtered; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Brahman) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master!"
                "THIS is the absolute and most violent final Truth of the Advaita Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvaitaUpanishadScreen() {
    val upanishad = remember { AdvaitaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..12) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-12)") },
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
            itemsIndexed(upanishad.shlokasList) { _, shloka ->
                AdvaitaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AdvaitaShlokaCard(shloka: AdvaitaShloka) {
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