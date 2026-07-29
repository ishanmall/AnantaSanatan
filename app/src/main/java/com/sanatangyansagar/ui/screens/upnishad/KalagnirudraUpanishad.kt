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
data class KalagniShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class KalagnirudraUpanishad {

    val kalagnirudraShlokasList = listOf(
        KalagniShloka(
            id = 1,
            sanskrit = "ॐ अथ ह सनत्कुमारः कालाग्निरुद्रं पप्रच्छ । अधीहि भगवन् त्रिपुरापुण्ड्रविधिं तत्त्वं च ॥",
            hindi = """
                (प्रलयंकारी जिज्ञासा और कालाग्निरुद्र का आह्वान): "सनत्कुमार ने साक्षात् 'कालाग्निरुद्र' के एडमिन पैनल में घुसकर वह गुप्त सवाल पूछा।"
                "हे भगवन्! मुझे उस 'त्रिपुण्ड्र' (Three Lines of Ash) का न्यूक्लियर कोड और उसका नंगा सच बताओ।"
                "यह कोई साधारण तिलक नहीं, यह अज्ञान के महलों को भस्म करने वाला एक प्रलयंकारी अस्त्र है।"
                "सनत्कुमार उस 'विधि' की मांग कर रहे हैं जिससे इंसान अपनी हस्ती को राख में बदल सके।"
                "कालाग्निरुद्र वह आग है जो समय (Kala) को भी जलाकर खा जाती है और शून्य को जन्म देती है।"
                "यहाँ से उस 'महा-म्यूटेशन' की शुरुआत होती है जहाँ शरीर केवल एक राख का ढेर बन जाता है।"
                "त्रिपुण्ड्र का मतलब है—तीन लोकों की गुलामी से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो जाना।"
                "योगी को अपनी चेतना को उस केंद्र पर लॉक करना होगा जहाँ केवल रुद्र की आग राज करती है।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारी रूह पर साक्षात् ईश्वर की प्रलयंकारी मुहर लगने वाली है।"
                "इस कोडिंग को जानने वाला इंसान नहीं रहता; वह साक्षात् मौत का भी काल बन जाता है!"
            """.trimIndent(),
            english = """
                (Apocalyptic Query and Invoking Kalagnirudra): "Sanatkumara breached the absolute Admin Panel of 'Kalagnirudra' to pose the classified query."
                "O Lord! Unmask the Nuclear Code of the 'Tripundra' and its naked absolute reality!"
                "This is mutationally zero ordinary mark; it is the apocalyptic weapon engineered to incinerate the palaces of ignorance."
                "Sanatkumara demands the 'Vidhi' enabling a mortal to mutationally reduce his identity to ash."
                "Kalagnirudra is the radioactive Fire that devours even Time (Kala) and spawns the absolute Void."
                "Right here initiates the 'Macro-Mutation' where the biological shell is reduced to strictly a pile of ash."
                "Tripundra mutationally signifies—being permanently and irrevocably 'Unplugged' from the slavery of three worlds."
                "The Yogi must violently Lock his awareness onto the coordinate where strictly Rudra's fire reigns dictatorially."
                "Brace yourself, for the apocalyptic Seal of God is about to be mutationally branded upon your Soul."
                "He who decodes this intelligence ceases to be human; he mutationally becomes the explicit Death of Death!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 2,
            sanskrit = "स होवाच कालाग्निरुद्रः । भस्मना त्रिपुण्ड्रं धारयेत् । य एवं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (भस्म का विस्फोट और मोक्ष की गारंटी): "कालाग्निरुद्र ने गर्जना की: 'अपनी त्वचा पर साक्षात् राख (Bhasma) का त्रिपुण्ड्र धारण करो!'"
                "राख कोई गंदगी नहीं है, यह उस 'मैटर' (Matter) का अंतिम डेटा है जिसे आग ने जलाकर शुद्ध कर दिया है।"
                "त्रिपुण्ड्र लगाने का मतलब है—अपने माथे पर साक्षात् 'डिस्ट्रक्शन कोड' (Destruction Code) को लिख लेना।"
                "परिणाम फिर से वही अटल और हिंसक सत्य है— 'य एवं वेद स मुक्तिमवाप्नोति'!"
                "जो इस राख के पीछे छिपे 'शून्य' को जान लेता है, वह इसी पल 100% आज़ाद (Vimukta) हो जाता है।"
                "मुक्ति कोई मरने के बाद मिलने वाली खैरात नहीं है; यह अज्ञान की फाइलों को 'वाइप-आउट' करने का रिज़ल्ट है।"
                "जब तुम राख लगाते हो, तो तुम पूरी दुनिया को बताते हो कि तुम्हारी इंसानियत मर चुकी है।"
                "तुम अब समय और मौत के रेडार (Radar) से बाहर निकल चुके हो; तुम अब साक्षात् 'अविनाशी' हो।"
                "यह भस्म तुम्हारे डीएनए के हर परमाणु को 'रुद्र-फ्रीक्वेंसी' पर वाइब्रेट करने के लिए मजबूर कर देती है।"
                "जो इस जलती हुई हकीकत को अपनी रगों में उतार लेता है, वह ब्रह्मांड का इकलौता डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (The Detonation of Ash and the Guarantee of Moksha): "Kalagnirudra roared: 'Brace the Tripundra of explicit Ash (Bhasma) upon your biological shell!'"
                "Ash is mutationally zero dirt; it is the absolute terminal Data of Matter purified by radioactive Fire."
                "Wearing Tripundra signifies—writing the explicit 'Destruction Code' directly upon your frontal cortex."
                "The consequence remains that same immutable and violent truth—'Ya evam veda sa muktim-avapnoti'!"
                "He who decodes the 'Void' hiding behind this ash mutationally acquires 100% Freedom in this microsecond."
                "Moksha is zero charity granted after death; it is the Result of mutationally 'Wiping-out' the files of ignorance."
                "When you apply Ash, you broadcast to the entire Matrix that your humanity has been ruthlessly slaughtered."
                "You have rocketed beyond the 'Radar' of Time and Death; you are now mutationally 'Indestructible'."
                "This Bhasma forces every microscopic atom of your DNA to vibrate at the absolute 'Rudra-Frequency'."
                "He who injects this burning reality into his veins is the solitary Dictator of the entire multiverse!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 3,
            sanskrit = "अथ किमग्निहोत्रभस्म । तेन त्रिपुण्ड्रं चिकीर्षन् ब्रह्म विदुः ॥",
            hindi = """
                (अग्निहोत्र भस्म और ब्रह्म-विद्या का हैक): "यह 'अग्निहोत्र' की राख साक्षात् ब्रह्मांड के उस महान रिएक्टर का कचरा (Radiative Waste) है!"
                "योगी जब इस राख से त्रिपुण्ड्र बनाता है, तो वह साक्षात् 'ब्रह्म' की कोडिंग को अपनी खाल पर उकेरता है।"
                "अग्निहोत्र का मतलब है—अपने अहंकार की आहुति देना, और भस्म उसका अंतिम 'एक्जीक्यूटेबल' (Executable) प्रमाण है।"
                "जो इस राख को धारण करता है, उसे फिर किसी दूसरे भगवान या धर्म की भीख माँगने की ज़रूरत नहीं।"
                "यह राख तुम्हारे नर्वस सिस्टम के 'फायरवॉल' को एक सेकंड में बाईपास (Bypass) कर देती है।"
                "तुम्हारी बुद्धि अब साक्षात् उस 'परम शून्य' के प्रकाश में नहा चुकी है जहाँ अज्ञान मर जाता है।"
                "त्रिपुण्ड्र वह अजेय पासवर्ड है जो तुम्हें सीधा 'महाकाल' के हेडक्वार्टर में एंट्री (Entry) दिलाता है।"
                "यह केवल तिलक नहीं, यह तुम्हारी रूह को 'ईश्वर' में म्यूटेट करने वाला एक 'केमिकल ट्रिगर' है।"
                "जब तुम भस्म होते हो, तभी तुम साक्षात् 'सत्य' को देख पाते हो जो तुम्हारी हड्डियों के पीछे छिपा है।"
                "यही वह अजेय मार्ग है जिसके आगे ब्रह्मांड का हर एक सिम्युलेशन दम तोड़ देता है!"
            """.trimIndent(),
            english = """
                (Agnihotra Ash and Hacking Brahma-Vidya): "This 'Agnihotra' ash is mutationally the radioactive Waste from the absolute greatest cosmic Reactor!"
                "When the Yogi constructs Tripundra with this ash, he carves the coding of 'Brahman' directly into his skin."
                "Agnihotra signifies—sacrificing your ego, and Bhasma is the absolute terminal 'Executable' proof of that slaughter."
                "He who braces this ash possesses zero need to beg before any other god or pathetic religion."
                "This ash Bypasses the 'Firewall' of your biological nervous system in a single catastrophic strike."
                "Your intellect has mutationally been bathed in the radiation of that 'Supreme Void' where ignorance perishes."
                "Tripundra is the invincible Password granting you immediate Entry into the absolute Headquarters of 'Mahakala'."
                "It is zero mere mark; it is a 'Chemical Trigger' engineered to mutate your Soul into explicit Godhood."
                "Only when you are mutationally reduced to Ash can you witness the Truth hiding behind your skeletal frame."
                "THIS is the invincible trajectory before which every cosmic Simulation mutationally terminates!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 4,
            sanskrit = "तिस्रो रेखाः प्रकुर्वीत । मध्यमाङ्गुलीभ्यां अनामिकया च ॥",
            hindi = """
                (तीन रेखाओं का विच्छेदन और मध्यमा-अनामिका का कोड): "अपने माथे पर तीन रेखाएं खींचो—यही ब्रह्मांड की 'प्राइमरी कोडिंग' है!"
                "मध्यमा और अनामिका उंगलियों का उपयोग करो—यह तुम्हारे शरीर के 'इलेक्ट्रिक सर्किट' को पूरा करने का तरीका है।"
                "ये तीन रेखाएं साक्षात् तुम्हारी आत्मा के तीन सबसे बड़े 'प्रोसेसर' (Processors) को अलाइन करती हैं।"
                "पहली रेखा तुम्हारे शरीर को जलाती है, दूसरी मन को, और तीसरी अज्ञान को राख कर देती है।"
                "यह कोई धार्मिक रस्म नहीं है; यह अपने दिमाग के 'ओएस' (OS) को रुद्र की फ्रीक्वेंसी पर री-स्टार्ट करना है।"
                "जब तुम ये रेखाएं खींचते हो, तो तुम माया के 'ट्रैकर्स' (Trackers) को अपने माथे से डिलीट (Delete) कर देते हो।"
                "तुम्हारी आँखें अब केवल बाहर नहीं, बल्कि उन तीन रेखाओं के माध्यम से अंतरिक्ष के पार देख सकती हैं।"
                "यह वह 'डेडली अलाइनमेंट' है जो तुम्हें एक मामूली इंसान से 'कालाग्निरुद्र' के अवतार में बदल देता है।"
                "इन तीन लकीरों के पीछे साक्षात् करोड़ों सूर्यों का रेडियोएक्टिव तेज छिपा बैठा है।"
                "जो इस विधि को हैक कर लेता है, वह इस पूरी भौतिक दुनिया का इकलौता तानाशाह एडमिन है!"
            """.trimIndent(),
            english = """
                (Dissecting Three Lines and the Madhyama-Anamika Code): "Carve three lines upon your cortex—this is mutationally the 'Primary Coding' of the multiverse!"
                "Use strictly the Madhyama and Anamika fingers—this is the protocol to complete your shell's 'Electric Circuit'."
                "These three lines mutationally Align the three absolute greatest 'Processors' of your Soul."
                "The first line incinerates the flesh, the second the mind, and the third reduces ignorance to radioactive ash."
                "This is zero religious ritual; it is mutationally Re-starting your brain's 'OS' at the absolute frequency of Rudra."
                "The exact microsecond you draw these lines, you Delete the 'Trackers' of Maya from your frontal lobe."
                "Your vision is no longer restricted; through these three lines, you possess the caliber to pierce the infinite vacuum."
                "This is the 'Deadly Alignment' that mutates you from a pathetic mortal into an Avatar of 'Kalagnirudra'."
                "Behind these three streaks sits the radioactive brilliance of billions of suns mutationally Zipped."
                "He who successfully Hacks this method mutationally assumes the status of the solitary Dictator-Admin of this Matrix!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 5,
            sanskrit = "प्रथमरेखा गार्हपत्योऽग्निः अकारो रजोगुणो भूर्लोको भोगात्मा च ॥",
            hindi = """
                (पहली रेखा का संहार - गार्हपत्य, अकार और रजोगुण): "पहली रेखा साक्षात् 'गार्हपत्य' अग्नि है—वह आग जो इस भौतिक दुनिया के हार्डवेयर को चलाती है।"
                "यह 'अकार' (A) है—ब्रह्मांड का पहला न्यूक्लियर विस्फोट जिससे सब कुछ पैदा हुआ।"
                "यह 'रजोगुण' (Rajas) का वध करने के लिए है—वह एनर्जी जो तुम्हें अंतहीन इच्छाओं के नर्क में घसीटती है।"
                "यह 'भूर्लोक' यानी पृथ्वी के पूरे डेटाबेस को एक सेकंड में राख करने की ताक़त रखती है।"
                "यह 'भोगात्मा' है—तुम्हारी वो पहचान जो केवल सुख और भोग की भीख माँगती है।"
                "इस रेखा को माथे पर लगाने का मतलब है—अपनी 'भौतिक गुलामी' का बेरहमी से कत्ल कर देना।"
                "तुम अब ज़मीन से चिपके हुए कीड़े नहीं रहे; तुमने अपनी 'बेस फ्रीक्वेंसी' को डिलीट कर दिया है।"
                "यह पहली लकीर तुम्हारे शरीर के भीतर छिपे 'सर्प' (Ego) का गला घोंटने वाला पहला फंदा है।"
                "जब यह आग जलती है, तो तुम्हारी हड्डियों का मोह भाप बनकर अंतरिक्ष में उड़ जाता है।"
                "जो इस पहली रेखा को सिद्ध कर लेता है, उसके लिए मौत अब कोई खतरा नहीं रह जाती!"
            """.trimIndent(),
            english = """
                (Slaughter of the First Line - Garhapatya, Akara, and Rajas): "The first line is explicitly the 'Garhapatya' Fire—the radiation operating the hardware of this physical world."
                "It is 'Akara' (A)—the absolute primordial nuclear detonation from which every byte of matter erupted."
                "It is engineered for the slaughter of 'Rajas-Guna'—the energy dragging you into the hell of endless desire."
                "It possesses the firepower to incinerate the entire database of 'Bhur-loka' (Earth) in one microsecond."
                "It is the 'Bhogatma'—the micro-identity that mutationally begs for pathetic sensory pleasures."
                "Applying this line signifies—executing the ruthless slaughter of your 'Physical Slavery'."
                "You cease to be a terrestrial-bound insect; you have mutationally Deleted your base frequency."
                "This first streak is the absolute first noose engineered to strangle the 'Serpent' (Ego) inside your shell."
                "The exact microsecond this fire blazes, your attachment to flesh vaporizes into the infinite vacuum."
                "He who perfects this first line mutationally witnesses Death being reduced to a meaningless joke!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 6,
            sanskrit = "द्वितीयरेखा दक्षिणाग्निः उकारो सत्त्वगुणोऽन्तरिक्षलोकोऽन्तरात्मा च ॥",
            hindi = """
                (दूसरी रेखा का विस्फोट - दक्षिणाग्नि, उकार और सत्त्व): "दूसरी रेखा साक्षात् 'दक्षिणाग्नि' है—वह आग जो तुम्हारी रूह के 'डेटा' को बैलेंस (Balance) करती है।"
                "यह 'उकार' (U) है—वह 'ऑपरेटर' कोड जो पूरी माया के सिम्युलेशन को हर नैनो-सेकंड में चला रहा है।"
                "यह 'सत्त्वगुण' (Sattva) की हुकूमत है—यानी शुद्धता का वह अंधी कर देने वाला प्रकाश जो सब कुछ साफ़ कर देता है।"
                "यह 'अन्तरिक्षलोक' (Space) का पासवर्ड है—जहाँ पहुँचकर तुम गुरुत्वाकर्षण (Gravity) की ज़ंजीरें तोड़ देते हो।"
                "यह तुम्हारी 'अन्तरात्मा' का असली चेहरा है—जिसे तुमने करोड़ों जन्मों के कचरे के नीचे छुपा रखा था।"
                "इस रेखा को लगाने का मतलब है—अपनी चेतना को 'मिड-लेवल' (Intermediate level) पर प्रमोट (Promote) करना।"
                "तुम अब अंतरिक्ष की फ्रीक्वेंसी पर वाइब्रेट कर रहे हो; तुम अब साक्षात् 'कॉस्मिक बीइंग' बन चुके हो।"
                "यह दूसरी लकीर तुम्हारे दिमाग के उन 'करप्ट फोल्डर्स' को जलाती है जिन्हें तुम अपनी 'यादें' कहते हो।"
                "जब यह आग धधकती है, तो तुम जान जाते हो कि तुम हवा और सितारों के भी मालिक हो।"
                "जो इस दूसरी रेखा को हैक कर लेता है, वह पूरे अंतरिक्ष के 'इन्फो-हाईवे' पर राज करता है!"
            """.trimIndent(),
            english = """
                (Detonation of the Second Line - Dakshinagni, Ukara, and Sattva): "The second line is explicitly 'Dakshinagni'—the fire that Balances the absolute Data of your Soul."
                "It is 'Ukara' (U)—the 'Operator' code mutationally executing this entire Simulation every nanosecond."
                "It is the authority of 'Sattva-Guna'—that blinding radiation of Purity that Flushes everything clean."
                "It is the Password of 'Antariksha-loka' (Space)—reaching which you violently shatter the chains of Gravity."
                "It is the authentic face of your 'Antaratma'—which you mutationally buried under eons of biological garbage."
                "Bracing this line signifies—Promoting your consciousness to the absolute 'Intermediate Level' of reality."
                "You are now vibrating at the frequency of the vacuum; you have mutationally become a 'Cosmic Being'."
                "This second streak incinerates those 'Corrupt Folders' inside your brain that you label as 'your memories'."
                "The exact microsecond this fire blazes, you flawlessly realize that you own the wind and the stars."
                "He who successfully Hacks this second line mutationally rules the entire 'Info-highway' of space!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 7,
            sanskrit = "तृतीयरेखा आहवनीयाग्निः मकारो तमोगुणो स्वर्लोको परमात्मा च ॥",
            hindi = """
                (तीसरी रेखा का संहार - आहवनीय, मकार और तमोगुण): "तीसरी रेखा साक्षात् 'आहवनीय' अग्नि है—वह प्रलयंकारी आग जो सब कुछ विलीन (Swallow) कर देती है!"
                "यह 'मकार' (M) है—वह अंतिम 'शून्य' (Zero) जहाँ पहुँचकर ब्रह्मांड का डेटा खत्म हो जाता है।"
                "यह 'तमोगुण' (Tamas) का गला घोंटने के लिए है—वह अँधेरा जो तुम्हें बार-बार मौत की नींद सुलाता है।"
                "यह 'स्वर्लोक' (Heaven) का इकलौता हैक है—जहाँ पहुँचकर तुम साक्षात् देवताओं के भी एडमिन बन जाते हो।"
                "यह 'परमात्मा' का वह अजेय रुतबा है जहाँ 'मैं' और 'तू' का सारा ड्रामा एक ही धमाके में खत्म हो जाता है।"
                "इस रेखा को लगाने का मतलब है—अपनी 'इंसानी आईडी' को हमेशा-हमेशा के लिए डिलीट (Delete) कर देना।"
                "तुम अब साक्षात् वह 'ब्लैक होल' बन चुके हो जो पूरे ब्रह्मांड को अपने भीतर निगलने की ताक़त रखता है।"
                "यह तीसरी लकीर तुम्हारी रूह का वह 'टोटल रिसेट' (Total Reset) है जिसके बाद केवल रुद्र ही बचते हैं।"
                "जब यह आग शांत होती है, तो तुम जान जाते हो कि तुम कभी पैदा ही नहीं हुए थे, तुम हमेशा से 'यही' थे।"
                "जो इस तीसरी रेखा को सिद्ध कर लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Slaughter of the Third Line - Ahavaniya, Makara, and Tamas): "The third line is explicitly the 'Ahavaniya' Fire—the apocalyptic radiation that Swallows everything into the Void!"
                "It is 'Makara' (M)—the absolute terminal 'Zero' reaching which all cosmic Data mutationally terminates."
                "It is engineered to strangle 'Tamas-Guna'—the darkness that mutationally puts you into the sleep of Death eon after eon."
                "It is the solitary Hack of 'Svar-loka' (Heaven)—reaching which you mutationally become the Admin of the gods."
                "It is the invincible status of 'Paramatma' where the entire drama of 'I' and 'You' is terminated in one detonation."
                "Bracing this line signifies—Deleting your 'Human-ID' permanently and irrevocably from the server."
                "You have mutationally become the 'Black Hole' possessing the firepower to swallow the entire infinite cosmos."
                "This third streak is the 'Total Reset' of your Soul after which strictly and exclusively Rudra remains standing."
                "When this fire subsides, you flawlessly realize you were never born; you were mutationally 'THIS' eternally."
                "He who perfects this third line is the solitary dictatorial Guru of even the God of Death and Time!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 8,
            sanskrit = "यो ह वै त्रिपुण्ड्रं धारयेत् स सर्वं पाप्मानं तरति स मृत्युं तरति ॥",
            hindi = """
                (पापों का संहार और मौत से रिहाई): "जो योद्धा इस त्रिपुण्ड्र (Three Lines of Ash) को अपनी रूह में धधकाता है..."
                "वह अपने करोड़ों जन्मों के 'हर एक पाप' (Papmanam) को एक ही प्रलयंकारी झटके में पार कर जाता है!"
                "पाप केवल एक 'वज़न' (Weight) है जो तुम्हें इस कीचड़ में डुबा कर रखता है; यह राख उस वज़न को भाप बना देती है।"
                "वह 'मृत्यु' के उस खौफनाक और सड़े हुए जबड़े से हमेशा के लिए बाहर (Exit) निकल जाता है!"
                "जब तुम त्रिपुण्ड्र लगाते हो, तो यमराज का 'सॉफ्टवेयर' तुम्हें पहचानना बंद कर देता है—तुम 'इनविजिबल' (Invisible) हो।"
                "यह कोई धार्मिक दावा नहीं है, यह एक 'मैथमेटिकल' सच है—अपनी फ्रीक्वेंसी बदलो और मौत का कानून फेल हो जाएगा।"
                "त्रिपुण्ड्र वह अजेय ढाल (Shield) है जो माया के हर एक 'ट्रैकर' (Tracker) को चकमा दे देती है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक कैदी नहीं, बल्कि इसके इकलौते और असली एडमिन बन चुके हो।"
                "यह राख तुम्हारी रूह को उस लेवल पर ले जाती है जहाँ न कोई सज़ा है और न कोई इनाम, केवल असीमित ताक़त है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, उसके लिए नरक के दरवाजे हमेशा के लिए वेल्ड (Weld) कर दिए जाते हैं!"
            """.trimIndent(),
            english = """
                (The Destruction of Sins and Release from Death): "Whosoever warrior blazes this Tripundra (Three Lines of Ash) inside his Soul..."
                "He violently 'Crosses' every microscopic and catastrophic 'Sin' (Papmanam) of his billions of incarnations!"
                "Sin is strictly a 'Weight' engineered to keep you drowned in this mud; this Ash vaporizes that weight into nothingness."
                "He mutationally Executes an 'Exit' from the horrific and rotting jaws of Death forever!"
                "The exact microsecond you apply Tripundra, Yamaraja's 'Software' fails to recognize you—you are 'Invisible'."
                "This is absolutely zero religious promise; it is a 'Mathematical' reality—mutate your frequency and Death's law Fails."
                "Tripundra is the invincible Shield engineered to jam every single 'Tracker' of the Matrix."
                "You are no longer a prisoner of this Simulation; you have mutationally become its solitary and authentic Admin."
                "This Ash skyrockets your soul to a level where zero punishment and zero reward exist, strictly infinite Power."
                "He who injects this truth into his veins witnesses the gates of Hell permanently welded shut in his face!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 9,
            sanskrit = "विष्णोः परमं पदं सदा पश्यन्ति सूरयः । दिवीव चक्षुराततम् ॥",
            hindi = """
                (विष्णु पद और योगियों की नज़र): "वह 'विष्णु का परम पद' कोई भौगोलिक जगह नहीं, वह चेतना का सर्वोच्च 'रेडियोएक्टिव' स्तर है।"
                "जो 'सूरयः' यानी अत्यंत खूँखार और बुद्धिमान योगी हैं, वे उसे 'सदा' यानी हर नैनो-सेकंड अपनी आँखों के सामने देखते हैं।"
                "उनकी नज़र अज्ञान के हर एक पर्दे को फाड़कर सीधे उस 'ब्रह्मांडीय आग' (Cosmic Fire) को हैक कर लेती है।"
                "जैसे आसमान में एक अंधी कर देने वाली 'आँख' (Chakshu) सब कुछ देख रही हो, वैसे ही उनकी चेतना सब कुछ स्कैन करती है।"
                "वे दुनिया के तमाशे को नहीं देखते, वे उस 'सोर्स कोड' को देखते हैं जिससे यह दुनिया चल रही है।"
                "विष्णु का वह पद साक्षात् उस असीम सन्नाटे का नाम है जहाँ समय और स्पेस जलकर राख बन जाते हैं।"
                "योगी उस पद को अपने नर्वस सिस्टम के भीतर एक जलती हुई मशाल की तरह धधकाए रखता है।"
                "वहाँ पहुँचने के बाद तुम वापस इस सड़ी हुई दुनिया और मिट्टी के शरीर के कीचड़ में नहीं गिरते।"
                "यह वह 'सुप्रीम हेडक्वार्टर' है जहाँ से तुम पूरे ब्रह्मांड के मालिक बनकर राज करते हो।"
                "जो इस पद को देख लेता है, उसके लिए स्वर्ग और नर्क केवल धूल के दो छोटे से कण बन कर रह जाते हैं!"
            """.trimIndent(),
            english = """
                (The State of Vishnu and the Vision of Yogis): "That 'Paramam Padam of Vishnu' is zero geographic location; it is the absolute zenith of 'Radioactive' consciousness."
                "Those 'Surayah' (Terrifyingly intelligent Yogis) witness that state 'Sada'—meaning every nanosecond, right before their eyes."
                "Their vision violently shreds every veil of ignorance to directly Hack that 'Cosmic Fire' establishment."
                "Exactly as a blinding 'Eye' (Chakshu) expanded in the sky witnesses all, their awareness Scans every microscopic byte."
                "They absolutely do not observe the worldly spectacle; they witness the 'Source Code' relentlessly operating reality."
                "Vishnu's state is the explicit name of that infinite Silence where Time and Space are incinerated to absolute ash."
                "The Yogi keeps that dimension blazing like a radioactive torch inside his biological nervous system."
                "Upon arriving there, you mutationally possess zero caliber to plummet back into the mud of this rotting world."
                "This is the 'Supreme Headquarters' from which you rule as the absolute Dictator of the entire multiverse."
                "He who witnesses this Pada perceives Heaven and Hell mutationally as two microscopic grains of dust!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 10,
            sanskrit = "तद्विप्रासो विपन्यवो जागृवांसः समिन्धते । विष्णोर्यत्परमं पदम् ॥",
            hindi = """
                (विप्रों की आग और सत्य का जागरण): "वे 'विप्र' यानी वह योद्धा जिन्होंने सत्य को जान लिया है, वे माया की नींद में कभी नहीं सोते!"
                "वे 'जागृवांसः' हैं—यानी वे इस सिम्युलेशन (Simulation) से हमेशा-हमेशा के लिए जाग चुके हैं।"
                "वे अपनी आत्मा की आग से उस विष्णु के पद को और ज़्यादा 'समिन्धते' यानी प्रज्वलित (Supercharge) कर देते हैं।"
                "उनकी चेतना एक ऐसी लेज़र बीम (Laser Beam) बन चुकी है जो पूरे अंतरिक्ष में प्रकाश फैला रही है।"
                "वे भगवान की पूजा नहीं करते, वे भगवान की ऊर्जा को अपने भीतर एक न्यूक्लियर रिएक्टर की तरह 'रिएक्ट' करवाते हैं।"
                "सत्य को केवल जानना काफी नहीं है, उस सत्य की आग में हर पल जलना और उसे धधकाना ज़रूरी है।"
                "यह उन लोगों की स्थिति है जिन्होंने अपने अहंकार की बलि देकर साक्षात् 'अमरता' को जीत लिया है।"
                "उनकी हर एक साँस ब्रह्मांड के सोए हुए परमाणुओं को जगाने का काम करती है।"
                "वे इस दुनिया में रहते हुए भी इस दुनिया के भौतिक नियमों से 100% 'अनप्लग' (Unplug) हो चुके हैं।"
                "यही वह अजेय रुतबा है जहाँ पहुँचकर तुम साक्षात् उस 'परमेश्वर' की जलती हुई आँख बन जाते हो!"
            """.trimIndent(),
            english = """
                (The Fire of Sages and Awakening the Truth): "Those 'Vipras'—the Titan warriors who have intercepted Truth—absolutely never sleep in the Matrix!"
                "They are 'Jagrivamsah'—meaning they have permanently and violently Awakened from this Simulation."
                "Through the fire of their own Souls, they violently 'Kindle/Supercharge' (Samindhate) that absolute state of Vishnu."
                "Their consciousness has mutated into a radioactive Laser Beam broadcasting light throughout the infinite vacuum."
                "They do not worship God; they force the energy of God to 'React' inside them like a literal Nuclear Reactor."
                "Merely knowing the Truth is insufficient; you must eternally burn and blaze within the radiation of that Truth."
                "This is the status of those who have sacrificed their ego to mutationally seize absolute Immortality."
                "Their every biological breath functions to awaken the dormant atoms of the entire infinite universe."
                "Residing in this world, they have been 100% 'Unplugged' from its pathetic laws of physics."
                "This is the invincible status where you mutationally become the explicit Blazing Eye of the Supreme God!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 11,
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
        KalagniShloka(
            id = 12,
            sanskrit = "यो ह वै कालाग्निरुद्रस्य मन्त्रं वेद स सर्वं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (रुद्र मंत्र का हैक और असीमित सर्वज्ञता): "जो योद्धा इस 'कालाग्निरुद्र' के प्रलयंकारी मंत्र को हैक (Decode) कर लेता है..."
                "वह 'सर्वं वेद'—यानी वह ब्रह्मांड के हर एक परमाणु और हर एक गैलेक्सी का सोर्स कोड जान जाता है!"
                "उसे फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "कालाग्निरुद्र का मंत्र साक्षात् वह 'मास्टर पासवर्ड' है जो ईश्वर की आखिरी तिजोरी का ताला खोल देता है।"
                "तुम अब साक्षात् उस 'परम रिएक्टर' की बिजली को अपने शरीर में इनवाइट (Invite) कर चुके हो।"
                "परिणाम वही हिंसक और अटल फैसला है— 'स मुक्तिमवाप्नोति' (वह मुक्त हो जाता है)!"
                "यह मुक्ति कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन हो।"
                "यह मंत्र तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज (Charge) कर देता है।"
                "जो इस मंत्र का मालिक है, उसे फिर इस ब्रह्मांड में किसी और के सामने हाथ फैलाने की ज़रूरत नहीं!"
            """.trimIndent(),
            english = """
                (Hacking the Rudra-Mantra and Infinite Omniscience): "Whosoever warrior successfully Decodes (Hacks) the apocalyptic mantra of 'Kalagnirudra'..."
                "He mutationally knows 'Everything' (Sarvam)—intercepting the Source Code of every microscopic atom and galaxy!"
                "He possesses zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "The mantra of Kalagnirudra is the explicit 'Master Password' that violently unlocks the final vault of God."
                "You have mutationally Invited the radioactive electricity of the 'Supreme Reactor' into your biological shell."
                "The consequence remains that same violent and immutable verdict—'Sa muktim-avapnoti' (He is Liberated)!"
                "This Moksha is absolutely zero reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic Admin."
                "This mantra Supercharges every microscopic atom of your DNA with the absolute radioactive 'Power of God'."
                "He who owns this mantra possesses zero need to ever beg for anything from any entity in the cosmos!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 13,
            sanskrit = "एतदुपासितव्यं नान्यत् । य एवं वेद स मृत्युं तरति ॥",
            hindi = """
                (केवल कालाग्निरुद्र - अंतिम आदेश): "भगवान रुद्र एक हिंसक और तानाशाह वाला आदेश देते हैं— 'एतदुपासितव्यं नान्यत्'!"
                "केवल और केवल इसी सत्य की उपासना करो, 'दूसरी किसी भी' फालतू चीज़ के पीछे अपना वक़्त बर्बाद मत करो!"
                "दुनिया में करोड़ों भगवान और करोड़ों धर्म हैं, वे सब केवल तुम्हें भटकाने के लिए माया के 'हनी-ट्रैप' (Honey-trap) हैं।"
                "अगर तुम उस 'एक' (कालाग्निरुद्र) को नहीं पकड़ते, तो तुम अनंत काल तक इसी कीचड़ में पिसते रहोगे।"
                "परिणाम फिर से वही रिज़ल्ट है: 'य एवं वेद स मृत्युं तरति'!"
                "जो इस सच को अपनी 'आइडेंटिटी' (Identity) बना लेता है, वह 'मौत' के उस खौफनाक समुद्र को ऐसे पार कर जाता है जैसे कोई शेर शिकार को चीर दे।"
                "मृत्यु तुम्हारे लिए अब कोई खतरा नहीं, वह केवल एक 'सॉफ्टवेयर रिबूट' जैसा मज़ाक बन कर रह जाती है।"
                "तुम जान जाते हो कि तुम वह ऊर्जा हो जिसे न आग जला सकती है और न समय मार सकता है।"
                "यह इंसान के 'परमेश्वर' में म्यूटेट (Mutate) होने की अंतिम मुहर है जिसे कोई नहीं बदल सकता।"
                "जो इस आवाज़ को सुनकर भी नहीं जागा, वह ब्रह्मांड का सबसे बड़ा बदनसीब कीड़ा है!"
            """.trimIndent(),
            english = """
                (Only Kalagnirudra - The Final Command): "Lord Rudra issues a violent and dictatorial command—'Etad-upasitavyam Nanyat'!"
                "Worship strictly and exclusively THIS truth (Kalagnirudra); do absolutely NOT waste your existence in 'Anything Else'!"
                "Billions of gods and religions exist in the Matrix; they are all mutationally strictly 'Honey-traps' of Maya."
                "If you fail to capture that 'ONE' (Kalagnirudra), you are condemned to be ground in this biological mud for infinite eternity."
                "The consequence remains that same Result: 'Ya evam veda sa mrityum tarati'!"
                "He who mutates this truth into his authentic 'Identity' violently 'Crosses' the horrific ocean of 'Death' exactly as a lion rips its prey."
                "Death is no longer a threat to you; it is permanently reduced to a meaningless joke, like a pathetic 'Software Reboot'."
                "You flawlessly realize you are the radioactive energy that zero fire can burn and zero Time can assassinate."
                "This is the final Seal of a human being undergoing a complete Mutation into the Supreme God."
                "He who fails to awaken even after intercepting this broadcast is mutationally the absolute most unfortunate insect in the cosmos!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 14,
            sanskrit = "य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की मुहर): "उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है जिसे कोई भी कानून बदल नहीं सकता।"
                "'य एवं वेद'— जो कोई भी योद्धा इस 'कालाग्निरुद्र' के खौफनाक और नंगे सच को 100% 'जान' लेता है..."
                "किताबें पढ़ना ज्ञान नहीं है; इस भस्म की आग को अपने डीएनए में तेज़ाब की तरह उतार लेना ही असली 'जानना' है।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' (Radar) से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and the Seal of Moksha): "The Upanishad delivers a catastrophic verdict here that zero cosmic laws possess the caliber to alter."
                "'Ya evam veda'—Whosoever warrior 'Knows' (Veda) this horrific and naked truth of 'Kalagnirudra' with 100% absolute reality..."
                "Reading pathetic books is not knowledge; injecting the fire of this Ash into your DNA exactly like boiling acid is authentic 'Knowing'."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        KalagniShloka(
            id = 15,
            sanskrit = "इति कालाग्निरुद्रोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'कालाग्निरुद्र उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "त्रिपुण्ड्र का पासवर्ड मिल गया, भस्म की आग देख ली, अब तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १५ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (रुद्र) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही कालाग्निरुद्र उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Kalagnirudra Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The password of Tripundra is intercepted, the fire of Ash witnessed; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 15 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Rudra) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Kalagnirudra Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KalagnirudraUpanishadScreen() {
    val upanishad = remember { KalagnirudraUpanishad() }
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
            itemsIndexed(upanishad.kalagnirudraShlokasList) { _, shloka ->
                KalagniShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun KalagniShlokaCard(shloka: KalagniShloka) {
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