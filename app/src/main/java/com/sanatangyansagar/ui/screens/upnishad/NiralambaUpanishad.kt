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
data class NiralambaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NiralambaUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..38) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Question Number (1-38)") },
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
            itemsIndexed(niralambaShlokasList) { _, shloka ->
                NiralambaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun NiralambaShlokaCard(shloka: NiralambaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Question ${shloka.id}",
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
                text = "हिन्दी व्याख्या:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Definition:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

val niralambaShlokasList: List<NiralambaShloka> = listOf(
    NiralambaShloka(
        id = 1,
        sanskrit = "किं ब्रह्म ? तन्महदादिपिण्डपर्यन्तं...",
        hindi = """
            प्रश्न: ब्रह्म क्या है? उत्तर: वह जो महत्तत्व से लेकर शरीर तक व्याप्त है।
            ब्रह्म वह सर्वोच्च चेतना है जो इस पूरे ब्रह्मांड का एकमात्र आधार है।
            वह अद्वितीय (एकमात्र), माया से रहित, और सभी दिशाओं में अनंत है।
            वह सत्य, ज्ञान और आनंद स्वरूप है जिसे शब्दों में नहीं बाँधा जा सकता।
            ब्रह्म ही वह तत्व है जो सूक्ष्म से सूक्ष्म और विशाल से विशाल में है।
            दुनिया की हर वस्तु उसी एक चेतन शक्ति का प्रकट या अप्रकट रूप है।
            वह आकाश की तरह निर्मल है और किसी भी कर्म से कभी मलिन नहीं होता।
            ब्रह्म को जान लेना ही मनुष्य के अस्तित्व की सबसे बड़ी और अंतिम सफलता है।
            वह न तो पैदा होता है और न ही समय के प्रभाव से कभी नष्ट होता है।
            ब्रह्म ही वह 'अकेला' सत्य है जिसके होने से यह सारा संसार सच लगता है।
        """.trimIndent(),
        english = """
            Question: What is Brahman? Answer: The Reality from Mahat to the body.
            Brahman is the Supreme Consciousness that acts as the sole base of the cosmos.
            He is non-dual (Unique), free from Maya, and infinite in all directions.
            His nature is Truth, Knowledge, and Bliss, beyond the reach of description.
            Brahman is the principle residing in the microscopic and the macroscopic.
            Every object in the world is a manifest or unmanifest form of that power.
            He is as pure as space and is never tainted by any worldly actions.
            Realizing Brahman is the greatest and final success of human existence.
            He is never born and never undergoes destruction through the influence of time.
            Brahman is the 'Only' Truth, due to which this entire world appears real.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 2,
        sanskrit = "क ईश्वरः ? ब्रह्मैव स्वशक्तिप्रकृत्या...",
        hindi = """
            प्रश्न: ईश्वर कौन है? उत्तर: अपनी माया शक्ति के साथ प्रकट ब्रह्म ही ईश्वर है।
            जब निराकार ब्रह्म सृष्टि की रचना के लिए अपनी 'प्रकृति' को स्वीकार करता है।
            तब वह ब्रह्मा, विष्णु और महेश के रूप में लोकों का सृजन और पालन करता है।
            वह संसार का नियंता (Controller) है जो जीवों को उनके कर्मफल देता है।
            ईश्वर वह सत्ता है जो भक्तों की करुणा भरी पुकार पर अपनी कृपा बरसाती है।
            यद्यपि वह सगुण दिखता है, पर वास्तव में वह निर्गुण ब्रह्म से अलग नहीं है।
            वह ब्रह्मांड का नायक है जो धर्म की रक्षा के लिए विभिन्न अवतार धारण करता है।
            ईश्वर की शक्ति से ही सूर्य चमकता है और वायु अपना कार्य करती है।
            वह सर्वज्ञ है, यानी वह हर जीव के मन के गुप्त विचारों को भी जानता है।
            ईश्वर ही वह सीढ़ी है जिसके माध्यम से जीव परम पद (मोक्ष) तक पहुँचता है।
        """.trimIndent(),
        english = """
            Question: Who is Ishvara? Answer: Brahman manifest through His own power.
            When the formless Brahman accepts His 'Prakriti' for the sake of creation.
            He then functions as Brahma, Vishnu, and Shiva to create and sustain worlds.
            He is the absolute Controller of the world who dispenses fruits of actions.
            Ishvara is the reality that showers grace upon the compassionate calls of devotees.
            Though He appears Saguna, He is in truth not different from Nirguna Brahman.
            He is the cosmic Hero who assumes various avatars to protect Righteousness.
            It is solely by His power that the sun shines and the wind performs its duty.
            He is Omniscient, meaning He knows even the secret thoughts of every being.
            Ishvara is the divine ladder through which the soul reaches the Supreme State.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 3,
        sanskrit = "को जीवः ? ब्रह्मविष्ण्वीशानेन्द्रनामरूपद्वारा...",
        hindi = """
            प्रश्न: जीव कौन है? उत्तर: जो अहंकार वश खुद को शरीर और नाम में सीमित माने।
            जब वह अनंत चेतना खुद को ब्रह्मा, विष्णु या एक साधारण मनुष्य मानने लगती है।
            तो वह अज्ञान के कारण 'जीव' कहलाती है और सुख-दुख के जाल में फँसती है।
            जीव वह है जो स्वयं को कर्ता और भोक्ता मानकर कर्मों के बंधन में बँधता है।
            वास्तव में जीव और ईश्वर में कोई अंतर नहीं है, केवल उपाधि का भेद है।
            जैसे घटाकाश (घड़े का आकाश) और महाकाश एक ही हैं, वैसे ही जीव ब्रह्म है।
            जीव होने का अर्थ है—स्वयं को एक नाशवान और सीमित इकाई (Entity) समझना।
            वह वासनाओं के कारण एक शरीर से दूसरे शरीर में भटकता रहता है।
            जब जीव का 'अहंकार' मिटता है, तो वह पुनः अपने शिव-स्वरूप को पा लेता है।
            जीव होना केवल एक अस्थायी भूमिका है जो अज्ञान के परदे पर चल रही है।
        """.trimIndent(),
        english = """
            Question: Who is the Jiva? Answer: One who identifies with names and forms.
            When the infinite Awareness begins to consider itself as a limited personality.
            Then due to ignorance, it is called 'Jiva' and is caught in the web of duality.
            A Jiva is one who believes himself to be the doer and the enjoyer of actions.
            In reality, there is no difference between Jiva and Ishvara except the label.
            As the space in a pot and the infinite space are one, the Jiva is Brahman.
            Being a Jiva means perceiving oneself as a perishable and finite entity.
            Due to latent desires, the Jiva wanders from one physical body to another.
            When the 'Ego' of the Jiva dissolves, it regains its original Shiva-nature.
            Being a Jiva is merely a temporary role projected on the screen of ignorance.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 4,
        sanskrit = "का प्रकृतिः ? ब्रह्मणः शक्तिरेव...",
        hindi = """
            प्रश्न: प्रकृति क्या है? उत्तर: ब्रह्म की वह बुद्धि स्वरूपा शक्ति जो जगत रचती है।
            यह ईश्वर की वह इच्छा शक्ति है जिससे यह सारा जड़-चेतन संसार प्रकट होता है।
            प्रकृति ही सत्व, रज और तम—इन तीन गुणों के माध्यम से विविधता पैदा करती है।
            इसे 'माया' भी कहा जाता है क्योंकि यह सत्य को छिपाकर असत्य को दिखाती है।
            यह जड़ है, पर चेतना के सानिध्य में आने पर यह सजीव की तरह व्यवहार करती है।
            प्रकृति ही जीव के लिए भोग के साधन (शरीर और इंद्रियां) तैयार करती है।
            यह निरंतर परिवर्तनशील है, जबकि इसका स्वामी (पुरुष) हमेशा स्थिर रहता है।
            सृष्टि के आरंभ में यह जाग्रत होती है और प्रलय में ब्रह्म में लीन हो जाती है।
            प्रकृति को समझ लेना ही माया के बंधन से मुक्त होने की दिशा में पहला कदम है।
            यह साक्षात् परब्रह्म की वह दिव्य कला है जिससे वह अपना खेल (लीला) रचता है।
        """.trimIndent(),
        english = """
            Question: What is Prakriti? Answer: The creative power of Brahman Himself.
            This is the will-power of God from which this entire world of matter emerges.
            Prakriti creates diversity through the three Gunas: Sattva, Rajas, and Tamas.
            It is also called 'Maya' because it veils the Truth and projects the false.
            It is inert, but in the presence of Consciousness, it behaves as if alive.
            Prakriti prepares the instruments of enjoyment (body and senses) for the soul.
            It is constantly changing, while its Master (the Purusha) remains steady.
            It awakens at the start of creation and dissolves back into Brahman at the end.
            Understanding Prakriti is the first step toward liberation from the bonds of Maya.
            It is the divine art of the Supreme Brahman through which He stages His Play.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 5,
        sanskrit = "कः परमात्मा ? देहाद्यतिरिक्तं ब्रह्माद्येव...",
        hindi = """
            प्रश्न: परमात्मा कौन है? उत्तर: जो देह आदि से परे और ब्रह्म स्वरूप है।
            वह आत्मा जो सभी शरीरों के भीतर साक्षी रूप में स्थित और सबसे श्रेष्ठ है।
            परमात्मा वह है जिस पर सुख, दुख, पाप या पुण्य का कोई असर नहीं होता।
            वह स्वयं प्रकाशमान है और सूरज, चाँद व मन को भी प्रकाशित करता है।
            वह न तो कभी बँधता है और न ही उसे कभी मुक्त करने की आवश्यकता होती है।
            वह घट-घट वासी है, यानी वह ब्रह्मांड के हर कण में पूर्ण रूप से व्याप्त है।
            परमात्मा को पहचानना ही जीवन के सभी दुखों का एकमात्र और अंतिम अंत है।
            वह अजर, अमर और अविनाशी सत्य है जो समय के प्रवाह से हमेशा अछूता है।
            जब जीव अपना 'मैं' छोड़ता है, तो उसे अहसास होता है कि वही परमात्मा है।
            यही वह लक्ष्य है जिसे पाने के लिए सभी योग और साधनाएं की जाती हैं।
        """.trimIndent(),
        english = """
            Question: Who is Paramatman? Answer: The Reality beyond the physical body.
            The Soul that resides within all bodies as the Witness and is the Highest.
            Paramatman is He upon whom pleasure, pain, sin, or merit has zero effect.
            He is self-luminous and illuminates the sun, the moon, and the human mind.
            He is never bound, and therefore, He never needs to be liberated at all.
            He is the indweller of all, meaning He pervades every atom of the universe.
            Recognizing Paramatman is the only and final end to all human suffering.
            He is the ageless, immortal, and indestructible Truth untouched by time.
            When the soul drops its 'I', it realizes that it indeed is the Paramatman.
            This is the ultimate goal for which all yogas and practices are performed.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 6,
        sanskrit = "को देवः ? स्वप्रकाशचैतन्यं...",
        hindi = """
            प्रश्न: देव कौन है? उत्तर: जो स्वयं प्रकाशमान चेतना (चित्) स्वरूप है।
            देव वह है जिसके प्रकाश से यह सारा संसार और हमारी बुद्धि प्रकाशित होती है।
            ब्रह्मा, विष्णु और महेश उस एक ही 'देव' की विभिन्न कार्यगत अभिव्यक्तियाँ हैं।
            'देव' शब्द 'दिव्' धातु से बना है, जिसका अर्थ है—चमकना या प्रकाश देना।
            वह चेतना ही असली देव है जो इंद्रियों और मन को काम करने की शक्ति देती है।
            बाहरी मूर्तियां उस एक आंतरिक 'देव' तक पहुँचने के प्रतीकात्मक माध्यम हैं।
            वह पवित्रता का पुंज है और अंधकार (अज्ञान) को मिटाने वाला परम सूर्य है।
            देवता वे हैं जो हमें सत्य, न्याय और करुणा के मार्ग पर चलने की प्रेरणा देते हैं।
            असली पूजा उस देव को अपने ही हृदय के भीतर अनुभव और साक्षात् करना है।
            जब साधक खुद को शुद्ध कर लेता है, तो वह स्वयं देव-तुल्य होकर आनंद पाता है।
        """.trimIndent(),
        english = """
            Question: Who is Deva? Answer: The Reality which is self-luminous Awareness.
            Deva is He by whose light this entire world and our intellect are illuminated.
            Brahma, Vishnu, and Shiva are various functional expressions of that one Deva.
            The word 'Deva' is derived from 'Div', which means to shine or grant light.
            That Consciousness is the real Deva providing power to the senses and mind.
            External idols are symbolic mediums to reach that one internal radiant Deva.
            He is the mass of purity and the Supreme Sun that destroys darkness (ignorance).
            Gods are those who inspire us to walk the path of truth, justice, and mercy.
            Real worship is experiencing and realizing that Deva right within one's heart.
            When a seeker purifies himself, he becomes god-like and attains supreme bliss.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 7,
        sanskrit = "का जातिः ? चर्ममांसरुधिरस्थिरेतोजातस्य...",
        hindi = """
            प्रश्न: जाति क्या है? उत्तर: यह केवल इस हाड़-मांस के शरीर का एक धर्म है।
            आत्मा की कोई जाति नहीं होती; जाति केवल भौतिक शरीर की एक पहचान मात्र है।
            त्वचा, मांस, रक्त और हड्डियों से बने इस ढांचे को ही लोग जातियों में बाँटते हैं।
            व्यवहार की दृष्टि से समाज को चलाने के लिए वर्ण बनाए गए, पर सत्य में वे नहीं हैं।
            उपनिषद स्पष्ट करता है कि ब्राह्मण, क्षत्रिय आदि भेद केवल सामाजिक व्यवस्था हैं।
            चेतना (आत्मा) न तो ऊंची होती है और न ही नीची; वह सबमें एक समान है।
            जाति का अहंकार आत्मज्ञान के मार्ग में एक बहुत बड़ी बाधा और रुकावट है।
            जो व्यक्ति जातियों के भेद को पकड़ कर बैठा है, वह कभी सत्य को नहीं जान सकता।
            एक ज्ञानी पुरुष सभी प्राणियों में एक ही अविनाशी आत्म-तत्व को देखता है।
            जाति-भेद से ऊपर उठना ही मनुष्य की आध्यात्मिक परिपक्वता का सच्चा प्रमाण है।
        """.trimIndent(),
        english = """
            Question: What is Caste (Jati)? Answer: A property of the flesh-and-bone body.
            The Soul has no caste; Jati is merely a label of the physical physical form.
            People divide this structure of skin, flesh, blood, and bones into castes.
            Varnas were created for social functioning, but they do not exist in Truth.
            The Upanishad clarifies that labels like Brahmin or Kshatriya are social setups.
            Consciousness (Atman) is neither high nor low; it is identical in everyone.
            The pride of caste is a massive obstacle and barrier on the path of wisdom.
            One who clings to the distinctions of caste can never truly know the Truth.
            A realized man sees the same indestructible Soul-principle in all creatures.
            Rising above caste distinctions is the true proof of spiritual maturity.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 8,
        sanskrit = "किं कर्म ? इन्द्रियैः क्रियमाणं...",
        hindi = """
            प्रश्न: कर्म क्या है? उत्तर: इंद्रियों द्वारा ईश्वर को अर्पण किए गए कार्य।
            कर्म वह क्रिया है जो हम मन, वाणी और शरीर के माध्यम से संसार में करते हैं।
            जब कर्म 'अहंकार' से किया जाता है, तो वह बंधन और जन्म का कारण बनता है।
            परंतु जब वही कर्म 'निष्काम' भाव से होता है, तो वह चित्त की शुद्धि करता है।
            कर्म का अर्थ केवल हाथ-पैर चलाना नहीं, बल्कि विचार करना भी एक कर्म है।
            यह संसार कर्मों का ही एक विस्तृत जाल है जहाँ हर क्रिया की प्रतिक्रिया होती है।
            अध्यात्म का उद्देश्य कर्म छोड़ना नहीं, बल्कि कर्म में 'कर्ता-भाव' को छोड़ना है।
            सच्चा कर्म वह है जो हमें वासनाओं से मुक्त करके शांति की ओर ले जाए।
            ईश्वर को साक्षी मानकर किया गया हर कार्य साक्षात् पूजा और यज्ञ बन जाता है।
            कर्म ही वह माध्यम है जिससे हम अपने प्रारब्ध को काटते और नया भविष्य बुनते हैं।
        """.trimIndent(),
        english = """
            Question: What is Karma? Answer: Actions performed by senses offered to God.
            Karma is the activity we perform through the mind, speech, and the body.
            When action is performed with 'Ego', it causes bondage and repeated rebirths.
            But when the same action is 'Desireless', it purifies the inner consciousness.
            Karma does not only mean physical movement; even thinking is a form of Karma.
            The world is a vast web of karmas where every action has an equal reaction.
            The goal of spirituality is not to quit action, but to quit the sense of doership.
            True Karma is that which frees us from lusts and leads us toward total peace.
            Every task performed keeping God as the Witness becomes a worship and Yajna.
            Karma is the medium through which we exhaust past destiny and weave a future.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 9,
        sanskrit = "किं अकर्म ? कर्तृत्वभोक्तृत्वाद्यहंकाररहितं...",
        hindi = """
            प्रश्न: अकर्म क्या है? उत्तर: कर्ता और भोक्ता के अहंकार से रहित होना।
            अकर्म का अर्थ काम न करना नहीं है, बल्कि काम करते हुए भी 'अलिप्त' रहना है।
            जब साधक जान लेता है कि "मैं कुछ नहीं कर रहा", तो वह अकर्म की स्थिति में है।
            यह वह मानसिक शांति है जहाँ कर्मों के अच्छे-बुरे फल हमें छू नहीं पाते।
            जैसे सूरज दुनिया को प्रकाश देता है पर वह कर्म में नहीं फँसता, वैसा ही अकर्म है।
            अकर्म ही वह कुंजी (Key) है जिससे कर्मों का बंधन हमेशा के लिए कट जाता है।
            यह अहंकार का पूर्ण समर्पण है, जहाँ ईश्वर ही एकमात्र कर्ता महसूस होता है।
            बिना अकर्म को समझे, मनुष्य कर्मों के पहाड़ के नीचे दबकर दुखी होता रहता है।
            भीतर से अचल (स्थिर) रहना और बाहर से सक्रिय रहना ही अकर्म का रहस्य है।
            जो अकर्म में स्थित है, वह संसार में रहते हुए भी संसार से पूरी तरह मुक्त है।
        """.trimIndent(),
        english = """
            Question: What is Akarma? Answer: Being free from doership and enjoyership.
            Akarma does not mean idleness, but remaining 'unattached' while performing tasks.
            When a seeker realizes "I am doing nothing," he is in the state of Akarma.
            It is that mental peace where the good or bad fruits of actions cannot touch us.
            As the sun lights the world without getting caught in actions, such is Akarma.
            Akarma is the absolute key through which the bondage of karma is severed forever.
            It is the total surrender of ego, where God is felt as the only actual Doer.
            Without understanding Akarma, man remains crushed under the mountain of deeds.
            Remaining unmoving (still) inside while being active outside is the secret.
            One who is established in Akarma is entirely free even while living in the world.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 10,
        sanskrit = "किं ज्ञानम् ? स्वस्वरूपानुसन्धानं ज्ञानम् ।",
        hindi = """
            प्रश्न: ज्ञान क्या है? उत्तर: अपने वास्तविक स्वरूप का अनुसंधान (अनुभव) करना।
            ज्ञान केवल सूचनाओं का संग्रह नहीं है, बल्कि यह 'स्व' (Self) की जागृति है।
            यह जानना कि "मैं शरीर नहीं, आत्मा हूँ" — यही वास्तविक और सर्वोच्च ज्ञान है।
            ज्ञान वह अग्नि है जो करोड़ों जन्मों के संचित पापों को एक क्षण में जला देती है।
            यह अविद्या के अंधेरे को मिटाकर जीवन में स्पष्टता और शांति लेकर आता है।
            सच्चा ज्ञान हमें अभय (Fearless) बनाता है क्योंकि आत्मा कभी मरती नहीं है।
            शास्त्रों का पढ़ना केवल रास्ता है, उस सत्य को महसूस करना ही असली मंजिल है।
            ज्ञान होने पर दुनिया का आकर्षण खत्म हो जाता है और ईश्वर का प्रेम जाग्रत होता है।
            यह वह आँख है जिससे हम दृश्य प्रपञ्च के पीछे छिपे हुए अदृश्य सत्य को देखते हैं।
            ज्ञान ही वह नौका है जिससे मनुष्य इस भयंकर संसार सागर को सुगमता से पार करता है।
        """.trimIndent(),
        english = """
            Question: What is Jnana? Answer: The realization of one's own true nature.
            Knowledge is not merely a collection of data, but the awakening of the Self.
            Realizing that "I am not the body, but the Soul"—this is the ultimate Jnana.
            Jnana is the fire that burns the sins of millions of births in a single moment.
            It dispels the darkness of Avidya and brings absolute clarity and peace to life.
            True knowledge makes us fearless because the Soul is fundamentally immortal.
            Reading scriptures is just the path; feeling the Truth is the actual destination.
            Upon gaining Jnana, worldly allure ends and the love for God truly awakens.
            It is the eye through which we see the invisible Truth behind the manifest world.
            Jnana is the boat with which man easily crosses this terrifying ocean of existence.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 11,
        sanskrit = "किं अज्ञानम् ? रज्जौ सर्पभ्रान्तिरिवात्मन्यनात्मबुद्धिः...",
        hindi = """
            प्रश्न: अज्ञान क्या है? उत्तर: जैसे रस्सी में सांप का भ्रम, वैसे ही आत्मा में देह बुद्धि।
            अज्ञान वह शक्ति है जो सत्य को ढँक लेती है और असत्य को सच जैसा दिखाती है।
            जब हम खुद को नाशवान शरीर और मन मानते हैं, तो हम घोर अज्ञान में होते हैं।
            यह अज्ञान ही सभी दुखों, चिंताओं और बार-बार जन्म लेने का एकमात्र मूल कारण है।
            अज्ञानी मनुष्य छाया (संसार) को पकड़ता है और असली वस्तु (आत्मा) को भूल जाता है।
            अज्ञान कोई बाहरी चीज़ नहीं है, यह मन की वह अशुद्धि है जो विवेक को ढँक देती है।
            जब तक अज्ञान है, तब तक इंसान मौत से डरेगा और वासनाओं का गुलाम बना रहेगा।
            जैसे रोशनी आने पर अंधेरा गायब होता है, वैसे ही विचार से अज्ञान मिट जाता है।
            संसार की सभी समस्याएं अज्ञान के ही अलग-अलग कड़वे और विषैले फल मात्र हैं।
            अज्ञान को पहचानना ही उसे दूर करने और ज्ञान की ओर बढ़ने की पहली शुरुआत है।
        """.trimIndent(),
        english = """
            Question: What is Ajnana? Answer: Perceiving the body as the Self, like a snake in a rope.
            Ignorance is the power that veils the Truth and projects the false as reality.
            When we identify as the perishable body and mind, we are in deep Ajnana.
            This ignorance is the sole root cause of all grief, worry, and repeated rebirths.
            The ignorant person chases the shadow (world) and forgets the reality (Soul).
            Ignorance is not external; it is the impurity of mind that covers discrimination.
            As long as Ajnana lasts, man will fear death and remain a slave to his lusts.
            Just as darkness vanishes when light arrives, Ajnana ends through Self-inquiry.
            All problems of the world are merely different bitter fruits of this ignorance.
            Identifying one's ignorance is the very first step toward attaining true Wisdom.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 12,
        sanskrit = "किं सुखम् ? सच्चिदानन्दस्वरूपज्ञानानन्दः सुखम् ।",
        hindi = """
            प्रश्न: सुख क्या है? उत्तर: सच्चिदानंद स्वरूप के ज्ञान से प्राप्त होने वाला आनंद।
            असली सुख किसी बाहरी वस्तु (मोबाइल, पैसा, पद) से नहीं, बल्कि आत्मा से आता है।
            संसार के सुख 'क्षणिक' (Temporary) हैं, पर आत्मा का सुख 'शाश्वत' (Permanent) है।
            जब मन पूरी तरह शांत और निर्विषय होता है, तब जो झलकता है वही असली सुख है।
            सच्चिदानंद का अर्थ है—जो हमेशा रहे (सत्), जो चेतन हो (चित्) और जो प्यारा हो (आनंद)।
            यह वह सुख है जिसे दुनिया की कोई भी परिस्थिति हमसे कभी छीन नहीं सकती।
            बाहरी सुखों के बाद हमेशा दुख आता है, पर इस आंतरिक सुख के बाद केवल शांति है।
            हम जिसे सुख समझकर भाग रहे हैं, वह वास्तव में केवल दुखों का एक छोटा सा ब्रेक है।
            आत्मानंद ही वह खजाना है जिसे पाने के बाद इंसान को फिर कुछ पाना शेष नहीं रहता।
            यह सुख हमारे भीतर ही है, हमें बस अज्ञान की धूल हटाकर इसे महसूस करना है।
        """.trimIndent(),
        english = """
            Question: What is Sukha? Answer: Bliss arising from the knowledge of the Self.
            Real happiness comes not from external objects, but directly from the Soul.
            Worldly joys are 'temporary', whereas the joy of the Soul is 'eternal'.
            When the mind is perfectly calm and free of objects, real happiness reflects.
            Satchidananda means: Eternal (Sat), Conscious (Chit), and Blissful (Ananda).
            This is the happiness that no worldly circumstance can ever snatch from us.
            Worldly joy is followed by grief, but this internal bliss is followed by peace.
            What we chase as happiness is actually just a brief pause between two sorrows.
            Self-bliss is the treasure after attaining which nothing else remains to be sought.
            This bliss is right within us; we only need to remove the dust of ignorance to feel it.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 13,
        sanskrit = "किं दुःखम् ? अनात्मविषयसंकल्पो दुःखम् ।",
        hindi = """
            प्रश्न: दुख क्या है? उत्तर: अनात्मा (संसार) के विषयों का संकल्प करना ही दुख है।
            जब मन यह सोचता है कि "मुझे यह चाहिए", तो वहीं से दुख का बीज बोया जाता है।
            इच्छाओं का पूरा न होना दुख है, और उनके पूरा होने पर खो जाने का डर भी दुख है।
            अनात्मा यानी शरीर और संसार की नाशवान चीजों से सुख की उम्मीद करना ही मूर्खता है।
            दुख हमारे मन की एक गलत आदत है जो बाहर की गुलामी करने से पैदा होती है।
            जितनी ज्यादा ममता और आसक्ति (Attachment) होगी, उतना ही गहरा दुख झेलना पड़ेगा।
            दुख कोई सजा नहीं है, यह एक सिग्नल (Signal) है कि हम सत्य से बहुत दूर जा रहे हैं।
            जब हम खुद को 'कर्ता' मानते हैं, तो कर्मों का बोझ हमें दुख के रूप में महसूस होता है।
            संसार में कहीं भी दुख नहीं है, दुख केवल हमारे 'संकल्पों' और 'अपेक्षाओं' में छिपा है।
            इच्छाओं का त्याग (Desirelessness) ही दुनिया में दुख को जड़ से मिटाने का इकलौता इलाज है।
        """.trimIndent(),
        english = """
            Question: What is Duhkha? Answer: Contemplating the objects of the non-Self.
            When the mind thinks "I want this," the very seed of sorrow is sown there.
            Unfulfilled desires cause grief, and the fear of losing fulfilled ones is also grief.
            Expecting joy from the non-Self (perishable objects) is the height of folly.
            Sorrow is a bad habit of the mind arising from slavery to external things.
            The more possessiveness and attachment one has, the deeper the grief one bears.
            Sorrow is not a punishment; it is a signal that we are moving away from Truth.
            When we consider ourselves the 'Doer', the burden of karma is felt as sorrow.
            Sorrow exists nowhere in the world; it hides only in our resolves and expectations.
            Renouncing desires (Desirelessness) is the only cure to uproot sorrow from the world.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 14,
        sanskrit = "कः स्वर्गः ? सत्संसर्गः स्वर्गः ।",
        hindi = """
            प्रश्न: स्वर्ग क्या है? उत्तर: सत्य का संसर्ग (सत्संग) ही वास्तविक स्वर्ग है।
            स्वर्ग कोई बादलों के ऊपर स्थित जगह नहीं है, बल्कि यह चेतना की एक ऊँची स्थिति है।
            जब हम महान संतों और सत्य के विचारों के साथ रहते हैं, तो हम स्वर्ग में होते हैं।
            जहाँ मन शांत है, जहाँ ईर्ष्या और क्रोध नहीं है, वही स्थान साक्षात् स्वर्ग है।
            सत्य की चर्चा और ईश्वर का स्मरण हृदय में स्वर्ग के सुख का अनुभव कराता है।
            सत्संग का अर्थ है—सत्य के साथ जुड़ना, चाहे वह भीतर हो या बाहर के किसी गुरु में।
            स्वर्ग वह मानसिक अवस्था है जहाँ मनुष्य को अपनी आत्मा की पवित्रता का अहसास होता है।
            जो व्यक्ति हमेशा अच्छे विचारों में रहता है, उसके लिए यह धरती ही स्वर्ग बन जाती है।
            संसार के सभी भौतिक सुख मिलकर भी सत्संग की एक घड़ी के सुख की बराबरी नहीं कर सकते।
            स्वर्ग को बाहर ढूँढना अज्ञान है; इसे अपनी संगति और विचारों में ढूँढना ही बुद्धिमानी है।
        """.trimIndent(),
        english = """
            Question: What is Svarga? Answer: Association with the Truth (Satsanga).
            Heaven is not a location above the clouds; it is an elevated state of consciousness.
            When we reside with great saints and truthful thoughts, we are in heaven.
            Where the mind is calm, and where envy and anger are absent, that place is heaven.
            Discussing Truth and remembering God allows one to feel heavenly bliss in the heart.
            Satsanga means joining with the Truth, whether internally or through an external Guru.
            Heaven is the mental state where a human realizes the purity of his own Soul.
            For one who constantly dwells in noble thoughts, this very earth becomes heaven.
            All worldly pleasures combined cannot match the joy of a single moment of Satsanga.
            Searching for heaven outside is ignorance; finding it in your company and thoughts is wisdom.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 15,
        sanskrit = "को नरकः ? असत्संसारविषयजनसंसर्गो नरकः ।",
        hindi = """
            प्रश्न: नरक क्या है? उत्तर: असत्य, संसारी और विषयी लोगों की संगति ही नरक है।
            नरक वह मानसिक स्थिति है जहाँ मन वासनाओं, नफरत और लालच की आग में जलता है।
            जब हम बुरे विचारों और स्वार्थी लोगों के बीच रहते हैं, तो हम साक्षात् नरक झेलते हैं।
            विषयों की गुलामी और अहंकार का बढ़ जाना ही नरक के द्वार खोलना है।
            जहाँ शांति नहीं है और जहाँ केवल छलावा है, वही स्थान नरक के समान दुखदायी है।
            असत् का अर्थ है वह जो टिकने वाला नहीं है; उसके पीछे भागना ही नरक की यात्रा है।
            क्रोध, काम और लोभ—इन तीनों को शास्त्रों में नरक का सीधा रास्ता बताया गया है।
            नरक कोई गड्ढा नहीं है, बल्कि यह हमारे ही मन की एक विकृत और गंदी अवस्था है।
            जो व्यक्ति हमेशा दूसरों की बुराई और षडयंत्र में लगा रहता है, वह जीते-जी नरक में है।
            बुरे लोगों की संगति से बचकर आत्म-चिंतन में लगना ही नरक से बचने का इकलौता उपाय है।
        """.trimIndent(),
        english = """
            Question: What is Naraka? Answer: Association with untruthful and worldly people.
            Hell is the mental condition where the mind burns in the fire of lust, hate, and greed.
            When we live amidst evil thoughts and selfish people, we experience direct hell.
            Slavery to objects and the inflation of ego is opening the very gates of hell.
            Where there is no peace and only deception exists, that place is as painful as hell.
            'Asat' means that which is not permanent; chasing it is the journey to hell.
            Anger, Lust, and Greed—these three are declared the direct paths to hell in scriptures.
            Hell is not a pit; it is a distorted and polluted state of our very own mind.
            A person constantly engaged in backbiting and conspiracies is in hell while alive.
            Avoiding evil company and engaging in Self-reflection is the only way to escape hell.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 16,
        sanskrit = "को बन्धः ? अहमेवेति संकल्पो बन्धः ।",
        hindi = """
            प्रश्न: बंधन क्या है? उत्तर: "मैं ही कर्ता हूँ" ऐसा संकल्प (अहंकार) ही बंधन है।
            जब चेतना खुद को एक छोटे से शरीर की सीमा में कैद कर लेती है, तो वह बँध जाती है।
            "यह मेरा है" और "वह तेरा है"—यह ममता ही वह धागा है जिससे बंधन बनता है।
            बंधन कोई बाहरी चीज़ नहीं है, यह हमारी अपनी ही मान्यताओं की एक जेल है।
            इच्छाओं की जंजीरें लोहे की जंजीरों से भी अधिक मजबूत और दुखदायी होती हैं।
            जब हम प्रकृति के गुणों के साथ खुद को जोड़ लेते हैं, तो हम अपनी आज़ादी खो देते हैं।
            अज्ञान ही वह रस्सी है जिससे जीव संसार रूपी खूँटे से कसकर बँधा हुआ है।
            बंधन का अर्थ है—अपनी खुशी के लिए किसी दूसरी वस्तु या व्यक्ति का गुलाम होना।
            यह 'अहंकार' ही है जो हमें अनंत से काटकर एक तुच्छ बिंदु (जीव) बना देता है।
            बंधन से मुक्त होने का अर्थ है उस 'मैं' को विलीन कर देना जो सत्य से अलग खड़ा है।
        """.trimIndent(),
        english = """
            Question: What is Bandha? Answer: The thought "I am the doer" (Ego) is bondage.
            When consciousness imprisons itself within the limits of a small body, it is bound.
            "This is mine" and "That is yours"—this possessiveness is the thread of bondage.
            Bondage is not an external thing; it is a prison made of our own deep-seated beliefs.
            The chains of desires are stronger and more painful than any iron shackles.
            When we identify ourselves with the qualities of nature, we lose our freedom.
            Ignorance is the rope with which the soul is tied to the peg of worldly existence.
            Bondage means being a slave to some other object or person for your own happiness.
            It is 'Ego' that cuts us off from the Infinite and makes us a trivial dot (the Jiva).
            To be freed from bondage means to dissolve the 'I' that stands separate from Truth.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 17,
        sanskrit = "किं तपः ? ब्रह्म सत्यं जगन्मिथ्येति...",
        hindi = """
            प्रश्न: तप क्या है? उत्तर: "ब्रह्म सत्य है और जगत मिथ्या है" इस विचार में स्थित होना।
            तप का अर्थ केवल शरीर को कष्ट देना नहीं, बल्कि मन को सत्य पर टिकाना है।
            इंद्रियों को विषयों से हटाकर अंतरात्मा में लगाना ही सबसे कठिन और श्रेष्ठ तप है।
            यह दृढ़ निश्चय कि "मैं अविनाशी आत्मा हूँ", मन की चंचलता को जलाने वाला तप है।
            संसार के द्वंद्वों (सुख-दुख, सर्दी-गर्मी) को शांति से सहना ही व्यावहारिक तप है।
            तप वह अग्नि है जो साधक के अंतःकरण की सभी अशुद्धियों को जलाकर कुन्दन बना देती है।
            बिना तप के बुद्धि सूक्ष्म नहीं होती और सूक्ष्म बुद्धि के बिना सत्य नहीं दिखता।
            स्वार्थ का त्याग और परोपकार में जीवन लगाना भी एक महान सामाजिक तप है।
            सच्चा तपस्वी वह है जिसका चित्त हर परिस्थिति में समुद्र की तरह गंभीर और शांत रहे।
            तप ही वह ऊर्जा है जो मनुष्य को साधारण जीव से महान योगी और ऋषि बनाती है।
        """.trimIndent(),
        english = """
            Question: What is Tapas? Answer: Firmly realizing "Brahman is True, world is unreal."
            Austerity is not just torturing the body, but anchoring the mind strictly on Truth.
            Withdrawing senses from objects and fixing them on the Soul is the highest Tapas.
            The firm resolve that "I am the immortal Soul" is the Tapas that burns restlessness.
            Enduring worldly dualities (joy-sorrow, heat-cold) with peace is practical Tapas.
            Tapas is the fire that burns all impurities of the heart and makes it pure as gold.
            Without Tapas, the intellect doesn't become subtle, and without that, Truth is unseen.
            Renouncing selfishness and dedicating life to others is also a great social Tapas.
            A true ascetic is one whose mind remains as deep and calm as the ocean in all states.
            Tapas is the energy that transforms an ordinary human into a great Yogi or Sage.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 18,
        sanskrit = "किं शत्रवः ? कामादय एव शत्रवः ।",
        hindi = """
            प्रश्न: शत्रु (दुश्मन) कौन हैं? उत्तर: काम, क्रोध, लोभ, मोह आदि ही असली शत्रु हैं।
            बाहरी शत्रु तो केवल शरीर को मार सकते हैं, पर ये आंतरिक शत्रु आत्मा को गिराते हैं।
            काम (वासना) हमारी शांति छीन लेता है और क्रोध हमारी बुद्धि को अंधा कर देता है।
            लोभ (लालच) हमें कभी संतुष्ट नहीं होने देता और मोह हमें अज्ञान में बाँधता है।
            ईर्ष्या और अहंकार वे गुप्त दुश्मन हैं जो हमारी सारी आध्यात्मिक कमाई को लूट लेते हैं।
            ये शत्रु हमारे ही मन में छिपे रहते हैं और हमें अपने असली स्वरूप से दूर रखते हैं।
            इन शत्रुओं को जीते बिना कोई भी व्यक्ति कभी भी स्वतंत्र या सुखी नहीं हो सकता।
            सच्चा योद्धा वह है जो तलवार से नहीं, बल्कि विवेक से अपने इन विकारों को मारता है।
            ज्ञान की तलवार ही इन शक्तिशाली और अदृश्य दुश्मनों का नाश करने में समर्थ है।
            शत्रुओं को बाहर ढूँढना बंद करो; अपने भीतर झाँको और इन्हें शांति से परास्त करो।
        """.trimIndent(),
        english = """
            Question: Who are the Enemies? Answer: Lust, Anger, Greed, and Delusion.
            External enemies can only harm the body, but these internal enemies degrade the Soul.
            Lust (Kama) snatches our peace, and Anger (Krodha) completely blinds our intellect.
            Greed (Lobha) never lets us be satisfied, and Delusion (Moha) binds us in ignorance.
            Envy and Pride are the secret thieves that rob us of all our spiritual merits.
            These enemies hide within our own minds and keep us distant from our true nature.
            Without conquering these, no human being can ever be truly free or genuinely happy.
            A true warrior is not one who uses a sword, but one who kills his vices via wisdom.
            The sword of Jnana is the only weapon capable of destroying these invisible foes.
            Stop searching for enemies outside; look within and defeat them through tranquility.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 19,
        sanskrit = "का भक्तिः ? गुरोः शिवस्य च...",
        hindi = """
            प्रश्न: भक्ति क्या है? उत्तर: गुरु और ईश्वर के प्रति अनन्य प्रेम और सेवा भाव।
            भक्ति का अर्थ केवल माला जपना नहीं, बल्कि अपने अहंकार को भगवान में विलीन करना है।
            यह वह प्रेम है जहाँ भक्त और भगवान के बीच कोई पर्दा या दूरी शेष नहीं रहती।
            भक्ति मन की वह परम शुद्धि है जो उसे संसार से हटाकर सत्य की ओर मोड़ देती है।
            सच्चा भक्त वही है जो हर जीव में अपने आराध्य (ईश्वर) के ही दर्शन करता है।
            भक्ति ज्ञान का ही एक सरस रूप है, जो हृदय को करुणा और आनंद से भर देता है।
            यह पूर्ण शरणागति (Surrender) है, जहाँ साधक अपनी मर्जी को ईश्वर की मर्जी मान लेता है।
            बिना भक्ति के ज्ञान सूखा है, और बिना ज्ञान के भक्ति केवल एक भावना का उफान है।
            भक्ति ही वह शक्ति है जो ईश्वर को निराकार से साकार रूप में प्रकट होने पर विवश करती है।
            जब प्रेम अपनी चरम सीमा पर पहुँचता है, तो भक्त स्वयं साक्षात् भक्ति-स्वरूप हो जाता है।
        """.trimIndent(),
        english = """
            Question: What is Bhakti? Answer: Exclusive love and service to Guru and God.
            Devotion is not just chanting beads; it is merging one's ego into the Divine.
            It is that supreme love where no veil or distance remains between devotee and God.
            Bhakti is the absolute purification of mind that turns it from the world to Truth.
            A true devotee is one who perceives his beloved Lord in every single living creature.
            Devotion is the succulent form of Jnana that fills the heart with mercy and bliss.
            It is total Surrender, where the seeker accepts God's will as his own final will.
            Without devotion, Jnana is dry; without Jnana, Bhakti is merely an emotional surge.
            Bhakti is the power that compels the formless God to manifest in a beautiful form.
            When love reaches its absolute peak, the devotee himself becomes the embodiment of Love.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 20,
        sanskrit = "का सरस्वती ? सद्रूपिणी सरस्वती ।",
        hindi = """
            प्रश्न: सरस्वती कौन है? उत्तर: सत्य का साक्षात् बोध कराने वाली वाणी ही सरस्वती है।
            सरस्वती केवल एक देवी नहीं, बल्कि वह शुद्ध ज्ञान है जो अज्ञान को नष्ट करता है।
            वह हमारी बुद्धि की वह पवित्रता है जो हमें सही और गलत का अंतर समझाती है।
            जब हमारी वाणी सत्य और प्रेम से युक्त होती है, तो साक्षात् सरस्वती उसमें बसती है।
            वह कला, संगीत और विज्ञान की अधिष्ठात्री है, जो आत्मा की अभिव्यक्ति (Expression) है।
            सरस्वती का अर्थ है—वह प्रवाह जो हमें जड़ता से चेतना की ओर निरंतर ले जाता है।
            वह ज्ञान की वह नदी है जो साधक के अंतःकरण की सारी गंदगी को धोकर साफ कर देती है।
            सच्चा विद्वान वही है जिसने अपने भीतर की सरस्वती (विवेक) को जागृत कर लिया है।
            बिना ज्ञान के जीवन अंधकारमय है; सरस्वती ही उस अंधकार में मशाल बनकर जलती है।
            सरस्वती की असली पूजा स्वाध्याय (Self-study) और सत्य का निरंतर आचरण करना ही है।
        """.trimIndent(),
        english = """
            Question: Who is Saraswati? Answer: The power of speech that reveals the Truth.
            Saraswati is not just a deity; she is the pure Wisdom that annihilates ignorance.
            She is the absolute purity of our intellect that teaches the difference between right/wrong.
            When our speech is endowed with truth and love, Saraswati herself resides within it.
            She is the presiding power of Arts, Music, and Science—the expression of the Soul.
            Saraswati means 'the flow' that continuously carries us from inertia toward awareness.
            She is the river of wisdom that washes away all the impurities of a seeker's heart.
            A true scholar is one who has awakened the Saraswati (discrimination) within himself.
            Life without wisdom is pitch dark; Saraswati is the torch that burns in that darkness.
            Real worship of Saraswati is Self-study and the consistent practice of the Truth.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 21,
        sanskrit = "कः संतोषः ? इष्टानिष्टप्राप्तौ...",
        hindi = """
            प्रश्न: संतोष (Contentment) क्या है? उत्तर: लाभ या हानि में मन का एक समान रहना।
            जब हमें मनचाही चीज़ मिले या न मिले, फिर भी मन शांत रहे—वही असली संतोष है।
            संतोष का अर्थ आलस्य नहीं, बल्कि अपनी मानसिक शांति को बाहर न बेचने की कला है।
            यह वह मानसिक अमीरी है जिसे पाने के बाद दुनिया का सारा धन फीका लगने लगता है।
            असंतोष ही सभी लोभ और ईर्ष्या की जड़ है जो इंसान को हमेशा बेचैन रखती है।
            संतोषी मनुष्य वह है जो वर्तमान पल में जीता है और भविष्य की व्यर्थ चिंता नहीं करता।
            यह भगवान पर उस अटूट विश्वास का नाम है कि "जो हो रहा है वह मेरे भले के लिए है।"
            संतोष ही वह सबसे बड़ी औषधि (Medicine) है जो मानसिक तनाव को जड़ से मिटाती है।
            जहाँ संतोष है, वहाँ शांति का वास है; जहाँ तृष्णा है, वहाँ दुखों का वास है।
            अपनी मेहनत का फल स्वीकार करना और अधिक की अंधी दौड़ में न फँसना ही संतोष है।
        """.trimIndent(),
        english = """
            Question: What is Santosha? Answer: Equanimity in both desirable and undesirable states.
            When we get what we want or we don't, yet the mind remains calm—that is contentment.
            Contentment is not laziness; it is the art of not selling your peace for external gains.
            It is that mental richness after attaining which all worldly wealth appears pale.
            Discontent is the root of all greed and envy that keeps a human perpetually restless.
            A contented man is one who lives in the present moment without future anxieties.
            It is the name of that firm faith in God: "Whatever is happening is for my ultimate good."
            Contentment is the greatest medicine that uproots mental stress from its very core.
            Where there is contentment, peace resides; where there is craving, sorrow resides.
            Accepting the fruits of one's labor without falling into the rat-race is contentment.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 22,
        sanskrit = "को विद्वान् ? स्वस्वरूपं यो विजानाति स विद्वान् ।",
        hindi = """
            प्रश्न: विद्वान कौन है? उत्तर: जो अपने वास्तविक स्वरूप (आत्मा) को जानता है।
            विद्वान वह नहीं है जिसने बहुत सारी किताबें पढ़ी हैं या जिसके पास बहुत डिग्रियां हैं।
            असली विद्वता तो वह है जो हमें अज्ञान के बंधनों से आज़ाद करके सत्य का दर्शन कराए।
            जो व्यक्ति जानता है कि "मैं अविनाशी आत्मा हूँ", वही ब्रह्मांड का सबसे बड़ा विद्वान है।
            दुनिया की जानकारी केवल 'साक्षरता' है, खुद की जानकारी ही असली 'विद्वता' है।
            विद्वान वह है जिसके शब्दों और आचरण में कोई भेद न हो और जो शांत स्वरूप हो।
            वह अपनी बुद्धि का उपयोग अहंकार बढ़ाने के लिए नहीं, बल्कि सत्य की सेवा के लिए करता है।
            विद्वान पुरुष सभी प्राणियों में एक ही परमात्मा को देखता है और सबसे प्रेम करता है।
            उसकी दृष्टि में सोना और मिट्टी एक समान हैं, क्योंकि वह केवल सार तत्व को देखता है।
            सच्चा विद्वान वही है जिसकी उपस्थिति मात्र से दूसरों का अज्ञान और संशय मिट जाए।
        """.trimIndent(),
        english = """
            Question: Who is a Scholar (Vidvan)? Answer: He who knows his own true nature.
            A scholar is not one who has read many books or possesses numerous academic degrees.
            Real scholarship is that which liberates us from the bonds of ignorance and reveals Truth.
            The person who realizes "I am the indestructible Soul" is the greatest scholar in the cosmos.
            Worldly information is merely 'literacy'; knowing the Self is the only real 'scholarship'.
            A scholar is one whose words and conduct have no gap and who is the embodiment of peace.
            He utilizes his intellect not to inflate his ego, but to serve the cause of Truth.
            A wise scholar perceives the same God in all beings and loves everyone unconditionally.
            In his vision, gold and dirt are equal, as he focuses only on the essential essence.
            A true Vidvan is he whose mere presence dispels the doubts and ignorance of others.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 23,
        sanskrit = "किं चक्षुः ? अज्ञानतमोनिवर्तकं ज्ञानं चक्षुः ।",
        hindi = """
            प्रश्न: आँख (दृष्टि) क्या है? उत्तर: अज्ञान के अंधकार को मिटाने वाला ज्ञान ही आँख है।
            हमारी ये भौतिक आँखें केवल बाहर की नाशवान चीज़ों और रंगों को ही देख सकती हैं।
            परंतु ज्ञान रूपी आँख वह है जो अदृश्य सत्य और आत्मा के प्रकाश को साक्षात् देखती है।
            बिना विवेक की आँख के, मनुष्य आँखें होते हुए भी अंधे के समान भटकता रहता है।
            ज्ञान की आँख हमें चीजों को वैसी ही दिखाती है जैसी वे वास्तव में हैं, न कि जैसी दिखती हैं।
            यह वह 'तीसरा नेत्र' है जो माया के परदे को फाड़कर परमात्मा का दर्शन कराता है।
            जब यह आँख खुलती है, तो संसार का सारा डर और अज्ञान एक ही पल में मिट जाता है।
            शास्त्रों का अध्ययन और गुरु की कृपा ही इस दिव्य चक्षु (आँख) को जाग्रत करती है।
            सच्ची दृष्टि वही है जो भेद-भाव को छोड़कर सबमें उस एक ही अखंड सत्ता को देखे।
            जो इस ज्ञान-चक्षु को पा लेता है, उसे फिर दुनिया में कुछ और देखना बाकी नहीं रहता।
        """.trimIndent(),
        english = """
            Question: What is the Eye (Chakshu)? Answer: Wisdom that dispels the dark of ignorance.
            Our physical eyes can only perceive the perishable external objects and various colors.
            But the eye of wisdom is that which directly beholds the invisible Truth and Soul-light.
            Without the eye of discrimination, a human wanders like a blind man despite having sight.
            The eye of knowledge shows things as they truly are, not merely as they appear to be.
            This is the 'Third Eye' that tears through the veil of Maya to reveal the Supreme Lord.
            When this eye opens, all worldly fear and ignorance vanish in a single moment.
            Studying scriptures and the grace of a Guru awaken this divine Eye (Chakshu) within.
            True vision is that which ignores differences and sees the one unbroken Reality in all.
            He who attains this eye of wisdom has nothing else left to see in the entire universe.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 24,
        sanskrit = "किं दानम् ? अनपेक्षं ब्रह्मापर्णं दानम् ।",
        hindi = """
            प्रश्न: दान क्या है? उत्तर: बिना किसी बदले की उम्मीद के ईश्वर को अर्पित करना।
            दान केवल पैसे देना नहीं, बल्कि अपने अहंकार और 'मैं-पन' को त्यागना असली दान है।
            जब हम किसी की मदद करते हैं और बदले में नाम या पुण्य नहीं चाहते, तो वह दान है।
            अपना समय, ज्ञान और प्रेम दूसरों के भले के लिए लगाना भी एक महान दान माना गया है।
            सच्चा दान वही है जहाँ देने वाले का 'हाथ' तो बढ़े, पर उसका 'अहंकार' बिल्कुल न बढ़े।
            ब्रह्मापणं का अर्थ है—यह मानना कि देने वाला, लेने वाला और वस्तु सब भगवान ही हैं।
            दान हमारे हृदय को विशाल बनाता है और संचय (इकट्ठा करने) की गंदी आदत को तोड़ता है।
            जो बिना किसी स्वार्थ के दान करता है, उसका अंतःकरण दर्पण की तरह साफ हो जाता है।
            शास्त्रों में दान को कलयुग का सबसे बड़ा और प्रभावशाली धर्म बताया गया है।
            दान का अर्थ है—दुनिया से जो लिया है, उसे कृतज्ञता के साथ दुनिया को वापस लौटा देना।
        """.trimIndent(),
        english = """
            Question: What is Charity (Dana)? Answer: Offering to God without any expectation.
            Charity is not just giving money; renouncing your ego and 'I-ness' is the real Dana.
            When we help someone and do not desire fame or merit in return, that is true charity.
            Giving your time, knowledge, and love for the welfare of others is also a great Dana.
            Real charity is where the 'hand' extends to give, but the 'ego' does not increase at all.
            'Brahmapanam' means realizing the giver, the receiver, and the object are all God.
            Charity expands our heart and shatters the toxic habit of hoarding material things.
            The person who gives without selfishness finds his inner heart purified like a mirror.
            Scriptures declare charity to be the greatest and most powerful Dharma of Kali Yuga.
            Charity means returning to the world with gratitude what you have taken from the world.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 25,
        sanskrit = "किं व्रतम् ? अखण्डसच्चिदानन्दात्मकानुसन्धानं व्रतम् ।",
        hindi = """
            प्रश्न: व्रत क्या है? उत्तर: अखंड सच्चिदानंद के विचार में निरंतर बने रहना ही व्रत है।
            व्रत केवल भूखा रहना नहीं है, बल्कि मन को संकल्प के साथ सत्य पर टिकाए रखना है।
            अपने आचरण को पवित्र रखना और इंद्रियों पर संयम रखना ही असली और श्रेष्ठ व्रत है।
            सच्चा व्रत वह है जो हमें अपनी प्रतिज्ञा (संकल्प) पर दृढ़ रहना सिखाता है।
            जब हम बुरा न बोलने, बुरा न सोचने का नियम लेते हैं, तो वह एक आध्यात्मिक व्रत है।
            व्रत का अर्थ है—अपने मन को बिखराव से बचाकर एक ऊंचे लक्ष्य की ओर केंद्रित करना।
            यह हमारी इच्छाशक्ति (Willpower) को मजबूत करता है और आत्म-अनुशासन सिखाता है।
            अखंड सच्चिदानंद का चिंतन करना ही वह महान व्रत है जो अज्ञान को जड़ से काट देता है।
            जो साधक अपने व्रत पर अडिग रहता है, उसी को परमात्मा की असीम कृपा प्राप्त होती है।
            व्रत हमारे जीवन को व्यवस्थित करता है और हमें पशु-प्रवृत्ति से ऊपर उठाकर देवत्व देता है।
        """.trimIndent(),
        english = """
            Question: What is Vrata? Answer: Constant contemplation on the Satchidananda.
            A vow is not just fasting; it is keeping the mind anchored on Truth with resolve.
            Maintaining pure conduct and self-control over the senses is the real and highest Vow.
            A true Vow is that which teaches us to remain firm and steady on our promises.
            When we take a rule to not speak ill or think ill, it is a powerful spiritual Vow.
            Vrata means protecting the mind from scattering and focusing it on a higher goal.
            It strengthens our Willpower and teaches the profound art of self-discipline.
            Contemplating the eternal Bliss is the great Vow that uproots ignorance entirely.
            The seeker who remains unshakeable in his Vow receives the infinite grace of God.
            Vows organize our lives and elevate us from animal instincts toward divinity.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 26,
        sanskrit = "कः संन्यासः ? सर्वकर्मफलापर्णं संन्यासः ।",
        hindi = """
            प्रश्न: संन्यास क्या है? उत्तर: सभी कर्मों के फलों को ईश्वर को अर्पण कर देना।
            संन्यास का अर्थ घर छोड़ना या कपड़े बदलना नहीं, बल्कि 'आसक्ति' (Attachment) छोड़ना है।
            जो व्यक्ति कर्म तो करता है पर उसके फल की इच्छा नहीं रखता, वही असली संन्यासी है।
            संन्यास मन की वह अवस्था है जहाँ मनुष्य "मेरा-तेरा" के छोटेपन से ऊपर उठ जाता है।
            सच्चा संन्यासी वह है जिसने अपने भीतर की सभी वासनाओं और कामनाओं को जला दिया है।
            वह दुनिया में वैसे ही रहता है जैसे कीचड़ में कमल—पवित्र, निर्लिप्त और हमेशा शांत।
            संन्यास का अर्थ है—अहंकार का त्याग करना और पूरी तरह से परमात्मा पर आश्रित होना।
            यह जीवन की वह परिपक्वता है जहाँ इंसान जान जाता है कि शांति बाहर नहीं, भीतर है।
            संन्यास हमें यह सिखाता है कि हम इस दुनिया के मालिक नहीं, बल्कि केवल एक ट्रस्टी हैं।
            जिसका मन पूरी तरह से शांत और विरक्त है, वह घर में रहकर भी एक पूर्ण संन्यासी ही है।
        """.trimIndent(),
        english = """
            Question: What is Sannyasa? Answer: Offering the fruits of all actions to God.
            Renunciation is not leaving home or changing clothes; it is dropping all attachment.
            The person who performs actions but has no desire for the results is the real Sannyasi.
            Sannyasa is a mental state where a human rises above the pettiness of "mine and thine."
            A true Sannyasi is one who has burnt all his internal lusts and worldly cravings.
            He lives in the world like a lotus in mud—pure, untainted, and perpetually peaceful.
            Renunciation means the sacrifice of ego and depending entirely upon the Supreme Lord.
            It is that maturity of life where one realizes that peace is inside, not in the world.
            Sannyasa teaches us that we are not the owners of this world, but merely its trustees.
            He whose mind is perfectly calm and detached is a total Sannyasi even while at home.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 27,
        sanskrit = "किं तीर्थम् ? सर्वभूतेषु ब्रह्मदर्शनं तीर्थम् ।",
        hindi = """
            प्रश्न: तीर्थ क्या है? उत्तर: सभी प्राणियों में ब्रह्म का दर्शन करना ही असली तीर्थ है।
            तीर्थ केवल नदियों या पहाड़ों की यात्रा नहीं, बल्कि चेतना की एक पवित्र यात्रा है।
            जब हमारा मन शुद्ध होकर हर जगह ईश्वर को देखने लगता है, तब हम तीर्थ में होते हैं।
            बाहरी तीर्थ तो केवल शरीर को धोते हैं, पर ब्रह्मदर्शन मन की सारी गंदगी साफ कर देता है।
            जहाँ सत्य का ज्ञान है और जहाँ संतों का वास है, वही स्थान साक्षात् परम तीर्थ है।
            अपनी ही आत्मा की गहराइयों में उतरना ही दुनिया का सबसे महान और पावन तीर्थ है।
            तीर्थ का अर्थ है—वह घाट जो हमें संसार रूपी नदी से पार उतार कर मोक्ष तक ले जाए।
            सच्ची तीर्थयात्रा वह है जो हमारे भीतर प्रेम, दया और विनम्रता के भाव जाग्रत कर दे।
            यदि हृदय में दया और ज्ञान नहीं है, तो काशी और कैलाश जाना भी केवल पर्यटन मात्र है।
            सबमें एक ही परमात्मा को देखना ही वह महा-तीर्थ है जो मनुष्य को जन्म-मरण से तारता है।
        """.trimIndent(),
        english = """
            Question: What is Tirtha? Answer: Seeing Brahman in all living beings is the Tirtha.
            A pilgrimage is not just a trip to rivers or mountains; it is a sacred journey of awareness.
            When our mind is purified and starts seeing God everywhere, we are in a true Tirtha.
            External pilgrimages only wash the body, but seeing Brahman cleanses all mental dirt.
            Where there is knowledge of Truth and the presence of saints, that place is a Tirtha.
            Diving into the very depths of your own Soul is the greatest and holiest Tirtha.
            Tirtha means 'the ford' or 'the pier' that carries us across the river of life to Moksha.
            A real pilgrimage is one that awakens love, compassion, and humility within us.
            If there is no mercy or wisdom in the heart, visiting Kashi or Kailash is just tourism.
            Perceiving the same God in everyone is that ultimate Tirtha that saves one from rebirth.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 28,
        sanskrit = "किं मौनम् ? वाणीप्रपञ्चातीतमौनम् ।",
        hindi = """
            प्रश्न: मौन क्या है? उत्तर: वाणी के प्रपंच (शब्दों के शोर) से पूरी तरह परे होना।
            मौन केवल चुप रहना नहीं है, बल्कि मन के भीतर के शोर (विचारों) का शांत हो जाना है।
            जब शब्द खत्म होते हैं, तभी ईश्वर की भाषा यानी 'मौन' की भाषा सुनाई देती है।
            सच्चा मौन वह है जहाँ "मैं" और "मेरा" की आवाज़ें पूरी तरह से थम जाती हैं।
            यह वह ऊर्जा है जो फालतू बोलने से होने वाले नुकसान को बचाकर अंतरात्मा को देती है।
            मौन में ही सत्य का साक्षात्कार होता है, क्योंकि ब्रह्म शब्दों की सीमा से बहुत परे है।
            बोलना अविद्या है और मौन रहना विद्या की ओर बढ़ने का एक अत्यंत सशक्त माध्यम है।
            गहरा मौन हमें अपनी ही आत्मा के संगीत को सुनने और महसूस करने की शक्ति देता है।
            यह वह शांति है जो बाहरी तूफानों के बीच भी साधक को विचलित नहीं होने देती।
            मौन का अर्थ है—अपने मन को उस शून्य में टिका देना जहाँ कोई संकल्प-विकल्प न हो।
        """.trimIndent(),
        english = """
            Question: What is Mauna? Answer: Being beyond the phenomenal world of speech.
            Silence is not just not speaking; it is the quieting of the internal noise of thoughts.
            When words end, only then the language of God—the language of Silence—is heard.
            True Silence is that state where the voices of "I" and "Mine" are completely stilled.
            It is the energy that saves the vital force from being wasted in talk and gives it to the Soul.
            In Silence alone, Truth is realized, as Brahman is far beyond the limits of words.
            Speaking is Avidya, and remaining Silent is a powerful medium to move toward Vidya.
            Deep Silence grants us the power to hear and feel the subtle music of our own Soul.
            It is that tranquility that prevents a seeker from being shaken amidst external storms.
            Silence means anchoring your mind in that void where no resolves or doubts exist.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 29,
        sanskrit = "को मोक्षः ? अहमेव ब्रह्मेति साक्षत्कारो मोक्षः ।",
        hindi = """
            प्रश्न: मोक्ष क्या है? उत्तर: "मैं ही ब्रह्म हूँ" इस सत्य का साक्षात् अनुभव ही मोक्ष है।
            मोक्ष कोई जगह नहीं है जहाँ मरकर जाया जाता है, बल्कि यह अज्ञान की नींद से जागना है।
            जब जीव का यह भ्रम टूट जाता है कि वह एक छोटा और लाचार शरीर है, तो वह मुक्त है।
            मोक्ष का अर्थ है—सभी दुखों, भयों और जन्म-मरण के चक्कर से हमेशा के लिए आज़ादी।
            यह वह स्थिति है जहाँ केवल अखंड आनंद और पूर्णता का अहसास निरंतर बना रहता है।
            जैसे नदी समुद्र में मिलकर समुद्र हो जाती है, वैसे ही मुक्त पुरुष ब्रह्म हो जाता है।
            मोक्ष का अर्थ है—कुछ भी पाने की इच्छा का न रहना, क्योंकि सब कुछ पा लिया गया है।
            यह अद्वैत की वह पराकाष्ठा है जहाँ "दूसरा" कोई भी बिल्कुल भी शेष नहीं बचता।
            मोक्ष साक्षात् शिव-स्वरूप होना है, जो नित्य, शुद्ध, बुद्ध और हमेशा मुक्त है।
            जो जीते-जी इस सत्य को जान लेता है, उसके लिए मृत्यु केवल पुराने कपड़े बदलना है।
        """.trimIndent(),
        english = """
            Question: What is Moksha? Answer: The realization that "I am indeed Brahman."
            Liberation is not a place to go after death; it is awakening from the sleep of ignorance.
            When the delusion that the soul is a small, helpless body shatters, one is liberated.
            Moksha means permanent freedom from all sorrows, fears, and the cycle of rebirth.
            It is the state where only unbroken Bliss and a sense of total Fulfilment remains.
            Just as a river merging into the sea becomes the sea, the liberated soul becomes Brahman.
            Moksha means having no more desire to attain anything, for everything has been attained.
            It is the peak of Non-duality where no "other" remains existing whatsoever.
            To be liberated is to be Shiva Himself, who is eternal, pure, awake, and ever-free.
            For one who realizes this while alive, death is merely like changing old clothes.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 30,
        sanskrit = "को मुमुक्षुः ? संसाराद्विमुक्तिमिच्छन् मुमुक्षुः ।",
        hindi = """
            प्रश्न: मुमुक्षु कौन है? उत्तर: जो संसार के बंधनों से मुक्त होने की तीव्र इच्छा रखता है।
            मुमुक्षु वह है जिसे अब दुनिया के खिलौनों (पैसा, मान, भोग) में कोई रस नहीं रहा।
            उसकी प्यास केवल परमात्मा के लिए है, जैसे प्यासे को पानी या डूबते को हवा चाहिए।
            वह सत्य को पाने के लिए अपनी पूरी ताकत और अपना सब कुछ दांव पर लगा देता है।
            मुमुक्षु होना आध्यात्मिक यात्रा की पहली और सबसे महत्वपूर्ण अनिवार्य पात्रता है।
            बिना तड़प और बिना गहरी इच्छा के, कोई भी व्यक्ति ईश्वर के रहस्य को नहीं पा सकता।
            वह हर पल खुद से यही पूछता है कि "मैं इस अज्ञान की जेल से बाहर कैसे निकलूँ?"
            मुमुक्षु वह साहसी यात्री है जो भीड़ से अलग होकर सत्य के कठिन मार्ग पर चलता है।
            उसके लिए मोक्ष कोई विकल्प (Option) नहीं, बल्कि जीवन की एकमात्र जरूरत (Necessity) है।
            जब मुमुक्षा (इच्छा) अपनी चरम सीमा पर होती है, तो गुरु और ज्ञान स्वतः प्रकट होते हैं।
        """.trimIndent(),
        english = """
            Question: Who is a Mumukshu? Answer: One desiring liberation from the world.
            A Mumukshu is one who no longer finds any taste in worldly toys (money, fame, lust).
            His thirst is only for the Divine, as a thirsty man needs water or a drowning man air.
            He stakes his entire strength and his very life solely to attain the ultimate Truth.
            Being a Mumukshu is the first and most vital qualification for the spiritual journey.
            Without intense longing and deep desire, no person can ever attain God's mystery.
            Every single moment he asks himself: "How can I escape from this prison of ignorance?"
            A Mumukshu is that brave traveler who leaves the crowd to walk the difficult path of Truth.
            For him, liberation is not an 'option', but the only absolute necessity of human life.
            When the longing (Mumuksha) reaches its peak, the Guru and wisdom manifest automatically.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 31,
        sanskrit = "को गृहस्थः ? संसारसुखदुःखानुभवकर्ता गृहस्थः ।",
        hindi = """
            प्रश्न: गृहस्थ कौन है? उत्तर: जो संसार के सुख और दुखों का निरंतर अनुभव करता है।
            गृहस्थ वह है जो परिवार और समाज के बीच रहकर अपने कर्तव्यों का पालन करता है।
            उपनिषद की नज़रों में गृहस्थी केवल विवाह नहीं, बल्कि कर्मों के भोग की एक अवस्था है।
            वह दुनिया के द्वंद्वों (Dualities) के बीच रहकर अपना जीवन बिताता और सीखता है।
            सच्चा गृहस्थ वह है जो घर में तो रहता है, पर अपना मन हमेशा ईश्वर में रखता है।
            वह अपने परिवार को ईश्वर की अमानत मानकर बिना आसक्ति के उनकी सेवा करता है।
            यदि गृहस्थ अपने कर्मों को 'यज्ञ' बना ले, तो वह घर में रहकर भी मोक्ष पा सकता है।
            परंतु यदि वह केवल वासनाओं और ममता में फँसा है, तो वह बंधन में ही रहेगा।
            गृहस्थी एक तपोवन (Austerity ground) है जहाँ संयम और धैर्य की परीक्षा होती है।
            संसार के थपेड़ों को सहते हुए भी शांत रहना ही एक आदर्श गृहस्थ का असली लक्षण है।
        """.trimIndent(),
        english = """
            Question: Who is a Grihastha? Answer: He who experiences worldly joys and sorrows.
            A householder is one who fulfills his duties while living amidst family and society.
            In the eyes of the Upanishad, it is not just marriage, but a state of experiencing karmas.
            He spends his life learning and growing amidst the various dualities of the world.
            A true householder lives in a home but keeps his mind constantly fixed on God.
            He considers his family as God's trust and serves them without any attachment.
            If a householder turns his deeds into a 'Yajna', he can find Moksha right at home.
            But if he is only trapped in lust and possessiveness, he will remain in bondage.
            Household life is a training ground (Tapovan) for testing one's restraint and patience.
            Remaining calm while facing the blows of the world is the hallmark of an ideal Grihastha.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 32,
        sanskrit = "को वानप्रस्थः ? विषयेभ्यो विरक्तो वानप्रस्थः ।",
        hindi = """
            प्रश्न: वानप्रस्थ कौन है? उत्तर: जो सांसारिक विषयों से पूरी तरह विरक्त हो चुका हो।
            वानप्रस्थ वह है जिसने अपनी जिम्मेदारियां पूरी कर ली हैं और अब एकांत खोजता है।
            यह केवल जंगल जाने का नाम नहीं, बल्कि मन को दुनिया के शोर से खाली करना है।
            वह अपनी इंद्रियों को बाहरी आकर्षणों से हटाकर अंतर्मुखी (Inward) होने का अभ्यास करता है।
            वानप्रस्थी का मुख्य उद्देश्य केवल आत्म-चिंतन और साधना में समय बिताना होता है।
            उसकी ममता अब केवल अपने परिवार तक सीमित नहीं, बल्कि पूरे संसार के लिए होती है।
            वह संन्यास की तैयारी की एक अवस्था है जहाँ वह धीरे-धीरे 'मैं और मेरा' छोड़ता है।
            विषयों की विरक्ति ही उसे मानसिक शांति और आध्यात्मिक ऊँचाई प्रदान करती है।
            वह सादगी का जीवन जीता है और अपना सारा अनुभव समाज को मार्ग दिखाने में लगाता है।
            जिसके हृदय में अब दुनिया का कोई लालच नहीं बचा, वही वास्तव में वानप्रस्थी है।
        """.trimIndent(),
        english = """
            Question: Who is Vanaprastha? Answer: He who is detached from worldly objects.
            A forest-dweller is one who has finished his duties and now seeks absolute solitude.
            It's not just about going to the forest, but about emptying the mind of worldly noise.
            He practices withdrawing his senses from external allurements to become inward-looking.
            The primary purpose of a Vanaprasthi is to spend time only in Self-reflection and Sadhana.
            His possessiveness is no longer limited to his family, but extends to the entire world.
            It is a stage of preparation for Sannyasa where he gradually drops "I and Mine."
            Detachment from objects grants him immense mental peace and spiritual height.
            He lives a life of simplicity and utilizes his experience to guide society.
            He in whose heart no worldly greed remains is indeed a true Vanaprasthi.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 33,
        sanskrit = "को ब्रह्मचारी ? यो ब्रह्मणि चरति स ब्रह्मचारी ।",
        hindi = """
            प्रश्न: ब्रह्मचारी कौन है? उत्तर: जो निरंतर ब्रह्म के विचार में विचरण करता है।
            ब्रह्मचर्य केवल शारीरिक संयम नहीं है, बल्कि मन का ईश्वर में लीन रहना है।
            वह हर समय "मैं ब्रह्म हूँ" या "सब कुछ ब्रह्म है" इसी सत्य का चिंतन करता है।
            उसकी पूरी ऊर्जा (Vital force) आत्मज्ञान और विद्या को प्राप्त करने में लगी होती है।
            ब्रह्मचारी वह है जिसने अपनी इंद्रियों के घोड़ों को बुद्धि की लगाम से वश में किया है।
            उसका आचरण पवित्र होता है और वह व्यर्थ की बातों और भोगों से दूर रहता है।
            सच्चा ब्रह्मचारी वही है जिसकी दृष्टि केवल सत्य की खोज पर टिकी रहती है।
            यह जीवन की वह अवस्था है जो भविष्य की महान आध्यात्मिक सफलता की नींव डालती है।
            जहाँ भी ब्रह्म (परमात्मा) का ध्यान है, वहीं पर सच्चा ब्रह्मचर्य निवास करता है।
            अपने मन को बिखराव से बचाकर अखंड चेतना में रखना ही ब्रह्मचारी का असली धर्म है।
        """.trimIndent(),
        english = """
            Question: Who is a Brahmachari? Answer: He who constantly moves (dwells) in Brahman.
            Brahmacharya is not just physical restraint; it is keeping the mind merged in God.
            He constantly contemplates the truth: "I am Brahman" or "Everything is Brahman."
            His entire vital energy is dedicated solely to attaining Self-knowledge and Wisdom.
            A Brahmachari is one who has mastered the horses of his senses via the intellect's reins.
            His conduct is impeccably pure, and he stays away from useless talk and indulgences.
            A true Brahmachari is one whose vision is anchored exclusively on the search for Truth.
            This is the stage of life that lays the foundation for great future spiritual success.
            Wherever there is meditation on Brahman, true Brahmacharya resides right there.
            Protecting the mind from scattering and keeping it in unbroken awareness is his duty.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 34,
        sanskrit = "को मुमुक्षुः ? संसाराद्विमुक्तिमिच्छन् मुमुक्षुः ।",
        hindi = """
            प्रश्न: मुमुक्षु कौन है? उत्तर: जो संसार के दुखों से आज़ादी चाहता है।
            (निरलम्ब उपनिषद के अनुसार पुनः बल): मुमुक्षु वह है जिसके लिए सत्य ही सब कुछ है।
            वह जान गया है कि संसार एक मृगतृष्णा है और उसे अब असली पानी (शांति) चाहिए।
            वह जन्म-मरण की बेड़ियों को काटकर हमेशा के लिए स्वतंत्र होना चाहता है।
            उसकी तड़प ऐसी होती है जैसे आग लगे घर से बाहर निकलने की तड़प होती है।
            मुमुक्षु वह वीर है जो अपनी ही अशुद्धियों और वासनाओं के खिलाफ युद्ध करता है।
            वह ज्ञान की खोज में किसी भी बाधा को पार करने के लिए तैयार रहता है।
            उसके जीवन का एकमात्र केंद्र बिंदु 'मोक्ष' यानी आत्मा का साक्षात् करना है।
            जो इस संसार के दुखों को पहचान लेता है, वही मुमुक्षु बनने का अधिकारी है।
            यही वह पात्रता है जिसे देखकर परमात्मा स्वयं गुरु बनकर शिष्य के पास आते हैं।
        """.trimIndent(),
        english = """
            Question: Who is a Mumukshu? Answer: One desiring freedom from worldly sorrows.
            (Re-emphasized in Niralamba): A Mumukshu is one for whom Truth is absolutely everything.
            He realized that the world is a mirage and he now needs the real water (Peace).
            He intensely wants to break the shackles of rebirth and be independent forever.
            His longing is as intense as the urge to escape from a house that is on fire.
            A Mumukshu is a hero who wages an internal war against his own impurities and lusts.
            He is ready to overcome any obstacle whatsoever in his persistent search for wisdom.
            The only central focus of his entire life is 'Moksha'—the realization of the Soul.
            He who profoundly recognizes the sorrows of this world is qualified to be a Mumukshu.
            This is the very qualification seeing which God Himself comes to the seeker as a Guru.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 35,
        sanskrit = "को भक्तः ? शिवविष्ण्वोरभेदेन...",
        hindi = """
            प्रश्न: भक्त कौन है? उत्तर: जो शिव और विष्णु में कोई भेद नहीं देखता।
            भक्त वह है जो ईश्वर के सभी रूपों में एक ही परम चेतना का अनुभव करता है।
            वह न तो किसी संप्रदाय में बँधा है और न ही वह किसी से नफरत करता है।
            उसके लिए पूरा ब्रह्मांड उसके भगवान की ही एक भव्य और सुंदर अभिव्यक्ति है।
            भक्त का हृदय करुणा से भरा होता है और उसकी वाणी हमेशा सत्य और मधुर होती है।
            वह अपने कर्मों को भगवान की पूजा मानकर पूरी निष्ठा के साथ संपन्न करता है।
            सच्चा भक्त वह है जो सुख में भगवान को नहीं भूलता और दुख में घबराता नहीं।
            भक्ति का अर्थ है—स्वयं को पूरी तरह से उस परम सत्ता के चरणों में लुटा देना।
            जहाँ प्रेम है, वहाँ द्वैत खत्म हो जाता है; भक्त भगवान का ही रूप बन जाता है।
            भक्त वही है जो अपनी मर्जी छोड़कर केवल ईश्वर की इच्छा में प्रसन्न रहता है।
        """.trimIndent(),
        english = """
            Question: Who is a Devotee (Bhakta)? Answer: He who sees no difference in God's forms.
            A devotee is one who experiences the same Supreme Awareness in all forms of God.
            He is neither bound by any sect nor does he ever harbor hatred toward anyone.
            For him, the entire universe is a magnificent and beautiful expression of his Lord.
            The heart of a devotee is full of mercy and his speech is always truthful and sweet.
            He performs his actions as an offering to God with absolute and total dedication.
            A true devotee is one who forgets not God in joy and panics not in the midst of grief.
            Devotion means completely surrendering oneself at the feet of that Supreme Reality.
            Where there is love, duality vanishes; the devotee becomes a form of God Himself.
            A Bhakta is he who drops his own will and remains happy only in the Will of God.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 36,
        sanskrit = "किं ज्ञानम् ? सर्वभूतेषु ब्रह्मदर्शनं ज्ञानम् ।",
        hindi = """
            प्रश्न: ज्ञान क्या है? उत्तर: सभी प्राणियों में ब्रह्म का दर्शन करना ही ज्ञान है।
            (निरलम्ब उपनिषद के अनुसार पुनः बल): ज्ञान का अर्थ अद्वैत का सीधा अनुभव है।
            जब साधक देखता है कि "सब कुछ ब्रह्म ही है", तो वह परम ज्ञानी हो जाता है।
            यह ज्ञान हमारे भीतर के सारे भेदभाव और घृणा को जड़ से उखाड़ फेंकता है।
            ज्ञान वह दृष्टि है जो बाहरी चमड़ी के पीछे छिपे हुए असली मालिक को देखती है।
            जहाँ ज्ञान है, वहाँ भय और दुख का कोई अस्तित्व बिल्कुल भी नहीं रह सकता।
            यह वह समझ है जो हमें बताती है कि हम कभी अकेले या लाचार नहीं रहे।
            ज्ञान होने पर मनुष्य को अपनी शक्तियों और अपनी महिमा का असली बोध होता है।
            सच्चा ज्ञान हमें विनम्र बनाता है क्योंकि हम सबमें एक ही प्रभु को देखते हैं।
            यही वह महा-विद्या है जो जीव को हमेशा के लिए अमृतत्व (अमरता) प्रदान करती है।
        """.trimIndent(),
        english = """
            Question: What is Jnana? Answer: Beholding Brahman in every living creature.
            (Re-emphasized in Niralamba): Knowledge means the direct experience of Non-duality.
            When the seeker sees that "Everything is indeed Brahman," he becomes a true Knower.
            This wisdom uproots all our internal prejudices and hatred from the very core.
            Knowledge is the vision that sees the real Master hidden behind the external skin.
            Where there is Jnana, fear and sorrow can absolutely have no existence whatsoever.
            It is the understanding that tells us we were never truly alone or truly helpless.
            Upon enlightenment, a human gains the real sense of his powers and his inner glory.
            True knowledge makes us humble because we see the same one Lord in everyone.
            This is the Supreme Science that grants the individual soul eternal Immortality.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 37,
        sanskrit = "को जीवन्मुक्तः? यः सुप्तवत् जाग्रति। को मोक्षः? यः आत्मज्ञानं लभते। को जीवन्मुक्तः? अहम ब्रह्मेति साक्षात करोति।",
        hindi = """
            प्रश्न: जीवन्मुक्त कौन है? उत्तर: जो इसी शरीर में रहते हुए मोक्ष का अनुभव करे।
            जीवन्मुक्त वह है जिसने जीते-जी अपने 'अहंकार' को पूरी तरह से विदा कर दिया है।
            संसार की कोई भी घटना (अपमान, बीमारी, मृत्यु) उसे विचलित नहीं कर सकती।
            वह दुनिया में वैसे ही विचरता है जैसे कोई मुक्त पंछी खुले आकाश में उड़ता है।
            उसकी बुद्धि हमेशा शांत रहती है और वह हर पल ब्रह्मानंद में डूबा रहता है।
            जीवन्मुक्त के लिए न कोई शत्रु है, न कोई मित्र; वह सबमें स्वयं को ही देखता है।
            वह प्रारब्ध के अनुसार कर्म तो करता है, पर कर्मों के फल से पूरी तरह अलिप्त है।
            उसके दर्शन मात्र से दूसरों का चित्त शांत होता है और भक्ति जागृत होती है।
            वह शरीर को केवल एक पुराने कपड़े की तरह देखता है जिसका गिरना तय है।
            जीवन्मुक्ति ही मनुष्य जीवन की वह सर्वोच्च सफलता है जिसे देवता भी चाहते हैं।
        """.trimIndent(),
        english = """
            Question: Who is Jivanmukta? Answer: One experiencing liberation while alive.
            A Jivanmukta is one who has completely bid farewell to his 'Ego' while still alive.
            No event of the world (insult, disease, death) can ever agitate or shake him.
            He wanders in the world as a free bird flies gracefully in the vast, open sky.
            His intellect always remains tranquil, and he is perpetually immersed in Bliss.
            For a Jivanmukta, there is neither enemy nor friend; he sees only Himself in all.
            He performs actions as per destiny but remains entirely detached from the results.
            His mere sight calms the minds of others and awakens deep devotion in their hearts.
            He views his physical body merely as an old garment whose falling is inevitable.
            Jivanmukti is the ultimate success of human life that even the celestial gods desire.
        """.trimIndent()
    ),
    NiralambaShloka(
        id = 38,
        sanskrit = "नित्यमुक्तः शुद्धः बुद्धः आत्मा... ॐ शान्तिः शान्तिः शान्तिः ॥",
        hindi = """
            (उपनिषद का समापन): आत्मा वास्तव में नित्य मुक्त, शुद्ध और जाग्रत स्वरूप है।
            वह कभी बँधी ही नहीं थी, इसलिए उसे मुक्त करने की बात केवल एक भाषा का खेल है।
            अज्ञान का परदा हटते ही वह अपने असली और शाश्वत रूप में चमकने लगती है।
            यह निरवलम्ब उपनिषद का परम ज्ञान हमें सभी आधारों (सहारे) से मुक्त करता है।
            परमात्मा ही हमारा असली घर है और वही हमारी शांति का एकमात्र अनंत सागर है।
            जो इस 38 प्रश्नों के रहस्य को जान लेता है, वह स्वयं साक्षात् ब्रह्म हो जाता है।
            सभी संशयों का नाश और पूर्ण अभय प्राप्त करना ही इस विद्या का अंतिम फल है।
            अपने भीतर छिपे उस 'नारालम्ब' (निराधार/स्वतंत्र) सत्य को पहचानना ही योग है।
            ॐ शांतिः शांतिः शांतिः—हमारे सभी ताप मिटें और हमें परम सत्य की प्राप्ति हो।
            यहाँ यह महान और दुर्लभ 'निरवलम्ब उपनिषद' पूर्ण रूप से और हर्षपूर्वक संपन्न होता है।
        """.trimIndent(),
        english = """
            (Conclusion of the Upanishad): The Soul is eternally free, pure, and awake.
            It was never bound, so talking about liberating it is merely a play of language.
            As the veil of ignorance drops, it shines in its original and eternal form.
            This knowledge of Niralamba Upanishad frees us from all external supports (bases).
            God is our true home and the only infinite ocean of our profound peace.
            He who realizes the secret of these 38 questions becomes Brahman Himself.
            The destruction of all doubts and attaining total fearlessness is the final fruit.
            Recognizing the 'Niralamba' (Supportless/Independent) Truth within is Yoga.
            OM Peace, Peace, Peace—may all our afflictions end and we attain Supreme Truth.
            Here, this magnificent and rare 'Niralamba Upanishad' is fully and joyfully completed.
        """.trimIndent()
    )
)