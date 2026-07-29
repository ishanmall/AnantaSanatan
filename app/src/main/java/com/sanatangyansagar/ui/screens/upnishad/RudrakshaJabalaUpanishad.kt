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

class RudrakshaJabalaUpanishad {

    // Data Model
    data class RudrakshaJabalaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val rudrakshajabalaShlokasList = listOf(
            RudrakshaJabalaShloka(
                id = 1,
                sanskrit = "अथ हैनं भुशुण्डः कालाग्निरुद्रमुपसमेत्य पप्रच्छ कथं रुद्राक्षोत्पत्तिस्तद्धारणात्किं फलमिति ।",
                hindi = """
                    (कालाग्नि रुद्र से प्रलयंकारी सवाल): "इस खौफनाक उपनिषद की शुरुआत में महर्षि भुशुण्ड सीधे उस भगवान से टकराते हैं जो ब्रह्मांड को राख करता है।"
                    "वे साक्षात 'कालाग्नि रुद्र' (महाकाल शिव का वह रूप जो प्रलय की आग धधकाता है) के सामने जाकर एक ब्रह्मांडीय रहस्य पूछते हैं।"
                    "वे गर्जना करते हैं: 'हे महाकाल! मुझे उस रहस्यमयी चीज़ का असली विज्ञान (Science) बताओ जिसे रुद्राक्ष कहते हैं!'"
                    "'कथं रुद्राक्षोत्पत्तिः'— इस रुद्राक्ष का जन्म इस ब्रह्मांड में कैसे हुआ? यह कोई साधारण बीज कैसे हो सकता है?"
                    "'तद्धारणात्किं फलमिति'— और इस बीज को अपने नश्वर शरीर पर धारण करने का वह खौफनाक और अजेय परिणाम (फल) क्या है?"
                    "भुशुण्ड जानते थे कि भगवान के गले में पड़ी कोई चीज़ केवल एक आभूषण (Jewelry) नहीं हो सकती; वह एक ब्रह्मांडीय हथियार है।"
                    "वे उस 'सोर्स कोड' (Source Code) को हैक (Hack) करना चाहते थे जिससे इंसान सीधे भगवान की ताक़त को अपने शरीर में पहन सके।"
                    "कालाग्नि रुद्र ने इस दुस्साहस को देखा और फिर ब्रह्मांड का वह सीक्रेट (Secret) खोल दिया जिसे सुनकर देवता भी काँपते हैं।"
                    "यह सवाल इंसानियत को कीड़े की औकात से उठाकर सीधे शिव के तख़्त पर बिठाने की पहली सीढ़ी है।"
                    "तैयार हो जाओ, क्योंकि अब साक्षात महाकाल अपने ही आँसुओं का वह रेडियोएक्टिव (Radioactive) सच उगलने वाले हैं!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Question to Kalagni Rudra): "At the terrifying genesis of this Upanishad, Maharishi Bhusunda directly confronts the exact God who incinerates the cosmos to ashes."
                    "He violently approaches explicit 'Kalagni Rudra' (The form of Mahakala Shiva blazing with the fire of Doomsday) to demand a cosmic secret."
                    "He roars: 'O Mahakala! Unmask the authentic science behind that highly classified object known as the Rudraksha!'"
                    "'Katham rudrakshotpattih'—How exactly was this Rudraksha spawned into the universe? How can it possibly be an ordinary biological seed?"
                    "'Taddharanatkim phalamiti'—And what is the terrifying, invincible consequence (Phala) of locking this seed onto a mortal biological shell?"
                    "Bhusunda flawlessly realized that an object draped around God's neck absolutely cannot be mere jewelry; it is a literal cosmic weapon."
                    "He demanded to Hack the exact 'Source Code' through which a human can literally wear the raw power of God on his flesh."
                    "Kalagni Rudra witnessed this colossal audacity and proceeded to rip open the secret that makes even gods tremble in sheer terror."
                    "This interrogation is the first strike in violently dragging humanity from the status of insects straight to the throne of Shiva."
                    "Brace yourself, because explicit Mahakala is about to vomit the radioactive absolute truth regarding His very own tears!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 2,
                sanskrit = "तं होवाच भगवान्कालाग्निरुद्रः । त्रिपुरवधार्थमहममीलिताक्षोऽभवम् ।",
                hindi = """
                    (त्रिपुर विनाश और महाकाल की अंधी आग): "महर्षि के उस सवाल पर साक्षात 'भगवान कालाग्नि रुद्र' ने एक खौफनाक गर्जना (तं होवाच) की।"
                    "शिव ने कहा: 'सुनो! जब अंतरिक्ष में असुरों के तीन अजेय और उड़ने वाले लोहे के शहर (त्रिपुर) ब्रह्मांड को तबाह कर रहे थे...'"
                    "'त्रिपुरवधार्थम्'— उन तीन शहरों (त्रिपुर) और उन राक्षसों का सबसे क्रूर और हिंसक वध (Slaughter) करने के लिए...'"
                    "'अहममीलिताक्षोऽभवम्'— मैंने अपनी आँखों को बिना पलक झपकाए, एक खूँखार और प्रलयंकारी लेज़र (Laser) की तरह 'खुला' (अमीलिताक्षो) रखा!"
                    "हज़ारों दिव्य वर्षों तक मेरी आँखें बंद नहीं हुईं; मेरे दिमाग का पूरा न्यूक्लियर रिएक्टर (Nuclear Reactor) ऑन (On) हो गया था।"
                    "मैं उन राक्षसों के सिस्टम (System) को हैक करने के लिए अपने भीतर करोड़ों सूर्यों की आग पैदा कर रहा था।"
                    "शिव का वह क्रोध इतना भयानक था कि उनकी आँखों की गर्मी से पूरा ब्रह्मांड पिघलने लगा था।"
                    "भगवान की आँखें कोई बायोलॉजिकल कैमरा नहीं हैं; वे वह ब्रह्मांडीय हथियार हैं जो देखने मात्र से दुनिया को राख कर सकती हैं।"
                    "यह श्लोक साबित करता है कि रुद्राक्ष शांति का नहीं, बल्कि साक्षात महाकाल के 'परम क्रोध' और 'विनाश' की भट्टी से निकला हुआ अस्त्र है!"
                    "रुद्राक्ष पहनने का मतलब है सीधे शिव के उस विनाशकारी रूप को अपने सीने पर धारण करना!"
                """.trimIndent(),
                english = """
                    (The Annihilation of Tripura and Mahakala's Blinding Fire): "Responding to that demand, the explicit 'Lord Kalagni Rudra' unleashed a terrifying cosmic roar (Tam hovacha)."
                    "Shiva roared: 'Listen! When the three invincible, flying titanium cities of the demons (Tripura) were violently obliterating the cosmos...'"
                    "'Tripuravadhartham'—Strictly to execute the most ruthless, cold-blooded Slaughter (Vadha) of those three cities and demons...'"
                    "'Ahamamilitaksho'bhavam'—I kept my eyes violently, mercilessly 'Wide Open and Unblinking' (Amilitaksho) exactly like an apocalyptic laser beam!"
                    "For thousands of divine years, my eyes absolutely refused to blink; the entire nuclear reactor of my brain was completely Switched On."
                    "I was actively detonating the fire of billions of suns directly inside my core to totally Hack and destroy their cosmic system."
                    "The apocalyptic wrath of Shiva was so catastrophically horrific that the sheer heat of His gaze began melting the universe."
                    "The eyes of God are absolutely no biological cameras; they are apocalyptic weapons capable of incinerating worlds merely by looking."
                    "This Shloka permanently proves that the Rudraksha is absolutely no symbol of peace; it is a weapon forged directly in the furnace of Mahakala's 'Absolute Wrath' and 'Destruction'!"
                    "Wearing a Rudraksha literally means draping the catastrophic, annihilating form of explicit Shiva directly onto your chest!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 3,
                sanskrit = "ममामीलिताक्षेभ्यो जलबिन्दवो भूमौ पतितास्ते रुद्राक्षा जाताः ।",
                hindi = """
                    (आँसुओं का विस्फोट और रुद्राक्ष का जन्म): "महाकाल शिव आगे वह खौफनाक सच बताते हैं जो विज्ञान (Science) की धज्जियां उड़ा दे।"
                    "'ममामीलिताक्षेभ्यो'— उन हज़ारों सालों तक बिना पलक झपकाए खुली हुई मेरी उन धधकती और प्रलयंकारी आँखों से..."
                    "'जलबिन्दवो भूमौ पतितास्'— जो खौफनाक और रेडियोएक्टिव (Radioactive) 'जल की बूँदें' (आँसू) टूटकर इस धरती (भूमौ) पर गिरीं!"
                    "वे कोई पानी के साधारण आँसू नहीं थे; वे शिव के असीम क्रोध, करुणा और ब्रह्मांडीय ऊर्जा का 100% सॉलिड (Solid) रूप थे।"
                    "'ते रुद्राक्षा जाताः'— जैसे ही वे आँसू धरती की मिट्टी से टकराए, उनमें एक भयंकर न्यूक्लियर विस्फोट हुआ और वे साक्षात 'रुद्राक्ष' बन गए!"
                    "'रुद्र' (शिव) + 'अक्ष' (आँख) = रुद्राक्ष! यानी यह बीज साक्षात भगवान शिव की 'तीसरी आँख' का ही भौतिक (Physical) अवतार है।"
                    "धरती पर उगने वाला यह कोई आम पेड़ नहीं है; यह सीधे शिव के डीएनए (DNA) और उनके नर्वस सिस्टम का हार्डवेयर (Hardware) है।"
                    "जब तुम रुद्राक्ष पहनते हो, तो तुम लकड़ी का टुकड़ा नहीं, बल्कि शिव के उन उबलते हुए आँसुओं को पहनते हो।"
                    "जिन आँसुओं ने राक्षसों के अजेय शहरों को जलाकर राख कर दिया था, वे तुम्हारे छोटे-मोटे पापों को एक सेकंड में भस्म कर देंगे।"
                    "यह इंसान के शरीर पर शिव के साक्षात हैकिंग टूल (Hacking Tool) को इंस्टॉल (Install) करने का ब्रह्मांडीय सच है!"
                """.trimIndent(),
                english = """
                    (The Detonation of Tears and the Birth of Rudraksha): "Mahakala Shiva proceeds to unveil the terrifying truth that violently shreds modern biological science to dust."
                    "'Mamamilitakshebhyo'—From those blazing, apocalyptic eyes of mine that remained violently open and unblinking for thousands of years..."
                    "'Jalabindavo bhumau patitas'—The horrific, highly radioactive 'Drops of Water' (Tears) that fractured and crashed violently onto this Earth (Bhumau)!"
                    "These were absolutely no pathetic drops of biological water; they were the 100% solid crystallization of Shiva's infinite wrath, mercy, and cosmic energy."
                    "'Te Rudraksha jatah'—The exact microsecond those tears collided with the dirt of the Earth, a nuclear detonation occurred, and they literally mutated into 'Rudrakshas'!"
                    "'Rudra' (Shiva) + 'Aksha' (Eye) = Rudraksha! Meaning this seed is the explicit physical, biological Avatar of Lord Shiva's 'Third Eye'."
                    "This is absolutely no ordinary tree growing in the mud; this is the literal biological Hardware and DNA of Shiva's own nervous system."
                    "When you wear a Rudraksha, you are absolutely not wearing a piece of wood; you are physically wearing the boiling tears of explicit Shiva."
                    "The exact tears that incinerated the invincible titanium cities of demons to ashes will brutally burn your pathetic microscopic sins to zero in one second."
                    "This is the cosmic absolute truth of physically Installing Shiva's explicit Hacking Tool directly onto the human shell!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 4,
                sanskrit = "तन्नामोच्चारणमात्रेण दशगोप्रदानफलं भवति । दर्शनात्स्पर्शनाच्चैव लक्षकोटिगुणं फलम् ।",
                hindi = """
                    (रुद्राक्ष की एटॉमिक ताक़त - नाम और स्पर्श): "उपनिषद इस रुद्राक्ष की पावर (Power) का खौफनाक गणित (Mathematics) समझाता है।"
                    "'तन्नामोच्चारणमात्रेण'— अगर कोई इंसान अपने होंठों से केवल 'रुद्राक्ष' शब्द का 'उच्चारण मात्र' (सिर्फ बोल भर दे) कर दे..."
                    "तो उसे उसी सेकंड 'दशगोप्रदानफलं भवति'— दस गायों का दान करने के बराबर का असीम और पवित्र ब्रह्मांडीय फल (Energy) मिल जाता है!"
                    "सोचो! जो केवल एक 'शब्द' बोलने से इंसान के कर्मों (Karma) के सर्वर को हैक कर ले, वह साक्षात चीज़ कितनी भयानक होगी?"
                    "और 'दर्शनात्स्पर्शनाच्चैव'— अगर तुम उस रुद्राक्ष को अपनी आँखों से 'देख' लो और अपनी त्वचा से 'छू' (स्पर्श) लो..."
                    "तो तुम्हारे शरीर के भीतर 'लक्षकोटिगुणं फलम्'— एक 'लाख करोड़ गुना' (1,000,000,000,000x) ज़्यादा ब्रह्मांडीय ऊर्जा का विस्फोट होता है!"
                    "यह कोई जादू-टोना नहीं है; यह एक ऐसा रेडियोएक्टिव प्लग (Radioactive Plug) है जिसे छूते ही शरीर की बैटरी करोड़ों वोल्ट से चार्ज हो जाती है।"
                    "तुम्हारे पापों की मशीन इस झटके (Shock) को बर्दाश्त नहीं कर पाती और जलकर राख हो जाती है।"
                    "रुद्राक्ष को छूने का मतलब है सीधे साक्षात महाकाल की त्वचा (Skin) को छू लेना।"
                    "यह शिव की वह तानाशाही ताक़त है जहाँ केवल एक बीज इंसान के करोड़ों जन्मों के अँधेरे का कत्ल कर देता है!"
                """.trimIndent(),
                english = """
                    (The Atomic Power of Rudraksha - Name and Touch): "The Upanishad violently dictates the horrific, apocalyptic Mathematics of this Rudraksha's raw Power."
                    "'Tannamoccharanamatrena'—If a human being merely uses his physical lips to strictly 'Utter the Name' of the word 'Rudraksha'..."
                    "In that exact microsecond, 'Dashagopradanaphalam bhavati'—He violently acquires the infinite, sacred cosmic merit (Energy) mathematically equivalent to donating ten cows!"
                    "Think! If merely vocalizing an acoustic 'Word' effortlessly Hacks the cosmic Server of human Karma, how catastrophically powerful is the physical object itself?"
                    "And 'Darshanatsparshanachchaiva'—If you explicitly 'See' that Rudraksha with your eyes and 'Touch' (Sparshana) it with your biological skin..."
                    "Inside your core detonates 'Lakshakotigunam phalam'—An atomic explosion of cosmic energy multiplied 'One Hundred Billion Times' (1,000,000,000,000x)!"
                    "This is absolutely no pathetic magic trick; it is a literal Radioactive Plug that, upon touch, Supercharges your biological battery with trillions of Volts."
                    "The rotting machine of your sins absolutely cannot survive this catastrophic Shock and instantly incinerates to ash."
                    "Physically touching a Rudraksha is mathematically identical to directly touching the raw, burning skin of explicit Mahakala."
                    "This is the dictatorial power of Shiva where a single biological seed executes the ruthless slaughter of billions of lifetimes of human darkness!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 5,
                sanskrit = "कण्ठे द्वात्रिंशतं बद्ध्वा शिरस्येकादशैव तु । कर्णयोः षट् षडेव स्युर्हस्तयोर्द्वादशैव तु ॥",
                hindi = """
                    (कवच की हैकिंग - शरीर पर रुद्राक्ष की कोडिंग - भाग १): "रुद्राक्ष पहनने का तरीका कोई फैशन (Fashion) नहीं है; यह अपने शरीर को शिव के अभेद्य 'कवच' (Titanium Armor) में लॉक (Lock) करने की कोडिंग (Coding) है!"
                    "उपनिषद शरीर के हर हिस्से का खौफनाक पासवर्ड (Password) बताता है।"
                    "'कण्ठे द्वात्रिंशतं बद्ध्वा'— अपने 'गले' (Neck) में ठीक 'बत्तीस' (32) रुद्राक्षों को कसकर बाँध लो (बद्ध्वा)!"
                    "गला वह जगह है जहाँ से इंसान की आवाज़ (शब्द-ब्रह्म) निकलती है; 32 रुद्राक्ष इंसान की ज़बान को शिव के मंत्र में बदल देते हैं।"
                    "'शिरस्येकादशैव तु'— अपने 'सिर' (Head) के ठीक ऊपर, जहाँ सहस्रार चक्र है, वहाँ 'ग्यारह' (11) रुद्राक्षों की चेन पहनो!"
                    "ये 11 रुद्राक्ष साक्षात 'एकादश रुद्रों' (Eleven Forms of Shiva) का एंटीना (Antenna) हैं जो सीधे अंतरिक्ष से ऊर्जा खींचते हैं।"
                    "'कर्णयोः षट् षडेव स्युर्'— अपने दोनों 'कानों' (Ears) में 'छह-छह' (6-6) रुद्राक्ष पहनो, ताकि तुम दुनिया का कचरा नहीं, बल्कि ब्रह्मांडीय नाद सुन सको।"
                    "'हस्तयोर्द्वादशैव तु'— और अपनी दोनों 'कलाइयों/हाथों' (Hands) में 'बारह-बारह' (12-12) रुद्राक्ष धारण करो!"
                    "यह शरीर के हर नाड़ी (Nerve) के एंड-पॉइंट (End-point) को ब्लॉक करके उसे शिव की ऊर्जा से सील (Seal) करने का हिंसक तरीका है।"
                    "जो इंसान इस तरह खुद को रुद्राक्ष से बाँध लेता है, उसके शरीर में मौत का कोई वायरस (Virus) घुस नहीं सकता!"
                """.trimIndent(),
                english = """
                    (Hacking the Armor - The Coding of Rudraksha on the Flesh - Part 1): "Wearing Rudrakshas is absolutely no pathetic fashion; it is the strict, explicit Coding to Lock your biological shell into Shiva's impenetrable 'Titanium Armor'!"
                    "The Upanishad unmasks the terrifying Passwords for every specific sector of the human body."
                    "'Kanthe dvatrimshatam baddhva'—Violently 'Bind and Lock' (Baddhva) exactly 'Thirty-Two' (32) Rudrakshas tightly around your 'Neck' (Kanthe)!"
                    "The throat is the biological generator of the human voice (Shabda-Brahman); 32 beads brutally mutate the human tongue into the explicit mantra of Shiva."
                    "'Shirasyekadashaiva tu'—Directly on your 'Head' (Shiras), atop the Sahasrara Chakra, wear a chain of exactly 'Eleven' (11) Rudrakshas!"
                    "These 11 beads are the literal Antennae of the 'Eleven Rudras' (Ekadasha Rudra) that violently extract radioactive energy directly from space."
                    "'Karnayoh shat shadeva syur'—Wear exactly 'Six and Six' (6-6) Rudrakshas on both your 'Ears' (Karna), to permanently deafen worldly garbage and hear strictly the Cosmic Roar."
                    "'Hastayordvadashaiva tu'—And lock exactly 'Twelve and Twelve' (12-12) Rudrakshas around both your 'Wrists/Hands' (Hastas)!"
                    "This is the ruthless, cold-blooded science of Blocking the End-points of every biological nerve and Sealing them with the raw energy of Shiva."
                    "The human who violently Binds himself with Rudraksha in this exact geometry becomes utterly impervious to the Virus of Death!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 6,
                sanskrit = "बाह्वोः षोडश षोडश शिखायामेकमेव तु । उरस्यष्टोत्तरशतं रुद्राक्षान्धारयेन्नरः ॥",
                hindi = """
                    (कवच की हैकिंग - शरीर पर रुद्राक्ष की कोडिंग - भाग २): "महाकाल का यह ब्रह्मांडीय कवच (Cosmic Armor) अभी पूरा नहीं हुआ है; शरीर के बाकी हिस्सों को भी सील (Seal) करना है।"
                    "'बाह्वोः षोडश षोडश'— अपनी दोनों 'भुजाओं/बांहों' (Arms) पर 'सोलह-सोलह' (16-16) रुद्राक्षों को बाँधो!"
                    "ये भुजाएं कर्म (Action) करने का हथियार हैं; 16 रुद्राक्ष तुम्हारे हाथों से होने वाले हर काम को भगवान का काम बना देते हैं।"
                    "'शिखायामेकमेव तु'— अपने सिर की 'शिखा' (चोटी/Crown) पर केवल 'एक' (1) परम रुद्राक्ष को स्थापित करो!"
                    "यह अकेला रुद्राक्ष तुम्हारे ब्रह्मरन्ध्र (Cosmic Gateway) का वह ताला है जो तुम्हारी चेतना को सीधे परब्रह्म से जोड़ता है।"
                    "'उरस्यष्टोत्तरशतं'— और अपने 'हृदय/सीने' (उरस) पर ठीक 'एक सौ आठ' (108) रुद्राक्षों की भयंकर माला धारण करो!"
                    "108 का नंबर ब्रह्मांड की धड़कन का कोड (Code) है; यह माला तुम्हारे दिल में बैठे अहंकार (Ego) को कुचल कर वहाँ शिव को बैठा देती है।"
                    "'रुद्राक्षान्धारयेन्नरः'— जो भी 'इंसान' (नरः) इस परफेक्ट और हिंसक कोडिंग के साथ अपने शरीर पर रुद्राक्ष पहन लेता है..."
                    "वह इंसान इंसान नहीं रहता, वह साक्षात शिव का एक 'चलता-फिरता मंदिर' (Walking Temple) बन जाता है।"
                    "यह मौत की आँखों में आँखें डालकर अपनी अमरता की गारंटी (Guarantee) पहनने का विज्ञान है!"
                """.trimIndent(),
                english = """
                    (Hacking the Armor - The Coding of Rudraksha on the Flesh - Part 2): "This Cosmic Armor of Mahakala is not yet complete; the remaining sectors of the biological shell must also be brutally Sealed."
                    "'Bahvoh shodasha shodasha'—Bind exactly 'Sixteen and Sixteen' (16-16) Rudrakshas tightly around both your 'Arms' (Bahu)!"
                    "These arms are the physical weapons of Karma (Action); 16 beads violently mutate every single action of your hands into the explicit action of God."
                    "'Shikhayamekameva tu'—Directly upon the 'Shikha' (Tuft/Crown) of your skull, install strictly 'One Single' (1) Supreme Rudraksha!"
                    "This solitary bead is the exact Titanium Padlock on your Brahmarandhra (Cosmic Gateway) that hardwires your consciousness directly to the Supreme Brahman."
                    "'Urasyashtottarashatam'—And across your 'Heart/Chest' (Uras), drape a terrifying garland of exactly 'One Hundred and Eight' (108) Rudrakshas!"
                    "The number 108 is the exact Hacking Code of the universe's heartbeat; this garland brutally crushes the Ego in your chest and installs Shiva upon it."
                    "'Rudrakshandharayennarah'—Whosoever 'Mortal Human' (Narah) locks these Rudrakshas onto his flesh with this flawless, violent coding..."
                    "He absolutely ceases to be a human; he instantaneously mutates into a 'Walking Temple' of explicit Shiva."
                    "This is the precise science of staring directly into the eyes of Death and physically wearing the Guarantee of your own Immortality!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 7,
                sanskrit = "पञ्चाक्षरेण मन्त्रेण रुद्राक्षान्धारयेत्सुधीः । तद्धारणं महापुण्यं भुक्तिमुक्तिफलप्रदम् ॥",
                hindi = """
                    (पंचाक्षर मंत्र का डायनामाइट और रुद्राक्ष की चार्जिंग): "केवल रुद्राक्ष को गले में लटका लेना काफी नहीं है; उसे एक्टिवेट (Activate) करने का एक खौफनाक पासवर्ड (Password) है।"
                    "उपनिषद चेतावनी देता है: 'पञ्चाक्षरेण मन्त्रेण रुद्राक्षान्धारयेत्सुधीः'!"
                    "जो 'सुधी' (अत्यंत बुद्धिमान और चतुर योगी) है, वह रुद्राक्ष को साक्षात शिव के 'पंचाक्षर मंत्र' (ॐ नमः शिवाय) के साथ धारण करता है!"
                    "पंचाक्षर मंत्र वह डायनामाइट (Dynamite) है जो इस सूखे बीज (रुद्राक्ष) के अंदर की न्यूक्लियर पावर (Nuclear Power) को ट्रिगर (Trigger) करता है।"
                    "बिना मंत्र के पहना गया रुद्राक्ष एक बिना गोली की बंदूक है; लेकिन 'ॐ नमः शिवाय' की आग से यह ब्रह्मांड का सबसे घातक हथियार बन जाता है।"
                    "नतीजा क्या होता है? 'तद्धारणं महापुण्यं'— इस तरह चार्ज (Charge) करके रुद्राक्ष पहनने से ऐसा 'महापुण्य' पैदा होता है जो इंसान के सारे पापों को जला डाले।"
                    "और 'भुक्तिमुक्तिफलप्रदम्'— यह दुनिया की सारी ताक़त, पैसा और ऐश्वर्य (भुक्ति) भी तुम्हारे कदमों में फेंक देता है..."
                    "और अंत में तुम्हें माया की इस सड़ी हुई जेल से परम 'मुक्ति' (मोक्ष) भी 100% गारंटी के साथ दे देता है!"
                    "यह शरीर के रहते हुए ब्रह्मांड के मज़े लूटना और मरने के बाद साक्षात भगवान बन जाने का इकलौता हैक (Hack) है।"
                    "शिव का नाम और शिव का आँसू (रुद्राक्ष) जब एक साथ मिलते हैं, तो इंसान की हस्ती हमेशा के लिए मिट जाती है!"
                """.trimIndent(),
                english = """
                    (The Dynamite of the Panchakshara Mantra and Charging the Rudraksha): "Merely hanging a Rudraksha around your neck is pathetically insufficient; there is a terrifying Password to violently Activate it."
                    "The Upanishad warns: 'Panchaksharena mantrena rudrakshandharayetsudhih'!"
                    "He who is 'Sudhi' (An extremely intelligent and cunning Yogi Titan) wears the Rudrakshas strictly while firing explicit Shiva's 'Panchakshara Mantra' (Om Namah Shivaya)!"
                    "The Panchakshara Mantra is the literal Dynamite that explicitly Triggers the dormant Nuclear Power locked inside this dry biological seed."
                    "A Rudraksha worn without the mantra is an unloaded gun; but detonated with the fire of 'Om Namah Shivaya', it mutates into the most lethal weapon in the cosmos."
                    "What is the exact result? 'Taddharanam mahapunyam'—Wearing a Rudraksha Supercharged like this generates a 'Maha-Punya' (Colossal Merit) that incinerates all human sins."
                    "And 'Bhuktimuktiphalapradam'—It violently throws every ounce of cosmic power, wealth, and worldly enjoyment (Bhukti) directly at your boots..."
                    "And ultimately grants you absolute, 100% guaranteed 'Liberation' (Mukti) from this rotting maximum-security prison of Maya!"
                    "This is the sole, undisputed Hack to mercilessly loot the universe while breathing, and violently mutate into God after death."
                    "When the Name of Shiva and the Tear of Shiva (Rudraksha) collide, the existence of the mortal human is completely, permanently erased!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 8,
                sanskrit = "रुद्राक्षधारणं पुण्यं यः करोति दिने दिने । स रुद्राक्षप्रभावेण रुद्र एव न संशयः ॥",
                hindi = """
                    (इंसान का साक्षात शिव बनना - ब्रह्मांड का सबसे नंगा सच): "यह श्लोक सनातन धर्म का वह सबसे खतरनाक और प्रलयंकारी वादा है जिसे सुनकर देवताओं के भी पसीने छूट जाएं!"
                    "'रुद्राक्षधारणं पुण्यं यः करोति दिने दिने'— जो भी इंसान अपने शरीर पर इस पवित्र रुद्राक्ष को 'हर रोज़' (दिने दिने) धारण करता है..."
                    "जो शिव के इन आँसुओं को अपने सीने से कभी अलग नहीं होने देता, और अपनी त्वचा को उस रेडियोएक्टिव आग से जलाता रहता है..."
                    "उसका क्या होता है? 'स रुद्राक्षप्रभावेण'— उस रुद्राक्ष के खौफनाक और ब्रह्मांडीय 'प्रभाव' (Power/Radiation) से वह इंसान..."
                    "'रुद्र एव'— वह केवल इंसान या देवता नहीं रहता, वह साक्षात महाकाल 'रुद्र' (शिव) ही बन जाता है!"
                    "'न संशयः'— इस बात में एक सेकंड के करोड़वें हिस्से का भी कोई 'शक' (Doubt) नहीं है!"
                    "यह कोई अलंकार (Metaphor) नहीं है; यह एक बायोलॉजिकल इंसान का म्यूटेशन (Mutation) होकर 100% भगवान बन जाने का विज्ञान है।"
                    "जब तुम शिव का हिस्सा (रुद्राक्ष) अपने ऊपर पहनते हो, तो शिव का ऑपरेटिंग सिस्टम (Operating System) तुम्हारे दिमाग को हैक कर लेता है।"
                    "तुम्हारा अहंकार मर जाता है, तुम्हारी कमज़ोरी मर जाती है, और तुम एक चलते-फिरते ब्रह्मांडीय तानाशाह (Dictator) बन जाते हो।"
                    "जो इंसान रुद्राक्ष पहनकर शिव बन गया, उसे अब दुनिया का कोई यमराज या कोई नियम छू भी नहीं सकता!"
                """.trimIndent(),
                english = """
                    (The Human Mutating into Explicit Shiva - The Most Naked Truth): "This Shloka is the most dangerous, apocalyptic promise of Sanatana Dharma, hearing which even the gods sweat in sheer terror!"
                    "'Rudrakshadharanam punyam yah karoti dine dine'—Whosoever human being wears this sacred Rudraksha on his biological shell 'Every single day' (Dine dine)..."
                    "He who never allows these tears of Shiva to separate from his chest, constantly burning his skin with its radioactive fire..."
                    "What exactly happens to him? 'Sa rudrakshaprabhavena'—Through the horrific, cosmic 'Impact' (Prabhava/Radiation) of that exact Rudraksha, that human..."
                    "'Rudra eva'—He absolutely ceases to be a human or a demigod; he explicitly and literally mutates into Mahakala 'Rudra' (Shiva) Himself!"
                    "'Na samshayah'—There is absolutely 'ZERO Doubt' (Na samshayah) regarding this in a billionth of a microsecond!"
                    "This is absolutely no pathetic metaphor; it is the cold-blooded science of a biological human undergoing a complete Mutation into 100% God."
                    "When you wear a physical fragment of Shiva (Rudraksha), the Operating System of Shiva violently Hacks your brain."
                    "Your ego is slaughtered, your biological weakness dies, and you mutate into a walking, breathing Cosmic Dictator."
                    "The human who mutates into Shiva by wearing the Rudraksha can absolutely never be touched by the God of Death or any law of physics again!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 9,
                sanskrit = "अभक्ष्यभक्षणात्पूतो भवति । अगम्यागमनात्पूतो भवति । सर्वपापेभ्यो मुक्तो भवति ॥",
                hindi = """
                    (महापापों का क्रूर संहार और परम पवित्रता): "उपनिषद यहाँ रुद्राक्ष की उस आग का वर्णन करता है जो दुनिया के सबसे घिनौने कचरे को भी राख कर देती है।"
                    "अगर किसी इंसान ने 'अभक्ष्यभक्षणात्'— न खाने लायक सबसे गंदी और वर्जित चीज़ें खाकर अपने शरीर को नर्क बना लिया हो..."
                    "रुद्राक्ष की एक छुअन उसे एक झटके में 100% 'पवित्र' (पूतो भवति) कर देती है!"
                    "अगर किसी ने 'अगम्यागमनात्'— उन लोगों के साथ शारीरिक संबंध बनाए हों जो शास्त्रों में वर्जित (Forbidden) हैं, जो इंसानियत का सबसे बड़ा पाप है..."
                    "रुद्राक्ष की आग उस भयानक वासना के कर्म को भी जलाकर उसे 'पवित्र' (पूतो भवति) कर देती है!"
                    "और सबसे बड़ी प्रलयंकारी घोषणा: 'सर्वपापेभ्यो मुक्तो भवति'!"
                    "वह इंसान अपने पिछले करोड़ों जन्मों के 'हर एक छोटे और बड़े महापाप' (सर्वपापेभ्यो) से एक ही सेकंड में हमेशा के लिए 'आज़ाद' (मुक्तो) हो जाता है!"
                    "यह कोई माफ़ी नहीं है; यह शिव की उस असीम ज्वाला का न्याय है जो पापों के पूरे सर्वर (Server) को फॉर्मेट (Format) कर देती है।"
                    "तुम्हारे पाप कितने भी काले क्यों न हों, रुद्राक्ष की शक्ति के सामने उनकी औकात एक सूखे तिनके जैसी है।"
                    "जो इस बीज को पहन लेता है, उसका पूरा पुराना वजूद (Identity) डिलीट (Delete) हो जाता है और वह शून्य से नई शुरुआत करता है!"
                """.trimIndent(),
                english = """
                    (The Ruthless Slaughter of Catastrophic Sins and Absolute Purity): "The Upanishad here describes the radioactive fire of the Rudraksha that incinerates even the most disgusting worldly garbage to ashes."
                    "If a human has committed 'Abhakshyabhakshanat'—consuming the most filthy, strictly forbidden, rotting substances, mutating his body into hell..."
                    "A single touch of the Rudraksha instantaneously incinerates that karma, rendering him 100% flawlessly 'Pure' (Puto bhavati)!"
                    "If someone has executed 'Agamyagamanat'—engaging in physical sexual relations with forbidden entities, humanity's most catastrophic sin..."
                    "The nuclear fire of the Rudraksha violently burns the karma of that horrific lust, rendering him completely 'Pure' (Puto bhavati)!"
                    "And the greatest apocalyptic declaration: 'Sarvapapebhyo mukto bhavati'!"
                    "That human is instantaneously, violently 'Liberated' (Mukto) from 'Every single microscopic and Catastrophic Sin' (Sarvapapebhyo) of his billions of past incarnations in one second!"
                    "This is absolutely no pathetic forgiveness; it is the ruthless justice of Shiva's infinite inferno that completely Formats the Server of human Karma."
                    "No matter how pitch-black your sins are, before the sheer firepower of the Rudraksha, their status is exactly equal to dry straw."
                    "He who wears this seed has his entire old Identity (Ego) permanently Deleted, rebooting his existence from absolute Zero!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 10,
                sanskrit = "यः कश्चिद्धारयेल्लोके रुद्राक्षं मनुजः शिवम् । स वन्द्यः सर्वभूतानां शिववत्पापनाशनः ॥",
                hindi = """
                    (ब्रह्मांडीय तानाशाह का रुतबा और शिव के समान पूजा): "जो इंसान रुद्राक्ष पहन लेता है, दुनिया में उसकी औकात क्या होती है? यह श्लोक वो खौफनाक सच उगल देता है।"
                    "'यः कश्चिद्धारयेल्लोके'— इस पूरी सड़ी हुई दुनिया (लोके) में जो कोई भी (यः कश्चिद्) इंसान..."
                    "'रुद्राक्षं मनुजः शिवम्'— परम कल्याणकारी और साक्षात शिव के रूप 'रुद्राक्ष' को अपने शरीर पर धारण कर लेता है..."
                    "'स वन्द्यः सर्वभूतानां'— वह इंसान नहीं रहता; वह इस ब्रह्मांड के 'सभी जीवों' (सर्वभूतानां—इंसान, देवता, राक्षस) द्वारा ज़मीन पर गिरकर 'पूजने लायक' (वन्द्यः) बन जाता है!"
                    "स्वर्ग के देवता भी उसके सामने झुकने के लिए मजबूर हो जाते हैं, क्योंकि उसके सीने पर साक्षात महाकाल का हथियार टँगा है।"
                    "और सबसे भयंकर बात: 'शिववत्पापनाशनः'— वह इंसान साक्षात 'शिव की तरह' (शिववत्) दूसरों के 'पापों का विनाश करने वाला' (पापनाशनः) बन जाता है!"
                    "यानी अब केवल उसके दर्शन करने से, या उसके आशीर्वाद देने से दूसरे इंसानों के जन्मों के पाप जलकर राख हो जाते हैं।"
                    "वह खुद एक 'तीर्थ' बन जाता है; उसका शरीर भगवान का एक चलता-फिरता न्यूक्लियर रिएक्टर (Nuclear Reactor) है।"
                    "यह रुद्राक्ष इंसान को एक कीड़े की स्थिति से उठाकर पूरे ब्रह्मांड का सुप्रीम डिक्टेटर (Supreme Dictator) बना देता है।"
                    "जो उसे नमन नहीं करता, वह अपनी ही मौत को बुलावा देता है!"
                """.trimIndent(),
                english = """
                    (The Status of the Cosmic Dictator and Worship as Explicit Shiva): "What exactly is the status of the human who wears a Rudraksha in this world? This Shloka vomits the terrifying absolute truth."
                    "'Yah kashchiddharayelloke'—Whosoever (Yah kashchid) biological entity in this rotting physical world (Loke)..."
                    "'Rudraksham manujah shivam'—Locks the supremely auspicious 'Rudraksha', the exact physical manifestation of Shiva, onto his flesh..."
                    "'Sa vandyah sarvabhutanam'—He absolutely ceases to be human; he mutates into an entity that 'Every single creature' (Sarvabhutanam—humans, gods, demons) is violently forced to fall to the dirt and 'Worship' (Vandyah)!"
                    "Even the gods of Heaven are forced to their knees before him, because the explicit weapon of Mahakala hangs directly on his chest."
                    "And the most horrific cosmic truth: 'Shivavatpapanashanah'—That human mutates into a 'Destroyer of Sins' (Papanashanah) exactly 'Like explicit Shiva Himself' (Shivavat)!"
                    "Meaning, merely by obtaining his visual sight (Darshan) or his blessing, the catastrophic sins of other mortals are instantaneously incinerated to ash."
                    "He himself mutates into a literal 'Pilgrimage site'; his biological body is a walking, breathing Nuclear Reactor of God."
                    "This Rudraksha violently drags a human from the status of an insect and mutates him into the Supreme Dictator of the entire cosmos."
                    "He who refuses to bow before him literally, physically invites his own absolute destruction!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 11,
                sanskrit = "रुद्राक्षं कण्ठदेशे तु यस्य देहं विमुञ्चति । स याति परमं स्थानं यत्र देवो महेश्वरः ॥",
                hindi = """
                    (मौत की हैकिंग और सीधा शिवलोक का टिकट): "इंसान की मौत सबसे डरावना पल होता है, लेकिन रुद्राक्ष उस मौत के सिस्टम (System) को कैसे हैक (Hack) करता है, यह सुनो।"
                    "'रुद्राक्षं कण्ठदेशे तु'— जिस किसी भी इंसान के 'गले' (कण्ठदेशे) या शरीर पर रुद्राक्ष की माला टँगी हुई है..."
                    "'यस्य देहं विमुञ्चति'— और उसी अवस्था में वह इंसान अपने इस नश्वर हाड़-मांस के 'शरीर को त्याग' (देहं विमुञ्चति) देता है (यानी मर जाता है)..."
                    "तो उसे यमराज (God of Death) या नर्क का कोई भी दूत छूने की जुर्रत नहीं कर सकता; मौत की मशीनरी क्रैश (Crash) हो जाती है!"
                    "'स याति परमं स्थानं'— वह आत्मा अंतरिक्ष को फाड़ते हुए सीधे उस 'परम स्थान' (The Supreme Cosmic Destination) की तरफ रॉकेट की तरह फायर (Fire) हो जाती है!"
                    "वह स्थान कौन सा है? 'यत्र देवो महेश्वरः'— ठीक उसी जगह, जहाँ साक्षात देवों के देव 'महेश्वर' (शिव) विराजमान हैं!"
                    "वह इंसान सीधा शिव के सामने प्रकट होता है और हमेशा-हमेशा के लिए शिवलोक (कैलाश) का मालिक बन जाता है।"
                    "चाहे उसने ज़िंदगी भर कितने भी पाप किए हों, अगर मरते वक्त उसके शरीर पर रुद्राक्ष है, तो वह सीधा भगवान में विलीन हो जाता है।"
                    "यह मौत की आँखों में धूल झोंककर अमरता (Immortality) का टिकट छीन लेने का सबसे खौफनाक और हिंसक विज्ञान है।"
                    "रुद्राक्ष वो ब्रह्मांडीय पासपोर्ट (Cosmic Passport) है जिसे देखकर मौत भी अपना रास्ता बदल लेती है!"
                """.trimIndent(),
                english = """
                    (Hacking Death and the Direct Ticket to Shivaloka): "The moment of human death is the ultimate terror, but listen to exactly how the Rudraksha violently Hacks the entire System of Death."
                    "'Rudraksham kanthadeshe tu'—Whosoever biological human possesses the garland of Rudraksha hanging strictly on his 'Neck' (Kanthadeshe) or body..."
                    "'Yasya deham vimunchati'—And in that exact state, he 'Abandons and Discards his biological flesh' (Deham vimunchati) (Meaning, he dies)..."
                    "Absolutely no messenger of Yamaraja (The God of Death) or Hell possesses the horrific audacity to even touch him; the machinery of Death undergoes a catastrophic Crash!"
                    "'Sa yati paramam sthanam'—That Soul violently tears through the fabric of space and is Fired exactly like a rocket directly to that 'Supreme Cosmic Destination' (Paramam Sthanam)!"
                    "What exact coordinate is that? 'Yatra devo Maheshvarah'—Exactly where the God of gods, explicit 'Maheshvara' (Shiva), reigns supreme!"
                    "That human materializes directly before Shiva and permanently mutates into the absolute Master of Shivaloka (Kailash) forever."
                    "No matter how many catastrophic sins he committed his entire life, if the Rudraksha touches his flesh at the microsecond of death, he dissolves directly into God."
                    "This is the most terrifying, cold-blooded science of throwing dust into the eyes of Death and violently snatching the Ticket to Absolute Immortality."
                    "The Rudraksha is the literal Cosmic Passport witnessing which even Death itself alters its trajectory in sheer terror!"
                """.trimIndent()
            ),
            RudrakshaJabalaShloka(
                id = 12,
                sanskrit = "य इमां रुद्राक्षजाबालोपनिषदमधीते स सर्वपापैः प्रमुच्यते स शिवसायुज्यमवाप्नोति न स पुनरावर्तते न स पुनरावर्तते इत्युपनिषत् ॥",
                hindi = """
                    (ब्रह्मांडीय मोक्ष की अंतिम मुहर और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक और अजेय 'रुद्राक्ष जाबाल उपनिषद' अपना सबसे प्रलयंकारी फैसला सुनाता है।"
                    "'य इमां रुद्राक्षजाबालोपनिषदमधीते'— जो कोई भी ब्रह्मांडीय योद्धा (Titan) इस परम 'रुद्राक्ष जाबाल उपनिषद' को केवल 'पढ़ता' या पढ़ता है..."
                    "वह केवल एक किताब नहीं पढ़ रहा; वह अपने दिमाग में साक्षात महाकाल के न्यूक्लियर कोड (Nuclear Code) को इंस्टॉल (Install) कर रहा है।"
                    "'स सर्वपापैः प्रमुच्यते'— वह एक ही झटके में अपने पिछले करोड़ों जन्मों के 'सभी भयंकर महापापों' से हमेशा-हमेशा के लिए 'आज़ाद' हो जाता है!"
                    "उसके कर्मों का सर्वर (Server) 100% डिलीट (Delete) होकर राख बन जाता है।"
                    "'स शिवसायुज्यमवाप्नोति'— और वह इंसान सीधे 'शिव-सायुज्य' (साक्षात शिव के शरीर और चेतना में पूरी तरह पिघल कर एक हो जाना) को प्राप्त कर लेता है!"
                    "और इसके बाद श्रुति (वेद) पूरी ताक़त से चीखकर ब्रह्मांड की सबसे बड़ी कसम खाती है: 'न स पुनरावर्तते, न स पुनरावर्तते'!"
                    "यानी, 'वह योगी इस सड़ी हुई दुनिया और कीचड़ में दोबारा कभी लौटकर (पैदा होकर) नहीं आता! वह कभी वापस नहीं आता!'"
                    "वह जन्म और मौत की इस घिनौनी मशीन (Matrix) को हथौड़े से तोड़कर साक्षात भगवान बन चुका है।"
                    "यहीं पर इंसान की हस्ती का अंतिम 'द एंड' (The End) होता है और परमेश्वर शिव का खौफनाक और अजेय सत्य हमेशा के लिए स्थापित हो जाता है (इत्युपनिषत्)!"
                """.trimIndent(),
                english = """
                    (The Final Seal of Cosmic Moksha and 'The End'): "Right exactly here, this supremely terrifying and invincible 'Rudraksha Jabala Upanishad' delivers its most apocalyptic, absolute verdict."
                    "'Ya imam Rudrakshajabalopanishadamadhite'—Whosoever cosmic warrior (Titan) merely 'Reads/Studies' (Adhite) this supreme 'Rudraksha Jabala Upanishad'..."
                    "He is absolutely not reading a pathetic book; he is violently Installing the explicit Nuclear Codes of Mahakala directly into his biological brain."
                    "'Sa sarvapaih pramuchyate'—He is instantaneously, violently 'Liberated' from 'Every single catastrophic sin' of his billions of past incarnations in a single explosion!"
                    "The Server of his biological Karma is 100% permanently Deleted and reduced to absolute ash."
                    "'Sa Shivasayujyamavapnoti'—And that human directly acquires 'Shiva-Sayujya' (The terrifying state of melting and fusing completely into the physical body and consciousness of explicit Shiva)!"
                    "And after this, the Shruti (Vedas) screams with maximum apocalyptic authority, swearing the greatest oath in the cosmos twice: 'Na sa punaravartate, Na sa punaravartate'!"
                    "Meaning, 'That Yogi absolutely NEVER EVER Returns (Reincarnates) into the rotting mud of this world! He ABSOLUTELY NEVER RETURNS!'"
                    "He has taken a sledgehammer and permanently shattered the disgusting machine of birth and death (Matrix), mutating explicitly into the Supreme God."
                    "Right here lies the absolute 'The End' of human existence, and the horrific, invincible truth of Lord Shiva is permanently established for all eternity (Ityupanishat)!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RudrakshaJabalaUpanishadScreen() {
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
                // Validates if the number is between 1 and 12
                if (shlokaNumber != null && shlokaNumber in 1..12) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-12)") },
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
            itemsIndexed(RudrakshaJabalaUpanishad.rudrakshajabalaShlokasList) { _, shloka ->
                RudrakshaJabalaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun RudrakshaJabalaShlokaCard(shloka: RudrakshaJabalaUpanishad.RudrakshaJabalaShloka) {
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