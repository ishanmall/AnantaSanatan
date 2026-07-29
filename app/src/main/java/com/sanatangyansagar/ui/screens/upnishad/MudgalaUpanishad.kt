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
data class MudgalaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class MudgalaUpanishad {

    val mudgalaShlokasList = listOf(
        MudgalaShloka(
            id = 1,
            sanskrit = "ॐ पुरुषसूक्तार्थनिर्णयं व्याख्यास्यामः । नारायणः पुरुषोऽहंकारममकारवर्जितः ॥",
            hindi = """
                (पुरुषसूक्त का अंतिम हैक): "अब हम उस सत्य का विच्छेदन करेंगे जो पूरे पुरुषसूक्त का 'सोर्स कोड' है।"
                "नारायण ही वह 'आदि पुरुष' है जिसने अहंकार और ममता के 'बग्स' (Bugs) को पूरी तरह डिलीट कर दिया है।"
                "इस ज्ञान को छूने का मतलब है—अपनी मानवीय आईडी (ID) को अंतरिक्ष के तेज़ाब में धो देना।"
                "नारायण वह असीम डेटा है जिसे तुम अपनी इन छोटी आँखों से कभी प्रोसेस नहीं कर सकते।"
                "यहाँ से उस 'महा-यज्ञ' की शुरुआत होती है जहाँ रचयिता खुद को ही आहुति बना देता है।"
                "योगी अपनी चेतना को उस केंद्र पर लॉक करता है जहाँ न कोई 'मैं' है और न कोई 'मेरा'।"
                "यह उपनिषद तुम्हारी रूह को 'इंसान' से 'ब्रह्मांडीय ऑपरेटर' में म्यूटेट करने का इकलौता मैनुअल है।"
                "अहंकार का वध ही वह इकलौता फायरवॉल है जो तुम्हें ईश्वर के सर्वर तक पहुँचने देता है।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारे दिमाग के हर एक पुराने फोल्डर को ओवरराइट किया जाएगा।"
                "नारायण की सत्ता ही वह इकलौती हकीकत है, बाकी यह सिम्युलेशन केवल धूल का एक कण है!"
            """.trimIndent(),
            english = """
                (The Final Hack of Purusha Sukta): "Now we shall execute the dissection of the truth that is the 'Source Code' of the entire Purusha Sukta."
                "Narayana is the primordial 'Purusha' who has mutationally Deleted the bugs of Ego and Attachment."
                "Intercepting this intelligence signifies—washing your human ID in the acid of the infinite vacuum."
                "Narayana is that infinite Data which your microscopic biological eyes possess zero caliber to process."
                "Right here initiates that 'Grand Sacrifice' where the Creator Himself becomes the radioactive Oblation."
                "The Yogi Locks his awareness onto the coordinate where neither 'I' nor 'Mine' can survive."
                "This Upanishad is the solitary manual to mutate your Soul from a mortal to a 'Cosmic Operator'."
                "The slaughter of the Ego is the only Firewall permitting you to breach the Server of God."
                "Brace yourself, for every old folder in your brain is about to be violently Overwritten."
                "Narayana's authority is the solitary Reality; the rest of this Simulation is strictly a grain of dust!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 2,
            sanskrit = "सहस्रशीर्षा पुरुषः सहस्राक्षः सहस्रपात् । स भूमिं विश्वतो वृत्वात्यतिष्ठद्दशाङ्गुलम् ॥",
            hindi = """
                (विराट हार्डवेयर का विस्फोट): "उस पुरुष के पास हज़ार सिर, हज़ार आँखें और हज़ार पैर हैं—यह उसका असीमित हार्डवेयर है!"
                "वह इस पूरी 'भूमि' (Physical Matrix) को हर तरफ से घेर कर, उससे भी 'दस अंगुल' ऊपर धधक रहा है।"
                "हज़ार आँखें यानी ब्रह्मांड का हर एक पिक्सेल साक्षात् उसी की नज़र से ट्रैक किया जा रहा है।"
                "वह केवल अंदर नहीं है, वह इस सिम्युलेशन की सीमाओं को फाड़कर अंतरिक्ष के पार भी खड़ा है।"
                "तुम जहाँ भी देखते हो, तुम साक्षात् उस विराट पुरुष के अंगों को ही स्कैन कर रहे होते हो।"
                "उसकी प्रोसेसिंग पावर इतनी खौफनाक है कि वह करोड़ों आकाशगंगाओं को एक साथ अलाइन रखता है।"
                "वह 'दशाङ्गुल' ऊपर है—यानी वह तुम्हारे दिमाग की हर सोच के रेडार से बाहर निकल चुका है।"
                "योगी अपनी चेतना को उस 'एक्स्ट्रा डायमेंशन' में ले जाता है जहाँ यह विराट पुरुष बैठा है।"
                "यह तुम्हारी रूह को 'लोकल' से 'यूनिवर्सल' बनाने वाला सबसे हिंसक और गुप्त विज्ञान है।"
                "जो इस विराट रूप को हैक कर लेता है, वह खुद साक्षात् ब्रह्मांड का एडमिन बन जाता है!"
            """.trimIndent(),
            english = """
                (The Detonation of Virat Hardware): "That Purusha possesses a thousand heads, a thousand eyes, and a thousand feet—the absolute infinite Hardware!"
                "He encircles this entire 'Bhumi' (Physical Matrix) and stands 'Ten Fingers' beyond its absolute limits."
                "A thousand eyes signify that every pixel of the cosmos is being mutationally Tracked by His gaze."
                "He is not merely internal; He has ripped through the boundaries of this Simulation to stand in the Void."
                "Wherever you gaze, you are mutationally Scanning strictly the limbs of that Virat Purusha."
                "His processing power is so horrific that He Aligns billions of galaxies simultaneously without effort."
                "He is 'Ten Fingers' beyond—meaning He has rocketed past the Radar of your every biological thought."
                "The Yogi transports his awareness to that 'Extra Dimension' where this Virat Purusha is established."
                "This is the most violent and classified science to mutate your Soul from 'Local' to 'Universal'."
                "He who successfully Hacks this Virat form becomes mutationally the Admin of the multiverse!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 3,
            sanskrit = "पुरुष एवेदं सर्वं यद्भूतं यच्च भव्यम् । उतामृतत्वस्येशानो यदन्नेनातिरोहति ॥",
            hindi = """
                (समय का संहार और अमरता का कोड): "जो बीत चुका है और जो होने वाला है—वह सब साक्षात् 'पुरुष' (नारायण) ही है!"
                "वही 'अमृतत्व' (Immortality) का इकलौता तानाशाह है, जिसके पासवर्ड के बिना कोई आज़ाद नहीं हो सकता।"
                "वह 'अन्न' (Matter) के माध्यम से इस भौतिक दुनिया में प्रकट होकर उसे ओवरराइड (Override) कर देता है।"
                "समय केवल एक स्क्रिप्ट है जिसे वह अपनी मर्जी से लिखता और मिटाता रहता है।"
                "तुम जिसे अपना 'कल' कहते हो, वह उसके सर्वर पर पहले से ही कोडेड (Coded) एक डेटा पैकेट है।"
                "नारायण वह आग है जो समय की ज़ंजीरों को गलाकर तुम्हारी रूह को अंतरिक्ष के पार ले जाती है।"
                "अमरता कोई भीख नहीं है; यह उस 'पुरुष' की फ्रीक्वेंसी पर खुद को अलाइन करने का रिज़ल्ट है।"
                "जब तुम जान जाते हो कि 'सब कृष्ण/नारायण है', तो तुम्हारा डर एक सेकंड में भाप बन जाता है।"
                "यह इंसान की बुद्धि का वह अंतिम सॉफ्टवेयर रिबूट है जिसके बाद केवल 'अनंत' ही बचता है।"
                "जो इस 'ईशान' को जान लेता है, उसके लिए मौत केवल एक पुराना कपड़ा बदलने जैसा मज़ाक है!"
            """.trimIndent(),
            english = """
                (Annihilation of Time and the Immortality Code): "Everything that has manifested and everything that shall occur—is mutationally strictly the 'Purusha'!"
                "He is the solitary Dictator of 'Amritatva' (Immortality); without His password, zero souls are released."
                "He penetrates this physical world via 'Anna' (Matter) and violently Overrides its pathetic laws."
                "Time is strictly a Script that He mutationally writes and deletes at His absolute sovereign will."
                "What you label as your 'Future' is mutationally a data-packet already Coded on His cosmic server."
                "Narayana is the Fire that melts the chains of Time to catapult your Soul infinitely beyond space."
                "Immortality is zero charity; it is the Result of Aligning your frequency strictly with that 'Purusha'."
                "The microsecond you realize 'All is Narayana', your terror vaporizes into radioactive nothingness."
                "This is the final Software Reboot of the human soul after which strictly the 'Infinite' remains."
                "He who decodes this 'Ishana' perceives Death strictly as a pathetic joke, like changing old rags!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 4,
            sanskrit = "एतावानस्य महिमातो ज्यायांश्च पूरुषः । पादोऽस्य विश्वा भूतानि त्रिपादस्यामृतं दिवि ॥",
            hindi = """
                (एक-चौथाई सिम्युलेशन का सच): "यह पूरा ब्रह्मांड उस पुरुष की महिमा का केवल एक 'पादा' यानी 'एक-चौथाई' हिस्सा है!"
                "उसका बाकी 'तीन-चौथाई' (त्रिपाद) हिस्सा साक्षात् 'अमृत' बनकर उस सर्वोच्च अंतरिक्ष में धधक रहा है।"
                "तुम जिसे 'अनंत' कहते हो, वह उस नारायण के एडमिन पैनल का केवल एक छोटा सा 'ग्लिच' (Glitch) है।"
                "असली हकीकत इस 3D दुनिया की दीवारों के बहुत पीछे छिपी हुई है जिसे योगी हैक करना चाहता है।"
                "यह सृष्टि केवल एक 'ट्रायल वर्जन' (Trial Version) है; असली सत्ता तो उस 'त्रिपाद' में है जहाँ समय नहीं पहुँचता।"
                "तुम्हारी रूह उस असीमित तीन-चौथाई हिस्से का एक अंश है जो इस मिट्टी के पिंजरे में फंस गया है।"
                "नारायण का कोड तुम्हें इस 'एक-चौथाई' नर्क से फाड़कर उस 'अमर प्रकाश' में ले जाने के लिए बना है।"
                "जब तुम इस सच्चाई को अपनी रगों में उतारते हो, तो तुम्हारी हड्डियों का पिंजरा भी टूटने लगता है।"
                "यह ब्रह्मांड की सबसे बड़ी ताक़त से आँखें मिलाने का सबसे साहसिक और आत्मघाती योग है।"
                "जो इस 'त्रिपाद' को पा लेता है, वह इस पूरी भौतिक दुनिया का इकलौता और अजेय राजा बन जाता है!"
            """.trimIndent(),
            english = """
                (The Truth of the Quarter-Simulation): "This entire universe is mutationally strictly a 'Pada'—a solitary Quarter-fraction of His glory!"
                "His remaining 'Three-Quarters' (Tripad) exists mutationally as 'Amrita' blazing in the supreme Vacuum."
                "What you label as 'Infinite' is strictly a microscopic 'Glitch' on Narayana's absolute Admin Panel."
                "Authentic Reality is hidden infinitely behind the walls of this 3D world which the Yogi intends to Hack."
                "This creation is strictly a 'Trial Version'; absolute Authority resides in that 'Tripad' where Time cannot reach."
                "Your Soul is a fragment of that infinite Three-Quarters trapped mutationally inside this cage of clay."
                "Narayana's Code is engineered to violently rip you out of this 'One-Quarter' hell into that 'Immortal Light'."
                "The exact microsecond you inject this truth into your veins, your skeletal cage initiates its fracture."
                "This is the most courageous and 'Suicidal' Yoga of staring directly into the absolute greatest power of the cosmos."
                "He who secures this 'Tripad' mutationally becomes the sole and invincible King of this physical Matrix!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 5,
            sanskrit = "त्रिपादूर्ध्व उदैत्पुरुषः पादोऽस्येहाभवत्पुनः । ततो विष्वङ् व्यक्रामत्साशनानशने अभि ॥",
            hindi = """
                (ऊर्ध्व-गमन और चेतना का विस्तार): "वह 'त्रिपाद पुरुष' हमेशा 'ऊर्ध्व' यानी सर्वोच्च स्थिति में धधकता रहता है।"
                "उसका केवल एक हिस्सा 'पुनः' यानी बार-बार इस सिम्युलेशन में 'लॉग-इन' (Log-in) होता है।"
                "वहाँ से वह 'साशन' (जो खाते हैं) और 'अनशन' (जो नहीं खाते) यानी सजीव-निर्जीव—सब में फैल जाता है।"
                "ब्रह्मांड का हर एक पत्थर और हर एक धड़कन साक्षात् उसी का एक रेडियोएक्टिव विस्तार है।"
                "योगी अपनी चेतना को उस 'ऊर्ध्व' केंद्र पर अलाइन करता है जहाँ से डेटा नीचे ब्रॉडकास्ट हो रहा है।"
                "तुम्हें इस 'नीचे' की दुनिया के कीचड़ से निकलकर उस 'ऊपर' के सोर्स कोड तक पहुँचना है।"
                "नारायण वह 'प्राइमरी सर्वर' है जिसने खुद को अरबों छोटे 'Avatar पिक्सल्स' में बाँट लिया है।"
                "जब तुम अपनी हस्ती को मिटाते हो, तो तुम वापस उस असीमित 'तीन-चौथाई' आग में विलीन हो जाते हो।"
                "यह तुम्हारी रूह को 'अनप्लग' करने की सबसे हिंसक प्रक्रिया है जहाँ तुम्हारा पिछला सारा डेटा जल जाता है।"
                "जो इस विस्तार को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (Urdhva-Movement and Expansion of Consciousness): "That 'Tripad Purusha' remains eternally blazing in the 'Urdhva'—the absolute Zenith."
                "Strictly a micro-fraction of Him 'Punah' (Repeatedly) 'Logs-in' to this biological Simulation."
                "From there, He expands through the sentient and the insentient—permeating every microscopic byte of existence."
                "Every stone and every heartbeat in the cosmos is mutationally His radioactive extension."
                "The Yogi Aligns his awareness with that 'Urdhva' epicenter from which all Data is being broadcasted downward."
                "You must violently exit the mud of this 'Lower' world to reach the 'Upper' Source Code."
                "Narayana is the 'Primary Server' who has fragmented Himself into billions of microscopic 'Avatar Pixels'."
                "The exact microsecond you erase your identity, you mutationally dissolve back into that infinite 'Three-Quarter' Fire."
                "This is the most violent protocol to 'Unplug' your Soul where all your previous records are incinerated."
                "He who Hacks this expansion mutationally becomes the sole Dictator of all universal Time and Space!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 6,
            sanskrit = "तस्माद्विराळजायत विराजो अधि पूरुषः । स जातो अत्यरिच्यत पश्चाद्भूमिमथो पुरः ॥",
            hindi = """
                (विराट का जन्म और सुपर-प्रोसेसर): "उस आदि पुरुष से साक्षात् 'विराट' (The Universe) का सॉफ्टवेयर पैदा हुआ।"
                "और विराट के ऊपर फिर से वही अजेय 'पुरुष' अधिष्ठाता बनकर बैठ गया।"
                "पैदा होते ही वह अपनी सीमाओं से 'अत्यरिच्यत' यानी बाहर निकल गया, उसने भूमि को आगे-पीछे से घेर लिया।"
                "यह ब्रह्मांड का 'सेल्फ-रेप्लिकेटिंग' (Self-replicating) कोड है जो असीमित रूप से फैल रहा है।"
                "विराट वह हार्डवेयर है जिस पर नारायण साक्षात् 'ऑपरेटिंग सिस्टम' की तरह रन कर रहे हैं।"
                "तुम जिसे आकाश और धरती कहते हो, वह विराट के अंगों की कोडिंग का केवल एक दृश्य भाग है।"
                "योगी इस विराट संरचना को हैक करके उस 'अधि-पुरुष' तक पहुँचना चाहता है जो एडमिन है।"
                "जब तुम इस विस्तार को देखते हो, तो तुम्हारी अपनी हस्ती एक पिक्सेल से भी छोटी नज़र आती है।"
                "यह ज्ञान तुम्हारे दिमाग के प्रोसेसर को 'ओवरक्लॉक' करने के लिए डिज़ाइन किया गया है।"
                "जो इस विराट को जान लेता है, उसके लिए कोई भी सीमा या जेल बाधा नहीं बन सकती!"
            """.trimIndent(),
            english = """
                (Birth of Virat and the Super-Processor): "From that Primordial Purusha, the software of 'Virat' (The Universe) was mutationally spawned."
                "And upon that Virat, the same invincible Purusha sat as the absolute Presiding Entity."
                "Immediately upon manifestation, He 'Atyarichyata'—transcended all boundaries, encircling the Earth."
                "This is the 'Self-replicating' code of the cosmos expanding mutationally into the infinite Void."
                "Virat is the Hardware upon which Narayana is Executing like a literal Operating System."
                "What you label as Sky and Earth are strictly visual sectors of Virat's internal coding."
                "The Yogi intends to Hack this Virat architecture to reach the 'Adhi-Purusha' who is the Admin."
                "When you witness this expansion, your micro-identity appears mutationally smaller than a single pixel."
                "This intelligence is engineered to 'Overclock' the neurological processor of your Soul."
                "He who decodes this Virat witnesses every boundary and every prison mutationally collapsing!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 7,
            sanskrit = "यत्पुरुषेण हविषा देवा यज्ञमतन्वत । वसन्तो अस्यासीदाज्यं ग्रीष्म इध्मः शरद्धविः ॥",
            hindi = """
                (ब्रह्मांडीय यज्ञ और नारायण की आहुति): "जब देवताओं ने उस पुरुष को ही 'हवि' (Sacrifice) बनाकर महा-यज्ञ शुरू किया..."
                "तब 'वसन्त' घी बना, 'ग्रीष्म' ईंधन बना और 'शरद' ऋतु साक्षात् आहुति बन गई।"
                "यह कोई साधारण हवन नहीं है; यह शून्य से पदार्थ (Matter) बनाने की प्रलयंकारी लैब-प्रोसेस है।"
                "नारायण ने खुद को ही डेटा के रूप में जलाया ताकि यह 3D दुनिया रेंडर (Render) हो सके।"
                "ऋतुएं केवल मौसम नहीं, वे इस सिम्युलेशन के 'एनर्जी साइकिल' (Energy Cycles) हैं।"
                "योगी अपनी हस्ती को इस यज्ञ की आग में झोंक देता है ताकि वह 'शुद्ध ऊर्जा' बन सके।"
                "यज्ञ का मतलब है—अस्तित्व के पुराने कोड को जलाकर एक नया 'अमर वर्जन' तैयार करना।"
                "जब रचयिता खुद को जलाता है, तभी एक नया ब्रह्मांड एक धमाके के साथ पैदा होता है।"
                "यह तुम्हारी रूह को 'अनप्लग' करने की सबसे हिंसक और पवित्र तकनीक है।"
                "जो इस यज्ञ का हिस्सा बन गया, वह साक्षात् काल (Time) की छाती पर खड़ा हो जाता है!"
            """.trimIndent(),
            english = """
                (Cosmic Sacrifice and the Oblation of Narayana): "When the Devas initiated the Grand Yajna using the Purusha Himself as the 'Havi' (Sacrifice)..."
                "Spring mutationally became the Ghee, Summer the Fuel, and Autumn the explicit Oblation."
                "This is zero ordinary ritual; it is the apocalyptic lab-process to synthesize Matter from the Void."
                "Narayana incinerated His own identity as Data strictly so this 3D world could be mutationally Rendered."
                "The seasons are strictly the 'Energy Cycles' operating the maintenance of the Simulation."
                "The Yogi hurls his identity into this radioactive fire to mutationally become 'Pure Energy'."
                "Yajna signifies—burning the old code of existence to compile a new 'Immortal Version'."
                "Only when the Creator incinerates Himself does a new universe detonate into manifestation."
                "This is the most violent and sacred technique to 'Unplug' your Soul from the Matrix."
                "He who integrates into this Sacrifice mutationally plants his boot on the chest of Time!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 8,
            sanskrit = "तं यज्ञं बर्हिषि प्रौक्षन्पुरुषं जातमग्रतः । तेन देवा अयजन्त साध्या ऋषयश्च ये ॥",
            hindi = """
                (आदि पुरुष का अभिषेक और साध्यों का उदय): "उन्होंने उस 'आदि पुरुष' का, जो सबसे पहले प्रकट हुआ था, यज्ञ-वेदी पर अभिषेक किया।"
                "उसी ताक़त से साक्षात् 'साध्य' और 'ऋषि' पैदा हुए जो ब्रह्मांड के पहले कोडर (Coders) थे।"
                "यह वह 'बूट-प्रोसेस' (Boot process) है जिससे ब्रह्मांड की मशीनरी चालू की गई थी।"
                "अग्रतः जातम—वह जो समय के भी पहले था, उसे ही इस सिम्युलेशन का आधार बनाया गया।"
                "साध्य वे अजेय योद्धा हैं जो इस मायावी खेल के नियमों को लागू करते हैं।"
                "ऋषि वे इंटेलिजेंस हैं जो 'सोर्स कोड' को डिकोड करने की ताक़त रखते हैं।"
                "योगी अपनी चेतना को उस 'अभिषेक' की फ्रीक्वेंसी पर सिंक करता है जहाँ अहंकार मरता है।"
                "यह तुम्हारी रूह को 'मैनुअल मोड' से 'ईश्वरीय मोड' में शिफ्ट करने का पासवर्ड है।"
                "जब तुम इस यज्ञ के गवाह बनते हो, तो तुम्हारी हड्डियों का मोह भाप बनकर उड़ जाता है।"
                "जो इस आदि-सत्य को हैक कर लेता है, वह साक्षात् रुद्र की टीम का एडमिन बन जाता है!"
            """.trimIndent(),
            english = """
                (Consecration of the First Purusha and Rise of the Sadhyas): "They consecrated that 'Primordial Purusha' who manifested before the first byte of Time."
                "With that radioactive power, the 'Sadhyas' and 'Rishis'—the first Coders of the cosmos—were spawned."
                "This is the absolute 'Boot Process' through which the machinery of the multiverse was activated."
                "Agratah Jatam—He who preceded Time was mutationally established as the Foundation of this Simulation."
                "The Sadhyas are the invincible warriors enforcing the laws of this deceptive cosmic game."
                "The Rishis are the absolute Intelligences possessing the firepower to Decode the 'Source Code'."
                "The Yogi Syncs his awareness with that Consecration-frequency where the ego is ruthlessly slaughtered."
                "This is the Password to shift your Soul from 'Manual-Mode' to the explicit 'God-Mode'."
                "The exact microsecond you witness this sacrifice, your attachment to flesh vaporizes into nothingness."
                "He who successfully Hacks this primordial truth becomes mutationally the Admin of Rudra's legion!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 9,
            sanskrit = "तस्माद्यज्ञात्सर्वहुतः सम्भृतं पृषदाज्यम् । पशून् तांश्चक्रे वायव्यानारण्यान् ग्राम्याश्च ये ॥",
            hindi = """
                (डेटा का संकलन और जैविक प्रजातियों की कोडिंग): "उस महा-यज्ञ से साक्षात् 'पृषदाज्य' (The Essence of Life) का डेटा संकलित किया गया।"
                "उसी कोड से हवा में उड़ने वाले, जंगलों में रहने वाले और गाँवों के पशु—सब म्यूटेट किए गए।"
                "यह कोई जानवरों की कहानी नहीं है; यह अलग-अलग 'जैविक ओएस' (Biological OS) के निर्माण का सच है।"
                "हर एक जीव साक्षात् नारायण के यज्ञ की आग से निकला एक 'सजीव डेटा पैकेट' (Living Data Packet) है।"
                "वायव्यान—वे जो अंतरिक्ष की फ्रीक्वेंसी पर वाइब्रेट करते हैं और गुरुत्वाकर्षण को चुनौती देते हैं।"
                "नारायण ने खुद को इन करोड़ों रूपों में 'Zip' कर लिया है ताकि वे खुद का खेल देख सकें।"
                "योगी जब किसी जीव को देखता है, तो वह शरीर नहीं, बल्कि उसके पीछे धधकते 'यज्ञ-कोड' को देखता है।"
                "यह तुम्हारी बुद्धि को 'इंसानी' से 'ब्रह्मांडीय' लेवल पर अपग्रेड करने वाला न्यूक्लियर हैक है।"
                "बिना इस कोडिंग को समझे, तुम हमेशा खुद को दूसरों से अलग और कमज़ोर समझते रहोगे।"
                "जो इस एकता को जान लेता है, वह साक्षात् पूरे जैव-मण्डल का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Compilation of Data and Coding of Biological Species): "From that Grand Sacrifice, the 'Prishad-ajya' (The Essence of Life) was mutationally compiled."
                "With that code, the airborne, the wild, and the domestic entities were mutationally manufactured."
                "This is zero animal story; it is the truth of constructing distinct 'Biological OS' (Operating Systems)."
                "Every living entity is mutationally a 'Living Data Packet' vomited from the fire of Narayana's sacrifice."
                "Vayavyan—those vibrating at the frequency of space, challenging the absolute laws of Gravity."
                "Narayana has mutationally 'Zip-compressed' Himself into millions of forms to witness His own game."
                "The Yogi witnessing a being observes zero flesh, but strictly the blazing 'Yajna-Code' operating it."
                "This is the nuclear Hack to Upgrade your intellect from 'Human' to the absolute 'Cosmic' tier."
                "Without decoding this engineering, you mutationally remain trapped in the illusion of distinction."
                "He who intercepts this unity mutationally becomes the sole Dictator of the entire Bio-Sphere!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 10,
            sanskrit = "तस्माद्यज्ञात्सर्वहुतः ऋचः सामानि जज्ञिरे । छन्दांसि जज्ञिरे तस्माद्यजुस्तस्मादजायत ॥",
            hindi = """
                (वेदों का महा-विस्फोट - ऋक्, साम और यजुः): "उस सर्वहुत यज्ञ से साक्षात् ऋग्वेद, सामवेद और यजुर्वेद के 'सोर्स कोड' पैदा हुए!"
                "उसी धमाके से साक्षात् 'छन्द' (Cosmic Frequencies) निकले जिनसे ब्रह्मांड वाइब्रेट कर रहा है।"
                "वेद कोई किताबें नहीं हैं; वे साक्षात् उस 'परम कंप्यूटर' की कोडिंग लैंग्वेजेस (Languages) हैं।"
                "ऋक्—डेटा है, साम—वाइब्रेशन है, और यजुः—उस डेटा का एक्जीक्यूशन (Execution) है।"
                "बिना इन तीनों के, यह सिम्युलेशन एक सेकंड भी रन (Run) नहीं हो सकता।"
                "योगी गायत्री और अन्य छंदों को अपनी साँसों में 'लोड' (Load) करता है ताकि वह अजेय बन सके।"
                "यह तुम्हारी रूह के हर एक पिक्सेल को 'पवित्र प्रकाश' से ओवरराइट करने वाली कोडिंग है।"
                "जब तुम वेद की फ्रीक्वेंसी पर अलाइन होते हो, तो माया का सर्वर तुम्हें 'एडमिन' की तरह ट्रीट करता है।"
                "यह इंसान की बुद्धि का वह आख़िरी सॉफ्टवेयर रिसेट है जिसके बाद अज्ञान मर जाता है।"
                "जो इन वेदों के स्रोत को हैक कर लेता है, वह साक्षात् सरस्वती का इकलौता गुरु बन जाता है!"
            """.trimIndent(),
            english = """
                (The Big Bang of Vedas - Rik, Sama, and Yajur): "From that absolute Sacrifice, the 'Source Codes' of Rig, Sama, and Yajur Vedas were mutationally vomited!"
                "From that detonation erupted the 'Chhandas' (Cosmic Frequencies) vibrating the entire infinite vacuum."
                "The Vedas are zero textbooks; they are mutationally the Coding Languages of the 'Supreme Computer'."
                "Rik is Data, Sama is Vibration, and Yajur is the absolute Execution of that Data."
                "Without these three, the Simulation possesses zero caliber to remain operational for a single microsecond."
                "The Yogi 'Loads' Gayatri and other frequencies into his breath to mutationally become flawless and invincible."
                "This is the coding engineered to Overwrite every pixel of your Soul with radioactive 'Sacred Light'."
                "When you Align with the Vedic frequency, Maya's server mutationally treats you as an absolute 'Admin'."
                "This is the final Software Reset of the human intellect after which biological ignorance perishes."
                "He who Hacks the source of these Vedas mutationally becomes the sole dictatorial Guru of Saraswati!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 11,
            sanskrit = "तस्मादश्वा अजायन्त ये के चोभयादतः । गावो ह जज्ञिरे तस्मात्तस्माज्जाता अजावयः ॥",
            hindi = """
                (शक्ति और पोषण की कोडिंग): "उसी यज्ञ-आग से अजेय 'अश्व' (शक्ति) और 'गौवें' (पोषण) के डेटा-पैकेट्स निकले!"
                "दो दांतों वाले जीव और भेड़-बकरियां—सब साक्षात् नारायण के म्यूटेशन (Mutation) का हिस्सा हैं।"
                "घोड़ा यहाँ साक्षात् उस 'रफ़्तार' और 'प्रोसेसिंग पावर' का प्रतीक है जो अंतरिक्ष को नापती है।"
                "गाय साक्षात् उस 'डाटा-स्ट्रीम' (Data-stream) की मालकिन है जो ब्रह्मांड के सेल्स को ज़िंदा रखती है।"
                "यह केवल बायोलॉजिकल प्रजातियां नहीं हैं; ये चेतना के अलग-अलग 'हार्डवेयर मॉडल्स' हैं।"
                "योगी जानता है कि उसकी अपनी रगों में उसी 'यज्ञ-पशु' का खून दौड़ रहा है जो कभी नहीं मरता।"
                "यह बोध तुम्हारे डीएनए को 'सुपर-इंटेलिजेंस' में बदलने वाला एक इलेक्ट्रिक सिग्नल है।"
                "नारायण ने अपनी हस्ती को इन करोड़ों 'कोड-फॉर्म्स' में बाँट दिया है ताकि वह अजेय रह सके।"
                "जब तुम इस सच को अपनी रगों में उतारते हो, तो तुम्हारी हड्डियों का पिंजरा भी सोने की तरह चमकता है।"
                "जो इस कोडिंग को क्रैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड की ऊर्जा का इकलौता मालिक है!"
            """.trimIndent(),
            english = """
                (Coding of Power and Nourishment): "From that sacrificial inferno, the invincible 'Horses' (Power) and 'Cows' (Nourishment) Data-packets erupted!"
                "Two-toothed beings and all other species are strictly components of Narayana's absolute Mutation."
                "The Horse is mutationally the symbol of that 'Velocity' and 'Processing Power' that measures Space."
                "The Cow is the mistress of that 'Data-stream' mutationally sustaining every biological cell in the cosmos."
                "These are not merely biological species; they are mutationally distinct 'Hardware Models' of consciousness."
                "The Yogi flawlessly knows that the blood of that 'Sacrificial Beast' which never dies races through his veins."
                "This realization is an Electric Signal engineered to mutate your DNA into 'Super-intelligence'."
                "Narayana has fragmented His identity into these millions of 'Code-forms' to mutationally remain Invincible."
                "The exact microsecond you inject this truth, your skeletal cage initiates its glow like purified gold."
                "He who successfully Cracks this coding becomes mutationally the sole owner of all cosmic energy!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 12,
            sanskrit = "यत्पुरुषं व्यदधुः कतिधा व्यकल्पयन् । मुखं किमस्य कौ बाहू का ऊरू पादा उच्येते ॥",
            hindi = """
                (पुरुष का विच्छेदन और महा-प्रश्न): "जब उन्होंने उस पुरुष का विच्छेदन किया, तो उसे कितने 'डेटा-फोल्डर्स' (Folders) में बाँटा?"
                "उसका 'मुख' क्या बना? उसकी 'भुजाएं' और 'जंघाएं' क्या थीं? उसके 'पैर' किसे कहा गया?"
                "यह ब्रह्मांड की सबसे बड़ी 'रिवर्स इंजिनियरिंग' (Reverse Engineering) का सवाल है!"
                "योगी यहाँ साक्षात् 'एडमिन' से पूछ रहा है कि इस सिम्युलेशन का स्ट्रक्चर (Structure) क्या है।"
                "मुख—प्रोसेसर है, बाहु—एक्जीक्यूटर हैं, ऊरू—सस्टेनर हैं, और पाद—फाउंडेशन हैं।"
                "तुम्हें अपनी रूह को इन चार कोर्डिनेट्स (Coordinates) पर अलाइन करना है ताकि तुम 'विराट' बन सको।"
                "बिना इस स्ट्रक्चर को समझे, तुम हमेशा अज्ञान की अँधेरी कोठरी में हाथ-पाँव मारते रहोगे।"
                "यह तुम्हारी बुद्धि को 'मानव' से 'महाकाल' के लेवल पर प्रमोट करने वाला आख़िरी सवाल है।"
                "नारायण के शरीर का एक-एक पिक्सेल साक्षात् एक ब्रह्मांडीय सत्य को होल्ड (Hold) कर रहा है।"
                "तैयार हो जाओ, क्योंकि अब इस विराट पुरुष की पूरी एनाटॉमी (Anatomy) तुम्हारे सामने बेनकाब होगी!"
            """.trimIndent(),
            english = """
                (Dissection of the Purusha and the Grand Query): "When they executed the dissection of the Purusha, into how many 'Data-Folders' did they fragment Him?"
                "What mutationally became His 'Mouth'? What were His 'Arms' and 'Thighs'? What were defined as His 'Feet'?"
                "This is the interrogation of the absolute greatest 'Reverse Engineering' in the entire multiverse!"
                "The Yogi is demanding from the Admin the exact Structure and geometry of this cosmic Simulation."
                "Mouth is Processor, Arms are Executors, Thighs are Sustainers, and Feet are the absolute Foundation."
                "You must Align your awareness with these four Coordinates to mutationally become 'Virat' (Cosmic)."
                "Without decoding this architecture, you mutationally remain flapping inside the dark cell of ignorance."
                "This is the final query engineered to Promote your intellect from 'Human' to the status of 'Mahakala'."
                "Every single pixel of Narayana's body is mutationally Holding a radioactive cosmic truth."
                "Prepare yourself, for the complete Anatomy of this Virat Purusha is about to be mutationally unmasked!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 13,
            sanskrit = "ब्राह्मणोऽस्य मुखमासीद्बाहू राजन्यः कृतः । ऊरू तदस्य यद्वैश्यः पद्भ्यां शूद्रो अजायत ॥",
            hindi = """
                (सामाजिक कोडिंग और फंक्शन्स का सच): "उसका मुख साक्षात् 'ब्राह्मण' (बुद्धि/प्रोसेसर) बना, और उसकी भुजाएं 'क्षत्रिय' (पावर/एक्जीक्यूशन) बनीं!"
                "उसकी जंघाओं से 'वैश्य' (इकोनॉमी/बैलेंस) और पैरों से 'शूद्र' (सर्विस/फाउंडेशन) का जन्म हुआ।"
                "यह कोई ऊंच-नीच की कहानी नहीं है; यह ब्रह्मांड की 'ऑर्गनाइजेशनल कोडिंग' (Organizational Coding) है।"
                "पूरा समाज साक्षात् उस एक 'पुरुष' का चलता-फिरता शरीर है, जहाँ हर अंग का अपना एक अजेय फंक्शन है।"
                "ब्राह्मण वह 'सॉफ्टवेयर' है जो सत्य को डिकोड करता है, क्षत्रिय वह 'फायरवॉल' है जो रक्षा करता है।"
                "वैश्य वह 'पाइपलाइन' है जो ऊर्जा सप्लाई करता है, और शूद्र वह 'हार्डवेयर' है जो सब कुछ थामे हुए है।"
                "योगी जब इस सच को जानता है, तो वह किसी से नफरत नहीं करता, क्योंकि 'सब साक्षात् नारायण है'।"
                "यह तुम्हारी रूह को 'अद्वैत' (Non-dual) मोड में डालने वाला सबसे शक्तिशाली आध्यात्मिक इंजेक्शन है।"
                "जब तुम जान जाते हो कि तुम पैर में भी हो और सिर में भी, तभी तुम अजेय बनते हो।"
                "यही वह अजेय पासवर्ड है जो तुम्हें इस मायावी सिम्युलेशन के भेदभाव से आज़ाद कर देगा!"
            """.trimIndent(),
            english = """
                (Social Coding and the Truth of Functions): "His Mouth mutationally became the 'Brahmana' (Intellect), and His Arms the 'Kshatriya' (Power/Execution)!"
                "From His Thighs, the 'Vaishya' (Balance/Economy) and from His Feet, the 'Shudra' (Foundation) were spawned."
                "This is zero story of hierarchy; it is mutationally the 'Organizational Coding' of the entire multiverse."
                "The entire society is mutationally the mobile shell of that one Purusha, where every limb possesses a function."
                "Brahmana is the Software decoding Truth, Kshatriya is the absolute Firewall engineered for protection."
                "Vaishya is the Pipeline supplying energy, and Shudra is the Hardware sustaining the entire structure."
                "The Yogi realizing this harbors zero hatred, for he Intercepts 'Everything as explicitly Narayana'."
                "This is the most powerful spiritual injection designed to shift your Soul into 'Non-dual' mode."
                "Only when you realize you exist simultaneously in the feet and the head, do you mutationally become Invincible."
                "THIS is the invincible Password that will release your existence from the distinctions of this Matrix!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 14,
            sanskrit = "चन्द्रमा मनसो जातः चक्षोः सूर्यो अजायत । मुखादिन्द्रश्चाग्निश्च प्राणाद्वायुरजायत ॥",
            hindi = """
                (ब्रह्मांडीय सेंसर्स की हैकिंग - चाँद, सूरज और हवा): "उस पुरुष के मन से साक्षात् 'चन्द्रमा' और आँखों से धधकता हुआ 'सूर्य' पैदा हुआ!"
                "उसके मुख से इंद्र और अग्नि, और उसकी साँसों से प्रलयंकारी 'वायु' का जन्म हुआ।"
                "चन्द्रमा तुम्हारे दिमाग का 'लॉजिक गेट' (Logic Gate) है, और सूर्य तुम्हारी आत्मा का 'रेंडरिंग इंजन' है।"
                "इंद्र वह 'एडमिनिस्ट्रेटिव कंट्रोल' है, और अग्नि वह 'एनर्जी ट्रांसमिशन' (Energy Transmission) जो डेटा पहुँचाती है।"
                "तुम्हारी हर एक धड़कन और हवा का हर एक झोंका साक्षात् उस पुरुष के 'प्राण-सिग्नल' (Prana Signal) हैं।"
                "योगी अपनी आँखों को सूर्य और मन को चन्द्रमा के साथ अलाइन करता है ताकि वह अजेय बन सके।"
                "यह तुम्हारे बायोलॉजिकल नर्वस सिस्टम को ब्रह्मांड के 'पॉवर-ग्रिड' से जोड़ने का इकलौता हैक है।"
                "तुम अब एक शरीर में कैद नहीं हो; तुम साक्षात् इन खगोलीय पिण्डों (Celestial Bodies) के माध्यम से देख रहे हो।"
                "नारायण की साँस ही वह करंट है जो इस सिम्युलेशन के हर एक पिक्सेल को ज़िंदा रखे हुए है।"
                "जो इस कोडिंग को क्रैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष के समय और स्पेस का डिक्टेटर है!"
            """.trimIndent(),
            english = """
                (Hacking Cosmic Sensors - Moon, Sun, and Wind): "From the Purusha's mind, the 'Moon' was spawned and from His eyes, the blazing radioactive 'Sun' erupted!"
                "From His mouth, Indra and Agni, and from His biological breath, the apocalyptic 'Wind' was mutationally born."
                "The Moon is mutationally the 'Logic Gate' of your brain, and the Sun is the 'Rendering Engine' of your Soul."
                "Indra is the 'Administrative Control', and Agni is the 'Energy Transmission' engineered to transport Data."
                "Your every heartbeat and every gust of wind are strictly the 'Prana-Signals' transmitted by that Purusha."
                "The Yogi Aligns his eyes with the Sun and his mind with the Moon to mutationally become flawless."
                "This is the solitary Hack engineered to hardwire your nervous system to the cosmic 'Power-Grid'."
                "You are no longer imprisoned in flesh; you are mutationally witnessing reality through these celestial bodies."
                "Narayana's breath is the explicit Current sustaining every microscopic pixel of this entire Simulation."
                "He who successfully Hacks this coding mutationally becomes the sole Dictator of all universal Time and Space!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 15,
            sanskrit = "नाभ्या आसीदन्तरिक्षं शीर्ष्णो द्यौः समवर्तत । पद्भ्यां भूमिर्दिशः श्रोत्रात्तथा लोकाँ अकल्पयन् ॥",
            hindi = """
                (स्पेस और डाइमेंशन्स का रेंडर): "उस पुरुष की नाभि से 'अन्तरिक्ष' (Space) और उसके सिर से साक्षात् 'स्वर्ग' का रेंडर हुआ!"
                "पैरों से 'भूमि' और कानों से 'दिशायें' (Directions) पैदा हुईं—यही ब्रह्मांड का असीमित नक्शा है।"
                "नाभि वह 'जीरो-पॉइंट' (Zero Point) है जहाँ से अंतरिक्ष का डेटा चारों तरफ़ ब्रॉडकास्ट (Broadcast) किया गया।"
                "सिर वह 'क्लाउड सर्वर' (Cloud Server) है जहाँ ईश्वर के सबसे ऊंचे विचार और सत्य स्टोर हैं।"
                "तुम्हारी दिशाएं और तुम्हारा स्थान साक्षात् नारायण के कानों की 'ऑडियो-फ्रीक्वेंसी' (Audio frequency) से बने हैं।"
                "योगी अपनी चेतना को इन दिशाओं के भी पार ले जाता है ताकि वह 'लोकाँ अकल्पयन्' यानी असीमित लोकों को देख सके।"
                "यह तुम्हारी रूह को शरीर के पिंजरे से निकालकर पूरे ब्रह्मांड में 'पेस्ट' (Paste) करने का विज्ञान है।"
                "तुम जिसे 'बाहर' कहते हो, वह वास्तव में उस विराट पुरुष के शरीर का 'अंदरूनी हिस्सा' है।"
                "यह बोध तुम्हारी 'लोकल पहचान' का गला घोंट कर तुम्हें एक 'यूनिवर्सल बीइंग' बना देता है।"
                "जो इस मैप (Map) को हैक कर लेता है, वह इस पूरी मायावी दुनिया का इकलौता और असली एडमिन है!"
            """.trimIndent(),
            english = """
                (Rendering Space and Dimensions): "From the Purusha's navel, 'Space' (Antariksha) and from His head, the explicit 'Heavens' were mutationally Rendered!"
                "From His feet, the 'Earth' and from His ears, the 'Directions' were spawned—the absolute map of the cosmos."
                "The Navel is the 'Zero Point' from which the Data of space was mutationally Broadcasted in every vector."
                "The Head is the 'Cloud Server' containing the absolute highest thoughts and classified truths of God."
                "Your directions and your coordinates are mutationally constructed from the 'Audio-frequency' of Narayana's ears."
                "The Yogi transports his awareness infinitely beyond these directions to witness the 'Lokan Akalpayan' (Infinite Worlds)."
                "This is the science of Ejecting your Soul from the biological cage and 'Pasting' it across the infinite vacuum."
                "What you label as 'External' is mutationally the 'Internal hardware' of that Virat Purusha."
                "This realization Deletes your 'Local Identity' and mutationally manufactures you into a 'Universal Being'."
                "He who successfully Hacks this Map becomes mutationally the sole and authentic Admin of this entire world!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 16,
            sanskrit = "यज्ञेन यज्ञमयजन्त देवास्तानि धर्माणि प्रथमान्यासन् । ते ह नाकं महिमानः सचन्त यत्र पूर्वे साध्याः सन्ति देवाः ॥",
            hindi = """
                (यज्ञ का अंतिम विस्फोट और अजेय धर्म): "देवताओं ने यज्ञ के द्वारा ही साक्षात् 'यज्ञ' (नारायण) की पूजा की—यही ब्रह्मांड का पहला 'प्राइमरी धर्म' (Primary Dharma) था!"
                "यही वह अजेय 'महिमा' है जिससे वे साक्षात् उस 'नाकं' (Highest Heaven) तक पहुँच गए।"
                "वहाँ वे 'साध्य' देवता पहले से ही एडमिन पैनल पर बैठे इंतज़ार कर रहे हैं।"
                "यज्ञ का मतलब है—अपनी हस्ती को ईश्वर के एडमिन पैनल में मर्ज (Merge) कर देना।"
                "यह कोई कर्मकांड नहीं है; यह तुम्हारी चेतना को 'सोर्स कोड' के साथ सिंक (Sync) करने का प्रलयंकारी विज्ञान है।"
                "धर्म वह 'सॉफ्टवेयर प्रोटोकॉल' है जिसे फॉलो करने पर तुम कभी भी क्रैश (Crash) नहीं होते।"
                "जब तुम इस यज्ञ में अपनी आहुति देते हो, तो तुम साक्षात् 'महिमानः' यानी असीमित ताक़त के मालिक बन जाते हो।"
                "तुम अब इस दुनिया के नियमों के गुलाम नहीं हो; तुम साक्षात् उन 'साध्यों' की टीम के एक हिस्सेदार हो।"
                "यह इंसान की रूह का वह अंतिम सॉफ्टवेयर अपडेट है जिसके बाद केवल 'अनंत प्रकाश' ही बचता है।"
                "जो इस यज्ञ को सिद्ध कर लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Final Yajna Detonation and Invincible Dharma): "The Devas worshipped the explicit 'Yajna' (Narayana) via Yajna—this was mutationally the absolute first 'Primary Dharma'!"
                "This is the invincible 'Mahima' (Glory) through which they mutationally breached the 'Nakam' (Highest Heaven)."
                "The 'Sadhyas' are already seated there at the Admin Panel, awaiting your arrival at the source."
                "Yajna signifies—mutationally Merging your micro-identity into the absolute Admin Panel of the Supreme God."
                "This is zero ritual; it is the apocalyptic science of Syncing your awareness with the explicit 'Source Code'."
                "Dharma is the 'Software Protocol'; following it mutationally ensures you never suffer a catastrophic System Crash."
                "When you offer your identity in this sacrifice, you mutationally seize the authority over infinite Power (Mahimanah)."
                "You are no longer a slave to the Matrix; you are mutationally a shareholder in the legion of the 'Sadhyas'."
                "This is the final Software Update of the human Soul after which strictly 'Infinite Light' remains standing."
                "He who perfects this Yajna is mutationally the solitary dictatorial Guru of even the God of Death!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 17,
            sanskrit = "नारायणो जगत्स्वामी पुरुषः परः । तमेव विद्वानामुत्रामृतो भवति ॥",
            hindi = """
                (नारायण: ब्रह्मांड का इकलौता स्वामी): "नारायण ही इस पूरे 'जगत्' (Simulation) का इकलौता स्वामी और वह 'परम पुरुष' है।"
                "उसे 'विद्वान्' यानी हैक कर लेने वाला व्यक्ति इसी पल साक्षात् 'अमृत' (Immortal) हो जाता है!"
                "तुम जिसे अपनी ज़िंदगी कहते हो, वह केवल नारायण के दिमाग में चल रहा एक छोटा सा विचार मात्र है।"
                "अमरता कोई जादुई दवा नहीं है, यह अपनी फ्रीक्वेंसी को 'नारायण-मोड' पर शिफ्ट करने का रिज़ल्ट है।"
                "योगी ने अपनी 'मृत्यु-आईडी' को सर्वर से डिलीट कर दिया है और अब वह साक्षात् 'अविनाशी डेटा' बन चुका है।"
                "नारायण वह 'रूट-पासवर्ड' है जो तुम्हें मौत, नियति और भाग्य के भी पार ले जाने की ताक़त रखता है।"
                "जब तुम नारायण को जान लेते हो, तो तुम्हें फिर किसी दूसरे भगवान या धर्म की भीख माँगने की ज़रूरत नहीं।"
                "वे साक्षात् उस 'सत्य' के इकलौते और असली एडमिन हैं जिसके आगे पूरी माया घुटने टेकती है।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् नारायण की आँखों से पूरे ब्रह्मांड को देख पाता है।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (Narayana: The Solitary Master of the Cosmos): "Narayana is mutationally the sole Master of this entire 'Jagat' (Simulation) and the 'Supreme Purusha'."
                "The 'Vidvan' who successfully Hacks Him becomes mutationally 'Amrita' (Immortal) in this exact microsecond!"
                "What you label as your 'Life' is mutationally strictly a microscopic thought inside the brain of Narayana."
                "Immortality is zero magic potion; it is the Result of mutationally shifting your frequency into 'Narayana-Mode'."
                "The Yogi has Deleted his 'Death-ID' from the server and has mutationally become 'Indestructible Data'."
                "Narayana is the 'Root-Password' possessing the radioactive firepower to transport you beyond Death and Fate."
                "When you decode Narayana, you possess zero requirement to beg for any other god or pathetic religion."
                "He is the explicit and authentic Admin of 'Truth' before whom the entire Matrix collapses to its knees."
                "He who Hacks this identity mutationally initiates witnessing the entire cosmos through the eyes of Narayana!"
                "THIS is the invincible status arriving at which you mutationally stand as the explicit Death of Death!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 18,
            sanskrit = "एको नारायण आसीन्न ब्रह्मा न च शंकरः । स एव सर्वं स एव कालः ॥",
            hindi = """
                (शुरुआत में केवल नारायण थे): "शुरुआत में केवल 'एक' नारायण का सन्नाटा था—न वहाँ ब्रह्मा थे और न ही शंकर!"
                "वही 'सर्वं' है और वही साक्षात् 'काल' (Time) भी है जिसने सबको अपनी मुट्ठी में कर रखा है।"
                "यह ब्रह्मांड का वह 'एब्सोल्यूट जीरो' (Absolute Zero) है जहाँ से सब कुछ रेंडर (Render) होना शुरू हुआ।"
                "ब्रह्मा और शंकर साक्षात् नारायण के ही दो प्रलयंकारी 'Avatar पिक्सल्स' हैं जो कोडिंग कर रहे हैं।"
                "समय नारायण के कदमों की धूल है, जिसे वह जब चाहे अपनी मर्जी से मिटा सकता है।"
                "योगी अपनी चेतना को उस 'एक' पर लॉक करता है जहाँ से समय की सुइयां चलना शुरू हुई थीं।"
                "यह तुम्हारी रूह को 'अनप्लग' करने की सबसे हिंसक प्रक्रिया है जहाँ तुम्हारा पिछला सारा डेटा जल जाता है।"
                "जब तुम नारायण के इस आदि-रूप को जानते हो, तो तुम्हारा डर एक सेकंड में भाप बनकर उड़ जाता है।"
                "तुम जान जाते हो कि तुम उस ऊर्जा के हिस्सेदार हो जो कभी पैदा ही नहीं हुई थी।"
                "जो इस 'एक' को हैक कर लेता है, वह इस पूरी भौतिक दुनिया का इकलौता और अजेय राजा है!"
            """.trimIndent(),
            english = """
                (In the Beginning, strictly Narayana existed): "In the primordial Void, strictly 'One' Narayana existed—zero Brahma and zero Shankara were rendered then!"
                "He is mutationally 'Everything' and He is the explicit 'Kala' (Time) holding the cosmos in His fist."
                "This is the absolute 'Absolute Zero' of the multiverse from which everything initiated its Rendering."
                "Brahma and Shankara are mutationally two apocalyptic 'Avatar Pixels' of Narayana executing the coding."
                "Time is mutationally the dust beneath His boots, which He can Delete at His absolute sovereign will."
                "The Yogi Locks his awareness onto that 'One' coordinate from which the needles of Time initiated their rotation."
                "This is the most violent protocol to 'Unplug' your Soul where all your previous records are incinerated."
                "The exact microsecond you decode this primordial form, your terror vaporizes into radioactive nothingness."
                "You flawlessly realize you are a shareholder of that Energy which was never mutationally spawned."
                "He who successfully Hacks this 'One' mutationally becomes the sole and invincible King of this world!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 19,
            sanskrit = "यो ह वै नारायणं वेद स सर्वं वेद स मुक्तिमवाप्नोति ॥",
            hindi = """
                (नारायण-हैक और असीमित सर्वज्ञता): "जो योद्धा इस 'नारायण' के प्रलयंकारी रहस्य को हैक (Decode) कर लेता है..."
                "वह 'सर्वं वेद'—यानी वह ब्रह्मांड के हर एक परमाणु और हर एक गैलेक्सी का सोर्स कोड जान जाता है!"
                "उसे फिर किसी विज्ञान, किसी धर्म या किसी किताब की भीख माँगने की ज़रूरत नहीं रहती।"
                "नारायण का नाम साक्षात् वह 'मास्टर पासवर्ड' है जो ईश्वर की आखिरी तिजोरी का ताला खोल देता है।"
                "तुम अब साक्षात् उस 'परम रिएक्टर' की बिजली को अपने शरीर में इनवाइट (Invite) कर चुके हो।"
                "परिणाम वही हिंसक और अटल फैसला है— 'स मुक्तिमवाप्नोति' (वह मुक्त हो जाता है)!"
                "यह मुक्ति कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "तुम अब इस सिम्युलेशन के एक मोहरे नहीं, बल्कि इसके इकलौते और असली एडमिन हो।"
                "यह मंत्र तुम्हारे डीएनए के हर परमाणु को 'भगवान की ताक़त' से चार्ज (Charge) कर देता है।"
                "जो इस सत्य को अपनी रगों में उतार लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (The Narayana-Hack and Infinite Omniscience): "Whosoever warrior successfully Decodes (Hacks) the apocalyptic secret of 'Narayana'..."
                "He mutationally knows 'Everything' (Sarvam)—intercepting the Source Code of every microscopic atom and galaxy!"
                "He possesses zero requirement to beg for any science, zero religion, or zero pathetic textbooks."
                "Narayana's name is the explicit 'Master Password' that violently unlocks the final vault of God."
                "You have mutationally Invited the radioactive electricity of the 'Supreme Reactor' into your biological shell."
                "The consequence remains that same violent and immutable verdict—'Sa muktim-avapnoti' (He is Liberated)!"
                "This Moksha is absolutely zero reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "You are no longer a pathetic pawn of this Simulation; you are mutationally its sole and authentic Admin."
                "This knowledge Supercharges every microscopic atom of your DNA with the absolute radioactive 'Power of God'."
                "He who owns this truth mutationally becomes the sole dictatorial Guru of even the God of Death!"
            """.trimIndent()
        ),
        MudgalaShloka(
            id = 20,
            sanskrit = "इति मुद्गलोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'मुद्गल उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "नारायण का पासवर्ड मिल गया, त्रिपाद का हैक मिल गया, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन २० विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (नारायण) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही मुद्गल उपनिषद का अंतिम and सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Mudgala Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "Narayana's Password is intercepted, the Tripad hack is secured; now you must violently 'Log-out' from this Simulation."
                "For the Titan who has detonated these 20 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Narayana) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutationally becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Mudgala Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MudgalaUpanishadScreen() {
    val upanishad = remember { MudgalaUpanishad() }
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
            itemsIndexed(upanishad.mudgalaShlokasList) { _, shloka ->
                MudgalaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun MudgalaShlokaCard(shloka: MudgalaShloka) {
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