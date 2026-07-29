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
data class KathaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KathaUpanishadScreen() {
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
                // Supports all 119 Shlokas of Katha Upanishad
                if (shlokaNumber != null && shlokaNumber in 1..119) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-119)") },
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
            itemsIndexed(kathaShlokasList) { _, shloka ->
                KathaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun KathaShlokaCard(shloka: KathaShloka) {
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

// Explicitly defining the list type to prevent compiler errors
val kathaShlokasList: List<KathaShloka> = listOf(
    KathaShloka(
        id = 1,
        sanskrit = "ॐ उशन् ह वै वाजश्रवसः सर्ववेदसं ददौ । तस्य ह नचिकेता नाम पुत्र आस ॥ १ ॥",
        hindi = """
            प्राचीन काल में वाजश्रवा के पुत्र (महर्षि उद्दालक) ने स्वर्ग के फल की इच्छा से विश्वजित नामक यज्ञ किया।
            उस महान यज्ञ में नियम यह था कि अपनी सारी धन-संपत्ति (सर्ववेदसं) का दान करना होता है।
            उस महर्षि के पास एक अत्यंत मेधावी और सत्यनिष्ठ पुत्र था, जिसका नाम 'नचिकेता' था।
            यह कठोपनिषद की शुरुआत है, जो अध्यात्म के इतिहास की सबसे महान और रहस्यमयी कथा है।
            कथा एक यज्ञ से शुरू होती है, जहाँ पिता फल की इच्छा (संसार) के लिए सब कुछ दान कर रहा है।
            यह दिखाता है कि लोग धर्म का पालन भी केवल अपनी भौतिक इच्छाओं को पूरा करने के लिए करते हैं।
            नचिकेता उस युवा पीढ़ी का प्रतीक है जो धर्म के दिखावे को नहीं, बल्कि उसके पीछे के सत्य को खोजती है।
            'सर्ववेदसं' का अर्थ है अपना सब कुछ दे देना, पर जब मन में मोह हो, तो ऐसा दान केवल एक दिखावा है।
            यहाँ से अज्ञान (पिता) और ज्ञान की जिज्ञासा (पुत्र) के बीच का वैचारिक टकराव शुरू होता है।
            यह श्लोक उस महान यात्रा का बीजारोपण करता है जो मनुष्य को सीधे मृत्यु के देवता (यमराज) तक ले जाएगी।
        """.trimIndent(),
        english = """
            In ancient times, the son of Vajasrava (Sage Uddalaka), desiring heavenly rewards, performed the Vishvajit sacrifice.
            The strict rule of that great sacrifice was to give away all of one's wealth and possessions (Sarvavedasam) in charity.
            That sage had an extremely intelligent, sincere, and truth-seeking son whose name was 'Nachiketa'.
            This is the very beginning of the Katha Upanishad, arguably the greatest mystical story in spiritual history.
            The story begins with a ritual where the father gives charity merely out of desire for worldly/heavenly rewards.
            This demonstrates that people often practice religion solely to fulfill their own selfish, material desires.
            Nachiketa represents the youthful generation that looks beyond religious hypocrisy to find the ultimate truth.
            'Sarvavedasam' means giving away everything, but if attachment remains, such charity is a mere hollow show.
            From here begins the ideological clash between ignorance (the father) and the thirst for true wisdom (the son).
            This verse plants the seed for the epic journey that will take a human directly to the Lord of Death (Yama).
        """.trimIndent()
    ),
    KathaShloka(
        id = 2,
        sanskrit = "तँ ह कुमारं सन्तं दक्षिणासु नीयमानासु श्रद्धाऽऽविवेश सोऽमन्यत ॥ २ ॥",
        hindi = """
            यज्ञ की समाप्ति पर जब ऋषियों और ब्राह्मणों को दान की गाएं (दक्षिणा) ले जाई जा रही थीं।
            तब उन ले जाई जाती हुई गायों को देखकर उस कुमार (बालक नचिकेता) के हृदय में साक्षात् 'श्रद्धा' का प्रवेश हो गया।
            उस श्रद्धा से प्रेरित होकर वह विचारशील बालक अपने मन में अत्यंत गहराई से सोचने लगा।
            यद्यपि नचिकेता की उम्र बहुत कम थी, परंतु उसका अंतःकरण पूरी तरह से शुद्ध और परिपक्व था।
            'श्रद्धा' केवल अंधविश्वास नहीं है; यह सत्य को जानने की वह अदम्य आग है जो हर दिखावे को भस्म कर देती है।
            जब पिता धर्म के नाम पर बेईमानी कर रहा था, तब पुत्र के भीतर धर्म का असली अर्थ जाग रहा था।
            यह श्लोक बताता है कि आध्यात्मिक जागृति उम्र की मोहताज नहीं होती, वह किसी भी समय घट सकती है।
            युवा नचिकेता ने आँखें बंद करके गलत को स्वीकार नहीं किया, उसने उस पर गहराई से विचार (अमन्यत) किया।
            श्रद्धा ही वह पहली सीढ़ी है जो इंसान को संसार के शोर से निकालकर ब्रह्मज्ञान की ओर ले जाती है।
            सच्चा साधक वह है जो दूसरों की गलतियों से भी सीखता है और सत्य के प्रति अपनी निष्ठा को मजबूत करता है।
        """.trimIndent(),
        english = """
            At the conclusion of the sacrifice, as the cows for charity (Dakshina) were being led away to the priests.
            Upon seeing those cows being given away, absolute 'Shraddha' (deep spiritual faith) entered the heart of the young boy Nachiketa.
            Inspired entirely by that profound faith, the thoughtful boy began to contemplate very deeply within his mind.
            Even though Nachiketa was very young in age, his inner conscience was exceptionally pure and highly mature.
            'Shraddha' is not mere blind belief; it is that indomitable fire for truth which burns down all hypocrisy.
            While the father was acting dishonestly in the name of religion, the true essence of Dharma was awakening in the son.
            This verse proves that spiritual awakening is completely independent of age and can happen at any moment.
            Young Nachiketa did not blindly accept the wrongdoings; he pondered over them deeply (Amanyata).
            Faith is the very first step that pulls a person out of worldly noise and directs him toward supreme wisdom.
            A true seeker is one who learns even from the mistakes of others and strengthens his dedication to the Truth.
        """.trimIndent()
    ),
    KathaShloka(
        id = 3,
        sanskrit = "पीतोदका जग्धतृणा दुग्धदोहा निरिन्द्रियाः । अनन्दा नाम ते लोकास्तान् स गच्छति ता ददत् ॥ ३ ॥",
        hindi = """
            (नचिकेता ने सोचा): पिताजी जो गाएं दान में दे रहे हैं, वे ऐसी हैं जो अपना अंतिम जल पी चुकी हैं (पीतोदका)।
            वे अपना अंतिम घास खा चुकी हैं (जग्धतृणा), और वे गाएं अपना सारा दूध भी पहले ही दे चुकी हैं (दुग्धदोहा)।
            उनकी प्रजनन क्षमता खत्म हो चुकी है और वे पूरी तरह से निर्बल और बूढ़ी (निरिन्द्रिया) हो चुकी हैं।
            इस प्रकार की बेकार गायों का दान करने वाला व्यक्ति मृत्यु के बाद 'अनंद' (आनंद से रहित/दुखदायी) लोकों को प्राप्त होता है।
            यहाँ नचिकेता के मन का वह सत्यवादी विश्लेषण है जो धर्म के नाम पर किए जा रहे पाखंड को उजागर करता है।
            वाजश्रवा ने 'सब कुछ' दान करने की कसम खाई थी, पर वह चालाकी से केवल अनुपयोगी और बीमार गाएं दे रहा था।
            ईश्वर या गुरु को हमेशा अपनी सबसे प्रिय और उत्तम वस्तु का दान करना चाहिए, कचरे का नहीं।
            खराब नीयत से किया गया दान स्वर्ग नहीं, बल्कि नर्क (अनंद लोक) की ओर ले जाता है।
            नचिकेता को अपने पिता के इस बुरे कर्म का अहसास होता है और वह एक सच्चे पुत्र की तरह पिता को नर्क से बचाना चाहता है।
            सच्चा अध्यात्म हमें यह देखने की दृष्टि देता है कि कर्म के पीछे की 'नीयत' कर्म से भी ज्यादा महत्वपूर्ण होती है।
        """.trimIndent(),
        english = """
            (Nachiketa thought): The cows my father is giving in charity have already drunk their final water (Pitodaka).
            They have eaten their final grass (Jagdhatrina), and they have already given all their milk completely (Dughdadoha).
            Their reproductive capacity has ended, and their senses and organs have become entirely weak and barren (Nirindriya).
            The person who donates such useless and dying cows certainly goes to the 'Ananda' (joyless/sorrowful) worlds after death.
            Here is Nachiketa's truthful mental analysis exposing the utter hypocrisy being committed in the name of religion.
            Vajasrava vowed to donate 'everything', but was cunningly giving away only the most useless and sick cows.
            One must always offer the best and most beloved things to God or Guru, never the discarded waste.
            Charity performed with bad intentions does not lead to heaven, but straight to hellish realms (Ananda Loka).
            Nachiketa realizes his father's grave sin and, like a truly devoted son, deeply wishes to save him from hell.
            True spirituality grants us the vision to see that the 'intention' behind an action is far more important than the action itself.
        """.trimIndent()
    ),
    KathaShloka(
        id = 4,
        sanskrit = "स होवाच पितरं तत कस्मै मां दास्यसीति । द्वितीयं तृतीयं तँ होवाच मृत्यवे त्वा ददामीति ॥ ४ ॥",
        hindi = """
            यह सोचकर नचिकेता अपने पिता के पास गया और बोला: "हे पिताजी! आप मुझे किसको दान में देंगे?"
            पिता ने अनसुना कर दिया, तो नचिकेता ने दूसरी बार और फिर तीसरी बार भी यही समान प्रश्न पूछा।
            बार-बार टोकने से क्रोधित होकर पिता वाजश्रवा ने झुंझलाते हुए कहा: "मैं तुझे मृत्यु (यमराज) को दान में देता हूँ!"
            चूंकि यज्ञ का नियम 'अपना सब कुछ' दान करना था, तो नचिकेता भी पिता की ही संपत्ति था।
            नचिकेता का प्रश्न पिता के झूठे दान पर एक बहुत ही गहरा और तीखा व्यंग्य (Satire) था।
            वह पिता को याद दिलाना चाहता था कि अगर सब कुछ देना है, तो मुझे भी दान करो, यह मोह क्यों?
            पिता ने गुस्से में आकर उसे मौत को सौंप दिया; क्रोध इंसान की बुद्धि को पूरी तरह अंधा कर देता है।
            परंतु नचिकेता कोई साधारण बालक नहीं था, वह पिता के इन क्रोध भरे शब्दों को भी ईश्वर का आदेश मान लेता है।
            यह श्लोक दिखाता है कि सत्य की राह पर चलने वालों को अक्सर अपनों का ही विरोध और क्रोध सहना पड़ता है।
            यहीं से नचिकेता की उस महान आध्यात्मिक यात्रा की शुरुआत होती है जो उसे साक्षात् यमराज के द्वार तक ले जाएगी।
        """.trimIndent(),
        english = """
            Thinking this, Nachiketa went to his father and asked: "O Father! To whom will you give me in charity?"
            When his father ignored him, Nachiketa repeated the exact same question a second and then a third time.
            Infuriated by the repeated interruptions, his father Vajasrava angrily blurted out: "I give you to Death (Yama)!"
            Since the strict rule of the sacrifice was to give 'everything', Nachiketa was also legally his father's property.
            Nachiketa's question was a profound and piercing satire on his father's extremely hypocritical charity.
            He wanted to remind his father that if everything must be given, then donate me too; why this attachment?
            In a fit of sheer anger, the father handed him over to death; anger completely blinds human intelligence.
            But Nachiketa was no ordinary child; he accepted even these angry words of his father as a divine command.
            This verse shows that those who walk the path of Truth often have to face the anger and opposition of their own loved ones.
            From this exact moment begins Nachiketa's epic spiritual journey that will take him directly to the gates of the Lord of Death.
        """.trimIndent()
    ),
    KathaShloka(
        id = 5,
        sanskrit = "बहूनामेमि प्रथमो बहूनामेमि मध्यमः । किं स्विद्यमस्य कर्तव्यं यन्मयाद्य करिष्यति ॥ ५ ॥",
        hindi = """
            (यमलोक जाने से पहले नचिकेता सोचता है): शिष्यों और पुत्रों में मैं बहुतों से प्रथम (सबसे श्रेष्ठ) हूँ।
            और बहुतों की तुलना में मैं मध्यम (बीच की श्रेणी का) हूँ, पर मैं कभी सबसे नीच या बुरा नहीं रहा।
            फिर यमराज का ऐसा कौन सा अटका हुआ काम (कर्तव्य) है जिसे पूरा करने के लिए पिताजी मुझे आज यम के पास भेज रहे हैं?
            नचिकेता को यह पता है कि उसके पिता ने क्रोध में आकर उसे मृत्यु को दे दिया है, पर वह शिकायत नहीं करता।
            वह आत्म-विश्लेषण (Self-analysis) करता है कि क्या मेरे आचरण में कोई ऐसी कमी थी जिससे पिता क्रोधित हुए?
            वह जानता है कि वह एक आज्ञाकारी पुत्र है, फिर भी वह इस श्राप को एक उद्देश्य के रूप में देखता है।
            यह एक सच्चे साधक का लक्षण है—वह विपरीत परिस्थितियों में भी घबराता नहीं, बल्कि उसका अर्थ (Meaning) खोजता है।
            नचिकेता को यमराज से डर नहीं लगता; वह सोचता है कि मृत्यु के देवता को भी शायद मेरी कोई जरूरत आ पड़ी है।
            वह पिता के वचनों को झूठा नहीं होने देना चाहता, इसलिए वह स्वेच्छा से यमराज के पास जाने का संकल्प लेता है।
            यह श्लोक मृत्यु के प्रति उस निर्भयता (Fearlessness) को दर्शाता है जो केवल पूर्ण सत्यनिष्ठा से ही आ सकती है।
        """.trimIndent(),
        english = """
            (Nachiketa ponders before leaving): Among many disciples and sons, I am the first (the best and most obedient).
            And among many others, I am middle-class (average), but I have never been the worst or disobedient.
            So what possible pending task (purpose) does Lord Yama have that my father seeks to accomplish by sending me today?
            Nachiketa knows perfectly well that his father gave him to Death in a fit of rage, yet he makes no complaints.
            He performs deep self-analysis to see if there was any flaw in his behavior that provoked his father's intense anger.
            He knows he is a completely obedient son, yet he views this terrible curse as a divine purpose.
            This is the hallmark of a true seeker—he does not panic in adverse situations; instead, he searches for its deep meaning.
            Nachiketa is not at all afraid of Yama; he innocently wonders if the Lord of Death actually needs his help.
            He does not want his father's spoken words to become false, so he resolves to go to Yama completely voluntarily.
            This verse illustrates an absolute fearlessness towards death that can only arise from total dedication to Truth.
        """.trimIndent()
    ),
    KathaShloka(
        id = 6,
        sanskrit = "अनुपश्य यथा पूर्वे प्रतिपश्य तथापरे । सस्यमिव मर्त्यः पच्यते सस्यमिवाजायते पुनः ॥ ६ ॥",
        hindi = """
            (नचिकेता पिता से कहता है): पिताजी! आप याद कीजिए कि हमारे पूर्वजों ने कैसा श्रेष्ठ और सत्य आचरण किया था।
            और यह भी देखिए कि वर्तमान में जो साधु पुरुष हैं, वे सत्य के मार्ग पर कैसे चलते हैं।
            यह मरणशील मनुष्य (मर्त्य) खेती के अन्न (सस्य) के समान ही पकता है (बूढ़ा होकर मरता है)।
            और फिर वह उसी अन्न के समान दोबारा नया जन्म ले लेता है। (इसलिए आप सत्य से मत डिगिए)।
            जब पिता को अपनी गलती का अहसास हुआ और वह दुखी होने लगा, तब नचिकेता ने उन्हें यह ज्ञान दिया।
            इंसान का शरीर खेती की फसल की तरह है—जो बोया जाता है, वह उगता है, कटता है और फिर से बोया जाता है।
            इस थोड़े से जीवन और नश्वर शरीर को बचाने के लिए कभी भी सत्य का और अपने दिए गए वचनों का त्याग नहीं करना चाहिए।
            पूर्वजों ने हमेशा वचन निभाने के लिए प्राण त्यागे हैं, इसलिए मेरे मोह में आप अपना धर्म मत भूलिए।
            यह श्लोक जन्म और मृत्यु के चक्र को प्रकृति के सबसे सामान्य और सरल नियम (खेती) के रूप में समझाता है।
            मृत्यु कोई भयानक राक्षस नहीं है, यह तो फसल के पकने और नई फसल के उगने जैसी एक स्वाभाविक प्रक्रिया है।
        """.trimIndent(),
        english = """
            (Nachiketa tells his father): O Father! Look back and remember how our great ancestors behaved with absolute truth.
            And also observe how the noble and righteous men of the present time constantly walk the path of truth.
            This mortal human (Martya) ripens (ages and dies) exactly like the corn (crops) in a field.
            And exactly like the corn, he is born again and springs up anew. (Therefore, do not deviate from your spoken truth).
            When the father realized his grave mistake and began to grieve, young Nachiketa imparted this wisdom to him.
            The human body is exactly like an agricultural crop—it is sown, it grows, it is harvested, and then sown all over again.
            To simply save this fleeting life and perishable body, one must never ever sacrifice the truth or their spoken vows.
            Our ancestors always laid down their lives to keep their word, so do not forget your Dharma out of attachment to me.
            This verse explains the complex cycle of birth and death using the most natural, simple law of nature (agriculture).
            Death is not some terrifying monster; it is merely a natural process, just like the ripening and replanting of crops.
        """.trimIndent()
    ),
    KathaShloka(
        id = 7,
        sanskrit = "वैश्वानरः प्रविशत्यतिथिर्ब्राह्मणो गृहान् । तस्यैताँ शान्तिं कुर्वन्ति हर वैवस्वतोदकम् ॥ ७ ॥",
        hindi = """
            (नचिकेता यमलोक पहुँचता है पर यमराज वहाँ नहीं हैं। तीन दिन बाद लौटने पर यमराज की पत्नी/मंत्री उनसे कहते हैं):
            हे यमराज! जब कोई ब्रह्मज्ञानी ब्राह्मण अतिथि के रूप में घर में प्रवेश करता है, तो वह साक्षात् अग्नि (वैश्वानर) के समान होता है।
            सज्जन लोग उस अग्नि को शांत करने के लिए (अर्थात अतिथि के सम्मान के लिए) अर्घ्य (जल) आदि देकर उसकी शांति करते हैं।
            इसलिए हे वैवस्वत (सूर्य-पुत्र यमराज)! आप इस अतिथि ब्राह्मण बालक (नचिकेता) के लिए तुरंत जल लेकर आइए।
            भारतीय संस्कृति में अतिथि को 'देवो भव' (भगवान) माना गया है, विशेषकर वह अतिथि जो ज्ञान की खोज में हो।
            यदि अतिथि भूखा-प्यासा घर में बैठा रहे, तो वह घर के पुण्यों को अग्नि की तरह जलाकर भस्म कर देता है।
            यमराज जो पूरी दुनिया को मारते हैं, उन्हें भी अतिथि सत्कार के सार्वभौमिक (Universal) नियमों का पालन करना पड़ता है।
            नचिकेता बिना खाए-पिए तीन दिन और तीन रात तक यमराज के दरवाजे पर सत्य की भूख लिए बैठा रहा।
            यह उस बालक की गज़ब की दृढ़ता और तपस्या है कि वह साक्षात् मृत्यु के दरवाजे पर भी भयभीत नहीं हुआ।
            यह श्लोक अतिथि सत्कार के महत्व और एक सच्चे साधक की तपस्या के प्रभाव को अत्यंत स्पष्ट रूप से बताता है।
        """.trimIndent(),
        english = """
            (Nachiketa reaches Yama's abode, but Yama is away. Returning after three days, Yama's wife/ministers advise Him):
            O Yama! When a God-knowing Brahmin enters a house as a guest, he enters entirely like blazing fire (Vaishvanara).
            Noble householders pacify that intense fire (meaning, honor the guest) by respectfully offering water and hospitality.
            Therefore, O Vaivasvata (Son of Sun/Yama)! Please bring water immediately for this young Brahmin guest (Nachiketa).
            In Indian culture, a guest is treated as 'God' (Atithi Devo Bhava), especially a guest who is a sincere seeker of Truth.
            If a guest remains hungry and thirsty in a house, he completely burns away all the merits of that household like a fire.
            Even Lord Yama, who controls the deaths of the whole world, must strictly obey the universal laws of hospitality.
            Nachiketa sat at the door of Death for three full days and nights without food or water, hungry only for the Truth.
            This demonstrates the boy's astonishing determination and austerity; he did not flinch even at the door of Death itself.
            This verse exceptionally highlights the deep importance of hospitality and the immense power of a true seeker's penance.
        """.trimIndent()
    ),
    KathaShloka(
        id = 8,
        sanskrit = "आशाप्रतीक्षे संगतं सूनृतां चेष्टापूर्ते पुत्रपशूँश्च सर्वान् । एतद्वृङ्क्ते पुरुषस्याल्पमेधसो यस्यानश्नन् वसति ब्राह्मणो गृहे ॥ ८ ॥",
        hindi = """
            (मंत्री यमराज को चेतावनी देते हैं): जिस मूर्ख या अल्प-बुद्धि (अल्पमेधसः) व्यक्ति के घर में।
            कोई ब्राह्मण (विद्वान) अतिथि बिना भोजन और जल ग्रहण किए (अनश्नन्) निवास करता है।
            उस व्यक्ति की सभी आशाएं (अनजान इच्छाएं), प्रतीक्षाएं (जानी हुई उम्मीदें), सत्संग का फल, और मीठी वाणी का फल नष्ट हो जाता है।
            उसके द्वारा किए गए सभी इष्ट (यज्ञ) और पूर्त (कुएं, तालाब बनवाना) कर्मों का फल भी पूरी तरह जल जाता है।
            और तो और, उसके सभी पुत्र और पशुधन भी उस भूखे अतिथि के प्रताप से नष्ट हो जाते हैं।
            यह श्लोक कर्मफल और नैतिकता का एक बहुत ही कठोर नियम स्थापित करता है।
            आप चाहे कितने भी बड़े मंदिर बनवा लें, दान दे दें, या मीठा बोलें, पर यदि आपके द्वार से कोई भूखा लौट गया।
            तो आपके वे सारे अच्छे कर्म जीरो (Zero) हो जाते हैं, क्योंकि मानवता और करुणा ही धर्म का सबसे बड़ा आधार है।
            यमराज, जो कर्मों के सबसे बड़े न्यायाधीश हैं, उनके घर में ही यह भारी चूक हो गई थी।
            इसलिए मृत्यु का देवता भी अपने कर्मों के फल से डरकर नचिकेता से क्षमा मांगने के लिए दौड़ा चला आता है।
        """.trimIndent(),
        english = """
            (The ministers warn Lord Yama): The foolish or little-witted (Alpamedhasah) person in whose house.
            A Brahmin (learned) guest dwells and stays completely without eating food or drinking water (Anashnan).
            All of that person's unknown hopes (Asha), known expectations (Pratiksha), fruits of good company, and sweet words are destroyed.
            The spiritual merits of all his sacrifices (Ishta) and public works like wells and charity (Purta) are also completely burnt away.
            Moreover, all his sons, progeny, and cattle wealth are entirely destroyed by the fiery impact of that hungry guest.
            This verse establishes an extremely strict and uncompromising law of karma and spiritual ethics.
            You may build huge temples, give massive charity, or speak sweetly, but if a hungry guest is ignored at your door.
            All your noble deeds are reduced to absolute zero, because humanity and deep compassion are the greatest foundations of Dharma.
            Lord Yama, the supreme judge of all karmas, had Himself committed this massive error in His own household.
            Therefore, even the God of Death, fearing the consequences of karma, rushes hurriedly to apologize to young Nachiketa.
        """.trimIndent()
    ),
    KathaShloka(
        id = 9,
        sanskrit = "तिस्रो रात्रीर्यदवात्सीर्गृहे मेऽनश्नन् ब्रह्मन्नतिथिर्नमस्यः । नमस्तेऽस्तु ब्रह्मन् स्वस्ति मेऽस्तु तस्मात्प्रति त्रीन्वरान्वृणीष्व ॥ ९ ॥",
        hindi = """
            (यमराज नचिकेता के पास आकर हाथ जोड़कर कहते हैं): हे ब्रह्मन्! आप मेरे घर में नमस्कार करने योग्य एक परम पूजनीय अतिथि हैं।
            चूंकि आपने मेरे घर में बिना कुछ खाए-पिए लगातार तीन रातें (और तीन दिन) भूखे रहकर बिताई हैं।
            इसलिए हे ब्रह्मन्! आपको मेरा बार-बार नमस्कार है, और इसके बदले मेरा कल्याण (स्वस्ति) हो (मुझे पाप न लगे)।
            आपने यहाँ तीन रातें कष्ट सहा है, इसलिए आप इसके बदले मुझसे कोई भी तीन मनचाहे वरदान (Three Boons) मांग लीजिए।
            यह प्रसंग अत्यंत अद्भुत है—मृत्यु का देवता, जिससे पूरी दुनिया कांपती है, वह एक छोटे से बच्चे के सामने हाथ जोड़ रहा है।
            यह ज्ञान, तपस्या और सत्यनिष्ठा की वह ताकत है जो भगवान को भी झुकने पर मजबूर कर देती है।
            यमराज अपनी गलती मानते हैं; वे अहंकार नहीं करते कि 'मैं तो मृत्यु का राजा हूँ, मुझे क्या फर्क पड़ता है।'
            सच्चा बड़ा व्यक्ति वही होता है जो अपनी भूल स्वीकार कर ले और उसे सुधारने का प्रयास करे।
            तीन रात के बदले तीन वरदान—यह ईश्वर के न्याय का प्रतीक है कि कोई भी तपस्या कभी खाली नहीं जाती।
            यहीं से इस उपनिषद के मूल उपदेश की आधारशिला रखी जाती है, जहाँ नचिकेता तीन वरदान मांगेगा।
        """.trimIndent(),
        english = """
            (Yama approaches Nachiketa with folded hands and says): O Brahmin! You are a highly venerable guest worthy of salutations in my house.
            Since you have resided continuously in my house for three nights (and days) completely without eating or drinking anything.
            Therefore, O Brahmin! My repeated salutations to you, and may welfare (Svati) be upon me (may I be absolved of this sin).
            Since you have endured hardship here for three nights, please choose any three boons (Varan) of your choice in return.
            This scene is absolutely astonishing—the Lord of Death, whom the entire world fears, is folding hands before a little boy.
            This is the sheer, unmatched power of wisdom, penance, and truthfulness that forces even God to bow down.
            Yama admits His mistake; He does not show the ego of thinking, 'I am the King of Death, why should I care?'
            A truly great individual is always the one who gracefully accepts his mistakes and actively tries to correct them.
            Three boons for three nights—this symbolizes God's perfect justice, ensuring that no spiritual penance ever goes unrewarded.
            From this exact point, the foundation of this Upanishad's core teachings is laid, as Nachiketa will now ask for his three boons.
        """.trimIndent()
    ),
    KathaShloka(
        id = 10,
        sanskrit = "शान्तसंकल्पः सुमना यथा स्याद्वीतमन्युर्गौतमो माभि मृत्यो । त्वत्प्रसृष्टं माभिवदेत्प्रतीत एतत् त्रयाणां प्रथमं वरं वृणे ॥ १० ॥",
        hindi = """
            (नचिकेता अपना पहला वरदान मांगता है): हे मृत्युदेव! मेरे पिता गौतम (वाजश्रवा) का मन मेरे प्रति पूरी तरह शांत हो जाए।
            वे प्रसन्न मन वाले (सुमना) हो जाएं और उनका सारा क्रोध (मन्यु) हमेशा के लिए पूरी तरह शांत हो जाए।
            जब मैं आपके द्वारा वापस पृथ्वी पर भेजा जाऊँ, तो वे मुझे अच्छी तरह पहचान लें और मुझसे प्रेमपूर्वक बात करें।
            हे यमराज! इन तीन वरदानों में से मैं यह अपना 'पहला वरदान' मांगता हूँ।
            नचिकेता ने सबसे पहले अपने लिए कोई ज्ञान या अमरता नहीं मांगी, बल्कि अपने पिता की शांति मांगी।
            यह एक श्रेष्ठ और आदर्श पुत्र का लक्षण है, जिसे अपने क्रोधी पिता से भी कोई शिकायत या नफरत नहीं है।
            पिता ने उसे मौत के मुँह में धकेल दिया था, फिर भी पुत्र चाहता है कि पिता को इस बात का पछतावा और दुख न सताए।
            आध्यात्मिक यात्रा की शुरुआत मानसिक शांति और पारिवारिक क्षमा (Forgiveness) से ही होती है।
            जब तक घर और रिश्तों में कड़वाहट है, तब तक कोई भी इंसान ध्यान या सत्य की ऊँचाइयों को नहीं छू सकता।
            पहला वरदान 'भावनात्मक शुद्धि' (Emotional healing) का प्रतीक है, जो योग के लिए सबसे पहली शर्त है।
        """.trimIndent(),
        english = """
            (Nachiketa asks for his first boon): O Lord of Death! May my father Gautama's (Vajasrava's) mind become completely peaceful towards me.
            May he become of a cheerful mind (Sumana), and may all his fierce anger (Manyu) be permanently pacified.
            When I am sent back to the earth by You, may he recognize me properly and speak to me with deep love and affection.
            O Yama! Out of the three boons, I choose this as my very 'first boon'.
            Nachiketa did not ask for wisdom or immortality for himself first; he primarily asked for his father's peace of mind.
            This is the ultimate hallmark of an ideal son, who holds absolutely no grudge or hatred even against an angry father.
            His father pushed him into the jaws of death, yet the son desires that his father should not suffer from regret and guilt.
            The spiritual journey must always begin with profound mental peace and absolute familial forgiveness.
            As long as there is bitterness in the home and relationships, no human can ever touch the heights of meditation or Truth.
            The first boon perfectly symbolizes 'Emotional Healing', which is the very first and most essential prerequisite for Yoga.
        """.trimIndent()
    ),
    KathaShloka(
        id = 11,
        sanskrit = "यथा पुरस्ताद् भविता प्रतीत औद्दालकिरारुणिर्मत्प्रसृष्टः । सुखँ रात्रीः शयिता वीतमन्युस्त्वां ददृशिवान्मृत्युमुखात् प्रमुक्तम् ॥ ११ ॥",
        hindi = """
            (यमराज ने मुस्कुराकर कहा): मेरे द्वारा यहाँ से मुक्त किए जाने पर तुम्हारे पिता (आरुणि उद्दालक)।
            तुम्हें मौत के मुँह से वापस लौटा हुआ देखकर, तुम्हें पहले की तरह ही प्रेम से पहचान लेंगे और स्वीकार करेंगे।
            उनका सारा क्रोध पूरी तरह से नष्ट हो जाएगा और वे तुमसे पहले जैसा ही स्नेह करने लगेंगे।
            और तुम्हें जीवित देखकर वे अपने जीवन की शेष रातें अत्यंत सुख और शांति के साथ सो पाएंगे।
            यमराज ने बिना किसी झिझक के तुरंत पहला वरदान दे दिया, क्योंकि इसमें सच्चा निःस्वार्थ प्रेम था।
            मृत्यु के देवता यह आश्वासन दे रहे हैं कि जो इंसान सत्य पर टिका रहता है, भगवान उसके सभी बिगड़े काम बना देते हैं।
            पिता का क्रोध एक तात्कालिक (Temporary) उफान था; जब वह शांत होगा, तो उन्हें अपनी भूल पर बहुत पीड़ा होगी।
            यमराज उस पीड़ा को मिटाने का वादा करते हैं; यह ईश्वर की करुणा (Compassion) का बहुत ही सुंदर उदाहरण है।
            जब हम दूसरों की भलाई मांगते हैं, तो भगवान हमें हमारी सोच से भी ज्यादा सुख और शांति प्रदान करते हैं।
            नचिकेता की पहली परीक्षा पास हो गई; उसने साबित कर दिया कि उसके मन में कोई अहंकार या बदला लेने की भावना नहीं है।
        """.trimIndent(),
        english = """
            (Yama smiled and replied): By my command and blessing, when you are released from here, your father (Auddalaki Aruni).
            Seeing you returned safely from the jaws of death, will recognize you and accept you with love exactly as before.
            All his anger will be completely and permanently destroyed, and he will love you with the same affection as before.
            And seeing you alive, he will be able to sleep the remaining nights of his life in supreme happiness and absolute peace.
            Yama granted the very first boon immediately without any hesitation, because it contained pure, selfless love.
            The God of Death assures that for a person who remains steadfast in truth, God Himself fixes all his broken situations.
            The father's anger was a temporary outburst; when calmed, he would suffer immense agony over his grave mistake.
            Yama promises to erase that agonizing guilt; this is an exceedingly beautiful example of God's limitless compassion.
            When we ask for the welfare of others, God grants us far more happiness and peace than we can even imagine.
            Nachiketa passed his first test; he proved absolutely that there is no ego or feeling of revenge in his heart.
        """.trimIndent()
    ),
    KathaShloka(
        id = 12,
        sanskrit = "स्वर्गे लोके न भयं किञ्चनास्ति न तत्र त्वं न जरया बिभेति । उभे तीर्त्वाशनायापिपासे शोकातिगो मोदते स्वर्गलोके ॥ १२ ॥",
        hindi = """
            (नचिकेता अब दूसरे वरदान की भूमिका बनाता है): हे यमराज! मैंने सुना है कि स्वर्ग लोक में किसी भी प्रकार का कोई डर नहीं है।
            वहाँ पर आप (मृत्यु) भी नहीं जा सकते, और वहाँ किसी को बुढ़ापे (जरा) का भय भी नहीं सताता है।
            स्वर्ग में रहने वाला मनुष्य भूख और प्यास—इन दोनों शारीरिक कष्टों को पूरी तरह से पार कर जाता है।
            वह सभी प्रकार के मानसिक शोकों (दुखों) से ऊपर उठकर, उस स्वर्ग लोक में हमेशा परमानंद में मग्न (मोदते) रहता है।
            नचिकेता यहाँ एक आम इंसान की सबसे बड़ी मनोवैज्ञानिक इच्छा (Psychological desire) का वर्णन कर रहा है।
            दुनिया का हर इंसान मौत, बुढ़ापे, भूख और दुख से डरता है; वह एक ऐसी जगह चाहता है जहाँ ये सब न हों।
            स्वर्ग कोई आसमान में तैरता हुआ शहर नहीं है, यह एक 'स्टेट ऑफ माइंड' (State of mind) या चेतना का स्तर है।
            जहाँ भौतिक शरीर की मजबूरियां (भूख/प्यास) और मन की चिंताएं (शोक) खत्म हो जाएं, वही स्वर्ग है।
            चूंकि नचिकेता के पिता स्वर्ग पाना चाहते थे, इसलिए नचिकेता इस दूसरे वरदान को उनके और दुनिया के लिए मांग रहा है।
            वह जानना चाहता है कि उस परम सुखदायक स्वर्ग तक पहुँचने की अचूक और वैज्ञानिक विधि (Technology) क्या है।
        """.trimIndent(),
        english = """
            (Nachiketa sets the context for the second boon): O Yama! I have heard that in the heavenly world, there is absolutely no fear of any kind.
            Even You (Death) cannot enter there, and no one there is ever tormented by the fear of old age (Jara).
            A person residing in heaven completely crosses over both the physical afflictions of terrible hunger and thirst.
            Rising entirely above all kinds of mental sorrows and grief, he rejoices and dwells in supreme bliss in that heavenly world.
            Nachiketa is describing the greatest psychological desire of an ordinary human being here.
            Every human in the world fears death, old age, hunger, and sorrow; he intensely desires a place where these do not exist.
            Heaven is not a city floating in the sky; it represents a 'State of mind' or an elevated level of consciousness.
            Where the compulsions of the physical body (hunger/thirst) and the anxieties of the mind (sorrow) end, that exactly is heaven.
            Since Nachiketa's father desperately wanted to attain heaven, Nachiketa is asking this second boon for him and the world.
            He wants to know the exact, infallible, and scientific method (technology) to successfully reach that supremely blissful heaven.
        """.trimIndent()
    ),
    KathaShloka(
        id = 13,
        sanskrit = "स त्वमग्निं स्वर्ग्यमध्येषि मृत्यो प्रब्रूहि त्वँ श्रद्दधानाय मह्यम् । स्वर्गलोका अमृतत्वं भजन्त एतद् द्वितीयेन वृणे वरेण ॥ १३ ॥",
        hindi = """
            (नचिकेता कहता है): हे मृत्युदेव! आप स्वर्ग प्रदान करने वाली उस रहस्यमयी 'अग्नि विद्या' को पूरी तरह से जानते हैं।
            मुझमें पूर्ण श्रद्धा और विश्वास है; कृपया आप मुझे उस दिव्य अग्नि विद्या का विस्तार से उपदेश दीजिए (प्रब्रूहि)।
            जिस अग्नि विद्या के द्वारा स्वर्ग लोक को प्राप्त करने वाले लोग अमृतत्व (देवत्व/अमरता) का भोग करते हैं।
            हे यमराज! अपने दूसरे वरदान के रूप में मैं आपसे इसी स्वर्गिक अग्नि विद्या का ज्ञान मांगता हूँ।
            पहला वरदान भावनात्मक था (पिता का प्रेम), दूसरा वरदान भौतिक और लौकिक सुखों (स्वर्ग) का रहस्य है।
            नचिकेता ने यहाँ 'श्रद्दधानाय' शब्द का प्रयोग किया है, जिसका अर्थ है कि वह इसे केवल जिज्ञासा के लिए नहीं पूछ रहा।
            वह पूरी श्रद्धा के साथ इसका अभ्यास करना चाहता है। ज्ञान हमेशा उसी को देना चाहिए जिसके भीतर श्रद्धा हो।
            यहाँ 'अग्नि' का अर्थ लकड़ी जलाने वाली आग नहीं है, यह ब्रह्मांडीय ऊर्जा और यज्ञ-विज्ञान (Science of rituals) का प्रतीक है।
            जो व्यक्ति अपनी ऊर्जा को सही दिशा में 'यज्ञ' की तरह इस्तेमाल करता है, वह जीवन में सभी प्रकार के सुख (स्वर्ग) पा लेता है।
            यमराज खुश हैं क्योंकि लड़का कोई तुच्छ चीज़ नहीं, बल्कि वह विद्या मांग रहा है जो पूरी मानवता के काम आएगी।
        """.trimIndent(),
        english = """
            (Nachiketa says): O Lord of Death! You perfectly know that mystical 'Fire-knowledge' (Agni Vidya) which leads directly to heaven.
            I possess absolute faith and trust; please instruct and explain that divine Fire-knowledge to me in detail.
            The fire-knowledge by which the dwellers of the heavenly world attain and enjoy immortality (divinity).
            O Yama! As my second boon, I specifically choose and ask for the profound knowledge of this heavenly Fire.
            The first boon was emotional (father's love); the second boon is the secret of physical and worldly happiness (heaven).
            Nachiketa uses the word 'Shraddhadhanaya' here, meaning he is not asking merely out of casual curiosity.
            He intensely wants to practice it with full faith. Wisdom should always be imparted only to one who has Shraddha.
            'Fire' here does not mean a wood-burning flame; it symbolizes cosmic energy and the deep science of rituals (Yajna).
            A person who uses his energy in the right direction like a 'Yajna' attains all kinds of happiness (heaven) in life.
            Yama is highly pleased because the boy is not asking for a trivial thing, but a science that will benefit all of humanity.
        """.trimIndent()
    ),
    KathaShloka(
        id = 14,
        sanskrit = "प्र ते ब्रवीमि तदु मे निबोध स्वर्ग्यमग्निं नचिकेतः प्रजानन् । अनन्तलोकाप्तिमथो प्रतिष्ठां विद्धि त्वमेतं निहितं गुहायाम् ॥ १४ ॥",
        hindi = """
            (यमराज कहते हैं): हे नचिकेता! मैं स्वर्ग देने वाली उस अग्नि विद्या को बहुत अच्छी तरह से जानता हूँ, मैं तुम्हें बताता हूँ।
            तुम उसे मुझसे अत्यंत सावधानी और ध्यानपूर्वक सुनो और समझो (निबोध)।
            यह अग्नि विद्या अनंत लोकों (स्वर्ग) को प्राप्त कराने वाली है, और यह इस पूरे ब्रह्मांड का मुख्य आधार (प्रतिष्ठा) है।
            तुम यह जान लो कि यह रहस्यमयी अग्नि विद्या विद्वानों के हृदय रूपी गुफा (गुहायाम्) में गहराई से छिपी हुई है।
            यमराज ने यह स्पष्ट कर दिया कि स्वर्ग जाने का रास्ता आसमान में नहीं, बल्कि हमारे अपने 'हृदय की गुफा' में है।
            यह अग्नि कोई बाहरी वस्तु नहीं है; यह हमारी अपनी 'चेतना' और 'प्राण ऊर्जा' (Life force) है।
            जब इंसान अपनी ऊर्जा (अग्नि) को इच्छाओं और वासनाओं में नष्ट करने की बजाय, ध्यान के द्वारा भीतर (गुहा में) संचित करता है।
            तब वह ऊर्जा एक ऐसा विस्फोट करती है जिससे उसे इसी जीवन में स्वर्ग (परम सुख) की अनुभूति होती है।
            यमराज 'निबोध' (ध्यान से सुनो) कह रहे हैं, क्योंकि यह विषय बहुत सूक्ष्म है और ज़रा सा ध्यान भटका तो अर्थ बदल जाएगा।
            स्वर्ग कोई भौगोलिक स्थान नहीं है, यह एक चेतना की अवस्था है जहाँ ऊर्जा पूरी तरह से संतुलित और ऊर्ध्वगामी होती है।
        """.trimIndent(),
        english = """
            (Yama says): O Nachiketa! I know that heaven-granting Fire-knowledge perfectly well; I shall declare it to you.
            Listen to it from me and understand it with extreme care and deep attention (Nibodha).
            This Fire-knowledge is the ultimate means to attain the infinite worlds (heaven), and it is the very foundation of the cosmos.
            You must know that this mystical Fire is deeply hidden securely within the cave of the heart (Guhayam) of the wise.
            Yama makes it exceptionally clear that the path to heaven is not in the sky, but right inside the 'cave of our own heart'.
            This Fire is not an external physical object; it is entirely our own 'Consciousness' and 'Vital Life Force' (Prana).
            When a person, instead of wasting his energy (fire) in desires, accumulates it within (in the cave) through meditation.
            Then that energy triggers an explosion that makes him experience heaven (supreme bliss) in this very lifetime.
            Yama says 'Nibodha' (listen carefully), because this subject is highly subtle and a slight distraction alters the meaning completely.
            Heaven is not a geographical location; it is a state of consciousness where energy is perfectly balanced and moving upwards.
        """.trimIndent()
    ),
    KathaShloka(
        id = 15,
        sanskrit = "लोकादिमग्निं तमुवाच तस्मै या इष्टका यावतीर्वा यथा वा । स चापि तत्प्रत्यवदद्यथोक्तमथास्य मृत्युः पुनरेवाह तुष्टः ॥ १५ ॥",
        hindi = """
            तब यमराज ने नचिकेता को उस अग्नि विद्या का ज्ञान दिया जो सभी लोकों का आदिकारण (मूल आधार) है।
            यमराज ने विस्तार से बताया कि यज्ञ की वेदी (Altar) बनाने के लिए कैसी ईंटें चाहिए, कितनी ईंटें चाहिए और उन्हें कैसे रखना है।
            नचिकेता इतना मेधावी था कि यमराज ने जो कुछ भी समझाया, उसने वह सब कुछ अक्षरशः (exactly) वैसे ही दोहरा (प्रत्यवदत्) दिया।
            नचिकेता की इस अद्भुत स्मरण शक्ति और गहरी एकाग्रता को देखकर मृत्यु के देवता यमराज अत्यंत प्रसन्न (तुष्ट) हो गए।
            यज्ञ की वेदी बनाना वास्तव में हमारे अपने शरीर और मन को व्यवस्थित (Organize) करने का एक रूपक (Metaphor) है।
            ईंटों का मतलब है हमारे विचार, अनुशासन और कर्म; यदि एक भी ईंट गलत रखी गई, तो साधना की इमारत गिर जाएगी।
            यमराज ने केवल थ्योरी (Theory) नहीं बताई, बल्कि 'यथा वा' (कैसे करें) बताकर पूरा प्रैक्टिकल (Practical) विज्ञान समझाया।
            नचिकेता एक आदर्श विद्यार्थी है—वह केवल सुनता नहीं है, वह ज्ञान को पूरी तरह आत्मसात कर लेता है।
            जब गुरु को यह दिखता है कि शिष्य पूरी तरह से ग्रहणशील (Receptive) है, तो गुरु का हृदय खुशी से भर जाता है।
            यमराज इतने खुश हुए कि वे दूसरे वरदान के साथ अपनी तरफ से एक 'बोनस' (Bonus) वरदान देने के लिए तैयार हो गए।
        """.trimIndent(),
        english = """
            Then Lord Yama imparted to Nachiketa the deep knowledge of that Fire which is the root cause (origin) of all worlds.
            Yama explained in great detail what kind of bricks are needed for the altar, how many are required, and exactly how to arrange them.
            Nachiketa was so remarkably intelligent that he repeated (Pratyavadat) everything exactly word-for-word as Yama had taught him.
            Witnessing Nachiketa's astonishing memory and his profound concentration, the God of Death, Yama, was extremely delighted.
            Building the sacrificial altar is actually a powerful metaphor for precisely organizing our own body and mind.
            The bricks symbolize our thoughts, discipline, and actions; if even one brick is misplaced, the building of Sadhana will collapse.
            Yama didn't just give the theory; by explaining 'Yatha va' (how to do it), He taught the complete practical science.
            Nachiketa is an absolutely ideal student—he doesn't merely listen; he absorbs and assimilates the knowledge completely.
            When a Guru sees that a disciple is perfectly receptive, the Guru's heart overflows with immense joy.
            Yama was so pleased that He became ready to offer a special 'bonus' gift along with the second boon of His own accord.
        """.trimIndent()
    ),
    KathaShloka(
        id = 16,
        sanskrit = "तमब्रवीत् प्रीयमाणो महात्मा वरं तवेहाद्य ददामि भूयः । तवैव नाम्ना भवितायमग्निः सृङ्कां चेमामनेकरूपां गृहाण ॥ १६ ॥",
        hindi = """
            उस बालक की योग्यता से अत्यंत प्रसन्न होकर उस महात्मा यमराज ने उससे कहा: "मैं तुम्हें आज एक और वरदान (अतिरिक्त) देता हूँ।"
            "आज से इस पवित्र स्वर्गिक अग्नि विद्या को इस संसार में तुम्हारे ही नाम (नाचिकेत अग्नि) से जाना जाएगा।"
            "और यह लो, अनेक रूप और रंगों वाली यह सुंदर रत्नों की माला (सृङ्कां) भी तुम मेरी तरफ से स्वीकार करो।"
            यह एक गुरु का अपने सबसे प्रिय शिष्य के लिए उमड़ता हुआ असीम प्रेम है।
            यमराज ने नचिकेता को अमर कर दिया; जब तक दुनिया में वेद रहेंगे, उस अग्नि को 'नाचिकेत अग्नि' ही कहा जाएगा।
            माला (सृङ्कां) यहाँ केवल आभूषण नहीं है; यह कर्मों के उत्कृष्ट फल और सिद्धि (Perfection) का प्रतीक है।
            जब साधक बिना किसी लालच के ज्ञान प्राप्त करता है, तो दुनिया का सारा वैभव भगवान उसे खुद-ब-खुद पहना देते हैं।
            नचिकेता ने नाम या प्रसिद्धि नहीं मांगी थी, पर सत्य के रास्ते पर चलने वालों के पीछे प्रसिद्धि खुद भाग कर आती है।
            यह श्लोक गुरु की उस उदारता को दिखाता है कि यदि शिष्य पात्र (Worthy) हो, तो गुरु अपना सब कुछ लुटाने को तैयार रहता है।
            यहाँ दूसरा वरदान पूर्ण रूप से संपन्न होता है, और नचिकेता को भौतिक और दैवीय दोनों सुखों का रहस्य मिल जाता है।
        """.trimIndent(),
        english = """
            Being exceedingly pleased with the boy's supreme competence, the great-souled Yama said: "I grant you one more (extra) boon here today."
            "From this day onward, this sacred heavenly Fire-knowledge shall be known in the world strictly by your name (Nachiketa Fire)."
            "And take this, accept this beautiful garland (Srinkam) studded with manifold colors and precious gems from my side."
            This represents a Guru's overflowing, boundless love and affection for his most exceptionally worthy disciple.
            Yama immortalized Nachiketa; as long as the Vedas exist in the world, that fire will be called the 'Nachiketa Fire'.
            The garland (Srinkam) here is not mere jewelry; it is a profound symbol of excellent karmic fruits and spiritual perfection.
            When a seeker acquires wisdom entirely without greed, God automatically adorns him with all the splendors of the world.
            Nachiketa never asked for name or fame, but fame naturally runs after those who walk the path of absolute Truth.
            This verse demonstrates a Guru's generosity—if the disciple is truly worthy, the Guru is ready to give away everything.
            Here the second boon is perfectly concluded, and Nachiketa receives the ultimate secret to both worldly and divine happiness.
        """.trimIndent()
    ),
    KathaShloka(
        id = 17,
        sanskrit = "त्रिणाचिकेतस्त्रिभिः सन्धिमेत्य त्रिकर्मकृत्तरति जन्ममृत्यू । ब्रह्मजज्ञं देवमीड्यं विदित्वा निचाय्येमाँ शान्तिमत्यन्तमेति ॥ १७ ॥",
        hindi = """
            जो व्यक्ति तीन बार 'नाचिकेत अग्नि' का चयन (अनुष्ठान) करता है, और जो तीन (माता, पिता, गुरु या वेद, स्मृति, सदाचार) से संधि (जुड़ाव) कर लेता है।
            तथा जो तीन कर्मों (यज्ञ, दान, तप) को जीवन में निरंतर करता है, वह जन्म और मृत्यु के सागर को पूरी तरह पार कर जाता है।
            ब्रह्मा जी (ब्रह्म) से उत्पन्न हुए उस सर्वज्ञ और स्तुति करने योग्य (ईड्य) परम देव (परमात्मा) को जब वह जान लेता है।
            और जब वह उसे अपने हृदय में साक्षात् अनुभव (निचाय्य) कर लेता है, तब वह अत्यंत और परम शांति को प्राप्त करता है।
            इस श्लोक में 'तीन' (Three) की संख्या पर बहुत जोर दिया गया है, जो संतुलन (Balance) का प्रतीक है।
            हम जीवन के सागर को केवल तभी पार कर सकते हैं जब हमारे विचार, हमारे शब्द और हमारे कर्म तीनों एक दिशा (सत्य) में हों।
            यज्ञ, दान और तप—ये तीनों कर्म इंसान के अहंकार को काटते हैं और उसे समाज तथा ईश्वर से जोड़ते हैं।
            केवल अग्नि (ऊर्जा) को जगाना काफी नहीं है; उस ऊर्जा का उपयोग ईश्वर (ब्रह्मजज्ञं) को जानने में होना चाहिए।
            अत्यंत शांति (Atyanta Shanti) वह अवस्था है जहाँ मन की कोई लहर नहीं बचती, कोई इच्छा नहीं सताती।
            स्वर्ग (दूसरा वरदान) अंतिम मंजिल नहीं है; अंतिम मंजिल वह शांति है जो भगवान को 'निचाय्य' (गहराई से अनुभव) करने पर मिलती है।
        """.trimIndent(),
        english = """
            He who performs the 'Nachiketa Fire' sacrifice three times, and who forms a union (Sandhi) with the three (Mother, Father, Guru or Vedas, Smriti, Ethics).
            And who continuously performs the three duties (Sacrifice, Charity, Austerity), completely crosses over the ocean of birth and death.
            When he truly knows that omniscient and highly adorable (Idya) Supreme Deity who is born from Brahman (Hiranyagarbha).
            And when he directly realizes (Nichayya) Him deeply in his heart, he attains extreme and ultimate absolute peace.
            In this verse, great emphasis is placed on the number 'Three', which perfectly symbolizes absolute balance.
            We can cross the ocean of life only when our thoughts, our words, and our actions are perfectly aligned in one direction (Truth).
            Sacrifice, Charity, and Austerity—these three actions cut down human ego and connect a person to society and God.
            Merely awakening the fire (energy) is not enough; that energy must be utilized to completely know God (Brahmajajnam).
            'Atyanta Shanti' (Ultimate Peace) is that highest state where no ripple of the mind remains and no desire torments.
            Heaven (the second boon) is not the final destination; the final goal is that absolute peace found by deeply experiencing God.
        """.trimIndent()
    ),
    KathaShloka(
        id = 18,
        sanskrit = "त्रिणाचिकेतस्त्रयमेतद्विदित्वा य एवं विद्वाँश्चिनुते नाचिकेतम् । स मृत्युपाशान् पुरतः प्रणोद्य शोकातिगो मोदते स्वर्गलोके ॥ १८ ॥",
        hindi = """
            जो विद्वान साधक उन तीन बातों (ईंटों का स्वरूप, उनकी संख्या और उनके रखने की विधि) को भलीभांति जानकर।
            तीन बार नाचिकेत अग्नि का विधिपूर्वक अनुष्ठान और चयन (चिनुते) करता है।
            वह मनुष्य अपने शरीर के गिरने (मृत्यु) से बहुत पहले ही (पुरतः) मृत्यु के सभी पाशों (बंधनों) को काट कर फेंक देता है।
            और वह सभी प्रकार के शोकों और दुखों के पार (शोकातिग) होकर स्वर्ग लोक में परम आनंद (मोदते) का भोग करता है।
            यहाँ यमराज उस अग्नि विद्या के अद्भुत परिणामों (Results) को दोहरा कर पक्का कर रहे हैं।
            मृत्युपाश (Chains of Death) का अर्थ शारीरिक मौत नहीं है, बल्कि 'मैं मरने वाला हूँ' यह डर और भ्रम है।
            सच्चा योगी मरने के बाद आज़ाद नहीं होता, वह इसी जीवन में ('पुरतः' यानी पहले ही) हर डर से मुक्त हो जाता है।
            जब इंसान को पता चल जाता है कि ऊर्जा (अग्नि) का सही उपयोग कैसे करना है, तो दुख उसे छू भी नहीं सकता।
            स्वर्ग लोक यहाँ एक प्रतीक है उस मानसिक अवस्था का जहाँ न कोई चिंता है और न कोई दुख (शोकातिग)।
            नचिकेता को दूसरे वरदान की पूरी कुंजी (Key) मिल गई है—कर्म और ज्ञान का सही मिश्रण ही सुख का रास्ता है।
        """.trimIndent(),
        english = """
            The wise seeker who, having perfectly understood those three things (the nature of bricks, their number, and arrangement method).
            And who performs and piles (Chinute) the Nachiketa Fire systematically exactly three times.
            That person completely breaks and throws off all the terrifying chains of death far before (Puratah) his physical body falls.
            And going entirely beyond all forms of grief and sorrow (Shokatiga), he rejoices in supreme bliss in the heavenly world.
            Here Yama is firmly repeating and confirming the miraculous results of that sacred Fire-knowledge.
            The chains of death (Mrityupasha) do not mean physical death, but the deep illusion and fear that 'I am going to die'.
            A true yogi doesn't get free after dying; he becomes completely free from every fear in this very life ('Puratah' - beforehand).
            When a person truly understands how to rightly utilize his energy (fire), sorrow cannot even touch him.
            Heavenly world here is a symbol of that elevated mental state where there is neither any anxiety nor any grief.
            Nachiketa has now received the complete key to the second boon—the perfect mixture of karma and wisdom is the path to joy.
        """.trimIndent()
    ),
    KathaShloka(
        id = 19,
        sanskrit = "एष तेऽग्निर्नचिकेतः स्वर्ग्यो यमवृणीथा द्वितीयेन वरेण । एतमग्निं तवैव प्रवक्ष्यन्ति जनासस्तृतीयं वरं नचिकेतो वृणीष्व ॥ १९ ॥",
        hindi = """
            (यमराज कहते हैं): हे नचिकेता! यह वह स्वर्ग प्रदान करने वाली अग्नि विद्या है, जिसे तुमने अपने दूसरे वरदान के रूप में मांगा था।
            आज से सभी लोग (जनासः) इस महान अग्नि को केवल तुम्हारे ही नाम (नाचिकेत अग्नि) से पुकारेंगे और जानेंगे।
            अब तुम्हारे दो वरदान पूरे हो चुके हैं; इसलिए हे नचिकेता! अब तुम अपना 'तीसरा वरदान' मांगो (वृणीष्व)।
            यहाँ यमराज ने भौतिक और लौकिक ज्ञान (स्वर्ग) का अध्याय पूरी तरह से समाप्त कर दिया है।
            नचिकेता ने सिद्ध कर दिया कि वह एक अत्यंत कुशाग्र (Sharp) और योग्य शिष्य है।
            यमराज उसे याद दिला रहे हैं कि अभी एक और वरदान बाकी है, जो इस उपनिषद को सबसे ऊंचे शिखर पर ले जाएगा।
            अब तक जो मांगा गया, वह संसार (स्वर्ग) से जुड़ा था; पर असली सवाल तो अभी बाकी है।
            एक सच्चा गुरु हमेशा शिष्य को आगे बढ़ने के लिए प्रेरित करता है, वह उसे छोटे सुखों (स्वर्ग) पर रुकने नहीं देता।
            यह श्लोक एक ट्रांजिशन (Transition) है—यहाँ से कथा कर्मकांड से हटकर शुद्ध वेदान्त (आत्मज्ञान) की ओर मुड़ती है।
            अब नचिकेता वह प्रश्न पूछेगा जिसने हजारों सालों से दार्शनिकों और विज्ञानियों की नींद उड़ा रखी है।
        """.trimIndent(),
        english = """
            (Yama says): O Nachiketa! This is that heaven-granting Fire-knowledge which you specifically chose as your second boon.
            From this day forth, all people (Janasah) will call and know this great fire solely by your name (Nachiketa Fire).
            Now two of your boons are completely fulfilled; therefore, O Nachiketa! Now ask for your 'third boon' (Vrinishva).
            Here Yama has completely concluded the entire chapter regarding physical and worldly knowledge (heaven).
            Nachiketa has perfectly proven that he is an exceptionally sharp, brilliant, and deeply worthy disciple.
            Yama reminds him that one more boon is still left, which will take this Upanishad to its absolute highest peak.
            Whatever was asked until now was connected to the world (heaven); but the real, ultimate question still remains.
            A true Guru always inspires the disciple to move forward; he never lets him stop at lesser pleasures (heaven).
            This verse acts as a direct transition—from here, the story shifts completely from rituals to pure Vedanta (Self-knowledge).
            Now Nachiketa will ask that ultimate question which has kept philosophers and scientists awake for thousands of years.
        """.trimIndent()
    ),

    KathaShloka(
        id = 20,
        sanskrit = "येयं प्रेते विचिकित्सा मनुष्येऽस्तीत्येके नायमस्तीति चैके । एतद्विद्यामनुशिष्टस्त्वयाहं वराणामेष वरस्तृतीयः ॥ २० ॥",
        hindi = """
            (नचिकेता अपना तीसरा वरदान मांगता है): मनुष्य के मर जाने (प्रेत हो जाने) पर यह जो बहुत बड़ा संदेह (विचिकित्सा) बना रहता है।
            कुछ लोग कहते हैं कि मृत्यु के बाद भी आत्मा 'अस्तित्व में रहती है' (अस्ति), और कुछ कहते हैं कि मृत्यु के बाद 'कुछ नहीं बचता' (नायम् अस्ति)।
            मैं आपके द्वारा भलीभांति उपदेशित होकर (अनुशिष्टः) इस परम रहस्य को पूरी तरह से जानना चाहता हूँ।
            हे यमराज! मेरे तीनों वरदानों में से यही मेरा अंतिम और 'तीसरा वरदान' है; कृपया मुझे आत्मज्ञान दीजिए।
            यह उपनिषदों का सबसे प्रसिद्ध और सीधा सवाल है: क्या मौत के बाद कुछ बचता है, या सब राख हो जाता है?
            मटेरियलिस्ट (Materialists/चार्वाक) कहते हैं कि शरीर के जलने के साथ सब कुछ खत्म हो जाता है।
            आस्तिक कहते हैं कि आत्मा हमेशा रहती है; नचिकेता इस कन्फ्यूजन (विचिकित्सा) को हमेशा के लिए मिटाना चाहता है।
            उसने यह सवाल यमराज से ही क्यों पूछा? क्योंकि मृत्यु के बाद क्या होता है, यह मृत्यु के देवता से बेहतर और कौन जान सकता है!
            नचिकेता कोई किताबी जवाब नहीं चाहता; वह 'डायरेक्ट ऑथोरिटी' (Direct Authority) से परम सत्य का साक्षात् ज्ञान चाहता है।
            यह तीसरा वरदान ही कठोपनिषद का हृदय है; इसके बाद का पूरा उपनिषद केवल इसी एक सवाल का महा-उत्तर है।
        """.trimIndent(),
        english = """
            (Nachiketa asks his third boon): When a human being dies (departs), there is this immense, lingering doubt (Vichikitsa).
            Some firmly say that the soul 'continues to exist' (Asti) after death, while others claim that 'nothing remains' (Nayam Asti).
            Being perfectly instructed and taught directly by You, I wish to know and understand this ultimate mystery completely.
            O Lord Yama! Out of my three boons, this is my final and 'third boon'; please grant me this Self-knowledge.
            This is the most famous and direct question of the Upanishads: Does anything survive after death, or is everything reduced to ashes?
            Materialists (Charvakas) argue that everything absolutely ends the moment the physical body is burnt.
            Theists argue that the soul is eternal; Nachiketa wants to permanently eradicate this massive confusion (Vichikitsa).
            Why did he ask Yama? Because who else could possibly know what happens after death better than the God of Death Himself!
            Nachiketa doesn't want a textbook answer; he demands the absolute truth straight from the 'Direct Authority'.
            This third boon is the very beating heart of the Katha Upanishad; the entire rest of the text is the grand answer to this single question.
        """.trimIndent()
    ),
    KathaShloka(
        id = 21,
        sanskrit = "देवैरत्रापि विचिकित्सितं पुरा न हि सुज्ञेयमणुरेष धर्मः । अन्यं वरं नचिकेतो वृणीष्व मा मोपरोत्सीरति मा सृजैनम् ॥ २१ ॥",
        hindi = """
            (यमराज यह गहरा प्रश्न सुनकर नचिकेता की परीक्षा लेते हैं): हे नचिकेता! इस विषय में प्राचीन काल में देवताओं को भी बहुत संदेह (विचिकित्सा) हुआ था।
            यह विषय (आत्मा का रहस्य) आसानी से समझ में आने वाला नहीं है (न हि सुज्ञेयम्), क्योंकि यह अत्यंत ही सूक्ष्म (अणु) धर्म है।
            इसलिए हे नचिकेता! तुम इस प्रश्न को छोड़ दो और इसकी जगह कोई 'अन्य वरदान' (दूसरा सुख) मुझसे मांग लो।
            तुम मुझे इस गहरे रहस्य को बताने के लिए बिल्कुल भी मजबूर मत करो (मा मोपरोत्सीः); तुम इस वरदान को यहीं छोड़ दो।
            सच्चा ज्ञान इतनी आसानी से नहीं दिया जाता; गुरु पहले यह परखता है कि शिष्य इसके लिए सच में योग्य है या नहीं।
            यमराज उसे डरा रहे हैं कि जब बड़े-बड़े देवता इस रहस्य को नहीं समझ पाए, तो तुम एक छोटे से बालक होकर कैसे समझोगे?
            आत्मा का ज्ञान 'अणु' (सूक्ष्म) है—इसे किसी प्रयोगशाला में देखा या सिद्ध नहीं किया जा सकता।
            यह कोई साधारण विद्या नहीं है जिसे रट लिया जाए; यह तो चेतना के सबसे गहरे स्तर पर अनुभव करने की चीज़ है।
            यमराज उसे प्रलोभन (Temptation) देकर देखना चाहते हैं कि क्या नचिकेता सत्य से ज्यादा सुख को पसंद करता है।
            यह श्लोक गुरु द्वारा ली जाने वाली उस अत्यंत कठोर 'प्रवेश परीक्षा' (Entrance Test) का हिस्सा है।
        """.trimIndent(),
        english = """
            (Hearing this profound question, Yama tests Nachiketa): O Nachiketa! In ancient times, even the gods had great doubts (Vichikitsa) regarding this matter.
            This subject (the secret of the soul) is absolutely not easy to understand (Na hi sujneyam), because it is an exceedingly subtle (Anu) principle.
            Therefore, O Nachiketa! Please drop this particular question and choose some 'other boon' (any other worldly pleasure) from me instead.
            Do not press or compel me to reveal this profound mystery (Ma moparotsih); please give up and release me from this specific boon.
            True supreme wisdom is never imparted so easily; the Guru first rigorously tests whether the disciple is truly qualified for it or not.
            Yama is intimidating him, implying that when even great gods couldn't grasp this secret, how will you, a mere little boy, understand it?
            The knowledge of the soul is 'Anu' (subtle)—it cannot be seen, measured, or proved in any physical laboratory.
            It is not ordinary information to be memorized; it is a reality to be experienced at the deepest possible level of consciousness.
            Yama wants to tempt him to see if Nachiketa prefers worldly happiness over the absolute, uncompromising Truth.
            This verse is the beginning of that extremely tough 'Entrance Test' conducted directly by the ultimate Guru.
        """.trimIndent()
    ),
    KathaShloka(
        id = 22,
        sanskrit = "देवैरत्रापि विचिकित्सितं किल त्वं च मृत्यो यन्न सुज्ञेयमात्थ । वक्ता चास्य त्वादृगन्यो न लभ्यो नान्यो वरस्तुल्य एतस्य कश्चित् ॥ २२ ॥",
        hindi = """
            (नचिकेता पूरी दृढ़ता से यमराज को उत्तर देता है): हे मृत्युदेव! आपने खुद कहा कि देवताओं को भी इस विषय में गहरा संदेह था।
            और आप स्वयं यह कह रहे हैं कि इस आत्मतत्त्व को जानना बिल्कुल भी आसान (सुज्ञेय) नहीं है।
            यही तो सबसे बड़ा कारण है कि मुझे यही जानना है! और इस परम सत्य का उपदेश देने वाला आपके जैसा (त्वादृग्) दूसरा कोई श्रेष्ठ वक्ता मुझे मिल भी नहीं सकता।
            इसलिए मेरे लिए इस आत्मज्ञान के वरदान के समान (तुल्य) संसार का कोई भी दूसरा वरदान बिल्कुल भी नहीं है।
            नचिकेता की बुद्धि कितनी तेज है! उसने यमराज की बात को ही अपना हथियार बना लिया।
            उसने कहा: जब यह ज्ञान इतना दुर्लभ है कि देवता भी इसे नहीं जानते, तो फिर यह ज्ञान तो सबसे कीमती हुआ ना?
            और जब आप मृत्यु के स्वयं अधिपति हैं, तो आपसे बेहतर टीचर (वक्ता) पूरे ब्रह्मांड में कौन हो सकता है?
            नचिकेता ने स्पष्ट कर दिया कि उसे सोने-चांदी या स्वर्ग के खिलौनों से बहलाया नहीं जा सकता।
            उसके भीतर सत्य को जानने की प्यास (मुमुक्षा) इतनी तीव्र है कि वह साक्षात् भगवान के लालच को भी ठुकरा रहा है।
            यह श्लोक एक आदर्श और जिद्दी शिष्य की निडरता को दिखाता है, जो सत्य के अलावा किसी भी चीज़ से समझौता (Compromise) नहीं करता।
        """.trimIndent(),
        english = """
            (Nachiketa replies to Yama with absolute firmness): O Lord of Death! You yourself admitted that even the gods had deep doubts regarding this.
            And You yourself are saying that this soul-principle is absolutely not easy to understand (Sujneya).
            That is exactly the biggest reason I must know it! And I can never find a more excellent teacher (speaker) to explain this Supreme Truth than You.
            Therefore, for me, there is absolutely no other boon in the entire universe that is equal (Tulya) to this boon of Self-knowledge.
            How incredibly sharp Nachiketa's intellect is! He brilliantly turned Yama's own argument into his strongest weapon.
            He reasoned: if this wisdom is so extremely rare that even gods don't know it, then it must be the most precious thing of all, right?
            And since You are the very Lord of Death Himself, who in the entire cosmos could possibly be a better teacher (Vakta) than You?
            Nachiketa made it crystal clear that he cannot be distracted or bought with toys of gold, silver, or heavenly pleasures.
            His thirst for Truth (Mumuksha) is so intense that he is outright rejecting the heavy temptations offered directly by God.
            This verse showcases the fearlessness of an ideal, stubborn disciple who absolutely refuses to compromise on anything less than the Truth.
        """.trimIndent()
    ),
    KathaShloka(
        id = 23,
        sanskrit = "शतायुषः पुत्रपौत्रान्वृणीष्व बहून्पशून् हस्तिहिरण्यमश्वान् । भूमेर्महदायतनं वृणीष्व स्वयं च जीव शरदो यावदिच्छसि ॥ २३ ॥",
        hindi = """
            (यमराज नचिकेता को संसार का सबसे बड़ा लालच देते हैं): हे नचिकेता! तुम सौ-सौ वर्ष (शतायुष) तक जीने वाले पुत्र और पौत्र (पोते) मांग लो।
            तुम बहुत सारे पशु, सुंदर हाथी, अपार सोना (हिरण्य) और दौड़ने वाले शानदार घोड़े मांग लो।
            तुम इस पूरी पृथ्वी का एक बहुत बड़ा और विशाल साम्राज्य (महदायतनं) मुझसे मांग लो।
            और तुम स्वयं जितने साल (शरद ऋतु) तक इस धरती पर जीवित रहना चाहो, उतनी लंबी उम्र मुझसे मांग लो (पर यह आत्मा का रहस्य मत पूछो)।
            यमराज ने यहाँ इंसान की सबसे बड़ी कमजोरियों (Weaknesses) पर सीधा प्रहार किया है।
            इंसान क्या चाहता है? लंबा जीवन, बच्चों का सुख, बेशुमार दौलत, गाड़ियां (हाथी/घोड़े) और सत्ता (साम्राज्य)।
            यमराज ये सब कुछ नचिकेता को एक ही थाली में सजाकर मुफ्त में दे रहे हैं।
            यह कोई साधारण परीक्षा नहीं है; यह माया का वह सबसे बड़ा जाल है जिसमें अच्छे-अच्छे ऋषि-मुनि भी फँस जाते हैं।
            यमराज कह रहे हैं कि तुम 'अनंत काल' (Eternity) की बात छोड़ो और इस दुनिया का 'पूरा मजा' ले लो।
            यह श्लोक बताता है कि आत्मज्ञान का रास्ता फूलों की सेज नहीं है; इस रास्ते पर मन को बहकाने वाले हजारों प्रलोभन खड़े हैं।
        """.trimIndent(),
        english = """
            (Yama offers Nachiketa the greatest worldly temptations): O Nachiketa! Ask for sons and grandsons who shall live for a hundred years (Shatayusha).
            Ask for enormous herds of cattle, magnificent elephants, limitless gold (Hiranya), and excellent swift horses.
            Ask for a massive, vast empire and absolute rulership over this entire earth (Mahadayatanam).
            And ask to live yourself for as many autumns (years) as you desire on this earth (but please do not ask the secret of the soul).
            Yama has struck directly at the absolute greatest vulnerabilities and weaknesses of human psychology here.
            What does a human want? A long life, the joy of children, endless wealth, luxury vehicles (elephants/horses), and supreme power.
            Yama is offering all of these to Nachiketa, beautifully decorated on a silver platter, absolutely free of cost.
            This is no ordinary test; it is the ultimate, most deceptive web of Maya wherein even great sages get trapped.
            Yama is essentially saying, "Forget about 'Eternity' and just enjoy the absolute maximum pleasures of this world."
            This verse shows that the path of Self-knowledge is not a bed of roses; thousands of mind-boggling temptations stand in the way.
        """.trimIndent()
    ),
    KathaShloka(
        id = 24,
        sanskrit = "एतत्तुल्यं यदि मन्यसे वरं वृणीष्व वित्तं चिरजीविकां च । महाभूमौ नचिकेतस्त्वमेधि कामानां त्वा कामभाजं करोमि ॥ २४ ॥",
        hindi = """
            (यमराज अपना प्रलोभन बढ़ाते हुए कहते हैं): यदि तुम इस वरदान (धन और साम्राज्य) के बराबर (तुल्य) किसी और सुख को मानते हो।
            तो तुम मुझसे वह असीम धन (वित्त) और कभी न खत्म होने वाला लंबा जीवन (चिरजीविका) भी मांग लो।
            हे नचिकेता! तुम इस विशाल और महान पृथ्वी (महाभूमौ) के एकछत्र सम्राट (राजा) बन जाओ।
            तुम्हारे मन में जो भी इच्छाएं हैं, मैं तुम्हें उन सभी इच्छाओं और कामनाओं को भोगने वाला (कामभाजं) बना देता हूँ।
            यमराज नचिकेता को 'ब्लैंक चेक' (Blank Check) दे रहे हैं: "जो चाहो लिख लो, मैं सब दे दूँगा।"
            दुनिया का हर इंसान अमीर बनना चाहता है और लंबे समय तक जवां रहकर उन पैसों को भोगना चाहता है।
            यमराज उसे राजा बनने का ऑफर दे रहे हैं, ताकि वह बिना किसी रोक-टोक के अपने हर शौक को पूरा कर सके।
            परंतु यहाँ एक बहुत बड़ा पेंच (Catch) है: ये सारे सुख तभी तक हैं जब तक शरीर है।
            यमराज मौत के देवता होकर उसे जीवन का लालच दे रहे हैं; वे जानते हैं कि एक दिन तो यह सब छिन ही जाएगा।
            माया हमें उन चीजों में उलझा देती है जो खत्म होने वाली हैं, ताकि हम उस चीज़ को भूल जाएं जो कभी खत्म नहीं होती (आत्मा)।
        """.trimIndent(),
        english = """
            (Yama, intensifying the temptation, says): If you consider any other pleasure to be absolutely equal (Tulya) to this boon.
            Then ask for that limitless wealth (Vittam) and an endlessly long, everlasting life (Chirajivikam) from me as well.
            O Nachiketa! Become the supreme, undisputed emperor (King) of this vast and magnificent earth (Mahabhumau).
            Whatever desires exist in your mind, I will make you the ultimate enjoyer (Kamabhajam) of all those desires and wishes.
            Yama is essentially handing Nachiketa a 'Blank Check': "Write whatever you want, and I shall grant it all."
            Every human in the world wants to become immensely rich and stay young forever to enjoy that wealth.
            Yama is offering him absolute kingship so he can fulfill his every single hobby and lust without any restriction.
            But there is a massive catch here: all these incredible pleasures last only as long as the physical body lasts.
            The God of Death is tempting him with life; Yama knows perfectly well that one day all of this will definitely be snatched away.
            Maya deliberately entangles us in perishable things, so we completely forget the only thing that never perishes (the Soul).
        """.trimIndent()
    ),
    KathaShloka(
        id = 25,
        sanskrit = "ये ये कामा दुर्लभा मर्त्यलोके सर्वान् कामाँश्छन्दतः प्रार्थयस्व । इमा रामाः सरथाः सतूर्या न हीदृशा लम्भनीया मनुष्यैः । आभिर्मत्प्रत्ताभिः परिचारयस्व नचिकेतो मरणं माऽनुप्राक्षीः ॥ २५ ॥",
        hindi = """
            (यमराज अपना अंतिम और सबसे बड़ा प्रलोभन फेंकते हैं): इस नश्वर मनुष्य लोक (मर्त्यलोक) में जो-जो भी इच्छाएं (सुख) अत्यंत दुर्लभ हैं।
            तुम अपनी इच्छा और पसंद के अनुसार उन सभी दुर्लभ सुखों (रामाः/सुंदर अप्सराओं) को मुझसे मांग लो।
            रथों और मधुर बाजों (तूर्य) के साथ ये जो दिव्य और सुंदर अप्सराएं हैं, ये मनुष्यों को कभी प्राप्त नहीं हो सकतीं (अलम्भनीया)।
            मेरे द्वारा दी गई इन दिव्य अप्सराओं से तुम अपनी सेवा (परिचारयस्व) करवाओ और खूब आनंद लो।
            परंतु हे नचिकेता! तुम मुझसे इस 'मरण' (मृत्यु के बाद आत्मा का क्या होता है) के रहस्य के बारे में बिल्कुल मत पूछो (मा अनुप्राक्षीः)।
            यह यमराज का मास्टरस्ट्रोक (Masterstroke) था; उन्होंने कामवासना (Lust) का सबसे तगड़ा बाण चलाया।
            देवलोक की अप्सराएं, नाच-गाना, और महलों का सुख—यह ऐसा लालच है जिससे बड़े-बड़े योगियों का ध्यान भंग हो जाता है।
            यमराज कह रहे हैं कि जो सुख इंसानों के लिए नामुमकिन हैं, वे मैं तुम्हें अभी इसी वक्त दे रहा हूँ।
            बस एक ही शर्त है: "मुझसे सत्य मत मांगो, मुझसे भ्रम (Illusion) मांग लो।"
            यह श्लोक साबित करता है कि सत्य का ज्ञान दुनिया की सबसे महँगी चीज़ है; इसके लिए इंसान को पूरी दुनिया की दौलत और सुख को ठोकर मारनी पड़ती है।
        """.trimIndent(),
        english = """
            (Yama throws his final and greatest temptation): Whatever desires and pleasures are exceedingly rare and difficult to attain in this mortal world.
            Ask freely for all those rare pleasures and beautiful celestial maidens (Ramah) according to your own free will.
            These beautiful celestial nymphs with their divine chariots and melodious musical instruments are completely unattainable by mortal men.
            Be served (Paricharayatsva) by these divine maidens granted by me, and enjoy the absolute peak of pleasure.
            But O Nachiketa! Please, absolutely do not ask me (Ma anuprakshih) about the profound secret of this 'Death' (what happens after death).
            This was Yama's absolute masterstroke; He fired the most powerful arrow of extreme sensual lust (Kamavasana).
            Heavenly nymphs, music, and luxurious palaces—this is a temptation that shatters the focus of even the greatest yogis.
            Yama is saying that the pleasures which are completely impossible for humans, I am giving to you right now.
            There is only one strict condition: "Do not ask me for the Truth; ask me for the beautiful illusion instead."
            This verse undeniably proves that the knowledge of Truth is the most expensive thing in existence; to attain it, one must totally kick away the wealth and pleasures of the entire world.
        """.trimIndent()
    ),// ... Continuing kathaShlokasList from ID 26

    KathaShloka(
        id = 26,
        sanskrit = "श्वोभावा मर्त्यस्य यदन्तकैतत्सर्वेन्द्रियाणां जरयन्ति तेजः । अपि सर्वं जीवितमल्पमेव तवैव वाहास्तव नृत्यगीते ॥ २६ ॥",
        hindi = """
            (नचिकेता यमराज के प्रलोभनों को ठुकराते हुए कहता है): हे मृत्युदेव! ये सभी सांसारिक सुख केवल कल तक (श्वोभावा) रहने वाले हैं।
            ये भोग और विलास मनुष्य की सभी इंद्रियों के तेज (ऊर्जा और शक्ति) को बहुत जल्दी नष्ट (जरयन्ति) कर देते हैं।
            आपने मुझे जो अत्यंत लंबी आयु का लालच दिया है, वह असीम समय (अनंत काल) के आगे बहुत ही अल्प (छोटी) है।
            मनुष्य का जीवन चाहे कितना भी लंबा हो, मृत्यु के सामने वह केवल एक क्षण के समान ही है।
            इसलिए हे यमराज! आपके ये सुंदर घोड़े, रथ, अप्सराएं और उनके नाच-गाने (नृत्यगीते) आपके ही पास रहें।
            मुझे इन नश्वर और नाशवान सुखों में कोई भी रुचि या लालच बिल्कुल भी नहीं है।
            नचिकेता की यह अत्यंत तीक्ष्ण वैराग्य-भावना है, जो माया के सबसे आकर्षक जाल को भी एक झटके में काट देती है।
            वह समझ गया है कि इंद्रियों का सुख शुरू में मीठा लगता है, पर अंत में वह शरीर और मन को खोखला कर देता है।
            सच्चा योगी वही है जो भविष्य के दुखों को वर्तमान में ही देख लेता है और झूठे सुखों को तुरंत ठुकरा देता है।
            यहाँ नचिकेता ने साबित कर दिया कि वह आत्मज्ञान का सबसे सच्चा और योग्य अधिकारी (Qualified student) है।
        """.trimIndent(),
        english = """
            (Nachiketa rejecting Yama's temptations): O Lord of Death! All these worldly pleasures are fleeting and last only until tomorrow.
            These sensual enjoyments rapidly exhaust and wear out the vigor (Tejas) of all human senses and organs.
            Even the incredibly long lifespan you have offered me is extremely brief and insignificant compared to eternity.
            No matter how long a human's life may be, it is ultimately just a passing moment in the face of inevitable death.
            Therefore, O Yama! Keep Your magnificent horses, chariots, celestial maidens, and their dances and songs to Yourself.
            I possess absolutely no interest, greed, or desire for these highly perishable and destructive mortal pleasures.
            This reveals Nachiketa's razor-sharp dispassion (Vairagya), effortlessly cutting through the most alluring web of Maya.
            He understands perfectly that sensual pleasure tastes sweet initially, but ultimately leaves the body and mind hollow.
            A true Yogi is one who foresees future suffering in the present moment and instantly rejects false, temporary joys.
            Here, Nachiketa decisively proves that he is the most genuine and highly qualified recipient for ultimate Self-knowledge.
        """.trimIndent()
    ),
    KathaShloka(
        id = 27,
        sanskrit = "न वित्तेन तर्पणीयो मनुष्यो लप्स्यामहे वित्तमद्राक्ष्म चेत्त्वा । जीविष्यामो यावदीशिष्यसि त्वं वरस्तु मे वरणीयः स एव ॥ २७ ॥",
        hindi = """
            (नचिकेता आगे कहता है): हे यमराज! दुनिया का कोई भी मनुष्य कभी भी केवल 'धन' (वित्त) से तृप्त या संतुष्ट नहीं हो सकता।
            और जब मैंने साक्षात् आपके (मृत्यु के देवता के) दर्शन कर लिए हैं, तो मुझे धन तो अपने-आप ही मिल जाएगा।
            तथा जब तक आप इस ब्रह्मांड पर शासन कर रहे हैं, तब तक हम जीवित भी रहेंगे ही (आयु भी आपके ही हाथ में है)।
            इसलिए आयु और धन मांगना व्यर्थ है; मेरे लिए तो केवल वही तीसरा वरदान (आत्मज्ञान) ही मांगने योग्य है।
            यह मानव मनोविज्ञान (Human Psychology) का एक बहुत बड़ा और कड़वा सच है जिसे नचिकेता ने उजागर किया है।
            दुनिया का सारा सोना मिलकर भी इंसान की मानसिक भूख को शांत नहीं कर सकता; इच्छाएं हमेशा बढ़ती ही जाती हैं।
            नचिकेता का तर्क अचूक है: "जब मौत के देवता मुझ पर मेहरबान हैं, तो भौतिक सुख तो मेरे चरणों में गिरे ही रहेंगे।"
            "पर मौत के बाद क्या होता है, यह ज्ञान मुझे आपके अलावा पूरी दुनिया में कोई नहीं दे सकता।"
            उसने स्पष्ट कर दिया कि जो चीज़ पैसे से खरीदी जा सकती है, वह अमर आत्मा के ज्ञान के सामने मिट्टी के समान है।
            सच्चा मुमुक्षु (Seeker) अपने लक्ष्य पर इतना केंद्रित होता है कि भगवान का लालच भी उसे डिगा नहीं सकता।
        """.trimIndent(),
        english = """
            (Nachiketa continues): O Lord Yama! No human being in this world can ever be truly satisfied or fulfilled merely by 'wealth'.
            And since I have directly beheld You (the God of Death) in person, wealth will automatically come to me anyway.
            Also, as long as You are ruling over this cosmos, we shall undoubtedly continue to live (lifespan is in Your hands).
            Therefore, asking for wealth and long life is futile; for me, only that third boon (Self-knowledge) is truly worth asking.
            This is a profound and bitter truth of human psychology that young Nachiketa exposes here with absolute clarity.
            All the gold in the world combined cannot extinguish human mental hunger; desires simply keep multiplying endlessly.
            Nachiketa's logic is flawless: "When the God of Death is pleased with me, worldly comforts will naturally fall at my feet."
            "But the supreme knowledge of what happens after death can be given to me by no one else in the universe but You."
            He made it crystal clear that anything that can be bought with money is mere dirt compared to the knowledge of the immortal soul.
            A true seeker is so intensely laser-focused on his ultimate goal that even God's temptations cannot shake him.
        """.trimIndent()
    ),
    KathaShloka(
        id = 28,
        sanskrit = "अजीर्यताममृतानामुपेत्य जीर्यन्मर्त्यः क्वधःस्थः प्रजानन् । अभिध्यायन् वर्णरतिप्रमोदान् अतिदीर्घे जीविते को रमेत ॥ २८ ॥",
        hindi = """
            जो मरणशील मनुष्य नीचे पृथ्वी पर रहता है, यदि वह कभी अमर और अजर देवताओं के समीप (उनके लोक में) पहुँच जाए।
            और वह यह अच्छी तरह से जान ले (प्रजानन्) कि उन देवताओं का ज्ञान और आनंद कितना ऊँचा और श्रेष्ठ है।
            तो फिर वह मनुष्य सुंदर अप्सराओं के रूप (वर्ण), उनके प्रेम (रति) और कामवासना के सुखों का चिंतन करते हुए।
            एक अत्यंत लंबे और तुच्छ भौतिक जीवन (अतिदीर्घे जीविते) में कैसे खुश रह सकता है या उसमें कैसे रम सकता है?
            नचिकेता कहता है कि जिसे एक बार असली और स्थायी (Permanent) सुख की झलक मिल जाए, वह नकली सुखों में नहीं फँसता।
            इंसान भौतिक सुखों के पीछे तब तक भागता है जब तक उसे आत्मा के गहरे आनंद का पता नहीं होता।
            अप्सराओं का नाच-गाना और कामवासना केवल शरीर की भूख है, यह आत्मा की प्यास कभी नहीं बुझा सकती।
            सौ या हजार साल की जिंदगी भी अगर अज्ञान और कामवासना में बीते, तो वह एक जानवर की जिंदगी से बेहतर नहीं है।
            नचिकेता ने यहाँ लंबी उम्र (Immortality of body) के लालच को सिरे से खारिज कर दिया।
            वह चाहता है 'चेतना की अमरता', जो समय के पार है और जिसे कोई बीमारी या बुढ़ापा नहीं छू सकता।
        """.trimIndent(),
        english = """
            If a mortal human dwelling on the earth below ever approaches the presence of the immortal and ageless gods.
            And if he thoroughly understands and realizes how vastly superior the wisdom and bliss of those divine beings truly are.
            Then how could such a human, contemplating the physical beauty (Varna) and lustful pleasures (Rati) of celestial nymphs.
            Ever find joy or delight in an excessively long but ultimately trivial physical existence (life)?
            Nachiketa argues that one who has caught even a glimpse of real, permanent bliss can never be trapped by fake, fleeting joys.
            Humans chase after physical pleasures only as long as they are completely unaware of the profound joy of the Soul.
            The dances of nymphs and sensual lust are merely the hungers of the body; they can never quench the deep thirst of the spirit.
            Even a life of a hundred or a thousand years, if spent purely in ignorance and lust, is no better than an animal's life.
            Nachiketa has completely and outrightly rejected the grand temptation of a massively long physical lifespan here.
            He intensely desires the 'Immortality of Consciousness', which is beyond time and completely untouched by disease or old age.
        """.trimIndent()
    ),
    KathaShloka(
        id = 29,
        sanskrit = "यस्मिन्निदं विचिकित्सन्ति मृत्यो यत्साम्पराये महति ब्रूहि नस्तत् । योऽयं वरो गूढमनुप्रविष्टो नान्यं तस्मान्नचिकेता वृणीते ॥ २९ ॥",
        hindi = """
            (नचिकेता अपनी अंतिम बात कहता है): हे मृत्युदेव! परलोक (मरने के बाद की स्थिति) के इस महान विषय में।
            लोगों के मन में जो यह बड़ा संदेह (विचिकित्सा) है, आप कृपा करके मुझे केवल उसी महान सत्य का उपदेश दीजिए।
            यह जो मेरा वरदान है, जो अत्यंत गूढ़ (रहस्यमयी) है और गहराइयों में छिपा हुआ है।
            यह नचिकेता इस आत्मज्ञान वाले वरदान को छोड़कर आपसे अन्य कोई भी दूसरा वरदान बिल्कुल नहीं मांगेगा।
            यहाँ कठोपनिषद का पहला अध्याय (प्रथम वल्ली) अपनी चरम सीमा (Climax) पर पहुँचकर समाप्त होता है।
            नचिकेता चट्टान की तरह अपनी जगह पर खड़ा है; यमराज के सारे हथियार (लालच) उस पर बेअसर हो गए हैं।
            यह एक घोषणा है कि सत्य के प्यासे को दुनिया की कोई भी ताकत खरीद नहीं सकती।
            'गूढमनुप्रविष्टो' का अर्थ है कि यह ज्ञान साधारण बुद्धि की पहुँच से बाहर है; यह सबसे गहरा रहस्य है।
            यमराज अब समझ चुके हैं कि यह लड़का कोई साधारण बालक नहीं, बल्कि धरती का सबसे श्रेष्ठ साधक है।
            जब शिष्य पूरी तरह से खाली और तैयार हो जाता है, तभी गुरु ज्ञान का अमृत उँडेलता है; अब वह समय आ गया है।
        """.trimIndent(),
        english = """
            (Nachiketa gives his final word): O Lord of Death! Regarding this great subject of the afterlife (the state after death).
            Please instruct me exclusively on that supreme truth about which people have this massive, lingering doubt (Vichikitsa).
            This specific boon of mine, which is exceptionally profound (Gudha) and deeply hidden in the greatest mystery.
            This Nachiketa will absolutely not ask for any other boon from You except this profound boon of Self-knowledge.
            Here, the first chapter (First Valli) of the Katha Upanishad reaches its absolute climax and concludes.
            Nachiketa stands his ground like an unshakeable rock; all the weapons (temptations) of Yama have failed completely.
            This is a thunderous declaration that a true seeker deeply thirsty for Truth cannot be bought by any power in the world.
            'Gudhamanupravishtho' means this wisdom is far beyond the reach of ordinary intellect; it is the deepest secret.
            Yama has now perfectly understood that this is no ordinary boy, but the most exceptionally qualified seeker on earth.
            Only when the disciple is completely empty and ready does the Guru pour the nectar of wisdom; that moment has now arrived.
        """.trimIndent()
    ),
    KathaShloka(
        id = 30,
        sanskrit = "अन्यच्छ्रेयोऽन्यदुतैव प्रेयस्ते उभे नानार्थे पुरुषँ सिनीतः । तयोः श्रेय आददानस्य साधु भवति हीयतेऽर्थाद्य उ प्रेयो वृणीते ॥ १ ॥",
        hindi = """
            (द्वितीय वल्ली प्रारंभ - यमराज उपदेश देते हैं): हे नचिकेता! 'श्रेय' (कल्याणकारी/सत्य का मार्ग) बिल्कुल अलग है।
            और 'प्रेय' (प्रिय लगने वाला/सांसारिक सुख का मार्ग) भी बिल्कुल अलग है; ये दोनों रास्ते एक नहीं हैं।
            ये दोनों ही मार्ग अलग-अलग उद्देश्य (लक्ष्य) लेकर मनुष्य को अपनी-अपनी ओर बाँधते हैं।
            इन दोनों में से जो मनुष्य 'श्रेय' (कल्याण के मार्ग) को अपनाता है, उसका हमेशा भला (साधु) होता है।
            किंतु जो मूर्ख मनुष्य 'प्रेय' (तत्काल सुख) को चुनता है, वह अपने जीवन के असली लक्ष्य (मोक्ष) से नीचे गिर जाता है।
            यमराज ने अपनी शिक्षा की शुरुआत इंसान की सबसे बड़ी दुविधा (Dilemma) से की है।
            जीवन में हर दिन हमें दो रास्तों में से एक चुनना पड़ता है: 'जो सही है' (श्रेय) और 'जो अच्छा लगता है' (प्रेय)।
            सत्य का रास्ता शुरू में कड़वा और कठिन लगता है, पर अंत में यह हमें हमेशा के लिए आज़ाद कर देता है।
            सुख का रास्ता (प्रेय) शुरू में बहुत मीठा लगता है, पर अंत में यह हमें बीमारियों और चिंताओं का गुलाम बना देता है।
            नचिकेता ने 'प्रेय' के रूप में अप्सराओं और साम्राज्य को ठुकराकर 'श्रेय' को चुना था, इसलिए यमराज उसकी तारीफ कर रहे हैं।
        """.trimIndent(),
        english = """
            (Beginning of Valli 2 - Yama teaches): O Nachiketa! The path of 'Shreya' (the Good/beneficial/Truth) is entirely different.
            And the path of 'Preya' (the Pleasant/worldly joy) is also completely different; these two paths are not the same.
            Both these paths bind a human being towards themselves, driving him toward two completely different goals.
            Of these two, the wise person who consciously chooses 'Shreya' (the Good) always attains ultimate welfare and success.
            But the foolish person who chooses 'Preya' (instant pleasure) completely falls away from the true goal of human life.
            Yama begins his profound teaching with the greatest, most fundamental psychological dilemma of human existence.
            Every single day we must choose between two paths: 'what is fundamentally right' (Shreya) and 'what feels good' (Preya).
            The path of Truth tastes bitter and hard at first, but it ultimately liberates us forever in the end.
            The path of pleasure (Preya) tastes very sweet initially, but ultimately enslaves us to diseases and endless anxieties.
            Nachiketa had rejected the 'Preya' (nymphs and empire) and chosen 'Shreya', which is exactly why Yama is praising him.
        """.trimIndent()
    ),
    KathaShloka(
        id = 31,
        sanskrit = "श्रेयश्च प्रेयश्च मनुष्यमेतस्तौ सम्परीत्य विविनक्ति धीरः । श्रेयो हि धीरोऽभिप्रेयसो वृणीते प्रेयो मन्दो योगक्षेमाद्वृणीते ॥ २ ॥",
        hindi = """
            श्रेय (कल्याण) और प्रेय (सुख)—ये दोनों ही मार्ग हर मनुष्य के सामने परीक्षा लेने के लिए आते हैं।
            जो धीर (बुद्धिमान और धैर्यवान) पुरुष है, वह इन दोनों पर गहराई से विचार करता है और इन्हें अलग-अलग करके पहचान लेता है।
            विचार करने के बाद, वह धीर पुरुष उन सांसारिक सुखों (प्रेय) की तुलना में परम कल्याण (श्रेय) को ही चुनता है।
            परंतु जो मंद बुद्धि (अज्ञानी) मनुष्य है, वह अपने शरीर के योग-क्षेम (भौतिक सुरक्षा और सुख) के लालच में प्रेय को चुन लेता है।
            भगवान इंसान को रोबोट नहीं बनाते; वे उसे 'फ्री विल' (Free Will / अपनी मर्जी चुनने का अधिकार) देते हैं।
            हर इंसान को यह तय करना होता है कि उसे आत्मा की शांति चाहिए या शरीर का आराम।
            बुद्धिमान व्यक्ति जानता है कि जो सुख आज मिल रहा है, वह कल खत्म हो जाएगा और दुख में बदल जाएगा।
            इसलिए वह थोड़े से कष्ट सहकर भी उस 'श्रेय' को चुनता है जो कभी खत्म नहीं होता।
            'योग-क्षेम' का अर्थ है जो नहीं है उसे पाना (योग) और जो है उसे बचाकर रखना (क्षेम)—यही सांसारिक भागदौड़ है।
            अज्ञानी इंसान सारी जिंदगी इसी योग-क्षेम में लगा रहता है और मौत उसे एक दिन अचानक आकर उठा ले जाती है।
        """.trimIndent(),
        english = """
            Both Shreya (the Good) and Preya (the Pleasant) constantly approach every human being to rigorously test him.
            The 'Dhira' (wise and patient man) examines both of them deeply, ponders over them, and distinguishes them clearly.
            After deep contemplation, the wise man intentionally chooses the Supreme Good (Shreya) over fleeting worldly pleasures (Preya).
            But the dull-witted (ignorant) man, driven entirely by the greed for bodily comfort and security (Yoga-Kshema), chooses Preya.
            God does not create humans as robots; He grants them the absolute gift of 'Free Will' (the power of choice).
            Every human must constantly decide whether he wants the eternal peace of the soul or the temporary comfort of the body.
            An intelligent person knows perfectly well that the pleasure obtained today will vanish tomorrow and turn into sorrow.
            Therefore, even if it requires enduring some hardship, he strictly chooses that 'Shreya' which never perishes.
            'Yoga-Kshema' means acquiring what one lacks (Yoga) and protecting what one has (Kshema)—this is the worldly rat race.
            An ignorant man spends his entire life in this endless cycle, and one day death suddenly comes and snatches him away.
        """.trimIndent()
    ),
    KathaShloka(
        id = 32,
        sanskrit = "स त्वं प्रियान् प्रियरूपान्श्च कामानभिध्यायन्नचिकेतोऽत्यस्राक्षीः । नैताँ सृङ्कां वित्तमयीमवाप्तो यस्यां मज्जन्ति बहवो मनुष्याः ॥ ३ ॥",
        hindi = """
            (यमराज नचिकेता की प्रशंसा करते हैं): हे नचिकेता! तुमने उन सभी प्रिय लगने वाले सुखों (पुत्र, धन आदि) पर गहराई से विचार किया।
            और अत्यंत सुंदर दिखने वाली अप्सराओं और कामनाओं के खोखलेपन को समझकर तुमने उन्हें पूरी तरह से त्याग (अत्यस्राक्षीः) दिया।
            तुमने धन और रत्नों से भरी हुई इस सांसारिक मार्ग (सृङ्कां) को बिल्कुल भी स्वीकार नहीं किया।
            जिस धन-दौलत और वासनाओं की कीचड़ में दुनिया के बहुत सारे (ज्यादातर) मनुष्य डूब कर नष्ट हो जाते हैं।
            यह गुरु द्वारा शिष्य को दिया गया सबसे बड़ा सम्मान (Certificate of purity) है।
            यमराज कह रहे हैं कि तुमने बिना सोचे-समझे सुखों को नहीं छोड़ा; तुमने 'अभिध्यायन्' (गहराई से सोचकर) उन्हें छोड़ा।
            अंधा होकर सुख छोड़ना मूर्खता है, पर उसकी हकीकत (Reality) देखकर उसे छोड़ना सच्चा वैराग्य है।
            पूरी दुनिया पैसे और शरीर के पीछे अंधी होकर भाग रही है; वे इस मोह के दलदल (Mud) में डूब रहे हैं।
            नचिकेता उन करोड़ों में से एक है जिसने इस दलदल को दूर से ही पहचान लिया और उसमें पैर नहीं रखा।
            ज्ञान हमेशा ऐसे ही साफ और वैराग्यवान (Detached) हृदय में उतरता है।
        """.trimIndent(),
        english = """
            (Yama praises Nachiketa): O Nachiketa! You deeply pondered over all those pleasant-seeming joys (sons, wealth, etc.).
            And realizing the ultimate hollowness of those beautiful celestial nymphs and desires, you rejected and abandoned them completely.
            You absolutely refused to accept this worldly chain (path) made entirely of wealth, gold, and extreme luxury.
            The very mud of wealth and lust in which the vast majority of human beings completely sink and perish.
            This is the highest honor and the ultimate 'Certificate of Purity' granted by the Guru to the disciple.
            Yama states that you didn't just reject pleasures blindly; you rejected them after 'Abhidhyayan' (deep and profound contemplation).
            Abandoning joy blindly is foolishness, but dropping it after seeing its temporary reality is true detachment (Vairagya).
            The entire world is running blindly after money and physical bodies; they are steadily drowning in this swamp of delusion.
            Nachiketa is one in millions who recognized this dangerous swamp from afar and completely refused to step into it.
            Supreme wisdom only descends into a heart that is so exquisitely clean and perfectly detached.
        """.trimIndent()
    ),
    KathaShloka(
        id = 33,
        sanskrit = "दूरमेते विपरीते विषूची अविद्या या च विद्येति ज्ञाता । विद्याभीप्सिनं नचिकेतसं मन्ये न त्वा कामा बहवोऽलोलुपन्त ॥ ४ ॥",
        hindi = """
            अविद्या (अज्ञान/सांसारिक सुख) और विद्या (ज्ञान/मोक्ष) — ये दोनों एक-दूसरे से बहुत दूर और बिल्कुल विपरीत (Opposite) दिशाओं में ले जाने वाली हैं।
            हे नचिकेता! मैं मानता हूँ कि तुम सच्चे अर्थों में 'विद्या' (आत्मज्ञान) को प्राप्त करने के ही इच्छुक (अभिप्सिनं) हो।
            क्योंकि मैंने तुम्हें जो इतने सारे (बहवो) सुखों और भोगों का लालच दिया था, वे भी तुम्हारे मन को ललचा (लोलुपन्त) नहीं सके।
            विद्या और अविद्या कभी एक साथ नहीं रह सकते; जैसे दिन और रात एक जगह नहीं हो सकते।
            जो इंसान संसार में भी नंबर वन बनना चाहता है और भगवान को भी पाना चाहता है, वह खुद को धोखा दे रहा है।
            अविद्या हमें बाहर (संसार की ओर) खींचती है, जबकि विद्या हमें भीतर (आत्मा की ओर) ले जाती है।
            यमराज ने यह कन्फर्म (Confirm) कर दिया है कि नचिकेता कोई ढोंगी नहीं है; वह सच में सत्य का खोजी है।
            हमारी इच्छाएं (कामा) ही हमारे अज्ञान का थर्मामीटर हैं; जितनी ज्यादा इच्छाएं, उतना बड़ा अज्ञान।
            नचिकेता की सभी भौतिक इच्छाएं शून्य (Zero) हो चुकी हैं, जो यह साबित करता है कि वह ज्ञान का सच्चा अधिकारी है।
            जब वासनाएं मन को नहीं हिला पातीं, तभी मन उस परम सत्य को ग्रहण करने के लायक बनता है।
        """.trimIndent(),
        english = """
            Avidya (Ignorance/worldly path) and Vidya (Wisdom/spiritual path) are miles apart and lead in entirely opposite directions.
            O Nachiketa! I firmly consider you to be a true and genuine seeker strictly desiring only 'Vidya' (Self-knowledge).
            Because even the countless (Bahavo) massive temptations and pleasures I offered could not induce even a trace of greed in you.
            Vidya and Avidya can never coexist; just as bright daylight and pitch darkness can never exist in the exact same place.
            A person who wants to be number one in the material world and also wants to attain God is simply deceiving himself.
            Avidya constantly pulls us outward (towards the world), whereas Vidya guides us completely inward (towards the Soul).
            Yama has officially confirmed here that Nachiketa is not a hypocrite; he is an absolutely authentic seeker of Truth.
            Our worldly desires (Kama) are the thermometer of our ignorance; the more the desires, the greater the ignorance.
            Nachiketa's worldly desires have hit absolute zero, proving beyond doubt that he is highly qualified for cosmic wisdom.
            Only when worldly lusts utterly fail to shake the mind does it become capable of receiving the Supreme Truth.
        """.trimIndent()
    ),
    KathaShloka(
        id = 34,
        sanskrit = "अविद्यायामन्तरे वर्तमानाः स्वयं धीरा पण्डितम्मन्यमानाः । दन्द्रम्यमाणाः परियन्ति मूढा अन्धेनैव नीयमाना यथान्धाः ॥ ५ ॥",
        hindi = """
            जो लोग घोर अज्ञान (अविद्या) के बीच में रहते हैं और पूरी तरह से सांसारिक मोह में फँसे हुए हैं।
            किंतु वे मूर्ख स्वयं को बहुत बुद्धिमान (धीर) और बहुत बड़ा ज्ञानी (पंडित) मानकर अहंकार में चूर रहते हैं।
            वे अज्ञानी (मूढ़) लोग इस संसार चक्र में अनेक प्रकार के दुखों को सहते हुए बार-बार भटकते (दन्द्रम्यमाणाः) रहते हैं।
            उनकी हालत बिल्कुल वैसी ही है जैसे किसी अंधे आदमी का मार्गदर्शन कोई दूसरा अंधा आदमी कर रहा हो।
            यह श्लोक उन नकली गुरुओं और पाखंडी विद्वानों पर एक करारा प्रहार है जो केवल किताबें पढ़कर ज्ञानी बन बैठते हैं।
            डिग्री (Degree) होना या शास्त्रों को रट लेना असली ज्ञान नहीं है; यह तो अहंकार को और बढ़ा देता है।
            जिसका अपना मन पैसों और वासनाओं में फँसा है, वह दूसरों को भगवान तक कैसे पहुँचा सकता है?
            अंधे को अगर अंधा रास्ता दिखाएगा, तो दोनों ही गड्ढे (दुखों के चक्र) में गिरेंगे।
            समाज की सबसे बड़ी त्रासदी यह है कि अज्ञानी लोग ही अक्सर लीडर (Leader) या गुरु बन जाते हैं।
            सच्चा ज्ञान विनम्रता (Humility) लाता है, जबकि अविद्या (Ignorance) इंसान को झूठे घमंड से भर देती है।
        """.trimIndent(),
        english = """
            Those who live completely immersed in the midst of thick ignorance (Avidya) and are entangled in worldly delusion.
            Yet, out of sheer arrogance, those fools consider themselves to be highly intelligent (Dhira) and profoundly learned (Pandit).
            Those deluded fools wander aimlessly in this cycle of existence, repeatedly suffering various miseries and getting battered.
            Their pathetic condition is exactly like that of blind men being led and guided by another blind man.
            This verse is a fierce strike against fake gurus and hypocritical scholars who claim wisdom just by reading books.
            Having a university degree or memorizing scriptures is not true wisdom; it merely inflates the human ego.
            How can someone whose own mind is trapped in money and lust possibly guide others to the Supreme God?
            If a blind man leads another blind man, both will inevitably fall straight into the deep ditch of misery.
            The greatest tragedy of society is that the most ignorant people often become self-appointed leaders and guides.
            True spiritual wisdom always brings profound humility, whereas ignorance inflates a person with completely false pride.
        """.trimIndent()
    ),
    KathaShloka(
        id = 35,
        sanskrit = "न साम्परायः प्रतिभाति बालं प्रमाद्यन्तं वित्तमोहेन मूढम् । अयं लोको नास्ति पर इति मानी पुनः पुनर्वशमापद्यते मे ॥ ६ ॥",
        hindi = """
            परलोक (मृत्यु के बाद का सत्य) क्या है, यह बात उस अज्ञानी बच्चे (बालक/मूर्ख) को बिल्कुल समझ नहीं आती (न प्रतिभाति)।
            जो धन और संपत्ति के मोह (वित्तमोह) में पड़कर पूरी तरह से पागल और असावधान (प्रमाद्यन्तं) हो चुका है।
            वह मूर्ख अहंकार में आकर यह मानता है कि 'केवल यही भौतिक संसार (अयं लोक) सब कुछ है, इसके अलावा दूसरा कोई लोक (ईश्वर/आत्मा) नहीं है।'
            ऐसा घमंड करने वाला वह अज्ञानी मनुष्य बार-बार जन्म लेता है और बार-बार मेरे (यमराज/मृत्यु के) वश में आता रहता है।
            पैसे का नशा इंसान की बुद्धि को पूरी तरह अंधा कर देता है; वह सोचता है कि पैसे से वह मौत को भी खरीद लेगा।
            यमराज ऐसे घमंडी इंसान को 'बालक' (बच्चा) कह रहे हैं, क्योंकि उसकी सोच एक नासमझ बच्चे जितनी ही छोटी है।
            मटेरियलिज्म (भौतिकवाद) का सबसे बड़ा भ्रम यह है कि 'खाओ, पिओ और मौज करो, कल किसने देखा है?'
            परंतु प्रकृति के नियम कठोर हैं; जो इंसान आत्मा को भूलकर केवल शरीर को सजाता है, उसे बार-बार मरने का दुख सहना पड़ता है।
            यमराज स्पष्ट चेतावनी दे रहे हैं कि अज्ञान की सजा भगवान नहीं देते, अज्ञान की सजा 'बार-बार जन्म लेना' (पुनर्जन्म) ही है।
            संसार को ही अंतिम सत्य मान लेना मानव जीवन की सबसे बड़ी और खतरनाक भूल है।
        """.trimIndent(),
        english = """
            What the afterlife (Truth after death) is, never becomes clear or apparent to that ignorant, foolish person (child).
            Who has become completely careless, mad, and deeply deluded by the intense infatuation with wealth (Vittamoha).
            That arrogant fool proudly believes, 'Only this visible material world exists; there is absolutely no other world (God/Soul).'
            Such an egoistic and deeply ignorant person takes birth repeatedly and falls under My (Death's) control over and over again.
            The intoxication of wealth completely blinds human intellect; he foolishly thinks he can even buy off death with money.
            Yama calls such an arrogant person a 'Balaka' (child) because his level of thinking is as petty and immature as a toddler's.
            The greatest illusion of Materialism is the belief: 'Eat, drink, and make merry, for there is no tomorrow.'
            But nature's laws are brutal; the one who forgets the Soul and decorates only the body must endure the pain of repeated deaths.
            Yama gives a stark warning that God doesn't punish ignorance; the punishment for ignorance is the painful cycle of 'rebirth' itself.
            Considering this physical world to be the final and ultimate truth is the greatest, most dangerous blunder of human life.
        """.trimIndent()
    ),
    KathaShloka(
        id = 36,
        sanskrit = "श्रवणायापि बहुभिर्यो न लभ्यः शृण्वन्तोऽपि बहवो यं न विद्युः । आश्चर्यो वक्ता कुशलोऽस्य लब्धाश्चर्यो ज्ञाता कुशलानुशिष्टः ॥ ७ ॥",
        hindi = """
            यह आत्मा का रहस्य इतना सूक्ष्म है कि बहुत से लोगों को तो इसके बारे में सुनने (श्रवण) का अवसर भी नहीं मिल पाता।
            और जो बहुत से लोग इसे सुन भी लेते हैं, वे भी इस गहरे रहस्य को बिल्कुल नहीं समझ पाते (न विद्युः)।
            इस आत्मतत्त्व का उपदेश देने वाला (वक्ता) गुरु बहुत ही आश्चर्यजनक (अत्यंत दुर्लभ) होता है।
            और इस ज्ञान को प्राप्त करने वाला (लब्धा) शिष्य भी अत्यंत कुशल और विरले ही होता है।
            एक योग्य और सिद्ध गुरु के द्वारा सिखाया गया (कुशलानुशिष्टः) वह ज्ञानी शिष्य भी एक महान आश्चर्य ही है।
            सच्चा अध्यात्म बाज़ार में बिकने वाली चीज़ नहीं है; यह किस्मत वालों को ही सुनने को मिलता है।
            आजकल बहुत से लोग गीता और उपनिषद पढ़ते (सुनते) हैं, पर फिर भी उनका अहंकार और दुख कम नहीं होता।
            ऐसा इसलिए है क्योंकि केवल कानों से सुनने से आत्मा का अनुभव नहीं होता; इसके लिए दिल की गहराई चाहिए।
            एक असली गुरु ढूँढना करोड़ों में एक चमत्कार है, और नचिकेता जैसा 'सौ प्रतिशत तैयार' शिष्य मिलना उससे भी बड़ा चमत्कार है।
            जब एक श्रेष्ठ गुरु और एक श्रेष्ठ शिष्य का मिलन होता है, तभी ज्ञान का असली विस्फोट (आश्चर्य) घटित होता है।
        """.trimIndent(),
        english = """
            The secret of this Soul is so profoundly subtle that many people do not even get the opportunity to hear about it.
            And even among the many who do hear about it, the vast majority simply cannot understand it at all (Na vidyuh).
            A Guru who can genuinely expound and teach this Soul-principle is an absolute wonder (exceedingly rare).
            And the disciple who can successfully grasp and attain this wisdom is also exceptionally skilled and incredibly rare.
            Taught by an expert, perfected Guru, the one who actually realizes this Truth is indeed a magnificent marvel.
            True spirituality is not a cheap commodity sold in markets; only the supremely fortunate even get to hear it.
            Nowadays, many people read (hear) the Gita and Upanishads, yet their ego, anger, and sorrows never decrease.
            This is because merely hearing with physical ears does not grant Soul-experience; it requires immense depth of heart.
            Finding an authentic Guru is a one-in-a-million miracle, and finding a '100% ready' disciple like Nachiketa is an even greater miracle.
            Only when a supreme Guru and a supreme disciple unite does the true, miraculous explosion of divine wisdom take place.
        """.trimIndent()
    ),
    KathaShloka(
        id = 37,
        sanskrit = "न नरेणावरेण प्रोक्त एष सुविज्ञेयो बहुधा चिन्त्यमानः । अनन्यप्रोक्ते गतिरत्र नास्त्यणीयान् ह्यतर्क्यमणुप्रमाणात् ॥ ८ ॥",
        hindi = """
            किसी सामान्य या निम्न स्तर (अवर) के मनुष्य द्वारा उपदेश दिए जाने पर इस आत्मा को अच्छी तरह से नहीं समझा जा सकता।
            क्योंकि लोग इस आत्मा के बारे में अपने-अपने छोटे दिमाग से अनेक प्रकार (बहुधा) की कल्पनाएं और चिंतन करते रहते हैं।
            परंतु जब कोई ऐसा गुरु इसका उपदेश देता है जो स्वयं भगवान से अभिन्न (अनन्य) हो चुका है, तब कोई भी संदेह (गति) बाकी नहीं रहता।
            क्योंकि यह आत्मा तर्क और बहस का विषय बिल्कुल नहीं है (अतर्क्यम्); यह परमाणु से भी अत्यधिक सूक्ष्म (अणीयान्) है।
            जो गुरु खुद अज्ञानी है, वह आपको भगवान के बारे में केवल उलझाएगा; वह सत्य का दर्शन नहीं करा सकता।
            आत्मा के बारे में दार्शनिक (Philosophers) बहुत बहस करते हैं—कोई कहता है आत्मा है, कोई कहता है नहीं है।
            परन्तु यह दिमागी कसरत (तर्क) से पकड़ने की चीज़ नहीं है; बुद्धि की सीमा वहीं खत्म हो जाती है जहाँ आत्मा शुरू होती है।
            जब वह गुरु बोलता है जिसने 'मैं ब्रह्म हूँ' (अहं ब्रह्मास्मि) का अनुभव कर लिया है, तो उसके शब्द सीधे शिष्य के दिल में उतरते हैं।
            'अनन्य' गुरु का मतलब है वह जो भगवान और खुद में कोई फर्क नहीं देखता; उसके शब्द साक्षात् वेद बन जाते हैं।
            आत्मा सूक्ष्म से भी सूक्ष्म है, इसलिए इसे केवल ध्यान की गहरी शांति में ही अनुभव किया जा सकता है, शोरगुल में नहीं।
        """.trimIndent(),
        english = """
            When taught by an ordinary or inferior (Avara) human being, this Soul simply cannot be understood properly.
            Because ignorant people continuously speculate and think about this Soul in multiple, conflicting ways (Bahudha).
            But when it is taught by a Guru who has become completely non-different (Ananya) from God, no doubts remain.
            Because this Soul is absolutely not a subject for logic and arguments (Atarkyam); it is infinitely subtler than the sub-atomic.
            A Guru who is himself ignorant will only confuse you about God; he can never grant you the direct vision of Truth.
            Philosophers constantly debate about the soul—some say it exists, some say it doesn't, creating endless confusion.
            But the Soul cannot be grasped by mental gymnastics (logic); the limit of the intellect ends exactly where the Soul begins.
            When a Guru speaks who has fully experienced 'I am Brahman', his words bypass the mind and pierce the disciple's heart directly.
            An 'Ananya' Guru means one who sees absolutely no difference between himself and God; his words become living scriptures.
            The Soul is subtler than the subtlest, so it can only be experienced in the deep silence of meditation, never in noisy debates.
        """.trimIndent()
    ),
    KathaShloka(
        id = 38,
        sanskrit = "नैषा तर्केण मतिरापनेया प्रोक्तान्येनैव सुज्ञानाय प्रेष्ठ । यां त्वमापः सत्यधृतिर्बतासि त्वादृङ् नो भूयान्नचिकेतः प्रष्टा ॥ ९ ॥",
        hindi = """
            (यमराज कहते हैं): हे अत्यंत प्रिय नचिकेता! यह आत्म-बुद्धि (ज्ञान) केवल तर्कों या दिमागी बहसों (तर्केण) से प्राप्त नहीं की जा सकती।
            जब यह ज्ञान किसी 'अन्य' (यानी जो स्वयं ब्रह्म बन चुका हो ऐसे गुरु) के द्वारा दिया जाता है, तभी यह अच्छी तरह समझ में आता है।
            हे नचिकेता! यह अत्यंत खुशी की बात है कि तुमने अपने दृढ़ निश्चय से इस सत्य-ज्ञान को प्राप्त करने की योग्यता पा ली है।
            तुम सत्य के प्रति अत्यंत दृढ़ संकल्प वाले (सत्यधृतिः) हो; हे नचिकेता! तुम्हारे जैसा प्रश्न पूछने वाला (जिज्ञासु) हमें हमेशा मिलता रहे।
            यमराज यहाँ नचिकेता के प्रति अपना अत्यंत गहरा गुरु-प्रेम (प्रेष्ठ) व्यक्त कर रहे हैं।
            दुनिया में बहुत से लोग भगवान के बारे में तर्क करते हैं, पर तर्क करने वाला कभी भगवान को नहीं पा सकता।
            ईश्वर प्रेम और श्रद्धा का विषय है, वकालत या कोर्ट-कचहरी का नहीं।
            नचिकेता की सबसे बड़ी योग्यता उसका 'सत्यधृति' होना है—यानी वह सत्य को जानने के लिए किसी भी हद तक जाने को तैयार है।
            एक सच्चा गुरु हमेशा ऐसे ही शिष्य की तलाश में रहता है जो सोने के खिलौनों की बजाय ज्ञान का हीरा मांगे।
            यहाँ यमराज ने नचिकेता को पूरी तरह से अपना लिया है और अब वे उसे सबसे बड़ा रहस्य बताने जा रहे हैं।
        """.trimIndent(),
        english = """
            (Yama says): O dearest Nachiketa! This supreme understanding of the Soul can never be attained through dry logic or mental debates (Tarkena).
            Only when this wisdom is imparted by 'another' (a realized Guru established in non-duality) can it be perfectly comprehended.
            O Nachiketa! It is a matter of immense joy that you have successfully acquired the absolute qualification to receive this Truth.
            You are a boy of remarkably firm resolve for the Truth (Satyadhritih); O Nachiketa, may we always find a questioner (seeker) exactly like you!
            Here Yama is expressing his exceedingly deep Guru-love (Preshtha) and affection for the young Nachiketa.
            Many people in the world endlessly debate about God, but a debater can never truly attain or experience God.
            God is a subject of profound love, devotion, and faith, not of intellectual advocacy or courtroom arguments.
            Nachiketa's greatest qualification is being 'Satyadhriti'—meaning he is ready to go to any lengths solely to know the Truth.
            A genuine Guru is always intensely searching for a disciple precisely like this, who demands the diamond of wisdom over golden toys.
            Here Yama has completely accepted Nachiketa as His own, and is now going to reveal the ultimate cosmic secret to him.
        """.trimIndent()
    ),
    KathaShloka(
        id = 39,
        sanskrit = "जानाम्यहं शेवधिरित्यनित्यं न ह्यध्रुवैः प्राप्यते हि ध्रुवं तत् । ततो मया नाचिकेतश्चितोऽग्निरनित्यैर्द्रव्यैः प्राप्तवानस्मि नित्यम् ॥ १० ॥",
        hindi = """
            (यमराज अपने अनुभव से बताते हैं): मैं अच्छी तरह जानता हूँ कि यह सांसारिक खजाना (शेवधि/कर्मफल) अनित्य (नाशवान) है।
            क्योंकि उन अनित्य (अस्थायी/अध्रुव) भौतिक साधनों के द्वारा उस नित्य (हमेशा रहने वाले/ध्रुव) परमात्मा को कभी प्राप्त नहीं किया जा सकता।
            यही कारण है कि मैंने इन अनित्य और भौतिक द्रव्यों (साधनों) का उपयोग करके 'नाचिकेत अग्नि' (यज्ञ/ध्यान) का अनुष्ठान किया।
            और उसी के फलस्वरूप मैंने आज यह नित्य और शाश्वत पद (यमराज का पद/ईश्वरीय स्थिति) प्राप्त कर लिया है।
            यमराज कोई पैदाइशी भगवान नहीं थे; वे बता रहे हैं कि उन्होंने भी तपस्या और सही ज्ञान से यह ऊँचा पद पाया है।
            हम सोचते हैं कि पैसे (शेवधि) से हम स्थायी सुख खरीद लेंगे, पर जो खुद मिटने वाला है वह हमें अमरता कैसे दे सकता है?
            मिट्टी से मिट्टी ही मिलेगी, और नाशवान साधनों से केवल नाशवान सुख ही मिलेगा।
            परंतु यदि उन्हीं नाशवान चीज़ों (शरीर, धन, समय) का उपयोग ईश्वर के ध्यान (अग्नि-चयन) में किया जाए, तो चमत्कार होता है।
            योग की यही खूबी है कि वह इस सड़ने वाले शरीर का उपयोग करके हमें न सड़ने वाली आत्मा तक पहुँचा देता है।
            यमराज अपने खुद के जीवन का उदाहरण देकर नचिकेता को कर्म और ज्ञान का सही उपयोग समझा रहे हैं।
        """.trimIndent(),
        english = """
            (Yama shares His own experience): I know perfectly well that this worldly treasure (Shevadhi/fruits of karma) is impermanent (Anitya).
            Because that eternal, permanent Truth (Dhruvam) can absolutely never be attained through impermanent, transient (Adhruva) physical means.
            That is exactly why I meticulously performed the 'Nachiketa Fire' (meditation/sacrifice) using these very impermanent material objects.
            And strictly as a result of that, I have today successfully attained this eternal and everlasting state (the divine position of Yama).
            Yama was not born a God; He reveals that He too attained this exceedingly high status through severe penance and right wisdom.
            We falsely think we can buy permanent happiness with money, but how can something inherently perishable grant us immortality?
            Matter can only yield matter, and perishable tools can only ever provide perishable, temporary pleasures.
            However, if those very same perishable things (body, wealth, time) are utilized for divine meditation (Agni-chayana), a miracle occurs.
            This is the beauty of Yoga—it utilizes this decaying physical body to elevate us directly to the non-decaying immortal Soul.
            By giving the profound example of His own life, Yama is teaching Nachiketa the perfect, practical use of action and wisdom.
        """.trimIndent()
    ),

    KathaShloka(
        id = 40,
        sanskrit = "कामस्याप्तिं जगतः प्रतिष्ठां क्रतोरनन्त्यमभयस्य पारम् । स्तोममहदुरुगायं प्रतिष्ठां दृष्ट्वा धृत्या धीरो नचिकेतोऽत्यस्राक्षीः ॥ ११ ॥",
        hindi = """
            (यमराज नचिकेता की महानता बताते हैं): तुमने सभी इच्छाओं की पूर्णता (कामस्याप्तिं) को और इस जगत के मुख्य आधार (स्वर्ग) को देख लिया।
            तुमने यज्ञों (क्रतु) के अनंत फलों को, निर्भयता की सबसे ऊँची सीमा को, और स्तुति करने योग्य महान महिमा (हिरण्यगर्भ पद) को देख लिया।
            इन सभी महानतम और अत्यंत सुखदायक भौतिक स्थितियों को देखने और प्राप्त करने का अवसर मिलने के बावजूद।
            हे नचिकेता! तुम इतने धीर (बुद्धिमान) हो कि तुमने अपने दृढ़ धैर्य (धृत्या) से इन सबका पूर्ण रूप से त्याग (अत्यस्राक्षीः) कर दिया।
            स्वर्ग या ब्रह्मा का पद (हिरण्यगर्भ) इस ब्रह्मांड का सबसे बड़ा और सबसे लुभावना पद है।
            वहाँ इंसान की हर इच्छा तुरंत पूरी हो जाती है और वहाँ किसी भी चीज़ का कोई डर (अभयस्य पारम्) नहीं होता।
            यमराज ने नचिकेता को यह सब कुछ एक थाली में सजा कर दिया था, पर नचिकेता ने उसे लात मार दी।
            क्यों? क्योंकि नचिकेता जानता है कि ब्रह्मा का पद भी माया के दायरे में ही आता है, वह अंतिम सत्य (ब्रह्म) नहीं है।
            वैराग्य (Detachment) का यह स्तर इतना ऊँचा है कि देवता भी नचिकेता के सामने बौने नज़र आते हैं।
            जो इंसान भगवान को छोड़कर भगवान की बनाई दुनिया से राजी नहीं होता, भगवान उसी को अपना सबसे बड़ा रहस्य देते हैं।
        """.trimIndent(),
        english = """
            (Yama describes Nachiketa's greatness): You have seen the complete fulfillment of all desires and the foundation of this world (Heaven).
            You have seen the infinite rewards of grand sacrifices, the absolute farthest shore of fearlessness, and the highly adorable great glory (status of Brahma).
            Despite having the direct opportunity to see and acquire all these supreme, immensely joyful material and heavenly states.
            O Nachiketa! You are so exceptionally wise (Dhira) that with your unshakeable patience (Dhriti), you completely rejected and abandoned them all.
            Heaven or the position of Brahma (Hiranyagarbha) is the highest and most extremely lucrative post in this entire cosmos.
            There, every single human desire is instantly fulfilled, and there is absolutely no fear (Abhayasya param) of anything.
            Yama had literally offered all of this to Nachiketa on a silver platter, but Nachiketa fiercely kicked it all away.
            Why? Because Nachiketa knows perfectly well that even Brahma's status falls under Maya; it is not the ultimate Truth (Brahman).
            This level of Vairagya (detachment) is so astoundingly high that even celestial gods appear like dwarfs before young Nachiketa.
            The person who refuses to settle for God's creation and demands only God Himself, receives God's greatest, ultimate secret.
        """.trimIndent()
    ),
    KathaShloka(
        id = 41,
        sanskrit = "तं दुर्दर्शं गूढमनुप्रविष्टं गुहाहितं गह्वरेष्ठं पुराणम् । अध्यात्मयोगाधिगमेन देवं मत्वा धीरो हर्षशोकौ जहाति ॥ १२ ॥",
        hindi = """
            वह परमात्मा अत्यंत दुर्दर्श (जिसे देखना बहुत कठिन है) है, और वह इस माया रूपी संसार में बहुत गहराई तक छिपा (गूढ़) हुआ है।
            वह बुद्धि रूपी गुफा (गुहाहितं) में स्थित है, और इस शरीर रूपी घने जंगल (गह्वर) में निवास करने वाला सबसे प्राचीन (पुराण) देव है।
            उस परम देव को 'अध्यात्म-योग' (अपने चित्त को बाहरी दुनिया से हटाकर भीतर आत्मा में लगाने की प्रक्रिया) के अभ्यास द्वारा।
            जानकर और अनुभव करके, बुद्धिमान (धीर) मनुष्य हर्ष (खुशी) और शोक (दुख) दोनों को हमेशा के लिए छोड़ (जहाति) देता है।
            ईश्वर हमारी आँखों के सामने नहीं खड़ा होता, क्योंकि वह हमारी ही 'देखने की शक्ति' (Consciousness) है।
            वह हमारे दिमाग (गुहा) और इस उलझे हुए शरीर (गह्वर) के बिल्कुल बीचोबीच बैठा है, पर फिर भी हम उसे ढूँढ नहीं पाते।
            उसे ढूँढने का इकलौता तरीका 'अध्यात्म-योग' (Meditation/Self-inquiry) है, बाहरी दुनिया में भागना नहीं।
            जब साधक को उस अविनाशी सत्य के दर्शन होते हैं, तो उसकी दिमागी अवस्था (State of mind) पूरी तरह बदल जाती है।
            तब उसे न तो लॉटरी लगने पर ख़ुशी (हर्ष) होती है और न ही दिवालिया होने पर दुख (शोक) होता है; वह इन सबसे ऊपर उठ जाता है।
            खुशी और दुख केवल शरीर और अहंकार के नाटक हैं; आत्मा इन दोनों द्वंद्वों (Dualities) से हमेशा मुक्त और शांत रहती है।
        """.trimIndent(),
        english = """
            That Supreme Lord is extremely hard to see (Durdarsha), and He is deeply hidden (Gudha) penetrating this entire world of Maya.
            He is seated right within the cave of the intellect (Guhahitam), and is the most ancient (Purana) Deity dwelling in this dense forest of the body (Gahvara).
            By the intense practice of 'Adhyatma-Yoga' (the process of withdrawing the mind from the outside and fixing it on the inner Soul).
            By realizing and directly experiencing that Deity, the wise (Dhira) man permanently abandons both joy (Harsha) and sorrow (Shoka).
            God does not stand visibly in front of our physical eyes, because He Himself is our very 'power of seeing' (Consciousness).
            He sits precisely in the center of our brain (cave) and this complex body (forest), yet we miserably fail to find Him.
            The only exclusive method to find Him is 'Adhyatma-Yoga' (Meditation/Self-inquiry), not running frantically in the outside world.
            When a seeker gets the vision of that indestructible Truth, his entire state of mind completely and permanently transforms.
            Then he neither feels elation (Harsha) upon winning a lottery, nor grief (Shoka) upon going bankrupt; he rises far above them both.
            Joy and sorrow are merely dramas of the physical body and ego; the Soul remains eternally free and perfectly tranquil beyond these dualities.
        """.trimIndent()
    ),
    KathaShloka(
        id = 42,
        sanskrit = "एतच्छ्रुत्वा सम्परिगृह्य मर्त्यः प्रवृह्य धर्म्यमणुमेतमाप्य । स मोदते मोदनीयँ हि लब्ध्वा विवृतँ सद्म नचिकेतसं मन्ये ॥ १३ ॥",
        hindi = """
            जब कोई मरणशील मनुष्य (मर्त्य) इस परम सत्य को किसी ज्ञानी गुरु से भलीभांति सुन (श्रुत्वा) लेता है और उसे हृदय से ग्रहण कर लेता है।
            और जब वह इस शरीर (अहंकार) से उस अत्यंत सूक्ष्म (अणु) और धर्मस्वरूप आत्मा को पूरी तरह से अलग (प्रवृह्य) करके जान लेता है।
            तब वह उस परम आनंदमय (मोदनीय) परमात्मा को प्राप्त करके उस सर्वोच्च परमानंद में हमेशा के लिए मग्न (मोदते) हो जाता है।
            हे नचिकेता! मैं मानता हूँ कि तुम्हारे लिए उस परम ब्रह्म का घर (विवृतं सद्म) पूरी तरह से खुला हुआ है।
            सत्य को केवल कानों से सुनना काफी नहीं है; उसे जीवन में उतारना (सम्परिगृह्य) और उसका अभ्यास करना जरूरी है।
            आत्मा को शरीर से अलग करना (प्रवृह्य) वैसे ही है जैसे मूंज (घास) के तिनके से उसकी सींक को सावधानी से अलग करना।
            जब तक हम खुद को शरीर मानते हैं, तब तक हम डर और दुख में जीते हैं; जब हम खुद को आत्मा मानते हैं, तो हम आनंद बन जाते हैं।
            यमराज नचिकेता को बता रहे हैं कि मोक्ष के दरवाजे (सद्म) हर किसी के लिए नहीं खुलते, ये केवल सच्चे जिज्ञासु के लिए खुलते हैं।
            नचिकेता की परीक्षा पूरी हो चुकी है; उसने दिखा दिया है कि वह उस आनंद (मोदनीय) को सम्भालने के लिए पूरी तरह तैयार है।
            यह श्लोक गुरु का एक बहुत ही प्यारा आशीर्वाद है, जो शिष्य को उस परम घर (मोक्ष) में प्रवेश करने की अनुमति दे रहा है।
        """.trimIndent(),
        english = """
            When a mortal human (Martya) thoroughly hears (Shrutva) this supreme truth from a wise Guru and accepts it deeply in his heart.
            And when he carefully separates (Pravrihya) and realizes this extremely subtle (Anu) and righteous Soul completely apart from the body (ego).
            Then, having attained that supremely blissful (Modaniya) Supreme Lord, he intensely rejoices and remains forever immersed in ultimate bliss.
            O Nachiketa! I firmly consider that the supreme abode of Brahman (Vivritam sadma) is thrown wide open specifically for you.
            Merely hearing the truth with physical ears is absolutely not enough; one must profoundly absorb it (Samparigrihya) and actively practice it.
            Separating the Soul from the physical body (Pravrihya) is exactly like carefully extracting the tender inner stalk from a blade of grass.
            As long as we identify with the body, we live in fear and sorrow; the moment we identify as the Soul, we become absolute bliss itself.
            Yama is telling Nachiketa that the doors of Moksha (Sadma) do not open for just anyone; they open exclusively for a genuine seeker.
            Nachiketa's grueling test is completely over; he has proven that he is perfectly ready to handle that ultimate cosmic bliss (Modaniya).
            This verse is an incredibly beautiful and loving blessing from the Guru, officially granting the disciple entry into that Supreme Home (Moksha).
        """.trimIndent()
    ),
    KathaShloka(
        id = 43,
        sanskrit = "अन्यत्र धर्मादन्यत्राधर्मादन्यत्रास्मात् कृताकृतात् । अन्यत्र भूताच्च भव्याच्च यत्तत्पश्यसि तद्वद ॥ १४ ॥",
        hindi = """
            (नचिकेता अब सीधे उस परम तत्व के बारे में पूछता है): हे यमराज! जो धर्म (पुण्य) से अलग है और अधर्म (पाप) से भी बिल्कुल अलग है।
            जो इस 'कृत' (कार्य/Effect) और 'अकृत' (कारण/Cause) दोनों की सीमाओं से पूरी तरह से परे है।
            और जो भूतकाल (बीते हुए समय) तथा भविष्यकाल (आने वाले समय) से भी सर्वथा अलग और स्वतंत्र है।
            आप जिस ऐसे परम तत्त्व (ईश्वर/आत्मा) को प्रत्यक्ष रूप से देखते और जानते हैं, कृपया मुझे केवल उसी के बारे में बताइए (तद्वद)।
            नचिकेता का यह प्रश्न वेदान्त दर्शन का सबसे तीक्ष्ण (Sharpest) और सबसे सटीक प्रश्न है।
            वह न तो अच्छे कर्मों (धर्म) का फल चाहता है और न बुरे कर्मों (अधर्म) से डरता है; वह इन दोनों द्वंद्वों (Dualities) के पार जाना चाहता है।
            वह कारण और कार्य (Cause and Effect) के उस विज्ञान से बाहर निकलना चाहता है जहाँ से कर्मों की जंजीरें शुरू होती हैं।
            समय (भूत-भविष्य) इंसान को मारता है; नचिकेता उस तत्व को जानना चाहता है जिस पर समय का कोई असर नहीं होता (Timelessness)।
            नचिकेता की मांग स्पष्ट है: "मुझे कोई फिलॉसफी (Philosophy) मत सुनाइए; आप जो 'देखते' हैं (Experience करते हैं), मुझे वही साक्षात् सत्य बताइए।"
            यह श्लोक उस परम निराकार ब्रह्म की ओर इशारा करता है जो दुनिया की हर परिभाषा और हर नियम से पूरी तरह आज़ाद है।
        """.trimIndent(),
        english = """
            (Nachiketa now asks directly about that Supreme Principle): O Yama! That which is entirely distinct from Dharma (virtue) and distinct from Adharma (sin).
            That which is completely and absolutely beyond both the 'Krita' (Effect/created) and the 'Akrita' (Cause/uncreated).
            And that which is entirely separate and independent from the past (what has been) and the future (what is yet to be).
            That ultimate Supreme Principle (God/Soul) which You directly see and experience, please tell me about That alone (Tadvada).
            Nachiketa's question here is undeniably the sharpest and most precise inquiry in the entire Vedantic philosophy.
            He neither desires the fruits of good deeds (Dharma) nor fears bad deeds (Adharma); he wants to transcend these dualities altogether.
            He intensely wants to step completely outside the science of Cause and Effect from where the chains of karma actually begin.
            Time (past-future) kills humans; Nachiketa wants to know that absolute Principle upon which time has zero effect (Timelessness).
            Nachiketa's demand is crystal clear: "Do not give me mere philosophy; tell me that direct Truth which You personally 'see' and experience."
            This verse brilliantly points directly toward that Supreme Formless Brahman which is completely free from every worldly definition and rule.
        """.trimIndent()
    ),

    KathaShloka(
        id = 44,
        sanskrit = "सर्वे वेदा यत्पदमामनन्ति तपाँसि सर्वाणि च यद्वदन्ति । यदिच्छन्तो ब्रह्मचर्यं चरन्ति तत्ते पदँ संग्रहेण ब्रवीम्योमित्येतत् ॥ १५ ॥",
        hindi = """
            (यमराज नचिकेता के महान प्रश्न का उत्तर देते हैं): सारे वेद एक स्वर में जिस परम पद (लक्ष्य/ईश्वर) का बार-बार प्रतिपादन और वर्णन करते हैं।
            दुनिया की सभी तपस्याएं (कठोर साधनाएं) जिस एक लक्ष्य को प्राप्त करने के लिए ही की जाती हैं।
            और जिस परम सत्य को पाने की इच्छा रखकर साधक ब्रह्मचर्य (इंद्रिय-संयम और ज्ञान के मार्ग पर चलना) का कठोर पालन करते हैं।
            मैं तुम्हें उस परम पद (मंजिल) के बारे में बहुत ही संक्षेप (Short) में बताता हूँ—वह परम पद केवल 'ॐ' (ओम) ही है।
            यमराज ने नचिकेता के अत्यंत जटिल प्रश्न का उत्तर एक ही शब्द में दे दिया: 'ॐ'।
            वेद लाखों श्लोकों में जो कुछ भी समझाना चाहते हैं, उसका अंतिम निचोड़ (Essence) केवल ॐ है।
            लोग जंगलों में जाकर जो भूखे-प्यासे तपस्या करते हैं, वे भी अनजाने में इसी ॐ रूपी चेतना को खोज रहे हैं।
            ब्रह्मचर्य का मतलब केवल शारीरिक संयम नहीं है, बल्कि अपने मन को हमेशा उस 'ब्रह्म' में चराने (लगाने) की कला है।
            ॐ कोई साधारण आवाज या अक्षर नहीं है; यह ब्रह्मांड की वह पहली ध्वनि (Cosmic Vibration) है जिससे सब कुछ पैदा हुआ है।
            जब साधक ॐ का ध्यान करता है, तो वह सीधे उस परम शक्ति (ब्रह्म) के साथ जुड़ (Connect) जाता है जो समय और कर्म से परे है।
        """.trimIndent(),
        english = """
            (Yama answers Nachiketa's great question): That supreme goal (state/God) which all the Vedas unanimously declare and repeatedly describe.
            That one ultimate destination which all austerities and severe spiritual penances in the world aim solely to attain.
            And desiring to attain which Supreme Truth, earnest seekers strictly practice Brahmacharya (sense-control and walking the path of Brahman).
            I will tell you about that supreme goal (destination) very briefly and concisely—that state is exclusively the syllable 'OM'.
            Yama has remarkably answered Nachiketa's extremely complex question in just one single, incredibly powerful word: 'OM'.
            Whatever the Vedas attempt to explain through millions of verses, its ultimate essence and core is simply OM.
            People who undergo severe penance starving in forests are also, knowingly or unknowingly, seeking this very consciousness of OM.
            Brahmacharya does not merely mean physical celibacy; it is the high art of constantly keeping one's mind engaged (moving) in 'Brahman'.
            OM is not an ordinary sound or letter; it is the primordial Cosmic Vibration from which absolutely everything was created.
            When a seeker meditates on OM, he directly connects with that Supreme Power (Brahman) which is entirely beyond time and karma.
        """.trimIndent()
    ),
    KathaShloka(
        id = 45,
        sanskrit = "एतद्ध्येवाक्षरं ब्रह्म एतद्ध्येवाक्षरं परम् । एतद्ध्येवाक्षरं ज्ञात्वा यो यदिच्छति तस्य तत् ॥ १६ ॥",
        hindi = """
            यह 'ॐ' (अक्षर) ही वास्तव में साक्षात् 'ब्रह्म' (निराकार सत्य) है, और यही 'ॐ' साक्षात् 'परमेश्वर' (सगुण ईश्वर) भी है।
            यह ॐ ही सबसे श्रेष्ठ और अविनाशी (अक्षर) तत्व है, इससे ऊपर और कुछ भी नहीं है।
            इस परम अक्षर (ॐ) को यथार्थ रूप में जान लेने पर (और इसका ध्यान करने पर), मनुष्य जो कुछ भी इच्छा करता है, उसे वही प्राप्त हो जाता है।
            यहाँ ॐ की अपार शक्ति और महिमा का वर्णन किया गया है।
            जो लोग भगवान को निराकार (Formless) मानते हैं, उनके लिए भी ॐ ही अंतिम सत्य है।
            और जो लोग भगवान को साकार (With form) मानते हैं, उनके लिए भी ॐ ही परमेश्वर का असली नाम है।
            'अक्षर' का अर्थ है जिसका कभी क्षरण (नाश) न हो; दुनिया की हर आवाज़ मिट जाती है, पर ॐ की ध्वनि ब्रह्मांड में हमेशा गूँजती है।
            यह कोई जादुई मंत्र नहीं है कि आप कुछ मांगेंगे और वह प्रकट हो जाएगा।
            इसका असली अर्थ यह है कि जब आप ॐ में लीन हो जाते हैं, तो आपकी इच्छाएं भगवान की इच्छाएं बन जाती हैं।
            और जब आपकी इच्छा ही ईश्वरीय हो गई, तो उसे पूरा होने से दुनिया की कोई भी ताकत रोक नहीं सकती।
        """.trimIndent(),
        english = """
            This syllable 'OM' (Akshara) is indeed the direct 'Brahman' (the formless Truth), and this 'OM' is also the Supreme 'Lord' (God with attributes).
            This OM is the most supreme and absolutely imperishable (Akshara) principle; there is nothing higher than this.
            By truly knowing (and deeply meditating upon) this Supreme Syllable (OM), whatever a person desires, that is instantly fulfilled for him.
            Here, the boundless power, glory, and absolute magnificence of OM are profoundly described.
            For those who believe God to be completely formless (Nirguna), OM is the ultimate, final Truth.
            And for those who believe God possesses a form (Saguna), OM is the true, original name of the Supreme Lord.
            'Akshara' means that which never decays; every sound in the world fades away, but the vibration of OM echoes eternally in the cosmos.
            This is not a cheap magical spell where you ask for something and it just pops up out of nowhere.
            The real meaning is that when you merge into OM, your desires automatically transform into the desires of God Himself.
            And when your desire becomes completely divine, absolutely no power in the world can stop it from being fulfilled.
        """.trimIndent()
    ),
    KathaShloka(
        id = 46,
        sanskrit = "एतदालम्बनँ श्रेष्ठमेतदालम्बनं परम् । एतदालम्बनं ज्ञात्वा ब्रह्मलोके महीयते ॥ १७ ॥",
        hindi = """
            यह 'ॐ' ही मनुष्य के लिए सबसे श्रेष्ठ आलंबन (आश्रय/सहारा) है; यह ॐ ही सबसे परम (सर्वोच्च) आलंबन है।
            इस दुनिया में ईश्वर तक पहुँचने के लिए ॐ से बड़ा कोई दूसरा साधन या नाव बिल्कुल नहीं है।
            इस महान आलंबन (ॐ) को जानकर और इसका ध्यान करके, साधक ब्रह्मलोक (ईश्वर के परम धाम) में महिमावान (पूजनीय) हो जाता है।
            जब इंसान समुद्र में डूब रहा होता है, तो उसे एक मजबूत सहारे (आलंबन) की जरूरत होती है।
            संसार भी दुखों का एक समुद्र है, और हमारा मन हमेशा किसी न किसी सहारे (पैसे, परिवार, रिश्ते) को पकड़ना चाहता है।
            परंतु ये सभी सांसारिक सहारे कमजोर हैं; ये एक न एक दिन टूट जाते हैं और इंसान फिर से डूबने लगता है।
            यमराज कहते हैं कि केवल 'ॐ' ही वह मजबूत लकड़ी (सहारा) है जो कभी नहीं टूटती और कभी धोखा नहीं देती।
            अगर मन को टिकाना ही है, तो उसे इस ॐ की ध्वनि पर टिकाओ।
            जो मन ॐ के साथ एक हो जाता है, वह भौतिक शरीर में रहते हुए भी सीधे ब्रह्मलोक (Supreme Consciousness) का आनंद लेता है।
            ऐसे आत्मज्ञानी पुरुष की महिमा देवताओं के समान हो जाती है, और पूरी प्रकृति उसके सामने झुक जाती है।
        """.trimIndent(),
        english = """
            This 'OM' is the very best Alambana (support/refuge/prop) for a human being; this OM is the highest and most supreme support.
            There is absolutely no greater tool or boat in this world to safely reach God than OM.
            Having known and meditated upon this great support (OM), the seeker becomes highly glorified and worshipped in Brahmaloka (the supreme abode of God).
            When a person is actively drowning in an ocean, he desperately needs a strong support (Alambana) to hold onto.
            The world is also an ocean of sorrows, and our mind constantly wants to grab onto some support (money, family, relationships).
            However, all these worldly supports are weak; they will inevitably break one day, leaving the person drowning again.
            Yama declares that 'OM' alone is that unbreakable, sturdy wood (support) that never snaps and never betrays.
            If you must anchor your restless mind somewhere, anchor it firmly on the continuous vibration of OM.
            The mind that becomes one with OM enjoys the bliss of Brahmaloka (Supreme Consciousness) even while living in a physical body.
            The glory of such a Self-realized soul becomes equal to the gods, and all of Nature bows down before him.
        """.trimIndent()
    ),
    KathaShloka(
        id = 47,
        sanskrit = "न जायते म्रियते वा विपश्चिन्नायं कुतश्चिन्न बभूव कश्चित् । अजो नित्यः शाश्वतोऽयं पुराणो न हन्यते हन्यमाने शरीरे ॥ १८ ॥",
        hindi = """
            यह ज्ञानी (विपश्चित्) आत्मा न तो कभी जन्म लेती है, और न ही यह कभी मरती है।
            यह आत्मा न तो किसी और चीज़ (कारण) से पैदा हुई है, और न ही इस आत्मा से कोई और चीज़ (कार्य) पैदा होती है।
            यह आत्मा अजन्मा (जिसका जन्म न हो), नित्य (हमेशा रहने वाली), शाश्वत (कभी न बदलने वाली) और अत्यंत पुरातन (प्राचीन) है।
            इस भौतिक शरीर के मारे जाने (नष्ट हो जाने) पर भी यह आत्मा कभी नहीं मारी जाती।
            यह भगवद्गीता (2.20) का सबसे प्रसिद्ध और आधारभूत श्लोक है जो सीधे कठोपनिषद से लिया गया है।
            हम मौत से डरते हैं क्योंकि हम खुद को यह मांस और हड्डियों का शरीर मान बैठे हैं।
            परंतु सत्य यह है कि हम वह चेतना (विपश्चित्) हैं जो शरीर के बनने से पहले भी थी और शरीर के जलने के बाद भी रहेगी।
            आत्मा किसी फैक्ट्री में नहीं बनी, और न ही भगवान ने इसे किसी मिट्टी से बनाया है; यह स्वयं भगवान का अंश है।
            यह कभी बूढ़ी नहीं होती (शाश्वत), इसके बाल सफेद नहीं होते; यह हमेशा शुद्ध और युवा रहती है।
            जब कोई तलवार शरीर को काटती है, तो वह केवल कपड़े को फाड़ती है; शरीर को पहनने वाली आत्मा पर उस तलवार का कोई असर नहीं होता।
        """.trimIndent(),
        english = """
            This conscious and wise (Vipashchit) Soul is never born, nor does it ever die at any time.
            This Soul has not sprung or originated from anything else (cause), nor has anything else evolved from this Soul (effect).
            This Soul is completely unborn (Aja), eternal (Nitya), everlasting/unchanging (Shashvata), and the most ancient (Purana).
            Even when this physical body is slain (destroyed), this Soul is never, ever slain or harmed.
            This is the most famous and foundational verse of the Bhagavad Gita (2.20), taken directly from the Katha Upanishad.
            We intensely fear death because we mistakenly identify ourselves as this fragile body of flesh and bones.
            But the absolute truth is that we are that pure Consciousness (Vipashchit) which existed before the body and will remain after it burns.
            The Soul was not manufactured in a factory, nor did God mold it from clay; it is an uncreated fragment of God Himself.
            It never ages (Shashvata), its hair never turns gray; it remains eternally pure, fresh, and youthful forever.
            When a sword cuts the body, it merely tears a piece of clothing; the sword has absolutely zero effect on the Soul wearing that body.
        """.trimIndent()
    ),
    KathaShloka(
        id = 48,
        sanskrit = "हन्ता चेन्मन्यते हन्तुं हतश्चेन्मन्यते हतम् । उभौ तौ न विजानीतो नायं हन्ति न हन्यते ॥ १९ ॥",
        hindi = """
            यदि कोई मारने वाला अहंकारवश यह सोचता है कि 'मैं इस आत्मा को मार रहा हूँ'।
            और यदि कोई मरने वाला डर के मारे यह सोचता है कि 'मैं मारा जा रहा हूँ (मैं मर जाऊँगा)'।
            तो वे दोनों ही मूर्ख हैं और वे दोनों ही इस आत्मा के असली रहस्य को बिल्कुल नहीं जानते हैं।
            क्योंकि सत्य तो यह है कि यह आत्मा न तो कभी किसी को मारती है, और न ही इसे कभी किसी के द्वारा मारा जा सकता है।
            यह श्लोक भी भगवद्गीता (2.19) का ही है, जो युद्ध और मृत्यु के दर्शन को बहुत गहराई से समझाता है।
            मारने वाले का घमंड झूठा है, क्योंकि वह केवल शरीर को नष्ट कर सकता है, आत्मा को छू भी नहीं सकता।
            और मरने वाले का डर भी झूठा है, क्योंकि उसकी असली पहचान (आत्मा) का कभी खून नहीं हो सकता।
            संसार में जो भी हिंसा या मृत्यु दिखती है, वह केवल भौतिक प्रकृति (Matter) का बदलाव है, चेतना का नहीं।
            जब इंसान को यह बात समझ में आ जाती है, तो वह विक्टिम कार्ड (Victim card - 'मैं बेचारा हूँ') खेलना बंद कर देता है।
            वह जान लेता है कि वह एक अजेय (Invincible) और अमर ऊर्जा है, जिसे दुनिया की कोई ताकत नुकसान नहीं पहुँचा सकती।
        """.trimIndent(),
        english = """
            If the slayer arrogantly thinks in his ego that 'I am slaying and killing this soul'.
            And if the slain thinks out of terrible fear that 'I am being killed (I will die)'.
            Then both of them are utterly foolish and neither of them truly knows the profound secret of this Soul.
            Because the absolute truth is that this Soul neither slays anyone, nor can it ever be slain by anyone.
            This verse is also echoed perfectly in the Bhagavad Gita (2.19), deeply explaining the philosophy of war and death.
            The pride of the killer is entirely false, because he can only destroy the body; he cannot even touch the Soul.
            And the fear of the dying person is equally false, because his true identity (the Soul) can never be murdered.
            Whatever violence or death is seen in the world is merely the transformation of physical matter, never of consciousness.
            When a person truly understands this fact, he completely stops playing the victim card ('I am poor and helpless').
            He realizes perfectly that he is an invincible, immortal energy that absolutely no power in the world can ever harm.
        """.trimIndent()
    ),
    KathaShloka(
        id = 49,
        sanskrit = "अणोरणीयान्महतो महीयानात्मास्य जन्तोर्निहितो गुहायाम् । तमक्रतुः पश्यति वीतशोको धातुप्रसादान्महिमानमात्मनः ॥ २० ॥",
        hindi = """
            यह आत्मा परमाणु (अणु) से भी अत्यंत सूक्ष्म (छोटा) है, और यह महान-से-महान आकाश से भी अधिक विशाल (बड़ा) है।
            यह परम आत्मा प्रत्येक मनुष्य और जीव (जंतु) की हृदय रूपी गुफा (गुहा) में गहराई से छिपा हुआ है।
            जिस साधक की सभी सांसारिक इच्छाएं खत्म हो चुकी हैं (अक्रतुः), वही निष्काम पुरुष इस आत्मा को देख पाता है।
            उस विधाता (ईश्वर) की अहैतुकी कृपा (धातुप्रसादात्) से ही वह मनुष्य आत्मा की इस महान महिमा को देखकर पूरी तरह शोकरहित (दुख-मुक्त) हो जाता है।
            यह श्लोक श्वेताश्वतर उपनिषद (3.20) के बिल्कुल समान है, जो आत्मा की विशालता और सूक्ष्मता को दर्शाता है।
            आत्मा का कोई साइज (Size) नहीं है; वह चींटी के दिल में भी पूरी तरह फिट है और पूरे ब्रह्मांड को भी निगले हुए है।
            हम उसे इसलिए नहीं देख पाते क्योंकि हमारा मन वासनाओं और इच्छाओं (क्रतु) के शोर से भरा हुआ है।
            जब तालाब का पानी हिलता है, तो उसमें चेहरा नहीं दिखता; जब मन की इच्छाएं शांत होती हैं, तभी आत्मा का चेहरा दिखता है।
            परंतु ध्यान रहे, यह दर्शन हमारी अपनी मेहनत से नहीं, बल्कि भगवान की 'कृपा' (प्रसाद) से ही संभव होता है।
            जब वह कृपा बरसती है, तो जीवन भर का सारा तनाव, डर और शोक एक ही पल में हमेशा के लिए मिट जाता है।
        """.trimIndent(),
        english = """
            This Soul is infinitely subtler than the smallest atom, and vastly greater than the greatest magnitude (space).
            This Supreme Soul is deeply hidden (seated) right within the cave of the heart (Guha) of every single creature.
            The desireless seeker (Akratuh), whose worldly cravings have completely vanished, alone is able to behold this Soul.
            By the pure grace of the Creator (Dhatuprasadat), that person clearly sees the magnificent glory of the Soul and becomes completely free from sorrow (Vitashokah).
            This verse is identical to Shvetashvatara Upanishad (3.20), illustrating the immense vastness and extreme subtlety of the Soul.
            The Soul has no physical size; it fits perfectly within the tiny heart of an ant and entirely swallows the vast cosmos.
            We fail to see it simply because our mind is filled with the loud, chaotic noise of lusts and desires (Kratu).
            When pond water ripples, a reflection cannot be seen; only when the mind's desires completely still does the face of the Soul appear.
            However, this divine vision is not possible merely through our own strenuous efforts, but ultimately through God's 'Grace' (Prasada).
            When that grace showers, a lifetime of severe stress, terrifying fear, and deep sorrow is wiped out forever in a single moment.
        """.trimIndent()
    ),

    KathaShloka(
        id = 50,
        sanskrit = "आसीनो दूरं व्रजति शयानो याति सर्वतः । कस्तं मदामदं देवं मदन्यो ज्ञातुमर्हति ॥ २१ ॥",
        hindi = """
            (यमराज आत्मा की रहस्यमयी प्रकृति बताते हैं): यह आत्मा एक जगह शांत बैठी हुई (आसीनो) भी बहुत दूर तक चली जाती है।
            और यह सोती हुई (शयानो) भी एक ही समय में सभी जगह (सर्वतः) पहुँच जाती है।
            उस हर्ष (मद) और शोक (अमद) से युक्त, तथा इन दोनों से अत्यंत परे रहने वाले उस परम देव (परमात्मा) को।
            मेरे (यमराज/आत्मज्ञानी) सिवा दूसरा कौन अज्ञानी मनुष्य जानने में समर्थ हो सकता है?
            यह श्लोक आत्मा के विरोधाभासों (Paradoxes) से भरा हुआ है, जो हमारी सामान्य बुद्धि को चकरा देता है।
            शरीर एक जगह बैठता है, पर मन और चेतना बैठे-बैठे ही पल भर में अमेरिका या चाँद तक पहुँच सकती है।
            आत्मा स्पेस (Space) और टाइम (Time) से बाहर है, इसलिए उसे कहीं 'जाने' की जरूरत ही नहीं पड़ती, वह पहले से ही सब जगह मौजूद है।
            'मद-अमद' का अर्थ है कि भगवान ही दुनिया के सुख (हर्ष) और दुख के रूप में प्रकट हो रहा है, फिर भी वह इन सबसे अप्रभावित (Untouched) है।
            यमराज कहते हैं कि भगवान को बुद्धि की चालाकी से नहीं समझा जा सकता; इसके लिए यमराज जैसी गहरी दृष्टि चाहिए।
            यह एक चुनौती है कि जो खुद को शरीर मानता है, वह कभी भी इस जादुई और सर्वव्यापी आत्मा को नहीं पकड़ सकता।
        """.trimIndent(),
        english = """
            (Yama explains the mystical nature of the Soul): This Soul, even while sitting perfectly still in one place (Asino), travels incredibly far.
            And even while resting or sleeping (Shayano), it goes absolutely everywhere (Sarvatah) at the exact same time.
            That Supreme Deity who is joyful (Mada) and joyless (Amada), and who exists completely beyond both of these states.
            Who else other than me (Yama/a realized sage) can possibly be capable of knowing and understanding Him?
            This verse is entirely filled with striking paradoxes of the Soul that completely baffle our ordinary, limited human intellect.
            The body sits in one place, but the mind and consciousness can reach America or the moon in a split second without moving.
            The Soul is outside Space and Time, so it doesn't ever need to 'travel' anywhere; it is already omnipresent everywhere.
            'Mada-Amada' means God Himself manifests as the world's joy and sorrow, yet He remains completely untouched by them all.
            Yama states that God cannot be comprehended by intellectual cleverness; it requires a profoundly deep vision like Yama's.
            This is a strict challenge indicating that anyone who identifies as a physical body can never grasp this magical, omnipresent Soul.
        """.trimIndent()
    ),
    // ... Continuing kathaShlokasList from ID 51

    KathaShloka(
        id = 51,
        sanskrit = "अशरीरँ शरीरेष्वनवस्थेष्ववस्थितम् । महान्तं विभुमात्मानं मत्वा धीरो न शोचति ॥ २२ ॥",
        hindi = """
            वह महान आत्मा नाशवान और अस्थायी शरीरों (शरीरेषु) के भीतर पूर्ण रूप से अशरीरी (बिना शरीर के) होकर स्थित है।
            वह अत्यंत चंचल और अस्थिर पदार्थों (अनवस्थेषु) के बीच बिल्कुल स्थिर और अचल (अवस्थितम्) होकर निवास करता है।
            वह आत्मा अत्यंत महान (विशाल) है और सर्वव्यापी (विभु) है; वह हर कण और हर दिशा में समान रूप से मौजूद है।
            उस महान और सर्वव्यापी आत्मा को यथार्थ रूप में जानकर (मत्वा), बुद्धिमान और धैर्यवान (धीर) मनुष्य कभी शोक नहीं करता।
            यह श्लोक शरीर और आत्मा के बीच के जबरदस्त विरोधाभास (Paradox) को बहुत ही स्पष्ट रूप से सामने रखता है।
            शरीर लगातार बदल रहा है, बूढ़ा हो रहा है और मरेगा, पर उसके अंदर बैठी चेतना (आत्मा) कभी बदलती नहीं है।
            हम दुखी इसलिए होते हैं क्योंकि हम अपनी पहचान बदलते हुए शरीर (अस्थिर) के साथ पूरी तरह से जोड़ लेते हैं।
            जब हम खुद को उस 'अशरीरी' (बिना शरीर वाले) तत्व के रूप में पहचानते हैं, तो मौत या बीमारी का डर खत्म हो जाता है।
            'धीर' का अर्थ वह नहीं है जो रोता नहीं, बल्कि वह है जो यह जान लेता है कि उसके पास रोने का कोई वास्तविक कारण है ही नहीं।
            आत्मज्ञान इंसान को इस संसार के सभी दुखों और मानसिक तनावों से पूरी तरह और हमेशा के लिए आज़ाद कर देता है।
        """.trimIndent(),
        english = """
            That great Soul resides completely bodiless (Incorporeal) within these perishable and temporary physical bodies.
            He dwells absolutely firm and permanently established (Avasthitam) amidst exceedingly fleeting and unstable things.
            That Soul is extraordinarily great (magnificent) and all-pervading (Vibhu); He is present equally in every single atom.
            By truly knowing and realizing that vast, omnipresent Soul, the wise and patient man (Dhira) never grieves again.
            This verse very clearly presents the tremendous paradox that constantly exists between the body and the soul.
            The body is continuously changing, aging, and will die, but the consciousness (Soul) sitting inside never changes.
            We suffer intensely solely because we falsely attach our ultimate identity to this constantly shifting, unstable body.
            When we finally recognize ourselves as that 'Bodiless' principle, the terrifying fear of death or disease simply vanishes.
            A 'Dhira' is not someone who forces himself not to cry, but one who realizes there is no genuine reason to cry at all.
            Self-knowledge liberates a human being entirely and permanently from all the sorrows and mental stresses of this world.
        """.trimIndent()
    ),
    KathaShloka(
        id = 52,
        sanskrit = "नायमात्मा प्रवचनेन लभ्यो न मेधया न बहुना श्रुतेन । यमेवैष वृणुते तेन लभ्यस्तस्यैष आत्मा विवृणुते तनूँ स्वाम् ॥ २३ ॥",
        hindi = """
            यह आत्मा केवल वेदों के प्रवचन (Lectures) देने या बहुत अधिक शास्त्र पढ़ने से प्राप्त (अनुभव) नहीं की जा सकती।
            इसे बहुत तेज़ बुद्धि (मेधया) या बहुत सारे विद्वानों को सुनने (श्रुतेन) मात्र से भी बिल्कुल प्राप्त नहीं किया जा सकता।
            यह आत्मा केवल उसी साधक को प्राप्त होती है, जिसे यह आत्मा स्वयं (अपनी कृपा से) स्वीकार (वृणुते) कर लेती है।
            और केवल उसी भाग्यशाली साधक के सामने यह आत्मा अपना असली और साक्षात् स्वरूप (तनूँ स्वाम्) पूरी तरह से प्रकट कर देती है।
            यह मुण्डक उपनिषद (3.2.3) का भी मंत्र है और अहंकार को तोड़ने वाला भारतीय दर्शन का सबसे बड़ा 'चेतावनी श्लोक' है।
            अक्सर लोग सोचते हैं कि अगर हम बहुत सारे ग्रंथ पढ़ लेंगे या बड़े-बड़े भाषण देंगे, तो हम भगवान को पा लेंगे।
            परंतु उपनिषद कहता है कि बौद्धिक जिमनास्टिक्स (Intellectual Gymnastics) से आत्मा को कभी पकड़ा नहीं जा सकता।
            ईश्वर कोई थ्योरी (Theory) नहीं है जिसे दिमाग से समझा जाए; वह 'कृपा' (Grace) का विषय है जो पूर्ण समर्पण से मिलती है।
            जब साधक अपना 'मैं' (अहंकार) पूरी तरह मिटा देता है, तब आत्मा खुद-ब-खुद अपने रहस्य के दरवाजे उसके लिए खोल देती है।
            यह श्लोक भक्ति और वैराग्य के बिना किए गए कोरे ज्ञान के अहंकार को पूरी तरह से खारिज (Reject) कर देता है।
        """.trimIndent(),
        english = """
            This Soul cannot possibly be attained (experienced) merely by giving discourses or reading vast numbers of scriptures.
            It can never be grasped by an exceedingly sharp intellect (Medha) or by continuously listening to many scholars (Shruti).
            This Soul is attained solely by that truly devoted seeker whom the Soul Itself chooses to accept (Vrinute) by its grace.
            And only to that incredibly fortunate seeker does this Soul completely reveal and manifest its true, original form.
            This is also a mantra from the Mundaka Upanishad (3.2.3) and the greatest 'warning verse' that shatters spiritual ego.
            People often falsely believe that if they memorize numerous texts or deliver grand speeches, they will attain God.
            But the Upanishad declares that the Soul can never be captured through mere intellectual gymnastics or logic.
            God is not a theory to be deciphered by the brain; He is a matter of 'Grace' (Kripa) earned through absolute surrender.
            When the seeker completely dissolves his 'I' (ego), the Soul automatically unlocks the doors to its deepest mysteries for him.
            This verse completely and utterly rejects the hollow arrogance of dry knowledge devoid of genuine devotion and detachment.
        """.trimIndent()
    ),
    KathaShloka(
        id = 53,
        sanskrit = "नाविरतो दुश्चरितान्नाशान्तो नासमाहितः । नाशान्तमानसो वापि प्रज्ञानेनैनमाप्नुयात् ॥ २४ ॥",
        hindi = """
            जिस मनुष्य ने अपने बुरे और निंदनीय कर्मों (दुश्चरितान्) से स्वयं को पूरी तरह से अलग (विरत) नहीं किया है।
            जिसकी इंद्रियां और मन अभी तक शांत नहीं हुए हैं (अशान्तः), और जिसका मन ध्यान में एकाग्र (असमाहितः) नहीं है।
            तथा जिसका मन हमेशा चंचल और बेचैन रहता है (अशान्तमानसो), ऐसा व्यक्ति केवल ज्ञान या तर्क के बल पर आत्मा को नहीं पा सकता।
            भले ही उसके पास कितनी भी बड़ी बौद्धिक प्रज्ञा (समझ) क्यों न हो, वह इस आत्मा के दर्शन से हमेशा वंचित ही रहेगा।
            यह श्लोक पिछले श्लोक की बात को और साफ करता है कि आत्मज्ञान के लिए पहली शर्त 'चरित्र की शुद्धि' (Character) है।
            यदि कोई व्यक्ति झूठ बोलता है, धोखा देता है और साथ में ध्यान भी करता है, तो उसका ध्यान कभी सफल नहीं होगा।
            अध्यात्म कोई शॉर्टकट नहीं है जहाँ पाप करते हुए भी मोक्ष मिल जाए; नैतिकता (Morality) ही योग की पहली सीढ़ी है।
            एक अशांत मन वाला व्यक्ति किताबों से भगवान को जान तो सकता है (Information), पर उसे 'महसूस' (Experience) नहीं कर सकता।
            मन की एकाग्रता (समाधि) और इंद्रियों की शांति के बिना, ज्ञान केवल एक दिमागी बोझ बनकर रह जाता है।
            सत्य उसी बर्तन (मन) में टिकता है जिसे सच्चाई, शांति और संयम के साबुन से अच्छी तरह धोया गया हो।
        """.trimIndent(),
        english = """
            A person who has not completely detached and restrained himself from evil and condemnable conduct (Duscharita).
            Whose senses and mind have absolutely not become tranquil (Ashantah), and whose mind lacks deep concentration.
            And whose mind remains perpetually restless and deeply disturbed; such a person cannot attain the Soul merely through logic.
            No matter how much great intellectual wisdom (Prajnana) he possesses, he will always remain deprived of this divine vision.
            This verse further clarifies the previous one, asserting that 'purity of character' is the absolute first condition for Self-knowledge.
            If someone continuously lies, cheats, and simultaneously tries to practice meditation, his meditation will never succeed.
            Spirituality is not a cheap shortcut where one can commit sins and still get Moksha; Morality is the foundation of Yoga.
            A restless person may acquire 'information' about God from books, but he can never truly 'experience' Him directly.
            Without absolute concentration of mind (Samadhi) and peaceful senses, knowledge merely becomes a heavy mental burden.
            Truth only stays in that vessel (mind) which has been thoroughly washed with the soap of honesty, peace, and self-control.
        """.trimIndent()
    ),
    KathaShloka(
        id = 54,
        sanskrit = "यस्य ब्रह्म च क्षत्रं च उभे भवत ओदनः । मृत्युर्यस्योपसेचनं क इत्था वेद यत्र सः ॥ २५ ॥",
        hindi = """
            जिस परमात्मा के लिए संपूर्ण ब्राह्मण वर्ग और क्षत्रिय वर्ग (अर्थात पूरी सृष्टि के सभी प्राणी) केवल भोजन (ओदन) के समान हैं।
            और यह भयंकर मृत्यु (यमराज), जो सबको खा जाती है, वह मृत्यु भी उस ईश्वर के लिए भोजन के साथ खाने वाली केवल एक चटनी (उपसेचनं) है।
            ऐसे उस असीम और सर्वशक्तिमान परमात्मा को सामान्य बुद्धि वाला कौन मनुष्य ठीक-ठीक जान सकता है कि वह कहाँ और कैसा है?
            (प्रथम अध्याय / दूसरी वल्ली का यह अंतिम श्लोक ईश्वर की अत्यंत विराट और संहारक शक्ति का वर्णन करता है)।
            ब्राह्मण (ज्ञान) और क्षत्रिय (बल) समाज की सबसे बड़ी शक्तियां मानी जाती हैं, पर ईश्वर के सामने वे चावल के दानों जैसी हैं।
            हम मृत्यु से इतना डरते हैं, पर वह मृत्यु भी ईश्वर की थाली की एक छोटी सी चटनी (Pickle) से ज्यादा कुछ नहीं है।
            ईश्वर केवल जन्म ही नहीं देता, वह एक महान 'भक्षक' (Consumer) भी है जो प्रलय के समय इस पूरे ब्रह्मांड को निगल जाता है।
            हम अपनी छोटी सी अक्ल से उस भगवान को नापने की कोशिश करते हैं जो मौत को भी चबा जाता है, यह हमारी सबसे बड़ी मूर्खता है।
            यह श्लोक इंसान के अहंकार को चकनाचूर कर देता है और उसे ईश्वर की असीमित सत्ता के सामने झुकने पर मजबूर करता है।
            ईश्वर को केवल वही जान सकता है जिसे वह स्वयं जनाए; तर्क करने वालों के लिए वह हमेशा एक अनसुलझा रहस्य ही रहेगा।
        """.trimIndent(),
        english = """
            For that Supreme Lord, the entire Brahmin and Kshatriya classes (meaning all living beings in creation) are merely like food (rice).
            And this terrifying Death (Yama) itself, which devours everything, is just like a pickle (side-dish/upasechanam) for His food.
            Who among ordinary, limited human intellects can ever truly know exactly where and how that omnipotent Lord exists?
            (This final verse of the first chapter / second Valli describes the unimaginably colossal and destructive power of God).
            Brahmins (wisdom) and Kshatriyas (strength) are the greatest powers of society, but before God, they are mere grains of rice.
            We fear death so intensely, yet even that Death is nothing more than a tiny dab of pickle on God's massive dinner plate.
            God is not just a Creator; He is also the Supreme 'Consumer' who swallows this entire cosmos during absolute dissolution.
            We foolishly try to measure with our tiny brains the God who casually chews up Death itself; this is our greatest folly.
            This verse completely shatters human arrogance and firmly forces one to bow down before the limitless supremacy of the Divine.
            God can only be known by the one to whom He reveals Himself; for debaters, He will forever remain an unsolved mystery.
        """.trimIndent()
    ),
    KathaShloka(
        id = 55,
        sanskrit = "ऋतं पिबन्तौ सुकृतस्य लोके गुहां प्रविष्टौ परमे परार्धे । छायातपौ ब्रह्मविदो वदन्ति पञ्चाग्नयो ये च त्रिणाचिकेताः ॥ १ ॥",
        hindi = """
            (तृतीय वल्ली प्रारंभ): इस शरीर रूपी लोक में, हृदय के अत्यंत श्रेष्ठ (परमे) और ऊँचे स्थान वाली गुफा (गुहा) में दो तत्त्व प्रवेश किए हुए हैं।
            वे दोनों अपने-अपने किए हुए शुभ कर्मों का यथार्थ फल (ऋतं) पी रहे हैं (एक कर्मों का भोग करता है, दूसरा साक्षी है)।
            ब्रह्म को जानने वाले ज्ञानी लोग, तथा पंचाग्नि और तीन बार नाचिकेत अग्नि का अनुष्ठान करने वाले लोग उन्हें 'छाया और धूप' (छायातपौ) कहते हैं।
            यहाँ फिर से मुण्डक उपनिषद (दो पक्षी) और श्वेताश्वतर वाली बात एक नए रूपक (Metaphor) में कही गई है।
            हृदय की गुफा में दो चीजें हैं: एक जीवात्मा (Individual soul) और दूसरा परमात्मा (Supreme soul)।
            जीवात्मा कर्मों का फल (सुख-दुख) भोगती है, जबकि परमात्मा बिना कुछ भोगे केवल एक 'साक्षी' की तरह वहां मौजूद रहता है।
            ज्ञानी लोग इन्हें छाया और धूप कहते हैं—जीवात्मा अज्ञान (छाया) में है, और परमात्मा शुद्ध ज्ञान (धूप/प्रकाश) का स्वरूप है।
            ये दोनों शरीर में एक साथ रहते हैं, फिर भी एक दुखी है और दूसरा परम शांत है।
            हमारा पूरा जीवन इस 'छाया' से निकलकर उस 'धूप' (परमात्मा के प्रकाश) में जाने का एक संघर्ष ही तो है।
            यमराज नचिकेता को बता रहे हैं कि सत्य की खोज बाहर हिमालय पर नहीं, अपने ही हृदय के अंधेरे और उजाले के बीच करनी है।
        """.trimIndent(),
        english = """
            (Beginning of Valli 3): In this world of the body, deeply entered into the supreme (Parame) and highest cave of the heart, there are two entities.
            Both are drinking the exact, righteous fruits (Ritam) of their actions (one actually enjoys, the other is merely a witness).
            The knowers of Brahman, as well as those who perform the five-fires and the three-fold Nachiketa fire, call them 'Shadow and Sunlight'.
            Here again, the concept from Mundaka (two birds) and Shvetashvatara is perfectly expressed through a fresh metaphor.
            There are precisely two entities in the cave of the heart: the Jivatma (individual soul) and the Paramatma (Supreme soul).
            The Jivatma actively consumes the fruits of karma (joy/sorrow), while the Paramatma remains entirely as a non-enjoying 'Witness'.
            The wise call them shadow and sunlight—the Jivatma is trapped in ignorance (shadow), while Paramatma is pure wisdom (sunlight).
            Both live perfectly together in the exact same body, yet one suffers immensely while the other is absolutely tranquil.
            Our entire spiritual life is simply a continuous struggle to step out of this 'shadow' and merge into that 'sunlight' (God's light).
            Yama is telling Nachiketa that the search for Truth is not outside on the Himalayas, but right between the dark and light of one's own heart.
        """.trimIndent()
    ),
    KathaShloka(
        id = 56,
        sanskrit = "यः सेतुरीजानानामक्षरं ब्रह्म यत् परम् । अभयं तितीर्षतां पारं नाचिकेतँ शकेमहि ॥ २ ॥",
        hindi = """
            (यमराज कहते हैं): जो अग्नि यज्ञ करने वालों के लिए दुखों के सागर को पार करने का एक मजबूत पुल (सेतु) है।
            और जो सबसे श्रेष्ठ, कभी नष्ट न होने वाला (अक्षर), और संसार से पार जाने वालों के लिए अभय (भय-रहित) किनारा है।
            उस परम ब्रह्म को और उस 'नाचिकेत अग्नि' (ध्यान/ज्ञान) को हम भलीभांति जानने और अनुभव करने में पूरी तरह समर्थ (शकेमहि) हों।
            यह श्लोक कर्मकांड (यज्ञ) और वेदान्त (ब्रह्मज्ञान) दोनों को एक साथ सम्मान देता है।
            संसार एक खतरनाक नदी है जहाँ इच्छाओं की लहरें और मृत्यु का डर इंसान को लगातार डुबोता रहता है।
            इस नदी को पार करने के लिए दो चीजें चाहिए: एक अच्छी नाव (नाचिकेत अग्नि/निष्काम कर्म) और एक सुरक्षित किनारा (ब्रह्म)।
            जब तक किनारा (लक्ष्य) सुरक्षित और भयरहित (अभय) न हो, तब तक नाव चलाने का कोई फायदा नहीं है।
            परब्रह्म ही वह इकलौता किनारा है जहाँ पहुँचने के बाद कोई भी डर, यहां तक कि मौत का डर भी, खत्म हो जाता है।
            हम इंसानों के भीतर वह क्षमता (Potential) है कि हम उस पार (पारं) जा सकें; हम यहां केवल रोने के लिए पैदा नहीं हुए हैं।
            यह श्लोक साधक के भीतर यह गहरा आत्मविश्वास जगाता है कि 'हाँ, मैं भी उस परब्रह्म को प्राप्त कर सकता हूँ।'
        """.trimIndent(),
        english = """
            (Yama says): That Fire which serves as a sturdy bridge (Setu) for the sacrificers to cross over the ocean of sorrow.
            And that which is the supreme, imperishable (Akshara) Brahman, the absolutely fearless (Abhaya) shore for those wishing to cross over.
            May we become completely capable (Shakemahi) of deeply knowing and experiencing that Nachiketa Fire and that Supreme Brahman.
            This verse beautifully offers profound respect simultaneously to both ritualistic action (Karma) and ultimate wisdom (Vedanta).
            The world is a highly dangerous river where the waves of desires and the deep fear of death constantly drown a person.
            To cross this river, two things are needed: a solid boat (Nachiketa Fire/selfless action) and a perfectly safe shore (Brahman).
            Unless the destination shore is completely safe and utterly fearless (Abhaya), rowing the boat is of no real use.
            The Supreme Brahman is the absolute only shore where, upon arrival, every single fear, even the fear of death, vanishes.
            We humans perfectly possess the deep potential to reach that ultimate shore (Param); we are not born merely to weep here.
            This verse awakens a profound self-confidence within the seeker that 'Yes, I too am fully capable of attaining that Supreme Brahman.'
        """.trimIndent()
    ),
    KathaShloka(
        id = 57,
        sanskrit = "आत्मानँ रथिनं विद्धि शरीरँ रथमेव तु । बुद्धिं तु सारथिं विद्धि मनः प्रग्रहमेव च ॥ ३ ॥",
        hindi = """
            (यमराज जीवन का सबसे प्रसिद्ध रूपक प्रस्तुत करते हैं): हे नचिकेता! तुम इस जीवात्मा को रथ का स्वामी (रथी/यात्री) जानो।
            और इस भौतिक शरीर को तुम वह 'रथ' (Chariot) समझो जिस पर यह आत्मा बैठकर यात्रा कर रही है।
            तुम अपनी 'बुद्धि' (Intellect) को इस रथ को चलाने वाला कुशल 'सारथी' (Driver) जानो।
            और अपने 'मन' (Mind) को तुम घोड़ों की 'लगाम' (प्रग्रह/Reins) के रूप में अच्छी तरह से समझो।
            कठोपनिषद का यह रथ का रूपक (Chariot Metaphor) भगवद्गीता के दर्शन का मूल आधार है।
            हमारा जीवन एक यात्रा है। शरीर केवल एक गाड़ी (रथ) है, यह गाड़ी स्वयं नहीं जानती कि इसे कहाँ जाना है।
            आत्मा इस गाड़ी का मालिक है जो पीछे आराम से बैठा है; वह यात्रा का असली लक्ष्य तय करता है।
            बुद्धि वह ड्राइवर है जिसके हाथ में मन रूपी लगाम है; यदि ड्राइवर सो गया या मूर्ख हुआ, तो एक्सीडेंट पक्का है।
            मन (लगाम) का काम है घोड़ों (इंद्रियों) को कंट्रोल करना, पर अगर लगाम ढीली हुई तो घोड़े गाड़ी को खाई में गिरा देंगे।
            अध्यात्म का मतलब शरीर (रथ) को नष्ट करना नहीं है, बल्कि ड्राइवर (बुद्धि) को मजबूत और जागरूक बनाना है।
        """.trimIndent(),
        english = """
            (Yama presents life's most famous metaphor): O Nachiketa! Know this individual Soul to be the absolute master (Rathi/passenger) of the chariot.
            And understand this physical body to be nothing but the 'chariot' (Ratha) upon which this soul is traveling.
            Know your 'intellect' (Buddhi) to be the expert 'charioteer' (driver) who actively steers and drives this chariot.
            And perfectly understand your 'mind' (Manas) to be the 'reins' (Pragraha) used to firmly control the horses.
            This Chariot Metaphor of the Katha Upanishad forms the very foundational basis of the philosophy of the Bhagavad Gita.
            Our life is a journey. The body is merely a vehicle (chariot); this vehicle doesn't inherently know where it needs to go.
            The Soul is the supreme master sitting comfortably in the back; He determines the true, ultimate destination of the journey.
            The intellect is the driver holding the reins of the mind; if the driver falls asleep or is foolish, a fatal accident is guaranteed.
            The mind's job is to control the horses (senses), but if the reins are loose, the wild horses will throw the chariot into a ditch.
            Spirituality does not mean destroying the body (chariot), but actively making the driver (intellect) exceptionally strong and fully alert.
        """.trimIndent()
    ),
    KathaShloka(
        id = 58,
        sanskrit = "इन्द्रियाणि हयानाहुर्विषयाँस्तेषु गोचरान् । आत्मेन्द्रियमनोयुक्तं भोक्तेत्याहुर्मनीषिणः ॥ ४ ॥",
        hindi = """
            ज्ञानी लोग हमारी पाँचों इंद्रियों (आँख, कान आदि) को इस शरीर रूपी रथ के दौड़ने वाले 'घोड़े' (हय) कहते हैं।
            और दुनिया के जो विषय हैं (रूप, शब्द, स्वाद आदि), वे उन घोड़ों के दौड़ने के 'रास्ते' (गोचर/Paths) हैं।
            शरीर, इंद्रियों और मन के साथ जुड़े हुए (युक्त) उस आत्मा को ही विद्वान लोग 'भोक्ता' (सुख-दुख भोगने वाला) कहते हैं।
            यह श्लोक रथ के रूपक को पूरा करता है और हमारे भटकाव (Distraction) का असली कारण बताता है।
            इंद्रियां वे जंगली घोड़े हैं जो हमेशा अपनी पसंद के रास्तों (सुंदर रूप, मीठा स्वाद) की ओर भागने के लिए बेताब रहते हैं।
            अगर घोड़े (इंद्रियां) ताकतवर हों और रास्ते (विषय) लुभावने हों, तो एक कमजोर ड्राइवर (बुद्धि) उन्हें कभी नहीं रोक सकता।
            आत्मा स्वभाव से 'साक्षी' है, पर जब वह मन और इंद्रियों के साथ जुड़ जाती है, तो वह 'भोक्ता' बन जाती है।
            वह सोचने लगती है कि "मैं खा रहा हूँ" या "मैं देख रहा हूँ", और इसी मिलावट के कारण वह दुखी होती है।
            हमें घोड़ों को मारना नहीं है, बल्कि उन्हें सही रास्ते (मोक्ष) की ओर मोडना है।
            यह रूपक बहुत ही मनोवैज्ञानिक (Psychological) है, जो दिखाता है कि इंसान का अंदरूनी सिस्टम कैसे काम करता है।
        """.trimIndent(),
        english = """
            The wise declare our five senses (eyes, ears, etc.) to be the powerful 'horses' (Haya) pulling this chariot of the body.
            And the objects of the world (form, sound, taste) are the 'paths' (Gochara/roads) on which these wild horses fiercely run.
            When the Soul is completely united (Yukt) with the body, senses, and mind, the wise call it the 'Enjoyer' (Bhokta).
            This verse completes the grand chariot metaphor and reveals the absolute root cause of our worldly distractions.
            The senses are wild horses desperately eager to sprint towards their favorite, enticing paths (beautiful forms, sweet tastes).
            If the horses (senses) are overwhelmingly strong and the paths highly alluring, a weak driver (intellect) can never stop them.
            The Soul by nature is a 'Witness', but when perfectly entangled with the mind and senses, it transforms into the 'Enjoyer'.
            It falsely begins to think "I am eating" or "I am seeing", and suffers immensely purely due to this false mixture.
            We are absolutely not supposed to kill the horses, but rather expertly steer them towards the right path (Moksha).
            This metaphor is deeply psychological, flawlessly illustrating exactly how the internal system of a human being operates.
        """.trimIndent()
    ),
    KathaShloka(
        id = 59,
        sanskrit = "यस्त्वविज्ञानवान्भवत्ययुक्तेन मनसा सदा । तस्येन्द्रियाण्यवश्यानि दुष्टाश्वा इव सारथेः ॥ ५ ॥",
        hindi = """
            जो मनुष्य अज्ञानी (अविज्ञानवान्) है, और जिसका अपनी बुद्धि पर नियंत्रण नहीं है।
            तथा जिसका मन हमेशा चंचल रहता है और लगाम (अयुक्तेन मनसा) के रूप में उसके वश में बिल्कुल नहीं रहता।
            उस अज्ञानी मनुष्य की इंद्रियां कभी भी उसके नियंत्रण (अवश्यानि) में नहीं रहती हैं।
            उसकी हालत ठीक वैसी ही होती है जैसे किसी अकुशल सारथी (ड्राइवर) के अनियंत्रित और दुष्ट घोड़े (दुष्टाश्वा) बेकाबू हो जाते हैं।
            यह श्लोक एक ऐसे इंसान की तस्वीर पेश करता है जिसका 'ड्राइवर' (बुद्धि) नशे में है या सो रहा है।
            जब बुद्धि (विवेक) कमजोर होती है, तो मन (लगाम) अपने-आप ढीला पड़ जाता है।
            और जब लगाम ढीली होती है, तो इंद्रियां (घोड़े) अपनी मर्जी से जहाँ चाहे भागने लगते हैं (लालच, वासना, क्रोध की ओर)।
            ऐसे रथ (शरीर) का एक्सीडेंट होना तय है; वह इंसान कभी अपनी मंजिल (शांति) तक नहीं पहुँच पाता।
            वह अपनी ही आदतों (Habits) और इच्छाओं का गुलाम बन जाता है और जीवन भर दुख के गड्ढों में गिरता रहता है।
            योग कोई बाहरी जादू नहीं है; यह अपने ही भीतर के ड्राइवर को जगाने और घोड़ों को कंट्रोल करने की कला है।
        """.trimIndent(),
        english = """
            That person who is utterly ignorant (Avijnanavan) and completely lacks proper control over his intellect.
            And whose mind is perpetually restless, never firmly held in check like proper, tightened reins (Ayuktena manasa).
            The senses of such an extremely ignorant man never, ever remain under his control (Avashyani).
            His pathetic condition is exactly like the wild, wicked, and completely uncontrollable horses (Dushtashva) of a highly unskillful charioteer.
            This verse paints a perfect picture of a human being whose 'driver' (intellect) is completely drunk or fast asleep.
            When the intellect (discrimination) is terribly weak, the mind (reins) automatically becomes dangerously loose.
            And when the reins are loose, the senses (horses) sprint wildly wherever they please (towards greed, lust, and blinding anger).
            A chariot (body) in such a state is absolutely guaranteed to crash; that person can never reach his ultimate destination (peace).
            He becomes a pathetic slave to his own toxic habits and desires, continuously tumbling into the deep ditches of misery all his life.
            Yoga is no external magic; it is the supreme art of waking up the inner driver and mastering one's own wild horses.
        """.trimIndent()
    ),
    KathaShloka(
        id = 60,
        sanskrit = "यस्तु विज्ञानवान्भवति युक्तेन मनसा सदा । तस्येन्द्रियाणि वश्यानि सदश्वा इव सारथेः ॥ ६ ॥",
        hindi = """
            परंतु इसके विपरीत, जो मनुष्य विवेकशील और ज्ञानी (विज्ञानवान्) होता है, जिसकी बुद्धि हमेशा जागृत रहती है।
            और जिसका मन हमेशा एकाग्र रहता है तथा एक कसी हुई मजबूत लगाम (युक्तेन मनसा) की तरह उसके पूरी तरह वश में रहता है।
            उस ज्ञानी मनुष्य की सभी इंद्रियां हमेशा उसके पूर्ण नियंत्रण और वश (वश्यानि) में रहती हैं।
            ठीक उसी प्रकार जैसे किसी अत्यंत कुशल सारथी (ड्राइवर) के अच्छे और सधे हुए घोड़े (सदश्वा) उसके इशारे पर चलते हैं।
            यह एक सफल योगी और एक संतुलित इंसान (Balanced person) का चित्र है।
            जब बुद्धि (विवेक) तेज होती है, तो वह जानती है कि क्या सही है और क्या गलत; वह गलत रास्तों पर नहीं जाती।
            एक जागृत बुद्धि मन रूपी लगाम को हमेशा कसकर पकड़ कर रखती है, उसे ढीला नहीं छोड़ती।
            परिणामस्वरूप, इंद्रियां (घोड़े) अनुशासित (सदश्वा) बन जाती हैं और केवल वहीं जाती हैं जहाँ मालिक (आत्मा) चाहता है।
            इंद्रियों को काबू करने का मतलब उन्हें अंधा या बहरा करना नहीं है, बल्कि उनकी ऊर्जा का सही दिशा में इस्तेमाल करना है।
            जो अपने मन का राजा बन जाता है, दुनिया की कोई भी परिस्थिति या दुख उसे डगमगा नहीं सकता।
        """.trimIndent(),
        english = """
            But on the absolute contrary, the person who is profoundly discerning and wise (Vijnanavan), whose intellect is always wide awake.
            And whose mind is perpetually concentrated, remaining fully under his control like tight, strong reins (Yuktena manasa).
            All the physical senses of that wise man remain constantly and perfectly under his absolute control (Vashyani).
            Exactly in the same way as the well-trained, noble, and good horses (Sadashva) obey every single gesture of an expert charioteer.
            This is the perfect portrait of a highly successful yogi and an exceptionally balanced, enlightened human being.
            When the intellect (discrimination) is sharp, it knows exactly what is right and wrong; it never strays onto false paths.
            An awakened intellect tightly holds the reins of the mind at all times, absolutely never letting them slip loose.
            Consequently, the senses (horses) become highly disciplined (Sadashva) and travel only where the supreme Master (Soul) desires.
            Controlling the senses absolutely does not mean blinding or deafening them, but expertly channeling their energy in the right direction.
            He who successfully becomes the undisputed King of his own mind can never be shaken by any worldly circumstance or sorrow.
        """.trimIndent()
    ),
    KathaShloka(
        id = 61,
        sanskrit = "यस्त्वविज्ञानवान्भवत्यमनस्कः सदाऽशुचिः । न स तत्पदमाप्नोति संसारं चाधिगच्छति ॥ ७ ॥",
        hindi = """
            जो मनुष्य हमेशा विवेकहीन (अविज्ञानवान्) रहता है, और जिसका अपने मन पर बिल्कुल भी नियंत्रण नहीं है (अमनस्कः)।
            और जो विचारों और कर्मों से हमेशा मलिन (अशुचि/अपवित्र) रहता है।
            वह मनुष्य जीवन के उस परम लक्ष्य (मोक्ष रूपी पद) को कभी भी प्राप्त नहीं कर पाता है।
            बल्कि वह बार-बार जन्म और मृत्यु के इस दुखदायी चक्र (संसार) में ही फँसता चला जाता है (संसारं चाधिगच्छति)।
            अज्ञान केवल जानकारी की कमी नहीं है; यह बुद्धि का वह अंधापन है जो हमें गलत को सही मानने पर मजबूर करता है।
            'अमनस्क' का अर्थ है जिसका मन उसके पास नहीं है, बल्कि हमेशा बाहरी वासनाओं में भटक रहा है।
            जब मन गंदे विचारों से भरा हो, तो शरीर चाहे कितना भी नहा ले, वह अंदर से 'अशुचि' (अपवित्र) ही रहता है।
            परमात्मा अत्यंत शुद्ध है; इसलिए अपवित्र मन वाले व्यक्ति के लिए उस परम पद का दरवाजा हमेशा बंद रहता है।
            यमराज स्पष्ट चेतावनी देते हैं कि भगवान की अदालत में कोई रिश्वत या सिफारिश काम नहीं आती; केवल मन की शुद्धि देखी जाती है।
            जो इस जीवन में अपने रथ (शरीर/मन) को नहीं सुधारता, उसे फिर से एक नया रथ (पुनर्जन्म) देकर इसी दुनिया में धकेल दिया जाता है।
        """.trimIndent(),
        english = """
            That person who always remains utterly devoid of discrimination (Avijnanavan), having absolutely no control over his mind (Amanaskah).
            And who perpetually remains deeply impure and tainted (Ashuchi) in his thoughts, intentions, and worldly actions.
            That human being never, ever attains that supreme, ultimate goal of life (the exalted state of Moksha).
            Instead, he relentlessly falls and gets trapped over and over again into this miserable cycle of birth and death (Samsara).
            Ignorance is not a mere lack of information; it is the sheer blindness of the intellect that forces us to accept wrong as right.
            'Amanaska' means one whose mind is not with him, but is perpetually wandering and lost in external, worldly lusts.
            When the mind is polluted with toxic thoughts, no matter how much the body bathes, it remains internally 'Ashuchi' (impure).
            The Supreme Lord is absolutely pure; hence, the door to that highest state always remains firmly shut for a person with an impure mind.
            Yama gives a stark warning: no bribe or recommendation works in God's court; only the absolute purity of the mind is evaluated.
            He who fails to fix his chariot (body/mind) in this life is simply shoved back into this world with a brand-new chariot (rebirth).
        """.trimIndent()
    ),
    KathaShloka(
        id = 62,
        sanskrit = "यस्तु विज्ञानवान्भवति समनस्कः सदा शुचिः । स तु तत्पदमाप्नोति यस्माद्भूयो न जायते ॥ ८ ॥",
        hindi = """
            परंतु इसके विपरीत, जो मनुष्य अत्यंत विवेकशील और ज्ञानी (विज्ञानवान्) होता है।
            जिसका मन हमेशा उसके पूर्ण नियंत्रण (समनस्कः) में रहता है, और जो विचारों तथा आचरण से हमेशा पवित्र (शुचि) रहता है।
            वह साधक निश्चित रूप से उस परम लक्ष्य (ईश्वर के परम पद) को प्राप्त कर लेता है।
            उस परम अवस्था को पा लेने के बाद उसे इस दुख भरे संसार में फिर कभी दुबारा जन्म नहीं लेना पड़ता (न जायते)।
            यह श्लोक योग के सबसे अंतिम परिणाम (Final Result) की घोषणा करता है: जन्म-मरण के चक्र से पूर्ण आज़ादी।
            ज्ञान का मतलब यहाँ वेदों को रटना नहीं है, बल्कि अपने रथ (शरीर) के एक-एक पुर्जे (Part) को पहचानना और कंट्रोल करना है।
            शुचिता (Purity) केवल नहाने से नहीं, बल्कि दूसरों के प्रति प्रेम, क्षमा और निःस्वार्थ कर्मों से आती है।
            जब मन एक शीशे की तरह बिल्कुल साफ और स्थिर हो जाता है, तभी उसमें परमात्मा का असली अक्स (Reflection) दिखाई देता है।
            'फिर जन्म न लेने' का अर्थ यह नहीं कि वह मिट जाता है; इसका अर्थ है कि वह उस शाश्वत अनंतता का हमेशा के लिए हिस्सा बन जाता है।
            यही उपनिषदों की सबसे बड़ी उपलब्धि (Achievement) है, जहाँ इंसान भगवान के स्तर (Level) तक उठ जाता है।
        """.trimIndent(),
        english = """
            But on the absolute contrary, the person who is exceptionally discerning, wise, and highly enlightened (Vijnanavan).
            Whose mind is perpetually under his absolute, unwavering control (Samanaskah), and who remains eternally pure in thoughts and conduct (Shuchi).
            That true seeker undoubtedly and certainly attains that ultimate, supreme goal (the highest state of the Lord).
            Having successfully attained that supreme state, he is never forced to take birth (Na jayate) in this miserable world ever again.
            This verse boldly declares the absolute final result of Yoga: total and permanent freedom from the vicious cycle of birth and death.
            Wisdom here does not mean cramming the Vedas, but profoundly recognizing and controlling every single part of one's chariot (body).
            Purity (Shuchita) doesn't come merely from bathing, but strictly from boundless love, forgiveness, and totally selfless actions toward others.
            Only when the mind becomes as impeccably clean and perfectly still as a pristine mirror, does the true reflection of God appear in it.
            'Not taking birth again' does not mean he is annihilated; it means he permanently becomes an inseparable part of that eternal Infinity.
            This is the ultimate, crowning achievement of the Upanishads, where a mere human rises directly to the absolute level of God Himself.
        """.trimIndent()
    ),
    KathaShloka(
        id = 63,
        sanskrit = "विज्ञानसारथिर्यस्तु मनःप्रग्रहवान्नरः । सोऽध्वनः पारमाप्नोति तद्विष्णोः परमं पदम् ॥ ९ ॥",
        hindi = """
            जो मनुष्य अपनी शुद्ध और जागृत बुद्धि को अपने जीवन के रथ का सारथी (ड्राइवर/विज्ञानसारथि) बनाता है।
            और जो अपने मन रूपी लगाम को बहुत मजबूती और सावधानी से अपने हाथों में पकड़ कर (प्रग्रहवान्) रखता है।
            वह मनुष्य इस संसार रूपी यात्रा (रास्ते) के अंतिम किनारे (पारम्) तक सुरक्षित पहुँच जाता है।
            और वह किनारा साक्षात् सर्वव्यापी भगवान विष्णु (परमात्मा) का वह परम पद है, जो सभी का अंतिम लक्ष्य है।
            रथ का रूपक यहाँ अपने सबसे खूबसूरत निष्कर्ष (Conclusion) पर पहुँचता है।
            यात्रा बहुत लंबी और खतरनाक है, रास्ते में गड्ढे हैं (माया के प्रलोभन), पर यदि बुद्धि होशियार है, तो डरने की कोई बात नहीं।
            'विष्णु' का अर्थ है जो हर जगह व्यापक है; वह कोई आसमान में बैठा व्यक्ति नहीं, बल्कि ब्रह्मांड की सर्वव्यापी चेतना है।
            परम पद कोई भौतिक स्थान नहीं, बल्कि चेतना की वह सबसे ऊँची अवस्था (Supreme State) है जहाँ केवल पूर्ण शांति है।
            बुद्धि को गुरु बनाओ और मन को नौकर; यदि मन गुरु बन गया, तो जीवन का विनाश निश्चित है।
            यह श्लोक हमें जीवन जीने का सबसे प्रैक्टिकल और शानदार मैनेजमेंट (Management) मंत्र देता है।
        """.trimIndent(),
        english = """
            That person who makes his pure and fully awakened intellect the supreme charioteer (driver) of his life's chariot.
            And who holds the reins of his mind extremely tightly, carefully, and firmly in his own hands (Pragrahavan).
            That person safely and successfully reaches the absolute end (Param/farthest shore) of this difficult worldly journey (path).
            And that ultimate shore is the direct, supreme abode (Paramam Padam) of the all-pervading Lord Vishnu (Supreme God).
            The grand chariot metaphor reaches its most extraordinarily beautiful and satisfying conclusion right here.
            The journey is exceedingly long and dangerous, with deep ditches (temptations of Maya), but if the intellect is alert, there is no fear.
            'Vishnu' means the one who is all-pervading; He is not a person sitting in the sky, but the omnipresent consciousness of the cosmos.
            The supreme abode is not a physical location, but that highest, absolute state of consciousness where there is only perfect peace.
            Make your intellect the Master and your mind the servant; if the mind becomes the master, total destruction of life is guaranteed.
            This verse provides us with the most practical, brilliant, and ultimate Management mantra for living a highly successful life.
        """.trimIndent()
    ),
    KathaShloka(
        id = 64,
        sanskrit = "इन्द्रियेभ्यः परा ह्यर्था अर्थेभ्यश्च परं मनः । मनसस्तु परा बुद्धिर्बुद्धेरात्मा महान्परः ॥ १० ॥",
        hindi = """
            (यमराज अब सृष्टि के सूक्ष्म स्तरों का क्रम बताते हैं): हमारी इंद्रियों (आँख, कान आदि) से बाहरी विषय (रूप, शब्द आदि) अधिक सूक्ष्म और श्रेष्ठ (पर) हैं।
            उन विषयों से भी अत्यंत सूक्ष्म, श्रेष्ठ और बलवान हमारा 'मन' है (क्योंकि मन के बिना इंद्रियां विषयों को ग्रहण नहीं कर सकतीं)।
            परंतु इस चंचल मन से भी अधिक श्रेष्ठ, सूक्ष्म और ताकतवर हमारी 'बुद्धि' (निश्चय करने वाली शक्ति) है।
            और उस बुद्धि से भी अत्यंत श्रेष्ठ, सूक्ष्म और महान 'आत्मा' (हिरण्यगर्भ / समष्टि बुद्धि) है।
            यह श्लोक भारतीय मनोविज्ञान (Psychology) और ब्रह्मांड विज्ञान (Cosmology) की गहरी परतें (Layers) खोलता है।
            हमें लगता है कि शरीर सबसे ताकतवर है, पर एक छोटा सा विचार (मन) शरीर को हिला सकता है।
            मन हमेशा विषयों की ओर भागता है, पर जब 'बुद्धि' आदेश देती है, तो मन को रुकना पड़ता है, इसलिए बुद्धि बड़ी है।
            परंतु बुद्धि भी अपने-आप काम नहीं करती; उसे प्रकाश उस 'महान आत्मा' (समष्टि चेतना) से मिलता है जो सबसे पीछे खड़ी है।
            साधक को ध्यान में इसी क्रम (Order) से वापस लौटना होता है: इंद्रियों को मन में, मन को बुद्धि में, और बुद्धि को आत्मा में समेटना होता है।
            यह स्थूल (Gross) से सूक्ष्म (Subtle) की ओर जाने की एक अत्यंत वैज्ञानिक और सटीक यात्रा है।
        """.trimIndent(),
        english = """
            (Yama explains the hierarchy of subtle levels): The external sense-objects (forms, sounds) are much subtler and higher (Para) than our senses.
            Our 'mind' is far subtler, higher, and more powerful than those external sense-objects (without the mind, senses cannot perceive).
            But our 'intellect' (the determining power) is far superior, subtler, and infinitely more powerful than this restless mind.
            And the 'Great Soul' (Hiranyagarbha/Cosmic Intellect) is absolutely superior, subtler, and far higher than the individual intellect.
            This verse completely unwraps the profound layers of ancient Indian Psychology and deep Vedic Cosmology.
            We falsely think the physical body is the strongest, but a tiny, invisible thought (mind) can drastically shake the entire body.
            The mind constantly runs towards objects, but when the 'intellect' commands, the mind must stop; hence the intellect is greater.
            However, the intellect does not work on its own; it receives its light entirely from that 'Great Soul' standing silently behind it.
            In meditation, the seeker must retreat exactly in this order: merge senses into mind, mind into intellect, and intellect into the Soul.
            This is an exceptionally scientific and precise inward journey traveling directly from the Gross (physical) to the absolute Subtle.
        """.trimIndent()
    ),
    KathaShloka(
        id = 65,
        sanskrit = "महतः परमव्यक्तमव्यक्तात्पुरुषः परः । पुरुषान्न परं किञ्चित्सा काष्ठा सा परा गतिः ॥ ११ ॥",
        hindi = """
            उस 'महान आत्मा' (समष्टि बुद्धि) से भी अत्यंत सूक्ष्म और श्रेष्ठ 'अव्यक्त' (मूल प्रकृति / माया / कारण अवस्था) है।
            और उस अव्यक्त प्रकृति से भी अत्यंत श्रेष्ठ, सूक्ष्म और परे वह परम 'पुरुष' (परमात्मा) है।
            उस परम पुरुष (परमात्मा) से परे या उससे बड़ा इस पूरे ब्रह्मांड में कुछ भी (किञ्चित्) नहीं है।
            वही सबसे अंतिम सीमा (काष्ठा) है, और वही सभी जीवों की परम और अंतिम गति (मंजिल) है।
            यह श्लोक सृष्टि की अंतिम गहराई (Final depth) तक पहुँच कर वहां रुक जाता है।
            अव्यक्त का मतलब है वह बीज (Seed) अवस्था जहाँ से पूरा ब्रह्मांड पैदा होता है (जैसे नींद में हमारे विचार अव्यक्त हो जाते हैं)।
            पर वह बीज भी अपने-आप नहीं उगता; उसे ऊर्जा देने वाला वह 'परम पुरुष' (शुद्ध चेतना) ही सबसे अंतिम सत्य है।
            विज्ञान (Science) अक्सर ऊर्जा या पदार्थ (Matter) पर आकर रुक जाता है, पर उपनिषद कहता है कि पदार्थ से परे 'चेतना' है।
            पुरुष से परे कुछ नहीं है (पुरुषान्न परं किञ्चित्); वह फुलस्टॉप (Full Stop) है, वह एब्सोल्यूट (Absolute) है।
            जो व्यक्ति उस पुरुष तक पहुँच जाता है, उसकी यात्रा हमेशा के लिए खत्म हो जाती है; वही जीवन की अंतिम और सबसे महान मंजिल है।
        """.trimIndent(),
        english = """
            The 'Unmanifest' (Avyakta / Root Nature / Causal State) is subtler and infinitely higher than that 'Great Soul'.
            And that Supreme 'Purusha' (God/Absolute Consciousness) is exceedingly superior, subtler, and far beyond even that Unmanifest Nature.
            There is absolutely nothing (whatsoever) in this entire cosmos that is higher than or beyond that Supreme Purusha.
            He is the absolute ultimate limit (Kastha), and He alone is the supreme, final destination (Gati) of all living beings.
            This verse reaches the absolute, final depth of cosmic creation and beautifully comes to a complete halt there.
            Avyakta means that causal seed state from which the universe is born (just as thoughts become unmanifest during deep sleep).
            But even that seed doesn't sprout on its own; that 'Supreme Purusha' (Pure Consciousness) energizing it is the final Truth.
            Science often stops at energy or physical matter, but the Upanishad boldly declares that 'Consciousness' exists far beyond matter.
            There is nothing beyond the Purusha; He is the ultimate Full Stop, He is the undeniable Absolute.
            The person who successfully reaches that Purusha completely ends his journey forever; that is life's ultimate and greatest destination.
        """.trimIndent()
    ),
    KathaShloka(
        id = 66,
        sanskrit = "एष सर्वेषु भूतेषु गूढोऽऽत्मा न प्रकाशते । दृश्यते त्वग्र्यया बुद्ध्या सूक्ष्मया सूक्ष्मदर्शिभिः ॥ १२ ॥",
        hindi = """
            यह परम आत्मा संसार के सभी छोटे-बड़े प्राणियों के भीतर अत्यंत गहराई से छिपा (गूढ़) हुआ है, इसलिए यह सबको स्पष्ट दिखाई नहीं देता (न प्रकाशते)।
            अज्ञानी और चंचल मन वाले लोग इस आत्मा को कभी नहीं देख सकते, क्योंकि यह भौतिक आँखों का विषय नहीं है।
            परंतु जो लोग सूक्ष्मदर्शी हैं (चीजों की गहराई में देखने वाले ज्ञानी), वे इसे प्रत्यक्ष देख लेते हैं।
            वे अपनी अत्यंत एकाग्र (अग्र्यया), तीक्ष्ण और अत्यंत सूक्ष्म (सूक्ष्मया) बुद्धि के द्वारा इस आत्मा का साक्षात् दर्शन कर लेते हैं।
            ईश्वर ने खुद को कहीं आसमान में नहीं, बल्कि हमारे ही भीतर इस तरह छिपाया है कि वह आसानी से न मिले।
            यह कोई लुका-छिपी का खेल नहीं है; यह योग्यता (Qualification) की परीक्षा है कि कौन उसे ढूँढने के लिए मेहनत करता है।
            मोटी बुद्धि केवल पैसे, कपड़े और शरीर (स्थूल चीजों) को ही देख और समझ सकती है।
            आत्मा को देखने के लिए बुद्धि को लेजर बीम (Laser beam) की तरह अत्यंत पैना (Sharp) और फोकस (Focused) करना पड़ता है।
            जब ध्यान के द्वारा मन की सारी फालतू लहरें शांत हो जाती हैं, तब बुद्धि इतनी सूक्ष्म हो जाती है कि वह आत्मा के प्रकाश को पकड़ लेती है।
            यह श्लोक सिद्ध करता है कि आत्मज्ञान कोई चमत्कार नहीं, बल्कि एक अत्यंत वैज्ञानिक और सूक्ष्म मानसिक प्रक्रिया है।
        """.trimIndent(),
        english = """
            This Supreme Soul is profoundly hidden (Gudha) deep within all living beings, therefore He does not shine clearly to everyone (Na prakashate).
            Ignorant people with restless minds can never see this Soul, because it is absolutely not a subject for physical eyes.
            However, those who are subtle-seers (wise sages who perceive the ultimate depths of reality) see Him directly.
            They directly behold this Soul through their exceedingly concentrated (Agryaya), razor-sharp, and highly subtle (Sukshmaya) intellect.
            God hasn't hidden Himself in some distant sky, but right within us in such a profound way that He isn't found easily.
            This is not a game of hide-and-seek; it is a strict test of qualification to see who works hard enough to find Him.
            A gross, dull intellect can only see and comprehend money, clothes, and physical bodies (gross material things).
            To see the Soul, the intellect must be made exceptionally sharp and flawlessly focused exactly like a powerful laser beam.
            When all useless ripples of the mind are calmed through meditation, the intellect becomes subtle enough to catch the Soul's light.
            This verse proves that Self-realization is not a cheap miracle, but an extremely scientific and subtle mental process.
        """.trimIndent()
    ),
    KathaShloka(
        id = 67,
        sanskrit = "यच्छेद्वाङ्मनसी प्राज्ञस्तद्यच्छेज्ज्ञान आत्मनि । ज्ञानमात्मनि महति नियच्छेत्तद्यच्छेच्छान्त आत्मनि ॥ १३ ॥",
        hindi = """
            (यमराज अब ध्यान की पूरी प्रक्रिया बताते हैं): बुद्धिमान साधक (प्राज्ञ) को चाहिए कि वह अपनी वाणी (और सभी इंद्रियों) को अपने मन में विलीन (यच्छेत्) कर दे।
            फिर उस मन को वह अपनी ज्ञानात्मक बुद्धि (ज्ञान-आत्मा) में अच्छी तरह से विलीन और शांत कर दे।
            उस बुद्धि को वह 'महान आत्मा' (समष्टि बुद्धि / हिरण्यगर्भ) में पूरी तरह से समेट कर लीन कर दे।
            और अंत में, उस महान आत्मा को भी वह परम शांत, अद्वैत और निर्विकार 'परमात्मा' (शांत आत्मनि) में विलीन कर दे।
            यह श्लोक पतंजलि योग सूत्र से भी बहुत पहले का है और ध्यान (Meditation) का सबसे पक्का ब्लूप्रिंट (Blueprint) है।
            ध्यान बाहर से अंदर की ओर लौटने की एक क्रमिक (Step-by-step) यात्रा है।
            सबसे पहले बोलना बंद करो और शरीर को स्थिर करो (वाणी को मन में डालो)।
            फिर चंचल विचारों को रोको और केवल एक निश्चय पर टिको (मन को बुद्धि में डालो)।
            फिर अपनी छोटी सी 'मैं' (Individual ego) को हटाकर पूरे ब्रह्मांड की चेतना के साथ जुड़ जाओ (बुद्धि को महान आत्मा में)।
            और सबसे अंत में, उस ब्रह्मांडीय अनुभव को भी छोड़कर पूर्ण शून्यता और परमानंद (परमात्मा) में डूब जाओ।
        """.trimIndent(),
        english = """
            (Yama now explains the complete process of meditation): A wise seeker (Prajna) should merge (Yacchet) his speech (and all senses) completely into his mind.
            Then he should thoroughly merge and still that mind into his knowing intellect (Jnana-Atman).
            He should then completely gather and merge that intellect into the 'Great Soul' (Cosmic Intellect / Hiranyagarbha).
            And finally, he should merge even that Great Soul entirely into the supremely peaceful, non-dual 'Supreme Lord' (Shanta Atmani).
            This verse predates the Patanjali Yoga Sutras and is the most infallible and absolute blueprint of true Meditation.
            Meditation is a highly systematic, step-by-step inward journey retreating from the outside world.
            First, stop speaking completely and make the body perfectly still (merging speech into the mind).
            Next, stop all restless thoughts and fixate solely on one firm resolve (merging the mind into the intellect).
            Then, completely drop your petty 'I' (individual ego) and connect with universal consciousness (intellect into Great Soul).
            And finally, leaving even that cosmic experience behind, plunge completely into absolute void and supreme bliss (God).
        """.trimIndent()
    ),

    KathaShloka(
        id = 68,
        sanskrit = "उत्तिष्ठत जाग्रत प्राप्य वरान्निबोधत । क्षुरस्य धारा निशिता दुरत्यया दुर्गं पथस्तत्कवयो वदन्ति ॥ १४ ॥",
        hindi = """
            हे अज्ञान की नींद में सोए हुए मनुष्यो! उठो (उत्तिष्ठत), अज्ञान की नींद से जागो (जाग्रत)।
            श्रेष्ठ और ज्ञानी गुरुओं (वरान्) के पास जाकर इस आत्मज्ञान को भलीभांति समझो और प्राप्त करो (निबोधत)।
            ज्ञानी पुरुष (कवि) कहते हैं कि इस आत्मज्ञान का मार्ग बहुत ही दुर्गम (कठिन) और खतरनाक है।
            यह मार्ग उस्तरे (रेज़र/क्षुर) की अत्यंत पैनी और तेज धार पर चलने के समान ही मुश्किल (दुरत्यया) है।
            स्वामी विवेकानंद का सबसे प्रसिद्ध नारा "उठो, जागो और लक्ष्य तक मत रुको" इसी श्लोक से प्रेरित है।
            हम खुली आँखों से दुनिया में घूम रहे हैं, पर उपनिषद कहता है कि आध्यात्मिक रूप से हम सब खर्राटे मार कर सो रहे हैं।
            भगवान को जानने का रास्ता फूलों की सेज नहीं है; यह अहंकार को काटने वाला उस्तरा (Razor) है।
            थोड़ी सी भी असावधानी, थोड़ा सा भी लालच या घमंड आपको इस रास्ते से तुरंत नीचे गिरा कर लहूलुहान कर सकता है।
            गुरु (वरान्) के पास जाना जरूरी है क्योंकि इस अंधेरे रास्ते पर बिना गाइड (Guide) के चलना साक्षात मौत है।
            यह श्लोक एक महान अलार्म क्लॉक (Alarm clock) है जो पूरी मानवता को उसकी गहरी बेहोशी से झकझोर कर जगाता है।
        """.trimIndent(),
        english = """
            O human beings sleeping in the deep slumber of ignorance! Arise (Uttishthata), awake from the sleep of ignorance (Jagrata).
            Approach the great, realized Gurus (Varan) and thoroughly understand and attain this ultimate Self-knowledge (Nibodhata).
            The wise, enlightened sages (Kavayah) declare that the path of this Self-realization is exceedingly difficult and highly dangerous.
            This spiritual path is as treacherous and hard to cross (Duratyaya) as walking on the extremely sharpened edge of a razor (Kshura).
            Swami Vivekananda's most famous slogan, "Arise, awake, and stop not till the goal is reached," is directly inspired by this verse.
            We wander the world with open eyes, but the Upanishad declares that spiritually, we are all snoring in a deep sleep.
            The path to knowing God is not a bed of roses; it is a razor blade that ruthlessly cuts down the human ego.
            Even the slightest carelessness, a tiny bit of greed, or arrogance can instantly make you fall and bleed on this path.
            Approaching a Guru (Varan) is absolutely mandatory because walking this dark path without a guide is sheer suicide.
            This verse acts as a colossal cosmic alarm clock, aggressively shaking and waking up all of humanity from its deep unconsciousness.
        """.trimIndent()
    ),
    KathaShloka(
        id = 69,
        sanskrit = "अशब्दमस्पर्शमरूपमव्ययं तथाऽरसं नित्यमगन्धवच्च यत् । अनाद्यनन्तं महतः परं ध्रुवं निचाय्य तन्मृत्युमुखात् प्रमुच्यते ॥ १५ ॥",
        hindi = """
            वह परमात्मा अशब्द (जिसका कोई शब्द/आवाज़ नहीं), अस्पर्श (जिसे छुआ नहीं जा सकता) और अरूप (जिसका कोई आकार नहीं) है।
            वह अव्यय (कभी खर्च न होने वाला), अरस (जिसका कोई स्वाद नहीं) और अगन्ध (जिसकी कोई महक नहीं) है, वह नित्य है।
            वह अनादि (शुरुआत-रहित) है, अनंत है, महान आत्मा से भी परे है और हमेशा अचल (ध्रुव) है।
            उस परम तत्व को जो साधक प्रत्यक्ष रूप से जान (निचाय्य) लेता है, वह मृत्यु के भयानक मुख से हमेशा के लिए मुक्त हो जाता है।
            हमारी इंद्रियां केवल शब्द, स्पर्श, रूप, रस और गंध को ही पकड़ सकती हैं; ईश्वर इन पांचों से पूरी तरह बाहर है।
            इसलिए कोई भी वैज्ञानिक उपकरण (Instrument) भगवान को कभी नहीं नाप सकता, क्योंकि उपकरण केवल पदार्थ (Matter) को नापते हैं।
            ईश्वर भौतिक नहीं है, वह शुद्ध चेतना है जो समय (अनादि-अनंत) और आकार (अरूप) की सीमाओं को तोड़ देती है।
            जब इंसान उस तत्व को जान लेता है जिसका कभी जन्म नहीं हुआ, तो वह जान जाता है कि उसकी मौत भी कभी नहीं हो सकती।
            मृत्यु का मुख केवल उसी को निगलता है जो खुद को यह मांस का शरीर मानता है।
            यह श्लोक अद्वैत वेदान्त का सबसे परिष्कृत (Refined) मंत्र है, जो ईश्वर को सभी भौतिक गुणों (Neti Neti) से मुक्त करता है।
        """.trimIndent(),
        english = """
            That Supreme Lord is soundless (Ashabda), absolutely intangible (Asparsha), and entirely formless (Arupa).
            He is imperishable/inexhaustible (Avyaya), completely tasteless (Arasa), eternally constant (Nitya), and odorless (Agandha).
            He is without beginning (Anadi), without end (Ananta), far beyond the Great Soul, and forever steadfast (Dhruva).
            The seeker who directly realizes (Nichayya) that Supreme Principle is completely liberated from the terrifying jaws of death forever.
            Our senses can only grasp sound, touch, form, taste, and smell; God exists entirely and absolutely outside these five.
            Therefore, no scientific instrument can ever measure God, because instruments strictly measure only physical matter.
            God is not physical; He is pure, unadulterated consciousness that completely shatters the boundaries of time and physical form.
            When a human realizes that Principle which was never born, he instantly knows that he can never possibly die.
            The jaws of death exclusively swallow only those who foolishly consider themselves to be this perishable body of flesh.
            This verse is the most highly refined mantra of Advaita Vedanta, completely stripping God of all physical attributes (Neti Neti).
        """.trimIndent()
    ),
    KathaShloka(
        id = 70,
        sanskrit = "नाचिकेतमुपाख्यानं मृत्युप्रोक्तँ सनातनम् । उक्त्वा श्रुत्वा च मेधावी ब्रह्मलोके महीयते ॥ १६ ॥",
        hindi = """
            (उपनिषद की फलश्रुति / महिमा): यह नचिकेता की अत्यंत पवित्र और महान कथा (उपाख्यान) है।
            इसे साक्षात् मृत्यु के देवता यमराज ने स्वयं कहा था (मृत्युप्रोक्तं), और यह कथा अत्यंत सनातन (शाश्वत सत्य से भरी) है।
            जो मेधावी (बुद्धिमान) पुरुष इस परम रहस्यमयी कथा को दूसरों को सुनाता (उक्त्वा) है।
            या जो इसे पूरी श्रद्धा के साथ किसी ज्ञानी से सुनता (श्रुत्वा) है, वह ब्रह्मलोक में अत्यंत महिमावान (पूजनीय) हो जाता है।
            यहाँ कठोपनिषद का मुख्य दार्शनिक भाग (प्रथम अध्याय) समाप्त होता है, और इसके पाठ का फल बताया जा रहा है।
            यह कोई साधारण कहानी नहीं है जिसे मनोरंजन के लिए पढ़ा जाए; यह जीवन और मौत के सबसे बड़े रहस्य की चाबी है।
            यमराज (मृत्यु) खुद जिंदगी का रहस्य बता रहे हैं, इससे बड़ा प्रामाणिक (Authentic) ज्ञान और क्या हो सकता है?
            इस कथा को सुनने या सुनाने मात्र से इंसान का मन शुद्ध हो जाता है और उसके भीतर वैराग्य जाग उठता है।
            'ब्रह्मलोक में महिमावान' होने का अर्थ यह है कि उसे जीते-जी ईश्वर की समीपता का अहसास होने लगता है।
            जो ज्ञान नचिकेता को मिला था, वही ज्ञान इस कथा के माध्यम से आज हर उस इंसान को मिल सकता है जो इसे पढ़ेगा।
        """.trimIndent(),
        english = """
            (The glory/fruits of the Upanishad): This is the exceedingly sacred and magnificently great story (Upakhyana) of Nachiketa.
            It was directly narrated by the God of Death, Yama Himself (Mrityuproktam), and this tale is profoundly eternal (Sanatana).
            The highly intelligent and wise (Medhavi) man who recites or teaches (Uktva) this supremely mystical story to others.
            Or who listens (Shrutva) to it from a wise sage with absolute faith, becomes highly glorified and worshipped in Brahmaloka.
            Here the main philosophical section (First Chapter) of Katha Upanishad concludes, and the fruits of its study are declared.
            This is no ordinary story meant for casual entertainment; it is the ultimate key to the greatest mystery of life and death.
            Yama (Death) Himself is revealing the secret of true life; what could possibly be a more authentic source of wisdom than this?
            Merely reciting or listening to this story with faith deeply purifies the human mind and awakens powerful detachment.
            Being 'glorified in Brahmaloka' means he begins to experience the immediate closeness of God while still fully alive.
            The exact same wisdom that Nachiketa received can be attained today by any human being who reads this story with devotion.
        """.trimIndent()
    ),
    KathaShloka(
        id = 71,
        sanskrit = "य इमं परमं गुह्यं श्रावयेद् ब्रह्मसंसदि । प्रयतः श्राद्धकाले वा तदानन्त्याय कल्पते तदानन्त्याय कल्पत इति ॥ १७ ॥",
        hindi = """
            (अध्याय १ का समापन): जो व्यक्ति इस परम रहस्यमयी और गुप्त (गुह्य) ज्ञान को ज्ञानी ब्राह्मणों की सभा (ब्रह्मसंसदि) में सुनाता है।
            अथवा जो व्यक्ति अत्यंत पवित्र (प्रयतः) होकर श्राद्ध के समय (पितरों के कर्म के समय) इसे अपने स्वजनों को सुनाता है।
            उसका वह कर्म उसे अनंत (कभी न खत्म होने वाले) फलों की प्राप्ति कराता है; वह निश्चित रूप से अनंत फल (मोक्ष) को प्राप्त करता है।
            (वाक्य का दोहराव इस बात की पूर्ण सत्यता और अध्याय की समाप्ति को दर्शाता है)।
            उपनिषद का ज्ञान 'गुह्य' है, इसे हर किसी के सामने नहीं, बल्कि 'ब्रह्मसंसदि' (समझने वालों की सभा) में ही कहना चाहिए।
            श्राद्ध के समय लोग अक्सर भावुक और दुखी होते हैं; ऐसे समय में यह कथा उन्हें समझाती है कि आत्मा कभी मरती नहीं।
            इसलिए इस कथा को सुनाने से मृत व्यक्ति की आत्मा और सुनने वालों—दोनों को अपार शांति मिलती है।
            यह कोई कर्मकांड नहीं है; जब हम दूसरों को ज्ञान देते हैं, तो हमारा अपना ज्ञान भी गहरा और अनंत (अनंत्याय) हो जाता है।
            यहाँ कठोपनिषद का पहला अध्याय (जिसमें तीन वल्लियां थीं) पूर्ण रूप से संपन्न होता है।
            नचिकेता को ज्ञान मिल चुका है, पर अगले अध्याय में यमराज योग की कुछ और गहरी तकनीकी (Technical) बातें समझाएंगे।
        """.trimIndent(),
        english = """
            (Conclusion of Chapter 1): The person who recites this supremely mystical and profoundly secret (Guhya) wisdom in an assembly of wise Brahmins (Brahmasamsadi).
            Or the person who, being completely pure and devout (Prayatah), recites it during the time of Shraddha (ancestral rites).
            That noble action makes him absolutely fit for infinite (never-ending) rewards; he undoubtedly attains infinite results (Moksha).
            (The repetition of the final phrase emphasizes absolute certainty and marks the formal conclusion of the chapter).
            Upanishadic wisdom is 'Guhya' (secret); it shouldn't be casually thrown around, but shared in a 'Brahmasamsadi' (assembly of seekers).
            During Shraddha, people are highly emotional and grieving; this story powerfully reassures them that the Soul absolutely never dies.
            Therefore, reciting this story grants immense, profound peace to both the departed soul and the grieving listeners.
            This is not a mere ritual; when we selflessly impart wisdom to others, our own wisdom deepens and becomes infinite (Anantyaya).
            Here the entire first chapter of the Katha Upanishad (comprising three Vallis) is perfectly and formally concluded.
            Nachiketa has received the wisdom, but in the next chapter, Yama will explain some deeper technical aspects of Yoga.
        """.trimIndent()
    ),

    KathaShloka(
        id = 72,
        sanskrit = "पराञ्चि खानि व्यतृणत् स्वयम्भूस्तस्मात्पराङ्पश्यति नान्तरात्मन् । कश्चिद्धीरः प्रत्यगात्मानमैक्षदावृत्तचक्षुरमृतत्वमिच्छन् ॥ १ ॥",
        hindi = """
            (द्वितीय अध्याय / चौथी वल्ली प्रारंभ): उस स्वयंभू (अपने-आप प्रकट होने वाले परमेश्वर) ने हमारी इंद्रियों (खानि) को ऐसा बनाया है कि वे हमेशा बाहर की ओर ही भागती हैं।
            चूंकि उसने उन्हें बाहर की ओर छिद्रित (व्यतृणत्) किया है, इसलिए मनुष्य हमेशा बाहरी दुनिया को ही देखता है, अपने भीतर की अंतरात्मा को कभी नहीं देखता।
            परंतु कोई विरला ही ऐसा अत्यंत बुद्धिमान और धैर्यवान (धीर) पुरुष होता है जो अमरता (अमृतत्व) की इच्छा रखता है।
            वह अपनी आँखों (और सभी इंद्रियों) को बाहर से मोड़कर (आवृत्तचक्षुः) अपने भीतर उस परम आत्मा (प्रत्यगात्मानम्) का साक्षात् दर्शन कर लेता है।
            यह मानव जीवन की सबसे बड़ी ट्रेजेडी (Tragedy) और हमारी डिज़ाइन (Design) का सबसे बड़ा दोष है।
            भगवान ने हमारी आँखें, कान, नाक सब ऐसे बनाए हैं कि वे केवल बाहर की दुनिया को देख सकते हैं, अंदर नहीं।
            इसलिए 99.9% लोग पूरी जिंदगी बाहर पैसा, सुख और रिश्ते खोजते रहते हैं और आत्मा से अनजान ही मर जाते हैं।
            परन्तु जो इंसान 'अमरता' चाहता है, उसे प्रकृति के इस 'डिफ़ॉल्ट सेटिंग' (Default setting) के खिलाफ जाकर बगावत करनी पड़ती है।
            उसे अपनी इंद्रियों के प्रवाह को बाहर से मोड़कर (प्रत्याहार) ज़बरदस्ती भीतर की ओर (Meditation) लाना पड़ता है।
            ईश्वर को पाना आसान नहीं है; यह धारा के बिल्कुल विपरीत (Against the current) तैरने की एक महान कला है।
        """.trimIndent(),
        english = """
            (Beginning of Chapter 2 / Valli 4): The Self-Existent Lord (Svayambhu) completely pierced the senses (outlets) turning them strictly outward.
            Because He created them facing outward, human beings perpetually look only at the external world, and never at the Inner Soul.
            However, there is an exceedingly rare, highly wise, and patient man (Dhira) who intensely desires absolute Immortality.
            He completely averts his eyes (and all senses) away from the external world (Avrittachakshuh) and directly beholds the Inner Soul.
            This highlights the greatest tragedy of human life and the most profound flaw in our biological design.
            God deliberately designed our eyes, ears, and nose in such a way that they can only perceive the outside world, never the inside.
            Therefore, 99.9% of people spend their entire lives endlessly chasing money and relationships outside, dying completely ignorant of the Soul.
            But the human who genuinely desires 'Immortality' must actively rebel against this 'Default Setting' of material nature.
            He must forcefully reverse the entire flow of his senses from the outside (Pratyahara) and direct them entirely inward (Meditation).
            Attaining God is not easy; it is the magnificent and extremely difficult art of swimming completely against the current.
        """.trimIndent()
    ),
    KathaShloka(
        id = 73,
        sanskrit = "पराचः कामाननुयन्ति बालास्ते मृत्योर्यन्ति विततस्य पाशम् । अथ धीरा अमृतत्वं विदित्वा ध्रुवमध्रुवेष्विह न प्रार्थयन्ते ॥ २ ॥",
        hindi = """
            जो अज्ञानी और मूर्ख लोग (बालाः) हैं, वे हमेशा बाहर की ओर दौड़ने वाली सांसारिक इच्छाओं (कामान्) के पीछे-पीछे ही भागते रहते हैं।
            और ऐसा करने के कारण वे चारों ओर फैले हुए (विततस्य) मृत्यु के भयंकर जाल (पाश) में फँस जाते हैं (और बार-बार मरते हैं)।
            परंतु जो ज्ञानी (धीर) पुरुष हैं, वे इस संसार में उस असली अमरता (अमृतत्व) को भलीभांति जान लेते हैं।
            इसलिए वे इस दुनिया की अनित्य और नाशवान (अध्रुवेषु) वस्तुओं के बीच उस नित्य और शाश्वत (ध्रुव) सुख को कभी नहीं खोजते (प्रार्थयन्ते)।
            यमराज यहाँ उन लोगों को 'बालक' (बच्चे) कह रहे हैं जिनकी दाढ़ी सफेद हो गई है, पर अक्ल अभी भी खिलौनों (पैसों) में अटकी है।
            बाहरी इच्छाओं के पीछे भागना ऐसा है जैसे मृत्यु के बिछाए हुए जाल में जानबूझकर जाकर कूदना।
            जितनी ज्यादा इच्छाएं होंगी, शरीर को उतनी ही बार जन्म लेना और मरना पड़ेगा।
            बुद्धिमान आदमी जानता है कि दुनिया की हर चीज़ 'अध्रुव' (बदलने वाली और खत्म होने वाली) है।
            तो फिर बदलने वाली चीज़ों में से कोई 'परमानेंट' (Permanent/ध्रुव) सुख कैसे मिल सकता है?
            इसलिए ज्ञानी दुनिया से कुछ मांगता नहीं है; वह बस शांत होकर अपने भीतर उस अमर तत्व का आनंद लेता है।
        """.trimIndent(),
        english = """
            Those ignorant and utterly foolish people (children) constantly chase entirely after outward-flowing worldly desires (Kaman).
            And by doing exactly that, they inevitably fall right into the widespread, terrifying net (snare) of Death (and die repeatedly).
            But the wise and patient men (Dhira) perfectly understand what true Immortality (Amritatvam) actually is in this world.
            Therefore, they absolutely never seek or pray for the permanent (Dhruva) joy amidst the impermanent and highly perishable (Adhruva) things of this world.
            Yama calls those people 'Balaka' (children) who may have gray beards but whose intellect is still terribly stuck on worldly toys (money).
            Relentlessly chasing external desires is exactly like intentionally jumping straight into the wide net laid out by Death.
            The greater the number of desires, the more times the physical body will be forced to take birth and die painfully.
            An intelligent man knows perfectly well that every single thing in this world is 'Adhruva' (mutable and guaranteed to perish).
            So how can anyone possibly extract 'permanent' (Dhruva) happiness from inherently impermanent, decaying objects?
            Hence, the wise man demands nothing from the world; he just sits calmly and enjoys the immortal principle right within himself.
        """.trimIndent()
    ),
    KathaShloka(
        id = 74,
        sanskrit = "येन रूपं रसं गन्धं शब्दान् स्पर्शाँश्च मैथुनान् । एतेनैव विजानाति किमत्र परिशिष्यते । एतद्वै तत् ॥ ३ ॥",
        hindi = """
            मनुष्य जिस शक्ति (चेतना) के द्वारा रूप (रंग), रस (स्वाद), गंध (महक), शब्द (आवाज़) और स्पर्श को पूरी तरह से जानता है।
            तथा जिस शक्ति से वह प्रेम और मैथुन (संसर्ग) के सुखों का अनुभव करता है, वह सब वह इसी आत्मा की शक्ति (एतेनैव) से ही जानता है।
            इस शरीर में उस आत्मा (चेतना) के अलावा और शेष बचता ही क्या है जो कुछ जान सके? (अर्थात कुछ नहीं)।
            तुमने जो पूछा था (कि मृत्यु के बाद क्या रहता है), "निश्चित रूप से यही वह (परम तत्व) है।"
            हम सोचते हैं कि हमारी आँखें देखती हैं या जीभ स्वाद लेती है, पर यह सच नहीं है।
            एक मुर्दे के पास भी आँखें और जीभ होती है, पर वह कुछ नहीं देख या चख सकता, क्योंकि उसमें 'आत्मा' नहीं है।
            इंद्रियां तो केवल खिड़कियां हैं; उन खिड़कियों के पीछे खड़ा होकर बाहर की दुनिया को 'देखने वाला' असली मास्टर आत्मा ही है।
            सेक्स (मैथुन) का जो सुख इंसान को पागल कर देता है, उस सुख को महसूस करने वाली मशीन भी आत्मा की ही ऊर्जा से चलती है।
            शरीर तो केवल हार्डवेयर (Hardware) है; जो सॉफ्टवेयर (चेतना) उसे चला रहा है, वही ब्रह्म है।
            यमराज नचिकेता को बता रहे हैं कि वह सत्य कोई दूर की चीज़ नहीं है; वह वही चेतना है जो अभी तुम्हारे अंदर से देख और सुन रही है।
        """.trimIndent(),
        english = """
            That supreme power (consciousness) by which a human being fully knows and perceives form (color), taste, smell, sound, and touch.
            And the exact same power by which he experiences the immense pleasures of love and sexual union (Maithuna), he knows all this solely by the Soul.
            What else is possibly left remaining in this body besides that Soul (Consciousness) that has the ability to know? (Absolutely nothing).
            What you asked for (what remains after death), "This indeed is That (the Supreme Principle)."
            We falsely think that our physical eyes see or our tongue tastes, but that is simply not the truth.
            A dead corpse also has eyes and a tongue, but it cannot see or taste anything at all because the 'Soul' has left.
            The senses are merely windows; the real Master standing behind those windows 'watching' the outside world is the Soul alone.
            Even the intense pleasure of sex (Maithuna) that drives humans crazy is completely experienced using the absolute energy of the Soul.
            The physical body is just inert hardware; the software (Consciousness) that operates it is the very Brahman.
            Yama tells Nachiketa that the Truth is not distant; it is the exact same consciousness looking and listening through you right now.
        """.trimIndent()
    ),
    KathaShloka(
        id = 75,
        sanskrit = "स्वप्नान्तं जागरितान्तं चोभौ येनानुपश्यति । महान्तं विभुमात्मानं मत्वा धीरो न शोचति ॥ ४ ॥",
        hindi = """
            वह शक्ति जिसके द्वारा यह जीव स्वप्न अवस्था (सपनों की दुनिया) के सभी दृश्यों को पूरी तरह से देखता (अनुपश्यति) है।
            और जिसके द्वारा वह इस जाग्रत अवस्था (जागते हुए) की दुनिया के सभी पदार्थों को प्रत्यक्ष देखता है (यानी जो दोनों अवस्थाओं का साक्षी है)।
            उस महान और सर्वव्यापी (विभु) आत्मा को यथार्थ रूप में जानकर (मत्वा), बुद्धिमान पुरुष (धीर) कभी भी शोक (दुख) नहीं करता।
            हम दिन भर जागते हैं और रात को सपने देखते हैं; ये दोनों दुनिया बिल्कुल अलग-अलग हैं।
            पर इन दोनों बदलती हुई दुनियाओं को देखने वाला (साक्षी / Witness) कौन है जो कभी नहीं बदलता?
            जब हम सपना देखते हैं तो शरीर सोया रहता है, पर फिर भी कोई है जो उस सपने को फिल्म की तरह देख रहा है।
            वह देखने वाला 'कैमरा' ही हमारी आत्मा (चेतना) है, जो हमेशा जागृत और सर्वव्यापी (विभु) है।
            जब इंसान को यह एहसास हो जाता है कि वह यह शरीर या मन नहीं, बल्कि केवल एक देखने वाला 'साक्षी' है।
            तो फिर उसे दुनिया का कोई भी नाटक (चाहे वह खुशी का हो या दुख का) रुला या डरा नहीं सकता।
            शोक (Sorrow) केवल तब होता है जब हम नाटक के किरदार (Character) के साथ खुद को जोड़ लेते हैं; आत्मा केवल दर्शक है।
        """.trimIndent(),
        english = """
            That supreme power by which the soul fully perceives and intensely watches all the scenes of the dream state (Svapnanta).
            And exactly by which it directly observes all the physical objects of the waking state (meaning, the witness of both states).
            By truly realizing and knowing that magnificently Great and all-pervading (Vibhu) Soul, the wise man (Dhira) absolutely never grieves.
            We stay awake all day and see dreams all night; these two worlds are entirely and completely different from each other.
            But who exactly is the one unchanged Observer (Witness) continuously watching both of these constantly shifting worlds?
            When we dream, the physical body is fast asleep, yet someone is vividly watching that dream just like a movie.
            That observing 'Camera' is nothing but our Soul (Consciousness), which is eternally awake and perfectly omnipresent (Vibhu).
            When a human being profoundly realizes that he is not this body or mind, but purely an observing 'Witness'.
            Then absolutely no worldly drama (whether of extreme joy or intense sorrow) can ever possibly make him cry or fear.
            Grief happens solely when we falsely identify with the character playing in the drama; the Soul is exclusively a silent spectator.
        """.trimIndent()
    ),
    // ... Paste these directly after Shloka 75 in your kathaShlokasList ...

    KathaShloka(
        id = 76,
        sanskrit = "य इमं मध्वदं वेद आत्मानं जीवमन्तिकात् । ईशानं भूतभव्यस्य न ततो विजुगुप्सते । एतद्वै तत् ॥ ५ ॥",
        hindi = """
            जो मनुष्य कर्मफलों को भोगने वाले इस 'मध्वद' (शहद/कर्मफल खाने वाले) जीव को अपने अत्यंत समीप जान लेता है।
            और वह जान लेता है कि यह आत्मा ही भूत (अतीत) और भविष्य का साक्षात् ईश्वर (शासक) है।
            ऐसा जानने के बाद वह मनुष्य कभी भी किसी भी चीज़ की निंदा नहीं करता और न ही अपने शरीर की रक्षा के लिए डरता है।
            तुमने जो पूछा था कि मृत्यु के बाद क्या रहता है, "निश्चित रूप से यही वह (परम तत्व) है।"
            हम दिन-रात कर्मों का मीठा या कड़वा फल (शहद) खाते हैं, इसलिए आत्मा को यहाँ 'मध्वद' कहा गया है।
            जब तक हम खुद को जीव (भोक्ता) मानते हैं, तब तक हम अपनी सुरक्षा को लेकर डरे रहते हैं।
            पर जब हम जान जाते हैं कि हमारे अंदर बैठा जीव ही पूरे ब्रह्मांड (भूत-भविष्य) का मालिक है।
            तो हमारे भीतर का सारा डर और असुरक्षा (Insecurity) हमेशा के लिए खत्म हो जाती है।
            जो खुद ही समय का मालिक है, उसे समय (काल/मौत) क्या नुकसान पहुँचा सकता है?
            यह श्लोक अद्वैत का सीधा अनुभव है, जहाँ जीव और ईश्वर के बीच की दूरी शून्य (Zero) हो जाती है।
        """.trimIndent(),
        english = """
            The person who truly knows and directly experiences this 'Madhvada' (honey-eater/experiencer of karma) soul very intimately.
            And who perfectly realizes that this very Soul is the absolute Lord (Master) of the past and the future.
            After knowing this, that person never despises or hates anything, nor does he constantly fear to protect his body.
            What you had asked about what remains after death, "This indeed is That (the Supreme Principle)."
            We consume the sweet or bitter fruits (honey) of our actions daily; hence the soul is called 'Madhvada'.
            As long as we falsely consider ourselves mere experiencing creatures, we remain terrified about our survival.
            But the moment we realize that the soul sitting within us is the actual Master of the universe (past-future).
            All our deep-rooted fears and intense physical insecurities simply vanish forever.
            How can Time (death) possibly harm the one who is the absolute Master of Time itself?
            This verse is the direct experience of Non-duality, where the distance between the soul and God becomes exactly zero.
        """.trimIndent()
    ),
    KathaShloka(
        id = 77,
        sanskrit = "यः पूर्वं तपसो जातमद्भ्यः पूर्वमजायत । गुहां प्रविश्य तिष्ठन्तं यो भूतेभिर्व्यपश्यत । एतद्वै तत् ॥ ६ ॥",
        hindi = """
            जिस परमात्मा ने सबसे पहले तप (ज्ञान/संकल्प) से उस हिरण्यगर्भ (प्रथम जीव) को उत्पन्न किया।
            जो हिरण्यगर्भ जल और पंचभूतों की उत्पत्ति से भी बहुत पहले उत्पन्न (अजायत) हुआ था।
            और जो सभी प्राणियों के शरीर रूपी गुफा में प्रवेश करके पंचभूतों के साथ स्थित है।
            जो साधक उस हिरण्यगर्भ को अपनी आत्मा के रूप में प्रत्यक्ष देख लेता है, वह साक्षात् परब्रह्म को ही देख लेता है।
            यहाँ ब्रह्मांड के निर्माण की वैदिक प्रक्रिया (Vedic Cosmology) को समझाया गया है।
            हिरण्यगर्भ वह पहली 'कॉस्मिक चेतना' (Cosmic Consciousness) है, जो बिग बैंग से भी पहले पैदा हुई थी।
            वही पहली चेतना आज हर मनुष्य और हर जानवर के हृदय की गुफा में धड़क रही है।
            हम कोई अलग-अलग जीव नहीं हैं; हम सब उसी एक हिरण्यगर्भ (ब्रह्मा) के अनगिनत रूप हैं।
            जब साधक अपने हृदय में देखता है, तो वह केवल अपनी आत्मा को नहीं, बल्कि ब्रह्मांड की पहली आत्मा को देखता है।
            यही वह परम सत्य है जिसे नचिकेता मृत्यु के देवता यमराज से जानना चाहता था।
        """.trimIndent(),
        english = """
            That Supreme Lord who first created 'Hiranyagarbha' (the first cosmic being) through His Tapas (resolve/knowledge).
            That Hiranyagarbha who was born long before the creation of water and all the five physical elements.
            And who, having entered the cave of the heart of all beings, resides there intimately with the elements.
            The seeker who directly perceives that Hiranyagarbha as his own soul, truly beholds the Supreme Brahman.
            Here the profound Vedic process of cosmic creation (Vedic Cosmology) is beautifully explained.
            Hiranyagarbha is that initial 'Cosmic Consciousness' that was born even before the Big Bang occurred.
            That exact same first consciousness is pulsating today right within the cave of every human and animal heart.
            We are not isolated, separate creatures; we are all countless manifestations of that one single Hiranyagarbha (Brahma).
            When a seeker looks into his heart, he doesn't just see his soul, but the very first Soul of the cosmos.
            This indeed is that absolute Supreme Truth which Nachiketa intensely desired to know from the God of Death.
        """.trimIndent()
    ),
    KathaShloka(
        id = 78,
        sanskrit = "या प्राणेन सम्भवत्यदितिर्देवतामयी । गुहां प्रविश्य तिष्ठन्तीं या भूतेभिर्व्यजायत । एतद्वै तत् ॥ ७ ॥",
        hindi = """
            जो सभी देवताओं की आत्मा (देवतामयी) है और जो प्राण (ब्रह्मांडीय ऊर्जा) के रूप में प्रकट होती है।
            वह 'अदिति' (अखंड प्रकृति / देवमाता) जो पंचभूतों के साथ मिलकर अनेकों रूपों में उत्पन्न हुई है।
            और जो प्राणियों के हृदय रूपी गुफा में प्रवेश करके गहराई से स्थित है।
            जो साधक इस अदिति को प्रत्यक्ष जान लेता है, वह साक्षात् उस परब्रह्म को ही जान लेता है, "निश्चित रूप से यही वह है।"
            'अदिति' का शाब्दिक अर्थ है 'जो कभी खंडित (तैयार) न हो'—यह ब्रह्मांड की मूल अनंत ऊर्जा (Infinite Energy) है।
            इसे प्राण (Life force) भी कहा जाता है, जो पूरे ब्रह्मांड को और हमारे शरीर को चला रही है।
            ईश्वर केवल 'पुरुष' (चेतना) नहीं है, वह 'प्रकृति' (ऊर्जा/अदिति) भी है, और ये दोनों कभी अलग नहीं होते।
            हमारे दिल में जो चेतना धड़क रही है, वही अदिति है जो सूरज और सितारों को भी ऊर्जा दे रही है।
            जब हम अपनी श्वास (प्राण) और हृदय पर ध्यान लगाते हैं, तो हम सीधे उस ब्रह्मांडीय माता से जुड़ जाते हैं।
            यह श्लोक विज्ञान के उस नियम को पुष्ट करता है कि 'ऊर्जा न तो बनती है न मिटती है'—वह अदिति (अखंड) है।
        """.trimIndent(),
        english = """
            She who is the soul of all gods (Devatamayi) and who magnificently manifests as Prana (cosmic vital energy).
            That 'Aditi' (the indivisible infinite Nature/Mother of gods) who is born in manifold forms along with the elements.
            And who, having entered the deeply hidden cave of the heart of all living beings, resides there firmly.
            The seeker who truly knows this Aditi directly knows the Supreme Brahman, "This indeed is That."
            'Aditi' literally means 'that which cannot be divided or broken'—it is the ultimate Infinite Energy of the cosmos.
            She is also called Prana (Life force), which is actively driving the entire universe and our physical bodies.
            God is not only 'Purusha' (Consciousness) but also 'Prakriti' (Energy/Aditi), and these two are never separate.
            The consciousness pulsating in our hearts is the exact same Aditi that empowers the sun and the stars.
            When we meditate deeply on our breath (Prana) and heart, we directly connect with that cosmic Mother.
            This verse perfectly validates the scientific law that 'Energy is neither created nor destroyed'—it is Aditi (indivisible).
        """.trimIndent()
    ),
    KathaShloka(
        id = 79,
        sanskrit = "अरण्योर्निहितो जातवेदा गर्भ इव सुभृतो गर्भिणीभिः । दिवेदिवे ईड्यो जागृवद्भिर्हविष्मद्भिर्मनुष्येभिरग्निः । एतद्वै तत् ॥ ८ ॥",
        hindi = """
            जिस प्रकार गर्भवती स्त्रियां अपने गर्भ में पल रहे शिशु की बहुत सावधानी और प्रेम से रक्षा करती हैं।
            उसी प्रकार यज्ञ की ऊपर और नीचे की दोनों लकड़ियों (अरणियों) के बीच 'जातवेदा' (अग्नि) को सुरक्षित रखा जाता है।
            वह अग्नि (परमात्मा), जो जागृत और सावधान रहने वाले तथा हवि (आहुति) देने वाले मनुष्यों द्वारा।
            हर दिन (दिवेदिवे) स्तुति करने और पूजने के योग्य (ईड्य) है, "निश्चित रूप से यही वह (परम तत्व) है।"
            यहाँ आत्मा की तुलना लकड़ी में छिपी हुई आग से की गई है, जो ध्यान और तपस्या से प्रकट होती है।
            आग लकड़ी में दिखाई नहीं देती, पर अगर उसे सही तरीके से रगड़ा जाए, तो वह सब कुछ रोशन कर देती है।
            इसी तरह आत्मा हमारे शरीर में दिखाई नहीं देती, पर ध्यान के घर्षण (Friction) से वह प्रकट हो जाती है।
            गर्भवती माँ की उपमा का अर्थ है कि साधक को अपने भीतर पल रहे इस 'ज्ञान' की बहुत नाज़ुक देखभाल करनी चाहिए।
            ज़रा सी लापरवाही (क्रोध या लालच) से यह आध्यात्मिक गर्भ (Spiritual fetus) नष्ट हो सकता है।
            इसलिए एक सच्चे योगी को हर दिन (दिवेदिवे) अत्यंत सतर्क (जागृत) रहकर इस आंतरिक अग्नि की पूजा करनी चाहिए।
        """.trimIndent(),
        english = """
            Just as pregnant women very carefully and lovingly protect and nourish the unborn child deeply hidden in their womb.
            Similarly, 'Jataveda' (the sacred fire) is kept perfectly safe and hidden between the upper and lower fire-sticks (Aranis).
            That Fire (the Supreme Lord), who is worshipped and adored daily (Dive-dive) by fully awakened, alert men.
            And by those who constantly offer oblations (devotion), "This indeed is exactly That (the Supreme Principle)."
            Here, the Soul is brilliantly compared to the latent fire hidden in wood, which manifests strictly through meditation and penance.
            Fire is absolutely invisible inside the wood, but if rubbed correctly, it blazes out and illuminates everything.
            Similarly, the Soul is invisible in our body, but it brightly manifests through the intense friction of deep meditation.
            The pregnant mother metaphor means the seeker must delicately protect this 'wisdom' growing within him like a fetus.
            Even a slight moment of carelessness (anger or lust) can instantly destroy this fragile spiritual fetus.
            Therefore, a true Yogi must remain utterly vigilant (awakened) every single day, worshiping this inner Fire.
        """.trimIndent()
    ),
    KathaShloka(
        id = 80,
        sanskrit = "यतश्चोदेति सूर्योऽस्तं यत्र च गच्छति । तं देवाः सर्वेऽर्पितास्तदु नात्येति कश्चन । एतद्वै तत् ॥ ९ ॥",
        hindi = """
            जिस परम शक्ति (प्राण/ब्रह्म) से यह सूर्य हर दिन उदित होता है (निकलता है), और जिसके भीतर यह वापस अस्त हो जाता है।
            उस एक परब्रह्म के भीतर ही सारे देवता (इंद्र, अग्नि, वायु आदि) पूरी तरह से आश्रित और स्थापित (अर्पिताः) हैं।
            दुनिया का कोई भी देवता या मनुष्य उस परम सत्ता का कभी भी उल्लंघन नहीं कर सकता (नात्येति कश्चन)।
            तुमने जो मुझसे मृत्यु के पार का सत्य पूछा था, "निश्चित रूप से यही वह (परम तत्व) है।"
            सूर्य दुनिया को प्रकाश देता है, पर सूर्य को भी उदय होने का आदेश (Order) उस परमेश्वर से ही मिलता है।
            विज्ञान कहता है कि सूर्य गुरुत्वाकर्षण (Gravity) के कारण चलता है, पर उपनिषद कहता है कि ग्रेविटी भी उसी ब्रह्म का एक नियम है।
            सारे देवता उस परमेश्वर के शरीर के अलग-अलग अंगों की तरह हैं; वे उससे आज़ाद होकर कुछ नहीं कर सकते।
            'कोई उल्लंघन नहीं कर सकता' का अर्थ है कि प्रकृति का हर नियम (Law of Nature) उस ब्रह्म का ही अनुशासन है।
            जब इंसान को यह समझ आ जाता है, तो वह छोटी-मोटी ताकतों से डरना बंद कर देता है और केवल उस 'एक' की शरण लेता है।
            यही वह अंतिम सत्य है जो मौत के बाद भी रहता है, क्योंकि जो सूरज को चलाता है, वह कभी मर नहीं सकता।
        """.trimIndent(),
        english = """
            That Supreme Power (Prana/Brahman) from which this brilliant sun rises every day, and into which it finally sets.
            It is within that one Supreme Brahman alone that all the gods (Indra, Agni, Vayu, etc.) are completely fixed and established.
            Absolutely no god or human being in this universe can ever transcend or violate His supreme authority.
            What you asked me regarding the ultimate truth beyond death, "This indeed is exactly That (the Supreme Principle)."
            The sun gives light to the world, but the sun itself receives its strict command to rise exclusively from that Supreme Lord.
            Science says the sun moves due to gravity, but the Upanishad states that gravity itself is merely a law of that Brahman.
            All the gods are simply like various functional limbs of that Supreme Lord's body; they can do nothing independently.
            'No one can violate' means that every single Law of Nature is strictly the unwavering discipline of that Brahman.
            When a human understands this, he permanently stops fearing petty powers and takes absolute refuge only in that 'One'.
            This is the ultimate Truth that remains even after death, because the One who drives the sun can never possibly die.
        """.trimIndent()
    ),
    KathaShloka(
        id = 81,
        sanskrit = "यदेवेह तदमुत्र यदमुत्र तदन्विह । मृत्योः स मृत्युमाप्नोति य इह नानेव पश्यति ॥ १० ॥",
        hindi = """
            जो परब्रह्म यहाँ (इस दृश्यमान भौतिक जगत और शरीर में) है, बिल्कुल वही ब्रह्म वहाँ (परलोक और स्वर्ग में) भी है।
            और जो वहाँ (परलोक में) है, वही बिल्कुल एक समान रूप से यहाँ (इस संसार में) भी व्याप्त है।
            जो अज्ञानी मनुष्य इस सत्य में 'नाना' (अनेकता या भेद) देखता है, वह मृत्यु से मृत्यु को प्राप्त होता है।
            अर्थात जो व्यक्ति भगवान और दुनिया को अलग मानता है, वह बार-बार जन्म-मरण के भयानक चक्र में फँसता है।
            यह वेदान्त का सबसे बड़ा और सबसे क्रांतिकारी (Revolutionary) श्लोक है।
            हम सोचते हैं कि भगवान किसी सातवें आसमान पर रहता है और यह दुनिया एक गंदी जगह है।
            पर उपनिषद कहता है कि जो भगवान स्वर्ग में है, वही भगवान इस धरती की धूल में भी है।
            ईश्वर और जगत (Creator and Creation) दो अलग चीज़ें नहीं हैं; यह 'अद्वैत' (Non-duality) का सर्वोच्च सिद्धांत है।
            'नाना' देखने का मतलब है भेद करना—यह मेरा है, यह तेरा है; यह पवित्र है, यह अपवित्र है।
            जब तक मन में यह भेद (Duality) रहेगा, तब तक इंसान को बार-बार मरना पड़ेगा; एकता ही अमरता है।
        """.trimIndent(),
        english = """
            That Supreme Brahman which is present right here (in this visible material world and body), is exactly the same Brahman there (in heaven).
            And whatever is present there (in the afterlife), is exactly what pervades uniformly right here (in this world) as well.
            That ignorant person who sees 'Nana' (multiplicity, duality, or difference) in this absolute Truth, goes from death to death.
            Meaning, he who believes God and the world are separate, repeatedly falls into the terrifying cycle of birth and death.
            This is the absolute greatest and most profoundly revolutionary verse in the entire Vedantic philosophy.
            We falsely think that God lives in some distant seventh heaven and that this physical world is a dirty, impure place.
            But the Upanishad declares that the exact same God residing in heaven is pulsating right here in the dust of the earth.
            God and the world (Creator and Creation) are not two different things; this is the highest principle of 'Advaita' (Non-duality).
            Seeing 'Nana' means creating differences—this is mine, this is yours; this is sacred, this is profane.
            As long as this duality remains in the mind, a person will be forced to die repeatedly; pure Oneness alone is immortality.
        """.trimIndent()
    ),
    KathaShloka(
        id = 82,
        sanskrit = "मनसैवेदमाप्तव्यं नेह नानास्ति किञ्चन । मृत्योः स मृत्युं गच्छति य इह नानेव पश्यति ॥ ११ ॥",
        hindi = """
            इस परम सत्य (परमात्मा) को केवल एक अत्यंत शुद्ध और एकाग्र 'मन' के द्वारा ही प्राप्त किया जा सकता है।
            इस संपूर्ण ब्रह्मांड में 'नाना' (अनेकता या द्वैत) नाम की कोई भी चीज़ बिल्कुल (किंचन) नहीं है। (सब कुछ केवल एक ब्रह्म है)।
            जो अज्ञानी मनुष्य इस एकता में थोड़ा सा भी भेद (अनेकता) देखता है, वह मृत्यु से मृत्यु की ओर ही जाता है।
            (अर्थात वह बार-बार मरने के भयंकर दुखों को भोगने के लिए संसार में लौटता रहता है)।
            पिछले श्लोक की बात को यहाँ और अधिक दृढ़ता से दोहराया गया है ताकि साधक के मन में कोई शक न रहे।
            भगवान को पाने के लिए पैर से चलकर हिमालय जाने की जरूरत नहीं है; उसे केवल 'मनसा' (शुद्ध मन से) पाया जाता है।
            हम जो ये करोड़ों अलग-अलग चीजें (पेड़, इंसान, जानवर) देख रहे हैं, वे वास्तव में अलग हैं ही नहीं।
            जैसे सोने से बने कंगन, अंगूठी और हार रूप में अलग दिखते हैं, पर तत्व में केवल सोना ही हैं।
            वैसे ही यह सारी दुनिया केवल एक ही ऊर्जा (ब्रह्म) का अलग-अलग रूप है।
            जो इस 'एकता' को नहीं देख पाता, वह दुनिया की उलझनों में फँसकर अपनी जान गंवाता रहता है।
        """.trimIndent(),
        english = """
            This Supreme Truth (God) can be attained exclusively and entirely through a supremely pure and highly concentrated 'mind'.
            There is absolutely no such thing as 'Nana' (multiplicity or duality) existing anywhere in this entire universe. (Everything is only Brahman).
            The ignorant person who perceives even the slightest difference (multiplicity) in this Oneness, goes straight from death to death.
            (Meaning, he is forcefully returned to the world over and over to suffer the terrifying agonies of repeated deaths).
            The profound message of the previous verse is reiterated here with extreme firmness so the seeker is left with absolutely no doubts.
            To attain God, there is no need to travel to the Himalayas on foot; He is attained solely 'Manasa' (through a purified mind).
            The millions of separate things we see (trees, humans, animals) are not actually separate or different at all.
            Just as a bracelet, ring, and necklace look different in form but are fundamentally nothing but pure gold.
            Exactly similarly, this entire diverse world is merely different manifestations of one single Energy (Brahman).
            He who fails to perceive this supreme 'Oneness' remains hopelessly trapped in worldly illusions and continuously loses his life.
        """.trimIndent()
    ),
    KathaShloka(
        id = 83,
        sanskrit = "अङ्गुष्ठमात्रः पुरुषो मध्य आत्मनि तिष्ठति । ईशानो भूतभव्यस्य न ततो विजुगुप्सते । एतद्वै तत् ॥ १२ ॥",
        hindi = """
            वह परम पुरुष (परमात्मा) अँगूठे के आकार (अंगुष्ठमात्र) का होकर इस शरीर के बिल्कुल मध्य भाग (हृदय) में स्थित है।
            वह हृदय में बैठा हुआ पुरुष ही भूतकाल (अतीत) और भविष्यकाल (आने वाले समय) का परम शासक (ईशान) है।
            उस ईश्वर को अपने भीतर जान लेने के बाद, मनुष्य कभी भी अपनी रक्षा के लिए डरता नहीं है और न ही किसी से घृणा (विजुगुप्सा) करता है।
            नचिकेता! तुमने जो पूछा था, "निश्चित रूप से यही वह (परम तत्व) है।"
            यह श्लोक श्वेताश्वतर उपनिषद में भी आता है, और ध्यान की एक बहुत ही विशिष्ट तकनीक (Technique) बताता है।
            ध्यान के लिए ईश्वर को अपने हृदय के बीच में एक अँगूठे के बराबर प्रकाश (ज्योति) के रूप में मानना चाहिए।
            ईश्वर सच में अँगूठे जितना नहीं है, पर चंचल मन को टिकाने के लिए यह आकार एक बहुत बड़ा सहारा है।
            हम जीवन में डरते और नफरत इसलिए करते हैं क्योंकि हम खुद को कमजोर और अकेला मानते हैं।
            पर जब हमें पता चलता है कि तीनों कालों (भूत-भविष्य-वर्तमान) का मालिक 'ईशान' हमारे अपने दिल में बैठा है।
            तो दुनिया की कोई भी परिस्थिति (Circumstance) हमें डरा नहीं सकती; हम पूर्ण रूप से अभय और प्रेमपूर्ण हो जाते हैं।
        """.trimIndent(),
        english = """
            That Supreme Person (God) dwells exactly in the middle of this body (the heart), manifesting in the size of a thumb (Angushtamatra).
            That Person seated intimately in the heart is the absolute Ruler (Ishana) of the past and the future.
            Having truly realized that Lord within oneself, a person never fears for his self-protection, nor does he ever hate (condemn) anyone.
            Nachiketa! What you had asked, "This indeed is exactly That (the Supreme Principle)."
            This verse also appears in the Shvetashvatara Upanishad and provides an exceedingly specific and practical technique for meditation.
            For meditation, one should visualize God as a brilliant, thumb-sized light (flame) situated right in the center of the heart.
            God is not literally the size of a thumb, but this specific form provides a massive support to anchor the highly restless mind.
            We fear and hate in life simply because we falsely consider ourselves to be weak, isolated, and completely alone.
            But when we profoundly realize that the 'Ishana' (Master) of all three times (past-present-future) sits right in our own heart.
            Absolutely no circumstance in the world can ever frighten us; we instantly become completely fearless and unconditionally loving.
        """.trimIndent()
    ),
    KathaShloka(
        id = 84,
        sanskrit = "अङ्गुष्ठमात्रः पुरुषो ज्योतिरिवाधूमकः । ईशानो भूतभव्यस्य स एवाद्य स उ श्वः । एतद्वै तत् ॥ १३ ॥",
        hindi = """
            हृदय में स्थित वह अँगूठे के आकार का परम पुरुष ऐसी ज्योति (प्रकाश) के समान है जिसमें बिल्कुल भी धुआं नहीं है (अधूमक)।
            वह परमेश्वर भूतकाल और भविष्यकाल दोनों का पूर्ण रूप से शासक और स्वामी (ईशान) है।
            वह परमात्मा जैसा आज (वर्तमान में) है, वैसा ही वह कल (भविष्य में) भी हमेशा रहेगा; वह कभी बदलता नहीं।
            हे नचिकेता! तुम जिसके बारे में जानना चाहते थे, "निश्चित रूप से यही वह (सत्य) है।"
            यहाँ आत्मा के प्रकाश की तुलना आग से की गई है, पर ऐसी आग जिसमें धुआं नहीं है।
            धुआं अज्ञान, कन्फ्यूजन और पापों का प्रतीक है; आत्मा का प्रकाश बिल्कुल साफ, शुद्ध और पारदर्शी (Transparent) है।
            जब मन के सारे विचार शांत हो जाते हैं, तब हृदय में यही 'बिना धुएं वाली ज्योति' चमकती हुई दिखाई देती है।
            'स एवाद्य स उ श्वः' का अर्थ है कि दुनिया की हर चीज़ आज कुछ है और कल कुछ और हो जाएगी।
            परंतु आत्मा एक ऐसा सत्य है जिस पर समय (Time) का एक सेकंड भी असर नहीं डाल सकता; वह कल भी वही था, आज भी वही है।
            यह श्लोक ईश्वर की शाश्वतता (Eternity) और परम शुद्धता का सबसे सुंदर और काव्यात्मक वर्णन है।
        """.trimIndent(),
        english = """
            That thumb-sized Supreme Person situated in the heart is exactly like a brilliant flame (Light) completely without smoke (Adhumakah).
            That Supreme Lord is the absolute Ruler and Master (Ishana) of both the past and the future entirely.
            Exactly as that Supreme Lord is today (in the present), so He shall flawlessly remain tomorrow (in the future); He never changes.
            O Nachiketa! That which you intensely sought to know, "This indeed is exactly That (the Supreme Truth)."
            Here, the radiant light of the Soul is compared to a blazing fire, but a fire that possesses absolutely no smoke.
            Smoke is the symbol of ignorance, mental confusion, and sins; the light of the Soul is flawlessly clear, pure, and transparent.
            When all restless thoughts of the mind completely settle down, this 'smokeless flame' is vividly seen shining in the heart.
            'Sa evadya sa u shvah' profoundly means that everything in the world is one thing today and will become something else tomorrow.
            But the Soul is a Truth upon which even a single second of Time has zero effect; it was exactly the same yesterday, and is the same today.
            This verse is the most beautiful and poetic description of God's absolute Eternity and His supreme, untainted purity.
        """.trimIndent()
    ),
    KathaShloka(
        id = 85,
        sanskrit = "यथोदकं दुर्गे वृष्टं पर्वतेषु विधावति । एवं धर्मान् पृथक् पश्यंस्तानेवानुविधावति ॥ १४ ॥",
        hindi = """
            (यमराज द्वैत भाव का परिणाम बताते हैं): जिस प्रकार किसी ऊँचे और दुर्गम पर्वत के शिखर पर बरसा हुआ वर्षा का जल।
            पहाड़ की अलग-अलग ढलानों से होकर नीचे की ओर कई अलग-अलग दिशाओं में बह जाता है (और बिखर कर नष्ट हो जाता है)।
            ठीक उसी प्रकार, जो अज्ञानी मनुष्य आत्मा और परमात्मा (धर्मों) को एक-दूसरे से अलग (पृथक्) और भिन्न मानता है।
            वह मनुष्य उस पहाड़ी जल की तरह ही जन्म-मरण की अलग-अलग नीच योनियों में भटकता और नष्ट होता रहता है (अनुविधावति)।
            यह प्रकृति का एक बहुत ही शानदार उदाहरण है जो 'अद्वैत' (Oneness) के महत्व को सिद्ध करता है।
            बारिश का पानी जब गिरता है तो एक होता है, पर जब वह पहाड़ की खाइयों में बंटता है, तो गंदा हो जाता है और सूख जाता है।
            हमारी चेतना भी मूल रूप से एक है; पर जब हम इसे 'मैं अलग हूँ, तुम अलग हो' के भेद में बाँट देते हैं, तो हमारी ऊर्जा बिखर जाती है।
            हम अनेक इच्छाओं (पैसा, रुतबा, रिश्ते) की खाइयों में अपनी शक्ति को बहा देते हैं और अंत में मौत के घाट उतर जाते हैं।
            यह श्लोक चेतावनी देता है कि जो जीवन में 'अनेकता' (Multiplicity) के पीछे भागेगा, उसका विनाश निश्चित है।
            एकता ही शक्ति है, और अनेकता में फँसना ही संसार का सबसे बड़ा दुख और पतन (Downfall) है।
        """.trimIndent(),
        english = """
            (Yama reveals the consequence of Duality): Just as pure rainwater poured down upon a high and inaccessible mountain peak.
            Flows rapidly downwards and scatters away into numerous different directions through the various rugged mountain slopes (and is lost).
            In the exact same way, the ignorant person who sees the individual souls and the Supreme Lord (Dharmas) as separate (Prithak) and distinct.
            That human being relentlessly runs after them (Anuvidhavati), wandering and perishing in various lower wombs of birth and death like that scattered water.
            This is an exceptionally brilliant example from Nature perfectly proving the supreme importance of 'Advaita' (Oneness).
            When rainwater falls, it is purely one, but when it divides into mountain crevices, it becomes muddy and eventually dries up.
            Our consciousness is also fundamentally one; but when we divide it with differences like 'I am separate, you are separate', our energy shatters.
            We blindly drain our vital power into the deep crevices of multiple desires (money, status, relationships) and ultimately meet a miserable death.
            This verse issues a stern warning that whoever chases after 'Multiplicity' in life is absolutely destined for destruction.
            Oneness is ultimate power, and getting entangled in multiplicity is the world's greatest sorrow and the steepest downfall.
        """.trimIndent()
    ),

    KathaShloka(
        id = 86,
        sanskrit = "यथोदकं शुद्धे शुद्धमासिक्तं तादृगेव भवति । एवं मुनेर्विजानत आत्मा भवति गौतम ॥ १५ ॥",
        hindi = """
            (चौथी वल्ली का समापन): परंतु जिस प्रकार अत्यंत शुद्ध और स्वच्छ जल में ऊपर से शुद्ध जल ही डाला जाता है।
            तो वह डाला गया जल भी बिल्कुल उसी के समान (तादृगेव) हो जाता है, उसमें कोई भी भेद या अंतर नहीं रह जाता।
            हे गौतम (नचिकेता)! ठीक उसी प्रकार, जो मुनि (मननशील ज्ञानी) इस आत्मा के परम सत्य (अद्वैत) को भलीभांति जान लेता है।
            उसकी आत्मा भी उस परमपिता परमात्मा के साथ मिलकर बिल्कुल उसी के समान (ब्रह्मरूप) हो जाती है।
            पिछले श्लोक में पहाड़ का पानी बिखर कर नष्ट हो रहा था, पर यहाँ पानी साफ नदी या बर्तन में मिलकर 'एक' हो रहा है।
            जब आत्मा अज्ञान से मुक्त होकर पूरी तरह शुद्ध हो जाती है, तो वह उस शुद्ध परमात्मा में समा जाती है।
            जैसे पानी में पानी मिलने के बाद आप यह नहीं बता सकते कि कौन सा पानी कहाँ से आया था।
            वैसे ही जब जीवात्मा परमात्मा से मिलती है, तो जीवात्मा का सारा अहंकार और पहचान मिट जाती है, वह केवल ईश्वर रह जाती है।
            'मुनेर्विजानत' का अर्थ है कि यह एकता केवल उसी के लिए संभव है जो मनन (Meditation) करके सत्य को 'जान' चुका है।
            यह श्लोक अद्वैत वेदान्त की सर्वोच्च मंजिल (Moksha) का सबसे प्यारा और सटीक उदाहरण है।
        """.trimIndent(),
        english = """
            (Conclusion of Valli 4): But just as exquisitely pure and clean water poured directly into equally pure water.
            Becomes exactly like that existing pure water (Tadrigeva), leaving absolutely no difference or distinction between the two.
            O Gautama (Nachiketa)! In the exact same way, the soul of a Muni (a contemplative sage) who perfectly realizes this absolute truth of Non-duality.
            That individual soul completely merges with the Supreme Father and becomes exactly like Him (assumes the form of Brahman).
            In the previous verse, mountain water was scattering and dying, but here, water merging into a pure lake becomes totally 'One'.
            When the individual soul becomes completely purified from all ignorance, it flawlessly dissolves into that pure Supreme Lord.
            Just as after water mixes with water, you can never separate or identify which water originally came from where.
            Similarly, when the soul unites with God, all of the soul's ego and identity vanish completely; only God remains.
            'Munervijanata' means this profound unity is possible exclusively for the one who has 'realized' the Truth through deep meditation.
            This verse is the most beloved and precise illustration of the ultimate, highest destination of Advaita Vedanta (Moksha).
        """.trimIndent()
    ),
    KathaShloka(
        id = 87,
        sanskrit = "पुरमेकादशद्वारमजस्यावक्रचेतसः । अनुष्ठाय न शोचति विमुक्तश्च विमुच्यते । एतद्वै तत् ॥ १ ॥",
        hindi = """
            (पांचवीं वल्ली प्रारंभ): यह भौतिक शरीर ग्यारह द्वारों (11 दरवाजों) वाला एक नगर (पुर) है।
            और इस नगर का राजा वह परमेश्वर है जो अजन्मा (अजस्य) है और जिसकी चेतना बिल्कुल सीधी (अवक्र/ज्ञानस्वरूप) है।
            जो साधक उस परमात्मा का इस शरीर रूपी नगर में ध्यान (अनुष्ठान) करता है, वह कभी भी शोक (दुख) नहीं करता।
            वह जीते-जी सभी अज्ञान के बंधनों से पूरी तरह मुक्त (विमुक्त) हो जाता है, और मरने के बाद हमेशा के लिए मोक्ष पा लेता है।
            तुमने जो पूछा था, "निश्चित रूप से यही वह परम तत्व है।"
            शरीर के 11 दरवाजे हैं: 2 आँखें, 2 कान, 2 नथुने, 1 मुँह, 1 नाभि (ब्रह्मरन्ध्र), 1 मलद्वार, 1 मूत्रद्वार और 1 नाभि-छिद्र।
            इस नगर में बहुत हलचल है, पर इसका राजा (आत्मा) 'अवक्र' है, यानी वह इन टेढ़े-मेढ़े द्वारों की उलझनों में नहीं फँसता।
            जब हम शरीर के द्वारों से बाहर देखने की बजाय, भीतर बैठे उस सीधे और सच्चे राजा पर ध्यान लगाते हैं।
            तो हम 'जीवनमुक्त' हो जाते हैं (जीते-जी आज़ाद); और फिर मौत आने पर हम 'विदेहमुक्त' (शरीर से हमेशा के लिए आज़ाद) हो जाते हैं।
            यह श्लोक शरीर को एक साधन (Instrument) मानता है, जिसे बुरा नहीं समझना है, बस सही राजा के हाथ में सौंपना है।
        """.trimIndent(),
        english = """
            (Beginning of Valli 5): This physical human body is a city (Puram) possessing exactly eleven gates (doors).
            And the King of this city is that Supreme Lord who is completely unborn (Ajasya) and whose consciousness is perfectly straight (Avakra/unfaltering).
            The seeker who constantly meditates (Anushthaya) upon that Lord reigning within this city of the body, never grieves again.
            He becomes completely liberated (Vimukta) from all bonds of ignorance while alive, and attains absolute Moksha after death.
            What you inquired about, "This indeed is exactly That Supreme Principle."
            The 11 gates are: 2 eyes, 2 ears, 2 nostrils, 1 mouth, the crown of the head, the navel, and 2 lower excretory organs.
            There is massive chaos in this city, but its King (Soul) is 'Avakra', meaning He never gets entangled in these crooked gates.
            When, instead of looking out through these bodily gates, we meditate entirely on that straight and true King sitting inside.
            We become 'Jivanmukta' (liberated while fully alive); and when death comes, we become 'Videhamukta' (forever free from physical bodies).
            This verse treats the body as a sacred instrument; it is not to be despised, but correctly handed over to the rightful King.
        """.trimIndent()
    ),
    KathaShloka(
        id = 88,
        sanskrit = "हंसः शुचिषद् वसुरन्तरिक्षसद्धोता वेदिषदतिथिर्दुरोणसत् । नृषद्वरसदृतसद्व्योमसदब्जा गोजा ऋतजा अद्रिजा ऋतं बृहत् ॥ २ ॥",
        hindi = """
            वही एक परमात्मा आकाश (शुचि) में चमकने वाला सूर्य (हंस) है, और वही अंतरिक्ष में निवास करने वाली वायु (वसु) है।
            वही यज्ञ की वेदी (वेदिषद्) पर जलने वाली अग्नि (होता) है, और वही घर (दुरोण) में आने वाला अतिथि (सोम कलश) है।
            वही मनुष्यों (नृषद्) में, श्रेष्ठ देवताओं (वरषद्) में, सत्य और यज्ञ (ऋतषद्) में, तथा आकाश (व्योमषद्) में व्याप्त है।
            जल में पैदा होने वाले शंख आदि (अब्जा), पृथ्वी से पैदा होने वाले अन्न (गोजा), सत्य से उत्पन्न होने वाले यज्ञ (ऋतजा)।
            और पर्वतों से निकलने वाली नदियां (अद्रिजा) — यह सब कुछ साक्षात् वही महान (बृहत्) और परम सत्य (ऋतं) परमात्मा ही है।
            यह श्लोक ऋग्वेद (4.40.5) का एक बहुत ही महान मंत्र है जो ईश्वर की सर्वव्यापकता (Omnipresence) को सिद्ध करता है।
            ईश्वर केवल आसमान में नहीं है; वह सूरज की गर्मी में, हवा के झोंके में और घर आए मेहमान में भी धड़क रहा है।
            नदी, पहाड़, इंसान और देवता—ये अलग-अलग चीज़ें नहीं हैं, ये सब उसी एक 'बृहत्' (विशाल) चेतना के रूप हैं।
            जब साधक इस मंत्र को समझता है, तो उसके लिए पूरी दुनिया एक पवित्र मंदिर बन जाती है।
            यहाँ आकर इंसान का अहंकार पूरी तरह पिघल जाता है, क्योंकि वह देखता है कि 'मैं' कुछ नहीं हूँ, जो है सब 'वह' ही है।
        """.trimIndent(),
        english = """
            That one Supreme Lord alone is the brilliant sun (Hamsa) dwelling in the pure sky, and He is the wind (Vasu) residing in the intermediate space.
            He is the sacred fire (Hota) burning on the sacrificial altar (Vedishad), and He is the guest (Soma juice) entering the house (Duronasat).
            He completely pervades all humans (Nrishad), the supreme gods (Varashad), the cosmic truth and sacrifice (Ritashad), and the vast ether (Vyomashad).
            Those born of water like shells (Abja), those born of the earth like grains (Goja), those born of cosmic truth (Ritaja).
            And the mighty rivers born from mountains (Adrija) — absolutely all of these are that direct, Great (Brihat), and Supreme Truth (Ritam) Himself.
            This verse is a magnificently great mantra from the Rigveda (4.40.5) flawlessly proving the absolute Omnipresence of God.
            God is not restricted to the sky; He is fiercely pulsating in the sun's heat, the gust of wind, and the guest at the door.
            Rivers, mountains, humans, and gods—these are not separate entities; they are all manifestations of that one 'Brihat' (Vast) Consciousness.
            When a seeker truly comprehends this mantra, the entire world instantly transforms into a supremely sacred temple for him.
            Here, human ego melts away entirely, because he clearly sees that 'I' am nothing; whatever exists is exclusively 'He'.
        """.trimIndent()
    ),
    KathaShloka(
        id = 89,
        sanskrit = "ऊर्ध्वं प्राणमुन्नयत्यपानं प्रत्यगस्यति । मध्ये वामनमासीनं विश्वे देवा उपासते ॥ ३ ॥",
        hindi = """
            वह परमात्मा ही प्राण वायु को शरीर में ऊपर की ओर उठाता है (उन्नयति)।
            और वही परमात्मा अपान वायु को शरीर में नीचे की ओर फेंकता (प्रत्यगस्यति) और धकेलता है।
            हृदय के बिल्कुल बीचोबीच (मध्ये) बैठे हुए उस अत्यंत सुंदर और पूजनीय देव (वामनम्) की।
            सभी देवता (इंद्रियां और उनकी शक्तियां) पूरी श्रद्धा के साथ उपासना (उपासते) और सेवा करते हैं।
            हम सोचते हैं कि हम अपने-आप सांस ले रहे हैं, पर यह श्लोक बताता है कि हमारी सांसों को चलाने वाला असली इंजन (Engine) ईश्वर है।
            प्राण (Oxygen) को फेफड़ों तक खींचना और अपान (Carbon Dioxide) को बाहर निकालना—यह मशीन उसी के इशारे पर चल रही है।
            'वामन' का अर्थ बौना (Dwarf) भी होता है और 'परम सुंदर' भी; आत्मा हृदय में बहुत छोटे आकार की है, पर वह सबसे आकर्षक है।
            हमारे शरीर के सभी अंग (आँखें, कान, हृदय) अपना काम चुपचाप इसलिए कर रहे हैं क्योंकि वे उस 'वामन' (आत्मा) की सेवा कर रहे हैं।
            जिस दिन वह वामन इस शरीर को छोड़ देगा, उसी दिन सारी इंद्रियां अपना काम बंद कर देंगी और शरीर मिट्टी हो जाएगा।
            यह श्लोक शरीर विज्ञान (Biology) के पीछे छिपे हुए उस महान आध्यात्मिक विज्ञान (Spiritual Science) को उजागर करता है।
        """.trimIndent(),
        english = """
            That Supreme Lord alone is the one who constantly leads and pushes the Prana breath upwards (Unnayati) in the body.
            And He is the exact same power that continuously throws and drives the Apana breath downwards (Pratyagasyati) in the body.
            That exceedingly beautiful and highly adorable Deity (Vamanam) who sits exactly in the absolute center of the heart (Madhye).
            All the gods (the senses and their presiding powers) constantly worship (Upasate) and serve Him with absolute devotion.
            We falsely assume that we are breathing on our own, but this verse reveals that God is the actual engine driving our breath.
            Pulling Prana (Oxygen) into the lungs and expelling Apana (Carbon Dioxide) out—this entire machine operates solely on His command.
            'Vamana' means dwarf and also 'supremely beautiful'; the Soul is minute in the heart, yet it is the most attractive entity.
            All the organs of our body (eyes, ears, heart) perform their duties silently strictly because they are serving that 'Vamana' (Soul).
            The exact day that Vamana abandons this body, all the senses will instantly stop working and the body will become mere dirt.
            This verse magnificently exposes the profound Spiritual Science hidden flawlessly right behind human Biology.
        """.trimIndent()
    ),
    KathaShloka(
        id = 90,
        sanskrit = "अस्य विस्रंसमानस्य शरीरस्थस्य देहिनः । देहाद्विमुच्यमानस्य किमत्र परिशिष्यते । एतद्वै तत् ॥ ४ ॥",
        hindi = """
            (नचिकेता का मुख्य प्रश्न फिर से सामने आता है): जब यह शरीर में रहने वाला जीव (देही) इस भौतिक शरीर से ढीला पड़ने लगता है (विस्रंसमानस्य)।
            और जब वह इस नश्वर शरीर से पूरी तरह अलग (विमुच्यमानस्य) होकर बाहर निकल जाता है (यानी जब मौत आ जाती है)।
            तब इस निर्जीव शरीर में ऐसा क्या है जो पीछे शेष बचता है (परिशिष्यते)? (अर्थात शरीर में कुछ भी नहीं बचता, सब राख हो जाता है)।
            तो फिर मृत्यु के बाद क्या रहता है? "निश्चित रूप से यही वह (परम तत्व/आत्मा) है।"
            यहाँ जीवन का सबसे कड़वा सत्य है कि मौत के बाद यह शरीर किसी काम का नहीं रहता।
            जो शरीर कल तक हँसता-बोलता था, आज उसे तुरंत जला दिया जाता है, क्योंकि उसमें से 'मालिक' (आत्मा) निकल चुका है।
            यह साबित करता है कि शरीर हमारा असली स्वरूप नहीं था; यह तो केवल एक किराए का मकान था।
            जब मकान ढह जाता है, तो उसमें रहने वाला व्यक्ति (देही) नहीं मरता, वह केवल मकान छोड़ता है।
            यमराज नचिकेता को बार-बार याद दिला रहे हैं कि तुम वह शरीर नहीं हो जो जलेगा, तुम वह हो जो 'बच जाएगा' (परिशिष्यते)।
            यही वह परम सत्य है जिसे जानकर इंसान मौत की आँखों में आँखें डालकर मुस्कुरा सकता है।
        """.trimIndent(),
        english = """
            (Nachiketa's core question resurfaces): When this embodied soul (Dehi) residing within the body begins to loosen its grip (Visransamanasya).
            And when it becomes completely separated and fully released (Vimuchyamanasya) from this mortal physical body (i.e., when death occurs).
            Then what exactly is left remaining behind (Parishishyate) in this lifeless physical body? (Meaning, absolutely nothing is left; it becomes ashes).
            So what is it that continues to exist after death? "This indeed is exactly That (the Supreme Principle/Soul)."
            Here is the most bitter truth of life: after death, this physical body becomes completely and utterly useless.
            The body that was laughing and talking until yesterday is immediately burnt today, simply because the 'Master' (Soul) has exited.
            This decisively proves that the physical body was never our true identity; it was merely a temporary, rented house.
            When a house collapses, the person residing inside it (Dehi) does not die; he merely leaves the broken house.
            Yama repeatedly reminds Nachiketa that you are not the body that will burn; you are exactly That which 'remains' (Parishishyate).
            This is that absolute Truth, knowing which a human being can look straight into the eyes of Death and smile fearlessly.
        """.trimIndent()
    ),
    KathaShloka(
        id = 91,
        sanskrit = "न प्राणेन नापानेन मर्त्यो जीवति कश्चन । इतरेण तु जीवन्ति यस्मिन्नेतावुपाश्रितौ ॥ ५ ॥",
        hindi = """
            इस दुनिया में कोई भी मरणशील मनुष्य (मर्त्य) केवल अंदर जाने वाली श्वास (प्राण) के सहारे जीवित नहीं रहता है।
            और न ही वह बाहर निकलने वाली श्वास (अपान) के बलबूते पर जीवित रहता है (श्वास जीवन का अंतिम कारण नहीं है)।
            बल्कि ये सभी प्राणी किसी 'अन्य' (इतरेण) परम सत्ता के सहारे ही जीवित रहते हैं।
            जिस एक परम सत्ता (परमात्मा) के ऊपर ये प्राण और अपान दोनों ही पूरी तरह से आश्रित (टिके हुए) हैं।
            डॉक्टर कहते हैं कि अगर इंसान की सांस रुक जाए, तो वह मर जाता है, इसलिए सांस (Oxygen) ही जीवन है।
            परंतु उपनिषद विज्ञान से एक कदम आगे जाता है और पूछता है: सांस लेने की मशीन को कौन चला रहा है?
            हम रात को गहरी नींद में सो जाते हैं, हमारी बुद्धि बंद हो जाती है, फिर भी हमारी सांस कौन लेता रहता है?
            वह प्राण और अपान नहीं, बल्कि वह 'इतर' (कोई और / ईश्वर) है जो बैकग्राउंड (Background) में बैठकर इस मशीन को चला रहा है।
            प्राण तो केवल एक तार (Wire) की तरह है; पर उसमें दौड़ने वाली बिजली (Electricity) वह परमेश्वर है।
            जब वह बिजली कट जाती है, तो फेफड़े सही-सलामत होने के बावजूद इंसान एक सांस भी नहीं ले सकता।
        """.trimIndent(),
        english = """
            No mortal human being (Martya) in this world stays alive solely by relying on the incoming breath (Prana).
            Nor does anyone stay alive merely by the power of the outgoing breath (Apana) (breath is not the ultimate cause of life).
            Rather, all these living beings remain alive strictly dependent upon 'Another' (Itarena) Supreme Entity.
            That one Supreme Power (God) upon whom both this Prana and Apana are completely dependent and perfectly supported.
            Doctors say that if a person's breath stops, he dies; therefore, breath (Oxygen) itself is life.
            But the Upanishad goes one massive step beyond science and asks: Who exactly is running this breathing machine?
            We fall into a deep sleep at night, our intellect shuts down, yet who continues to breathe for us flawlessly?
            It is not the Prana or Apana, but that 'Other' (Itara / God) sitting quietly in the background running this complex machine.
            Prana is merely like an electrical wire; but the actual electricity flowing through it is that Supreme Lord.
            When that divine electricity is cut off, even if the lungs are perfectly healthy, a human cannot take a single breath.
        """.trimIndent()
    ),
    KathaShloka(
        id = 92,
        sanskrit = "हन्त त इदं प्रवक्ष्यामि गुह्यं ब्रह्म सनातनम् । यथा च मरणं प्राप्य आत्मा भवति गौतम ॥ ६ ॥",
        hindi = """
            (यमराज कहते हैं): हे गौतम (नचिकेता)! सुनो, अब मैं तुम्हें उस अत्यंत गुप्त (गुह्य) और सनातन (हमेशा रहने वाले) ब्रह्म का रहस्य बताऊँगा।
            और मैं तुम्हें यह भी स्पष्ट रूप से बताऊँगा कि शारीरिक मृत्यु (मरणं) को प्राप्त करने के बाद।
            इस जीवात्मा (आत्मा) का क्या होता है और वह किस गति (अवस्था) को प्राप्त (भवति) होती है।
            यहाँ यमराज उस विषय के सबसे रहस्यमयी और डरावने हिस्से को खोलने जा रहे हैं—पुनर्जन्म (Reincarnation)।
            लोग जानना चाहते हैं कि मौत के बाद क्या हमारे कर्म खत्म हो जाते हैं? क्या हम हमेशा के लिए सो जाते हैं?
            यमराज कहते हैं कि मृत्यु कोई पूर्णविराम (Full stop) नहीं है, यह केवल एक अल्पविराम (Comma) है।
            सनातन ब्रह्म का ज्ञान बहुत 'गुह्य' है, क्योंकि इसे आम इंसान की बुद्धि आसानी से स्वीकार नहीं कर पाती।
            नचिकेता की योग्यता सिद्ध हो चुकी है, इसलिए यमराज अब बिना किसी झिझक के उसे कर्मों का कड़ा नियम बताने वाले हैं।
            यह श्लोक अगले श्लोक (जहाँ पुनर्जन्म का सिद्धांत बताया गया है) के लिए एक अत्यंत रोमांचक भूमिका (Build-up) बनाता है।
            मृत्यु एक दरवाजा है, और यमराज उस दरवाजे के पार की दुनिया का नज़ारा नचिकेता को दिखाने जा रहे हैं।
        """.trimIndent(),
        english = """
            (Yama says): O Gautama (Nachiketa)! Listen, now I shall declare to you the profound secret of that highly hidden (Guhya) and eternal (Sanatana) Brahman.
            And I shall also clearly and precisely explain to you what exactly happens after attaining physical death (Maranam).
            What ultimately becomes of this individual soul (Atman) and what state or destination it eventually reaches (Bhavati).
            Here Yama is about to unlock the most mysterious and intimidating aspect of this subject—Reincarnation.
            People constantly wonder: Do our karmas end after death? Do we just go to sleep permanently forever?
            Yama declares that death is absolutely not a Full Stop; it is merely a temporary Comma in the soul's journey.
            The knowledge of the eternal Brahman is highly 'Guhya' (secret), because an ordinary human intellect cannot easily accept it.
            Nachiketa's absolute qualification has been proven, so Yama is now going to reveal the strict laws of karma without hesitation.
            This verse creates an exceptionally thrilling build-up for the very next verse (where the theory of rebirth is explained).
            Death is merely a door, and Lord Yama is about to show young Nachiketa the vivid view of the world beyond that door.
        """.trimIndent()
    ),

    KathaShloka(
        id = 93,
        sanskrit = "योनिमन्ये प्रपद्यन्ते शरीरत्वाय देहिनः । स्थाणुमन्येऽनुसंयन्ति यथाकर्म यथाश्रुतम् ॥ ७ ॥",
        hindi = """
            (यमराज पुनर्जन्म का नियम बताते हैं): मृत्यु के बाद, कुछ अज्ञानी जीवात्माएं नया शरीर (शरीरत्वाय) धारण करने के लिए।
            किसी दूसरी माता के गर्भ (योनि) में प्रवेश कर जाती हैं (और मनुष्य या पशु के रूप में जन्म लेती हैं)।
            और कुछ अन्य जीवात्माएं तो (अपने महापापों के कारण) वृक्ष, पौधे या पत्थर (स्थाणु) जैसी जड़ अवस्था को भी प्राप्त हो जाती हैं।
            यह सब पूरी तरह से उनके द्वारा किए गए कर्मों (यथाकर्म) और उनके द्वारा प्राप्त किए गए ज्ञान/विचारों (यथाश्रुतम्) के अनुसार ही होता है।
            यह श्लोक कर्म सिद्धांत (Law of Karma) का सबसे कठोर और अकाट्य नियम (Infallible rule) है।
            मौत के बाद भगवान किसी को अपनी मर्जी से सजा या इनाम नहीं देते; हमारे अपने ही कर्म हमारा अगला जन्म तय करते हैं।
            'यथाकर्म'—यदि हमने जानवरों जैसा हिंसक कर्म किया है, तो प्रकृति हमें अगले जन्म में जानवर का ही शरीर देगी।
            'यथाश्रुतम्'—यदि हमारी सोच (ज्ञान) जड़ और आलसी (पेड़ जैसी) रही है, तो हम अगले जन्म में पेड़ (स्थाणु) ही बनेंगे।
            यह कर्मों का ऑटोमैटिक सिस्टम (Automatic system) है जहाँ कोई रिश्वत काम नहीं आती।
            परंतु जो ज्ञानी है, वह इन योनियों (Wombs) में नहीं जाता; वह कर्मों को जलाकर सीधे उस ब्रह्म में समा जाता है।
        """.trimIndent(),
        english = """
            (Yama explains the law of rebirth): After death, some ignorant individual souls, in order to assume a new physical body (Shariratvaya).
            Enter into the womb (Yoni) of another mother (and take birth as human beings or various animals).
            And certain other souls (due to their grave sins) even descend to completely inert states like trees, plants, or stones (Sthanu).
            All of this happens strictly and perfectly according to their past actions (Yathakarma) and the knowledge/thoughts they acquired (Yathashrutam).
            This verse is the most rigorous and absolutely infallible rule of the Law of Karma in Indian philosophy.
            God does not arbitrarily punish or reward anyone after death; our very own karmas strictly determine our next birth.
            'Yathakarma'—if we have acted violently like animals, Nature will automatically assign us an animal's body in the next life.
            'Yathashrutam'—if our thoughts (knowledge) were entirely inert and lazy (like a tree), we will literally become a tree (Sthanu).
            This is a highly flawless automatic system of karma where absolutely no bribes or excuses can ever work.
            But the truly wise man does not enter these wombs; he completely burns his karmas and merges directly into Brahman.
        """.trimIndent()
    ),
    KathaShloka(
        id = 94,
        sanskrit = "य एष सुप्तेषु जागर्ति कामं कामं पुरुषो निर्मिमाणः । तदेव शुक्रं तद्ब्रह्म तदेवामृतमुच्यते । तस्मिँल्लोकाः श्रिताः सर्वे तदु नात्येति कश्चन । एतद्वै तत् ॥ ८ ॥",
        hindi = """
            जब हम सब गहरी नींद में सो जाते हैं (सुप्तेषु), तब भी जो परम पुरुष (परमात्मा) हमारे भीतर हमेशा जागता (जागर्ति) रहता है।
            और जो हमारे सपनों में हमारी इच्छाओं के अनुसार (कामं कामं) अनेकों दृश्यों और भोगों का निर्माण (रचना) करता है।
            वही परम पुरुष अत्यंत शुद्ध (शुक्रं) है, वही साक्षात् परब्रह्म है, और केवल उसी को 'अमृत' (अमर) कहा जाता है।
            उसी एक परब्रह्म के आश्रय में यह संपूर्ण लोक और ब्रह्मांड टिके (श्रिताः) हुए हैं, और कोई भी उसका उल्लंघन नहीं कर सकता।
            तुमने जो पूछा था, "निश्चित रूप से यही वह (परम तत्व) है।"
            नींद एक छोटी मौत है; जब हम सोते हैं, तो हमारा शरीर और बुद्धि काम करना बंद कर देते हैं।
            पर सपनो की दुनिया कौन बनाता है? वह हमारी चेतना (आत्मा) है जो कभी नहीं सोती, वह हमेशा जागृत (Witness) रहती है।
            सपनों की तरह ही यह जाग्रत दुनिया भी उसी चेतना द्वारा रची गई एक फिल्म (Illusion) है।
            वह चेतना 'शुक्र' (पवित्र) है क्योंकि सपनों के गंदे या डरावने दृश्यों का उस पर कोई दाग नहीं लगता।
            जो नींद में भी जागता है, वही असली ईश्वर है; और जो कोई उसका ध्यान करता है, वह भी उसी के समान अमर हो जाता है।
        """.trimIndent(),
        english = """
            When we all fall fast asleep (Supteshu), that Supreme Person who remains perpetually awake (Jagarti) right within us.
            And who continuously constructs (creates) numerous objects and experiences in our dreams according to our desires (Kamam kamam).
            That Supreme Person is absolutely pure (Shukram), He is the direct Supreme Brahman, and He alone is called 'Amrita' (Immortal).
            In that single Supreme Brahman, all the worlds and universes rest securely (Shritah), and absolutely no one can ever transcend Him.
            What you had asked, "This indeed is exactly That (the Supreme Principle)."
            Sleep is a mini-death; when we sleep, our physical body and intellect completely shut down and stop working.
            But who creates the vivid world of dreams? It is our Consciousness (Soul) which never sleeps; it is eternally awake (the Witness).
            Just like dreams, this waking world is also merely a magnificent movie (illusion) projected by that exact same Consciousness.
            That Consciousness is 'Shukra' (pure) because the dirty or terrifying scenes of dreams leave absolutely no stain on it.
            The One who stays fully awake even during deep sleep is the true God; whoever meditates on Him becomes immortal like Him.
        """.trimIndent()
    ),
    KathaShloka(
        id = 95,
        sanskrit = "अग्निर्यथैको भुवनं प्रविष्टो रूपं रूपं प्रतिरूपो बभूव । एकस्तथा सर्वभूतान्तरात्मा रूपं रूपं प्रतिरूपो बहिश्च ॥ ९ ॥",
        hindi = """
            जिस प्रकार यह अग्नि (आग) मूल रूप से केवल 'एक' ही है, परंतु जब वह इस संसार (भुवन) में प्रवेश करती है।
            तो वह जिस-जिस वस्तु (लकड़ी, कोयला, लोहा) को जलाती है, वह बिल्कुल उसी वस्तु के आकार और रूप (प्रतिरूप) जैसी दिखाई देने लगती है।
            ठीक उसी प्रकार, वह सभी प्राणियों की अंतरात्मा (ईश्वर) भी मूल रूप से केवल 'एक' ही है।
            परंतु वह जिस-जिस शरीर (इंसान, जानवर, पेड़) में प्रवेश करती है, वह उसी के रूप जैसी दिखने लगती है; और वह उन शरीरों से बाहर (बहिः) भी मौजूद है।
            यह श्लोक अद्वैत दर्शन का सबसे क्लासिक (Classic) और शानदार उदाहरण है।
            आग का अपना कोई निश्चित आकार नहीं होता; गोल लकड़ी में वह गोल दिखती है, लंबी लकड़ी में वह लंबी दिखती है।
            इसी तरह, आत्मा का अपना कोई रूप नहीं है; वह हाथी में हाथी जैसी और चींटी में चींटी जैसी लगती है।
            हमें लगता है कि दुनिया में करोड़ों अलग-अलग जीव हैं, पर यह हमारी आँखों का धोखा है; उन सबमें एक ही 'आग' जल रही है।
            'बहिश्च' (बाहर भी) का अर्थ है कि वह आत्मा शरीरों में बँधी हुई नहीं है; शरीरों के जल जाने के बाद भी वह चेतना बाहर ब्रह्मांड में मौजूद रहती है।
            इस ज्ञान को पाने के बाद इंसान किसी भी प्राणी से नफरत नहीं कर सकता, क्योंकि सबमें उसे अपना ही रूप (प्रतिरूप) दिखाई देता है।
        """.trimIndent(),
        english = """
            Just as Fire is fundamentally only 'One', but the moment it completely enters and manifests in this world (Bhuvana).
            It perfectly assumes the exact shape and form (Pratirupa) of every single object (wood, coal, iron) that it burns.
            In the exact same way, the Supreme Inner Soul (God) of all living beings is also fundamentally only 'One'.
            But whichever physical body (human, animal, tree) It enters, It appears to take that very shape; yet It also exists boundlessly outside (Bahishcha) them all.
            This verse is the most classic, brilliant, and widely cited example of Advaita (Non-dual) philosophy.
            Fire has no fixed shape of its own; in a round log, it looks round, and in a long log, it looks long.
            Similarly, the Soul has no form of its own; it appears elephant-like in an elephant and ant-like in an ant.
            We falsely think there are billions of different souls, but it's an optical illusion; the exact same 'Fire' burns within everyone.
            'Bahishcha' (outside too) means the Soul is not imprisoned in bodies; even after bodies burn, that Consciousness remains omnipresent outside.
            After attaining this wisdom, a human can never hate any creature, because he clearly sees his own reflection (Pratirupa) in all.
        """.trimIndent()
    ),
    KathaShloka(
        id = 96,
        sanskrit = "वायुर्यथैको भुवनं प्रविष्टो रूपं रूपं प्रतिरूपो बभूव । एकस्तथा सर्वभूतान्तरात्मा रूपं रूपं प्रतिरूपो बहिश्च ॥ १० ॥",
        hindi = """
            जिस प्रकार यह वायु (हवा) मूल रूप से केवल 'एक' ही है, परंतु जब वह इस संसार में प्रवेश करती है।
            तो वह जिस-जिस वस्तु (बांसुरी, शंख, टायर, गुब्बारा) में जाती है, वह बिल्कुल उसी वस्तु के आकार (प्रतिरूप) जैसी हो जाती है।
            ठीक उसी प्रकार, वह सभी प्राणियों की अंतरात्मा (ईश्वर) भी मूल रूप से केवल 'एक' ही है।
            परंतु वह जिस-जिस शरीर में प्रवेश करती है, वह उसी शरीर के रूप जैसी (प्रतिरूप) हो जाती है; और वह उन शरीरों से परे (बाहर) भी व्यापक है।
            अग्नि के बाद यमराज 'वायु' का उदाहरण देकर इस एकता के सिद्धांत को और भी पक्का कर रहे हैं।
            हवा जब बांसुरी से निकलती है तो संगीत बन जाती है, और जब शंख से निकलती है तो तेज ध्वनि बन जाती है।
            हवा में कोई भेद नहीं है, भेद केवल उन यंत्रों (Instruments) में है जिनमें से वह गुजर रही है।
            उसी तरह, एक अच्छा इंसान और एक बुरा इंसान—दोनों के भीतर चेतना (आत्मा) बिल्कुल एक ही है।
            बुरा इंसान केवल एक 'खराब बांसुरी' की तरह है जिससे बेसुरी आवाज़ आ रही है, पर उसके भीतर की हवा (आत्मा) अशुद्ध नहीं है।
            जब हम इस बात को गहराई से समझते हैं, तो हमारी दृष्टि शरीरों (यंत्रों) से हटकर उस एक 'हवा' (आत्मा) पर टिक जाती है।
        """.trimIndent(),
        english = """
            Just as the Air (Wind) is fundamentally only 'One', but the moment it completely enters and blows through this world.
            It perfectly assumes the exact shape and form (Pratirupa) of every single object (flute, conch, balloon) it fills.
            In the exact same way, the Supreme Inner Soul (God) of all living beings is also fundamentally only 'One'.
            But whichever physical body It enters, It appears to take that very shape (Pratirupa); yet It also exists infinitely outside them all.
            After Fire, Yama gives the powerful example of 'Air' to solidify and cement this profound principle of Oneness.
            When air passes through a flute, it becomes sweet music, and when through a conch, it becomes a loud, roaring sound.
            There is absolutely no difference in the air itself; the difference lies solely in the instruments it passes through.
            Similarly, a saintly person and a wicked person—the core Consciousness (Soul) within both is exactly the same.
            A wicked person is merely like a 'broken flute' producing harsh noise, but the air (Soul) inside him is never impure.
            When we understand this deeply, our vision permanently shifts from the physical bodies (instruments) directly to that one 'Air' (Soul).
        """.trimIndent()
    ),

    KathaShloka(
        id = 97,
        sanskrit = "सूर्यो यथा सर्वलोकस्य चक्षुर्न लिप्यते चाक्षुषैर्बाह्यदोषैः । एकस्तथा सर्वभूतान्तरात्मा न लिप्यते लोकदुःखेन बाह्यः ॥ ११ ॥",
        hindi = """
            जिस प्रकार 'सूर्य' इस पूरे संसार की आँख (सबको प्रकाश और दृष्टि देने वाला) है।
            फिर भी वह मनुष्यों की आँखों के बाहरी दोषों (जैसे मोतियाबिंद या पीलिया) या दुनिया की गंदगी से बिल्कुल भी लिप्त (गंदा) नहीं होता।
            ठीक उसी प्रकार, वह एक अद्वितीय परमात्मा सभी प्राणियों की अंतरात्मा (चेतना का प्रकाश) है।
            फिर भी वह इस संसार के किसी भी दुख, पाप या गंदगी से बिल्कुल लिप्त (प्रभावित) नहीं होता, क्योंकि वह इन सबसे पूरी तरह परे (बाह्य) है।
            यह श्लोक अद्वैत दर्शन पर उठने वाले सबसे बड़े सवाल का जवाब देता है।
            सवाल यह है: अगर भगवान ही मेरे अंदर है, तो जब मैं दुखी होता हूँ या पाप करता हूँ, तो क्या भगवान भी दुखी और पापी हो जाता है?
            यमराज उत्तर देते हैं: बिल्कुल नहीं! जैसे सूरज की रोशनी कीचड़ पर गिरती है, पर सूरज गंदा नहीं होता।
            या जैसे आपकी आँख में मोतियाबिंद हो, तो आपको धुंधला दिखता है, पर इससे सूरज की रोशनी कम नहीं होती।
            उसी तरह, दुख और पाप आपके शरीर और 'अहंकार' (Ego) की बीमारी हैं; आत्मा इन सबसे अछूती (Untouched) और शुद्ध है।
            आत्मा केवल एक 'लाइट' (Light) है जो आपको सोचने की ताकत देती है, पर वह आपके विचारों से कभी गंदी नहीं होती।
        """.trimIndent(),
        english = """
            Just as the 'Sun' is the ultimate eye of the entire world (providing light and vision to absolutely everyone).
            Yet it is never, ever tainted or polluted (Lipyate) by the external defects of human eyes (like cataracts) or the filth of the world.
            In the exact same way, that one non-dual Supreme Lord is the Inner Soul (the light of consciousness) of all living beings.
            Yet He is never tainted or affected by any worldly sorrow, pain, or sin, because He exists completely beyond (Bahyah) them all.
            This verse brilliantly answers the biggest, most critical question often raised against the philosophy of Advaita.
            The question is: If God Himself is inside me, then when I suffer or commit a sin, does God also suffer and become a sinner?
            Yama answers: Absolutely not! Just as sunlight falls on filthy mud, but the sun itself never becomes dirty.
            Or if you have a cataract in your eye, your vision is blurry, but that doesn't diminish the pure light of the sun.
            Similarly, sorrow and sins are strictly diseases of your physical body and 'Ego'; the Soul is completely untouched and pure.
            The Soul is merely a 'Light' that gives you the power to think, but it is never polluted by the nature of your thoughts.
        """.trimIndent()
    ),
    KathaShloka(
        id = 98,
        sanskrit = "एको वशी सर्वभूतान्तरात्मा एकं रूपं बहुधा यः करोति । तमात्मस्थं येऽनुपश्यन्ति धीरास्तेषां सुखं शाश्वतं नेतरेषाम् ॥ १२ ॥",
        hindi = """
            वह परमात्मा केवल एक है, सबको अपने पूर्ण वश (नियंत्रण) में रखने वाला है, और वह सभी प्राणियों की परम अंतरात्मा है।
            जो अपनी माया शक्ति से अपने उस 'एक' ही रूप को अनगिनत विविध रूपों (बहुधा) में बदल देता है।
            उस परमेश्वर को जो धीर (बुद्धिमान और ज्ञानी) पुरुष अपनी ही आत्मा के भीतर (आत्मस्थं) साक्षात् देखते हैं।
            केवल उन्हीं ज्ञानी पुरुषों को शाश्वत (हमेशा रहने वाला) सुख प्राप्त होता है, अज्ञानियों (इतरेषाम्) को कभी नहीं।
            यह श्लोक श्वेताश्वतर उपनिषद (6.12) के बिल्कुल समान है, जो ईश्वर के नियंत्रण और अद्वैत को बताता है।
            इस दुनिया में जो भी हो रहा है, वह आउट ऑफ कंट्रोल (Out of control) नहीं है; वह 'वशी' (मालिक) सब कुछ संभाल रहा है।
            जैसे एक ही मिट्टी से सैकड़ों अलग-अलग बर्तन बनते हैं, वैसे ही वह एक ईश्वर अपनी माया से इस पूरी दुनिया के रूप में फैल गया है।
            हम सुख को दुकानों में, मोबाइल में या दूसरों के प्यार में ढूँढते हैं, जो कल खत्म हो जाएंगे।
            पर जो साधक अपनी आँखें बंद करके उस ईश्वर को अपने ही हृदय में (आत्मस्थ) खोज लेता है, उसे ऐसा सुख मिलता है जो कभी खत्म नहीं होता।
            असली और 'शाश्वत सुख' कोई बाहरी वस्तु नहीं है, वह आपके अपने भीतर की शांति का जागरण है।
        """.trimIndent(),
        english = """
            That Supreme Lord is absolutely One, the supreme Controller (Vashi) of all, and He is the ultimate Inner Soul of all beings.
            Who, through His phenomenal power of Maya, effortlessly multiplies His 'One' single form into incredibly diverse, manifold forms (Bahudha).
            Those wise and highly patient men (Dhira) who directly perceive that Lord as seated right within their own souls (Atmastham).
            Only to those wise ones belongs eternal (everlasting) happiness, and never, ever to the ignorant others (Itaresham).
            This verse is identical to Shvetashvatara Upanishad (6.12), profoundly highlighting God's absolute control and Non-duality.
            Whatever is happening in this world is not 'out of control'; that 'Vashi' (Master) is managing absolutely everything perfectly.
            Just as hundreds of differently shaped pots are made from the exact same clay, God has expanded into this diverse world through Maya.
            We foolishly search for joy in shops, gadgets, or the fleeting love of others, all of which will inevitably perish tomorrow.
            But the seeker who closes his eyes and discovers that Lord inside his own heart (Atmastha), attains a joy that simply never ends.
            True and 'eternal happiness' is never an external object to be acquired; it is the ultimate awakening of profound peace within you.
        """.trimIndent()
    ),
    KathaShloka(
        id = 99,
        sanskrit = "नित्योऽनित्यानां चेतनश्चेतनानामेको बहूनां यो विदधाति कामान् । तमात्मस्थं येऽनुपश्यन्ति धीरास्तेषां शान्तिः शाश्वती नेतरेषाम् ॥ १३ ॥",
        hindi = """
            वह परमात्मा सभी अनित्य (नाशवान) वस्तुओं के बीच एकमात्र 'नित्य' (हमेशा रहने वाला) सत्य है।
            वह सभी चेतन जीवों (आत्माओं) की परम 'चेतना' है; और वह अकेला होकर भी अनगिनत जीवों की सभी इच्छाओं (कामनाओं) को पूरा करता है।
            उस परमेश्वर को जो धीर (ज्ञानी) पुरुष अपनी ही आत्मा के भीतर (आत्मस्थं) विराजमान देखते और अनुभव करते हैं।
            केवल उन्हीं ज्ञानी पुरुषों को शाश्वत (कभी न मिटने वाली) शांति प्राप्त होती है, दूसरों (अज्ञानियों) को कभी नहीं।
            यह श्लोक भी श्वेताश्वतर (6.13) के समान है; पिछले श्लोक में 'सुख' की बात थी, यहाँ 'शांति' की बात है।
            दुनिया की हर चीज़ मिटने वाली है, पर उस मिटने वाली दुनिया का जो बेस (Base/Foundation) है, वह नित्य ईश्वर है।
            हम जो भी मांगते हैं, वह हमें कोई बॉस (Boss) या सरकार नहीं देती; हमारी कर्मों की इच्छाएं पूरी करने वाला वह एक ही ईश्वर है।
            हम बाहर कितनी भी संपत्ति इकट्ठी कर लें, मन की शांति पैसे से नहीं खरीदी जा सकती।
            'शाश्वत शांति' (Permanent Peace) केवल तब मिलती है जब इंसान का अहंकार शून्य हो जाता है और वह भगवान को अपने अंदर महसूस करता है।
            जब तक इंसान दुनिया से जुड़ा है, वह अशांत रहेगा; जब वह आत्मा से जुड़ता है, तो वह परम शांत हो जाता है।
        """.trimIndent(),
        english = """
            That Supreme Lord is the only absolute 'Eternal' (Nitya) Truth existing amidst all these transient, perishable things.
            He is the supreme 'Consciousness' of all conscious souls; and though He is One, He flawlessly fulfills the desires of countless beings.
            Those wise and patient men (Dhira) who directly perceive that Lord as reigning supremely right within their own souls (Atmastham).
            Only to those wise ones belongs eternal (everlasting) peace, and never, ever to the ignorant others (Itaresham).
            This verse is also identical to Shvetashvatara (6.13); the previous verse spoke of 'happiness', this one speaks of 'peace'.
            Everything in the world is destined to perish, but the ultimate Foundation (Base) of this perishable world is that eternal God.
            Whatever we ask for is not given by a boss or a government; it is that one God alone who dispenses the fruits of our desires.
            No matter how much massive wealth we accumulate externally, peace of mind can absolutely never be bought with money.
            'Permanent Peace' is attained exclusively when human ego drops to zero and one deeply feels God's presence inside.
            As long as a person is attached to the world, he will remain restless; when he connects to the Soul, he becomes perfectly peaceful.
        """.trimIndent()
    ),
    KathaShloka(
        id = 100,
        sanskrit = "तदेतदिति मन्यन्तेऽनिर्देश्यं परमं सुखम् । कथं नु तद्विजानीयां किमु भाति विभाति वा ॥ १४ ॥",
        hindi = """
            (नचिकेता पूछता है): ज्ञानी लोग उस 'अनिर्देश्य' (जिसे शब्दों में बताया या इशारा नहीं किया जा सकता) परम सुख (ब्रह्मानंद) को।
            "यह वही है" (तदेतद्) ऐसा मानकर प्रत्यक्ष अनुभव करते हैं।
            परंतु हे यमराज! मैं उस परम आनंद को आखिर कैसे जानूँ और अनुभव करूँ?
            क्या वह परमात्मा स्वयं अपने-आप चमकता (भाति) है? या वह किसी और के प्रकाश से प्रकाशित (विभाति) होता है?
            नचिकेता का यह प्रश्न बहुत ही गहरा और तकनीकी (Technical) है।
            हम दुनिया की किसी भी चीज़ को उंगली दिखाकर बता सकते हैं कि "यह गाय है" या "यह पेड़ है" (निर्देश्य)।
            पर ईश्वर को उंगली दिखाकर नहीं बताया जा सकता (अनिर्देश्य), क्योंकि उंगली भी उसी के प्रकाश से उठ रही है।
            तो नचिकेता पूछ रहा है कि जब उसे बताया ही नहीं जा सकता, तो ज्ञानी लोग उसे 'पकड़ते' कैसे हैं?
            क्या ईश्वर एक बल्ब की तरह है जो खुद चमकता है, या चाँद की तरह है जो सूरज की रोशनी से चमकता है?
            यह सवाल यमराज को उस सबसे महान जवाब की ओर ले जाता है जो पूरे उपनिषद साहित्य का सबसे चमकता हुआ सितारा है (अगले श्लोक में)।
        """.trimIndent(),
        english = """
            (Nachiketa asks): The wise sages directly experience that 'Anirdeshya' (indefinable/which cannot be pointed out) supreme bliss (Brahmananda).
            By profoundly recognizing and feeling it internally as, "This indeed is That" (Tadetad).
            But O Lord Yama! How on earth can I possibly know and directly experience that ultimate, supreme bliss?
            Does that Supreme Lord shine brilliantly by His own inherent light (Bhati)? Or does He shine by reflecting the light of another (Vibhati)?
            Nachiketa's question here is exceedingly profound and highly technical in nature.
            We can easily point a finger at anything in the world and specify, "This is a cow" or "This is a tree" (Nirdeshya).
            But God simply cannot be pointed at (Anirdeshya), because the very finger pointing is energized by His light alone.
            So Nachiketa is asking: if He absolutely cannot be described or pointed out, how do the wise sages 'grasp' Him?
            Is God like a lightbulb that shines by itself, or is He like the moon that shines by reflecting the sun's light?
            This highly intelligent question leads Yama directly to the greatest answer, which is the brightest star of all Upanishadic literature (in the next verse).
        """.trimIndent()
    ),
    // ... Paste these directly after Shloka 100 in your kathaShlokasList ...

    KathaShloka(
        id = 101,
        sanskrit = "न तत्र सूर्यो भाति न चन्द्रतारकं नेमा विद्युतो भान्ति कुतोऽयमग्निः । तमेव भान्तमनुभाति सर्वं तस्य भासा सर्वमिदं विभाति ॥ १५ ॥",
        hindi = """
            (यमराज नचिकेता के प्रश्न का सबसे महान उत्तर देते हैं): उस परब्रह्म के परम प्रकाश में न तो सूर्य चमकता है।
            वहाँ न तो चंद्रमा की कोई चमक है, और न ही आकाश के ये करोड़ों तारे वहाँ कोई प्रकाश दे सकते हैं।
            वहाँ आकाश की ये तेज बिजलियां भी नहीं चमक सकतीं, तो फिर इस पृथ्वी की इस तुच्छ आग की तो बात ही क्या?
            वास्तव में, केवल उसी एक परमात्मा के प्रकाशित होने पर ही यह सारा ब्रह्मांड उसके पीछे-पीछे प्रकाशित होता है।
            केवल और केवल उसी ईश्वर की परम आभा (रौशनी) से यह सूरज, चाँद और पूरी दुनिया चमक रही है।
            नचिकेता ने पूछा था कि क्या भगवान खुद चमकता है या किसी और की लाइट से चमकता है?
            यमराज कहते हैं कि दुनिया की हर लाइट उसी से है; वह किसी से उधार की रोशनी नहीं लेता।
            जैसे बैटरी के बिना बल्ब नहीं जल सकता, वैसे ही आत्मा के बिना सूरज भी एक अंधा गोला मात्र है।
            हम भगवान को बाहर की लाइट से ढूँढने की कोशिश करते हैं, पर वह खुद ही सभी लाइटों का सोर्स (Source) है।
            यह श्लोक भारतीय दर्शन का मुकुटमणि है, जो आत्मा के स्वयं-प्रकाशित (Self-luminous) स्वरूप को सिद्ध करता है।
        """.trimIndent(),
        english = """
            (Yama gives the greatest answer to Nachiketa's question): There, in the supreme presence of Brahman, the sun does not shine.
            There, the moon has absolutely no radiance, nor can the millions of stars in the sky give any light.
            There, the bright flashes of lightning cannot shine, so what can be said of this tiny, insignificant earthly fire?
            In reality, it is only when that one Supreme Lord shines that this entire universe shines entirely after Him.
            It is solely and exclusively by His supreme radiance (Light) that the sun, moon, and this whole world shine.
            Nachiketa had asked whether God shines by His own light or reflects the light of another.
            Yama answers that every single light in the universe comes from Him; He borrows light from absolutely no one.
            Just as a bulb cannot glow without a battery, the sun is merely a blind sphere without the presence of the Soul.
            We foolishly try to search for God using external lights, but He Himself is the ultimate Source of all lights.
            This verse is the absolute crown jewel of Indian philosophy, perfectly proving the self-luminous nature of the Soul.
        """.trimIndent()
    ),
    KathaShloka(
        id = 102,
        sanskrit = "ऊर्ध्वमूलोऽवाक्शाख एषोऽश्वत्थः सनातनः । तदेव शुक्रं तद्ब्रह्म तदेवामृतमुच्यते । तस्मिँल्लोकाः श्रिताः सर्वे तदु नात्येति कश्चन । एतद्वै तत् ॥ १ ॥",
        hindi = """
            (छठी वल्ली प्रारंभ): यह संसार एक पीपल के पेड़ (अश्वत्थ) के समान है, जिसकी जड़ें ऊपर की ओर (ऊर्ध्वमूल) हैं।
            और जिसकी शाखाएं (डालियां) नीचे की ओर (अवाक्शाख) फैली हुई हैं; यह संसार रूपी वृक्ष अत्यंत सनातन (पुराना) है।
            इस वृक्ष की जो सबसे ऊपर की 'जड़' है, वही परम शुद्ध (शुक्रं) है, वही ब्रह्म है, और उसी को अमर (अमृत) कहा जाता है।
            उसी एक परब्रह्म रूपी जड़ के आश्रय में यह संपूर्ण ब्रह्मांड और सभी लोक टिके (श्रिताः) हुए हैं।
            दुनिया का कोई भी प्राणी या देवता उस ब्रह्म का उल्लंघन नहीं कर सकता; "निश्चित रूप से यही वह (सत्य) है।"
            यह भगवद्गीता (15.1) का सबसे प्रसिद्ध 'उल्टे पेड़' का रूपक (Metaphor) है जो यहाँ से लिया गया है।
            संसार का पेड़ उल्टा क्यों है? क्योंकि इसकी जड़ें (भगवान/कारण) स्वर्ग में हैं, और इसकी डालियां (इंसान/कार्य) धरती पर हैं।
            'अश्वत्थ' का शाब्दिक अर्थ है 'जो कल तक नहीं टिकेगा' (अ-श्व-त्थ)—यानी यह संसार लगातार बदल रहा है और नाशवान है।
            परंतु इस बदलते हुए पेड़ को ज़िंदा रखने वाली जड़ 'ब्रह्म' है, जो कभी नहीं बदलती और हमेशा अमर रहती है।
            यदि हमें इस पेड़ के दुखों से मुक्त होना है, तो हमें डालियों को छोड़कर उस परम 'जड़' को पकड़ना होगा।
        """.trimIndent(),
        english = """
            (Beginning of Valli 6): This world is exactly like a Peepal tree (Ashvattha) whose roots are entirely upwards (Urdhvamula).
            And whose branches physically spread and extend downwards (Avakshakha); this tree of the world is extremely ancient (Sanatana).
            The topmost 'Root' of this tree is absolutely pure (Shukram), That is Brahman, and That alone is called immortal (Amrita).
            It is solely relying upon that one Supreme Brahman-root that this entire universe and all worlds are firmly supported (Shritah).
            Absolutely no creature or god in the world can ever transcend that Brahman; "This indeed is exactly That (the Truth)."
            This is the highly famous 'Inverted Tree' metaphor of the Bhagavad Gita (15.1), originally taken directly from here.
            Why is the world's tree upside down? Because its roots (God/Cause) are in heaven, and its branches (humans/Effects) are on earth.
            'Ashvattha' literally means 'that which will not last until tomorrow' (A-shva-ttha)—meaning this world is constantly changing and perishable.
            But the Root keeping this changing tree alive is 'Brahman', which absolutely never changes and remains forever immortal.
            If we want to be completely freed from the sorrows of this tree, we must let go of the branches and firmly grasp that Supreme 'Root'.
        """.trimIndent()
    ),
    KathaShloka(
        id = 103,
        sanskrit = "यदिदं किञ्च जगत् सर्वं प्राण एजति निःसृतम् । महद्भयं वज्रमुद्यतं य एतद्विदुरमृतास्ते भवन्ति ॥ २ ॥",
        hindi = """
            यह जो कुछ भी संपूर्ण दृश्यमान जगत दिखाई दे रहा है, वह सब उसी 'प्राण' (परमेश्वर) से ही निकला (निःसृतम्) है।
            और उसी के परम अनुशासन में रहकर यह पूरा ब्रह्मांड निरंतर गति कर रहा है और कांप (एजति) रहा है।
            वह परमात्मा उठे हुए अत्यंत भयंकर 'वज्र' (हथियार) के समान है, जिससे सभी भयभीत (महद्भयं) रहते हैं और नियम का पालन करते हैं।
            जो ज्ञानी मनुष्य इस महान शासक और परम तत्व को यथार्थ रूप में जान लेते हैं, वे हमेशा के लिए अमर हो जाते हैं।
            भगवान केवल प्यार का सागर नहीं है; वह प्रकृति के नियमों का सबसे कठोर और सख्त प्रशासक (Administrator) भी है।
            ग्रहों का अपनी कक्षा में घूमना और समय का चलना—यह सब ईश्वर के 'वज्र' (कठोर अनुशासन) के डर से हो रहा है।
            जैसे किसी सख्त राजा के उठाए हुए कोड़े (वज्र) के डर से राज्य में सब काम सही होता है, वैसे ही यह ब्रह्मांड चल रहा है।
            ईश्वर के इस 'भय' का अर्थ यह है कि प्रकृति के नियम अटूट हैं; जो आग में हाथ डालेगा, वह निश्चित रूप से जलेगा।
            अज्ञानी मनुष्य इस नियम से टकराकर दुखी होता है, जबकि ज्ञानी इस नियम (ब्रह्म) को समझकर इसके साथ तालमेल बिठा लेता है।
            ईश्वर के अनुशासन को पहचान लेना ही असली ज्ञान है, जिससे इंसान मौत के डर से मुक्त होकर अमरता पाता है।
        """.trimIndent(),
        english = """
            Whatever this entire visible universe appears to be, it has completely emerged (Nihsritam) from that one 'Prana' (Supreme Lord).
            And existing entirely under His supreme discipline, this whole cosmos continuously moves, vibrates, and trembles (Ejati).
            That Supreme Lord is exactly like a terrifying, upraised 'Thunderbolt' (Vajra), out of great fear of whom everyone strictly obeys the laws.
            Those wise men who truly realize this absolute Ruler and Supreme Principle in His reality, become immortal forever.
            God is not merely an ocean of love; He is also the most rigorous and strict Administrator of the absolute laws of nature.
            The planets revolving in their orbits and the flow of time—all this happens purely out of fear of God's 'Vajra' (strict discipline).
            Just as everything runs perfectly in a kingdom out of fear of a strict king's raised whip (Vajra), so does this cosmos operate.
            This 'fear' of God means that the laws of nature are completely unbreakable; whoever puts a hand in the fire will definitely burn.
            An ignorant man clashes with this law and suffers, while the wise man understands this law (Brahman) and harmonizes with it perfectly.
            Recognizing and accepting God's absolute discipline is true wisdom, freeing a human from the fear of death to attain immortality.
        """.trimIndent()
    ),
    KathaShloka(
        id = 104,
        sanskrit = "भयादस्याग्निस्तपति भयात्तपति सूर्यः । भयादिन्द्रश्च वायुश्च मृत्युर्धावति पञ्चमः ॥ ३ ॥",
        hindi = """
            उसी परमेश्वर के महान भय (अनुशासन) से ही यह अग्नि भयंकर रूप से जलती (तपती) है।
            उसी के भय से यह सूर्य नियमित रूप से उदय होता है और संसार को प्रकाश व गर्मी (तपति) देता है।
            उसी ईश्वर के भय से इंद्र (वर्षा का देवता) और वायु (हवा) अपना-अपना काम पूरी निष्ठा से करते हैं।
            और उसी के शासन और भय से पांचवां देवता मृत्यु (यमराज) भी बिना रुके अपने काम के लिए दौड़ता रहता है।
            यह श्लोक तैत्तिरीय उपनिषद में भी आता है, जो ईश्वर के सुप्रीम कंट्रोल (Supreme Control) को और भी गहरा करता है।
            हम सोचते हैं कि यमराज मौत का सबसे बड़ा राजा है, पर नचिकेता के सामने खुद यमराज अपनी सच्चाई बता रहे हैं।
            यमराज कह रहे हैं: "मैं भी स्वतंत्र नहीं हूँ; मैं भी उसी एक बॉस (ईश्वर) के आदेश और डर से भाग-भाग कर काम करता हूँ।"
            आग, हवा, सूरज और मौत—ये ब्रह्मांड की सबसे ताकतवर चीजें हैं, पर ये सब भगवान के मामूली कर्मचारी मात्र हैं।
            यह सुनकर नचिकेता का सारा डर खत्म हो जाता है, क्योंकि उसे पता चल जाता है कि मौत भी किसी और के कंट्रोल में है।
            जब हम सबसे बड़े मालिक (ईश्वर) की शरण में आ जाते हैं, तो दुनिया का कोई भी डर (यहाँ तक कि मौत भी) हमें डरा नहीं सकता।
        """.trimIndent(),
        english = """
            It is solely out of intense fear (discipline) of that Supreme Lord that the fire burns so fiercely and emits heat (Tapati).
            It is completely out of His fear that the sun rises regularly and continuously gives light and heat to the world.
            Out of profound fear of that very Lord, Indra (the god of rain) and Vayu (the wind) perform their duties with absolute dedication.
            And purely out of His governance and fear, the fifth deity, Death (Yama), runs relentlessly to perform his assigned duty.
            This verse also appears in the Taittiriya Upanishad, profoundly deepening the concept of God's Supreme Control.
            We think Yama is the absolute king of death, but directly before Nachiketa, Yama Himself reveals His own true reality.
            Yama is saying: "I am not independent either; I too run around and work strictly under the command and fear of that one Boss (God)."
            Fire, wind, sun, and death—these are the most powerful things in the cosmos, yet they are merely minor employees of God.
            Hearing this, all of Nachiketa's fears completely vanish, for he realizes that even Death is controlled by someone else.
            When we take absolute refuge in the highest Master (God), absolutely no fear in the world (not even death) can ever frighten us.
        """.trimIndent()
    ),
    KathaShloka(
        id = 105,
        sanskrit = "इह चेदशकदबोद्धुं प्राक् शरीरस्य विस्रसः । ततः सर्गेषु लोकेषु शरीरत्वाय कल्पते ॥ ४ ॥",
        hindi = """
            यदि कोई मनुष्य इस भौतिक शरीर के गिरने (मृत्यु) से पहले (प्राक्), इसी जीवन में (इह)।
            उस परब्रह्म को भलीभांति जानने (बोद्धुम्) और अनुभव करने में पूरी तरह समर्थ (सफल) हो जाता है, (तो वह मुक्त हो जाता है)।
            परंतु यदि वह इस शरीर के रहते हुए उसे जानने में असमर्थ रहता है (चुक जाता है)।
            तो उसे बार-बार इस सृष्टि के विभिन्न लोकों (सर्गेषु लोकेषु) में जाकर नया शरीर (शरीरत्वाय) धारण करने के लिए विवश होना पड़ता है।
            यह श्लोक इंसान को बहुत सख्त चेतावनी (Warning) दे रहा है कि आत्मज्ञान को कल पर मत टालो।
            कई लोग सोचते हैं कि "बुढ़ापे में भगवान का नाम लेंगे" या "मरने के बाद स्वर्ग में भगवान को ढूँढ लेंगे।"
            यमराज कहते हैं कि मरने के बाद कुछ नहीं मिलता; जो पाना है, वह इसी शरीर में, इसी धरती पर और अभी (इह) पाना होगा।
            मृत्यु कोई जादू नहीं है जो अज्ञानी इंसान को अचानक ज्ञानी बना दे; जैसी चेतना जीवन में है, वैसी ही मृत्यु के समय रहेगी।
            यदि हम इस सुनहरे मौके (मनुष्य जन्म) को गँवा देते हैं, तो प्रकृति हमें फिर से जन्म-मरण की लंबी और दुखदायी कतार में खड़ा कर देगी।
            यह श्लोक प्रोक्रेस्टिनेशन (Procrastination / टालमटोल) को आध्यात्म का सबसे बड़ा दुश्मन मानता है।
        """.trimIndent(),
        english = """
            If a human being, entirely before (Prak) the falling away (death) of this physical body, right here in this very life (Iha).
            Becomes completely capable and successful in truly knowing (Boddhum) and experiencing that Supreme Brahman, (he is liberated).
            But if he utterly fails and remains incapable of knowing Him while this physical body still lasts.
            Then he is helplessly forced to take on new physical bodies (Shariratvaya) over and over again in the various created worlds (Sargeshu Lokeshu).
            This verse gives an extremely strict warning to humanity: absolutely do not postpone Self-knowledge for tomorrow.
            Many people falsely think, "I will chant God's name in old age" or "I will easily find God in heaven after I die."
            Yama declares that nothing is attained after death; whatever is to be achieved must be achieved in this body, on this earth, right now (Iha).
            Death is no magic trick that suddenly turns an ignorant man into an enlightened sage; consciousness remains exactly as it was in life.
            If we carelessly waste this golden opportunity (human birth), Nature will forcefully put us back in the long, agonizing queue of rebirth.
            This verse considers procrastination (delaying) to be the absolute greatest and most dangerous enemy of spiritual life.
        """.trimIndent()
    ),
    KathaShloka(
        id = 106,
        sanskrit = "यथादर्शे तथात्मनि यथा स्वप्ने तथा पितृलोके । यथाम्सु परीव ददृशे तथा गन्धर्वलोके छायातपयोरिव ब्रह्मलोके ॥ ५ ॥",
        hindi = """
            (यमराज बताते हैं कि ब्रह्म कहाँ सबसे साफ दिखता है): जैसे एक साफ दर्पण (शीशे) में अपना चेहरा बिल्कुल स्पष्ट दिखाई देता है।
            वैसे ही अपनी शुद्ध 'आत्मा' (अंतःकरण) में उस परब्रह्म का सबसे स्पष्ट दर्शन होता है।
            पितृलोक में भगवान का दर्शन वैसा ही धुंधला होता है जैसा कि 'स्वप्न' (सपने) में कोई दृश्य दिखाई देता है।
            गंधर्व लोक में उसका दर्शन वैसा हिलता हुआ होता है जैसा 'जल' (पानी) में परछाईं दिखाई देती है।
            परंतु ब्रह्मलोक में ब्रह्म का दर्शन बिल्कुल वैसा ही स्पष्ट और अलग होता है जैसे 'छाया और धूप' (Light and shadow)।
            अक्सर इंसान सोचता है कि मरने के बाद स्वर्ग या पितृलोक जाकर वह भगवान को अच्छी तरह देख लेगा।
            यमराज इस भ्रम को तोड़ते हैं और कहते हैं कि पितृलोक या गंधर्व लोक में भगवान धुंधले और हिलते हुए (Unclear) दिखते हैं।
            ब्रह्म का सबसे 'HD' (High Definition) और स्पष्ट दर्शन केवल इसी मनुष्य जन्म में एक शुद्ध हृदय (दर्पण) के भीतर ही संभव है।
            मनुष्य शरीर एक अत्यंत दुर्लभ शीशा है; इसे गंदा रखने के बजाय इसे ध्यान से साफ करो।
            ब्रह्मलोक में भी दर्शन स्पष्ट है, पर वहाँ पहुँचना अत्यंत कठिन है; इसलिए इसी जीवन में आत्मा रूपी दर्पण में उसे पा लेना सबसे श्रेष्ठ है।
        """.trimIndent(),
        english = """
            (Yama explains where Brahman is seen most clearly): Just as one's face is seen with absolute, crystal clarity in a clean mirror (Adarshe).
            Exactly similarly, the clearest possible vision of that Supreme Brahman is attained right within one's own pure 'Soul' (Intellect).
            In the world of the ancestors (Pitruloka), the vision of God is as blurry and vague as a scene experienced in a 'dream' (Svapne).
            In the celestial world of Gandharvas, the vision is as highly distorted and wavering as a reflection seen in moving 'water' (Amsu).
            But in the supreme Brahmaloka, the vision of Brahman is as perfectly distinct and clear as 'Light and Shadow' (Chhayatapayoh).
            Humans often falsely assume that after dying and going to heaven or Pitruloka, they will see God perfectly.
            Yama shatters this grand illusion, stating that in Pitruloka or Gandharva loka, God appears extremely blurry and wavering (unclear).
            The most 'HD' (High Definition) and crystal-clear vision of Brahman is possible exclusively in this human birth, within a purified heart (mirror).
            The human body is an exceptionally rare mirror; instead of keeping it dirty, clean it rigorously with intense meditation.
            Vision is clear in Brahmaloka too, but reaching there is tremendously hard; hence realizing Him right now in the soul's mirror is best.
        """.trimIndent()
    ),
    KathaShloka(
        id = 107,
        sanskrit = "इन्द्रियाणां पृथग्भावमुदयास्तमयौ च यत् । पृथगुत्पद्यमानानां मत्वा धीरो न शोचति ॥ ६ ॥",
        hindi = """
            पंचभूतों से अलग-अलग उत्पन्न हुई इन इंद्रियों (आँख, कान, नाक आदि) का स्वभाव आत्मा से बिल्कुल अलग (पृथक्) है।
            तथा जागने पर इन इंद्रियों का उदय (जाग्रत होना) होता है और सोने पर इनका अस्त (शांत होना) हो जाता है।
            इस प्रकार इन इंद्रियों की उत्पत्ति, उदय और अस्त—ये सभी आत्मा से सर्वथा भिन्न (अलग) प्रक्रियाएं हैं।
            ऐसा मानकर (मत्वा) और अच्छी तरह से जानकर, बुद्धिमान (धीर) पुरुष कभी भी शोक (दुख) नहीं करता है।
            यह श्लोक डिप्रेशन (Depression) और दुख का सबसे बड़ा मनोवैज्ञानिक इलाज (Psychological cure) बताता है।
            इंसान दुखी क्यों होता है? क्योंकि जब उसकी आँखें कुछ बुरा देखती हैं या शरीर थकता है, तो वह सोचता है "मैं थक गया हूँ।"
            यमराज कहते हैं कि इंद्रियां भौतिक तत्वों (मिट्टी, पानी, आग) से बनी हैं; वे पैदा होती हैं और थकती हैं।
            परंतु तुम्हारी असली पहचान 'आत्मा' है, जो न कभी पैदा होती है, न थकती है और न ही सोती है।
            जब आप यह भेद (पृथग्भाव) समझ लेते हैं कि "मैं आँख या कान नहीं हूँ, मैं उनको देखने वाला हूँ।"
            तो फिर बुढ़ापा या बीमारी इंद्रियों को तो सता सकती है, पर उस 'धीर' पुरुष के मन को कभी रुला नहीं सकती।
        """.trimIndent(),
        english = """
            The inherent nature of these senses (eyes, ears, nose, etc.), produced separately from the elements, is entirely distinct and separate (Prithak) from the Soul.
            Furthermore, the rising (awakening) of these senses occurs upon waking, and their setting (calming) occurs during sleep.
            Thus, the origin, awakening, and setting of these physical senses are processes entirely and absolutely separate from the immortal Soul.
            Having deeply realized (Matva) and perfectly understood this distinction, the wise and patient man (Dhira) absolutely never grieves.
            This verse provides the greatest and most profound psychological cure for human depression and worldly sorrow.
            Why does a human suffer? Because when his eyes see something bad or his body tires, he falsely thinks "I am tired."
            Yama explains that the senses are made of physical elements (earth, water, fire); they naturally take birth and get exhausted.
            But your actual, true identity is the 'Soul', which never takes birth, never tires, and absolutely never sleeps.
            When you profoundly understand this separation (Prithagbhava) that "I am not the eye or ear, I am the Observer of them."
            Then old age or disease may afflict the physical senses, but it can never, ever make the mind of that 'Dhira' (wise man) cry.
        """.trimIndent()
    ),
    KathaShloka(
        id = 108,
        sanskrit = "इन्द्रियेभ्यः परं मनो मनसः सत्त्वमुत्तमम् । सत्त्वादधि महानात्मा महतोऽव्यक्तमुत्तमम् ॥ ७ ॥",
        hindi = """
            (सृष्टि के सूक्ष्म स्तरों का क्रम फिर से बताया गया है): इन बाहरी इंद्रियों से हमारा सूक्ष्म 'मन' अधिक श्रेष्ठ और पर (बड़ा) है।
            और उस चंचल मन से हमारी निश्चय करने वाली बुद्धि (सत्त्व / Intellect) अत्यंत उत्तम और श्रेष्ठ है।
            उस बुद्धि से भी अधिक श्रेष्ठ और बड़ी वह 'महान आत्मा' (समष्टि बुद्धि / हिरण्यगर्भ) है।
            और उस महान आत्मा से भी अत्यंत उत्तम और परे वह 'अव्यक्त' (मूल प्रकृति / माया / कारण अवस्था) है।
            यह श्लोक 3.10 के समान ही है, पर यहाँ साधक को ध्यान की गहराई में उतरने का नक्शा (Map) फिर से याद दिलाया जा रहा है।
            हमें बाहर की दुनिया (इंद्रियों) को छोड़कर सबसे पहले अपने मन के विचारों पर आना है।
            फिर उन हजारों विचारों को रोककर एक बुद्धि (विवेक) पर टिकना है।
            फिर अपनी छोटी सी बुद्धि को छोड़कर उस ब्रह्मांडीय महान चेतना (Cosmic Intellect) से जुड़ना है।
            और फिर उस चेतना को भी छोड़कर शून्यता (अव्यक्त) में डूब जाना है।
            यह सीढ़ी हमें दिखाती है कि हमारा शरीर सबसे निचला पायदान है; असली यात्रा तो मन के परे जाने में है।
        """.trimIndent(),
        english = """
            (The hierarchy of subtle levels is reiterated): Our subtle 'Mind' is far superior, higher, and beyond (Para) these external physical senses.
            And our determining intellect (Sattva / Buddhi) is exceedingly excellent and vastly superior to that restless mind.
            That 'Great Soul' (Cosmic Intellect / Hiranyagarbha) is far superior and infinitely greater than the individual intellect.
            And the 'Unmanifest' (Root Nature / Maya / Causal State) is supremely excellent and far beyond even that Great Soul.
            This verse is identical to 3.10, but here the seeker is being reminded of the precise map to descend into the ultimate depths of meditation.
            We must first completely leave the external world (senses) and firmly retreat into the thoughts of our mind.
            Then we must stop those thousands of chaotic thoughts and anchor ourselves on the single intellect (discrimination).
            Then, dropping our petty individual intellect, we must connect directly with that vast Cosmic Consciousness.
            And finally, leaving even that cosmic consciousness, we must plunge entirely into the absolute void (Avyakta).
            This ladder powerfully demonstrates that our body is the absolute lowest rung; the real journey is going entirely beyond the mind.
        """.trimIndent()
    ),
    KathaShloka(
        id = 109,
        sanskrit = "अव्यक्तात्तु परः पुरुषो व्यापकोऽलिङ्ग एव च । यं ज्ञात्वा मुच्यते जन्तुरमृतत्वं च गच्छति ॥ ८ ॥",
        hindi = """
            उस अव्यक्त (मूल प्रकृति/शून्यता) से भी अत्यंत श्रेष्ठ और परे वह परम 'पुरुष' (परमात्मा) है।
            वह परम पुरुष सर्वत्र व्यापक (Omnipresent) है और वह पूरी तरह से 'अलिङ्ग' (बिना किसी भौतिक चिह्न या आकार के) है।
            जिस एक परम पुरुष को यथार्थ रूप से जानकर कोई भी मनुष्य या जीव सभी बंधनों से पूरी तरह मुक्त (मुच्यते) हो जाता है।
            और बंधनों से मुक्त होकर वह निश्चित रूप से परम अमरता (अमृतत्व) को प्राप्त कर लेता है।
            यह पिछले श्लोक का निष्कर्ष है; ध्यान की अंतिम मंजिल शून्यता (अव्यक्त) नहीं है।
            शून्यता के भी पार वह 'चेतना' है जो उस शून्यता को भी प्रकाशित कर रही है; वही पुरुष (परमेश्वर) है।
            वह 'अलिङ्ग' है, यानी दुनिया का कोई भी लॉजिक, मूर्ति या परिभाषा उसे बाँध कर नहीं समझा सकती।
            वह हवा से भी ज्यादा सूक्ष्म और व्यापक है।
            विज्ञान केवल 'अव्यक्त' (क्वांटम फील्ड / Quantum field) तक पहुँच सकता है, पर पुरुष विज्ञान की पहुँच से बाहर है।
            मोक्ष का अर्थ केवल इतना ही है कि उस निराकार और व्यापक सत्य को 'जान' लिया जाए, कुछ और करना बाकी नहीं रहता।
        """.trimIndent(),
        english = """
            That Supreme 'Purusha' (God/Absolute Consciousness) is exceedingly superior and entirely beyond even that Unmanifest (Root Nature/Void).
            That Supreme Person is absolutely all-pervading (Vyapaka) and is completely 'Alinga' (entirely devoid of any physical mark, sign, or form).
            By truly and perfectly realizing that one Supreme Person, any human or living creature becomes entirely liberated (Muchyate) from all bonds.
            And having been completely freed from all bonds, he undoubtedly and successfully attains supreme Immortality (Amritatvam).
            This is the ultimate conclusion of the previous verse; the absolute final destination of meditation is not merely the void (Avyakta).
            Far beyond even the void is that vibrant 'Consciousness' which illuminates even that void; that exactly is the Purusha (Supreme Lord).
            He is 'Alinga', meaning absolutely no logic, idol, or worldly definition can ever bound or fully explain Him.
            He is infinitely subtler and far more all-pervading than the air itself.
            Science can only reach up to the 'Avyakta' (the quantum field), but the Purusha is entirely beyond the reach of physical science.
            Moksha strictly means just 'knowing' that formless, all-pervading Truth; absolutely nothing else remains to be done.
        """.trimIndent()
    ),
    KathaShloka(
        id = 110,
        sanskrit = "न सन्दृशे तिष्ठति रूपमस्य न चक्षुषा पश्यति कश्चनैनम् । हृदा मनीषा मनसाभिक्लृप्तो य एतद्विदुरमृतास्ते भवन्ति ॥ ९ ॥",
        hindi = """
            उस परमात्मा का वास्तविक स्वरूप हमारी इन भौतिक आँखों की दृष्टि (सन्दृशे) के सामने कभी खड़ा नहीं होता।
            दुनिया का कोई भी मनुष्य अपनी इन चर्म-चक्षुओं (चमड़ी की आँखों) से उस ईश्वर को बिल्कुल नहीं देख सकता है।
            वह तो केवल एक प्रेमपूर्ण हृदय, शुद्ध प्रज्ञा (मनीषा) और अत्यंत एकाग्र मन (मनसा) के द्वारा ही जाना और अनुभव किया जा सकता है।
            जो ज्ञानी मनुष्य उस परब्रह्म को इस प्रकार (हृदय और मन से) जान लेते हैं, वे हमेशा के लिए अमर हो जाते हैं।
            यह श्लोक श्वेताश्वतर उपनिषद (4.20) के बिल्कुल समान है; यह वेदान्त का एक अत्यंत प्रामाणिक सिद्धांत है।
            ईश्वर कोई वस्तु (Object) नहीं है जिससे रोशनी टकराकर हमारी आँखों में आए, इसलिए आँखें उसे नहीं देख सकतीं।
            ईश्वर को देखने के लिए बाहरी आँखों को बंद करना पड़ता है और 'अंतर्दृष्टि' (Inner Vision) को खोलना पड़ता है।
            वह अंतर्दृष्टि केवल एक भावना-प्रधान हृदय (Love) और एक शांत, तीक्ष्ण बुद्धि (Clarity) के मिलन से पैदा होती है।
            यदि हम भगवान को केवल आसमान में ढूँढते रहेंगे, तो कभी नहीं मिलेगा; वह तो हमारे शुद्ध मन का ही अनुभव है।
            यही वह ज्ञान है जो नचिकेता पाना चाहता था, और यमराज ने इसे पूरी स्पष्टता के साथ उसके सामने खोल कर रख दिया है।
        """.trimIndent(),
        english = """
            The true, original form of that Supreme Lord never, ever stands before the vision (Sandrishe) of our physical eyes.
            Absolutely no human being in the world can ever possibly see that God with these fleshy, physical eyes.
            He can be profoundly known and experienced solely through a loving heart, pure intellect (Manisha), and a highly concentrated mind.
            Those exceptionally wise people who truly know that Supreme Brahman in this exact manner become completely immortal forever.
            This verse is entirely identical to Shvetashvatara Upanishad (4.20); it is a highly authentic and irrefutable principle of Vedanta.
            God is not a physical object from which light can bounce back into our eyes, which is precisely why physical eyes cannot see Him.
            To truly see God, one must firmly close the external eyes and actively open the 'Inner Vision'.
            That inner vision is born exclusively from the perfect union of an emotion-filled heart (Love) and a calm, razor-sharp intellect (Clarity).
            If we keep searching for God merely in the sky, we will never find Him; He is the direct, intimate experience of our purified mind.
            This is the exact wisdom Nachiketa intensely desired, and Yama has laid it completely bare before him with absolute clarity.
        """.trimIndent()
    ),

    KathaShloka(
        id = 111,
        sanskrit = "यदा पञ्चावतिष्ठन्ते ज्ञानानि मनसा सह । बुद्धिश्च न विचेष्टते तामाहुः परमां गतिम् ॥ १० ॥",
        hindi = """
            (यमराज अब 'योग' की सबसे सटीक परिभाषा देते हैं): जब हमारी पांचों ज्ञानेंद्रियां (आँख, कान आदि) बाहरी विषयों से हट जाती हैं।
            और वे पांचों इंद्रियां हमारे शांत मन (मनसा) के साथ भीतर एक जगह पूरी तरह से स्थिर (अवतिष्ठन्ते) हो जाती हैं।
            तथा जब हमारी बुद्धि (निश्चय करने वाली शक्ति) भी किसी भी प्रकार की कोई चेष्टा (हिलडुल या विचार) नहीं करती।
            उस परम शांत और विचार-शून्य अवस्था को ही ज्ञानी लोग 'परम गति' (सबसे ऊँची और महान अवस्था) कहते हैं।
            कठोपनिषद का यह श्लोक ध्यान और योग का सबसे बेहतरीन और सबसे वैज्ञानिक (Scientific) वर्णन है।
            हमेशा हमारी इंद्रियां कुछ देखना या सुनना चाहती हैं; ध्यान में सबसे पहले उन पांचों को शांत करके मन में लाना है।
            फिर मन भी कुछ न कुछ कल्पना करता रहता है; उस मन को भी रोक कर बुद्धि में स्थिर करना है।
            और अंत में जब बुद्धि भी यह सोचना बंद कर दे कि "मैं ध्यान कर रहा हूँ", यानी जब 'मैं' पूरी तरह मिट जाए।
            जब भीतर एक पत्ता भी न खड़के, केवल एक सन्नाटा और पूर्ण मौन (Silence) रह जाए, वही परम गति है।
            यही वह अवस्था है जहाँ जीवात्मा साक्षात् परब्रह्म से मिल जाती है और सारे रहस्य अपने-आप खुल जाते हैं।
        """.trimIndent(),
        english = """
            (Yama now gives the most precise definition of 'Yoga'): When our five senses of perception (eyes, ears, etc.) completely withdraw from external objects.
            And when those five senses become perfectly still and firmly established (Avatisthante) together with a completely calm mind.
            And when even our intellect (the determining power) absolutely stops making any movement, effort, or thought (Na vicheshtate).
            The wise sages declare that state of absolute tranquility and thoughtless void to be the 'Parama Gati' (the Supreme, Highest State).
            This verse of the Katha Upanishad is arguably the finest, most scientific, and exact description of deep meditation and Yoga.
            Our senses constantly want to see or hear something; in meditation, we must first silence all five and bring them into the mind.
            Then the mind constantly imagines things; we must tightly restrain that mind and fix it entirely in the intellect.
            And finally, when the intellect stops even thinking "I am meditating"—meaning when the 'Ego' completely dissolves into nothingness.
            When not even a single leaf rustles inside, and only absolute, profound Silence remains, that exactly is the Supreme State.
            This is the exact ultimate state where the individual soul merges directly with the Supreme Brahman, and all mysteries automatically unfold.
        """.trimIndent()
    ),
    KathaShloka(
        id = 112,
        sanskrit = "तां योगमिति मन्यन्ते स्थिरामिन्द्रियधारणाम् । अप्रमत्तस्तदा भवति योगो हि प्रभवाप्ययौ ॥ ११ ॥",
        hindi = """
            इंद्रियों और मन की उस अत्यंत अचल और स्थिर धारणा (एकाग्रता) को ही महान ऋषि 'योग' मानते हैं।
            उस स्थिर अवस्था में पहुँचने पर साधक पूरी तरह से अप्रमत्त (बिना किसी भूल, प्रमाद या असावधानी के) हो जाता है।
            (साधक को अप्रमत्त रहना ही चाहिए), क्योंकि यह योग अत्यंत चंचल है; यह आता भी है (प्रभव) और चला भी जाता है (अप्यय)।
            यह श्लोक बहुत बड़ी चेतावनी है। 'योग' कोई शारीरिक कसरत नहीं है, यह इंद्रियों की वह गहरी स्थिरता है जो भीतर घटित होती है।
            जब मन पूरी तरह शांत हो जाता है, तो साधक को अत्यंत आनंद मिलता है। पर यहाँ यमराज कहते हैं: 'अप्रमत्त रहो' (Alert रहो)।
            क्यों? क्योंकि मन बहुत धोखेबाज है। थोड़ी सी भी लापरवाही हुई, कोई पुराना विचार आया, और ध्यान तुरंत टूट जाएगा।
            'प्रभवाप्ययौ' का मतलब है कि योग (एकाग्रता) की अवस्था बनती है और बहुत जल्दी बिगड़ भी जाती है।
            यह कोई ऐसी डिग्री नहीं है जो एक बार मिल गई तो हमेशा रहेगी; यह एक संतुलन (Balance) है जिसे हर पल बनाए रखना पड़ता है।
            जैसे साइकिल चलाते समय आपको हर सेकंड बैलेंस बनाना पड़ता है, वैसे ही ध्यान में हर सेकंड अप्रमत्त (सावधान) रहना होता है।
            जो योगी इस सावधानी को साध लेता है, वही उस परम शांति को स्थायी (Permanent) रूप से अपने भीतर उतार पाता है।
        """.trimIndent(),
        english = """
            The great sages consider that absolute, unshakeable firmness and steady concentration of the senses and mind to be 'Yoga'.
            Upon reaching that steady state, the seeker becomes completely Apramatta (flawlessly alert, without any carelessness or distraction).
            (The seeker must absolutely remain alert), because this state of Yoga is highly volatile; it comes (Prabhava) and it quickly goes away (Apyaya).
            This verse serves as a massive warning. 'Yoga' is not a physical workout; it is that profound, unshakeable steadiness of senses happening within.
            When the mind becomes totally calm, the seeker feels immense bliss. But here Yama warns: 'Remain Apramatta' (Stay completely Alert).
            Why? Because the mind is incredibly deceptive. Even a split second of carelessness or an old thought, and meditation shatters instantly.
            'Prabhavapyayau' means that the state of Yoga (concentration) is acquired with effort, but it can be lost and destroyed very quickly.
            It is not a one-time degree that stays forever once earned; it is a delicate balance that must be meticulously maintained every single second.
            Just as you must constantly balance a moving bicycle every second, in meditation you must remain impeccably alert (Apramatta) every second.
            The Yogi who successfully masters this unbroken vigilance is the one who permanently anchors that Supreme Peace within himself.
        """.trimIndent()
    ),
    KathaShloka(
        id = 113,
        sanskrit = "नैव वाचा न मनसा प्राप्तुं शक्यो न चक्षुषा । अस्तीति ब्रुवतोऽन्यत्र कथं तदुपलभ्यते ॥ १२ ॥",
        hindi = """
            वह परम परमात्मा न तो हमारी वाणी (शब्दों या भाषण) के द्वारा प्राप्त किया जा सकता है या समझाया जा सकता है।
            न तो उसे हमारे चंचल मन की किसी कल्पना से प्राप्त किया जा सकता है, और न ही इन भौतिक आँखों से देखा जा सकता है।
            जो श्रद्धायुक्त आस्तिक पुरुष यह दृढ़ता से कहता है कि "वह परमात्मा (निश्चित रूप से) है" (अस्ति इति)।
            उस आस्तिक पुरुष को छोड़कर, किसी अन्य नास्तिक या तर्क करने वाले को वह परब्रह्म आखिर कैसे प्राप्त हो सकता है?
            ईश्वर को शब्दों में नहीं बाँधा जा सकता; जो कहता है "मैंने भगवान को पूरी तरह समझा दिया है", वह झूठ बोल रहा है।
            दिमाग केवल उन चीजों को सोच सकता है जो उसने पहले कभी देखी हों; ईश्वर दिमाग के भी परे है।
            आँखें केवल रंग देखती हैं, निराकार सत्य को नहीं। तो फिर वह मिलता कैसे है?
            यमराज कहते हैं कि उसे पाने की पहली और सबसे जरूरी शर्त है 'श्रद्धा' (Faith)—यह मान लेना कि "हाँ, वह है" (अस्ति)।
            जो आदमी पहले ही तय कर चुका है कि भगवान नहीं है, उसे दुनिया का कोई भी प्रमाण भगवान नहीं दिखा सकता।
            शुरुआत हमेशा एक 'पॉजिटिव विश्वास' से होती है; जो इस विश्वास के साथ खोजता है, भगवान केवल उसी के सामने प्रकट होते हैं।
        """.trimIndent(),
        english = """
            That Supreme Lord can absolutely never be attained, fully grasped, or explained by our speech (words or grand lectures).
            Nor can He ever be attained by any imagination of our restless mind, nor can He possibly be seen by these physical eyes.
            Apart from that faithful, devout person who firmly and affirmatively declares that "He (God) definitely IS" (Asti iti).
            Other than him, how on earth can that Supreme Brahman ever be attained or experienced by a non-believer or a mere debater?
            God cannot be confined in words; anyone claiming "I have completely explained God in words" is simply telling a lie.
            The mind can only imagine things it has previously seen or known; God is entirely beyond the limits of the human mind.
            The eyes only perceive colors and physical forms, not the formless Truth. So how exactly is He attained?
            Yama states that the absolute first and most essential condition to find Him is 'Shraddha' (Faith)—accepting firmly that "Yes, He IS" (Asti).
            For a person who has already stubbornly concluded that God doesn't exist, no proof in the world can ever show him God.
            The spiritual journey always begins with a 'Positive Faith'; God manifests exclusively to the one who searches with this unwavering faith.
        """.trimIndent()
    ),
    KathaShloka(
        id = 114,
        sanskrit = "अस्तीत्येवोपलब्धव्यस्तत्त्वभावेन चोभयोः । अस्तीत्येवोपलब्धस्य तत्त्वभावः प्रसीदति ॥ १३ ॥",
        hindi = """
            (साधना के दो चरण): सबसे पहले तो उस परमात्मा को "वह है" (अस्ति) इस दृढ़ विश्वास के साथ ही प्राप्त (मानना) करना चाहिए।
            और फिर उसके बाद उसे उसके विशुद्ध 'तत्त्वभाव' (निराकार, निर्गुण, असली स्वरूप) के रूप में प्राप्त करना चाहिए।
            इन दोनों प्रकारों में से, जो साधक पहले उसे "वह है" (सगुण रूप में) इस आस्था के साथ स्वीकार कर लेता है।
            केवल उसी आस्तिक साधक के सामने अंततः उस परब्रह्म का वह परम 'तत्त्वभाव' (असली रहस्य) प्रसन्न होकर पूरी तरह प्रकट होता है।
            यह श्लोक अध्यात्म की एक बहुत ही मनोवैज्ञानिक और प्रैक्टिकल (Practical) सीढ़ी बताता है।
            आप सीधे 'शून्यता' या 'निराकार ब्रह्म' (तत्त्वभाव) पर ध्यान नहीं लगा सकते, क्योंकि दिमाग उसे समझ ही नहीं पाएगा।
            इसलिए पहला कदम है "अस्ति"—यानी मानना कि भगवान है (चाहे मूर्ति रूप में, नाम रूप में या सगुण रूप में)।
            यह सगुण भक्ति हमारे चंचल मन को एक सहारा देती है और उसे एकाग्र व शांत करती है।
            जब मन पूरी तरह शांत हो जाता है, तब भगवान का वह अंतिम निराकार और अनंत स्वरूप (तत्त्वभाव) खुद-ब-खुद हमारे भीतर प्रकट हो जाता है।
            बिना पहली सीढ़ी (श्रद्धा) पर पैर रखे, दूसरी सीढ़ी (पूर्ण आत्मज्ञान) तक पहुँचना किसी भी इंसान के लिए पूरी तरह असंभव है।
        """.trimIndent(),
        english = """
            (The two stages of practice): First and foremost, that Supreme Lord must be grasped (accepted) with the firm faith that "He IS" (Asti).
            And subsequently, after that, He must be realized in His absolute, pure 'Tattvabhava' (formless, attribute-less, true essence).
            Between these two modes, the seeker who first fully accepts Him with the deep faith and conviction that "He IS" (in a manifest form).
            It is solely to that faithful seeker that the supreme 'Tattvabhava' (the ultimate secret essence) of Brahman eventually reveals itself in grace.
            This verse prescribes an exceptionally psychological and highly practical step-by-step ladder for spiritual evolution.
            You cannot directly meditate on 'Voidness' or the 'Formless Brahman' (Tattvabhava) because the human mind simply cannot comprehend it.
            Therefore, the first mandatory step is "Asti"—accepting that God exists (whether as an idol, a name, or in a manifest form).
            This devotion to the manifest form provides a solid anchor to our restless mind, making it deeply concentrated and calm.
            When the mind becomes flawlessly still, God's ultimate formless, infinite nature (Tattvabhava) automatically manifests within us by grace.
            Without stepping firmly on the first rung (Faith), reaching the second rung (Absolute Self-realization) is utterly impossible for any human.
        """.trimIndent()
    ),

    KathaShloka(
        id = 115,
        sanskrit = "यदा सर्वे प्रमुच्यन्ते कामा येऽस्य हृदि श्रिताः । अथ मर्त्योऽमृतो भवत्यत्र ब्रह्म समश्नुते ॥ १४ ॥",
        hindi = """
            जब इस मनुष्य के हृदय (मन) में आश्रित रहने वाली (छुपी हुई) सभी भौतिक इच्छाएं और कामनाएं (कामा) पूरी तरह से नष्ट हो जाती हैं।
            (अर्थात जब उसके भीतर संसार से कुछ भी पाने का कोई भी लालच शेष नहीं रह जाता)।
            तब वह मरणशील मनुष्य (मर्त्य) इसी जीवन में पूरी तरह से अमर (अमृत) हो जाता है।
            और वह इसी भौतिक शरीर में रहते हुए यहीं (अत्र) उस परब्रह्म को प्राप्त कर लेता है (उसके साथ एक हो जाता है)।
            यह उपनिषदों की सबसे महान घोषणाओं में से एक है कि 'मोक्ष' मरने के बाद नहीं मिलता, वह 'यहीं और अभी' (अत्र) मिलता है।
            अमर होने का मतलब यह नहीं कि इंसान का शरीर नहीं मरेगा; शरीर तो राख होगा ही।
            अमर होने का असली मतलब है 'इच्छाओं का मर जाना'। जब इच्छाएं मर जाती हैं, तो जन्म लेने का कारण खत्म हो जाता है।
            हमारा हृदय इच्छाओं का गोदाम है; जब तक यह गोदाम भरा है, भगवान इसमें प्रवेश नहीं कर सकते।
            जब यह गोदाम खाली (वासना-रहित) हो जाता है, तो उसमें अचानक ब्रह्म का प्रकाश भर जाता है।
            यही 'जीवनमुक्ति' (Liberation while alive) है—जहाँ इंसान दुनिया में रहता है, पर दुनिया की कोई चाहत उसे छू नहीं पाती।
        """.trimIndent(),
        english = """
            When absolutely all the material desires and deep lusts (Kama) that reside firmly hidden within this human's heart are completely destroyed.
            (Meaning, when not even a single trace of greed to acquire anything from this world is left within him).
            Then that mortal human being (Martya) instantly becomes utterly immortal (Amrita) right in this very lifetime.
            And while still living within this physical body, he attains (merges absolutely with) that Supreme Brahman right here and right now (Atra).
            This is one of the greatest, most monumental declarations of the Upanishads: 'Moksha' is not attained after death; it is attained 'Here and Now'.
            Becoming immortal absolutely does not mean the physical body won't die; the body will undoubtedly turn to ashes.
            True immortality essentially means the 'death of desires'. When all desires die, the very root cause of rebirth is entirely obliterated.
            Our heart is a massive warehouse of desires; as long as this warehouse is full, God simply cannot enter it.
            The exact moment this warehouse becomes completely empty (desireless), it is instantly flooded with the blinding light of Brahman.
            This is 'Jivanmukti' (Liberation while alive)—where a person lives in the world, yet no worldly craving can ever touch him.
        """.trimIndent()
    ),
    KathaShloka(
        id = 116,
        sanskrit = "यदा सर्वे प्रभिद्यन्ते हृदयस्येह ग्रन्थयः । अथ मर्त्योऽमृतो भवत्येतावद्ध्यनुशासनम् ॥ १५ ॥",
        hindi = """
            जब इस जीवन में (इह) मनुष्य के हृदय की सभी 'ग्रंथियां' (अज्ञान, मोह, और अहंकार की उलझी हुई गांठें) पूरी तरह से कट जाती हैं (प्रभिद्यन्ते)।
            (अर्थात जब 'मैं शरीर हूँ' यह झूठा भ्रम हमेशा के लिए टूट कर बिखर जाता है)।
            तब वह मरणशील मनुष्य निश्चित रूप से पूर्ण अमर (अमृत) हो जाता है।
            बस, संपूर्ण वेदों और उपनिषदों का केवल इतना ही (एतावद्) परम और अंतिम उपदेश (अनुशासन) है।
            हमारे हृदय में तीन मुख्य गांठें (Knots) मानी गई हैं: अज्ञान (Ignorance), काम (Desire), और कर्म (Action)।
            हम सोचते हैं कि हम शरीर हैं (अज्ञान), इसलिए हम शरीर के लिए सुख चाहते हैं (काम), और उस सुख के लिए हम अच्छे-बुरे काम करते हैं (कर्म)।
            यह एक ऐसी उलझी हुई रस्सी है जिसने हमें संसार के खूंटे से कसकर बाँध रखा है।
            आत्मज्ञान की तेज तलवार एक ही झटके में इन सारी गांठों को काट कर फेंक देती है।
            गांठें खुलते ही आत्मा, जो अब तक इस शरीर रूपी गुब्बारे में कैद थी, आज़ाद होकर अनंत आकाश में मिल जाती है।
            यमराज ने स्पष्ट कर दिया कि इसके आगे कोई और थ्योरी या नियम नहीं है; सारे वेदों का निचोड़ बस यही आज़ादी है।
        """.trimIndent(),
        english = """
            When all the 'Knots' of the heart (the deeply tangled knots of ignorance, delusion, and ego) are completely cut asunder (Prabhidyante) right here in this life (Iha).
            (Meaning, when the deeply ingrained false illusion that 'I am this physical body' is shattered permanently forever).
            Then that mortal human being undoubtedly and instantaneously becomes completely immortal (Amrita).
            This much (Etavad), and strictly this much alone, is the ultimate, supreme teaching and final instruction (Anushasanam) of all the Vedas and Upanishads.
            There are considered to be three primary knots in our heart: Avidya (Ignorance), Kama (Desire), and Karma (Action).
            We falsely think we are the body (Ignorance), hence we intensely crave bodily pleasures (Desire), and to get them, we perform actions (Karma).
            This forms a deeply tangled rope that has tied us exceptionally tightly to the brutal peg of worldly existence.
            The razor-sharp sword of Self-knowledge slices through and destroys all these tight knots in one single, devastating strike.
            As soon as the knots are cut, the soul, previously trapped in this balloon-like body, is liberated and merges with the infinite sky.
            Yama makes it flawlessly clear that there is no further theory or rule beyond this; the ultimate essence of all Vedas is just this absolute Freedom.
        """.trimIndent()
    ),
    KathaShloka(
        id = 117,
        sanskrit = "शतं चैका च हृदयस्य नाड्यस्तासां मूर्धानमभिनिःसृतैका । तयोर्ध्वमायन्नमृतत्वमेति विष्वङ्ङन्या उत्क्रमणे भवन्ति ॥ १६ ॥",
        hindi = """
            मनुष्य के हृदय से कुल एक सौ एक (101) प्रमुख नाड़ियां (ऊर्जा के प्रवाह के रास्ते) निकलती हैं।
            उन 101 नाड़ियों में से केवल एक नाड़ी (जिसका नाम 'सुषुम्ना' है) ऊपर सिर के शिखर (मूर्धा / ब्रह्मरन्ध्र) की ओर जाती है।
            जो साधक मृत्यु के समय उस एक 'सुषुम्ना' नाड़ी के माध्यम से अपनी चेतना को ऊपर की ओर ले जाता है, वह अमरता (अमृतत्व/मोक्ष) को प्राप्त करता है।
            परंतु जो अन्य बाकी की 100 नाड़ियां हैं, वे शरीर में अलग-अलग दिशाओं (नीचे या बगल) में जाती हैं; उनके द्वारा प्राण निकलने पर जीव फिर से इसी संसार में जन्म (उत्क्रमण) लेता है।
            यह श्लोक प्राचीन भारतीय योग और तंत्र विज्ञान (Kundalini Yoga) का एक अत्यंत ही तकनीकी (Technical) रहस्य है।
            नाड़ियां खून की नसें नहीं हैं; ये प्राण (Life energy) के बहने के अत्यंत सूक्ष्म रास्ते हैं।
            सामान्य इंसान की ऊर्जा जीवन भर नीचे की ओर (वासनाओं और भोगों में) बहती रहती है; इसलिए मरते वक्त भी उसके प्राण नीचे की नाड़ियों से निकलते हैं (और वह फिर जन्म लेता है)।
            परंतु जो योगी जीवन भर ध्यान करता है, उसकी ऊर्जा 'सुषुम्ना' के रास्ते ऊपर (सहस्रार चक्र) की ओर बहने लगती है।
            जब मौत आती है, तो योगी का प्राण सिर के ऊपरी हिस्से (ब्रह्मरन्ध्र) को भेद कर ब्रह्मांड की ऊर्जा में मिल जाता है।
            इस तरह वह शरीर छोड़कर सीधे उस परमेश्वर (अमरता) में समा जाता है और उसे दोबारा जन्म नहीं लेना पड़ता।
        """.trimIndent(),
        english = """
            There are exactly one hundred and one (101) primary Nadis (channels of vital energy flow) emanating directly from the human heart.
            Out of those 101 Nadis, only one single Nadi (known as 'Sushumna') travels straight up piercing the absolute crown of the head (Brahmarandhra).
            The seeker who, at the time of death, draws his consciousness upwards strictly through that one Sushumna Nadi, successfully attains absolute Immortality (Moksha).
            However, the other 100 Nadis branch out in various different directions (downwards or sideways); if the vital breath departs through them, the soul takes rebirth (Utkramana) in this world again.
            This verse unveils a highly technical, profound secret of ancient Indian Yoga and Tantra Science (Kundalini Yoga).
            Nadis are not physical blood veins; they are extremely subtle, invisible pathways for the flow of Prana (Life energy).
            An ordinary human's energy flows downwards (into lust and worldly pleasures) all his life; hence at death, his breath exits through lower Nadis (causing rebirth).
            But the Yogi who meditates deeply all his life actively redirects his energy to flow upwards through the 'Sushumna' toward the Crown Chakra.
            When death arrives, the Yogi's vital breath pierces the top of his skull (Brahmarandhra) and seamlessly merges with the infinite cosmic energy.
            Thus, leaving the body, he dissolves directly into the Supreme Lord (Immortality) and is never forced to take birth again.
        """.trimIndent()
    ),
    KathaShloka(
        id = 118,
        sanskrit = "अङ्गुष्ठमात्रः पुरुषोऽन्तरात्मा सदा जनानां हृदये सन्निविष्टः । तं स्वाच्छरीरात्प्रवृहेन्मुञ्जादिवेषीकां धैर्येण । तं विद्याच्छुक्रममृतं तं विद्याच्छुक्रममृतमिति ॥ १७ ॥",
        hindi = """
            वह अँगूठे के आकार का परम पुरुष (ईश्वर) अंतरात्मा के रूप में सदा (हमेशा) सभी मनुष्यों के हृदय में विराजमान है।
            साधक को चाहिए कि वह उस आत्मा को अपने इस भौतिक शरीर से बहुत ही सावधानी और धैर्य (धैर्येण) के साथ अलग (प्रवृहेत्) करके जाने।
            ठीक उसी प्रकार, जैसे कोई व्यक्ति मूंज (घास) के तिनके में से उसके अंदर की सींक (इषीका) को अत्यंत सावधानी से खींचकर अलग करता है।
            उस शरीर से अलग की गई आत्मा को ही तुम परम शुद्ध (शुक्रं) और अमर (अमृत) परब्रह्म जानो! हाँ, उसी को तुम परम शुद्ध और अमर ब्रह्म जानो!
            (वाक्य का दोहराव इस उपदेश की परम सत्यता और समाप्ति को दर्शाता है)।
            यह कठोपनिषद के यमराज के उपदेश का सबसे अंतिम और सबसे महान व्यावहारिक (Practical) निर्देश है।
            हमारा शरीर घास (मूंज) के भारी आवरण (Covering) की तरह है, और आत्मा उसके अंदर छिपी हुई अत्यंत सूक्ष्म सींक की तरह है।
            यदि आप घास से सींक को झटके से या गुस्से में निकालेंगे, तो सींक टूट जाएगी; इसके लिए अत्यंत 'धैर्य' (Patience) और ध्यान चाहिए।
            उसी तरह, आत्मा को शरीर से अलग जानने के लिए हड़बड़ी या शारीरिक बल नहीं, बल्कि शांत ध्यान और विवेक चाहिए।
            जब वह सींक (आत्मा) बाहर आती है, तो योगी देखता है कि यह तो 'मैं' हूँ! और यह तो बिल्कुल शुद्ध और कभी न मरने वाला ईश्वर है!
        """.trimIndent(),
        english = """
            That thumb-sized Supreme Person (God) is eternally seated right within the hearts of all human beings as their Inner Soul.
            A seeker must diligently and carefully extract and separate (Pravrihet) that Soul from his own physical body with absolute patience and steadiness (Dhairena).
            Exactly in the same meticulous way a person carefully pulls out the tender inner stalk (Ishika) from within a blade of Munja grass.
            You must know that pure, separated Soul to be the absolutely immaculate (Shukram) and immortal (Amrita) Brahman! Yes, know That alone to be the pure, immortal Brahman!
            (The repetition of the final phrase heavily emphasizes the absolute truth of this teaching and marks its grand conclusion).
            This is the final, ultimate, and most magnificent practical instruction given by Lord Yama in the Katha Upanishad.
            Our physical body is exactly like the thick, gross outer covering of the grass, while the Soul is the extremely subtle, delicate stalk hidden inside.
            If you yank the stalk out of the grass violently or in haste, it will break; it requires immense 'Patience' (Dhैर्य) and deep focus.
            Similarly, realizing the Soul as separate from the body does not require physical force or haste, but tranquil meditation and sharp discrimination.
            When that stalk (Soul) is finally realized separately, the Yogi joyously discovers: "This is ME! And I am that flawlessly pure, immortal God!"
        """.trimIndent()
    ),
    KathaShloka(
        id = 119,
        sanskrit = "मृत्युप्रोक्तां नचिकेतोऽथ लब्ध्वा विद्यामेतां योगविधिं च कृत्स्नम् । ब्रह्मप्राप्तो विरजोऽभूद्विमृत्युरन्योऽप्येवं यो विदध्यात्ममेव ॥ १८ ॥",
        hindi = """
            (उपनिषद का अंतिम उपसंहार): इस प्रकार, साक्षात् मृत्यु के देवता यमराज के द्वारा कहे गए इस परम पवित्र और रहस्यमयी ज्ञान को प्राप्त करके।
            और योग की संपूर्ण विधियों (नियमों और धारणाओं) को अच्छी तरह से सीखकर नचिकेता मृत्यु के पार चला गया।
            वह सभी प्रकार के पापों और अशुद्धियों (विरज) से पूरी तरह मुक्त होकर साक्षात् 'ब्रह्म' को प्राप्त हो गया।
            अज्ञान रूपी मृत्यु को पार करके वह हमेशा के लिए अमर (विमृत्यु) और शांत हो गया।
            यह कथा केवल नचिकेता तक सीमित नहीं है; उपनिषद मानव जाति को एक महान और खुला आश्वासन (Guarantee) देता है।
            दुनिया का कोई भी 'अन्य' (दूसरा) मनुष्य भी, जो इस अध्यात्म-विद्या और आत्मा के सत्य को इसी प्रकार जानेगा।
            वह भी नचिकेता की तरह ही सभी अशुद्धियों से मुक्त होकर उस परमानंद और अमरता (ब्रह्म) को प्राप्त कर लेगा।
            यहाँ कठोपनिषद अपनी पूरी महिमा के साथ संपन्न होता है, जहाँ एक छोटा सा बालक मौत को हराकर भगवान बन जाता है।
            यह हमें सिखाता है कि सत्य की खोज के लिए उम्र नहीं, बल्कि नचिकेता जैसी दृढ़ इच्छाशक्ति और श्रद्धा चाहिए।
            ॐ शांतिः शांतिः शांतिः — हमारे शरीर, मन और आत्मा में उस परमेश्वर की असीम शांति हमेशा के लिए स्थापित हो।
        """.trimIndent(),
        english = """
            (The final conclusion of the Upanishad): Thus, having fully received this supremely sacred and mystical wisdom directly declared by Yama, the Lord of Death.
            And having completely mastered the entire process and techniques of Yoga, Nachiketa successfully crossed beyond death.
            He became completely free from all sins and impurities (Viraja), and directly attained the Supreme 'Brahman' Himself.
            Conquering death in the form of ignorance, he became totally immortal (Vimrityu) and perfectly tranquil forever.
            This epic story is not limited to Nachiketa alone; the Upanishad gives a great, open guarantee to all of humanity.
            Any 'other' human being in the world who truly realizes this Spiritual Science and the truth of the Soul in this exact way.
            He too, exactly like Nachiketa, will be completely freed from all impurities and successfully attain that supreme bliss and immortality.
            Here the Katha Upanishad magnificently concludes, where a young boy decisively defeats Death and becomes one with God.
            It powerfully teaches us that the search for Truth requires Nachiketa-like determination and faith, not just old age.
            OM Peace, Peace, Peace — May the boundless peace of that Supreme Lord be permanently established in our body, mind, and soul.
        """.trimIndent()
    )
)