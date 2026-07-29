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
data class VajrasuchiShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VajrasuchiUpanishadScreen() {
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
                if (shlokaNumber != null && shlokaNumber in 1..9) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-9)") },
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
            itemsIndexed(vajrasuchiShlokasList) { _, shloka ->
                VajrasuchiShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun VajrasuchiShlokaCard(shloka: VajrasuchiShloka) {
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

val vajrasuchiShlokasList: List<VajrasuchiShloka> = listOf(
    VajrasuchiShloka(
        id = 1,
        sanskrit = "वज्रसूचीं प्रवक्ष्यामि शास्त्रमज्ञानभेदनम् । दूषणं ज्ञानहीनानां भूषणं ज्ञानचक्षुषाम् ॥ १ ॥ ब्राह्मक्षत्रियवैश्यशूद्रा इति चत्वारो वर्णाः ... को वा ब्राह्मणो नाम किं जीवः किं देहः किं जातिः किं ज्ञानं किं कर्म किं धार्मिक इति ॥",
        hindi = """
            (वज्रसूची का अर्थ): 'वज्र' का अर्थ है हीरा (Diamond) और 'सूची' का अर्थ है सुई (Needle)।
            यह उपनिषद ज्ञान की वह अत्यंत कठोर और तीक्ष्ण हीरे की सुई है जो अज्ञान के सबसे मोटे परदे को तुरंत भेद देती है।
            यह महान शास्त्र अज्ञानी और पाखंडी लोगों के लिए एक बहुत बड़ा 'दूषण' (दोष/भयंकर फटकार) है।
            और जिन सच्चे साधकों के 'ज्ञान-चक्षु' (Wisdom-eyes) खुल चुके हैं, उनके लिए यह उपनिषद एक अत्यंत सुंदर 'आभूषण' (गहना) है।
            इस उपनिषद का मुख्य और सबसे क्रांतिकारी प्रश्न यह है: वास्तव में सच्चा 'ब्राह्मण' (Brahmin) कौन है?
            क्या यह अमर 'जीव' (आत्मा) ब्राह्मण है? या क्या यह हाड़-मांस का नाशवान 'शरीर' (देह) ब्राह्मण है?
            क्या जन्म से मिलने वाली 'जाति' (Caste) ब्राह्मण है? या क्या शास्त्रों की कोरी 'जानकारी' (ज्ञान) ब्राह्मण है?
            क्या महान 'कर्म' करने वाला ब्राह्मण है? या क्या 'धार्मिक' (दान-पुण्य और यज्ञ करने वाला) ब्राह्मण है?
            प्राचीन काल में जब जातिवाद चरम पर था, तब इस उपनिषद ने समाज के सबसे बड़े अहंकार पर सीधा प्रहार किया।
            यह उपनिषद इंसान की बाहरी और झूठी पहचान को पूरी तरह से मिटाकर उसे उसके असली ईश्वरीय रूप से साक्षात् मिलवाता है।
        """.trimIndent(),
        english = """
            (Meaning of Vajrasuchi): 'Vajra' translates perfectly to a Diamond, and 'Suchi' literally means a razor-sharp Needle.
            This magnificent Upanishad is exactly that exceptionally hard, razor-sharp diamond needle that effortlessly pierces the thickest veil of dark ignorance.
            This supreme scripture is a terrifying 'Dushanam' (fierce condemnation/flaw) for deeply ignorant, arrogant hypocrites.
            And strictly for those sincere seekers whose 'Jnana-chakshu' (Eyes of Wisdom) have opened, it is an exquisitely beautiful 'Bhushanam' (ornament).
            The absolute primary and most exceptionally revolutionary question of this entire Upanishad is: Who exactly is a true 'Brahmin'?
            Is the immortal 'Jiva' (Soul) the Brahmin? Or is this perishable, fleshy 'Body' (Deha) the Brahmin?
            Is the physical 'Caste' (Jati) acquired merely by birth the Brahmin? Or is cheap scriptural 'Knowledge' (Jnana) the Brahmin?
            Is the performer of great 'Karma' (Action) the Brahmin? Or is the 'Dharmika' (the one doing endless rituals and massive charity) the Brahmin?
            In ancient times when the toxic caste system was at its absolute blinding peak, this Upanishad violently struck the society's absolute greatest ego.
            This Upanishad completely annihilates a human being's false, external, superficial identity and introduces him directly to his true, divine nature.
        """.trimIndent()
    ),
    VajrasuchiShloka(
        id = 2,
        sanskrit = "तत्र प्रथमो जीवो ब्राह्मण इति चेत् तन्न । अतीतानागतानेकडेहानां जीवस्यैकरूपत्वात् ... तस्माज्जिवो न ब्राह्मणः ॥ २ ॥",
        hindi = """
            सबसे पहला प्रश्न: क्या 'जीव' (आत्मा) ब्राह्मण है? उपनिषद अत्यंत कठोरता से उत्तर देता है: बिल्कुल नहीं (तन्न)।
            क्योंकि आत्मा (जीव) तो केवल एक ही है, पर वह अपने कर्मों के अनुसार भूतकाल में हजारों अलग-अलग शरीरों में जा चुकी है।
            वह आत्मा भविष्य में भी न जाने कितने पशु-पक्षियों और अलग-अलग जातियों के शरीरों में प्रवेश करेगी।
            एक ही आत्मा कल कुत्ते के शरीर में थी और आज मनुष्य के शरीर में है; आत्मा का अपना कोई भौतिक आकार या जाति बिल्कुल नहीं होती।
            चूँकि सभी शरीरों (इंसान से लेकर कीड़े तक) में धड़कने वाली आत्मा बिल्कुल एक ही (ऐकरूपत्वात्) है।
            तो फिर उस पवित्र आत्मा को 'ब्राह्मण' या 'शूद्र' कैसे कहा जा सकता है? आत्मा तो इन सब सांसारिक उपाधियों से पूरी तरह आज़ाद है।
            इसलिए (तस्मात्), यह 100% सिद्ध होता है कि जीव (आत्मा) कभी भी जन्म या जाति से ब्राह्मण नहीं हो सकता।
            यह तार्किक श्लोक इस झूठे भ्रम को पूरी तरह काट देता है कि कोई आत्मा जन्म से ही 'पवित्र' या 'ऊँची' होती है।
            आत्मा पानी की तरह परम शुद्ध है; वह जिस भी बर्तन (शरीर) में जाती है, उसका अपना कोई जाति-धर्म नहीं होता।
            वेदान्त का यह नियम इंसान के उस भयंकर अहंकार को जड़ से उखाड़ देता है जो सोचता है कि उसकी आत्मा दूसरों से ज्यादा श्रेष्ठ है।
        """.trimIndent(),
        english = """
            The absolute first question: Is the 'Jiva' (Soul) a Brahmin? The Upanishad fiercely and firmly answers: Absolutely not (Tanna).
            Because the Soul (Jiva) is strictly one, yet strictly according to its karmas, it has already helplessly entered thousands of different bodies in the past.
            That exact same Soul will inevitably enter countless future bodies of various animals, birds, and entirely different human castes.
            The exact same Soul was in a dog's body yesterday and is strictly in a human's body today; the Soul possesses absolutely no physical form or caste.
            Since the pulsating Soul perfectly present in absolutely all bodies (from great humans down to filthy insects) is exactly one and identical (Ekarupatvat).
            How on earth can that pure Soul possibly be labeled a 'Brahmin' or a 'Shudra'? The Soul is entirely and flawlessly free from all such worldly titles.
            Therefore (Tasmat), it is 100% flawlessly proven that the Jiva (Soul) can absolutely never be the Brahmin by birth.
            This razor-sharp logic completely destroys the false, toxic assumption that a specific Soul is inherently 'pure' or 'superior' simply from birth.
            The Soul is as immaculately pure as water; whatever physical vessel (body) it enters, it acquires absolutely no caste or religion of its own.
            This supreme rule of Vedanta violently uproots the human's terrifying ego which falsely and arrogantly claims his Soul is somehow superior to others.
        """.trimIndent()
    ),
    VajrasuchiShloka(
        id = 3,
        sanskrit = "तर्हि देहो ब्राह्मण इति चेत् तन्न । आचाण्डालादिपर्यन्तानां मनुष्याणां पञ्चभौतिकत्वेन देहस्यैकरूपत्वात् ... तस्माद्देहो न ब्राह्मणः ॥ ३ ॥",
        hindi = """
            तो फिर क्या यह भौतिक 'देह' (शरीर) ब्राह्मण है? उपनिषद तुरंत कहता है: बिल्कुल नहीं (तन्न)।
            क्योंकि एक चांडाल (समाज की सबसे नीची जाति) से लेकर एक तथाकथित महान ब्राह्मण तक, सभी मनुष्यों का भौतिक शरीर एक जैसा ही है।
            पूरी दुनिया के सभी इंसानों का शरीर केवल उन्हीं पाँच महाभूतों (पृथ्वी, जल, अग्नि, वायु, आकाश) से ही मिलकर बना है।
            सभी के शरीर में वही बुढ़ापा, वही खौफनाक मौत और वही भयंकर बीमारियां (दोष) एक समान रूप से आते हैं।
            प्रकृति का ऐसा कोई नियम नहीं है कि ब्राह्मण का शरीर हमेशा गोरा हो और शूद्र का शरीर हमेशा काला हो।
            जब मौत के बाद शरीर को जलाया जाता है, तो ब्राह्मण का शरीर भी उसी राख में बदलता है जिसमें एक चांडाल का शरीर जलकर बदलता है।
            यदि शरीर ही ब्राह्मण है, तो पिता के मरने पर जब पुत्र उसके शरीर को जलाता है, तो पुत्र को 'ब्रह्महत्या' (ब्राह्मण को मारने का पाप) का पाप लगना चाहिए!
            पर ऐसा बिल्कुल नहीं होता, क्योंकि जलने वाला भौतिक शरीर कभी भी ब्राह्मण था ही नहीं।
            इसलिए (तस्मात्), यह 100% सिद्ध हो गया कि यह हाड़-मांस का और मल-मूत्र से भरा शरीर कभी ब्राह्मण नहीं हो सकता।
            यह श्लोक रंग-भेद (Racism) और शरीर-भेद (Casteism by physical body) का पूरी तरह से वैज्ञानिक और तार्किक विनाश (Destruction) करता है।
        """.trimIndent(),
        english = """
            Then is this gross physical 'Body' (Deha) the Brahmin? The Upanishad fiercely and instantly answers: Absolutely not (Tanna).
            Because from a Chandala (the absolute lowest outcast in society) right up to a so-called great Brahmin, the physical body of all humans is exactly identical.
            The physical bodies of absolutely all humans globally are manufactured strictly and exclusively from the exact same five gross elements (Earth, Water, Fire, Air, Space).
            The exact same terrifying old age, the same agonizing death, and the same horrific diseases uniformly and ruthlessly attack absolutely everyone's body.
            There is absolutely no biological rule in Nature dictating that a Brahmin's body must always be fair-skinned and a Shudra's body permanently dark.
            When the corpse is aggressively burnt after death, a Brahmin's body turns into the exact same ashes as the body of an outcast Chandala.
            If the physical body itself were the Brahmin, then when a son burns his dead father's corpse, the son must strictly incur the massive, unforgivable sin of 'Brahmahatya' (murdering a Brahmin)!
            But that absolutely never happens, simply because the burning physical body was absolutely never the Brahmin in the first place.
            Therefore (Tasmat), it is 100% flawlessly proven that this fleshy body filled completely with urine and feces can absolutely never be the Brahmin.
            This magnificent verse executes a completely Scientific and fiercely Logical absolute annihilation of all Racism and physical Casteism.
        """.trimIndent()
    ),
    VajrasuchiShloka(
        id = 4,
        sanskrit = "तर्हि जातिर्ब्राह्मण इति चेत् तन्न । तत्र जात्यन्तरजन्तुष्वनेकजातिसम्भावात् महर्षयो बहवः सन्ति ... तस्माज्जातिर्न ब्राह्मणः ॥ ४ ॥",
        hindi = """
            तो फिर क्या 'जाति' (किसी विशेष कुल या ऊँचे परिवार में जन्म लेना) ब्राह्मण है? उपनिषद कड़ाई से कहता है: बिल्कुल नहीं (तन्न)।
            क्योंकि दुनिया में ऐसे अनगिनत महर्षि हुए हैं जिनका जन्म किसी ब्राह्मण कुल में नहीं, बल्कि अत्यंत विचित्र और निचली जगहों से हुआ है।
            महान महर्षि 'ऋष्यशृंग' का जन्म एक हिरणी के गर्भ से हुआ था, और महर्षि 'कौशिक' कुशा घास से पैदा हुए थे।
            महान ऋषि 'जाम्बूक' एक सियारिन (Jackal) से पैदा हुए, और महर्षि 'वाल्मीकि' का जन्म एक नीची माने जाने वाली चांडाल जाति में हुआ था।
            वेदों का ज्ञान देने वाले 'महर्षि व्यास' एक साधारण मछुआरी (मल्लाह की बेटी) के गर्भ से उत्पन्न हुए थे।
            महान 'वशिष्ठ' ऋषि का जन्म वेश्या (उर्वशी) से हुआ था, और ऋषि 'अगस्त्य' एक मिट्टी के घड़े से पैदा हुए थे।
            इन सभी महान ऋषियों की 'जाति' जन्म से बिल्कुल भी ब्राह्मण नहीं थी, फिर भी वे अपने ज्ञान के कारण विश्व के सबसे बड़े 'ब्राह्मण' कहलाए।
            इससे यह बात पूरी तरह सिद्ध हो जाती है कि इंसान अपनी 'जन्म की जाति' से ब्राह्मण कभी नहीं होता।
            ब्राह्मणत्व कोई 'जीन' (Gene) या डीएनए (DNA) नहीं है जो माता-पिता से बच्चों को मुफ्त में ट्रांसफर (Transfer) हो जाए।
            इसलिए (तस्मात्), केवल जन्म के आधार पर किसी को ऊँचा या नीचा मानना दुनिया का सबसे बड़ा झूठ और अंधकार है।
        """.trimIndent(),
        english = """
            Then is 'Caste' (Jati / taking birth in a specific high family) the Brahmin? The Upanishad ruthlessly answers: Absolutely not (Tanna).
            Because there have been countless great sages in the world who were absolutely not born in Brahmin families, but from exceedingly bizarre and extremely low origins.
            The great Sage 'Rishyasringa' was miraculously born directly from the womb of a deer, and Sage 'Kaushika' was born from Kusha grass.
            The magnificent Sage 'Jambuka' was born from a wild Jackal, and the great Sage 'Valmiki' was born strictly in a Chandala (low outcast) caste.
            The supreme 'Maharishi Vyasa', who compiled the sacred Vedas, was born directly from the womb of a simple, ordinary fisherwoman.
            The colossal Sage 'Vasishtha' was born from a courtesan (Urvashi), and Sage 'Agastya' was miraculously born from an earthen clay pot.
            The birth 'Caste' of absolutely all these great sages was never Brahmin, yet due strictly to their supreme wisdom, they became known as the world's absolute greatest 'Brahmins'.
            This flawlessly and irrefutably proves that a human being absolutely never becomes a Brahmin strictly based on his 'Caste by physical birth'.
            Brahminhood is absolutely not a 'Gene' or physical DNA that magically and effortlessly transfers for free from parents to their children.
            Therefore (Tasmat), considering someone high or low strictly based purely on their physical birth is the world's absolute greatest lie and dark ignorance.
        """.trimIndent()
    ),
    VajrasuchiShloka(
        id = 5,
        sanskrit = "तर्हि ज्ञानं ब्राह्मण इति चेत् तन्न । क्षत्रियादयोऽपि परमार्थदर्शिनोऽभिज्ञा बहवः सन्ति ... तस्माज्ज्ञानं न ब्राह्मणः ॥ ५ ॥",
        hindi = """
            तो फिर क्या 'ज्ञान' (शास्त्रों को पढ़ना और भारी जानकारी होना) ब्राह्मण है? उपनिषद साफ कहता है: बिल्कुल नहीं (तन्न)।
            क्योंकि दुनिया में ऐसे बहुत से 'क्षत्रिय' (राजा) और अन्य जातियों के लोग हुए हैं जो परमार्थ (सत्य) को जानने वाले अत्यंत बड़े ज्ञानी (अभिज्ञा) थे।
            राजा 'जनक' जन्म से एक क्षत्रिय थे, फिर भी उनका ज्ञान इतना महान था कि बड़े-बड़े ब्राह्मण ऋषि उनसे ब्रह्मज्ञान सीखने जाते थे।
            केवल वेदों, पुराणों और स्मृतियों को तोते की तरह रट लेने से कोई भी व्यक्ति ब्राह्मण नहीं बन जाता।
            'ज्ञान' (Knowledge / Information) तो आज के समय में इंटरनेट या किताबों से कोई भी साधारण इंसान प्राप्त कर सकता है।
            बहुत से तथाकथित 'ज्ञानी' ऐसे होते हैं जो मंच पर बहुत अच्छा बोलते हैं, पर अंदर से वे लालच, क्रोध और वासना से भरे होते हैं।
            रावण भी चारों वेदों का महान ज्ञाता था, फिर भी उसके बुरे कर्मों के कारण उसे राक्षस ही कहा गया, ब्राह्मण नहीं।
            इसलिए केवल दिमागी इन्फॉर्मेशन (Intellectual information) को इकट्ठा कर लेना ब्राह्मण होने की निशानी बिल्कुल नहीं है।
            जब तक वह ज्ञान इंसान के जीवन का 'साक्षात् अनुभव' (Living Experience) न बन जाए, तब तक वह कोरा ज्ञान बिल्कुल कचरा है।
            इसलिए (तस्मात्), केवल किताबी ज्ञान (Information) कभी भी इंसान को सच्चा ब्राह्मण नहीं बना सकता।
        """.trimIndent(),
        english = """
            Then is 'Knowledge' (Jnana / reading scriptures and having heavy information) the Brahmin? The Upanishad fiercely answers: Absolutely not (Tanna).
            Because there have been countless 'Kshatriyas' (Kings) and people of other castes in the world who were supreme scholars (Abhijna) flawlessly knowing the Ultimate Truth.
            King 'Janaka' was strictly a Kshatriya by birth, yet his wisdom was so colossal that great Brahmin sages went specifically to him to learn Brahma-Jnana.
            Merely memorizing the Vedas, Puranas, and Smritis exactly like a mindless parrot absolutely does not transform a person into a Brahmin.
            Mere 'Knowledge' (Information) can easily be acquired by absolutely any ordinary human today through the Internet or cheap books.
            There are countless so-called 'Scholars' who speak magnificently on stage, but internally they are heavily packed with toxic greed, anger, and deep lust.
            Ravana was also a massive, supreme master of all four Vedas, yet strictly due to his evil actions, he was explicitly called a demon, never a Brahmin.
            Therefore, merely accumulating Intellectual Information in the physical brain is absolutely not the hallmark of being a true Brahmin.
            Until that textbook knowledge flawlessly becomes the direct 'Living Experience' of life, that dry knowledge is completely and utterly garbage.
            Therefore (Tasmat), mere bookish knowledge (Intellectual data) can absolutely never make a human being a true, authentic Brahmin.
        """.trimIndent()
    ),
    VajrasuchiShloka(
        id = 6,
        sanskrit = "तर्हि कर्म ब्राह्मण इति चेत् तन्न । सर्वेषां प्राणिनां प्रारब्धसञ्चितागामिकर्मसाधर्म्यदर्शनात् ... तस्मात्कर्म न ब्राह्मणः ॥ ६ ॥",
        hindi = """
            तो फिर क्या 'कर्म' (सांसारिक या धार्मिक कार्य और मेहनत करना) ब्राह्मण है? उपनिषद कहता है: बिल्कुल नहीं (तन्न)।
            क्योंकि दुनिया के सभी प्राणियों (सर्वेषां प्राणिनां) में कर्मों का सिस्टम बिल्कुल एक जैसा (साधर्म्य) ही काम करता है।
            हर जीव अपने 'प्रारब्ध' (पिछले जन्मों के पके हुए कर्म), 'संचित' (इकट्ठे किए गए कर्म) और 'आगामी' (भविष्य के कर्म) से बुरी तरह बंधा हुआ है।
            एक छोटी सी चींटी से लेकर एक इंसान तक, हर कोई अपनी-अपनी प्रकृति के अनुसार लगातार कोई न कोई कर्म कर ही रहा है।
            कर्म मूल रूप से जड़ (Inert) होते हैं; वे केवल कार्य (Action) हैं, उनमें कोई चेतना या आध्यात्मिक बुद्धिमत्ता नहीं होती।
            अगर केवल मेहनत (कर्म) ही ब्राह्मण बनाता, तो हर मज़दूर जो दिन-रात भयंकर पसीना बहा रहा है, वह दुनिया का सबसे बड़ा ब्राह्मण होता!
            कई लोग दिखावे के लिए बहुत अच्छे और बड़े-बड़े कर्म करते हैं, पर अंदर से उनकी नीयत (Intention) बहुत गंदी और स्वार्थी होती है।
            कर्म इंसान को संसार के जन्म-मरण के चक्र में बाँधने का काम करता है, जबकि ब्राह्मणत्व संसार से पूरी आज़ादी का नाम है।
            इसलिए केवल अच्छे कर्म कर लेने मात्र से ही कोई व्यक्ति परमानेंट (Permanent) रूप से ब्राह्मण नहीं बन जाता।
            अतः (तस्मात्), यह 100% सिद्ध होता है कि भौतिक कर्मों (Physical Actions) के आधार पर किसी को ब्राह्मण बिल्कुल नहीं कहा जा सकता।
        """.trimIndent(),
        english = """
            Then is 'Karma' (performing worldly or religious actions and hard work) the Brahmin? The Upanishad firmly answers: Absolutely not (Tanna).
            Because the entire system of karmas operates in exactly the identical, uniform manner (Sadharmya) strictly across absolutely all living creatures (Sarvesham praninam) in the world.
            Every single creature is hopelessly and brutally bound by its 'Prarabdha' (ripe past karmas), 'Sanchita' (accumulated karmas), and 'Agami' (future karmas).
            From a tiny ant to a complex human, absolutely everyone is continuously performing some karma or the other strictly according to their nature.
            Karmas are fundamentally Inert (dead); they are merely physical Actions completely devoid of any pure consciousness or spiritual wisdom.
            If mere hard work (Karma) made someone a Brahmin, then every single laborer violently sweating day and night would be the world's absolute greatest Brahmin!
            Many people violently perform massive, 'good' actions purely for show-off, but deeply inside, their Intention is horrifyingly filthy and selfish.
            Karma aggressively works to bind a human to the terrifying cycle of birth and death, whereas Brahminhood is the exact name of total freedom from the world.
            Therefore, merely performing physically good actions absolutely does not permanently transform a person into a Brahmin.
            Thus (Tasmat), it is 100% flawlessly proven that absolutely no one can ever be called a Brahmin strictly based on mere physical Karmas.
        """.trimIndent()
    ),
    VajrasuchiShloka(
        id = 7,
        sanskrit = "तर्हि धार्मिको ब्राह्मण इति चेत् तन्न । क्षत्रियादयो हिरण्यदातारो बहवः सन्ति ... तस्माद्धार्मिको न ब्राह्मणः ॥ ७ ॥",
        hindi = """
            तो फिर क्या 'धार्मिक' होना (दान-पुण्य करना, बड़े-बड़े यज्ञ करना) ब्राह्मण है? उपनिषद कहता है: बिल्कुल नहीं (तन्न)।
            क्योंकि दुनिया में ऐसे बहुत से क्षत्रिय, वैश्य और अन्य जातियों के लोग हैं जो भारी मात्रा में सोना (हिरण्य) और धन दान (दातारो) करते हैं।
            कई अमीर लोग लाखों रुपये मंदिरों में दान करते हैं, आश्रम बनवाते हैं और बड़े-बड़े लंगर (भण्डारे) चलवाते हैं।
            अगर केवल दान देने और मंदिर बनवाने से कोई ब्राह्मण बन जाता, तो दुनिया के सारे अरबपति (Billionaires) ही सबसे बड़े ब्राह्मण होते!
            धार्मिक कर्मकांड (जैसे पूजा, व्रत या तीर्थयात्रा) अक्सर इंसान के अहंकार (Ego) को और ज्यादा बढ़ा देते हैं।
            दान देने वाला व्यक्ति अक्सर यह सोचकर घमंड से भर जाता है कि "मैंने इतना बड़ा दान दिया, मैं बहुत पुण्यात्मा हूँ।"
            जहाँ घमंड (Ego) आ गया, वहाँ ब्राह्मणत्व (शुद्धता) एक सेकंड भी नहीं टिक सकता; घमंड और ईश्वर कभी एक साथ नहीं रहते।
            धार्मिक होना समाज के लिए अच्छा हो सकता है, पर यह आत्मा की आज़ादी (मोक्ष) की कोई गारंटी नहीं है।
            धर्म अक्सर व्यापार (Business) बन जाता है जहाँ लोग स्वर्ग पाने के लालच में दान करते हैं (यानी पूर्ण स्वार्थ के लिए)।
            इसलिए (तस्मात्), केवल 'धार्मिक' होने या बहुत दिखावे का दान-पुण्य करने से ही कोई व्यक्ति वास्तव में ब्राह्मण नहीं बन जाता।
        """.trimIndent(),
        english = """
            Then is being 'Dharmika' (performing extreme religious duties, massive charity, and grand Yajnas) the Brahmin? The Upanishad bluntly answers: Absolutely not (Tanna).
            Because there are countless Kshatriyas, Vaishyas, and people of other castes in the world who massively donate (Dataro) enormous quantities of pure gold (Hiranya) and immense wealth.
            Many incredibly rich people aggressively donate millions to temples, build ashrams, and relentlessly run massive free-food kitchens (Bhandaras).
            If merely donating heavy cash and building physical temples made someone a Brahmin, then all the Billionaires of the world would undeniably be the greatest Brahmins!
            Strict religious rituals (like fasts, grand worship, or expensive pilgrimages) frequently inflate a human's toxic ego to terrifying levels.
            The heavy donor often becomes completely filled with blinding arrogance, foolishly thinking, "I donated so much, I am exceptionally righteous."
            Exactly where toxic Pride (Ego) enters, true Brahminhood (absolute purity) simply cannot survive for even a single second; ego and God absolutely never coexist.
            Being strictly religious might be highly beneficial for society, but it is absolutely no guarantee for the Liberation (Moksha) of the Soul.
            Religion frequently degrades into a cheap Business where people actively donate strictly out of intense greed to purchase a ticket to heaven (pure Selfishness).
            Therefore (Tasmat), merely being highly 'Dharmika' or aggressively giving massive, show-off charity absolutely never makes a person an authentic Brahmin.
        """.trimIndent()
    ),
    VajrasuchiShloka(
        id = 8,
        sanskrit = "तर्हि को वा ब्राह्मणो नाम । यः कश्चिदात्मानमद्वितीयं रूपरसगन्धहीनं निर्विकल्पमशेषदोषातीतं ... स एव ब्राह्मण इति श्रुतिस्मृतीतिहासपुराणानामभिप्रायः ॥ ८ ॥",
        hindi = """
            (सबसे बड़ा निष्कर्ष): तो फिर वास्तव में 'ब्राह्मण' नाम किसका है (को वा ब्राह्मणो नाम)?
            जो व्यक्ति अपनी 'आत्मा' को पूर्ण अद्वैत (अद्वितीय / जिसके जैसा दूसरा कोई नहीं) रूप में साक्षात् अनुभव कर लेता है।
            जो जान लेता है कि यह आत्मा रूप, रस, और गंध से पूरी तरह हीन (रहित) है, और सभी प्रकार के दोषों (पापों) से परे (अशेषदोषातीतं) है।
            जिसके हृदय से काम (वासना), क्रोध, अहंकार, इच्छा, और मोह पूरी तरह से नष्ट हो चुके हैं।
            जो दिखावे (पाखंड), ईर्ष्या (Jealousy) और लालच से पूरी तरह मुक्त होकर एक अत्यंत शांत और निर्मल जीवन जीता है।
            जिसे यह पक्का अहसास हो चुका है कि उसके भीतर बैठा परमात्मा और संपूर्ण ब्रह्मांड बिल्कुल एक ही है।
            और जो बिना किसी स्वार्थ के, बिना किसी डर के, साक्षात् उस ब्रह्म के असीम आनंद में हर पल डूबा रहता है।
            वास्तव में 'वही एक व्यक्ति सच्चा ब्राह्मण है' (स एव ब्राह्मण)—यही संपूर्ण श्रुतियों (वेदों), स्मृतियों, इतिहास और पुराणों का एकमात्र असली 'अभिप्राय' (निर्णय) है।
            ब्राह्मण कोई जन्म से मिली हुई जाति (Caste) बिल्कुल नहीं है, बल्कि यह इंसान के 'चरित्र' (Character) और 'आत्मज्ञान' का सबसे ऊँचा शिखर है।
            जिसने 'ब्रह्म' (परमात्मा) को साक्षात् जान लिया, केवल और केवल वही व्यक्ति 'ब्राह्मण' कहलाने का 100% सच्चा अधिकारी है।
        """.trimIndent(),
        english = """
            (The absolute grand conclusion): Then who on earth is genuinely and authentically called a 'Brahmin' (Ko va brahmano nama)?
            That highly specific person who directly and flawlessly experiences his own 'Soul' as entirely Non-dual (Advitiyam / having no second or equal).
            Who perfectly realizes that this Soul is completely devoid (Hinam) of physical form, taste, and smell, and is absolutely beyond all flaws and sins (Asheshadoshatitam).
            From whose heart the toxic poisons of lust (Kama), violent anger, blinding ego, deep desires, and brutal delusion have been entirely annihilated.
            Who lives a supremely tranquil and immaculate life, flawlessly free from all cheap hypocrisy (Show-off), intense Jealousy, and deep greed.
            Who has gained the absolute, rock-solid realization that the Supreme Lord sitting right inside him and the entire massive cosmos are identically One.
            And who remains perpetually, non-stop drowned exactly in the infinite bliss of that Brahman, completely without any selfishness or terrifying fear.
            In absolute reality, 'He alone is the true Brahmin' (Sa eva brahmana)—This, and strictly this, is the sole, ultimate 'Opinion' (Conclusion) of absolutely all Shrutis, Smritis, Itihasas, and Puranas.
            A Brahmin is absolutely not a cheap physical Caste obtained freely by birth, but the absolute highest peak of human 'Character' and 'Self-knowledge'.
            He who has flawlessly realized 'Brahman' (The Supreme Lord), only, and strictly only that specific person is the true, legitimate candidate to be called a 'Brahmin'.
        """.trimIndent()
    ),
    VajrasuchiShloka(
        id = 9,
        sanskrit = "अन्यथा हि ब्राह्मणत्वसिद्धिर्नास्त्येव । सच्चिदानन्दमात्मानमद्वितीयं ब्रह्म भावयेदित्युपनिषत् ॥ ९ ॥",
        hindi = """
            (उपनिषद का समापन): इस आत्मज्ञान और ब्रह्म-साक्षात्कार के बिना, किसी भी अन्य तरीके (अन्यथा) से ब्राह्मणत्व की सिद्धि (सच्चा ब्राह्मण बनना) बिल्कुल असंभव है (नास्त्येव)।
            चाहे आप कितने भी वेद रट लें, कितने भी बड़े यज्ञ कर लें, या किसी ब्राह्मण के घर में जन्म ले लें; आत्मज्ञान के बिना आप ब्राह्मण बिल्कुल नहीं हैं।
            इसलिए, मोक्ष की इच्छा रखने वाले साधक को चाहिए कि वह अपने भीतर उसी 'सत्-चित्-आनंद' (सच्चिदानन्दं) स्वरूप आत्मा का निरंतर चिंतन (भावयेत्) करे।
            उसे यह महसूस करना चाहिए कि वह स्वयं ही वह अद्वितीय (अद्वितीयं) और अनंत परब्रह्म है।
            वज्रसूची उपनिषद यहाँ समाज के सबसे बड़े पाखंड (जातिवाद) को एक ही झटके में हमेशा के लिए खत्म कर देता है।
            यह डंके की चोट पर घोषित करता है कि 'ब्राह्मण' कोई पेटेंट (Patent) या पैदाइशी हक़ नहीं है; यह एक अत्यंत ऊँची 'चेतना' (Consciousness) का नाम है।
            एक अछूत (शूद्र) भी अगर आत्मज्ञान प्राप्त कर ले, तो वह साक्षात् 'ब्राह्मण' है; और एक ब्राह्मण के घर पैदा हुआ लालची इंसान शूद्र से भी नीचा है।
            जो इंसान अपने कर्मों और विचारों को शुद्ध करके भगवान में लीन हो जाता है, वही इस ब्रह्मांड का सबसे बड़ा और सच्चा ब्राह्मण है।
            'इत्युपनिषत्' (यहाँ उपनिषद समाप्त होता है)—यह परम ज्ञान इंसान को शारीरिक भेदभाव की गटर (Gutter) से निकालकर आत्मा के असीम आकाश में ले जाता है।
            ॐ शांतिः शांतिः शांतिः—यह परम सत्य हमारे समाज और हमारे मन में पूर्ण शांति, समानता और एकता स्थापित करे।
        """.trimIndent(),
        english = """
            (Conclusion of the Upanishad): Completely without this supreme Self-knowledge and direct realization of Brahman, successfully attaining true Brahminhood through any other alternative method (Anyatha) is absolutely, 100% impossible (Nastyeva).
            No matter how many millions of Vedas you blindly memorize, how many grand Yajnas you perform, or if you are born directly in a Brahmin's house; completely without wisdom, you are absolutely no Brahmin.
            Therefore, the sincere seeker must relentlessly and profoundly meditate (Bhavayet) upon that exact Soul which is the direct embodiment of 'Sat-Chit-Ananda' (Absolute Truth, Consciousness, and Bliss).
            He must deeply and flawlessly realize that he himself is undeniably that Non-dual (Advitiyam) and infinite Supreme Brahman.
            The Vajrasuchi Upanishad violently and flawlessly annihilates the society's absolute greatest hypocrisy (Casteism) in a single, devastating stroke forever right here.
            It fiercely declares with absolute authority that 'Brahmin' is absolutely not a cheap Patent or an entitled birthright; it is strictly the majestic name of an exceptionally high 'Consciousness'.
            Even if an untouchable (Shudra) successfully attains Self-knowledge, he is literally a 'Brahmin'; whereas a greedy man born in a Brahmin's house is pathetically lower than a Shudra.
            The human being who perfectly purifies his karmas and thoughts and flawlessly dissolves into God is undeniably the absolute greatest and truest Brahmin in this cosmos.
            'Ityupanishat' (Here the Upanishad ends)—this spectacular wisdom violently pulls a human out of the filthy gutter of physical discrimination and throws him directly into the infinite sky of the Soul.
            OM Peace, Peace, Peace—May this supreme, ultimate Truth firmly establish absolute peace, total equality, and flawless unity strictly within our society and our restless minds.
        """.trimIndent()
    )
)