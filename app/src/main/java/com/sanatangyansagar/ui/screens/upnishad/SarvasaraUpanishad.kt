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
data class SarvasaraShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SarvasaraUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..23) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Definition Number (1-23)") },
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
            itemsIndexed(sarvasaraShlokasList) { _, shloka ->
                SarvasaraShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SarvasaraShlokaCard(shloka: SarvasaraShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Topic ${shloka.id}",
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
                text = "हिन्दी व्याख्या (Definition):",
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

val sarvasaraShlokasList: List<SarvasaraShloka> = listOf(
    SarvasaraShloka(
        id = 1,
        sanskrit = "कथं बन्धः ? अनात्मन्यात्मबुद्धिर्बन्धः ।",
        hindi = """
            प्रश्न: बंधन (Bondage) क्या है? उत्तर: जो अनात्मा है, उसे आत्मा मान लेना ही बंधन है।
            हमारा यह भौतिक शरीर, मन और बुद्धि वास्तव में 'अनात्मा' (जड़ पदार्थ) हैं।
            परंतु अज्ञान के कारण हम इस शरीर को ही अपना असली 'मैं' (आत्मा) समझ लेते हैं।
            यही गलत पहचान हमें संसार के दुखों, बीमारियों और मृत्यु के भय में बाँध देती है।
            बंधन कोई बाहरी लोहे की जंजीर नहीं है, बल्कि यह एक मानसिक भ्रम (Illusion) है।
            जब हम सोचते हैं "मैं काला हूँ", "मैं बीमार हूँ", तो हम शरीर के गुणों से बँध जाते हैं।
            आत्मा कभी बीमार नहीं होती, वह कभी मरती नहीं, और उसका कोई रंग नहीं होता।
            अनात्मा (दृश्य जगत) के साथ अपनापन जोड़ना ही गुलामी की पहली शुरुआत है।
            इस भ्रम के कारण ही जीव बार-बार जन्म लेता है और कर्मों के जाल में फँसता है।
            सच्ची आज़ादी के लिए सबसे पहले इस गलत 'मैं' की धारणा को तोड़ना अनिवार्य है।
        """.trimIndent(),
        english = """
            Question: What is Bandha (Bondage)? Answer: To mistake the non-Self for the Self.
            Our physical body, restless mind, and limited intellect are actually 'non-Self' (matter).
            However, due to sheer ignorance, we consider this body to be our real 'I' (the Soul).
            This false identification binds us to worldly sorrows, diseases, and the fear of death.
            Bondage is not an external iron chain; it is a profound internal mental illusion.
            When we think "I am sick" or "I am old," we bind ourselves to the body's traits.
            The Soul never falls ill, it never dies, and it possesses no physical attributes.
            Attaching a sense of 'mineness' to the non-Self is the very beginning of slavery.
            Due to this delusion, the soul takes birth repeatedly and is caught in karma's net.
            For true freedom, shattering this false concept of the 'I' is absolutely mandatory.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 2,
        sanskrit = "कथं मोक्षः ? बन्धनिवृत्तिर्मोक्षः ।",
        hindi = """
            प्रश्न: मोक्ष क्या है? उत्तर: बंधन की पूरी तरह से निवृत्ति (समाप्ति) ही मोक्ष है।
            जब वह गलत पहचान (मैं शरीर हूँ) पूरी तरह मिट जाती है, तब जीव मुक्त हो जाता है।
            मोक्ष मरने के बाद किसी दूसरे लोक में जाने का नाम नहीं है, बल्कि यह एक जागृति है।
            अज्ञान की जंजीरों का टूट जाना और अपने असली स्वरूप को पहचान लेना ही मुक्ति है।
            जैसे अंधेरा हटने पर रोशनी स्वतः प्रकट होती है, वैसे ही बंधन हटने पर मोक्ष मिलता है।
            जब मन से 'मेरा' और 'तेरा' का भाव समाप्त हो जाता है, तब परम शांति मिलती है।
            मोक्ष का अर्थ है—संसार की वस्तुओं पर अपनी निर्भरता (Dependency) को खत्म करना।
            मुक्त पुरुष वह है जो शरीर के रहते हुए भी शरीर के सुख-दुख से विचलित नहीं होता।
            यह अवस्था प्राप्त करना ही मानव जीवन का सर्वोच्च और अंतिम पुरुषार्थ माना गया है।
            सत्य को केवल जानना काफी नहीं है, उस सत्य में पूरी तरह स्थित होना ही मोक्ष है।
        """.trimIndent(),
        english = """
            Question: What is Moksha (Liberation)? Answer: The absolute cessation of bondage.
            When the false identification (I am the body) is entirely erased, the soul is freed.
            Moksha is not going to another world after death; it is a profound internal awakening.
            The breaking of the chains of ignorance and realizing one's true nature is liberation.
            Just as light appears when darkness vanishes, Moksha is found when bondage ends.
            When the sense of 'mine' and 'thine' disappears from the mind, supreme peace ensues.
            Moksha means ending one's absolute dependency on external objects for happiness.
            A liberated person is one who is not shaken by pain or pleasure even while in a body.
            Attaining this state is considered the highest and final goal of every human life.
            Knowing the truth is not enough; being firmly established in that truth is Moksha.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 3,
        sanskrit = "काविद्या ? अनात्मन्यात्मबुद्धिः साविद्या ।",
        hindi = """
            प्रश्न: अविद्या (Ignorance) क्या है? उत्तर: अनात्मा में आत्मा की बुद्धि रखना ही अविद्या है।
            यह ब्रह्मांड का वह मूल अज्ञान है जो सत्य को छिपा देता है और असत्य को सच दिखाता है।
            जैसे अँधेरे में रस्सी सांप दिखाई देती है, वैसे ही अविद्या में शरीर आत्मा दिखता है।
            अविद्या ही वह शक्ति है जो हमें नाशवान चीजों में स्थायी सुख ढूँढने पर मजबूर करती है।
            यह केवल जानकारी का अभाव नहीं है, बल्कि यह एक 'गलत जानकारी' का दृढ़ होना है।
            अविद्या के कारण ही हम खुद को कर्ता और भोक्ता मानकर कर्मों के फल में फँसते हैं।
            जब तक यह अविद्या है, तब तक जीव संसार के चक्र से बाहर नहीं निकल सकता।
            सारे दुखों की जड़ इसी एक गलत समझ (अविद्या) में छिपी हुई है, इसे पहचानना जरूरी है।
            अध्यात्म का पूरा प्रयास इस अविद्या के परदे को विवेक के द्वारा हटाना ही होता है।
            अविद्या का नाश होते ही आत्मा स्वयं के प्रकाश में वैसी ही दिखती है जैसी वह है।
        """.trimIndent(),
        english = """
            Question: What is Avidya (Ignorance)? Answer: Regarding the non-Self as the Self.
            This is the primordial ignorance that hides the Truth and shows the false as real.
            As a rope appears as a snake in darkness, the body appears as the Soul in Avidya.
            Avidya is the power that forces us to seek permanent joy in highly perishable things.
            It is not merely a lack of information; it is the firm rooting of 'wrong information'.
            Due to Avidya, we consider ourselves the doer and enjoyer, getting trapped in karma.
            As long as this Avidya exists, the soul cannot exit the endless cycle of Samsara.
            The root of all human suffering lies in this single misunderstanding called Avidya.
            The entire spiritual effort aims to remove this veil of Avidya through discrimination.
            The moment Avidya is destroyed, the Soul shines in its own light exactly as it is.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 4,
        sanskrit = "का विद्या ? आत्मन्यात्मबुद्धिः सा विद्या ।",
        hindi = """
            प्रश्न: विद्या (Knowledge) क्या है? उत्तर: आत्मा में ही आत्मा की बुद्धि रखना विद्या है।
            स्वयं को शुद्ध, अविनाशी और आनंदमय चेतना के रूप में जानना ही वास्तविक विद्या है।
            यह कोई किताबी ज्ञान नहीं है, बल्कि यह 'स्व' (Self) का साक्षात् अनुभव और प्रतीति है।
            विद्या वह प्रकाश है जो अविद्या के भ्रम को एक ही झटके में जलाकर भस्म कर देता है।
            जब साधक को अहसास होता है "मैं शरीर नहीं, मैं आत्मा हूँ", तब विद्या जाग्रत होती है।
            यही वह ज्ञान है जो मनुष्य को पशुता से उठाकर देवत्व और ब्रह्मत्व तक ले जाता है।
            विद्या हमें यह सिखाती है कि सुख हमारे भीतर है, वह बाहर की वस्तुओं का मोहताज नहीं।
            सच्ची विद्या वही है जो मुक्ति प्रदान करे (सा विद्या या विमुक्तये)—यही वेदों का सार है।
            इसे पाने के लिए मन को शांत करना और गुरु के उपदेशों पर मनन करना आवश्यक है।
            विद्या के उदय होते ही संसार का सारा भय और मानसिक संताप हमेशा के लिए मिट जाता है।
        """.trimIndent(),
        english = """
            Question: What is Vidya (Wisdom)? Answer: Perceiving the Self strictly as the Self.
            Knowing oneself as pure, indestructible, and blissful consciousness is true Vidya.
            This is not academic knowledge; it is the direct experience and realization of the Self.
            Vidya is the light that burns the delusions of Avidya into ashes in a single stroke.
            When a seeker realizes "I am not the body, I am the Atman," Vidya awakens within.
            This is the wisdom that elevates a human from animality to divinity and Brahman-hood.
            Vidya teaches us that happiness is within us, not dependent on external objects at all.
            True wisdom is that which grants liberation (Sa Vidya Ya Vimuktaye)—this is the Veda's core.
            To attain it, silencing the mind and contemplating the Guru's words are essential steps.
            With the rising of Vidya, all worldly fears and mental agonies vanish permanently.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 5,
        sanskrit = "कः कत्र्ता ? बुद्धिमनोऽभिमानसंयोगः कत्र्ता ।",
        hindi = """
            प्रश्न: कर्ता (Doer) कौन है? उत्तर: बुद्धि, मन और अहंकार के मेल से जो बनता है, वही कर्ता है।
            आत्मा स्वयं कुछ नहीं करती, वह केवल एक साक्षी और प्रकाश देने वाली परम शक्ति है।
            जब मन में विचार उठते हैं और अहंकार कहता है "यह मैंने किया", तब कर्ता पैदा होता है।
            बिना अहंकार (अभिमान) के जुड़ाव के, कोई भी मनुष्य कर्ता की श्रेणी में नहीं आ सकता।
            यह 'अभिमान' ही है जो हमें कर्मों की जंजीरों में जकड़ लेता है और फल की चिंता देता है।
            कर्ता होने का भाव ही सभी चिंताओं, तनाव और मानसिक थकावट का मुख्य कारण है।
            जब तक हम खुद को कर्ता मानेंगे, तब तक हमें कर्मों के अच्छे-बुरे फल भोगने पड़ेंगे।
            अध्यात्म सिखाता है कि कर्ता भाव को त्यागकर कर्म करो, ताकि कर्म तुम्हें बाँध न सकें।
            भगवान कृष्ण गीता में कहते हैं कि अहंकार से मोहित व्यक्ति ही खुद को कर्ता मानता है।
            कर्ता भाव का मिट जाना ही परम शांति और निष्कामता की ओर ले जाने वाला मार्ग है।
        """.trimIndent(),
        english = """
            Question: Who is the Doer (Karta)? Answer: The union of Intellect, Mind, and Ego.
            The Soul itself performs no action; it is merely a witness and a source of light.
            When thoughts arise in the mind and ego says "I did this," the Doer is then born.
            Without the association of ego (Abhimana), no human can be categorized as a Doer.
            It is this 'Ego' that binds us in the chains of karma and causes anxiety over results.
            The feeling of being the Doer is the primary cause of all worry, stress, and fatigue.
            As long as we believe we are the Doer, we must reap the good or bad fruits of action.
            Spirituality teaches acting without the sense of doership, so actions do not bind you.
            Lord Krishna says in the Gita that only the one deluded by ego thinks "I am the doer."
            The dissolution of the 'Doer' sentiment is the path leading to supreme peace and purity.
        """.trimIndent()
    ),

    SarvasaraShloka(
        id = 6,
        sanskrit = "किं जाग्रत् ? इन्द्रियैः शब्दाद्यर्थोपलब्धिः ।",
        hindi = """
            प्रश्न: जाग्रत (Waking State) क्या है? उत्तर: इंद्रियों द्वारा शब्द आदि विषयों का ज्ञान होना।
            जब हमारी आँखें, कान और अन्य इंद्रियां बाहरी दुनिया से संपर्क करती हैं, तो वह जाग्रत है।
            इस अवस्था में हम स्थूल जगत का अनुभव करते हैं और कर्मों का संपादन करते हैं।
            यहाँ 'मैं' और 'यह दुनिया' के बीच का भेद बहुत स्पष्ट और ठोस रूप में दिखाई देता है।
            जाग्रत अवस्था में मन पूरी तरह बाहर की ओर फैला होता है और इंद्रियों का गुलाम होता है।
            इसे 'वैश्वानर' अवस्था भी कहा जाता है जहाँ जीव बाहरी सुख-दुख का भोग करता है।
            यह वह अवस्था है जहाँ हम सबसे अधिक सक्रिय होते हैं और अज्ञान का प्रभाव प्रबल होता है।
            उपनिषद कहता है कि यह जाग्रत दुनिया भी वैसी ही अस्थायी है जैसे कि सपनों की दुनिया।
            साधक को इस अवस्था में भी अपनी अंतरात्मा के प्रति जागरूक रहने का अभ्यास करना चाहिए।
            इंद्रियों के शोर के पीछे जो शांत देखने वाला है, उसे पहचानना ही जाग्रत का असली उद्देश्य है।
        """.trimIndent(),
        english = """
            Question: What is Jagrat (Waking State)? Answer: Perception of objects via the senses.
            When our eyes, ears, and other senses contact the external world, it is the waking state.
            In this state, we experience the gross physical world and perform various actions.
            Here, the distinction between the 'I' and 'this world' appears very clear and solid.
            In the waking state, the mind is fully extended outward and is a slave to the senses.
            It is also called the 'Vaishvanara' state, where the soul enjoys external pleasures.
            This is the state where we are most active and the influence of ignorance is strongest.
            The Upanishad states that this waking world is as temporary as the world of dreams.
            A seeker must practice remaining aware of their inner Self even during this state.
            Recognizing the silent observer behind the sensory noise is the true goal of waking.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 7,
        sanskrit = "किं स्वप्नम् ? जाग्रत्संस्कारजः शब्दाद्यविषयत्वेऽपि वासनामयः स्वप्नः ।",
        hindi = """
            प्रश्न: स्वप्न (Dream State) क्या है? उत्तर: जाग्रत के संस्कारों से उत्पन्न वासनामय जगत।
            जब इंद्रियां काम नहीं करतीं, फिर भी मन अपनी दबी हुई इच्छाओं से एक दुनिया बनाता है।
            सपनों में कोई असली बाहरी विषय नहीं होता, पर मन उन्हें बिल्कुल सच जैसा महसूस कराता है।
            यह अवस्था जीव के 'सूक्ष्म शरीर' की सक्रियता को दर्शाती है जहाँ मन ही सब कुछ है।
            सपनों का आधार जाग्रत अवस्था के अनुभव और अधूरी रह गई वासनाएं (Desires) ही होती हैं।
            इसे 'तैजस' अवस्था कहा जाता है जहाँ चेतना केवल आंतरिक मानसिक कल्पनाओं का भोग करती है।
            सपना हमें सिखाता है कि मन बिना किसी भौतिक वस्तु के भी सुख-दुख पैदा करने में समर्थ है।
            जैसे जागने पर सपना गायब हो जाता है, वैसे ही ज्ञान होने पर यह जाग्रत दुनिया भी गायब होती है।
            साधक के लिए सपने उसके अवचेतन मन (Subconscious) की गहराइयों को समझने का एक दर्पण हैं।
            सपनों और जाग्रत दोनों का जो साझा साक्षी (Witness) है, वही हमारी असली और अमर आत्मा है।
        """.trimIndent(),
        english = """
            Question: What is Svapna (Dream State)? Answer: A world of lust born from waking impressions.
            When senses stop working, yet the mind builds a world from its suppressed desires.
            In dreams, there are no real external objects, yet the mind makes them feel totally real.
            This state highlights the activity of the 'Subtle Body' where the mind is everything.
            The basis of dreams are the experiences and unfulfilled lusts (Vasanas) of the waking state.
            It is called the 'Taijasa' state, where consciousness enjoys only internal mental images.
            Dreams teach us that the mind is capable of creating joy and grief without physical objects.
            Just as the dream vanishes upon waking, this waking world vanishes upon enlightenment.
            For a seeker, dreams are a mirror to understand the depths of their subconscious mind.
            The common Witness of both dreams and waking is our true and indestructible Soul.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 8,
        sanskrit = "किं सुषुप्तिम् ? सर्वप्रकारज्ञानोपसंहारात् सुखमयी सुषुप्तिः ।",
        hindi = """
            प्रश्न: सुषुप्ति (Deep Sleep) क्या है? उत्तर: सभी प्रकार के ज्ञान के विलीन होने पर सुखमय अवस्था।
            गहरी नींद में न तो बाहरी दुनिया होती है और न ही कोई सपना, वहाँ केवल पूर्ण शांति होती है।
            यहाँ मन और बुद्धि अपने कारण (अज्ञान) में सो जाते हैं, इसलिए कोई द्वैत महसूस नहीं होता।
            सुषुप्ति में मनुष्य को जो सुख मिलता है, वह किसी वस्तु से नहीं, बल्कि शांति से आता है।
            इसे 'प्राज्ञ' अवस्था कहा जाता है जहाँ चेतना आनंद के अत्यंत समीप पहुँच जाती है।
            भले ही यहाँ अज्ञान का पर्दा रहता है, पर अहंकार का शोर शांत होने से हमें ताज़गी मिलती है।
            गहरी नींद यह साबित करती है कि हमारा असली स्वभाव 'आनंद' है, जो बिना विषय के भी है।
            यदि नींद में सुख न होता, तो कोई भी मनुष्य सोने की इच्छा कभी नहीं करता।
            साधक के लिए सुषुप्ति वह अवस्था है जहाँ वह जाने-अनजाने परमात्मा की गोद में विश्राम करता है।
            समाधि और सुषुप्ति में यही अंतर है कि समाधि में होश रहता है, जबकि यहाँ अज्ञान का अंधेरा है।
        """.trimIndent(),
        english = """
            Question: What is Sushupti (Deep Sleep)? Answer: Blissful state due to cessation of all knowledge.
            In deep sleep, there is neither the external world nor any dream; only perfect peace remains.
            Here, the mind and intellect sleep in their cause (ignorance), so no duality is felt.
            The happiness one feels in deep sleep comes not from objects, but from pure tranquility.
            It is called the 'Prajna' state, where consciousness reaches very close to absolute Bliss.
            Although a veil of ignorance remains here, the silence of the ego provides deep refreshment.
            Deep sleep proves that our original nature is 'Bliss', which exists even without objects.
            If there were no happiness in sleep, no human being would ever desire to go to sleep.
            For a seeker, Sushupti is the state where one rests in God's lap, knowingly or unknowingly.
            The difference between Samadhi and Sushupti is that Samadhi is conscious, while sleep is dark.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 9,
        sanskrit = "किं तुरीयम् ? अवस्थात्रयसाक्षिभूतं तुरीयम् ।",
        hindi = """
            प्रश्न: तुरीय (The Fourth State) क्या है? उत्तर: तीनों अवस्थाओं का साक्षी भाव ही तुरीय है।
            यह वह चेतना है जो जागते, सपने देखते और गहरी नींद में भी एक समान और अखंड रहती है।
            तुरीय कोई अस्थायी अवस्था नहीं है, बल्कि यह हमारा असली और स्थायी स्वरूप (Atman) है।
            यह जाग्रत के स्थूल, स्वप्न के सूक्ष्म और सुषुप्ति के कारण प्रपंच से पूरी तरह परे है।
            जैसे धागा मोतियों के बीच छिपा रहता है, वैसे ही तुरीय इन तीनों अवस्थाओं में छिपा है।
            जो इस 'चौथी' स्थिति को पहचान लेता है, वह जन्म और मृत्यु के पार चला जाता है।
            तुरीय शुद्ध प्रकाश है जो हमारी बुद्धि, मन और इंद्रियों को काम करने की ऊर्जा देता है।
            इसे पाना ही योग का अंतिम लक्ष्य है जिसे समाधि के द्वारा साक्षात् अनुभव किया जाता है।
            वहाँ न कोई दुख है, न कोई डर है, और न ही कोई दूसरा है; वहाँ केवल अद्वैत आनंद है।
            तुरीय को जान लेना ही ब्रह्म को जान लेना है, क्योंकि आत्मा और ब्रह्म वास्तव में एक ही हैं।
        """.trimIndent(),
        english = """
            Question: What is Turiya (The Fourth)? Answer: The Witness of the three previous states.
            This is the consciousness that remains identical and unbroken through waking, dreaming, and sleep.
            Turiya is not a temporary state, but our real and permanent original nature (Atman).
            It is entirely beyond the gross of waking, the subtle of dreams, and the causal of deep sleep.
            As a thread is hidden within beads, Turiya is hidden throughout these three states.
            One who recognizes this 'Fourth' state successfully transcends the cycle of birth and death.
            Turiya is the pure light providing energy to our intellect, mind, and senses to function.
            Attaining this is the final goal of Yoga, directly experienced through the state of Samadhi.
            There is no grief, no fear, and no 'other' there; only non-dual absolute bliss exists.
            To know Turiya is to know Brahman, for the Soul and Brahman are indeed strictly one.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 10,
        sanskrit = "क आत्मा ? चिदानन्दरूपः शुद्धो बुद्धो मुक्तः परमात्मा ।",
        hindi = """
            प्रश्न: आत्मा क्या है? उत्तर: जो चित् (चेतना), आनंद स्वरूप, शुद्ध, बुद्ध और नित्य मुक्त है।
            आत्मा वह है जो कभी अशुद्ध नहीं होती और जिसे कभी किसी बंधन में नहीं बाँधा जा सकता।
            वह 'चित्' है, अर्थात वह स्वयं प्रकाशमान है और दुनिया की हर चीज़ को रोशन करती है।
            वह 'आनंद' है, जिसका अर्थ है कि उसे खुश रहने के लिए किसी बाहरी कारण की जरूरत नहीं।
            वह 'बुद्ध' है, यानी वह हमेशा जाग्रत ज्ञान स्वरूप है; अज्ञान उसे कभी छू भी नहीं सकता।
            वह 'मुक्त' है, जिसका अर्थ है कि बंधन केवल शरीर का भ्रम है, आत्मा तो सदा आज़ाद है।
            यही वह परमात्मा है जो हमारे भीतर 'मैं' के असली अहसास के रूप में शांति से बैठा है।
            आत्मा न तो पैदा होती है और न ही मरती है; वह समय और स्थान की सीमाओं से परे है।
            इसे जानना ही खुद को जानना है और यही जीवन की सभी समस्याओं का एकमात्र समाधान है।
            हम जो शांति बाहर ढूँढ रहे हैं, वह वास्तव में इस आत्मा के रूप में हमारे ही पास मौजूद है।
        """.trimIndent(),
        english = """
            Question: What is the Atman? Answer: The Conscious, Blissful, Pure, Awake, and Free Self.
            The Atman is that which never becomes impure and can never be bound by any shackles.
            It is 'Chit' (Consciousness), meaning it is self-luminous and illuminates everything else.
            It is 'Ananda' (Bliss), implying it needs no external reason or object to be happy.
            It is 'Buddha' (Awake), meaning its nature is perpetual knowledge; ignorance cannot touch it.
            It is 'Mukta' (Free), signifying that bondage is a bodily illusion; the Soul is ever-free.
            This is the Supreme Self sitting peacefully within us as the real sense of our existence.
            The Atman is neither born nor does it die; it exists beyond the limits of time and space.
            Knowing this is knowing oneself, and this is the only solution to all of life's problems.
            The peace we are searching for outside is actually present with us in the form of this Atman.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 11,
        sanskrit = "क ईश्वरः ? मायाशक्तिविशिष्टं चैतन्यमीश्वरः ।",
        hindi = """
            प्रश्न: ईश्वर क्या है? उत्तर: माया रूपी शक्ति से युक्त शुद्ध चैतन्य ही ईश्वर है।
            जब निराकार ब्रह्म अपनी असीम शक्ति 'माया' को स्वीकार करता है, तो वह ईश्वर कहलाता है।
            ईश्वर ही इस ब्रह्मांड का रचयिता, पालक और संहारक (Destroyer) माना जाता है।
            वह पूरी सृष्टि का मालिक है और कर्मों के अनुसार जीवों को फल प्रदान करने वाला न्यायाधीश है।
            माया ईश्वर के अधीन है, इसलिए ईश्वर कभी भी अज्ञान या मोह के वश में नहीं होता।
            जैसे जादूगर अपने जादू से नहीं फँसता, वैसे ही ईश्वर अपनी माया के खेल में कभी नहीं फँसता।
            वह सर्वज्ञ (सब कुछ जानने वाला) और सर्वशक्तिमान (सब कुछ करने में समर्थ) सत्ता है।
            ईश्वर ही वह माध्यम है जिसके द्वारा जीव अपनी भक्ति और साधना से ब्रह्म तक पहुँचता है।
            भले ही वह सगुण (गुणों वाला) दिखता है, पर तत्व में वह निर्गुण ब्रह्म ही है।
            ईश्वर की शरण लेना अहंकार को मिटाने और सत्य के मार्ग पर चलने का सबसे सरल तरीका है।
        """.trimIndent(),
        english = """
            Question: What is Ishvara (God)? Answer: Pure Consciousness associated with Maya-power.
            When formless Brahman accepts His infinite power called 'Maya', He is known as Ishvara.
            Ishvara is considered the Creator, Sustainer, and Destroyer of this vast universe.
            He is the Master of all creation and the Judge who dispenses fruits according to karma.
            Maya is subordinate to Ishvara; hence, God is never under the control of ignorance.
            Just as a magician isn't fooled by his own magic, God is never trapped in His play of Maya.
            He is the Omniscient (all-knowing) and Omnipotent (all-powerful) absolute Reality.
            Ishvara is the medium through which the soul reaches Brahman via devotion and practice.
            Though He appears Saguna (with attributes), in essence, He is strictly the Nirguna Brahman.
            Taking refuge in Ishvara is the simplest way to erase ego and walk the path of Truth.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 12,
        sanskrit = "कः साक्षी ? जाग्रत्स्वप्नसुषुप्तिभ्योऽन्यः साक्षी ।",
        hindi = """
            प्रश्न: साक्षी (The Witness) कौन है? उत्तर: जाग्रत, स्वप्न और सुषुप्ति से भिन्न सत्ता ही साक्षी है।
            साक्षी वह है जो हमारे जागने, सपने देखने और सोने को चुपचाप देख रहा है पर जुड़ता नहीं।
            जैसे एक जलता हुआ दीपक कमरे में होने वाली हर हलचल को देखता है पर प्रभावित नहीं होता।
            साक्षी भाव का अर्थ है—विचारों को देखना पर विचारों के साथ बहना या उनमें फँसना नहीं।
            यह हमारे व्यक्तित्व का वह हिस्सा है जो कभी दुखी नहीं होता और जिसे कोई चोट नहीं लगती।
            साक्षी ही वह आधार है जिसके कारण हमें अपनी पुरानी यादों और अनुभवों का ज्ञान होता है।
            जब हम "मैं देख रहा हूँ कि मेरा मन उदास है" कहते हैं, तो वह 'देखने वाला' ही साक्षी है।
            साक्षी होने का अभ्यास करना ही ध्यान की सबसे ऊँची और सीधी वैज्ञानिक विधि है।
            यही वह 'साक्षी चेतना' है जो हमें शरीर और मन के ड्रामे से अलग और सुरक्षित रखती है।
            साक्षी को पहचान लेना ही अपने असली और अमर स्वरूप (अविनाशी आत्मा) को पहचान लेना है।
        """.trimIndent(),
        english = """
            Question: Who is the Sakshi (Witness)? Answer: The reality distinct from the three states.
            The Witness is He who silently observes our waking, dreaming, and sleeping without merging.
            As a lit lamp observes every movement in a room without being affected by the activity.
            Witnessing means observing thoughts without flowing with them or getting entangled in them.
            This is the part of our being that never gets sad and can never be wounded or harmed.
            The Witness is the foundation because of which we have knowledge of past memories.
            When we say "I see that my mind is sad," that internal 'Observer' is the Sakshi.
            Practicing being a Witness is the highest and most direct scientific method of meditation.
            This is the 'Witness Consciousness' that keeps us separate and safe from the drama of ego.
            To recognize the Sakshi is to recognize one's original and indestructible immortal nature.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 13,
        sanskrit = "कः कूटस्थः ? सर्वभूतानां बुद्धौ तिष्ठति स कूटस्थः ।",
        hindi = """
            प्रश्न: कूटस्थ (The Immutable) क्या है? उत्तर: जो सभी प्राणियों की बुद्धि में अचल होकर स्थित है।
            'कूट' का अर्थ है निहाई (Anvil) जिस पर लोहार प्रहार करता है पर वह स्वयं नहीं बदलती।
            दुनिया बदलती है, शरीर बदलता है, पर बुद्धि के पीछे जो चेतना है वह हमेशा स्थिर रहती है।
            कूटस्थ वह अचल आधार है जिसके ऊपर संसार का सारा परिवर्तनशील नाच (Dance) हो रहा है।
            यह आत्मा का वह रूप है जो सभी विकारों और बदलावों से पूरी तरह और हमेशा मुक्त रहता है।
            जैसे सिनेमा का पर्दा स्थिर रहता है चाहे फिल्म में आग लगे या पानी गिरे, वैसा ही कूटस्थ है।
            वह हमारी बुद्धि को प्रकाशित करता है पर बुद्धि के अज्ञान या दोषों से कभी गंदा नहीं होता।
            कूटस्थ को जानने का अर्थ है उस चट्टान को ढूँढ लेना जो जीवन के तूफानों में कभी नहीं हिलती।
            यह शब्द ईश्वर की अखंडता और उसकी कभी न खत्म होने वाली स्थिरता का प्रतीक है।
            जब हम इस कूटस्थ तत्व से जुड़ जाते हैं, तो हम भी समय के थपेड़ों से पूरी तरह सुरक्षित हो जाते हैं।
        """.trimIndent(),
        english = """
            Question: What is Kutastha (Immutable)? Answer: That which sits unmoving in the intellect.
            'Kuta' means an anvil upon which the blacksmith strikes, but the anvil itself never changes.
            The world changes, the body changes, but the consciousness behind the intellect is steady.
            Kutastha is the motionless base upon which the entire shifting dance of the world occurs.
            It is the aspect of the Soul that remains entirely free from all modifications and changes.
            As a cinema screen remains steady whether the film shows fire or rain, so is Kutastha.
            It illuminates our intellect but never gets soiled by the intellect's ignorance or flaws.
            Knowing Kutastha means finding that rock which never shakes during the storms of life.
            This term symbolizes God's integrity and His never-ending, absolute stillness.
            When we connect with this Kutastha principle, we too become safe from the blows of time.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 14,
        sanskrit = "कोऽन्तर्यामी ? सर्वभूतानां हृदयकमले तिष्ठति सोऽन्तर्यामी ।",
        hindi = """
            प्रश्न: अंतर्यामी (Inner Controller) कौन है? उत्तर: जो सभी प्राणियों के हृदय-कमल में स्थित है।
            अंतर्यामी वह ईश्वर है जो हमारे सबसे गुप्त विचारों और भावनाओं को भी गहराई से जानता है।
            वह बाहर से आदेश नहीं देता, बल्कि वह अंदर से ही हमारी बुद्धि को सही दिशा में प्रेरित करता है।
            वह हर जीव की धड़कन और हर विचार के पीछे काम करने वाली अदृश्य और चेतन शक्ति है।
            दुनिया की कोई भी बात अंतर्यामी से छिपी नहीं रह सकती, क्योंकि वह हमारे ही भीतर बैठा है।
            वह हमारा सबसे करीबी मित्र है जो हर सुख और दुख में हमारे साथ साये की तरह रहता है।
            अंतर्यामी ही वह गुरु है जो शब्द के बिना हमें सही और गलत के बीच का भेद समझाता है।
            जब हम प्रार्थना करते हैं, तो वह इसी अंतर्यामी तत्व तक पहुँचती है जो दिल में विराजमान है।
            उसे प्रसन्न करने के लिए किसी बाहरी दिखावे की नहीं, बल्कि केवल 'सच्चाई' की जरूरत होती है।
            अंतर्यामी को पहचान लेने पर मनुष्य अकेलापन महसूस करना हमेशा के लिए बंद कर देता है।
        """.trimIndent(),
        english = """
            Question: Who is Antaryami (Inner Ruler)? Answer: He who dwells in the lotus of the heart.
            Antaryami is that God who deeply knows even our most secret thoughts and silent emotions.
            He does not command from the outside; He inspires our intellect in the right direction from within.
            He is the invisible and conscious power working behind every heartbeat and every thought.
            Nothing in the world can be hidden from Antaryami because He is seated right inside us.
            He is our closest friend who stays with us like a shadow in every joy and every sorrow.
            Antaryami is the silent Guru who explains the difference between right and wrong without words.
            When we pray, the prayer reaches this very Antaryami principle residing in our heart.
            To please Him, no external show is required; only absolute 'honesty' is necessary.
            Upon recognizing the Antaryami, a human being permanently stops feeling any sense of loneliness.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 15,
        sanskrit = "किं प्रत्यगात्मा ? चिन्मात्रः प्रत्यगात्मा ।",
        hindi = """
            प्रश्न: प्रत्यगात्मा (Individual Soul) क्या है? उत्तर: जो केवल शुद्ध चैतन्य (Pure Consciousness) है।
            यह हमारी चेतना का वह स्तर है जो शरीर और मन के आवरणों के बिल्कुल पीछे शांत खड़ा है।
            प्रत्यगात्मा का अर्थ है—वह 'मैं' जो किसी भी उपाधि (नाम, पद, उम्र) से पूरी तरह मुक्त है।
            जब हम खुद से पूछते हैं "मैं कौन हूँ?", तो जो अंतिम उत्तर बचता है वही प्रत्यगात्मा है।
            यह वह प्रकाश है जो न तो कभी घटता है और न ही कभी बढ़ता है, यह हमेशा एक समान है।
            भले ही यह शरीर में कैद लगता है, पर वास्तव में यह आकाश की तरह स्वतंत्र और मुक्त है।
            यह प्रत्यगात्मा ही वह बिंदु है जहाँ जीव और ब्रह्म का आपस में मिलन और साक्षात् होता है।
            इसे जानना ही अद्वैत की पहली सीढ़ी है जहाँ हम जड़ और चेतन के बीच का भेद समझ जाते हैं।
            प्रत्यगात्मा को जान लेने के बाद इंसान की पूरी जीवन दृष्टि (Perspective) बदल जाती है।
            यही वह शुद्ध 'मैं' (Pure Ego-less I) है जो संसार के सभी बंधनों से सर्वथा अछूता रहता है।
        """.trimIndent(),
        english = """
            Question: What is Pratyagatman? Answer: That which is merely Pure Consciousness (Chinmatra).
            This is the level of our awareness that stands silently behind the sheaths of body and mind.
            Pratyagatman means the 'I' that is entirely free from any label (name, status, or age).
            When we ask ourselves "Who am I?", the final remaining answer is the Pratyagatman.
            It is the light that neither decreases nor increases; it remains constant and uniform.
            Although it seems imprisoned in the body, it is actually as independent and free as space.
            This Pratyagatman is the very point where the soul and Brahman meet and become one.
            Knowing this is the first step of Advaita where we understand the gap between matter and spirit.
            After realizing the Pratyagatman, a human's entire perspective on life changes completely.
            This is the pure 'I' (Pure Ego-less I) that remains absolutely untouched by worldly bonds.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 16,
        sanskrit = "किं परं ब्रह्म ? सत्यं ज्ञानमनन्तं ब्रह्म ।",
        hindi = """
            प्रश्न: परब्रह्म (Supreme Brahman) क्या है? उत्तर: जो सत्य, ज्ञान और अनंत स्वरूप है।
            ब्रह्म वह है जिसका कभी विनाश नहीं होता (सत्य) और जो समय की सीमाओं से पूरी तरह परे है।
            वह 'ज्ञान' स्वरूप है, अर्थात वह चेतना का वह सागर है जिससे पूरी सृष्टि को होश मिलता है।
            वह 'अनंत' है, जिसका अर्थ है कि उसकी कोई भी दिशा, कोई अंत और कोई सीमा नहीं है।
            परब्रह्म वह अंतिम आधार है जिस पर पूरा ब्रह्मांड एक सपने की तरह प्रकट और विलीन होता है।
            वह शब्दों और कल्पनाओं की पहुँच से बाहर है, पर फिर भी वह हमारे सबसे करीब स्थित है।
            ब्रह्म ही एकमात्र वह सत्य है जिसके होने से बाकी सब कुछ सच जैसा दिखाई देता है।
            इसे जानना ही परम सुख और परम शांति है, क्योंकि इसके बाद और कुछ जानना शेष नहीं रहता।
            यह परब्रह्म ही हमारी अपनी आत्मा का वह विराट रूप है जिसे हम अज्ञानवश भूल गए हैं।
            सत्यं-ज्ञानं-अनंतं—यही उस सर्वोच्च सत्ता की सबसे प्रामाणिक और वैज्ञानिक परिभाषा है।
        """.trimIndent(),
        english = """
            Question: What is Supreme Brahman? Answer: He who is Truth, Knowledge, and Infinity.
            Brahman is that which never undergoes destruction (Truth) and is beyond the limits of time.
            He is 'Knowledge', meaning He is the ocean of consciousness from which all creation gets life.
            He is 'Infinite', implying He has no direction, no end, and no physical or mental boundaries.
            Supreme Brahman is the ultimate base upon which the cosmos appears and dissolves like a dream.
            He is beyond the reach of words and imaginations, yet He is situated closest to our being.
            Brahman is the only Truth because of whose existence everything else appears to be real.
            Realizing This is supreme joy and peace, because after this, nothing else remains to be known.
            This Supreme Brahman is the cosmic form of our own Soul which we have forgotten via ignorance.
            Satyam-Jnanam-Anantam—this is the most authentic and scientific definition of the Absolute.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 17,
        sanskrit = "किं माया ? अनादिः सा शक्तिः ।",
        hindi = """
            प्रश्न: माया (Illusion) क्या है? उत्तर: वह अनादि शक्ति जो असंभव को संभव कर दिखाती है।
            माया ईश्वर की वह रचनात्मक ऊर्जा है जिससे वह इस रंग-बिरंगे संसार का निर्माण करता है।
            यह 'अनादि' है, यानी इसकी शुरुआत कब हुई यह बुद्धि से कभी नहीं समझा जा सकता।
            माया सत्य को छिपा देती है (आवरण) और जो नहीं है उसे सच दिखा देती है (विक्षेप)।
            जैसे जादूगर का खेल सच लगता है पर होता नहीं, वैसे ही माया का यह संसार दिखाई देता है।
            यह हमें एक ही परमात्मा में करोड़ों अलग-अलग जीव और वस्तुएं देखने पर मजबूर करती है।
            माया बुरी नहीं है, पर इसमें उलझकर खुद को भूल जाना ही जीव के सभी दुखों का मूल कारण है।
            जो माया के स्वामी (ईश्वर) की शरण लेता है, वही इस पार न पा सकने वाली माया को पार करता है।
            ज्ञान होने पर माया मिटती नहीं, बल्कि उसका प्रभाव (असर) साधक के ऊपर से पूरी तरह खत्म हो जाता है।
            माया को समझना ही संसार के खेल को समझना है ताकि हम इसमें फँसने की बजाय इसका आनंद लें।
        """.trimIndent(),
        english = """
            Question: What is Maya? Answer: That beginningless power which makes the impossible possible.
            Maya is God's creative energy through which He constructs this vibrant and diverse universe.
            It is 'Anadi' (beginningless), meaning its origin can never be understood by the limited human brain.
            Maya hides the Truth (Avarana) and projects the false as real (Vikshepa).
            Just as a magician's trick seems real but isn't, so does this world of Maya appear to us.
            It forces us to perceive millions of separate beings and objects within the single Supreme Lord.
            Maya isn't evil, but getting entangled in it and forgetting oneself is the cause of all grief.
            One who takes refuge in the Master of Maya (God) successfully crosses this insurmountable Maya.
            Upon enlightenment, Maya doesn't vanish, but its binding influence on the seeker ends completely.
            Understanding Maya is understanding the game of the world so we can enjoy it without getting trapped.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 18,
        sanskrit = "कः प्रपञ्चः ? मायाकार्यं प्रपञ्चः ।",
        hindi = """
            प्रश्न: प्रपञ्च (Phenomenal World) क्या है? उत्तर: माया का जो कार्य (परिणाम) है, वही प्रपञ्च है।
            यह दृश्यमान जगत—ग्रह, तारे, शरीर, और मन—माया की ही एक विस्तृत अभिव्यक्ति (प्रपञ्च) है।
            प्रपञ्च का अर्थ है वह विस्तार जो पाँच तत्वों (पंचभूतों) के मेल से तैयार हुआ है।
            यह वह रंगमंच (Stage) है जहाँ जीव अपने कर्मों का नाटक खेलता है और अनुभव प्राप्त करता है।
            प्रपञ्च क्षणभंगुर है, यानी यह हर पल बदल रहा है और एक दिन पूरी तरह नष्ट हो जाएगा।
            हम जिसे ठोस दुनिया समझते हैं, वह वास्तव में चेतना की तरंगों का एक जटिल जाल (प्रपञ्च) है।
            यह अज्ञानी को बाँधता है, पर ज्ञानी को ईश्वर की अनंत रचनात्मकता का दर्शन कराता है।
            प्रपञ्च से भागना समाधान नहीं है, बल्कि प्रपञ्च के पीछे छिपे सत्य (ब्रह्म) को देखना समाधान है।
            यह वह 'फैलाव' है जो हमें एकता में अनेकता का भ्रम पैदा करके संसार में उलझाए रखता है।
            जब साधक की दृष्टि अंतर्मुखी होती है, तब वह इस प्रपञ्च को केवल एक आभास मात्र समझने लगता है।
        """.trimIndent(),
        english = """
            Question: What is Prapancha? Answer: The effect (manifestation) of Maya is Prapancha.
            This visible world—planets, stars, bodies, and minds—is a detailed expression of Maya.
            Prapancha refers to the expansion created by the combination of the five material elements.
            It is the stage where the soul plays its drama of karma and gains various experiences.
            Prapancha is ephemeral, meaning it changes every moment and will eventually be destroyed.
            What we perceive as a solid world is actually a complex web (Prapancha) of conscious waves.
            It binds the ignorant, but reveals God's infinite creativity to the enlightened seeker.
            Running from Prapancha is not the solution; seeing the Truth (Brahman) behind it is the solution.
            It is the 'extension' that creates the illusion of many in one, keeping us entangled in life.
            When a seeker's vision turns inward, he begins to realize this Prapancha as merely an appearance.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 19,
        sanskrit = "को जीवः ? मायावच्छिन्नं चैतन्यं जीवः ।",
        hindi = """
            प्रश्न: जीव (Individual Self) कौन है? उत्तर: माया की सीमाओं में बँधा हुआ चैतन्य ही जीव है।
            जब वह अनंत चेतना (ब्रह्म) खुद को एक छोटे से शरीर और मन में सीमित मान लेती है, तो वह जीव है।
            जीव होने का अर्थ है—स्वयं को कर्ता, भोक्ता और एक नाशवान व्यक्ति (Personality) समझना।
            यह वह अवस्था है जहाँ हम अपनी ईश्वरीय शक्तियों को भूलकर लाचार और कमजोर महसूस करते हैं।
            जीव अज्ञान के कारण सुख-दुख के झूले में झूलता है और जन्म-मृत्यु के चक्र में भटकता है।
            असल में जीव और ब्रह्म में कोई फर्क नहीं है, जैसे घड़े के अंदर का आकाश और बाहर का आकाश।
            बस 'घड़ा' (अहंकार) वह सीमा है जो जीव को ब्रह्म से अलग होने का भ्रम पैदा करती है।
            अध्यात्म का पूरा लक्ष्य इस जीव-भाव को मिटाकर पुनः ब्रह्म-भाव को प्राप्त करना ही है।
            जब जीव जान लेता है "मैं जीव नहीं, मैं शिव हूँ", तो उसके सारे दुख तुरंत समाप्त हो जाते हैं।
            जीव होना केवल एक अस्थायी भूमिका (Role) है, जिसे हमने इस संसार के नाटक के लिए निभाया है।
        """.trimIndent(),
        english = """
            Question: Who is the Jiva? Answer: Consciousness limited and conditioned by Maya.
            When that infinite Awareness (Brahman) considers itself limited to a small body and mind, it is Jiva.
            Being a Jiva means perceiving oneself as a doer, enjoyer, and a perishable individual personality.
            This is the state where we forget our divine powers and feel helpless, small, and weak.
            The Jiva oscillates between joy and grief due to ignorance, wandering in the cycle of rebirth.
            In reality, there is no difference between Jiva and Brahman, like space inside and outside a pot.
            Only the 'Pot' (Ego) is the boundary creating the illusion that Jiva is separate from Brahman.
            The entire goal of spirituality is to erase this 'Jiva-sense' and regain the 'Brahman-sense'.
            When the Jiva realizes "I am not a creature, I am Shiva," all its sorrows end instantaneously.
            Being a Jiva is merely a temporary role played for the grand drama of this worldly existence.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 20,
        sanskrit = "किं स्थूलशरीरम् ? पञ्चीकृतपञ्चमहाभूतैः कृतं शरीरं स्थूलशरीरम् ।",
        hindi = """
            प्रश्न: स्थूल शरीर (Gross Body) क्या है? उत्तर: पाँच तत्वों के स्थूल मेल से बना यह भौतिक शरीर।
            आकाश, वायु, अग्नि, जल और पृथ्वी—इनके आपस में मिलने (पञ्चीकरण) से यह मांस का ढांचा बनता है।
            यह वह शरीर है जिसे हम देख सकते हैं, छू सकते हैं और जो अन्न (भोजन) से पोषित होता है।
            जन्म लेना, बढ़ना, बूढ़ा होना और मर जाना—ये सभी बदलाव इसी स्थूल शरीर के धर्म हैं।
            यह आत्मा का सबसे बाहरी आवरण (अन्नमय कोष) है जो दुनिया के संपर्क में रहता है।
            स्थूल शरीर केवल एक वाहन (Vehicle) है जिसका उपयोग आत्मा अपने अनुभवों के लिए करती है।
            हम अक्सर इस मिट्टी के पुतले को ही 'मैं' मान लेते हैं, जो सभी दुखों की मुख्य जड़ है।
            मरने के बाद यह शरीर वापस इन्हीं पाँच तत्वों में विलीन होकर धूल में मिल जाता है।
            ज्ञानी पुरुष इस शरीर का ख्याल तो रखता है, पर इससे कभी भी मोह या आसक्ति नहीं रखता।
            यह शरीर मंदिर जैसा है, पर मंदिर की मूर्ति (आत्मा) मंदिर से कहीं अधिक महत्वपूर्ण है।
        """.trimIndent(),
        english = """
            Question: What is the Gross Body? Answer: The body formed by the five gross elements.
            Ether, air, fire, water, and earth—the combination of these (Panchikarana) forms this fleshly frame.
            This is the body we can see, touch, and which is nourished and sustained entirely by food.
            Being born, growing, aging, and dying—all these modifications are the traits of this gross body.
            It is the outermost sheath of the Soul (Annamaya Kosha) that remains in contact with the world.
            The gross body is merely a vehicle utilized by the Soul to gather its worldly experiences.
            We often mistake this puppet of clay for the 'I', which is the primary root of all suffering.
            After death, this body dissolves back into these very five elements and turns into dust.
            A wise man cares for this body but never maintains any deluded infatuation or attachment to it.
            This body is like a temple, but the idol (Soul) inside is far more important than the structure.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 21,
        sanskrit = "किं सूक्ष्मशरीरम् ? अपञ्चीकृतपञ्चमहाभूतैः कृतं शरीरं सूक्ष्मशरीरम् ।",
        hindi = """
            प्रश्न: सूक्ष्म शरीर (Subtle Body) क्या है? उत्तर: पाँच तत्वों के सूक्ष्म अंशों से बना हुआ शरीर।
            इसमें हमारी पाँच ज्ञानेंद्रियां, पाँच कर्मेंद्रियां, पाँच प्राण, मन और बुद्धि शामिल हैं।
            सूक्ष्म शरीर वह है जिसे भौतिक आँखों से नहीं देखा जा सकता, पर यह स्थूल को चलाता है।
            यह वह 'ऊर्जा शरीर' है जो मृत्यु के बाद भी नहीं मरता और अगले जन्म तक साथ जाता है।
            सपनों का अनुभव हम इसी सूक्ष्म शरीर के माध्यम से करते हैं जब स्थूल शरीर सोया होता है।
            हमारे संस्कार, आदतें और यादें इसी सूक्ष्म शरीर में सॉफ्टवेयर की तरह संचित रहती हैं।
            यही वह कड़ी है जो आत्मा को भौतिक जगत के अनुभवों और संवेदनाओं से जोड़कर रखती है।
            इसे शुद्ध करना (चित्त-शुद्धि) ही योग और साधना का सबसे महत्वपूर्ण और अनिवार्य हिस्सा है।
            जब तक सूक्ष्म शरीर में वासनाएं बाकी हैं, तब तक जीव को बार-बार जन्म लेना पड़ता है।
            मोक्ष का अर्थ है—इस सूक्ष्म शरीर का भी कारण शरीर में पूरी तरह से विलय और विनाश हो जाना।
        """.trimIndent(),
        english = """
            Question: What is the Subtle Body? Answer: The body made of the five subtle elements.
            It includes the five senses of knowledge, five organs of action, five pranas, mind, and intellect.
            The subtle body cannot be seen with physical eyes, but it is what operates the gross body.
            It is the 'energy body' that does not die with the physical form and travels to the next birth.
            We experience dreams through this subtle body while the gross physical body is fast asleep.
            Our impressions (Sanskaras), habits, and memories are stored here like internal software.
            This is the link that connects the Soul to the experiences and sensations of the material world.
            Purifying this (Chitta-shuddhi) is the most vital and mandatory part of all spiritual practice.
            As long as lusts and cravings remain in the subtle body, the soul is forced to be reborn.
            Moksha means the total dissolution and destruction of this subtle body into the causal state.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 22,
        sanskrit = "किं कारणशरीरम् ? स्वस्वरूपभूताज्ञानमात्रं कारणशरीरम् ।",
        hindi = """
            प्रश्न: कारण शरीर (Causal Body) क्या है? उत्तर: अपने असली स्वरूप का अज्ञान ही कारण शरीर है।
            यह वह बीज (Seed) अवस्था है जहाँ से स्थूल और सूक्ष्म दोनों शरीरों की उत्पत्ति होती है।
            गहरी नींद (सुषुप्ति) में हम इसी कारण शरीर की स्थिति में होते हैं जहाँ कुछ भी याद नहीं रहता।
            यह अविद्या का वह घना अंधेरा है जो आत्मा के प्रकाश को पूरी तरह ढँक कर रख देता है।
            कारण शरीर वह 'ब्लैंक' अवस्था है जिसमें आने वाले जन्मों की पूरी योजना गुप्त रूप से छिपी है।
            जैसे बीज में पूरा पेड़ छिपा होता है, वैसे ही कारण शरीर में हमारा पूरा भविष्य छिपा होता है।
            इसे 'आनंदमय कोष' भी कहते हैं क्योंकि यहाँ मन की बेचैनी नहीं होती, पर अज्ञान बना रहता है।
            जब तक यह 'कारण' (अज्ञान का बीज) मौजूद है, तब तक संसार का वृक्ष उगता ही रहेगा।
            आत्मज्ञान की अग्नि इस कारण शरीर के बीज को भून देती है ताकि दोबारा जन्म का अंकुर न फूटे।
            इस अंतिम परत को पार करना ही साक्षात् परमात्मा से मिलन और शाश्वत आज़ादी पाना है।
        """.trimIndent(),
        english = """
            Question: What is the Causal Body? Answer: Mere ignorance of one's own original nature.
            This is the seed state from which both the gross and subtle bodies successfully originate.
            In deep sleep (Sushupti), we are in the state of the causal body where nothing is remembered.
            It is the dense darkness of Avidya that completely covers and veils the light of the Soul.
            The causal body is that 'blank' state in which the entire plan of future births is hidden.
            As a whole tree is hidden in a seed, our entire future is hidden within this causal body.
            It is also called the 'Blissful Sheath' because mental unrest is absent, yet ignorance remains.
            As long as this 'Cause' (the seed of ignorance) exists, the tree of the world will keep growing.
            The fire of Self-knowledge roasts this causal seed so that the sprout of rebirth never grows again.
            Transcending this final layer is merging with the Supreme Lord and gaining eternal freedom.
        """.trimIndent()
    ),
    SarvasaraShloka(
        id = 23,
        sanskrit = "किं पारमार्थिकम् ? यत् सर्वदा सत्यं तत् पारमार्थिकम् ।",
        hindi = """
            प्रश्न: पारमार्थिक (Ultimate Reality) क्या है? उत्तर: जो तीनों कालों में सदा सत्य रहे, वही पारमार्थिक है।
            वह सत्य जो जाग्रत, स्वप्न और सुषुप्ति—तीनों अवस्थाओं में कभी भी बदलता या मिटता नहीं है।
            संसार 'व्यावहारिक' सत्य है (अस्थायी), पर आत्मा ही एकमात्र 'पारमार्थिक' सत्य (स्थायी) है।
            पारमार्थिक सत्ता वह है जिसके होने के लिए किसी और सहारे की बिल्कुल भी जरूरत नहीं होती।
            वह न कभी पैदा होता है, न कभी बूढ़ा होता है और न ही उसका कभी अंत हो सकता है।
            जो इस परम सत्य को जान लेता है, उसके लिए दुनिया के सारे छोटे सच और झूठ बेमानी हो जाते हैं।
            यह वह शुद्ध सोना है जिससे संसार के सभी गहने (नाम और रूप) गढ़े गए हैं।
            पारमार्थिक दृष्टि प्राप्त करना ही ज्ञान की पराकाष्ठा है जहाँ केवल एक ही सत्ता दिखाई देती है।
            यही वह 'अमृत' है जिसे पीकर मनुष्य हमेशा के लिए अभय (भय-मुक्त) और अमर हो जाता है।
            ॐ शांतिः शांतिः शांतिः—यहाँ सर्वसार उपनिषद का यह दार्शनिक शब्दकोश पूर्ण रूप से संपन्न होता है।
        """.trimIndent(),
        english = """
            Question: What is Paramarthika (Absolute Truth)? Answer: That which is eternally True.
            The Truth that never changes or vanishes during the states of waking, dreaming, or deep sleep.
            The world is a 'Relative' truth (temporary), but the Soul is the only 'Absolute' Truth (eternal).
            Absolute Reality is that which requires no other support or evidence to prove its existence.
            It is never born, it never grows old, and it can absolutely never come to an end or perish.
            One who realizes this supreme Truth finds all other small truths and lies to be meaningless.
            It is the pure gold from which all the world's ornaments (names and forms) have been crafted.
            Attaining the absolute perspective is the peak of wisdom where only one single Reality is seen.
            This is the 'Nectar' drinking which a human becomes forever fearless and truly immortal.
            OM Peace, Peace, Peace—here the philosophical dictionary of Sarvasara Upanishad is completed.
        """.trimIndent()
    )
)