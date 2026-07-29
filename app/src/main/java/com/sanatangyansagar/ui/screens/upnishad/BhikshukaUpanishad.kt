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

class BhikshukaUpanishad {

    // Data Model
    data class BhikshukaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val bhikshukaShlokasList = listOf(
            BhikshukaShloka(
                id = 1,
                sanskrit = "ॐ भिक्षूणां मोक्षार्थिनां कुटीचक-बहूदक-हंस-परमहंसाश्चेति चत्वारो भवन्ति ॥ १॥",
                hindi = """
                    (मोक्ष की खौफनाक सेना का वर्गीकरण): "सनातन धर्म में मोक्ष कोई खैरात में मिलने वाली चीज़ नहीं है; यह मौत को हराने का सबसे खौफनाक युद्ध है।"
                    "इस प्रलयंकारी उपनिषद की शुरुआत में उन अजेय योद्धाओं (भिक्षुओं) का ऐलान होता है, जो मोक्ष की भूख में अपनी पूरी दुनिया जला चुके हैं।"
                    "जो मुमुक्षु (मोक्ष चाहने वाले) अपनी देह के इस सड़े हुए पिंजरे को तोड़ने निकलते हैं, वे चार खौफनाक श्रेणियों में बाँटे गए हैं।"
                    "पहला 'कुटीचक', दूसरा 'बहूदक', तीसरा 'हंस' और चौथा ब्रह्मांड का सबसे अजेय तानाशाह— 'परमहंस'!"
                    "ये चारों कोई साधारण भिखारी नहीं हैं; ये वो आत्मघाती सैनिक हैं जिन्होंने अपनी ही हस्ती (Ego) को बम से उड़ाने का संकल्प लिया है।"
                    "दुनिया पैसे और वासना के पीछे भागती है, लेकिन ये भिक्षु अपनी वासनाओं का नंगा नाच देखकर उन पर बेरहमी से थूक देते हैं।"
                    "संन्यास कोई भागने का रास्ता नहीं, बल्कि यह अपने ही अहंकार की गर्दन पर कुल्हाड़ी मारने का सीधा और क्रूर हुक्म है।"
                    "इन चारों सीढ़ियों पर चढ़कर ही एक इंसान अपनी मिट्टी की औकात को चीरकर साक्षात ईश्वर के तख़्त तक पहुँचता है।"
                    "जैसे-जैसे भिक्षु इन सीढ़ियों पर आगे बढ़ता है, समाज से उसकी बगावत उतनी ही खौफनाक और असीमित होती जाती है।"
                    "यहीं से शुरू होता है इंसानियत को मिटाकर 'भगवान' पैदा करने का वह ब्रह्मांडीय और क्रूर विज्ञान!"
                """.trimIndent(),
                english = """
                    (The Terrifying Hierarchy of the Moksha Army): "In Sanatana Dharma, Moksha is absolutely no charity; it is the most horrific, apocalyptic war to defeat Death."
                    "This explosive Upanishad opens by violently declaring the ranks of those invincible warriors (Bhikshukas) who have burnt their entire world in the hunger for Liberation."
                    "The seekers who march out to shatter the rotting biological cage of their flesh are categorized into four terrifying divisions."
                    "The first is 'Kutichaka', the second 'Bahudaka', the third 'Hamsa', and the fourth is the undisputed dictator of the cosmos—the 'Paramahamsa'!"
                    "These four are absolutely no ordinary beggars; they are spiritual suicide-soldiers who have vowed to detonate their own existence (Ego) to ashes."
                    "While the world chases money and lust, these monks brutally spit on the naked dance of biological desires."
                    "Sannyasa is absolutely no escapism; it is the direct, cold-blooded command to swing an axe directly at the neck of your own ego."
                    "Strictly by scaling these four ladders does a human tear through his pathetic earthly status and ascend to the literal throne of God."
                    "As the monk violently ascends these ranks, his rebellion against society becomes increasingly horrifying and limitless."
                    "Right here begins the cosmic, brutal science of entirely erasing humanity to explicitly birth 'God'!"
                """.trimIndent()
            ),
            BhikshukaShloka(
                id = 2,
                sanskrit = "कुटीचका नाम गौतमभरद्वाजयाज्ञवल्क्यवसिष्ठप्रभृतयोऽष्टौ ग्रासान् भिक्षमाणा योगमार्गे मोक्षमन्विच्छन्तीति ॥ २॥",
                hindi = """
                    (कुटीचक: पहली सीढ़ी और भूख का दमन): "मोक्ष के इस खूनी युद्ध की पहली सीढ़ी 'कुटीचक' संन्यासी हैं, जिन्होंने वैराग्य का पहला घूंट पिया है।"
                    "इनमें महर्षि गौतम, भरद्वाज, याज्ञवल्क्य और वसिष्ठ जैसे महान और अजेय महापुरुष आते हैं, जिन्होंने सबसे पहले अपनी भूख का गला घोंटा।"
                    "वे इंसानियत की सबसे बड़ी कमज़ोरी (भोजन/Taste) को कुचलने के लिए केवल और केवल 'आठ ग्रास' (Eight mouthfuls) भोजन ही मांगते हैं!"
                    "चाहे उनका शरीर भूख से तड़प-तड़प कर चीखें मारे, वे आठवें निवाले के बाद अन्न के एक दाने को भी छूने से इंकार कर देते हैं।"
                    "वे केवल ज़िंदा रहने के लिए इस शरीर रुपी भट्टी में ईंधन डालते हैं, ताकि उनका योग का महायुद्ध जारी रह सके।"
                    "वे एक कुटिया में रहकर इस दुनिया की वासनाओं को अपने घर के बाहर ही जलाकर राख कर देते हैं।"
                    "यह शरीर को यातना देने का कोई पागलपन नहीं है, बल्कि अपनी इंद्रियों (Senses) को गुलाम बनाकर उन्हें जंजीरों में जकड़ने का तरीका है।"
                    "जो अपनी जीभ (Tongue) को कंट्रोल नहीं कर सकता, वह ब्रह्मांड को क्या कंट्रोल करेगा?"
                    "इन कुटीचक योगियों ने अपनी 'जीभ की मौत' के ज़रिए उस परम 'मोक्ष' (Absolute Freedom) की तरफ अपना पहला खौफनाक कदम बढ़ा दिया है।"
                    "यहीं से इंसान अपनी पाशविक (Animal) आदतों का वध करके देवत्व की ओर छलांग लगाता है!"
                """.trimIndent(),
                english = """
                    (Kutichaka: The First Step and the Strangling of Hunger): "The very first rank in this bloody war for Moksha is the 'Kutichaka' monk, who has swallowed the first drop of absolute detachment."
                    "This rank includes colossal, invincible Titans like Gautama, Bharadvaja, Yajnavalkya, and Vasishtha, who were the first to violently strangle their own hunger."
                    "To brutally crush humanity's greatest biological weakness (Food/Taste), they beg for strictly and exclusively 'Eight Mouthfuls' (Ashtau Grasan) of food!"
                    "Even if their physical body screams in excruciating starvation, they absolutely refuse to touch a single microscopic grain after the eighth bite."
                    "They merely dump fuel into this biological furnace strictly to keep the heart beating, ensuring their Great War of Yoga continues."
                    "Residing in a solitary hut, they intercept and incinerate all worldly lusts outside their doors to absolute ashes."
                    "This is absolutely no insane self-torture; it is the deliberate, brutal enslavement and chaining of their own biological senses."
                    "He who cannot exert tyrannical control over his pathetic tongue, how will he ever dictate the cosmos?"
                    "Through the literal 'Death of the Tongue', these Kutichaka Yogis launch their first terrifying march toward explicit 'Moksha' (Absolute Freedom)."
                    "Right here, the human executes the slaughter of his animalistic habits and leaps violently toward Godhood!"
                """.trimIndent()
            ),
            BhikshukaShloka(
                id = 3,
                sanskrit = "अथ बहूदका नाम त्रिदण्डकमण्डलुशिखायज्ञोपवीतकाषायवस्त्रधारिणो... अष्टौ ग्रासान् भिक्षमाणा योगमार्गे मोक्षमन्विच्छन्तीति ॥ ३॥",
                hindi = """
                    (बहूदक: निरंतर भटकाव और कर्मों का श्मशान): "कुटीचक के बाद दूसरी भयंकर सीढ़ी 'बहूदक' भिक्षुओं की आती है, जो एक जगह रुकने को अपनी मौत मानते हैं।"
                    "वे अपने हाथ में 'त्रिदण्ड' (तीन डंडों का समूह) पकड़ते हैं, जो उनके मन, वचन और शरीर पर उनके क्रूर और पूर्ण नियंत्रण का प्रतीक है।"
                    "वे कमंडल, शिखा, जनेऊ और भगवा वस्त्र धारण करते हैं, और समाज के हर सुख-सुविधा को लात मारकर हमेशा के लिए बेघर (Homeless) हो जाते हैं।"
                    "वे पवित्र नदियों (बहूदक) का पानी पीकर ज़िंदा रहते हैं; वे कभी भी किसी एक घर, किसी एक इंसान या किसी एक ज़मीन से लगाव नहीं जोड़ते।"
                    "अगर उन्होंने एक जगह डेरा डाला, तो 'मोह' (Attachment) उन्हें पकड़ लेगा, इसलिए वे हवा की तरह हमेशा भटकते रहते हैं।"
                    "वे भी अपनी देह के अहंकार को भूखा मारने के लिए केवल 'आठ ग्रास' अन्न का ही सेवन करते हैं।"
                    "उनके लिए यह पूरी दुनिया एक विशाल श्मशान घाट है, जहाँ वे अपनी ही इच्छाओं की चिता हर रोज़ जलाते हैं।"
                    "उन्होंने अपने आराम (Comfort Zone) का इतनी बेरहमी से कत्ल कर दिया है कि अब उन्हें पहाड़ों और जंगलों में ही शांति मिलती है।"
                    "वे योग के खुरदरे और खूनी रास्ते पर नंगे पैर चलते हुए उस परम 'मोक्ष' को अपनी मुट्ठी में करने के लिए निकल पड़े हैं।"
                    "उनका यह भटकाव कोई भटकाव नहीं, बल्कि ईश्वर के सीधे सीने में उतरने का अचूक निशाना है!"
                """.trimIndent(),
                english = """
                    (Bahudaka: Eternal Wandering and the Graveyard of Karma): "Following the Kutichaka is the second terrifying rank, the 'Bahudaka' monks, who consider staying in one place as literal death."
                    "They grip the 'Tridanda' (Three-fold staff), a brutal physical symbol of their absolute, tyrannical dictatorship over their mind, speech, and body."
                    "Adorned with a water pot, tuft, sacred thread, and saffron robes, they violently kick away every societal comfort and become permanently Homeless."
                    "They survive strictly by drinking from sacred rivers (Bahudaka); they absolutely never form a micro-drop of attachment to any house, human, or land."
                    "If they camp in one place, the demon of 'Moha' (Attachment) will hijack them; therefore, they wander relentlessly like the wild, uncontrollable wind."
                    "To continuously starve the ego of their physical shell, they too consume strictly 'Eight Mouthfuls' of food and nothing more."
                    "To them, this entire planet is one colossal graveyard where they daily ignite the funeral pyre of their own biological desires."
                    "They have executed the slaughter of their 'Comfort Zone' so ruthlessly that they now find peace exclusively in brutal mountains and dark forests."
                    "Walking barefoot on the jagged, bloody path of Yoga, they march forward to violently seize 'Moksha' within their fists."
                    "Their endless wandering is absolutely no aimless roaming; it is a flawless, sniper-like trajectory straight into the chest of God!"
                """.trimIndent()
            ),
            BhikshukaShloka(
                id = 4,
                sanskrit = "अथ हंसा नाम ग्राम एकरात्रं नगरे पञ्चरात्रं... चान्द्रायणादिव्रतपरा योगमार्गे मोक्षमन्विच्छन्तीति ॥ ४॥",
                hindi = """
                    (हंस: भयंकर तपस्या और दुनिया का बहिष्कार): "तीसरी और ज़्यादा खतरनाक सीढ़ी पर 'हंस' (Swan) भिक्षु आते हैं, जो समाज से पूरी तरह कट चुके हैं।"
                    "उनका नियम खौफनाक है: वे किसी भी छोटे गाँव में 'केवल एक रात' और बड़े शहर में 'ज़्यादा से ज़्यादा पाँच रात' ही रुकते हैं!"
                    "वे किसी भी इंसान के साथ अपना रिश्ता या पहचान बनने ही नहीं देते; वे समाज की नज़रों में एक अदृश्य भूत की तरह आते हैं और चले जाते हैं।"
                    "वे 'चान्द्रायण' जैसे अत्यंत क्रूर और जानलेवा व्रतों का पालन करते हैं, जहाँ खाना दिन-ब-दिन कम किया जाता है जब तक कि शरीर सूख कर काँटा न हो जाए!"
                    "उन्होंने अपने खुद के भौतिक शरीर के खिलाफ एक खूनी जंग छेड़ दी है, ताकि आत्मा की आवाज़ बाहर आ सके।"
                    "वे 'हंस' की तरह दुनिया के कीचड़ (माया) में रहते हुए भी उसमें से केवल 'सत्य' (दूध) को चूस लेते हैं और 'झूठ' (पानी) को वहीं छोड़ देते हैं।"
                    "उन्हें दुनिया की गालियों से दर्द नहीं होता और तारीफों से कोई खुशी नहीं होती; उनका दिमाग पूरी तरह सुन्न (Numb) हो चुका है।"
                    "वे मौत को रोज़ अपने सामने खड़ा देखते हैं, लेकिन तपस्या की आग में जलकर वे मौत से भी ज़्यादा खतरनाक हो गए हैं।"
                    "उनका हर एक कदम, हर एक साँस और हर एक व्रत केवल और केवल उस असीम 'मोक्ष' को फाड़कर बाहर निकालने के लिए है।"
                    "यह शरीर को तोड़ने का वो विज्ञान है जिसके बाद इंसान सीधा परमेश्वर के रूप में वापस जुड़ता है!"
                """.trimIndent(),
                english = """
                    (Hamsa: Terrifying Penance and the Boycott of the World): "On the third, massively more lethal rank stand the 'Hamsa' (Swan) monks, who have violently severed themselves from society."
                    "Their rule is draconian: They stay strictly 'One Single Night' in a village and 'Maximum Five Nights' in a city!"
                    "They absolutely refuse to allow any relationship or identity to form with mortals; they appear and vanish like invisible ghosts in the eyes of society."
                    "They execute extremely brutal, near-lethal fasting rituals like 'Chandrayana', starving the body systematically until it shrinks into a biological skeleton!"
                    "They have launched a ruthless, bloody warfare against their own physical body, specifically so the roar of the Soul can finally explode outward."
                    "Like the legendary 'Hamsa' (Swan), they exist in the worldly mud (Maya) but extract exclusively the 'Truth' (Milk), leaving the 'Lies' (Water) behind."
                    "Worldly abuses cause them zero agony, and praise triggers zero joy; their brain is completely, terrifyingly 'Numb' to external manipulation."
                    "They stare Death in the face every single day, but burning in the radioactive fire of penance, they have mutated to become far more dangerous than Death itself."
                    "Every single step, every breath, and every brutal fast is strictly weaponized to violently tear open the fabric of the universe and extract 'Moksha'."
                    "This is the precise science of totally shattering the biological body so that the human reconstructs directly into the Supreme God!"
                """.trimIndent()
            ),
            BhikshukaShloka(
                id = 5,
                sanskrit = "अथ परमहंसा नाम संवर्तकारुणिश्वेतकेतुजडभरतदत्तात्रेयशुकवामदेवहारीतकप्रभृतयो... ॥ ५॥",
                hindi = """
                    (परमहंस: ब्रह्मांड के अजेय तानाशाह): "अब आती है चौथी, आखिरी और सबसे प्रलयंकारी सीढ़ी— 'परमहंस' (The Supreme Swan)!"
                    "इस लिस्ट में संवर्तक, आरुणि, श्वेतकेतु, जडभरत, दत्तात्रेय और शुकदेव जैसे ब्रह्मांड के सबसे खौफनाक और अजेय महापुरुष आते हैं।"
                    "इन्होंने धर्म, नियम, समाज और इंसानियत की सारी हदों को बारूद से उड़ा दिया है; ये अब इंसान रहे ही नहीं!"
                    "इन्होंने शिखा, जनेऊ, कपड़े और यहाँ तक कि अपने 'नाम' को भी श्मशान में जलाकर उसकी राख अपने माथे पर मल ली है।"
                    "दुनिया के मूर्ख लोग इन्हें पागल, जड़ (Jadabharata) या विक्षिप्त समझते हैं, क्योंकि इनका आचरण इंसानों जैसा नहीं होता।"
                    "ये अवधूत हैं! ये सड़क पर नंगे घूम सकते हैं, राजा के सिंहासन पर मिट्टी फेंक सकते हैं, क्योंकि इनके लिए सब कुछ केवल 'शून्य' है।"
                    "इन्होंने द्वैत (Duality) की उस दीवार को इतनी बेरहमी से तोड़ दिया है कि इनके लिए अब कोई दूसरा भगवान बचा ही नहीं; ये खुद ही भगवान हैं!"
                    "इनकी साँस से शास्त्र बनते हैं और इनके खामोश रहने से प्रलय आती है; ये वो महासागर हैं जिसकी कोई गहराई नाप नहीं सकता।"
                    "इन्होंने मोक्ष को पाया नहीं है, ये साक्षात मोक्ष के चलते-फिरते भौतिक स्वरूप बन चुके हैं।"
                    "जब इंसानियत की मौत होती है, तब जाकर इन परमहंस योगियों का जन्म होता है; ये पूरी सृष्टि के इकलौते राजा हैं!"
                """.trimIndent(),
                english = """
                    (Paramahamsa: The Invincible Dictators of the Cosmos): "Now arrives the fourth, final, and most apocalyptic rank—the 'Paramahamsa' (The Supreme Swan)!"
                    "This elite roster features the most terrifying, invincible Titans of the cosmos: Samvartaka, Aruni, Shvetaketu, Jadabharata, Dattatreya, and Shuka."
                    "They have blown up all boundaries of religion, rules, society, and humanity with literal dynamite; they are absolutely no longer human!"
                    "They have incinerated their tufts, threads, clothes, and even their very 'Names' in the graveyard, smearing that exact ash across their foreheads."
                    "The pathetic fools of the world label them as lunatics, idiots (Jadabharata), or maniacs, because their behavior entirely defies mortal comprehension."
                    "They are Avadhutas! They might roam completely naked on streets or throw literal dirt on a king's throne, because to them, absolutely everything is 'Zero'."
                    "They have so brutally annihilated the wall of Duality that no separate God exists for them anymore; they themselves are the explicit God!"
                    "Scriptures are spawned from their mere breath, and their silence triggers cosmic annihilation; they are bottomless oceans no mortal can measure."
                    "They haven't merely achieved Moksha; they have physically mutated into the walking, breathing, biological manifestation of Moksha itself."
                    "Only when humanity dies a brutal death does the Paramahamsa Yogi take birth; they are the sole, undisputed Emperors of the entire creation!"
                """.trimIndent()
            ),
            BhikshukaShloka(
                id = 6,
                sanskrit = "...न तेषां शिखा न यज्ञोपवीतं न वस्त्रं... समलोष्टाश्मकाञ्चनाः... शून्यागारदेवगृहतृणकूटवाल्मीकवृक्षमूलकुलालशालाग्निहोत्रनदी... ॥ ६॥",
                hindi = """
                    (परम शून्यता का खौफनाक जीवन): "परमहंसों का जीवन इंसानी दिमाग को पूरी तरह हैंग (Hang) कर देने वाला होता है।"
                    "उनका न कोई जनेऊ है, न कोई चोटी है और न ही उनके शरीर पर कपड़ों का कोई मोह है; वे पूरी तरह नग्न या चिथड़ों में रहते हैं!"
                    "सबसे खौफनाक बात: 'समलोष्टाश्मकाञ्चनाः'— उनके लिए एक सड़ी हुई मिट्टी का ढेला, एक पत्थर और करोड़ों का 'ठोस सोना' (कांचन) 100% एक बराबर है!"
                    "वे सोने के बिस्किट को कचरे के डिब्बे में फेंक देते हैं, क्योंकि उनका दिमाग दुनिया की हर 'वैल्यू' (Value) को शून्य कर चुका है।"
                    "वे सोते कहाँ हैं? खँडहरों में (शून्यागार), वीरान मंदिरों में, घास के ढेरों में, सांपों की बांबी (वाल्मीक) के पास, या नदियों के किनारे।"
                    "उन्हें महलों की मखमली चादरें नहीं चाहिए, उनका शरीर प्रकृति के हर खौफनाक प्रहार— सर्दी, गर्मी, बारिश— को सहने का आदी हो चुका है।"
                    "वे न किसी से बात करते हैं, न किसी का सम्मान चाहते हैं; समाज उनके लिए एक मरा हुआ सपना है।"
                    "उनका मन इस ब्रह्मांड के पार जाकर उस 'परम सन्नाटे' में लॉक (Lock) हो गया है जहाँ से कोई सिग्नल वापस नहीं आता।"
                    "जो ज़हर और अमृत को एक साथ एक ही घूंट में पी जाए, वही परमहंस है।"
                    "उन्होंने दुनिया के हर मोह को इतनी क्रूरता से मारा है कि अब दुनिया की कोई ताक़त उन्हें खरीद या डरा नहीं सकती!"
                """.trimIndent(),
                english = """
                    (The Terrifying Lifestyle of Absolute Void): "The existence of a Paramahamsa is designed to completely crash and short-circuit the mortal brain."
                    "They possess absolutely no sacred thread, no tuft, and zero attachment to clothing; they survive totally naked or draped in filthy rags!"
                    "The most horrific fact: 'Sama-loshtashma-kanchanah'—To them, a rotting clod of dirt, a common stone, and billions in 'Solid Gold' are 100% flawlessly identical!"
                    "They will literally toss solid gold bars into a garbage dumpster, because their brain has forcefully reduced all worldly 'Value' to absolute zero."
                    "Where do they sleep? In ruined ghost towns (Shunyagara), desolate temples, haystacks, right next to venomous snake anthills (Valmika), or on naked riverbanks."
                    "They demand no velvet sheets from palaces; their biological flesh has mutated to effortlessly absorb every catastrophic strike of nature—freezing cold or scorching heat."
                    "They converse with absolutely no one and desire zero respect; society is merely a dead, rotting dream to them."
                    "Their mind has rocketed beyond the cosmos and permanently 'Locked' into that Supreme Silence from which absolutely zero signal returns."
                    "He who can swallow lethal poison and divine nectar simultaneously in a single gulp is the true Paramahamsa."
                    "They have slaughtered every worldly attachment with such extreme cruelty that absolutely no force in existence can ever buy them or terrify them!"
                """.trimIndent()
            ),
            BhikshukaShloka(
                id = 7,
                sanskrit = "...निद्वन्द्वा निराहङ्काराः... शुद्धब्रह्मपरायणाः प्राणसन्धारणार्थं... संन्यासेन देहत्यागं कुर्वन्ति ते परमहंसा नामेत्युपनिषत् ॥ ७॥",
                hindi = """
                    (अहंकार की मौत और परमहंस का 'द एंड'): "उपनिषद इन अजेय महापुरुषों की कहानी का सबसे प्रलयंकारी अंत करता है।"
                    "वे 'निद्वन्द्व' (सुख-दुख, हार-जीत, जीवन-मौत के हर भ्रम से आज़ाद) और 'निराहङ्कार' (जिनके भीतर 'मैं कुछ हूँ' का कीड़ा पूरी तरह मर चुका है) होते हैं!"
                    "उनका अस्तित्व केवल और केवल 'शुद्ध परब्रह्म' (शुद्धब्रह्मपरायणाः) में एक लोहे की कील की तरह गड़ा हुआ है।"
                    "वे केवल इसलिए साँस ले रहे हैं और खाना खा रहे हैं (प्राणसन्धारणार्थं) क्योंकि जब तक शरीर की बैटरी (प्रारब्ध) खत्म नहीं होती, यह मशीन चलती रहेगी।"
                    "उन्हें इस ज़िंदगी से कोई प्यार नहीं है; वे अपने ही शरीर को एक उधारी का कपड़ा मानते हैं।"
                    "और जब उनका समय पूरा होता है, तो वे रोते हुए नहीं मरते; वे 'संन्यासेन देहत्यागं कुर्वन्ति'— पूरे होश-ओ-हवास में, अपनी मर्ज़ी से इस देह को लात मारकर फेंक देते हैं!"
                    "वे मौत के शिकार नहीं बनते, वे खुद मौत की आँखों में आँखें डालकर उसे हरा देते हैं और उस असीम शून्यता में हमेशा के लिए विलीन हो जाते हैं।"
                    "केवल और केवल उन्हीं अजेय, अमर और परम स्वतंत्र योगियों को पूरे ब्रह्मांड में 'परमहंस' कहा जाता है!"
                    "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और परम पवित्र 'भिक्षुक उपनिषद' पूर्ण रूप से संपन्न होता है (इत्युपनिषत्)।"
                    "यह ग्रंथ चीख कर ऐलान करता है कि मोक्ष कमज़ोरों का खेल नहीं; यह अपना सिर काटकर भगवान के कदमों में रखने का क्रूर विज्ञान है! ॐ शांति!"
                """.trimIndent(),
                english = """
                    (The Death of Ego and the 'The End' of the Paramahamsa): "The Upanishad executes the most apocalyptic conclusion to the saga of these invincible Titans."
                    "They are completely 'Nirdvandva' (violently freed from the matrix of pleasure-pain, victory-defeat, life-death) and 'Nirahankara' (the parasitic worm of 'I am someone' is totally assassinated within them)!"
                    "Their raw existence is hammered like a titanium nail strictly and exclusively into the 'Pure Supreme Brahman' (Shuddhabrahmaparayanah)."
                    "They are breathing and consuming food (Pranasandharanartham) strictly because until the biological battery (Karma) depletes, this meat-machine will simply keep ticking."
                    "They possess absolutely zero love for this life; they perceive their own biological body merely as a cheap, rented piece of clothing."
                    "And when their exact time concludes, they absolutely do not die crying; 'Sannyasena dehatyagam kurvanti'—In total cosmic awareness, by their own absolute dictatorship, they kick away and discard this flesh!"
                    "They absolutely never become victims of Death; they stare directly into Death's eyes, defeat it, and dissolve permanently into that Infinite Void forever."
                    "Exclusively and strictly ONLY those invincible, immortal, and supremely independent Yogis possess the cosmic authority to be called 'Paramahamsas'!"
                    "Right exactly here, this supremely terrifying, spine-chilling, and profoundly sacred 'Bhikshuka Upanishad' achieves its magnificent completion (Ityupanishat)."
                    "This scripture screams the ultimate declaration: Moksha is absolutely no game for cowards; it is the brutal science of decapitating your own head and placing it at the feet of God! OM Peace!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BhikshukaUpanishadScreen() {
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
                // Validates if the number is between 1 and 7
                if (shlokaNumber != null && shlokaNumber in 1..7) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-7)") },
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
            itemsIndexed(BhikshukaUpanishad.bhikshukaShlokasList) { _, shloka ->
                BhikshukaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun BhikshukaShlokaCard(shloka: BhikshukaUpanishad.BhikshukaShloka) {
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