package com.sanatangyansagar.ui.screens.veda.YajurVeda.ShuklaYajurveda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

data class ShuklaYajurVerse(
    val id: Int,
    val sanskrit: String,
    val hindiCommentary: String,
    val englishCommentary: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShuklaYajurvedaAdhyayaOneScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            shuklaYajurAdhyayaOneData
        } else {
            shuklaYajurAdhyayaOneData.filter {
                it.id.toString().contains(searchQuery) ||
                        it.sanskrit.contains(searchQuery, ignoreCase = true) ||
                        it.hindiCommentary.contains(searchQuery, ignoreCase = true) ||
                        it.englishCommentary.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color.White)) {
                CenterAlignedTopAppBar(
                    title = {
                        Text("प्रथम अध्याय - दर्शपूर्णमास", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFCC80) // Saffron/Orange tint for Yajurveda
                    )
                )
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("खोजें (मंत्र संख्या या शब्द)...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFF5F5F5),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFFFF8E1)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(filteredVerses) { verse ->
                VedaDetailCard(verse)
            }

            if (filteredVerses.isEmpty()) {
                item {
                    Text(
                        "कोई मंत्र नहीं मिला।",
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun VedaDetailCard(verse: ShuklaYajurVerse) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Verse ID
            Text(
                text = "मंत्र ${verse.id}",
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE65100), // Dark Orange to match the theme
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Sanskrit Text
            Text(
                text = verse.sanskrit,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFBF360C), // Deep Red/Orange for Sanskrit
                modifier = Modifier.padding(bottom = 12.dp)
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color(0xFFEEEEEE))

            // Hindi Commentary
            Text(
                text = "हिन्दी भावार्थ:",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = verse.hindiCommentary,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color(0xFFEEEEEE))

            // English Commentary
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = verse.englishCommentary
            )
        }
    }
}

val shuklaYajurAdhyayaOneData = listOf(
    ShuklaYajurVerse(
        id = 1,
        sanskrit = "इषे त्वोर्जे त्वा वायव स्थ देवो वः सविता प्रार्पयतु श्रेष्ठतमाय कर्मणऽ।\nआप्यायध्वमघ्न्या इन्द्राय भागं प्रजावतीरनमीवा अयक्ष्मा मा वस्तेन ईशत माघशं सो ध्रुवा अस्मिन् गोपतौ स्यात बह्वीर्यजमानस्य पशून्पाहि ॥ १ ॥",
        hindiCommentary = """
            हे पलाश की शाखा! मैं तुम्हें अन्न की प्राप्ति और जीवन की शक्ति के लिए ग्रहण करता हूँ। तुम वायु के समान गतिशील और पवित्र हो।
            सृष्टिकर्ता सविता देव तुम्हें उत्तम कर्म (यज्ञ) के लिए प्रेरित करें। हे गौओं! तुम इंद्र के भाग के रूप में दूध और घी से परिपूर्ण हो जाओ।
            तुम संतान वाली हो, रोगों से मुक्त हो और कभी न मर जाने वाली (अघ्न्या) होकर हमारे धन की वृद्धि करो।
            चोर या हिंसक प्राणी तुम पर अधिकार न कर सकें। तुम सदा इस गोशाला में स्थिर रहो और स्वामी के पशुओं की रक्षा करो।
            यह मंत्र कर्मकांड में पशुओं और अन्न की महत्ता को दर्शाता है, जहाँ प्रकृति के प्रत्येक अंश को देवत्व प्रदान किया गया है।
            यज्ञ का मुख्य उद्देश्य केवल वैयक्तिक लाभ नहीं, बल्कि समाज के पोषण और स्वास्थ्य की कामना करना है।
            परमात्मा से प्रार्थना है कि हमारी बुद्धि सदैव श्रेष्ठ कर्मों की ओर प्रवृत्त रहे और हम ईर्ष्या-द्वेष से मुक्त रहें।
            पशुधन की रक्षा और उनके प्रति अहिंसा का भाव इस मंत्र का मूल संदेश है, जो हमें जीवमात्र के प्रति दया सिखाता है।
            सविता देव की कृपा से प्राप्त प्रेरणा हमें आलस्य त्याग कर पुरुषार्थ करने की सामर्थ्य प्रदान करती है।
            हे प्रभु! हमें ऐसी शक्ति दें कि हम अपनी आध्यात्मिक और भौतिक उन्नति के साथ-साथ समाज का भी कल्याण कर सकें।
        """.trimIndent(),
        englishCommentary = """
            O branch of the Palasha tree! I accept thee for the sake of food and for the sake of vital strength and energy.
            May the Divine Savitar impel you toward the highest and most noble deeds of the sacred sacrifice.
            O Cows! May you flourish and be filled with milk for the portion of Indra, being rich in progeny and free from disease.
            May no thief or wicked predator ever have power over you; remain steadfast and secure in this stable of the master.
            This mantra emphasizes the preservation of cattle and the importance of agricultural prosperity in Vedic rituals.
            It calls upon the creative power of God to guide human actions toward the benefit of all living beings and nature.
            Protect the livestock of the sacrificer and ensure that the environment remains healthy and free from consumption by evil.
            The prayer seeks divine intervention to maintain the balance between physical resources and spiritual growth.
            By invoking Savitar, the seeker asks for the inner light that drives away the darkness of ignorance and lethargy.
            May we be blessed with the abundance of nature while remaining devoted to the path of righteousness and universal service.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 2,
        sanskrit = "वसव्यास पवित्रे स्थो वसवो वः पवित्रं पृणक्तु।\nसवितुर्वः प्रसव उत्पुनाम्यच्छिद्रेण पवित्रेण वसोः सूर्यस्य रश्मिभिः ॥ २ ॥",
        hindiCommentary = """
            तुम वसु (पवित्र करने वाले) के समान हो; यह पवित्र कुश का जोड़ा तुम्हें पूरी तरह शुद्ध और पावन कर दे।
            मैं तुम्हें सविता देव की प्रेरणा से, सूर्य की किरणों के समान निर्मल और छिद्ररहित पवित्रता से शुद्ध करता हूँ।
            यह मंत्र शुद्धि की प्रक्रिया को दर्शाता है, जहाँ भौतिक वस्तुओं को मंत्रशक्ति से आध्यात्मिक ऊर्जा में बदला जाता है।
            सूर्य की किरणें जैसे संसार के अंधकार और दोषों को नष्ट करती हैं, वैसे ही यह संस्कार हमारे जीवन को प्रकाशित करे।
            हमारी अंतरात्मा में जो भी मलिनता या विकार हैं, वे इस ईश्वरीय प्रकाश के सान्निध्य में आकर पूरी तरह भस्म हो जाएं।
            पवित्रता केवल बाहरी नहीं, बल्कि आंतरिक भावों की भी होनी चाहिए, तभी मनुष्य ईश्वरीय कृपा का वास्तविक पात्र बनता है।
            सृष्टि के कण-कण में व्याप्त दिव्य चैतन्य को पहचानना ही इस वैदिक विधि का मूल उद्देश्य और सर्वोच्च लक्ष्य है।
            बिना छिद्र वाले पवित्र के समान हमारा चरित्र भी निष्कलंक हो, ताकि हम सत्य के मार्ग पर बिना डगमगाए चल सकें।
            ईश्वर की प्रेरणा ही वह शक्ति है जो हमें सामान्य कर्मों से उठाकर दिव्य कर्मों की श्रेणी में स्थापित कर देती है।
            हे परमात्मा! हमें वह दृष्टि दें जिससे हम प्रत्येक वस्तु में आपकी व्यापकता और पवित्रता का अनुभव निरंतर कर सकें।
        """.trimIndent(),
        englishCommentary = """
            You are the vessels of wealth and purity; may the sacred strainers of the Vasus purify you completely and holy.
            By the impulse of Savitar, I purify you with a flawless filter, consistent with the radiant rays of the bright Sun.
            This mantra signifies the ritual purification of the elements used in sacrifice, making them fit for divine offering.
            Just as the sun's rays cleanse the earth of impurities, the divine word cleanses the heart of the seeker from all sins.
            It teaches us that before embarking on any noble task, one must achieve mental and physical cleanliness and focus.
            The 'flawless filter' represents a mind that is undivided and dedicated solely to the service of the Supreme Reality.
            The Vasus, as the elemental deities, symbolize the supporting structures of the universe that maintain order and sanctity.
            May our actions be as transparent and beneficial as the sunlight that nourishes the entire world without discrimination.
            The invocation of Savitar reminds us that all creative and purifying power originates from the one Divine Source.
            Grant us the wisdom to remain pure in thought, word, and deed, ensuring our lives become a continuous sacrifice to God.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 3,
        sanskrit = "सा विश्वायुः सा विश्वव्यचाः सा विश्वकर्मा।\nसम्पृच्यध्वमृतावरीरूर्मिणीर्मधुमत्तमा मन्द्रा धनस्य सातये ॥ ३ ॥",
        hindiCommentary = """
            यह जल संपूर्ण आयु देने वाला है, यह जल सर्वत्र व्याप्त है और यही संपूर्ण श्रेष्ठ कर्मों को सिद्ध करने वाला है।
            हे जल की पावन धारों! तुम सत्य से युक्त हो, तरंगों वाली हो और अत्यंत मधुरता से परिपूर्ण होकर एक साथ मिल जाओ।
            यह मंत्र जल की महिमा और उसकी जीवनदायिनी शक्ति का वर्णन करता है, जो सृष्टि के हर जीव का मूलाधार है।
            यज्ञ में जल का प्रयोग केवल शुद्धि के लिए नहीं, बल्कि धन, धान्य और ऐश्वर्य की प्राप्ति के संकल्प के साथ किया जाता है।
            जल की तरंगे हमें जीवन में निरंतर आगे बढ़ने और बाधाओं को पार करने की महान प्रेरणा देती हैं।
            हे परमात्मा! हमारे जीवन में भी जल के समान शीतलता, मधुरता और पवित्रता का संचार करें जिससे हमारा स्वभाव निर्मल हो।
            जिस प्रकार जल सभी अशुद्धियों को अपने में समाहित कर शुद्ध कर देता है, वैसे ही हमारी आत्मा को भी निष्पाप बना दें।
            संसार के सभी श्रेष्ठ कर्म इस जल के समान स्वच्छ और पारदर्शी होने चाहिए, तभी उनका वास्तविक फल प्राप्त होता है।
            हम प्रार्थना करते हैं कि यह अमृत रूपी जल हमारे मन, प्राण और शरीर को पुष्ट कर हमें दीर्घायु और निरोगी बनाए।
            आपसी प्रेम और सद्भाव से मिलकर रहना ही जल की धाराओं से प्राप्त होने वाला सबसे बड़ा सामाजिक और आध्यात्मिक संदेश है।
        """.trimIndent(),
        englishCommentary = """
            This water grants universal life, it is all-pervading, and it is the performer of all universal and noble deeds.
            O sacred streams of water! You are filled with truth, full of waves, and exceedingly sweet; mingle together seamlessly.
            This mantra describes the glory of water and its life-giving power, which is the foundational basis for all creation.
            In the sacrifice, water is used not only for physical purification but with the resolve to attain wealth, food, and prosperity.
            The flowing waves of water deeply inspire us to continuously move forward in life and overcome all obstacles gracefully.
            O Supreme Lord! Infuse our lives with the coolness, sweetness, and purity of water so our nature becomes perfectly clean.
            Just as water absorbs and purifies all impurities, please render our souls sinless and completely free from all worldly taints.
            All noble deeds in the world should be as clean and transparent as water; only then is their true fruit realized.
            We pray that this nectar-like water nourishes our mind, vital breath, and body, granting us longevity and perfect health.
            Living together with mutual love and harmony is the greatest social and spiritual message derived from merging water streams.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 4,
        sanskrit = "सप्रथस्व पृथिवि मा त्वा हिंसीन्मा मा हिंसीः।\nअग्नेस्तनूरसि वाचो विसर्जनं देववीतये त्वा गृह्णामि ॥ ४ ॥",
        hindiCommentary = """
            हे पृथ्वी! तू विस्तीर्ण हो, हमें कोई हानि न पहुँचा और हम भी तुझे कभी कोई हानि न पहुँचाएं, हमारा सह-अस्तित्व बना रहे।
            तुम अग्नि का शरीर हो, वाणी का विसर्जन हो; देवों की तृप्ति और प्रसन्नता के लिए मैं तुम्हें श्रद्धापूर्वक ग्रहण करता हूँ।
            यह मंत्र पर्यावरण संरक्षण और पृथ्वी के प्रति मनुष्य के कृतज्ञता भाव को अत्यंत सुंदर और स्पष्ट रूप में प्रस्तुत करता है।
            वेदों में पृथ्वी को माता माना गया है, और इस मंत्र में यह प्रार्थना है कि हम उसके संसाधनों का दोहन न कर केवल पोषण लें।
            यज्ञ की वेदी पृथ्वी का ही एक पवित्र अंश है, जहाँ हम देवों को हवि अर्पित कर ब्रह्मांडीय संतुलन बनाए रखने का प्रयास करते हैं।
            अग्नि का आधार पृथ्वी ही है, इसलिए दोनों का सामंजस्य जीवन के प्रत्येक शुभ कार्य की सफलता के लिए परम आवश्यक है।
            हे प्रभु! हमें वह विवेक दें जिससे हम प्रकृति के नियमों का पालन करें और कभी भी अपने स्वार्थ के लिए इसका विनाश न करें।
            पृथ्वी की विशालता हमारे मन की विशालता का प्रतीक बने, जिससे हम सभी जीवों को अपने परिवार के सदस्य के रूप में देख सकें।
            देवताओं की तृप्ति का अर्थ है प्राकृतिक शक्तियों का संतुलित रहना, जो मानव जाति के सुख और समृद्धि का मुख्य आधार है।
            हम संकल्प लेते हैं कि हम वाणी का प्रयोग केवल सत्य और कल्याण के लिए करेंगे, जो ईश्वर की सच्ची स्तुति होगी।
        """.trimIndent(),
        englishCommentary = """
            Expand and be vast, O Earth! Do not harm us, and may we never cause any harm to you; let our coexistence flourish.
            You are the physical body of Agni, the release of sacred speech; I accept you with devotion for the joy of the Gods.
            This mantra beautifully and clearly presents environmental conservation and human gratitude towards Mother Earth.
            In the Vedas, the Earth is considered a mother, and this prayer asks that we only take nourishment, not exploit her.
            The sacrificial altar is a sacred part of the earth where we offer oblations to gods to maintain cosmic balance.
            The foundation of fire is the earth itself, hence their harmony is absolutely essential for the success of auspicious acts.
            O Lord! Grant us the wisdom to follow the laws of nature and never destroy it merely for our own selfish motives.
            May the vastness of the earth become the symbol of our mental vastness, allowing us to see all beings as our family.
            The satisfaction of the deities means the balance of natural forces, which is the main basis of human happiness.
            We resolve to use our speech only for truth and welfare, which ultimately serves as the true praise of the Divine.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 5,
        sanskrit = "अद्रिरसि वानस्पत्यः स इदं देवेभ्यो हव्यं शमितं कुरु।\nधूर्व धूर्वन्तं धूर्व तं योऽस्मान्धूर्वति तं धूर्व यं वयं धूर्वामः ॥ ५ ॥",
        hindiCommentary = """
            तू वनस्पति का सार रूपी पत्थर (ओखली/मूसल) है; देवों के लिए इस पवित्र हवि को भली-भांति तैयार कर सिद्ध कर दे।
            तू बाधा डालने वालों का नाश कर; जो हमसे द्वेष करे, उसका विनाश कर, और हम जिसे दंड देना चाहें, उसका भी शमन कर।
            यज्ञ में अन्न को कूटने के लिए उपयोग किए जाने वाले उपकरणों को भी इस मंत्र में देवता स्वरूप मानकर उनका आह्वान किया गया है।
            यह मंत्र सिखाता है कि हमारे द्वारा उपयोग किए जाने वाले साधारण साधन भी यदि पवित्र उद्देश्य से जुड़ें तो वे दिव्य हो जाते हैं।
            शत्रु और द्वेष भाव जीवन की प्रगति में सबसे बड़ी बाधा हैं, अतः उनका समूल नाश करने की प्रार्थना यहाँ की गई है।
            यह हिंसा का नहीं, बल्कि आत्मरक्षा और धर्म की रक्षा के लिए बुराइयों को समाप्त करने का एक शक्तिशाली वैदिक संकल्प है।
            हमारे भीतर छिपे काम, क्रोध और लोभ रूपी आंतरिक शत्रुओं को नष्ट करने के लिए यह आध्यात्मिक प्रहार अत्यंत आवश्यक है।
            हे देव! हमें वह शक्ति दें जिससे हम न्याय के मार्ग पर खड़े रहकर अन्याय और अधर्म का निर्भीकता से सामना कर सकें।
            ईश्वर के निमित्त तैयार किया गया अन्न केवल भोजन नहीं रहता, वह प्रसाद बन जाता है जो शरीर और आत्मा दोनों को शुद्ध करता है।
            हमारी संकल्प शक्ति उस पत्थर के समान कठोर हो जो कठिनाइयों को पीसकर हमारे लिए सफलता का मार्ग पूरी तरह प्रशस्त कर दे।
        """.trimIndent(),
        englishCommentary = """
            You are the stone derived from the forest tree; prepare this sacred offering completely and thoroughly for the Gods.
            Destroy the one who causes obstacles; destroy him who harbors malice against us, and subdue the one we wish to punish.
            In this mantra, even the implements used to pound the grain in the sacrifice are invoked as divine entities.
            It teaches that even the ordinary tools we use become divine and powerful when connected to a holy and pure purpose.
            Enemies and malicious feelings are the biggest hurdles in life's progress, hence a prayer is made to uproot them.
            This is not a call for violence, but a powerful Vedic resolution to eliminate evils for self-defense and Dharma.
            This spiritual strike is absolutely necessary to destroy our internal enemies in the form of lust, anger, and greed.
            O God! Give us the strength to stand firmly on the path of justice and fearlessly face injustice and unrighteousness.
            Food prepared for the Divine ceases to be mere food; it becomes a holy sacrament that purifies both body and soul.
            May our willpower be as hard as that stone, grinding away difficulties and paving the clear path to our success.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 6,
        sanskrit = "द्यौस्ते स्तभ्नातु पृथिवी ते प्रथिम्ना।\nधृष्टिरसि ब्रह्मणा त्वा युनज्मि ॥ ६ ॥",
        hindiCommentary = """
            विशाल आकाश तुझे ऊपर से थामे रखे और यह पृथ्वी अपनी विशालता से तुझे नीचे से एक मजबूत और स्थायी आधार प्रदान करे।
            तू धैर्य और प्रगल्भता का साक्षात् स्वरूप है; परम ब्रह्म की असीम शक्ति और मंत्र के प्रभाव से मैं तुझे इस कार्य में जोड़ता हूँ।
            इस मंत्र में यज्ञ की वेदी या उपकरणों को स्थापित करते समय आकाश और पृथ्वी दोनों के सहयोग की विशेष याचना की गई है।
            सृष्टि का हर कार्य आकाश (शून्य/विस्तार) और पृथ्वी (पदार्थ/आधार) के अद्भुत संतुलन और सामंजस्य से ही संपन्न होता है।
            धैर्य और साहस ही वह 'धृष्टि' है जो मनुष्य को कठिन से कठिन परिस्थितियों में भी टूटने नहीं देती और आगे बढ़ाती है।
            ब्रह्म की शक्ति से जुड़ने का अर्थ है अपने कर्मों को अहंकार से मुक्त कर ईश्वर की इच्छा के अधीन कर देना और फल की चिंता छोड़ना।
            हम जो भी निर्माण करें, उसकी नींव पृथ्वी की तरह मजबूत और उसकी सोच आकाश की तरह असीम और व्यापक होनी चाहिए।
            हे परमात्मा! हमारे संकल्पों को ब्रह्मांडीय शक्तियों का ऐसा ही सुदृढ़ सहारा मिले जिससे हमारे उद्देश्य हमेशा सफल हों।
            जब मनुष्य स्वयं को ब्रह्म की शक्ति से युक्त कर लेता है, तब उसके लिए संसार का कोई भी लक्ष्य कभी भी असंभव नहीं रह जाता।
            हमारा जीवन भी स्वर्ग और पृथ्वी के बीच एक पवित्र सेतु बने, जो भौतिक और आध्यात्मिक दोनों दृष्टियों से पूर्णतः संतुलित हो।
        """.trimIndent(),
        englishCommentary = """
            May the vast heaven support you from above, and may this Earth sustain you with her immense breadth from below.
            You are the embodiment of courage and boldness; I yoke you to this holy task with the supreme power of Brahman.
            This mantra specifically requests the cooperation of both heaven and earth while establishing the sacrificial altar or tools.
            Every action in creation is completed only through the wonderful balance of sky (space) and earth (matter/foundation).
            Patience and courage are the 'Dhrishti' that keep a person from breaking down even in the most difficult circumstances.
            Yoking with the power of Brahman means freeing our actions from ego and submitting them to the divine will.
            Whatever we build, its foundation should be as strong as the earth, and its vision as limitless and vast as the sky.
            O Supreme Lord! May our resolutions receive such firm support from cosmic forces so our noble goals always succeed.
            When a person unites himself with the power of Brahman, no goal in this world ever remains impossible to achieve.
            May our lives also become a sacred bridge between heaven and earth, perfectly balanced both materially and spiritually.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 7,
        sanskrit = "अग्नेर्हव्यरक्षणीर्मन्त्रं जपेत्।\nअपहतोऽररुः पृथिव्यै अदेवयजन्योऽपहता रक्षार्थं वेद्याम् ॥ ७ ॥",
        hindiCommentary = """
            यह अग्नि की हवि की रक्षा करने वाला मंत्र है; यज्ञ की वेदी से उन सभी असुरी प्रवृत्तियों का नाश हो जो देवों का यजन नहीं करतीं।
            जो अररु (दानव या विघ्नकर्ता) पृथ्वी के लिए अहितकर हैं और देवयज्ञ के विरोधी हैं, उन्हें यज्ञवेदी से बहुत दूर हटा दिया गया है।
            कोई भी शुभ कार्य तभी सफल होता है जब उसके चारों ओर से नकारात्मक और विघ्न डालने वाली शक्तियों को पूरी तरह से हटा दिया जाए।
            इस मंत्र में 'अररु' केवल बाहरी शत्रु नहीं हैं, बल्कि वे हमारे मन के भीतर छिपे अज्ञान, आलस्य और अहंकार के प्रतीक भी हैं।
            वेदी को शुद्ध करने का अर्थ है अपने अंतःकरण को उस स्तर तक पवित्र बनाना जहाँ ईश्वरीय शक्तियां बिना किसी बाधा के आ सकें।
            देवयज्ञ का विरोध करने वाली प्रवृत्तियां मनुष्य को स्वार्थी बनाती हैं, उन्हें जीवन से दूर करना हमारी सबसे बड़ी और पहली प्राथमिकता है।
            अग्नि केवल प्रकाश नहीं देती, बल्कि वह एक रक्षक भी है जो पवित्रता को नष्ट करने वाले तत्वों को जलाकर हमेशा के लिए राख कर देती है।
            हे प्रभु! हमारे जीवन की वेदी पर केवल शुभ विचारों का वास हो और बुरी आदतें हमारे आस-पास भी फटकने का साहस न कर सकें।
            यज्ञ की रक्षा ही वास्तव में धर्म की रक्षा है, क्योंकि जब धर्म सुरक्षित रहता है, तभी मानवता फलती-फूलती और निरंतर विकसित होती है।
            हम अपने कर्म क्षेत्र को इस प्रकार सुरक्षित और पावन बनाएं कि वहां केवल सकारात्मकता, शांति और ईश्वरीय प्रेम का ही प्रवाह हो।
        """.trimIndent(),
        englishCommentary = """
            This is the mantra that protects Agni's oblations; let all demonic tendencies that do not worship gods be destroyed from the altar.
            The Araru (demons or obstacle creators) who are harmful to the earth and oppose divine sacrifice are driven far away.
            Any auspicious work becomes successful only when negative and disruptive forces are completely removed from its surroundings.
            In this mantra, 'Araru' are not just external foes, but they also symbolize the ignorance, laziness, and ego hidden within.
            Purifying the altar means making our inner conscience so holy that divine forces can enter without any obstruction.
            Tendencies that oppose divine sacrifice make humans selfish; distancing them from our lives is our greatest priority.
            Agni not only gives light, but it is also a protector that burns to ashes all elements that try to destroy true purity.
            O Lord! Let only auspicious thoughts reside on the altar of our lives, and may bad habits never dare to come near us.
            Protecting the sacrifice is actually protecting Dharma, because only when Dharma is safe does humanity truly flourish.
            Let us make our field of action so secure and sacred that only positivity, peace, and divine love continuously flow there.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 8,
        sanskrit = "व्रतेन दीक्षामाप्नोति दीक्षयाऽऽप्नोति दक्षिणाम्।\nदक्षिणा श्रद्धामाप्नोति श्रद्धया सत्यमाप्यते ॥ ८ ॥",
        hindiCommentary = """
            मनुष्य व्रत (सच्चे संकल्प) से दीक्षा प्राप्त करता है, और दीक्षा के कठोर पालन से उसे यज्ञ की दक्षिणा (सफलता या फल) प्राप्त होती है।
            उस दक्षिणा या सफलता से हृदय में श्रद्धा जाग्रत होती है, और जब श्रद्धा गहरी होती है, तभी मनुष्य परम सत्य को प्राप्त कर पाता है।
            यह मंत्र आध्यात्मिक साधना और जीवन की सफलता का एक अत्यंत वैज्ञानिक और सटीक क्रमबद्ध मार्ग प्रस्तुत करता है।
            शुरुआत संकल्प (व्रत) से होती है; बिना दृढ़ निश्चय के कोई भी महान कार्य या साधना कभी भी आरंभ नहीं की जा सकती।
            दीक्षा का अर्थ है स्वयं को एक अनुशासन में ढालना, जो हमें हमारे लक्ष्य की ओर निरंतर और एकाग्रचित्त होकर बढ़ने की प्रेरणा देता है।
            जब हम अनुशासन से कार्य करते हैं, तो परिणाम (दक्षिणा) अवश्य मिलता है, जो हमारे आत्मविश्वास और ईश्वर पर विश्वास को बढ़ाता है।
            सच्ची श्रद्धा अंधविश्वास नहीं है, बल्कि वह अनुभव से जन्मी हुई वह दृढ़ता है जो हमें सत्य के साक्षात् दर्शन कराती है।
            हे प्रभु! हमें संकल्प शक्ति दें ताकि हम अपने जीवन में सत्य की खोज के इस महान और पावन मार्ग पर बिना रुके चलते रहें।
            सत्य की प्राप्ति ही मानव जीवन का सर्वोच्च और अंतिम लक्ष्य है, जहाँ सभी भ्रम मिट जाते हैं और केवल ईश्वरीय आनंद शेष रहता है।
            हमारे कर्म इस प्रकार हों कि वे हमारे भीतर श्रद्धा के दीप को प्रज्वलित करें और अंततः हमें पूर्ण आत्मज्ञान की ओर ले जाएं।
        """.trimIndent(),
        englishCommentary = """
            By a vow (firm resolve), one obtains initiation; by strict initiation, one naturally obtains the sacrificial fee (success).
            From that success, faith is awakened in the heart, and through deep, unwavering faith, the Supreme Truth is ultimately attained.
            This mantra presents a highly scientific and systematic sequential path of spiritual practice and success in life.
            The journey begins with a resolve (Vrata); without a firm determination, no great work or practice can ever commence.
            Initiation means molding oneself into discipline, which inspires us to move towards our goal continuously and with focus.
            When we work with discipline, results (Dakshina) are assured, which increases our self-confidence and trust in God.
            True faith is not blind superstition, but a firmness born of real experience that ultimately reveals the Truth to us.
            O Lord! Grant us willpower so that we may continue to walk unstoppably on this great and holy path of seeking Truth.
            The attainment of Truth is the supreme and ultimate goal of human life, where all illusions vanish and only bliss remains.
            May our actions be such that they ignite the lamp of faith within us and ultimately lead us directly to full Self-realization.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 9,
        sanskrit = "अग्ने व्रतपते व्रतं चरिष्यामि तच्छकेयं तन्मे राध्यताम्।\nइदमहमनृतात्सत्यमुपैमि ॥ ९ ॥",
        hindiCommentary = """
            हे व्रतों के रक्षक अग्निदेव! मैं सत्य के मार्ग पर चलने का व्रत लेता हूँ; मुझे इसे पूरा करने की शक्ति दें और मेरा यह व्रत सफल हो।
            मैं इस संकल्प के माध्यम से असत्य (अज्ञान और बुराई) को पूरी तरह छोड़कर सत्य (ज्ञान और ईश्वरीय मार्ग) की ओर गमन करता हूँ।
            यह यजुर्वेद का अत्यंत प्रसिद्ध और शक्तिशाली मंत्र है, जो मनुष्य के भीतर के आत्म-परिवर्तन की तीव्र आकांक्षा को दर्शाता है।
            अग्नि को व्रतपति इसलिए कहा गया है क्योंकि अग्नि साक्षी है और उसकी ज्योति हमें सदा हमारे संकल्प की याद दिलाती रहती है।
            सत्य के मार्ग पर चलना अत्यंत कठिन है, इसलिए साधक ईश्वर से केवल प्रेरणा नहीं, बल्कि उस मार्ग पर टिके रहने की शक्ति मांगता है।
            असत्य से सत्य की ओर जाने का अर्थ केवल झूठ बोलना छोड़ना नहीं है, बल्कि जीवन के हर क्षण में यथार्थ और न्याय को अपनाना है।
            हम अज्ञान के अंधकार से निकलकर उस दिव्य प्रकाश की ओर जाना चाहते हैं जहाँ आत्मा का वास्तविक और शाश्वत स्वरूप प्रकट होता है।
            हे देव! जब भी मेरे कदम डगमगाएं, आप मेरी रक्षा करें और मुझे पुनः मेरे उच्च आदर्शों और संकल्पों की ओर मोड़ दें।
            यही वह मंत्र है जो मनुष्य को पशु स्तर से उठाकर देवत्व की ओर ले जाता है, क्योंकि सत्य ही ईश्वर का साक्षात् स्वरूप है।
            हमारा पूरा जीवन इसी व्रत का एक अखंड पालन बन जाए, जिससे अंत समय में हमें परम शांति और ईश्वर की प्राप्ति हो सके।
        """.trimIndent(),
        englishCommentary = """
            O Agni, Lord of Vows! I shall observe the vow of Truth; grant me the strength to fulfill it, and may my vow be successful.
            Through this sacred resolve, I completely abandon untruth (ignorance and evil) and approach Truth (knowledge and God).
            This is a highly famous and powerful mantra of the Yajurveda, showing humanity's intense desire for inner transformation.
            Agni is called the Lord of Vows because fire is the eternal witness, and its light constantly reminds us of our resolve.
            Walking the path of truth is very difficult, so the seeker asks God not just for inspiration, but for the strength to persist.
            Moving from untruth to truth does not just mean stopping lies; it means adopting reality and justice in every moment.
            We wish to leave the darkness of ignorance and step into the divine light where the true, eternal nature of the soul is revealed.
            O God! Whenever my steps falter, protect me and turn me back toward my high ideals, noble resolutions, and Dharma.
            This is the mantra that elevates a person from an animalistic level to divinity, because Truth is the direct form of God.
            May our entire life become an unbroken observance of this vow, so that in the end, we attain supreme peace and the Divine.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 10,
        sanskrit = "कस्त्वा युनक्ति स त्वा युनक्ति कस्मै त्वा युनक्ति तस्मै त्वा युनक्ति।\nकर्मणे वां वेषाय वाम् ॥ १० ॥",
        hindiCommentary = """
            तुम्हें कौन (प्रजापति/ईश्वर) नियुक्त करता है? वह परमेश्वर ही तुम्हें नियुक्त करता है। वह तुम्हें किसलिए नियुक्त करता है? उसी (परम सुख) के लिए।
            मैं तुम दोनों (यज्ञ के उपकरणों या प्राण और अपान) को श्रेष्ठ कर्म की सिद्धि और यज्ञादि महान कार्यों के विस्तार के लिए नियुक्त करता हूँ।
            इस मंत्र में 'कः' शब्द का प्रयोग प्रजापति या उस अव्यक्त ईश्वर के लिए किया गया है जो संपूर्ण सृष्टि का एकमात्र नियंता है।
            यह दर्शन कराता है कि संसार में जो भी कार्य हो रहा है, वह ईश्वरीय इच्छा और उसकी व्यापक व्यवस्था के अंतर्गत ही हो रहा है।
            हमारा कोई भी कर्म व्यक्तिगत नहीं है; जब हम उसे ईश्वर को समर्पित कर देते हैं, तो वह 'कस्मै' (ईश्वर के लिए) हो जाता है।
            प्राण और ऊर्जा का उपयोग केवल स्वार्थ के लिए नहीं, बल्कि समाज के मंगल और श्रेष्ठ आध्यात्मिक कर्मों के लिए होना चाहिए।
            यह प्रश्नोत्तर शैली साधक को यह याद दिलाती है कि उसके जीवन का मूल स्रोत और अंतिम लक्ष्य केवल और केवल परमात्मा ही है।
            हे प्रभु! हमें यह बोध सदा रहे कि हमारी सभी क्षमताएं आपकी ही दी हुई हैं और हमें उनका उपयोग आपके ही कार्यों में करना है।
            कर्म की श्रेष्ठता इस बात में है कि वह बिना किसी अहंकार के किया जाए और उसका फल संपूर्ण सृष्टि के कल्याण के लिए हो।
            यह मंत्र हमें निमित्त मात्र बनकर कर्मयोग के उस उच्च शिखर पर पहुँचने की महान प्रेरणा देता है जहाँ पूर्ण शांति का वास है।
        """.trimIndent(),
        englishCommentary = """
            Who (Prajapati/God) yokes you? That Supreme Lord yokes you. For what purpose does He yoke you? For Him (supreme bliss).
            I yoke both of you (sacrificial tools or Prana and Apana) for the accomplishment of noble deeds and the expansion of sacrifice.
            In this mantra, the word 'Kah' (Who) is used for Prajapati or the unmanifest God who is the sole controller of creation.
            It philosophizes that whatever action is happening in the world falls strictly under the divine will and His vast cosmic order.
            None of our actions are purely personal; when we surrender them to God, they become 'Kasmai' (for the sake of the Divine).
            The use of vitality and energy should not be merely for selfish ends but for the welfare of society and high spiritual deeds.
            This question-and-answer style reminds the seeker that the source and ultimate goal of their life is solely the Supreme.
            O Lord! Keep us always aware that all our capabilities are given by You, and we must use them strictly in Your service.
            The greatness of an action lies in it being performed without ego, and its fruits being dedicated to universal welfare.
            This mantra deeply inspires us to become mere instruments and reach the peak of Karma Yoga where complete peace resides.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 11,
        sanskrit = "प्रत्युष्टं रक्षः प्रत्युष्टा अरातयो निष्टप्तं रक्षो निष्टप्ता अरातयः।\nउर्वन्तरिक्षमन्वेमि ॥ ११ ॥",
        hindiCommentary = """
            राक्षसी प्रवृत्तियों को मैंने पूरी तरह से तपा कर नष्ट कर दिया है; कृपणता और शत्रुता के भावों को मैंने जलाकर भस्म कर दिया है।
            इन सभी नकारात्मकताओं को जला देने के बाद, अब मैं इस विशाल और उन्मुक्त अंतरिक्ष (स्वतंत्र और शुद्ध चेतना) में निर्बाध विचरण करता हूँ।
            यज्ञ की अग्नि में केवल लकड़ी नहीं जलाई जाती, बल्कि साधक अपने भीतर के राक्षसी विचारों और अज्ञान को भी अग्नि को समर्पित करता है।
            अराति का अर्थ है वे शक्तियां जो हमें दान देने, परोपकार करने या श्रेष्ठ कार्य करने से रोकती हैं; उनका नाश आध्यात्मिक प्रगति के लिए आवश्यक है।
            जब तक मन में शत्रुता, भय या कंजूसी होती है, तब तक मनुष्य का हृदय संकुचित रहता है और वह कभी भी ईश्वर का अनुभव नहीं कर सकता।
            इन दोषों के भस्म होने पर ही आत्मा उस 'उरु अंतरिक्ष' यानी अनंत विस्तार और असीम शांति का अनुभव करने में पूरी तरह सक्षम होती है।
            हे अग्निदेव! आप हमारे मानसिक विकारों को अपनी पावन ज्वाला में जला दें ताकि हमारा अंतःकरण आकाश की तरह निर्मल और व्यापक हो जाए।
            स्वतंत्रता का वास्तविक अर्थ भौतिक बंधनों से मुक्ति नहीं, बल्कि अपनी ही बुराइयों से स्वयं को पूरी तरह से मुक्त कर लेना है।
            यह मंत्र हमें सिखाता है कि सकारात्मकता की ओर बढ़ने से पहले भीतर की नकारात्मकता का कठोरता से दमन करना अत्यंत आवश्यक है।
            हम ईश्वर की असीम सत्ता में इस प्रकार लीन हो जाएं कि संसार का कोई भी क्लेश या दुख हमारी आंतरिक शांति को कभी भी भंग न कर सके।
        """.trimIndent(),
        englishCommentary = """
            I have completely scorched and destroyed demonic tendencies; I have thoroughly burnt to ashes the feelings of miserliness and enmity.
            Having burnt away all these negativities, I now move unhindered and freely into the vast and open space (pure consciousness).
            In the sacrificial fire, not only wood is burnt, but the seeker also completely surrenders internal demonic thoughts and ignorance.
            'Arati' means forces that stop us from giving charity, helping others, or doing noble deeds; their destruction is vital for progress.
            As long as enmity, fear, or stinginess remain, the human heart remains contracted and can never truly experience the Divine.
            Only when these flaws are burnt does the soul become capable of experiencing the 'Uru Antariksha'—infinite expansion and peace.
            O Agni! Burn our mental afflictions in your holy flame so that our inner conscience becomes as clear and vast as the sky.
            True freedom is not just liberation from physical bonds, but completely freeing oneself from one's own internal evils.
            This mantra teaches us that before moving towards positivity, it is absolutely essential to strictly suppress inner negativity.
            May we merge into God's infinite existence such that no worldly affliction or sorrow can ever disturb our profound inner peace.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 12,
        sanskrit = "देवस्य त्वा सवितुः प्रसवेऽश्विनोर्बाहुभ्यां पूष्णो हस्ताभ्याम्।\nअग्नये जुष्टं गृह्णाम्यग्नीषोमाभ्यां जुष्टं गृह्णामि ॥ १२ ॥",
        hindiCommentary = """
            सृष्टिकर्ता सविता देव की पावन प्रेरणा से, अश्विनीकुमारों की बलशाली भुजाओं से और पूषा देव के मजबूत हाथों से मैं इस हवि को ग्रहण करता हूँ।
            यह हवि मैं अग्नि देव की प्रसन्नता के लिए और अग्नि तथा सोम दोनों देवों की पूर्ण तृप्ति के लिए अत्यंत श्रद्धापूर्वक स्वीकार करता हूँ।
            यज्ञ का हर कर्म व्यक्तिगत अहंकार से मुक्त होता है; साधक मानता है कि उसके हाथ देवताओं के ही हाथ हैं, जो यह श्रेष्ठ कर्म कर रहे हैं।
            सविता हमें प्रेरणा देते हैं, अश्विनीकुमार हमें प्राणशक्ति और आरोग्य देते हैं, और पूषा हमें पोषण प्रदान कर हमारे शरीर को पुष्ट करते हैं।
            जब मनुष्य यह अनुभव करता है कि उसके द्वारा किया गया कर्म ईश्वरीय शक्तियों द्वारा ही हो रहा है, तब कर्म बंधनों से मुक्ति मिल जाती है।
            अग्नि और सोम सृष्टि के दो मुख्य तत्व हैं—अग्नि ऊष्मा (तेज) का और सोम शीतलता (शांति) का प्रतीक है; दोनों का संतुलन ही जीवन है।
            हे परमात्मा! हमारे हाथों से केवल ऐसे ही कार्य संपन्न हों जो समाज के लिए कल्याणकारी हों और जो ब्रह्मांडीय शक्तियों को प्रसन्न करें।
            हम जो भी ग्रहण करें या समाज को दें, वह ईश्वर का प्रसाद मानकर दें, जिससे हमारे मन में कभी भी रत्ती भर अहंकार उत्पन्न न हो।
            देवताओं की ऊर्जा को अपने भीतर आमंत्रित करने का यह एक अत्यंत शक्तिशाली और वैज्ञानिक वैदिक मंत्र है, जो हमें ईश्वर से जोड़ता है।
            हमारा जीवन अग्नि की तरह तेजस्वी और सोम की तरह मधुर और शांतिपूर्ण बने, ताकि हम विश्व में धर्म और प्रेम की स्थापना कर सकें।
        """.trimIndent(),
        englishCommentary = """
            Impelled by the Divine Savitar, with the strong arms of the Ashvins, and with the firm hands of Pushan, I take this sacred oblation.
            I accept this offering with great devotion for the pleasure of Agni, and for the complete satisfaction of both Agni and Soma.
            Every act of the sacrifice is free from personal ego; the seeker believes his hands are the gods' hands performing this noble deed.
            Savitar provides inspiration, the Ashvins grant vitality and health, and Pushan provides nourishment to strengthen our bodies.
            When a person realizes that the actions performed are actually driven by divine forces, liberation from the bondage of karma occurs.
            Agni and Soma are two core elements of creation—Agni represents heat (brilliance) and Soma coolness (peace); their balance is life.
            O Supreme Lord! May our hands only perform deeds that are beneficial for society and that please the cosmic divine forces.
            Whatever we take or give to society, let it be given as God's grace, so that not even an ounce of ego ever arises in our minds.
            This is an incredibly powerful and scientific Vedic mantra to invite divine energy within, connecting us directly to God.
            May our lives become brilliant like Agni and sweet like Soma, so we can establish Dharma and pure love throughout the world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 13,
        sanskrit = "वेदोऽसि येन त्वं देव वेद देवेभ्यो वेदोऽभवस्तेन मह्यं वेदो भूयाः।\nदेवानां त्वा पितॄणां त्वाऽऽयुरसि विश्वमायुर्वर्चोदा असि ॥ १३ ॥",
        hindiCommentary = """
            हे कुश की मुष्टि (वेद)! तुम ज्ञान स्वरूप हो; जिस प्रकार तुमने देवों को ज्ञान (धन/सिद्धि) प्रदान किया, उसी प्रकार मुझे भी श्रेष्ठ ज्ञान और ऐश्वर्य प्रदान करो।
            तुम देवों और पितरों दोनों के लिए हो; तुम संपूर्ण विश्व की आयु (जीवन) हो और ओज तथा तेज प्रदान करने वाले साक्षात् देव स्वरूप हो।
            यज्ञ में प्रयुक्त कुश की मुट्ठी को ही 'वेद' कहकर संबोधित किया गया है, जो इस बात का प्रतीक है कि प्रकृति का हर अंश ज्ञान से भरा है।
            ज्ञान केवल पुस्तकों में नहीं, बल्कि प्रकृति के साथ हमारे संबंध और यज्ञीय कर्मों में भी समाहित है; हमें बस उसे पहचानने की दृष्टि चाहिए।
            जो शक्ति देवताओं को सिद्धि देती है, वही शक्ति एक निस्वार्थ साधक को भी प्राप्त हो सकती है यदि उसकी भावना अत्यंत शुद्ध और पवित्र हो।
            यह मंत्र देवों (प्रकाशमान शक्तियों) और पितरों (पूर्वजों के अनुभवों) दोनों का सम्मान करता है, जो हमारी संस्कृति का एक मुख्य आधार है।
            आयु और वर्चस्व (तेज) भौतिक जीवन के लिए आवश्यक हैं, परंतु इनका उपयोग धर्म की रक्षा और समाज के कल्याण के लिए ही होना चाहिए।
            हे प्रभु! हमें वह 'वेद' यानी सच्चा ज्ञान दें जिससे हमारे जीवन का अज्ञान नष्ट हो और हम एक तेजस्वी तथा दीर्घायु जीवन व्यतीत कर सकें।
            हमारा जीवन इस कुशा के समान पवित्र हो जाए, जो देखने में साधारण है परंतु जिसमें देवताओं को प्रसन्न करने की अद्भुत और अलौकिक क्षमता है।
            हम अपने पूर्वजों के दिखाए मार्ग पर चलकर अपनी आने वाली पीढ़ियों के लिए तेज, ओज और ज्ञान का एक अमूल्य खजाना छोड़कर जाएं।
        """.trimIndent(),
        englishCommentary = """
            O handful of Kusha grass (Veda)! You are knowledge; just as you granted knowledge and wealth to the gods, grant me supreme wisdom and prosperity.
            You are for both the Gods and the Ancestors; you are the life of the entire universe and the direct giver of vigor and profound brilliance.
            The handful of Kusha used in the sacrifice is addressed as 'Veda', symbolizing that every part of nature is brimming with deep knowledge.
            Knowledge is not only in books but embedded in our relationship with nature and sacrificial acts; we just need the vision to see it.
            The same power that grants success to the gods can be attained by a selfless seeker if their intentions are extremely pure and holy.
            This mantra respects both the Gods (luminous forces) and Ancestors (experiences of the past), which is a core foundation of our culture.
            Longevity and dominance (brilliance) are necessary for physical life, but they must be used solely to protect Dharma and global welfare.
            O Lord! Grant us that 'Veda'—true knowledge—so the ignorance of our lives is destroyed and we lead a brilliant and long life.
            May our lives become as pure as this Kusha grass, which looks ordinary but possesses the amazing, supernatural ability to please Gods.
            Walking the path shown by our ancestors, may we leave behind an invaluable treasure of brilliance, vigor, and wisdom for future generations.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 14,
        sanskrit = "मा तर्पीर्मा प्रमीर्मा हिंसीः।\nअन्तरिक्षमसि भूरसि भूमिरसि ॥ १४ ॥",
        hindiCommentary = """
            तू किसी को संतप्त (दुखी) मत कर, तू किसी का विनाश मत कर, और तू किसी भी जीव की हिंसा मत कर।
            तू ही अंतरिक्ष (मध्य लोक) है, तू ही भू (प्राण-आधार) है, और तू ही यह विशाल और धारण करने वाली भूमि है।
            यह मंत्र अहिंसा और शांति का एक बहुत ही स्पष्ट और प्रत्यक्ष वैदिक संदेश है, जो जीवन के सभी स्तरों पर संयम बरतने की शिक्षा देता है।
            यज्ञ के उपकरण या प्रकृति की शक्तियों से यह प्रार्थना की गई है कि वे मानवता के लिए कल्याणकारी हों, न कि विनाशकारी।
            हम भी अपने जीवन में यह संकल्प लें कि हमारे किसी भी कर्म, वचन या विचार से किसी अन्य जीव को कोई दुख या संताप न पहुँचे।
            सृष्टि के तीन मुख्य स्तर—पृथ्वी, अंतरिक्ष और द्युलोक—एक ही परमात्मा के विभिन्न रूप हैं, इसलिए सभी में एक ही चेतना व्याप्त है।
            जब हम संसार को ईश्वर का ही विस्तार मान लेते हैं, तो हमारे भीतर से हिंसा और द्वेष की भावना स्वतः ही जड़ से समाप्त हो जाती है।
            हे परमात्मा! हमें ऐसा स्वभाव दें कि हम अपने आस-पास के वातावरण को शांति, प्रेम और करुणा से निरंतर पोषित करते रहें।
            भूमि हमें धारण करती है और अंतरिक्ष हमें विस्तार देता है; हमें इन दोनों से सहनशीलता और व्यापकता का महान गुण अवश्य सीखना चाहिए।
            हमारा अस्तित्व दूसरों के विनाश का कारण न बने, बल्कि यह संपूर्ण ब्रह्मांड के लिए एक वरदान और शांति का अद्भुत स्रोत सिद्ध हो।
        """.trimIndent(),
        englishCommentary = """
            Do not torment or cause sorrow to anyone, do not destroy anyone, and do not commit violence against any living being.
            You are the intermediate space (Antariksha), you are the foundation of life (Bhu), and you are this vast, sustaining Earth.
            This mantra is a very clear and direct Vedic message of non-violence and peace, teaching restraint at all levels of existence.
            A prayer is made to the sacrificial implements or forces of nature that they be beneficial to humanity, not destructive.
            We too should resolve in our lives that none of our actions, words, or thoughts ever cause sorrow or torment to any other soul.
            The three main levels of creation—Earth, Space, and Heaven—are forms of the same God, hence one consciousness pervades all.
            When we consider the world as an extension of God, the feelings of violence and malice automatically vanish from their roots.
            O Supreme Lord! Grant us a nature that continuously nourishes our surrounding environment with peace, love, and compassion.
            The Earth holds us and the Space gives us expansion; we must absolutely learn the great qualities of tolerance and vastness from both.
            May our existence not be the cause of destruction for others, but prove to be a blessing and an amazing source of peace for the universe.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 15,
        sanskrit = "अदित्यै रास्नासीन्द्राण्या उष्णीषः।\nपूषा ते ग्रन्थिं ग्रथ्नातु स ते माऽस्थात् ॥ १५ ॥",
        hindiCommentary = """
            तू अदिति (देवमाता/अखंड सत्ता) की करधनी (रास्ना) है; तू इंद्राणी (ऐश्वर्य की देवी) का पवित्र उष्णीष (मुकुट या शिरोबंध) है।
            पूषा देव (पोषण के अधिपति) तेरी इस गांठ को मजबूती से बांधें, ताकि यह कभी भी ढीली न हो और यज्ञ का कार्य सुचारु रूप से चलता रहे।
            यज्ञ में हवि की सामग्री को बांधने वाली साधारण डोरी को भी यहाँ अदिति और इंद्राणी जैसे दिव्य प्रतीकों से जोड़ा गया है।
            अदिति अखंडता की प्रतीक हैं; यज्ञ में जो कुछ भी अर्पित होता है,চেতন ہمیں उस परम अखंड ईश्वरीय सत्ता के साथ जोड़ देता है।
            इंद्राणी ऐश्वर्य और शक्ति की प्रतीक हैं, जो दर्शाती हैं कि धर्म के मार्ग पर चलने से ही वास्तविक और स्थायी वैभव प्राप्त होता है।
            गांठ का प्रतीक है हमारा दृढ़ संकल्प; यदि संकल्प की गांठ मजबूत नहीं होगी, तो साधना और सफलता बिखर जाएगी।
            पूषा देव से प्रार्थना है कि वे हमारे संकल्पों को पोषण दें और हमारी एकाग्रता को कभी भी टूटने या कमजोर न होने दें।
            हे प्रभु! हमारे जीवन में भी धर्म, कर्म और भक्ति की ऐसी मजबूत गांठ बांध दें जिसे संसार का कोई भी प्रलोभन या दुख खोल न सके।
            हम जो भी नियम या व्रत लें, उस पर पूरी निष्ठा से टिके रहें और कभी भी अपने उच्च आदर्शों से पीछे न हटें।
            यह मंत्र साधारण वस्तुओं में भी दिव्यता देखने और अपने हर कर्म को एक पवित्र अनुष्ठान बनाने की महान कला हमें सिखाता है।
        """.trimIndent(),
        englishCommentary = """
            You are the girdle (Rasna) of Aditi (the boundless Mother of Gods); you are the sacred head-wrap (Ushnisha) of Indrani (Goddess of wealth).
            May the God Pushan (Lord of nourishment) tie your knot firmly, so that it never comes undone and the sacrifice proceeds smoothly.
            Even the simple cord used to bind the sacrificial offerings is linked here to divine symbols like Aditi and Indrani.
            Aditi symbolizes boundlessness and integrity; whatever is offered in sacrifice connects us with that supreme, unbroken divine reality.
            Indrani represents prosperity and power, showing that true and lasting wealth is attained only by walking the path of Dharma.
            The knot symbolizes our firm resolve; if the knot of determination is not strong, spiritual practice and success will scatter.
            The prayer to Pushan is to nourish our resolutions and ensure that our concentration never breaks or becomes weak.
            O Lord! Tie such a strong knot of Dharma, action, and devotion in our lives that no worldly temptation or sorrow can untie it.
            Whatever rules or vows we take, let us stand by them with absolute loyalty and never step back from our high spiritual ideals.
            This mantra teaches us the great art of seeing divinity even in ordinary objects and making every action a holy ritual.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 16,
        sanskrit = "इन्द्रस्य त्वा बाहुभ्यामुद्यच्छे।\nबृहस्पतेर्मूर्ध्ना हरामि ॥ १६ ॥",
        hindiCommentary = """
            हे हवि! मैं तुम्हें इंद्र की अत्यंत बलशाली भुजाओं की शक्ति से ऊपर उठाता हूँ, ताकि यह कार्य पूरी सामर्थ्य के साथ संपन्न हो सके।
            मैं बृहस्पति (बुद्धि और ज्ञान के देव) के मस्तक (सर्वोच्च ज्ञान) की प्रेरणा से तुम्हें धारण कर यज्ञवेदी तक ले जाता हूँ।
            कर्म की पूर्णता के लिए दो चीजों की सबसे अधिक आवश्यकता होती है—शारीरिक शक्ति (इंद्र) और श्रेष्ठ बुद्धि या ज्ञान (बृहस्पति)।
            केवल बल होने से कार्य विनाशकारी हो सकता है, और केवल बुद्धि होने से कर्म का अभाव हो सकता है; दोनों का संगम ही यज्ञ है।
            जब हम कोई पवित्र कार्य अपने हाथों में लेते हैं, तो हमें यह भावना रखनी चाहिए कि हमारा बल ईश्वरीय है और हमारी मति भी ईश्वरीय है।
            यह मंत्र अहंकार का नाश करता है; साधक यह मानता है कि वह स्वयं कुछ नहीं कर रहा, बल्कि इंद्र और बृहस्पति उसके माध्यम से कार्य कर रहे हैं।
            हम जो भी दायित्व उठाएं, उसे पूरी ऊर्जा और उत्तम विवेक के साथ पूरा करें, ताकि उसका परिणाम सभी के लिए मंगलकारी हो।
            हे देव! हमें इंद्र जैसी अदम्य कार्यक्षमता और बृहस्पति जैसा गहरा विवेक प्रदान करें जिससे हम जीवन की हर चुनौती को पार कर सकें।
            यज्ञ की हवि को ले जाना एक प्रतीकात्मक यात्रा है, जो मनुष्य को सामान्य जीवन से उठाकर उच्च आध्यात्मिक शिखर (मूर्धा) तक ले जाती है।
            हमारे सभी कर्म ईश्वर को समर्पित हों और हमारी बुद्धि सदैव सत्य, धर्म और न्याय के सर्वोच्च प्रकाश से आलोकित रहे।
        """.trimIndent(),
        englishCommentary = """
            O Oblation! I lift you up with the power of the extremely mighty arms of Indra, so that this task may be accomplished with full strength.
            I carry you inspired by the head (supreme wisdom) of Brihaspati (the God of intellect and knowledge) to the sacrificial altar.
            For the perfection of any action, two things are needed most—physical strength (Indra) and superior wisdom or knowledge (Brihaspati).
            Mere strength can be destructive, and mere intellect can lead to inaction; the confluence of both is the true sacrifice.
            When we take up a holy task, we should hold the feeling that our strength is divine and our intellect is also completely divine.
            This mantra destroys ego; the seeker believes he is doing nothing himself, but Indra and Brihaspati are acting through him.
            Whatever responsibility we lift, let us fulfill it with full energy and excellent discernment, so the result is auspicious for all.
            O God! Grant us indomitable working capacity like Indra and profound wisdom like Brihaspati so we can cross every challenge in life.
            Carrying the oblation is a symbolic journey that elevates a human from an ordinary life to the highest spiritual peak (Murdha).
            May all our actions be dedicated to God, and our intellect remain constantly illuminated by the supreme light of truth, Dharma, and justice.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 17,
        sanskrit = "उरुविष्णो विक्रमस्वोरु क्षयाय नस्कृधि।\nघृतं घृतयोने पिब प्र प्र यज्ञपतिं तिर ॥ १७ ॥",
        hindiCommentary = """
            हे सर्वव्यापी विष्णु देव! आप अपना विशाल डग (कदम) भरें और हमारे निवास स्थान को अत्यंत विस्तृत, सुरक्षित और समृद्ध बनाएं।
            हे घृत से उत्पन्न होने वाले अग्नि देव! आप इस पवित्र घी का पान करें और हमारे इस यज्ञ के स्वामी (यजमान) की निरंतर वृद्धि और प्रगति करें।
            विष्णु का अर्थ है वह जो कण-कण में व्याप्त है; उनकी 'विक्रम' (कदम) की प्रार्थना जीवन में विस्तार, प्रगति और ऊंचाइयों को छूने का प्रतीक है।
            हमारा जीवन केवल एक स्थान पर रुका हुआ न रहे, बल्कि हम वैचारिक और आत्मिक रूप से निरंतर आगे बढ़ें और असीम हो जाएं।
            अग्नि को 'घृतयोनि' कहा गया है क्योंकि वह घी से ही प्रज्वलित होती है; घी हमारे उत्तम कर्मों और शुद्ध भावों का प्रतीक है।
            जब हम ईश्वर को अपनी श्रेष्ठतम भावनाएं अर्पित करते हैं, तब ईश्वरीय शक्तियां हमारे जीवन और कुल की वृद्धि सुनिश्चित करती हैं।
            हे प्रभु! हमारे हृदय को इतना विशाल बना दें कि उसमें संपूर्ण संसार के लिए प्रेम समा सके और संकीर्णता का पूरी तरह से नाश हो जाए।
            यज्ञपति की वृद्धि का अर्थ केवल धन की वृद्धि नहीं, बल्कि यश, धर्म, ज्ञान और आध्यात्मिक शांति में निरंतर और स्थायी बढ़ोतरी से है।
            जिस प्रकार विष्णु ने तीन पगों में त्रिलोकी को नाप लिया था, वैसे ही हम भी अपने पुरुषार्थ से धर्म, अर्थ और मोक्ष को प्राप्त करें।
            हमारा हर कदम सत्य की ओर उठे और हमारी हर आहुति विश्व के कल्याण के लिए एक शक्तिशाली आशीर्वाद में परिवर्तित हो जाए।
        """.trimIndent(),
        englishCommentary = """
            O Omnipresent Lord Vishnu! Take your vast stride and make our dwelling place extremely wide, secure, and prosperous.
            O Agni, born of clarified butter (Ghee)! Drink this sacred Ghee and continuously promote the growth and progress of the master of this sacrifice.
            Vishnu means the one who pervades every atom; the prayer for His 'Vikrama' (stride) symbolizes expansion, progress, and reaching great heights in life.
            Our life should not remain stagnant in one place, but we must continuously move forward conceptually and spiritually to become boundless.
            Agni is called 'Ghritayoni' because it is ignited by Ghee; Ghee is the symbol of our most excellent deeds and pure emotions.
            When we offer our highest feelings to God, divine forces ensure the growth and protection of our lives and families.
            O Lord! Make our hearts so vast that love for the entire world can fit within, completely destroying all narrow-mindedness.
            The growth of the sacrifice's master does not just mean an increase in wealth, but a continuous and permanent rise in fame, Dharma, and peace.
            Just as Vishnu measured the three worlds in three steps, may we too attain Dharma, wealth, and liberation through our righteous efforts.
            May every step of ours rise towards the Truth, and may every oblation we offer transform into a powerful blessing for global welfare.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 18,
        sanskrit = "अग्निष्टे तनुवं माऽतिधाक्।\nअग्ने हव्यं रक्षस्व ॥ १८ ॥",
        hindiCommentary = """
            हे हविष्य (अन्न)! अग्नि तुम्हारे स्वरूप को पूरी तरह से जलाकर नष्ट न करे, बल्कि वह तुम्हें देवों के योग्य पवित्र रूप में ही परिपक्व करे।
            हे अग्निदेव! आप इस हविष्य की रक्षा करें ताकि यह यज्ञ का उद्देश्य पूर्ण कर सके और किसी भी प्रकार से व्यर्थ न जाने पाए।
            यज्ञ में पकाने की प्रक्रिया अत्यंत संयमित होती है; यदि आंच अधिक हो तो अन्न जल जाता है, और कम हो तो कच्चा रह जाता है।
            यह जीवन में भी 'मध्यम मार्ग' और संतुलन अपनाने का महान संदेश है—हमारा उत्साह क्रोध न बन जाए और हमारी शांति आलस्य न बन जाए।
            अग्नि से प्रार्थना की गई है कि वह विनाशक नहीं, बल्कि शोधक और रक्षक की भूमिका निभाए, ताकि हमारे कर्मों का सही फल प्राप्त हो।
            हमारे संकल्प और तपस्या इतनी ही होनी चाहिए जितनी हमारा शरीर और मन सहन कर सके; अति सर्वत्र वर्जित है।
            हे देव! हमारे भीतर की ज्ञानरूपी अग्नि हमारे दुर्गुणों को तो अवश्य जलाए, परंतु हमारे मानवीय गुणों और संवेदनाओं को हमेशा सुरक्षित रखे।
            हवि की रक्षा का अर्थ है हमारी मेहनत और हमारी शुद्ध भावनाओं की रक्षा, ताकि वे संसार के बुरे प्रभावों से कभी नष्ट न हों।
            हम जो भी कर्म ईश्वर को अर्पित करने के लिए करें, वह पूर्णता से युक्त हो और उसमें किसी भी प्रकार दोष या त्रुटि न रहे।
            ईश्वर हमारी रक्षा उसी प्रकार करे जैसे अग्नि यज्ञ की हवि को पवित्र बनाकर उसे देवताओं तक सुरक्षित पहुँचाने का कार्य करती है।
        """.trimIndent(),
        englishCommentary = """
            O Sacrificial Food! May Agni not completely burn and destroy your form, but mature you into a holy state fit for the gods.
            O Agni! Protect this oblation so that it may fulfill the very purpose of the sacrifice and not go to waste in any way.
            The process of cooking in the sacrifice is highly restrained; if the heat is too much, food burns, if too little, it remains raw.
            This is a great message to adopt the 'Middle Path' and balance in life—our enthusiasm shouldn't become anger, nor our peace lethargy.
            Agni is prayed to play the role of a purifier and protector, not a destroyer, so we receive the correct fruits of our actions.
            Our resolutions and penance should only be as much as our body and mind can bear; excess is forbidden everywhere.
            O God! Let the fire of knowledge within us surely burn our flaws, but always keep our human virtues and sensitivities completely safe.
            Protecting the oblation means protecting our hard work and pure emotions, so they are never destroyed by the world's bad influences.
            Whatever deed we perform to offer to God, let it be filled with perfection and completely free from any kind of flaw or error.
            May God protect us just as Agni purifies the sacrificial offering and safely carries it to the divine beings.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 19,
        sanskrit = "दृंहस्व मा ह्वाः।\nमित्रस्य त्वा चक्षुषा प्रेक्षे ॥ १९ ॥",
        hindiCommentary = """
            हे हविष्य (या साधक)! तू दृढ़ रह, अपने स्वरूप से कभी भी विचलित मत हो और किसी भी स्थिति में कुटिलता या टेढ़ापन मत अपना।
            मैं तुम्हें 'मित्र' (सूर्य या स्नेही देव) की अत्यंत स्नेहपूर्ण और समतामयी दृष्टि से देखता हूँ, जिसमें कोई भी भेदभाव या द्वेष नहीं है।
            यह मंत्र जीवन में दृढ़ता और सरलता का सबसे सुंदर पाठ पढ़ाता है; कठिनाइयों में भी हमें अपने सत्य के मार्ग से नहीं डिगना चाहिए।
            टेढ़ापन या कुटिलता मनुष्य के पतन का सबसे बड़ा कारण है; जो ईश्वर का भक्त है, उसका स्वभाव सदैव जल की तरह सीधा और पारदर्शी होता है।
            'मित्र की दृष्टि' का अर्थ है सारे संसार को प्रेम, करुणा और मित्रता के भाव से देखना, किसी को भी शत्रु न मानना।
            सूर्य जैसे सभी पर समान रूप से प्रकाश डालता है, वैसे ही हमारी दृष्टि में भी ऊंच-नीच, छोटे-बड़े का कोई भी अनुचित भेद नहीं होना चाहिए।
            हे प्रभु! हमें इतनी शक्ति दें कि हम अपने सिद्धांतों पर अडिग रहें, परंतु हमारा व्यवहार दूसरों के प्रति अत्यंत कोमल और मित्रवत हो।
            जब हम संसार को मित्रता की दृष्टि से देखते हैं, तो सारा संसार हमारा अपना परिवार बन जाता है (वसुधैव कुटुम्बकम्)।
            ईश्वर भी हमें उसी प्रेमपूर्ण दृष्टि से निहारता है; अतः हमें अपने भीतर के भयों और संशयों को त्यागकर पूर्णतः निर्भय हो जाना चाहिए।
            हमारा जीवन ऐसा हो कि जो भी हमारे संपर्क में आए, वह केवल शांति, सौहार्द और ईश्वरीय प्रेम का ही अनुभव करे।
        """.trimIndent(),
        englishCommentary = """
            O Sacrificial Offering (or seeker)! Be firm, never deviate from your true nature, and do not adopt crookedness in any situation.
            I look upon you with the extremely affectionate and equitable gaze of 'Mitra' (the Sun or friendly God), free from any bias or malice.
            This mantra teaches the most beautiful lesson of firmness and simplicity in life; even in hardships, we must not waver from truth.
            Crookedness or deceit is the biggest cause of human downfall; the nature of God's devotee is always straight and transparent like water.
            The 'gaze of Mitra' means looking at the whole world with feelings of love, compassion, and friendship, considering no one an enemy.
            Just as the Sun shines equally on all, our vision should also have no unfair discrimination of high-low or big-small.
            O Lord! Give us so much strength that we remain unshakable on our principles, yet our behavior towards others remains extremely gentle and friendly.
            When we look at the world with a friendly vision, the entire universe truly becomes our own family (Vasudhaiva Kutumbakam).
            God also gazes at us with that same loving vision; therefore, we should abandon our inner fears and doubts and become completely fearless.
            May our lives be such that whoever comes in contact with us experiences only peace, harmony, and profound divine love.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 20,
        sanskrit = "अविर्दोहणीर्विद्युद्भवन्तीरूर्म्या आ यजमानाय सन्तु।\nतासामुशिग्भिः प्र भराम्यग्निमृतेन सत्यमृतात्सत्यं प्र भवामि ॥ २० ॥",
        hindiCommentary = """
            वे गौएं (या किरणें) जो कभी नहीं दुही गईं, विद्युत के समान तेजस्विनी और तरंगों वाली होकर यजमान के लिए कल्याणकारी और मंगलमय हों।
            उन कामनाशील शक्तियों के साथ मैं अग्नि को भली-भांति प्रज्वलित करता हूँ; मैं ऋत (सच्चे कर्म) से सत्य को और सत्य से ऋत को उत्पन्न करता हूँ।
            यह मंत्र ऋत (ब्रह्मांडीय नियम/कर्म) और सत्य (शाश्वत तत्व) के बीच के अटूट और गहरे संबंध को अत्यंत स्पष्टता से उद्घाटित करता है।
            सत्य केवल विचार नहीं है, बल्कि जब वह हमारे आचरण में उतरता है, तो वह ऋत बन जाता है; और सही आचरण ही हमें परम सत्य तक ले जाता है।
            विद्युत के समान चेतना हमें आध्यात्मिक जाग्रति देती है, जो हमारे भीतर के अज्ञान को पल भर में नष्ट करने की महान क्षमता रखती है।
            गौओं को यहाँ ज्ञान की रश्मियों (किरणों) का प्रतीक माना गया है, जो हमारी बुद्धि को निरंतर प्रकाशित और ऊर्ध्वगामी करती हैं।
            हे परमात्मा! हमारा प्रत्येक कर्म सत्य पर आधारित हो और हमारे कर्मों के फलस्वरूप समाज में केवल सत्य की ही प्रतिष्ठा और विजय हो।
            सत्य और ऋत के पालन से ही यज्ञ (शुभ कर्म) सफल होता है और यजमान (साधक) को ईश्वरीय शक्तियों का पूर्ण आशीर्वाद प्राप्त होता है।
            हम अज्ञानता के जीवन को त्यागकर उस ज्ञान की ओर बढ़ें जो विद्युत की तरह तीव्र और जल की तरंगों की तरह निरंतर प्रवाहमयी है।
            हमारा पूरा जीवन सत्य से शुरू होकर सत्य पर ही समाप्त हो, ताकि हम ईश्वरीय व्यवस्था के एक श्रेष्ठ और अभिन्न अंग बन सकें।
        """.trimIndent(),
        englishCommentary = """
            May those cows (or rays) that are unmilked, radiant like lightning, and full of waves become beneficial and auspicious for the sacrificer.
            With those desirous forces, I properly kindle the Agni; I manifest Truth from Rta (righteous action) and Rta from Truth.
            This mantra unveils the unbroken and deep relationship between Rta (cosmic law/action) and Truth (eternal reality) with great clarity.
            Truth is not just a thought; when it descends into our conduct, it becomes Rta; and correct conduct leads us to the Ultimate Truth.
            Lightning-like consciousness grants us spiritual awakening, which possesses the great capability to destroy our ignorance in an instant.
            Cows are considered here as symbols of the rays of knowledge, which continuously illuminate and elevate our intellect higher.
            O Supreme Lord! May every action of ours be based on truth, and as a result of our deeds, may only truth be established and victorious in society.
            Only by following Truth and Rta does a sacrifice (noble deed) succeed, and the seeker receives the full blessing of divine forces.
            Let us abandon the life of ignorance and move towards that knowledge which is fast like lightning and continuously flowing like water waves.
            May our entire life start with truth and end in truth, so that we can become an excellent and integral part of the divine cosmic order.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 21,
        sanskrit = "देव सवितः प्र सुव यज्ञं प्र सुव यज्ञपतिं भगाय।\nदिव्यो गन्धर्वः केतपूः केतं नः पुनातु वाचस्पतियों वाचं नः स्वदतु ॥ २१ ॥",
        hindiCommentary = """
            हे प्रकाशमान सविता देव! आप हमारे इस यज्ञ को और यज्ञ के स्वामी (यजमान) को सौभाग्य, ऐश्वर्य और कल्याण की ओर निरंतर प्रेरित करें।
            जो दिव्य गन्धर्व (प्राणशक्ति) हमारे ज्ञान और बुद्धि को पवित्र करने वाला है, वह हमारे संकल्पों और विचारों को पूर्णतः शुद्ध करे।
            वाणी के अधिपति देव (वाचस्पति) हमारी वाणी को अत्यंत मधुर, सत्य और सभी के लिए स्वादिष्ट (कल्याणकारी) बनाने की महान कृपा करें।
            सविता देव ही सभी प्रेरणाओं के स्रोत हैं; जब हमारी प्रेरणा शुद्ध होती है, तभी हमारा कर्म (यज्ञ) फलदायी और समाज के लिए उपयोगी होता है।
            बुद्धि की शुद्धि सबसे अधिक आवश्यक है, क्योंकि यदि विचार मलिन होंगे, तो हमारे कर्म कभी भी श्रेष्ठ या पुण्यदायी नहीं हो सकते।
            गन्धर्व यहाँ उस सूक्ष्म ईश्वरीय शक्ति का प्रतीक है जो हमारे अंतःकरण में ज्ञान का प्रकाश भरकर हमारे विकारों को दूर करती है।
            वाणी की मधुरता मनुष्य का सबसे बड़ा आभूषण है; कटु वाणी से बड़े-बड़े यज्ञ भी विफल हो जाते हैं और पुण्य नष्ट हो जाते हैं।
            हे प्रभु! हमारी जिह्वा पर सदैव वाग्देवी का वास हो, जिससे हम जो भी बोलें, वह दूसरों को शांति, ढांढस और सही मार्ग प्रदान करे।
            हमारा संपूर्ण जीवन एक ऐसा महायज्ञ बन जाए जिससे स्वयं को आत्मज्ञान मिले और संपूर्ण विश्व को सुख, सौभाग्य और समृद्धि प्राप्त हो।
            सच्चा सौभाग्य भौतिक धन नहीं, बल्कि वह निर्मल बुद्धि और सत्यमयी वाणी है जो हमें ईश्वर के साक्षात् स्वरूप के समीप ले जाती है।
        """.trimIndent(),
        englishCommentary = """
            O Luminous Savitar! Continuously inspire this sacrifice of ours and the master of the sacrifice towards good fortune, wealth, and welfare.
            May the divine Gandharva (vital force) who purifies our knowledge and intellect, completely purify our resolutions and thoughts.
            May the Lord of Speech (Vachaspati) graciously make our speech extremely sweet, truthful, and tasty (beneficial) for everyone.
            Savitar is the source of all inspirations; only when our inspiration is pure does our action (sacrifice) become fruitful and useful to society.
            Purification of intellect is most essential, because if thoughts are impure, our actions can never be noble or merit-yielding.
            Gandharva here symbolizes that subtle divine power which fills our inner self with the light of knowledge and removes our flaws.
            Sweetness of speech is a person's greatest ornament; with bitter speech, even great sacrifices fail and merits are quickly destroyed.
            O Lord! May the Goddess of Speech always reside on our tongue, so whatever we speak gives peace, comfort, and the right path to others.
            May our entire life become such a grand sacrifice that grants us self-realization and brings joy, fortune, and prosperity to the whole world.
            True fortune is not material wealth, but that pure intellect and truthful speech which takes us closer to the direct realization of God.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 22,
        sanskrit = "आपो देवीरग्रेपुवो अग्रेगुवोऽग्र इमामद्य यज्ञं नयताग्रे यज्ञपतिं सुधातुम्।\nयुष्मानिन्द्रोऽवृणीत वृत्रतूर्ये यूयमिन्द्रमवृणीध्वं वृत्रतूर्ये प्रोक्षिता स्थ ॥ २२ ॥",
        hindiCommentary = """
            हे दिव्य जल की देवियों! तुम सबसे पहले पवित्र करने वाली और सबसे आगे चलने वाली हो; आज हमारे इस यज्ञ को और यजमान को श्रेष्ठ स्थान पर ले चलो।
            वृत्रासुर (अज्ञान/बाधा) के वध के समय इंद्र ने तुम्हारी शक्ति का वरण किया था, और तुमने भी उस महासंग्राम में इंद्र का पूरा साथ दिया था।
            अब तुम भली-भांति प्रोक्षित (पवित्र) हो चुकी हो; तुम्हारी कृपा से हमारा यह अनुष्ठान सभी विघ्नों को पार कर पूर्णता को प्राप्त हो।
            जल केवल भौतिक प्यास नहीं बुझाता, वह 'अग्रणी' है जो जीवन को निरंतर आगे बढ़ाता है और हर प्रकार की अशुद्धि को धो डालता है।
            वृत्र उस अंधकार और अज्ञान का प्रतीक है जो हमारी चेतना को ढके रहता है; जल रूपी दिव्य ज्ञान ही उस आवरण को नष्ट कर सकता है।
            देवता भी प्रकृति की शक्तियों के सहयोग के बिना असुरों पर विजय प्राप्त नहीं कर सकते, यह प्रकृति और ईश्वर के सामंजस्य का प्रमाण है।
            हे परमात्मा! हमारे जीवन की धारा भी जल की तरह स्वच्छ हो और हम भी समाज की बुराइयों से लड़ने में सत्य का ही साथ दें।
            जैसे जल ऊंच-नीच का भेद किए बिना सभी को जीवन देता है, वैसे ही हमारा प्रेम और सेवा भाव भी सभी के लिए समान और निष्काम हो।
            हम स्वयं को इस दिव्य जल से सींच कर अपनी आत्मा को अज्ञान के वृत्र से मुक्त करें और परम स्वतंत्र तथा ज्ञानी बनें।
            जल की बूंद-बूंद में छिपी वह असीम शक्ति हमारे भीतर भी ऐसे ही जागृत हो जो हमें जीवन के सर्वोच्च और पवित्र लक्ष्यों तक पहुँचा दे।
        """.trimIndent(),
        englishCommentary = """
            O Goddesses of divine waters! You are the first to purify and the foremost to lead; today, lead this sacrifice and its master to the highest state.
            During the slaying of Vritra (ignorance/obstacle), Indra chose your power, and you too fully supported Indra in that great battle.
            Now you have been thoroughly consecrated (purified); by your grace, may this ritual cross all hurdles and achieve absolute perfection.
            Water not only quenches physical thirst, it is the 'leader' that continuously moves life forward and washes away every kind of impurity.
            Vritra symbolizes that darkness and ignorance which covers our consciousness; only the divine knowledge resembling water can destroy that veil.
            Even gods cannot conquer demons without the cooperation of nature's forces; this proves the profound harmony between Nature and God.
            O Supreme Lord! May the stream of our lives be as clean as water, and may we too side with Truth in fighting the evils of society.
            Just as water gives life to all without discrimination of high and low, may our love and service be equal and selfless for everyone.
            Let us irrigate ourselves with this divine water to free our souls from the Vritra of ignorance, becoming perfectly free and wise.
            May that infinite power hidden in every drop of water awaken within us, taking us directly to the highest and holiest goals of life.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 23,
        sanskrit = "अविर्दोहणीर्विद्युद्भवन्तीरूर्म्या आ यजमानाय सन्तु।\nतासामुशिग्भिः प्र भराम्यग्निमृतेन सत्यमृतात्सत्यं प्र भवामि ॥ २३ ॥",
        hindiCommentary = """
            (मंत्र २० की पुनरावृत्ति विशेष कर्म के लिए) वे प्रकाशमयी और निर्दोष किरणें यजमान के लिए अत्यंत कल्याणकारी और सुखदायी सिद्ध हों।
            उन शुभ शक्तियों की सहायता से मैं अग्नि को पुनः जाग्रत करता हूँ; मैं ऋत (सच्चाई के नियम) के द्वारा ही सत्य को जीवन में स्थापित करता हूँ।
            वैदिक कर्मकांड में कुछ मंत्रों की पुनरावृत्ति इस बात पर बल देने के लिए होती है कि जीवन में शुभ संकल्पों को बार-बार दोहराना चाहिए।
            अग्नि को जाग्रत करने का अर्थ है अपनी आत्मा की चेतना को प्रज्वलित करना, जो संसार की मोह-माया में अक्सर सुप्त और ठंडी पड़ जाती है।
            सत्य कोई अमूर्त वस्तु नहीं है; जब हम धर्मपूर्ण कर्म (ऋत) करते हैं, तो वही कर्म सजीव होकर हमारे लिए परम सत्य बन जाता है।
            हम जो भी कामना करें, वह विद्युत की तरह शुद्ध और तीव्र हो, और उसमें किसी के अहित का कोई भी भाव कभी भी न छिपा हो।
            हे देव! हमारी बुद्धि को उन गौओं (ज्ञान-रश्मियों) के समान बनाएं जो निरंतर अमृत (ज्ञान) देती हैं और कभी भी शुष्क या खाली नहीं होतीं।
            बार-बार सत्य का स्मरण ही मनुष्य को माया के भ्रमजाल से निकाल सकता है और उसे उसके वास्तविक स्वरूप का साक्षात् दर्शन करा सकता है।
            यह यज्ञ केवल बाहर का अग्निहोत्र नहीं है, यह हमारे भीतर चल रहा वह अखंड अनुष्ठान है जो हमें ईश्वरीय ज्योति से पूरी तरह जोड़ता है।
            हमारा संकल्प इतना शक्तिशाली हो कि हम अपने और समाज के जीवन में अज्ञान के गहन अंधकार को समाप्त कर शाश्वत सत्य की ही स्थापना करें।
        """.trimIndent(),
        englishCommentary = """
            (Repetition of Mantra 20 for a specific rite) May those luminous and flawless rays prove to be extremely beneficial and joyful for the sacrificer.
            With the help of those auspicious forces, I reawaken the Agni; I establish Truth in life solely through Rta (the law of righteousness).
            In Vedic rituals, the repetition of certain mantras emphasizes that noble resolutions must be repeatedly reiterated in our lives.
            Awakening Agni means igniting the consciousness of our soul, which often becomes dormant and cold amidst the illusions of the world.
            Truth is not an abstract thing; when we perform righteous actions (Rta), that action comes alive and becomes the Ultimate Truth for us.
            Whatever we desire, let it be pure and intense like lightning, and let it never conceal any feeling of harm towards anyone at all.
            O God! Make our intellect like those cows (rays of knowledge) that continuously give nectar (wisdom) and never become dry or empty.
            Only the repeated remembrance of Truth can pull a human out of the web of illusion and provide a direct vision of their true nature.
            This sacrifice is not just an external Agnihotra; it is the unbroken ritual going on within us that fully connects us to the divine light.
            May our resolve be so powerful that we end the deep darkness of ignorance in our and society's lives, establishing only eternal Truth.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 24,
        sanskrit = "अदित्यास्त्वा पृष्ठे सादयाम्यन्तरिक्षस्य धर्त्रीम्।\nविष्तम्भोऽसि दिशो भानुनाऽऽपृण ॥ २४ ॥",
        hindiCommentary = """
            हे यज्ञपात्र! मैं तुम्हें माता अदिति (पृथ्वी/अखंड सत्ता) की पीठ पर स्थापित करता हूँ, जो इस पूरे अंतरिक्ष को धारण करने वाली महान शक्ति है।
            तू यज्ञ का मुख्य आधार (विष्कम्भ) है; अपनी दिव्य ज्योति और तेज से तू सभी दिशाओं को पूरी तरह से प्रकाशित कर दे।
            पृथ्वी केवल मिट्टी नहीं है, वह 'अदिति' है जो संपूर्ण ब्रह्मांड के भार को सहन करती है; हमारा भी आधार यही अनंत ईश्वरीय सत्ता है।
            जब हम किसी शुभ कार्य की स्थापना करते हैं, तो हमें यह विश्वास होना चाहिए कि उसे स्वयं परमात्मा की पीठ (सहारे) पर रखा गया है।
            आधार के बिना कोई भी निर्माण टिक नहीं सकता; धर्म ही हमारे जीवन का वह सच्चा विष्कम्भ है जो हमें पतन के मार्ग से सदैव बचाता है।
            यह ज्योति केवल भौतिक प्रकाश नहीं है, बल्कि यह वह आत्मज्ञान है जो हमारी अज्ञानता की दिशाओं को ज्ञान के प्रकाश से भर देता है।
            हे प्रभु! हमें वह तेजस्विता प्रदान करें जिससे हमारे श्रेष्ठ विचार और शुभ कर्म चारों दिशाओं में फैलकर मानवता का निरंतर कल्याण करें।
            हम जो भी ग्रहण करें, उसे धारण करने की क्षमता भी विकसित करें, क्योंकि क्षमता के बिना प्राप्त ऐश्वर्य भी मनुष्य का विनाश ही करता है।
            अखंड सत्ता से जुड़ने पर ही हमारी आत्मा भी अखंडित और अमर हो जाती है, जो कि योग और वैदिक ज्ञान का अंतिम और परम लक्ष्य है।
            हमारा जीवन ऐसा दीप बने जो स्वयं जलकर दूसरों के मार्गों को प्रकाशित करे और संसार के सभी कोनों तक प्रेम और शांति की किरणें पहुँचाए।
        """.trimIndent(),
        englishCommentary = """
            O Sacrificial Vessel! I place you upon the back of Mother Aditi (Earth/Boundless Reality), who is the great power upholding this entire space.
            You are the main pillar (Vishkambha) of the sacrifice; fill and illuminate all directions completely with your divine light and brilliance.
            Earth is not just soil; she is 'Aditi' who bears the weight of the whole universe; our foundation too is this infinite divine reality.
            When we establish any auspicious work, we must have faith that it is placed directly on the back (support) of the Supreme Lord.
            No structure can stand without a base; Dharma is that true pillar of our lives which forever saves us from the path of downfall.
            This light is not just physical illumination, but the Self-knowledge that fills the directions of our ignorance with the light of wisdom.
            O Lord! Grant us that brilliance so our noble thoughts and auspicious deeds spread in all directions, continuously benefiting humanity.
            Whatever we receive, we must also develop the capacity to hold it, because wealth attained without capacity only destroys a person.
            Only by connecting with the Boundless Reality does our soul also become unbroken and immortal, which is the ultimate goal of Yoga and Vedas.
            May our life become a lamp that burns itself to illuminate others' paths and sends rays of love and peace to all corners of the world.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 25,
        sanskrit = "शर्मास्यवधूतं रक्षोऽवधूता अरातयः।\nअदित्यास्त्वोपस्थे सादयामि ॥ २५ ॥",
        hindiCommentary = """
            हे कृष्णमृगचर्म (यज्ञ का आसन)! तू सुख और शरण देने वाला है; तेरे प्रभाव से सभी राक्षस (बाधाएं) दूर फेंक दिए गए हैं और शत्रुओं का नाश हो गया है।
            अब मैं तुम्हें माता अदिति (अखंड और पावन पृथ्वी) की गोद (उपस्थ) में अत्यंत आदर और श्रद्धा के साथ स्थापित करता हूँ।
            यज्ञ में बिछाया जाने वाला आसन 'शर्म' (सुख/शांति) का प्रतीक है; जब हम साधना में बैठते हैं, तो सबसे पहले मन की स्थिरता आवश्यक है।
            राक्षस और अराति (कृपणता) वास्तव में हमारे मानसिक चंचलता और स्वार्थ के प्रतीक हैं, जिन्हें ध्यान के आसन पर बैठने से पूर्व त्यागना होता है।
            अदिति की गोद का अर्थ है कि हम स्वयं को उस परम सत्ता के प्रति पूर्णतः समर्पित कर दें, जैसे एक शिशु अपनी माता की गोद में सुरक्षित अनुभव करता है।
            शरण की यह भावना साधक के भीतर से हर प्रकार के भय, चिंता और तनाव को निकालकर उसे एक असीम मानसिक शांति प्रदान करती है।
            हे परमात्मा! हमारे मन रूपी आसन को ऐसा पवित्र बनाएं कि उस पर बैठकर हम केवल आपके ही दिव्य स्वरूप का निरंतर और एकाग्र ध्यान कर सकें।
            बुराइयों को दूर फेंकने के लिए केवल विचार पर्याप्त नहीं, बल्कि एक दृढ़ संकल्प और कठोर आत्म-अनुशासन की सबसे अधिक आवश्यकता होती है।
            हम प्रकृति की गोद में बैठकर ही प्रकृति के स्वामी को जान सकते हैं; इसलिए प्रकृति के प्रति हमारा रवैया सदैव आदर और सम्मानपूर्ण होना चाहिए।
            हमारा जीवन भी ऐसा 'शर्म' बने जो दुखी और पीड़ित मानवता को अपनेपन की शीतल छाया और परम आश्रय प्रदान कर सके।
        """.trimIndent(),
        englishCommentary = """
            O Black Antelope Skin (Sacrificial Seat)! You are the giver of joy and refuge; by your power, all demons (obstacles) are cast away and enemies destroyed.
            Now I place you with utmost respect and devotion into the lap (Upastha) of Mother Aditi (the unbroken and holy Earth).
            The seat laid in the sacrifice symbolizes 'Sharma' (joy/peace); when we sit for spiritual practice, mental stability is needed first.
            Demons and Arati (miserliness) actually symbolize our mental restlessness and selfishness, which must be discarded before sitting in meditation.
            Aditi's lap means that we completely surrender ourselves to that Supreme Reality, just as an infant feels safe in its mother's lap.
            This feeling of taking refuge removes every kind of fear, worry, and stress from the seeker, granting immense mental peace.
            O Supreme Lord! Make our mind's seat so pure that sitting upon it, we can continuously and with focus meditate only on Your divine form.
            To cast away evils, mere thoughts are not enough; a firm resolve and strict self-discipline are what is required the absolute most.
            We can know the Lord of Nature only by sitting in Nature's lap; hence our attitude towards nature should always be full of respect and honor.
            May our life also become such a 'Sharma' that it can provide the cool shade of belongingness and supreme refuge to sorrowful and suffering humanity.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 26,
        sanskrit = "अग्नेर्वेपेन त्वा गृह्णामि मखस्य शिरोऽसि।\nसम्पृच्यध्वमृतावरीरूर्मिणीर्मधुमत्तमाः ॥ २६ ॥",
        hindiCommentary = """
            हे यज्ञ पात्र! मैं अग्नि के तीव्र तेज और कंपन (प्रेरणा) के साथ तुम्हें ग्रहण करता हूँ; तुम इस महान यज्ञ (मख) के मस्तक (सर्वोच्च अंग) हो।
            हे जल की पावन धाराओं! तुम सत्य से युक्त, लहरों वाली और अत्यंत मधुर हो; तुम सब एक साथ भली-भांति मिलकर इस कार्य को सफल बनाओ।
            अग्नि का 'वेप' (कंपन) हमारे भीतर उस आध्यात्मिक ऊर्जा और उत्साह का प्रतीक है जो हमें किसी भी श्रेष्ठ कार्य को करने के लिए प्रेरित करता है।
            मख का शिर (यज्ञ का मस्तक) होने का अर्थ है कि हमारे सभी साधन और कर्म उस परम लक्ष्य की ओर ही केंद्रित होने चाहिए।
            जल की धाराओं के मिलने का आह्वान समाज में एकता, सद्भाव और सामूहिक पुरुषार्थ की भावना को अत्यंत सुंदर रूप से दर्शाता है।
            अकेला व्यक्ति कुछ नहीं कर सकता, लेकिन जब सत्य और मधुरता से भरे हुए लोग एक साथ मिलते हैं, तो कोई भी महान यज्ञ (कार्य) सफल हो जाता है।
            हे देव! हमारे भीतर अग्नि के समान ऊर्जा हो और हमारे स्वभाव में जल के समान शीतलता और सबको साथ लेकर चलने की अद्भुत क्षमता हो।
            हम जो भी विचार ग्रहण करें, वे इतने श्रेष्ठ हों कि वे हमारे जीवन रूपी अनुष्ठान के मुकुट (शिर) बन जाएं और हमें हमेशा सही राह दिखाएं।
            सत्य (ऋत) ही वह गोंद है जो समाज की विभिन्न धाराओं को एक सूत्र में बांधकर रख सकता है, अन्यथा स्वार्थ सबको अलग कर देता है।
            हम प्रार्थना करते हैं कि हमारे सम्मिलित प्रयासों से एक ऐसा समाज बने जो प्रेम और सत्य के रस से पूरी तरह ओत-प्रोत हो।
        """.trimIndent(),
        englishCommentary = """
            O Sacrificial Vessel! I accept you with the intense brilliance and vibration (inspiration) of Agni; you are the head (supreme part) of this great sacrifice (Makha).
            O sacred streams of water! You are endowed with truth, wavy, and exceedingly sweet; all of you mingle well together to make this task successful.
            The 'Vepa' (vibration) of Agni symbolizes that spiritual energy and enthusiasm within us which inspires us to perform any noble deed.
            Being the head of Makha (the head of sacrifice) means that all our tools and actions must be focused purely on that ultimate goal.
            The invocation of water streams merging beautifully illustrates the feeling of unity, harmony, and collective effort in society.
            A lone person cannot do much, but when people filled with truth and sweetness unite, any great sacrifice (mission) becomes successful.
            O God! Let there be energy like Agni within us, and in our nature, coolness like water and the amazing ability to take everyone along.
            Whatever thoughts we accept, let them be so noble that they become the crown (head) of our life's ritual and always show us the right path.
            Truth (Rta) is the very glue that can bind the diverse streams of society into one thread, otherwise selfishness separates everyone entirely.
            We pray that through our united efforts, a society is formed that is completely permeated with the essence of pure love and ultimate truth.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 27,
        sanskrit = "मखस्य शिरोऽसि।\nसं त्वा सिञ्चामि यजुषा प्रजामैश्वर्यं च ॥ २७ ॥",
        hindiCommentary = """
            तू इस महान यज्ञ का मस्तक (शिर) है।
            मैं इन पवित्र यजुर्मंत्रों के द्वारा तुझे भली-भांति सींचता (संस्कारित करता) हूँ, ताकि तू हमें उत्तम प्रजा (संतान) और महान ऐश्वर्य प्रदान कर सके।
            यज्ञ का शिर होने का अर्थ है कि हमारा विवेक हमेशा जाग्रत रहे, क्योंकि बिना विवेक के किया गया कोई भी कर्म दिशाहीन ही होता है।
            'सिंचन' का अर्थ केवल जल छिड़कना नहीं, बल्कि मंत्रों की शक्ति से अपने अंतःकरण को दिव्य भावों और ईश्वरीय ज्ञान से भिगोना है।
            वैदिक धर्म में भौतिक ऐश्वर्य और उत्तम संतान की कामना को पाप नहीं माना गया है, बशर्ते वह धर्म के मार्ग से और यज्ञीय भाव से प्राप्त की गई हो।
            अच्छी प्रजा का अर्थ केवल अपनी संतान नहीं, बल्कि एक ऐसा श्रेष्ठ समाज बनाना है जो भविष्य में भी धर्म और सत्य के मार्ग पर चलता रहे।
            हे प्रभु! हमारे मस्तिष्क को यजुर्वेद के ज्ञान से ऐसे सींच दें कि उसमें कभी भी अज्ञान और अहंकार रूपी खरपतवार न उगने पाए।
            हम जो भी संपत्ति प्राप्त करें, उसका उपयोग समाज के मंगल के लिए हो, क्योंकि तभी वह सच्चा ऐश्वर्य कहलाता है, अन्यथा वह विनाश का कारण बनता है।
            मंत्रों के सिंचन से मनुष्य की आत्मा शुद्ध होती है और उसकी कार्यक्षमता कई गुना बढ़ जाती है, जिससे उसे हर क्षेत्र में पूर्ण सफलता मिलती है।
            हमारा जीवन इस यज्ञ के समान ऐसा उन्नत हो कि हम स्वयं के साथ-साथ आने वाली पीढ़ियों के लिए भी एक आदर्श और समृद्ध भविष्य छोड़ सकें।
        """.trimIndent(),
        englishCommentary = """
            You are the head (Murdha) of this great sacrifice.
            I thoroughly sprinkle (consecrate) you with these holy Yajur mantras, so that you may grant us excellent progeny and great prosperity.
            Being the head of the sacrifice means our discernment must always remain awake, because any action done without wisdom is totally directionless.
            'Sprinkling' does not just mean throwing water, but soaking our inner conscience with divine feelings and Godly knowledge through the power of mantras.
            In Vedic Dharma, desiring material wealth and good offspring is not a sin, provided it is attained through the path of Dharma and sacrificial spirit.
            Good progeny means not just our children, but creating an excellent society that continues to walk the path of Dharma and Truth in the future.
            O Lord! Irrigate our brains with the knowledge of Yajurveda so that the weeds of ignorance and ego may never sprout within it.
            Whatever wealth we acquire, may it be used for the welfare of society, because only then is it true prosperity; otherwise, it causes destruction.
            Sprinkling of mantras purifies the human soul and multiplies its working capacity, granting it absolute success in every single field.
            May our life be as elevated as this sacrifice, so we leave behind an ideal and prosperous future for ourselves and the coming generations.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 28,
        sanskrit = "घृतवतोर्मिणा मधुमता सम्प्रच्यध्वम्।\nअपहतोऽररुः पृथिव्यै ॥ २८ ॥",
        hindiCommentary = """
            हे जल की धाराओं! तुम घृत (घी) के समान स्निग्ध और मधुरता से भरी हुई तरंगों के साथ एक-दूसरे में भली-भांति मिल जाओ।
            इस पृथ्वी से अररु (विघ्नकर्ता दानव या नकारात्मक विचार) को पूरी तरह से नष्ट कर दिया गया है और बहुत दूर धकेल दिया गया है।
            जल और घी का संगम जीवन में कोमलता, प्रेम और पुष्टि का प्रतीक है; कठोरता से नहीं, बल्कि मधुरता से ही दिलों को जोड़ा जा सकता है।
            जब समाज के विभिन्न वर्ग बिना किसी कटुता के आपस में प्रेम से मिलते हैं, तो वह समाज वास्तव में देवतुल्य और शक्तिशाली हो जाता है।
            अररु वह असुर है जो हमारे भीतर ईर्ष्या और नफरत पैदा करता है; उसे अपने मन से बाहर निकालना ही सबसे बड़ी और सच्ची आध्यात्मिक विजय है।
            पृथ्वी हमारी कर्मभूमि है, यदि यह नकारात्मकताओं से मुक्त होगी, तभी हमारे सभी शुभ संकल्प और कार्य सफलतापूर्वक फलित हो सकेंगे।
            हे परमात्मा! हमारे संबंधों में घी के समान स्निग्धता हो ताकि मनमुटाव का घर्षण कभी भी हमारे प्रेम के बंधन को तोड़ न सके।
            विघ्नों का नाश बाहरी हथियारों से नहीं, बल्कि हमारे भीतर की एकता और पवित्र विचारों की शक्ति से ही संभव है, यही इस मंत्र का संदेश है।
            हम अपने कार्यस्थल और घर को ऐसा पवित्र बनाएं कि वहां बुराइयां प्रवेश करने का साहस ही न कर सकें और केवल सकारात्मक ऊर्जा का वास हो।
            मधुरता और प्रेम की धारा जब बहती है, तो वह सबसे कठोर हृदय को भी पिघलाकर ईश्वर की ओर उन्मुख करने की अद्भुत सामर्थ्य रखती है।
        """.trimIndent(),
        englishCommentary = """
            O streams of water! Mingle well with one another with waves that are as smooth as Ghee (clarified butter) and fully saturated with sweetness.
            The Araru (the obstacle-creating demon or negative thoughts) has been completely destroyed and pushed far away from this earth.
            The confluence of water and Ghee symbolizes gentleness, love, and nourishment in life; hearts can be united only through sweetness, not harshness.
            When various sections of society meet each other with love and without bitterness, that society truly becomes godlike and incredibly powerful.
            Araru is the demon that creates envy and hatred within us; expelling him from our mind is the greatest and truest spiritual victory.
            The earth is our field of action; if it is free from negativities, only then can all our auspicious resolutions and actions successfully bear fruit.
            O Supreme Lord! May our relationships have the smoothness of Ghee so that the friction of disagreements can never break our bond of pure love.
            The destruction of obstacles is possible not by external weapons, but solely through our inner unity and the power of pure thoughts.
            Let us make our workplace and home so sacred that evils don't even dare to enter, and only positive energy continuously resides there.
            When the stream of sweetness and love flows, it possesses the amazing capability to melt even the hardest heart and turn it towards the Divine.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 29,
        sanskrit = "व्रतेन दीक्षामाप्नोति दीक्षयाऽऽप्नोति दक्षिणाम्।\nदक्षिणा श्रद्धामाप्नोति श्रद्धया सत्यमाप्यते ॥ २९ ॥",
        hindiCommentary = """
            (सत्य की स्थापना के लिए इस मंत्र की पुनः आवृत्ति) मनुष्य व्रत (सच्चे संकल्प) से दीक्षा प्राप्त करता है, और दीक्षा के कठोर पालन से दक्षिणा (सफलता) मिलती है।
            उस सफलता से हृदय में गहरी श्रद्धा जाग्रत होती है, और जब श्रद्धा अटल हो जाती है, तभी मनुष्य परम सत्य का साक्षात् अनुभव कर पाता है।
            वैदिक परंपरा में यह मंत्र मनुष्य के आध्यात्मिक विकास का अचूक सूत्र है; संकल्प के बिना किसी भी यात्रा का आरंभ कभी संभव नहीं है।
            दीक्षा हमें एक निश्चित नियम और अनुशासन में बांधती है, जो हमारे बिखरे हुए मन को एकाग्र कर हमारी शक्तियों को एक सही दिशा देती है।
            कर्म का जो फल (दक्षिणा) हमें मिलता है, वह कोई भौतिक पुरस्कार नहीं, बल्कि हमारी आत्मिक उन्नति का वह संतोष है जो हमें और आगे बढ़ाता है।
            सफलता से उपजा हुआ विश्वास (श्रद्धा) हमें ईश्वर के न्याय पर पूर्ण भरोसा करना सिखाता है, जिससे जीवन के सभी संशय हमेशा के लिए मिट जाते हैं।
            सत्य कोई वस्तु नहीं है जिसे पाया जा सके; यह वह अवस्था है जहाँ पहुंचने पर साधक स्वयं सत्य स्वरूप (ब्रह्ममय) हो जाता है।
            हे देव! हमें संकल्प में दृढ़ता और कर्म में ऐसा अनुशासन दें कि हमारे भीतर की श्रद्धा कभी भी सांसारिक दुखों या लालच से डगमगाए नहीं।
            जब हम सत्य को प्राप्त कर लेते हैं, तब हमें ज्ञात होता है कि संसार की सभी भौतिक वस्तुएं उस परम आनंद के सामने अत्यंत तुच्छ और नश्वर हैं।
            हमारा यह व्रत अखंड रहे कि हम असत्य का त्याग कर सदैव सत्य का ही आचरण करेंगे, क्योंकि सत्य ही ईश्वर तक पहुँचने का एकमात्र मार्ग है।
        """.trimIndent(),
        englishCommentary = """
            (Repetition for establishing Truth) By a vow (firm resolve), one obtains initiation; by strict initiation, one naturally obtains the sacrificial fee (success).
            From that success, deep faith is awakened in the heart, and when faith becomes unwavering, one directly experiences the Supreme Truth.
            In the Vedic tradition, this mantra is the infallible formula for human spiritual development; without resolve, starting any journey is never possible.
            Initiation binds us in a certain rule and discipline, which concentrates our scattered mind and gives our powers a correct and focused direction.
            The fruit of action (Dakshina) we receive is not a material reward, but that satisfaction of our spiritual progress which pushes us further ahead.
            The trust (faith) born from success teaches us to fully rely on God's justice, eradicating all doubts of life forever and completely.
            Truth is not an object to be found; it is that state reaching which the seeker himself becomes the embodiment of Truth (Brahman).
            O God! Give us firmness in resolve and such discipline in action that the faith within us never wavers due to worldly sorrows or greed.
            When we attain Truth, we realize that all material things of the world are extremely trivial and perishable compared to that supreme bliss.
            May this vow of ours remain unbroken: that we shall abandon untruth and always practice Truth, for Truth is the only path to reach the Divine.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 30,
        sanskrit = "इदमहमनृतात्सत्यमुपैमि।\nसुवरभि वि ख्येषं वैश्वानरं ज्योतिः ॥ ३0 ॥",
        hindiCommentary = """
            मैं इस यज्ञ और संकल्प के माध्यम से असत्य (अज्ञान, बुराई और मिथ्याचार) को पूरी तरह त्याग कर शाश्वत सत्य की ओर प्रस्थान करता हूँ।
            मैं उस स्वः (स्वर्ग या परम आनंद) को प्राप्त करूँ और वैश्वानर (सबके भीतर स्थित) ईश्वरीय ज्योति का प्रत्यक्ष और स्पष्ट दर्शन करूँ।
            यह प्रथम अध्याय के समापन की ओर ले जाने वाला एक अत्यंत शक्तिशाली उद्घोष है, जिसमें साधक अपनी आध्यात्मिक यात्रा का चरम लक्ष्य निर्धारित करता है।
            असत्य केवल झूठ नहीं है, बल्कि यह संसार की वह नश्वर माया है जो हमें ईश्वर से दूर रखती है; इसे छोड़ना ही मोक्ष की पहली सीढ़ी है।
            स्वर्ग यहाँ किसी दूसरे लोक का नहीं, बल्कि हमारी चेतना की उस उच्च अवस्था का वर्णन है जहाँ कोई दुख, भय या द्वेष शेष नहीं रहता।
            वैश्वानर ज्योति वह आत्मप्रकाश है जो हर प्राणी के भीतर मौजूद है; जब हम इसे पहचान लेते हैं, तो सभी जीवों में हमें ईश्वर ही दिखाई देता है।
            हे प्रभु! मेरे अज्ञान के सारे परदे हटा दें ताकि मैं उस दिव्य प्रकाश को देख सकूं जो कभी बुझता नहीं और जो जीवन का सच्चा मार्गदर्शक है।
            यज्ञ का अंतिम उद्देश्य कुछ प्राप्त करना नहीं, बल्कि स्वयं को उस परम सत्य में विलीन कर देना है, जहाँ 'मैं' और 'तू' का कोई भी भेद नहीं रह जाता।
            हम बाहरी अंधकार से डरते हैं, लेकिन अज्ञान का भीतरी अंधकार अधिक भयानक है; वैश्वानर ज्योति ही उस अंधकार को समूल नष्ट कर सकती है।
            हमारा यह जीवन सत्य के प्रकाश से इतना जगमगा जाए कि मृत्यु भी हमें अंधकार में न धकेल सके, और हम अमरत्व के परमानंद को प्राप्त करें।
        """.trimIndent(),
        englishCommentary = """
            Through this sacrifice and resolve, I completely abandon untruth (ignorance, evil, and falsehood) and depart towards the Eternal Truth.
            May I attain that 'Svar' (heaven or supreme bliss) and directly and clearly behold the Vaishvanara (omnipresent) divine light.
            This is an extremely powerful declaration leading towards the conclusion of the first chapter, setting the ultimate goal of the spiritual journey.
            Untruth is not just lying, but the perishable illusion of the world that keeps us away from God; abandoning it is the first step to liberation.
            Heaven here is not another world, but a description of that high state of our consciousness where no sorrow, fear, or malice remains.
            The Vaishvanara light is that soul-illumination present within every being; when we recognize it, we see only God in all living creatures.
            O Lord! Remove all the veils of my ignorance so I can see that divine light which never extinguishes and is the true guide of life.
            The ultimate purpose of the sacrifice is not to attain something, but to merge oneself into that Supreme Truth where no difference of 'I' and 'You' remains.
            We fear external darkness, but the internal darkness of ignorance is far more terrifying; only the Vaishvanara light can uproot it completely.
            May this life of ours shine so brightly with the light of Truth that even death cannot push us into darkness, and we attain the bliss of immortality.
        """.trimIndent()
    ),
    ShuklaYajurVerse(
        id = 31,
        sanskrit = "व्रतं कृणुताव्रतं कृणुताव्रतं कृणुता।\nअग्ने व्रतपते व्रतं चरिष्यामि तच्छकेयं तन्मे राध्यताम् ॥ ३१ ॥\n(नोट: यह प्रथम अध्याय का अन्तिम मन्त्र है।)",
        hindiCommentary = """
            हे ऋत्विजों! आप सब व्रत (संकल्प) करें, व्रत करें, व्रत करें।
            हे व्रतों के अधिपति अग्निदेव! मैं सत्य और धर्म के पालन का व्रत करूँगा; मुझे इसे पूर्ण करने की सामर्थ्य प्रदान करें और मेरा यह अनुष्ठान सफल हो।
            यह प्रथम अध्याय का अंतिम और पूर्णता सूचक मंत्र है, जो संपूर्ण यज्ञ को एक व्यक्तिगत और सामूहिक संकल्प (व्रत) का रूप दे देता है।
            यज्ञ केवल आहुति देना नहीं है, बल्कि जीवन भर श्रेष्ठ कर्म करने की एक अटल प्रतिज्ञा है।
            अग्नि को साक्षी मानकर लिया गया संकल्प मनुष्य को कभी भी पाप या अधर्म के मार्ग पर नहीं जाने देता।
            यहाँ 'व्रत' का अर्थ है ईश्वरीय नियमों (ऋत) का स्वेच्छा से और पूरी निष्ठा के साथ पालन करना।
            हे प्रभु! प्रथम अध्याय के इस समापन पर हम यह प्रण लेते हैं कि हमारा जीवन सदा आपके निर्देशों और सत्य के प्रकाश में ही व्यतीत होगा।
            अज्ञान का त्याग कर ज्ञान की ओर जाना ही मनुष्य का सबसे बड़ा व्रत है, और यही दर्शपूर्णमास यज्ञ का वास्तविक आध्यात्मिक संदेश है।
            इस मंत्र के साथ बाहरी यज्ञ की वेदी पूर्ण होती है और साधक के हृदय में आत्म-यज्ञ की ज्योति सदैव के लिए प्रज्वलित हो जाती है।
            ॐ शान्तिः शान्तिः शान्तिः।
        """.trimIndent(),
        englishCommentary = """
            O Priests! Observe the vow, observe the vow, observe the vow!
            O Agni, Lord of Vows! I shall practice the vow of truth and Dharma; may I have the capacity for it, and may it succeed for me.
            This is the final, completing mantra of the first chapter, turning the entire sacrifice into a deeply personal and collective resolve (Vrata).
            Sacrifice is not just offering oblations; it is an unbreakable pledge to perform noble deeds throughout one's entire life.
            A resolution taken with Agni as the witness never allows a human to stray onto the path of sin or unrighteousness.
            Here, 'Vrata' means following the divine laws (Rta) voluntarily and with absolute, unwavering loyalty.
            O Lord! At the conclusion of this first chapter, we pledge that our lives will always be spent in the light of Your commands and Truth.
            Abandoning ignorance and moving towards knowledge is humanity's greatest vow, and this is the true spiritual message of the sacrifice.
            With this mantra, the external altar is completed, and the flame of self-sacrifice is eternally ignited within the seeker's heart.
            Om Shanti Shanti Shanti.
        """.trimIndent()
    )
)