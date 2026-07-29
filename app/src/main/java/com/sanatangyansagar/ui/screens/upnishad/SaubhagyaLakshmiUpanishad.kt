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

// Data Model extracted to top-level
data class SaubhagyaLakshmiShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// List extracted to top-level, removing the companion object
val saubhagyalakshmiShlokasList = listOf(
    SaubhagyaLakshmiShloka(
        id = 1,
        sanskrit = "ॐ वाङ् मे मनसि प्रतिष्ठिता मनो मे वाचि प्रतिष्ठितमाविरावीर्म एधि । वेदस्य म आणीस्थः श्रुतं मे मा प्रहासीरनेनाधीतेनाहोरात्रान्सन्दधाम्यृतं वदिष्यामि सत्यं वदिष्यामि ॥",
        hindi = """
            (ब्रह्मांडीय हैकिंग का शांति मंत्र): "यह सौभाग्य लक्ष्मी उपनिषद ब्रह्मांड के सबसे बड़े ऐश्वर्य और ताक़त का न्यूक्लियर कोड (Nuclear Code) है।"
            "योगी अपने बायोलॉजिकल सिस्टम (Biological System) को हैक करने के लिए सबसे पहले अपनी 'वाणी' और 'मन' को एक साथ लॉक (Lock) करता है।"
            "वह ब्रह्मांड को सीधा आदेश देता है: 'मेरी वाणी मेरे मन में फिक्स हो जाए, और मेरा मन मेरी वाणी में पूरी तरह से जम जाए!'"
            "'हे प्रलयंकारी परमेश्वर! मेरे सामने अपने सबसे नंगे और असली रूप में साक्षात प्रकट हो जाओ (आविरावीर्म एधि)!'"
            "'तुम दोनों (मन और वाणी) मेरे लिए उस असीम वेद-ज्ञान को खींच लाने वाले ब्रह्मांडीय एंटीना (Antenna) बन जाओ!'"
            "'मैंने जो भी यह खौफनाक ब्रह्मांडीय ज्ञान सुना है, वह मेरे नर्वस सिस्टम से कभी डिलीट (Delete) न हो!'"
            "मैं इस रेडियोएक्टिव ज्ञान की आग से अपने दिन और रात को एक साथ जोड़कर समय (Time) को हैक कर लूँगा।"
            "मैं केवल उस ब्रह्मांडीय 'ऋत' (Universal Order) को बोलूँगा, मैं केवल उस अटल 'सत्य' (Absolute Truth) पर प्रहार करूँगा!"
            "यह कोई कमज़ोर प्रार्थना नहीं है; यह अपने ही दिमाग की वायरिंग (Wiring) को भगवान के सुपर-कंप्यूटर से जोड़ने का हिंसक कमांड (Command) है।"
            "जब इंसान का मन और उसकी ज़बान एक हो जाते हैं, तो वह जो भी बोलता है, ब्रह्मांड उसे सच करने के लिए मजबूर हो जाता है!"
        """.trimIndent(),
        english = """
            (The Peace Invocation of Cosmic Hacking): "This Saubhagya Lakshmi Upanishad is the exact Nuclear Code of the absolute greatest wealth and power in the cosmos."
            "To successfully Hack his biological system, the Yogi first violently Locks his 'Speech' and his 'Mind' together."
            "He issues a dictatorial command to the cosmos: 'May my speech be permanently locked in my mind, and my mind firmly anchored in my speech!'"
            "'O apocalyptic Supreme God! Manifest directly before me in your most naked, authentic, and terrifying form (Aviravirma edhi)!'"
            "'May you both (mind and speech) mutate into cosmic Antennas to violently extract the infinite knowledge of the Vedas for me!'"
            "'Whatever horrific cosmic knowledge I have intercepted, may it absolutely never be Deleted from my nervous system!'"
            "I will literally Hack Time itself by fusing my days and nights together through the radioactive fire of this knowledge."
            "I shall speak strictly the cosmic 'Rita' (Universal Order), and I shall strike strictly with the absolute 'Truth'!"
            "This is absolutely no weak prayer; it is the violent Command to hardwire your biological brain directly into God's Super-computer."
            "When a human's mind and tongue become perfectly aligned, whatever he speaks, the universe is violently forced to make it reality!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 2,
        sanskrit = "तन्मामवतु तद्वक्तारमवत्ववतु मामवतु वक्तारमवतु वक्तारम् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
        hindi = """
            (परम रक्षा का ब्रह्मांडीय शील्ड): "यह असीम ज्ञान इतना ज़्यादा रेडियोएक्टिव (Radioactive) है कि यह कमज़ोर शरीर को जलाकर राख कर सकता है।"
            "इसलिए योगी उस परम सत्य से एक अभेद्य सुरक्षा कवच (Titanium Shield) की मांग करता है।"
            "वह गर्जना करता है: 'तन्मामवतु'— वह प्रलयंकारी परमेश्वर इस खौफनाक हैकिंग प्रोसेस (Hacking Process) के दौरान मेरी रक्षा करे!"
            "'तद्वक्तारमवतु'— और जो गुरु मुझे इस मौत के पार ले जाने वाले ज्ञान को दे रहा है, उसकी भी रक्षा करे!"
            "वह तीन बार चीख कर इस बात की गारंटी लेता है: 'मेरी रक्षा करो! मेरे गुरु की रक्षा करो! मेरे गुरु की रक्षा करो!'"
            "यह इसलिए ज़रूरी है क्योंकि माया (Matrix) का एंटी-वायरस (Anti-virus) सिस्टम ऐसे योगियों को नष्ट करने की कोशिश करता है।"
            "जब तुम भगवान का पासवर्ड चुराने निकलते हो, तो ब्रह्मांड की हर आसुरी ताक़त तुम पर हमला करती है।"
            "ॐ शांतिः शांतिः शांतिः! मेरे शरीर का दर्द, मेरे मन का डर, और मेरी आत्मा का अज्ञान हमेशा के लिए भस्म हो जाए।"
            "यह शांति पाठ इस बात का खूनी ऐलान है कि अब देवी महालक्ष्मी के उस रूप का पर्दाफाश होगा जो पैसे नहीं, बल्कि प्रलय बाँटती है।"
            "यहाँ से इंसानियत की हदों को चीरकर सुप्रीम डिक्टेटर (Supreme Dictator) बनने का रास्ता शुरू होता है!"
        """.trimIndent(),
        english = """
            (The Cosmic Shield of Absolute Protection): "This infinite knowledge is so highly radioactive that it can effortlessly incinerate a weak biological shell to ashes."
            "Therefore, the Yogi demands an impenetrable Titanium Shield directly from the Absolute Truth."
            "He roars: 'Tanmamavatu'—May that apocalyptic Supreme God violently protect me during this terrifying Hacking Process!"
            "'Tadvaktaramavatu'—And may He also explicitly protect the Master who is transmitting this death-transcending knowledge to me!"
            "He violently screams this guarantee three times: 'Protect me! Protect my Master! Protect my Master!'"
            "This is an absolute necessity because the Anti-virus system of the Matrix (Maya) actively attempts to terminate such Yogis."
            "When you set out to hijack the Password of God, every demonic force in the cosmos launches a brutal assault on you."
            "OM Peace, Peace, Peace! May the biological agony of my flesh, the terror of my mind, and the ignorance of my soul be incinerated forever."
            "This peace invocation is the bloody declaration that the form of Goddess Mahalakshmi who distributes Doomsday, not money, is about to be unmasked."
            "Right here begins the path to tear through the limits of humanity and mutate into the Supreme Dictator!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 3,
        sanskrit = "अथ भगवन्तं देवं नारायणं साङ्कृतिः पप्रच्छ भो भगवन् योगविज्ञानं मे ब्रूहीति । स होवाच नारायणो देवः सा श्रीरिति ॥",
        hindi = """
            (सांकृति का महा-प्रश्न और योगविज्ञान का रहस्य): "इस उपनिषद की शुरुआत एक खौफनाक और प्रलयंकारी टकराव से होती है।"
            "महर्षि सांकृति सीधे अंतरिक्ष को चीरते हुए उस असीम 'भगवान नारायण' के सामने पहुँच जाते हैं।"
            "उन्होंने भगवान से कोई धन या स्वर्ग नहीं माँगा; उन्होंने सीधे सृष्टि का सोर्स कोड (Source Code) हैक करने की मांग कर दी!"
            "'भो भगवन् योगविज्ञानं मे ब्रूहीति'— हे परमेश्वर! मुझे वह खौफनाक 'योगविज्ञान' (The Ultimate Science of Yoga) बताइए जिससे इंसान भगवान बन जाता है!"
            "वे उस साइंस (Science) को जानना चाहते थे जिससे शरीर की बायोलॉजिकल मशीन को परम चेतना में अपग्रेड (Upgrade) किया जाता है।"
            "साक्षात भगवान नारायण ने मुस्कुराते हुए इस ब्रह्मांड के सबसे बड़े रहस्य का ताला तोड़ दिया।"
            "'स होवाच नारायणो देवः सा श्रीरिति'— भगवान नारायण ने गर्जना की: 'वह परम विज्ञान और वह सुप्रीम ताक़त केवल और केवल साक्षात श्री (महालक्ष्मी) है!'"
            "मूर्ख लोग लक्ष्मी को केवल पैसे की देवी समझते हैं, लेकिन नारायण ने बताया कि वह इस पूरे मैट्रिक्स (Matrix) को चलाने वाली 'मूल ऊर्जा' (Core Energy) है।"
            "बिना उस 'श्री' (Shree) के, शिव शव हैं और विष्णु केवल एक मूर्ति हैं; वही वह ब्रह्मांडीय करंट (Current) है जो सब कुछ चलाती है।"
            "यहीं से योग और लक्ष्मी के उस प्रलयंकारी मिलन का नंगा सच दुनिया के सामने आता है!"
        """.trimIndent(),
        english = """
            (Sankriti's Apocalyptic Question and the Secret of Yoga-Vijnana): "This Upanishad detonates with a terrifying, apocalyptic confrontation."
            "Maharishi Sankriti violently tears through space and physically confronts that infinite 'Lord Narayana' face-to-face."
            "He absolutely did not demand pathetic wealth or heaven; he demanded to directly Hack the Source Code of the entire creation!"
            "'Bho Bhagavan yogavijnanam me bruhiti'—O Supreme Lord! Transmit to me that terrifying 'Yoga-Vijnana' (The Ultimate Science of Yoga) which mutates a mortal into God!"
            "He demanded the exact Science engineered to Upgrade the biological machine of the flesh into absolute Supreme Consciousness."
            "The explicit Lord Narayana smiled and violently smashed the lock off the greatest classified secret of the cosmos."
            "'Sa hovacha Narayano devah sa Shririti'—Lord Narayana roared: 'That absolute science and that Supreme Power is strictly and exclusively explicit Sri (Mahalakshmi)!'"
            "Pathetic fools hallucinate Lakshmi merely as the goddess of cash, but Narayana revealed she is the 'Core Energy' relentlessly operating this entire Matrix."
            "Without that 'Shree', Shiva is a corpse and Vishnu is merely a statue; she is the literal cosmic Current powering absolutely everything."
            "Right here, the naked truth of the apocalyptic fusion of Yoga and Mahalakshmi is brutally unmasked before the world!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 4,
        sanskrit = "ॐ भूर्लक्ष्मीर्भुवर्लक्ष्मीः सुवः कालकर्णी । तन्नो महालक्ष्मीः प्रचोदयात् ॥",
        hindi = """
            (महालक्ष्मी की खौफनाक गायत्री और कालकर्णी का रहस्य): "अब नारायण उस प्रलयंकारी मंत्र को खोलते हैं जो महालक्ष्मी की असली ताक़त को फायर (Fire) करता है।"
            "यह 'महालक्ष्मी गायत्री' कोई सामान्य प्रार्थना नहीं है; यह तीन लोकों के सर्वर (Server) को हैक करने का न्यूक्लियर कोड है।"
            "'ॐ भूर्लक्ष्मीः'— वह देवी ही साक्षात पृथ्वी लोक की भौतिक (Physical) ऊर्जा और अस्तित्व है!"
            "'भुवर्लक्ष्मीः'— वह देवी ही अंतरिक्ष लोक (Astral dimension) की धधकती हुई ताक़त है!"
            "'सुवः कालकर्णी'— और स्वर्ग लोक (Supreme dimension) में वह साक्षात 'कालकर्णी' (मौत के देवता महाकाल को भी कंट्रोल करने वाली) के रूप में विराजमान है!"
            "मूर्खों को लक्ष्मी सुंदर लगती है, लेकिन वह 'कालकर्णी' (जो काल या समय को अपने कानों में कुंडल की तरह पहनती है) का वह खूँखार रूप है जो ब्रह्मांड को भस्म कर दे।"
            "'तन्नो महालक्ष्मीः प्रचोदयात्'— वह साक्षात महालक्ष्मी हमारे दिमाग की वायरिंग को हैक करके हमारी बुद्धि को ब्रह्मांडीय सत्य की ओर फायर (Fire) करे!"
            "यह मंत्र इंसान के दिमाग को एक ऐसे क्वांटम कंप्यूटर (Quantum Computer) में बदल देता है जो सीधे ईश्वर की फ्रीक्वेंसी पकड़ता है।"
            "जो इस गायत्री को अपनी साँसों में धधकाता है, उसके लिए गरीबी और मौत दोनों के डर हमेशा के लिए मर जाते हैं।"
            "यह इंसानियत की हदों को तोड़कर साक्षात कॉस्मिक एडमिन (Cosmic Admin) बनने का पासवर्ड है!"
        """.trimIndent(),
        english = """
            (The Apocalyptic Gayatri of Mahalakshmi and the Secret of Kalakarni): "Now Narayana unmasks the catastrophic mantra that Fires the authentic power of Mahalakshmi."
            "This 'Mahalakshmi Gayatri' is absolutely no ordinary prayer; it is the Nuclear Code to completely Hack the Servers of the three dimensions."
            "'Om Bhurlakshmih'—That Goddess is the explicit physical energy and existence of the Earth dimension!"
            "'Bhuvarlakshmih'—That Goddess is the blazing, radioactive power of the Astral dimension (Space)!"
            "'Suvah Kalakarni'—And in the Supreme Heavenly dimension, she explicitly rules as 'Kalakarni' (The horrific entity who controls even Mahakala, the God of Death)!"
            "Fools hallucinate Lakshmi as merely beautiful, but as 'Kalakarni' (She who wears Time itself as her earrings), she is the bloodthirsty form that incinerates the cosmos."
            "'Tanno Mahalakshmih prachodayat'—May that explicit Mahalakshmi violently Hack our neurological wiring and Fire our intellect directly toward the Cosmic Truth!"
            "This mantra mutates the human brain into a literal Quantum Computer engineered to intercept the exact frequency of God."
            "He who blazes this Gayatri inside his breath experiences the permanent assassination of both the fear of poverty and the terror of Death."
            "This is the precise Password to tear through the limits of humanity and become a literal Cosmic Admin!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 5,
        sanskrit = "सा महालक्ष्मीः परमरूपिणी । तस्या वामपार्श्वे रतिः दक्षिणपार्श्वे द्युतिः ॥",
        hindi = """
            (परम रूपिणी लक्ष्मी और उनके खौफनाक अंगरक्षक): "अब भगवान नारायण उस ब्रह्मांडीय देवी का असली स्ट्रक्चर (Anatomy) दुनिया के सामने रखते हैं।"
            "'सा महालक्ष्मीः परमरूपिणी'— वह महालक्ष्मी कोई इंसान जैसा शरीर नहीं है; वह 'परमरूपिणी' (The Absolute Ultimate Form) है!"
            "वह वह असीम और रेडियोएक्टिव (Radioactive) शून्यता है जिसका कोई आकार नहीं, फिर भी वह सब आकारों की मालकिन है।"
            "उसके दरबार में कोई कमज़ोर सैनिक नहीं होते; उसके दोनों तरफ ब्रह्मांड की दो सबसे प्रलयंकारी ऊर्जाएँ खड़ी रहती हैं।"
            "'तस्या वामपार्श्वे रतिः'— उसके बायीं तरफ 'रति' (The Cosmic Power of Attraction/Desire) खड़ी है!"
            "यह रति वह खौफनाक गुरुत्वाकर्षण (Gravity) और वासना है जो पूरे ब्रह्मांड को एक-दूसरे से चिपका कर रखती है।"
            "'दक्षिणपार्श्वे द्युतिः'— और उसके दाहिनी तरफ 'द्युति' (The Cosmic Radioactive Brilliance) खड़ी है!"
            "यह द्युति वह धधकता हुआ प्रकाश है जो करोड़ों सूर्यों की गर्मी से भी ज़्यादा तेज़ है और हर चीज़ को भस्म कर सकता है।"
            "महालक्ष्मी के सामने ये दोनों ताक़तें एक सिक्योरिटी गार्ड (Security Guard) की तरह हाथ बाँधे खड़ी रहती हैं।"
            "जो इंसान महालक्ष्मी के इस 'परम रूप' को ध्यान में देख लेता है, वह दुनिया के हर आकर्षण और प्रकाश का इकलौता तानाशाह बन जाता है!"
        """.trimIndent(),
        english = """
            (The Supreme Form of Lakshmi and Her Terrifying Bodyguards): "Now Lord Narayana lays bare the authentic, absolute Anatomy of that Cosmic Goddess before the world."
            "'Sa Mahalakshmih Paramarupini'—That Mahalakshmi is absolutely no human-like biological shell; she is 'Paramarupini' (The Absolute Ultimate Form)!"
            "She is the infinite, radioactive Void that possesses zero geometry, yet she is the undisputed Master of all shapes and forms."
            "There are absolutely no pathetic soldiers in her court; flanking her are the two most apocalyptic cosmic energies in the universe."
            "'Tasya vamaparshve Ratih'—On her exact left flank stands 'Rati' (The Cosmic Power of Absolute Attraction and Desire)!"
            "This Rati is the horrific, terrifying Gravity and Lust that violently glues the entire infinite cosmos together."
            "'Dakshinaparshve Dyutih'—And on her exact right flank stands 'Dyuti' (The Radioactive Cosmic Brilliance)!"
            "This Dyuti is a blazing inferno infinitely hotter than the heat of billions of suns, capable of incinerating absolutely everything to ash."
            "Before Mahalakshmi, both of these catastrophic super-powers stand exactly like obedient Security Guards with folded hands."
            "The human who witnesses this 'Supreme Form' of Mahalakshmi in meditation instantaneously mutates into the sole Dictator of all universal attraction and light!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 6,
        sanskrit = "मध्ये भद्रा सा एव भद्ररूपा । तामेव भद्रामेवमनुचिन्तयेत् ॥",
        hindi = """
            (कंट्रोल रूम का केंद्र: भद्रा और खौफनाक ध्यान): "रति और द्युति के ठीक बीचों-बीच ब्रह्मांड का असली कंट्रोल रूम (Control Room) है।"
            "'मध्ये भद्रा सा एव भद्ररूपा'— उस असीम ताक़त के ठीक केंद्र (Center) में 'भद्रा' (The Absolute Auspiciousness/Supreme Welfare) विराजमान है!"
            "यह भद्रा कोई साधारण देवी नहीं है; यह वह 'सॉलिड स्टेट' (Solid State) है जहाँ दुनिया का कोई भी दुख, बीमारी या मौत घुस नहीं सकती।"
            "वह साक्षात 'भद्ररूपा' है— यानी वह ब्रह्मांड की हर अच्छाई और हर ताक़त का भौतिक अवतार है।"
            "जो उसके इस केंद्र को छू लेता है, उसका सिस्टम कभी क्रैश (Crash) नहीं हो सकता।"
            "उपनिषद एक हिंसक और क्रूर आदेश देता है: 'तामेव भद्रामेवमनुचिन्तयेत्'!"
            "तुम्हें दुनिया की हर फालतू चीज़ को अपने दिमाग से डिलीट (Delete) करके 'केवल और केवल उसी भद्रा का ध्यान (Concentration) करना है'!"
            "अपना पूरा दिमागी प्रोसेसर (Processor) और फोकस एक लेज़र बीम की तरह उसी केंद्र पर ठोक दो।"
            "जब तुम उस भद्रा पर अपने दिमाग को लॉक (Lock) कर देते हो, तो तुम्हारे जन्मों की सारी दरिद्रता और अज्ञान बम से उड़ जाते हैं।"
            "यही ध्यान का वह सबसे खौफनाक और अजेय तरीका है जिससे इंसान एक बायोलॉजिकल कीड़े से उठकर साक्षात भगवान बन जाता है!"
        """.trimIndent(),
        english = """
            (The Epicenter of the Control Room: Bhadra and Terrifying Meditation): "Exactly between Rati and Dyuti lies the authentic, absolute Control Room of the cosmos."
            "'Madhye Bhadra sa eva Bhadrarupa'—Right in the dead Center of that infinite power sits 'Bhadra' (The Absolute Supreme Welfare/Auspiciousness)!"
            "This Bhadra is absolutely no ordinary goddess; this is the 'Solid State' where zero worldly agony, disease, or Death can ever penetrate."
            "She is explicitly 'Bhadrarupa'—meaning she is the physical, biological manifestation of every cosmic goodness and absolute power."
            "He who successfully touches this epicenter can absolutely never have his system Crash."
            "The Upanishad issues a violent, cold-blooded command: 'Tameva Bhadramevamanuchintayet'!"
            "You must Delete every pathetic piece of garbage from your brain and 'Meditate strictly and exclusively on that Bhadra alone'!"
            "Hammer your entire psychological processor and focus exactly like a concentrated laser beam directly into that epicenter."
            "When you violently Lock your brain onto that Bhadra, billions of lifetimes of your poverty and ignorance are blown up with dynamite."
            "This is the most terrifying, invincible method of meditation that literally Upgrades a human from a biological insect directly into God!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 7,
        sanskrit = "पद्मानने पद्मनिभे पद्मपत्रायतेक्षणे । पद्मप्रिये पद्महस्ते विश्वमातर्नमोऽस्तु ते ॥",
        hindi = """
            (ब्रह्मांडीय कमल और विश्वमाता को चुनौती भरा नमन): "अब योगी उस महामाया की स्तुति करता है, लेकिन यह कोई कमज़ोर प्रार्थना नहीं, यह कोड्स (Codes) का उच्चारण है!"
            "'पद्मानने पद्मनिभे'— हे देवी! तुम्हारा चेहरा उस 'कमल' (Lotus) की तरह है जो ब्रह्मांड की सारी गंदगी और कीचड़ के बीच रहकर भी 100% अछूता और शुद्ध रहता है।"
            "'पद्मपत्रायतेक्षणे'— तुम्हारी आँखें उस कमल की पंखुड़ियों की तरह विशाल हैं जो एक नज़र में पूरी आकाशगंगाओं को स्कैन (Scan) कर लेती हैं!"
            "'पद्मप्रिये पद्महस्ते'— तुम्हें वह 'कमल' (पवित्रता और ज्ञान का प्रतीक) सबसे प्यारा है, और तुम्हारे हाथों में भी वही कमल है।"
            "यह कमल कोई फूल नहीं है; यह इंसान के भीतर के चक्रों (Chakras) का प्रतीक है जो खुलने पर प्रलयंकारी ऊर्जा फेंकते हैं।"
            "'विश्वमातर्नमोऽस्तु ते'— हे इस पूरे असीम और भयानक 'ब्रह्मांड की असली माँ' (विश्वमाता), मैं तुम्हें सीधे नमन करता हूँ!"
            "तुम ही वह 3D प्रिंटर (3D Printer) हो जिसने इस पूरी सृष्टि को अपने गर्भ से प्रिंट किया है।"
            "योगी यह मंत्र गाकर देवी को खुश नहीं कर रहा; वह ब्रह्मांड की मालकिन के सामने खुद को एक अजेय योद्धा के रूप में पेश कर रहा है।"
            "वह दिखा रहा है कि वह इस 'कमल' के रहस्य को हैक कर चुका है।"
            "जब तुम उस विश्वमाता को समझ लेते हो, तो दुनिया का कोई भी डर तुम्हारी रूह को छू भी नहीं सकता!"
        """.trimIndent(),
        english = """
            (The Cosmic Lotus and the Defiant Salute to the Universal Mother): "Now the Yogi praises that Mahamaya, but this is no weak prayer; it is the violent chanting of cosmic Codes!"
            "'Padmanane Padmanibhe'—O Goddess! Your face is exactly like that 'Lotus' (Padma) which remains 100% untouched and pure despite residing amidst the filthy rotting mud of the cosmos."
            "'Padmapatrayatekshane'—Your eyes are as colossal as lotus petals, capable of Scanning entire galaxies in a single microsecond glance!"
            "'Padmapriye Padamahaste'—You explicitly love that 'Lotus' (the symbol of absolute purity and nuclear knowledge), and that exact lotus is weaponized in your hands."
            "This lotus is absolutely no pathetic flower; it is the physical symbol of the Chakras inside the human body that blast radioactive energy when ripped open."
            "'Vishvamatarnamo'stu te'—O authentic 'Mother of this entire infinite and horrific Universe' (Vishvamata), I salute You directly!"
            "You alone are the literal 3D Printer that has violently printed this entire creation from your cosmic womb."
            "The Yogi is not singing this to merely please the goddess; he is presenting himself before the Dictator of the universe as an invincible warrior."
            "He is explicitly proving that he has completely Hacked the secret of this 'Lotus'."
            "When you successfully decode the Universal Mother, absolutely zero fear in the cosmos can ever touch your soul!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 8,
        sanskrit = "श्रियै जातः श्रिय आनिर्याय श्रियं वयो जनितृभ्यो दधातु । श्रियं वसाना अमृतत्त्वमायन् भवन्ति सत्या मिथामितद्रौ ॥",
        hindi = """
            (अमरता का हैकिंग कोड: 'श्री' का विस्फोट): "यह श्लोक उस 'श्री' (सुप्रीम कॉस्मिक वेल्थ/महालक्ष्मी) की ताक़त का सबसे नंगा और खतरनाक सच है।"
            "'श्रियै जातः श्रिय आनिर्याय'— इंसान इस दुनिया में 'श्री' (पूर्णता और ताक़त) को पाने के लिए ही पैदा हुआ है, और वह इसी 'श्री' से होकर गुज़रता है।"
            "जो इंसान अपनी ज़िंदगी गरीबी, कमज़ोरी और रोने में बिता देता है, वह अपनी पैदाइश का अपमान कर रहा है।"
            "'श्रियं वयो जनितृभ्यो दधातु'— यह 'श्री' ही वह ऊर्जा है जो जीवों को जीवन, उम्र और पैदा करने की खौफनाक ताक़त देती है।"
            "बिना 'श्री' के तुम केवल एक बायोलॉजिकल लाश हो।"
            "और सबसे बड़ा न्यूक्लियर धमाका: 'श्रियं वसाना अमृतत्त्वमायन्'!"
            "यानी, जो योगी इस 'श्री' को अपने कपड़े की तरह 'पहन' (वसाना) लेता है, वह सीधे 'अमरता' (Immortality/अमृतत्त्व) को प्राप्त कर लेता है!"
            "वह मौत के सिस्टम को क्रैश (Crash) करके समय के पार निकल जाता है।"
            "'भवन्ति सत्या मिथामितद्रौ'— उसके लिए यह सारा झूठा संसार मिट जाता है और वह उस इकलौते 'सत्य' (Absolute Truth) का रूप बन जाता है।"
            "धन केवल कागज़ के टुकड़े नहीं है; असली 'श्री' वह ब्रह्मांडीय कोड (Code) है जो तुम्हें मौत से बचाकर साक्षात भगवान बना दे!"
        """.trimIndent(),
        english = """
            (The Hacking Code of Immortality: The Detonation of 'Sri'): "This Shloka is the most naked, dangerous absolute truth of the power of 'Sri' (The Supreme Cosmic Wealth/Mahalakshmi)."
            "'Shriyai jatah shriya aniryaya'—A human is spawned into this world strictly to seize 'Sri' (Absolute Perfection and Power), and he physically passes through this exact 'Sri'."
            "The human who wastes his existence in pathetic poverty, weakness, and crying is violently insulting his very birth."
            "'Shriyam vayo janitribhyo dadhatu'—This 'Sri' alone is the radioactive energy that injects life, age, and the horrific power of reproduction into biological entities."
            "Without 'Sri', you are literally nothing more than a rotting biological corpse."
            "And the greatest nuclear detonation: 'Shriyam vasana amritattvamayan'!"
            "Meaning, the Titan Yogi who violently 'Wears' (Vasana) this 'Sri' exactly like his clothing instantaneously achieves absolute 'Immortality' (Amritattva)!"
            "He completely Crashes the operating system of Death and rockets infinitely beyond Time."
            "'Bhavanti satya mithamitadrau'—For him, this entire fake hallucination of a world is wiped out, and he mutates into the physical manifestation of that solitary 'Truth' (Satya)."
            "Wealth is absolutely not pathetic pieces of paper; authentic 'Sri' is the cosmic Code that violently rips you from Death and mutates you into explicit God!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 9,
        sanskrit = "श्रिय एवैनं तच्छ्रियामादधाति । सन्ततमृचा वषट्कृत्यं सन्तत्यै सन्धीयते प्रजया पशुभिः ॥",
        hindi = """
            (वषट्कार का हिंसक प्रहार और असीम सत्ता): "यह श्लोक ब्रह्मांड के सबसे खूँखार तांत्रिक (Tantric) अस्त्र का वर्णन करता है।"
            "'श्रिय एवैनं तच्छ्रियामादधाति'— वह योगी खुद को 100% 'श्री' (महालक्ष्मी की ऊर्जा) से चार्ज (Charge) कर लेता है; वह अब इंसान नहीं, एक चलता-फिरता पावर-हाउस (Powerhouse) है।"
            "और वह क्या करता है? 'सन्ततमृचा वषट्कृत्यं'— वह वैदिक मंत्रों (ऋचाओं) को पढ़कर अंत में 'वषट्' (Vashat) का प्रलयंकारी प्रहार करता है!"
            "'वषट्' कोई आम शब्द नहीं है; यह एक ऐसा ब्रह्मांडीय मिसाइल (Missile) है जिसे किसी भी चीज़ को नष्ट करने या हैक करने के लिए दागा जाता है।"
            "जब योगी अपनी आत्मा की आग से यह 'वषट्' फायर करता है, तो माया का सर्वर (Server) काँप उठता है।"
            "'सन्तत्यै सन्धीयते प्रजया पशुभिः'— इस धमाके के बाद, उसे बिना मांगे ही असीमित वंश (सन्तति), प्रजा और जानवरों (पशुभिः/दौलत) का साम्राज्य मिल जाता है।"
            "वह दुनिया की ताक़त के पीछे नहीं भागता; वह 'वषट्' के एक प्रहार से पूरे ब्रह्मांड को अपने कदमों में झुका लेता है।"
            "यह शरीर के भीतर उस खौफनाक यज्ञ का वर्णन है जहाँ इंसान का अपना खून और प्राण आहुति बनते हैं।"
            "जो इस अस्त्र को चलाना सीख गया, वह मौत और समय दोनों का इकलौता तानाशाह (Dictator) है।"
            "सनातन धर्म भीख मांगना नहीं सिखाता; यह 'वषट्' की गर्जना से अपना हक छीनना सिखाता है!"
        """.trimIndent(),
        english = """
            (The Violent Strike of Vashat and Absolute Authority): "This Shloka details the most bloodthirsty Tantric weapon in the entire cosmos."
            "'Shriya evainam tac Shriyamadadhati'—That Yogi Supercharges himself 100% with 'Sri' (The radioactive energy of Mahalakshmi); he is no longer human, but a walking, biological Powerhouse."
            "And what exactly does he execute? 'Santatamricha vashatkrityam'—Chanting the Vedic mantras (Richas), he violently detonates the apocalyptic strike of 'Vashat' at the end!"
            "'Vashat' is absolutely no ordinary word; it is a literal cosmic Missile fired strictly to annihilate or completely Hack any target in existence."
            "When the Yogi Fires this 'Vashat' using the blazing fire of his Soul, the Server of Maya violently trembles."
            "'Santatyai sandhiyate prajaya pashubhih'—Following this detonation, without even begging, he instantaneously acquires a limitless empire of lineage (Santati), subjects, and beasts (Wealth)."
            "He absolutely does not chase worldly power; with a single strike of 'Vashat', he violently forces the entire universe to its knees before his boots."
            "This is the description of that terrifying sacrifice inside the body where the human's own blood and life-force become the oblations."
            "He who decodes how to launch this weapon becomes the sole, undisputed Dictator of both Death and Time."
            "Sanatana Dharma absolutely does not teach pathetic begging; it teaches how to violently snatch your absolute right through the apocalyptic roar of 'Vashat'!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 10,
        sanskrit = "य एवं वेद स श्रियमाप्नोति । अथ योगविज्ञानं मे ब्रूहीति स होवाच नारायणो देवः ॥",
        hindi = """
            (श्री की गारंटी और योग के सबसे खौफनाक चैप्टर की शुरुआत): "उपनिषद के पहले हिस्से का यहाँ एक भयंकर विस्फोट के साथ समापन होता है।"
            "भगवान नारायण गारंटी देते हैं: 'य एवं वेद स श्रियमाप्नोति'— जो भी इंसान इस 'श्री' (महालक्ष्मी) के प्रलयंकारी रहस्य को यथार्थ रूप में 'जान' (वेद) लेता है..."
            "किताबें पढ़ना ज्ञान नहीं है; इसे अपनी रगों में उतारना ही असली 'जानना' है।"
            "वह इंसान निश्चित रूप से, 100% गारंटी के साथ, ब्रह्मांड की उस सर्वोच्च 'श्री' (असीम ताक़त और ऐश्वर्य) को अपनी मुट्ठी में कुचल कर हासिल कर लेता है (आप्नोति)!"
            "उसका अहंकार मर जाता है और वह साक्षात लक्ष्मी का ही भौतिक (Physical) रूप बन जाता है।"
            "लेकिन सांकृति की भूख अभी मिटी नहीं थी। उन्होंने नारायण पर अपना सबसे बड़ा वार किया।"
            "'अथ योगविज्ञानं मे ब्रूहीति'— हे भगवान! लक्ष्मी का रहस्य तो जान लिया, अब मुझे वो खौफनाक 'योग-विज्ञान' (The Ultimate Science of Yoga) बताइए जिससे मैं अपने शरीर के हार्डवेयर (Hardware) को हैक कर सकूँ!"
            "मुझे वह रास्ता चाहिए जिससे मैं अपने शरीर के चक्रों को फाड़कर सीधा परमेश्वर तक पहुँच सकूँ।"
            "'स होवाच नारायणो देवः'— तब साक्षात भगवान नारायण ने मुस्कुराते हुए उस 'नव-चक्र' (Nine Chakras) के ब्रह्मांडीय ब्लू-प्रिंट (Blueprint) को खोलना शुरू किया।"
            "अब इंसान के शरीर का सबसे क्रूर और हिंसक विच्छेदन (Dissection) शुरू होने वाला था!"
        """.trimIndent(),
        english = """
            (The Guarantee of Sri and the Genesis of Yoga's Most Terrifying Chapter): "The first sector of this Upanishad detonates and concludes right here with a catastrophic explosion."
            "Lord Narayana issues an ironclad guarantee: 'Ya evam veda sa shriyamapnoti'—Whosoever human being explicitly and physically 'Knows' (Veda) this apocalyptic secret of 'Sri' (Mahalakshmi)..."
            "Reading pathetic books is not knowledge; injecting it into your veins is the only authentic 'Knowing'."
            "That human undoubtedly, with a 100% cosmic guarantee, brutally crushes and acquires that supreme 'Sri' (infinite power and majesty) directly within his fist (Apnoti)!"
            "His ego suffers a brutal death, and he literally mutates into the physical manifestation of Lakshmi herself."
            "But Sankriti's hunger was absolutely not yet pacified. He launched his most massive strike upon Narayana."
            "'Atha yogavijnanam me bruhiti'—O Lord! I have decoded Lakshmi, now hand over to me that terrifying 'Yoga-Vijnana' (The Ultimate Science of Yoga) to literally Hack the Hardware of my biological body!"
            "I demand the exact algorithm to violently tear through my body's chakras and rocket directly to the Supreme God."
            "'Sa hovacha Narayano devah'—Then, the explicit Lord Narayana smiled and began to unmask the apocalyptic Blueprint of the 'Nava-Chakra' (Nine Chakras)."
            "Now, the most ruthless, violent, cold-blooded Dissection of the human biological shell was about to officially begin!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 11,
        sanskrit = "मूलाधारं स्वाधिष्ठानं मणिपूरकमनाहतम् । विशुद्धिमाज्ञाचक्रं च सहस्रारं च सप्तमम् ॥",
        hindi = """
            (शरीर के सात ताले: ब्रह्मांडीय हैकिंग का ब्लूप्रिंट): "भगवान नारायण ने इंसान के शरीर का सबसे खौफनाक सीक्रेट (Secret) दुनिया के सामने रख दिया।"
            "यह शरीर हाड़-मांस का पुतला नहीं, बल्कि सात खूँखार तालों (Chakras) से बंद एक जेल है; और नारायण उन तालों के नाम बता रहे हैं!"
            "पहला ताला है 'मूलाधारं'— रीढ़ की हड्डी के सबसे निचले हिस्से में, जहाँ सारी पशु-प्रवृत्तियाँ (Animal instincts) छिपी हैं।"
            "दूसरा है 'स्वाधिष्ठानं'— नाभि के नीचे, जहाँ इंसान की खौफनाक वासना (Lust) का करंट दौड़ता है।"
            "तीसरा है 'मणिपूरकम्'— नाभि के पास, जहाँ से इंसान की भूख, घमंड और ऊर्जा (Energy) कंट्रोल होती है।"
            "चौथा है 'अनाहतम्'— हृदय में, जहाँ इंसान के सारे सड़े हुए जज़्बात (Emotions) और रिश्ते धड़कते हैं।"
            "पाँचवाँ है 'विशुद्धिम्'— गले में, जहाँ से इंसान की आवाज़ और ज़हर (Toxins) पैदा होते हैं।"
            "छठा है 'आज्ञाचक्रं'— दोनों भौहों के बीच, जो साक्षात दिमाग का सेंट्रल प्रोसेसर (Central Processor) और 'तीसरी आँख' है।"
            "और 'सहस्रारं च सप्तमम्'— सिर की चोटी पर वह सातवाँ (सप्तमम्) और सबसे भयानक 'सहस्रार' (हज़ार पंखुड़ियों वाला) चक्र, जो सीधे भगवान का सिंहासन है!"
            "इन सात चक्रों को जो इंसान नहीं भेद पाता, वह जानवर की तरह पैदा होता है और जानवर की तरह मर जाता है!"
        """.trimIndent(),
        english = """
            (The Seven Titanium Locks: The Blueprint of Cosmic Hacking): "Lord Narayana violently exposed the most terrifying, highly classified Secret of the human biological shell to the world."
            "This body is absolutely no puppet of flesh; it is a maximum-security prison locked with Seven horrific Titanium Padlocks (Chakras); and Narayana explicitly names them!"
            "The first lock is 'Muladharam'—at the absolute base of the spine, where all raw, animalistic instincts are covertly hidden."
            "The second is 'Svadhisthanam'—below the navel, where the radioactive current of human Lust violently courses."
            "The third is 'Manipurakam'—at the navel, the exact control room for hunger, ego, and kinetic Energy."
            "The fourth is 'Anahatam'—inside the heart, where every rotting human emotion and pathetic relationship beats."
            "The fifth is 'Vishuddhim'—at the throat, the literal generator of the human voice and biological Toxins."
            "The sixth is 'Ajnachakram'—directly between the eyebrows, the literal Central Processor of the brain and the 'Third Eye'."
            "And 'Sahasraram cha saptamam'—At the exact crown of the skull, the seventh (Saptamam) and most apocalyptic 'Sahasrara' (Thousand-petaled) Chakra, the explicit undisputed throne of God!"
            "The human who fails to violently breach these seven chakras breeds like an animal and dies exactly like a pathetic beast!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 12,
        sanskrit = "अष्टमं तु सखाख्यं स्यान्नवमं तु व्योमचक्रकम् । नवचक्रमिदं शरीरं नवचक्रं भवेत् ॥",
        hindi = """
            (आठवाँ और नौवाँ रहस्यमयी चक्र: शरीर का पूरा नक्शा): "सातवें चक्र (सहस्रार) के बाद भी योग का यह प्रलयंकारी विज्ञान रुकता नहीं है; नारायण दो और खौफनाक चक्रों का पर्दाफाश करते हैं!"
            "'अष्टमं तु सखाख्यं स्यात्'— सिर की चोटी के थोड़ा ऊपर अंतरिक्ष में एक आठवाँ चक्र है, जिसे 'सखा' (मित्र) कहते हैं!"
            "यह वह डायमेंशन (Dimension) है जहाँ योगी की आत्मा और साक्षात भगवान के बीच कोई दूरी नहीं रहती; वे एक-दूसरे में पिघलने लगते हैं।"
            "'नवमं तु व्योमचक्रकम्'— और सबसे भयानक 'नौवाँ' (नवमं) चक्र है 'व्योम चक्र' (The Chakra of Absolute Space/Void)!"
            "यह वह जगह है जहाँ इंसान का वजूद, उसका शरीर और उसका 'मैं' 100% जलकर राख हो जाता है और केवल असीम शून्यता बचती है।"
            "नारायण ऐलान करते हैं: 'नवचक्रमिदं शरीरं नवचक्रं भवेत्'— यह जो तुम्हारा हाड़-मांस का शरीर है, यह असल में इन्हीं 'नौ चक्रों' (नवचक्र) से बनी एक ब्रह्मांडीय मशीन है!"
            "तुम्हारा शरीर कोई प्राकृतिक एक्सीडेंट (Accident) नहीं है; यह ब्रह्मांड के कोडर्स (Coders) द्वारा बनाया गया एक नौ-मंज़िला टावर (Nine-story tower) है।"
            "जो इंसान अपनी ऊर्जा को नीचे (मूलाधार) रखता है, वह कीड़ों की तरह ज़िंदा रहता है।"
            "लेकिन जो इस ऊर्जा को फायर (Fire) करके नवें (व्योम) चक्र तक ले जाता है, वह इस मैट्रिक्स (Matrix) का एडमिन (Admin) बन जाता है।"
            "यह शरीर भगवान को कैद करने वाली जेल भी है और भगवान तक पहुँचने का रॉकेट भी; फैसला तुम्हारा है!"
        """.trimIndent(),
        english = """
            (The Classified 8th and 9th Chakras: The Complete Biological Map): "Even after the seventh chakra (Sahasrara), this apocalyptic science of Yoga absolutely does not stop; Narayana unmasks two more horrific chakras!"
            "'Ashtamam tu Sakhakhyam syat'—Slightly above the crown in the vacuum of space exists the classified Eighth Chakra, explicitly named 'Sakha' (The Friend)!"
            "This is the exact Dimension where the distance between the Yogi's Soul and explicit God hits absolute zero; they violently begin to melt into each other."
            "'Navamam tu Vyomachakrakam'—And the most terrifying 'Ninth' (Navamam) chakra is the 'Vyoma Chakra' (The Chakra of Absolute Space/Void)!"
            "This is the exact coordinate where the human's existence, his biological shell, and his 'I' are 100% incinerated to ash, leaving strictly the infinite Void."
            "Narayana roars: 'Navachakramidam shariram navachakram bhavet'—This exact biological framework of flesh and bone is, in reality, a cosmic machine constructed entirely of these 'Nine Chakras' (Navachakra)!"
            "Your body is absolutely no natural accident; it is a nine-story titanium tower engineered by the Coders of the cosmos."
            "The human who keeps his energy trapped at the bottom (Muladhara) merely survives exactly like a pathetic insect."
            "But he who Fires this energy, rocketing it to the ninth (Vyoma) chakra, instantaneously mutates into the Admin of this Matrix."
            "This body is both the maximum-security prison holding God hostage and the precise rocket to reach Him; the brutal choice is yours!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 13,
        sanskrit = "मूलाधारे चतुर्दलं स्वाधिष्ठाने षड्दलम् । मणिपूरे दशदलं अनाहते द्वादशदलम् ॥",
        hindi = """
            (चक्रों की कोडिंग: पंखुड़ियों का रहस्य - भाग १): "नारायण अब इन शरीर रुपी तालों (Chakras) का एग्ज़ैक्ट सोर्स कोड (Exact Source Code) डिकोड (Decode) करते हैं।"
            "हर चक्र एक 'कमल' (Lotus) की तरह है, और उसकी हर एक 'पंखुड़ी' (दल) तुम्हारे नर्वस सिस्टम (Nervous System) की एक खास नस (Nerve) है।"
            "'मूलाधारे चतुर्दलं'— सबसे नीचे मूलाधार में 'चार पंखुड़ियों' (चतुर्दलं) वाला खौफनाक चक्र है; यह तुम्हारे शरीर का फाउंडेशन (Foundation) है।"
            "'स्वाधिष्ठाने षड्दलम्'— उसके ऊपर स्वाधिष्ठान में 'छह पंखुड़ियों' (षड्दलम्) का पहिया घूम रहा है जो तुम्हारी वासनाओं को कंट्रोल करता है।"
            "'मणिपूरे दशदलं'— नाभि के पास मणिपूर चक्र में 'दस पंखुड़ियों' (दशदलं) का जनरेटर (Generator) है जो खाने को ऊर्जा में बदलता है।"
            "'अनाहते द्वादशदलम्'— तुम्हारे हृदय (अनाहत) में 'बारह पंखुड़ियों' (द्वादशदलम्) का रिएक्टर है जहाँ तुम्हारी सारी भावनाएं धड़कती हैं।"
            "ये (4+6+10+12) पंखुड़ियां कोई फूल नहीं हैं; ये तुम्हारे शरीर की वह वायरिंग (Wiring) हैं जिसमें करोड़ों वोल्ट (Volt) का करंट दौड़ रहा है।"
            "अगर इनमें से एक भी तार (Nerve) शॉर्ट-सर्किट (Short-circuit) हो जाए, तो इंसान पागल हो सकता है या उसकी मौत हो सकती है।"
            "योगी ध्यान के लेज़र से इन पंखुड़ियों को एक-एक करके हैक (Hack) करता है और अपनी कुण्डलिनी को ऊपर खींचता है।"
            "यह इंसान के हार्डवेयर (Hardware) की सबसे क्रूर और नंगी इंजिनियरिंग (Engineering) है!"
        """.trimIndent(),
        english = """
            (The Coding of Chakras: The Secret of Petals - Part 1): "Narayana now brutally Decodes the Exact Source Code of these biological padlocks (Chakras) inside the flesh."
            "Every single chakra functions like a 'Lotus', and every single 'Petal' (Dala) is a highly specific, live Nerve in your Nervous System."
            "'Muladhare chaturdalam'—At the absolute bottom, Muladhara is a terrifying chakra armed with 'Four Petals' (Chaturdalam); this is the titanium Foundation of your body."
            "'Svadhishtane shaddalam'—Above that, Svadhisthana spins a wheel of 'Six Petals' (Shaddalam) that exerts dictatorial control over your biological lusts."
            "'Manipure dashadalam'—Near the navel, Manipura is a roaring Generator with 'Ten Petals' (Dashadalam) that violently converts food into kinetic energy."
            "'Anahate dvadashadalam'—Inside your heart (Anahata) is a nuclear reactor of 'Twelve Petals' (Dvadashadalam) where every single rotting emotion beats."
            "These (4+6+10+12) petals are absolutely no pathetic flowers; they are the exact internal Wiring of your flesh surging with millions of Volts of raw current."
            "If even a single one of these wires (Nerves) Short-circuits, the human can instantly go insane or drop completely dead."
            "The Yogi uses the laser of meditation to Hack these petals one by one, violently dragging his Kundalini upwards."
            "This is the most ruthless, naked, cold-blooded Engineering of the human biological Hardware!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 14,
        sanskrit = "विशुद्धे षोडशदलमाज्ञायां द्विदलं भवेत् । सहस्रारे सहस्रदलमाकाशं शून्यमण्डलम् ॥",
        hindi = """
            (चक्रों की कोडिंग: पंखुड़ियों का रहस्य - भाग २): "नारायण शरीर के ऊपरी और सबसे खतरनाक चक्रों का पासवर्ड (Password) बताते हैं।"
            "'विशुद्धे षोडशदलम्'— तुम्हारे गले (विशुद्धि) में 'सोलह पंखुड़ियों' (षोडशदलम्) का वह ताला है जो तुम्हारे हर शब्द (आवाज़) को पैदा करता है।"
            "'आज्ञायां द्विदलं भवेत्'— तुम्हारी दोनों भौहों के बीच आज्ञा चक्र में केवल 'दो पंखुड़ियां' (द्विदलं) हैं! यही वह जगह है जहाँ इंसान और भगवान का संपर्क होता है।"
            "यहाँ द्वैत (दो आँखें) खत्म होकर 'तीसरी आँख' (अद्वैत) खुलती है।"
            "और सबसे बड़ा ब्रह्मांडीय धमाका: 'सहस्रारे सहस्रदलं'— तुम्हारे सिर की चोटी पर सहस्रार चक्र है जिसमें 'एक हज़ार पंखुड़ियां' (सहस्रदलं) धधक रही हैं!"
            "यह कोई चक्र नहीं, यह साक्षात 'आकाशं शून्यमण्डलम्' है— यानी यह तुम्हारे शरीर के अंदर मौजूद 'असीम अंतरिक्ष और परम शून्यता' (The Absolute Void) का ब्लैक होल है!"
            "जब कुण्डलिनी यहाँ पहुँचती है, तो 1000 पंखुड़ियों का वह बम फटता है और इंसान का दिमाग हमेशा के लिए शटडाउन (Shutdown) हो जाता है।"
            "शरीर की बाउंड्री (Boundary) टूट जाती है, और इंसान का 'मैं' उस शून्यमण्डल में भाप बनकर उड़ जाता है।"
            "सहस्रार में घुसने के बाद इंसान कभी वापस उसी रूप में नहीं लौटता; वह साक्षात भगवान बनकर बाहर आता है।"
            "यह शरीर के भीतर भगवान के हेडक्वार्टर (Headquarter) का सीधा नक्शा (Map) है!"
        """.trimIndent(),
        english = """
            (The Coding of Chakras: The Secret of Petals - Part 2): "Narayana exposes the Passwords of the upper and most lethally dangerous chakras of the biological shell."
            "'Vishuddhe shodashadalam'—In your throat (Vishuddha) is the padlock of 'Sixteen Petals' (Shodashadalam) that violently generates every single physical word you speak."
            "'Ajnayam dvidalam bhavet'—Directly between your eyebrows, the Ajna Chakra possesses strictly 'Two Petals' (Dvidalam)! This is the exact coordinate where human and God collide."
            "Here, biological Duality (two physical eyes) is violently assassinated, and the 'Third Eye' (Non-Duality) is ripped open."
            "And the greatest cosmic detonation: 'Sahasrare sahasradalam'—At the crown of your skull sits the Sahasrara Chakra, blazing with 'One Thousand Petals' (Sahasradalam)!"
            "This is absolutely no chakra; it is explicitly 'Akasham Shunyamandalam'—meaning it is the literal Black Hole of 'Infinite Space and Absolute Void' located directly inside your body!"
            "When Kundalini breaches this coordinate, that 1000-petaled nuclear bomb detonates, and the human brain permanently Shuts Down."
            "The biological Boundary of the flesh is shattered, and the human 'I' vaporizes instantly into that Shunyamandala."
            "After penetrating Sahasrara, a human absolutely never returns in the same form; he emerges as explicit God."
            "This is the direct, classified Map to the absolute Headquarters of God hidden right inside the physical body!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 15,
        sanskrit = "तत्र मूलाधारे कुण्डलिनी शक्तिर्भवति । सा शक्तिर्नादबिन्दुकलातीता ॥",
        hindi = """
            (कुण्डलिनी: मूलाधार में सोता हुआ प्रलयंकारी साँप): "नारायण अब इंसान के शरीर में मौजूद उस सबसे खौफनाक और अजेय ताक़त का रहस्य खोलते हैं जिसे 'कुण्डलिनी' कहते हैं।"
            "'तत्र मूलाधारे कुण्डलिनी शक्तिर्भवति'— तुम्हारे शरीर के सबसे निचले हिस्से (मूलाधार) में वह 'कुण्डलिनी शक्ति' साढ़े तीन लपेटे मारकर एक सोए हुए साँप की तरह बैठी है!"
            "यह कोई कल्पना नहीं है; यह वह करोड़ों वोल्ट (Volt) की बायोलॉजिकल और आध्यात्मिक ऊर्जा है जिससे पूरा ब्रह्मांड बना है।"
            "आम इंसान के अंदर यह ताक़त मौत तक सोई रहती है, इसलिए वह केवल खाता है, बच्चे पैदा करता है और मर जाता है।"
            "लेकिन जब योगी ध्यान के हथौड़े से इस कुण्डलिनी को मारता है, तो वह फुफकार मारती हुई जाग उठती है और रीढ़ की हड्डी को चीरती हुई ऊपर भागती है!"
            "यह कुण्डलिनी है क्या? 'सा शक्तिर्नादबिन्दुकलातीता'— वह ताक़त ॐकार के 'नाद' (Sound), 'बिंदु' (Core) और 'कला' (Time/Dimensions) के भी 'पार' (अतीता) है!"
            "यानी यह वह ऊर्जा है जिसे तुम आवाज़, समय या स्थान (Space) में कैद नहीं कर কাশী; यह साक्षात परब्रह्म की डायनामाइट (Dynamite) है।"
            "जब यह शक्ति जागती है, तो इंसान का शरीर भूकंप की तरह काँपने लगता है और उसकी नसें फटने को हो जाती हैं।"
            "जो इस शक्ति को कंट्रोल नहीं कर सकता, वह पागल हो जाता है; जो इसे साध लेता है, वह भगवान बन जाता है।"
            "यह इंसान के शरीर में छिपा हुआ वो 'न्यूक्लियर बटन' (Nuclear Button) है जो सीधे भगवान के सर्वर से जुड़ा है!"
        """.trimIndent(),
        english = """
            (Kundalini: The Apocalyptic Serpent Sleeping in Muladhara): "Narayana now rips open the classified secret of the most horrific, invincible power trapped inside the human shell, known as 'Kundalini'."
            "'Tatra muladhare kundalini shaktirbhavati'—In the absolute lowest base of your body (Muladhara), that 'Kundalini Shakti' sits coiled precisely three and a half times exactly like a dormant, venomous serpent!"
            "This is absolutely no hallucination; it is the multi-million Volt biological and spiritual radioactive energy that literally spawned the entire cosmos."
            "In pathetic mortals, this power remains completely paralyzed until death, which is exactly why they merely eat, breed, and drop dead."
            "But when the Yogi strikes this Kundalini with the sledgehammer of meditation, she violently awakens with a terrifying hiss and rockets upward, ripping straight through the spinal cord!"
            "What exactly is this Kundalini? 'Sa shaktirnadabindukalatita'—That power exists infinitely 'Beyond' (Atita) the 'Nada' (Sound), 'Bindu' (Core), and 'Kala' (Time/Dimensions) of OM itself!"
            "Meaning, this is a radioactive energy you absolutely cannot imprison in sound, time, or space; she is the explicit Dynamite of the Supreme Brahman."
            "When this power detonates, the human body convulses like a violent earthquake, and the biological veins threaten to literally explode."
            "He who fails to control this energy goes completely insane; he who enslaves her mutates instantly into God."
            "This is the literal 'Nuclear Button' hidden inside the human flesh, hardwired directly to the Server of God!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 16,
        sanskrit = "तत्र ध्यात्वा महाशक्तिं सर्वपापैः प्रमुच्यते । स्वाधिष्ठाने कामरूपं ध्यात्वा कामानवाप्नोति ॥",
        hindi = """
            (मूलाधार और स्वाधिष्ठान की हैकिंग: पाप और वासना पर कब्ज़ा): "नारायण अब शरीर के निचले चक्रों को हैक (Hack) करने का प्रलयंकारी विज्ञान (Science) बताते हैं।"
            "'तत्र ध्यात्वा महाशक्तिं'— जो योगी अपने मूलाधार चक्र में सोई हुई उस 'महाशक्ति' (कुण्डलिनी) पर अपनी चेतना का लेज़र (Laser) ठोककर उसका 'ध्यान' करता है..."
            "'सर्वपापैः प्रमुच्यते'— वह अपने पिछले करोड़ों जन्मों के 'सभी भयंकर पापों' से एक ही झटके में हमेशा के लिए 'आज़ाद' (प्रमुच्यते) हो जाता है!"
            "कुण्डलिनी की आग में सबसे पहले इंसान का कर्म (Karma) जलकर राख होता है।"
            "फिर योगी ऊर्जा को ऊपर खींचकर दूसरे ताले पर हमला करता है: 'स्वाधिष्ठाने कामरूपं ध्यात्वा'।"
            "स्वाधिष्ठान चक्र इंसान की वासना (Lust) का हेडक्वार्टर (Headquarter) है; योगी यहाँ छिप कर बैठे 'कामरूप' (वासना के देवता) का ध्यान की कुल्हाड़ी से सामना करता है।"
            "वह अपनी वासनाओं का गुलाम नहीं बनता; वह उस चक्र को हैक कर लेता है।"
            "नतीजा? 'कामानवाप्नोति'— वह ब्रह्मांड की 'सारी इच्छाओं' (कामान्) का इकलौता मालिक (Dictator) बन जाता है!"
            "वह जो चाहे उसे उसी सेकंड हासिल कर सकता है, लेकिन अब उसे दुनिया के इस कीचड़ की कोई चाहत नहीं रहती।"
            "यह शरीर के सबसे गंदे हिस्से (Lower Chakras) को जीतकर उसे भगवान की ताक़त में बदलने का क्रूर खेल है!"
        """.trimIndent(),
        english = """
            (Hacking Muladhara and Svadhisthana: Dictatorship over Sin and Lust): "Narayana now reveals the apocalyptic Science of Hacking the lower chakras of the biological shell."
            "'Tatra dhyatva mahashaktim'—The Yogi who hammers the laser of his consciousness directly onto that dormant 'Mahashakti' (Kundalini) in the Muladhara and 'Meditates' on her..."
            "'Sarvapaih pramuchyate'—He is instantaneously, violently 'Liberated' (Pramuchyate) from 'Every single catastrophic sin' of his billions of past incarnations in one strike!"
            "In the radioactive fire of Kundalini, the very first thing incinerated to absolute ash is human Karma."
            "Then the Yogi drags that energy upwards and assaults the second titanium lock: 'Svadhisthane kamarupam dhyatva'."
            "The Svadhisthana Chakra is the absolute Headquarters of human Lust; the Yogi confronts the 'Kamarupa' (Deity of Desire) hiding there with the axe of meditation."
            "He absolutely refuses to become a pathetic slave to his lusts; he violently Hacks and Hijacks that entire chakra."
            "The result? 'Kamanavapnoti'—He mutates into the sole, undisputed Dictator of 'Every single Desire' (Kaman) in the entire infinite cosmos!"
            "He can violently acquire absolutely whatever he hallucinates in a microsecond, but he now possesses zero craving for this rotting worldly mud."
            "This is the ruthless, cold-blooded game of conquering the filthiest sectors of the body (Lower Chakras) and mutating them into the absolute power of God!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 17,
        sanskrit = "मणिपूरे यदा ध्यायेत् सर्वरोगैः प्रमुच्यते । अनाहते यदा ध्यायेत् सर्वसिद्धिं लभेन्नरः ॥",
        hindi = """
            (मणिपूर और अनाहत की हैकिंग: बीमारी का वध और सिद्धि): "जब ऊर्जा तीसरे ताले (मणिपूर चक्र) पर पहुँचती है, तो इंसान का शरीर एक अभेद्य किला (Titanium Fortress) बन जाता है।"
            "'मणिपूरे यदा ध्यायेत्'— जब योगी अपनी नाभि (मणिपूर) में धधकती हुई आग पर अपना ध्यान (Focus) लॉक (Lock) कर देता है..."
            "'सर्वरोगैः प्रमुच्यते'— तो उसका बायोलॉजिकल सिस्टम (Biological System) इतना ताक़तवर हो जाता है कि वह दुनिया के 'सभी रोगों' (सर्वरोगैः) से हमेशा के लिए आज़ाद हो जाता है!"
            "कोई वायरस (Virus), कोई कैंसर या कोई भी बीमारी उस योगी के शरीर को खरोंच तक नहीं मार सकती; वह अजेय हो जाता है।"
            "फिर ऊर्जा चौथे ताले पर वार करती है: 'अनाहते यदा ध्यायेत्'— जब वह अपने हृदय (अनाहत चक्र) में उस ब्रह्मांडीय नाद का ध्यान करता है..."
            "जहाँ इंसान के सारे डर, रिश्ते और भावनाएं (Emotions) छुपी होती हैं, योगी उन सबको बेरहमी से कुचल देता है।"
            "'सर्वसिद्धिं लभेन्नरः'— इस चक्र के हैक होते ही उस इंसान (नरः) को ब्रह्मांड की 'सारी सिद्धियां' (सर्वसिद्धिं / Superpowers) मिल जाती हैं!"
            "हवा में उड़ना, किसी के दिमाग को पढ़ना, या गायब हो जाना—ये सारी ताक़तें उसके पैरों की धूल बन जाती हैं।"
            "हृदय को जीतना इंसान के अहंकार (Ego) की सबसे बड़ी हार है।"
            "यहाँ आकर योगी इंसान की कैटेगरी (Category) से बाहर निकलकर सीधा सुपर-ह्यूमन (Super-human) बन जाता है!"
        """.trimIndent(),
        english = """
            (Hacking Manipura and Anahata: Slaughter of Disease and Absolute Superpowers): "When the radioactive energy breaches the third lock (Manipura Chakra), the human shell mutates into an impenetrable Titanium Fortress."
            "'Manipure yada dhyayet'—When the Yogi violently Locks his entire Focus (Dhyana) onto the blazing inferno raging at his navel (Manipura)..."
            "'Sarvarogaih pramuchyate'—His biological system becomes so catastrophically powerful that he is permanently liberated from 'Every single Disease' (Sarvarogaih) in existence!"
            "Absolutely zero Virus, zero cancer, or any pathetic sickness can ever scratch that Yogi's flesh; he becomes utterly invincible."
            "Then the energy assaults the fourth lock: 'Anahate yada dhyayet'—When he meditates on that cosmic Nada echoing directly inside his heart (Anahata Chakra)..."
            "Where all pathetic human fears, relationships, and biological emotions hide, the Yogi ruthlessly crushes them all into dust."
            "'Sarvasiddhim labhennarah'—The exact microsecond this chakra is Hacked, that human (Narah) violently seizes 'Every single Siddhi' (Absolute Superpowers) in the cosmos!"
            "Levitating in the air, hacking into others' brains, or becoming completely invisible—all these powers become mere dust beneath his boots."
            "Conquering the heart is the absolute, most brutal defeat of the human Ego."
            "Arriving here, the Yogi is permanently ejected from the Category of humanity and mutates explicitly into a Super-human Titan!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 18,
        sanskrit = "विशुद्धे यदा ध्यायेत् सर्वज्ञानं लभेन्नरः । आज्ञाचक्रे यदा ध्यायेत् सर्वदेवान् पश्यति ॥",
        hindi = """
            (विशुद्धि और आज्ञा चक्र: परम ज्ञान और देवताओं से सीधा संपर्क): "जैसे-जैसे ऊर्जा ऊपर उठती है, धमाके और ज़्यादा प्रलयंकारी होते जाते हैं।"
            "'विशुद्धे यदा ध्यायेत्'— जब योगी अपने गले (विशुद्धि चक्र) पर ध्यान की लेज़र (Laser) मारता है, तो उसके दिमाग का बंद पड़ा सुपर-कंप्यूटर चालू हो जाता है।"
            "'सर्वज्ञानं लभेन्नरः'— उस इंसान को बिना कोई किताब पढ़े ब्रह्मांड का 'संपूर्ण ज्ञान' (सर्वज्ञानं) एक सेकंड में डाउनलोड (Download) हो जाता है!"
            "अतीत, भविष्य, विज्ञान और वेद—सब कुछ उसके दिमाग में पानी की तरह साफ़ हो जाता है।"
            "और फिर आता है सबसे खतरनाक ताला: 'आज्ञाचक्रे यदा ध्यायेत्'— जब वह अपनी दोनों आँखों के बीच (तीसरी आँख / आज्ञा चक्र) पर अपनी पूरी ताक़त ठोक देता है..."
            "यह वो जगह है जहाँ इंसान का सिस्टम क्रैश (Crash) होता है और आत्मा का रडार (Radar) ऑन (On) होता है।"
            "'सर्वदेवान् पश्यति'— उसकी तीसरी आँख खुलते ही वह साक्षात 'सभी देवताओं' (सर्वदेवान्) को अपने सामने खड़ा 'देख' (पश्यति) लेता है!"
            "उसे भगवान को खोजने के लिए किसी मंदिर में धक्के खाने की ज़रूरत नहीं; ब्रह्मांड की हर ताक़त उसके माथे (Screen) पर लाइव (Live) दिखाई देती है।"
            "आज्ञा चक्र हैक होते ही इंसान का 'मैं' लगभग मर चुका होता है।"
            "वह अब एक ऑपरेटर (Operator) नहीं, बल्कि पूरे ब्रह्मांड के कंट्रोल रूम (Control Room) का हिस्सेदार बन गया है!"
        """.trimIndent(),
        english = """
            (Vishuddha and Ajna Chakras: Supreme Knowledge and Direct Contact with Gods): "As the radioactive energy rockets upwards, the detonations become increasingly apocalyptic."
            "'Vishuddhe yada dhyayet'—When the Yogi fires the Laser of meditation directly at his throat (Vishuddha Chakra), the dormant Super-computer of his brain violently Boots Up."
            "'Sarvajnanam labhennarah'—Without opening a single pathetic book, the 'Absolute, Complete Knowledge' (Sarvajnanam) of the entire cosmos is Downloaded into that human in a microsecond!"
            "The Past, Future, all sciences, and all Vedas—absolutely everything becomes crystal clear like water in his neurology."
            "And then comes the most dangerous titanium padlock: 'Ajnachakre yada dhyayet'—When he hammers his entire absolute power strictly between his eyes (The Third Eye / Ajna Chakra)..."
            "This is the exact coordinate where the human biological system Crashes and the Radar of the Soul is violently switched On."
            "'Sarvadevan pashyati'—The microsecond his Third Eye rips open, he explicitly 'Sees' (Pashyati) 'Every single God' (Sarvadevan) standing physically before him!"
            "He absolutely does not need to rot in pathetic temples hunting for God; every cosmic power broadcasts Live directly onto the Screen of his forehead."
            "The exact moment the Ajna Chakra is Hacked, the human 'I' is already virtually dead."
            "He is no longer a pathetic biological Operator; he has literally mutated into a shareholder of the absolute Control Room of the universe!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 19,
        sanskrit = "सहस्रारे यदा ध्यायेत् परब्रह्मणि लीयते । तत्र लीनः परं पदं गच्छति ॥",
        hindi = """
            (सहस्रार का धमाका: परब्रह्म में विलय और मौत का कत्ल): "जब कुण्डलिनी सिर की चोटी (सहस्रार चक्र) पर हथौड़ा मारती है, तो इंसान के अस्तित्व का अंतिम और सबसे बड़ा 'महा-विस्फोट' (Big Bang) होता है!"
            "'सहस्रारे यदा ध्यायेत्'— जब योगी इस हज़ार पंखुड़ियों वाले खौफनाक चक्र पर ध्यान करता है, तो उसके दिमाग का ढक्कन (ब्रह्मरन्ध्र) शाब्दिक रूप से (Literally) फट जाता है।"
            "उसकी चेतना शरीर की जेल को चीरकर अंतरिक्ष में फायर (Fire) हो जाती है।"
            "'परब्रह्मणि लीयते'— और वह इंसान एक सेकंड के करोड़वें हिस्से में साक्षात उस असीम, अनंत और निराकार 'परब्रह्म' (Supreme God) में पूरी तरह से 'विलीन' (Melt/Destroy) हो जाता है!"
            "यहाँ आकर द्वैत (Duality) हमेशा के लिए मर जाता है; न कोई ध्यान करने वाला बचता है, न कोई चक्र बचता है, केवल और केवल 'शून्यता' बचती है।"
            "जैसे एक पानी की बूँद समंदर में गिरकर खुद समंदर बन जाती है, वैसे ही योगी का 'मैं' (Ego) मरकर साक्षात भगवान बन जाता है।"
            "'तत्र लीनः परं पदं गच्छति'— उस परब्रह्म में पूरी तरह नष्ट (लीन) होने के बाद, वह उस 'परम पद' (The Ultimate Absolute Destination) को प्राप्त कर लेता है।"
            "जहाँ से कोई वापस इंसान बनकर इस धरती के कीचड़ में नहीं गिरता।"
            "यह शरीर के रहते हुए शरीर से बाहर होने का (Out of Body) सबसे नंगा और हिंसक सच है।"
            "यहीं पर इंसान की मौत का हमेशा के लिए कत्ल हो जाता है और अमरता (Immortality) जीत जाती है!"
        """.trimIndent(),
        english = """
            (The Detonation of Sahasrara: Fusion into Brahman and the Slaughter of Death): "When the Kundalini hammers against the absolute crown of the skull (Sahasrara Chakra), the final, greatest 'Big Bang' of human existence detonates!"
            "'Sahasrare yada dhyayet'—When the Yogi meditates on this terrifying thousand-petaled chakra, the literal roof of his brain (Brahmarandhra) physically, violently explodes."
            "His raw consciousness tears through the biological prison of the flesh and is Fired directly into the vacuum of space."
            "'Parabrahmani liyate'—And in a billionth of a microsecond, that human is completely and permanently 'Dissolved/Erased' (Liyate) directly into that infinite, boundless, formless 'Supreme Brahman'!"
            "Arriving here, Duality suffers a brutal, permanent death; no meditator survives, no chakras survive, strictly and exclusively the 'Absolute Void' remains."
            "Exactly as a drop of water crashes into the ocean and mutates into the ocean itself, the Yogi's 'Ego' (I) dies and mutates explicitly into God."
            "'Tatra linah param padam gacchati'—After being completely annihilated (Lina) into that Supreme Brahman, he violently rockets into that 'Param Padam' (The Ultimate Absolute Destination)."
            "From where absolutely no entity ever plummets back to mutate into a pathetic human in the rotting mud of this Earth."
            "This is the most naked, violent, and cold-blooded truth of being totally Out of Body while the biological heart still beats."
            "Right exactly here, Death itself is permanently slaughtered, and absolute Immortality wins the ultimate war!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 20,
        sanskrit = "अष्टमे च सखाचक्रे सर्वशून्यं विचिन्तयेत् । नवमे व्योमचक्रे तु निर्गुणं परचिन्तनम् ॥",
        hindi = """
            (आठवां और नौवां चक्र: परम शून्यता का खौफनाक क्षेत्र): "सहस्रार (सातवें चक्र) के बाद इंसान की कोई सीमा (Limit) नहीं बचती, लेकिन उपनिषद तुम्हें उस डार्क डायमेंशन (Dark Dimension) में धकेलता है जिसे शब्दों में नहीं बताया जा सकता।"
            "'अष्टमे च सखाचक्रे'— शरीर के बाहर अंतरिक्ष में जो आठवाँ 'सखा चक्र' है..."
            "'सर्वशून्यं विचिन्तयेत्'— वहाँ योगी को आदेश है कि वह 'सब कुछ पूरी तरह शून्य (Zero) है', इस खौफनाक और सुन्न कर देने वाले सन्नाटे का ध्यान (विचिन्तयेत्) करे!"
            "यहाँ कोई भगवान का रूप नहीं, कोई प्रकाश नहीं, कोई आवाज़ नहीं; केवल एक एंडलेस (Endless) खालीपन है जो इंसान के अहंकार को घोंट कर मार देता है।"
            "और इसके बाद सबसे खतरनाक और आखिरी पड़ाव आता है: 'नवमे व्योमचक्रे तु' (नौवें व्योम चक्र में)!"
            "यह व्योम (Space/Void) वह जगह है जहाँ से पूरे ब्रह्मांड का सोर्स कोड (Source code) लिखा गया था।"
            "'निर्गुणं परचिन्तनम्'— यहाँ योगी को उस 'निर्गुण' (जिसका कोई गुण, रूप, या नाम न हो) का प्रलयंकारी चिंतन करना होता है।"
            "यहाँ आकर योगी का खुद का वजूद 100% डिलीट (Delete) हो जाता है; वह यूनिवर्स का बैकएंड (Backend) हैक कर चुका है।"
            "जो इस शून्यता से डर गया, वह वापस गिरकर इंसान बन जाता है।"
            "लेकिन जो इस शून्यता में कूद गया, वह हमेशा-हमेशा के लिए साक्षात वह शक्ति बन जाता है जो दुनिया चलाती है!"
        """.trimIndent(),
        english = """
            (The 8th and 9th Chakras: The Terrifying Zone of the Absolute Void): "Beyond the Sahasrara (Seventh Chakra), absolutely zero human limits survive, but the Upanishad violently shoves you into a Dark Dimension that cannot be transcribed into words."
            "'Ashtame cha Sakhachakre'—In the eighth 'Sakha Chakra' suspended in the vacuum of space outside the biological shell..."
            "'Sarvashunyam vichintayet'—The Yogi is given the draconian command to 'Meditate' (Vichintayet) exclusively on the horrific, paralyzing reality that 'Absolutely everything is total Zero (Void)'!"
            "There is no form of God here, zero light, zero acoustic sound; strictly an Endless vacuum that chokes the human ego to a brutal death."
            "And after this arrives the most lethal and absolute final coordinate: 'Navame Vyomachakre tu' (In the Ninth Vyoma Chakra)!"
            "This Vyoma (Absolute Space/Void) is the exact physical coordinate from where the Source Code of the entire cosmos was originally written."
            "'Nirgunam parachintanam'—Here, the Yogi must execute the apocalyptic contemplation of that 'Nirguna' (That which possesses zero attributes, zero form, and zero name)."
            "Arriving here, the Yogi's own existence is 100% permanently Deleted; he has successfully Hacked the absolute Backend of the universe."
            "He who cowers in terror of this Void plummets violently back to mutate into a human."
            "But he who plunges maniacally into this Void permanently mutates into the explicit exact Power that dictates the cosmos!"
        """.trimIndent()
    ),
    SaubhagyaLakshmiShloka(
        id = 21,
        sanskrit = "एवं ध्यात्वा नवचक्रं स मुक्तो भवति । स एव परमो हंसः स एव शिवः ॥",
        hindi = """
            (नौ चक्रों को हैक करने का परिणाम: साक्षात शिव बनना): "नारायण अब इस प्रलयंकारी हैकिंग (Hacking) का सबसे खौफनाक और अंतिम रिज़ल्ट (Result) दुनिया के मुँह पर मारते हैं।"
            "'एवं ध्यात्वा नवचक्रं'— जो कोई भी ब्रह्मांडीय योद्धा (Titan) इस तरह अपने शरीर के इन 'नौ चक्रों' (नवचक्रं) को ध्यान के हथौड़े से तोड़कर हैक कर लेता है..."
            "जिसने अपनी बायोलॉजिकल मशीन (Biological Machine) की एक-एक वायर (Wire) को अपने कंट्रोल में कर लिया है..."
            "'स मुक्तो भवति'— वह इंसान इसी पल, 100% गारंटी के साथ, माया की इस मैट्रिक्स से हमेशा-हमेशा के लिए 'आज़ाद' (मुक्तो) हो जाता है!"
            "उसे दोबारा कभी मौत का मुँह नहीं देखना पड़ता; वह समय (Time) के हर कानून को अपने पैरों तले कुचल देता है।"
            "और वह बनता क्या है? 'स एव परमो हंसः'— वह केवल और केवल साक्षात वह 'परम हंस' (The Supreme Cosmic Swan) बन जाता है, जो असीम और अजेय है!"
            "और सबसे बड़ा धमाका: 'स एव शिवः'— वह खुद ही साक्षात 'शिव' बन जाता है! वह स्वयं ही महाकाल है!"
            "यह कोई पदवी (Title) नहीं है; वह इंसानियत से इवॉल्व (Evolve) होकर 100% भगवान की फ्रीक्वेंसी (Frequency) में अपग्रेड हो चुका है।"
            "यहाँ आकर द्वैत (Duality) की मौत हो जाती है; न कोई भक्त है और न कोई भगवान—केवल एक ही प्रलयंकारी ताक़त है।"
            "नौ चक्रों का यह विज्ञान इंसान के शरीर में छिपा हुआ वो न्यूक्लियर बटन (Nuclear Button) है जो दबाने पर सीधे भगवान पैदा करता है!"
        """.trimIndent(),
        english = """
            (The Consequence of Hacking the Nine Chakras: Mutating into Explicit Shiva): "Narayana now violently slams the most horrific, ultimate Result of this apocalyptic Hacking directly into the face of the world."
            "'Evam dhyatva navachakram'—Whosoever cosmic warrior (Titan) successfully Hacks and shatters these 'Nine Chakras' (Navachakram) of his biological shell using the sledgehammer of meditation..."
            "He who has seized dictatorial control over every single Wire of his Biological Machine..."
            "'Sa mukto bhavati'—That human, in this exact microsecond, with a 100% ironclad guarantee, becomes permanently and irrevocably 'Liberated' (Mukto) from this Matrix of Maya forever!"
            "He absolutely never has to stare into the jaws of Death again; he crushes every single law of Time beneath his boots."
            "And what exactly does he mutate into? 'Sa eva paramo hamsah'—He becomes strictly and exclusively that 'Param Hamsa' (The Supreme Cosmic Swan), infinite and invincible!"
            "And the ultimate atomic detonation: 'Sa eva Shivah'—He himself explicitly mutates into literal 'Shiva'! He himself is Mahakala!"
            "This is absolutely no pathetic Title; he has violently Evolved out of humanity, upgrading 100% into the exact Frequency of God."
            "Arriving here, Duality suffers a brutal death; there is no devotee and no separate God—strictly ONE apocalyptic Force."
            "This science of the nine chakras is the literal Nuclear Button hidden inside the human body that, when detonated, violently breeds God!"
        """.trimIndent()
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaubhagyaLakshmiUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 21
                if (shlokaNumber != null && shlokaNumber in 1..21) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-21)") }, // Updated Label
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
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
            itemsIndexed(saubhagyalakshmiShlokasList) { _, shloka ->
                SaubhagyaLakshmiShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SaubhagyaLakshmiShlokaCard(shloka: SaubhagyaLakshmiShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Shloka ${shloka.id}",
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
            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}