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

class MahavakyaUpanishad {

    // Data Model
    data class MahavakyaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val mahavakyaShlokasList = listOf(
            MahavakyaShloka(
                id = 1,
                sanskrit = "अथातो महावाक्योपनिषदं व्याख्यास्यामः । यदक्षरं परं ब्रह्म तदेव महावाक्यम् ॥ १॥",
                hindi = """
                    (महावाक्य का प्रलयंकारी आरंभ): "अब हम उस अत्यंत गुप्त और खौफनाक 'महावाक्य उपनिषद' के रहस्य को खोलेंगे, जिसे सुनकर कमज़ोर दिमाग फट जाते हैं।"
                    "इस ब्रह्मांड में अरबों शब्द और करोड़ो ग्रंथ हैं, लेकिन 'महावाक्य' (The Supreme Pronouncement) केवल वही है जो इंसान को सीधा भगवान बना दे।"
                    "वह महावाक्य कोई साधारण मंत्र या प्रार्थना नहीं है; वह साक्षात 'अक्षरं परं ब्रह्म' (अविनाशी परमेश्वर) का भौतिक और ध्वनि रूप (Sound Form) है!"
                    "जब यह महावाक्य किसी सच्चे योगी के कानों से होकर उसकी आत्मा में प्रवेश करता है, तो यह एक ब्रह्मांडीय न्यूक्लियर बम की तरह फटता है।"
                    "यह इंसान के इस सड़े हुए घमंड को एक झटके में जला देता है कि वह मिट्टी से बना एक नश्वर जीव है।"
                    "यह शब्द नहीं, बल्कि एक प्रलयंकारी आग है जो इंसान और ईश्वर के बीच की उस झूठी दीवार को हमेशा के लिए भस्म कर देती है।"
                    "वेदों का अंतिम और सबसे खतरनाक हथियार यही महावाक्य है, जिसे केवल वही बर्दाश्त कर सकता है जिसने अपनी वासनाओं का कत्ल कर दिया हो।"
                    "जो इस महावाक्य को केवल जीभ से रटता है, वह दुनिया का सबसे बड़ा गधा है।"
                    "और जो इसे अपनी आत्मा की गहराई में फोड़ता है, वह साक्षात इस पूरे असीम ब्रह्मांड का इकलौता तानाशाह बन जाता है।"
                    "यहीं से माया (Matrix) को हैक करने और उसे नष्ट करने के उस परम विज्ञान की शुरुआत होती है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Genesis of the Mahavakya): "Now we shall violently rip open the highly classified and terrifying secret of the 'Mahavakya Upanishad', which shatters weak mortal minds."
                    "There are billions of words and millions of scriptures in this cosmos, but the 'Mahavakya' (The Supreme Pronouncement) is exclusively that which instantaneously mutates a human into God."
                    "That Mahavakya is absolutely no ordinary mantra or pathetic prayer; it is the literal, physical acoustic manifestation (Sound Form) of the 'Indestructible Supreme Brahman'!"
                    "When this Mahavakya penetrates the ears of a genuine Yogi and sinks into his soul, it detonates exactly like a cosmic nuclear bomb."
                    "It instantaneously incinerates the rotting human hallucination that he is merely a mortal creature constructed of pathetic dirt."
                    "This is absolutely not a word, but a radioactive, apocalyptic fire that permanently burns down the fake boundary between human and God."
                    "This Mahavakya is the absolute final, most lethal weapon of the Vedas, endurable strictly only by him who has brutally assassinated his biological lusts."
                    "He who merely memorizes and chants this Mahavakya with his physical tongue is the greatest beast of burden in existence."
                    "And he who detonates it deep within his absolute core instantaneously becomes the sole, undisputed Dictator of this entire infinite universe."
                    "Right here begins the supreme, terrifying science of completely hacking and destroying the Matrix of Maya!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 2,
                sanskrit = "अन्तरादित्ये विद्यमानं... हिरण्मयं पुरुषं... स एष सर्वभूतान्तरात्मा ॥ २॥",
                hindi = """
                    (हृदय के भीतर का खौफनाक ब्रह्मांडीय सूर्य): "उपनिषद इंसान को आसमान की तरफ देखने से रोकता है और सबसे भयानक सच उसके ही सीने में दिखाता है।"
                    "तुम्हारे हृदय के भीतर एक ऐसा प्रलयंकारी 'अदृश्य सूर्य' (अन्तरादित्ये) धधक रहा है, जिसकी गर्मी करोड़ों भौतिक सूर्यों से भी ज़्यादा है!"
                    "उस आग के ठीक बीचों-बीच वह 'हिरण्मय पुरुष' (सोने की तरह धधकता हुआ सर्वोच्च परमेश्वर) विराजमान है!"
                    "वह भगवान किसी सातवें आसमान पर नहीं बैठा; वह 'सर्वभूतान्तरात्मा' (हर एक जीव की असली और सबसे भीतरी आत्मा) के रूप में तुम्हारे ही अंदर छिपकर बैठा है।"
                    "जो मूर्ख ईश्वर को बाहर पत्थरों या बादलों में खोज रहे हैं, वे ब्रह्मांड के सबसे बड़े अंधे और अज्ञानी हैं।"
                    "तुम्हारे सीने में जो धड़क रहा है, वह तुम्हारा कमज़ोर दिल नहीं, वह इस पूरी सृष्टि को चलाने वाले महाकाल का सेंटर (Center) है।"
                    "जब योगी ध्यान के हथौड़े से अपने सीने की इस तिजोरी को तोड़ता है, तो वह इसी हिरण्मय पुरुष (Golden Titan) से आमने-सामने टकराता है।"
                    "उस धधकते हुए सत्य को देखते ही इंसान का 'मैं' (Ego) चीख मारते हुए उसी आग में गिरकर भस्म हो जाता है।"
                    "तब उसे एहसास होता है कि पूरे ब्रह्मांड का पावर-हाउस (Powerhouse) उसी की अपनी आत्मा है।"
                    "ईश्वर तुमसे एक मिलीमीटर भी दूर नहीं है; वह तुम ही हो, बस तुम्हें इस नश्वर शरीर का भ्रम छोड़ना होगा!"
                """.trimIndent(),
                english = """
                    (The Terrifying Cosmic Sun Inside the Heart): "The Upanishad violently stops the human from looking at the sky and forces him to witness the most horrific truth right inside his own chest."
                    "Deep within your core blazes an apocalyptic 'Invisible Sun' (Antaraditye) whose radioactive heat infinitely surpasses billions of physical suns!"
                    "Directly in the dead epicenter of that raging fire sits the 'Hiranmaya Purusha' (The Supreme God blazing like liquid gold)!"
                    "That God does not sit on some pathetic seventh heaven; He sits terrifyingly hidden right inside you as the 'Sarva-bhutantaratma' (The Absolute Inner Soul of every single creature)."
                    "The pathetic fools hunting for God externally in stones or clouds are the most completely blind and ignorant entities in the cosmos."
                    "What pounds within your chest is absolutely not your weak biological heart; it is the central command of Mahakala who operates this entire creation."
                    "When the Yogi uses the sledgehammer of meditation to violently smash open this vault in his chest, he collides face-to-face with this Golden Titan."
                    "The exact microsecond he witnesses that blazing truth, his human 'Ego' (I) screams and plunges into that exact fire, burning to absolute ashes."
                    "He then flawlessly realizes that the ultimate Powerhouse of the entire infinite cosmos is his very own Soul."
                    "God is absolutely not a micro-millimeter away from you; He is exactly YOU, provided you violently discard the pathetic illusion of this mortal flesh!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 3,
                sanskrit = "अज्ञानतिमिरातीतं... प्रज्ञानं ब्रह्म... ॥ ३॥",
                hindi = """
                    (अज्ञान का कत्ल और पहला महावाक्य - प्रज्ञानं ब्रह्म): "जब उस आंतरिक सूर्य का विस्फोट होता है, तो इंसान के जन्मों का अँधेरा खत्म हो जाता है।"
                    "वह साक्षात 'अज्ञानतिमिरातीतं'— इस ब्रह्मांडीय अज्ञान (Maya) के घने और दमघोंटू अँधेरे को चीरकर हमेशा के लिए उसके पार निकल जाता है।"
                    "तब उसे ऋग्वेद का वह पहला प्रलयंकारी महावाक्य अपनी ही रगों में दौड़ता हुआ सुनाई देता है— 'प्रज्ञानं ब्रह्म'!"
                    "यानी, 'वह शुद्ध चेतना (Supreme Consciousness) ही साक्षात परब्रह्म है!'"
                    "तुम्हारे भीतर जो 'जानने' की ताक़त है, जो हर चीज़ को 'देख' रही है, वह कोई दिमागी केमिकल नहीं, वह खुद भगवान है!"
                    "यह दुनिया पत्थरों, पानी और गैस से नहीं बनी है; इस पूरे ब्रह्मांड की ईंट (Building block) केवल और केवल 'चेतना' है।"
                    "यह शरीर एक बायोलॉजिकल रोबोट है, लेकिन इसके भीतर जो सॉफ्टवेयर (चेतना) है, वह साक्षात इस ब्रह्मांड का रचयिता है।"
                    "जो इस 'प्रज्ञान' (Pure Awareness) को पहचान लेता है, वह माया की इस जेल का जेलर बन जाता है।"
                    "यह कोई फिलॉसफी नहीं है; यह इंसान की चेतना को हैक करके उसे सीधा ईश्वर की फ्रीक्वेंसी पर सेट करने का विज्ञान है।"
                    "इस एक महावाक्य के धमाके से इंसान की 'मृत्यु' का खौफ हमेशा के लिए भस्म हो जाता है!"
                """.trimIndent(),
                english = """
                    (The Slaughter of Ignorance and the First Mahavakya - Prajnanam Brahma): "When that internal cosmic sun violently detonates, the darkness of billions of human lifetimes is completely annihilated."
                    "He explicitly becomes 'Ajnana-timiratitam'—violently tearing through the dense, suffocating, pitch-black darkness of cosmic ignorance (Maya) to permanently escape it."
                    "It is then he hears the first apocalyptic Mahavakya of the Rig Veda coursing like radioactive fire through his veins—'Prajnanam Brahma'!"
                    "Meaning, 'That Pure Absolute Consciousness is explicitly the Supreme Brahman Himself!'"
                    "The power inside you that 'Knows', the raw entity that is 'Witnessing' everything, is absolutely no biological brain chemical; it is God Himself!"
                    "This universe is absolutely not constructed of rocks, water, and gas; the absolute fundamental building block of this entire cosmos is exclusively 'Consciousness'."
                    "This physical body is a pathetic biological robot, but the software (Awareness) operating inside it is literally the Creator of this universe."
                    "He who flawlessly recognizes this 'Prajnana' (Pure Awareness) instantaneously mutates from a prisoner of Maya into the absolute Warden of this cosmic prison."
                    "This is absolutely no philosophy; it is the ruthless science of hacking human consciousness and tuning it directly to the exact frequency of God."
                    "With the atomic detonation of this single Mahavakya, the human fear of 'Death' is permanently incinerated to absolute ashes!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 4,
                sanskrit = "अहं ब्रह्मास्मि... महावाक्येन बोधितः... ॥ ४॥",
                hindi = """
                    (दूसरा महावाक्य - मैं ही ब्रह्म हूँ): "अब यजुर्वेद का वह दूसरा महावाक्य ब्रह्मांड को हिलाते हुए उस योगी के गले से गर्जना बनकर निकलता है।"
                    "वह अपनी आत्मा की असीम गहराई से पूरी सृष्टि को चुनौती देते हुए दहाड़ता है— 'अहं ब्रह्मास्मि' (मैं ही साक्षात परब्रह्म हूँ)!"
                    "यह दुनिया का सबसे बड़ा और सबसे खौफनाक दुस्साहस है; वह इंसान होने से साफ इंकार कर देता है!"
                    "वह घोषणा करता है: 'मैं यह सड़ा हुआ खून और मांस का ढांचा नहीं हूँ, मैं ही वह असीम ऊर्जा हूँ जो सितारों को जलाती है!'"
                    "'महावाक्येन बोधितः'— इस महावाक्य के भयानक प्रहार से उसके दिमाग के सारे पुराने सॉफ्टवेयर (संस्कार) डिलीट हो जाते हैं।"
                    "जो कल तक भगवान के सामने भीख मांगता था, आज वह खुद भगवान के सिंहासन पर जाकर बैठ गया है।"
                    "उसका अहंकार (Ego) ऐसे मरता है जैसे आग में एक सूखा पत्ता, और उसकी जगह एक ऐसा 'विराट मैं' (Cosmic I) जन्म लेता है जिसका कोई अंत नहीं।"
                    "जब 'मैं ही भगवान हूँ', तो फिर न कोई मुझे सजा दे सकता है, न कोई मुझे नर्क में धकेल सकता है और न कोई मुझे मार सकता है।"
                    "यह सनातन धर्म का वह सबसे नंगा और खतरनाक सच है जिसे सुनने से कमज़ोर धर्म वाले थर-थर काँपते हैं।"
                    "यह 'अहं ब्रह्मास्मि' इंसान को कीड़े की औकात से उठाकर सीधे ब्रह्मांड का परम मालिक बना देता है!"
                """.trimIndent(),
                english = """
                    (The Second Mahavakya - I Am Brahman): "Now the second apocalyptic Mahavakya of the Yajur Veda violently erupts like a cosmic roar from the Yogi's throat, shaking the universe."
                    "From the infinite abyss of his soul, challenging the entire fabric of creation, he roars—'Aham Brahmasmi' (I myself am explicitly the Supreme Brahman)!"
                    "This is the world's most terrifying and absolute audacity; he flatly and brutally refuses to be a human being anymore!"
                    "He ferociously declares: 'I am absolutely not this rotting biological framework of blood and meat; I am that infinite, primordial energy that burns the stars!'"
                    "'Mahavakyena bodhitah'—By the catastrophic strike of this Mahavakya, all the pathetic old software (Conditioning) of his mortal brain is completely deleted."
                    "He who begged pathetically before God yesterday has violently marched up and sat directly on the undisputed throne of God today."
                    "His human ego dies a brutal death exactly like a dry leaf in a blazing inferno, giving violent birth to a 'Colossal Cosmic I' that possesses no end."
                    "When 'I myself am God', absolutely no one possesses the authority to punish me, no one can drag me to hell, and absolutely nothing can kill me."
                    "This is the most naked, lethal, and dangerous truth of Sanatana Dharma, hearing which weak religious minds tremble in sheer terror."
                    "This 'Aham Brahmasmi' violently drags a human from the status of a pathetic insect and explicitly mutates him into the Absolute Master of the cosmos!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 5,
                sanskrit = "तत्त्वमसि... अयमात्मा ब्रह्म... इति चतुष्टयम् ॥ ५॥",
                hindi = """
                    (तीसरा और चौथा महावाक्य - संपूर्ण सत्य): "तीसरा प्रलयंकारी महावाक्य सामवेद से आता है— 'तत्त्वमसि' (तुम ही वह परब्रह्म हो)!"
                    "गुरु अपने शिष्य के सीने में ज्ञान का खंजर उतारते हुए कहता है: 'तू कोई पापी जीव नहीं, तू साक्षात वही अनंत ईश्वर है!'"
                    "तेरी औकात इस दुनिया की गुलामी करने की नहीं है; तेरे भीतर ही वह महासागर छिपा है जिससे यह दुनिया बनी है।"
                    "और चौथा महावाक्य अथर्ववेद से सबसे बड़ा धमाका करता है— 'अयमात्मा ब्रह्म' (यह आत्मा ही साक्षात परब्रह्म है)!"
                    "यह साबित करता है कि इंसान के शरीर में बैठी आत्मा कोई 'किरायेदार' नहीं है, बल्कि वह खुद इस शरीर और ब्रह्मांड की 'मालिक' है।"
                    "ये चार महावाक्य (इति चतुष्टयम्) कोई कविता नहीं हैं; ये वो चार खौफनाक न्यूक्लियर कोड (Nuclear Codes) हैं जो माया (Matrix) को भस्म कर देते हैं।"
                    "इन चारों वाक्यों का एक ही मतलब है— इंसान और ईश्वर के बीच की दूरी एक 100% झूठा और सड़ा हुआ भ्रम है।"
                    "जो इन चार महावाक्यों को अपनी साँसों में घोल लेता है, उसके लिए दुनिया के सारे मंदिर, सारी किताबें और सारे कर्मकांड राख बन जाते हैं।"
                    "उसे अब किसी बाहरी पूजा की ज़रूरत नहीं, क्योंकि वह हर पल अपनी ही आत्मा की पूजा कर रहा है।"
                    "यह इंसानियत को मिटाकर उसे पूरी तरह से 'परमेश्वर' में बदल देने का सबसे खूनी और क्रूर आध्यात्मिक विज्ञान है।"
                """.trimIndent(),
                english = """
                    (The Third and Fourth Mahavakyas - The Absolute Truth): "The third apocalyptic Mahavakya strikes from the Sama Veda—'Tat Tvam Asi' (You explicitly are That Supreme Brahman)!"
                    "The Master violently plunges the dagger of cosmic knowledge into the disciple's chest, roaring: 'You are absolutely no sinful creature; you are literally that infinite God!'"
                    "Your status is absolutely not to be a pathetic slave to this world; the exact ocean from which this universe was spawned is hidden directly inside you."
                    "And the fourth Mahavakya from the Atharva Veda detonates the final ultimate explosion—'Ayamatma Brahma' (This exact Soul is explicitly the Supreme Brahman)!"
                    "This permanently proves that the Soul sitting inside the human shell is no pathetic 'tenant', but is the absolute, undisputed 'Dictator' of this body and the cosmos."
                    "These four Mahavakyas (Iti chatushtayam) are absolutely no poetry; they are the four terrifying Nuclear Codes that completely incinerate the Matrix of Maya."
                    "All four sentences violently roar exactly one truth—the pathetic distance between human and God is a 100% fake, rotting biological hallucination."
                    "He who dissolves these four Mahavakyas into his very breath reduces every temple, every book, and every ritual on Earth to worthless ashes."
                    "He requires absolutely zero external worship, because every microsecond he is executing the absolute worship of his own Supreme Soul."
                    "This is the most bloody, ruthless spiritual science designed specifically to utterly annihilate humanity and mutate it flawlessly into 'God'!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 6,
                sanskrit = "ओमित्येकाक्षरं ब्रह्म... सोऽहमिति हंसः... ॥ ६॥",
                hindi = """
                    (ॐकार और सोऽहम् का प्रलयंकारी अस्त्र): "इन महावाक्यों को सिद्ध करने का हथियार क्या है? 'ॐ' (ओमित्येकाक्षरं ब्रह्म)!"
                    "यह ॐ कोई साधारण आवाज़ नहीं है; यह वह ब्रह्मांडीय फ्रीक्वेंसी (Frequency) है जिस पर ईश्वर का दिमाग काम करता है।"
                    "योगी जब इस 'एक अक्षर' वाले ॐ को अपनी आत्मा में धधकता है, तो उसके शरीर की एक-एक कोशिका (Cell) बम की तरह फटने लगती है।"
                    "और इसके साथ चलता है 'सोऽहम्' (हंसः) का खौफनाक मंत्र— 'सः' (वह परब्रह्म) 'अहम्' (मैं ही हूँ)!"
                    "हर साँस अंदर लेते हुए योगी कहता है 'वह' (सः), और साँस छोड़ते हुए कहता है 'मैं हूँ' (अहम्)।"
                    "साँसों की इस भयानक और क्रूर रगड़ से वह अपने ही मन का गला घोंट देता है।"
                    "दिन-रात, सोते-जागते, हर सेकंड उसके भीतर यही एक युद्ध चल रहा होता है— 'मैं ही वह भगवान हूँ!'"
                    "धीरे-धीरे इंसान का यह 'मैं' (Ego) पूरी तरह से जलकर राख हो जाता है और केवल वह असीम 'हंस' (परमात्मा) ही शेष बचता है।"
                    "यह वह अवस्था है जहाँ योगी की साँसें हवा नहीं खींचतीं, बल्कि पूरे ब्रह्मांड को अपने भीतर खींच लेती हैं।"
                    "जब ॐ और सोऽहम् आपस में टकराते हैं, तो अज्ञान की मौत निश्चित है और इंसान का भगवान बनना अटल है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Weapon of OM and So'ham): "What is the supreme weapon to execute these Mahavakyas? 'OM' (Omityekaksharam Brahma)!"
                    "This OM is absolutely no ordinary acoustic sound; it is the exact, terrifying cosmic frequency upon which the brain of God operates."
                    "When the Yogi blazes this 'One-Syllable' OM strictly within his Soul, every single biological cell in his body begins to detonate like a bomb."
                    "And alongside it runs the terrifying, lethal mantra of 'So-Ham' (Hamsah)—'Sah' (That Supreme Brahman) 'Aham' (I myself am)!"
                    "With every single breath inhaled, the Yogi violently asserts 'That' (Sah), and exhaling, he mercilessly roars 'I Am' (Aham)."
                    "Through this horrific, brutal friction of his own physical breath, he literally strangles his pathetic biological mind to death."
                    "Day and night, waking or sleeping, every microsecond only one violent war rages inside him—'I myself am explicitly that God!'"
                    "Gradually, this pathetic human 'I' (Ego) is completely incinerated to ashes, leaving strictly and exclusively that infinite 'Hamsa' (Supreme God) behind."
                    "This is the dimension where the Yogi's breath no longer pulls in mere air, but violently sucks the entire infinite cosmos into his core."
                    "When OM and So'ham collide catastrophically, the brutal death of ignorance is guaranteed, and the mutation of the human into God is absolutely irreversible!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 7,
                sanskrit = "मनोनाशो महामोहविनाशः... तदेव परमं पदम् ॥ ७॥",
                hindi = """
                    (मन की क्रूर मौत और परम शून्यता): "यह उपनिषद सबसे भयानक आदेश देता है: 'मनोनाशो'— अपने ही मन का क्रूरता से वध कर दो!"
                    "ईश्वर तुम्हें तब तक नहीं मिलेगा जब तक तुम्हारा यह 'मन' (Mind) ज़िंदा है, क्योंकि मन ही इस दुनिया की सारी माया (Matrix) बनाता है।"
                    "जब तुम ध्यान की कुल्हाड़ी से इस मन के टुकड़े-टुकड़े कर देते हो, तभी 'महामोहविनाशः' (सबसे बड़े सांसारिक मोह का विनाश) होता है।"
                    "विचारों का मरना ही मोक्ष की सबसे पहली और आखिरी शर्त है; जहाँ विचार हैं, वहाँ भगवान नहीं हो सकता।"
                    "जब तुम्हारा दिमाग पूरी तरह से 'सुन्न' (Flatline) हो जाता है, जब सोचने के लिए एक भी शब्द नहीं बचता..."
                    "तब जो भयानक, असीम और मौत जैसा 'सन्नाटा' (Silence) पीछे बचता है— 'तदेव परमं पदम्' (वही सन्नाटा ही ब्रह्मांड का सबसे ऊँचा और परम स्थान है)!"
                    "वह सन्नाटा खालीपन नहीं है; वह सन्नाटा ही वह साक्षात परब्रह्म है जिससे यह पूरी दुनिया पैदा हुई है।"
                    "अपने ही दिमाग को मार डालना इंसान का सबसे खौफनाक और आत्मघाती कदम है, जिससे कायर लोग काँपते हैं।"
                    "लेकिन जो शूरवीर अपने मन की बलि चढ़ा देता है, वह मौत के चंगुल से हमेशा के लिए बाहर निकल जाता है।"
                    "मन की मौत ही इंसान की जीत है, और यही महावाक्यों का सबसे आखिरी और प्रलयंकारी परिणाम है!"
                """.trimIndent(),
                english = """
                    (The Brutal Slaughter of the Mind and the Supreme Void): "This Upanishad issues the most terrifying, blood-curdling command: 'Manonasho'—Execute the brutal, ruthless slaughter of your own Mind!"
                    "God is absolutely inaccessible to you as long as this pathetic 'Mind' is alive, because the mind itself fabricates the entire Matrix (Maya) of this world."
                    "Only when you hack this mind into bloody pieces with the axe of meditation does 'Mahamoha-vinashah' (The absolute annihilation of the greatest worldly delusion) detonate."
                    "The violent death of thoughts is the absolute first and final condition for Moksha; where pathetic thoughts exist, God absolutely cannot."
                    "When your biological brain completely 'Flatlines', when not a single microscopic word survives to be thought..."
                    "Then the horrific, infinite, death-like 'Deafening Silence' that remains behind—'Tadeva paramam padam' (That exact silence is the highest, ultimate absolute destination of the cosmos)!"
                    "That silence is absolutely not emptiness; that exact silence is the explicit Supreme Brahman from which this entire universe was violently spawned."
                    "Assassinating your own biological brain is the most terrifying, suicidal leap of a human, causing cowards to tremble in sheer terror."
                    "But the supreme Titan who sacrifices his mind permanently escapes the suffocating jaws of Death forever."
                    "The death of the mind is the absolute victory of the human, and this is the ultimate, apocalyptic final result of the Mahavakyas!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 8,
                sanskrit = "जाग्रत्स्वप्नसुषुप्त्यादि... तुरीयं परमं पदम्... ॥ ८॥",
                hindi = """
                    (तीनों अवस्थाओं का विनाश और तुरीय की छलांग): "इंसान अपनी पूरी ज़िंदगी केवल तीन खौफनाक जेलों में सड़ा करता है— 'जाग्रत' (जागना), 'स्वप्न' (सपने देखना), और 'सुषुप्ति' (गहरी नींद)।"
                    "जब तुम जागते हो, तो तुम इस झूठी दुनिया के गुलाम होते हो; जब तुम सपने देखते हो, तो तुम अपने ही दिमाग के गुलाम होते हो।"
                    "और जब तुम गहरी नींद में होते हो, तो तुम एक ज़िंदा लाश की तरह अँधेरे में पड़े रहते हो।"
                    "योगी इन तीनों सड़ी हुई अवस्थाओं (States of Consciousness) को लात मारकर चीर देता है!"
                    "वह इन तीनों के पार उस चौथी और सबसे खौफनाक अवस्था में छलांग लगाता है जिसे 'तुरीयं परमं पदम्' (तुरीय अवस्था) कहते हैं।"
                    "यह वह अवस्था है जहाँ इंसान न तो जाग रहा है, न सो रहा है, और न ही सपने देख रहा है..."
                    "वह पूरी तरह से 'परम चेतना' (Absolute Radioactive Awareness) बन चुका है, जहाँ यह पूरा ब्रह्मांड एक धूल के कण जैसा लगता है।"
                    "तुरीय कोई अवस्था नहीं है; तुरीय ही साक्षात वह 'परमेश्वर' है जो इन तीनों अवस्थाओं का तमाशा देख रहा है।"
                    "जिसने इस तुरीय को भेद लिया, उसने समय (Time) और अंतरिक्ष (Space) की छाती पर अपना झंडा गाड़ दिया है।"
                    "वह अब इंसान नहीं रहा; वह उस महा-शून्यता का इकलौता तानाशाह बन चुका है जहाँ मौत का भी दम घुटता है!"
                """.trimIndent(),
                english = """
                    (The Annihilation of the Three States and the Leap into Turiya): "A mortal human rots his entire pathetic life strictly inside three terrifying maximum-security prisons—'Jagrat' (Waking), 'Svapna' (Dreaming), and 'Sushupti' (Deep Sleep)."
                    "When you are awake, you are a pathetic slave to this fake world; when you dream, you are a hostage to your own biological brain."
                    "And when you are in deep sleep, you lie paralyzed in the dark exactly like a rotting, living corpse."
                    "The Yogi violently kicks and tears through all three of these rotting, biological 'States of Consciousness'!"
                    "He leaps brutally beyond these three into the fourth and most terrifying absolute dimension known as 'Turiyam paramam padam' (The State of Turiya)."
                    "This is the precise dimension where the human is absolutely neither awake, nor sleeping, nor hallucinating dreams..."
                    "He has mutated flawlessly into 'Absolute Radioactive Awareness', where this entire infinite cosmos appears as a pathetic micro-particle of dust."
                    "Turiya is absolutely no state; Turiya is explicitly the 'Supreme God' Himself who acts as the silent, terrifying Witness to the drama of the other three states."
                    "He who successfully breaches this Turiya has violently planted his flag directly into the chest of Time and Space."
                    "He is no longer a human; he has mutated into the sole dictator of that Supreme Void where even Death suffocates and dies!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 9,
                sanskrit = "अरूपमगुणमस्पर्शम्... तद्ब्रह्मैवाहमस्मीति... ॥ ९॥",
                hindi = """
                    (परब्रह्म की खौफनाक परिभाषा और अद्वैत गर्जना): "जब योगी तुरीय में पहुँचता है, तो वह जिस भगवान से मिलता है, वह कोई इंसान जैसा दिखने वाला रूप नहीं है।"
                    "उपनिषद उस परम सत्य की सबसे खौफनाक परिभाषा देता है: 'अरूपम्' (उसका कोई रूप, कोई शक्ल नहीं है)!"
                    "'अगुणम्' (उसमें दुनिया का कोई गुण, कोई जज़्बात या कोई दया-माया नहीं है)!"
                    "'अस्पर्शम्' (उसे दुनिया की कोई ताक़त छू नहीं सकती, वह हर भौतिक चीज़ के पार एक असीम ऊर्जा है)!"
                    "वह इतना विशाल और इतना सूक्ष्म है कि इंसान का दिमाग उसे समझने की कोशिश में ही फट जाएगा।"
                    "लेकिन योगी डरता नहीं है; वह उस असीम, निर्गुण और भयानक सन्नाटे में खुद को पूरी तरह से विसर्जित (Merge) कर देता है।"
                    "और फिर वह अपनी आत्मा से अंतिम और सबसे प्रलयंकारी गर्जना करता है: 'तद्ब्रह्मैवाहमस्मीति'!"
                    "यानी, 'वह अरूप, अगुण और असीम परब्रह्म कोई और नहीं... केवल और केवल मैं ही हूँ!'"
                    "इस एक पल में, एक छोटे से इंसान की हस्ती मिट जाती है और वह साक्षात उस ऊर्जा में बदल जाता है जो ब्रह्मांड को बनाती और बिगाड़ती है।"
                    "द्वैत (Duality) की दीवार हमेशा के लिए चकनाचूर हो जाती है; अब न कोई पूज्य है और न कोई पुजारी—केवल एक अद्वैत सत्य!"
                """.trimIndent(),
                english = """
                    (The Terrifying Definition of Brahman and the Non-Dual Roar): "When the Yogi violently breaches Turiya, the God he collides with is absolutely no human-looking, pathetic entity."
                    "The Upanishad delivers the most horrific definition of that Absolute Truth: 'Arupam' (It possesses absolutely zero form, zero face, zero shape)!"
                    "'Agunam' (It possesses zero worldly attributes, zero biological emotions, and zero pathetic human mercy)!"
                    "'Asparsham' (Absolutely no force in existence can touch it; it is an infinite, radioactive energy transcending all physical matter)!"
                    "It is so colossally vast and terrifyingly microscopic that a human brain would literally explode attempting to process it."
                    "But the Yogi absolutely does not fear; he violently and completely submerges and dissolves himself entirely into that infinite, formless, terrifying silence."
                    "And then he unleashes the final, most apocalyptic roar from his core: 'Tad-brahmaivahamasmiti'!"
                    "Meaning, 'That formless, attributeless, and infinite Supreme Brahman is absolutely no one else... It is explicitly and exclusively ME alone!'"
                    "In this exact microsecond, the pathetic existence of a tiny human is violently erased, and he mutates into the precise primordial energy that spawns and destroys universes."
                    "The wall of Duality is permanently, catastrophically shattered to dust; there is no longer a worshipped nor a worshiper—strictly only One Non-Dual Absolute Truth!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 10,
                sanskrit = "एवं च पश्यतो योगिनः... न मृत्युर्न च सङ्कटम् ॥ १०॥",
                hindi = """
                    (मृत्यु का वध और योगी की अजेयता): "जो महायोगी इस प्रलयंकारी सत्य को साक्षात 'देख' लेता है (एवं च पश्यतो योगिनः)..."
                    "जिसने यह जान लिया कि वह शरीर नहीं बल्कि वह असीम परमेश्वर है, उसकी ज़िंदगी में सबसे खौफनाक बदलाव आता है।"
                    "उपनिषद चीख कर कहता है: 'न मृत्युर्'— उस योगी के लिए 'मौत' नाम की चीज़ हमेशा-हमेशा के लिए ख़त्म हो जाती है!"
                    "जब वह शरीर है ही नहीं, तो मौत किसे मारेगी? मौत खुद उसके सामने घुटने टेककर काँपने लगती है।"
                    "'न च सङ्कटम्'— दुनिया का कोई भी भयंकर से भयंकर दुख, संकट या बर्बादी उसे खरोंच तक नहीं मार सकती!"
                    "पूरी पृथ्वी नष्ट हो जाए, आसमान फट पड़े, लेकिन वह योगी एक पत्थर की तरह पूरी तरह से सुन्न और अजेय रहता है।"
                    "वह दुनिया में चलते-फिरते एक 'ज़िंदा भूत' या साक्षात भगवान की तरह रहता है, जिसे किसी चीज़ से कोई फर्क नहीं पड़ता।"
                    "उसे कोई बीमारी नहीं सता सकती, कोई इंसान उसे डरा नहीं सकता, कोई लालच उसे खरीद नहीं सकता।"
                    "वह इंसानियत की हर कमजोरी का क्रूरता से वध करके ब्रह्मांड के सबसे ऊँचे और सबसे खतरनाक सिंहासन पर बैठ चुका है।"
                    "यही असली योग की ताक़त है— इंसान को मौत के चंगुल से निकालकर अमर और अजेय 'टाइटन' (Titan) बना देना!"
                """.trimIndent(),
                english = """
                    (The Slaughter of Death and the Invincibility of the Yogi): "The colossal Yogi who explicitly and directly 'Witnesses' this apocalyptic truth in absolute reality (Evam cha pashyato yoginah)..."
                    "He who has flawlessly realized that he is absolutely not biological flesh but the infinite Supreme God, undergoes the most terrifying mutation in existence."
                    "The Upanishad violently screams: 'Na Mrityur'—For that exact Yogi, the pathetic concept called 'Death' is permanently, totally annihilated forever!"
                    "When he is fundamentally not the physical body, who exactly will Death kill? Death itself falls to its knees and trembles violently before him."
                    "'Na cha sankatam'—Absolutely no catastrophic crisis, agony, or horrific destruction in the universe can ever manage to even scratch him!"
                    "Even if the entire Earth detonates and the sky rips apart, that Yogi remains as completely numb, emotionless, and invincible as a cosmic monolith."
                    "He roams the earth exactly like a 'Living Ghost' or a walking literal God, flawlessly unaffected by absolutely everything."
                    "No biological disease can torture him, no mortal possesses the capability to terrify him, and zero worldly greed can ever buy him."
                    "Having brutally slaughtered every single human weakness, he has marched up and occupied the highest, most dangerous throne in the universe."
                    "This is the terrifying, radioactive power of true Yoga—violently dragging a human out of the jaws of Death and mutating him into an immortal, invincible Titan!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 11,
                sanskrit = "दहत्यविद्यामखिलाम्... ज्ञानाग्निः सर्वकर्मणि ॥ ११॥",
                hindi = """
                    (ज्ञान की प्रलयंकारी आग और कर्मों की राख): "यह श्लोक उस योगी के भीतर धधकने वाली उस आग का वर्णन करता है जो सब कुछ जला डालती है।"
                    "जब 'अहं ब्रह्मास्मि' का यह महा-ज्ञान पैदा होता है, तो यह कोई साधारण रोशनी नहीं, बल्कि एक खौफनाक ब्रह्मांडीय 'ज्ञान की आग' (ज्ञानाग्निः) होती है!"
                    "यह आग 'दहत्यविद्यामखिलाम्'— जन्मों-जन्मों की अविद्या, अज्ञान, मोह और माया को एक सेकंड में जलाकर खाक (दहति) कर देती है।"
                    "इंसान के दिमाग में फँसे हुए करोड़ों जन्मों के संस्कार, डर और इच्छाएं एक ही धमाके में भस्म हो जाते हैं।"
                    "और सबसे बड़ी बात— 'सर्वकर्मणि'— इस शरीर ने पिछले करोड़ों जन्मों में जो भी अच्छे (पुण्य) या बुरे (पाप) 'कर्म' किए हैं..."
                    "वह ज्ञान की आग उन सारे कर्मों के पहाड़ों को एक पल में जलाकर राख कर देती है; इंसान का सारा हिसाब (Record) शून्य हो जाता है!"
                    "बिना कर्मों के जले कोई इंसान इस माया की जेल (Matrix) से बाहर नहीं निकल सकता।"
                    "यह आग इंसान की पुरानी पहचान का इतनी बेरहमी से कत्ल करती है कि उसका कोई नाम या निशान नहीं बचता।"
                    "उस धधकती हुई राख से जो चीज़ बाहर आती है, वह इंसान नहीं होता—वह साक्षात वह शिव होता है जो चिता की भस्म से लिपटा है।"
                    "ज्ञान कोई किताब पढ़ना नहीं है; ज्ञान वो न्यूक्लियर आग है जो तुम्हारी पूरी हस्ती को जलाकर तुम्हें भगवान बनाती है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Fire of Knowledge and the Ashes of Karma): "This Shloka describes the radioactive, terrifying inferno blazing inside that Yogi which incinerates absolutely everything."
                    "When this colossal realization of 'Aham Brahmasmi' detonates, it is no pathetic gentle light; it is a horrific, cosmic 'Fire of Absolute Knowledge' (Jnanagnih)!"
                    "This apocalyptic fire 'Dahatyavidyamakhilam'—violently and instantaneously burns down billions of lifetimes of ignorance, delusion, and the Matrix (Maya) into absolute ashes (Dahati)."
                    "The conditioning, fears, and biological lusts infected in the human brain over millions of births are incinerated to dust in a single microsecond."
                    "And the most terrifying strike—'Sarvakarmani'—whatever good (Merit) or horrific (Sin) 'Karmas' this entity accumulated over billions of past incarnations..."
                    "That radioactive fire of Knowledge instantaneously burns those entire mountains of Karma to absolute zero; the human's entire cosmic record is permanently erased!"
                    "Without the brutal incineration of all Karma, absolutely no human can ever breach and escape this maximum-security prison of Maya."
                    "This fire so ruthlessly slaughters the human's past identity that absolutely zero name or biological trace survives."
                    "The entity that walks out of that blazing ash is absolutely not a human—it is explicitly Shiva Himself, smeared in the absolute ashes of the funeral pyre."
                    "Knowledge is absolutely not reading pathetic books; Knowledge is that nuclear inferno that violently burns your entire existence to mutate you into God!"
                """.trimIndent()
            ),
            MahavakyaShloka(
                id = 12,
                sanskrit = "स मुक्तो भवति स मुक्तो भवतीत्युपनिषत् ॥ १२॥",
                hindi = """
                    (मोक्ष की सबसे खौफनाक और अंतिम गारंटी - 'द एंड'): "उपनिषद अपने इस ब्रह्मांडीय ज्ञान रुपी परमाणु बम को सबसे निर्णायक मुहर के साथ समाप्त करता है।"
                    "जिस इंसान ने इस 'महावाक्य' को अपनी साँसों में उतारकर अपने अहंकार की गर्दन काट दी है..."
                    "जिसने अपनी चेतना को उस 'परम शून्यता' में इस तरह विस्फोट कर दिया है कि उसका 'मैं' हमेशा के लिए मर चुका है..."
                    "वह इंसान निश्चित रूप से, पूरे ब्रह्मांड की 100% अटल गारंटी के साथ, जन्म, मृत्यु, और कर्मों के इस सड़े हुए जाल से हमेशा के लिए पूरी तरह 'मुक्त' हो जाता है!"
                    "श्रुति (वेद) पूरी ताक़त से चीखकर इस बात को दो बार दोहराती है— 'स मुक्तो भवति, स मुक्तो भवति' (हाँ! वह हमेशा के लिए आज़ाद हो जाता है!)"
                    "उसे दोबारा कभी इस दुनिया के कीचड़ में, किसी माँ के गर्भ में उल्टा लटकने का दर्दनाक और घिनौना मज़ाक नहीं सहना पड़ेगा।"
                    "वह समय (Time), स्थान (Space) और मौत (Death) की हदों को चीरकर उस असीम शून्यता में हमेशा-हमेशा के लिए एक परमेश्वर की तरह विलीन हो जाता है।"
                    "यहीं पर यह अत्यंत महान, रौंगटे खड़े कर देने वाला और परम पवित्र 'महावाक्य उपनिषद' अपनी पूरी प्रलयंकारी महिमा के साथ संपन्न होता है (इत्युपनिषत्)।"
                    "यह ग्रंथ ऐलान करता है कि मोक्ष कोई भीख नहीं है; यह मौत की आँखों में आँखें डालकर उसे हराने का क्रूर विज्ञान है।"
                    "जब इंसान मिटता है, तब भगवान का जन्म होता है। यही सनातन धर्म की सबसे महान और आखिरी आज़ादी है! ॐ शांतिः शांतिः शांतिः!"
                """.trimIndent(),
                english = """
                    (The Most Terrifying and Final Guarantee of Moksha - 'The End'): "The Upanishad violently detonates this atomic bomb of cosmic wisdom with its most decisive, ironclad seal."
                    "The human who has injected this 'Mahavakya' into his very breath and brutally decapitated his own pathetic ego..."
                    "He who has detonated his raw consciousness into that 'Supreme Void' so violently that his human 'I' is permanently, ruthlessly dead..."
                    "That exact human being undoubtedly, with a 100% absolute cosmic guarantee, becomes flawlessly, permanently 'Liberated' from this rotting web of birth, death, and karma forever!"
                    "The Shruti (Vedas) screams with maximum apocalyptic authority, violently repeating it twice—'Sa Mukto Bhavati, Sa Mukto Bhavati' (Yes! He undeniably becomes liberated forever!)"
                    "He will absolutely never again have to suffer the agonizing, disgusting torture of hanging upside down in a biological mother's womb in the mud of this world."
                    "Violently tearing through the pathetic limits of Time, Space, and Death, he dissolves permanently into that Infinite Void exactly as the Supreme God."
                    "Right exactly here, this majestic, spine-chilling, and profoundly sacred 'Mahavakya Upanishad' achieves its absolute, apocalyptic completion (Ityupanishat)."
                    "This scripture roars the ultimate declaration: Moksha is absolutely no pathetic charity; it is the ruthless science of staring directly into Death's eyes and violently defeating it."
                    "When the human is utterly erased, God is flawlessly born. This is Sanatana Dharma's most magnificent and absolute final freedom! OM Peace, Peace, Peace!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MahavakyaUpanishadScreen() {
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
            itemsIndexed(MahavakyaUpanishad.mahavakyaShlokasList) { _, shloka ->
                MahavakyaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun MahavakyaShlokaCard(shloka: MahavakyaUpanishad.MahavakyaShloka) {
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