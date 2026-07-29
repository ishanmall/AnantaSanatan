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
data class TuriyatitaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

val turiyatitaShlokasList = listOf(
    TuriyatitaShloka(
        id = 1,
        sanskrit = "ॐ पूर्णमदः पूर्णमिदं पूर्णात्पूर्णमुदच्यते । पूर्णस्य पूर्णमादाय पूर्णमेवावशिष्यते ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
        hindi = """
            (ब्रह्मांडीय पूर्णता का महा-सिद्धांत): यह मंत्र सनातन धर्म की सबसे बड़ी और प्रलयंकारी घोषणा है!
            "वह निराकार परब्रह्म पूरी तरह से असीम और 'पूर्ण' (Infinite) है।"
            "यह दृश्यमान ब्रह्मांड भी उसी पूर्ण भगवान से प्रकट होने के कारण अपने आप में पूरी तरह 'पूर्ण' है।"
            "उस परम पूर्ण (परमात्मा) में से इस अनंत ब्रह्मांड को निकाल लेने के बाद भी, ईश्वर में रत्ती भर भी कमी नहीं आती।"
            "अनंत में से अनंत को घटाने के बाद जो बचता है, वह भी साक्षात अनंत और पूर्ण ही होता है।"
            यह सत्य इंसान के इस झूठे 'अहंकार' को कुचल देता है कि वह अधूरा, कमज़ोर या छोटा है।
            इंसान की आत्मा कोई टुकड़ा नहीं, बल्कि साक्षात वह संपूर्ण और असीम 'ईश्वर' ही है।
            जब यह 'छोटा मैं' (Ego) मरता है, तब जीव अपनी इस खौफनाक और असीम पूर्णता को पहचान लेता है।
            ॐ! मेरे शरीर, मन और आत्मा के तीनों तापों (दैहिक, दैविक, भौतिक) का हमेशा के लिए सर्वनाश हो और परम शांति मिले!
            (यह शांति पाठ संन्यास के इस सबसे कठोर उपनिषद की शुरुआत करता है)।
        """.trimIndent(),
        english = """
            (The Grand Principle of Cosmic Completeness): This mantra is the most apocalyptic and colossal declaration of Sanatana Dharma!
            "That formless Supreme Brahman is absolutely, boundlessly, and infinitely 'Complete' (Purna)."
            "This visible universe, having manifested directly from that Infinite God, is also perfectly 'Complete'."
            "Even after flawlessly extracting this infinite cosmos from that Supreme Infinite, God suffers zero reduction."
            "Subtracting the infinite from the infinite leaves behind a remainder that is undeniably the Absolute Infinite alone."
            This lethal truth violently crushes the human illusion and ego that man is broken, weak, or incomplete.
            The human soul is not a pathetic fragment, but literally the total, infinite, and complete 'God' Himself.
            When this 'Tiny I' (Ego) brutally starves to death, the soul awakens to its terrifying, boundless perfection.
            OM! May there be the absolute and permanent annihilation of the three worldly miseries, bringing supreme cosmic peace!
            (This peace invocation initiates the most terrifyingly harsh Upanishad of extreme renunciation).
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 2,
        sanskrit = "अथ पितामहं भगवन्तं नारायणमुपसमेत्योवाच । तुरीयातीतावधूतानां कोऽयं मार्गः का तेषां स्थितिरिति । तस्मै स होवाच ।",
        hindi = """
            (ब्रह्मा का नारायण से परम रहस्य पूछना): इस उपनिषद की शुरुआत किसी इंसान से नहीं, बल्कि देवताओं के भी देवता से होती है।
            सृष्टि के रचयिता, साक्षात 'पितामह ब्रह्मा' ने सर्वोच्च परमेश्वर 'भगवान नारायण' के पास जाकर यह रहस्यमयी प्रश्न पूछा।
            ब्रह्मा जी ने पूछा: "हे प्रभु! उन रहस्यमयी 'तुरीयातीत अवधूतों' का वास्तविक मार्ग क्या है?"
            "जाग्रत, स्वप्न, सुषुप्ति और तुरीय—इन चारों अवस्थाओं को भी चीरकर पार कर जाने वाले उस महायोगी की स्थिति क्या है?"
            "वह इंसान जो इंसानियत की हदें पार कर चुका है, उसका मन कैसा होता है? उसका आचरण कैसा होता है?"
            यह कोई साधारण प्रश्न नहीं था; यह उस परम अवस्था का रहस्य था जहाँ इंसान और ईश्वर का भेद पूरी तरह मिट जाता है।
            इस प्रलयंकारी प्रश्न को सुनकर भगवान नारायण ने मुस्कुराते हुए ब्रह्मांड का सबसे गूढ़ रहस्य खोलना शुरू किया।
            "हे ब्रह्मा! जो मैं कहने जा रहा हूँ, वह कमज़ोर दिल वालों के लिए नहीं है।"
            "यह उस 'अवधूत' (परम पागल और परम ज्ञानी) की कहानी है, जो मौत को भी अपनी मुट्ठी में रखता है।"
            तब भगवान नारायण ने उस खौफनाक और परम स्वतंत्र मार्ग का वर्णन किया...
        """.trimIndent(),
        english = """
            (Brahma's Quest for the Absolute Secret): This Upanishad begins not with a human, but with the God of gods.
            The Creator of the cosmos, 'Grandsire Brahma' himself, directly approached the Supreme Lord 'Narayana' to ask this profound mystery.
            Lord Brahma asked: "O Supreme Lord! What exactly is the true, absolute path of those terrifying 'Turiyatita Avadhutas'?"
            "What is the exact state of that colossal Yogi who has violently torn through and transcended the four states of waking, dreaming, sleeping, and Turiya?"
            "How does the mind of a being who has utterly surpassed the limits of humanity function? How does he behave?"
            This was no ordinary question; it was the ultimate secret of the state where the boundary between human and God is permanently annihilated.
            Hearing this apocalyptic question, Lord Narayana smiled and began unveiling the most impenetrable secret of the universe.
            "O Brahma! What I am about to reveal is absolutely not for the weak-hearted."
            "This is the saga of the 'Avadhuta' (the supremely mad and supremely wise monk) who holds Death itself in his fist."
            Then, Lord Narayana described that terrifying, absolutely independent cosmic path...
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 3,
        sanskrit = "योऽयं तुरीयातीतावधूत-मार्गो लोके दुर्लभतरो न तु बाहुल्यः । यद्येको भवति स एव नित्यपूतस्थः स एव वेदपुरुष इति विदुषो मन्यन्ते ।",
        hindi = """
            (तुरीयातीत अवधूत की भयंकर दुर्लभता): भगवान नारायण ने सिंह गर्जना करते हुए कहा— "हे ब्रह्मा! यह 'तुरीयातीत अवधूत' मार्ग अत्यंत खौफनाक और दुर्लभ है!"
            "ऐसे महापुरुष दुनिया की भीड़ में, बाज़ारों में या आम आश्रमों में कभी नहीं मिलते (न तु बाहुल्यः)।"
            "अरबों-खरबों जन्मों के बाद, यदि पूरे ब्रह्मांड में ऐसा कोई एक भी योगी पैदा हो जाए, तो समझो पूरी सृष्टि धन्य हो गई।"
            "वह अकेला इंसान ही साक्षात 'नित्य पवित्र' है; उसके पैरों की धूल से ही गंगा जैसी नदियां भी पवित्र हो जाती हैं।"
            "सर्वोच्च ज्ञानी और सिद्ध पुरुष उसे कोई इंसान नहीं, बल्कि साक्षात 'वेद-पुरुष' (वेदों का ज़िंदा भगवान) मानते हैं।"
            "उसने ध्यान (Meditation) को भी पीछे छोड़ दिया है; अब उसे ध्यान करने की ज़रूरत नहीं, वह स्वयं ध्यान बन चुका है।"
            "वह समाज के हर नियम, हर शर्म, और हर डर को एक सड़े हुए तिनके की तरह कुचल चुका है।"
            "वह तुरीयातीत (Turiyatita) है—यानी वह चेतना के भी उस पार चला गया है जहाँ केवल और केवल शुद्ध शून्यता और परब्रह्म बचता है।"
            "उसकी आँखें दुनिया को देखती हैं, लेकिन उसका दिमाग इस दुनिया में मौजूद ही नहीं होता।"
            "वह शरीर में कैद एक ऐसा असीम महासागर है जिसे मौत भी छूने से काँपती है।"
        """.trimIndent(),
        english = """
            (The Terrifying Rarity of the Turiyatita Avadhuta): Lord Narayana roared with the intensity of a cosmic lion—"O Brahma! This path of the 'Turiyatita Avadhuta' is terrifyingly rare!"
            "Such colossal mastermen are absolutely never found in worldly crowds, markets, or common ashrams (Na tu bahulyah)."
            "If, after billions of lifetimes, even one such absolute Yogi is born in the entire cosmos, consider the universe utterly blessed."
            "He alone is the embodiment of 'Eternal Purity'; even rivers like the Ganga become purified merely by the dust of his feet."
            "The highest enlightened masters recognize him not as a human, but explicitly as the 'Veda-Purusha' (the living, breathing God of the Vedas)."
            "He has violently surpassed even meditation; he no longer needs to meditate, because he has literally become Meditation itself."
            "He has brutally crushed every societal rule, every ounce of shame, and every micro-drop of fear like rotting straw."
            "He is 'Turiyatita'—meaning he has crossed completely beyond consciousness into a realm where strictly only absolute Void and Supreme Brahman remain."
            "His physical eyes look at the world, but his mind absolutely does not exist in this dimension."
            "He is an infinite, bottomless ocean trapped in a biological shell, whom even Death trembles to touch."
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 4,
        sanskrit = "सोऽयं स्वयमादौ क्रमेण कुटीचको बहूदको हंसः परमहंसस्तपसा स्वरूपमवगत्य...",
        hindi = """
            (अवधूत बनने की खौफनाक सीढ़ियां): नारायण बताते हैं कि कोई अचानक अवधूत नहीं बनता; उसे संन्यास की भयंकर आग से गुज़रना पड़ता है।
            "सबसे पहले वह 'कुटीचक' बनता है (जो कुटिया में रहकर संन्यास का अभ्यास करता है)।"
            "फिर वह 'बहूदक' बनता है (जो एक जगह नहीं रुकता, पवित्र नदियों का जल पीकर भटकता है)।"
            "उसके बाद वह 'हंस' बनता है (जो ज्ञान और अज्ञान के बीच का फर्क समझकर केवल सत्य को चुनता है)।"
            "फिर वह तपस्या की भयंकर आग में जलकर 'परमहंस' बनता है (जो शिखा, जनेऊ और दुनिया के सारे कर्मकांड त्याग देता है)।"
            "लेकिन वह यहीं नहीं रुकता! परमहंस की स्थिति को भी वह अपने पैरों तले रौंद देता है।"
            "अपनी 'आत्मा के असली स्वरूप' (स्वरूपमवगत्य) का ऐसा प्रलयंकारी ज्ञान उसे होता है कि वह आखिरी सीमा भी तोड़ देता है।"
            "वह संन्यासी के भगवा कपड़ों, दण्ड और कमंडल को भी फेंक देता है, क्योंकि अब उसे संन्यासी दिखने का भी कोई शौक नहीं।"
            "वह कुटीचक, बहूदक, हंस और परमहंस की सभी सीढ़ियों को जलाकर उस चरम 'तुरीयातीत' अवस्था में पहुँच जाता है।"
            "जहाँ न कोई धर्म है, न कोई नियम है, न कोई गुरु है और न ही कोई शिष्य!"
        """.trimIndent(),
        english = """
            (The Terrifying Steps to Becoming an Avadhuta): Lord Narayana reveals that no one becomes an Avadhuta overnight; he must survive the brutal fire of total renunciation.
            "First, he becomes a 'Kutichaka' (a monk practicing renunciation while living in a secluded hut)."
            "Then he evolves into a 'Bahudaka' (a wanderer who never stays in one place, surviving only on sacred river water)."
            "Next, he transforms into a 'Hamsa' (a swan-like master who perfectly separates cosmic truth from worldly illusion)."
            "Then, burning in the catastrophic fire of penance, he becomes a 'Paramahamsa' (who violently discards his tuft, thread, and all rituals)."
            "But he absolutely does not stop there! He ruthlessly tramples even the exalted state of the Paramahamsa under his feet."
            "He experiences such an apocalyptic realization of his 'Absolute True Self' (Swarupamavagatya) that he shatters the final boundary."
            "He throws away the saffron robes, the wooden staff, and the water pot, possessing absolutely zero desire even to 'look' like a monk."
            "Burning down the ladders of Kutichaka, Bahudaka, Hamsa, and Paramahamsa, he explodes into the ultimate 'Turiyatita' state."
            "A terrifying dimension where there is no religion, no rules, no master, and absolutely no disciple left!"
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 5,
        sanskrit = "कौपीनं दण्डमाच्छादनं स्वशरीरोपभोगार्थाय लोकस्योपकारार्थाय च परिग्रहेत् । तदपि त्यक्त्वा जातरूपधरो भूत्वा...",
        hindi = """
            (अंतिम वस्त्रों का भी महा-त्याग): "एक साधारण परमहंस अपने शरीर को ज़िंदा रखने के लिए लंगोट (कौपीन), डंडा और एक कपड़ा रखता है।"
            "वह ये चीज़ें केवल इसलिए रखता है ताकि दुनिया का कल्याण कर सके। लेकिन तुरीयातीत अवधूत इससे भी आगे निकल जाता है।"
            "वह उस आखिरी लंगोट, उस डंडे और उस कपड़े को भी निर्दयता से नोचकर फेंक देता है (तदपि त्यक्त्वा)!"
            "वह उसी अवस्था में आ जाता है जिस अवस्था में वह अपनी माँ के गर्भ से पैदा हुआ था—पूरी तरह निर्वस्त्र (जातरूपधरो भूत्वा)।"
            "या फिर वह सड़क पर पड़े हुए फटे-पुराने चिथड़ों को पहन लेता है, क्योंकि उसके लिए रेशम और कचरे में कोई फर्क नहीं बचा।"
            "उसे न तो समाज की गालियों का डर है और न ही नंगेपन की कोई शर्म। उसकी 'शर्म' (Shame) पूरी तरह से मर चुकी है।"
            "वह दुनिया के लिए एक पागल है, लेकिन असल में उसने ब्रह्मांड के हर भौतिक बंधन की धज्जियां उड़ा दी हैं।"
            "उसे यह भौतिक शरीर अपना लगता ही नहीं; यह शरीर उसके लिए हवा में उड़ते हुए एक सूखे पत्ते से ज्यादा कुछ नहीं।"
            "वह आज़ादी की उस खौफनाक और असीमित चोटी पर खड़ा है, जहाँ उसे छूने की औकात दुनिया के किसी नियम की नहीं है।"
            "यह है एक सच्चे अवधूत की सबसे खौफनाक और प्रलयंकारी स्वतंत्रता!"
        """.trimIndent(),
        english = """
            (The Ultimate Sacrifice of the Final Coverings): "An ordinary Paramahamsa retains a mere loincloth (Kaupina), a staff, and a single cloth just to keep his body alive."
            "He keeps them strictly for the welfare of the world. But the Turiyatita Avadhuta violently surpasses even this."
            "He ruthlessly tears off and throws away even that final loincloth, that staff, and that covering (Tadapi tyaktva)!"
            "He flawlessly returns to the exact state in which he was born from his mother’s womb—completely, unapologetically naked (Jatarupadharo bhutva)."
            "Or he might drape himself in filthy rags found on the street, because to him, pure silk and rotting garbage are entirely identical."
            "He possesses absolutely zero fear of society's abuses, and zero shame of nakedness. His psychological 'Shame' has been utterly assassinated."
            "To the blind world he is a lunatic, but in reality, he has brutally obliterated every single physical chain of the cosmos."
            "He no longer recognizes this biological body as his own; to him, this flesh is nothing more than a dead leaf blowing in the wild wind."
            "He stands on that terrifying, boundless peak of ultimate freedom where absolutely no worldly rule has the status to touch him."
            "This is the most terrifying, apocalyptic, and absolute freedom of a genuine Avadhuta!"
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 6,
        sanskrit = "उन्मत्तबालपिशाचवदेकाकी सञ्चरन्... अन्तरात्मनि सर्वमेव पश्यन्...",
        hindi = """
            (पागल, बच्चे और भूत जैसी अवस्था): यह उपनिषद अवधूत के चरित्र का सबसे भयंकर वर्णन करता है।
            "वह महायोगी समाज में 'उन्मत्त' (एक पूर्ण पागल व्यक्ति), 'बाल' (एक मासूम बच्चे), और 'पिशाच' (एक भूत-प्रेत) की तरह अकेला (एकाकी) भटकता है!"
            "जैसे एक पागल को दुनिया के नियमों की परवाह नहीं होती, वैसे ही अवधूत दुनिया की हर मर्यादा को तोड़ चुका होता है।"
            "जैसे एक छोटे बच्चे को अच्छे-बुरे का कोई भेद नहीं होता, वैसे ही अवधूत के लिए सोना और मिट्टी एक बराबर हैं।"
            "जैसे एक भूत-प्रेत का कोई घर या ठिकाना नहीं होता, वह अदृश्य होकर कहीं भी भटकता है, अवधूत का भी कोई आश्रम नहीं होता।"
            "बाहर से वह दुनिया का सबसे गिरा हुआ, पागल और आवारा इंसान दिखता है।"
            "लेकिन अंदर... अंदर वह एक ऐसे ब्रह्मांडीय विस्फोट में जी रहा है जहाँ वह अपनी 'आत्मा के भीतर ही संपूर्ण ब्रह्मांड' (अन्तरात्मनि सर्वमेव पश्यन्) को धड़कते हुए देखता है!"
            "वह बाहर से भिखारी है, लेकिन भीतर से वह पूरे ब्रह्मांड का इकलौता सम्राट है।"
            "उसकी आँखें खुली हैं, लेकिन वह जो देख रहा है, वह दुनिया के किसी आम इंसान को दिखाई नहीं देता।"
            "वह चलता-फिरता शिव बन चुका है; उसकी यह 'पागलपन' वाली अवस्था असल में सबसे ऊँची और शुद्ध बुद्धिमत्ता (Supreme Intelligence) है।"
        """.trimIndent(),
        english = """
            (The State of a Madman, Child, and Ghost): This Upanishad delivers the most terrifying description of the Avadhuta's character.
            "That colossal Yogi violently wanders completely alone (Ekaki), behaving exactly like an 'Unmatta' (an absolute madman), a 'Bala' (an innocent infant), and a 'Pishacha' (a wild ghost)!"
            "Just as a lunatic possesses zero regard for societal laws, the Avadhuta has utterly crushed every single worldly boundary."
            "Just as an infant perceives zero difference between good and bad, for the Avadhuta, solid gold and rotting dirt are flawlessly identical."
            "Just as a ghost possesses no house or shelter and wanders invisibly everywhere, the Avadhuta has absolutely no ashram or destination."
            "From the outside, he appears as the most degraded, lunatic, and homeless vagabond on Earth."
            "But internally... internally he is living within an apocalyptic cosmic explosion, literally perceiving 'the entire cosmos pulsating strictly within his own Soul' (Antaratmani sarvameva pashyan)!"
            "Externally he is a beggar, but internally he is the absolute, undisputed Emperor of the entire universe."
            "His physical eyes are wide open, but what he is witnessing cannot possibly be seen by any mortal human."
            "He has become a walking, breathing Shiva; his apparent 'insanity' is, in absolute reality, the highest, most terrifyingly pure Supreme Intelligence."
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 7,
        sanskrit = "अपुण्यमपापमज्ञानमविद्यामनाशमविकारमेवावगच्छन् । अजगरवृत्त्या... मद्भक्तानां मल्लक्षणं मय्येवावतिष्ठते ।",
        hindi = """
            (अजगर वृत्ति और पाप-पुण्य का अंत): "उस अवधूत के लिए 'पाप' (Sin) और 'पुण्य' (Merit) दोनों शब्दों की मौत हो चुकी है।"
            "उसके लिए अज्ञान, विद्या, नाश और शरीर का कोई भी विकार (बदलाव) मायने नहीं रखता; वह इन सबसे हमेशा के लिए परे जा चुका है।"
            "वह 'अजगर वृत्ति' (Python's way of life) से जीता है— एक अजगर शिकार खोजने नहीं जाता, जो उसके मुँह के पास आ जाए, वह उसी को खाकर मस्त रहता है।"
            "उसी तरह, अवधूत न तो खाना मांगता है, न कल की चिंता करता है। कोई उसे ज़हर दे या अमृत, वह बिना स्वाद लिए उसे निगल जाता है।"
            "उसे जीने की कोई इच्छा नहीं है, और मरने का उसे रत्ती भर भी खौफ नहीं है।"
            "भगवान नारायण कहते हैं: 'ऐसा योगी मेरा सबसे बड़ा भक्त है! वह मेरे ही लक्षणों (मल्लक्षणं) को धारण करता है!'"
            "'वह कोई इंसान नहीं रहा, वह साक्षात मेरा ही प्रतिरूप बन चुका है, और वह हमेशा केवल मुझमें (मय्येवावतिष्ठते) ही निवास करता है!'"
            "यह है सनातन धर्म की सबसे चरम और खौफनाक आध्यात्मिकता, जहाँ इंसान की सारी कमज़ोरियां राख हो जाती हैं।"
            "जब कोई 'मैं' बचता ही नहीं, तो पाप कौन करेगा और पुण्य किसे मिलेगा?"
            "वह अवधूत अच्छाई और बुराई की आग को पार करके उस परम शून्यता में खड़ा है जहाँ केवल ईश्वर है।"
        """.trimIndent(),
        english = """
            (The Way of the Python and the Death of Sin/Merit): "For that supreme Avadhuta, the very concepts of 'Sin' (Papa) and 'Merit' (Punya) have violently starved to death."
            "Ignorance, knowledge, destruction, and all biological bodily mutations mean absolutely nothing to him; he has permanently transcended them all."
            "He survives strictly through the 'Ajagara Vritti' (The Python's Code)—a python never hunts, it merely swallows whatever stumbles near its mouth and remains in absolute bliss."
            "Similarly, the Avadhuta never begs, never hunts for food, and has zero anxiety for tomorrow. Whether handed lethal poison or divine nectar, he swallows it without registering its taste."
            "He possesses absolutely zero desire to live, and possesses not a micro-drop of fear of dying."
            "Lord Narayana roars: 'Such a colossal Yogi is my ultimate devotee! He physically embodies My exact divine traits (Mallakshanam)!'"
            "'He is no longer a mortal human; he has mutated into My exact, literal replica, and he permanently resides strictly within Me alone (Mayyevavatishthate)!'"
            "This is the most extreme, terrifying spirituality of Sanatana Dharma, where every single human weakness is burnt to ashes."
            "When the 'Ego' no longer exists, who is left to commit a sin, and who is left to claim merit?"
            "That Avadhuta has crossed the raging fires of both good and evil, standing as a completely invincible titan in that Supreme Void where strictly only God exists."
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 8,
        sanskrit = "स्वशरीरं कुणपमिव पश्यन्... अहंकारं हित्वा...",
        hindi = """
            (शरीर का त्याग और मुर्दे का सत्य): "वह तुरीयातीत योगी सबसे खौफनाक काम करता है—वह अपने ही साँस लेते शरीर को एक सड़े हुए 'मुर्दे' (कुणपमिव) की तरह देखता है!"
            "उसे पता है कि यह हाड़-मांस का पुतला कल मिट्टी में मिल जाएगा, इसलिए वह इसके दर्द और सुख से अपना रिश्ता पूरी तरह काट लेता है।"
            "उसके अंदर का 'अहंकार' (मैं फलां व्यक्ति हूँ, मैं बड़ा ज्ञानी हूँ) एक भयानक चीख के साथ मर चुका है।"
            "कोई उसकी देह को काट भी दे, तो भी उसे कोई दर्द महसूस नहीं होता, क्योंकि उसने खुद को शरीर से पूरी तरह अलग कर लिया है।"
            "यह 'देहाध्यास' (शरीर से मोह) की सबसे भयानक और क्रूर मौत है; जो खुद को पहले ही मुर्दा मान चुका हो, उसे दुनिया की कोई मौत नहीं मार सकती।"
            "वह जानता है कि जो जलता है, जो सड़ता है और जो मरता है, वह केवल यह मांस का ढांचा है।"
            "वह खुद को वह अजर-अमर 'द्रष्टा' (Witness) मानता है, जो इस शरीर रूपी कपड़े के फटने का तमाशा देख रहा है।"
            "दुनिया उसे ज़िंदा इंसान समझती है, लेकिन असल में वह दुनिया के लिए मर चुका है और ईश्वर के लिए पूरी तरह जाग चुका है।"
            "अहंकार के वध के बिना यह अवस्था असंभव है; और जब अहंकार मरता है, तो ईश्वर का जन्म होता है।"
            "यह कोई किताबी ज्ञान नहीं, यह योगी के जीवन का वह खौफनाक यथार्थ है जिससे देवता भी काँपते हैं।"
        """.trimIndent(),
        english = """
            (The Abandonment of the Body and the Truth of the Corpse): "That Turiyatita Yogi executes the most terrifying psychological act—he literally perceives his own breathing, living body strictly as a rotting, dead 'Corpse' (Kunapamiva)!"
            "He knows with absolute certainty that this puppet of flesh will turn to dirt tomorrow, so he violently severs all connection to its biological pain and pleasure."
            "His 'Ego' (the illusion that 'I am this person, I am so wise') has died a brutal, agonizing death with a final terrifying scream."
            "Even if someone literally slices his physical body into pieces, he registers absolutely zero agony, because he has entirely detached his consciousness from the flesh."
            "This is the most horrific and ruthless assassination of physical attachment; he who has already accepted himself as a corpse can absolutely never be killed by any death in the universe."
            "He knows flawlessly that what burns, what rots, and what dies is strictly this biological framework of meat."
            "He recognizes himself purely as the immortal, indestructible 'Witness' (Drashta), merely watching the tearing of this flesh-cloth."
            "The blind world thinks he is a living human, but in absolute reality, he is totally dead to the world and completely, violently awake to God."
            "Without the brutal slaughter of the ego, this state is impossible; and exactly when the ego dies, God is instantly born."
            "This is no poetic textbook philosophy; this is the terrifying, raw reality of the Yogi's existence that makes even the gods tremble."
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 9,
        sanskrit = "अहं ब्रह्मेति... अहमेव परं ब्रह्म...",
        hindi = """
            (महा-विस्फोट और 'अहं ब्रह्मास्मि' की गर्जना): "तपस्या और वैराग्य की सभी हदों को चीरने के बाद, अंततः उस योगी के भीतर एक ब्रह्मांडीय विस्फोट होता है!"
            "उसे यह प्रलयंकारी और असीम सत्य महसूस होता है—'अहं ब्रह्मेति' (मैं ही वह परब्रह्म हूँ!)।"
            "यह कोई घमंड नहीं है, यह ब्रह्मांड का वह परम सत्य है जहाँ जीव और शिव की बाउंड्री हमेशा के लिए टूटकर भस्म हो जाती है।"
            "वह योगी पूरी कायनात को चुनौती देते हुए अपनी आत्मा की गहराई से दहाड़ता है—'अहमेव परं ब्रह्म' (केवल और केवल मैं ही वह सर्वोच्च ईश्वर हूँ!)।"
            "वह जान जाता है कि सूरज उसी की ऊर्जा से जलता है, हवा उसी के हुक्म से चलती है और मौत उसी के इशारे पर नाचती है।"
            "वह एक छोटा सा इंसान नहीं रहा, वह साक्षात वह ऊर्जा बन चुका है जिससे करोड़ों ब्रह्मांड पैदा होते हैं और नष्ट होते हैं।"
            "इस एक 'महावाक्य' की अनुभूति होते ही, संसार का सारा भ्रम, सारा डर और सारा दर्द अनंत काल के लिए शून्य हो जाता है।"
            "उसे अब किसी स्वर्ग की लालच नहीं है, क्योंकि स्वर्ग भी उसी के भीतर समाया हुआ है।"
            "उसे अब किसी भगवान की पूजा नहीं करनी है, क्योंकि पूजा करने वाला और जिसकी पूजा हो रही है, वे दोनों अब एक ही हो चुके हैं!"
            "यह सनातन धर्म का वह परम शिखर है जहाँ एक साधारण मिट्टी का इंसान उठकर पूरे ब्रह्मांड का इकलौता सम्राट बन जाता है।"
        """.trimIndent(),
        english = """
            (The Cosmic Explosion and the Roar of 'Aham Brahmasmi'): "After violently tearing through absolutely all limits of penance and renunciation, an atomic cosmic explosion finally detonates within that Yogi!"
            "He is struck by the apocalyptic, boundless absolute truth—'Aham Brahmeti' (I am precisely that Supreme Brahman!)."
            "This is absolutely not arrogance; this is the supreme cosmic truth where the pathetic boundary between the mortal soul and God is permanently burnt to ashes."
            "That Yogi, challenging the entire fabric of existence, roars from the deepest core of his Soul—'Ahameva Param Brahma' (I, and I alone, am explicitly the Supreme God!)."
            "He flawlessly realizes that the sun burns strictly by his energy, the wind blows entirely by his command, and Death itself dances purely on his orders."
            "He is no longer a microscopic human; he has mutated into the exact primordial energy that spawns and destroys billions of universes."
            "The microsecond this 'Mahavakya' (Supreme Statement) is experienced, every illusion, every drop of fear, and all pain in existence is violently reduced to absolute zero forever."
            "He possesses absolutely zero greed for any heaven, because heaven itself is fully contained within his own vastness."
            "He no longer needs to worship any God, because the one who worshipped and the One who was worshipped have violently fused into exactly the same Entity!"
            "This is the absolute, terrifying zenith of Sanatana Dharma, where an ordinary human of dirt rises to become the sole, undisputed Emperor of the entire cosmos."
        """.trimIndent()
    ),
    TuriyatitaShloka(
        id = 10,
        sanskrit = "य एवं वेद स संन्यासी भवति । स मुक्तो भवति इत्युपनिषत् ॥",
        hindi = """
            (मोक्ष की परम गारंटी और 'द एंड'): "उपनिषद अपनी अंतिम और सबसे निर्णायक मुहर लगाते हुए कहता है: 'य एवं वेद' (जो मुमुक्षु साधक इस परम सत्य को जान लेता है और जी लेता है)।"
            "केवल वही इंसान इस पूरे ब्रह्मांड में सच्चा और असली 'संन्यासी' (स संन्यासी भवति) कहलाने का अधिकारी है; बाकी सब केवल नाटक कर रहे हैं।"
            "जिसने अपने अहंकार को मार दिया और 'अहं ब्रह्मास्मि' का अनुभव कर लिया..."
            "वह निश्चित रूप से, 100% गारंटी के साथ, जन्म, मृत्यु, सुख, दुख और कर्मों की हर ज़ंजीर से हमेशा-हमेशा के लिए पूरी तरह 'मुक्त' हो जाता है! (स मुक्तो भवति)।"
            "उसे दोबारा किसी माँ के गर्भ में उल्टा लटकने का भयानक दर्द नहीं सहना पड़ता; वह अमर हो चुका है।"
            "वह संसार के सभी बंधनों से छूटकर उस परम अद्वैत शून्यता में हमेशा के लिए विलीन हो जाता है।"
            "यहीं पर यह अत्यंत खौफनाक, महान और प्रलयंकारी 'तुरीयातीत अवधूत उपनिषद' पूर्ण रूप से संपन्न होता है (इत्युपनिषत्)।"
            "यह उपनिषद चेतावनी देता है कि मोक्ष कोई सस्ती चीज़ नहीं है; इसके लिए अपनी ही 'मैं' (Ego) की सबसे क्रूर बलि देनी पड़ती है।"
            "जब 'मैं' मरता है, तब 'मोक्ष' का जन्म होता है; जब इंसान मिटता है, तब भगवान का जन्म होता है।"
            "यही सनातन धर्म की वह सबसे महान और आखिरी आज़ादी है जहाँ मौत भी उस योगी के सामने घुटने टेक देती है! ॐ शांति!"
        """.trimIndent(),
        english = """
            (The Ironclad Guarantee of Moksha and 'The End'): "The Upanishad violently slams its final, absolute, and decisive seal, declaring: 'Ya Evam Veda' (Whosoever seeker completely knows and lives this terrifying absolute truth)."
            "That specific human being alone, in the entire cosmos, possesses the terrifying authority to be called an authentic, genuine 'Sannyasin' (Sa sannyasi bhavati); everyone else is merely executing a pathetic theatrical drama."
            "He who has brutally slaughtered his own ego and physically experienced the atomic explosion of 'Aham Brahmasmi'..."
            "He undoubtedly, with an ironclad 100% cosmic guarantee, becomes flawlessly, permanently 'Liberated' from every single chain of birth, death, pleasure, pain, and karma forever! (Sa mukto bhavati)."
            "He absolutely never has to suffer the agonizing torture of hanging upside down in a mother's womb ever again; he has achieved literal immortality."
            "Shattering every worldly bondage, he violently dissolves and merges into that Supreme Non-Dual Void for all eternity."
            "Right exactly here, this terrifyingly harsh, majestic, and apocalyptic 'Turiyatita Avadhuta Upanishad' achieves absolute completion (Ityupanishat)."
            "This Upanishad roars a lethal warning: Moksha is absolutely not cheap; it demands the most brutal, ruthless human sacrifice of your own 'Ego' (I)."
            "When the 'I' violently dies, 'Moksha' is instantly born; when the human is utterly erased, God is flawlessly born."
            "This is Sanatana Dharma's most magnificent, final absolute freedom, where Death itself falls to its knees before the Yogi! OM Peace!"
        """.trimIndent()
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TuriyatitaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..10) {
                    coroutineScope.launch {
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
            itemsIndexed(turiyatitaShlokasList) { _, shloka ->
                TuriyatitaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun TuriyatitaShlokaCard(shloka: TuriyatitaShloka) {
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