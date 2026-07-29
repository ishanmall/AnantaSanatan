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
data class KenaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KenaUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7)) // Light traditional background
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                // Attempt to parse the query into a number and scroll to it
                val shlokaNumber = query.toIntOrNull()
                // Limiting search strictly to the available 15 Shlokas
                if (shlokaNumber != null && shlokaNumber in 1..15) {
                    coroutineScope.launch {
                        // -1 because list indices start at 0
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

        // Shloka List
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(kenaShlokasList) { _, shloka ->
                KenaShlokaCard(shloka)
            }
        }
    }
}

@Composable
fun KenaShlokaCard(shloka: KenaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Shloka ${shloka.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFD84315) // Deep Orange
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Sanskrit Text
            Text(
                text = shloka.sanskrit,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))

            // Hindi Explanation
            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = shloka.hindi,
                fontSize = 15.sp,
                lineHeight = 22.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))

            // English Explanation
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = shloka.english,
                fontSize = 15.sp,
                lineHeight = 22.sp
            )
        }
    }
}

// Data List of Kena Upanishad - First 15 Shlokas
val kenaShlokasList = listOf(
    KenaShloka(
        id = 1,
        sanskrit = "केनेषितं पतति प्रेषितं मनः । केन प्राणः प्रथमः प्रैति युक्तः ।\nकेनेषितां वाचमिमां वदन्ति चक्षुः श्रोत्रं क उ देवो युनक्ति ॥ १ ॥",
        hindi = """
            किसकी इच्छा या प्रेरणा से यह मन अपने विषयों (सोचने) की ओर दौड़ता है?
            किसके द्वारा नियुक्त होकर मुख्य प्राण (जीवन शक्ति) शरीर में अपना कार्य शुरू करता है?
            किसकी इच्छा से मनुष्य इस वाणी को बोलता है जो हम सुनते हैं?
            और वह कौन सा प्रकाशमान देव (सत्ता) है जो हमारी आँखों और कानों को उनके काम में लगाता है?
            केन उपनिषद की शुरुआत इसी गहरे दार्शनिक प्रश्न से होती है, इसीलिए इसका नाम 'केन' (किसके द्वारा) है।
            यहाँ शिष्य अपने गुरु से जीवन और चेतना के मूल स्रोत के बारे में पूछ रहा है।
            हम सोचते हैं कि हमारा मन और शरीर स्वतंत्र रूप से काम कर रहे हैं, लेकिन ऐसा नहीं है।
            इन सभी भौतिक इंद्रियों के पीछे एक और सूक्ष्म और महान शक्ति काम कर रही है।
            यह उपनिषद हमें भौतिक शरीर से परे जाकर उस परमसत्ता की खोज करने के लिए प्रेरित करता है।
            यही वह मूलभूत जिज्ञासा है जो सच्चे आत्म-ज्ञान और अध्यात्म का प्रवेश द्वार है।
        """.trimIndent(),
        english = """
            By whose will and direction does the mind light upon its objects?
            Commanded by whom does the first vital breath (Prana) proceed to function?
            By whose will do humans utter this speech?
            And what radiant divine intelligence directs the eyes and the ears in their respective tasks?
            The Kena Upanishad begins with this profound philosophical inquiry, hence its name 'Kena' (By whom).
            Here, a sincere disciple is asking the guru about the ultimate source of life and consciousness.
            We often assume that our mind, body, and senses operate entirely on their own, independently.
            However, there is a far subtler, supreme power operating silently behind all these physical faculties.
            This Upanishad powerfully urges us to look beyond our physical bodies and investigate the Ultimate Reality.
            This fundamental questioning is the very gateway to authentic Self-realization and deep spirituality.
        """.trimIndent()
    ),
    KenaShloka(
        id = 2,
        sanskrit = "श्रोत्रस्य श्रोत्रं मनसो मनो यद् वाचो ह वाचं स उ प्राणस्य प्राणः ।\nचक्षुषश्चक्षुरतिमुच्य धीराः प्रेत्यास्माल्लोकादमृता भवन्ति ॥ २ ॥",
        hindi = """
            वह (परमात्मा) कानों का भी कान है, मन का भी मन है, वाणी की भी वाणी है।
            वह प्राणों का भी प्राण है और आँखों की भी आँख है।
            इस सत्य को जानकर धीर (बुद्धिमान) पुरुष इंद्रियों के अहंकार से मुक्त हो जाते हैं।
            और इस भौतिक लोक से विदा होने के बाद वे अमरता (मोक्ष) को प्राप्त कर लेते हैं।
            गुरु उत्तर देते हैं कि वह शक्ति कोई बाहरी वस्तु नहीं, बल्कि हमारी चेतना का भी मूल है।
            आँखें केवल उस शक्ति की वजह से देखती हैं; स्वयं आँखों में देखने की स्वतंत्र शक्ति नहीं है।
            मन सोचता है क्योंकि वह परम चेतना मन को शक्ति प्रदान करती है।
            जो अज्ञानी हैं वे शरीर को ही सब कुछ मान लेते हैं और मृत्यु के चक्र में फंसे रहते हैं।
            लेकिन जो ज्ञानी इस 'पीछे की शक्ति' को पहचान लेते हैं, वे मृत्यु के भय को पार कर जाते हैं।
            इंद्रियों की सीमाओं को पार करना ही सच्ची आध्यात्मिक अमरता है।
        """.trimIndent(),
        english = """
            That Supreme Reality is the Ear of the ear, the Mind of the mind, and the Speech of speech.
            He is the very Life of the vital breath (Prana), and the Eye of the eye.
            Knowing this profound truth, the wise relinquish their false identification with the senses.
            And upon departing from this mortal world, they attain eternal immortality (Moksha).
            The Guru answers that this power is not external, but the very root of our own consciousness.
            The eyes can only see because of that divine power; the eyes themselves have no independent vision.
            The mind is able to think purely because that Supreme Consciousness illuminates it.
            The ignorant mistakenly believe the physical body is everything and remain trapped in the cycle of rebirth.
            But the wise who recognize the 'Power behind the power' transcend the illusion of death.
            Rising above the limitations of the senses is the realization of true spiritual immortality.
        """.trimIndent()
    ),
    KenaShloka(
        id = 3,
        sanskrit = "न तत्र चक्षुर्गच्छति न वाग्गच्छति नो मनः ।\nन विद्मो न विजानीमो यथैतदनुशिष्यात् ॥ ३ ॥",
        hindi = """
            उस परमसत्ता (ब्रह्म) तक न तो हमारी आँखें पहुँच सकती हैं, और न ही हमारी वाणी।
            यहाँ तक कि हमारा मन भी उस तक नहीं पहुँच सकता, क्योंकि वह मन की कल्पना से परे है।
            हम नहीं जानते कि वह कैसा है, इसलिए हम यह भी नहीं जानते कि किसी को इसका उपदेश कैसे दिया जाए।
            परमात्मा को भौतिक इंद्रियों या बुद्धि द्वारा कभी भी मापा या देखा नहीं जा सकता।
            आँखें केवल भौतिक वस्तुओं को देख सकती हैं, और मन केवल उन्हीं चीज़ों को सोच सकता है जिन्हें उसने अनुभव किया हो।
            चूंकि ब्रह्म इन सभी का मूल है, इसलिए कोई भी साधन अपने ही मूल को कैसे जान सकता है?
            जैसे चिमटी उस हाथ को नहीं पकड़ सकती जो उसे चला रहा है।
            गुरु यहाँ स्वीकार करते हैं कि ईश्वर का वर्णन करने के लिए इंसानी भाषा और शब्द पूरी तरह अपर्याप्त हैं।
            उसे जानने का तरीका सांसारिक ज्ञान प्राप्त करने के तरीकों से बिल्कुल अलग है।
            यह श्लोक अद्वैत दर्शन में ईश्वर की 'अज्ञेयता' (Unknowability) को स्थापित करता है।
        """.trimIndent(),
        english = """
            The human eye does not go there, nor does speech, nor can the mind comprehend it.
            We do not know exactly what It is, nor do we know how one could teach or explain it to another.
            The Supreme Reality (Brahman) can never be measured, seen, or grasped by the physical senses or intellect.
            Eyes can only perceive material objects, and the mind can only think of concepts it has already experienced.
            Since Brahman is the absolute source of all these tools, how can a tool turn back and grasp its own source?
            Just as a pair of tongs cannot grasp the very hand that is holding and operating it.
            The Guru humbly admits that human language and intellectual definitions are entirely inadequate to describe God.
            The methodology of knowing the Divine is completely different from acquiring regular worldly knowledge.
            This verse beautifully establishes the fundamental 'Unknowability' of God through standard intellectual means.
            It points towards direct, intuitive realization rather than academic understanding.
        """.trimIndent()
    ),
    KenaShloka(
        id = 4,
        sanskrit = "अन्यदेव तद्विदितादथो अविदितादधि ।\nइति शुश्रुम पूर्वेषां ये नस्तद्व्याचचक्षिरे ॥ ४ ॥",
        hindi = """
            वह ब्रह्म उस सब से बिल्कुल अलग है जिसे हम जानते हैं (विदित)।
            और वह उस सब से भी परे है जिसे हम नहीं जानते (अविदित)।
            ऐसा हमने उन प्राचीन गुरुओं और ऋषियों से सुना है, जिन्होंने हमारे लिए इसकी स्पष्ट व्याख्या की थी।
            जो कुछ भी हम जानते हैं, वह सृष्टि का हिस्सा है, इसलिए वह ब्रह्म नहीं हो सकता।
            और जो हम नहीं जानते (जैसे कि कल क्या होगा), वह भी अज्ञान की श्रेणी में आता है, ब्रह्म उससे भी ऊपर है।
            ईश्वर न तो कोई ज्ञात वस्तु है और न ही कोई रहस्यमयी अज्ञात वस्तु जिसे भविष्य में खोजा जा सके।
            वह जानने वाले (ज्ञाता) की अपनी आत्मा है, इसलिए उसे एक 'वस्तु' के रूप में नहीं जाना जा सकता।
            यह श्लोक गुरु-शिष्य परंपरा के महत्व पर भी प्रकाश डालता है कि यह ज्ञान प्राचीन काल से चला आ रहा है।
            सत्य को खोजने के लिए हमें ज्ञान और अज्ञान दोनों की सीमाओं को छोड़ना होगा।
            यह उपनिषदों की सबसे रहस्यमयी और गहरी शिक्षाओं में से एक है।
        """.trimIndent(),
        english = """
            That Supreme Brahman is entirely different from everything that is known to us.
            And It is also far beyond everything that is currently unknown to us.
            Thus we have heard from the ancient sages and teachers who clearly explained it to us.
            Whatever we can know is part of the material creation, therefore it cannot be the absolute Brahman.
            And whatever is unknown (like a hidden object or future event) is still within the realm of ignorance; Brahman transcends even that.
            God is neither a known scientific fact, nor a mysterious puzzle waiting to be solved in the future.
            He is the very core of the Knower; hence He cannot be objectified or reduced to a piece of information.
            This verse also highlights the unbroken lineage of the Guru-disciple tradition preserving this wisdom.
            To realize the Truth, one must absolutely transcend the dualistic boundaries of both knowledge and ignorance.
            This remains one of the most profoundly mystical and precise teachings found in the Upanishads.
        """.trimIndent()
    ),
    KenaShloka(
        id = 5,
        sanskrit = "यद्वाचानभ्युदितं येन वागभ्युद्यते ।\nतदेव ब्रह्म त्वं विद्धि नेदं यदिदमुपासते ॥ ५ ॥",
        hindi = """
            जिसे वाणी (शब्दों) के द्वारा व्यक्त या प्रकाशित नहीं किया जा सकता।
            बल्कि जिसकी शक्ति से स्वयं वाणी प्रकाशित होती है और बोली जाती है।
            तू उसी को वास्तविक ब्रह्म जान, न कि उसे जिसकी लोग यहाँ (संसार में) एक वस्तु के रूप में उपासना करते हैं।
            हम ईश्वर को मंत्रों या शब्दों में बाँधने की कोशिश करते हैं, लेकिन शब्द उस तक पहुँच नहीं सकते।
            ईश्वर वह शक्ति है जो हमारी जीभ को बोलने की क्षमता देती है।
            लोग मूर्तियों, धन, या अन्य सीमित रूपों को ही ईश्वर मानकर उनकी पूजा करने लगते हैं।
            उपनिषद यहाँ स्पष्ट करता है कि जो कुछ भी हमारी इंद्रियों या मन का विषय है, वह सच्चा ब्रह्म नहीं है।
            ब्रह्म 'दृश्य' नहीं है, बल्कि वह 'दृष्टा' (देखने वाला) है।
            सच्चा ईश्वर वह है जो तुम्हारी प्रार्थनाओं को सुन रहा है, न कि वह रूप जिसे तुमने अपने दिमाग में बना लिया है।
            यह श्लोक आध्यात्मिक साधक को बाहरी कर्मकांडों से उठाकर आंतरिक सत्य की ओर मोड़ता है।
        """.trimIndent(),
        english = """
            That which cannot be expressed, illuminated, or defined by human speech.
            But that by whose power speech itself is illuminated and spoken.
            Know that alone to be the true Brahman, and not this which people worship here as an object.
            We often try to capture God within mantras, scriptures, or descriptive words, but words fall utterly short.
            Brahman is the silent, underlying power that grants the tongue the very capacity to speak.
            People often mistakenly worship limited idols, concepts, or material things as the ultimate God.
            The Upanishad firmly clarifies that anything that can become an object of your senses or mind is not Brahman.
            Brahman is never the 'seen' object; Brahman is the eternal 'Seer' or witness.
            The true Divine is the consciousness hearing your prayers, not the mental image you pray to.
            This verse profoundly redirects the spiritual seeker away from external rituals towards the absolute internal truth.
        """.trimIndent()
    ),
    KenaShloka(
        id = 6,
        sanskrit = "यन्मनसा न मनुते येनाहुर्मनो मतम् ।\nतदेव ब्रह्म त्वं विद्धि नेदं यदिदमुपासते ॥ ६ ॥",
        hindi = """
            जिसे मन के द्वारा सोचा या समझा नहीं जा सकता।
            बल्कि जिसके प्रकाश से मन सोचने में सक्षम होता है (मन को भी जो जानता है)।
            तू उसी को वास्तविक ब्रह्म जान, न कि उसे जिसकी लोग इस दुनिया में उपासना करते हैं।
            हमारा मन केवल आकार, रंग, समय और स्थान के भीतर ही सोच सकता है।
            परमात्मा इन सब सीमाओं से परे है, इसलिए मन उसे अपने भीतर नहीं समेट सकता।
            जैसे बल्ब बिजली को नहीं देख सकता, वैसे ही मन उस चेतना को नहीं समझ सकता जो उसे ऊर्जा दे रही है।
            ईश्वर तुम्हारे विचारों का विषय नहीं है, वह उन विचारों को देखने वाला साक्षी है।
            जो लोग किसी विशेष मानसिक चित्र या धारणा को ही अंतिम ईश्वर मान लेते हैं, वे भ्रम में हैं।
            ब्रह्म तुम्हारे सोचने की प्रक्रिया से भी पहले मौजूद है।
            अतः मन को शांत करके ही उस असीम तत्व का अनुभव किया जा सकता है।
        """.trimIndent(),
        english = """
            That which the mind cannot think, conceptualize, or comprehend.
            But that by whose light the mind itself is said to be thought of and energized.
            Know that alone to be the absolute Brahman, and not this which people worship as an object.
            Our human mind is strictly limited to thinking within the frameworks of shape, time, space, and logic.
            The Supreme Reality transcends all these boundaries, so the mind cannot possibly encapsulate it.
            Just as a lightbulb cannot illuminate the electricity powering it, the mind cannot analyze the consciousness feeding it.
            God is not a subject of your thoughts; God is the silent witness observing those thoughts.
            Those who mistake a specific mental image, feeling, or theology for the ultimate God are fundamentally mistaken.
            Brahman exists perfectly prior to your very process of thinking.
            Therefore, it is only by completely stilling the mind that this infinite reality can be truly experienced.
        """.trimIndent()
    ),
    KenaShloka(
        id = 7,
        sanskrit = "यच्चक्षुषा न पश्यति येन चक्षूंषि पश्यति ।\nतदेव ब्रह्म त्वं विद्धि नेदं यदिदमुपासते ॥ ७ ॥",
        hindi = """
            जिसे इन भौतिक आँखों से देखा नहीं जा सकता।
            बल्कि जिसकी शक्ति से आँखें देखने का कार्य करती हैं।
            तू उसी को सच्चा ब्रह्म जान, न कि उसे जिसकी लोग यहाँ एक सीमित रूप में उपासना करते हैं।
            मनुष्य अक्सर कहता है "मैं ईश्वर को अपनी आँखों से देखना चाहता हूँ, तभी मानूंगा।"
            लेकिन आँखें केवल रूप और रंग को देख सकती हैं, जबकि ब्रह्म निराकार है।
            वह प्रकाश का भी प्रकाश है, जो आँखों को देखने की ताकत देता है।
            आप उस आँख को कैसे देख सकते हैं जो सब कुछ देख रही है?
            सांसारिक लोग उन वस्तुओं या आकृतियों की पूजा करते हैं जिन्हें आँखें देख सकती हैं।
            किंतु जो कुछ भी दिखाई देता है वह नष्ट होने वाला है, वह शाश्वत ब्रह्म नहीं हो सकता।
            ईश्वर दृश्य जगत का हिस्सा नहीं है, वह संपूर्ण जगत का आधार है।
        """.trimIndent(),
        english = """
            That which one cannot perceive or see with the physical eyes.
            But that by whose supreme power the eyes are able to see their objects.
            Know that alone to be the ultimate Brahman, and not this which people worship here in limited forms.
            Humans often stubbornly declare, "I will only believe in God if I can see Him with my own eyes."
            However, the eyes are merely organs that detect light, color, and form, whereas Brahman is formless.
            He is the Light of all lights, the very energy that enables the retina to register vision.
            How can you possibly look at the Ultimate 'Eye' that is witnessing everything?
            Worldly people tend to worship only what is visible, tangible, and perceptible to the senses.
            But whatever is visible is inherently perishable and cannot be the eternal, unchanging Brahman.
            God is not a part of the visible scenery; He is the invisible foundation of the entire universe.
        """.trimIndent()
    ),
    KenaShloka(
        id = 8,
        sanskrit = "यच्छ्रोत्रेण न शृणोति येन श्रोत्रमिदं श्रुतम् ।\nतदेव ब्रह्म त्वं विद्धि नेदं यदिदमुपासते ॥ ८ ॥",
        hindi = """
            जिसे कानों के द्वारा सुना नहीं जा सकता।
            बल्कि जिसकी शक्ति से कानों को सुनने की क्षमता प्राप्त होती है (कान जिसके द्वारा सुने जाते हैं)।
            तू उसी को वास्तविक ब्रह्म जान, न कि उसे जिसकी लोग यहाँ एक सांसारिक वस्तु के रूप में उपासना करते हैं।
            हम बाहरी ध्वनियों, भजनों या प्रवचनों को सुनकर सोचते हैं कि हमने ईश्वर को पा लिया।
            लेकिन ब्रह्म कोई ध्वनि या शब्द नहीं है जिसे भौतिक कानों से सुना जा सके।
            वह उस सन्नाटे और चेतना का नाम है जिसके कारण हम किसी भी ध्वनि को सुन पाते हैं।
            जब हम कहते हैं कि हम ईश्वर को खोज रहे हैं, तो हमें अपनी ही ज्ञानेंद्रियों के स्रोत की ओर मुड़ना होगा।
            यहाँ उपनिषद स्पष्ट करता है कि पंच-इंद्रियां (आँख, कान, नाक, जीभ, त्वचा) सत्य को नहीं पकड़ सकतीं।
            सत्य इन उपकरणों का स्वामी है, उपकरण सत्य के स्वामी नहीं हो सकते।
            यह श्लोक ध्यान की गहराई में जाने का एक स्पष्ट संकेत है, जहाँ सभी ध्वनियां शांत हो जाती हैं।
        """.trimIndent(),
        english = """
            That which one cannot hear with the physical ears.
            But that by whose unseen power the ears are granted the capacity to hear.
            Know that alone to be the true Brahman, and not this which people worship here as an external object.
            We often listen to external sounds, hymns, or spiritual discourses and think we have captured God.
            But Brahman is not a sound wave or a spoken word that can be caught by the eardrum.
            He is the profound silence and the living consciousness that makes the act of hearing possible.
            When we claim to be searching for God, we must reverse our attention back to the source of our own senses.
            The Upanishad categorically states that the five senses can never capture the Ultimate Truth.
            The Truth is the absolute master of these sensory tools; the tools cannot master the Truth.
            This verse provides a clear directive to enter deep meditation, where all external noises fade into the silence of the Self.
        """.trimIndent()
    ),
    KenaShloka(
        id = 9,
        sanskrit = "यदि मन्यसे सुवेदेति दभ्रमेवापि नूनं त्वं वेत्थ ब्रह्मणो रूपम् ।\nयदस्य त्वं यदस्य च देवेष्वथ नु मीमांस्यमेव ते मन्ये विदितम् ॥ ९ ॥",
        hindi = """
            (गुरु शिष्य से कहते हैं:) यदि तुम सोचते हो कि "मैं ब्रह्म को बहुत अच्छी तरह जानता हूँ", तो निश्चित रूप से तुम ब्रह्म के रूप को बहुत थोड़ा (दभ्रम्) ही जानते हो।
            जो रूप तुम अपने भीतर समझते हो, या जो तुम देवताओं के भीतर समझते हो, वह बहुत ही अल्प है।
            इसलिए तुम्हारे लिए ब्रह्म का यह विषय अभी भी विचार करने (मीमांस्यम्) और गहराई से जानने योग्य है।
            शिष्य ने पिछले उपदेश सुनकर शायद यह सोच लिया होगा कि उसने ईश्वर को पूरी तरह समझ लिया है।
            गुरु तुरंत उसके इस बौद्धिक अहंकार को तोड़ते हुए चेतावनी देते हैं।
            ईश्वर असीम है, और मनुष्य की बुद्धि सीमित है। असीम को कभी भी पूरी तरह 'जाना' नहीं जा सकता।
            जब कोई कहता है कि "मैं ईश्वर को जानता हूँ", तो उसने ईश्वर की केवल एक छोटी सी धारणा ही बनाई होती है।
            सच्चा ज्ञान यह स्वीकार करने में है कि हमारी समझ हमेशा अधूरी है।
            ब्रह्म कोई ऐसा विषय नहीं है जिसकी एक बार पढ़ाई कर ली जाए और बात खत्म हो जाए।
            यह एक निरंतर अनुभव और जीवन भर खोज का मार्ग है।
        """.trimIndent(),
        english = """
            (The Guru tells the disciple:) If you think, "I know Brahman very well," then surely you know but a very little of Brahman's true form.
            What you comprehend of Him within yourself, or what you comprehend of Him among the gods, is incredibly minute.
            Therefore, the reality of Brahman is still something you must deeply reflect upon and investigate further.
            The disciple might have intellectually grasped the previous teachings and concluded he now completely understood God.
            The Guru immediately shatters this intellectual arrogance with a stern warning.
            God is infinite, and human intellect is strictly finite. The finite can never fully enclose or 'know' the infinite.
            When someone claims "I know God perfectly," they have merely captured a tiny, limited mental concept of the Divine.
            True spiritual wisdom begins with the humble realization that our intellectual grasp is always incomplete.
            Brahman is not an academic subject that can be mastered and set aside.
            It is a continuous, living experience and a path of endless internal exploration.
        """.trimIndent()
    ),
    KenaShloka(
        id = 10,
        sanskrit = "नाहं मन्ये सुवेदेति नो न वेदेति वेद च ।\nयो नस्तद्वेद तद्वेद नो न वेदेति वेद च ॥ १० ॥",
        hindi = """
            (अब शिष्य समझकर उत्तर देता है:) मैं ऐसा नहीं मानता कि मैं ब्रह्म को बहुत अच्छी तरह जानता हूँ।
            और मैं ऐसा भी नहीं मानता कि मैं उसे बिल्कुल नहीं जानता। (मैं उसे जानता भी हूँ और नहीं भी जानता)।
            हम शिष्यों में से जो कोई मेरे इस कथन को "मैं उसे जानता भी हूँ और नहीं भी जानता" समझता है, वही वास्तव में ब्रह्म को जानता है।
            शिष्य अब गुरु के संकेत को समझ गया है और बहुत ही रहस्यमयी उत्तर देता है।
            अगर वह कहे "मैं जानता हूँ", तो वह ब्रह्म को एक सांसारिक वस्तु (Object) मान रहा है, जो गलत है।
            अगर वह कहे "मैं बिल्कुल नहीं जानता", तो इसका मतलब वह ब्रह्म के अस्तित्व को ही नकार रहा है, जो कि अज्ञान है।
            ब्रह्म हमारी अपनी आत्मा है। हम खुद को 'जानते' तो हैं कि हम हैं, लेकिन खुद को एक वस्तु की तरह नहीं देख सकते।
            इसीलिए यह विरोधाभास है: ब्रह्म अनुभव में तो आता है, लेकिन शब्दों या बुद्धि की पकड़ में नहीं आता।
            ज्ञानी वही है जो ज्ञान के इस असीम विस्तार और बुद्धि की सीमाओं को एक साथ स्वीकार करता है।
            यह श्लोक अद्वैत वेदांत की उस सूक्ष्म सीमा को छूता है जहाँ ज्ञान और अज्ञान दोनों पीछे छूट जाते हैं।
        """.trimIndent(),
        english = """
            (The awakened disciple replies:) I do not think that I know Brahman perfectly well.
            Nor do I think that I do not know Him at all. (In a sense, I know Him, and yet I do not know Him).
            Amongst us disciples, whoever truly understands my statement—"I know it not, and yet I know it"—is the one who truly knows Brahman.
            The disciple has now grasped the Guru's subtle hint and gives a highly paradoxical, enlightened response.
            If he says "I know it completely," he is reducing Brahman to a mere worldly object, which is entirely false.
            If he says "I know absolutely nothing," he would be denying the existence of his own soul, which is ignorance.
            Brahman is our very own Self. We intuitively 'know' that we exist, but we cannot look at our Self as a physical object.
            Hence the paradox: Brahman is deeply experienced in pure awareness, yet completely escapes intellectual definition.
            A true sage is one who simultaneously embraces this infinite experience and the inherent limitations of the human mind.
            This verse touches the absolute pinnacle of Advaita Vedanta, where concepts of both knowledge and ignorance are left far behind.
        """.trimIndent()
    ),
    KenaShloka(
        id = 11,
        sanskrit = "यस्यामतं तस्य मतं मतं यस्य न वेद सः ।\nअविज्ञातं विजानतां विज्ञातमविजानताम् ॥ ११ ॥",
        hindi = """
            जिसका यह विचार है कि 'ब्रह्म जानने में नहीं आता' (अमतं), उसी ने वास्तव में उसे जाना है।
            लेकिन जो अहंकारवश मानता है कि 'मैंने उसे जान लिया है' (मतं), वह उसे बिल्कुल नहीं जानता।
            सच्चे ज्ञानियों (विजानताम्) के लिए वह अज्ञात (अविज्ञातं) है।
            और अज्ञानियों (अविजानताम्) के लिए वह ज्ञात (विज्ञातम) है।
            यह श्लोक पिछले श्लोकों का एक अत्यंत सुंदर और काव्यात्मक निष्कर्ष है।
            ज्ञानी व्यक्ति यह समझ जाता है कि सत्य इतना विशाल है कि उसे बुद्धि की छोटी सी डिब्बी में बंद नहीं किया जा सकता।
            इसलिए वह ईश्वर के आगे नतमस्तक होकर कहता है कि "तू मेरी समझ से परे है।" यही उसकी सच्ची समझ है।
            दूसरी ओर, अज्ञानी व्यक्ति किसी मूर्ति, ग्रंथ या धारणा को ही ईश्वर मानकर अहंकार में फूल जाता है कि "मुझे ईश्वर मिल गया।"
            सच्चा अध्यात्म अहंकार का विसर्जन है, न कि बौद्धिक जानकारियों का संग्रह।
            जब मन यह स्वीकार कर लेता है कि वह नहीं जान सकता, तभी अहंकार गिरता है और सच्चे ब्रह्म का अनुभव होता है।
        """.trimIndent(),
        english = """
            He by whom Brahman is not conceived or limited by thought (amatam), by him It is truly understood.
            But he who arrogantly conceives it and claims 'I have known it' (matam), does not know It at all.
            To the truly enlightened (vijanatam), Brahman remains the Unknown (avijnatam).
            To the ignorant (avijanatam), It appears as the known (vijnatam).
            This verse serves as a remarkably beautiful, poetic, and definitive conclusion to the previous thoughts.
            A truly wise person realizes that the Truth is so magnificent and infinite that it cannot be boxed into a tiny human intellect.
            Therefore, bowing in deep humility, the sage admits, "You are beyond my grasp." This humility is itself the highest realization.
            Conversely, an ignorant person clings to a statue, a text, or a limited concept, swelling with ego, claiming "I have found God."
            True spirituality is the complete dissolution of the ego, not merely the accumulation of intellectual data.
            It is only when the mind fully surrenders and accepts its inability to 'know', that the true experience of Brahman dawns.
        """.trimIndent()
    ),
    KenaShloka(
        id = 12,
        sanskrit = "प्रतिबोधविदितं मतममृतत्वं हि विन्दते ।\nआत्मना विन्दते वीर्यं विद्यया विन्दतेऽमृतम् ॥ १२ ॥",
        hindi = """
            जब ब्रह्म को चेतना की प्रत्येक अवस्था (जाग्रत, स्वप्न, सुषुप्ति) और प्रत्येक विचार (बोध) में अनुभव किया जाता है, तभी उसे वास्तव में जाना हुआ माना जाता है।
            इस प्रकार जानने से मनुष्य निश्चित रूप से अमरता (मोक्ष) को प्राप्त कर लेता है।
            मनुष्य अपनी आत्मा के द्वारा ही सच्चा बल (वीर्यं) प्राप्त करता है।
            और आत्म-ज्ञान (विद्या) के द्वारा वह अमरता (अमृतम्) को प्राप्त करता है।
            परमात्मा कोई ऐसी चीज़ नहीं है जिसे केवल आँख बंद करके ध्यान में पाया जाए।
            सच्चा ज्ञान वह है जब आप हर विचार, हर काम और हर क्षण में उस ईश्वरीय चेतना की उपस्थिति को महसूस करें।
            दैनिक जीवन का हर अनुभव (प्रतिबोध) ईश्वर का ही प्रकाश बन जाता है।
            संसार का धन, पद या शरीर हमें सच्ची ताकत नहीं दे सकते, क्योंकि वे सब नष्ट होने वाले हैं।
            असली और कभी न खत्म होने वाली ताकत (वीर्य) आत्मा को जानने से ही मिलती है।
            और यह ज्ञान ही मृत्यु के भय को हमेशा के लिए समाप्त कर देता है।
        """.trimIndent(),
        english = """
            Brahman is truly known when It is realized intimately in every single state of consciousness and behind every thought (Pratibodha).
            By attaining this continuous, unbroken realization, one undoubtedly achieves true immortality.
            Through the realization of one's own Self, one attains immense, authentic spiritual strength and vigor.
            And through the knowledge of the Divine (Vidya), one attains absolute immortality.
            The Supreme is not something that is only found in isolated, closed-eye meditation in a cave.
            True enlightenment means feeling the vivid presence of that Divine consciousness in every action, thought, and waking moment.
            Every ordinary experience of daily life becomes a radiant illumination of God.
            Worldly wealth, status, and physical health cannot give us real strength because they are fundamentally perishable.
            The only authentic, inexhaustible power comes directly from realizing the eternal nature of the soul.
            It is this profound knowledge alone that permanently eradicates the deep-seated fear of death.
        """.trimIndent()
    ),
    KenaShloka(
        id = 13,
        sanskrit = "इह चेदवेदीदथ सत्यमस्ति न चेदिहावेदीन्महती विनष्टिः ।\nभूतेषु भूतेषु विचित्य धीराः प्रेत्यास्माल्लोकादमृता भवन्ति ॥ १३ ॥",
        hindi = """
            यदि मनुष्य ने इसी जीवन में (इह) उस परमसत्ता को जान लिया, तो उसका जीवन सत्य और सफल है।
            लेकिन यदि उसने इस जीवन में उसे नहीं जाना, तो उसका बहुत बड़ा विनाश (महान हानि) है।
            बुद्धिमान पुरुष (धीर) सभी प्राणियों (कण-कण) में उसी एक परमात्मा को व्याप्त देखकर उसे पहचान लेते हैं।
            और इस भौतिक शरीर को छोड़ने के बाद वे अमर हो जाते हैं (जन्म-मृत्यु के चक्र से मुक्त हो जाते हैं)।
            यह श्लोक मानव जीवन के सबसे बड़े उद्देश्य की चेतावनी और प्रेरणा दोनों है।
            मानव शरीर बहुत दुर्लभ है; यह केवल खाने, सोने और पैसे कमाने के लिए नहीं मिला है।
            यदि हम आत्म-ज्ञान के बिना मर जाते हैं, तो हमने विकास का एक बहुत बड़ा अवसर खो दिया, यह हमारी सबसे बड़ी हार है।
            ईश्वर को मरने के बाद स्वर्ग में नहीं खोजना है, बल्कि 'इसी जीवन में' (इह) खोजना है।
            ज्ञानी लोग दुनिया छोड़कर नहीं भागते, बल्कि वे दुनिया की हर चीज़ में ईश्वर को देख लेते हैं।
            यही समदृष्टि (सबमें एक को देखना) मोक्ष का सच्चा मार्ग है।
        """.trimIndent(),
        english = """
            If a person realizes that Supreme Reality right here in this very life, then there is truth and meaning to their existence.
            But if one fails to realize It here in this life, it is a tremendous destruction, a catastrophic loss.
            The wise, having clearly perceived that same Supreme Brahman dwelling equally in all living beings.
            Depart from this mortal world and attain eternal immortality, forever free from the cycle of rebirth.
            This verse serves as both a severe warning and an inspiring call to action regarding the ultimate purpose of human life.
            A human birth is extraordinarily rare; it is not meant to be wasted merely on eating, sleeping, and accumulating wealth.
            If we die without achieving Self-realization, we have squandered a profound evolutionary opportunity, which is our greatest tragedy.
            God is not to be searched for in some post-death heaven, but must be realized 'right here, right now' (Iha) while alive.
            Enlightened beings do not escape from the world; instead, they successfully recognize the Divine immanent in every creature.
            This vision of absolute equality and omnipresence is the guaranteed pathway to ultimate liberation.
        """.trimIndent()
    ),
    KenaShloka(
        id = 14,
        sanskrit = "ब्रह्म ह देवेभ्यो विजिग्ये तस्य ह ब्रह्मणो विजये देवा अमहीयन्त ।\nत ऐक्षन्तास्माकमेवायं विजयोऽस्माकमेवायं महिमेति ॥ १४ ॥",
        hindi = """
            (यहाँ से एक कहानी शुरू होती है:) एक बार ब्रह्म (परमात्मा) ने देवताओं के लिए (असुरों पर) विजय प्राप्त की।
            ब्रह्म की उस महान विजय से देवताओं की महिमा और शक्ति बढ़ गई।
            लेकिन अज्ञानवश, उन देवताओं ने सोचा, "यह विजय केवल हमारी अपनी शक्ति का परिणाम है, और यह महिमा हमारी अपनी है।"
            उपनिषद का तीसरा भाग ज्ञान को एक सुंदर प्रतीकात्मक कहानी (Myth) के माध्यम से समझाता है।
            यहाँ देवता हमारी इंद्रियों (आँख, कान, मन आदि) और दैवीय प्रवृत्तियों के प्रतीक हैं।
            असुर हमारी बुरी आदतों और अज्ञान के प्रतीक हैं।
            जब हम जीवन में कोई बड़ी सफलता प्राप्त करते हैं या बुराई पर जीत हासिल करते हैं, तो अक्सर हमारा अहंकार जाग जाता है।
            देवताओं को भी यही अहंकार हो गया कि उन्होंने अपनी मेहनत और ताकत से असुरों को हराया है।
            वे उस 'अदृश्य शक्ति' (ब्रह्म) को भूल गए जो वास्तव में उन्हें शक्ति दे रही थी।
            यह श्लोक मनुष्य के उस अहंकार को दर्शाता है जहाँ वह ईश्वर की कृपा को भूलकर अपनी सफलता का श्रेय खुद लेने लगता है।
        """.trimIndent(),
        english = """
            (Here begins a symbolic story:) Once upon a time, Brahman (the Supreme) won a great victory for the gods over the demons.
            In that magnificent victory achieved by Brahman, the gods grew great in power and glory.
            However, out of sheer ignorance, the gods thought, "This victory is entirely ours, and this greatness belongs solely to us."
            The third part of the Upanishad explains deep spiritual truths through a highly effective allegorical story.
            Here, the 'gods' symbolically represent our human senses (eyes, ears, mind) and our positive, divine qualities.
            The 'demons' represent our negative tendencies, darkness, and ignorance.
            Whenever we achieve significant success in life or conquer a bad habit, our ego naturally tends to inflate.
            The gods suffered from this exact same arrogance, believing they defeated the demons through their own independent strength.
            They completely forgot the 'invisible, underlying power' (Brahman) that was actually enabling them to fight and win.
            This verse perfectly mirrors human nature, where we quickly claim personal credit for our successes while completely forgetting Divine grace.
        """.trimIndent()
    ),
    KenaShloka(
        id = 15,
        sanskrit = "तद्धैषां विजज्ञौ तेभ्यो ह प्रादुर्बभूव तन्न व्यजानत किमिदं यक्षमिति ॥ १५ ॥",
        hindi = """
            ब्रह्म (परमात्मा) देवताओं के इस झूठे अहंकार को जान गया।
            उनके इस अहंकार को तोड़ने के लिए, ब्रह्म उनके सामने एक अत्यंत अद्भुत और रहस्यमयी रूप (यक्ष) धारण करके प्रकट हुआ।
            देवता उस दिव्य और तेजोमय स्वरूप को देखकर हैरान रह गए और वे बिल्कुल नहीं जान पाए कि "यह पूजनीय यक्ष (आत्मा) कौन है?"
            ईश्वर अपने भक्तों और अच्छाई के मार्ग पर चलने वालों (देवताओं) का अहंकार कभी टिकने नहीं देता, क्योंकि अहंकार ज्ञान का सबसे बड़ा दुश्मन है।
            जब ईश्वर ने देखा कि देवता घमंड में चूर हैं, तो उसने उनका घमंड तोड़ने का निश्चय किया।
            वह उनके सामने एक ऐसे रूप में आया जिसे उनकी बुद्धि और इंद्रियां समझ नहीं सकती थीं।
            देवता जो खुद को सर्वशक्तिमान मान रहे थे, अब एक अजनबी शक्ति के सामने असहाय और अज्ञानी महसूस करने लगे।
            यह दर्शाता है कि जब हम प्रकृति या जीवन में किसी ऐसी शक्ति का सामना करते हैं जो हमारी समझ से परे है, तो हमारा अहंकार टूटता है।
            सच्चा ज्ञान तब शुरू होता है जब हम यह स्वीकार करते हैं कि "हम नहीं जानते।"
            यहीं से देवताओं की ब्रह्म को जानने की यात्रा फिर से शुरू होती है।
        """.trimIndent(),
        english = """
            Brahman immediately recognized this false pride and arrogance inflating the minds of the gods.
            To shatter their ego, Brahman miraculously appeared before them in the form of an incredibly wondrous and mysterious spirit (Yaksha).
            The gods were completely bewildered by this radiant, mysterious apparition and did not know at all, "Who is this adorable spirit?"
            The Divine never allows the ego of His devotees or those walking the path of goodness (the gods) to remain unchecked, as ego is the greatest obstacle to enlightenment.
            Seeing the gods blinded by their own pride, the Supreme decided it was necessary to humble them.
            He manifested in a form that completely bypassed their intellect and sensory comprehension.
            The very gods who had just proclaimed themselves as almighty suddenly felt entirely ignorant and helpless before this unknown entity.
            This beautifully illustrates that when we encounter vast forces in nature or life that defy our understanding, our petty ego shatters.
            The journey to true wisdom only genuinely begins when we humbly admit, "We do not know."
            From this point of profound humility, the gods' genuine quest to discover Brahman recommences.
        """.trimIndent()
    ),KenaShloka(
        id = 16,
        sanskrit = "तेऽग्निमब्रुवन् जातवेद एतद्विजानीहि किमेतद्यक्षमिति तथेति ॥ १६ ॥",
        hindi = """
            (जब देवताओं को कुछ समझ नहीं आया तो) उन्होंने अग्निदेव से कहा: "हे जातवेद (सब कुछ जानने वाले अग्नि)! आप जाकर पता लगाइए कि यह पूजनीय यक्ष कौन है?"
            अग्नि ने उत्तर दिया: "ठीक है, मैं पता लगाता हूँ।"
            यहाँ अग्निदेव को 'जातवेद' कहा गया है, जिसका अर्थ है वह जो उत्पन्न हुई हर वस्तु को जानता है।
            देवताओं को अग्नि पर सबसे ज्यादा भरोसा था क्योंकि अग्नि पृथ्वीलोक के सबसे मुख्य और शक्तिशाली देवता माने जाते हैं।
            यह श्लोक दिखाता है कि जब इंसान के सामने कोई रहस्य आता है, तो वह अपनी सबसे तेज़ बुद्धि या शक्ति (अग्नि) को उसे सुलझाने के लिए लगाता है।
            लेकिन अहंकार से भरी हुई भौतिक बुद्धि आध्यात्मिक रहस्य (यक्ष/ब्रह्म) को नहीं सुलझा सकती।
        """.trimIndent(),
        english = """
            (Confused by the mysterious apparition) The gods said to Agni (Fire): "O Jataveda (knower of all born things), go and find out who this adorable Spirit (Yaksha) is."
            Agni replied: "So be it," and agreed to investigate.
            Agni is addressed here as 'Jataveda', meaning the one who intimately knows everything that exists in the physical creation.
            The gods relied on Agni because fire is considered the primary and most active elemental force on earth.
            This verse symbolically shows that when humanity faces the unknown, it first uses its sharpest intellect and physical energy (represented by fire) to solve the mystery.
            However, arrogant intellect alone cannot decipher the profound mystery of the Supreme Brahman.
        """.trimIndent()
    ),
    KenaShloka(
        id = 17,
        sanskrit = "तदभ्यद्रवत् तमभ्यवदत् कोऽसीति अग्निर्वा अहमस्मीत्यब्रवीज्जातवेदा वा अहमस्मीति ॥ १७ ॥",
        hindi = """
            अग्निदेव उस यक्ष की ओर दौड़कर गए। यक्ष ने उनके पहुँचते ही पूछा: "तुम कौन हो?"
            अग्नि ने बड़े गर्व से उत्तर दिया: "मैं अग्नि हूँ! मुझे ही लोग महान 'जातवेद' कहते हैं!"
            अग्नि का यह उत्तर अहंकार से भरा हुआ था। वे सोच रहे थे कि उनकी पहचान पूरी दुनिया में है।
            यक्ष (ब्रह्म) ने अग्नि को अपनी शक्ति का प्रदर्शन करने का मौका भी नहीं दिया और सीधे उनकी पहचान पर सवाल कर दिया।
            जब ईश्वर हमारे सामने होता है, तो हमारी सांसारिक उपाधियां, नाम और रुतबा सब अर्थहीन हो जाते हैं।
            ईश्वर यह जानना चाहता है कि क्या तुम खुद की असली आत्मा को पहचानते हो, या सिर्फ इस शरीर और पद को अपना मानते हो?
            अग्नि का उत्तर यह सिद्ध करता है कि वे अब भी अपने भौतिक स्वरूप (आग) के भ्रम में जी रहे थे।
        """.trimIndent(),
        english = """
            Agni hastened towards the Spirit. As soon as he approached, the Spirit asked him: "Who are you?"
            Agni replied with great pride: "I am Agni (Fire)! I am famously known as Jataveda!"
            Agni's response was dripping with ego. He assumed the entire universe recognized his greatness and title.
            The Yaksha (Brahman) did not even give Agni a chance to show off, but immediately questioned his core identity.
            When we stand before the Divine, our worldly titles, fame, and physical identities become utterly meaningless.
            The Divine essentially asks if we know our true soul, or if we are just blindly attached to our temporary roles.
            Agni's proud answer proves he was still entirely trapped in the illusion of his elemental form.
        """.trimIndent()
    ),
    KenaShloka(
        id = 18,
        sanskrit = "तस्मिंस्त्वयि किं वीर्यमित्यपीदं सर्वं दहेयं यदिदं पृथिव्यामिति ॥ १८ ॥",
        hindi = """
            यक्ष ने अग्नि से पूछा: "ऐसे महान नाम वाले तुममें आखिर क्या शक्ति (वीर्य) है?"
            अग्नि ने घमंड से उत्तर दिया: "इस पृथ्वी पर जो कुछ भी है, मैं उस सब को जलाकर भस्म कर सकता हूँ।"
            अग्नि को अपनी जलाने की शक्ति पर बहुत अभिमान था। उसे लगता था कि विनाश की यह शक्ति उसी की अपनी है।
            मनुष्य भी जब शक्तिशाली पद पर होता है, तो वह सोचता है कि वह अपने बल से दुनिया को नष्ट या नियंत्रित कर सकता है।
            यक्ष ने अग्नि को अपनी शेखी बघारने दी, क्योंकि जब तक अहंकार पूरी तरह बाहर नहीं आता, तब तक उसे तोड़ा नहीं जा सकता।
            अग्नि यह भूल गया था कि उसे 'जलाने की ताकत' भी उसी यक्ष (परमात्मा) ने दी है।
        """.trimIndent(),
        english = """
            The Spirit then asked Agni: "What specific power and ability resides in you, who holds such great names?"
            Agni boastfully replied: "I can burn and reduce to ashes absolutely everything that exists on this earth."
            Agni was intensely arrogant about his destructive capacity, falsely believing this immense power originated from himself.
            Similarly, when a human being attains a position of power, they often mistakenly believe they can control or destroy anything by their own might.
            The Yaksha patiently allowed Agni to brag, because an ego must be fully exposed before it can be completely shattered.
            Agni had completely forgotten that his very 'capacity to burn' was a borrowed power granted by the Supreme Brahman.
        """.trimIndent()
    ),
    KenaShloka(
        id = 19,
        sanskrit = "तस्मै तृणं निदधावेतद्दहेति तदुपप्रेयाय सर्वजवेन तन्न शशाक दग्धुं स तत एव निववृते नैतदशकं विज्ञातुं यदेतद्यक्षमिति ॥ १९ ॥",
        hindi = """
            यक्ष ने अग्नि के सामने एक तिनका (सूखी घास) रख दिया और कहा: "ज़रा इसे जलाकर दिखाओ।"
            अग्नि अपने पूरे वेग (सर्वजवेन) और ताकत के साथ उस तिनके पर झपटा, लेकिन वह उस सूखे तिनके को जला भी नहीं सका।
            निराश और लज्जित होकर अग्नि देवताओं के पास लौट आया और बोला: "मैं यह नहीं जान सका कि यह रहस्यमयी यक्ष कौन है।"
            यह कहानी का एक बहुत ही गहरा और प्रतीकात्मक मोड़ है।
            परमात्मा के सहयोग के बिना, दुनिया की सबसे बड़ी आग एक सूखे तिनके को भी नहीं जला सकती।
            हम जो भी कर्म करते हैं, उसमें हमारी इच्छा होती है, लेकिन उसे पूरा करने की शक्ति ईश्वर की होती है।
            अग्नि का अहंकार टूट गया। उसने विनम्रता से स्वीकार किया कि वह हार गया है।
            यही आध्यात्मिक जागृति का पहला कदम है—अपनी सीमाओं को पहचानना और अहंकार को छोड़ना।
        """.trimIndent(),
        english = """
            The Spirit placed a dry blade of grass before him and said: "Burn this."
            Agni rushed at the grass with all his speed and furious might, but he was completely unable to burn it.
            Humiliated and defeated, Agni returned to the gods and confessed: "I could not find out who this mysterious Spirit is."
            This is a profoundly deep and symbolic turning point in the Upanishad.
            Without the underlying sanction and energy of the Supreme, the greatest cosmic fire cannot burn even a fragile piece of straw.
            We may have the will to act, but the actual power executing the action belongs entirely to the Divine.
            Agni's massive ego was instantly crushed, and he humbly admitted his failure.
            This marks the very first step in spiritual awakening—recognizing one's own limitations and dropping the ego.
        """.trimIndent()
    ),
    KenaShloka(
        id = 20,
        sanskrit = "अथ वायुमब्रुवन् वायवेतद्विजानीहि किमेतद्यक्षमिति तथेति ॥ २० ॥",
        hindi = """
            अग्नि के असफल होने के बाद, देवताओं ने वायुदेव (हवा) से कहा: "हे वायु! तुम जाकर पता लगाओ कि यह यक्ष कौन है?"
            वायुदेव ने कहा: "ठीक है, मैं पता लगाता हूँ।"
            अग्नि के बाद देवताओं ने वायु को चुना, क्योंकि हवा सर्वत्र फैलती है और सबसे शक्तिशाली तत्वों में से एक मानी जाती है।
            देवताओं को लगा कि अगर अग्नि उस यक्ष को नहीं हरा सका, तो शायद वायु अपने प्रचंड तूफान से उसे हिला सकेगा।
            यह मानव मन की फितरत है; जब एक सांसारिक उपाय काम नहीं करता, तो वह भगवान की ओर मुड़ने के बजाय दूसरे सांसारिक उपाय (वायु) की ओर भागता है।
            लेकिन वायुदेव का अहंकार भी अग्निदेव के समान ही बड़ा था।
        """.trimIndent(),
        english = """
            After Agni's failure, the gods turned to Vayu (Wind) and said: "O Vayu! Go and find out who this Spirit is."
            Vayu agreed and said: "So be it."
            The gods selected Vayu next because wind pervades everywhere and is considered one of the most powerful and unstoppable elemental forces.
            The gods assumed that if fire couldn't intimidate the Spirit, perhaps a violent hurricane could move it.
            This reflects a common human tendency: when one material solution fails, we quickly try another material force rather than turning inward to the Divine.
            However, Vayu's ego was just as inflated as Agni's, setting him up for the exact same lesson.
        """.trimIndent()
    ),
    KenaShloka(
        id = 21,
        sanskrit = "तदभ्यद्रवत् तमभ्यवदत् कोऽसीति वायुर्वा अहमस्मीत्यब्रवीन्मातरिश्वा वा अहमस्मीति ॥ २१ ॥",
        hindi = """
            वायुदेव उस यक्ष की ओर दौड़े। यक्ष ने उनसे भी वही सवाल किया: "तुम कौन हो?"
            वायु ने गर्व से उत्तर दिया: "मैं वायु हूँ! मुझे अंतरिक्ष में विचरने वाला महान 'मातरिश्वा' कहा जाता है!"
            वायु ने भी वही गलती की जो अग्नि ने की थी। उसने अपने शरीर और उपाधि को अपनी असली पहचान मान लिया।
            'मातरिश्वा' का अर्थ है जो माता (अंतरिक्ष) में सांस लेता है या चलता है।
            यक्ष फिर से शांत रहा, क्योंकि वह देख रहा था कि इन देवताओं को अपनी शक्तियों पर कितना झूठा घमंड है।
            ईश्वर हमेशा अहंकार को चुनौती देता है ताकि आत्मा अपनी असली वास्तविकता को पहचान सके।
        """.trimIndent(),
        english = """
            Vayu rushed towards the Spirit. The Spirit asked him the exact same question: "Who are you?"
            Vayu proudly proclaimed: "I am Vayu (Wind)! I am famously known as Matarishva, the one who breathes through space!"
            Vayu committed the identical mistake as Agni; he completely identified himself with his title and elemental form.
            'Matarishva' refers to the powerful force that moves swiftly through the mother-like expanse of the cosmos.
            The Yaksha remained calm, observing how deeply intoxicated these gods were by their borrowed powers.
            The Divine continually challenges human arrogance so that the soul may eventually discover its true, humble reality.
        """.trimIndent()
    ),
    KenaShloka(
        id = 22,
        sanskrit = "तस्मिंस्त्वयि किं वीर्यमित्यपीदं सर्वमाददीय यदिदं पृथिव्यामिति ॥ २२ ॥",
        hindi = """
            यक्ष ने वायु से पूछा: "इतने महान नाम वाले तुममें आखिर क्या शक्ति (वीर्य) है?"
            वायु ने बड़े घमंड से उत्तर दिया: "इस पृथ्वी पर जो कुछ भी है, मैं उस सब को उड़ा सकता हूँ और अपने साथ ले जा सकता हूँ।"
            तूफान और बवंडर के रूप में वायु की शक्ति असीम लगती है। वह बड़े-बड़े पेड़ों और पहाड़ों को हिला सकता है।
            उसे अपनी इस भौतिक शक्ति पर बहुत नाज़ था।
            अग्नि को 'जलाने' का अभिमान था और वायु को 'उड़ाने' का।
            मनुष्य भी अपनी अलग-अलग योग्यताओं (कोई बुद्धि में, कोई धन में, कोई बल में) का झूठा अभिमान पालता है।
        """.trimIndent(),
        english = """
            The Spirit asked Vayu: "What specific power resides in you, who holds such grand titles?"
            Vayu arrogantly replied: "I can easily lift up and blow away absolutely anything and everything on this earth."
            As a hurricane or tornado, the wind's sheer physical power appears limitless, capable of uprooting massive trees and shaking mountains.
            Vayu was exceedingly proud of this destructive physical capacity.
            While Agni was obsessed with his power to 'burn', Vayu was intoxicated by his power to 'blow away'.
            Similarly, human beings falsely pride themselves on their various limited capabilities, whether it be wealth, intellect, or physical strength.
        """.trimIndent()
    ),
    KenaShloka(
        id = 23,
        sanskrit = "तस्मै तृणं निदधावेतदादत्स्वेति तदुपप्रेयाय सर्वजवेन तन्न शशाकादातुं स तत एव निववृते नैतदशकं विज्ञातुं यदेतद्यक्षमिति ॥ २३ ॥",
        hindi = """
            यक्ष ने वायु के सामने भी वही एक तिनका रखा और कहा: "ज़रा इसे उड़ाकर दिखाओ।"
            वायु अपने पूरे वेग के साथ उस तिनके पर झपटा, लेकिन वह उस हल्के से तिनके को हिला तक नहीं सका।
            हार मानकर वायु भी देवताओं के पास लौट आया और बोला: "मैं भी नहीं जान सका कि यह यक्ष कौन है।"
            हवा जो बड़े-बड़े शहरों को तबाह कर सकती है, परमात्मा की इच्छा के बिना एक तिनका भी नहीं हिला सकी।
            कहावत है कि "ईश्वर की इच्छा के बिना पत्ता भी नहीं हिलता," यह श्लोक उसी सत्य को प्रमाणित करता है।
            प्राण शक्ति (हवा) भी ब्रह्मांडीय चेतना के अधीन है।
            अब तक भौतिक शक्तियों (अग्नि और वायु) का अहंकार पूरी तरह चूर-चूर हो चुका था।
        """.trimIndent(),
        english = """
            The Spirit placed the exact same blade of grass before him and said: "Lift this."
            Vayu rushed at it with blinding speed and fury, but he was entirely unable to even move or lift the tiny straw.
            Defeated, Vayu returned to the gods and confessed: "I too could not find out who this Spirit is."
            The violent wind that could devastate entire cities was rendered completely powerless against a single straw without God's sanction.
            The popular saying, "Not a single leaf moves without God's will," finds its profound origin in this truth.
            Even the vital life force (Prana/Air) is strictly subordinate to the Supreme Cosmic Consciousness.
            By this point, the massive egos of the greatest physical forces (fire and wind) had been completely and utterly crushed.
        """.trimIndent()
    ),
    KenaShloka(
        id = 24,
        sanskrit = "अथेन्द्रमब्रुवन् मघवन्नेतद्विजानीहि किमेतद्यक्षमिति तथेति तदभ्यद्रवत् तस्मात्तिरोदधे ॥ २४ ॥",
        hindi = """
            अंत में, देवताओं ने अपने राजा इंद्र (मघवन) से कहा: "हे इंद्र! आप जाकर पता लगाइए कि यह यक्ष कौन है?"
            इंद्र ने कहा "ठीक है," और वे उस यक्ष की ओर दौड़े। लेकिन उनके पहुँचते ही यक्ष उनके सामने से अंतर्ध्यान (गायब) हो गया।
            इंद्र देवताओं के राजा हैं, जो मन और आत्मा (जीव) के प्रतीक हैं।
            जब तक हम अपनी इंद्रियों (अग्नि, वायु) के बल पर ईश्वर को खोजना चाहते हैं, ईश्वर हमारे सामने रहता है लेकिन हम उसे समझ नहीं पाते।
            लेकिन जब राजा (मन या आत्मा) खुद सत्य की खोज में निकलता है, तो ईश्वर का सगुण रूप (यक्ष) गायब हो जाता है।
            क्यों? क्योंकि ईश्वर कोई भौतिक वस्तु नहीं है जिसे सामने से देखा जा सके।
            इंद्र का अहंकार भी टूट गया कि वे राजा होकर भी उस यक्ष से मिल नहीं पाए।
            यही वह अवस्था है जहाँ साधक पूरी तरह शून्य और समर्पित हो जाता है।
        """.trimIndent(),
        english = """
            Finally, the gods turned to their king, Indra (Maghavan), and said: "O Indra! Find out who this Spirit is."
            Indra agreed, saying "So be it," and rushed towards it. But the moment he approached, the Spirit completely vanished from his sight.
            Indra is the king of the gods, symbolically representing the human mind or the individual soul (Jiva).
            As long as we try to grasp God purely through our physical senses (like Agni and Vayu), God appears as a mystery we cannot solve.
            But when the mind itself earnestly sets out to find the Truth, the manifested form (Yaksha) disappears.
            Why? Because God is not a physical object standing in front of you that the mind can catch.
            Indra's royal ego was humbled because, despite being the king, he was denied even an interview with the Spirit.
            This represents the crucial spiritual stage where the seeker realizes his utter helplessness and surrenders completely.
        """.trimIndent()
    ),
    KenaShloka(
        id = 25,
        sanskrit = "स तस्मिन्नेवाकाशे स्त्रियमाजगाम बहुशोभमानामुमां हैमवतीं तां होवाच किमेतद्यक्षमिति ॥ २५ ॥",
        hindi = """
            यक्ष के गायब होने के बाद, उसी आकाश (स्थान) में इंद्र के सामने एक अत्यंत सुंदर स्त्री प्रकट हुई।
            वह उमा हैमवती (हिमालय की पुत्री, देवी पार्वती या ब्रह्मविद्या का स्वरूप) थीं।
            इंद्र ने उनसे पूछा: "हे देवी! क्या आप जानती हैं कि वह रहस्यमयी यक्ष कौन था?"
            जब इंद्र का अहंकार टूट गया और वे खाली हाथ खड़े रहे, तब वहां 'ज्ञान' (उमा) प्रकट हुआ।
            ईश्वर को सीधे बल से नहीं पाया जा सकता; ईश्वर को केवल दिव्य ज्ञान (ब्रह्मविद्या) के माध्यम से जाना जा सकता है।
            उमा यहाँ परम ज्ञान की देवी हैं। वे सोने की तरह चमक रही थीं (बहुशोभमानाम), जो शुद्ध चेतना का प्रतीक है।
            जब साधक का मन अहंकार से खाली हो जाता है, तभी उसके भीतर सच्चा आध्यात्मिक ज्ञान उदय होता है।
            और यह ज्ञान ही उसे सत्य का परिचय कराता है।
        """.trimIndent(),
        english = """
            In the exact same space where the Spirit vanished, an exceedingly beautiful woman appeared before Indra.
            She was Uma Haimavati (the daughter of the Himalayas, representing Goddess Parvati or Supreme Divine Wisdom).
            Indra humbly asked her: "O Goddess! Do you know who that mysterious Spirit was?"
            When Indra's ego was shattered and he stood empty-handed, pure 'Wisdom' (Uma) manifested before him.
            God cannot be conquered by force or intellect; God can only be realized through pure, unadulterated Divine Knowledge (Brahmavidya).
            Uma represents the illuminating Goddess of Wisdom. She was shining brilliantly like gold, symbolizing pure consciousness.
            It is only when the seeker's mind is completely emptied of ego that true spiritual intuition dawns from within.
            And it is this supreme wisdom alone that can introduce the soul to the Ultimate Truth.
        """.trimIndent()
    ),
    KenaShloka(
        id = 26,
        sanskrit = "सा ब्रह्मेति होवाच ब्रह्मणो वा एतद्विजये महीयध्वमिति ततो हैव विदाञ्चकार ब्रह्मेति ॥ २६ ॥",
        hindi = """
            देवी उमा ने उत्तर दिया: "वह यक्ष 'ब्रह्म' (परमात्मा) ही था! उसी ब्रह्म की विजय से तुम देवताओं को यह महिमा और शक्ति मिली है।"
            उमा के यह बताने पर ही इंद्र को पहली बार यह ज्ञान हुआ कि वह वास्तव में ब्रह्म था।
            ज्ञान की देवी ने देवताओं के उस भ्रम को पूरी तरह मिटा दिया कि वे अपनी शक्ति से असुरों को हराए थे।
            उन्होंने स्पष्ट किया कि हमारी सभी सफलताएं और शक्तियां उस एकमात्र परमसत्ता की देन हैं।
            इंद्र (मन) जब ज्ञान (उमा) के माध्यम से सत्य को सुनता है, तभी उसे आत्म-साक्षात्कार होता है।
            यह श्लोक हमें सिखाता है कि हमारे जीवन में जो भी महान या अच्छा होता है, वह ईश्वर की कृपा है।
            अपनी सफलताओं पर घमंड करना मूर्खता है, क्योंकि हम केवल उस परमसत्ता के उपकरण मात्र हैं।
        """.trimIndent(),
        english = """
            Goddess Uma replied: "That Yaksha was indeed 'Brahman' (the Supreme Lord)! It is solely through Brahman's victory that you gods attained your glory."
            Only upon hearing this from the Goddess of Wisdom did Indra truly realize that the Spirit was Brahman.
            The Divine Wisdom completely shattered the gods' illusion that they had defeated the demons through their own independent might.
            She clarified that every ounce of our success, strength, and glory is a direct gift from the one Supreme Reality.
            When Indra (representing the mind) listens to Wisdom (Uma), only then does Self-realization occur.
            This verse teaches us the profound lesson that whatever is great or good in our lives is entirely due to Divine grace.
            To boast about our personal successes is foolish, for we are merely instruments in the hands of the Almighty.
        """.trimIndent()
    ),
    KenaShloka(
        id = 27,
        sanskrit = "तस्माद्वा एते देवा अतितरामिवान्यान्देवान् यदग्निर्वायुरिन्द्रस्ते ह्येनन्नेदिष्ठं पस्पर्शुस्ते ह्येनत्प्रथमो विदाञ्चकार ब्रह्मेति ॥ २७ ॥",
        hindi = """
            यही कारण है कि ये तीन देवता—अग्नि, वायु और इंद्र—अन्य सभी देवताओं से कहीं अधिक श्रेष्ठ माने जाते हैं।
            क्योंकि वे ही उस ब्रह्म के सबसे समीप गए थे (उन्होंने उसे सबसे करीब से छुआ था)।
            और उन्होंने ही सबसे पहले यह जाना कि वह यक्ष वास्तव में ब्रह्म है।
            आध्यात्मिक अर्थ में, अग्नि वाणी/कर्म का प्रतीक है, वायु प्राण का, और इंद्र मन का।
            जब व्यक्ति ध्यान करता है, तो सबसे पहले उसकी वाणी और कर्म शुद्ध होते हैं, फिर उसके प्राण शांत होते हैं, और अंततः मन ईश्वर के निकट पहुँचता है।
            चूंकि ये इंद्रियां ही हमें ईश्वर की अनुभूति कराने में सबसे पहले सहायक होती हैं, इसलिए शरीर में इनका स्थान सबसे ऊंचा है।
            जो सत्य के सबसे करीब जाता है, वही सबसे महान बन जाता है।
        """.trimIndent(),
        english = """
            Therefore, these three gods—Agni, Vayu, and Indra—are considered vastly superior to all the other deities.
            Because they were the ones who approached Brahman the closest (they intimately touched His presence).
            And they were the very first among the gods to realize that the mysterious Spirit was indeed Brahman.
            In a spiritual context, Agni represents speech/action, Vayu represents the vital breath (Prana), and Indra represents the mind.
            During deep meditation, first our speech and actions purify, then our breath calms down, and finally, the mind approaches the Divine.
            Because these faculties are the primary instruments that help us perceive the Divine, they hold the highest status in our physical and subtle bodies.
            Whoever dares to approach closest to the Supreme Truth naturally becomes the greatest.
        """.trimIndent()
    ),
    KenaShloka(
        id = 28,
        sanskrit = "तस्माद् वा इन्द्रोऽतितरामिवान्यान्देवान् स ह्येनन्नेदिष्ठं पस्पर्श स ह्येनत्प्रथमो विदाञ्चकार ब्रह्मेति ॥ २८ ॥",
        hindi = """
            और इसीलिए इंद्र अग्नि और वायु से भी अधिक श्रेष्ठ हैं।
            क्योंकि वे ही ब्रह्म के सबसे अधिक निकट पहुँचे थे, और उन्होंने ही देवी उमा से सबसे पहले जाना कि वह ब्रह्म है।
            अग्नि और वायु ने केवल यक्ष को देखा था, लेकिन वे उसे पहचान नहीं पाए।
            इंद्र ने देवी उमा (ज्ञान) के उपदेश से यह जान लिया कि वह ब्रह्म है।
            इसलिए मन (इंद्र) हमेशा वाणी (अग्नि) और प्राण (वायु) से श्रेष्ठ है।
            बिना मन की एकाग्रता के, केवल कर्म या श्वास-प्रश्वास से आत्म-ज्ञान नहीं हो सकता।
            ज्ञान की प्राप्ति मन में ही होती है, इसलिए अध्यात्म में मन को जीतने वाला ही असली राजा (इंद्र) है।
        """.trimIndent(),
        english = """
            And for this specific reason, Indra is considered superior even to Agni and Vayu.
            Because he approached the closest to Brahman, and he was the absolute first to know (through Goddess Uma) that it was Brahman.
            Agni and Vayu had only seen the Spirit but failed completely to recognize its true identity.
            Indra, through the direct instruction of Goddess Uma (Wisdom), recognized the Supreme Truth.
            Therefore, the mind (Indra) is always inherently superior to speech (Agni) and breath (Vayu).
            Without the focused participation of the mind, mere physical rituals or breathing exercises cannot lead to Self-realization.
            Enlightenment occurs within the mind; thus, the one who masters his mind is the true spiritual king (Indra).
        """.trimIndent()
    ),
    KenaShloka(
        id = 29,
        sanskrit = "तस्यैष आदेशो यदेतद्विद्युतो व्यद्युतदा३ इतीन्न्यमीमिषदा३ इत्यधिदैवतम् ॥ २९ ॥",
        hindi = """
            (ब्रह्म के स्वरूप को समझाने के लिए) यहाँ ब्रह्म का एक भौतिक (अधिदैवत) उदाहरण दिया जा रहा है।
            ब्रह्म का प्रकट होना आकाश में चमकने वाली बिजली की तरह है—जो पलक झपकते ही चमकती है और गायब हो जाती है।
            यह आँख झपकाने (निमिष) जितना ही तेज़ है।
            यह श्लोक बताता है कि शुरुआती साधक को ईश्वर का अनुभव लगातार नहीं होता।
            जैसे अंधेरी रात में अचानक बिजली कड़कती है और एक पल के लिए सब कुछ साफ दिखाई देता है, वैसा ही आत्म-ज्ञान का पहला अनुभव होता है।
            यह ज्ञान एक अचानक होने वाली घटना (Flash of intuition) की तरह आता है, यह कोई धीरे-धीरे होने वाली तार्किक प्रक्रिया नहीं है।
            मनुष्य का मन इतना चंचल है कि वह उस अनंत प्रकाश को ज्यादा देर तक पकड़ कर नहीं रख सकता।
            इसलिए, ईश्वर की झलक बिजली की चमक की तरह तीव्र, चमत्कारी और क्षणिक होती है।
        """.trimIndent(),
        english = """
            Now, an illustration of Brahman in the cosmic/physical realm (Adhidaivata) is given.
            The manifestation of Brahman is like a sudden flash of brilliant lightning—it flashes and vanishes in an instant.
            It is as incredibly swift as the winking of an eye.
            This verse illustrates that to a beginner on the spiritual path, the experience of the Divine is not constant.
            Just as lightning suddenly illuminates a pitch-black night for a fraction of a second, the first flash of Self-realization happens instantaneously.
            This spiritual wisdom arrives as a sudden, explosive flash of intuition, not as a slow, calculated logical deduction.
            The human mind is far too restless to hold onto that infinite, blinding light for very long.
            Therefore, the preliminary glimpse of God is as rapid, miraculous, and momentary as a lightning strike.
        """.trimIndent()
    ),
    KenaShloka(
        id = 30,
        sanskrit = "अथाध्यात्मं यदेतद्गच्छतीव च मनोऽनेन चैतदुपस्मरत्यभीक्ष्णँ सङ्कल्पः ॥ ३० ॥",
        hindi = """
            अब ब्रह्म का आध्यात्मिक (अंदरूनी या मनोवैज्ञानिक) उदाहरण दिया जा रहा है।
            यह ऐसा लगता है जैसे हमारा मन ब्रह्म की ओर जा रहा है।
            और यह मन बार-बार ब्रह्म को याद करता है (स्मरण करता है) और उसी में निरंतर संकल्प (इच्छा) करता है।
            बाहर की दुनिया में ब्रह्म बिजली की तरह चमकता है, लेकिन हमारे भीतर वह हमारी यादों और विचारों के रूप में है।
            जब कोई व्यक्ति ध्यान करता है, तो उसका मन बार-बार सांसारिक बातों से हटकर उस परमात्मा की ओर जाता है।
            हम ईश्वर को लगातार नहीं सोच सकते, लेकिन हमारा मन रुक-रुक कर बार-बार उसी की ओर खिंचता है।
            यह श्लोक ध्यान की प्रक्रिया को समझाता है: बार-बार ईश्वर का स्मरण करना और मन को उसी में लगाना ही सच्ची उपासना है।
            जिस दिन मन पूरी तरह वहीं टिक जाएगा, उसी दिन मोक्ष मिल जाएगा।
        """.trimIndent(),
        english = """
            Now, the illustration of Brahman from the internal, psychological perspective (Adhyatma) is given.
            It appears as though the human mind is continuously moving towards Brahman.
            The mind repeatedly remembers Him, and constantly directs its will and resolve towards Him.
            While in the external world Brahman is like a sudden flash of lightning, internally He is the constant target of our deepest thoughts and memories.
            When a seeker meditates, their mind continually pulls away from worldly distractions to focus on the Supreme.
            We may not be able to hold the thought of God constantly, but the trained mind repeatedly gravitates back towards Him.
            This verse beautifully describes the actual process of meditation: repeatedly remembering God and anchoring the mind's resolve upon Him.
            The day the mind permanently rests in that thought, ultimate liberation is achieved.
        """.trimIndent()
    ),
    KenaShloka(
        id = 31,
        sanskrit = "तद्ध तद्वनं नाम तद्वनमित्युपासितव्यं स य एतदेवं वेदाभि हैनं सर्वाणि भूतानि संवाञ्छन्ति ॥ ३१ ॥",
        hindi = """
            उस ब्रह्म का एक गुप्त नाम 'तद्वन' है। तद्वन का अर्थ है 'वह जो सबके द्वारा पूजनीय या चाहने योग्य है'।
            अतः मनुष्य को 'तद्वन' (सबके परम प्रिय) के रूप में उसकी उपासना करनी चाहिए।
            जो व्यक्ति ब्रह्म को इस प्रकार (सबका प्यारा मानकर) जानता है और पूजता है, सभी प्राणी उससे प्रेम करने लगते हैं।
            ईश्वर कोई कठोर तानाशाह नहीं है जिससे डरा जाए, बल्कि वह सबसे ज़्यादा प्यार करने योग्य सत्ता (तद्वन) है।
            हम जीवन में सुख और शांति चाहते हैं, और ईश्वर ही परम सुख है, इसलिए अनजाने में हर कोई ईश्वर को ही खोज रहा है।
            जब कोई साधक ईश्वर को अपना सबसे प्यारा मानकर पूजता है, तो उसके भीतर का सारा स्वार्थ खत्म हो जाता है।
            चूंकि वह इंसान ईश्वर से जुड़ जाता है, इसलिए वह पूरी सृष्टि से जुड़ जाता है।
            नतीजतन, हर इंसान और जानवर उस साधक की ओर उसी तरह आकर्षित होते हैं जैसे वे ईश्वर की ओर होते हैं।
        """.trimIndent(),
        english = """
            That Supreme Brahman has a secret name: 'Tadvanam', which means 'The Adorable One' or 'The absolute object of all desire'.
            Therefore, He should be worshipped and meditated upon specifically as 'Tadvanam' (The highly Adorable).
            He who profoundly knows and worships Brahman in this way becomes deeply loved and desired by all living beings.
            God is not a cruel dictator to be feared, but the most supremely lovable and adorable reality in existence.
            Every human is unconsciously searching for absolute happiness and peace, which is precisely what God is.
            When a seeker worships God purely out of immense love, all selfish ego vanishes from their heart.
            Because that person becomes deeply connected to the Creator, they naturally become connected to all of creation.
            Consequently, all humans and creatures are naturally drawn to and love that sage, just as they would love the Divine.
        """.trimIndent()
    ),
    KenaShloka(
        id = 32,
        sanskrit = "उपनिषदं भो ब्रूहीत्युक्ता त उपनिषद् ब्राह्मीं वाव त उपनिषदमाम्रूमेति ॥ ३२ ॥",
        hindi = """
            (इतना सब सुनने के बाद) शिष्य गुरु से कहता है: "हे भगवन्! कृपया मुझे उपनिषद (ब्रह्म का रहस्यमयी ज्ञान) सिखाइए।"
            गुरु उत्तर देते हैं: "उपनिषद तुम्हें बता दी गई है। हमने वास्तव में तुम्हें ब्रह्म के विषय में वह पवित्र उपनिषद सुना दी है।"
            शिष्य का मन अभी भी असंतुष्ट है, उसे लगता है कि शायद कोई और मंत्र या जादू बाकी है जो गुरु ने छुपा रखा है।
            लेकिन गुरु स्पष्ट करते हैं कि जानने योग्य जो भी था (ब्रह्म के बारे में), वह सब पहले ही बताया जा चुका है।
            सत्य बहुत ही सरल और स्पष्ट है: "ईश्वर तुम्हारी इंद्रियों का विषय नहीं है, वह तुम्हारी चेतना का मूल है।"
            इससे ज्यादा और कुछ भी रहस्य नहीं है।
            अब शिष्य का काम इस ज्ञान को केवल सुनना नहीं है, बल्कि इसे अपने जीवन में उतारना और अनुभव करना है।
        """.trimIndent(),
        english = """
            (After hearing all these profound teachings) The disciple requests the Guru: "Sir, please teach me the Upanishad (the secret, mystical knowledge)."
            The Guru replies: "The Upanishad has already been taught to you. We have indeed imparted to you the sacred Upanishad regarding Brahman."
            The disciple's mind is still slightly restless, perhaps expecting some hidden magic spell or secret technique that the Guru held back.
            However, the Guru firmly clarifies that everything essential about the Supreme Truth has already been revealed.
            The ultimate truth is strikingly simple: "God cannot be perceived by the senses; He is the very source of your consciousness."
            There is absolutely no deeper intellectual secret beyond this.
            The disciple's task now is not to acquire more theory, but to actively practice, meditate, and directly experience this truth.
        """.trimIndent()
    ),
    KenaShloka(
        id = 33,
        sanskrit = "तस्यै तपो दमः कर्मेति प्रतिष्ठा वेदाः सर्वाङ्गानि सत्यमायतनम् ॥ ३३ ॥",
        hindi = """
            उस ब्रह्म-ज्ञान (उपनिषद) की नींव (प्रतिष्ठा) तीन चीजें हैं: तप (कठोर परिश्रम/तपस्या), दम (इंद्रियों पर नियंत्रण), और कर्म (निष्काम सेवा)।
            चारों वेद और उनके अंग इस ज्ञान के विभिन्न हिस्से (अंग) हैं।
            और सत्य (सच्चाई) इस ज्ञान का निवास स्थान (आयतन) है।
            गुरु यहाँ चेतावनी देते हैं कि केवल किताबें पढ़कर या श्लोक सुनकर आत्म-ज्ञान नहीं होता।
            ज्ञान तभी टिकता है जब जीवन में अनुशासन (तप) हो, बुरी आदतों पर लगाम (दम) हो, और स्वार्थ रहित अच्छे काम (कर्म) किए जाएं।
            वेदों का अध्ययन आपकी बुद्धि को साफ करता है।
            लेकिन इन सबसे ऊपर है 'सत्य'। जिस व्यक्ति के विचार, शब्द और कर्म में सत्य नहीं है, वहां ब्रह्म-ज्ञान कभी नहीं टिक सकता।
            सत्य ही वह पवित्र मंदिर है जहाँ ईश्वर (ब्रह्म) निवास करता है।
        """.trimIndent(),
        english = """
            The firm foundation (Pratishtha) of this Upanishadic knowledge rests on three pillars: Tapas (austerity/discipline), Dama (control of the senses), and Karma (selfless action).
            The Vedas and all their auxiliary limbs are the various parts of this knowledge.
            And Truth (Satya) is its ultimate abode or resting place.
            The Guru gives a stern reminder here that Self-realization is never achieved merely by reading books or listening to lectures.
            Spiritual wisdom only takes root in a life strictly disciplined by austerity, rigorous sensory control, and selfless service to others.
            Studying the scriptures helps clarify and sharpen the intellect.
            However, above all these is 'Truth'. Supreme wisdom can never reside in a mind or heart tainted by falsehood or deceit.
            Absolute Truth in thought, word, and deed is the sacred temple where Brahman chooses to dwell.
        """.trimIndent()
    ),
    KenaShloka(
        id = 34,
        sanskrit = "यो वा एतामेवं वेदापहत्य पाप्मानमनन्ते स्वर्गे लोके ज्येये प्रतितिष्ठति प्रतितिष्ठति ॥ ३४ ॥",
        hindi = """
            जो कोई भी इस ब्रह्म-ज्ञान (उपनिषद) को इस प्रकार गहराई से जान लेता है और अपने जीवन में उतारता है।
            वह अपने सभी पापों (अज्ञान और बुराइयों) को पूरी तरह नष्ट कर देता है।
            और वह अनंत, सबसे महान और आनंदमय स्वर्गीय लोक (यानी मोक्ष या परब्रह्म की स्थिति) में हमेशा के लिए स्थापित हो जाता है, हाँ, वह हमेशा के लिए स्थापित हो जाता है।
            यह केन उपनिषद का अंतिम श्लोक और फलश्रुति (परिणाम) है।
            यहाँ 'स्वर्ग' का अर्थ मृत्यु के बाद मिलने वाली सुख-सुविधाओं वाली जगह नहीं है, बल्कि यह असीम शांति और परमानंद की वह स्थिति है जहाँ कोई दुख नहीं पहुँच सकता।
            ज्ञान ही वह आग है जो सभी पुराने पापों (बुरे कर्मों) को जला देती है।
            "प्रतितिष्ठति" (स्थापित हो जाता है) शब्द का दो बार प्रयोग यह ज़ोर देकर बताने के लिए किया गया है कि यह सत्य अटल है और ज्ञानी कभी उस परमानंद की स्थिति से नीचे नहीं गिरता।
            यही मानव जीवन की सबसे बड़ी और अंतिम विजय है।
        """.trimIndent(),
        english = """
            Whoever profoundly understands and integrates this Upanishadic knowledge of Brahman into their life in this manner.
            He completely shakes off and destroys all his sins, ignorance, and evil tendencies.
            And he becomes firmly established in the infinite, supreme, and most blissful heavenly realm (the state of ultimate liberation), yes, he is firmly established.
            This is the final, concluding verse of the Kena Upanishad, stating the ultimate reward (Phalashruti) of this wisdom.
            'Heaven' (Swarga) here does not refer to a temporary post-death resort of physical pleasures, but the infinite, unshakeable state of supreme peace and bliss.
            True spiritual knowledge is the fire that incinerates all past karmas and sins.
            The repetition of the word "Pratitishthati" (firmly established) is used to strongly emphasize absolute certainty; the enlightened soul never falls back into ignorance.
            Achieving this eternal union with the Divine is the grandest, ultimate victory of human existence.
        """.trimIndent()
    )
)