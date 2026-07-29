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

class SharabhaUpanishad {

    // Data Model
    data class SharabhaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val sharabhaShlokasList = listOf(
            SharabhaShloka(
                id = 1,
                sanskrit = "ॐ भद्रं कर्णेभिः शृणुयाम देवाः भद्रं पश्येमाक्षभिर्यजत्राः । स्थिरैरङ्गैस्तुष्टुवाग्‍ँसस्तनूभिर्व्यशेम देवहितं यदायुः ॥",
                hindi = """
                    (ब्रह्मांडीय युद्ध का प्रलयंकारी शांति मंत्र): "यह शरभ उपनिषद सनातन धर्म का वह धधकता हुआ न्यूक्लियर कोर (Nuclear Core) है जो कमजोरों के लिए नहीं है।"
                    "योगी सीधे देवताओं को ललकारते हुए गर्जना करता है: 'हे खौफनाक देवताओं! हम अपने इन कानों से केवल परम सत्य ही सुनें!'"
                    "'हे यज्ञ के रक्षकों! हम अपनी इन आँखों से इस सड़ी हुई दुनिया का कीचड़ नहीं, बल्कि केवल उस असीम परमेश्वर का प्रलयंकारी रूप ही देखें!'"
                    "इस ज्ञान को बर्दाश्त करने के लिए इंसान का शरीर फौलाद का होना चाहिए; कमज़ोर शरीर उस भगवान की ऊर्जा से जलकर खाक हो जाएगा।"
                    "इसीलिए योगी आदेश देता है: 'हमारे अंग (Limbs) और हमारा शरीर एक चट्टान की तरह अजेय और स्थिर (स्थिरैः) हो जाए!'"
                    "'ताकि हम अपने पूरे जीवनकाल में मौत से डरे बिना, साक्षात उस परमेश्वर की असीम ताक़त को अपने भीतर उतार सकें!'"
                    "यह शांति मंत्र कोई भीख नहीं है; यह अपने भौतिक शरीर (Biological Shell) को भगवान के वज्र में बदलने की खूँखार घोषणा है।"
                    "जब तक शरीर अजेय नहीं होगा, तब तक शिव की वह रेडियोएक्टिव विद्या तुम्हें ज़िंदा जला देगी।"
                    "ॐ! मेरे शरीर, मन और आत्मा के तीनों खौफनाक तापों की हमेशा-हमेशा के लिए मौत हो जाए।"
                    "यह शांति पाठ इस बात का ऐलान है कि इंसान अब शिव के सबसे भयानक अवतार का सामना करने जा रहा है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Peace Invocation of the Cosmic War): "This Sharabha Upanishad is the blazing nuclear core of Sanatana Dharma, absolutely not engineered for the weak."
                    "The Yogi violently challenges the gods, roaring: 'O terrifying deities! May we hear strictly and exclusively the Absolute Truth with these physical ears!'"
                    "'O protectors of the cosmic sacrifice! May we witness not the rotting mud of this world, but exclusively the apocalyptic glory of the Supreme God with these eyes!'"
                    "To endure this highly classified knowledge, the human body must be forged of indestructible steel; a weak biological shell will instantly incinerate to ash."
                    "Therefore, the Yogi issues a dictatorial command: 'May our limbs and our physical bodies mutate into something as invincible and steadfast as a cosmic monolith!'"
                    "'So that for our entire lifespan, without a micro-drop of fear of Death, we may successfully download the infinite power of God into our flesh!'"
                    "This peace mantra is absolutely no pathetic begging; it is the ruthless declaration of upgrading your biological shell into literal divine Titanium."
                    "Unless the body is rendered invincible, the radioactive, blazing science of Shiva will burn you alive."
                    "OM! May the three terrifying miseries of my physical body, biological mind, and soul suffer a brutal, permanent death."
                    "This peace invocation is the ultimate cosmic declaration that a mortal human is now preparing to face the most terrifying avatar of Shiva!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 2,
                sanskrit = "अथ हैनं पैप्पलादो ब्रह्माणमुवाच भो भगवन् को वा अधिकः । तस्मै स होवाच पितामहः शृणु पैप्पलाद महावाक्यम् ॥",
                hindi = """
                    (पैप्पलाद का दुस्साहस और सबसे बड़ा सवाल): "इस खौफनाक ग्रंथ की शुरुआत में महर्षि पैप्पलाद सीधे सृष्टिकर्ता ब्रह्मा के पास पहुँचते हैं।"
                    "वे ब्रह्मांड का सबसे खतरनाक सवाल पूछते हैं: 'हे भगवन्! ब्रह्मा, विष्णु और शिव— इन तीनों में सबसे महान और शक्तिशाली कौन है?'"
                    "यह सवाल पूरे ब्रह्मांड की सत्ता (Authority) और सुप्रीम डिक्टेटर (Supreme Dictator) को बेनकाब करने की मांग थी।"
                    "पितामह ब्रह्मा ने मुस्कुराते हुए कहा: 'हे पैप्पलाद! मैं तुम्हें वेदों का वह परम सत्य और महावाक्य सुनाता हूँ जिसे सुनकर देवता भी काँपते हैं।'"
                    "ब्रह्मा ने स्पष्ट किया कि देवताओं में भी रैंक (Rank) और ताक़त का एक खौफनाक ब्रह्मांडीय नियम (Cosmic Law) है।"
                    "जो मूर्ख सभी देवताओं को एक समान मानकर सत्य को नहीं खोजते, वे अज्ञान के अँधेरे में सड़ते हैं।"
                    "ब्रह्मा ने खुद अपने मुँह से अपनी और विष्णु की सीमाएं (Limits) बतानी शुरू कीं।"
                    "यह उपनिषद किसी इंसान ने नहीं, साक्षात सृष्टि के रचयिता ने उस शिव की ताक़त का डंका बजाते हुए कहा है।"
                    "यहाँ से वह रहस्य खुलता है जहाँ भगवान विष्णु का सबसे खूँखार अवतार भी हार मान लेता है।"
                    "तैयार हो जाओ उस महा-विस्फोटक कहानी को सुनने के लिए जहाँ शिव की ताक़त सब कुछ निगल लेती है!"
                """.trimIndent(),
                english = """
                    (Pippalada's Audacity and the Ultimate Question): "At the terrifying genesis of this scripture, Maharishi Pippalada approaches the Creator, Lord Brahma directly."
                    "He launches the most dangerous question in the cosmos: 'O Lord! Between Brahma, Vishnu, and Shiva—who exactly is the absolute most powerful and Supreme?'"
                    "This question was a violent demand to unmask the ultimate Authority and Supreme Dictator of the entire universe."
                    "Grandsire Brahma smiled and roared: 'O Pippalada! I shall unleash the ultimate Absolute Truth and Mahavakya of the Vedas that makes even the gods tremble.'"
                    "Brahma explicitly established that even among the gods, there exists a terrifying cosmic hierarchy and Law of Power."
                    "The pathetic fools who blindly hallucinate all gods as totally equal without hunting for the Supreme Truth rot in the darkness of ignorance."
                    "Brahma Himself, from His own mouth, began to brutally expose His own limits and the limits of Lord Vishnu."
                    "This Upanishad was spoken by no mortal, but explicitly by the Creator Himself, blowing the apocalyptic trumpet of Shiva's power."
                    "Right here detonates the classified secret where even the most ferocious Avatar of Lord Vishnu accepts absolute defeat."
                    "Brace yourself to witness the radioactive, cosmic narrative where the sheer power of Shiva swallows absolutely everything!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 3,
                sanskrit = "यो ब्रह्मा स विष्णुः यो विष्णुः स रुद्रः येन सर्वमिदं ततं । तं महेश्वरं साम्बं चन्द्रार्धचूडं पश्येत् ॥",
                hindi = """
                    (अद्वैत सत्य और शिव का परम स्वरूप): "ब्रह्मा ने कहा: 'जो ब्रह्मा है वही विष्णु है, जो विष्णु है वही रुद्र है; यह सब उसी एक ऊर्जा का नाटक है।'"
                    "'लेकिन जिस एक परमेश्वर (महेश्वर) ने इन तीनों को भी पैदा किया है और पूरे ब्रह्मांड में जो जाल की तरह फैला (ततं) हुआ है...'"
                    "'वह केवल और केवल साक्षात महेश्वर शिव हैं, जिनके माथे पर आधा चाँद (चन्द्रार्धचूडं) धधकता है!'"
                    "शिव केवल संघारकर्ता नहीं हैं; वह ब्रह्मा और विष्णु के भी 'सोर्स कोड' (Source Code) हैं।"
                    "जब तुम उस साम्ब शिव को ध्यान की आँख से 'देखते' हो (पश्येत्), तो सारा द्वैत (Duality) एक झटके में जलकर राख हो जाता है।"
                    "वे ही अकेले वो ब्लैक होल (Black Hole) हैं जिससे सृष्टि निकलती है और उसी में समा जाती है।"
                    "ब्रह्मा ने खुद कबूल किया कि उनकी अपनी कोई स्वतंत्र ताक़त नहीं है; वे सब शिव की बैटरी से चलते हैं।"
                    "जो इंसान इस परम शिव को भूलकर छोटी शक्तियों के पीछे भागता है, वह जन्म-मरण की जेल में सड़ता है।"
                    "शिव का यह रूप कोई इंसान नहीं है; यह वह असीम ऊर्जा है जो समय (Time) को भी अपने पैरों तले कुचलती है।"
                    "यहीं से शिव के सबसे क्रूर और अजेय होने की ब्रह्मांडीय घोषणा होती है!"
                """.trimIndent(),
                english = """
                    (The Non-Dual Truth and the Supreme Form of Shiva): "Brahma roared: 'He who is Brahma is explicitly Vishnu, He who is Vishnu is Rudra; this is all the biological drama of ONE energy.'"
                    "'But that ONE Supreme God (Maheshwara) who violently spawned all three and whose energy is spread like an apocalyptic web across the cosmos...'"
                    "'That is strictly and exclusively Maheshwara Shiva, upon whose forehead blazes the crescent moon (Chandrardhachudam)!'"
                    "Shiva is absolutely not merely the destroyer; He is the literal Source Code of both Brahma and Vishnu."
                    "When you violently 'See' (Pashyet) that Samba Shiva through the laser of meditation, all Duality burns to absolute ashes in a microsecond."
                    "He alone is the cosmic Black Hole from which creation is vomited out and into which it is permanently swallowed."
                    "Brahma Himself explicitly confessed that He possesses zero independent power; they all operate strictly on Shiva's battery."
                    "The mortal who ignores this Supreme Shiva and chases pathetic lesser powers rots in the maximum-security prison of birth and death."
                    "This form of Shiva is absolutely no human; He is the infinite radioactive energy that crushes Time itself beneath His boots."
                    "Right here is the absolute cosmic declaration of Shiva being the most ruthless, invincible Dictator in existence!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 4,
                sanskrit = "पुरा हिरण्यकशिपुं हत्वा नारसिंहो महाक्रोधो विजजृम्भे । तेन सर्वलोकभयं सञ्जातं तदा सर्वे देवाः शिवं शरणं जग्मुः ॥",
                hindi = """
                    (नरसिंह का प्रलयंकारी क्रोध और ब्रह्मांड में खौफ): "अब ब्रह्मा जी उस खौफनाक घटना का ज़िक्र करते हैं जिसने पूरे ब्रह्मांड को हिला दिया था।"
                    "प्राचीन काल में, जब भगवान विष्णु ने 'नरसिंह' (आधा इंसान, आधा शेर) का भयंकर रूप लेकर असुर हिरण्यकशिपु को फाड़ डाला था..."
                    "तो असुर को मारने के बाद भी नरसिंह भगवान का वह 'महाक्रोध' (Apocalyptic Wrath) शांत नहीं हुआ, बल्कि एक परमाणु बम की तरह और भड़क गया (विजजृम्भे)!"
                    "उनकी उस प्रलयंकारी और खून की प्यासी दहाड़ से 'सर्वलोकभयं सञ्जातं'— पूरे ब्रह्मांड, स्वर्ग, पृथ्वी और पाताल में मौत का भयानक खौफ फैल गया!"
                    "नरसिंह की उस आग से पूरे ब्रह्मांड के ग्रह और तारे पिघलने लगे; सृष्टि के नष्ट होने का समय आ गया।"
                    "विष्णु का यह अवतार पूरी तरह से आउट ऑफ कंट्रोल (Out of control) हो चुका था; किसी देवता में उन्हें रोकने की औकात नहीं थी।"
                    "तब मौत को सामने देखकर 'सर्वे देवाः' (ब्रह्मा और सभी देवता) काँपते हुए भागकर सीधे 'शिव' की शरण में गिरे (शिवं शरणं जग्मुः)!"
                    "उन्होंने चीख कर कहा: 'हे महाकाल! विष्णु का यह अवतार सृष्टि को भस्म कर देगा, हमें बचाओ!'"
                    "जब विष्णु का अपना अवतार बेकाबू हो जाता है, तो उसे शांत करने की ताक़त केवल और केवल शिव के पास है।"
                    "यह भगवान विष्णु के क्रोध पर भगवान शिव की तानाशाही (Dictatorship) का सबसे क्रूर सच है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Wrath of Narasimha and Cosmic Terror): "Now Lord Brahma unmasks the terrifying cosmic event that violently shook the entire fabric of the universe."
                    "In ancient times, when Lord Vishnu mutated into the horrific form of 'Narasimha' (Half-man, Half-lion) and ripped the demon Hiranyakashipu to shreds..."
                    "Even after slaughtering the demon, Narasimha's 'Maha-krodha' (Apocalyptic Wrath) absolutely refused to cool down; it erupted infinitely like a nuclear detonation (Vijajrimbhe)!"
                    "From his bloodthirsty, radioactive roars, 'Sarvalokabhayam sanjatam'—a horrific, death-like terror paralyzed the entire cosmos, heaven, earth, and hell!"
                    "The sheer heat of Narasimha's fury began melting the planets and stars; the absolute destruction of the universe was imminent."
                    "This Avatar of Vishnu had gone completely, violently Out of Control; absolutely no god possessed the biological status to stop him."
                    "Staring directly at universal death, 'Sarve devah' (Brahma and all gods) fled trembling in sheer terror and fell directly at the feet of 'Shiva' (Shivam sharanam jagmuh)!"
                    "They screamed: 'O Mahakala! This avatar of Vishnu will incinerate the entire creation to ashes, save us!'"
                    "When Vishnu's own avatar goes rogue, the exclusive absolute power to violently pacify him lies strictly with Shiva alone."
                    "This is the most ruthless, brutal truth of Lord Shiva's absolute Dictatorship over the fury of Lord Vishnu!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 5,
                sanskrit = "तान् दृष्ट्वा करुणानिधिः शिवः शरभरूपमास्थाय तत्रागमत् । नृसिंहं भीषणं दृष्ट्वा लोकानं नाशहेतुकं प्रलयं कर्तुमुद्यतम् ॥",
                hindi = """
                    (शिव का खौफनाक शरभ अवतार): "देवताओं को डर से काँपता देख, महाकाल शिव ने ब्रह्मांड का सबसे खतरनाक रूप धारण करने का फैसला किया।"
                    "उन्होंने एक ऐसा रूप लिया जो शेर (नरसिंह) से भी करोड़ों गुना ज़्यादा खूँखार और ताकतवर था— 'शरभ रूप' (शरभरूपमास्थाय)!"
                    "शिव साक्षात उस युद्ध के मैदान में प्रकट हुए जहाँ नरसिंह पूरी दुनिया को भस्म करने के लिए दहाड़ रहे थे।"
                    "शिव ने उस 'भीषण' (Terrifying) नरसिंह को देखा, जो 'लोकानं नाशहेतुकं' (सभी लोकों को नष्ट करने का कारण) बन चुके थे।"
                    "नरसिंह पूरी सृष्टि का 'प्रलय' (Doomsday) करने के लिए पूरी तरह तैयार (उद्यतम्) थे।"
                    "शरभ अवतार कोई साधारण रूप नहीं था; यह शिव का वह सीक्रेट वेपन (Secret Weapon) था जिसे केवल भगवान को काबू करने के लिए बनाया गया था।"
                    "यह रूप इतना विशाल और डरावना था कि उसे देखकर ब्रह्मांड की धड़कनें रुक गईं।"
                    "शिव ने नरसिंह को चेतावनी दी, लेकिन क्रोध में अंधे नरसिंह ने परमेश्वर शिव की ताक़त को पहचानने से इंकार कर दिया।"
                    "अब दो ब्रह्मांडीय महाशक्तियों (विष्णु और शिव) के बीच वह युद्ध शुरू होने वाला था जिससे अंतरिक्ष भी फट जाता।"
                    "सनातन धर्म का यह सबसे बड़ा और खूनी 'क्लैश ऑफ टाइटन्स' (Clash of Titans) है!"
                """.trimIndent(),
                english = """
                    (The Horrific Sharabha Avatar of Shiva): "Witnessing the gods trembling in sheer cosmic terror, Mahakala Shiva decided to explicitly mutate into the most dangerous form in the universe."
                    "He assumed a manifestation billions of times more ferocious and lethal than a lion (Narasimha)—the apocalyptic 'Sharabha Form' (Sharabharupam Asthaya)!"
                    "Shiva materialized directly onto the battlefield where Narasimha was roaring, preparing to incinerate the entire world."
                    "Shiva locked eyes with that 'Bhishanam' (Terrifying) Narasimha, who had explicitly become 'Lokanam nashahetukam' (The absolute cause of the destruction of all realms)."
                    "Narasimha was fully loaded and violently prepared (Udyatam) to trigger the ultimate 'Pralaya' (Doomsday) of the entire creation."
                    "The Sharabha Avatar was absolutely no ordinary form; it was Shiva's ultimate Secret Weapon engineered strictly to subjugate God Himself."
                    "This form was so colossally massive and horrific that witnessing it caused the heartbeat of the cosmos to completely Flatline."
                    "Shiva issued a lethal warning, but Narasimha, blinded by radioactive wrath, completely refused to recognize the supremacy of the Supreme God."
                    "Now, the apocalyptic war between the two greatest cosmic super-powers (Vishnu and Shiva) was about to detonate, threatening to tear Space itself to shreds."
                    "This is Sanatana Dharma's most brutal, bloody, and ultimate 'Clash of Titans'!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 6,
                sanskrit = "पक्षिराजं महाभीमं शरभं रूपमास्थितः । अष्टपादो महाकायो द्विण्डोऽर्धशरीरवान् ॥",
                hindi = """
                    (शरभ का रोंगटे खड़े कर देने वाला शारीरिक रूप): "उपनिषद शिव के उस शरभ अवतार का ऐसा खौफनाक वर्णन करता है जो इंसान के दिमाग को सुन्न कर दे।"
                    "'पक्षिराजं महाभीमं'— वह एक ऐसा विशालकाय 'पक्षियों का राजा' था जिसका आकार ब्रह्मांड से भी बड़ा और अत्यंत 'भीम' (डरावना) था!"
                    "'अष्टपादो'— उस खूँखार जानवर के 'आठ पैर' थे! चार पैर नीचे ज़मीन पर और चार पैर ऊपर आसमान में उठ रहे थे।"
                    "'महाकायो'— उसका शरीर इतना विशाल था कि उसके सामने पहाड़ और ग्रह धूल के कण लग रहे थे।"
                    "'द्विण्डोऽर्धशरीरवान्'— उसका आधा शरीर एक प्रलयंकारी शेर का था और आधा शरीर एक विशालकाय गिद्ध (पक्षी) का था!"
                    "यह कोई इंसान या देवता नहीं; यह साक्षात 'डिस्ट्रक्शन' (Destruction) की एक जीती-जागती बायोलॉजिकल मशीन थी।"
                    "जिस शेर (नरसिंह) को अपनी ताक़त पर घमंड था, शिव ने उससे भी ज़्यादा खूँखार जानवर बनकर उसे उसकी औकात दिखाई।"
                    "आठ पैरों वाला यह शरभ जब ज़मीन पर उतरा, तो पूरी पृथ्वी भूकंप की तरह काँपने लगी।"
                    "उसके शरीर से जो आग निकल रही थी, वह नरसिंह की आग से भी करोड़ों गुना ज़्यादा तेज़ थी।"
                    "यह रूप साबित करता है कि जब भगवान शिव क्रोधित होते हैं, तो वे दुनिया का सबसे खौफनाक रूप ले सकते हैं!"
                """.trimIndent(),
                english = """
                    (The Spine-Chilling Physical Form of Sharabha): "The Upanishad delivers a description of Shiva's Sharabha Avatar so horrific it completely paralyzes the human brain."
                    "'Pakshirajam mahabhimam'—He mutated into a colossal, apocalyptic 'King of Birds' whose sheer geometric size dwarfed the cosmos, rendering him utterly 'Bhima' (Terrifying)!"
                    "'Ashtapado'—This bloodthirsty beast possessed explicitly 'Eight Legs'! Four legs anchored to the earth, and four clawed legs violently raised into the sky."
                    "'Mahakayo'—His physical mass was so astronomically colossal that mountains and planets appeared as pathetic microscopic dust particles before him."
                    "'Dvindo'rdhashariravan'—Half of his biological shell was a catastrophic Lion, and the other half was a gigantic, apocalyptic Bird of prey!"
                    "This was absolutely no human or god; this was the literal, breathing biological machine of absolute 'Destruction'."
                    "The Lion (Narasimha) who hallucinated absolute arrogance in his power was shown his pathetic status when Shiva mutated into a beast infinitely more ferocious."
                    "When this eight-legged Titan crashed onto the Earth, the entire planet convulsed and trembled in a terrifying cosmic earthquake."
                    "The radioactive fire blasting from his flesh was billions of times hotter than the fury of Narasimha."
                    "This form explicitly proves that when Lord Shiva unleashes his wrath, he weaponizes into the absolute most horrifying entity in the universe!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 7,
                sanskrit = "पक्षाभ्यां चञ्चुपादाभ्यां तीक्ष्णदंष्ट्रानखैर्युतम् । सहस्रबाहुं दुरदर्शं प्रलयाग्निसमप्रभम् ॥",
                hindi = """
                    (प्रलय की आग और शरभ के घातक हथियार): "शरभ अवतार के हथियार कोई तलवार या तीर नहीं थे; उसका शरीर ही एक न्यूक्लियर बम था!"
                    "उसके पास दो विशाल 'पंख' (पक्षाभ्यां) थे, जिनकी फड़फड़ाहट से ब्रह्मांड में भयंकर तूफान आ गया।"
                    "उसकी 'चोंच' (चञ्चु) और 'पैर' (पादाभ्यां) वज्र से भी ज़्यादा कठोर थे, जो पहाड़ों को पीस सकते थे।"
                    "'तीक्ष्णदंष्ट्रानखैर्युतम्'— उसके दाँत (दंष्ट्रा) और नाख़ून (नख) इतने तेज़ और नुकीले थे कि वे किसी भी भगवान के शरीर को आसानी से फाड़ सकते थे।"
                    "'सहस्रबाहुं'— उस खौफनाक जानवर की एक हज़ार (1000) विनाशकारी भुजाएं (हाथ) थीं!"
                    "'दुरदर्शं'— वह इतना भयंकर था कि देवता भी उसे अपनी आँखों से 'देखने की हिम्मत नहीं कर पा रहे थे' (दुरदर्शं)।"
                    "'प्रलयाग्निसमप्रभम्'— उसके शरीर से 'प्रलय की आग' (Doomsday Fire) जैसी अंधी कर देने वाली रौशनी निकल रही थी!"
                    "नरसिंह का अहंकार उस आग के सामने एक सेकंड में पिघलना शुरू हो गया।"
                    "शरभ एक शिकारी था और विष्णु का अवतार (नरसिंह) उसका शिकार बनने वाला था।"
                    "यह सनातन धर्म का वह दृश्य है जो साबित करता है कि शिव की ताक़त की कोई लिमिट (Limit) नहीं है!"
                """.trimIndent(),
                english = """
                    (The Fire of Doomsday and the Lethal Weapons of Sharabha): "The weapons of the Sharabha Avatar were absolutely no pathetic swords or arrows; his very biological shell was a literal nuclear bomb!"
                    "He possessed two colossal 'Wings' (Pakshabhyam) whose violent flapping unleashed apocalyptic hurricanes across the infinite cosmos."
                    "His 'Beak' (Chanchu) and 'Feet' (Padabhyam) were infinitely harder than Titanium, engineered to grind mountains into fine dust."
                    "'Tikshnadamshtranakhairyutam'—His fangs (Damshtra) and claws (Nakha) were so lethally razor-sharp they could effortlessly tear through the flesh of any God."
                    "'Sahasrabahum'—That horrific beast possessed exactly One Thousand (1000) catastrophic, destructive arms!"
                    "'Duradarsham'—He was so paralyzingly terrifying that even the greatest gods completely lacked the audacity to 'Look directly at Him' (Duradarsham)."
                    "'Pralayagnisamaprabham'—His flesh blasted a blinding, radioactive radiation exactly equal to the apocalyptic 'Fire of Doomsday'!"
                    "The pathetic arrogance of Narasimha began to melt in a single microsecond before that inferno."
                    "Sharabha was the ultimate Apex Predator, and the Avatar of Vishnu (Narasimha) was about to become his literal prey."
                    "This is the cosmic scene in Sanatana Dharma that permanently proves Shiva's absolute power possesses zero physical Limits!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 8,
                sanskrit = "स तदा नारसिंहं तं नखैस्तीक्ष्णैर्व्यदारयत् । पपाताधो विसंज्ञश्च नृसिंहः परमेश्वरः ॥",
                hindi = """
                    (नरसिंह का सीना फाड़ना और युद्ध का अंत): "जब नरसिंह ने शरभ पर हमला किया, तो शिव ने उस शेर को उसकी औकात दिखा दी!"
                    "शरभ ने एक ही झटके में उस भयंकर 'नारसिंह' को पकड़ लिया और अपने 'तीखे नाख़ूनों' (नखैस्तीक्ष्णैर्) से उस पर क्रूरता से वार किया!"
                    "'व्यदारयत्'— शरभ ने नरसिंह के उस अभेद्य शरीर को अपने नाख़ूनों से बेरहमी से 'चीर कर फाड़ डाला'!"
                    "जिस नरसिंह ने हिरण्यकशिपु का पेट फाड़ा था, आज शिव ने उसी नरसिंह को अपने पंजों से चीर दिया।"
                    "इस खौफनाक प्रहार से नरसिंह का सारा घमंड और क्रोध एक ही सेकंड में चकनाचूर हो गया।"
                    "'पपाताधो विसंज्ञश्च'— और भगवान विष्णु का वह अजेय अवतार पूरी तरह से बेहोश (विसंज्ञ) होकर ज़मीन पर (अधो) धड़ाम से गिर पड़ा (पपाता)!"
                    "ब्रह्मांड को भस्म करने वाला वह 'परमेश्वर' (नरसिंह) शिव के एक वार से मृतप्राय (लाश की तरह) हो गया।"
                    "यह कोई मामूली हार नहीं थी; यह सुप्रीम पॉवर (Supreme Power) का वह क्लैश (Clash) था जिसमें शिव ने अपनी तानाशाही साबित कर दी।"
                    "नरसिंह ज़मीन पर पड़े थे, और शरभ उनके सीने पर अपना पैर रखकर खड़ा था।"
                    "जब भगवान भी अपनी हद भूल जाते हैं, तो महाकाल उन्हें इसी तरह सज़ा देते हैं!"
                """.trimIndent(),
                english = """
                    (The Tearing of Narasimha's Chest and the End of the War): "When Narasimha violently assaulted Sharabha, Shiva brutally showed the lion his exact pathetic status!"
                    "In a single, lightning-fast strike, Sharabha seized that terrifying 'Narasimha' and ruthlessly slashed him with his 'Razor-sharp claws' (Nakhaistikshnair)!"
                    "'Vyadarayat'—Sharabha mercilessly and violently 'Tore and Ripped open' the impenetrable biological shell of Narasimha with his bare talons!"
                    "The exact Narasimha who had ripped open Hiranyakashipu's stomach was today torn to shreds by the claws of Shiva."
                    "From this horrific, catastrophic strike, Narasimha's entire radioactive arrogance and wrath shattered to dust in one microsecond."
                    "'Papatadho visamjnascha'—And that invincible Avatar of Lord Vishnu violently crashed to the 'Ground' (Adho), completely paralyzed and 'Unconscious' (Visamjna)!"
                    "That 'Supreme Lord' (Narasimha) who was about to incinerate the cosmos was rendered functionally dead (like a corpse) by a single strike from Shiva."
                    "This was absolutely no ordinary defeat; it was the ultimate Clash of Supreme Powers where Shiva violently proved his absolute Dictatorship."
                    "Narasimha lay paralyzed in the dirt, and Sharabha stood towering with his foot planted firmly on his chest."
                    "When even Gods forget their limits, this is exactly how Mahakala executes his brutal, ruthless punishment!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 9,
                sanskrit = "ततस्तं नृसिंहं वेगेन आकाशे समुदक्षिपत् । तस्य पादप्रहारेण मूर्च्छितोऽभूज्जनार्दनः ॥",
                hindi = """
                    (आकाश में फेंकना और जनार्दन की मूर्च्छा): "शरभ (शिव) का प्रहार यहीं नहीं रुका; उन्होंने नरसिंह को सबसे भयानक ज़िल्लत (Humiliation) दी।"
                    "उन्होंने अपने पंजों से उस विशाल नरसिंह को पकड़ा और पूरी ताक़त से 'तेज़ी से' (वेगेन) असीम 'आकाश में उछाल कर फेंक दिया' (आकाशे समुदक्षिपत्)!"
                    "जैसे कोई बाज किसी छोटे से चूहे को आसमान में ले जाकर फेंक देता है, वैसे ही शिव ने विष्णु के अवतार को अंतरिक्ष में फेंक दिया।"
                    "और जब नरसिंह नीचे गिरे, तो शरभ ने अपने 'पैर से ऐसा खौफनाक प्रहार' (पादप्रहारेण) किया..."
                    "कि साक्षात भगवान 'जनार्दन' (विष्णु/नरसिंह) का दिमाग पूरी तरह से हैंग (Hang) हो गया और वे गहरी 'मूर्च्छा' (Coma/मूर्च्छितोऽभूज्) में चले गए!"
                    "इस प्रहार ने विष्णु के अवतार के सारे सिस्टम (System) को क्रैश (Crash) कर दिया।"
                    "पूरे ब्रह्मांड ने देखा कि जिसे वे अजेय मान रहे थे, वह शिव के पैरों के नीचे एक बेहोश लाश की तरह पड़ा था।"
                    "यह शिव की वह अल्टीमेट सुप्रीमसी (Ultimate Supremacy) है जिसे कोई भी पुराण झुठला नहीं सकता।"
                    "अहंकार चाहे इंसान का हो या भगवान का, शिव के त्रिशूल और पंजों से कोई नहीं बच सकता।"
                    "नरसिंह का क्रोध अब शांत नहीं हुआ था, बल्कि पीट-पीट कर ठंडा कर दिया गया था!"
                """.trimIndent(),
                english = """
                    (Hurled into the Sky and the Coma of Janardana): "The brutal assault of Sharabha (Shiva) absolutely did not stop there; he inflicted the most horrific Humiliation upon Narasimha."
                    "He gripped that colossal Narasimha in his talons and, with cataclysmic 'Velocity' (Vegena), 'Violently hurled him deep into the infinite Sky' (Akashe samudakshipat)!"
                    "Exactly like an apex eagle tossing a pathetic mouse into the stratosphere, Shiva violently flung the Avatar of Vishnu into the vacuum of space."
                    "And as Narasimha plummeted down, Sharabha delivered such a horrific 'Strike with his Foot' (Padapraharena)..."
                    "That the brain of the explicit Lord 'Janardana' (Vishnu/Narasimha) completely short-circuited, sending him crashing into a deep, paralyzing 'Coma' (Murchchhitobhuj)!"
                    "This apocalyptic physical strike catastrophically Crashed every single biological and divine system of Vishnu's Avatar."
                    "The entire infinite cosmos witnessed that the entity they hallucinated as invincible was lying like an unconscious corpse beneath Shiva's boots."
                    "This is the absolute Ultimate Supremacy of Shiva that absolutely no scripture or Puran can ever deny."
                    "Whether the arrogant ego belongs to a pathetic mortal or to God Himself, absolutely no one escapes the trident and talons of Shiva."
                    "Narasimha's wrath was not pacified; it was violently and physically beaten out of him until he went completely cold!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 10,
                sanskrit = "स तदा शरभो रुद्रो नृसिंहं प्राह भीषणम् । मुञ्च प्राणान् नृकेसरिन् त्वं हि लोकभयङ्करः ॥",
                hindi = """
                    (शिव की मौत की चेतावनी और नरसिंह का सरेंडर): "जब नरसिंह खून से लथपथ होकर ज़मीन पर गिरे, तब साक्षात महाकाल रुद्र (शरभ) ने दहाड़ कर कहा।"
                    "उन्होंने उस भयानक (भीषणम्) नरसिंह से मौत का सीधा और क्रूर आदेश देते हुए कहा—"
                    "'हे नृकेसरिन् (शेर और इंसान)! अब अपने प्राणों को त्याग दे (मुञ्च प्राणान्)! मरने के लिए तैयार हो जा!'"
                    "'तू इस पूरे ब्रह्मांड के लिए एक खौफनाक खतरा (लोकभयङ्करः) बन चुका है; तेरी यह हस्ती अब बर्दाश्त नहीं की जाएगी!'"
                    "शिव ने विष्णु के अवतार को सीधा 'मौत की सज़ा' सुना दी थी; वह शरभ नरसिंह का सिर काटने ही वाला था।"
                    "यह दृश्य देखकर नरसिंह के भीतर का सारा 'महाक्रोध' और 'घमंड' बर्फ की तरह पिघल गया।"
                    "उन्हें समझ आ गया कि उनके सामने कोई दानव नहीं, बल्कि साक्षात सृष्टि का 'पिता' (Supreme God) खड़ा है।"
                    "नरसिंह का अहंकार (Ego) जो स्वर्ग तक पहुँच गया था, वह शिव के पैरों की धूल में मिल गया।"
                    "जब भगवान विष्णु का अवतार मौत के डर से काँप सकता है, तो इंसान की औकात ही क्या है?"
                    "यह सनातन धर्म का वह मोमेंट (Moment) है जहाँ शिव ने यह साबित कर दिया कि वे 'देवों के देव महादेव' क्यों कहलाते हैं!"
                """.trimIndent(),
                english = """
                    (Shiva's Death Warning and the Surrender of Narasimha): "As Narasimha lay violently bleeding and paralyzed in the dirt, the explicit Mahakala Rudra (Sharabha) roared like a cosmic explosion."
                    "He issued a direct, cold-blooded execution order to that terrifying (Bhishanam) Narasimha, screaming—"
                    "'O Nrikesarin (Man-Lion)! Violently surrender and abandon your life-force immediately (Muncha Pranan)! Prepare to die a brutal death!'"
                    "'You have mutated into a horrific, apocalyptic threat to this entire infinite cosmos (Lokabhayankarah); your existence will absolutely no longer be tolerated!'"
                    "Shiva explicitly pronounced a direct 'Death Sentence' upon the Avatar of Vishnu; that Sharabha was literally milliseconds away from decapitating Narasimha."
                    "Witnessing this catastrophic reality, all the 'Maha-krodha' (Apocalyptic Wrath) and 'Arrogance' inside Narasimha melted like ice into pure terror."
                    "He flawlessly realized that standing before him was absolutely no demon, but explicitly the 'Father' of creation (The Supreme God) Himself."
                    "Narasimha's Ego, which had skyrocketed to the heavens, was violently crushed into the literal dust beneath Shiva's boots."
                    "When the supreme Avatar of Lord Vishnu can tremble in the sheer terror of Death, what pathetic status does a mortal human possess?"
                    "This is the precise, atomic Moment in Sanatana Dharma where Shiva violently proved exactly why He is titled 'Mahadeva, The God of Gods'!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 11,
                sanskrit = "ततः स चेतनां लब्ध्वा नृसिंहो विष्णुमव्ययम् । तुष्टाव देवदेवेशं शरभं परमेश्वरम् ॥",
                hindi = """
                    (होश में आना और परमेश्वर की स्तुति): "शिव के उस खौफनाक प्रहार के बाद, जब भगवान विष्णु (नरसिंह) को थोड़ा 'होश' (चेतनां) आया (लब्ध्वा)..."
                    "तो उन्होंने लड़ना छोड़ दिया। उस 'अव्यय विष्णु' ने तुरंत समझ लिया कि उनके सामने कौन सा ब्रह्मांडीय तानाशाह खड़ा है।"
                    "उन्होंने अपने खूँखार पंजों को समेट लिया और हाथ जोड़कर उस 'देवों के देव' (देवदेवेशं) की पूजा (तुष्टाव) करनी शुरू कर दी!"
                    "नरसिंह ने साक्षात उस 'शरभ' (शिव) को अपना 'परमेश्वर' (Supreme God) मानकर उसके सामने सर झुका दिया।"
                    "जो विष्णु कुछ देर पहले दुनिया को भस्म करने वाले थे, वे अब एक अपराधी की तरह शिव के पैरों में पड़े थे।"
                    "यह हार नहीं थी; यह ज्ञान का वह विस्फोट था जहाँ विष्णु का अहंकार जलकर राख हो गया।"
                    "शिव का यह शरभ अवतार कोई दानव नहीं था, वह साक्षात वह गुरु था जिसने विष्णु के भटके हुए अवतार को सही रास्ता दिखाया।"
                    "जब भगवान भी अपनी हदें पार करते हैं, तो महाकाल की लाठी उन्हें वापस ज़मीन पर ला पटकती है।"
                    "नरसिंह की यह स्तुति (प्रार्थना) साबित करती है कि शिव से ऊपर कोई ताक़त न कभी थी और न कभी होगी।"
                    "यहीं से नरसिंह के मुँह से वह ब्रह्मांडीय सच निकलता है जो आज तक पुराणों में गूँज रहा है!"
                """.trimIndent(),
                english = """
                    (Regaining Consciousness and Worshipping the Supreme God): "Following that apocalyptic strike from Shiva, when Lord Vishnu (Narasimha) managed to claw back a fraction of his 'Consciousness' (Chetanam labdhva)..."
                    "He violently aborted the war. That 'Avyaya Vishnu' (Indestructible Vishnu) instantaneously realized exactly which cosmic Dictator stood towering over him."
                    "He retracted his bloodthirsty talons, folded his hands, and immediately began to worship and praise (Tushtava) that 'God of Gods' (Devadevesham)!"
                    "Narasimha explicitly accepted that 'Sharabha' (Shiva) as his absolute 'Parameshwara' (Supreme God) and bowed his head in total submission."
                    "The Vishnu who, microseconds ago, was preparing to incinerate the world to ashes, now lay exactly like a guilty criminal at the feet of Shiva."
                    "This was absolutely no mere defeat; it was the atomic detonation of absolute Knowledge where Vishnu's ego was burnt to dust."
                    "This Sharabha Avatar of Shiva was absolutely no demon; He was the explicit Guru who violently corrected the rogue path of Vishnu's Avatar."
                    "When even Gods violently cross their limits, the sledgehammer of Mahakala brutally slams them back into the dirt."
                    "This prayer of Narasimha permanently proves that absolutely no power has ever existed, nor will ever exist, above Shiva."
                    "Right here, from the mouth of Narasimha, erupts the cosmic absolute truth that echoes through the Puranas to this day!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 12,
                sanskrit = "नृसिंह उवाच । नमस्ते देवदेवेश नमस्ते परमेश्वर । अद्य मे सफलं जन्म अद्य मे सफलं तपः ॥",
                hindi = """
                    (नरसिंह का समर्पण और जन्म का सफल होना): "नरसिंह ने ज़मीन पर पड़े-पड़े भगवान शिव को देखते हुए कहा (नृसिंह उवाच)।"
                    "'नमस्ते देवदेवेश!'— हे देवताओं के भी सबसे बड़े देवता, आपको मेरा बार-बार नमस्कार है!"
                    "'नमस्ते परमेश्वर!'— हे ब्रह्मांड के इकलौते परमेश्वर (Supreme Boss), मैं आपके सामने पूरी तरह सरेंडर (Surrender) करता हूँ।"
                    "नरसिंह ने कहा: 'अद्य मे सफलं जन्म'— आज, शिव के इस खौफनाक और प्रलयंकारी प्रहार को खाने के बाद ही, मेरा यह नरसिंह अवतार लेना 'सफल' हुआ है!"
                    "'अद्य मे सफलं तपः'— आज आपको अपनी आँखों से देखकर मेरी सारी तपस्या सफल हो गई है!"
                    "यह बात एक भगवान दूसरे भगवान से कह रहा है; इससे बड़ा सत्य और क्या होगा?"
                    "विष्णु का अवतार मानता है कि शिव के हाथों मार खाना या पीटा जाना भी ब्रह्मांड का सबसे बड़ा सौभाग्य (Blessing) है।"
                    "अहंकार में अंधे होने से बेहतर है कि शिव का त्रिशूल इंसान का सीना फाड़ दे; कम से कम आँखें तो खुल जाती हैं।"
                    "नरसिंह का यह समर्पण (Submission) दुनिया के हर उस इंसान के लिए तमाचा है जो अपनी ताक़त और पैसे पर घमंड करता है।"
                    "जब भगवान विष्णु का अवतार शिव के पैरों में गिर सकता है, तो तुम्हारी क्या औकात है?"
                """.trimIndent(),
                english = """
                    (Narasimha's Surrender and the Fulfillment of His Birth): "Lying paralyzed in the dirt, Narasimha stared up at Lord Shiva and declared (Nrisimha uvacha)."
                    "'Namaste Devadevesha!'—O absolute Supreme God of all gods, I violently and repeatedly bow to You!"
                    "'Namaste Parameshwara!'—O sole, undisputed Supreme Dictator of the cosmos, I execute my 100% total and unconditional Surrender before You."
                    "Narasimha roared: 'Adya me saphalam janma'—Today, strictly after absorbing this terrifying, apocalyptic strike from Shiva, my incarnation as Narasimha has finally become 'Fulfilled'!"
                    "'Adya me saphalam tapah'—Today, by witnessing You directly with my own eyes, my entire cosmic penance has achieved absolute perfection!"
                    "This is one explicit God declaring this to another explicit God; what greater absolute truth could possibly exist in the universe?"
                    "The Avatar of Vishnu explicitly confesses that being brutally beaten and nearly slaughtered by Shiva is the cosmos's absolute greatest Blessing."
                    "It is infinitely better to have your chest ripped open by Shiva's trident than to rot blind in arrogance; at least your eyes are violently opened."
                    "This Total Submission by Narasimha is a brutal, radioactive slap to every single mortal who hallucinates arrogance over pathetic wealth and power."
                    "When the supreme Avatar of Lord Vishnu can drop to his knees at the feet of Shiva, what pathetic, microscopic status do you possess?"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 13,
                sanskrit = "यत्त्वां पश्यामि देवेश शरभं परमेश्वरम् । त्वमेव स्रष्टा सर्वेषां त्वमेव परिपालकः ॥",
                hindi = """
                    (शिव ही रचयिता और पालनकर्ता हैं): "नरसिंह ने स्तुति करते हुए कहा: 'हे देवेश! जो मैं आज आपको इस खौफनाक शरभ रूप में साक्षात देख रहा हूँ (पश्यामि)...'"
                    "'इससे मेरे दिमाग का हर भ्रम हमेशा के लिए टूट गया है कि मैं इस दुनिया का रक्षक हूँ।'"
                    "'त्वमेव स्रष्टा सर्वेषां'— हे शिव! केवल और केवल आप ही इस पूरे असीम ब्रह्मांड और सभी जीवों के असली 'स्रष्टा' (Creator/ब्रह्मा) हैं!"
                    "'त्वमेव परिपालकः'— और केवल आप ही इस पूरी सृष्टि के एकमात्र 'परिपालक' (Sustainer/विष्णु) भी हैं!"
                    "नरसिंह (विष्णु) ने खुद मान लिया कि जो काम वे करते हैं, वह उनकी अपनी ताक़त से नहीं, बल्कि साक्षात शिव की दी हुई ऊर्जा से होता है।"
                    "विष्णु केवल एक ऑपरेटर (Operator) हैं, लेकिन सिस्टम का असली 'एडमिन' (Admin) शिव ही है।"
                    "यह श्लोक सनातन धर्म के उस सबसे बड़े रहस्य को खोलता है कि ब्रह्मा और विष्णु दोनों ही शिव के हाथों की कठपुतलियाँ हैं।"
                    "जब शिव चाहते हैं, दुनिया बनती है; जब शिव चाहते हैं, दुनिया चलती है।"
                    "जो इंसान भगवान विष्णु की पूजा करते हैं, उन्हें यह सत्य जानना होगा कि विष्णु खुद किसकी पूजा करते हैं!"
                    "यह शिव की उस अद्वैत (Non-dual) तानाशाही की गर्जना है जिसे कोई वेद झुठला नहीं सकता।"
                """.trimIndent(),
                english = """
                    (Shiva Alone is the Creator and Sustainer): "Continuing his praise, Narasimha roared: 'O Devesha! Today, as I explicitly and physically witness You (Pashyami) in this terrifying Sharabha form...'"
                    "'Every single hallucination in my brain that I am the supreme protector of this universe has been permanently and violently shattered to dust.'"
                    "'Tvameva srashta sarvesham'—O Shiva! Strictly and exclusively YOU alone are the authentic 'Srashta' (Creator/Brahma) of this entire infinite cosmos and all entities!"
                    "'Tvameva paripalakah'—And strictly and exclusively YOU alone are the solitary 'Paripalaka' (Sustainer/Vishnu) of this entire creation!"
                    "Narasimha (Vishnu) Himself explicitly confessed that the operations He executes are absolutely not powered by His own strength, but strictly by the radioactive energy granted by Shiva."
                    "Vishnu is merely a biological Operator, but the absolute 'Admin' of the entire Matrix is explicitly Shiva."
                    "This Shloka violently rips open the greatest classified secret of Sanatana Dharma: Both Brahma and Vishnu are literal puppets operating strictly on Shiva's strings."
                    "When Shiva commands, the world detonates into existence; when Shiva dictates, the universe functions."
                    "The mortals who worship Lord Vishnu must flawlessly decode this absolute truth: Who exactly does Vishnu Himself worship?"
                    "This is the apocalyptic roar of Shiva's Non-dual Dictatorship that absolutely no Veda can ever deny!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 14,
                sanskrit = "त्वमेव संहर्ता देव त्वमेव परमेश्वरः । मत्तोऽधिकतरो नास्ति इत्यहं गर्वितः पुरा ॥",
                hindi = """
                    (अहंकार का टूटना और सबसे बड़ी भूल का स्वीकार): "नरसिंह ने शिव की प्रलयंकारी ताक़त को मानते हुए कहा: 'त्वमेव संहर्ता देव!'"
                    "'हे प्रभु! केवल आप ही इस पूरे ब्रह्मांड को भस्म करने वाले असली 'संहर्ता' (Destroyer/महाकाल) हैं!'"
                    "'त्वमेव परमेश्वरः'— इस असीम अंतरिक्ष में कोई और नहीं, केवल और केवल आप ही 'परमेश्वर' (The Ultimate Supreme God) हैं!"
                    "और फिर भगवान विष्णु के अवतार ने ब्रह्मांड की सबसे बड़ी भूल और अपना सबसे बड़ा घमंड (Ego) कुबूल किया।"
                    "'मत्तोऽधिकतरो नास्ति'— हे शिव! हिरण्यकशिपु को मारने के बाद मेरे दिमाग में यह सड़ा हुआ कीड़ा घुस गया था कि 'मुझसे ज़्यादा शक्तिशाली इस दुनिया में कोई है ही नहीं!'"
                    "'इत्यहं गर्वितः पुरा'— इसी खौफनाक और अंधे 'घमंड' (गर्वितः) में पागल होकर मैं पूरी सृष्टि को तबाह करने जा रहा था!"
                    "सोचो! जब भगवान विष्णु के अवतार के दिमाग में भी 'मैं सबसे बड़ा हूँ' का अहंकार (Ego) आ सकता है, तो आम इंसान की क्या औकात है?"
                    "अहंकार (Ego) वो ज़हर है जो भगवान को भी दानव बना देता है; और उस ज़हर का एंटीडोट (Antidote) केवल शिव का त्रिशूल है।"
                    "नरसिंह ने यह स्वीकार किया कि शिव के इस प्रहार के बिना वह कभी इस अज्ञान की बीमारी से ठीक नहीं हो पाते।"
                    "अपनी हार मानना ही सबसे बड़ी जीत है; विष्णु ने हार मानकर शिव को हमेशा के लिए जीत लिया!"
                """.trimIndent(),
                english = """
                    (The Shattering of Ego and the Confession of the Ultimate Mistake): "Acknowledging the apocalyptic power of Shiva, Narasimha roared: 'Tvameva samharta Deva!'"
                    "'O Lord! Strictly and exclusively YOU alone are the authentic 'Samharta' (Destroyer/Mahakala) who incinerates this entire cosmos to ashes!'"
                    "'Tvameva Parameshvarah'—In this entire infinite vacuum of space, absolutely no one else, exclusively YOU alone are the 'Parameshwara' (The Ultimate Supreme God)!"
                    "And then, the Avatar of Lord Vishnu executed the most brutal confession of the greatest cosmic mistake and his own massive Ego."
                    "'Matto'dhikataro nasti'—O Shiva! After slaughtering Hiranyakashipu, a rotting biological worm infected my brain, hallucinating that 'Absolutely no force in existence is more powerful than ME!'"
                    "'Ityaham garvitah pura'—Blinded and driven completely insane by this horrific, toxic 'Arrogance' (Garvitah), I was about to annihilate the entire creation!"
                    "Think! If the supreme Avatar of Lord Vishnu can be infected by the pathetic Ego virus of 'I am the greatest', what pathetic status does a mortal human possess?"
                    "Ego is the lethal venom that mutates even God into a demon; and the absolute only Antidote to that venom is the violent strike of Shiva's trident."
                    "Narasimha explicitly confessed that without this brutal assault from Shiva, he could never have been cured of this disease of ignorance."
                    "To forcefully accept defeat is the absolute greatest victory; by submitting his defeat, Vishnu permanently conquered Shiva's heart!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 15,
                sanskrit = "अद्य मे गर्वनाशस्तु कृतो वै भवता विभो । क्षमस्व मेऽपराधं तं प्रभो परमकारुणिक ॥",
                hindi = """
                    (घमंड का कत्ल और माफ़ी की भीख): "नरसिंह ने शिव के चरणों में गिरकर कहा: 'अद्य मे गर्वनाशस्तु कृतो वै भवता विभो!'"
                    "'हे असीम परमेश्वर (विभो)! आज आपने मुझे पीट-पीट कर मेरे उस भयानक 'घमंड का पूरी तरह से सर्वनाश' (गर्वनाश) कर दिया है!'"
                    "मेरा वह अहंकार जो अंतरिक्ष को फाड़ रहा था, आपके एक पंजे के प्रहार से हमेशा के लिए मिट्टी में मिल गया है।"
                    "'क्षमस्व मेऽपराधं तं'— हे प्रभु! मैं अपने होश में नहीं था; मुझे मेरे उस खौफनाक और प्रलयंकारी 'अपराध' (पाप) के लिए माफ़ कर दीजिए!"
                    "मैंने इस दुनिया को तबाह करने की जो जुर्रत की और आपसे जो टकराने की भूल की, उसकी क्षमा केवल आप ही दे सकते हैं।"
                    "'प्रभो परमकारुणिक'— क्योंकि आप केवल विनाशकारी नहीं हैं, आप पूरे ब्रह्मांड के 'परम दयालु' (Supreme Compassionate) भगवान भी हैं।"
                    "शिव का मारना भी एक वरदान है; वे तभी मारते हैं जब वे अहंकार को खत्म करके आत्मा को बचाना चाहते हैं।"
                    "नरसिंह के इन शब्दों से ब्रह्मांड का तापमान वापस नॉर्मल (Normal) हो गया और प्रलय रुक गई।"
                    "जब तुम भगवान के सामने रोकर अपनी गलती मान लेते हो, तो तुम्हारे करोड़ों जन्मों के पाप तुरंत डिलीट (Delete) हो जाते हैं।"
                    "विष्णु का अवतार शिव के सामने एक छोटे बच्चे की तरह रो रहा था; यही शिव की असीम ताक़त का सबसे बड़ा सबूत है!"
                """.trimIndent(),
                english = """
                    (The Slaughter of Arrogance and the Begging for Forgiveness): "Crashing to the feet of Shiva, Narasimha roared: 'Adya me garvanashastu krito vai bhavata Vibho!'"
                    "'O Infinite Supreme Lord (Vibho)! Today, by brutally beating me, you have executed the absolute and permanent 'Annihilation of my Arrogance' (Garvanasha)!'"
                    "My rotting ego, which was literally tearing the fabric of space, has been violently ground into the dirt by a single strike of your talons."
                    "'Kshamasva me'paradham tam'—O Lord! I was absolutely not in my right mind; grant me absolute forgiveness for that horrific, apocalyptic 'Crime' (Sin)!"
                    "The audacity I possessed to attempt the incineration of the world, and the lethal mistake of colliding with YOU—only You can pardon this."
                    "'Prabho paramakarunika'—Because You are absolutely not just the Destroyer, You are the explicitly 'Supreme Compassionate' Lord of the entire cosmos."
                    "Even Shiva's brutal physical assault is a cosmic blessing; He strikes exclusively to assassinate the ego and salvage the Soul."
                    "Triggered by Narasimha's words, the boiling temperature of the cosmos immediately Flatlined back to normal, completely aborting Doomsday."
                    "When you violently shatter your ego and confess your crimes crying before God, billions of lifetimes of sins are instantaneously Deleted."
                    "The supreme Avatar of Lord Vishnu was weeping exactly like a pathetic infant before Shiva; this is the absolute, irrefutable proof of Shiva's infinite supremacy!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 16,
                sanskrit = "इति स्तुत्वा नृसिंहस्तु शरभं परमेश्वरम् । तस्य पादौ समालिङ्ग्य रुरोद च मुहुर्मुहुः ॥",
                hindi = """
                    (नरसिंह का रोना और शिव के पैरों से लिपट जाना): "यह दृश्य सनातन धर्म के इतिहास का सबसे भावुक और रोंगटे खड़े कर देने वाला दृश्य है।"
                    "'इति स्तुत्वा नृसिंहस्तु'— भगवान विष्णु के अवतार नरसिंह ने इस तरह उस 'परमेश्वर शरभ' (शिव) की खौफनाक और सच्ची स्तुति की।"
                    "और फिर उन्होंने क्या किया? 'तस्य पादौ समालिङ्ग्य'— उस विशालकाय और प्रलयंकारी शरभ के 'पैरों' को अपने हाथों से कसकर 'गले लगा लिया' (समालिङ्ग्य)!"
                    "जिस भगवान विष्णु की पूजा पूरा ब्रह्मांड करता है, वह विष्णु शिव के चरणों में कसकर लिपट गए।"
                    "'रुरोद च मुहुर्मुहुः'— और वे वहाँ ज़मीन पर पड़े हुए 'बार-बार, फूट-फूट कर' (मुहुर्मुहुः) एक छोटे बच्चे की तरह 'रोने लगे' (रुरोद)!"
                    "उनकी आँखों से आँसुओं की नदियां बहने लगीं; यह हार के आँसू नहीं थे, यह उस परम सत्य को पहचानने और अपने अहंकार के मरने के आँसू थे।"
                    "जब अहंकार का बाँध टूटता है, तो इंसान हो या भगवान, वह रोए बिना नहीं रह सकता।"
                    "यह शिव का वह खौफनाक और असीम प्यार था जिसने नरसिंह के क्रोध की आग को आँसुओं के समंदर में बदल दिया।"
                    "जो शिव मौत बनकर आए थे, वे अब एक पिता की तरह उस रोते हुए शेर को देख रहे थे।"
                    "इस एक श्लोक ने यह साबित कर दिया कि शिव के चरणों में ब्रह्मांड का हर एक सिर झुकने के लिए ही बना है!"
                """.trimIndent(),
                english = """
                    (Narasimha's Weeping and Clinging to Shiva's Feet): "This scene is the most emotionally catastrophic and spine-chilling visual in the entire history of Sanatana Dharma."
                    "'Iti stutva Nrisimhastu'—The Avatar of Lord Vishnu, Narasimha, explicitly executed this terrifying and authentic praise of that 'Supreme God Sharabha' (Shiva)."
                    "And what did he do next? 'Tasya padau samalingya'—He violently threw his arms around the 'Feet' of that colossal, apocalyptic Sharabha and 'Embraced' them tightly (Samalingya)!"
                    "The exact Lord Vishnu, who is worshipped by the entire infinite cosmos, clung desperately to the literal feet of Shiva."
                    "'Ruroda cha muhurmuhuh'—And lying there in the dirt, he began to 'Weep violently and hysterically, over and over again' (Muhurmuhuh ruroda) exactly like a pathetic infant!"
                    "Rivers of tears erupted from his eyes; these were absolutely not tears of defeat, they were the tears of recognizing the Absolute Truth and the brutal death of his ego."
                    "When the titanium dam of the ego shatters, be it a human or God Himself, he absolutely cannot stop weeping uncontrollably."
                    "It was the terrifying and infinite love of Shiva that mutated the raging fire of Narasimha's wrath into a literal ocean of tears."
                    "The exact Shiva who descended as Death itself was now looking down at the weeping lion exactly like a cosmic Father."
                    "This single Shloka permanently proves that every single head in the infinite cosmos is engineered explicitly to bow at the feet of Shiva!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 17,
                sanskrit = "तमुवाच तदा रुद्रो नृसिंहं सान्त्वयन् वचः । उत्तिष्ठोत्तिष्ठ भद्रं ते नृसिंह परमेश्वर ॥",
                hindi = """
                    (महाकाल की करुणा और नरसिंह को उठाना): "जब शिव ने अपने परम भक्त (विष्णु) को अपने पैरों में फूट-फूट कर रोते हुए देखा, तो उनका सारा प्रलयंकारी क्रोध एक सेकंड में शांत हो गया।"
                    "'तमुवाच तदा रुद्रो'— तब साक्षात महाकाल रुद्र ने उस रोते हुए नरसिंह से 'सांत्वना' (सान्त्वयन् / प्यार और दया) भरे शब्द कहे।"
                    "जो शिव अभी तक ब्रह्मांड को फाड़ने वाले हथियार चला रहे थे, उनकी आवाज़ अब एक माँ से भी ज़्यादा कोमल हो गई।"
                    "शिव ने कहा: 'उत्तिष्ठोत्तिष्ठ भद्रं ते'— 'उठो! उठो मेरे प्यारे! तुम्हारा परम कल्याण (भद्रं) हो! अब रोना बंद करो।'"
                    "और शिव ने विष्णु को क्या कहकर पुकारा? 'नृसिंह परमेश्वर'— हे परमेश्वर नरसिंह!"
                    "शिव ने विष्णु को नीचा नहीं दिखाया; उनका अहंकार तोड़ने के बाद शिव ने वापस उन्हें 'परमेश्वर' का रुतबा (Respect) दे दिया।"
                    "यही शिव की सबसे बड़ी महानता है; वे अहंकार का वध करते हैं, लेकिन आत्मा का सम्मान करते हैं।"
                    "वे दंड देने में दुनिया के सबसे खूँखार तानाशाह हैं, और प्यार करने में ब्रह्मांड के सबसे बड़े दयालु पिता।"
                    "शिव ने अपने पंजों से विष्णु को उठाया और उन्हें अपने सीने से लगा लिया।"
                    "यह शिव और विष्णु का वह ब्रह्मांडीय मिलन था जिसने पूरी सृष्टि को महा-प्रलय से बचा लिया!"
                """.trimIndent(),
                english = """
                    (The Compassion of Mahakala and Raising Narasimha): "When Shiva witnessed His supreme devotee (Vishnu) weeping violently and hysterically at His feet, His entire apocalyptic wrath completely Flatlined in a single microsecond."
                    "'Tamuvacha tada Rudro'—Then the explicit Mahakala Rudra spoke words saturated with 'Consolation' and infinite cosmic mercy (Santvayan) to that crying Narasimha."
                    "The exact Shiva who was wielding universe-shredding weapons microseconds ago now projected an acoustic frequency softer than a mother's."
                    "Shiva commanded: 'Uttishthottishtha bhadram te'—'Rise! Rise my beloved! May absolute ultimate welfare (Bhadram) be yours! Violently cease your weeping immediately.'"
                    "And exactly how did Shiva address Vishnu? 'Nrisimha Parameshwara'—O Supreme God Narasimha!"
                    "Shiva absolutely did not degrade or humiliate Vishnu; after brutally slaughtering his ego, Shiva instantly reinstated his absolute 'Status of Supreme God'."
                    "This is the absolute greatest majesty of Shiva; He executes the ruthless assassination of the Ego, but infinitely respects the Soul."
                    "In delivering punishment, He is the universe's most bloodthirsty Dictator; in projecting love, He is the cosmos's most infinitely compassionate Father."
                    "Shiva lifted Vishnu with his colossal talons and violently embraced him against his own chest."
                    "This was the apocalyptic, cosmic fusion of Shiva and Vishnu that instantaneously aborted Doomsday and salvaged the entire creation!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 18,
                sanskrit = "ममैव त्वं प्रियतमो नात्र कार्या विचारणा । मया यत्कृतमेतत्ते लोकोपकृतये कृतम् ॥",
                hindi = """
                    (शिव का खौफनाक प्यार और युद्ध का असली कारण): "शिव ने नरसिंह की आँखों में आँखें डालकर ब्रह्मांड का सबसे बड़ा सत्य बोल दिया।"
                    "'ममैव त्वं प्रियतमो'— हे विष्णु! इस पूरे असीम ब्रह्मांड में तुम ही मेरे सबसे ज़्यादा 'प्रिय' (सबसे चहेते) हो!"
                    "'नात्र कार्या विचारणा'— इस बात में एक सेकंड के करोड़वें हिस्से का भी कोई शक (विचार/Doubt) मत करना!"
                    "तो फिर शिव ने विष्णु को इतनी बेरहमी से क्यों पीटा? शिव ने इसका जवाब खुद दिया।"
                    "'मया यत्कृतमेतत्ते'— मैंने तुम्हारे साथ जो यह खौफनाक और हिंसक युद्ध (कत्लेआम) किया है..."
                    "'लोकोपकृतये कृतम्'— वह मैंने तुम्हें नीचा दिखाने के लिए नहीं, बल्कि केवल और केवल 'पूरी दुनिया को प्रलय से बचाने' (लोकोपकृतये) के लिए किया है!"
                    "तुम्हारा क्रोध (Anger) आउट ऑफ कंट्रोल (Out of control) हो गया था, और अगर मैं तुम्हें नहीं पीटता, तो यह पूरी सृष्टि भस्म हो जाती।"
                    "एक पिता अपने बच्चे को तभी मारता है जब वह बच्चा आग में कूदने वाला हो; शिव ने भी ठीक वही किया।"
                    "यह शिव का वह खौफनाक प्यार है जहाँ वे दुनिया को बचाने के लिए अपने सबसे प्यारे इंसान (विष्णु) का भी खून बहाने से पीछे नहीं हटते।"
                    "इससे यह सिद्ध हो गया कि शिव का क्रोध (Anger) कभी विनाश के लिए नहीं होता, वह हमेशा केवल रक्षा के लिए होता है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Love of Shiva and the True Reason for War): "Staring directly into the eyes of Narasimha, Shiva detonated the absolute greatest truth in the cosmos."
                    "'Mamaiva tvam priyatamo'—O Vishnu! In this entire infinite, boundless universe, YOU alone are explicitly my most 'Beloved' (Priyatama)!"
                    "'Natra karya vicharana'—Absolutely do not harbor even a billionth of a microsecond's 'Doubt' (Vicharana) regarding this ironclad fact!"
                    "Then why exactly did Shiva beat and slash Vishnu so ruthlessly? Shiva explicitly delivered the answer Himself."
                    "'Maya yatkritametatte'—This horrific, violent, and bloody warfare (slaughter) that I executed upon your physical body..."
                    "'Lokopakritaye kritam'—Was absolutely not engineered to humiliate you, but was executed strictly and exclusively 'To salvage the entire cosmos from Doomsday' (Lokopakritaye)!"
                    "Your wrath had gone completely, catastrophically Out of Control, and if I had not brutally beaten you down, this entire creation would have been incinerated to ash."
                    "A father strikes his child violently only when the child is about to plunge into a raging fire; Shiva executed exactly that identical protocol."
                    "This is the terrifying, radioactive love of Shiva where He does not flinch from drawing the blood of His most beloved entity (Vishnu) strictly to save the Matrix."
                    "This permanently proves that Shiva's apocalyptic Wrath is never engineered for destruction; it is weaponized strictly and exclusively for absolute Protection!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 19,
                sanskrit = "त्वदीयं चर्म मे देहि नृसिंहस्य महाविभो । तवाङ्गे यत्स्थितं चर्म ममासनमस्तु वै ॥",
                hindi = """
                    (नरसिंह की खाल मांगना - अहंकार की अंतिम सज़ा): "युद्ध शांत होने के बाद, शिव ने विष्णु से एक ऐसी खौफनाक चीज़ मांगी जो इंसान की रूह कंपा दे!"
                    "शिव ने कहा: 'हे महाविभो! तुमने जिस शेर (नृसिंह) का रूप धारण किया था, उस शेर की यह 'खाल' (चर्म) मुझे दे दो (मे देहि)!' "
                    "यह कोई आम कपड़ा नहीं था; यह विष्णु के सबसे ताक़तवर अवतार के शरीर की असली चमड़ी थी!"
                    "शिव ने हुक्म दिया: 'तवाङ्गे यत्स्थितं चर्म'— तुम्हारे शरीर पर जो यह खूँखार और अजेय शेर की खाल चिपकी हुई है..."
                    "'ममासनमस्तु वै'— वह अब से हमेशा-हमेशा के लिए मेरा 'आसन' (बैठने की जगह/Throne) बनेगी!"
                    "शिव ने नरसिंह के शरीर से वह खाल उतार कर उसे अपने पहनने और बैठने का कपड़ा बना लिया।"
                    "यह विष्णु के अहंकार की सबसे बड़ी और स्थायी सज़ा थी; कि जिस रूप पर उन्हें इतना घमंड था, वह अब शिव के पैरों और शरीर के नीचे दबा रहेगा।"
                    "आज भी शिव जो बाघम्बर (शेर की खाल) पहनते हैं, वह कोई आम जानवर नहीं, साक्षात भगवान नरसिंह की खाल है!"
                    "यह दृश्य दुनिया के हर इंसान को चेतावनी देता है कि अगर तुमने घमंड किया, तो शिव तुम्हारी खाल उधेड़ कर उसे अपना पायदान (Doormat) बना लेंगे।"
                    "यह सनातन धर्म का सबसे हिंसक, सबसे नंगा और सबसे खौफनाक 'सरेंडर' (Surrender) है!"
                """.trimIndent(),
                english = """
                    (Demanding Narasimha's Skin - The Ultimate Punishment of Ego): "After the apocalyptic war Flatlined, Shiva demanded something from Vishnu so horrific it violently shakes the human soul!"
                    "Shiva commanded: 'O Mahavibho! Violently peel off and 'Hand over to me' (Me dehi) the biological 'Skin' (Charma) of this lion-avatar (Narasimha) you manifested!' "
                    "This was absolutely no ordinary piece of clothing; this was the literal, biological skin ripped from the most powerful Avatar of Vishnu!"
                    "Shiva issued the dictatorial order: 'Tavange yatsthitam charma'—This ferocious, invincible lion-skin fused to your physical flesh..."
                    "'Mamasanamastu vai'—Shall from this exact microsecond become my absolute, permanent 'Asana' (Seat/Throne) for all eternity!"
                    "Shiva literally flayed that biological skin directly from Narasimha's body, weaponizing it as His explicit garment and cosmic seat."
                    "This was the ultimate, permanent punishment for Vishnu's ego; the exact physical form he arrogantly boasted of would now rot permanently crushed beneath Shiva's boots and flesh."
                    "Even today, the Baghambara (Lion Skin) that Shiva wears is absolutely no pathetic animal; it is the explicit, literal skin of Lord Narasimha!"
                    "This scene broadcasts a lethal warning to every mortal: If you hallucinate arrogance, Shiva will violently flay your skin and mutate it into His permanent Doormat."
                    "This is the most violent, naked, cold-blooded, and terrifying 'Surrender' ever recorded in Sanatana Dharma!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 20,
                sanskrit = "तथेति च प्रतिज्ञाय नृसिंहः परमेश्वरः । तद्ददौ शिवाय चर्म स्वकीयमतियत्नतः ॥",
                hindi = """
                    (नरसिंह का अपनी ही खाल उतार कर शिव को देना): "शिव के इस खौफनाक और रोंगटे खड़े कर देने वाले हुक्म को सुनकर नरसिंह ने कोई विरोध नहीं किया।"
                    "'तथेति च प्रतिज्ञाय'— उस परमेश्वर नरसिंह ने अपना सिर झुकाकर कहा: 'जो आज्ञा (तथा अस्तु)! मैं प्रतिज्ञा करता हूँ!'"
                    "और फिर ब्रह्मांड ने वह खूनी और प्रलयंकारी नज़ारा देखा जो कभी किसी ने सपने में भी नहीं सोचा था।"
                    "'तद्ददौ शिवाय चर्म'— नरसिंह ने अपनी ही 'शेर की खाल' (चर्म) अपने शरीर से नोच कर साक्षात भगवान शिव को सौंप दी (ददौ)!"
                    "'स्वकीयमतियत्नतः'— उन्होंने अपने ही शरीर को पूरी ताक़त से छीलकर वह खाल अपने हाथों से शिव के चरणों में रख दी।"
                    "कल्पना करो! एक भगवान अपने ही शरीर की चमड़ी उधेड़ कर दूसरे भगवान को गिफ्ट (Gift) कर रहा है!"
                    "यह साबित करता है कि जब बात शिव के आदेश की हो, तो शरीर का दर्द और अपना वजूद पूरी तरह शून्य (Zero) हो जाता है।"
                    "विष्णु ने खुशी-खुशी अपनी वह भयानक पहचान (Identity) शिव को दे दी, क्योंकि वे जान गए थे कि असली मालिक कौन है।"
                    "जो इंसान अपने अहंकार (Ego) की चमड़ी नहीं उतार सकता, वह कभी भगवान के दरबार में खड़ा नहीं हो सकता।"
                    "इस बलिदान के बाद, विष्णु और शिव के बीच का यह खौफनाक अध्याय हमेशा के लिए एक मिसाल बन गया।"
                """.trimIndent(),
                english = """
                    (Narasimha Flaying His Own Skin and Handing it to Shiva): "Hearing this horrific, blood-curdling command from Shiva, Narasimha offered absolutely zero microscopic resistance."
                    "'Tatheti cha pratijnaya'—That Supreme God Narasimha bowed his head in absolute submission and roared: 'As You Command (Tatha Astu)! I swear this oath!'"
                    "And then the entire infinite cosmos witnessed the most bloody, apocalyptic spectacle absolutely no one had ever hallucinated even in their darkest nightmares."
                    "'Taddadau Shivaya charma'—Narasimha literally, violently flayed his own 'Lion Skin' (Charma) straight off his biological flesh and handed it directly to Lord Shiva (Dadau)!"
                    "'Svakiyamatiyatnatah'—He ripped his own physical shell apart with maximum horrific force, placing that skin at Shiva's feet with his own bare, bleeding hands."
                    "Visualize this! One literal God violently flaying his own biological skin to present it as a physical 'Gift' to another God!"
                    "This permanently proves that when it is a direct command from Shiva, physical biological agony and personal existence drop violently to absolute Zero."
                    "Vishnu happily and willingly surrendered that terrifying physical Identity (Ego) to Shiva, because he flawlessly recognized who the absolute Master was."
                    "The human who absolutely refuses to flay the skin of his own Ego can absolutely never stand in the court of the Supreme God."
                    "Following this horrific sacrifice, this apocalyptic chapter between Vishnu and Shiva became an eternal, titanium cosmic benchmark!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 21,
                sanskrit = "तदाप्रभृति तच्चर्म शिवो धत्ते कृपानिधिः । कृत्तिवासा इति ख्यातिं लेभे स परमेश्वरः ॥",
                hindi = """
                    (कृत्तिवासा: शिव का नया और खौफनाक नाम): "नरसिंह के इस ब्रह्मांडीय बलिदान के बाद शिव ने उस चमड़ी का क्या किया? उपनिषद यह रहस्य खोलता है।"
                    "'तदाप्रभृति'— ठीक उसी पल से लेकर आज तक और अनंत काल तक के लिए..."
                    "'तच्चर्म शिवो धत्ते'— उन करुणानिधि (दया के सागर) शिव ने नरसिंह की उस खूँखार खाल को अपने शरीर पर एक कपड़े की तरह पहन लिया (धत्ते)!"
                    "शिव ने उस खाल को फेंका नहीं; उन्होंने विष्णु के उस रूप को हमेशा के लिए अपने सीने और अपनी जाँघों से लपेट लिया।"
                    "यह शिव का विष्णु के प्रति एक खौफनाक प्यार था, जहाँ उन्होंने अपने भक्त के अहंकार को अपनी ड्रेस (Dress) बना लिया।"
                    "और इसी घटना के बाद से, भगवान शिव का एक नया और प्रलयंकारी नाम पूरे ब्रह्मांड में गूँज उठा— 'कृत्तिवासा'!"
                    "'कृत्तिवासा इति ख्यातिं लेभे'— यानी 'वह भगवान जिसने जानवर (नरसिंह) की खाल (कृत्ति) को अपना वस्त्र (वासा) बना लिया'!"
                    "जब तुम शिव को बाघम्बर पहने हुए देखते हो, तो याद रखना कि वह केवल एक बाघ की खाल नहीं है; वह भगवान विष्णु के सबसे शक्तिशाली अवतार की खाल है।"
                    "यह नाम 'कृत्तिवासा' हर उस असुर और देवता को याद दिलाता है कि शिव के सामने घमंड करने का अंजाम क्या होता है।"
                    "यहीं से शिव ने यह साबित कर दिया कि वे मौत को भी ओढ़ कर पहन सकते हैं!"
                """.trimIndent(),
                english = """
                    (Krittivasa: The New, Terrifying Name of Shiva): "What exactly did Shiva do with that flayed skin after Narasimha's cosmic sacrifice? The Upanishad rips open this secret."
                    "'Tadaprabhriti'—From that exact microsecond onwards, continuously until infinite eternity..."
                    "'Tachcharma Shivo dhatte'—That Ocean of Compassion (Karunanidhi) Shiva literally draped that horrific, bleeding skin of Narasimha around His own physical body as a garment (Dhatte)!"
                    "Shiva absolutely did not discard that skin; He permanently wrapped that specific physical form of Vishnu around His own chest and thighs forever."
                    "This was Shiva's terrifying, radioactive love for Vishnu, where He literally mutated His devotee's slaughtered ego into His permanent cosmic Dress."
                    "And strictly triggered by this apocalyptic event, a brand new, catastrophic name for Lord Shiva violently echoed across the entire cosmos—'Krittivasa'!"
                    "'Krittivasa iti khyatim lebhe'—Meaning, 'That Supreme God who has weaponized the flayed skin (Krittika) of the beast (Narasimha) as His literal clothing (Vasa)'!"
                    "When you witness Shiva wearing the Baghambara (tiger skin), remember flawlessly that it is no pathetic animal; it is the explicit skin of Lord Vishnu's most invincible Avatar."
                    "This name 'Krittivasa' is a lethal, broadcasting warning to every demon and god in existence detailing the exact catastrophic consequence of hallucinating arrogance before Shiva."
                    "Right here, Shiva permanently proved that He can literally drape Death itself over His shoulders as casual clothing!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 22,
                sanskrit = "ततः प्रहृष्टो भगवान् शिवो लोकनमस्कृतः । उवाच विष्णुं तं दृष्ट्वा कृपया परमेश्वरः ॥",
                hindi = """
                    (शिव का खुश होना और विष्णु को आशीर्वाद): "विष्णु का घमंड टूटने और उनकी खाल उतरने के बाद, शिव का 'महाक्रोध' पूरी तरह से शांत हो गया।"
                    "'ततः प्रहृष्टो भगवान् शिवो'— तब पूरे ब्रह्मांड द्वारा नमन किए जाने वाले (लोकनस्कृतः) भगवान शिव विष्णु के इस पूर्ण समर्पण से 'अत्यंत प्रसन्न' (प्रहृष्टो) हुए!"
                    "शिव को क्रोध दिलाना जितना आसान है, उन्हें अपनी भक्ति और सच्चाई से खुश करना भी उतना ही आसान है।"
                    "शिव ने उस खून से सने और ज़मीन पर पड़े विष्णु को देखा, लेकिन अब उनकी आँखों में आग नहीं, बल्कि 'कृपा' (दया का समंदर) थी।"
                    "'उवाच विष्णुं तं दृष्ट्वा कृपया परमेश्वरः'— उस परमेश्वर शिव ने विष्णु की ओर अत्यंत दया (कृपया) से देखते हुए ब्रह्मांडीय शब्द कहे।"
                    "यह दृश्य उस बाप की तरह था जो अपने भटके हुए बेटे को पीटने के बाद उसे रोता देख गले लगा लेता है।"
                    "शिव कभी किसी का परमानेंट (Permanent) दुश्मन नहीं होते; उनकी दुश्मनी केवल 'अहंकार' से है, इंसान से नहीं।"
                    "जैसे ही अहंकार (खाल) उतरी, शिव ने विष्णु को वापस अपना सबसे प्यारा दोस्त और भक्त मान लिया।"
                    "यह सनातन धर्म का वह सुप्रीम मोमेंट (Supreme Moment) है जो बताता है कि भगवान का क्रोध भी असल में उनका आशीर्वाद ही होता है।"
                    "अब शिव अपने सबसे बड़े भक्त को एक ऐसा वरदान देने वाले थे जो सृष्टि का नियम बन गया।"
                """.trimIndent(),
                english = """
                    (Shiva's Joy and the Blessing to Vishnu): "After Vishnu's arrogance was violently shattered and his skin flayed, Shiva's 'Apocalyptic Wrath' completely and flawlessly Flatlined."
                    "'Tatah prahrishto Bhagavan Shivo'—Then, Lord Shiva, worshipped by the entire infinite cosmos (Lokanamaskritah), became 'Extremely Delighted and Thrilled' (Prahrishto) by Vishnu's absolute total surrender!"
                    "As effortlessly easy as it is to trigger Shiva's apocalyptic fury, it is equally effortless to violently melt His heart through raw authenticity and devotion."
                    "Shiva locked eyes with that bleeding Vishnu lying paralyzed in the dirt, but now His eyes radiated absolutely zero fire; they were a literal ocean of 'Mercy' (Kripa)."
                    "'Uvacha Vishnum tam drishtva kripaya Parameshvarah'—Looking at Vishnu with catastrophic, infinite compassion (Kripaya), that Supreme God Shiva spoke cosmic words."
                    "This visual was exactly like a supreme Father who, after brutally beating a rogue son, violently embraces him upon seeing him weep."
                    "Shiva is absolutely no one's permanent enemy; His enmity is explicitly and exclusively targeted at the 'Ego', absolutely never the entity."
                    "The exact microsecond the Ego (Skin) was flayed, Shiva instantly reinstated Vishnu as His most beloved friend and supreme devotee."
                    "This is the Supreme Cosmic Moment of Sanatana Dharma, permanently proving that even God's apocalyptic Wrath is, in absolute reality, a horrific Blessing."
                    "Now, Shiva was about to detonate a blessing upon His greatest devotee that would instantaneously mutate into the ironclad Law of the Universe."
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 23,
                sanskrit = "वरं वृणीष्व भद्रं ते यत्ते मनसि वर्तते । तद्ददामि न सन्देहः सत्यमेतन्मयोदितम् ॥",
                hindi = """
                    (शिव का ब्रह्मांडीय वरदान और अटल गारंटी): "महाकाल शिव ने विष्णु की आँखों में देखकर एक ऐसी ब्रह्मांडीय गर्जना की जिसने पूरे आसमान को हिला दिया।"
                    "शिव ने कहा: 'वरं वृणीष्व भद्रं ते'— हे विष्णु! तुम्हारा कल्याण हो! जो चाहो वह 'वरदान मांग लो' (वरं वृणीष्व)!"
                    "'यत्ते मनसि वर्तते'— इस पूरे असीम ब्रह्मांड में तुम्हारे 'मन में जो कुछ भी चल रहा है', बेझिझक मुझसे मांग लो!"
                    "चाहे वह तीनों लोकों का राज हो, अमरता हो, या कोई ऐसा हथियार जो देवताओं के पास भी न हो।"
                    "'तद्ददामि न सन्देहः'— मैं वह सब कुछ तुम्हें 'अभी और इसी वक़्त दे दूँगा' (तद्ददामि), इसमें एक सेकंड के करोड़वें हिस्से का भी 'कोई शक नहीं' (न सन्देहः) है!"
                    "और शिव ने अपनी बात को एक खौफनाक और प्रलयंकारी शपथ (Oath) के साथ लॉक (Lock) कर दिया।"
                    "'सत्यमेतन्मयोदितम्'— यह जो मैंने कहा है, वह 100% अटल 'सत्य' है; और शिव के मुँह से निकली बात को ब्रह्मांड का कोई नियम काट नहीं सकता!"
                    "यह शिव की वह तानाशाही ताक़त है जहाँ वे बिना कुछ सोचे-समझे पूरे ब्रह्मांड को दान में दे सकते हैं।"
                    "वे दुनिया के इकलौते ऐसे भगवान (भोलेनाथ) हैं जो खुश होने पर अपना सब कुछ लुटा देते हैं।"
                    "विष्णु समझ गए कि अब उन्हें वह मांगना है जो उन्हें हमेशा के लिए शिव के चरणों से जोड़ दे।"
                """.trimIndent(),
                english = """
                    (Shiva's Cosmic Boon and Ironclad Guarantee): "Looking directly into Vishnu's eyes, Mahakala Shiva unleashed a cosmic roar that violently shook the entire heavens."
                    "Shiva commanded: 'Varam vrinishva bhadram te'—O Vishnu! May absolute welfare be yours! Demand absolutely any 'Boon you desire' (Varam vrinishva)!"
                    "'Yatte manasi vartate'—Whatever is currently circulating inside your 'Mind' in this entire infinite cosmos, demand it from me without a microsecond's hesitation!"
                    "Whether it is the absolute dictatorship of the three realms, immortality, or a weapon that even the gods do not possess."
                    "'Taddadami na sandehah'—I shall 'Hand it over to you right here, right now' (Taddadami); there is absolutely 'Zero Doubt' (Na sandehah) about this in a billionth of a microsecond!"
                    "And Shiva violently Locked His declaration with a terrifying, apocalyptic cosmic Oath."
                    "'Satyametanmayoditam'—What I have just declared is 100% indestructible 'Truth'; and absolutely no law in the cosmos possesses the authority to override words spoken by Shiva!"
                    "This is the dictatorial, absolute power of Shiva where He can literally donate the entire universe without a single thought."
                    "He is the solitary God (Bholenath) in existence who, upon being pleased, ruthlessly gives away absolutely everything He owns."
                    "Vishnu flawlessly realized that he must now demand the exact thing that would permanently weld him to Shiva's feet for all eternity."
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 24,
                sanskrit = "ततः प्रहृष्टो भगवान् विष्णुः सत्यपराक्रमः । उवाच शिवमीशानं ब्रह्मेन्द्रादिभिरर्चितम् ॥",
                hindi = """
                    (विष्णु की खुशी और परमेश्वर से प्रार्थना): "शिव के मुँह से यह 'ब्लैंक चेक' (Blank Check) वरदान सुनकर, ज़मीन पर पड़े भगवान विष्णु का दिल खुशी से फट पड़ा।"
                    "'ततः प्रहृष्टो भगवान् विष्णुः'— तब वह 'सत्यपराक्रम' (अजेय और सच्ची ताक़त वाले) भगवान विष्णु 'अत्यंत प्रसन्न' (प्रहृष्टो) होकर उठ खड़े हुए।"
                    "कुछ देर पहले जो मौत के खौफ से काँप रहे थे, अब शिव की एक मुस्कान ने उनके भीतर करोड़ों सूर्यों की ऊर्जा भर दी।"
                    "'उवाच शिवमीशानं'— और उन्होंने उन साक्षात 'ईशान' (पूरे ब्रह्मांड के इकलौते मालिक/ईश्वर) शिव से बोलना शुरू किया।"
                    "वे शिव कैसे थे? 'ब्रह्मेन्द्रादिभिरर्चितम्'— जिनकी पूजा साक्षात सृष्टि के रचयिता ब्रह्मा, स्वर्ग के राजा इंद्र और ब्रह्मांड के सारे देवता ज़मीन पर गिरकर करते हैं!"
                    "विष्णु ने समझ लिया कि दुनिया की कोई भी भौतिक (Physical) ताक़त मांगना बेवकूफी होगी, क्योंकि शिव के सामने सब कुछ राख है।"
                    "उन्होंने एक ऐसा वरदान माँगने का फैसला किया जो इंसान और भगवान, दोनों के लिए एक मिसाल बन जाए।"
                    "यह दृश्य उस पल का गवाह है जब विष्णु ने अपने आप को पूरी तरह से शिव का सबसे बड़ा भक्त (Devotee) घोषित कर दिया।"
                    "भगवान विष्णु की यह प्रार्थना आज भी सनातन धर्म का सबसे बड़ा सीक्रेट (Secret) है।"
                    "अब सुनो कि भगवान विष्णु ने उस महाकाल शिव से अपनी ज़िंदगी की सबसे बड़ी और आखिरी चीज़ क्या मांगी!"
                """.trimIndent(),
                english = """
                    (Vishnu's Joy and the Prayer to the Supreme God): "Hearing this literal 'Blank Check' cosmic boon from Shiva's mouth, the heart of Lord Vishnu, lying in the dirt, exploded with absolute ecstasy."
                    "'Tatah prahrishto Bhagavan Vishnuh'—Then that 'Satyaparakramah' (The God of invincible, true valor) Lord Vishnu stood up, becoming 'Extremely Thrilled and Ecstatic' (Prahrishto)."
                    "The exact entity who was trembling in sheer terror of Death microseconds ago was instantly supercharged with the radioactive energy of billions of suns by a single smile from Shiva."
                    "'Uvacha Shivamishanam'—And he began to speak directly to that explicit 'Ishana' (The sole, undisputed Dictator/Master of the entire infinite cosmos) Shiva."
                    "What was the exact status of this Shiva? 'Brahmendradibhirarchitam'—The exact God worshipped by the Creator Brahma, the King of Heaven Indra, and all cosmic deities who fall to the dirt before Him!"
                    "Vishnu flawlessly decoded that demanding any pathetic physical or worldly power would be sheer idiocy, because everything is literal ash before Shiva."
                    "He resolved to demand a catastrophic boon that would mutate into an eternal, indestructible benchmark for both humans and gods."
                    "This visual is the absolute witness to the microsecond Vishnu explicitly declared Himself as the ultimate, greatest Devotee of Shiva."
                    "This exact prayer of Lord Vishnu remains the most highly classified Secret in Sanatana Dharma to this day."
                    "Now listen to what exactly Lord Vishnu demanded as the greatest and final prize of his existence from that Mahakala Shiva!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 25,
                sanskrit = "विष्णुरुवाच । यदि मे वरदो देव यदि देयो वरो मम । तव भक्तिः सदा भूयात् तव दासोऽहमस्मि वै ॥",
                hindi = """
                    (विष्णु का अंतिम वरदान - शिव की शाश्वत गुलामी): "भगवान विष्णु ने हाथ जोड़कर ब्रह्मांड का सबसे बड़ा और खौफनाक वरदान मांग लिया।"
                    "विष्णु ने कहा (विष्णुरुवाच): 'यदि मे वरदो देव यदि देयो वरो मम'— हे महादेव! अगर आप सच में मुझे वरदान देना ही चाहते हैं और मुझ पर मेहरबान हैं..."
                    "तो मुझे कोई ब्रह्मा का पद या स्वर्ग का राज नहीं चाहिए! मुझे केवल एक चीज़ चाहिए..."
                    "'तव भक्तिः सदा भूयात्'— मेरे हृदय में आपके लिए ऐसी प्रलयंकारी 'भक्ति' (Devotion) पैदा हो जाए जो 'सदा' (हमेशा-हमेशा के लिए) जलती रहे!"
                    "यह भक्ति कभी खत्म न हो, चाहे महा-प्रलय आ जाए या मैं कोई भी अवतार लूँ; मेरे हर अवतार में मेरा दिल केवल आपके लिए धड़के।"
                    "और सबसे बड़ा धमाका: 'तव दासोऽहमस्मि वै'— मैं आज से और अनंत काल तक के लिए साक्षात 'आपका दास (गुलाम/Servant)' बन कर रहूँ!"
                    "सोचो! जो विष्णु पूरी दुनिया को पालते हैं, वे खुद अपने मुँह से शिव का 'गुलाम' (दास) बनने की भीख मांग रहे हैं।"
                    "यह अहंकार की उस सबसे क्रूर मौत का नतीजा है जो शरभ अवतार ने की थी।"
                    "सनातन धर्म में 'शिव का दास' बनने से बड़ा कोई रुतबा (Status) पूरे असीम अंतरिक्ष में नहीं है।"
                    "भगवान विष्णु ने अपनी इस मांग से यह साबित कर दिया कि शिव के चरणों में बैठने से बड़ी कोई आज़ादी (Moksha) नहीं है!"
                """.trimIndent(),
                english = """
                    (Vishnu's Final Boon - The Eternal Slavery of Shiva): "Folding his hands, Lord Vishnu demanded the absolute greatest and most terrifying cosmic boon in the entire universe."
                    "Vishnu roared (Vishnuruvacha): 'Yadi me varado Deva yadi deyo varo mama'—O Mahadeva! If You genuinely intend to grant me a boon and are truly merciful upon me..."
                    "I absolutely do not demand the pathetic throne of Brahma or the kingdom of Heaven! I demand strictly ONE explicit thing..."
                    "'Tava bhaktih sada bhuyat'—Let an apocalyptic, radioactive 'Devotion' (Bhakti) for You detonate inside my heart that burns 'Sada' (Eternally, forever and ever)!"
                    "Let this devotion absolutely never extinguish, even if Doomsday strikes or I manifest in any Avatar; in every incarnation, let my heart beat exclusively for You."
                    "And the ultimate cosmic detonation: 'Tava daso'hamasmi vai'—From this exact microsecond until infinite eternity, let me exist explicitly as 'Your Dasa (Slave/Servant)'!"
                    "Think! The exact Vishnu who relentlessly operates the entire world is literally begging with his own mouth to become the biological 'Slave' of Shiva."
                    "This is the direct, explicit aftermath of the brutal assassination of the ego executed by the Sharabha Avatar."
                    "In Sanatana Dharma, there is absolutely no greater Status in the entire infinite vacuum of space than mutating into the 'Slave of Shiva'."
                    "Through this demand, Lord Vishnu permanently proved that there is absolutely no greater Freedom (Moksha) than rotting eternally at the feet of Shiva!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 26,
                sanskrit = "त्वत्पादाब्जस्मृतिर्मेऽस्तु यावत्कल्पान्तमव्यय । इत्युक्तो विष्णुना देवः शिवः परमकारणम् ॥",
                hindi = """
                    (विष्णु का अंतिम संकल्प और शिव की स्वीकृति): "विष्णु की भूख अभी भी शांत नहीं हुई थी; उन्होंने अपनी भक्ति को समय (Time) के पार ले जाने का संकल्प लिया।"
                    "विष्णु ने चीख कर कहा: 'त्वत्पादाब्जस्मृतिर्मेऽस्तु'— हे महादेव! मेरे दिमाग में हमेशा केवल और केवल 'आपके चरण-कमलों की याद' (स्मृति) गूँजती रहे!"
                    "यह याद कितनी देर तक रहे? 'यावत्कल्पान्तमव्यय'— जब तक यह पूरा ब्रह्मांड खत्म नहीं हो जाता, जब तक यह 'कल्प' (Cosmic Age) समाप्त होकर महा-प्रलय नहीं आ जाती..."
                    "तब तक, हे अविनाशी (अव्यय) शिव, मैं एक सेकंड के लिए भी आपको भूलने का पाप न करूँ!"
                    "विष्णु ने खुद को शिव के चरणों में एक लोहे की कील की तरह हमेशा-हमेशा के लिए ठोक (Lock) दिया।"
                    "उनके दिमाग के सारे सॉफ्टवेयर (Software) डिलीट हो गए और केवल 'शिव का नाम' उस सिस्टम में बच गया।"
                    "'इत्युक्तो विष्णुना देवः'— जब भगवान विष्णु ने इस तरह अपनी पूरी हस्ती मिटाकर यह खौफनाक मांग की..."
                    "तब वह 'देवः शिवः परमकारणम्'— वह साक्षात शिव, जो इस पूरी असीम सृष्टि का इकलौता और सबसे 'परम कारण' (The Ultimate Cause/Source Code) हैं..."
                    "उन्होंने विष्णु की इस मांग को सुनकर अपना फैसला सुनाया। उन्होंने विष्णु को वह वरदान दे दिया जिसने उन्हें शिव का सबसे बड़ा भक्त बना दिया।"
                    "यहाँ आकर विष्णु और शिव के बीच की यह प्रलयंकारी लड़ाई हमेशा के लिए परम प्रेम में बदल गई!"
                """.trimIndent(),
                english = """
                    (Vishnu's Final Resolve and Shiva's Acceptance): "Vishnu's hunger was absolutely not yet pacified; he resolved to project his devotion infinitely beyond the limits of Time."
                    "Vishnu violently screamed: 'Tvatpadabjasmritirme'stu'—O Mahadeva! Let the 'Memory' (Smriti) of strictly and exclusively 'Your Lotus Feet' constantly echo in my brain!"
                    "For exactly how long should this memory persist? 'Yavatkalpantamavyaya'—Until this entire infinite cosmos is utterly destroyed, until this 'Kalpa' (Cosmic Age) violently ends in the Great Annihilation..."
                    "Until then, O Indestructible (Avyaya) Shiva, let me absolutely never commit the horrific sin of forgetting You for even a microsecond!"
                    "Vishnu literally, physically hammered himself like a titanium nail directly into the feet of Shiva forever."
                    "Every single pathetic software in his brain was permanently Deleted, leaving exclusively the 'Name of Shiva' running in his system."
                    "'Ityukto Vishnuna Devah'—When Lord Vishnu made this terrifying demand, completely erasing his own absolute existence..."
                    "Then that 'Devah Shivah Paramakaranam'—That explicit Lord Shiva, who is the solitary and most absolute 'Supreme Cause' (The Ultimate Source Code) of this entire infinite creation..."
                    "Hearing Vishnu's demand, He delivered His absolute cosmic verdict. He granted Vishnu the exact boon that mutated him into Shiva's greatest cosmic devotee."
                    "Right here, this apocalyptic, bloody warfare between Vishnu and Shiva violently mutated into the ultimate, eternal Supreme Love!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 27,
                sanskrit = "तथास्त्विति तदा प्राह विष्णुं देवः स शङ्करः । तत्रैवान्तरधीयत शिवः परमकारणम् ॥",
                hindi = """
                    (शिव का 'तथास्तु' और ब्रह्मांडीय शून्यता में गायब होना): "विष्णु की उस चीखती हुई प्रार्थना को सुनकर, महाकाल शिव ने अपना आखिरी और अटल फैसला सुना दिया।"
                    "'तथास्त्विति तदा प्राह'— उस परमेश्वर 'शङ्कर' ने विष्णु की आँखों में देखकर गर्जना की: 'तथास्तु!' (ऐसा ही होगा!)।"
                    "यह कोई मामूली शब्द नहीं था; यह 'तथास्तु' वह ब्रह्मांडीय मुहर (Seal) थी जिसे दुनिया की कोई ताक़त, समय या मौत कभी नहीं तोड़ सकती।"
                    "शिव ने विष्णु को ब्रह्मांड का सबसे बड़ा भक्त घोषित कर दिया; विष्णु का सॉफ्टवेयर (Software) अब हमेशा के लिए शिव के नाम से हैक (Hack) हो चुका था।"
                    "वरदान देने के ठीक एक सेकंड बाद क्या हुआ? 'तत्रैवान्तरधीयत'— वह साक्षात शिव उसी युद्ध के मैदान में एक खौफनाक धमाके के साथ 'अदृश्य' (Disappear/Vanish) हो गए!"
                    "वह परम भयंकर शरभ अवतार (जिसने ब्रह्मांड को हिला दिया था), एक पल में हवा में धुएं की तरह विलीन हो गया।"
                    "शिव को किसी भी रूप में कैद नहीं किया जा सकता; वे केवल अपना काम (अहंकार का विनाश) करते हैं और वापस उस 'परम शून्यता' (Black Hole) में लौट जाते हैं।"
                    "वह शिव जो 'परमकारणम्' (पूरी सृष्टि का इकलौता सोर्स कोड) है, वह किसी भी जगह टिक कर नहीं रहता; वह सब जगह है और कहीं नहीं है।"
                    "शरभ अवतार का काम खत्म हो चुका था; विष्णु का अहंकार मर चुका था, और सृष्टि प्रलय से बच गई थी।"
                    "यह शिव का वह खौफनाक 'लॉग आउट' (Log out) था जिसने पूरे ब्रह्मांड में सन्नाटा छा दिया!"
                """.trimIndent(),
                english = """
                    (Shiva's 'Tathastu' and Vanishing into the Cosmic Void): "Hearing that screaming, desperate prayer from Vishnu, Mahakala Shiva delivered His final, ironclad absolute verdict."
                    "'Tathastviti tada praha'—That Supreme God 'Shankara' locked eyes with Vishnu and roared: 'Tathastu!' (So it shall be!)."
                    "This was absolutely no ordinary word; this 'Tathastu' was the cosmic Titanium Seal that absolutely no force, Time, or Death can ever shatter."
                    "Shiva explicitly declared Vishnu as the greatest devotee in the cosmos; Vishnu's software was now permanently Hacked by the name of Shiva."
                    "What exactly happened one microsecond after granting the boon? 'Tatraivantaradhiyata'—That explicit Shiva 'Vanished' (Disappeared) from that exact battlefield with a terrifying cosmic detonation!"
                    "That horrifically apocalyptic Sharabha Avatar (which had literally shaken the universe) evaporated into thin air exactly like smoke in a split second."
                    "Shiva can absolutely never be imprisoned in any physical form; He strictly executes His mission (the assassination of ego) and violently returns to that 'Supreme Void' (Black Hole)."
                    "That Shiva who is the 'Paramakaranam' (The sole Source Code of the entire creation) absolutely never stays anchored in one place; He is simultaneously everywhere and nowhere."
                    "The mission of the Sharabha Avatar was flawlessly terminated; Vishnu's ego was dead, and the cosmos was violently salvaged from Doomsday."
                    "This was Shiva's terrifying 'Log Out' that instantaneously dropped an apocalyptic dead silence over the entire infinite universe!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 28,
                sanskrit = "नृसिंहोऽपि तदा देवः शान्तिकोपः प्रशान्तधीः । स्वस्थानं गतवान् देवो विष्णुः सत्यपराक्रमः ॥",
                hindi = """
                    (क्रोध की मौत और विष्णु की वापसी): "शिव के जाते ही उस युद्ध के मैदान का सारा ब्रह्मांडीय रेडिएशन (Radiation) एकदम शांत हो गया।"
                    "और वह विष्णु का 'नृसिंह' अवतार, जो कुछ देर पहले करोड़ों सूर्यों की गर्मी से धधक रहा था और दुनिया को भस्म करने वाला था..."
                    "'शान्तिकोपः प्रशान्तधीः'— उसका वह प्रलयंकारी 'क्रोध' (Anger) 100% सुन्न होकर मर गया (शान्तिकोपः), और उसकी 'बुद्धि' (Mind/धीः) पूरी तरह से 'परम शांत' (प्रशान्त) हो गई!"
                    "यह कोई आम शांति नहीं थी; यह वह सन्नाटा था जो अहंकार के मरने के बाद पैदा होता है; नृसिंह का बायोलॉजिकल इंजन (Biological Engine) पूरी तरह कूल डाउन (Cool down) हो चुका था।"
                    "विष्णु का वह आउट ऑफ कंट्रोल (Out of control) रूप अब पूरी तरह से कंट्रोल (Control) में आ गया था।"
                    "'स्वस्थानं गतवान् देवो'— इसके बाद, वह साक्षात भगवान विष्णु शांति से उठे और अपने असली ठिकाने (स्वस्थानं / बैकुंठ) वापस लौट गए (गतवान्)।"
                    "अब वे 'सत्यपराक्रमः' (सच्ची ताक़त वाले) थे, क्योंकि अब उनकी ताक़त में अहंकार की कोई मिलावट नहीं थी; उनकी ताक़त अब 100% शुद्ध थी।"
                    "विष्णु समझ गए कि ब्रह्मांड की सबसे बड़ी ताक़त मारने में नहीं, बल्कि अपने अहंकार को मारने में है।"
                    "इस युद्ध ने ब्रह्मांड के पूरे मैट्रिक्स (Matrix) को रिसेट (Reset) कर दिया था।"
                    "नरसिंह का लौटना इंसानियत को यह पैगाम है कि चाहे तुम कितने भी ताक़तवर हो जाओ, अंत में तुम्हें अपनी असली जगह (शून्यता) पर वापस लौटना ही होगा!"
                """.trimIndent(),
                english = """
                    (The Death of Wrath and the Return of Vishnu): "The exact microsecond Shiva vanished, the entire apocalyptic cosmic Radiation of that battlefield instantly Flatlined."
                    "And that 'Narasimha' Avatar of Vishnu, who was blazing with the heat of billions of suns microseconds ago, ready to incinerate the world..."
                    "'Shantikopah prashantadhih'—His apocalyptic 'Wrath' (Kopa) went 100% numb and died a brutal death (Shantikopah), and his 'Intellect' (Mind/Dhih) became terrifyingly 'Absolutely Silent' (Prashanta)!"
                    "This was absolutely no ordinary peace; this was the deafening silence spawned strictly after the assassination of the ego; Narasimha's Biological Engine had completely Cooled Down."
                    "Vishnu's horrific, Out of Control manifestation was now 100% ruthlessly back under absolute Control."
                    "'Svasthanam gatavan devo'—Following this, that explicit Lord Vishnu calmly rose and 'Returned' (Gatavan) to his authentic, true cosmic coordinates (Svasthanam / Vaikuntha)."
                    "He was now 'Satyaparakramah' (Possessing True, Authentic Power), because his strength now contained zero pathetic mixture of ego; his power was now 100% pure, radioactive energy."
                    "Vishnu flawlessly realized that the absolute greatest power in the cosmos is not in slaughtering others, but in brutally assassinating one's own ego."
                    "This apocalyptic war had completely, violently Reset the entire operating System (Matrix) of the universe."
                    "Narasimha's return broadcasts a lethal message to humanity: No matter how insanely powerful you mutate into, you must ultimately return to your authentic place (The Void)!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 29,
                sanskrit = "य इदं शृणुयान्नित्यं शरभोपनिषत्परम् । स सर्वपापनिर्मुक्तो शिवलोके महीयते ॥",
                hindi = """
                    (शरभ उपनिषद की प्रलयंकारी ताक़त और मोक्ष): "अब यह उपनिषद अपनी असली और सबसे खौफनाक ताक़त (Phala Shruti) का ऐलान करता है।"
                    "'य इदं शृणुयान्नित्यं'— जो कोई भी इंसान इस परम और ब्रह्मांडीय 'शरभ उपनिषद' (शरभोपनिषत्परम्) को हर रोज़ (नित्यं) सुनता है या अपने दिमाग में उतार लेता है..."
                    "यह कोई कहानी नहीं है; यह वह न्यूक्लियर कोड (Nuclear Code) है जो सीधे तुम्हारे कर्मों (Karma) के सर्वर को हैक करता है।"
                    "इस एक श्लोक को सुनने मात्र से तुम्हारे अंदर का 'नरसिंह' (क्रोध और अहंकार) मर जाता है और 'शरभ' (परम शिव) जाग उठता है।"
                    "परिणाम क्या होगा? 'स सर्वपापनिर्मुक्तो'— वह इंसान अपने पिछले अरबों-खरबों जन्मों के 'सारे महापापों' (सर्वपाप) से एक ही झटके में पूरी तरह 'आज़ाद' (निर्मुक्तो) हो जाता है!"
                    "उसके कर्मों का पूरा रिकॉर्ड (Record) ब्रह्मांड के कंप्यूटर से 100% डिलीट (Delete) हो जाता है; उसके पाप जलकर राख हो जाते हैं।"
                    "और इसके बाद वह कहाँ जाता है? 'शिवलोके महीयते'— वह इस सड़ी हुई पृथ्वी या झूठे स्वर्ग में नहीं जाता; वह सीधे साक्षात 'शिवलोक' (कैलाश / परम शून्यता) में जाकर राज करता है!"
                    "उसे देवता भी नमन करते हैं, क्योंकि वह अब इंसान नहीं रहा, वह साक्षात शिव का रूप बन चुका है।"
                    "इस उपनिषद को सुनना मौत के मुँह से ज़िंदगी को ज़बरदस्ती छीन लेने के बराबर है।"
                    "यह तुम्हारे खून और डीएनए (DNA) को हैक करके तुम्हें सीधा भगवान में अपग्रेड (Upgrade) कर देता है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Power of Sharabha Upanishad and Moksha): "Now this Upanishad violently broadcasts its authentic and most terrifying Power (Phala Shruti)."
                    "'Ya idam shrinuyannityam'—Whosoever human being 'Listens' or physically downloads this supreme, cosmic 'Sharabha Upanishad' (Sharabhopanishatparam) into his brain every single day (Nityam)..."
                    "This is absolutely no pathetic story; it is the exact Nuclear Code that directly Hacks the cosmic Server of your Karma."
                    "Merely intercepting the acoustic frequency of this Shloka slaughters the 'Narasimha' (Wrath and Ego) inside you and violently awakens the 'Sharabha' (Supreme Shiva)."
                    "What is the explicit consequence? 'Sa sarvapapanirmukto'—That human is instantaneously and completely 'Liberated' (Nirmukto) from 'Every single Catastrophic Sin' (Sarvapapa) of his billions of past incarnations!"
                    "His entire cosmic record of Karma is 100% permanently Deleted from the universe's mainframe; his sins are incinerated to absolute ash."
                    "And where exactly does he rocket to after this? 'Shivaloke mahiyate'—He absolutely does not plummet to this rotting Earth or some fake Heaven; he rockets directly to rule the explicit 'Shivaloka' (The Supreme Void)!"
                    "Even the gods fall to the dirt to worship him, because he is no longer human; he has mutated into the literal, physical manifestation of Shiva."
                    "Listening to this Upanishad is mathematically equivalent to violently snatching life directly out of the jaws of Death."
                    "It physically Hacks your blood and DNA, Upgrading you instantaneously and brutally into God Himself!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 30,
                sanskrit = "यस्त्विमां पठते नित्यं शरभोपनिषत्परम् । स सर्वान् कामानवाप्नोति शिवेन सह मोदते ॥",
                hindi = """
                    (पढ़ने का धमाका और शिव के साथ परम आनंद): "सुनने से भी बड़ा और खौफनाक धमाका तब होता है जब कोई इंसान इसे खुद पढ़ता है।"
                    "'यस्त्विमां पठते नित्यं'— जो कोई भी ब्रह्मांडीय योद्धा इस परम 'शरभ उपनिषद' को हर दिन अपनी ज़बान से 'पढ़ता' (पठते) है या इसका उच्चारण करता है..."
                    "वह अपने गले और होंठों से साक्षात शिव के उस प्रलयंकारी मंत्र (Frequency) को फायर (Fire) कर रहा होता है।"
                    "यह पाठ करना ऐसा है जैसे तुम अपनी साँसों में बारूद भरकर अपने ही दिमाग के अज्ञान को बम से उड़ा रहे हो।"
                    "इसका परिणाम क्या होता है? 'स सर्वान् कामानवाप्नोति'— वह इंसान ब्रह्मांड की 'सारी इच्छाओं' (सर्वान् कामान्) और ताक़तों को अपनी मुट्ठी में कुचल कर हासिल कर लेता है!"
                    "दुनिया की कोई भी दौलत, कोई भी ताक़त, कोई भी सिद्धि (Superpower) उसकी पहुँच से बाहर नहीं रहती; वह पूरी सृष्टि का तानाशाह (Dictator) बन जाता है।"
                    "लेकिन वह इन छोटी-मोटी चीज़ों पर नहीं रुकता; 'शिवेन सह मोदते'— वह साक्षात महाकाल 'शिव के साथ' (शिवेन सह) उस परम आनंद में डूबकर 'मस्त' (मोदते) हो जाता है!"
                    "वह शिव का दास नहीं रहता, वह शिव के बराबर बैठकर ब्रह्मांड का तमाशा देखता है।"
                    "यह शरीर के रहते हुए भी शरीर से बाहर निकलकर सीधे परमेश्वर के साथ पार्टी (Cosmic Union) करने का विज्ञान है।"
                    "जो इस ग्रंथ को जपता है, उसके लिए यह पूरी दुनिया केवल एक खिलौना बन कर रह जाती है!"
                """.trimIndent(),
                english = """
                    (The Detonation of Reading and Supreme Bliss with Shiva): "An even more catastrophic and apocalyptic explosion detonates when a human actually reads this himself."
                    "'Yastvimam pathate nityam'—Whosoever cosmic warrior physically 'Reads' (Pathate) or violently chants this supreme 'Sharabha Upanishad' every single day..."
                    "He is literally Firing the exact apocalyptic acoustic Frequency of Shiva directly through his physical throat and lips."
                    "Executing this recitation is exactly like packing your breath with literal gunpowder and blowing up the ignorance in your own brain with dynamite."
                    "What is the explicit outcome? 'Sa sarvan kamanavapnoti'—That human brutally crushes and violently acquires 'Every single Desire' (Sarvan Kaman) and absolute power in the entire cosmos within his fist!"
                    "Absolutely zero worldly wealth, zero power, and zero Siddhi (Superpower) remains out of his grasp; he mutates into the undisputed Dictator of the creation."
                    "But he absolutely does not stop at these pathetic earthly toys; 'Shivena saha modate'—He violently drowns in supreme bliss and 'Rejoices' (Modate) strictly 'Alongside explicit Shiva' (Shivena saha)!"
                    "He is absolutely no longer a pathetic slave to Shiva; he sits as an absolute equal, silently watching the pathetic biological drama of the universe."
                    "This is the science of rocketing out of the biological shell while still breathing, to execute a direct Cosmic Union with the Supreme God."
                    "For the Titan who chants this scripture, this entire infinite world is permanently reduced to nothing more than a pathetic, glitching toy!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 31,
                sanskrit = "न तस्य किञ्चिदप्राप्यं त्रैलोक्ये सचराचरे । शरभोपनिषत्पुण्यां ब्राह्मणो यः पठेत्सदा ॥",
                hindi = """
                    (ब्रह्मांड की हर ताक़त पर कब्ज़ा और अजेयता): "उपनिषद उस इंसान की ताक़त का नंगा सच बताता है जिसने इस शरभ विद्या को हैक (Hack) कर लिया है।"
                    "'न तस्य किञ्चिदप्राप्यं'— इस असीम अंतरिक्ष में ऐसी कोई भी एक चीज़ या ताक़त नहीं है, जो उसके लिए 'अप्राप्य' (Impossible to get) हो!"
                    "उसके लिए नामुमकिन शब्द की ही मौत हो जाती है; वह जो सोच ले, वह उसी सेकंड सच हो जाता है।"
                    "'त्रैलोक्ये सचराचरे'— स्वर्ग, पृथ्वी, पाताल— इन तीनों लोकों (त्रैलोक्ये) में, और इस पूरी सृष्टि के हर चलते-फिरते (चर) और स्थिर (अचर) कण-कण पर..."
                    "उस योगी का 100% तानाशाही कब्ज़ा (Dictatorship) हो जाता है! वह पूरी सृष्टि का हैकर (Hacker) बन जाता है।"
                    "'शरभोपनिषत्पुण्यां ब्राह्मणो यः पठेत्सदा'— जो कोई भी 'ब्राह्मण' (सच्चा ज्ञानी, जो ब्रह्म को जानता है) इस परम पवित्र और प्रलयंकारी 'शरभ उपनिषद' को 'सदा' (हमेशा) पढ़ता है..."
                    "वह इंसानियत की हर कमज़ोरी को कुचल कर ब्रह्मांड के सबसे ऊँचे तख़्त पर जाकर बैठ जाता है।"
                    "यह कोई कहानी की किताब नहीं है; यह एक ऐसा बायोलॉजिकल कोड (Biological Code) है जो तुम्हारे दिमाग के उस हिस्से को चालू करता है जो भगवान के पास होता है।"
                    "इस उपनिषद को पढ़ने वाला इंसान कभी भिखारी नहीं हो सकता; वह जो मांगता है, ब्रह्मांड उसे देने के लिए मजबूर हो जाता है।"
                    "यह शरीर और मन की उस सबसे खौफनाक ताक़त का ऐलान है जहाँ भगवान खुद तुम्हारे सामने झुक जाते हैं!"
                """.trimIndent(),
                english = """
                    (The Hijacking of Every Cosmic Power and Invincibility): "The Upanishad rips open the naked truth regarding the sheer apocalyptic power of the human who has Hacked this Sharabha Vidya."
                    "'Na tasya kinchidaprapyam'—In this entire infinite vacuum of space, there is absolutely zero microscopic object or power that is 'Impossible to acquire' (Aprapyam) for him!"
                    "For him, the very concept of 'Impossible' dies a brutal death; whatever he merely hallucinates violently mutates into reality in that exact microsecond."
                    "'Trailokye sacharachare'—In all three dimensions (Heaven, Earth, Hell), and over every single moving (Chara) and unmoving (Achara) atomic particle in this entire creation..."
                    "That Yogi establishes a 100% absolute, tyrannical Dictatorship! He explicitly mutates into the ultimate Hacker of the entire creation."
                    "'Sharabhopanishatpunyam brahmano yah pathetsada'—Whosoever 'Brahmin' (The true Titan who has realized Brahman) 'Constantly' (Sada) reads and fires this supremely pure, apocalyptic 'Sharabha Upanishad'..."
                    "He ruthlessly crushes every single weakness of humanity and violently occupies the absolute highest undisputed throne of the cosmos."
                    "This is absolutely no pathetic storybook; it is an explicit Biological Code engineered to forcibly boot up the exact sector of the brain that operates as God."
                    "The human who weaponizes this Upanishad can absolutely never be a pathetic beggar; whatever he demands, the universe is violently forced to deliver."
                    "This is the ultimate cosmic declaration of the most terrifying physical and psychological firepower, where God Himself bows before you!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 32,
                sanskrit = "सर्वान् पापान् प्रणाश्याशु शिवलोके स गच्छति । यस्तु ध्यायति तं नित्यं शरभं परमेश्वरम् ॥",
                hindi = """
                    (महापापों का संहार और शिवलोक की गारंटी): "यह श्लोक शरभ भगवान के ध्यान (Meditation) का सबसे क्रूर और प्रलयंकारी परिणाम बताता है।"
                    "जो योगी केवल पाठ नहीं करता, बल्कि 'यस्तु ध्यायति तं नित्यं'— जो अपने दिमाग को पूरी तरह से उस 'परमेश्वर शरभ' पर 'ध्यान' (Focus/Lock) करके गाड़ देता है..."
                    "जो उस आठ पैरों वाले, ब्रह्मांड को निगलने वाले खौफनाक शिव को हर रोज़ (नित्यं) अपनी आँखों के पीछे देखता है..."
                    "उस धधकते हुए ध्यान की लेज़र (Laser) से क्या होता है? 'सर्वान् पापान् प्रणाश्याशु'!"
                    "उसके पिछले करोड़ों जन्मों के 'सारे भयंकर महापाप' (सर्वान् पापान्) एक सेकंड के करोड़वें हिस्से में 'तुरंत' (आशु) जलकर पूरी तरह 'भस्म' (प्रणाश्य) हो जाते हैं!"
                    "ध्यान की आग से बड़ा कोई सर्फ-एक्सेल (Detergent) नहीं है; यह इंसान के कर्मों (Karma) के पूरे रिकॉर्ड (Database) को फॉर्मेट (Format) कर देता है।"
                    "पापों की मौत के बाद उसका शरीर एक खाली बर्तन बन जाता है।"
                    "और फिर 'शिवलोके स गच्छति'— शरीर के मरने पर वह सीधा अंतरिक्ष को चीरते हुए उस असीम 'शिवलोक' (The Ultimate Void) में रॉकेट की तरह घुस (गच्छति) जाता है!"
                    "जहाँ से कोई वापस इस सड़ी हुई दुनिया में जन्म लेने नहीं आता।"
                    "यह ध्यान इंसान के नर्वस सिस्टम (Nervous System) को हैक करके उसे सीधा अमर (Immortal) बना देने की 100% गारंटी है!"
                """.trimIndent(),
                english = """
                    (The Slaughter of Catastrophic Sins and the Guarantee of Shivaloka): "This Shloka dictates the most brutal, apocalyptic consequence of launching explicit 'Meditation' (Dhyana) on Lord Sharabha."
                    "The Yogi who does not merely chant, but 'Yastu dhyayati tam nityam'—who violently 'Focuses/Locks' his brain entirely onto that 'Supreme God Sharabha'..."
                    "He who explicitly visualizes that horrific, eight-legged, universe-swallowing Shiva directly behind his eyelids every single day (Nityam)..."
                    "What exactly detonates from that radioactive laser of meditation? 'Sarvan Papan Pranashyashu'!"
                    "Every single 'Catastrophic, Horrific Sin' (Sarvan Papan) committed over billions of his past incarnations is 'Instantaneously' (Ashu) incinerated and completely 'Annihilated' (Pranashya) in a microsecond!"
                    "There is absolutely no greater detergent than the apocalyptic fire of meditation; it completely Formats the entire Database of the human's Karma."
                    "Following the brutal death of his sins, his physical biological shell mutates into an empty, hollow vessel."
                    "And then 'Shivaloke sa gacchati'—Upon biological death, he violently tears through the fabric of space and rockets directly into the infinite 'Shivaloka' (The Supreme Void)!"
                    "From where absolutely no entity ever returns to breed in this rotting biological hell."
                    "This Meditation is a 100% ironclad guarantee of Hacking the human Nervous System and mutating the mortal instantaneously into an Immortal!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 33,
                sanskrit = "तस्य मृत्युभयं नास्ति व्याधिभिर्न च बाध्यते । स सर्वत्र जयी भूत्वा शिवेनान्ते प्रलीयते ॥",
                hindi = """
                    (मृत्यु का वध और शिव में अंतिम विलय): "यह इस उपनिषद की वह सबसे बड़ी और खौफनाक सिद्धि (Superpower) है जिससे दुनिया का हर इंसान काँपता है— 'मौत'!"
                    "उपनिषद गर्जना करता है: 'तस्य मृत्युभयं नास्ति'— उस महायोगी के दिमाग से 'मौत का खौफ' (मृत्युभयं) हमेशा-हमेशा के लिए 100% डिलीट (Delete) हो जाता है (नास्ति)!"
                    "जब इंसान यह जान लेता है कि वह शरीर है ही नहीं, वह साक्षात शिव है, तो मौत उसे कैसे मार सकती है? मौत खुद उसके पैरों में गिर जाती है।"
                    "'व्याधिभिर्न च बाध्यते'— दुनिया की कोई भी लाइलाज 'बीमारी' (व्याधि) या वायरस उसके शरीर को बाँध (बाध्यते) या सड़ा नहीं सकता!"
                    "उसका शरीर भले ही बायोलॉजिकल हो, लेकिन उसका ऑपरेटिंग सिस्टम (Operating System) अब शिव का है, जिसे कोई रोग हैक नहीं कर सकता।"
                    "'स सर्वत्र जयी भूत्वा'— वह इंसान इस पूरे ब्रह्मांड में, हर जगह (सर्वत्र), और हर हालत में केवल और केवल एक 'अजेय विजेता' (जयी) बनकर उभरता है!"
                    "कोई दुश्मन, कोई ताक़त और कोई प्रलय उसे हरा नहीं सकती; वह माया (Matrix) के खेल को हमेशा जीतता है।"
                    "और सबसे आखिरी धमाका— 'शिवेनान्ते प्रलीयते'— और जब उसका समय (End) आता है, तो वह मरता नहीं है..."
                    "वह साक्षात उस असीम 'शिव' के अंदर एक परमाणु बम की तरह फटकर हमेशा-हमेशा के लिए उसी में 'विलीन' (Merge/Melt) हो जाता है (प्रलीयते)!"
                    "यह शरीरधारी कीड़े से लेकर ब्रह्मांड के मालिक (ईश्वर) तक के सबसे खौफनाक सफर का 'द एंड' (The End) है!"
                """.trimIndent(),
                english = """
                    (The Assassination of Death and the Final Fusion into Shiva): "This is the absolute greatest, most terrifying Superpower (Siddhi) granted by this Upanishad, the exact entity every mortal trembles before—'Death'!"
                    "The Upanishad violently roars: 'Tasya mrityubhayam nasti'—From the brain of that colossal Yogi, the pathetic 'Terror of Death' (Mrityubhayam) is 100% permanently Deleted (Nasti) forever!"
                    "When a human flawlessly realizes he is absolutely not a physical body but explicit Shiva, how can Death possibly kill him? Death itself falls paralyzed at his boots."
                    "'Vyadhibhirna cha badhyate'—Absolutely zero incurable biological 'Disease' (Vyadhi) or virus possesses the capability to bind (Badhyate) or rot his flesh!"
                    "His shell may be biological, but his Operating System is now strictly Shiva's, which absolutely no disease can ever Hack."
                    "'Sa sarvatra jayi bhutva'—That Titan emerges exclusively and strictly as an 'Invincible Conqueror' (Jayi) everywhere (Sarvatra) across this entire infinite universe!"
                    "Zero enemies, zero forces, and zero Doomsdays can ever defeat him; he relentlessly and flawlessly wins the pathetic game of the Matrix (Maya)."
                    "And the final apocalyptic detonation—'Shivenante praliyate'—And when his absolute 'End' arrives, he absolutely does not die..."
                    "He detonates exactly like a nuclear bomb directly inside that infinite 'Shiva' and 'Melts/Fuses' (Praliyate) permanently into Him for all eternity!"
                    "This is the absolute 'The End' of the most horrific, terrifying journey from a biological insect to the explicit Dictator of the Cosmos (God)!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 34,
                sanskrit = "यो ह वै शरभोपनिषदमधीते स सर्वपापैः प्रमुच्यते । स सर्वान् देवान् वेत्ति स सर्वान् लोकान् जयति ॥",
                hindi = """
                    (ज्ञान की हैकिंग और ब्रह्मांड पर विजय): "यह श्लोक शरभ विद्या की उस खौफनाक और असीमित ताक़त का ऐलान करता है जो इंसान के सोचने की हद से बाहर है।"
                    "'यो ह वै शरभोपनिषदमधीते'— जो कोई भी इंसान इस प्रलयंकारी 'शरभ उपनिषद' को केवल 'पढ़ता' (अधीते) है या इसका गहरा अध्ययन करता है..."
                    "वह केवल एक किताब नहीं पढ़ रहा है; वह अपने डीएनए (DNA) के उस कोड को तोड़ रहा है जो उसे इंसान बनाए हुए है।"
                    "'स सर्वपापैः प्रमुच्यते'— वह अपने पिछले करोड़ों जन्मों के 'हर एक छोटे और बड़े महापाप' से एक ही झटके में हमेशा के लिए 'आज़ाद' (प्रमुच्यते) हो जाता है!"
                    "पाप केवल एक मेंटल वायरस (Mental Virus) है, और यह उपनिषद वह एंटी-वायरस (Anti-virus) है जो इसे एक सेकंड में डिलीट (Delete) कर देता है।"
                    "और इसके बाद उसे क्या मिलता है? 'स सर्वान् देवान् वेत्ति'— उसे किसी भगवान को खोजने नहीं जाना पड़ता; वह घर बैठे-बैठे 'सभी देवताओं' को साक्षात 'जान' (वेत्ति) लेता है!"
                    "यानी ब्रह्मांड के सारे सीक्रेट्स (Secrets), सारे देवताओं के पासवर्ड (Passwords) उसके दिमाग में ऑटोमैटिकली (Automatically) डाउनलोड (Download) हो जाते हैं।"
                    "और सबसे बड़ी बात: 'स सर्वान् लोकान् जयति'— वह केवल इस धरती को नहीं, बल्कि इस ब्रह्मांड के 'सभी लोकों' (All Dimensions/Galaxies) को पूरी तरह से 'जीत' (जयति) लेता है!"
                    "वह एक ही जगह बैठकर अपनी चेतना (Consciousness) की ताक़त से पूरे ब्रह्मांड का इकलौता तानाशाह (Dictator) बन जाता है।"
                    "यह शरीर में रहते हुए पूरे मैट्रिक्स (Matrix) का कंट्रोल अपने हाथ में लेने का सबसे नंगा सच है!"
                """.trimIndent(),
                english = """
                    (The Hacking of Knowledge and the Conquest of the Cosmos): "This Shloka violently declares the horrific, limitless power of the Sharabha Vidya that exists infinitely beyond the pathetic limits of human comprehension."
                    "'Yo ha vai Sharabhopanishadamadhite'—Whosoever human being merely 'Reads' (Adhite) or deeply dissects this apocalyptic 'Sharabha Upanishad'..."
                    "He is absolutely not reading a pathetic book; he is brutally shattering the exact DNA code that keeps him trapped as a biological human."
                    "'Sa sarvapaih pramuchyate'—He is instantaneously, violently 'Liberated' (Pramuchyate) from 'Every single microscopic and catastrophic sin' of his billions of past incarnations in a single microsecond!"
                    "Sin is strictly a pathetic Mental Virus, and this Upanishad is the ultimate Anti-virus that Deletes it in exactly one second."
                    "And what explicitly does he gain? 'Sa sarvan devan vetti'—He absolutely doesn't have to hunt for any God; sitting exactly where he is, he physically 'Knows/Realizes' (Vetti) 'All the Gods'!"
                    "Meaning, every single classified Secret of the cosmos and the Passwords of all deities are Automatically Downloaded directly into his biological brain."
                    "And the ultimate strike: 'Sa sarvan lokan jayati'—He absolutely does not just conquer this pathetic Earth, he ruthlessly 'Conquers' (Jayati) 'All Dimensions/Galaxies' (Sarvan Lokan) in the entire creation!"
                    "Sitting in one coordinate, using strictly the radioactive power of his pure Consciousness, he mutates into the sole Dictator of the entire universe."
                    "This is the most naked, cold-blooded truth of violently seizing absolute control over the entire Matrix while still breathing inside a biological shell!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 35,
                sanskrit = "न स भूयो जन्म मरणं पश्यति । स जीवन्मुक्तो भवति ॥",
                hindi = """
                    (जन्म-मरण का कत्ल और ज़िंदा आज़ादी): "इंसान का सबसे बड़ा डर क्या है? मरना! और मरने के बाद फिर से किसी कीचड़ में पैदा होना।"
                    "उपनिषद इस सबसे बड़े डर की गर्दन काटते हुए सबसे खौफनाक और प्रलयंकारी गारंटी देता है!"
                    "'न स भूयो जन्म मरणं पश्यति'— वह योगी इस ब्रह्मांड में दोबारा (भूयो) कभी भी 'जन्म' (पैदा होना) और 'मरणं' (मौत) का वो सड़ा हुआ तमाशा 'नहीं देखता' (न पश्यति)!"
                    "जन्म और मौत केवल इस भौतिक शरीर (Biological Shell) की होती है; योगी इस शरीर से अपने आप को इतना काट लेता है कि वह शरीर के मरने को भी अपनी मौत नहीं मानता।"
                    "उसने जन्म-मरण की उस सड़ी हुई मशीन (Matrix of Karma) को हथौड़े से तोड़कर हमेशा-हमेशा के लिए चकनाचूर कर दिया है।"
                    "उसे दोबारा किसी माँ के गर्भ में, खून और गंदगी के बीच उल्टा लटकने का घिनौना सज़ा नहीं काटना पड़ेगा।"
                    "वह समय (Time) की उस ज़ंजीर से बाहर निकल चुका है जहाँ घड़ियाँ टिक-टिक करती हैं और इंसान बूढ़ा होकर मरता है।"
                    "और वह क्या बन जाता है? 'स जीवन्मुक्तो भवति'— वह 'जीवन्मुक्त' (शरीर के ज़िंदा और साँस लेते हुए भी 100% आज़ाद) हो जाता है!"
                    "उसका दिल धड़क रहा है, लेकिन अंदर कोई इंसान नहीं बचा; वह धरती पर चलता-फिरता एक असीम, अजेय और अद्वैत 'परमेश्वर' बन चुका है।"
                    "यह मौत की छाती पर पैर रखकर अमरता (Immortality) छीन लेने का सबसे नंगा और खतरनाक विज्ञान है!"
                """.trimIndent(),
                english = """
                    (The Slaughter of Birth-Death and Living Freedom): "What is humanity's absolute greatest terror? Dying! And after dying, being bred again into some rotting biological mud."
                    "The Upanishad decapitates this supreme terror, delivering the most horrific, apocalyptic, and ironclad cosmic guarantee!"
                    "'Na sa bhuyo janma maranam pashyati'—That Yogi absolutely NEVER again (Bhuyo) 'Witnesses/Experiences' (Na pashyati) the rotting, pathetic spectacle of 'Birth' (Janma) and 'Death' (Maranam) in this cosmos!"
                    "Birth and death are explicitly restricted to this biological physical shell; the Yogi violently severs himself from this flesh so completely that he refuses to recognize the biological expiration as his own death."
                    "He has taken a sledgehammer and permanently, violently shattered the rotting machine of birth and death (Matrix of Karma) to absolute dust."
                    "He absolutely never again has to suffer the disgusting, horrific torture of hanging upside down amidst blood and filth inside a biological mother's womb."
                    "He has violently broken out of the titanium chain of Time, where clocks pathetically tick and mortals age and die."
                    "And what exactly does he mutate into? 'Sa jivanmukto bhavati'—He becomes 'Jivanmukta' (100% Absolutely, Permanently Liberated while his physical body is still breathing)!"
                    "His biological heart pounds, but absolutely zero human survives inside; he wanders the Earth as an infinite, invincible, non-dual walking 'God'."
                    "This is the most naked, lethal science of planting your boot directly on the chest of Death and violently snatching absolute Immortality!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 36,
                sanskrit = "य एवं वेद स मुक्तो भवति । ॐ शान्तिः शान्तिः शान्तिः ॥",
                hindi = """
                    (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'शरभ उपनिषद' अपनी पूरी प्रलयंकारी महिमा के साथ समाप्त होता है।"
                    "उपनिषद अपना आखिरी और सबसे खूँखार फैसला सुनाता है: 'य एवं वेद स मुक्तो भवति'!"
                    "यानी 'जो कोई भी इंसान इस परम और हिंसक सत्य को (कि विष्णु का अहंकार भी शिव ने तोड़ा था और शिव ही परमेश्वर हैं) 100% यथार्थ रूप में 'जान' (वेद) लेता है...'"
                    "किताबें पढ़ना ज्ञान नहीं है; इस सच को अपनी रगों में तेज़ाब की तरह उतार लेना ही असली 'जानना' है।"
                    "जिसने इस सत्य का विस्फोट अपने दिमाग में कर लिया, वह 'निश्चित रूप से, बिना किसी शक के, हमेशा-हमेशा के लिए माया की इस जेल से 'मुक्त' (Liberated) हो जाता है (स मुक्तो भवति)!"
                    "उस इंसान का अहंकार उसी आग में जल जाता है जिसमें नरसिंह का घमंड जला था।"
                    "वह साक्षात उस परम शून्यता (शिव) में एक परमाणु बम की तरह फटकर विलीन हो जाता है, जहाँ से कोई वापस लौटकर इंसान नहीं बनता।"
                    "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                    "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर, अद्वैत 'सत्य' (महाकाल शिव) हमेशा के लिए अजेय खड़ा है!"
                    "यह इंसान का मिटना और साक्षात भगवान का विस्फोट है; जो इस शून्यता से डर गया वह खत्म हो गया, जो इसमें कूद गया वह शिव बन गया!"
                """.trimIndent(),
                english = """
                    (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Sharabha Upanishad' achieves its absolute majestic and catastrophic completion."
                    "The Upanishad delivers its final, most bloodthirsty verdict: 'Ya evam veda sa mukto bhavati'!"
                    "Meaning, 'Whosoever human being explicitly, physically 'Knows' (Veda) this supreme, violent truth (that even Vishnu's ego was slaughtered by Shiva and Shiva alone is the Supreme God) in 100% absolute reality...'"
                    "Reading pathetic books is absolutely not knowledge; injecting this truth into your veins exactly like boiling acid is the only authentic 'Knowing'."
                    "He who detonates this truth inside his biological brain 'Undoubtedly, with a 100% ironclad guarantee, becomes flawlessly and permanently 'Liberated' (Mukto) from this prison of Maya forever (Sa mukto bhavati)!"
                    "That human's pathetic ego is incinerated in the exact same radioactive fire that burnt Narasimha's arrogance to ash."
                    "He detonates exactly like a nuclear bomb, dissolving permanently into that Supreme Void (Shiva) from which absolutely no entity ever returns to mutate back into a human."
                    "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                    "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal, Non-Dual 'Truth' (Mahakala Shiva) remains standing flawlessly invincible forever!"
                    "This is the brutal erasure of the human entity and the explicit atomic detonation of God; he who is terrified of this Void is destroyed, he who plunges into it becomes Shiva!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 37,
                sanskrit = "शरभोपनिषत्पुण्यां ब्राह्मणो यः पठेत्सदा । स शिवत्वमवाप्नोति न स भूयोऽभिजायते ॥",
                hindi = """
                    (शिवत्व की प्राप्ति और पुनर्जन्म का पूर्ण विनाश): "यह श्लोक मोक्ष की सबसे ऊँची और खौफनाक डिग्री (Degree) का ऐलान करता है— 'शिवत्व' (साक्षात शिव बन जाना)!"
                    "उपनिषद गर्जना करता है: 'शरभोपनिषत्पुण्यां ब्राह्मणो यः पठेत्सदा'— जो कोई भी 'असली ब्राह्मण' (जिसने परब्रह्म को जान लिया हो) इस परम पवित्र और प्रलयंकारी 'शरभ उपनिषद' को 'हमेशा' (सदा) पढ़ता और अपनी साँसों में जपता है..."
                    "वह केवल स्वर्ग या देवताओं के लोकों में नहीं जाता; वह इंसान सीधे सिस्टम को हैक कर लेता है!"
                    "'स शिवत्वमवाप्नोति'— वह इंसानियत की हर सड़ी हुई बाउंड्री को पार करके साक्षात 'शिवत्व' (The Absolute State of Shiva Himself) को प्राप्त कर लेता है!"
                    "यानी वह शिव का नौकर या भक्त नहीं रहता; वह खुद ही वह प्रलयंकारी 'शिव' बन जाता है जिसके पैरों में पूरी सृष्टि पड़ी है।"
                    "और जब वह खुद ही शिव बन गया, तो उसका क्या होगा? 'न स भूयोऽभिजायते'— वह इस ब्रह्मांड के कीचड़ में दोबारा (भूयो) कभी भी पैदा नहीं होता (न अभिजायते)!"
                    "पुनर्जन्म (Rebirth) केवल उन कमज़ोर कीड़ों (इंसानों) का होता है जो अपनी वासनाओं के गुलाम हैं।"
                    "लेकिन जिसने अपने अंदर शिव का न्यूक्लियर बम फोड़ लिया, उसके कर्मों का सारा सर्वर (Server) हमेशा के लिए क्रैश (Crash) हो जाता है।"
                    "यह सनातन धर्म का वह सबसे नंगा और हिंसक वादा है जिसे दुनिया का कोई भी धर्म झुठला नहीं सकता।"
                    "तुम इंसान पैदा हुए थे, लेकिन इस उपनिषद की आग में जलने के बाद तुम साक्षात भगवान बनकर बाहर आओगे!"
                """.trimIndent(),
                english = """
                    (The Attainment of Shivatva and the Absolute Annihilation of Rebirth): "This Shloka broadcasts the absolute highest, most terrifying Degree of Moksha—'Shivatva' (Literally mutating into explicit Shiva)!"
                    "The Upanishad roars: 'Sharabhopanishatpunyam brahmano yah pathetsada'—Whosoever 'Authentic Brahmin' (The Titan who has realized the Supreme Brahman) 'Constantly' (Sada) reads and fires this supremely pure, apocalyptic 'Sharabha Upanishad' in his breath..."
                    "He absolutely does not plummet into some pathetic Heaven or realms of lesser gods; that human directly Hacks the entire cosmic System!"
                    "'Sa shivatvamavapnoti'—He violently tears through every rotting boundary of humanity and literally attains 'Shivatva' (The Absolute Exact State of Shiva Himself)!"
                    "Meaning, he ceases to be a pathetic servant or devotee of Shiva; he himself mutates explicitly into that apocalyptic 'Shiva' at whose feet the entire creation lies paralyzed."
                    "And when he himself has mutated into Shiva, what exactly happens? 'Na sa bhuyo'bhijayate'—He absolutely NEVER again (Bhuyo) breeds or is 'Born' (Na abhijayate) into the rotting mud of this infinite cosmos!"
                    "Reincarnation (Rebirth) is a pathetic punishment strictly engineered for weak insects (humans) who are slaves to their biological lusts."
                    "But he who has detonated the nuclear bomb of Shiva inside his core permanently Crashes the entire Server of his Karma into absolute nothingness."
                    "This is the most naked, violent, and cold-blooded promise of Sanatana Dharma that absolutely no pathetic earthly religion can ever deny."
                    "You were spawned as a biological human, but after burning in the radioactive inferno of this Upanishad, you will explicitly emerge as the Supreme God!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 38,
                sanskrit = "न तस्य रोगो भवति न तस्य जरा भवति । स शिवेन सह मोदते इत्युपनिषत् ॥",
                hindi = """
                    (बुढ़ापे और बीमारियों का कत्ल - अजेय देवत्व): "जब इंसान 'शिवत्व' पा लेता है, तो उसके शरीर के बायोलॉजिकल नियम (Biological Laws) कैसे क्रैश (Crash) होते हैं, यह श्लोक वो खौफनाक सच बताता है।"
                    "'न तस्य रोगो भवति'— उस महायोगी के शरीर में कोई भी 'रोग' (बीमारी/Disease) कभी पैदा ही नहीं हो सकता!"
                    "कैंसर, महामारी या ब्रह्मांड का कोई भी वायरस (Virus) उसके सिस्टम (System) को हैक नहीं कर सकता, क्योंकि उसका शरीर अब हाड़-मांस का नहीं, शुद्ध कॉस्मिक ऊर्जा का बन चुका है।"
                    "'न तस्य जरा भवति'— उसके शरीर पर 'बुढ़ापा' (जरा/Aging) कभी हमला नहीं कर सकता; उसके लिए समय (Time) का पहिया हमेशा के लिए जाम (Freeze) हो चुका है!"
                    "वह समय का गुलाम नहीं, बल्कि समय का तानाशाह (Dictator) बन जाता है।"
                    "यह शरीर को अमर (Immortal) और अजेय (Invincible) बनाने का वह परम विज्ञान है जो मौत के भी पसीने छुड़ा दे।"
                    "और इस अमरता के बाद वह करता क्या है? 'स शिवेन सह मोदते'— वह साक्षात महाकाल 'शिव के साथ' (शिवेन सह) उसी परम शून्यता में डूबकर 'मस्त' (मोदते) रहता है!"
                    "वह शिव के दरबार में भीख नहीं मांगता; वह शिव के बिल्कुल बराबर बैठकर इस ब्रह्मांड के बनने और नष्ट होने का तमाशा देखता है।"
                    "यहीं पर यह अत्यंत प्रलयंकारी 'उपनिषद' (इत्युपनिषत्) अपनी अंतिम मुहर लगाता है।"
                    "यह इंसानियत को जलाकर भगवान बनाने का सबसे परफेक्ट (Perfect) और खूनी ब्लूप्रिंट (Blueprint) है!"
                """.trimIndent(),
                english = """
                    (The Slaughter of Aging and Disease - Invincible Godhood): "When a human attains 'Shivatva', this Shloka unmasks the terrifying truth of exactly how his biological laws undergo a catastrophic Crash."
                    "'Na tasya rogo bhavati'—Absolutely zero 'Disease' (Roga/Sickness) possesses the biological capability to ever breed inside the body of that colossal Yogi!"
                    "Cancer, plagues, or any horrific cosmic Virus absolutely cannot Hack his system, because his shell is no longer rotting flesh, but pure, radioactive Cosmic Energy."
                    "'Na tasya jara bhavati'—The decaying rot of 'Old Age' (Jara/Aging) can absolutely never assault his body; for him, the brutal wheel of Time has permanently Frozen solid!"
                    "He is absolutely no longer a pathetic slave to Time; he has violently mutated into the absolute Dictator of Time itself."
                    "This is the supreme, apocalyptic science of rendering the biological body Immortal and Invincible, making Death itself sweat in sheer terror."
                    "And after attaining this immortality, what exactly does he do? 'Sa Shivena saha modate'—He violently drowns in supreme bliss and 'Rejoices' (Modate) strictly 'Alongside explicit Shiva' (Shivena saha) in that Supreme Void!"
                    "He absolutely does not beg in Shiva's court; he sits flawlessly equal to Shiva, silently watching the pathetic spectacle of the universe's creation and annihilation."
                    "Right exactly here, this supremely apocalyptic 'Upanishad' (Ityupanishat) stamps its final, ironclad titanium seal."
                    "This is the absolute most Perfect, bloody, and ruthless Blueprint engineered specifically to incinerate humanity and manufacture God!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 39,
                sanskrit = "सर्ववेदान्तसारार्थं शरभोपनिषत्परम् । यः पठेच्छिवभक्तस्तु स शिवं प्राप्नुयाद् ध्रुवम् ॥",
                hindi = """
                    (वेदों का अंतिम सार और शिव को पाने की गारंटी): "यह उपनिषद कोई आम किताब नहीं है; यह पूरे सनातन धर्म के ज्ञान का 'न्यूक्लियर कोर' (Nuclear Core) है।"
                    "उपनिषद गर्जना करता है: 'सर्ववेदान्तसारार्थं'— चारों वेदों और सभी वेदांतों (उपनिषदों) का जो सबसे निचोड़ा हुआ, सबसे खौफनाक और 'परम सार' (Ultimate Essence) है..."
                    "वह केवल और केवल यही 'शरभोपनिषत्परम्' (परम शरभ उपनिषद) है!"
                    "अगर तुमने दुनिया की सारी किताबें पढ़ लीं लेकिन इसे नहीं जाना, तो तुम अभी भी अज्ञान के सबसे गहरे अंधेरे में सड़ रहे हो।"
                    "यह वह मास्टर की (Master Key) है जो ब्रह्मांड के हर ताले को एक झटके में तोड़ देती है।"
                    "'यः पठेच्छिवभक्तस्तु'— जो कोई भी खूँखार और सच्चा 'शिवभक्त' इस प्रलयंकारी ग्रंथ को अपनी साँसों में उतार कर इसे 'पढ़ता' (पठेत्) है..."
                    "'स शिवं प्राप्नुयाद् ध्रुवम्'— वह इंसान निश्चित रूप से, बिना एक मिलीमीटर के शक के, साक्षात 'शिव' को प्राप्त (प्राप्नुयाद्) कर लेता है! यह 'ध्रुवम्' (100% अटल और फिक्स/Fixed) है!"
                    "यह कोई शायद या 'हो सकता है' वाला झूठा वादा नहीं है; यह ब्रह्मांड का वह लोहे का कानून है जिसे कोई देवता या दानव बदल नहीं सकता।"
                    "जो इस उपनिषद की आग में कूदेगा, वह शिव के अलावा कुछ और बन ही नहीं सकता।"
                    "यह तुम्हारे दिमाग के सॉफ्टवेयर (Software) को शिव के ऑपरेटिंग सिस्टम (Operating System) से रिप्लेस (Replace) करने का आखिरी कोड है!"
                """.trimIndent(),
                english = """
                    (The Ultimate Essence of the Vedas and the Guarantee of Attaining Shiva): "This Upanishad is absolutely no ordinary book; it is the blazing 'Nuclear Core' of the entire knowledge of Sanatana Dharma."
                    "The Upanishad roars: 'Sarvavedantasarartham'—The absolute, most concentrated, squeezed out, terrifying 'Ultimate Essence' of all four Vedas and all Vedantas (Upanishads)..."
                    "Is strictly and exclusively this 'Sharabhopanishatparam' (The Supreme Sharabha Upanishad)!"
                    "If you have memorized every pathetic book in the world but remain ignorant of this, you are still rotting in the deepest pitch-black darkness of cosmic ignorance."
                    "This is the absolute Master Key that violently shatters every single titanium lock in the entire universe in one strike."
                    "'Yah pathecchivabhaktastu'—Whosoever ferocious and authentic 'Devotee of Shiva' injects this apocalyptic scripture into his breath and 'Reads' (Pathet) it..."
                    "'Sa Shivam prapnuyad dhruvam'—That human being undoubtedly, without a micro-millimeter of doubt, 'Attains' (Prapnuyad) explicit 'Shiva'! This is 'Dhruvam' (100% Ironclad, Immutable, and Fixed)!"
                    "This is absolutely no fake promise of 'maybe' or 'perhaps'; this is the absolute iron law of the cosmos that absolutely no god or demon possesses the capability to alter."
                    "He who plunges into the radioactive fire of this Upanishad absolutely cannot mutate into anything else but explicit Shiva."
                    "This is the final, classified Code engineered to totally Replace your pathetic human Software directly with the Operating System of Shiva!"
                """.trimIndent()
            ),
            SharabhaShloka(
                id = 40,
                sanskrit = "इत्यथर्ववेदे शरभोपनिषत् समाप्ता ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
                hindi = """
                    (अंतिम शून्यता और महा-प्रलय का समापन): "यहीं पर अथर्ववेद का यह सबसे खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'शरभ उपनिषद' पूरी तरह से समाप्त (समाप्ता) होता है।"
                    "यह ग्रंथ इंसान के दिमाग पर गिराया गया वह ब्रह्मांडीय न्यूक्लियर बम है जिसने इंसानियत, अहंकार और अज्ञान की धज्जियां उड़ा दी हैं।"
                    "नरसिंह का अहंकार कुचल दिया गया, विष्णु ने शिव की परमसत्ता स्वीकार कर ली, और शरभ (शिव) की तानाशाही पूरे असीम ब्रह्मांड में स्थापित हो गई।"
                    "जिसने इस ग्रंथ के एक-एक श्लोक को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म, सारी किताबें और सारे कर्मकांड राख के बराबर हो चुके हैं।"
                    "इस खौफनाक और हिंसक आध्यात्मिक युद्ध का 'द एंड' (The End) केवल और केवल पूर्ण और असीम शून्यता (Absolute Void) है।"
                    "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा, और कोई विचार नहीं बचा— केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                    "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा-हमेशा के लिए भस्म हो गया।"
                    "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर, अद्वैत 'सत्य' (साक्षात महाकाल शिव) हमेशा के लिए अजेय खड़ा है!"
                    "यह इंसान का पूरी तरह से मिटना और साक्षात भगवान का विस्फोट है।"
                    "जो इस शून्यता से डर गया, वह हमेशा के लिए खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए शिव बन गया!"
                """.trimIndent(),
                english = """
                    (The Final Void and the Conclusion of the Great Annihilation): "Right exactly here, this most terrifying, spine-chilling, and invincible 'Sharabha Upanishad' of the Atharva Veda achieves its absolute, catastrophic completion (Samapta)."
                    "This scripture is the literal cosmic nuclear bomb dropped directly onto the human brain, violently shredding humanity, ego, and ignorance into absolute dust."
                    "Narasimha's arrogance was brutally crushed, Vishnu executed absolute surrender to Shiva's supremacy, and the Dictatorship of Sharabha (Shiva) was permanently established across the infinite cosmos."
                    "For the Titan who has detonated every single Shloka of this text inside his Soul, every religion, every book, and every pathetic ritual on Earth has been reduced to worthless ashes."
                    "The absolute 'The End' of this terrifying and bloody spiritual warfare is strictly and exclusively total, infinite, boundless Nothingness (Absolute Void)."
                    "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic silence rules as the absolute dictator."
                    "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                    "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal, Non-Dual 'Truth' (Explicit Mahakala Shiva) remains standing flawlessly invincible forever!"
                    "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                    "He who is terrified of this Void is destroyed forever; he who violently plunges into it mutates into explicit Shiva for all eternity!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharabhaUpanishadScreen() {
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
                // Validates if the number is between 1 and 40
                if (shlokaNumber != null && shlokaNumber in 1..40) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-40)") },
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
            itemsIndexed(SharabhaUpanishad.sharabhaShlokasList) { _, shloka ->
                SharabhaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SharabhaShlokaCard(shloka: SharabhaUpanishad.SharabhaShloka) {
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