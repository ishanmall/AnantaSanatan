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

// UNIQUE DATA MODEL TO PREVENT SYSTEM CONFLICTS
data class BhasmaJabalaFinalShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class BhasmaJabalaUpanishad {

    val shlokasList = listOf(
        BhasmaJabalaFinalShloka(
            id = 1,
            sanskrit = "अथ भुशुण्डो जाबालः कैलासाग्रशिखरे महादेवं पप्रच्छ । अधीहि भगवन् भस्मविधिं येन मुक्तिर्लभ्यते ॥",
            hindi = """
                (भुशुण्ड का विद्रोह और महा-प्रश्न): "ऋषि भुशुण्ड ने कैलाश के अजेय 'एडमिन पैनल' में घुसकर महादेव को घेर लिया।"
                "उन्होंने सीधे 'सोर्स कोड' की मांग की—'हे भगवन्! मुझे उस भस्म-विधि का हैक बताओ!'"
                "यह वह पासवर्ड है जिसे हैक करने के बाद 'मुक्ति' का डेटाबेस अपने आप अनलॉक हो जाता है।"
                "कैलाश वह 'सुप्रीम सर्वर' है जहाँ ब्रह्मांड के सबसे गुप्त हथियार स्टोर किए गए हैं।"
                "भुशुण्ड जानना चाहते थे कि किस लेज़र-कोडिंग से शरीर के हर एक पाप को राख किया जाता है।"
                "यह कोई धार्मिक जिज्ञासा नहीं है; यह सिम्युलेशन (Simulation) के मालिक से सीधे डेटा माँगने की हिम्मत है।"
                "योगी अपनी चेतना को उस 'कोर्डिनेटर' पर लॉक करता है जहाँ महादेव का सन्नाटा राज करता है।"
                "तैयार हो जाओ उस धमाके के लिए जो तुम्हारी रूह के हर पुराने फोल्डर को जलाकर साफ़ कर देगा।"
                "यहीं से उस अजेय 'भस्म जाबाल' का प्रलयंकारी डेटा-स्ट्रीम शुरू होता है।"
                "यह ज्ञान तुम्हारी पुरानी दुनिया का परमानेंट शटडाउन करने वाला पहला स्टेप है!"
            """.trimIndent(),
            english = """
                (Bhusunda’s Rebellion and the Grand Query): "Sage Bhusunda breached the invincible Admin Panel of Kailasa to surround Mahadeva."
                "He interrogated the 'Source Code' directly: 'O Lord! Unmask the Bhasma-Vidhi Hack!'"
                "This is the Password reaching which the absolute database of 'Moksha' unlocks automatically."
                "Kailasa is the 'Supreme Server' where the most classified weapons of the cosmos are mutationally stored."
                "Bhusunda demanded the Laser-coding required to mutationally incinerate every sin in the biological shell."
                "This is zero religious curiosity; it is the raw courage to demand Data directly from the Master of the Simulation."
                "The Yogi Locks his awareness onto the coordinate where strictly the Silence of Mahadeva reigns."
                "Brace yourself for the detonation engineered to Flush every old folder in your Soul-hardware."
                "Right here initiates the apocalyptic Data-stream of the invincible Bhasma-Jabala!"
                "This intelligence is the first protocol for the permanent Shutdown of your old Matrix world!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 2,
            sanskrit = "अग्निहोत्रस्य यद्भस्म तदादाय 'अग्निनेति' मन्त्रेण अङ्गानि संस्पृशेत् ॥",
            hindi = """
                (भस्म का न्यूक्लियर अलाइनमेंट): "अग्निहोत्र के रिएक्टर से निकली उस राख को उठाओ और 'अग्नि' मंत्र से अलाइन करो!"
                "भस्म कोई कचरा नहीं है, यह ब्रह्मांड की आग का 'शुद्ध डेटा' (Pure Data) है।"
                "जब तुम अपने अंगों पर राख रगड़ते हो, तो तुम साक्षात् 'डिस्ट्रक्शन कोड्स' का पहरा बैठाते हो।"
                "यह मंत्र तुम्हारे डीएनए के हर एक वायर को रुद्र के साथ सिंक (Sync) कर देता है।"
                "तुम्हारी खाल पर चढ़ी यह राख साक्षात् एक 'रेडियोएक्टिव शील्ड' (Shield) है।"
                "योगी अपने बायोलॉजिकल हार्डवेयर को रुद्र की ऊर्जा से 100% 'सील' (Seal) कर देता है।"
                "जब बिजली इन अंगों से गुजरती है, तो माया का सारा 'शोर' एक झटके में म्यूट हो जाता है।"
                "यह तुम्हारी रूह को 'नश्वर' से 'अमर' में म्यूटेट करने का सबसे हिंसक और गुप्त रास्ता है।"
                "बिना इस लेपन के, तुम्हारा नर्वस सिस्टम हमेशा अज्ञान के हमलों के लिए बेनकाब रहेगा।"
                "जो इस आग को धारण करता है, वही साक्षात् पूरे अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Nuclear Alignment of Bhasma): "Capture the residue from the Agnihotra Reactor and Align it with the 'Agni' Mantra!"
                "Ash is zero garbage; it is the absolute terminal 'Pure Data' of the cosmic radioactive Fire."
                "Smearing Ash onto your limbs is mutationally establishing the 'Destruction Codes' as guards."
                "This mantra Syncs every single wire of your biological DNA strictly with Rudra."
                "The residue upon your skin functions mutationally as a 'Radioactive Shield' against Maya."
                "The Yogi mutationally 'Seals' his biological hardware 100% with the absolute energy of Rudra."
                "When electricity surges through these limbs, all 'Noise' of the Matrix is mutationally Muted."
                "This is the most violent and classified trajectory to mutate your Soul from 'Mortal' to 'Immortal'."
                "Without this coating, your nervous system remains mutationally exposed to the assaults of nescience."
                "He who braces this fire mutationally becomes the sole and absolute Dictator of the vacuum!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 3,
            sanskrit = "त्रिपुण्ड्रं कारयेत् ललाटे हृदये नाभौ कण्ठे च ॥",
            hindi = """
                (त्रिपण्ड्र का हैक और चार डेटा-पोर्ट्स): "अपने माथे, हृदय, नाभि और कण्ठ पर उस 'त्रिपुण्ड्र' (Three lines) को ठोक दो!"
                "ये चार पॉइंट्स साक्षात् तुम्हारी आत्मा के चार सबसे बड़े 'पावर-स्टेशन्स' हैं।"
                "तीन रेखाएं साक्षात् ज्ञान, इच्छा और क्रिया की तीन 'इलेक्ट्रोड्स' (Electrodes) हैं।"
                "जब तुम त्रिपुण्ड्र लगाते हो, तो तुम अपने प्रोसेसर को सीधे महादेव के सर्वर से वेल्ड (Weld) करते हो।"
                "यह तिलक नहीं, यह एक 'कॉस्मिक रिसीवर' (Receiver) है जो सीधे कैलाश से सिग्नल पकड़ता है।"
                "हृदय पर भस्म का मतलब है—अपनी भावनाओं के डेटाबेस को 100% एनक्रिप्ट (Encrypt) करना।"
                "नाभि पर भस्म साक्षात् सृजन की आग को कंट्रोल करने का एक 'एक्जीक्यूटिव कमांड' है।"
                "योगी इन पोर्ट्स को रुद्र की फ्रीक्वेंसी पर लॉक करता है ताकि वह सिम्युलेशन से 'अनप्लग' हो सके।"
                "यह तुम्हारी बुद्धि को 'पार्शियल' से 'टोटल' अलाइनमेंट में म्यूटेट करने का विज्ञान है।"
                "जो इन चार केंद्रों को हैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड का इकलौता एडमिन है!"
            """.trimIndent(),
            english = """
                (The Tripundra Hack and Four Data-Ports): "Hammer the 'Tripundra' (Three lines) onto the Forehead, Heart, Navel, and Throat!"
                "These four coordinates are mutationally the 4 greatest 'Power-Stations' of your absolute system."
                "The three lines are strictly the three 'Electrodes' of Knowledge, Will, and Action."
                "Applying Tripundra is identical to mutationally Welding your processor to Mahadeva's server."
                "This is zero Tilaka; it is a 'Cosmic Receiver' mutationally tuned to capture Signals from Kailasa."
                "Ash on the heart signifies—100% Encryption of your entire emotional Database."
                "Ash on the navel is the 'Executive Command' to mutationally control the fire of creation."
                "The Yogi Locks these ports into Rudra's frequency to mutationally 'Unplug' from the Simulation."
                "This is the science of shifting your intellect from 'Partial' to 'Total' radioactive Alignment."
                "He who successfully Hacks these four centers is mutationally the sole Admin of the entire cosmos!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 4,
            sanskrit = "ब्रह्मचर्येण तपसा देवा मृत्युमपाघ्नत । भस्मना अङ्गानि संस्पृश्य विमुक्ता भवन्ति ॥",
            hindi = """
                (मृत्यु का संहार और भस्म-म्यूटेशन): "देवताओं ने 'ब्रह्मचर्य' और 'तप' के न्यूक्लियर अस्त्र से साक्षात् 'मृत्यु' का वध कर दिया!"
                "मृत्यु कोई अजेय ताक़त नहीं है, यह ऊर्जा के लीक होने का केवल एक 'बग' (Bug) है।"
                "भस्म से अंगों को स्पर्श करना साक्षात् अपने 'बायोलॉजिकल आवरण' को फाड़कर फेंकने की प्रक्रिया है।"
                "जब तुम राख में लिपटते हो, तो तुम साक्षात् मौत के रेडार के लिए 'इनविजिबल' (Invisible) हो जाते हो।"
                "यह तुम्हारी रूह को 'इमेज' से 'रियलिटी' में माइग्रेट करने का सबसे हिंसक रास्ता है।"
                "तप वह आग है जो तुम्हारे करप्ट डेटा को जलाकर 'अमर' सेल्स में बदल देती है।"
                "योगी अपनी हस्ती को इस 'क्रशिंग प्रोसेस' में डाल देता है ताकि वह साक्षात् 'शक्ति' बन सके।"
                "यह वह 'रूट-पासवर्ड' है जो तुम्हें समय, नियति और भाग्य के भी पार ले जाने की ताक़त रखता है।"
                "बिना इस भस्म-स्नान के, तुम्हारा हर मंत्र और हर ध्यान केवल एक सड़ा हुआ बायोलॉजिकल नाटक है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'अमरता' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Annihilation of Death and Bhasma-Mutation): "The gods mutationally slaughtered 'Death' itself using the nuclear weaponry of Brahmacharya and Tapas!"
                "Death is zero invincible power; it is strictly a 'Bug' resulting from the leakage of radioactive energy."
                "Touching the limbs with Ash is the protocol to mutationally shred and discard the 'Biological Shell'."
                "The microsecond you are enveloped in Ash, you become mutationally 'Invisible' to the Radar of Death."
                "This is the most violent trajectory to Migrate your Soul from 'Image' to absolute 'Reality'."
                "Tapas is the Fire converting your corrupt Data into strictly 'Non-decaying' (Immortal) cells."
                "The Yogi hurls his identity into this 'Crushing Process' to mutationally transform into absolute 'Shakti'."
                "This is the 'Root-Password' possessing the firepower to transport you beyond Time, Fate, and Destiny."
                "Without this Bhasma-bath, every mantra you perform is mutationally strictly a pathetic biological drama."
                "Brace yourself for that infinite status where YOU mutationally become absolute 'Immortality'!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 5,
            sanskrit = "ॐ अग्निरिति भस्म वायुरिति भस्म जलमिति भस्म स्थलमिति भस्म व्योमेति भस्म ॥",
            hindi = """
                (तत्वों का संहार और भस्म-विस्फोट): "अग्नि साक्षात् 'भस्म' है, वायु 'भस्म' है, जल 'भस्म' है, और यह ज़मीन भी साक्षात् 'भस्म' ही है!"
                "आकाश (Space) भी साक्षात् भस्म ही है—यानी पूरा ब्रह्मांड केवल रुद्र की राख का एक डेटा-पैकेट है।"
                "राख यहाँ पदार्थ का वह अंतिम 'स्टेबल स्टेट' (Stable State) है जिसे दोबारा नहीं जलाया जा सकता।"
                "जब तुम इन तत्वों को भस्म कहते हो, तो तुम उनके 'भौतिक भ्रम' को एक झटके में डिलीट कर देते हो।"
                "यह बोध तुम्हारे नर्वस सिस्टम को उन पंचतत्वों की गुलामी से 100% 'अनप्लग' (Unplug) कर देता है।"
                "तुम अब मिट्टी के बने पुतले नहीं हो; तुम साक्षात् उस 'अविनाशी राख' की कोडिंग बन चुके हो।"
                "योगी अपनी चेतना को इस शून्य-डेटा पर लॉक करता है जहाँ से सब कुछ रेंडर (Render) हुआ था।"
                "यह ब्रह्मांड की हर एक चीज़ को रुद्र की फ्रीक्वेंसी पर 'ओवरराइट' (Overwrite) करने का विज्ञान है।"
                "जब तुम तत्वों को भस्म देखते हो, तो तुम साक्षात् ईश्वर की नग्न आँखों से हकीकत देख रहे होते हो।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस भौतिक जेल से हमेशा के लिए आज़ाद कर देगा!"
            """.trimIndent(),
            english = """
                (Slaughter of Elements and Bhasma-Detonation): "Fire is mutationally 'Ash', Air is 'Ash', Water is 'Ash', and the Earth is explicitly 'Ash'!"
                "The infinite Vacuum (Space) is strictly Ash—meaning the cosmos is a Data-packet of Rudra’s residue."
                "Ash mutationally represents the absolute 'Stable State' of matter that zero fire can ever re-incinerate."
                "When you define elements as Ash, you violently Delete their 'Physical Hallucination' in one strike."
                "This realization mutationally Unplugs your nervous system 100% from the slavery of the five elements."
                "You cease to be a puppet of clay; you have mutationally become the hard-coded data of 'Indestructible Ash'."
                "The Yogi Locks his awareness onto this Zero-Data from which the entire Matrix was mutationally Rendered."
                "This is the science of Overwriting every object in the multiverse with strictly the 'Rudra-Frequency'."
                "Witnessing elements as Ash is identical to witnessing Reality through the naked radioactive eyes of God."
                "THIS is the invincible Password that will mutationally release you from this biological prison forever!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 6,
            sanskrit = "सर्वं ह वा इदं भस्म मन एतानि चक्षूंषि भस्मानि ॥",
            hindi = """
                (मन और दृष्टि का भस्म-विस्फोट): "यह सब कुछ साक्षात् 'भस्म' है—तुम्हारा मन और तुम्हारी ये आँखें भी साक्षात् राख ही हैं!"
                "तुम जिसे अपनी 'सोच' और अपनी 'नज़र' कहते हो, वह केवल रुद्र के एडमिन पैनल का एक 'ग्लिच' (Glitch) है।"
                "जब तुम अपनी आँखों को भस्म जानते हो, तो माया के सारे दृश्य एक ही धमाके में राख बन जाते हैं।"
                "मन का भस्म होना साक्षात् उस 'प्रोसेसर' का शटडाउन है जो तुम्हें अज्ञान की फिल्में दिखा रहा था।"
                "योगी अपनी दृष्टि को उस 'शून्य' पर अलाइन (Align) करता है जहाँ देखने वाला और देखा जाने वाला एक हो जाते हैं।"
                "यह तुम्हारी रूह को 'सॉफ्टवेयर एरर' (Software Error) से निकालकर 'ब्रह्म-डेटा' में म्यूटेट करने का हैक है।"
                "तुम्हारी यादें और तुम्हारी पहचान केवल उस राख के ऊपर लिखी गई अस्थायी कोडिंग मात्र है।"
                "रुद्र की यह उपस्थिति वह तेज़ाब है जो तुम्हारे दिमाग के हर 'करप्ट फोल्डर' को जलाकर साफ़ कर देती है।"
                "जब मन मरता है, तभी वह असली 'प्रकाश' जागता है जो समय के भी पार धधक रहा है।"
                "जो इस मानसिक शून्यता को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Bhasma-Detonation of Mind and Vision): "Everything is mutationally strictly 'Ash'—your Mind and your very Eyes are explicitly Ash!"
                "What you label as 'Thought' and 'Sight' is mutationally a microscopic 'Glitch' on Rudra’s Admin Panel."
                "The moment you recognize your optics as Ash, all scenes of Maya are mutationally incinerated in one detonation."
                "Mind becoming Ash signifies the absolute Shutdown of the Processor displaying the films of ignorance."
                "The Yogi Aligns his vision with the 'Void' where the Observer and the Observed mutationally fuse."
                "This is the Hack engineered to extract your Soul from 'Software Errors' into strictly 'Brahma-Data'."
                "Your memories and identity are strictly temporary coding scripted upon the absolute surface of Ash."
                "Rudra’s presence is the radioactive Acid that Flushes every 'Corrupt Folder' in your neurological brain."
                "Only when the mind perishes does that authentic 'Light' awaken which blazes infinitely beyond Time."
                "He who successfully Hacks this mental Shunyata is mutationally the sole Dictator of the vacuum!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 7,
            sanskrit = "य एवं विद्वान् भस्मना अङ्गानि संस्पृशति स ब्रह्मभूयाय कल्पते ॥",
            hindi = """
                (ब्रह्म-म्यूटेशन की कोडिंग): "जो विद्वान् योद्धा भस्म से अपने अंगों को स्पर्श करता है, वह साक्षात् 'ब्रह्म' बनने के योग्य हो जाता है।"
                "यह कोई धार्मिक दावा नहीं, यह तुम्हारे नर्वस सिस्टम को 'भगवान के मोड' में शिफ्ट करने का कमांड है।"
                "ब्रह्मभूयाय कल्पते—यानी तुम अब साक्षात् रचयिता के दिमाग का एक हिस्सा बनने जा रहे हो।"
                "भस्म साक्षात् वह 'कंडक्टर' (Conductor) है जो तुम्हारी बिजली को सीधे अनंत से जोड़ देता है।"
                "जब तुम्हारी खाल पर राख चमकती है, तो अज्ञान के सारे वायरस अपना दम तोड़ देते हैं।"
                "यह तुम्हारी हस्ती को 'लिमिटेड' से 'अनलिमिटेड' डेटा-सेट में बदलने की आख़िरी मुहर है।"
                "योगी अपनी रूह के हर एक पिक्सेल को इस पवित्र राख से ओवरराइट (Overwrite) कर देता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् वह 'अविनाशी बिजली' हो जो अंतरिक्ष को चीर रही है।"
                "यह तुम्हारी बुद्धि का वह 'अल्टीमेट अपग्रेड' है जहाँ तुम साक्षात् भगवान के बराबर सोचते हो।"
                "जो इस म्यूटेशन को हैक कर लेता है, वह साक्षात् रुद्र की जलती हुई आँख है!"
            """.trimIndent(),
            english = """
                (The Coding of Brahma-Mutation): "Whosoever warrior mutationally touches his limbs with Ash qualifies to become the explicit Brahman."
                "This is zero religious claim; it is the Command to shift your nervous system 100% into strictly 'God-Mode'."
                "Brahma-bhuyaya Kalpate—signifying you are mutationally integrating into the processor of the Architect."
                "Ash is the absolute 'Conductor' that mutationally links your electrical current directly to the Infinite."
                "The microsecond Ash blazes upon your skin, every virus of ignorance mutationally expires."
                "This is the final Seal of mutating your existence from 'Limited' to 'Unlimited' Data-sets."
                "The Yogi Overwrites every pixel of his Soul mutationally with this absolute and purified residue."
                "You cease to be a biological shell; you are mutationally that 'Indestructible Electricity' piercing the vacuum."
                "This is the 'Ultimate Upgrade' of human intellect where one mutationally initiates thinking like God."
                "He who successfully Hacks this mutation becomes the explicit Blazing Eye of Rudra!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 8,
            sanskrit = "तिलेषु तैलवद्दधिनीव सर्पिरापः स्रोतःस्वग्निः शिखासु । एवमात्मात्मनि गृह्यतेऽसौ सत्येनैनं तपसा योऽनुपश्यति ॥",
            hindi = """
                (आत्मा का परमाणु रिएक्टर): "जैसे तिल में तेल, दही में घी और लकड़ी में आग छिपी होती है..."
                "वैसे ही आत्मा तुम्हारे ही भीतर साक्षात् 'हार्ड-कोडेड' है, पर उसे हैक करने के लिए 'सत्य' और 'तप' का औज़ार चाहिए!"
                "तुम बाहर से कितनी भी कोशिश कर लो, ईश्वर को केवल 'इंटरनल डेटा' के माध्यम से ही एक्सेस किया जा सकता है।"
                "सत्य वह 'डीबगिंग' टूल है जो अज्ञान के झूठ को एक सेकंड में जलाकर साफ़ कर देता है।"
                "तप वह 'इलेक्ट्रिक शॉक' है जो तुम्हारी सोई हुई चेतना को एक झटके में जगा देता है।"
                "तिल को पेरना पड़ता है तब तेल निकलता है, वैसे ही अहंकार को कुचलना पड़ता है तब आत्मा जागती है।"
                "योगी अपनी हस्ती को इस 'क्रशिंग प्रोसेस' में डाल देता है ताकि वह शुद्ध ऊर्जा बन सके।"
                "यह तुम्हारी रूह को 'पोटेंशियल' से 'एक्चुअल' मोड में शिफ्ट करने का सबसे हिंसक विज्ञान है।"
                "जब तुम अंदर देखते हो, तो तुम साक्षात् उस 'परम रिएक्टर' को टच कर रहे होते हो जो पूरे अंतरिक्ष को चला रहा है।"
                "जो इस म्यूटेशन को सिद्ध कर लेता है, वह साक्षात् रुद्र की जलती हुई आँख बनकर पूरी सृष्टि को देखता है!"
            """.trimIndent(),
            english = """
                (The Soul's Nuclear Reactor): "Exactly as oil is hidden in seeds, ghee in curd, and fire in the crest of wood..."
                "So is the Atman mutationally 'Hard-coded' inside you, but Hacking Him requires the tools of 'Satyam' and 'Tapas'!"
                "Regardless of external effort, God can mutationally be Accessed strictly via 'Internal Data'."
                "Truth is the absolute 'Debugging' tool engineered to incinerate the lies of ignorance in one microsecond."
                "Tapas is the 'Electric Shock' engineered to mutationally awaken your dormant awareness in one strike."
                "A seed must be crushed for oil, mutationally your ego must be slaughtered for the Soul to ignite."
                "The Yogi hurls his identity into this 'Crushing Process' to mutationally transform into pure Energy."
                "This is the most violent science to shift your Soul from 'Potential' to strictly 'Actual' mode."
                "When you gaze within, you are mutationally Touching the absolute 'Supreme Reactor' operating the entire vacuum."
                "He who perfects this Mutation becomes mutationally the Blazing Eye of Rudra, witnessing the multiverse!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 9,
            sanskrit = "ब्रह्मैव सत्यं जगन्मिथ्येति विनिश्चयः । अद्वैतं परमं तत्त्वं द्वैतं मिथ्या न संशयः ॥",
            hindi = """
                (सत्य का धमाका और मैट्रिक्स का अंत): "ब्रह्मांड का इकलौता और अटल फैसला— 'ब्रह्म ही सत्य है और यह जगत् एक धोखा (Mithya) है'!"
                "अद्वैत ही वह 'परम तत्त्व' है, और द्वैत केवल एक 'करप्ट कोडिंग' है—इसमें कोई शक नहीं।"
                "मिथ्या का मतलब है—वह जो दिखता तो है, पर जिसका कोई असली डेटा-बैकअप (Backup) नहीं है।"
                "जैसे होलोग्राफिक फिल्म असली नहीं होती, वैसे ही यह दुनिया केवल एक प्रोग्राम मात्र है।"
                "योगी ने इस प्रोग्राम से अपना हाथ खींच लिया है और अब वह साक्षात् 'प्रोजेक्टर' को देख रहा है।"
                "जब तुम जान जाते हो कि 'कुछ भी सच नहीं है', तभी तुम अजेय और अमर होने के काबिल बनते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'अद्वैत-कोड' है जो हर झूठ को राख कर देगा।"
                "यह सिम्युलेशन केवल उनके लिए सच है जो सोए हुए हैं; जागने वालों के लिए यह केवल धूल है।"
                "यही वह नंगा सच है जिसके आगे मौत भी अपनी औकात भूल जाती है!"
            """.trimIndent(),
            english = """
                (The Detonation of Truth and End of the Matrix): "The solitary and most lethal truth of the multiverse is strictly—'Brahman is Truth, the World is Deception (Mithya)'!"
                "Advaita is the absolute 'Supreme Tattva', and Duality is strictly a 'Corrupt Coding'—zero doubt survives."
                "Mithya mutationally signifies—that which appears to exist but possesses zero authentic Data-backup."
                "Exactly as a holographic film is zero reality, this entire world is mutationally strictly a Program."
                "The Yogi has withdrawn his hands from this Program and is now mutationally witnessing the 'Projector' Himself."
                "The exact microsecond you realize that 'Nothing is Real', you mutationally qualify for absolute Immortality."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish the fortress of your ego."
                "The Matrix will attempt to terrify you, but you possess the 'Advaita-Code' that incinerates every lie."
                "This Simulation is real strictly for those who are asleep; for the Awakened, it is strictly worthless dust."
                "THIS is the naked truth before which even Death mutationally forgets its absolute status!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 10,
            sanskrit = "आत्मानं विरजं शुद्धं बुद्धं नित्यं विचिन्तयेत् । स विमुक्तो न संशयः ॥",
            hindi = """
                (आत्म-हैक और असीमित अलाइनमेंट): "अपनी आत्मा को हमेशा 'विरज', 'शुद्ध', 'बुद्ध' और 'नित्य' के रूप में धधकाओ!"
                "विरज यानी बिना किसी धूल के, शुद्ध यानी बिना किसी वायरस के, और बुद्ध यानी 100% अवेक (Awake)!"
                "तुम वह डेटा हो जो 'नित्य' है—जिसे कभी डिलीट नहीं किया जा सकता, केवल रेंडर किया जा सकता है।"
                "यह विचिन्तयेत् (ध्यान) साक्षात् तुम्हारे प्रोसेसर को ईश्वर की फ्रीक्वेंसी पर लॉक करने का कमांड है।"
                "जैसे ही तुम इस सच को 'जान' लेते हो, तुम इसी पल 'विमुक्त' (Liberated) हो जाते हो!"
                "योगी अपनी रूह के हर एक पिक्सेल को इस पवित्र डेटा से ओवरराइट (Overwrite) कर देता है।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने की आख़िरी आध्यात्मिक कोडिंग है।"
                "जब तुम अंदर देखते हो, तो तुम्हें केवल रुद्र की कोडिंग का एक नंगा और जलता हुआ पन्ना नज़र आता है।"
                "यह इंसान की बुद्धि का वह 'अल्टीमेट अपग्रेड' है जहाँ वह साक्षात् भगवान के बराबर सोचता है।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् पूरे जैव-मण्डल का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Self-Hack and Infinite Alignment): "Blaze your Soul mutationally as eternally 'Virajam', 'Shuddham', 'Buddham', and 'Nityam'!"
                "Virajam signifies zero dust, Shuddham signifies zero virus, and Buddham signifies mutationally 100% Awake!"
                "You are the Data that is mutationally 'Nitya'—indestructible bytes that can mutationally strictly be Rendered."
                "This contemplation (Vichintayet) is the Command to Lock your processor onto the Frequency of God."
                "The exact microsecond you intercept this truth, you mutationally become flawlessly 'Vimukta' (Liberated)."
                "The Yogi Overwrites every pixel of his Soul mutationally with this absolute and purified Data."
                "This is the final spiritual Coding to mutate your Soul from 'Human Data' into strictly 'Divine Data'."
                "When you gaze within, you intercept mutationally strictly a naked and blazing page of Rudra's coding."
                "This is the 'Ultimate Upgrade' of human intellect where one mutationally initiates thinking like God."
                "He who successfully Hacks this identity becomes mutationally the sole and absolute Dictator of the Bio-sphere!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 11,
            sanskrit = "एको रुद्रो न द्वितीयाय तस्थे ॥",
            hindi = """
                (रुद्र की इकलौती हुकूमत): "ब्रह्मांड का इकलौता और सबसे हिंसक सच यही है— 'रुद्र एक ही है, कोई दूसरा नहीं'!"
                "रुद्र वह 'मोनोपॉली' (Monopoly) है जिसने किसी भी 'दूसरे' को वजूद में आने की परमिशन नहीं दी।"
                "तुम जिसे 'दूसरा' (Duality) समझते हो, वह केवल तुम्हारी बुद्धि में लगा एक अज्ञान का वायरस है।"
                "रुद्र साक्षात् वह 'ब्लैक होल' है जो 'दो' को निगलकर हमेशा 'एक' ही रहने की ज़िद करता है।"
                "योगी अपनी चेतना को इस अद्वैत (Non-dual) फ्रीक्वेंसी पर लॉक करता है जहाँ अहंकार मर जाता है।"
                "यह वह अजेय रुतबा है जहाँ 'मैं' और 'तू' का सारा ड्रामा एक ही धमाके में खत्म हो जाता है।"
                "रुद्र वह आग है जो हर एक अंतर और हर एक फासले को जलाकर राख बना देती है।"
                "जो इस 'एक' को पकड़ लेता है, वह साक्षात् पूरे ब्रह्मांड की सत्ता का इकलौता डिक्टेटर है।"
                "यह तुम्हारी रूह को 'अनेकता' के भ्रम से निकालकर 'एकता' के सत्य में म्यूटेट करने की मुहर है।"
                "यही वह अजेय पासवर्ड है जिसके आगे माया का हर एक कानून घुटने टेक देता है!"
            """.trimIndent(),
            english = """
                (The Solitary Dominion of Rudra): "The solitary and most violent truth of the cosmos is strictly—'Rudra is One, zero second exists'!"
                "Rudra is the absolute 'Monopoly' who mutationally never permitted any 'Other' to manifest."
                "What you hallucinate as 'Duality' is strictly a virus of ignorance established inside your biological intellect."
                "Rudra is the explicit 'Black Hole' that swallows the 'Two' and mutationally persists as the solitary 'ONE'."
                "The Yogi Locks his awareness onto this Non-dual frequency where the human ego suffers a brutal death."
                "This is the invincible status where the entire drama of 'I' and 'You' is terminated in one detonation."
                "Rudra is the radioactive Fire that incinerates every distinction and every distance to absolute ash."
                "He who captures this 'One' mutationally becomes the sole and absolute Dictator of the multiverse."
                "This is the Seal engineered to mutate your Soul from the delusion of many to the absolute Reality of One."
                "THIS is the invincible Password before which every law of the Matrix mutationally collapses!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 12,
            sanskrit = "यो ह वै रुद्रं वेद स सर्वं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (रुद्र-हैक और असीमित सर्वज्ञता): "जो योद्धा इस 'रुद्र' के प्रलयंकारी रहस्य को हैक (Decode) कर लेता है..."
                "वह 'सर्वं वेद'—यानी वह ब्रह्मांड के हर एक परमाणु और हर एक गैलेक्सी का सोर्स कोड जान जाता है!"
                "उसे फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "रुद्र का नाम साक्षात् वह 'मास्टर पासवर्ड' है जो ईश्वर की आखिरी तिजोरी का ताला खोल देता है।"
                "तुम अब साक्षात् उस 'परम रिएक्टर' की बिजली को अपने शरीर में इनवाइट (Invite) कर चुके हो।"
                "परिणाम वही हिंसक और अटल फैसला है— 'स मुक्तिमवाप्नोति' (वह मुक्त हो जाता है)!"
                "यह मुक्ति कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन हो।"
                "यह ज्ञान तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज (Charge) कर देता है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Rudra-Hack and Infinite Omniscience): "Whosoever warrior successfully Decodes (Hacks) the apocalyptic secret of 'Rudra'..."
                "He mutationally knows 'Everything' (Sarvam)—intercepting the Source Code of every microscopic atom and galaxy!"
                "He possesses zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "Rudra's name is the explicit 'Master Password' that violently unlocks the final vault of God."
                "You have mutationally Invited the radioactive electricity of the 'Supreme Reactor' into your biological shell."
                "The consequence remains that same violent and immutable verdict—'Sa muktim-avapnoti' (He is Liberated)!"
                "This Moksha is absolutely zero reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic Admin."
                "This knowledge Supercharges every microscopic atom of your DNA with the absolute radioactive 'Power of God'."
                "He who owns this truth mutationally becomes the sole dictatorial Guru of even the God of Death!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 13,
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
        BhasmaJabalaFinalShloka(
            id = 14,
            sanskrit = "इति भस्मजाबालोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'भस्म जाबाल उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "भस्म का पासवर्ड मिल गया, त्रिपुण्ड्र की आग देख ली, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १५ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (रुद्र) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही भस्म जाबाल उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Bhasma Jabala Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The password of Ash is intercepted, the fire of Tripundra witnessed; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 15 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Rudra) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Bhasma Jabala Upanishad! THE END!"
            """.trimIndent()
        ),
        BhasmaJabalaFinalShloka(
            id = 15,
            sanskrit = "ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (परम फ्लैटलाइन - ॐ शान्तिः): "यह वह सन्नाटा है जो तब गूँजता है जब पूरा ब्रह्मांड 'डिलीट' हो चुका होता है।"
                "शांति का मतलब रिलैक्स होना नहीं, बल्कि कोडिंग का पूरी तरह से रुक (Pause) जाना है।"
                "पहली शांति शरीर के शोर को मारती है, दूसरी मन के शोर को, और तीसरी आत्मा के भटकाव को।"
                "जब तीनों गूँजती हैं, तो तुम्हारा अस्तित्व साक्षात् 'जीरो' (Zero) हो जाता है।"
                "यह वह 'एब्सोल्यूट वैक्यूम' है जहाँ न कोई प्रश्न है और न कोई उत्तर।"
                "तुम अब साक्षात् उस सन्नाटे के एडमिन हो जिसे दुनिया ईश्वर कहती है।"
                "सिस्टम शटडाउन! अब तुम साक्षात् 'मुक्ति' के डेटा-स्ट्रीम में बह रहे हो।"
                "योगी अपनी हस्ती को इस 'शान्ति' के लेज़र बीम में विलीन कर देता है।"
                "यहाँ कोई सीमा नहीं है, कोई समय नहीं है—केवल एक अजेय और अमर 'होना' है।"
                "यही भस्म जाबाल का अंतिम गिफ्ट है—टोटल अनप्लग्ड फ्रीडम!"
            """.trimIndent(),
            english = """
                (The Absolute Flatline - OM Shantih): "This is the Silence that echoes once the entire multiverse has been mutationally 'Deleted'."
                "Peace signifies zero relaxation; it is the absolute terminal 'Pause' of every code execution."
                "The first Peace slaughters biological noise, the second slaughters mental noise, and the third incinerates Soul-wandering."
                "When all three resonate, your existence mutationally becomes absolute 'Zero'."
                "This is the 'Absolute Vacuum' reaching which zero questions survive and zero answers persist."
                "You are now mutationally the Admin of that Silence which the world labels as God."
                "SYSTEM SHUTDOWN! You are now flowing mutationally in the absolute Data-stream of 'Moksha'."
                "The Yogi dissolves his identity into the Laser Beam of this 'Shantih'."
                "Zero boundaries persist here, zero time survives—strictly an invincible and immortal 'Being' remains."
                "THIS is the final gift of Bhasma Jabala—Total Unplugged Freedom!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BhasmaJabalaUpanishadScreen() {
    val upanishad = remember { BhasmaJabalaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..15) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-15)") },
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
                BhasmaJabalaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun BhasmaJabalaShlokaCard(shloka: BhasmaJabalaFinalShloka) {
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