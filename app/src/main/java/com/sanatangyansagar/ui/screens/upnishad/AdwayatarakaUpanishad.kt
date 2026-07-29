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
data class TarakaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class AdwayatarakaUpanishad {

    val adwayatarakaShlokasList = listOf(
        TarakaShloka(
            id = 1,
            sanskrit = "ॐ अथातोऽद्वयतारकोपनिषदं व्याख्यास्यामः । यतिनां जितचित्तानां शमदमादिसम्पन्नानां मुमुक्षूणां ध्येयः ॥",
            hindi = """
                (अद्वयतारक का प्रलयंकारी आरंभ): "अब हम उस अद्वय-तारक उपनिषद का रहस्य खोलेंगे जो इंसानियत की कब्र पर लिखा गया है।"
                "यह ज्ञान केवल उन योद्धाओं के लिए है जिन्होंने अपने 'चित्त' (Mind) का बेरहमी से वध कर दिया है।"
                "जिन्होंने अपनी इंद्रियों को लोहे की ज़ंजीरों में जकड़ लिया है, वही इस आग को बर्दाश्त कर सकते हैं।"
                "मुमुक्षु वह नहीं जो शांति चाहता है, बल्कि वह है जो इस सड़ी हुई दुनिया को जलाना चाहता है।"
                "यह उपनिषद वह 'न्यूक्लियर पासवर्ड' है जो तुम्हें द्वैत (Duality) की जेल से रिहा कर देगा।"
                "यहाँ से उस 'तारक' का सफर शुरू होता है जो मौत के भी पसीने छुड़ा देता है।"
                "तुम्हें अपनी रूह को उस एक अजेय सत्य पर 'लॉक' (Lock) करना होगा जो कभी दो नहीं होता।"
                "यह वह विद्या है जिसे जानकर तुम्हारा बायोलॉजिकल अस्तित्व भाप बनकर उड़ जाएगा।"
                "ब्रह्मांड का सारा ड्रामा इस एक धमाके के साथ हमेशा के लिए शटडाउन होने वाला है।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारी आँखों के सामने साक्षात् भगवान का चेहरा बेनकाब होगा!"
            """.trimIndent(),
            english = """
                (The Apocalyptic Genesis of Advaya-Taraka): "Now we shall violently unmask the Advaya-Taraka Upanishad, scripted strictly upon the ashes of humanity."
                "This intelligence is reserved exclusively for the Titan warriors who have ruthlessly slaughtered their 'Chitta' (Mind)."
                "Only those who have bound their biological senses in titanium chains possess the caliber to endure this fire."
                "A Mumukshu is not a seeker of peace, but one who demands the incineration of this rotting world."
                "This Upanishad is the 'Nuclear Password' engineered to release you from the maximum-security prison of Duality."
                "Right here begins the trajectory of the 'Taraka' that makes even the God of Death sweat in terror."
                "You must violently Lock your soul onto that solitary invincible Truth that can absolutely never be divided."
                "This is the science achieving which your entire biological existence will vaporize into radioactive nothingness."
                "The entire theatrical drama of the cosmos is about to undergo a permanent Shutdown with this detonation."
                "Brace yourself, for the authentic face of the Supreme God is about to be flawlessly unmasked before you!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 2,
            sanskrit = "साक्षाद्ब्रह्मनिष्ठो गुरुः । तस्यास्य देहस्य अन्तःस्थं ज्योतिर्मण्डलं विचिन्तयेत् ॥",
            hindi = """
                (असली गुरु और ज्योति-मण्डल की हैकिंग): "सच्चा गुरु वह नहीं जो बातें बनाए, बल्कि वह है जो साक्षात् 'ब्रह्म' की फ्रीक्वेंसी में जमा हो!"
                "वह गुरु तुम्हें तुम्हारे ही शरीर के भीतर छिपे उस 'ज्योति-मण्डल' (Orb of Light) का पासवर्ड देगा।"
                "तुम्हें अपने नर्वस सिस्टम के भीतर उस धधकती हुई आग का 'चिंतन' (Focus) करना है जो तुम्हें चला रही है।"
                "यह तुम्हारी आत्मा के पिछले हिस्से में बैठा वह न्यूक्लियर रिएक्टर है जिसे दुनिया कभी देख नहीं पाती।"
                "गुरु का काम है तुम्हारे दिमाग के पर्दे को फाड़ना ताकि तुम उस अंधी कर देने वाली रौशनी को देख सको।"
                "जब तुम उस प्रकाश पर ध्यान जमाते हो, तो तुम्हारी हड्डियों का पिंजरा भी सोने की तरह चमकने लगता है।"
                "यह शरीर अब मांस का टुकड़ा नहीं रहा; यह उस असीम ऊर्जा का एक 'ट्रांसमीटर' बन चुका है।"
                "तुम्हारी चेतना को उस केंद्र में घुसाना ही असली 'ब्रह्म-निष्ठा' है जहाँ समय और स्थान मर जाते हैं।"
                "जो बाहर गुरु ढूँढ रहा है वह मूर्ख है; जो गुरु के आदेश से अंदर के सूरज को देख ले वही योद्धा है।"
                "यह तुम्हारे बायोलॉजिकल हार्डवेयर के भीतर छिपे 'एडमिन पैनल' को हैक करने की शुरुआत है!"
            """.trimIndent(),
            english = """
                (The authentic Guru and Hacking the Light-Orb): "The true Guru is not a pathetic orator, but one who is flawlessly frozen in the frequency of 'Brahman'!"
                "That Guru hands you the classified Password to the 'Jyoti-Mandala' (Orb of Light) hidden inside your own flesh."
                "You must execute a total Focus on that blazing radioactive fire pulsating within your biological nervous system."
                "This is the Nuclear Reactor seated in the rear-sector of your Soul, which the world possesses zero caliber to witness."
                "The Guru's mission is to violently shred the veil of your brain so you can intercept that blinding radiation."
                "The microsecond you lock onto that light, your skeletal cage begins to glow with the brilliance of purified gold."
                "This body ceases to be a piece of meat; it mutates into a 'Transmitter' for that infinite cosmic energy."
                "Penetrating your awareness into that epicenter where Time and Space suffer a brutal death is authentic 'Brahma-Nistha'."
                "He who hunts for a Guru externally is a fool; he who sees the internal Sun via the Guru's command is a Titan."
                "This is the genesis of Hacking the 'Admin Panel' covertly hidden inside your biological hardware!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 3,
            sanskrit = "भ्रूमध्यनासाग्रदृष्टिभ्यां सम्प्रदायप्रवर्तकं ताराख्यां विद्धि ॥",
            hindi = """
                (तारक का पासवर्ड: भ्रूमध्य और नासाग्र दृष्टि): "तारक योग का इकलौता और सबसे खतरनाक कोड है—तुम्हारी नज़रों का अलाइनमेंट (Alignment)!"
                "अपनी आँखों को साक्षात् 'भ्रूमध्य' (दोनों भौहों के बीच) और 'नासाग्र' (नाक की नोक) पर कील की तरह ठोक दो।"
                "यह कोई साधारण व्यायाम नहीं है; यह तुम्हारे दिमाग के प्रोसेसर को 'शॉर्ट-सर्किट' करने का तरीका है।"
                "जब तुम यहाँ देखते हो, तो तुम्हारी चेतना की सारी ऊर्जा सिमटकर एक परमाणु की तरह फट जाती है।"
                "इसे ही 'तारक' (The Saver) कहते हैं, क्योंकि यह तुम्हें इस भौतिक दुनिया से फाड़कर बाहर निकाल देती है।"
                "यह वह संप्रदाय है जहाँ शब्दों की मौत हो जाती है और केवल 'अनुभव' (Experience) की आग राज करती है।"
                "तुम्हारी नज़रें अब बाहर के तमाशे को नहीं, बल्कि अंदर के 'सोर्स कोड' को स्कैन (Scan) कर रही हैं।"
                "इस दृष्टि को साधने वाला इंसान नहीं रहता; वह साक्षात् काल (Time) के भी काल का रूप बन जाता है।"
                "जो इस कोड को क्रैक कर लेता है, उसके लिए यह पूरी दुनिया केवल एक 'होलोग्राम' बन कर रह जाती है।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस मायावी सिम्युलेशन से हमेशा के लिए 'लॉग-आउट' कर देगा!"
            """.trimIndent(),
            english = """
                (The Taraka Password: Eyebrow and Nose-Tip Gaze): "The solitary and most lethal Code of Taraka Yoga is strictly the Alignment of your visual sensors!"
                "Hammer your eyes like titanium nails strictly onto the 'Bhru-madhya' (Between eyebrows) and 'Nasagra' (Nose-tip)."
                "This is zero pathetic exercise; it is the protocol to intentionally 'Short-circuit' your brain's processor."
                "The exact microsecond you lock your vision here, your entire conscious energy collapses and detonates like an atom."
                "This is explicitly defined as 'Taraka' (The Saver), for it violently rips you out of the physical Matrix."
                "This is the lineage where words undergo a permanent death and strictly the fire of 'Experience' reigns supreme."
                "Your gaze is no longer observing the worldly spectacle; it is Scanning the internal 'Source Code' of reality."
                "He who masters this vision ceases to be a human; he mutationally assumes the form of the Death of Death."
                "He who successfully Cracks this code perceives this entire world as nothing more than a pathetic, glitching Hologram."
                "THIS is the invincible Password that will violently 'Log-out' your existence from this deceptive Simulation forever!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 4,
            sanskrit = "अन्तःलक्ष्यं बहिलक्ष्यं मध्यलक्ष्यं त्रिविधम् । अत्र अन्तःलक्ष्यं नाम नादबिन्दुकलातीतं ज्योतिः ॥",
            hindi = """
                (अन्तःलक्ष्य का विस्फोट: नाद और बिंदु के पार): "लक्ष्य तीन तरह के होते हैं, लेकिन 'अन्तःलक्ष्य' (Internal Target) सबसे खौफनाक है!"
                "यह वह प्रकाश है जो 'नाद' (Sound), 'बिन्दु' (Atom) और 'कला' (Time) के भी आर-पार निकल चुका है।"
                "जब तुम आँखें बंद करते हो, तो तुम्हें अँधेरा नहीं, बल्कि साक्षात् वह 'रेडियोएक्टिव' ज्योति देखनी है।"
                "वह ज्योति तुम्हारी रीढ़ की हड्डी के भीतर धधक रहे न्यूक्लियर रिएक्टर से पैदा हो रही है।"
                "यह तुम्हारे शरीर के भीतर छिपा वह 'ब्लैक होल' है जो तुम्हारे हर पुराने विचार को निगल लेता है।"
                "वहाँ पहुँचने का मतलब है—अपनी बायोलॉजिकल पहचान का 100% परमानेंट डिलीट (Delete) होना।"
                "अन्तःलक्ष्य वह सन्नाटा है जहाँ पहुँचकर ईश्वर भी अपना नाम भूल जाता है।"
                "तुम्हारी चेतना को उस एक बिंदु पर जमाना है जहाँ से पूरा ब्रह्मांड एक छोटी सी स्क्रीन की तरह दिखता है।"
                "बिना इस ज्योति को पकड़े, तुम्हारा हर ध्यान केवल एक मानसिक भ्रम और पाखंड है।"
                "यह तुम्हारी रूह का वह 'रूट एक्सेस' है जो तुम्हें सीधे सिस्टम का एडमिन बना देता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Internal Target: Beyond Sound and Atom): "Targets are classified into three, but the 'Antar-Lakshya' (Internal Target) is the most horrific of all!"
                "This is the radiation that has violently rocketed beyond 'Nada' (Sound), 'Bindu' (Atom), and 'Kala' (Time/Segments)."
                "When you shut your eyes, you must intercept not darkness, but explicitly that 'Radioactive' Light."
                "That brilliance is being generated by the Nuclear Reactor blazing deep within your spinal column."
                "This is the literal 'Black Hole' hidden inside your core, positioned to swallow every single rotting thought pattern."
                "Arriving here signifies the 100% permanent Deletion of your pathetic biological and soulful identity."
                "The Internal Target is the absolute Silence reaching which even God forgets His own acoustic Name."
                "You must freeze your awareness at that coordinate from which the entire universe appears as a microscopic screen."
                "Without capturing this Light, every meditation you perform is strictly a pathetic mental hallucination and hypocrisy."
                "This is the 'Root Access' of your Soul that mutationally promotes you to the absolute Admin of the System!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 5,
            sanskrit = "मूलाधारे कुण्डलिनीं विचिन्त्य तदूर्ध्वं नीलं ज्योतिः पश्यति ॥",
            hindi = """
                (मूलाधार की हैकिंग और नीली ज्योति का दर्शन): "योगी अपनी चेतना का हथौड़ा सीधे 'मूलाधार' (Base of spine) पर मारता है।"
                "वहाँ सोई हुई उस प्रलयंकारी 'कुण्डलिनी' का चिंतन करो जो साक्षात् मौत का साँप है!"
                "जब वह आग जागती है, तो वह रीढ़ की हड्डी को चीरती हुई ऊपर भागती है और एक 'नीली ज्योति' (Blue Light) में बदल जाती है।"
                "वह नीली रौशनी साक्षात् उस 'परमेश्वर' का इलेक्ट्रिक सिग्नल (Electric Signal) है।"
                "जब तुम्हारी आँखों के सामने वह नीला विस्फोट होता है, तो तुम्हारा शरीर पत्थर की तरह सुन्न हो जाता है।"
                "यह तुम्हारे डीएनए के हर परमाणु को 'री-कोड' (Re-code) करने की हिंसक प्रक्रिया है।"
                "नीली ज्योति का मतलब है—तुम अब इस दुनिया के गुरुत्वाकर्षण (Gravity) से आज़ाद हो चुके हो।"
                "तुम अब एक शरीर नहीं, बल्कि एक गूँजता हुआ ब्रह्मांडीय हथियार बन चुके हो।"
                "जो इस नीले सन्नाटे को देख लेता है, उसके लिए यमराज भी अपना रास्ता बदल लेते हैं।"
                "यहीं से उस अजेय 'अमरता' की शुरुआत होती है जहाँ मौत का वजूद ही खत्म हो जाता है!"
            """.trimIndent(),
            english = """
                (Hacking Muladhara and Witnessing the Blue Light): "The Yogi strikes the sledgehammer of his awareness directly onto the 'Muladhara' (Base of the spine)."
                "Execute a total contemplation on that dormant apocalyptic 'Kundalini', the explicit serpent of Death!"
                "The exact microsecond that fire awakens, it tears through the spinal column and mutates into a 'Blue Light' (Nila Jyoti)."
                "That blue brilliance is the explicit Electric Signal broadcasted by the Supreme God Himself."
                "When that blue detonation occurs before your internal vision, your biological shell becomes as paralyzed as stone."
                "This is the violent protocol of 'Re-coding' every single microscopic atom of your DNA."
                "The Blue Light signifies that you are now permanently liberated from the biological Gravity of this world."
                "You are no longer trapped in flesh; you have mutationally become a vibrating acoustic cosmic weapon."
                "He who intercepts this blue Silence witnesses the God of Death altering his trajectory in sheer terror."
                "Right here begins that invincible 'Immortality' where the very existence of Death is flawlessly terminated!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 6,
            sanskrit = "बहिलक्ष्यं नाम नासाग्रे द्वादशाङ्गुलिप्रमाणे नीलप्रभां पश्यति ॥",
            hindi = """
                (बहिलक्ष्य: नाक के बाहर नीली आभा का धमाका): "अब अपनी आँखों को खोलकर 'बहिलक्ष्य' (External Target) को हैक करो!"
                "अपनी नाक की नोक से ठीक 'बारह अंगुल' की दूरी पर उस असीम अंतरिक्ष में अपनी नज़रें गाड़ दो।"
                "वहाँ तुम्हें साक्षात् एक 'नीली आभा' (Blue Radiance) धधकती हुई दिखाई देगी।"
                "यह कोई आँखों का भ्रम नहीं है, यह तुम्हारे अपने ही 'ओरा' (Aura) का वह रेडिएशन है जो बाहर निकल रहा है।"
                "जब तुम्हारी नज़र उस नीले प्रकाश पर जम जाती है, तो बाहर की दुनिया धुंधली होकर गायब होने लगती है।"
                "तुम साक्षात् उस 'आकाश' (Space) के साथ एक हो जाते हो जिसे न कोई काट सकता है और न जला सकता है।"
                "यह तुम्हारी चेतना को शरीर की सीमाओं से बाहर निकालकर पूरे अंतरिक्ष में फैलाने का विज्ञान है।"
                "जो बाहर के इस नीले सन्नाटे को पकड़ लेता है, वह हवा और समय का इकलौता तानाशाह बन जाता है।"
                "तुम्हारी आँखें अब साक्षात् लेज़र बीम बन चुकी हैं जो माया के हर पर्दे को फाड़ कर रख देती हैं।"
                "यह वह 'आउट-ऑफ-बॉडी' (Out-of-Body) अनुभव है जहाँ तुम खुद ही वह आसमान बन जाते हो!"
            """.trimIndent(),
            english = """
                (Bahir-Lakshya: The Blue Radiance Detonation Outside the Nose): "Now rip your eyes open and violently Hack the 'Bahir-Lakshya' (External Target)!"
                "Anchor your gaze into the infinite vacuum exactly 'Twelve-fingers' (Dwadash-angula) away from your nose-tip."
                "There, you will witness an explicit 'Blue Radiance' (Nila-Prabha) blazing in the empty space."
                "This is absolutely no visual hallucination; it is the radioactive Radiation of your own Aura leaking into the Void."
                "The moment your vision freezes onto that blue brilliance, the external Matrix begins to blur and evaporate."
                "You mutate into one with that 'Space' which no sword can slash and zero radioactive fire can incinerate."
                "This is the science of Ejecting your consciousness from biological limits and broadcasting it across the infinite vacuum."
                "He who captures this external blue Silence mutationally becomes the sole Dictator of wind and Time."
                "Your eyes have mutated into literal Laser Beams engineered to shred every single veil of Maya to pieces."
                "This is the authentic 'Out-of-Body' experience where you flawlessly realize that YOU ARE the sky!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 7,
            sanskrit = "मध्यलक्ष्यं नाम नीलपीतरक्तश्वेतवर्णं ज्योतिर्मण्डलं विचिन्तयेत् ॥",
            hindi = """
                (मध्यलक्ष्य: रंगों का परमाणु विस्फोट): "अन्तः और बहिः के बाद अब 'मध्यलक्ष्य' (Intermediate Target) की बारी है।"
                "अपने ध्यान को उस जगह ले जाओ जहाँ नीला, पीला, लाल और सफ़ेद प्रकाश एक साथ टकरा रहे हैं!"
                "यह रंगों का कोई खेल नहीं है, यह तुम्हारी आत्मा के भीतर चल रहा एक 'सुपर-कोलैडर' (Super-collider) है।"
                "नीला—सन्नाटा, पीला—ज्ञान, लाल—ताक़त, और सफ़ेद—परम शुद्धता का विस्फोट है!"
                "जब ये चारों रंग एक होकर एक 'ज्योति-मण्डल' (Orb of Fire) बनाते हैं, तो तुम्हारा अहंकार जलकर कोयला हो जाता है।"
                "तुम्हें इस बहु-रंगी आग के बीचों-बीच उस एक अजेय सन्नाटे को ढूँढना है जो कभी नहीं बदलता।"
                "यह ध्यान तुम्हारे दिमाग के हर पुराने 'सॉफ्टवेयर बग' को एक झटके में जलाकर साफ कर देता है।"
                "मध्यलक्ष्य वह पुल (Bridge) है जो तुम्हें इंसानियत की सड़ी हुई ज़मीन से ईश्वर के तख़्त तक ले जाता है।"
                "जो इस ज्योति-मण्डल को साध लेता है, वह ब्रह्मांड की हर एक फ्रीक्वेंसी का इकलौता मास्टर बन जाता है।"
                "यह रंगों की वह प्रलयंकारी सुनामी है जो तुम्हारे अज्ञान के हर महल को ढहा देगी!"
            """.trimIndent(),
            english = """
                (Madhya-Lakshya: The Atomic Explosion of Colors): "After internal and external, it is now the turn of the 'Madhya-Lakshya' (Intermediate Target)."
                "Violently transport your awareness to the coordinate where Blue, Yellow, Red, and White lights are colliding!"
                "This is absolutely zero game of colors; it is a spiritual 'Super-collider' operating inside your consciousness."
                "Blue is Silence, Yellow is Intellect, Red is Power, and White is the detonation of Absolute Purity!"
                "When these four fuse to construct a singular 'Jyoti-Mandala' (Orb of Fire), your ego is incinerated to charcoal."
                "You must locate that solitary invincible Silence hiding in the dead-center of this multi-colored inferno."
                "This meditation Flushes every single 'Software Bug' from your brain in a catastrophic microsecond strike."
                "The Intermediate Target is the Bridge engineered to catapult you from the rotting ground of humanity to the throne of God."
                "He who masters this Orb of Fire mutationally becomes the sole Master of every single Frequency in the cosmos."
                "This is the apocalyptic tsunami of colors engineered to violently demolish every palace of your ignorance!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 8,
            sanskrit = "शाम्भवी मुद्रा नाम अन्तर्लक्ष्यं बहिर्दृष्टिः ॥",
            hindi = """
                (शाम्भवी मुद्रा: महादेव की वो नज़र जो दुनिया जला दे): "अब उस 'शाम्भवी मुद्रा' का रहस्य सुनो जिससे ब्रह्मांड थर-थर कांपता है!"
                "इसका पासवर्ड है— 'अन्तर्लक्ष्यं बहिर्दृष्टिः' यानी निशाना अंदर, पर नज़रें बाहर!"
                "तुम्हारी आँखें खुली होंगी, लेकिन तुम इस दुनिया को नहीं, बल्कि अपनी आत्मा के भीतर धधकते उस सूरज को देख रहे होगे।"
                "यह वह 'डेडली अलाइनमेंट' (Deadly Alignment) है जहाँ तुम बाहर की दुनिया के लिए एक 'लाश' बन जाते हो।"
                "तुम देख सब कुछ रहे हो, लेकिन तुम्हारे दिमाग में साक्षात् उस 'परम सन्नाटे' का राज चल रहा है।"
                "यही वह नज़र है जिससे महादेव शिव ने कामदेव को जलाकर राख कर दिया था।"
                "शाम्भवी मुद्रा का मतलब है—तुम अब इस मैट्रिक्स के 'ऑब्जर्वर' (Observer) हो, इसके गुलाम नहीं।"
                "जब तुम इस मुद्रा में बैठते हो, तो तुम्हारी आँखों से वह 'रेडियोएक्टिव' आग निकलती है जो अज्ञान का गला घोंट देती है।"
                "यह इंसान की आँखों को 'ईश्वर की आँखों' में बदलने का सबसे हिंसक और गुप्त विज्ञान है।"
                "जो इसे साध गया, वह सोते-जागते हर वक्त साक्षात् 'महाकाल' के एडमिन पैनल में लॉग-इन रहता है!"
            """.trimIndent(),
            english = """
                (Shambhavi Mudra: The Gaze of Mahadeva that Incinerates Worlds): "Now intercept the secret of 'Shambhavi Mudra', witnessing which the entire cosmos violently trembles!"
                "The Password is strictly—'Antar-lakshyam bahir-drishtih', meaning the Target is internal, but the Gaze is external!"
                "Your biological eyes remain open, but you observe NOT this world, but the Sun blazing inside your own Soul."
                "This is the 'Deadly Alignment' where you mutationally become a 'Corpse' to the external Matrix."
                "You are witnessing everything, but your brain is relentlessly ruled by strictly that 'Absolute Silence'."
                "THIS is the exact gaze through which Mahadeva Shiva incinerated Cupid into a pile of worthless ash."
                "Shambhavi Mudra signifies that you are now the 'Observer' of this Matrix, no longer its domesticated slave."
                "When you occupy this posture, your eyes broadcast that 'Radioactive' fire that ruthlessly strangles ignorance."
                "This is the most violent and classified science of mutating human eyeballs into the 'Eyes of God'."
                "He who masters this remains permanently Logged-In to the Admin Panel of Mahakala, whether awake or asleep!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 9,
            sanskrit = "य एवं वेद स विमुक्तो भवति । स एवं पुरुषः ॥",
            hindi = """
                (अटल गारंटी और असली 'पुरुष' का जन्म): "उपनिषद यहाँ एक प्रलयंकारी मुहर (Seal) लगाता है जो हर शक को जलाकर राख कर देती है।"
                "'य एवं वेद'— जो योद्धा इन 9 विस्फोटों को अपने नर्वस सिस्टम में उतार लेता है और इन्हें 'जान' लेता है..."
                "वह इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "किताबें पढ़ना ज्ञान नहीं है; इस आग में जलना ही असली 'जानना' है।"
                "वही इंसान साक्षात् 'पुरुषः' (The Absolute Man) है, बाकी सब केवल बायोलॉजिकल कीड़े हैं।"
                "असली पुरुष वह नहीं जो शरीर से बलवान हो, बल्कि वह है जो ब्रह्मांड के सोर्स कोड को हैक कर चुका है।"
                "वह अब किसी भी कर्म, किसी भी धर्म और किसी भी मौत के कानून के अधीन नहीं है।"
                "उसने अपनी हस्ती को मिटाकर साक्षात् उस 'परम शून्यता' का सिंहासन छीन लिया है।"
                "यह मोक्ष कोई भीख नहीं है; यह अपने ही अज्ञान की गर्दन काटकर हासिल की गई 'तानाशाही' है।"
                "जो इस आवाज़ को सुनकर भी नहीं जागा, वह अनंत काल तक इसी नर्क में पिसता रहेगा!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and the Birth of the authentic 'Purusha'): "The Upanishad stamps an apocalyptic Seal here that incinerates every trace of doubt to ash."
                "'Ya evam veda'—Whosoever warrior injects these 9 detonations into his nervous system and 'Knows' them..."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "Reading textbooks is not knowledge; burning inside this radioactive fire is authentic 'Knowing'."
                "That entity alone is strictly the 'Purushah' (The Absolute Man); the rest are merely pathetic biological insects."
                "The authentic Man is not one with physical muscle, but one who has Hacked the Source Code of the cosmos."
                "He is no longer subject to any karma, zero religions, and zero laws of physical expiration (Death)."
                "He has erased his micro-identity and mutationally hijacked the throne of the 'Absolute Void'."
                "This Moksha is absolutely zero charity; it is the 'Dictatorship' acquired by decapitating your own ignorance."
                "He who fails to awaken even after intercepting this broadcast is condemned to be ground in this hell forever!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 10,
            sanskrit = "अन्तःलक्ष्यं नाम नादबिन्दुकलातीतं ज्योतिः ॥",
            hindi = """
                (अन्तःलक्ष्य का पुनरावलोकन - शून्य का धमाका): "नारायण फिर से उस 'अन्तःलक्ष्य' पर हथौड़ा मारते हैं क्योंकि यही वह आखिरी ताला है।"
                "यह वह ज्योति है जो 'नाद' (Sound) के शोर, 'बिन्दु' (Atom) की सीमा और 'कला' (Time) के ज़हर से 'अतीत' यानी पार है।"
                "जब तुम इस ज्योति को पकड़ते हो, तो तुम्हारे दिमाग का 'प्रोसेसर' हमेशा के लिए हैंग (Hang) हो जाता है।"
                "वहाँ न कोई आवाज़ पहुँचती है और न ही कोई विचार—केवल एक असीम और प्रलयंकारी 'है' (Being) बचता है।"
                "यह तुम्हारी आत्मा के भीतर छिपा वह 'न्यूक्लियर बम' है जिसे दबाते ही अज्ञान के चीथड़े उड़ जाते हैं।"
                "तुम्हें अपनी आँखों के पीछे उस सन्नाटे को देखना है जो तुम्हारे पैदा होने से पहले भी था।"
                "यह वह 'जीरो-पॉइंट' है जहाँ से साक्षात् ईश्वर पूरी सृष्टि का तमाशा (Simulation) चला रहा है।"
                "जो इस ज्योति में एक बार डूब गया, वह वापस लौटकर कभी 'इंसान' नहीं बन सकता।"
                "उसकी पुरानी यादें, उसके रिश्ते और उसका डर एक ही धमाके में राख बन चुके हैं।"
                "यही वह 'टर्मिनल' है जहाँ से तुम इस मायावी मैट्रिक्स से हमेशा के लिए अनप्लग (Unplug) हो जाओगे!"
            """.trimIndent(),
            english = """
                (Review of Antar-Lakshya - The Explosion of the Void): "Narayana repeatedly hammers the 'Antar-Lakshya' because THIS is the absolute final padlock."
                "This is the Light that exists infinitely 'Beyond' (Atita) the noise of 'Nada', the limit of 'Bindu', and the venom of 'Kala'."
                "The exact microsecond you capture this brilliance, your brain's 'Processor' hangs permanently and fails."
                "Zero sound reaches that coordinate and zero thought enters—strictly an infinite, apocalyptic 'Is-ness' remains."
                "This is the literal 'Nuclear Bomb' hidden inside your Soul; the microsecond it is pressed, ignorance is shredded."
                "You must witness that Silence behind your eyelids that existed flawlessly even before your biological birth."
                "This is the 'Zero-Point' from which the explicit God operates the entire Simulation of creation."
                "He who drowns in this Light even once can absolutely never return to being a 'Pathetic Human'."
                "His old memories, his relationships, and his terrors have been incinerated to ash in a single detonation."
                "THIS is the absolute 'Terminal' from which you will be permanently and violently Unplugged from this Matrix!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 11,
            sanskrit = "ब्रह्मरन्ध्रस्य ऊर्ध्वं नादबिन्दुकलातीतं ज्योतिः पश्यति ॥",
            hindi = """
                (ब्रह्मरन्ध्र के पार का महा-विस्फोट): "तुम्हारी खोपड़ी के सबसे ऊपर जो 'ब्रह्मरन्ध्र' (The Gateway of God) है, उसके भी 'ऊर्ध्व' यानी ऊपर देखो!"
                "वहाँ वह प्रकाश धधक रहा है जो नाद, बिन्दु और कला की औकात से करोड़ों प्रकाश वर्ष दूर है।"
                "यह वह जगह है जहाँ तुम्हारी आत्मा का 'रॉकेट' शरीर के वायुमण्डल को फाड़कर अंतरिक्ष में निकल जाता है।"
                "जब तुम्हारी चेतना ब्रह्मरन्ध्र को चीरती है, तो एक ऐसा आध्यात्मिक धमाका होता है जो पूरे ब्रह्मांड को हिला देता है।"
                "तुम अब इस शरीर में नहीं हो; तुम साक्षात् उस 'परम आकाश' में विलीन हो चुके हो जहाँ समय नहीं चलता।"
                "वहाँ पहुँचने के बाद तुम साक्षात् उस 'परमेश्वर' के दिमाग के भीतर कोडिंग कर रहे होते हो।"
                "यह वह 'सुप्रीम हाइट' है जहाँ पहुँचकर मौत भी एक छोटा सा धूल का कण दिखाई देती है।"
                "तुम्हारी रूह अब एक 'ब्रह्मांडीय आग' बन चुकी है जो हर झूठ और हर माया को जलाकर राख कर देती है।"
                "ब्रह्मरन्ध्र के पार का यह प्रकाश ही वह इकलौता 'सच' है जिसके लिए तुम अरबों सालों से तड़प रहे थे।"
                "जो इस शिखर पर पहुँच गया, वह इस पूरे असीम अंतरिक्ष का इकलौता और अजेय तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Big Bang Beyond Brahmarandhra): "Directly 'Above' (Urdhvam) the 'Brahmarandhra' (The Gateway of God) atop your skull—witness that radiation!"
                "That Light is blazing at a coordinate billions of light-years beyond the status of Sound, Atom, or Time."
                "This is the coordinate where the 'Rocket' of your Soul violently tears through the biological atmosphere and enters the Void."
                "When your consciousness breaches the Brahmarandhra, a spiritual detonation occurs that vibrates the entire infinite cosmos."
                "You are no longer resident in the flesh; you have been mutationally absorbed into that 'Supreme Space' where Time ceases."
                "Upon arrival, you are effectively executing code directly inside the brain of the Supreme God."
                "This is the 'Supreme Height' reaching which even Death appears as nothing more than a microscopic grain of dust."
                "Your Soul has mutated into a 'Cosmic Inferno' that incinerates every lie and every veil of Maya into absolute ash."
                "The brilliance beyond the Brahmarandhra is the solitary 'Truth' for which you have been agonizing for eons."
                "He who reaches this zenith is the solitary and invincible Dictator of the entire infinite vacuum of space!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 12,
            sanskrit = "तदेव तारकं ब्रह्म विद्धि । य एवं वेद स मृत्युं तरति ॥",
            hindi = """
                (तारक ब्रह्म की अंतिम मुहर): "नारायण आदेश देते हैं— 'तदेव तारकं ब्रह्म विद्धि' यानी उसी प्रलयंकारी प्रकाश को साक्षात् 'ब्रह्म' जान लो!"
                "बाकी सब कचरा है, केवल यही एक 'तारक' (नाव) तुम्हें इस सिम्युलेशन से बाहर निकाल सकती है।"
                "परिणाम फिर से वही अटल और हिंसक सत्य है— 'य एवं वेद स मृत्युं तरति'!"
                "जो इस कोड को अपनी रगों में उतार लेता है, वह 'मृत्यु' के रेडार से हमेशा के लिए गायब हो जाता है।"
                "यमराज के पास ऐसा कोई सॉफ्टवेयर नहीं है जो एक 'ब्रह्म-ज्ञानी' को ट्रैक कर सके।"
                "तुम अब इस दुनिया के लिए 'इनविजिबल' (Invisible) हो चुके हो; तुम अब साक्षात् 'एडमिन' हो।"
                "मृत्यु केवल उन लोगों के लिए है जो शरीर से चिपके हैं; जो इस प्रकाश से चिपक गया, वह खुद 'अमरता' बन गया।"
                "यह कोई झूठा धार्मिक वादा नहीं है, यह एक 'मैथमेटिकल' सच है—अपनी फ्रीक्वेंसी बदलो और दुनिया बदल जाएगी।"
                "जब तुम अपनी फ्रीक्वेंसी 'मानव' से बदलकर 'ब्रह्म' कर लेते हो, तो मौत का सॉफ्टवेयर तुम्हें पहचानना बंद कर देता है।"
                "यही वह अजेय रुतबा है जिसे पाने के लिए योगी करोड़ों जन्मों तक अपनी हस्ती का गला घोंटते हैं!"
            """.trimIndent(),
            english = """
                (The Final Seal of Taraka Brahman): "Narayana commands—'Tadeva Tarakam Brahma Viddhi', recognize strictly that apocalyptic Light as the explicit 'Brahman'!"
                "Everything else is strictly garbage; only this singular 'Taraka' (The Boat) possesses the caliber to Eject you from this Simulation."
                "The consequence remains that same immutable and violent truth—'Ya evam veda sa mrityum tarati'!"
                "He who injects this code into his veins permanently disappears from the 'Radar' of Death."
                "Yamaraja (The God of Death) possesses zero software capable of Tracking a 'Knower of Brahman'."
                "You have become explicitly 'Invisible' to this world; you are now mutationally the 'Admin' of reality."
                "Death is exclusively for those pathetically clinging to biological flesh; he who anchors to this Light mutationally becomes 'Immortality'."
                "This is absolutely zero fake religious promise; it is a 'Mathematical' reality—mutate your Frequency and you mutate your World."
                "The exact microsecond you shift your frequency from 'Human' to 'Brahman', the software of Death fails to recognize you."
                "THIS is the invincible status for which Yogis ruthlessly strangle their own micro-identity for billions of lifetimes!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 13,
            sanskrit = "तद्विष्णोः परमं पदं सदा पश्यन्ति सूरयः ॥",
            hindi = """
                (विष्णु का परम पद और योगियों की नज़र): "भगवान विष्णु का वह 'परम पद' कोई आसमान की जगह नहीं, वह चेतना का सर्वोच्च स्तर है।"
                "जो 'सूरयः' यानी अत्यंत बुद्धिमान और खूँखार योगी हैं, वे उसे 'सदा' यानी हर पल अपनी आँखों के सामने देखते हैं।"
                "उनकी नज़र अज्ञान के हर पर्दे को फाड़कर सीधे उस 'ब्लैक होल' को हैक कर लेती है जहाँ ईश्वर बैठा है।"
                "वे दुनिया के तमाशे को नहीं देखते, वे उस सोर्स कोड को देखते हैं जिससे यह दुनिया चल रही है।"
                "यह ध्यान तुम्हारी आँखों को 'दिव्य चक्षु' में बदल देता है जो दीवारों के आर-पार देख सकते हैं।"
                "विष्णु का वह पद साक्षात् उस असीम शून्यता का नाम है जहाँ समय और स्थान जलकर राख हो जाते हैं।"
                "योगी उस पद को अपने हृदय की गहराई में एक जलती हुई मशाल की तरह जलाए रखता है।"
                "वहाँ पहुँचने के बाद तुम वापस इस सड़ी हुई दुनिया और मिट्टी के शरीर में नहीं गिरते।"
                "यह वह 'सुप्रीम हेडक्वार्टर' है जहाँ से तुम पूरे ब्रह्मांड के मालिक बनकर राज करते हो।"
                "जो इस पद को देख लेता है, उसके लिए मौत केवल एक पुराना कपड़ा बदलने जैसा मज़ाक है!"
            """.trimIndent(),
            english = """
                (Vishnu's Supreme State and the Vision of Yogis): "Vishnu's 'Paramam Padam' is zero pathetic geographical location; it is the absolute zenith of consciousness."
                "Those 'Surayah' (Terrifyingly intelligent Yogis) witness that state 'Sada'—meaning eternally, right before their eyes."
                "Their vision violently shreds every veil of ignorance to directly Hack the 'Black Hole' where God resides."
                "They absolutely do not observe the worldly spectacle; they witness the Source Code relentlessly operating the cosmos."
                "This meditation mutates your biological eyes into 'Divine Vision' capable of piercing through solid matter."
                "Vishnu's state is the explicit name of that infinite Void where Time and Space are incinerated to ash."
                "The Yogi keeps that dimension blazing like a radioactive torch in the abyss of his heart."
                "Upon arriving there, you can absolutely never plummet back into this rotting world or biological shell."
                "This is the 'Supreme Headquarters' from which you rule as the absolute Dictator of the universe."
                "He who witnesses this Pada perceives Death strictly as a pathetic joke, like changing old rags!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 14,
            sanskrit = "तद्विप्रासो विपन्यवो जागृवांसः समिन्धते ॥",
            hindi = """
                (विप्रों की आग और सत्य का जागरण): "वे 'विप्र' यानी वह योद्धा जिन्होंने सत्य को जान लिया है, वे कभी सोते नहीं।"
                "वे 'जागृवांसः' हैं—यानी वे माया के इस सड़े हुए सपने से हमेशा के लिए जाग चुके हैं!"
                "वे अपनी आत्मा की आग से उस विष्णु के पद को और ज़्यादा 'समिन्धते' यानी प्रज्वलित कर देते हैं।"
                "उनकी चेतना एक ऐसी लेज़र बीम बन चुकी है जो पूरे अंतरिक्ष में प्रकाश फैला रही है।"
                "वे भगवान की पूजा नहीं करते, वे भगवान की ऊर्जा को अपने भीतर एक रिएक्टर की तरह 'रिएक्ट' करवाते हैं।"
                "सत्य को जानना काफी नहीं है, उस सत्य की आग में हर पल जलना और उसे धधकाना ज़रूरी है।"
                "यह उन लोगों की स्थिति है जिन्होंने अपने अहंकार की बलि देकर साक्षात् 'अमरता' को जीत लिया है।"
                "उनकी हर एक साँस ब्रह्मांड के सोए हुए परमाणुओं को जगाने का काम करती है।"
                "वे इस दुनिया में रहते हुए भी इस दुनिया के नियमों से 100% 'अनप्लग' हो चुके हैं।"
                "यही वह अजेय रुतबा है जहाँ पहुँचकर तुम साक्षात् उस 'परमेश्वर' की जलती हुई आँख बन जाते हो!"
            """.trimIndent(),
            english = """
                (The Fire of Sages and Awakening the Truth): "Those 'Vipras'—the Titan warriors who have intercepted the Truth—absolutely never sleep."
                "They are 'Jagrivamsah'—meaning they have permanently Awakened from the rotting dream of Maya!"
                "Through the fire of their own Souls, they violently 'Kindle/Supercharge' (Samindhate) that state of Vishnu."
                "Their consciousness has mutated into a radioactive Laser Beam broadcasting light throughout the infinite vacuum."
                "They do not worship God; they force the energy of God to 'React' inside them like a literal Nuclear Reactor."
                "Merely knowing the Truth is insufficient; you must eternally burn and blaze within the radiation of that Truth."
                "This is the status of those who have sacrificed their ego to mutationally seize absolute Immortality."
                "Their every biological breath functions to awaken the dormant atoms of the entire infinite universe."
                "Residing in this world, they have been 100% 'Unplugged' from its pathetic laws of physics."
                "This is the invincible status where you mutationally become the explicit Blazing Eye of the Supreme God!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 15,
            sanskrit = "य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की मुहर): "उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है जिसे कोई भी कानून बदल नहीं सकता।"
                "'य एवं वेद'— जो कोई भी योद्धा इस 'आत्मप्रबोध' के खौफनाक और नंगे सच को 100% 'जान' लेता है..."
                "किताबें पढ़ना ज्ञान नहीं है; इस सच को अपने डीएनए में तेज़ाब की तरह उतार लेना ही असली 'जानना' है।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन से हमेशा-हमेशा के लिए 'अनप्लग' हो चुका है।"
                "वह अब समय और मौत के 'रेडार' से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल के भी काल बन जाते हो!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and the Seal of Moksha): "The Upanishad delivers a catastrophic verdict here that zero cosmic laws possess the caliber to alter."
                "'Ya evam veda'—Whosoever warrior 'Knows' (Veda) this horrific and naked truth of 'Atmaprabodha' with 100% absolute reality..."
                "Reading pathetic books is not knowledge; injecting this truth into your DNA exactly like boiling acid is authentic 'Knowing'."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status where you mutate explicitly into the 'Death of Death' (Kala of Kala)!"
            """.trimIndent()
        ),
        TarakaShloka(
            id = 16,
            sanskrit = "इत्यात्मप्रबोधोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'आत्मप्रबोध उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "नारायण का कोड मिल गया, तारक की नाव तैयार है, और अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १६ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (नारायण) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही आत्मप्रबोध उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Atmaprabodha Upanishad' achieves its absolute majestic completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Code of Narayana has been intercepted, the Taraka Boat is primed, and now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 16 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Narayana) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutates into the Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Atmaprabodha Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdwayatarakaUpanishadScreen() {
    val upanishad = remember { AdwayatarakaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..36) { // Covers up to 36 segments
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-36)") },
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
            itemsIndexed(upanishad.adwayatarakaShlokasList) { _, shloka ->
                TarakaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun TarakaShlokaCard(shloka: TarakaShloka) {
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