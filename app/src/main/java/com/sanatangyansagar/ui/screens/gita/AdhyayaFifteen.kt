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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AdhyayaFifteen() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaFifteenShlokas.indexOfFirst { it.id == shlokaNum }
            if (targetIndex != -1) {
                coroutineScope.launch {
                    listState.animateScrollToItem(targetIndex)
                }
                keyboardController?.hide()
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Shloka Number (1 - 20)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { performSearch() }),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { performSearch() }) {
                    Icon(Icons.Default.Search, contentDescription = "Jump to Shloka")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            itemsIndexed(adhyayaFifteenShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaFifteenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            श्रीभगवानुवाच |
            ऊर्ध्वमूलमधःशाखमश्वत्थं प्राहुरव्ययम् |
            छन्दांसि यस्य पर्णानि यस्तं वेद स वेदवित् || १ ||
        """.trimIndent(),
        hindi = """
            भगवान श्रीकृष्ण इस भौतिक संसार की तुलना एक उल्टे पीपल के पेड़ यानी अश्वत्थ से करते हैं जो अत्यंत रहस्यमयी है।
            इस भयानक और अविनाशी माने जाने वाले पेड़ की जड़ें ऊपर की ओर और शाखाएं नीचे संसार की ओर फैली हुई हैं।
            इस मायावी पेड़ के पत्ते वेदों के वे सकाम मंत्र हैं जो इंसान को स्वर्ग के सुखों और कर्मकांडों का लालच देते हैं।
            जो मनुष्य इस उल्टे पेड़ के असली रहस्य को पूरी तरह से जान लेता है, वास्तव में वही वेदों का सच्चा ज्ञाता माना जाता है।
            यह उल्टा पेड़ इस बात का प्रतीक है कि यह भौतिक दुनिया असली आध्यात्मिक दुनिया का केवल एक उल्टा और विकृत प्रतिबिंब है।
            जैसे पानी के किनारे खड़े असली पेड़ का रूप ऊपर होता है और पानी में उसकी परछाई हमेशा उल्टी ही दिखाई देती है।
            उसी प्रकार इस भौतिक जगत में जो कुछ भी है, वह आध्यात्मिक जगत की केवल एक झूठी, डार्क और उल्टी नकल मात्र है।
            यह पेड़ हमारी सांसारिक इच्छाओं और सकाम कर्मों के कारण लगातार बढ़ता रहता है और कभी खत्म नहीं होता।
            हमें इस भ्रम के पेड़ से अपना मोह तोड़कर इसकी असली जड़ों यानी परमात्मा की ओर वापस लौटने का प्रयास करना होगा।
            संसार के इस मायावी पेड़ के ढांचे को समझना ही आत्मज्ञान और मोक्ष की सबसे पहली और अनिवार्य सीढ़ी है।
        """.trimIndent(),
        english = """
            Lord Sri Krishna profoundly compares the entire material manifestation to a highly mysterious, inverted banyan tree called Ashvattha.
            The roots of this seemingly imperishable cosmic tree grow upward, while its massive branches extend downward into the material matrix.
            The leaves of this tree represent the Vedic hymns that aggressively encourage fruitive activities and temporary heavenly elevation.
            One who flawlessly understands the complex, illusionary nature of this inverted tree is officially the true knower of the Vedas.
            This inverted structure mathematically symbolizes that the physical world is merely a distorted, upside-down reflection of reality.
            Just as a real tree standing by a river heavily reflects its exact inverted shadow upon the surface of the water below.
            Similarly, this entire material matrix is nothing but a dark, perverted, temporary reflection of the absolute spiritual dimension.
            This illusionary tree continues to violently flourish and expand, nourished strictly by our endless, toxic material desires and karma.
            We must aggressively trace this reflection back to its original, absolute roots which are situated eternally in the Supreme Lord.
            Decoding the complex architecture of this cosmic tree is the mandatory first step toward executing an ultimate spiritual escape.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            अधश्चोर्ध्वं प्रसृतास्तस्य शाखा गुणप्रवृद्धा विषयप्रवालाः |
            अधश्च मूलान्यनुसन्ततानि कर्मानुबन्धीनि मनुष्यलोके || २ ||
        """.trimIndent(),
        hindi = """
            इस विशाल सांसारिक पेड़ की शाखाएं ऊपर देवताओं के लोकों और नीचे पशुओं की योनियों में सभी दिशाओं में तेजी से फैली हुई हैं।
            प्रकृति के तीनों गुण यानी सत्त्व, रजस और तमस इस पेड़ की डालियों को पोषण देने वाले पानी की तरह लगातार काम करते हैं।
            इन्द्रियों के विषय जैसे रूप, रस और गंध इस असीम पेड़ की छोटी-छोटी और आकर्षक कोपलों के समान हैं जो हमें लुभाती हैं।
            इस पेड़ की कुछ मुख्य जड़ें नीचे मनुष्य लोक की ओर भी गहराई तक जा रही हैं जो इंसानों को फँसा कर रखती हैं।
            ये नीची जड़ें उन सकाम कर्मों और वासनाओं की प्रतीक हैं जो इंसान को समाज और भौतिक दुनिया में बुरी तरह बांधकर रखती हैं।
            प्रकृति के गुणों के कारण इंसान अपनी इच्छाओं में अंधा होकर स्वर्ग और नर्क की योनियों में बार-बार ऊपर-नीचे भटकता रहता है।
            जब हम इन्द्रियों के सुखों में लिप्त होते हैं, तो हम अनजाने में इस माया के पेड़ को और अधिक हरा-भरा कर रहे होते हैं।
            दुनिया के झूठे आकर्षण हमें इस पेड़ की अलग-अलग टहनियों पर एक बेचैन पक्षी की तरह भटकाते और थकाते रहते हैं।
            हमारे अच्छे और बुरे कर्म ही वे लोहे की जंजीरें हैं जो हमें इस पेड़ के निचले हिस्से से हमेशा के लिए चिपका देती हैं।
            ईश्वर अर्जुन को यह डरावना दृश्य इसलिए दिखा रहे हैं ताकि वह इस मोह-माया के जाल की भयानकता को अच्छी तरह समझ सके।
        """.trimIndent(),
        english = """
            The massive branches of this cosmic tree extend relentlessly in all directions, growing downward and upward into various planetary systems.
            The three modes of material nature act exactly like the nourishing water that fuels the violent growth of these branches.
            The highly attractive objects of the senses represent the tiny, seductive twigs growing eagerly on the tree's expanding extremities.
            Furthermore, this tree possesses secondary, powerful roots spreading deeply downwards directly into the human planetary systems.
            These downward roots physically symbolize the fruitive actions and toxic desires that heavily bind humans to worldly society.
            Driven blindly by the material modes, the soul wanders endlessly up and down the branches across heavenly and hellish realms.
            Whenever we eagerly indulge in sensory gratification, we actively water and strengthen this terrifying, illusionary cosmic tree.
            The hypnotic allure of the matrix forces the soul to hop blindly from one branch of desire to another like a restless bird.
            Our accumulated pious and sinful karmas act as the rigid biological roots chaining us permanently to this earthly dimension.
            The Lord graphically describes this complex architecture so Arjuna can visually comprehend the terrifying entanglement of the matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            न रूपमस्येह तथोपलभ्यते नान्तो न चादिर्न च सम्प्रतिष्ठा |
            अश्वत्थमेनं सुविरूढमूलमसङ्गशस्त्रेण दृढेन छित्त्वा || ३ ||
        """.trimIndent(),
        hindi = """
            इस भौतिक संसार में रहते हुए इस असीम और भ्रमित करने वाले पेड़ के असली रूप को कभी भी पूरी तरह से नहीं समझा जा सकता।
            न तो इसकी शुरुआत का कुछ पता चलता है, न ही इसके अंत का, और न ही इसके मूल आधार का कोई ज्ञान इंसान को होता है।
            यह पेड़ इतना विशाल और पुराना है कि इंसान अपनी छोटी सी बुद्धि से इसका पूरा नक्शा कभी भी नहीं बना सकता।
            लेकिन इस अत्यंत मजबूत जड़ों वाले 'अश्वत्थ' यानी माया के पेड़ को काटना हमारी मुक्ति के लिए सबसे अधिक ज़रूरी काम है।
            इस भयंकर पेड़ को काटने का एकमात्र और अचूक हथियार केवल 'वैराग्य' है यानी संसार से पूरी तरह से अनासक्त हो जाना।
            जब तक इंसान दुनिया के सुखों से चिपका रहेगा, वह इस पेड़ की भूलभुलैया में बुरी तरह फँसा ही रहेगा और रोता रहेगा।
            हमें वैराग्य की इस कुल्हाड़ी को आध्यात्मिक ज्ञान के पत्थर पर रगड़कर अत्यंत तेज़ और धारदार बनाना होगा।
            बिना निर्मम वैराग्य के कोई भी मनुष्य अपने जन्मों-जन्मों के कर्मों की इन गहरी जड़ों को कभी भी उखाड़ नहीं सकता है।
            संसार को भोगने की वासना ही इस पेड़ को ज़िंदा रखती है, जबकि विरक्ति इसे तुरंत सुखाकर राख कर देती है।
            अपने अहंकार और मोह को कुचलकर ही हम इस मायावी जंगल से बाहर निकलने का सही रास्ता हमेशा के लिए खोज सकते हैं।
        """.trimIndent(),
        english = """
            The actual form, geometry, and magnitude of this cosmic tree cannot possibly be perceived while dwelling within this material world.
            No biological human can mathematically determine its precise beginning, its absolute end, or its ultimate foundational basis.
            This illusionary tree is so unfathomably ancient and massive that it completely defies all human scientific mapping and logic.
            However, it is absolutely critical for spiritual survival that this strongly rooted banyan tree of illusion be violently cut down.
            The absolute only weapon capable of severing this massive tree is the sharp, heavy axe of uncompromising detachment and renunciation.
            As long as a human clings to worldly pleasures, he remains hopelessly imprisoned within the terrifying labyrinth of its branches.
            We must aggressively sharpen the psychological weapon of detachment on the solid whetstone of supreme transcendental knowledge.
            Without absolute, cold-blooded renunciation, absolutely no mortal can ever uproot the deeply entrenched roots of their fruitive karma.
            The toxic desire to enjoy the matrix keeps this tree alive, whereas pure detachment instantaneously starves it to death.
            By violently crushing our false ego and worldly lust, we finally secure the permanent escape route out of this cosmic jungle.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            ततः पदं तत्परिमार्गितव्यं यस्मिन्गता न निवर्तन्ति भूयः |
            तमेव चाद्यं पुरुषं प्रपद्ये यतः प्रवृत्तिः प्रसृता पुराणी || ४ ||
        """.trimIndent(),
        hindi = """
            वैराग्य के तेज हथियार से इस पेड़ को काटने के बाद मनुष्य को उस परम आध्यात्मिक स्थान की ही खोज करनी चाहिए।
            उस दिव्य स्थान यानी ईश्वर के धाम में एक बार प्रवेश करने के बाद कोई भी जीव वापस इस जन्म-मरण के संसार में नहीं लौटता है।
            साधक को उस आदि पुरुष यानी परमात्मा की ही पूर्ण रूप से शरण लेनी चाहिए जिससे यह सारी सृष्टि उत्पन्न हुई है।
            यह वही परमेश्वर है जिससे इस संपूर्ण ब्रह्मांड का अनादि विस्तार शुरू हुआ है और आज तक संचालित हो रहा है।
            संसार से डिटैचमेंट के बाद मन को खाली नहीं रखना है, बल्कि उसे तुरंत ईश्वर की भक्ति और प्रेम से जोड़ लेना है।
            जब तक हम सही लक्ष्य यानी ईश्वर को नहीं चुनते, तब तक माया का यह पेड़ हमारे मन में दोबारा उग सकता है।
            आध्यात्मिक यात्रा का पहला कदम है संसार को छोड़ना, और दूसरा सबसे बड़ा कदम है परमात्मा को कसकर पकड़ लेना।
            हमें यह अटल संकल्प लेना होगा कि मैं केवल उसी परम शक्ति का अंश हूँ जिसने यह सारा कॉस्मिक खेल रचा है।
            उस सनातन सत्ता की खोज ही मानव जीवन का एकमात्र उद्देश्य और हमारी सभी शारीरिक व मानसिक समस्याओं का अचूक समाधान है।
            परमात्मा की 100% शरण में जाने वाला व्यक्ति इस 3D मैट्रिक्स को हैक करके शाश्वत सत्य के आयाम में हमेशा के लिए प्रवेश कर जाता है।
        """.trimIndent(),
        english = """
            After violently striking down this illusionary tree with detachment, one must relentlessly seek that supreme spiritual destination.
            Once a soul successfully enters that ultimate dimension, it absolutely never returns to this matrix of repeated birth and death.
            The seeker must completely and unconditionally surrender to the original Supreme Personality of Godhead with full faith.
            It is from this exact primeval Lord that the entire infinite expansion of the multiverse originally began and currently operates.
            Following material detachment, the mind must not remain empty; it must immediately be locked onto the Supreme Creator.
            If we fail to actively secure the ultimate target, the toxic tree of illusion will mathematically regenerate and trap us again.
            The first step of spiritual evolution is rejecting the material simulation; the second is desperately grabbing hold of the Divine.
            We must enforce a titanium resolution recognizing that we are eternal fragments of the Master Architect of this cosmos.
            Searching for that primeval truth is the absolute sole purpose of life and the ultimate cure for all biological existence.
            The soul who perfectly surrenders to God successfully hacks the 3D matrix and steps directly into the dimension of eternal reality.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            निर्मानमोहा जितसङ्गदोषा अध्यात्मनित्या विनिवृत्तकामाः |
            द्वन्द्वैर्विमुक्ताः सुखदुःखसञ्ज्ञैर्गच्छन्त्यमूढाः पदमव्ययं तत् || ५ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य झूठे मान-सम्मान के अहंकार और सांसारिक मोह से पूरी तरह मुक्त हो चुके हैं, वे ही इस परम पद को प्राप्त करते हैं।
            जिन्होंने सांसारिक संगति के भयंकर दोष को जीत लिया है और जो हमेशा अध्यात्म के गहरे ज्ञान में ही स्थित रहते हैं।
            जिनकी सभी प्रकार की भौतिक कामनाएं यानी इच्छाएं और वासनाएं जड़ से पूरी तरह नष्ट और भस्म हो चुकी हैं।
            जो सुख और दुःख के द्वंद्वों यानी मानसिक उलझनों से पूरी तरह आज़ाद हैं और किसी भी स्थिति में कभी विचलित नहीं होते।
            ऐसे मोह-रहित और अत्यंत बुद्धिमान मनुष्य ही उस शाश्वत और कभी न मिटने वाले ईश्वरीय पद को प्राप्त करते हैं।
            यह श्लोक भगवान के धाम में प्रवेश करने के लिए आवश्यक वीआईपी क्वालिफिकेशन्स या योग्यताओं को बिल्कुल स्पष्ट करता है।
            ईश्वर के घर में अहंकार, दिखावा और मोह के लिए कोई जगह नहीं है; वहाँ केवल शुद्धि और प्रेम का ही प्रवेश होता है।
            जब इंसान दुनिया की झूठी तालियों और गालियों से पूरी तरह परे हो जाता है, तभी वह असली स्वतंत्रता का स्वाद चखता है।
            सुख-दुःख के समय एक अजेय चट्टान की तरह शांत रहना ही इस दुनिया का सबसे बड़ा और सबसे शक्तिशाली मनोवैज्ञानिक चमत्कार है।
            इन्हीं कठिन पैमानों पर खरा उतरने वाला ज्ञानी ही माया को हराकर हमेशा के लिए ईश्वर का परम और प्यारा साथी बन जाता है।
        """.trimIndent(),
        english = """
            Those who are entirely free from toxic false prestige, massive illusion, and false association flawlessly attain the eternal kingdom.
            They have aggressively conquered the severe disease of material attachment and dwell constantly in absolute spiritual knowledge.
            Their minds are completely purged, and all their toxic biological lusts and material desires have been permanently eradicated.
            They are entirely liberated from the schizophrenic dualities of happiness and distress, remaining permanently unbothered.
            Such unbewildered, elite, and highly intelligent persons successfully achieve the eternal, indestructible supreme destination.
            This spectacular verse outlines the exact VIP cosmic qualifications required to legally access the eternal Kingdom of God.
            There is absolutely zero bandwidth for arrogance, fake personas, or worldly attachments in the spiritual sky; only pure consciousness enters.
            A human tastes true cosmic freedom only when he becomes totally immune to the fake applause and toxic insults of society.
            Remaining as stable as a titanium mountain during extreme joy and brutal tragedy is the highest psychological superpower.
            Only the master who perfectly passes these brutal filters defeats the matrix and becomes God's eternal and intimate companion.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            न तद्भासयते सूर्यो न शशाङ्को न पावकः |
            यद्गत्वा न निवर्तन्ते तद्धाम परमं मम || ६ ||
        """.trimIndent(),
        hindi = """
            मेरे उस परम धाम को न तो सूर्य प्रकाशित कर सकता है और न ही चंद्रमा या अग्नि में उसे रोशन करने की कोई शक्ति है।
            वह आध्यात्मिक आकाश स्वयं ही अपने दिव्य और असीम प्रकाश से हर समय पूर्ण रूप से प्रकाशित और चमकता रहता है।
            इस भौतिक दुनिया में हमें रोशनी के लिए किसी न किसी स्रोत जैसे सूरज या बिजली पर निर्भर रहना पड़ता है जो कि अस्थाई है।
            लेकिन भगवान का वह वैकुंठ धाम भौतिक नियमों और प्राकृतिक ऊर्जा के सभी स्रोतों से पूरी तरह स्वतंत्र और परे स्थित है।
            जो भाग्यशाली मनुष्य एक बार उस दिव्य और परम स्थान पर पहुँच जाता है, वह लौटकर कभी इस मृत्युलोक में नहीं आता।
            यही सनातन सत्य है कि आत्मा का असली घर वह दिव्य प्रकाश है जहाँ अंधेरे या अज्ञान की कोई गुंजाइश ही नहीं है।
            भौतिक ब्रह्मांड की सबसे बड़ी और चमकदार चीज़ें भी उस ईश्वरीय तेज के सामने महज़ एक छोटे से जुगनू के समान हैं।
            ईश्वर का वह घर आनंद, ज्ञान और शाश्वतता का वह पूर्ण भंडार है जिसकी इंसान जीवन भर केवल कल्पना करता है।
            उस धाम की प्राप्ति ही सभी प्रकार के तप, योग और भक्ति का सबसे अंतिम और सबसे महान पुरस्कार मानी गई है।
            जो इस सत्य को समझ लेता है, वह दुनिया के इन बनावटी और मिटने वाले प्रकाशों के पीछे भागना तुरंत छोड़ देता है।
        """.trimIndent(),
        english = """
            That supreme abode of Mine is absolutely not illuminated by the sun or the moon, nor by fire or any electrical energy.
            The spiritual sky is completely self-luminous, radiating an eternal and blinding transcendental effulgence of its own.
            In this material universe, we are pathetically dependent on temporary cosmic generators like stars to provide basic light.
            However, the Lord's eternal kingdom exists infinitely beyond the physical laws of thermodynamics and material power sources.
            Any fortunate soul who successfully reaches that supreme destination is absolutely never forced to return to this matrix of death.
            This is the ultimate truth: the soul's original home is a dimension of pure light completely devoid of any darkness or ignorance.
            Even the most massive, blazing supernovas in this physical cosmos are exactly like tiny fireflies compared to God's brilliant aura.
            That supreme headquarters is the ultimate reservoir of absolute bliss, eternity, and knowledge that humanity desperately seeks.
            Gaining entry into that divine realm is the absolute highest reward for executing severe austerities, yoga, and pure devotion.
            One who comprehends this reality immediately stops chasing the cheap, temporary, and flickering lights of this material simulation.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            ममैवांशो जीवलोके जीवभूतः सनातनः |
            मनःषष्ठानीन्द्रियाणि प्रकृतिस्थानि कर्षति || ७ ||
        """.trimIndent(),
        hindi = """
            इस बद्ध संसार में रहने वाले सभी जीव वास्तव में मेरे ही सनातन और अविनाशी अंश (हिस्से) हैं।
            परंतु भौतिक प्रकृति के प्रभाव में आकर ये जीव मन सहित छह इन्द्रियों के साथ बहुत भयंकर संघर्ष कर रहे हैं।
            आत्मा स्वभाव से पूर्णतयः शुद्ध और ईश्वरीय है, लेकिन शरीर में आते ही वह अपनी असली पहचान को भूल जाती है।
            मन और पाँचों इन्द्रियां (आँख, कान आदि) जीव को भौतिक सुखों की ओर खींचती हैं और उसे संसार में उलझाए रखती हैं।
            हमारा यह जीवन वास्तव में अपनी ही इन्द्रियों और बेकाबू मन के खिलाफ चल रही एक बहुत ही लंबी और थकाऊ लड़ाई है।
            भगवान कहते हैं कि तुम कोई साधारण प्राणी नहीं हो, तुम साक्षात् मेरी ऊर्जा हो और तुम्हारे भीतर असीम शक्ति है।
            लेकिन अपनी इस ईश्वरीय पहचान को भूलकर इंसान प्रकृति की बनाई हुई इस मशीन यानी शरीर का गुलाम बन चुका है।
            यही कारण है कि इंसान हर समय तनाव, डिप्रेशन और इन्द्रियों की कभी न बुझने वाली प्यास से जूझता रहता है।
            जब आत्मा इस बात को समझ लेती है कि वह परमात्मा का अंश है, तो वह इन्द्रियों की इस गुलामी को तुरंत खारिज कर देती है।
            यह श्लोक इंसान को उसकी असली 'सुपर-ह्यूमन' (Super-human) औकात याद दिलाता है जो शरीर की सीमाओं से बहुत बड़ी है।
        """.trimIndent(),
        english = """
            The living entities situated in this conditioned material world are eternally My own fragmental and indestructible parts.
            However, due to conditioned life, they are violently struggling hard with the six senses, which include the turbulent mind.
            The soul is fundamentally pure and divine by nature, but upon entering the biological vessel, it completely forgets its true identity.
            The mind and the five physical senses aggressively drag the soul toward material pleasures, keeping it hopelessly entangled.
            Our human existence is actually an exhausting, relentless biological war fought daily against our own uncontrolled senses.
            The Lord declares: You are absolutely not an ordinary mortal; you are literal divine energy possessing infinite cosmic power.
            But tragically forgetting this divine heritage, the human has become a pathetic slave to the biological machine of the body.
            This is the exact reason why humans perpetually suffer from severe depression, stress, and the unquenchable thirst of the senses.
            When the soul finally realizes it is a direct fragment of God, it instantly rejects and rebels against this sensory slavery.
            This spectacular verse reminds a human being of his actual 'Super-human' status that exists far beyond biological limitations.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            शरीरं यदवाप्नोति यच्चाप्युत्क्रामतीश्वरः |
            गृहीत्वैतानि संयाति वायुर्गन्धानिवाशयात् || ८ ||
        """.trimIndent(),
        hindi = """
            इस भौतिक शरीर का स्वामी (जीवात्मा) जब एक शरीर को छोड़ता है और फिर दूसरे नए शरीर को धारण करता है।
            तो वह अपने साथ मन और इन्द्रियों की सूक्ष्म धारणाओं को बिल्कुल वैसे ही ले जाता है जैसे हवा फूलों से सुगंध को ले जाती है।
            यह श्लोक 'पुनर्जन्म और कर्मों के ट्रांसफर' (Transmigration of Soul) का सबसे स्पष्ट और खूबसूरत वैज्ञानिक उदाहरण है।
            जब इंसान मरता है, तो उसका भौतिक शरीर यहीं राख बन जाता है, लेकिन उसका 'सॉफ्टवेयर' (मन, आदतें और वासनाएं) नष्ट नहीं होता।
            आत्मा उस पूरे जीवन के डेटा और इच्छाओं को अपने सूक्ष्म शरीर में सेव (Save) करके अगले जन्म के लिए साथ ले जाती है।
            जैसे हवा दिखाई नहीं देती लेकिन वह फूलों की महक को एक जगह से दूसरी जगह ले जाती है, वैसे ही आत्मा कर्मों की महक साथ ले जाती है।
            यही कारण है कि कोई बच्चा जन्म से ही बहुत शांत होता है और कोई बहुत गुस्सैल, क्योंकि वे अपनी पिछली आदतें साथ लाते हैं।
            इंसान इस जन्म में जो भी सोचता है और करता है, वह सब एक अदृश्य चिप (Chip) में रिकॉर्ड हो रहा है जो उसके अगले शरीर का निर्माण करेगा।
            इसलिए मृत्यु से डरने के बजाय इंसान को अपने विचारों की सुगंध को पवित्र करने पर सबसे ज्यादा ध्यान देना चाहिए।
            हमारा आज का माइंडसेट ही हमारे कल के बायोलॉजिकल शरीर और हमारी नियति (Destiny) का इकलौता और असली आर्किटेक्ट है।
        """.trimIndent(),
        english = """
            When the living entity, the master of the body, eventually quits his physical vessel to acquire a completely new one.
            He carries his various conceptions of life with him exactly as the invisible wind forcefully carries aromas from the flowers.
            This spectacular verse provides the absolute clearest and most beautiful scientific analogy for the Transmigration of the Soul.
            When a human physically dies, his biological hardware turns to ash, but his psychological 'Software' (habits and lust) is never deleted.
            The soul securely 'Saves' the entire accumulated data and desires of that lifetime and transports them directly into the next birth.
            Just as the wind is invisible but seamlessly carries the scent of flowers across distances, the soul carries the aroma of its karma.
            This mathematically explains why some children are born natural geniuses or inherently angry; they are running their previous life's software.
            Everything a human thinks and executes in this life is actively being recorded on an invisible chip that engineers his next body.
            Therefore, instead of being paralyzed by the fear of death, a human must urgently focus on purifying the 'Aroma' of his daily thoughts.
            Our current mindset and desires are the absolute sole architects officially designing our future biological bodies and cosmic destiny.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            श्रोत्रं चक्षुः स्पर्शनं च रसनं घ्राणमेव च |
            अधिष्ठाय मनश्चायं विषयानुपसेवते || ९ ||
        """.trimIndent(),
        hindi = """
            यह जीवात्मा नया शरीर धारण करके फिर से कान, आँख, त्वचा, जीभ, नाक और मन का पूरी तरह से आश्रय ले लेती है।
            और इन सभी इन्द्रियों के माध्यम से वह संसार के विभिन्न भौतिक विषयों (रूप, रस, गंध आदि) का उपभोग करने लगती है।
            पिछले श्लोक में आत्मा नया शरीर ले रही थी, और इस श्लोक में वह नए शरीर की मशीनरी को 'स्टार्ट' (Start) कर रही है।
            जैसे ही आत्मा नए जन्म में आती है, वह अपनी पुरानी इच्छाओं को पूरा करने के लिए तुरंत 5 नए सेंसर्स (Sensors) एक्टिवेट कर देती है।
            आत्मा मन नाम के सीपीयू (CPU) के ज़रिए आँखों से देखती है, कानों से सुनती है और जीभ से स्वाद का लालच पूरा करती है।
            लेकिन अज्ञानता के कारण वह भूल जाती है कि वह इन इन्द्रियों से अलग एक अत्यंत पवित्र और ईश्वरीय सत्ता है।
            वह इन बायोलॉजिकल उपकरणों को ही अपनी पहचान मान लेती है और सांसारिक सुखों को भोगने की अंतहीन दौड़ में शामिल हो जाती है।
            मनुष्य का पूरा जीवन केवल इन्हीं पाँच दरवाज़ों के ज़रिए बाहरी दुनिया का डेटा (Data) इकट्ठा करने और उसे भोगने में बीत जाता है।
            यह एक भयंकर लूप (Loop) है जहाँ इच्छाएं हमें नए शरीर देती हैं और शरीर हमें नई इच्छाएं पूरी करने के लिए मजबूर करता है।
            जब तक आत्मा अपने मन को इस बाहरी दुनिया से खींचकर अंदर भगवान की ओर नहीं लगाती, वह इस मैट्रिक्स में फँसी ही रहती है।
        """.trimIndent(),
        english = """
            The living entity, upon acquiring a new biological body, once again takes firm shelter of the ears, eyes, touch, tongue, nose, and mind.
            And strictly utilizing all these grouped physical senses, the soul begins to aggressively enjoy the various objects of material gratification.
            In the previous verse, the soul acquired a new body; here, it officially boots up and 'Starts' the biological machinery.
            The exact microsecond the soul respawns, it instantly activates 5 new biological 'Sensors' to desperately satisfy its carried-over lust.
            Operating through the 'CPU' of the mind, the soul fiercely looks through the eyes, listens through the ears, and indulges the tongue.
            However, due to heavy cosmic ignorance, the soul tragically forgets that it is a pure, divine entity completely separate from these senses.
            It pathetically accepts these biological instruments as its true identity and joins the endless, exhausting rat race for sensory pleasure.
            A human's entire lifespan is brutally wasted merely collecting data through these five sensory doors and desperately trying to enjoy it.
            This forms a terrifying, inescapable Loop where desires manufacture new bodies, and the bodies forcefully manufacture new desires.
            Until the soul violently unplugs its mind from this external data and connects to God, it remains hopelessly trapped in the matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            उत्क्रामन्तं स्थितं वापि भुञ्जानं वा गुणान्वितम् |
            विमूढा नानुपश्यन्ति पश्यन्ति ज्ञानचक्षुषः || १० ||
        """.trimIndent(),
        hindi = """
            मूर्ख लोग (विमूढा) यह कभी नहीं देख पाते कि आत्मा कैसे शरीर को छोड़ती है, कैसे शरीर में रहती है, और गुणों के अधीन होकर कैसे विषयों को भोगती है।
            परंतु जिनके पास 'ज्ञान की आँखें' (ज्ञानचक्षुषः) हैं, वे ज्ञानी मनुष्य इस पूरी प्रक्रिया को बिल्कुल स्पष्ट रूप से देख लेते हैं।
            भगवान यहाँ इंसान के 'ब्लाइंड-स्पॉट' (Blind-spot) और आध्यात्मिक अंधेपन का बहुत बड़ा और कड़वा सच बता रहे हैं।
            जो लोग केवल अपनी भौतिक आँखों (Physical eyes) पर भरोसा करते हैं, वे शरीर को मरते हुए तो देखते हैं लेकिन आत्मा को निकलते हुए नहीं देख पाते।
            उन्हें लगता है कि शरीर का मरना ही सब कुछ खत्म होना है क्योंकि उनके पास सत्य को देखने वाला सॉफ़्टवेयर (ज्ञान) ही नहीं है।
            वे यह भी नहीं समझ पाते कि उनके अंदर बैठा हुआ जीव प्रकृति के तीन गुणों (सत्त्व, रजस, तमस) का गुलाम बनकर कैसे काम कर रहा है।
            लेकिन जो व्यक्ति अध्यात्म और वेदों का गहरा अध्ययन करता है, उसकी 'ज्ञान की आँखें' (X-Ray Vision) खुल जाती हैं।
            वह ज्ञानी एक चलते-फिरते इंसान में भी उस अमर आत्मा को देख लेता है और मरते हुए शरीर से उसे सुरक्षित बाहर निकलते हुए भी समझ जाता है।
            हमें दुनिया को इन हाड़-मांस की आँखों से नहीं बल्कि ज्ञान और विज्ञान की आँखों से देखने की अपनी क्षमता विकसित करनी चाहिए।
            जो व्यक्ति आत्मा के इस सफर को समझ लेता है, उसके लिए मृत्यु का कोई डर नहीं रहता और उसका जीवन पूरी तरह बदल जाता है।
        """.trimIndent(),
        english = """
            The foolish and highly ignorant cannot possibly understand how a living entity quits his body, nor can they see how he enjoys while under the spell of the modes of nature.
            But those exceptionally wise persons whose eyes are heavily trained in knowledge (Jnana-chakshushah) can see all this flawlessly and clearly.
            The Lord is brutally exposing the massive 'Blind-spot' and pathetic spiritual blindness plaguing the majority of the human race.
            Ignorant mortals who blindly rely solely on their fragile physical retinas can witness a body rotting, but they absolutely cannot perceive the soul exiting.
            They tragically hallucinate that biological death is the absolute end of existence because they completely lack the required software of truth.
            They also fail to realize how the entity residing inside them is operating purely as a pathetic slave to the three modes of material nature.
            But the elite seeker who aggressively absorbs transcendental knowledge successfully unlocks his 'Eyes of Knowledge' (Spiritual X-Ray Vision).
            This sage effortlessly perceives the immortal soul operating a walking biological body and scientifically understands its safe exit during terminal death.
            We must urgently upgrade our perception, refusing to view the world through biological flesh and relying instead on the lens of supreme cosmic logic.
            For the master who successfully decodes this eternal journey of the soul, the paralyzing terror of death is permanently deleted from his psychology.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            यतन्तो योगिनश्चैनं पश्यन्त्यात्मन्यवस्थितम् |
            यतन्तोऽप्यकृतात्मानो नैनं पश्यन्त्यचेतसः || ११ ||
        """.trimIndent(),
        hindi = """
            जो योगी दृढ़ निश्चय के साथ प्रयास (यतन्तो) करते हैं, वे ही इस आत्मा को अपने हृदय के भीतर स्थित स्पष्ट रूप से देख पाते हैं।
            परंतु जिन्होंने अपने मन को शुद्ध नहीं किया है (अकृतात्मानो) और जो अज्ञानी हैं, वे बहुत प्रयास करने के बावजूद भी इस आत्मा को नहीं देख पाते।
            यहाँ भगवान 'सेल्फ-रियलाइजेशन' (Self-realization) के लिए एक बहुत ही कड़ी और ज़रूरी कंडीशन (Condition) बता रहे हैं।
            केवल किताबें पढ़ लेने या आँखें बंद करके बैठ जाने से किसी को आत्मा के दर्शन या ईश्वर की प्राप्ति नहीं हो जाती है।
            आत्मा को देखने के लिए सबसे पहली शर्त है 'हृदय की शुद्धि'—यानी अपने अंदर से अहंकार, लालच और नफरत का कचरा पूरी तरह साफ करना।
            जो योगी अपने चरित्र को हीरे की तरह साफ कर लेते हैं, वे ही अपने भीतर छिपी हुई उस दिव्य शक्ति को पहचान पाते हैं।
            लेकिन जो लोग अंदर से वासनाओं और बुरे विचारों से भरे हुए हैं, वे चाहे हिमालय पर जाकर सौ साल तक भी ध्यान क्यों न लगा लें।
            भगवान की यह चेतावनी है कि वे अज्ञानी लोग अपने लाखों प्रयासों के बाद भी उस परम सत्य को कभी भी नहीं देख सकते।
            ईश्वर का साक्षात्कार कोई मैकेनिकल प्रोसेस (Mechanical process) नहीं है, यह पूरी तरह से आपकी आंतरिक पवित्रता पर निर्भर करता है।
            इसलिए मनुष्य को सबसे पहले अपना कैरेक्टर (Character) सुधारना चाहिए, उसके बाद ही उसे योग और ध्यान में सच्ची सफलता मिलती है।
        """.trimIndent(),
        english = """
            The steadily endeavoring transcendentalists, who are highly situated in yoga, can clearly see all this taking place directly within their own hearts.
            But those heavily degraded humans whose minds are not purified and who lack genuine intelligence cannot possibly see what is happening, regardless of how much they try.
            The Lord is establishing an uncompromising, iron-clad 'Condition' required to successfully execute genuine Self-Realization.
            Merely memorizing massive philosophical books or mechanically sitting with closed eyes absolutely does not guarantee a vision of the soul.
            The absolute first prerequisite for perceiving the spirit is 'Internal Purification'—violently scrubbing all toxic arrogance, greed, and hatred from the heart.
            Elite yogis who flawlessly polish their character to shine like a diamond are the only ones granted the security clearance to perceive the divine energy within.
            However, those whose internal hard drives are deeply infected with biological lust and toxic thoughts can meditate in the Himalayas for a century and achieve nothing.
            The Lord issues a stern warning: such ignorant fools, despite their massive mechanical efforts, will mathematically never perceive the Absolute Truth.
            God-realization is absolutely NOT a cheap mechanical process; it strictly depends 100% on the flawless purity of your internal consciousness.
            Therefore, a human must urgently focus on upgrading his core character first; only then will his yoga and meditation yield explosive spiritual success.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            यदादित्यगतं तेजो जगद्भासयतेऽखिलम् |
            यच्चन्द्रमसि यच्चाग्नौ तत्तेजो विद्धि मामकम् || १२ ||
        """.trimIndent(),
        hindi = """
            हे अर्जुन! सूर्य में स्थित जो भयंकर तेज (प्रकाश) इस पूरे ब्रह्मांड को प्रकाशित कर रहा है, उसे तुम मेरा ही तेज समझो।
            और जो प्रकाश चंद्रमा में मौजूद है तथा जो ताप (रोशनी) अग्नि में है, वह सब प्रकाश भी तुम मुझसे ही उत्पन्न हुआ जानो।
            भगवान श्रीकृष्ण अब अपनी उस अनंत शक्ति का वर्णन कर रहे हैं जो इस भौतिक दुनिया के पूरे इको-सिस्टम (Eco-system) को चला रही है।
            हम इंसान समझते हैं कि सूर्य एक गैस का गोला है जो अपने आप जल रहा है और चंद्रमा एक पत्थर है जो चमक रहा है।
            लेकिन भगवान उस पर्दे के पीछे का असली विज्ञान बताते हैं कि सूर्य, चंद्रमा और अग्नि के पास अपनी कोई आज़ाद (Independent) शक्ति नहीं है।
            यह पूरा सोलर सिस्टम (Solar System) एक बल्ब की तरह है जिसमें बिजली (Energy) सीधे भगवान के सुप्रीम पावर-हाउस से आ रही है।
            सूर्य की रोशनी जो हमें जीवन देती है और अग्नि जो हमें सर्दी से बचाती है, वह साक्षात् ईश्वर की ही केयर (Care) और उपस्थिति है।
            भगवान यह बता रहे हैं कि दुनिया की सबसे ताकतवर और चमकदार चीज़ों में जो असीम ऊर्जा है, वह मेरी ही ऊर्जा का एक बहुत छोटा सा स्पार्क है।
            जब हम इस बात को समझ लेते हैं, तो हम प्रकृति की हर बड़ी शक्ति के सामने नम्र हो जाते हैं और उसमें ईश्वर का दर्शन करते हैं।
            यह श्लोक भौतिक विज्ञान (Physics) और अध्यात्म के बीच के गहरे संबंध को बहुत ही भव्य तरीके से दुनिया के सामने रखता है।
        """.trimIndent(),
        english = """
            O Arjuna! The absolute blinding splendor of the sun, which efficiently dissipates the darkness of this entire universe, comes entirely from Me.
            And the soothing, brilliant radiance of the moon, as well as the intense, blazing light of the fire, are also to be understood as completely originating from Me.
            Lord Sri Krishna is now explicitly describing His infinite cosmic energy that flawlessly powers the entire eco-system of this material matrix.
            Ignorant humans foolishly assume the sun is merely an autonomous, burning ball of hydrogen gas and the moon is just a glowing rock.
            But the Lord violently pulls back the cosmic curtain, revealing that the sun, moon, and fire possess absolutely zero independent energy of their own.
            This entire Solar System operates exactly like a giant lightbulb, heavily powered by the invisible electricity flowing directly from God's Supreme Powerhouse.
            The solar radiation that biological sustains life and the fire that protects humanity are direct, physical manifestations of God's care and presence.
            The Lord is demonstrating that the absolute most terrifyingly powerful and luminous entities in the universe are merely a tiny microscopic spark of His energy.
            When a human deeply internalizes this, he instantly drops his arrogance, becoming profoundly humble and actively perceiving God within the forces of nature.
            This spectacular verse brilliantly and majestically bridges the massive gap between advanced quantum physics and supreme transcendental spirituality.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            गामाविश्य च भूतानि धारयाम्यहमोजसा |
            पुष्णामि चौषधीः सर्वाः सोमो भूत्वा रसात्मकः || १३ ||
        """.trimIndent(),
        hindi = """
            मैं ही प्रत्येक लोक (ग्रह) में प्रवेश करके अपनी असीम शक्ति (ओज) से उन सभी ग्रहों और उनके प्राणियों को धारण करता हूँ (हवा में टिकाए रखता हूँ)।
            और मैं ही रसों से भरा हुआ अमृतमयी चंद्रमा (सोम) बनकर पृथ्वी की सभी वनस्पतियों (पेड़-पौधों और फसलों) को जीवन और पोषण देता हूँ।
            यह श्लोक ब्रह्मांड के काम करने के तरीके (Cosmology) और खेती (Agriculture) का सबसे बड़ा और गहरा रहस्य खोलता है।
            हम सोचते हैं कि करोड़ों भारी ग्रह अंतरिक्ष में 'ग्रेविटी' (Gravity) के कारण हवा में टिके हुए हैं, लेकिन उस ग्रेविटी की ताकत कहाँ से आती है?
            भगवान स्पष्ट कहते हैं: "मैं खुद अपनी असीम ऊर्जा (ओज) से इस पूरे ब्रह्मांड के खरबों ग्रहों को बिना किसी सपोर्ट के हवा में होल्ड (Hold) किए हुए हूँ।"
            इतना ही नहीं, जो फसलें और सब्जियां हम खाते हैं, उनमें स्वाद और पोषण (Vitamins) ज़मीन या पानी से नहीं आता।
            भगवान कहते हैं कि "मैं रात के समय 'चंद्रमा' की चांदनी बनकर उन सभी फसलों में अपना अमृत और रस (Juice) डालता हूँ जिससे वे पकती हैं।"
            यह साबित करता है कि हम जो साँस ले रहे हैं और जो खाना हम खा रहे हैं, वह सब कुछ सीधे तौर पर भगवान की ही मेहरबानी और शक्ति है।
            ईश्वर केवल आसमान में बैठा हुआ कोई दर्शक नहीं है, बल्कि वह एक 'सपोर्ट सिस्टम' (Support System) की तरह इस दुनिया के ज़र्रे-ज़र्रे को चला रहा है।
            हमें अपने हर निवाले और अपने अस्तित्व के लिए उस परम शक्ति का हमेशा गहराई से और दिल से शुक्रगुज़ार होना चाहिए।
        """.trimIndent(),
        english = """
            I physically and spiritually enter into each planetary system, and by My supreme, undeniable energy, I sustain them and keep them perfectly in orbit.
            I also personally become the nectar-giving moon, actively supplying the essential juice of life to nourish all the vegetables and vegetation on earth.
            This spectacular verse violently decodes the absolute greatest mysteries of both universal Cosmology and biological Agriculture.
            We blindly hallucinate that billions of massive, heavy planets are magically suspended in the cosmic vacuum merely due to the blind laws of 'Gravity'.
            The Lord explicitly declares: "I Myself, using My staggering, infinite raw power (Ojas), physically Hold and flawlessly suspend all these trillions of planets in orbit without any visible support."
            Furthermore, the nutritional value and delicious taste inside the crops and vegetables we consume do not originate merely from dirt or basic water.
            The Lord reveals, "I actively transform into the soothing moonlight at night, aggressively injecting My divine nectar and essential juices directly into all the growing crops."
            This mathematically proves that the very air we breathe and the daily meals we consume are strictly the direct result of God's active, hands-on mercy.
            God is absolutely not an isolated spectator lounging in the sky; He is the heavy 'Support System' meticulously micro-managing every atom of the matrix.
            A human being must be profoundly and violently grateful from the bottom of his soul for every single bite of food and the very stability of his existence.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            अहं वैश्वानरो भूत्वा प्राणिनां देहमाश्रितः |
            प्राणापानसमायुक्तः पचाम्यन्नं चतुर्विधम् || १४ ||
        """.trimIndent(),
        hindi = """
            मैं ही सभी जीवित प्राणियों के शरीर में 'वैश्वानर' (पाचन अग्नि / जठराग्नि) के रूप में स्थित रहता हूँ।
            और मैं ही प्राण और अपान वायु के साथ मिलकर उनके द्वारा खाए गए चार प्रकार के अन्न (भोजन) को पचाने का काम करता हूँ।
            भगवान की केयर (Care) और इंजीनियरिंग का यह सबसे ज़बरदस्त और हैरान करने वाला उदाहरण है!
            भगवान न केवल चाँद बनकर फसल उगाते हैं (श्लोक 13), बल्कि जब हम वह खाना खा लेते हैं, तो उसे पचाने का काम भी वही करते हैं!
            हमारे पेट के अंदर जो 'एसिड' (Acid / पाचन अग्नि) खाने को गलता है, भगवान कहते हैं कि वह 'वैश्वानर' आग साक्षात् मेरा ही रूप है।
            हम इंसान केवल खाना चबाकर पेट में धकेल सकते हैं, लेकिन उस खाने को खून, हड्डी और ऊर्जा में बदलने का जटिल काम इंसान के कंट्रोल में नहीं है।
            भगवान प्राण (अंदर जाने वाली साँस) और अपान (बाहर आने वाली साँस) का इस्तेमाल करके उस भोजन को 100% परफेक्शन के साथ पचाते हैं।
            चार प्रकार के खाने होते हैं: चबाने वाले (रोटी), चूसने वाले (गन्ना), चाटने वाले (शहद) और पीने वाले (पानी); भगवान इन सबको हज़म करते हैं।
            इसका मतलब है कि भगवान हमारे शरीर रूपी घर में एक 'शेफ और डॉक्टर' (Chef and Doctor) की तरह लगातार 24 घंटे काम कर रहे हैं।
            इसलिए भोजन करने से पहले भगवान को धन्यवाद देना केवल एक रस्म नहीं है, बल्कि यह एक बहुत बड़ा वैज्ञानिक और आध्यात्मिक सच है।
        """.trimIndent(),
        english = """
            I am physically situated directly within the biological bodies of all living entities as the blazing fire of digestion (Vaishvanara).
            And I join with the incoming outgoing breath of life (Prana and Apana) to effectively digest the four different kinds of foodstuff consumed by the entity.
            This is the absolute most staggering and mind-blowing demonstration of God's intimate Care and biological Engineering!
            The Lord does not merely act as the moon to grow the crops (Verse 13); once we casually swallow that food, He personally takes over the complex digestion process!
            The highly corrosive biological 'Acid' (gastric fire) churning inside our stomachs is officially declared by the Lord to be His direct physical manifestation as 'Vaishvanara'.
            A human can merely chew his food and carelessly swallow it down, but the terrifyingly complex process of converting that dead matter into living blood, bone, and energy is completely out of his control.
            The Lord perfectly utilizes the mechanics of the incoming and outgoing biological breath to execute this digestion with 100% flawless, mathematical precision.
            There are exactly four types of consumables: chewed (bread), sucked (sugarcane), licked (honey), and drunk (water); the Lord effortlessly metabolizes them all.
            This means the Supreme Creator is operating 24/7 inside your physical body exactly like an elite, internal 'Chef and Doctor', keeping your machine alive.
            Therefore, expressing deep gratitude to God before eating is absolutely not a cheap ritual; it is acknowledging a massive scientific and spiritual reality.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            सर्वस्य चाहं हृदि सन्निविष्टो मत्तः स्मृतिर्ज्ञानमपोहनं च |
            वेदैश्च सर्वैरहमेव वेद्यो वेदान्तकृद्वेदविदेव चाहम् || १५ ||
        """.trimIndent(),
        hindi = """
            मैं ही ब्रह्मांड के सभी प्राणियों के हृदय में परमात्मा के रूप में गहराई से विराजमान हूँ और उन पर नियंत्रण रखता हूँ।
            मुझसे ही इंसान को उसकी पुरानी यादें (स्मृति), सच्चा ज्ञान और भूलने की शक्ति (विस्मृति / Apohanam) प्राप्त होती है।
            मैं केवल एक मूक दर्शक नहीं हूँ बल्कि मैं जीव के हर कर्म और उसके हर विचार का साक्षात संचालन भी करता हूँ।
            चारों वेदों और सभी शास्त्रों के अध्ययन के द्वारा वास्तव में केवल मुझे (परमेश्वर को) ही जानना सबसे मुख्य लक्ष्य है।
            मैं ही वेदांत का असली रचयिता हूँ और मैं ही वेदों के सबसे गहरे और रहस्यमयी अर्थों को जानने वाला परम ज्ञाता हूँ।
            यह श्लोक साबित करता है कि ईश्वर कोई दूर बैठा हुआ तानाशाह नहीं है बल्कि वह हमारे ही दिल की धड़कन में मौजूद हमारा सबसे करीबी है।
            हमारी सोचने-समझने की क्षमता और हमारी बुद्धिमानी भी हमारी अपनी नहीं है, वह केवल ईश्वर का दिया हुआ एक सॉफ्टवेयर है जो वे कभी भी छीन सकते हैं।
            जब हम अहंकार में भरकर खुद को बहुत बड़ा ज्ञानी मानते हैं तो हम भूल जाते हैं कि वह ज्ञान का कनेक्शन हमें कहाँ से मिल रहा है।
            ईश्वर ही वह एकमात्र परम गुरु है जो हमारे भीतर से हमें सही रास्ता दिखाता है और गलतियों पर हमें चेतावनी (Warning) देता है।
            इस पूर्ण सत्य को पहचान लेना ही सभी वेदों को पढ़ने का एकमात्र और सबसे बड़ा आध्यात्मिक निष्कर्ष माना गया है।
        """.trimIndent(),
        english = """
            I am officially and intimately seated directly within the hearts of absolutely all living entities as the Supersoul.
            From Me alone originate a human's precise memory, supreme knowledge, and the inevitable capability of forgetfulness.
            I am not merely a silent observer; I actively orchestrate the psychological processing and karma of every biological machine.
            By all the vast libraries of the Vedas and complex scriptures, I am the absolute only truth that is to be fundamentally known.
            Indeed, I am the original compiler of Vedanta, and I am the supreme, flawless knower of all Vedic conclusions.
            This spectacular verse proves that God is absolutely not a distant, isolated dictator but exists perfectly within our very heartbeat.
            Our impressive intellectual processing power and human intelligence are not our own; they are merely temporary software downloaded by God.
            When we arrogantly boast about our massive academic achievements, we tragically forget the actual cosmic source supplying that brainpower.
            The Supreme Lord is the ultimate internal Guru who constantly guides the soul from within and issues psychological warnings against toxic actions.
            Realizing this staggering reality is universally recognized as the absolute highest, ultimate objective of all Vedic study and human existence.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            द्वाविमौ पुरुषौ लोके क्षरश्चाक्षर एव च |
            क्षरः सर्वाणि भूतानि कूटस्थोऽक्षर उच्यते || १६ ||
        """.trimIndent(),
        hindi = """
            इस संपूर्ण संसार में जीवों की मुख्य रूप से दो श्रेणियां या प्रकार होते हैं: एक 'क्षर' (विनाशी) और दूसरा 'अक्षर' (अविनाशी)।
            इस भौतिक ब्रह्मांड में रहने वाले जितने भी शरीरधारी जीव हैं, वे सब के सब 'क्षर' यानी पतनशील या बदलने वाले कहलाते हैं।
            परंतु जो जीव आध्यात्मिक जगत में स्थित हैं और जिनका कभी पतन नहीं होता, वे 'कूटस्थ' यानी 'अक्षर' (अविनाशी) कहलाते हैं।
            भगवान यहाँ जीवों के स्टेटस (Status) का एक बहुत बड़ा और स्पष्ट क्लासिफिकेशन (Classification) दुनिया के सामने रख रहे हैं।
            हम जो इस धरती पर रह रहे हैं, हम 'क्षर' (Fallible) हैं क्योंकि हम अपनी गलतियों और इच्छाओं के कारण बार-बार जन्म लेते और मरते हैं।
            हमारा शरीर, हमारी स्थिति और हमारे विचार हर सेकंड बदलते रहते हैं, इसलिए इस भौतिक दुनिया में कुछ भी परमानेंट या पक्का नहीं है।
            लेकिन जो आत्माएं भगवान की भक्ति करके उनके वैकुंठ धाम (Spiritual World) में पहुँच चुकी हैं, वे 'अक्षर' (Infallible) हो जाती हैं।
            वे वहाँ एक 'कूटस्थ' (लोहार की निहाई की तरह जो चोट पड़ने पर भी नहीं बदलती) अवस्था में हमेशा के लिए स्थिर और अमर हो जाती हैं।
            उनका कभी पतन नहीं होता और वे दोबारा कभी इस दुखों भरी मैट्रिक्स में लौटकर वापस नहीं आतीं।
            हर इंसान का अंतिम लक्ष्य इसी 'क्षर' अवस्था की गुलामी से बाहर निकलकर उस 'अक्षर' और आज़ाद अवस्था को प्राप्त करना होना चाहिए।
        """.trimIndent(),
        english = """
            There are fundamentally two classes of beings existing in the creation: the fallible (Kshara) and the infallible (Akshara).
            In this material universe, absolutely every single embodied living entity is officially classified as fallible and subject to constant degradation.
            However, in the eternal spiritual world, every living entity is perfectly infallible, unchanging, and eternally secure (Kuta-stha).
            The Lord is establishing a massive, crystal-clear cosmic 'Classification' regarding the exact status of all souls across the multiverse.
            We who currently reside on this biological earth are 'Kshara' (Fallible) because our toxic mistakes and desires force us to constantly reincarnate and suffer.
            Our physical bodies, our social positions, and our flickering thoughts mutate every microsecond; absolutely nothing in this matrix is permanent.
            But those elite souls who have successfully attained God's eternal Kingdom (Vaikuntha) through pure devotion are officially upgraded to 'Akshara' (Infallible).
            They become permanently 'Kuta-stha' (immoveable and unchanging like a blacksmith's anvil), establishing absolute, eternal immortality.
            They absolutely never degrade, fall down, or violently return to this horrific, temporary matrix of birth and death ever again.
            The ultimate, absolute goal of human existence is to aggressively escape the pathetic slavery of the fallible state and achieve that eternal, infallible perfection.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            उत्तमः पुरुषस्त्वन्यः परमात्मेत्युदाहृतः |
            यो लोकत्रयमाविश्य बिभर्त्यव्यय ईश्वरः || १७ ||
        """.trimIndent(),
        hindi = """
            परंतु इन दोनों (क्षर और अक्षर जीवों) से भी बिल्कुल अलग एक सबसे श्रेष्ठ और महान सत्ता है जिसे 'उत्तम पुरुष' कहा गया है।
            उसी उत्तम पुरुष को शास्त्रों में 'परमात्मा' (Super-soul) के नाम से पूरी दुनिया में जाना और पुकारा जाता है।
            वह अविनाशी परमेश्वर ही तीनों लोकों (स्वर्ग, पृथ्वी और पाताल) में प्रवेश करके इस पूरे ब्रह्मांड को धारण करता है और पालता है।
            लोग अक्सर 'आत्मा' और 'परमात्मा' को एक ही समझ लेते हैं, लेकिन भगवान यहाँ उस बड़े कन्फ्यूजन को पूरी तरह से साफ कर रहे हैं।
            चाहे कोई इंसान धरती पर फँसा हो (क्षर) या कोई मुक्त होकर वैकुंठ पहुँच गया हो (अक्षर), वे दोनों ही भगवान के केवल छोटे से अंश (Part) हैं।
            लेकिन जो भगवान खुद हैं, वे इन दोनों से बहुत ऊपर और 'सुप्रीम' (Supreme) हैं; वे ही 'उत्तम पुरुष' यानी सबसे बड़े और असली बॉस हैं।
            एक मुक्त आत्मा (अक्षर) शांत तो हो सकती है, लेकिन वह पूरे ब्रह्मांड को चलाने या उसे होल्ड (Hold) करने की ताकत कभी नहीं रखती।
            केवल वह 'परमात्मा' ही है जो अपने असीम और जादुई बल से इन खरबों ग्रहों और गैलेक्सीज़ को हवा में टिकाए हुए है।
            ईश्वर अपनी इस ड्यूटी में कभी नहीं थकता, वह 'अव्यय' (अविनाशी) है और वही इस पूरी सृष्टि का इकलौता 'सिस्टम-एडमिन' (System Admin) है।
            आत्मा हमेशा सेवक (Servant) है और परमात्मा हमेशा उसका मालिक (Master) है, यही सनातन धर्म का सबसे बड़ा और अंतिम सत्य है।
        """.trimIndent(),
        english = """
            Besides these two classes of beings, there is an absolute greatest, supreme living personality known universally as the Supreme Soul (Paramatma).
            He is completely distinct and entirely separate from both the fallible and the infallible souls, existing on a staggeringly superior level.
            He is the imperishable Supreme Lord who actively enters into all the three planetary systems, flawlessly sustaining and maintaining them all.
            Ignorant philosophers tragically confuse the tiny individual soul with the Supreme God, but the Lord aggressively obliterates that massive misconception here.
            Whether a soul is heavily trapped on earth (Kshara) or perfectly liberated in the spiritual sky (Akshara), they remain merely microscopic, dependent fragments.
            But the Supreme Godhead Himself exists infinitely 'Beyond' and above both categories; He is the 'Uttama Purusha', the undisputed Ultimate Boss.
            A liberated soul may achieve profound peace, but it mathematically possesses absolutely ZERO capacity to engineer, sustain, or control the colossal multiverse.
            It is exclusively the 'Paramatma' (Supersoul) who utilizes His terrifying, infinite magic to effortlessly suspend trillions of massive galaxies in the cosmic vacuum.
            The Lord absolutely never fatigues in this cosmic duty; He is 'Avyaya' (Inexhaustible) and functions as the absolute, single 'System Admin' of the matrix.
            The soul is eternally the dependent servant, and God is eternally the Supreme Master; this is the absolute, irrefutable final truth of existence.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            यस्मात्क्षरमतीतोऽहमक्षरादपि चोत्तमः |
            अतोऽस्मि लोके वेदे च प्रथितः पुरुषोत्तमः || १८ ||
        """.trimIndent(),
        hindi = """
            चूँकि मैं पतनशील (क्षर) जीवों से पूरी तरह परे हूँ और मुक्त (अक्षर) जीवों से भी बहुत अधिक श्रेष्ठ और महान हूँ।
            इसीलिए इस दुनिया (लोक) में और सभी वेदों (शास्त्रों) में मुझे 'पुरुषोत्तम' (सबसे महान पुरुष / Supreme Person) के नाम से पुकारा जाता है।
            यह श्लोक इस पंद्रहवें अध्याय का शीर्षक (Title) है और इसमें भगवान अपने 'पुरुषोत्तम' नाम का पूरा वैज्ञानिक अर्थ समझा रहे हैं।
            भगवान श्रीकृष्ण बहुत ही गर्व और स्पष्टता के साथ दुनिया के सामने अपनी सुप्रीम अथॉरिटी (Supreme Authority) का ऐलान कर रहे हैं।
            वे कहते हैं कि जो इंसान धरती पर पाप कर रहा है (क्षर), मैं उससे तो बहुत महान हूँ ही, इसमें कोई शक नहीं है।
            लेकिन जो बड़े-बड़े योगी और संत अपनी मेहनत से मोक्ष पाकर मुक्त (अक्षर) हो चुके हैं, मैं उन मुक्त आत्माओं से भी करोड़ों गुना बड़ा हूँ!
            यानी इस पूरे ब्रह्मांड में और आध्यात्मिक जगत में भी कृष्ण के बराबर या उनसे ऊपर कोई भी दूसरी सत्ता (Power) मौजूद नहीं है।
            इसीलिए दुनिया के सबसे महान ग्रंथ (वेद) और सबसे बड़े ज्ञानी लोग भी मुझे बिना किसी शक के 'द अल्टीमेट सुप्रीम बीइंग' (The Ultimate Supreme Being) मानते हैं।
            ईश्वर कोई निराकार शून्य नहीं है; वे एक 'पुरुष' (Personality) हैं और वो भी 'उत्तम' (सर्वश्रेष्ठ), जो सब कुछ देख और कर सकते हैं।
            जो इस सच को मान लेता है, उसका दिमाग दुनिया के बाकी सभी कन्फ्यूजन से आज़ाद हो जाता है और वह केवल कृष्ण की शरण में जाता है।
        """.trimIndent(),
        english = """
            Because I am transcendental, completely situated beyond the fallible souls, and because I am infinitely greater even than the infallible, liberated souls.
            Therefore, both in this material world and in all the Vedic scriptures, I am officially celebrated and widely known as the Supreme Person (Purushottama).
            This spectacular verse serves as the absolute title track of this Fifteenth Chapter, with the Lord clinically decoding the precise meaning of His name 'Purushottama'.
            Lord Sri Krishna is boldly and proudly broadcasting His undisputed, absolute 'Supreme Authority' to the entire multiverse without a shred of ambiguity.
            He declares: I am undeniably vastly superior to the degraded, sinning mortals trapped in the earthly matrix (Kshara)—that is an obvious, elementary fact.
            But even the most elite, highly elevated saints and yogis who have successfully achieved eternal Moksha (Akshara) are infinitely, mathematically subordinate to My absolute power!
            This means that in the entire expanse of both the material and spiritual universes, there is absolutely ZERO entity or power equal to or above Krishna.
            This is exactly why the absolute greatest cosmic scriptures (Vedas) and the most brilliant sages officially certify Me as 'The Ultimate Supreme Being'.
            God is absolutely NOT a dead, formless, emotionless void; He is the ultimate 'Personality' (Purusha) who is 'Uttama' (The Absolute Best), controlling everything.
            A human who intellectually locks onto this staggering truth instantly deletes all spiritual confusion from his brain and exclusively surrenders to Krishna.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            यो मामेवमसम्मूढो जानाति पुरुषोत्तमम् |
            स सर्वविद्भजति मां सर्वभावेन भारत || १९ ||
        """.trimIndent(),
        hindi = """
            हे भारत (अर्जुन)! जो मनुष्य बिना किसी भ्रम या शंका के (असम्मूढो) मुझे इस प्रकार साक्षात् 'पुरुषोत्तम' (परमेश्वर) के रूप में जान लेता है।
            वह मनुष्य वास्तव में 'सर्वज्ञ' (सब कुछ जानने वाला / सर्ववित्) है, और वह अपने पूरे भाव और हृदय से केवल मेरी ही भक्ति (भजन) करता है।
            भगवान श्रीकृष्ण यहाँ उस इंसान को 'सर्टिफिकेट' (Certificate) दे रहे हैं जिसने पिछले श्लोक का अर्थ पूरी तरह से समझ लिया है।
            दुनिया में बहुत से लोग खुद को ज्ञानी मानते हैं क्योंकि उन्होंने साइंस पढ़ी है या दुनिया के कई देश घूमे हैं।
            लेकिन भगवान कहते हैं कि वह सब ज्ञान अधूरा है; ब्रह्मांड का सबसे बड़ा 'जीनियस' (Genius / सर्ववित्) वह है जिसने मुझे 'सुप्रीम बॉस' मान लिया है।
            अगर इंसान को यह पक्का यकीन ('असम्मूढो') हो जाए कि कृष्ण ही सब कुछ हैं, तो उसे फिर दुनिया की और कोई किताब पढ़ने की ज़रूरत ही नहीं है।
            क्योंकि जब उसे 'सोर्स-कोड' (Source Code) मिल गया, तो उसने पूरी दुनिया का 'मास्टर-पासवर्ड' (Master Password) हैक (Hack) कर लिया!
            और जब इंसान का दिमाग यह अल्टीमेट सच जान लेता है, तो उसका रिएक्शन (Reaction) क्या होता है? वह अपना सारा टाइम फालतू के कामों में बर्बाद नहीं करता।
            वह "सर्वभावेन" (अपने 100% इमोशंस, प्यार और एक्शन के साथ) केवल भगवान की भक्ति में पागलों की तरह डूब जाता है।
            सच्चा ज्ञान हमेशा इंसान को घमंडी नहीं बनाता, बल्कि वह उसे एक बहुत ही प्यारा और समर्पित 'भक्त' (Devotee) बना देता है।
        """.trimIndent(),
        english = """
            O son of Bharata! Whoever unequivocally knows Me as the Supreme Personality of Godhead, completely free from all toxic doubts and illusion.
            He is to be officially recognized as the absolute knower of everything (Sarva-vit), and he therefore engages himself in full devotional service to Me with his entire being (Sarva-bhavena).
            Lord Sri Krishna is issuing the ultimate 'Cosmic Certificate of Genius' to the human who successfully decodes and internalizes the truth from the previous verse.
            In the matrix, ignorant mortals arrogantly brand themselves as brilliant intellectuals simply because they possess a PhD in physics or have traveled the globe.
            But the Lord declares that all such worldly data is pathetic and incomplete; the absolute greatest 'Genius' in the multiverse is the one who accepts Me as the Ultimate Boss.
            If a human achieves 100% titanium certainty ('Asammudho') that Krishna is the Supreme Creator, he mathematically never needs to read another academic book again.
            Because by successfully locating the original 'Source-Code' of creation, he has effectively 'Hacked' the ultimate Master Password of the entire universe!
            And what is the exact biological and psychological reaction of a brain that processes this ultimate truth? He absolutely stops wasting his timeline on cheap earthly garbage.
            He completely submerges himself "Sarva-bhavena" (Using 100% of his raw emotions, massive love, and physical actions) exclusively into passionate devotion to God.
            Genuine, elite spiritual knowledge absolutely never makes a human arrogantly proud; it flawlessly transforms him into an incredibly sweet, fully surrendered Devotee.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            इति गुह्यतमं शास्त्रमिदमुक्तं मयानघ |
            एतद्बुद्ध्वा बुद्धिमान्स्यात्कृतकृत्यश्च भारत || २० ||
        """.trimIndent(),
        hindi = """
            हे निष्पाप अर्जुन (अनघ)! इस प्रकार मैंने तुम्हें वेदों और शास्त्रों का यह सबसे 'परम गोपनीय' (सबसे बड़ा रहस्य / गुह्यतमं) ज्ञान बता दिया है।
            हे भारत! इस ज्ञान को पूरी तरह से समझकर (एतद्बुद्ध्वा) मनुष्य सचमुच 'बुद्धिमान' (परम ज्ञानी) हो जाता है और उसके जीवन के सभी काम पूरे (कृतकृत्यः) हो जाते हैं!
            यह पंद्रहवें अध्याय (पुरुषोत्तम योग) का अत्यंत ही शानदार और 'माइक-ड्रॉप' (Mic-drop) ग्रैंड फिनाले श्लोक है!
            भगवान श्रीकृष्ण कहते हैं कि अर्जुन, मैंने तुम्हारे सामने ब्रह्मांड की सबसे बड़ी और 'टॉप-सीक्रेट फाइल' (Top-Secret File) खोल कर रख दी है।
            यह कोई साधारण फिलॉसफी नहीं है, यह वेदों का वो 'गुह्यतमं शास्त्र' (The most confidential science) है जो देवताओं तक को आसानी से नहीं मिलता।
            जब इंसान इस पंद्रहवें अध्याय के विज्ञान (पेड़, आत्मा, परमात्मा और पुरुषोत्तम) को पूरी तरह से डिकोड (Decode) कर लेता है, तो चमत्कार होता है।
            भगवान खुद उसे 'बुद्धिमान' (The most intelligent entity) का टाइटल देते हैं, क्योंकि उसने उस सच को पा लिया है जिसे बड़े-बड़े साइंटिस्ट नहीं पा सके।
            "कृतकृत्यश्च"—यह सबसे पावरफुल शब्द है! इसका मतलब है कि इस ज्ञान को पाने के बाद इंसान को इस दुनिया में अब और कुछ भी करना या पाना बाकी नहीं रह जाता।
            उसकी ज़िंदगी का 'मिशन' (Mission) 100% सक्सेसफुल (Successful) हो जाता है और वह इस जन्म-मरण के खतरनाक खेल से हमेशा के लिए आज़ाद होकर 'गेम ओवर' (Game Over) कर देता है।
            यहाँ पुरुषोत्तम योग नामक यह असीम और दिव्य अध्याय पूर्ण होता है, जो इंसान को सीधा भगवान के हृदय तक ले जाता है।
        """.trimIndent(),
        english = """
            O sinless Arjuna (Anagha)! This is the absolute most confidential, highly classified part of the Vedic scriptures, and it has now been officially disclosed by Me.
            O son of Bharata! Whoever deeply understands this supreme science becomes entirely wise and truly intelligent (Buddhiman), and his endeavors come to absolute perfection (Krita-krityash).
            This is the incredibly spectacular, majestic, and aggressive 'MIC-DROP' Grand Finale verse of the Fifteenth Chapter (Purushottama Yoga)!
            Lord Sri Krishna declares: Arjuna, I have just officially declassified and unlocked the universe's absolute biggest 'Top-Secret File' directly into your brain.
            This is absolutely not cheap, generic philosophy; it is the 'Guhyatamam Shastra' (The Most Confidential Cosmic Science) that even elite demigods struggle to access.
            When a human completely decodes and internalizes the brutal science of this 15th Chapter (the tree, the soul, the Supersoul, and the Supreme Person), a cosmic miracle occurs.
            God Himself personally awards him the official title of 'Buddhiman' (The Absolute Most Intelligent Entity), because he cracked the code that arrogant modern scientists completely missed.
            "Krita-krityash"—This is the absolute most powerful term! It mathematically means that after securing this knowledge, the human has absolutely NOTHING left to achieve or do in this matrix.
            His entire biological and spiritual 'Mission' becomes 100% Successful; he permanently escapes the terrifying game of reincarnation, achieving an eternal 'Game Over' for material suffering.
            Here flawlessly concludes the majestic Purushottama Yoga, the divine chapter that provides the direct, non-stop flight straight into the heart of the Supreme Godhead.
        """.trimIndent()
    )
)