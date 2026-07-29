package com.sanatangyansagar.ui.screens.gita

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AdhyayaTwo() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaTwoShlokas.indexOfFirst { it.id == shlokaNum }
            if (targetIndex != -1) {
                coroutineScope.launch {
                    listState.animateScrollToItem(targetIndex)
                }
                keyboardController?.hide()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (e.g., 7)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { performSearch() }
            ),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump to Shloka")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(adhyayaTwoShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaTwoShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            सञ्जय उवाच |
            तं तथा कृपयाविष्टमश्रुपूर्णाकुलेक्षणम् |
            विषीदन्तमिदं वाक्यमुवाच मधुसूदनः || १ ||
        """.trimIndent(),
        hindi = """
            संजय ने कहा: इस प्रकार करुणा (शोक) से पूरी तरह घिरे हुए, आँसुओं से भरी और व्याकुल आँखों वाले...
            उस अत्यंत दुःखी और अवसादग्रस्त अर्जुन को देखकर मधुसूदन (भगवान श्रीकृष्ण) ने यह महत्वपूर्ण वचन कहे।
            यह श्लोक दूसरे अध्याय (सांख्य योग) की प्रस्तावना है, जहाँ से वास्तविक आध्यात्मिक उपचार शुरू होता है।
            अर्जुन की स्थिति एक वीर योद्धा की नहीं, बल्कि एक हताश और मोहग्रस्त साधारण मनुष्य की हो गई है।
            संजय स्पष्ट रूप से बताते हैं कि अर्जुन की आँखें आँसुओं से डबडबा गई हैं ('अश्रुपूर्णाकुलेक्षणम्')।
            एक क्षत्रिय के लिए युद्धभूमि में रोना उसकी सबसे बड़ी मानसिक दुर्बलता और पतन का प्रतीक माना जाता है।
            परंतु यहाँ अर्जुन का यह रुदन किसी शारीरिक भय के कारण नहीं, बल्कि 'कृपा' (अत्यधिक और अनुचित दया) के कारण है।
            यह वह बिंदु है जहाँ सांसारिक मोह ने आत्मा के प्राकृतिक धर्म को पूरी तरह से ढक लिया है।
            संजय जानबूझकर श्रीकृष्ण के लिए 'मधुसूदन' नाम का प्रयोग करते हैं; जिन्होंने मधु नामक भयानक असुर को मारा था।
            यह नाम यह संकेत देता है कि अब भगवान श्रीकृष्ण अर्जुन के मन में बैठे 'मोह' रूपी इस भयंकर असुर का भी वध करने वाले हैं।
        """.trimIndent(),
        english = """
            Sanjaya said: Seeing Arjuna thus completely overwhelmed with misplaced compassion, his mind deeply depressed...
            and his eyes brimming with tears of sorrow, Madhusudana (Lord Krishna) spoke these profound words to him.
            This verse acts as the prologue to the Second Chapter (Sankhya Yoga), marking the beginning of the actual spiritual treatment.
            Arjuna's current state is absolutely not that of a heroic warrior, but of a desperate, hopelessly deluded ordinary man.
            Sanjaya clearly vividly describes that Arjuna's eyes are completely welling up with tears ('ashru-purna-kulekshanam').
            For a Kshatriya warrior to physically cry on the battlefield is considered the ultimate symbol of mental weakness and downfall.
            However, Arjuna's crying here is not due to any physical fear of death, but due to 'Kripa' (excessive and misplaced pity).
            This is the exact breaking point where deep worldly attachment has completely covered the natural, righteous duty of the soul.
            Sanjaya intentionally uses the name 'Madhusudana' for Krishna, referring to the time He killed the terrifying demon named Madhu.
            This powerfully hints that Lord Krishna is now about to effortlessly slay the terrible demon of 'Illusion' sitting within Arjuna's mind.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            श्रीभगवानुवाच |
            कुतस्त्वा कश्मलमिदं विषमे समुपस्थितम् |
            अनार्यजुष्टमस्वर्ग्यमकीर्तिकरमर्जुन || २ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे अर्जुन! तुम्हारे मन में इस विषम (कठिन) स्थिति में यह भयंकर अज्ञान (कश्मलम) कहाँ से आ गया?
            यह आचरण न तो श्रेष्ठ पुरुषों (आर्यों) के योग्य है, न ही यह स्वर्ग देने वाला है, और न ही इससे इस लोक में कोई कीर्ति (यश) मिलेगी।
            पूरे ग्रंथ में यह पहली बार है जब परमेश्वर स्वयं बोल रहे हैं (श्रीभगवानुवाच), और उनके पहले ही शब्द सहानुभूति के नहीं, बल्कि फटकार के हैं।
            भगवान अर्जुन की इस भावुकता को 'करुणा' नहीं मानते, बल्कि वे इसे 'कश्मलम्' (गंदगी, अशुद्धता या मानसिक कचरा) कहते हैं।
            युद्ध के इस अत्यंत निर्णायक और संकटपूर्ण क्षण ('विषमे') में इस प्रकार का कायरतापूर्ण विचार आना एक योद्धा के लिए अत्यंत शर्मनाक है।
            श्रीकृष्ण स्पष्ट करते हैं कि अर्जुन जो कुछ भी सोच रहे हैं, वह किसी भी कोण से सही नहीं है।
            'अनार्यजुष्टम्'—यह उन लोगों का मार्ग नहीं है जो जीवन के उच्च आदर्शों (आर्य) को समझते हैं।
            'अस्वर्ग्यम्'—क्षत्रिय धर्म से भागने के कारण यह कृत्य परलोक में तुम्हें स्वर्ग या उच्च गति भी नहीं देगा।
            'अकीर्तिकरम्'—और इस लोक में भी तुम्हारी पीढ़ियों तक निंदा होगी कि तुम युद्धभूमि से डरकर भाग गए।
            भगवान एक झटके में अर्जुन के उस महान दार्शनिक आवरण को फाड़ देते हैं, जिसके पीछे छिपकर अर्जुन युद्ध से भागना चाहते थे।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead said: O Arjuna! From where has this terrible impurity and delusion (Kashmalam) come upon you in this hour of crisis?
            This behavior is absolutely not fit for an advanced, noble man (Aryan); it does not lead to higher planets (heaven), but rather leads only to infamy and disgrace.
            This is the very first time in the text that the Supreme Lord Himself speaks (Sri Bhagavan Uvacha), and His first words are not of sympathy, but of a sharp rebuke.
            The Lord absolutely does not consider Arjuna's emotional breakdown as 'compassion'; rather, He bluntly calls it 'Kashmalam' (dirt, impurity, or mental garbage).
            To entertain such cowardly thoughts at this extremely decisive and critical moment of war ('Vishame') is deeply shameful for a warrior.
            Sri Krishna makes it crystal clear that whatever Arjuna is thinking is fundamentally wrong from absolutely every single angle.
            'Anarya-jushtam'—This is definitely not the path of those who understand the higher, noble values of life (the Aryans).
            'Aswargyam'—By abandoning your sacred martial duty, this act will absolutely not grant you heaven or higher elevation in the afterlife.
            'Akirtikaram'—And even in this current world, you will face eternal infamy for running away from the battlefield out of fear.
            In one swift stroke, the Lord tears away the grand philosophical mask behind which Arjuna was desperately trying to hide his fear.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            क्लैब्यं मा स्म गमः पार्थ नैतत्त्वय्युपपद्यते |
            क्षुद्रं हृदयदौर्बल्यं त्यक्त्वोत्तिष्ठ परन्तप || ३ ||
        """.trimIndent(),
        hindi = """
            हे पृथा-पुत्र (पार्थ)! इस नपुंसकता (कायरता) को प्राप्त मत हो; यह तुम्हारे जैसे महान वीर को बिल्कुल भी शोभा नहीं देता।
            हे शत्रुओं को संताप देने वाले (परन्तप)! हृदय की इस अत्यंत तुच्छ और छोटी दुर्बलता को तुरंत त्याग दो और युद्ध के लिए खड़े हो जाओ।
            भगवान श्रीकृष्ण यहाँ एक अत्यंत कठोर और मनोवैज्ञानिक रूप से झकझोरने वाली भाषा का प्रयोग कर रहे हैं।
            वे दुनिया के सर्वश्रेष्ठ क्षत्रिय को 'क्लैब्यं' (नपुंसकता या नामर्दी) शब्द कहकर ललकार रहे हैं ताकि अर्जुन का सोया हुआ स्वाभिमान जाग उठे।
            कृष्ण जानते हैं कि अर्जुन की यह स्थिति किसी सच्ची करुणा से नहीं, बल्कि एक गहरे मनोवैज्ञानिक डर और मोह से पैदा हुई है।
            इसलिए वे इसे 'क्षुद्रं हृदयदौर्बल्यं' कहते हैं, अर्थात् यह कोई महान आध्यात्मिक त्याग नहीं है, बल्कि हृदय की एक अत्यंत नीच और तुच्छ कमजोरी है।
            वे अर्जुन को 'पार्थ' (कुंती का पुत्र) कहकर याद दिलाते हैं कि तुम्हारी माता ने तुम्हें अन्याय सहने के लिए जन्म नहीं दिया है।
            साथ ही वे 'परन्तप' (शत्रुओं को रुलाने वाला) कहकर संबोधित करते हैं, ताकि अर्जुन को उनकी अपनी वास्तविक अजेय शक्ति की याद आ जाए।
            परमात्मा का यह आदेश है कि जीवन में जब भी कर्तव्य सामने हो, तो भावुकता और हृदय की दुर्बलता को छोड़कर दृढ़ता से खड़े होना चाहिए।
            सच्चा धर्म हमें कमजोर या पलायनवादी नहीं बनाता, बल्कि वह हमें हमारे सबसे बड़े डरों का सामना करने का साहस देता है।
        """.trimIndent(),
        english = """
            O son of Pritha (Partha)! Do not yield to this degrading impotence (cowardice); it absolutely does not befit a great hero like you.
            O chastiser of enemies (Parantapa)! Immediately give up this petty, wretched weakness of heart and arise to fight.
            Lord Sri Krishna is deliberately using extremely harsh, shocking, and psychologically jarring language here to snap Arjuna out of his illusion.
            He challenges the greatest Kshatriya in the universe by using the word 'Klaibyam' (impotence or unmanliness) to forcefully awaken Arjuna's dormant self-respect.
            Krishna knows perfectly well that Arjuna's current state is not born of true spiritual compassion, but from a deep psychological fear and material attachment.
            Therefore, He bluntly calls it 'Kshudram hridaya-daurbalyam', meaning this is not some grand spiritual renunciation, but an extremely base and petty weakness of the heart.
            He calls Arjuna 'Partha' (son of Kunti) to remind him that his noble mother did not give birth to him to silently tolerate terrible injustice.
            He also addresses him as 'Parantapa' (chastiser of foes), intending to sharply remind Arjuna of his own actual, invincible martial prowess.
            The Supreme Lord's ultimate command is that whenever duty calls in life, one must completely discard emotional sentimentality and weakness, and stand firm.
            True dharma does not make us weak or escapist; rather, it gives us the immense courage to face our absolute deepest fears head-on.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            अर्जुन उवाच |
            कथं भीष्ममहं सङ्ख्ये द्रोणं च मधुसूदन |
            इषुभिः प्रतियोत्स्यामि पूजार्हावरिसूदन || ४ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने कहा: हे मधुसूदन! हे शत्रुओं को मारने वाले (अरिसूदन)! मैं इस युद्धभूमि में भीष्म पितामह और गुरु द्रोणाचार्य के विरुद्ध कैसे लड़ूंगा?
            वे दोनों ही मेरे द्वारा बाणों से प्रहार किए जाने योग्य नहीं हैं, बल्कि वे तो मेरे द्वारा सदैव पूजा करने (पूजार्हौ) के ही योग्य हैं।
            श्रीकृष्ण की कठोर फटकार सुनने के बाद भी अर्जुन का मोह तुरंत दूर नहीं होता; वे अपने बचाव में सबसे मजबूत तर्क प्रस्तुत करते हैं।
            अर्जुन भारतीय संस्कृति के उस मूल सिद्धांत को सामने रखते हैं जहाँ गुरु और पितामह का स्थान साक्षात ईश्वर के समान माना गया है।
            वे पूछते हैं कि जिन भीष्म पितामह की गोद में मैं खेला हूँ और जिन द्रोण ने मुझे धनुष पकड़ना सिखाया है, उन पर मैं बाण कैसे चला सकता हूँ?
            जिनके चरणों में मुझे श्रद्धा से फूल चढ़ाने चाहिए, उनकी छाती पर मैं तीरों की वर्षा कैसे कर सकता हूँ?
            यह अर्जुन का कोई बहाना नहीं है, बल्कि यह उनका एक अत्यंत सच्चा और गहरा नैतिक संकट (Moral Dilemma) है।
            वे श्रीकृष्ण को 'अरिसूदन' (शत्रुओं का वध करने वाले) कहकर एक सूक्ष्म संकेत भी दे रहे हैं।
            अर्जुन मानो कह रहे हों कि "हे कृष्ण! आप शत्रुओं को मारते हैं, यह ठीक है, लेकिन मेरे सामने शत्रु नहीं, मेरे श्रद्धेय गुरु और पितामह खड़े हैं।"
            यह श्लोक उस आंतरिक संघर्ष को दर्शाता है जब इंसान के सामने उसका व्यक्तिगत प्रेम और उसका सामाजिक कर्तव्य आमने-सामने आ टकराते हैं।
        """.trimIndent(),
        english = """
            Arjuna said: O Madhusudana! O killer of enemies (Arisudana)! How can I possibly counterattack men like Bhishma and Drona with arrows on this battlefield?
            Both of them are absolutely not meant to be struck by weapons; rather, they are entirely worthy of my deepest worship and reverence (Pujarhau).
            Even after hearing Sri Krishna's severe rebuke, Arjuna's profound illusion does not vanish immediately; he presents his strongest counter-argument in defense.
            Arjuna brings forward the core, fundamental principle of Indian culture where the position of a teacher and a grandfather is considered equal to God.
            He desperately asks how he can possibly shoot arrows at Grandsire Bhishma, in whose lap he played, and Drona, who taught him how to hold a bow.
            How can he rain deadly arrows upon the very chests of those at whose feet he should respectfully be offering flowers?
            This is not a mere cowardly excuse from Arjuna, but an extremely genuine, agonizing, and deep-rooted moral dilemma.
            He addresses Krishna as 'Arisudana' (killer of enemies), subtly throwing a psychological hint towards the Lord.
            It is as if Arjuna is saying, "O Krishna! You kill your enemies, which is fine, but standing before me are not my enemies, but my highly revered elders."
            This verse perfectly illustrates the horrific internal conflict that occurs when a person's localized, personal love violently collides with their supreme social duty.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            गुरूनहत्वा हि महानुभावान् श्रेयो भोक्तुं भैक्ष्यमपीह लोके |
            हत्वार्थकामांस्तु गुरूनिहैव भुञ्जीय भोगान् रुधिरप्रदिग्धान् || ५ ||
        """.trimIndent(),
        hindi = """
            इन महानुभाव गुरुजनों को न मारकर इस संसार में भीख मांगकर खाना भी मैं अपने लिए कहीं अधिक कल्याणकारी (श्रेयकर) समझता हूँ।
            क्योंकि यदि मैं इन गुरुजनों को मार भी दूँ, तो भी इस संसार में धन और संपत्ति की कामना वाले जिन सुखों को मैं भोगूँगा, वे सब उनके खून से सने हुए ही तो होंगे।
            अर्जुन अपने वैराग्य को और अधिक गहरा करते हुए एक बहुत बड़ा और चरम निर्णय सुना रहे हैं।
            एक क्षत्रिय के लिए भीख मांगना सबसे बड़ा अपमान और निंदनीय कार्य माना जाता है, जो मृत्यु से भी बदतर है।
            लेकिन अर्जुन कह रहे हैं कि उन्हें भीख का वह अपमानजनक अन्न खाना मंजूर है, बजाय इसके कि वे अपने गुरुओं के खून से सना हुआ राजसी भोजन करें।
            अर्जुन मानते हैं कि यद्यपि द्रोण और भीष्म जैसे गुरु दुर्योधन के 'अर्थ' (धन) के अधीन होकर इस युद्ध में आए हैं, फिर भी वे 'महानुभाव' (महान) हैं।
            अर्जुन का तर्क है कि ऐसा सिंहासन जो मेरे अपनों की लाशों पर टिका हो, वह मुझे कभी भी मानसिक शांति या वास्तविक सुख नहीं दे सकता।
            यहाँ अर्जुन का दृष्टिकोण पूरी तरह से भौतिक और भावनात्मक है; वे शरीर के स्तर पर सोच रहे हैं, आत्मा या उच्चतर धर्म के स्तर पर नहीं।
            वे यह नहीं समझ पा रहे हैं कि जब महान गुरु भी अन्याय का साथ देने लगें, तो धर्म की रक्षा के लिए उनका वध करना भी एक न्यायपूर्ण कृत्य बन जाता है।
            अर्जुन की यह सोच उस अज्ञान को दर्शाती है जहाँ इंसान पापियों के প্রতি झूठी दया दिखाकर स्वयं एक बड़ा सामाजिक पाप करने को तैयार हो जाता है।
        """.trimIndent(),
        english = """
            It would be far better and more auspicious (shreya) for me to live in this world by begging, rather than to live by killing such great souls as my teachers.
            For even if I do kill these superiors, whatever worldly wealth, desires, and pleasures I enjoy in this world will be forever tainted and smeared with their red blood.
            Deepening his sense of false renunciation, Arjuna is now announcing a massive, extreme, and highly dramatic decision.
            For a noble Kshatriya, begging is considered the absolute greatest insult and the most condemnable act, far worse than actual death itself.
            But Arjuna claims that he is perfectly willing to eat the humiliating food of a beggar rather than enjoy a royal feast smeared with the blood of his beloved teachers.
            Arjuna acknowledges that although elders like Drona and Bhishma have sided with Duryodhana due to financial obligations ('artha'), they remain 'great souls'.
            Arjuna's logic is that a royal throne built upon the slaughtered corpses of his own people can absolutely never grant him any mental peace or true happiness.
            Here, Arjuna's entire perspective is completely materialistic and emotional; he is thinking solely on the bodily platform, not on the level of the soul or supreme dharma.
            He completely fails to understand that when even great teachers choose to support terrible injustice, executing them to protect dharma becomes a perfectly righteous act.
            This mindset of Arjuna highlights the dangerous ignorance where a person becomes ready to commit a massive social sin by showing false mercy to supporters of tyranny.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            न चैतद्विद्मः कतरन्नो गरीयो यद्वा जयेम यदि वा नो जयेयुः |
            यानेव हत्वा न जिजीविषामस् तेऽवस्थिताः प्रमुखे धार्तराष्ट्राः || ६ ||
        """.trimIndent(),
        hindi = """
            हम तो यह भी ठीक से नहीं जानते कि हमारे लिए दोनों में से क्या श्रेष्ठ है—युद्ध करना या न करना; और यह भी नहीं जानते कि हम उन्हें जीतेंगे या वे हमें जीतेंगे।
            अरे! जिन्हें मारकर हम स्वयं ही जीवित नहीं रहना चाहते, वे ही धृतराष्ट्र के पुत्र हमारे बिल्कुल सामने युद्ध के लिए खड़े हैं।
            अर्जुन के मन का द्वंद्व (Dilemma) अब पूरी तरह से उन्हें पंगु (Paralyze) कर चुका है। उनका विवेक पूरी तरह से काम करना बंद कर चुका है।
            वे स्पष्ट रूप से भगवान के सामने अपनी घोर मानसिक उलझन (Confusion) स्वीकार कर रहे हैं कि वे सही और गलत का निर्णय नहीं कर पा रहे हैं।
            अर्जुन कह रहे हैं कि युद्ध का परिणाम भी अनिश्चित है; जीत हमारी भी हो सकती है और हम हार भी सकते हैं।
            लेकिन सबसे बड़ी विडंबना यह है कि यदि हम जीत भी गए, तो यह जीत हमारी सबसे बड़ी हार होगी।
            क्योंकि जिन्हें मारकर हमें वह राजसिंहासन मिलेगा, वे वही लोग हैं जिनके बिना हम एक पल भी जीवित रहने की कल्पना नहीं कर सकते।
            'यानेव हत्वा न जिजीविषामस्'—यह वाक्य अर्जुन के गहरे डिप्रेशन को दर्शाता है, जहाँ जीतने के बाद का जीवन उन्हें मृत्यु से भी अधिक भयानक लग रहा है।
            जब इंसान का मोह चरम पर होता है, तो वह हर स्थिति में केवल अपना ही नुकसान देखता है, और इसी कारण वह कर्म (Action) करने से पूरी तरह रुक जाता है।
        """.trimIndent(),
        english = """
            Nor do we actually know which is better for us—whether to fight them or not to fight; or whether we shall conquer them, or they will conquer us.
            Alas! Those very sons of Dhritarashtra, after killing whom we would not even wish to live a single day, are standing right here before us on this battlefield.
            The massive internal dilemma in Arjuna's mind has now completely paralyzed his ability to act. His rational conscience has totally stopped functioning.
            He explicitly and openly confesses his extreme mental confusion to the Lord, admitting that he is entirely unable to decide between what is right and what is wrong.
            Arjuna states that the final outcome of the war is also uncertain; we might achieve victory, or we might be completely destroyed by them.
            But the greatest and most agonizing irony is that even if we do win, that victory will practically be our most devastating defeat.
            Because the people we must slaughter to attain that royal throne are the very exact people without whom we cannot imagine living for even a moment.
            'Yaneva hatva na jijivishamas'—this specific sentence perfectly illustrates Arjuna's deep depression, where life after victory appears far more terrifying to him than actual death.
            When a person's attachment reaches its absolute peak, they only see massive loss in every possible scenario, which causes them to completely halt all purposeful action.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            कार्पण्यदोषोपहतस्वभावः पृच्छामि त्वां धर्मसम्मूढचेताः |
            यच्छ्रेयः स्यान्निश्चितं ब्रूहि तन्मे शिष्यस्तेऽहं शाधि मां त्वां प्रपन्नम् || ७ ||
        """.trimIndent(),
        hindi = """
            कायरता (कार्पण्य) रूपी दोष के कारण मेरा स्वाभाविक क्षत्रिय स्वभाव पूरी तरह नष्ट हो गया है, और मेरा मन धर्म के विषय में बुरी तरह मोहित (सम्मूढ) हो गया है।
            इसलिए मैं आपसे पूछता हूँ कि जो निश्चित रूप से मेरे लिए परम कल्याणकारी (श्रेय) हो, वही मुझे बताइए।
            अब मैं आपका शिष्य हूँ, और पूरी तरह से आपकी शरण में हूँ; कृपया मुझे उचित उपदेश (शिक्षा) दीजिए।
            यह पूरी भगवद्गीता का सबसे महत्वपूर्ण और निर्णायक 'टर्निंग पॉइंट' (Turning Point) है। यहीं से अर्जुन का अहंकार टूटता है और समर्पण शुरू होता है।
            अर्जुन अंततः यह स्वीकार कर लेते हैं कि वे जिस वैराग्य की बातें कर रहे थे, वह वास्तव में उनकी 'कायरता' (कार्पण्य दोष) है।
            वे मानते हैं कि उनका क्षत्रिय स्वभाव (निडरता) इस समय पूरी तरह से नष्ट हो चुका है और वे सही धर्म (कर्तव्य) का निर्णय करने में पूरी तरह असमर्थ हैं।
            जब तक इंसान यह मानता है कि वह सब कुछ जानता है, तब तक भगवान उसे ज्ञान नहीं देते। अर्जुन ने अपने सारे तर्कों को त्याग कर अपनी अज्ञानता स्वीकार कर ली है।
            वे अब श्रीकृष्ण को अपना केवल एक मित्र या सारथी नहीं मान रहे हैं, बल्कि उन्होंने स्वयं को आधिकारिक रूप से श्रीकृष्ण का 'शिष्य' घोषित कर दिया है।
            'शाधि मां त्वां प्रपन्नम्' (मैं आपकी शरण में हूँ, मुझे शिक्षा दें)—यह वह अंतिम कुंजी है जिससे गीता के दिव्य ज्ञान का दरवाजा खुलता है।
            सच्चा ज्ञान तभी प्राप्त होता है जब साधक अपने सारे बौद्धिक अहंकार को छोड़कर एक योग्य गुरु के चरणों में पूर्ण रूप से समर्पण कर देता है।
        """.trimIndent(),
        english = """
            My natural Kshatriya disposition has been completely destroyed by the fault of cowardice (Karpanya), and my mind is totally bewildered regarding my true duty (Dharma).
            Therefore, I now ask You to clearly tell me what is absolutely and definitely the most beneficial (Shreya) path for me.
            I am now officially Your disciple, and a soul fully surrendered unto You; please instruct and guide me.
            This is arguably the most critical and decisive 'Turning Point' of the entire Bhagavad Gita. This is exactly where Arjuna's ego shatters and true surrender begins.
            Arjuna finally and honestly admits that all the grand renunciation he was preaching was actually just his 'cowardice' (Karpanya dosha) in disguise.
            He openly confesses that his natural martial courage is entirely ruined right now, and he is completely incapable of determining his righteous duty.
            As long as a human being arrogantly thinks he knows everything, God never grants him true wisdom. Arjuna has dropped all his false logic and admitted his total ignorance.
            He is no longer treating Sri Krishna merely as a dear friend or a lowly charioteer; he has officially declared himself as Krishna's completely submissive 'disciple'.
            'Shadhi mam tvam prapannam' (I am surrendered to You, please instruct me)—this is the ultimate master key that unlocks the door to the Gita's divine, transcendental knowledge.
            Absolute, supreme wisdom is only received when a seeker completely abandons all intellectual arrogance and unreservedly surrenders at the lotus feet of a bonafide spiritual master.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            न हि प्रपश्यामि ममापनुद्याद् यच्छोकमुच्छोषणमिन्द्रियाणाम् |
            अवाप्य भूमावसपत्नमृद्धं राज्यं सुराणामपि चाधिपत्यम् || ८ ||
        """.trimIndent(),
        hindi = """
            क्योंकि इस पृथ्वी पर शत्रुओं से रहित (असपत्नम्), धन-धान्य से संपन्न पूरा राज्य प्राप्त कर लेने पर भी...
            अथवा देवताओं के स्वर्ग का आधिपत्य (राज्याधिकार) मिल जाने पर भी, मुझे ऐसा कोई उपाय नहीं दिखता...
            जो मेरी इन्द्रियों को पूरी तरह सुखा देने वाले इस भयंकर शोक (दुःख) को दूर कर सके।
            अर्जुन यहाँ अपने मानसिक अवसाद (Depression) की असीमित गहराई को व्यक्त कर रहे हैं, जिसका कोई भौतिक समाधान संभव नहीं है।
            वे कहते हैं कि यदि यह युद्ध जीतकर उन्हें पूरी पृथ्वी का एकछत्र, बिना किसी दुश्मन वाला राज्य मिल भी जाए, तो भी वे खुश नहीं हो सकते।
            यहाँ तक कि यदि उन्हें देवताओं के राजा इंद्र का स्वर्ग का सिंहासन भी दे दिया जाए, तो भी उनका यह मानसिक संताप दूर नहीं होगा।
            अर्जुन का यह शोक इतना भयंकर है कि वह उनकी 'इन्द्रियों को सुखा रहा है' (उच्छोषणमिन्द्रियाणाम्), अर्थात् उनकी शारीरिक और मानसिक शक्ति को पूरी तरह निचोड़ रहा है।
            यह श्लोक इस शाश्वत सत्य को प्रमाणित करता है कि जब मन के भीतर गहरा अज्ञान, अपराधबोध और शोक बैठ जाता है, तो दुनिया की कोई भी बाहरी भौतिक संपत्ति उसे शांत नहीं कर सकती।
            पैसा, सत्ता, और सिंहासन कभी भी आत्मा के दर्द की दवा नहीं हो सकते। अर्जुन समझ चुके हैं कि अब उन्हें किसी मनोवैज्ञानिक सांत्वना की नहीं, बल्कि एक गहरे आध्यात्मिक ज्ञान की आवश्यकता है।
            इसी गहरी प्यास के कारण वे भगवान के सामने पूरी तरह असहाय होकर एक शिष्य के रूप में शरणागत हुए हैं।
        """.trimIndent(),
        english = """
            Because even if I were to obtain an entirely unrivaled, extremely prosperous kingdom on this earth without any enemies...
            or even if I were to attain the supreme sovereignty over the celestial gods in heaven, I absolutely do not see any means...
            that can possibly drive away this terrifying grief that is completely drying up my senses.
            Arjuna is expressing the limitless, unfathomable depth of his severe clinical depression here, for which absolutely no material or worldly solution is possible.
            He states that even if he wins this war and is granted the undisputed, enemy-free rulership of the entire earth, he still cannot find happiness.
            Even if he were to be handed the supreme celestial throne of Lord Indra in heaven, his deep, burning mental anguish would remain completely uncured.
            Arjuna's grief is so terrifyingly intense that it is 'drying up his senses' (ucchhoshanam-indriyanam), meaning it is violently draining away all his physical vitality and mental sanity.
            This verse perfectly authenticates the eternal truth that when deep ignorance, guilt, and grief settle inside the mind, no external material wealth in the universe can pacify it.
            Money, political power, and royal thrones can absolutely never act as medicine for the agonizing pain of the soul. Arjuna realizes he needs deep spiritual enlightenment, not psychological comfort.
            It is exactly because of this intense, burning thirst that he has surrendered completely helplessly as a disciple before the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            सञ्जय उवाच |
            एवमुक्त्वा हृषीकेशं गुडाकेशः परन्तप |
            न योत्स्य इति गोविन्दमुक्त्वा तूष्णीं बभूव ह || ९ ||
        """.trimIndent(),
        hindi = """
            संजय ने कहा: हे शत्रुओं को ताप देने वाले राजा धृतराष्ट्र! निद्रा को जीतने वाले अर्जुन (गुडाकेश) ने अंतर्यामी भगवान श्रीकृष्ण (हृषीकेश) से इस प्रकार कहकर...
            अंत में यह स्पष्ट रूप से कह दिया कि "हे गोविन्द! मैं युद्ध नहीं करूँगा" (न योत्स्य) और ऐसा कहकर वे पूरी तरह से चुप हो गए।
            यह श्लोक अर्जुन के उस भयंकर मानसिक द्वंद्व का अंतिम और पूर्ण विराम है। उन्होंने अपना अंतिम निर्णय सुना दिया है।
            अर्जुन, जिन्होंने अभी-अभी श्रीकृष्ण को अपना गुरु माना था और उनसे मार्गदर्शन मांगा था, वे ही अर्जुन अगले ही पल गुरु का उपदेश सुने बिना ही अपना फैसला सुना रहे हैं।
            "मैं युद्ध नहीं करूँगा" यह वाक्य उनके भीतर बैठे उस जिद्दी अज्ञान और मोह को दर्शाता है जो आसानी से जाने वाला नहीं है।
            संजय यहाँ जानबूझकर अर्जुन के लिए 'गुडाकेश' (नींद को जीतने वाला) और 'परन्तप' (शत्रुओं को जलाने वाला) शब्दों का प्रयोग करते हैं।
            यह एक बहुत बड़ा व्यंग्य है कि जो अर्जुन अजेय है और जिसने आलस्य को जीत लिया है, वह आज मोह की नींद में इतनी गहरी तरह सो गया है कि कर्तव्य से भाग रहा है।
            अर्जुन का यह 'चुप हो जाना' (तूष्णीं बभूव) वास्तव में गीता के उस महान ज्ञान के प्रकट होने के लिए एक शांत पृष्ठभूमि (Canvass) तैयार कर रहा है।
            जब एक शिष्य अपने सारे अहंकार और तर्कों से थक कर पूरी तरह शांत हो जाता है, तभी गुरु (परमात्मा) बोलना शुरू करते हैं।
        """.trimIndent(),
        english = """
            Sanjaya said: O King, chastiser of enemies! Having spoken thus to the indwelling Lord Krishna (Hrishikesha), Arjuna, the conqueror of sleep (Gudakesha)...
            finally declared very explicitly to Govinda, "I shall absolutely not fight" (Na yotsya), and having said this, he became completely silent.
            This verse is the absolute final full stop to Arjuna's terrifying mental dilemma. He has pronounced his ultimate, stubborn decision.
            Arjuna, who just a moment ago accepted Sri Krishna as his Guru and begged for guidance, is now issuing his own final verdict without even waiting to hear the Guru's teachings.
            The defiant statement "I shall not fight" perfectly reflects the incredibly stubborn ignorance and deep attachment sitting within him, which will not leave easily.
            Sanjaya intentionally uses the adjectives 'Gudakesha' (conqueror of sleep) and 'Parantapa' (chastiser of enemies) for Arjuna here.
            It is a massive, striking irony that the invincible Arjuna, who conquered physical sleep, is today sleeping so deeply in the slumber of illusion that he is running from his duty.
            Arjuna's 'becoming completely silent' (Tushnim babhuva) is actually preparing the perfectly quiet, blank canvas for the manifestation of the Gita's supreme knowledge.
            It is only when a disciple becomes totally exhausted by his own ego and false logic, and falls completely silent, that the Guru (the Supreme Lord) finally begins to speak.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            तमुवाच हृषीकेशः प्रहसन्निव भारत |
            सेनयोरुभयोर्मध्ये विषीदन्तमिदं वचः || १० ||
        """.trimIndent(),
        hindi = """
            हे भरतवंशी धृतराष्ट्र! तब दोनों सेनाओं के ठीक मध्य में, उस अत्यंत गहरे शोक में डूबे हुए अर्जुन को देखकर...
            भगवान श्रीकृष्ण (हृषीकेश) ने मानो मुस्कुराते हुए (प्रहसन्निव) ये अत्यंत महत्वपूर्ण और गंभीर वचन कहे।
            यहाँ से साक्षात् परमेश्वर का वह महान उपदेश शुरू होता है जिसने पूरी मानव जाति के लिए आध्यात्मिक ज्ञान के दरवाजे खोल दिए।
            एक तरफ अर्जुन हैं, जो अज्ञान के कारण गहरे अवसाद (डिप्रेशन) में डूबकर रो रहे हैं और काँप रहे हैं।
            दूसरी तरफ भगवान श्रीकृष्ण हैं, जो इस भयंकर युद्ध के बीच में और अर्जुन की इस दयनीय स्थिति को देखकर भी 'मुस्कुरा' रहे हैं।
            भगवान की यह मुस्कान किसी का उपहास नहीं है; यह एक पिता की उस मुस्कान के समान है जो अपने डरे हुए बच्चे को देखकर मुस्कुराता है।
            भगवान जानते हैं कि अर्जुन का यह सारा डर, दुःख और मोह बिल्कुल झूठा और अवास्तविक है, यह केवल अज्ञान के कारण पैदा हुआ एक भ्रम है।
            श्रीकृष्ण अर्जुन की स्थिति को लेकर बिल्कुल भी चिंतित या घबराए हुए नहीं हैं, क्योंकि वे स्वयं 'हृषीकेश' (मन और इन्द्रियों के परम नियंत्रक) हैं।
            वे मुस्कुरा रहे हैं क्योंकि वे जानते हैं कि ज्ञान की एक छोटी सी चिंगारी अर्जुन के इस विशाल अज्ञान रूपी अंधेरे को पल भर में जलाकर भस्म कर देगी।
        """.trimIndent(),
        english = """
            O descendant of Bharata (Dhritarashtra)! Then, situated exactly in the midst of both the armies, seeing Arjuna completely drowning in deep grief...
            Lord Krishna (Hrishikesha), seemingly smiling with great affection (Prahasanniva), spoke these highly profound and significant words to him.
            From this exact moment begins the supreme, transcendental discourse of the Supreme Lord that opened the doors of eternal spiritual wisdom for all mankind.
            On one side is Arjuna, who is violently weeping, trembling, and drowning in severe clinical depression due to utter ignorance.
            On the other side is Lord Sri Krishna, who, despite being in the middle of a terrifying world war and seeing Arjuna's pathetic state, is simply 'smiling'.
            The Lord's gentle smile is absolutely not a mockery; it is exactly like the comforting smile of a loving father watching his unnecessarily terrified child.
            The Lord knows perfectly well that all of Arjuna's intense fear, grief, and attachment are completely false and unreal; they are mere illusions born of ignorance.
            Sri Krishna is not in the least bit worried or panicked by Arjuna's breakdown, because He Himself is 'Hrishikesha' (the supreme controller of all minds and senses).
            He smiles confidently because He knows that just a tiny, single spark of eternal spiritual knowledge will effortlessly burn down this massive darkness of Arjuna's ignorance in an instant.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            श्रीभगवानुवाच |
            अशोच्यानन्वशोचस्त्वं प्रज्ञावादांश्च भाषसे |
            गतासूनगतासूंश्च नानुशोचन्ति पण्डिताः || ११ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: तुम उन लोगों के लिए शोक कर रहे हो जो बिल्कुल भी शोक करने योग्य नहीं हैं, और फिर भी तुम किसी बड़े विद्वान (पंडित) की तरह बड़ी-बड़ी ज्ञान की बातें कर रहे हो!
            परंतु जो वास्तव में ज्ञानी (पंडित) होते हैं, वे न तो मरे हुए लोगों के लिए (गतासून्) और न ही जीवित लोगों के लिए (अगतासून्) कभी शोक करते हैं।
            यह श्लोक भगवद्गीता के महान आध्यात्मिक उपदेश का सबसे पहला और अत्यंत मारक प्रहार है।
            भगवान अर्जुन की बीमारी (मोह) की जड़ पर सीधा प्रहार करते हुए उनके झूठे अहंकार को तोड़ते हैं।
            वे कहते हैं कि अर्जुन की बातें तो बहुत ऊँची-ऊँची और शास्त्र-सम्मत (समाज और कुलधर्म) लग रही हैं, लेकिन उनका आचरण एक मूर्ख और अज्ञानी व्यक्ति जैसा है।
            सच्चा ज्ञान यह नहीं है कि हम बड़े-बड़े श्लोक बोलें; सच्चा ज्ञान वह है जो हमारे आचरण और मन की शांति में दिखाई दे।
            श्रीकृष्ण स्पष्ट करते हैं कि जो लोग शरीर को ही सब कुछ मानते हैं, वे हमेशा मृत्यु के डर से रोते हैं।
            लेकिन जो सच्चा 'पंडित' (तत्वज्ञानी) है, वह जानता है कि शरीर तो वैसे भी मरने वाला है (चाहे आज या कल), और आत्मा कभी मरती नहीं।
            इसलिए एक ज्ञानी व्यक्ति कभी भी शरीर के जन्मने या मरने पर आँसू नहीं बहाता, क्योंकि वह जीवन और मृत्यु के इस झूठे खेल की असलियत को समझता है।
            यहीं से भगवान गीता के सबसे मुख्य सिद्धांत—शरीर और आत्मा के अंतर—की नींव रखते हैं।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead said: You are deeply mourning for those who are absolutely not worthy of any grief, yet you speak highly philosophical words like a great, learned scholar!
            However, those who are truly wise and actually learned (Panditas) never lament either for the dead (whose breath is gone) or for the living (whose breath remains).
            This specific verse is the very first and incredibly lethal, direct strike of the great spiritual discourse of the Bhagavad Gita.
            The Lord attacks the absolute root cause of Arjuna's disease (illusion) directly, violently shattering his false intellectual ego.
            He points out that while Arjuna's words sound extremely lofty, moral, and scriptural, his actual behavior is completely that of a foolish, ignorant man.
            True spiritual knowledge is not simply quoting big verses; true wisdom must clearly reflect in one's personal conduct and absolute peace of mind.
            Sri Krishna clarifies that those who wrongly consider the temporary physical body to be everything will always cry in the terrible fear of death.
            But a true 'Pandita' (knower of the Absolute Truth) knows that the physical body is destined to die anyway (whether today or tomorrow), and the soul never ever dies.
            Therefore, a truly enlightened person never sheds tears over the birth or death of the physical body, as he perfectly understands the reality behind this false play of life and death.
            Exactly from this point, the Lord lays the supreme foundational principle of the Gita—the fundamental difference between the temporary body and the eternal soul.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            न त्वेवाहं जातु नासं न त्वं नेमे जनाधिपाः |
            न चैव न भविष्यामः सर्वे वयमतः परम् || १२ ||
        """.trimIndent(),
        hindi = """
            ऐसा बिल्कुल भी नहीं है कि किसी काल (समय) में मैं नहीं था, या तुम नहीं थे, अथवा ये सामने खड़े सभी राजा लोग नहीं थे।
            और ऐसा भी बिल्कुल नहीं है कि भविष्य में हम सब नहीं रहेंगे; अर्थात् हम सभी (आत्मा रूप में) हमेशा थे और हमेशा रहेंगे।
            यह श्लोक सनातन धर्म के सबसे महान और गूढ़ सत्य—आत्मा की अमरता और उसके व्यक्तिगत अस्तित्व—की स्पष्ट घोषणा है।
            भगवान अर्जुन के इस डर को दूर कर रहे हैं कि मृत्यु के बाद सब कुछ खत्म हो जाता है।
            वे स्पष्ट करते हैं कि शरीर भले ही नष्ट हो जाए, लेकिन 'मैं' (परमात्मा), 'तुम' (जीवात्मा अर्जुन), और ये सभी राजा (अन्य जीवात्माएं) अनादि काल से मौजूद हैं।
            हमारा अस्तित्व इस शरीर के जन्म के साथ शुरू नहीं हुआ है, और इस शरीर की मृत्यु के साथ खत्म भी नहीं होगा।
            श्रीकृष्ण यहाँ अद्वैतवाद के उस सिद्धांत का भी सूक्ष्म खंडन कर रहे हैं जो कहता है कि मुक्ति के बाद सभी आत्माएं अपना वजूद खोकर ईश्वर में मिल जाती हैं।
            भगवान बहुत स्पष्ट शब्दों में 'मैं', 'तुम' और 'ये सभी' (बहुवचन) का प्रयोग करते हैं, जो यह सिद्ध करता है कि प्रत्येक आत्मा का अपना एक स्वतंत्र और अमर अस्तित्व है।
            यह ज्ञान मृत्यु के भय को पूरी तरह से समाप्त कर देता है, क्योंकि जो जन्मता ही नहीं, वह मर कैसे सकता है?
            अर्जुन का शोक केवल इस बात पर था कि ये लोग 'मर जाएंगे', भगवान सिद्ध कर रहे हैं कि ये कभी 'मर ही नहीं सकते'।
        """.trimIndent(),
        english = """
            Never was there a time when I did not exist, nor you, nor all these kings standing before us.
            And never in the future shall any of us ever cease to exist; meaning, we all (as souls) have always existed and shall always exist eternally.
            This verse is the absolute, supreme, and clearest declaration of Sanatana Dharma's most profound truth—the immortality and individual eternal existence of the soul.
            The Lord is completely uprooting Arjuna's fundamental fear that everything ends with physical death.
            He clarifies that while the physical body will undoubtedly perish, 'I' (the Supreme Lord), 'You' (the individual soul Arjuna), and 'These Kings' (other individual souls) have existed since beginningless time.
            Our true existence absolutely did not begin with the birth of this temporary body, nor will it ever end with the death of this body.
            Sri Krishna is also subtly refuting the philosophy which claims that after liberation, all individual souls lose their identity and merge into a formless void.
            The Lord very explicitly uses plural terms like 'I', 'You', and 'All of them', which perfectly proves that every single soul maintains its own independent, eternal individuality.
            This transcendental knowledge completely destroys the terrible fear of death from its root, because how can that which is never born possibly die?
            Arjuna's entire grief was based on the false belief that these people would 'die'; the Lord is proving that they can simply 'never die'.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            देहिनोऽस्मिन्यथा देहे कौमारं यौवनं जरा |
            तथा देहान्तरप्राप्तिर्धीरस्तत्र न मुह्यति || १३ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार इस शरीर में रहने वाली आत्मा (देही) लगातार बचपन, जवानी और बुढ़ापे की अवस्थाओं से गुजरती है...
            ठीक उसी प्रकार मृत्यु के समय यह आत्मा एक शरीर को छोड़कर दूसरे नए शरीर (देहान्तर) को प्राप्त कर लेती है। धीर (बुद्धिमान) पुरुष इस विषय में कभी मोहग्रस्त नहीं होता।
            भगवान श्रीकृष्ण यहाँ पुनर्जन्म (Reincarnation) के अत्यंत जटिल विज्ञान को दुनिया के सबसे सरल और तार्किक उदाहरण से समझा रहे हैं।
            वे कहते हैं कि अर्जुन, तुम अपने ही जीवन को देखो! तुम्हारा बचपन का छोटा शरीर पूरी तरह मर चुका है और उसने युवा शरीर का रूप ले लिया है।
            क्या तुम अपने बचपन के शरीर के मरने पर रोते हो? नहीं, क्योंकि तुम जानते हो कि शरीर बदला है, लेकिन 'तुम' (आत्मा) वही हो।
            उसी तरह, जब यह वर्तमान शरीर बिल्कुल बूढ़ा या अनुपयोगी हो जाता है, तो आत्मा इसे उतारकर एक नया शरीर पहन लेती है।
            मृत्यु कोई भयंकर अंत या विनाश नहीं है; मृत्यु तो आत्मा के लिए केवल एक कपड़े बदलने जैसी सामान्य प्रक्रिया (Transition) है।
            जो व्यक्ति (धीर) इस महान विज्ञान को गहराई से समझ लेता है, वह किसी की मृत्यु पर मूर्खों की तरह छाती नहीं पीटता।
            अर्जुन का दुःख शरीर के नष्ट होने को लेकर है, जबकि भगवान उन्हें समझा रहे हैं कि शरीर तो वैसे भी हर पल बदल (मर) रहा है, तुम व्यर्थ ही रो रहे हो।
        """.trimIndent(),
        english = """
            Just as the embodied soul (Dehi) continuously passes through the states of childhood, youth, and old age within this very body...
            similarly, at the time of death, the soul smoothly passes into and acquires another new body (Dehantara). A sober, intelligent person (Dhira) is never bewildered by such a change.
            Lord Sri Krishna is explaining the highly complex, eternal science of reincarnation here using the absolute simplest and most logical everyday example.
            He is telling Arjuna to simply observe his own life! His small childhood body is completely dead and gone, replaced entirely by a youthful body.
            Do you ever cry mourning the death of your childhood body? No, because you clearly know that the body has changed, but 'You' (the conscious soul) remain exactly the same.
            In the exact same way, when this current physical body becomes completely old or unusable, the soul simply discards it and puts on a fresh new body.
            Death is absolutely not some terrifying, final destruction; death is merely a very normal transition, just like changing a set of old clothes for the soul.
            A self-realized, sober person (Dhira) who deeply understands this great science never weeps foolishly beating his chest over someone's physical passing.
            Arjuna's massive grief is solely focused on the destruction of the body, while the Lord is explaining that the body is already changing (dying) every single second anyway, so his crying is completely useless.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            मात्रास्पर्शास्तु कौन्तेय शीतोष्णसुखदुःखदाः |
            आगमापायिनोऽनित्यास्तांस्तितिक्षस्व भारत || १४ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! इन्द्रियों और उनके विषयों (शब्द, स्पर्श, रूप आदि) का जो संपर्क होता है, वही हमें सर्दी-गर्मी और सुख-दुःख का अनुभव कराता है।
            ये सभी अनुभव आने-जाने वाले (आगमापायिनः) और पूरी तरह से अनित्य (अस्थायी) हैं; इसलिए हे भरतवंशी अर्जुन! तुम इन्हें चुपचाप सहन करना (तितिक्षस्व) सीखो।
            आत्मा की अमरता समझाने के बाद, भगवान अब अर्जुन की दूसरी सबसे बड़ी समस्या—शारीरिक और मानसिक कष्ट—का समाधान कर रहे हैं।
            अर्जुन को युद्ध में अपने गुरुओं और सगे-संबंधियों को मारने के विचार से भयंकर मानसिक कष्ट (दुःख) हो रहा है।
            श्रीकृष्ण बताते हैं कि यह सारा सुख और दुःख वास्तव में कहाँ से आता है; यह हमारी इन्द्रियों (आँख, कान, त्वचा) के बाहरी दुनिया से टकराने का परिणाम है।
            जैसे सर्दी और गर्मी के मौसम आते हैं और चले जाते हैं, वे हमेशा नहीं टिकते, वैसे ही जीवन के सुख और दुःख भी पूरी तरह से अस्थायी (Temporary) हैं।
            पानी छूने में ठंडा है या गर्म, यह केवल त्वचा का अहसास है, आत्मा का इससे कोई लेना-देना नहीं है।
            इसलिए भगवान एक बहुत ही व्यावहारिक आदेश देते हैं—'तांस्तितिक्षस्व' (उन्हें सहन करो)। जीवन में हर दर्द या परेशानी से भागा नहीं जा सकता।
            एक महान योद्धा और योगी वही है जो इन अस्थायी कष्टों और दुःखों से विचलित हुए बिना अपने कर्तव्य-पथ पर अडिग रहता है।
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya)! The non-permanent appearance of happiness and distress, and their disappearance in due course, are like the appearance and disappearance of winter and summer seasons.
            They arise merely from sense perception, O scion of Bharata, and one must learn to tolerate them without being disturbed.
            After deeply explaining the immortality of the soul, the Lord now addresses Arjuna's second biggest problem—his intense physical and mental suffering.
            Arjuna is experiencing horrific mental agony (distress) merely at the thought of having to kill his beloved teachers and relatives in the war.
            Sri Krishna explains exactly where all this worldly happiness and distress actually comes from; it is purely the result of our physical senses (eyes, ears, skin) colliding with external material objects.
            Just as the freezing winter and scorching summer seasons come and inevitably go away, never lasting forever, similarly, all joys and sorrows of life are completely temporary (Anitya).
            Whether water feels cold or hot to the touch is merely a temporary sensation of the physical skin; the eternal soul has absolutely nothing to do with it.
            Therefore, the Lord gives a highly practical and powerful command—'Tans titikshasva' (Learn to tolerate them). One cannot simply run away from every pain or discomfort in life.
            A truly great warrior and yogi is only he who remains absolutely firmly fixed on his path of duty without being shaken by these temporary pains and fleeting sorrows.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            यं हि न व्यथयन्त्येते पुरुषं पुरुषर्षभ |
            समदुःखसुखं धीरं सोऽमृतत्वाय कल्पते || १५ ||
        """.trimIndent(),
        hindi = """
            हे पुरुषों में श्रेष्ठ (पुरुषर्षभ)! जो धीर (बुद्धिमान) मनुष्य इन इन्द्रियों के विषयों (सुख-दुःख) से बिल्कुल भी विचलित (परेशान) नहीं होता...
            और जो सुख तथा दुःख दोनों ही स्थितियों में हमेशा समान (समदुःखसुखं) रहता है, वह मनुष्य निश्चित रूप से अमरत्व (मोक्ष) प्राप्त करने के योग्य हो जाता है।
            पिछले श्लोक में भगवान ने कष्टों को 'सहन करने' को कहा था, और इस श्लोक में वे उस सहनशीलता का परम फल (Result) बता रहे हैं।
            साधारण इंसान थोड़ा सा दुःख आने पर रोने लगता है और थोड़ा सा सुख मिलने पर अहंकार से पागल हो जाता है।
            लेकिन जो व्यक्ति अपनी इन्द्रियों पर विजय प्राप्त कर लेता है, वह निंदा-स्तुति, हार-जीत और सुख-दुःख में एक पहाड़ की तरह अविचल खड़ा रहता है।
            श्रीकृष्ण अर्जुन को 'पुरुषर्षभ' (मनुष्यों में बैल के समान अत्यंत बलवान) कहकर याद दिला रहे हैं कि तुम शारीरिक रूप से तो बलवान हो, अब मानसिक रूप से भी बलवान बनो।
            यहाँ 'अमृतत्वाय' (अमरता) का अर्थ यह नहीं है कि व्यक्ति का शरीर कभी नहीं मरेगा, बल्कि इसका अर्थ है जन्म और मृत्यु के चक्र से हमेशा के लिए आज़ाद हो जाना (मोक्ष)।
            भगवान स्पष्ट करते हैं कि मोक्ष या ईश्वर की प्राप्ति किसी जंगल में भागने से नहीं होती, बल्कि जीवन के द्वंद्वों (Dualities) के बीच समभाव (Balance) बनाए रखने से होती है।
            अर्जुन का यह रोना और युद्ध से भागना उन्हें मोक्ष नहीं, बल्कि पतन की ओर ले जाएगा।
        """.trimIndent(),
        english = """
            O best among men (Purusharshabha)! That highly intelligent, sober person (Dhira) who is absolutely not disturbed by these sensory inputs (happiness and distress)...
            and who remains completely steady and equal in both joy and sorrow (Sama-duhkha-sukham), certainly becomes fully eligible for liberation (Immortality/Moksha).
            In the previous verse, the Lord commanded Arjuna to 'tolerate' difficulties, and in this verse, He reveals the supreme, ultimate reward for that tolerance.
            An ordinary human being starts crying bitterly at the slightest sorrow and goes completely mad with arrogance at the slightest taste of happiness.
            But a self-realized person who has conquered his senses stands as unshakable as a massive mountain through insult-praise, victory-defeat, and joy-sorrow.
            Sri Krishna addresses Arjuna as 'Purusharshabha' (the strongest bull among men) to remind him: you are immensely strong physically, now become equally strong mentally.
            Here, 'Amritatvaya' (Immortality) absolutely does not mean that the physical body will never die; rather, it means achieving permanent liberation (Moksha) from the endless cycle of birth and death.
            The Lord makes it brilliantly clear that Moksha or God-realization is not achieved by running away to a forest, but by maintaining perfect equanimity (balance) amidst the dualities of life.
            Arjuna's current crying and his cowardly desire to flee the war will not lead him to liberation, but to severe spiritual downfall.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            नासतो विद्यते भावो नाभावो विद्यते सतः |
            उभयोरपि दृष्टोऽन्तस्त्वनयोस्तत्त्वदर्शिभिः || १६ ||
        """.trimIndent(),
        hindi = """
            जो असत् (झूठा या अस्थायी) है, उसका कभी भी कोई स्थायी अस्तित्व (भाव) नहीं होता; और जो सत् (सच्चा या नित्य) है, उसका कभी भी अभाव (विनाश) नहीं होता।
            इन दोनों (सत् और असत्) का यह अंतिम सत्य और रहस्य तत्त्वज्ञानियों (परम सत्य को देखने वालों) द्वारा बहुत अच्छी तरह से देखा और समझा गया है।
            यह श्लोक वेदान्त दर्शन का एक अत्यंत ही महत्वपूर्ण और आधारभूत नियम (Fundamental Rule) है, जो पूरी दुनिया की वास्तविकता को स्पष्ट करता है।
            यहाँ 'असत्' का अर्थ है भौतिक शरीर और यह सारा दिखाई देने वाला संसार। यह असत् है क्योंकि यह हर पल बदल रहा है और एक दिन नष्ट हो जाएगा।
            'सत्' का अर्थ है वह अमर आत्मा और परमात्मा, जो कभी नहीं बदलते, जो हमेशा एक रस रहते हैं और जिन्हें कोई मार नहीं सकता।
            भगवान अर्जुन से कह रहे हैं कि तुम जिन शरीरों (भीष्म, द्रोण) को बचाने के लिए इतना रो रहे हो, वे तो 'असत्' हैं, वे तो आज नहीं तो कल मिटेंगे ही, उनका मिटना तय है।
            और जो 'सत्' (आत्मा) है, उसे तुम अपने तीरों से चाहकर भी नहीं मार सकते, क्योंकि सत्य का कभी विनाश हो ही नहीं सकता।
            जो महापुरुष (तत्त्वदर्शी) इस सत्य को जान लेते हैं, वे असत् (शरीर) के छूटने का कभी शोक नहीं करते।
            अर्जुन का पूरा डिप्रेशन इसी बात पर टिका है कि वह 'असत्' को 'सत्' (हमेशा रहने वाला) मान बैठे हैं, और भगवान इसी भ्रम को तोड़ रहे हैं।
        """.trimIndent(),
        english = """
            Those who are seers of the truth have concluded that of the non-existent (Asat - the temporary material body) there is absolutely no endurance or eternal existence.
            And of the existent (Sat - the eternal soul) there is absolutely no cessation or destruction. This ultimate reality of both has been perfectly seen by the seers of truth (Tattva-darshis).
            This verse presents an incredibly profound and fundamental rule of Vedantic philosophy, which perfectly defines the actual reality of the entire universe.
            Here, 'Asat' strictly refers to the physical material body and this entire visible world. It is called Asat because it is constantly changing every second and is destined to be destroyed one day.
            'Sat' refers strictly to the immortal soul and the Supreme Lord, who absolutely never change, remain eternally constant, and can never be killed by anyone.
            The Lord is practically telling Arjuna: the physical bodies (of Bhishma, Drona) that you are crying so bitterly to save are 'Asat'; they are guaranteed to perish today or tomorrow anyway.
            And the 'Sat' (the soul) inside them cannot possibly be killed by you even if you shoot a million arrows, because Truth simply cannot ever be destroyed.
            The great self-realized sages (Tattva-darshis) who have realized this ultimate truth never mourn the inevitable loss of the 'Asat' (the physical body).
            Arjuna's entire severe depression rests purely on the tragic mistake of accepting the 'Asat' as 'Sat' (permanent), and the Lord is surgically destroying this very illusion.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            अविनाशि तु तद्विद्धि येन सर्वमिदं ततम् |
            विनाशमव्ययस्यास्य न कश्चित्कर्तुमर्हति || १७ ||
        """.trimIndent(),
        hindi = """
            परंतु तुम उस तत्त्व को तो पूरी तरह से अविनाशी (कभी नष्ट न होने वाला) जानो, जिससे यह संपूर्ण दृश्य जगत और शरीर व्याप्त (भरा हुआ) है।
            इस कभी न बदलने वाले और कभी न खर्च होने वाले (अव्यय) आत्मा का विनाश करने में कोई भी, बिल्कुल कोई भी, समर्थ नहीं है।
            पिछले श्लोक में भगवान ने 'सत्' (आत्मा) का जिक्र किया था; अब वे उस आत्मा की असीमित और अकल्पनीय शक्ति का स्पष्ट वर्णन कर रहे हैं।
            यहाँ 'येन सर्वमिदं ततम्' का अर्थ है कि चेतना (Consciousness) के रूप में यह आत्मा हमारे पैर के नाखून से लेकर सिर के बाल तक पूरे शरीर में फैली हुई है।
            यह आत्मा शरीर के हर सुख-दुःख को महसूस करती है, लेकिन शरीर के कटने-फटने से यह स्वयं कभी नहीं कटती।
            भगवान एक बहुत बड़ी और अंतिम गारंटी दे रहे हैं कि इस ब्रह्मांड में कोई भी ऐसा हथियार, देवता, राक्षस या स्वयं काल (समय) भी नहीं है जो इस आत्मा को मार सके।
            जब आत्मा को कोई मार ही नहीं सकता, तो फिर अर्जुन का यह सोचना कि "मैं युद्ध में इन्हें मार डालूंगा", उनके भयंकर अज्ञान और झूठे अहंकार का ही सूचक है।
            यह श्लोक अर्जुन के सिर से हत्यारे होने के उस झूठे अपराधबोध (Guilt) को पूरी तरह से उतार फेंकने के लिए कहा गया है।
            व्यक्ति केवल बाहरी शरीर रूपी कपड़े को नष्ट कर सकता है, उसे पहनने वाले को नहीं।
        """.trimIndent(),
        english = """
            But you should know that strictly to be indestructible and imperishable by which this entire visible body is pervaded.
            Absolutely no one is able to cause the destruction of that imperishable (Avyaya), eternal soul.
            In the previous verse, the Lord mentioned the 'Sat' (the eternal soul); now He explicitly and vividly describes the limitless and unimaginable power of that soul.
            Here, 'yena sarvam idam tatam' means that in the form of pure consciousness, this soul completely pervades the entire physical body from the toenails to the hair on the head.
            This soul perceives every single pain and pleasure of the physical body, yet it itself is never cut or wounded when the physical body is hacked to pieces.
            The Lord is giving a massive, ultimate guarantee here that there is absolutely no weapon, demigod, demon, or even Time itself in this entire universe that can kill this soul.
            When it is an established fact that the soul simply cannot be killed by anyone, Arjuna's arrogant thought that "I will kill them in war" is a clear indicator of his profound ignorance and false ego.
            This powerful verse is spoken specifically to completely rip off the false, crushing guilt from Arjuna's mind that he is going to become a murderer.
            A person can merely destroy the external, temporary clothing (the physical body), but never the one who wears it (the soul).
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            अन्तवन्त इमे देहा नित्यस्योक्ताः शरीरिणः |
            अनाशिनोऽप्रमेयस्य तस्माद्युध्यस्व भारत || १८ ||
        """.trimIndent(),
        hindi = """
            इस नित्य (हमेशा रहने वाले), अविनाशी (कभी नष्ट न होने वाले) और अप्रमेय (जिसे मापा न जा सके) आत्मा के...
            ये सभी भौतिक शरीर निश्चित रूप से अंत होने वाले (नाशवान) ही कहे गए हैं। इसलिए हे भरतवंशी अर्जुन! तुम युद्ध करो।
            भगवान श्रीकृष्ण यहाँ शरीर और आत्मा की प्रकृति की तुलना करके एक बहुत ही तार्किक और सीधा निष्कर्ष (Conclusion) निकाल रहे हैं।
            वे आत्मा को तीन विशेषण देते हैं: १. 'नित्य' (यह कल भी थी, आज भी है, और कल भी रहेगी), २. 'अनाशी' (इसे किसी भी तरीके से मिटाया नहीं जा सकता), ३. 'अप्रमेय' (इसे भौतिक इंद्रियों या विज्ञान के पैमानों से मापा या देखा नहीं जा सकता)।
            इसके बिल्कुल विपरीत, यह जो भौतिक शरीर है (चाहे वह महान भीष्म का हो या किसी साधारण सैनिक का), वह 'अन्तवन्त' है—अर्थात् उसका अंत (मृत्यु) पहले से ही तय है।
            जब शरीर को हर हाल में मरना ही है, और आत्मा किसी भी हाल में मर ही नहीं सकती, तो फिर अर्जुन के शोक का आधार ही क्या बचा?
            भगवान अपनी पूरी फिलॉसफी को एक बहुत ही स्पष्ट और सीधे 'कॉल टू एक्शन' (Call to Action) में बदलते हैं: "तस्माद्युध्यस्व" (इसलिए, उठो और युद्ध करो)।
            वे यह नहीं कह रहे हैं कि युद्ध करना कोई बहुत अच्छा काम है, बल्कि वे यह कह रहे हैं कि जब शरीर का नाश होना प्रकृति का एक अटल नियम है, तो तुम्हें अपने क्षत्रिय धर्म (अन्याय को मिटाने) से पीछे नहीं हटना चाहिए।
        """.trimIndent(),
        english = """
            The material body of the indestructible, immeasurable (Aprameya), and eternal living entity is guaranteed to come to an end (Antavanta).
            Therefore, having clearly understood this supreme truth, O descendant of Bharata (Arjuna), fight the battle!
            Lord Sri Krishna is drawing a highly logical, direct, and inescapable conclusion here by perfectly comparing the distinct natures of the material body and the spiritual soul.
            He gives three profound adjectives to the soul: 1. 'Nitya' (it existed yesterday, exists today, and will exist eternally), 2. 'Anashi' (it cannot be destroyed by any possible means), 3. 'Aprameya' (it is immeasurable and cannot be perceived by crude physical senses or material science).
            In stark and complete contrast to this, the physical material body (whether it belongs to the great Bhishma or an ordinary foot soldier) is 'Antavanta'—meaning its ultimate destruction (death) is already pre-destined and certain.
            When the physical body must inevitably die in any case, and the spiritual soul simply cannot die in any case, what possible logical ground remains for Arjuna's intense grief?
            The Lord brilliantly converts His entire profound philosophy into a very sharp, direct 'Call to Action': "Tasmad yudhyasva" (Therefore, stand up and fight).
            He is not preaching that war itself is a wonderful activity; rather, He is declaring that since the destruction of the body is an unchangeable law of material nature, you must absolutely not shrink from your sacred Kshatriya duty (to eradicate injustice).
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            य एनं वेत्ति हन्तारं यश्चैनं मन्यते हतम् |
            उभौ तौ न विजानीतो नायं हन्ति न हन्यते || १९ ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति इस आत्मा को मारने वाला समझता है, और जो व्यक्ति इस आत्मा को मरा हुआ (मारा गया) मानता है...
            वे दोनों ही महामूर्ख हैं और सत्य को बिल्कुल नहीं जानते; क्योंकि यह आत्मा वास्तव में न तो किसी को मारती है और न ही किसी के द्वारा मारी जाती है।
            भगवान श्रीकृष्ण यहाँ अर्जुन के अहंकार और अज्ञान पर एक साथ बहुत ही करारी चोट कर रहे हैं।
            अर्जुन बार-बार कह रहे थे: "मैं भीष्म को मारूँगा", "मैं द्रोण को मारूँगा", "मेरे कारण ये सब मारे जाएंगे"।
            भगवान स्पष्ट करते हैं कि जो भी व्यक्ति यह सोचता है कि उसने किसी को 'मार दिया', वह अज्ञान में जी रहा है, क्योंकि आत्मा को मारा ही नहीं जा सकता।
            और जो मरने वाला यह सोचता है कि "मैं मर गया", वह भी अज्ञानी है, क्योंकि आत्मा कभी मरती नहीं, केवल शरीर छूटता है।
            यह श्लोक किसी भी प्रकार की भौतिक हिंसा या हत्या को सही ठहराने के लिए नहीं है; यह केवल आत्मा की परम अमरता को दर्शाने के लिए है।
            सांसारिक और कानूनी दृष्टि से हत्यारे को सजा मिलती है (क्योंकि उसने शरीर का नाश किया), लेकिन पारलौकिक दृष्टि से आत्मा अछूती रहती है।
            अर्जुन का यह सोचना कि वे किसी की आत्मा के विनाशक बन सकते हैं, उनका सबसे बड़ा भ्रम है; वे केवल प्रकृति के हाथों में एक निमित्त (Instrument) मात्र हैं।
        """.trimIndent(),
        english = """
            He who mistakenly thinks that this living entity (the soul) is the killer, and he who mistakenly thinks that this soul is killed...
            both of them are completely in ignorance and absolutely do not know the truth; because the soul in reality neither kills anyone nor is it ever killed by anyone.
            Lord Sri Krishna is delivering a highly severe, simultaneous blow to both Arjuna's false ego and his profound ignorance here.
            Arjuna had been repeatedly lamenting: "I will kill Bhishma", "I will kill Drona", "Because of me, all these people will be slaughtered".
            The Lord makes it brilliantly clear that anyone who arrogantly thinks he has 'killed' someone is living in total illusion, because the eternal soul simply cannot be killed.
            And similarly, the dying person who foolishly laments "I am dying" is also deeply ignorant, because the soul never dies; only the temporary physical coat is discarded.
            This extremely powerful verse is absolutely not meant to legally or morally justify physical violence or murder; it is meant solely to illustrate the supreme, untouchable immortality of the soul.
            From a worldly and legal perspective, a murderer is certainly punished (because he unlawfully destroyed a physical body), but from the transcendental perspective, the soul remains completely untouched.
            Arjuna's arrogant belief that he can somehow become the destroyer of someone's eternal soul is his biggest delusion; he is merely going to be a small instrument in the hands of material nature.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            न जायते म्रियते वा कदाचिन् नायं भूत्वा भविता वा न भूयः |
            अजो नित्यः शाश्वतोऽयं पुराणो न हन्यते हन्यमाने शरीरे || २० ||
        """.trimIndent(),
        hindi = """
            यह आत्मा किसी भी काल में न तो कभी जन्म लेती है और न ही कभी मरती है; और न ही यह ऐसा है कि पहले उत्पन्न होकर फिर कभी न रहे (या नष्ट हो जाए)।
            यह आत्मा अजन्मा (जिसका जन्म न हो), नित्य (हमेशा रहने वाली), शाश्वत (लगातार एक जैसी रहने वाली) और अत्यंत पुरातन (सबसे पुरानी) है।
            शरीर के मारे जाने पर (नष्ट हो जाने पर) भी यह आत्मा बिल्कुल भी नहीं मारी जाती।
            यह श्लोक भगवद्गीता के सबसे प्रसिद्ध, सबसे सुंदर और आत्मा के स्वरूप का वर्णन करने वाले सबसे महत्वपूर्ण श्लोकों में से एक है।
            भगवान श्रीकृष्ण इसमें आत्मा की उन छह भौतिक विकृतियों (षड्विकार) का पूरी तरह से खंडन करते हैं जिनसे हर भौतिक शरीर गुजरता है (जन्म, अस्तित्व, विकास, परिपक्वता, क्षय और मृत्यु)।
            आत्मा 'अजः' है—इसका कोई जन्मदिन नहीं होता। यह 'नित्य' और 'शाश्वत' है—यह कभी बुड्ढी या कमजोर नहीं होती। यह 'पुराण' है—यह ब्रह्मांड की सबसे पुरानी सत्ता है, फिर भी यह हमेशा नई और ताजी रहती है।
            जब किसी शरीर को तलवार से काट दिया जाता है, आग में जला दिया जाता है, या वह बीमारी से नष्ट हो जाता है ('हन्यमाने शरीरे'), तब भी उसके भीतर बैठी आत्मा को खरोंच तक नहीं आती।
            जैसे किसी मकान के टूट जाने पर मकान के अंदर का आकाश (Space) नहीं टूटता, वैसे ही शरीर के मिटने पर आत्मा नहीं मिटती।
            इस एक श्लोक को गहराई से समझ लेने पर मृत्यु का जो भयंकर भय हर इंसान को सताता है, वह जड़ से हमेशा के लिए खत्म हो जाता है।
        """.trimIndent(),
        english = """
            For the soul there is absolutely neither birth nor death at any time; nor is it that having once been, it will ever cease to be.
            This soul is unborn (Aja), eternal (Nitya), ever-existing (Shashvata), and primeval (Purana - the oldest).
            It is absolutely not killed or destroyed when the physical body is killed or destroyed.
            This is arguably one of the most famous, most exquisitely beautiful, and supremely important verses in the entire Bhagavad Gita describing the exact nature of the soul.
            Lord Sri Krishna systematically and completely refutes all the six material transformations (birth, existence, growth, maturity, decay, and death) that every physical body must inevitably undergo.
            The soul is 'Aja'—it possesses no birthday. It is 'Nitya' and 'Shashvata'—it never grows old, weak, or changes its fundamental nature. It is 'Purana'—it is the oldest entity in the universe, yet it always remains perfectly fresh and new.
            Even when a physical body is brutally hacked to pieces by swords, completely burnt to ashes in fire, or utterly destroyed by a terrible disease ('hanyamane sharire'), the soul sitting inside doesn't even get a scratch.
            Just as the empty space (sky) inside a house is absolutely not broken when the walls of the house are demolished, similarly, the soul is not destroyed when the body perishes.
            By deeply understanding and internalizing the profound truth of this single verse, the terrifying, paralyzing fear of death that haunts every human being is completely eradicated from its very root forever.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            वेदाविनाशिनं नित्यं य एनमजमव्ययम् |
            कथं स पुरुषः पार्थ कं घातयति हन्ति कम् || २१ ||
        """.trimIndent(),
        hindi = """
            हे पृथा-पुत्र (पार्थ)! जो मनुष्य इस आत्मा को पूरी तरह से अविनाशी (कभी नष्ट न होने वाला), नित्य (हमेशा रहने वाला), अजन्मा (जिसका जन्म न हो) और अव्यय (जिसमें कभी कोई कमी न आए) जानता है...
            वह मनुष्य भला कैसे किसी को मार सकता है, या कैसे किसी को मरवा सकता है?
            भगवान श्रीकृष्ण यहाँ अर्जुन के उस गहरे अपराधबोध (Guilt) को मिटा रहे हैं जहाँ वे खुद को हत्यारा मान रहे थे।
            जब एक ज्ञानी व्यक्ति यह अच्छी तरह समझ लेता है कि आत्मा को किसी भी प्रकार से मारा ही नहीं जा सकता, तो उसके भीतर से यह कर्तापन का अहंकार (कि 'मैं' मार रहा हूँ) पूरी तरह से खत्म हो जाता है।
            भगवान समझा रहे हैं कि अज्ञानी व्यक्ति शरीर को आत्मा मानकर सोचता है कि उसने किसी की हत्या कर दी।
            परंतु एक आत्मज्ञानी क्षत्रिय जब युद्ध के मैदान में धर्म की रक्षा के लिए शत्रुओं के शरीर काटता है, तो उसे यह स्पष्ट ज्ञान होता है कि वह केवल भौतिक शरीरों को नष्ट कर रहा है, आत्माओं को नहीं।
            इसलिए, न्याय के लिए युद्ध करते समय एक क्षत्रिय वास्तव में किसी को 'मार' नहीं रहा होता है, वह केवल प्रकृति के नियमों के तहत अपना कर्त्तव्य निभा रहा होता है।
            श्रीकृष्ण अर्जुन को उस सर्वोच्च आध्यात्मिक चेतना तक उठा रहे हैं जहाँ कर्म करते हुए भी मनुष्य कर्म के पाप से पूरी तरह मुक्त रहता है।
            यह श्लोक कर्म और अकर्म के अत्यंत गहरे रहस्य को उजागर करता है—ज्ञान के साथ किया गया हिंसात्मक कार्य भी पापमुक्त हो सकता है।
        """.trimIndent(),
        english = """
            O Partha (Arjuna)! A person who perfectly knows this soul to be indestructible (Avinashi), eternal (Nitya), unborn (Aja), and inexhaustible (Avyaya)...
            how can that person possibly kill anyone, or how can he cause anyone to be killed?
            Lord Sri Krishna is completely erasing Arjuna's deep-rooted, paralyzing guilt here, where he was falsely considering himself a murderer.
            When an enlightened person thoroughly understands that the eternal soul simply cannot be killed by any means, the false ego of doership (the thought that 'I' am killing) is completely destroyed within him.
            The Lord explains that an ignorant person mistakes the physical body for the soul and foolishly thinks he has murdered someone.
            However, when a self-realized Kshatriya slices through enemy bodies on the battlefield to protect dharma, he possesses the crystal-clear knowledge that he is only destroying material bodies, not eternal souls.
            Therefore, while fighting strictly for justice, a righteous warrior is not actually 'killing' anyone; he is merely performing his supreme duty under the laws of material nature.
            Sri Krishna is elevating Arjuna to that supreme spiritual consciousness where a person remains completely free from the sinful reactions of work, even while performing horrific actions like war.
            This profound verse reveals the deepest secret of action and inaction—even a seemingly violent act can be totally free from sin if performed with absolute spiritual knowledge.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            वासांसि जीर्णानि यथा विहाय नवानि गृह्णाति नरोऽपराणि |
            तथा शरीराणि विहाय जीर्णा न्यन्यानि संयाति नवानि देही || २२ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार मनुष्य अपने फटे-पुराने (जीर्ण) कपड़ों को उतारकर त्याग देता है और दूसरे नए कपड़े धारण कर लेता है...
            ठीक उसी प्रकार, यह आत्मा (देही) भी पुराने और अनुपयोगी हो चुके शरीरों को त्यागकर दूसरे नए शरीरों को प्राप्त कर लेती है।
            यह भगवद्गीता के सबसे लोकप्रिय और आसानी से समझ में आने वाले दृष्टांतों (Examples) में से एक है।
            भगवान श्रीकृष्ण मृत्यु के भयंकर डर को एक बहुत ही सामान्य और रोज़मर्रा की घटना से जोड़कर उसका सारा खौफ खत्म कर रहे हैं।
            वे कहते हैं कि जब तुम्हारे कपड़े पुराने हो जाते हैं या फट जाते हैं, तो क्या तुम उन्हें फेंकने पर रोते हो? बिल्कुल नहीं, क्योंकि तुम्हें पता है कि तुम्हें नए कपड़े मिल जाएंगे और 'तुम' वही रहोगे।
            उसी तरह, बीमारी, बुढ़ापे या युद्ध के कारण जब यह भौतिक शरीर आत्मा के रहने या काम करने लायक नहीं रहता, तो आत्मा उसे एक पुराने कपड़े की तरह उतार कर फेंक देती है।
            और कर्मों के अनुसार प्रकृति उसे तुरंत एक बिल्कुल नया और ताज़ा शरीर (कपड़ा) दे देती है।
            मृत्यु कोई पूर्ण विराम (Full Stop) नहीं है, यह तो आत्मा की अनंत यात्रा में केवल एक अल्पविराम (Comma) है।
            अर्जुन जो अपने गुरुओं और संबंधियों के शरीरों के कटने के विचार से काँप रहे थे, भगवान उन्हें समझा रहे हैं कि तुम उनके कपड़े (शरीर) बदलने पर व्यर्थ ही इतना शोक कर रहे हो।
        """.trimIndent(),
        english = """
            Just as a person discards his old, torn, and worn-out garments (Vasamsi) and puts on other brand new clothes...
            in the exact same way, the embodied soul (Dehi) completely discards its old, useless bodies and accepts new material bodies.
            This is arguably one of the most famous, relatable, and easily understandable analogies in the entire Bhagavad Gita.
            Lord Sri Krishna is completely removing the terrifying horror of death by brilliantly comparing it to a very normal, everyday human activity.
            He is essentially asking Arjuna: when your clothes become old, torn, or useless, do you sit down and cry when you throw them away? Absolutely not, because you know you will get new clothes and 'You' remain exactly the same.
            In the exact same way, when this physical body becomes completely useless due to old age, disease, or severe injuries in war, the soul simply discards it like a dirty old shirt.
            And according to its past karma, material nature immediately provides it with a brand new, fresh physical body (new clothes).
            Death is absolutely not a final full stop; it is merely a tiny comma in the soul's infinite, eternal journey across lifetimes.
            Arjuna was violently trembling at the mere thought of his relatives' bodies being hacked to pieces; the Lord is explaining that he is foolishly crying over them merely changing their temporary physical clothes.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            नैनं छिन्दन्ति शस्त्राणि नैनं दहति पावकः |
            न चैनं क्लेदयन्त्यापो न शोषयति मारुतः || २३ ||
        """.trimIndent(),
        hindi = """
            इस आत्मा को कोई भी शस्त्र (हथियार) काट नहीं सकते, और न ही इसे आग (पावक) जला सकती है।
            जल (पानी) इस आत्मा को भिगो या गला नहीं सकता, और न ही वायु (हवा) इसे सुखा सकती है।
            भगवान श्रीकृष्ण यहाँ भौतिक प्रकृति (Material Nature) के चार सबसे शक्तिशाली तत्वों—पृथ्वी (शस्त्र), अग्नि, जल और वायु—की परम सीमाएं बता रहे हैं।
            दुनिया का हर भौतिक शरीर या वस्तु इन चार तत्वों के प्रहार से नष्ट हो सकती है; तलवार शरीर को काट सकती है, आग उसे राख कर सकती है, पानी उसे गला सकता है और तेज़ हवा उसे सुखा सकती है।
            लेकिन आत्मा इन भौतिक तत्वों से नहीं बनी है; वह पूर्ण रूप से आध्यात्मिक (Spiritual) और दिव्य है।
            भौतिक दुनिया का कोई भी हथियार या तत्व आध्यात्मिक सत्ता को छू तक नहीं सकता, उसे नष्ट करना तो बहुत दूर की बात है।
            अर्जुन का यह डर कि उनके बाणों से भीष्म या द्रोण की हत्या हो जाएगी, इस श्लोक से पूरी तरह निराधार साबित हो जाता है।
            भगवान स्पष्ट गारंटी दे रहे हैं कि चाहे कितने भी ब्रह्मास्त्र या भयंकर हथियार क्यों न चल जाएं, आत्मा पर खरोंच भी नहीं आ सकती।
            यह ज्ञान मनुष्य को दुनिया के हर प्रकार के डर से पूरी तरह मुक्त कर देता है, क्योंकि जो हमारा असली स्वरूप (आत्मा) है, वह ब्रह्मांड की हर चीज़ से पूरी तरह अजेय है।
        """.trimIndent(),
        english = """
            No weapons whatsoever can ever cut or pierce this soul, nor can fire ever burn it.
            Water can never moisten or dissolve it, nor can the wind ever dry it out.
            Lord Sri Krishna is vividly defining the absolute limitations of the four most powerful elements of material nature here—Earth (weapons), Fire, Water, and Air.
            Every single physical body or material object in the universe can be easily destroyed by the sheer force of these elements: swords can chop a body, fire can turn it to ash, water can rot it, and fierce winds can dry it up.
            But the soul is absolutely not made of these physical material elements; it is entirely spiritual and completely transcendental.
            No weapon or destructive element of the material world can even touch the spiritual reality, let alone destroy it.
            Arjuna's paralyzing fear that his deadly arrows would murder Bhishma or Drona is proven completely baseless and unscientific by this single verse.
            The Lord is giving an absolute, ironclad guarantee that even if millions of nuclear weapons (Brahmastras) are deployed, the soul will not receive even a microscopic scratch.
            This supreme knowledge completely liberates a human being from every possible fear in the world, because our true identity (the soul) is absolutely invincible against everything in the universe.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            अच्छेद्योऽयमदाह्योऽयमक्लेद्योऽशोष्य एव च |
            नित्यः सर्वगतः स्थाणुरचलोऽयं सनातनः || २४ ||
        """.trimIndent(),
        hindi = """
            निश्चित रूप से यह आत्मा अच्छेद्य (न काटी जाने वाली), अदाह्य (न जलाई जाने वाली), अक्लेद्य (न गीली होने वाली) और अशोष्य (न सूखने वाली) है।
            यह आत्मा नित्य (हमेशा रहने वाली), सर्वगत (सब जगह व्याप्त), स्थाणु (स्थिर), अचल (कभी न हिलने वाली) और सनातन (सबसे प्राचीन) है।
            पिछले श्लोक की बात को और अधिक दृढ़ता और बल (Emphasis) के साथ दोहराते हुए भगवान आत्मा के विशेष गुण बता रहे हैं।
            कई बार जब शिष्य अज्ञान में बहुत गहराई तक फंसा होता है, तो गुरु एक ही सत्य को अलग-अलग शब्दों में बार-बार दोहराता है ताकि वह बात शिष्य के अवचेतन (Subconscious) में बैठ जाए।
            श्रीकृष्ण आत्मा को 'सर्वगतः' कहते हैं, जिसका अर्थ है कि आत्मा हर स्थिति और हर योनि (शरीर) में मौजूद रह सकती है, यह किसी एक शरीर में कैद नहीं है।
            यह 'स्थाणु' (एक खंभे की तरह अचल) और 'सनातन' (हमेशा से अस्तित्व में रहने वाली) है; समय का प्रवाह इसे बूढ़ा या कमजोर नहीं कर सकता।
            संसार की हर चीज़ में 'मोशन' (गति और परिवर्तन) है, लेकिन आत्मा 'अचल' है, उसमें कभी कोई बदलाव या डिग्रेडेशन (Degradation) नहीं होता।
            जब आत्मा इतनी स्थिर, पूर्ण और अजेय है, तो फिर अर्जुन का यह रोना और युद्धभूमि में घबराना उनके परम अज्ञान का ही प्रदर्शन है।
            भगवान अर्जुन को उनके शरीर के दायरे से बाहर निकालकर उन्हें उनके उस अमर स्वरूप की याद दिला रहे हैं जिसे दुनिया की कोई ताकत नहीं मिटा सकती।
        """.trimIndent(),
        english = """
            This individual soul is undeniably unbreakable and indivisible, insoluble, and can neither be burned nor dried.
            It is eternal (Nitya), all-pervading (Sarva-gatah), unchangeable (Sthanu), immovable (Achala), and eternally the same (Sanatana).
            Repeating the profound truth of the previous verse with much greater emphasis and absolute conviction, the Lord further describes the specific qualities of the soul.
            Often, when a disciple is trapped extremely deeply in the dark mud of ignorance, the Guru repeats the exact same truth using different words so that it penetrates deep into the disciple's subconscious mind.
            Sri Krishna calls the soul 'Sarva-gatah' (all-pervading), meaning the soul can exist in any condition, species, or environment; it is not permanently imprisoned in one specific physical body.
            It is 'Sthanu' (unshakable like a firm pillar) and 'Sanatana' (primeval and eternal); the ruthless flow of time can never make it old, weak, or degraded.
            Everything in the material world has 'motion' (constant change and decay), but the soul is 'Achala' (immovable); it never undergoes any mutation or chemical change.
            When the soul is so supremely stable, perfect, and invincible, Arjuna's crying and panicking on the battlefield is nothing but a tragic display of his profound ignorance.
            The Lord is forcefully pulling Arjuna out of the narrow, suffocating boundaries of his physical body, constantly reminding him of his immortal identity which no power in the universe can ever destroy.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            अव्यक्तोऽयमचिन्त्योऽयमविकार्योऽयमुच्यते |
            तस्मादेवं विदित्वैनं नानुशोचितुमर्हसि || २५ ||
        """.trimIndent(),
        hindi = """
            यह आत्मा अव्यक्त (इन्द्रियों से न दिखाई देने वाली), अचिन्त्य (मन की सोच से परे) और अविकारी (जिसमें कोई परिवर्तन न हो) कही जाती है।
            इसलिए, हे अर्जुन! इस आत्मा को इस प्रकार (अमर और अजेय) जानकर, तुम्हारा शोक करना बिल्कुल भी उचित नहीं है।
            श्रीकृष्ण आत्मा की तीन और अत्यंत रहस्यमयी विशेषताएं बता रहे हैं।
            यह 'अव्यक्त' है: इसे हम अपनी भौतिक आँखों या माइक्रोस्कोप से नहीं देख सकते, यह विज्ञान के उपकरणों की पकड़ से पूरी तरह बाहर है।
            यह 'अचिन्त्य' है: हमारा भौतिक मन केवल उन्हीं चीज़ों को सोच सकता है जिन्हें उसने देखा या सुना हो; आत्मा भौतिक नहीं है, इसलिए मन इसकी कल्पना भी नहीं कर सकता।
            यह 'अविकार्य' है: दूध फटकर दही बन जाता है (विकार), लेकिन आत्मा में कभी कोई रासायनिक या भौतिक बदलाव नहीं आता।
            भगवान निष्कर्ष निकालते हैं कि जब आत्मा को देखा नहीं जा सकता, सोचा नहीं जा सकता, और बदला नहीं जा सकता, तो फिर तुम उसके लिए रो क्यों रहे हो?
            शोक हमेशा उस चीज़ के लिए किया जाता है जो बदल जाती है या नष्ट हो जाती है। जब आत्मा नष्ट ही नहीं होती, तो शोक (अनुशोचितुम्) करना पूरी तरह से अतार्किक (Illogical) है।
            भगवान अर्जुन के डिप्रेशन को केवल भावनाओं से नहीं, बल्कि ठोस, अकाट्य आध्यात्मिक तर्क (Logic) से काट रहे हैं।
        """.trimIndent(),
        english = """
            It is said that this soul is unmanifested (invisible to material eyes), inconceivable (beyond the mind's thoughts), and immutable (unchangeable).
            Therefore, O Arjuna! Knowing this soul to be as such (immortal and invincible), you should absolutely not grieve for the body.
            Sri Krishna is revealing three more extremely mysterious and transcendental characteristics of the soul.
            It is 'Avyakta' (unmanifest): we absolutely cannot see it with our physical eyes or the most powerful microscopes; it completely entirely escapes the grasp of material science and technology.
            It is 'Achintya' (inconceivable): our material mind can only think of and process things it has seen, heard, or touched; since the soul is purely spiritual, the material mind cannot even imagine it.
            It is 'Avikarya' (immutable): milk transforms and degrades into yogurt (mutation), but the soul never ever undergoes any physical or chemical changes or degradation.
            The Lord draws a powerful conclusion: when the soul cannot be seen, cannot be imagined, and cannot be changed, then why on earth are you crying for it?
            Lamentation is always reserved for things that mutate, degrade, or get destroyed. When the soul is never destroyed, grieving ('anushocitum') for it is completely illogical and foolish.
            The Lord is not cutting down Arjuna's severe depression with mere emotional comfort, but with solid, irrefutable, and razor-sharp spiritual logic.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            अथ चैनं नित्यजातं नित्यं वा मन्यसे मृतम् |
            तथापि त्वं महाबाहो नैवं शोचितुमर्हसि || २६ ||
        """.trimIndent(),
        hindi = """
            परंतु हे महाबाहु अर्जुन! यदि तुम इस आत्मा को हमेशा (लगातार) जन्म लेने वाला और हमेशा मरने वाला भी मानते हो...
            तो भी हे महाबाहो! तुम्हारे लिए इस प्रकार शोक करना बिल्कुल उचित नहीं है।
            भगवान श्रीकृष्ण अब एक बहुत ही शानदार तर्क (Debate Technique) का प्रयोग कर रहे हैं।
            मान लो कि थोड़ी देर के लिए अर्जुन वेदान्त के इस आध्यात्मिक दर्शन (कि आत्मा अमर है) को नहीं मानता।
            मान लो कि अर्जुन उस भौतिकवादी (Materialistic/Atheist) विचारधारा को मानता है कि आत्मा जैसी कोई चीज़ नहीं होती, केवल शरीर ही पैदा होता है और मर जाता है।
            श्रीकृष्ण कहते हैं कि यदि तुम नास्तिकों की तरह यह मानते हो कि शरीर का जन्म ही जीवन है और शरीर का नाश ही सब कुछ खत्म होना है, तब भी तुम्हारा रोना व्यर्थ है!
            क्योंकि अगर मृत्यु हर चीज़ का पूर्ण अंत है और उसके बाद कुछ नहीं बचता, तो फिर उस चीज़ के लिए रोना कैसा जो हमेशा के लिए खत्म हो गई?
            रासायनिक तत्त्व (Chemicals) मिलते हैं तो शरीर बनता है, और वे अलग होते हैं तो शरीर मर जाता है। क्या रसायनों के मिलने और बिछड़ने पर कोई बुद्धिमान इंसान रोता है?
            भगवान दोनों ही दृष्टिकोणों से—चाहे तुम आस्तिक (Spiritual) हो या नास्तिक (Materialist)—अर्जुन के शोक को पूरी तरह से अतार्किक और मूर्खतापूर्ण साबित कर रहे हैं।
            'महाबाहु' कहकर वे याद दिला रहे हैं कि तुम इतने शक्तिशाली योद्धा हो, फिर भी बच्चों जैसी कच्ची सोच रख रहे हो।
        """.trimIndent(),
        english = """
            If, however, O mighty-armed Arjuna, you think that the soul (or life symptoms) is perpetually born and always dies...
            even then, O mighty-armed one, you still have absolutely no reason to lament in this way.
            Lord Sri Krishna is now using a highly brilliant debate technique and flawless logical counter-argument here.
            Assume for a moment that Arjuna completely rejects this Vedantic spiritual philosophy (that the soul is eternal and immortal).
            Assume Arjuna subscribes to the purely materialistic or atheistic view that there is no soul, and life is merely a chemical reaction where the body is born and then permanently dies.
            Sri Krishna argues that even if you think like an atheist—that birth of the body is the absolute beginning and physical death is the absolute final end—your crying is still completely useless!
            Because if death is the final, permanent end and absolutely nothing survives, then what is the point of crying over a bunch of chemicals that have simply dispersed forever?
            Chemicals combine to form a body, and they separate to cause death. Does any highly intelligent person sit and cry over the mere combining and separating of chemical elements?
            From both perspectives—whether you are a highly spiritual believer or a strict materialist—the Lord perfectly proves that Arjuna's grief is totally illogical and foolish.
            By addressing him as 'Maha-bahu' (mighty-armed), He is sharply reminding him: you are such an incredibly powerful warrior, yet you are thinking with the fragile logic of a child.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            जातस्य हि ध्रुवो मृत्युर्ध्रुवं जन्म मृतस्य च |
            तस्मादपरिहार्येऽर्थे न त्वं शोचितुमर्हसि || २७ ||
        """.trimIndent(),
        hindi = """
            क्योंकि जिसने भी जन्म लिया है, उसकी मृत्यु निश्चित (ध्रुव) है; और जो मर गया है, उसका जन्म भी निश्चित है।
            इसलिए, इस बिना उपाय वाले (अपरिहार्य) विषय में तुम्हारे लिए शोक करना बिल्कुल भी उचित नहीं है।
            यह श्लोक प्रकृति के उस कठोर और अटल नियम (Law of Nature) को बताता है जिसे कोई भी नहीं बदल सकता।
            भगवान कहते हैं कि जन्म और मृत्यु एक घूमते हुए पहिए (चक्र) की तरह हैं। जो ऊपर गया है, वह नीचे आएगा, और जो नीचे है, वह फिर से ऊपर जाएगा।
            जब भीष्म और द्रोण ने जन्म लिया था, उसी क्षण यह भी तय हो गया था कि उन्हें एक दिन मरना है। मृत्यु कोई दुर्घटना नहीं है, यह जीवन की सबसे बड़ी निश्चितता है।
            और मृत्यु के बाद कर्मों के अनुसार उन्हें नया शरीर (जन्म) मिलना भी तय है।
            जब कोई घटना 'अपरिहार्य' है—यानी जिसे किसी भी प्रार्थना, विज्ञान, या हथियार से टाला नहीं जा सकता—तो उस पर रोने से क्या हासिल होगा?
            क्या कोई समझदार इंसान इस बात पर रोता है कि सूरज क्यों डूब रहा है? नहीं, क्योंकि वह जानता है कि यह प्रकृति का नियम है।
            अर्जुन उसी अटल नियम के लिए व्यर्थ में आँसू बहा रहे हैं। श्रीकृष्ण उन्हें भावनाओं से निकालकर वास्तविकता (Reality) के धरातल पर ला रहे हैं।
            यह श्लोक हमें सिखाता है कि जो चीजें हमारे नियंत्रण से पूरी तरह बाहर हैं, उनके लिए रोना अज्ञानता की निशानी है।
        """.trimIndent(),
        english = """
            For one who has taken birth, death is absolutely certain (Dhruva); and for one who is dead, birth is equally certain.
            Therefore, in the completely unavoidable execution of your duty, you absolutely should not lament.
            This verse clearly defines the harsh, inescapable, and absolute Law of Material Nature that absolutely no one in the universe can ever change.
            The Lord states that birth and death are exactly like a constantly revolving wheel. Whatever goes up must inevitably come down, and whatever is down will surely rise again.
            The exact moment Bhishma and Drona took their births, it was simultaneously guaranteed that they would have to die one day. Death is never an accident; it is life's ultimate certainty.
            And following their physical death, according to their past karma, acquiring a brand new body (rebirth) is also fully guaranteed.
            When an event is 'Apariharya'—meaning completely unavoidable and unstoppable by any prayer, science, or weapon—then what is achieved by bitterly crying over it?
            Does any sane, intelligent human being sit and cry because the sun is setting? No, because they know it is an unchangeable law of nature.
            Arjuna is foolishly shedding tears over that very same inevitable law. Sri Krishna is pulling him out of his blinding emotional quicksand and grounding him in absolute reality.
            This powerful verse teaches us that crying over things that are completely and utterly beyond our control is the ultimate sign of profound ignorance.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            अव्यक्तादीनि भूतानि व्यक्तमध्यानि भारत |
            अव्यक्तनिधनान्येव तत्र का परिदेवना || २८ ||
        """.trimIndent(),
        hindi = """
            हे भारत (अर्जुन)! सभी प्राणी जन्म से पहले बिना शरीर के (अव्यक्त) थे, जन्म और मृत्यु के बीच की अवस्था में वे प्रकट (व्यक्त) दिखाई देते हैं...
            और मृत्यु के बाद वे फिर से बिना शरीर के (अव्यक्त) हो जाएंगे। तो फिर इस स्थिति में शोक करने की क्या बात है?
            भगवान श्रीकृष्ण यहाँ जीवन को एक बहुत ही बड़े परिदृश्य (Bigger Picture) में देखने का नजरिया दे रहे हैं।
            वे समझाते हैं कि हमारा यह जीवन अनंत काल की रेखा पर केवल एक छोटे से चमकते हुए बिंदु (Flash) के समान है।
            जन्म लेने से पहले हम कहाँ थे, कोई नहीं जानता (अव्यक्त)। मृत्यु के बाद हम कहाँ जाएंगे, यह भी कोई भौतिक आँखों से नहीं देख सकता (पुनः अव्यक्त)।
            हम केवल जन्म और मृत्यु के बीच के कुछ साठ-सत्तर सालों को देखते हैं, जहाँ शरीर प्रकट (व्यक्त) होता है।
            अर्जुन की समस्या यह है कि वे उस छोटी सी 'व्यक्त' अवस्था (जीवन) से बहुत ज्यादा आसक्त (Attach) हो गए हैं, और यह भूल गए हैं कि इसके आगे और पीछे का सत्य अव्यक्त है।
            जैसे रात के अंधेरे में एक जुगनू कुछ पल के लिए चमकता है और फिर अंधेरे में खो जाता है, वैसे ही यह भौतिक शरीर कुछ समय के लिए दिखता है और फिर गायब हो जाता है।
            जब सब कुछ अंततः उसी अव्यक्त (निराकार) अवस्था में ही जाना है, तो फिर बीच की इस छोटी सी अवस्था के नष्ट होने पर इतना विलाप (परिदेवना) क्यों?
            भगवान अर्जुन की दृष्टि को शरीर के इस छोटे से बुलबुले से निकालकर आत्मा की अनंतता की ओर ले जा रहे हैं।
        """.trimIndent(),
        english = """
            O descendant of Bharata (Arjuna)! All created beings are completely unmanifest (invisible/formless) in their beginning, manifest (visible) only in their interim state...
            and they become completely unmanifest again when entirely annihilated (after death). So what need is there for lamentation in this?
            Lord Sri Krishna is shifting Arjuna's perspective here, asking him to look at human life from a massive, cosmic 'Bigger Picture'.
            He beautifully explains that this current human life is merely a tiny, fleeting flash of light on the infinite, eternal timeline of existence.
            Where we were before taking birth, no one knows (Avyakta - unmanifest). Where we will go after physical death, no one can see with material eyes (again Avyakta).
            We only ever see the brief sixty or seventy years between birth and death, where the physical body temporarily becomes visible (Vyakta).
            Arjuna's core problem is that he has become intensely and blindly attached to this tiny, temporary 'Vyakta' state (current life), completely forgetting the infinite unmanifest reality before and after it.
            Just like a firefly glows for a brief second in the dark night and disappears back into the darkness, this physical body appears temporarily and then completely vanishes.
            When absolutely everything must ultimately return to that exact same unmanifest (formless) state, why is there such heavy lamentation (paridevana) over the destruction of this brief interim phase?
            The Lord is expanding Arjuna's vision far beyond the fragile, temporary bubble of the physical body towards the infinite eternity of the soul.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            आश्चर्यवत्पश्यति कश्चिदेनम् आश्चर्यवद्वदति तथैव चान्यः |
            आश्चर्यवच्चैनमन्यः शृणोति श्रुत्वाप्येनं वेद न चैव कश्चित् || २९ ||
        """.trimIndent(),
        hindi = """
            कोई महापुरुष ही इस आत्मा को आश्चर्य की तरह (एक अद्भुत तत्व के रूप में) देखता है; वैसे ही कोई अन्य इसे आश्चर्य की तरह बताता है;
            कोई दूसरा इसे आश्चर्य की तरह सुनता है; और कोई तो इसे सुनकर भी बिल्कुल नहीं समझ पाता!
            यहाँ भगवान श्रीकृष्ण आत्मा के विषय की अत्यंत सूक्ष्मता और कठिनाई को स्वीकार कर रहे हैं।
            आत्मा कोई भौतिक वस्तु नहीं है जिसे प्रयोगशाला (Laboratory) में देखा या परखा जा सके। यह पूरी तरह से 'दिव्य' (Transcendental) है।
            इसलिए जब कोई सच्चा योगी ध्यान में अपनी आत्मा का दर्शन करता है, तो वह इसकी चमक और दिव्यता देखकर 'आश्चर्यचकित' (Amazed) रह जाता है।
            जब कोई गुरु इस आत्मा का वर्णन करता है, तो उसके शब्द भी आश्चर्य से भरे होते हैं, क्योंकि भौतिक भाषा आत्मा को पूरी तरह समझा नहीं सकती।
            जो शिष्य सुनता है, वह भी हैरान रह जाता है कि क्या सच में मेरे भीतर ऐसी अजेय और अमर चीज़ मौजूद है!
            लेकिन सबसे बड़ी विडंबना यह है कि अधिकतर लोग बड़े-बड़े प्रवचन सुनने और ग्रंथ पढ़ने के बाद भी आत्मा के इस रहस्य को बिल्कुल नहीं समझ पाते।
            वे सुनकर बाहर निकलते हैं और फिर से शरीर, पैसे और परिवार के मोह में फँस जाते हैं।
            अर्जुन की स्थिति भी ऐसी ही है—वे भगवान से साक्षात् ज्ञान सुन रहे हैं, फिर भी उनका मोह तुरंत नहीं टूट रहा है, क्योंकि आत्मा का विज्ञान समझना दुनिया का सबसे कठिन कार्य है।
        """.trimIndent(),
        english = """
            Some highly elevated soul looks upon this soul as amazing, some other explains it as amazing;
            another hears of it as amazing; and yet, there are others who, even after hearing all about it, cannot understand it at all!
            Here, Lord Sri Krishna is openly acknowledging the extreme subtlety, profound mystery, and extreme difficulty of truly understanding the subject of the soul.
            The soul is absolutely not a physical object that can be seen, tested, or analyzed in a scientific laboratory. It is entirely 'Transcendental' (divine).
            Therefore, when a true, advanced yogi actually perceives his own soul in deep meditation, he is completely 'amazed' and awestruck by its brilliant, infinite divinity.
            When an enlightened Guru describes this soul, his words are also filled with deep wonder, because limited material language simply cannot fully explain the spiritual soul.
            The disciple who hears this is equally astonished, wondering: does such an invincible, immortal, and perfect entity actually exist right inside me?
            But the greatest irony is that the vast majority of people, even after hearing grand lectures and reading massive scriptures, completely fail to understand this secret.
            They walk out after hearing the truth and immediately fall right back into the blind attachment of the body, money, and family.
            Arjuna's condition is quite similar—he is hearing the absolute truth directly from God Himself, yet his illusion doesn't break instantly, because realizing the science of the soul is the hardest task in the universe.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            देही नित्यमवध्योऽयं देहे सर्वस्य भारत |
            तस्मात्सर्वाणि भूतानि न त्वं शोचितुमर्हसि || ३० ||
        """.trimIndent(),
        hindi = """
            हे भरतवंशी अर्जुन! सभी प्राणियों के शरीर में रहने वाला यह 'देही' (आत्मा) नित्य (हमेशा) अवध्य (न मारा जा सकने वाला) है।
            इसलिए, तुम्हें किसी भी प्राणी के लिए इस प्रकार शोक नहीं करना चाहिए।
            इस श्लोक के साथ भगवान श्रीकृष्ण आत्मा के स्वरूप (Nature of the Soul) के विषय को अंतिम रूप से समाप्त कर रहे हैं।
            उन्होंने 11वें श्लोक से जो आत्मा का वर्णन शुरू किया था, यह उसका 'अंतिम निष्कर्ष' (Final Conclusion) है।
            वे एक बार फिर अत्यंत दृढ़ता से कहते हैं कि चाहे शरीर किसी देवता का हो, इंसान का हो, या किसी चींटी का, उसके भीतर बैठा हुआ 'देही' (आत्मा) कभी मारा नहीं जा सकता ('अवध्य')।
            यह कोई ऐसा नियम नहीं है जो कभी बदल जाएगा; यह 'नित्य' (हमेशा लागू रहने वाला) सत्य है।
            जब यह परम सत्य है कि ब्रह्मांड में किसी भी आत्मा की हत्या हो ही नहीं सकती, तो फिर अर्जुन का अपने गुरुओं और परिजनों के लिए रोना पूरी तरह से अर्थहीन है।
            भगवान कह रहे हैं कि 'सर्वाणि भूतानि' (सभी प्राणियों) के लिए शोक करना छोड़ दो, केवल अपने परिजनों के लिए ही नहीं।
            शोक हमेशा अज्ञान की उपज होता है। आत्मज्ञान का उदय होते ही शोक का हमेशा के लिए अंत हो जाता है।
            अब चूँकि आत्मा के स्तर पर अर्जुन का तर्क कट चुका है, भगवान अगले श्लोकों में सामाजिक और क्षत्रिय धर्म के स्तर पर बात करेंगे।
        """.trimIndent(),
        english = """
            O descendant of Bharata (Arjuna)! He who dwells in the physical body of every living entity (the Dehi/Soul) can never ever be slain (Avadhya).
            Therefore, having understood this, you should absolutely not mourn for any living being whatsoever.
            With this powerful verse, Lord Sri Krishna is finally concluding the profound philosophical subject of the 'Nature of the Soul' (Sankhya).
            This serves as the absolute 'Final Conclusion' of the intense spiritual description He began in verse 11.
            He emphatically reiterates that whether the physical body belongs to a powerful demigod, a human being, or a tiny ant, the 'Dehi' (Soul) seated inside it can never ever be killed ('Avadhya').
            This is not a temporary rule that might change in the future; it is an eternal ('Nitya') and unchangeable truth.
            When it is the ultimate, absolute truth that no soul in the universe can ever be murdered, then Arjuna's bitter crying for his teachers and relatives is entirely meaningless.
            The Lord commands him to stop lamenting for 'Sarvani Bhutani' (all living entities entirely), not just for his own family members.
            Lamentation is always the direct byproduct of deep ignorance. The very moment true self-realization dawns, all grief vanishes permanently.
            Now that Arjuna's false logic has been completely destroyed on the spiritual platform of the soul, the Lord will shift to practical arguments based on social and martial duty in the upcoming verses.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            स्वधर्ममपि चावेक्ष्य न विकम्पितुमर्हसि |
            धर्म्याद्धि युद्धाच्छ्रेयोऽन्यत्क्षत्रियस्य न विद्यते || ३१ ||
        """.trimIndent(),
        hindi = """
            और अपने स्वयं के क्षत्रिय धर्म (स्वधर्म) को देखते हुए भी तुम्हारा इस प्रकार काँपना या पीछे हटना उचित नहीं है।
            क्योंकि एक क्षत्रिय के लिए धर्म-युद्ध (न्याय के लिए लड़े जाने वाले युद्ध) से बढ़कर कल्याणकारी (श्रेय) कोई दूसरा कर्म इस दुनिया में है ही नहीं।
            आत्मा के ज्ञान के बाद, श्रीकृष्ण अब बहुत ही व्यावहारिक (Practical) बात कर रहे हैं। वे अर्जुन को समाज में उनकी भूमिका की याद दिला रहे हैं।
            हर मनुष्य का समाज में एक विशिष्ट 'स्वधर्म' (कर्तव्य) होता है। एक ब्राह्मण का धर्म ज्ञान देना है, और एक क्षत्रिय का धर्म अन्याय को रोकना और समाज की रक्षा करना है।
            अर्जुन एक जन्मजात और प्रशिक्षित क्षत्रिय हैं। उनके सामने कौरव समाज के सबसे बड़े शोषक और अत्याचारी के रूप में खड़े हैं।
            ऐसे में यदि अर्जुन युद्ध से भागते हैं, तो वे अहिंसा का पालन नहीं कर रहे हैं, बल्कि वे अपने सामाजिक और नैतिक 'स्वधर्म' से भगोड़े (Escapist) बन रहे हैं।
            भगवान बहुत स्पष्ट शब्दों में घोषणा करते हैं कि जब युद्ध धर्म (न्याय और सत्य) की रक्षा के लिए लड़ा जा रहा हो, तो एक क्षत्रिय के लिए उससे बड़ा कोई पुण्य या तपस्या नहीं है।
            अन्याय को देखकर आँखें बंद कर लेना कायरता है। धर्म-युद्ध में भाग लेना क्षत्रिय का सबसे बड़ा 'श्रेय' (कल्याण) है।
            अर्जुन जो जंगल में जाकर संन्यासी बनने को अपना कल्याण मान रहे थे, भगवान उस विचार को पूरी तरह से खारिज कर रहे हैं।
        """.trimIndent(),
        english = """
            And even considering your specific, inherent duty as a Kshatriya (Sva-dharma), you absolutely should not hesitate or tremble in this way.
            Because for a Kshatriya, there is absolutely no better or more auspicious engagement in this world than fighting for religious principles (Dharmya-Yuddha).
            After delivering the profound knowledge of the soul, Sri Krishna is now bringing the conversation down to a highly practical and societal level. He reminds Arjuna of his specific role in society.
            Every human being has a specific, inherent duty ('Sva-dharma') in society. A Brahmana's duty is to impart knowledge, while a Kshatriya's supreme duty is to stop injustice and protect citizens.
            Arjuna is a born, highly trained, and elite Kshatriya. Standing right in front of him are the Kauravas, the greatest tyrants and exploiters of society.
            In such a critical situation, if Arjuna runs away from the war, he is not practicing noble non-violence; he is merely becoming a coward and an escapist from his strict social and moral 'Sva-dharma'.
            The Lord declares in absolute, crystal-clear terms that when a war is fought strictly to protect dharma (justice and truth), there is no greater pious act or austerity for a Kshatriya than to fight it.
            Closing one's eyes to massive injustice is pure cowardice. Participating in a righteous war (Dharma-Yuddha) is the ultimate 'Shreya' (welfare) for a warrior.
            Arjuna thought his welfare lay in running to the forest to become a beggar-monk, but the Lord completely and utterly rejects that false notion.
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            यदृच्छया चोपपन्नं स्वर्गद्वारमपावृतम् |
            सुखिनः क्षत्रियाः पार्थ लभन्ते युद्धमीदृशम् || ३२ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ (अर्जुन)! अपने आप (बिना माँगे) प्राप्त हुआ यह युद्ध तो स्वर्ग के खुले हुए दरवाजे के समान है।
            वे क्षत्रिय अत्यंत भाग्यशाली (सुखी) होते हैं, जिन्हें इस प्रकार का महान धर्म-युद्ध लड़ने का अवसर प्राप्त होता है।
            श्रीकृष्ण अर्जुन के क्षत्रिय खून में जोश भरने के लिए उन्हें इस युद्ध का वास्तविक महत्व बता रहे हैं।
            पांडवों ने कभी यह युद्ध नहीं चाहा था; उन्होंने शांति के लिए हर संभव प्रयास किया (यहाँ तक कि सिर्फ पांच गांव मांगे थे), लेकिन दुर्योधन ने युद्ध थोप दिया।
            इसलिए यह युद्ध 'यदृच्छया' (अपने आप, भाग्यवश) पांडवों के सामने आ खड़ा हुआ है।
            शास्त्रों के अनुसार, यदि कोई क्षत्रिय धर्म की रक्षा करते हुए वीरगति (मृत्यु) को प्राप्त होता है, तो उसके लिए स्वर्ग के दरवाजे सीधे खुल जाते हैं, उसे किसी अन्य तपस्या की आवश्यकता नहीं होती।
            इसलिए भगवान कहते हैं कि ऐसे युद्ध का अवसर मिलना कोई दुःख की बात नहीं है, बल्कि यह तो परम सौभाग्य की बात है।
            दुनिया के महान क्षत्रिय पूरी उम्र ऐसे ही किसी महान उद्देश्य के लिए लड़ने की कामना करते हैं ताकि उनका जीवन सार्थक हो सके।
            अर्जुन को ऐसे महान अवसर पर रोने के बजाय एक सच्चे वीर की तरह खुश होना चाहिए कि उन्हें धर्म की रक्षा के लिए चुना गया है।
            यह श्लोक अर्जुन की निराशा को एक महान गौरव (Pride) में बदलने का प्रयास है।
        """.trimIndent(),
        english = """
            O Partha (Arjuna)! Happy are the Kshatriyas to whom such glorious opportunities for fighting come unsought (by their own accord)...
            for such a righteous war opens for them the wide, unbarred doors of the heavenly planets.
            Sri Krishna is attempting to inject fierce martial passion into Arjuna's Kshatriya blood by revealing the true, glorious significance of this specific war.
            The Pandavas absolutely never wanted this war; they tried every possible avenue for peace (even begging for just five mere villages), but Duryodhana arrogantly forced the war upon them.
            Therefore, this war has arrived 'Yadricchaya' (unsought, by the arrangement of destiny) right before the Pandavas.
            According to strict Vedic martial codes, if a Kshatriya attains martyrdom (dies) while fiercely protecting dharma, the doors of heaven swing wide open for him directly; he requires no other penance.
            Therefore, the Lord states that getting the opportunity to fight such a massive righteous war is not a matter for crying, but a matter of supreme, exceptional good fortune.
            Great warriors all over the world spend their entire lives praying for such a magnificent, noble cause to fight for, so that their lives gain ultimate meaning.
            Instead of weeping at such a magnificent opportunity, Arjuna should be immensely joyful and proud like a true hero that he has been specifically chosen by destiny to protect dharma.
            This powerful verse is a direct attempt to transform Arjuna's crippling depression into a feeling of supreme martial pride.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            अथ चेत्त्वमिमं धर्म्यं सङ्ग्रामं न करिष्यसि |
            ततः स्वधर्मं कीर्तिं च हित्वा पापमवाप्स्यसि || ३३ ||
        """.trimIndent(),
        hindi = """
            परंतु यदि तुम इस धर्म-युक्त संग्राम (न्याय के लिए हो रहे युद्ध) को नहीं करोगे...
            तो तुम अपने 'स्वधर्म' (क्षत्रिय के कर्तव्य) और अपनी महान 'कीर्ति' (यश) को खोकर केवल भयंकर पाप को ही प्राप्त करोगे।
            भगवान श्रीकृष्ण यहाँ अर्जुन के उस तर्क को पूरी तरह से पलट रहे हैं जिसमें अर्जुन ने कहा था कि 'युद्ध करने से पाप लगेगा'।
            श्रीकृष्ण एक बहुत बड़ा मनोवैज्ञानिक प्रहार करते हुए कहते हैं कि पाप युद्ध करने में नहीं, बल्कि इस 'धर्म-युद्ध' से भागने में है।
            जब एक डॉक्टर ऑपरेशन करने से डरकर भाग जाए, या एक पुलिस वाला अपराधी को पकड़ने से डर जाए, तो वह अहिंसा नहीं, बल्कि अपने कर्त्तव्य से गद्दारी है, जो कि एक पाप है।
            उसी तरह, समाज की रक्षा करना अर्जुन का स्वधर्म है। यदि वे भागते हैं, तो समाज अत्याचारियों के हवाले हो जाएगा, और उस विनाश का सारा पाप अर्जुन के सिर पर ही आएगा।
            इसके अलावा, अर्जुन ने अपने पराक्रम से पूरी दुनिया में एक महान योद्धा की 'कीर्ति' (Reputation) कमाई है।
            युद्ध से भागने पर वह सारी जीवन भर की कमाई हुई इज्जत और यश पल भर में मिट्टी में मिल जाएगा।
            अतः युद्ध से भागना न तो आध्यात्मिक रूप से सही है (क्योंकि इससे पाप लगेगा) और न ही सांसारिक रूप से (क्योंकि इससे बेइज्जती होगी)।
            भगवान अर्जुन को हर तरफ से घेर कर यह समझा रहे हैं कि युद्ध करना ही एकमात्र सही विकल्प है।
        """.trimIndent(),
        english = """
            If, however, you adamantly refuse to perform your religious duty of fighting this righteous war (Dharmya-sangramam)...
            then you will certainly incur massive sins for neglecting your prescribed duties (Sva-dharma) and thus completely lose your great reputation as a fighter.
            Lord Sri Krishna is completely and masterfully flipping Arjuna's previous argument upside down, where Arjuna had foolishly claimed that 'fighting will incur sin'.
            Sri Krishna delivers a massive psychological blow, declaring that the actual sin does not lie in fighting, but precisely in running away from this 'Dharma-yuddha' (Righteous War).
            When a surgeon runs away out of fear of performing an operation, or a cop runs away from stopping a criminal, it is not noble non-violence; it is pure treason against their duty, which is a massive sin.
            Similarly, protecting society from tyrants is Arjuna's supreme Sva-dharma. If he flees, society will be thrown to the wolves, and the horrific sin of that ensuing destruction will fall squarely on Arjuna's head.
            Furthermore, Arjuna has painstakingly built an unparalleled 'Kirti' (worldwide reputation and fame) as an invincible warrior through years of hard work.
            By running away like a coward, his entire life's earnings of respect and glory will turn to dust in a single second.
            Therefore, fleeing the war is neither spiritually correct (as it brings heavy sin) nor materially beneficial (as it brings extreme humiliation).
            The Lord is completely cornering Arjuna from all logical angles, proving that fighting is the absolute only correct option.
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            अकीर्तिं चापि भूतानि कथयिष्यन्ति तेऽव्ययाम् |
            सम्भावितस्य चाकीर्तिर्मरणादतिरिच्यते || ३४ ||
        """.trimIndent(),
        hindi = """
            लोग (सभी प्राणी) हमेशा के लिए तुम्हारी इस अपकीर्ति (निंदा और बदनामी) का वर्णन करेंगे।
            और एक सम्मानित (सम्भावितस्य) व्यक्ति के लिए इस प्रकार की बदनामी मृत्यु से भी बढ़कर भयंकर होती है।
            यह श्लोक एक महान और सम्मानित व्यक्ति के मनोविज्ञान (Psychology) का अत्यंत गहरा विश्लेषण करता है।
            अर्जुन को लगता था कि युद्ध छोड़कर जंगल चले जाने से लोग उन्हें एक महान 'त्यागी' या 'संन्यासी' मानेंगे।
            लेकिन भगवान इस गलतफहमी को दूर करते हुए कहते हैं कि दुनिया तुम्हें त्यागी नहीं, बल्कि एक 'भगोड़ा' और 'कायर' कहेगी।
            तुम्हारी यह बदनामी ('अकीर्ति') केवल आज तक सीमित नहीं रहेगी, बल्कि यह 'अव्ययाम्' (हमेशा रहने वाली) होगी—इतिहास हमेशा तुम्हें एक डरपोक क्षत्रिय के रूप में याद रखेगा।
            एक साधारण आदमी के लिए थोड़ी बेइज्जती सहना आसान हो सकता है, लेकिन जो व्यक्ति पूरे समाज में अपने शौर्य और चरित्र के लिए पूजा जाता हो ('सम्भावितस्य'), उसके लिए बदनामी का एक दाग भी मौत से बदतर होता है।
            शारीरिक मृत्यु तो केवल एक बार कष्ट देती है, लेकिन बदनामी इंसान को जीते जी हर दिन मारती है।
            श्रीकृष्ण अर्जुन के उस 'क्षत्रीय स्वाभिमान' (Warrior's Pride) को जगा रहे हैं जो मोह की भारी चादर के नीचे पूरी तरह से सो गया है।
            वे स्पष्ट चेतावनी दे रहे हैं कि तुम्हारा यह तथाकथित वैराग्य तुम्हारे पूरे जीवन के गौरव को नष्ट कर देगा।
        """.trimIndent(),
        english = """
            People will always endlessly speak of your infamy and terrible disgrace (Akirti) for all time to come.
            And for an individual who has been highly honored and respected (Sambhavitasya), such dishonor is infinitely worse than death itself.
            This highly profound verse provides an incredibly deep analysis of the psychology of a great, highly respected personality.
            Arjuna falsely believed that by dropping his weapons and running off to the forest, the world would praise him as a great 'renunciate' or 'saint'.
            But the Lord shatters this childish delusion, stating that the harsh world will absolutely not call you a saint; they will brand you a pathetic 'coward' and a 'deserter'.
            This infamy ('Akirti') will not just be limited to today; it will be 'Avyayam' (eternal)—history will forever remember and mock you as a timid warrior who panicked.
            For an ordinary man, bearing a little insult might be easy, but for a person who is universally worshipped for his unparalleled valor and character ('Sambhavitasya'), even a single stain of dishonor is far worse than physical death.
            Physical death only causes pain once, but public disgrace tortures and kills a proud man every single day while he is still alive.
            Sri Krishna is aggressively shaking awake Arjuna's 'Warrior's Pride', which has fallen deeply asleep under the heavy blanket of worldly attachment.
            He is issuing a very stark warning: this so-called fake renunciation of yours will completely permanently destroy the glory of your entire life.
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            भयाद्रणादुपरतं मंस्यन्ते त्वां महारथाः |
            येषां च त्वं बहुमतो भूत्वा यास्यसि लाघवम् || ३५ ||
        """.trimIndent(),
        hindi = """
            जिन महारथियों (जैसे दुर्योधन, कर्ण आदि) की दृष्टि में तुम अभी तक अत्यंत सम्मानित (बहुमतः) थे, अब वे तुम्हें तुच्छ (लाघवम्) समझने लगेंगे।
            वे सभी यही मानेंगे कि तुम अपने संबंधियों के प्रति दया के कारण नहीं, बल्कि अपनी जान के डर (भयात्) से युद्धभूमि से भाग गए हो।
            अर्जुन का एक तर्क यह था कि मैं अपने गुरुओं और भाइयों पर दया कर रहा हूँ, इसलिए हथियार डाल रहा हूँ।
            श्रीकृष्ण अर्जुन के इस 'दया' के गुब्बारे की हवा निकालते हुए दुनिया की कड़वी सच्चाई (Harsh Reality) सामने रखते हैं।
            वे कहते हैं कि तुम चाहे अपने मन में इसे कितनी भी महान 'दया' या 'त्याग' का नाम दे दो, लेकिन तुम्हारे शत्रु इसे दया नहीं मानेंगे।
            कर्ण और दुर्योधन जैसे महारथी, जो हमेशा तुमसे खौफ खाते थे और तुम्हारी वीरता का सम्मान करते थे, वे सोचेंगे कि अर्जुन मौत के डर ('भयात्') से भाग गया।
            समाज हमेशा लोगों के कार्यों (Actions) को देखता है, उनके पीछे की भावनाओं (Intentions) को नहीं। एक क्षत्रिय का मैदान छोड़ना हमेशा कायरता ही माना जाता है।
            और जब तुम्हारे ही शत्रु तुम्हें एक डरपोक मानकर तुम्हारी खिल्ली उड़ाएंगे, तो वह स्थिति तुम्हारे लिए अत्यंत अपमानजनक और तुच्छ ('लाघवम्') होगी।
            भगवान अर्जुन को यह समझा रहे हैं कि युद्ध से हटने पर न तो उन्हें पुण्य मिलेगा और न ही सम्मान, बल्कि केवल और केवल उपहास (Mockery) ही मिलेगा।
        """.trimIndent(),
        english = """
            The great generals and warriors (Maharathas) who have highly esteemed your name and fame will now think that you have left the battlefield entirely out of sheer fear (Bhayat).
            And thus, you will be considered extremely insignificant and completely lose your great respect in the eyes of those who previously thought very highly of you.
            One of Arjuna's primary arguments was that he was dropping his weapons out of profound 'compassion' for his teachers and brothers.
            Sri Krishna aggressively punctures this balloon of 'compassion' by presenting the extremely harsh and bitter reality of how the world actually works.
            He bluntly states that no matter how much you internally label your action as great 'mercy' or 'renunciation', your brutal enemies will absolutely never interpret it that way.
            Great, arrogant warriors like Karna and Duryodhana, who have always secretly feared you and respected your martial prowess, will simply conclude that Arjuna ran away purely terrified of death ('Bhayat').
            Society always judges people strictly by their external actions, almost never by their internal emotional intentions. A Kshatriya abandoning a battlefield is universally branded as a coward.
            And when your very own bitter enemies mock you and treat you as a frightened weakling, that situation will be unimaginably humiliating and degrading ('Laghavam') for you.
            The Lord is making Arjuna realize that retreating from this war will bring him neither spiritual merit nor worldly respect; it will only invite endless, brutal mockery.
        """.trimIndent()
    ),
    Shloka(
        id = 36,
        sanskrit = """
            अवाच्यवादांश्च बहून्वदिष्यन्ति तवाहिताः |
            निन्दन्तस्तव सामर्थ्यं ततो दुःखतरं नु किम् || ३६ ||
        """.trimIndent(),
        hindi = """
            तुम्हारे शत्रु (अहिताः) तुम्हारे शौर्य और सामर्थ्य की घोर निंदा करते हुए ऐसे-ऐसे बुरे शब्द (अवाच्यवादान्) कहेंगे, जो कहने लायक भी नहीं हैं।
            भला उस अपमान से बढ़कर तुम्हारे लिए और अधिक दुःख की बात क्या हो सकती है?
            भगवान श्रीकृष्ण यहाँ अर्जुन के मानस पटल पर एक अत्यंत कष्टदायक चित्र (Visual) खींच रहे हैं।
            वे कहते हैं कि जब तुम पीठ दिखाकर भागोगे, तो दुर्योधन और कर्ण जैसे तुम्हारे दुश्मन चुप नहीं बैठेंगे।
            वे तुम्हारे पराक्रम और गांडीव धनुष का सरेआम मज़ाक उड़ाएंगे। वे ऐसी गंदी और नीच बातें ('अवाच्यवादान्') कहेंगे जो एक सच्चे क्षत्रिय के कानों के लिए पिघले हुए सीसे के समान होंगी।
            वे कहेंगे कि "अर्जुन तो केवल बातों का वीर था, जब असल युद्ध की बारी आई तो वह नपुंसक की तरह रोने लगा।"
            श्रीकृष्ण अर्जुन से सीधे पूछते हैं: "तुम्हारे जैसे स्वाभिमानी और विश्व-विजेता योद्धा के लिए, अपने ही दुश्मनों से अपनी शक्ति पर ऐसे ताने सुनने से बड़ा दुःख और क्या हो सकता है?"
            अर्जुन जो युद्ध को सबसे बड़ा दुःख मान रहे थे, भगवान उन्हें बता रहे हैं कि युद्ध से भागने के बाद मिलने वाला मानसिक प्रताड़ना (Torture) युद्ध के दुःख से करोड़ों गुना बड़ा होगा।
            यह मनोवैज्ञानिक उपचार (Psychological Therapy) अर्जुन के सोए हुए क्षत्रिय खून को पूरी तरह से खौलाने के लिए किया जा रहा है।
        """.trimIndent(),
        english = """
            Your enemies (Ahitah) will relentlessly describe you in many unkind, unspeakable words (Avachya-vadan), harshly scorning and mocking your great ability and valor.
            What could possibly be more painful and devastatingly sorrowful for you than experiencing such brutal degradation?
            Lord Sri Krishna is painting an extremely agonizing and vivid mental picture inside Arjuna's mind right here.
            He tells him that when you turn your back and run away like a coward, vicious enemies like Duryodhana and Karna are not just going to sit quietly.
            They will publicly and ruthlessly mock your past victories and your legendary Gandiva bow. They will hurl such foul, unspeakable insults ('Avachya-vadan') that will burn the ears of a true Kshatriya like molten lead.
            They will arrogantly proclaim, "Arjuna was merely a hero in his big talk; when the actual war arrived, he started weeping like an impotent coward."
            Sri Krishna directly asks Arjuna: "For a fiercely proud, world-conquering warrior like you, what could possibly be a greater agony than hearing your own enemies brutally ridicule your strength?"
            Arjuna was considering the war to be the ultimate sorrow; the Lord is forcefully making him realize that the mental torture and humiliation he will suffer after escaping will be a million times more painful than the war itself.
            This intense psychological therapy is being masterfully applied to completely boil Arjuna's dormant Kshatriya blood and shatter his illusion.
        """.trimIndent()
    ),
    Shloka(
        id = 37,
        sanskrit = """
            हतो वा प्राप्स्यसि स्वर्गं जित्वा वा भोक्ष्यसे महीम् |
            तस्मादुत्तिष्ठ कौन्तेय युद्धाय कृतनिश्चयः || ३७ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र! यदि तुम इस युद्ध में मारे गए, तो सीधे स्वर्ग को प्राप्त करोगे; और यदि तुम जीत गए, तो इस पृथ्वी के विशाल राज्य का सुख भोगोगे।
            इसलिए हे अर्जुन! हर तरह से अपना लाभ देखकर, युद्ध करने का दृढ़ निश्चय करके उठ खड़े हो जाओ।
            भगवान श्रीकृष्ण अब एक बहुत ही स्पष्ट, तार्किक और "Win-Win" (हर हाल में जीत) वाली स्थिति अर्जुन के सामने रख रहे हैं।
            वे कहते हैं कि क्षत्रिय के लिए धर्म-युद्ध में केवल दो ही परिणाम संभव हैं, और दोनों ही अत्यंत शानदार हैं।
            पहला: यदि तुम लड़ते हुए वीरगति (शहादत) को प्राप्त होते हो, तो धर्म की रक्षा में प्राण देने के कारण तुम्हें देवताओं का स्वर्ग मिलेगा, जहाँ अनंत सुख है।
            दूसरा: यदि तुम अपने दुश्मनों को हराकर विजयी होते हो, तो तुम्हें इस पूरी पृथ्वी का एकछत्र राज्य और अपार सांसारिक सुख मिलेगा।
            चूँकि दोनों ही परिणामों में अर्जुन का केवल और केवल फायदा ही है, इसलिए युद्ध से भागने का विचार पूरी तरह से मूर्खतापूर्ण और अतार्किक (Illogical) है।
            श्रीकृष्ण एक बहुत ही शक्तिशाली कमांड (Command) देते हैं: "तस्मादुत्तिष्ठ... युद्धाय कृतनिश्चयः" (इसलिए, युद्ध करने का पक्का इरादा करके उठो)।
            यह केवल एक शारीरिक उठना नहीं है, बल्कि यह अर्जुन की चेतना (Consciousness) को अज्ञान और निराशा के अंधकार से बाहर निकालने का स्पष्ट आदेश है।
            यहाँ तक भगवान ने अर्जुन को सामाजिक, लौकिक और तार्किक दृष्टिकोण से समझाया है; इसके बाद वे निष्काम कर्मयोग का महान सिद्धांत बताएंगे।
        """.trimIndent(),
        english = """
            O son of Kunti! Either you will be killed on this battlefield and immediately attain the heavenly planets, or you will conquer your enemies and enjoy the earthly kingdom.
            Therefore, seeing your absolute benefit in both outcomes, stand up with a firm, unshakeable determination to fight.
            Lord Sri Krishna is now presenting a highly logical, crystal-clear, and absolute "Win-Win" scenario directly before Arjuna.
            He explains that for a noble Kshatriya fighting a righteous war, there are only two possible outcomes, and both of them are exceptionally glorious.
            First: If you are killed in action while fiercely fighting, because you laid down your life protecting dharma, you will bypass all rituals and instantly attain heaven, where infinite celestial joy awaits.
            Second: If you successfully slaughter your enemies and emerge victorious, you will become the undisputed emperor of this entire earth and enjoy massive material opulence.
            Since in both possible scenarios, Arjuna stands to gain immense and absolute benefit, the very thought of running away from the war is profoundly foolish and entirely illogical.
            Sri Krishna delivers a highly commanding, electrifying order: "Tasmad uttishtha... yuddhaya krita-nishchayah" (Therefore, stand up with a firm, rock-solid determination to fight).
            This is not merely a command to physically stand up; it is a supreme order to elevate his fallen consciousness out of the dark mud of despair and ignorance.
            Up to this specific verse, the Lord has appealed to Arjuna using social, material, and logical arguments; moving forward, He will introduce the supreme spiritual science of selfless action (Karma Yoga).
        """.trimIndent()
    ),
    Shloka(
        id = 38,
        sanskrit = """
            सुखदुःखे समे कृत्वा लाभालाभौ जयाजयौ |
            ततो युद्धाय युज्यस्व नैवं पापमवाप्स्यसि || ३८ ||
        """.trimIndent(),
        hindi = """
            सुख और दुःख, लाभ और हानि, तथा जीत और हार को पूरी तरह से एक समान (बराबर) समझकर...
            उसके बाद तुम युद्ध के लिए तैयार हो जाओ (युद्ध करो)। इस समभाव से कर्म करने पर तुम्हें कभी कोई पाप नहीं लगेगा।
            यह श्लोक पूरी भगवद्गीता के सबसे महान और मुख्य सिद्धांतों में से एक है—यहीं से 'निष्काम कर्मयोग' (Selfless Action) का बीज बोया जाता है।
            पिछले श्लोक में भगवान ने स्वर्ग या राज्य का लालच दिया था, जो भौतिक बुद्धि वाले लोगों के लिए था। लेकिन अर्जुन एक श्रेष्ठ आत्मा हैं, इसलिए अब भगवान उन्हें सर्वोच्च आध्यात्मिक रहस्य बता रहे हैं।
            वे कहते हैं कि युद्ध (या कोई भी कर्म) राज्य पाने के लालच से या हारने के डर से मत करो।
            जीत होगी या हार (जयाजयौ), फायदा होगा या नुकसान (लाभालाभौ), सुख मिलेगा या दुःख (सुखदुःखे)—इन सब द्वंद्वों (Dualities) को मन से पूरी तरह निकाल दो।
            जब तुम फल की आसक्ति (Attachment) को छोड़कर केवल 'कर्तव्य' समझकर धर्म की रक्षा के लिए लड़ोगे, तो वह कर्म दिव्य हो जाएगा।
            अर्जुन का सबसे बड़ा डर यही था कि "युद्ध करने से मुझे पाप लगेगा"। भगवान यहाँ उस डर की सबसे सटीक दवा दे रहे हैं।
            पाप कर्म में नहीं होता, पाप उस कर्म के पीछे छिपी हुई स्वार्थपरक भावना (Selfish Motive) में होता है।
            जब मन में कोई स्वार्थ, राग या द्वेष ही नहीं होगा, तो शरीर से भयंकर युद्ध करने पर भी इंसान पूरी तरह से पाप-मुक्त रहता है।
        """.trimIndent(),
        english = """
            Do thou fight for the absolute sake of fighting, without internally considering happiness or distress, loss or gain, victory or defeat.
            And by deeply engaging in your duty with this equal consciousness, you shall never incur any sinful reaction.
            This verse introduces one of the absolute greatest and most central doctrines of the entire Bhagavad Gita—the supreme seed of 'Nishkama Karma Yoga' (Selfless Action) is planted right here.
            In the previous verse, the Lord tempted Arjuna with heaven or a kingdom, which is meant for people with materialistic intelligence. But Arjuna is an advanced soul, so the Lord now reveals the highest spiritual secret.
            He commands Arjuna not to fight (or perform any action in life) out of the greedy desire to win a kingdom or the paralyzing fear of losing it.
            Victory or defeat (jayajayau), profit or loss (labhalabhau), happiness or distress (sukha-duhkhe)—you must completely eradicate the attachment to all these material dualities from your mind.
            When you completely drop the selfish attachment to the end result and fight purely for the sake of 'Duty' to protect dharma, that ordinary action instantly becomes divine and transcendental.
            Arjuna's absolute biggest fear was: "If I fight this bloody war, I will incur massive sin." The Lord provides the ultimate, perfect cure for that fear here.
            Sin does not exist in the physical action itself; sin exists purely in the selfish motive (attachment or hatred) hidden behind the action.
            When the mind is completely free from all selfishness and attachment, a person remains entirely sinless and pure, even while executing a terrifying world war with his physical body.
        """.trimIndent()
    ),
    Shloka(
        id = 39,
        sanskrit = """
            एषा तेऽभिहिता साङ्ख्ये बुद्धिर्योगे त्विमां शृणु |
            बुद्ध्या युक्तो यया पार्थ कर्मबन्धं प्रहास्यसि || ३९ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! अब तक मैंने तुम्हारे सामने यह ज्ञान 'सांख्य योग' (आत्मा और शरीर के ज्ञान) के दृष्टिकोण से वर्णित किया है।
            अब तुम इसी ज्ञान को 'कर्म योग' (निष्काम कर्म) के दृष्टिकोण से ध्यानपूर्वक सुनो; जिस बुद्धियोग (ज्ञान) से युक्त होकर तुम कर्मों के सारे बंधनों को हमेशा के लिए पूरी तरह काट दोगे।
            यहाँ से भगवद्गीता के उपदेश का गियर (Gear) बदलता है। भगवान अपने उपदेश को एक नए और अधिक व्यावहारिक (Practical) चरण में ले जा रहे हैं।
            'सांख्य योग' का अर्थ है विश्लेषण (Analytical Study)—जिसमें भगवान ने श्लोक 11 से 30 तक आत्मा (सदा रहने वाली) और शरीर (नष्ट होने वाले) के बीच का अंतर बहुत गहराई से समझाया था।
            सांख्य योग से अर्जुन को यह समझ आ गया कि आत्मा को मारा नहीं जा सकता, इसलिए शोक करना व्यर्थ है।
            लेकिन केवल ज्ञान ही काफी नहीं है, उस ज्ञान को जीवन में उतारना (Application) भी ज़रूरी है, जिसे 'बुद्धियोग' या 'कर्मयोग' कहा जाता है।
            भगवान अर्जुन को आश्वस्त कर रहे हैं कि मैं तुम्हें अब एक ऐसी शानदार तकनीक (Technique) सिखाने जा रहा हूँ, जिससे तुम दुनिया में रहकर सारे काम (युद्ध तक) करोगे, लेकिन उन कर्मों का फल तुम्हें बांध नहीं पाएगा।
            हर कर्म एक रस्सी (बंधन) की तरह इंसान को जन्म-मृत्यु के चक्र में बांधता है।
            लेकिन निष्काम कर्मयोग की यह विशेष 'बुद्धि' (चेतना) उस कर्म की रस्सी को ही जलाकर भस्म कर देती है, जिससे व्यक्ति परम स्वतंत्र (मुक्त) हो जाता है।
        """.trimIndent(),
        english = """
            O Partha! Thus far I have thoroughly described this supreme knowledge to you through analytical study (Sankhya Yoga).
            Now listen carefully as I explain it in terms of working without fruitive results (Karma Yoga/Buddhi Yoga); for when you act with such transcendental intelligence, you can free yourself completely from the bondage of all actions.
            From this exact verse, the primary gear of the Bhagavad Gita's discourse completely shifts. The Lord is transitioning His teachings into a highly active and practical phase.
            'Sankhya Yoga' means deep analytical study—where the Lord profoundly explained the absolute difference between the eternal soul and the temporary material body from verses 11 to 30.
            Through Sankhya, Arjuna intellectually understood that the soul simply cannot be killed, so weeping over the body is useless.
            But mere intellectual knowledge is never enough; the practical application of that knowledge in the battlefield of life is essential, which is termed 'Buddhi Yoga' or 'Karma Yoga'.
            The Lord is assuring Arjuna: I am now going to teach you an incredibly magnificent technique by which you will perform all heavy activities in this world (even a massive war), but the reactions of those actions will never entangle you.
            Every ordinary material action acts like a strong rope (bondage) that ties a human being to the endless cycle of birth and death.
            But this highly specific 'Buddhi' (transcendental consciousness) of selfless action completely burns down the very rope of karma to ashes, making the person absolutely and eternally free (liberated).
        """.trimIndent()
    ),
    Shloka(
        id = 40,
        sanskrit = """
            नेहाभिक्रमनाशोऽस्ति प्रत्यवायो न विद्यते |
            स्वल्पमप्यस्य धर्मस्य त्रायते महतो भयात् || ४० ||
        """.trimIndent(),
        hindi = """
            इस निष्काम कर्मयोग (बुद्धियोग) में किए गए किसी भी आरंभ (प्रयास) का कभी कोई नाश (नुकसान) नहीं होता, और न ही इसमें कोई उल्टा फल (प्रत्यवाय) मिलता है।
            बल्कि इस निष्काम धर्म का बहुत थोड़ा सा भी आचरण (अभ्यास) मनुष्य को जन्म-मृत्यु रूपी सबसे महान भय से हमेशा के लिए बचा लेता है।
            यह श्लोक 'निष्काम कर्मयोग' की असीमित महिमा और उसकी सबसे बड़ी सुरक्षा (Guarantee) का वर्णन करता है।
            भौतिक दुनिया में अगर हम कोई काम (जैसे व्यापार या पढ़ाई) बीच में छोड़ दें, तो हमारा सारा समय और पैसा बर्बाद (नाश) हो जाता है।
            और कई बार गलत काम करने से फायदा होने की बजाय उल्टा नुकसान (प्रत्यवाय / Side Effect) हो जाता है, जैसे गलत दवा खाने से बीमारी बढ़ जाती है।
            लेकिन भगवान पूर्ण गारंटी देते हैं कि ईश्वर को समर्पित करके किया गया कोई भी निस्वार्थ कर्म कभी ज़रा सा भी बर्बाद नहीं होता।
            अगर कोई इंसान आध्यात्मिक पथ पर चलना शुरू करे और किसी कारणवश (मृत्यु या भटकाव के कारण) उसे पूरा न कर पाए, तो भी उसका किया गया वह थोड़ा सा प्रयास उसके खाते (Spiritual Bank Account) में हमेशा के लिए जमा (Save) हो जाता है।
            अगले जन्म में वह व्यक्ति उसी बिंदु से अपनी यात्रा दोबारा शुरू करता है। इसमें कभी कोई 'माइनस मार्किंग' (Negative Result) नहीं होती।
            भगवान कहते हैं कि इस योग का थोड़ा सा भी अभ्यास (जैसे एक बार भी सच्चे मन से निष्काम कर्म करना) आत्मा को जीवन के सबसे बड़े डर—जन्म, मृत्यु और नरक के डर—से पूरी तरह मुक्त कर देता है।
        """.trimIndent(),
        english = """
            In this sublime endeavor of selfless action (Buddhi Yoga), there is absolutely no loss or diminution of any effort made, and there is zero adverse reaction (side-effect).
            Rather, even a very slight execution of this supreme religious practice can save a person completely from the greatest type of danger and fear.
            This spectacularly beautiful verse explicitly describes the limitless glories and the ultimate safety (Absolute Guarantee) of 'Nishkama Karma Yoga'.
            In the material world, if we start a project (like a business or a degree) and leave it halfway, our entire investment of time and money goes completely to waste (Nashah).
            And sometimes, doing things improperly causes a severe reverse reaction (Pratyavaya / Side-effects), just like taking the wrong medicine makes the disease much worse.
            But the Supreme Lord gives an absolute, ironclad guarantee that any selfless action performed as an offering to God is never, ever wasted, not even slightly.
            If a person begins the spiritual path but fails to complete it due to death or distraction, whatever tiny effort they made is permanently saved in their eternal 'Spiritual Bank Account'.
            In their next birth, that soul resumes its journey from that exact same point. There is absolutely zero 'negative marking' or backward slide on this path.
            The Lord powerfully declares that even a tiny fraction of practice of this yoga (like performing a completely selfless act even once) permanently saves the soul from the universe's most terrifying fear—the endless cycle of birth, death, and hellish suffering.
        """.trimIndent()
    ),
    Shloka(
        id = 41,
        sanskrit = """
            व्यवसायात्मिका बुद्धिरेकेह कुरुनन्दन |
            बहुशाखा ह्यनन्ताश्च बुद्धयोऽव्यवसायिनाम् || ४१ ||
        """.trimIndent(),
        hindi = """
            हे कुरुनन्दन (अर्जुन)! इस निष्काम कर्मयोग के मार्ग में दृढ़ निश्चय वाली (व्यवसायात्मिका) बुद्धि केवल एक ही होती है।
            परंतु जो लोग दृढ़ निश्चय वाले नहीं हैं (सकाम कर्मी हैं), उनकी बुद्धियां अनन्त शाखाओं (दिशाओं) वाली और बिखरी हुई होती हैं।
            भगवान श्रीकृष्ण यहाँ सफलता का सबसे बड़ा और सबसे अचूक मनोवैज्ञानिक रहस्य बता रहे हैं—'सिंगल-पॉइंटेड फोकस' (Single-pointed focus)।
            जब मनुष्य केवल ईश्वर की प्रसन्नता या अपने शुद्ध कर्तव्य के लिए काम करता है, तो उसका लक्ष्य बिलकुल स्पष्ट और एक (One) होता है।
            ऐसी चेतना को 'व्यवसायात्मिका बुद्धि' कहते हैं, जहाँ मन में कोई 'प्लान बी' (Plan B) या दुविधा नहीं होती; साधक एक लेज़र बीम की तरह केंद्रित होता है।
            इसके विपरीत, जो लोग भौतिक इच्छाओं (पैसा, नाम, स्वर्ग) के लिए काम करते हैं, उनका मन हमेशा हजारों दिशाओं (बहुशाखा) में भटकता रहता है।
            आज उन्हें यह चाहिए, कल कुछ और चाहिए; अगर एक इच्छा पूरी नहीं हुई तो वे तुरंत अपना रास्ता या अपना देवता बदल लेते हैं।
            ऐसा चंचल और विभाजित मन कभी भी ध्यान (समाधि) की अवस्था तक नहीं पहुँच सकता, और न ही जीवन में कोई महान आध्यात्मिक सिद्धि पा सकता है।
            अर्जुन का मन भी इस समय हजारों शंकाओं में बँटा हुआ है, इसलिए भगवान उन्हें अपनी बुद्धि को एक ही दिशा (कर्तव्य) में एकाग्र करने का आदेश दे रहे हैं।
        """.trimIndent(),
        english = """
            O beloved child of the Kurus (Arjuna)! Those who are on this path are highly resolute in purpose, and their aim is exactly one (Single-pointed intelligence).
            But the intelligence of those who are irresolute (driven by material desires) is scattered into many branches and is endlessly divided.
            Lord Sri Krishna is revealing the absolute greatest and most foolproof psychological secret of ultimate success here—'Single-pointed focus'.
            When a human being works solely for the pleasure of the Supreme or strictly for their righteous duty, their target is crystal clear and singular (One).
            Such a state of consciousness is called 'Vyavasayatmika Buddhi', where there is absolutely no confusing 'Plan B' in the mind; the seeker is focused like a laser beam.
            In strict contrast, those who work purely for material desires (money, fame, heaven) have their minds perpetually wandering in thousands of directions (Bahu-shakha).
            Today they intensely want this, tomorrow they crave something else; if one desire fails, they instantly change their entire path or even their worshipable deity.
            Such a flickering, restless, and completely divided mind can absolutely never reach the state of deep meditation (Samadhi), nor achieve any great spiritual perfection.
            Arjuna's mind is currently violently torn apart by thousands of doubts, so the Lord is commanding him to forcefully converge his intelligence in one single direction: his supreme duty.
        """.trimIndent()
    ),
    Shloka(
        id = 42,
        sanskrit = """
            यामिमां पुष्पितां वाचं प्रवदन्त्यविपश्चितः |
            वेदवादरताः पार्थ नान्यदस्तीति वादिनः || ४२ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ! जो लोग वेदों के केवल कर्मकांड वाले हिस्से में ही पूरी तरह रचे-पचे रहते हैं और कहते हैं कि "स्वर्ग और भोगों के अलावा जीवन में और कुछ है ही नहीं"...
            ऐसे कम बुद्धि वाले अज्ञानी (अविपश्चितः) लोग इस प्रकार की अत्यंत दिखावटी और फूल-पत्ती सी सजी हुई (पुष्पितां) बातें किया करते हैं।
            यह श्लोक उन लोगों पर बहुत बड़ा प्रहार है जो धर्म को केवल एक 'व्यापार' (Business) बना लेते हैं।
            वेदों में कई जगह ऐसे यज्ञों और पूजा-पाठ का वर्णन है जिन्हें करने से धन, पुत्र या स्वर्ग की प्राप्ति होती है (कर्मकांड)।
            जो लोग आध्यात्मिक रूप से अज्ञानी हैं, वे वेदों के इन लालच भरे वचनों को ही जीवन का परम लक्ष्य मान लेते हैं।
            श्रीकृष्ण इन मीठी-मीठी और लुभावनी बातों को 'पुष्पितां वाचं' (Flowery language) कहते हैं—यानी ऐसी बातें जो फूलों की तरह बाहर से तो बहुत सुंदर और आकर्षक दिखती हैं, लेकिन उनमें कोई फल (शाश्वत सत्य) नहीं होता।
            ऐसे लोग यह अहंकार पाल लेते हैं कि धर्म का मतलब केवल भगवान को रिश्वत (यज्ञ) देकर अपनी भौतिक इच्छाएं पूरी करवाना है, इसके आगे और कोई सत्य ('नान्यदस्तीति') नहीं है।
            भगवान अर्जुन को चेतावनी दे रहे हैं कि ऐसे कर्मकांडी और भौतिकवादी लोगों की बातों में आकर कभी भी अपने परम कर्तव्य (निष्काम कर्म) से मत भटकना।
            सच्चा धर्म स्वर्ग पाने के लिए नहीं, बल्कि परमात्मा से जुड़ने के लिए होता है।
        """.trimIndent(),
        english = """
            O Partha! Those who are entirely devoted to the fruitive sections of the Vedas and arrogantly declare that "There is absolutely nothing more to life than heavenly enjoyments"...
            such men with poor fund of knowledge (Avipashchitah) are very much attached to speaking such highly flowery, decorated language (Pushpitam Vacham).
            This verse is a massive, highly critical strike against those who completely turn religion into a mere transactional 'Business'.
            In the Vedas, there are many sections describing specific rituals and sacrifices that grant immense wealth, good progeny, or elevation to heaven (Karma-kanda).
            People who are spiritually ignorant falsely accept these tempting, reward-based verses as the absolute and ultimate goal of human life.
            Sri Krishna brilliantly terms these sweet, alluring promises as 'Pushpitam Vacham' (Flowery language)—meaning words that look extremely beautiful and attractive on the outside like flowers, but bear no actual eternal fruit (Truth).
            Such materialistic people develop the arrogant belief that religion merely means bribing God through rituals to fulfill their desires, and absolutely nothing higher exists ('nanyad astiti').
            The Lord is sternly warning Arjuna never to be derailed from his supreme duty (selfless action) by being seduced by the words of such ritualistic materialists.
            True religion is absolutely not meant for purchasing a ticket to heaven, but for completely reuniting the soul with the Supreme Lord.
        """.trimIndent()
    ),
    Shloka(
        id = 43,
        sanskrit = """
            कामात्मानः स्वर्गपरा जन्मकर्मफलप्रदाम् |
            क्रियाविशेषबहुलां भोगैश्वर्यगतिं प्रति || ४३ ||
        """.trimIndent(),
        hindi = """
            वे लोग पूरी तरह से सांसारिक कामनाओं (इच्छाओं) में डूबे रहते हैं (कामात्मानः) और स्वर्ग प्राप्ति को ही जीवन का सबसे बड़ा लक्ष्य (स्वर्गपरा) मानते हैं।
            वे भोग और ऐश्वर्य की प्राप्ति के लिए जन्म और कर्म का फल देने वाली अत्यंत जटिल और अनेक प्रकार की दिखावटी क्रियाओं (कर्मकांडों) का ही पालन करते हैं।
            यह पिछले श्लोक का ही विस्तार है। भगवान बता रहे हैं कि इच्छाओं के गुलाम लोग किस प्रकार धर्म का दुरुपयोग करते हैं।
            उनका पूरा जीवन केवल 'भोग' (Enjoyment) और 'ऐश्वर्य' (Power/Wealth) को बटोरने की अंधी दौड़ में बीत जाता है।
            वे स्वर्ग भी इसलिए जाना चाहते हैं ताकि वहां उन्हें अप्सराएं और अमृत मिल सके, न कि भगवान का प्रेम।
            ऐसे लोग धर्म के नाम पर बहुत ही जटिल और खर्चीले अनुष्ठान ('क्रियाविशेषबहुलां') करते हैं ताकि समाज में उनका रुतबा बढ़े।
            लेकिन प्रकृति का नियम बहुत कठोर है; ये यज्ञ और पुण्य उन्हें कुछ समय के लिए स्वर्ग तो भेज देते हैं, लेकिन पुण्य खत्म होते ही उन्हें फिर से इस मृत्युलोक में 'जन्म और कर्म' के चक्कर में गिरना पड़ता है।
            भगवान अर्जुन को समझा रहे हैं कि सकाम कर्म (Desire-based action) एक ऐसा जाल है जो कभी खत्म नहीं होता।
            स्वर्ग की चाहत भी एक तरह की सोने की जंजीर है, जो लोहे की जंजीर (नरक) की तरह ही आत्मा को बांध कर रखती है।
        """.trimIndent(),
        english = """
            Being completely full of desires for sense gratification (Kamatmanah), they consider elevation to heaven as the absolute supreme goal of life (Svarga-para).
            They engage in a multitude of highly complex, pompous rituals (Kriya-vishesha-bahulam) solely to attain immense wealth and enjoyment, which merely results in continuous good birth and fruitive actions.
            This is a direct continuation and expansion of the previous verse. The Lord is exposing exactly how people enslaved by desires utterly misuse religion.
            Their entire lifespan is completely wasted in a blind, pathetic race to accumulate maximum 'Bhoga' (Sensory Enjoyment) and 'Aishvarya' (Power and Opulence).
            They desire to go to heaven not out of love for God, but solely to enjoy celestial maidens (Apsaras) and drink nectar.
            Such people perform extremely complex, highly expensive, and showy rituals ('Kriya-vishesha-bahulam') in the name of religion, simply to inflate their ego and status in society.
            But the law of nature is brutally strict; these pious credits may temporarily send them to heaven, but once the balance is exhausted, they violently fall back into the cycle of 'birth and karma' on earth.
            The Lord is profoundly explaining to Arjuna that Karma-kanda (Desire-based action) is a terrifying trap that never ever ends.
            The lust for heaven is merely a chain made of pure gold, which binds the soul exactly as tightly as a chain made of black iron (hell).
        """.trimIndent()
    ),
    Shloka(
        id = 44,
        sanskrit = """
            भोगैश्वर्यप्रसक्तानां तयापहृतचेतसाम् |
            व्यवसायात्मिका बुद्धिः समाधौ न विधीयते || ४४ ||
        """.trimIndent(),
        hindi = """
            जिन लोगों का मन पूरी तरह से सांसारिक भोगों और ऐश्वर्य (धन-सत्ता) में अत्यंत आसक्त (डूबा हुआ) है...
            और उन वेदों की पुष्पित (दिखावटी) वाणियों द्वारा जिनका विवेक पूरी तरह से हर लिया गया है (अपहृतचेतसाम्), ऐसे लोगों के मन में परमात्मा की प्राप्ति के लिए दृढ़ निश्चय वाली बुद्धि (व्यवसायात्मिका बुद्धि) कभी उत्पन्न नहीं होती।
            यह श्लोक भौतिकवादी (Materialistic) जीवनशैली का सबसे कड़वा और स्पष्ट सत्य उजागर करता है।
            भगवान कहते हैं कि जब किसी इंसान का दिमाग 24 घंटे केवल पैसा कमाने, लक्ज़री (Luxury) गाड़ियाँ खरीदने और समाज में अपनी शक्ति (ऐश्वर्य) दिखाने में लगा रहता है...
            तो उसका 'चेतना' (Consciousness) या सोचने-समझने का स्तर पूरी तरह से अपहरण (Hijack) हो जाता है।
            ऐसे इंसान को अगर कोई बैठकर गीता का गहरा ज्ञान समझाए या ध्यान (समाधि) करने को कहे, तो वह कभी अपना मन एकाग्र नहीं कर पाएगा।
            ध्यान या समाधि के लिए एक शांत और स्थिर मन चाहिए, लेकिन एक भौतिकवादी इंसान का मन हमेशा नई इच्छाओं की आग में जलता रहता है।
            इसलिए, परमात्मा को पाने का जो दृढ़ संकल्प (व्यवसायात्मिका बुद्धि) है, वह कभी भी भोग-विलास में डूबे हुए इंसान के दिमाग में टिक ही नहीं सकता।
            अर्जुन को यह संदेश दिया जा रहा है कि यदि तुम्हें आध्यात्मिक शांति और युद्ध में सही निर्णय की शक्ति चाहिए, तो पहले अपने मन से विजय, राज्य और सत्ता की आसक्ति को निकाल फेंकना होगा।
        """.trimIndent(),
        english = """
            In the minds of those who are overly attached to material sense enjoyment and extreme opulence (Bhogaisvarya-prasaktanam)...
            and whose consciousness has been completely stolen away (Apahrita-chetasam) by such flowery words, the resolute determination (Vyavasayatmika Buddhi) for devotional service to the Supreme is absolutely never established.
            This verse ruthlessly exposes the most bitter and crystal-clear truth regarding a highly materialistic lifestyle.
            The Lord declares that when a human being's brain is occupied 24/7 purely with earning money, buying ultimate luxury, and showing off social power (Aishvarya)...
            his higher intelligence, conscience, and entirely spiritual 'Consciousness' are completely hijacked and paralyzed.
            If someone tries to teach such a heavily addicted person the profound wisdom of the Gita or asks them to meditate (Samadhi), they will absolutely never be able to focus their scattered mind.
            Deep meditation requires an exceptionally calm and steady mind, but a materialistic person's mind is constantly burning in the violent fire of never-ending desires.
            Therefore, the absolute, iron-clad determination (Vyavasayatmika Buddhi) required to attain God simply cannot survive for even a second in a brain drowned in hedonism.
            The profound message to Arjuna is that if he truly desires spiritual peace and the mental clarity to make the right decision in this war, he must first violently throw out his attachment to victory, kingdom, and power.
        """.trimIndent()
    ),
    Shloka(
        id = 45,
        sanskrit = """
            त्रैगुण्यविषया वेदा निस्त्रैगुण्यो भवार्जुन |
            निर्द्वन्द्वो नित्यसत्त्वस्थो निर्योगक्षेम आत्मवान् || ४५ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! वेदों का मुख्य विषय प्रकृति के तीनों गुणों (सत्त्व, रज और तम) से संबंधित कर्म और उनके फलों का वर्णन करना है।
            तुम इन तीनों गुणों से पूरी तरह ऊपर उठ जाओ (निस्त्रैगुण्य बनो)। सभी द्वंद्वों (सुख-दुःख) से मुक्त हो जाओ, हमेशा शुद्ध सत्त्वगुण में स्थित रहो, योग-क्षेम (चीजों को पाने और बचाने की चिंता) को छोड़ दो और पूरी तरह से आत्म-परायण (आत्मा में स्थित) बनो।
            यह गीता के सबसे क्रांतिकारी श्लोकों में से एक है। यहाँ भगवान श्रीकृष्ण अर्जुन को वेदों के साधारण कर्मकांडों (Rituals) से भी ऊपर उठने का सीधा आदेश दे रहे हैं।
            वे समझाते हैं कि प्रकृति तीन गुणों से बनी है: तमोगुण (आलस्य/अज्ञान), रजोगुण (अत्यधिक लालच/दौड़-धूप), और सत्त्वगुण (शांति/ज्ञान)।
            वेदों के अधिकांश हिस्से मनुष्यों को इन्हीं तीन गुणों के भीतर रहते हुए फल प्राप्त करने के तरीके बताते हैं।
            लेकिन कृष्ण कहते हैं कि एक श्रेष्ठ योगी को इस 'त्रैगुण्य' (Matrix of 3 modes) की कैद को तोड़कर इसके पार जाना होगा।
            उसे 'निर्द्वन्द्व' बनना होगा—यानी मान-अपमान, गर्मी-सर्दी सबसे अप्रभावित रहना होगा।
            सबसे महत्वपूर्ण बात, उसे 'योग-क्षेम' छोड़ना होगा। 'योग' का अर्थ है जो हमारे पास नहीं है उसे पाने की चिंता, और 'क्षेम' का अर्थ है जो हमारे पास है उसे बचाने की चिंता।
            जब इंसान अपने भविष्य की सारी चिंताएं ईश्वर पर छोड़ देता है और केवल अपनी आत्मा ('आत्मवान्') में संतुष्ट रहता है, तभी वह वास्तव में स्वतंत्र होता है।
        """.trimIndent(),
        english = """
            O Arjuna! The Vedas deal largely with the subject of the three modes of material nature (goodness, passion, and ignorance).
            You must transcend these three modes (become Nistraigunya). Be completely free from all dualities and from all anxieties for gain and safety (Yoga-kshema), and be established entirely in the eternal self.
            This is arguably one of the most highly revolutionary and paradigm-shifting verses in the Gita. Here, Lord Krishna is directly commanding Arjuna to rise even above the standard rituals of the holy Vedas.
            He explains that material nature consists entirely of three modes: Tamas (ignorance/laziness), Rajas (intense passion/greed), and Sattva (goodness/knowledge).
            The vast majority of the Vedas simply instruct humans on how to acquire material rewards while operating strictly within this exact matrix of three modes.
            But Krishna commands that an elite yogi must violently break out of this 'Traigunya' (Matrix of 3 modes) prison and completely transcend it.
            He must become 'Nirdvandva'—meaning absolutely unaffected by opposing dualities like honor-dishonor or heat-cold.
            Most importantly, he must abandon 'Yoga-kshema'. 'Yoga' means the burning anxiety to acquire what we don't have, and 'Kshema' means the constant fear of protecting what we already possess.
            When a human being completely surrenders all future anxieties to God and remains perfectly satisfied solely within his eternal soul ('Atmavān'), only then is he truly, eternally free.
        """.trimIndent()
    ),
    Shloka(
        id = 46,
        sanskrit = """
            यावानर्थ उदपाने सर्वतः सम्प्लुतोदके |
            तावान्सर्वेषु वेदेषु ब्राह्मणस्य विजानतः || ४६ ||
        """.trimIndent(),
        hindi = """
            सब ओर से पूरी तरह लबालब भरे हुए एक विशाल जलाशय (झील या नदी) के प्राप्त हो जाने पर, एक छोटे से कुएं (उदपाने) का मनुष्य के लिए जितना सा प्रयोजन (अर्थ) रह जाता है...
            ठीक उसी प्रकार, परम सत्य (परमात्मा) को जान लेने वाले एक आत्मज्ञानी ब्राह्मण के लिए सभी वेदों का भी केवल उतना ही सा प्रयोजन रह जाता है।
            श्रीकृष्ण एक अत्यंत सुंदर और सटीक उदाहरण के द्वारा आध्यात्मिक ज्ञान की सर्वोच्चता को सिद्ध कर रहे हैं।
            प्राचीन काल में लोग नहाने, पीने या कपड़े धोने के लिए अलग-अलग छोटे कुओं (उदपाने) का इस्तेमाल करते थे।
            लेकिन यदि अचानक से कोई विशाल, स्वच्छ और मीठे पानी से भरी हुई झील मिल जाए, तो उन सभी छोटे कुओं की कोई आवश्यकता नहीं रह जाती, क्योंकि झील अकेले ही कुओं के सारे काम पूरे कर देती है।
            यहाँ 'छोटे कुएं' वेदों के अलग-अलग कर्मकांड और अनुष्ठान हैं, जो इंसान को थोड़ी-थोड़ी भौतिक चीजें (धन, स्वर्ग) देते हैं।
            और 'विशाल जलाशय' साक्षात् परमात्मा का वह असीम ज्ञान और प्रेम है।
            जब कोई व्यक्ति (विजानतः ब्राह्मण) ध्यान और निष्काम कर्म के द्वारा सीधे ईश्वर को प्राप्त कर लेता है, तो वेदों के छोटे-छोटे कर्मकांडों से मिलने वाले सभी फल उसमें अपने आप समाहित हो जाते हैं।
            इसलिए, ईश्वर को पा लेना ही सारे शास्त्रों को पढ़ने का अंतिम लक्ष्य है; जो ईश्वर तक पहुँच गया, उसके लिए शास्त्रों के पन्ने पलटने की कोई आवश्यकता नहीं बचती।
        """.trimIndent(),
        english = """
            Whatever specific purposes are served by a small well (Udapane) can be served at once in all respects by a massive, all-pervading body of water (like a vast lake).
            Similarly, absolutely all the purposes of the entire Vedas are instantly and perfectly fulfilled for an enlightened Brahmana who knows the Supreme Absolute Truth.
            Sri Krishna is brilliantly proving the absolute supremacy of direct spiritual realization over mechanical rituals using a stunningly precise and beautiful analogy.
            In ancient times, villagers had to painstakingly use different small wells ('Udapane') for specific purposes like drinking, washing, or bathing.
            But if someone suddenly discovers a massive, incredibly pure, and overflowing freshwater lake, all those tiny wells instantly become completely useless, because the lake alone perfectly fulfills all those needs simultaneously.
            Here, the 'tiny wells' represent the various isolated rituals and sacrifices of the Vedas, which grant very limited, piecemeal material rewards (like money or a temporary trip to heaven).
            And the 'massive reservoir' represents the infinite, boundless knowledge and pure love of the Supreme Lord.
            When an enlightened seeker ('Vijanatah Brahmana') directly attains God through pure devotion and selfless action, all the tiny results of all Vedic rituals are automatically and instantly included within that realization.
            Therefore, directly attaining the Supreme Lord is the absolute ultimate purpose of reading any scripture; once the destination is reached, the map (scriptures) is no longer required.
        """.trimIndent()
    ),
    Shloka(
        id = 47,
        sanskrit = """
            कर्मण्येवाधिकारस्ते मा फलेषु कदाचन |
            मा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि || ४७ ||
        """.trimIndent(),
        hindi = """
            तुम्हारा अधिकार केवल अपने निर्धारित कर्म (Duty) को करने में ही है, उसके फलों (परिणामों) में तुम्हारा कोई अधिकार कभी नहीं है।
            तुम कभी भी स्वयं को अपने कर्मों के फलों का कारण (हेतु) मत मानो, और न ही कभी कर्म न करने (अकर्म या आलस्य) में तुम्हारी आसक्ति होनी चाहिए।
            यह पूरी भगवद्गीता का सबसे प्रसिद्ध, सबसे अधिक उद्धृत (Quoted) और सनातन धर्म का सबसे महान सूत्र (Formula) है।
            यह श्लोक चार बहुत ही स्पष्ट और अत्यंत शक्तिशाली कमांड्स (Commands) देता है:
            १. 'कर्मण्येवाधिकारस्ते': तुम्हारा कंट्रोल केवल तुम्हारे एक्शन (प्रयास) पर है। तुम पूरी ईमानदारी से युद्ध (या कोई भी काम) कर सकते हो।
            २. 'मा फलेषु कदाचन': रिज़ल्ट (जीत या हार, पास या फेल) पर तुम्हारा 0% कंट्रोल है। रिज़ल्ट हज़ारों अन्य कारकों (प्रकृति, समय) पर निर्भर करता है, इसलिए उस पर अपना अधिकार मत जताओ।
            ३. 'मा कर्मफलहेतुर्भूर्': जब रिज़ल्ट अच्छा आए, तो अहंकार मत करो कि "यह मेरी वजह से हुआ", क्योंकि तुम केवल एक माध्यम हो।
            ४. 'मा ते सङ्गोऽस्त्वकर्मणि': सबसे बड़ा खतरा यह है कि रिज़ल्ट की गारंटी न देखकर इंसान आलसी हो जाए और काम ही न करे। भगवान चेतावनी देते हैं कि फल से विरक्त होना है, काम से नहीं। तुम्हें 100% ऊर्जा के साथ अपना कर्तव्य निभाना ही होगा।
            यह श्लोक इंसान को रिज़ल्ट की भयंकर एंग्ज़ायटी (Anxiety) से पूरी तरह मुक्त करके उसे एक 'सुपर-परफॉर्मर' (Super-performer) बना देता है।
        """.trimIndent(),
        english = """
            You have a right only to perform your prescribed duty (Karma), but you absolutely never have any right to the fruits of your actions (Results).
            Never consider yourself to be the ultimate cause of the results of your activities, and never let yourself be attached to inaction (Akarma/Laziness).
            This is undisputedly the most famous, most heavily quoted verse in the entire Bhagavad Gita, and the absolute greatest master-formula of Sanatana Dharma.
            This single, legendary verse delivers four incredibly clear and terrifyingly powerful commands:
            1. 'Karmany evadhikaras te': Your absolute jurisdiction and control lies ONLY in executing your action (effort). You can only put in 100% honest work.
            2. 'Ma phaleshu kadachana': You have exactly 0% control over the final result (success/failure). Results depend on millions of cosmic factors (time, destiny, nature), so completely drop your false claim over them.
            3. 'Ma karma-phala-hetur bhur': When an amazing result occurs, never let the ego falsely claim "I am the creator of this success", because you are merely a tiny instrument of nature.
            4. 'Ma te sango 'stv akarmani': The most dangerous trap is thinking, "If I don't get the result, why should I even work?" The Lord issues a strict warning: Detach from the result, but NEVER attach yourself to laziness or inaction. You MUST perform your duty fiercely.
            This flawless formula completely liberates a human being from the paralyzing, toxic anxiety of the future, instantly transforming them into an incredibly fearless 'Super-performer'.
        """.trimIndent()
    ),
    Shloka(
        id = 48,
        sanskrit = """
            योगस्थः कुरु कर्माणि सङ्गं त्यक्त्वा धनञ्जय |
            सिद्ध्यसिद्ध्योः समो भूत्वा समत्वं योग उच्यते || ४८ ||
        """.trimIndent(),
        hindi = """
            हे धनञ्जय (अर्जुन)! तू आसक्ति (स्वार्थ और लगाव) को पूरी तरह त्याग कर, और कार्य की सिद्धि (सफलता) और असिद्धि (विफलता) में पूरी तरह समान (समभाव) रहकर...
            योग में स्थित (योगस्थः) होकर अपना कर्तव्य कर्म कर। इस प्रकार सफलता-विफलता में मन का यह 'समत्व' (समान रहना) ही वास्तव में 'योग' कहलाता है।
            पिछले श्लोक में भगवान ने फल की इच्छा छोड़ने को कहा था, इस श्लोक में वे उस सिद्धांत को लागू करने का व्यावहारिक (Practical) तरीका बता रहे हैं।
            वे कहते हैं कि किसी भी काम को करते समय मन की स्थिति 'योगस्थ' होनी चाहिए।
            यहाँ 'योग' का मतलब सिर के बल खड़े होना या सांस रोकना नहीं है; श्रीकृष्ण योग की सबसे सुंदर और सटीक परिभाषा (Definition) दे रहे हैं: "समत्वं योग उच्यते"।
            अर्थात्, जब काम का रिज़ल्ट बहुत अच्छा (सिद्धि) आए तो खुशी से पागल न होना, और जब रिज़ल्ट बहुत बुरा (असिद्धि) आए तो डिप्रेशन में न जाना। दोनों ही स्थितियों में मन को एक शांत झील की तरह स्थिर (Balanced) रखना ही सच्चा योग है।
            यह स्थिरता तभी आ सकती है जब हम काम से जुड़ी सारी आसक्ति ('सङ्गं')—जैसे नाम, पैसा या अहंकार—को पूरी तरह से त्याग दें।
            एक योगी की तरह कर्म करने का अर्थ है कि बाहर से तुम एक भयंकर युद्ध लड़ रहे हो, लेकिन भीतर से तुम इतने शांत हो कि तुम्हारी हृदय की धड़कन तक नहीं बढ़ती।
        """.trimIndent(),
        english = """
            O Dhananjaya (Arjuna)! Perform your duty strictly while being situated in Yoga (Yogasthah), completely abandoning all false attachment (Sangam)...
            and remaining absolutely perfectly equal in both success (Siddhi) and failure (Asiddhi). Such impeccable equanimity and perfect balance of mind is called 'Yoga'.
            In the previous verse, the Lord commanded giving up the desire for fruits; in this verse, He provides the highly practical, real-world technique for executing that principle.
            He commands that while executing any action, the exact state of the mind must be 'Yogasthah' (established in Yoga).
            Here, 'Yoga' absolutely does not mean standing on your head or holding your breath; Sri Krishna is giving the most beautiful, precise psychological definition of Yoga: "Samatvam Yoga Uchyate".
            Meaning: When the result is a massive success (Siddhi), do not go crazy with arrogant euphoria, and when it is a devastating failure (Asiddhi), do not collapse into clinical depression. Keeping the mind as flawlessly balanced and perfectly calm as a still lake in both extremes is true Yoga.
            This unshakable stability can only be achieved when we completely slaughter all toxic attachments ('Sangam')—like the craving for fame, money, or ego validation—connected to the work.
            Working like a true Yogi means that outwardly you are aggressively fighting a terrifying world war, but inwardly you are so profoundly peaceful that even your heart rate remains completely undisturbed.
        """.trimIndent()
    ),
    Shloka(
        id = 49,
        sanskrit = """
            दूरेण ह्यवरं कर्म बुद्धियोगाद्धनञ्जय |
            बुद्धौ शरणमन्विच्छ कृपणाः फलहेतवः || ४९ ||
        """.trimIndent(),
        hindi = """
            हे धनञ्जय! इस समत्व-रूप बुद्धियोग (निष्काम कर्म) की तुलना में, सकाम कर्म (फल की इच्छा से किए गए काम) अत्यंत ही निम्न कोटि के (अवरं) और बहुत दूर (नीचे) हैं।
            इसलिए, तुम इस समत्व बुद्धि (ईश्वर चेतना) की ही शरण ग्रहण करो। क्योंकि जो लोग केवल कर्म के फलों (रिज़ल्ट्स) के लिए ही काम करते हैं, वे अत्यंत कंजूस (कृपण) और दयनीय हैं।
            भगवान श्रीकृष्ण यहाँ निष्काम कर्म की श्रेष्ठता को बहुत ही कड़े शब्दों में स्थापित कर रहे हैं।
            वे कहते हैं कि जो इंसान केवल पैसे, प्रमोशन या स्वर्ग के लालच में दिन-रात गधों की तरह मेहनत करता है ('अवरं कर्म'), उसका काम आध्यात्मिक दृष्टिकोण से बहुत ही निचले और घटिया स्तर का है।
            इसके विपरीत, जो व्यक्ति अपने काम को भगवान की सेवा समझकर बिना किसी स्वार्थ के करता है ('बुद्धियोग'), उसका काम सबसे सर्वोच्च और पवित्र है।
            श्रीकृष्ण सकाम कर्मियों (Selfish workers) के लिए एक बहुत ही तीखा शब्द इस्तेमाल करते हैं: 'कृपण' (कंजूस या दयनीय)।
            कंजूस वह व्यक्ति है जिसके पास बहुत संपत्ति है, लेकिन वह उसका सही उपयोग नहीं करता।
            उसी तरह, जो इंसान अपना यह अनमोल मानव जीवन (जिससे वह मोक्ष पा सकता था) केवल छोटी-छोटी भौतिक इच्छाओं और रिज़ल्ट्स की टेंशन में बर्बाद कर देता है, वह ब्रह्मांड का सबसे बड़ा कंजूस और मूर्ख है।
            इसलिए भगवान अर्जुन से कहते हैं कि अपनी चेतना (बुद्धि) को ऊंचा उठाओ और केवल दिव्य समभाव की ही शरण लो।
        """.trimIndent(),
        english = """
            O Dhananjaya! Action performed with a desire for fruitive results is undeniably far, far inferior (Avaram) to the action performed in this supreme consciousness (Buddhi-yoga).
            Therefore, you must absolutely seek perfect refuge in this transcendental consciousness. Because those who work purely for the sake of enjoying the fruits of their labor are extremely miserly and pathetic (Kripanah).
            Lord Sri Krishna is establishing the absolute, undeniable supremacy of selfless action (Nishkama Karma) using incredibly strong and harsh vocabulary here.
            He declares that a person who tirelessly works day and night like a donkey purely out of the greedy lust for money, promotion, or heavenly rewards ('Avaram karma') is performing work of an extremely low, degraded, and inferior caliber.
            In strict contrast, the person who executes their duty as a pure offering to the Lord, completely devoid of selfishness ('Buddhi-yoga'), elevates their work to the highest, most sacred dimension.
            Sri Krishna uses a highly piercing, insulting word for selfish, outcome-driven workers: 'Kripana' (miserly, pathetic, or wretched).
            A classic miser is someone who hoards massive wealth but refuses to utilize it properly.
            Similarly, a human being who completely wastes this priceless, exceedingly rare human life (which is meant for attaining eternal Moksha) merely sweating over petty material desires and the toxic anxiety of results is the biggest miser and fool in the entire universe.
            Therefore, the Lord commands Arjuna to forcefully elevate his intelligence and take absolute refuge only in this divine, balanced consciousness.
        """.trimIndent()
    ),
    Shloka(
        id = 50,
        sanskrit = """
            बुद्धियुक्तो जहातीह उभे सुकृतदुष्कृते |
            तस्माद्योगाय युज्यस्व योगः कर्मसु कौशलम् || ५० ||
        """.trimIndent(),
        hindi = """
            समत्व-बुद्धि से युक्त (बुद्धियुक्त) मनुष्य इसी जन्म में किए गए अपने पुण्य (सुकृत) और पाप (दुष्कृत) दोनों को ही पूरी तरह त्याग देता है (उनसे मुक्त हो जाता है)।
            इसलिए, तुम इसी समत्व-रूप योग में लग जाओ। क्योंकि कर्मों में यह जो कुशलता (कौशलम्) है—अर्थात् बंधन में न फँसते हुए कर्म करना—यही वास्तव में 'योग' है।
            यह श्लोक 'कर्म के विज्ञान' (Science of Karma) का एक अत्यंत गहरा रहस्य खोलता है।
            साधारण इंसान हमेशा इसी उलझन में रहता है कि "मैं अच्छे (पुण्य) कर्म करूँ ताकि मुझे सुख मिले, और बुरे (पाप) कर्मों से बचूँ ताकि दुःख न मिले।"
            लेकिन भगवान समझाते हैं कि आध्यात्मिक दृष्टि से 'पाप' लोहे की जंजीर है और 'पुण्य' सोने की जंजीर है; दोनों ही आत्मा को संसार में बांधती हैं और पुनर्जन्म का कारण बनती हैं।
            लेकिन जो 'बुद्धियुक्त' (निष्काम कर्मयोगी) है, वह इसी जन्म में पाप और पुण्य दोनों के खातों को हमेशा के लिए ज़ीरो (Zero) कर देता है।
            जब वह किसी फल की इच्छा ही नहीं रखता, तो प्रकृति उसे कोई फल (सुख या दुःख) दे ही नहीं सकती।
            इसीलिए श्रीकृष्ण कहते हैं: "योगः कर्मसु कौशलम्"—योग कोई काम छोड़कर भागना नहीं है, बल्कि संसार के बीच रहकर, सारे काम करते हुए भी कर्म के बंधनों से पूरी तरह अछूता रहना ही कार्यों में सच्ची 'कुशलता' (Skill/Art) है।
            अर्जुन को यही 'स्किल' (Skill) सीखनी है कि वे युद्ध के मैदान में लाखों तीर चलाएं, लेकिन एक भी तीर का पाप या पुण्य उनके आध्यात्मिक खाते में जमा न हो।
        """.trimIndent(),
        english = """
            A man engaged in devotional, unattached consciousness (Buddhi-yukto) perfectly rids himself of both good actions (Punya) and bad actions (Papa) even in this very life.
            Therefore, strive relentlessly for this Yoga (of equanimity). Because this supreme art of working expertly without getting entangled (Kaushalam) is precisely what 'Yoga' truly is.
            This majestic verse unlocks an incredibly profound, ultimate secret regarding the exact 'Science of Karma'.
            An ordinary, ignorant human is constantly trapped in the primitive calculation: "I must do good deeds (Punya) to enjoy happiness, and aggressively avoid bad deeds (Papa) to escape pain."
            But the Supreme Lord explains that from the ultimate spiritual perspective, 'Papa' is a rusty iron chain and 'Punya' is a glittering gold chain; yet both identically bind the eternal soul to this material world, forcing continuous rebirth.
            However, the 'Buddhi-yuktah' (the selfless Karma Yogi) completely incinerates and zeroes out both his good and bad karmic bank accounts permanently, right in this very lifetime.
            Because he holds absolutely zero desire for the fruit, the material matrix simply cannot force any reaction (joy or suffering) upon him.
            Hence, Sri Krishna delivers another legendary definition: "Yogah karmasu kaushalam"—Yoga is absolutely not escaping to the mountains; rather, standing right in the chaotic center of the world, flawlessly executing every intense action, yet remaining completely untouched by the karmic spiderweb, is the true 'Master Skill' (Kaushalam) of action.
            This is the exact 'Skill' Arjuna must urgently learn: how to violently fire millions of arrows on the battlefield without a single drop of sin or merit ever staining his eternal soul.
        """.trimIndent()
    ),
    Shloka(
        id = 51,
        sanskrit = """
            कर्मजं बुद्धियुक्ता हि फलं त्यक्त्वा मनीषिणः |
            जन्मबन्धविनिर्मुक्ताः पदं गच्छन्त्यनामयम् || ५१ ||
        """.trimIndent(),
        hindi = """
            क्योंकि इस समत्व-बुद्धि से युक्त जो ज्ञानी महापुरुष (मनीषिणः) हैं, वे कर्मों से उत्पन्न होने वाले फलों को पूरी तरह त्याग कर...
            जन्म-मृत्यु के भयानक बंधन से हमेशा के लिए मुक्त हो जाते हैं, और उस परम पद (मोक्ष/वैकुंठ) को प्राप्त करते हैं जहाँ कोई भी दुःख या रोग (अनामयम्) नहीं है।
            यह श्लोक निष्काम कर्मयोग का अंतिम और सबसे बड़ा इनाम (Final Reward) बताता है।
            भगवान स्पष्ट करते हैं कि हमारे दुःखों की जड़ क्या है? हमारे दुःखों की जड़ है 'जन्म लेना'। जो जन्म लेगा, उसे बीमारी, बुढ़ापा और मृत्यु का दुःख भोगना ही पड़ेगा।
            और जन्म क्यों होता है? हमारे कर्मों के फलों (Karma Phala) को भोगने के लिए।
            जब कोई ज्ञानी ('मनीषी') कर्म तो करता है लेकिन उसके फलों को पूरी तरह से भगवान को सौंप देता है (त्याग देता है), तो प्रकृति के पास उसे वापस इस दुनिया में भेजने का कोई कारण (Balance) नहीं बचता।
            फलस्वरूप, ऐसा योगी 'जन्मबंधविनिर्मुक्ताः' हो जाता है—अर्थात् पुनर्जन्म के उस चक्रव्यूह (Matrix) से हमेशा के लिए आज़ाद हो जाता है जिसमें पूरी दुनिया फंसी हुई है।
            और आज़ाद होकर वह कहाँ जाता है? वह भगवान के उस परम धाम (अनामयम् पदम्) में प्रवेश करता है, जहाँ न कोई मानसिक तनाव है, न कोई शारीरिक बीमारी है, और न ही कोई मृत्यु है।
            भगवान अर्जुन को समझा रहे हैं कि युद्ध से भागकर तुम मृत्यु से नहीं बच सकते, लेकिन निष्काम भाव से युद्ध करके तुम मृत्यु के चक्र (जन्म-मरण) को हमेशा के लिए तोड़ सकते हो।
        """.trimIndent(),
        english = """
            Because by engaging in such unalloyed devotional consciousness, the great sages and wise men (Manishinah) completely completely surrender the results born of their actions.
            And by doing so, they become permanently liberated from the terrifying bondage of birth and death, and perfectly attain that supreme state (Moksha/Vaikuntha) which is entirely free from all miseries (Anamayam).
            This spectacular verse vividly describes the absolute, ultimate, and supreme 'Final Reward' of mastering Nishkama Karma Yoga.
            The Lord brilliantly clarifies the root fundamental cause of all human suffering. What is it? It is simply the act of 'Taking Birth'. Whoever takes a physical birth must inevitably suffer the brutal tortures of disease, old age, and death.
            And exactly why do we take birth? Simply to experience the pending reactions (fruits) of our past actions (Karma Phala).
            When an enlightened sage ('Manishi') performs intense action but flawlessly and completely surrenders all the results (fruits) to the Supreme Lord, the material nature has absolutely zero residual reason (Karmic Balance) to force him back into this material world.
            As a direct consequence, such an elite Yogi becomes 'Janma-bandha-vinirmuktah'—meaning he permanently breaks out of the horrific, endless Matrix of reincarnation that traps the entire world.
            And where does he go upon escaping? He effortlessly enters the supreme, eternal abode of the Lord (Anamayam Padam), an absolute dimension where there is zero mental anxiety, zero physical disease, and absolutely no death.
            The Lord is profoundly explaining to Arjuna: You cannot escape physical death by running away from the war like a coward, but by fighting this war selflessly, you can permanently shatter the very cycle of death and birth itself.
        """.trimIndent()
    ),
    Shloka(
        id = 52,
        sanskrit = """
            यदा ते मोहकलिलं बुद्धिर्व्यतितरिष्यति |
            तदा गन्तासि निर्वेदं श्रोतव्यस्य श्रुतस्य च || ५२ ||
        """.trimIndent(),
        hindi = """
            जिस काल (समय) में तुम्हारी बुद्धि इस घने मोह रूपी दलदल (मोहकलिलम्) को पूरी तरह से पार कर जाएगी...
            उस समय तुम जो कुछ भी अब तक सुना गया है और जो कुछ भी आगे सुनने योग्य है, उन सबके प्रति पूर्ण वैराग्य (निर्वेदं) को प्राप्त हो जाओगे।
            अर्जुन का मन इस समय इस बात को लेकर बहुत उलझा हुआ है कि शास्त्रों में क्या लिखा है, परिवार के प्रति क्या कर्तव्य है, और पाप-पुण्य क्या है।
            भगवान श्रीकृष्ण इस श्लोक में अर्जुन को एक ऐसी आध्यात्मिक अवस्था (State of Mind) का वादा कर रहे हैं जहाँ ये सारी उलझनें खुद-ब-खुद खत्म हो जाएंगी।
            वे अर्जुन के वर्तमान विचारों को 'मोहकलिलम्' (मोह का एक अत्यंत घना और गंदा जंगल या दलदल) कहते हैं, जिसमें अर्जुन बुरी तरह फँस गए हैं।
            लेकिन जब इंसान निष्काम कर्म का अभ्यास करता है, तो उसकी बुद्धि एक लेज़र (Laser) की तरह तेज हो जाती है और इस अज्ञान के दलदल को चीर कर बाहर निकल आती है।
            जब यह आत्मज्ञान रूपी प्रकाश (Enlightenment) भीतर प्रकट होता है, तो बाहर के ज्ञान का कोई मोल नहीं रह जाता।
            तब इंसान 'निर्वेद' (पूर्ण वैराग्य) को प्राप्त होता है। उसे फिर दुनिया भर के प्रवचन सुनने ('श्रोतव्यस्य') या पुराने पढ़े हुए शास्त्रों ('श्रुतस्य') पर बहस करने की कोई आवश्यकता महसूस नहीं होती।
            वह सीधे परम सत्य से जुड़ जाता है, जहाँ दुनिया के सारे शब्द और सारे तर्क बौने हो जाते हैं। भगवान अर्जुन को उसी परम अनुभव की ओर ले जाना चाहते हैं।
        """.trimIndent(),
        english = """
            When your pure intelligence has completely completely crossed over and surpassed the dense, muddy forest of delusion (Moha-kalilam)...
            at that exact moment, you shall attain absolute, supreme indifference and detachment (Nirvedam) towards all that has been heard so far, and all that is yet to be heard.
            Arjuna's fragile mind is currently violently entangled and confused regarding what various scriptures dictate, what his social duty to his family is, and the complex mathematics of sin and merit.
            In this deeply reassuring verse, Lord Sri Krishna promises Arjuna a future transcendent State of Mind where all these frustrating mental complexities will simply evaporate on their own.
            He accurately terms Arjuna's current emotional thought-process as 'Moha-kalilam' (a terrifyingly dense, dirty swamp or impenetrable forest of illusion) in which Arjuna is hopelessly bogged down.
            But when a person diligently practices selfless action, his intelligence becomes incredibly sharp like a razor beam, effortlessly slicing right through this thick swamp of ignorance.
            When this blinding light of true Self-realization (Enlightenment) finally explodes from within, all external, borrowed knowledge instantly loses its entire value.
            At that precise moment, a person attains 'Nirveda' (Absolute, supreme detachment). He no longer feels the slightest urge to hear any more worldly philosophies ('Shrotavyasya') or endlessly debate over previously read rituals and scriptures ('Shrutasya').
            He becomes directly, experientially plugged into the Supreme Absolute Truth, where all worldly words and intellectual logics become entirely dwarfed and meaningless. The Lord intends to guide Arjuna to that exact supreme experiential reality.
        """.trimIndent()
    ),
    Shloka(
        id = 53,
        sanskrit = """
            श्रुतिविप्रतिपन्ना ते यदा स्थास्यति निश्चला |
            समाधावचला बुद्धिस्तदा योगमवाप्स्यसि || ५३ ||
        """.trimIndent(),
        hindi = """
            भांति-भांति के वचनों को सुनने से विचलित (श्रुतिविप्रतिपन्ना) हुई तुम्हारी बुद्धि, जब परमात्मा के ध्यान (समाधि) में...
            पूरी तरह से अचल (बिना हिले-डुले) और स्थिर (निश्चला) होकर ठहर जाएगी, तब तुम सच्चे 'योग' (परमात्मा से पूर्ण मिलन) को प्राप्त कर लोगे।
            अर्जुन ने अब तक बहुत लोगों की बातें सुनी हैं—शास्त्रों की बातें, समाज की बातें, परिवार वालों की बातें—और इसी 'श्रुति' (सुनने) के कारण उनका दिमाग एक भयंकर कंफ्यूजन (Confusion) का शिकार हो गया है।
            श्रीकृष्ण बताते हैं कि जब तक इंसान दुनिया की बातें और अलग-अलग दर्शन (Philosophies) सुनता रहता है, उसका मन कभी शांत नहीं हो सकता।
            सच्चा ज्ञान बाहर से नहीं आता, वह भीतर की शांति से प्रकट होता है।
            इसलिए भगवान कहते हैं कि जब यह भटकती हुई बुद्धि सारी बाहरी आवाजों से कटकर भीतर की गहराई (समाधि) में डूब जाएगी...
            और जब यह बिना एक मिलीमीटर भी हिले ('अचला' और 'निश्चला') एक ही परम सत्य (ईश्वर) पर टिक जाएगी, तभी वास्तविक आध्यात्मिक सफलता मिलेगी।
            'तदा योगमवाप्स्यसि'—यही वह अंतिम बिंदु है जहाँ इंसान और ईश्वर के बीच की दूरी खत्म हो जाती है और पूर्ण 'योग' (जुड़ाव) घटित होता है।
            इस श्लोक को सुनकर अर्जुन के मन में एक बहुत बड़ी जिज्ञासा पैदा होती है कि "आखिर ऐसा इंसान दिखता कैसा है जिसकी बुद्धि इतनी स्थिर हो गई हो?" और यहीं से अगला श्लोक जन्म लेता है।
        """.trimIndent(),
        english = """
            When your intelligence, which is currently totally bewildered and heavily distracted by hearing conflicting words and various philosophies (Shruti-vipratipanna)...
            becomes completely immovable (Achala) and unflinchingly, permanently fixed (Nischala) in the deep trance of God-realization (Samadhi), then you will have attained perfect, absolute Yoga (Divine union).
            Up until this exact moment, Arjuna has absorbed a massive overload of conflicting information—the confusing injunctions of scriptures, the heavy expectations of society, and the emotional demands of his family—and purely because of this endless 'Shruti' (hearing), his brain has suffered a massive psychological short-circuit.
            Sri Krishna profoundly explains that as long as a human being continues to endlessly listen to the chaotic noise of the world and thousands of contradictory philosophies, his mind can absolutely never find true peace.
            Ultimate, absolute truth does not enter from the outside world; it explodes from the profound stillness within.
            Therefore, the Lord states that when this wildly wandering intelligence completely cuts off all external noise and plunges into the deepest internal abyss of meditation (Samadhi)...
            and when it locks onto the One Supreme Truth without vibrating even a single millimeter ('Achala' and 'Nischala'), only then will true, ultimate spiritual perfection be achieved.
            'Tada yogam avapsyasi'—This is the absolute final singularity where the illusionary gap between the human soul and the Supreme God completely collapses, and pure, perfect 'Yoga' (Union) occurs.
            Hearing this spectacular promise, a massive, burning curiosity awakens within Arjuna: "What exactly does a human being whose intelligence has become so perfectly stable look like?" And this directly triggers the legendary question in the very next verse.
        """.trimIndent()
    ),
    Shloka(
        id = 54,
        sanskrit = """
            अर्जुन उवाच |
            स्थितप्रज्ञस्य का भाषा समाधिस्थस्य केशव |
            स्थितधीः किं प्रभाषेत किमासीत व्रजेत किम् || ५४ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने पूछा: हे केशव! जो व्यक्ति समाधि में स्थित है और जिसकी प्रज्ञा (बुद्धि) पूरी तरह से स्थिर हो चुकी है (स्थितप्रज्ञ), उस महापुरुष के क्या लक्षण (भाषा) होते हैं?
            वह स्थिर बुद्धि वाला व्यक्ति (स्थितधीः) कैसे बोलता है (प्रभाषेत), वह कैसे बैठता है (आसीत), और वह कैसे चलता है (व्रजेत)?
            यह भगवद्गीता के सबसे महत्वपूर्ण प्रश्नों में से एक है। श्रीकृष्ण द्वारा 'स्थिर बुद्धि' की महिमा सुनने के बाद अर्जुन अत्यधिक उत्सुक हो गए हैं।
            अर्जुन एक अत्यंत व्यावहारिक (Practical) योद्धा हैं। वे किसी काल्पनिक या किताबी ज्ञान से संतुष्ट नहीं होते; वे उस ज्ञान का जीता-जागता प्रमाण देखना चाहते हैं।
            वे जानना चाहते हैं कि यदि कोई व्यक्ति सच में ईश्वर को पा ले और उसकी बुद्धि 'स्थितप्रज्ञ' (Sthitaprajna - Perfectly stable intelligence) हो जाए, तो उसकी आम जिंदगी में क्या बदलाव आता है?
            क्या उसके सिर के पीछे कोई आभा-मंडल (Halo) चमकने लगता है? क्या वह दुनिया से कटकर किसी गुफा में बैठ जाता है?
            अर्जुन के तीन बहुत ही गहरे और स्पेसिफिक प्रश्न हैं:
            १. वह बोलता कैसे है? (जब कोई उसका अपमान करे या तारीफ करे, तो वह कैसी प्रतिक्रिया देता है?)
            २. वह बैठता कैसे है? (जब इन्द्रियों को खींचने वाले भोग सामने हों, तो वह अपने मन को कैसे रोकता है?)
            ३. वह चलता कैसे है? (वह इस बुरी और स्वार्थी दुनिया के बीच में कैसे व्यवहार करता है?)
            यहाँ से भगवान श्रीकृष्ण 'स्थितप्रज्ञ' (Enlightened Person) का जो चित्र खींचेंगे, वह पूरी दुनिया के मनोविज्ञान और अध्यात्म का सबसे महान ग्रंथ बन गया है।
        """.trimIndent(),
        english = """
            Arjuna urgently inquired: O Keshava! What are the exact symptoms and describing features (Bhasha) of a person whose consciousness is completely merged in transcendence and steady wisdom (Sthitaprajna)?
            How does such a person of perfectly steady intelligence (Sthitadhi) actually speak? How does he sit? And how does he walk and interact in this world?
            This is undisputedly one of the most monumentally important and practical questions asked in the entire Bhagavad Gita. After hearing Sri Krishna glorify the 'perfectly stable intelligence', Arjuna has become overwhelmingly curious.
            Arjuna is a highly practical, results-oriented warrior. He is absolutely never satisfied with vague, theoretical, or bookish philosophy; he desperately wants to see the living, breathing proof of that knowledge.
            He essentially asks: If a human being actually achieves ultimate God-realization and his intelligence truly becomes 'Sthitaprajna' (Flawlessly stable), how does that drastically alter his ordinary, day-to-day life?
            Does a glowing, mystical halo suddenly appear behind his head? Does he completely cut off from society and permanently hide in a dark mountain cave?
            Arjuna poses three extremely profound, behavioral questions:
            1. How does he speak? (How does he internally and externally react when someone viciously insults him or highly praises him?)
            2. How does he sit? (When extremely tempting objects of sensory enjoyment are right in front of him, how does he completely restrain his mind?)
            3. How does he walk? (How does he navigate and practically operate within this heavily toxic, selfish, and chaotic material world?)
            From this point onwards, the breathtaking portrait Lord Sri Krishna will paint of the 'Sthitaprajna' (The Enlightened Sage) has become the absolute greatest master-text of psychology and spirituality in the entire world.
        """.trimIndent()
    ),
    Shloka(
        id = 55,
        sanskrit = """
            श्रीभगवानुवाच |
            प्रजहाति यदा कामान्सर्वान्पार्थ मनोगतान् |
            आत्मन्येवात्मना तुष्टः स्थितप्रज्ञस्तदोच्यते || ५५ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा: हे पार्थ! जब कोई मनुष्य अपने मन में उत्पन्न होने वाली सभी प्रकार की भौतिक इच्छाओं (कामनाओं) को पूरी तरह से त्याग देता है (प्रजहाति)...
            और जब वह अपनी ही शुद्ध आत्मा के द्वारा अपनी आत्मा में ही पूरी तरह से संतुष्ट (तुष्टः) रहता है, तब उस महापुरुष को 'स्थितप्रज्ञ' (स्थिर बुद्धि वाला) कहा जाता है।
            अर्जुन के प्रश्नों का उत्तर देते हुए, भगवान सबसे पहले उस ज्ञानी के आंतरिक मनोविज्ञान (Internal Psychology) का वर्णन कर रहे हैं।
            साधारण इंसान की पूरी जिंदगी उसके 'मनोगतान् कामान्' (मन में पैदा होने वाली अंतहीन इच्छाओं) को पूरा करने में ही निकल जाती है।
            मनुष्य सोचता है कि बाहर की चीज़ें (नई गाड़ी, बड़ा घर, सम्मान) उसे खुशी देंगी, लेकिन इच्छाओं की यह आग कभी नहीं बुझती।
            स्थितप्रज्ञ व्यक्ति वह है जिसने यह गहराई से समझ लिया है कि बाहरी दुनिया का कोई भी खिलौना आत्मा की असीम भूख को नहीं मिटा सकता।
            इसलिए, वह एक झटके में मन की सभी (सर्वान्) बनावटी इच्छाओं को जड़ से उखाड़ फेंकता है ('प्रजहाति')।
            लेकिन जब इच्छाएं छूट जाती हैं, तो इंसान डिप्रेशन में नहीं जाता, बल्कि वह 'आत्मन्येवात्मना तुष्टः' हो जाता है—यानी वह अपने भीतर मौजूद परमात्मा के असीम रस और आनंद में ही 100% संतुष्ट हो जाता है।
            उसे खुश होने के लिए बाहर की किसी भी चीज़ या व्यक्ति की भीख नहीं मांगनी पड़ती; वह स्वयं आनंद का एक बहता हुआ सागर बन जाता है। यही स्थितप्रज्ञ का पहला और सबसे बड़ा लक्षण है।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead elegantly replied: O Partha! When a human being completely and utterly gives up all varieties of material desires that are merely manufactured by the mind (Kaman mano-gatan)...
            and when his purified mind finds absolute, 100% satisfaction solely within the eternal self, by the self (Atmany evatmana tushtah), then that great soul is definitively declared to be a 'Sthitaprajna' (A person of perfectly steady wisdom).
            Beginning His masterpiece answer to Arjuna's specific behavioral questions, the Lord first brilliantly defines the core, foundational Internal Psychology of an enlightened sage.
            An ordinary, ignorant human being's entire lifespan is brutally exhausted simply chasing after his 'Manogatan Kaman' (the endless, toxic web of desires manufactured by his restless mind).
            A mortal foolishly thinks that external material objects (a luxury car, a massive mansion, social validation) will finally grant him happiness, but this raging fire of desires is never, ever extinguished.
            The Sthitaprajna is that elite individual who has profoundly and experientially realized that absolutely no plastic toy from the external material world can ever satisfy the infinite, eternal hunger of the spiritual soul.
            Therefore, in one powerful, decisive stroke, he violently uproots and completely discards ('Prajahati') ALL ('Sarvan') artificial, mental concoctions and desires.
            But when all desires are dropped, the sage absolutely does not fall into a void of depression; instead, he becomes 'Atmany evatmana tushtah'—meaning he becomes totally, infinitely intoxicated and 100% satisfied in the limitless bliss of the Supreme Soul existing right within his own heart.
            He never again has to pathetically beg any external object or person to make him happy; he himself becomes a continuous, overflowing ocean of pure ecstasy. This is the absolute first and supreme symptom of the Sthitaprajna.
        """.trimIndent()
    ),
    Shloka(
        id = 56,
        sanskrit = """
            दुःखेष्वनुद्विग्नमनाः सुखेषु विगतस्पृहः |
            वीतरागभयक्रोधः स्थितधीर्मुनिरुच्यते || ५६ ||
        """.trimIndent(),
        hindi = """
            जिसका मन किसी भी प्रकार के दुःखों (शारीरिक या मानसिक) की प्राप्ति होने पर बिल्कुल भी विचलित या घबराता नहीं है (अनुद्विग्नमनाः)...
            और जो भारी सुख मिलने पर भी उसमें कोई लालसा या आसक्ति नहीं रखता (विगतस्पृहः)...
            तथा जो मनुष्य राग (लगाव/आकर्षण), भय (डर) और क्रोध (गुस्से) से पूरी तरह मुक्त हो चुका है (वीतरागभयक्रोधः), उस मननशील मुनि को 'स्थितप्रज्ञ' (स्थिर बुद्धि वाला) कहा जाता है।
            यह श्लोक अर्जुन के पहले प्रश्न ("स्थितप्रज्ञ कैसे बोलता है या बर्ताव करता है?") का सीधा उत्तर है।
            भगवान यहाँ एक महान योगी का 'शॉक-एब्जॉर्बर' (Shock-absorber) सिस्टम समझा रहे हैं।
            जब एक आम आदमी पर कोई बड़ा दुःख (बीमारी, नुकसान, मौत) आता है, तो वह टूट कर रोने लगता है, शिकायत करता है और डिप्रेशन में चला जाता है।
            लेकिन ज्ञानी पुरुष (मुनि) जानता है कि ये दुःख केवल शरीर और मन के बाहरी सतह पर हैं, आत्मा तक इनकी पहुँच नहीं है, इसलिए वह शांत ('अनुद्विग्नमनाः') रहता है।
            उसी तरह, जब उसे बहुत बड़ी लॉटरी या सफलता (सुख) मिलती है, तो वह खुशी से पागल होकर अहंकार में नहीं डूबता ('विगतस्पृहः')।
            इस गजब के संतुलन का रहस्य क्या है? रहस्य यह है कि उसने तीन सबसे बड़े शत्रुओं को मार गिराया है:
            १. 'राग' (किसी चीज़ से चिपकना), २. 'भय' (उस चीज़ के छिन जाने का डर), और ३. 'क्रोध' (जब वह चीज़ न मिले या छिन जाए तो आने वाला भयंकर गुस्सा)।
            जो इन तीनों वायरसों (Viruses) से मुक्त हो गया है, उसकी बुद्धि हमेशा के लिए एक चट्टान की तरह स्थिर (स्थितधीः) हो जाती है।
        """.trimIndent(),
        english = """
            One whose mind remains absolutely undisturbed, unagitated, and calm even amidst the most severe threefold miseries (Duhkheshv anudvigna-manah)...
            and who remains completely free from any craving, excitement, or attachment when encountering immense happiness and pleasures (Sukheshu vigata-sprihah)...
            and who has become entirely and permanently free from all false attachment (Raga), paralyzing fear (Bhaya), and violent anger (Krodha)—such a highly thoughtful sage is definitively called a person of perfectly steady intelligence (Sthita-dhi/Sthitaprajna).
            This verse is the direct, spectacular answer to Arjuna's first question ("How does the Sthitaprajna speak or react to the world?").
            The Lord is brilliantly explaining the ultimate psychological 'Shock-absorber' system of a self-realized grandmaster Yogi.
            When an ordinary mortal is hit by massive tragedy (fatal disease, financial ruin, death of a loved one), he violently breaks down weeping, bitterly complains against God, and spirals into dark depression.
            But the enlightened sage (Muni) perfectly knows that these miseries are merely crashing against the outermost superficial shell of the temporary physical body and mind; they simply cannot touch the eternal soul, hence he remains flawlessly calm ('Anudvigna-manah').
            Similarly, when he hits a massive lottery or attains monumental worldly success (Sukha), he does not go crazy with arrogant euphoria or drown in toxic pride ('Vigata-sprihah').
            What is the absolute secret behind this godlike, impeccable balance? The secret is that he has permanently slaughtered the mind's three deadliest enemies:
            1. 'Raga' (toxic, sticky attachment to objects), 2. 'Bhaya' (the paralyzing terror of losing those objects), and 3. 'Krodha' (the violent, blinding anger that erupts when desires are frustrated or objects are snatched away).
            Whoever becomes 100% free from these three psychological viruses finds his intelligence permanently, unshakably locked like a massive granite mountain (Sthita-dhi).
        """.trimIndent()
    ),
    Shloka(
        id = 57,
        sanskrit = """
            यः सर्वत्रानभिस्नेहस्तत्तत्प्राप्य शुभाशुभम् |
            नाभिनन्दति न द्वेष्टि तस्य प्रज्ञा प्रतिष्ठिता || ५७ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य इस भौतिक संसार में सभी जगह (सभी व्यक्तियों और वस्तुओं में) स्नेह (लगाव/आसक्ति) से पूरी तरह रहित है (अनभिस्नेहः)...
            और जो किसी भी शुभ (अच्छी) चीज़ को प्राप्त करके न तो अत्यधिक प्रसन्न (अभिनंदन) होता है, और किसी अशुभ (बुरी) चीज़ को प्राप्त करके न ही उससे घृणा (द्वेष) करता है...
            उस महापुरुष की प्रज्ञा (बुद्धि) परम सत्य में पूरी तरह से प्रतिष्ठित (स्थिर) हो चुकी है।
            यह श्लोक भी स्थितप्रज्ञ व्यक्ति के सामाजिक व्यवहार की बहुत ही बारीक और गहरी तस्वीर प्रस्तुत करता है।
            भगवान कहते हैं कि ज्ञानी व्यक्ति का मन 'अनभिस्नेह' होता है—इसका अर्थ यह नहीं है कि वह पत्थरदिल है या किसी से प्यार नहीं करता।
            इसका अर्थ यह है कि उसका प्यार 'स्वार्थ' (Selfishness) से नहीं जुड़ा होता। वह लोगों से इसलिए नहीं जुड़ता कि वे उसे कोई फायदा देंगे।
            साधारण इंसान अच्छी चीज़ें (शुभ) मिलने पर डींगें मारता है और उसका खूब जश्न (अभिनंदन) मनाता है, और बुरी चीज़ें (अशुभ) मिलने पर दुनिया को गालियां देता है और उन चीज़ों से घृणा (द्वेष) करने लगता है।
            लेकिन ज्ञानी पुरुष जानता है कि यह पूरी दुनिया एक किराये का घर है, जहाँ आज कुछ अच्छा है तो कल कुछ बुरा होगा; यह प्रकृति का खेल है।
            इसलिए जब उसका कोई सम्मान करता है तो वह अहंकार से नहीं फूलता, और जब कोई उसका अपमान करता है तो वह उससे नफरत नहीं करता।
            वह इन सभी छोटी-मोटी भौतिक घटनाओं को एक दर्शक (Witness) की तरह चुपचाप देखता रहता है।
            जिसकी चेतना (बुद्धि) इस स्तर तक ऊपर उठ चुकी है, वह इस दुनिया के किसी भी तूफान से कभी नहीं हिल सकता।
        """.trimIndent(),
        english = """
            He who remains completely without false, material affection (Anabhisnehah) for anything or anyone anywhere in this material world...
            and who neither rejoices, praises, nor proudly celebrates upon achieving something highly auspicious or good (Shubham), nor fiercely despises, curses, or hates upon encountering something highly inauspicious or evil (Ashubham)...
            the supreme intelligence (Prajna) of such a phenomenal person is permanently and perfectly established (Pratishtita).
            This verse paints an incredibly fine, deeply nuanced, and highly advanced picture of the exact social behavior and daily interaction of the enlightened Sthitaprajna.
            The Lord states that the sage's mind is 'Anabhisneha'—this absolutely does not mean he is a cold, heartless stone who doesn't love anyone.
            It profoundly means that his love is completely stripped of toxic 'Selfishness' and 'Expectations'. He does not attach himself to people or objects like a parasite merely to extract personal benefit from them.
            An ordinary mortal boasts, throws massive parties, and excessively celebrates (Abhinandati) when he acquires highly favorable things (Shubham), and he bitterly curses the universe and violently hates (Dveshti) when struck by unfortunate things (Ashubham).
            But the enlightened master perfectly knows that this entire material world is merely a temporary rented hotel, where if something is excellent today, it is guaranteed to degrade tomorrow; it is just the mechanical play of nature.
            Therefore, when society showers him with immense honor, his ego does not inflate a single inch, and when he faces brutal insult, he does not generate a single drop of hatred for the offender.
            He continuously observes all these petty, trivial material fluctuations silently like an entirely detached, unaffected supreme Witness (Observer).
            One whose divine consciousness (intelligence) has elevated to this staggering altitude can absolutely never be shaken by any violent storm of this world.
        """.trimIndent()
    ),
    Shloka(
        id = 58,
        sanskrit = """
            यदा संहरते चायं कूर्मोऽङ्गानीव सर्वशः |
            इन्द्रियाणीन्द्रियार्थेभ्यस्तस्य प्रज्ञा प्रतिष्ठिता || ५८ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार एक कछुआ (कूर्मः) खतरे को देखकर अपने सभी अंगों को तुरंत अपने कठोर खोल के भीतर खींच लेता है (संहरते)...
            ठीक उसी प्रकार, जब यह योगी अपनी सभी इन्द्रियों को उनके लुभावने विषयों (रूप, रस, गंध आदि) से पूरी तरह खींचकर अपने वश में कर लेता है...
            तब उसकी प्रज्ञा (बुद्धि) परम स्थिरता (प्रतिष्ठिता) को प्राप्त हुई मानी जाती है।
            यह श्लोक अर्जुन के दूसरे प्रश्न ("स्थितप्रज्ञ बैठता कैसे है?") का एक अत्यंत ही वैज्ञानिक और प्रतीकात्मक उत्तर है।
            यहाँ 'बैठने' का अर्थ शरीर को किसी आसन में मोड़ना नहीं है, बल्कि खतरे के समय मन और इन्द्रियों को समेट कर भीतर बैठ जाना है।
            भगवान एक कछुए का बहुत ही शानदार उदाहरण देते हैं। जब कछुआ बाहर की दुनिया में किसी शिकारी या खतरे को महसूस करता है, तो वह लड़ता नहीं है; वह तुरंत अपने हाथ-पैर और सिर को अपने मजबूत कवच (Shell) के अंदर समेट लेता है, जहाँ वह पूरी तरह सुरक्षित रहता है।
            उसी तरह, हमारी पाँच ज्ञानेंद्रियाँ (आँख, कान, नाक, जीभ, त्वचा) हमेशा बाहरी दुनिया के मजे (इन्द्रियार्थ) लूटने के लिए बाहर की तरफ भागती रहती हैं।
            एक स्थितप्रज्ञ योगी जानता है कि बाहर की ये आकर्षक चीजें (जैसे खूबसूरत रूप, स्वादिष्ट जंक फूड, या झूठी तारीफ) आत्मा के लिए एक बहुत बड़ा खतरा (शिकारी) हैं।
            इसलिए जब भी यह खतरा सामने आता है, वह एक कछुए की तरह अपनी चेतना (Consciousness) को तुरंत उन विषयों से खींचकर अपनी आत्मा के सुरक्षित खोल (Shell) के भीतर समेट लेता है।
            इन्द्रियों को बलपूर्वक नियंत्रित करने की यह अद्भुत क्षमता (Self-control) ही स्थितप्रज्ञ व्यक्ति का सबसे बड़ा हथियार है।
        """.trimIndent(),
        english = """
            Just as a tortoise (Kurmah) instantly and completely withdraws all its vulnerable limbs entirely within its hard shell upon perceiving any external danger...
            in the exact same manner, when this Yogi is able to completely and forcefully withdraw all his senses from their highly attractive sense objects (Indriyarthebhyah)...
            then his intelligence (Prajna) is considered to be perfectly and permanently established in secure, transcendent consciousness (Pratishtita).
            This verse provides a highly scientific, profoundly symbolic, and brilliant answer to Arjuna's second question ("How does the Sthitaprajna sit?").
            Here, 'sitting' absolutely does not mean folding the physical body into a yoga posture; it signifies the supreme mental ability to completely retract the mind and senses inward during times of extreme external temptation or danger.
            The Lord provides the spectacularly perfect analogy of a tortoise. When a tortoise senses a deadly predator or threat in the outside world, it does not foolishly stay out and fight; it instantly retracts its head and limbs entirely inside its impenetrable armor shell, where it remains 100% safe.
            In the exact same way, our five knowledge-acquiring senses (eyes, ears, nose, tongue, skin) are constantly running outwards like wild horses, desperately trying to devour the temporary, toxic pleasures (Indriyarthas) of the external world.
            An enlightened Yogi perfectly recognizes that these highly attractive external objects (like seductive forms, toxic junk food, or false flattery) are actually massive, deadly predators seeking to destroy his spiritual soul.
            Therefore, whenever this massive threat presents itself, he acts exactly like the master tortoise—he instantly and completely unplugs his consciousness from those toxic objects and retracts his entire focus deep inside the ultimate, impenetrable safe-shell of his eternal soul.
            This astonishing, supreme capability of absolute sense control (Self-mastery) is the ultimate, greatest weapon of the Sthitaprajna.
        """.trimIndent()
    ),
    Shloka(
        id = 59,
        sanskrit = """
            विषया विनिवर्तन्ते निराहारस्य देहिनः |
            रसवर्जं रसोऽप्यस्य परं दृष्ट्वा निवर्तते || ५९ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य इन्द्रियों को उनके विषयों (आहार) से जबरदस्ती रोकता है (जैसे व्रत या तपस्या द्वारा), उसके इन्द्रियों के बाहरी विषय (भौतिक चीजें) तो निवृत्त हो जाते हैं (रुक जाते हैं)...
            परंतु उसके मन के भीतर उन विषयों को भोगने की जो गहरी 'रस' (रुचि या लालसा) है, वह खत्म नहीं होती।
            लेकिन जब ऐसा व्यक्ति उस परम सत्य (परमात्मा) का साक्षात् अनुभव (परं दृष्ट्वा) कर लेता है, तो उसकी वह भीतर की सूक्ष्म रुचि (रस) भी हमेशा के लिए समाप्त हो जाती है।
            यह श्लोक मनोविज्ञान (Psychology) और आध्यात्मिक साधना (Spiritual Practice) का एक बहुत बड़ा और कड़वा सत्य सामने रखता है।
            अक्सर लोग इन्द्रियों को कंट्रोल करने के लिए जबरदस्ती भूखे रहते हैं, आँखें बंद कर लेते हैं, या जंगलों में भाग जाते हैं ('निराहारस्य')।
            भगवान कहते हैं कि इस जबरदस्ती से तुम चीजों (विषयों) को तो अपने शरीर से दूर कर दोगे, लेकिन तुम्हारे 'मन' के अंदर उस चॉकलेट को खाने की या उस सुख को भोगने की जो भयंकर 'क्रेविंग' (Craving / रस) है, वह कभी नहीं मरेगी।
            और जैसे ही मौका मिलेगा, वह दबी हुई इच्छा ज्वालामुखी की तरह फट पड़ेगी और इंसान को फिर से पाप में गिरा देगी।
            तो फिर यह 'क्रेविंग' (रस) हमेशा के लिए खत्म कैसे होगी?
            श्रीकृष्ण इसका अचूक फॉर्मूला देते हैं: 'परं दृष्ट्वा' (उस 'परम' को देखकर)। जब आत्मा को भगवान के प्रेम और ध्यान का वह अलौकिक और मीठा 'रस' (Higher Taste) मिल जाता है, तो दुनिया के सारे छोटे-मोटे रस (सुख) अपने आप बिल्कुल फीके और बकवास लगने लगते हैं।
            एक बार असली हीरा मिल जाए, तो इंसान कांच के टुकड़ों (दुनिया के सुखों) को खुद ही डस्टबिन में फेंक देता है।
        """.trimIndent(),
        english = """
            The embodied soul may be forcefully restricted from external sense enjoyment (such as through severe fasting or physical austerities), and though the external sense objects (Vishaya) are thereby kept away...
            the deep-rooted internal taste, craving, or longing (Rasa) for those sense objects absolutely remains intact within the mind.
            But once such a person personally experiences and directly beholds the Supreme Absolute Truth (Param Drishtva), even that subtle, hidden internal taste (Rasa) ceases completely and vanishes forever.
            This verse exposes a massively profound and often bitter truth regarding human psychology and artificial spiritual practices.
            Often, amateur practitioners try to forcefully control their wild senses by aggressively starving themselves, physically shutting their eyes, or running away to isolate themselves in remote forests ('Niraharasya').
            The Lord warns that through such violent physical force, you might successfully keep the external objects (Vishayas) away from your physical body, but the intense, burning 'Craving' (Rasa/Taste) hidden deep inside your 'Mind' to devour that chocolate or enjoy that pleasure will absolutely never die.
            And the very exact second an opportunity presents itself, that violently suppressed desire will explode like a massive volcano, dragging the person right back into severe degradation.
            So, how on earth is this toxic 'Craving' (Rasa) permanently destroyed forever?
            Sri Krishna delivers the absolute, infallible master-formula: 'Param Drishtva' (by directly beholding the 'Supreme'). When the soul finally tastes the unimaginably ecstatic, sweet, and transcendental 'Higher Taste' of pure love and meditation on God, all the cheap, petty tastes of worldly pleasures automatically begin to taste like absolute garbage.
            Once a person finds an actual, priceless diamond, he automatically and effortlessly throws away the shiny pieces of broken glass (worldly pleasures) into the dustbin without the slightest regret.
        """.trimIndent()
    ),
    Shloka(
        id = 60,
        sanskrit = """
            यततो ह्यपि कौन्तेय पुरुषस्य विपश्चितः |
            इन्द्रियाणि प्रमाथीनि हरन्ति प्रसभं मनः || ६० ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! इन्द्रियों को वश में करने का लगातार और भारी प्रयास (यत्न) करने वाले एक अत्यंत बुद्धिमान और विवेकशील (विपश्चितः) पुरुष के भी...
            मन को ये अत्यंत बलवान, मथ डालने वाली (प्रमाथीनि) और भयंकर इन्द्रियां बलपूर्वक (प्रसभं) खींचकर अपनी ओर (विषयों की ओर) ले ही जाती हैं।
            भगवान श्रीकृष्ण यहाँ मानव शरीर की इन्द्रियों की अकल्पनीय और डरावनी शक्ति (Power of the Senses) का बहुत ही यथार्थ (Realistic) वर्णन कर रहे हैं।
            वे अर्जुन को चेतावनी दे रहे हैं कि इन्द्रियों को कंट्रोल करना कोई बच्चों का खेल नहीं है।
            भले ही कोई इंसान बहुत बड़ा पढ़ा-लिखा विद्वान हो, उसे सारे शास्त्रों का ज्ञान हो ('विपश्चितः'), और वह अपनी इन्द्रियों को रोकने की पूरी ताकत लगा रहा हो ('यततो ह्यपि')...
            फिर भी, ये इन्द्रियां इतनी 'प्रमाथीनि' (तूफान की तरह मथ देने वाली और पागल कर देने वाली) हैं कि वे इंसान के सारे ज्ञान और समझदारी को एक झटके में बहा ले जाती हैं।
            जैसे एक अत्यंत शक्तिशाली और बेलगाम घोड़ा अपने घुड़सवार को उसकी इच्छा के खिलाफ बलपूर्वक ('प्रसभं') किसी भी खड्ड में गिरा सकता है, वैसे ही ये इन्द्रियां इंसान के मन को जबर्दस्ती पाप की ओर खींच ले जाती हैं।
            यह श्लोक यह स्पष्ट करता है कि केवल अपनी व्यक्तिगत शक्ति या किताबी ज्ञान के दम पर कोई भी इंसान इस माया और इन्द्रियों के जाल से नहीं बच सकता।
            अपनी इन्द्रियों पर घमंड करना सबसे बड़ी मूर्खता है। इन तूफानी इन्द्रियों को कंट्रोल करने के लिए ईश्वर की शरण और उच्च आध्यात्मिक 'रस' (Higher Taste) का होना अत्यंत आवश्यक है।
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya)! The physical senses are so incredibly strong, turbulent, and violently impetuous (Pramathini) that they forcibly (Prasabham) carry away the mind...
            even of a highly intelligent, intensely discriminative man of ultimate wisdom (Vipashchitah) who is constantly and vigorously endeavoring (Yatatah) to control them.
            Lord Sri Krishna is painting an incredibly realistic, frightening, and brutally honest picture of the unimaginable, devastating power of the human senses here.
            He is issuing a severe warning to Arjuna that controlling the wild senses is absolutely not a child's play or a casual hobby.
            Even if a human being is a massively educated scholar, possessing the absolute highest academic knowledge of all scriptures ('Vipashchitah'), and is putting in 100% of his absolute maximum willpower to forcefully restrict his senses ('Yatatah hy api')...
            even then, these senses are so 'Pramathini' (violently turbulent, churning, and maddening like a Category 5 hurricane) that they can effortlessly wash away all of the man's logic, knowledge, and sanity in a single, brutal strike.
            Just as an exceptionally massive, unbridled, and violently wild horse can forcefully ('Prasabham') drag its helpless rider against his will and throw him off a cliff, these toxic senses violently drag the human mind forcefully into the abyss of sin.
            This terrifying verse makes it crystal clear that absolutely no human being can ever survive the deadly trap of Maya (Illusion) and the senses relying purely on his own puny personal willpower or bookish academic knowledge.
            Being blindly arrogant about one's self-control is the absolute pinnacle of foolishness. To actually conquer these hurricane-like senses, taking absolute, humble shelter of the Supreme Lord and constantly experiencing the transcendental 'Higher Taste' is mandatory and non-negotiable.
        """.trimIndent()
    ),
    Shloka(
        id = 61,
        sanskrit = """
            तानि सर्वाणि संयम्य युक्त आसीत मत्परः |
            वशे हि यस्येन्द्रियाणि तस्य प्रज्ञा प्रतिष्ठिता || ६१ ||
        """.trimIndent(),
        hindi = """
            इसलिए मनुष्य को चाहिए कि वह उन संपूर्ण इन्द्रियों को अच्छी तरह वश में करके (संयम्य) और अपने मन को मुझमें (परमात्मा में) लगाकर (मत्परः) ध्यान में बैठे।
            क्योंकि जिस मनुष्य की इन्द्रियां पूरी तरह से उसके वश में होती हैं, उसी की बुद्धि (प्रज्ञा) वास्तव में स्थिर (प्रतिष्ठिता) मानी जाती है।
            पिछले श्लोक में भगवान ने बताया था कि इन्द्रियां कितनी भयंकर और तूफानी होती हैं। अब वे उन तूफानी इन्द्रियों को काबू करने का एकमात्र अचूक रहस्य (Ultimate Secret) बता रहे हैं।
            साधारण इंसान अपनी इन्द्रियों को केवल अपने 'अहंकार' या 'विलपावर' (Willpower) के दम पर रोकने की कोशिश करता है, और अंततः बुरी तरह हार जाता है।
            लेकिन श्रीकृष्ण यहाँ एक नया और अत्यंत शक्तिशाली शब्द जोड़ते हैं: 'मत्परः' (मेरे परायण होकर, या मुझे अपना सर्वोच्च लक्ष्य मानकर)।
            जब एक योगी अपनी इन्द्रियों को विषयों (जैसे गंदे विचारों या लालच) से हटाकर, उन्हें परमात्मा की भक्ति और प्रेम भरे कार्यों में लगा देता है, तो उसका मन खुद-ब-खुद शांत हो जाता है।
            इन्द्रियों को खाली छोड़ना खतरनाक है; उन्हें ईश्वर की उच्चतर चेतना (Higher Taste) से भर देना ही उन्हें जीतने का असली तरीका है।
            जिसने भगवान की शक्ति का सहारा लेकर अपनी इन्द्रियों को जीत लिया है, केवल उसी व्यक्ति की बुद्धि इस संसार के तूफानों के बीच चट्टान की तरह स्थिर रह सकती है।
        """.trimIndent(),
        english = """
            Therefore, one should completely completely restrain all the senses, keeping them firmly under absolute control, and fix his consciousness entirely upon Me (Mat-parah).
            Because the intelligence of that person whose senses are perfectly under his control is considered to be permanently and flawlessly established (Pratishthita).
            In the previous verse, the Lord vividly described how terrifyingly powerful and destructive the senses are. Now, He reveals the absolute, single most infallible secret to conquering them.
            An ordinary human being foolishly attempts to forcefully control his wild senses purely on the fragile strength of his own 'Ego' or 'Willpower', and inevitably suffers a brutal defeat.
            But Sri Krishna introduces a massively powerful, game-changing condition here: 'Mat-parah' (making Me your supreme goal, completely surrendering to Me).
            When a Yogi forcibly unplugs his senses from toxic material objects and successfully plugs them directly into the loving, devotional service of the Supreme Lord, the mind automatically becomes deeply pacified.
            Leaving the senses entirely empty and unoccupied is extremely dangerous; filling them to the brim with the transcendental 'Higher Taste' of God is the only real way to conquer them.
            Only that highly elevated person who has conquered his senses by taking absolute shelter of the Lord's supreme power possesses an intelligence that remains unshakable amidst worldly storms.
        """.trimIndent()
    ),
    Shloka(
        id = 62,
        sanskrit = """
            ध्यायतो विषयान्पुंसः सङ्गस्तेषूपजायते |
            सङ्गात्सञ्जायते कामः कामात्क्रोधोऽभिजायते || ६२ ||
        """.trimIndent(),
        hindi = """
            इन्द्रियों के विषयों (जैसे सुंदर रूप, धन, या भौतिक सुखों) का लगातार चिंतन (ध्यान) करने वाले पुरुष की उन विषयों में गहरी आसक्ति (सङ्ग या लगाव) पैदा हो जाती है।
            उस आसक्ति (लगाव) से मन में उन चीजों को पाने की तीव्र इच्छा या वासना (काम) उत्पन्न होती है, और जब उस इच्छा के पूरा होने में कोई बाधा आती है, तो क्रोध (गुस्सा) पैदा होता है।
            यह और इसके अगला (63वां) श्लोक, पूरी भगवद्गीता और आधुनिक मनोविज्ञान (Modern Psychology) के सबसे महान श्लोकों में से हैं। इसे "मानव पतन की सीढ़ी" (Ladder of Fall) कहा जाता है।
            भगवान इंसान के विनाश का बिल्कुल 'स्टेप-बाय-स्टेप' (Step-by-step) वैज्ञानिक विश्लेषण कर रहे हैं।
            विनाश की शुरुआत किसी बहुत बड़े पाप से नहीं होती; विनाश की शुरुआत दिमाग में चल रहे एक छोटे से, मासूम से विचार ('ध्यायतो') से होती है।
            जब इंसान किसी चीज़ (जैसे नई गाड़ी या किसी व्यक्ति) के बारे में बार-बार सोचता है, तो उसके भीतर उस चीज़ के प्रति एक मनोवैज्ञानिक चुंबकत्व या 'आसक्ति' (Attachment) पैदा हो जाती है।
            यह आसक्ति धीरे-धीरे एक भयंकर और अंधी 'वासना' (Lust/Kama) का रूप ले लेती है कि "मुझे यह चीज़ हर हाल में चाहिए ही चाहिए।"
            और इस दुनिया में कोई भी इच्छा 100% पूरी नहीं होती। जब उस वासना के रास्ते में कोई व्यक्ति या परिस्थिति रुकावट बनती है, तो वह वासना तुरंत एक ज्वालामुखी की तरह फटकर 'क्रोध' (Anger) में बदल जाती है।
        """.trimIndent(),
        english = """
            While constantly contemplating and deeply meditating on the objects of the senses (Vishayas), a person develops a profound psychological attachment (Sanga) to them.
            From such deep attachment, an intense, burning lust or craving (Kama) develops, and from frustrated lust arises violent, blinding anger (Krodha).
            This verse, along with the next one (63), forms what is universally considered the absolute greatest psychological masterpiece in the entire Gita, often called the "Ladder of Fall".
            The Lord is providing a highly flawless, clinically precise 'step-by-step' scientific analysis of exactly how a human mind is utterly destroyed.
            Ultimate destruction never begins with a massive, horrific crime; it always begins with a single, tiny, seemingly innocent thought ('Dhyayatah') lingering in the mind.
            When a human repeatedly dwells on a specific object (like a luxury car, money, or a person), a powerful psychological magnetism or 'Attachment' (Sanga) is rapidly generated within him.
            This attachment gradually mutates into a terrifying, blind, and desperate 'Lust' (Kama) that arrogantly demands, "I must possess this at any cost whatsoever."
            And since the material world never fulfills any desire 100%, whenever a situation or person creates a blockage in fulfilling that lust, it instantly violently explodes into blinding 'Anger' (Krodha).
        """.trimIndent()
    ),
    Shloka(
        id = 63,
        sanskrit = """
            क्रोधाद्भवति सम्मोहः सम्मोहात्स्मृतिविभ्रमः |
            स्मृतिभ्रंशाद्बुद्धिनाशो बुद्धिनाशात्प्रणश्यति || ६३ ||
        """.trimIndent(),
        hindi = """
            क्रोध (गुस्से) से अत्यंत भयंकर मूढ़ता या अविवेक (सम्मोह) पैदा होता है; उस मूढ़ता से इंसान की स्मृति (याददाश्त और शास्त्रों का ज्ञान) पूरी तरह भ्रमित हो जाती है।
            स्मृति के भ्रमित हो जाने पर मनुष्य की बुद्धि (सही-गलत सोचने की शक्ति) का पूरी तरह से नाश हो जाता है, और बुद्धि के नाश हो जाने पर उस मनुष्य का पूर्ण रूप से पतन (विनाश) हो जाता है।
            यहाँ भगवान श्रीकृष्ण 'मानव पतन की सीढ़ी' के अंतिम और सबसे भयानक चरणों का वर्णन कर रहे हैं।
            जब वासना पूरी न होने पर 'क्रोध' आता है, तो इंसान अंधा हो जाता है और 'सम्मोह' (Delusion) में गिर जाता है। उसे सही-गलत का कोई होश नहीं रहता।
            उस सम्मोह के कारण उसकी 'स्मृतिविभ्रम' (Loss of Memory) हो जाती है। इसका मतलब यह नहीं है कि वह अपना नाम भूल जाता है, बल्कि वह अपने 'आध्यात्मिक ज्ञान' और 'संस्कारों' को भूल जाता है।
            उसे याद नहीं रहता कि वह कौन है, उसके गुरु ने क्या सिखाया था, और उसका धर्म क्या है। वह अपनों पर ही वार करने लगता है।
            जब ज्ञान की यह मेमोरी डिलीट (Delete) हो जाती है, तो उसकी 'बुद्धि' (Intelligence/Conscience) हमेशा के लिए मर जाती है।
            और एक बार जब इंसान की बुद्धि (सोचने-समझने का सिस्टम) काम करना बंद कर दे, तो वह इंसान एक चलते-फिरते शव (लाश) के समान हो जाता है। उसका सामाजिक, नैतिक और आध्यात्मिक 'विनाश' (प्रणश्यति) तय है।
            एक छोटे से गलत विचार से शुरू होकर इंसान कैसे अपनी पूरी जिंदगी बर्बाद कर लेता है, यह उसका सबसे सटीक वैज्ञानिक विवरण है।
        """.trimIndent(),
        english = """
            From violent anger (Krodha), complete delusion and profound bewilderment (Sammohah) arise; and from delusion, there is absolute bewilderment of memory (Smriti-vibhramah).
            When memory is utterly bewildered, the human intelligence and moral conscience (Buddhi) are completely destroyed, and upon the total destruction of intelligence, the person falls down into the deepest abyss of absolute ruin (Pranashyati).
            Here, Lord Sri Krishna maps out the final, most terrifying and catastrophic stages of the 'Ladder of Fall'.
            When 'Anger' furiously erupts from frustrated lust, the human being goes completely psychologically blind and falls into dense 'Delusion' (Sammoha). He entirely loses all sense of right and wrong.
            Because of that deep delusion, his 'Memory' forcefully crashes (Smriti-vibhramah). This does not mean forgetting his name; it means completely forgetting his spiritual training, morals, and noble values.
            He brutally forgets who he actually is, what his Guru taught him, and what his supreme dharma is, often making him attack his own loved ones.
            When this sacred memory hard-drive is completely wiped out, his 'Intelligence' (Buddhi/Conscience) dies permanently.
            And once a human being's intelligence is completely destroyed, he is practically reduced to a walking corpse. His social, moral, and spiritual 'Annihilation' (Pranashyati) is absolute and guaranteed.
            This is the ultimate, flawless scientific breakdown of exactly how a person destroys their entire existence starting from just a single, tiny, uncontrolled wrong thought.
        """.trimIndent()
    ),
    Shloka(
        id = 64,
        sanskrit = """
            रागद्वेषवियुक्तैस्तु विषयानिन्द्रियैश्चरन् |
            आत्मवश्यैर्विधेयात्मा प्रसादमधिगच्छति || ६४ ||
        """.trimIndent(),
        hindi = """
            परंतु जो स्वाधीन अंतःकरण वाला पुरुष (विधेयात्मा) अपने मन और इन्द्रियों को पूरी तरह अपने वश में (आत्मवश्यैः) रखता है...
            और जो इन्द्रियों के विषयों में विचरते हुए भी (अर्थात् दुनिया के सारे काम करते हुए भी) 'राग' (लगाव) और 'द्वेष' (घृणा) से पूरी तरह मुक्त (वियुक्त) रहता है, वह परमात्मा की निर्मल कृपा और परम शांति (प्रसादम्) को प्राप्त करता है।
            विनाश की सीढ़ी बताने के बाद, अब भगवान श्रीकृष्ण सफलता और परम शांति (प्रसादम्) तक पहुँचने की सीढ़ी (Ladder of Elevation) बता रहे हैं।
            वे यह नहीं कहते कि इन्द्रियों को फोड़ दो या दुनिया छोड़कर किसी गुफा में भाग जाओ। यह गीता का सबसे सुंदर और व्यावहारिक (Practical) संदेश है।
            वे कहते हैं कि 'विषयानिन्द्रियैश्चरन्'—अपनी इन्द्रियों से दुनिया के सारे काम करो, अच्छा भोजन खाओ, समाज में रहो, व्यापार या युद्ध करो।
            लेकिन शर्त केवल एक है: तुम्हारी इन्द्रियां 'आत्मवश्यैः' (तुम्हारे पूरे कंट्रोल में) होनी चाहिए, और तुम्हारा मन 'राग और द्वेष' (Like and Dislike) की बीमारी से मुक्त होना चाहिए।
            जब इंसान पिज़्ज़ा इसलिए खाता है क्योंकि वह शरीर की जरूरत है, न कि 'राग' के कारण, और जब वह कड़वी दवा बिना 'द्वेष' के पी लेता है, तो वह योगी है।
            जो व्यक्ति इस तरह एक मशीन ऑपरेटर (Operator) की तरह अपने शरीर और इन्द्रियों को बिना किसी आसक्ति के चलाता है, उसके जीवन में कभी तनाव नहीं आता।
            ऐसा व्यक्ति सीधे 'प्रसादम्' को प्राप्त होता है। यहाँ प्रसाद का अर्थ मंदिर की मिठाई नहीं है, बल्कि भगवान की वह असीम 'कृपा और परम शांति' है, जो मन के सारे मैल धो देती है।
        """.trimIndent(),
        english = """
            But a person completely free from all false attachment (Raga) and absolute aversion (Dvesha), who is able to expertly control his senses (Atma-vashyaih) through the regulative principles of freedom...
            even while flawlessly interacting with the sense objects of this world, such a master of his own mind (Vidheyatma) attains the complete mercy and absolute tranquility of the Lord (Prasadam).
            After outlining the terrifying ladder of destruction, Lord Sri Krishna now presents the glorious, uplifting 'Ladder of Elevation' leading to supreme peace.
            He absolutely does not command Arjuna to physically pluck out his eyes or run away to a dark mountain cave to escape the world. This is the Gita's most beautiful, practical message.
            He specifically says 'vishayan indriyais caran'—meaning you can fully interact with the world, eat good food, do business, or fight massive wars using your senses.
            But there is one absolute, non-negotiable condition: your senses must be 'Atma-vashyaih' (under your complete, supreme control), and your mind must be entirely immune to the viruses of 'Raga' (Craving) and 'Dvesha' (Hatred).
            When a person eats simply to nourish the body without 'Raga' (addiction), and drinks bitter medicine without 'Dvesha' (disgust), he is a true Yogi.
            The person who operates his body and senses objectively, exactly like an expert machine operator entirely without emotional attachment, never experiences mental stress.
            Such a supreme master directly attains 'Prasadam'. Here, Prasada does not mean sweet food from a temple; it refers to the boundless 'Divine Mercy and Supreme Tranquility' of God that washes away all mental dirt.
        """.trimIndent()
    ),
    Shloka(
        id = 65,
        sanskrit = """
            प्रसादे सर्वदुःखानां हानिरस्योपजायते |
            प्रसन्नचेतसो ह्याशु बुद्धिः पर्यवतिष्ठते || ६५ ||
        """.trimIndent(),
        hindi = """
            परमात्मा की उस असीम कृपा और शांति (प्रसाद) के प्राप्त हो जाने पर, इस मनुष्य के सभी प्रकार के दुःखों (शारीरिक और मानसिक) का पूरी तरह से नाश (हानि) हो जाता है।
            और उस अत्यंत प्रसन्न चित्त (प्रसन्नचेतसः) वाले महापुरुष की बुद्धि बहुत ही शीघ्र (आशु) सब ओर से हटकर केवल परमात्मा में भली-भांति स्थिर (पर्यवतिष्ठते) हो जाती है।
            यह श्लोक 'प्रसाद' (ईश्वरीय कृपा और शांति) का जादुई परिणाम बताता है।
            साधारण इंसान सोचता है कि जब मेरी सारी इच्छाएं पूरी हो जाएंगी (खूब पैसा, बड़ा घर), तब मेरे दुःख खत्म होंगे और मुझे शांति मिलेगी।
            लेकिन गीता का विज्ञान इसके बिल्कुल विपरीत (Opposite) काम करता है। भगवान कहते हैं कि पहले अपनी इच्छाओं (राग-द्वेष) को छोड़ो, तो तुम्हें ईश्वर की 'शांति' (प्रसाद) मिलेगी।
            और जैसे ही वह ईश्वरीय शांति तुम्हारे मन में प्रवेश करेगी, तुम्हारे जीवन के सारे दुःख (चाहे वे कितने भी बड़े क्यों न हों) एक पल में उसी तरह नष्ट हो जाएंगे जैसे सूरज के निकलते ही अंधेरा गायब हो जाता है।
            जब मन पूरी तरह से शांत, प्रसन्न और तनाव-मुक्त (प्रसन्नचेतसः) हो जाता है, तो उस इंसान को ध्यान लगाने के लिए कोई जोर या संघर्ष नहीं करना पड़ता।
            उसकी बुद्धि 'आशु' (बहुत तेजी से और अपने-आप) बाहरी दुनिया के सारे झमेलों से हटकर एक चुंबक की तरह सीधे परमात्मा के चरणों में जाकर चिपक जाती है (स्थिर हो जाती है)।
            दुःख और चिंता में फँसा हुआ दिमाग कभी ईश्वर को नहीं समझ सकता; केवल एक आनंदित और प्रसन्न मन ही समाधि को प्राप्त कर सकता है।
        """.trimIndent(),
        english = """
            Upon achieving this supreme divine mercy and absolute tranquility (Prasade), all the threefold miseries of material existence are completely and permanently destroyed (Hanir asya upajayate) for him.
            And the intelligence of such an immensely joyful and perfectly peaceful-minded person (Prasanna-chetasah) very swiftly (Ashu) withdraws from all directions and becomes flawlessly established in the Supreme.
            This phenomenal verse explicitly reveals the highly magical and instantaneous outcome of attaining 'Prasada' (Divine grace and deep tranquility).
            An ordinary, ignorant mortal believes: "When all my hundreds of material desires are fulfilled (massive wealth, huge mansions), only then will my miseries end and I will finally find peace."
            But the flawless science of the Gita works in the exact opposite direction. The Lord states: First drop your toxic attachments and hatreds, and you will instantly attain the Lord's 'Peace' (Prasada).
            And the very exact microsecond that divine, cooling peace enters your mind, absolutely all the miseries of your life (no matter how massive) will be destroyed in a flash, just as dense darkness vanishes the moment the sun rises.
            When the mind becomes totally serene, completely stress-free, and profoundly joyous (Prasanna-chetasah), that person absolutely does not have to violently struggle or force himself to meditate.
            His intelligence 'Ashu' (extremely rapidly and effortlessly) disconnects from the chaotic noise of the world and magnetically locks itself directly onto the Supreme Lord, becoming perfectly stable.
            A brain violently suffocating in grief and anxiety can absolutely never realize God; only a profoundly joyous and peaceful mind can attain ultimate Samadhi.
        """.trimIndent()
    ),
    Shloka(
        id = 66,
        sanskrit = """
            नास्ति बुद्धिरयुक्तस्य न चायुक्तस्य भावना |
            न चाभावयतः शान्तिरशान्तस्य कुतः सुखम् || ६६ ||
        """.trimIndent(),
        hindi = """
            जो व्यक्ति योग से नहीं जुड़ा है (अयुक्तस्य - जिसने अपना मन और इन्द्रियां वश में नहीं की हैं), उसमें कभी भी सही निश्चय करने वाली 'बुद्धि' नहीं हो सकती; और उस अयुक्त मनुष्य के मन में परमात्मा के प्रति कोई सच्ची 'भावना' (ध्यान या भाव) भी नहीं हो सकती।
            जिसके मन में परमात्मा की भावना (ध्यान) नहीं है, उसे कभी 'शांति' नहीं मिल सकती; और जिसे शांति ही नहीं मिली, भला उस अशान्त इंसान को दुनिया में सच्चा 'सुख' कहाँ से मिल सकता है?
            श्रीकृष्ण यहाँ सुख और शांति का एक बहुत ही शानदार गणितीय (Mathematical) फॉर्मूला दे रहे हैं, जिसे कोई झुठला नहीं सकता।
            दुनिया का हर इंसान केवल एक ही चीज़ ढूँढ रहा है—'सुख' (Happiness)।
            लेकिन भगवान रिवर्स इंजीनियरिंग (Reverse Engineering) करके बताते हैं कि सुख कहाँ से आता है:
            क्या अशांत मन वाले को सुख मिल सकता है? नहीं। (नो पीस = नो हैप्पीनेस)।
            क्या उस इंसान को शांति मिल सकती है जिसका ईश्वर से कोई कनेक्शन (भावना/ध्यान) नहीं है? नहीं।
            क्या उस इंसान में कोई दिव्य भावना पैदा हो सकती है जिसकी बुद्धि अस्थिर (अयुक्त) है और जो हमेशा भौतिक चीजों के पीछे भागता रहता है? नहीं।
            इसलिए निष्कर्ष यह है कि जब तक इंसान इन्द्रियों के पीछे भागना बंद करके अपने मन को योग (ईश्वर) से नहीं जोड़ता, तब तक वह चाहे करोड़ों रुपए कमा ले, उसे न तो शांति मिलेगी और न ही कभी सच्चा सुख नसीब होगा।
            बिना शांति के सुख की उम्मीद करना, बिना पानी के प्यास बुझाने की कोशिश करने के समान है।
        """.trimIndent(),
        english = """
            For one who is completely disconnected from the Supreme and whose mind is uncontrolled (Ayuktasya), there is absolutely no transcendental intelligence, nor can there be any steady meditation or divine emotion (Bhavana).
            For one who is entirely devoid of such divine meditation, there can absolutely be no peace (Shantih); and for one lacking peace, how on earth can there be any true happiness (Sukham)?
            Lord Sri Krishna is delivering a spectacularly brilliant, universally applicable mathematical formula for human happiness here, which is impossible to refute.
            Every single human being in the entire world is desperately searching for exactly one thing—'Happiness' (Sukham).
            But the Lord uses flawless reverse engineering to explain exactly where true happiness actually comes from:
            Can a person whose mind is constantly agitated and restless ever experience happiness? No. (No Peace = No Happiness).
            Can a person ever attain peace if he has absolutely zero divine connection, meditation, or emotion (Bhavana) towards the Supreme? No.
            Can a person whose intelligence is completely unstable (Ayukta), wandering wildly after material objects, ever develop that deep divine emotion? No.
            Therefore, the absolute conclusion is that until a human stops running like a madman after sensory pleasures and firmly connects his mind to Yoga (God), even if he earns billions of dollars, he will never find peace, and thus, never taste true happiness.
            Expecting to experience happiness without attaining internal peace is exactly like trying to quench extreme thirst without a single drop of water.
        """.trimIndent()
    ),
    Shloka(
        id = 67,
        sanskrit = """
            इन्द्रियाणां हि चरतां यन्मनोऽनुविधीयते |
            तदस्य हरति प्रज्ञां वायुर्नावमिवाम्भसि || ६७ ||
        """.trimIndent(),
        hindi = """
            क्योंकि अपने-अपने भौतिक विषयों में लगातार भटकती हुई (चरतां) इन इन्द्रियों के पीछे जब यह मनुष्य का मन चलने लगता है...
            तो वह अकेला मन ही इस मनुष्य की सारी बुद्धि (प्रज्ञा) को उसी तरह हर (खींच) ले जाता है, जिस प्रकार पानी में तैरती हुई एक नाव को प्रचंड हवा (वायु) अपने बहाव में बहा ले जाती है।
            यह श्लोक मन और इन्द्रियों के खतरनाक गठबंधन (Alliance) का एक बहुत ही डरावना लेकिन सत्य चित्र प्रस्तुत करता है।
            भगवान एक नाव (Boat) का अत्यंत सटीक उदाहरण देते हैं। कल्पना कीजिए कि एक नाव पानी (संसार) में है, और नाव चलाने वाला (बुद्धि) उसे सही दिशा (ईश्वर/कर्तव्य) में ले जाना चाहता है।
            लेकिन हमारी इन्द्रियां (आँख, कान आदि) उस प्रचंड हवा (वायु) की तरह हैं जो किसी बहुत आकर्षक चीज़ (जैसे सुंदर रूप या स्वादिष्ट खाने) को देखकर उसकी तरफ पागलपन से बहने लगती हैं।
            अगर हमारा 'मन' उस हवा (इन्द्रियों) के साथ मिल जाए और उसका समर्थन करने लगे, तो वह हमारी सारी समझदारी, ज्ञान और बुद्धि को एक झटके में बहा ले जाता है।
            इंसान जानता है कि जंक फूड खाना या नशा करना उसके शरीर और भविष्य के लिए जहर है (यह बुद्धि है)।
            लेकिन जब उसकी जीभ (इन्द्री) स्वाद मांगती है और मन कहता है "बस एक बार खा लेते हैं", तो वह सारी बुद्धि (नाव) उसी लालच की आंधी में बह जाती है, और इंसान हार जाता है।
            इसलिए इन्द्रियों पर मन का कड़ा पहरा होना अत्यंत आवश्यक है।
        """.trimIndent(),
        english = """
            For as a strong, sweeping wind (Vayuh) violently carries away a boat drifting upon the waters (Navam ivambhasi)...
            similarly, even one of the roaming senses (Indriyanam), on which the human mind exclusively focuses and follows, can completely and forcefully sweep away a man's entire intelligence (Prajnam).
            This profoundly poetic verse paints a deeply terrifying yet absolute true picture of the highly dangerous alliance between the human mind and the wild senses.
            The Lord provides the extraordinarily precise analogy of a boat. Imagine a boat floating on the vast waters (the material world), and the skilled boatman (the intelligence) desperately wants to steer it in the right, safe direction (Duty/God).
            But our physical senses (eyes, tongue, etc.) are exactly like a massive, violent hurricane (Vayu) that starts blowing madly towards highly attractive material objects (like seductive forms or toxic addictions).
            If our 'Mind' foolishly aligns with and surrenders to that hurricane (the senses), it violently sweeps away all our logic, spiritual knowledge, and rational intelligence in a single, devastating strike.
            A person perfectly knows that eating toxic junk food or taking drugs is absolute poison for his body and future (this is his intelligence).
            But the exact moment his tongue (sense) violently craves the taste and the mind whispers "just one last time", his entire intelligence (the boat) is brutally swept away by the hurricane of greed, and the human falls.
            Therefore, maintaining a tremendously strict, iron-clad guard of the mind over the wandering senses is a matter of absolute survival.
        """.trimIndent()
    ),
    Shloka(
        id = 68,
        sanskrit = """
            तस्माद्यस्य महाबाहो निगृहीतानि सर्वशः |
            इन्द्रियाणीन्द्रियार्थेभ्यस्तस्य प्रज्ञा प्रतिष्ठिता || ६८ ||
        """.trimIndent(),
        hindi = """
            इसलिए हे महाबाहु (अर्जुन)! जिस पुरुष की इन्द्रियां उनके लुभावने विषयों (इन्द्रियार्थेभ्यः) से सब ओर से (सर्वशः) पूरी तरह खींची हुई और उसके वश में (निगृहीतानि) होती हैं...
            उसी महापुरुष की बुद्धि (प्रज्ञा) वास्तव में स्थिर (प्रतिष्ठिता) मानी जाती है।
            भगवान श्रीकृष्ण यहाँ इन्द्रिय-निग्रह (Sense Control) के अपने पूरे सिद्धांत का अंतिम निष्कर्ष (Conclusion) दे रहे हैं।
            वे अर्जुन को 'महाबाहु' (महान और शक्तिशाली भुजाओं वाला) कहकर पुकारते हैं।
            इसका बहुत गहरा अर्थ है: "हे अर्जुन! तुम्हारी मजबूत भुजाओं ने दुनिया के बड़े-बड़े राजाओं और राक्षसों को तो जीत लिया है, लेकिन असली 'महाबाहु' (महान योद्धा) वह है जो अपनी इन सूक्ष्म इन्द्रियों को जीत ले।"
            बाहर के दुश्मनों को हराना आसान है, लेकिन अपने ही भीतर बैठे लालच, क्रोध और वासना के राक्षसों को हराना ब्रह्मांड का सबसे मुश्किल काम है।
            श्रीकृष्ण बहुत स्पष्ट रूप से 'सर्वशः' (सब ओर से) शब्द का प्रयोग करते हैं। इसका मतलब है कि आपको अपनी पाँचों इन्द्रियों को कंट्रोल करना होगा।
            अगर कोई इंसान अपनी आँखें तो बंद कर ले, लेकिन कानों से गंदी बातें सुनता रहे, तो उसकी नाव (बुद्धि) डूबना तय है। किसी एक इन्द्री का लीक (Leak) होना भी पूरे सिस्टम को क्रैश कर सकता है।
            जब इंसान सब तरफ से इन इन्द्रियों को कछुए की तरह अपने सख्त कंट्रोल में कर लेता है, केवल तभी वह उस सर्वोच्च अवस्था (स्थितप्रज्ञ) पर पहुँचता है जहाँ दुनिया की कोई भी ताकत उसकी शांति को तोड़ नहीं सकती।
        """.trimIndent(),
        english = """
            Therefore, O mighty-armed Arjuna (Maha-baho)! He whose senses are completely and totally restrained (Nigrihitani) from their attractive sense objects (Indriyarthebhyah) from all sides and in all respects (Sarvashah)...
            the intelligence of that great, self-realized person is considered to be perfectly, unshakeably steady and firmly established (Pratishtita).
            Lord Sri Krishna is delivering the absolute, grand conclusion of His entire, profound doctrine on ultimate Sense Control (Indriya-nigraha) here.
            He very intentionally addresses Arjuna as 'Maha-baho' (the one with incredibly mighty, powerful arms).
            There is a brilliantly deep meaning behind this: "O Arjuna! Your massively strong physical arms have easily conquered the world's greatest kings and demons, but the true 'Maha-bahu' (Ultimate Warrior) is the one who successfully conquers his own subtle senses."
            Defeating thousands of external enemies on a battlefield is relatively easy, but slaughtering the terrifying demons of greed, lust, and anger sitting right inside your own mind is the hardest battle in the entire universe.
            Sri Krishna very explicitly uses the word 'Sarvashah' (from absolutely all sides). This strictly means you must flawlessly control all five of your senses simultaneously.
            If a man tightly shuts his eyes but continues to listen to highly toxic, degrading talk with his ears, his boat (intelligence) is 100% guaranteed to sink. Even a single sensory leak will crash the entire spiritual system.
            Only when a human being restrains these senses from all directions under his absolute, iron-clad control like a tortoise, does he finally reach that supreme state (Sthitaprajna) where absolutely no power in the universe can shatter his peace.
        """.trimIndent()
    ),
    Shloka(
        id = 69,
        sanskrit = """
            या निशा सर्वभूतानां तस्यां जागर्ति संयमी |
            यस्यां जाग्रति भूतानि सा निशा पश्यतो मुनेः || ६९ ||
        """.trimIndent(),
        hindi = """
            संपूर्ण साधारण प्राणियों के लिए जो घोर रात्रि (अंधेरा या अज्ञान) के समान है, उस परम सत्य (ईश्वर और आत्मज्ञान) की स्थिति में संयमी (ज्ञानी योगी) पूरी तरह जागता रहता है।
            और जिस नाशवान भौतिक सुख-भोग की अवस्था में सब साधारण प्राणी जागते रहते हैं (दिन-रात भागते हैं), वह तत्व को गहराई से देखने वाले मुनि के लिए एकदम रात्रि (अंधेरे) के समान है।
            यह भगवद्गीता के सबसे रहस्यमयी, दार्शनिक और काव्यात्मक (Poetic) श्लोकों में से एक है। यहाँ भगवान 'ज्ञानी' और 'अज्ञानी' के बीच का दिन-रात का अंतर बता रहे हैं।
            यहाँ 'रात' और 'दिन' का अर्थ सूरज के छिपने या निकलने से नहीं है, बल्कि यह 'चेतना' (Consciousness) का रूपक (Metaphor) है।
            दुनिया के 99% लोग पैसा, सत्ता, और शारीरिक सुखों को ही सब कुछ मानकर उनके पीछे दिन-रात पागलों की तरह भाग रहे हैं; उनके लिए भौतिक दुनिया ही 'दिन' (सच्चाई) है।
            लेकिन एक सिद्ध योगी के लिए यह सारा भौतिक खेल बिल्कुल झूठ, अंधेरा और एक 'डरावने सपने' (रात) के समान है; वह इन भौतिक चीजों में सोता है (अर्थात् इनमें कोई रुचि नहीं लेता)।
            दूसरी ओर, जो 'परम सत्य' और 'आत्मा की शांति' है, उसे दुनिया के लोग बकवास मानते हैं, वे उस आध्यात्मिक ज्ञान की ओर से पूरी तरह सोए हुए (अंधेरे में) हैं।
            लेकिन एक मुनि (ज्ञानी) उसी आध्यात्मिक सत्य में 24 घंटे जागता है, वही उसका असली 'दिन' और उसकी एकमात्र वास्तविकता है।
            स्थितप्रज्ञ व्यक्ति की पूरी दुनिया और उसका सोचने का तरीका साधारण लोगों से बिल्कुल उल्टा (180 डिग्री विपरीत) होता है।
        """.trimIndent(),
        english = """
            What is considered pitch-dark night (ignorance and darkness) for all ordinary living beings, in that absolute spiritual reality, the self-controlled sage is fully awake.
            And the material state of sensory enjoyment in which all ordinary beings are wide awake (running madly day and night), is considered as dark night (illusion) by the introspective, truth-seeing sage.
            This is undeniably one of the most profoundly mystical, philosophical, and stunningly poetic verses in the entire Bhagavad Gita. Here, the Lord sharply defines the 'Day and Night' contrast between an enlightened master and an ignorant materialist.
            Here, 'Night' and 'Day' absolutely do not refer to the physical setting and rising of the sun; they are exceptionally powerful metaphors for 'Consciousness' and 'Awareness'.
            99% of the world's population considers money, political power, and physical sex to be the absolute ultimate truth of existence, running madly after them; for them, the material matrix is their 'Day' (Reality).
            But for a perfected, self-realized Yogi, this entire material rat-race is a complete lie, total darkness, and a terrifying 'Nightmare' (Night); he is fast asleep towards these material things (meaning he has zero interest in them).
            On the other hand, the 'Supreme Absolute Truth' and 'Eternal Soul', which ordinary people completely ignore and sleep through (treating it as darkness/night), is exactly where the sage lives.
            The sage is 100% fully awake in that blinding spiritual truth 24 hours a day; that is his actual 'Day' and his only genuine reality.
            The entire worldview and psychological operating system of a Sthitaprajna is exactly 180 degrees opposite to that of the ordinary, deluded masses.
        """.trimIndent()
    ),
    Shloka(
        id = 70,
        sanskrit = """
            आपूर्यमाणमचलप्रतिष्ठं समुद्रमापः प्रविशन्ति यद्वत् |
            तद्वत्कामा यं प्रविशन्ति सर्वे स शान्तिमाप्नोति न कामकामी || ७० ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार सब ओर से जल से लबालब भरे हुए और अपनी मर्यादा में अचल (स्थिर) रहने वाले विशाल समुद्र में हजारों नदियां आकर प्रवेश करती हैं, लेकिन वे समुद्र को ज़रा भी विचलित (हिला) नहीं पातीं...
            ठीक उसी प्रकार, जिस संयमी महापुरुष के भीतर सभी भौतिक इच्छाएं और कामनाएं (बिना कोई विकार पैदा किए) प्रवेश करके शांत हो जाती हैं, वही मनुष्य परम 'शांति' को प्राप्त होता है; न कि वह जो इच्छाओं को पूरा करने के पीछे भागता रहता है (कामकामी)।
            श्रीकृष्ण एक ज्ञानी मुनि के मन की विशालता को समझाने के लिए यहाँ 'समुद्र' (Ocean) का सबसे भव्य और शक्तिशाली उदाहरण दे रहे हैं।
            बारिश के मौसम में हजारों उफनती हुई नदियां अपना गंदा और तेज़ पानी लेकर समुद्र में गिरती हैं। लेकिन क्या समुद्र का स्तर बढ़ जाता है? क्या समुद्र अपनी सीमा तोड़कर बाहर आ जाता है? नहीं, वह अपनी गहराई में एकदम अचल और शांत रहता है।
            उसी प्रकार, एक ज्ञानी व्यक्ति (स्थितप्रज्ञ) के जीवन में भी हजारों भौतिक आकर्षण, सुंदर चीज़ें, या लोग (नदियों के समान) उसके सामने आते हैं।
            लेकिन उसका मन ईश्वर के असीम आनंद से इतना 'आपूर्यमाण' (पूरी तरह लबालब भरा हुआ) है कि बाहर की कोई भी इच्छा उसके मन में कोई लहर या तूफान पैदा नहीं कर पाती।
            वे इच्छाएं उसके मन में आती हैं और उसी में विलीन होकर मर जाती हैं, बिना उसे हिलाए।
            शांति उस भिखारी को कभी नहीं मिलती जो दिन-रात अपनी एक-एक इच्छा (डिजायर) को पूरा करने के पीछे भागता है ('कामकामी')।
            सच्ची शांति केवल उस 'आध्यात्मिक समुद्र' को मिलती है जिसका भीतर का खजाना इतना बड़ा है कि बाहर की दुनिया उसे रत्ती भर भी लुभा नहीं सकती।
        """.trimIndent(),
        english = """
            Just as the incredibly vast ocean is always being filled by thousands of rapidly flowing rivers, but remains completely unagitated, steady, and immovable (Achala-pratishtham) within its boundaries...
            in the exact same manner, a person within whom all material desires endlessly enter without creating the slightest disturbance, alone achieves absolute 'Peace' (Shanti); and certainly not the person who constantly strives to satisfy those desires (Kama-kami).
            To brilliantly illustrate the unfathomable vastness and stability of an enlightened sage's mind, Sri Krishna provides the most majestic and powerful analogy of the 'Ocean' here.
            During the fierce monsoon season, thousands of violent, flooded rivers pour their muddy, rushing waters directly into the vast ocean. But does the ocean level rise? Does the ocean panic and cross its boundaries? No, it remains absolutely immovable, silent, and majestic in its depth.
            Similarly, in the daily life of an enlightened master (Sthitaprajna), thousands of material temptations, beautiful objects, and sensual offers (like the rivers) constantly appear before him.
            But his consciousness is so 'Apuryamanam' (filled to the absolute brim) with the infinite, ecstatic bliss of the Supreme Lord that no external desire can create even a microscopic ripple or storm in his mind.
            Those desires simply enter his mind, dissolve, and die completely, without shaking him even a millimeter.
            True peace absolutely never comes to that pathetic beggar ('Kama-kami') who runs madly day and night trying to extinguish the fire of his endless desires by fulfilling them.
            Absolute, supreme peace belongs solely to that 'Spiritual Ocean' whose internal treasure is so incredibly massive that the entire external material world cannot tempt him in the slightest.
        """.trimIndent()
    ),
    Shloka(
        id = 71,
        sanskrit = """
            विहाय कामान्यः सर्वान्पुमांश्चरति निःस्पृहः |
            निर्ममो निरहङ्कारः स शान्तिमधिगच्छति || ७१ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य मन की सभी सांसारिक कामनाओं (इच्छाओं) को पूरी तरह त्याग कर (विहाय)...
            भौतिक सुखों की हर प्रकार की लालसा से मुक्त होकर (निःस्पृहः), ममतारहित (यह 'मेरा' है, इस भाव से मुक्त) और अहंकार-रहित (यह 'मैं' हूँ, इस घमंड से मुक्त) होकर इस संसार में विचरण करता है (काम करता है), वही मनुष्य परम शांति को प्राप्त करता है।
            यह श्लोक शांति (Peace) प्राप्त करने का दुनिया का सबसे छोटा और सबसे सटीक 'फॉर्मूला' (Formula) है। इसमें भगवान ने शांति के लिए चार अचूक शर्तें रखी हैं:
            १. 'विहाय कामान् सर्वान्': मन में उठने वाली 100% स्वार्थी इच्छाओं को कूड़ेदान में फेंक दो। "मुझे यह चाहिए, मुझे वह चाहिए" की रट बंद करो।
            २. 'निःस्पृहः': भविष्य में किसी भौतिक चीज़ के मिलने की लालसा (Craving) भी छोड़ दो।
            ३. 'निर्ममो' (ममता से मुक्त): किसी भी व्यक्ति, वस्तु, या पैसे पर यह दावा मत करो कि "यह मेरा है"। सब कुछ ईश्वर का है, तुम केवल केयरटेकर (Caretaker) हो। जब 'मेरा' ही कुछ नहीं, तो खोने का डर भी नहीं।
            ४. 'निरहङ्कारः' (अहंकार से मुक्त): "मैं बहुत बड़ा आदमी हूँ, मैं बहुत ज्ञानी हूँ, मैंने यह काम किया है"—इस 'मैं' (Ego) की बीमारी को पूरी तरह खत्म कर दो।
            जो व्यक्ति इन चार भारी जंजीरों को तोड़कर इस दुनिया में सामान्य रूप से जीता और काम करता है, उसका मन एक ऐसा 'नो-फ्लाई ज़ोन' (No-fly zone) बन जाता है जहाँ दुःख या तनाव कभी प्रवेश नहीं कर सकते।
            केवल ऐसा ही पूर्ण वैरागी व्यक्ति जीवन की सर्वोच्च और परम शांति का अनुभव करता है।
        """.trimIndent(),
        english = """
            That person who has completely given up and thrown away absolutely all material desires for sense gratification (Vihaya kaman sarvan)...
            who lives and acts in this world totally free from all cravings (Nihsprihah), completely devoid of any sense of false proprietorship (Nirmamo - nothing is 'mine'), and entirely free from false ego (Nirankarah - 'I am the doer'), he alone can attain ultimate, supreme peace.
            This stunning verse is universally considered the world's shortest, most brutally precise, and absolute 'Master Formula' for achieving permanent mental peace. The Lord lays down four unbreakable conditions:
            1. 'Vihaya kaman sarvan': Violently throw 100% of all selfish, material desires into the trash can. Completely stop the toxic, endless chanting of "I want this, I need that."
            2. 'Nihsprihah': Completely eradicate even the subtle, hidden craving or lingering hope for any future material enjoyment.
            3. 'Nirmamo' (Free from ownership): Never arrogantly claim, "This house, this family, or this money is MINE." Everything belongs strictly to God; you are merely a temporary caretaker. When absolutely nothing is 'yours', there is zero fear of losing anything.
            4. 'Nirankarah' (Free from false Ego): Completely annihilate the blinding disease of "I" ("I am so great, I am so rich, I am the ultimate doer of this action").
            A human being who violently shatters these four heavy iron chains and then simply lives and performs his duties in this world turns his mind into a supreme 'No-fly zone' where stress, depression, or sorrow can never enter.
            Only such a perfectly detached, profoundly surrendered sage actually tastes the absolute, ultimate, and highest peace of existence.
        """.trimIndent()
    ),
    Shloka(
        id = 72,
        sanskrit = """
            एषा ब्राह्मी स्थितिः पार्थ नैनां प्राप्य विमुह्यति |
            स्थित्वास्यामन्तकालेऽपि ब्रह्मनिर्वाणमृच्छति || ७२ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ (अर्जुन)! यह 'ब्राह्मी स्थिति' (परब्रह्म परमात्मा को प्राप्त किए हुए मनुष्य की दिव्य अवस्था) है। इस परम अवस्था को प्राप्त कर लेने के बाद मनुष्य कभी दोबारा मोह (अज्ञान) में नहीं फँसता (विमुह्यति)।
            और यदि जीवन के बिल्कुल अंतिम समय (मृत्यु के क्षण - अन्तकाले) में भी कोई मनुष्य इस ब्राह्मी स्थिति में टिक जाए, तो वह निश्चित रूप से 'ब्रह्म-निर्वाण' (भगवान के परम धाम और मोक्ष) को प्राप्त कर लेता है।
            यहाँ भगवद्गीता के दूसरे अध्याय (सांख्य योग) का अत्यंत ही शानदार और राजसी समापन (Grand Finale) होता है।
            भगवान श्रीकृष्ण स्थितप्रज्ञ योगी की उस अंतिम अवस्था को एक नाम देते हैं: 'ब्राह्मी स्थिति' (The Divine State of God Consciousness)।
            एक बार जब कोई इंसान अपनी इन्द्रियों और अहंकार को मारकर इस परम दिव्य चेतना (Level of Consciousness) को छू लेता है, तो भगवान गारंटी देते हैं कि वह फिर कभी माया या अज्ञान ('विमुह्यति') के गंदे नाले में वापस नहीं गिरता।
            और सबसे बड़ी दया और आशा की बात भगवान अंतिम लाइन में कहते हैं: "अन्तकालेऽपि" (मृत्यु के अंतिम पल में भी)।
            यदि किसी व्यक्ति ने पूरी जिंदगी गलतियां की हों, लेकिन मरने से ठीक एक सेकंड पहले भी यदि उसका अहंकार टूट जाए, वह अपनी वासनाएं छोड़ दे, और उसका मन पूरी तरह से ईश्वर में एकाग्र (ब्राह्मी स्थिति) हो जाए...
            तो भगवान इतने दयालु हैं कि वे उसे तुरंत 'ब्रह्म-निर्वाण' (जन्म-मरण से पूर्ण आज़ादी और वैकुंठ धाम) प्रदान कर देते हैं।
            यह श्लोक पूरी मानव जाति के लिए सबसे बड़ी आशा (Hope) है कि ईश्वर को पाने के लिए कभी भी बहुत देर नहीं होती।
            यहीं पर अर्जुन को यह स्पष्ट हो जाता है कि युद्ध से भागना अज्ञान है, और निष्काम भाव से ईश्वर पर ध्यान लगाते हुए युद्ध करना ही यह 'ब्राह्मी स्थिति' है।
        """.trimIndent(),
        english = """
            O Partha (Arjuna)! This is the supreme 'Brahmi Sthiti' (the ultimate spiritual and divine state of God-consciousness). After attaining this absolute state, a human being is never again bewildered or trapped in illusion (Vimuhyati).
            And if one is firmly situated in this supreme divine consciousness even at the exact, final hour of death (Anta-kale api), he undoubtedly attains 'Brahma-nirvana' (entry into the eternal kingdom of God/Liberation).
            This verse marks the incredibly majestic, glorious, and breathtaking 'Grand Finale' of the Second Chapter (Sankhya Yoga) of the Bhagavad Gita.
            Lord Sri Krishna officially gives a title to this ultimate, perfected state of the Sthitaprajna Yogi: 'Brahmi Sthiti' (The Absolute Divine State of God Consciousness).
            Once a human being brutally slaughters his ego and senses, and successfully touches this staggering altitude of spiritual consciousness, the Lord gives an iron-clad guarantee that he will never, ever fall back into the filthy gutter of Maya (illusion and ignorance) again.
            And the absolute greatest, most overwhelmingly merciful message of hope is delivered by the Lord in the final line: "Anta-kale api" (Even at the very last second of death).
            Even if a person has lived a completely corrupted life, but somehow, just one microsecond before drawing his final breath, his ego shatters, he drops all desires, and his mind flawlessly locks onto the Supreme Lord (attaining Brahmi Sthiti)...
            the Supreme Lord is so unfathomably merciful that He instantly grants that soul 'Brahma-nirvana' (absolute, eternal liberation from the cycle of rebirth and entry into the spiritual sky).
            This profound verse is the absolute greatest beacon of hope for all mankind—proving that it is never, ever too late to surrender to God.
            Here, it becomes crystal clear to Arjuna that running away from the war is sheer ignorance, and fighting fiercely while selflessly meditating on God is the true 'Brahmi Sthiti'.
        """.trimIndent()
    )
)