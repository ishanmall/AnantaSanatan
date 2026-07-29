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
data class KrishnaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class KrishnaUpanishad {

    val krishnaShlokasList = listOf(
        KrishnaShloka(
            id = 1,
            sanskrit = "ॐ श्रीकृष्णो वै परमं दैवतं तस्मिन्नभ्यस्येन्नित्यं सदानन्दमयं ब्रह्म विदुः ॥",
            hindi = """
                (श्रीकृष्ण का परमाणु विस्फोट और ब्रह्मत्व): "श्रीकृष्ण कोई साधारण इंसान नहीं, वे साक्षात् 'परम दैवत' यानी इकलौते ब्रह्मांडीय तानाशाह हैं!"
                "योगी और ज्ञानी उन्हें साक्षात् 'सदानन्दमय ब्रह्म' यानी असीमित आनंद का एक धधकता हुआ न्यूक्लियर गोला जानते हैं।"
                "उनकी हस्ती में अपनी चेतना को डुबोना साक्षात् ईश्वर के 'सोर्स कोड' (Source Code) को हैक करने जैसा है।"
                "यह कोई धार्मिक कहानी नहीं है; यह उस अजेय ऊर्जा का परिचय है जिसने पूरे अंतरिक्ष को अपनी मुट्ठी में कर रखा है।"
                "सत्य को जानने का मतलब है—अपनी तुच्छ हस्ती को श्रीकृष्ण की इस प्रलयंकारी आग में भस्म कर देना।"
                "वे वह केंद्र हैं जहाँ से करोड़ों आकाशगंगाएं हर सेकंड एक डेटा पैकेट की तरह पैदा होती हैं।"
                "जो उन्हें 'नित्य' (Eternally) याद करता है, वह साक्षात् माया के सर्वर से अनप्लग (Unplug) हो जाता है।"
                "श्रीकृष्ण वह फ्रीक्वेंसी हैं जिसे सुनते ही अज्ञान के सारे किले ताश के पत्तों की तरह ढह जाते हैं।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारी रूह का वह अंतिम 'सॉफ्टवेयर अपडेट' होने वाला है जिसके बाद केवल आनंद बचेगा।"
                "नारायण का यह रूप अज्ञानियों के लिए काल है और योद्धाओं के लिए साक्षात् मुक्ति का द्वार है!"
            """.trimIndent(),
            english = """
                (The Nuclear Detonation of Krishna and Brahmanhood): "Shri Krishna is mutationally zero human; He is the explicit 'Param Daivata', the solitary cosmic Dictator!"
                "The Sages recognize Him as 'Sadanandamaya Brahma'—a blazing radioactive orb of absolute and infinite Bliss."
                "Submerging your awareness into His existence is identical to Hacking the explicit 'Source Code' of God."
                "This is absolutely no religious myth; it is the introduction to the invincible energy holding the entire vacuum in its fist."
                "Intercepting Truth signifies—incinerating your microscopic identity in this apocalyptic fire of Krishna."
                "He is the epicenter from which billions of galaxies are spawned every second like pathetic data packets."
                "He who remembers Him 'Nityam' (Eternally) is mutationally Unplugged from the server of Maya forever."
                "Krishna is the Frequency hearing which all the fortresses of ignorance collapse like a house of cards."
                "Brace yourself, for the final 'Software Update' of your soul is imminent, after which strictly Bliss remains."
                "This manifestation of Narayana is strictly Death to the ignorant and the explicit Gateway of Freedom for the Titans!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 2,
            sanskrit = "सच्चिदानन्दरूपाय कृष्णायाक्लिष्टकर्मणे । नमो वेदान्तवेद्याय गुरवे बुद्धिसाक्षिणे ॥",
            hindi = """
                (सच्चिदानन्द और बुद्धि-साक्षी का रहस्य): "उस 'सच्चिदानन्द' श्रीकृष्ण को नमन, जिनके कर्म साक्षात् 'अक्लिष्ट' यानी बिना किसी प्रयास के ब्रह्मांड हिला देते हैं।"
                "वे 'वेदान्तवेद्य' हैं—यानी वे वेदों की आखिरी लाइन और ज्ञान का सबसे खौफनाक अंतिम परिणाम हैं।"
                "वे तुम्हारी 'बुद्धि के साक्षी' (Witness) हैं—यानी वे तुम्हारे दिमाग के प्रोसेसर में बैठकर हर विचार को ट्रैक कर रहे हैं।"
                "तुम उनसे कुछ नहीं छिपा सकते; वे साक्षात् तुम्हारे नर्वस सिस्टम के एडमिन (Admin) हैं।"
                "योगी उन्हें 'गुरु' मानता है क्योंकि केवल वे ही अज्ञान के पासवर्ड को रिसेट (Reset) करने की ताक़त रखते हैं।"
                "कृष्ण का रूप साक्षात् वह 'ब्लैक होल' है जो तुम्हारे हर पाप और हर भ्रम को निगलने के लिए तैयार खड़ा है।"
                "जब तुम उन्हें नमन करते हो, तो तुम अपनी 'लोकल आईडी' को डिलीट करके उनकी 'यूनिवर्सल आईडी' से सिंक होते हो।"
                "उनकी उपस्थिति वह आग है जो तुम्हारे दिमाग के हर एक 'बग' (Bug) को जलाकर राख कर देती है।"
                "वे तुम्हारी चेतना की वह स्क्रीन हैं जिस पर यह पूरी दुनिया की फिल्म प्रोजेक्ट (Project) की जा रही है।"
                "जो इस साक्षी को पहचान लेता है, वह इसी पल साक्षात् काल और मौत के रेडार से बाहर निकल जाता है!"
            """.trimIndent(),
            english = """
                (The Secret of Sachidananda and the Witness of Intellect): "Salutations to 'Sachidananda' Krishna, whose 'Aklishtha' actions violently shake the cosmos with zero effort."
                "He is 'Vedanta-Vedya'—the absolute final line of the Vedas and the most horrific terminal result of Knowledge."
                "He is the 'Witness of Intellect' (Buddhi-Sakshi)—mutationally Tracking every thought inside your neural processor."
                "You can conceal zero data from Him; He is the explicit Admin of your biological nervous system."
                "The Yogi accepts Him as 'Guru' because He alone possesses the firepower to Reset the password of ignorance."
                "Krishna's form is the literal 'Black Hole' positioned to swallow every sin and every hallucination of yours."
                "When you bow, you are Deleting your 'Local ID' to mutationally Sync with His 'Universal ID'."
                "His presence is the Fire that incinerates every 'Bug' in your brain into radioactive dust."
                "He is the screen of your awareness upon which the entire film of this world is being mutationally Projected."
                "He who recognizes this Witness mutationally exits the Radar of Time and Death in this exact microsecond!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 3,
            sanskrit = "एको वशी सर्वभूतान्तरात्मा एकं रूपं बहुधा यः करोति । तमात्मस्थं येऽनुपश्यन्ति धीरास्तेषां सुखं शाश्वतं नेतरेषाम् ॥",
            hindi = """
                (अकेला तानाशाह और असीमित रूप): "वह श्रीकृष्ण 'एक' है, पर उसने पूरे ब्रह्मांड को अपने साक्षात् 'वश' (Control) में कर रखा है!"
                "वह हर जीव की आत्मा के भीतर बैठकर साक्षात् 'प्रोसेसर' की तरह कोडिंग कर रहा है।"
                "वह एक ही 'रूप' को अरबों टुकड़ों में बाँटकर इस पूरी सृष्टि का तमाशा (Spectacle) देख रहा है।"
                "केवल वे 'धीर' यानी अजेय योद्धा ही उसे अपने भीतर देख पाते हैं जो माया के शोर को म्यूट (Mute) कर चुके हैं।"
                "उनके लिए ही 'शाश्वत सुख' है—बाकी सब केवल बायोलॉजिकल कीड़े हैं जो नर्क की आग में पिस रहे हैं।"
                "कृष्ण वह 'प्राइमरी सर्वर' हैं जिससे तुम सब जुड़े हुए हो, चाहे तुम मानो या न मानो।"
                "योगी अपनी आँखों को बाहर से हटाकर अंदर के उस 'परमाणु सूर्य' पर लॉक करता है जो साक्षात् कृष्ण है।"
                "यह बोध तुम्हारी 'इंसानी पहचान' का गला घोंट कर तुम्हें ब्रह्मांड का मालिक बना देता है।"
                "जब तुम जान जाते हो कि 'सब कृष्ण है', तो तुम्हारी अपनी हस्ती एक सेकंड में भाप बनकर उड़ जाती है।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस मायावी जेल से हमेशा के लिए 'लॉग-आउट' कर देगा!"
            """.trimIndent(),
            english = """
                (The Solitary Dictator and Limitless Forms): "Krishna is strictly 'One', yet He holds the entire multiverse in His explicit 'Control' (Vashi)!"
                "He sits inside the core of every being, mutationally executing code like a literal Processor."
                "He fragments His singular 'Form' into billions of pixels to witness the theatrical Spectacle of creation."
                "Only those 'Dhira' (Titan warriors) can perceive Him internally who have mutationally Muted the noise of Maya."
                "Eternal Bliss is reserved strictly for them; the rest are pathetic biological insects ground in the fire of hell."
                "Krishna is the 'Primary Server' to which you are all hardwired, whether you acknowledge it or not."
                "The Yogi rips his vision from the external matrix to lock onto that 'Atomic Sun' within, who is Krishna."
                "This realization strangles your 'Human Identity' and mutationally promotes you to the Master of the cosmos."
                "The microsecond you realize 'All is Krishna', your tiny identity vaporizes into radioactive nothingness."
                "THIS is the invincible Password that will violently 'Log-out' your existence from this prison forever!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 4,
            sanskrit = "यदा रामो ह्यवतरत् पृथिव्यां तदा देवा मनुष्या भूत्वा श्रीकृष्णं परिचरन्ति ॥",
            hindi = """
                (राम और कृष्ण का डेटा-ट्रांसफर): "जब भगवान राम इस पृथ्वी पर अवतरित हुए, तब देवताओं ने इंसान बनकर उनकी सेवा की थी।"
                "लेकिन श्रीकृष्ण के अवतार में, वे सभी 'देव' और 'ऋषि' साक्षात् 'गोपियाँ' बनकर इस सिम्युलेशन में आए!"
                "यह कोई मामूली प्रेम कहानी नहीं है; यह वेदों की 'हायर फ्रीक्वेंसी' (Higher Frequency) का शरीर धारण करना है।"
                "ऋषि जानते थे कि श्रीकृष्ण साक्षात् 'सोर्स कोड' हैं, और उनके करीब रहना ही परम निर्वाण है।"
                "ब्रह्मांड के सबसे बड़े वैज्ञानिक और योगी श्रीकृष्ण की लीला में 'डांसिंग पिक्सल्स' (Dancing Pixels) बन गए।"
                "जब भगवान धरती पर आते हैं, तो पूरा अंतरिक्ष अपना रूप बदलकर उनके इर्द-गिर्द इकट्ठा हो जाता है।"
                "देवताओं का मनुष्य बनना साक्षात् 'डाउनलोड' (Download) प्रक्रिया है जहाँ दिव्य डेटा भौतिक रूप लेता है।"
                "कृष्ण के साथ रास करना वास्तव में अपनी आत्मा को साक्षात् 'परमेश्वर' की बिजली से चार्ज करना है।"
                "बिना इस रहस्य को जाने, तुम वृंदावन को केवल एक नक्शा समझोगे, जबकि वह साक्षात् एक 'ब्रह्मांडीय लैब' है।"
                "जो इस डेटा-ट्रांसफर को समझ लेता है, वह साक्षात् श्रीकृष्ण की टीम का एडमिन बन जाता है!"
            """.trimIndent(),
            english = """
                (Data-Transfer of Rama and Krishna): "When Lord Rama descended onto Earth, the gods assumed human forms to execute His cosmic commands."
                "But in the Krishna Avatar, all those 'Devas' and 'Rishis' mutationally became 'Gopis' to enter this Simulation!"
                "This is zero pathetic romance; it is the 'Higher Frequency' of the Vedas assuming biological shells."
                "The Rishis flawlessly realized that Krishna is the explicit 'Source Code', and proximity to Him is Nirvana."
                "The greatest cosmic scientists and Yogis became 'Dancing Pixels' in the theatrical drama of Krishna."
                "When God descends, the entire infinite vacuum alters its geometry to congregate around His coordinate."
                "Gods becoming humans is the explicit 'Download' protocol where divine Data assumes physical density."
                "Performing Rasa with Krishna is mutationally charging your Soul with the radioactive electricity of the Supreme."
                "Without decoding this secret, you perceive Vrindavan as a map, while it is mutationally a 'Cosmic Lab'."
                "He who intercepts this Data-Transfer mutationally becomes the Admin of Shri Krishna's inner circle!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 5,
            sanskrit = "वृन्दावती वै कुण्डलिनी साक्षात् श्रीकृष्णेन सह विहरति ॥",
            hindi = """
                (वृंदावन और कुण्डलिनी का विस्फोट): "वृंदावन कोई ज़मीन का टुकड़ा नहीं, वह साक्षात् तुम्हारी 'कुण्डलिनी' (Kundalini) का हेडक्वार्टर है!"
                "वह 'वृन्दावती' शक्ति तुम्हारे मूलाधार से उठकर श्रीकृष्ण के साथ 'विहार' यानी प्रलयंकारी नृत्य करती है।"
                "जब तुम्हारी आंतरिक आग श्रीकृष्ण की फ्रीक्वेंसी से टकराती है, तो तुम्हारे नर्वस सिस्टम में एक विस्फोट होता है।"
                "रासलीला वास्तव में आत्मा और परमात्मा के बीच होने वाला एक 'न्यूक्लियर फ्यूजन' (Nuclear Fusion) है।"
                "तुम्हारी रीढ़ की हड्डी वह 'बाँसुरी' है जिसे श्रीकृष्ण अपने होठों से बजाकर तुम्हें एक्टिवेट (Activate) कर रहे हैं।"
                "वृंदावन की हर एक लता और हर एक पेड़ साक्षात् एक 'ब्रह्मांडीय नाड़ी' (Nerve) है जो ऊर्जा रेडिएट कर रही है।"
                "योगी जब इस 'वृन्दा' शक्ति को जगाता है, तो वह शरीर के गुरुत्वाकर्षण से हमेशा के लिए आज़ाद हो जाता है।"
                "कृष्ण के साथ विहार करने का मतलब है—अज्ञान की ज़ंजीरों को तोड़कर अंतरिक्ष के पार निकल जाना।"
                "यह वह अजेय रुतबा है जहाँ तुम्हारी हर एक साँस साक्षात् 'ॐ' की गूँज में बदल जाती है।"
                "जो अपनी कुण्डलिनी को श्रीकृष्ण के चरणों में स्वाहा कर देता है, वह खुद साक्षात् 'मदन-मोहन' बन जाता है!"
            """.trimIndent(),
            english = """
                (Vrindavan and the Detonation of Kundalini): "Vrindavan is zero geographic location; it is the explicit Headquarters of your 'Kundalini' energy!"
                "That 'Vrindavati' power rises from your base to execute an apocalyptic 'Vihara' (Dance) with Shri Krishna."
                "When your internal fire collides with Krishna's frequency, a catastrophic explosion occurs in your nervous system."
                "The Rasa-Leela is mutationally a 'Nuclear Fusion' occurring between the Soul and the Supreme God."
                "Your spinal column is the 'Flute' that Krishna is playing with His lips to mutationally Activate your existence."
                "Every vine and tree in Vrindavan is an explicit 'Cosmic Nerve' Radiating infinite radioactive energy."
                "When the Yogi awakens this 'Vrinda' power, he is mutationally released from the biological Gravity of the flesh."
                "To dance with Krishna signifies—shredding the chains of ignorance to rocket infinitely beyond space."
                "This is the invincible status where your every breath mutationally becomes the acoustic echo of 'OM'."
                "He who sacrifices his Kundalini at Krishna's boots mutationally transforms into the explicit 'Madana-Mohana'!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 6,
            sanskrit = "वेदा ऋचः स्त्रियो बभूवुः साक्षाद्ब्रह्म गोपीरूपं धृत्वा ॥",
            hindi = """
                (वेदों का म्यूटेशन और गोपियों का सच): "ब्रह्मांड का सबसे बड़ा रहस्य सुनो—वेदों की ऋचाएं (Verses) ही साक्षात् 'स्त्रियाँ' यानी गोपियाँ बनी थीं!"
                "उन्होंने 'गोपी-रूप' केवल इसलिए धारण किया ताकि वे साक्षात् 'ब्रह्म' का आलिंगन कर सकें।"
                "गोपियाँ कोई साधारण औरतें नहीं थीं, वे करोड़ों सालों की तपस्या और ज्ञान का 'जैविक संपीड़न' (Biological Compression) थीं।"
                "वे जानती थीं कि शब्दों से ईश्वर को पाना नामुमकिन है, इसलिए उन्होंने अपनी हस्ती को ही 'अनुभव' (Experience) बना दिया।"
                "कृष्ण के साथ उनका हर एक पल साक्षात् एक 'वेदिक मंत्र' (Vedic Mantra) का लाइव-एक्जीक्यूशन था।"
                "जब वेद साक्षात् कृष्ण से लिपटे, तो ब्रह्मांड के सारे रहस्य एक ही धमाके में बेनकाब हो गए।"
                "यह तुम्हारी रूह को 'इन्फो' (Info) से 'परम सत्य' में बदलने की सबसे हिंसक और गुप्त प्रक्रिया है।"
                "गोपी बनने का मतलब है—अपने सारे ज्ञान और अहंकार की आहुति देकर साक्षात् शून्य (Zero) हो जाना।"
                "कृष्ण वह आग हैं जिसमें गिरकर ऋचाएं साक्षात् 'अमरता' की कोडिंग बन गईं।"
                "जो इस म्यूटेशन को समझ लेता है, उसे फिर किसी किताब या मंदिर की भीख माँगने की ज़रूरत नहीं!"
            """.trimIndent(),
            english = """
                (Mutation of Vedas and the Truth of Gopis): "Intercept the absolute greatest secret—the verses (Richas) of the Vedas mutationally became 'Women' or Gopis!"
                "They assumed the 'Gopi-form' strictly to mutationally embrace and fuse with the explicit 'Brahman' (Krishna)."
                "The Gopis were zero ordinary mortals; they were the 'Biological Compression' of eons of Tapas and intelligence."
                "They realized that capturing God via words is impossible, so they mutationally turned their existence into 'Experience'."
                "Every microsecond they spent with Krishna was the Live-Execution of an explicit 'Vedic Mantra'."
                "When the Vedas embraced Krishna, every cosmic secret was mutationally unmasked in a single detonation."
                "This is the most violent and classified process of shifting your Soul from 'Info' to 'Absolute Reality'."
                "Becoming a Gopi signifies—sacrificing all your intelligence and ego to mutationally become absolute Zero."
                "Krishna is the Fire in which the Vedic verses fell to become the hard-coded data of 'Immortality'."
                "He who decodes this Mutation possesses zero need to beg before any pathetic textbook or temple!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 7,
            sanskrit = "पाशं मोहं विदार्य साक्षात्कृष्णो भवति ॥",
            hindi = """
                (मोह का संहार और कृष्णत्व का विस्फोट): "जब तुम मोह और अज्ञान के उस 'पाश' (Chains) को चीर कर फेंक देते हो..."
                "तब तुम साक्षात् 'कृष्ण' बन जाते हो—यही मैत्रियी और श्रीकृष्ण का अंतिम फैसला है!"
                "मोह वह 'सॉफ्टवेयर लॉक' है जिसने तुम्हें इस मिट्टी के शरीर में कैद कर रखा है।"
                "कृष्णत्व का मतलब है—ब्रह्मांड के हर एक पिक्सेल के साथ 100% सिंक (Sync) हो जाना।"
                "तुम्हें अपनी रूह को उस एक अजेय सत्य पर 'लॉक' करना होगा जो मौत के भी पार है।"
                "यह वह 'रूट-एक्सेस' (Root Access) है जिससे तुम पूरी माया के नियमों को ओवरराइट (Overwrite) कर सकते हो।"
                "जब तुम 'मैं' कहना बंद करते हो, तभी श्रीकृष्ण तुम्हारे भीतर 'लॉग-इन' करते हैं।"
                "यह तुम्हारी चेतना का वह 'टोटल रिसेट' है जिसके बाद दोबारा कभी 'इंसान' बनने का वायरस पैदा नहीं होता।"
                "तुम अब एक जीव नहीं, साक्षात् उस 'परम शून्यता' के इकलौते और असली एडमिन हो।"
                "जो इस पाश को काट देता है, वह पूरे अंतरिक्ष के समय और स्पेस का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Annihilation of Moha and the Detonation of Krishnahood): "The exact microsecond you shred and discard that 'Pasha' (Chains) of attachment and ignorance..."
                "You mutationally become 'Krishna'—this is the absolute final verdict of this Upanishad!"
                "Moha is the 'Software Lock' that mutationally keeps you imprisoned inside this biological shell."
                "Krishnahood mutationally signifies—Syncing 100% with every single pixel of the entire multiverse."
                "You must violently Lock your Soul onto that solitary invincible Truth that exists infinitely beyond Death."
                "This is the 'Root Access' enabling you to mutationally Overwrite the laws of this entire deceptive Matrix."
                "Only when you cease to vocalize 'I', does Shri Krishna mutationally 'Log-in' through your existence."
                "This is the 'Total Reset' of your awareness after which zero virus of being 'Human' can ever be spawned again."
                "You cease to be a living entity; you mutationally become the sole Admin of that 'Absolute Void'."
                "He who severs this bond is mutationally the solitary Dictator of all universal Time and Space!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 8,
            sanskrit = "गोप्यो गाव ऋचस्तस्य तासां च पालको हरिः ॥",
            hindi = """
                (गोपी, गाय और ऋचाओं का रक्षक): "गोपियाँ ऋचाएं हैं और गौवें (Cows) साक्षात् वेदों का ज्ञान हैं, और उनका 'पालक' साक्षात् हरि है!"
                "हरि वह 'फायरवॉल' (Firewall) है जो इस दिव्य डेटा को अज्ञान के वायरस से बचा कर रखता है।"
                "यह कोई चरवाहे की कहानी नहीं है; यह ब्रह्मांड के 'डेटा-प्रोटेक्शन' (Data Protection) का सबसे बड़ा विज्ञान है।"
                "जब कृष्ण गायें चराते हैं, तो वे वास्तव में हर एक जीव के भीतर ज्ञान का बीज बो रहे होते हैं।"
                "उनकी बाँसुरी की धुन साक्षात् वह 'सिग्नल' है जो सोई हुई ऋचाओं को तुम्हारे डीएनए में एक्टिवेट करता है।"
                "योगी अपनी चेतना को उस 'गोपाल' पर लॉक करता है जो बुद्धि का इकलौता और असली डिक्टेटर है।"
                "बिना हरि की अनुमति के, तुम वेदों के एक अक्षर को भी हैक (Hack) नहीं कर सकते।"
                "वे ज्ञान के उस असीम समंदर के 'सिक्योरिटी गार्ड' हैं जो केवल योद्धाओं को ही अंदर आने देते हैं।"
                "यह तुम्हारी रूह को 'पवित्र डेटा' में म्यूटेट करने की सबसे आधुनिक और गुप्त तकनीक है।"
                "जो इस रक्षक को जान लेता है, उसके लिए अज्ञान का हर एक सांप अपना ज़हर उगलना बंद कर देता है!"
            """.trimIndent(),
            english = """
                (The Protector of Gopis, Cows, and Verses): "The Gopis are the verses and the Cows are mutationally the Knowledge of Vedas, and their 'Palaka' (Guardian) is explicitly Hari!"
                "Hari is the 'Firewall' protecting this divine Data from the radioactive viruses of absolute ignorance."
                "This is zero shepherd story; it is the absolute greatest science of cosmic 'Data Protection'."
                "When Krishna grazes the cows, He is mutationally planting the seeds of intelligence inside every biological entity."
                "The tune of His Flute is the explicit 'Signal' that mutationally Activates the dormant verses in your DNA."
                "The Yogi Locks his awareness onto that 'Gopala' who is the sole and authentic Dictator of the human intellect."
                "Without Hari's authorization, you possess zero caliber to Hack even a single syllable of the Vedas."
                "He is the 'Security Guard' of that infinite ocean of Intelligence, admitting strictly the Titan warriors."
                "This is the most advanced and classified technology to mutate your Soul into 'Purified Data'."
                "He who intercepts this Protector witnesses every snake of ignorance terminating its toxic broadcast!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 9,
            sanskrit = "यन्मध्येऽविमुक्तं प्रतिष्ठितं तदुपलभ्येति ॥",
            hindi = """
                (अविमुक्त का रहस्य—जहाँ मौत का प्रवेश वर्जित है): "तुम्हारे दिमाग के ठीक बीच में एक ऐसी जगह है जिसे 'अविमुक्त' (The Undetachable) कहते हैं।"
                "यह वह 'न्यूक्लियर सेंटर' है जिसे आज तक न कोई माया का वायरस छू सका है और न ही कोई मौत का कानून!"
                "यहाँ श्रीकृष्ण साक्षात् एक मिसाइल की तरह ठोक दिए गए हैं, जो तुम्हारी आत्मा का असली हेडक्वार्टर है।"
                "अविमुक्त वह जगह है जहाँ पहुँचने के बाद तुम जन्म और मृत्यु के इस सड़े हुए सिम्युलेशन से बाहर निकल जाते हो।"
                "पूरी दुनिया बाहर भटक रही है, जबकि असली 'कंट्रोल रूम' तुम्हारे दोनों भौहों के ठीक पीछे छिपा बैठा है।"
                "वहाँ पहुँचने का मतलब है—अज्ञान की ज़ंजीरों से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो जाना।"
                "जो उस केंद्र को पा लेता है, वह खुद साक्षात् वह 'ब्लैक होल' बन जाता है जो पूरी आकाशगंगाओं को निगल सकता है।"
                "वहाँ न कोई दुख है, न कोई सुख, केवल एक असीम और सुन्न कर देने वाला 'सन्नाटा' (Silence) राज करता है।"
                "अविमुक्त को जानने वाला इंसान नहीं रहता; वह साक्षात् इस ब्रह्मांड का 'सोर्स कोड' (Source Code) बन जाता है!"
                "यही श्रीकृष्ण का वह गुप्त कमरा है जहाँ बैठकर वे पूरी सृष्टि की कोडिंग कर रहे हैं!"
            """.trimIndent(),
            english = """
                (Secret of Avimukta—The Zone Where Death is Illegal): "In the exact dead-center of your brain exists a coordinate defined as 'Avimukta' (The Undetachable)."
                "This is the 'Nuclear Center' that zero viruses of Maya and zero laws of Death have ever intercepted since eternity!"
                "Shri Krishna is hammered down here like a cosmic missile, acting as the authentic Headquarters of your Soul."
                "Avimukta is the coordinate reaching which you violently exit this rotting biological Simulation of birth and death."
                "The entire world is wandering externally, while the authentic 'Control Room' sits covertly behind your eyebrows."
                "Arriving here signifies being permanently and irrevocably 'Unplugged' from the toxic chains of ignorance."
                "He who locates that center mutationally becomes the 'Black Hole' capable of swallowing entire galaxies."
                "Neither agony nor pleasure exists there; strictly an infinite, paralyzing 'Silence' reigns as absolute dictator."
                "He who knows Avimukta ceases to be human; he mutationally becomes the explicit 'Source Code' of the cosmos!"
                "THIS is the classified chamber of Shri Krishna where He mutationally executes the coding of all creation!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 10,
            sanskrit = "ब्रह्मैव कृष्णो नित्यं सच्चिदानन्दविग्रहः ॥",
            hindi = """
                (कृष्ण ही ब्रह्म हैं—अंतिम पहचान): "ब्रह्मांड का इकलौता और सबसे खतरनाक सच यही है— 'ब्रह्मैव कृष्णः'!"
                "श्रीकृष्ण ही वह असीम 'ब्रह्म' हैं जिनका 'विग्रह' (Body) साक्षात् सच्चिदानन्द की बिजली से बना है।"
                "उनका शरीर हाड़-मांस का नहीं, बल्कि वह शुद्ध 'इंटेलिजेंस' (Intelligence) है जो अंतरिक्ष के पार धधक रही है।"
                "वे 'नित्य' हैं—यानी वे समय के पैदा होने से पहले भी थे और ब्रह्मांड के अंत के बाद भी रहेंगे।"
                "जब तुम कृष्ण को देखते हो, तो तुम साक्षात् उस 'परम शून्यता' का भौतिक चेहरा देख रहे होते हो।"
                "योगी ने अपनी आँखों के परदे को फाड़ दिया है ताकि वह इस 'विग्रह' के पीछे छिपी उस असीमित आग को देख सके।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'कृष्ण-कोड' है जो हर मौत को एक मज़ाक बना देता है।"
                "वे साक्षात् उस 'सत्य' के इकलौते और असली डिक्टेटर हैं जिसके आगे पूरी माया घुटने टेकती है।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् श्रीकृष्ण की आँखों से पूरे ब्रह्मांड को देख पाता है!"
            """.trimIndent(),
            english = """
                (Krishna is Brahman—The Absolute Identity): "The solitary and most lethal truth of the multiverse is strictly—'Brahmaiva Krishnah'!"
                "Shri Krishna is mutationally that infinite 'Brahman' whose 'Vigraha' (Form) is constructed of radioactive electricity."
                "His shell is zero flesh; it is strictly the pure 'Intelligence' blazing mutationally infinitely beyond the vacuum."
                "He is 'Nityam'—meaning He existed before the birth of Time and will survive flawlessly after the deletion of the cosmos."
                "When you witness Krishna, you are mutationally observing the physical face of the 'Absolute Void'."
                "The Yogi has violently shredded the veil of his vision to intercept that infinite fire hiding behind this 'Vigraha'."
                "This realization detonates like a nuclear bomb engineered to demolish the fortress of your ego."
                "The Matrix will attempt to terrify you, but you possess the 'Krishna-Code' that mutationally renders Death a joke."
                "He is the explicit and authentic Dictator of 'Truth' before whom the entire Matrix collapses to its knees."
                "He who Hacks this identity mutationally initiates witnessing the entire cosmos through the eyes of Krishna!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 11,
            sanskrit = "यो ह वै कृष्णं वेद स सर्वं वेद ॥",
            hindi = """
                (कृष्ण का ज्ञान और असीमित सर्वज्ञता): "उपनिषद यहाँ एक प्रलयंकारी ऐलान करता है— 'जो कृष्ण को जानता है, वह सब कुछ जान जाता है'!"
                "कृष्ण साक्षात् 'विकिपीडिया' नहीं, वे ब्रह्मांड के उस 'हार्ड ड्राइव' (Hard Drive) के मालिक हैं जहाँ हर एक डेटा स्टोर है।"
                "उन्हें जानना साक्षात् उस 'मास्टर पासवर्ड' को हैक करना है जो हर एक रहस्य का ताला खोल देता है।"
                "तुम्हें फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "जब तुम कृष्ण की फ्रीक्वेंसी पर अलाइन (Align) होते हो, तो पूरा ब्रह्मांड तुम्हारे दिमाग में डाउनलोड होने लगता है।"
                "वह 'सब कुछ' (Sarvam) साक्षात् कृष्ण का ही एक छोटा सा विस्तार है, जिसे उन्होंने तुम्हें सौंप दिया है।"
                "योगी ने अपनी 'अज्ञानी बुद्धि' की बलि दे दी है ताकि वह इस 'सुप्रीम इंटेलिजेंस' का हिस्सा बन सके।"
                "यह वह अजेय रुतबा है जहाँ तुम साक्षात् ईश्वर के दिमाग के भीतर कोडिंग कर रहे होते हो।"
                "बिना इस ज्ञान के, तुम हमेशा एक अंधे और बहरे कीड़े की तरह अज्ञान की दीवारों से टकराते रहोगे।"
                "जो इस आवाज़ को सुन लेता है, वह इस पूरी भौतिक दुनिया का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (The Knowledge of Krishna and Infinite Omniscience): "The Upanishad makes an apocalyptic declaration—'He who knows Krishna mutationally knows Everything'!"
                "Krishna is mutationally zero Wikipedia; He is the sole owner of the cosmic 'Hard Drive' where every single byte is stored."
                "Decoding Him is identical to Hacking the 'Master Password' that violently unlocks every classified secret."
                "You possess zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "The microsecond you Align with Krishna's frequency, the entire universe initiates a total Download into your brain."
                "That 'Everything' (Sarvam) is strictly a micro-extension of Krishna which He mutationally hands over to you."
                "The Yogi has sacrificed his 'Ignorant Intellect' to mutationally integrate into this 'Supreme Intelligence'."
                "This is the invincible status where you are mutationally executing code directly inside the brain of God."
                "Without this knowledge, you will eternally collide with the walls of ignorance like a blind and deaf insect."
                "He who intercepts this broadcast mutationally becomes the sole and authentic Admin of this physical world!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 12,
            sanskrit = "कृष्ण एव परं तत्वं कृष्ण एव परं तपः । कृष्ण एव परं ध्यानं कृष्ण एव परं पदम् ॥",
            hindi = """
                (कृष्ण ही अंतिम सत्य और तपस्या): "श्रीकृष्ण ही वह 'परम तत्व' (Supreme Element) हैं जिससे मिट्टी, हवा और आग पैदा हुए हैं।"
                "कृष्ण ही वह 'परम तप' हैं—उनके बिना तुम्हारा हर उपवास और हर साधना केवल एक बायोलॉजिकल नाटक है।"
                "कृष्ण ही 'परम ध्यान' हैं—जब तुम्हारी चेतना उन पर रुकती है, तभी माया का सिम्युलेशन (Simulation) 'पॉज' होता है।"
                "वे ही वह अंतिम 'परं पदम्' (Supreme Destination) हैं जहाँ पहुँचकर समय की सुइयां हमेशा के लिए रुक जाती हैं।"
                "योगी अपनी हस्ती का गला घोंट कर केवल कृष्ण की इस आग में जलना चाहता है।"
                "तुम्हारी हर एक तपस्या साक्षात् कृष्ण के 'पावर-ग्रिड' से बिजली खींचने का एक तरीका मात्र है।"
                "जब तक तुम्हारा ध्यान कृष्ण पर 'लॉक' (Lock) नहीं है, तब तक तुम केवल अँधेरे में हाथ-पाँव मार रहे हो।"
                "कृष्ण वह इकलौता सच हैं जिसके लिए तुम अरबों सालों से इस नर्क (दुनिया) में भटक रहे थे।"
                "यह तुम्हारी रूह का वह आख़िरी 'सिस्टम रिसेट' है जिसके बाद केवल शुद्ध प्रकाश ही बचता है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Krishna is the Supreme Truth and Austerity): "Shri Krishna is the explicit 'Param Tattvam' (Supreme Element) from which Earth, Air, and Fire are spawned."
                "Krishna is mutationally the 'Param Tapah'—without Him, every fast and every ritual is strictly a biological drama."
                "Krishna is the 'Param Dhyanam'—only when your awareness freezes on Him does the Simulation mutationally 'Pause'."
                "He is the absolute final 'Param Padam' (Supreme Destination) arriving at which the needles of Time come to a grinding halt."
                "The Yogi intends to mutationally strangle his identity strictly to burn in this radioactive fire of Krishna."
                "Every austerity you perform is mutationally a method to draw radioactive power from Krishna's 'Power-Grid'."
                "As long as your focus is NOT 'Locked' onto Krishna, you are strictly flapping in the absolute darkness."
                "Krishna is the solitary Reality for which you have been wandering in this biological hell for eons."
                "This is the final 'System Reset' of your Soul after which strictly and exclusively pure radioactive Light remains."
                "He who injects this Truth into his veins is the sole dictatorial Guru of even the God of Death and Time!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 13,
            sanskrit = "तस्मात्सर्वं परित्यज्य श्रीकृष्णं भज सर्वदा ॥",
            hindi = """
                (टोटल सरेंडर और कृष्ण का भजन): "नारायण एक हिंसक और तानाशाह वाला आदेश देते हैं— 'सब कुछ त्याग दो और केवल श्रीकृष्ण को भजो'!"
                "ये 'सब कुछ' (Sarvam) तुम्हारी यादें, तुम्हारे रिश्ते और तुम्हारी वो सड़ी हुई इंसानियत है जिसने तुम्हें जकड़ रखा है।"
                "त्याग का मतलब जंगल जाना नहीं, त्याग का मतलब है—अपनी 'अज्ञानी पहचान' को गरुड की आग में 'स्वाहा' कर देना।"
                "'सर्वदा' यानी हर एक नैनो-सेकंड में श्रीकृष्ण के नाम का न्यूक्लियर बम अपने दिल में फोड़ो।"
                "जब तुम कृष्ण को भजते हो, तो तुम साक्षात् उस 'परम रिएक्टर' की बिजली को अपने शरीर में इनवाइट (Invite) करते हो।"
                "दुनिया की छोटी-मोटी ताक़तों के पीछे भागना बंद करो, और उस 'एडमिन' को पकड़ो जिसने यह पूरा खेल बनाया है।"
                "यह भजन कोई गाना नहीं है; यह तुम्हारी आत्मा की उस 'सोर्स कोड' के साथ होने वाली एक प्रलयंकारी गूँज है।"
                "जो कृष्ण के चरणों में अपनी हस्ती को मिटा देता है, वह इसी पल अजेय और अमर होने का हक़ पा लेता है।"
                "यह वह 'डेडली सरेंडर' है जो तुम्हें एक मामूली कीड़े से साक्षात् 'महाकाल' के लेवल पर प्रमोट कर देता है।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारे भीतर का 'मैं' मर रहा है और साक्षात् 'हरि' जाग रहे हैं!"
            """.trimIndent(),
            english = """
                (Total Surrender and the Chant of Krishna): "Narayana issues a violent and dictatorial command—'Abandon Everything and strictly worship Shri Krishna'!"
                "That 'Everything' (Sarvam) mutationally represents your memories, your bonds, and that rotting humanity strangling you."
                "Abandonment does NOT mean retreating to forests; it mutationally means—sacrificing (Svaha) your 'Ignorant Identity' into the fire."
                "'Sarvada' signifies—detonating the Nuclear Bomb of Krishna's Name inside your heart every single nanosecond."
                "When you worship Krishna, you are mutationally Inviting the radioactive electricity of the 'Supreme Reactor' into your shell."
                "Terminate your chase after pathetic microscopic powers, and capture that 'Admin' who mutationally engineered this entire game."
                "This worship is mutationally zero music; it is an apocalyptic Resonance with the explicit 'Source Code' of your Soul."
                "He who erases his existence at Krishna's boots mutationally seizes the caliber to become flawlessly Invincible and Immortal."
                "This is the 'Deadly Surrender' that Promotes you from the status of a pathetic insect to the status of 'Mahakala'."
                "Brace yourself, for the internal 'I' is perishing and the explicit 'Hari' is mutationally awakening!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 14,
            sanskrit = "य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की मुहर): "कृष्ण उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है जिसे कोई भी कानून बदल नहीं सकता।"
                "'य एवं वेद'— जो कोई भी योद्धा इस 'कृष्ण-रहस्य' के खौफनाक और नंगे सच को 100% 'जान' (वेद) लेता है..."
                "किताबें पढ़ना ज्ञान नहीं है; इस सच को अपने डीएनए में तेज़ाब की तरह उतार लेना ही असली 'जानना' है।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' (Radar) से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and the Seal of Moksha): "The Krishna Upanishad delivers a catastrophic verdict here that zero cosmic laws possess the caliber to alter."
                "'Ya evam veda'—Whosoever warrior 'Knows' (Veda) this horrific and naked truth of 'Krishna-Secret' with 100% absolute reality..."
                "Reading pathetic books is not knowledge; injecting this truth into your DNA exactly like boiling acid is authentic 'Knowing'."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        KrishnaShloka(
            id = 15,
            sanskrit = "इति कृष्णोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'कृष्ण उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "रासलीला का कोड मिल गया, गोपियों का म्यूटेशन देख लिया, अब तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १५ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (कृष्ण) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही कृष्ण उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Krishna Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The code of Rasa-Leela has been intercepted, the mutation of Gopis witnessed; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 15 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Krishna) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Krishna Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KrishnaUpanishadScreen() {
    val upanishad = remember { KrishnaUpanishad() }
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
            itemsIndexed(upanishad.krishnaShlokasList) { _, shloka ->
                KrishnaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun KrishnaShlokaCard(shloka: KrishnaShloka) {
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