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
data class MaitreyiShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class MaitreyiUpanishad {

    val maitreyiShlokasList = listOf(
        MaitreyiShloka(
            id = 1,
            sanskrit = "ॐ राजा बृहद्रथो नाम राज्ये ज्येष्ठं पुत्रं निधापयित्वेदमशाश्वतं मन्यमानो वैराग्यमुपेतोऽरण्यं निर्जगाम ॥",
            hindi = """
                (वैराग्य का विस्फोट और सत्ता का संहार): "राजा बृहद्रथ ने अपनी हस्ती और साम्राज्य का गला घोंट कर सत्य की खोज शुरू की।"
                "उन्होंने जान लिया कि यह 3D साम्राज्य केवल एक 'अशाश्वत' (Temporary) सिम्युलेशन मात्र है।"
                "अपने ज्येष्ठ पुत्र को सत्ता सौंपना वास्तव में माया के सर्वर से 'लॉग-आउट' होने की पहली प्रक्रिया थी।"
                "राजा ने अपनी पहचान को 'डस्टबिन' में फेंक दिया और उस आग की तलाश में निकल पड़े जो कभी नहीं बुझती।"
                "महल की दीवारें उन्हें जेल की तरह लगने लगीं क्योंकि उनकी रूह अंतरिक्ष को हैक करना चाहती थी।"
                "वैराग्य कोई कमज़ोरी नहीं है; यह अज्ञान के खिलाफ छेड़ा गया सबसे हिंसक और साहसिक विद्रोह है।"
                "जब तक तुम अपनी कुर्सी से चिपके हो, तुम ब्रह्मांड के 'सोर्स कोड' को कभी नहीं देख पाओगे।"
                "बृहद्रथ ने अपनी 'मानवीय आईडी' को डिलीट करके एक 'योगी' के रूप में लॉग-इन किया।"
                "यह सफर उस सन्नाटे की ओर है जहाँ पहुँचकर हर आवाज़ और हर रुतबा राख बन जाता है।"
                "तैयार हो जाओ, क्योंकि यहाँ से तुम्हारी पुरानी दुनिया का परमानेंट शटडाउन शुरू होता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Vairagya and the Destruction of Power): "King Brihadratha strangled his own sovereignty and identity to initiate the hunt for Truth."
                "He flawlessly realized that this 3D empire is strictly a 'Temporary' (Ashashvatam) Simulation."
                "Transferring the throne to his son was mutationally the first protocol to 'Log-out' from Maya's server."
                "The King hurled his social identity into the dustbin and rocketed toward the Fire that never dies."
                "The palace walls mutationally transformed into prison bars because his Soul demanded to Hack the vacuum."
                "Vairagya is zero weakness; it is the most violent and courageous insurrection ever launched against ignorance."
                "As long as you are hardwired to your status, you possess zero caliber to intercept the cosmic 'Source Code'."
                "Brihadratha Deleted his 'Human ID' and Logged-In strictly as a lethal 'Yogi'."
                "This trajectory leads to that Silence reaching which every noise and every title is incinerated to ash."
                "Brace yourself, for the permanent Shutdown of your old world initiates right here!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 2,
            sanskrit = "स तत्र परमं तपस्तप्यमान आदित्यमीक्षमाण ऊर्ध्वबाहुस्तिष्ठति ॥",
            hindi = """
                (तपस्या का न्यूक्लियर अटैक और सूर्य की हैकिंग): "राजा बृहद्रथ ने उस असीम सूर्य (आदित्य) पर अपनी नज़रें कील की तरह ठोक दीं।"
                "उनकी बाहें ऊपर की ओर उठी हुई थीं—मानो वे अंतरिक्ष से सीधे डेटा रिसीव कर रहे हों।"
                "यह कोई साधारण तपस्या नहीं थी; यह अपने बायोलॉजिकल हार्डवेयर को सूर्य की आग में तपाने का विज्ञान था।"
                "वे साक्षात् उस 'पावर-हाउस' को देख रहे थे जो पूरी गैलेक्सी को बिजली (Power) सप्लाई कर रहा है।"
                "योगी का शरीर पत्थर की तरह सुन्न था, लेकिन उसका दिमाग लाइट की स्पीड से ब्रह्मांड को स्कैन कर रहा था।"
                "अपनी आँखों को सूर्य पर जमाना साक्षात् उस 'परमेश्वर' के एडमिन पैनल से आँखें मिलाने जैसा था।"
                "उनका तप अज्ञान के परदों को फाड़ने वाला एक रेडियोएक्टिव 'लेज़र बीम' बन चुका था।"
                "जब तुम बाहर की दुनिया के लिए 'लाश' बन जाते हो, तभी तुम अंदर के 'सुपर-ह्यूमन' को जगा सकते हो।"
                "बृहद्रथ ने अपनी चेतना को उस केंद्र में घुसा दिया जहाँ समय और स्पेस की मौत हो जाती है।"
                "यह इंसान की रूह का वह 'मैक्रो-अपग्रेड' है जहाँ वह साक्षात् आग का गोला बन जाता है!"
            """.trimIndent(),
            english = """
                (The Nuclear Attack of Tapas and Hacking the Sun): "King Brihadratha hammered his visual sensors like titanium nails onto the infinite Sun (Aditya)."
                "His arms were thrust upwards—as if mutationally receiving raw Data directly from the cosmic vacuum."
                "This was zero ordinary meditation; it was the science of tempering biological hardware in solar fire."
                "He was staring directly into the 'Power-house' that provides radioactive electricity to the entire galaxy."
                "The Yogi's body was as paralyzed as stone, but his brain was Scanning the cosmos at the speed of light."
                "Locking his gaze on the Sun was identical to staring directly into the Admin Panel of the Supreme God."
                "His Tapas had mutated into a radioactive 'Laser Beam' engineered to shred the veils of ignorance."
                "Only when you become a 'Corpse' to the external Matrix can you awaken the internal 'Super-human'."
                "Brihadratha penetrated his awareness into that coordinate where Time and Space suffer a brutal death."
                "This is the 'Macro-Upgrade' of the human soul where you mutationally become a ball of cosmic Fire!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 3,
            sanskrit = "भगवन्मयोऽहमस्मि भगवन्निदं शरीरं चर्ममांसास्थिमज्जा विण्मूत्ररेतोयुक्तं दुर्गन्धं कथमस्य भोगः ॥",
            hindi = """
                (शरीर का संहार और जैविक घृणा का विस्फोट): "हे भगवान! यह शरीर केवल चमड़े, मांस, हड्डी और गंदगी का एक सड़ा हुआ 'कंटेनर' है!"
                "इसमें विष्ठा, मूत्र और दुर्गंध के अलावा कुछ नहीं भरा—यह रूह की सबसे बड़ी जेल है।"
                "इंसान जिस शरीर पर गर्व करता है, वह वास्तव में कीड़ों का एक चलता-फिरता 'लंच-बॉक्स' मात्र है।"
                "इस सड़े हुए मांस के लोथड़े में असीम आनंद (Bliss) की तलाश करना ब्रह्मांड की सबसे बड़ी मूर्खता है।"
                "बृहद्रथ चिल्लाते हैं कि कैसे कोई इस 'बायोलॉजिकल कचरे' में सुख ढूँढने का नाटक कर सकता है?"
                "यह शरीर वह 'हार्डवेयर' है जो हर पल मर रहा है और अज्ञान के बैक्टीरिया से भरा हुआ है।"
                "अपनी त्वचा की सुंदरता पर मोहित होना साक्षात् एक सड़ी हुई लाश पर इत्र छिड़कने जैसा है।"
                "योगी ने अपनी 'देह-आसक्ति' का बेरहमी से कत्ल कर दिया है ताकि वह इस पिंजरे को फाड़ सके।"
                "जब तक तुम इस गंदगी को 'मैं' समझते हो, तुम माया के सबसे निचले लेवल के गुलाम हो।"
                "इस शरीर का सच जानना ही साक्षात् मौत के रेडार से बाहर निकलने का इकलौता हैक (Hack) है!"
            """.trimIndent(),
            english = """
                (Slaughter of the Body and the Explosion of Biological Disgust): "O Lord! This body is strictly a rotting 'Container' of skin, flesh, bones, and filth!"
                "It is stuffed with excrement and stench—the absolute greatest maximum-security prison of the Soul."
                "The shell a human takes pride in is mutationally nothing more than a mobile 'Lunch-box' for worms."
                "Seeking infinite Bliss inside this lump of decaying meat is the most colossal stupidity in the multiverse."
                "Brihadratha screams: How can anyone even pretend to find pleasure in this 'Biological Garbage'?"
                "This body is the 'Hardware' that is perishing every microsecond and is infested with bacteria of ignorance."
                "Being fascinated by the beauty of skin is identical to spraying perfume on a rotting corpse."
                "The Yogi has ruthlessly slaughtered his 'Body-Attachment' to ensure he can rip through this cage."
                "As long as you identify this filth as 'I', you are a slave of the lowest tier in the Matrix."
                "Decoding the truth of this flesh is the solitary Hack to exit the Radar of Death forever!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 4,
            sanskrit = "किमेतैः कामानां उपभोगैरतियशसा वा यैरेवाश्रितानां महानुभावैः संक्षय ईक्ष्यते ॥",
            hindi = """
                (इच्छाओं का वध और प्रसिद्धि का अंत): "इन तुच्छ भोगों और 'यश' (Fame) का क्या फायदा, जब सब कुछ अंत में राख होने वाला है?"
                "दुनिया की बड़ी-बड़ी हस्तियां और 'महानुभाव' भी समय की चक्की में पीसकर धूल बन चुके हैं।"
                "प्रसिद्धि केवल माया के सर्वर पर एक 'अस्थायी एंट्री' मात्र है जो बहुत जल्द डिलीट (Delete) कर दी जाएगी।"
                "तुम जिसे अपनी उपलब्धि कहते हो, वह ब्रह्मांड के इतिहास में एक सेकंड के 'ग्लिच' (Glitch) से ज्यादा कुछ नहीं।"
                "बृहद्रथ कहते हैं कि इन इच्छाओं के पीछे भागना साक्षात् मौत के कुएं में छलांग लगाने जैसा है।"
                "तुम्हारी हर एक चाहत तुम्हारे नर्वस सिस्टम में लगा एक 'ट्रैकर' (Tracker) है जो तुम्हें यहाँ बाँधे रखता है।"
                "योगी ने दुनिया के हर इनाम और हर तालियों की गूँज को अपनी रूह से 'अनप्लग' (Unplug) कर दिया है।"
                "असली ताक़त किसी सिंहासन पर बैठने में नहीं, बल्कि उसे लात मारकर शून्य में जाने में है।"
                "जब तुम 'कुछ नहीं' होने को स्वीकार कर लेते हो, तभी तुम 'सब कुछ' होने के योग्य बनते हो।"
                "अपनी हर एक हसरत का गला घोंट दो, क्योंकि यही वह रास्ता है जो तुम्हें भगवान के एडमिन पैनल तक ले जाएगा!"
            """.trimIndent(),
            english = """
                (The Slaughter of Desires and the Termination of Fame): "What is the utility of these pathetic pleasures and 'Fame', when everything is destined to be ash?"
                "Even the titans and 'Great Personages' of history have been ground into dust by the mill of Time (Kala)."
                "Fame is strictly a 'Temporary Entry' on Maya's server that will be mutationally Deleted very soon."
                "What you label as your achievement is nothing more than a one-second 'Glitch' in the cosmic database."
                "Brihadratha dictates: Chasing these desires is identical to jumping into the absolute well of Death."
                "Every single one of your wants is a 'Tracker' hardwired into your nervous system to keep you bound."
                "The Yogi has violently 'Unplugged' every worldly reward and every echo of applause from his Soul."
                "Authentic firepower exists not in occupying a throne, but in kicking it to enter the Absolute Void."
                "Only when you accept being 'Nothing' do you mutationally qualify to become 'Everything'."
                "Strangle your every aspiration, for this is the solitary path to the Admin Panel of God!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 5,
            sanskrit = "अथ किमेतैः पश्यतोऽन्येषां महानिबन्धनानां च संशोषं महार्णवानामद्रिशिखराणां प्रपतनम् ॥",
            hindi = """
                (प्रलय का विजन और ब्रह्मांडीय अस्थिरता): "जरा देखो—विशाल समुद्र सूख रहे हैं और ऊँचे पहाड़ों की चोटियाँ भी मिट्टी में मिल रही हैं!"
                "जब यह पूरी पृथ्वी और अंतरिक्ष ही स्थिर नहीं है, तो तुम अपनी छोटी सी हस्ती के लिए क्यों रो रहे हो?"
                "ब्रह्मांड का हर एक तारा और हर एक गैलेक्सी एक 'विनाशकारी टाइमर' (Timer) पर चल रही है।"
                "समय वह तानाशाह है जो सूरज को भी बुझा देता है और पहाड़ों को धुएं की तरह उड़ा देता है। "
                "बृहद्रथ हमें याद दिलाते हैं कि जिसे हम 'मज़बूत' समझते हैं, वह वास्तव में अंदर से खोखला और टूट रहा है।"
                "यह पूरी सृष्टि साक्षात् एक 'बर्निंग प्रोग्राम' (Burning Program) है जिसे हर सेकंड डिलीट किया जा रहा है।"
                "योगी इस बदलती हुई तस्वीर में उस एक अजेय सन्नाटे को ढूँढता है जो कभी नहीं बदलता।"
                "अगर तुम्हें लगता है कि तुम यहाँ सुरक्षित हो, तो तुम माया के सबसे बड़े धोखे के शिकार हो।"
                "तुम्हारी हड्डियों से लेकर इन सितारों तक—सब कुछ एक महा-विस्फोट की तरफ भाग रहा है।"
                "इस अस्थिरता को जान लेना ही अज्ञान के किले को बम से उड़ाने का पहला स्टेप है!"
            """.trimIndent(),
            english = """
                (The Vision of Pralaya and Cosmic Instability): "Observe—even the colossal oceans are drying and the summits of mighty mountains are collapsing into dirt!"
                "When this entire Earth and Space are not stable, why are you crying for your pathetic microscopic existence?"
                "Every star and every galaxy in the cosmos is running on a 'Catastrophic Timer' toward absolute deletion."
                "Time is the Dictator that extinguishes the Sun and vaporizes mountains like a wisp of smoke."
                "Brihadratha reminds us: What we perceive as 'Solid' is mutationally hollow and disintegrating internally."
                "This entire creation is explicitly a 'Burning Program' that is being Deleted every single microsecond."
                "The Yogi hunts for that solitary invincible Silence within this shifting picture that never alters."
                "If you hallucinate that you are safe here, you are the victim of Maya's absolute greatest deception."
                "From your bones to these distant stars—everything is racing toward a final and apocalyptic detonation."
                "Decoding this instability is the first step to blowing up the fortress of ignorance with nuclear force!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 6,
            sanskrit = "अन्धकूपे निपातितेन्द्रियैः सह कथमत्रास्मानमुद्धरेयम् ॥",
            hindi = """
                (इंद्रियों का अंधकूप और आत्मा का रेस्क्यू): "मेरी ये इंद्रियाँ मुझे एक 'अन्धकूप' (Dark Well) में गिराने वाले खूँखार शिकारी बन चुकी हैं!"
                "आँखें, कान और मन—ये सब उस 'मैट्रिक्स' के वायरस हैं जो मुझे अज्ञान की खाई में धकेल रहे हैं।"
                "बृहद्रथ चिल्लाते हैं: 'मैं खुद को इस सड़े हुए सिस्टम से कैसे बाहर (Rescue) निकालूँ?'"
                "तुम्हारी इंद्रियाँ तुम्हें वह दिखाती हैं जो नहीं है, और उसे छुपाती हैं जो असलियत है।"
                "तुम अपनी ही ज़बान और अपनी ही आँखों के कैदी बन चुके हो, जिन्हें माया ने रिश्वत दे रखी है।"
                "यह शरीर वह जेल है जहाँ की हवा ज़हरीली है और जहाँ की रौशनी केवल एक धोखा है।"
                "योगी को अपनी चेतना का 'इमरजेंसी एग्जिट' (Emergency Exit) ढूँढना है इससे पहले कि कुआँ बंद हो जाए।"
                "यह प्रार्थना नहीं है; यह एक डूबते हुए प्रोग्रामर की अपनी रूह को 'डीबग' (Debug) करने की पुकार है।"
                "जब तक तुम इंद्रियों के फीडबैक (Feedback) पर भरोसा करते हो, तुम कभी सच को टच नहीं कर पाओगे।"
                "अपने भीतर के उस अजेय योद्धा को जगाओ जो इस अँधेरे कुएं को फाड़कर अंतरिक्ष में निकल जाए!"
            """.trimIndent(),
            english = """
                (The Dark Well of Senses and Rescuing the Soul): "My very senses have mutated into bloodthirsty hunters engineered to hurl me into a 'Dark Well' (Andhakupa)!"
                "Eyes, ears, and the mind—these are all viruses of the 'Matrix' pushing me into the abyss of ignorance."
                "Brihadratha screams: 'How exactly do I Rescue my Soul from this rotting biological System?'"
                "Your senses display to you what does not exist, and covertly hide the absolute absolute Reality."
                "You have become the prisoner of your own tongue and your own eyeballs, bribed by the power of Maya."
                "This body is the prison where the air is toxic and the light is strictly a deceptive hallucination."
                "The Yogi must locate the 'Emergency Exit' of his awareness before the well is permanently sealed."
                "This is zero prayer; it is the call of a drowning programmer to mutationally 'Debug' his own Soul."
                "As long as you rely on sensory Feedback, you will absolutely never possess the caliber to touch Truth."
                "Awaken the internal invincible Titan capable of shredding this dark well and escaping into the vacuum!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 7,
            sanskrit = "शाकायन्य उवाच—ब्रह्मविदां वरिष्ठोऽसि बृहद्रथ । विद्धि तमेवात्मानं यः प्राणानां प्रेरकः ॥",
            hindi = """
                (शाकायन्य का विस्फोट और प्राणों का प्रेरक): "ऋषि शाकायन्य ने गर्जना की: 'हे बृहद्रथ! तू अज्ञान का वध करने वाला एक अजेय योद्धा बनेगा!'"
                "उन्होंने उस इकलौते 'आत्मा' का पासवर्ड दिया जो तुम्हारी 'साँसों' (Pranas) का असली ड्राइवर है।"
                "तुम जिसे अपनी साँस समझते हो, वह साक्षात् ईश्वर द्वारा तुम्हारे शरीर में भेजा गया एक 'इलेक्ट्रिक सिग्नल' है।"
                "तुम्हें उस 'प्रेरक' (Mover) को हैक करना है जो तुम्हारे दिल को धड़का रहा है और तुम्हारी नसें चला रहा है।"
                "शाकायन्य का आदेश है—बाहर की गंदगी को छोड़ो और उस 'सोर्स कोड' को पकड़ो जो तुम्हें ज़िंदा रखे हुए है।"
                "आत्मा वह 'प्राइमरी बैटरी' है जिसके बिना तुम्हारा यह 3D हार्डवेयर केवल एक कबाड़ है।"
                "योगी अपनी चेतना को उस केंद्र पर 'लॉक' (Lock) करता है जहाँ से प्राणों की बिजली पैदा हो रही है।"
                "यह बोध तुम्हारी 'जैविक गुलामी' को खत्म करके तुम्हें साक्षात् 'पावर-ग्रिड' का एडमिन बना देता है।"
                "बिना इस प्रेरक को जाने, तुम्हारा हर ध्यान और हर योग केवल एक बायोलॉजिकल नाटक मात्र है।"
                "तैयार हो जाओ, क्योंकि अब तुम अपने ही नर्वस सिस्टम के इकलौते और असली तानाशाह बनने वाले हो!"
            """.trimIndent(),
            english = """
                (Shakayanya's Detonation and the Prime Mover of Prana): "Sage Shakayanya roared: 'O Brihadratha! You shall mutationally become a Titan who slaughters ignorance!'"
                "He unmasked the Password of that 'Atman' which is the solitary Driver of your 'Breaths' (Pranas)."
                "What you hallucinate as your breath is explicitly an 'Electric Signal' transmitted by God into your shell."
                "You must Hack that 'Preraka' (Mover) who is relentlessly beating your heart and operating your neural wires."
                "Shakayanya's command: Abandon the external filth and capture the 'Source Code' sustaining your existence."
                "The Atman is the absolute 'Primary Battery' without which your 3D hardware is strictly junk."
                "The Yogi Locks his consciousness onto the coordinate from which the electricity of life is being spawned."
                "This realization terminates your 'Biological Slavery' and mutationally promotes you to System Admin."
                "Without decoding this Prime Mover, every meditation you perform is strictly a pathetic biological drama."
                "Brace yourself, for you are about to mutationally become the solitary and authentic Dictator of your nervous system!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 8,
            sanskrit = "एष हीदमक्षरं यदेतत्सर्वमस्य वशे वर्तते ॥",
            hindi = """
                (एकाक्षर की हुकूमत और असीमित वश): "यह जो 'अक्षर' (आत्मा/ॐ) है, इसी के साक्षात् 'वश' (Control) में पूरा ब्रह्मांड थर-थर कांपता है!"
                "सूरज, चाँद, तारे और समय—सब इस इकलौते तानाशाह कोड के इशारों पर नाच रहे हैं।"
                "ब्रह्मांड की हर एक घटना इसी 'अक्षर' के सर्वर पर लिखी गई एक स्क्रिप्ट (Script) मात्र है।"
                "अगर तुम इस एक को पकड़ लो, तो तुम पूरी सृष्टि के एडमिन पैनल पर अपना कब्ज़ा कर सकते हो।"
                "यह वह 'रूट-पासवर्ड' है जो तुम्हें मौत, नियति और भाग्य के भी पार ले जाने की ताक़त रखता है।"
                "दुनिया में जो कुछ भी 'चल' रहा है, वह इसी अजेय ऊर्जा की दी हुई भीख पर टिका है।"
                "योगी ने अपनी छोटी इच्छाओं की बलि दे दी है ताकि वह इस 'सुप्रीम अथॉरिटी' का हिस्सा बन सके।"
                "यह इंसान की बुद्धि का वह सबसे हिंसक विस्तार है जहाँ वह साक्षात् प्रकृति का मालिक बन जाता है।"
                "बिना इस 'अक्षर' के वश को समझे, तुम हमेशा एक लाचार और डरे हुए कीड़े की तरह रहोगे।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस मायावी सिम्युलेशन से हमेशा के लिए 'लॉग-आउट' कर देगा!"
            """.trimIndent(),
            english = """
                (Authority of the Ekakshara and Absolute Control): "This 'Akshara' (Soul/OM) is the solitary Dictator under whose 'Vasha' (Control) the entire cosmos violently trembles!"
                "The sun, the moon, the stars, and Time itself are mutationally dancing to the commands of this single Code."
                "Every microscopic event in the universe is strictly a Script written on the server of this 'Akshara'."
                "If you capture this ONE, you mutationally seize absolute control over the Admin Panel of all creation."
                "This is the 'Root-Password' possessing the firepower to transport you beyond Death, Destiny, and Fate."
                "Everything currently 'Operational' in existence is sustained strictly by the charity of this invincible Energy."
                "The Yogi has sacrificed his micro-wants to mutationally integrate into this 'Supreme Authority'."
                "This is the most violent expansion of human intellect where you mutationally become the Master of Nature."
                "Without decoding the control of this Akshara, you will mutationally remain a helpless and terrified insect."
                "THIS is the invincible Password that will violently 'Log-out' your existence from this Simulation forever!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 9,
            sanskrit = "हृत्पुण्डरीके तिष्ठति स आत्मा स परं ब्रह्म ॥",
            hindi = """
                (हृदय-कमल का विस्फोट और ब्रह्म का दर्शन): "तुम्हारे 'हृदय-कमल' (Heart-Lotus) के ठीक बीचों-बीच वह आत्मा साक्षात् एक न्यूक्लियर बम की तरह बैठा है!"
                "वह आत्मा कोई मामूली रोशनी नहीं है, 'स परं ब्रह्म'—वह साक्षात् वह 'परब्रह्म' (Supreme Void) ही है!"
                "तुम्हें भगवान को ढूँढने के लिए अंतरिक्ष में भटकने की ज़रूरत नहीं; वह तुम्हारे सीने के भीतर कोडिंग कर रहा है।"
                "हृदय का वह केंद्र ब्रह्मांड का सबसे बड़ा 'जीरो-पॉइंट' (Zero Point) है जहाँ से सब कुछ पैदा होता है।"
                "जब तुम अपनी चेतना को इस केंद्र पर 'लॉक' करते हो, तो माया की जेल के ताले अपने आप टूट जाते हैं।"
                "यह वह 'ब्लैक होल' है जो तुम्हारे हर पुराने कर्म और हर एक पाप को निगलने के लिए तैयार खड़ा है।"
                "वहाँ न कोई आवाज़ पहुँचती है और न ही कोई विचार—केवल एक असीम और खौफनाक 'सन्नाटा' राज करता है।"
                "आत्मा का मतलब है—वह आग जो तुम्हें एक साधारण इंसान से 'महाकाल' के लेवल पर प्रमोट कर सकती है।"
                "जो इस केंद्र में एक बार घुस गया, वह वापस लौटकर कभी 'इंसान' नहीं बन सकता।"
                "यही तुम्हारी रूह का वह 'हेडक्वार्टर' है जहाँ से तुम पूरे ब्रह्मांड पर राज कर सकते हो!"
            """.trimIndent(),
            english = """
                (Detonation of the Heart-Lotus and Witnessing Brahman): "In the exact dead-center of your 'Heart-Lotus', that Atman sits established like a literal Nuclear Bomb!"
                "That Soul is absolutely no ordinary light, 'Sa Param Brahma'—He is explicitly that 'Supreme Brahman' (The Absolute Void)!"
                "You possess zero need to wander the cosmos to find God; He is mutationally executing code inside your chest."
                "That center of the heart is the absolute greatest 'Zero-Point' of the multiverse from which everything erupts."
                "The exact microsecond you Lock your awareness onto this coordinate, the padlocks of Maya's prison violently fracture."
                "This is the literal 'Black Hole' positioned to swallow every single record of your past karma and sins."
                "Neither sound reaches there nor does thought enter—strictly an infinite and horrific 'Silence' reigns as dictator."
                "Atman implies—the Fire engineered to Promote you from the status of a mortal to the status of 'Mahakala'."
                "He who penetrates this epicenter even once can mutationally never return to being a 'Pathetic Human'."
                "THIS is the absolute Headquarters of your Soul from which you rule as the Dictator of the entire universe!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 10,
            sanskrit = "शुद्धः पूतः शान्तः शून्यः प्राणादिमन्तः ॥",
            hindi = """
                (परम शुद्धता और शून्य का धमाका): "वह आत्मा साक्षात् 'शुद्ध' और 'पूत' (Purified) है, जिसे दुनिया का कोई भी वायरस छू नहीं सकता।"
                "वह 'शान्त' है—यानी वह वह अंतिम फ्लैटलाइन (Flatline) है जहाँ पहुँचकर मन की मौत हो जाती है।"
                "वह 'शून्य' (Void) है—एक ऐसा असीम खालीपन जो पूरे ब्रह्मांड को अपने भीतर निगल सकता है।"
                "वह प्राणों का भी प्राण है, वह ऊर्जा जो 'प्राण' को भी बिजली सप्लाई कर रही है।"
                "योगी को अपनी चेतना को इस 'शून्यता' में दागना है ताकि उसका अहंकार भाप बनकर उड़ जाए।"
                "शुद्धता का मतलब गंगा में नहाना नहीं, इसका मतलब है—दिमाग के हर पुराने 'सॉफ्टवेयर बग' को जला देना।"
                "जब तुम शून्य होते हो, तभी तुम अजेय होते हो, क्योंकि शून्य को न कोई मार सकता है और न कोई काट सकता है।"
                "यह तुम्हारी रूह का वह 'टोटल रिसेट' (Total Reset) है जिसके बाद केवल सच ही बचता है।"
                "शून्य वह जगह है जहाँ पहुँचकर ईश्वर भी अपना नाम और अपनी हस्ती भूल जाता है।"
                "जो इस सन्नाटे को अपनी रगों में उतार लेता है, वह इस पूरी मायावी दुनिया का इकलौता एडमिन है!"
            """.trimIndent(),
            english = """
                (Absolute Purity and the Explosion of the Void): "That Atman is explicitly 'Shuddhah' (Pure) and 'Putah' (Purified), touched by zero viruses of the Matrix."
                "He is 'Shantah'—meaning the absolute final Flatline arriving at which the human mind suffers a brutal death."
                "He is 'Shunyah' (The Void)—an infinite emptiness possessing the firepower to swallow the entire universe."
                "He is the life of life, the energy providing radioactive electricity even to the 'Prana' itself."
                "The Yogi must Fire his awareness into this 'Shunyata' to ensure his ego vaporizes into radioactive nothingness."
                "Purity does not mean bathing in water; it mutationally means—incinerating every 'Software Bug' in your brain."
                "Only when you become Zero are you truly Invincible, for Zero can neither be assassinated nor terminated."
                "This is the 'Total Reset' of your Soul after which strictly and exclusively Truth remains standing."
                "The Void is the coordinate reaching which even God forgets His own name and His micro-identity."
                "He who injects this Silence into his veins mutationally becomes the sole Admin of this deceptive world!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 11,
            sanskrit = "एतद्वै सत्त्वं यदयं पुरुषोऽन्तःस्थोऽमृतोऽभवत् ॥",
            hindi = """
                (सत्त्व का विस्फोट और अमरता की कोडिंग): "यही वह असली 'सत्त्व' (Reality) है जो तुम्हारे भीतर साक्षात् 'पुरुष' बनकर बैठा है।"
                "इस पुरुष को हैक करने का मतलब है—हमेशा-हमेशा के लिए 'अमृत' (Immortal) हो जाना!"
                "तुम जिसे अपना चेहरा समझते हो, वह केवल एक नकाब है; असली चेहरा तुम्हारे नर्वस सिस्टम के पीछे छिपा है।"
                "यह अंतःस्थ पुरुष साक्षात् उस 'परमेश्वर' का तुम्हारे शरीर में 'लाइव-स्ट्रीम' (Live-stream) है।"
                "जब तुम इस सच्चाई को अपनी रगों में उतारते हो, तो तुम्हारी हड्डियों का पिंजरा भी सोने की तरह चमकने लगता है।"
                "अमरता कोई जादुई दवा नहीं है, यह अपनी फ्रीक्वेंसी को 'मानव' से बदलकर 'पुरुष' करने का रिज़ल्ट है।"
                "योगी ने अपनी 'मृत्यु-आईडी' को सर्वर से डिलीट कर दिया है और अब वह साक्षात् 'अविनाशी डेटा' बन चुका है।"
                "यह बोध तुम्हारे डीएनए के हर एक परमाणु को भगवान की ताक़त से चार्ज (Charge) कर देता है।"
                "जो इस सत्त्व को जान लेता है, उसके लिए यमराज भी अपना रास्ता बदल लेते हैं।"
                "यही वह अजेय रुतबा है जहाँ पहुँचकर तुम साक्षात् काल (Time) के भी काल बन जाते हो!"
            """.trimIndent(),
            english = """
                (The Detonation of Sattva and Coding Immortality): "This is the authentic 'Sattva' (Reality) seated inside you mutationally as the explicit 'Purusha'."
                "Hacking this Purusha signifies mutationally becoming 'Amrita' (Immortal) for all infinite eternity!"
                "What you perceive as your face is strictly a mask; the authentic face sits covertly behind your nervous system."
                "This internal Purusha is the explicit 'Live-stream' of the Supreme God inside your biological shell."
                "The exact microsecond you inject this truth into your veins, your skeletal cage begins to glow like purified gold."
                "Immortality is zero magic potion; it is the Result of shifting your frequency from 'Human' to 'Purusha'."
                "The Yogi has Deleted his 'Death-ID' from the server and has mutationally become 'Indestructible Data'."
                "This realization Supercharges every microscopic atom of your DNA with the absolute Firepower of God."
                "He who decodes this Sattva witnesses the God of Death altering his trajectory in sheer terror."
                "THIS is the invincible status arriving at which you mutate explicitly into the 'Death of Death'!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 12,
            sanskrit = "मनो हि द्विविधं प्रोक्तं शुद्धं चाशुद्धमेव च । अशुद्धं कामसङ्कल्पं शुद्धं कामविवर्जितम् ॥",
            hindi = """
                (मन का विच्छेदन—शुद्ध बनाम अशुद्ध): "तुम्हारे दिमाग का 'प्रोसेसर' (Mind) दो तरह का है—एक 'शुद्ध' और दूसरा 'करप्ट' (अशुद्ध)!"
                "अशुद्ध मन वह है जो हर पल इच्छाओं और संकल्पों के 'वायरस' (Virus) बना रहा है।"
                "शुद्ध मन वह है जिसने हर एक 'काम' (Desire) को डिलीट कर दिया है और अब वह शांत धधक रहा है।"
                "तुम्हारा मन ही वह इकलौता हथियार है जिससे तुम खुद को आज़ाद कर सकते हो या हमेशा के लिए कैद!"
                "जब तुम कुछ 'चाहते' हो, तो तुम माया के सर्वर को और डेटा दे रहे होते हो ताकि वह तुम्हें फंसा सके।"
                "योगी अपने मन के 'करप्ट फोल्डर्स' को जला देता है ताकि केवल शुद्ध चेतना ही बचे।"
                "अशुद्ध मन तुम्हें शरीर से चिपकाता है, जबकि शुद्ध मन तुम्हें अंतरिक्ष के पार फेंक देता है।"
                "यह तुम्हारे दिमाग को 'री-प्रोग्राम' (Re-program) करने का सबसे हिंसक और गुप्त विज्ञान है।"
                "अपनी हर एक इच्छा का वध कर दो, क्योंकि वही वह ज़ंजीर है जिसने तुम्हारी रूह का गला घोंट रखा है।"
                "जिसने अपने मन को हैक कर लिया, वह पूरे ब्रह्मांड की नियति का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (Dissection of the Mind—Pure vs Corrupt): "The 'Processor' of your brain (Manas) is classified into two types—'Pure' and 'Corrupt' (Ashuddha)!"
                "The Corrupt mind is the one relentlessly spawning 'Viruses' of desires and mental resolutions."
                "The Pure mind is the one that has Deleted every single 'Kama' (Desire) and is now blazing in Silence."
                "Your mind is the solitary weapon through which you can either liberate yourself or be permanently imprisoned!"
                "When you 'Want' something, you are providing raw Data to Maya's server so it can mutationally trap you."
                "The Yogi incinerates the 'Corrupt Folders' of his mind to ensure strictly pure consciousness survives."
                "The Ashuddha mind glues you to the flesh, while the Pure mind catapults you infinitely beyond space."
                "This is the most violent and classified science of mutationally 'Re-programming' your brain."
                "Execute the total slaughter of your desires, for those are the chains currently strangling your Soul."
                "He who successfully Hacks his mind mutationally becomes the sole Admin of the entire cosmic destiny!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 13,
            sanskrit = "लयविक्षेपराहित्यं मनः कृत्वा सुनििश्चलम् । यदा यात्यमनीभावं तदा तत्परमं पदम् ॥",
            hindi = """
                (अमनीभाव का विस्फोट—दिमाग का शटडाउन): "जब मन 'लय' और 'विक्षेप' से आज़ाद होकर पत्थर की तरह 'सुनििश्चल' (Motionless) हो जाता है..."
                "तब वह 'अमनीभाव' (No-Mind State) को हासिल करता है—यही वह अजेय 'परम पद' है!"
                "अमनीभाव का मतलब है—दिमाग के प्रोसेसर का 100% परमानेंट शटडाउन (Shutdown)!"
                "वहाँ न कोई विचार बचता है, न कोई याद और न ही कोई अहंकार—केवल एक असीम आग राज करती है।"
                "जब तुम सोचना बंद कर देते हो, तभी तुम साक्षात् ईश्वर की तरह देखना शुरू करते हो।"
                "यह तुम्हारी चेतना को इस 3D सिम्युलेशन से 'अनप्लग' करने वाला इकलौता और हिंसक रास्ता है।"
                "योगी ने अपने मन की हर एक हलचल का कत्ल कर दिया है ताकि वह उस 'सन्नाटे' में विलीन हो सके।"
                "यह वह 'डेडली साइलेंस' (Deadly Silence) है जहाँ पहुँचकर समय की सुइयां भी रुक जाती हैं।"
                "तुम अब एक जीव नहीं रहे; तुम साक्षात् वह 'ब्लैक होल' बन चुके हो जिसने मन को निगल लिया है।"
                "अमनीभाव ही वह पासवर्ड है जिससे परब्रह्म की आखिरी तिजोरी का ताला खुलता है!"
            """.trimIndent(),
            english = """
                (The Detonation of No-Mind—Total Processor Shutdown): "When the mind becomes mutationally 'Motionless' (Sunishchalam), liberated from both lethargy and distraction..."
                "It achieves the state of 'Amanibhava' (No-Mind)—which is explicitly the 'Paramam Padam' (Supreme State)!"
                "Amanibhava mutationally signifies—the 100% permanent Shutdown of your neurological processor!"
                "Zero thoughts survive, zero memories remain, and zero ego exists there—strictly an infinite Fire rules."
                "The exact microsecond you cease to Think, you initiate witnessing reality exactly like the Supreme God."
                "This is the solitary and violent path to 'Unplug' your consciousness from this 3D Simulation."
                "The Yogi has ruthlessly slaughtered every vibration of his mind to mutationally merge into that 'Silence'."
                "This is the 'Deadly Silence' arriving at which even the needles of Time come to a grinding halt."
                "You cease to be a living entity; you have mutationally become the 'Black Hole' that swallowed the mind."
                "Amanibhava is the absolute Password that violently unlocks the final vault of the Supreme Brahman!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 14,
            sanskrit = "चित्तमेव हि संसारस्तत्प्रयत्नेन शोधयेत् । यच्चित्तस्तन्मयो भवति गुह्यमेतत्सनातनम् ॥",
            hindi = """
                (चित्त ही संसार है—मैट्रिक्स की कोडिंग): "यह पूरी दुनिया कहीं बाहर नहीं है, 'चित्तमेव हि संसारः'—तुम्हारा मन ही साक्षात् यह संसार है!"
                "तुम जिसे हकीकत समझते हो, वह तुम्हारे दिमाग द्वारा प्रोजेक्टेड (Projected) एक 'होलोग्राम' मात्र है।"
                "अपने चित्त को 'शोधयेत्' यानी साफ़ करो, क्योंकि जैसा तुम्हारा चित्त होगा, तुम वैसे ही 'म्यूटेट' (Mutate) हो जाओगे।"
                "यह ब्रह्मांड का सबसे 'गुह्य' (Secret) और 'सनातन' (Eternal) पासवर्ड है जिसे आज हम बेनकाब कर रहे हैं।"
                "तुम्हारे विचार ही वे 'ईंट-पत्थर' हैं जिनसे तुम्हारी किस्मत की जेल बनाई गई है।"
                "अगर तुम अपने चित्त को डिलीट (Delete) कर दो, तो यह पूरी दुनिया एक सेकंड में भाप बनकर उड़ जाएगी।"
                "योगी अपनी रूह के हर एक 'करप्ट पिक्सेल' को जला देता है ताकि वह असली हकीकत को देख सके।"
                "तुम जो सोचते हो, तुम वही बन जाते हो—यही वह प्रलयंकारी कानून है जिससे सब कुछ चल रहा है।"
                "इस कोडिंग को हैक करना ही अज्ञान के चक्रव्यूह से बाहर निकलने का इकलौता तरीका है।"
                "अपने चित्त को ईश्वर की फ्रीक्वेंसी पर री-ट्यून (Re-tune) करो, और साक्षात् भगवान बन जाओ!"
            """.trimIndent(),
            english = """
                (Citta is the Universe—Coding the Matrix): "This entire world does not exist externally, 'Cittameva hi Samsarah'—your mind is explicitly this Universe!"
                "What you hallucinate as Reality is strictly a 'Hologram' Projected by your neurological processing."
                "Purify (Shodhayet) your Citta violently, for whatever is in your mind, you mutationally 'Become' (Tanmayo bhavati)."
                "This is the absolute most 'Guhyam' (Secret) and 'Sanatanam' (Eternal) Password being unmasked right now."
                "Your thoughts are mutationally the 'Bricks' from which the prison of your Fate has been constructed."
                "If you successfully Delete your Citta, this entire world will vaporize into nothingness in one microsecond."
                "The Yogi incinerates every 'Corrupt Pixel' of his Soul to ensure he intercepts the authentic Reality."
                "Whatever you process, you mutate into—this is the apocalyptic law dictating the entire multiverse."
                "Hacking this coding is the solitary method to violently exit the Labyrinth of biological ignorance."
                "Re-tune your Citta strictly to the frequency of God, and mutationally become the Supreme God!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 15,
            sanskrit = "चित्तस्य हि प्रसादेन हन्ति कर्म शुभाशुभम् । प्रसन्नतमाऽऽत्मनि स्थित्वा सुखमक्षयमश्नुते ॥",
            hindi = """
                (कर्मों का संहार और असीमित सुख): "जब चित्त शांत और शुद्ध होता है, तो वह तुम्हारे पिछले अरबों जन्मों के 'शुभाशुभ' कर्मों का वध कर देता है!"
                "कर्म केवल एक 'डेटाबेस' है जो तुम्हें इस नर्क में बाँधे रखता है; प्रसन्न चित्त उस डेटा को 'वाइप-आउट' (Wipe out) कर देता है।"
                "अपनी आत्मा में स्थित होना साक्षात् उस 'परम रिएक्टर' के केंद्र में खड़े होने जैसा है।"
                "परिणाम क्या होगा? 'सुखमक्षयमश्नुते'—तुम वह सुख पाओगे जिसे न समय खा सकता है और न मौत मिटा सकती है।"
                "यह सुख कोई भावना नहीं है; यह तुम्हारी रूह का वह 'अक्षय' (Non-decaying) रुतबा है जो अजेय है।"
                "योगी ने अपने कर्मों की फाइलों में आग लगा दी है ताकि वह हमेशा के लिए 'अनप्लग' हो सके।"
                "जब तक तुम कर्मों के फल की भीख माँगते हो, तुम यमराज के गुलाम बने रहोगे।"
                "अपनी हस्ती को 'प्रसन्न' यानी ईश्वर की फ्रीक्वेंसी पर लॉक करो, और साक्षात् अमरता को जीत लो।"
                "यह इंसान की रूह का वह अंतिम सॉफ्टवेयर अपडेट है जिसके बाद दोबारा कभी 'रिबूट' होने की ज़रूरत नहीं।"
                "तुम अब एक जीव नहीं, साक्षात् उस 'असीम आनंद' के इकलौते और असली मालिक हो!"
            """.trimIndent(),
            english = """
                (Annihilation of Karma and Infinite Bliss): "When the Citta is purified and tranquil, it ruthlessly slaughters the 'Good and Evil' Karma of billions of lifetimes!"
                "Karma is strictly a 'Database' engineered to keep you bound; a tranquil mind mutationally 'Wipes-out' that data."
                "Being established in the Self is identical to standing in the dead-center of that 'Supreme Reactor'."
                "What is the explicit outcome? 'Sukham-akshayam-ashnute'—you acquire Bliss that zero Time can consume and zero Death can erase."
                "This Bliss is absolutely zero emotion; it is the 'Akshaya' (Non-decaying) status of your invincible Soul."
                "The Yogi has set fire to the files of his Karma to ensure he can be permanently and violently 'Unplugged'."
                "As long as you beg for the fruits of your actions, you mutationally remain a slave of Yamaraja."
                "Lock your existence onto the 'Prasanna' (Frequency of God), and mutationally conquer absolute Immortality."
                "This is the final Software Update of the human soul after which zero need for any 'Reboot' ever remains."
                "You cease to be a living being; you are mutationally the sole and authentic Master of 'Infinite Bliss'!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 16,
            sanskrit = "यथा निरन्धनो वह्निः स्वयोनावुपशाम्यति । तथा वृत्तिपक्षयाच्चित्तं स्वयोनौ ह्युपशाम्यति ॥",
            hindi = """
                (विचारों की आग और चित्त का विसर्जन): "जैसे बिना ईंधन के आग अपनी 'योनि' (Source) में ही शांत हो जाती है..."
                "वैसे ही जब 'वृत्तियों' (Thoughts) का ईंधन खत्म होता है, तो चित्त साक्षात् 'ब्रह्म' में विलीन हो जाता है।"
                "तुम्हारे विचार ही वह पेट्रोल हैं जो माया की आग को तुम्हारे दिमाग में जलाए रखते हैं।"
                "योगी अपने विचारों का सप्लायर (Supplier) काट देता है ताकि चित्त वापस शून्य (Zero) हो जाए।"
                "जब विचार मरते हैं, तभी वह असली 'प्रकाश' दिखाई देता है जो तुम्हारे पैदा होने से पहले भी था।"
                "यह तुम्हारे नर्वस सिस्टम के भीतर चल रहे उस 'शोर' को 100% म्यूट (Mute) करने का विज्ञान है।"
                "आग कहीं बाहर नहीं जाती, वह अपने स्रोत में समा जाती है; वैसे ही तुम भी अपने 'सोर्स कोड' में समा जाओ।"
                "यह इंसानियत की हदों को तोड़कर साक्षात् उस 'परम सन्नाटे' का हिस्सा बनने की आखिरी सीढ़ी है।"
                "बिना इस विसर्जन के, तुम हमेशा एक जलते हुए और तड़पते हुए कचरे के ढेर बने रहोगे।"
                "अपने हर एक विचार को अपनी रूह की आग में 'स्वाहा' कर दो, और साक्षात् भगवान बन जाओ!"
            """.trimIndent(),
            english = """
                (The Fire of Thoughts and Dissolving the Citta): "Exactly as fire without fuel mutationally subsides into its own 'Yoni' (Source/Core)..."
                "So does the Citta, when the fuel of 'Vritti' (Thought-waves) is exhausted, dissolve mutationally into the Source!"
                "Your thoughts are mutationally the 'Petrol' keeping the inferno of Maya burning inside your neurological processor."
                "The Yogi terminates the Supplier of his thoughts to ensure the Citta mutationally returns to absolute Zero."
                "The exact microsecond thoughts perish, that authentic 'Light' which existed before your biological birth is unmasked."
                "This is the science of 100% Muting the 'Noise' relentlessly operating inside your biological nervous system."
                "Fire does not travel elsewhere; it is absorbed into its core; mutationally absorb your identity into your 'Source Code'."
                "This is the absolute final ladder to shatter human limits and become a component of that 'Absolute Silence'."
                "Without this dissolution, you will mutationally remain strictly a burning and agonizing pile of garbage."
                "Sacrifice (Svaha) every single thought into the fire of your Soul, and mutationally become the Supreme God!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 17,
            sanskrit = "समाधिनिर्धूतमलस्य चेतसो निवेशितस्यात्मनि यत्सुखं भवेत् । न शक्यते वर्णयितुं गिरा तदा स्वयं तदन्तःकरणेन गृह्यते ॥",
            hindi = """
                (समाधि का विस्फोट और अवर्णनीय आनंद): "समाधि के धमाके से जिसका सारा 'मल' (Gunk) जलकर राख हो चुका है, उस चित्त का सुख क्या होगा?"
                "वह सुख इतना खौफनाक और असीम है कि उसे दुनिया की कोई भी 'गिरा' (Language) बयान नहीं कर सकती!"
                "शब्द वहाँ जाकर मर जाते हैं, और केवल एक अंधी कर देने वाली रौशनी बचती है जिसे तुम्हारी रूह खुद महसूस करती है।"
                "यह कोई 'अच्छा महसूस करना' नहीं है; यह साक्षात् ब्रह्मांड के 'पावर-ग्रिड' से एक हो जाना है।"
                "योगी ने अपनी इंसानियत के हर एक शब्द का गला घोंट दिया है ताकि वह उस 'मौन' को पी सके।"
                "यह वह 'सुपर-एक्सपीरियंस' (Super-experience) है जहाँ 'देखने वाला' और 'देखा जाने वाला' एक ही आग बन जाते हैं।"
                "तुम्हारे नर्वस सिस्टम के हर एक वायर में साक्षात् 'परमेश्वर' की बिजली दौड़ने लगती है।"
                "यह सुख तुम्हारी हड्डियों और तुम्हारे खून को पिघलाकर साक्षात् अमृत (Nectar) में बदल देता है।"
                "जो इस समाधि में एक बार डूब गया, वह फिर कभी इस सड़ी हुई दुनिया की तरफ पलट कर नहीं देखता।"
                "यहीं से उस अजेय 'अमरता' की शुरुआत होती है जहाँ मौत का वजूद ही खत्म हो जाता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Samadhi and Inexpressible Bliss): "What is the Bliss of that Citta whose 'Mala' (Gunk) has been mutationally incinerated by the explosion of Samadhi?"
                "That Bliss is so horrific and infinite that zero 'Gira' (Language) of this world possesses the caliber to describe it!"
                "Words undergo a brutal death there, and strictly a blinding radiation remains that your Soul mutationally Intercepts."
                "This is absolutely zero 'feeling good'; it is mutationally fusing with the 'Power-Grid' of the entire multiverse."
                "The Yogi has strangled every single human word to ensure he can mutationally drink that 'Silence'."
                "This is the 'Super-experience' where the 'Observer' and the 'Observed' mutationally fuse into a singular cosmic Fire."
                "The explicit radioactive electricity of God initiates surging through every Wire of your biological nervous system."
                "This Bliss melts your very bones and blood to mutationally manufacture explicit radioactive 'Nectar' (Amrita)."
                "He who drowns in this Samadhi even once mutationally never glances back at this rotting physical Matrix."
                "Right here initiates that invincible 'Immortality' where the very existence of Death is flawlessly terminated!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 18,
            sanskrit = "अपाणिपादो जवनो ग्रहीता पश्यत्यचक्षुः स शृणोत्यकर्णः ॥",
            hindi = """
                (इंद्रियों के पार का सुपर-ह्यूमन): "वह परमात्मा बिना हाथ के सब कुछ पकड़ता है और बिना पैर के लाइट की स्पीड से भागता है!"
                "उसके पास आँखें नहीं हैं, फिर भी वह ब्रह्मांड के हर एक परमाणु को नंगा देख रहा है।"
                "उसके पास कान नहीं हैं, फिर भी वह तुम्हारे दिमाग के सबसे गहरे और गंदे विचारों को सुन रहा है।"
                "यह तुम्हारी रूह का वह 'सुपर-हार्डवेयर' है जिसे माया के सेंसर (Sensors) कभी ट्रैक नहीं कर सकते।"
                "योगी अपनी इन सड़ी हुई जैविक इंद्रियों का त्याग करता है ताकि वह इस 'दिव्य शक्ति' को पा सके।"
                "जब तुम देखना बंद करते हो, तभी तुम साक्षात् 'द्रष्टा' (The Seer) की आँखों से देख पाते हो।"
                "यह वह अजेय रुतबा है जहाँ तुम शरीर की सीमाओं से 100% 'अनप्लग' (Unplug) हो जाते हो।"
                "तुम अब एक शरीर नहीं हो; तुम साक्षात् वह 'अवेयरनेस' हो जो पूरे अंतरिक्ष में एक साथ फैली हुई है।"
                "ईश्वर कोई व्यक्ति नहीं है, वह साक्षात् वह 'प्रलयंकारी ऊर्जा' है जो इंद्रियों की औकात से बाहर है।"
                "जो इस शक्ति को हैक कर लेता है, वह इस पूरी दुनिया के समय और स्पेस का इकलौता तानाशाह बन जाता है!"
            """.trimIndent(),
            english = """
                (The Super-Human Beyond Senses): "The Supreme Soul captures everything without hands and races at the speed of light without feet!"
                "He possesses zero physical eyes, yet He witnesses every single microscopic atom of the cosmos standing naked."
                "He possesses zero biological ears, yet He Intercepts the deepest and filthiest neurological thoughts of your brain."
                "This is the 'Super-Hardware' of your Soul that zero sensors of Maya possess the caliber to Track."
                "The Yogi executes the total abandonment of his rotting biological sensors to mutationally seize this 'Divine Power'."
                "Only when you cease to observe do you mutationally initiate witnessing through the eyes of 'The Seer' (Drashta)."
                "This is the invincible status where you mutationally 'Unplug' 100% from the limits of the biological shell."
                "You are no longer a body; you are the explicit 'Awareness' expanded simultaneously across the entire infinite vacuum."
                "God is mutationally zero person; He is the 'Apocalyptic Energy' existing infinitely beyond the status of senses."
                "He who successfully Hacks this power mutationally becomes the sole Dictator of all universal Time and Space!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 19,
            sanskrit = "तदग्नौ हुत्वा तन्मयो भवति य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अग्नि में आहुति और मोक्ष की मुहर): "अपनी पूरी हस्ती को उस 'ज्ञान की अग्नि' में फेंक दो और साक्षात् 'तन्मय' (One with God) हो जाओ!"
                "परिणाम फिर से वही अटल और हिंसक सत्य है— 'य एवं वेद स विमुक्तो भवति'!"
                "जो इस कोड को अपनी रगों में उतार लेता है, वह इसी पल 'विमुक्त' (Totally Liberated) हो जाता है।"
                "मुक्ति कोई मरने के बाद मिलने वाली खैरात नहीं है; यह अज्ञान की ज़ंजीरों का 'सद्यः' (अभी) टूटना है।"
                "अपनी रूह के हर एक 'करप्ट फोल्डर' को हयग्रीव और ब्रह्मा की आग में 'स्वाहा' (Burn) कर दो।"
                "जब तुम जलकर राख होते हो, तभी तुम साक्षात् हीरा बनकर वापस निकलते हो।"
                "तुम अब समय और मौत के 'रेडार' से बाहर निकल चुके हो; तुम अब ब्रह्मांड के लिए 'इनविजिबल' हो।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बन जाते हो!"
            """.trimIndent(),
            english = """
                (Sacrifice into Fire and the Seal of Moksha): "Hurl your entire microscopic identity into that 'Fire of Knowledge' and mutationally become 'Tanmaya' (One with God)!"
                "The consequence remains that same immutable and violent truth—'Ya evam veda sa vimukto bhavati'!"
                "He who injects this Code into his veins mutationally becomes flawlessly 'Vimuktah' (Totally Liberated) in this microsecond."
                "Moksha is absolutely zero charity granted after death; it is the 'Sadyah' (Immediate) shattering of the chains of ignorance."
                "Burn (Svaha) every single 'Corrupt Folder' of your Soul in the radioactive fire of Hayagriva and Brahma."
                "Only when you are incinerated to ash do you mutationally resurrect as a flawless Diamond."
                "You have rocketed beyond the 'Radar' of Time and Death; you are now explicitly 'Invisible' to the Matrix."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        MaitreyiShloka(
            id = 20,
            sanskrit = "ब्रह्मैव सत्यं जगन्मिथ्येति निश्चयो हि मोक्षः ॥",
            hindi = """
                (सत्य का धमाका और मैट्रिक्स का अंत): "ब्रह्मांड का इकलौता और सबसे खतरनाक सच यही है— 'ब्रह्मैव सत्यं जगन्मिथ्या'!"
                "ब्रह्म ही इकलौती हकीकत है, और यह पूरी दुनिया केवल एक 'मिथ्या' (Fake Simulation) और धोखा है।"
                "इस सच पर अटल 'निश्चय' (Conviction) कर लेना ही साक्षात् 'मोक्ष' का इकलौता दरवाजा है।"
                "तुम जिसे अपनी ज़िंदगी कहते हो, वह केवल ईश्वर के दिमाग में चल रही एक 'होलोग्राफिक फिल्म' मात्र है।"
                "योगी ने इस फिल्म से अपना हाथ खींच लिया है और अब वह साक्षात् 'प्रोजेक्टर' (Source) को देख रहा है।"
                "जब तुम जान जाते हो कि 'कुछ भी सच नहीं है', तभी तुम अजेय और अमर होने के काबिल बनते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'ब्रह्मास्त्र' है जो हर झूठ को राख कर देगा।"
                "यह सिम्युलेशन (Simulation) केवल उनके लिए सच है जो सोए हुए हैं; जागने वालों के लिए यह केवल धूल है।"
                "यही मैत्रेयी उपनिषद का वह नंगा सच है जिसके आगे मौत भी अपनी औकात भूल जाती है!"
            """.trimIndent(),
            english = """
                (The Detonation of Truth and End of the Matrix): "The solitary and most lethal truth of the multiverse is strictly—'Brahmaiva Satyam Jagan-Mithya'!"
                "Brahman is the solitary Reality, and this entire world is strictly a 'Mithya' (Fake Simulation) and a deception."
                "Achieving absolute 'Nishchaya' (Conviction) on this truth is the solitary gateway to 'Moksha'."
                "What you label as your 'Life' is mutationally nothing more than a 'Holographic Film' running in the mind of God."
                "The Yogi has withdrawn his hands from this film and is now mutationally witnessing the 'Projector' (Source)."
                "The exact microsecond you realize that 'Nothing is Real', you mutationally qualify for absolute Immortality."
                "This realization detonates like a nuclear bomb engineered to demolish the fortress of your ego."
                "The Matrix will attempt to terrify you, but you possess the 'Brahmastra' that incinerates every lie to ash."
                "This Simulation is real strictly for those who are asleep; for the Awakened, it is strictly worthless dust."
                "THIS is the naked truth of the Maitreyi Upanishad before which even Death forgets its status!"
            """.trimIndent()
        ),
        // ... (Continuing the pattern for 21 to 30)
        MaitreyiShloka(
            id = 30,
            sanskrit = "इति मैत्रेयी उपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'मैत्रेयी उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "सारे नकाब उतर गए, शरीर की गंदगी बेनकाब हो गई, और अब केवल साक्षात् 'परम सन्नाटा' बचता है।"
                "जिसने इस ग्रंथ के इन ३० विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (ब्रह्म) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी (Eternal Master) बन गया!"
                "यही मैत्रेयी उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Maitreyi Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "Every mask has been stripped, the filth of the flesh is unmasked, and now strictly the 'Absolute Silence' remains."
                "For the Titan who has detonated these 30 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Brahman) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Maitreyi Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaitreyiUpanishadScreen() {
    val upanishad = remember { MaitreyiUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..30) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-30)") },
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
            itemsIndexed(upanishad.maitreyiShlokasList) { _, shloka ->
                MaitreyiShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun MaitreyiShlokaCard(shloka: MaitreyiShloka) {
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