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
data class ParamahamsaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

val paramahamsaShlokasList = listOf(
    ParamahamsaShloka(
        id = 1,
        sanskrit = "ॐ पूर्णमदः पूर्णमिदं पूर्णात्पूर्णमुदच्यते । पूर्णस्य पूर्णमादाय पूर्णमेवावशिष्यते ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
        hindi = """
            (शांति मंत्र और ब्रह्मांड का परम रहस्य): यह कोई साधारण मंत्र नहीं, बल्कि सनातन धर्म के अध्यात्म का सबसे प्रलयंकारी गणित है।
            "वह परब्रह्म (निराकार ईश्वर) पूरी तरह से 'पूर्ण' (Infinite/Limitless) है।"
            "और यह दृश्यमान, असीम ब्रह्मांड भी उसी पूर्ण से प्रकट होने के कारण अपने आप में पूरी तरह 'पूर्ण' ही है।"
            "उस परम पूर्ण (भगवान) में से इस पूरे ब्रह्मांड को निकाल लेने पर भी ईश्वर में कोई कमी नहीं आती।"
            "पूर्ण में से पूर्ण को घटाने के बाद भी, जो शेष बचता है, वह भी पूरी तरह से असीम और 'पूर्ण' ही रहता है।"
            यह साबित करता है कि ईश्वर को न तो बाँटा जा सकता है, न घटाया जा सकता है, और न ही उसके टुकड़े किए जा सकते हैं।
            हर इंसान, हर जीव भीतर से कोई टुकड़ा नहीं, बल्कि साक्षात वह संपूर्ण और अनंत 'ईश्वर' ही है।
            इंसान का यह सोचना कि "मैं छोटा हूँ या अधूरा हूँ", ही दुनिया का सबसे बड़ा झूठ और माया है।
            जब यह 'अहंकार' मरता है, तब इंसान को अपनी असीम पूर्णता का महा-ज्ञान प्राप्त होता है।
            ॐ! मेरे शरीर, मन और आत्मा के त्रिविध तापों (शारीरिक, दैविक, भौतिक दुखों) की हमेशा के लिए परम शांति हो!
        """.trimIndent(),
        english = """
            (The Peace Invocation and the Absolute Cosmic Secret): This is no ordinary chant; it is the most earth-shattering mathematics of Sanatana Dharma's spirituality.
            "That Supreme Brahman (the formless God) is absolutely, boundlessly, and infinitely 'Complete' (Purna)."
            "And this visible, colossal universe, having manifested directly from that Infinite, is also perfectly 'Complete'."
            "Even after flawlessly extracting this infinite universe from that Supreme Infinite, God suffers absolutely zero reduction."
            "Subtracting the infinite from the infinite leaves behind a remainder that is undeniably the Absolute Infinite alone."
            This proves permanently that God can never be divided, subtracted, or shattered into fragmented pieces.
            Every human, every soul inside is not a tiny fragment, but literally the total, infinite, and complete 'God' Himself.
            The human delusion of thinking "I am small or incomplete" is the greatest lie and illusion (Maya) in existence.
            Exactly when this pathetic 'Ego' dies, the human violently awakens to his colossal, infinite completeness.
            OM! May there be the absolute, permanent cessation and peace from the three terrifying worldly miseries!
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 2,
        sanskrit = "अथ योगिनां परमहंसानां कोऽयं मार्गस्तेषां का स्थितिरिति नारदो भगवन्तमुपसमेत्योवाच । तं भगवानाह ।",
        hindi = """
            (परमहंस रहस्य की खोज): जब तक इंसान दुनियादारी में फँसा रहता है, वह कभी परम सत्य को नहीं जान पाता।
            इसीलिए देवताओं के ऋषि, स्वयं देवर्षि नारद ने सीधे साक्षात् सृष्टिकर्ता भगवान ब्रह्मा के पास जाकर यह अत्यंत गूढ़ प्रश्न पूछा।
            उन्होंने पूछा: "हे ब्रह्मांड के रचयिता! उन सर्वश्रेष्ठ और सबसे रहस्यमयी 'परमहंस' योगियों का वास्तविक मार्ग क्या है?"
            "वह कौन सा खौफनाक और कठोर रास्ता है जिस पर चलकर एक साधारण इंसान साक्षात भगवान बन जाता है?"
            "और जब वह सब कुछ त्याग देता है, तो उसकी वह अंतिम, सर्वोच्च मानसिक और आध्यात्मिक 'स्थिति' (State of Mind) कैसी होती है?"
            क्या वह पागलों की तरह जीता है, या उसे पूरे ब्रह्मांड का नियंत्रण मिल जाता है?
            एक संन्यासी के मन के भीतर असल में क्या चलता है, यह जानने की भयंकर प्यास नारद के शब्दों में थी।
            यह कोई आम सवाल नहीं था, यह उस परम आज़ादी (मोक्ष) का रहस्य पूछने का दुस्साहस था जिससे मृत्यु भी डरती है।
            तब भगवान ब्रह्मा ने मंद-मंद मुस्कुराते हुए उन्हें वह परम ज्ञान (Secret of the Highest Monks) देना शुरू किया।
            ब्रह्मा जी ने जो उत्तर दिया, वह इंसानियत के इतिहास का सबसे बड़ा और सबसे प्रलयंकारी सत्य है।
        """.trimIndent(),
        english = """
            (The Quest for the Paramahamsa Secret): As long as a human is trapped in worldly illusions, he can never fathom the absolute truth.
            Therefore, the divine sage Narada directly and boldly approached the Creator, Lord Brahma, and intensely asked this profound question.
            He asked: "O Creator of the cosmos! What exactly is the true, absolute, and highly secretive path of those supreme 'Paramahamsa' Yogis?"
            "What is that terrifyingly harsh and ruthless path by which an ordinary human literally transforms into God?"
            "And when he violently renounces absolutely everything, what exactly is his ultimate, highest mental and spiritual 'State' of existence?"
            Does he live like a madman, or does he gain the absolute undisputed control over the entire universe?
            A fierce, burning thirst to know what actually runs inside the brain of a supreme monk echoed in Narada's words.
            This was no ordinary question; it was the audacity to demand the cosmic secret of ultimate freedom (Moksha) that even Death fears.
            To this, the Supreme Lord Brahma, with a gentle divine smile, began imparting the ultimate absolute wisdom.
            The answer Lord Brahma delivered remains the most colossal, earth-shattering absolute truth in the history of humanity.
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 3,
        sanskrit = "योऽयं परमहंसमार्गो लोके दुर्लभतरो न तु बाहुल्यो यद्येको भवति स एव नित्यपूतस्थः स एव वेदपुरुष इति विदुषो मन्यन्ते महापुरुषो यच्चित्तं तत्सर्वदा मय्येवावतिष्ठते तस्मादहं च तस्मिन्नेवावस्थीयते ।",
        hindi = """
            (परमहंस की भयंकर दुर्लभता): ब्रह्मा जी ने गर्जना करते हुए कहा - "हे नारद! इस संसार में यह परमहंस मार्ग अत्यंत, भयंकर रूप से दुर्लभ है।"
            "ऐसे महायोगी बाजारों या भीड़ में नहीं मिलते (न तु बाहुल्यो), यह कोई आम रास्ता नहीं है जिस पर हर कोई चल सके।"
            "अरबों-खरबों की आबादी में यदि कोई एक भी ऐसा महापुरुष पैदा हो जाए, तो समझो पृथ्वी धन्य हो गई।"
            "वह अकेला ही हमेशा के लिए नित्य पवित्र है; उसके छूने भर से तीर्थ स्थान भी पवित्र हो जाते हैं।"
            "स्वयं सर्वोच्च ज्ञानी जन उसे साक्षात् 'वेद-पुरुष' (वेदों का चलता-फिरता, जीवित स्वरूप) मानते हैं।"
            "उस महापुरुष का चित्त (Mind) दुनिया के कचरे से पूरी तरह कटकर हमेशा केवल मुझ परब्रह्म में ही डूबा रहता है।"
            "उसका 'छोटा मैं' (Ego) पूरी तरह से मर चुका होता है, और उसके अंदर केवल परम शून्यता और मेरा वास होता है।"
            "और इसीलिए, क्योंकि वह मुझमें रहता है, मैं (स्वयं ईश्वर) भी हमेशा उसी के हृदय में साक्षात निवास करता हूँ।"
            "वह अब कोई साधारण हाड़-मांस का इंसान नहीं रहा; वह ब्रह्मांड को चलाने वाली शक्ति से एकाकार हो चुका है।"
            "सच्चा परमहंस कोई और नहीं, बल्कि धरती पर चलता-फिरता साक्षात भगवान ही बन जाता है!"
        """.trimIndent(),
        english = """
            (The Terrifying Rarity of the Paramahamsa): Lord Brahma roared - "O Narada! This specific path of the Paramahamsa is terrifyingly, extraordinarily rare in this world."
            "Such absolute master Yogis are never found wandering in common crowds or markets; this is no ordinary path for the weak."
            "If among billions and trillions of humans, even one such colossal soul is born, consider the Earth utterly blessed."
            "He alone is eternally, perfectly pure; even the holiest pilgrimage sites become purified merely by his physical touch."
            "The truly wise and enlightened masters explicitly recognize him as the living, breathing 'Veda-Purusha' (the physical manifestation of the scriptures)."
            "That colossal soul's mind is violently severed from all worldly garbage and remains violently anchored strictly in Me (The Supreme Brahman)."
            "His 'tiny ego' has brutally starved to death, leaving behind only absolute cosmic void and My presence."
            "And precisely because his mind is absorbed in Me, I (God Himself) permanently and directly reside exactly within his heart."
            "He is no longer a pathetic human made of flesh and bone; he has flawlessly fused with the supreme power operating the cosmos."
            "The true Paramahamsa is nothing else but a literal, walking God manifested on this physical Earth!"
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 4,
        sanskrit = "असौ स्वपुत्रमित्रकलत्रबन्ध्वादीञ्छिखायज्ञोपवीते स्वाध्यायं च सर्वकर्माणि संन्यस्यायं ब्रह्माण्डं च हित्वा कौपीनं दण्डमाच्छादनं च स्वशरीरोपभोगार्थाय लोकस्योपकारार्थाय च परिग्रहेत् । तच्च न मुख्योऽस्ति कोऽयं मुख्य इति चेदयं मुख्यः ॥ १॥",
        hindi = """
            (प्रारंभिक संन्यास का प्रहार): "ऐसा योगी सबसे पहले अपने पुत्र, मित्र, पत्नी और बंधु-बांधवों की झूठी मोह-माया को निर्ममता से काट फेंकता है।"
            "रिश्तों की बेड़ियों को तोड़ने के बाद, वह धर्म के बाहरी प्रतीकों— अपनी शिखा (चोटी) और यज्ञोपवीत (जनेऊ) को भी उखाड़ फेंकता है।"
            "वह वेद-पाठ, स्वाध्याय, कर्मकांड और दुनिया के सभी सांसारिक कर्मों का पूरी तरह से, भयंकर रूप से संन्यास कर लेता है।"
            "वह इस पूरे ब्रह्मांड और इसके झूठे आकर्षणों को एक सड़े हुए तिनके की तरह लात मारकर छोड़ देता है।"
            "वह अपने पास कुछ नहीं रखता, केवल शरीर की लाज ढंकने के लिए एक लंगोट (कौपीन), हाथ में एक दण्ड और ओढ़ने के लिए एक वस्त्र।"
            "यह सब भी वह केवल इसलिए रखता है ताकि यह भौतिक शरीर ज़िंदा रहे और वह अपने ज्ञान से दुनिया का कल्याण कर सके।"
            "उसकी कोई निजी संपत्ति, कोई घर, कोई बैंक बैलेंस या पहचान नहीं होती। वह दुनिया की नज़रों में मिट चुका होता है।"
            "लेकिन सावधान! ब्रह्मा जी कहते हैं कि यह सब तो केवल बाहरी वेशभूषा है, यह संन्यास की 'मुख्य' (सर्वोच्च) स्थिति नहीं है।"
            "बाहर से कपड़े छोड़ देना काफी नहीं है। यदि कोई पूछे कि फिर असली और मुख्य स्थिति क्या है?"
            "तो ब्रह्मांड के उस सबसे गहरे और खौफनाक रहस्य को अब ध्यान से सुनो:"
        """.trimIndent(),
        english = """
            (The Brutal Strike of Initial Renunciation): "Such a Yogi first ruthlessly and violently severs the fake illusions of ties with his children, friends, wife, and relatives."
            "After shattering the chains of relationships, he violently discards even the external symbols of religion—his tuft of hair and his sacred thread."
            "He executes a complete, terrifying renunciation of all scriptural recitations, rituals, and absolutely all worldly, biological actions."
            "He treats the entire cosmos and its pathetic material attractions as rotting straw, kicking it all away without mercy."
            "He owns absolutely nothing, accepting strictly only a basic loincloth (Kaupina), a wooden staff, and a single ragged covering."
            "He keeps even these trivial items merely to keep his biological body breathing, and solely to radiate welfare to this suffering world."
            "He possesses zero personal property, no house, no wealth, no identity. In the eyes of the world, he is completely erased."
            "But beware! Lord Brahma warns that this is merely an external costume; this is definitively NOT the 'Primary' or highest absolute state."
            "Shedding clothes externally is utterly insufficient. If someone dares to ask, what then is the true, primary state?"
            "Then listen carefully to the deepest, most terrifying cosmic secret of absolute existence:"
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 5,
        sanskrit = "न दण्डं न शिखां न यज्ञोपवीतं न चाच्छादनं चरति परमहंसः । न शीतं न चोष्णं न सुखं न दुःखं न मानावमाने च षडूर्मिवर्जम् ।",
        hindi = """
            (असली परमहंस की खौफनाक स्वतंत्रता): "एक सच्चा और सर्वोच्च परमहंस बाहरी प्रतीकों का मोह भी छोड़ देता है; वह न तो हाथ में कोई दण्ड रखता है।"
            "उसके सिर पर कोई शिखा नहीं होती, शरीर पर कोई जनेऊ नहीं होता, यहाँ तक कि वह कपड़ों (आच्छादन) के मोह से भी आज़ाद हो जाता है।"
            "वह समाज के नियमों और शर्म से पूरी तरह मुक्त होकर एक नवजात शिशु या हवा की तरह बेपरवाह विचरता है।"
            "उसे न तो खून जमा देने वाली सर्दी सताती है, और न ही त्वचा जला देने वाली गर्मी का कोई अहसास होता है।"
            "वह दुनिया के सबसे बड़े सुख में नाचता नहीं है, और पहाड़ों जैसे दुख के टूटने पर भी उसकी आँख से एक आँसू नहीं गिरता।"
            "लोग उसे गालियां दें, पत्थर मारें (अपमान), या उसकी पूजा करें (सम्मान)—उसे इस कचरे से रत्ती भर भी फर्क नहीं पड़ता।"
            "वह इंसानियत की छह सबसे खौफनाक लहरों (षडूर्मि)— 'भूख, प्यास, शोक, मोह, शरीर का बुढ़ापा और भयानक मौत' से हमेशा के लिए मुक्त हो चुका होता है।"
            "उसकी देह भले ही दुनिया में चल रही हो, लेकिन अंदर से वह पूरी तरह से एक अजेय चट्टान बन चुका है।"
            "उसे कोई मार नहीं सकता, कोई डरा नहीं सकता, कोई खरीद नहीं सकता।"
            "वह भौतिक शरीर में रहते हुए भी साक्षात परमेश्वर (शिव) के उस परम अद्वैत स्वरूप में स्थापित हो जाता है।"
        """.trimIndent(),
        english = """
            (The Terrifying Freedom of the True Paramahamsa): "A genuine, supreme Paramahamsa abandons even the attachment to monkhood symbols; he carries absolutely no staff."
            "He wears no tuft of hair on his head, no sacred thread on his body, and is completely liberated even from the need for clothing."
            "He completely obliterates societal rules and shame, wandering with the absolute, terrifying recklessness of a newborn or the wild wind."
            "He is flawlessly and totally immune to blood-freezing cold and absolutely unfazed by flesh-scorching heat."
            "He does not dance in the world's greatest physical pleasures, nor does he shed a single tear when crushed by mountains of agony."
            "Whether people hurl brutal abuses and stones at him (disgrace) or worship him like a deity (honor)—he treats it all as literal garbage."
            "He exists perfectly untouched by humanity's six most terrifying biological waves: ravenous hunger, extreme thirst, grief, delusion, bodily decay, and death."
            "Even though his physical body walks the earth, internally he has mutated into an invincible, unbreakable cosmic mountain."
            "Absolutely nothing can kill him, nothing can terrify him, and no wealth in the universe can ever buy him."
            "While still trapped in a biological shell, he flawlessly establishes himself in the supreme, non-dual exact state of Lord Shiva Himself."
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 6,
        sanskrit = "निन्दागर्वमत्सरदम्भदर्पेच्छाद्वेषसुखदुःखकामक्रोधलोभमोहहर्षासूयाहङ्कारादींश्च हित्वा स्ववपुः कुणपमिव दृश्यते यतस्तदपध्वस्तं संशयविपरीतमिथ्याज्ञानानां यो हेतुस्तेन नित्यनिवृत्तस्तन्नित्यबोधस्तत्स्वयमेवावस्थितिस्तं शान्तमचलमद्वयानन्दविज्ञानघन एवास्मि ।",
        hindi = """
            (अहंकार की मौत और महा-ब्रह्मानुभूति): "वह योगी निंदा, अहंकार, ईर्ष्या, पाखंड, घमंड, सांसारिक इच्छाओं और दूसरों से द्वेष को जड़ से उखाड़ कर जला देता है।"
            "सुख-दुख, भयानक कामवासना, क्रोध, लोभ, मोह, क्षणिक खुशी और दूसरों की तरक्की से होने वाली जलन का वह पूरी तरह वध कर देता है।"
            "सबसे खौफनाक बात यह है कि वह अपने ही साँस लेते हुए, चलते-फिरते भौतिक शरीर को एक सड़ते हुए 'मुर्दे' (शव / कुणप) की तरह देखता है।"
            "क्योंकि उसका 'देहाध्यास' (मैं शरीर हूँ, यह भ्रम) पूरी तरह चकनाचूर हो चुका है, इसलिए वह देह के दर्द से भी कट चुका है।"
            "उसके अंदर अज्ञान और संशय पैदा करने वाले मन की मौत हो चुकी है, इसलिए वह भ्रम से नित्य मुक्त है।"
            "वह नींद में भी सोता नहीं है; वह हर पल, हर सेकंड 'नित्य बोध' (Constant Cosmic Awareness) की अवस्था में जागता रहता है।"
            "वह अपनी आत्मा में इस तरह धंस जाता है कि उसे यह प्रलयंकारी और असीम ब्रह्मांडीय गर्जना साक्षात् महसूस होती है:"
            "'मैं यह हाड़-मांस का पुतला नहीं हूँ! मैं ही वह शांत, अचल, अटल और अमर सत्य हूँ जिसे कोई मिटा नहीं सकता!'"
            "'मैं ही वह अद्वैत (जिसका कोई दूसरा नहीं), अनंत आनंद और परम चेतना (विज्ञान) का सघन महासागर हूँ!'"
            "इस महा-विस्फोट के बाद, इंसान का वजूद मिट जाता है और केवल 'ईश्वर' ही शेष रह जाता है।"
        """.trimIndent(),
        english = """
            (The Violent Death of Ego and Cosmic Realization): "That Yogi violently uproots and burns to ashes all slander, egoism, jealousy, extreme hypocrisy, arrogance, worldly desires, and hatred."
            "He executes the brutal slaughter of pleasure and pain, terrifying lust, wrath, greed, delusion, fleeting excitement, and toxic envy."
            "The most terrifying aspect is that he literally perceives his own breathing, walking physical biological body merely as a rotting, dead corpse."
            "Because his physical identification (the illusion that 'I am this body') is violently shattered, he is completely severed even from physical agony."
            "The mind that breeds doubt and false cosmic ignorance is entirely exterminated; thus, he is eternally liberated from all illusions."
            "He does not sleep even in slumber; he remains locked in a terrifying state of 'Constant Cosmic Awakening' every single microsecond."
            "He plunges so deeply into his Soul that he physically experiences this colossal, earth-shattering cosmic roar vibrating within:"
            "'I am definitely not this pathetic puppet of flesh! I am undeniably that completely tranquil, unmoving, immortal absolute truth that nothing can erase!'"
            "'I am the infinite, solid, unbreakable ocean of non-dual supreme bliss and pure cosmic consciousness!'"
            "After this atomic psychological explosion, the human completely ceases to exist, leaving strictly only 'God' behind."
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 7,
        sanskrit = "तदेव मम परमधाम तदेव शिखा च तदेवोपवीतं च । परमात्मात्मनोरेकत्वज्ञानेन तयोर्भेद एव विभग्नः सा सन्ध्या ॥ २॥",
        hindi = """
            (असली शिखा, जनेऊ और परम संध्या की महा-परिभाषा): "वह योगी घोषणा करता है कि बाहरी मंदिर या आश्रम नहीं, बल्कि वही 'परब्रह्म' ही मेरा असली और परम धाम है!"
            "वही ब्रह्म-ज्ञान ही मेरे सिर की शिखा (चोटी) है और आत्मा का वह शुद्ध बोध ही मेरा सच्चा यज्ञोपवीत (जनेऊ) है।"
            "धागे और बाल कट जाने से संन्यास नहीं होता, बल्कि मन के कट जाने से संन्यास होता है; शरीर पर पहने गए धागे उसके लिए राख के समान हैं।"
            "जब उस योगी के भीतर यह प्रलयंकारी ज्ञान परमाणु बम की तरह फटता है कि 'मेरी आत्मा और सर्वव्यापी परमात्मा बिल्कुल एक ही हैं'..."
            "तब भगवान और इंसान के बीच की दूरी, यह 'द्वैत' का भ्रम हमेशा के लिए भयानक रूप से चकनाचूर (विभग्न) हो जाता है।"
            "वह जान जाता है कि जिसे वह आसमान में खोज रहा था, वह स्वयं उसी के भीतर धड़क रहा है।"
            "जीव और शिव के बीच का यह पर्दा गिरना ही मोक्ष है।"
            "यह 'एकता का असीम अनुभव' ही उस परमहंस की सच्ची 'संध्या वंदन' (प्रार्थना) है।"
            "उसे अब किसी मूर्ति, किसी दिशा या किसी समय की मोहताज पूजा की ज़रूरत नहीं है।"
            "ब्रह्मांड की सबसे बड़ी पूजा और सबसे बड़ा कर्मकांड केवल यही अद्वैत ज्ञान है, जहाँ न कोई पूजने वाला बचता है और न कोई पूज्य।"
        """.trimIndent(),
        english = """
            (The Ultimate Definition of Tuft, Thread, and Prayer): "That Yogi fiercely declares that no external temple or ashram, but 'That Supreme Brahman alone is my absolute, ultimate abode!'"
            "'That colossal supreme realization alone is my true tuft of hair, and that pure awareness of the Soul is my authentic sacred thread.'"
            "Sannyasa is not achieved by cutting hair and threads, but by decapitating the mind; physical threads worn on the body are mere ashes to him."
            "When the apocalyptic realization explodes like an atomic bomb within him that 'My individual soul and the Supreme God are absolutely identical'..."
            "Then the pathetic illusion of separation and distance between the human and God is violently, permanently, and terrifyingly shattered into dust."
            "He realizes that the exact entity he was desperately searching for in the skies has been beating within his own chest all along."
            "The violent collapse of this curtain between the mortal creature and the immortal Creator is actual Moksha."
            "Experiencing this absolute, explosive oneness is his true, authentic, and only 'Sandhya' (twilight prayer ritual)."
            "He no longer requires any idol, any specific direction, or any time-bound worship."
            "This non-dual realization is the greatest worship and absolute ultimate ritual in the cosmos, where neither the worshiper nor the worshipped survives."
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 8,
        sanskrit = "सर्वान् कामान् परित्यज्य अद्वैते परमे स्थितिः । ज्ञानदण्डो धृतो येन एकदण्डी स उच्यते ॥ काष्ठदण्डो धृतो येन सर्वाशी ज्ञानवर्जितः । स याति नरकान् घोरान् महारौरवसंज्ञकान् ॥ इदमन्तरं ज्ञात्वा स परमहंसः ॥ ३॥",
        hindi = """
            (ज्ञान का दण्ड बनाम ढोंग का विनाशकारी परिणाम): उपनिषद यहाँ पाखंडियों पर सबसे भयानक और सीधा प्रहार करता है।
            "जिसने अपने मन की हर छोटी-बड़ी इच्छा को निर्ममता से जलाकर भस्म कर दिया है, और जो उस परम 'अद्वैत' में एक चट्टान की तरह स्थापित हो गया है..."
            "असल में उसी महायोगी ने अपने हाथ में 'ज्ञान रूपी अदृश्य दण्ड' पकड़ा है, और पूरे ब्रह्मांड में केवल वही एक सच्चा 'एकदण्डी संन्यासी' कहलाने के लायक है।"
            "लेकिन दूसरी तरफ, जो महा-पाखंडी केवल दुनिया को दिखाने के लिए हाथ में 'लकड़ी का डंडा' (काष्ठदण्ड) लेकर घूमता है..."
            "जो छुप-छुप कर दुनिया के सारे स्वादिष्ट भोजन और वासनाओं का भोग करता है (सर्वाशी), और जो असली आत्म-ज्ञान से पूरी तरह अँधा और खाली है..."
            "उपनिषद श्राप देता है कि ऐसा ढोंगी मरने के बाद 'महारौरव' नामक सबसे खौफनाक और वीभत्स नरक में सीधा गिरता है, जहाँ उसकी आत्मा चीखती है।"
            "भगवा कपड़े और डंडा मोक्ष नहीं देते, बल्कि वासनाओं की मौत मोक्ष देती है।"
            "इन दोनों (सच्चे ज्ञान और झूठे ढोंग) के बीच के इस जानलेवा और भयानक फर्क को जो इंसान अपनी रग-रग में गहराई से समझ लेता है..."
            "और जो लकड़ी के डंडे को फेंककर ज्ञान के डंडे को थाम लेता है, बस वही इंसान असली 'परमहंस' बनने की हैसियत रखता है।"
            "बाकी सब केवल धर्म के नाम पर एक भ्रम और नाटक जी रहे हैं।"
        """.trimIndent(),
        english = """
            (The Staff of Knowledge vs. The Catastrophic Result of Hypocrisy): Here, the Upanishad launches its most brutal, unforgivable strike against hypocrites.
            "He who has ruthlessly burnt every single microscopic desire to absolute ashes, and has anchored himself like an immovable cosmic mountain in the Supreme 'Non-Duality'..."
            "That master Yogi alone has truly gripped the invisible, invincible 'Staff of Absolute Knowledge', and in the entire cosmos, only he deserves to be called an authentic 'Ekadandi' monk."
            "But on the dark side, the massive hypocrite who merely carries a theatrical physical 'wooden staff' strictly for public manipulation..."
            "Who secretly and indiscriminately gorges on every worldly delicacy and sensory lust, and who is completely blind, hollow, and devoid of actual cosmic wisdom..."
            "The Upanishad curses that such a fraud violently plunges straight into the most terrifying, agonizing, and horrific hell known as 'Maharaurava', where his soul screams in torment."
            "Saffron robes and wooden sticks do not grant Moksha; only the brutal death of all lust and desire grants Moksha."
            "He who flawlessly and deeply comprehends this lethal, terrifying difference between absolute truth and fake hypocrisy in his very veins..."
            "And he who discards the wooden stick to wield the staff of cosmic knowledge—he alone possesses the terrifying caliber to become a genuine 'Paramahamsa'."
            "Everyone else is merely living a pathetic theatrical drama and illusion in the name of religion."
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 9,
        sanskrit = "आशाम्बरो न नमस्कारो न स्वाहाकारो न स्वधाकारो न निन्दा न स्तुतिर्यादृच्छिको भवेद्भिक्षुर्नावाहनं न विसर्जनं न मन्त्रं न ध्यानं न तत्त्वं न यन्त्रं न पृथगन्याश्रयं न लक्ष्यं नालक्ष्यं न पृथङ्नापृथगहं न त्वं न सर्वं चानिकेतस्थितिरेव स भिक्षुः सौवर्णादीनि नैव परिग्रहेत् न लोकं नावलोकं च ।",
        hindi = """
            (पूर्ण अवधूत की खौफनाक और असीमित अवस्था): "वह परम भिक्षु दिशाओं (आसमान) को ही अपना वस्त्र मान लेता है; वह दिगंबर होकर समाज की हर शर्म और नियम को कुचल देता है।"
            "वह इस पूरे ब्रह्मांड में किसी भी इंसान, देवता या मूर्ति के आगे अपना सिर नहीं झुकाता (न नमस्कारो), क्योंकि वह स्वयं भगवान बन चुका है।"
            "वह न तो देवताओं को आग में 'स्वाहा' कहकर आहुति देता है, और न ही मरे हुए पितरों को 'स्वधा' कहता है; उसके लिए सारे कर्मकांड जल चुके हैं।"
            "कोई उसे गालियां दे या उसकी आरती उतारे, निंदा और तारीफ दोनों ही उसके लिए धूल के समान हैं। वह हवा की तरह बिना किसी नियम के, बेपरवाह और आज़ाद जीता है।"
            "वह किसी भी भगवान का आवाहन (बुलाना) या विसर्जन (विदा करना) नहीं करता। उसके लिए कोई मंत्र नहीं, कोई यंत्र नहीं, कोई तंत्र नहीं और ध्यान का कोई नाटक भी नहीं।"
            "उसके लिए कोई लक्ष्य (Target) नहीं बचा जिसे पाना हो। उसके लिए 'मैं', 'तुम', 'यह दुनिया' या 'वह भगवान' जैसा कोई भी भेद नहीं बचा; सब कुछ शून्य और एक हो चुका है।"
            "वह पूरी तरह बेघर (अनिकेत) होकर, ज़मीन पर सोकर जीता है; उसका अपना कोई ठिकाना नहीं होता।"
            "ऐसा भयानक भिक्षु सपने में भी, भूलकर भी कभी सोने-चांदी, पैसे या दौलत (सौवर्णादीनि) को हाथ नहीं लगाता।"
            "और सबसे बड़ी बात— वह इस दुनिया की किसी भी चीज़, किसी भी दृश्य, या किसी भी रिश्ते की रत्ती भर भी चाहत नहीं रखता।"
            "वह एक ज़िंदा इंसान नहीं, बल्कि धरती पर चलता हुआ एक असीम शून्य (Void) है।"
        """.trimIndent(),
        english = """
            (The Terrifying and Boundless State of the Avadhuta): "That supreme mendicant is clothed exclusively by the invisible directions of space (Sky-clad); he violently crushes all societal shame and rules."
            "He absolutely refuses to bow his head to anyone—no human, no deity, no idol in this entire cosmos—because he himself has mutated into God."
            "He offers zero oblations to the gods shouting 'Swaha', nor to dead ancestors whispering 'Swadha'; every single ritual has burnt to ashes for him."
            "Whether society hurls brutal curses at him or worships him, blame and praise are literal dirt to him. He lives flawlessly spontaneously, drifting wildly like the uncontrollable wind."
            "He performs absolutely no invocation to call any god, nor any dismissal. He uses zero mantras, zero yantras, zero tantras, and performs no theatrical meditations."
            "There is absolutely no target left for him to achieve. He perceives zero separation—there is no 'I', no 'You', no 'This World', no 'That God'; everything has melted into one cosmic Void."
            "He exists as a completely homeless wanderer (Aniketa), sleeping on the raw dirt, possessing absolutely no permanent shelter."
            "Such a terrifyingly detached monk absolutely never, even in his deepest nightmares, touches or accepts gold, money, or wealth."
            "And the ultimate climax—he harbors absolutely zero craving or desire for any object, any sight, or any relationship in this entire world."
            "He is no longer a living human being; he is a walking, breathing infinite cosmic Void on Earth."
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 10,
        sanskrit = "यस्माद्भिक्षुर्हिरण्यं रसेन दृष्टं चेत्स ब्रह्महा भवेत् । यस्माद्भिक्षुर्हिरण्यं रसेन स्पृष्टं चेत्स पौल्कसो भवेत् । यस्माद्भिक्षुर्हिरण्यं रसेन ग्राह्यं चेत्स आत्महा भवेत् । तस्माद्भिक्षुर्हिरण्यं रसेन न दृष्टं न स्पृष्टं न ग्राह्यं च ।",
        hindi = """
            (धन और स्वर्ण का प्रलयंकारी और भयंकर निषेध): यहाँ उपनिषद पैसे को संन्यासी के लिए साक्षात मौत और ज़हर घोषित करता है।
            "एक संन्यासी के लिए दौलत से बड़ा कोई दुश्मन नहीं। यदि कोई भिक्षु लालच या वासना (रसेन) की दृष्टि से 'सोने या पैसों' को आँख उठाकर 'देखता' भी है..."
            "तो वह उसी क्षण साक्षात एक 'ब्रह्म-हत्यारे' (ब्रह्महा) के समान भयंकर और घृणित पापी बन जाता है!"
            "यदि वह लालच के वशीभूत होकर उस सोने या दौलत को अपनी उंगलियों से 'छू' भर लेता है..."
            "तो वह अपनी सारी आध्यात्मिक ऊँचाई से गिरकर समाज के सबसे नीच, अपवित्र और गिरे हुए 'चांडाल' (पौल्कस) के स्तर पर पहुँच जाता है!"
            "और यदि वह लालच में अंधा होकर उस सोने (पैसों) को स्वीकार कर लेता है, अपनी जेब में रख लेता है..."
            "तो वह साक्षात अपनी ही आत्मा का क्रूर हत्यारा (आत्महा) बन जाता है; उसने अपने हाथों से अपनी मुक्ति का गला घोंट दिया!"
            "पैसा और मोह आध्यात्मिक मौत का दूसरा नाम है; यह मन को वापस कीचड़ में खींच लाता है।"
            "इसीलिए, यह एक लोहे की तरह कठोर आदेश है: एक सच्चे भिक्षु को कभी भी, किसी भी प्रलयंकारी हालात में..."
            "सोने या दौलत को न तो लालच से देखना चाहिए, न उसे छूना चाहिए, और न ही उसे कभी स्वीकार करना चाहिए!"
        """.trimIndent(),
        english = """
            (The Apocalyptic and Terrifying Prohibition of Wealth): Here, the Upanishad fiercely declares money as literal, concentrated death and poison for a monk.
            "There is no enemy more lethal to a Sannyasin than wealth. If a mendicant even dares to 'look' at gold or money with the slightest micro-drop of greedy desire (Rasa)..."
            "He instantaneously and violently incurs the horrific, unforgivable, and repulsive sin of a Brahma-Slayer!"
            "If, overpowered by lust, he even 'touches' that gold or wealth with the tip of his fingers..."
            "He violently crashes down from his spiritual zenith to the degraded, filthy level of the lowest, most polluted outcaste (Paulkasa)!"
            "And if, blinded by extreme greed, he actually 'accepts' and hoards this wealth in his pockets..."
            "He literally becomes the brutal, cold-blooded murderer of his own Soul (Atmaha); he has strangled his own liberation with his bare hands!"
            "Money and attachment are the absolute synonyms for spiritual suicide; they drag the mind violently back into the worldly mud."
            "Therefore, this is an ironclad, absolute cosmic command: Under absolutely no catastrophic circumstance must a true monk ever..."
            "Look at gold with greed, touch it with lust, or accept it as his own!"
        """.trimIndent()
    ),
    ParamahamsaShloka(
        id = 11,
        sanskrit = "सर्वे कामा मनोगता व्यावर्तन्ते । दुःखे नोद्विग्नः सुखे निःस्पृहस्त्यागो रागे सर्वत्र शुभाशुभयोरनभिस्नेहो न द्वेष्टि न मोदते च । सर्वेषामिन्द्रियाणां गतिरुपरमते य आत्मन्येवावस्थीयते यत्पूर्णानन्दैकबोधस्तद्ब्रह्मैवाहमस्मीति कृतकृत्यो भवति कृतकृत्यो भवतीत्युपनिषत् ॥ ४॥",
        hindi = """
            (अंतिम मोक्ष की महा-गर्जना और 'द एंड'): "जब वह इस खौफनाक तपस्या को पार कर लेता है, तो उसके मन की अंधेरी गुफाओं में छिपी आखिरी इच्छा भी तड़प कर राख हो जाती है।"
            "अब वह अजेय है! दुखों का पहाड़ टूट कर गिरने पर भी उसके चेहरे पर कोई डर या शिकन नहीं आती।"
            "दुनिया के सारे सुख और स्वर्ग के राज-पाट उसके कदमों में रख दिए जाएं, फिर भी वह रत्ती भर नहीं ललचाता (निःस्पृह)।"
            "उसने हर जगह से, हर इंसान से और हर वस्तु से अपने लगाव और आसक्ति (Attachment) की जंजीरों को हमेशा के लिए काट दिया है।"
            "हालात चाहे कितने भी अच्छे हों या कितने भी खौफनाक, न तो वह किसी से नफरत करता है, न किसी बात पर खुश होता है।"
            "दुनिया को भोगने वाली उसकी सभी पाँचों इंद्रियों (Senses) की गति और भूख हमेशा के लिए सुन्न पड़ जाती है और मर जाती है।"
            "वह योगी दुनिया से कटकर केवल और केवल अपनी 'आत्मा' के गहरे, असीम महासागर में डूबकर स्थापित हो जाता है।"
            "और तब उसके भीतर यह प्रलयंकारी सत्य परमाणु बम की तरह फटता है: 'मैं ही वह शुद्ध आनंद और परम चेतना हूँ, मैं ही साक्षात परब्रह्म हूँ!' (ब्रह्मैवाहमस्मीति)।"
            "जब इंसान खुद भगवान बन गया, तो वह हमेशा के लिए पूर्ण काम और आज़ाद हो जाता है। हाँ! श्रुति चीख कर कहती है - वह हमेशा के लिए मुक्त हो जाता है! (कृतकृत्यो भवति)।"
            यहीं पर यह सबसे महान, रौंगटे खड़े कर देने वाला और पवित्र 'परमहंस उपनिषद' पूर्ण रूप से संपन्न होता है। ॐ शांति!
        """.trimIndent(),
        english = """
            (The Colossal Cosmic Roar of Final Liberation and 'The End'): "When he survives this terrifying penance, every single lingering desire hiding in the darkest caves of his mind violently starves and turns to ash."
            "He is now utterly invincible! He remains absolutely unshaken, without a flinch, even if a catastrophic mountain of agony crushes him."
            "Even if all the physical pleasures of the world and the thrones of heaven are thrown at his feet, he remains completely, perfectly desireless."
            "He has permanently, violently severed and shattered the heavy chains of attachment to every place, every human, and every object."
            "Whether circumstances are exceptionally magnificent or horrifyingly evil, he neither harbors hatred nor feels any fleeting excitement."
            "The outward, hungry, worldly movement of all his physical senses completely freezes into a dead, absolute silence."
            "The Yogi, severed from the external cosmos, anchors and drowns exclusively into the infinite, bottomless ocean of his own Supreme Soul."
            "And then, he is struck by the earth-shattering, atomic reality: 'I am exactly that perfect bliss, I myself am explicitly the Absolute Supreme Brahman!' (Brahmaivahamasmiti)."
            "When the human flawlessly becomes God Himself, he is entirely fulfilled and violently liberated. Yes! The Shruti screams - He undeniably becomes perfectly fulfilled forever! (Kritakrityo bhavati)."
            Right exactly here, this supreme, spine-chilling, and profoundly sacred 'Paramahamsa Upanishad' achieves its magnificent completion. OM Peace!
        """.trimIndent()
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParamahamsaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..11) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-11)") },
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
            itemsIndexed(paramahamsaShlokasList) { _, shloka ->
                ParamahamsaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun ParamahamsaShlokaCard(shloka: ParamahamsaShloka) {
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