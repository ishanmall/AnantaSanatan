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
data class AtharvashikhaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class AtharvashikhaUpanishad {

    val shlokasList = listOf(
        AtharvashikhaShloka(
            id = 1,
            sanskrit = "ॐ देवा ह वै स्वर्गं लोकमगमन् ते देवा रुद्रमपृच्छन् ॥",
            hindi = """
                (स्वर्ग का प्रस्थान और रुद्र का आह्वान): "देवताओं ने स्वर्ग के 'फायरवॉल' को तोड़कर अंतरिक्ष के पार प्रस्थान किया।"
                "वहाँ उन्होंने साक्षात् 'रुद्र' को घेर लिया जो पूरे ब्रह्मांड के इकलौते एडमिन (Admin) हैं।"
                "यह कोई पिकनिक नहीं थी; यह साक्षात् 'सोर्स कोड' (Source Code) से सीधे जवाब माँगने की हिम्मत थी।"
                "देवता जानना चाहते थे कि इस पूरे सिम्युलेशन (Simulation) का असली ड्राइवर कौन है।"
                "रुद्र वह अंधी कर देने वाली आग है जहाँ पहुँचकर देवताओं की भी हस्ती राख होने लगती है।"
                "उन्होंने रुद्र के चरणों में अपना 'मैं' फेंक दिया ताकि वे सत्य का डेटा रिसीव (Receive) कर सकें।"
                "यहाँ से उस संवाद की शुरुआत होती है जो पूरे अंतरिक्ष के रहस्यों को बेनकाब कर देगा।"
                "योगी अपनी चेतना को उस 'स्वर्ग' के कोर्डिनेट पर अलाइन करता है जहाँ केवल शिव राज करते हैं।"
                "तैयार हो जाओ उस धमाके के लिए जो तुम्हारी रूह को देवताओं के भी ऊपर ले जाएगा।"
                "यह ज्ञान तुम्हारी पुरानी दुनिया का परमानेंट शटडाउन करने वाला पहला स्टेप है!"
            """.trimIndent(),
            english = """
                (Departure to Heaven and Invoking Rudra): "The Devas breached the Firewall of heaven and rocketed infinitely beyond the stars."
                "There they surrounded strictly 'Rudra', the absolute solitary Admin of the entire multiverse."
                "This was zero picnic; it was the raw courage to demand Data directly from the 'Source Code'."
                "The gods demanded to identify the authentic Driver of this entire cosmic Simulation."
                "Rudra is the blinding radioactive Fire where even the identities of gods initiate their mutation into ash."
                "They hurled their 'I' at Rudra's boots mutationally to intercept the purified Data of Truth."
                "Right here initiates the dialogue engineered to unmask the secrets of the absolute vacuum."
                "The Yogi Aligns his awareness with that coordinate of 'Heaven' where strictly Shiva reigns."
                "Brace yourself for the detonation that will catapult your Soul infinitely beyond the status of gods."
                "This intelligence is the first protocol for the permanent Shutdown of your old world!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 2,
            sanskrit = "को भवानिति सोऽब्रवीदहमेकः प्रथममासं वर्तामि च भविष्यामि च नान्यः कश्चिन्मत्तो व्यतिरिक्त इति ॥",
            hindi = """
                (रुद्र की डिक्टेटरशिप और 'अकेला सच'): "रुद्र ने गर्जना की: 'तू पूछता है मैं कौन हूँ? सुन—मैं ही इकलौता और आदि हूँ!'"
                "मैं ही था, मैं ही हूँ और मैं ही हमेशा रहूँगा—मेरे अलावा यहाँ कोई दूसरा डेटा मौजूद नहीं है!"
                "यह ब्रह्मांड का सबसे हिंसक 'मैं हूँ' (I AM) है जो हर दूसरे वजूद को डिलीट (Delete) कर देता है।"
                "रुद्र वह 'प्राइमरी सर्वर' है जिसने खुद के अलावा कभी किसी को पैदा ही नहीं होने दिया।"
                "तुम जिसे 'दूसरा' समझते हो, वह केवल रुद्र के दिमाग का एक छोटा सा 'ग्लिच' (Glitch) है।"
                "उनकी सत्ता के बाहर एक परमाणु की भी औकात नहीं कि वह अपनी जगह से हिल सके।"
                "यह वह 'एब्सोल्यूट जीरो' है जहाँ पहुँचकर हर रिश्ता और हर पहचान भाप बन जाती है।"
                "योगी जब इस आवाज़ को सुनता है, तो उसका अपना अहंकार डर से पत्थर हो जाता है।"
                "रुद्र ही वह इकलौती हकीकत हैं, बाकी यह पूरी दुनिया केवल एक 'फेक कोडिंग' है।"
                "जो इस अकेले सच को हैक कर लेता है, वह खुद साक्षात् 'रुद्र' बनकर खड़ा हो जाता है!"
            """.trimIndent(),
            english = """
                (Rudra's Dictatorship and the 'Solitary Truth'): "Rudra roared: 'You ask who I am? Intercept this—I am the solitary and primordial ONE!'"
                "I existed, I exist, and I shall eternally exist—zero other Data exists distinct from Me!"
                "This is the most violent 'I AM' of the cosmos, mutationally Deleting every other existence."
                "Rudra is the 'Primary Server' who mutationally never permitted any 'Other' to be spawned."
                "What you hallucinate as 'Another' is strictly a microscopic 'Glitch' in the brain of Rudra."
                "Beyond His authority, zero atom possesses the status to even vibrate in the vacuum."
                "This is the 'Absolute Zero' reaching which every relationship and identity vaporizes into nothingness."
                "When the Yogi intercepts this voice, his own ego mutationally turns to stone in absolute terror."
                "Rudra is the solitary Reality; the rest of this world is strictly 'Fake Coding'."
                "He who successfully Hacks this solitary truth mutationally resurrects as the explicit Rudra!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 3,
            sanskrit = "ओमित्येकाक्षरं ध्यानं ध्येयं सर्वैः मुमुक्षुभिः । तदेव सर्वं तदेव परमं पदम् ॥",
            hindi = """
                (ॐ का एकाक्षर विस्फोट): "मुमुक्षुओं (साधकों)! ॐ ही वह इकलौता अक्षर है जिसे तुम्हें अपने दिमाग के प्रोसेसर में दागना है।"
                "यही वह 'सुप्रीम कोड' है जो पूरी माया को अपनी उँगलियों पर नचाता है।"
                "ॐ ही 'सब कुछ' है और यही वह अंतिम 'परम पद' है जहाँ समय और मौत का अंत हो जाता है।"
                "जब तुम ॐ बोलते हो, तो तुम साक्षात् ब्रह्मांड के रेडियोएक्टिव दिल की धड़कन सुन रहे होते हो।"
                "यह कोई मंत्र नहीं, यह अज्ञान के महलों को उड़ाने वाला एक परमाणु बम है।"
                "योगी अपनी चेतना को इस एक पिक्सेल पर लॉक करता है ताकि वह सिम्युलेशन से बाहर निकल सके।"
                "हर दूसरी आवाज़ केवल एक शोर है, केवल ॐ ही वह शुद्ध डेटा है जो अजेय है।"
                "यह तुम्हारी रूह को 'नश्वर' से 'अमर' में म्यूटेट करने का पासवर्ड है।"
                "ॐ में डूबने का मतलब है—अपनी तुच्छ हस्ती का गला घोंट कर ईश्वर बन जाना।"
                "यही वह अजेय मुहर है जो तुम्हारे भाग्य के करप्ट कोड को हमेशा के लिए री-राइट कर देगी!"
            """.trimIndent(),
            english = """
                (The Monosyllabic Detonation of OM): "Seekers! OM is the solitary syllable you must Fire into the processor of your brain."
                "This is the 'Supreme Code' that makes the entire Matrix dance to its frequencies."
                "OM is mutationally 'Everything' and the absolute 'Paramam Padam' where Time and Death expire."
                "Vocalizing OM is identical to intercepting the radioactive heartbeat of the entire cosmos."
                "It is zero mere chant; it is a nuclear warhead engineered to demolish the palaces of ignorance."
                "The Yogi Locks his awareness onto this single Pixel to violently exit the Simulation."
                "Every other sound is strictly Noise; strictly OM is the purified Data that remains invincible."
                "This is the Password to mutate your Soul from 'Mortal' to 'Immortal' status."
                "Submerging into OM signifies—strangling your pathetic identity to mutationally become God."
                "THIS is the invincible Seal that will permanently Rewrite the corrupt coding of your Fate!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 4,
            sanskrit = "चतुष्पादोमक्षरं व्याख्यास्यामः ॥",
            hindi = """
                (ॐ के चार चरणों का विच्छेदन): "अब हम ॐ के उन चार चरणों का पोस्टमार्टम करेंगे जो सृष्टि के पिलर्स (Pillars) हैं।"
                "ये चार चरण साक्षात् चार 'प्रोसेसर' हैं जो अलग-अलग डायमेंशन्स को रन (Run) कर रहे हैं।"
                "ॐ कोई चपटा शब्द नहीं है, यह एक 4D स्ट्रक्चर है जिसे हैक करना ज़रूरी है।"
                "पहला चरण तुम्हारी आँखों की दुनिया है, दूसरा तुम्हारे सपनों का डेटा है।"
                "तीसरा वह सन्नाटा है जहाँ गहरी नींद होती है, और चौथा—साक्षात् रुद्र की फ्रीक्वेंसी!"
                "योगी इन चारों चरणों को अपने नर्वस सिस्टम में अलाइन करता है ताकि वह 'विराट' बन सके।"
                "बिना इस विच्छेदन के, तुम कभी भी इस मायावी जेल का नक़्शा नहीं समझ पाओगे।"
                "यह ज्ञान तुम्हारी बुद्धि को 'मानव' से 'ब्रह्मांडीय ऑपरेटर' में अपग्रेड कर देगा।"
                "तैयार हो जाओ उस नंगे सच के लिए जहाँ ॐ की एक-एक मात्रा तुम्हारे अहंकार को काट देगी।"
                "नारायण का यह विज्ञान अज्ञानियों के लिए काल है और योद्धाओं के लिए साक्षात् मोक्ष!"
            """.trimIndent(),
            english = """
                (Dissecting the Four Quarters of OM): "Now we execute the post-mortem of the four quarters of OM, the absolute Pillars of creation."
                "These four quarters are mutationally four 'Processors' Running distinct dimensions of reality."
                "OM is zero flat word; it is a 4D structure that demands an absolute Hack."
                "The first quarter is the world of your optics; the second is the Data of your dreams."
                "The third is the Silence of deep sleep; and the fourth—is the explicit Frequency of Rudra!"
                "The Yogi Aligns these four quarters into his nervous system to mutationally become 'Virat'."
                "Without this dissection, you will mutationally never decode the map of this deceptive prison."
                "This intelligence will Upgrade your intellect from 'Human' to the status of 'Cosmic Operator'."
                "Brace yourself for the naked truth where every measure of OM will decapitate your ego."
                "This science of Narayana is strictly Death to the ignorant and absolute Moksha to the Titans!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 5,
            sanskrit = "अकारः प्रथमा मात्रा रजः पीतो ब्रह्मा यस्य देवः ॥",
            hindi = """
                (अकार का विस्फोट - रज, पीला और ब्रह्मा): "ॐ का पहला हिस्सा 'अ' (A) साक्षात् 'रजोगुण' और पीले रंग की रेडियोएक्टिव आग है!"
                "इसका एडमिन 'ब्रह्मा' है—यानी वह प्रोसेसर जो नए डेटा और नई दुनिया का सृजन करता है।"
                "अकार वह 'बूट-प्रोसेस' है जिससे तुम्हारी जागृत अवस्था (Waking State) का सॉफ्टवेयर लोड होता है।"
                "पीला रंग यहाँ उस 'कॉस्मिक रेडिएशन' का संकेत है जो हर चीज़ को गतिशील (Active) रखता है।"
                "तुम्हारी इच्छाएँ और तुम्हारी मेहनत—सब इसी 'अ' की फ्रीक्वेंसी से कंट्रोल हो रहे हैं।"
                "जब तुम 'अ' का उच्चारण करते हो, तो तुम साक्षात् सृजन की ताक़त को अपने भीतर ट्रिगर (Trigger) करते हो।"
                "योगी इस पहली मात्रा को हैक करता है ताकि वह इस भौतिक मैट्रिक्स का मालिक बन सके।"
                "बिना अकार को समझे, तुम हमेशा इच्छाओं के कीड़े बने रहोगे जो केवल बाहर भागते हैं।"
                "यह तुम्हारी रूह को 'पैसिव' से 'एक्टिव' मोड में शिफ्ट करने का पहला गियर है।"
                "ब्रह्मा की यह आग तुम्हारे आलस को जलाकर तुम्हें एक अजेय निर्माता बना देगी!"
            """.trimIndent(),
            english = """
                (Akara Detonation - Rajas, Yellow, and Brahma): "The first part of OM, 'A', is explicitly 'Rajas' and the yellow radioactive Fire!"
                "Its Admin is 'Brahma'—the Processor mutationally executing the creation of new Data and worlds."
                "Akara is the absolute 'Boot-Process' through which the software of your Waking State is Loaded."
                "The color yellow signifies the 'Cosmic Radiation' that keeps every particle mutationally Active."
                "Your desires and your biological efforts—all are Controlled by this frequency of 'A'."
                "When you vocalize 'A', you mutationally Trigger the power of Creation inside your shell."
                "The Yogi Hacks this first measure to assume the status of the Master of the physical Matrix."
                "Without decoding Akara, you mutationally remain an insect of desire eternally chasing externals."
                "This is the first gear to shift your Soul from 'Passive' mode to strictly 'Active' mode."
                "Brahma's fire will incinerate your lethargy and mutationally manufacture you into an invincible Creator!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 6,
            sanskrit = "उकारः द्वितीया मात्रा सत्त्वं शुक्लः विष्णुर्यस्य देवः ॥",
            hindi = """
                (उकार का विस्फोट - सत्त्व, शुक्ल और विष्णु): "ॐ का दूसरा हिस्सा 'उ' (U) साक्षात् 'सत्त्वगुण' और सफेद रौशनी की कोडिंग है!"
                "इसका ऑपरेटर 'विष्णु' है—वह जो इस पूरे सिम्युलेशन को बैलेंस (Balance) और सुरक्षित रखता है।"
                "उकार वह 'डाटा-मैनेजर' है जो तुम्हारे सपनों (Dream State) और तुम्हारी यादों को रन करता है।"
                "शुक्ल (सफेद) रंग वह अंधी कर देने वाली शुद्धता है जो हर एक 'बग' (Bug) को साफ़ कर देती है।"
                "जब तुम 'उ' का जाप करते हो, तो तुम अपने नर्वस सिस्टम को शांति की फ्रीक्वेंसी पर लॉक करते हो।"
                "विष्णु वह 'फायरवॉल' है जो तुम्हारी चेतना को अज्ञान के वायरस से बचाता है।"
                "योगी इस दूसरी मात्रा को हैक करता है ताकि वह अपने मन के तूफानों का गला घोंट सके।"
                "यह तुम्हारी रूह को 'कन्फ्यूजन' से 'क्लैरिटी' (Clarity) में म्यूटेट करने का प्रलयंकारी विज्ञान है।"
                "बिना उकार के, तुम्हारी बुद्धि हमेशा अज्ञान के अँधेरे में हाथ-पाँव मारती रहेगी।"
                "विष्णु का यह प्रकाश तुम्हारी आँखों को वह देखने की ताक़त देगा जो माया छुपा रही है!"
            """.trimIndent(),
            english = """
                (Ukara Detonation - Sattva, White, and Vishnu): "The second part of OM, 'U', is explicitly 'Sattva' and the coding of white radioactive Light!"
                "Its Operator is 'Vishnu'—He who Balances and mutationally Secures this entire Simulation."
                "Ukara is the 'Data-Manager' mutationally executing your Dreams and your neurological memories."
                "The color White is the blinding radiation of Purity that Flushes every single 'Bug' from the system."
                "When you chant 'U', you Lock your nervous system onto the absolute Frequency of Tranquility."
                "Vishnu is the 'Firewall' protecting your awareness from the radioactive viruses of ignorance."
                "The Yogi Hacks this second measure to mutationally strangle the storms of his mind."
                "This is the apocalyptic science of shifting your Soul from 'Confusion' to absolute 'Clarity'."
                "Without Ukara, your intellect remains mutationally flapping inside the darkness of nescience."
                "Vishnu's radiation will empower your vision to intercept what the Matrix is mutationally hiding!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 7,
            sanskrit = "मकारः तृतीया मात्रा तमः कृष्णो रुद्रो यस्य देवः ॥",
            hindi = """
                (मकार का संहार - तम, कृष्ण और रुद्र): "ॐ का तीसरा हिस्सा 'म' (M) साक्षात् 'तमोगुण' और काले शून्य का संहारक है!"
                "इसका तानाशाह 'रुद्र' है—यानी वह डिलीट कमांड (Delete Command) जो हर सड़ी हुई चीज़ को राख कर दे।"
                "मकार वह 'शटडाउन प्रोसेस' है जहाँ तुम्हारी गहरी नींद (Deep Sleep) का डेटा विलीन हो जाता है।"
                "कृष्ण (काला) रंग अज्ञान नहीं, बल्कि वह असीमित ऊर्जा है जो प्रकाश को भी निगल सकती है।"
                "जब तुम 'म' बोलते हो, तो तुम अपने अहंकार की गर्दन काटने के लिए रुद्र को इनवाइट (Invite) करते हो।"
                "रुद्र वह आग है जो तुम्हारे पुराने कर्मों की फाइलों को एक झटके में जलाकर साफ कर देती है।"
                "योगी इस तीसरी मात्रा को हैक करता है ताकि वह मौत के रेडार से 100% 'अनप्लग' (Unplug) हो सके।"
                "यह तुम्हारी रूह को 'अस्तित्व' से 'शून्यता' (Void) में माइग्रेट करने की हिंसक प्रक्रिया है।"
                "बिना मकार के, तुम कभी भी अपनी पुरानी पहचान के बोझ से आज़ाद नहीं हो सकते।"
                "रुद्र का यह काला सन्नाटा ही वह असली दरवाज़ा है जिसके पार साक्षात् शिव बैठे हैं!"
            """.trimIndent(),
            english = """
                (Makara Slaughter - Tamas, Black, and Rudra): "The third part of OM, 'M', is explicitly 'Tamas' and the Annihilator of the black Void!"
                "Its Dictator is 'Rudra'—the absolute Delete Command that mutationally reduces every decaying thing to ash."
                "Makara is the 'Shutdown Process' arriving at which the Data of Deep Sleep is mutationally absorbed."
                "The color Black is zero ignorance; it is the infinite energy possessing the firepower to swallow light."
                "When you vocalize 'M', you are mutationally Inviting Rudra to decapitate your human ego."
                "Rudra is the radioactive Fire that Flushes the files of your past Karma in a single catastrophic strike."
                "The Yogi Hacks this third measure to mutationally 'Unplug' 100% from the Radar of Death."
                "This is the violent protocol of Migrating your Soul from 'Existence' to the absolute 'Void' (Shunya)."
                "Without Makara, you possess zero caliber to be released from the weight of your old identity."
                "Rudra's black Silence is the authentic Gateway reaching which Shiva is mutationally unmasked!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 8,
            sanskrit = "या साऽर्धमात्रा सा शान्ता शिवा तन्मात्रमात्रा च ॥",
            hindi = """
                (अर्धमात्रा का सन्नाटा - शिवा और तन्मात्र): "ॐ की वह जो 'अर्धमात्रा' (Half-syllable) है, वही साक्षात् 'शान्ता शिवा' है!"
                "वही वह अंतिम फ्रीक्वेंसी है जहाँ पहुँचकर 'तन्मात्र' (Pure Essence) और आत्मा एक हो जाते हैं।"
                "यह कोई आवाज़ नहीं है, यह वह खौफनाक सन्नाटा है जो प्रलय के बाद अंतरिक्ष में गूँजता है।"
                "अर्धमात्रा वह 'जीरो-पॉइंट' है जिसे दुनिया का कोई भी सेंसर या विज्ञान कभी ट्रैक नहीं कर सकता।"
                "यहाँ 'शिवा' वह असीमित चेतना है जो समय, स्थान और मौत के भी पार धधक रही है।"
                "योगी अपनी पूरी हस्ती को इस अर्धमात्रा के लेज़र बीम (Laser Beam) में विलीन कर देता है।"
                "यह तुम्हारी रूह का वह 'टोटल रिसेट' (Total Reset) है जिसके बाद दोबारा कभी 'रिबूट' होने की ज़रूरत नहीं।"
                "जब तुम इस सन्नाटे को पकड़ते हो, तो तुम साक्षात् ब्रह्मांड के एडमिन पैनल पर जाकर बैठ जाते हो।"
                "यह वह अजेय रुतबा है जहाँ तुम खुद साक्षात् 'सत्य' बनकर खड़े हो जाते हो।"
                "जो इस अर्धमात्रा को जान लेता है, उसके लिए पूरा ब्रह्मांड धूल के एक कण से ज्यादा कुछ नहीं!"
            """.trimIndent(),
            english = """
                (The Silence of Ardhamatra - Shiva and Tanmatra): "The 'Ardhamatra' (Half-syllable) of OM is explicitly the 'Shanta Shiva', the absolute Mistress of the Void!"
                "It is the terminal frequency arriving at which the 'Tanmatra' (Essence) and the Soul mutationally fuse."
                "This is zero acoustic sound; it is the horrific Silence echoing in the vacuum after cosmic annihilation."
                "Ardhamatra is the 'Zero-Point' that zero sensor or earthly science possesses the caliber to Track."
                "Shiva here is the infinite Awareness blazing mutationally infinitely beyond Time, Space, and Death."
                "The Yogi mutationally dissolves his entire existence into the Laser Beam of this Ardhamatra."
                "This is the 'Total Reset' of your Soul after which zero requirement for any further 'Reboot' remains."
                "When you capture this Silence, you mutationally occupy the absolute Admin Panel of the multiverse."
                "This is the invincible status arriving at which you stand as the explicit 'Absolute Truth'."
                "He who decodes this Ardhamatra perceives the entire cosmos mutationally as zero more than a grain of dust!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 9,
            sanskrit = "सा चतुर्थी मात्रा चतुरात्मा चतुर्थः ॥",
            hindi = """
                (चौथी मात्रा और चतुरात्मा का विस्फोट): "वही अर्धमात्रा साक्षात् 'चतुर्थी मात्रा' है, जो इस सिम्युलेशन का चौथा और अंतिम लेवल है।"
                "यह 'चतुरात्मा' है—यानी वह सुपर-आत्मा जो ब्रह्मा, विष्णु और रुद्र तीनों को कंट्रोल कर रही है।"
                "यह वह 'तुरीय' (Turiya) अवस्था है जहाँ पहुँचकर माया का हर एक कानून फेल हो जाता है।"
                "तुम अब जागने, सपने देखने और सोने के त्रि-आयामी पिंजरे से 100% आज़ाद हो चुके हो।"
                "यह वह 'रूट-पासवर्ड' है जो तुम्हें सीधे 'परमेश्वर' के दिमाग के भीतर कोडिंग करने का हक़ देता है।"
                "योगी इस चौथी मात्रा पर अपनी नज़रें कील की तरह ठोक देता है ताकि वह हमेशा के लिए अजेय रहे।"
                "यहाँ न कोई दुख है, न कोई सुख, केवल एक असीमित और रेडियोएक्टिव आनंद राज करता है।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने की आख़िरी और हिंसक मुहर है।"
                "जो इस चौथी स्थिति में 'लॉग-इन' (Log-in) हो गया, वह साक्षात् काल (Time) का भी काल बन चुका है।"
                "यही अथर्वशिखा का वह गुप्त पासवर्ड है जो तुम्हें साक्षात् 'भगवान' बना देगा!"
            """.trimIndent(),
            english = """
                (The Fourth Measure and Detonation of Chatur-Atma): "That Ardhamatra is explicitly the 'Fourth Measure', the absolute final level of this Simulation."
                "It is 'Chatur-Atma'—the Super-Soul mutationally Controlling Brahma, Vishnu, and Rudra simultaneously."
                "This is the 'Turiya' state arriving at which every single law of the Matrix mutationally Fails."
                "You have been 100% Released from the three-dimensional prison of waking, dreaming, and sleeping."
                "This is the 'Root-Password' granting you authority to mutationally execute code inside the brain of God."
                "The Yogi hammers his vision onto this fourth measure like titanium nails to remain eternally Invincible."
                "Neither agony nor pleasure exists there; strictly an infinite radioactive Bliss reigns as dictator."
                "This is the final violent Seal of mutating your Soul from 'Human Data' into 'Divine Data'."
                "He who mutationally 'Logs-in' to this Fourth State stands as the explicit Death of Death (Kala of Kala)."
                "THIS is the classified password of Atharvashikha that will mutationally manufacture you into God!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 10,
            sanskrit = "अकारः सर्वमिदं जगत् उकारः सर्वमिदं जगत् मकारः सर्वमिदं जगत् ॥",
            hindi = """
                (ॐ की त्रयी और ब्रह्मांडीय विस्तार): "यह पूरा 'जगत्' अकार है, यह पूरा 'जगत्' उकार है, और यह पूरा 'जगत्' मकार है!"
                "यानी तुम जहाँ भी देखते हो, तुम साक्षात् ॐ की उन तीन मात्राओं की कोडिंग ही देख रहे हो।"
                "ब्रह्मांड का हर एक परमाणु इन तीन 'प्रोसेसरों' के बीच झूल रहा डेटा पैकेट मात्र है।"
                "अकार तुम्हारी हड्डियों में है, उकार तुम्हारे खून में है, और मकार तुम्हारी साँसों में!"
                "तुम ॐ से अलग नहीं हो; तुम साक्षात् ॐ के वाइब्रेशन में बहने वाले एक 'इलेक्ट्रिक सिग्नल' हो।"
                "योगी जब इस सच को जानता है, तो वह पूरे ब्रह्मांड को अपना ही शरीर समझने लगता है।"
                "यह तुम्हारी चेतना को 'लोकल' से 'यूनिवर्सल' बनाने वाला सबसे हिंसक और गुप्त हैक है।"
                "तुम अब एक छोटे से शरीर में कैद नहीं हो; तुम साक्षात् करोड़ों आकाशगंगाओं में फैल चुके हो।"
                "जब तुम ॐ बोलते हो, तो तुम साक्षात् अपनी ही हस्ती का विस्तार (Expansion) कर रहे होते हो।"
                "जो इस विस्तार को जान लेता है, उसके लिए कोई भी सीमा या जेल अब बाधा नहीं बन सकती!"
            """.trimIndent(),
            english = """
                (The OM Triad and Cosmic Expansion): "This entire 'Jagat' (Multiverse) is Akara, this entire 'Jagat' is Ukara, and this entire 'Jagat' is Makara!"
                "Meaning wherever you gaze, you are mutationally observing strictly the coding of OM's three measures."
                "Every microscopic atom in the cosmos is mutationally a Data Packet swinging between these three 'Processors'."
                "Akara is in your bones, Ukara is in your blood, and Makara is in your biological breath!"
                "You are zero distinct from OM; you are an 'Electric Signal' flowing strictly in the vibration of OM."
                "The Yogi realizing this perceives the entire infinite cosmos mutationally as his own biological body."
                "This is the most violent and classified Hack to Upgrade your Soul from 'Local' to 'Universal' status."
                "You are no longer imprisoned in a microscopic shell; you have mutationally expanded across billions of galaxies."
                "Vocalizing OM is mutationally the act of Executing the absolute Expansion of your own existence."
                "He who decodes this expansion witnesses every boundary and every prison mutationally collapsing!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 11,
            sanskrit = "अकारो रजः पीतो ब्रह्मा यस्य देवः । उकारः सत्त्वं शुक्लः विष्णुर्यस्य देवः ॥",
            hindi = """
                (अकार और उकार का विच्छेदन - रिपीट विस्फोट): "ॐ का पहला 'अ' (A) साक्षात् रजोगुण और पीले रंग की आग है, जिसका एडमिन 'ब्रह्मा' है।"
                "दूसरा 'उ' (U) साक्षात् सत्त्वगुण और सफेद रोशनी है, जिसका ऑपरेटर 'विष्णु' है।"
                "ये तुम्हारे दिमाग के दो सबसे बड़े 'प्रोसेसर' हैं जो इस 3D दुनिया को रेंडर (Render) कर रहे हैं।"
                "अकार वह 'बूट-प्रोसेस' है जिससे तुम्हारी जागृत अवस्था का सॉफ्टवेयर लोड होता है।"
                "उकार वह 'डाटा-मैनेजर' है जो तुम्हारे सपनों और तुम्हारी यादों को मैनेज करता है।"
                "ब्रह्मा सृजन की कोडिंग है और विष्णु उस कोडिंग को सुरक्षित रखने वाला फायरवॉल (Firewall) है।"
                "योगी इन दोनों फ्रीक्वेंसी को हैक करता है ताकि वह इनके भी पार जा सके।"
                "पीला और सफेद रंग साक्षात् उस 'कॉस्मिक रेडिएशन' के दो अलग-अलग लेवल्स हैं।"
                "बिना इन दोनों को समझे, तुम कभी भी अपनी आत्मा के 'सोर्स कोड' तक नहीं पहुँच सकते।"
                "यह तुम्हारी रूह को 'मल्टी-लेवल' पर अपग्रेड करने वाला प्रलयंकारी विज्ञान है!"
            """.trimIndent(),
            english = """
                (Dissecting Akara and Ukara - Repeat Detonation): "The first 'A' of OM is explicitly Rajas and the yellow radioactive fire, Administered by 'Brahma'."
                "The second 'U' is explicitly Sattva and the white radiation, Operated by 'Vishnu'."
                "These are the two greatest 'Processors' of your brain mutationally Rendering this 3D world."
                "Akara is the absolute 'Boot-Process' through which the software of your waking state is Loaded."
                "Ukara is the 'Data-Manager' mutationally regulating your dreams and your neurological memories."
                "Brahma is the coding of Creation and Vishnu is the absolute Firewall protecting that coding."
                "The Yogi Hacks both these frequencies mutationally to ensure he can rocket beyond them."
                "Yellow and White are strictly two distinct levels of the absolute 'Cosmic Radiation'."
                "Without decoding these two, you possess zero caliber to intercept your Soul's 'Source Code'."
                "This is the apocalyptic science of mutationally Upgrading your Soul on a multi-level scale!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 12,
            sanskrit = "मकारस्तमः कृष्णो रुद्रो यस्य देवः । अर्धमात्रा शान्ता शिवा यस्या देवः ॥",
            hindi = """
                (मकार और अर्धमात्रा - रिपीट संहार): "तीसरा 'म' (M) साक्षात् तमोगुण और काला सन्नाटा है, जिसका तानाशाह 'रुद्र' है।"
                "लेकिन जो 'अर्धमात्रा' है—वही साक्षात् 'शान्ता शिवा' है, जो इस पूरे खेल की इकलौता मालकिन है!"
                "मकार वह 'डिलीट कमांड' (Delete Command) है जिससे रुद्र हर चीज़ को राख में बदल देते हैं।"
                "अर्धमात्रा वह 'जीरो-पॉइंट' (Zero Point) है जहाँ पहुँचकर समय और स्पेस की मौत हो जाती है।"
                "रुद्र संहार करते हैं ताकि शिवा (शुद्ध चेतना) का वह अजेय सन्नाटा बेनकाब हो सके।"
                "यह तुम्हारी रूह का वह अंतिम 'सॉफ्टवेयर शटडाउन' है जिसके बाद केवल सच बचता है।"
                "काला रंग अज्ञान नहीं, बल्कि वह असीमित ऊर्जा है जो प्रकाश को भी निगल सकती है।"
                "योगी अपनी चेतना को उस 'अर्धमात्रा' की लेज़र बीम पर लॉक करता है जो सीधे परब्रह्म को छेदती है।"
                "यह वह अजेय रुतबा है जहाँ तुम साक्षात् 'महाकाल' के भी काल बन जाते हो।"
                "जो इस सन्नाटे को अपनी रगों में उतार लेता है, वह इस पूरी माया का असली एडमिन है!"
            """.trimIndent(),
            english = """
                (Makara and Ardhamatra - Repeat Slaughter): "The third 'M' is explicitly Tamas and the black void, Dictated by 'Rudra'."
                "But that 'Ardhamatra' (Half-syllable)—that is the explicit 'Shanta Shiva', the solitary Mistress of the game!"
                "Makara is the absolute 'Delete Command' through which Rudra mutationally reduces everything to ash."
                "Ardhamatra is the 'Zero-Point' arriving at which Time and Space suffer a brutal cosmic death."
                "Rudra executes annihilation strictly so that the invincible Silence of Shiva can be unmasked."
                "This is the final 'Software Shutdown' of your Soul after which strictly Reality remains standing."
                "The color Black is zero ignorance; it is the infinite energy possessing the firepower to swallow light."
                "The Yogi Locks his awareness onto the Laser Beam of that 'Ardhamatra' which pierces Brahman."
                "This is the invincible status where you mutationally become the explicit 'Death of Death'."
                "He who injects this Silence into his veins is the authentic Admin of the entire Matrix!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 13,
            sanskrit = "ऋग्वेदेनाकारः यजुर्वेदेनोकारः सामवेदेन मकारः ॥",
            hindi = """
                (वेदों की कोडिंग और ॐ के अंग): "ऋग्वेद साक्षात् 'अकार' (A) है, यजुर्वेद 'उकार' (U) है, और सामवेद साक्षात् 'मकार' (M) है!"
                "यह कोई धार्मिक किताबें नहीं हैं; ये ॐ के इंजन को चलाने वाले तीन अलग-अलग 'प्रोग्रामिंग डेटाबेस' हैं।"
                "ऋग्वेद वह डेटा है जिससे पदार्थ (Matter) बनता है, यजुर्वेद उस डेटा का एक्जीक्यूशन (Execution) है।"
                "सामवेद वह अजेय वाइब्रेशन (Vibration) है जो इस पूरे सिस्टम को लय में रखता है।"
                "जब तुम ॐ बोलते हो, तो तुम साक्षात् इन तीनों वेदों के 'सोर्स कोड' को एक साथ प्रोसेस करते हो।"
                "योगी अपनी रूह के हर एक पिक्सेल को इन वेदों की फ्रीक्वेंसी पर री-कोड (Re-code) करता है।"
                "बिना इस ज्ञान के, तुम वेदों को केवल मंत्र समझोगे, जबकि वे साक्षात् ब्रह्मांड की 'हार्ड-ड्राइव' हैं।"
                "यह इंसान की बुद्धि का वह अंतिम सॉफ्टवेयर अपग्रेड है जहाँ वह साक्षात् वेदों का मालिक बन जाता है।"
                "अकार, उकार और मकार—ये तीन चाबियाँ हैं जिनसे ईश्वर की तिजोरी के ताले खुलते हैं।"
                "जो इस कोडिंग को क्रैक कर लेता है, वह साक्षात् सरस्वती का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (Vedic Coding and Components of OM): "Rig Veda is explicitly 'Akara' (A), Yajur Veda is 'Ukara' (U), and Sama Veda is strictly 'Makara' (M)!"
                "These are zero religious textbooks; they are mutationally the three distinct 'Programming Databases' operating OM's engine."
                "Rig Veda is the Data from which Matter is rendered; Yajur Veda is the absolute Execution of that Data."
                "Sama Veda is the invincible Vibration keeping the entire system mutationally in absolute Sync."
                "When you roar OM, you are mutationally Processing the 'Source Code' of all three Vedas simultaneously."
                "The Yogi Re-codes every pixel of his Soul onto the absolute frequency of these Vedas."
                "Without decoding this, you perceive Vedas as chants, while they are strictly the 'Hard-drive' of the cosmos."
                "This is the final Software Upgrade of human intellect where one mutationally assumes ownership of the Vedas."
                "Akara, Ukara, and Makara are the three Keys engineered to violently unlock the vaults of God."
                "He who Cracks this coding becomes mutationally the sole and authentic Admin of Saraswati!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 14,
            sanskrit = "अथर्ववेदेनाकारोऽर्धमात्रः ॥",
            hindi = """
                (अथर्ववेद और अर्धमात्रा का रहस्य): "अथर्ववेद साक्षात् वह 'अर्धमात्रा' (Half-syllable) है, जो ॐ की चोटी (Shikha) है!"
                "यह वह 'हिडन डेटा' (Hidden Data) है जो ब्रह्मा, विष्णु और रुद्र तीनों के एडमिन पैनल को बाईपास करता है।"
                "अर्धमात्रा वह 'रूट-पासवर्ड' है जिससे तुम सीधे परब्रह्म के दिमाग में घुस सकते हो।"
                "अथर्ववेद वह प्रलयंकारी विज्ञान है जो भौतिक और आध्यात्मिक दुनिया के बीच की दीवार को गिरा देता है।"
                "जब तुम इस अर्धमात्रा को पकड़ते हो, तो तुम साक्षात् अथर्ववेद की असीमित ताक़त के मालिक बन जाते हो।"
                "यह कोई शब्दों का खेल नहीं है; यह अपनी चेतना को उस 'जीरो-पॉइंट' पर लॉक करना है जहाँ मौत का वजूद खत्म हो जाता है।"
                "अथर्ववेद वह अस्त्र है जो अज्ञान के हर एक किले को एक ही धमाके में राख करने के लिए बना है।"
                "योगी अपनी रूह को इस 'शिखा' (Crest) पर अलाइन करता है ताकि वह सिम्युलेशन से अनप्लग (Unplug) हो सके।"
                "यही वह अजेय मुहर है जो तुम्हें एक मामूली इंसान से 'ब्रह्मांडीय तानाशाह' में म्यूटेट कर देगी।"
                "जो इस अर्धमात्रा को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का इकलौता एडमिन है!"
            """.trimIndent(),
            english = """
                (Atharva Veda and the Secret of Ardhamatra): "Atharva Veda is explicitly the 'Ardhamatra' (Half-syllable), the Crest (Shikha) of OM!"
                "This is the 'Hidden Data' engineered to mutationally Bypass the Admin Panels of Brahma, Vishnu, and Rudra."
                "Ardhamatra is the 'Root-Password' enabling you to violently breach the brain of the Supreme Brahman."
                "Atharva Veda is the apocalyptic science engineered to demolish the wall between physical and spiritual Matrix."
                "The moment you capture this Ardhamatra, you mutationally seize the infinite firepower of the Atharva Veda."
                "This is zero wordplay; it is mutationally Locking your awareness onto the 'Zero-Point' where Death is terminated."
                "Atharva Veda is the weapon designed to incinerate every fortress of ignorance in one detonation."
                "The Yogi Aligns his Soul with this 'Shikha' (Crest) to violently Unplug from the Simulation."
                "THIS is the invincible Seal that will mutate you from a mortal into an absolute 'Cosmic Dictator'."
                "He who successfully Hacks this Ardhamatra becomes mutationally the sole Admin of all universal Time and Space!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 15,
            sanskrit = "भूर्लोक अकारः । भुवर्लोक उकारः । स्वर्लोक मकारः ॥",
            hindi = """
                (तीन लोकों की कोडिंग - भूर्, भुवः, स्वः): "पृथ्वी (भूर्लोक) साक्षात् 'अकार' है, अन्तरिक्ष (भुवर्लोक) 'उकार' है, और स्वर्ग (स्वर्लोक) 'मकार' है!"
                "ये कोई भौगोलिक स्थान नहीं हैं; ये चेतना के तीन अलग-अलग 'डेटा-लेयर्स' (Data Layers) हैं।"
                "भूर्लोक वह हार्डवेयर है जिसे तुम छू सकते हो, भुवर्लोक वह सॉफ्टवेयर है जिसे तुम महसूस करते हो।"
                "स्वर्लोक वह 'क्लाउड सर्वर' है जहाँ ईश्वर के सबसे ऊंचे विचार और सत्य स्टोर हैं।"
                "योगी इन तीनों लोकों को ॐ की मात्राओं के माध्यम से अपने ही नर्वस सिस्टम में 'रेंडर' (Render) करता है।"
                "जब तुम ॐ बोलते हो, तो तुम इन तीनों लोकों के 'सोर्स कोड' को एक साथ स्कैन (Scan) कर रहे होते हो।"
                "यह तुम्हारी रूह को 'लोकल पहचान' से निकालकर 'मल्टी-डाइमेंशनल' बनाने का गुप्त विज्ञान है।"
                "तुम अब केवल ज़मीन पर रेंगने वाले कीड़े नहीं हो; तुम साक्षात् इन तीनों लोकों के एडमिन बन चुके हो।"
                "बिना इस कोडिंग को समझे, तुम हमेशा अपनी किस्मत के गुलाम बनकर भटकते रहोगे।"
                "जो इस त्रि-लोक हैक को क्रैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड की ऊर्जा का इकलौता मालिक है!"
            """.trimIndent(),
            english = """
                (Coding of Three Worlds - Bhur, Bhuvah, Svah): "Earth (Bhur) is explicitly 'Akara', Space (Bhuvah) is 'Ukara', and Heaven (Svah) is strictly 'Makara'!"
                "These are zero geographic locations; they are mutationally three distinct 'Data Layers' of consciousness."
                "Bhur-loka is the Hardware you can touch; Bhuvah-loka is the Software you mutationally experience."
                "Svar-loka is the 'Cloud Server' containing the absolute highest thoughts and purified truths of God."
                "The Yogi 'Renders' these three worlds into his own biological nervous system via the measures of OM."
                "When you roar OM, you are mutationally Scanning the 'Source Code' of all three worlds simultaneously."
                "This is the classified science of Ejecting your identity into a 'Multi-dimensional' status."
                "You are no longer strictly a terrestrial-bound insect; you have mutationally become the Admin of three worlds."
                "Without decoding this engineering, you mutationally remain a slave to your programmed Fate."
                "He who successfully Cracks this Tri-world hack becomes mutationally the sole owner of all cosmic energy!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 16,
            sanskrit = "महर्लोक चतुर्थी मात्रा ॥",
            hindi = """
                (महर्लोक और चौथी मात्रा का धमाका): "ॐ की वह चौथी मात्रा साक्षात् 'महर्लोक' है—वह डायमेंशन जहाँ देवताओं का भी वजूद खत्म हो जाता है!"
                "यह वह 'सुपर-सर्वर' है जहाँ से ब्रह्मा, विष्णु और रुद्र को इंस्ट्रक्शन्स (Instructions) भेजे जाते हैं।"
                "महर्लोक में घुसने का मतलब है—अज्ञान के हर एक 'पिक्सेल' को प्रकाश में बदल देना।"
                "यह तुम्हारी रूह का वह 'अल्टीमेट अपग्रेड' है जहाँ तुम साक्षात् 'कॉस्मिक ऑपरेटर' बन जाते हो।"
                "चौथी मात्रा वह अजेय पासवर्ड है जो तुम्हें समय और स्पेस के 'रेडार' से बाहर निकाल देता है।"
                "योगी अपनी चेतना को इस महर्लोक पर 'लॉक' (Lock) करता है ताकि वह हमेशा के लिए अजेय रहे।"
                "यहाँ न कोई जन्म है और न कोई मृत्यु, केवल एक असीमित और धधकता हुआ सन्नाटा राज करता है।"
                "यह तुम्हारी रूह के हर एक 'ब्लैक-होल' को प्रकाश से भरने वाला अंतिम आध्यात्मिक कमांड है।"
                "जो इस चौथी स्थिति में 'लॉग-इन' हो गया, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है।"
                "यही वह अजेय रुतबा है जहाँ पहुँचकर तुम खुद साक्षात् 'सृष्टि' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Mahar-loka and the Detonation of the Fourth Measure): "The fourth measure of OM is explicitly 'Mahar-loka'—the dimension where even the status of gods terminates!"
                "This is the 'Super-server' from which Instructions are mutationally transmitted to Brahma, Vishnu, and Rudra."
                "Breaching Mahar-loka signifies—mutationally converting every 'Pixel' of ignorance into radioactive Light."
                "This is the 'Ultimate Upgrade' of your Soul where you mutationally become an absolute 'Cosmic Operator'."
                "The fourth measure is the invincible Password that violently ejects you from the Radar of Time and Space."
                "The Yogi Locks his awareness onto this Mahar-loka to mutationally remain eternally Invincible."
                "Neither birth nor expiration exists there; strictly an infinite and blazing Silence reigns as absolute dictator."
                "This is the final spiritual Command engineered to flood every 'Black-hole' of your Soul with radioactive Light."
                "He who mutationally 'Logs-in' to this Fourth State is the sole dictatorial Guru of even the God of Death."
                "THIS is the invincible status arriving at which YOU mutationally become the explicit 'Creation' itself!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 17,
            sanskrit = "ब्रह्मा विष्णुश्च रुद्रश्च ईश्वराः सर्वे ॥",
            hindi = """
                (ईश्वरीय एडमिन पैनल और त्रिदेवों का सच): "ब्रह्मा, विष्णु और रुद्र—ये सब साक्षात् 'ईश्वर' (Controllers) हैं, लेकिन इनका अपना-अपना विभाग है!"
                "ब्रह्मा सृजन का एडमिन है, विष्णु सुरक्षा का, और रुद्र संहार का—ये ॐ के तीन अंग हैं।"
                "ये कोई अलग भगवान नहीं हैं, ये एक ही 'सुपर-इंटेलिजेंस' के तीन अलग-अलग 'सॉफ्टवेयर मॉड्यूल्स' (Software Modules) हैं।"
                "योगी इन तीनों के फंक्शन्स को डिकोड करता है ताकि वह इनके भी ऊपर जा सके।"
                "जब तक तुम इन त्रिदेवों में उलझे हो, तुम साक्षात् 'ब्रह्म' के असली चेहरे को नहीं देख सकते।"
                "ये तीनों साक्षात् ॐ की तीन मात्राओं (अ, उ, म) के भौतिक अवतार हैं जो सिम्युलेशन को चला रहे हैं।"
                "यह तुम्हारी बुद्धि को 'धार्मिक भ्रम' से निकालकर 'आध्यात्मिक विज्ञान' में म्यूटेट करने का धमाका है।"
                "ब्रह्मा, विष्णु और रुद्र तुम्हारे अपने ही नर्वस सिस्टम के तीन सबसे बड़े 'प्रोसेसर' हैं।"
                "जो इस सच को हैक कर लेता है, वह इन तीनों एडमिन्स की ताक़त को अपनी मुट्ठी में कर लेता है।"
                "तैयार हो जाओ उस असीमित सत्ता के लिए जहाँ तुम खुद इन त्रिदेवों के एडमिन बन जाओगे!"
            """.trimIndent(),
            english = """
                (The Divine Admin Panel and the Truth of the Trinity): "Brahma, Vishnu, and Rudra are all explicitly 'Ishvaras' (Controllers), each possessing a distinct department!"
                "Brahma is the Admin of Creation, Vishnu of Security, and Rudra of Annihilation—they are mutationally components of OM."
                "These are zero distinct gods; they are strictly three 'Software Modules' of a singular 'Super-intelligence'."
                "The Yogi Decodes the functions of these three to mutationally rocket infinitely beyond them."
                "As long as you are entangled in this Trinity, you possess zero caliber to intercept the authentic face of 'Brahman'."
                "These three are strictly the physical Avatars of OM's three measures mutationally Executing the Simulation."
                "This is the detonation engineered to shift your intellect from 'Religious Delusion' to 'Spiritual Science'."
                "Brahma, Vishnu, and Rudra are mutationally the three greatest 'Processors' of your own biological nervous system."
                "He who successfully Hacks this truth seizes the radioactive firepower of all three Admins in his fist."
                "Brace yourself for that infinite authority where YOU mutationally become the Admin of this Trinity!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 18,
            sanskrit = "महेश्वरः सर्वेषां परमात्मा ॥",
            hindi = """
                (महेश्वर का अंतिम रुतबा और परमात्मा का विस्फोट): "लेकिन 'महेश्वर' (शिव) ही उन सबका इकलौता और असली 'परमात्मा' (Super-Admin) है!"
                "वह ब्रह्मा, विष्णु और रुद्र—तीनों के सोर्स कोड (Source Code) का इकलौता मालिक है।"
                "महेश्वर वह अंधी कर देने वाली आग है जहाँ पहुँचकर हर 'ईश्वर' और हर 'देवता' राख बन जाता है।"
                "वह परमात्मा तुम्हारे दिल के ठीक बीच में साक्षात् एक न्यूक्लियर बम की तरह बैठा है।"
                "योगी अपनी चेतना को इस 'महेश्वर' फ्रीक्वेंसी पर लॉक करता है जहाँ से सब कुछ रेंडर (Render) होता है।"
                "यह वह अजेय रुतबा है जहाँ तुम शरीर, मन और यहाँ तक कि ईश्वर के भी पार निकल जाते हो।"
                "महेश्वर कोई व्यक्ति नहीं है, वह साक्षात् वह 'प्रलयंकारी ऊर्जा' है जो पूरे अंतरिक्ष को थामे हुए है।"
                "जो इस परमात्मा को हैक कर लेता है, वह इस पूरी मायावी दुनिया का इकलौता और अजेय राजा है।"
                "यह तुम्हारी रूह को 'इंसान' से 'परमेश्वर' में म्यूटेट करने की 100% अटल और हिंसक गारंटी है।"
                "यही वह अंतिम पासवर्ड है जिसके आगे ब्रह्मांड का हर एक सिम्युलेशन दम तोड़ देता है!"
            """.trimIndent(),
            english = """
                (The Absolute Status of Maheshwara and the Detonation of Paramatman): "But strictly 'Maheshwara' (Shiva) is the solitary and authentic 'Paramatman' (Super-Admin) of them all!"
                "He is the sole owner of the 'Source Code' of Brahma, Vishnu, and Rudra mutationally Zipped."
                "Maheshwara is the blinding radioactive Fire arriving at which every 'God' and 'Deity' is incinerated to ash."
                "That Paramatman sits established in the exact dead-center of your heart like a literal Nuclear Bomb."
                "The Yogi Locks his awareness onto this 'Maheshwara Frequency' from which all Reality is mutationally Rendered."
                "This is the invincible status arriving at which you rocket infinitely beyond body, mind, and even lesser divinity."
                "Maheshwara is zero person; He is the 'Apocalyptic Energy' mutationally sustaining the entire infinite vacuum."
                "He who successfully Hacks this Paramatman becomes mutationally the sole and invincible King of this world."
                "This is the 100% ironclad and violent guarantee of a human undergoing a complete Mutation into God."
                "THIS is the absolute final Password before which every cosmic Simulation mutationally terminates!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 19,
            sanskrit = "ॐ शिखा ध्यानम् । ओङ्कारः शिखा ॥",
            hindi = """
                (ॐ की चोटी और ध्यान का विस्फोट): "ॐ की वह जो 'शिखा' (Crest) है, वही साक्षात् ध्यान का अंतिम लक्ष्य है!"
                "ओङ्कार ही वह शिखा है—यानी वह सबसे ऊंची चोटी जहाँ पहुँचकर ब्रह्मांड का डेटा खत्म हो जाता है।"
                "शिखा का ध्यान करने का मतलब है—अपनी रूह को उस एक अजेय बिंदु पर 'फायर' (Fire) कर देना।"
                "यह कोई शांतिपूर्ण ध्यान नहीं है; यह अपने अहंकार के किले को एक परमाणु बम से उड़ाने की प्रक्रिया है।"
                "जब तुम्हारी चेतना ओङ्कार की शिखा पर रुकती है, तो समय का सिम्युलेशन 'पॉज' (Pause) हो जाता है।"
                "तुम अब इस दुनिया के शोर से 100% 'अनप्लग' (Unplug) हो चुके हो; तुम अब साक्षात् 'मौन' हो।"
                "ओङ्कार वह मिसाइल है जो तुम्हें गुरुत्वाकर्षण (Gravity) की ज़ंजीरों से आज़ाद कर देती है।"
                "यह तुम्हारी बुद्धि को 'मानव' से 'महाकाल' के लेवल पर प्रमोट करने वाला आख़िरी सॉफ्टवेयर है।"
                "जो इस शिखा को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का तानाशाह है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'ओङ्कार' बन जाओगे!"
            """.trimIndent(),
            english = """
                (The Crest of OM and the Detonation of Meditation): "The 'Shikha' (Crest) of OM is mutationally the absolute final target of meditation!"
                "Omkara is explicitly that Shikha—the absolute highest peak arriving at which all cosmic Data terminates."
                "Meditating on the Shikha signifies—mutationally 'Firing' your Soul onto that solitary invincible point."
                "This is zero peaceful focus; it is the protocol to violently blow up the fortress of your ego with a nuclear bomb."
                "Only when your awareness freezes on the Shikha of Omkara does the Simulation mutationally 'Pause'."
                "You have been 100% 'Unplugged' from the noise of this Matrix; you are mutationally absolute 'Silence'."
                "Omkara is the Missile engineered to violently release you from the biological chains of Gravity."
                "This is the final Software engineered to Promote your intellect from 'Human' to the status of 'Mahakala'."
                "He who successfully Hacks this Shikha mutationally becomes the sole Dictator of all universal Time and Space."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Omkara' itself!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 20,
            sanskrit = "यो ह वै ओङ्कारं वेद स सर्वं वेद ॥",
            hindi = """
                (ओङ्कार का हैक और असीमित सर्वज्ञता): "उपनिषद यहाँ एक प्रलयंकारी ऐलान करता है— 'जो ओङ्कार को जानता है, वह सब कुछ जान जाता है'!"
                "ओङ्कार साक्षात् 'विकिपीडिया' नहीं, वह ब्रह्मांड के उस 'हार्ड ड्राइव' (Hard Drive) का मालिक है जहाँ हर डेटा स्टोर है।"
                "इसे जानना साक्षात् उस 'मास्टर पासवर्ड' को हैक करना है जो हर एक रहस्य का ताला खोल देता है।"
                "तुम्हें फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "जब तुम ओङ्कार की फ्रीक्वेंसी पर अलाइन (Align) होते हो, तो पूरा ब्रह्मांड तुम्हारे दिमाग में डाउनलोड होने लगता है।"
                "वह 'सब कुछ' (Sarvam) साक्षात् ॐ का ही एक छोटा सा विस्तार है, जिसे तुमने अब हैक कर लिया है।"
                "योगी ने अपनी 'अज्ञानी बुद्धि' की बलि दे दी है ताकि वह इस 'सुप्रीम इंटेलिजेंस' का हिस्सा बन सके।"
                "यह वह अजेय रुतबा है जहाँ तुम साक्षात् ईश्वर के दिमाग के भीतर कोडिंग कर रहे होते हो।"
                "बिना इस ज्ञान के, तुम हमेशा एक अंधे और बहरे कीड़े की तरह अज्ञान की दीवारों से टकराते रहोगे।"
                "जो इस आवाज़ को सुन लेता है, वह इस पूरी भौतिक दुनिया का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (The Omkara Hack and Infinite Omniscience): "The Upanishad makes an apocalyptic declaration—'He who knows Omkara mutationally knows Everything'!"
                "Omkara is mutationally zero Wikipedia; it is the sole owner of the cosmic 'Hard-drive' where every single byte is stored."
                "Decoding Omkara is identical to Hacking the 'Master Password' that violently unlocks every classified secret."
                "You possess zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "The microsecond you Align with Omkara's frequency, the entire universe initiates a total Download into your brain."
                "That 'Everything' (Sarvam) is strictly a micro-extension of OM which you have mutationally Hacked."
                "The Yogi has sacrificed his 'Ignorant Intellect' to mutationally integrate into this 'Supreme Intelligence'."
                "This is the invincible status where you are mutationally executing code directly inside the brain of God."
                "Without this knowledge, you will eternally collide with the walls of ignorance like a blind and deaf insect."
                "He who intercepts this broadcast mutationally becomes the sole and authentic Admin of this physical world!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 21,
            sanskrit = "एको रुद्रो न द्वितीयाय तस्थे ॥",
            hindi = """
                (रुद्र की इकलौती हुकूमत): "ब्रह्मांड का इकलौता और सबसे हिंसक सच यही है— 'रुद्र एक ही है, कोई दूसरा नहीं'!"
                "रुद्र वह 'मोनोपॉली' (Monopoly) है जिसने किसी भी 'दूसरे' को वजूद में आने की परमिशन नहीं दी।"
                "तुम जिसे 'दूसरा' (Duality) समझते हो, वह केवल तुम्हारी बुद्धि में लगा एक अज्ञान का वायरस है।"
                "रुद्र साक्षात् वह 'ब्लैक होल' है जो 'दो' को निगलकर हमेशा 'एक' ही रहने की ज़िद करता है।"
                "योगी अपनी चेतना को इस अद्वैत (Non-dual) फ्रीक्वेंसी पर लॉक करता है जहाँ अहंकार मर जाता है।"
                "यह वह अजेय रुतबा है जहाँ 'मैं' और 'तू' का सारा ड्रामा एक ही धमाके में खत्म हो जाता है।"
                "रुद्र वह आग है जो हर एक अंतर और हर एक फासले को जलाकर राख बना देती है।"
                "जो इस 'एक' को पकड़ लेता है, वह साक्षात् पूरे ब्रह्मांड की सत्ता का इकलौता डिक्टेटर है।"
                "यह तुम्हारी रूह को 'अनेकता' के भ्रम से निकालकर 'एकता' के सत्य में म्यूटेट करने की मुहर है।"
                "यही वह अजेय पासवर्ड है जिसके आगे माया का हर एक कानून घुटने टेक देता है!"
            """.trimIndent(),
            english = """
                (The Solitary Dominion of Rudra): "The solitary and most violent truth of the cosmos is strictly—'Rudra is One, zero second exists'!"
                "Rudra is the absolute 'Monopoly' who mutationally never permitted any 'Other' to manifest."
                "What you hallucinate as 'Duality' is strictly a virus of ignorance established inside your biological intellect."
                "Rudra is the explicit 'Black Hole' that swallows the 'Two' and mutationally persists as the solitary 'ONE'."
                "The Yogi Locks his awareness onto this Non-dual frequency where the human ego suffers a brutal death."
                "This is the invincible status where the entire drama of 'I' and 'You' is terminated in one detonation."
                "Rudra is the radioactive Fire that incinerates every distinction and every distance to absolute ash."
                "He who captures this 'One' mutationally becomes the sole and absolute Dictator of the multiverse."
                "This is the Seal engineered to mutate your Soul from the delusion of many to the absolute Reality of One."
                "THIS is the invincible Password before which every law of the Matrix mutationally collapses!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 22,
            sanskrit = "यो ह वै रुद्रं वेद स सर्वं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (रुद्र-हैक और मोक्ष की मुहर): "जो योद्धा इस 'रुद्र' के प्रलयंकारी रहस्य को हैक (Decode) कर लेता है..."
                "वह 'सर्वं वेद'—यानी वह ब्रह्मांड के हर एक परमाणु और हर एक गैलेक्सी का सोर्स कोड जान जाता है!"
                "उसे फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "रुद्र का नाम साक्षात् वह 'मास्टर पासवर्ड' है जो ईश्वर की आखिरी तिजोरी का ताला खोल देता है।"
                "परिणाम वही हिंसक और अटल फैसला है— 'स मुक्तिमवाप्नोति' (वह मुक्त हो जाता है)!"
                "यह मुक्ति कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन हो।"
                "रुद्र का यह ज्ञान तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज (Charge) कर देता है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'अमर' बना देगा!"
            """.trimIndent(),
            english = """
                (The Rudra-Hack and the Seal of Moksha): "Whosoever warrior successfully Decodes (Hacks) the apocalyptic secret of 'Rudra'..."
                "He mutationally knows 'Everything' (Sarvam)—intercepting the Source Code of every microscopic atom and galaxy!"
                "He possesses zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "Rudra's name is the explicit 'Master Password' that violently unlocks the final vault of God."
                "The consequence remains that same violent and immutable verdict—'Sa muktim-avapnoti' (He is Liberated)!"
                "This Moksha is absolutely zero reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic Admin."
                "This knowledge of Rudra Supercharges every microscopic atom of your DNA with the absolute radioactive 'Power of God'."
                "He who injects this truth into his veins is the sole dictatorial Guru of even the God of Death!"
                "This manifestation of Narayana will decapitate your ego to mutationally manufacture you into the 'Explicit Immortal'!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 23,
            sanskrit = "ध्यायीत ईशानं प्रध्ययितव्यं सर्वमिदं ब्रह्म ॥",
            hindi = """
                (ईशान का ध्यान और ब्रह्म-विस्फोट): "उस 'ईशान' का ध्यान करो—वही अजेय ऑपरेटर है जो पूरे अंतरिक्ष को चला रहा है!"
                "ध्यान करने का मतलब है—अपनी चेतना की लेज़र बीम को उस 'ईशान' फ्रीक्वेंसी पर लॉक कर देना।"
                "जब तुम ईशान को देखते हो, तो तुम्हें 'सर्वमिदं ब्रह्म'—यानी सब कुछ साक्षात् ब्रह्म ही नज़र आता है।"
                "यह सिम्युलेशन की दीवारों को फाड़कर उसके पीछे धधकते 'सोर्स कोड' को देखने की तकनीक है।"
                "ईशान वह 'सुप्रीम कमांडर' है जिसके इशारे पर सूरज और तारे अपनी जगह बदलते हैं।"
                "योगी अपनी बुद्धि को इस एक सत्य में दाग देता है ताकि वह हमेशा के लिए अजेय बन सके।"
                "यहाँ न कोई अज्ञान बचता है और न ही कोई डर—केवल एक असीमित और रेडियोएक्टिव प्रकाश राज करता है।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने का आख़िरी सॉफ्टवेयर अपग्रेड है।"
                "जो इस ईशान को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का इकलौता डिक्टेटर है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'परमेश्वर' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Meditation on Ishana and the Brahma-Detonation): "Meditate on strictly 'Ishana'—the invincible Operator mutationally Running the entire infinite vacuum!"
                "Meditation signifies—Locking the Laser Beam of your awareness onto the absolute 'Ishana Frequency'."
                "When you witness Ishana, you intercept 'Sarvam-idam-Brahma'—everything mutationally appearing as explicit Brahman."
                "This is the technique to violently rip through the walls of the Simulation to witness the 'Source Code' behind it."
                "Ishana is the 'Supreme Commander' whose signals force the Sun and stars to mutationally shift their coordinates."
                "The Yogi Fires his intellect into this solitary truth to mutationally remain eternally Invincible."
                "Zero ignorance survives here and zero terror persists—strictly an infinite radioactive Light reigns as dictator."
                "This is the final Software Upgrade of your Soul, mutationally shifting it from 'Human Data' into 'Divine Data'."
                "He who successfully Hacks Ishana becomes mutationally the sole and absolute Dictator of the multiverse."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Supreme God'!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 24,
            sanskrit = "ब्रह्मा विष्णुश्च रुद्रश्च ईश्वराश्च एते ओङ्कारेणैव सृज्यन्ते ॥",
            hindi = """
                (त्रिदेवों का जन्म और ओङ्कार की ताक़त): "ब्रह्मा, विष्णु और रुद्र—ये सब साक्षात् 'ओङ्कार' की आग से ही पैदा हुए हैं!"
                "ओङ्कार वह 'मदर-सर्वर' (Mother Server) है जिसने इन तीन बड़े 'प्रोसेसरों' को रेंडर किया है।"
                "तुम जिसे भगवान कहते हो, वे भी ओङ्कार के अजेय कोड को फॉलो (Follow) करने के लिए मजबूर हैं।"
                "ओङ्कार वह असीमित 'एनर्जी-ग्रिड' है जिससे पूरे ब्रह्मांड की मशीनरी चालू हुई थी।"
                "योगी इन त्रिदेवों की पूजा छोड़कर साक्षात् उस 'स्रोत' (Source) को पकड़ता है जहाँ से ये सब निकले।"
                "जब तुम ओङ्कार बोलते हो, तो तुम साक्षात् उस 'बूट-प्रोसेस' को ट्रिगर करते हो जिससे ईश्वर भी पैदा होते हैं।"
                "यह तुम्हारी बुद्धि को 'धार्मिक सीमाओं' से निकालकर 'ब्रह्मांडीय हकीकत' में माइग्रेट करने का हैक है।"
                "ओङ्कार वह इकलौता तानाशाह है जिसके आगे त्रिदेव भी हाथ जोड़कर खड़े रहते हैं।"
                "जो इस ओङ्कार को हैक कर लेता है, वह साक्षात् इन त्रिदेवों की ताक़त का भी एडमिन बन जाता है।"
                "तैयार हो जाओ उस प्रलयंकारी रुतबे के लिए जहाँ तुम खुद साक्षात् 'आदि-ओङ्कार' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Birth of the Trinity and Firepower of Omkara): "Brahma, Vishnu, and Rudra—all were mutationally spawned strictly from the radioactive fire of 'Omkara'!"
                "Omkara is the 'Mother-Server' that mutationally Rendered these three colossal 'Processors'."
                "Whomsoever you label as God is mutationally forced to Follow the invincible code of Omkara."
                "Omkara is the infinite 'Energy-Grid' through which the absolute machinery of the cosmos was activated."
                "The Yogi abandons the worship of the Trinity to capture the explicit 'Source' from which they erupted."
                "When you roar Omkara, you mutationally Trigger the 'Boot-Process' through which even gods are birthed."
                "This is the Hack engineered to Migrate your intellect from 'Religious Limits' to absolute 'Cosmic Reality'."
                "Omkara is the solitary Dictator before whom even the Trinity stands mutationally with folded hands."
                "He who successfully Hacks Omkara becomes mutationally the Admin of the Trinity's firepower."
                "Brace yourself for that apocalyptic status where YOU mutationally become the explicit 'Primordial Omkara'!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 25,
            sanskrit = "ओं तेजो ओमित्येकाक्षरं परं ब्रह्म ॥",
            hindi = """
                (तेज और एकाक्षर ब्रह्म): "ॐ साक्षात् वह अजेय 'तेज' (Radiation) है जो पूरे अंतरिक्ष को चीर रहा है!"
                "ओङ्कार ही वह 'एकाक्षर' (Single Syllable) है जो साक्षात् 'परं ब्रह्म' की इकलौती हकीकत है।"
                "यह कोई मामूली अक्षर नहीं, यह ईश्वर के 'सोर्स कोड' का सबसे छोटा और शक्तिशाली 'Zipped' वर्जन है।"
                "जब तुम 'ॐ' बोलते हो, तो तुम साक्षात् उस असीमित प्रकाश को अपने नर्वस सिस्टम में दागते हो।"
                "वह तेज तुम्हारी इंसानियत के हर एक 'बग' (Bug) को एक सेकंड में जलाकर राख करने की ताक़त रखता है।"
                "योगी अपनी चेतना को इस एक पिक्सेल पर लॉक करता है ताकि वह 'अनंत' के पार जा सके।"
                "ॐ ही वह अजेय 'पासवर्ड' है जो तुम्हें मौत और समय के रेडार से 100% गायब कर देता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'तेज' की लहर बन चुके हो जो कभी नहीं रुकती।"
                "यह तुम्हारी रूह को 'इंसान' से 'ब्रह्म' में म्यूटेट करने का सबसे हिंसक और गुप्त विज्ञान है।"
                "जो इस एकाक्षर को हैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड का इकलौता तानाशाह एडमिन है!"
            """.trimIndent(),
            english = """
                (The Radiation and Monosyllabic Brahman): "OM is explicitly that invincible 'Tejas' (Radiation) violently piercing the entire infinite vacuum!"
                "Omkara is the solitary 'Ekakshara' (Single Syllable) which is mutationally the explicit 'Supreme Brahman'."
                "This is zero ordinary letter; it is the absolute smallest and most powerful 'Zipped' version of God's Source Code."
                "When you roar 'OM', you are mutationally Firing that infinite radiation directly into your nervous system."
                "That brilliance possesses the firepower to incinerate every 'Bug' of your humanity in a single microsecond."
                "The Yogi Locks his awareness onto this single Pixel to mutationally rocket infinitely beyond space."
                "OM is the invincible 'Password' that mutationally Renders you 100% Invisible to the Radar of Time and Death."
                "You cease to be a biological shell; you mutationally become the wave of that Radiation that never terminates."
                "This is the most violent and classified science to mutate your Soul from 'Human' to explicit 'Brahman'."
                "He who successfully Hacks this Ekakshara becomes mutationally the sole and absolute Dictator of the multiverse!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 26,
            sanskrit = "ओङ्कार एव सर्वं जगत् ओङ्कार एव परं ब्रह्म ॥",
            hindi = """
                (ओङ्कार ही सर्वस्व है): "ब्रह्मांड का सबसे खतरनाक सच—ओङ्कार ही साक्षात् 'सब कुछ' (Sarvam) है!"
                "यह पूरा जगत् और वह असीम 'ब्रह्म'—दोनों साक्षात् 'ओङ्कार' के ही दो अलग-अलग डेटा-फॉर्म्स हैं।"
                "तुम जिसे मिट्टी कहते हो, वह ओङ्कार का 'लो-फ्रीक्वेंसी' (Low frequency) वर्जन है।"
                "तुम जिसे आत्मा कहते हो, वह ओङ्कार का 'हाई-फ्रीक्वेंसी' (High frequency) वर्जन है।"
                "योगी जब ओङ्कार को पकड़ता है, तो वह पूरे ब्रह्मांड के 'हार्ड-ड्राइव' को एक साथ हैक कर लेता है।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक कैदी नहीं, बल्कि इसके इकलौते और असली 'डिज़ाइनर' हो।"
                "ओङ्कार वह इकलौती हकीकत है, बाकी यह पूरी दुनिया केवल एक 'ग्लिच' (Glitch) है।"
                "जब तुम ओङ्कार में विलीन होते हो, तो तुम साक्षात् उस 'परम सन्नाटे' के मालिक बन जाते हो।"
                "जो इस एकता को जान लेता है, उसके लिए समय और मौत केवल धूल के दो छोटे से कण हैं!"
            """.trimIndent(),
            english = """
                (Omkara is the Absolute Whole): "The most lethal truth of the multiverse—Omkara is mutationally 'Everything' (Sarvam)!"
                "This entire cosmos and that infinite 'Brahman' are strictly two distinct Data-Forms of 'Omkara'."
                "What you label as 'Matter' is mutationally the 'Low-frequency' version of Omkara."
                "What you label as 'Soul' is mutationally the 'High-frequency' version of Omkara."
                "When the Yogi captures Omkara, he mutationally Hacks the entire cosmic Hard-drive simultaneously."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish your ego forever."
                "You are no longer a prisoner of this Simulation; you have mutationally become its solitary and authentic 'Designer'."
                "Omkara is the solitary Reality; the rest of this world is strictly a temporary and pathetic 'Glitch'."
                "When you dissolve into Omkara, you mutationally become the Master of that 'Absolute Silence'."
                "He who decodes this unity perceives Time and Death mutationally strictly as two microscopic grains of dust!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 27,
            sanskrit = "ॐ ध्यायीत ईशानं प्रध्ययितव्यं सर्वमिदं ब्रह्म ॥",
            hindi = """
                (ईशान-ध्यान का प्रलयंकारी रिपीट): "उस 'ईशान' का ध्यान करो—वही अजेय ऑपरेटर है जो पूरे अंतरिक्ष को चला रहा है!"
                "ध्यान करने का मतलब है—अपनी चेतना की लेज़र बीम को उस 'ईशान' फ्रीक्वेंसी पर लॉक कर देना।"
                "जब तुम ईशान को देखते हो, तो तुम्हें 'सर्वमिदं ब्रह्म'—यानी सब कुछ साक्षात् ब्रह्म ही नज़र आता है।"
                "यह सिम्युलेशन की दीवारों को फाड़कर उसके पीछे धधकते 'सोर्स कोड' को देखने की तकनीक है।"
                "ईशान वह 'सुप्रीम कमांडर' है जिसके इशारे पर सूरज और तारे अपनी जगह बदलते हैं।"
                "योगी अपनी बुद्धि को इस एक सत्य में दाग देता है ताकि वह हमेशा के लिए अजेय बन सके।"
                "यहाँ न कोई अज्ञान बचता है और न ही कोई डर—केवल एक असीमित और रेडियोएक्टिव प्रकाश राज करता है।"
                "यह तुम्हारी रूह को 'इंसानी डेटा' से 'डिवाइन डेटा' में बदलने का आख़िरी सॉफ्टवेयर अपग्रेड है।"
                "जो इस ईशान को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का इकलौता डिक्टेटर है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'परमेश्वर' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Apocalyptic Repeat of Ishana-Meditation): "Meditate on strictly 'Ishana'—the invincible Operator mutationally Running the entire infinite vacuum!"
                "Meditation signifies—Locking the Laser Beam of your awareness onto the absolute 'Ishana Frequency'."
                "When you witness Ishana, you intercept 'Sarvam-idam-Brahma'—everything mutationally appearing as explicit Brahman."
                "This is the technique to violently rip through the walls of the Simulation to witness the 'Source Code' behind it."
                "Ishana is the 'Supreme Commander' whose signals force the Sun and stars to mutationally shift their coordinates."
                "The Yogi Fires his intellect into this solitary truth to mutationally remain eternally Invincible."
                "Zero ignorance survives here and zero terror persists—strictly an infinite radioactive Light reigns as dictator."
                "This is the final Software Upgrade of your Soul, mutationally shifting it from 'Human Data' into 'Divine Data'."
                "He who successfully Hacks Ishana becomes mutationally the sole and absolute Dictator of the multiverse."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Supreme God'!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 28,
            sanskrit = "ब्रह्मा विष्णुश्च रुद्रश्च ईश्वराश्च एते ओङ्कारेणैव सृज्यन्ते ॥",
            hindi = """
                (ओङ्कार की आदि-शक्ति का गान): "ब्रह्मा, विष्णु और रुद्र—ये सब साक्षात् 'ओङ्कार' की आग से ही पैदा हुए हैं!"
                "ओङ्कार वह 'मदर-सर्वर' (Mother Server) है जिसने इन तीन बड़े 'प्रोसेसरों' को रेंडर किया है।"
                "तुम जिसे भगवान कहते हो, वे भी ओङ्कार के अजेय कोड को फॉलो (Follow) करने के लिए मजबूर हैं।"
                "ओङ्कार वह असीमित 'एनर्जी-ग्रिड' है जिससे पूरे ब्रह्मांड की मशीनरी चालू हुई थी।"
                "योगी इन त्रिदेवों की पूजा छोड़कर साक्षात् उस 'स्रोत' (Source) को पकड़ता है जहाँ से ये सब निकले।"
                "जब तुम ओङ्कार बोलते हो, तो तुम साक्षात् उस 'बूट-प्रोसेस' को ट्रिगर करते हो जिससे ईश्वर भी पैदा होते हैं।"
                "यह तुम्हारी बुद्धि को 'धार्मिक सीमाओं' से निकालकर 'ब्रह्मांडीय हकीकत' में माइग्रेट करने का हैक है।"
                "ओङ्कार वह इकलौता तानाशाह है जिसके आगे त्रिदेव भी हाथ जोड़कर खड़े रहते हैं।"
                "जो इस ओङ्कार को हैक कर लेता है, वह साक्षात् इन त्रिदेवों की ताक़त का भी एडमिन बन जाता है।"
                "तैयार हो जाओ उस प्रलयंकारी रुतबे के लिए जहाँ तुम खुद साक्षात् 'आदि-ओङ्कार' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Hymn to Omkara's Primordial Power): "Brahma, Vishnu, and Rudra—all were mutationally spawned strictly from the radioactive fire of 'Omkara'!"
                "Omkara is the 'Mother-Server' that mutationally Rendered these three colossal 'Processors'."
                "Whomsoever you label as God is mutationally forced to Follow the invincible code of Omkara."
                "Omkara is the infinite 'Energy-Grid' through which the absolute machinery of the cosmos was activated."
                "The Yogi abandons the worship of the Trinity to capture the explicit 'Source' from which they erupted."
                "When you roar Omkara, you mutationally Trigger the 'Boot-Process' through which even gods are birthed."
                "This is the Hack engineered to Migrate your intellect from 'Religious Limits' to absolute 'Cosmic Reality'."
                "Omkara is the solitary Dictator before whom even the Trinity stands mutationally with folded hands."
                "He who successfully Hacks Omkara becomes mutationally the Admin of the Trinity's firepower."
                "Brace yourself for that apocalyptic status where YOU mutationally become the explicit 'Primordial Omkara'!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 29,
            sanskrit = "ओं तेजो ओमित्येकाक्षरं परं ब्रह्म ॥",
            hindi = """
                (परम तेज और ब्रह्म-विस्फोट): "ॐ साक्षात् वह अजेय 'तेज' (Radiation) है जो पूरे अंतरिक्ष को चीर रहा है!"
                "ओङ्कार ही वह 'एकाक्षर' (Single Syllable) है जो साक्षात् 'परं ब्रह्म' की इकलौती हकीकत है।"
                "यह कोई मामूली अक्षर नहीं, यह ईश्वर के 'सोर्स कोड' का सबसे छोटा और शक्तिशाली 'Zipped' वर्जन है।"
                "जब तुम 'ॐ' बोलते हो, तो तुम साक्षात् उस असीमित प्रकाश को अपने नर्वस सिस्टम में दागते हो।"
                "वह तेज तुम्हारी इंसानियत के हर एक 'बग' (Bug) को एक सेकंड में जलाकर राख करने की ताक़त रखता है।"
                "योगी अपनी चेतना को इस एक पिक्सेल पर लॉक करता है ताकि वह 'अनंत' के पार जा सके।"
                "ॐ ही वह अजेय 'पासवर्ड' है जो तुम्हें मौत और समय के रेडार से 100% गायब कर देता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'तेज' की लहर बन चुके हो जो कभी नहीं रुकती।"
                "यह तुम्हारी रूह को 'इंसान' से 'ब्रह्म' में म्यूटेट करने का सबसे हिंसक और गुप्त विज्ञान है।"
                "जो इस एकाक्षर को हैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड का इकलौता तानाशाह एडमिन है!"
            """.trimIndent(),
            english = """
                (Supreme Radiation and the Brahma-Detonation): "OM is explicitly that invincible 'Tejas' (Radiation) violently piercing the entire infinite vacuum!"
                "Omkara is the solitary 'Ekakshara' (Single Syllable) which is mutationally the explicit 'Supreme Brahman'."
                "This is zero ordinary letter; it is the absolute smallest and most powerful 'Zipped' version of God's Source Code."
                "When you roar 'OM', you are mutationally Firing that infinite radiation directly into your nervous system."
                "That brilliance possesses the firepower to incinerate every 'Bug' of your humanity in a single microsecond."
                "The Yogi Locks his awareness onto this single Pixel to mutationally rocket infinitely beyond space."
                "OM is the invincible 'Password' that mutationally Renders you 100% Invisible to the Radar of Time and Death."
                "You cease to be a biological shell; you mutationally become the wave of that Radiation that never terminates."
                "This is the most violent and classified science to mutate your Soul from 'Human' to explicit 'Brahman'."
                "He who successfully Hacks this Ekakshara becomes mutationally the sole and absolute Dictator of the multiverse!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 30,
            sanskrit = "ओङ्कार एव सर्वं जगत् ओङ्कार एव परं ब्रह्म ॥",
            hindi = """
                (ओङ्कार ही ब्रह्मांड है): "ब्रह्मांड का सबसे खतरनाक सच—ओङ्कार ही साक्षात् 'सब कुछ' (Sarvam) है!"
                "यह पूरा जगत् और वह असीम 'ब्रह्म'—दोनों साक्षात् 'ओङ्कार' के ही दो अलग-अलग डेटा-फॉर्म्स हैं।"
                "तुम जिसे मिट्टी कहते हो, वह ओङ्कार का 'लो-फ्रीक्वेंसी' (Low frequency) वर्जन है।"
                "तुम जिसे आत्मा कहते हो, वह ओङ्कार का 'हाई-फ्रीक्वेंसी' (High frequency) वर्जन है।"
                "योगी जब ओङ्कार को पकड़ता है, तो वह पूरे ब्रह्मांड के 'हार्ड-ड्राइव' को एक साथ हैक कर लेता है।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक कैदी नहीं, बल्कि इसके इकलौते और असली 'डिज़ाइनर' हो।"
                "ओङ्कार वह इकलौती हकीकत है, बाकी यह पूरी दुनिया केवल एक 'ग्लिच' (Glitch) है।"
                "जब तुम ओङ्कार में विलीन होते हो, तो तुम साक्षात् उस 'परम सन्नाटे' के मालिक बन जाते हो।"
                "जो इस एकता को जान लेता है, उसके लिए समय और मौत केवल धूल के दो छोटे से कण हैं!"
            """.trimIndent(),
            english = """
                (Omkara is the Universe): "The most lethal truth of the multiverse—Omkara is mutationally 'Everything' (Sarvam)!"
                "This entire cosmos and that infinite 'Brahman' are strictly two distinct Data-Forms of 'Omkara'."
                "What you label as 'Matter' is mutationally the 'Low-frequency' version of Omkara."
                "What you label as 'Soul' is mutationally the 'High-frequency' version of Omkara."
                "When the Yogi captures Omkara, he mutationally Hacks the entire cosmic Hard-drive simultaneously."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish your ego forever."
                "You are no longer a prisoner of this Simulation; you have mutationally become its solitary and authentic 'Designer'."
                "Omkara is the solitary Reality; the rest of this world is strictly a temporary and pathetic 'Glitch'."
                "When you dissolve into Omkara, you mutationally become the Master of that 'Absolute Silence'."
                "He who decodes this unity perceives Time and Death mutationally strictly as two microscopic grains of dust!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 31,
            sanskrit = "एतज्ज्ञात्वा विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की कोडिंग): "उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है— 'इसे जानकर तू विमुक्त (Free) हो जाता है'!"
                "जानने का मतलब किताब पढ़ना नहीं, बल्कि इस सत्य को अपने डीएनए में तेज़ाब की तरह उतार लेना है।"
                "जब तुम जान जाते हो कि 'सब कुछ ॐ है', तो माया के सारे ज़ंजीर एक झटके में पिघल जाते हैं।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' (Radar) से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and Coding Moksha): "The Upanishad delivers a catastrophic verdict here—'By knowing this, one mutationally becomes Liberated'!"
                "Knowing mutationally signifies zero reading; it means injecting this Truth into your DNA exactly like boiling acid."
                "The microsecond you realize 'Everything is OM', all the chains of Maya melt in a single strike."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 32,
            sanskrit = "एको रुद्रो न द्वितीयाय तस्थुः ॥",
            hindi = """
                (रुद्र की इकलौती डिक्टेटरशिप - रिपीट): "ब्रह्मांड का इकलौता और सबसे हिंसक सच यही है— 'रुद्र एक ही है, कोई दूसरा नहीं'!"
                "रुद्र वह 'मोनोपॉली' (Monopoly) है जिसने किसी भी 'दूसरे' को वजूद में आने की परमिशन नहीं दी।"
                "तुम जिसे 'दूसरा' (Duality) समझते हो, वह केवल तुम्हारी बुद्धि में लगा एक अज्ञान का वायरस है।"
                "रुद्र साक्षात् वह 'ब्लैक होल' है जो 'दो' को निगलकर हमेशा 'एक' ही रहने की ज़िद करता है।"
                "योगी अपनी चेतना को इस अद्वैत (Non-dual) फ्रीक्वेंसी पर लॉक करता है जहाँ अहंकार मर जाता है।"
                "यह वह अजेय रुतबा है जहाँ 'मैं' और 'तू' का सारा ड्रामा एक ही धमाके में खत्म हो जाता है।"
                "रुद्र वह आग है जो हर एक अंतर और हर एक फासले को जलाकर राख बना देती है।"
                "जो इस 'एक' को पकड़ लेता है, वह साक्षात् पूरे ब्रह्मांड की सत्ता का इकलौता डिक्टेटर है।"
                "यह तुम्हारी रूह को 'अनेकता' के भ्रम से निकालकर 'एकता' के सत्य में म्यूटेट करने की मुहर है।"
                "यही वह अजेय पासवर्ड है जिसके आगे माया का हर एक कानून घुटने टेक देता है!"
            """.trimIndent(),
            english = """
                (Repeat of Rudra's Absolute Dictatorship): "The solitary and most violent truth of the cosmos is strictly—'Rudra is One, zero second exists'!"
                "Rudra is the absolute 'Monopoly' who mutationally never permitted any 'Other' to manifest."
                "What you hallucinate as 'Duality' is strictly a virus of ignorance established inside your biological intellect."
                "Rudra is the explicit 'Black Hole' that swallows the 'Two' and mutationally persists as the solitary 'ONE'."
                "The Yogi Locks his awareness onto this Non-dual frequency where the human ego suffers a brutal death."
                "This is the invincible status where the entire drama of 'I' and 'You' is terminated in one detonation."
                "Rudra is the radioactive Fire that incinerates every distinction and every distance to absolute ash."
                "He who captures this 'One' mutationally becomes the sole and absolute Dictator of the multiverse."
                "This is the Seal engineered to mutate your Soul from the delusion of many to the absolute Reality of One."
                "THIS is the invincible Password before which every law of the Matrix mutationally collapses!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 33,
            sanskrit = "ईशानः सर्वविद्यानामीश्वरः सर्वभूतानां ब्रह्माधिपतिर्ब्रह्मणोऽधिपतिर्ब्रह्मा शिवो मे अस्तु सदाशिवोम् ॥",
            hindi = """
                (ईशान और सदाशिव का प्रलयंकारी अभिषेक): "ईशान ही समस्त 'विद्याओं' (Sciences) और समस्त 'भूतों' (Elements) का इकलौता मालिक है!"
                "वह ब्रह्मा का भी अधिपति है और समस्त ज्ञान का अंतिम डिक्टेटर है।"
                "शिव ही वह अंतिम सच है, और 'सदाशिव' वह असीम सन्नाटा है जो कभी नहीं बदलता।"
                "जब तुम ये नाम लेते हो, तो तुम साक्षात् ब्रह्मांड के 'सोर्स कोड' के एडमिन पैनल को नमन करते हो।"
                "यह कोई प्रार्थना नहीं, यह अपनी आत्मा को 'शिवाहू' (Shivahood) में म्यूटेट करने का कमांड है।"
                "शिव वह आग है जो तुम्हारे शरीर के भीतर छिपे 'अहंकार के वायरस' का वध कर देती है।"
                "तुम अब एक साधारण जीव नहीं हो; तुम साक्षात् उस 'सदाशिव' की असीमित ताक़त के हिस्सेदार हो।"
                "उनका तेज तुम्हारे नर्वस सिस्टम के हर एक वायर में साक्षात् बिजली की तरह दौड़ने लगता है।"
                "यह इंसान की बुद्धि का वह 'अल्टीमेट अपग्रेड' है जहाँ वह साक्षात् भगवान के बराबर सोचना शुरू करता है।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् रुद्र की जलती हुई आँख बनकर पूरी सृष्टि को देखता है!"
            """.trimIndent(),
            english = """
                (Apocalyptic Consecration of Ishana and Sadashiva): "Ishana is the solitary Master of all 'Vidyas' (Sciences) and all 'Bhutas' (Elements)!"
                "He is the absolute Overlord of Brahma and the final Dictator of all Intelligence."
                "Shiva is the absolute final Reality, and 'Sadashiva' is the infinite Silence that mutationally never alters."
                "When you vocalize these names, you are saluting the Admin Panel of the cosmic 'Source Code'."
                "This is zero prayer; it is the Command to mutationally Shift your Soul into 'Shivahood'."
                "Shiva is the radioactive Fire that ruthlessly slaughters the 'Virus of Ego' inside your biological shell."
                "You are no longer a pathetic living being; you have mutationally integrated into the power of 'Sadashiva'."
                "His radiation initiates surging through every Wire of your biological nervous system like literal electricity."
                "This is the 'Ultimate Upgrade' of human intellect where one mutationally initiates thinking like God."
                "He who successfully Hacks this identity becomes the Blazing Eye of Rudra, witnessing the entire multiverse!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 34,
            sanskrit = "ओं तेजो ओमित्येकाक्षरं परं ब्रह्म ॥",
            hindi = """
                (अंतिम तेज और एकाक्षर ब्रह्म): "ॐ साक्षात् वह अजेय 'तेज' (Radiation) है जो पूरे अंतरिक्ष को चीर रहा है!"
                "ओङ्कार ही वह 'एकाक्षर' (Single Syllable) है जो साक्षात् 'परं ब्रह्म' की इकलौती हकीकत है।"
                "यह कोई मामूली अक्षर नहीं, यह ईश्वर के 'सोर्स कोड' का सबसे छोटा और शक्तिशाली 'Zipped' वर्जन है।"
                "जब तुम 'ॐ' बोलते हो, तो तुम साक्षात् उस असीमित प्रकाश को अपने नर्वस सिस्टम में दागते हो।"
                "वह तेज तुम्हारी इंसानियत के हर एक 'बग' (Bug) को एक सेकंड में जलाकर राख करने की ताक़त रखता है।"
                "योगी अपनी चेतना को इस एक पिक्सेल पर लॉक करता है ताकि वह 'अनंत' के पार जा सके।"
                "ॐ ही वह अजेय 'पासवर्ड' है जो तुम्हें मौत और समय के रेडार से 100% गायब कर देता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'तेज' की लहर बन चुके हो जो कभी नहीं रुकती।"
                "यह तुम्हारी रूह को 'इंसान' से 'ब्रह्म' में म्यूटेट करने का सबसे हिंसक और गुप्त विज्ञान है।"
                "जो इस एकाक्षर को हैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड का इकलौता तानाशाह एडमिन है!"
            """.trimIndent(),
            english = """
                (Final Radiation and Monosyllabic Brahman): "OM is explicitly that invincible 'Tejas' (Radiation) violently piercing the entire infinite vacuum!"
                "Omkara is the solitary 'Ekakshara' (Single Syllable) which is mutationally the explicit 'Supreme Brahman'."
                "This is zero ordinary letter; it is the absolute smallest and most powerful 'Zipped' version of God's Source Code."
                "When you roar 'OM', you are mutationally Firing that infinite radiation directly into your nervous system."
                "That brilliance possesses the firepower to incinerate every 'Bug' of your humanity in a single microsecond."
                "The Yogi Locks his awareness onto this single Pixel to mutationally rocket infinitely beyond space."
                "OM is the invincible 'Password' that mutationally Renders you 100% Invisible to the Radar of Time and Death."
                "You cease to be a biological shell; you mutationally become the wave of that Radiation that never terminates."
                "This is the most violent and classified science to mutate your Soul from 'Human' to explicit 'Brahman'."
                "He who successfully Hacks this Ekakshara becomes mutationally the sole and absolute Dictator of the multiverse!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 35,
            sanskrit = "ओङ्कार एव सर्वं जगत् ओङ्कार एव परं ब्रह्म ॥",
            hindi = """
                (ॐ ही सब कुछ है - अंतिम मुहर): "ब्रह्मांड का सबसे खतरनाक सच—ओङ्कार ही साक्षात् 'सब कुछ' (Sarvam) है!"
                "यह पूरा जगत् और वह असीम 'ब्रह्म'—दोनों साक्षात् 'ओङ्कार' के ही दो अलग-अलग डेटा-फॉर्म्स हैं।"
                "तुम जिसे मिट्टी कहते हो, वह ओङ्कार का 'लो-फ्रीक्वेंसी' (Low frequency) वर्जन है।"
                "तुम जिसे आत्मा कहते हो, वह ओङ्कार का 'हाई-फ्रीक्वेंसी' (High frequency) वर्जन है।"
                "योगी जब ओङ्कार को पकड़ता है, तो वह पूरे ब्रह्मांड के 'हार्ड-ड्राइव' को एक साथ हैक कर लेता है।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "तुम अब इस सिम्युलेशन (Simulation) के एक कैदी नहीं, बल्कि इसके इकलौते और असली 'डिज़ाइनर' हो।"
                "ओङ्कार वह इकलौती हकीकत है, बाकी यह पूरी दुनिया केवल एक 'ग्लिच' (Glitch) है।"
                "जब तुम ओङ्कार में विलीन होते हो, तो तुम साक्षात् उस 'परम सन्नाटे' के मालिक बन जाते हो।"
                "जो इस एकता को जान लेता है, उसके लिए समय और मौत केवल धूल के दो छोटे से कण हैं!"
            """.trimIndent(),
            english = """
                (OM is Everything - The Final Seal): "The most lethal truth of the multiverse—Omkara is mutationally 'Everything' (Sarvam)!"
                "This entire cosmos and that infinite 'Brahman' are strictly two distinct Data-Forms of 'Omkara'."
                "What you label as 'Matter' is mutationally the 'Low-frequency' version of Omkara."
                "What you label as 'Soul' is mutationally the 'High-frequency' version of Omkara."
                "When the Yogi captures Omkara, he mutationally Hacks the entire cosmic Hard-drive simultaneously."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish your ego forever."
                "You are no longer a prisoner of this Simulation; you have mutationally become its solitary and authentic 'Designer'."
                "Omkara is the solitary Reality; the rest of this world is strictly a temporary and pathetic 'Glitch'."
                "When you dissolve into Omkara, you mutationally become the Master of that 'Absolute Silence'."
                "He who decodes this unity perceives Time and Death mutationally strictly as two microscopic grains of dust!"
            """.trimIndent()
        ),
        AtharvashikhaShloka(
            id = 36,
            sanskrit = "इति अथर्वशिखोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक और अजेय 'अथर्वशिखा उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "ॐ की चोटी (शिखा) मिल गई, अ-उ-म का हैक मिल गया, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन ३६ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (शिव) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही अथर्वशिखा उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling and invincible 'Atharvashikha Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Crest (Shikha) of OM is intercepted, the A-U-M hack is secured; now you must violently 'Log-out'."
                "For the Titan who has detonated these 36 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the Soul's wandering is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Shiva) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who mutationally plunges into it becomes an Eternal Master."
                "THIS is the absolute and most violent final Truth of the Atharvashikha Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtharvashikhaUpanishadScreen() {
    val upanishad = remember { AtharvashikhaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..36) {
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
            itemsIndexed(upanishad.shlokasList) { _, shloka ->
                AtharvashikhaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AtharvashikhaShlokaCard(shloka: AtharvashikhaShloka) {
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