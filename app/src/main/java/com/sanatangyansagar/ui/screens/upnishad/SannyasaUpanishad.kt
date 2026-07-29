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
data class SannyasaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

val sannyasaShlokasList = listOf(
    SannyasaShloka(
        id = 1,
        sanskrit = "यदा तु विदितं सर्वं जगन्नास्तीति निश्चितम् । तदा संन्यस्य वै देही वासनोन्मूलनाय च ॥ १॥",
        hindi = """
            (संसार का खोखलापन और वैराग्य का विस्फोट): "जब इंसान के भीतर यह प्रलयंकारी सत्य एक परमाणु बम की तरह फटता है..."
            "कि यह पूरा ब्रह्मांड, इसके सारे रिश्ते, सारा धन और सारी सफलताएँ केवल एक छलावा, एक भ्रम और एक झूठा सपना हैं।"
            "जब उसे 100% निश्चित हो जाता है कि इस नश्वर 'जगत का असल में कोई अस्तित्व ही नहीं है' (जगन्नास्तीति निश्चितम्)।"
            "तब वह बुद्धिमान जीव इस खोखले समाज और इसके झूठे मोह-पाश को पूरी निर्ममता से लात मारकर 'संन्यास' ग्रहण कर लेता है।"
            "संन्यास कोई शौक नहीं है, यह अपनी ही 'वासनाओं' (Desires) को जड़ से उखाड़ कर जला देने का सबसे खौफनाक और क्रूर फैसला है।"
            "जब तक मन में एक भी वासना ज़िंदा है, तब तक इंसान एक ग़ुलाम है, चाहे वह राजा ही क्यों न हो।"
            "अपनी वासनाओं का गला घोंटने के लिए ही वह देहधारी अपने भौतिक जीवन को ज़िंदा रहते हुए श्मशान में बदल देता है।"
            "यह दुनिया के हर आकर्षण के चेहरे पर एक जोरदार तमाचा है।"
            "सच्चा वैराग्य किसी डर या मजबूरी से नहीं आता; वह तब आता है जब इंसान दुनिया की औकात को समझ लेता है।"
            "यहीं से उस खौफनाक आध्यात्मिक यात्रा की शुरुआत होती है, जहाँ इंसान भगवान बनने के लिए निकलता है।"
        """.trimIndent(),
        english = """
            (The Hollowness of the World and the Explosion of Vairagya): "When this apocalyptic truth detonates inside a human like an atomic bomb..."
            "That this entire cosmos, all its relationships, all wealth, and all successes are merely a pathetic illusion, a fake dream."
            "When he becomes 100% absolutely certain that this mortal 'world literally possesses zero existence' (Jagannastiti nishchitam)."
            "Then that awakened being ruthlessly kicks away this hollow society and its fake attachments, violently embracing 'Sannyasa'."
            "Sannyasa is no hobby; it is the most terrifying, brutal decision to uproot and burn one's own core 'Desires' (Vasanas) to ashes."
            "As long as even a single microscopic desire is alive, the human is a pathetic slave, even if he is an emperor."
            "Strictly to strangle his own lusts to death, the physical being turns his living biological life into a literal graveyard."
            "This is a violently resounding slap across the face of every single worldly attraction."
            "True absolute detachment does not stem from fear; it violently erupts when a human realizes the pathetic worth of the universe."
            "Right here begins that terrifying spiritual crusade, where a mortal human embarks to literally mutate into God."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 2,
        sanskrit = "आत्मन्यग्नीन् समारोप्य त्यक्त्वा सर्वपरिग्रहान् । ब्रह्माण्डं च हित्वा सर्वं त्यजेद्बुधः ॥ २॥",
        hindi = """
            (आंतरिक अग्नि और ब्रह्मांड का महा-त्याग): "एक आम इंसान बाहरी आग में कर्मकांड करता है, लेकिन संन्यासी बाहरी आग को बुझा देता है।"
            "वह उस पवित्र अग्नि को अपने ही 'भीतर' (आत्मा में) स्थापित कर लेता है (आत्मन्यग्नीन् समारोप्य)।"
            "वह घर, ज़मीन, बैंक बैलेंस, कपड़े और यहाँ तक कि रिश्तों के 'परिग्रह' (Possessions) को भी नोच कर फेंक देता है।"
            "वह इस पूरे ब्रह्मांड को एक सड़े हुए तिनके के समान 'तुच्छ' समझकर उसका हमेशा के लिए त्याग कर देता है।"
            "उसका अपना कोई भौतिक घर नहीं बचता; वह पूरे ब्रह्मांड से अपना नाम और पता मिटा देता है।"
            "ज्ञानी पुरुष (बुधः) के लिए यह दुनिया एक ऐसा जेलखाना है जिसकी दीवारें उसने खुद अपने वैराग्य से तोड़ दी हैं।"
            "अब वह किसी से कुछ नहीं मांगता, न ही कुछ जमा करता है।"
            "उसकी कोई पहचान नहीं, कोई आधार कार्ड नहीं, कोई परिवार नहीं।"
            "वह ज़िंदा रहते हुए भी इस ब्रह्मांड के लिए एक मरा हुआ इंसान बन चुका है।"
            "यही एक सच्चे संन्यासी का सबसे पहला और सबसे कठोर कदम है।"
        """.trimIndent(),
        english = """
            (The Internal Fire and the Colossal Abandonment of the Cosmos): "An ordinary mortal performs rituals in physical fire, but a Sannyasin permanently extinguishes all external fires."
            "He violently internalizes and establishes that sacred cosmic fire directly within his own 'Soul' (Atmanyagnin samaropya)."
            "He ruthlessly tears away and discards every single 'Possession' (Parigraha)—houses, lands, wealth, clothing, and human relationships."
            "He perceives this entire infinite cosmos as a piece of rotting straw, executing a total, eternal abandonment of it."
            "He retains absolutely no physical home; he completely erases his name and coordinates from the fabric of the universe."
            "To the awakened master (Budha), this world is a pathetic prison whose walls he has violently shattered with absolute detachment."
            "He now begs nothing from anyone, nor does he hoard a single micro-particle of matter."
            "He possesses zero identity, zero legal existence, zero family bloodlines."
            "While his physical heart still beats, he has successfully mutated into a dead entity as far as this cosmos is concerned."
            "This is the very first and the most terrifyingly brutal step of an authentic monk."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 3,
        sanskrit = "सशिखं वपनं कृत्वा बहिःसूत्रं त्यजेद्बुधः । यदक्षरं परं ब्रह्म तत्सूत्रमिति धारयेत् ॥ ३॥",
        hindi = """
            (बाहरी धागों का खात्मा और असली जनेऊ): "धर्म का दिखावा करने वाले बाहरी प्रतीकों को भी वह ज्ञानी संन्यासी उखाड़ फेंकता है।"
            "वह अपने सिर की 'शिखा' (चोटी) को काट देता है और शरीर पर पहने हुए 'यज्ञोपवीत' (पवित्र जनेऊ) को भी तोड़कर फेंक देता है।"
            "उसे यह भली-भांति पता है कि सूत (कपास) के धागे कभी किसी इंसान को भगवान से नहीं मिला सकते।"
            "उसका असली जनेऊ क्या है? 'अक्षरं परं ब्रह्म'— वह अमर और अविनाशी परमेश्वर ही उसका असली धागा है!"
            "वह अपनी चेतना को उस परम सत्य के साथ ऐसे बाँध लेता है कि फिर उसे कोई दुनियावी कैंची काट नहीं सकती।"
            "समाज उसे धर्म-भ्रष्ट कह सकता है, लेकिन वह समाज के बनाए हुए धर्म से अरबों मील आगे निकल चुका है।"
            "उसके लिए कर्मकांड और बाहरी पूजा-पाठ केवल बच्चों का खेल रह गए हैं।"
            "वह अब धागों का मोहताज नहीं; उसने सीधे ब्रह्मांड की सबसे बड़ी ऊर्जा को पहन लिया है।"
            "जब मन ही साक्षात ब्रह्म बन गया हो, तो शरीर पर धागे लटकाने का क्या तुक है?"
            "यही वह खौफनाक आज़ादी है जहाँ योगी धर्म के नियमों को भी अपने पैरों तले रौंद देता है।"
        """.trimIndent(),
        english = """
            (The Annihilation of External Threads and the True Sacred Thread): "The awakened Sannyasin violently rips off even the external, theatrical symbols of religion."
            "He mercilessly shaves off his 'Shikha' (tuft of hair) and violently snaps and discards his 'Yajnopavita' (sacred cotton thread)."
            "He knows with absolute terrifying certainty that physical cotton strings can never possibly connect a human to God."
            "What exactly is his true sacred thread? 'Aksharam Param Brahma'—That immortal, indestructible Supreme God is his only true thread!"
            "He ties his raw consciousness to that absolute truth so brutally that no worldly scissors can ever sever it."
            "Society might curse him as a religious degenerate, but he has skyrocketed billions of miles beyond society's pathetic, man-made religions."
            "To him, physical rituals and external worship are reduced to mere childish, theatrical games."
            "He is no longer a slave to cotton threads; he has literally draped himself in the supreme cosmic energy of the universe."
            "When the mind itself has physically mutated into God, what is the logic of hanging pathetic strings on a biological body?"
            "This is that terrifying cosmic freedom where the Yogi violently tramples even religious laws beneath his feet."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 4,
        sanskrit = "अभयं सर्वभूतेभ्यो मत्तः स्वाहेति मन्त्रयन् । दण्डं कमण्डलुं चैव जगृहाद्ब्रह्मवित्तमः ॥ ४॥",
        hindi = """
            (पूर्ण अभय दान और सन्यास का खौफनाक संकल्प): "यह संन्यास का सबसे रोंगटे खड़े कर देने वाला ब्रह्मांडीय संकल्प है!"
            "वह संन्यासी दोनों हाथ उठाकर पूरे ब्रह्मांड के जीवों को अपनी वासनाओं की आहुति देते हुए चीखता है— 'मत्तः स्वाहा!'"
            "'मेरे द्वारा इस दुनिया के किसी भी इंसान, जानवर या जीव को कभी कोई डर नहीं होगा! मैंने सबको अभय दान दे दिया!'"
            "अब न तो वह किसी का दुश्मन है और न ही किसी का दोस्त; वह पूरे संसार के लिए पूरी तरह से 'हानिरहित' (Harmless) हो गया है।"
            "वह अपने अहंकार, अपने क्रोध और अपनी हिंसा को उसी मंत्र के साथ आग में जलाकर राख कर देता है।"
            "केवल इस खौफनाक शपथ को लेने के बाद ही वह 'ब्रह्मवित्तमः' (ब्रह्म को जानने वाला श्रेष्ठ योगी) हाथ में अपना दण्ड और कमंडल उठाता है।"
            "वह दण्ड किसी को पीटने के लिए नहीं, बल्कि अपने ही मन को अनुशासन में रखने का प्रतीक है।"
            "और वह कमंडल बताता है कि उसकी ज़िंदगी अब केवल पानी की तरह निर्मल और प्रवाहित है।"
            "उसने दुनिया से अपना नाम हमेशा के लिए मिटा दिया है; अब वह केवल एक 'ब्रह्मांडीय ऊर्जा' बनकर जी रहा है।"
            "जिस इंसान से किसी को डर नहीं लगता, असल में मौत भी उसी इंसान से सबसे ज़्यादा डरती है।"
        """.trimIndent(),
        english = """
            (The Vow of Absolute Fearlessness and the Terrifying Resolve): "This is the most spine-chilling, cosmic resolution of Sannyasa!"
            "Raising his hands to the cosmos, sacrificing his very lusts, the monk roars to every creature in the universe—'Mattah Swaha!'"
            "'From this microsecond, absolutely no human, beast, or entity shall ever fear me! I grant absolute amnesty to the cosmos!'"
            "He is now absolutely no one's enemy and no one's friend; he has mutated into a completely, perfectly 'Harmless' entity to creation."
            "He violently burns his own ego, his catastrophic wrath, and his inner violence to absolute ashes with that single mantra."
            "Strictly only after taking this terrifying oath does that 'Brahmavittama' (Supreme Knower of God) grip his wooden staff and water pot."
            "That staff is absolutely not a weapon to strike others, but a brutal symbol of dominating and executing his own mind."
            "And that water pot physically signifies that his biological existence is now flawlessly pure and constantly flowing like raw water."
            "He has permanently erased his name from the world's memory; he now exists strictly as an anonymous cosmic energy."
            "The human whom absolutely no one fears is precisely the exact human whom Death itself fears the most."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 5,
        sanskrit = "एकाकी सञ्चरेन्नित्यं सिद्ध्यर्थमद्वितीयकः । अरण्ये निर्जने देशे मृगवच्चरते मुनिः ॥ ५॥",
        hindi = """
            (भयानक एकांत और जंगली जानवर जैसी आज़ादी): "संन्यास कोई समाज सेवा या आश्रम चलाने का बिज़नेस नहीं है।"
            "यह उपनिषद चीख कर कहता है कि सच्चा संन्यासी हमेशा, हर पल पूरी तरह 'अकेला' (एकाकी) ही भटकता है!"
            "वह परम सिद्धि को पाने के लिए अपने साथ किसी चेले-चपाटी या भीड़ को नहीं रखता; वह अद्वितीय (अकेला) रहता है।"
            "वह घने और खौफनाक जंगलों में (अरण्ये) या उन सुनसान जगहों पर चला जाता है जहाँ इंसानों की परछाई तक नहीं पड़ती।"
            "वहाँ वह एक 'जंगली जानवर' (मृगवच्चरते) की तरह पूरी तरह बेपरवाह और स्वतंत्र होकर जीता है।"
            "जैसे जंगल के शेर को किसी समाज के नियम की फिक्र नहीं होती, वैसे ही वह मुनि समाज के हर नियम को फाड़ चुका होता है।"
            "उसे इंसानों से बात करने में कोई दिलचस्पी नहीं है; उसकी बातचीत सीधे उस परब्रह्म से होती है।"
            "जो भीड़ में रहता है, उसका मन कभी भगवान को नहीं पा सकता। जो अकेला होता है, वही ब्रह्मांड को जीतता है।"
            "उसे न तो जंगली जानवरों का खौफ है और न ही भूख से मरने का।"
            "वह अपनी 'आत्मा' की असीम गुफा में इस तरह छिप गया है कि दुनिया की कोई ताक़त उसे वहाँ से बाहर नहीं निकाल सकती।"
        """.trimIndent(),
        english = """
            (Terrifying Solitude and the Freedom of a Wild Beast): "Sannyasa is absolutely not a business of running ashrams or performing social service."
            "This Upanishad violently screams that a genuine monk roams completely, terrifyingly 'Alone' (Ekaki) every single microsecond!"
            "To achieve the absolute cosmic zenith, he gathers no pathetic disciples or crowds; he remains flawlessly singular and solitary."
            "He vanishes into horrifyingly dense jungles (Aranye) or utterly desolate terrains where not even a human shadow falls."
            "There, he survives exactly like a 'Wild Beast' (Mrigavat)—completely reckless, unapologetic, and flawlessly free."
            "Just as a jungle lion gives zero care for societal laws, that sage has brutally ripped apart every single human boundary."
            "He possesses zero interest in conversing with mortals; his communication is a direct, atomic transmission with the Supreme Brahman."
            "He who lingers in crowds can never seize God. He who stands terrifyingly alone is the one who conquers the entire cosmos."
            "He possesses absolutely no fear of being slaughtered by wild beasts, nor the microscopic fear of starving to death."
            "He has hidden himself so deeply in the infinite cave of his 'Soul' that no force in existence can ever drag him out."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 6,
        sanskrit = "माधुकरीं भिक्षां चरन्... न जिह्वया रसं वेत्ति न च कामं न कांचनम् ॥ ६॥",
        hindi = """
            (स्वाद की मौत और काम-कांचन का महा-त्याग): "एक खौफनाक संन्यासी कभी किसी एक घर से पेट भरकर खाना नहीं मांगता।"
            "वह 'माधुकरी' भिक्षा करता है—जैसे एक मधुमक्खी कई फूलों से थोड़ा-थोड़ा रस लेती है, वैसे ही वह कई घरों से थोड़ा-थोड़ा अन्न मांगता है।"
            "ताकि किसी एक गृहस्थ पर उसके भोजन का बोझ न पड़े। लेकिन सबसे भयंकर बात यह है कि उसकी 'जीभ' (Taste) मर चुकी है।"
            "कोई उसे शाही पकवान दे या सड़ी हुई सूखी रोटी, वह अपनी जीभ से कोई 'स्वाद' (रस) महसूस ही नहीं करता!"
            "वह अन्न को केवल शरीर रुपी मशीन के टैंक में ईंधन (Fuel) की तरह डालता है, मज़ा लेने के लिए नहीं।"
            "उसके भीतर 'काम' (Lust/वासना) और 'कांचन' (Gold/पैसा) के प्रति आकर्षण का हमेशा के लिए क्रूर वध हो चुका है।"
            "दुनिया के दो सबसे बड़े ज़हर— वासना और दौलत— अब उसके लिए मिट्टी और राख से भी बदतर हैं।"
            "जिस इंसान की जीभ और जननेंद्रिय (Sexuality) उसके 100% कंट्रोल में हैं, वही ब्रह्मांड का असली सम्राट है।"
            "उसे कोई भी दौलत खरीद नहीं सकती और कोई भी अप्सरा डिगा नहीं सकती।"
            "वह बाहर से भिखारी ज़रूर दिखता है, लेकिन असल में उसने दुनिया के हर राजा को अपनी मानसिक ताक़त से हरा दिया है।"
        """.trimIndent(),
        english = """
            (The Death of Taste and the Absolute Rejection of Lust and Gold): "A terrifying Sannyasin never begs for a full meal from a single house."
            "He executes 'Madhukari' begging—just as a bee extracts a micro-drop of nectar from multiple flowers, he gathers fragments of food from many doors."
            "This ensures absolutely zero burden falls on any single householder. But the most horrific fact is that his 'Tongue' (Taste) has died."
            "Whether handed royal delicacies or rotting dry crusts, he physically registers absolutely zero 'Taste' (Rasa) on his tongue!"
            "He merely dumps food into his biological machine exactly like fuel into a tank; he absolutely never eats for pleasure."
            "Within his psychological core, the attraction toward 'Kama' (Lust) and 'Kanchana' (Gold) has been brutally and permanently assassinated."
            "The universe's two deadliest poisons—lust and wealth—are now vastly inferior to literal dirt and ashes to him."
            "The entity who exerts 100% tyrannical control over his tongue and sexuality is the absolute, undisputed Emperor of the cosmos."
            "Absolutely no wealth in existence can buy him, and no celestial nymph possesses the status to make him flinch."
            "He definitely appears as a beggar externally, but internally, he has violently defeated every mortal king with his sheer psychological supremacy."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 7,
        sanskrit = "निन्दां स्तुतिं तथा मानमपमानं च वर्जयेत् । समलोष्टाश्मकाञ्चनः समः शत्रौ च मित्रे च ॥ ७॥",
        hindi = """
            (मान-अपमान की हत्या और असीम समता): "दुनिया में सबसे मुश्किल काम है अपने 'सम्मान' की इच्छा को मारना, पर संन्यासी इसे बेरहमी से कुचल देता है।"
            "कोई उसे गालियां दे, उस पर थूके (निंदा/अपमान) या कोई उसके पैरों में गिरकर उसकी पूजा करे (स्तुति/मान)..."
            "वह दोनों ही स्थितियों में पत्थर की तरह सुन्न और भावहीन (Emotionless) रहता है; उसका अहंकार कोई प्रतिक्रिया नहीं देता।"
            "उसके लिए एक 'मिट्टी का ढेला' (लोष्ट), एक 'साधारण पत्थर' (अश्म) और करोड़ों का 'ठोस सोना' (कांचन) बिल्कुल एक बराबर हैं!"
            "वह सोने के बिस्किट को और पत्थर के टुकड़े को एक ही नज़र से देखता है; दोनों ही उसके लिए केवल ज़मीन का कचरा हैं।"
            "उसका इस दुनिया में कोई 'दोस्त' नहीं है जो उसे खुश कर सके, और कोई 'दुश्मन' नहीं है जो उसे डरा सके।"
            "मित्र और शत्रु दोनों ही उसे एक ही 'आत्मा' के रूप में दिखाई देते हैं, इसलिए वह दोनों पर एक जैसी दया करता है।"
            "यह वह खौफनाक मानसिक अवस्था है जहाँ इंसान का मन पूरी तरह से 'फ्लैट' (Flatline) हो जाता है।"
            "वह दुनिया के द्वैत (Duality) की आग को पार करके उस अद्वैत बर्फ में बदल गया है जो कभी पिघलती नहीं।"
            "यही है संन्यास का वह परम शिखर, जहाँ दुनिया की कोई भी चाल योगी को भटका नहीं सकती।"
        """.trimIndent(),
        english = """
            (The Assassination of Honor and Disgrace, and Absolute Equanimity): "The hardest task in the cosmos is killing the desire for 'Respect', but the Sannyasin ruthlessly crushes it to dust."
            "Whether society hurls brutal abuses and spits on him (Disgrace) or falls at his feet worshipping him like a God (Honor)..."
            "He remains as completely numb, paralyzed, and emotionless as a stone in both scenarios; his ego generates absolutely zero reaction."
            "To his eyes, a 'Clod of Dirt' (Loshta), an 'Ordinary Rock' (Ashma), and billions in 'Solid Gold' (Kanchana) are flawlessly identical!"
            "He views a solid gold bar and a piece of gravel with the exact same gaze; both are strictly terrestrial garbage to him."
            "He has absolutely no 'Friend' in this universe who can excite him, and zero 'Enemies' who possess the capability to terrify him."
            "He perceives both friend and foe strictly as the exact same 'Cosmic Soul', thus raining the exact same neutral compassion on both."
            "This is the terrifying psychological dimension where the human mind completely 'Flatlines' into absolute stillness."
            "He has violently crossed the raging fires of global Duality and mutated into an absolute non-dual ice that can never melt."
            "This is the absolute zenith of Sannyasa, where absolutely no worldly manipulation possesses the power to distract the Yogi."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 8,
        sanskrit = "कलेवरं कुणपमिव पश्यन् जरामरणशोकार्तिं त्यक्त्वा तिष्ठति निर्भयः ॥ ८॥",
        hindi = """
            (शरीर का शव बनना और मौत का क्रूर वध): "वह योगी एक ऐसा प्रलयंकारी काम करता है जो कोई आम इंसान सपने में भी नहीं सोच सकता।"
            "वह अपने ही साँस लेते हुए, चलते-फिरते भौतिक शरीर को एक सड़े हुए 'मुर्दे' (कुणपमिव) की तरह देखता है!"
            "उसने 'मैं शरीर हूँ' इस झूठे भ्रम का इतनी बेरहमी से कत्ल कर दिया है कि अब शरीर का दर्द उसकी आत्मा तक नहीं पहुँचता।"
            "जब कोई इंसान ज़िंदा रहते हुए खुद को मुर्दा मान ले, तो दुनिया की कौन सी ताक़त उसे मार सकती है?"
            "वह शरीर के बुढ़ापे (जरा), मौत (मरण), दुख (शोक) और भयानक पीड़ा (आर्ति) को लात मारकर हमेशा के लिए फेंक देता है।"
            "वह ब्रह्मांड के उस चरम 'निर्भय' (Fearless) बिंदु पर जाकर खड़ा हो जाता है, जहाँ मौत भी उसे देखकर काँपने लगती है।"
            "उसे पता है कि जो पैदा हुआ है, जो बीमार पड़ेगा और जो मरेगा—वह केवल यह हाड़-मांस का पुतला है, वह (आत्मा) नहीं।"
            "इस खौफनाक अलगाव (Detachment) के कारण, वह एक अमर चट्टान की तरह अजेय होकर जीता है।"
            "चाहे कोई उसका हाथ काट दे, उसे रत्ती भर भी दर्द या अफ़सोस नहीं होता, क्योंकि 'वह' तो उस शरीर में है ही नहीं!"
            "यह है सनातन धर्म का वो सुप्रीम वैराग्य, जहाँ इंसान मौत की आँखों में आँखें डालकर उसे हरा देता है।"
        """.trimIndent(),
        english = """
            (The Body as a Corpse and the Brutal Slaughter of Death): "That Yogi executes an apocalyptic psychological act that ordinary mortals cannot even fathom in nightmares."
            "He literally, flawlessly perceives his own breathing, walking, biological physical body strictly as a rotting, dead 'Corpse' (Kunapamiva)!"
            "He has so brutally assassinated the fake illusion of 'I am this body' that physical agony absolutely cannot penetrate his soul."
            "When a human being, while his heart is still beating, unconditionally accepts himself as a corpse, what force in existence can possibly kill him?"
            "He violently kicks away and permanently discards bodily decay (Jara), death (Marana), immense grief (Shoka), and horrific physical agony (Arti)."
            "He ascends and stands on that absolute cosmic peak of 'Fearlessness' (Nirbhaya) where Death itself begins to violently tremble looking at him."
            "He knows with lethal certainty that what is born, what sickens, and what dies—is strictly this puppet of flesh, definitely not Him (the Soul)."
            "Because of this terrifying, atomic detachment, he survives as a completely immortal, invincible, unbreakable cosmic mountain."
            "Even if someone literally hacks off his arm, he registers zero pain or regret, because 'He' is fundamentally not inside that flesh anymore!"
            "This is the supreme, ultimate detachment of Sanatana Dharma, where a human stares directly into the eyes of Death and ruthlessly defeats it."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 9,
        sanskrit = "शून्यागारे वृक्षमूले गुहायां वा वसेन्मुनिः । अनिकेतः स्थिरमतिरमुत्रैवावतिष्ठते ॥ ९॥",
        hindi = """
            (बेघर होने का प्रलयंकारी सत्य और शून्यता का घर): "वह योगी इंसानी बस्तियों को छोड़कर उन खौफनाक जगहों पर जाता है जहाँ कोई नहीं जाता।"
            "वह किसी उजाड़, खँडहर और भूतों वाले घर (शून्यागारे) में, किसी पेड़ की जड़ के पास, या किसी घोर अँधेरी गुफा में अपना डेरा डालता है।"
            "वह 'अनिकेत' (बिना घर का) है; पूरे ब्रह्मांड में उसकी अपनी कोई ज़मीन, कोई छत और कोई बिस्तर नहीं है।"
            "बाहर से वह एक आवारा और बेघर भिखारी है, जिसके पास छिपने के लिए कोई जगह नहीं।"
            "लेकिन अंदर से उसकी बुद्धि (मति) एक विशाल पर्वत की तरह 'स्थिर' (Unshakeable) हो चुकी है।"
            "वह भौतिक घरों को छोड़कर उस परम 'शून्यता' (परब्रह्म) के घर में जाकर बैठ गया है, जिसे कोई भूकंप नहीं गिरा सकता।"
            "उसे न तो सर्दी में रजाई चाहिए और न गर्मी में छत; उसका शरीर प्रकृति के हर खौफनाक प्रहार को सहने का आदी हो चुका है।"
            "वह दुनिया के लोगों की तरह कल की चिंता नहीं करता, क्योंकि उसने 'कल' (Future) का ही कत्ल कर दिया है।"
            "वह हमेशा उसी एक पारलौकिक और असीम अवस्था (अमुत्रैव) में डूबा रहता है।"
            "जिसका कोई घर नहीं होता, असल में यह पूरा असीम ब्रह्मांड ही उसी की जागीर बन जाता है।"
        """.trimIndent(),
        english = """
            (The Apocalyptic Truth of Homelessness and the Home of the Void): "That Yogi abandons human settlements and marches into terrifying domains where absolutely no one dares to tread."
            "He camps in utterly desolate, ruined, ghost-ridden structures (Shunyagare), at the naked roots of wild trees, or inside pitch-black, horrific caves."
            "He is 'Aniketa' (Absolutely Homeless); in this entire infinite cosmos, he claims zero land, zero roof, and zero bed as his own."
            "Externally, he appears as a vagabond, a homeless beggar possessing absolutely nowhere to hide from the elements."
            "But internally, his intellect (Mati) has mutated to become as terrifyingly 'Unshakeable' (Sthira) as a colossal cosmic mountain."
            "Abandoning fragile biological houses, he has permanently relocated into the absolute mansion of the 'Supreme Void', which no earthquake can ever shatter."
            "He begs for no blankets in the freezing winter nor roofs in the scorching summer; his flesh is adapted to absorb every horrific strike of nature."
            "He does not harbor pathetic anxiety for tomorrow like mortals do, because he has literally assassinated the very concept of the 'Future'."
            "He remains eternally and violently drowned in that single, transcendent, and boundless cosmic state (Amutraiva) every microsecond."
            "He who possesses zero physical home is the exact entity who ultimately inherits this entire infinite universe as his personal undisputed empire."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 10,
        sanskrit = "बालोन्मत्तपिशाचवदेकाकी सञ्चरन्... न वर्णाश्रमधर्मोऽस्ति न च शास्त्रं न च क्रमः ॥ १०॥",
        hindi = """
            (पागलपन का चोला और धर्म-शास्त्रों का विनाश): "समाज से बचने के लिए वह अवधूत जानबूझकर ऐसा भयानक रूप धारण करता है कि लोग उससे दूर रहें।"
            "वह कभी एक 'मासूम बच्चे' (बाल) की तरह हँसता है, कभी एक 'खतरनाक पागल' (उन्मत्त) की तरह हरकतें करता है, और कभी 'भूत-पिशाच' की तरह खौफनाक नज़र आता है!"
            "वह अकेला (एकाकी) ही पूरे ब्रह्मांड में भटकता है; उसे दुनिया की नज़रों में 'समझदार' दिखने की कोई बीमारी नहीं है।"
            "उसके लिए समाज के बनाए गए ब्राह्मण, क्षत्रिय जैसे 'वर्ण' और ब्रह्मचर्य, गृहस्थ जैसे 'आश्रम' के सारे नियम जलकर राख हो चुके हैं!"
            "उसके लिए अब किसी भी धार्मिक 'शास्त्र' का कोई आदेश लागू नहीं होता; वह शास्त्रों के पार जा चुका है।"
            "उसके लिए जीवन का कोई 'क्रम' (Routine) नहीं है; वह कब सोता है, कब जागता है, इसका कोई नियम नहीं।"
            "वह ब्रह्मांड का सबसे बड़ा 'विद्रोही' (Rebel) है, जिसने इंसानियत के हर छोटे-बड़े नियम की धज्जियां उड़ा दी हैं।"
            "वह पागल दिखता है, लेकिन असल में वह दुनिया का इकलौता इंसान है जो पूरी तरह से 'होश' में जाग गया है।"
            "दुनिया की नज़रों में गिरकर ही वह भगवान की नज़रों में सबसे ऊपर उठ गया है।"
            "जब कोई नियम उसे बाँध ही नहीं सकता, तो वह साक्षात परम स्वतंत्र 'ईश्वर' ही तो है।"
        """.trimIndent(),
        english = """
            (The Cloak of Insanity and the Annihilation of Scriptures): "To violently repel society, that Avadhuta intentionally adorns such a horrific persona that mortals flee from him."
            "He sometimes laughs like an innocent 'Infant' (Bala), sometimes behaves like a 'Lethal Lunatic' (Unmatta), and sometimes appears as terrifying as a 'Wild Ghost' (Pishacha)!"
            "He wanders completely and utterly 'Alone' (Ekaki); he suffers from zero pathetic disease of wanting to look 'sane' in the eyes of the world."
            "For him, every single societal rule of caste (Varna) and life-stages (Ashrama) has been brutally burnt to absolute ashes!"
            "Absolutely no commandment of any religious 'Scripture' applies to him anymore; he has rocketed infinitely beyond all scriptures."
            "He follows absolutely zero 'Routine' (Krama); there are no laws governing when he sleeps or when he wakes."
            "He is the ultimate cosmic 'Rebel' who has violently shredded every microscopic human rule into oblivion."
            "He appears to be a maniac, but in absolute reality, he is the ONLY human on Earth who has flawlessly and entirely 'Awakened'."
            "By brutally plummeting in the eyes of the world, he has skyrocketed to the absolute pinnacle in the eyes of God."
            "When absolutely no law in existence can bind him, he is nothing else but the literal, supremely independent 'God' Himself."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 11,
        sanskrit = "स्त्रीणां दर्शनं स्पर्शं संलापं च विवर्जयेत् । कामं क्रोधं तथा लोभं मोहं च भस्मसात् कृत्वा ॥ ११॥",
        hindi = """
            (वासना और क्रोध का क्रूर वध): "यह संन्यास का सबसे कठोर और भयंकर नियम है, जहाँ कोई छूट नहीं दी जाती।"
            "संन्यासी स्त्रियों (या कामुक आकर्षण) के 'दर्शन' (देखना), 'स्पर्श' (छूना), और 'संलाप' (बातचीत करने) का पूरी तरह से विनाश कर देता है।"
            "वह वासना के बीज को पनपने से पहले ही आग लगा देता है, क्योंकि एक छोटी सी चिंगारी भी योगी की सारी तपस्या जला सकती है।"
            "वह अपने भीतर पल रहे 'काम' (Lust) का सबसे बेरहमी से कत्ल करता है।"
            "वह अपने 'क्रोध' (Anger), 'लोभ' (Greed) और 'मोह' (Attachment) को उखाड़ कर तपस्या की भट्टी में 'भस्मसात्' (राख) कर देता है!"
            "जब तक मन में वासना और क्रोध की एक बूँद भी ज़िंदा है, तब तक इंसान एक जानवर से ज्यादा कुछ नहीं।"
            "वह अपने ही मन का सबसे बड़ा हत्यारा बन जाता है; वह अपने अंदर के हर उस जज़्बात को मार डालता है जो उसे कमज़ोर करता है।"
            "इस क्रूर आंतरिक युद्ध में कोई खून नहीं बहता, लेकिन इंसान का 'अहंकार' तड़प-तड़प कर मरता है।"
            "जब ये सारी कमज़ोरियां राख हो जाती हैं, तब उस राख से एक ऐसा अजेय महापुरुष जन्म लेता है जो भगवान के बराबर है।"
            "सच्चा संन्यास बाहर से कपड़े बदलना नहीं, बल्कि अंदर से अपने ही राक्षसों की गर्दन काटना है।"
        """.trimIndent(),
        english = """
            (The Brutal Slaughter of Lust and Wrath): "This is the most terrifying, ironclad law of Sannyasa, where absolutely zero leniency is ever granted."
            "The Sannyasin executes the complete annihilation of 'Looking at', 'Touching', and 'Conversing with' women (or any sexual attraction)."
            "He violently sets fire to the seed of lust before it even sprouts, knowing a single micro-spark can incinerate his entire colossal penance."
            "He executes the most ruthless, cold-blooded assassination of 'Kama' (Lust) breeding within his biological core."
            "He violently uproots his 'Anger' (Krodha), 'Greed' (Lobha), and 'Attachment' (Moha), throwing them into the furnace of penance until they are burnt to 'Ashes' (Bhasmasat)!"
            "As long as even a single microscopic drop of lust and wrath survives, a human is absolutely nothing more than a pathetic animal."
            "He becomes the ultimate assassin of his own mind; he slaughters every single emotion inside him that generates weakness."
            "No physical blood flows in this savage internal warfare, but the human 'Ego' dies a prolonged, agonizing, screaming death."
            "When all these pathetic biological weaknesses are reduced to ashes, an invincible Titan equal to God is born from that exact ash."
            "True Sannyasa is absolutely not changing external clothes; it is the brutal decapitation of your own internal demons."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 12,
        sanskrit = "अहङ्कारं च ममतां त्यक्त्वा सर्वत्र निर्ममः । अन्तरात्मनि सर्वमेव पश्यन्... ॥ १२॥",
        hindi = """
            ('मैं' और 'मेरा' की चिता और ब्रह्मांडीय दृष्टि): "उस योगी ने दुनिया की सबसे भयंकर बीमारी— 'अहंकार' (मैं कुछ हूँ) का वध कर दिया है।"
            "उसने 'ममता' (यह चीज़ मेरी है, यह इंसान मेरा है) को जड़ से उखाड़ कर उसकी चिता जला दी है।"
            "वह पूरे ब्रह्मांड में 'निर्मम' (बिना किसी लगाव के) होकर घूमता है; उसके लिए एक कचरे का डिब्बा और एक महल दोनों समान रूप से बेगाने हैं।"
            "उसका किसी भी चीज़ पर कोई कब्ज़ा नहीं है, और न ही कोई चीज़ उस पर कब्ज़ा कर सकती है।"
            "वह अपनी आँखें बंद करता है और बाहर की दुनिया को पूरी तरह से मिटा देता है।"
            "और फिर... उसे अपनी 'अन्तरात्मा' (Inner Soul) के भीतर ही यह पूरा का पूरा 'ब्रह्मांड' (सर्वमेव) साक्षात नज़र आता है!"
            "वह जान जाता है कि सितारे, आकाशगंगाएं, समुद्र और पहाड़ बाहर नहीं, बल्कि उसी के मन के भीतर धड़क रहे हैं।"
            "वह एक छोटा सा इंसान नहीं रहा, वह खुद ही वह अंतरिक्ष बन गया है जिसमें यह पूरी दुनिया तैर रही है।"
            "जिसने खुद को जीत लिया, उसने असल में पूरी सृष्टि को अपनी मुट्ठी में कैद कर लिया।"
            "यह कोई कल्पना नहीं, यह योग का वह प्रलयंकारी यथार्थ है जहाँ इंसान का दिमाग फटकर ब्रह्मांड बन जाता है।"
        """.trimIndent(),
        english = """
            (The Funeral Pyre of 'I' and 'Mine' and Cosmic Vision): "That Yogi has executed the assassination of the universe's most horrific disease—'Ahamkara' (The Ego: 'I am someone')."
            "He has violently uprooted 'Mamata' (The attachment: 'This is mine') and set its funeral pyre ablaze."
            "He wanders the entire cosmos as 'Nirmama' (Absolutely unattached); to him, a literal garbage dumpster and a royal palace are equally alien."
            "He possesses absolute zero claim over anything, and absolutely nothing possesses the capacity to claim him."
            "He forcefully shuts his physical eyes and completely annihilates the external reality from his consciousness."
            "And then... he literally, physically perceives the entire infinite 'Cosmos' (Sarvameva) pulsating directly within his own 'Inner Soul' (Antaratmani)!"
            "He flawlessly realizes that the stars, galaxies, oceans, and mountains are not outside, but are violently beating inside his own mind."
            "He is no longer a microscopic human; he has literally mutated into the exact cosmic space in which this entire universe floats."
            "He who has violently conquered his own self has, in absolute reality, locked the entire creation inside his fist."
            "This is no poetic imagination; this is the apocalyptic reality of Yoga where the human brain explodes and mutates into the cosmos."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 13,
        sanskrit = "चिन्मयः परमानन्दः शिवोऽहमिति भावयन् । अहमेव परं ब्रह्म... ॥ १३॥",
        hindi = """
            ('शिवोऽहम्' की ब्रह्मांडीय गर्जना): "अब वह योगी इंसान की सीमा को पार करके साक्षात भगवान की फ्रीक्वेंसी पर आ चुका है।"
            "वह लगातार इस प्रलयंकारी सत्य का अनुभव (भावयन्) करता है कि 'मैं मिट्टी का शरीर नहीं, मैं शुद्ध चेतना (चिन्मयः) हूँ!'"
            "वह आनंद की कोई छोटी बूँद नहीं, बल्कि वह खुद ही असीम 'परमानन्द' (Supreme Bliss) का धधकता हुआ महासागर बन चुका है।"
            "उसके रोम-रोम से यह ब्रह्मांडीय गर्जना उठती है— 'शिवोऽहम्!' (मैं ही शिव हूँ! मैं ही वह असीम ऊर्जा हूँ!)।"
            "दुनिया के देवता जहाँ झुकते हैं, वह योगी घोषणा करता है— 'अहमेव परं ब्रह्म' (केवल और केवल मैं ही वह साक्षात परमेश्वर हूँ!)।"
            "यह इंसानियत का सबसे बड़ा दुस्साहस है और ब्रह्मांड का सबसे बड़ा सच भी; उसने जीव और शिव के बीच का पर्दा जला दिया है।"
            "अब न कोई पूजा बाकी है, न कोई इबादत। क्योंकि जो पूजने वाला था, वह खुद ही पूज्य बन गया है।"
            "उसे अब किसी से डरने की ज़रूरत नहीं, क्योंकि जिससे डर लगता है, वह शक्ति भी उसी की अपनी है।"
            "जब मैं ही भगवान हूँ, तो मुझे कौन मारेगा? कौन मुझे नरक में भेजेगा?"
            "यह सनातन धर्म का वह खौफनाक और परम शिखर है, जहाँ इंसान सीधे ईश्वर के तख़्त पर जाकर बैठ जाता है।"
        """.trimIndent(),
        english = """
            (The Cosmic Roar of 'Shivoham' - I am Shiva): "Now, that Yogi has violently crossed the boundary of humanity and locked onto the exact frequency of God."
            "He constantly and physically experiences the apocalyptic truth: 'I am not this biological dirt, I am pure, radioactive Consciousness (Chinmayah)!'"
            "He is not a pathetic drop of joy; he has literally mutated into the blazing, infinite ocean of 'Supreme Bliss' (Paramananda) himself."
            "From every single pore of his being, this cosmic roar violently erupts—'Shivoham!' (I am Shiva! I am the ultimate infinite energy!)."
            "Where the gods of the world bow down, that Yogi fiercely declares—'Ahameva Param Brahma' (I, and I alone, am explicitly the Supreme God!)."
            "This is humanity's most terrifying audacity and the universe's absolute greatest truth; he has burnt the curtain between the mortal and God."
            "Absolutely no worship or prayer remains. Because the one who worshipped has violently mutated into the exact Entity to be worshipped."
            "He needs to fear absolutely no one, because the very force that induces fear is literally his own power."
            "When I myself am God, who possesses the capability to kill me? Who possesses the authority to send me to hell?"
            "This is the terrifying and absolute zenith of Sanatana Dharma, where the human marches directly and sits on the undisputed throne of God."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 14,
        sanskrit = "न बन्धोऽस्ति न मोक्षोऽस्ति न ज्ञाता न च दर्शनम् । सर्वं ब्रह्मैव... ॥ १४॥",
        hindi = """
            (बंधन और मोक्ष दोनों का प्रलयंकारी अंत): "ज्ञान की सबसे खौफनाक ऊँचाई पर पहुँचने के बाद, उपनिषद एक ऐसा सच बोलता है जो दिमाग फाड़ देता है।"
            "वह योगी कहता है: 'असल में न तो कोई बंधन (Bondage) है, और न ही कोई मोक्ष (Liberation) है!'"
            "क्योंकि जो आत्मा कभी किसी ज़ंजीर में बँधी ही नहीं थी, तो फिर उसे आज़ाद होने की ज़रूरत ही क्या है?"
            "बंधन और आज़ादी दोनों ही इस कमज़ोर मन के बनाए हुए झूठे खेल थे, जो अब राख हो चुके हैं।"
            "अब न कोई 'ज्ञाता' (जानने वाला) बचा है, न कोई 'ज्ञान' बचा है, और न ही कोई 'दृश्य' (देखने लायक चीज़) बची है।"
            "देखने वाला, जो देखा जा रहा है, और देखने की क्रिया—तीनों आपस में टकराकर एक भयंकर विस्फोट में शून्य हो गए हैं!"
            "केवल एक ही सत्य ठोस चट्टान की तरह खड़ा है— 'सर्वं ब्रह्मैव' (जो कुछ भी है, वह केवल और केवल परब्रह्म ही है)।"
            "मैं, तुम, यह दुनिया, यह ब्रह्मांड—सब कुछ उसी एक ऊर्जा का नाटक था।"
            "जब नाटक खत्म हो गया, तो केवल वह सन्नाटा और वह परम सत्य ही बचा रह गया।"
            "यह वह अवस्था है जहाँ इंसान का दिमाग काम करना बंद कर देता है और केवल परम शून्यता राज करती है।"
        """.trimIndent(),
        english = """
            (The Apocalyptic End of Both Bondage and Liberation): "Upon reaching the most terrifying altitude of supreme knowledge, the Upanishad spits a mind-shredding truth."
            "That Yogi roars: 'In absolute reality, there is absolutely zero Bondage, and absolutely zero Liberation (Moksha)!'"
            "Because if the Soul was never actually bound by any cosmic chain, what is the pathetic logic of needing to be freed?"
            "Both slavery and liberation were merely fake, theatrical illusions generated by a weak mind, which are now burnt to ashes."
            "There is no 'Knower' (Jnata) left, no 'Knowledge' left, and absolutely no 'Sight' (Darshana) left to be seen."
            "The observer, the object being observed, and the act of observation have violently collided and detonated into absolute zero!"
            "Only one single, indestructible truth stands like a cosmic monolith—'Sarvam Brahmaiva' (Absolutely everything is exclusively the Supreme Brahman alone)."
            "I, You, this World, this entire Universe—everything was merely a biological drama of that one single primordial energy."
            "When the theatrical drama permanently collapses, only that deafening silence and the Absolute Truth remain reigning."
            "This is the terrifying dimension where the human brain completely ceases to function, and strictly the Supreme Void rules as the absolute dictator."
        """.trimIndent()
    ),
    SannyasaShloka(
        id = 15,
        sanskrit = "अनेन संन्यासयोगेन... स मुक्तो भवति इत्युपनिषत् ॥ १५ ॥",
        hindi = """
            (मोक्ष की परम और अंतिम मुहर - 'द एंड'): "उपनिषद अपने इस ज्ञान रूपी परमाणु बम को अंतिम शब्द के साथ समाप्त करता है।"
            "जो भी मुमुक्षु साधक इस खौफनाक और प्रलयंकारी 'संन्यास योग' (संन्यास के असली विज्ञान) को अपनी रगों में उतार लेता है..."
            "जिसने बाहरी धागे तोड़ने के बजाय अपने मन की वासनाओं की गर्दन काट दी है, और जो 'अहं ब्रह्मास्मि' में स्थिर हो गया है।"
            "वह मनुष्य निश्चित रूप से, पूरे ब्रह्मांड की 100% गारंटी के साथ, जन्म, मृत्यु, सुख, दुख और माया के हर जाल से हमेशा के लिए 'मुक्त' हो जाता है!"
            "उसे दोबारा कभी इस दुनिया के कीचड़ में, किसी माँ के गर्भ में उल्टा लटकने का दर्द नहीं सहना पड़ेगा।"
            "वह समय, स्थान और मौत की हदों को चीरकर उस असीम शून्यता में हमेशा-हमेशा के लिए विलीन हो जाता है।"
            "यहीं पर यह महान, रौंगटे खड़े कर देने वाला और परम पवित्र 'संन्यास उपनिषद' अपनी पूरी महिमा के साथ संपन्न होता है (इत्युपनिषत्)।"
            "यह ग्रंथ चीख कर ऐलान करता है कि संन्यास कायरों के लिए नहीं है; यह मौत को सामने देखकर मुस्कुराने वाले पागलों का रास्ता है।"
            "जब 'मैं' (अहंकार) मरता है, तब 'मोक्ष' का जन्म होता है; जब इंसान मिटता है, तब भगवान का जन्म होता है।"
            "यही सनातन धर्म की वह सबसे महान, सबसे खौफनाक और आखिरी आज़ादी है! ॐ शांतिः शांतिः शांतिः!"
        """.trimIndent(),
        english = """
            (The Ultimate and Final Seal of Moksha - 'The End'): "The Upanishad detonates this atomic bomb of absolute wisdom with its final, definitive word."
            "Whosoever sincere seeker injects this terrifying, apocalyptic 'Sannyasa Yoga' (the true science of renunciation) directly into his veins..."
            "He who, instead of merely snapping external cotton threads, has brutally decapitated the lusts of his own mind, and anchored flawlessly in 'Aham Brahmasmi'."
            "That human being undoubtedly, with an ironclad 100% cosmic guarantee, becomes flawlessly, permanently 'Liberated' from every web of birth, death, and illusion!"
            "He will absolutely never again have to suffer the agonizing torture of hanging upside down in a mother's womb in the mud of this world."
            "Violently tearing through the pathetic limits of time, space, and death, he dissolves into that Infinite Void for all eternity."
            "Right exactly here, this majestic, spine-chilling, and profoundly sacred 'Sannyasa Upanishad' achieves its absolute glorious completion (Ityupanishat)."
            "This scripture roars the ultimate declaration: Sannyasa is absolutely not for cowards; it is the path of lunatics who smile staring directly at Death."
            "When the 'I' (Ego) violently dies, 'Moksha' is instantly born; when the human is utterly erased, God is flawlessly born."
            "This is Sanatana Dharma's most magnificent, most terrifying, and absolute final freedom! OM Peace, Peace, Peace!"
        """.trimIndent()
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SannyasaUpanishadScreen() {
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
                // Validates if the number is between 1 and 15
                if (shlokaNumber != null && shlokaNumber in 1..15) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-15)") },
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
            itemsIndexed(sannyasaShlokasList) { _, shloka ->
                SannyasaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SannyasaShlokaCard(shloka: SannyasaShloka) {
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