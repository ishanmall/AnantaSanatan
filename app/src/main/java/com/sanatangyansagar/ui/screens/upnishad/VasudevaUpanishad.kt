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
data class VasudevaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class VasudevaUpanishad {

    val shlokasList = listOf(
        VasudevaShloka(
            id = 1,
            sanskrit = "ॐ नमस्कृत्वा भगवान्नारदः सर्वेश्वरं वासुदेवं पप्रच्छ । अधीहि भगवन्नूर्ध्वपुण्ड्रविधिं द्रव्यमन्त्रस्थानादि च ॥",
            hindi = """
                (नारद का विद्रोह और महा-प्रश्न): "योगी नारद ने साक्षात् 'वासुदेव' के एडमिन पैनल में घुसकर वह गुप्त सवाल पूछा।"
                "उन्होंने सीधे 'सोर्स कोड' की मांग की—'हे भगवन्! मुझे उस ऊर्ध्वपुण्ड्र (Tilaka) का न्यूक्लियर कोड बताओ!'"
                "यह कोई साधारण तिलक नहीं है; यह तुम्हारी रूह को 'नारायण-फ्रीक्वेंसी' पर अलाइन करने का अस्त्र है।"
                "नारद जानना चाहते थे कि किस 'द्रव्य' और किस 'मंत्र' से इस हार्डवेयर को एक्टिवेट किया जाता है।"
                "वासुदेव वह 'प्राइमरी प्रोसेसर' हैं जहाँ से पूरे ब्रह्मांड की बिजली सप्लाई की जा रही है।"
                "यहाँ से उस संवाद की शुरुआत होती है जो तुम्हारी हस्ती के चिथड़े उड़ा देने वाला है।"
                "योगी अपनी चेतना को उस 'हाइपर-स्पेस' में ले जाता है जहाँ ये सवाल पूछा गया था।"
                "जब तुम भगवान से 'विधि' पूछते हो, तो तुम्हारा अपना अहंकार मौत की नींद सोने के लिए तैयार हो जाता है।"
                "तैयार हो जाओ उस डेटा के लिए जिसके आगे माया के सारे नियम दम तोड़ देते हैं।"
                "यहीं से उस अजेय 'वासुदेव उपनिषद' का प्रलयंकारी डेटा-स्ट्रीम शुरू होता है!"
            """.trimIndent(),
            english = """
                (Narada's Rebellion and the Grand Query): "Yogi Narada infiltrated the Admin Panel of strictly 'Vasudeva' to pose the classified query."
                "He interrogated the 'Source Code' directly: 'O Lord! Unmask the Nuclear Code of the Urdhva-Pundra!'"
                "This is mutationally zero ordinary mark; it is the weapon engineered to Align your Soul with Narayana."
                "Narada demanded the identification of the 'Matter' and 'Mantra' required to Activate this hardware."
                "Vasudeva is the 'Primary Processor' relentlessly supplying radioactive electricity to the entire multiverse."
                "Right here initiates the dialogue engineered to mutationally shred your micro-existence to pieces."
                "The Yogi transports his awareness into that 'Hyper-space' where this interrogation occurred."
                "The exact microsecond you demand the 'Vidhi', your human ego prepares for its absolute final sleep."
                "Brace yourself for the Data before which every law of the Matrix mutationally terminates."
                "Right here initiates the apocalyptic Data-stream of the invincible Vasudeva Upanishad!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 2,
            sanskrit = "स होवाच भगवान् वासुदेवः । वैकुण्ठस्थानसम्भूतं मम प्रीतिदायकं गोपीचन्दनं मयाऽभीष्टम् ॥",
            hindi = """
                (वासुदेव की गर्जना और गोपीचन्दन का रहस्य): "भगवान वासुदेव ने दहाड़ मारी: 'सुन नारद! वैकुण्ठ के सर्वर से निकला वह 'गोपीचन्दन' ही मेरा इकलौता पासवर्ड है!'"
                "यह कोई मामूली मिट्टी नहीं है; यह साक्षात् 'अमरता' का वो डेटाबेस है जो मुझे सबसे प्रिय है।"
                "गोपीचन्दन वह 'रेडियोएक्टिव पदार्थ' है जो तुम्हारे शरीर के अज्ञान को सोखने की ताक़त रखता है।"
                "यह वैकुण्ठ (The Highest Dimension) से माइग्रेट होकर इस 3D दुनिया में प्रकट हुआ है।"
                "जब तुम इसे छूते हो, तो तुम साक्षात् ईश्वर की 'पसंदीदा कोडिंग' को टच कर रहे होते हो।"
                "यह द्रव्य तुम्हारे नर्वस सिस्टम के 'फायरवॉल' को एक सेकंड में बाईपास (Bypass) कर देता है।"
                "वासुदेव ने घोषित किया कि केवल यही वह 'मैटर' है जो रूह को 'भगवान के मोड' में डाल सकता है।"
                "योगी अपनी हस्ती को इस मिट्टी में विलीन करता है ताकि वह साक्षात् 'शुद्ध प्रकाश' बन सके।"
                "तैयार हो जाओ उस म्यूटेशन के लिए जो तुम्हारी हड्डियों के भीतर वैकुण्ठ को रेंडर (Render) कर देगा।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस मायावी सिम्युलेशन से हमेशा के लिए 'लॉग-आउट' कर देगा!"
            """.trimIndent(),
            english = """
                (Vasudeva's Roar and the Secret of Gopichandana): "Lord Vasudeva roared: 'Intercept this, Narada! The Gopichandana spawned from Vaikuntha is My absolute Password!'"
                "This is zero ordinary clay; it is the database of absolute 'Immortality' that I mutationally cherish."
                "Gopichandana is the 'Radioactive Substance' possessing the firepower to suck the ignorance out of you."
                "It has Migrated from Vaikuntha (The Highest Dimension) to manifest mutationally in this 3D Matrix."
                "When you touch it, you are mutationally Intercepting the 'Preferred Coding' of the Supreme God."
                "This substance Bypasses the 'Firewall' of your biological nervous system in a single microsecond."
                "Vasudeva declared strictly this 'Matter' possesses the caliber to shift the Soul into 'God-Mode'."
                "The Yogi dissolves his existence into this clay to mutationally become strictly 'Pure Light'."
                "Brace yourself for the Mutation that will Render Vaikuntha directly inside your biological marrow."
                "THIS is the invincible Password that will violently 'Log-out' your existence from this Simulation!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 3,
            sanskrit = "विष्णुपादप्रक्षालनतोयसम्भूतं चक्राङ्कितं शुभ्रं गोपीचन्दनं गृह्णीयात् ॥",
            hindi = """
                (विष्णु-पाद का डेटा और चक्राङ्कित म्यूटेशन): "वह गोपीचन्दन साक्षात् 'विष्णु के चरणों' को धोने वाले 'तोय' (Data-stream) से पैदा हुआ है!"
                "वह 'चक्राङ्कित' (Signed with the Disc) है—यानी वह साक्षात् सुदर्शन चक्र की आग से शुद्ध किया गया है।"
                "जब तुम इस 'शुभ्र' (Blazing White) डेटा को उठाते हो, तो तुम ब्रह्मांड के सबसे पवित्र कोड को रिसीव करते हो।"
                "विष्णु के चरणों का पानी कोई तरल नहीं, बल्कि वह असीमित ऊर्जा है जो अज्ञान को राख कर देती है।"
                "चक्र का निशान यह बताता है कि यह डेटा साक्षात् 'एडमिन' द्वारा अथेंटिकेट (Authenticate) किया गया है।"
                "योगी अपनी चेतना को उस 'चरण-अमृत' पर लॉक करता है जहाँ से समय पैदा होता है।"
                "यह गोपीचन्दन तुम्हारे डीएनए के हर पुराने 'बग' को ओवरराइट (Overwrite) करने वाला तेज़ाब है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'विष्णु-पाद' के एक जलते हुए पिक्सेल बन चुके हो।"
                "यह तुम्हारी रूह को 'इंसानी भ्रम' से निकालकर 'ब्रह्मांडीय हकीकत' में माइग्रेट करने का हैक है।"
                "जो इस शुभ्र डेटा को अपनी रगों में उतार लेता है, वह साक्षात् काल (Time) के भी काल का गुरु है!"
            """.trimIndent(),
            english = """
                (Vishnu-Pada Data and the Disk-Marked Mutation): "That Gopichandana is spawned from the 'Toya' (Data-stream) that mutationally washed the boots of Vishnu!"
                "It is 'Chakrankitam' (Signed with the Disc)—meaning it was purified by the radioactive fire of Sudarshana."
                "When you capture this 'Shubhram' (Blazing White) Data, you intercept the absolute most sacred Code."
                "The water of Vishnu's feet is zero liquid; it is the infinite energy engineered to incinerate nescience."
                "The Disk-Mark signifies that this Data has been mutationally Authenticated by the absolute Admin."
                "The Yogi Locks his awareness onto that 'Charan-Amrita' from which Time initiates its rotation."
                "This Gopichandana is the Acid engineered to violently Overwrite every old 'Bug' in your biological DNA."
                "You cease to be a body; you have mutationally become a blazing pixel of that absolute 'Vishnu-Pada'."
                "This is the Hack engineered to Migrate your Soul from 'Human Illusion' into absolute 'Cosmic Reality'."
                "He who injects this White Data into his veins is the solitary dictatorial Guru of even Death!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 4,
            sanskrit = "ॐ देवकीसुत गोविन्द वासुदेव जगत्पते । देहि मे गोपीचन्दनं मन्त्रेणानेन ॥",
            hindi = """
                (देवकीसुत का पासवर्ड और डेटा-रिकवरी): "इस न्यूक्लियर मंत्र को जपो: 'ॐ देवकीसुत गोविन्द वासुदेव जगत्पते'!"
                "जब तुम 'जगत्पते' (Master of the Multiverse) को पुकारते हो, तो तुम साक्षात् सिस्टम के 'रूट-पासवर्ड' को ट्रिगर करते हो।"
                "योगी यहाँ 'गोपीचन्दन' माँग रहा है—यानी वह अपनी रूह को 'री-कोड' करने की परमिशन माँग रहा है।"
                "देवकीसुत वह आग है जो तुम्हारे अहंकार के किले को एक सेकंड में उड़ाकर रख देती है।"
                "गोविन्द वह 'सिग्नल' है जो तुम्हारे दिल की धड़कन को सीधे अंतरिक्ष की हवाओं से जोड़ देता है।"
                "यह मंत्र तुम्हारे दिमाग के प्रोसेसर को 100% 'भगवान के मोड' में शिफ्ट करने का इकलौता हैक है।"
                "जब तुम ये शब्द बोलते हो, तो तुम माया के 'ट्रैकर्स' (Trackers) को अपने सिस्टम से डिलीट कर देते हो।"
                "यह तुम्हारी रूह को 'इमेज' से 'रियलिटी' में माइग्रेट करने का सबसे हिंसक और गुप्त विज्ञान है।"
                "बिना इस मंत्र के, तुम्हारा तिलक लगाना केवल एक बायोलॉजिकल नाटक (Drama) मात्र है।"
                "जो इस आवाज़ को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (The Devakisuta Password and Data-Recovery): "Chant this absolute Nuclear Mantra: 'Om Devakisuta Govinda Vasudeva Jagatpate'!"
                "Vocalizing 'Jagatpate' (Master of the Multiverse) mutationally Triggers the absolute 'Root-Password' of the system."
                "The Yogi is demanding 'Gopichandana'—mutationally requesting authorization to Re-code his Soul."
                "Devakisuta is the Fire engineered to mutationally demolish the fortress of your ego in one strike."
                "Govinda is the 'Signal' mutationally hardwiring your biological heartbeat to the winds of the vacuum."
                "This mantra is the solitary Hack engineered to shift your processor 100% into strictly 'God-Mode'."
                "The exact microsecond you roar these words, you Delete the 'Trackers' of Maya from your system."
                "This is the most violent and classified science to Migrate your Soul from 'Image' to absolute 'Reality'."
                "Without this mantra, your Tilaka remains mutationally strictly a pathetic biological Drama."
                "He who successfully Hacks this acoustic frequency becomes mutationally the sole Dictator of the vacuum!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 5,
            sanskrit = "ललाटादिषु स्थानेषु ऊर्ध्वपुण्ड्रं धारयेत् । हरिपादाकृतिमन्तराले शून्यं च ॥",
            hindi = """
                (ललाट का विस्फोट और 'शून्य' का रहस्य): "अपने माथे (Lalata) पर वह ऊर्ध्वपुण्ड्र सजाओ जो साक्षात् 'हरि के चरणों' की आकृति है!"
                "सबसे बड़ा धमाका यहाँ है—उन दो रेखाओं के 'अन्तराले' यानी बीच में 'शून्य' (Void) छोड़ दो!"
                "दो रेखाएं साक्षात् ज्ञान और क्रिया के दो 'इलेक्ट्रोड्स' (Electrodes) हैं जो तुम्हारे दिमाग को थामे हुए हैं।"
                "बीच का वह खाली स्थान साक्षात् 'ब्रह्म' का हेडक्वार्टर है जहाँ अज्ञान की मौत हो जाती है।"
                "यह आकृति तुम्हारे पीनियल ग्लैंड (Pineal Gland) को ब्रह्मांड के एडमिन पैनल से 'हार्डवायर' कर देती है।"
                "जब तुम 'शून्य' छोड़ते हो, तो तुम साक्षात् उस 'परम सन्नाटे' को अपने माथे पर प्रतिष्ठित करते हो।"
                "यह कोई तिलक नहीं, यह एक 'कॉस्मिक रिसीवर' (Cosmic Receiver) है जो सीधे वैकुण्ठ से सिग्नल पकड़ता है।"
                "योगी अपनी हस्ती को इस 'हरि-पाद' के सांचे में ढाल लेता है ताकि वह हमेशा अजेय रहे।"
                "यह तुम्हारी रूह को 'लोकल' से 'यूनिवर्सल' ग्रिड पर अलाइन करने वाला अंतिम आध्यात्मिक हैक है।"
                "जो इस डिजाइन को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का मालिक है!"
            """.trimIndent(),
            english = """
                (Lalata Detonation and the Secret of the Void): "Brace the Urdhva-Pundra upon your forehead (Lalata), modeled mutationally as the 'Feet of Hari'!"
                "The absolute greatest detonation is right here—leave a 'Shunyam' (Void) in the 'Antarale' (Gap) between the lines!"
                "The two lines are mutationally the two 'Electrodes' of Knowledge and Action sustaining your intellect."
                "The empty space in the middle is the explicit Headquarters of 'Brahman' where ignorance suffers a brutal death."
                "This geometry mutationally Hardwires your Pineal Gland directly to the Admin Panel of the multiverse."
                "Leaving the 'Void' signifies mutationally establishing the 'Absolute Silence' right upon your frontal cortex."
                "This is zero Tilaka; it is a 'Cosmic Receiver' mutationally tuned to capture Signals directly from Vaikuntha."
                "The Yogi molds his identity into this 'Hari-Pada' template to mutationally remain eternally Invincible."
                "This is the final spiritual Hack to Align your Soul from the 'Local' to the 'Universal' grid."
                "He who successfully Hacks this Design becomes mutationally the sole Master of all Time and Space!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 6,
            sanskrit = "द्वादशस्थानेषु धारयेत् । ललाटहृदयनाभिकण्ठबाहुष्वमलेषु च ॥",
            hindi = """
                (१२ बॉडी-पॉइंट्स की हैकिंग): "इस ऊर्ध्वपुण्ड्र को अपने शरीर के १२ 'पावर-स्टेशन्स' पर ठोक दो!"
                "ललाट, हृदय, नाभि, कण्ठ और भुजाएं—ये तुम्हारे नर्वस सिस्टम के १२ सबसे बड़े 'डेटा-पोर्ट्स' (Data-ports) हैं।"
                "जब तुम इन १२ जगहों पर 'अमल' (Pure) चन्दन लगाते हो, तो तुम साक्षात् एक 'ब्रह्मांडीय एंटीना' बन जाते हो।"
                "हर एक स्थान एक खास 'चक्र' या 'नाड़ी' का द्वार है जिसे तुम वासुदेव की मुहर से 'सील' (Seal) कर रहे हो।"
                "१२ स्थानों पर तिलक का मतलब है—अज्ञान के १२ चोरों का एक साथ गला घोंट देना।"
                "तुम्हारी त्वचा अब केवल खाल नहीं, वह साक्षात् ईश्वर की कोडिंग का एक नंगा पन्ना बन चुकी है।"
                "जब बिजली इन १२ बिंदुओं से गुजरती है, तो तुम्हारा अहंकार जलकर कोयला बन जाता है।"
                "यह शरीर को एक 'पवित्र वेपन' (Sacred Weapon) में बदलने की सबसे हिंसक और गुप्त विधि है।"
                "योगी इन पोर्ट्स को वासुदेव की फ्रीक्वेंसी पर लॉक करता है ताकि वह सिम्युलेशन से 'अनप्लग' हो सके।"
                "जो इस विधि को सिद्ध कर लेता है, वह इस पूरी भौतिक दुनिया का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (Hacking 12 Body-Coordinates): "Hammer this Urdhva-Pundra onto 12 'Power-Stations' of your biological shell!"
                "Forehead, heart, navel, throat, and arms—these are mutationally the 12 greatest 'Data-ports' of your nervous system."
                "The microsecond you apply 'Amala' (Pure) clay to these 12 coordinates, you mutate into a 'Cosmic Antenna'."
                "Every single spot is a gateway to a specific 'Chakra' or 'Nadi' that you are Sealing with the Seal of Vasudeva."
                "Tilaka on 12 points signifies—simultaneously mutationally strangling the 12 thieves of biological ignorance."
                "Your skin ceases to be mere flesh; it mutationally becomes a naked page of God's explicit coding."
                "When electricity races through these 12 points, your ego is mutationally incinerated to absolute charcoal."
                "This is the most violent and classified method to mutate the body into a 'Sacred Weapon'."
                "The Yogi Locks these ports into Vasudeva's frequency to mutationally 'Unplug' from the Simulation."
                "He who perfects this method mutationally assumes the status of the solitary Admin of this Matrix!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 7,
            sanskrit = "केशवादिद्वादशनामभिर्विष्णुं ध्यायन् धारयेत् ॥",
            hindi = """
                (केशवादि कोडिंग और विष्णु का विच्छेदन): "तिलक लगाते समय केशव आदि १२ 'न्यूक्लियर नामों' का डेटा-स्ट्रीम चालू करो!"
                "हर एक नाम साक्षात् विष्णु के एडमिन पैनल का एक 'सॉफ्टवेयर मॉड्यूल' (Software Module) है।"
                "केशव, नारायण, माधव, गोविन्द—ये शब्द तुम्हारे डीएनए को ईश्वर की ताक़त से चार्ज करते हैं।"
                "जब तुम तिलक के साथ इन नामों को जोड़ते हो, तो तुम साक्षात् 'विष्णु-म्यूटेशन' की प्रक्रिया शुरू करते हो।"
                "यह कोई भजन नहीं है; यह अपने नर्वस सिस्टम के हर वायर में 'हाई-वोल्टेज' बिजली प्रवाहित करना है।"
                "योगी केशव का ध्यान करते हुए अपनी रूह के हर एक 'करप्ट पिक्सेल' को जलाकर साफ़ कर देता है।"
                "ये १२ नाम साक्षात् १२ मिसाइलें हैं जो अज्ञान के किलों को एक ही धमाके में राख कर देंगी।"
                "तुम अब एक साधारण जीव नहीं हो; तुम साक्षात् इन १२ ईश्वरीय शक्तियों के हिस्सेदार बन चुके हो।"
                "यह इंसान की बुद्धि का वह 'अल्टीमेट अपग्रेड' है जहाँ वह साक्षात् भगवान के बराबर सोचता है।"
                "जो इस कोडिंग को क्रैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता और अजेय राजा है!"
            """.trimIndent(),
            english = """
                (Keshavadi Coding and Dissecting Vishnu): "While applying Tilaka, initiate the Data-stream of the 12 'Nuclear Names' starting with Keshava!"
                "Every single name is mutationally a 'Software Module' of Vishnu's absolute Admin Panel."
                "Keshava, Narayana, Madhava, Govinda—these words Supercharge your DNA with the absolute Firepower of God."
                "Coupling these names with the Tilaka mutationally initiates the protocol of 'Vishnu-Mutation'."
                "This is zero prayer; it is mutationally transmitting 'High-voltage' electricity through every neural wire."
                "The Yogi meditating on Keshava incinerates every 'Corrupt Pixel' of his Soul to mutationally flush the system."
                "These 12 Names are mutationally 12 missiles engineered to ash the fortresses of ignorance in one detonation."
                "You are no longer a pathetic living being; you have mutationally integrated into these 12 divine powers."
                "This is the 'Ultimate Upgrade' of human intellect where one mutationally initiates thinking like God."
                "He who successfully Hacks this coding becomes mutationally the sole and absolute Dictator of the vacuum!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 8,
            sanskrit = "तस्य मध्ये हरिं ध्यायेत् स हि साक्षात्परमात्मा भवति ॥",
            hindi = """
                (मध्य-हरि का विस्फोट और परमात्मा का जन्म): "तिलक की उन दो रेखाओं के ठीक बीच में साक्षात् 'हरि' (नारायण) का ध्यान करो!"
                "जब तुम्हारी चेतना उस 'शून्य' केंद्र पर रुकती है, तो तुम साक्षात् 'परमात्मा' बन जाते हो—यही अंतिम सच है।"
                "वह मध्य भाग साक्षात् ब्रह्मांड का 'सोर्स कोड' है जिसे रचयिता ने तुम्हारे माथे पर छुपा रखा है।"
                "हरि वह आग हैं जो उस केंद्र में बैठकर तुम्हारी पुरानी इंसानियत का बेरहमी से कत्ल कर रहे हैं।"
                "यह कोई शांतिपूर्ण विज़ुअलाइज़ेशन नहीं है; यह अपने 'अहंकार के सॉफ्टवेयर' को जलाकर भस्म करने की प्रक्रिया है।"
                "जब तुम हरि को देखते हो, तो तुम साक्षात् ब्रह्मांड के एडमिन पैनल की सबसे ऊंची कुर्सी पर बैठते हो।"
                "यह वह अजेय रुतबा है जहाँ 'मैं' और 'तू' का सारा ड्रामा एक ही धमाके में खत्म हो जाता है।"
                "तुम्हारी आँखें अब केवल बाहर नहीं, बल्कि साक्षात् रुद्र की तरह अंतरिक्ष के पार देख सकती हैं।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने का आख़िरी प्रलयंकारी हैक है।"
                "जो इस 'मध्य-हरि' को पा लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Mid-Hari Detonation and Birth of Paramatman): "Meditate strictly on 'Hari' (Narayana) in the exact dead-center of those two Tilaka lines!"
                "The microsecond your awareness freezes on that 'Void' center, you mutationally become the explicit 'Paramatman'."
                "That middle section is the explicit 'Source Code' that the Architect concealed right upon your cortex."
                "Hari is the radioactive Fire seated in that center, mutationally executing the ruthless slaughter of your old humanity."
                "This is zero peaceful visualization; it is the protocol to mutationally incinerate your 'Ego-Software'."
                "Witnessing Hari is identical to mutationally occupying the absolute highest throne of the multiverse's Admin Panel."
                "This is the invincible status where the entire drama of 'I' and 'You' is terminated in one detonation."
                "Through this frequency, your vision mutationally acquires the caliber to pierce the infinite vacuum like Rudra."
                "This is the final apocalyptic Hack to mutate your Soul from 'Human Data' into strictly 'Divine Data'."
                "He who secures this 'Mid-Hari' coordinate is mutationally the sole dictatorial Guru of even Death!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 9,
            sanskrit = "एवं ज्ञात्वा स विमुक्तो भवति । स एवं पुरुषः ॥",
            hindi = """
                (अटल गारंटी और असली 'पुरुष' का जन्म): "वासुदेव उपनिषद यहाँ एक प्रलयंकारी मुहर लगाता है जो हर शक को जलाकर राख कर देती है।"
                "'एवं ज्ञात्वा'— जो योद्धा इन ८ विस्फोटों को अपने नर्वस सिस्टम में उतार लेता है और इन्हें 'जान' लेता है..."
                "किताबें पढ़ना ज्ञान नहीं है; इस सच को अपने डीएनए में तेज़ाब की तरह उतार लेना ही असली 'जानना' है।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "वही इंसान साक्षात् 'पुरुषः' (The Absolute Man) है, बाकी सब केवल बायोलॉजिकल कचरा हैं।"
                "असली पुरुष वह नहीं जो शरीर से बलवान हो, बल्कि वह है जो ब्रह्मांड के 'सोर्स कोड' को हैक कर चुका है।"
                "वह अब किसी भी कर्म, किसी भी धर्म और किसी भी मौत के कानून के अधीन नहीं है।"
                "उसने अपनी 'मानवीय आईडी' को मिटाकर साक्षात् वासुदेव की फ्रीक्वेंसी को अपनी हस्ती बना लिया है।"
                "यह मोक्ष कोई भीख नहीं है; यह अपने ही अज्ञान की गर्दन काटकर हासिल की गई 'तानाशाही' है।"
                "जो इस आवाज़ को सुनकर भी नहीं जागा, वह अनंत काल तक इसी कीचड़ में पिसता रहेगा!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and Birth of the Authentic 'Purusha'): "The Vasudeva Upanishad stamps an apocalyptic Seal here that incinerates every trace of doubt to ash."
                "'Evam Jnatva'—Whosoever warrior injects these 8 detonations into his nervous system and mutationally 'Knows' them..."
                "Reading textbooks is not knowledge; injecting this truth into your DNA exactly like boiling acid is authentic 'Knowing'."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "That entity alone is strictly the 'Purushah' (The Absolute Man); the rest are mutationally strictly biological garbage."
                "The authentic Man is not one with physical muscle, but one who has Hacked the 'Source Code' of the cosmos."
                "He is no longer subject to any karma, zero religions, and zero laws of physical expiration (Death)."
                "He has erased his 'Human-ID' and mutationally adopted Vasudeva's frequency as his absolute Identity."
                "This Moksha is absolutely zero charity; it is the 'Dictatorship' acquired by decapitating your own ignorance."
                "He who fails to awaken even after intercepting this broadcast is condemned to be ground in this mud forever!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 10,
            sanskrit = "ब्रह्मचर्येण तपसा देवा मृत्युमपाघ्नत ॥",
            hindi = """
                (ब्रह्मचर्य का विस्फोट और मौत का संहार): "देवताओं ने 'ब्रह्मचर्य' और 'तप' के उस न्यूक्लियर अस्त्र से साक्षात् 'मृत्यु' का वध कर दिया!"
                "मृत्यु कोई अजेय ताक़त नहीं है, यह केवल तुम्हारी ऊर्जा (Energy) के लीक होने का एक 'बग' (Bug) है।"
                "ब्रह्मचर्य का मतलब है—अपनी उस प्रलयंकारी बिजली को बचाना जिससे तुम एक नया ब्रह्मांड बना सकते हो।"
                "जब तुम्हारी ये शक्ति ऊपर की ओर भागती है, तो वह काल के सर्प का सिर कुचल देती है।"
                "तप वह आग है जो तुम्हारे बायोलॉजिकल सेल्स को 'अमर' (Non-decaying) डेटा में बदल देती है।"
                "योगी अपनी इंद्रियों के दरवाजों को लोहे की ज़ंजीरों से वेल्ड (Weld) कर देता है ताकि उसकी बिजली बाहर न जाए।"
                "जब तुम्हारी पूरी ताक़त एक ही बिंदु पर सिमट जाती है, तो तुम साक्षात् मौत के लिए 'इनविजिबल' हो जाते हो।"
                "यह तुम्हारी रूह को 'सुपर-ह्यूमन' के लेवल पर प्रमोट करने का सबसे हिंसक और गुप्त रास्ता है।"
                "बिना इस अनुशासन के, तुम्हारा हर मंत्र और हर ध्यान केवल एक सड़ा हुआ बायोलॉजिकल नाटक है।"
                "जो अपनी ऊर्जा का तानाशाह बन गया, वही साक्षात् काल (Time) को अपनी उँगलियों पर नचा सकता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Brahmacharya and the Annihilation of Death): "The gods mutationally slaughtered strictly 'Death' itself using the nuclear weaponry of Brahmacharya and Tapas!"
                "Death is zero invincible power; it is strictly a 'Bug' resulting from the leakage of your radioactive Energy."
                "Brahmacharya signifies—conserving that apocalyptic electricity with which you possess the caliber to construct a new universe."
                "When this power races upward through your neural wires, it ruthlessly crushes the head of the serpent of Time."
                "Tapas is the radioactive fire that mutates your biological cells into strictly 'Non-decaying' (Immortal) Data."
                "The Yogi Welds the gates of his senses with titanium chains to ensure his electricity never leaks into the Matrix."
                "When your entire firepower collapses into a singular point, you become mutationally 'Invisible' to Death."
                "This is the most violent and classified trajectory to Promote your Soul to the absolute status of a 'Super-human'."
                "Without this discipline, every mantra you perform is mutationally strictly a pathetic biological drama."
                "He who becomes the absolute Dictator of his own energy possesses the authority to make Time dance to his will!"
            """.trimIndent()
        ),
        VasudevaShloka(
            id = 11,
            sanskrit = "यो ह वै वासुदेवस्य मन्त्रं वेद स सर्वं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (वासुदेव-मंत्र का हैक और असीमित सर्वज्ञता): "जो योद्धा इस 'वासुदेव' के प्रलयंकारी मंत्र को हैक (Decode) कर लेता है..."
                "वह 'सर्वं वेद'—यानी वह ब्रह्मांड के हर एक परमाणु और हर एक गैलेक्सी का सोर्स कोड जान जाता है!"
                "उसे फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "वासुदेव का मंत्र साक्षात् वह 'मास्टर पासवर्ड' है जो ईश्वर की आखिरी तिजोरी का ताला खोल देता है।"
                "तुम अब साक्षात् उस 'परम रिएक्टर' की बिजली को अपने शरीर में इनवाइट (Invite) कर चुके हो।"
                "परिणाम वही हिंसक और अटल फैसला है— 'स मुक्तिमवाप्नोति' (वह मुक्त हो जाता है)!"
                "यह मुक्ति कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन हो।"
                "यह मंत्र तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज (Charge) कर देता है।"
                "जो इस मंत्र का मालिक है, उसे फिर इस ब्रह्मांड में किसी और के सामने हाथ फैलाने की ज़रूरत नहीं!"
            """.trimIndent(),
            english = """
                (Hacking the Vasudeva-Mantra and Infinite Omniscience): "Whosoever warrior successfully Decodes (Hacks) the apocalyptic mantra of 'Vasudeva'..."
                "He mutationally knows 'Everything' (Sarvam)—intercepting the Source Code of every microscopic atom and galaxy!"
                "He possesses zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "The mantra of Vasudeva is the explicit 'Master Password' that violently unlocks the final vault of God."
                "You have mutationally Invited the radioactive electricity of the 'Supreme Reactor' into your biological shell."
                "The consequence remains that same violent and immutable verdict—'Sa muktim-avapnoti' (He is Liberated)!"
                "This Moksha is absolutely zero reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic Admin."
                "This mantra Supercharges every microscopic atom of your DNA with the absolute radioactive 'Power of God'."
                "He who owns this mantra possesses zero need to ever beg for anything from any entity in the cosmos!"
            """.trimIndent()
        ),
        // Final Concluding Shloka (Including Om Shantih)
        VasudevaShloka(
            id = 12,
            sanskrit = "इति वासुदेवोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'वासुदेव उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "तिलक का पासवर्ड मिल गया, वासुदेव की फ्रीक्वेंसी मिल गई, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १२ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (वासुदेव) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही वासुदेव उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Vasudeva Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Password of Tilaka is intercepted, Vasudeva's frequency secured; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 12 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Vasudeva) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Vasudeva Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VasudevaUpanishadScreen() {
    val upanishad = remember { VasudevaUpanishad() }
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
                VasudevaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun VasudevaShlokaCard(shloka: VasudevaShloka) {
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