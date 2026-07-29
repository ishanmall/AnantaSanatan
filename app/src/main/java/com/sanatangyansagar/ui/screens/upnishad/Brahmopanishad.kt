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

// UNIQUE DATA MODEL TO AVOID CONFLICTS
data class BrahmopanishadShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class Brahmopanishad {

    val shlokasList = listOf(
        BrahmopanishadShloka(
            id = 1,
            sanskrit = "ॐ शौनको ह वै महाशालोऽङ्गिरसं विधिवदुपसन्नः पप्रच्छ । दिव्ये ब्रह्मपुरे संप्रतिष्ठिता भवन्ति कथं सृजतः ॥",
            hindi = """
                (शौनक का विद्रोह और महा-प्रश्न): "महान गृहस्थ शौनक ने ऋषि अङ्गिरा के एडमिन पैनल में घुसकर वह गुप्त सवाल पूछा।"
                "हे भगवन्! इस दिव्य 'ब्रह्मपुर' (शरीर) में शक्तियाँ कैसे प्रतिष्ठित होती हैं और यह सिम्युलेशन कैसे काम करता है?"
                "यह कोई साधारण जिज्ञासा नहीं थी; यह अपने ही बायोलॉजिकल हार्डवेयर को समझने का हिंसक प्रयास था।"
                "शौनक जानना चाहते थे कि इस ३डी पिंजरे का असली ऑपरेटर (Operator) कौन है।"
                "ब्रह्मपुर वह 'स्मार्ट सिटी' है जहाँ तुम्हारी रूह एक कैदी बनकर रह रही है।"
                "यहाँ से उस संवाद की शुरुआत होती है जो तुम्हारी हस्ती के हर एक पिक्सेल को बेनकाब कर देगा।"
                "योगी अपनी चेतना को उस 'आदि-प्रश्न' पर लॉक करता है जहाँ से अज्ञान का वध शुरू होता है।"
                "जब तुम पूछते हो कि 'यह सब कैसे चल रहा है', तो तुम माया के सर्वर को हैक करने का पहला कमांड देते हो।"
                "तैयार हो जाओ उस डेटा के लिए जो तुम्हारे नर्वस सिस्टम के 'फायरवॉल' को एक झटके में तोड़ देगा।"
                "यहीं से उस अजेय 'ब्रह्मोपनिषद' का प्रलयंकारी डेटा-स्ट्रीम शुरू होता है!"
            """.trimIndent(),
            english = """
                (Shaunaka's Rebellion and the Grand Query): "The great householder Shaunaka breached the Admin Panel of Angiras to pose the classified query."
                "O Lord! How exactly are the powers established in this 'Brahmapura' (Body) and how is creation Executed?"
                "This was zero ordinary curiosity; it was a violent attempt to decode his own biological hardware."
                "Shaunaka demanded to identify the authentic Operator of this 3D biological cage."
                "Brahmapura is the 'Smart City' where your Soul currently exists mutationally as a prisoner."
                "Right here initiates the dialogue engineered to unmask every pixel of your microscopic existence."
                "The Yogi Locks his awareness onto the 'Primordial Question' where the slaughter of ignorance initiates."
                "The moment you interrogate 'How is this operational?', you issue the first Command to Hack Maya's server."
                "Brace yourself for the Data engineered to violently shatter your brain's Firewall in one strike."
                "Right here initiates the apocalyptic Data-stream of the invincible Brahmopanishad!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 2,
            sanskrit = "तस्मै स होवाच । एष ह वै देवात्मा । य एष पुरुषः स वै देवात्मा ॥",
            hindi = """
                (देवात्मा का विस्फोट और पुरुष का सच): "अङ्गिरा ने दहाड़ मारी: 'सुन शौनक! यह जो भीतर बैठा है, यही साक्षात् 'देवात्मा' (Divine Soul) है!'"
                "यह 'पुरुष' कोई हाड़-मांस का पुतला नहीं, यह ब्रह्मांड का इकलौता 'सोर्स कोड' (Source Code) है।"
                "यही वह 'प्राइमरी प्रोसेसर' है जिसके बिना तुम्हारी इन्द्रियाँ केवल एक निर्जीव कबाड़ हैं।"
                "देवात्मा का मतलब है—वह आग जो देवताओं को भी बिजली (Power) सप्लाई कर रही है।"
                "तुम जिसे 'अपना' कहते हो, वह साक्षात् उस एडमिन का एक छोटा सा 'Avatar पिक्सेल' मात्र है।"
                "ब्रह्मा साक्षात् इसी एक बिजली के अलग-अलग फ्रीक्वेंसी वाले सिग्नल्स हैं।"
                "जब तुम इस पुरुष को हैक करते हो, तो तुम साक्षात् ब्रह्मांड के 'पॉवर-ग्रिड' से एक हो जाते हो।"
                "यह तुम्हारी रूह को 'यूजर' से 'एडमिन' के लेवल पर प्रमोट करने का सबसे तेज़ रास्ता है।"
                "आत्मा वह अजेय डेटा है जिसे माया का कोई भी वायरस कभी करप्ट नहीं कर सका।"
                "जो इस देवात्मा को पहचान लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (Detonation of Devatma and the Truth of Purusha): "Angiras roared: 'Intercept this, Shaunaka! That which sits within is the explicit 'Devatma' (Divine Soul)!'"
                "This 'Purusha' is zero puppet of flesh; it is mutationally the solitary 'Source Code' of the multiverse."
                "He is the 'Primary Processor' without whom your senses are strictly lifeless biological junk."
                "Devatma signifies—the radioactive Fire supplying electricity strictly to the higher gods themselves."
                "What you label as 'Yourself' is mutationally a microscopic 'Avatar Pixel' of the absolute Admin."
                "Rudra, Vishnu, and Brahma are strictly distinct Frequency-signals of this singular radioactive Current."
                "The exact microsecond you Hack this Purusha, you mutationally fuse with the cosmic Power-Grid."
                "This is the fastest trajectory to Promote your Soul from the status of 'User' to absolute 'Admin'."
                "The Soul is the indestructible Data that zero virus of Maya has ever possessed the caliber to corrupt."
                "He who recognizes this Devatma becomes mutationally the sole and absolute Dictator of the vacuum!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 3,
            sanskrit = "तस्यैतस्य चतुष्पात्त्वं भवति । जाग्रत्स्वप्नसुषुप्तितुर्याणीति ॥",
            hindi = """
                (चेतना के चार लेवल्स का विच्छेदन): "इस आत्मा के चार 'चरण' (Quarters) हैं—जाग्रत, स्वप्न, सुषुप्ति और तुरीय!"
                "जाग्रत तुम्हारी आँखों की ३डी दुनिया है, स्वप्न तुम्हारे दिमाग का इंटरनल 'सिमुलेटर' (Simulator) है।"
                "सुषुप्ति वह 'शटडाउन' स्टेट है जहाँ डेटा वापस अन-प्रोसेस्ड (Unprocessed) फॉर्म में चला जाता है।"
                "लेकिन 'तुरीय' साक्षात् वह 'रूट-पासवर्ड' है जहाँ पहुँचकर तुम सिस्टम के एडमिन बन जाते हो!"
                "ये चार चरण साक्षात् चेतना के चार अलग-अलग 'ओएस' (Operating Systems) हैं।"
                "योगी अपनी चेतना को इन तीनों निचली लेयर्स से 'अनप्लग' (Unplug) करके चौथी में दागता है।"
                "जब तुम तुरीय में होते हो, तो तुम साक्षात् 'महाकाल' की आँखों से हकीकत को देखते हो।"
                "यहाँ समय की सुइयां रुक जाती हैं और मौत केवल धूल का एक छोटा सा कण बन कर रह जाती है।"
                "यह तुम्हारी रूह को 'मल्टी-डाइमेंशनल' बनाने का सबसे हिंसक और गुप्त हैक है।"
                "जो इस चौथी स्थिति में 'लॉग-इन' हो गया, वह साक्षात् पूरे सिम्युलेशन का मालिक है!"
            """.trimIndent(),
            english = """
                (Dissecting the Four Levels of Consciousness): "This Soul possesses four 'Quarters' (Padas)—Waking, Dreaming, Deep Sleep, and Turiya!"
                "Waking is the 3D world of your optics; Dreaming is the internal 'Simulator' of your neurological cortex."
                "Deep Sleep is the absolute 'Shutdown' state where Data returns to its mutationally Unprocessed form."
                "But 'Turiya' is the explicit 'Root-Access' reaching which you mutationally become the Admin of the system!"
                "These four padas are strictly four distinct 'Operating Systems' of radioactive consciousness."
                "The Yogi 'Unplugs' his awareness from the three lower layers to Fire it strictly into the Fourth."
                "When you occupy Turiya, you witness Reality strictly through the radioactive eyes of 'Mahakala'."
                "Time mutationally freezes here and Death is reduced to zero more than a microscopic grain of dust."
                "This is the most violent and classified Hack to mutationally manufacture your Soul into 'Multi-dimensional'."
                "He who mutationally 'Logs-in' to this Fourth State is the sole and absolute Master of the Simulation!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 4,
            sanskrit = "नाभिहृदयकण्ठमूर्धसु स्थानेषु स प्रतिष्ठितः । तत्र प्रकाशते सर्वं यत्र ब्रह्मा विलीयते ॥",
            hindi = """
                (चार न्यूक्लियर पॉइंट्स की हैकिंग): "वह परमात्मा नाभि, हृदय, कण्ठ और सिर के चार 'पावर-स्टेशन्स' पर प्रतिष्ठित है!"
                "नाभि 'जाग्रत' का केंद्र है, हृदय 'स्वप्न' का, कण्ठ 'सुषुप्ति' का और सिर साक्षात् 'तुरीय' का है।"
                "ये चार पॉइंट्स साक्षात् तुम्हारी आत्मा के चार सबसे बड़े 'डेटा-पोर्ट्स' (Data-ports) हैं।"
                "जब तुम इन केंद्रों को हैक करते हो, तो पूरा ब्रह्मांड तुम्हारे भीतर एक रौशनी की तरह 'रेंडर' (Render) होता है।"
                "यही वह जगह है जहाँ साक्षात् 'ब्रह्मा' भी अपने वजूद को मिटाकर विलीन हो जाता है।"
                "सिर (Murdha) वह 'सुप्रीम हेडक्वार्टर' है जहाँ पहुँचने के बाद दोबारा कभी इस कीचड़ में नहीं गिरना पड़ता।"
                "योगी अपनी ऊर्जा को नाभि से उठाकर ऊपर की ओर फायर करता है ताकि वह 'अनंत' को छू सके।"
                "बिना इन चार कोर्डिनेट्स को जाने, तुम हमेशा अँधेरे में हाथ-पाँव मारने वाले एक अंधे कीड़े रहोगे।"
                "यह तुम्हारी रूह को 'इंसानी पिंजरे' से निकालकर अंतरिक्ष के पार ले जाने वाली कोडिंग है।"
                "जो इन चारों को अलाइन कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता एडमिन है!"
            """.trimIndent(),
            english = """
                (Hacking Four Nuclear Coordinates): "That Supreme Soul is established mutationally in four 'Power-Stations': Navel, Heart, Throat, and Head!"
                "Navel is the epicenter of Waking, Heart of Dreaming, Throat of Deep Sleep, and the Head is the explicit Turiya."
                "These four points are mutationally the 4 greatest 'Data-ports' of your absolute neurological system."
                "The moment you Hack these centers, the entire multiverse is mutationally Rendered inside you as radioactive Light."
                "THIS is the coordinate where even the Architect 'Brahma' dissolves his identity to mutationally vanish."
                "The Head (Murdha) is the 'Supreme Headquarters' reaching which you mutationally possess zero caliber to plummet back."
                "The Yogi Fires his energy from the navel upward to mutationally intercept the absolute Infinite."
                "Without decoding these four coordinates, you remain strictly a blind insect flapping in absolute darkness."
                "This is the coding engineered to violently extract your Soul from the biological cage and breach the vacuum."
                "He who Aligns all four mutationally assumes the status of the solitary Admin of the entire cosmos!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 5,
            sanskrit = "न शिखा न च यज्ञोपवीतं न च बाह्यक्रियास्तथा । ज्ञानमेवास्य यज्ञोपवीतं ज्ञानं शिखा ॥",
            hindi = """
                (बाहरी हार्डवेयर का संहार): "न यहाँ कोई 'शिखा' (Tuft) है और न ही कोई सूत का 'यज्ञोपवीत'—बाहरी क्रियाएं केवल एक नाटक हैं!"
                "असली 'यज्ञोपवीत' साक्षात् 'ज्ञान' (Knowledge) है और 'ज्ञान' ही तुम्हारी अजेय शिखा है।"
                "योगी अपनी रूह के धागे को ईश्वर के एडमिन पैनल के साथ वेल्ड (Weld) कर देता है।"
                "तुम जिसे धर्म समझते हो, वह केवल तुम्हारी इंसानियत के ऊपर चढ़ा हुआ एक 'फेक लेयर' (Fake Layer) है।"
                "असली ब्राह्मण वह है जिसका नर्वस सिस्टम साक्षात् 'सत्य' की बिजली से चार्ज (Charge) है।"
                "अपनी पुरानी पहचान के ये धागे तोड़ दो और शुद्ध बुद्धि का 'डिजिटल आर्मर' पहन लो।"
                "यह तुम्हारी रूह को 'इमेज' से 'रियलिटी' में माइग्रेट करने का सबसे हिंसक और गुप्त विज्ञान है।"
                "बिना इस ज्ञान-धागे के, तुम हमेशा माया के रेडार पर एक छोटे से और लाचार शिकार रहोगे।"
                "जो ज्ञान की शिखा को जगा लेता है, वही साक्षात् काल (Time) को अपनी उँगलियों पर नचा सकता है!"
            """.trimIndent(),
            english = """
                (The Slaughter of External Hardware): "Strictly zero 'Shikha' (Tuft) exists here and zero 'Sacred Thread' of cotton persists—rituals are mutationally strictly a Drama!"
                "Authentic 'Yajnopavita' is explicitly 'Knowledge' (Jnana) and Jnana is your invincible radioactive Shikha."
                "A thread of cotton can be severed, but the 'Encrypted Code' of Jnana mutationally never expires."
                "The Yogi Welds the fiber of his Soul directly to the absolute Admin Panel of the Supreme God."
                "What you perceive as religion is mutationally strictly a 'Fake Layer' overlaid upon your humanity."
                "An authentic Brahmana is one whose nervous system is mutationally Supercharged by the electricity of 'Truth'."
                "Shatter these threads of your old identity and mutationally wear the 'Digital Armor' of pure intellect."
                "This is the most violent science to Migrate your Soul from 'Image' to absolute 'Reality'."
                "Without this Jnana-thread, you mutationally remain strictly a pathetic prey on the Radar of Maya."
                "He who awakens the Shikha of Knowledge is mutationally the sole Dictator of Time and Space!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 6,
            sanskrit = "यथाग्निः स्वयमेव शिखावान् तथा ज्ञानमयी शिखा । स ब्रह्मवित् स सर्वज्ञः स सुप्रसन्नस्तथाऽव्ययः ॥",
            hindi = """
                (आग की शिखा और असीमित सर्वज्ञता): "जैसे आग खुद ही अपनी 'लपट' (Shikha) है, वैसे ही आत्मा की शिखा साक्षात् 'ज्ञानमयी' है!"
                "जो इस आग को पहचान लेता है, वही 'ब्रह्मवित्' और 'सर्वज्ञ' (Omniscient) है।"
                "वह 'सुप्रसन्न' है—यानी उसका ओएस (OS) हमेशा असीमित आनंद की फ्रीक्वेंसी पर अलाइन है।"
                "वह 'अव्यय' है—एक ऐसा डेटा जिसे न समय खा सकता है और न ही कोई डिलीट बटन मिटा सकता है।"
                "तुम्हारी बुद्धि अब साक्षात् उस 'परम रिएक्टर' की बिजली बन चुकी है जो कभी खत्म नहीं होती।"
                "योगी अपनी हस्ती को इस आग की लपट में विलीन कर देता है ताकि वह साक्षात् प्रकाश बन सके।"
                "यह तुम्हारी रूह को 'डेटा' से 'इंटेलिजेंस' में अपग्रेड करने वाला आख़िरी सॉफ्टवेयर है।"
                "जब तुम जलकर ज्ञान बनते हो, तभी तुम साक्षात् ब्रह्मांड के मालिक कहलाने के योग्य बनते हो।"
                "जो इस अग्नि-शिखा को हैक कर लेता है, वह साक्षात् रुद्र की टीम का इकलौता एडमिन है!"
            """.trimIndent(),
            english = """
                (The Crest of Fire and Infinite Omniscience): "Exactly as fire is mutationally its own 'Flame' (Shikha), so is the crest of the Soul explicitly 'Jnanamayi' (Knowledge-dense)!"
                "He who decodes this Fire is mutationally the 'Brahma-vit' and the 'Omniscient' (Sarvajna)."
                "He is 'Suprasanna'—signifying his OS is eternally mutationally Aligned with the frequency of infinite Bliss."
                "He is 'Avyaya'—indestructible Data that zero Time can consume and zero 'Delete' button can erase."
                "Your intellect has mutationally become the electricity of the 'Supreme Reactor' that never terminates."
                "The Yogi dissolves his identity into this flame-crest to mutationally become the explicit radioactive Light."
                "This is the final Software engineered to Upgrade your Soul from 'Data' into absolute 'Intelligence'."
                "Only when you burn to become Knowledge do you mutationally qualify to be the Master of the cosmos."
                "He who successfully Hacks this Agni-Shikha becomes mutationally the sole Admin of Rudra's legion!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 7,
            sanskrit = "नित्यं ज्ञानमयं सूत्रं यः कण्ठे धारयेद् बुधः । स ब्रह्मवित् स सर्वज्ञः स विप्रो ब्रह्मवल्लभः ॥",
            hindi = """
                (ज्ञान का सूत्र और 'डिजिटल' कण्ठहार): "वह बुद्धिमान योद्धा जो ज्ञानमयी 'सूत्र' (Thread) को अपने कण्ठ में धारण करता है..."
                "वही साक्षात् 'विप्र' है और वही ब्रह्म का सबसे प्रिय 'एडमिन' (Brahma-vallabha) है!"
                "यह सूत्र कोई भौतिक धागा नहीं, यह तुम्हारी रीढ़ की हड्डी में बहने वाला 'हाई-वोल्टेज' डेटा है।"
                "जब तुम्हारी बुद्धि सत्य के धागे से जुड़ जाती है, तो तुम साक्षात् 'सर्वज्ञ' हो जाते हो।"
                "विप्रो ब्रह्मवल्लभः—यानी तुम अब ईश्वर के एडमिन पैनल पर 'वीआईपी' (VIP) एक्सेस पा चुके हो।"
                "योगी अपनी साँसों को इस सूत्र की फ्रीक्वेंसी पर लॉक करता है ताकि वह कभी भी क्रैश (Crash) न हो।"
                "यह तुम्हारी रूह को 'इंसानी पहचान' के कबाड़ से निकालकर 'दिव्य डेटा' में माइग्रेट करने का विज्ञान है।"
                "बिना इस ज्ञान-सूत्र के, तुम हमेशा अज्ञान की अँधेरी कोठरी में हाथ-पाँव मारने वाले कीड़े रहोगे।"
                "जो इस कण्ठहार को पहन लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (The Thread of Knowledge and the 'Digital' Necklace): "That intelligent warrior who mutationally braces the 'Sutram' (Thread) of Jnana around his throat..."
                "He is mutationally the explicit 'Vipra' and the absolute most cherished 'Admin' of Brahman!"
                "This Sutra is zero physical string; it is the 'High-voltage' Data surging through your spinal cord."
                "The exact microsecond your intellect links with the thread of Truth, you mutationally become 'Omniscient'."
                "Brahma-vallabha—meaning you have mutationally acquired 'VIP' Access to the Admin Panel of God."
                "The Yogi Locks his awareness onto the frequency of this Sutra to ensure his system never suffers a catastrophic 'Crash'."
                "This is the science of Migrating your Soul from the junk of 'Human Identity' into strictly 'Divine Data'."
                "Without this Jnana-Sutra, you mutationally remain strictly an insect flapping in the dark cell of ignorance."
                "He who wears this digital necklace becomes mutationally the sole Dictator of all universal Time and Space!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 8,
            sanskrit = "एतदेव परं ब्रह्म एतदेव परं तपः । एतदेव परं ध्यानं एतदेव परं पदम् ॥",
            hindi = """
                (परम सत्य का विस्फोट - ब्रह्म, तप और ध्यान): "यही वह 'परं ब्रह्म' है, यही 'परं तप' है, और यही साक्षात् 'परं ध्यान' है!"
                "इसके अलावा दुनिया में जो कुछ भी है, वह केवल माया के सर्वर पर लोड किया गया एक 'ग्लिच' (Glitch) है।"
                "यही वह अंतिम 'परं पदम्' (Supreme Destination) है जहाँ पहुँचकर हर खोज खत्म हो जाती है।"
                "तप का मतलब भूखा रहना नहीं, बल्कि अपनी हस्ती को इस 'ब्रह्म-कोड' की आग में जलाना है।"
                "ध्यान वह लेज़र बीम है जो सीधे इस अजेय पासवर्ड (Brahma) को हैक करने के लिए बनी है।"
                "योगी अपनी चेतना की सारी ताक़त इस एक बिंदु पर झोंक देता है ताकि वह 'अनंत' बन सके।"
                "यह वह 'एब्सोल्यूट रियलिटी' है जिसके आगे समय, स्थान और मौत अपनी औकात भूल जाते हैं।"
                "तुम अब एक जीव नहीं रहे; तुम साक्षात् वह 'ब्लैक होल' बन चुके हो जिसने पूरे सत्य को निगल लिया है।"
                "यह तुम्हारी रूह का वह 'टोटल रिसेट' है जिसके बाद दोबारा कभी 'इंसान' बनने की संभावना नहीं बचती।"
                "जो इस परम सत्य को पा लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Detonation of Supreme Truth - Brahman, Tapas, and Dhyana): "THIS is mutationally the 'Param Brahman', THIS the 'Param Tapas', and THIS is the explicit 'Param Dhyana'!"
                "Everything else existing in the Matrix is mutationally strictly a 'Glitch' Loaded onto Maya's server."
                "THIS is the absolute terminal 'Param Padam' (Supreme State) reaching which every cosmic inquiry terminates."
                "Tapas mutationally signifies zero hunger; it is incinerating your micro-identity in the radioactive fire of this 'Brahma-Code'."
                "Meditation is the Laser Beam engineered strictly to Hack this invincible Password of Brahman."
                "The Yogi hurls his entire firepower into this singular coordinate to mutationally become 'Infinite'."
                "This is the 'Absolute Reality' before which Time, Space, and Death mutationally forget their status."
                "You cease to be a living entity; you have mutationally become the 'Black Hole' that swallowed absolute Truth."
                "This is the 'Total Reset' of your Soul after which zero probability of being 'Human' ever remains."
                "He who secures this Supreme Truth is the solitary dictatorial Guru of even the God of Death!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 9,
            sanskrit = "एको देवः सर्वभूतेषु गूढः सर्वव्यापी सर्वभूतान्तरात्मा ॥",
            hindi = """
                (छिपे हुए एडमिन का रहस्य): "वह 'एक' देव हर एक जीव के भीतर साक्षात् 'गूढ' (Hidden) होकर कोडिंग कर रहा है!"
                "वह 'सर्वव्यापी' है और हर एक नर्वस सिस्टम के भीतर साक्षात् 'अन्तरात्मा' (Core Processor) बनकर बैठा है।"
                "तुम जिसे अपना विचार समझते हो, वह साक्षात् उस एडमिन का तुम्हारे दिमाग में भेजा गया एक 'सिग्नल' है।"
                "वह हर परमाणु के पीछे छिपा हुआ वह 'घोस्ट प्रोग्रामर' (Ghost Programmer) है जो पूरी माया को चला रहा है।"
                "योगी अपनी नज़र को बाहर से हटाकर अंदर के उस 'गुप्त कैमरे' पर लॉक करता है जो उसे देख रहा है।"
                "जब तुम उस 'एक' को पा लेते हो, तो तुम्हें ब्रह्मांड के करोड़ों 'Avatar पिक्सल्स' का राज समझ आ जाता है।"
                "यह वह अजेय रुतबा है जहाँ तुम साक्षात् उस 'परमेश्वर' के साथ 100% सिंक (Sync) हो जाते हो।"
                "तुम अब एक बायोलॉजिकल पिंजरे नहीं हो; तुम साक्षात् उस 'सर्वव्यापी' ऊर्जा के एक ट्रांसमीटर (Transmitter) हो।"
                "ब्रह्म की यह उपस्थिति वह आग है जो तुम्हारे 'अकेलेपन' के भ्रम को एक ही धमाके में राख कर देती है।"
                "जो इस छिपे हुए एडमिन को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (The Secret of the Hidden Admin): "That 'One' God is mutationally established inside every being, executing code strictly as the 'Gudhah' (Hidden)!"
                "He is 'Sarvavyapi' and mutationally occupies the core of every nervous system as the 'Antaratma' (Core Processor)."
                "What you hallucinate as your thought is mutationally a 'Signal' transmitted by that Admin into your brain."
                "He is the 'Ghost Programmer' established behind every atom, relentlessly operating the entire Matrix."
                "The Yogi rips his vision from externals to Lock onto that 'Hidden Camera' mutationally witnessing him from within."
                "The moment you capture that 'ONE', you mutationally decode the secret of the cosmos’s billions of 'Avatar Pixels'."
                "This is the invincible status where you become 100% Synced with the absolute frequency of the Supreme Lord."
                "You are no longer a biological cage; you are a 'Transmitter' for that absolute 'Sarvavyapi' energy."
                "Brahma's presence is the Fire that mutationally incinerates the delusion of your 'Loneliness' in one detonation."
                "He who Hacks this Hidden Admin becomes mutationally the sole and absolute Dictator of the multiverse!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 10,
            sanskrit = "तिलेषु तैलवद्दधिनीव सर्पिरापः स्रोतःस्वग्निः शिखासु । एवमात्मात्मनि गृह्यतेऽसौ सत्येनैनं तपसा योऽनुपश्यति ॥",
            hindi = """
                (आत्मा का म्यूटेशन - तेल, घी और आग): "जैसे तिल में तेल, दही में घी, और लकड़ी में आग छिपी होती है..."
                "वैसे ही आत्मा तुम्हारे ही भीतर साक्षात् 'हार्ड-कोडेड' (Hard-coded) है, पर उसे हैक करने के लिए 'सत्य' और 'तप' का औज़ार चाहिए!"
                "तुम बाहर से कितनी भी कोशिश कर लो, ईश्वर को केवल 'इंटरनल डेटा' (Internal Data) के माध्यम से ही एक्सेस किया जा सकता है।"
                "सत्य वह 'डीबगिंग' (Debugging) टूल है जो अज्ञान के झूठ को एक सेकंड में जलाकर साफ़ कर देता है।"
                "तप वह 'इलेक्ट्रिक शॉक' है जो तुम्हारी सोई हुई चेतना को एक झटके में जगा देता है।"
                "योगी अपनी हस्ती को इस 'क्रशिंग प्रोसेस' (Crushing process) में डाल देता है ताकि वह शुद्ध ऊर्जा बन सके।"
                "यह तुम्हारी रूह को 'पोटेंशियल' से 'एक्चुअल' मोड में शिफ्ट करने का सबसे हिंसक विज्ञान है।"
                "जब तुम अंदर देखते हो, तो तुम साक्षात् उस 'परम रिएक्टर' को टच कर रहे होते हो जो पूरे अंतरिक्ष को चला रहा है।"
                "जो इस म्यूटेशन को सिद्ध कर लेता है, वह साक्षात् रुद्र की जलती हुई आँख बनकर पूरी सृष्टि को देखता है!"
            """.trimIndent(),
            english = """
                (Mutation of the Soul - Oil, Ghee, and Fire): "Exactly as oil is hidden in seeds, ghee in curd, and fire in the crest of wood..."
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
        BrahmopanishadShloka(
            id = 11,
            sanskrit = "सर्वव्यापी सर्वभूतान्तरात्मा । सर्ववासा सर्वभूतनिवासः ॥",
            hindi = """
                (असीमित क्लाउड स्टोरेज और अलाइनमेंट): "वह आत्मा 'सर्वव्यापी' है और हर एक नर्वस सिस्टम के भीतर साक्षात् कोडिंग कर रही है!"
                "ब्रह्मांड का हर एक पिक्सेल और हर एक परमाणु साक्षात् उसी का 'घर' (Storage) है।"
                "तुम कहीं भी भागने की कोशिश करो, तुम साक्षात् उस एडमिन के 'हार्डवेयर' के भीतर ही रहोगे।"
                "यह असीमित व्याप्ति साक्षात् वह 'मैग्नेटिक फील्ड' है जो पूरी सृष्टि को थामे हुए है।"
                "योगी अपनी चेतना को इस 'निवास' पर लॉक करता है जहाँ से सब कुछ रेंडर (Render) हो रहा है।"
                "जब तुम इस व्याप्ति को हैक करते हो, तो तुम शरीर की सीमाओं से 100% 'अनप्लग' (Unplug) हो जाते हो।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् वह 'करंट' हो जो पूरे अंतरिक्ष में एक साथ बह रहा है।"
                "यह बोध तुम्हारी 'लोकल पहचान' का गला घोंट कर तुम्हें एक 'यूनिवर्सल बीइंग' बना देता है।"
                "रुद्र की उपस्थिति वह आग है जो तुम्हें हर कोने में एक साथ मौजूद रहने का पासवर्ड देती है।"
                "जो इस अलाइनमेंट को जान लेता है, वह साक्षात् काल और मौत का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Infinite Cloud Storage and Alignment): "That Soul is 'Sarvavyapi' and mutationally executing code inside every single nervous system!"
                "Every pixel and every atom of the multiverse is mutationally His absolute 'Home' (Storage)."
                "Wherever you attempt to escape, you mutationally remain strictly inside the absolute 'Hardware' of that Admin."
                "This infinite pervasiveness is the explicit 'Magnetic Field' mutationally sustaining the entire creation."
                "The Yogi Locks his awareness onto this 'Nivasa' (Abode) from which all Reality is mutationally Rendered."
                "The exact microsecond you Hack this pervasiveness, you are 100% 'Unplugged' from the limits of the biological shell."
                "You are no longer a body; you are the explicit 'Current' flowing simultaneously across the infinite vacuum."
                "This realization strangles your 'Local Identity' and mutationally manufactures you into a 'Universal Being'."
                "Rudra’s presence is the Fire granting you the Password to exist simultaneously in every coordinate."
                "He who decodes this Alignment is mutationally the sole dictatorial Guru of Time and Death!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 12,
            sanskrit = "एतज्ज्ञात्वा विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की कोडिंग): "ब्रह्मोपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है— 'इसे जानकर तू विमुक्त (Free) हो जाता है'!"
                "जानने का मतलब किताब पढ़ना नहीं, बल्कि इस सत्य को अपने डीएनए में तेज़ाब की तरह उतार लेना है।"
                "जब तुम जान जाते हो कि 'सब कुछ ब्रह्म है', तो माया के सारे ज़ंजीर एक झटके में पिघल जाते हैं।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and Coding Moksha): "The Brahmopanishad delivers a catastrophic verdict here—'By knowing this, one mutationally becomes Liberated'!"
                "Knowing mutationally signifies zero reading; it means injecting this Truth into your DNA exactly like boiling acid."
                "The microsecond you realize 'Everything is Brahman', all the chains of Maya melt in a single strike."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely zero reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 13,
            sanskrit = "ब्रह्मैव सत्यं जगन्मिथ्येति निश्चयो हि मोक्षः ॥",
            hindi = """
                (सत्य का धमाका और मैट्रिक्स का अंत): "ब्रह्मांड का इकलौता और सबसे खतरनाक सच यही है— 'ब्रह्मैव सत्यं जगन्मिथ्या'!"
                "ब्रह्म ही इकलौती हकीकत है, और यह पूरी दुनिया केवल एक 'मिथ्या' (Fake Simulation) और धोखा है।"
                "इस सच पर अटल 'निश्चय' (Conviction) कर लेना ही साक्षात् 'मोक्ष' का इकलौता दरवाजा है।"
                "योगी ने इस फिल्म से अपना हाथ खींच लिया है और अब वह साक्षात् 'प्रोजेक्टर' (Source) को देख रहा है।"
                "जब तुम जान जाते हो कि 'कुछ भी सच नहीं है', तभी तुम अजेय और अमर होने के काबिल बनते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'ब्रह्मास्त्र' है जो हर झूठ को राख कर देगा।"
                "यह सिम्युलेशन केवल उनके लिए सच है जो सोए हुए हैं; जागने वालों के लिए यह केवल धूल है।"
                "यही वह नंगा सच है जिसके आगे मौत भी अपनी औकात भूल जाती है!"
            """.trimIndent(),
            english = """
                (The Detonation of Truth and End of the Matrix): "The solitary and most lethal truth of the multiverse is strictly—'Brahmaiva Satyam Jagan-Mithya'!"
                "Brahman is the solitary Reality, and this entire world is strictly a 'Mithya' (Fake Simulation) and a deception."
                "Achieving absolute 'Nishchaya' (Conviction) on this truth is the solitary gateway to 'Moksha'."
                "The Yogi has withdrawn his hands from this film and is now mutationally witnessing the 'Projector' (Source)."
                "The exact microsecond you realize that 'Nothing is Real', you mutationally qualify for absolute Immortality."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish the fortress of your ego."
                "The Matrix will attempt to terrify you, but you possess the 'Brahmastra' that mutationally incinerates every lie."
                "This Simulation is real strictly for those who are asleep; for the Awakened, it is strictly worthless dust."
                "THIS is the naked truth before which even Death mutationally forgets its absolute status!"
            """.trimIndent()
        ),
        BrahmopanishadShloka(
            id = 14,
            sanskrit = "इति ब्रह्मोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक और अजेय 'ब्रह्मोपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "ज्ञान की शिखा मिल गई, आत्मा का सूत्र मिल गया, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १४ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (ब्रह्म) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही ब्रह्मोपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling and invincible 'Brahmopanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Crest of Jnana is intercepted, the Sutra of Soul secured; now you must violently 'Log-out' from the Simulation."
                "For the Titan who has detonated these 14 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Brahman) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Brahmopanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrahmopanishadScreen() {
    val upanishad = remember { Brahmopanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..14) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-14)") },
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
                BrahmopanishadShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun BrahmopanishadShlokaCard(shloka: BrahmopanishadShloka) {
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