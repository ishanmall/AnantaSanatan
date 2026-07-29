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

// 1. Data Model
data class Shloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

// 2. Main Composable Screen
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AdhyayaOne() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    // Function to handle the search logic dynamically
    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            // Find the exact index of the Shloka with this ID
            val targetIndex = adhyayaOneShlokas.indexOfFirst { it.id == shlokaNum }

            if (targetIndex != -1) {
                coroutineScope.launch {
                    listState.animateScrollToItem(targetIndex)
                }
                // Hide keyboard after successful search
                keyboardController?.hide()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Search Bar Area
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (e.g., 10)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search // Shows search icon on keyboard
            ),
            keyboardActions = KeyboardActions(
                onSearch = { performSearch() } // Triggers search from keyboard button
            ),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump to Shloka")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Scrollable List of Shlokas
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(adhyayaOneShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

// 3. UI Component for individual Shlokas
@Composable
fun ShlokaCard(shloka: Shloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Shloka ${shloka.id}", // Fixed from shloka.number
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = shloka.sanskrit,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = shloka.hindi,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = shloka.english,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

// 4. The Data Repository (Shlokas 1 to 20)
val adhyayaOneShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            धृतराष्ट्र उवाच |
            धर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः |
            मामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय || १ ||
        """.trimIndent(),
        hindi = """
            धृतराष्ट्र ने संजय से पूछा: हे संजय! धर्मभूमि कुरुक्षेत्र में इस समय क्या हो रहा है?
            युद्ध की प्रबल इच्छा से वहाँ इकट्ठे हुए मेरे पुत्रों (कौरवों) ने क्या किया?
            और मेरे भाई पाण्डु के पुत्रों (पाण्डवों) ने वहाँ एकत्र होकर क्या निर्णय लिया?
            यह प्रथम श्लोक सम्पूर्ण भगवद्गीता का मूल बीज है, जहाँ से यह महान संवाद शुरू होता है।
            'धर्मक्षेत्रे' शब्द यह स्पष्ट दर्शाता है कि यह युद्ध केवल सत्ता का नहीं, बल्कि धर्म का है।
            धृतराष्ट्र जन्म से शारीरिक रूप से अंधे थे, परंतु पुत्र मोह में वे आत्मिक रूप से भी अंधे थे।
            'मामकाः' (मेरे) और 'पाण्डवाः' (पांडु के) शब्दों में उनका घोर पक्षपात और विभाजन झलकता है।
            वे भीतर से डरे हुए थे और जानना चाहते थे कि इस पवित्र भूमि का उनके पुत्रों पर क्या प्रभाव पड़ा।
            क्या कुरुक्षेत्र की पवित्रता के प्रभाव से उनके दुष्ट मन में कोई पश्चाताप या शांति का भाव आया है?
            यह प्रश्न एक अंधे पिता के गहरे स्वार्थ, आसक्ति और भयानक युद्ध के परिणामों के आंतरिक भय को दर्शाता है।
        """.trimIndent(),
        english = """
            Dhritarashtra asked Sanjaya: O Sanjaya! What is happening in the holy land of Kurukshetra?
            After assembling there with a strong desire to fight, what did my sons (Kauravas) do?
            And what did the sons of my brother Pandu (Pandavas) do after gathering on the battlefield?
            This very first verse is the foundational seed of the entire Bhagavad Gita dialogue.
            The word 'Dharmakshetre' clearly indicates that this is a war of righteousness, not just power.
            Dhritarashtra was physically blind from birth, but he was also spiritually blinded by attachment.
            His use of 'Mamakaha' (mine) and 'Pandavaha' (Pandu's) shows his deep-rooted nepotism and division.
            He was internally fearful and wanted to know if this holy land had any impact on his wicked sons.
            Did the pious nature of Kurukshetra bring any repentance or peaceful thoughts to their minds?
            This single question exposes a blind father's deep selfishness, attachment, and fear of the war's outcome.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            सञ्जय उवाच |
            दृष्ट्वा तु पाण्डवानीकं व्यूढं दुर्योधनस्तदा |
            आचार्यमुपसङ्गम्य राजा वचनमब्रवीत् || २ ||
        """.trimIndent(),
        hindi = """
            संजय ने धृतराष्ट्र को उत्तर देते हुए कहा: उस समय युद्धभूमि का दृश्य अत्यंत गंभीर था।
            पाण्डवों की विशाल सेना को एक अचूक और अभेद्य व्यूहरचना से युक्त देखकर राजा दुर्योधन विचलित हो गया।
            उसने तुरंत अपने गुरु द्रोणाचार्य के पास जाकर कूटनीति से भरे हुए यह महत्वपूर्ण वचन कहे।
            संजय, जिन्हें महर्षि वेदव्यास ने दिव्य दृष्टि प्रदान की थी, आँखों देखा हाल बताना आरंभ करते हैं।
            दुर्योधन, जो कि कूटनीति और राजनीति का ज्ञाता है, पांडवों की सुव्यवस्थित सेना देखकर भीतर से घबरा गया है।
            यद्यपि पांडवों की सेना कौरवों की तुलना में छोटी थी, फिर भी उनकी व्यूहरचना ने दुर्योधन के मन में भय उत्पन्न कर दिया।
            अपने इस आंतरिक भय को छिपाने और सेना का मनोबल बनाए रखने के लिए, वह तुरंत गुरु के पास जाता है।
            गुरु के पास इस तरह जाना उसके कूटनीतिक स्वभाव और उसकी गहरी राजनीतिक चाल को दर्शाता है।
            वह चाहता है कि गुरु द्रोणाचार्य पांडवों के प्रति कोई सहानुभूति न रखें और पूरी शक्ति से उनका नाश करें।
            यह श्लोक दुर्योधन के भारी अहंकार के पीछे छिपी हुई उसकी गहरी असुरक्षा को बहुत स्पष्ट रूप से उजागर करता है।
        """.trimIndent(),
        english = """
            Sanjaya replied to Dhritarashtra: At that time, the scene on the battlefield was extremely serious.
            Seeing the vast army of the Pandavas arranged in an impenetrable military formation, King Duryodhana became disturbed.
            He immediately approached his martial teacher, Dronacharya, and spoke these highly diplomatic words.
            Sanjaya, who was granted divine vision by Sage Vedavyasa, begins to narrate the live events.
            Duryodhana, a master of diplomacy and politics, is internally terrified seeing the highly organized Pandava army.
            Although the Pandava army was smaller than the Kauravas', their flawless formation instilled deep fear in Duryodhana's mind.
            To hide this internal fear and to maintain his army's morale, he immediately goes to his teacher.
            Approaching the teacher in this manner demonstrates his diplomatic nature and deep political cunning.
            He wants to ensure that Dronacharya holds no sympathy for the Pandavas and fights them with his absolute maximum power.
            This verse very clearly exposes the deep insecurity hidden directly behind Duryodhana's massive ego.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम् |
            व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता || ३ ||
        """.trimIndent(),
        hindi = """
            हे आचार्य! पाण्डु-पुत्रों की इस बड़ी भारी और अत्यंत विशाल सेना को ध्यान से देखिए।
            इस सेना को आपके ही अत्यंत बुद्धिमान शिष्य द्रुपद-पुत्र धृष्टद्युम्न ने व्यूहाकार खड़ा किया है।
            यहाँ दुर्योधन अपनी कूटनीति का प्रयोग करते हुए जानबूझकर गुरु द्रोणाचार्य को उकसाने का प्रयास कर रहा है।
            वह उन्हें याद दिलाता है कि विपक्ष का मुख्य सेनापति वही धृष्टद्युम्न है, जो राजा द्रुपद का पुत्र है।
            राजा द्रुपद और गुरु द्रोणाचार्य के बीच एक पुराना और अत्यंत गहरा राजनीतिक बैर था।
            धृष्टद्युम्न का जन्म ही विशेष रूप से गुरु द्रोणाचार्य का वध करने के स्पष्ट उद्देश्य से हुआ था।
            फिर भी, द्रोणाचार्य ने अपने ब्राह्मण धर्म का पालन करते हुए उसे अस्त्र-शस्त्र की महान शिक्षा दी थी।
            दुर्योधन 'आपके बुद्धिमान शिष्य' कहकर द्रोणाचार्य की उस पुरानी उदारता पर गहरा व्यंग्य कस रहा है।
            उसका मुख्य उद्देश्य गुरु के हृदय में पांडवों और पांचालों के प्रति अत्यंत क्रोध और प्रतिशोध जगाना है।
            वह चाहता है कि द्रोणाचार्य युद्ध में कोई भी रियायत न बरतें और अपनी पूरी शक्ति से पांडवों का नाश करें।
        """.trimIndent(),
        english = """
            O my respected teacher! Please carefully behold this mighty, heavy, and vast army of the sons of Pandu.
            This great army has been expertly arranged in a strategic formation by your highly intelligent disciple, the son of Drupada.
            Here, Duryodhana is using his cunning diplomacy and intentionally trying to strongly provoke his guru Dronacharya.
            He reminds his teacher that the primary opposing commander is none other than Dhrishtadyumna, the son of King Drupada.
            King Drupada and Guru Dronacharya shared a very old, bitter, and deep-rooted political enmity.
            It was a known fact that Dhrishtadyumna was born specifically with the clear purpose of killing Dronacharya.
            Yet, Dronacharya, strictly following his supreme duty as a teacher, had imparted great military education to him.
            By saying 'your intelligent disciple', Duryodhana is sharply mocking Dronacharya's past leniency and generosity.
            His primary goal is to ignite feelings of intense anger and revenge in his teacher's heart against the Pandavas.
            He wants to ensure that Dronacharya shows absolutely no mercy and fights with his maximum destructive power.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            अत्र शूरा महेष्वासा भीमार्जुनसमा युधि |
            युयुधानो विराटश्च द्रुपदश्च महारथः || ४ ||
        """.trimIndent(),
        hindi = """
            इस पांडव सेना में बड़े-बड़े धनुषों वाले अत्यंत शूरवीर और महान योद्धा उपस्थित हैं।
            युद्ध भूमि में वे सभी पराक्रम और शक्ति में साक्षात् भीम और अर्जुन के ही समान हैं।
            इनमें महान शूरवीर सात्यकि (युयुधान) और राजा विराट जैसे अजेय योद्धा पूरी तैयारी से खड़े हैं।
            इनके साथ ही महारथी राजा द्रुपद भी हैं, जो अकेले ही दस हजार सैनिकों से लड़ने में पूरी तरह सक्षम हैं।
            दुर्योधन जानबूझकर पांडवों की सेना के इन प्रमुख योद्धाओं की एक-एक करके गणना कर रहा है।
            वह भली-भांति जानता है कि भीम और अर्जुन अजेय हैं, इसलिए वह अन्य योद्धाओं की तुलना उन्हीं से करता है।
            अपने गुरु के सामने इन महान योद्धाओं का विस्तृत वर्णन करके दुर्योधन विपक्ष की ताकत का आकलन कर रहा है।
            वह अपने पक्ष के सेनापतियों को जताना चाहता है कि वे दुश्मन की शक्ति को बिल्कुल भी हल्के में न लें।
            यह विस्तृत वर्णन उसकी अपनी आंतरिक घबराहट और गहरे मनोवैज्ञानिक भय का भी स्पष्ट सूचक है।
            वह सामने खड़ी इस भयंकर चुनौती और युद्ध के विनाशकारी परिणामों को बहुत स्पष्ट रूप से देख पा रहा है।
        """.trimIndent(),
        english = """
            Present in this Pandava army are incredibly heroic warriors wielding massive and highly powerful bows.
            In the battlefield, they are all completely equal in might, strength, and valor to the great Bhima and Arjuna.
            Among them stand fully prepared and unconquerable heroes like Yuyudhana (Satyaki) and the mighty King Virata.
            Along with them is the great Maharatha King Drupada, who is fully capable of fighting ten thousand soldiers alone.
            Duryodhana is intentionally and very carefully enumerating these key warriors of the opposing Pandava army one by one.
            He knows very well that Bhima and Arjuna are invincible, so he uses them as the ultimate benchmark for comparison.
            By detailing these great warriors to his teacher, Duryodhana is carefully evaluating the enemy's massive strength.
            He wants to deeply impress upon his own commanders that they must never ever underestimate the enemy's power.
            This highly detailed description is also a very clear indicator of his own internal nervousness and deep psychological fear.
            He can very clearly see the terrifying challenge standing before him and the potentially devastating consequences of this war.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            धृष्टकेतुश्चेकितानः काशिराजश्च वीर्यवान् |
            पुरुजित्कुन्तिभोजश्च शैब्यश्च नरपुङ्गवः || ५ ||
        """.trimIndent(),
        hindi = """
            इनके अलावा यहाँ धृष्टकेतु, चेकितान और अत्यंत बलवान काशिराज जैसे महान पराक्रमी योद्धा भी हैं।
            साथ ही पुरुजित, कुन्तिभोज और मनुष्यों में सर्वश्रेष्ठ माने जाने वाले वीर शैब्य भी यहाँ उपस्थित हैं।
            दुर्योधन पांडव पक्ष के अन्य शक्तिशाली राजाओं और शूरवीरों का यह वर्णन लगातार जारी रखता है।
            वह शिशुपाल के पराक्रमी पुत्र धृष्टकेतु और एक अत्यंत प्रसिद्ध यादव योद्धा चेकितान का उल्लेख करता है।
            इसके साथ ही वह कुंती के पालक पिता के परिवार से आने वाले राजा कुंतिभोज का भी विशेष नाम लेता है।
            वह राजा शिबि के महान वंशज शैब्य को 'नरपुंगव' अर्थात् मनुष्यों में श्रेष्ठ और बैल के समान बलवान कहकर पुकारता है।
            इन सभी प्रतापी राजाओं के नामों को एक साथ गिनाने के पीछे दुर्योधन का एक विशेष राजनीतिक तात्पर्य है।
            वह यह बताना चाहता है कि पांडवों को चारों दिशाओं के महान और शक्तिशाली राजाओं का पूर्ण समर्थन प्राप्त है।
            दुर्योधन द्रोणाचार्य को यह कड़वी सच्चाई महसूस कराना चाहता है कि यह सेना केवल पांच भाइयों की नहीं है।
            बल्कि यह उस युग के सर्वश्रेष्ठ और अद्वितीय योद्धाओं का महासम्मेलन है, जिनसे पार पाना बहुत कठिन होगा।
        """.trimIndent(),
        english = """
            Apart from them, there are immensely mighty warriors like Dhrishtaketu, Chekitana, and the highly powerful King of Kashi.
            Also present here are Purujit, Kuntibhoja, and the heroic Shaibya, who is considered the absolute best among men.
            Duryodhana continuously proceeds with this detailed description of the powerful kings and heroes on the Pandava side.
            He mentions Dhrishtaketu, the mighty son of Shishupala, and Chekitana, an extremely famous and powerful Yadava warrior.
            Along with them, he makes a special mention of King Kuntibhoja, who comes from the family of Kunti's adoptive father.
            He addresses Shaibya, the great descendant of King Shibi, as 'Nara-pungava', meaning an exceedingly strong hero among men.
            There is a very specific political purpose behind Duryodhana enumerating the names of all these illustrious kings together.
            He wants to highlight that the Pandavas have secured the complete and unwavering support of mighty kings from all directions.
            Duryodhana wants to make Dronacharya truly realize the bitter truth that this army is not just composed of five brothers.
            Rather, it is a massive grand alliance of the era's absolute best warriors, whom it will be extremely difficult to defeat.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            युधामन्युश्च विक्रान्त उत्तमौजाश्च वीर्यवान् |
            सौभद्रो द्रौपदेयाश्च सर्व एव महारथाः || ६ ||
        """.trimIndent(),
        hindi = """
            इनके अतिरिक्त यहाँ अत्यंत पराक्रमी युधामन्यु और महान बलवान उत्तमौजा भी अपनी पूरी सेना के साथ हैं।
            सुभद्रा के वीर पुत्र अभिमन्यु और महारानी द्रौपदी के पाँचों पुत्र भी पूरी युद्ध-तैयारी के साथ खड़े हैं।
            ये सभी के सभी शूरवीर कोई साधारण योद्धा नहीं, बल्कि अपने आप में महान 'महारथी' की उपाधि वाले हैं।
            पांडवों की सेना के इन अंतिम प्रमुख योद्धाओं का वर्णन करते हुए दुर्योधन युधामन्यु का विशेष नाम लेता है।
            युधामन्यु और उत्तमौजा पांचाल देश के महान और अत्यंत भयंकर युद्ध कौशल वाले योद्धा माने जाते थे।
            इसके बाद वह अर्जुन और सुभद्रा के अत्यंत वीर और युवा पुत्र अभिमन्यु (सौभद्र) का विशेष रूप से उल्लेख करता है।
            साथ ही वह द्रौपदी के पांचों पुत्रों (प्रतिविन्ध्य, सुतसोम, श्रुतकर्मा, शतानीक और श्रुतसेन) को भी इस सूची में गिनता है।
            दुर्योधन इन सभी युवा योद्धाओं को भी बिना किसी संकोच के 'महारथी' की महान उपाधि से घोषित करता है।
            एक महारथी वह श्रेष्ठ योद्धा होता है जो अस्त्र-शस्त्र में अत्यंत निपुण हो और दस हजार धनुर्धरों से अकेला लड़ सके।
            दुर्योधन जानबूझकर यह बता रहा है कि पांडवों की यह युवा पीढ़ी भी युद्ध में किसी भी अनुभवी सेनापति से कम नहीं है।
        """.trimIndent(),
        english = """
            Additionally, the incredibly mighty Yudhamanyu and the highly powerful Uttamauja are present here with their entire forces.
            The heroic son of Subhadra, Abhimanyu, and the five sons of Queen Draupadi are also standing fully prepared for war.
            All these great warriors are not ordinary soldiers at all, but they individually hold the great title of 'Maharathas'.
            While describing these final key warriors of the Pandava army, Duryodhana specifically takes the name of Yudhamanyu.
            Yudhamanyu and Uttamauja were universally considered remarkably great warriors from Panchala with terrifying combat skills.
            After this, he makes a highly special mention of Abhimanyu (Saubhadra), the extremely brave young son of Arjuna and Subhadra.
            Along with him, he also meticulously includes the five sons of Draupadi (Prativindhya, Sutasoma, Shrutakarma, Shatanika, and Shrutasena).
            Duryodhana openly declares all these young warriors as 'Maharathas' without any hesitation or underestimation of their power.
            A Maharatha is an elite warrior perfectly skilled in weaponry and fully capable of fighting ten thousand archers alone.
            Duryodhana is intentionally pointing out that even this younger generation of Pandavas is equal to any veteran military commander.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम |
            नायका मम सैन्यस्य संज्ञार्थं तान्ब्रवीमि ते || ७ ||
        """.trimIndent(),
        hindi = """
            हे ब्राह्मणों में श्रेष्ठ (द्विजोत्तम)! अब हमारे पक्ष में जो सबसे प्रधान और विशिष्ट योद्धा हैं, उन्हें भी आप जान लीजिए।
            मेरी इस विशाल सेना के जो मुख्य सेनापति और नायक हैं, आपकी जानकारी के लिए मैं उनके नाम आपको बताता हूँ।
            पांडवों की सेना का विस्तार से वर्णन करने के बाद दुर्योधन को शायद अपनी ही मनोवैज्ञानिक भूल का गहरा एहसास हुआ।
            उसे लगा कि उसने विपक्ष की कुछ ज्यादा ही प्रशंसा कर दी है, जिससे उसके अपने ही खेमे का मनोबल गिर सकता है।
            इस नकारात्मक प्रभाव को संतुलित करने के लिए वह तुरंत ही अपना ध्यान अपनी स्वयं की सेना की ओर मोड़ता है।
            वह गुरु द्रोणाचार्य को 'द्विजोत्तम' (ब्राह्मणों में श्रेष्ठ) कहकर अत्यंत सम्मानपूर्वक तरीके से संबोधित करता है।
            यह एक सम्मानजनक शब्द अवश्य है, लेकिन इसके पीछे दुर्योधन की अपनी एक विशेष राजनीतिक और कूटनीतिक मानसिकता भी है।
            वह शायद याद दिला रहा है कि द्रोणाचार्य जन्म से ब्राह्मण हैं, क्षत्रिय नहीं, इसलिए उन्हें युद्ध में अधिक क्रूर होना होगा।
            वह कहता है कि वह अपनी सेना के नायकों का परिचय केवल इसलिए दे रहा है ताकि द्रोणाचार्य उन्हें अच्छी तरह पहचान लें।
            यहाँ दुर्योधन वास्तव में अपनी ही सेना की महान शक्ति को याद करके स्वयं के डगमगाते हृदय को सांत्वना देने का प्रयास कर रहा है।
        """.trimIndent(),
        english = """
            O best among the Brahmanas (Dvijottama)! Now please also know those who are the most distinguished warriors on our side.
            For your complete information, I shall now recount the names of the principal captains and commanders of my own vast army.
            After extensively describing the Pandava army, Duryodhana perhaps deeply realized his own psychological mistake.
            He felt that he had praised the opposition a bit too much, which could easily demoralize his own military camp.
            To immediately balance this negative psychological impact, he swiftly shifts his complete attention toward his own military forces.
            He addresses his teacher Dronacharya as 'Dvijottama' (best among the Brahmanas) in a highly respectful and formal manner.
            While this is certainly a term of respect, it also hides a specific political and diplomatic mindset typical of Duryodhana.
            He is perhaps subtly reminding him that Dronacharya is a Brahmana by birth, not a Kshatriya, and must act fiercely in war.
            He states that he is introducing the heroes of his army merely so that Dronacharya is fully aware of their powerful presence.
            Here, Duryodhana is actually trying desperately to console his own trembling heart by recalling the immense power of his own army.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            भवान्भीष्मश्च कर्णश्च कृपश्च समितिञ्जयः |
            अश्वत्थामा विकर्णश्च सौमदत्तिस्तथैव च || ८ ||
        """.trimIndent(),
        hindi = """
            एक तो स्वयं आप (द्रोणाचार्य), पितामह भीष्म, और महान धनुर्धर कर्ण तथा युद्ध में सदा विजयी रहने वाले कृपाचार्य हैं।
            तथा इनके अलावा महान योद्धा अश्वत्थामा, मेरा भाई विकर्ण और सोमदत्त के पराक्रमी पुत्र भूरिश्रवा भी इस सेना में उपस्थित हैं।
            दुर्योधन अपनी सेना के मनोबल को बढ़ाने के लिए अपने पक्ष के सभी अजेय महारथियों की एक विस्तृत सूची प्रस्तुत करता है।
            वह कूटनीति का प्रयोग পুনঃ सबसे पहले अत्यंत सम्मानपूर्वक अपने गुरु द्रोणाचार्य (भवान्) का ही नाम लेता है।
            फिर वह अपनी पूरी सेना के मुख्य सेनापति और सबसे महान योद्धा भीष्म पितामह का पूरे आदर के साथ स्मरण करता है।
            इसके बाद वह अपने परम मित्र, सबसे बड़े समर्थक और अर्जुन के समान महान धनुर्धर कर्ण का नाम बहुत गर्व से लेता है।
            फिर वह कृपाचार्य का उल्लेख करता है, जिन्हें वह 'समितिंजय' अर्थात् संग्राम में सदा विजयी रहने वाला महान वीर कहता है।
            इसके अतिरिक्त, वह द्रोणाचार्य के पराक्रमी पुत्र अश्वत्थामा और अपने सबसे धर्मात्मा भाई विकर्ण का भी उल्लेख करता है।
            ध्यान देने योग्य बात यह है कि दुर्योधन ने सेनापति भीष्म से भी पहले द्रोणाचार्य का नाम लिया, जो उसका कूटनीतिक स्वार्थ है।
            इन सभी अपराजेय और महान योद्धाओं का स्मरण करके दुर्योधन वास्तव में अपने डगमगाते आत्मविश्वास को वापस पाना चाहता है।
        """.trimIndent(),
        english = """
            First, there is yourself (Dronacharya), Grandsire Bhishma, the great archer Karna, and the ever-victorious Kripacharya.
            And besides them, the great warrior Ashvatthama, my brother Vikarna, and Somadatta's mighty son Bhurishrava are also present.
            To significantly boost the morale of his army, Duryodhana presents a detailed list of all the invincible Maharathas on his side.
            Using his sharp diplomacy, he first very respectfully takes the name of his teacher Dronacharya (Bhavan) before anyone else.
            Then he respectfully remembers Grandsire Bhishma, the absolute supreme commander and the greatest warrior of his entire army.
            After that, he very proudly takes the name of his best friend, biggest supporter, and Arjuna's powerful equal, the great archer Karna.
            Then he mentions Kripacharya, whom he refers to as 'Samitinjayah', meaning a great hero who is always victorious in battle.
            In addition, he mentions Dronacharya's mighty son Ashvatthama and his own most righteous and virtuous brother, Vikarna.
            It is very noteworthy that Duryodhana named Dronacharya even before commander Bhishma, fully showing his diplomatic selfishness.
            By continuously recalling all these invincible and legendary warriors, Duryodhana actually wants to regain his own faltering self-confidence.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            अन्ये च बहवः शूरा मदर्थे त्यक्तजीविताः |
            नानाशस्त्रप्रहरणाः सर्वे युद्धविशारदाः || ९ ||
        """.trimIndent(),
        hindi = """
            इन सब प्रमुख नायकों के अतिरिक्त और भी बहुत-से शूरवीर राजा यहाँ हैं, जो मेरे लिए अपने जीवन की आशा त्याग चुके हैं।
            वे सभी योद्धा अनेक प्रकार के भयंकर अस्त्र-शस्त्रों से पूरी तरह सुसज्जित हैं और युद्धकला में अत्यंत ही निपुण और अनुभवी हैं।
            अपने प्रमुख नायकों का नाम लेने के बाद, दुर्योधन अपनी सेना के अन्य सभी राजाओं और सैनिकों का वर्णन एक ही पंक्ति में कर देता है।
            वह बड़े गर्व से कहता है कि ये सभी शूरवीर केवल मेरे लिए अपने प्राणों की बाजी लगाने को पूरी तरह से तैयार होकर आए हैं।
            'मदर्थे त्यक्तजीविताः' (मेरे लिए जीवन त्यागने वाले) यह वाक्य दुर्योधन के असीमित अहंकार और उसके गहरे मानसिक भ्रम को दर्शाता है।
            वह यह मूर्खतापूर्ण मान बैठा है कि यह विशाल सेना केवल उसके प्रति व्यक्तिगत वफादारी के कारण ही मरने को तैयार खड़ी है।
            जबकि वास्तविकता यह थी कि कई लोग भीष्म और द्रोण जैसे बड़ों के सम्मान या अपनी राजनीतिक विवशताओं के कारण इस युद्ध में आए थे।
            यह श्लोक एक प्रकार से बहुत बड़ा अशुभ संकेत भी है, जो कौरव सेना के भयानक भविष्य को पहले ही बहुत स्पष्ट कर देता है।
            'त्यक्तजीविताः' का एक अर्थ यह भी निकाला जा सकता है कि वे सभी वास्तव में अपना जीवन त्याग ही चुके हैं।
            अर्थात् इस विनाशकारी युद्ध में उनका मरना पूरी तरह से निश्चित है, यह दुर्योधन के अचेतन मन से निकली एक कड़वी सच्चाई है।
        """.trimIndent(),
        english = """
            Apart from all these key commanders, there are many other heroic kings here who have given up hope for their lives for my sake.
            All those warriors are fully equipped with various kinds of terrifying weapons and are extremely skilled and experienced in warfare.
            After extensively naming his principal commanders, Duryodhana describes all the other kings and soldiers of his army in a single line.
            He proudly states that all these great heroes have come fully prepared to risk and sacrifice their very lives entirely for my sake.
            The phrase 'Madarthe tyakta-jivitah' (ready to give up lives for me) reflects Duryodhana's limitless ego and deep mental delusion.
            He foolishly assumes that this massive army is standing ready to die purely out of intense personal loyalty and devotion to him.
            Whereas the actual reality was that many joined the war due to respect for elders like Bhishma or due to political obligations.
            In a way, this verse is also a very massive and ominous sign that already clarifies the dark and deadly future of the Kaurava army.
            Another profound meaning of 'Tyakta-jivitah' can be interpreted as indicating that they have already practically given up their lives.
            Meaning, their death in this devastating war is absolutely certain; this is a bitter truth emerging from Duryodhana's subconscious mind.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            अपर्याप्तं तदस्माकं बलं भीष्माभिरक्षितम् |
            पर्याप्तं त्विदमेतेषां बलं भीमाभिरक्षितम् || १० ||
        """.trimIndent(),
        hindi = """
            भीष्म पितामह द्वारा पूरी तरह से रक्षित हमारी यह विशाल सेना सब प्रकार से अजेय (अपर्याप्त) और असीमित प्रतीत होती है।
            जबकि दूसरी ओर भीम द्वारा रक्षित इन लोगों (पाण्डवों) की वह सेना बहुत सीमित और आसानी से जीतने योग्य (पर्याप्त) है।
            इस अत्यंत महत्वपूर्ण श्लोक के सटीक अर्थ को लेकर विद्वानों और आचार्यों के बीच हमेशा से ही गहरे मतभेद रहे हैं।
            कुछ आचार्यों के अनुसार दुर्योधन घमंड में कहता है कि अजेय भीष्म द्वारा रक्षित हमारी ग्यारह अक्षौहिणी सेना वास्तव में असीमित (अपर्याप्त) है।
            और भीम द्वारा रक्षित पांडवों की वह सात अक्षौहिणी सेना हमारे सामने बहुत सीमित (पर्याप्त) और आसानी से हराए जाने योग्य है।
            परंतु दूसरे मनोवैज्ञानिक अर्थ के अनुसार, दुर्योधन आंतरिक घबराहट में कह रहा है कि हमारी इतनी बड़ी सेना भी मुझे 'अपर्याप्त' (नाकाफी) लग रही है।
            उसे लगता है कि भीष्म पितामह दोनों पक्षों (कौरवों और पांडवों) के प्रति अपने मन में गहरा स्नेह रखते हैं, इसलिए वे पूरी शक्ति से नहीं लड़ेंगे।
            जबकि भीम अपनी छोटी सेना की रक्षा भी पूरी क्रूरता, निष्ठा और भयंकर क्रोध के साथ कर रहा है, इसलिए उनकी सेना 'पर्याप्त' (मजबूत) है।
            दोनों ही अर्थों में, दुर्योधन की मानसिक अस्थिरता और उसके भीतर छिपा हुआ गहरा मनोवैज्ञानिक भय पूरी तरह से स्पष्ट हो जाता है।
            वह अपनी सेना की विशालता देखकर भी आश्वस्त नहीं है और उसे बचपन से ही भीम से एक बहुत गहरा और भयानक मानसिक डर रहा है।
        """.trimIndent(),
        english = """
            Our massive army, completely protected by Grandsire Bhishma, appears to be totally unconquerable (aparyaptam) and limitless in every way.
            Whereas on the other hand, the army of these Pandavas, carefully protected by Bhima, is very limited and easily conquerable (paryaptam).
            There have always been very deep differences of opinion among scholars and teachers regarding the exact meaning of this crucial verse.
            According to some teachers, Duryodhana arrogantly claims that his eleven-division army guarded by the invincible Bhishma is limitless (aparyaptam).
            And the Pandavas' seven-division army, guarded by Bhima, is very limited (paryaptam) and can be easily defeated before us.
            However, according to another psychological interpretation, Duryodhana is saying in internal panic that even his massive army feels 'insufficient' (aparyaptam).
            He feels that Grandsire Bhishma holds deep affection for both sides (Kauravas and Pandavas), so he might not fight with full strength.
            Whereas Bhima is protecting his smaller army with complete ruthlessness, dedication, and terrifying anger, making their army 'sufficient' (strong).
            In both interpretations, Duryodhana's mental instability and his deeply hidden psychological fear become completely and perfectly clear to the reader.
            He is not assured even after seeing the vastness of his army, and he has harbored a very deep and terrifying mental fear of Bhima since childhood.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            अयनेषु च सर्वेषु यथाभागमवस्थिताः |
            भीष्ममेवाभिरक्षन्तु भवन्तः सर्व एव हि || ११ ||
        """.trimIndent(),
        hindi = """
            इसलिए युद्ध के सब मोर्चों पर अपनी-अपनी रणनीतिक जगह पर मजबूती से स्थित रहते हुए आप लोग एक विशेष कार्य करें।
            आप सभी महारथी और सेनापति मिलकर निस्संदेह रूप से भीष्म पितामह की ही सब ओर से और हर स्थिति में रक्षा करें।
            दुर्योधन अपनी सेना के सभी मुख्य सेनापतियों और योद्धाओं को युद्ध शुरू होने से ठीक पहले एक अत्यंत महत्वपूर्ण आदेश देता है।
            वह चाहता है कि वे युद्ध के मैदान में अपने-अपने निर्धारित मोर्चों पर डटे रहें, लेकिन उनका मुख्य उद्देश्य कुछ और ही होना चाहिए।
            उसका यह स्पष्ट निर्देश है कि सेनापति भीष्म पितामह की रक्षा करना ही इस पूरी सेना का सबसे पहला और सर्वोच्च लक्ष्य होना चाहिए।
            दुर्योधन यह भली-भांति जानता था कि भीष्म अजेय हैं और जब तक वे युद्धभूमि में खड़े हैं, तब तक कौरवों की हार पूरी तरह से असंभव है।
            परंतु उसे भीष्म पितामह की एक बहुत बड़ी और घातक कमजोरी भी पता थी—वे किसी भी स्त्री पर कभी शस्त्र नहीं उठाएंगे।
            शिखंडी पूर्व जन्म में स्त्री था, इसलिए भीष्म उस पर बाण नहीं चलाएंगे, और दुर्योधन को डर था कि पांडव इसी बात का फायदा उठाएंगे।
            इसलिए वह चाहता है कि द्रोणाचार्य और अन्य सभी महारथी भीष्म के चारों ओर हर समय एक अभेद्य सुरक्षा घेरा बनाकर रखें।
            यह श्लोक दुर्योधन की रणनीतिक सोच के साथ-साथ भीष्म पितामह के ऊपर उसकी अत्यधिक और हताश निर्भरता को भी स्पष्ट रूप से प्रदर्शित करता है।
        """.trimIndent(),
        english = """
            Therefore, while remaining firmly stationed at your respective strategic positions on all fronts of the war, you must all perform a special task.
            All of you great warriors and commanders must undoubtedly protect Grandsire Bhishma from all sides and in every possible situation.
            Duryodhana gives a highly crucial command to all the main commanders and warriors of his army just before the war begins.
            He wants them to firmly hold their assigned fronts on the battlefield, but their primary objective should be something else entirely.
            His clear instruction is that protecting Commander Grandsire Bhishma must be the very first and supreme goal of this entire army.
            Duryodhana knew very well that Bhishma was invincible, and as long as he stood on the battlefield, the Kauravas' defeat was completely impossible.
            However, he also knew of a very massive and fatal weakness of Grandsire Bhishma—he would never raise a weapon against any woman.
            Shikhandi was a woman in his previous birth, so Bhishma would not shoot at him, and Duryodhana feared the Pandavas would exploit this exact point.
            Therefore, he wants Dronacharya and all other great warriors to maintain an impenetrable protective ring around Bhishma at all times.
            This verse clearly displays Duryodhana's strategic thinking as well as his extreme and desperate dependence on Grandsire Bhishma for victory.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            तस्य सञ्जनयन्हर्षं कुरुवृद्धः पितामहः |
            सिंहनादं विनद्योच्चैः शङ्खं दध्मौ प्रतापवान् || १२ ||
        """.trimIndent(),
        hindi = """
            कौरवों के वंश में सबसे वृद्ध और सबसे बड़े प्रतापी पितामह भीष्म ने उस दुर्योधन के डरे हुए हृदय में गहरा हर्ष उत्पन्न किया।
            उन्होंने अपने गले से उच्च स्वर में एक गरजते हुए सिंह के समान भयंकर नाद किया और अत्यंत प्रताप के साथ अपना शंख बजाया।
            भीष्म पितामह युद्ध कला के साथ-साथ मानवीय मनोविज्ञान में भी अत्यंत अनुभवी और पूरी तरह से कुशल थे।
            जब उन्होंने दूर से देखा कि राजा दुर्योधन द्रोणाचार्य के पास जाकर बहुत घबराहट और असुरक्षा से भरी बातें कर रहा है।
            तो वे तुरंत ही समझ गए कि राजा का मनोबल युद्ध शुरू होने से पहले ही बहुत तेजी से नीचे गिर रहा है।
            दुर्योधन का उत्साह फिर से बढ़ाने और अपनी पूरी सेना में युद्ध का नया जोश भरने के लिए, भीष्म ने एक भयानक सिंहनाद किया।
            और इसके तुरंत बाद उन्होंने अपने भीतर की पूरी शक्ति को एकत्रित करके अपना विशाल शंख बहुत जोर से बजाया।
            प्राचीन काल के युद्धों में किसी भी मुख्य सेनापति द्वारा किया गया शंखनाद ही युद्ध की आधिकारिक शुरुआत और घोषणा माना जाता था।
            भीष्म का यह भयंकर शंखनाद उनकी अपनी निर्भयता, असीमित पराक्रम और अपने क्षत्रिय कर्तव्य के प्रति उनकी अटूट निष्ठा का प्रतीक था।
            यद्यपि वे जानते थे कि अंततः धर्म (पांडवों) की ही जीत होगी, फिर भी एक सच्चे सेनापति के रूप में उन्होंने कौरव सेना में नई ऊर्जा का संचार किया।
        """.trimIndent(),
        english = """
            The oldest and most immensely glorious Grandsire of the Kaurava dynasty, Bhishma, generated deep joy in that fearful heart of Duryodhana.
            He made a terrifying sound loudly from his throat like a roaring lion and blew his conch shell with extreme and majestic power.
            Grandsire Bhishma was deeply experienced and completely skilled not only in the art of war but also in human psychology.
            When he observed from afar that King Duryodhana was speaking to Dronacharya with words full of great panic and insecurity.
            He immediately understood that the king's morale was falling very rapidly even before the actual battle had properly begun.
            To raise Duryodhana's enthusiasm again and to fill his entire army with the fresh passion for war, Bhishma let out a terrifying lion's roar.
            And immediately following that, gathering all his inner strength, he blew his massive conch shell with tremendous and deafening force.
            In the wars of ancient times, the blowing of the conch by any supreme commander was considered the official start and declaration of the war.
            This terrifying conch blast by Bhishma was the ultimate symbol of his own fearlessness, limitless valor, and unbreakable dedication to his Kshatriya duty.
            Even though he knew that ultimately dharma (the Pandavas) would win, still, as a true commander, he infused fresh energy into the Kaurava army.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            ततः शङ्खाश्च भेर्यश्च पणवानकगोमुखाः |
            सहसैवाभ्यहन्यन्त स शब्दस्तुमुलोऽभवत् || १३ ||
        """.trimIndent(),
        hindi = """
            पितामह के शंखनाद के तुरंत पश्चात् कौरव सेना के शंख, नगाड़े, ढोल, मृदंग और नरसिंघे आदि सभी बाजे एक साथ ही बज उठे।
            उन सभी वाद्य यंत्रों के एक साथ बजने से उत्पन्न होने वाला वह सम्मिलित शब्द अत्यंत ही भयंकर और कोलाहलपूर्ण (तुमुल) हुआ।
            भीष्म पितामह के शंख बजाते ही पूरी की पूरी कौरव सेना के भीतर युद्ध का एक भयंकर और पागलपन भरा उन्माद छा गया।
            सेनापति पितामह के उस शंख की गूंजती हुई ध्वनि को युद्ध का अंतिम और अचूक संकेत मानकर, कौरव सेना सक्रिय हो गई।
            उस विशाल सेना के पास मौजूद सभी प्रकार के युद्ध-वाद्य यंत्र बिना किसी देरी के अचानक और एक साथ पूरी शक्ति से बज उठे।
            इन वाद्य यंत्रों में अनेक प्रकार के भयानक बाजे शामिल थे जैसे शंख, भेरी (नगाड़े), पणव (ढोल), आनक (मृदंग) और गोमुख (नरसिंघे)।
            ग्यारह अक्षौहिणी सैनिकों की उस महाविशाल सेना में जब ये लाखों वाद्य यंत्र अचानक और एक साथ पूरे जोर से बजे।
            तो उस क्षण उत्पन्न होने वाली वह भयानक ध्वनि अत्यंत ही कोलाहलपूर्ण, डरावनी और साधारण हृदय को पूरी तरह से कंपा देने वाली थी।
            यह तुमुल (कोलाहलपूर्ण) ध्वनि युद्ध की भयानकता, मार-काट और एक महा-विनाश के निश्चित आगमन की बिल्कुल स्पष्ट उद्घोषणा थी।
            संजय यह भयंकर दृश्य और ध्वनि का वर्णन करके धृतराष्ट्र को बताना चाहते हैं कि उनके पुत्रों की ओर से युद्ध की पूरी शुरुआत हो चुकी है।
        """.trimIndent(),
        english = """
            Immediately after the Grandsire's conch blast, the conch shells, kettledrums, tabors, snare drums, and cow-horns of the Kaurava army all sounded together.
            The combined sound produced by the simultaneous blowing and beating of all those musical instruments became extremely terrifying and tumultuous (Tumula).
            As soon as Grandsire Bhishma blew his conch, a terrifying and maddening frenzy of war completely overtook the entire Kaurava army.
            Taking the echoing sound of the commander's conch as the ultimate and unmistakable signal for war, the Kaurava army became fully active.
            All types of martial musical instruments present within that massive army suddenly and simultaneously sounded with full force without any delay.
            These instruments included various terrifying types like conches, Bheris (kettledrums), Panavas (tabors), Anakas (snare drums), and Gomukhas (cow-horns).
            When these millions of instruments were suddenly and simultaneously played at full volume within that colossal army of eleven divisions.
            Then the terrifying sound generated at that exact moment was extremely tumultuous, dreadful, and capable of completely shaking any ordinary heart.
            This tumultuous (chaotic) sound was the absolute clear declaration of the war's terror, the impending slaughter, and the definite arrival of mass destruction.
            By describing this terrifying scene and sound, Sanjaya wants to inform Dhritarashtra that the war has fully commenced from his sons' side.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            ततः श्वेतैर्हयैर्युक्ते महति स्यन्दने स्थितौ |
            माधवः पाण्डवश्चैव दिव्यौ शङ्खौ प्रदध्मतुः || १४ ||
        """.trimIndent(),
        hindi = """
            कौरवों के उस भयंकर और कोलाहलपूर्ण शब्द का उत्तर देने के लिए, अब पांडवों के खेमे में हलचल शुरू होती है।
            इसके अनन्तर चार दिव्य सफेद घोड़ों से जुते हुए एक अत्यंत महान और उत्तम रथ पर बैठे हुए दो दिव्य पुरुष दिखाई देते हैं।
            वे दोनों साक्षात् भगवान श्रीकृष्ण (माधव) और सर्वश्रेष्ठ धनुर्धर अर्जुन (पांडव) हैं, जिन्होंने अपने-अपने दिव्य शंख बजाए।
            संजय का यह वर्णन अत्यंत ही सुंदर, गहरा और भविष्य की विजय का बिल्कुल स्पष्ट संकेत देने वाला है।
            वे धृतराष्ट्र को बताते हैं कि अर्जुन का रथ कोई साधारण रथ नहीं है; यह एक 'महान स्यंदन' (विशाल रथ) है।
            इस रथ में जुते हुए चार सफेद घोड़े अत्यंत दिव्य हैं, और यह रथ स्वयं अग्निदेव ने अर्जुन को भेंट स्वरूप दिया था।
            सबसे महत्वपूर्ण बात यह है कि इस अजेय रथ के सारथी स्वयं लक्ष्मीपति भगवान श्रीकृष्ण (माधव) हैं।
            'माधव' शब्द का अर्थ है माया के स्वामी; और जिस रथ का संचालन स्वयं परमेश्वर कर रहे हों, उसकी विजय तो निश्चित ही है।
            श्रीकृष्ण और अर्जुन ने कौरवों के उस सांसारिक शोर के जवाब में अपने पारलौकिक और दिव्य शंख बजाए।
            इनके शंखों की ध्वनि कौरवों की तरह शोरगुल वाली नहीं थी, बल्कि यह स्पष्ट और धर्म की विजय की उद्घोषणा करने वाली थी।
        """.trimIndent(),
        english = """
            To answer that terrifying and tumultuous uproar of the Kauravas, movement now begins in the Pandava camp.
            Thereafter, seated on an extremely great and excellent chariot yoked with four divine white horses, two divine beings appear.
            Those two are none other than Lord Krishna (Madhava) and the greatest archer Arjuna (Pandava), who blew their respective divine conches.
            This description by Sanjaya is extremely beautiful, profound, and gives an absolutely clear indication of future victory.
            He informs Dhritarashtra that Arjuna's chariot is no ordinary vehicle; it is a 'Mahan Syandana' (a massive chariot).
            The four white horses yoked to this chariot are highly divine, and this chariot was gifted to Arjuna by the Fire God himself.
            The most important fact is that the charioteer of this invincible chariot is the Lord of Fortune, Sri Krishna (Madhava) himself.
            The word 'Madhava' means the master of illusion; and a chariot driven by the Supreme Lord Himself is absolutely certain to win.
            Sri Krishna and Arjuna blew their transcendental and divine conch shells in response to the worldly noise of the Kauravas.
            The sound of their conches was not chaotic like the Kauravas, but it was clear and a pure declaration of the victory of dharma.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            पाञ्चजन्यं हृषीकेशो देवदत्तं धनञ्जयः |
            पौण्ड्रं दध्मौ महाशङ्खं भीमकर्मा वृकोदरः || १५ ||
        """.trimIndent(),
        hindi = """
            श्रीकृष्ण (हृषीकेश) ने 'पाञ्चजन्य' नामक अपना दिव्य शंख बजाया, और अर्जुन (धनंजय) ने 'देवदत्त' नामक शंख बजाया।
            और भयानक कर्म करने वाले तथा भेड़िये के समान पाचन शक्ति वाले भीमसेन (वृकोदर) ने 'पौण्ड्र' नामक महाशंख बजाया।
            इस श्लोक में पांडव पक्ष के तीन सबसे प्रमुख व्यक्तियों और उनके विशिष्ट तथा शक्तिशाली शंखों के नाम बताए गए हैं।
            श्रीकृष्ण को यहाँ 'हृषीकेश' कहा गया है, जिसका अर्थ है सभी इंद्रियों के परम स्वामी; उन्होंने अपना प्रसिद्ध पाञ्चजन्य शंख बजाया।
            अर्जुन को 'धनंजय' कहा गया है क्योंकि उन्होंने राजसूय यज्ञ के लिए अपार धन जीता था; उन्होंने अपना देवदत्त शंख बजाया।
            भीमसेन को 'वृकोदर' (अत्यधिक भूख और पाचन शक्ति वाला) और 'भीमकर्मा' (अत्यंत भयानक कर्म करने वाला) कहा गया है।
            भीम ने अपने विशाल शरीर और अपनी अपार शारीरिक शक्ति के अनुरूप 'पौण्ड्र' नामक एक अत्यंत बड़ा महाशंख पूरी शक्ति से बजाया।
            इन विशिष्ट नामों और उनके दिव्य शंखों का यह स्पष्ट उल्लेख पांडव पक्ष की दिव्यता, असीम शक्ति और उनके संकल्प की दृढ़ता को दर्शाता है।
            पांडवों के शंखों की यह स्पष्ट और गगनभेदी ध्वनि कौरव सेना के झूठे मनोबल को तोड़ने के लिए पूरी तरह से पर्याप्त थी।
            यह दृश्य सिद्ध करता है कि पांडव न केवल शारीरिक रूप से मजबूत थे, बल्कि वे आध्यात्मिक रूप से भी परम शक्तिशाली थे।
        """.trimIndent(),
        english = """
            Lord Krishna (Hrishikesha) blew His divine conch shell called Panchajanya, and Arjuna (Dhananjaya) blew his conch named Devadatta.
            And Bhima (Vrikodara), the voracious eater and the performer of terrifyingly herculean tasks, blew his terrific and massive conch called Paundra.
            This verse individualizes the majestic response of the Pandava leaders by specifically naming their legendary and powerful conch shells.
            Lord Krishna is addressed here as 'Hrishikesha' (the supreme master of all senses); He blows the famous Panchajanya conch.
            Arjuna is called 'Dhananjaya' (the winner of wealth, reflecting his vast conquests); he blows the divine Devadatta conch gifted by gods.
            Bhima is described with two highly potent adjectives: 'Vrikodara' (having a wolf-like appetite) and 'Bhimakarma' (performer of terrifying deeds).
            Fittingly, Bhima blew a massive and terrifying conch named Paundra with all his might, matching his colossal body and immense strength.
            Identifying these formidable warriors and their divine instruments serves to deeply establish the overwhelming spiritual and physical prowess of the Pandavas.
            This clear and sky-piercing sound of the Pandavas' conches was entirely sufficient to shatter the false morale of the Kaurava army.
            This scene proves that the Pandavas were not only physically strong, but they were also supremely powerful on a spiritual level.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            अनन्तविजयं राजा कुन्तीपुत्रो युधिष्ठिरः |
            नकुलः सहदेवश्च सुघोषमणिपुष्पकौ || १६ ||
        """.trimIndent(),
        hindi = """
            कुन्ती-पुत्र राजा युधिष्ठिर ने 'अनन्तविजय' नामक अपना विशाल शंख बजाया, जो सत्य और धर्म की कभी न समाप्त होने वाली विजय का प्रतीक है।
            तथा छोटे भाइयों नकुल और सहदेव ने भी क्रमशः 'सुघोष' (सुंदर ध्वनि वाला) और 'मणिपुष्पक' (रत्नों से जड़ा हुआ) नामक शंख बजाए।
            श्रीकृष्ण, अर्जुन और भीम के प्रचंड शंखनाद के बाद अब धर्मराज युधिष्ठिर और उनके दोनों छोटे भाइयों का क्रमवार वर्णन यहाँ किया गया है।
            इस श्लोक में युधिष्ठिर को स्पष्ट रूप से 'राजा' कहकर संबोधित किया गया है, जो संजय के मन की एक बहुत बड़ी सच्चाई को उजागर करता है।
            यह शब्द यह सिद्ध करता है कि संजय और वस्तुतः पूरी दुनिया युधिष्ठिर को ही हस्तिनापुर का वास्तविक और वैध सम्राट मानते हैं, दुर्योधन को नहीं।
            युधिष्ठिर के शंख का नाम 'अनन्तविजय' है, जो यह घोषणा करता है कि अंततः विजय उसी की होगी जो धर्म के सत्य मार्ग पर चलता है।
            उनके पीछे-पीछे नकुल ने 'सुघोष' और सहदेव ने 'मणिपुष्पक' शंख बजाकर अपने बड़े भाई और धर्म के प्रति अपना पूर्ण समर्थन व्यक्त किया।
            ये सभी शंखनाद एक साथ मिलकर यह स्पष्ट संदेश देते हैं कि पांचों पांडव पूरी तरह से एकजुट हैं और उनके बीच कोई मतभेद नहीं है।
            वे सभी अपने अधिकारों और न्याय तथा धर्म की स्थापना के लिए यह अंतिम और भयानक युद्ध लड़ने के लिए पूरी तरह से मानसिक रूप से तैयार हैं।
            कौरवों की भीड़ के विपरीत, पांडवों का यह शंखनाद एक सुव्यवस्थित, अनुशासित और धर्म के प्रति उनकी गहरी प्रतिबद्धता का स्पष्ट प्रतीक है।
        """.trimIndent(),
        english = """
            King Yudhishthira, the righteous son of Kunti, blew his massive conch named Anantavijaya, which symbolizes unending victory of truth and dharma.
            And the younger brothers Nakula and Sahadeva also blew their respective conches named Sughosha (pleasant sounding) and Manipushpaka (jewel-decorated).
            After the fierce conch blasts of Krishna, Arjuna, and Bhima, the sequential description of Dharmaraja Yudhishthira and his younger brothers is given here.
            In this verse, Yudhishthira is very explicitly addressed as 'Raja' (King), which reveals a very great truth hidden in Sanjaya's mind.
            This word proves that Sanjaya, and essentially the whole world, mentally considers Yudhishthira as the real and rightful emperor, not Duryodhana.
            The name of Yudhishthira's conch is 'Anantavijaya', which clearly declares that ultimate victory belongs only to the one walking the true path of dharma.
            Following him, Nakula blew 'Sughosha' and Sahadeva blew 'Manipushpaka', expressing their complete support for their eldest brother and for righteousness.
            All these coordinated conch blasts together send a very clear message that the five Pandavas are completely united without any differences.
            They are all fully prepared mentally to fight this final and terrifying war for their absolute rights and for the establishment of justice.
            Unlike the chaotic crowd of the Kauravas, this conch blowing of the Pandavas is a clear symbol of their organized, disciplined, and deep commitment to dharma.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            काश्यश्च परमेष्वासः शिखण्डी च महारथः |
            धृष्टद्युम्नो विराटश्च सात्यकिश्चापराजितः || १७ ||
        """.trimIndent(),
        hindi = """
            महान और सर्वश्रेष्ठ धनुर्धर काशिराज, महारथी शिखण्डी, सेनापति धृष्टद्युम्न, राजा विराट और युद्ध में कभी न हारने वाले (अपराजित) यादव वीर सात्यकि...
            यहाँ संजय पांडव सेना के उन अन्य प्रमुख महारथियों और राजाओं का लगातार वर्णन कर रहे हैं जिन्होंने अपने-अपने शंख एक साथ बजाए।
            सबसे पहले काशिराज का नाम लिया गया है, जिन्हें 'परमेष्वासः' अर्थात् परम श्रेष्ठ और महान धनुर्धर कहकर अत्यंत सम्मानित किया गया है।
            इसके बाद शिखण्डी का नाम आता है, जिसका जन्म ही विशेष रूप से भीष्म पितामह का वध करने के लिए हुआ था, और उसे 'महारथी' कहा गया है।
            इसके अलावा संपूर्ण पांडव सेना के मुख्य सेनापति धृष्टद्युम्न का नाम है, जिन्होंने इस विशाल सेना की अचूक व्यूहरचना का निर्माण किया है।
            साथ ही मत्स्य देश के राजा विराट का भी उल्लेख है, जिनके राज्य में सभी पांडवों ने अपना एक वर्ष का कठिन अज्ञातवास सफलतापूर्वक बिताया था।
            और अंत में कभी परास्त न होने वाले (अपराजित) यादव शूरवीर सात्यकि का नाम बड़े गर्व से लिया गया है, जो अर्जुन के प्रिय शिष्य भी हैं।
            संजय एक-एक करके इन सभी नामों को गिनाकर धृतराष्ट्र को यह कड़वा अहसास करा रहे हैं कि पांडवों का पलड़ा बहुत भारी है।
            वे बताना चाहते हैं कि पांडवों के पक्ष में जो योद्धा खड़े हैं, वे केवल साधारण वीर ही नहीं हैं, बल्कि वे पूरी तरह से अपराजेय हैं।
            ये सभी महारथी अपने-अपने क्षेत्रों और युद्ध-कौशल के सर्वश्रेष्ठ शूरवीर हैं, जो कौरवों की सेना को बहुत आसानी से मिट्टी में मिला सकते हैं।
        """.trimIndent(),
        english = """
            That absolutely great and supreme archer the King of Kashi, the great fighter Shikhandi, Dhrishtadyumna, Virata, and the unconquerable Yadava hero Satyaki...
            Here Sanjaya is continuously detailing the other key Maharathas and kings of the Pandava alliance who blew their respective conches together.
            First, the King of Kashi is named, who is highly honored by being called 'Parameshvasah', meaning an absolutely supreme and great archer.
            Then comes the name of Shikhandi, whose very birth was specifically destined for the killing of Grandsire Bhishma, and he is called a 'Maharatha'.
            Besides them is the name of Dhrishtadyumna, the supreme commander of the entire Pandava army, who constructed their flawless military formation.
            Also mentioned is King Virata of the Matsya kingdom, in whose territory all the Pandavas had successfully spent their difficult year of incognito exile.
            And finally, the proudly unconquered (Aparajitah) Yadava hero Satyaki is named, who is also a very dear and highly skilled student of Arjuna.
            By enumerating all these names one by one, Sanjaya is making Dhritarashtra realize the bitter truth that the Pandavas have a very heavy advantage.
            He wants to convey that the warriors standing on the side of the Pandavas are not just ordinary heroes, but they are completely invincible.
            All these Maharathas are the absolute best warriors in their respective fields and combat skills, fully capable of turning the Kaurava army to dust.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            द्रुपदो द्रौपदेयाश्च सर्वशः पृथिवीपते |
            सौभद्रश्च महाबाहुः शङ्खान्दध्मुः पृथक्पृथक् || १८ ||
        """.trimIndent(),
        hindi = """
            हे पृथ्वी के स्वामी (पृथिवीपते) राजन्! पांचाल नरेश राजा द्रुपद, द्रौपदी के पाँचों पुत्र और बड़ी-बड़ी मजबूत भुजाओं वाले सुभद्रा-पुत्र अभिमन्यु...
            इन सभी शूरवीरों ने भी एक साथ, सब ओर से और चारों दिशाओं से अपने-अपने भयंकर शंखों को पूरी ताकत के साथ अलग-अलग बजाया।
            संजय यहाँ अत्यंत कूटनीति और व्यंग्य के साथ धृतराष्ट्र को 'पृथिवीपते' (पूरी पृथ्वी के स्वामी या हे राजन) कहकर सीधे संबोधित करते हैं।
            वे इस दृश्य को पूरा करते हुए बताते हैं कि राजा द्रुपद, द्रौपदी के पांचों पुत्र और अत्यंत बलशाली ('महाबाहु') वीर अभिमन्यु ने भी शंखनाद किया।
            पांडव पक्ष से इतने सारे शक्तिशाली और दिव्य शंखों का एक साथ और इतनी सुव्यवस्थित तरीके से बजना एक बहुत बड़ा और महत्वपूर्ण सूचक था।
            यह साबित करता था कि पांडवों की सेना कौरवों की तुलना में अत्यंत सुसंगठित, अनुशासित और बहुत ही उच्च मनोबल वाली सेना है।
            धृतराष्ट्र को ठीक इसी क्षण 'पृथ्वीपति' कहकर संबोधित करने में संजय का एक बहुत गहरा और मनोवैज्ञानिक मंतव्य भी छिपा हो सकता है।
            वे शायद धृतराष्ट्र को याद दिला रहे हैं कि आप इस पूरी पृथ्वी के अकेले राजा हैं, और इस महा-विनाश की पूरी जिम्मेदारी केवल आपकी है।
            यदि आप चाहें तो अपने अधिकार का प्रयोग करके अब भी इस विनाशकारी युद्ध को रोक सकते हैं, क्योंकि सामने खड़ी पांडवों की शक्ति अपार है।
            यह शंखनाद धृतराष्ट्र के लिए एक अंतिम चेतावनी थी कि उनके पुत्र जिस आग से खेलने जा रहे हैं, वह आग अंततः उनके पूरे वंश को जला देगी।
        """.trimIndent(),
        english = """
            O Lord of the Earth (Prithivipate) King! The King of Panchala Drupada, the five sons of Draupadi, and the mighty-armed son of Subhadra, Abhimanyu...
            All these great heroes also simultaneously blew their respective terrifying conches separately with full force from all sides and all directions.
            Here Sanjaya directly addresses Dhritarashtra as 'Prithivipate' (Lord of the entire earth or O King) with extreme diplomacy and subtle irony.
            Completing this scene, he describes that King Drupada, the five sons of Draupadi, and the immensely strong ('Maha-bahu') hero Abhimanyu also sounded their conches.
            The simultaneous and highly organized blasting of so many powerful and divine conchs from the Pandava side was a very massive and important indicator.
            It completely proved that the Pandava army, compared to the Kauravas, was an extremely well-organized, disciplined, and high-morale military force.
            There might also be a very deep and psychological intention hidden in Sanjaya addressing Dhritarashtra as 'Lord of the Earth' at this exact moment.
            He is perhaps reminding Dhritarashtra that you are the sole king of this entire earth, and the absolute responsibility for this mass destruction is yours alone.
            If you wish, you can use your supreme authority to stop this devastating war even now, because the power of the Pandavas standing opposite is immense.
            This conch blowing was a final, deafening warning to Dhritarashtra that the fire his sons are about to play with will ultimately burn down his entire dynasty.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            स घोषो धार्तराष्ट्राणां हृदयानि व्यदारयत् |
            नभश्च पृथिवीं चैव तुमुलो व्यनुनादयन् || १९ ||
        """.trimIndent(),
        hindi = """
            पांडवों के उन सभी दिव्य शंखों की उस अत्यंत भयानक और गगनभेदी ध्वनि ने आकाश और पृथ्वी दोनों को पूरी तरह से गुंजा दिया।
            और उस भयंकर तुमुल शब्द ने धृतराष्ट्र के पुत्रों (कौरवों) के हृदयों को अंदर तक पूरी तरह से विदीर्ण कर दिया (अर्थात् चीर कर रख दिया)।
            यह श्लोक युद्ध से ठीक पहले दोनों सेनाओं के बीच के गहरे मनोवैज्ञानिक और आध्यात्मिक अंतर को बहुत ही स्पष्ट रूप से हमारे सामने रखता है।
            कुछ समय पहले जब कौरवों ने अपने शंख और नगाड़े बजाए थे, तो वे चाहे कितने भी शोरगुल वाले हों, पांडवों के मन में कोई भय उत्पन्न नहीं हुआ था।
            परंतु जब पांडवों की ओर से भगवान श्रीकृष्ण, अर्जुन, भीम और अन्य महारथियों ने धर्म की स्थापना के लिए अपने दिव्य शंख बजाए।
            तो उस पारलौकिक, भयंकर और गगनभेदी ध्वनि ने केवल धरती को ही नहीं कंपाया, बल्कि संपूर्ण आकाशमंडल को भी बुरी तरह से हिला दिया।
            उस दिव्य ध्वनि का आध्यात्मिक प्रभाव इतना गहरा और मारक था कि उसने कौरवों ('धार्तराष्ट्राणां') के हृदयों को भयानक डर से चीर कर रख दिया।
            यह घटना इस शाश्वत सत्य का प्रतीक है कि जो लोग अधर्म और अन्याय के मार्ग पर होते हैं, वे बाहर से कितने भी शक्तिशाली या क्रूर क्यों न दिखें।
            वे लोग भीतर से हमेशा ही अत्यंत खोखले, डरे हुए और अपनी ही ग्लानि से कमजोर होते हैं, जिनका कोई आध्यात्मिक आधार नहीं होता।
            सत्य और धर्म के पक्ष से निकली हुई एक शुद्ध हुंकार ही अधर्मियों के झूठे आत्मविश्वास को पल भर में हमेशा के लिए तोड़ने के लिए पर्याप्त होती है।
        """.trimIndent(),
        english = """
            That extremely terrifying and sky-piercing sound of all those divine conches of the Pandavas made both the sky and the earth completely reverberate.
            And that terrifying tumultuous uproar completely shattered (literally tore apart) the hearts of the sons of Dhritarashtra (the Kauravas) from deep within.
            This verse very clearly places before us the deep psychological and spiritual contrast between the two armies just before the war begins.
            Sometime earlier, when the Kauravas blew their conches and drums, no matter how noisy they were, it caused absolutely no fear in the minds of the Pandavas.
            However, when Lord Krishna, Arjuna, Bhima, and other Maharathas from the Pandava side blew their divine conches for the establishment of dharma.
            Then that transcendental, terrifying, and sky-piercing sound not only shook the earth but also badly trembled the entire celestial sky.
            The spiritual impact of that divine sound was so profound and lethal that it literally tore apart the hearts of the Kauravas ('Dhartarashtranam') with terrifying fear.
            This event perfectly symbolizes the eternal truth that those who stand on the path of adharma and injustice, no matter how powerful or cruel they look outside.
            They are always extremely hollow, frightened, and weakened by their own guilt from within, possessing absolutely no spiritual foundation to stand upon.
            A single, pure roar emerging from the side of truth and righteousness is completely sufficient to permanently shatter the false self-confidence of the unrighteous in a moment.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            अथ व्यवस्थितान्दृष्ट्वा धार्तराष्ट्रान् कपिध्वजः |
            प्रवृत्ते शस्त्रसम्पाते धनुरुद्यम्य पाण्डवः |
            हृषीकेशं तदा वाक्यमिदमाह महीपते || २० ||
        """.trimIndent(),
        hindi = """
            हे पृथ्वी के स्वामी राजन्! इसके बाद कपिध्वज अर्जुन ने कौरवों को युद्ध के लिए मोर्चों पर पूरी तरह से व्यवस्थित और तैयार खड़ा देखकर अपना धनुष उठा लिया।
            और जब दोनों ओर से शस्त्र चलने की बिल्कुल तैयारी हो ही चुकी थी, ठीक उसी समय अर्जुन ने अपने सारथी भगवान श्रीकृष्ण (हृषीकेश) से यह महत्वपूर्ण वचन कहा।
            यह श्लोक वास्तव में संपूर्ण भगवद्गीता के मुख्य और दिव्य संवाद की अत्यंत महत्वपूर्ण पृष्ठभूमि और भूमिका का निर्माण करता है।
            अर्जुन को यहाँ 'कपिध्वज' कहकर पुकारा गया है, जिसका अर्थ है वह वीर जिसके रथ की विशाल ध्वजा पर स्वयं भगवान हनुमान जी साक्षात विराजमान हैं।
            हनुमान जी त्रेता युग में भगवान राम (सत्य) के परम सेवक थे, और उनका अर्जुन के रथ पर होना इस बात का अकाट्य संकेत है कि यहाँ धर्म की विजय निश्चित है।
            कुरुक्षेत्र के मैदान में युद्ध बिलकुल शुरू होने ही वाला है ('प्रवृत्ते शस्त्रसम्पाते' अर्थात् अब बाण और शस्त्र बस चलने ही वाले हैं)।
            और अर्जुन ने युद्ध लड़ने के पूरे दृढ़ संकल्प के साथ अपना विश्व-प्रसिद्ध गांडीव धनुष अपने हाथों में मजबूती से उठा लिया है।
            अर्जुन का यह निडर कृत्य स्पष्ट दिखाता है कि वे युद्ध के लिए पूरी तरह से तैयार हैं और इस क्षण तक उनके मन में कोई भी संकोच या कायरता नहीं है।
            लेकिन युद्ध का पहला बाण छोड़ने से ठीक पहले, वे स्थिति का जायजा लेने के लिए श्रीकृष्ण से अपने रथ को दोनों सेनाओं के बीच ले जाने का अनुरोध करते हैं।
            ठीक इसी क्षण से अर्जुन के मन में पारिवारिक मोह की उत्पत्ति होती है, और यहीं से भगवान श्रीकृष्ण के महान गीता उपदेश का वास्तविक आरंभ होता है।
        """.trimIndent(),
        english = """
            O Lord of the Earth King! Thereafter, Arjuna, whose chariot flag bears Hanuman (Kapidhvaja), seeing the Kauravas standing completely organized for battle, took up his bow.
            And when the discharging of weapons was absolutely just about to begin from both sides, at that exact moment Arjuna spoke these important words to Lord Krishna (Hrishikesha).
            This verse actually creates the extremely important background and foundation for the main, divine dialogue of the entire Bhagavad Gita.
            Arjuna is addressed here as 'Kapidhvaja', which means the great hero on whose massive chariot flag Lord Hanuman himself is physically seated.
            Lord Hanuman was the supreme servant of Lord Rama (Truth) in the Treta Yuga, and his presence on Arjuna's chariot is an undeniable sign that victory for dharma is absolutely certain here.
            The war on the battlefield of Kurukshetra is just about to commence ('Pravritte shastrasampate' meaning arrows and weapons are just about to be released).
            And Arjuna has firmly raised his world-famous Gandiva bow in his hands with a complete and absolute determination to fight the battle.
            This fearless act of Arjuna clearly shows that he is fully prepared for war and until this very moment, there is absolutely no hesitation or cowardice in his mind.
            But just before shooting the first arrow, he requests Sri Krishna to take his chariot between the two armies to properly survey the situation.
            It is exactly from this moment that familial attachment arises in Arjuna's mind, and from here the actual beginning of Lord Krishna's great Gita discourse takes place.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            अर्जुन उवाच |
            सेनयोरुभयोर्मध्ये रथं स्थापय मेऽच्युत || २१ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने कहा: हे अच्युत (श्रीकृष्ण)! कृपा करके मेरे इस रथ को दोनों सेनाओं के बिल्कुल बीच में ले जाकर खड़ा कर दीजिए।
            इस श्लोक में अर्जुन भगवान श्रीकृष्ण को 'अच्युत' कहकर संबोधित कर रहे हैं, जिसका अर्थ है वह जो कभी अपने स्वरूप, शक्ति या धर्म से नहीं गिरता।
            यद्यपि श्रीकृष्ण साक्षात् परमेश्वर हैं, फिर भी उन्होंने अपने प्रिय भक्त अर्जुन के सारथी (सेवक) का पद बहुत ही स्वेच्छा और प्रेम से स्वीकार किया है।
            अर्जुन यहाँ एक योद्धा और सेनापति के रूप में भगवान को आज्ञा दे रहे हैं, और भगवान उस आज्ञा का बिना किसी संकोच के पालन कर रहे हैं।
            यह दृश्य भगवान और उनके शुद्ध भक्त के बीच के उस अत्यंत मधुर और अकल्पनीय प्रेम संबंध को दर्शाता है जहाँ ईश्वर भक्त के अधीन हो जाते हैं।
            युद्ध के पहले बाण के छूटने से ठीक पहले रथ को दोनों सेनाओं के बीच में ले जाने का अर्जुन का यह निर्णय बहुत ऐतिहासिक साबित होता है।
            यहीं से उस महान भ्रम और मोह की शुरुआत होती है जो आगे चलकर भगवद्गीता के दिव्य ज्ञान के प्रकट होने का एकमात्र कारण बनता है।
            अर्जुन शत्रु सेना को करीब से देखना चाहते थे, यह उनका क्षत्रिय आत्मविश्वास था, लेकिन नियति ने उनके लिए कुछ और ही तय कर रखा था।
        """.trimIndent(),
        english = """
            Arjuna said: O Achyuta (Infallible One)! Please draw my chariot and place it exactly in the middle of both the armies.
            In this verse, Arjuna addresses Lord Krishna as 'Achyuta', meaning the one who never falls from His eternal nature, power, or supreme position.
            Even though Sri Krishna is the Supreme Personality of Godhead, out of pure love, He has willingly accepted the menial role of a charioteer for His dear devotee.
            Arjuna is practically issuing a direct command to the Supreme Lord here in his capacity as a warrior, and the Lord obeys it without any hesitation.
            This beautiful scene profoundly illustrates the incredibly sweet, transcendental, and unimaginable relationship where the Lord lovingly subordinates Himself to His pure devotee.
            Arjuna's decision to take the chariot to the center of the battlefield just before the first arrow is shot proves to be a massive historical turning point.
            It is precisely from this moment that the great illusion (moha) begins to cloud Arjuna's mind, which ultimately becomes the cause for the revelation of the Bhagavad Gita.
            Arjuna confidently wanted to observe the enemy forces up close, but divine destiny had planned a completely different spiritual journey for him.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            यावदेतान्निरीक्षेऽहं योद्धुकामानवस्थितान् |
            कैर्मया सह योद्धव्यमस्मिन् रणसमुद्यमे || २२ ||
        """.trimIndent(),
        hindi = """
            जब तक कि मैं युद्धभूमि में डटे हुए और युद्ध की प्रबल अभिलाषा रखने वाले इन सभी विपक्षी योद्धाओं को भली-भांति देख न लूँ।
            और यह जान न लूँ कि इस भयंकर युद्ध रूपी उद्योग में मुझे मुख्य रूप से किन-किन योद्धाओं के साथ शस्त्रों से मुकाबला करना है।
            यहाँ अर्जुन अपने सारथी श्रीकृष्ण को रथ बीच में रोकने का मुख्य कारण बता रहे हैं; वे कौरव सेना के प्रमुख शूरवीरों का अपनी आँखों से आकलन करना चाहते हैं।
            एक श्रेष्ठ सेनापति होने के नाते, यह अर्जुन की रणनीति का हिस्सा था कि वे अपने विपक्षियों की वास्तविक शक्ति और उनकी मानसिकता को करीब से समझें।
            अर्जुन पूरी तरह से निडर हैं; वे 'योद्धुकामान्' शब्द का प्रयोग करते हैं, जिसका अर्थ है जो लोग मरने-मारने की इच्छा से यहाँ आए हैं।
            वे देखना चाहते हैं कि वे कौन लोग हैं जिन्होंने अन्याय का साथ देने का फैसला किया है और जिन्हें आज उन्हें अपने गांडीव से मृत्यु के घाट उतारना है।
            इस क्षण तक अर्जुन के मन में रत्ती भर भी मोह, संकोच या कायरता नहीं है; वे पूरी तरह से एक शुद्ध क्षत्रिय की तरह सोच रहे हैं।
            परंतु, बीच मैदान में जाकर अपनों को ही शत्रु के रूप में सामने खड़े देखने से उनका यह दृढ़ आत्मविश्वास बहुत जल्द एक गहरे पारिवारिक मोह में बदलने वाला है।
        """.trimIndent(),
        english = """
            So that I may carefully observe all these opposing warriors who are standing here completely arrayed and fiercely eager for battle.
            And so that I may properly assess exactly with whom I must fight and contend in this massive and terrifying enterprise of war.
            Here Arjuna gives his charioteer Sri Krishna the primary reason for stopping the chariot in the middle; he wants to visually assess the Kaurava stalwarts.
            Being an elite and supreme military commander, it was an integral part of Arjuna's strategy to closely evaluate the actual strength and mindset of his opponents.
            Arjuna is completely fearless at this moment; he uses the word 'yoddhukaman', referring to those who have come with an intense desire to fight and die.
            He wants to see who exactly these people are who have chosen to support terrible injustice and whom he must slaughter today with his Gandiva bow.
            Up until this very second, there is not a single trace of illusion, hesitation, or cowardice in Arjuna's mind; he is thinking purely like a fearless Kshatriya warrior.
            However, standing in the middle and seeing his own beloved relatives arrayed as enemies is about to quickly transform this firm confidence into deep familial attachment.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            योत्स्यमानानवेक्षेऽहं य एतेऽत्र समागताः |
            धार्तराष्ट्रस्य दुर्बुद्धेर्युद्धे प्रियचिकीर्षवः || २३ ||
        """.trimIndent(),
        hindi = """
            मैं उन सभी लोगों को अच्छी तरह से देखना चाहता हूँ जो इस युद्ध में दुष्ट बुद्धि वाले धृतराष्ट्र-पुत्र (दुर्योधन) का प्रिय करने की इच्छा से यहाँ आए हैं।
            अर्जुन यहाँ बहुत ही स्पष्ट और कठोर शब्दों का प्रयोग करते हैं; वे दुर्योधन को 'दुर्बुद्धेः' (दुष्ट बुद्धि वाला या कुबुद्धि) कहकर संबोधित करते हैं।
            यह दर्शाता है कि अर्जुन के मन में यह बात बिल्कुल स्पष्ट है कि कौरवों का पक्ष पूरी तरह से अधर्म, अन्याय और लालच पर आधारित है।
            वे हैरान हैं और उन राजाओं को देखना चाहते हैं जो यह जानते हुए भी कि दुर्योधन अत्याचारी है, केवल उसके स्वार्थ को पूरा करने के लिए अपनी जान देने आ गए हैं।
            अर्जुन का यह मानना है कि जो कोई भी जानबूझकर एक दुष्ट का साथ देता है, वह भी समान रूप से दंड का भागी होता है।
            यह श्लोक अर्जुन की स्पष्ट न्यायप्रियता और धर्म के प्रति उनकी शुरुआती प्रतिबद्धता को बहुत अच्छी तरह से उजागर करता है।
            वे युद्ध के लिए पूरी तरह मानसिक रूप से तैयार हैं और विपक्षियों को अपना कटु शत्रु मान रहे हैं, जिनके प्रति वे कोई दया नहीं दिखाना चाहते।
            परंतु जैसे ही उनकी दृष्टि इन राजाओं के बजाय अपने सगे-संबंधियों, पिताओं और गुरुओं पर पड़ेगी, उनका यह सारा क्षत्रिय क्रोध अचानक से शांत हो जाएगा।
        """.trimIndent(),
        english = """
            I wish to carefully look at those who have assembled here to fight, solely desiring to please the evil-minded son of Dhritarashtra (Duryodhana) in this battle.
            Arjuna uses extremely clear and harsh words here; he directly refers to Duryodhana as 'Durbuddheh', meaning someone with an evil, wicked, or corrupt intelligence.
            This clearly indicates that Arjuna possesses absolute moral clarity at this moment that the Kaurava side is entirely based on adharma, terrible injustice, and greed.
            He is surprised and wants to observe those kings who, despite knowing Duryodhana is a tyrant, have come to sacrifice their lives merely to satisfy his selfishness.
            Arjuna firmly believes that whoever intentionally chooses to support an evil person is equally guilty and fully deserves extreme punishment.
            This verse brilliantly highlights Arjuna's initial commitment to justice, righteousness, and his clear understanding of his martial duty.
            He is fully prepared for war mentally and considers the opposition as bitter enemies towards whom he intends to show absolutely no mercy.
            But as soon as his gaze shifts from these kings to his own blood relatives, grandfathers, and teachers, all this righteous Kshatriya anger will suddenly evaporate.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            सञ्जय उवाच |
            एवमुक्तो हृषीकेशो गुडाकेशेन भारत |
            सेनयोरुभयोर्मध्ये स्थापयित्वा रथोत्तमम् || २४ ||
        """.trimIndent(),
        hindi = """
            संजय ने कहा: हे भरतवंशी राजा धृतराष्ट्र! निद्रा को जीतने वाले अर्जुन (गुडाकेश) द्वारा इस प्रकार कहे जाने पर, भगवान श्रीकृष्ण (हृषीकेश) ने उन दोनों सेनाओं के बीच...
            उस उत्तम और अत्यंत भव्य रथ को ले जाकर ठीक मध्य में खड़ा कर दिया।
            संजय का यह वर्णन बहुत ही प्रतीकात्मक और अर्थपूर्ण है। वे अर्जुन को 'गुडाकेश' कहते हैं—गुडाका का अर्थ है नींद या अज्ञान, और ईश का अर्थ है स्वामी।
            अर्जुन वह व्यक्ति हैं जिन्होंने अज्ञान और आलस्य दोनों पर पूरी तरह से विजय प्राप्त कर ली है, फिर भी वे कुछ ही पलों में एक गहरे मानसिक अज्ञान (मोह) में गिरने वाले हैं।
            भगवान श्रीकृष्ण को 'हृषीकेश' कहा गया है, जिसका अर्थ है सभी इंद्रियों के परम स्वामी और उन्हें नियंत्रित करने वाले परमेश्वर।
            जो स्वयं इंद्रियों के स्वामी हैं, वे आज अर्जुन की इच्छा के अधीन होकर उनके सारथी का कर्तव्य निभा रहे हैं; यह भगवान की असीम भक्त-वत्सलता है।
            संजय ने धृतराष्ट्र को 'भारत' (भरत के वंशज) कहकर पुकारा, जो शायद यह याद दिलाने के लिए था कि वे एक महान और पवित्र वंश के राजा हैं जिसे वे कलंकित कर रहे हैं।
            रथ को ठीक दोनों सेनाओं के बीच में खड़ा करना भगवान की एक बहुत गहरी लीला थी; वे जानबूझकर अर्जुन को उस मोह के बिंदु पर ले गए जहाँ से गीता का जन्म होना था।
        """.trimIndent(),
        english = """
            Sanjaya said: O King descendant of Bharata (Dhritarashtra)! Having been addressed thus by Arjuna (Gudakesha, the conqueror of sleep), Lord Krishna (Hrishikesha)...
            drew up that most excellent and magnificent chariot and placed it exactly in the midst of both the armies.
            Sanjaya's description here is highly symbolic and profoundly meaningful. He specifically calls Arjuna 'Gudakesha'—Gudaka means sleep or ignorance, and Isha means master.
            Arjuna is a man who has completely conquered both ignorance and physical laziness, yet in a few moments, he is about to fall into a deep, temporary mental ignorance (moha).
            Lord Krishna is addressed as 'Hrishikesha', which means the supreme master and ultimate controller of all the senses of all living beings.
            The One who is the absolute master of the senses is today willingly acting under the command of Arjuna as a charioteer; this is the Lord's limitless love for His devotees.
            Sanjaya calls Dhritarashtra 'Bharata' (descendant of King Bharata), perhaps to subtly remind him of the noble and pure dynasty he is currently disgracing through his greed.
            Placing the chariot exactly in the middle was the Lord's deep divine play; He intentionally brought Arjuna to the precise point of illusion from where the Gita had to be born.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            भीष्मद्रोणप्रमुखतः सर्वेषां च महीक्षिताम् |
            उवाच पार्थ पश्यैतान्समवेतान्कुरूनिति || २५ ||
        """.trimIndent(),
        hindi = """
            भीष्म पितामह, गुरु द्रोणाचार्य तथा सामने खड़े अन्य सभी राजाओं के ठीक सामने रथ को रोककर भगवान श्रीकृष्ण ने कहा:
            "हे पार्थ! यहाँ युद्ध के लिए एकत्र हुए इन सभी कुरुवंशियों को भली-भांति देखो।"
            यह श्लोक एक बहुत बड़े मनोवैज्ञानिक भूचाल का बिल्कुल आरंभिक बिंदु है। भगवान श्रीकृष्ण ने जानबूझकर रथ को भीष्म और द्रोण के ठीक सामने लाकर खड़ा किया।
            श्रीकृष्ण अर्जुन के मन की गहराई को बहुत अच्छी तरह जानते थे; वे जानते थे कि अर्जुन के भीतर अपने पितामह और गुरु के प्रति असीम आदर और अगाध प्रेम है।
            उन्होंने साधारण राजाओं के सामने रथ नहीं रोका, बल्कि ठीक उन लोगों के सामने रोका जिनसे अर्जुन का सबसे गहरा और सबसे संवेदनशील भावनात्मक जुड़ाव था।
            इसके बाद श्रीकृष्ण ने बहुत ही संक्षिप्त लेकिन मारक वाक्य कहा—"पश्यैतान्समवेतान्कुरूनिति" (इन कुरुवंशियों को देखो)।
            उन्होंने 'शत्रुओं को देखो' नहीं कहा, बल्कि 'कुरुवंशियों' (तुम्हारे अपने परिवार वालों) को देखो कहा; इस एक छोटे से वाक्य ने अर्जुन के सोचने का नजरिया ही बदल दिया।
            भगवान अर्जुन के भीतर छिपे हुए उस अज्ञान और मोह को बाहर लाना चाहते थे ताकि वे भगवद्गीता के चिरस्थायी ज्ञान रूपी शल्यक्रिया (सर्जरी) के माध्यम से उसे हमेशा के लिए काट सकें।
        """.trimIndent(),
        english = """
            Right in front of Grandsire Bhishma, Guru Dronacharya, and all the other rulers of the earth, Lord Sri Krishna stopped the chariot and said:
            "O Partha! Behold all these members of the Kuru dynasty who are assembled here for battle."
            This verse is the absolute starting point of a massive psychological earthquake. Lord Krishna intentionally stopped the chariot exactly in front of Bhishma and Drona.
            Sri Krishna deeply understood the innermost workings of Arjuna's mind; He knew that Arjuna held boundless respect and unfathomable love for his grandfather and teacher.
            He did not stop the chariot in front of ordinary kings, but precisely in front of those with whom Arjuna had the deepest and most sensitive emotional connection.
            Thereafter, Krishna spoke a very brief but lethal sentence—"Pashyaitan samavetan Kurun iti" (Behold these assembled Kurus).
            He did not say 'behold your enemies', but rather 'behold the Kurus' (your own family members); this one tiny sentence completely altered Arjuna's entire perspective.
            The Lord wanted to bring out the hidden ignorance and attachment from within Arjuna so that He could surgically remove it forever through the eternal wisdom of the Bhagavad Gita.
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            तत्रापश्यत्स्थितान्पार्थः पितॄनथ पितामहान् |
            आचार्यान्मातुलान्भ्रातॄन्पुत्रान्पौत्रान्सखींस्तथा || २६ ||
        """.trimIndent(),
        hindi = """
            तब उस युद्धभूमि में अर्जुन (पार्थ) ने दोनों सेनाओं में अपने ताऊ-चाचाओं (पिताओं), दादों-परदादों (पितामहों), गुरुओं (आचार्यों), मामाओं...
            भाइयों, पुत्रों, पौत्रों (पोतों) और साथ ही अपने बहुत से बचपन के मित्रों को युद्ध के लिए बिल्कुल तैयार खड़े देखा।
            रथ के मध्य में रुकते ही अर्जुन की आँखों ने शत्रु सैनिकों को देखना बंद कर दिया, और उन्हें हर चेहरे में अपना कोई न कोई सगा-संबंधी दिखाई देने लगा।
            उन्होंने भीष्म, सोमदत्त और भूरिश्रवा जैसे श्रद्धेय पितामहों को देखा; द्रोणाचार्य और कृपाचार्य जैसे पूजनीय गुरुओं को देखा; शल्य और शकुनि जैसे मामाओं को देखा।
            दुर्योधन और दुशासन जैसे चचेरे भाइयों को देखा; और लक्ष्मण जैसे अनेकों भतीजों और पोतों को मरने और मारने के लिए तैयार खड़े देखा।
            यह दृश्य अर्जुन के लिए अत्यंत हृदय विदारक था। जो अर्जुन कुछ क्षण पहले 'योद्धुकामान्' (युद्ध के प्यासे शत्रुओं) को देखने की बात कर रहा था...
            वह अब अचानक से अपने ही परिवार के एक अत्यंत विशाल और विनाशकारी पारिवारिक कलह को साक्षात् अपने सामने घटित होते हुए देख रहा था।
            यहीं से अर्जुन का वह महान 'विषाद' (गहरा दुःख और अवसाद) शुरू होता है, क्योंकि अब उनके सामने शत्रु नहीं, बल्कि उनका अपना ही खून खड़ा था।
        """.trimIndent(),
        english = """
            Then, standing there on the battlefield, Arjuna (Partha) saw stationed in both armies his uncles (fathers), grandfathers, great-grandfathers, teachers, maternal uncles...
            brothers, sons, grandsons, and also many of his childhood friends and companions fully prepared for war.
            As soon as the chariot stopped in the middle, Arjuna's eyes completely stopped seeing enemy soldiers, and he began to see his own blood relatives in every single face.
            He saw revered grandfathers like Bhishma, Somadatta, and Bhurishrava; worshipable teachers like Dronacharya and Kripacharya; and uncles like Shalya and Shakuni.
            He saw cousins like Duryodhana and Dushasana; and countless nephews and grandsons like Lakshmana standing ready to kill and be killed.
            This scene was absolutely heart-wrenching for Arjuna. The very same Arjuna who a moment ago was talking about observing 'bloodthirsty enemies'...
            was now suddenly witnessing a massive and completely devastating family feud unfolding right in front of his very own eyes.
            It is exactly from this point that Arjuna's great 'Vishada' (profound sorrow and deep depression) begins, because standing before him were no longer enemies, but his own blood.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            श्वशुरान् सुहृदश्चैव सेनयोरुभयोरपि |
            तान्समीक्ष्य स कौन्तेयः सर्वान्बन्धूनवस्थितान् || २७ ||
        """.trimIndent(),
        hindi = """
            उन्होंने दोनों ही सेनाओं में अपने ससुरों और बहुत से शुभचिंतकों (सुहृदों) को भी देखा।
            इस प्रकार कुन्ती-पुत्र अर्जुन (कौन्तेय) ने उन सभी सगे-संबंधियों (बंधुओं) को वहाँ मरने-मारने के लिए उपस्थित देखकर...
            यह श्लोक पिछले श्लोक के विचार को ही पूर्ण करता है। अर्जुन ने केवल कौरव सेना में ही नहीं, बल्कि अपनी स्वयं की सेना में भी अपने प्रियजनों को देखा।
            उन्होंने अपने ससुर (जैसे द्रुपद) और ऐसे सुहृदों (मित्रों) को देखा जो केवल प्रेम और वफादारी के कारण अपनी जान की बाजी लगाने आ गए थे।
            जब अर्जुन ने दोनों पक्षों में केवल और केवल अपने ही लोगों (सर्वान् बन्धून्) को देखा, तो उनका हृदय अत्यंत द्रवित हो उठा।
            उन्हें अचानक यह भयंकर और कड़वी सच्चाई महसूस हुई कि यह युद्ध चाहे जो भी जीते, अंततः विनाश केवल उनके अपने ही परिवार और प्रियजनों का होना है।
            कौरव हारें या पांडव हारें, खून तो कुरुवंश का ही बहेगा। यह सोचकर एक वीर क्षत्रिय का कठोर हृदय एक आम संसारी मनुष्य की तरह पिघलने लगा।
            अर्जुन का यह मोह कोई साधारण डर नहीं था; यह अपनों को खोने का वह स्वाभाविक और असीम मानवीय दुःख था, जिसे हर सामान्य मनुष्य महसूस करता है।
        """.trimIndent(),
        english = """
            He also saw his fathers-in-law and many well-wishers stationed in both the armies.
            Having closely observed all these assembled kinsmen and blood relatives standing there ready to fight, the son of Kunti (Arjuna)...
            This verse directly completes the profound thought of the previous verse. Arjuna didn't just see relatives in the Kaurava army, but in his own army as well.
            He saw his fathers-in-law (like King Drupada) and such well-wishers (friends) who had come to risk their precious lives entirely out of pure love and loyalty to him.
            When Arjuna saw absolutely nothing but his very own people (sarvan bandhun) arrayed on both sides, his heart melted with extreme emotion.
            He suddenly realized the terrifying and bitter truth that no matter who actually wins this war, the ultimate destruction will only be of his own family and loved ones.
            Whether the Kauravas lose or the Pandavas lose, the blood spilled will solely belong to the Kuru dynasty. Thinking this, the hard heart of a brave warrior began to melt like an ordinary man.
            Arjuna's illusion here was not ordinary physical cowardice; it was the natural and boundless human sorrow of losing one's loved ones, something every normal human experiences.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            कृपया परयाविष्टो विषीदन्निदमब्रवीत् |
            अर्जुन उवाच |
            दृष्ट्वेमं स्वजनं कृष्ण युयुत्सुं समुपस्थितम् || २८ ||
        """.trimIndent(),
        hindi = """
            अत्यंत गहरी करुणा (कृपा) से पूरी तरह घिरकर और गहरे शोक (विषाद) में डूबकर अर्जुन ने ये वचन कहे।
            अर्जुन ने कहा: हे कृष्ण! युद्ध की इच्छा से यहाँ एकत्र हुए अपने ही इन सगे-संबंधियों (स्वजनों) को देखकर...
            यह वह क्षण है जहाँ अर्जुन का शरीर और मन पूरी तरह से टूट रहा है। वे 'परया कृपया' (अत्यधिक और अनुचित दया) से भर गए हैं।
            यह दया धर्म पर आधारित नहीं है, बल्कि 'स्वजन' (ये मेरे अपने हैं) के सीमित और अज्ञानपूर्ण मोह पर आधारित है।
            अर्जुन भूल गए हैं कि ये वही कौरव हैं जिन्होंने द्रौपदी का चीरहरण किया था, उन्हें विष दिया था, और लाख के घर में जलाने की कोशिश की थी।
            अपनों को सामने देखकर अर्जुन का सारा क्रोध और प्रतिशोध की भावना एक पल में विलुप्त हो गई, और उसकी जगह एक भयंकर मानसिक विषाद ने ले ली।
            वे भगवान कृष्ण से कहते हैं कि हे कृष्ण, ये शत्रु नहीं हैं, ये तो मेरे अपने लोग हैं, जो युद्ध के उन्माद में यहाँ आ गए हैं।
            यह श्लोक स्पष्ट करता है कि मनुष्य का सबसे बड़ा शत्रु कोई बाहरी व्यक्ति नहीं, बल्कि उसके अपने ही भीतर बैठा हुआ मोह और अज्ञान है।
        """.trimIndent(),
        english = """
            Being completely overwhelmed by extreme and misplaced compassion, and sinking deep into sorrow (Vishada), Arjuna spoke these words.
            Arjuna said: O Krishna! Seeing my very own kinsmen (Swajanam) present here, so fiercely eager to fight against each other...
            This is the exact moment where Arjuna's mind and body are completely breaking down. He is overwhelmed by 'Paraya Kripaya' (excessive and misplaced pity).
            This compassion is not based on righteousness or dharma, but entirely on the limited, ignorant, and selfish attachment of 'Swajana' (these are my own people).
            Arjuna has momentarily forgotten that these are the exact same Kauravas who tried to disrobe Draupadi, poisoned Bhima, and tried to burn them alive in the house of lac.
            Seeing his own people, all his righteous anger and desire for justice vanished in a split second, completely replaced by a terrifying mental depression (Vishada).
            He tells Lord Krishna that these are not enemies, these are my own beloved people who have foolishly gathered here in the frenzy of war.
            This verse brilliantly clarifies that a human being's greatest enemy is never an outsider, but the deep-rooted attachment and ignorance sitting within their own mind.
        """.trimIndent()
    ),
    Shloka(
        id = 29,
        sanskrit = """
            सीदन्ति मम गात्राणि मुखं च परिशुष्यति |
            वेपथुश्च शरीरे मे रोमहर्षश्च जायते || २९ ||
        """.trimIndent(),
        hindi = """
            मेरे शरीर के सभी अंग बुरी तरह शिथिल हो रहे हैं (काँप रहे हैं), और मेरा मुँह पूरी तरह से सूख रहा है।
            मेरे सारे शरीर में एक भयानक कंपन हो रहा है, और मेरे रोंगटे खड़े हो रहे हैं (शरीर में रोमांच हो रहा है)।
            अर्जुन यहाँ अपने गहरे मानसिक अवसाद (डिप्रेशन) के प्रत्यक्ष शारीरिक लक्षणों का बहुत ही स्पष्ट वर्णन कर रहे हैं।
            जब मन भयंकर मोह और शोक से ग्रस्त होता है, तो उसका सीधा और सबसे पहला प्रभाव हमारे भौतिक शरीर और नर्वस सिस्टम पर पड़ता है।
            अर्जुन जो कि ब्रह्मांड के सर्वश्रेष्ठ धनुर्धर हैं और जिन्होंने अकेले ही देवताओं और असुरों को हराया है, आज वे सामान्य व्यक्ति की तरह पैनिक अटैक का शिकार हो गए हैं।
            अपनों को मारने के पाप का काल्पनिक भय इतना गहरा है कि उनके शरीर ने काम करना बंद कर दिया है; उनकी मांसपेशियां (गात्राणि) जवाब दे रही हैं।
            तनाव और डर के कारण उनका मुँह सूख रहा है, शरीर काँप रहा है और रोंगटे खड़े हो गए हैं, जो अत्यधिक मनोवैज्ञानिक दबाव का सीधा परिणाम है।
            यह स्थिति दर्शाती है कि शारीरिक बल चाहे कितना भी अधिक क्यों न हो, यदि मन कमजोर और भ्रमित हो जाए, तो शरीर किसी काम का नहीं रहता।
        """.trimIndent(),
        english = """
            All the limbs of my body are failing and quivering, and my mouth is drying up completely.
            A terrible trembling has taken over my entire body, and my hair is standing on end.
            Arjuna is providing a very explicit and clinical description of the direct physical symptoms of his deep mental depression and anxiety here.
            When the mind is severely gripped by terrible attachment and grief, its direct and very first impact is heavily felt on our physical body and nervous system.
            Arjuna, who is the greatest archer in the universe and has single-handedly defeated gods and demons, is suffering a massive panic attack today like an ordinary man.
            The imaginary fear and guilt of killing his own relatives is so profound that his body has simply stopped functioning; his muscles (gatrani) are giving way.
            Due to extreme stress and fear, his mouth is parched, his body is violently shaking, and his hair is standing on end—a direct result of overwhelming psychological pressure.
            This condition perfectly proves that no matter how immensely immense one's physical strength is, if the mind becomes weak and confused, the body becomes completely useless.
        """.trimIndent()
    ),
    Shloka(
        id = 30,
        sanskrit = """
            गाण्डीवं स्रंसते हस्तात्त्वक्चैव परिदह्यते |
            न च शक्नोम्यवस्थातुं भ्रमतीव च मे मनः || ३० ||
        """.trimIndent(),
        hindi = """
            मेरा विश्व-प्रसिद्ध गांडीव धनुष मेरे हाथों से छूट कर गिर रहा है, और मेरी पूरी त्वचा (चमड़ी) मानो जल रही है।
            मुझमें अब रथ पर खड़े रहने की भी शक्ति नहीं बची है, और मेरा मन पूरी तरह से चकरा रहा है (भ्रमित हो रहा है)।
            अर्जुन की मनोवैज्ञानिक और शारीरिक गिरावट यहाँ अपने चरम पर पहुँच गई है। उनका सबसे प्रिय हथियार, अजेय 'गांडीव', उनके हाथों से फिसल रहा है।
            एक क्षत्रिय के हाथ से उसके युद्ध के समय उसका हथियार गिर जाना उसकी सबसे बड़ी हार और असीमित मानसिक कमजोरी का सूचक है।
            अत्यधिक मानसिक तनाव के कारण उन्हें ऐसा महसूस हो रहा है जैसे उनके पूरे शरीर की त्वचा आग से जल रही है, जो तीव्र घबराहट (Anxiety) का लक्षण है।
            वे कहते हैं कि उनके पैरों में अब खड़े रहने की भी जान नहीं है; उनका सिर चकरा रहा है और वे सोचने-समझने की पूरी क्षमता खो चुके हैं।
            'भ्रमतीव च मे मनः'—यह वाक्य स्पष्ट करता है कि अर्जुन का मन पूरी तरह से उनके नियंत्रण से बाहर हो चुका है और अज्ञान के भंवर में फँस गया है।
            गीता हमें सिखाती है कि जब हम अपने कर्तव्यों (धर्म) को भूलकर केवल 'मेरे और तेरे' (मोह) के चक्कर में पड़ जाते हैं, तो हमारी भी यही स्थिति होती है।
        """.trimIndent(),
        english = """
            My world-famous Gandiva bow is slipping from my hands, and my entire skin feels as if it is burning.
            I am no longer even able to stand steadily on the chariot, and my mind is completely whirling in confusion.
            Arjuna's psychological and physical breakdown has reached its absolute peak here. His most beloved and invincible weapon, the 'Gandiva', is slipping from his grasp.
            For a Kshatriya warrior to physically drop his weapon during the time of war is the ultimate sign of defeat and limitless mental weakness.
            Due to extreme mental tension, he feels as though the skin of his entire body is burning with fire, which is a classic clinical symptom of severe anxiety.
            He states that he has absolutely no strength left in his legs to even stand; his head is spinning heavily, and he has completely lost his ability to think rationally.
            'Bhramativa cha me manah'—this specific sentence clarifies that Arjuna's mind has gone completely out of his control and is hopelessly trapped in a whirlpool of ignorance.
            The Gita teaches us that whenever we forget our rightful duties (dharma) and fall entirely into the trap of 'mine and yours' (attachment), we suffer the exact same fate.
        """.trimIndent()
    ),
    Shloka(
        id = 31,
        sanskrit = """
            निमित्तानि च पश्यामि विपरीतानि केशव |
            न च श्रेयोऽनुपश्यामि हत्वा स्वजनमाहवे || ३१ ||
        """.trimIndent(),
        hindi = """
            हे केशव! मुझे तो सभी शकुन और लक्षण भी अत्यंत विपरीत (अशुभ) ही दिखाई दे रहे हैं।
            और युद्ध में अपने ही सगे-संबंधियों को मारकर मुझे कोई भी कल्याण (श्रेय) या भलाई दिखाई नहीं देती।
            डरा हुआ और भ्रमित मन हमेशा अपने डर को सही साबित करने के लिए बहाने ढूँढता है; अर्जुन यहाँ वही कर रहे हैं।
            वे श्रीकृष्ण को 'केशव' (केशी राक्षस को मारने वाले) कहकर पुकारते हैं, और कहते हैं कि उन्हें हर तरफ अपशकुन दिखाई दे रहे हैं।
            वास्तव में, अर्जुन के रथ पर हनुमान विराजमान हैं और सारथी स्वयं भगवान हैं, इससे बड़ा शुभ शकुन ब्रह्मांड में कुछ नहीं हो सकता।
            लेकिन मोह में अंधा हो चुका व्यक्ति सत्य को नहीं देख पाता। अर्जुन अब तर्क दे रहे हैं कि अपनों को मारने से कोई 'श्रेय' (कल्याण) नहीं होगा।
            वे न्याय और धर्म की स्थापना रूपी सबसे बड़े कल्याण को पूरी तरह भूल चुके हैं और केवल अपने परिवार के जीवित रहने को ही 'श्रेय' मान रहे हैं।
            यह एक आम मानवीय प्रवृत्ति है; जब हम कोई कठिन लेकिन सही काम करने से डरते हैं, तो हम उसे गलत साबित करने के लिए झूठे तर्क गढ़ने लगते हैं।
        """.trimIndent(),
        english = """
            O Keshava! I am only seeing completely adverse and highly inauspicious omens everywhere.
            And I do not foresee any good or ultimate benefit (Shreya) whatsoever in killing my own kinsmen in this battle.
            A terrified and highly confused mind always desperately searches for excuses to justify its fear; Arjuna is doing exactly that here.
            He addresses Sri Krishna as 'Keshava' (the killer of the Keshi demon) and claims that he is seeing bad omens and signs of disaster all around him.
            In reality, Hanuman is seated on Arjuna's flag and the Supreme Lord Himself is his charioteer; there can be absolutely no greater auspicious omen in the universe than this.
            But a person completely blinded by attachment simply cannot see the truth. Arjuna is now arguing logically that killing his own people will bring no 'Shreya' (welfare).
            He has completely forgotten the supreme welfare of establishing justice and dharma, and is wrongly considering only the survival of his physical family as 'Shreya'.
            This is a very common human tendency; whenever we are deeply afraid to do a difficult but righteous task, we begin fabricating false logic to prove it wrong.
        """.trimIndent()
    ),
    Shloka(
        id = 32,
        sanskrit = """
            न काङ्क्षे विजयं कृष्ण न च राज्यं सुखानि च |
            किं नो राज्येन गोविन्द किं भोगैर्जीवितेन वा || ३२ ||
        """.trimIndent(),
        hindi = """
            हे कृष्ण! मैं न तो युद्ध में विजय की इच्छा रखता हूँ, और न ही मुझे राज्य या राजसुखों की कोई कामना है।
            हे गोविन्द! हमें ऐसे राज्य से क्या लाभ? अथवा ऐसे सुख-भोगों और यहाँ तक कि इस जीवन से भी हमें क्या प्रयोजन है?
            अर्जुन का वैराग्य यहाँ मुखर हो रहा है, लेकिन यह सच्चा आध्यात्मिक वैराग्य नहीं है; यह दुःख और मोह से उत्पन्न हुआ 'शमशान वैराग्य' है।
            वे कृष्ण को 'गोविन्द' (गायों, इंद्रियों और भूमि को आनंद देने वाले) कहते हैं और जीवन से पूर्ण निराशा व्यक्त करते हैं।
            वे कहते हैं कि जिस राज्य, विजय या सुख के लिए यह युद्ध हो रहा है, वह उनके लिए पूरी तरह से अर्थहीन है यदि उन्हें अपनों को ही मारना पड़े।
            अर्जुन यह भूल गए हैं कि यह युद्ध उन्होंने अपने सुख के लिए नहीं, बल्कि समाज से दुर्योधन के अत्याचार को मिटाने के लिए चुना था।
            जब हम अपने कर्तव्य को व्यक्तिगत लाभ या हानि के तराजू पर तौलने लगते हैं, तो हम अक्सर कर्तव्य से भागने की कोशिश करते हैं।
            अर्जुन भी अपने क्षत्रिय धर्म से भागकर संन्यासी बनने का जो तर्क दे रहे हैं, वह केवल उनके छिपे हुए डर और मोह का आवरण (कवर) है।
        """.trimIndent(),
        english = """
            O Krishna! I do not desire victory in this war, nor do I have any craving for the kingdom or its royal pleasures.
            O Govinda! Of what use is such a kingdom to us? Or what is the purpose of such enjoyments, or even of this life itself?
            Arjuna's sense of renunciation is becoming highly vocal here, but this is absolutely not true spiritual renunciation; it is a temporary escapism born of grief and attachment.
            He addresses Krishna as 'Govinda' (the giver of pleasure to cows, senses, and the earth) and expresses complete frustration and hopelessness with life itself.
            He argues that the kingdom, victory, or happiness for which this massive war is being fought is completely meaningless to him if he has to kill his own people.
            Arjuna has entirely forgotten that he did not choose this war for his personal happiness, but to eradicate Duryodhana's terrible tyranny from society.
            Whenever we start weighing our supreme duties on the selfish scales of personal gain or loss, we almost always try to escape from our responsibilities.
            The philosophical logic Arjuna is presenting to escape his Kshatriya duty and become a renunciate is merely a deceptive cover for his deeply hidden fear and attachment.
        """.trimIndent()
    ),
    Shloka(
        id = 33,
        sanskrit = """
            येषामर्थे काङ्क्षितं नो राज्यं भोगाः सुखानि च |
            त इमेऽवस्थिता युद्धे प्राणांस्त्यक्त्वा धनानि च || ३३ ||
        """.trimIndent(),
        hindi = """
            हम जिनके लिए यह राज्य, सुख और तरह-तरह के भोग प्राप्त करना चाहते हैं...
            वे ही सब लोग अपने प्राणों और धन की आशा को पूरी तरह से त्याग कर आज इस युद्धभूमि में हमारे सामने खड़े हैं।
            अर्जुन का तर्क है कि मनुष्य धन, संपत्ति और राज्य का आनंद केवल अपने परिवार और प्रियजनों के साथ ही तो बांटता है।
            यदि वे ही प्रियजन (जिनके लिए हम यह सब पाना चाहते हैं) इस युद्ध में मारे जाएंगे, तो उस खाली राज्य का सिंहासन किस काम का?
            वे देख रहे हैं कि कौरव पक्ष के सभी लोग अपने प्राणों का मोह छोड़कर युद्ध करने आ गए हैं ('प्राणांस्त्यक्त्वा')।
            अर्जुन की यह सोच संसारी दृष्टि से बिल्कुल सही और अत्यंत भावुक लगती है, लेकिन धर्म की दृष्टि से यह पूरी तरह से गलत है।
            धर्म यह नहीं देखता कि सामने अपराधी आपका भाई है या कोई अजनबी; धर्म केवल न्याय की मांग करता है।
            अर्जुन एक न्यायाधीश (क्षत्रिय) की कुर्सी पर बैठकर एक अपराधी (कौरवों) के प्रति परिवारिक मोह दिखा रहे हैं, जो उनके कर्तव्य का घोर उल्लंघन है।
        """.trimIndent(),
        english = """
            Those very persons for whose sake we desire this kingdom, royal enjoyments, and various types of pleasures...
            they themselves are standing here right before us on this battlefield, having completely given up all hope for their lives and wealth.
            Arjuna makes a highly emotional argument that a human being truly enjoys wealth, property, and a kingdom only when he shares it with his family and loved ones.
            If those very loved ones (for whom we want to achieve all this) are slaughtered in this war, then what is the use of an empty, blood-stained throne?
            He clearly sees that everyone on the Kaurava side has come to fight, having entirely abandoned their attachment to their own lives ('pranans tyaktva').
            This specific thought of Arjuna appears absolutely correct and highly emotional from a worldly perspective, but from the strict viewpoint of dharma, it is completely flawed.
            Dharma (righteousness) does not check whether the criminal standing before you is your blood brother or a total stranger; dharma demands absolute justice.
            Arjuna is sitting in the chair of a supreme judge (a Kshatriya) but showing familial attachment towards criminals (the Kauravas), which is a terrible violation of his sacred duty.
        """.trimIndent()
    ),
    Shloka(
        id = 34,
        sanskrit = """
            आचार्याः पितरः पुत्रास्तथैव च पितामहाः |
            मातुलाः श्वशुराः पौत्राः श्यालाः सम्बन्धिनस्तथा || ३४ ||
        """.trimIndent(),
        hindi = """
            यहाँ मेरे गुरुजन (आचार्याः), ताऊ-चाचे (पितरः), पुत्र, उसी प्रकार दादे-परदादे (पितामहाः)...
            मामा (मातुलाः), ससुर (श्वशुराः), पोते (पौत्राः), साले (श्यालाः) तथा अन्य सभी रिश्तेदार (सम्बन्धिनः) मरने के लिए खड़े हैं।
            अर्जुन एक बार फिर अपने सभी रिश्तेदारों की पूरी सूची गिना रहे हैं, मानो वे श्रीकृष्ण को अपने दुःख की गहराई का एहसास कराना चाहते हों।
            वे गुरुओं (जैसे द्रोण और कृप) का नाम सबसे पहले लेते हैं, क्योंकि भारतीय संस्कृति में गुरु का स्थान पिता से भी ऊपर होता है और उन पर शस्त्र उठाना महापाप है।
            फिर वे पितरों (जैसे सोमदत्त), पितामहों (जैसे भीष्म), शल्य जैसे मामाओं, और द्रुपद जैसे ससुरों की गिनती करते हैं।
            वे उन साले-बहनोइयों और अन्य संबंधियों को भी गिनते हैं जो उनसे पारिवारिक रूप से जुड़े हुए हैं।
            यह श्लोक दिखाता है कि अर्जुन का मन पूरी तरह से पारिवारिक संबंधों के मायाजाल में जकड़ चुका है।
            उनका क्षत्रिय धर्म (समाज की रक्षा) इस समय उनके पारिवारिक धर्म (परिवार की रक्षा) के सामने पूरी तरह से बौना और अर्थहीन हो गया है।
        """.trimIndent(),
        english = """
            Standing here to die are my teachers (Acharyas), uncles (Pitarah), sons, and similarly my grandfathers (Pitamahah)...
            maternal uncles (Matulah), fathers-in-law (Shwashurah), grandsons (Pautrah), brothers-in-law (Shyalah), and all other relatives (Sambandhinah).
            Arjuna is once again recounting a complete, detailed list of all his relatives, as if he desperately wants to make Sri Krishna realize the sheer depth of his sorrow.
            He deliberately places his teachers (like Drona and Kripa) at the very beginning of the list, because in Indian culture, a teacher is above a father, and raising a weapon against them is a massive sin.
            Then he counts his uncles (like Somadatta), grandfathers (like Bhishma), maternal uncles like Shalya, and fathers-in-law like Drupada.
            He also counts the brothers-in-law and other extended relatives who are closely connected to him through various family ties.
            This verse clearly demonstrates that Arjuna's mind is completely and hopelessly entangled in the deceptive web of worldly family relationships.
            His supreme Kshatriya duty (protecting society and justice) has completely dwarfed and become totally meaningless in the face of his localized family duty (protecting relatives).
        """.trimIndent()
    ),
    Shloka(
        id = 35,
        sanskrit = """
            एतान्न हन्तुमिच्छामि घ्नतोऽपि मधुसूदन |
            अपि त्रैलोक्यराज्यस्य हेतोः किं नु महीकृते || ३५ ||
        """.trimIndent(),
        hindi = """
            हे मधुसूदन! भले ही ये लोग मुझे ही क्यों न मार डालें, फिर भी मैं इन्हें मारना बिल्कुल नहीं चाहता।
            तीनों लोकों (स्वर्ग, पृथ्वी, और पाताल) के राज्य के लिए भी मैं इन्हें मारना नहीं चाहता, तो फिर इस छोटी सी पृथ्वी के राज्य के लिए तो कहना ही क्या!
            अर्जुन की भावनाएँ यहाँ अपनी चरम सीमा पार कर चुकी हैं। वे अहिंसा का सबसे बड़ा और सबसे आदर्शवादी तर्क प्रस्तुत कर रहे हैं।
            वे कहते हैं कि यदि कौरव निर्दयी होकर मुझे निहत्थे को मार भी दें ('घ्नतोऽपि'), तो भी मैं पलटकर उन पर कोई प्रहार नहीं करूँगा।
            वे श्रीकृष्ण को 'मधुसूदन' (मधु नामक असुर को मारने वाला) कहते हैं; शायद वे इशारा कर रहे हैं कि आपने तो असुरों को मारा था, मैं अपने परिवार को कैसे मारूँ?
            अर्जुन का यह तर्क सुनने में अत्यंत पवित्र, दयालु और त्यागमयी लगता है, कि वे त्रिलोकी के राज्य को भी ठुकराने को तैयार हैं।
            परंतु सच्चाई यह है कि यह त्याग सत्य और ज्ञान से नहीं, बल्कि भयंकर कायरता और गहरे मोह से उत्पन्न हुआ है।
            अन्याय को चुपचाप सहना और अत्याचारियों को छोड़ देना कोई धर्म नहीं है; यह तो समाज को और अधिक विनाश की ओर धकेलने वाला सबसे बड़ा पाप है।
        """.trimIndent(),
        english = """
            O Madhusudana! Even if these people relentlessly attack and kill me, I still absolutely do not wish to kill them.
            Even for the sake of ruling all the three worlds (heaven, earth, and the netherworld), I do not want to slay them; what then to speak of this insignificant earth!
            Arjuna's emotions have completely crossed their ultimate limits here. He is presenting the highest and most idealistic argument for non-violence (Ahimsa).
            He passionately states that even if the Kauravas mercilessly slaughter him while he is completely unarmed ('ghnato api'), he will still not strike back at them.
            He addresses Sri Krishna as 'Madhusudana' (the slayer of the demon Madhu); perhaps subtly hinting that You killed demons, how can I kill my own beloved family?
            Arjuna's argument sounds extremely pure, intensely compassionate, and highly sacrificial, as he is ready to reject even the absolute sovereignty of the three worlds.
            But the harsh reality is that this so-called renunciation is not born of truth and supreme knowledge, but out of terrible cowardice and profound delusion.
            Silently tolerating terrible injustice and letting murderous tyrants go unpunished is not dharma; it is actually the greatest sin that pushes society towards even more destruction.
        """.trimIndent()
    ),
    Shloka(
        id = 36,
        sanskrit = """
            निहत्य धार्तराष्ट्रान्नः का प्रीतिः स्याज्जनार्दन |
            पापमेवाश्रयेदस्मान्हत्वैतानाततायिनः || ३६ ||
        """.trimIndent(),
        hindi = """
            हे जनार्दन (श्रीकृष्ण)! धृतराष्ट्र के इन पुत्रों को मारकर हमें भला क्या प्रसन्नता (प्रीति) मिलेगी?
            इन आततायियों (महा-अपराधियों) को मारने से तो हमें केवल भयानक पाप ही लगेगा।
            अर्जुन यहाँ श्रीकृष्ण को 'जनार्दन' (मनुष्यों का पालन करने वाले) कहकर पुकार रहे हैं, यह संकेत देते हुए कि जो सबका पालन करता है, वह विनाश की आज्ञा कैसे दे सकता है?
            वे मानते हैं कि कौरव 'आततायी' हैं। वैदिक शास्त्रों के अनुसार आततायी छह प्रकार के होते हैं: विष देने वाला, घर में आग लगाने वाला, घातक हथियार से हमला करने वाला, धन लूटने वाला, भूमि छीनने वाला, और पत्नी का अपहरण करने वाला।
            कौरवों ने ये सभी भयंकर अपराध पांडवों के विरुद्ध किए थे, और शास्त्र स्पष्ट कहता है कि ऐसे आततायियों को तुरंत मार देना चाहिए, इसमें कोई पाप नहीं है।
            फिर भी, अर्जुन का मोह इतना गहरा हो चुका है कि वे शास्त्रों के इस स्पष्ट नियम को भी नजरअंदाज कर रहे हैं और कह रहे हैं कि इन्हें मारने से पाप लगेगा।
            मोह में फँसा हुआ व्यक्ति हमेशा अपने बचाव के लिए शास्त्रों का आधा-अधूरा और अपने मनमुताबिक अर्थ निकालता है।
            अर्जुन भूल रहे हैं कि एक न्यायाधीश या क्षत्रिय जब किसी अपराधी को दंड देता है, तो उसे पाप नहीं लगता, बल्कि वह समाज को पाप-मुक्त करता है।
            यहीं पर अर्जुन का व्यक्तिगत प्रेम उनके सामाजिक और क्षत्रिय कर्तव्य पर पूरी तरह से हावी हो गया है।
            वे अपने न्याय करने के कठोर दायित्व से भागकर एक झूठे और भावुक वैराग्य का सहारा ले रहे हैं।
        """.trimIndent(),
        english = """
            O Janardana (Krishna)! What joy or pleasure can we possibly derive from killing these sons of Dhritarashtra?
            Sin will solely overcome us if we slay such aggressors (Atatayis) who are standing before us.
            Arjuna addresses Sri Krishna here as 'Janardana' (the maintainer of all people), subtly hinting that He who maintains the world shouldn't command its destruction.
            He clearly acknowledges that the Kauravas are 'Atatayis' (deadly aggressors). Vedic scriptures define six types of aggressors: a poisoner, an arsonist, one who attacks with deadly weapons, a plunderer of wealth, an occupier of land, and a kidnapper of a wife.
            The Kauravas had ruthlessly committed every single one of these heinous crimes against the Pandavas, and scriptures explicitly state that such aggressors must be killed immediately without any sin being incurred.
            However, Arjuna's attachment has become so incredibly deep that he completely ignores this clear scriptural injunction and claims that killing them will bring terrible sin upon him.
            A person trapped in illusion always selectively quotes and twists scriptures to conveniently justify his own fears and weaknesses.
            Arjuna forgets that when a judge or a Kshatriya punishes a lethal criminal, he does not incur sin; rather, he purifies society from sin.
            This is exactly where Arjuna's localized, personal love has completely overshadowed his supreme social and martial duty.
            He is desperately fleeing from his harsh responsibility of delivering justice and taking refuge in a false, highly emotional form of renunciation.
        """.trimIndent()
    ),
    Shloka(
        id = 37,
        sanskrit = """
            तस्मान्नार्हा वयं हन्तुं धार्तराष्ट्रान्स्वबान्धवान् |
            स्वजनं हि कथं हत्वा सुखिनः स्याम माधव || ३७ ||
        """.trimIndent(),
        hindi = """
            इसलिए हे माधव! अपने ही बांधवों (सगे-संबंधियों), धृतराष्ट्र के पुत्रों को मारना हमारे लिए किसी भी प्रकार से उचित नहीं है।
            क्योंकि अपने ही कुटुंबियों और स्वजनों (स्वजनं) को मारकर हम कैसे सुखी हो सकते हैं?
            अर्जुन अपने तर्क को अंतिम रूप देते हुए यह निष्कर्ष निकालते हैं कि कौरवों का वध करना हर दृष्टिकोण से अनुचित और अमंगलकारी है।
            वे श्रीकृष्ण को 'माधव' (लक्ष्मी के पति या सौभाग्य के स्वामी) कहकर पुकारते हैं, जिसका अर्थ है कि सौभाग्य की प्राप्ति अपनों को मारकर नहीं हो सकती।
            अर्जुन का यह प्रश्न कि "हम अपनों को मारकर कैसे सुखी हो सकते हैं?" हर उस इंसान का प्रश्न है जो भौतिक संबंधों को ही जीवन का अंतिम सत्य मानता है।
            वे यह नहीं समझ पा रहे हैं कि सुख शरीर या परिवार से नहीं, बल्कि आत्मा और धर्म के पालन से उत्पन्न होता है।
            जब कोई सर्जन (Surgeon) शरीर के सड़े हुए अंग को काटता है, तो वह उसे सुख देने के लिए नहीं, बल्कि पूरे शरीर को बचाने के लिए करता है।
            उसी प्रकार, एक क्षत्रिय का कर्तव्य समाज रूपी शरीर से दुर्योधन रूपी कैंसर को काटकर निकालना है, चाहे वह कैंसर उनके अपने ही परिवार का क्यों न हो।
            लेकिन अर्जुन का मन इस समय पूरी तरह से 'स्वजन' (मेरे लोग) के संकीर्ण दायरे में कैद हो चुका है।
            उनका यह अज्ञान ही भगवद्गीता के उस दिव्य उपदेश की नींव तैयार कर रहा है जो सारे सांसारिक बंधनों को काट देगा।
        """.trimIndent(),
        english = """
            Therefore, O Madhava! It is completely improper and unfitting for us to kill the sons of Dhritarashtra, who are our own kinsmen.
            For how can we possibly be happy after slaughtering our own family members and relatives (Swajanam)?
            Arjuna finalizes his argument by concluding that slaying the Kauravas is entirely unjustifiable and inauspicious from absolutely every angle.
            He addresses Sri Krishna as 'Madhava' (the husband of the Goddess of Fortune), implying that true fortune and happiness cannot be achieved by massacring one's own relatives.
            Arjuna's burning question, "How can we be happy by killing our own people?" is the universal question of every human being who considers physical relationships as the ultimate truth of life.
            He fails to understand that true, eternal happiness does not stem from the physical body or family, but from the soul and the strict execution of righteous duty (dharma).
            When a surgeon amputates a rotting, infected limb, he doesn't do it to inflict pain, but to save the entire remaining body from death.
            Similarly, a Kshatriya's absolute duty is to surgically remove the cancer named Duryodhana from the body of society, even if that cancer belongs to his own family.
            But Arjuna's mind is currently completely imprisoned within the narrow, suffocating boundaries of 'Swajana' (my people).
            His profound ignorance is exactly what is laying the foundation for the divine discourse of the Bhagavad Gita, which will shatter all worldly illusions.
        """.trimIndent()
    ),
    Shloka(
        id = 38,
        sanskrit = """
            यद्यप्येते न पश्यन्ति लोभोपहतचेतसः |
            कुलक्षयकृतं दोषं मित्रद्रोहे च पातकम् || ३८ ||
        """.trimIndent(),
        hindi = """
            यद्यपि लोभ (लालच) से जिनका चित्त (विवेक) पूरी तरह से भ्रष्ट हो चुका है, ऐसे ये कौरव लोग...
            कुल का नाश करने से उत्पन्न होने वाले भयंकर दोष को और मित्रों के साथ द्रोह (धोखा) करने से होने वाले महापाप को बिल्कुल नहीं देख पा रहे हैं।
            अर्जुन यहाँ यह स्वीकार करते हैं कि कौरव पूरी तरह से अंधे हो चुके हैं, लेकिन उनका अंधापन शारीरिक नहीं, बल्कि लालच (लोभ) से उत्पन्न हुआ मानसिक अंधापन है।
            राज्य और सत्ता के भयंकर लालच ने दुर्योधन और उसके भाइयों की सोचने-समझने की क्षमता ('चेतसः') को पूरी तरह से नष्ट कर दिया है।
            इसी लालच के कारण वे यह नहीं देख पा रहे हैं कि इस युद्ध का परिणाम उनके पूरे महान कुरुवंश का समूल नाश ('कुलक्षय') होगा।
            वे अपने बचपन के मित्रों (पांडवों) के साथ विश्वासघात ('मित्रद्रोह') करने में भी कोई पाप या बुराई नहीं देख रहे हैं।
            अर्जुन यह कह रहे हैं कि चूँकि कौरवों की बुद्धि लालच के कारण मर चुकी है, इसलिए वे इस महापाप को करने के लिए तैयार हैं।
            लेकिन अर्जुन का सवाल यह है कि यदि एक अंधा व्यक्ति कुएं में गिर रहा है, तो क्या आँखें वाले व्यक्ति को भी उसके पीछे कुएं में कूद जाना चाहिए?
            अर्जुन खुद को समझदार मान रहे हैं और सोच रहे हैं कि उन्हें इस मूर्खतापूर्ण विनाशकारी कृत्य से खुद को पीछे खींच लेना चाहिए।
            यह तर्क बहुत ही बुद्धिमानी भरा लगता है, लेकिन यह अर्जुन के क्षत्रिय धर्म से पीछे हटने का एक और बहुत बड़ा बहाना है।
        """.trimIndent(),
        english = """
            Even though these Kauravas, whose minds and consciousness have been completely corrupted and overpowered by extreme greed...
            cannot see the terrible fault in destroying their own dynasty, nor do they see the massive sin in betraying their friends.
            Arjuna readily admits here that the Kauravas have become completely blind, but their blindness is not physical; it is a mental blindness born entirely of overwhelming greed (Lobha).
            The terrifying lust for the kingdom and power has completely destroyed the reasoning capacity and conscience ('Chetasah') of Duryodhana and his brothers.
            Because of this intense greed, they are completely unable to foresee that the direct consequence of this war will be the total annihilation of their great Kuru dynasty ('Kulakshaya').
            They also do not see any sin or evil in committing treacherous betrayal ('Mitra-droha') against their own childhood friends, the Pandavas.
            Arjuna argues that since the Kauravas' intelligence has been murdered by greed, they are foolishly ready to commit this massive sin.
            But Arjuna's core question is: if a blind man is foolishly falling into a well, should a man with perfect vision also jump into the well after him?
            Arjuna considers himself wise and is contemplating that he should completely withdraw himself from this foolish and devastatingly destructive act.
            This logic sounds highly intelligent and moral, but it is yet another massive excuse for Arjuna to retreat from his sacred Kshatriya duty.
        """.trimIndent()
    ),
    Shloka(
        id = 39,
        sanskrit = """
            कथं न ज्ञेयमस्माभिः पापादस्मान्निवर्तितुम् |
            कुलक्षयकृतं दोषं प्रपश्यद्भिर्जनार्दन || ३९ ||
        """.trimIndent(),
        hindi = """
            तो फिर हे जनार्दन (श्रीकृष्ण)! कुल के नाश से उत्पन्न होने वाले इस भयंकर दोष (पाप) को स्पष्ट रूप से देखने और जानने वाले हम लोगों को...
            इस महापाप से पीछे हटने (निवृत्त होने) का विचार क्यों नहीं करना चाहिए?
            अर्जुन का यह तर्क समाजशास्त्र और नैतिकता के दृष्टिकोण से बहुत ही गहरा और विचारणीय है।
            वे कहते हैं कि कौरव तो अज्ञानी हैं और सत्ता के लालच में अंधे हो चुके हैं, इसलिए वे विनाश के इस रास्ते पर चल पड़े हैं।
            लेकिन हम (पांडव) तो ज्ञानी हैं! हम तो स्पष्ट रूप से देख सकते हैं कि इस युद्ध का परिणाम पूरे परिवार और समाज का भयंकर विनाश होगा।
            अर्जुन पूछते हैं कि ज्ञान का वास्तविक अर्थ क्या है? क्या ज्ञान का अर्थ यह नहीं है कि पाप को देखकर उससे तुरंत पीछे हट जाया जाए?
            वे तर्क देते हैं कि यदि हम सब कुछ जानते हुए भी युद्ध करेंगे, तो हमारा पाप अज्ञानी कौरवों के पाप से कहीं अधिक बड़ा और अक्षम्य होगा।
            अर्जुन का यह विचार ऊपरी तौर पर बहुत ही पवित्र और ज्ञान से भरा हुआ लगता है, लेकिन इसमें एक बहुत बड़ी और मूलभूत कमी है।
            वे 'अहिंसा' को ही परम धर्म मान बैठे हैं, जबकि वास्तव में परम धर्म 'न्याय' की स्थापना करना है, भले ही उसके लिए हिंसा करनी पड़े।
            भगवान श्रीकृष्ण आगे चलकर अर्जुन के इसी 'अहंकारी ज्ञान' और 'झूठी नैतिकता' को अपने दिव्य उपदेश से पूरी तरह नष्ट करेंगे।
        """.trimIndent(),
        english = """
            Then why, O Janardana (Krishna), should we—who can clearly see and fully understand the terrible crime in destroying a dynasty—
            not consider completely withdrawing and turning away from such a massive and horrific sin?
            Arjuna's argument here is extremely profound and thought-provoking from the perspectives of sociology and basic human morality.
            He states that the Kauravas are deeply ignorant and entirely blinded by the lust for power, which is why they have embarked on this path of destruction.
            But we (the Pandavas) are knowledgeable and wise! We can clearly and perfectly foresee that the result of this war will be the horrific destruction of the entire family and society.
            Arjuna asks, what is the actual purpose of knowledge? Doesn't true knowledge mean that upon recognizing a sin, one should immediately step back from it?
            He argues that if we fight despite knowing all the catastrophic consequences, our sin will be infinitely greater and far more unforgivable than that of the ignorant Kauravas.
            This thought of Arjuna appears extremely pure, deeply moral, and full of wisdom on the surface, but it contains a massive, fundamental flaw.
            He has wrongly assumed that 'non-violence' (Ahimsa) is the absolute highest duty, whereas in reality, the supreme duty is to establish 'justice', even if it requires violent force.
            Lord Sri Krishna will later completely annihilate this 'egotistical knowledge' and 'false morality' of Arjuna through His divine, transcendental discourse.
        """.trimIndent()
    ),
    Shloka(
        id = 40,
        sanskrit = """
            कुलक्षये प्रणश्यन्ति कुलधर्माः सनातनाः |
            धर्मे नष्टे कुलं कृत्स्नमधर्मोऽभिभवत्युत || ४० ||
        """.trimIndent(),
        hindi = """
            कुल (खानदान) का भयंकर नाश होने पर उस कुल के जो सनातन (प्राचीन काल से चले आ रहे) धर्म और परंपराएं हैं, वे पूरी तरह नष्ट हो जाती हैं।
            और कुल के उन पवित्र धर्मों का नाश हो जाने पर, बचे हुए उस संपूर्ण कुल को भी अधर्म पूरी तरह से दबा लेता है (घेर लेता है)।
            यहाँ से अर्जुन युद्ध के भयंकर सामाजिक और दूरगामी परिणामों का एक बहुत ही सटीक समाजशास्त्रीय (Sociological) विश्लेषण प्रस्तुत करते हैं।
            वे कहते हैं कि किसी भी युद्ध में सबसे पहले घर के बड़े-बुजुर्ग, अनुभवी और चरित्रवान पुरुष मारे जाते हैं।
            किसी भी परिवार या समाज में धर्म, संस्कार, पूजा-पाठ और पवित्र परंपराओं (सनातन कुलधर्म) को एक पीढ़ी से दूसरी पीढ़ी तक यही बड़े-बुजुर्ग ही तो पहुंचाते हैं।
            जब ये ज्ञान देने वाले बड़े लोग युद्ध में मारे जाएंगे, तो परिवार में केवल अज्ञानी बच्चे और असहाय स्त्रियां ही बचेंगी।
            मार्गदर्शन के अभाव में, सदियों से चली आ रही वह पवित्र पारिवारिक परंपरा और धर्म का वह ढांचा हमेशा के लिए टूट जाएगा।
            जब परिवार से धर्म विदा हो जाता है, तो वहाँ एक भयानक वैक्यूम (खालीपन) पैदा होता है, जिसे 'अधर्म' (पाप, भ्रष्टाचार और अनैतिकता) तुरंत भर देता है।
            अर्जुन की यह चिंता बिल्कुल यथार्थ है कि युद्ध केवल वर्तमान की पीढ़ियों को नहीं मारता, बल्कि वह भविष्य की पीढ़ियों के चरित्र को भी मार देता है।
            यह एक अत्यंत सत्य तर्क है, परंतु अर्जुन इसका प्रयोग अपने व्यक्तिगत कर्तव्य (दुष्टों को सजा देने) से भागने के लिए कर रहे हैं।
        """.trimIndent(),
        english = """
            Upon the massive destruction of a dynasty, the eternal (Sanatana) traditions, piety, and religious principles of that family are completely destroyed.
            And when these sacred religious principles are ruined, the entire remaining family is rapidly and completely overwhelmed by irreligion (adharma).
            From here onwards, Arjuna presents a highly accurate and brilliant sociological analysis of the terrifying, long-term consequences of any massive war.
            He points out that in any great war, the elders, the experienced, and the men of high moral character are the very first ones to be slaughtered.
            In any family or society, it is these exact elders who pass down dharma, cultural values, rituals, and sacred traditions (Sanatana Kuladharma) from one generation to the next.
            When these knowledgeable elders are killed in battle, only ignorant children and helpless women will remain in the family without proper protection.
            In the complete absence of wise guidance, the sacred family traditions and the entire framework of dharma that has existed for centuries will break down forever.
            When dharma departs from a family, a terrifying spiritual vacuum is created, which is immediately filled and overwhelmed by 'adharma' (sin, corruption, and immorality).
            Arjuna's deep anxiety is absolutely realistic: war doesn't just kill the present generations; it ruthlessly murders the moral character of all future generations.
            This is an undeniably true argument, but Arjuna is misusing this ultimate sociological truth as a grand excuse to escape his immediate personal duty of punishing the wicked.
        """.trimIndent()
    ),
    Shloka(
        id = 41,
        sanskrit = """
            अधर्माभिभवात्कृष्ण प्रदुष्यन्ति कुलस्त्रियः |
            स्त्रीषु दुष्टासु वार्ष्णेय जायते वर्णसङ्करः || ४१ ||
        """.trimIndent(),
        hindi = """
            हे कृष्ण! अधर्म के बहुत अधिक बढ़ जाने के कारण कुल की जो पवित्र स्त्रियां हैं, वे अत्यंत दूषित (भ्रष्ट) हो जाती हैं।
            और हे वार्ष्णेय (वृष्णि वंश में उत्पन्न होने वाले श्रीकृष्ण)! स्त्रियों के भ्रष्ट हो जाने पर अवांछित और संकर संतानें (वर्णसंकर) उत्पन्न होती हैं।
            अर्जुन अपने सामाजिक पतन के तर्क को और आगे बढ़ाते हुए समाज के सबसे संवेदनशील विषय—स्त्रियों की सुरक्षा और पवित्रता—पर बात करते हैं।
            प्राचीन काल में परिवार के पुरुष स्त्रियों और बच्चों के रक्षक माने जाते थे। युद्ध में जब अधिकांश पुरुष मारे जाते हैं, तो समाज का संतुलन बुरी तरह बिगड़ जाता है।
            सुरक्षा और मार्गदर्शन के अभाव में, और अधर्म के हावी होने के कारण, समाज में अनैतिकता और शोषण बहुत तेजी से फैलने लगता है।
            ऐसी स्थिति में कुल की पवित्र और सदाचारी स्त्रियों का शोषण होता है या वे स्वयं मार्ग भटक जाती हैं, जिससे उनका पतन (प्रदुष्यन्ति) होता है।
            जब स्त्रियों का पतन होता है और पारिवारिक मर्यादाएं टूटती हैं, तो बिना विवाह या गलत संबंधों से अवांछित संतानें पैदा होती हैं, जिन्हें 'वर्णसंकर' कहा जाता है।
            वर्णसंकर उन संतानों को कहते हैं जिन्हें अच्छे संस्कार नहीं मिलते, जो परंपराओं को नहीं मानते, और जो समाज में केवल अराजकता फैलाते हैं।
            अर्जुन श्रीकृष्ण को 'वार्ष्णेय' कहकर संबोधित कर रहे हैं, मानो वे कह रहे हों कि "आप स्वयं एक महान वृष्णि वंश के हैं, क्या आप चाहेंगे कि हमारा कुरुवंश इस तरह वर्णसंकर होकर नष्ट हो जाए?"
            अर्जुन की दूरदृष्टि यहाँ एकदम सटीक है कि युद्ध अंततः समाज की सबसे मजबूत इकाई (परिवार) को कैसे भीतर से खोखला कर देता है।
        """.trimIndent(),
        english = """
            O Krishna! When irreligion (adharma) becomes deeply prominent in the family, the chaste and pure women of the family become highly polluted and degraded.
            And O Varshneya (Descendant of Vrishni)! When the womanhood is thus corrupted, it gives rise to highly unwanted and uncultured progeny (Varna-sankara).
            Taking his argument of profound social degradation a step further, Arjuna touches upon the most sensitive topic of society—the protection and purity of women.
            In ancient times, the men of the family were considered the absolute protectors of women and children. When most men are slaughtered in war, the social balance is terribly destroyed.
            In the complete absence of physical protection and moral guidance, and with adharma dominating, immorality and severe exploitation spread very rapidly through society.
            In such a chaotic situation, the chaste and virtuous women of the family are either horribly exploited or they lose their way, leading to their degradation ('pradushyanti').
            When women are degraded and sacred family boundaries are shattered, unwanted children are born out of wedlock or illicit relations, which are termed 'Varna-sankara'.
            Varna-sankara refers to those offspring who receive absolutely no moral values, reject all sacred traditions, and spread nothing but chaos and anarchy in society.
            Arjuna addresses Sri Krishna as 'Varshneya', as if saying, "You Yourself belong to the great Vrishni dynasty; would You want our Kuru dynasty to be destroyed by becoming Varna-sankara?"
            Arjuna's farsightedness here is incredibly accurate regarding how war ultimately hollows out the strongest unit of society (the family) from the deep inside.
        """.trimIndent()
    ),
    Shloka(
        id = 42,
        sanskrit = """
            सङ्करो नरकायैव कुलघ्नानां कुलस्य च |
            पतन्ति पितरो ह्येषां लुप्तपिण्डोदकक्रियाः || ४२ ||
        """.trimIndent(),
        hindi = """
            यह वर्णसंकर (अवांछित संतान) उस कुल का नाश करने वालों (कुलघ्नानां) को और उस पूरे कुल को निश्चित रूप से नरक में ले जाने वाला ही होता है।
            क्योंकि श्राद्ध, पिण्डदान और तर्पण (जल) देने की जो पवित्र क्रियाएं हैं, उनके नष्ट हो जाने से इन लोगों के पूर्वज (पितर) भी अपने स्वर्ग के स्थान से नीचे गिर जाते हैं।
            अर्जुन अब युद्ध के सामाजिक परिणामों से आगे बढ़कर उसके अत्यंत भयंकर आध्यात्मिक और पारलौकिक परिणामों का वर्णन कर रहे हैं।
            सनातन धर्म की मान्यता के अनुसार, किसी भी मनुष्य का अपने पूर्वजों (पितरों) के प्रति एक गहरा ऋण और कर्तव्य होता है, जिसे श्राद्ध और पिण्डदान के माध्यम से चुकाया जाता है।
            जब परिवार में वर्णसंकर (संस्कारहीन) संतानें पैदा होती हैं, तो वे न तो धर्म को जानती हैं और न ही उन्हें श्राद्ध कर्म करने में कोई रुचि या विश्वास होता है।
            परिणामस्वरूप, पूर्वजों को दिया जाने वाला पवित्र पिण्ड (भोजन) और उदक (जल) पूरी तरह से बंद हो जाता है ('लुप्तपिण्डोदकक्रियाः')।
            पिण्ड और जल न मिलने के कारण पितर भूखे-प्यासे रह जाते हैं और उन्हें स्वर्ग या उच्च लोकों से गिरकर नरक की यातनाएं भोगनी पड़ती हैं।
            अर्जुन कहते हैं कि जो लोग (यानी हम पांडव और कौरव) इस युद्ध के द्वारा कुल का नाश करेंगे, वे स्वयं तो नरक जाएंगे ही, साथ ही वे अपने बेचारे पूर्वजों को भी नरक में धकेल देंगे।
            यह विचार अर्जुन के मन में एक भयानक अपराधबोध (Guilt) पैदा कर रहा है कि वे अपनी महत्वाकांक्षा के लिए अपने परलोक सिधार चुके पूर्वजों को कष्ट देने वाले हैं।
            इस श्लोक में अर्जुन का पारिवारिक प्रेम और धार्मिक कर्मकांडों के प्रति उनका डर पूरी तरह से हावी हो गया है।
        """.trimIndent(),
        english = """
            This unwanted progeny (Varna-sankara) absolutely ensures hellish life both for those who destroy the family and for the rest of the family itself.
            Because, being entirely deprived of the sacred offerings of food (Pinda) and water (Udaka), the ancestors (Pitaras) of such corrupt families fall down from their heavenly positions.
            Arjuna now steps beyond the massive social consequences of war and begins describing its extremely terrifying spiritual and otherworldly consequences.
            According to strict Sanatana Dharma beliefs, every human being has a deep spiritual debt and duty towards their ancestors (Pitaras), repaid through the rituals of Shraddha and offering Pinda.
            When Varna-sankara (uncultured and unwanted) children are born in a family, they neither know dharma nor have any faith or interest in performing these sacred ancestral rituals.
            As a direct result, the sacred offerings of Pinda (food) and Udaka (water) given to the ancestors are completely and permanently stopped ('Lupta-pindodaka-kriyah').
            Deprived of this essential food and water, the ancestors suffer terrible hunger and thirst, eventually falling from heaven or higher planetary systems to suffer the brutal torments of hell.
            Arjuna claims that those (meaning the Pandavas and Kauravas) who destroy the dynasty through this war will not only go to hell themselves, but will also forcefully drag their poor ancestors into hell.
            This terrifying thought is generating a massive, unbearable sense of guilt within Arjuna's mind that he is about to torture his departed ancestors purely for his own worldly ambition.
            In this specific verse, Arjuna's localized familial love and his deep fear of religious rituals have completely overpowered his rational mind.
        """.trimIndent()
    ),
    Shloka(
        id = 43,
        sanskrit = """
            दोषैरेतैः कुलघ्नानां वर्णसङ्करकारकैः |
            उत्साद्यन्ते जातिधर्माः कुलधर्माश्च शाश्वताः || ४३ ||
        """.trimIndent(),
        hindi = """
            कुल का नाश करने वाले इन लोगों के द्वारा उत्पन्न किए गए वर्णसंकर (अवांछित संतानों) को पैदा करने वाले इन भयानक दोषों (पापों) के कारण...
            सदियों से चले आ रहे शाश्वत (हमेशा रहने वाले) जाति-धर्म और कुल-धर्म पूरी तरह से छिन्न-भिन्न (नष्ट) हो जाते हैं।
            अर्जुन अपने तर्कों की पूरी श्रृंखला को यहाँ समेटते हुए समाज के अंतिम पतन का चित्र खींच रहे हैं।
            वे कहते हैं कि युद्ध केवल कुछ व्यक्तियों को नहीं मारता, बल्कि यह पूरी की पूरी संस्कृति और सामाजिक ताने-बाने को जड़ से उखाड़ फेंकता है।
            'जाति-धर्म' का अर्थ है पूरे समाज या समुदाय के वे विशेष नियम जो समाज को एकजुट और व्यवस्थित रखते हैं।
            'कुल-धर्म' का अर्थ है किसी एक विशेष परिवार की वे अत्यंत पवित्र परंपराएं जो उन्हें पीढ़ियों से श्रेष्ठ बनाए रखती हैं।
            जब परिवार के रक्षक पुरुष मारे जाते हैं और समाज में बिना संस्कारों वाली वर्णसंकर संतानें भर जाती हैं, तो कोई भी इन पुराने और पवित्र नियमों को मानने वाला नहीं बचता।
            जिस समाज में न तो कुल का कोई नियम बचता है और न ही जाति की कोई मर्यादा, वह समाज पशुओं के समान हो जाता है और अंततः पूरी तरह से नष्ट हो जाता है।
            अर्जुन बहुत गहराई से यह महसूस कर रहे हैं कि यदि वे राज्य पाने के लिए लड़े, तो वे अनजाने में ही पूरी सामाजिक व्यवस्था (Social Order) के पतन का कारण बन जाएंगे।
            यह एक अत्यंत बुद्धिमानी भरा और सार्वभौमिक (Universal) सत्य है, लेकिन यहाँ अर्जुन इसे अपने व्यक्तिगत डर को छिपाने के एक महान दार्शनिक आवरण के रूप में प्रयोग कर रहे हैं।
        """.trimIndent(),
        english = """
            Due to these terrifying faults and massive sins of the destroyers of the family, which directly cause the birth of unwanted children (Varna-sankara)...
            all the eternal (Shashvata) and age-old traditional projects, community duties (Jati-dharma), and family welfare activities (Kula-dharma) are completely devastated and ruined.
            Arjuna is wrapping up his entire chain of profound logical arguments here by painting a horrifying picture of ultimate societal collapse.
            He emphatically states that a great war doesn't merely kill a few individuals; it violently uproots and completely destroys the entire culture and social fabric from its very foundation.
            'Jati-dharma' refers to the specific, sacred rules of the entire community or society that keep it united, functioning, and highly organized.
            'Kula-dharma' refers to the extremely sacred and localized traditions of a specific family that have kept them noble and righteous for countless generations.
            When the male protectors are slaughtered and society is flooded with uncultured Varna-sankara offspring, absolutely no one is left to respect or follow these ancient, sacred rules.
            A society where neither family traditions nor community boundaries survive quickly degrades to the level of animals and is ultimately destroyed entirely.
            Arjuna is feeling very deeply that if he fights merely to gain a kingdom, he will unknowingly become the primary cause for the total collapse of the entire Social Order.
            This is an exceptionally intelligent and universal truth, but right here, Arjuna is using it merely as a grand philosophical cover to hide his deep personal fear and attachment.
        """.trimIndent()
    ),
    Shloka(
        id = 44,
        sanskrit = """
            उत्सन्नकुलधर्माणां मनुष्याणां जनार्दन |
            नरके नियतं वासो भवतीत्यनुशुश्रुम || ४४ ||
        """.trimIndent(),
        hindi = """
            हे जनार्दन (श्रीकृष्ण)! जिनके कुल-धर्म पूरी तरह से नष्ट हो गए हैं, ऐसे मनुष्यों का...
            अनिश्चित काल (नियतं) के लिए नरक में ही वास होता है, ऐसा हमने गुरुजनों और शास्त्रों से सुना है।
            अर्जुन अपने सारे तर्कों का अंतिम निष्कर्ष निकालते हुए एक बहुत ही भयानक बात कह रहे हैं।
            वे कहते हैं कि धर्म-शास्त्रों और बड़े-बुजुर्गों की पुरानी परंपराओं से ('अनुशुश्रुम' - हमने ऐसा सुना है) उन्होंने यह सीखा है कि कुलधर्म का नाश करने वालों की क्या गति होती है।
            जिन लोगों के कारण परिवार की पवित्र परंपराएं और संस्कार मिट जाते हैं, उनके लिए भगवान भी कोई क्षमा नहीं रखते।
            ऐसे महापापी मनुष्यों को कुछ दिनों या सालों के लिए नहीं, बल्कि हमेशा के लिए ('नियतं') भयानक नरक की यातनाएं झेलनी पड़ती हैं।
            अर्जुन के मन में नरक का यह गहरा डर बैठ गया है कि यदि उन्होंने बाण चलाया तो वे सीधे नरक के सबसे गहरे गर्त में गिरेंगे।
            यह ध्यान देने योग्य है कि अर्जुन ने यह सब "सुना है" ('अनुशुश्रुम'), यह उनका अपना साक्षात् ज्ञान या अनुभव नहीं है।
            उन्होंने शास्त्रों के केवल उन हिस्सों को याद रखा है जो उनके वर्तमान डर का समर्थन करते हैं, लेकिन वे क्षत्रिय धर्म के उस शास्त्र को भूल गए हैं जो अन्याय के खिलाफ लड़ना सिखाता है।
            यह श्लोक दिखाता है कि जब इंसान भावुक होता है, तो वह केवल वही सुनना और याद रखना चाहता है जो उसकी अपनी कमजोरियों को सही साबित करे।
        """.trimIndent(),
        english = """
            O Janardana (Krishna)! I have heard from the great authorities and scriptures that those human beings whose family traditions (Kula-dharma) are utterly destroyed...
            are definitely forced to dwell in hell for an indefinite, eternal period of time.
            Drawing the final, terrifying conclusion from all his previous arguments, Arjuna states a deeply horrific consequence.
            He says that from the religious scriptures and the ancient traditions of wise elders ('anushushrum' - I have heard thus), he has learned exactly what happens to those who destroy family dharma.
            God Himself holds absolutely no forgiveness for those individuals who cause the complete obliteration of a family's sacred traditions and cultural values.
            Such massive sinners do not just suffer for a few days or years, but they are condemned to endure the horrific torments of hell permanently ('niyatam').
            A paralyzing, deep-rooted fear of hell has settled into Arjuna's mind; he genuinely believes that if he shoots a single arrow, he will fall straight into the deepest pit of hell.
            It is highly noteworthy that Arjuna says he has only "heard" this ('anushushrum'); it is not his own direct, realized spiritual knowledge or experience.
            He has conveniently remembered only those specific parts of the scriptures that fully support his current fear, entirely forgetting the Kshatriya scriptures that mandate fighting against injustice.
            This verse clearly shows that when a human is highly emotional, they selectively listen to and remember only what justifies their own internal weaknesses.
        """.trimIndent()
    ),
    Shloka(
        id = 45,
        sanskrit = """
            अहो बत महत्पापं कर्तुं व्यवसिता वयम् |
            यद्राज्यसुखलोभेन हन्तुं स्वजनमुद्यताः || ४५ ||
        """.trimIndent(),
        hindi = """
            अहो! कितने बड़े खेद और दुःख की बात है कि हम लोग यह कैसा महापाप करने के लिए पूरी तरह से तैयार (निश्चय) हो गए हैं!
            कि हम केवल राज्य और राजसुख के लालच (लोभ) में आकर अपने ही सगे-संबंधियों और परिवार वालों (स्वजन) को मारने के लिए तत्पर हो उठे हैं।
            अर्जुन अब गहरे पश्चाताप और आत्मग्लानि (Self-guilt) की आग में जल रहे हैं। 'अहो बत' का अर्थ है आश्चर्य और बहुत गहरा दुःख।
            वे स्वयं को और अपने भाइयों को धिक्कार रहे हैं कि उन्होंने युद्ध करने का यह विचार ही अपने मन में क्यों आने दिया।
            अर्जुन अपनी ही न्यायपूर्ण लड़ाई को अब केवल एक 'लालच' (लोभ) मान रहे हैं। वे कह रहे हैं कि हम केवल एक राज्य के टुकड़े और थोड़े से सुख के लिए कितने अंधे हो गए हैं।
            उनका यह मानना है कि कौरव तो पापी हैं ही, लेकिन अगर हम पांडव भी राज्य के लिए अपनों का खून बहाएंगे, तो हम उनसे भी बड़े पापी कहलाएंगे।
            अर्जुन पूरी तरह से भूल चुके हैं कि यह युद्ध राज्य के लोभ के लिए नहीं, बल्कि दुनिया से एक अत्याचारी राजा (दुर्योधन) को हटाने और धर्म को बचाने के लिए हो रहा है।
            मोह इंसान को अंधा कर देता है; अर्जुन जो कल तक धर्म के रक्षक थे, आज मोह के कारण खुद को एक लालची और स्वार्थी अपराधी मान बैठे हैं।
            यह श्लोक मानवीय भावनाओं के उस खतरनाक भंवर को दिखाता है जहाँ इंसान अपने ही सही और पवित्र निर्णयों पर संदेह करने लगता है।
        """.trimIndent(),
        english = """
            Alas! What a massive tragedy and matter of great sorrow it is that we have firmly resolved and prepared ourselves to commit such a tremendously great sin!
            Driven merely by the greed (lobha) for royal happiness and a kingdom, we have become so fully intent on killing our very own kinsmen and family (Swajana).
            Arjuna is now violently burning in the intense fire of deep remorse and overwhelming self-guilt. 'Aho bata' expresses both massive astonishment and profound sorrow.
            He is harshly cursing himself and his brothers, wondering how they could have ever allowed the very thought of this war to enter their minds in the first place.
            Arjuna is now wrongly labeling his own perfectly just and righteous fight as nothing but mere 'greed' (lobha). He feels they have become totally blind just for a piece of land and temporary happiness.
            His logic is that the Kauravas are already sinners, but if we Pandavas also shed the blood of our own family for a kingdom, we will be called even greater sinners than them.
            Arjuna has completely and totally forgotten that this war is not being fought out of greed for a kingdom, but to remove a cruel tyrant (Duryodhana) from the world and save dharma.
            Worldly attachment (Moha) makes a person completely blind; Arjuna, who until yesterday was the supreme protector of dharma, today considers himself a greedy, selfish criminal due to attachment.
            This verse powerfully displays that dangerous psychological whirlpool of human emotions where a person begins to deeply doubt their own correct and righteous decisions.
        """.trimIndent()
    ),
    Shloka(
        id = 46,
        sanskrit = """
            यदि मामप्रतीकारमशस्त्रं शस्त्रपाणयः |
            धार्तराष्ट्रा रणे हन्युस्तन्मे क्षेमतरं भवेत् || ४६ ||
        """.trimIndent(),
        hindi = """
            यदि मुझ शस्त्ररहित (निहत्थे) और सामने से किसी भी प्रकार का कोई विरोध या वार न करने वाले को...
            हाथों में शस्त्र लिए हुए ये धृतराष्ट्र के पुत्र (कौरव) इस युद्धभूमि में मार भी डालें, तो वह मरना भी मेरे लिए कहीं अधिक कल्याणकारी (क्षेमतरं) होगा।
            अर्जुन के विषाद और अवसाद (Depression) की यह अंतिम और सबसे भयंकर चरम सीमा है। वे पूरी तरह से आत्महत्या (Suicidal) जैसी मानसिकता में आ गए हैं।
            दुनिया के सबसे महान क्षत्रिय योद्धा, जिनके पास गांडीव है और जिनके साथ स्वयं भगवान हैं, आज कह रहे हैं कि मैं अपने हथियार डाल दूँगा।
            वे कहते हैं कि यदि मैं बिना शस्त्र उठाए शांति से खड़ा रहूँ और दुर्योधन व उसके भाई मुझे निर्दयता से काट भी डालें, तो वह मौत मुझे मंजूर है।
            अर्जुन का मानना है कि अपनों को मारकर खून से सने हुए सिंहासन पर बैठने और पाप की आग में जलने से तो कहीं अच्छा है कि मैं चुपचाप मर जाऊं।
            उन्हें लगता है कि ऐसी शहादत से कम से कम उनका परिवार तो बच जाएगा और उन्हें नरक का भागी नहीं बनना पड़ेगा।
            यह दुनिया का सबसे बड़ा मोह है जो अहिंसा का मुखौटा पहनकर सामने आ रहा है। अन्याय को सहना और अत्याचारी को मजबूत करना सबसे बड़ी कायरता है।
            अर्जुन का यह वाक्य क्षत्रिय धर्म का सबसे बड़ा अपमान है, जिसे सुनकर भगवान श्रीकृष्ण आगे चलकर उन्हें बहुत जोर से डांटने वाले हैं।
        """.trimIndent(),
        english = """
            Even if these heavily armed sons of Dhritarashtra (Kauravas) were to relentlessly attack and kill me on this battlefield...
            while I remain completely unarmed and utterly unresisting, I would still consider that death to be far better and much more auspicious (Kshemataram) for me.
            This is the absolute final, terrifying, and ultimate extreme of Arjuna's severe depression (Vishada). He has completely slipped into a dangerously suicidal mindset.
            The absolute greatest Kshatriya warrior in the world, who wields the Gandiva and has the Supreme Lord beside him, is declaring today that he will drop his weapons.
            He passionately states that if he stands completely peacefully without raising a single weapon, and Duryodhana and his brothers mercilessly hack him to pieces, he fully accepts that brutal death.
            Arjuna truly believes that dying silently is infinitely better than sitting on a blood-stained throne after massacring his own family and burning in the eternal fire of sin.
            He feels that through such an unarmed martyrdom, his beloved family will at least survive, and he will completely escape the horrific punishment of hell.
            This is the world's most massive attachment (moha) presenting itself while wearing a highly deceptive mask of non-violence (Ahimsa). Tolerating massive injustice and empowering tyrants is the greatest cowardice.
            This single sentence of Arjuna is the absolute highest insult to the sacred duty of a Kshatriya, hearing which Lord Sri Krishna is going to scold him very severely in the next chapter.
        """.trimIndent()
    ),
    Shloka(
        id = 47,
        sanskrit = """
            सञ्जय उवाच |
            एवमुक्त्वार्जुनः सङ्ख्ये रथोपस्थ उपाविशत् |
            विसृज्य सशरं चापं शोकसंविग्नमानसः || ४७ ||
        """.trimIndent(),
        hindi = """
            संजय ने धृतराष्ट्र से कहा: हे राजन्! युद्धभूमि (कुरुक्षेत्र) में ऐसा कहकर, अत्यंत शोक और गहरे दुःख से घबराए हुए मन वाले अर्जुन ने...
            अपने बाणों सहित उस महान गांडीव धनुष को वहीं त्याग दिया (फेंक दिया) और अपने रथ के पिछले भाग में जाकर हताश होकर बैठ गए।
            यहाँ भगवद्गीता के प्रथम अध्याय का अत्यंत ही नाटकीय और दुःखद अंत होता है। संजय धृतराष्ट्र को आँखों देखा हाल बता रहे हैं।
            अर्जुन केवल बातें ही नहीं कर रहे थे, बल्कि उन्होंने शारीरिक रूप से भी पूरी तरह से हार मान ली है।
            'विसृज्य सशरं चापं'—उन्होंने अपने तीरों सहित अपने उस अजेय धनुष (गांडीव) को रथ में ही नीचे फेंक दिया है, जो एक क्षत्रिय के लिए सबसे बड़ा पतन है।
            उनका मन 'शोकसंविग्नमानसः' है, जिसका अर्थ है कि उनका हृदय शोक, डर और मोह से पूरी तरह से उद्विग्न (विचलित और अस्थिर) हो चुका है।
            वे रथ के पिछले हिस्से में (जहाँ योद्धा नहीं बैठता) जाकर एक हताश और थके हुए व्यक्ति की तरह धम्म से बैठ गए हैं।
            यह दृश्य धृतराष्ट्र के लिए एक बहुत बड़ी खुशखबरी थी, क्योंकि सबसे महान शत्रु अर्जुन ने बिना लड़े ही हथियार डाल दिए थे।
            परंतु, अर्जुन का यह गिरना वास्तव में मनुष्य जाति के सबसे बड़े उठान का कारण बनने वाला था।
            अर्जुन का यह संपूर्ण समर्पण ही वह खालीपन (Vacuum) है जिसमें अब भगवान श्रीकृष्ण अपना सबसे महान और दिव्य ज्ञान (गीता) उड़ेलने वाले हैं।
            इस प्रकार 'अर्जुनविषादयोग' नामक श्रीमद्भगवद्गीता का प्रथम अध्याय पूर्ण होता है।
        """.trimIndent(),
        english = """
            Sanjaya said to Dhritarashtra: O King! Having spoken these words on the battlefield, Arjuna, whose mind was completely overwhelmed and highly agitated by profound grief...
            cast aside his great bow along with his arrows, and sank down heavily on the seat of his chariot, utterly defeated by despair.
            Here marks the incredibly dramatic, heartbreaking, and anti-climactic end of the very First Chapter of the Bhagavad Gita. Sanjaya is narrating the live events to the blind King.
            Arjuna was not merely expressing empty philosophical thoughts; he has now physically and completely surrendered to his mental breakdown.
            'Visrijya sasharam chapam'—he has physically thrown down his invincible bow (the Gandiva) along with his arrows into the chariot, which is the absolute greatest fall and disgrace for any Kshatriya.
            His mind is 'shoka-samvigna-manasah', which deeply means that his heart is completely agitated, disturbed, and fiercely burning with extreme grief, terror, and attachment.
            He has retreated to the back part of the chariot (where an active warrior never sits) and slumped down heavily like a completely hopeless, exhausted, and broken man.
            This scene must have been absolutely fantastic news for Dhritarashtra, because the greatest enemy, Arjuna, had just laid down his weapons without even fighting a single second.
            However, this massive fall of Arjuna was actually destined to become the cause of the greatest spiritual upliftment in the history of all mankind.
            This complete physical and mental surrender of Arjuna creates the ultimate vacuum into which Lord Sri Krishna is now going to pour His supreme, eternal, and divine knowledge (The Gita).
            Thus perfectly ends the First Chapter of the Srimad Bhagavad Gita, famously known as the 'Yoga of the Dejection of Arjuna' (Arjuna Vishada Yoga).
        """.trimIndent()
    )
)