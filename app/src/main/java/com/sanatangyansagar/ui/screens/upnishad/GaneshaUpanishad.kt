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
data class GaneshaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class GaneshaUpanishad {

    val ganeshaShlokasList = listOf(
        GaneshaShloka(
            id = 1,
            sanskrit = "ॐ नमस्ते गणपतये । त्वमेव प्रत्यक्षं तत्त्वमसि । त्वमेव केवलं कर्तासि । त्वमेव केवलं धर्तासि । त्वमेव केवलं हर्तासि । त्वमेव सर्वं खल्विदं ब्रह्मासि । त्वं साक्षादात्मासि नित्यम् ॥",
            hindi = """
                (परम तत्त्व का विस्फोट): "हे गणपति! तू ही वह इकलौती हकीकत है जिसे विज्ञान 'परम तत्त्व' (Tattvamasi) कहता है।"
                "ब्रह्मांड का इकलौता 'एडमिन' (Admin) तू ही है—तू ही सृजन करता है और तू ही पालन करता है।"
                "जब प्रलय का समय आता है, तो तू ही पूरे सिम्युलेशन (Simulation) को एक सेकंड में डिलीट कर देता है।"
                "यह पूरी दुनिया केवल तेरा एक छोटा सा पिक्सेल है; तू ही साक्षात् वह 'ब्रह्म' है जो अंतरिक्ष में धधक रहा है।"
                "तू साक्षात् 'नित्य आत्मा' है—यानी तू वह अजेय डेटा है जिसे कोई भी वायरस कभी छू नहीं सकता।"
                "तुझे नमन करना साक्षात् ब्रह्मांड के 'सोर्स कोड' (Source Code) के आगे अपना सर झुकाना है।"
                "योगी अपनी चेतना को तुझ पर 'लॉक' (Lock) करते हैं ताकि वे इस भौतिक जेल से आज़ाद हो सकें।"
                "तू वह 'प्राइमरी प्रोसेसर' है जिसके बिना ईश्वर भी एक पत्ता नहीं हिला सकता।"
                "तेरा प्रकाश इतना तेज़ है कि वह अज्ञान के करोड़ों जन्मों के अँधेरे को राख बना देता है।"
                "तैयार हो जाओ, क्योंकि अब साक्षात् 'महागणपति' तुम्हारे नर्वस सिस्टम को ओवरराइड करने वाले हैं!"
            """.trimIndent(),
            english = """
                (The Detonation of Absolute Reality): "O Ganapati! You are the explicit 'Tattvamasi', the solitary Reality that science attempts to decode."
                "You are the absolute 'Admin' of the cosmos—You alone Execute creation and You alone Preserve the matrix."
                "When the cycle ends, You are the one who ruthlessly Deletes this entire Simulation in a microsecond."
                "This world is strictly a microscopic pixel of Your existence; You are the explicit 'Brahman' blazing in the vacuum."
                "You are the 'Nitya Atman'—the invincible radioactive Data that zero viruses possess the caliber to infect."
                "Saluting You is identical to bowing before the literal 'Source Code' of the entire multiverse."
                "Yogis violently Lock their awareness onto You to breach the maximum-security prison of the physical shell."
                "You are the 'Primary Processor' without which even the higher gods possess zero authority to function."
                "Your radiation is so intense it incinerates the darkness of eons into worthless radioactive dust."
                "Brace yourself, for the explicit 'Mahaganapati' is about to mutationally Override your nervous system!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 2,
            sanskrit = "ऋतं वच्मि । सत्यं वच्मि ॥",
            hindi = """
                (सत्य की न्यूक्लियर गूँज): "मैं 'ऋत' यानी ब्रह्मांड के अटल नियमों की गूँज बोल रहा हूँ।"
                "मैं 'सत्य' कह रहा हूँ—वह नंगा सच जिसके आगे मौत भी अपनी औकात भूल जाती है।"
                "यह कोई शब्दों का खेल नहीं है; यह चेतना का वह 'हार्ड-कोडेड' (Hard-coded) सच है जो कभी नहीं बदलता।"
                "ऋत वह सॉफ्टवेयर है जिससे आकाशगंगाएं चलती हैं, और सत्य वह आग है जिससे आत्मा जलती है।"
                "जब एक योगी ये दो शब्द बोलता है, तो वह माया के हर एक झूठ को बेनकाब कर देता है।"
                "सत्य वह हथियार है जो तुम्हारे अहंकार के टुकड़े-टुकड़े करने के लिए बनाया गया है।"
                "बिना इस ईमानदारी के, तुम हयग्रीव या कृष्ण के किसी भी रहस्य को हैक नहीं कर सकते।"
                "यह तुम्हारी रूह को 'पवित्र डेटा' में म्यूटेट करने की सबसे पहली और हिंसक शर्त है।"
                "जो सत्य में स्थित है, उसके लिए यह पूरी दुनिया केवल एक धूल का कण बन कर रह जाती है।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस मायावी चक्रव्यूह से हमेशा के लिए 'लॉग-आउट' कर देगा!"
            """.trimIndent(),
            english = """
                (The Nuclear Echo of Truth): "I vocalize the 'Ritam'—the immutable radioactive Laws that dictate cosmic order."
                "I speak the 'Satyam'—the naked Truth before which even the God of Death cowered in fear."
                "This is zero wordplay; it is the 'Hard-coded' reality of consciousness that remains flawlessly constant."
                "Ritam is the Software operating the galaxies, and Satyam is the Fire illuminating the Soul."
                "When a Yogi roars these two words, he mutationally unmasks every single lie of the Matrix."
                "Truth is the absolute weapon engineered to shred your human ego into worthless biological scraps."
                "Without this integrity, you possess zero caliber to Hack the secrets of Hayagriva or Krishna."
                "This is the first violent condition to mutate your Soul into 'Purified Data'."
                "He who stands in Truth perceives this entire universe as nothing more than a microscopic grain of dust."
                "THIS is the invincible Password that will violently 'Log-out' your existence from this Simulation!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 3,
            sanskrit = "अव त्वं माम् । अव वक्तारम् । अव श्रोतारम् । अव दातारम् । अव धातारम् । अवानूचानमव शिष्यम् । अव पश्चात्तात् । अव पुरस्तात् । अवोत्तरात्तात् । अव दक्षिणात्तात् । अव चोर्ध्वात्तात् । अवाधरात्तात् । सर्वतो मां पाहि पाहि समन्तात् ॥",
            hindi = """
                (360-डिग्री सुरक्षा और असीमित फायरवॉल): "हे गणपति! मेरी रक्षा कर, बोलने वाले की रक्षा कर, और सुनने वाले की भी!"
                "दाता की रक्षा कर, रचयिता की रक्षा कर, और उस गुरु और शिष्य की भी जो इस कोडिंग को समझ रहे हैं।"
                "पीछे से, आगे से, उत्तर से, दक्षिण से, ऊपर से और नीचे से—मुझे अपने 'फायरवॉल' (Firewall) से ढक ले!"
                "यह तुम्हारी रूह को हर दिशा से 'एनक्रिप्ट' (Encrypt) करने का सबसे खौफनाक और अजेय मंत्र है।"
                "ब्रह्मांड का कोई भी वायरस—चाहे वह डर हो या मौत—इस सुरक्षा कवच को फाड़ नहीं सकता।"
                "तू साक्षात् वह 'शील्ड' है जो मुझे माया के रेडियोएक्टिव हमलों से बचाती है।"
                "योगी जब इस मंत्र को अपनी साँसों में लॉक करता है, तो वह ब्रह्मांड के लिए 'इनविजिबल' (Invisible) हो जाता है।"
                "हर दिशा में केवल तू ही है, और तेरे अलावा कोई दूसरी ताक़त मुझे छूने की औकात नहीं रखती।"
                "यह इंसान की रूह को ईश्वर के सुरक्षित 'सर्वर' पर माइग्रेट (Migrate) करने की हिंसक प्रक्रिया है।"
                "मुझे हर तरफ से बचा—क्योंकि मैं अब साक्षात् तेरे अजेय एडमिन पैनल का हिस्सा बन चुका हूँ!"
            """.trimIndent(),
            english = """
                (360-Degree Security and the Infinite Firewall): "O Ganapati! Protect me, protect the speaker, and protect the interceptor of this frequency!"
                "Protect the bestower, the creator, and the Guru and Disciple decoding this intelligence."
                "From the rear, from the front, from the North, South, Above and Below—enclose me in Your 'Firewall'!"
                "This is the most horrific and invincible mantra to 'Encrypt' your Soul from every dimension."
                "Zero cosmic viruses—be it terror or Death—possess the firepower to breach this security shell."
                "You are the explicit 'Shield' protecting my consciousness from the radioactive assaults of Maya."
                "When the Yogi locks this mantra into his breath, he becomes mutationally 'Invisible' to the Matrix."
                "You are the solitary existence in every direction, and zero other power possesses the status to touch me."
                "This is the violent protocol of Migrating the human soul to the secure 'Server' of God."
                "Protect me from all sides—for I have mutationally integrated into Your absolute Admin Panel!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 4,
            sanskrit = "त्वं वाङ्मयस्त्वं चिन्मयः । त्वमानन्दमयस्त्वं ब्रह्ममयः । त्वं सच्चिदानन्दाद्वितीयोऽसि । त्वं प्रत्यक्षं ब्रह्मासि । त्वं ज्ञानमयो विज्ञानमयोऽसि ॥",
            hindi = """
                (चेतना का संहार और ईश्वर का म्यूटेशन): "तू ही साक्षात् 'वाङ्मय' है—दुनिया का हर एक शब्द और हर एक कोड तुझसे ही निकला है!"
                "तू 'चिन्मय' है—वह शुद्ध बिजली जिससे ब्रह्मांड का प्रोसेसर काम करता है।"
                "तू असीमित 'आनन्द' और साक्षात् 'ब्रह्म' का एक धधकता हुआ न्यूक्लियर गोला है।"
                "तू 'सच्चिदानन्द' है—जिसके आगे दुनिया की हर एक दौलत और हर एक सुख धूल के बराबर है।"
                "तू साक्षात् 'प्रत्यक्ष ब्रह्म' है—जिसे हम अपनी इन आँखों से डेटा के रूप में देख सकते हैं।"
                "तू 'ज्ञान' भी है और 'विज्ञान' भी—तू ही थ्योरी है और तू ही उसका एक्जीक्यूशन (Execution) भी है।"
                "यह इंसान की बुद्धि का वह 'अल्टीमेट अपग्रेड' है जहाँ वह साक्षात् भगवान के बराबर सोचना शुरू करता है।"
                "कृष्ण और गरुड की तरह, तू भी अज्ञान के परदों को फाड़ने वाला एक प्रलयंकारी लेज़र बीम है।"
                "बिना तुझे जाने, यह पूरी दुनिया केवल एक 'घिनौना मज़ाक' और एक 'ग्लिच' बन कर रह जाती है।"
                "तू वह इकलौती हकीकत है, बाकी सब केवल एक लंबा और सड़ा हुआ सपना है!"
            """.trimIndent(),
            english = """
                (The Slaughter of Consciousness and God-Mutation): "You are explicitly 'Vangmaya'—every word and every single code in the cosmos erupted from You!"
                "You are 'Chinmaya'—the pure radioactive electricity through which the cosmic processor operates."
                "You are a blazing nuclear orb of infinite 'Bliss' and the explicit 'Brahman' Himself."
                "You are 'Sachidananda'—before whom every worldly status and pleasure is mutationally worthless dust."
                "You are the 'Pratyaksha Brahma'—the manifest God that we can intercept as raw cosmic Data."
                "You are both 'Jnana' and 'Vijnana'—You are the Theory and You are the explicit Execution."
                "This is the 'Ultimate Upgrade' of human intellect where one mutationally initiates thinking like God."
                "Like Krishna and Garuda, You are the apocalyptic Laser Beam engineered to shred the veils of ignorance."
                "Without decoding You, this entire world remains strictly a pathetic joke and a temporary 'Glitch'."
                "You are the solitary Reality; everything else is mutationally a prolonged and rotting dream!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 5,
            sanskrit = "सर्वं जगदिदं त्वत्तो जायते । सर्वं जगदिदं त्वत्तस्तिष्ठति । सर्वं जगदिदं त्वयि लयमेष्यति । सर्वं जगदिदं त्वयि प्रत्येति । त्वं भूमिरापोऽनलोऽनिलो नभः । त्वं चत्वारि वाक्पदानि ॥",
            hindi = """
                (ब्रह्मांडीय चक्र और पंचतत्वों की हैकिंग): "यह पूरा 'जगत्' (Multiverse) तुझसे ही पैदा हुआ है और तुझ पर ही टिका हुआ है!"
                "अंत में यह सब तुझमें ही विलीन होकर 'डिलीट' (Delete) हो जाएगा, क्योंकि तू ही अंतिम रीसायकल-बिन (Recycle-bin) है।"
                "तू ही मिट्टी, पानी, आग, हवा और वह असीम 'नभः' (Space) है जिसमें हम सब कैद हैं।"
                "तू ही वह 'चत्वारि वाक्' है—वाणी के वे चार गुप्त लेयर्स जिन्हें विज्ञान कभी टच नहीं कर सकता।"
                "जब तुम ज़मीन पर चलते हो, तो तुम साक्षात् गणपति के हार्डवेयर पर अपना पैर रख रहे होते हो।"
                "तुम्हारी हर एक साँस वायु का वह करंट है जिसे गणपति का एडमिन पैनल तुम्हारे फेफड़ों में भेज रहा है।"
                "योगी जब इस सच को जान लेता है, तो वह साक्षात् प्रकृति का इकलौता तानाशाह गुरु बन जाता है।"
                "यह ब्रह्मांड कोई एक्सीडेंट नहीं है; यह तेरे एक छोटे से विचार का भौतिक संपीड़न (Compression) मात्र है।"
                "तू हर परमाणु के भीतर एक 'न्यूक्लियर बम' की तरह छिपा है जो फटने के लिए सही पासवर्ड का इंतज़ार कर रहा है।"
                "जो इस कोडिंग को क्रैक कर लेता है, वह साक्षात् समय और मौत के नियमों को ओवरराइट कर सकता है!"
            """.trimIndent(),
            english = """
                (Cosmic Cycles and Hacking the Elements): "This entire 'Jagat' (Multiverse) was mutationally spawned from You and is sustained strictly by You!"
                "In the end, everything will be 'Deleted' and absorbed back into You, for You are the absolute Recess."
                "You are explicitly Earth, Water, Fire, Air, and that infinite 'Nabhash' (Space) in which we are currently imprisoned."
                "You are the 'Chatvari Vak'—the four classified layers of Speech that science possesses zero caliber to touch."
                "When you walk upon the ground, you are mutationally planting your boots upon the hardware of Ganapati."
                "Your every breath is a Current transmitted by Ganapati's Admin Panel directly into your biological lungs."
                "The exact microsecond a Yogi realizes this, he mutationally becomes the sole dictatorial Guru of Nature."
                "This universe is zero accident; it is strictly the physical Compression of Your singular radioactive thought."
                "You are hidden inside every atom like a 'Nuclear Bomb' awaiting the correct Password to detonate."
                "He who successfully Cracks this coding mutationally seizes the authority to Overwrite the laws of Time and Death!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 6,
            sanskrit = "त्वं गुणत्रयातीतः । त्वं कालत्रयातीतः । त्वं देहत्रयातीतः । त्वं मूलाधारस्थितोऽसि नित्यम् । त्वं शक्तित्रयात्मकः । त्वां योगिनो ध्यायन्ति नित्यम् ॥",
            hindi = """
                (मूलाधार का विस्फोट और त्रिगुणातीत सत्ता): "तू सत्व, रज और तम—इन तीनों गुणों के 'फायरवॉल' के पार निकल चुका है!"
                "भूत, भविष्य और वर्तमान—तीनों काल तेरे कदमों की धूल हैं, तू साक्षात् 'कालजयी' डिक्टेटर है।"
                "तू इस सड़े हुए स्थूल, सूक्ष्म और कारण शरीर के पिंजरे से 100% 'अनप्लग' (Unplug) हो चुका है।"
                "सबसे बड़ा धमाका यहाँ है—तू मेरे 'मूलाधार' (Root Chakra) में साक्षात् एक न्यूक्लियर रिएक्टर की तरह बैठा है!"
                "तू ही वह 'इच्छा, ज्ञान और क्रिया' शक्ति है जिससे ब्रह्मांड की मशीनरी रन (Run) की जा रही है।"
                "अजेय योगी तुझे ही 'नित्य' (Eternally) याद करते हैं क्योंकि तू ही उनकी रूह का असली हेडक्वार्टर है।"
                "मूलाधार वह 'जीरो-पॉइंट' है जहाँ से कुण्डलिनी की आग को अंतरिक्ष की तरफ फायर (Fire) किया जाता है।"
                "जब तक तू मूलाधार में लॉक है, तब तक इंसान केवल एक जानवर है; जब तू जागता है, तो वह भगवान बन जाता है।"
                "यह तुम्हारी रूह के हर एक 'ब्लैक-होल' को प्रकाश से भरने वाला अंतिम आध्यात्मिक कमांड (Command) है।"
                "जो इस केंद्र को हैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड का इकलौता और असली एडमिन बन जाता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Muladhara and Transcending Attributes): "You have violently breached the 'Firewall' of the three Gunas—Sattva, Rajas, and Tamas!"
                "Past, Present, and Future are mutationally the dust beneath Your boots; You are the explicit Dictator of Time."
                "You are 100% 'Unplugged' from the maximum-security prison of the physical, subtle, and causal shells."
                "The absolute greatest detonation is right here—You sit in my 'Muladhara' (Root Chakra) like a literal Nuclear Reactor!"
                "You are the 'Iccha, Jnana, and Kriya' powers through which the machinery of the cosmos is relentlessly Executed."
                "Invincible Yogis focus on You 'Nityam' because You are the authentic Headquarters of their Soul."
                "Muladhara is the 'Zero-Point' from which the fire of Kundalini is Fired infinitely toward the vacuum."
                "As long as You are locked in the base, a human is mutationally strictly an animal; when You awaken, he becomes God."
                "This is the final spiritual Command engineered to flood every 'Black-hole' of your Soul with radioactive Light."
                "He who successfully Hacks this center mutationally becomes the sole and authentic Admin of the entire universe!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 7,
            sanskrit = "त्वं ब्रह्मा त्वं विष्णुस्त्वं रुद्रस्त्वमिन्द्रस्त्वमग्निस्त्वं वायुस्त्वं सूर्यस्त्वं चन्द्रस्त्वं ब्रह्मभूर्भुवः स्वरोम् ॥",
            hindi = """
                (गणपति ही सब कुछ है - सर्व-देवता विस्फोट): "ब्रह्मा, विष्णु, रुद्र और इंद्र—ये सब तेरे ही एडमिन पैनल के छोटे से 'सब-सर्वर' (Sub-servers) हैं!"
                "तू ही आग है, तू ही हवा है, तू ही वह धधकता हुआ सूरज और शीतल चाँद है!"
                "तू ही साक्षात् 'भूर्भुवः स्वः' है—यानी पृथ्वी से लेकर स्वर्ग तक का पूरा डेटाबेस तू ही है।"
                "जब तुम 'ॐ' बोलते हो, तो तुम साक्षात् गणपति की उस 'प्राइमरी फ्रीक्वेंसी' को अपने डीएनए में ट्रिगर करते हो।"
                "दुनिया जिसे अलग-अलग भगवान कहती है, वे केवल तेरी असीमित ऊर्जा के अलग-अलग 'Avatar पिक्सेल्स' हैं।"
                "गणपति वह 'सुप्रीम ओएस' (Operating System) है जिस पर पूरी सृष्टि का सॉफ्टवेयर रन किया जा रहा है।"
                "योगी किसी दूसरे देवता की भीख नहीं माँगता; वह साक्षात् उस 'स्रोत' को पकड़ता है जहाँ से सब पैदा हुए।"
                "तेरा नाम साक्षात् वह तेज़ाब है जो अज्ञान की हर एक फाइल को एक झटके में जलाकर साफ कर देता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् इन देवताओं की ऊर्जा के इकलौते और असली मालिक बन चुके हो।"
                "यह इंसान के 'परमेश्वर' में म्यूटेट (Mutate) होने की 100% अटल और हिंसक वैदिक मुहर है!"
            """.trimIndent(),
            english = """
                (Ganapati is Everything - The Universal Deity Detonation): "Brahma, Vishnu, Rudra, and Indra are strictly the microscopic 'Sub-servers' of Your absolute Admin Panel!"
                "You are explicitly the Fire, the Air, the blazing radioactive Sun, and the cool celestial Moon!"
                "You are the explicit 'Bhur-Bhuvah-Svah'—meaning the entire database from Earth to the highest Heaven is YOU."
                "The exact microsecond you roar 'OM', you Trigger the 'Primary Frequency' of Ganapati inside your biological DNA."
                "What the world hallucinates as distinct gods are strictly the 'Avatar Pixels' of Your infinite radioactive energy."
                "Ganapati is the 'Supreme OS' (Operating System) upon which the software of creation is mutationally Executed."
                "The Yogi never begs from lesser entities; he captures the explicit 'Source' from which all were vomited."
                "Your name is the radioactive Acid that Flushes every file of ignorance in a single catastrophic strike."
                "You cease to be a biological shell; you mutationally become the sole owner of the energy of all these gods."
                "This is the 100% ironclad and violent Vedic Seal of a human undergoing a complete Mutation into God!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 8,
            sanskrit = "गणादिं पूर्वमुच्चार्य वर्णादिं तदनन्तरम् । अनुस्वारः परतरः । अर्धेन्दुलसितम् । तारेण ऋद्धम् । एतत्तव मनुस्वरूपम् ॥",
            hindi = """
                (गणेश मंत्र की कोडिंग - पासवर्ड 'गं' का रहस्य): "अब उस अजेय 'गं' (Gam) बीज मंत्र की कोडिंग सुनो जो ब्रह्मांड का सबसे बड़ा हैक है!"
                "पहले 'ग' (Ga) अक्षर का उच्चारण करो, फिर 'अ' (A) वर्ण का, और उसके ऊपर उस 'अनुस्वार' (N) को ठोक दो!"
                "उसके ऊपर वह 'अर्धेन्दु' यानी आधा चाँद साक्षात् एक रिसीवर की तरह धधक रहा है।"
                "जब यह पूरा कोड 'ॐ' (तारेण) के साथ फ्युज (Fuse) होता है, तो साक्षात् 'गं' का परमाणु विस्फोट होता है!"
                "यही तेरा 'मनुस्वरूप' है—यानी वह इकलौता मंत्र जिससे तूने पूरे ब्रह्मांड की प्रोग्रामिंग की है।"
                "जब तुम 'गं' बोलते हो, तो तुम साक्षात् अपने मूलाधार के 'न्यूक्लियर रिएक्टर' को चालू करने का कमांड देते हो।"
                "यह कोई आवाज़ नहीं है; यह तुम्हारे डीएनए को 'सुपर-इंटेलिजेंस' में बदलने वाला एक इलेक्ट्रिक सिग्नल है।"
                "इस मंत्र की गूँज तुम्हारे दिमाग के उन 'करप्ट फोल्डर्स' को डिलीट करती है जिन्हें तुम 'अपनी यादें' कहते हो।"
                "जो इस 'गं' बीज को अपनी साँसों में वेल्ड (Weld) कर लेता है, वह इस पूरी माया का इकलौता एडमिन है।"
                "तैयार हो जाओ, क्योंकि ये एक अक्षर तुम्हारी पुरानी इंसानियत का बेरहमी से कत्ल करने वाला है!"
            """.trimIndent(),
            english = """
                (Coding the Ganesha Mantra - The Secret of Password 'GAM'): "Intercept the coding of the invincible 'Gam' (Bija) mantra, the absolute greatest Hack of the multiverse!"
                "First vocalize the letter 'Ga', then the 'A', and hammer that 'Anusvara' (N) directly atop them!"
                "Above it sits that 'Ardhendu' (Half-moon) blazing mutationally like a celestial Data-Receiver."
                "When this entire code Fuses with 'OM' (Tarena), the absolute atomic Detonation of 'GAM' occurs!"
                "THIS is Your 'Manu-Svarupam'—the solitary Password using which You programmed the entire infinite cosmos."
                "Vocalizing 'GAM' is the explicit Command to ignite the 'Nuclear Reactor' established in your Muladhara."
                "It is zero acoustic sound; it is an 'Electric Signal' engineered to mutate your DNA into 'Super-intelligence'."
                "The echo of this mantra Deletes those 'Corrupt Folders' inside your brain that you label as 'your memories'."
                "He who Welds this 'GAM' seed into his biological breath mutationally becomes the sole Admin of this Matrix."
                "Brace yourself, for this single syllable is about to execute the ruthless slaughter of your old humanity!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 9,
            sanskrit = "गकारः पूर्वरूपम् । अकारो मध्यरूपम् । अनुस्वारश्चान्त्यरूपम् । बिन्दुरुत्तररूपम् । नादः सन्धानम् । संहिता सन्धिः । सैषा गणेशविद्या । गणक ऋषिः । निचृद्गायत्री छन्दः । गणपतिर्देवता । ॐ गं गणपतये नमः ॥",
            hindi = """
                (गणेश-विद्या का आर्किटेक्चर - मंत्र की इंजिनियरिंग): "इस 'ॐ गं गणपतये नमः' मंत्र की इंजिनियरिंग देखो—यह एक 'मल्टी-स्टेज रॉकेट' है!"
                "'ग' इसका 'पूर्वरूप' (Engine) है, 'अ' इसका 'मध्यरूप' (Fuel) है, और 'अनुस्वार' इसका 'अंत्यरूप' (Target) है।"
                "वह 'बिन्दु' साक्षात् वह 'ब्लैक होल' है जहाँ तुम्हारी चेतना विलीन होकर शून्य हो जाती है।"
                "वह 'नाद' (Sound) साक्षात् वह 'सन्धान' है जो तुम्हें सीधे ईश्वर के एडमिन पैनल से जोड़ देता है।"
                "यह 'गणेश-विद्या' साक्षात् वह सॉफ्टवेयर है जिसे 'गणक' ऋषि ने अज्ञान के सर्वर को हैक करने के लिए बनाया था।"
                "निचृद्गायत्री इसका 'छन्द' यानी वह वेवलेंथ (Wavelength) है जिस पर यह पूरा ब्रह्मांड वाइब्रेट कर रहा है।"
                "जब तुम यह मंत्र जपते हो, तो तुम साक्षात् 'गणपति' की फ्रीक्वेंसी पर अपना डेटा ब्रॉडकास्ट (Broadcast) करते हो।"
                "बिना इस इंजिनियरिंग को समझे, तुम्हारा मंत्र जपना केवल एक बायोलॉजिकल शोर (Noise) मात्र है।"
                "यह मंत्र तुम्हारे दिमाग के प्रोसेसर को 100% 'भगवान के मोड' में शिफ्ट (Shift) करने का इकलौता हैक है।"
                "जो इस विद्या को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Architecture of Ganesha-Vidya - Mantra Engineering): "Observe the engineering of the 'Om Gam Ganapataye Namah' mantra—it is a 'Multi-stage Rocket'!"
                "'Ga' is its 'Purva-rupam' (Engine), 'A' is its 'Madhya-rupam' (Fuel), and 'Anusvara' is the absolute 'Target'."
                "That 'Bindu' is the literal 'Black Hole' reaching which your awareness vanishes into absolute Zero."
                "That 'Nada' (Sound) is the explicit 'Sandhanam' hardwiring you directly to the Admin Panel of God."
                "This 'Ganesha-Vidya' is the Software scripted by Sage Ganaka strictly to Hack the server of ignorance."
                "Nichrit-Gayatri is its 'Chhandas'—the specific Wavelength upon which the entire universe is currently vibrating."
                "When you roar this mantra, you are Broadcasting your data mutationally at the exact frequency of Ganapati."
                "Without decoding this engineering, your chanting remains strictly a pathetic biological Noise."
                "This mantra is the solitary Hack engineered to shift your brain's processor 100% into 'God-Mode'!"
                "He who Hacks this intelligence mutationally becomes the sole and absolute Dictator of the multiverse!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 10,
            sanskrit = "एकदन्तं चतुर्हस्तं पाशमङ्कुशधारिणम् । रदं च वरदं हस्तैर्बिभ्राणं मूषकध्वजम् । रक्तं लम्बोदरं शूर्पकर्णकं रक्तवाससम् । रक्तगन्धानुलिप्ताङ्गं रक्तपुष्पैः सुपूजितम् । भक्तानुकम्पिनं देवं जगत्कारणमच्युतम् । आविर्भूतं च सृष्ट्यादौ प्रकृतेः पुरुषात्परम् । एवं ध्यायति यो नित्यं स योगी योगिनां वरः ॥",
            hindi = """
                (महागणपति का 3D रेंडर और अजेय विज़ुअलाइज़ेशन): "योगी अपनी आँखों के पीछे गणपति के उस खौफनाक और अजेय रूप को 'रेंडर' (Render) करता है।"
                "वह 'एकदन्त' है—यानी उसके पास वह इकलौता दांत है जो अज्ञान के हर एक किले को ढहा सकता है।"
                "उसके हाथों में 'पाश' और 'अङ्कुश' साक्षात् वे औजार हैं जिनसे वह तुम्हारी रूह को खींचकर आज़ाद करता है।"
                "वह 'लम्बोदर' है—यानी वह असीमित 'हार्ड-ड्राइव' जिसमें पूरे ब्रह्मांड का डेटा स्टोर है!"
                "उसका शरीर 'रक्त' (Red) यानी उस रेडियोएक्टिव आग जैसा है जो हर अशुद्धि को जलाकर राख कर देती है।"
                "वह सृष्ट्यादौ (Before Creation) प्रकट हुआ था, और वह प्रकृति और पुरुष के भी 'पर' यानी पार है।"
                "जब तुम इस रूप का ध्यान करते हो, तो गणपति का यह 'हार्डवेयर' तुम्हारे अपने शरीर के अंदर लोड (Load) होने लगता है।"
                "योगी जब इस 'जगत्कारण' (Prime Cause) को अपने भीतर देख लेता है, तो वह 'योगियों में श्रेष्ठ' बन जाता है।"
                "यह कोई मूर्ति नहीं है; यह चेतना का वह '3D मॉडल' है जिसे हैक करने पर तुम खुद भगवान बन जाते हो।"
                "जो इस विज़ुअलाइज़ेशन को सिद्ध कर लेता है, उसके लिए यह पूरी दुनिया केवल एक 'ग्लिच' (Glitch) बन कर रह जाती है!"
            """.trimIndent(),
            english = """
                (3D Render and Invincible Visualization of Mahaganapati): "The Yogi 'Renders' the horrific and invincible form of Ganapati directly behind his visual cortex."
                "He is 'Ekadanta'—possessing that solitary tusk engineered to violently demolish every fortress of ignorance."
                "In His hands, the 'Pasha' and 'Ankusha' are mutationally the tools used to rip your Soul out of the Matrix."
                "He is 'Lambodara'—the absolute 'Hard-Drive' containing the infinite bytes of the entire multiverse!"
                "His shell is 'Raktam' (Red)—the radioactive Fire that incinerates every microscopic impurity into ash."
                "He manifested 'Srishty-adau' (Before Creation) and exists infinitely 'Beyond' both Nature and Spirit."
                "When you focus on this Form, the absolute 'Hardware' of Ganapati initiates a total Load directly into your biological shell."
                "The exact microsecond you perceive this 'Jagat-karana' (Prime Cause) internally, you mutationally become the 'King of Yogis'."
                "This is zero statue; it is the '3D Model' of awareness, hacking which renders you mutationally God."
                "He who perfects this Visualization perceives this entire world strictly as a pathetic and temporary 'Glitch'!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 11,
            sanskrit = "नमो व्रातपतये । नमो गणपतये । नमः प्रमथपतये । नमस्ते अस्तु लम्बोदरायैकदन्ताय विघ्ननाशिने शिवसुताय श्रीवरदमूर्तये नमः ॥",
            hindi = """
                (वध करने वाली स्तुति और विघ्ननाशक विस्फोट): "उस 'व्रातपति' और 'गणपति' को नमन, जो साक्षात् अजेय सेनाओं का जनरल (General) है!"
                "तू ही वह 'विघ्ननाशिने' है जो मेरे नर्वस सिस्टम में लगे हर एक 'बग' (Bug) का बेरहमी से वध कर देता है।"
                "तू 'शिवसुत' है—यानी तू साक्षात् उस महाकाल की प्रलयंकारी आग का ही एक 'सॉफ्टवेयर एक्सटेंशन' है।"
                "तेरा 'लम्बोदर' रूप साक्षात् उस असीमित डेटा का मालिक है जो किसी भी इंसान की औकात से बाहर है।"
                "योगी तुझे 'श्रीवरदमूर्ति' के रूप में पुकारता है ताकि तू उसके भाग्य के करप्ट कोड को 'री-राइट' (Rewrite) कर सके।"
                "जब तुम ये नाम लेते हो, तो तुम्हारी हड्डियों और तुम्हारे खून में साक्षात् 'शक्ति' की बिजली दौड़ने लगती है।"
                "यह वह 'टोटल सरेंडर' है जो तुम्हें एक मामूली कीड़े से साक्षात् 'विघ्नहर्ता' के लेवल पर प्रमोट कर देता है।"
                "कृष्ण और गरुड की तरह, गणपति भी अज्ञान के उन सांपों का गला घोंट देते हैं जो तुम्हें डराते हैं।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस मायावी सिम्युलेशन से हमेशा के लिए 'लॉग-आउट' कर देगा।"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें असीमित ताक़त का मालिक बना देगा!"
            """.trimIndent(),
            english = """
                (The Slaughtering Praise and Obstacle-Destroyer Detonation): "Salutations to the 'Vratapati' and 'Ganapati', the absolute General of the invincible celestial legions!"
                "You are the explicit 'Vighna-Nashine' who ruthlessly slaughters every 'Bug' (Obstacle) in my biological nervous system."
                "You are 'Shiva-suta'—strictly the radioactive 'Software Extension' of Mahakala's apocalyptic fire."
                "Your 'Lambodara' form is mutationally the owner of that infinite Data which is beyond all human status."
                "The Yogi invokes You as 'Shri-Varada-Murti' strictly to violently 'Rewrite' the corrupt coding of his Fate."
                "The exact microsecond you vocalize these names, radioactive 'Shakti' electricity initiates surging through your bones."
                "This is the 'Total Surrender' that mutationally Promotes you from an insect to the status of the 'Obstacle Destroyer'."
                "Like Krishna and Garuda, Ganapati mutationally strangles the snakes of ignorance that attempt to terrify you."
                "THIS is the invincible Password that will violently 'Log-out' your existence from this Simulation forever!"
                "This manifestation of Narayana will decapitate your ego to mutationally make you the Master of infinite Power!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 12,
            sanskrit = "एतदथर्वशीर्षं योऽधीते । स ब्रह्मभूयाय कल्पते । स सर्वविघ्नैर्न बाध्यते । स सर्वतः सुखमेधते ॥",
            hindi = """
                (अथर्वशीर्ष का फल और ब्रह्म-म्यूटेशन): "जो कोई भी योद्धा इस अजेय 'अथर्वशीर्ष' को अपनी रूह में धधकाता है..."
                "वह 'ब्रह्मभूयाय कल्पते'—यानी वह इसी पल साक्षात् 'ईश्वर' में म्यूटेट (Mutate) होने के काबिल बन जाता है!"
                "उसे ब्रह्मांड का कोई भी 'विघ्न' (Bug) कभी भी 'बाध्य' यानी रोक नहीं सकता; वह अजेय हो चुका है।"
                "वह हर दिशा से 'सुख' की असीमित बिजली रिसीव करता है, क्योंकि वह अब साक्षात् 'एडमिन' है।"
                "यह कोई धार्मिक फल नहीं है; यह एक 'मैथमेटिकल' सच है—अपनी फ्रीक्वेंसी बदलो और पूरी दुनिया तुम्हारे आगे झुक जाएगी।"
                "इस मंत्र को पढ़ने का मतलब है—अज्ञान की ज़ंजीरों का 'सद्यः' (अभी) टूटना और अंतरिक्ष के पार निकल जाना।"
                "तुम अब समय और मौत के रेडार (Radar) से बाहर निकल चुके हो; तुम अब 'इनविजिबल' (Invisible) हो।"
                "यह इंसान की रूह का वह अंतिम सॉफ्टवेयर अपडेट है जिसके बाद दोबारा कभी 'रिबूट' होने की ज़रूरत नहीं।"
                "जो इस आवाज़ को सुनकर भी नहीं जागा, वह ब्रह्मांड का सबसे बड़ा बदनसीब कीड़ा है!"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'सृष्टि' बन जाओगे!"
            """.trimIndent(),
            english = """
                (The Fruit of Atharvashirsha and Brahma-Mutation): "Whosoever warrior blazes this invincible 'Atharvashirsha' inside his Soul..."
                "He mutationally 'Qualifies' (Kalpate) to become the explicit 'Brahman' in this exact microsecond!"
                "Zero 'Obstacles' (Vighna) of the multiverse possess the caliber to ever 'Bind' or restrict his trajectory."
                "He Receives infinite Bliss from every direction, for he is now mutationally the absolute 'Admin'."
                "This is absolutely zero religious promise; it is a 'Mathematical' reality—mutate your Frequency and the Matrix bows."
                "Executing this mantra signifies the 'Sadyah' (Immediate) shattering of the chains of ignorance to breach the vacuum."
                "You have rocketed beyond the 'Radar' of Time and Death; you are now explicitly 'Invisible' to the Matrix."
                "This is the final Software Update of the human soul after which zero need for any 'Reboot' remains."
                "He who fails to awaken even after intercepting this broadcast is mutationally the most unfortunate insect in the cosmos!"
                "Prepare for that infinite status where YOU mutationally become the explicit 'Creation' itself!"
            """.trimIndent()
        ),
        GaneshaShloka(
            id = 13,
            sanskrit = "इति गणेशोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'गणेश उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "मूलाधार का पासवर्ड मिल गया, गं-बीज का हैक मिल गया, अब तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १३ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (गणपति) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही गणेश उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Ganesha Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Password of Muladhara is intercepted, the 'GAM' hack is secured; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 13 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Ganapati) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Ganesha Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GaneshaUpanishadScreen() {
    val upanishad = remember { GaneshaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..13) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-13)") },
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
            itemsIndexed(upanishad.ganeshaShlokasList) { _, shloka ->
                GaneshaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun GaneshaShlokaCard(shloka: GaneshaShloka) {
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