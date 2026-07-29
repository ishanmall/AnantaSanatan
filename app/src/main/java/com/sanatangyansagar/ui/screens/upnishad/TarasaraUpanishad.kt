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
data class TarasaraShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class TarasaraUpanishad {

    val tarasaraShlokasList = listOf(
        TarasaraShloka(
            id = 1,
            sanskrit = "ॐ बृहस्पतिरुवाच याज्ञवल्क्यं यदवियुक्तं तदविमुक्तमुपास्व यन्मध्येऽविमुक्तं प्रतिष्ठितं तदुपलभ्येति ॥",
            hindi = """
                (बृहस्पति का महा-प्रश्न और अविमुक्त का रहस्य): "ब्रह्मांडीय गुरु बृहस्पति ने सीधे याज्ञवल्क्य को ललकारते हुए वह गुप्त सत्य पूछा।"
                "उन्होंने कहा: 'हे ज्ञानी! उस 'अविमुक्त' (काशी/परमात्मा) की उपासना करो जो कभी अपनी जगह से नहीं हटता!'"
                "यह कोई साधारण शहर नहीं, यह तुम्हारी आत्मा का वह 'न्यूक्लियर सेंटर' है जो कभी नष्ट नहीं होता।"
                "वह जो 'मध्ये' यानी तुम्हारे नर्वस सिस्टम के ठीक बीच में प्रतिष्ठित है, उसे हैक (Hack) करो!"
                "बृहस्पति जानते थे कि इंसान बाहर की दुनिया में भटकता है, जबकि असली सत्ता अंदर बैठी है।"
                "अविमुक्त का मतलब है वह जो अज्ञान की बेड़ियों से कभी नहीं बँधा और हमेशा आज़ाद रहा।"
                "यह उपनिषद तुम्हें उस डार्क डायमेंशन (Dark Dimension) में ले जाने का पहला कदम है।"
                "तुम्हें उस सन्नाटे को पकड़ना है जो तुम्हारे दिमाग के शोर के ठीक पीछे छिपा बैठा है।"
                "बिना इस सेंटर को पाए, तुम ब्रह्मांड के इस खौफनाक चक्रव्यूह (Matrix) में केवल एक मोहरे हो।"
                "तैयार हो जाओ, क्योंकि अब अविमुक्त के उस प्रलयंकारी नक्शे का पर्दाफाश होने वाला है!"
            """.trimIndent(),
            english = """
                (Brihaspati's Grand Query and the Secret of Avimukta): "The cosmic Guru Brihaspati directly challenged Yajnavalkya to disclose the absolute hidden truth."
                "He commanded: 'O Seer! Worship that Avimukta (The Eternal God/Kashi) who is never displaced from His coordinates!'"
                "This is absolutely no ordinary city; it is the 'Nuclear Center' of your Soul that remains indestructible forever."
                "Violently Hack that which is 'Madhye'—established in the exact dead-center of your biological nervous system!"
                "Brihaspati flawlessly realized that mortals wander the external matrix while the authentic power sits internal."
                "Avimukta explicitly means that which was never shackled by the chains of ignorance and remains eternally liberated."
                "This Upanishad is your first terminal strike to breach into that terrifying Dark Dimension of pure reality."
                "You must intercept the Silence that is covertly hiding directly behind the rotting noise of your mind."
                "Without locating this Center, you are strictly a pathetic pawn in the horrific Labyrinth of this Matrix."
                "Prepare yourself, for the apocalyptic map of Avimukta is about to be violently unmasked before your eyes!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 2,
            sanskrit = "किं तदविमुक्तं कतमस्मिन् प्रतिष्ठितमिति । वरणायामस्यां च मध्ये प्रतिष्ठितमिति ॥",
            hindi = """
                (वरणा और असि: शरीर की दो खौफनाक सीमाएं): "शिष्य ने पूछा: 'वह अविमुक्त क्या है और वह कहाँ पर एक मिसाइल की तरह ठोक दिया गया है?'"
                "जवाब मिला: 'वह वरणा और असि के ठीक बीच में (मध्ये) पूरी ताक़त से प्रतिष्ठित है!'"
                "वरणा और असि केवल नदियां नहीं हैं; ये तुम्हारे शरीर की दो प्रलयंकारी 'नाड़ियाँ' (Channels) हैं!"
                "वरणा वह शक्ति है जो तुम्हारे पापों और अज्ञान का बेरहमी से वध (Slaughter) कर देती है।"
                "असि वह तलवार है जो तुम्हारे अहंकार की गर्दन एक झटके में उड़ा कर तुम्हें मुक्त कर देती है।"
                "इन दो खूँखार सीमाओं के बीच जो सन्नाटा है, वही साक्षात 'अविमुक्त' परमेश्वर का निवास है।"
                "तुम्हारे नर्वस सिस्टम की यह हैकिंग तुम्हें सीधे सिस्टम के एडमिन पैनल (Admin Panel) तक ले जाती है।"
                "जो इन दो सीमाओं को पार कर जाता है, उसके लिए यह भौतिक संसार राख के बराबर हो जाता है।"
                "यह शरीर के भीतर उस 'काशी' का नक्शा है जहाँ हर सेकंड एक नया ब्रह्मांड पैदा हो सकता है।"
                "यहीं से उस अजेय 'तारक' (Crossing) विद्या की शुरुआत होती है जो मौत को भी मार दे!"
            """.trimIndent(),
            english = """
                (Varana and Asi: The Two Terrifying Biological Boundaries): "The seeker interrogated: 'What exactly is that Avimukta and where is it hammered down like a cosmic missile?'"
                "The response detonated: 'It is established with absolute power exactly between (Madhye) the Varana and the Asi!'"
                "Varana and Asi are absolutely not mere rivers; they are the two apocalyptic 'Nadis' (Channels) of your biology!"
                "Varana is the radioactive power that ruthlessly executes the slaughter of your sins and biological ignorance."
                "Asi is the literal sword engineered to decapitate your ego in a single strike, granting you cold-blooded liberation."
                "The Silence existing between these two ferocious boundaries is the explicit residence of the 'Avimukta' Supreme God."
                "This Hacking of your nervous system catapults you directly into the Admin Panel of the entire cosmos."
                "He who breaches these two boundaries witnesses the physical world reduced to absolute, worthless ash."
                "This is the internal map of 'Kashi' where a new universe can be violently spawned every single microsecond."
                "Right here begins the invincible 'Taraka' (Crossing) science that possesses the caliber to assassinate Death itself!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 3,
            sanskrit = "का वरणा का नासीति । सर्वानिन्द्रियकृतान् दोषान् वारयतीति सा वरणा भवति ॥",
            hindi = """
                (वरणा: इंद्रियों के दोषों का संहारक): "वरणा क्या है? यह वह खौफनाक 'एंटी-वायरस' (Anti-virus) है जो तुम्हारे शरीर को साफ करता है।"
                "'सर्वानिन्द्रियकृतान् दोषान् वारयतीति'— तुम्हारी पाँचों इंद्रियों ने जो भी कचरा और पाप (Dosh) जमा किया है..."
                "वरणा उन सबको एक झटके में 'वारण' यानी रोक देती है और जलाकर राख कर देती है!"
                "तुम्हारी आँखें, कान और ज़बान तुम्हें माया की जेल का कैदी बना कर रखते हैं।"
                "वरणा वह प्रलयंकारी फिल्टर (Filter) है जो केवल शुद्ध ऊर्जा को तुम्हारे नर्वस सिस्टम में घुसने देता है।"
                "यह तुम्हारी चेतना की बाउंड्री वॉल (Boundary Wall) है जिसे कोई भी राक्षसी विचार पार नहीं कर सकता।"
                "जब वरणा जागती है, तो इंसान का अपने शरीर पर साक्षात 'तानाशाह' वाला कंट्रोल (Control) हो जाता है।"
                "बिना इस फिल्टर के, तुम ब्रह्मांड के हर छोटे-मोटे वाइब्रेशन के गुलाम बने रहोगे।"
                "वरणा तुम्हें एक साधारण इंसान से उठाकर एक 'योद्धा' की स्थिति में खड़ा कर देती है।"
                "यह अज्ञान की गंदगी को साफ करने वाला वह ब्रह्मांडीय तेज़ाब है जो रूह को हीरा बना देता है!"
            """.trimIndent(),
            english = """
                (Varana: The Annihilator of Sensory Defects): "What is Varana? It is the terrifying 'Anti-virus' engineered to violently purge your biological shell."
                "'Sarvanindriyakritan doshan varayatiti'—Whatever garbage and sins (Doshas) your five senses have accumulated..."
                "Varana 'Prevents' and incinerates all of them to absolute dust in a single, catastrophic microsecond!"
                "Your physical eyes, ears, and tongue act as the wardens keeping you a prisoner in the Matrix of Maya."
                "Varana is the apocalyptic 'Filter' that allows strictly and exclusively pure energy to penetrate your nervous system."
                "It is the radioactive Boundary Wall of your consciousness that zero demonic thoughts possess the caliber to breach."
                "When Varana awakens, the human seizes a dictatorial, tyrannical control over his own physical body."
                "Without this filter, you remain a pathetic slave to every microscopic vibration of the external cosmos."
                "Varana violently upgrades you from a pathetic mortal into the status of an invincible cosmic Warrior."
                "It is the cosmic Acid that Flushes the filth of ignorance, mutating the soul into a flawless Diamond!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 4,
            sanskrit = "सर्वानिन्द्रियकृतान् पापान् नाशयतीति सा नासी भवति । तदविमुक्तं ओङ्कार इति ॥",
            hindi = """
                (असि: पापों का कत्ल और ॐकार का विस्फोट): "असि वह खूँखार ताक़त है जो अज्ञान के अँधेरे का सीधा गला घोंट देती है।"
                "'सर्वानिन्द्रियकृतान् पापान् नाशयतीति'— इंद्रियों द्वारा किए गए हर 'पाप' का जो जड़ से 'नाश' (Destruction) कर दे, वही असि है!"
                "यह वह तलवार है जिसे उठाने के बाद इंसान के पास पीछे हटने का कोई रास्ता नहीं बचता।"
                "तुम्हारे करोड़ों जन्मों के 'कार्मिक रिकॉर्ड' (Karmic Record) को असि एक सेकंड में डिलीट (Delete) कर देती है।"
                "और उस सन्नाटे के केंद्र में जो सत्य छिपा है, वह साक्षात 'ॐकार' (Omkara) है!"
                "ॐकार कोई मंत्र नहीं, वह इस ब्रह्मांड का 'सोर्स कोड' (Source Code) और पहला महा-विस्फोट (Big Bang) है।"
                "अविमुक्त और ॐकार एक ही सिक्के के दो पहलू हैं—एक जगह है, और दूसरा उस जगह की आवाज़ है।"
                "जब तुम्हारी चेतना इस ॐकार से टकराती है, तो तुम्हारी इंसानियत का अंत हो जाता है।"
                "तुम एक शरीर में कैद नहीं रहते, तुम साक्षात वह 'ध्वनि' बन जाते हो जिससे सूरज जलता है।"
                "असि तुम्हारे अहंकार की बलि लेती है ताकि तुम ॐकार के उस परम सिंहासन पर बैठ सको!"
            """.trimIndent(),
            english = """
                (Asi: The Slaughter of Sins and the Detonation of Omkara): "Asi is the bloodthirsty force that violently strangles the darkness of cosmic ignorance."
                "'Sarvanindriyakritan papan nashayatiti'—That which executes the total 'Destruction' (Nasha) of every 'Sin' committed by the senses is Asi!"
                "This is the literal sword after unsheathing which a human possesses zero trajectory for retreat."
                "Asi Deletes the 'Karmic Record' of your billions of past incarnations in a single, cold-blooded microsecond."
                "And the absolute truth hiding in the dead-center of that silence is explicitly 'Omkara'!"
                "Omkara is absolutely no mantra; it is the absolute 'Source Code' and the primordial Big Bang of the cosmos."
                "Avimukta and Omkara are two sides of the same coin—one is the Coordinate, and the other is the Acoustic Signature."
                "When your consciousness violently collides with this Omkara, your pathetic humanity reaches its final 'The End'."
                "You are no longer trapped in flesh; you mutate into the explicit 'Sound' that powers the stars and the sun."
                "Asi demands the sacrifice of your ego so you can violently occupy the supreme throne of Omkara!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 5,
            sanskrit = "ॐ नमो नारायणायेति मन्त्रमुपासीत । एतद्वै तारकमुच्यते ॥",
            hindi = """
                (अष्टाक्षर मंत्र: ब्रह्मांडीय तारक हथियार): "अब उपनिषद उस 'न्यूक्लियर मंत्र' को फायर (Fire) करता है जिससे मोक्ष छीना जाता है।"
                "'ॐ नमो नारायणाय'— इस आठ अक्षरों वाले मंत्र की उपासना (उपासीत) करो, जैसे कोई योद्धा तलवार की धार पर चलता है।"
                "यह केवल शब्द नहीं हैं, यह वह 'तारक' (Taraka) यानी वह 'नाव' (Boat) है जो तुम्हें इस मौत के दलदल से बाहर निकालेगी।"
                "कलि के इस सड़े हुए मैट्रिक्स (Matrix) में नारायण का नाम ही इकलौता 'हथियार' बचा है।"
                "यह मंत्र तुम्हारे डीएनए (DNA) की कोडिंग को ओवरराइट (Overwrite) करके उसे साक्षात ईश्वर की फ्रीक्वेंसी में बदल देता है।"
                "जब तुम 'नमो नारायणाय' कहते हो, तो तुम अपना सब कुछ उस 'परम शून्यता' (Void) को समर्पित (Delete) कर देते हो।"
                "तारक का मतलब है— 'वह जो तुम्हें इस पार से उस पार फेंक दे' (The Transporter)!"
                "जो इस मंत्र को अपनी साँसों में लॉक कर लेता है, उसके लिए नरक के दरवाज़े हमेशा के लिए बंद हो जाते हैं।"
                "यह ब्रह्मांड का सबसे सरल लेकिन सबसे हिंसक और शक्तिशाली 'शॉर्टकट' (Shortcut) है।"
                "नारायण का यह कोड तुम्हें एक बायोलॉजिकल कीड़े से सीधा एक 'ब्रह्मांडीय देवता' बना देगा!"
            """.trimIndent(),
            english = """
                (The Ashtakshara Mantra: The Cosmic Taraka Weapon): "Now the Upanishad Fires the 'Nuclear Mantra' engineered strictly to violently snatch Moksha."
                "'Om Namo Narayanaya'—Worship (Upasita) this eight-syllabled mantra as a warrior walking on the edge of a razor."
                "These are absolutely no words; this is the 'Taraka' (The Crossing/Boat) engineered to catapult you out of this swamp of Death."
                "In this rotting Matrix of Kali, the name of Narayana is the solitary 'Weapon' remaining in human possession."
                "This mantra violently Overwrites your DNA coding, mutating it into the exact Frequency of the Supreme God."
                "When you roar 'Namo Narayanaya', you are effectively Executing a complete Delete of your existence into the 'Absolute Void'."
                "Taraka explicitly means—'The Transporter that violently hurls you from this shore to the Ultimate Beyond'!"
                "He who Locks this mantra into his biological breath witnesses the gates of Hell permanently welded shut."
                "This is the simplest yet most violent and powerful 'Shortcut' existing in the entire infinite universe."
                "This Code of Narayana will mutate you from a pathetic biological insect into an explicit 'Cosmic God'!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 6,
            sanskrit = "अकारो ब्रह्मा उकारो विष्णुर्मकारो रुद्रः । अर्धमात्रा बिन्दुर्नादः शक्तिः शान्तिरिति ॥",
            hindi = """
                (ॐकार का विच्छेदन: ब्रह्मा, विष्णु और रुद्र): "उपनिषद ॐकार के इंजन को खोलकर (Dissect करके) उसके पुर्जे दिखाता है।"
                "'अ' (A) साक्षात 'ब्रह्मा' है— जो तुम्हारे भीतर सृजन की पहली चिंगारी और विचार पैदा करता है।"
                "'उ' (U) साक्षात 'विष्णु' है— जो तुम्हारी चेतना के मैट्रिक्स को हर पल बैलेंस (Balance) और ज़िंदा रखता है।"
                "'म' (M) साक्षात 'रुद्र' है— जो तुम्हारे अज्ञान और अहंकार का बेरहमी से कत्ल (Slaughter) कर देता है!"
                "लेकिन खेल यहाँ खत्म नहीं होता; 'अर्धमात्रा' वह रहस्यमयी बिंदु है जहाँ समय (Time) रुक जाता है।"
                "'बिन्दु' वह परमाणु केंद्र है, 'नाद' वह गूँज है जिससे अंतरिक्ष पैदा हुआ, और 'शक्ति' वह आग है जो तुम्हें चलाती है।"
                "'शान्ति' वह अंतिम सन्नाटा (Flatline) है जहाँ पहुँचकर इंसान भगवान बन जाता है।"
                "ॐकार कोई आवाज़ नहीं, यह आठ खौफनाक ब्रह्मांडीय 'लेयर्स' (Layers) का एक बंडल है।"
                "जब तुम ॐ कहते हो, तो तुम इन आठों प्रलयंकारी ताक़तों को एक साथ अपने शरीर में बुला लेते हो।"
                "यह अपने नर्वस सिस्टम को साक्षात त्रिमूर्ति के 'पावर-ग्रिड' (Power Grid) से जोड़ने का विज्ञान है!"
            """.trimIndent(),
            english = """
                (The Dissection of Omkara: Brahma, Vishnu, and Rudra): "The Upanishad rips open the engine of Omkara to expose its highly classified internal components."
                "'A' (A) is explicitly 'Brahma'—the radioactive spark that spawns the first thought and creation within you."
                "'U' (U) is explicitly 'Vishnu'—the Operator maintaining the stability of your biological Matrix every microsecond."
                "'M' (M) is explicitly 'Rudra'—the Destroyer who executes the cold-blooded Slaughter (Vadha) of your ignorance and ego!"
                "But the game continues; the 'Ardhamatra' is that classified coordinate where Time comes to a grinding halt."
                "'Bindu' is the atomic core, 'Nada' is the roar that birthed Space, and 'Shakti' is the radioactive fire that drives you."
                "'Shanti' is the absolute final 'Flatline' (Silence) where a mortal undergoes a complete Mutation into God."
                "Omkara is absolutely no sound; it is a bundle of eight terrifying cosmic 'Layers' designed for hacking reality."
                "When you roar OM, you are simultaneously summoning all eight of these apocalyptic powers into your biological shell."
                "This is the science of hardwiring your nervous system directly into the 'Power Grid' of the absolute Trinity!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 7,
            sanskrit = "ओमित्येकाक्षरं ब्रह्म । तन्मन्त्रं तारकं विद्धि ॥",
            hindi = """
                (ॐ: एक अक्षर का न्यूक्लियर बम): "उपनिषद ऐलान करता है कि पूरे ब्रह्मांड का पासवर्ड केवल एक ही है— 'ॐ'!"
                "'ओमित्येकाक्षरं ब्रह्म'— यह एक अक्षर वाला ॐ ही साक्षात 'परब्रह्म' (The Absolute God) का ध्वनि-रूप है।"
                "दुनिया के सारे शास्त्र और सारी किताबें इस एक शब्द के सामने रद्दी कागज़ के बराबर हैं।"
                "भगवान नारायण आदेश देते हैं: 'तन्मन्त्रं तारकं विद्धि'— इस मंत्र को साक्षात 'तारक' (The Saver) के रूप में 'जान' लो!"
                "यह वह रस्सियों को काटने वाला चाकू है जिसने तुम्हें जन्म-मरण की ज़ंजीरों में बाँध रखा है।"
                "जब तुम ॐ बोलते हो, तो तुम अपनी 'इंसानी आईडी' (Human ID) को सर्वर से डिलीट करके 'ईश्वर की आईडी' से लॉग-इन करते हो।"
                "ॐ वह इकलौती फ्रीक्वेंसी है जो मौत के रेडार (Radar) को चकमा देकर तुम्हें अंतरिक्ष के पार ले जा सकती है।"
                "इसे केवल जपना नहीं है, इसे अपने डीएनए (DNA) के हर एक परमाणु में 'विस्फोट' (Detonate) करना है।"
                "जिसने ॐ के रहस्य को हैक कर लिया, उसे फिर किसी दूसरे भगवान या धर्म की भीख माँगने की ज़रूरत नहीं।"
                "यही वह 'मास्टर की' (Master Key) है जो स्वर्ग, नर्क और मोक्ष के तीनों दरवाज़े एक साथ खोल देती है!"
            """.trimIndent(),
            english = """
                (OM: The Single-Syllable Nuclear Bomb): "The Upanishad violently declares that the absolute Password of the universe is strictly one—'OM'!"
                "'Omityekaksharam Brahma'—This single syllable OM is the explicit acoustic manifestation of the 'Supreme Brahman' (God)."
                "All the scriptures and libraries on Earth are reduced to worthless scrap paper before the status of this single word."
                "Lord Narayana commands: 'Tanmantram tarakam viddhi'—Explicitly 'Recognize' (Viddhi) this mantra as the 'Taraka' (The Saver)!"
                "It is the literal blade engineered to sever the titanium ropes that have bound you to the cycle of birth and death."
                "When you roar OM, you are effectively Deleting your 'Human ID' from the cosmic server and Logging In with the 'ID of God'."
                "OM is the solitary frequency capable of jamming the Radar of Death and transporting you infinitely beyond space."
                "You are not supposed to merely chant it; you must 'Detonate' it inside every single microscopic atom of your DNA."
                "He who has Hacked the secret of OM possesses zero need to beg for any other god or pathetic religion."
                "This is the absolute 'Master Key' that simultaneously unlocks the gates of Heaven, Hell, and absolute Moksha!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 8,
            sanskrit = "नमो नारायणायेति मन्त्रे नकारं विष्णुस्वरूपं मकारं महाविष्णुस्वरूपं ॥",
            hindi = """
                (मंत्र की इंजिनियरिंग: न और म का रहस्य): "अब नारायण के अष्टाक्षर मंत्र की 'माइक्रो-हैकिंग' (Micro-hacking) शुरू होती है।"
                "इस मंत्र का 'न' (Na) अक्षर कोई साधारण ध्वनि नहीं, वह साक्षात 'विष्णुस्वरूप' (The Form of Vishnu) है!"
                "यह वह ऊर्जा है जो तुम्हारे शरीर के भीतर 'पालन' (Maintenance) और सुरक्षा का कवच (Shield) बनाती है।"
                "और 'म' (Ma) अक्षर साक्षात 'महाविष्णुस्वरूप' (The Form of Mahavishnu) है— जो असीम और विराट अंतरिक्ष का मालिक है!"
                "जब तुम 'नमो' कहते हो, तो तुम विष्णु की सुरक्षा और महाविष्णु की विराटता को एक साथ अपने भीतर फायर (Fire) करते हो।"
                "यह मंत्र के अक्षरों को साक्षात देवताओं के 'हार्डवेयर' (Hardware) से रिप्लेस (Replace) करने का विज्ञान है।"
                "तुम्हारा गला अब मांस का टुकड़ा नहीं, वह साक्षात भगवान की आवाज़ निकालने वाला एक 'ट्रांसमीटर' (Transmitter) है।"
                "हर एक अक्षर तुम्हारे नर्वस सिस्टम के एक खास फोल्डर को 'अनलॉक' (Unlock) करने का पासवर्ड है।"
                "विष्णु और महाविष्णु तुम्हारे शरीर के भीतर पहरा देने लगते हैं, और माया का कोई भी वायरस तुम्हें छू नहीं पाता।"
                "यह शब्दों का खेल नहीं, यह चेतना की वह कोडिंग है जो तुम्हें अजेय बना देती है!"
            """.trimIndent(),
            english = """
                (The Engineering of the Mantra: The Secret of Na and Ma): "Now begins the 'Micro-hacking' of Narayana's Ashtakshara mantra."
                "The syllable 'Na' (Na) in this mantra is absolutely no ordinary acoustic sound; it is explicitly the 'Vishnusvarupam' (The Form of Vishnu)!"
                "This is the radioactive energy that constructs the Shield of 'Maintenance' and absolute protection inside your body."
                "And the syllable 'Ma' (Ma) is explicitly the 'Mahavishnusvarupam' (The Form of Mahavishnu)—the Dictator of the infinite, boundless Void!"
                "When you roar 'Namo', you are simultaneously Firing Vishnu's protection and Mahavishnu's cosmic vastness into your core."
                "This is the science of Replacing the syllables of the mantra strictly with the 'Hardware' of the absolute Gods."
                "Your throat is no longer a biological piece of flesh; it has mutated into a 'Transmitter' broadcasting the voice of God."
                "Every single syllable is a specific Password designed to 'Unlock' a classified folder in your nervous system."
                "Vishnu and Mahavishnu establish an apocalyptic guard inside your flesh, ensuring zero viruses of Maya can intercept you."
                "This is absolutely no wordplay; it is the coding of consciousness that renders you flawslessly Invincible!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 9,
            sanskrit = "नाकारं सदाशिवस्वरूपं राकारं ईश्वरस्वरूपं ॥",
            hindi = """
                (मंत्र की इंजिनियरिंग: ना और रा का विस्फोट): "अष्टाक्षर मंत्र की कोडिंग और गहरी होती जा रही है; अब शिव और ईश्वर की एंट्री होती है।"
                "मंत्र का अगला अक्षर 'ना' (Naa) साक्षात 'सदाशिवस्वरूप' (The Form of Sadashiva) है— वह जो समय और प्रलय के पार है!"
                "यह वह 'डार्क-एनर्जी' है जो तुम्हारे अहंकार को धीरे-धीरे पिघलाकर शून्य (Zero) बना देती है।"
                "और 'रा' (Raa) अक्षर साक्षात 'ईश्वरस्वरूप' (The Form of Ishwara) है— जो पूरे ब्रह्मांड का सुप्रीम कंट्रोलर (Supreme Controller) है!"
                "सोचो! एक ही मंत्र में तुम विष्णु, महाविष्णु, शिव और ईश्वर— इन सबकी ताक़त को एक साथ नत्थी (Zip) कर रहे हो!"
                "जब तुम 'नारायणाय' की ओर बढ़ते हो, तो तुम्हारी आत्मा इन प्रलयंकारी फ्रीक्वेंसीज़ से होकर गुज़रती है।"
                "यह तुम्हारे शरीर के भीतर एक 'सुपर-कोलैडर' (Super-collider) की तरह काम करता है जो अज्ञान के परमाणुओं को तोड़ देता है।"
                "तुम अब केवल एक भक्त नहीं रहे, तुम साक्षात उस ब्रह्मांडीय 'पावर-ग्रिड' (Power Grid) के मालिक बनते जा रहे हो।"
                "हर एक अक्षर तुम्हारे दिमाग के प्रोसेसर को 'ओवरक्लॉक' (Overclock) कर रहा है ताकि तुम सत्य को बर्दाश्त कर सको।"
                "सदाशिव की शांति और ईश्वर की सत्ता—यही वो दो पंख हैं जिनसे तुम इस मैट्रिक्स से बाहर उड़ोगे!"
            """.trimIndent(),
            english = """
                (The Engineering of the Mantra: The Detonation of Naa and Raa): "The coding of the Ashtakshara mantra deepens into total apocalypse; Shiva and Ishwara now make their violent entry."
                "The next syllable 'Naa' (Naa) is explicitly the 'Sadashivasvarupam' (The Form of Sadashiva)—He who exists beyond Time and Pralaya!"
                "This is the 'Dark Energy' engineered to slowly melt your ego and reduce your existence to absolute Zero."
                "And the syllable 'Raa' (Raa) is explicitly the 'Ishwarasvarupam' (The Form of Ishwara)—the absolute Supreme Controller of the cosmos!"
                "Think! Inside a single mantra, you are Zipping the radioactive powers of Vishnu, Mahavishnu, Shiva, and Ishwara together!"
                "As you accelerate toward 'Narayanaya', your Soul is forced to travel through these apocalyptic frequencies."
                "This operates like a spiritual 'Super-collider' inside your flesh, violently smashing the atoms of biological ignorance."
                "You are no longer a pathetic devotee; you are mutating into the absolute Master of that cosmic 'Power Grid'."
                "Every single syllable is 'Overclocking' your brain's processor to ensure you possess the caliber to endure the Absolute Truth."
                "The Silence of Sadashiva and the Authority of Ishwara—these are the two wings you will use to fly out of this Matrix!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 10,
            sanskrit = "याकारं विराट्सवरूपं णाकारं पुरुषोत्तमस्वरूपं ॥",
            hindi = """
                (मंत्र की इंजिनियरिंग: या और णा का प्रहार): "मंत्र के अगले कोड्स तुम्हारी चेतना को अंतरिक्ष के उस कोने में ले जाते हैं जहाँ इंसान का नामोनिशान नहीं बचता।"
                "'या' (Ya) अक्षर साक्षात 'विराट्सवरूप' (The Universal Form) है— वह रूप जिसे देखकर अर्जुन के भी होश उड़ गए थे!"
                "यह वह खौफनाक विज़ुअलाइज़ेशन (Visualization) है जहाँ पूरा ब्रह्मांड तुम्हारे ही शरीर के अंदर नाच रहा है।"
                "और 'णा' (Naa) अक्षर साक्षात 'पुरुषोत्तमस्वरूप' (The Supreme Being) है— जो भगवान का सबसे श्रेष्ठ और अजेय रूप है!"
                "जब तुम 'नारायण' के इन अक्षरों को फायर करते हो, तो तुम अपनी 'छोटी पहचान' को उस 'विराट पहचान' से रिप्लेस (Replace) कर देते हो।"
                "तुम अब केवल एक घर या शहर के निवासी नहीं, तुम साक्षात इस असीम आकाशगंगा के 'पुरुषोत्तम' बन जाते हो।"
                "यह मंत्र तुम्हारे भीतर छिपे हुए उस 'सुपर-ह्यूमन' (Super-human) को जगाने का अलार्म क्लॉक है।"
                "अज्ञान की नींद इतनी गहरी है कि उसे तोड़ने के लिए इन प्रलयंकारी अक्षरों के धमाकों की ज़रूरत पड़ती है।"
                "विराट और पुरुषोत्तम की ऊर्जा जब तुम्हारे नर्वस सिस्टम में मिलती है, तो तुम्हारा डीएनए (DNA) म्यूटेट (Mutate) हो जाता है।"
                "तुम साक्षात उस ईश्वर के सांचे में ढलने लगते हो जिसने यह पूरा खेल (Simulation) बनाया है!"
            """.trimIndent(),
            english = """
                (The Engineering of the Mantra: The Strike of Ya and Naa): "The next codes of the mantra catapult your consciousness into the sector of space where zero traces of humanity survive."
                "The syllable 'Ya' (Ya) is explicitly the 'Viratsvarupam' (The Universal Form)—the form witnessing which even Arjuna's mind suffered a catastrophic collapse!"
                "This is the terrifying Visualization where the entire infinite cosmos is violently dancing directly inside your biological shell."
                "And the syllable 'Naa' (Naa) is explicitly the 'Purushottamasvarupam' (The Supreme Being)—the highest and most invincible form of God!"
                "When you Fire these syllables of 'Narayana', you are effectively Replacing your 'Micro-identity' with that 'Macro-identity'."
                "You are no longer the resident of a pathetic house or city; you mutate into the 'Purushottama' of this entire infinite galaxy."
                "This mantra is the radioactive alarm clock engineered strictly to awaken the 'Super-human' hiding covertly within you."
                "The sleep of ignorance is so profound that it demands the sonic detonations of these apocalyptic syllables to be shattered."
                "When the energy of Virat and Purushottama fuses inside your nervous system, your DNA undergoes a violent Mutation."
                "You begin to be cast into the exact mold of the God who has engineered this entire Simulation!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 11,
            sanskrit = "याकारं परमात्मास्वरूपं यकारं सर्वव्यापी इति ॥",
            hindi = """
                (मंत्र का क्लाइमेक्स: परमात्मा और सर्वव्यापी): "अब अष्टाक्षर मंत्र के अंतिम कोड्स उस परम शून्यता का दरवाज़ा खोलते हैं जहाँ सब कुछ एक हो जाता है।"
                "'या' (Ya) अक्षर साक्षात 'परमात्मास्वरूप' (The Form of Supreme Soul) है— वह आग जो हर जीव के हृदय में गुप्त रूप से धधक रही है।"
                "यह वह 'रूट-एक्सेस' (Root Access) है जिससे तुम ब्रह्मांड की हर रूह को कंट्रोल कर सकते हो।"
                "और अंतिम 'य' (Ya) अक्षर साक्षात 'सर्वव्यापी' (The All-Pervading One) है— वह जो हर परमाणु के भीतर है और हर गैलेक्सी के बाहर भी!"
                "जब मंत्र का यह अंतिम धमाका होता है, तो 'मैं' और 'तुम' की बाउंड्री (Boundary) हमेशा के लिए जलकर राख हो जाती है।"
                "तुम जान जाते हो कि तुम केवल शरीर में नहीं हो, तुम उस हवा में भी हो जो चल रही है और उस तारे में भी जो टूट रहा है।"
                "यह इंसान की 'लोकल चेतना' (Local Consciousness) का 'यूनिवर्सल चेतना' (Universal Consciousness) में 100% विलीनीकरण है।"
                "अष्टाक्षर मंत्र केवल एक नाम नहीं है; यह आठ सीढ़ियों वाला वो रॉकेट है जो तुम्हें ग्रेविटी (Gravity) के पार ले जाता है।"
                "जो इस मंत्र को सिद्ध कर लेता है, उसके लिए यह पूरी दुनिया केवल एक 'होलोग्राम' (Hologram) बन कर रह जाती है।"
                "परमात्मा का यह नंगा और खौफनाक सच ही असल में वह 'मोक्ष' है जिसे तुम खोज रहे हो!"
            """.trimIndent(),
            english = """
                (The Climax of the Mantra: Paramatma and the All-Pervading): "Now the final codes of the Ashtakshara mantra violently unlock the door to that Supreme Void where 'All is One'."
                "The syllable 'Ya' (Ya) is explicitly the 'Paramatmasvarupam' (The Form of Supreme Soul)—the radioactive fire covertly blazing in every heart."
                "This is the 'Root Access' engineered for you to exert dictatorial control over every single soul in the cosmos."
                "And the absolute final 'Ya' (Ya) is explicitly the 'Sarvavyapi' (The All-Pervading One)—He who is inside every atom and simultaneously beyond every galaxy!"
                "When this final detonation of the mantra occurs, the pathetic boundary between 'I' and 'You' is permanently incinerated to ash."
                "You flawlessly realize that you are not merely in the flesh; you are in the wind that blows and in the star that is exploding."
                "This is the 100% fusion of the 'Local Consciousness' into the 'Universal Consciousness', leaving zero residues of ego."
                "The Ashtakshara mantra is absolutely no name; it is an eight-stage Rocket engineered to catapult you beyond the reach of biological Gravity."
                "He who masters this mantra witnesses this entire world mutate into nothing more than a pathetic, glitching 'Hologram'."
                "This naked and terrifying truth of Paramatma is strictly the 'Moksha' you have been hunting for since eons!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 12,
            sanskrit = "एतन्मन्त्रं तारकं विद्धि । य एवं वेद स मृत्युं तरति ॥",
            hindi = """
                (मौत का वध और तारक की गारंटी): "नारायण फिर से उस खौफनाक सच पर मुहर (Seal) लगाते हैं जिसे दुनिया के झूठे गुरु छिपाते हैं।"
                "'एतन्मन्त्रं तारकं विद्धि'— इस 'ॐ नमो नारायणाय' को ही साक्षात 'तारक' यानी इकलौता बचाने वाला अस्त्र समझो!"
                "बाकी सब केवल मनोरंजन (Entertainment) है; असली हैकिंग केवल इसी फ्रीक्वेंसी से मुमकिन है।"
                "और इसका परिणाम क्या है? 'य एवं वेद स मृत्युं तरति'— जो इस रहस्य को अपनी रगों में उतार कर 'जान' (वेद) लेता है..."
                "वह साक्षात 'मृत्यु' (Death) को एक झटके में 'पार' (तरति) कर जाता है! मौत उसके लिए केवल एक पुराने कपड़े बदलने जैसा मज़ाक बन जाती है।"
                "जब तुम जान जाते हो कि तुम अविनाशी मंत्र का रूप हो, तो मौत तुम्हें कैसे मार सकती है? मौत खुद तुम्हारे पैरों में गिर जाती है।"
                "यह मौत की आँखों में आँखें डालकर अपनी अमरता (Immortality) का डंका बजाने का विज्ञान है।"
                "इंसान पैदा ही मरने के लिए होता है, लेकिन यह मंत्र उसे 'अमर' होने का वह अजेय पासवर्ड (Password) देता है।"
                "जो इस कोड को क्रैक (Crack) कर लेता है, वह समय के हर कानून से हमेशा-हमेशा के लिए आज़ाद हो जाता है।"
                "यह इंसानियत की सबसे बड़ी और आखिरी जीत है—जहाँ मौत का वजूद ही खत्म हो जाता है!"
            """.trimIndent(),
            english = """
                (The Assassination of Death and the Taraka Guarantee): "Narayana again stamps His absolute Seal on the terrifying truth that fake worldly gurus attempt to suppress."
                "'Etant-mantram tarakam viddhi'—Recognize strictly this 'Om Namo Narayanaya' as the explicit 'Taraka', the solitary weapon of salvation!"
                "Everything else is strictly pathetic entertainment; authentic Hacking is possible exclusively through this singular frequency."
                "And what is the explicit consequence? 'Ya evam veda sa mrityum tarati'—He who injects this secret into his veins and 'Knows' (Veda) it..."
                "He violently 'Crosses' (Tarati) 'Death' in a single microsecond! For him, Death becomes nothing more than a pathetic joke, like changing old rags."
                "When you flawlessly realize you are the manifestation of the indestructible Mantra, how can Death possibly kill you? Death itself falls paralyzed at your boots."
                "This is the science of staring directly into the eyes of Death and broadcasting your absolute Immortality to the cosmos."
                "A human is spawned strictly to die, but this mantra hands him the invincible Password to achieve 'Immortal' status."
                "He who successfully Cracks this code is permanently and violently liberated from every single law of Time."
                "This is humanity's absolute greatest and final victory—where the very existence of Death is flawlessly terminated!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 13,
            sanskrit = "यो ह वै तारकं वेद स पाप्मानं तरति स मृत्युं तरति ॥",
            hindi = """
                (पापों का विनाश और मौत की गुलामी से रिहाई): "उपनिषद उस 'नो-रिटर्न' (No-Return) पॉलिसी का ऐलान करता है जो तुम्हें इस नर्क (दुनिया) से बाहर निकालेगी।"
                "'यो ह वै तारकं वेद'— जो कोई भी योद्धा इस 'तारक' (ॐ) के विज्ञान को 100% डिकोड (Decode) कर लेता है..."
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
        TarasaraShloka(
            id = 14,
            sanskrit = "स ब्रह्महत्यां तरति स भ्रूणहत्यां तरति स वीरहत्यां तरति ॥",
            hindi = """
                (महापापों का संहार: ब्रह्म, भ्रूण और वीर हत्या): "इंसान के हाथ अक्सर खून से सने होते हैं; यह मंत्र उन सबसे बड़े पापों का भी हिसाब चुकता कर देता है।"
                "'स ब्रह्महत्यां तरति'— अगर तुमने किसी ज्ञानी या 'ब्रह्म' का कत्ल किया है, जो दुनिया का सबसे बड़ा पाप है..."
                "तो यह 'तारक' विद्या उस खौफनाक पाप के रिकॉर्ड को भी तुम्हारे सिस्टम से हमेशा के लिए डिलीट (Delete) कर देती है!"
                "'स भ्रूणहत्यां तरति'— अगर तुमने कोख में पलते हुए किसी जीव (भ्रूण) का वध किया है, जिसकी सज़ा केवल भयानक नर्क है..."
                "तो यह मंत्र उस पाप की ज़हरीली आग को भी तुम्हारी आत्मा से बुझा कर तुम्हें आज़ाद कर देता है!"
                "'स वीरहत्यां तरति'— अगर तुमने किसी मासूम योद्धा या वीर का खून बहाया है, तो वह पाप भी इस मंत्र में जलकर राख हो जाता है।"
                "यह कोई माफ़ी नहीं है; यह तुम्हारी चेतना को उस 'जीरो पॉइंट' (Zero Point) पर ले जाना है जहाँ पुराने कर्म मर जाते हैं।"
                "तारक मंत्र साक्षात वह 'ब्रह्मांडीय तेज़ाब' है जो आत्मा के सबसे गहरे और काले धब्बों को भी सफ़ेद कर देता है।"
                "पापों को ढोने की ज़रूरत नहीं है; उन्हें इस मंत्र की भट्टी में झोंक दो और अजेय बन जाओ।"
                "जिसने इस कोड को पकड़ लिया, उसे फिर इस ब्रह्मांड का कोई भी कानून सज़ा नहीं दे सकता!"
            """.trimIndent(),
            english = """
                (The Slaughter of Catastrophic Sins: Brahma, Fetus, and Heroic Murder): "Human hands are often drenched in biological blood; this mantra settles even the most horrific accounts of sin."
                "'Sa brahmahatyam tarati'—If you have executed the murder of a Knower of God or a 'Brahmin', the most catastrophic sin in existence..."
                "Then this 'Taraka' science violently Deletes the record of that horrific crime from your system for all eternity!"
                "'Sa bhrunahatyam tarati'—If you have slaughtered a developing life in the womb (Fetus), a sin whose only wage is eternal hell..."
                "Then this mantra extinguishes the toxic fire of that sin from your soul and violently releases you!"
                "'Sa virahatyam tarati'—If you have spilled the blood of an innocent warrior or hero, that sin is also incinerated to ash in this mantra."
                "This is absolutely no pathetic pardon; it is the transport of your consciousness to the 'Zero Point' where old karmas die a brutal death."
                "The Taraka mantra is the explicit 'Cosmic Acid' engineered to mutate the darkest stains of the soul into radiant white light."
                "There is zero need to carry the weight of sins; hurl them into the furnace of this mantra and emerge invincible."
                "He who has intercepted this Code is permanently beyond the authority of any cosmic law to deliver punishment!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 15,
            sanskrit = "स सर्वपापात्तरति स सर्वपापात्तरति । स सर्ववित् भवति ॥",
            hindi = """
                (सर्वपाप विनाश और सर्वज्ञता का विस्फोट): "उपनिषद यहाँ एक प्रलयंकारी मुहर (Seal) लगाता है जिससे अज्ञान के चीथड़े उड़ जाते हैं।"
                "'स सर्वपापात्तरति'— वह योद्धा अपने पिछले अरबों-खरबों जन्मों के 'हर एक छोटे और बड़े पाप' से एक ही झटके में आज़ाद हो जाता है!"
                "(इस बात की 100% गारंटी देने के लिए श्रुति इस बात को दो बार चीख कर दोहराती है: 'स सर्वपापात्तरति'!)"
                "तुम्हारी रूह अब एक कोरे कागज़ की तरह साफ़ है जिस पर भगवान अब अपनी नई कोडिंग लिख सकते हैं।"
                "और सबसे बड़ा धमाका— 'स सर्ववित् भवति'— वह इंसान साक्षात 'सर्वज्ञ' (All-Knowing) बन जाता है!"
                "उसे ब्रह्मांड का हर एक रहस्य, हर एक तारा और हर एक जीव का पासवर्ड (Password) घर बैठे-बैठे पता चल जाता है।"
                "तुम्हें किसी गुरु या किताब की ज़रूरत नहीं रहती, तुम खुद ही साक्षात 'चलता-फिरता वेद' बन जाते हो।"
                "तुम्हारी आँखें अब दीवारों के आर-पार, समय के आर-पार और मौत के आर-पार देखने लगती हैं।"
                "यह इंसान की बुद्धि का वह सबसे खौफनाक 'अपग्रेड' (Upgrade) है जहाँ वह साक्षात 'गूगल' से भी तेज़ हो जाता है।"
                "जिसने सब कुछ जान लिया, उसे फिर इस दुनिया में कोई बेवकूफ नहीं बना सकता!"
            """.trimIndent(),
            english = """
                (The Annihilation of All Sins and the Detonation of Omniscience): "The Upanishad here stamps an apocalyptic Seal engineered to shred every trace of biological ignorance."
                "'Sa sarvapapattarati'—That warrior is instantaneously released from 'Every single microscopic and catastrophic sin' of his eons of existence!"
                "(To stamp a 100% ironclad guarantee, the Shruti roars and repeats it twice: 'Sa sarvapapattarati'!)"
                "Your soul is now a flawlessly blank slate upon which God can now execute His brand-new cosmic coding."
                "And the absolute atomic explosion—'Sa sarvavit bhavati'—That human mutates into the explicit 'Omniscient' (All-Knowing) being!"
                "He intercepts every classified secret of the cosmos, every star, and the Password of every living entity without moving an inch."
                "You possess zero need for any Guru or pathetic textbook; you mutate into the literal 'Walking Veda' yourself."
                "Your vision now rips through solid walls, pierces through Time, and stares unflinchingly through the fabric of Death."
                "This is the most terrifying 'Upgrade' of the human intellect where he becomes mathematically faster than any supercomputer."
                "He who has flawlessly 'Known' everything can absolutely never be deceived by this Matrix again!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 16,
            sanskrit = "ॐ नमो नारायणायेत्येतदुपासितव्यम् । यस्मिन् लयमागच्छति तद्ब्रह्म भवति ॥",
            hindi = """
                (अंतिम विलय और ब्रह्म में विस्फोट): "अष्टाक्षर मंत्र की उपासना केवल जपने के लिए नहीं है; यह खुद को मिटाने (Self-Destruction) की प्रक्रिया है।"
                "'ॐ नमो नारायणाय'— इस मंत्र को अपनी आत्मा में तब तक रगड़ो (उपासितव्यम्) जब तक तुम खुद गायब न हो जाओ।"
                "'यस्मिन् लयमागच्छति'— जिस पल तुम इस मंत्र की फ्रीक्वेंसी में अपना 'लय' (Dissolution) कर देते हो..."
                "यानी जब 'मैं' मर जाता है और केवल 'नारायण' बचता है, तो एक भयानक आध्यात्मिक धमाका होता है।"
                "'तद्ब्रह्म भवति'— वह योगी उसी सेकंड साक्षात 'ब्रह्म' (The Absolute God) बन जाता है!"
                "यहाँ भक्त और भगवान के बीच का सारा ड्रामा खत्म हो जाता है; केवल एक असीम ऊर्जा शेष बचती है।"
                "यह शरीर के रहते हुए शरीर की मौत है और साक्षात परमेश्वर का जन्म है।"
                "जो इस शून्यता में डूबने की हिम्मत करता है, वह हमेशा-हमेशा के लिए अजेय हो जाता है।"
                "दुनिया जिसे 'मृत्यु' कहती है, योगी उसे 'ब्रह्म-प्राप्ति' का उत्सव मानता है।"
                "यह इंसानियत की आखिरी साँस है और अनंत काल की पहली धड़कन है!"
            """.trimIndent(),
            english = """
                (The Final Dissolution and the Explosion into Brahman): "The worship of the Ashtakshara mantra is not for pathetic chanting; it is the process of intentional 'Self-Destruction'."
                "'Om Namo Narayanaya'—Grind this mantra into your soul (Upasitavyam) until your own existence completely evaporates."
                "'Yasmin layamagacchati'—The exact microsecond you execute your 'Laya' (Dissolution) into the frequency of this mantra..."
                "Meaning, when the 'I' suffers a brutal death and strictly 'Narayana' remains, a terrifying spiritual detonation occurs."
                "'Tad-Brahma bhavati'—That Yogi, in that exact microsecond, mutates explicitly into 'Brahman' (The Supreme God)!"
                "The entire theatrical drama between the devotee and God terminates here; strictly one infinite Energy remains reigning."
                "This is the death of the body while still breathing and the explicit radioactive birth of the Supreme Lord."
                "He who possesses the terrifying audacity to drown in this Void becomes permanently and flawlessly Invincible."
                "What the world hallucinates as 'Death', the Yogi celebrates as the apocalyptic 'Attainment of Brahman'."
                "This is the final gasp of humanity and the first heartbeat of eternal infinity!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 17,
            sanskrit = "अकारो वियदादि सर्गसमुत्पन्नकिरणं कीलकम् ।",
            hindi = """
                (अकार की कीलक: अंतरिक्ष की कोडिंग): "ॐकार का पहला हिस्सा 'अ' (A) ब्रह्मांड की वह 'कील' (Password) है जिसने अंतरिक्ष को बाँध रखा है।"
                "'अकारो वियदादि'— इस 'अ' से ही असीम 'अंतरिक्ष' (Space) और सृष्टि के सारे तत्वों का जन्म हुआ है।"
                "'सर्गसमुत्पन्नकिरणं'— यह वह पहली प्रलयंकारी 'किरण' (Ray) है जिसने शून्यता में प्रकाश भरा था।"
                "योगी जब 'अ' का उच्चारण करता है, तो वह सीधे 'बिग बैंग' (Big Bang) की ऊर्जा को अपने गले में महसूस करता है।"
                "यह तुम्हारे शरीर के भीतर उस 'क्रिएशन-इंजन' (Creation Engine) को चालू करने का कोड है।"
                "बिना इस कीलक को जाने, तुम्हारा ध्यान केवल एक खोखली आवाज़ है।"
                "अकार वह बीज है जिसमें करोड़ों आकाशगंगाएं सुप्त अवस्था में छिपी बैठी हैं।"
                "जब तुम इस अक्षर को अपनी आत्मा में फोड़ते हो, तो तुम खुद एक 'ब्रह्मांड' की तरह फैलने लगते हो।"
                "यह तुम्हारी बायोलॉजिकल हदों को चीरकर तुम्हें 'विराट' बनाने की शुरुआत है।"
                "जो इस किरण को पकड़ लेता है, वह अंतरिक्ष के हर कोने का मालिक बन जाता है!"
            """.trimIndent(),
            english = """
                (The Kilakam of Akar: Coding the Infinite Space): "The first segment of Omkara, 'A' (A), is the cosmic 'Pin' (Password) that holds Space itself in position."
                "'Akaro viyadadi'—From this 'A' alone was the infinite 'Space' (Viyad) and every element of creation violently spawned."
                "'Sargasamutpannakiranam'—This is the absolute first apocalyptic 'Ray' (Kiranam) that flooded the Void with radioactive light."
                "When the Yogi vocalizes 'A', he intercepts the raw energy of the 'Big Bang' directly inside his physical throat."
                "This is the Code engineered to ignite the 'Creation Engine' sitting dormant inside your biological shell."
                "Without decoding this Kilakam, your meditation is strictly a pathetic, hollow acoustic vibration."
                "Akar is the primordial Seed where billions of galaxies are covertly hiding in a state of suspended animation."
                "The microsecond you detonate this syllable in your soul, you begin to expand flawlessly like a literal 'Universe'."
                "This is the genesis of shredding your biological boundaries and mutating into the 'Virat' (Universal Form)."
                "He who intercepts this Ray becomes the undisputed Master of every microscopic coordinate in space!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 18,
            sanskrit = "उकारो विष्णुर्मकारो रुद्रः अर्धमात्रा बिन्दुरिति ।",
            hindi = """
                (विष्णु और रुद्र की परमाणु शक्ति): "ॐकार के अगले पुर्जे चेतना के उस स्तर पर ले जाते हैं जहाँ समय और संहार का खेल शुरू होता है।"
                "'उकारो विष्णुः'— 'उ' (U) वह ताक़त है जो तुम्हारे वजूद को गिरने नहीं देती, वह तुम्हें थामे रखती है।"
                "यह विष्णु की वह 'ऑपरेटिंग' ऊर्जा है जो पूरे ब्रह्मांड के डेटा को मैनेज (Manage) कर रही है।"
                "'मकारो रुद्रः'— 'म' (M) वह खूँखार और हिंसक 'रुद्र' है जो हर सड़ी हुई चीज़ को खत्म करने के लिए दहाड़ रहा है।"
                "रुद्र का काम है तुम्हारे अज्ञान के कचरे को जलाना ताकि केवल शुद्ध सोना (आत्मा) बचे।"
                "'अर्धमात्रा बिन्दुरिति'— और वह 'बिंदु' वह जगह है जहाँ विष्णु और रुद्र की ताक़त एक होकर शून्य हो जाती है।"
                "यह तुम्हारे दिमाग के भीतर वह 'ब्लैक होल' है जो सब कुछ निगलने के लिए तैयार खड़ा है।"
                "बिंदु पर पहुँचते ही इंसान के विचार मौत की नींद सो जाते हैं।"
                "यह शरीर के भीतर उस न्यूक्लियर रिएक्टर का केंद्र है जहाँ ऊर्जा अपनी चरम सीमा पर होती है।"
                "जो इस बिंदु को हैक कर लेता है, वह साक्षात शिव और विष्णु की संयुक्त ताक़त का मालिक बन जाता है!"
            """.trimIndent(),
            english = """
                (The Atomic Power of Vishnu and Rudra): "The next components of Omkara transport the consciousness to the level where the game of Time and Annihilation begins."
                "'Ukaro Vishnuh'—'U' (U) is the radioactive power that prevents your existence from collapsing; it sustains your absolute structure."
                "This is Vishnu's 'Operating' energy that flawlessly Manages the entire data stream of the cosmos."
                "'Makaro Rudrah'—'M' (M) is the bloodthirsty and violent 'Rudra' roaring to execute the total slaughter of every decaying thing!"
                "Rudra's mission is to incinerate the garbage of your ignorance, leaving strictly the Pure Gold (Soul) behind."
                "'Ardhamatra binduriti'—And that 'Bindu' is the coordinate where the powers of Vishnu and Rudra fuse into absolute zero."
                "This is the literal 'Black Hole' inside your brain, positioned and ready to swallow your entire existence."
                "The exact microsecond you reach the Bindu, your thoughts suffer a permanent, brutal death."
                "It is the epicenter of the internal Nuclear Reactor where energy skyrockets to its absolute, extreme zenith."
                "He who successfully Hacks this Bindu becomes the sole Master of the combined radioactive power of Shiva and Vishnu!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 19,
            sanskrit = "तदूर्ध्वं नादः शक्तिः शान्तिरिति ।",
            hindi = """
                (नाद, शक्ति और शान्ति का प्रलयंकारी आरोहण): "बिंदु के पार जो रास्ता जाता है, वह इंसानियत के लिए हमेशा के लिए बंद है, लेकिन योगी उसे भी खोल देता है।"
                "'तदूर्ध्वं'— उस बिंदु के भी 'ऊपर' (Beyond) वह असीम 'नाद' (Sound) गूँज रहा है जिसने शून्य को हिला दिया था।"
                "यह नाद साक्षात ईश्वर की धड़कन है, जिसे सुनने के बाद इंसान फिर कभी दुनिया का शोर नहीं सुन सकता।"
                "और 'शक्ति' वह प्रलयंकारी आग है जो इस नाद को पूरे अंतरिक्ष में फैला रही है।"
                "यह वह करंट (Current) है जिससे तुम्हारी आत्मा के सोए हुए बल्ब जल उठते हैं।"
                "'शान्ति' वह अंतिम और सबसे खौफनाक अवस्था है जहाँ पहुँचकर ब्रह्मांड का सारा खेल थम जाता है।"
                "शांति का मतलब आँखें बंद करना नहीं, शांति का मतलब है 'अहंकार की 100% मृत्यु' (Absolute Flatline)!"
                "यहाँ न कोई चाहत बचती है, न कोई डर, न कोई भगवान और न कोई भक्त—केवल एक अद्वैत सन्नाटा राज करता है।"
                "यह वह 'टर्मिनल' है जहाँ से तुम हमेशा के लिए इस मैट्रिक्स (Matrix) से बाहर निकल जाते हो।"
                "नाद, शक्ति और शांति—ये तीन वो चाबियाँ हैं जिनसे परब्रह्म का आखिरी ताला खुलता है!"
            """.trimIndent(),
            english = """
                (The Apocalyptic Ascent of Nada, Shakti, and Shanti): "The path beyond the Bindu is permanently sealed for mortals, but the Yogi violently smashes it open."
                "'Tad-urdhvam'—Directly 'Above' (Beyond) that Bindu echoes that infinite 'Nada' (Sound) which had originally vibrated the Void."
                "This Nada is the explicit heartbeat of God; once intercepted, a human can never again hear the pathetic noise of the world."
                "And 'Shakti' is the apocalyptic fire that is relentlessly broadcasting this Nada throughout the infinite vacuum of space."
                "It is the radioactive Current that ignites the dormant bulbs of your Soul into brilliant radiation."
                "'Shanti' is the absolute final and most terrifying dimension where the entire cosmic game comes to a grinding halt."
                "Shanti does not mean closing your eyes; Shanti explicitly means the '100% Death of the Ego' (Absolute Flatline)!"
                "Here, zero craving survives, zero fear exists, zero separate God or Devotee remains—strictly a Non-dual Silence reigns supreme."
                "This is the absolute 'Terminal' from which you are permanently and violently Ejected from this Matrix."
                "Nada, Shakti, and Shanti—these are the three keys engineered to unlock the absolute final padlock of the Supreme Brahman!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 20,
            sanskrit = "तमेतं तारकमिति विद्धि । य एवं वेद स मृत्युं तरति ॥",
            hindi = """
                (तारक की अंतिम चेतावनी और अमरता की मुहर): "नारायण फिर से उस बात पर ज़ोर देते हैं जो अज्ञानी लोगों को समझ नहीं आती।"
                "'तमेतं तारकमिति विद्धि'— इस पूरे ॐकार और अष्टाक्षर के विज्ञान को ही साक्षात 'तारक' (Saved Zone) जान लो!"
                "अगर तुम इसे नहीं जानते, तो तुम ब्रह्मांड के सबसे बड़े अंधे और बहरे हो।"
                "परिणाम फिर से वही अटल सत्य है: 'य एवं वेद स मृत्युं तरति'!"
                "जो इस 'तारक' फ्रीक्वेंसी को अपनी रगों में तेज़ाब की तरह उतार लेता है, वह 'मृत्यु' को ऐसे पार कर जाता है जैसे कोई शिकारी अपने शिकार को कुचल देता है।"
                "मृत्यु केवल उन लोगों के लिए है जो शरीर से चिपके हैं; जो मंत्र से चिपक गया, वह साक्षात शिव हो गया।"
                "यह कोई झूठा धार्मिक वादा नहीं है, यह एक 'मैथमेटिकल' (Mathematical) सच है—फ्रीक्वेंसी बदलो और दुनिया बदल जाएगी।"
                "जब तुम अपनी फ्रीक्वेंसी 'इंसान' से बदलकर 'तारक' कर लेते हो, तो मौत का सॉफ्टवेयर तुम्हें पहचानना बंद कर देता है।"
                "तुम इस मायावी सिम्युलेशन (Simulation) के लिए 'इनविजिबल' (Invisible) हो जाते हो।"
                "यही वह अजेय रुतबा है जिसे पाने के लिए योगी करोड़ों सालों तक बर्फ में जलते हैं!"
            """.trimIndent(),
            english = """
                (The Final Warning of Taraka and the Seal of Immortality): "Narayana again emphasizes the absolute truth which remains incomprehensible to the pathetic ignorant mortals."
                "'Tametam tarakamiti viddhi'—Explicitly recognize this entire science of Omkara and Ashtakshara strictly as the 'Taraka' (The Safe Zone)!"
                "If you fail to decode this, you are the most utterly blind and deaf entity in the entire infinite cosmos."
                "The consequence remains that same immutable absolute truth: 'Ya evam veda sa mrityum tarati'!"
                "He who injects this 'Taraka' frequency into his veins exactly like boiling acid violently 'Crosses' Death as an apex predator crushes its prey."
                "Death is exclusively reserved for those pathetically clinging to biological flesh; he who anchors to the Mantra explicitly mutates into Shiva."
                "This is absolutely no fake religious promise; it is a 'Mathematical' reality—mutate your Frequency and you mutate your World."
                "The exact microsecond you shift your frequency from 'Human' to 'Taraka', the software of Death fails to recognize you."
                "You become explicitly 'Invisible' to this deceptive cosmic Simulation."
                "This is the invincible status for which Yogis burn in radioactive ice for billions of years!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 21,
            sanskrit = "आदित्यमण्डले प्रतिष्ठितं पुरुषं ध्यायेत् । स परमात्मा स परं ब्रह्म ॥",
            hindi = """
                (सूर्य-मण्डल का ध्यान और परमेश्वर का दर्शन): "अब योगी को अपनी आँखें उस धधकते हुए सूर्य (आदित्य) पर लगानी हैं जो अंतरिक्ष का पावर-हाउस है।"
                "'आदित्यमण्डले प्रतिष्ठितं पुरुषं'— उस सूर्य के धधकते गोले के ठीक बीचों-बीच जो अजेय 'पुरुष' (The Cosmic Being) बैठा है, उसका 'ध्यान' (Lock) करो!"
                "वह सूर्य केवल एक तारा नहीं है, वह साक्षात उस परब्रह्म की 'भौतिक आँख' (Physical Eye) है जो सब कुछ देख रही है।"
                "जब तुम उस सूर्य की आग में अपनी चेतना को जलाते हो, तो तुम्हें 'परमात्मा' के साक्षात दर्शन होते हैं।"
                "वह परमात्मा कोई और नहीं, 'स परं ब्रह्म'— वह साक्षात वह 'परब्रह्म' (Supreme Void) ही है!"
                "यह ध्यान तुम्हारी आँखों के रेटिना को नहीं, बल्कि तुम्हारी आत्मा के परदे को जलाकर साफ़ कर देता है।"
                "सूरज की वह रेडियोएक्टिव गर्मी तुम्हारे अज्ञान के कचरे को भाप बनाकर उड़ा देती है।"
                "तुम जान जाते हो कि जो प्रकाश उस मण्डल में है, वही प्रकाश तुम्हारी आँखों के पीछे भी धधक रहा है।"
                "यहाँ आकर 'देखने वाला' और 'देखा जाने वाला' दोनों एक ही आग बन जाते हैं।"
                "यह ब्रह्मांड की सबसे बड़ी ताक़त से आँखें मिलाने का सबसे साहसिक और आत्मघाती (Suicidal) योग है!"
            """.trimIndent(),
            english = """
                (Meditating on the Solar Orb and Witnessing God): "Now the Yogi must violently Lock his eyes onto that blazing Sun (Aditya), the absolute radioactive powerhouse of space."
                "'Adityamandale pratishtitam purusham'—Directly in the dead-center of that blazing solar orb sits the invincible 'Purusha' (The Cosmic Being); focus your 'Meditation' (Lock) strictly on Him!"
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
        TarasaraShloka(
            id = 22,
            sanskrit = "योऽयं नारायणः स विष्णुः स शिवः स ब्रह्मा स इन्द्रः स परः ॥",
            hindi = """
                (नारायण की असीमित ताक़त: सब उसी का नाटक हैं): "उपनिषद यहाँ सारे देवताओं की अलग-अलग पहचान का बेरहमी से कत्ल कर देता है।"
                "'योऽयं नारायणः'— यह जो असीम और प्रलयंकारी 'नारायण' है, वही साक्षात 'विष्णु' है जो दुनिया चलाता है!"
                "'स शिवः'— वही साक्षात महाकाल 'शिव' है जो ब्रह्मांड को जलाकर राख कर देता है!"
                "'स ब्रह्मा स इन्द्रः'— वही साक्षात सृष्टिकर्ता 'ब्रह्मा' है और वही देवताओं का राजा 'इंद्र' भी है!"
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
        TarasaraShloka(
            id = 23,
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
                "तुम इसी शरीर के अंदर रहते हुए साक्षात भगवान की तरह आज़ाद हो जाते हो।"
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
        TarasaraShloka(
            id = 24,
            sanskrit = "प्रणवो धनुः शरो ह्यात्मा ब्रह्म तल्लक्ष्यमुच्यते । अप्रमत्तेन वेद्धव्यं शरवत्तन्मयो भवेत् ॥",
            hindi = """
                (ॐकार का धनुष और आत्मा का तीर): "मुक्ति पाने के लिए तुम्हें एक खौफनाक 'स्नाइपर' (Sniper) बनना होगा।"
                "'प्रणवो धनुः'— साक्षात ॐकार (प्रणव) ही वह अजेय 'धनुष' है जिस पर तुम्हें अपनी आत्मा को चढ़ाना है।"
                "'शरो ह्यात्मा'— तुम्हारी 'आत्मा' ही वह धारदार 'तीर' (शरो) है जिसे तुम्हें फायर (Fire) करना है।"
                "'ब्रह्म तल्लक्ष्यमुच्यते'— और तुम्हारा इकलौता 'निशाना' (Target) वह असीम 'ब्रह्म' (शून्यता) है!"
                "इस युद्ध में गलती की कोई गुंजाइश नहीं है; 'अप्रमत्तेन वेद्धव्यं'— तुम्हें बिना पलक झपकाए, पूरी सावधानी और एकाग्रता के साथ उस निशाने को 'भेद' (Shoot) देना है!"
                "अगर तुम्हारा ध्यान भटका, तो तुम माया की खाई में गिर जाओगे।"
                "और अंत में— 'शरवत्तन्मयो भवेत्'— जैसे तीर निशाने में घुसकर खुद निशाना बन जाता है, वैसे ही तुम उस ब्रह्म में घुसकर खुद 'ब्रह्म' बन जाओ!"
                "यहाँ भक्त की मौत होती है ताकि साक्षात भगवान ज़िंदा हो सके।"
                "यह अपनी ही रूह को एक मिसाइल (Missile) बनाकर सीधे ईश्वर के दिल में दागने का विज्ञान है।"
                "जो इस निशानेबाजी में उस्ताद हो गया, वह पूरे ब्रह्मांड के समय और मौत को अपने काबू में कर लेता है!"
            """.trimIndent(),
            english = """
                (The Bow of Omkara and the Arrow of the Soul): "To achieve absolute liberation, you must mutate into a terrifying cosmic 'Sniper'."
                "'Pranavo dhanuh'—The explicit Omkara (Pranava) is the invincible 'Bow' upon which you must mount your existence."
                "'Sharo hyatma'—Your very 'Soul' (Atma) is the razor-sharp 'Arrow' (Sharo) that you are engineered to Fire."
                "'Brahma tallakshyamucchyate'—And your solitary 'Target' (Lakshya) is strictly that infinite 'Brahman' (The Void)!"
                "In this warfare, zero margin for error exists; 'Apramattena veddhavyam'—You must 'Pierce/Shoot' (Veddhavyam) that target with absolute unblinking caution and radioactive concentration!"
                "If your focus deviates by even a micro-millimeter, you will plummet straight into the abyss of Maya."
                "And finally—'Sharavattanmayo bhavet'—Exactly as an arrow penetrates the target and mutates into the target itself, penetrate Brahman and mutate into explicit 'Brahman'!"
                "The Devotee must suffer a brutal death here so that the explicit God can be flawlessly resurrected."
                "This is the science of weaponizing your Soul into a ballistic missile and Firing it directly into the heart of God."
                "He who becomes an expert in this cosmic marksmanship dictates the velocity of Time and the trajectory of Death!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 25,
            sanskrit = "एतदुपासितव्यं य एवं वेद स मृत्युं तरति स पाप्मानं तरति ॥",
            hindi = """
                (परम उपासना और मौत का अंत): "उपनिषद बार-बार इसी एक सत्य पर हथौड़ा मारता है ताकि तुम्हारे दिमाग का ताला टूट जाए।"
                "'एतदुपासितव्यं'— केवल इसी ॐकार और नारायण के अद्वैत रहस्य की 'उपासना' करो!"
                "बाकी सब कचरा है, केवल यही एक कोड (Code) तुम्हें इस सिम्युलेशन (Simulation) से बाहर निकाल सकता है।"
                "नारायण फिर से उस प्रलयंकारी रिज़ल्ट की घोषणा करते हैं: 'य एवं वेद स मृत्युं तरति'!"
                "जो इस सत्य को अपनी साँसों में धधका लेता है, वह 'मृत्यु' के रेडार (Radar) से हमेशा के लिए गायब हो जाता है।"
                "यमराज के पास ऐसा कोई सॉफ्टवेयर नहीं है जो एक 'ब्रह्म-ज्ञानी' को ट्रैक (Track) कर सके।"
                "'स पाप्मानं तरति'— उसके पिछले करोड़ों जन्मों के 'महापाप' एक ही झटके में भाप बनकर उड़ जाते हैं।"
                "पाप और पुण्य की ज़ंजीरें केवल उन लोगों के लिए हैं जो अभी भी इंसानियत के भ्रम में जी रहे हैं।"
                "योगी इन दोनों को अपनी आत्मा की आग में स्वाहा (Burn) कर देता है।"
                "यही वह अजेय रुतबा है जहाँ पहुँचकर तुम खुद ही वह ताक़त बन जाते हो जो सितारे बनाती है!"
            """.trimIndent(),
            english = """
                (Supreme Worship and the Termination of Death): "The Upanishad repeatedly hammers this solitary truth into your brain until the biological padlock shatters."
                "'Etad-upasitavyam'—Execute 'Worship' strictly and exclusively on this non-dual secret of Omkara and Narayana!"
                "Everything else is strictly garbage; only this singular Code possesses the caliber to Eject you from this Simulation."
                "Narayana again broadcasts the apocalyptic result: 'Ya evam veda sa mrityum tarati'!"
                "He who blazes this truth inside his breath permanently disappears from the 'Radar' of Death."
                "Yamaraja (The God of Death) possesses zero software capable of Tracking a 'Knower of Brahman'."
                "'Sa papmanam tarati'—Every single 'Catastrophic Sin' of his billions of past incarnations vaporizes into radioactive nothingness in one strike."
                "The chains of Sin and Merit exist strictly for those still hallucinating the pathetic biological drama of humanity."
                "The Yogi Swahas (Burns) both into the radioactive fire of his Soul."
                "This is the invincible status arriving at which YOU mutate into the explicit power that constructs the galaxies!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 26,
            sanskrit = "यत्रैतदक्षयं ब्रह्म यत्र गत्वा न निवर्तते । तद्विष्णोः परमं पदं पश्यन्ति सूरयः ॥",
            hindi = """
                (विष्णु का परम पद: नो-रिटर्न ज़ोन): "अब उस 'टर्मिनल' (Terminal) का पता दिया जा रहा है जहाँ पहुँचने के बाद तुम वापस इस कीचड़ में नहीं लौटोगे।"
                "'यत्रैतदक्षयं ब्रह्म'— जहाँ वह कभी न खत्म होने वाला (अक्षय) 'परब्रह्म' अपनी पूरी प्रलयंकारी महिमा में विराजमान है!"
                "'यत्र गत्वा न निवर्तते'— जहाँ एक बार घुसने (गत्वा) के बाद, ब्रह्मांड की कोई भी ताक़त तुम्हें 'वापस' (न निवर्तते) नहीं भेज सकती!"
                "पुनर्जन्म (Rebirth) की वह सड़ी हुई मशीन वहाँ जाकर हमेशा के लिए क्रैश (Crash) हो जाती है।"
                "'तद्विष्णोः परमं पदं'— यही भगवान 'विष्णु का वह परम पद' (The Ultimate Dimension) है, जहाँ समय और स्थान जलकर राख हो जाते हैं।"
                "'पश्यन्ति सूरयः'— केवल वे 'सूरयः' (अत्यंत बुद्धिमान और खूँखार योगी) ही इसे देख पाते हैं जिनकी आँखें सत्य की आग में जल चुकी हैं।"
                "यह कोई आसमान का स्वर्ग नहीं है, यह चेतना का वह 'ब्लैक होल' है जो तुम्हारे 'मैं' को निगल कर तुम्हें ईश्वर बना देता है।"
                "यहाँ पहुँचने के बाद तुम साक्षात वह 'परम सन्नाटा' बन जाते हो जिससे पूरी सृष्टि चल रही है।"
                "यही वह 'सुप्रीम हेडक्वार्टर' है जहाँ से तुम पूरे ब्रह्मांड का तमाशा देखते हो।"
                "जो इस पद पर बैठ गया, वह पूरे असीम अंतरिक्ष का इकलौता तानाशाह (Dictator) है!"
            """.trimIndent(),
            english = """
                (The Supreme State of Vishnu: The No-Return Zone): "The exact coordinates of the 'Terminal' are now disclosed, reaching which you shall absolutely never return to this biological mud."
                "'Yatraitad-akshayam Brahma'—Where that indestructible (Akshaya) 'Supreme Brahman' reigns in all His apocalyptic majesty!"
                "'Yatra gatva na nivartate'—Where once you Penetrate (Gatva), absolutely zero force in the cosmos possesses the authority to send you 'Back' (Na nivartate)!"
                "The rotting machine of Reincarnation violently Crashes and Flatlines forever at that exact coordinate."
                "'Tad-Vishnoh paramam padam'—THIS explicitly is 'Vishnu's Supreme Dimension', where Time and Space are incinerated to absolute ash."
                "'Pashyanti surayah'—Strictly and exclusively those 'Surayah' (Terrifyingly intelligent and fierce Yogis) witness this, whose vision has been forged in the fire of Truth."
                "This is absolutely no heaven in the sky; it is the absolute 'Black Hole' of consciousness that swallows your 'I' and resurrects you as God."
                "Upon arrival, you mutate into the explicit 'Supreme Silence' that relentlessly operates the entire infinite creation."
                "This is the 'Supreme Headquarters' from which you witness the pathetic theatrical drama of the universe."
                "He who occupies this throne is the sole, undisputed Dictator of the entire infinite vacuum of space!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 27,
            sanskrit = "सदा पश्यन्ति सूरयः दिवीव चक्षुराततम् । तद्विप्रासो विपन्यवो जागृवांसः समिन्धते ॥",
            hindi = """
                (योगियों की नंगी और प्रलयंकारी नज़र): "वे अजेय योगी (सूरयः) उस सत्य को कैसे देखते हैं? उपनिषद उनका नंगा सच उगल देता है।"
                "'सदा पश्यन्ति सूरयः'— वे योद्धा 'हमेशा' (सदा) उस सत्य को अपनी आँखों के सामने नंगा खड़ा देखते हैं!"
                "'दिवीव चक्षुराततम्'— जैसे असीम 'आकाश' (दिवीव) में एक विशाल और धधकती हुई 'आँख' (चक्षुः) सब कुछ देख रही हो!"
                "उनकी नज़र दीवारों के आर-पार, शरीरों के आर-पार और समय के आर-पार साक्षात उस 'ब्रह्म' को पकड़ लेती है।"
                "'तद्विप्रासो विपन्यवो'— वे 'विप्र' (ज्ञानी) अपनी स्तुतियों और अपनी ऊर्जा से उस सत्य को लगातार 'जगाए' (जागृवांसः) रखते हैं।"
                "'समिन्धते'— वे अपनी आत्मा की आग से उस 'परम पद' को और ज़्यादा 'धधका' (समिन्धते) देते हैं!"
                "वे भगवान की पूजा नहीं करते, वे भगवान की ऊर्जा को अपने भीतर एक न्यूक्लियर रिएक्टर की तरह 'रिएक्ट' (React) करवाते हैं।"
                "उनकी चेतना एक ऐसी लेज़र बीम (Laser Beam) बन चुकी है जो माया के हर पर्दे को फाड़ कर रख देती है।"
                "वे सोते हुए भी जाग रहे हैं, और जागते हुए भी उस परम सन्नाटे में डूबे हुए हैं।"
                "यही वह खौफनाक रुतबा है जहाँ इंसान और ईश्वर के बीच का पर्दा हमेशा के लिए जलकर राख हो जाता है!"
            """.trimIndent(),
            english = """
                (The Naked and Apocalyptic Vision of the Yogis): "How exactly do those invincible Yogis (Surayah) witness the Truth? The Upanishad vomits the naked reality."
                "'Sada pashyanti surayah'—Those warriors witness that Absolute Truth standing flawlessly naked before them 'Eternally' (Sada)!"
                "'Diviva chakshuratatam'—Exactly like a colossal, blazing 'Eye' (Chakshuh) established in the infinite 'Sky' (Divi), witnessing everything simultaneously!"
                "Their vision violently rips through solid walls, pierces through biological bodies, and strikes the 'Brahman' directly through Time."
                "'Tadvipraso vipanyavo'—Those 'Vipras' (Sages) through their radioactive energy keep that Truth perpetually 'Awake' (Jagrivamsah) within them."
                "'Samindhate'—They use the fire of their own Souls to violently 'Kindle/Supercharge' (Samindhate) that 'Supreme Dimension'!"
                "They absolutely do not worship God; they force the energy of God to 'React' inside their core like a literal Nuclear Reactor."
                "Their consciousness has mutated into a radioactive Laser Beam engineered to shred every single veil of Maya to pieces."
                "They are wide awake even while sleeping, and while awake, they are flawlessly drowned in that Supreme Silence."
                "THIS is the terrifying status where the pathetic curtain between human and God is permanently incinerated to ash!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 28,
            sanskrit = "विष्णोर्यत्परमं पदं यदविमुक्तं तदुच्यते । य एवं वेद स मुक्तो भवति ॥",
            hindi = """
                (विष्णु पद और अविमुक्त की एकता): "उपनिषद यहाँ उस आखिरी पहेली (Puzzle) को हल करता है जिसने तुम्हें जन्मों से बेवकूफ बना रखा है।"
                "'विष्णोर्यत्परमं पदं'— वह जो भगवान विष्णु का सबसे ऊँचा और खौफनाक 'परम पद' (Dimension) है..."
                "'यदविमुक्तं तदुच्यते'— उसी को साक्षात 'अविमुक्त' (काशी/The Undetachable) भी कहा जाता है!"
                "विष्णु का पद और शिव की काशी—ये कोई दो अलग-अलग जगह नहीं हैं; ये साक्षात उस एक ही 'परम शून्यता' के नाम हैं!"
                "चाहे तुम राम कहो, शिव कहो या नारायण—तुम उसी एक 'न्यूक्लियर कोर' (Nuclear Core) की बात कर रहे हो।"
                "परिणाम फिर से वही हिंसक और अटल गारंटी है: 'य एवं वेद स मुक्तो भवति'!"
                "जो इस एकता (Unity) के रहस्य को हैक कर लेता है और अपनी रगों में उतार लेता है, वह 'निश्चित रूप से मुक्त' हो जाता है।"
                "मुक्ति कोई मेहनत का काम नहीं है, यह केवल अज्ञान के उस पुराने सॉफ्टवेयर को 'अनइंस्टॉल' (Uninstall) करने का नाम है।"
                "जिस पल तुम जान जाते हो कि 'सब एक है', उसी पल माया की जेल के ताले अपने आप टूट कर गिर जाते हैं।"
                "यह इंसान की आत्मा का वह अंतिम और प्रलयंकारी विस्फोट है जहाँ से कोई वापस नहीं लौटता!"
            """.trimIndent(),
            english = """
                (The Unity of Vishnu's State and Avimukta): "The Upanishad here solves the absolute final Puzzle that has kept you a pathetic fool for billions of lifetimes."
                "'Vishnoryat-paramam padam'—That which is the absolute highest and terrifying 'Supreme Dimension' (Pada) of Lord Vishnu..."
                "'Yadavimuktam taduchyate'—Is explicitly and identically named as the 'Avimukta' (Kashi/The Undetachable)!"
                "Vishnu's dimension and Shiva's Kashi are absolutely NOT two distinct locations; they are strictly names for that ONE singular 'Nuclear Core'!"
                "Whether you roar Rama, Shiva, or Narayana—you are targeting the exact same radioactive 'Absolute Void'."
                "The consequence remains that same violent and ironclad guarantee: 'Ya evam veda sa mukto bhavati'!"
                "He who successfully Hacks this secret of Unity and injects it into his veins becomes 'Flawlessly Liberated' in this exact microsecond."
                "Moksha is absolutely zero labor; it is strictly the protocol of 'Uninstalling' the old, corrupt software of biological ignorance."
                "The exact microsecond you 'Know' that 'All is One', the titanium padlocks of Maya's prison violently fracture and fall."
                "This is the final and apocalyptic detonation of the human Soul from which absolutely zero return is possible!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 29,
            sanskrit = "एतदुपासितव्यं नान्यत् । य एवं वेद स मृत्युं तरति ॥",
            hindi = """
                (अंतिम आदेश: केवल इसी सत्य में जलो): "नारायण अपनी बात को खत्म करने से पहले एक आखिरी प्रलयंकारी चेतावनी (Warning) देते हैं।"
                "'एतदुपासितव्यं नान्यत्'— केवल और केवल इसी सत्य (नारायण/तारक) की उपासना करो, 'दूसरी किसी भी' (नान्यत्) चीज़ में अपना वक़्त बर्बाद मत करो!"
                "दुनिया में करोड़ों भगवान और करोड़ों धर्म हैं, वे सब केवल तुम्हें भटकाने के लिए माया के 'हनी-ट्रैप' (Honey-trap) हैं।"
                "अगर तुम उस 'एक' को नहीं पकड़ते, तो तुम अनंत काल तक इसी कीचड़ में पिसते रहोगे।"
                "नारायण फिर से उस रिज़ल्ट का डंका बजाते हैं: 'य एवं वेद स मृत्युं तरति'!"
                "जो इस सच को अपनी 'आइडेंटिटी' (Identity) बना लेता है, वह 'मौत' के उस खौफनाक समुद्र को ऐसे पार कर जाता है जैसे कोई शेर किसी शिकार को चीर देता है।"
                "मृत्यु तुम्हारे लिए अब कोई खतरा नहीं, वह केवल एक 'सॉफ्टवेयर रिबूट' (Software Reboot) जैसा मज़ाक बन कर रह जाती है।"
                "तुम जान जाते हो कि तुम वह ऊर्जा हो जिसे न आग जला सकती है और न समय मार सकता है।"
                "यह इंसान के 'परमेश्वर' में म्यूटेट (Mutate) होने की अंतिम मुहर है।"
                "जो इस आवाज़ को सुनकर भी नहीं जागा, वह ब्रह्मांड का सबसे बड़ा बदनसीब कीड़ा है!"
            """.trimIndent(),
            english = """
                (The Final Command: Burn Strictly in this Truth): "Lord Narayana issues one last apocalyptic Warning before terminating His cosmic broadcast."
                "'Etad-upasitavyam nanyat'—Worship strictly and exclusively THIS truth (Narayana/Taraka); do absolutely NOT waste your existence in 'Anything Else' (Nanyat)!"
                "Billions of gods and religions exist in the Matrix; they are all strictly the 'Honey-traps' of Maya engineered to keep you wandering."
                "If you fail to capture that 'ONE', you are condemned to be ground in this biological mud for infinite eternity."
                "Narayana again sounds the trumpet of the result: 'Ya evam veda sa mrityum tarati'!"
                "He who mutates this truth into his authentic 'Identity' violently 'Crosses' the horrific ocean of 'Death' exactly as a lion rips through its prey."
                "Death is no longer a threat to you; it is permanently reduced to a meaningless joke, like a pathetic 'Software Reboot'."
                "You flawlessly realize you are the radioactive energy that zero fire can burn and zero Time can assassinate."
                "This is the final Seal of a human being undergoing a complete Mutation into the Supreme God."
                "He who fails to awaken even after intercepting this broadcast is the absolute most unfortunate insect in the cosmos!"
            """.trimIndent()
        ),
        TarasaraShloka(
            id = 30,
            sanskrit = "इत्युपनिषत् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'तारासार उपनिषद' अपनी पूरी प्रलयंकारी महिमा के साथ समाप्त होता है (इत्युपनिषत्)।"
                "यह कोई मामूली किताब नहीं है; यह एक ऐसा ब्रह्मांडीय 'न्यूक्लियर बम' है जो सीधा इंसान के अज्ञान और अहंकार पर गिरता है।"
                "नारायण का कोड मिल गया, तारक की नाव तैयार है, और अब तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' (Log-out) करना है।"
                "जिसने इस ग्रंथ के इन ३० विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म और कर्मकांड राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा— केवल एक मौत जैसा खौफनाक और असीम 'सन्नाटा' (Silence) राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (नारायण) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही तारासार उपनिषद का अंतिम और सबसे हिंसक सच है!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Tarasara Upanishad' achieves its absolute majestic completion (Ityupanishat)."
                "This is absolutely no ordinary book; it is a literal cosmic 'Nuclear Bomb' dropped directly onto the human ego and biological ignorance."
                "The Code of Narayana has been intercepted, the Taraka Boat is primed, and now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 30 explosions inside his Soul, every religion and ritual on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules as the absolute dictator."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Narayana) remains standing flawlessly invincible!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutates into the Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Tarasara Upanishad!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarasaraUpanishadScreen() {
    val upanishad = remember { TarasaraUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..30) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-30)") },
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
            itemsIndexed(upanishad.tarasaraShlokasList) { _, shloka ->
                TarasaraShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun TarasaraShlokaCard(shloka: TarasaraShloka) {
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