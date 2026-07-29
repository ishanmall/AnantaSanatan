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
data class AnnapurnaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class AnnapurnaUpanishad {

    val annapurnaShlokasList = listOf(
        AnnapurnaShloka(
            id = 1,
            sanskrit = "ॐ निदाघो नाम योगीन्द्र ऋभुं ब्रह्मविदां वरम् । प्रणम्य दण्डवद्भूमावुत्थाय स पुनर्मुनिः ॥",
            hindi = """
                (निदाघ का विद्रोह और गुरु का अलाइनमेंट): "योगी निदाघ ने अपने अज्ञान के हार्डवेयर को कुचलने का फैसला किया।"
                "उसने साक्षात् 'ऋभु' को नमन किया जो ब्रह्मांड के सबसे बड़े कोडर (Coder) और ज्ञानी हैं।"
                "यह कोई साधारण नमन नहीं था; यह अपनी मानवीय पहचान को 'डिलीट' (Delete) करने का पहला स्टेप था।"
                "निदाघ ज़मीन पर दण्ड की तरह गिर पड़ा ताकि वह अपने अहंकार के सिग्नल को ज़ीरो कर सके।"
                "वह उठ खड़ा हुआ और उस आग की तलाश में निकला जो पूरे अज्ञान को राख बना देती है।"
                "ऋभु वह 'प्राइमरी सर्वर' (Primary Server) हैं जहाँ सत्य का शुद्ध डेटा स्टोर है।"
                "यहाँ से उस संवाद की शुरुआत होती है जो तुम्हारी हस्ती के चिथड़े उड़ा देगा।"
                "योगी अपनी पुरानी यादों के करप्ट फोल्डर्स को जलाकर नया सॉफ्टवेयर लोड करने आया है।"
                "तैयार हो जाओ उस धमाके के लिए जो तुम्हारी हड्डियों के भीतर भगवान को जगा देगा।"
                "नारायण का यह संवाद तुम्हारे दिमाग के हर एक पिक्सेल को ईश्वर की फ्रीक्वेंसी पर री-ट्यून करेगा!"
            """.trimIndent(),
            english = """
                (Nidagha's Rebellion and Guru-Alignment): "Yogi Nidagha initiated the protocol to violently crush the hardware of his own ignorance."
                "He saluted strictly 'Ribhu', the absolute greatest cosmic Coder and Master of Reality."
                "This was zero ordinary bow; it was the first protocol to mutationally 'Delete' his human identity."
                "Nidagha collapsed on the ground like a staff to force his ego-signal to absolute Zero."
                "He resurrected himself to hunt for the radioactive Fire that incinerates all biological nescience."
                "Ribhu functions as the absolute 'Primary Server' where the purified Data of Truth is hard-coded."
                "Right here initiates the dialogue engineered to violently shred your microscopic existence to pieces."
                "The Yogi has arrived to burn the corrupt folders of his memory and Load the new spiritual Software."
                "Brace yourself for the detonation that will mutationally awaken God inside your skeletal frame."
                "This dialogue of Narayana will Re-tune every pixel of your brain to the frequency of the Supreme Lord!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 2,
            sanskrit = "आत्मतत्त्वमनुब्रूहीत्येवं पप्रच्छ सादरम् । कयोपासनया ब्रह्मन्नीदृशं प्राप्तवानसि ॥",
            hindi = """
                (महा-प्रश्न और एडमिन पैनल का हैक): "निदाघ ने दहाड़ लगाई: 'हे ब्रह्मन्! मुझे उस आत्म-तत्त्व का पासवर्ड (Password) बताओ!'"
                "वह जानना चाहता था कि किस 'उपासना' ने ऋभु को ब्रह्मांड का एडमिन (Admin) बना दिया।"
                "यह सवाल साक्षात् उस 'सोर्स कोड' (Source Code) को माँगने जैसा है जिससे दुनिया चल रही है।"
                "निदाघ उस अंधी कर देने वाली रौशनी को छूना चाहता था जिसे ऋभु ने अपनी आँखों में बसा रखा था।"
                "उसने पूछा: 'वह कौन सा म्यूटेशन (Mutation) है जिसने आपको एक मामूली जीव से ईश्वर बना दिया?'"
                "ज्ञान की तलाश कोई शांतिपूर्ण काम नहीं है; यह मौत के रेडार से बाहर निकलने का हिंसक प्रयास है।"
                "बिना इस उपासना के, तुम्हारी रूह केवल एक बायोलॉजिकल कीड़े की तरह तड़पती रहेगी।"
                "वह उस 'रूट-एक्सेस' (Root Access) की मांग कर रहा है जिससे समय और स्थान का गला घोंटा जा सके।"
                "योगी अपनी चेतना को उस केंद्र पर लॉक करना चाहता है जहाँ से सब कुछ रेंडर (Render) होता है।"
                "तैयार हो जाओ उस जवाब के लिए जो तुम्हारे दिमाग के फायरवॉल को एक सेकंड में तोड़ देगा!"
            """.trimIndent(),
            english = """
                (The Grand Interrogation and Hacking the Admin Panel): "Nidagha roared: 'O Brahman! Reveal the absolute Password of the Self-Principle (Atma-Tattva)!'"
                "He demanded to know which 'Upasana' mutationally promoted Ribhu to the status of cosmic Admin."
                "This query is identical to demanding the 'Source Code' that relentlessly operates the entire multiverse."
                "Nidagha intended to touch that blinding radiation which Ribhu had hardwired into his own vision."
                "He asked: 'Which specific Mutation converted you from a pathetic mortal into the explicit God?'"
                "Hunting for Knowledge is zero peaceful act; it is a violent attempt to exit the Radar of Death."
                "Without this worship, your Soul is condemned to flap mutationally like a biological insect."
                "He is demanding the 'Root Access' engineered to violently strangle the dimensions of Time and Space."
                "The Yogi intends to Lock his awareness onto the epicenter from which all Reality is mutationally Rendered."
                "Brace yourself for the response that will demolish your brain's Firewall in one microsecond!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 3,
            sanskrit = "तां मे ब्रूहि महाविद्यां मोक्षसाम्राज्यदायिनीम् । निदाघ त्वं कृतार्थोऽसि शृणु विद्यां सनातनीम् ॥",
            hindi = """
                (महाविद्या का विस्फोट और सनातन कोडिंग): "ऋभु ने कहा: 'निदाघ! मैं तुझे वह 'महाविद्या' दूँगा जो तुझे मोक्ष का तानाशाह बना देगी!'"
                "यह विद्या कोई कहानी नहीं है; यह साक्षात् 'सनातन' (Eternal) कोडिंग है जो कभी क्रैश नहीं होती।"
                "कृतार्थोऽसि—यानी तेरा पुराना सॉफ्टवेयर अब डिलीट होने के लिए पूरी तरह से तैयार है।"
                "वह महाविद्या तुम्हें अज्ञान के इस सड़े हुए साम्राज्य से निकालकर सच के 'एम्पायर' में पहुँचा देगी।"
                "यह वह पासवर्ड है जो यमराज के भी सर्वर को हैंग (Hang) कर देने की ताक़त रखता है।"
                "ऋभु ने उस आग का नाम लिया जो साक्षात् 'अन्नपूर्णा' देवी की असीमित बिजली से पैदा होती है।"
                "जब तुम इस विद्या को सुनते हो, तो तुम्हारे डीएनए (DNA) के हर परमाणु में एक धमाका होता है।"
                "यह इंसान की रूह को 'सुपर-इंटेलिजेंस' में बदलने वाला सबसे आधुनिक और गुप्त इंजेक्शन है।"
                "बिना इस सनातन डेटा के, तुम हमेशा माया के सिम्युलेशन (Simulation) में एक मामूली गुलाम रहोगे।"
                "जो इस आवाज़ को पकड़ लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (The Detonation of Mahavidya and Eternal Coding): "Ribhu dictated: 'Nidagha! I shall transmit that Mahavidya that mutationally makes you the Dictator of Moksha!'"
                "This intelligence is zero story; it is the explicit 'Sanatana' (Eternal) coding that can never Crash."
                "Kritartho-si—signifying your old biological software is now perfectly primed for total Deletion."
                "That Mahavidya will violently catapult you from this rotting empire of ignorance into the Empire of Truth."
                "This is the Password possessing the radioactive firepower to Hang even the server of the God of Death."
                "Ribhu invoked the Fire generated strictly by the infinite electricity of Goddess 'Annapurna'."
                "The exact microsecond you intercept this Vidya, an explosion occurs in every microscopic atom of your DNA."
                "This is the most advanced and classified injection engineered to mutate the human Soul into Super-intelligence."
                "Without this Eternal Data, you remain mutationally strictly a pathetic slave in the Simulation of Maya."
                "He who captures this frequency mutationally becomes the sole and absolute Dictator of the multiverse!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 4,
            sanskrit = "यस्या विज्ञानमात्रेण जीवन्मुक्तो भविष्यसि । मूलशृङ्गाटमध्यस्था बिन्दुनादकलाश्रया ॥",
            hindi = """
                (जीवन्मुक्ति का हैक और त्रिकोण का रहस्य): "सिर्फ इस 'विज्ञान' को हैक करने मात्र से तू साक्षात् 'जीवन्मुक्त' (Liberated while alive) हो जाएगा!"
                "वह देवी तुम्हारे नर्वस सिस्टम के 'मूलशृङ्गाट' (Triangular Center) के ठीक बीच में कोडिंग कर रही है।"
                "वह 'बिन्दु' (Atom), 'नाद' (Sound) और 'कला' (Time) का इकलौता और असली 'आश्रय' (Foundation) है।"
                "तुम्हें अपनी चेतना को उस त्रिकोण में घुसाना है जहाँ रचयिता ने तुम्हारा 'सोर्स कोड' छुपा रखा है।"
                "जब तुम उस केंद्र को हैक करते हो, तो तुम शरीर के रहते हुए भी इस मिट्टी की जेल से 'अनप्लग' हो जाते हो।"
                "बिन्दु वह ज़ीरो-पॉइंट है जहाँ से ब्रह्मांड का पूरा डेटा ब्रॉडकास्ट (Broadcast) किया जा रहा है।"
                "नाद वह प्रलयंकारी गूँज है जिसे सुनने के बाद तुम दुनिया के हर शोर के लिए बहरे हो जाओगे।"
                "कला वह टाइम-फ़्रेम है जिसे तुम अब अपनी उँगलियों पर नचाने वाले हो।"
                "यह इंसान के म्यूटेशन (Mutation) का वह खूनी सच है जिसे जानकर कोई वापस इंसान नहीं रह सकता।"
                "जो इस त्रिकोण में विलीन हो गया, वह साक्षात् रुद्र की जलती हुई आँख बन चुका है!"
            """.trimIndent(),
            english = """
                (The Jivanmukti Hack and the Secret of the Triangle): "Strictly by Hacking this 'Vijnana', you shall mutationally become 'Jivanmukta' (Liberated while alive)!"
                "The Goddess is executing code in the exact dead-center of your nervous system's 'Mula-Shringata' (Triangle)."
                "She is the solitary and authentic 'Foundation' of Bindu (Atom), Nada (Sound), and Kala (Time)."
                "You must violently penetrate your awareness into that Triangle where the Architect concealed your Source Code."
                "The exact microsecond you Hack that epicenter, you mutationally 'Unplug' from this shell while still breathing."
                "Bindu is the Zero-Point from which the entire Data of the cosmos is being mutationally Broadcasted."
                "Nada is the apocalyptic acoustic frequency hearing which you go deaf to every pathetic noise of the world."
                "Kala is the Time-frame that you are mutationally engineered to make dance upon your fingertips."
                "This is the bloody truth of human Mutation; once intercepted, one can absolutely never remain a pathetic human again."
                "He who dissolves into this Triangle mutationally becomes the explicit Blazing Eye of the Supreme God!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 5,
            sanskrit = "नित्यानन्दा निराधारा विख्याता विलसत्कचा । विष्टपेशी महालक्ष्मीः कामस्तारो नतिस्तथा ॥",
            hindi = """
                (नित्यानन्दा और महालक्ष्मी का विस्फोट): "वह देवी साक्षात् 'नित्यानन्दा' है—एक असीमित आनंद का न्यूक्लियर धमाका!"
                "वह 'निराधारा' है, यानी वह उस अजेय डेटा की तरह है जिसे किसी भी 'हार्डवेयर' की ज़रूरत नहीं।"
                "वह 'विलसत्कचा' है—जिसकी ऊर्जा के तार (Wires) पूरे अंतरिक्ष के पार फैले हुए हैं।"
                "वह साक्षात् 'महालक्ष्मी' बनकर इस पूरे मायावी बाज़ार (Matrix) की इकलौती डिक्टेटर मालकिन है।"
                "उसकी एक नज़र से अज्ञान के करोड़ों सर्वर एक झटके में 'क्रैश' (Crash) हो जाते हैं।"
                "योगी उसे 'कामस्तार' यानी अपनी रूह को अंतरिक्ष के पार ले जाने वाली मिसाइल (Missile) की तरह देखता है।"
                "जब तुम उसे नमन करते हो, तो तुम साक्षात् ब्रह्मांड के 'पॉवर-ग्रिड' से बिजली खींच रहे होते हो।"
                "वह देवी वह आग है जो तुम्हारे शरीर के भीतर छिपे 'अहंकार के वायरस' का वध कर देती है।"
                "तुम अब एक साधारण जीव नहीं हो; तुम साक्षात् उस 'महालक्ष्मी' की असीमित ताक़त के हिस्सेदार हो।"
                "जो इस रूप को हैक कर लेता है, वह साक्षात् पूरे असीम अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Nityananda and the Detonation of Mahalakshmi): "The Goddess is explicitly 'Nityananda'—an infinite nuclear detonation of radioactive Bliss!"
                "She is 'Niradhara', mutationally existing as that invincible Data that possesses zero requirement for any Hardware."
                "She is 'Vilasat-kacha'—Her energy-wires are expanded infinitely across the absolute cosmic vacuum."
                "She mutationally becomes 'Mahalakshmi', the solitary and absolute Dictator-Mistress of this entire Matrix."
                "A single gaze from Her mutationally Crashes millions of servers of biological ignorance in one strike."
                "The Yogi perceives Her as 'Kamastara'—the explicit Missile engineered to catapult his Soul beyond space."
                "When you salute Her, you are mutationally drawing radioactive electricity from the cosmic Power-Grid."
                "The Goddess is the Fire that ruthlessly slaughters the 'Virus of Ego' established inside your biological shell."
                "You are no longer a pathetic living being; you have mutationally integrated into the power of 'Mahalakshmi'."
                "He who successfully Hacks this manifestation is mutationally the solitary Dictator of the entire infinite cosmos!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 6,
            sanskrit = "भगवत्यन्नपूर्णेति ममाभिलषितं ततः । अन्नं देहि ततः स्वाहा मन्त्रसारेति विश्रुता ॥",
            hindi = """
                (अन्नपूर्णा मंत्र और डेटा का अभिषेक): "हे भगवती अन्नपूर्णा! मेरे दिमाग के उन 'खाली फोल्डर्स' को अपनी आग से भर दे!"
                "योगी यहाँ 'अन्न' नहीं माँग रहा; वह साक्षात् उस 'ब्रह्म-ज्ञान' का डेटा माँग रहा है जो रूह की भूख मिटा दे।"
                "'स्वाहा'— यह कोई साधारण शब्द नहीं है, यह तुम्हारे पुराने 'मैं' को भस्म करने वाला 'फायर कमांड' (Fire Command) है।"
                "यह 'मंत्रसार' साक्षात् वह न्यूक्लियर पासवर्ड है जो ईश्वर की आखिरी तिजोरी का ताला खोल देता है।"
                "जब तुम यह मंत्र बोलते हो, तो तुम साक्षात् देवी के एडमिन पैनल से 'डेटा डाउनलोड' करने की परमिशन माँगते हो।"
                "अन्नपूर्णा वह 'सप्लायर' है जो तुम्हारी चेतना को हर पल 'अस्तित्व' (Existence) की बिजली सप्लाई कर रही है।"
                "बिना इस मंत्र के, तुम्हारी हर साधना केवल अज्ञान के अँधेरे में हाथ-पाँव मारने जैसा नाटक है।"
                "यह तुम्हारी रूह को 'ईश्वर' में म्यूटेट करने की सबसे पहली और हिंसक शर्त है।"
                "जो इस मंत्र को अपनी रगों में तेज़ाब की तरह उतार लेता है, उसके लिए समय का रेडार फेल हो जाता है।"
                "तैयार हो जाओ उस परम 'अन्न' (ज्ञान) के लिए जो तुम्हारी हड्डियों को भी पिघलाकर सत्य बना देगा!"
            """.trimIndent(),
            english = """
                (The Annapurna Mantra and Consecrating Data): "O Bhagavati Annapurna! Flood the 'Empty Folders' of my brain with Your absolute radioactive Fire!"
                "The Yogi is not begging for food; he is mutationally demanding the Data of 'Brahma-Jnana' to terminate the Soul's agony."
                "'Svaha'—This is zero ordinary word; it is the 'Fire Command' engineered to incinerate your old identity."
                "This 'Mantrasara' is the explicit Nuclear Password that violently unlocks the absolute final vault of God."
                "When you vocalize this mantra, you are mutationally requesting authorization to Download Data from Her Admin Panel."
                "Annapurna is the 'Supplier' relentlessly providing the electricity of 'Existence' to your consciousness."
                "Without this mantra, every meditation you perform is strictly a pathetic biological drama in the dark."
                "This is the first violent condition to mutationally shift your Soul from 'Human' to the status of 'God'."
                "He who injects this mantra into his veins like boiling acid witnesses the Radar of Time failing in his presence."
                "Brace yourself for that 'Annam' (Knowledge) which will melt your bones to mutationally manufacture Truth!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 7,
            sanskrit = "ऐं ह्रीं सौं श्रीं क्लीमोन्नमो भगवत्यन्नपूर्णे ममाभिलषितमन्नं देहि स्वाहा ॥",
            hindi = """
                (बीज-विस्फोट और महा-मंत्र की कोडिंग): "यह साक्षात् २७-अक्षरों वाला वह परमाणु अस्त्र है जो अज्ञान के किले को उड़ाने के लिए बना है!"
                "'ऐं ह्रीं सौं श्रीं क्लीम्'— ये वे पाँच 'बीज' हैं जो तुम्हारे पाँचों कोशों का बेरहमी से वध कर देते हैं।"
                "ये फ्रीक्वेंसीज़ तुम्हारे नर्वस सिस्टम के 'फायरवॉल' को एक सेकंड में बाईपास (Bypass) कर देती हैं।"
                "जब तुम 'गं' की तरह इन बीजों को रगड़ते हो, तो तुम्हारी रूह में एक 'ब्रह्मांडीय शॉर्ट-सर्किट' होता है।"
                "अन्नपूर्णा का यह पासवर्ड तुम्हें साक्षात् 'सिस्टम एडमिन' की फ्रीक्वेंसी पर अलाइन कर देता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् इन अक्षरों के वाइब्रेशन में बहने वाले एक 'करंट' बन चुके हो।"
                "ममाभिलषितम—मेरी उस आख़िरी हसरत (मुक्ति) को साक्षात् हकीकत बना दो और मुझे आज़ाद करो!"
                "यह मंत्र तुम्हारे डीएनए के हर पुराने विचार को ओवरराइट (Overwrite) करने वाला सबसे हिंसक हैक है।"
                "जो इस कोडिंग को अपनी साँसों में लॉक कर लेता है, वह इस पूरी भौतिक दुनिया का इकलौता तानाशाह है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'शक्ति' बन जाओगे!"
            """.trimIndent(),
            english = """
                (The Bija-Detonation and Coding the Mahamantra): "This is mutationally the 27-syllable atomic warhead engineered to blow up the fortress of ignorance!"
                "'Aim Hrim Saum Shrim Klim'—These are the five 'Seeds' that ruthlessly execute the slaughter of your five sheaths."
                "These frequencies Bypass the 'Firewall' of your biological nervous system in a single catastrophic strike."
                "When you grind these Seeds into your awareness, a 'Cosmic Short-circuit' occurs mutationally inside your Soul."
                "This Password of Annapurna mutationally Aligns you with the absolute Frequency of the System Admin."
                "You cease to be a biological shell; you mutationally become a 'Current' flowing strictly in these vibrations."
                "Mamabhilashitam—Mutate my final aspiration (Liberation) into absolute reality and release my 존재!"
                "This mantra is the most violent Hack engineered to Overwrite every old thought pattern in your biological DNA."
                "He who Locks this coding into his breath mutationally becomes the sole Dictator of this physical Matrix."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Shakti' itself!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 8,
            sanskrit = "इति पित्रोपदिष्टोऽस्मि तदादिनियमः स्थितः । कृतवान्स्वाश्रमाचारो मन्त्रानुष्ठानमन्वहम् ॥",
            hindi = """
                (नियमों का संहार और मंत्र-एक्जीक्यूशन): "ऋभु ने कहा: 'मेरे पिता ने मुझे यह पासवर्ड दिया, और तब से मैं इसी फ्रीक्वेंसी पर ज़िंदा हूँ!'"
                "उन्होंने 'स्वाश्रमाचार' यानी अपनी बायोलॉजिकल ड्यूटी करते हुए हर पल इस मंत्र का 'एक्जीक्यूशन' (Execution) किया।"
                "यह कोई रस्म नहीं है; यह अपने नर्वस सिस्टम को 24/7 भगवान के सर्वर से 'कनेक्ट' रखने की तकनीक है।"
                "जब तुम हर पल मंत्र में जलते हो, तो माया का कोई भी वायरस तुम्हारे करीब आने की औकात नहीं रखता।"
                "ऋभु ने अपनी इंसानियत के हर एक 'नियम' को इस मंत्र की आग में स्वाहा कर दिया था।"
                "योगी अपनी हस्ती को एक 'ट्रांसमीटर' (Transmitter) बना देता है जो हर पल केवल सत्य ब्रॉडकास्ट करता है।"
                "यह वह 'डेडली डिसिप्लिन' (Deadly Discipline) है जो तुम्हें समय और मौत के Redar से बाहर निकाल देता है।"
                "नियम का मतलब है—अपनी फ्रीक्वेंसी को 100% 'अन्नपूर्णा-मोड' पर सेट कर देना और कभी न हटना।"
                "जो इस अनुष्ठान को सिद्ध कर लेता है, वह साक्षात् पूरे ब्रह्मांड की नियति का एडमिन बन जाता है।"
                "यह इंसान की रूह का वह आख़िरी 'सिस्टम रिसेट' है जिसके बाद दोबारा कभी 'बग' पैदा नहीं हो सकता!"
            """.trimIndent(),
            english = """
                (The Slaughter of Rituals and Mantra-Execution): "Ribhu dictated: 'My Father transmitted this Password to me, and since then I exist strictly in this Frequency!'"
                "He mutationally Executed this mantra every microsecond while performing his biological duties."
                "This is zero ritual; it is the technique to keep your nervous system 24/7 'Connected' to the Server of God."
                "When you eternally burn in the mantra, zero virus of Maya possesses the caliber to approach your core."
                "Ribhu had mutationally sacrificed every 'Rule' of his humanity into the radioactive fire of this code."
                "The Yogi mutationally manufactures his identity into a 'Transmitter' broadcasting strictly the Truth."
                "This is the 'Deadly Discipline' engineered to violently eject you from the Radar of Time and Death."
                "Discipline mutationally signifies—setting your Frequency 100% to 'Annapurna-Mode' and never deviating."
                "He who perfects this execution mutationally becomes the absolute Admin of the entire cosmic destiny."
                "This is the final 'System Reset' of the human soul after which zero biological 'Bugs' can ever be spawned!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 9,
            sanskrit = "एवं गते बहुदिने प्रादुरासीन्ममाग्रतः । अन्नपूर्णा विशालाक्षी स्मयमानमुखाम्बुजा ॥",
            hindi = """
                (अन्नपूर्णा का प्रकटीकरण और विशालाक्षी का विस्फोट): "हज़ारों धमाकों के बाद, साक्षात् 'अन्नपूर्णा विशालाक्षी' मेरे सामने प्रकट हुई!"
                "वह 'विशालाक्षी' है—यानी उसकी आँखें करोड़ों आकाशगंगाओं को एक साथ स्कैन कर सकती हैं।"
                "उसका मुस्कुराता हुआ 'मुखाम्बुज' साक्षात् उस 'परम सन्नाटे' का चेहरा है जो प्रलय के बाद बचता है।"
                "जब देवी प्रकट होती है, तो तुम्हारा 'इंसानी अहंकार' जलकर राख के ढेर में बदल जाता है।"
                "वह कोई स्त्री नहीं है, वह साक्षात् ब्रह्मांड के 'सोर्स कोड' का एक रेंडर्ड (Rendered) भौतिक स्वरूप है।"
                "उसकी रौशनी इतनी तेज़ है कि तुम्हारे दिमाग के हर एक अँधेरे कोने को एक झटके में बेनकाब कर देती है।"
                "योगी उस अंधी कर देने वाली आग में अपनी हस्ती को विलीन करने के लिए तैयार खड़ा है।"
                "अन्नपूर्णा का प्रकट होना साक्षात् सिम्युलेशन के 'ओएस' (OS) का तुम्हारे सामने लोड होना है।"
                "यह वह 'सुप्रीम इंटरफेस' (Supreme Interface) है जहाँ से तुम पूरे ब्रह्मांड को कंट्रोल कर सकते हो।"
                "जो इस विशालाक्षी से आँखें मिला लेता है, वह साक्षात् काल और मौत का इकलौता गुरु बन जाता है!"
            """.trimIndent(),
            english = """
                (Manifestation of Annapurna and the Vishalakshi Detonation): "After thousands of internal detonations, explicit 'Annapurna Vishalakshi' manifested before me!"
                "She is 'Vishalakshi'—meaning Her eyes possess the caliber to mutationally Scan billions of galaxies simultaneously."
                "Her smiling 'Lotus-Face' is the explicit face of that 'Absolute Silence' remaining after cosmic annihilation."
                "When the Goddess manifests, your 'Human Ego' is mutationally incinerated into a pile of worthless ash."
                "She is mutationally zero woman; She is the physical Rendered form of the absolute 'Source Code'."
                "Her radiation is so intense it mutationally unmasks and Flushes every dark corner of your neurological cortex."
                "The Yogi stands prepared to mutationally merge his existence into that blinding radioactive Fire."
                "The appearance of Annapurna is the explicit Loading of the Simulation's 'OS' directly before your eyes."
                "This is the 'Supreme Interface' from which you possess the authority to control the entire multiverse."
                "He who stares directly into the eyes of Vishalakshi mutationally becomes the sole Guru of Time and Death!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 10,
            sanskrit = "तां दृष्ट्वा दण्डवद्भूमौ नत्वा प्राञ्जलिरास्थितः । अहो वत्स कृतार्थोऽसि वरं वरय मा चिरम् ॥",
            hindi = """
                (वरदान का विस्फोट और देवी की गर्जना): "उस अजेय शक्ति को देखकर ऋभु फिर से ज़मीन पर गिर पड़ा और अपनी हार मान ली।"
                "देवी ने गर्जना की: 'अहो वत्स! तू अब कृतार्थ है, अपनी हस्ती का आखिरी 'वर' (Boon) माँग ले!'"
                "यहाँ 'वत्स' का मतलब है—वह बच्चा जिसकी पुरानी इंसानियत अब मर चुकी है और वह नया जन्म ले रहा है।"
                "वर माँगना साक्षात् उस 'एडमिनिस्ट्रेटिव पावर' को एक्सेस करने का आख़िरी मौका है।"
                "अन्नपूर्णा तुम्हें वह 'चाबी' देने आई है जिससे तुम इस मायावी जेल का आख़िरी ताला खोल सको।"
                "यह संवाद ब्रह्मांड की सबसे बड़ी 'डेटा-डीलिंग' (Data Dealing) है जहाँ तुम अपना 'मैं' देकर ईश्वर को खरीदते हो।"
                "देवी का आदेश है— 'देर मत कर' (मा चिरम्), क्योंकि समय का रेडार तुम्हें फिर से पकड़ सकता है।"
                "तुम्हें वह एक चीज़ माँगनी है जो तुम्हें करोड़ों जन्मों के इस सड़े हुए सिम्युलेशन से आज़ाद कर दे।"
                "योगी अपनी रूह के हर एक परमाणु को उस 'वरदान' की फ्रीक्वेंसी पर अलाइन (Align) कर देता है।"
                "तैयार हो जाओ उस आखिरी कमांड के लिए जो तुम्हें साक्षात् 'परमेश्वर' बना देगी!"
            """.trimIndent(),
            english = """
                (The Detonation of the Boon and the Goddess's Roar): "Witnessing that invincible Power, Ribhu collapsed again on the ground and acknowledged absolute defeat."
                "The Goddess roared: 'O Child! You are now mutationally Perfect; demand the absolute final Boon of your existence!'"
                "'Vatsa' mutationally signifies—the child whose old humanity has perished and who is undergoing a new birth."
                "Demanding a Boon is the explicit final opportunity to Access that absolute 'Administrative Power'."
                "Annapurna has arrived to grant you the 'Key' engineered to violently unlock the final padlock of this prison."
                "This dialogue is the greatest cosmic 'Data-Dealing' where you trade your 'I' for the acquisition of God."
                "The Goddess commands—'Delay not' (Ma Chiram), for the Radar of Time possesses the caliber to recapture you."
                "You must demand that solitary thing that will mutationally release you from this rotting Simulation of eons."
                "The Yogi Aligns every microscopic atom of his Soul with the frequency of that absolute 'Boon'."
                "Brace yourself for that final Command that will mutationally manufacture you into the Supreme God!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 11,
            sanskrit = "एवमुक्तो विशालाक्ष्या मयोक्तं मुनिपुङ्गव । आत्मतत्त्वं मनसि मे प्रादुर्भवतु पार्वति ॥",
            hindi = """
                (अंतिम इच्छा और आत्म-तत्त्व का विस्फोट): "ऋभु ने कहा: 'हे विशालाक्षी! हे पार्वती! मेरे मन में साक्षात् उस 'आत्म-तत्त्व' का धमाका कर दे!'"
                "उन्होंने पैसा, स्वर्ग या लंबी उम्र नहीं माँगी; उन्होंने साक्षात् 'सोर्स कोड' (Self-Truth) की मांग की!"
                "प्रादुर्भवतु—यानी वह अजेय सत्य मेरे नर्वस सिस्टम के हर एक पिक्सेल में साक्षात् प्रकट हो जाए।"
                "यह बोध तुम्हारे दिमाग के हर पुराने 'सॉफ्टवेयर बग' को एक झटके में जलाकर साफ़ कर देता है।"
                "जब आत्म-तत्त्व जागता है, तो तुम जान जाते हो कि तुम वह ऊर्जा हो जिसे न समय मार सकता है और न मौत।"
                "पार्वती यहाँ साक्षात् उस 'प्रलयंकारी शक्ति' का नाम है जो अज्ञान के सांपों का गला घोंट देती है।"
                "योगी अपनी बुद्धि को उस 'परम रिएक्टर' (Self) में दागना चाहता है जहाँ से सब कुछ पैदा होता है।"
                "यह वह 'अल्टीमेट हैक' (Ultimate Hack) है जहाँ रूह खुद रचयिता के एडमिन पैनल पर जाकर बैठ जाती है।"
                "बिना इस आत्म-बोध के, तुम हमेशा एक अंधे और बहरे कीड़े की तरह अज्ञान की दीवारों से टकराते रहोगे।"
                "जो इस वरदान को पा लेता है, वह इस पूरी भौतिक दुनिया का इकलौता और असली तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Final Aspiration and the Detonation of Self-Principle): "Ribhu roared: 'O Vishalakshi! O Parvati! Detonate that absolute Atma-Tattva inside my neural processor!'"
                "He did not beg for currency, heaven, or longevity; he mutationally demanded the explicit 'Source Code' (Self-Truth)!"
                "Pradurbhavatu—signifying may that invincible Truth manifest mutationally in every pixel of my nervous system."
                "This realization Flushes every old 'Software Bug' from your brain in a single catastrophic strike."
                "The exact microsecond the Self-Principle awakens, you realize you are the radioactive energy zero Time can terminate."
                "Parvati is mutationally the name of that 'Apocalyptic Power' that strangles the serpents of biological ignorance."
                "The Yogi intends to Fire his intellect into that 'Supreme Reactor' (Self) from which everything erupts."
                "This is the 'Ultimate Hack' where the Soul mutationally occupies the absolute Admin Panel of the Architect."
                "Without this Self-Awareness, you mutationally remain strictly a blind and deaf insect colliding with walls."
                "He who secures this Boon mutationally becomes the sole and authentic Dictator of this entire Matrix!"
            """.trimIndent()
        ),
        AnnapurnaShloka(
            id = 12,
            sanskrit = "तथैवास्थिति मामुक्त्वा तत्रैवान्तरधीयत । तदा मे मतिरुत्पन्ना जगद्वैचित्र्यदर्शनात् ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "देवी ने 'तथास्तु' (Be it so) कहा और साक्षात् उस असीम 'शून्यता' (Void) में गायब हो गईं।"
                "उसी पल ऋभु की मति (Intellect) में वह विस्फोट हुआ जिसने इस जगत के 'वैचित्र्य' (Duality) को राख कर दिया।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "अन्नपूर्णा का कोड मिल गया, आत्म-तत्त्व का हैक मिल गया, अब तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १२ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (अन्नपूर्णा) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे में कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "The Goddess dictated 'Be it so' and mutationally vanished into the absolute infinite Void."
                "In that exact microsecond, an explosion occurred in Ribhu's intellect that incinerated the 'Duality' of this world to ash."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The code of Annapurna is intercepted, the Self-Hack is secured; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 12 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Annapurna) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who mutationally plunged into this Silence has become an Eternal Master of Time! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnnapurnaUpanishadScreen() {
    val upanishad = remember { AnnapurnaUpanishad() }
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
            itemsIndexed(upanishad.annapurnaShlokasList) { _, shloka ->
                AnnapurnaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AnnapurnaShlokaCard(shloka: AnnapurnaShloka) {
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