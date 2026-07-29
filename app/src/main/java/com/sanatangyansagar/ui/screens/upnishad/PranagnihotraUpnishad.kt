package com.sanatangyansagar.ui.screens.upnishad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PranagnihotraUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Range updated for 1 to 23
                if (shlokaNumber != null && shlokaNumber in 1..23) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-23)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Hooking up the data layer object you just created
            items(PranagnihotraUpnishad.shlokasList) { shloka ->
                PranagnihotraShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun PranagnihotraShlokaCard(shloka: PranagnihotraShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Shloka ${shloka.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = shloka.sanskrit,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = shloka.hindi,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = shloka.english,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
// Data Model for Pranagnihotra Shlokas
data class PranagnihotraShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

object PranagnihotraUpnishad {

    val shlokasList = listOf(
        PranagnihotraShloka(
            id = 1,
            sanskrit = "अथातः प्राणग्निहोत्रविधिं व्याख्यास्यामः । सर्ववेदान्तसारसङ्ग्रहम् ।",
            hindi = """
                (प्राणाग्निहोत्र का आरंभ): यहाँ से हम प्राणाग्निहोत्र की परम रहस्यमयी और पवित्र विधि की व्याख्या शुरू करते हैं।
                यह कोई साधारण कर्मकांड नहीं है, बल्कि समस्त उपनिषदों और वेदांत का निचोड़ (सार) है।
                दुनिया के लोग बाहरी कुंडों में आग जलाकर घी की आहुति देते हैं, जिसे बाह्य यज्ञ कहा जाता है।
                लेकिन ऋषियों ने सबसे बड़े यज्ञ को इंसान के अपने ही शरीर के भीतर खोज लिया है।
                इस ब्रह्मांड का सबसे पवित्र हवन कुंड मनुष्य का अपना पेट (जठराग्नि) है।
                इसमें डाली जाने वाली हर आहुति (भोजन) सीधे आत्मा और प्राणों को तृप्त करती है।
                जो इस रहस्य को जान लेता है, उसे जीवन में कभी कोई बाहरी कर्मकांड करने की आवश्यकता नहीं रह जाती।
                यह शरीर ही साक्षात मंदिर है, और इसके भीतर धड़कने वाली चेतना ही साक्षात परब्रह्म है।
                जब इंसान भोजन को मात्र भूख मिटाने का साधन न मानकर उसे यज्ञ की आहुति मान लेता है, 
                तब उसका हर निवाला उसे मोक्ष की ओर ले जाने वाला महा-साधन बन जाता है।
            """.trimIndent(),
            english = """
                (The Beginning of Pranagnihotra): From this exact moment, we commence the profound exposition of the sacred Pranagnihotra ritual.
                This is not a superficial external ceremony; it is the absolute essence and ultimate conclusion of all Vedanta.
                Ordinary humanity lights physical fires in brick altars to offer clarified butter, performing external sacrifices.
                However, the ancient enlightened sages discovered the most colossal sacrifice existing entirely within the human body.
                The most sacred sacrificial fire pit in the cosmos is the human stomach (Jatharagni - the digestive fire).
                Every single morsel of food offered into it directly satisfies the vital life forces and the Supreme Soul.
                He who completely realizes this profound secret never again requires any external physical rituals or religious ceremonies.
                This biological physical body is the literal temple, and the consciousness throbbing inside is the Supreme Brahman.
                When a human stops viewing food merely as a cure for hunger and begins seeing it as a divine sacrificial offering,
                Every single bite he takes becomes a supreme instrument propelling him violently toward absolute liberation (Moksha).
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 2,
            sanskrit = "शरीरं देवालयः प्रोक्तो जीवो देवः सनातनः । त्यजेदज्ञाननिर्माल्यं सोऽहंभावेन पूजयेत् ॥",
            hindi = """
                (शरीर साक्षात देवालय है): उपनिषद यहाँ सबसे बड़ी और प्रलयंकारी घोषणा करता है कि यह भौतिक शरीर कोई हाड़-मांस का पुतला नहीं है।
                यह शरीर ही पूरे ब्रह्मांड का सबसे पवित्र और साक्षात 'देवालय' (भगवान का मंदिर) है।
                और इस मंदिर के भीतर रहने वाला 'जीव' (आत्मा) कोई और नहीं, बल्कि सनातन और अनंत ईश्वर स्वयं है।
                इंसान को अपने भीतर बसे अज्ञान, मूर्खता और अहंकार के कचरे (निर्माल्य) को हमेशा के लिए बाहर फेंक देना चाहिए।
                "मैं छोटा हूँ, मैं पापी हूँ, मैं कमज़ोर हूँ"—यह सोच ही दुनिया का सबसे बड़ा अज्ञान है जिसे त्यागना होगा।
                इसके बजाय, इंसान को "सोऽहं" (वह परब्रह्म मैं ही हूँ) की परम भावना से अपने स्वयं के अस्तित्व की पूजा करनी चाहिए।
                बाहरी मूर्तियों को नहलाने से पहले इंसान को अपने भीतर बैठे भगवान को पहचानना होगा।
                जब यह शरीर मंदिर बन जाता है, तो इसके भीतर जाने वाला अन्न (भोजन) साक्षात नैवेद्य (प्रसाद) बन जाता है।
                यही प्राणाग्निहोत्र का मूल आधार है—स्वयं को ईश्वर मानकर अपने भीतर के प्राणों को तृप्त करना।
                यह अद्वैत वेदांत की वह चोटी है जहाँ पहुँचकर इंसान और भगवान के बीच का हर फासला हमेशा के लिए मिट जाता है।
            """.trimIndent(),
            english = """
                (The Body is the Literal Temple): The Upanishad makes its most colossal and earth-shattering declaration here: this physical body is not mere flesh and bone.
                This very biological body is undeniably the most sacred, living, and literal 'Temple' (Devalaya) in the entire cosmos.
                And the individual living entity (Jiva) residing deep within this temple is absolutely none other than the eternal, infinite God Himself.
                A human must violently and permanently discard the rotting garbage (Nirmalya) of his own cosmic ignorance, stupidity, and ego.
                "I am small, I am a sinner, I am weak"—this pathetic mindset is the ultimate ignorance that must be slaughtered.
                Instead, one must worship one's own existence with the supreme, unbreakable realization of "So'ham" (I am exactly That Supreme Brahman).
                Before bathing external stone idols, a human must urgently recognize the living God vibrating within his own chest.
                When this body is realized as a temple, the food entering it automatically transforms into the highest divine offering (Naivedya).
                This is the absolute foundational core of Pranagnihotra—satisfying the vital forces within by recognizing oneself as God.
                This is the terrifying peak of Non-Dual Vedanta where every single millimeter of distance between man and God is permanently erased.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 3,
            sanskrit = "चतुर्विधमन्नं भक्ष्याभक्ष्यलेह्यचोष्यरूपं तदेव ब्रह्म ।",
            hindi = """
                (अन्न ही साक्षात ब्रह्म है): इंसान जो भी भोजन ग्रहण करता है, उपनिषद उसे चार मुख्य भागों में बाँटता है।
                भक्ष्य (चबाकर खाया जाने वाला), भोज्य (निगला जाने वाला), लेह्य (चाटा जाने वाला) और चोष्य (चूसा जाने वाला)।
                यह चारों प्रकार का अन्न कोई साधारण भौतिक पदार्थ नहीं है; यह अन्न साक्षात 'परब्रह्म' का सगुण स्वरूप है।
                बिना अन्न के इस ब्रह्मांड में जीवन की कल्पना भी नहीं की जा सकती; अन्न ही प्राणों को शरीर में बांध कर रखता है।
                जब तक इंसान अन्न को केवल स्वाद और वासना की दृष्टि से देखता है, वह उसे पतन की ओर ले जाता है।
                लेकिन जब वह अन्न को साक्षात भगवान का रूप मानकर पूरी श्रद्धा और चेतना के साथ ग्रहण करता है...
                तब वही अन्न उसके भीतर जाकर आध्यात्मिक ऊर्जा, असीम ज्ञान और परम शांति में बदल जाता है।
                सृष्टि का हर कण एक दूसरे को खाकर जीवित है; यह ब्रह्मांडीय भोजन चक्र ही ईश्वर की सबसे बड़ी लीला है।
                अन्न का अपमान करना साक्षात ईश्वर का अपमान करना है, क्योंकि अन्न ही जीवन की धड़कन है।
                प्राणाग्निहोत्र में यह चारों प्रकार का अन्न जठराग्नि (पेट की आग) रूपी हवन कुंड में आहुति के रूप में डाला जाता है।
            """.trimIndent(),
            english = """
                (Food is Literal Brahman): Whatever food a human consumes, the Upanishad categorizes it entirely into four distinct forms.
                Bhakshya (chewed solid food), Bhojya (swallowed soft food), Lehya (licked food), and Choshya (sucked liquid food).
                These four types of food are definitively not ordinary material substances; they are the literal, physical manifestation of the Supreme Brahman.
                Without food, the existence of biological life in this cosmos is utterly impossible; food alone binds the vital force to the physical body.
                As long as a human perceives food merely through the lens of sensory lust and taste, it violently drags him toward spiritual downfall.
                However, when he consumes food recognizing it explicitly as the form of God, with absolute reverence and awakened consciousness...
                That exact same food enters his biology and miraculously mutates into supreme spiritual energy, infinite wisdom, and absolute peace.
                Every atom in creation survives by consuming another; this terrifying cosmic food cycle is God's ultimate divine play.
                To disrespect food is to launch a direct insult at God Himself, because food is the literal heartbeat of existence.
                In the Pranagnihotra sacrifice, all four types of food are offered directly into the sacrificial fire pit of the stomach (Jatharagni).
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 4,
            sanskrit = "अन्तर्हृदये जाठराग्निः प्रदीप्तः । स एव गार्हपत्यः ।",
            hindi = """
                (जठराग्नि ही परम हवन कुंड है): बाहरी दुनिया में यज्ञ करने के लिए लोग तीन तरह की पवित्र अग्नियां स्थापित करते हैं।
                लेकिन प्राणाग्निहोत्र के योगी के लिए, उसके हृदय और नाभि के बीच जलने वाली 'जठराग्नि' (पाचन अग्नि) ही असली अग्नि है।
                यही शारीरिक अग्नि वेदों में बताई गई 'गार्हपत्य अग्नि' (गृहस्थ की मुख्य यज्ञ अग्नि) का साक्षात और जीवंत रूप है।
                अगर यह अग्नि बुझ जाए, तो इंसान का शरीर तुरंत ठंडा पड़ जाता है और मौत हो जाती है।
                यह जठराग्नि ही पूरे शरीर को ऊर्जा देती है, खून बनाती है, और दिमाग को काम करने की ताकत देती है।
                इसलिए जब हम भोजन करते हैं, तो हम वास्तव में अपनी भूख नहीं मिटा रहे होते हैं...
                बल्कि हम अपने भीतर बैठे ईश्वर की उस प्रज्ज्वलित और धधकती हुई अग्नि में आहुति डाल रहे होते हैं।
                भोजन करते समय मन में लालच नहीं, बल्कि यज्ञ करने की परम पवित्र भावना होनी चाहिए।
                जो इस रहस्य को जानकर मौन रहकर भोजन करता है, उसका हर निवाला साक्षात स्वर्ग का मार्ग खोलता है।
                पेट कोई कूड़ेदान नहीं है, यह ब्रह्मांड का सबसे पवित्र वेदी (Altar) है जहाँ नित्य हवन हो रहा है।
            """.trimIndent(),
            english = """
                (The Digestive Fire is the Ultimate Altar): In the external world, priests establish three types of sacred physical fires to perform Vedic sacrifices.
                But for the ultimate Yogi of Pranagnihotra, the 'Jatharagni' (digestive fire) blazing intensely between his heart and navel is the true fire.
                This biological, metabolic fire is the literal, living manifestation of the 'Garhapatya Agni' (the primary household sacrificial fire) mentioned in the Vedas.
                If this internal fire is extinguished for even a moment, the human body instantly turns freezing cold, resulting in biological death.
                This exact Jatharagni fuels the entire biology, synthesizes blood, and supplies pure electrical power to the brain to function.
                Therefore, when we consume a meal, we are absolutely not merely extinguishing our biological hunger...
                We are literally pouring sacred offerings into the blazing, roaring sacrificial fire of the God residing within us.
                While eating, the mind must not harbor gluttonous lust, but must maintain the supremely sacred intent of performing a cosmic sacrifice.
                He who comprehends this terrifying secret and eats in absolute silence, turns every single bite into a gateway to heaven.
                The stomach is not a garbage bin; it is the most sacred, supreme Altar in the universe where a continuous daily Havan occurs.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 5,
            sanskrit = "प्राणाय स्वाहा । आपोशानं कृत्वा प्रथममाहुतिं जुहोति ।",
            hindi = """
                (प्राण वायु को पहली आहुति): प्राणाग्निहोत्र की वास्तविक प्रक्रिया अब यहाँ से शुरू होती है।
                भोजन का पहला निवाला खाने से पहले, योगी जल से 'आपोशान' (हाथ और भोजन का शुद्धिकरण) करता है।
                इसके बाद वह पूर्ण एकाग्रता के साथ पहली आहुति (पहला ग्रास) लेता है और मन में कहता है: "ॐ प्राणाय स्वाहा।"
                यह पहली आहुति 'प्राण वायु' को समर्पित है, जो हृदय और छाती के हिस्से में रहकर हमें सांस लेने की ताकत देती है।
                प्राण वायु के बिना इंसान एक सेकंड भी जीवित नहीं रह सकता; यह जीवन की सबसे बड़ी और मुख्य शक्ति है।
                जब योगी यह पहली आहुति डालता है, तो उसकी सांसों में छिपी सभी बीमारियां और विकार भस्म हो जाते हैं।
                उसका हृदय मजबूत होता है, फेफड़ों में नई ऊर्जा भर जाती है, और उसे एक असीम शांति महसूस होती है।
                यह आहुति सूर्य देवता और ब्रह्मांड की सकारात्मक ऊर्जा को सीधे शरीर के भीतर खींच लाती है।
                इस एक निवाले के अर्पण से स्वर्ग के देवताओं को भी तृप्ति मिल जाती है, क्योंकि देव और प्राण एक ही हैं।
                भोजन को चबाते हुए योगी महसूस करता है कि वह परब्रह्म के मुख में साक्षात अमृत डाल रहा है।
            """.trimIndent(),
            english = """
                (The First Offering to Prana Vayu): The actual, meticulous procedure of the Pranagnihotra commences right from this point.
                Before consuming the very first morsel, the Yogi performs 'Aposhana' (purification of hands and food using sacred water).
                Following this, with absolute razor-sharp concentration, he takes the first offering and mentally chants: "Om Pranaya Svaha."
                This preliminary offering is strictly dedicated to the 'Prana Vayu', the vital air residing in the chest and heart, enabling respiration.
                Without this Prana Vayu, a human cannot survive even a single second; it is the absolute paramount force of existence.
                When the Yogi makes this first conscious offering, all respiratory diseases and subtle impurities in his breath are incinerated.
                His physical heart transforms into an invincible fortress, his lungs fill with cosmic energy, and he experiences bottomless peace.
                This specific offering acts as a magnet, forcefully pulling the positive solar energy of the universe directly into his biology.
                Through the offering of this single morsel, even the cosmic deities in heaven are deeply satisfied, for the deities and the life-breath are identical.
                While chewing the food, the Yogi intensely feels that he is literally dropping immortal nectar directly into the mouth of the Supreme Brahman.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 6,
            sanskrit = "अपानाय स्वाहा । द्वितीयामाहुतिं जुहोति ।",
            hindi = """
                (अपान वायु को दूसरी आहुति): दूसरा निवाला उठाते समय योगी पूरी चेतना के साथ मन में उच्चारण करता है: "ॐ अपानाय स्वाहा।"
                यह दूसरी आहुति 'अपान वायु' को दी जाती है, जो नाभि से नीचे के हिस्से में निवास करती है।
                अपान वायु का काम शरीर से सारा कचरा, मल, मूत्र और हानिकारक तत्वों (Toxins) को बाहर निकालना है।
                अगर अपान वायु काम करना बंद कर दे, तो शरीर अपने ही ज़हर से घुट कर मर जाएगा।
                इस आहुति से शरीर की शुद्धि प्रणाली (Excretory System) पूरी तरह से शक्तिशाली और दोषमुक्त हो जाती है।
                अपान वायु का संबंध पृथ्वी तत्व से है; यह इंसान को मानसिक रूप से ज़मीन से जोड़े रखती है।
                जब यह वायु तृप्त होती है, तो इंसान के भीतर की सारी नकारात्मकता, क्रोध और गंदे विचार भी शरीर से बाहर निकल जाते हैं।
                भोजन करते समय जब इंसान अपान का ध्यान करता है, तो उसका पाचन तंत्र लोहे जैसा मज़बूत हो जाता है।
                इस आहुति के प्रभाव से इंसान बुढ़ापे की बीमारियों से बचता है और उसकी उम्र लंबी होती है।
                यह शरीर के निचले चक्रों (मूलाधार और स्वाधिष्ठान) को भी जाग्रत करने का गुप्त और शक्तिशाली तरीका है।
            """.trimIndent(),
            english = """
                (The Second Offering to Apana Vayu): Raising the second morsel, the Yogi internally chants with full awakened consciousness: "Om Apanaya Svaha."
                This crucial second offering is dedicated specifically to the 'Apana Vayu', the downward-moving vital air residing below the navel.
                The absolute function of Apana Vayu is the violent expulsion of all waste, toxins, feces, and urine from the biological system.
                If the Apana Vayu halts its operation even briefly, the body will literally suffocate and die from its own accumulated toxic poison.
                Through this conscious offering, the entire excretory and purification system of the body becomes flawlessly powerful and immune to defects.
                Apana Vayu is deeply connected to the Earth element; it keeps the human psychologically grounded and stable.
                When this specific vital force is satisfied, all internal negativity, explosive anger, and filthy thoughts are also forcefully flushed out.
                When a human meditates on the Apana while eating, his digestive tract mutates into unbreakable, invincible iron.
                By the powerful impact of this exact offering, a human evades the agonizing diseases of old age and significantly prolongs his lifespan.
                This is also a highly secretive, lethal method to violently awaken the lower spiritual chakras (Muladhara and Svadhisthana).
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 7,
            sanskrit = "व्यानाय स्वाहा । तृतीयामाहुतिं जुहोति ।",
            hindi = """
                (व्यान वायु को तीसरी आहुति): भोजन का तीसरा ग्रास लेते हुए योगी श्रद्धापूर्वक जपता है: "ॐ व्यानाय स्वाहा।"
                यह तीसरी आहुति 'व्यान वायु' के लिए है, जो किसी एक अंग में नहीं, बल्कि सिर से लेकर पैर तक पूरे शरीर में दौड़ती है।
                व्यान वायु का काम पूरे शरीर में खून का संचार (Blood Circulation) करना और हर कोशिका तक ऊर्जा पहुँचाना है।
                यह शरीर की नाड़ियों (Nerves) का राजा है; इसके बिना शरीर के अंगों में तालमेल नहीं हो सकता।
                जब योगी इस वायु को भोजन अर्पित करता है, तो उसके शरीर की 72,000 नाड़ियाँ शुद्ध और पवित्र हो जाती हैं।
                व्यान के तृप्त होने से शरीर की त्वचा में एक दिव्य चमक और तेज (Aura) आ जाता है।
                मांसपेशियों का दर्द, थकान, और शारीरिक कमज़ोरी इस एक आहुति के प्रभाव से हमेशा के लिए नष्ट हो जाते हैं।
                यह आहुति अंतरिक्ष (Space) तत्व से जुड़ी है, जो इंसान को हर दिशा में फैलने और शक्तिशाली बनने की ताकत देती है।
                जब व्यान शांत होता है, तो इंसान का रक्तचाप (Blood Pressure) और धड़कन पूरी तरह से नियंत्रण में आ जाती है।
                यह शरीर के रोम-रोम में ईश्वर की उपस्थिति का साक्षात और जीवंत अनुभव कराता है।
            """.trimIndent(),
            english = """
                (The Third Offering to Vyana Vayu): Taking the third bite of food, the Yogi reverently chants: "Om Vyanaya Svaha."
                This third offering is explicitly meant for the 'Vyana Vayu', which does not stay in one organ but violently rushes through the entire body from head to toe.
                The primary function of Vyana Vayu is to command total blood circulation and deliver raw energy to every single microscopic cell.
                It is the undisputed king of the nervous system (Nadis); without it, absolute biological coordination is impossible.
                When the Yogi offers food to this specific air, all 72,000 subtle energy channels (Nadis) in his biology are purged and intensely purified.
                The absolute satisfaction of Vyana produces a terrifyingly brilliant, divine glow and radiant Aura upon the human's skin.
                Muscular agony, chronic exhaustion, and biological weakness are permanently annihilated by the sheer force of this one offering.
                This offering is linked to the Space (Akasha) element, granting the human the immense power to expand and dominate in all directions.
                When Vyana is pacified, the human's blood pressure and cardiac rhythms are brought under flawless, absolute total control.
                This forces the literal, living experience of God's presence to vibrate violently within every single pore of the physical body.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 8,
            sanskrit = "उदानाय स्वाहा । चतुर्थीमाहुतिं जुहोति ।",
            hindi = """
                (उदान वायु को चौथी आहुति): चौथा निवाला मुँह में डालते हुए संन्यासी ध्यान करता है: "ॐ उदानाय स्वाहा।"
                यह आहुति 'उदान वायु' को समर्पित है, जिसका निवास कंठ (गले) और सिर के हिस्से में होता है।
                उदान वायु ही इंसान को बोलने की शक्ति, आवाज़ में गूंज, और निगलने की क्षमता देती है।
                सबसे बड़ी बात—मृत्यु के समय यही उदान वायु आत्मा को शरीर से बाहर निकालकर ऊर्ध्व गति (ऊपर के लोकों) में ले जाती है।
                जो इस वायु को भोजन अर्पण करता है, उसकी वाणी सिद्ध हो जाती है; वह जो बोलता है, वही सच हो जाता है।
                उसके गले से सरस्वती का साक्षात वास होता है, और उसके शब्द मंत्र बन जाते हैं।
                उदान के शुद्ध होने से इंसान नींद, आलस्य और मूर्खता से हमेशा के लिए आज़ाद हो जाता है।
                यह अग्नि तत्व से जुड़ा है, जो इंसान के भीतर के सभी भ्रम और अज्ञान को जलाकर राख कर देता है।
                जब मौत का समय आता है, तो उदान वायु योगी को दर्द नहीं देती, बल्कि शांति से शरीर छुड़वा देती है।
                यह आहुति इंसान को भौतिक दुनिया से ऊपर उठाकर सीधे आध्यात्मिक दुनिया से जोड़ती है।
            """.trimIndent(),
            english = """
                (The Fourth Offering to Udana Vayu): Placing the fourth morsel in his mouth, the ascetic meditates: "Om Udanaya Svaha."
                This specific offering is fiercely dedicated to the 'Udana Vayu', whose permanent residence is located in the throat and the head region.
                Udana Vayu alone grants humans the sheer power of speech, the resonance in the voice, and the fundamental biological ability to swallow.
                Most terrifyingly—at the precise moment of physical death, it is this exact Udana Vayu that forcefully ejects the soul from the corpse and launches it into higher realms.
                Whoever offers food systematically to this air attains 'Vak-Siddhi' (perfection of speech); whatever he utters literally manifests into reality.
                Goddess Saraswati directly establishes her physical residence in his throat, and his ordinary words mutate into lethal cosmic mantras.
                With the purification of Udana, a human is permanently liberated from lethargy, sleepiness, and gross mental stupidity.
                It is deeply connected to the Fire element, which mercilessly burns all internal illusions and cosmic ignorance entirely to ashes.
                When the hour of death arrives, Udana Vayu does not inflict agony on the Yogi, but ensures a flawlessly peaceful bodily exit.
                This one offering violently elevates the human above the pathetic material matrix, plugging him directly into the supreme spiritual dimensions.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 9,
            sanskrit = "समानाय स्वाहा । पञ्चमीमाहुतिं जुहोति ।",
            hindi = """
                (समान वायु को पाँचवीं आहुति): पाँचवाँ और अंतिम मुख्य ग्रास लेते हुए योगी मानसिक जप करता है: "ॐ समानाय स्वाहा।"
                यह आहुति 'समान वायु' के लिए है, जो ठीक पेट के बीच (नाभि क्षेत्र) में रहकर भोजन को पचाने का काम करती है।
                यह जठराग्नि को भड़काती है और पचे हुए भोजन से पोषक तत्वों (Nutrients) को अलग करके पूरे शरीर में बांटती है।
                अगर समान वायु कमज़ोर पड़ जाए, तो इंसान चाहे कितना भी अच्छा भोजन कर ले, शरीर उसे सोख नहीं पाएगा।
                इस आहुति के प्रभाव से योगी की पाचन शक्ति आग की तरह प्रखर और अभेद्य हो जाती है।
                समान वायु संतुलन (Balance) का प्रतीक है; यह शरीर के सभी दोषों (वात, पित्त, कफ) को एक समान बनाए रखती है।
                जब समान वायु तृप्त होती है, तो इंसान के मन में कभी अशांति या हताशा पैदा नहीं होती।
                यह इंसान को मानसिक रूप से स्थिर, शांत और अडिग बना देती है, जैसे कोई गहरा समुद्र हो।
                इन पाँच आहुतियों के बाद जो भी भोजन किया जाता है, वह मौन रहकर परब्रह्म का प्रसाद मानकर खाया जाता है।
                यह पाँच आहुतियां शरीर के पाँचों प्राणों को शांत करके आत्मा को परम मोक्ष के लिए तैयार कर देती हैं।
            """.trimIndent(),
            english = """
                (The Fifth Offering to Samana Vayu): Taking the fifth and final primary bite, the Yogi mentally chants: "Om Samanaya Svaha."
                This ultimate offering is strictly for the 'Samana Vayu', which violently operates right in the center of the abdomen to digest food.
                It deliberately fans the flames of the digestive fire, extracts the absolute raw nutrients from the food, and perfectly distributes them.
                If Samana Vayu becomes weak, no matter how much elite food a human consumes, the biological system will brutally fail to absorb it.
                By the sheer impact of this exact offering, the Yogi’s digestive capacity mutates into an impenetrable, raging inferno.
                Samana Vayu is the absolute symbol of Equilibrium; it ruthlessly maintains flawless balance among the body's humors (Vata, Pitta, Kapha).
                When Samana is fully satisfied, extreme mental turbulence, depression, or frustration can never breed inside the human mind.
                It transforms the human into a psychologically immovable, terrifyingly calm, and unshakeable force, like a bottomless dark ocean.
                Whatever food is consumed after these five primary offerings is eaten in dead silence, perceived explicitly as the nectar of the Supreme God.
                These five lethal offerings perfectly pacify all five vital forces, flawlessly preparing the soul for absolute, terrifying liberation.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 10,
            sanskrit = "भोजनान्ते पुनरापोशानं कृत्वा । अमृतापिधानमसीति ।",
            hindi = """
                (भोजन के अंत में अमृत-पान): जब पूरा भोजन समाप्त हो जाता है, तो यज्ञ अभी अधूरा है।
                भोजन के बाद योगी दोबारा थोड़ा सा जल लेकर 'आपोशान' (उत्तरापोशान) करता है।
                इस जल को पीते समय वह मंत्र जपता है: "अमृतापिधानमसि"—"हे जल! तुम मेरे द्वारा खाए गए इस अन्न रूपी अमृत का ढक्कन (आवरण) बन जाओ।"
                इसका रहस्य यह है कि जो अन्न प्राणों को दिया गया है, वह जल के प्रभाव से शरीर में हमेशा के लिए सुरक्षित और सील (Seal) हो जाता है।
                जल उस भोजन को सड़ने नहीं देता, बल्कि उसे आध्यात्मिक तेज और शुद्ध ऊर्जा में बदल देता है।
                यह प्रक्रिया बताती है कि भोजन की शुरुआत और अंत दोनों ही पवित्रता (जल) से घिरे होने चाहिए।
                बिना इस अंतिम आचमन के प्राणाग्निहोत्र का फल अधूरा माना जाता है, क्योंकि ऊर्जा शरीर से बाहर लीक हो सकती है।
                इस जल को पीने के बाद योगी अपने हाथों को धोता है और अपने हृदय (आत्मा) को स्पर्श करता है।
                वह यह घोषणा करता है कि आज का यज्ञ सफल हुआ, और भगवान मेरे इस शरीर में पूर्ण रूप से तृप्त हो गए।
                यह एक साधारण खाना खाने की क्रिया को ब्रह्मांड के सबसे महान कर्मकांड (Ritual) में बदल देने की परम कला है।
            """.trimIndent(),
            english = """
                (Drinking Nectar at the End of the Meal): When the entire meal is completely finished, the cosmic sacrifice is still technically incomplete.
                Post-meal, the Yogi once again takes a small sip of sacred water to perform the final 'Aposhana' (Uttaraposhana).
                While swallowing this water, he chants the powerful mantra: "Amritapidhanamasi"—"O Water! Become the impenetrable lid (cover) securing this nectar-like food I just consumed."
                The terrifying secret here is that the food offered to the vital forces is permanently sealed, locked, and secured within the biology by the power of this water.
                The water absolutely prevents the food from rotting, forcing it to instantly mutate into raw spiritual brilliance and pure electrical energy.
                This exact procedure dictates that both the initiation and the termination of a meal must be violently enveloped in absolute purity (Water).
                Without this final sip, the fruits of the Pranagnihotra are deemed incomplete, as the generated cosmic energy might leak out of the biological system.
                After swallowing this water, the Yogi washes his hands and physically touches his heart (the seat of the Soul).
                He makes a cosmic declaration that today's sacrifice is flawlessly victorious, and God is absolutely, wholly satisfied within this body.
                This is the supreme, ancient art of transforming the mundane, biological act of eating into the most colossal, terrifying ritual in the cosmos.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 11,
            sanskrit = "अन्नं ब्रह्मेति व्यजानात् । अन्नाद्ध्येव खल्विमानि भूतानि जायन्ते ।",
            hindi = """
                (अन्न ही ब्रह्मा की उत्पत्ति है): उपनिषद एक बार फिर से गर्जना करता है: "अन्न को ही साक्षात परब्रह्म जानो!"
                क्योंकि इस ब्रह्मांड में मौजूद हर एक प्राणी, कीड़े-मकोड़े से लेकर इंसान तक, केवल अन्न से ही जन्म लेते हैं।
                अन्न से ही बीज बनता है, बीज से पिता के शरीर में जीवन का निर्माण होता है, और उसी से संतान पैदा होती है।
                अन्न ही वह शक्ति है जो दुनिया को चला रही है; अगर धरती से अन्न खत्म हो जाए, तो सृष्टि का अंत निश्चित है।
                जो व्यक्ति अन्न का अपमान करता है, उसे जूठा छोड़ता है, या उसे कचरे में फेंकता है...
                वह साक्षात भगवान की हत्या करने के समान भयंकर पाप का भागीदार बनता है।
                प्राणाग्निहोत्र करने वाला योगी कभी एक दाना भी बर्बाद नहीं करता, क्योंकि उसके लिए वह दाना ब्रह्म का एक टुकड़ा है।
                अन्न खाने के बाद ही इंसान को धर्म, ज्ञान, तपस्या और मोक्ष की बातें समझ में आती हैं; भूखे पेट भगवान भी नहीं मिलते।
                यह अन्न ही है जो मिट्टी से पैदा होता है और अंत में मिट्टी में मिलकर वापस ब्रह्म में विलीन हो जाता है।
                इस रहस्य को गहराई से समझ लेने वाला इंसान भोजन करते समय परम समाधि (Meditation) का अनुभव करता है।
            """.trimIndent(),
            english = """
                (Food is the Origin of Brahman): The Upanishad once again roars with cosmic authority: "Know unequivocally that Food is literal Supreme Brahman!"
                Because absolutely every single biological entity in this universe, from microscopic insects to complex humans, is born exclusively from food.
                Food synthesizes the seed, the seed manufactures raw life within the father's biology, and from that, the offspring is violently birthed.
                Food is the undisputed raw power operating the world; if food vanishes from the Earth, the absolute extermination of creation is guaranteed.
                Any human who intentionally disrespects food, leaves it half-eaten, or ruthlessly throws it into the garbage...
                Literally incurs a horrifying, catastrophic sin equivalent to directly assassinating God Himself.
                The Yogi executing Pranagnihotra never wastes a single microscopic grain, because for him, that grain is a physical fragment of Brahman.
                Only after consuming food can a human brain comprehend religion, wisdom, severe penance, and liberation; even God cannot be found on a starving stomach.
                It is this exact food that is violently born from the dirt, and ultimately decays back into dirt, merging flawlessly back into Brahman.
                The human who deeply, penetratingly understands this terrifying secret physically experiences Supreme Samadhi (Meditation) while merely eating a meal.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 12,
            sanskrit = "य एवं वेद स सर्वान् पाप्मनोऽपहत्य ब्रह्मलोकमभिसम्पद्यते ।",
            hindi = """
                (पापों का विनाश और मोक्ष): उपनिषद यहाँ इस पूरी प्रक्रिया का सबसे बड़ा और अंतिम फल (Result) बताता है।
                "जो भी इंसान प्राणाग्निहोत्र के इस खौफनाक और गहरे रहस्य को पूरी तरह जान लेता है और इसे अपने जीवन में उतारता है..."
                उसके पिछले जन्मों के और इस जन्म के सारे भयंकर पाप, चाहे वे कितने भी बड़े क्यों न हों, तुरंत जलकर भस्म हो जाते हैं।
                जिस तरह सूखी घास का पहाड़ एक छोटी सी चिंगारी से जलकर राख हो जाता है, वैसे ही ज्ञान की इस अग्नि से पाप खत्म हो जाते हैं।
                वह इंसान मरने के बाद किसी निचले लोक या नरक में नहीं भटकता, न ही उसे दोबारा कीड़े-मकोड़ों की योनि में जन्म लेना पड़ता है।
                वह सीधे, बिना किसी रुकावट के 'ब्रह्मलोक' (परब्रह्म के सर्वोच्च और अंतिम निवास) को प्राप्त कर लेता है।
                वहाँ पहुँचने के बाद आत्मा का कभी पतन नहीं होता, वह हमेशा के लिए जन्म और मौत के खौफनाक चक्र से आज़ाद हो जाती है।
                यह कोई कहानी या कोरा आश्वासन नहीं है, यह वेदों की अटल और कभी न टूटने वाली गारंटी है।
                एक साधारण सी दिखने वाली भोजन की क्रिया इंसान को साक्षात ईश्वर के सिंहासन तक पहुँचा सकती है।
                बस शर्त यह है कि भोजन करते समय मन में लालच के बजाय आत्म-ज्ञान और यज्ञ की परम भावना जल रही हो।
            """.trimIndent(),
            english = """
                (The Annihilation of Sins and Ultimate Liberation): The Upanishad here dictates the ultimate, absolute consequence (Result) of this entire procedure.
                "Any human who flawlessly comprehends this terrifying, profound secret of Pranagnihotra and permanently implements it in his life..."
                All his horrific, catastrophic sins from thousands of past lives and the current one, regardless of their immense gravity, are instantly incinerated to ashes.
                Exactly as a colossal mountain of dry grass is violently reduced to dust by a tiny spark, all sins are slaughtered by this fire of cosmic wisdom.
                After physical death, that human never wanders into lower realms or hells, nor is he ever forced to be reborn in the pathetic wombs of animals or insects.
                He directly, without a microsecond of obstruction, pierces through reality and achieves 'Brahmaloka' (the absolute, ultimate supreme abode of God).
                Once he reaches that absolute zenith, the soul never suffers a downfall; it is permanently and violently liberated from the terrifying cycle of birth and death.
                This is strictly not a fairy tale or a hollow promise; this is the unbreakable, ironclad, absolute guarantee of the Vedas.
                An act as seemingly mundane as eating a biological meal possesses the sheer lethal power to catapult a human straight to the throne of God.
                The absolute condition is merely this: while eating, instead of pathetic gluttony, the supreme fire of self-realization and cosmic sacrifice must be blazing in the mind.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 13,
            sanskrit = "मनो यजमानः । बुद्धिः पत्नी ।",
            hindi = """
                (मन यजमान है और बुद्धि उसकी पत्नी): अब उपनिषद इस शरीर रूपी यज्ञशाला का पूरा प्रतीकात्मक (Symbolic) अर्थ खोलता है।
                बाहरी यज्ञ में एक 'यजमान' (यज्ञ करवाने वाला मुख्य व्यक्ति) होता है; यहाँ इंसान का अपना 'मन' ही वह यजमान है।
                जब तक मन यज्ञ में शामिल नहीं है, तब तक किया गया कोई भी कर्म या खाया गया कोई भी भोजन व्यर्थ है।
                यज्ञ में यजमान की पत्नी का होना अनिवार्य है; इस आध्यात्मिक यज्ञ में इंसान की 'बुद्धि' (Intellect) ही मन की पत्नी है।
                मन हमेशा चंचल होता है, वह भटकता है, लेकिन बुद्धि उसे सही रास्ता दिखाती है और यज्ञ को सफल बनाती है।
                बिना तेज बुद्धि के, मन कभी भी वैराग्य या भगवान की तरफ नहीं मुड़ सकता।
                जब मन (यजमान) और बुद्धि (पत्नी) दोनों मिलकर पूरी एकाग्रता के साथ शरीर में प्राणों को आहुति देते हैं...
                तब इंसान के भीतर चल रहा यह द्वंद्व (Conflicts) शांत हो जाता है और उसे परम ज्ञान (Enlightenment) मिलता है।
                यह श्लोक साबित करता है कि असली धर्म और अध्यात्म बाहर के जंगलों में नहीं, बल्कि हमारे दिमाग और विचारों के भीतर घटित हो रहा है।
                मन और बुद्धि का यह विवाह ही इंसान को शिव (परमात्मा) से मिलाता है।
            """.trimIndent(),
            english = """
                (The Mind is the Sacrificer, Intellect is the Wife): Now, the Upanishad violently rips open the profound symbolic architecture of this body-as-a-sacrifice.
                In an external ritual, there is a 'Yajamana' (the primary host funding the sacrifice); here, the human's own 'Mind' is explicitly that Sacrificer.
                Unless the mind is fully, consciously engaged, absolutely any action performed or food consumed is a totally useless, mechanical dead act.
                In a Vedic ritual, the presence of the sacrificer's wife is strictly mandatory; in this spiritual sacrifice, the human 'Intellect' (Buddhi) is the literal wife of the Mind.
                The Mind is inherently chaotic, violently fluctuating and wandering, but the Intellect ruthlessly guides it and ensures the absolute victory of the sacrifice.
                Without a razor-sharp, lethal Intellect, the Mind can absolutely never pivot toward detachment or the Supreme God.
                When both the Mind (Host) and the Intellect (Wife) unite and pour offerings to the vital forces with terrifying concentration...
                The brutal psychological conflicts within the human are permanently silenced, and he instantaneously achieves Supreme Enlightenment.
                This verse permanently proves that authentic religion and spirituality do not happen in external forests, but entirely within our brains and psychological architecture.
                This exact internal marriage between the Mind and the Intellect is what flawlessly fuses the human with Shiva (The Supreme Soul).
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 14,
            sanskrit = "अहङ्कारोऽध्वर्युः । चित्तं होता ।",
            hindi = """
                (अहंकार और चित्त की भूमिका): यज्ञ में आहुति डालने वाले और मंत्र पढ़ने वाले ब्राह्मणों (पुजारियों) के नाम अब शरीर के भीतर खोजे गए हैं।
                इंसान का 'अहंकार' (Ego - 'मैं' होने का भाव) यहाँ 'अध्वर्यु' (यज्ञ के कार्य करने वाला मुख्य पुरोहित) है।
                और इंसान का 'चित्त' (Subconscious Mind - जहाँ सारी यादें जमा हैं) यहाँ 'होता' (देवताओं को बुलाने वाला पुरोहित) है।
                सामान्य जीवन में अहंकार इंसान को पतन की ओर ले जाता है, लेकिन प्राणाग्निहोत्र में यह अहंकार ही भगवान की सेवा में लग जाता है।
                जब 'मैं' का भाव यह मान लेता है कि "मैं शरीर नहीं, बल्कि ब्रह्म का सेवक हूँ", तो वह अहंकार ही मोक्ष का साधन बन जाता है।
                चित्त, जो जन्मों-जन्मों के कचरे से भरा है, अब सांसारिक विचारों को छोड़कर परम सत्य (मंत्रों) को पुकारने लगता है।
                यह एक ऐसा खौफनाक और सुंदर रूपांतरण (Transformation) है, जहाँ इंसान की कमज़ोरियां ही उसकी सबसे बड़ी ताकत बन जाती हैं।
                शरीर के ये मानसिक हिस्से अब दुनिया की तरफ नहीं भागते, बल्कि भीतर बैठे परब्रह्म की आग में खुद को स्वाहा करने लगते हैं।
                इस तरह, इंसान का पूरा मनोविज्ञान (Psychology) ही एक पवित्र यज्ञशाला में बदल जाता है।
                यहाँ कुछ भी नष्ट नहीं होता, सब कुछ शुद्ध होकर भगवान में विलीन हो जाता है।
            """.trimIndent(),
            english = """
                (The Roles of Ego and Subconscious): The exact titles of the Brahmin priests performing the sacrifice and chanting mantras are now discovered hidden deep within the biology.
                The human 'Ego' (Ahamkara - the vicious sense of 'I-ness') is explicitly assigned the role of the 'Adhvaryu' (the primary operational priest managing the sacrifice).
                And the human 'Chitta' (the vast Subconscious Mind hoarding all memories) is designated as the 'Hota' (the priest who loudly invokes the cosmic deities).
                In mundane existence, the Ego violently drags a human into catastrophic downfall, but in Pranagnihotra, this exact Ego is forcefully enslaved into the service of God.
                When this sense of 'I' completely accepts that "I am absolutely not this body, but a servant of Brahman", that very Ego mutates into a lethal weapon for liberation.
                The Chitta, bloated with the rotting garbage of a million past lives, stops vomiting worldly thoughts and begins frantically invoking the Absolute Truth (Mantras).
                This is a terrifyingly beautiful, violent psychological transformation, where a human's darkest internal weaknesses are mutated into his greatest invincible strengths.
                These internal psychological components stop sprinting toward the fake material world, and begin mercilessly offering themselves into the fire of Brahman blazing within.
                In this exact manner, the entire human Psychology flawlessly transforms into a hyper-sacred, roaring sacrificial arena.
                Absolutely nothing is destroyed here; everything is brutally purified and seamlessly dissolved back into God.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 15,
            sanskrit = "प्राणो ब्रह्मा । अपान उद्राता ।",
            hindi = """
                (प्राण और अपान भी पुरोहित हैं): यज्ञ में सबसे बड़े पद पर बैठने वाले 'ब्रह्मा' (जो पूरे यज्ञ की निगरानी करता है) का स्थान 'प्राण वायु' को मिला है।
                प्राण ही शरीर का सबसे मुख्य तत्त्व है, इसलिए वही इस शारीरिक यज्ञ का सुप्रीम कमांडर (ब्रह्मा) है।
                और 'उद्गाता' (जो सामवेद के मधुर मंत्रों को गाता है), उसका स्थान 'अपान वायु' को दिया गया है।
                यह कल्पना नहीं, बल्कि एक गहरा वैज्ञानिक और आध्यात्मिक सत्य है कि साँसों का आना-जाना ही शरीर में सबसे बड़ा वैदिक मंत्र (सोऽहं) गा रहा है।
                हम भले ही चुप बैठे हों, लेकिन हमारी साँसें (प्राण और अपान) हर पल भगवान का नाम गा रही हैं।
                जब इंसान अपनी साँसों के इस संगीत को ध्यान (Meditation) में सुन लेता है, तो उसे बाहर के किसी संगीत या मंत्र की ज़रूरत नहीं पड़ती।
                प्राण शरीर को ऊपर खींचता है (जीवन), और अपान नीचे खींचता है (मृत्यु); इन दोनों का संतुलन (Balance) ही यह यज्ञ है।
                जब यह दोनों पुरोहित (प्राण और अपान) एक हो जाते हैं और सुषुम्ना नाड़ी (Spinal Cord) में प्रवेश करते हैं...
                तब शरीर का भ्रम टूट जाता है और कुण्डलिनी शक्ति का महा-विस्फोट होता है।
                यही प्राणाग्निहोत्र का गुप्त योग है, जो साधक को सीधे ईश्वर से टकरा देता है।
            """.trimIndent(),
            english = """
                (Prana and Apana as Priests): The absolute highest, most authoritative position in a sacrifice, the 'Brahma' (the silent supreme overseer), is awarded entirely to the 'Prana Vayu'.
                Since Prana is unequivocally the most critical element keeping the biology alive, it rightfully acts as the Supreme Commander of this biological sacrifice.
                And the 'Udgata' (the priest who melodiously chants the mesmerizing verses of the Sama Veda) is explicitly played by the 'Apana Vayu'.
                This is not a poetic hallucination, but a violently deep scientific and spiritual reality: the very mechanical inhalation and exhalation of breath is constantly singing the greatest Vedic mantra (So'ham).
                Even when we sit in absolute, dead physical silence, our vital breaths (Prana and Apana) are ruthlessly, continuously roaring the name of God every microsecond.
                When a human successfully hears this deafening music of the breath through intense Meditation, he never again requires any external music or recited mantras.
                Prana forcefully pulls the biology upward (Life), and Apana violently drags it downward (Death); the flawless, terrifying balance of these two is this Sacrifice.
                When these two massive priests (Prana and Apana) crash into each other, fuse into one, and forcefully enter the Sushumna Nadi (the central spinal channel)...
                The pathetic illusion of the physical body shatters instantly, triggering the catastrophic, atomic explosion of Kundalini energy.
                This is the highly classified, lethal Yoga hidden within Pranagnihotra, which slams the seeker face-first into God.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 16,
            sanskrit = "शरीरं वेदिः । शिरः कपालम् ।",
            hindi = """
                (शरीर ही वेदी और सिर पात्र है): यज्ञ करने के लिए ज़मीन पर जो ईंटों से 'वेदी' (Altar) बनाई जाती है, वह यह पूरा शरीर ही है।
                इंसान का शरीर ही वह पवित्र ज़मीन है जहाँ हर पल जीवन और मृत्यु का यज्ञ चल रहा है।
                यज्ञ में घी या सामग्री रखने के लिए जो बर्तन (कपाल/पात्र) इस्तेमाल होता है, वह इंसान का अपना 'सिर' (खोपड़ी) है।
                सिर के भीतर (दिमाग में) ही सारे विचार, सारा ज्ञान और सारी चेतना जमा रहती है, जिसे अग्नि में अर्पित करना होता है।
                उपनिषद यहाँ इंसान के देह-अभिमान (मैं शरीर हूँ, ऐसा घमंड) पर सीधा प्रहार कर रहा है।
                तुम्हारी यह काया जिसे तुम रोज़ सजाते हो, वह असल में जलने के लिए बनी एक यज्ञ-वेदी से ज्यादा कुछ नहीं है।
                और तुम्हारा यह सिर जिस पर तुम्हें इतना घमंड है, वह केवल ईश्वर को ज्ञान सौंपने का एक मिट्टी का बर्तन है।
                जब योगी इस नज़रिए से अपने शरीर को देखता है, तो उसका मौत से डर हमेशा के लिए खत्म हो जाता है।
                वह जीते जी अपने शरीर को ब्रह्मांडीय अग्नि में अर्पित कर देता है; यही सच्चा संन्यास है।
                ऐसे योगी के लिए दुनिया का कोई भी बाहरी कर्मकांड मायने नहीं रखता, वह चलते-फिरते एक जीता-जागता तीर्थ बन जाता है।
            """.trimIndent(),
            english = """
                (The Body is the Altar, the Head is the Vessel): The physical 'Vedi' (sacrificial Altar) meticulously constructed with bricks on the ground for a ritual, is literally this entire physical human body itself.
                The human biology is the exact, ultra-sacred ground where the terrifying, continuous sacrifice of Life and Death is occurring every microsecond.
                The specific 'Kapala' (the physical vessel/bowl) used in a ritual to hold the clarified butter or offerings, is unequivocally the human 'Head' (Skull).
                Deep inside this skull (the brain) is where all toxic worldly thoughts, accumulated knowledge, and raw consciousness are hoarded, waiting to be violently poured into the cosmic fire.
                The Upanishad here launches a brutal, unforgivable direct strike against human bodily arrogance (the pathetic ego of 'I am this flesh').
                This biological shell you passionately decorate every day is, in absolute reality, nothing more than a sacrificial altar destined strictly to burn.
                And this head you are so intensely arrogant about, is merely a cheap earthen pot designed solely to surrender its contents (knowledge) back to God.
                When a master Yogi perceives his physical form strictly through this terrifying lens, his biological fear of death is permanently exterminated.
                He violently and mercilessly sacrifices his own living body into the cosmic fire while still breathing; this is authentic, absolute Sannyasa.
                For such a terrifyingly awake Yogi, no external religious drama matters; he literally mutates into a walking, breathing, supreme pilgrimage site.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 17,
            sanskrit = "लोमानि बर्हिः । अवागन्तरिक्षम् ।",
            hindi = """
                (रोएं कुशा घास हैं और हृदय अंतरिक्ष): यज्ञ की वेदी को सजाने और पवित्र करने के लिए जो 'कुशा घास' (बर्हि) बिछाई जाती है...
                वह इंसान के शरीर पर मौजूद छोटे-छोटे 'रोएं' (Hair/Pores) हैं। शरीर का हर एक रोम इस यज्ञ को पवित्र बना रहा है।
                और यज्ञशाला के ऊपर जो विशाल आसमान या 'अंतरिक्ष' होता है, वह इंसान का अपना 'हृदय' (छाती का भीतरी खाली हिस्सा) है।
                हृदय के भीतर असीम शून्यता और शांति है; इसी हृदय के आकाश (चिदाकाश) में परमात्मा चमकते हुए सूरज की तरह निवास करता है।
                जब हम बाहर आसमान की ओर देखकर भगवान को खोजते हैं, तो हम सबसे बड़ी गलती करते हैं।
                उपनिषद चीख-चीख कर कह रहा है कि पूरा का पूरा ब्रह्मांड, तारे, आकाश और कुशा घास सब तुम्हारे इसी छोटे से शरीर में मौजूद हैं।
                तुम कोई साधारण इंसान नहीं हो; तुम अपने आप में एक पूरा, स्वतंत्र और असीम ब्रह्मांड (Microcosm) हो।
                तुम्हारे रोम-रोम में पवित्रता है और तुम्हारे सीने के भीतर साक्षात शून्य (Void) और अनंत आसमान बसा है।
                जो ध्यान के ज़रिए अपने हृदय के इस अंतरिक्ष में प्रवेश कर जाता है...
                उसे फिर दुनिया के किसी भी दुख, किसी भी बीमारी या मौत की परछाई तक छू नहीं सकती।
            """.trimIndent(),
            english = """
                (Body Hair is Kusha Grass, the Heart is Outer Space): The hyper-sacred 'Kusha Grass' (Barhi) explicitly scattered to aggressively purify and decorate a physical sacrificial altar...
                Are literally the microscopic 'Hairs' (and pores) covering the entire human physical body. Every single pore on your skin is violently purifying this biological sacrifice.
                And the colossal, infinite 'Antariksha' (Outer Space) hovering menacingly above the sacrificial arena, is precisely the human 'Heart' (the deep internal void within the chest cavity).
                There is absolutely bottomless, terrifying emptiness and cosmic silence deep within this heart; in this exact internal space (Chidakasha), the Supreme God blazes permanently like a blinding Sun.
                When we pathetically stare at the external physical sky frantically searching for God, we are committing the ultimate cosmic error.
                The Upanishad is screaming at the top of its lungs that the entire staggering cosmos, the stars, the outer space, and the sacred grass are entirely compressed directly inside this tiny biological shell.
                You are definitively not a pathetic, ordinary human; you are completely, independently, and absolutely an infinite, self-sustaining Universe (Microcosm).
                Supreme, raw purity flows through your every microscopic pore, and literal infinite Space and absolute Void permanently reside right inside your ribcage.
                He who aggressively violently crashes into this internal outer space of his own heart through lethal Meditation...
                Can absolutely never again be touched even by the shadow of worldly agony, catastrophic disease, or biological death.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 18,
            sanskrit = "य एवं विद्वान् प्राणाग्निहोत्रं जुहोति । स सर्वपापेभ्यो मुक्तो भवति ।",
            hindi = """
                (पापमुक्ति का महा-सिद्धांत): उपनिषद अपने अंतिम चरणों में पहुँचते हुए सबसे बड़ी उद्घोषणा करता है।
                "जो भी परम ज्ञानी (विद्वान) इस भयानक रहस्य को समझकर हर रोज़ 'प्राणाग्निहोत्र' रूपी यज्ञ करता है..."
                वह इस जन्म के, और पिछले करोड़ों जन्मों के सभी भयंकर से भयंकर पापों से हमेशा के लिए मुक्त (Free) हो जाता है।
                दुनिया के सारे तीर्थ नहाने से, या करोड़ों रुपये दान करने से जो शुद्धि नहीं मिलती, वह ज्ञान की इस अग्नि से एक पल में मिल जाती है।
                पाप असल में क्या है? शरीर को अपना मानना और अज्ञान में जीना ही सबसे बड़ा पाप है।
                जब इंसान यह मानकर भोजन करता है कि "मैं परब्रह्म हूँ, और मैं अपने भीतर के प्राणों (देवताओं) को तृप्त कर रहा हूँ"...
                तो वह साधारण इंसान नहीं रह जाता, वह साक्षात अग्नि बन जाता है, और अग्नि में कोई भी कचरा (पाप) टिक नहीं सकता।
                उसके हाथों से अनजाने में हुआ कोई भी बुरा कर्म उसे बांध नहीं सकता; वह कर्मों के जाल (Karma) से बाहर निकल जाता है।
                यह उपनिषद इंसानियत को सबसे तेज़ और सबसे शक्तिशाली रास्ता दे रहा है—केवल अपनी सोच और चेतना (Consciousness) को बदल डालो।
                कर्मकाण्ड में उलझने की ज़रूरत नहीं है; बस साँस लेने और खाना खाने की रोज़मर्रा की क्रिया को ही ईश्वर की पूजा बना दो।
            """.trimIndent(),
            english = """
                (The Grand Principle of Sin Eradication): Approaching its terrifying climax, the Upanishad delivers its most colossal, absolute proclamation.
                "Any supreme, enlightened master (Vidvan) who flawlessly grasps this horrific secret and executes this 'Pranagnihotra' sacrifice every single day..."
                Is instantly, violently, and permanently liberated from the most catastrophic, unforgivable sins of this life and trillions of previous incarnations combined.
                The absolute purification that cannot be achieved by bathing in all earthly pilgrimages or donating billions in wealth, is triggered in a single microsecond by this fire of cosmic knowledge.
                What is the literal definition of Sin? Identifying strictly with this rotting biological body and existing in pathetic cosmic ignorance is the absolute greatest sin.
                When a human consumes food with the roaring realization that "I am explicitly the Supreme Brahman, and I am forcefully satisfying the cosmic deities (Pranas) within my biology"...
                He ceases to be a pathetic human; he literally mutates into raw, blazing Fire, and absolutely no garbage (Sin) can survive inside Fire.
                Even horrific negative actions performed accidentally by his physical hands absolutely fail to bind him; he violently shatters out of the brutal matrix of Karma completely.
                This Upanishad is handing humanity the absolute fastest, most lethal weapon of liberation—simply, brutally alter your fundamental Consciousness and perception.
                There is zero need to become entangled in pathetic external theatrical rituals; merely mutate the mundane, biological acts of breathing and eating into the highest, supreme worship of God.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 19,
            sanskrit = "न स पुनरावर्तते न स पुनरावर्तते ।",
            hindi = """
                (जन्म-मरण के चक्र का अंत): यह उपनिषदों का सबसे ताक़तवर और खौफनाक वादा है, जिसे दो बार दोहराया गया है: "वह लौटकर नहीं आता, वह कभी लौटकर नहीं आता!"
                इसका मतलब है कि जो व्यक्ति प्राणाग्निहोत्र के इस परम अद्वैत ज्ञान को पा लेता है...
                उसे मरने के बाद इस सड़ी हुई, दुख और धोखे से भरी भौतिक दुनिया में दोबारा जन्म नहीं लेना पड़ता।
                पुनर्जन्म कोई अच्छी चीज़ नहीं है, यह वासनाओं और अधूरे लालच की सज़ा है।
                जब इंसान की सारी इच्छाएं जठराग्नि के यज्ञ में जलकर भस्म हो जाती हैं, तो उसके पास वापस लौटने का कोई कारण (Karma) नहीं बचता।
                वह सीधे परब्रह्म (Infinite Source) में उसी तरह घुल जाता है, जैसे समुद्र में गिरी हुई पानी की एक बूँद हमेशा के लिए समुद्र बन जाती है।
                कोई भी भगवान, कोई भी देवता या कोई भी यमराज उसे वापस इस धरती की जेल में नहीं धकेल सकता।
                'न स पुनरावर्तते' की यह गर्जना इंसान की आत्मा की सबसे बड़ी जीत का ऐलान है।
                मौत अब उसके लिए कोई डरावना अंत नहीं है, बल्कि यह ब्रह्मांड की सबसे बड़ी और शानदार आज़ादी (Liberation) का दरवाज़ा है।
                जिसने अपने शरीर को ही ब्रह्मांड और भोजन को ही हविष्य बना लिया, उसने मृत्यु की छाती पर पैर रखकर परमेश्वर का सिंहासन छीन लिया है।
            """.trimIndent(),
            english = """
                (The Brutal Termination of the Rebirth Cycle): This is the most lethal, terrifying, and absolute ironclad promise of the Upanishads, violently repeated twice for maximum cosmic impact: "He absolutely never returns, He absolutely NEVER returns!"
                This explicitly dictates that the specific human who forcefully weaponizes this supreme non-dual knowledge of Pranagnihotra...
                Is absolutely never forced to be reborn back into this rotting, deceptive, agony-filled physical matrix ever again after biological death.
                Reincarnation is definitively not a beautiful blessing; it is a brutal, agonizing punishment directly caused by unfulfilled lust and pathetic biological greed.
                When every single microscopic trace of human desire is mercilessly incinerated to ashes in the sacrificial fire of Jatharagni, absolutely zero reason (Karma) survives to drag him back.
                He dissolves violently and perfectly straight into the Supreme Brahman (The Infinite Source), exactly like a drop of water crashing into the ocean and permanently mutating into the ocean itself.
                Absolutely no deity, no God, and no Lord of Death (Yamaraja) possesses the authority or power to shove him back into this earthly biological prison.
                This roaring declaration of 'Na Sa Punaravartate' is the absolute, ultimate victory cry of the human Soul over the cosmos.
                Biological death is definitively no longer a terrifying extermination for him; it is merely the explosive gateway to the most colossal, staggering absolute Liberation in existence.
                He who mutated his own biology into a Universe, and his food into a cosmic offering, has literally placed his foot on the chest of Death and seized the absolute throne of God.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 20,
            sanskrit = "एतज्ज्ञानं ज्ञात्वा यो भुङ्क्ते । स भुङ्क्ते सर्वम् ।",
            hindi = """
                (सर्व-भक्षण का महा-सिद्धांत): यह श्लोक अद्वैत वेदांत की एक बेहद खौफनाक और असीम चोटी (Peak) है।
                "जो इस प्रलयंकारी ज्ञान को जानकर, पूरी चेतना के साथ भोजन करता है... वह असल में 'सब कुछ' खा जाता है (स भुङ्क्ते सर्वम्)!"
                इसका अर्थ यह नहीं कि वह दुनिया भर का खाना खा लेता है। इसका रहस्य बेहद गहरा है।
                जब इंसान यह जान लेता है कि "मैं परब्रह्म हूँ", तो वह अपने छोटे शरीर की सीमाओं से बाहर निकलकर पूरे ब्रह्मांड में फैल जाता है।
                तब दुनिया में कोई भी व्यक्ति, कहीं भी कुछ भी खा रहा हो, वह असल में उसी योगी (परब्रह्म) के मुँह में जा रहा होता है।
                क्योंकि ब्रह्मांड में केवल एक ही खाने वाला (भोक्ता) है, और वह है परमात्मा, जो अब वह योगी खुद बन चुका है।
                यह 'मैं ही सब कुछ हूँ' (I am Everything) का वह खौफनाक अनुभव है, जहाँ दूसरा कोई बचता ही नहीं।
                जब दूसरा कोई है ही नहीं, तो ईर्ष्या, लालच और नफरत अपने आप मर जाती है।
                यही परम तृप्ति (Absolute Satisfaction) है; इसके बाद इंसान को कभी किसी चीज़ की भूख या कमी महसूस नहीं होती।
                उसका एक निवाला पूरे ब्रह्मांड को तृप्त कर देता है, क्योंकि वह और ब्रह्मांड अब बिल्कुल एक हो चुके हैं।
            """.trimIndent(),
            english = """
                (The Grand Principle of Cosmic Consumption): This precise verse represents a terrifyingly extreme, boundless, absolute peak of Non-Dual Vedanta.
                "He who consumes a meal heavily armed with this apocalyptic cosmic knowledge and awakened consciousness... literally ends up consuming 'Absolutely Everything' in existence (Sa Bhunkte Sarvam)!"
                This explicitly does not mean he physically gluts on all earthly food. The horrifying secret here is profoundly deeper.
                When the human flawlessly realizes "I am the exact Supreme Brahman," he violently shatters out of the pathetic microscopic limits of his biology and expands identically into the entire Universe.
                At that exact threshold, if absolutely any entity, anywhere in the cosmos, is consuming food, that food is in absolute reality entering directly into the mouth of that exact Yogi (Brahman).
                Because in the entire cosmic structure, there exists strictly only ONE absolute consumer (Bhokta), and that is the Supreme God, into which the Yogi has completely mutated.
                This is the spine-chilling, earth-shattering realization of 'I am Everything,' where absolutely nothing 'Other' survives in existence.
                When the concept of 'the Other' is brutally annihilated, all toxic jealousy, greed, and hatred suffer instantaneous, violent death.
                This is the state of Absolute Cosmic Satisfaction; after this, the human absolutely never experiences psychological starvation or microscopic lack ever again.
                His single biological bite of food instantaneously satisfies the entire cosmic matrix, because he and the Universe have violently fused into one exact entity.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 21,
            sanskrit = "ब्रह्मार्पणं ब्रह्म हविर्ब्रह्माग्नौ ब्रह्मणा हुतम् ।",
            hindi = """
                (गीता का बीज मंत्र और पूर्ण अद्वैत): यह मंत्र (जो भगवद्गीता में भी आता है) प्राणाग्निहोत्र का सबसे बड़ा ब्रह्मास्त्र है।
                यहाँ सब कुछ शून्य होकर केवल एक ही तत्व बचता है—'ब्रह्म'।
                जिस चम्मच या बर्तन (अर्पण) से आहुति डाली जा रही है, वह बर्तन कोई धातु नहीं, साक्षात ब्रह्म है।
                जो भोजन या घी (हवि) अग्नि में डाला जा रहा है, वह खाना नहीं, वह भी साक्षात ब्रह्म का ही रूप है।
                जिस पेट की आग (अग्नौ) में वह खाना जल रहा है, वह आग भी ब्रह्म ही है।
                और जो इंसान (ब्रह्मणा) अपने हाथों से वह खाना खा रहा है, वह इंसान भी कोई और नहीं, साक्षात ब्रह्म ही है।
                जब क्रिया, साधन, सामग्री और कर्ता—यह चारों मिलकर बिल्कुल एक (One) हो जाते हैं, तब दुनिया का भ्रम टूट जाता है।
                इस भयानक सत्य को जीते जी अनुभव करना ही मोक्ष है।
                योगी जब इस भाव से खाना खाता है, तो उसे कर्मों का कोई पाप या पुण्य नहीं लगता।
                वह कर्म करते हुए भी अकर्म (Non-action) की सबसे ऊँची और रहस्यमयी अवस्था में रहता है, जहाँ वह बस एक गवाह (Witness) बन जाता है।
            """.trimIndent(),
            english = """
                (The Seed Mantra of the Gita and Absolute Non-Duality): This devastating mantra (also notoriously deployed in the Bhagavad Gita) is the ultimate nuclear weapon (Brahmastra) of Pranagnihotra.
                Here, absolutely everything collapses into a terrifying cosmic void, leaving strictly only one raw element standing: 'Brahman'.
                The specific spoon, instrument, or vessel (Arpanam) actively used to pour the offering is definitively not physical metal; it is explicitly Brahman.
                The raw food, rice, or clarified butter (Havi) violently hurled into the fire is absolutely not biological matter; it is the physical manifestation of Brahman.
                The roaring metabolic fire blazing inside the stomach (Agnau) actively incinerating that food is undeniably Brahman itself.
                And the biological human entity (Brahmana) physically executing the mechanical act of eating is absolutely none other than Brahman acting on Itself.
                When the Action, the Instrument, the Material, and the Doer violently crash into each other and flawlessly fuse into absolute 'One', the pathetic illusion of the Matrix shatters permanently.
                To physically, violently experience this terrifying absolute truth while still breathing is the exact definition of Moksha.
                When the Yogi consumes food locked in this catastrophic realization, absolutely zero toxic Karma, sin, or fake merit can ever attach to him.
                Even while aggressively performing severe physical actions, he remains anchored in the highest, most secretive state of 'Non-Action' (Akarma), reduced to a terrifyingly silent, absolute cosmic Witness.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 22,
            sanskrit = "ब्रह्मैव तेन गन्तव्यं ब्रह्मकर्मसमाधिना ।",
            hindi = """
                (कर्म ही समाधि है और ब्रह्म ही लक्ष्य है): पिछले मंत्र का यह दूसरा और अंतिम हिस्सा है, जो लक्ष्य को स्पष्ट करता है।
                "जो इंसान अपने हर एक काम (खाना, पीना, चलना) को पूरी तरह 'ब्रह्म-कर्म' (ईश्वर की क्रिया) मानकर करता है..."
                वह कोई साधारण जीवन नहीं जी रहा है; उसकी खुली आँखें और काम करते हुए हाथ भी साक्षात 'समाधि' (Meditation) की अवस्था में हैं।
                समाधि का मतलब आंखें बंद करके जंगल में बैठना नहीं है; हर पल, हर काम में ईश्वर को देखना ही सबसे भयंकर और असली समाधि है।
                ऐसा योगी जब इस जीवन को छोड़ता है, तो उसकी मंज़िल (गन्तव्य) कोई स्वर्ग या बैकुंठ नहीं होता।
                उसकी अंतिम और एकमात्र मंज़िल 'स्वयं परब्रह्म' (ब्रह्मैव) होती है, जहाँ वह ईश्वर से मिलने नहीं जाता, बल्कि खुद ईश्वर बन जाता है।
                स्वर्ग तो पुण्य खत्म होने पर छिन जाता है, लेकिन जो ब्रह्म में समा गया, उसे कोई हिला नहीं सकता।
                प्राणाग्निहोत्र हमें यही सिखाता है कि सन्यास भागने का नाम नहीं, बल्कि दुनिया के हर कर्म को यज्ञ में बदल देने का नाम है।
                जब खाने जैसी साधारण क्रिया समाधि बन सकती है, तो इंसान का पूरा जीवन ही एक जीता-जागता चमत्कार बन जाता है।
                यही इंसान के जीवन का अंतिम, सर्वोच्च और सबसे खौफनाक सच है, जिसके आगे कोई विज्ञान या ज्ञान नहीं टिकता।
            """.trimIndent(),
            english = """
                (Action is Samadhi and Brahman is the Target): This is the lethal, absolute concluding half of the previous cosmic mantra, brutally clarifying the final target.
                "Any human who violently mutates every single mechanical action (eating, drinking, walking) completely into 'Brahma-Karma' (The active operation of God)..."
                Is definitively not living a mundane biological existence; his wide-open eyes and aggressively moving hands are permanently locked in the highest absolute state of 'Samadhi' (Supreme Trance).
                True Samadhi is absolutely not about shutting your eyes and hiding pathetically in a forest; perceiving the blazing God in every microsecond of violent action is the most terrifying and authentic Samadhi.
                When such a colossal Yogi finally discards this biological shell, his ultimate destination (Gantavya) is definitely not a cheap paradise or a fake heaven.
                His final, absolute, and exclusive destination is 'The Supreme Brahman Itself' (Brahmaiva), where he does not 'meet' God, but flawlessly and permanently mutates exactly into God.
                Temporary heavens are violently snatched away when your cosmic merit expires, but he who melts into Brahman becomes a terrifying, immovable cosmic mountain that nothing can shake.
                Pranagnihotra ruthlessly teaches humanity that authentic Sannyasa is not cowardice or escape, but the violent alchemy of mutating every worldly action into a cosmic sacrifice.
                When an act as mundane as swallowing food forcefully becomes Samadhi, the entire biological existence of the human mutates into a walking, living, terrifying cosmic miracle.
                This is the absolute, ultimate, highest, and most spine-chilling truth of human existence, against which all pathetic material science and philosophy are violently shattered into dust.
            """.trimIndent()
        ),
        PranagnihotraShloka(
            id = 23,
            sanskrit = "इत्युपनिषत् । ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (उपनिषद का अंत और परम शांति): यहाँ यह रहस्यमयी और प्रलयंकारी 'प्राणाग्निहोत्र उपनिषद' पूरी तरह से संपन्न (खत्म) होता है।
                ऋषियों ने इंसान को बाहर के कर्मकांडों के जाल से निकालकर, उसे उसके अपने शरीर के भीतर बैठे साक्षात भगवान से मिला दिया है।
                इस परम सत्य को जानने के बाद अब कुछ भी जानना, खोजना या पाना बाकी नहीं रह जाता।
                अंत में तीन बार 'ॐ शांति' का उच्चारण किया जाता है, जो ब्रह्मांड की तीन सबसे खौफनाक ताकतों को शांत करने के लिए है।
                पहली शांति: आधिभौतिक (दुनिया के लोगों, जानवरों और दुश्मनों से मिलने वाले बाहरी दुखों का अंत)।
                दूसरी शांति: आधिदैविक (ग्रहों, तूफानों, भूकंप और देवताओं के प्रकोप से मिलने वाले प्राकृतिक दुखों का अंत)।
                तीसरी शांति: आध्यात्मिक (अपने ही शरीर की बीमारियों और मन के भीतर उठने वाले डिप्रेशन और अहंकार रूपी दुखों का अंत)।
                जब इंसान यह मान लेता है कि "मैं परब्रह्म हूँ", तो यह तीनों तरह के खौफनाक दुख हमेशा के लिए राख हो जाते हैं।
                उसके जीवन में एक ऐसी गहरी, सन्नाटे से भरी और अटल 'शांति' उतर आती है, जिसे मौत भी नहीं तोड़ सकती।
                यही सनातन धर्म का अंतिम रहस्य है, यही वेदों का शिखर है। ॐ! हर तरफ परम शांति हो!
            """.trimIndent(),
            english = """
                (The Termination of the Upanishad and Absolute Peace): Exactly here, this highly secretive, apocalyptic, and profound 'Pranagnihotra Upanishad' achieves its absolute completion.
                The ancient sages have violently dragged humanity out of the pathetic trap of external theatrical rituals, forcefully slamming them face-to-face with the literal God residing within their own biology.
                After fully absorbing this terrifying cosmic truth, absolutely nothing remains to be known, searched for, or achieved in this entire universe.
                At the absolute climax, 'Om Shanti' is aggressively chanted exactly three times, designed as a lethal weapon to instantly pacify the three most terrifying forces of the cosmos.
                First Peace: Adhibhautika (the violent termination of all external agonies inflicted by humans, animals, enemies, and the physical matrix).
                Second Peace: Adhidaivika (the total annihilation of natural miseries caused by planetary wrath, devastating storms, earthquakes, and angry cosmic deities).
                Third Peace: Adhyatmika (the permanent slaughter of internal agony caused by biological diseases, psychological depression, and the vicious ego within).
                When a human irrevocably locks into the absolute realization "I am the Supreme Brahman," these three categories of horrific agony are instantaneously incinerated to ashes forever.
                A terrifyingly deep, deathly silent, unshakeable, and bottomless 'Peace' violently descends into his existence, which even biological death cannot fracture.
                This is the absolute final secret of Sanatana Dharma; this is the staggering, ultimate peak of the Vedas. OM! Let there be absolute, terrifying, supreme Peace everywhere!
            """.trimIndent()
        )
    )
}