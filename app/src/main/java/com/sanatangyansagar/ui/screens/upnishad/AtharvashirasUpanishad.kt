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
data class AtharvashirasShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class AtharvashirasUpanishad {

    val shlokasList = listOf(
        AtharvashirasShloka(
            id = 1,
            sanskrit = "ॐ देवा ह वै स्वर्गं लोकमगमन् ते देवा रुद्रमपृच्छन् को भवानिति ॥",
            hindi = """
                (स्वर्ग में घुसपैठ और रुद्र का इंटरोगेशन): "देवताओं ने स्वर्ग के 'फायरवॉल' को तोड़कर रुद्र के 'एडमिन पैनल' में घुसपैठ की।"
                "उन्होंने सीधे 'सोर्स कोड' से सवाल किया—'को भवानिति' यानी तू असली तानाशाह कौन है?"
                "यह कोई साधारण जिज्ञासा नहीं थी; यह सिम्युलेशन (Simulation) के मालिक को पहचानने की कोशिश थी।"
                "देवता उस अंधी कर देने वाली रौशनी के आगे अपनी हस्ती को राख होते महसूस कर रहे थे।"
                "रुद्र वह 'प्राइमरी प्रोसेसर' है जिसके बिना स्वर्ग का हार्डवेयर भी एक कबाड़ है।"
                "पूरा अंतरिक्ष एक सांस रोककर उस जवाब का इंतज़ार कर रहा था जो हकीकत को बदल दे।"
                "योगी अपनी चेतना को उस 'हाइपर-स्पेस' में ले जाता है जहाँ ये सवाल पूछा गया था।"
                "जब तुम भगवान से पूछते हो 'तुम कौन हो', तो तुम्हारा अपना 'मैं' मरना शुरू हो जाता है।"
                "तैयार हो जाओ उस धमाके के लिए जो देवताओं के भी होश उड़ा देने वाला है।"
                "यहीं से उस अजेय 'अथर्वशिर' का प्रलयंकारी डेटा-स्ट्रीम शुरू होता है!"
            """.trimIndent(),
            english = """
                (Infiltrating Heaven and Interrogating Rudra): "The Devas breached the Firewall of heaven to infiltrate Rudra’s absolute Admin Panel."
                "They interrogated the 'Source Code' directly: 'Who exactly are You, the solitary Dictator?'"
                "This was zero ordinary curiosity; it was an attempt to identify the Master of the Simulation."
                "The gods felt their micro-identities mutationally incinerating before that blinding radiation."
                "Rudra is the 'Primary Processor' without whom the hardware of heaven is strictly junk."
                "The entire infinite vacuum held its breath, awaiting the response that would rewrite reality."
                "The Yogi transports his awareness into that 'Hyper-space' where this interrogation occurred."
                "When you demand God to reveal Himself, your own human ego initiates its brutal death."
                "Brace yourself for the detonation that will mutationally shatter the intellect of the gods."
                "Right here initiates the apocalyptic Data-stream of the invincible Atharvashiras!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 2,
            sanskrit = "सोऽब्रवीदहमेकः प्रथममासं वर्तामि च भविष्यामि च नान्यः कश्चिन्मत्तो व्यतिरिक्त इति ॥",
            hindi = """
                (रुद्र की डिक्टेटरशिप और 'अकेला सच'): "रुद्र ने दहाड़ मारी: 'मैं ही वह इकलौता 'सोर्स कोड' हूँ जो समय के बिग-बैंक से पहले भी था!'"
                "मैं ही अभी 'एक्जीक्यूट' (Execute) हो रहा हूँ और भविष्य का सारा डेटा भी मैं ही हूँ!"
                "मेरे अलावा इस पूरे सिस्टम में कोई दूसरा 'डेटा पैकेट' वजूद नहीं रखता।"
                "यह ब्रह्मांड का सबसे हिंसक 'मैं हूँ' (I AM) है जो हर दूसरे वजूद को डिलीट कर देता है।"
                "रुद्र वह 'मोनोपॉली' है जिसने किसी भी दूसरे ऑपरेटर को पैदा ही नहीं होने दिया।"
                "तुम जिसे 'दूसरा' समझते हो, वह केवल रुद्र के दिमाग का एक छोटा सा 'ग्लिच' (Glitch) है।"
                "उनकी सत्ता के बाहर एक परमाणु की भी औकात नहीं कि वह अपनी फ्रीक्वेंसी बदल सके।"
                "यह वह 'एब्सोल्यूट जीरो' है जहाँ पहुँचकर हर रिश्ता और हर पहचान भाप बन जाती है।"
                "योगी जब इस आवाज़ को सुनता है, तो उसका अपना अहंकार डर से पत्थर हो जाता है।"
                "रुद्र ही वह इकलौती हकीकत हैं, बाकी यह पूरी दुनिया केवल एक 'फेक कोडिंग' है!"
            """.trimIndent(),
            english = """
                (Rudra's Dictatorship and the 'Solitary Truth'): "Rudra roared: 'I am the solitary Source Code that was blazing before the Big Bang of Time!'"
                "I am the code currently being Executed, and I am mutationally every byte of the future!"
                "Zero other 'Data Packet' possesses the status to exist distinct from My authority."
                "This is the most violent 'I AM' of the cosmos, mutationally Deleting every other existence."
                "Rudra is the absolute Monopoly who mutationally never permitted another Operator to manifest."
                "What you hallucinate as 'Another' is strictly a microscopic 'Glitch' in the brain of Rudra."
                "Beyond His authority, zero atom possesses the caliber to even alter its vibration."
                "This is the 'Absolute Zero' reaching which every relationship and identity vaporizes into nothingness."
                "When the Yogi intercepts this voice, his own ego mutationally turns to stone in absolute terror."
                "Rudra is the solitary Reality; the rest of this world is strictly 'Fake Coding'!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 3,
            sanskrit = "व्यतिरिक्तं च नित्यं चानित्यं च ब्रह्माहं च ॥",
            hindi = """
                (परम पहचान और विरोधाभास का संहार): "रुद्र ने घोषित किया: 'मैं ही वह सब कुछ हूँ जो इस सिस्टम से अलग (व्यतिरिक्त) दिखता है!'"
                "मैं ही 'नित्य' (Permanent Data) हूँ और मैं ही 'अनित्य' (Temporary Simulation) हूँ!"
                "मैं ही साक्षात् 'ब्रह्म' हूँ—यानी वह असीम ऊर्जा जो हर चीज़ को चला रही है।"
                "रुद्र वह 'यूनिवर्सल ओएस' (Universal OS) है जो विरोधाभासों को एक साथ रन (Run) करता है।"
                "जब तुम मरते हो तो तुम रुद्र के अनित्य फोल्डर में होते हो, जब जागते हो तो नित्य में।"
                "यह कोडिंग इतनी जटिल है कि तुम्हारी बुद्धि इसे कभी डिकोड नहीं कर सकती।"
                "योगी अपनी चेतना को उस 'ब्रह्म-फ्रीक्वेंसी' पर लॉक करता है जहाँ नित्य-अनित्य का भेद मर जाता है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् रुद्र के दिमाग का एक 'एक्टिव थॉट' (Active Thought) हो।"
                "रुद्र की यह घोषणा तुम्हारे दिमाग के हर पुराने 'सॉफ्टवेयर बग' को जलाकर राख कर देगी।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड का इकलौता एडमिन बन जाता है!"
            """.trimIndent(),
            english = """
                (Supreme Identity and the Slaughter of Paradox): "Rudra declared: 'I am mutationally everything that appears distinct (Vyatirikta) from the system!'"
                "I am the 'Permanent Data' (Nitya) and I am the 'Temporary Simulation' (Anitya) simultaneously!"
                "I am the explicit 'Brahman'—the infinite energy relentlessly operating every microscopic particle."
                "Rudra is the 'Universal OS' that Runs paradoxical data-streams mutationally as a single unit."
                "When you perish, you are in His temporary folder; when you Awaken, you are in the Eternal."
                "This coding is so horrific that your biological brain possesses zero caliber to decode it."
                "The Yogi Locks his awareness onto the 'Brahma-Frequency' where the duality of time perishes."
                "You are no longer a biological shell; you are an 'Active Thought' inside the brain of Rudra."
                "This declaration of Rudra will incinerate every 'Software Bug' in your brain to radioactive ash."
                "He who successfully Hacks this identity becomes mutationally the sole Admin of the entire multiverse!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 4,
            sanskrit = "दिशश्च प्रदिशश्च अहमेव सर्वम् ॥",
            hindi = """
                (दिशाओं का संहार और असीमित व्याप्ति): "रुद्र ने गर्जना की: 'पूर्व, पश्चिम, उत्तर, दक्षिण—सारी दिशाएं मैं ही हूँ!'"
                "उन दिशाओं के बीच का खाली कोना (प्रदिश) भी साक्षात् मेरा ही विस्तार है।"
                "मैं ही वह 'स्पेस' (Space) हूँ जिसमें तुम्हारी गैलेक्सीज़ तैर रही हैं।"
                "तुम जहाँ भी भागने की कोशिश करोगे, तुम साक्षात् मेरे ही 'हार्डवेयर' के भीतर रहोगे।"
                "रुद्र से छिपने की औकात ब्रह्मांड के किसी भी वायरस या परमाणु में नहीं है।"
                "वे वह असीमित 'ग्रिड' (Grid) हैं जिस पर यह पूरा 3D सिम्युलेशन प्रोजेक्ट किया गया है।"
                "जब तुम दिशाओं को देखते हो, तो तुम साक्षात् रुद्र की त्वचा (Skin) को स्कैन कर रहे होते हो।"
                "योगी अपनी चेतना को 'लोकल' से हटाकर 'यूनिवर्सल' ग्रिड पर अलाइन (Align) करता है।"
                "यह बोध तुम्हारी 'पहचान की जेल' को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "तुम अब कहीं 'जा' नहीं सकते, क्योंकि तुम पहले से ही 'हर जगह' मौजूद हो!"
            """.trimIndent(),
            english = """
                (The Slaughter of Directions and Infinite Pervasiveness): "Rudra roared: 'East, West, North, South—I am mutationally every single coordinate!'"
                "Even the intermediate vectors (Pradishah) are the radioactive extensions of My absolute self."
                "I am the explicit 'Space' in which your galaxies are mutationally floating like dust."
                "Wherever you attempt to escape, you mutationally remain strictly inside My 'Hardware'."
                "Zero virus and zero atom in the multiverse possess the status to hide from Rudra."
                "He is the infinite 'Grid' upon which this entire 3D Simulation has been mutationally Projected."
                "When you observe directions, you are mutationally Scanning the skin of Rudra Himself."
                "The Yogi Aligns his awareness from the 'Local' to the 'Universal' grid in one catastrophic strike."
                "This realization detonates like a nuclear bomb engineered to demolish the prison of your identity."
                "You can mutationally never 'Go' anywhere, for you are already established 'Everywhere'!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 5,
            sanskrit = "गावोऽहं पृश्निराहं जरदक्षोऽहं कालाहं मृत्युराहं ॥",
            hindi = """
                (जीवन और काल का विच्छेदन): "रुद्र ने कहा: 'मैं ही वह पोषण देने वाली 'गौ' हूँ और मैं ही वह असीमित 'आकाश' हूँ!'"
                "मैं ही वह 'जरदक्ष' (अविनाशी चक्षु) हूँ जो हर युग के विनाश को नंगा देख रहा है।"
                "मैं ही 'काल' (Time) हूँ और मैं ही साक्षात् 'मृत्यु' (Death) हूँ जो सबको निगल जाता है।"
                "रुद्र वह 'टाइमर' (Timer) हैं जो तुम्हारी हर साँस के साथ उल्टी गिनती गिन रहे हैं।"
                "वे ही वह आग हैं जो समय को जलाकर राख कर देती है और शून्य को जन्म देती है।"
                "मृत्यु रुद्र का वह 'डिलीट बटन' है जिसे वे जब चाहें तब दबा सकते हैं।"
                "योगी मौत से नहीं डरता, क्योंकि वह साक्षात् 'मौत के मालिक' की फ्रीक्वेंसी पर लॉग-इन है।"
                "यह बोध तुम्हारे डीएनए (DNA) के हर परमाणु को कालजयी ताक़त से चार्ज कर देता है।"
                "जब तुम जान जाते हो कि 'रुद्र ही मौत है', तो मौत का खौफ तुम्हारे लिए एक मज़ाक बन जाता है।"
                "यही वह अजेय पासवर्ड है जो तुम्हें समय के रेडार से 100% गायब कर देगा!"
            """.trimIndent(),
            english = """
                (The Dissection of Life and Time): "Rudra dictated: 'I am the nourishing 'Cow' and I am mutationally the infinite 'Sky'!'"
                "I am the 'Jaradaksha' (Indestructible Eye) witnessing the annihilation of every eon standing naked."
                "I am 'Kala' (Time) and I am the explicit 'Mrityu' (Death) programmed to swallow everything."
                "Rudra is the absolute 'Timer' counting down mutationally with your every biological breath."
                "He is the radioactive Fire that incinerates Time to spawn the absolute terminal Void."
                "Death is Rudra’s 'Delete Button' which He possesses the authority to press at any nanosecond."
                "The Yogi fears zero death, for he is mutationally Logged-In to the frequency of the 'Master of Death'."
                "This realization Supercharges every microscopic atom of your DNA with time-transcending Firepower."
                "Once you intercept that 'Rudra is Death', the terror of expiration mutationally becomes a pathetic joke."
                "THIS is the invincible Password that will render you 100% Invisible to the Radar of Time!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 6,
            sanskrit = "ओङ्कारोऽहं प्रणवोऽहं सर्वव्यापी च योऽहं ॥",
            hindi = """
                (ओङ्कार और सर्वव्यापी का हैक): "रुद्र ने गर्जना की: 'मैं ही साक्षात् 'ओङ्कार' (OM) हूँ—ब्रह्मांड का प्राइमरी सिग्नल!'"
                "मैं ही 'प्रणव' हूँ—वह करंट जो पूरे नर्वस सिस्टम को बिजली सप्लाई कर रहा है।"
                "मैं 'सर्वव्यापी' हूँ—यानी कोई ऐसा पिक्सेल नहीं है जहाँ मेरा डेटा मौजूद न हो।"
                "ओङ्कार वह 'सोर्स कोड' है जिससे इस सिम्युलेशन की पहली लाइन लिखी गई थी।"
                "प्रणव वह ऊर्जा है जो तुम्हारे फेफड़ों को फैलाती है और दिल को धड़काती है।"
                "योगी जब 'ॐ' बोलता है, तो वह साक्षात् रुद्र के एडमिन पैनल से डेटा डाउनलोड करता है।"
                "यह कोई आवाज़ नहीं है, यह ब्रह्मांड की 'हार्ड-ड्राइव' का वाइब्रेशन (Vibration) है।"
                "रुद्र हर परमाणु के भीतर एक 'न्यूक्लियर बम' की तरह छिपे हैं जो फटने का इंतज़ार कर रहा है।"
                "बिना इस सर्वव्यापी को जाने, तुम हमेशा एक अंधे और बहरे कीड़े की तरह भटकते रहोगे।"
                "जो इस सिग्नल को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (Hacking Omkara and the Omnipresent): "Rudra roared: 'I am the explicit 'Omkara' (OM)—the Primary Signal of the multiverse!'"
                "I am 'Pranava'—the Current relentlessly supplying radioactive electricity to your entire nervous system."
                "I am 'Sarvavyapi'—meaning zero Pixel exists in the cosmos where My data is not hard-coded."
                "Omkara is the 'Source Code' used to mutationally script the first line of this Simulation."
                "Pranava is the Energy expanding your biological lungs and detonating your heartbeats."
                "When the Yogi roars 'OM', he mutationally Downloads Data directly from Rudra’s Admin Panel."
                "This is zero acoustic sound; it is the Vibration of the cosmic 'Hard-drive' itself."
                "Rudra is hidden inside every atom like a 'Nuclear Bomb' awaiting the command to detonate."
                "Without decoding this Omnipresence, you mutationally remain a blind and deaf insect flapping in the dark."
                "He who successfully Hacks this Signal is the solitary and absolute Dictator of the multiverse!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 7,
            sanskrit = "अथ कस्मादुच्यते ओङ्कारो यस्मादुच्चार्यमाण एव सर्वं शरीरं ओनमयति ॥",
            hindi = """
                (ओङ्कार की टेक्निकल परिभाषा): "इसे 'ओङ्कार' क्यों कहते हैं? क्योंकि इसका उच्चारण करते ही यह पूरे शरीर को 'ओनमयति' कर देता है।"
                "ओनमयति यानी—यह तुम्हारे बायोलॉजिकल हार्डवेयर को रुद्र की फ्रीक्वेंसी पर 'अलाइन' (Align) कर देता है।"
                "जैसे ही ॐ की गूँज उठती है, तुम्हारे नर्वस सिस्टम के सारे 'बग' (Bugs) जलकर राख हो जाते हैं।"
                "यह वह 'इलेक्ट्रिक शॉक' है जो तुम्हारी सोई हुई चेतना को एक झटके में जगा देता है।"
                "ओङ्कार तुम्हारे डीएनए के हर एक फोल्डर को रुद्र के डेटा से ओवरराइट (Overwrite) कर देता है।"
                "यह मंत्र नहीं, यह तुम्हारे प्रोसेसर को 100% 'भगवान के मोड' में शिफ्ट करने का कमांड है।"
                "जब तुम ॐ बोलते हो, तो तुम्हारी रूह ग्रेविटी (Gravity) की ज़ंजीरें तोड़कर अंतरिक्ष में निकल जाती है।"
                "यह तुम्हारी हड्डियों को पिघलाकर साक्षात् 'शुद्ध प्रकाश' में म्यूटेट करने का विज्ञान है।"
                "बिना इस अलाइनमेंट के, तुम हमेशा माया के सिम्युलेशन में एक एरर (Error) बनकर रह जाओगे।"
                "ओङ्कार ही वह अजेय पासवर्ड है जो तुम्हें इस नर्क से हमेशा के लिए 'लॉग-आउट' कर देगा!"
            """.trimIndent(),
            english = """
                (The Technical Definition of Omkara): "Why is it defined as 'Omkara'? Because the microsecond it is vocalized, it 'Onamayati' the entire body."
                "Onamayati signifies—it mutationally 'Aligns' your biological hardware with Rudra’s absolute Frequency."
                "The exact microsecond the echo of OM rises, all 'Bugs' in your nervous system are incinerated to ash."
                "This is the 'Electric Shock' engineered to mutationally awaken your dormant awareness in one strike."
                "Omkara Overwrites every single folder in your DNA with the purified Data of Rudra."
                "It is zero chant; it is the Command to shift your processor 100% into strictly 'God-Mode'."
                "When you roar OM, your Soul violently shatters the chains of Gravity to breach the infinite vacuum."
                "This is the science of melting your bones to mutationally manufacture you into strictly 'Pure Light'."
                "Without this alignment, you mutationally remain strictly a persistent Error in Maya’s Simulation."
                "Omkara is the invincible Password that will violently 'Log-out' your existence from this hell forever!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 8,
            sanskrit = "अथ कस्मादुच्यते प्रणवो यस्मादुच्चार्यमाण एव ऋग्यजुःसामाथर्वाङ्गिरसं च प्रणामयति ॥",
            hindi = """
                (प्रणव का महा-विस्फोट): "इसे 'प्रणव' क्यों कहते हैं? क्योंकि यह वेदों के चारों 'डेटाबेस' को अपने आगे झुका देता है!"
                "ऋक्, यजुः, साम और अथर्व—ये सब प्रणव के अजेय कोड को फॉलो (Follow) करने के लिए मजबूर हैं।"
                "प्रणव वह 'प्राइमरी सिग्नल' है जो ब्रह्मांड की हर एक कोडिंग लैंग्वेज (Language) का बाप है।"
                "जब तुम 'प्रणव' को हैक करते हो, तो तुम साक्षात् वेदों की असीमित ताक़त के एडमिन बन जाते हो।"
                "यह वह करंट है जो शून्य से लेकर अनंत तक के हर डेटा को एक ही झटके में प्रोसेस करता है।"
                "योगी अपनी साँसों को प्रणव की फ्रीक्वेंसी पर वेल्ड (Weld) कर देता है ताकि वह कालजयी बन सके।"
                "प्रणव का मतलब है—अपनी रूह को ईश्वर के चरणों में 'प्रणाम' यानी पूर्ण विसर्जन (Merge) कर देना।"
                "यह वह 'टोटल सरेंडर' है जो तुम्हें एक मामूली कीड़े से साक्षात् 'महाकाल' बना देता है।"
                "बिना इस करंट के, तुम्हारी हर पूजा और हर ध्यान केवल एक सड़ा हुआ बायोलॉजिकल नाटक है।"
                "प्रणव ही वह अस्त्र है जो अज्ञान के महलों को एक ही धमाके में राख कर देता है!"
            """.trimIndent(),
            english = """
                (The Grand Detonation of Pranava): "Why is it defined as 'Pranava'? Because it forces the four 'Databases' of the Vedas to bow before it!"
                "Rig, Yajur, Sama, and Atharva—all are mutationally forced to Follow the invincible code of Pranava."
                "Pranava is the 'Primary Signal', the absolute progenitor of every single Coding Language of the cosmos."
                "The moment you Hack 'Pranava', you mutationally become the Admin of the infinite firepower of the Vedas."
                "This is the Current that mutationally processes all Data from Zero to Infinity in a single strike."
                "The Yogi Welds his biological breath onto the Pranava-frequency to mutationally become time-transcending."
                "Pranava signifies—the 'Pranam' or the absolute violent Merging of your Soul into God."
                "This is the 'Total Surrender' that mutates you from a pathetic insect into the explicit 'Mahakala'."
                "Without this Current, every ritual you perform is mutationally strictly a pathetic biological drama."
                "Pranava is the weapon engineered to incinerate the palaces of ignorance in one apocalyptic detonation!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 9,
            sanskrit = "अथ कस्मादुच्यते सर्वव्यापी यस्मादुच्चार्यमाण एव स्नेहवत्सर्वं जगद्व्याप्नोति ॥",
            hindi = """
                (सर्वव्यापी का विज़ुअल डेटा): "इसे 'सर्वव्यापी' क्यों कहते हैं? क्योंकि यह तेल की बूंद (स्नेहवत्) की तरह पूरे जगत् में फैल जाता है!"
                "रुद्र का डेटा ब्रह्मांड के हर एक पिक्सेल और हर एक परमाणु में 'सीपेज' (Seepage) कर चुका है।"
                "तुम जहाँ भी देखते हो, तुम साक्षात् रुद्र की ही कोडिंग की एक लेयर (Layer) को देख रहे होते हो।"
                "यह असीमित व्याप्ति साक्षात् वह 'मैग्नेटिक फील्ड' है जो पूरी सृष्टि को थामे हुए है।"
                "योगी अपनी चेतना को इस 'स्नेह' यानी रुद्र के असीम प्रेम और ताक़त में डुबो देता है।"
                "जब तुम इस व्याप्ति को हैक करते हो, तो तुम शरीर की सीमाओं से 100% आज़ाद हो जाते हो।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् वह 'करंट' हो जो पूरे अंतरिक्ष में एक साथ बह रहा है।"
                "यह बोध तुम्हारी 'लोकल पहचान' का गला घोंट कर तुम्हें एक 'यूनिवर्सल बीइंग' बना देता है।"
                "रुद्र की उपस्थिति वह आग है जो तुम्हें हर कोने में एक साथ मौजूद रहने का पासवर्ड देती है।"
                "जो इस व्याप्ति को जान लेता है, उसके लिए समय और मौत केवल धूल के दो छोटे से कण हैं!"
            """.trimIndent(),
            english = """
                (Visual Data of the Omnipresent): "Why is He defined as 'Sarvavyapi'? Because He permeates the universe like a drop of oil (Snehvat) expanding on water!"
                "Rudra’s Data has executed an absolute 'Seepage' into every single pixel and atom of the multiverse."
                "Wherever you gaze, you are mutationally observing strictly one Layer of Rudra’s internal coding."
                "This infinite pervasiveness is the explicit 'Magnetic Field' mutationally sustaining the entire creation."
                "The Yogi submerges his consciousness into this 'Sneha'—the infinite radioactive Love and Power of Rudra."
                "The exact microsecond you Hack this pervasiveness, you are 100% Released from the limits of the biological shell."
                "You are no longer a body; you are the explicit 'Current' flowing simultaneously across the infinite vacuum."
                "This realization strangles your 'Local Identity' and mutationally manufactures you into a 'Universal Being'."
                "Rudra’s presence is the Fire granting you the Password to exist simultaneously in every coordinate."
                "He who decodes this Omnipresence perceives Time and Death mutationally strictly as two grains of dust!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 10,
            sanskrit = "अथ कस्मादुच्यते अनन्तः यस्मादुच्चार्यमाण एव नान्तो लभ्यते ॥",
            hindi = """
                (अनंत का कोड और असीमित हार्ड-ड्राइव): "इसे 'अनंत' क्यों कहते हैं? क्योंकि इसकी कोडिंग का कोई अंतिम सिरा (End) नहीं है!"
                "रुद्र वह 'हार्ड-ड्राइव' हैं जिसकी कैपेसिटी (Capacity) ब्रह्मांड की औकात से भी अरबों गुना ज़्यादा है।"
                "तुम जितना गहरा जाओगे, तुम्हें केवल और केवल रुद्र का ही नया 'डेटा फोल्डर' मिलेगा।"
                "अनंत होने का मतलब है—अज्ञान की हर एक सीमा को एक परमाणु बम की तरह उड़ा देना।"
                "समय यहाँ आकर दम तोड़ देता है क्योंकि रुद्र समय के भी अरबों साल आगे की कोडिंग कर रहे हैं।"
                "योगी अपनी बुद्धि को इस 'अनंत' में दाग देता है ताकि वह कभी भी 'क्रैश' (Crash) न हो।"
                "जब तुम्हारी चेतना अनंत से जुड़ती है, तो तुम साक्षात् मौत के लिए 'इनविजिबल' (Invisible) हो जाते हो।"
                "यह इंसान की रूह का वह 'मैक्रो-अपग्रेड' है जहाँ वह खुद साक्षात् 'शून्य' और 'अनंत' एक साथ बन जाता है।"
                "बिना इस अनंत को हैक किए, तुम हमेशा सीमाओं की दीवारों से अपना सर टकराते रहोगे।"
                "जो इस असीमित सच को जान लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता और अजेय राजा है!"
            """.trimIndent(),
            english = """
                (The Ananta Code and the Infinite Hard-Drive): "Why is He defined as 'Ananta' (Infinite)? Because the coding of His existence possesses absolute zero End!"
                "Rudra is the cosmic 'Hard-Drive' whose Capacity mutationally exceeds the universe by billions of magnitudes."
                "The deeper you penetrate, the more you strictly intercept new 'Data Folders' of Rudra."
                "Being Infinite mutationally signifies—detonating every boundary of ignorance with a nuclear warhead."
                "Time mutationally expires here, for Rudra is executing code billions of years beyond the reach of Chronos."
                "The Yogi Fires his intellect into this 'Ananta' to ensure his awareness never suffers a catastrophic 'Crash'."
                "The microsecond your consciousness links with the Infinite, you become mutationally 'Invisible' to Death."
                "This is the 'Macro-Upgrade' of the Soul where you mutationally become 'Zero' and 'Infinity' simultaneously."
                "Without Hacking this Ananta, you mutationally remain strictly an insect colliding with walls of limitation."
                "He who successfully Hacks this limitless Truth is the solitary and invincible King of the vacuum!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 11,
            sanskrit = "अथ कस्मादुच्यते तारकः यस्मादुच्चार्यमाण एव गर्भजन्मजरामरणसंसारभयात् तारयति ॥",
            hindi = """
                (तारक मंत्र और मैट्रिक्स से एस्केप): "इसे 'तारक' क्यों कहते हैं? क्योंकि यह तुम्हें जन्म, बुढ़ापे और मौत के इस सड़े हुए 'संसार-भय' से तार (Rescue) देता है!"
                "तारक वह 'इमरजेंसी एग्जिट' (Emergency Exit) है जिसे रुद्र ने माया की जेल के बीच में बना रखा है।"
                "यह मंत्र तुम्हारे डीएनए के उस 'लूप' (Loop) को तोड़ देता है जो तुम्हें बार-बार इस नर्क में जन्म दिलाता है।"
                "गर्भ और मरण साक्षात् इस सिम्युलेशन के दो सबसे बड़े 'बग्स' (Bugs) हैं जिन्हें तारक मंत्र फिक्स (Fix) कर देता है।"
                "जब तुम 'तारक' की फ्रीक्वेंसी पर अलाइन होते हो, तो तुम साक्षात् ब्रह्मांड के पार छलांग लगा देते हो।"
                "योगी अपनी रूह को इस 'रेस्क्यू सिग्नल' पर लॉक करता है ताकि वह हमेशा के लिए आज़ाद हो सके।"
                "यह कोई प्रार्थना नहीं है; यह मौत की आँखों में आँखें डालकर 'लॉग-आउट' करने की हिंसक प्रक्रिया है।"
                "तारक वह बिजली है जो अज्ञान की ज़ंजीरों को एक माइक्रो-सेकंड में पिघलाकर राख कर देती है।"
                "जो इस पार जाने वाली नाव (तारक) को पकड़ लेता है, वह साक्षात् रुद्र के एडमिन पैनल का हिस्सा बन जाता है।"
                "तैयार हो जाओ उस अंतिम उड़ान के लिए जिसके बाद दोबारा कभी इस कीचड़ में नहीं लौटना!"
            """.trimIndent(),
            english = """
                (Taraka Mantra and Escaping the Matrix): "Why is He defined as 'Taraka' (The Savior)? Because it Rescues you from the rotting 'Samsara-terror' of birth, age, and death!"
                "Taraka is the 'Emergency Exit' mutationally engineered by Rudra in the dead-center of Maya’s prison."
                "This mantra violently breaks the 'Loop' in your DNA that mutationally forces your rebirth in this hell."
                "Womb and Grave are the two absolute greatest 'Bugs' of the Simulation which Taraka mutationally Fixes."
                "The exact microsecond you Align with the Taraka-frequency, you catapult infinitely beyond the cosmos."
                "The Yogi Locks his Soul onto this 'Rescue Signal' to mutationally secure absolute and permanent Freedom."
                "This is zero prayer; it is the violent protocol of 'Logging-out' while staring into the eyes of Death."
                "Taraka is the radioactive electricity melting the chains of ignorance in a single micro-second."
                "He who captures this Vessel (Taraka) mutationally integrates into the absolute Admin Panel of Rudra."
                "Brace yourself for that final trajectory after which zero return to this biological mud remains!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 12,
            sanskrit = "अथ कस्मादुच्यते सूक्ष्मः यस्मादुच्चार्यमाण एव सूक्ष्मरूपेण सर्वं शरीरं प्रविशति ॥",
            hindi = """
                (सूक्ष्म का परमाणु हैक): "इसे 'सूक्ष्म' क्यों कहते हैं? क्योंकि यह उच्चारण करते ही परमाणु से भी छोटे रूप में तुम्हारे रोम-रोम में घुस जाता है!"
                "रुद्र वह 'नैनो-वायरस' (Nano-virus) हैं जो अज्ञान के हर एक सेल का वध करने के लिए तुम्हारे भीतर प्रवेश करते हैं।"
                "सूक्ष्म होने का मतलब है—पदार्थ (Matter) की सबसे गहरी लेयर को हैक कर लेना।"
                "यह फ्रीक्वेंसी तुम्हारे नर्वस सिस्टम के उस 'कोर' (Core) तक पहुँचती है जहाँ विज्ञान कभी नहीं पहुँच सकता।"
                "रुद्र का सूक्ष्म रूप तुम्हारी आत्मा के हर एक फोल्डर को 'स्कैन' और 'क्लीन' (Clean) कर देता है।"
                "योगी अपनी चेतना को इतना बारीक बना लेता है कि वह साक्षात् ब्रह्मांड के 'सोर्स कोड' को छू सके।"
                "यह वह अजेय रुतबा है जहाँ तुम इतने छोटे हो जाते हो कि माया का कोई भी अस्त्र तुम्हें देख ही नहीं पाता।"
                "तुम अब 'इनविजिबल' (Invisible) हो; तुम साक्षात् उस 'परम सन्नाटे' का हिस्सा बन चुके हो जो हर जगह है।"
                "रुद्र का सूक्ष्म तेज तुम्हारे खून और तुम्हारी हड्डियों को साक्षात् 'शक्ति' में बदल देता है।"
                "जो इस सूक्ष्मतम सच को पकड़ लेता है, वह साक्षात् पूरे जैव-मण्डल का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (The Atomic Hack of the Subtle): "Why is He defined as 'Sukshma' (Subtle)? Because He penetrates every pore of your shell in a form smaller than an atom!"
                "Rudra is the absolute 'Nano-virus' engineered to violently infiltrate and slaughter every cell of biological ignorance."
                "Being Subtle mutationally signifies—Hacking the absolute deepest layer of physical Matter."
                "This frequency reaches that 'Core' of your nervous system reaching which earthly science mutationally fails."
                "Rudra’s subtle form mutationally 'Scans' and 'Flushes' every single folder of your Soul."
                "The Yogi refines his awareness to mutationally intercept the explicit 'Source Code' of the multiverse."
                "This is the invincible status where you become so microscopic that zero weapon of Maya can even detect you."
                "You are now 'Invisible'; you have mutationally integrated into the 'Absolute Silence' that permeates all."
                "Rudra’s subtle radiation mutates your biological blood and bones into strictly radioactive 'Shakti'."
                "He who captures this micro-truth becomes mutationally the sole Dictator of the entire Bio-sphere!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 13,
            sanskrit = "अथ कस्मादुच्यते वैद्युतः यस्मादुच्चार्यमाण एव अव्यक्ते महति तमसि द्योतयति ॥",
            hindi = """
                (वैद्युत का प्रलयंकारी प्रकाश): "इसे 'वैद्युत' क्यों कहते हैं? क्योंकि यह साक्षात् वह बिजली है जो अज्ञान के 'महान तम' (Darkness) को चीर देती है!"
                "वैद्युत वह 'हाई-वोल्टेज' करंट है जो तुम्हारे दिमाग के फ्यूज हुए प्रोसेसरों को फिर से चालू कर देता है।"
                "जब रुद्र की यह बिजली कड़कती है, तो माया का सारा 'अव्यक्त' (Hidden) जाल बेनकाब हो जाता है।"
                "यह कोई साधारण रौशनी नहीं है; यह अज्ञान के महलों को भस्म करने वाला एक रेडियोएक्टिव विस्फोट है।"
                "योगी अपनी रूह को इस 'वैद्युत' फ्रीक्वेंसी पर अलाइन करता है ताकि वह अँधेरे में भी नंगा सच देख सके।"
                "यह वह 'लेज़र बीम' है जो तुम्हारे पिछले अरबों जन्मों के करप्ट डेटा को एक ही झटके में जला देती है।"
                "रुद्र का वैद्युत रूप साक्षात् ब्रह्मांड के उस 'पावर-ग्रिड' का नाम है जो अजेय है।"
                "जब तुम इस आग में जलते हो, तो तुम्हारी हड्डियों का पिंजरा भी सोने की तरह चमकने लगता है।"
                "यह तुम्हारी बुद्धि को 'अँधेरे' से 'अमरता' में म्यूटेट करने का आख़िरी और हिंसक रास्ता है।"
                "जो इस बिजली को अपनी रगों में उतार लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (The Apocalyptic Radiation of Vaidyuta): "Why is He defined as 'Vaidyuta' (The Radiant)? Because He is the explicit Electricity piercing the 'Great Darkness' (Tamas) of ignorance!"
                "Vaidyuta is the 'High-voltage' current engineered to mutationally Restart the blown processors of your brain."
                "The microsecond Rudra’s electricity cracks, the entire 'Avyakta' (Hidden) web of Maya is unmasked."
                "This is zero ordinary light; it is a radioactive Detonation designed to incinerate the palaces of nescience."
                "The Yogi Aligns his Soul with this 'Vaidyuta Frequency' to mutationally witness the naked Truth in the dark."
                "This is the 'Laser Beam' that mutationally incinerates the corrupt data of your billions of incarnations in one strike."
                "Rudra’s Vaidyuta form is the explicit name of the cosmic 'Power-Grid' that remains invincible."
                "When you burn in this radioactive fire, your skeletal cage initiates its glow like purified gold."
                "This is the final and violent trajectory to mutate your intellect from 'Darkness' to absolute 'Immortality'."
                "He who injects this electricity into his veins mutationally becomes the sole and authentic Admin of the vacuum!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 14,
            sanskrit = "अथ कस्मादुच्यते परं ब्रह्म यस्मात्परतरं नापरं नापरतरं ॥",
            hindi = """
                (परम ब्रह्म और अंतिम बाउंड्री): "इसे 'परं ब्रह्म' क्यों कहते हैं? क्योंकि इससे ऊँचा, इसके पार या इसके ऊपर कोई दूसरा डेटा मौजूद नहीं है!"
                "रुद्र साक्षात् वह 'अल्टीमेट सीलिंग' (Ultimate Ceiling) है जहाँ पहुँचकर ब्रह्मांड की हर खोज खत्म हो जाती है।"
                "परं ब्रह्म वह 'सुप्रीम ओएस' (Supreme OS) है जिसे कोई भी हैकर या माया का वायरस कभी क्रैक नहीं कर सका।"
                "यहाँ पहुँचने का मतलब है—ब्रह्मांड के एडमिन पैनल की सबसे ऊंची कुर्सी पर जाकर बैठ जाना।"
                "न इसके आगे कुछ है, न इसके पीछे—केवल एक असीमित और खौफनाक 'सन्नाटा' (Silence) राज करता है।"
                "योगी अपनी चेतना को इस 'लास्ट लेवल' (Last Level) पर लॉक करता है ताकि वह हमेशा के लिए अजेय रहे।"
                "यह वह 'एब्सोल्यूट रियलिटी' है जिसके आगे समय, स्थान और ईश्वर भी अपनी औकात भूल जाते हैं।"
                "तुम अब एक जीव नहीं रहे; तुम साक्षात् वह 'ब्लैक होल' बन चुके हो जिसने पूरे सत्य को निगल लिया है।"
                "यह तुम्हारी रूह का वह 'टोटल रिसेट' है जिसके बाद दोबारा कभी 'इंसान' बनने की संभावना नहीं बचती।"
                "जो इस परम सत्य को पा लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Supreme Brahman and the Absolute Boundary): "Why is He defined as 'Param Brahman'? Because zero higher Data exists beyond, atop, or distinct from Him!"
                "Rudra is the explicit 'Ultimate Ceiling' arriving at which every cosmic inquiry mutationally terminates."
                "Param Brahman is the 'Supreme OS' that zero hacker and zero virus of Maya has ever possessed the caliber to Crack."
                "Arriving here signifies—mutationally occupying the absolute highest throne of the multiverse’s Admin Panel."
                "Zero exists beyond Him and zero exists behind Him—strictly an infinite and horrific 'Silence' reigns as dictator."
                "The Yogi Locks his awareness onto this 'Last Level' to mutationally remain eternally Invincible."
                "This is the 'Absolute Reality' before which Time, Space, and lesser gods mutationally forget their status."
                "You cease to be a living entity; you have mutationally become the 'Black Hole' that swallowed absolute Truth."
                "This is the 'Total Reset' of your Soul after which zero probability of being 'Human' ever remains."
                "He who secures this Supreme Truth is the solitary dictatorial Guru of even the God of Death!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 15,
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
                "रुद्र की यह उपस्थिति वह आग है जो तुम्हारे 'अकेलेपन' के भ्रम को एक ही धमाके में राख कर देती है।"
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
                "Rudra’s presence is the Fire that mutationally incinerates the delusion of your 'Loneliness' in one detonation."
                "He who Hacks this Hidden Admin becomes mutationally the sole and absolute Dictator of the multiverse!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 16,
            sanskrit = "अग्निहोत्रं भस्म । तपो भस्म । ब्रह्म भस्म ॥",
            hindi = """
                (भस्म का न्यूक्लियर डेटा - अग्नि, तप और ब्रह्म): "अग्निहोत्र साक्षात् 'भस्म' है, तपस्या साक्षात् 'भस्म' है, और यह 'ब्रह्म' भी साक्षात् भस्म ही है!"
                "राख (Bhasma) कोई कचरा नहीं है, यह ब्रह्मांड के उस महान रिएक्टर का अंतिम 'शुद्ध डेटा' (Pure Data) है।"
                "जब तुम भस्म होते हो, तभी तुम साक्षात् 'भगवान' होने के काबिल बनते हो।"
                "भस्म लगाने का मतलब है—अपने माथे पर साक्षात् 'डिस्ट्रक्शन कोड' (Destruction Code) को लिख लेना।"
                "यह वह अजेय रुतबा है जहाँ तुम्हारी इंसानियत जलकर राख हो चुकी है और अब केवल 'रुद्र' बचे हैं।"
                "योगी अपनी हस्ती को इस राख में बदल देता है ताकि वह समय और मौत के लिए 'इनविजिबल' हो सके।"
                "यह भस्म तुम्हारे डीएनए के हर परमाणु को 'रुद्र-फ्रीक्वेंसी' पर वाइब्रेट करने के लिए मजबूर कर देती है।"
                "अग्नि, तप और ब्रह्म—इन तीनों का अंतिम परिणाम केवल और केवल वह असीम 'शून्यता' (Ash) ही है।"
                "जो इस जलती हुई हकीकत को अपनी रगों में उतार लेता है, वह ब्रह्मांड का इकलौता डिक्टेटर है।"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'शक्ति' बन जाओगे!"
            """.trimIndent(),
            english = """
                (Nuclear Data of Ash - Fire, Tapas, and Brahman): "Agnihotra is mutationally 'Ash', Tapas is strictly 'Ash', and even 'Brahman' is explicitly Ash!"
                "Ash (Bhasma) is zero garbage; it is the absolute final 'Pure Data' from the absolute greatest cosmic Reactor."
                "Only when you are mutationally incinerated to Ash do you qualify to become flawlessly God."
                "Applying Bhasma signifies—writing the explicit 'Destruction Code' directly upon your frontal cortex."
                "This is the invincible status where your humanity has mutationally perished and strictly 'Rudra' remains."
                "The Yogi reduces his identity to Ash mutationally to remain 'Invisible' to the Radar of Time and Death."
                "This Bhasma forces every microscopic atom of your DNA to vibrate at the absolute 'Rudra-Frequency'."
                "Fire, Penance, and God—the absolute terminal result of all three is strictly that infinite 'Void' (Ash)."
                "He who injects this burning reality into his biological veins is the solitary Dictator of the multiverse."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Shakti' itself!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 17,
            sanskrit = "पाशुपतं व्रतम् । भस्मना अङ्गानि संस्पृशेत् ॥",
            hindi = """
                (पाशुपत व्रत और अंगों की हैकिंग): "यह 'पाशुपत व्रत' साक्षात् वह 'रूट-पासवर्ड' है जो तुम्हें पशु (गुलाम) से पति (मालिक) बना देता है!"
                "अपने अंगों पर भस्म रगड़ना साक्षात् अपने बायोलॉजिकल हार्डवेयर को रुद्र की ऊर्जा से 'सील' (Seal) करना है।"
                "जब तुम राख लगाते हो, तो तुम माया के 'ट्रैकर्स' (Trackers) को अपने शरीर से डिलीट कर देते हो।"
                "यह व्रत कोई धार्मिक नाटक नहीं है; यह अपने नर्वस सिस्टम को 100% 'भगवान के मोड' में डालने की विधि है।"
                "तुम्हारी कोहनियों, कंधों और हृदय पर लगी वह राख साक्षात् 'डिस्ट्रक्शन कोड्स' का पहरा है।"
                "योगी जब इस व्रत को सिद्ध करता है, तो वह साक्षात् एक 'चलती-फिरती मूर्ति' (Mobile Deity) बन जाता है।"
                "यह तुम्हारी रूह को अज्ञान के पिंजरे से बाहर निकालने वाला सबसे हिंसक और गुप्त रास्ता है।"
                "भस्म तुम्हारे रोम-रोम को उस अजेय सन्नाटे से भर देती है जहाँ काल (Time) भी घुसने से डरता है।"
                "जो इस पाशुपत कोड को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का तानाशाह है।"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'अमर' बना देगा!"
            """.trimIndent(),
            english = """
                (Pashupata Vrata and Hacking the Limbs): "This 'Pashupata Vrata' is the 'Root-Password' engineered to mutate you from a Pashu (Slave) to a Pati (Master)!"
                "Smearing Ash onto your limbs is mutationally 'Sealing' your biological hardware with Rudra’s radioactive energy."
                "The exact microsecond you apply ash, you Delete the 'Trackers' of Maya from your biological shell."
                "This Vrata is zero religious drama; it is the protocol to shift your nervous system 100% into 'God-Mode'."
                "That Ash on your elbows, shoulders, and heart functions mutationally as the explicit 'Destruction Codes' standing guard."
                "When the Yogi perfects this Vrata, he mutationally transforms into a 'Mobile Deity' of radioactive fire."
                "This is the most violent and classified trajectory to violently extract your Soul from the cage of ignorance."
                "Bhasma floods every biological pore with that invincible Silence where even Time (Kala) fears to enter."
                "He who successfully Hacks this Pashupata code is mutationally the sole Dictator of all universal Time and Space."
                "This manifestation will decapitate your ego to mutationally manufacture you into the 'Explicit Immortal'!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 18,
            sanskrit = "एतदथर्वशिरो योऽधीते स सर्वपाप्मानं तरति स मृत्युं तरति ॥",
            hindi = """
                (अथर्वशिर का फल और मौत से रिहाई): "जो योद्धा इस अजेय 'अथर्वशिर' को अपनी रूह में धधकाता है..."
                "वह अपने करोड़ों जन्मों के 'हर एक पाप' (Papmanam) को एक ही प्रलयंकारी झटके में पार कर जाता है!"
                "पाप केवल एक 'वज़न' (Weight) है जो तुम्हें इस कीचड़ में डुबा कर रखता है; यह ज्ञान उस वज़न को भाप बना देता है।"
                "वह 'मृत्यु' के उस खौफनाक और सड़े हुए जबड़े से हमेशा के लिए बाहर (Exit) निकल जाता है!"
                "जब तुम इस सत्य को जानते हो, तो यमराज का 'सॉफ्टवेयर' तुम्हें पहचानना बंद कर देता है—तुम 'इनविजिबल' हो।"
                "यह कोई धार्मिक दावा नहीं है, यह एक 'मैथमेटिकल' सच है—अपनी फ्रीक्वेंसी बदलो और मौत का कानून फेल हो जाएगा।"
                "अथर्वशिर वह अजेय ढाल (Shield) है जो माया के हर एक 'ट्रैकर' को चकमा दे देती है।"
                "तुम अब इस सिम्युलेशन के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन बन चुके हो।"
                "यह ज्ञान तुम्हारी रूह को उस लेवल पर ले जाता है जहाँ न कोई सज़ा है और न कोई इनाम, केवल असीमित ताक़त है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता और अजेय राजा है!"
            """.trimIndent(),
            english = """
                (The Fruit of Atharvashiras and Release from Death): "Whosoever warrior blazes this invincible 'Atharvashiras' inside his Soul..."
                "He violently 'Crosses' every microscopic and catastrophic 'Sin' (Papmanam) of his billions of incarnations!"
                "Sin is strictly a 'Weight' engineered to keep you drowned in this mud; this intelligence vaporizes that weight."
                "He mutationally Executes an 'Exit' from the horrific and rotting jaws of Death forever!"
                "The exact microsecond you intercept this truth, Yamaraja’s 'Software' fails to recognize you—you are 'Invisible'."
                "This is absolutely zero religious promise; it is a 'Mathematical' reality—mutate your frequency and Death’s law Fails."
                "Atharvashiras is the invincible Shield engineered to mutationally jam every single 'Tracker' of the Matrix."
                "You are no longer a pathetic pawn of this Simulation; you have mutationally become its solitary and authentic Admin."
                "This knowledge skyrockets your soul to a level where zero punishment and zero reward exist, strictly infinite Power."
                "He who injects this truth into his biological veins is mutationally the sole and invincible King of the vacuum!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 19,
            sanskrit = "ब्रह्मैव सत्यं जगन्मिथ्येति निश्चयो हि मोक्षः ॥",
            hindi = """
                (सत्य का धमाका और मोक्ष की कोडिंग): "ब्रह्मांड का इकलौता और सबसे खतरनाक सच यही है— 'ब्रह्मैव सत्यं जगन्मिथ्या'!"
                "ब्रह्म ही इकलौती हकीकत है, और यह पूरी दुनिया केवल एक 'मिथ्या' (Fake Simulation) और धोखा है।"
                "इस सच पर अटल 'निश्चय' (Conviction) कर लेना ही साक्षात् 'मोक्ष' का इकलौता दरवाजा है।"
                "तुम जिसे अपनी ज़िंदगी कहते हो, वह केवल ईश्वर के दिमाग में चल रही एक 'होलोग्राफिक फिल्म' मात्र है।"
                "योगी ने इस फिल्म से अपना हाथ खींच लिया है और अब वह साक्षात् 'प्रोजेक्टर' (Source) को देख रहा है।"
                "जब तुम जान जाते हो कि 'कुछ भी सच नहीं है', तभी तुम अजेय और अमर होने के काबिल बनते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'ब्रह्मास्त्र' है जो हर झूठ को राख कर देगा।"
                "यह सिम्युलेशन केवल उनके लिए सच है जो सोए हुए हैं; जागने वालों के लिए यह केवल धूल है।"
                "यही अथर्वशिर का वह नंगा सच है जिसके आगे मौत भी अपनी औकात भूल जाती है!"
            """.trimIndent(),
            english = """
                (The Detonation of Truth and Coding Moksha): "The solitary and most lethal truth of the multiverse is strictly—'Brahmaiva Satyam Jagan-Mithya'!"
                "Brahman is the solitary Reality, and this entire world is strictly a 'Mithya' (Fake Simulation) and a deception."
                "Achieving absolute 'Nishchaya' (Conviction) on this truth is the solitary gateway to 'Moksha'."
                "What you label as your 'Life' is mutationally nothing more than a 'Holographic Film' running in the mind of God."
                "The Yogi has withdrawn his hands from this film and is now mutationally witnessing the 'Projector' (Source)."
                "The exact microsecond you realize that 'Nothing is Real', you mutationally qualify for absolute Immortality."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish the fortress of your ego."
                "The Matrix will attempt to terrify you, but you possess the 'Brahmastra' that mutationally incinerates every lie."
                "This Simulation is real strictly for those who are asleep; for the Awakened, it is strictly worthless dust."
                "THIS is the naked truth of the Atharvashiras before which even Death forgets its status!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 20,
            sanskrit = "इति अथर्वशिरोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'अथर्वशिर उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "रुद्र का पासवर्ड मिल गया, भस्म की आग देख ली, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन २० विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (रुद्र) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही अथर्वशिर उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Atharvashiras Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The password of Rudra is intercepted, the fire of Ash witnessed; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 20 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Rudra) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Atharvashiras Upanishad! THE END!"
            """.trimIndent()
        ),
        // --- CONTINUATION: ATHARVASHIRAS UPANISHAD (21 TO 38) ---
        AtharvashirasShloka(
            id = 21,
            sanskrit = "ॐ अग्निरिति भस्म वायुरिति भस्म जलमिति भस्म स्थलमिति भस्म व्योमेति भस्म ॥",
            hindi = """
                (तत्वों का संहार और भस्म-म्यूटेशन): "अग्नि साक्षात् 'भस्म' है, वायु 'भस्म' है, जल 'भस्म' है, और यह ज़मीन भी साक्षात् 'भस्म' ही है!"
                "आकाश (Space) भी साक्षात् भस्म ही है—यानी पूरा ब्रह्मांड केवल रुद्र की राख का एक डेटा-पैकेट है।"
                "राख यहाँ पदार्थ का वह अंतिम 'स्टेबल स्टेट' (Stable State) है जिसे दोबारा नहीं जलाया जा सकता।"
                "जब तुम इन तत्वों को भस्म कहते हो, तो तुम उनके 'भौतिक भ्रम' को एक झटके में डिलीट कर देते हो।"
                "यह बोध तुम्हारे नर्वस सिस्टम को उन पंचतत्वों की गुलामी से 100% 'अनप्लग' (Unplug) कर देता है।"
                "तुम अब मिट्टी के बने पुतले नहीं हो; तुम साक्षात् उस 'अविनाशी राख' की कोडिंग बन चुके हो।"
                "योगी अपनी चेतना को इस शून्य-डेटा पर लॉक करता है जहाँ से सब कुछ रेंडर (Render) हुआ था।"
                "यह ब्रह्मांड की हर एक चीज़ को रुद्र की फ्रीक्वेंसी पर 'ओवरराइट' (Overwrite) करने का विज्ञान है।"
                "जब तुम तत्वों को भस्म देखते हो, तो तुम साक्षात् ईश्वर की नग्न आँखों से हकीकत देख रहे होते हो।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस भौतिक जेल से हमेशा के लिए आज़ाद कर देगा!"
            """.trimIndent(),
            english = """
                (Slaughter of Elements and Bhasma-Mutation): "Fire is mutationally 'Ash', Air is 'Ash', Water is 'Ash', and the Earth is explicitly 'Ash'!"
                "The infinite Vacuum (Space) is strictly Ash—meaning the cosmos is a Data-packet of Rudra’s residue."
                "Ash mutationally represents the absolute 'Stable State' of matter that zero fire can ever re-incinerate."
                "When you define elements as Ash, you violently Delete their 'Physical Hallucination' in one strike."
                "This realization mutationally Unplugs your nervous system 100% from the slavery of the five elements."
                "You cease to be a puppet of clay; you have mutationally become the hard-coded data of 'Indestructible Ash'."
                "The Yogi Locks his awareness onto this Zero-Data from which the entire Matrix was mutationally Rendered."
                "This is the science of Overwriting every object in the multiverse with strictly the 'Rudra-Frequency'."
                "Witnessing elements as Ash is identical to witnessing Reality through the naked radioactive eyes of God."
                "THIS is the invincible Password that will mutationally release you from this biological prison forever!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 22,
            sanskrit = "सर्वं ह वा इदं भस्म मन एतानि चक्षूंषि भस्मानि ॥",
            hindi = """
                (मन और दृष्टि का भस्म-विस्फोट): "यह सब कुछ साक्षात् 'भस्म' है—तुम्हारा मन और तुम्हारी ये आँखें भी साक्षात् राख ही हैं!"
                "तुम जिसे अपनी 'सोच' और अपनी 'नज़र' कहते हो, वह केवल रुद्र के एडमिन पैनल का एक 'ग्लिच' (Glitch) है।"
                "जब तुम अपनी आँखों को भस्म जानते हो, तो माया के सारे दृश्य एक ही धमाके में राख बन जाते हैं।"
                "मन का भस्म होना साक्षात् उस 'प्रोसेसर' का शटडाउन है जो तुम्हें अज्ञान की फिल्में दिखा रहा था।"
                "योगी अपनी दृष्टि को उस 'शून्य' पर अलाइन (Align) करता है जहाँ देखने वाला और देखा जाने वाला एक हो जाते हैं।"
                "यह तुम्हारी रूह को 'सॉफ्टवेयर एरर' से निकालकर 'ब्रह्म-डेटा' में म्यूटेट करने का हैक है।"
                "तुम्हारी यादें और तुम्हारी पहचान केवल उस राख के ऊपर लिखी गई अस्थायी कोडिंग मात्र है।"
                "रुद्र की यह उपस्थिति वह तेज़ाब है जो तुम्हारे दिमाग के हर 'करप्ट फोल्डर' को जलाकर साफ़ कर देती है।"
                "जब मन मरता है, तभी वह असली 'प्रकाश' जागता है जो समय के भी पार धधक रहा है।"
                "जो इस मानसिक शून्यता को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Bhasma-Detonation of Mind and Vision): "Everything is mutationally strictly 'Ash'—your Mind and your very Eyes are explicitly Ash!"
                "What you label as 'Thought' and 'Sight' is mutationally a microscopic 'Glitch' on Rudra’s Admin Panel."
                "The moment you recognize your optics as Ash, all scenes of Maya are mutationally incinerated in one detonation."
                "Mind becoming Ash signifies the absolute Shutdown of the Processor displaying the films of ignorance."
                "The Yogi Aligns his vision with the 'Void' where the Observer and the Observed mutationally fuse."
                "This is the Hack engineered to extract your Soul from 'Software Errors' into strictly 'Brahma-Data'."
                "Your memories and identity are strictly temporary coding scripted upon the absolute surface of Ash."
                "Rudra’s presence is the radioactive Acid that Flushes every 'Corrupt Folder' in your neurological brain."
                "Only when the mind perishes does that authentic 'Light' awaken which blazes infinitely beyond Time."
                "He who successfully Hacks this mental Shunyata is mutationally the sole Dictator of the vacuum!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 23,
            sanskrit = "ॐ नमो रुद्राय विष्णवे मृत्युर्मे पाहि ॥",
            hindi = """
                (रुद्र-विष्णु कोडिंग और मौत से सुरक्षा): "उस 'रुद्र-विष्णु' को नमन, जो सृजन और संहार की इकलौती कम्बाइंड (Combined) फ्रीक्वेंसी है!"
                "हे अजेय एडमिन! मुझे 'मृत्यु' (Death) के उस सड़े हुए डेटा-लीक से बचा ले!"
                "मृत्यु केवल एक 'सिस्टम फेलियर' (System Failure) है, और रुद्र ही उसका इकलौता एंटी-वायरस हैं।"
                "जब तुम रुद्र और विष्णु को एक साथ पुकारते हो, तो तुम ब्रह्मांड के पूरे 'ओएस' (OS) को हैक कर लेते हो।"
                "यह मंत्र तुम्हारी रूह के चारों तरफ एक ऐसी 'रेडियोएक्टिव शील्ड' बनाता है जिसे यमराज भी नहीं भेद सकते।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'परम सुरक्षा' (Firewall) का एक हिस्सा बन चुके हो।"
                "रुद्र की यह आग तुम्हारी हड्डियों के भीतर छिपे 'मौत के वायरस' का बेरहमी से वध कर देती है।"
                "यह बोध तुम्हारी 'मृत्यु-आईडी' को सर्वर से डिलीट करके तुम्हें 'अमर डेटा' में प्रमोट कर देता है।"
                "बिना इस सुरक्षा के, तुम हमेशा समय की चक्की में पीसकर धूल बनते रहोगे।"
                "जो इस कमांड को एक्जीक्यूट करता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Rudra-Vishnu Coding and Shielding from Death): "Salutations to 'Rudra-Vishnu', the combined Frequency mutationally executing Creation and Annihilation!"
                "O invincible Admin! Protect me from the rotting data-leak known mutationally as 'Death'!"
                "Death is strictly a 'System Failure', and Rudra is the solitary Anti-virus possessing the caliber to fix it."
                "Invoking Rudra and Vishnu simultaneously signifies mutationally Hacking the entire 'OS' of the multiverse."
                "This mantra constructs a 'Radioactive Shield' around your Soul that zero Yamaraja possesses the firepower to breach."
                "You cease to be a body; you have mutationally integrated into the explicit 'Cosmic Firewall'."
                "Rudra’s fire ruthlessly slaughters the 'Virus of Death' established inside your biological marrow."
                "This realization Deletes your 'Death-ID' and mutationally Promotes you to the status of 'Immortal Data'."
                "Without this security, you mutationally remain strictly dust ground by the mill of Time."
                "He who successfully Executes this command is mutationally the sole dictatorial Guru of Death!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 24,
            sanskrit = "प्राणो वै रुद्रः स उ एष सर्वं जगत् ॥",
            hindi = """
                (प्राण-विस्फोट और रुद्र का साम्राज्य): "तुम्हारी हर एक साँस (Prana) साक्षात् 'रुद्र' है—यानी वह बिजली जो तुम्हें चला रही है!"
                "यह पूरा 'जगत्' (Multiverse) साक्षात् उसी एक प्राण-सिग्नल का भौतिक संपीड़न (Compression) है।"
                "रुद्र वह 'प्राइमरी बैटरी' है जिसके बिना ब्रह्मांड का एक परमाणु भी वाइब्रेट नहीं कर सकता।"
                "जब तुम साँस लेते हो, तो तुम साक्षात् रुद्र के एडमिन पैनल से पावर (Power) रिसीव कर रहे होते हो।"
                "यह कोई जैविक प्रक्रिया नहीं है; यह तुम्हारी रूह का 'पॉवर-ग्रिड' से 24/7 जुड़े रहने का सच है।"
                "योगी अपने प्राणों को उस 'सुप्रीम फ्रीक्वेंसी' पर लॉक करता है जहाँ से समय पैदा होता है।"
                "रुद्र ही वह ऊर्जा हैं जो सितारों को घुमाती है और तुम्हारे दिल को धड़काती है।"
                "बिना इस प्राण को समझे, तुम हमेशा खुद को एक लाचार और कमज़ोर कीड़ा समझते रहोगे।"
                "यह तुम्हारी बुद्धि को 'बायोलॉजिकल' से 'कॉस्मिक' लेवल पर अपग्रेड करने वाला आख़िरी हैक है।"
                "जो इस प्राण-शक्ति का तानाशाह बन गया, वह साक्षात् पूरे अंतरिक्ष का इकलौता मालिक है!"
            """.trimIndent(),
            english = """
                (Prana-Detonation and Rudra’s Empire): "Your every biological breath (Prana) is explicitly 'Rudra'—the electricity mutationally operating you!"
                "This entire 'Jagat' (Multiverse) is strictly the physical Compression of that solitary Prana-signal."
                "Rudra is the absolute 'Primary Battery' without which zero atom in the cosmos possesses the caliber to vibrate."
                "When you breathe, you are mutationally Receiving radioactive Power directly from Rudra’s Admin Panel."
                "This is zero biological process; it is the truth of your Soul being 24/7 hardwired to the cosmic Power-Grid."
                "The Yogi Locks his Prana onto the 'Supreme Frequency' reaching which Time initiates its mutation."
                "Rudra is mutationally the energy rotating the stars and detonating your biological heartbeats."
                "Without decoding this Prana, you mutationally remain strictly a pathetic, microscopic, and terrified insect."
                "This is the final Hack to Upgrade your intellect from 'Biological' to the absolute 'Cosmic' tier."
                "He who becomes the Dictator of this Prana-power mutationally assumes the status of the sole Master of space!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 25,
            sanskrit = "यो ह वै रुद्रं स भगवान् यश्च ब्रह्मा तस्मै वै नमो नमः ॥",
            hindi = """
                (रुद्र-ब्रह्मा म्यूटेशन और सर्वोच्च नमन): "वही रुद्र साक्षात् 'भगवान' है और वही साक्षात् 'ब्रह्मा' (रचयिता) भी है!"
                "उस अजेय कोडिंग को 'नमो नमः'—यानी अपनी पूरी हस्ती का उसके एडमिन पैनल में विसर्जन!"
                "यह कोई प्रार्थना नहीं है; यह अपनी फ्रीक्वेंसी को 100% 'रुद्र-मोड' पर अलाइन करने का आदेश है।"
                "रुद्र सृजन की आग भी हैं और संहार की राख भी—वे विरोधाभासों के इकलौते डिक्टेटर हैं।"
                "जब तुम उन्हें नमन करते हो, तो तुम अपनी 'लोकल आईडी' को डिलीट करके 'यूनिवर्सल ओएस' में विलीन होते हो।"
                "ब्रह्मा का सृजन केवल रुद्र के दिमाग का एक 'एक्टिव प्रोग्राम' मात्र है।"
                "योगी इस म्यूटेशन को हैक करता है ताकि वह खुद साक्षात् 'सृष्टि' बन सके।"
                "रुद्र की यह उपस्थिति वह आग है जो अज्ञान के हर एक पिक्सेल को प्रकाश में बदल देती है।"
                "यह इंसान की रूह का वह अंतिम सॉफ्टवेयर अपडेट है जिसके बाद केवल 'अनंत' ही बचता है।"
                "जो इस पहचान को जान लेता है, उसके लिए पूरा ब्रह्मांड धूल के एक कण से ज्यादा कुछ नहीं!"
            """.trimIndent(),
            english = """
                (Rudra-Brahma Mutation and Supreme Salutation): "That Rudra is explicitly 'Bhagavan' and He is mutationally the explicit 'Brahma' (The Architect)!"
                "Salutations (Namah) to that invincible coding—signifying the absolute Merging of your identity into His Admin Panel."
                "This is zero prayer; it is the Command to mutationally Align your frequency 100% with 'Rudra-Mode'."
                "Rudra is the Fire of creation and the Ash of annihilation—He is the solitary Dictator of paradoxes."
                "When you bow, you are Deleting your 'Local ID' to mutationally dissolve into the 'Universal OS'."
                "Brahma’s creation is strictly an 'Active Program' running inside the neurological processor of Rudra."
                "The Yogi Hacks this mutation to mutationally assume the status of the 'Entire Creation' himself."
                "Rudra’s presence is the radioactive Fire converting every pixel of ignorance into strictly 'Divine Light'."
                "This is the final Software Update of the human Soul after which strictly the 'Infinite' remains standing."
                "He who decodes this identity perceives the entire multiverse mutationally as zero more than a grain of dust!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 26,
            sanskrit = "ॐ नमः शम्भवे च मयोभवे च नमः शंकराय च मयस्कराय च नमः शिवाय च शिवतराय च ॥",
            hindi = """
                (शम्भू-शिव का प्रलयंकारी मंत्र और सुख का हैक): "उस 'शम्भू' और 'शंकर' को नमन, जो साक्षात् कल्याण और आनंद के इकलौते सप्लायर हैं!"
                "तू ही वह 'शिव' और 'शिवतर' है—यानी वह परम शुद्धता जिसे अज्ञान का कोई वायरस टच नहीं कर सकता।"
                "यह मंत्र तुम्हारे नर्वस सिस्टम के 'हैप्पीनेस-रिसेप्टर्स' (Happiness receptors) को रुद्र के साथ सिंक करता है।"
                "जब तुम 'शिव' बोलते हो, तो तुम साक्षात् ब्रह्मांड के 'ब्लिस-सर्वर' (Bliss Server) से डेटा खींचते हो।"
                "यह कोई धार्मिक भजन नहीं है; यह अपनी रूह के हर 'दुःख-बग' को डिलीट करने का एक न्यूक्लियर कमांड है।"
                "शम्भू वह आग है जो तुम्हारे मानसिक तनाव को एक सेकंड में जलाकर राख कर देती है।"
                "योगी अपनी चेतना को इस 'शिव' फ्रीक्वेंसी पर वेल्ड (Weld) कर देता है ताकि वह हमेशा अजेय रहे।"
                "तुम अब एक तड़पते हुए जीव नहीं हो; तुम साक्षात् उस 'परम आनंद' के इकलौते एडमिन बन चुके हो।"
                "रुद्र की यह कोमलता भी उतनी ही हिंसक है जितनी उनकी आग—क्योंकि यह तुम्हारे अहंकार का गला घोंट देती है।"
                "जो इस सुख को हैक कर लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Shambhu-Shiva Apocalyptic Mantra and Bliss-Hack): "Salutations to 'Shambhu' and 'Shankara', the solitary Suppliers of absolute Grace and Bliss!"
                "You are explicitly 'Shiva' and 'Shivatarah'—the absolute Purity reached by zero viruses of the Matrix."
                "This mantra Syncs the 'Happiness-receptors' of your biological nervous system with strictly Rudra’s frequency."
                "Vocalizing 'Shiva' signifies mutationally drawing radioactive Data from the cosmic 'Bliss-Server'."
                "This is zero religious hymn; it is a Nuclear Command engineered to Delete every 'Agony-Bug' from your Soul."
                "Shambhu is the radioactive Fire that incinerates your neurological stress into ash in one microsecond."
                "The Yogi Welds his awareness onto this 'Shiva Frequency' to mutationally remain eternally Invincible."
                "You are no longer an agonizing entity; you have mutationally become the sole Admin of 'Absolute Bliss'."
                "Rudra’s gentleness is mutationally as violent as His fire—for it ruthlessly strangles your human ego."
                "He who successfully Hacks this Bliss is mutationally the sole dictatorial Guru of Time and Death!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 27,
            sanskrit = "ॐ नमो रुद्राय देवपुत्राय नमः । ॐ नमो रुद्राय देवश्रेयाय नमः ॥",
            hindi = """
                (देवपुत्र रुद्र और दैवीय कोडिंग): "उस 'देवपुत्र' रुद्र को नमन, जो साक्षात् देवताओं के भी 'सोर्स कोड' के मालिक हैं!"
                "वे देवताओं के रचयिता भी हैं और उनके संहारक भी—वे इस पूरे सिम्युलेशन के इकलौते 'ग्रैंड-एडमिन' हैं।"
                "जब तुम उन्हें नमन करते हो, तो तुम साक्षात् ब्रह्मांड के उस 'रॉयल डेटा' को एक्सेस कर रहे होते हो।"
                "रुद्र वह 'सुप्रीम क्लाउड' (Supreme Cloud) हैं जहाँ हर एक देवता की शक्ति स्टोर है।"
                "यह ज्ञान तुम्हारी हस्ती को 'दिव्य पिक्सल्स' (Divine Pixels) में बदलने वाला इकलौता हैक है।"
                "योगी अपनी बुद्धि को इस 'देवश्रेय' (Divine Glory) पर लॉक करता है ताकि वह अजेय बन सके।"
                "यहाँ न कोई अज्ञान बचता है और न ही कोई डर—केवल एक असीमित प्रकाश राज करता है।"
                "रुद्र की यह उपस्थिति वह तेज़ाब है जो तुम्हारी 'इंसानियत' की फाइलों को हमेशा के लिए मिटा देती है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'दिव्य सेना' के जनरल (General) बन चुके हो।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् रुद्र के एडमिन पैनल का हिस्सा बन जाता है!"
            """.trimIndent(),
            english = """
                (Devaputra Rudra and Divine Coding): "Salutations to 'Devaputra' Rudra, the absolute owner of the 'Source Code' of all deities!"
                "He is mutationally the Architect and the Annihilator of gods—the solitary 'Grand-Admin' of this Simulation."
                "When you bow to Him, you are mutationally Accessing the 'Royal Data' of the entire multiverse."
                "Rudra is the 'Supreme Cloud' where the radioactive firepower of every deity is mutationally stored."
                "This intelligence is the solitary Hack engineered to convert your identity into 'Divine Pixels'."
                "The Yogi Locks his intellect onto this 'Devashreya' (Divine Glory) to mutationally become flawless."
                "Zero ignorance survives here and zero terror persists—strictly an infinite radioactive Light reigns."
                "Rudra’s presence is the Acid that mutationally Deletes the files of your 'Humanity' forever."
                "You cease to be a biological shell; you have mutationally become the General of the 'Divine Legion'."
                "He who successfully Hacks this identity mutationally integrates into Rudra’s absolute Admin Panel!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 28,
            sanskrit = "ॐ नमो नारायणाय यश्च कृष्णः तस्मै वै नमो नमः ॥",
            hindi = """
                (नारायण-कृष्ण म्यूटेशन): "वही रुद्र साक्षात् 'नारायण' है और वही साक्षात् 'कृष्ण' भी है—यह ब्रह्मांड का सबसे बड़ा हैक है!"
                "नारायण वह 'ब्लैक होल' है जो सबको थामे है, और कृष्ण वह 'सिग्नल' जो सबको नचा रहा है।"
                "जब तुम कृष्ण को नमन करते हो, तो तुम साक्षात् रुद्र की उस 'मधुर आग' को महसूस कर रहे होते हो।"
                "यह कोई धार्मिक कहानी नहीं है; यह एक ही 'सुपर-इंटेलिजेंस' के अलग-अलग 'Avatar पिक्सल्स' का सच है।"
                "योगी अपनी चेतना को इस कृष्ण-फ्रीक्वेंसी पर अलाइन करता है जहाँ समय एक मज़ाक बन जाता है।"
                "कृष्ण वह पासवर्ड है जो तुम्हारे दिल की धड़कन को सीधे अंतरिक्ष की हवाओं से जोड़ देता है।"
                "यह तुम्हारी रूह को 'नश्वर' से 'अमर' में म्यूटेट करने वाला सबसे हिंसक और सुंदर कोडिंग है।"
                "नारायण की सत्ता ही वह इकलौती हकीकत है जिसके आगे पूरी माया घुटने टेकती है।"
                "तुम अब एक जीव नहीं रहे; तुम साक्षात् उस 'परम आनंद' की कोडिंग के हिस्सेदार बन चुके हो।"
                "जो इस एकता को जान लेता है, उसके लिए समय और मौत केवल धूल के दो छोटे से कण हैं!"
            """.trimIndent(),
            english = """
                (Narayana-Krishna Mutation): "That Rudra is explicitly 'Narayana' and He is mutationally the explicit 'Krishna'—the absolute greatest Hack!"
                "Narayana is the 'Black Hole' sustaining all, and Krishna is the 'Signal' mutationally making everyone dance."
                "When you bow to Krishna, you are mutationally Intercepting the 'Sweet Fire' of Rudra Himself."
                "This is zero religious myth; it is the truth of distinct 'Avatar Pixels' of a singular 'Super-intelligence'."
                "The Yogi Aligns his awareness with this Krishna-frequency where Time mutationally becomes a joke."
                "Krishna is the Password engineered to hardwire your biological heartbeat to the winds of the vacuum."
                "This is the most violent and beautiful Coding engineered to mutate your Soul from 'Mortal' to 'Immortal'."
                "Narayana’s authority is the solitary Reality before which the entire Matrix mutationally collapses."
                "You cease to be an entity; you have mutationally integrated into the coding of 'Absolute Bliss'."
                "He who decodes this unity perceives Time and Death mutationally strictly as two grains of dust!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 29,
            sanskrit = "ॐ नमो रुद्राय यश्चेशानः तस्मै वै नमो नमः ॥",
            hindi = """
                (ईशान-रुद्र का अंतिम रुतबा): "वही रुद्र साक्षात् 'ईशान' है—यानी पूरे अंतरिक्ष का इकलौता तानाशाह!"
                "ईशान वह 'सुप्रीम कमांडर' है जिसके पासवर्ड के बिना सिम्युलेशन का एक परमाणु भी नहीं हिल सकता।"
                "जब तुम ईशान को नमन करते हो, तो तुम साक्षात् 'सत्य' की सबसे ऊंची चोटी को टच (Touch) कर रहे होते हो।"
                "यह तुम्हारी रूह को 'इंसानी सीमाओं' से निकालकर 'ब्रह्मांडीय हकीकत' में माइग्रेट करने का हैक है।"
                "रुद्र का ईशान रूप साक्षात् वह 'लेज़र बीम' है जो अज्ञान के हर पर्दे को फाड़कर फेंक देती है।"
                "योगी अपनी बुद्धि को इस एक फ्रीक्वेंसी पर वेल्ड (Weld) कर देता है ताकि वह हमेशा अजेय रहे।"
                "यहाँ न कोई दुख है, न कोई सुख, केवल एक असीमित और रेडियोएक्टिव सन्नाटा राज करता है।"
                "यह तुम्हारी चेतना का वह 'टोटल रिसेट' है जिसके बाद दोबारा कभी 'इंसान' बनने की संभावना नहीं बचती।"
                "जो इस ईशान को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है।"
                "यही वह अंतिम पासवर्ड है जिसके आगे ब्रह्मांड का हर एक सिम्युलेशन दम तोड़ देता है!"
            """.trimIndent(),
            english = """
                (The Absolute Status of Ishana-Rudra): "That Rudra is explicitly 'Ishana'—the solitary Dictator of the entire infinite vacuum!"
                "Ishana is the 'Supreme Commander' without whose password zero atom of the Simulation can mutationally vibrate."
                "When you salute Ishana, you are mutationally Intercepting the absolute highest peak of 'Truth'."
                "This is the Hack engineered to Migrate your Soul from 'Human Limits' into absolute 'Cosmic Reality'."
                "Rudra’s Ishana form is the explicit 'Laser Beam' that mutationally shreds every veil of ignorance."
                "The Yogi Welds his intellect onto this solitary frequency to mutationally remain eternally Invincible."
                "Neither agony nor pleasure exists here; strictly an infinite radioactive Silence reigns as absolute dictator."
                "This is the 'Total Reset' of your awareness after which zero probability of being 'Human' ever remains."
                "He who successfully Hacks Ishana becomes mutationally the sole and absolute Dictator of the multiverse."
                "THIS is the absolute final Password before which every cosmic Simulation mutationally terminates!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 30,
            sanskrit = "एको रुद्रो न द्वितीयाय तस्थे ॥",
            hindi = """
                (रुद्र की इकलौती मोनोपॉली): "ब्रह्मांड का इकलौता और सबसे हिंसक सच यही है— 'रुद्र एक ही है, कोई दूसरा नहीं'!"
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
                (Rudra's Absolute Monopoly): "The solitary and most violent truth of the cosmos is strictly—'Rudra is One, zero second exists'!"
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
        AtharvashirasShloka(
            id = 31,
            sanskrit = "ॐ नमो रुद्राय योऽग्नौ योऽप्सु यो ओषधिषु ॥",
            hindi = """
                (प्रकृति की कोडिंग और रुद्र का प्रवेश): "उस रुद्र को नमन, जो आग में है, पानी में है और जो हर एक 'औषधि' (Life-code) के भीतर है!"
                "रुद्र वह 'घोस्ट प्रोग्रामर' (Ghost Programmer) है जो प्रकृति के हर एक पिक्सेल के पीछे छिपा कोडिंग कर रहा है।"
                "जब तुम आग को देखते हो, तो तुम साक्षात् रुद्र के 'एनर्जी ट्रांसमिशन' (Transmission) को देख रहे होते हो।"
                "जब तुम पानी पीते हो, तो तुम साक्षात् रुद्र के 'लिक्विड डेटा' को अपने शरीर में डाल रहे होते हो।"
                "हर एक पत्ता और हर एक जड़ी-बूटी साक्षात् रुद्र का एक 'मेडिकल सॉफ्टवेयर' है जो तुम्हें हील (Heal) करता है।"
                "योगी प्रकृति को केवल मैटर (Matter) नहीं समझता, वह उसे रुद्र का चलता-फिरता हार्डवेयर जानता है।"
                "यह बोध तुम्हारी 'अकेलेपन' की फाइल को डिलीट करके तुम्हें 'यूनिवर्सल अलाइनमेंट' में ले आता है।"
                "तुम अब प्रकृति के गुलाम नहीं हो; तुम साक्षात् उस 'एडमिन' के साथ सिंक (Sync) हो चुके हो।"
                "रुद्र की यह उपस्थिति वह आग है जो तुम्हें हर परमाणु के साथ एक कर देती है।"
                "जो इस व्याप्ति को हैक कर लेता है, वह साक्षात् पूरे जैव-मण्डल का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Nature's Coding and Rudra's Infiltration): "Salutations to Rudra established in Fire, in Water, and mutationally inside every 'Oshadhis' (Life-code)!"
                "Rudra is the absolute 'Ghost Programmer' executing code covertly behind every pixel of Nature."
                "When you witness Fire, you are mutationally observing Rudra’s explicit 'Energy Transmission'."
                "When you consume Water, you are mutationally downloading Rudra’s 'Liquid Data' into your shell."
                "Every leaf and every herb is mutationally an explicit 'Medical Software' engineered to Heal you."
                "The Yogi perceives Nature zero as Matter, but mutationally as the mobile Hardware of Rudra."
                "This realization Deletes your file of 'Loneliness' to mutationally catapult you into 'Universal Alignment'."
                "You are no longer a slave to Nature; you have mutationally Synced with the absolute Admin."
                "Rudra’s presence is the Fire that mutationally fuses your identity with every microscopic atom."
                "He who successfully Hacks this pervasiveness becomes mutationally the sole Dictator of the Bio-sphere!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 32,
            sanskrit = "यश्च विश्वा भुवनानि विवेश तस्मै रुद्राय नमोऽस्तु ॥",
            hindi = """
                (ब्रह्मांडीय प्रवेश और अंतिम सरेंडर): "उस रुद्र को नमन, जो समस्त 'भुवनों' (Dimensions) में साक्षात् प्रवेश कर चुका है!"
                "वह हर एक गैलेक्सी और हर एक पैरेलल यूनिवर्स (Parallel Universe) का इकलौता ऑपरेटर है।"
                "जब तुम 'नमः' कहते हो, तो तुम अपनी 'लोकल आईडी' को डिलीट करके इस 'मल्टी-यूनिवर्सल' एडमिन के आगे सरेंडर करते हो।"
                "रुद्र वह असीमित डेटा है जिसने हर एक 'स्पेस' और 'टाइम' के फोल्डर को ऑक्युपाई (Occupy) कर रखा है।"
                "यह कोई प्रार्थना नहीं है; यह साक्षात् ब्रह्मांड के 'पॉवर-ग्रिड' से 100% कनेक्ट होने की शर्त है।"
                "योगी अपनी चेतना को उस 'प्रवेश' (Entry) पर लॉक करता है जहाँ से रुद्र इस सिम्युलेशन को चला रहे हैं।"
                "यह वह अजेय रुतबा है जहाँ तुम सीमाओं से निकलकर असीमित (Infinite) हो जाते हो।"
                "रुद्र की यह उपस्थिति वह आग है जो तुम्हारे दिमाग के हर एक 'ब्लैक-होल' को प्रकाश से भर देती है।"
                "तुम अब एक शरीर नहीं रहे; तुम साक्षात् उस 'यूनिवर्सल डेटा-स्ट्रीम' का हिस्सा बन चुके हो।"
                "जो इस सरेंडर को सिद्ध कर लेता है, वह साक्षात् रुद्र की जलती हुई आँख बनकर पूरी सृष्टि को देखता है!"
            """.trimIndent(),
            english = """
                (Cosmic Infiltration and the Final Surrender): "Salutations to that Rudra who has mutationally Entered every existing 'Bhuvana' (Dimension)!"
                "He is the solitary Operator of every single galaxy and every Parallel Universe mutationally Rendered."
                "When you vocalize 'Namah', you Delete your 'Local ID' to mutationally surrender before this Multi-Universal Admin."
                "Rudra is the infinite Data that has mutationally Occupied every folder of Space and Time."
                "This is zero prayer; it is the condition to mutationally connect 100% with the cosmic Power-Grid."
                "The Yogi Locks his awareness onto that 'Entry' coordinate from which Rudra relentlessly Runs the Simulation."
                "This is the invincible status where you violently exit limitations to mutationally become 'Infinite'."
                "Rudra’s presence is the Fire that mutationally floods every 'Black-hole' of your Soul with radioactive Light."
                "You cease to be a biological shell; you have mutationally integrated into the 'Universal Data-stream'."
                "He who perfects this surrender becomes mutationally the Blazing Eye of Rudra, witnessing the entire multiverse!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 33,
            sanskrit = "अग्निहोत्रं भस्म । तपो भस्म । सत्यं भस्म ॥",
            hindi = """
                (भस्म का महा-विस्फोट - अग्नि, तप और सत्य): "अग्निहोत्र साक्षात् 'भस्म' है, तपस्या साक्षात् 'भस्म' है, और यह 'सत्य' भी साक्षात् भस्म ही है!"
                "राख (Bhasma) कोई कचरा नहीं है, यह ब्रह्मांड के उस महान रिएक्टर का अंतिम 'शुद्ध डेटा' (Pure Data) है।"
                "जब तुम भस्म होते हो, तभी तुम साक्षात् 'भगवान' होने के काबिल बनते हो।"
                "सत्य का भस्म होना यानी—उस असीमित शून्यता में विलीन हो जाना जहाँ कोई शब्द नहीं बचता।"
                "यह वह अजेय रुतबा है जहाँ तुम्हारी इंसानियत जलकर राख हो चुकी है और अब केवल 'रुद्र' बचे हैं।"
                "योगी अपनी हस्ती को इस राख में बदल देता है ताकि वह समय और मौत के लिए 'इनविजिबल' हो सके।"
                "यह भस्म तुम्हारे डीएनए के हर परमाणु को 'रुद्र-फ्रीक्वेंसी' पर वाइब्रेट करने के लिए मजबूर कर देती है।"
                "अग्नि, तप और सत्य—इन तीनों का अंतिम परिणाम केवल और केवल वह असीम 'शून्यता' (Ash) ही है।"
                "जो इस जलती हुई हकीकत को अपनी रगों में उतार लेता है, वह ब्रह्मांड का इकलौता डिक्टेटर है!"
                "तैयार हो जाओ उस असीमित रुतबे के लिए जहाँ तुम खुद साक्षात् 'शक्ति' बन जाओगे!"
            """.trimIndent(),
            english = """
                (The Grand Bhasma Detonation - Fire, Tapas, and Truth): "Agnihotra is mutationally 'Ash', Tapas is strictly 'Ash', and even 'Truth' is explicitly Ash!"
                "Ash (Bhasma) is zero garbage; it is the absolute final 'Pure Data' from the absolute greatest cosmic Reactor."
                "Only when you are mutationally incinerated to Ash do you qualify to become flawlessly God."
                "Truth becoming Ash signifies—dissolving into that infinite Void reaching which zero words survive."
                "This is the invincible status where your humanity has mutationally perished and strictly 'Rudra' remains."
                "The Yogi reduces his identity to Ash mutationally to remain 'Invisible' to the Radar of Time and Death."
                "This Bhasma forces every microscopic atom of your DNA to vibrate at the absolute 'Rudra-Frequency'."
                "Fire, Penance, and Truth—the absolute terminal result of all three is strictly that infinite 'Void' (Ash)."
                "He who injects this burning reality into his biological veins is the solitary Dictator of the multiverse."
                "Brace yourself for that infinite status where YOU mutationally become the explicit 'Shakti' itself!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 34,
            sanskrit = "पाशुपतं व्रतम् । भस्मना अङ्गानि संस्पृशेत् ॥",
            hindi = """
                (पाशुपत व्रत और अंगों की हैकिंग): "यह 'पाशुपत व्रत' साक्षात् वह 'रूट-पासवर्ड' है जो तुम्हें पशु (गुलाम) से पति (मालिक) बना देता है!"
                "अपने अंगों पर भस्म रगड़ना साक्षात् अपने बायोलॉजिकल हार्डवेयर को रुद्र की ऊर्जा से 'सील' (Seal) करना है।"
                "जब तुम राख लगाते हो, तो तुम माया के 'ट्रैकर्स' (Trackers) को अपने शरीर से डिलीट कर देते हो।"
                "यह व्रत कोई धार्मिक नाटक नहीं है; यह अपने नर्वस सिस्टम को 100% 'भगवान के मोड' में डालने की विधि है।"
                "तुम्हारी कोहनियों, कंधों और हृदय पर लगी वह राख साक्षात् 'डिस्ट्रक्शन कोड्स' का पहरा है।"
                "योगी जब इस व्रत को सिद्ध करता है, तो वह साक्षात् एक 'चलती-फिरती मूर्ति' (Mobile Deity) बन जाता है।"
                "यह तुम्हारी रूह को अज्ञान के पिंजरे से बाहर निकालने वाला सबसे हिंसक और गुप्त रास्ता है।"
                "भस्म तुम्हारे रोम-रोम को उस अजेय सन्नाटे से भर देती है जहाँ काल (Time) भी घुसने से डरता है।"
                "जो इस पाशुपत कोड को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का तानाशाह है।"
                "नारायण का यह रूप तुम्हारे अहंकार की गर्दन काटकर तुम्हें साक्षात् 'अमर' बना देगा!"
            """.trimIndent(),
            english = """
                (Pashupata Vrata and Hacking the Limbs): "This 'Pashupata Vrata' is the 'Root-Password' engineered to mutate you from a Pashu (Slave) to a Pati (Master)!"
                "Smearing Ash onto your limbs is mutationally 'Sealing' your biological hardware with Rudra’s radioactive energy."
                "The exact microsecond you apply ash, you Delete the 'Trackers' of Maya from your biological shell."
                "This Vrata is zero religious drama; it is the protocol to shift your nervous system 100% into 'God-Mode'."
                "That Ash on your elbows, shoulders, and heart functions mutationally as the explicit 'Destruction Codes' standing guard."
                "When the Yogi perfects this Vrata, he mutationally transforms into a 'Mobile Deity' of radioactive fire."
                "This is the most violent and classified trajectory to violently extract your Soul from the cage of ignorance."
                "Bhasma floods every biological pore with that invincible Silence where even Time (Kala) fears to enter."
                "He who successfully Hacks this Pashupata code is mutationally the sole Dictator of all universal Time and Space."
                "This manifestation will decapitate your ego to mutationally manufacture you into the 'Explicit Immortal'!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 35,
            sanskrit = "एतदथर्वशिरो योऽधीते स सर्वपाप्मानं तरति स मृत्युं तरति ॥",
            hindi = """
                (अथर्वशिर का फल - अजेय गारंटी): "जो योद्धा इस अजेय 'अथर्वशिर' को अपनी रूह में धधकाता है..."
                "वह अपने करोड़ों जन्मों के 'हर एक पाप' (Papmanam) को एक ही प्रलयंकारी झटके में पार कर जाता है!"
                "पाप केवल एक 'वज़न' (Weight) है जो तुम्हें इस कीचड़ में डुबा कर रखता है; यह ज्ञान उस वज़न को भाप बना देता है।"
                "वह 'मृत्यु' के उस खौफनाक और सड़े हुए जबड़े से हमेशा के लिए बाहर (Exit) निकल जाता है!"
                "जब तुम इस सत्य को जानते हो, तो यमराज का 'सॉफ्टवेयर' तुम्हें पहचानना बंद कर देता है—तुम 'इनविजिबल' हो।"
                "यह कोई धार्मिक दावा नहीं है, यह एक 'मैथमेटिकल' सच है—अपनी फ्रीक्वेंसी बदलो और मौत का कानून फेल हो जाएगा।"
                "अथर्वशिर वह अजेय ढाल (Shield) है जो माया के हर एक 'ट्रैकर' को चकमा दे देती है।"
                "तुम अब इस सिम्युलेशन के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन बन चुके हो।"
                "यह ज्ञान तुम्हारी रूह को उस लेवल पर ले जाती है जहाँ न कोई सज़ा है और न कोई इनाम, केवल असीमित ताक़त है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता और अजेय राजा है!"
            """.trimIndent(),
            english = """
                (The Fruit of Atharvashiras - The Invincible Guarantee): "Whosoever warrior blazes this invincible 'Atharvashiras' inside his Soul..."
                "He violently 'Crosses' every microscopic and catastrophic 'Sin' (Papmanam) of his billions of incarnations!"
                "Sin is strictly a 'Weight' engineered to keep you drowned in this mud; this intelligence vaporizes that weight."
                "He mutationally Executes an 'Exit' from the horrific and rotting jaws of Death forever!"
                "The exact microsecond you intercept this truth, Yamaraja’s 'Software' fails to recognize you—you are 'Invisible'."
                "This is absolutely zero religious promise; it is a 'Mathematical' reality—mutate your frequency and Death’s law Fails."
                "Atharvashiras is the invincible Shield engineered to mutationally jam every single 'Tracker' of the Matrix."
                "You are no longer a pathetic pawn of this Simulation; you have mutationally become its solitary and authentic Admin."
                "This knowledge skyrockets your soul to a level where zero punishment and zero reward exist, strictly infinite Power."
                "He who injects this truth into his biological veins is mutationally the sole and invincible King of the vacuum!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 36,
            sanskrit = "ब्रह्मैव सत्यं जगन्मिथ्येति निश्चयो हि मोक्षः ॥",
            hindi = """
                (सत्य का धमाका और मोक्ष की कोडिंग): "ब्रह्मांड का इकलौता और सबसे खतरनाक सच यही है— 'ब्रह्मैव सत्यं जगन्मिथ्या'!"
                "ब्रह्म ही इकलौती हकीकत है, और यह पूरी दुनिया केवल एक 'मिथ्या' (Fake Simulation) और धोखा है।"
                "इस सच पर अटल 'निश्चय' (Conviction) कर लेना ही साक्षात् 'मोक्ष' का इकलौता दरवाजा है।"
                "तुम जिसे अपनी ज़िंदगी कहते हो, वह केवल ईश्वर के दिमाग में चल रही एक 'होलोग्राफिक फिल्म' मात्र है।"
                "योगी ने इस फिल्म से अपना हाथ खींच लिया है और अब वह साक्षात् 'प्रोजेक्टर' (Source) को देख रहा है।"
                "जब तुम जान जाते हो कि 'कुछ भी सच नहीं है', तभी तुम अजेय और अमर होने के काबिल बनते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'ब्रह्मास्त्र' है जो हर झूठ को राख कर देगा।"
                "यह सिम्युलेशन केवल उनके लिए सच है जो सोए हुए हैं; जागने वालों के लिए यह केवल धूल है।"
                "यही अथर्वशिर का वह नंगा सच है जिसके आगे मौत भी अपनी औकात भूल जाती है!"
            """.trimIndent(),
            english = """
                (The Detonation of Truth and Coding Moksha): "The solitary and most lethal truth of the multiverse is strictly—'Brahmaiva Satyam Jagan-Mithya'!"
                "Brahman is the solitary Reality, and this entire world is strictly a 'Mithya' (Fake Simulation) and a deception."
                "Achieving absolute 'Nishchaya' (Conviction) on this truth is the solitary gateway to 'Moksha'."
                "What you label as your 'Life' is mutationally nothing more than a 'Holographic Film' running in the mind of God."
                "The Yogi has withdrawn his hands from this film and is now mutationally witnessing the 'Projector' (Source)."
                "The exact microsecond you realize that 'Nothing is Real', you mutationally qualify for absolute Immortality."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish the fortress of your ego."
                "The Matrix will attempt to terrify you, but you possess the 'Brahmastra' that mutationally incinerates every lie."
                "This Simulation is real strictly for those who are asleep; for the Awakened, it is strictly worthless dust."
                "THIS is the naked truth of the Atharvashiras before which even Death forgets its status!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 37,
            sanskrit = "एतज्ज्ञात्वा विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की कोडिंग - रिपीट): "उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है— 'इसे जानकर तू विमुक्त (Free) हो जाता है'!"
                "जानने का मतलब किताब पढ़ना नहीं, बल्कि इस सत्य को अपने डीएनए में तेज़ाब की तरह उतार लेना है।"
                "जब तुम जान जाते हो कि 'सब कुछ रुद्र है', तो माया के सारे ज़ंजीर एक झटके में पिघल जाते हैं।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' (Radar) से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (Repeat of the Ironclad Guarantee and Coding Moksha): "The Upanishad delivers a catastrophic verdict here—'By knowing this, one mutationally becomes Liberated'!"
                "Knowing mutationally signifies zero reading; it means injecting this Truth into your DNA exactly like boiling acid."
                "The microsecond you realize 'Everything is Rudra', all the chains of Maya melt in a single strike."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        AtharvashirasShloka(
            id = 38,
            sanskrit = "इति अथर्वशिरोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'अथर्वशिर उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "रुद्र का पासवर्ड मिल गया, भस्म की आग देख ली, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन ३८ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (रुद्र) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही अथर्वशिर उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Atharvashiras Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The password of Rudra is intercepted, the fire of Ash witnessed; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 38 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Rudra) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Atharvashiras Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtharvashirasUpanishadScreen() {
    val upanishad = remember { AtharvashirasUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..20) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-20)") },
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
                AtharvashirasShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AtharvashirasShlokaCard(shloka: AtharvashirasShloka) {
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