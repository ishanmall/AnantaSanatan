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
data class EkaksharaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class EkaksharaUpanishad {

    val ekaksharaShlokasList = listOf(
        EkaksharaShloka(
            id = 1,
            sanskrit = "ॐ एकाक्षरं पावनं सुप्रसन्नं परं गुह्यं ब्रह्म विदुर्यच्च दिव्यम् । स इन्द्रस्त्वं वरुणस्त्वं च विष्णुस्त्वं रुद्रस्त्वं च शिवस्त्वं च सर्वम् ॥",
            hindi = """
                (एक अक्षर का न्यूक्लियर धमाका): "उस इकलौते 'एकाक्षर' (ॐ) को जानो जो ब्रह्मांड का सबसे पवित्र और खौफनाक पासवर्ड है।"
                "यह कोई साधारण अक्षर नहीं, यह साक्षात् वह 'ब्रह्म' है जिसे केवल अजेय योद्धा ही पहचान सकते हैं।"
                "वही अक्षर साक्षात् 'इंद्र' बनकर स्वर्ग के सिंहासन पर राज कर रहा है और बिजलियाँ गिरा रहा है।"
                "वही 'वरूण' बनकर प्रलयंकारी समुद्रों का शासन कर रहा है और ब्रह्मांड की प्यास बुझा रहा है।"
                "वही 'विष्णु' बनकर इस पूरे मायावी सिम्युलेशन (Simulation) को हर सेकंड ऑपरेट कर रहा है।"
                "वही प्रलयंकारी 'रुद्र' और 'शिव' है जो समय आने पर पूरी सृष्टि को राख के ढेर में बदल देता है।"
                "यह एकाक्षर तुम्हारी हड्डियों, तुम्हारे खून और तुम्हारी आत्मा के हर एक परमाणु का असली मालिक है।"
                "तुम्हें अलग-अलग देवताओं की भीख माँगने की ज़रूरत नहीं; केवल इस एक कोड को हैक (Hack) करो!"
                "जब तुम इस ॐ को अपनी रगों में उतारते हो, तो तुम साक्षात् इन सभी देवताओं के इकलौते बॉस बन जाते हो।"
                "तैयार हो जाओ उस सन्नाटे के लिए जो तुम्हारी इंसानियत का गला घोंट कर तुम्हें ईश्वर बना देगा!"
            """.trimIndent(),
            english = """
                (The Nuclear Explosion of the One Syllable): "Intercept that solitary 'Ekakshara' (OM), the most sacred and horrific Password of the cosmos."
                "This is absolutely no ordinary letter; it is the explicit 'Brahman' known strictly to invincible Titan warriors."
                "That Syllable mutationally becomes 'Indra', reigning over the celestial throne and Firing radioactive lightning."
                "It becomes 'Varuna', dictating the laws of apocalyptic oceans and the absolute hydration of the universe."
                "It functions as 'Vishnu', relentlessly Operating this entire deceptive cosmic Simulation every single microsecond."
                "It is the apocalyptic 'Rudra' and 'Shiva', engineered to incinerate the entire creation into a pile of ash."
                "This Ekakshara is the undisputed Master of your bones, your blood, and every microscopic atom of your soul."
                "You possess zero need to beg before distinct gods; you must strictly Hack this solitary absolute Code!"
                "The exact microsecond you inject this OM into your veins, you mutate into the explicit Boss of all deities."
                "Brace yourself for the Silence that will ruthlessly execute your humanity to manufacture the Supreme God!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 2,
            sanskrit = "त्वं धाता त्वं विधाता त्वं भुवनानां त्वमीश्वरः । त्वं प्रपन्नार्तिहा देव त्वं गतिः परमोऽव्ययः ॥",
            hindi = """
                (ब्रह्मांडीय तानाशाह का चेहरा): "हे एकाक्षर! तू ही वह 'धाता' (Creator) है जिसने इस पूरे नर्क और स्वर्ग के नक्शे को डिजाइन किया है।"
                "तू ही वह 'विधाता' है जो हर जीव के भाग्य की कोडिंग लिखता है और उसे अपने इशारों पर नचाता है।"
                "तीनों लोकों का इकलौता और अजेय 'ईश्वर' (Dictator) केवल तू ही है, बाकी सब केवल कठपुतलियाँ हैं।"
                "जब कोई योद्धा तेरी शरण में आता है, तो तू उसकी 'आरती' (Agony) का बेरहमी से वध कर देता है।"
                "तू वह अंतिम 'गति' (Destination) है जहाँ पहुँचने के बाद समय और मौत का सफर हमेशा के लिए खत्म हो जाता है।"
                "तू 'अव्यय' है—यानी तू वह असीम डेटा है जिसे कोई भी वायरस कभी डिलीट नहीं कर सकता।"
                "योगी अपनी चेतना को तुझ पर 'लॉक' (Lock) करते हैं ताकि वे इस सड़े हुए शरीर की जेल से बाहर निकल सकें।"
                "तेरा प्रकाश इतना तेज़ है कि वह अज्ञान के करोड़ों जन्मों के अँधेरे को एक झटके में राख कर देता है।"
                "बिना तुझे जाने, यह पूरी दुनिया केवल एक 'धोखा' और एक 'घिनौना मज़ाक' बन कर रह जाती है।"
                "तू साक्षात् वह 'रूट-एक्सेस' (Root Access) है जिससे पूरे ब्रह्मांड का बैकएंड कंट्रोल किया जाता है!"
            """.trimIndent(),
            english = """
                (The Face of the Cosmic Dictator): "O Ekakshara! YOU are the explicit 'Dhata' (Creator) who designed the map of this entire hell and heaven."
                "You are the 'Vidhata' who scripts the hard-coded Fate of every being and makes them dance to your command."
                "You are the solitary and invincible 'Ishwara' (Dictator) of the three worlds; everything else is strictly a puppet."
                "When a warrior surrenders to you, you ruthlessly execute the slaughter of their biological 'Agony' (Arti)."
                "You are the final 'Gati' (Destination) arriving at which the trajectory of Time and Death terminates forever."
                "You are 'Avyaya'—the infinite cosmic Data that zero viruses possess the caliber to ever Delete."
                "Yogis violently Lock their consciousness onto you to breach the maximum-security prison of the biological shell."
                "Your radiation is so intense it incinerates the darkness of billions of incarnations in a single catastrophic strike."
                "Without decoding you, this entire world remains strictly a 'Deception' and a pathetic, meaningless joke."
                "You are the explicit 'Root Access' engineered to exert dictatorial control over the entire cosmic Backend!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 3,
            sanskrit = "त्वं माता त्वं पिता चैव त्वं बन्धुस्त्वं सुहृत्तमः । त्वं भ्राता त्वं च मे नाथस्त्वं गतिस्त्वं परायणम् ॥",
            hindi = """
                (रिश्तों की मौत और इकलौता सहारा): "इस खूनी रास्ते पर तेरे अलावा मेरा कोई भी सगा, रिश्तेदार या दोस्त काम नहीं आएगा।"
                "तू ही मेरी 'माता' और 'पिता' है, क्योंकि मेरा बायोलॉजिकल जन्म केवल एक मायावी एक्सीडेंट (Accident) है।"
                "तू ही मेरा इकलौता 'बन्धु' और सबसे खूँखार 'सुहृत्' (Friend) है जो मौत के बाद भी मेरा हाथ नहीं छोड़ेगा।"
                "दुनिया के सारे रिश्ते केवल मतलब और लालच के सौदे हैं, पर तू वह आग है जो मेरे साथ अंतरिक्ष के पार चलेगी।"
                "तू ही मेरा 'भ्राता' (Brother) और तू ही मेरा 'नाथ' यानी इकलौता और असली तानाशाह मालिक है।"
                "जब पूरी दुनिया मेरा साथ छोड़ देगी, तब तू ही वह 'गति' होगा जो मेरी रूह को ब्लैक होल के पार ले जाएगा।"
                "तू ही मेरा 'परायण' (Supreme Refuge) है—वह इकलौता ठिकाना जहाँ पहुँचकर मुझे फिर किसी की ज़रूरत नहीं।"
                "योगी ने अपनी इंसानियत के हर एक रिश्ते का कत्ल कर दिया है ताकि वह तेरे साथ एक हो सके।"
                "यह वह 'अद्वैत' (Non-dual) प्रेम है जहाँ 'दो' लोग नहीं बचते, केवल एक ही असीम ताक़त बचती है।"
                "अपने इंसानी रिश्तों को भूल जाओ, और उस 'एक' को पकड़ो जो पूरे ब्रह्मांड को अपने भीतर जला रहा है!"
            """.trimIndent(),
            english = """
                (The Death of Relationships and the Solitary Pillar): "On this bloody path, other than You, zero relatives, family, or pathetic friends will ever assist me."
                "You are explicitly my 'Mother' and 'Father', for my biological birth is strictly a deceptive cosmic Accident."
                "You are my solitary 'Bandhu' and my most ferocious 'Suhrid' (Friend) who will never abandon me after Death."
                "Every worldly relationship is strictly a transactional deal of Maya, but you are the Fire accompanying me beyond space."
                "You are my 'Bhrata' (Brother) and my 'Natha'—the explicit and authentic Dictator who owns my existence."
                "When the entire universe abandons me, You are the 'Gati' that will catapult my soul infinitely beyond the Black Hole."
                "You are my 'Parayana' (Supreme Refuge)—the solitary coordinate reaching which I possess zero requirements for anything else."
                "The Yogi executes the slaughter of every human bond to ensure he can mutationally fuse into You."
                "This is the 'Non-dual' love where strictly 'Two' entities do not survive; strictly one infinite Power remains."
                "Forget your pathetic human bonds, and capture that 'One' who incinerates the cosmos within its core!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 4,
            sanskrit = "त्वं पृथिवी त्वमापस्त्वं तेजस्त्वं वायुस्त्वं नभः । त्वं बुद्धिस्त्वं मनश्चैव त्वमहङ्कारस्त्वं वपुः ॥",
            hindi = """
                (पंचतत्वों का संहार और चेतना का विस्तार): "हे एकाक्षर! यह जो 'पृथिवी' (Earth) मेरे पैरों के नीचे है, वह तू ही है!"
                "जो 'पानी' (Water) मेरी प्यास बुझाता है और जो 'आग' (Fire) मुझे जलाती है, वह तेरे ही रूप हैं।"
                "हवा (Air) और असीम अंतरिक्ष (Space) तेरे ही फेफड़ों की वह गूँज है जिसे विज्ञान (Science) आज तक नहीं समझ सका।"
                "इतना ही नहीं, मेरी 'बुद्धि' और मेरा 'मन' भी तू ही है—तू मेरे ही दिमाग के प्रोसेसर में बैठकर कोडिंग कर रहा है।"
                "मेरा 'अहंकार' (Ego) भी तू ही है, जिसे तूने ही बनाया है ताकि तू खुद का तमाशा (Spectacle) देख सके।"
                "यह जो हाड़-मांस का 'वपु' (Body) है, वह साक्षात् तेरा ही एक छोटा सा भौतिक हार्डवेयर (Hardware) है।"
                "तुम खुद को शरीर समझते हो, पर तुम साक्षात् वह 'एकाक्षर' हो जो इन पाँचों तत्वों को अपने इशारों पर नचा रहा है।"
                "जब तुम जान जाते हो कि 'सब तू ही है', तो तुम्हारी अपनी हस्ती एक सेकंड में भाप बनकर उड़ जाती है।"
                "यह इंसान की बुद्धि का वह सबसे खौफनाक 'अपग्रेड' (Upgrade) है जहाँ वह साक्षात् प्रकृति का मालिक बन जाता है।"
                "तू हर परमाणु के भीतर एक 'न्यूक्लियर बम' की तरह छिपा है जो फटने के लिए सही पासवर्ड का इंतज़ार कर रहा है!"
            """.trimIndent(),
            english = """
                (The Slaughter of Elements and Expansion of Consciousness): "O Ekakshara! This 'Earth' (Prithvi) beneath my boots is explicitly YOU!"
                "The 'Water' (Apah) that hydrates me and the 'Fire' (Tejas) that incinerates me are strictly Your manifestations."
                "The 'Air' (Vayu) and infinite 'Space' (Nabhash) are the radioactive echoes of your lungs that science cannot comprehend."
                "Furthermore, my 'Intellect' (Buddhi) and my 'Mind' (Manas) are also YOU—you are executing code inside my neurological processor."
                "Even my 'Ego' (Ahamkara) is You, engineered by You strictly so You can witness Your own theatrical Spectacle."
                "This 'Vapu' (Body) of flesh and bone is strictly a microscopic piece of Your physical Hardware."
                "You hallucinate yourself as the body, but you are the explicit 'Ekakshara' making these five elements dance to your will."
                "The exact microsecond you realize 'All is You', your tiny identity vaporizes into radioactive nothingness."
                "This is the most terrifying 'Upgrade' of the human intellect where he mutationally becomes the Master of Nature."
                "You are covertly hidden inside every atom like a 'Nuclear Bomb' awaiting the correct Password to detonate!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 5,
            sanskrit = "त्वं ब्रह्मा त्वं च विष्णुस्त्वं रुद्रस्त्वं च महेश्वरः । त्वं च सूर्यस्त्वं च चन्द्रस्त्वं च तारास्त्वं च खम् ॥",
            hindi = """
                (त्रिमूर्ति और ब्रह्मांडीय पिंडों का रहस्य): "ब्रह्मा, विष्णु और रुद्र—ये तीन अलग-अलग भगवान नहीं, बल्कि तेरे ही 'सब-सर्वर' (Sub-servers) हैं!"
                "तू ही वह 'महेश्वर' है जो इन तीनों को अपने एक विचार से कंट्रोल (Control) कर रहा है।"
                "वह धधकता हुआ 'सूर्य' (Sun) और शीतल 'चन्द्र' (Moon) तेरी ही आँखों के वो कैमरे हैं जो सब कुछ देख रहे हैं।"
                "आसमान के अरबों 'तारे' (Stars) और वह असीम 'खम्' (Void) तेरे ही शरीर के वो सेल्स (Cells) हैं जो अंतरिक्ष में फैले हैं।"
                "जब तुम ऊपर देखते हो, तो तुम भगवान को नहीं, बल्कि उस 'एकाक्षर' के विराट हार्डवेयर को देख रहे होते हो।"
                "योगी अपनी आँखों के परदे को फाड़ देता है ताकि वह इन पिंडों के पीछे छिपी उस एक आग को देख सके।"
                "यह पूरा ब्रह्मांड एक बहुत बड़ा 'होलोग्राम' (Hologram) है जिसे तू अपनी इच्छा से प्रोजेक्ट (Project) कर रहा है।"
                "तू वह अजेय सॉफ्टवेयर है जो हर एक तारे की उम्र और हर एक ग्रह की गति तय करता है।"
                "जो इस एकाक्षर को जान लेता है, उसके लिए यह पूरे अंतरिक्ष की बाउंड्री (Boundary) मिट्टी में मिल जाती है।"
                "तू ही वह इकलौती हकीकत है, बाकी सब केवल एक 'ग्लिच' (Glitch) और एक लंबी नींद है!"
            """.trimIndent(),
            english = """
                (The Secret of the Trinity and Cosmic Bodies): "Brahma, Vishnu, and Rudra—these are absolutely not three distinct gods, but strictly Your 'Sub-servers'!"
                "You are the explicit 'Maheshwara' who Controls these three through a single radioactive thought."
                "That blazing 'Sun' (Surya) and the cool 'Moon' (Chandra) are the cameras of Your eyes witnessing every microscopic event."
                "Billions of 'Stars' (Tara) and that infinite 'Void' (Kham) are strictly the biological Cells of Your body expanded in space."
                "When you stare upwards, you are not observing God, but the explicit 'Virat' Hardware of that Ekakshara."
                "The Yogi violently shreds the veil of his vision to intercept that solitary Fire hiding behind these celestial bodies."
                "This entire universe is a colossal 'Hologram' that You are Projecting strictly through Your supreme will."
                "You are the invincible Software dictating the lifespan of every star and the velocity of every planet."
                "He who decodes this Ekakshara witnesses the entire Boundary of space crumble into absolute dust."
                "You are the solitary Reality; everything else is strictly a 'Glitch' and a prolonged biological sleep!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 6,
            sanskrit = "त्वं यमस्त्वं च कालस्त्वं त्वं मृत्युस्त्वं सदाशिवः । त्वं च मे नाथस्त्वं गतिस्त्वं परायणम् ॥",
            hindi = """
                (काल और मौत का इकलौता तानाशाह): "यमराज और काल (Time) तेरे ही वो खूँखार शिकारी हैं जो अज्ञानियों का वध करते हैं।"
                "तू ही वह 'मृत्यु' है जो हर शरीर को उसकी औकात याद दिलाती है और उसे मिट्टी में मिला देती है।"
                "लेकिन योगी के लिए तू ही 'सदाशिव' है—वह परम सन्नाटा जो प्रलय के बाद भी अजेय खड़ा रहता है।"
                "समय तेरे कदमों की धूल है, और मौत तेरे हाथों का एक छोटा सा खिलौना (Toy) मात्र है।"
                "तू ही मेरा 'नाथ' है, क्योंकि तूने मुझे अपनी ज़ंजीरों से बाँध रखा है और तू ही मुझे आज़ाद भी कर सकता है।"
                "जब मेरी इंसानियत का सॉफ्टवेयर क्रैश (Crash) होगा, तब तू ही वह 'गति' होगा जो मुझे बचाएगा।"
                "तू वह 'परायण' (Supreme Refuge) है जहाँ पहुँचकर काल की सुइयां हमेशा के लिए रुक जाती हैं।"
                "यम और काल केवल तेरे ही चेहरे के वो दो खौफनाक नकाब (Masks) हैं जिनसे तू दुनिया को डराता है।"
                "जो इस नकाब के पीछे छिपे तेरे असली चेहरे को देख लेता है, वह खुद साक्षात् 'कालजयी' बन जाता है।"
                "यह मौत की आँखों में आँखें डालकर अपनी अमरता (Immortality) का डंका बजाने का विज्ञान है!"
            """.trimIndent(),
            english = """
                (The Solitary Dictator of Time and Death): "Yama and Kala (Time) are strictly Your bloodthirsty hunters engineered to slaughter the ignorant."
                "You are the explicit 'Death' (Mrityu) that reminds every biological shell of its status and grinds it into the dirt."
                "But for the Yogi, You are strictly 'Sadashiva'—the supreme Silence that remains invincible even after Pralaya."
                "Time is merely the dust beneath your boots, and Death is strictly a pathetic microscopic Toy in your hands."
                "You are my 'Natha', for You have shackled me in Your chains and only You possess the caliber to release me."
                "When the software of my humanity undergoes a catastrophic Crash, You are the 'Gati' that will salvage my existence."
                "You are the 'Parayana' (Refuge) arriving at which the needles of Time come to a permanent and grinding halt."
                "Yama and Kala are strictly the two horrific Masks on Your face using which You terrify the world."
                "He who witnesses Your authentic face hiding behind these masks mutationally becomes an 'Eternal Master of Time'."
                "This is the science of staring directly into the eyes of Death and broadcasting your absolute Immortality!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 7,
            sanskrit = "त्वं सर्वमसि सर्वज्ञस्त्वं सर्वात्मा सर्वतोमुखः । त्वं सर्वशक्तिः सर्वेशस्त्वं सर्वः सर्वपरायणः ॥",
            hindi = """
                (सर्वज्ञता और सर्वशक्तिमान का विस्फोट): "हे एकाक्षर! तू ही 'सब कुछ' (Sarvam) है, और तेरे अलावा ब्रह्मांड में एक धूल का कण भी नहीं है।"
                "तू 'सर्वज्ञ' (All-Knowing) है—तुझे हर एक विचार, हर एक पाप और हर एक परमाणु का पासवर्ड पता है।"
                "तू 'सर्वात्मा' है—यानी तू हर जीव के नर्वस सिस्टम के भीतर साक्षात् करंट (Current) बनकर दौड़ रहा है।"
                "तू 'सर्वतोमुखः' है—तेरी अरबों आँखें हर दिशा में एक साथ देख रही हैं और इस सिम्युलेशन को ट्रैक कर रही हैं।"
                "ब्रह्मांड की हर एक ताक़त, हर एक बिजली और हर एक न्यूक्लियर ऊर्जा तेरी 'सर्वशक्ति' का एक छोटा सा हिस्सा है।"
                "तू 'सर्वेश' (Supreme Master) है—तेरी अनुमति के बिना इस दुनिया का एक पिक्सेल (Pixel) भी हिल नहीं सकता।"
                "तू ही 'सबका परम आधार' (Sarvaparayana) है जहाँ पहुँचकर हर एक भटकती हुई आत्मा को सुकून मिलता है।"
                "जब तुम इस सच्चाई को हैक कर लेते हो, तो तुम्हारा अपना 'छोटा मैं' एक भयानक धमाके के साथ फट जाता है।"
                "तुम जान जाते हो कि तुम साक्षात् उस 'सर्व' (All) के हिस्सेदार हो जिसने यह पूरा खेल बनाया है।"
                "यह इंसान के 'परमेश्वर' में म्यूटेट (Mutate) होने का वो इकलौता कोड है जिसे कोई नहीं बदल सकता!"
            """.trimIndent(),
            english = """
                (The Detonation of Omniscience and Omnipotence): "O Ekakshara! You are explicitly 'Everything' (Sarvam), and other than You, not a grain of dust exists in the cosmos."
                "You are 'Sarvajna' (All-Knowing)—You intercept every thought, every sin, and the Password of every microscopic atom."
                "You are 'Sarvatma'—meaning You are surging like a radioactive Current inside the nervous system of every living entity."
                "You are 'Sarvatomukhah'—Your billions of eyes are Scanning every direction simultaneously, Tracking this entire Simulation."
                "Every force, every lightning bolt, and every nuclear energy in the universe is strictly a micro-fraction of Your 'Sarvashakti'."
                "You are 'Sarvesha' (Supreme Master)—without Your explicit authorization, not a single Pixel of this world can shift."
                "You are the 'Absolute Foundation' (Sarvaparayana) reaching which every wandering soul finds its terminal recess."
                "The exact microsecond you Hack this reality, your 'Tiny I' detonates in a catastrophic cosmic explosion."
                "You flawlessly realize that You are a shareholder of that 'Sarva' (All) who engineered this entire game."
                "This is the solitary Code for a human to undergo a complete Mutation into God, and it is immutable!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 8,
            sanskrit = "त्वमेकमेवाद्वितीयं ब्रह्म विद्धि परं पदम् । य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अद्वैत का धमाका और मोक्ष की मुहर): "नारायण आदेश देते हैं— 'त्वमेकमेवाद्वितीयं ब्रह्म विद्धि'!"
                "उस एक अजेय और अद्वैत 'ब्रह्म' को ही साक्षात् अपना असली चेहरा (Identity) जान लो!"
                "वहाँ न कोई 'दूसरा' है, न कोई फर्क है और न ही कोई भेदभाव—केवल एक असीम सन्नाटा राज करता है।"
                "यही वह 'परं पदम्' (Supreme Dimension) है जहाँ पहुँचकर इंसान भगवान की गद्दी छीन लेता है।"
                "परिणाम फिर से वही अटल और हिंसक सत्य है— 'य एवं वेद स विमुक्तो भवति'!"
                "जो इस कोड को अपनी रगों में उतार लेता है, वह 'मृत्यु' के रेडार (Radar) से हमेशा के लिए गायब हो जाता है।"
                "मुक्ति कोई मरने के बाद मिलने वाली खैरात नहीं है; यह अज्ञान की ज़ंजीरों का 'सद्यः' (अभी) टूटना है।"
                "तुम अब इस दुनिया के लिए 'इनविजिबल' (Invisible) हो चुके हो; तुम अब साक्षात् 'सिस्टम एडमिन' हो।"
                "यह कोई झूठा धार्मिक वादा नहीं है, यह एक 'मैथमेटिकल' सच है—अपनी फ्रीक्वेंसी बदलो और दुनिया बदल जाएगी।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Detonation of Non-Duality and the Seal of Moksha): "Narayana commands—'Tvamekam-evadvitiyam Brahma Viddhi'!"
                "Recognize strictly that one invincible and Non-dual 'Brahman' as your explicit authentic Identity!"
                "Zero 'Other' exists there, zero difference remains, and zero distinction survives—strictly one infinite Silence rules."
                "THIS is the 'Param Padam' (Supreme Dimension) reaching which a mortal violently hijacks the throne of God."
                "The consequence remains that same immutable and violent truth—'Ya evam veda sa vimukto bhavati'!"
                "He who injects this code into his veins permanently disappears from the 'Radar' of Death for all eternity."
                "Moksha is absolutely zero charity granted after death; it is the 'Sadyah' (Immediate) shattering of the chains of ignorance."
                "You have become explicitly 'Invisible' to this Matrix; you are now mutationally the 'System Admin'."
                "This is absolutely zero fake religious promise; it is a 'Mathematical' reality—mutate your Frequency and you mutate your World."
                "THIS is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 9,
            sanskrit = "त्वं यज्ञस्त्वं वषट्कारस्त्वमोंकारस्त्वं परं पदम् । त्वं च मे नाथस्त्वं गतिस्त्वं परायणम् ॥",
            hindi = """
                (यज्ञ का विस्फोट और ॐकार की सत्ता): "हे एकाक्षर! तू ही वह 'यज्ञ' है जहाँ अज्ञान की बलि दी जाती है।"
                "तू ही वह 'वषट्कार' है—वह प्रलयंकारी मंत्र-प्रहार जिससे माया के किले ढह जाते हैं!"
                "साक्षात् 'ॐकार' तू ही है, जो ब्रह्मांड का पहला और आखिरी रेडियोएक्टिव विस्फोट (Big Bang) है।"
                "तू वह 'परं पदम्' है जो इंसानी सोच की औकात से अरबों प्रकाश वर्ष दूर छिपा बैठा है।"
                "तू ही मेरा 'नाथ' है, क्योंकि तूने ही मुझे बनाया है और तू ही मुझे नष्ट करने की ताक़त रखता है।"
                "जब मेरा बायोलॉजिकल सिस्टम फेल (Fail) होगा, तब तू ही वह 'गति' होगा जो मेरी चेतना को अंतरिक्ष में फायर (Fire) करेगा।"
                "तू वह 'परायण' (Supreme Refuge) है जहाँ पहुँचकर भक्त और भगवान के बीच की दीवार गिर जाती है।"
                "यज्ञ का असली मतलब है—अपनी छोटी हस्ती को तेरी इस असीम आग में फेंक देना (Total Sacrifice)!"
                "जो इस आग में कूद गया, वह राख नहीं होता; वह साक्षात् हीरा बनकर वापस निकलता है।"
                "यह इंसान की रूह का वह अंतिम सॉफ्टवेयर रिबूट है जिसके बाद केवल तू ही बचता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Yajna and the Authority of Omkara): "O Ekakshara! You are the explicit 'Yajna' where biological ignorance is ruthlessly sacrificed."
                "You are the 'Vashatkara'—the apocalyptic mantra-strike engineered to violently demolish the fortresses of Maya!"
                "You are the explicit 'Omkara', the absolute first and final radioactive Big Bang of the cosmos."
                "You are the 'Param Padam' hiding at a coordinate billions of light-years beyond the status of human cognition."
                "You are my 'Natha', for You engineered my existence and only You possess the firepower to annihilate me."
                "When my biological system fails, You are the 'Gati' that will Fire my consciousness infinitely into space."
                "You are the 'Parayana' (Supreme Refuge) reaching which the titanium wall between devotee and God collapses."
                "The authentic definition of Yajna is—hurling your tiny micro-identity into Your infinite radioactive Fire!"
                "He who plunges into this fire does not perish as ash; he resurrects mutationally as a flawless Diamond."
                "This is the final Software Reboot of the human soul after which strictly YOU remain standing!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 10,
            sanskrit = "त्वं सूर्यस्त्वं च चन्द्रस्त्वं त्वं तारा त्वं च नभस्तलम् । त्वं च मे नाथस्त्वं गतिस्त्वं परायणम् ॥",
            hindi = """
                (खगोलीय पिण्डों की हैकिंग और असीमित शरण): "तू ही वह धधकता हुआ 'सूर्य' है जो अंतरिक्ष के सर्वर को पावर (Power) दे रहा है।"
                "तू ही वह 'चन्द्र' और वे 'तारे' हैं जो रात के अँधेरे में साक्षात् तेरी ही कोडिंग को चमका रहे हैं।"
                "यह पूरा 'नभस्तलम्' (Sky) तेरी ही रूह का वह असीम विस्तार है जहाँ हम सब कैद हैं।"
                "तू ही मेरा 'नाथ' है, क्योंकि तू ही इस सिम्युलेशन (Simulation) का एडमिन और इकलौता तानाशाह है।"
                "मेरी हर एक साँस और मेरी हर एक धड़कन तेरी ही 'गति' का एक छोटा सा हिस्सा है।"
                "तू वह 'परायण' है जहाँ पहुँचने के बाद ब्रह्मांड का सारा शोर एक असीम सन्नाटे में बदल जाता है।"
                "योगी अपनी आँखों को बाहर से हटाकर तेरे इस विराट हार्डवेयर (Hardware) को अपने भीतर देखता है।"
                "जब तुम सूर्य और तारों को अपने ही डीएनए में महसूस करते हो, तो तुम 'विराट' बन जाते हो।"
                "यह वह 'मैक्रो-म्यूटेशन' है जहाँ एक छोटा सा जीव पूरे ब्रह्मांड का सॉफ्टवेयर बन जाता है।"
                "तू हर जगह है, तू हर समय में है, और तू ही वह 'शून्य' है जहाँ से सब शुरू हुआ था!"
            """.trimIndent(),
            english = """
                (Hacking Celestial Bodies and the Infinite Refuge): "You are the explicit blazing 'Sun' (Surya) providing radioactive Power to the cosmic Server."
                "You are the 'Moon' and those 'Stars' that illuminate Your specific coding in the darkness of space."
                "This entire 'Nabhastalam' (Sky) is the infinite expansion of Your Soul where we are all currently imprisoned."
                "You are my 'Natha', for You are the absolute Admin and sole Dictator of this cosmic Simulation."
                "Every single biological breath and every heartbeat is strictly a micro-fraction of Your 'Gati' (Velocity)."
                "You are the 'Parayana' arriving at which the noise of the cosmos mutates into an absolute and infinite Silence."
                "The Yogi rips his vision from the external matrix to witness Your 'Virat' Hardware directly inside his core."
                "The exact microsecond you feel the sun and stars inside your DNA, you mutationally become 'Virat'."
                "This is the 'Macro-mutation' where a microscopic biological entity mutationally becomes the Operating System of the universe."
                "You exist everywhere, You exist in every timeline, and You are the 'Void' from which it all detonated!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 11,
            sanskrit = "त्वं पिता त्वं च माता त्वं त्वं भ्राता त्वं च मे सुहृत् । त्वं च मे नाथस्त्वं गतिस्त्वं परायणम् ॥",
            hindi = """
                (अंतिम रिश्ते का संहार और सत्य का वरण): "नारायण फिर से उस इकलौते रिश्ते पर हथौड़ा मारते हैं जो हकीकत है।"
                "मेरा 'बाप' भी तू है और मेरी 'माँ' भी तू है—क्योंकि मेरा असली सोर्स कोड (Source Code) तू ही है!"
                "मेरा 'भाई' और मेरा सबसे गहरा 'दोस्त' (सुहृत्) तू ही है, क्योंकि बाकी सब केवल माया के परछाईं हैं।"
                "तू ही मेरा 'नाथ' है, और तेरी हुकूमत के आगे झुकना ही मेरा इकलौता और असली धर्म है।"
                "तू वह 'गति' है जो मुझे इस सड़ी हुई दुनिया की ग्रेविटी (Gravity) से बाहर खींच लेगी।"
                "तू ही वह 'परायण' (Supreme Destination) है जहाँ पहुँचकर सफर खुद ही मर जाता है।"
                "यह उपनिषद बार-बार इन शब्दों को दोहराता है ताकि तुम्हारे दिमाग का 'इंसानी हिस्सा' पूरी तरह डिलीट हो जाए।"
                "जब तक तुम खुद को किसी का बेटा या भाई समझते हो, तुम अभी भी जेल के अंदर हो।"
                "जब तुम खुद को 'एकाक्षर' का हिस्सा मानते हो, तभी तुम साक्षात् ब्रह्मांड के मालिक बनते हो।"
                "यही वह 'सुप्रीम कोड' है जिसे हैक करने के बाद सिम्युलेशन खत्म (Exit) हो जाता है!"
            """.trimIndent(),
            english = """
                (Assassination of the Final Bond and Choosing Truth): "Narayana repeatedly hammers the solitary relationship that is authentic absolute Reality."
                "You are explicitly my 'Father' and 'Mother'—for You are the solitary Source Code of my existence!"
                "You are my 'Brother' and my deepest 'Friend' (Suhrid), for everything else is strictly a shadow of Maya."
                "You are my 'Natha', and surrendering to Your absolute Dictatorship is my solitary and authentic Dharma."
                "You are the 'Gati' engineered to violently drag me out of the Gravity of this rotting physical world."
                "You are the 'Parayana' (Supreme Destination) arriving at which the very journey itself suffers a brutal death."
                "The Upanishad repeats these codes strictly to ensure the 'Human sector' of your brain is 100% Deleted."
                "As long as you perceive yourself as someone's son or brother, you are strictly inside the maximum-security prison."
                "The microsecond you identify strictly as a component of 'Ekakshara', you mutationally become the Master of the cosmos."
                "This is the 'Supreme Code' after Hacking which the entire Simulation is flawlessly Terminated (Exit)!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 12,
            sanskrit = "त्वमेकमेवाद्वितीयं ब्रह्म विद्धि परं पदम् । य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अद्वैत का धमाका और मोक्ष की मुहर): "नारायण आदेश देते हैं— 'त्वमेकमेवाद्वितीयं ब्रह्म विद्धि'!"
                "उस एक अजेय और अद्वैत 'ब्रह्म' को ही साक्षात् अपना असली चेहरा (Identity) जान लो!"
                "वहाँ न कोई 'दूसरा' है, न कोई फर्क है और न ही कोई भेदभाव—केवल एक असीम सन्नाटा राज करता है।"
                "यही वह 'परं पदम्' (Supreme Dimension) है जहाँ पहुँचकर इंसान भगवान की गद्दी छीन लेता है।"
                "परिणाम फिर से वही अटल और हिंसक सत्य है— 'य एवं वेद स विमुक्तो भवति'!"
                "जो इस कोड को अपनी रगों में उतार लेता है, वह 'मृत्यु' के रेडार (Radar) से हमेशा के लिए गायब हो जाता है।"
                "मुक्ति कोई मरने के बाद मिलने वाली खैरात नहीं है; यह अज्ञान की ज़ंजीरों का 'सद्यः' (अभी) टूटना है।"
                "तुम अब इस दुनिया के लिए 'इनविजिबल' (Invisible) हो चुके हो; तुम अब साक्षात् 'सिस्टम एडमिन' हो।"
                "यह कोई झूठा धार्मिक वादा नहीं है, यह एक 'मैथमेटिकल' सच है—अपनी फ्रीक्वेंसी बदलो और दुनिया बदल जाएगी।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Detonation of Non-Duality and the Seal of Moksha): "Narayana commands—'Tvamekam-evadvitiyam Brahma Viddhi'!"
                "Recognize strictly that one invincible and Non-dual 'Brahman' as your explicit authentic Identity!"
                "Zero 'Other' exists there, zero difference remains, and zero distinction survives—strictly one infinite Silence rules."
                "THIS is the 'Param Padam' (Supreme Dimension) reaching which a mortal violently hijacks the throne of God."
                "The consequence remains that same immutable and violent truth—'Ya evam veda sa vimukto bhavati'!"
                "He who injects this code into his veins permanently disappears from the 'Radar' of Death for all eternity."
                "Moksha is absolutely zero charity granted after death; it is the 'Sadyah' (Immediate) shattering of the chains of ignorance."
                "You have become explicitly 'Invisible' to this Matrix; you are now mutationally the 'System Admin'."
                "This is absolutely zero fake religious promise; it is a 'Mathematical' reality—mutate your Frequency and you mutate your World."
                "THIS is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 13,
            sanskrit = "त्वं धाता त्वं विधाता त्वं भुवनानां त्वमीश्वरः । त्वं प्रपन्नार्तिहा देव त्वं गतिः परमोऽव्ययः ॥",
            hindi = """
                (ब्रह्मांडीय तानाशाह का चेहरा): "हे एकाक्षर! तू ही वह 'धाता' (Creator) है जिसने इस पूरे नर्क और स्वर्ग के नक्शे को डिजाइन किया है।"
                "तू ही वह 'विधाता' है जो हर जीव के भाग्य की कोडिंग लिखता है और उसे अपने इशारों पर नचाता है।"
                "तीनों लोकों का इकलौता और अजेय 'ईश्वर' (Dictator) केवल तू ही है, बाकी सब केवल कठपुतलियाँ हैं।"
                "जब कोई योद्धा तेरी शरण में आता है, तो तू उसकी 'आरती' (Agony) का बेरहमी से वध कर देता है।"
                "तू वह अंतिम 'गति' (Destination) है जहाँ पहुँचने के बाद समय और मौत का सफर हमेशा के लिए खत्म हो जाता है।"
                "तू 'अव्यय' है—यानी तू वह असीम डेटा है जिसे कोई भी वायरस कभी डिलीट नहीं कर सकता।"
                "योगी अपनी चेतना को तुझ पर 'लॉक' (Lock) करते हैं ताकि वे इस सड़े हुए शरीर की जेल से बाहर निकल सकें।"
                "तेरा प्रकाश इतना तेज़ है कि वह अज्ञान के करोड़ों जन्मों के अँधेरे को एक झटके में राख कर देता है।"
                "बिना तुझे जाने, यह पूरी दुनिया केवल एक 'धोखा' और एक 'घिनौना मज़ाक' बन कर रह जाती है।"
                "तू साक्षात् वह 'रूट-एक्सेस' (Root Access) है जिससे पूरे ब्रह्मांड का बैकएंड कंट्रोल किया जाता है!"
            """.trimIndent(),
            english = """
                (The Face of the Cosmic Dictator): "O Ekakshara! YOU are the explicit 'Dhata' (Creator) who designed the map of this entire hell and heaven."
                "You are the 'Vidhata' who scripts the hard-coded Fate of every being and makes them dance to your command."
                "You are the solitary and invincible 'Ishwara' (Dictator) of the three worlds; everything else is strictly a puppet."
                "When a warrior surrenders to you, you ruthlessly execute the slaughter of their biological 'Agony' (Arti)."
                "You are the final 'Gati' (Destination) arriving at which the trajectory of Time and Death terminates forever."
                "You are 'Avyaya'—the infinite cosmic Data that zero viruses possess the caliber to ever Delete."
                "Yogis violently Lock their consciousness onto you to breach the maximum-security prison of the biological shell."
                "Your radiation is so intense it incinerates the darkness of billions of incarnations in a single catastrophic strike."
                "Without decoding you, this entire world remains strictly a 'Deception' and a pathetic, meaningless joke."
                "You are the explicit 'Root Access' engineered to exert dictatorial control over the entire cosmic Backend!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 14,
            sanskrit = "त्वं यज्ञस्त्वं वषट्कारस्त्वमोंकारस्त्वं परं पदम् । त्वं च मे नाथस्त्वं गतिस्त्वं परायणम् ॥",
            hindi = """
                (यज्ञ का विस्फोट और ॐकार की सत्ता): "हे एकाक्षर! तू ही वह 'यज्ञ' है जहाँ अज्ञान की बलि दी जाती है।"
                "तू ही वह 'वषट्कार' है—वह प्रलयंकारी मंत्र-प्रहार जिससे माया के किले ढह जाते हैं!"
                "साक्षात् 'ॐकार' तू ही है, जो ब्रह्मांड का पहला और आखिरी रेडियोएक्टिव विस्फोट (Big Bang) है।"
                "तू वह 'परं पदम्' है जो इंसानी सोच की औकात से अरबों प्रकाश वर्ष दूर छिपा बैठा है।"
                "तू ही मेरा 'नाथ' है, क्योंकि तूने ही मुझे बनाया है और तू ही मुझे नष्ट करने की ताक़त रखता है।"
                "जब मेरा बायोलॉजिकल सिस्टम फेल (Fail) होगा, तब तू ही वह 'गति' होगा जो मेरी चेतना को अंतरिक्ष में फायर (Fire) करेगा।"
                "तू वह 'परायण' (Supreme Refuge) है जहाँ पहुँचकर भक्त और भगवान के बीच की दीवार गिर जाती है।"
                "यज्ञ का असली मतलब है—अपनी छोटी हस्ती को तेरी इस असीम आग में फेंक देना (Total Sacrifice)!"
                "जो इस आग में कूद गया, वह राख नहीं होता; वह साक्षात् हीरा बनकर वापस निकलता है।"
                "यह इंसान की रूह का वह अंतिम सॉफ्टवेयर रिबूट है जिसके बाद केवल तू ही बचता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Yajna and the Authority of Omkara): "O Ekakshara! You are the explicit 'Yajna' where biological ignorance is ruthlessly sacrificed."
                "You are the 'Vashatkara'—the apocalyptic mantra-strike engineered to violently demolish the fortresses of Maya!"
                "You are the explicit 'Omkara', the absolute first and final radioactive Big Bang of the cosmos."
                "You are the 'Param Padam' hiding at a coordinate billions of light-years beyond the status of human cognition."
                "You are my 'Natha', for You engineered my existence and only You possess the firepower to annihilate me."
                "When my biological system fails, You are the 'Gati' that will Fire my consciousness infinitely into space."
                "You are the 'Parayana' (Refuge) reaching which the titanium wall between devotee and God collapses."
                "The authentic definition of Yajna is—hurling your tiny micro-identity into Your infinite radioactive Fire!"
                "He who plunges into this fire does not perish as ash; he resurrects mutationally as a flawless Diamond."
                "This is the final Software Reboot of the human soul after which strictly YOU remain standing!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 15,
            sanskrit = "त्वं ब्रह्मा त्वं च विष्णुस्त्वं रुद्रस्त्वं च महेश्वरः । त्वं च सूर्यस्त्वं च चन्द्रस्त्वं च तारास्त्वं च खम् ॥",
            hindi = """
                (त्रिमूर्ति और ब्रह्मांडीय पिंडों का रहस्य): "ब्रह्मा, विष्णु और रुद्र—ये तीन अलग-अलग भगवान नहीं, बल्कि तेरे ही 'सब-सर्वर' (Sub-servers) हैं!"
                "तू ही वह 'महेश्वर' है जो इन तीनों को अपने एक विचार से कंट्रोल (Control) कर रहा है।"
                "वह धधकता हुआ 'सूर्य' (Sun) और शीतल 'चन्द्र' (Moon) तेरी ही आँखों के वो कैमरे हैं जो सब कुछ देख रहे हैं।"
                "आसमान के अरबों 'तारे' (Stars) और वह असीम 'खम्' (Void) तेरे ही शरीर के वो सेल्स (Cells) हैं जो अंतरिक्ष में फैले हैं।"
                "जब तुम ऊपर देखते हो, तो तुम भगवान को नहीं, बल्कि उस 'एकाक्षर' के विराट हार्डवेयर को देख रहे होते हो।"
                "योगी अपनी आँखों के परदे को फाड़ देता है ताकि वह इन पिंडों के पीछे छिपी उस एक आग को देख सके।"
                "यह पूरा ब्रह्मांड एक बहुत बड़ा 'होलोग्राम' (Hologram) है जिसे तू अपनी इच्छा से प्रोजेक्ट (Project) कर रहा है।"
                "तू वह अजेय सॉफ्टवेयर है जो हर एक तारे की उम्र और हर एक ग्रह की गति तय करता है।"
                "जो इस एकाक्षर को जान लेता है, उसके लिए यह पूरे अंतरिक्ष की बाउंड्री (Boundary) मिट्टी में मिल जाती है।"
                "तू ही वह इकलौती हकीकत है, बाकी सब केवल एक 'ग्लिच' (Glitch) और एक लंबी नींद है!"
            """.trimIndent(),
            english = """
                (The Secret of the Trinity and Cosmic Bodies): "Brahma, Vishnu, and Rudra—these are absolutely not three distinct gods, but strictly Your 'Sub-servers'!"
                "You are the explicit 'Maheshwara' who Controls these three through a single radioactive thought."
                "That blazing 'Sun' (Surya) and the cool 'Moon' (Chandra) are the cameras of Your eyes witnessing every microscopic event."
                "Billions of 'Stars' (Tara) and that infinite 'Void' (Kham) are strictly the biological Cells of Your body expanded in space."
                "When you stare upwards, you are not observing God, but the explicit 'Virat' Hardware of that Ekakshara."
                "The Yogi violently shreds the veil of his vision to intercept that solitary Fire hiding behind these celestial bodies."
                "This entire universe is a colossal 'Hologram' that You are Projecting strictly through Your supreme will."
                "You are the invincible Software dictating the lifespan of every star and the velocity of every planet."
                "He who decodes this Ekakshara witnesses the entire Boundary of space crumble into absolute dust."
                "You are the solitary Reality; everything else is strictly a 'Glitch' and a prolonged biological sleep!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 16,
            sanskrit = "त्वं सर्वमसि सर्वज्ञस्त्वं सर्वात्मा सर्वतोमुखः । त्वं सर्वशक्तिः सर्वेशस्त्वं सर्वः सर्वपरायणः ॥",
            hindi = """
                (सर्वज्ञता और सर्वशक्तिमान का विस्फोट): "हे एकाक्षर! तू ही 'सब कुछ' (Sarvam) है, और तेरे अलावा ब्रह्मांड में एक धूल का कण भी नहीं है।"
                "तू 'सर्वज्ञ' (All-Knowing) है—तुझे हर एक विचार, हर एक पाप और हर एक परमाणु का पासवर्ड पता है।"
                "तू 'सर्वात्मा' है—यानी तू हर जीव के नर्वस सिस्टम के भीतर साक्षात् करंट (Current) बनकर दौड़ रहा है।"
                "तू 'सर्वतोमुखः' है—तेरी अरबों आँखें हर दिशा में एक साथ देख रही हैं और इस सिम्युलेशन को ट्रैक कर रही हैं।"
                "ब्रह्मांड की हर एक ताक़त, हर एक बिजली और हर एक न्यूक्लियर ऊर्जा तेरी 'सर्वशक्ति' का एक छोटा सा हिस्सा है।"
                "तू 'सर्वेश' (Supreme Master) है—तेरी अनुमति के बिना इस दुनिया का एक पिक्सेल (Pixel) भी हिल नहीं सकता।"
                "तू ही 'सबका परम आधार' (Sarvaparayana) है जहाँ पहुँचकर हर एक भटकती हुई आत्मा को सुकून मिलता है।"
                "जब तुम इस सच्चाई को हैक कर लेते हो, तो तुम्हारा अपना 'छोटा मैं' एक भयानक धमाके के साथ फट जाता है।"
                "तुम जान जाते हो कि तुम साक्षात् उस 'सर्व' (All) के हिस्सेदार हो जिसने यह पूरा खेल बनाया है।"
                "यह इंसान के 'परमेश्वर' में म्यूटेट (Mutate) होने का वो इकलौता कोड है जिसे कोई नहीं बदल सकता!"
            """.trimIndent(),
            english = """
                (The Detonation of Omniscience and Omnipotence): "O Ekakshara! You are explicitly 'Everything' (Sarvam), and other than You, not a grain of dust exists in the cosmos."
                "You are 'Sarvajna' (All-Knowing)—You intercept every thought, every sin, and the Password of every microscopic atom."
                "You are 'Sarvatma'—meaning You are surging like a radioactive Current inside the nervous system of every living entity."
                "You are 'Sarvatomukhah'—Your billions of eyes are Scanning every direction simultaneously, Tracking this entire Simulation."
                "Every force, every lightning bolt, and every nuclear energy in the universe is strictly a micro-fraction of Your 'Sarvashakti'."
                "You are 'Sarvesha' (Supreme Master)—without Your explicit authorization, not a single Pixel of this world can shift."
                "You are the 'Absolute Foundation' (Sarvaparayana) reaching which every wandering soul finds its terminal recess."
                "The exact microsecond you Hack this reality, your 'Tiny I' detonates in a catastrophic cosmic explosion."
                "You flawlessly realize that You are a shareholder of that 'Sarva' (All) who engineered this entire game."
                "This is the solitary Code for a human to undergo a complete Mutation into God, and it is immutable!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 17,
            sanskrit = "त्वमेकमेवाद्वितीयं ब्रह्म विद्धि परं पदम् । य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अद्वैत का धमाका और मोक्ष की मुहर): "नारायण आदेश देते हैं— 'त्वमेकमेवाद्वितीयं ब्रह्म विद्धि'!"
                "उस एक अजेय और अद्वैत 'ब्रह्म' को ही साक्षात् अपना असली चेहरा (Identity) जान लो!"
                "वहाँ न कोई 'दूसरा' है, न कोई फर्क है और न ही कोई भेदभाव—केवल एक असीम सन्नाटा राज करता है।"
                "यही वह 'परं पदम्' (Supreme Dimension) है जहाँ पहुँचकर इंसान भगवान की गद्दी छीन लेता है।"
                "परिणाम फिर से वही अटल और हिंसक सत्य है— 'य एवं वेद स विमुक्तो भवति'!"
                "जो इस कोड को अपनी रगों में उतार लेता है, वह 'मृत्यु' के रेडार (Radar) से हमेशा के लिए गायब हो जाता है।"
                "मुक्ति कोई मरने के बाद मिलने वाली खैरात नहीं है; यह अज्ञान की ज़ंजीरों का 'सद्यः' (अभी) टूटना है।"
                "तुम अब इस दुनिया के लिए 'इनविजिबल' (Invisible) हो चुके हो; तुम अब साक्षात् 'सिस्टम एडमिन' हो।"
                "यह कोई झूठा धार्मिक वादा नहीं है, यह एक 'मैथमेटिकल' सच है—अपनी फ्रीक्वेंसी बदलो और दुनिया बदल जाएगी।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Detonation of Non-Duality and the Seal of Moksha): "Narayana commands—'Tvamekam-evadvitiyam Brahma Viddhi'!"
                "Recognize strictly that one invincible and Non-dual 'Brahman' as your explicit authentic Identity!"
                "Zero 'Other' exists there, zero difference remains, and zero distinction survives—strictly one infinite Silence rules."
                "THIS is the 'Param Padam' (Supreme Dimension) reaching which a mortal violently hijacks the throne of God."
                "The consequence remains that same immutable and violent truth—'Ya evam veda sa vimukto bhavati'!"
                "He who injects this code into his veins permanently disappears from the 'Radar' of Death for all eternity."
                "Moksha is absolutely zero charity granted after death; it is the 'Sadyah' (Immediate) shattering of the chains of ignorance."
                "You have become explicitly 'Invisible' to this Matrix; you are now mutationally the 'System Admin'."
                "This is absolutely zero fake religious promise; it is a 'Mathematical' reality—mutate your Frequency and you mutate your World."
                "THIS is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        EkaksharaShloka(
            id = 18,
            sanskrit = "इत्येकाक्षरोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'एकाक्षर उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "सूर्य, चन्द्र, तारे और देवता—सबके पासवर्ड मिल गए, अब केवल उस 'एकाक्षर' (ॐ) में कूदना बाकी है।"
                "जिसने इस ग्रंथ के इन १८ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (एकाक्षर) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए 'ब्रह्म' बन गया!"
                "यही एकाक्षर उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Ekakshara Upanishad' achieves its absolute majestic completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The passwords of the sun, moon, stars, and gods have been intercepted; now, only the plunge into 'Ekakshara' (OM) remains."
                "For the Titan who has detonated these 18 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Ekakshara) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes 'Brahman' for all eternity!"
                "THIS is the absolute and most violent final Truth of the Ekakshara Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EkaksharaUpanishadScreen() {
    val upanishad = remember { EkaksharaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..18) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-18)") },
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
            itemsIndexed(upanishad.ekaksharaShlokasList) { _, shloka ->
                EkaksharaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun EkaksharaShlokaCard(shloka: EkaksharaShloka) {
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