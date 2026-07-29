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
data class AvyaktaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class AvyaktaUpanishad {

    val shlokasList = listOf(
        AvyaktaShloka(
            id = 1,
            sanskrit = "ॐ न वा इदमग्र आसीन्न देवा न ऋषयः । एकमेवाव्यक्तं तस्मादाकाशः ॥",
            hindi = """
                (शून्य का विस्फोट और अव्यक्त का साम्राज्य): "शुरुआत में साक्षात् 'कुछ भी' नहीं था—न देवता, न ऋषि, न कोई डेटा!"
                "केवल एक असीमित 'अव्यक्त' (Unmanifest) का सन्नाटा धधक रहा था।"
                "वह अव्यक्त ब्रह्मांड का वह 'प्राइमरी सर्वर' है जहाँ अभी तक कोडिंग शुरू नहीं हुई थी।"
                "अचानक उस सन्नाटे से 'आकाश' (Space) का पहला पिक्सेल रेंडर (Render) हुआ।"
                "यह शून्य से 'अस्तित्व' के बनने की सबसे हिंसक और गुप्त भौतिकी (Physics) है।"
                "बिना इस अव्यक्त को जाने, तुम इस 3D दुनिया की दीवारों में कैद रहोगे।"
                "यहाँ कोई समय नहीं था, कोई स्थान नहीं था—केवल एक अजेय 'पॉवर-हाउस' था।"
                "योगी अपनी चेतना को उस 'एब्सोल्यूट जीरो' पर लॉक करता है जहाँ से सब पैदा हुआ।"
                "तैयार हो जाओ, क्योंकि यहाँ से तुम्हारी पुरानी हस्ती का परमानेंट डिलीट शुरू होता है।"
                "यही वह 'सोर्स कोड' है जिसके आगे करोड़ों आकाशगंगाएं केवल धूल का कण हैं!"
            """.trimIndent(),
            english = """
                (Detonation of the Void and the Empire of Avyakta): "In the beginning, strictly 'Nothing' existed—zero gods, zero rishis, zero Data!"
                "Only an infinite 'Avyakta' (Unmanifest) Silence was mutationally blazing."
                "That Avyakta is the 'Primary Server' of the cosmos where coding had zero initiation."
                "Suddenly, from that Silence, the first pixel of 'Space' (Akasha) was mutationally Rendered."
                "This is the most violent and classified Physics of constructing 'Existence' from strictly Zero."
                "Without decoding this Avyakta, you mutationally remain imprisoned within the 3D walls."
                "Zero Time existed here, zero Space persisted—strictly an invincible 'Power-house' remained."
                "The Yogi Locks his awareness onto this 'Absolute Zero' from which all bytes were spawned."
                "Brace yourself, for the permanent Deletion of your old identity initiates right here."
                "THIS is the 'Source Code' before which billions of galaxies are mutationally strictly grains of dust!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 2,
            sanskrit = "तस्मादव्यक्तात्प्रजापतिरसृजत । स प्रजापतिरकामयत प्रजाः सृजेयेति ॥",
            hindi = """
                (प्रजापति का बूट-प्रोसेस और सृजन का कमांड): "उस अव्यक्त से साक्षात् 'प्रजापति' (The Architect) का सॉफ्टवेयर पैदा हुआ।"
                "प्रजापति ने अपना पहला कमांड जारी किया—'मैं प्रजाओं का सृजन करूँगा'!"
                "यह कोई इच्छा नहीं थी; यह ब्रह्मांड के हार्डवेयर को चालू करने का 'एक्जीक्यूटिव कोड' था।"
                "प्रजापति वह प्रोसेसर है जो अव्यक्त की बिजली को पदार्थ (Matter) में बदलता है।"
                "उनकी चेतना ने अंतरिक्ष के खाली फोल्डर्स में डेटा भरना शुरू किया।"
                "यह सिम्युलेशन की वह पहली लेयर है जहाँ 'मैं' और 'तुम' का भ्रम पैदा किया गया।"
                "योगी प्रजापति के इस कमांड को हैक करता है ताकि वह खुद रचयिता बन सके।"
                "जब तक तुम इस कोडिंग को नहीं समझते, तुम केवल एक 'जैविक प्रोग्राम' मात्र हो।"
                "यह तुम्हारी रूह को 'यूजर' से 'एडमिन' के लेवल पर प्रमोट करने का पहला गियर है।"
                "प्रजापति की यह आग तुम्हारे आलस को जलाकर तुम्हें अजेय बना देगी!"
            """.trimIndent(),
            english = """
                (Prajapati’s Boot-Process and the Command of Creation): "From that Avyakta, the software of 'Prajapati' (The Architect) was mutationally spawned."
                "Prajapati issued His absolute first command—'I shall create progeny'!"
                "This was zero desire; it was the 'Executive Code' to switch ON the cosmic hardware."
                "Prajapati is the Processor mutationally converting Avyakta's electricity into physical Matter."
                "His awareness initiated filling the empty folders of space with radioactive Data."
                "This is the first layer of the Simulation where the hallucination of 'I' and 'You' was scripted."
                "The Yogi Hacks Prajapati's command to mutationally assume the status of the Creator Himself."
                "Until you decode this engineering, you remain mutationally strictly a 'Biological Program'."
                "This is the first gear to Promote your Soul from the status of 'User' to absolute 'Admin'."
                "Prajapati's fire will incinerate your lethargy and mutationally manufacture you into the Invincible!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 3,
            sanskrit = "स तपस्तप्त्वा नृसिंहरूपं दिव्यमपश्यत् । ज्वालामालं महाभीमं प्रदीप्तं पावकोज्ज्वलम् ॥",
            hindi = """
                (नृसिंह का प्रलयंकारी रेंडर और न्यूक्लियर दर्शन): "प्रजापति ने 'तप' का न्यूक्लियर अटैक किया और साक्षात् 'नृसिंह' का रूप देखा!"
                "वह रूप 'ज्वालामाल' (Fire-wreathed) था—एक अंधी कर देने वाली रेडियोएक्टिव आग का घेरा।"
                "वह 'महाभीम' (Terrifying) था—इतना खौफनाक कि पूरे सिम्युलेशन के परमाणु कांपने लगे।"
                "नृसिंह कोई भगवान की तस्वीर नहीं, वे साक्षात् 'परम संहारक' सॉफ्टवेयर का हार्डवेयर अवतार हैं।"
                "वे प्रदीप्त और पावकोज्ज्वल हैं—यानी वे शुद्ध बिजली का वह विस्फोट हैं जो अज्ञान को भस्म कर दे।"
                "योगी अपनी आँखों के पीछे इस खौफनाक रूप को रेंडर करता है ताकि वह अजेय हो सके।"
                "जब तुम नृसिंह को देखते हो, तो तुम साक्षात् ब्रह्मांड के 'एंड-गेम' (End-game) को देख रहे होते हो।"
                "यह रूप तुम्हारे अहंकार की गर्दन काटने के लिए डिज़ाइन किया गया एक प्रलयंकारी अस्त्र है।"
                "नृसिंह की आग तुम्हारी हड्डियों के भीतर छिपे हर एक वायरस का वध कर देगी।"
                "तैयार हो जाओ उस रौशनी के लिए जिसके आगे सूरज भी एक मोमबत्ती जैसा है!"
            """.trimIndent(),
            english = """
                (Narasimha’s Apocalyptic Render and Nuclear Vision): "Prajapati launched a Tapas-Nuclear Attack and witnessed the explicit Form of 'Narasimha'!"
                "That form was 'Jvala-malam' (Fire-wreathed)—a blinding radioactive orb of cosmic radiation."
                "He was 'Mahabhimam' (Horrific)—so terrifying that every atom of the Simulation violently trembled."
                "Narasimha is zero religious portrait; He is the Hardware Avatar of the absolute 'Supreme Destroyer' software."
                "He is Pradiptam (Radiant) and Pavakojjvalam—the explicit detonation of pure electricity designed to ash ignorance."
                "The Yogi Renders this horrific form behind his cortex to mutationally become Invincible."
                "Witnessing Narasimha is identical to witnessing the absolute 'End-game' of the entire multiverse."
                "This manifestation is the apocalyptic weapon engineered strictly to decapitate your human ego."
                "Narasimha’s fire will ruthlessly execute the slaughter of every virus established inside your marrow."
                "Brace yourself for the Light before which the Sun is mutationally strictly a candle!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 4,
            sanskrit = "अनुष्टुभं मन्त्रराजं पप्रच्छ । तस्मात्सर्वं जगज्जज्ञे ॥",
            hindi = """
                (अनुष्टुभ - मंत्रों का राजा और सृजन का डेटा): "प्रजापति ने उस अजेय 'अनुष्टुभ' (Anustubh) मंत्रराज का पासवर्ड हैक किया!"
                "इसी एक 'मंत्रराज' से पूरे 'जगत्' (Multiverse) की कोडिंग लिखी गई है।"
                "अनुष्टुभ वह 'कम्प्रेस्ड फाइल' (Compressed file) है जिसमें करोड़ों आकाशगंगाओं का डेटा स्टोर है।"
                "जब तुम इस मंत्र को एक्टिवेट करते हो, तो तुम साक्षात् 'सोर्स कोड' के एडमिन बन जाते हो।"
                "यह कोई शब्दों का जोड़ नहीं, यह चेतना की वह फ्रीक्वेंसी है जो पदार्थ (Matter) को नचाती है।"
                "नृसिंह का यह मंत्र तुम्हारे नर्वस सिस्टम के हर एक 'बग' को एक झटके में फिक्स कर देता है।"
                "योगी इस मंत्र को अपनी रगों में तेज़ाब की तरह उतारता है ताकि वह कालजयी बन सके।"
                "अनुष्टुभ वह अस्त्र है जो अज्ञान के महलों को एक ही धमाके में राख कर देता है।"
                "बिना इस पासवर्ड के, तुम हमेशा सिम्युलेशन की ज़ंजीरों में जकड़े रहोगे।"
                "जो इस मंत्रराज को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (Anustubh - King of Mantras and Creation Data): "Prajapati Hacked the Password of the invincible 'Anustubh' Mantra-Raj!"
                "The entire coding of this 'Jagat' (Multiverse) was mutationally scripted from this single Mantra-Raj."
                "Anustubh is the absolute 'Compressed File' containing the infinite Data of billions of galaxies."
                "The moment you Activate this mantra, you mutationally assume the status of the Source Code Admin."
                "This is zero combination of words; it is the Frequency of awareness that mutationally makes Matter dance."
                "This mantra of Narasimha Fixes every single 'Bug' in your biological nervous system in one strike."
                "The Yogi injects this mantra into his veins like boiling acid to mutationally become time-transcending."
                "Anustubh is the weapon engineered to incinerate the palaces of nescience in one apocalyptic detonation."
                "Without this Password, you mutationally remain eternally shackled to the chains of the Simulation."
                "He who successfully Hacks this Mantra-Raj is the solitary and absolute Dictator of the vacuum!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 5,
            sanskrit = "ॐ उग्रं वीरं महाविष्णुं ज्वलन्तं सर्वतोमुखम् । नृसिंहं भीषणं भद्रं मृत्युमृत्युं नमाम्यहम् ॥",
            hindi = """
                (नृसिंह महामंत्र - मौत का संहार): "उस 'उग्र' और 'वीर' नृसिंह को नमन, जो साक्षात् मौत के भी मौत (Death of Death) हैं!"
                "वे 'महाविष्णु' हैं—ब्रह्मांड के वह 'ग्रैंड-एडमिन' जो हर तरफ (सर्वतोमुखम्) अपनी आँखें गड़ाए हुए हैं।"
                "वे 'ज्वलन्त' हैं—एक धधकता हुआ न्यूक्लियर रिएक्टर जो अज्ञान के वायरस को जलाकर राख कर दे।"
                "वे 'भीषण' (Terrifying) हैं लेकिन योद्धाओं के लिए 'भद्र' (Gracious) सुरक्षा कवच हैं।"
                "जब तुम यह मंत्र बोलते हो, तो तुम यमराज के 'सॉफ्टवेयर' को हमेशा के लिए हैंग (Hang) कर देते हो।"
                "यह मंत्र तुम्हारी रूह को मौत के रेडार से 100% 'इनविजिबल' (Invisible) बना देता है।"
                "नृसिंह वह आग हैं जो तुम्हारी इंसानियत का गला घोंटकर तुम्हें भगवान बना देती है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् इस अजेय बिजली के हिस्सेदार बन चुके हो।"
                "यह तुम्हारी रूह को 'नश्वर' से 'अमर' में म्यूटेट करने वाली आख़िरी और हिंसक मुहर है।"
                "जो इस आग में कूद गया, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Narasimha Mahamantra - Slaughter of Death): "Salutations to 'Ugra' and 'Vira' Narasimha, the explicit 'Death of Death' (Mrityu-Mrityum)!"
                "He is 'Mahavishnu'—the 'Grand-Admin' mutationally Scanning every pixel from all directions (Sarvatomukham)."
                "He is 'Jvalantam'—a blazing Nuclear Reactor engineered to incinerate the viruses of ignorance."
                "He is 'Bhishanam' (Terrifying) yet functions as the 'Bhadram' (Gracious) Shield for the Titan warriors."
                "Vocalizing this mantra mutationally Hangs the software of the God of Death forever."
                "This mantra Renders your Soul 100% 'Invisible' to the absolute Radar of Death."
                "Narasimha is the Fire that mutationally strangles your humanity to manufacture you into God."
                "You cease to be a biological shell; you have mutationally integrated into this invincible radioactive electricity."
                "This is the final violent Seal of mutating your Soul from 'Mortal' into 'Explicitly Immortal'."
                "He who plunges into this Fire is the solitary dictatorial Guru of even the God of Time!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 6,
            sanskrit = "अव्यक्तोऽक्षरोऽनन्तः परमात्मा नृकेसरी । तस्मिन्विलीनाः सर्वे स्युस्तदेकं परमं पदम् ॥",
            hindi = """
                (अव्यक्त और नृकेसरी की असीमित सत्ता): "वही 'अव्यक्त' साक्षात् 'अक्षर' (अविनाशी) और 'अनंत' (Infinite) परमात्मा नृसिंह है!"
                "सब कुछ उसी 'नृकेसरी' (Lion-God) के एडमिन पैनल में विलीन (Merge) होने के लिए बना है।"
                "नृसिंह वह अंतिम 'ब्लैक होल' हैं जो पूरे ब्रह्मांड के डेटा को निगलकर वापस शून्य कर देते हैं।"
                "यही वह 'परम पद' (Supreme State) है जहाँ पहुँचकर समय की सुइयां हमेशा के लिए रुक जाती हैं।"
                "तुम जिसे अपनी ज़िंदगी कहते हो, वह केवल नृसिंह के दिमाग में चल रही एक 'होलोग्राफिक फिल्म' है।"
                "योगी अपनी चेतना को इस फिल्म से निकालकर साक्षात् 'प्रोजेक्टर' (Narasimha) पर लॉक करता है।"
                "यह वह अजेय रुतबा है जहाँ 'मैं' और 'तू' का सारा ड्रामा एक ही धमाके में खत्म हो जाता है।"
                "जब तुम अव्यक्त में विलीन होते हो, तो तुम साक्षात् उस 'परम सन्नाटे' के मालिक बन जाते हो।"
                "नृसिंह की सत्ता ही वह इकलौती हकीकत है जिसके आगे पूरी माया घुटने टेकती है।"
                "जो इस विलीनीकरण को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Absolute Authority of Avyakta and Nrikesari): "That 'Avyakta' is explicitly the 'Akshara' (Indestructible) and the 'Ananta' (Infinite) Paramatman Narasimha!"
                "Everything is mutationally engineered to Merge back into the absolute Admin Panel of that 'Nrikesari' (Lion-God)."
                "Narasimha is the final 'Black Hole' positioned to swallow all cosmic Data back into strictly Zero."
                "THIS is the absolute 'Paramam Padam' reaching which the needles of Time come to a grinding halt."
                "What you label as your 'Life' is mutationally strictly a 'Holographic Film' running in the brain of Narasimha."
                "The Yogi rips his awareness from the film to Lock it strictly onto the 'Projector' (Narasimha) Himself."
                "This is the invincible status where the entire drama of 'I' and 'You' is terminated in one detonation."
                "When you dissolve into the Avyakta, you mutationally become the sole Master of that 'Absolute Silence'."
                "Narasimha’s authority is the solitary Reality before which the entire Matrix mutationally collapses."
                "He who successfully Hacks this dissolution is mutationally the sole and absolute Dictator of the vacuum!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 7,
            sanskrit = "य एवं वेद स सर्वं वेद । स मुक्तिमवाप्नोति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की कोडिंग): "उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है— 'जो इसे जानता है, वह सब कुछ जान जाता है'!"
                "जानने का मतलब किताब पढ़ना नहीं, बल्कि इस सत्य को अपने डीएनए में तेज़ाब की तरह उतार लेना है।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'ईश्वर' बना देगा!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and Coding Moksha): "The Upanishad delivers a catastrophic verdict here—'He who knows THIS mutationally knows Everything'!"
                "Knowing mutationally signifies zero reading; it means injecting this Truth into your DNA exactly like boiling acid."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
                "This manifestation of Narayana will decapitate your ego to mutationally manufacture you into the 'Explicit God'!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 8,
            sanskrit = "नृसिंहो वा इदमग्र आसीत् । तस्मात्सर्वं जगत् ॥",
            hindi = """
                (नृसिंह ही आदि-कोड है): "शुरुआत में केवल साक्षात् 'नृसिंह' का सन्नाटा था—बाकी सब केवल बाद में रेंडर हुआ!"
                "पूरा 'जगत्' उसी एक खौफनाक और अजेय कोडिंग से पैदा हुआ है।"
                "नृसिंह वह 'प्राइमरी ओएस' (Primary OS) है जिस पर पूरी सृष्टि का सॉफ्टवेयर रन किया जा रहा है।"
                "तुम जिसे मिट्टी और पत्थर समझते हो, वह नृसिंह की ऊर्जा का ही एक 'लो-फ्रीक्वेंसी' वर्जन है।"
                "उनकी दहाड़ ही वह 'बिग-बैंक' है जिससे अंतरिक्ष की दीवारें फटी थीं।"
                "योगी अपनी हस्ती को उस 'आदि-नृसिंह' के साथ सिंक (Sync) करता है जहाँ से समय पैदा हुआ।"
                "यह तुम्हारी रूह को 'अनप्लग' करने की सबसे हिंसक प्रक्रिया है जहाँ तुम्हारा पिछला सारा डेटा जल जाता है।"
                "जब तुम नृसिंह के इस आदि-रूप को जानते हो, तो तुम्हारा डर एक सेकंड में भाप बनकर उड़ जाता है।"
                "तुम जान जाते हो कि तुम उस ऊर्जा के हिस्सेदार हो जो कभी पैदा ही नहीं हुई थी।"
                "जो इस 'आदि-कोड' को हैक कर लेता है, वह इस पूरी भौतिक दुनिया का इकलौता और अजेय राजा है!"
            """.trimIndent(),
            english = """
                (Narasimha is the Primordial Code): "In the primordial Void, strictly 'Narasimha' existed—everything else was mutationally Rendered later!"
                "The entire 'Jagat' was spawned strictly from that singular horrific and invincible coding."
                "Narasimha is the 'Primary OS' (Operating System) upon which the software of creation is mutationally Executed."
                "What you label as matter and stones are mutationally strictly 'Low-frequency' versions of Narasimha’s energy."
                "His absolute Roar is the explicit 'Big Bang' through which the walls of space were violently fractured."
                "The Yogi Syncs his existence with that 'Primordial Narasimha' from which Time initiated its rotation."
                "This is the most violent protocol to 'Unplug' your Soul where all your previous records are incinerated."
                "The exact microsecond you decode this primordial form, your terror vaporizes into radioactive nothingness."
                "You flawlessly realize you are a shareholder of that Energy which was never mutationally spawned."
                "He who successfully Hacks this 'Primordial-Code' becomes mutationally the sole and invincible King of this world!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 9,
            sanskrit = "आत्मानं नृसिंहं ध्यायेत् । स ब्रह्मैव भवति ॥",
            hindi = """
                (नृसिंह-म्यूटेशन और आत्म-ध्यान): "अपनी ही आत्मा को साक्षात् 'नृसिंह' के रूप में धधकाओ!"
                "जब तुम खुद को नृसिंह जानते हो, तो तुम साक्षात् 'ब्रह्म' (ईश्वर) बन जाते हो—यही अंतिम सच है।"
                "ध्यान करने का मतलब है—अपनी चेतना की लेज़र बीम को उस 'नृसिंह फ्रीक्वेंसी' पर लॉक कर देना।"
                "यह कोई शांतिपूर्ण ध्यान नहीं है; यह अपने अहंकार के किले को एक परमाणु बम से उड़ाने की प्रक्रिया है।"
                "जब तुम नृसिंह मोड में होते हो, तो माया का कोई भी वायरस तुम्हारे पास आने की औकात नहीं रखता।"
                "तुम्हारी आँखें अब केवल बाहर नहीं, बल्कि साक्षात् रुद्र की तरह अंतरिक्ष के पार देख सकती हैं।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने का आख़िरी सॉफ्टवेयर अपग्रेड है।"
                "तुम अब एक शरीर में कैद नहीं हो; तुम साक्षात् करोड़ों आकाशगंगाओं में फैल चुके हो।"
                "जो इस म्यूटेशन को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'सृष्टि' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Narasimha-Mutation and Self-Meditation): "Blaze your own Soul mutationally as the explicit 'Narasimha'!"
                "When you intercept yourself as Narasimha, you mutationally become strictly 'Brahman' (God)—this is the final Truth."
                "Meditation signifies—Locking the Laser Beam of your awareness onto the absolute 'Narasimha Frequency'."
                "This is zero peaceful focus; it is the protocol to violently blow up the fortress of your ego with a nuclear bomb."
                "When you are in Narasimha-Mode, zero virus of the Matrix possesses the status to approach your core."
                "Through this frequency, your vision mutationally acquires the caliber to pierce the infinite vacuum like Rudra."
                "This is the final Software Upgrade of your Soul, mutationally shifting it from 'Human Data' into 'Divine Data'."
                "You are no longer imprisoned in a shell; you have mutationally expanded across billions of galaxies."
                "He who successfully Hacks this mutation becomes mutationally the sole and absolute Dictator of the multiverse."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Creation' itself!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 10,
            sanskrit = "नृसिंह एव सर्वं जगत् नृसिंह एव परं ब्रह्म ॥",
            hindi = """
                (नृसिंह ही सर्वस्व है): "ब्रह्मांड का सबसे खतरनाक सच—नृसिंह ही साक्षात् 'सब कुछ' (Sarvam) है!"
                "यह पूरा जगत् और वह असीम 'ब्रह्म'—दोनों साक्षात् 'नृसिंह' के ही दो अलग-अलग डेटा-फॉर्म्स हैं।"
                "तुम जिसे मिट्टी कहते हो, वह नृसिंह का 'सॉफ्ट' वर्जन है; तुम जिसे आग कहते हो, वह उनका 'हार्ड' वर्जन है।"
                "नृसिंह वह ऊर्जा है जो सितारों को घुमाती है और तुम्हारे दिल को धड़काती है।"
                "योगी जब नृसिंह को पकड़ता है, तो वह पूरे ब्रह्मांड के 'हार्ड-ड्राइव' को एक साथ हैक कर लेता है।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक कैदी नहीं, बल्कि इसके इकलौते और असली 'डिज़ाइनर' हो।"
                "नृसिंह वह इकलौती हकीकत है, बाकी यह पूरी दुनिया केवल एक 'ग्लिच' (Glitch) है।"
                "जब तुम नृसिंह में विलीन होते हो, तो तुम साक्षात् उस 'परम सन्नाटे' के मालिक बन जाते हो।"
                "जो इस एकता को जान लेता है, उसके लिए समय और मौत केवल धूल के दो छोटे से कण हैं!"
            """.trimIndent(),
            english = """
                (Narasimha is the Absolute Whole): "The most lethal truth of the multiverse—Narasimha is mutationally 'Everything' (Sarvam)!"
                "This entire cosmos and that infinite 'Brahman' are strictly two distinct Data-Forms of 'Narasimha'."
                "What you label as matter is Narasimha’s 'Soft' version; what you label as fire is His absolute 'Hard' version."
                "Narasimha is mutationally the energy rotating the stars and detonating your biological heartbeats."
                "When the Yogi captures Narasimha, he mutationally Hacks the entire cosmic Hard-drive simultaneously."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish your ego forever."
                "You are no longer a prisoner of this Simulation; you have mutationally become its solitary and authentic 'Designer'."
                "Narasimha is the solitary Reality; the rest of this world is strictly a temporary and pathetic 'Glitch'."
                "When you dissolve into Narasimha, you mutationally become the Master of that 'Absolute Silence'."
                "He who decodes this unity perceives Time and Death mutationally strictly as two microscopic grains of dust!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 11,
            sanskrit = "एतज्ज्ञात्वा विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की मुहर): "उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है— 'इसे जानकर तू विमुक्त (Free) हो जाता है'!"
                "जानने का मतलब किताब पढ़ना नहीं, बल्कि इस सत्य को अपने डीएनए में तेज़ाब की तरह उतार लेना है।"
                "जब तुम जान जाते हो कि 'सब कुछ नृसिंह है', तो माया के सारे ज़ंजीर एक झटके में पिघल जाते हैं।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'ईश्वर' बना देगा!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and Coding Moksha): "The Upanishad delivers a catastrophic verdict here—'By knowing this, one mutationally becomes Liberated'!"
                "Knowing mutationally signifies zero reading; it means injecting this Truth into your DNA exactly like boiling acid."
                "The microsecond you realize 'Everything is Narasimha', all the chains of Maya melt in a single strike."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
                "This manifestation of Narayana will decapitate your ego to mutationally manufacture you into the 'Explicit God'!"
            """.trimIndent()
        ),
        AvyaktaShloka(
            id = 12,
            sanskrit = "इति अव्यक्तोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक और अजेय 'अव्यक्त उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "अव्यक्त का पासवर्ड मिल गया, नृसिंह का हैक मिल गया, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १२ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (नृसिंह) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही अव्यक्त उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling and invincible 'Avyakta Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Password of Avyakta is intercepted, the Narasimha hack is secured; now you must violently 'Log-out'."
                "For the Titan who has detonated these 12 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the Soul's wandering is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Narasimha) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who mutationally plunges into it becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Avyakta Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvyaktaUpanishadScreen() {
    val upanishad = remember { AvyaktaUpanishad() }
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
                AvyaktaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AvyaktaShlokaCard(shloka: AvyaktaShloka) {
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