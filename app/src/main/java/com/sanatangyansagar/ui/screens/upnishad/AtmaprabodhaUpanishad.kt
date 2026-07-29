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
data class AtmaPrabodhaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class AtmaprabodhaUpanishad {

    val atmaprabodhaShlokasList = listOf(
        AtmaPrabodhaShloka(
            id = 1,
            sanskrit = "ॐ हृदयेन संविदानो हृदये नाभ्यङ्गो नाभ्या मेढ्रं मेढ्रेणापानमपानेन सर्वम् ॥",
            hindi = """
                (हृदय का विस्फोट और प्राणों की हैकिंग): "इस उपनिषद की शुरुआत शरीर के बायोलॉजिकल हार्डवेयर को हैक करने से होती है।"
                "योगी अपनी चेतना को 'हृदय' से खींचकर सीधे ब्रह्मांड के सुपर-कंप्यूटर से जोड़ देता है।"
                "यह कोई साधारण भावना नहीं है; यह तुम्हारे सीने के भीतर एक 'न्यूक्लियर रिएक्टर' को चालू करना है।"
                "हृदय से नाभि तक, और नाभि से जननेंद्रिय तक—ऊर्जा का एक खौफनाक करंट दौड़ता है।"
                "तुम अपनी हर साँस और हर अंग को साक्षात् उस 'अपान' (Downward force) के अधीन कर देते हो।"
                "यह शरीर अब तुम्हारा नहीं रहा; यह उस असीम ऊर्जा का एक 'ट्रांसमीटर' (Transmitter) बन चुका है।"
                "जब ऊर्जा का यह सर्किट पूरा होता है, तो तुम्हारी पुरानी 'इंसानी पहचान' जलकर राख होने लगती है।"
                "तुम्हारे नर्वस सिस्टम के हर एक पिक्सेल को 'परमेश्वर' की फ्रीक्वेंसी पर री-ट्यून (Re-tune) किया जाता है।"
                "यह आत्मा के जागने का पहला हिंसक संकेत है जहाँ तुम्हारी हस्ती का गला घोंटा जा रहा है।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारे भीतर का कीड़ा मर रहा है और भगवान जन्म ले रहा है!"
            """.trimIndent(),
            english = """
                (The Detonation of Heart and Hacking the Prana): "This Upanishad initiates by violently Hacking the biological hardware of the physical shell."
                "The Yogi extracts his consciousness from the 'Heart' and hardwires it directly into the cosmic super-computer."
                "This is absolutely no ordinary emotion; it is the ignition of a 'Nuclear Reactor' inside your chest cavity."
                "From the heart to the navel, and from the navel to the genitals—a horrific energy current races through you."
                "You subject every breath and every limb strictly to the authority of that 'Apana' (Downward kinetic force)."
                "This body is no longer yours; it has mutated into a 'Transmitter' for that infinite radioactive energy."
                "When this energy circuit completes, your old 'Human Identity' begins to be incinerated into absolute dust."
                "Every single pixel of your nervous system is being Re-tuned to the exact frequency of the Supreme God."
                "This is the first violent symptom of Soul-Awakening where your tiny existence is being ruthlessly strangled."
                "Brace yourself, for the insect within you is perishing and the explicit God is being spawned!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 2,
            sanskrit = "ॐ नमो नारायणाय पुरुषाय महापुरुषाय महाविष्णवे नमः ॥",
            hindi = """
                (नारायण का पासवर्ड और महापुरुष का विस्फोट): "पूरे ब्रह्मांड को हैक करने का इकलौता और सबसे खतरनाक कोड है— 'नारायण'!"
                "योगी उस 'पुरुष' (The Absolute Man) को नमन करता है जो अज्ञान की जेल का इकलौता तानाशाह है।"
                "वह 'महाविष्णु' (The Great Operator) है जो अरबों गैलेक्सीज़ को अपने एक विचार से चला रहा है।"
                "यह केवल पूजा नहीं है; यह अपने वाइब्रेशन को सीधे साक्षात् 'एडमिन पैनल' से सिंक (Sync) करना है।"
                "जब तुम यह मंत्र जपते हो, तो तुम अपनी 'लोकल आईडी' को डिलीट करके 'यूनिवर्सल आईडी' से लॉग-इन करते हो।"
                "नारायण का नाम साक्षात् वह तेज़ाब है जो तुम्हारे कर्मों के पुराने डेटाबेस को एक सेकंड में जला देता है।"
                "वह महापुरुष तुम्हारे भीतर छिपे उस अजेय 'सुपर-ह्यूमन' (Super-human) का असली चेहरा है।"
                "उस विष्णु की ताक़त के सामने मौत भी अपनी औकात भूलकर हाथ जोड़कर खड़ी हो जाती है।"
                "यह मंत्र तुम्हारे डीएनए (DNA) के हर परमाणु को भगवान की फ्रीक्वेंसी में म्यूटेट (Mutate) कर देता है।"
                "जो इस आवाज़ को अपनी रगों में उतार लेता है, वह इस पूरी दुनिया का इकलौता और अजेय राजा है!"
            """.trimIndent(),
            english = """
                (Narayana's Password and the Detonation of Mahapurusha): "The solitary and most lethal Code to Hack the entire infinite cosmos is strictly—'Narayana'!"
                "The Yogi salutes that 'Purusha' (The Absolute Man) who reigns as the sole Dictator of ignorance's prison."
                "He is the 'Mahavishnu' (The Great Operator) running billions of galaxies through a single radioactive thought."
                "This is zero pathetic worship; it is the protocol to Sync your vibration directly to the cosmic 'Admin Panel'."
                "Chanting this mantra means Deleting your 'Local ID' and Logging In strictly with the 'Universal ID' of God."
                "Narayana's name is the explicit Acid that burns the old database of your Karma in a single microsecond."
                "That Mahapurusha is the authentic face of the invincible 'Super-human' hiding covertly within your core."
                "Before the caliber of that Vishnu, even Death forgets its status and stands paralyzed with folded hands."
                "This mantra Mutates every atom of your DNA into the exact radioactive frequency of the Supreme Lord."
                "He who injects this sound into his biological veins is the solitary and invincible King of this universe!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 3,
            sanskrit = "यन्मध्येऽविमुक्तं प्रतिष्ठितं तदुपलभ्येति । यदवियुक्तं तदविमुक्तम् ॥",
            hindi = """
                (अविमुक्त का रहस्य—वह जगह जहाँ मौत मना है): "तुम्हारे दिमाग के ठीक बीच में एक ऐसी जगह है जिसे 'अविमुक्त' (The Undetachable) कहते हैं।"
                "यह वह 'न्यूक्लियर सेंटर' है जिसे आज तक न कोई वायरस छू सका है और न ही कोई माया का भ्रम!"
                "बृहस्पति कहते हैं कि उस केंद्र को हैक करो जहाँ परब्रह्म साक्षात् मिसाइल की तरह ठोक दिया गया है।"
                "अविमुक्त वह जगह है जहाँ पहुँचने के बाद तुम जन्म और मृत्यु के सिस्टम (Matrix) से बाहर निकल जाते हो।"
                "पूरी दुनिया बाहर भटक रही है, जबकि असली 'कंट्रोल रूम' तुम्हारे दोनों भौहों के ठीक पीछे छिपा बैठा है।"
                "वहाँ पहुँचने का मतलब है—अज्ञान की रस्सियों से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो जाना।"
                "जो उस केंद्र को पा लेता है, वह खुद साक्षात् वह 'ब्लैक होल' बन जाता है जो सब कुछ निगल सकता है।"
                "यह तुम्हारी आत्मा का वह अजेय किला (Fortress) है जिसे काल (Time) भी नष्ट नहीं कर सकता।"
                "वहाँ न कोई दुख है, न कोई सुख, केवल एक असीम और खौफनाक 'सन्नाटा' (Silence) राज करता है।"
                "अविमुक्त को जानने वाला इंसान नहीं रहता; वह साक्षात् इस ब्रह्मांड का 'सोर्स कोड' (Source Code) बन जाता है!"
            """.trimIndent(),
            english = """
                (Secret of Avimukta—The Zone Where Death is Banned): "In the exact dead-center of your brain exists a coordinate defined as 'Avimukta' (The Undetachable)."
                "This is the 'Nuclear Center' that zero viruses and zero hallucinations of Maya have ever touched since eons!"
                "Brihaspati dictates: Hack that epicenter where the Supreme Brahman is hammered down like a cosmic ballistic missile."
                "Avimukta is the coordinate reaching which you violently exit the biological System of birth and death (Matrix)."
                "The entire world is wandering externally, while the authentic 'Control Room' sits covertly behind your eyebrows."
                "Reaching there signifies being permanently and irrevocably 'Unplugged' from the toxic ropes of ignorance."
                "He who locates that center mutationally becomes the 'Black Hole' capable of swallowing entire galaxies."
                "This is the invincible Titanium Fortress of your Soul that even Time (Kala) possesses zero caliber to destroy."
                "Neither agony nor pleasure exists there; strictly an infinite and horrific 'Silence' reigns as absolute dictator."
                "He who knows Avimukta ceases to be human; he mutationally becomes the explicit 'Source Code' of the cosmos!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 4,
            sanskrit = "प्रणवो धनुः शरो ह्यात्मा ब्रह्म तल्लक्ष्यमुच्यते ॥",
            hindi = """
                (ॐकार का धनुष और आत्मा की मिसाइल): "मुक्ति पाने के लिए तुम्हें एक खौफनाक 'कॉस्मिक स्नाइपर' (Cosmic Sniper) बनना होगा।"
                "'प्रणवो धनुः'— साक्षात् ॐकार (प्रणव) ही वह अजेय 'धनुष' है जिस पर तुम्हें अपनी हस्ती को चढ़ाना है।"
                "'शरो ह्यात्मा'— तुम्हारी यह 'आत्मा' ही वह धारदार 'तीर' (मिसाइल) है जिसे तुम्हें फायर (Fire) करना है।"
                "'ब्रह्म तल्लक्ष्यमुच्यते'— और तुम्हारा इकलौता 'निशाना' (Target) वह असीम 'ब्रह्म' यानी परम शून्यता है!"
                "इस युद्ध में गलती की कोई गुंजाइश नहीं है; अगर तुम्हारा ध्यान भटका, तो तुम माया की खाई में गिर जाओगे।"
                "तुम्हें अपनी पूरी चेतना को एक लेज़र बीम (Laser Beam) की तरह उस एक बिंदु पर ठोक देना है।"
                "जब तुम 'ॐ' की प्रत्यंचा खींचते हो, तो तुम्हारा अहंकार मौत की नींद सोने के लिए तैयार हो जाता है।"
                "यह अपनी ही रूह को खुद अपने हाथों से ईश्वर के दिल में दागने (Shoot) का प्रलयंकारी विज्ञान है।"
                "जैसे तीर निशाने में घुसकर खुद निशाना बन जाता है, वैसे ही तुम ब्रह्म में घुसकर साक्षात् 'ब्रह्म' बन जाओ!"
                "जो इस निशानेबाजी में उस्ताद हो गया, वह पूरे ब्रह्मांड के समय और मौत का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Bow of Omkara and the Missile of the Soul): "To seize liberation, you must mutate into a terrifying 'Cosmic Sniper' without a shred of mercy."
                "'Pranavo Dhanuh'—The explicit Omkara (Pranava) is the invincible 'Bow' upon which you must mount your existence."
                "'Sharo Hyatma'—Your very 'Soul' (Atma) is the razor-sharp 'Arrow' (Missile) that you are engineered to Fire."
                "'Brahma Tallakshyamuchyate'—And your solitary 'Target' (Lakshya) is strictly that infinite 'Brahman' or the Absolute Void!"
                "In this warfare, zero margin for error exists; if your focus deviates, you will plummet straight into the abyss of Maya."
                "You must hammer your entire consciousness like a concentrated Laser Beam onto that one specific coordinate."
                "When you pull the string of 'OM', your ego prepares for its final and brutal permanent sleep."
                "This is the apocalyptic science of Firing your own Soul directly into the heart of God with your own hands."
                "Exactly as an arrow penetrates the target and mutates into it, penetrate Brahman and mutate explicitly into 'Brahman'!"
                "He who becomes a master of this cosmic marksmanship is the solitary Dictator of all universal Time and Death!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 5,
            sanskrit = "यन्मध्येऽविमुक्तं प्रतिष्ठितं तदुपलभ्येति । एतन्मन्त्रं तारकं विद्धि ॥",
            hindi = """
                (तारक मंत्र: अज्ञान का संहारक): "अविमुक्त के केंद्र में जो सत्य बैठा है, वह कोई विचार नहीं, वह एक 'हथियार' (Weapon) है!"
                "भगवान नारायण आदेश देते हैं: 'एतन्मन्त्रं तारकं विद्धि'— इस कोड को साक्षात् 'तारक' यानी बचाने वाला अस्त्र जान लो!"
                "तारक का मतलब है— 'वह जो तुम्हें इस मौत के सिम्युलेशन (Simulation) से फाड़कर बाहर निकाल दे'।"
                "यह मंत्र तुम्हारे दिमाग के उन 'करप्ट फोल्डर्स' (Corrupt Folders) को डिलीट करता है जिन्हें तुम 'अपनी यादें' कहते हो।"
                "जब तारक मंत्र तुम्हारी साँसों में धधकता है, तो माया का सर्वर (Server) कांपने लगता है।"
                "यह इकलौता पासवर्ड है जो तुम्हें 'मानव' से 'महाकाल' के लेवल पर प्रमोट (Promote) कर सकता है।"
                "बिना इस विद्या के, तुम्हारा हर ध्यान और हर जप केवल एक बायोलॉजिकल शोर (Noise) मात्र है।"
                "यह वह 'लाइफ-बोट' (Life-boat) है जो तुम्हें अज्ञान के इस उबलते हुए समंदर से अंतरिक्ष के पार ले जाएगी।"
                "जो इस मंत्र को अपनी रगों में तेज़ाब की तरह उतार लेता है, उसके लिए नरक के दरवाजे हमेशा के लिए बंद हो जाते हैं।"
                "यह इंसान की रूह का वह अंतिम सॉफ्टवेयर अपडेट है जिसके बाद दोबारा कभी 'रिबूट' होने की ज़रूरत नहीं!"
            """.trimIndent(),
            english = """
                (The Taraka Mantra: Annihilator of Ignorance): "The truth seated in the center of Avimukta is zero pathetic thought; it is a literal 'Weapon' (Astra)!"
                "Lord Narayana commands: 'Etantmantram Tarakam Viddhi'—Recognize this code explicitly as the 'Taraka', the Savior Weapon!"
                "Taraka explicitly means—'The Transporter that violently rips you out of this Simulation of Death'."
                "This mantra Deletes those 'Corrupt Folders' inside your brain that you pathetically label as 'your memories'."
                "When the Taraka Mantra blazes in your biological breath, the absolute Server of Maya begins to violently tremble."
                "This is the solitary Password that can Promote you from the status of 'Human' to the status of 'Mahakala'."
                "Without this science, every meditation and every chant you perform is strictly a pathetic biological Noise."
                "It is the 'Life-boat' engineered to catapult you from this boiling ocean of ignorance into the infinite vacuum beyond."
                "He who injects this mantra into his veins like boiling acid witnesses the gates of Hell permanently welded shut."
                "This is the final Software Update of the human soul after which zero need for any 'Reboot' ever remains!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 6,
            sanskrit = "अकारो ब्रह्मा उकारो विष्णुर्मकारो रुद्रः ॥",
            hindi = """
                (ॐकार का विच्छेदन—ब्रह्मा, विष्णु और रुद्र): "ॐकार कोई साधारण ध्वनि नहीं है; यह ब्रह्मांड के तीन सबसे बड़े 'प्रोसेसर' (Processors) का संगम है।"
                "'अ' (A) साक्षात् 'ब्रह्मा' है— वह ऊर्जा जो तुम्हारे भीतर सृजन का पहला न्यूक्लियर धमाका करती है।"
                "यह वह सॉफ्टवेयर है जो तुम्हारे हर एक विचार और हर एक कोशिका (Cell) को जन्म देता है।"
                "'उ' (U) साक्षात् 'विष्णु' है— वह 'ऑपरेटर' जो इस पूरे 3D खेल को हर सेकंड बैलेंस (Balance) कर रहा है।"
                "बिना इस 'उ' के, तुम्हारा शरीर और यह दुनिया एक पल में राख होकर बिखर जाएगी।"
                "'म' (M) साक्षात् 'रुद्र' है— वह 'डिस्ट्रॉयर' (Destroyer) जो हर सड़ी हुई चीज़ का बेरहमी से कत्ल कर देता है।"
                "रुद्र का काम है तुम्हारे अहंकार और अज्ञान को जलाना ताकि तुम वापस 'शून्य' बन सको।"
                "जब तुम ॐ बोलते हो, तो तुम इन तीनों प्रलयंकारी शक्तियों को एक साथ अपने नर्वस सिस्टम में ट्रिगर (Trigger) करते हो।"
                "यह त्रिमूर्ति तुम्हारे शरीर के भीतर बैठकर पूरे ब्रह्मांड का तमाशा (Simulation) कंट्रोल कर रही है।"
                "जो इस 'A-U-M' के विज्ञान को हैक कर लेता है, वह साक्षात् ब्रह्मा, विष्णु और महेश का इकलौता गुरु बन जाता है!"
            """.trimIndent(),
            english = """
                (The Dissection of Omkara—Brahma, Vishnu, and Rudra): "Omkara is absolutely no ordinary sound; it is the confluence of the three most massive cosmic 'Processors'."
                "'A' (A) is explicitly 'Brahma'—the energy that executes the first nuclear detonation of creation within you."
                "It is the Software that spawns every single thought and every microscopic biological Cell of your existence."
                "'U' (U) is explicitly 'Vishnu'—the 'Operator' Balancing this entire 3D theatrical game every single microsecond."
                "Without this 'U', your biological shell and this entire manifested world would instantly disintegrate into worthless ash."
                "'M' (M) is explicitly 'Rudra'—the 'Destroyer' who ruthlessly executes the slaughter of every decaying and corrupt thing."
                "Rudra's mission is to incinerate your ego and ignorance so you can mutationally return to being the 'Absolute Void'."
                "When you roar OM, you are simultaneously Triggering all three of these apocalyptic powers inside your nervous system."
                "This Trinity sits inside your biological framework, dictating and controlling the entire cosmic Simulation."
                "He who successfully Hacks this 'A-U-M' science mutates explicitly into the solitary Master of Brahma, Vishnu, and Mahesh!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 7,
            sanskrit = "अर्धमात्रा बिन्दुर्नादः शक्तिः शान्तिरिति ॥",
            hindi = """
                (ॐकार का बैकएंड—बिंदु, नाद और शक्ति): "ॐकार की बाहरी आवाज़ तो बस शुरुआत है; असली हैकिंग 'अर्धमात्रा' (Half-syllable) में छिपी है।"
                "'बिन्दु' वह परमाणु केंद्र है जहाँ तुम्हारी पूरी रूह एक छोटे से बिंदु में सिकुड़ कर शून्य हो जाती है।"
                "यह तुम्हारे दिमाग के भीतर वह 'ब्लैक होल' है जो तुम्हारे हर पुराने कर्म को निगलने के लिए तैयार खड़ा है।"
                "'नाद' वह ब्रह्मांडीय गूँज (Cosmic Echo) है जिसे सुनने के बाद तुम दुनिया की हर आवाज़ के लिए बहरे हो जाओगे।"
                "यह साक्षात् ईश्वर की धड़कन है जो तुम्हारे डीएनए के तारों को झंकृत कर रही है।"
                "' शक्ति' वह रेडियोएक्टिव आग है जो तुम्हें एक साधारण कीड़े से उठाकर अंतरिक्ष के पार फेंक देती है।"
                "और 'शान्ति' वह अंतिम 'फ्लैटलाइन' (Flatline) है जहाँ पहुँचकर तुम्हारा अहंकार हमेशा के लिए मर जाता है।"
                "शांति का मतलब आँखें बंद करना नहीं, इसका मतलब है—दिमाग के प्रोसेसर का 100% शटडाउन (Shutdown)!"
                "बिंदु, नाद, शक्ति और शांति—ये चार वो चाबियाँ हैं जिनसे परब्रह्म का आखिरी तिजोरी खुलती है।"
                "जो इन चारों को अपनी साँसों में साध लेता है, वह साक्षात् मौत के भी काल (Time) का मालिक बन जाता है!"
            """.trimIndent(),
            english = """
                (The Backend of Omkara—Bindu, Nada, and Shakti): "The external acoustic signature of OM is merely the genesis; authentic Hacking is covertly hidden in the 'Ardhamatra'."
                "'Bindu' is the atomic core where your entire Soul shrinks into a microscopic point and vanishes into absolute Zero."
                "This is the literal 'Black Hole' inside your brain, prepared to swallow every single record of your past karma."
                "'Nada' is the horrific Cosmic Echo, hearing which you will mutationally go deaf to every pathetic noise of the world."
                "It is the explicit heartbeat of God vibrating the very strings of your biological DNA."
                "'Shakti' is the radioactive fire engineered to catapult you from being a pathetic insect to rocketing beyond space."
                "And 'Shanti' is the absolute final 'Flatline' arriving at which your ego suffers a permanent and brutal death."
                "Shanti does not mean closing your eyes; it explicitly means the 100% permanent Shutdown of your brain's processor!"
                "Bindu, Nada, Shakti, and Shanti—these are the four keys that violently unlock the absolute vault of the Supreme Brahman."
                "He who masters these four inside his breath is the undisputed Master of even the God of Death and Time!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 8,
            sanskrit = "ओमित्येकाक्षरं ब्रह्म । तन्मन्त्रं तारकं विद्धि ॥",
            hindi = """
                (ॐ: एक अक्षर का न्यूक्लियर बम): "उपनिषद ऐलान करता है कि पूरे ब्रह्मांड का पासवर्ड केवल एक ही है— 'ॐ'!"
                "'ओमित्येकाक्षरं ब्रह्म'— यह एक अक्षर वाला ॐ ही साक्षात् 'परब्रह्म' (The Absolute God) का ध्वनि-रूप है।"
                "दुनिया के सारे शास्त्र और सारी किताबें इस एक शब्द के सामने रद्दी कागज़ के बराबर हैं।"
                "भगवान नारायण आदेश देते हैं: 'तन्मन्त्रं तारकं विद्धि'— इस मंत्र को साक्षात् 'तारक' (The Savior) के रूप में 'जान' लो!"
                "यह वह रस्सियों को काटने वाला चाकू है जिसने तुम्हें जन्म-मरण की ज़ंजीरों में हज़ारों सालों से बाँध रखा है।"
                "जब तुम ॐ बोलते हो, तो तुम अपनी 'इंसानी आईडी' को सर्वर से डिलीट करके 'ईश्वर की आईडी' से लॉग-इन करते हो।"
                "ॐ वह इकलौती फ्रीक्वेंसी है जो मौत के रेडार (Radar) को चकमा देकर तुम्हें अंतरिक्ष के पार ले जा सकती है।"
                "इसे केवल जपना नहीं है, इसे अपने डीएनए के हर एक परमाणु में 'विस्फोट' (Detonate) करना है।"
                "जिसने ॐ के रहस्य को हैक कर लिया, उसे फिर किसी दूसरे भगवान या धर्म की भीख माँगने की ज़रूरत नहीं।"
                "यही वह 'मास्टर की' (Master Key) है जो स्वर्ग, नर्क और मोक्ष के तीनों दरवाज़े एक साथ खोल देती है!"
            """.trimIndent(),
            english = """
                (OM: The Single-Syllable Nuclear Bomb): "The Upanishad violently declares that the absolute Password of the universe is strictly one—'OM'!"
                "'Omityekaksharam Brahma'—This single syllable OM is the explicit acoustic manifestation of the 'Supreme Brahman' (God)."
                "All the scriptures and libraries on Earth are reduced to worthless scrap paper before the status of this single word."
                "Lord Narayana commands: 'Tanmantram Tarakam Viddhi'—Explicitly 'Recognize' (Viddhi) this mantra as the 'Taraka' (The Savior)!"
                "It is the literal blade engineered to sever the titanium ropes that have bound you to the cycle of birth and death for eons."
                "When you roar OM, you are effectively Deleting your 'Human ID' from the cosmic server and Logging In with the 'ID of God'."
                "OM is the solitary frequency capable of jamming the Radar of Death and transporting you infinitely beyond space."
                "You are not supposed to merely chant it; you must 'Detonate' it inside every single microscopic atom of your DNA."
                "He who has Hacked the secret of OM possesses zero need to beg for any other god or pathetic religion."
                "This is the absolute 'Master Key' that simultaneously unlocks the gates of Heaven, Hell, and absolute Moksha!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 9,
            sanskrit = "आदित्यमण्डले प्रतिष्ठितं पुरुषं ध्यायेत् । स परमात्मा स परं ब्रह्म ॥",
            hindi = """
                (सूर्य-मण्डल का ध्यान और परमेश्वर का दर्शन): "अब योगी को अपनी आँखें उस धधकते हुए सूर्य (आदित्य) पर लगानी हैं जो अंतरिक्ष का पावर-हाउस है।"
                "'आदित्यमण्डले प्रतिष्ठितं पुरुषं'— उस सूर्य के धधकते गोले के ठीक बीचों-बीच जो अजेय 'पुरुष' बैठा है, उसका 'ध्यान' करो!"
                "वह सूर्य केवल एक तारा नहीं है, वह साक्षात् उस परब्रह्म की 'भौतिक आँख' (Physical Eye) है जो सब कुछ देख रही है।"
                "जब तुम उस सूर्य की आग में अपनी चेतना को जलाते हो, तो तुम्हें 'परमात्मा' के साक्षात् दर्शन होते हैं।"
                "वह परमात्मा कोई और नहीं, 'स परं ब्रह्म'— वह साक्षात् वह 'परब्रह्म' (Supreme Void) ही है!"
                "यह ध्यान तुम्हारी आँखों के रेटिना को नहीं, बल्कि तुम्हारी आत्मा के परदे को जलाकर साफ़ कर देता है।"
                "सूरज की वह रेडियोएक्टिव गर्मी तुम्हारे अज्ञान के कचरे को भाप बनाकर उड़ा देती है।"
                "तुम जान जाते हो कि जो प्रकाश उस मण्डल में है, वही प्रकाश तुम्हारी आँखों के पीछे भी धधक रहा है।"
                "यहाँ आकर 'देखने वाला' और 'देखा जाने वाला' दोनों एक ही आग बन जाते हैं।"
                "यह ब्रह्मांड की सबसे बड़ी ताक़त से आँखें मिलाने का सबसे साहसिक और आत्मघाती (Suicidal) योग है!"
            """.trimIndent(),
            english = """
                (Meditating on the Solar Orb and Witnessing God): "Now the Yogi must violently Lock his eyes onto that blazing Sun (Aditya), the absolute radioactive powerhouse of space."
                "'Adityamandale Pratishtitam Purusham'—Directly in the dead-center of that blazing solar orb sits the invincible 'Purusha'; focus your 'Meditation' strictly on Him!"
                "That Sun is absolutely no mere star; it is the explicit 'Physical Eye' of the Supreme Brahman witnessing every microscopic event."
                "When you incinerate your consciousness in the radioactive fire of that Sun, you intercept the physical manifestation of 'Paramatma'."
                "That Supreme Soul is none other than 'Sa Param Brahma'—He is explicitly that 'Supreme Brahman' (The Absolute Void) Himself!"
                "This meditation does not burn your physical retina, but violently purges the veil of your Soul with divine radiation."
                "The radioactive heat of the Sun vaporizes the garbage of your biological ignorance into nothingness."
                "You flawlessly realize that the Light established in that Solar Orb is the exact same Light pulsating behind your own eyelids."
                "Arriving here, the 'Observer' and the 'Observed' fuse into a singular, catastrophic cosmic Fire."
                "This is the most courageous and 'Suicidal' Yoga of staring directly into the absolute greatest power of the cosmos!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 10,
            sanskrit = "योऽयं नारायणः स विष्णुः स शिवः स ब्रह्मा स इन्द्रः स परः ॥",
            hindi = """
                (नारायण की असीमित ताक़त: सब उसी का नाटक हैं): "उपनिषद यहाँ सारे देवताओं की अलग-अलग पहचान का बेरहमी से कत्ल कर देता है।"
                "'योऽयं नारायणः'— यह जो असीम और प्रलयंकारी 'नारायण' है, वही साक्षात् 'विष्णु' है जो दुनिया चलाता है!"
                "'स शिवः'— वही साक्षात् महाकाल 'शिव' है जो ब्रह्मांड को जलाकर राख कर देता है!"
                "'स ब्रह्मा स इन्द्रः'— वही साक्षात् सृष्टिकर्ता 'ब्रह्मा' है और वही देवताओं का राजा 'इंद्र' भी है!"
                "तुम जिस भी भगवान की पूजा कर रहे हो, वह केवल नारायण की उस असीम ऊर्जा का एक छोटा सा 'छद्म-रूप' (Avatar) है।"
                "नारायण वह 'प्राइमरी सर्वर' (Primary Server) है जिससे ये सारे 'सब-सर्वर' (Sub-servers) जुड़े हुए हैं।"
                "जो मूर्ख इन देवताओं में फर्क देखता है, वह अभी भी माया के उस पुराने सॉफ्टवेयर पर चल रहा है जो करप्ट (Corrupt) हो चुका है।"
                "नारायण का मतलब है— 'वह जगह जहाँ सब कुछ विलीन हो जाता है' (The Final Recess)!"
                "जब तुम नारायण को जान लेते हो, तो तुम्हें पूरी त्रिमूर्ति का पासवर्ड एक साथ मिल जाता है।"
                "यही वह 'परः' (Supreme) सत्य है जिसे जानकर इंसान फिर किसी के सामने हाथ नहीं फैलाता!"
            """.trimIndent(),
            english = """
                (The Limitless Power of Narayana: All Deities are His biological Drama): "The Upanishad executes the ruthless slaughter of the distinct identities of all gods right here."
                "'Yo'yam Narayanah'—This infinite and apocalyptic 'Narayana' is explicitly 'Vishnu' who operates the universe!"
                "'Sa Shivah'—He himself is explicitly 'Shiva' who incinerates the cosmos into absolute dust!"
                "'Sa Brahma Sa Indrah'—He is the explicit Creator 'Brahma' and the literal King of Gods 'Indra' as well!"
                "Whichever God you are pathetically worshipping is merely a microscopic 'Pseudo-Form' (Avatar) of Narayana's infinite radioactive energy."
                "Narayana is the absolute 'Primary Server' to which all these 'Sub-servers' are hardwired."
                "The pathetic fool who hallucinates a difference between these gods is still running on the Corrupt software of the old Matrix."
                "Narayana explicitly means—'The Coordinate where absolutely everything is swallowed and dissolved' (The Final Recess)!"
                "When you decode Narayana, you violently seize the Passwords of the entire Trinity simultaneously."
                "THIS is the 'Parah' (Supreme) truth intercepted which prevents a human from ever begging before anyone again!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 11,
            sanskrit = "यो ह वै तारकं वेद स पाप्मानं तरति स मृत्युं तरति ॥",
            hindi = """
                (पापों का विनाश और मौत की गुलामी से रिहाई): "उपनिषद उस 'नो-रिटर्न' (No-Return) पॉलिसी का ऐलान करता है जो तुम्हें इस नर्क (दुनिया) से बाहर निकालेगी।"
                "'यो ह वै तारकं वेद'— जो कोई भी योद्धा इस 'तारक' के विज्ञान को 100% डिकोड (Decode) कर लेता है..."
                "'स पाप्मानं तरति'— वह अपने पिछले करोड़ों जन्मों के 'हर एक पाप' (पाप्मानं) को एक ही झटके में 'पार' कर जाता है!"
                "पाप केवल एक 'वज़न' (Weight) है जो तुम्हें इस कीचड़ में डुबा कर रखता है; यह मंत्र उस वज़न को भाप बनाकर उड़ा देता है।"
                "'स मृत्युं तरति'— वह मौत के उस खौफनाक और सड़े हुए जबड़े से हमेशा के लिए बाहर निकल जाता है!"
                "जब तक तुम पापों से बँधे हो, तुम यमराज के कैदी हो; लेकिन जब तारक जागता है, तो यमराज के हाथ-पैर फूल जाते हैं।"
                "यह मंत्र तुम्हारी रूह को उस लेवल पर ले जाता है जहाँ न कोई सज़ा है और न कोई इनाम, केवल असीम ताक़त है।"
                "जो इस आवाज़ को अपनी साँसों में गाड़ देता है, वह इस मायावी खेल का एडमिन (Admin) बन जाता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह ब्रह्मास्त्र है जो हर डर को जलाकर राख कर देगा।"
                "यह इंसान के म्यूटेशन (Mutation) का वह खूनी सच है जिसे जानकर कोई वापस इंसान नहीं रह सकता!"
            """.trimIndent(),
            english = """
                (The Destruction of Sins and Release from the Slavery of Death): "The Upanishad violently announces the 'No-Return' policy engineered to eject you from this biological hell (Earth)."
                "'Yo ha vai tarakam veda'—Whosoever warrior successfully Decodes (Veda) the science of this 'Taraka' (OM) 100%..."
                "'Sa papmanam tarati'—He violently 'Crosses' every microscopic and catastrophic 'Sin' (Papmanam) of his billions of past incarnations!"
                "Sin is strictly a 'Weight' engineered to keep you drowned in this mud; this mantra vaporizes that weight into radioactive nothingness."
                "'Sa mrityum tarati'—He permanently exits the horrific, rotting jaws of Death forever!"
                "As long as you are shackled by sins, you are a prisoner of Yamaraja; but when Taraka awakens, the God of Death trembles in terror."
                "This mantra skyrockets your soul to a level where zero punishment and zero reward exist, strictly infinite Power."
                "He who hammers this frequency into his biological breath mutates into the absolute Admin of this deceptive game."
                "The Matrix will attempt to flinch you, but you possess the Brahmastra that incinerates every fear into absolute ash."
                "This is the bloody truth of human Mutation; once intercepted, one can absolutely never remain a pathetic human again!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 12,
            sanskrit = "एतदुपासितव्यं नान्यत् । य एवं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (केवल नारायण: दूसरी सब पूजा बेकार है): "भगवान नारायण एक हिंसक और तानाशाह वाला आदेश देते हैं— 'एतदुपासितव्यं नान्यत्'!"
                "केवल इसी एक सत्य (नारायण/ॐ) की उपासना करो, 'किसी और' (नान्यत्) फालतू चीज़ के पीछे मत भागो!"
                "जब तुम्हारे पास ब्रह्मांड का मास्टर पासवर्ड है, तो तुम छोटी-मोटी ताक़तों के पीछे क्यों रो रहे हो?"
                "दुनिया के बाकी सारे धर्म, सारे गुरु और सारे कर्मकांड केवल माया की भूलभुलैया (Labyrinth) हैं।"
                "अपना पूरा फोकस, अपना पूरा खून और अपनी पूरी रूह केवल इसी एक सत्य पर ठोक (Lock) दो।"
                "परिणाम क्या होगा? 'य एवं वेद स मुक्तिमवाप्नोति'!"
                "जो इस नंगे सच को 'जान' (वेद) लेता है, वह इसी पल, 100% गारंटी के साथ परम 'मुक्ति' (Absolute Freedom) को हासिल कर लेता है।"
                "मुक्ति कोई मरने के बाद मिलने वाली खैरात नहीं है; यह अज्ञान की ज़ंजीरों का 'सद्यः' (अभी) टूटना है।"
                "तुम इसी शरीर के अंदर रहते हुए साक्षात् भगवान की तरह आज़ाद हो जाते हो।"
                "यह वह 'टोटल सरेंडर' (Total Surrender) है जो तुम्हें पूरे ब्रह्मांड का मालिक बना देता है!"
            """.trimIndent(),
            english = """
                (Narayana Strictly: All Other Worship is Worthless Garbage): "Lord Narayana issues a violent and dictatorial command—'Etad-upasitavyam nanyat'!"
                "Worship strictly and exclusively this ONE truth (Narayana/OM), and absolutely 'Zero Else' (Nanyat) must you chase!"
                "When you possess the Master Password of the cosmos, why exactly are you crying after pathetic microscopic powers?"
                "All other religions, all gurus, and all worldly rituals are strictly the deceptive Labyrinth of Maya engineered to keep you trapped."
                "Hammer your entire Focus, your entire blood, and your entire Soul strictly onto this solitary Truth (Lock)."
                "What is the explicit outcome? 'Ya evam veda sa muktim-avapnoti'!"
                "He who 'Knows' (Veda) this naked truth violently acquires absolute 'Liberation' (Mukti) with a 100% cosmic guarantee in this microsecond."
                "Moksha is absolutely no pathetic charity granted after death; it is the 'Sadyah' (Immediate) shattering of the chains of ignorance."
                "You become explicitly liberated, functioning as God Himself while still residing inside this biological shell."
                "This is the 'Total Surrender' protocol that mutates you into the absolute Dictator of the entire infinite cosmos!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 13,
            sanskrit = "विष्णोर्यत्परमं पदं सदा पश्यन्ति सूरयः ॥",
            hindi = """
                (विष्णु का परम पद और योगियों की नज़र): "भगवान विष्णु का वह 'परम पद' (Dimension) कोई आसमान की जगह नहीं, वह चेतना का सर्वोच्च स्तर है।"
                "जो 'सूरयः' यानी अत्यंत बुद्धिमान और खूँखार योगी हैं, वे उसे 'सदा' यानी हर पल अपनी आँखों के सामने नंगा खड़ा देखते हैं।"
                "उनकी नज़र अज्ञान के हर पर्दे को फाड़कर सीधे उस 'ब्लैक होल' को हैक कर लेती है जहाँ ईश्वर बैठा है।"
                "वे दुनिया के तमाशे को नहीं देखते, वे उस सोर्स कोड (Source Code) को देखते हैं जिससे यह दुनिया चल रही है।"
                "यह ध्यान तुम्हारी आँखों को 'दिव्य चक्षु' में बदल देता है जो दीवारों के आर-पार देख सकते हैं।"
                "विष्णु का वह पद साक्षात् उस असीम शून्यता का नाम है जहाँ समय और स्थान जलकर राख हो जाते हैं।"
                "योगी उस पद को अपने हृदय की गहराई में एक जलती हुई मशाल की तरह जलाए रखता है।"
                "वहाँ पहुँचने के बाद तुम वापस इस सड़ी हुई दुनिया और मिट्टी के शरीर में नहीं गिरते।"
                "यह वह 'सुप्रीम हेडक्वार्टर' है जहाँ से तुम पूरे ब्रह्मांड के मालिक बनकर राज करते हो।"
                "जो इस पद को देख लेता है, उसके लिए मौत केवल एक पुराना कपड़ा बदलने जैसा मज़ाक है!"
            """.trimIndent(),
            english = """
                (Vishnu's Supreme State and the Vision of Yogis): "Vishnu's 'Paramam Padam' (The Ultimate Dimension) is zero pathetic geographical location; it is the absolute zenith of consciousness."
                "Those 'Surayah' (Terrifyingly intelligent Yogis) witness that state 'Sada'—meaning eternally, right before their eyes standing naked."
                "Their vision violently shreds every veil of ignorance to directly Hack the 'Black Hole' where God resides."
                "They absolutely do not observe the worldly spectacle; they witness the Source Code relentlessly operating the cosmos."
                "This meditation mutates your biological eyes into 'Divine Vision' capable of piercing through solid matter."
                "Vishnu's state is the explicit name of that infinite Void where Time and Space are incinerated to ash."
                "The Yogi keeps that dimension blazing like a radioactive torch in the abyss of his heart."
                "Upon arriving there, you can absolutely never plummet back into this rotting world or biological shell."
                "This is the 'Supreme Headquarters' from which you rule as the absolute Dictator of the universe."
                "He who witnesses this Pada perceives Death strictly as a pathetic joke, like changing old rags!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 14,
            sanskrit = "तद्विप्रासो विपन्यवो जागृवांसः समिन्धते ॥",
            hindi = """
                (विप्रों की आग और सत्य का जागरण): "वे 'विप्र' यानी वह योद्धा जिन्होंने सत्य को जान लिया है, वे कभी सोते नहीं।"
                "वे 'जागृवांसः' हैं—यानी वे माया के इस सड़े हुए सपने से हमेशा के लिए जाग चुके हैं!"
                "वे अपनी आत्मा की आग से उस विष्णु के पद को और ज़्यादा 'समिन्धते' यानी प्रज्वलित कर देते हैं।"
                "उनकी चेतना एक ऐसी लेज़र बीम (Laser Beam) बन चुकी है जो पूरे अंतरिक्ष में प्रकाश फैला रही है।"
                "वे भगवान की पूजा नहीं करते, वे भगवान की ऊर्जा को अपने भीतर एक रिएक्टर (Reactor) की तरह 'रिएक्ट' करवाते हैं।"
                "सत्य को जानना काफी नहीं है, उस सत्य की आग में हर पल जलना और उसे धधकाना ज़रूरी है।"
                "यह उन लोगों की स्थिति है जिन्होंने अपने अहंकार की बलि देकर साक्षात् 'अमरता' को जीत लिया है।"
                "उनकी हर एक साँस ब्रह्मांड के सोए हुए परमाणुओं को जगाने का काम करती है।"
                "वे इस दुनिया में रहते हुए भी इस दुनिया के नियमों से 100% 'अनप्लग' (Unplug) हो चुके हैं।"
                "यही वह अजेय रुतबा है जहाँ पहुँचकर तुम साक्षात् उस 'परमेश्वर' की जलती हुई आँख बन जाते हो!"
            """.trimIndent(),
            english = """
                (The Fire of Sages and Awakening the Truth): "Those 'Vipras'—the Titan warriors who have intercepted the Truth—absolutely never sleep."
                "They are 'Jagrivamsah'—meaning they have permanently Awakened from the rotting dream of Maya!"
                "Through the fire of their own Souls, they violently 'Kindle/Supercharge' (Samindhate) that state of Vishnu."
                "Their consciousness has mutated into a radioactive Laser Beam broadcasting light throughout the infinite vacuum."
                "They do not worship God; they force the energy of God to 'React' inside them like a literal Nuclear Reactor."
                "Merely knowing the Truth is insufficient; you must eternally burn and blaze within the radiation of that Truth."
                "This is the status of those who have sacrificed their ego to mutationally seize absolute Immortality."
                "Their every biological breath functions to awaken the dormant atoms of the entire infinite universe."
                "Residing in this world, they have been 100% 'Unplugged' from its pathetic laws of physics."
                "This is the invincible status where you mutationally become the explicit Blazing Eye of the Supreme God!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 15,
            sanskrit = "य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की मुहर): "उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है जिसे कोई भी कानून बदल नहीं सकता।"
                "'य एवं वेद'— जो कोई भी योद्धा इस 'आत्मप्रबोध' के खौफनाक और नंगे सच को 100% 'जान' (वेद) लेता है..."
                "किताबें पढ़ना ज्ञान नहीं है; इस सच को अपने डीएनए में तेज़ाब की तरह उतार लेना ही असली 'जानना' है।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' (Radar) से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' (Invisible) है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट (Result) है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बन जाते हो!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and the Seal of Moksha): "The Upanishad delivers a catastrophic verdict here that zero cosmic laws possess the caliber to alter."
                "'Ya evam veda'—Whosoever warrior 'Knows' (Veda) this horrific and naked truth of 'Atmaprabodha' with 100% absolute reality..."
                "Reading pathetic books is not knowledge; injecting this truth into your DNA exactly like boiling acid is authentic 'Knowing'."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status where you mutate explicitly into the 'Death of Death' (Kala of Kala)!"
            """.trimIndent()
        ),
        AtmaPrabodhaShloka(
            id = 16,
            sanskrit = "इत्यात्मप्रबोधोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'आत्मप्रबोध उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "नारायण का कोड मिल गया, तारक की नाव तैयार है, और अब तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' (Log-out) करना है।"
                "जिसने इस ग्रंथ के इन १६ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (नारायण) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही आत्मप्रबोध उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Atmaprabodha Upanishad' achieves its absolute majestic completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Code of Narayana has been intercepted, the Taraka Boat is primed, and now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 16 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Narayana) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutates into the Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Atmaprabodha Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtmaprabodhaUpanishadScreen() {
    val upanishad = remember { AtmaprabodhaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..16) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-16)") },
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
            itemsIndexed(upanishad.atmaprabodhaShlokasList) { _, shloka ->
                AtmaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AtmaShlokaCard(shloka: AtmaPrabodhaShloka) {
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