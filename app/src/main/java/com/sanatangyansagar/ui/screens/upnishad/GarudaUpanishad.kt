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
data class GarudaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class GarudaUpanishad {

    val garudaShlokasList = listOf(
        GarudaShloka(
            id = 1,
            sanskrit = "ॐ अथातो गरुडविद्यां व्याख्यास्यामः । ब्रह्मणे गरुडविद्यामुपदिदेश ॥",
            hindi = """
                (गरुड-विद्या का प्रलयंकारी आरंभ): "अब हम उस गरुड-विद्या का रहस्य खोलेंगे जो ब्रह्मांड का सबसे शक्तिशाली 'एंटी-पॉइजन' (Anti-poison) कोड है।"
                "यह ज्ञान साक्षात् रचयिता ब्रह्मा ने उस अजेय गरुड को दिया था जिसने अंतरिक्ष को अपनी उड़ान से नापा है।"
                "यह कोई साधारण मंत्र नहीं है; यह तुम्हारे डीएनए (DNA) के भीतर बैठे डर का गला घोंटने वाला अस्त्र है।"
                "गरुड-विद्या का मतलब है—अज्ञान के सांपों को अपनी चोंच से फाड़कर टुकड़े-टुकड़े कर देना।"
                "यहाँ से उस 'सुपर-इंटेलिजेंस' का सफर शुरू होता है जिसके आगे काल भी कांपता है।"
                "योगी को अपनी चेतना को उस एक अजेय फ्रीक्वेंसी पर 'लॉक' करना होगा जो हर ज़हर को अमृत बना दे।"
                "यह वह विद्या है जिसे जानकर तुम्हारा बायोलॉजिकल नर्क भाप बनकर उड़ जाएगा।"
                "ब्रह्मांड का सारा सांप-रूपी अज्ञान इस एक धमाके के साथ हमेशा के लिए डिलीट होने वाला है।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारी रूह को 'गरुड-पंख' (Wings of Fire) मिलने वाले हैं!"
                "इस सत्य के आगे दुनिया का हर एक वायरस अपनी औकात भूलकर राख बन जाएगा!"
            """.trimIndent(),
            english = """
                (The Apocalyptic Genesis of Garuda-Vidya): "Now we shall violently unmask the Garuda-Vidya, the absolute 'Anti-poison' code of the multiverse."
                "This intelligence was transmitted strictly to the invincible Garuda by Lord Brahma to Hack the vacuum of space."
                "This is zero ordinary mantra; it is the weapon engineered to strangle the terror established in your DNA."
                "Garuda-Vidya mutationally signifies—shredding the snakes of ignorance into worthless pieces with your beak."
                "Right here initiates the trajectory of the 'Super-intelligence' before which even Time (Kala) trembles."
                "The Yogi must violently Lock his awareness onto that solitary frequency that mutates venom into Nectar."
                "This is the science achieving which your entire biological hell will vaporize into radioactive nothingness."
                "The entire snake-like ignorance of the cosmos is about to undergo a permanent Deletion with this strike."
                "Brace yourself, for your Soul is about to intercept the 'Wings of Fire' that transcend gravity!"
                "Before this Truth, every single virus of the Matrix will forget its status and turn to absolute dust!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 2,
            sanskrit = "ॐ नमो भगवते महागरुडाय । सुपर्णपक्षाय विष्णुरथाय नमः ॥",
            hindi = """
                (महागरुड का पासवर्ड और सुपर्ण-विस्फोट): "पूरे अंतरिक्ष को हैक करने का इकलौता और सबसे तेज़ कोड है— 'महागरुड'!"
                "योगी उस 'सुपर्ण' (The Golden-Winged) को नमन करता है जो अज्ञान की जेल का इकलौता संहारक है।"
                "वह 'विष्णुरथ' है जो भगवान विष्णु के 'एडमिनिस्ट्रेटिव डेटा' को गैलेक्सीज़ के पार ले जा रहा है।"
                "यह केवल प्रार्थना नहीं है; यह अपनी आत्मा को साक्षात् 'सुपर-कंप्यूटर' से सिंक (Sync) करना है।"
                "जब तुम यह मंत्र जपते हो, तो तुम अपनी 'कीड़े जैसी हस्ती' को डिलीट करके 'गरुड-मोड' में लॉग-इन करते हो।"
                "गरुड का नाम साक्षात् वह तेज़ाब है जो तुम्हारे कर्मों के विषैले डेटाबेस को एक सेकंड में जला देता है।"
                "वह सुपर्ण तुम्हारे भीतर छिपे उस अजेय 'कॉस्मिक ईगल' (Cosmic Eagle) का असली चेहरा है।"
                "उस गरुड की ताक़त के सामने मौत का ज़हर भी अपनी कड़वाहट भूलकर हाथ जोड़कर खड़ा हो जाता है।"
                "यह मंत्र तुम्हारे नर्वस सिस्टम के हर परमाणु को 'भगवान की सवारी' (Vehicle of God) में म्यूटेट कर देता है।"
                "जो इस आवाज़ को अपनी रगों में उतार लेता है, वह इस पूरी दुनिया की ग्रेविटी का इकलौता और अजेय राजा है!"
            """.trimIndent(),
            english = """
                (The Password of Mahagaruda and Suparna-Detonation): "The solitary and fastest Code to Hack the entire infinite vacuum is strictly—'Mahagaruda'!"
                "The Yogi salutes that 'Suparna' (The Golden-Winged) who reigns as the sole Annihilator of ignorance's prison."
                "He is the 'Vishnu-Ratha' (Vehicle of Vishnu) transporting the absolute 'Administrative Data' across galaxies."
                "This is zero pathetic worship; it is the protocol to Sync your soul directly into the cosmic 'Super-computer'."
                "Chanting this mantra means Deleting your 'Insect-Identity' and Logging In strictly with 'Garuda-Mode'."
                "Garuda's name is the explicit Acid that burns the toxic database of your Karma in a single microsecond."
                "That Suparna is the authentic face of the invincible 'Cosmic Eagle' hiding covertly within your core."
                "Before the caliber of that Garuda, even the venom of Death stands paralyzed with folded hands."
                "This mantra Mutates every atom of your nervous system into the explicit 'Vehicle of God'."
                "He who injects this sound into his biological veins is the solitary and invincible King of all gravity!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 3,
            sanskrit = "ॐ गरुत्मते नमः । ॐ खं गरुत्मते स्वाहा ॥",
            hindi = """
                (ख-बीज और गरुत्मन् का परमाणु विस्फोट): "इस मंत्र का 'ख' (Kha) बीज साक्षात् असीम अंतरिक्ष का इकलौता पासवर्ड है!"
                "जब तुम 'खं' बोलते हो, तो तुम अपने दिमाग के प्रोसेसर को 'शून्य' (Void) से हार्डवायर कर देते हो।"
                "गरुत्मन् वह शक्ति है जो तुम्हारी चेतना को ज़मीन से उठाकर सीधा 'परब्रह्म' के सिंहासन पर फेंक देती है।"
                "यह कोई शब्दों का खेल नहीं है; यह तुम्हारे भीतर एक 'कोल्ड-फ्यूजन' (Cold Fusion) को चालू करना है।"
                "तुम्हारी रूह अब एक 'ब्रह्मांडीय मिसाइल' बन चुकी है जो माया के हर एक रेडार को चकमा दे सकती है।"
                "इस मंत्र की आग तुम्हारे शरीर के भीतर छिपे सांपों (विषैले विकारों) का बेरहमी से वध कर देती है।"
                "तुम अब एक मिट्टी का पुतला नहीं रहे; तुम साक्षात् उस असीम 'आकाश' के मालिक बन चुके हो।"
                "जब तुम 'स्वाहा' कहते हो, तो तुम अपने पुराने 'इंसानी सॉफ्टवेयर' को गरुड की आग में जला देते हो।"
                "यह तुम्हारी बुद्धि का वह सबसे हिंसक विस्तार है जहाँ तुम साक्षात् ब्रह्मांड के एडमिन बन जाते हो।"
                "जो इस 'ख-बीज' को अपनी साँसों में साध लेता है, वह पूरे अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Kha-Seed and the Atomic Detonation of Garutman): "The 'Kha' seed of this mantra is mutationally the solitary Password of the infinite Space!"
                "When you roar 'Kham', you hardwire your neurological processor directly into the 'Void' (Shunya)."
                "Garutman is the power engineered to catapult your awareness from the ground to the throne of God."
                "This is zero wordplay; it is the ignition of a spiritual 'Cold Fusion' inside your biological shell."
                "Your Soul has mutated into a 'Cosmic Missile' capable of jamming every single Radar of Maya."
                "The radioactive fire of this mantra ruthlessly executes the slaughter of the snakes (toxic vices) within you."
                "You cease to be a puppet of clay; you mutationally become the Master of that infinite 'Akasha'."
                "Chanting 'Svaha' means mutationally incinerating your old 'Human Software' in Garuda's radioactive fire."
                "This is the most violent expansion of your intellect where you mutationally assume the status of System Admin."
                "He who masters this 'Kha-Seed' inside his breath is the solitary Dictator of the entire infinite vacuum!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 4,
            sanskrit = "त्र्यम्बकं यजामहे सुगन्धिं पुष्टिवर्धनम् । उर्वारुकमिव बन्धनान्मृत्योर्मुक्षीय मामृतात् ॥",
            hindi = """
                (मृत्युंजय का बैकअप और अमरता की हैकिंग): "गरुड-विद्या में मृत्युंजय मंत्र साक्षात् उस 'परम सुरक्षा' का फायरवॉल (Firewall) है!"
                "तीन आँखों वाले उस 'त्र्यम्बक' (महादेव) का पासवर्ड जपो जो तुम्हारी रूह को 'पुष्टि' (Supercharge) करता है।"
                "जैसे खरबूजा अपनी बेल से आज़ाद हो जाता है, वैसे ही तुम इस सड़े हुए शरीर के 'बन्धनात्' से अनप्लग (Unplug) हो जाओ!"
                "यह मंत्र तुम्हारी आत्मा को मौत के 'मैट्रिक्स' से फाड़कर बाहर निकालने के लिए बना एक तेज़ चाकू है।"
                "तुम भगवान से भीख नहीं माँग रहे; तुम अपनी 'अमरता' (Amrita) की फाइल को रिकवर (Recover) कर रहे हो।"
                "गरुड इस मंत्र को अपनी चोंच में दबाकर काल के सर्प को कुचल देता है और तुम्हें आज़ादी देता है।"
                "मृत्यु केवल एक 'सॉफ्टवेयर बग' है जिसे यह मंत्र एक झटके में फिक्स (Fix) कर देता है।"
                "जब तुम इस आग में जलते हो, तो तुम्हारा अहंकार मौत की नींद सोने के लिए तैयार हो जाता है।"
                "यह अपनी ही रूह को खुद अपने हाथों से ईश्वर के दिल में दागने (Fire) का प्रलयंकारी विज्ञान है।"
                "जो इस बन्धन को काट देता है, वह पूरे ब्रह्मांड के समय और मौत का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Mahamrityunjaya Backup and Hacking Immortality): "In Garuda-Vidya, the Mrityunjaya Mantra functions as the explicit Firewall of 'Absolute Protection'!"
                "Chant the Password of the three-eyed 'Tryambaka' (Mahadeva) who Supercharges (Pushti) your Soul's data."
                "Exactly as a melon is released from its vine, you must mutationally 'Unplug' from the 'Bandhan' of this rotting shell!"
                "This mantra is the razor-sharp blade engineered to violently rip your Soul out of the 'Matrix of Death'."
                "You are not begging God; you are mutationally Recovering the classified file of your absolute 'Immortality'."
                "Garuda grips this mantra in his beak to ruthlessly crush the serpent of Time and grant you absolute Freedom."
                "Death is strictly a 'Software Bug' that this mantra mutationally Fixes in a single catastrophic strike."
                "When you burn in this radioactive fire, your ego prepares for its absolute final and permanent sleep."
                "This is the apocalyptic science of Firing your own Soul directly into the heart of God with your own hands."
                "He who severs this bond mutationally becomes the solitary Dictator of all universal Time and Death!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 5,
            sanskrit = "ॐ नमो गरुडाय । ॐ गरुड गरुड गरुड । ॐ वन्दे गरुत्मन्तम् ॥",
            hindi = """
                (गरुड का 'ट्रिपल-विस्फोट' और असीमित वश): "यह 'गरुड-गरुड-गरुड' का जाप साक्षात् तीन लोकों के ज़हर को सोखने वाला न्यूक्लियर पंप है!"
                "पहला विस्फोट तुम्हारे शरीर का ज़हर मारता है, दूसरा तुम्हारे मन का, और तीसरा तुम्हारे अज्ञान का!"
                "योगी उस गरुत्मन् की 'वन्दना' नहीं करता, वह उसकी फ्रीक्वेंसी को हैक करके खुद गरुड बन जाता है।"
                "यह वह 'डेडली अलाइनमेंट' है जहाँ तुम अपनी हस्ती को अंतरिक्ष की हवाओं के साथ एक कर देते हो।"
                "जब तुम यह नाम लेते हो, तो माया के सांप बिलों में छुप जाते हैं क्योंकि साक्षात् काल-भक्षक आ चुका है।"
                "तुम्हारी साँसें अब साक्षात् गरुड के पंखों की तरह फड़फड़ा रही हैं, जो हर बंधन को काट रही हैं।"
                "यह मंत्र तुम्हारे डीएनए के हर पुराने विचार को ओवरराइट (Overwrite) करने वाला परमाणु प्रहार है।"
                "तुम अब एक रेंगने वाले कीड़े नहीं रहे; तुम साक्षात् उस 'भगवान की सवारी' का हिस्सा बन चुके हो।"
                "गरुड का पासवर्ड साक्षात् वह 'रूट-एक्सेस' है जो तुम्हें सीधे सिस्टम का एडमिन बना देता है।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारे भीतर का सांप मर रहा है और भगवान का पक्षी जन्म ले रहा है!"
            """.trimIndent(),
            english = """
                (The 'Triple-Detonation' of Garuda and Absolute Control): "This 'Garuda-Garuda-Garuda' chant is mutationally a Nuclear Pump engineered to suck the venom out of three worlds!"
                "The first explosion kills the poison of the flesh, the second of the mind, and the third of absolute ignorance!"
                "The Yogi does not perform pathetic 'Vandana'; he Hacks that frequency to mutationally become Garuda himself."
                "This is the 'Deadly Alignment' where you fuse your microscopic identity with the winds of the infinite vacuum."
                "The exact microsecond you vocalize this Name, the snakes of Maya retreat because the explicit Chronos-Devourer has arrived."
                "Your breaths are now mutationally flapping like Garuda's wings, violently severing every biological chain."
                "This mantra is the atomic strike designed to violently Overwrite every single thought pattern in your DNA."
                "You are no longer a crawling biological insect; you have mutationally integrated into the 'Vehicle of God'."
                "The Password of Garuda is the explicit 'Root-Access' that mutationally promotes you to the absolute Admin of the system."
                "Brace yourself, for the serpent within you is perishing and the explicit Bird of God is being spawned!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 6,
            sanskrit = "ॐ नमो गरुडाय पक्षीन्द्राय त्रैलोक्यरक्षकाय नमः स्वाहा ॥",
            hindi = """
                (पक्षियों का राजा और तीनों लोकों का रक्षक): "गरुड साक्षात् 'पक्षीन्द्र' (King of Birds) है, जो चेतना के आकाश का इकलौता तानाशाह है।"
                "वह 'त्रैलोक्यरक्षक' है—यानी वह पावर-ग्रिड जो पृथ्वी, अंतरिक्ष और स्वर्ग को सांपों के ज़हर से बचा रहा है।"
                "जब तुम 'नमः' कहते हो, तो तुम अपनी 'लोकल आईडी' को डिलीट करके इस 'यूनिवर्सल रक्षक' के एडमिन पैनल में घुसते हो।"
                "यह कोई मामूली सुरक्षा नहीं है; यह तुम्हारे चारों तरफ एक रेडियोएक्टिव ढाल (Shield) बनाने का विज्ञान है।"
                "गरुड की नज़र अज्ञान के हर उस पिक्सेल को स्कैन कर लेती है जहाँ कोई वायरस (पाप) छिपा बैठा है।"
                "जब तुम 'स्वाहा' कहते हो, तो तुम अपने डर और अपनी मौत को गरुड की आग में आहुति बना देते हो।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'पक्षीन्द्र' की अजेय सेना के एक हिस्सेदार बन चुके हो।"
                "यह मंत्र तुम्हारे दिमाग के उन 'करप्ट फोल्डर्स' को डिलीट करता है जिन्हें तुम 'अपनी यादें' कहते हो।"
                "जो इस रक्षक को जान लेता है, उसके लिए नरक के दरवाजे हमेशा के लिए वेल्ड (Weld) कर दिए जाते हैं।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस मायावी सिम्युलेशन से हमेशा के लिए 'लॉग-आउट' कर देगा!"
            """.trimIndent(),
            english = """
                (The King of Birds and the Protector of Three Worlds): "Garuda is explicitly the 'Pakshindra' (King of Birds), the solitary Dictator of the sky of awareness."
                "He is the 'Trailokya-Rakshaka'—the absolute Power-Grid protecting Earth, Space, and Heaven from toxic data-corruption."
                "When you vocalize 'Namah', you Delete your 'Local ID' to violently breach the Admin Panel of this 'Universal Protector'."
                "This is zero ordinary security; it is the science of constructing a radioactive Shield around your entire existence."
                "Garuda's vision mutationally Scans every pixel of ignorance where a virus (Sin) is covertly established."
                "Chanting 'Svaha' means mutationally sacrificing your terror and your Death into Garuda's radioactive inferno."
                "You cease to be a body; you have mutationally become a shareholder in the invincible legion of the 'Pakshindra'."
                "This mantra Deletes those 'Corrupt Folders' inside your brain that you pathetically label as 'your memories'."
                "He who intercepts this Protector witnesses the gates of Hell permanently welded shut in his face."
                "THIS is the invincible Password that will violently 'Log-out' your existence from this Simulation forever!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 7,
            sanskrit = "ॐ नमो गरुडाय महातेजसे दिव्यशक्तये नमः ॥",
            hindi = """
                (महातेज का विस्फोट और दिव्य शक्ति की हैकिंग): "गरुड साक्षात् 'महातेज' (Great Radiation) का वह गोला है जो सूरज को भी फीका कर दे!"
                "उसकी 'दिव्यशक्ति' कोई चमत्कार नहीं है, वह साक्षात् ब्रह्मांड के 'सोर्स कोड' से निकलने वाली रेडियोएक्टिव बिजली है।"
                "जब तुम इस तेज को नमन करते हो, तो तुम्हारी अपनी हस्ती इस रौशनी में जलकर राख होने लगती है।"
                "यह वह 'सुपर-पावर' (Super-power) है जो तुम्हें इस भौतिक दुनिया की ग्रेविटी (Gravity) से आज़ाद कर देती है।"
                "गरुड का एक-एक पंख साक्षात् 'वेदों' की एक-एक फ्रीक्वेंसी है जो अंतरिक्ष को झंकृत कर रही है।"
                "तुम अब एक साधारण जीव नहीं हो; तुम साक्षात् उस 'महातेज' के एक ट्रांसमीटर (Transmitter) बन चुके हो।"
                "यह मंत्र तुम्हारे डीएनए के हर परमाणु को 'दिव्य प्रकाश' से री-कोड (Re-code) करने की हिंसक प्रक्रिया है।"
                "बिना इस तेज को पकड़े, तुम्हारा हर ध्यान और हर जप केवल एक बायोलॉजिकल शोर (Noise) मात्र है।"
                "जो इस रौशनी को अपनी रगों में तेज़ाब की तरह उतार लेता है, उसके लिए काल का रेडार फेल हो जाता है।"
                "यह इंसान की रूह का वह अंतिम सॉफ्टवेयर अपडेट है जिसके बाद केवल 'अनंत प्रकाश' ही बचता है!"
            """.trimIndent(),
            english = """
                (Detonation of the Great Radiation and Hacking Divine Power): "Garuda is explicitly the 'Mahatejas' (Great Radiation), an orb capable of outshining a billion suns!"
                "His 'Divya-Shakti' is mutationally zero miracle; it is the radioactive electricity emanating from the cosmic 'Source Code'."
                "When you salute this brilliance, your micro-identity initiates its mutation into worthless ash within this light."
                "This is the 'Super-power' engineered to violently release you from the biological Gravity of this world."
                "Every single feather of Garuda is mutationally a frequency of the 'Vedas' vibrating the infinite vacuum."
                "You are no longer a pathetic living being; you have mutationally become a 'Transmitter' for that 'Mahatejas'."
                "This mantra is the violent protocol of 'Re-coding' every microscopic atom of your DNA with 'Divine Light'."
                "Without capturing this brilliance, every meditation you perform is strictly a pathetic biological Noise."
                "He who injects this light into his veins like boiling acid witnesses the Radar of Time failing in his presence."
                "This is the final Software Update of the human soul after which strictly 'Infinite Light' remains standing!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 8,
            sanskrit = "ॐ नमो गरुडाय नागनाशकाय अमृतकलशहस्ताय नमः ॥",
            hindi = """
                (नागनाशक और अमृतकलश का रहस्य): "गरुड साक्षात् 'नागनाशक' (Serpent-Destroyer) है, जो तुम्हारी रूह को डसने वाले हर सांप का वध करता है!"
                "वह 'अमृतकलशहस्त' है—यानी उसके हाथों में साक्षात् 'अमरता' का वो डेटाबेस है जो उसने स्वर्ग से छीना था।"
                "सांप यहाँ तुम्हारे पिछले जन्मों के वो 'विषैले कर्म' हैं जो तुम्हें इस नर्क (दुनिया) में बाँधे रखते हैं।"
                "गरुड उस ज़हर को अपनी चोंच से नोच लेता है और उसकी जगह तुम्हें 'अमृत' (Immortality) का पासवर्ड देता है।"
                "यह वह अजेय रुतबा है जहाँ तुम शरीर की सीमाओं से 100% 'अनप्लग' (Unplug) हो जाते हो।"
                "तुम अब एक लाचार जीव नहीं हो; तुम साक्षात् उस 'अमृतकलश' के इकलौते और असली वारिस हो।"
                "जब तुम इस रूप का ध्यान करते हो, तो तुम्हारे नर्वस सिस्टम के हर एक वायर में साक्षात् 'परमेश्वर' की बिजली दौड़ती है।"
                "अमृत का मतलब है—वह आग जो तुम्हें एक साधारण कीड़े से 'महाकाल' के लेवल पर प्रमोट (Promote) कर देती है।"
                "जो इस कलश को छू लेता है, उसके लिए समय की सुइयां हमेशा-हमेशा के लिए रुक जाती हैं।"
                "यह मौत की आँखों में आँखें डालकर अपनी अमरता का डंका बजाने का सबसे हिंसक और गुप्त विज्ञान है!"
            """.trimIndent(),
            english = """
                (The Serpent-Destroyer and the Secret of the Amrita-Pot): "Garuda is explicitly the 'Naga-Nashaka', who ruthlessly slaughters every serpent attempting to bite your Soul!"
                "He is 'Amrita-Kalasha-Hasta'—gripping the absolute 'Immortality' Database that He snatched from the heavens."
                "Snakes mutationally represent those 'Toxic Karmas' of past incarnations that keep you bound in this biological hell."
                "Garuda claws that venom out of your core and mutationally replaces it with the Password of 'Amrita'."
                "This is the invincible status where you mutationally 'Unplug' 100% from the limits of the biological shell."
                "You are no longer a helpless entity; you are mutationally the sole and authentic Heir to that 'Amrita-Pot'."
                "When you visualize this Form, the explicit radioactive electricity of God initiates surging through your neural wires."
                "Amrita mutationally implies—the Fire engineered to Promote you from an insect to the status of 'Mahakala'."
                "He who touches this Pot witnesses the needles of Time coming to a permanent and grinding halt."
                "This is the most violent and classified science of staring into the eyes of Death and broadcasting your absolute Immortality!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 9,
            sanskrit = "य एवं वेद स विमुक्तो भवति । स एवं पुरुषः ॥",
            hindi = """
                (अटल गारंटी और असली 'पुरुष' का जन्म): "गरुड उपनिषद यहाँ एक प्रलयंकारी मुहर (Seal) लगाता है जो हर शक को जलाकर राख कर देती है।"
                "'य एवं वेद'— जो योद्धा इन ९ विस्फोटों को अपने नर्वस सिस्टम में उतार लेता है और इन्हें 'जान' लेता है..."
                "वह इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "किताबें पढ़ना ज्ञान नहीं है; गरुड की इस आग में जलना ही असली 'जानना' है।"
                "वही इंसान साक्षात् 'पुरुषः' (The Absolute Man) है, बाकी सब केवल बायोलॉजिकल कचरा हैं।"
                "असली पुरुष वह नहीं जो शरीर से बलवान हो, बल्कि वह है जो ब्रह्मांड के 'सोर्स कोड' को हैक कर चुका है।"
                "वह अब किसी भी कर्म, किसी भी धर्म और किसी भी मौत के कानून के अधीन नहीं है।"
                "उसने अपनी 'मानवीय आईडी' को मिटाकर साक्षात् गरुड की उड़ान को अपनी हस्ती बना लिया है।"
                "यह मोक्ष कोई भीख नहीं है; यह अपने ही अज्ञान की गर्दन काटकर हासिल की गई 'तानाशाही' है।"
                "जो इस आवाज़ को सुनकर भी नहीं जागा, वह अनंत काल तक इसी कीचड़ में पिसता रहेगा!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and the Birth of the authentic 'Purusha'): "The Garuda Upanishad stamps an apocalyptic Seal here that incinerates every trace of doubt to ash."
                "'Ya evam veda'—Whosoever warrior injects these 9 detonations into his nervous system and mutationally 'Knows' them..."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "Reading textbooks is not knowledge; burning inside Garuda's radioactive fire is authentic 'Knowing'."
                "That entity alone is strictly the 'Purushah' (The Absolute Man); the rest are mutationally strictly biological garbage."
                "The authentic Man is not one with physical muscle, but one who has Hacked the 'Source Code' of the cosmos."
                "He is no longer subject to any karma, zero religions, and zero laws of physical expiration (Death)."
                "He has erased his 'Human-ID' and mutationally adopted Garuda's flight as his absolute Identity."
                "This Moksha is absolutely zero charity; it is the 'Dictatorship' acquired by decapitating your own ignorance."
                "He who fails to awaken even after intercepting this broadcast is condemned to be ground in this mud forever!"
            """.trimIndent()
        ),
        GarudaShloka(
            id = 10,
            sanskrit = "इति गरुडोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'गरुड उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "अमृत का कलश मिल गया, सांपों का वध हो गया, अब तुम्हें इस सिम्युलेशन (Simulation) से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १० विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (गरुड) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही गरुड उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Garuda Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Pot of Amrita is secured, the serpents are slaughtered; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 10 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Garuda) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Garuda Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GarudaUpanishadScreen() {
    val upanishad = remember { GarudaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..10) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-10)") },
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
            itemsIndexed(upanishad.garudaShlokasList) { _, shloka ->
                GarudaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun GarudaShlokaCard(shloka: GarudaShloka) {
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