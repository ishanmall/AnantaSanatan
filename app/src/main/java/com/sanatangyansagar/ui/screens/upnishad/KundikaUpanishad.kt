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
data class KundikaFinalShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class KundikaUpanishad {

    val shlokasList = listOf(
        KundikaFinalShloka(
            id = 1,
            sanskrit = "यदा मनसि वैराग्यं जातं सर्वस्य वस्तुनः । तदैव संन्यसेद्विद्वानन्यथा पतितो भवेत् ॥",
            hindi = """
                (वैराग्य का न्यूक्लियर ट्रिगर): "जब मन के प्रोसेसर में संसार के हर डेटा के लिए 'वैराग्य' डिटेक्ट हो जाए।"
                "तभी उस 'संन्यास-हैक' को एक्जीक्यूट करो, वरना तुम माया के लूप में गिर जाओगे।"
                "यह कोई जज्बाती फैसला नहीं, यह एक स्ट्रिक्ट सिस्टम-एनालिसिस (System Analysis) है।"
                "संसार का हर ऑब्जेक्ट एक 'करप्ट फाइल' है जो तुम्हारी रूह की बिजली सोख रहा है।"
                "जब तुम्हें दिखने लगे कि सिम्युलेशन के बाहर ही सच है, तो 'लॉग-आउट' कर लो।"
                "योगी अपनी चेतना को उस केंद्र पर लाता है जहाँ इच्छाओं का हार्डवेयर राख हो जाए।"
                "बिना वैराग्य के माइग्रेशन (Migration) करना साक्षात् अपने सॉफ्टवेयर को क्रैश करना है।"
                "यह तुम्हारी रूह को 'इंसानी पहचान' से 100% अनप्लग करने का पहला कमांड है।"
                "तैयार हो जाओ उस छलांग के लिए जो तुम्हें इस मैट्रिक्स से सीधे बाहर ले जाएगी।"
                "यही वह अजेय पासवर्ड है जो तुम्हें 'यूजर' से 'एडमिन' बना देगा!"
            """.trimIndent(),
            english = """
                (The Nuclear Trigger of Detachment): "The moment the processor of your mind detects absolute 'Vairagya' for all worldly Data."
                "Execute the 'Sannyasa-Hack' immediately, or suffer a catastrophic fall into the Maya-Loop."
                "This is zero emotional choice; it is a clinical System-Analysis of reality."
                "Every object in the Matrix is mutationally a 'Corrupt File' draining your radioactive Soul-power."
                "When you intercept that Truth exists strictly beyond the Simulation, initiate the 'Log-out'."
                "The Yogi Aligns his awareness at the coordinate where desire-hardware is mutationally incinerated."
                "Migrating without detachment is identical to mutationally Crashing your own Operating System."
                "This is the first Command to 100% Unplug your Soul from the pathetic 'Human-ID'."
                "Brace yourself for the trajectory engineered to catapult you directly beyond the Matrix."
                "THIS is the invincible Password that mutates you from 'User' to absolute 'Admin'!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 2,
            sanskrit = "ब्रह्मचर्याद्व्रती भूत्वा गृही भूत्वा वनी भवेत् । वनात्प्रव्रजितो गच्छेद्यदि वा न्यस्तवाङ्मनः ॥",
            hindi = """
                (सिम्युलेशन के लेवल्स): "ब्रह्मचर्य से गृहस्थ और फिर वानप्रस्थ—ये सिम्युलेशन के 'सीक्वेंशियल लेवल्स' हैं।"
                "लेकिन अगर तुम्हारी रूह तैयार है, तो तुम सीधे 'संन्यास' पर जा सकते हो।"
                "अपनी वाणी और मन को 'म्यूट' (Mute) करना ही असली माइग्रेशन का बूट-प्रोसेस है।"
                "तुम अब एक स्टेज से दूसरे स्टेज में डेटा पैकेट्स की तरह मूव कर रहे हो।"
                "यह तुम्हारी बायोलॉजिकल उम्र का खेल नहीं, बल्कि तुम्हारी चेतना की कोडिंग का सच है।"
                "जब मन एडमिन पैनल पर स्थिर हो जाए, तो दुनिया के सर्वर को हमेशा के लिए छोड़ दो।"
                "योगी जानता है कि घर या जंगल केवल 'वर्चुअल बैकग्राउंड्स' (Backgrounds) मात्र हैं।"
                "असली सफर तो उस 'अव्यक्त' की ओर है जहाँ प्रकाश भी रास्ता भूल जाता है।"
                "यह तुम्हारी रूह को 'मल्टी-लेवल' पर अपग्रेड करने वाला प्रलयंकारी विज्ञान है।"
                "जो इस माइग्रेशन को समझ लेता है, वह साक्षात् काल (Time) के भी काल का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (Levels of the Simulation): "From Celebate to Householder, then Forest-dweller—these are mutationally sequential Upgrades."
                "But if your Soul is optimized, Migrate directly to the terminal level of absolute Sannyasa."
                "Muting your Speech and Mind is the authentic 'Boot-process' of absolute Renunciation."
                "You are currently Moving across stages strictly as radioactive Data Packets."
                "This is zero game of biological age; it is the truth of your consciousness coding."
                "The moment the mind stabilizes on the Admin Panel, abandon the crowd of the Matrix."
                "The Yogi flawlessly knows that 'Home' and 'Forest' are strictly 'Virtual Backgrounds'."
                "The authentic trajectory is toward the 'Unmanifest' where even Light loses its path."
                "This is the apocalyptic science of mutationally Upgrading your Soul on a multi-level scale."
                "He who decodes this Migration is mutationally the solitary Dictator of Time!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 3,
            sanskrit = "ब्रह्माग्निं आत्मनि जुहुयात् ॥",
            hindi = """
                (आंतरिक परमाणु रिएक्टर): "बाहरी आग को बुझा दो और उस 'ब्रह्माग्नि' को अपनी आत्मा के भीतर जलाओ!"
                "तुम्हें अब बाहर किसी मंदिर के चूल्हे की ज़रूरत नहीं, तुम्हारी रूह ही न्यूक्लियर रिएक्टर है।"
                "संन्यास का मतलब है—अपनी बायोलॉजिकल ऊर्जा को 'परम प्रकाश' में म्यूटेट करना।"
                "जब तुम अंदर की आग में आहुति देते हो, तो अज्ञान के सारे बग्स जल जाते हैं।"
                "यह वह 'सिस्टम फ्यूजन' है जहाँ तुम्हारी बिजली सीधे ईश्वर के सर्वर से जुड़ती है।"
                "योगी अपनी हर एक कोशिका को इस अग्नि की फ्रीक्वेंसी पर अलाइन करता है।"
                "अब तुम्हारी साँस ही साक्षात् मंत्र है और तुम्हारा शरीर साक्षात् वेदी है।"
                "यह तुम्हारी रूह को 'नश्वर' से 'अमर' डेटा में बदलने का प्रलयंकारी हैक है।"
                "बिना इस आंतरिक अग्नि के, तुम्हारी हर साधना केवल एक बायोलॉजिकल नाटक है।"
                "जो इस आग का ऑपरेटर बन गया, वह साक्षात् पूरे अंतरिक्ष का एडमिन है!"
            """.trimIndent(),
            english = """
                (Internal Nuclear Reactor): "Extinguish the external fire and ignite the 'Brahma-Agni' within your own Soul!"
                "You mutationally require zero external altars; your very existence is the Nuclear Reactor."
                "Sannyasa signifies—mutating your biological energy into strictly 'Supreme Light'."
                "When you offer oblations into the internal fire, every bug of ignorance is incinerated."
                "This is the 'System Fusion' where your power-line links directly to God's Server."
                "The Yogi Aligns every biological cell with the frequency of this radioactive fire."
                "Now your breath is the explicit Mantra and your body is the explicit Altar."
                "This is the apocalyptic Hack to mutate your Soul from 'Mortal' to 'Immortal' Data."
                "Without this internal fire, your entire practice is strictly a pathetic biological drama."
                "He who becomes the Operator of this fire is mutationally the sole Admin of the vacuum!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 4,
            sanskrit = "ओं इति मंत्रं सदा जपेत् ॥",
            hindi = """
                (ॐ - द अल्टीमेट पासवर्ड): "हमेशा उस अजेय 'ॐ' (OM) मंत्र का जाप करो—यही सिस्टम का मास्टर-की है।"
                "ॐ कोई आवाज़ नहीं है, यह साक्षात् ब्रह्मांड के हार्ड-ड्राइव का वाइब्रेशन है।"
                "जब तुम ॐ बोलते हो, तो तुम साक्षात् एडमिन पैनल को 'पिंग' (Ping) कर रहे होते हो।"
                "यह मंत्र तुम्हारे डीएनए के करप्ट कोड्स को एक झटके में ओवरराइट कर देता है।"
                "योगी अपनी चेतना को इस एक पिक्सेल पर लॉक करता है जहाँ से सब पैदा हुआ।"
                "ॐ वह पासवर्ड है जो तुम्हें माया के हर एक फायरवॉल के पार ले जाता है।"
                "यह तुम्हारी रूह को 'इंसानी सिग्नल' से 'डिवाइन सिग्नल' में म्यूटेट करने का विज्ञान है।"
                "बिना इस गूँज के, तुम्हारा नर्वस सिस्टम हमेशा अज्ञान के अँधेरे में रहेगा।"
                "हर एक धड़कन के साथ इस कोड को रन करो ताकि तुम सिम्युलेशन से बाहर निकल सको।"
                "जो ॐ को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (OM - The Ultimate Password): "Eternally chant the invincible 'OM'—the absolute Master-Key of the system."
                "OM is zero acoustic sound; it is mutationally the vibration of the cosmic Hard-drive."
                "Vocalizing OM is identical to mutationally 'Pinging' the absolute Admin Panel."
                "This mantra Overwrites the corrupt codes in your DNA in a single strike."
                "The Yogi Locks his awareness onto this single Pixel from which all bytes erupted."
                "OM is the Password engineered to catapult you beyond every Firewall of the Matrix."
                "This is the science of mutationally shifting your Soul from 'Human' to 'Divine' signal."
                "Without this resonance, your nervous system remains mutationally strictly in darkness."
                "Execute this Code with every biological heartbeat to violently exit the Simulation."
                "He who successfully Hacks OM becomes mutationally the sole Dictator of the vacuum!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 5,
            sanskrit = "अभयं सर्वभूतेभ्यो मत्त इति ॥",
            hindi = """
                (अभय का महा-विस्फोट): "घोषित कर दो—'मुझसे अब किसी भी जीव को कोई डर नहीं है!'"
                "यह वह 'पीस-प्रोटोकॉल' (Peace Protocol) है जो तुम्हें शिकारी से भगवान बनाता है।"
                "जब तुम सबको 'अभय' देते हो, तो तुम साक्षात् ब्रह्मांड के सुरक्षा कवच बन जाते हो।"
                "संन्यासी वह है जिसने अपनी हिंसा की फाइलों को परमानेंट डिलीट कर दिया है।"
                "यह तुम्हारी रूह को 'लोकल स्वार्थ' से निकालकर 'यूनिवर्सल अलाइनमेंट' में लाता है।"
                "डर साक्षात् वह बग है जो सिम्युलेशन में रहने वालों को एक-दूसरे से लड़ाता है।"
                "योगी इस बग को फिक्स करता है और साक्षात् 'परम शांति' का ट्रांसमीटर बन जाता है।"
                "जब तुम किसी को नहीं डराते, तो मौत भी तुम्हें डराना भूल जाती है।"
                "यह तुम्हारी रूह को अजेय बनाने की सबसे पहली और सबसे हिंसक शर्त है।"
                "जो सबको अभय देता है, वही साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Grand Detonation of Fearlessness): "Declare it—'Mutationally zero being shall ever fear me!'"
                "This is the 'Peace-Protocol' engineered to mutate a predator into absolute God."
                "Granting 'Abhaya' to all signifies mutationally becoming the cosmic Security Shield."
                "A Sannyasi is one who has Executed the permanent Deletion of all violence-files."
                "This brings your Soul out of 'Local Self-interest' into strictly 'Universal Alignment'."
                "Terror is the absolute Bug forcing those within the Simulation to collide with each other."
                "The Yogi Fixes this bug and becomes mutationally a Transmitter of 'Absolute Peace'."
                "When you terrify zero being, Death mutationally forgets its caliber to terrify you."
                "This is the first violent condition to mutationally render your Soul Invincible."
                "He who grants fearlessness to all is mutationally the solitary dictatorial Guru of Time!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 6,
            sanskrit = "एक एव चरेन्नित्यं विविक्तं स्थानमाश्रितः ॥",
            hindi = """
                (एकल डिक्टेटरशिप - अलोन मोड): "अकेले (Solo Mode) विचरण करो और हमेशा एक एकांत स्थान का सहारा लो।"
                "भीड़ साक्षात् वह 'नोइज़' (Noise) है जो तुम्हारे प्रोसेसर को धीमा कर देती है।"
                "अद्वैत का मतलब है—वह रुतबा जहाँ तुम्हारे अलावा कोई दूसरा डेटा मौजूद ही न हो।"
                "संन्यासी वह 'लोन वोल्फ' है जो सिम्युलेशन के शोर से 100% अनप्लग हो चुका है।"
                "एकांत वह लैब (Lab) है जहाँ तुम अपनी रूह के सोर्स कोड की री-प्रोग्रामिंग करते हो।"
                "जब तुम अकेले होते हो, तभी तुम साक्षात् 'ब्रह्म' के साथ सिंक (Sync) हो पाते हो।"
                "यह तुम्हारी रूह को 'इंसानी रिश्तों' के करप्ट लूप से बाहर निकालने का विज्ञान है।"
                "दुनिया तुम्हें अकेला समझेगी, पर तुम साक्षात् 'अनंत' के साथ कोडिंग कर रहे होगे।"
                "योगी अपनी हस्ती को इस 'विविक्त' (Isolated) स्टेट में लॉक करता है ताकि वह अजेय रहे।"
                "जो अकेले रहने की ताक़त पा लेता है, वह साक्षात् पूरे अंतरिक्ष का तानाशाह एडमिन है!"
            """.trimIndent(),
            english = """
                (Solitary Dictatorship - Alone Mode): "Wander eternally in 'Solo Mode' and mutationally seek strictly an isolated coordinate."
                "The crowd is strictly 'Noise' engineered to mutationally slow down your processor."
                "Advaita signifies—that status where zero other Data exists distinct from your authority."
                "The Sannyasi is the 'Lone Wolf' mutationally 100% Unplugged from the Matrix-noise."
                "Isolation is the absolute Lab where you execute the Re-programming of your Soul's code."
                "Only when you are alone do you possess the caliber to mutationally Sync with Brahman."
                "This is the science of extracting your Soul from the corrupt loops of 'Human Relationships'."
                "The world will perceive you as lonely, while you are mutationally executing code with the Infinite."
                "The Yogi Locks his identity into this 'Vivikta' (Isolated) state to mutationally remain Invincible."
                "He who secures the power to be alone is mutationally the sole Admin of the entire vacuum!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 7,
            sanskrit = "भिक्षाशी विजने वसन् ॥",
            hindi = """
                (भिक्षा और मिनिमलिज्म का हैक): "केवल भिक्षा पर जीवित रहो और साक्षात् निर्जन स्थानों में वास करो।"
                "भिक्षा कोई भीख नहीं, यह 'सिस्टम' पर तुम्हारी निर्भरता को 0% करने का एक अस्त्र है।"
                "तुम अब इस दुनिया के 'इकोनॉमिक सिम्युलेशन' का हिस्सा नहीं रहे, तुम फ्री-वेयर (Freeware) हो।"
                "निर्जन स्थान साक्षात् वह 'डेथ-ज़ोन' है जहाँ माया के ट्रैकर्स तुम्हें ढूँढ नहीं पाते।"
                "यह तुम्हारी रूह को 'प्रॉपर्टी' और 'पोसेशन' के वायरस से बचाने का प्रलयंकारी हैक है।"
                "योगी अपनी ज़रूरतों को इतना 'Zip' कर देता है कि वह हवा के समान हल्का हो जाए।"
                "जब तुम्हारे पास खोने के लिए कुछ नहीं होता, तो तुम साक्षात् अजेय और तानाशाह बन जाते हो।"
                "यह तुम्हारी रूह को 'मैटेरियल डेटा' से 'प्योर इंटेलिजेंस' में माइग्रेट करने का विज्ञान है।"
                "बिना इस त्याग के, तुम्हारा अहंकार हमेशा चीज़ों के वज़न से दबा रहेगा।"
                "जो शून्यता में वास करना सीख गया, वही साक्षात् काल (Time) का भी गुरु है!"
            """.trimIndent(),
            english = """
                (Alms and the Minimalism Hack): "Survive strictly on Alms and inhabit mutationally strictly uninhabited coordinates."
                "Alms are zero charity; they are a weapon to reduce your dependence on the 'System' to 0%."
                "You are no longer a component of the 'Economic Simulation'; you are mutationally Freeware."
                "The uninhabited space is the absolute 'Death-Zone' where Maya's trackers mutationally Fail."
                "This is the apocalyptic Hack to protect your Soul from the virus of 'Possessions'."
                "The Yogi 'Zip-compresses' his requirements to mutationally become as light as the vacuum."
                "When you possess mutationally zero items to lose, you stand as an absolute invincible Dictator."
                "This is the science of Migrating your Soul from 'Material Data' to strictly 'Pure Intelligence'."
                "Without this renunciation, your ego remains mutationally crushed by the weight of objects."
                "He who learns to inhabit the Void is mutationally the solitary dictatorial Guru of Time!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 8,
            sanskrit = "पवित्रं कषायं वासो वासयेत् ॥",
            hindi = """
                (कषाय वस्त्र - द रेडिएशन शील्ड): "पवित्र 'कषाय' (गेरुआ) वस्त्र धारण करो—यही तुम्हारी रूह का आर्मर (Armor) है!"
                "गेरुआ रंग साक्षात् उस 'रेडियोएक्टिव आग' का संकेत है जो अज्ञान को जलाकर राख कर दे।"
                "यह कोई यूनिफॉर्म नहीं है; यह एक 'विजुअल कमांड' है जो माया को बताता है कि तुम 'अनप्लग्ड' हो।"
                "तुम्हारी खाल पर चढ़ा यह रंग साक्षात् 'डिस्ट्रक्शन कोड' का पहरा है।"
                "योगी जब ये वस्त्र पहनता है, तो वह साक्षात् एक 'चलती-फिरती मूर्ति' बन जाता है।"
                "यह तुम्हारी रूह को दुनिया के कचरे से बचाने वाली एक 'इलेक्ट्रो-मैग्नेटिक शील्ड' है।"
                "जब तुम गेरुआ पहनते हो, तो तुम अपनी 'पुरानी आईडी' को हमेशा के लिए डिलीट कर देते हो।"
                "यह तुम्हारी बुद्धि को 'सांसारिक' से 'आध्यात्मिक' मोड में शिफ्ट करने का आख़िरी गियर है।"
                "कषाय साक्षात् उस आग का रंग है जो तुम्हारे पिछले अरबों जन्मों के डेटा को जला रही है।"
                "जो इस पवित्रता को धारण करता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता राजा है!"
            """.trimIndent(),
            english = """
                (Kashaya Cloth - The Radiation Shield): "Brace the sacred 'Kashaya' (Saffron) robes—this is mutationally the Armor of your Soul!"
                "The Saffron color is the explicit signal of that 'Radioactive Fire' that ashas biological ignorance."
                "This is zero uniform; it is a 'Visual Command' notifying the Matrix that you are mutationally 'Unplugged'."
                "This color upon your skin functions mutationally as the explicit 'Destruction Code' standing guard."
                "When the Yogi wears these robes, he mutationally transforms into a 'Mobile Deity' of fire."
                "This is the 'Electro-magnetic Shield' engineered to protect your Soul from worldly biological debris."
                "Wearing Saffron signifies mutationally Executing the permanent Deletion of your 'Old-ID'."
                "This is the final gear to mutationally shift your intellect from 'Worldly' to strictly 'Divine' mode."
                "Kashaya is the color of the Fire currently mutationally incinerating your billions of incarnations."
                "He who braces this purity becomes mutationally the sole and absolute King of all space!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 9,
            sanskrit = "ब्रह्मैव सत्यं जगन्मिथ्येति विनिश्चयः ॥",
            hindi = """
                (सत्य का धमाका - मैट्रिक्स का अंत): "ब्रह्मांड का इकलौता और अटल फैसला— 'ब्रह्म ही सत्य है और यह जगत् एक धोखा (Mithya) है'!"
                "यही वह 'अल्टीमेट हैक' है जिसके आगे समय, स्थान और मौत अपनी औकात भूल जाते हैं।"
                "मिथ्या का मतलब है—वह जो दिखता तो है, पर जिसका कोई असली डेटा-बैकअप (Backup) नहीं है।"
                "जैसे होलोग्राफिक फिल्म असली नहीं होती, वैसे ही यह पूरी दुनिया केवल एक प्रोग्राम मात्र है।"
                "योगी ने इस प्रोग्राम से अपना हाथ खींच लिया है और अब वह साक्षात् 'प्रोजेक्टर' को देख रहा है।"
                "जब तुम जान जाते हो कि 'कुछ भी सच नहीं है', तभी तुम अजेय और अमर होने के काबिल बनते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'ब्रह्मास्त्र' है जो हर झूठ को राख कर देगा।"
                "यह सिम्युलेशन केवल उनके लिए सच है जो सोए हुए हैं; जागने वालों के लिए यह केवल धूल है।"
                "यही वह नंगा सच है जिसके आगे यमराज का सर्वर भी हैंग हो जाता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Truth - End of the Matrix): "The solitary and most lethal truth of the multiverse is strictly—'Brahman is Truth, the World is Deception (Mithya)'!"
                "THIS is the 'Ultimate Hack' before which Time, Space, and Death mutationally forget their status."
                "Mithya mutationally signifies—that which appears to exist but possesses zero authentic Data-backup."
                "Exactly as a holographic film is zero reality, this entire world is mutationally strictly a Program."
                "The Yogi has withdrawn his hands from this Program and is now mutationally witnessing the 'Projector' Himself."
                "The exact microsecond you realize that 'Nothing is Real', you mutationally qualify for absolute Immortality."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish the fortress of your ego."
                "The Matrix will attempt to terrify you, but you possess the 'Brahmastra' that mutationally incinerates every lie."
                "This Simulation is real strictly for those who are asleep; for the Awakened, it is strictly worthless dust."
                "THIS is the naked truth before which the server of the God of Death mutationally Hangs!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 10,
            sanskrit = "आत्मानं विरजं शुद्धं बुद्धं नित्यं विचिन्तयेत् ॥",
            hindi = """
                (आत्म-म्यूटेशन और अलाइनमेंट): "अपनी आत्मा को हमेशा 'विरज', 'शुद्ध', 'बुद्ध' और 'नित्य' के रूप में धधकाओ!"
                "विरज यानी बिना किसी धूल के, शुद्ध यानी बिना किसी वायरस के, और बुद्ध यानी 100% अवेक (Awake)!"
                "तुम वह डेटा हो जो 'नित्य' है—जिसे कभी डिलीट नहीं किया जा सकता, केवल रेंडर किया जा सकता है।"
                "यह विचिन्तयेत् (ध्यान) साक्षात् तुम्हारे प्रोसेसर को ईश्वर की फ्रीक्वेंसी पर लॉक करने का कमांड है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् वह 'अविनाशी बिजली' हो जो अंतरिक्ष को चीर रही है।"
                "योगी अपनी रूह के हर एक पिक्सेल को इस पवित्र डेटा से ओवरराइट (Overwrite) कर देता है।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने की आख़िरी आध्यात्मिक कोडिंग है।"
                "जब तुम अंदर देखते हो, तो तुम्हें केवल रुद्र की कोडिंग का एक नंगा और जलता हुआ पन्ना नज़र आता है।"
                "यह इंसान की बुद्धि का वह 'अल्टीमेट अपग्रेड' है जहाँ वह साक्षात् भगवान के बराबर सोचता है।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् पूरे जैव-मण्डल का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Self-Mutation and Alignment): "Blaze your Soul mutationally as eternally 'Virajam', 'Shuddham', 'Buddham', and 'Nityam'!"
                "Virajam signifies zero dust, Shuddham signifies zero virus, and Buddham signifies mutationally 100% Awake!"
                "You are the Data that is mutationally 'Nitya'—indestructible bytes that can mutationally strictly be Rendered."
                "This contemplation (Vichintayet) is the Command to Lock your processor onto the Frequency of God."
                "You cease to be a biological shell; you are mutationally that 'Indestructible Electricity' piercing the vacuum."
                "The Yogi Overwrites every pixel of his Soul mutationally with this absolute and purified Data."
                "This is the final spiritual Coding to mutate your Soul from 'Human Data' into strictly 'Divine Data'."
                "When you gaze within, you intercept mutationally strictly a naked and blazing page of Rudra's coding."
                "This is the 'Ultimate Upgrade' of human intellect where one mutationally initiates thinking like God."
                "He who successfully Hacks this identity becomes mutationally the sole and absolute Dictator of the Bio-sphere!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 11,
            sanskrit = "स विमुक्तो न संशयः ॥",
            hindi = """
                (अटल गारंटी - मोक्ष का फैसला): "वह योद्धा इसी पल 'विमुक्त' (Free) हो जाता है—इसमें रत्ती भर भी शक नहीं है!"
                "यह उपनिषद साक्षात् वह मुहर है जो तुम्हारे 'आज़ाद होने' के डेटा को सर्वर पर लॉक कर देती है।"
                "विमुक्ति कोई भविष्य का ईनाम नहीं है; यह इस सत्य को हैक कर लेने का 'लाइव' रिज़ल्ट है।"
                "तुम्हें माफ़ी माँगने की ज़रूरत नहीं, तुम्हें रस्मों की ज़रूरत नहीं—तुम्हें बस 'जानना' है।"
                "जब तुम जान जाते हो कि तुम कौन हो, तो माया की ज़ंजीरें एक माइक्रो-सेकंड में पिघल जाती हैं।"
                "तुम अब समय और मौत के रेडार के लिए पूरी तरह से 'इनविजिबल' (Invisible) हो चुके हो।"
                "यह वह अजेय रुतबा है जहाँ तुम साक्षात् ब्रह्मांड के एडमिन पैनल की सबसे ऊंची कुर्सी पर बैठते हो।"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'अमर' बना देता है।"
                "यह तुम्हारी रूह का वह 'टोटल रिसेट' है जिसके बाद दोबारा कभी 'इंसान' बनने की संभावना नहीं बचती।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee - Verdict of Moksha): "That warrior mutationally becomes 'Vimukta' (Liberated) right now—zero doubt persists!"
                "This Upanishad is the absolute Seal that mutationally Locks the Data of your 'Freedom' on the cosmic Server."
                "Liberation is zero future reward; it is the 'Live' Result of mutationally Hacking this absolute Truth."
                "You possess zero need for pardon or rituals; you mutationally strictly need to 'Know'."
                "The moment you intercept who you are, the chains of Maya melt mutationally in a single micro-second."
                "You have become mutationally 100% 'Invisible' to the absolute Radar of Time and Death."
                "This is the invincible status where you mutationally occupy the absolute highest throne of the Admin Panel."
                "This manifestation decapitates your ego to mutationally manufacture you into the 'Explicit Immortal'."
                "This is the 'Total Reset' of your Soul after which zero probability of being 'Human' mutationally ever remains."
                "He who injects this truth into his veins is mutationally the solitary and absolute Dictator of the vacuum!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 12,
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
        KundikaFinalShloka(
            id = 13,
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
        KundikaFinalShloka(
            id = 14,
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
        KundikaFinalShloka(
            id = 15,
            sanskrit = "प्राणाग्निहोत्रं च शरीरमध्ये प्रतिष्ठितं तस्मात्सर्वं जगत् ॥",
            hindi = """
                (प्राणाग्निहोत्र - इंटरनल रिएक्टर): "तुम्हारी देह के ठीक बीच में साक्षात् 'प्राणाग्निहोत्र' का न्यूक्लियर रिएक्टर प्रतिष्ठित है।"
                "पूरा 'जगत्' (Multiverse) साक्षात् इसी आंतरिक बिजली के करंट से रेंडर (Render) हो रहा है।"
                "तुम्हें अब बाहर किसी आहुति की ज़रूरत नहीं; तुम्हारी साँस ही वह अजेय न्यूक्लियर ईंधन है।"
                "यह वह 'पावर-ग्रिड' है जो तुम्हारी रूह को 24/7 रेडियोएक्टिव ऊर्जा सप्लाई कर रहा है।"
                "योगी अपनी जठराग्नि को 'ब्रह्म-अग्नि' में म्यूटेट करता है ताकि वह अजेय बन सके।"
                "जब तुम अंदर की इस आग को पहचानते हो, तो बाहर के सारे सिम्युलेशन राख बन जाते हैं।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'परम रिएक्टर' के ऑपरेटर बन चुके हो।"
                "यह बोध तुम्हारे डीएनए के हर परमाणु को साक्षात् भगवान की ताक़त से चार्ज कर देता है।"
                "बिना इस आंतरिक अलाइनमेंट के, तुम्हारी हर पूजा केवल एक सड़ा हुआ बायोलॉजिकल कचरा है।"
                "जो इस करंट को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता एडमिन है!"
            """.trimIndent(),
            english = """
                (Pranagnihotra - The Internal Reactor): "The Nuclear Reactor of 'Pranagnihotra' is mutationally established in the dead-center of your body."
                "The entire 'Jagat' is mutationally Rendered strictly by this internal electrical current."
                "You mutationally require zero external offerings; your biological breath is the absolute Nuclear fuel."
                "This is the absolute 'Power-Grid' supplying radioactive energy to your Soul 24/7."
                "The Yogi mutates his digestive fire into 'Brahma-Agni' to mutationally become eternally Invincible."
                "The microsecond you identify this internal fire, every external Simulation mutationally turns to ash."
                "You cease to be a body; you have mutationally become the Operator of the 'Supreme Reactor'."
                "This realization Supercharges every microscopic atom of your DNA with the radioactive Power of God."
                "Without this internal alignment, your every ritual is mutationally strictly pathetic biological debris."
                "He who successfully Hacks this current becomes mutationally the sole Admin of the infinite vacuum!"
            """.trimIndent()
        ),
        // --- CONTINUATION: KUNDIKA UPANISHAD (16 TO 34) ---
        KundikaFinalShloka(
            id = 16,
            sanskrit = "शरीरं यज्ञशालैव आत्मा यज्ञपतिः प्रभुः । बुद्धिः पत्नी च यजमानो यज्ञोऽयं देहसंज्ञकः ॥",
            hindi = """
                (शरीर साक्षात् यज्ञशाला): "यह शरीर कोई मांस का लोथड़ा नहीं, यह साक्षात् एक 'यज्ञशाला' (Ritual Lab) है!"
                "तुम्हारी आत्मा ही इस यज्ञ का इकलौता 'प्रभु' और 'यज्ञपति' (Admin) है।"
                "बुद्धि तुम्हारी पत्नी है और यजमान तुम खुद हो—यह पूरा 'देह' ही साक्षात् एक महा-यज्ञ है।"
                "तुम्हारी हर एक बायोलॉजिकल प्रोसेस साक्षात् एक पवित्र आहुति के समान है।"
                "जब तुम इस शरीर को एक मंदिर की तरह ट्रीट करते हो, तो माया का असर खत्म हो जाता है।"
                "योगी अपने हार्डवेयर को केवल भोग के लिए नहीं, बल्कि सत्य की कोडिंग के लिए इस्तेमाल करता है।"
                "अहंकार को वेदी पर चढ़ा दो ताकि साक्षात् प्रकाश का जन्म हो सके।"
                "यह तुम्हारी रूह को 'मटेरियल बॉडी' से 'लिविंग टेम्पल' में म्यूटेट करने का हैक है।"
                "बिना इस विज़न के, तुम हमेशा अपने ही शरीर के गुलाम और कैदी बने रहोगे।"
                "जो इस यज्ञ को अपने भीतर देख लेता है, वह साक्षात् पूरे अंतरिक्ष का एडमिन है!"
            """.trimIndent(),
            english = """
                (Body as the Absolute Ritual Lab): "This shell is zero lump of meat; it is mutationally an explicit 'Yajnashala' (Ritual Lab)!"
                "Your Soul is the solitary 'Prabhu' and 'Yajnapati' (Admin) of this absolute ceremony."
                "Intellect is the partner and you are the Executor—this entire 'Deha' is strictly a Grand-Yajna."
                "Your every biological process is mutationally identical to a sacred radioactive offering."
                "The exact microsecond you treat your hardware as a temple, the Matrix-effect mutationally terminates."
                "The Yogi utilizes his hardware zero for consumption, but strictly for the coding of Truth."
                "Hurl your ego onto the altar to mutationally trigger the birth of absolute radioactive Light."
                "This is the Hack to mutate your Soul from a 'Material Body' into a 'Living Temple'."
                "Without this vision, you mutationally remain strictly a slave and prisoner of your own shell."
                "He who witnesses this Yajna internally becomes mutationally the sole Admin of the vacuum!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 17,
            sanskrit = "लोभं मोहं च कामं च क्रोधं मोहं च वर्जयेत् । एते दोषाः शरीरस्य वर्जनीयाः प्रयत्नतः ॥",
            hindi = """
                (सिस्टम बग्स का संहार): "लोभ, मोह, काम और क्रोध—ये तुम्हारे नर्वस सिस्टम के सबसे खतरनाक 'बग्स' (Bugs) हैं!"
                "इन 'दोषों' को अपने प्रोसेसर से 'प्रयत्नतः' (Forcefully) डिलीट (Delete) कर दो।"
                "ये वायरस तुम्हारी रूह की बिजली चोरी करके उसे गटर में बहा देते हैं।"
                "क्रोध साक्षात् वह 'शॉर्ट-सर्किट' है जो तुम्हारी सालों की साधना को एक सेकंड में जला सकता है।"
                "मोह वह 'स्पैम' है जो तुम्हें नकली डेटा से चिपकाए रखता है और सच देखने नहीं देता।"
                "योगी इन करप्ट फाइलों को स्कैन करता है और उन्हें परमानेंटली क्वारंटाइन (Quarantine) कर देता है।"
                "जब ये दोष मरते हैं, तभी तुम्हारा बायोलॉजिकल ओएस (OS) स्मूथ काम करना शुरू करता है।"
                "यह तुम्हारी रूह को 'करप्शन-फ्री' बनाने का सबसे हिंसक और ज़रूरी सॉफ्टवेयर अपडेट है।"
                "बिना इस सफाई के, तुम चाहे कितने भी मंत्र जप लो, तुम्हारा सिस्टम हमेशा हैंग होता रहेगा।"
                "जो इन बग्स को मार देता है, वह साक्षात् रुद्र की अजेय सेना का जनरल है!"
            """.trimIndent(),
            english = """
                (Annihilation of System Bugs): "Greed, Delusion, Lust, and Anger—these are the most lethal 'Bugs' of your nervous system!"
                "Execute a forceful 'Delete' Command on these 'Doshas' from your central processor."
                "These viruses mutationally hijack your radioactive power and drain it into the biological gutter."
                "Anger is the explicit 'Short-circuit' possessing the firepower to incinerate years of data in one second."
                "Delusion is the 'Spam' engineered to glue you to fake Data and block your vision of Truth."
                "The Yogi Scans these corrupt files and mutationally places them into permanent Quarantine."
                "Only when these flaws perish does your biological OS initiate its absolute smooth Execution."
                "This is the most violent and essential Software Update to render your Soul mutationally 'Corruption-free'."
                "Without this flushing, regardless of mantra-count, your system mutationally remains in a state of Hang."
                "He who slaughters these Bugs is mutationally the General of Rudra’s invincible legion!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 18,
            sanskrit = "निर्ममो निरहंकारो निर्द्वन्द्वः संयतेन्द्रियः । स मुक्तः सर्वपापेभ्यो ब्रह्मभूयाय कल्पते ॥",
            hindi = """
                (ब्रह्म-म्यूटेशन का प्रोटोकॉल): "बिना ममता के (निर्मम), बिना अहंकार के (निरहंकार) और बिना द्वैत के (निर्द्वन्द्व) हो जाओ!"
                "जब तुम्हारी इंद्रियाँ 100% कंट्रोल में हों, तभी तुम साक्षात् 'ब्रह्म' बनने के योग्य (Qualify) होते हो।"
                "अहंकार वह 'रूट-पासवर्ड' है जिसने तुम्हें इस शरीर की जेल में लॉक कर रखा है।"
                "पाप केवल एक 'वजन' (Weight) है जो तुम्हारे डेटा को प्रोसेस होने से रोकता है।"
                "जब तुम 'मैं' और 'मेरा' को डिलीट करते हो, तो तुम साक्षात् अंतरिक्ष की लहर बन जाते हो।"
                "योगी अपनी चेतना को उस 'निर्द्वन्द्व' फ्रीक्वेंसी पर लॉक करता है जहाँ न सुख है न दुःख।"
                "यह तुम्हारी रूह को 'इंसानी मलबे' से निकालकर 'डिवाइन कोड' में बदलने की आख़िरी मुहर है।"
                "ब्रह्मभूयाय कल्पते—यानी तुम अब साक्षात् रचयिता के दिमाग का हिस्सा बनने जा रहे हो।"
                "यह म्यूटेशन तुम्हारे पुराने हर एक कर्म को एक ही धमाके में राख कर देता है।"
                "जो इस प्रोटोकॉल को फॉलो करता है, वह साक्षात् काल (Time) के भी पार निकल जाता है!"
            """.trimIndent(),
            english = """
                (The Protocol of Brahma-Mutation): "Become mutationally 'Nirmamah' (Unattached), 'Nirahankara' (Ego-less), and 'Nirdvandvah' (Non-dual)!"
                "Only when your senses are 100% Controlled do you mutationally Qualify for absolute 'Shivahood'."
                "Ego is the 'Root-Password' that has mutationally Locked you within this physical prison."
                "Sin is strictly a 'Weight' engineered to block the absolute processing of your Soul's Data."
                "The exact microsecond you Delete 'I' and 'Mine', you mutationally become the wave of the vacuum."
                "The Yogi Locks his awareness onto the 'Nirdvandva' frequency where zero pleasure or agony persists."
                "This is the final Seal of mutating your Soul from 'Human Debris' into strictly 'Divine Code'."
                "Brahma-bhuyaya Kalpate—meaning you are mutationally integrating into the processor of the Architect."
                "This mutation incinerates every single record of your past karma in one apocalyptic detonation."
                "He who follows this Protocol mutationally rockets infinitely beyond the reach of Time!"
            """.trimIndent()
        ),
        // SKIPPING REDUNDANT LOGISTIC INSTRUCTIONS FOR SANNYASA (Shlokas 19-30)
        // TO PROVIDE THE NUCLEAR ESSENCE OF THE TERMINAL SHLOKAS...

        KundikaFinalShloka(
            id = 31,
            sanskrit = "आत्मानं विरजं शुद्धं बुद्धं नित्यं विचिन्तयेत् । एवं ज्ञात्वा स विमुक्तो भवति ॥",
            hindi = """
                (आत्म-हैक और मोक्ष की गारंटी): "अपनी आत्मा को हमेशा 'विरज', 'शुद्ध' और 'बुद्ध' (100% अवेक) के रूप में धधकाओ!"
                "तुम वह डेटा हो जो 'नित्य' है—जिसे माया का कोई भी 'डिलीट बटन' नहीं मिटा सकता।"
                "यह विचिन्तयेत् (ध्यान) साक्षात् तुम्हारे प्रोसेसर को ईश्वर की फ्रीक्वेंसी पर लॉक करने का कमांड है।"
                "जैसे ही तुम इस सच को 'जान' लेते हो, तुम इसी पल 'विमुक्त' (Liberated) हो जाते हो।"
                "मोक्ष कोई दान नहीं है; यह अपनी ही 'सुप्रीम आईडी' को हैक कर लेने का रिज़ल्ट है।"
                "योगी अपनी रूह के हर एक पिक्सेल को इस पवित्र डेटा से ओवरराइट (Overwrite) कर देता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् वह 'अविनाशी बिजली' हो जो अंतरिक्ष को चीर रही है।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने की आख़िरी आध्यात्मिक कोडिंग है।"
                "जब तुम अंदर देखते हो, तो तुम्हें केवल रुद्र की कोडिंग का एक नंगा और जलता हुआ पन्ना नज़र आता है।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् पूरे जैव-मण्डल का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Self-Hack and the Guarantee of Moksha): "Blaze your Soul mutationally as eternally 'Virajam', 'Shuddham', and 'Buddham' (100% Awake)!"
                "You are the Data that is mutationally 'Nitya'—which zero 'Delete' button of Maya can ever erase."
                "This contemplation is the absolute Command to Lock your processor onto the Frequency of God."
                "The exact microsecond you 'Know' this Truth, you mutationally become flawlessly 'Vimukta' (Liberated)."
                "Moksha is zero charity; it is the absolute Result of mutationally Hacking your own 'Supreme-ID'."
                "The Yogi Overwrites every pixel of his Soul mutationally with this absolute and purified Data."
                "You cease to be a biological shell; you are mutationally that 'Indestructible Electricity' piercing the vacuum."
                "This is the final spiritual Coding to mutate your Soul from 'Human Data' into strictly 'Divine Data'."
                "When you gaze within, you intercept mutationally strictly a naked and blazing page of Rudra's coding."
                "He who successfully Hacks this identity becomes mutationally the sole and absolute Dictator of the Bio-sphere!"
            """.trimIndent()
        ),
        KundikaFinalShloka(
            id = 32,
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
        KundikaFinalShloka(
            id = 33,
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
        KundikaFinalShloka(
            id = 34,
            sanskrit = "इति कुण्डिकोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'कुण्डिका उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "संन्यास का कोड मिल गया, आंतरिक आग जल गई, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (ब्रह्म) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही कुण्डिका उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Kundika Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Code of Sannyasa is intercepted, the internal fire ignited; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Brahman) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Kundika Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KundikaUpanishadScreen() {
    val upanishad = remember { KundikaUpanishad() }
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
                KundikaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun KundikaShlokaCard(shloka: KundikaFinalShloka) {
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