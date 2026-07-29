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

class SkandaUpanishad {

    // Data Model
    data class SkandaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val skandaShlokasList = listOf(
            SkandaShloka(
                id = 1,
                sanskrit = "अच्युतोऽस्मि महादेव तव कारुण्यलेशतः । विज्ञानघन एवास्मि शिवोऽस्मि किमतः परम् ॥ १॥",
                hindi = """
                    (महादेव की प्रलयंकारी कृपा और 'शिवोऽहम्' की गर्जना): "उपनिषद एक ऐसे खौफनाक और अजेय सत्य से शुरू होता है जो इंसानियत की धज्जियां उड़ा दे।"
                    "स्कंद (कार्तिकेय) गर्जना करते हैं: 'हे महादेव! तुम्हारी कृपा के उस एक सूक्ष्म कतरे (Micro-drop) से ही...'"
                    "'मेरा यह सड़ा हुआ इंसानी अहंकार पूरी तरह से जलकर खाक हो चुका है!'"
                    "'मैं कोई नश्वर जीव नहीं रहा; मैं साक्षात अजेय और अविनाशी 'अच्युत' (विष्णु) बन चुका हूँ!'"
                    "'मैं केवल एक हाड़-मांस का पुतला नहीं, मैं 'विज्ञानघन' (परम और शुद्ध चेतना का सघन महासागर) हूँ!'"
                    "'अहं शिवोऽस्मि— मैं ही साक्षात वह महाकाल शिव हूँ जो ब्रह्मांड को चलाता है!'"
                    "'जब मैं खुद ही भगवान बन गया, तो इससे आगे और क्या खौफनाक सच हो सकता है? (किमतः परम्)।'"
                    "यह कोई प्रार्थना नहीं है; यह एक इंसान के भीतर हुए उस ब्रह्मांडीय न्यूक्लियर विस्फोट का ऐलान है।"
                    "जहाँ इंसान और ईश्वर के बीच का पर्दा हमेशा के लिए फट जाता है।"
                    "जब आत्मा जागती है, तो वह भीख नहीं मांगती; वह सीधा भगवान के सिंहासन पर कब्ज़ा कर लेती है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Grace of Mahadeva and the Roar of 'Shivoham'): "The Upanishad detonates with a terrifying, invincible truth designed to blow humanity to absolute shreds."
                    "Skanda (Kartikeya) roars: 'O Mahadeva! By just a microscopic drop of your apocalyptic grace...'"
                    "'My rotting human ego has been completely incinerated to absolute, permanent ashes!'"
                    "'I am absolutely no mortal creature anymore; I have mutated explicitly into the invincible, indestructible 'Achyuta' (Vishnu)!'"
                    "'I am no puppet of flesh and bone; I am 'Vijnanaghana' (The solid, infinitely dense ocean of pure radioactive consciousness)!'"
                    "'Aham Shivosmi—I myself am explicitly that Mahakala Shiva who operates and annihilates the cosmos!'"
                    "'When I myself have literally mutated into God, what more terrifying absolute truth could possibly exist beyond this? (Kimatah param).'"
                    "This is absolutely no pathetic prayer; it is the declaration of a cosmic nuclear detonation directly inside a human core."
                    "Where the pathetic biological curtain between mortal and God is permanently torn to bloody shreds."
                    "When the Soul awakens, it absolutely does not beg; it violently hijacks and occupies the undisputed throne of God!"
                """.trimIndent()
            ),
            SkandaShloka(
                id = 2,
                sanskrit = "न निजं निजभावत्वात् अन्तःकरणजृम्भणात् । अन्तःकरणनाशेन को भवेत् केन संस्थितः ॥ २॥",
                hindi = """
                    (अंतःकरण की मौत और अहंकार का विनाश): "यह श्लोक इंसान के सबसे बड़े दुश्मन 'अंतःकरण' (Mind/Ego) के खात्मे का खौफनाक फॉर्मूला देता है।"
                    "जब तक तुम्हारे भीतर यह मन और विचार (अन्तःकरणजृम्भणात्) उछल रहे हैं, तुम्हारा असली 'स्वभाव' (निजं) कभी प्रकट नहीं हो सकता।"
                    "इंसान की यह 'मैं' की भावना केवल दिमाग का एक सड़ा हुआ वायरस (Virus) है।"
                    "उपनिषद सीधा और हिंसक आदेश देता है: 'अन्तःकरणनाशेन'— अपने ही मन और विचारों का क्रूरता से वध कर दो!"
                    "जब तुम ध्यान की कुल्हाड़ी से अपने ही दिमाग के टुकड़े-टुकड़े कर देते हो..."
                    "तो उपनिषद पूछता है: 'को भवेत् केन संस्थितः'— तब कौन बचेगा और वह किसमें रहेगा?"
                    "तब कोई इंसान नहीं बचेगा, कोई डर नहीं बचेगा; केवल वह असीम और सुन्न कर देने वाला 'परब्रह्म' (शून्यता) बचेगा!"
                    "बिना मन को मारे कोई भगवान नहीं बन सकता; मन का मरना ही मोक्ष की सबसे पहली शर्त है।"
                    "अपनी ही सोच का गला घोंटना ब्रह्मांड का सबसे डरावना और साहसिक काम है।"
                    "जब विचारों का शोर बंद होता है, तभी ब्रह्मांडीय सन्नाटा (God) गूँजता है!"
                """.trimIndent(),
                english = """
                    (The Assassination of the Mind and Annihilation of Ego): "This Shloka delivers the terrifying formula for the absolute extermination of the human's greatest enemy—the 'Antahkarana' (Mind/Ego)."
                    "As long as your biological mind and thoughts are violently jumping inside you (Antahkaranajrimbhanat), your authentic 'True Nature' (Nijam) can absolutely never manifest."
                    "This human feeling of 'I' is strictly a rotting biological Virus infecting the brain."
                    "The Upanishad issues a direct, violent command: 'Antahkarananashena'—Execute the brutal, ruthless slaughter of your own mind and thoughts!"
                    "When you hack your own brain to bloody pieces using the axe of meditation..."
                    "The Upanishad interrogates: 'Ko bhavet kena samsthitah'—Who exactly will survive, and where will he reside?"
                    "Absolutely no human will survive, zero fear will survive; strictly only that infinite, paralyzing 'Supreme Brahman' (Void) will remain!"
                    "Without assassinating the mind, no one can mutate into God; the death of the mind is the absolute first condition for Moksha."
                    "Strangling your own thoughts is the most terrifying and courageous act in the entire cosmos."
                    "Only when the rotting noise of thoughts is put to death does the cosmic silence (God) violently echo!"
                """.trimIndent()
            ),
            SkandaShloka(
                id = 3,
                sanskrit = "ज्ञानमुत्पद्यते पुंसामन्तःकरणनाशनात् । स शिवः स हरिर्ब्रह्मा स इन्द्रः स परः पुमान् ॥ ३॥",
                hindi = """
                    (मन की लाश पर ज्ञान का विस्फोट और देवत्व): "जब इंसान का 'मन' (अंतःकरण) बेरहमी से मार दिया जाता है, तभी उसके भीतर ब्रह्मांडीय ज्ञान (ज्ञानमुत्पद्यते) का विस्फोट होता है!"
                    "अहंकार की चिता पर ही वह परम ज्ञान जन्म लेता है जो इंसान को सीधा भगवान बना देता है।"
                    "मन के मरते ही वह योगी इंसान नहीं रहता; वह गर्जना करता है: 'स शिवः स हरिर्ब्रह्मा'!"
                    "यानी, वह खुद ही साक्षात 'शिव' बन जाता है, वह खुद ही 'विष्णु' (हरि) बन जाता है, और वह खुद ही 'ब्रह्मा' बन जाता है!"
                    "'स इन्द्रः स परः पुमान्'— वह खुद ही देवताओं का राजा 'इंद्र' बन जाता है, और वह खुद ही वह 'परम पुरुष' (Supreme Titan) बन जाता है!"
                    "यह कोई कविता नहीं है; यह इंसान की चेतना के सबसे खौफनाक अपग्रेड (Upgrade) का विज्ञान है।"
                    "जब तुम अपने दिमाग के सड़े हुए फोल्डर (Folder) को डिलीट करते हो, तो तुम्हारे भीतर पूरे ब्रह्मांड का सॉफ्टवेयर डाउनलोड (Download) हो जाता है।"
                    "तुम एक शरीर में कैद नहीं रहते, तुम इस असीम सृष्टि के इकलौते मालिक बन जाते हो।"
                    "जिसने खुद को मार दिया, उसने साक्षात त्रिमूर्ति को अपने भीतर ज़िंदा कर लिया।"
                    "यही सनातन धर्म की वह प्रलयंकारी ताक़त है जिसे कोई भी साधारण धर्म समझ नहीं सकता!"
                """.trimIndent(),
                english = """
                    (The Detonation of Knowledge on the Corpse of the Mind): "Only when the human's 'Mind' (Antahkarana) is ruthlessly slaughtered does the cosmic Knowledge (Jnanamutpadyate) violently detonate within him!"
                    "Strictly on the burning funeral pyre of the ego is that supreme wisdom born which instantly mutates a human into God."
                    "The microsecond the mind dies, the Yogi is no longer human; he roars: 'Sa Shivah Sa Harirbrahma'!"
                    "Meaning, he himself explicitly mutates into literal 'Shiva', he himself becomes 'Vishnu' (Hari), and he himself becomes 'Brahma'!"
                    "'Sa Indrah Sa Parah Puman'—He himself mutates into 'Indra' (King of Gods), and he himself becomes that 'Supreme Titan' (Parah Puman)!"
                    "This is absolutely no poetry; it is the ruthless science of the most terrifying biological Upgrade of human consciousness."
                    "When you permanently Delete the rotting folder of your brain, the operating system of the entire cosmos is violently Downloaded into you."
                    "You are absolutely no longer imprisoned in a physical shell; you become the sole, undisputed Dictator of this infinite creation."
                    "He who has brutally assassinated himself has explicitly resurrected the absolute Trinity directly inside his core."
                    "This is the apocalyptic, radioactive power of Sanatana Dharma which no pathetic ordinary religion can ever fathom!"
                """.trimIndent()
            ),
            SkandaShloka(
                id = 4,
                sanskrit = "स एव परमो हंसः स एव जगदात्मकः । देहो देवालयः प्रोक्तः स जीवः केवलः शिवः ॥ ४॥",
                hindi = """
                    (शरीर रूपी मंदिर और जीव का साक्षात शिव होना): "अब उपनिषद दुनिया के सारे मंदिरों और तीर्थों को मिट्टी में मिलाते हुए सबसे खतरनाक सच बोलता है।"
                    "वह योगी 'परम हंस' (स एव परमो हंसः) बन जाता है, और वह साक्षात इस पूरे जगत् की आत्मा (जगदात्मकः) बन जाता है।"
                    "उपनिषद चीख कर कहता है: 'देहो देवालयः प्रोक्तः'— यह जो तुम्हारा हाड़-मांस का शरीर है, यही पूरे ब्रह्मांड का सबसे बड़ा और असली 'मंदिर' है!"
                    "बाहर के मंदिर ईंट और पत्थर के बने हैं, लेकिन यह शरीर वो मंदिर है जिसे साक्षात ईश्वर ने अपने रहने के लिए बनाया है।"
                    "और इस मंदिर के भीतर जो मूर्ति है, वह क्या है? 'स जीवः केवलः शिवः'— तुम्हारे भीतर बैठा हुआ यह 'जीव' (Soul) कोई और नहीं, 100% केवल और केवल साक्षात 'शिव' ही है!"
                    "तुम कोई पापी या कमज़ोर इंसान नहीं हो; तुम साक्षात वह महाकाल हो जो अपने ही बनाए हुए मंदिर (शरीर) में छिपा बैठा है।"
                    "जो मूर्ख शिव को बाहर पहाड़ों या पत्थरों में खोज रहा है, वह ब्रह्मांड का सबसे बड़ा अंधा है।"
                    "तुम्हारा सीना ही गर्भगृह है, और तुम्हारी धड़कन ही उस शिव का डमरू है।"
                    "यह शरीर को नकारने का नहीं, बल्कि शरीर को भगवान का अभेद्य किला (Titanium Fortress) मानने का प्रलयंकारी दर्शन है।"
                    "जिस पल तुम इस सत्य को हैक (Hack) कर लेते हो, तुम्हारी इंसानियत हमेशा के लिए खत्म हो जाती है!"
                """.trimIndent(),
                english = """
                    (The Flesh as the Temple and the Mortal as Explicit Shiva): "Now the Upanishad reduces every physical temple and pilgrimage site on Earth to worthless dirt, spitting the most dangerous truth."
                    "That Yogi mutates into the 'Supreme Swan' (Sa eva paramo hamsah), and he explicitly becomes the literal Soul of the entire cosmos (Jagadatmakah)."
                    "The Upanishad violently screams: 'Deho devalayah proktah'—This exact biological framework of flesh and bone is the absolute, greatest, and ONLY authentic 'Temple' in the universe!"
                    "External temples are constructed of pathetic bricks and stones, but this biological shell is the fortress God built strictly for His own residence."
                    "And what exactly is the idol inside this temple? 'Sa jivah kevalah Shivah'—This 'Soul' (Jiva) sitting inside you is absolutely no one else, it is 100% exclusively and explicitly 'Shiva' Himself!"
                    "You are absolutely no sinful or weak mortal; you are the literal Mahakala hiding covertly inside the exact temple (body) you constructed."
                    "The pathetic fool hunting for Shiva externally in mountains or stones is the most utterly blind entity in the cosmos."
                    "Your chest is the Sanctum Sanctorum, and your beating heart is the literal Damaru (Drum) of Shiva."
                    "This is absolutely not the rejection of the body, but the apocalyptic philosophy of weaponizing the biological shell as God's impenetrable Titanium Fortress."
                    "The exact microsecond you Hack this absolute truth, your humanity is permanently exterminated forever!"
                """.trimIndent()
            ),
            SkandaShloka(
                id = 5,
                sanskrit = "त्यजेदज्ञाननिर्माल्यं सोऽहंभावेन पूजयेत् । अभेददर्शनं ज्ञानं ध्यानं निर्विषयं मनः ॥ ५॥",
                hindi = """
                    (अज्ञान के कचरे का त्याग और 'सोऽहम्' की पूजा): "जब शरीर ही मंदिर है और तुम ही शिव हो, तो पूजा कैसे करनी है? उपनिषद इसका खौफनाक तरीका बताता है।"
                    "'त्यजेदज्ञाननिर्माल्यं'— अज्ञान (Ignorance) और बाहरी कर्मकांडों के सड़े हुए 'कचरे' (निर्माल्य) को मंदिर से बाहर फेंक दो!"
                    "तुम्हें फूल, पानी या अगरबत्ती की कोई ज़रूरत नहीं है; भगवान इन भौतिक चीज़ों का भूखा नहीं है।"
                    "तो असली पूजा क्या है? 'सोऽहंभावेन पूजयेत्'— 'सोऽहम्' (वह परब्रह्म मैं ही हूँ!) के इस प्रलयंकारी और खूँखार भाव से अपनी ही पूजा करो!"
                    "अपनी ही आत्मा को भगवान मानकर अपने सामने सर झुकाना ही ब्रह्मांड की सबसे बड़ी पूजा है।"
                    "'अभेददर्शनं ज्ञानं'— जब तुम्हें अपने और ईश्वर के बीच कोई भेद (दूरी/Difference) नज़र न आए, तो यही दुनिया का असली और सबसे खतरनाक 'ज्ञान' है।"
                    "और 'ध्यानं निर्विषयं मनः'— असली ध्यान आँखें बंद करना नहीं है, बल्कि अपने मन को हर विषय (Object) से काटकर पूरी तरह शून्य (Zero) कर देना है!"
                    "जब मन का स्क्रीन (Screen) पूरी तरह ब्लैक (Black) हो जाता है, तभी उस पर भगवान का असली चेहरा दिखाई देता है।"
                    "बाहरी पूजा कमज़ोरों के लिए है; यह आंतरिक हैकिंग (Hacking) केवल उन योगियों के लिए है जो खुद भगवान बनना चाहते हैं।"
                    "इस 'सोऽहम्' के धमाके से इंसान का छोटा अहंकार (Ego) हमेशा के लिए राख हो जाता है!"
                """.trimIndent(),
                english = """
                    (Discarding the Garbage of Ignorance and the Worship of 'So'ham'): "When the biological body is the temple and you yourself are Shiva, how must you worship? The Upanishad reveals the terrifying method."
                    "'Tyajedajnana-nirmalyam'—Violently throw the rotting 'Garbage' (Nirmalya) of Ignorance and pathetic external rituals out of the temple!"
                    "You require absolutely zero physical flowers, water, or incense; God is absolutely not hungry for these pathetic earthly objects."
                    "What then is authentic worship? 'So'ham-bhavena pujayet'—Execute absolute worship strictly through the apocalyptic, ferocious conviction of 'So'ham' (I myself am that Supreme Brahman)!"
                    "Bowing down before your own Soul, recognizing it explicitly as God, is the absolute greatest worship in the entire cosmos."
                    "'Abhedadarshanam jnanam'—When you physically perceive absolutely zero Difference (Distance) between yourself and God, this is the universe's most dangerous, authentic 'Knowledge'."
                    "And 'Dhyanam nirvishayam manah'—True meditation is not closing your eyes, but brutally severing your mind from every physical Object, mutating it into absolute Zero!"
                    "Only when the biological screen of the mind goes completely pitch-black does the authentic face of God manifest upon it."
                    "External worship is for pathetic weaklings; this internal Hacking is strictly for those Titans who demand to mutate into God."
                    "Triggered by the detonation of this 'So'ham', the pathetic human Ego is permanently reduced to absolute ashes!"
                """.trimIndent()
            ),
            SkandaShloka(
                id = 6,
                sanskrit = "स्नानं मनोमलत्यागः शौचमिन्द्रियनिग्रहः । ब्रह्मामृतं पिबेद्भैक्षमाचरेद्देहरक्षणे ॥ ६॥",
                hindi = """
                    (असली स्नान, शौच और ब्रह्मांडीय अमृत का पान): "इस योग के मार्ग में बाहरी दुनिया के स्नान और पवित्रता को उपनिषद पैरों तले कुचल देता है।"
                    "'स्नानं मनोमलत्यागः'— नदियों में शरीर धोने से तुम पवित्र नहीं होते; असली नहाना (स्नान) अपने मन के सड़े हुए कचरे (वासना और क्रोध) को काटकर फेंकना है!"
                    "'शौचमिन्द्रियनिग्रहः'— असली सफाई (शौच) पानी से नहीं होती; अपनी पाँचों इंद्रियों (Senses) का निर्मम गला घोंट देना (निग्रह) ही ब्रह्मांड की सबसे बड़ी पवित्रता है!"
                    "जिसकी आँखें वासना देख रही हैं, वह चाहे दिन में सौ बार नहाए, वह अंदर से कीचड़ से सना हुआ है।"
                    "और योगी खाता क्या है? 'ब्रह्मामृतं पिबेद्'— वह साक्षात 'परब्रह्म के असीम ज्ञान रुपी अमृत' को अपनी आत्मा में पीता है!"
                    "वह इस भौतिक दुनिया का खाना नहीं खाता; वह अंतरिक्ष की ऊर्जा (Cosmic Energy) को निगल जाता है।"
                    "'भैक्षमाचरेद्देहरक्षणे'— वह केवल इस सड़े हुए शरीर (मशीन) को ज़िंदा रखने के लिए रूखा-सूखा 'भिक्षा' का अन्न डाल देता है।"
                    "उसे स्वाद (Taste) से कोई मतलब नहीं; उसकी जीभ का पूरी तरह से वध हो चुका है।"
                    "यह शरीर के सिस्टम (System) को हैक करने का ऐसा विज्ञान है जहाँ इंसान बाहरी पानी से नहीं, बल्कि आंतरिक आग से खुद को साफ करता है।"
                    "जिसने इस ब्रह्मामृत को पी लिया, उसके लिए दुनिया के सारे ज़हर और सारे सुख एक बराबर हो जाते हैं!"
                """.trimIndent(),
                english = """
                    (The Authentic Bath, Purity, and Devouring the Cosmic Nectar): "On this path of Yoga, the Upanishad violently tramples the physical world's concept of bathing and purity beneath its boots."
                    "'Snanam manomalatyagah'—Washing your flesh in pathetic rivers absolutely does not purify you; the authentic 'Bath' is brutally hacking away and discarding the rotting garbage (lust and wrath) of your mind!"
                    "'Shauchamindriyanigrahah'—Authentic 'Purity' is not achieved with water; the ruthless, cold-blooded strangulation (Nigraha) of your five biological Senses is the supreme purity in the cosmos!"
                    "He whose eyes hallucinate lust, even if he bathes a hundred times a day, is fundamentally coated in filthy internal mud."
                    "And what exactly does the Yogi consume? 'Brahmamritam pibed'—He physically drinks and devours the 'Apocalyptic Nectar of Supreme Brahman' directly into his Soul!"
                    "He absolutely does not consume the pathetic food of this physical matrix; he violently swallows the raw Cosmic Energy of space."
                    "'Bhaikshyamachareddeharakshane'—He merely dumps dry, tasteless begged scraps into his stomach strictly to keep this rotting biological machine from dying."
                    "He possesses absolutely zero concept of 'Taste'; his physical tongue has been completely, permanently assassinated."
                    "This is the horrific science of Hacking the body's system, where a human purifies himself not with external water, but with an apocalyptic internal fire."
                    "He who has swallowed this Brahmamrita treats all the lethal poisons and physical pleasures of the world as flawlessly identical!"
                """.trimIndent()
            ),
            SkandaShloka(
                id = 7,
                sanskrit = "एकान्ते द्वैतमुत्सृज्य वसेदैकान्तिको भूत्वा । इत्येवमाचरेद्धीमान् स मुक्तिमधिगच्छति ॥ ७॥",
                hindi = """
                    (भयंकर एकांत और द्वैत का संहार): "अब उस योगी को एक ऐसे युद्ध के मैदान में उतरना होता है जहाँ कोई दूसरा इंसान नहीं आ सकता।"
                    "'एकान्ते द्वैतमुत्सृज्य'— उसे सबसे खौफनाक और गहरे एकांत (Isolation) में जाकर 'द्वैत' (Duality / यह दुनिया और मैं अलग हैं) के भ्रम का बेरहमी से कत्ल करना होता है!"
                    "जब तुम अकेले होते हो, तब तुम्हारा अहंकार सबसे ज़्यादा तड़पता है; योगी इसी अकेलेपन का इस्तेमाल अहंकार को भूखा मारने के लिए करता है।"
                    "'वसेदैकान्तिको भूत्वा'— वह इंसानियत की भीड़ से हमेशा के लिए कटकर, पूरी तरह से 100% 'अकेला' (Singular) होकर निवास करता है।"
                    "उसके लिए कोई दोस्त, कोई परिवार, कोई धर्म और कोई गुरु नहीं बचता; वह सीधे उस परब्रह्म के साथ लॉक (Lock) हो जाता है।"
                    "जब इंसान भीड़ में होता है, तो वह केवल एक बायोलॉजिकल जानवर होता है; लेकिन जब वह अकेले में अपने विचारों का वध करता है, तो वह भगवान बन जाता है।"
                    "'इत्येवमाचरेद्धीमान्'— जो प्रलयंकारी बुद्धिमान (Titan) इस खौफनाक आचरण (Practice) को अपने डीएनए (DNA) में उतार लेता है..."
                    "'स मुक्तिमधिगच्छति'— केवल और केवल वही इंसान मौत की छाती पर पैर रखकर उस परम 'मुक्ति' (Absolute Liberation) को अपनी मुट्ठी में कुचल लेता है!"
                    "यह कोई समाज सेवा नहीं है; यह अपने ही वजूद को मिटाकर पूरे ब्रह्मांड को जीत लेने का सबसे हिंसक रास्ता है।"
                    "अकेलेपन की इस आग में जलकर ही इंसान उस परम शून्यता में दाखिल होता है जहाँ से कोई वापस नहीं लौटता!"
                """.trimIndent(),
                english = """
                    (Terrifying Isolation and the Slaughter of Duality): "Now that Yogi must descend into a psychological battlefield where absolutely no other human can ever enter."
                    "'Ekante dvaitamutsrijya'—He must plunge into the most horrific, absolute Isolation and ruthlessly slaughter the hallucination of 'Duality' (the illusion that I and the world are separate)!"
                    "When you are completely alone, your ego agonizes the most; the Yogi weaponizes this exact isolation to brutally starve his ego to death."
                    "'Vasedaikantiko bhutva'—Violently severing himself from the pathetic crowds of humanity, he resides completely, 100% 'Alone' (Singular)."
                    "For him, absolutely zero friends, family, religion, or gurus survive; he Locks directly into a one-on-one frequency with the Supreme Brahman."
                    "When a human is in a crowd, he is merely a biological animal; but when he assassinates his own thoughts in isolation, he mutates into God."
                    "'Ityevamachareddhiman'—The apocalyptic Titan who injects this terrifying 'Practice' directly into his DNA..."
                    "'Sa muktimadhigacchati'—Strictly and exclusively he plants his titanium boot on the chest of Death and crushes that Supreme 'Liberation' within his fist!"
                    "This is absolutely no pathetic social service; it is the most violent, ruthless path of erasing your own existence to conquer the entire infinite cosmos."
                    "Burning in this radioactive fire of isolation, the human penetrates that Supreme Void from which absolutely no one ever returns!"
                """.trimIndent()
            ),

            SkandaShloka(
                id = 8,
                sanskrit = "शिवाय विष्णुरूपाय शिवरूपाय विष्णवे । शिवस्य हृदयं विष्णुर्विष्णोश्च हृदयं शिवः ॥ ८॥",
                hindi = """
                    (हरि और हर का प्रलयंकारी विलय): "दुनिया के मूर्ख लोग शिव और विष्णु को अलग-अलग भगवान मानकर आपस में लड़ते हैं, लेकिन यह उपनिषद इस अज्ञान के चीथड़े उड़ा देता है!"
                    "उपनिषद गर्जना करता है: 'शिवाय विष्णुरूपाय'— मैं उस शिव को प्रणाम करता हूँ जो साक्षात विष्णु का ही रूप धारण किए हुए है!"
                    "'शिवरूपाय विष्णवे'— और मैं उस विष्णु को नमन करता हूँ जो 100% शिव के ही खौफनाक रूप में मौजूद है!"
                    "ब्रह्मांड का सबसे बड़ा हैकिंग कोड (Hacking Code) सुनो: 'शिवस्य हृदयं विष्णुः'— शिव के धड़कते हुए हृदय के ठीक बीचों-बीच साक्षात 'विष्णु' बैठे हैं!"
                    "'विष्णोश्च हृदयं शिवः'— और भगवान विष्णु के प्रलयंकारी हृदय के भीतर साक्षात महाकाल 'शिव' का निवास है!"
                    "यह कोई दो अलग-अलग भगवान नहीं हैं; यह एक ही ब्रह्मांडीय सुपर-पावर (Super-Power) के दो अलग-अलग हथियार हैं।"
                    "विष्णु वह कोड (Code) है जो इस माया (Matrix) को चलाता है, और शिव वह वायरस (Virus) है जो इस मैट्रिक्स को क्रैश (Crash) कर देता है!"
                    "जो मूर्ख इन दोनों में भेद देखता है, वह नरक की सबसे गहरी खाई में सड़ने के लिए मजबूर है।"
                    "जब योगी इस अद्वैत (Non-dual) रहस्य को हैक कर लेता है, तो उसके दिमाग में सारे भगवान एक ही 'परम शून्यता' में पिघल जाते हैं।"
                    "सनातन धर्म का यह सबसे बड़ा एटम बम (Atom Bomb) है जो हर तरह के धार्मिक बँटवारे को एक ही झटके में भस्म कर देता है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Fusion of Hari and Hara): "The pathetic fools of the world hallucinate Shiva and Vishnu as separate Gods and wage biological wars, but this Upanishad violently shreds this ignorance to dust!"
                    "The Upanishad roars: 'Shivaya Vishnurupaya'—I salute that explicit Shiva who has literally weaponized and manifested exactly as the form of Vishnu!"
                    "'Shivarupaya Vishnave'—And I salute that literal Vishnu who exists 100% flawlessly in the terrifying form of Shiva!"
                    "Listen to the absolute greatest Hacking Code of the cosmos: 'Shivasya hridayam Vishnuh'—Exactly in the dead-center of Shiva's beating heart sits explicit 'Vishnu'!"
                    "'Vishnoshcha hridayam Shivah'—And locked directly inside the apocalyptic heart of Lord Vishnu resides the explicit Mahakala 'Shiva'!"
                    "These are absolutely not two separate Gods; they are two distinct weapons of the exact same singular Cosmic Super-Power."
                    "Vishnu is the absolute Code that operates this Matrix (Maya), and Shiva is the catastrophic Virus that completely Crashes this Matrix!"
                    "The pathetic fool who hallucinates a difference between them is condemned to rot in the deepest, most horrific abyss of hell."
                    "When the Yogi successfully Hacks this Non-Dual secret, every single God in his brain violently melts down into ONE 'Supreme Void'."
                    "This is Sanatana Dharma's ultimate Atom Bomb that instantaneously incinerates every microscopic trace of religious division to absolute ashes!"
                """.trimIndent()
            ),
            SkandaShloka(
                id = 9,
                sanskrit = "यथा शिवमयो विष्णुरेवं विष्णुमयः शिवः । यथान्तरं न पश्यामि तथा मे स्वस्तिरायुषि ॥ ९॥",
                hindi = """
                    (भेदभाव की मौत और अटल दृष्टि): "जब योगी उस हरि-हर (विष्णु-शिव) के अद्वैत सत्य को पी लेता है, तो उसकी नज़र से 'भेदभाव' (Separation) हमेशा के लिए अंधा हो जाता है।"
                    "उपनिषद चीखता है: 'यथा शिवमयो विष्णुः'— जिस 100% सत्यता के साथ साक्षात विष्णु पूरी तरह से 'शिव-मय' (शिव से भरे हुए) हैं..."
                    "'एवं विष्णुमयः शिवः'— ठीक उसी खौफनाक और प्रलयंकारी सत्यता के साथ साक्षात शिव पूरी तरह से 'विष्णु-मय' हैं!"
                    "इन दोनों के बीच एक मिलीमीटर के करोड़वें हिस्से का भी कोई फर्क नहीं है; दोनों एक ही सिक्के के दो पहलू नहीं, दोनों साक्षात एक ही सिक्का हैं!"
                    "योगी ब्रह्मांड को चुनौती देते हुए कहता है: 'यथान्तरं न पश्यामि'— मैं इन दोनों के बीच रत्ती भर भी कोई 'अंतर' (Difference) नहीं देखता!"
                    "मेरी आँखों ने द्वैत (Duality) को देखना बंद कर दिया है; मेरे दिमाग का वह सॉफ्टवेयर हमेशा के लिए क्रैश (Crash) हो चुका है जो चीज़ों को अलग देखता था।"
                    "'तथा मे स्वस्तिरायुषि'— जब तक मैं इस अटल अद्वैत दृष्टि में लॉक (Lock) रहूँगा, तब तक मेरे जीवन का 'स्वस्ति' (Absolute Cosmic Welfare/अमरता) अटल रहेगा!"
                    "जिस इंसान के दिमाग में दो भगवान हैं, वह इंसान अभी भी माया का कैदी है।"
                    "लेकिन जिसने दोनों को एक ही आग में पिघलाकर एक कर दिया, उसने साक्षात ब्रह्मांड का मास्टर पासवर्ड (Master Password) हैक कर लिया है।"
                    "यह दृष्टि इंसान को एक जानवर से उठाकर सीधे उस सिंहासन पर बैठा देती है जहाँ से पूरा ब्रह्मांड एक छोटी सी स्क्रीन (Screen) पर दिखता है!"
                """.trimIndent(),
                english = """
                    (The Assassination of Separation and the Ironclad Vision): "When the Yogi entirely devours the non-dual absolute truth of Hari-Hara (Vishnu-Shiva), his eyes become permanently blind to 'Separation' (Duality)."
                    "The Upanishad screams: 'Yatha Shivamayo Vishnuh'—With the exact 100% absolute reality that explicit Vishnu is entirely 'Shiva-maya' (Saturated with Shiva)..."
                    "'Evam Vishnumayah Shivah'—With that exact same terrifying and apocalyptic reality, explicit Shiva is entirely 'Vishnu-maya'!"
                    "There is absolutely not a billionth of a millimeter's difference between them; they are not two sides of a coin, they are literally the EXACT same coin!"
                    "The Yogi challenges the cosmos, roaring: 'Yathantaram na pashyami'—I physically perceive absolutely zero micro-drop of 'Difference' between them!"
                    "My biological eyes have permanently stopped hallucinating Duality; the software in my brain that processes separation has suffered a catastrophic Crash."
                    "'Tatha me svastirayushi'—As long as I remain permanently Locked in this unbreakable non-dual vision, the 'Svasti' (Absolute Cosmic Immortality) of my existence remains indestructible!"
                    "The human whose brain harbors two Gods is still a pathetic maximum-security prisoner of Maya."
                    "But he who has melted both Gods into a single radioactive fire has explicitly Hacked the Master Password of the entire cosmos."
                    "This terrifying Vision violently drags a human from the status of an animal and slams him onto the throne where the entire universe is viewed on a microscopic Screen!"
                """.trimIndent()
            ),
            SkandaShloka(
                id = 10,
                sanskrit = "यथान्तरं न भेदोऽस्ति शिवकेशवयोस्तथा । इत्येवमक्षरं ब्रह्म स मुक्तो भवति इत्युपनिषत् ॥ १०॥",
                hindi = """
                    (परम मोक्ष की अंतिम मुहर और 'द एंड'): "उपनिषद अपने इस ज्ञान रूपी ब्रह्मांडीय न्यूक्लियर बम का अंतिम और सबसे प्रलयंकारी धमाका करता है!"
                    "'यथान्तरं न भेदोऽस्ति शिवकेशवयोस्तथा'— जिस तरह शिव और केशव (विष्णु) के बीच रत्ती भर भी कोई भेद या दूरी नहीं है..."
                    "ठीक उसी तरह, इंसान की 'आत्मा' और उस असीम 'परब्रह्म' के बीच भी कोई भेद नहीं है; तुम और भगवान 100% एक ही हो!"
                    "जब यह खौफनाक सच इंसान के दिमाग में फटता है, तो उसका 'मैं शरीर हूँ' का सड़ा हुआ अहंकार हमेशा-हमेशा के लिए राख हो जाता है।"
                    "'इत्येवमक्षरं ब्रह्म'— यही वह कभी नष्ट न होने वाला, अजेय और अमर 'अक्षर ब्रह्म' (The Ultimate Indestructible God) का परम सत्य है!"
                    "जिसने इस सत्य को केवल पढ़ा नहीं, बल्कि अपनी रगों में उतार कर अपनी इंसानियत का कत्ल कर दिया..."
                    "'स मुक्तो भवति'— वह इंसान निश्चित रूप से, पूरे ब्रह्मांड की 100% गारंटी के साथ, जन्म-मरण की इस जेल से हमेशा के लिए 'मुक्त' (Liberated) हो जाता है!"
                    "उसे दोबारा किसी माँ के गर्भ में उल्टा लटकने की खौफनाक सज़ा नहीं भुगतनी पड़ती; वह समय और मौत के पार निकल कर भगवान बन जाता है।"
                    "यहीं पर यह रोंगटे खड़े कर देने वाला 'स्कंद उपनिषद' पूर्ण रूप से संपन्न होता है (इत्युपनिषत्)।"
                    "यह सनातन धर्म की वह सबसे नंगी और क्रूर सच्चाई है, जहाँ मोक्ष भीख में नहीं मिलता, बल्कि अपना सिर काटकर छीना जाता है! ॐ शांति!"
                """.trimIndent(),
                english = """
                    (The Final Seal of Ultimate Moksha and 'The End'): "The Upanishad detonates the final, most apocalyptic explosion of this cosmic nuclear bomb of Knowledge!"
                    "'Yathantaram na bhedo'sti Shivakeshavayostatha'—Exactly as there is absolutely zero micro-drop of difference or distance between Shiva and Keshava (Vishnu)..."
                    "In that exact terrifying manner, there is absolutely zero difference between the human 'Soul' and the infinite 'Supreme Brahman'; YOU and God are 100% identical!"
                    "When this horrific absolute truth detonates inside the human skull, the rotting ego of 'I am this body' is incinerated to absolute dust forever."
                    "'Ityevamaksharam Brahma'—THIS explicitly is the supreme, absolute truth of the indestructible, invincible, immortal 'Akshara Brahman' (The Ultimate God)!"
                    "He who has not merely read this truth, but has injected it into his veins and executed the brutal slaughter of his own humanity..."
                    "'Sa mukto bhavati'—That human being undoubtedly, with a 100% ironclad cosmic guarantee, becomes flawlessly, permanently 'Liberated' from this maximum-security prison of birth and death!"
                    "He absolutely never again has to suffer the terrifying punishment of hanging upside down inside a biological mother's womb; he rockets beyond Time and Death to mutate into God."
                    "Right exactly here, this spine-chilling, apocalyptic 'Skanda Upanishad' achieves its absolute majestic completion (Ityupanishat)."
                    "This is the most naked, cold-blooded truth of Sanatana Dharma: Moksha is never granted as pathetic charity; it is violently snatched by decapitating your own head! OM Peace!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkandaUpanishadScreen() {
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
                // Validates if the number is between 1 and 10
                if (shlokaNumber != null && shlokaNumber in 1..10) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-10)") },
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
            itemsIndexed(SkandaUpanishad.skandaShlokasList) { _, shloka ->
                SkandaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SkandaShlokaCard(shloka: SkandaUpanishad.SkandaShloka) {
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