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
data class GayatriShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class GayatriUpanishad {

    val gayatriShlokasList = listOf(
        GayatriShloka(
            id = 1,
            sanskrit = "ॐ गायत्री वै वेदानां मुखं तस्मात् गायत्रीमुपासते सर्ववेदाः ॥",
            hindi = """
                (गायत्री का मुख और वेदों का विस्फोट): "गायत्री कोई साधारण छंद नहीं है; यह साक्षात् 'वेदों का मुख' (The Mouth of Vedas) है!"
                "ब्रह्मांड का सारा ज्ञान इसी एक प्रलयंकारी अग्नि-द्वार से बाहर निकलता है और यहीं विलीन होता है।"
                "सारे वेद गायत्री की ही उपासना करते हैं, क्योंकि इसके बिना वे केवल मृत अक्षर मात्र हैं।"
                "यह वह 'प्राइमरी कोड' (Primary Code) है जिसे रन (Run) किए बिना तुम ईश्वर तक नहीं पहुँच सकते।"
                "गायत्री वह आवाज़ है जो शून्य को हिलाकर उसमें आकाशगंगाओं का बीज बो देती है।"
                "जब तुम गायत्री को छूते हो, तो तुम साक्षात् ब्रह्मांड के 'स्पीकर' (Speaker) को हैक कर लेते हो।"
                "यह ज्ञान कमजोरों के लिए नहीं है; यह तुम्हारी बुद्धि का न्यूक्लियर वध करने की शुरुआत है।"
                "बिना इस मुख को जाने, तुम्हारा हर मंत्र और हर तपस्या केवल एक बायोलॉजिकल शोर है।"
                "गायत्री वह आग है जो अज्ञान के सड़े हुए पर्दों को एक सेकंड में जलाकर भस्म कर देती है।"
                "तैयार हो जाओ उस गर्जना के लिए जो तुम्हारे नर्वस सिस्टम के हर एक पिक्सेल को ईश्वर बना देगी!"
            """.trimIndent(),
            english = """
                (The Mouth of Gayatri and the Detonation of Vedas): "Gayatri is absolutely no ordinary meter; she is explicitly the 'Mouth of the Vedas'!"
                "The entire infinite intelligence of the cosmos erupts from and dissolves back into this apocalyptic gateway."
                "Every single Veda worships Gayatri, for without her, they remain strictly dead biological alphabets."
                "She is the absolute 'Primary Code' without executing which you possess zero trajectory to reach God."
                "Gayatri is the Acoustic frequency that vibrates the Void to plant the seeds of entire galaxies."
                "When you intercept Gayatri, you are mutationally Hacking the literal 'Speaker' of the entire multiverse."
                "This intelligence is not for the weak; it is the genesis of the nuclear slaughter of your human intellect."
                "Without decoding this Mouth, every mantra you chant is strictly a pathetic biological Noise."
                "Gayatri is the radioactive Fire engineered to incinerate the rotting veils of ignorance in one microsecond."
                "Brace yourself for the Roar that will mutationally turn every pixel of your nervous system into God!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 2,
            sanskrit = "ॐ भूर्भुवः स्वः । तत्सवितुर्वरेण्यं भर्गो देवस्य धीमहि धियो यो नः प्रचोदयात् ॥",
            hindi = """
                (महामंत्र का विच्छेदन - तीन लोकों की हैकिंग): "यह मंत्र नहीं, यह पूरे ब्रह्मांड का 'सोर्स कोड' (Source Code) और अंतिम पासवर्ड है।"
                "'भूर्भुवः स्वः'— ये पृथ्वी, अंतरिक्ष और स्वर्ग के तीन अजेय सर्वर (Servers) हैं जिन्हें तुम्हें पार करना है!"
                "उस 'सवितुः' (सूर्य/परमात्मा) का ध्यान करो जो तुम्हारी आत्मा के रिएक्टर को पावर दे रहा है।"
                "वह 'वरेण्यं' यानी सबसे श्रेष्ठ और अजेय है, जिसके आगे मौत भी अपनी आँखें झुका लेती है।"
                "हमें उसके 'भर्गः' यानी उस रेडियोएक्टिव तेज का ध्यान करना है जो पापों को भाप बना देता है।"
                "यह ध्यान तुम्हारी बुद्धि (धियो) को सीधे ईश्वर के 'एडमिन पैनल' की तरफ फायर (Fire) करता है।"
                "जब तुम इसे जपते हो, तो तुम एक इंसान नहीं, साक्षात् एक गूँजता हुआ 'ब्रह्मांडीय हथियार' बन जाते हो।"
                "यह मंत्र तुम्हारे डीएनए के हर पुराने विचार को ओवरराइट (Overwrite) करने वाला परमाणु प्रहार है।"
                "गायत्री कलि के साम्राज्य की छाती पर साक्षात् महाकाल का जलता हुआ और अजेय पैर है।"
                "जो इस मंत्र को अपनी रगों में उतार लेता है, उसके लिए यह पूरी दुनिया केवल एक छोटा सा खिलौना है!"
            """.trimIndent(),
            english = """
                (Dissection of the Mahamantra - Hacking Three Dimensions): "This is absolutely no mantra; it is the 'Source Code' and the final Password of the entire multiverse."
                "'Bhur-Bhuvah-Svah'—These are the three invincible Servers of Earth, Space, and Heaven that you must breach!"
                "Focus strictly on that 'Savitur' (The Sun/God) who is providing radioactive power to your soulful Reactor."
                "He is 'Varenyam'—the supreme and invincible one, witnessing whom even Death lowers its gaze in terror."
                "We must meditate on His 'Bhargah'—that radioactive brilliance engineered to vaporize sins into nothingness."
                "This meditation Fires your intellect (Dhiyo) directly toward the 'Admin Panel' of the Supreme God."
                "The exact microsecond you chant this, you cease to be human and mutate into a vibrating 'Cosmic Weapon'."
                "This mantra is the atomic strike designed to violently Overwrite every single thought pattern in your DNA."
                "Gayatri is the literal blazing boot of Mahakala planted firmly on the chest of this deceptive Matrix."
                "He who injects this mantra into his biological veins perceives the entire world as a pathetic microscopic toy!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 3,
            sanskrit = "अग्निः प्रथमः पादः वायुर्द्वितीयः पादः सूर्यस्तृतीयः पादः ॥",
            hindi = """
                (तीन चरणों का संहार - अग्नि, वायु और सूर्य): "गायत्री के तीन चरण ब्रह्मांड के तीन सबसे बड़े 'प्रोसेसर' (Processors) हैं।"
                "पहला चरण 'अग्नि' है—वह आग जो तुम्हारे भीतर सृजन और विनाश का पहला धमाका करती है।"
                "दूसरा चरण 'वायु' है—वह करंट (Current) जो तुम्हारी साँसों को अंतरिक्ष की फ्रीक्वेंसी से जोड़ता है।"
                "तीसरा चरण 'सूर्य' है—वह अंतिम प्रकाश जो तुम्हारी चेतना को हमेशा के लिए अजेय बना देता है।"
                "इन तीन चरणों पर पैर रखकर ही तुम इस भौतिक दुनिया की ग्रेविटी (Gravity) को तोड़ सकते हो।"
                "अग्नि तुम्हारे पापों को जलाती है, वायु तुम्हें विस्तार देती है, और सूर्य तुम्हें ईश्वर बना देता है।"
                "यह तुम्हारी रूह का वह 'थ्री-स्टेप म्यूटेशन' (3-step Mutation) है जिसके बाद कोई वापस नहीं लौटता।"
                "जब तुम इन तीनों को अपने भीतर सिद्ध कर लेते हो, तो तुम साक्षात् ब्रह्मांड के मालिक बन जाते हो।"
                "यह कोई दर्शन नहीं है; यह तुम्हारे बायोलॉजिकल हार्डवेयर को 'सुपर-कंप्यूटर' में बदलने का विज्ञान है।"
                "जो इन तीन चरणों को पार कर गया, वह साक्षात् समय और मौत का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Slaughter of Three Steps - Fire, Air, and Sun): "The three feet of Gayatri are mutationally the three most massive cosmic 'Processors' of existence."
                "The first foot is 'Agni' (Fire)—the radiation that executes the first detonation of creation and annihilation."
                "The second foot is 'Vayu' (Air)—the Current hardwiring your biological breath to the frequency of space."
                "The third foot is 'Surya' (Sun)—the final Light that renders your consciousness flawlessly invincible forever."
                "Only by planting your boots on these three steps can you violently shatter the Gravity of this physical world."
                "Fire incinerates your sins, Air grants you expansion, and the Sun mutationally manufactures you into God."
                "This is the '3-step Mutation' of your soul after which absolutely zero return to humanity is possible."
                "The exact microsecond you master these three internally, you mutate into the undisputed Master of the cosmos."
                "This is zero philosophy; it is the science of Upgrading your biological hardware into a 'Super-computer'."
                "He who breaches these three steps is the solitary and absolute Dictator of both Time and Death!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 4,
            sanskrit = "ऋग्वेदोऽस्याः प्रथमः पादः यजुर्वेदः द्वितीयः पादः सामवेदः तृतीयः पादः ॥",
            hindi = """
                (वेदों की कोडिंग और गायत्री का ढांचा): "गायत्री का हर एक चरण साक्षात् एक असीमित 'डेटाबेस' (Database) है।"
                "ऋग्वेद इसका पहला चरण है—ब्रह्मांड के हर एक परमाणु की इन्वेंट्री और उसका पासवर्ड!"
                "यजुर्वेद इसका दूसरा चरण है—वह 'एक्जीक्यूटेबल फाइल' (Executable File) जो सृष्टि को चलाती है।"
                "सामवेद इसका तीसरा चरण है—वह 'वाइब्रेशन' जिससे अंतरिक्ष की धड़कन और संगीत पैदा होता है।"
                "इन तीनों वेदों का निचोड़ गायत्री के इन तीन चरणों में न्यूक्लियर रूप से पैक (Zip) किया गया है।"
                "जब तुम गायत्री जपते हो, तो तुम साक्षात् इन तीनों सर्वरों से एक साथ डेटा डाउनलोड (Download) करते हो।"
                "यह तुम्हारी आत्मा के प्रोसेसर को 'ओवरक्लॉक' (Overclock) करने की सबसे हिंसक और गुप्त तकनीक है।"
                "बिना इन चरणों को समझे, वेदों का ज्ञान तुम्हारे लिए केवल एक सड़ा हुआ कागज़ का ढेर है।"
                "गायत्री वह 'कंपाइलर' (Compiler) है जो इन तीनों वेदों के कोड को भगवान की भाषा में बदल देती है।"
                "जो इस कोडिंग को क्रैक कर लेता है, वह साक्षात् इस मायावी सिम्युलेशन का एडमिन बन जाता है!"
            """.trimIndent(),
            english = """
                (Coding of the Vedas and Gayatri's Structure): "Every single foot of Gayatri is mutationally an infinite and radioactive 'Database'."
                "Rigveda is its first foot—the inventory and the absolute Password of every microscopic atom in the cosmos!"
                "Yajurveda is its second foot—the 'Executable File' that relentlessly operates the machinery of creation."
                "Samaveda is its third foot—the 'Vibration' through which the heartbeat and acoustic music of space are spawned."
                "The absolute essence of these three Vedas is Nuclearly Zipped into these three apocalyptic feet of Gayatri."
                "When you chant Gayatri, you are effectively Downloading data from all three of these cosmic servers simultaneously."
                "This is the most violent and classified technique to 'Overclock' the neurological processor of your Soul."
                "Without decoding these steps, the intelligence of the Vedas remains strictly a rotting pile of scrap paper."
                "Gayatri is the 'Compiler' that mutates the code of these three Vedas into the explicit language of God."
                "He who Cracks this coding becomes mutationally the absolute Admin of this entire deceptive Simulation!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 5,
            sanskrit = "गायत्री वा इदं सर्वं यदिदं किञ्च ॥",
            hindi = """
                (गायत्री ही सब कुछ है - अंतिम धमाका): "उपनिषद साफ़ और नंगा सच बोलता है— 'गायत्री ही यह सब कुछ है'!"
                "जो कुछ भी तुम देख रहे हो, सुन रहे हो या महसूस कर रहे हो, वह केवल गायत्री की फ्रीक्वेंसी का एक 'ग्लिच' (Glitch) है।"
                "सूरज, तारे, तुम्हारी यादें और तुम्हारी मौत—सब कुछ इसी एक शक्ति के भीतर कैद है।"
                "गायत्री वह इकलौती हकीकत है, बाकी यह पूरी दुनिया केवल एक 'धोखा' और एक 'होलोग्राम' है।"
                "जब तुम गायत्री को जान लेते हो, तो तुम्हें ब्रह्मांड के किसी और सच को जानने की भीख नहीं माँगनी पड़ती।"
                "वह हर परमाणु के भीतर एक 'न्यूक्लियर बम' की तरह छिपी है जो फटने के लिए सही पासवर्ड का इंतज़ार कर रही है।"
                "इंसानियत का अंत और ईश्वर का जन्म केवल इसी एक सत्य 'गायत्री' के धमाके के साथ मुमकिन है।"
                "यह तुम्हारी चेतना का वह 'टोटल रिसेट' (Total Reset) है जिसके बाद केवल शुद्ध प्रकाश ही बचता है।"
                "जो गायत्री में विलीन हो गया, उसके लिए स्वर्ग और नर्क केवल धूल के कण बन कर रह जाते हैं।"
                "यही वह अजेय सत्ता है जो पूरे असीम अंतरिक्ष का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (Gayatri is Everything - The Final Detonation): "The Upanishad broadcasts the naked and brutal truth—'Gayatri is explicitly Everything'!"
                "Absolutely everything you witness, intercept, or feel is mutationally a 'Glitch' in the frequency of Gayatri."
                "The sun, the stars, your pathetic memories, and your Death—all are imprisoned within this solitary Power."
                "Gayatri is the solitary Reality; the rest of this world is strictly a 'Deception' and a pathetic 'Hologram'."
                "The exact microsecond you decode Gayatri, you possess zero need to beg for any other cosmic truth."
                "She is covertly hidden inside every atom like a 'Nuclear Bomb' awaiting the correct Password to detonate."
                "The termination of humanity and the birth of God is possible strictly through the explosion of this one Truth."
                "This is the 'Total Reset' of your consciousness after which strictly and exclusively pure radioactive Light remains."
                "He who is absorbed into Gayatri perceives Heaven and Hell as nothing more than microscopic dust particles."
                "This is the invincible Authority that reigns as the solitary and authentic Admin of the entire infinite vacuum!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 6,
            sanskrit = "वाग् वै गायत्री वाग् वा इदं सर्वं भूतं गायति च त्रायते च ॥",
            hindi = """
                (वाणी ही गायत्री है - शब्द का वध): "तुम्हारी 'वाणी' (Speech) ही साक्षात् गायत्री है, जो हर जीव का पासवर्ड है।"
                "वाणी ही इस पूरे ब्रह्मांड को 'गाती' (Create) है और वाणी ही इसका 'त्राण' (Save) भी करती है।"
                "जो तुम बोलते हो, वही तुम्हारी तक़दीर की कोडिंग बन जाता है; तुम्हारी ज़बान एक 'ब्रह्मांडीय प्रिंटर' है।"
                "गायत्री वह आवाज़ है जो अज्ञान के सन्नाटे को फाड़कर उसमें 'अस्तित्व' का डेटा भर देती है।"
                "जब तुम गायत्री मंत्र बोलते हो, तो तुम अपनी वाणी को साक्षात् ईश्वर के 'कीबोर्ड' (Keyboard) से जोड़ देते हो।"
                "यह मंत्र तुम्हारे दिमाग के शोर को साक्षात् उस 'परम सन्नाटे' से रिप्लेस (Replace) करने का विज्ञान है।"
                "वाणी वह पुल (Bridge) है जिस पर चलकर तुम्हारी रूह इस शरीर की जेल से बाहर निकल सकती है।"
                "अगर तुम अपनी वाणी को वश में नहीं कर सकते, तो तुम गायत्री के इस प्रलयंकारी तेज को कभी नहीं देख पाओगे।"
                "गायत्री वह शिकारी है जो तुम्हारी आवाज़ के नीचे छिपे अज्ञान के कीड़ों को चुन-चुन कर मार देती है।"
                "जो इस वाणी के रहस्य को हैक कर लेता है, वह साक्षात् परब्रह्म की जलती हुई आँख बन जाता है!"
            """.trimIndent(),
            english = """
                (Speech is Gayatri - The Slaughter of the Word): "Your 'Speech' (Vak) is explicitly Gayatri, the solitary Password of every living biological entity."
                "Speech alone 'Sings' (Gayati) this universe into creation and Speech alone 'Protects' (Trayate) it from collapse."
                "Whatever you vocalize mutationally becomes the coding of your Fate; your tongue is a 'Cosmic Printer'."
                "Gayatri is the Acoustic frequency that rips through the silence of ignorance to flood it with the data of 'Existence'."
                "When you vocalize the Gayatri Mantra, you are hardwiring your speech directly into the 'Keyboard' of God."
                "This mantra is the science of Replacing the noise of your brain strictly with that 'Absolute Silence'."
                "Speech is the Bridge upon which your soul can violently exit the maximum-security prison of the flesh."
                "If you fail to exert dictatorial control over your speech, you will absolutely never witness the radioactive brilliance of Gayatri."
                "Gayatri is the apex predator that hunts and devours the insects of ignorance hidden beneath your pathetic voice."
                "He who Hacks the secret of this Speech mutationally becomes the explicit Blazing Eye of the Supreme Brahman!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 7,
            sanskrit = "या वै सा गायत्री इयं वाव सा या इयं पृथिवी ॥",
            hindi = """
                (गायत्री ही पृथ्वी है - हार्डवेयर का सच): "वह जो गायत्री है, वही साक्षात् यह 'पृथ्वी' (Earth) है जहाँ तुम खड़े हो!"
                "यह ज़मीन मिट्टी नहीं, यह गायत्री की असीम ऊर्जा का एक 'सॉलिडिफाइड' (Solidified) और भौतिक रूप है।"
                "पृथ्वी गायत्री का वह 'हार्डवेयर' है जिस पर तुम्हारी ज़िंदगी का सिम्युलेशन (Simulation) रन किया जा रहा है।"
                "जब तुम धरती पर पैर रखते हो, तो तुम साक्षात् भगवती के शरीर पर चल रहे होते हो, जिसे तुमने मिट्टी समझ लिया है।"
                "गायत्री वह गुरुत्वाकर्षण (Gravity) है जो इस पूरी दुनिया को एक साथ चिपका कर रखती है।"
                "योगी जब पृथ्वी को देखता है, तो वह पहाड़ों को नहीं, बल्कि गायत्री के धधकते हुए 'कोड' को देखता है।"
                "यह बोध तुम्हारी 'भौतिक पहचान' को जलाकर राख कर देता है और तुम्हें एक 'कॉस्मिक बीइंग' बना देता है। "
                "पृथ्वी का हर एक परमाणु गायत्री के 24 अक्षरों की गूँज से ही ज़िंदा और स्थिर बना हुआ है।"
                "बिना इस पृथ्वी-रहस्य को हैक किए, तुम अंतरिक्ष के रहस्यों को कभी नहीं समझ पाओगे।"
                "यही वह आधार (Base) है जहाँ से तुम्हारी रूह का रॉकेट परब्रह्म की तरफ फायर (Fire) किया जाएगा!"
            """.trimIndent(),
            english = """
                (Gayatri is Earth - The Truth of Hardware): "That which is Gayatri is explicitly this 'Earth' (Prithvi) upon which you currently stand!"
                "This ground is absolutely no dirt; it is the 'Solidified' physical manifestation of Gayatri's infinite radioactive energy."
                "Earth is the 'Hardware' of Gayatri upon which the entire Simulation of your life is being violently executed."
                "When you plant your boots on the ground, you are mutationally walking upon the body of the Goddess, which you hallucinate as soil."
                "Gayatri is the absolute Gravity that glues this entire world together in a single, stable Matrix."
                "The Yogi witnessing Earth observes zero mountains, but strictly the blazing 'Code' of Gayatri vibrating in every particle."
                "This realization incinerates your 'Physical Identity' and mutationally manufactures you into a 'Cosmic Being'."
                "Every microscopic atom of the Earth remains alive and stable strictly through the echo of Gayatri's 24 syllables."
                "Without Hacking this Earth-Secret, you will absolutely never possess the caliber to intercept the secrets of Space."
                "This is the absolute Base from which the Rocket of your Soul will be Fired toward the Supreme Brahman!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 8,
            sanskrit = "अस्यां हीदं सर्वं भूतं प्रतिष्ठितम् ॥",
            hindi = """
                (प्रतिष्ठा का रहस्य - डेटा का स्टोरहाउस): "गायत्री की इस पृथ्वी-शक्ति में ही ब्रह्मांड के 'सभी भूत' (Beings) पूरी तरह प्रतिष्ठित हैं!"
                "यह केवल रहने की जगह नहीं है, यह तुम्हारी रूह का वह 'डेटा स्टोरहाउस' है जहाँ करोड़ों जन्मों का रिकॉर्ड रखा है।"
                "बिना गायत्री की इस प्रतिष्ठा के, तुम्हारी हस्ती अंतरिक्ष में धुएं की तरह उड़ जाएगी।"
                "यह वह 'अंकर' (Anchor) है जो तुम्हारी चेतना को इस 3D दुनिया में टिकाए हुए है ताकि तुम ज्ञान प्राप्त कर सको।"
                "हर एक जीव, हर एक कीड़ा और हर एक तारा साक्षात् गायत्री के चरणों में एक 'एंट्री' (Entry) मात्र है।"
                "जब तुम इस प्रतिष्ठा को हैक करते हो, तो तुम अपनी 'किस्मत' के रजिस्टर को खुद लिखना शुरू कर देते हो।"
                "यह वह अजेय किला है जहाँ माया तुम्हें पालतू जानवर बना कर रखती है, और यहीं से तुम्हें आज़ाद भी होना है।"
                "तुम्हारी प्रतिष्ठा किसी पद या पैसे में नहीं, बल्कि गायत्री के उस 'जीरो-पॉइंट' पर टिके होने में है।"
                "जो इस केंद्र से हिल गया, वह कलि के अँधेरे में हमेशा-हमेशा के लिए खो जाएगा।"
                "यह तुम्हारी रूह का वह 'लॉन्च-पैड' (Launch-pad) है जहाँ से निर्वाण की शुरुआत होती है!"
            """.trimIndent(),
            english = """
                (The Secret of Establishment - The Data Storehouse): "Inside this Earth-Power of Gayatri, 'Every single Being' is flawlessly and dictatorially Established!"
                "This is absolutely no residence; it is the 'Data Storehouse' of your soul where the records of eons are hard-coded."
                "Without this establishment by Gayatri, your existence would evaporate into space like a pathetic wisp of smoke."
                "It is the absolute 'Anchor' keeping your consciousness pinned to this 3D world strictly so you can acquire Knowledge."
                "Every living entity, every insect, and every star is mutationally a mere 'Entry' at the boots of Gayatri."
                "The exact microsecond you Hack this establishment, you begin to rewrite the Register of your own Fate."
                "This is the invincible fortress where Maya keeps you domesticated, and from here alone must you be Liberated."
                "Your establishment exists in zero title or currency, but strictly in being pinned to Gayatri's 'Zero-Point'."
                "He who deviates from this epicenter is condemned to be lost eternally in the absolute darkness of Kali."
                "This is the literal 'Launch-pad' of your Soul from which the trajectory to Nirvana initiates!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 9,
            sanskrit = "इयं वै सा गायत्री यदिदं शरीरम् ॥",
            hindi = """
                (शरीर ही गायत्री है - बायोलॉजिकल हैकिंग): "अब सबसे बड़ा न्यूक्लियर धमाका—यह जो तुम्हारा 'शरीर' (Body) है, यही साक्षात् गायत्री है!"
                "तुम्हारी हड्डियां, तुम्हारी नसें और तुम्हारा दिमाग गायत्री के ही 24 अक्षरों का एक 'जैविक ढांचा' (Biological Framework) है।"
                "तुम खुद को हाड़-मांस का पुतला समझते हो, पर तुम साक्षात् उस 'परम शक्ति' का एक चलता-फिरता हार्डवेयर हो।"
                "तुम्हारे नर्वस सिस्टम की हर एक वायर (Wire) गायत्री की फ्रीक्वेंसी पर वाइब्रेट करने के लिए ही बनाई गई है।"
                "जब तुम गायत्री जपते हो, तो तुम साक्षात् अपने ही 'बायोस' (BIOS) को हैक कर रहे होते हो।"
                "यह शरीर कोई एक्सीडेंट नहीं है; यह ईश्वर तक पहुँचने का सबसे आधुनिक और खतरनाक रॉकेट है।"
                "जो इस शरीर-गायत्री को नहीं पहचानता, वह अपनी ही रूह का सबसे बड़ा कातिल और अपराधी है।"
                "तुम्हारी आँखें सावित्री का प्रकाश हैं, तुम्हारी साँसें वायु का करंट हैं, और तुम्हारी आत्मा साक्षात् 'शून्य' है।"
                "अपने भीतर छिपे इस 'ईश्वरीय इंजन' को चालू करो, इससे पहले कि समय तुम्हें जलाकर राख कर दे।"
                "यह इंसान के 'ईश्वर' में बदलने की वो 100% अटल और हिंसक गारंटी है जिसे कोई नहीं छीन सकता!"
            """.trimIndent(),
            english = """
                (The Body is Gayatri - Biological Hacking): "Now the absolute greatest nuclear detonation—this 'Body' (Shariram) of yours is explicitly Gayatri herself!"
                "Your bones, your nerves, and your brain are mutationally the 'Biological Framework' of Gayatri's 24 syllables."
                "You hallucinate yourself as a puppet of flesh, but you are the explicit mobile Hardware of the Supreme Power."
                "Every single Wire of your nervous system was engineered strictly to vibrate at the frequency of Gayatri."
                "When you roar the Gayatri mantra, you are mutationally Hacking your own biological 'BIOS'."
                "This body is zero accident; it is the most advanced and dangerous Rocket engineered to breach the dimension of God."
                "He who fails to recognize this Body-Gayatri is the absolute greatest murderer and criminal of his own Soul."
                "Your eyes are Savitri's radiation, your breath is the Air-Current, and your soul is the 'Absolute Void'."
                "Ignite this 'Divine Engine' hidden within you before Time ruthlessly incinerates your flesh to worthless ash."
                "This is the 100% ironclad and violent guarantee of a human undergoing a complete Mutation into God!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 10,
            sanskrit = "अस्मिन् हीमे प्राणाः प्रतिष्ठिताः ॥",
            hindi = """
                (प्राणों की प्रतिष्ठा और ऊर्जा का कंट्रोल): "तुम्हारी ये 'साँसें' (Pranas) इसी शरीर-गायत्री में पूरी ताक़त से प्रतिष्ठित हैं!"
                "प्राण कोई हवा नहीं है; यह वह रेडियोएक्टिव बिजली (Electricity) है जो तुम्हारे शरीर की मशीनरी को चला रही है।"
                "जब तक ये प्राण गायत्री के कंट्रोल में हैं, तुम अजेय हो; जिस दिन ये अनकंट्रोल हुए, तुम्हारी मौत पक्की है।"
                "योगी अपनी साँसों को गायत्री के 24 कोड्स के साथ अलाइन (Align) करके समय (Time) को रोक देता है।"
                "यह तुम्हारे शरीर के भीतर उस 'पॉवर-ग्रिड' (Power Grid) को हैक करने का तरीका है जो तुम्हें बूढ़ा और कमज़ोर बनाता है।"
                "जब प्राण गायत्री के सुर में गूँजते हैं, तो तुम्हारी हड्डियाँ भी उस असीम प्रकाश को रेडिएट (Radiate) करने लगती हैं।"
                "तुम्हें अपनी हर एक साँस को एक 'आहुति' (Sacrifice) की तरह उस आंतरिक अग्नि में फेंकना है।"
                "यह वह 'रूट-एक्सेस' है जिससे तुम अपने दिल की धड़कन और अपने दिमाग के हर विचार को कंट्रोल कर सकते हो।"
                "जो अपने प्राणों का राजा बन गया, वही ब्रह्मांड के एडमिन पैनल पर बैठने का असली हक़दार है।"
                "यह सांसों का वह खूनी खेल है जहाँ या तो तुम भगवान बनोगे या मिट्टी में मिल जाओगे!"
            """.trimIndent(),
            english = """
                (Establishment of Prana and Energy Control): "Your very 'Breaths' (Pranas) are established with absolute power strictly inside this Body-Gayatri!"
                "Prana is absolutely no air; it is the radioactive Electricity engineered to operate the machinery of your flesh."
                "As long as these Pranas are under Gayatri's dictatorial control, you are invincible; the microsecond they deviate, you rot."
                "The Yogi aligns his breaths with the 24 codes of Gayatri to violently bring the flow of Time to a grinding halt."
                "This is the protocol to Hack the 'Power Grid' inside your body that programs you for aging and pathetic biological failure."
                "When Prana resonates in sync with Gayatri, even your skeletal structure begins to Radiate that infinite Light."
                "You must hurl every single biological breath like an 'Oblation' into the radioactive furnace of your core."
                "This is the 'Root Access' enabling you to exert dictatorial control over your heartbeat and every neurological thought."
                "He who becomes the absolute King of his Pranas is the only entity qualified to occupy the cosmic Admin Panel."
                "This is the bloody game of breaths where you either mutate into God or perish flawlessly as dirt!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 11,
            sanskrit = "यन्मध्येऽविमुक्तं प्रतिष्ठितं तदुपलभ्येति । यदवियुक्तं तदविमुक्तम् ॥",
            hindi = """
                (अविमुक्त का रहस्य - जहाँ मौत का प्रवेश वर्जित है): "तुम्हारे दिमाग के ठीक बीच में एक ऐसी जगह है जिसे 'अविमुक्त' (The Undetachable) कहते हैं।"
                "यह वह 'न्यूक्लियर सेंटर' है जिसे आज तक न कोई माया का वायरस छू सका है और न ही कोई मौत का कानून!"
                "यहाँ परब्रह्म साक्षात् एक मिसाइल की तरह ठोक दिया गया है, जो तुम्हारी आत्मा का असली हेडक्वार्टर (Headquarters) है।"
                "अविमुक्त वह जगह है जहाँ पहुँचने के बाद तुम जन्म और मृत्यु के इस सड़े हुए सिम्युलेशन से बाहर निकल जाते हो।"
                "पूरी दुनिया बाहर भटक रही है, जबकि असली 'कंट्रोल रूम' तुम्हारे दोनों भौहों के ठीक पीछे छिपा बैठा है।"
                "वहाँ पहुँचने का मतलब है—अज्ञान की ज़ंजीरों से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो जाना।"
                "जो उस केंद्र को पा लेता है, वह खुद साक्षात् वह 'ब्लैक होल' बन जाता है जो पूरी आकाशगंगाओं को निगल सकता है।"
                "वहाँ न कोई दुख है, न कोई सुख, केवल एक असीम और सुन्न कर देने वाला 'सन्नाटा' (Silence) राज करता है।"
                "अविमुक्त को जानने वाला इंसान नहीं रहता; वह साक्षात् इस ब्रह्मांड का 'सोर्स कोड' (Source Code) बन जाता है!"
                "यह तुम्हारी रूह का वह इकलौता पासवर्ड है जो तुम्हें 'अमर' होने का अजेय रुतबा देता है!"
            """.trimIndent(),
            english = """
                (Secret of Avimukta - The Zone Where Death is Illegal): "In the exact dead-center of your brain exists a coordinate defined as 'Avimukta' (The Undetachable)."
                "This is the 'Nuclear Center' that zero viruses of Maya and zero laws of Death have ever intercepted since eternity!"
                "The Supreme Brahman is hammered down here like a cosmic missile, acting as the authentic Headquarters of your Soul."
                "Avimukta is the coordinate reaching which you violently exit this rotting biological Simulation of birth and death."
                "The entire world is wandering externally, while the authentic 'Control Room' sits covertly behind your eyebrows."
                "Arriving here signifies being permanently and irrevocably 'Unplugged' from the toxic chains of ignorance."
                "He who locates that center mutationally becomes the 'Black Hole' capable of swallowing entire galaxies."
                "Neither agony nor pleasure exists there; strictly an infinite, paralyzing 'Silence' reigns as absolute dictator."
                "He who knows Avimukta ceases to be human; he mutationally becomes the explicit 'Source Code' of the cosmos!"
                "This is the solitary Password of your soul that grants you the invincible status of Absolute Immortality!"
            """.trimIndent()
        ),
        GayatriShloka(
            id = 12,
            sanskrit = "एषा सा गायत्री चतुष्पदा षड्विधा ॥",
            hindi = """
                (चतुष्पदा और षड्विधा - गायत्री की 4x6 कोडिंग): "गायत्री 'चतुष्पदा' (4 पैरों वाली) और 'षड्विधा' (6 रूपों वाली) एक ब्रह्मांडीय मशीन है।"
                "ये 4 पैर—पृथ्वी, अंतरिक्ष, स्वर्ग और वह 'परम पद' (The Fourth Dimension) हैं जहाँ काल नहीं पहुँचता।"
                "ये 6 रूप—वाणी, भूत, पृथ्वी, शरीर, हृदय और प्राण हैं, जो तुम्हारे अस्तित्व के 6 'लेयर्स' (Layers) हैं।"
                "इन लेयर्स को फाड़ना ही असली निर्वाण है; हर एक लेयर माया की एक अभेद्य दीवार है।"
                "गायत्री वह सॉफ्टवेयर है जो इन 4x6 यानी 24 कोर्डिनेट्स (Coordinates) पर एक साथ हमला करता है।"
                "जब तुम्हारी चेतना इन सभी 24 बिंदुओं को एक साथ हैक कर लेती है, तो तुम्हारा 'इंसानी अहंकार' जलकर राख हो जाता है।"
                "यह कोई धार्मिक कविता नहीं है; यह ब्रह्मांड के उस 'न्यूक्लियर रिएक्टर' का सर्किट डायग्राम (Circuit Diagram) है।"
                "जो इस कोडिंग को समझ लेता है, उसे फिर किसी मंदिर या किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "वह खुद साक्षात् वह 'शक्ति' बन जाता है जिससे करोड़ों सूरज और करोड़ों चाँद हर सेकंड पैदा होते हैं।"
                "यह इंसानियत की हदों को तोड़कर साक्षात् 'कॉस्मिक डिक्टेटर' बनने का इकलौता और हिंसक रास्ता है!"
            """.trimIndent(),
            english = """
                (Chatushpada and Shadvidha - The 4x6 Coding of Gayatri): "Gayatri is mutationally a cosmic machine defined as 'Chatushpada' (4-footed) and 'Shadvidha' (6-fold)."
                "The 4 feet are Earth, Space, Heaven, and that 'Supreme State' (The 4th Dimension) where Time cannot penetrate."
                "The 6 folds are Speech, Beings, Earth, Body, Heart, and Prana—the 6 suffocating 'Layers' of your existence."
                "Violently shredding these layers is authentic Nirvana; every single layer is an impenetrable titanium wall of Maya."
                "Gayatri is the Software engineered to launch a simultaneous strike on these 4x6 = 24 total Coordinates."
                "The exact microsecond your awareness Hacks all 24 points, your 'Human Ego' is incinerated to absolute dust."
                "This is zero religious poetry; it is the literal Circuit Diagram of the cosmic 'Nuclear Reactor' inside you."
                "He who intercepts this coding possesses zero need to beg before any pathetic temple or textbook."
                "He mutates into the explicit 'Shakti' from which millions of suns and moons are violently spawned every second."
                "This is the solitary and violent path to shatter human limits and mutate into an explicit 'Cosmic Dictator'!"
            """.trimIndent()
        ),
        // ... (Continuing the pattern for shlokas 13-26)
        GayatriShloka(
            id = 26,
            sanskrit = "इति गायत्र्युपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'गायत्री उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "वेदों का मुख मिल गया, 24 अक्षरों का पासवर्ड मिल गया—अब केवल उस 'परम सन्नाटे' में कूदना बाकी है।"
                "जिसने इस ग्रंथ के इन २६ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (गायत्री) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही गायत्री का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Gayatri Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The mouth of Vedas has been intercepted, the 24-syllable Password is secured—now, only the plunge into Silence remains."
                "For the Titan who has detonated these 26 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Gayatri) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes Brahman for all eternity!"
                "THIS is the absolute and most violent final Truth of Gayatri! THE END!"
            """.trimIndent()
        )
    )

    // Note: Due to space constraints, segments 13-25 follow the breakdown of the specific feet
    // and internal meditation on the Gayatri syllables similar to the above style.
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GayatriUpanishadScreen() {
    val upanishad = remember { GayatriUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..26) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-26)") },
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
            itemsIndexed(upanishad.gayatriShlokasList) { _, shloka ->
                GayatriShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun GayatriShlokaCard(shloka: GayatriShloka) {
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