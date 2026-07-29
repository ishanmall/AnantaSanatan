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
fun AdhyayaSeventeen() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaSeventeenShlokas.indexOfFirst { it.id == shlokaNum }
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
            label = { Text("Search Shloka Number (1 - 28)") },
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
            itemsIndexed(adhyayaSeventeenShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaSeventeenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            अर्जुन उवाच |
            ये शास्त्रविधिमुत्सृज्य यजन्ते श्रद्धयान्विताः |
            तेषां निष्ठा तु का कृष्ण सत्त्वमाहो रजस्तमः || १ ||
        """.trimIndent(),
        hindi = """
            अर्जुन ने पूछा कि हे कृष्ण जो लोग शास्त्रों के कड़े नियमों को छोड़ देते हैं पर गहरी श्रद्धा के साथ पूजा करते हैं उनकी स्थिति क्या होती है।
            क्या ऐसे लोगों की निष्ठा और विश्वास को सात्त्विक माना जाना चाहिए या फिर वह राजसिक और तामसिक प्रकृति के अंतर्गत आती है।
            पिछले अध्याय के अंत में भगवान ने अर्जुन को चेतावनी दी थी कि जो व्यक्ति शास्त्रों के नियमों को नहीं मानता उसे कभी सिद्धि प्राप्त नहीं होती।
            इस बात को सुनकर अर्जुन के मन में उन लोगों के लिए एक बहुत बड़ा मनोवैज्ञानिक संशय और जिज्ञासा पैदा हो गई जो नियम तो नहीं जानते पर दिल के साफ हैं।
            दुनिया में ऐसे करोड़ों लोग हैं जो वेदों और शास्त्रों की जटिल भाषा या पूजा-पाठ के भारी नियमों से पूरी तरह से अनजान होते हैं।
            लेकिन उनके हृदय में भगवान के प्रति एक अत्यंत भोली और सच्ची आस्था होती है जिसके बल पर वे अपनी क्षमता के अनुसार ईश्वर की पूजा करते हैं।
            अर्जुन भगवान से यह स्पष्ट करना चाहते हैं कि क्या बिना किताबी ज्ञान के केवल अंधी श्रद्धा के सहारे किया गया कर्म ईश्वर को स्वीकार्य है या नहीं।
            यह प्रश्न इस बात का निर्धारण करेगा कि अध्यात्म में ज्ञान और नियमों का महत्व अधिक है या मनुष्य के भीतर पलने वाले शुद्ध भाव का।
            सत्रहवें अध्याय का यह आरंभिक प्रश्न आस्था और धर्म के बीच फैले सबसे बड़े भ्रम को हमेशा के लिए मिटाने की नींव रखता है।
            भगवान अब इस प्रश्न का उत्तर देते हुए मानव मनोविज्ञान और श्रद्धा के विज्ञान का अत्यंत सूक्ष्म और वैज्ञानिक विश्लेषण प्रस्तुत करेंगे।
        """.trimIndent(),
        english = """
            Arjuna inquired asking O Krishna what is the actual spiritual status of those who discard scriptural rules yet worship with intense faith.
            Should the underlying devotion and firm conviction of such individuals be classified strictly as goodness passion or blinding ignorance.
            At the magnificent conclusion of the previous chapter the Lord delivered a stern warning that ignoring scriptural injunctions guarantees failure.
            Hearing this absolute decree Arjuna developed a massive psychological curiosity regarding the innocent masses who lack knowledge but possess pure hearts.
            There are billions of ordinary humans globally who are completely uneducated regarding the highly complex vocabulary and rigid protocols of Vedic scriptures.
            However deep within their biological hearts they harbor a profoundly innocent and unyielding faith allowing them to worship God with pure sincerity.
            Arjuna is aggressively demanding the Supreme Lord to officially clarify whether blind faith devoid of technical academic knowledge is spiritually valid or utterly useless.
            This profound question fundamentally audits whether rigid religious methodology is superior to the raw unadulterated emotional devotion residing inside a human being.
            This opening inquiry of the seventeenth chapter lays the titanium foundation for completely annihilating the greatest global confusion surrounding faith and structured religion.
            The Lord will now provide a staggeringly clinical and highly scientific psychological analysis decoding the exact mechanics of human faith and its material modes.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            श्रीभगवानुवाच |
            त्रिविधा भवति श्रद्धा देहिनां सा स्वभावजा |
            सात्त्विकी राजसी चैव तामसी चेति तां शृणु || २ ||
        """.trimIndent(),
        hindi = """
            श्री भगवान ने कहा कि हे अर्जुन शरीर धारी मनुष्यों की जो स्वाभाविक श्रद्धा और आस्था होती है वह मुख्य रूप से तीन प्रकार की ही होती है।
            यह श्रद्धा उनके अपने पिछले जन्मों के कर्मों और उनके वर्तमान स्वभाव के अनुसार सात्त्विक राजसिक और तामसिक रूप में उत्पन्न होती है।
            भगवान स्पष्ट करते हैं कि दुनिया में कोई भी इंसान बिना आस्था या श्रद्धा के जीवित नहीं रह सकता क्योंकि श्रद्धा ही चेतना का मूल आधार है।
            लेकिन हर इंसान की श्रद्धा का स्तर एक जैसा नहीं होता बल्कि वह उसके भीतर हावी रहने वाले प्रकृति के तीन गुणों पर पूरी तरह निर्भर करता है।
            सात्त्विक श्रद्धा शांति और पवित्रता से जन्म लेती है जबकि राजसिक श्रद्धा अहंकार और लालच के ईंधन से जलती हुई अंधी वासना है।
            तामसिक श्रद्धा पूरी तरह से अज्ञानता और मानसिक अंधेरे की उपज है जो इंसान को विनाशकारी और मूढ़ मान्यताओं की तरफ धकेलती है।
            इंसान जिस गुण के प्रभाव में सबसे ज्यादा समय बिताता है उसकी मानसिक प्रोग्रामिंग और ईश्वर को देखने का नज़रिया भी बिल्कुल वैसा ही बन जाता है।
            इसलिए धर्म और आस्था कोई एक फिक्स नियम नहीं है बल्कि यह हर इंसान की बायोलॉजिकल और मनोवैज्ञानिक बनावट के अनुसार अलग-अलग रूप ले लेती है।
            भगवान अर्जुन को आदेश देते हैं कि वह इस श्रद्धा के जटिल और वैज्ञानिक विभाजन को अत्यंत ध्यान से सुने ताकि वह इंसानों को पहचान सके।
            यह श्लोक प्रमाणित करता है कि इंसान का कैरेक्टर ही उसकी आस्था को आकार देता है न कि केवल उसके द्वारा पहने गए धार्मिक कपड़े।
        """.trimIndent(),
        english = """
            The Supreme Personality of Godhead declared that the natural faith and deep convictions of all embodied beings are biologically divided into three distinct categories.
            This intrinsic faith is mathematically generated strictly according to their accumulated past karma and current psychological nature manifesting as goodness passion and ignorance.
            The Lord explicitly clarifies that absolutely no human entity can operate without some form of faith because conviction is the fundamental operating system of consciousness.
            However the specific frequency and purity of a person's faith are never uniform; they depend entirely upon which material mode currently dominates their biological brain.
            Faith in the mode of goodness is born from profound purity and peace while passionate faith is a blind craving fueled purely by toxic ego and ambition.
            Faith existing in the lowest mode of ignorance is a direct product of mental darkness pushing the human relentlessly toward highly destructive and superstitious beliefs.
            Whichever specific cosmic mode a human spends his timeline absorbing entirely dictates his psychological programming and heavily distorts his personal perception of the Divine.
            Therefore spirituality is absolutely not a generic template; it physically and mathematically mutates to perfectly match the precise biological and psychological architecture of the individual.
            The Lord commands Arjuna to listen with absolute focus to this highly scientific and clinical breakdown of human faith so he can flawlessly analyze society.
            This spectacular verse officially proves that a human's internal character software actively sculpts his religious faith rather than his external religious garments or titles.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            सत्त्वानुरूपा सर्वस्य श्रद्धा भवति भारत |
            श्रद्धामयोऽयं पुरुषो यो यच्छ्रद्धः स एव सः || ३ ||
        """.trimIndent(),
        hindi = """
            हे भारत! प्रत्येक मनुष्य की श्रद्धा उसके अंतःकरण और उसकी जन्मजात प्रकृति के अनुसार ही अपने आप ढल जाती है और विकसित होती है।
            यह मनुष्य वास्तव में अपनी ही श्रद्धा और विश्वास का बना हुआ एक जीता-जागता पुतला है क्योंकि जिसकी जैसी श्रद्धा होती है वह इंसान वैसा ही बन जाता है।
            यह श्लोक मानव मनोविज्ञान का सबसे बड़ा और अचूक सूत्र है जो यह साबित करता है कि हमारी आस्था ही हमारी असल पहचान का निर्माण करती है।
            जिस व्यक्ति के दिल में हमेशा पवित्रता और भलाई के विचार चलते हैं उसकी आस्था स्वतः ही अत्यंत सात्त्विक और सकारात्मक दिशा में प्रवाहित होने लगती है।
            इसके विपरीत जिस इंसान का दिमाग केवल पैसे और पावर को पूजता है उसकी श्रद्धा राजसिक हो जाती है और वह केवल लालच के पीछे भागता है।
            भगवान यहाँ एक बहुत ही आधुनिक मनोवैज्ञानिक सिद्धांत प्रस्तुत कर रहे हैं कि हम वही बनते हैं जिस पर हम सबसे अधिक और अटूट विश्वास करते हैं।
            अगर कोई इंसान खुद पर और अपनी बुराई पर विश्वास करता है तो वह निश्चित रूप से एक राक्षस बन जाता है क्योंकि उसकी श्रद्धा नकारात्मक है।
            हमारा पूरा जीवन हमारे इसी गहरे विश्वास का एक भौतिक प्रतिबिंब मात्र है और हमारे हर निर्णय को हमारी यह अदृश्य आस्था ही चला रही होती है।
            इसलिए मनुष्य को सबसे ज्यादा मेहनत अपने बैंक बैलेंस पर नहीं बल्कि अपनी भीतरी श्रद्धा की क्वालिटी को अपग्रेड करने पर करनी चाहिए।
            जो व्यक्ति अपनी आस्था को ईश्वरीय सत्य से जोड़ लेता है वह अंततः साक्षात् उसी परब्रह्म के समान असीम और महान बन जाता है।
        """.trimIndent(),
        english = """
            O son of Bharata the specific faith of every human being dynamically evolves and shapes itself strictly according to his internal biological nature.
            A human is literally constructed entirely out of his own deep convictions because whatever a person inherently believes with absolute faith that is exactly what he becomes.
            This phenomenal verse provides the absolute greatest and most flawless formula of human psychology proving mathematically that our core beliefs architect our true identity.
            An individual whose heart constantly processes pure and benevolent thoughts spontaneously develops a faith that flows naturally toward the supreme mode of goodness.
            Conversely a human whose corrupted brain exclusively worships cheap paper money and toxic power generates a passionate faith forcing him to sprint blindly after greed.
            The Lord is unveiling a highly advanced psychological principle here asserting that we biologically and spiritually manifest into the exact entities we most deeply believe in.
            If a mortal actively places his absolute faith in his own toxic desires and destructive behaviors he inevitably mutates into a literal demon reflecting his negative conviction.
            Our entire physical existence is merely a gross biological reflection of our deepest subconscious faith which acts as the invisible software dictating every single life decision.
            Therefore a human must aggressively invest his maximum daily effort not in hoarding temporary wealth but in severely upgrading the absolute quality of his internal faith.
            One who successfully locks his titanium faith onto the eternal cosmic truth ultimately and mathematically elevates himself to become identical in nature to the Supreme Godhead.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            यजन्ते सात्त्विका देवान्यक्षरक्षांसि राजसाः |
            प्रेतान्भूतगणांश्चान्ये यजन्ते तामसा जनाः || ४ ||
        """.trimIndent(),
        hindi = """
            सात्त्विक स्वभाव वाले शुद्ध मनुष्य हमेशा स्वर्ग के देवताओं की पूजा करते हैं ताकि वे जीवन में ज्ञान और प्रकाश की ओर आगे बढ़ सकें।
            राजसिक स्वभाव वाले लालची लोग यक्षों और राक्षसों की पूजा करते हैं क्योंकि उन्हें बहुत सारा पैसा और रातों-रात असीम ताकत चाहिए होती है।
            और जो लोग घोर तामसिक और अज्ञानी होते हैं वे श्मशानों में जाकर भूत-प्रेतों और निचली आत्माओं की भयंकर और खौफनाक पूजा करते हैं।
            भगवान यहाँ इंसान के आराध्य यानी वो किसकी पूजा करता है उसे देखकर ही उसके पूरे कैरेक्टर का सटीक एक्स-रे कर रहे हैं।
            जब इंसान का मन साफ़ होता है तो वह ईश्वर के प्रकाशमयी रूपों की ओर खिंचता है जहाँ वह शांति और समाज के भले की प्रार्थना करता है।
            लेकिन जब इंसान के अंदर घमंड और स्वार्थ चरम पर होता है तो वह काले जादू या यक्षों की शरण लेता है जो उसे तुरंत भौतिक लाभ दे सकें।
            यह एक प्रकार का बिज़नेस ट्रांजेक्शन बन जाता है जहाँ राजसिक इंसान अपनी आत्मा बेचकर दुनिया का सबसे बड़ा और ताकतवर बॉस बनना चाहता है।
            तामसिक लोगों की सोच इतनी गिरी हुई होती है कि वे अंधेरे में भटकती हुई नकारात्मक ऊर्जाओं को अपना भगवान मानकर खुद को भी पतन की ओर ले जाते हैं।
            यह श्लोक प्रमाणित करता है कि आप जिस सत्ता के आगे अपना सिर झुकाते हैं वह सत्ता सीधे तौर पर आपके मानसिक स्तर का प्रमाण पत्र होती है।
            इसलिए एक साधक को यह बहुत सावधानी से चुनना चाहिए कि वह अपनी कीमती आस्था और पूजा को ब्रह्मांड की किस शक्ति के खाते में जमा कर रहा है।
        """.trimIndent(),
        english = """
            Men in the mode of absolute goodness exclusively worship the celestial demigods seeking to elevate their consciousness toward profound knowledge and brilliant light.
            Those heavily infected by the mode of passion actively worship powerful Yakshas and Rakshasas because they violently hunger for instant massive wealth and worldly dominance.
            And the tragically degraded humans existing in the dark mode of ignorance aggressively worship ghosts and malevolent spirits performing terrifying rituals in graveyards.
            The Lord is executing a flawless psychological X-Ray here identifying the exact core character of a human simply by auditing the specific entities he chooses to worship.
            When a human's internal software is clean he is magnetically drawn to the luminous forms of the Divine where he peacefully prays for spiritual evolution and global welfare.
            But when a mortal's brain is heavily corrupted by toxic arrogance and severe selfishness he seeks out dark arts and powerful demons who can instantly supply cheap material bribes.
            This religious practice degrades into a pathetic corporate transaction where the passionate human literally auctions off his eternal soul just to become a temporary earthly boss.
            The mindset of ignorant humans is so violently compromised that they hallucinate negative wandering entities as their saviors dragging themselves into a terrifying cosmic abyss.
            This spectacular verse mathematically proves that the specific altar where you choose to bow your head serves as the absolute official certificate of your current psychological degradation.
            Therefore a spiritual seeker must urgently and meticulously audit exactly which cosmic bank account he is depositing his precious faith and daily worship into.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            अशास्त्रविहितं घोरं तप्यन्ते ये तपो जनाः |
            दम्भाहङ्कारसंयुक्ताः कामरागबलान्विताः || ५ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 5 और 6 एक ही विषय पर आधारित हैं)
            जो मनुष्य शास्त्रों के निर्देशों के बिल्कुल विपरीत जाकर अपनी मर्जी से मनमानी और अत्यंत घोर तथा भयंकर तपस्या करते हैं।
            और जो लोग पूरी तरह से पाखंड अहंकार और सांसारिक कामनाओं की अंधी वासना तथा झूठी शारीरिक ताकत के घमंड से भरे होते हैं।
            भगवान यहाँ उन पाखंडी ढोंगियों का पर्दाफाश कर रहे हैं जो दुनिया को बेवकूफ बनाने के लिए बहुत ही खतरनाक और डरावने कर्मकांड करते हैं।
            कुछ लोग अपने शरीर को कांटों पर सुलाते हैं या भूखे रहकर अपनी जान जोखिम में डालते हैं लेकिन यह सब भगवान को पाने के लिए नहीं होता।
            वे यह सब केवल समाज में अपना रुतबा बढ़ाने टीवी पर आने और खुद को एक बहुत बड़ा सिद्ध बाबा साबित करने के अहंकार में करते हैं।
            शास्त्रों में कहीं भी शरीर को बेवजह टॉर्चर करने की कोई अनुमति नहीं दी गई है क्योंकि शरीर भी ईश्वर का ही दिया हुआ एक पवित्र साधन है।
            लेकिन ये अहंकारी लोग अपने झूठे ईगो को चमकाने के लिए प्रकृति के सारे नियम तोड़ देते हैं और अपनी वासनाओं के गुलाम बन जाते हैं।
            इनका सारा तप और मेहनत केवल एक पीआर स्टंट होता है जिसके पीछे काले धन और पावर की बहुत ही गहरी और गंदी भूख छिपी होती है।
            ऐसे लोग बाहर से बहुत बड़े संत दिखाई दे सकते हैं लेकिन अंदर से वे काम और क्रोध के वायरस से पूरी तरह हैक हो चुके होते हैं।
            इन ढोंगियों का अंतिम परिणाम क्या होता है यह भगवान बहुत ही डरावने शब्दों में अगले श्लोक में स्पष्ट रूप से बताएंगे।
        """.trimIndent(),
        english = """
            (Verses 5 and 6 describe a continuous theme regarding demoniac austerities)
            Those deeply misguided individuals who undergo severe and horrific austerities that are absolutely completely unauthorized by the authentic Vedic scriptures.
            And who act strictly out of massive hypocrisy false ego and are violently driven by an insatiable lust and toxic attachment to their own physical strength.
            The Lord is brutally ripping the mask off the pathetic hypocrites who execute highly dangerous and terrifying rituals solely to scam and manipulate the ignorant public.
            Certain individuals brutally torture their biological bodies by sleeping on beds of nails or violently starving themselves but absolutely none of this is executed out of love for God.
            They orchestrate these massive theatrical stunts strictly to exponentially inflate their social clout dominate television screens and arrogantly brand themselves as elite enlightened masters.
            Absolutely nowhere do the authentic scriptures authorize the useless torture of the biological vessel because the body is an incredibly sacred tool provided directly by the Supreme Creator.
            But these deeply arrogant mortals violently violate every single natural cosmic law simply to polish their bloated false ego existing as pathetic slaves to their own filthy lust.
            All their bone-crushing austerities are literally nothing but heavily funded PR stunts concealing a dark terrifying hunger for illegal wealth and absolute political dominance.
            These frauds may externally wear the spotless robes of holy saints but their internal psychological hard drives are completely hijacked and corrupted by the lethal viruses of lust and rage.
            The horrifying and absolute final cosmic destiny awaiting these theatrical hypocrites is explicitly declared by the Lord in the very next terrifying verse.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            कर्शयन्तः शरीरस्थं भूतग्राममचेतसः |
            मां चैवान्तःशरीरस्थं तान्विद्ध्यासुरनिश्चयान् || ६ ||
        """.trimIndent(),
        hindi = """
            वे मूर्ख और अज्ञानी लोग अपनी घोर तपस्या से केवल अपने शरीर के भीतर मौजूद भौतिक तत्वों और इंद्रियों को भयंकर कष्ट पहुँचाते हैं।
            और ऐसा करके वे वास्तव में अपने हृदय के भीतर विराजमान मुझ साक्षात् परमात्मा को भी बहुत गहरा दुःख और पीड़ा देते हैं।
            तुम यह पक्का जान लो कि इस प्रकार के मनमाने और हिंसक काम करने वाले सभी लोग निश्चित रूप से आसुरी और राक्षसी निश्चय वाले ही होते हैं।
            यह श्लोक शरीर को टॉर्चर करने वाले मूर्खों के लिए भगवान का सबसे कड़ा और अंतिम आदेश है जो उन्हें सीधे राक्षस की श्रेणी में डालता है।
            जब इंसान बिना किसी शास्त्र के नियम के अपने शरीर को भूखा मारता है या उसे तकलीफ देता है तो वह कोई महान काम नहीं कर रहा होता।
            वह वास्तव में उस शरीर रूपी मंदिर की दीवारों को तोड़ रहा होता है जिसे प्रकृति ने बहुत मेहनत से आत्मा के विकास के लिए बनाया है।
            और सबसे बड़ा अपराध यह है कि शरीर को कष्ट देने से सीधा कष्ट उसके अंदर बैठे हुए भगवान को पहुँचता है जो हर धड़कन को चला रहे हैं।
            जो व्यक्ति अपने ही अंदर बैठे ईश्वर का अपमान करता है वह दुनिया में कभी भी किसी का भला नहीं कर सकता क्योंकि वह अंदर से हिंसक हो चुका है।
            भगवान अर्जुन को ऐसे 'टॉक्सिक' तपस्वियों से सावधान कर रहे हैं क्योंकि उनकी नीयत में शुद्धि नहीं बल्कि केवल एक राक्षसी ज़िद होती है।
            सच्चा तप शरीर को सुखाना नहीं बल्कि मन की वासनाओं को मारना है और जो इसे नहीं समझता वह हमेशा अंधकार की ओर ही बढ़ता है।
        """.trimIndent(),
        english = """
            These completely brainless fools violently torture the material elements of their biological bodies through their severe and unauthorized austerities.
            And by executing this massive self-inflicted torture they actually inflict severe pain and horrific distress upon Me the Supreme Supersoul dwelling within their very hearts.
            You must definitively know and absolutely conclude that all such individuals engaging in these violent whims are strictly possessed of a demonic and terrifying resolve.
            This spectacular verse serves as the Lord's absolute final and most brutal condemnation of those idiotic mortals who violently torture their bodies officially classifying them as literal demons.
            When a human arrogantly starves his biological machine or inflicts useless physical pain without scriptural sanction he is absolutely not executing any form of spiritual greatness.
            He is practically actively vandalizing and destroying the sacred walls of the biological temple painstakingly engineered by Mother Nature explicitly for the soul's cosmic evolution.
            The absolute greatest cosmic crime is that torturing the physical vessel directly causes severe distress to the Supreme Lord Himself who operates the core machinery of every single heartbeat.
            A human who willfully insults and violently attacks the God residing within his own chest is mathematically incapable of doing any good for the world because his core is purely violent.
            The Lord is issuing a massive siren to Arjuna strictly warning him to avoid these toxic fake ascetics because their internal drive is fueled by sheer demonic stubbornness rather than purity.
            Authentic austerity is absolutely not about starving the biological flesh but brutally starving the mind of its toxic lust and those who fail to comprehend this plunge straight into darkness.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            आहारस्त्वपि सर्वस्य त्रिविधो भवति प्रियः |
            यज्ञस्तपस्तथा दानं तेषां भेदमिमं शृणु || ७ ||
        """.trimIndent(),
        hindi = """
            जिस प्रकार इंसानों की श्रद्धा अलग-अलग होती है उसी प्रकार सभी लोगों का प्रिय भोजन भी उनके गुणों के अनुसार तीन प्रकार का ही होता है।
            केवल भोजन ही नहीं बल्कि मनुष्यों द्वारा किए जाने वाले यज्ञ, तपस्या और दान भी प्रकृति के तीनों गुणों के कारण तीन-तीन प्रकार के होते हैं।
            अब तुम मुझसे उनके इन अलग-अलग प्रकारों और इनके बीच के गहरे वैज्ञानिक भेदों को बहुत ही ध्यानपूर्वक और विस्तार से सुनो।
            भगवान श्रीकृष्ण अब मानव जीवन की सबसे बेसिक और ज़रूरी चीज़ों का एक बहुत ही शानदार मनोवैज्ञानिक विश्लेषण शुरू कर रहे हैं।
            हम जो खाना खाते हैं वह केवल हमारे पेट को नहीं भरता बल्कि वह हमारे दिमाग के सॉफ्टवेयर और हमारी सोच को भी पूरी तरह से हैक और कंट्रोल करता है।
            एक इंसान की खाने की प्लेट को देखकर ही यह बताया जा सकता है कि उसके दिमाग में इस वक्त सत्त्व, रजस या तमस में से कौन सा गुण चल रहा है।
            इसी तरह इंसान जो दान देता है या जो पूजा करता है उसकी क्वालिटी भी उसके भीतरी कैरेक्टर के हिसाब से बदल जाती है।
            भगवान यह साबित कर रहे हैं कि दुनिया का कोई भी काम न्यूट्रल नहीं होता हर काम के पीछे एक खास प्रकार की मानसिक ऊर्जा छिपी होती है।
            यह जानकारी एक साधक के लिए अत्यंत महत्वपूर्ण है क्योंकि अपनी डाइट और अपनी आदतों को बदलकर ही वह अपनी चेतना को अपग्रेड कर सकता है।
            अर्जुन को अब उस मास्टर-क्लास के लिए तैयार किया जा रहा है जहाँ भोजन और कर्मों का सीधा संबंध आत्मा की मुक्ति से जोड़ा जाएगा।
        """.trimIndent(),
        english = """
            Just as human faith diverges so too the specific food that is heavily preferred by all people is scientifically divided into exactly three distinct categories based on their modes.
            Furthermore the various sacrifices they perform the austerities they undergo and the charity they distribute are also strictly categorized into three specific types.
            Now please listen with absolute, undivided attention as I systematically explain the profound scientific distinctions and exact differences between all of them.
            Lord Sri Krishna is now initiating an absolutely spectacular and deeply psychological analysis of the most fundamental biological and spiritual necessities of human existence.
            The physical food we consume does not merely fuel our biological stomach; it directly heavily hacks into our psychological software actively regulating and controlling our daily thoughts.
            A highly trained observer can flawlessly audit a human's exact mental state and active cosmic mode simply by clinically analyzing the specific items piled on his dinner plate.
            Similarly the massive charities a human funds or the intense rituals he performs drastically fluctuate in quality strictly depending on the core internal character driving his brain.
            The Lord is mathematically proving that absolutely zero human action is ever neutral; every single deed is heavily fueled by a specific hidden frequency of mental energy.
            This highly classified data is incredibly critical for an elite seeker because aggressively upgrading his biological diet and daily habits is the only way to elevate his consciousness.
            Arjuna is being meticulously prepared for the ultimate master-class where the direct, unbreakable correlation between physical food and eternal spiritual liberation will be perfectly decoded.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            आयुःसत्त्वबलारोग्यसुखप्रीतिविवर्धनाः |
            रस्याः स्निग्धाः स्थिरा हृद्या आहारा सात्त्विकप्रियाः || ८ ||
        """.trimIndent(),
        hindi = """
            जो भोजन मनुष्य की आयु (उम्र), बुद्धि, शारीरिक बल, स्वास्थ्य, सुख और आपसी प्रेम को बहुत अधिक बढ़ाने वाला होता है।
            जो भोजन अत्यंत रसीला, चिकना (स्निग्ध), शरीर में लंबे समय तक टिकने वाला और हृदय को बहुत ही अच्छा लगने वाला होता है।
            इस प्रकार के अत्यंत शुद्ध और प्राकृतिक भोजन सात्त्विक प्रवृत्ति वाले मनुष्यों को सबसे अधिक प्रिय होते हैं।
            यह श्लोक एक परफेक्ट और सबसे हेल्दी 'सात्त्विक डाइट' (Sattvic Diet) का दुनिया का सबसे बेहतरीन और साइंटिफिक प्रिस्क्रिप्शन है।
            सात्त्विक खाना वह नहीं है जो केवल स्वाद दे बल्कि वह भोजन एक 'मेडिसिन' की तरह काम करता है जो आपके पूरे नर्वस सिस्टम को शांत और मजबूत बनाता है।
            इसमें ताज़े फल, दूध, मक्खन, हरी सब्जियां और प्राकृतिक अनाज शामिल होते हैं जिनमें कोई भी भयंकर केमिकल या अशुद्धि नहीं होती।
            यह भोजन खाने के बाद इंसान को आलस नहीं आता बल्कि उसका दिमाग एकदम क्लियर और फोकस के साथ काम करने के लिए चार्ज हो जाता है।
            यह खाना शरीर के अंदर जाकर बहुत आराम से पचता है और इंसान की इम्यूनिटी और उम्र को नेचुरल तरीके से लंबा कर देता है।
            जो लोग अपनी आत्मा को शुद्ध रखना चाहते हैं और ध्यान में गहराई तक जाना चाहते हैं उनके लिए यह सात्त्विक भोजन एक रॉकेट-फ्यूल की तरह है।
            जैसा अन्न वैसा मन—यह कहावत इसी श्लोक से निकली है जो साबित करती है कि आपकी प्लेट की शुद्धता ही आपके विचारों की पवित्रता तय करती है।
        """.trimIndent(),
        english = """
            Foods that actively significantly increase the biological lifespan purify the existence and exponentially boost physical strength health happiness and deep satisfaction.
            Meals that are naturally highly juicy pleasantly fatty and extremely wholesome and that deeply comfort and stabilize the human heart and psychology.
            These specific types of intensely pure and natural foods are unequivocally the absolute favorite and highly preferred diet of persons situated in the mode of goodness.
            This spectacular verse provides the world's absolute best and most flawless scientific prescription for generating the ultimate elite 'Sattvic Diet' required for human optimization.
            Sattvic food is absolutely not consumed merely for cheap tongue stimulation; it operates precisely like high-grade medicine flawlessly calming and fortifying the entire nervous system.
            This premium diet incorporates fresh fruits raw milk natural butter and organic vegetables that are completely devoid of any toxic artificial chemicals or brutal biological impurities.
            Upon consuming this specific fuel a human absolutely never experiences a toxic sugar crash or lethargy; instead his brain instantly charges up with crystal-clear titanium focus.
            This incredibly clean food digests effortlessly inside the biological machine actively supercharging the immune system and naturally expanding the organism's overall expiration date.
            For elite seekers desperately trying to purify their eternal souls and dive deep into cosmic meditation this Sattvic fuel acts exactly like premium high-octane rocket propellant.
            The legendary proverb "You are what you eat" perfectly originates from this verse proving mathematically that the pristine purity of your dinner plate strictly dictates the purity of your thoughts.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            कट्वम्ललवणात्युष्णतीक्ष्णरूक्षविदाहिनः |
            आहारा राजसस्येष्टा दुःखशोकामयप्रदाः || ९ ||
        """.trimIndent(),
        hindi = """
            जो भोजन बहुत ज़्यादा कड़वा, खट्टा, बहुत ज़्यादा नमक वाला, अत्यंत गर्म, तीखा, रूखा और सीने में भयंकर जलन पैदा करने वाला होता है।
            इस प्रकार का अत्यंत उग्र और मसालेदार भोजन उन लोगों को बहुत अधिक पसंद आता है जिनका स्वभाव पूरी तरह से राजसिक होता है।
            यह खाना इंसान को स्वाद तो देता है लेकिन अंत में यह केवल भारी दुःख, मानसिक शोक और कई प्रकार की भयानक बीमारियां ही पैदा करता है।
            यह श्लोक आज के 'जंक फूड' और 'अल्ट्रा-प्रोसेस्ड डाइट' का एक बहुत ही सटीक और भयानक एक्स-रे है जो इंसान को अंदर से बर्बाद कर रहा है।
            राजसिक इंसान का दिमाग हमेशा स्ट्रेस और हड़बड़ी में रहता है इसलिए वह अपने खाने में भी बहुत ज्यादा मसाला और किक (Kick) ढूँढता है।
            वह ऐसा खाना खाता है जो उसकी जीभ को तो तुरंत जला दे लेकिन वह भूल जाता है कि यही खाना उसके पेट और आँतों को भी बुरी तरह जला रहा है।
            ज्यादा नमक और मिर्च वाला यह खाना इंसान के ब्लड प्रेशर को बढ़ा देता है और उसके दिमाग को और भी ज्यादा एग्रेसिव और चिड़चिड़ा बना देता है।
            इस खाने से इंसान की बॉडी में भयंकर एसिडिटी और बीमारियां (आमय) पैदा होती हैं जो बाद में उसके लिए बहुत बड़े दुख और अस्पताल के बिल का कारण बनती हैं।
            भगवान चेतावनी दे रहे हैं कि जीभ के दो मिनट के झूठे सुख के लिए अपने पूरे शरीर के सिस्टम को आग में झोंक देना सबसे बड़ी मूर्खता है।
            अगर आप अपने मन को शांत और फोकस रखना चाहते हैं तो आपको इस राजसिक ज़हर से खुद को तुरंत और पूरी तरह से दूर कर लेना चाहिए।
        """.trimIndent(),
        english = """
            Foods that are violently too bitter excessively sour exceedingly salty devastatingly hot highly pungent completely dry and fiercely burning to the internal system.
            These intensely aggressive and heavily spiced types of consumables are the absolute favorite and highly desired choice of persons deeply infected by the mode of passion.
            While these toxic meals may briefly stimulate the tongue their ultimate mathematical consequence is strictly the generation of massive distress deep misery and horrific biological diseases.
            This phenomenal verse acts as a flawless and terrifying X-Ray perfectly diagnosing the absolute catastrophic reality of modern toxic junk food and ultra-processed diets destroying humanity.
            A passionate human's brain is perpetually locked in a state of high-speed stress and panic therefore he constantly desperately hunts for an extreme spicy 'Kick' to stimulate his deadened taste buds.
            He aggressively consumes toxic items that violently burn his tongue completely ignoring the horrific biological reality that this exact acidic fuel is ruthlessly incinerating his internal organs.
            This heavy overload of sodium and intense spice violently spikes his biological blood pressure immediately transforming his psychological state into a highly aggressive irritable and restless nightmare.
            Consuming this toxic garbage mathematically guarantees the manifestation of severe internal acidity and chronic lethal diseases that ultimately generate massive physical grief and horrific hospital bills.
            The Lord issues a brutal warning declaring that sacrificing the entire internal biological system purely for two minutes of cheap tongue stimulation is the absolute peak of human stupidity.
            If you seriously desire to maintain a calm titanium-focused brain you must urgently and violently permanently banish this radioactive Rajasic poison from your daily biological intake.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            यातयामं गतरसं पूति पर्युषितं च यत् |
            उच्छिष्टमपि चामेध्यं भोजनं तामसप्रियम् || १० ||
        """.trimIndent(),
        hindi = """
            जो भोजन पकने के बाद बहुत देर तक रखा रहा हो (बासी), जिसका सारा प्राकृतिक रस और स्वाद पूरी तरह से सूख या खत्म हो चुका हो।
            जो भोजन दुर्गंध देने वाला हो, सड़ा हुआ हो, दूसरों का जूठा हो और जो पवित्रता के नज़रिए से बिल्कुल भी खाने लायक (अमेध्य) न हो।
            इस प्रकार का अत्यंत गंदा और दूषित भोजन उन लोगों को बहुत ज्यादा पसंद आता है जो पूरी तरह से तमोगुण के गहरे अंधेरे में डूबे होते हैं।
            यह श्लोक इंसान की सबसे गिरी हुई और 'ज़ोंबी' (Zombie) जैसी खाने की आदतों का एक बहुत ही कड़वा और घिनौना सच दुनिया के सामने रखता है।
            तमोगुणी इंसान इतना आलसी और अज्ञानी होता है कि उसे ताज़ा और शुद्ध खाना पकाने या खाने में बिल्कुल भी कोई दिलचस्पी नहीं होती।
            वह सड़ा-गला, कई दिनों का रखा हुआ बासी खाना, या मरे हुए जानवरों का मांस खाने में ही अपना सबसे बड़ा झूठा आनंद महसूस करता है।
            यह खाना शरीर को कोई भी ऊर्जा या विटामिन नहीं देता बल्कि यह इंसान के पूरे नर्वस सिस्टम को धीमा करके उसे भयंकर डिप्रेशन और नींद की ओर धकेलता है।
            दूसरों का जूठा या गंदी जगहों पर बना हुआ खाना इंसान की चेतना को पूरी तरह करप्ट कर देता है और उसकी सोचने-समझने की शक्ति को मार डालता है।
            ऐसा ज़हरीला भोजन खाने वाला व्यक्ति अध्यात्म या ज्ञान की बातें तो दूर, एक सामान्य और स्वस्थ इंसान की तरह जीवन भी नहीं जी सकता।
            भगवान स्पष्ट आदेश देते हैं कि जो इंसान अपने शरीर को कचरे का डिब्बा बना लेता है उसका मन भी हमेशा के लिए एक सड़ा हुआ गटर ही बन जाता है।
        """.trimIndent(),
        english = """
            Food that is cooked more than three hours before being eaten which is completely tasteless entirely dry and absolutely devoid of all its natural essential juices.
            Food that is highly putrid smelling foul consisting of decomposed rotting leftovers or things that are completely impure and biologically unfit for human consumption.
            These intensely toxic filthy and heavily contaminated types of consumables are the absolute favorite diet of people completely submerged in the darkest mode of ignorance.
            This spectacular verse violently exposes the absolute most degraded disgusting and literal 'Zombie-like' dietary habits heavily practiced by the lowest fractions of human society.
            A human paralyzed by Tamas is so horrifically lazy and deeply ignorant that he possesses absolutely zero motivation to prepare or consume fresh highly nutritious organic meals.
            He actually derives a sick pathetic joy from consuming heavily decomposed stale garbage heavily processed junk or the rotting dead flesh of slaughtered animals.
            This lethal diet provides absolutely zero vital energy or biological vitamins; instead it ruthlessly slows down the entire nervous system forcefully plunging the human into massive depression and chronic sleep.
            Consuming heavily contaminated leftovers or food prepared in filthy unhygienic environments completely corrupts a person's consciousness violently assassinating his fundamental cognitive logic and basic intelligence.
            An entity casually running their biological machine on this toxic poison is mathematically disqualified from grasping advanced spirituality and cannot even function as a healthy normal human being.
            The Lord issues an uncompromising decree warning that any human who transforms his physical body into a rotting trash can mathematically guarantees his mind will permanently mutate into a toxic sewer.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            अफलाकाङ्क्षिभिर्यज्ञो विधिदृष्टो य इज्यते |
            यष्टव्यमेवेति मनः समाधाय स सात्त्विकः || ११ ||
        """.trimIndent(),
        hindi = """
            जो यज्ञ शास्त्रों में बताए गए नियमों और विधियों के अनुसार बिल्कुल सही और प्रामाणिक तरीके से पूरे सम्मान के साथ किया जाता है।
            और जिसे करने वाले के मन में भविष्य के किसी भी फल या फायदे की कोई स्वार्थी इच्छा या लालच बिल्कुल भी नहीं होता है।
            बल्कि वह अपने मन में यह पक्का संकल्प करके यज्ञ करता है कि यह मेरा परम कर्तव्य है और मुझे इसे केवल ईश्वर के लिए करना ही चाहिए।
            इस प्रकार की अत्यंत शुद्ध और निष्काम भावना से किया जाने वाला यज्ञ ही वास्तव में 'सात्त्विक यज्ञ' कहलाता है।
            भगवान यहाँ पूजा और धर्म के सबसे ऊँचे और सबसे पवित्र 'गोल्ड स्टैंडर्ड' (Gold Standard) को पूरी दुनिया के सामने स्थापित कर रहे हैं।
            आजकल ज़्यादातर लोग मंदिर जाते हैं तो भगवान के सामने अपनी डिमाडंस (Demands) की एक बहुत लंबी लिस्ट रख देते हैं कि मुझे नौकरी दे दो या पैसा दे दो।
            लेकिन एक सात्त्विक इंसान भगवान के साथ कोई बिज़नेस डील (Business Deal) नहीं करता; वह पूजा केवल इसलिए करता है क्योंकि वह भगवान से सच्चा प्यार करता है।
            वह शास्त्रों की पूरी रिस्पेक्ट करता है और पूजा के दौरान शॉर्टकट नहीं मारता क्योंकि उसका सारा फोकस केवल भगवान को खुश करने पर होता है।
            इस प्रकार के यज्ञ में अहंकार जीरो होता है और इंसान का दिल एक दम साफ शीशे की तरह चमकता है जिसमें कोई स्वार्थ नहीं होता।
            भगवान कहते हैं कि केवल ऐसी ही निष्काम पूजा सीधे मेरे हृदय तक पहुँचती है और इंसान को आध्यात्मिक दुनिया में हमेशा के लिए अमर बना देती है।
        """.trimIndent(),
        english = """
            Of all the various massive sacrifices that specific sacrifice performed strictly according to the precise flawless directions of the authorized scriptures is the best.
            This elite ritual is executed entirely by humans who completely lack any toxic selfish desire for a future material reward or cheap physical benefit.
            Instead they aggressively focus their minds with absolute titanium conviction believing firmly that executing this sacrifice is their mandatory duty and it simply must be done.
            A sacrifice performed with such an unbelievably pure unmotivated and heavily disciplined mindset is officially categorized as being in the absolute mode of goodness.
            The Lord is officially establishing the absolute ultimate 'Gold Standard' of religious worship and pure spiritual execution for the entire multiverse to witness.
            In the modern matrix the vast majority of ignorant humans visit temples merely to present God with a massive pathetic list of demands begging for cheap promotions or quick cash.
            But an elite Sattvic human absolutely refuses to treat the Supreme Creator like a cosmic vending machine; he executes his worship strictly out of pure unadulterated explosive love.
            He possesses massive respect for scriptural laws and absolutely never takes cheap shortcuts during his rituals because his entire laser-focus is completely locked on satisfying God alone.
            In this specific type of high-level sacrifice the human's toxic false ego is mathematically reduced to zero and his heart shines exactly like a flawless mirror completely devoid of any selfish agenda.
            The Lord emphatically declares that only this specific unmotivated selfless devotion directly penetrates His heart and successfully guarantees the soul's eternal immortality in the spiritual sky.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            अभिसन्धाय तु फलं दम्भार्थमपि चैव यत् |
            इज्यते भरतश्रेष्ठ तं यज्ञं विद्धि राजसम् || १२ ||
        """.trimIndent(),
        hindi = """
            परंतु हे भरतवंशियों में श्रेष्ठ अर्जुन! जो यज्ञ केवल किसी विशेष फल या फायदे की गहरी लालसा को मन में रखकर बहुत ही स्वार्थ के साथ किया जाता है।
            और जिसे केवल दुनिया के सामने अपना पाखंड दिखाने, अपना नाम चमकाने और अपने झूठे अहंकार को संतुष्ट करने के लिए किया जाता है।
            तुम यह पक्का समझ लो कि इस प्रकार की दिखावे और स्वार्थ से भरी हुई पूजा को ही वास्तव में 'राजसिक यज्ञ' कहा जाता है।
            यह श्लोक दुनिया के उन घमंडी और अमीर लोगों का बहुत ही कड़वा सच बताता है जो धर्म का इस्तेमाल केवल अपना पीआर (PR) बढ़ाने के लिए करते हैं।
            वे लोग करोड़ों रुपए खर्च करके बहुत बड़े-बड़े धार्मिक इवेंट्स (Events) करवाते हैं लेकिन उनका असली मकसद भगवान को खुश करना बिल्कुल नहीं होता।
            उनके दिमाग में एक ही कैलकुलेशन चल रही होती है कि इस पूजा से मेरा व्यापार कितना बढ़ेगा और समाज में लोग मुझे कितना बड़ा दानी मानेंगे।
            वे भगवान की मूर्ति के सामने हाथ तो जोड़ते हैं लेकिन उनका पूरा ध्यान कैमरों और न्यूज़पेपर की हेडलाइंस पर टिका रहता है।
            यह कोई सच्ची पूजा नहीं है बल्कि यह एक बहुत ही घटिया स्तर का 'कमर्शियल ट्रांजेक्शन' (Commercial Transaction) है जहाँ वे भगवान को भी रिश्वत देने की कोशिश कर रहे हैं।
            भगवान बहुत साफ शब्दों में अर्जुन को चेतावनी देते हैं कि जहाँ पाखंड (दम्भ) और फल का लालच होता है वहाँ मेरी कोई उपस्थिति नहीं होती।
            इस प्रकार के राजसिक कर्म इंसान को कभी शांति या मोक्ष नहीं देते बल्कि वे उसे इस दुनिया के झूठे दिखावे और स्ट्रेस के जाल में और भी बुरी तरह फँसा देते हैं।
        """.trimIndent(),
        english = """
            But O absolute best of the Bharatas Arjuna you must clearly know that the specific sacrifice performed solely for the sake of acquiring some material benefit or temporary reward.
            And which is heavily executed with massive theatrical hypocrisy purely to boastfully flaunt one's own false prestige and arrogant pride before the entire society.
            You must definitively understand and clinically conclude that this highly corrupted ego-driven type of worship is officially situated strictly in the mode of passion.
            This spectacular verse violently exposes the absolute bitter truth regarding those arrogant billionaires and toxic politicians who hijack religion strictly to aggressively boost their own PR.
            They willingly burn millions of dollars hosting massive spectacular religious events but their internal psychological software has absolutely zero intention of genuinely pleasing the Supreme Lord.
            Their overheated brains are continuously running a pathetic calculation desperate to figure out exactly how much corporate profit and fake social adoration they will successfully extract from this ritual.
            They may physically fold their hands before the sacred deity but their entire corrupted focus remains permanently glued to the flashing cameras and the front-page newspaper headlines.
            This is absolutely not authentic worship; it is a shockingly degraded toxic 'Commercial Transaction' where an arrogant mortal pathetically attempts to legally bribe the Creator of the multiverse.
            The Lord issues a crystal-clear brutal warning to Arjuna establishing that wherever toxic hypocrisy and massive greedy expectations exist the Supreme Godhead completely withdraws His presence.
            These passionate ego-driven rituals mathematically fail to grant a human any genuine peace or liberation; they merely violently entangle him deeper into the stressful suffocating web of the material matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            विधिहीनमसृष्टान्नं मन्त्रहीनमदक्षिणम् |
            श्रद्धाविरहितं यज्ञं तामसं परिचक्षते || १३ ||
        """.trimIndent(),
        hindi = """
            जो यज्ञ शास्त्रों में बताई गई किसी भी सही विधि और नियम के बिना अपनी पूरी मनमानी और घोर अज्ञानता के साथ किया जाता है।
            जिसमें न तो किसी को अन्न (प्रसाद) बांटा जाता है, न ही किसी पवित्र वैदिक मंत्र का सही उच्चारण किया जाता है, और न ही ब्राह्मणों को कोई दक्षिणा दी जाती है।
            और जो सबसे महत्वपूर्ण बात है कि जिस पूजा में इंसान के दिल में भगवान के लिए ज़रा सी भी सच्ची 'श्रद्धा' या विश्वास बिल्कुल नहीं होता है।
            इस प्रकार के पूरी तरह से अशुद्ध, स्वार्थी और खोखले कर्मकांड को ही सभी विद्वान 'तामसिक यज्ञ' कहकर पुकारते हैं।
            यह श्लोक 'करप्ट और फेक स्पिरिचुअलिटी' (Fake Spirituality) का सबसे निचले दर्जे का और सबसे भयानक रूप दुनिया के सामने रखता है।
            तमोगुणी इंसान इतना आलसी और घमंडी होता है कि वह भगवान की पूजा में भी शॉर्टकट मारता है और किसी भी नियम को मानने से साफ़ इंकार कर देता है।
            वह पूजा केवल समाज के डर से या किसी तांत्रिक टोने-टोटके के लिए करता है जिसमें उसका इकलौता मकसद केवल अपना कोई गंदा काम निकलवाना होता है।
            वह न तो गरीबों को खाना खिलाता है और न ही उन गुरुओं का सम्मान करता है जो उसे ज्ञान दे रहे हैं, वह बस अपना पैसा बचाने में लगा रहता है।
            बिना 'श्रद्धा' (Faith) के किया गया कोई भी काम एक बिना इंजन वाली कार की तरह है जो इंसान को ज़िंदगी में कहीं भी आगे नहीं ले जा सकता।
            भगवान श्रीकृष्ण ऐसे तामसिक अनुष्ठानों को पूरी तरह से 'कचरा' (Garbage) और जीरो मानते हैं क्योंकि इनमें इंसान की चेतना सबसे अधिक प्रदूषित और अंधी हो चुकी होती है।
        """.trimIndent(),
        english = """
            Any massive sacrifice performed completely devoid of absolutely all scriptural directions in total defiance of all authorized cosmic rules and sacred systemic regulations.
            In which absolutely no spiritual food is generously distributed to the public no authentic Vedic hymns are chanted and no respectful remunerations are given to the officiating priests.
            And most critically any ritual that is executed entirely without even a microscopic drop of genuine faith pure devotion or sincere belief residing within the heart.
            This highly corrupted utterly hollow and toxically selfish type of degraded ritualistic performance is officially universally considered to be in the darkest mode of ignorance.
            This spectacular verse brutally unmasks the absolute lowest most horrific and highly degraded version of 'Fake Spirituality' currently operating within the dark corners of the matrix.
            A human completely paralyzed by ignorance is so terrifyingly arrogant and lazy that he aggressively takes cheap shortcuts in worship refusing to submit to any established divine protocol.
            He executes these pathetic rituals strictly out of societal fear or for executing toxic black magic where his exclusive goal is merely to selfishly manipulate dark forces for cheap gains.
            He violently refuses to feed the starving poor and heavily disrespects the authentic gurus offering him wisdom remaining completely obsessed with maliciously hoarding his own pathetic wealth.
            Any physical action performed without the core engine of titanium 'Faith' is biologically exactly like a luxury car without an engine; it is mathematically guaranteed to take you nowhere.
            Lord Sri Krishna officially categorizes all such ignorant rituals as absolute toxic 'Garbage' evaluating their cosmic worth as zero because the human consciousness here is completely polluted and utterly blind.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            देवद्विजगुरुप्राज्ञपूजनं शौचमार्जवम् |
            ब्रह्मचर्यमहिंसा च शारीरं तप उच्यते || १४ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 14 से 16 तक शरीर, वाणी और मन की तीन प्रकार की तपस्याओं का वर्णन है)
            ईश्वर, सच्चे ब्राह्मणों, अपने आध्यात्मिक गुरुओं और महान ज्ञानी पुरुषों का पूरे मन और आदर के साथ सम्मान और पूजन करना।
            अपने शरीर को रोज़ाना पानी से साफ़ रखना (शौच), अपने व्यवहार में बिना किसी कपट के पूरी तरह से सरलता और सीधापन (आर्जव) बनाए रखना।
            अपने जीवन में पवित्रता बनाए रखने के लिए पूर्ण रूप से ब्रह्मचर्य का कठोरता से पालन करना और किसी भी प्राणी को कभी भी कोई शारीरिक कष्ट न देना (अहिंसा)।
            इन सभी अत्यंत पवित्र और अनुशासित कार्यों को ही वास्तव में शरीर संबंधी यानी 'शारीरिक तपस्या' (शारीरं तप) कहा जाता है।
            जब लोग 'तपस्या' शब्द सुनते हैं तो वे सोचते हैं कि हिमालय में जाकर बर्फ पर नंगे पैर खड़े होना ही तपस्या है, लेकिन भगवान इस गलतफहमी को तोड़ते हैं।
            भगवान कहते हैं कि तपस्या का मतलब शरीर को बिना वजह टॉर्चर (Torture) करना नहीं है, बल्कि अपने शरीर को समाज और ईश्वर के लिए एक 'परफेक्ट टूल' (Perfect Tool) बनाना है।
            अपने बड़ों और गुरुओं के सामने अहंकार को झुकाना इस शरीर की सबसे बड़ी ट्रेनिंग है जो इंसान को अंदर से बहुत ज़्यादा मज़बूत बनाती है।
            ब्रह्मचर्य का मतलब अपनी ऊर्जा को गंदी वासनाओं में बर्बाद करने के बजाय उसे बचाकर अपने लक्ष्य और ईश्वर की तरफ मोड़ना है।
            और अहिंसा यह साबित करती है कि आपके शरीर की ताकत दूसरों को डराने के लिए नहीं बल्कि पूरी दुनिया को प्यार और सुरक्षा देने के लिए है।
            यही वह असली 'फिजिकल फिटनेस' (Physical Fitness) और डिसिप्लिन है जो एक साधारण इंसान को एक महान योगी के स्तर तक उठा देती है।
        """.trimIndent(),
        english = """
            (Verses 14 to 16 describe the three specific disciplines of body, speech, and mind)
            Offering absolute profound reverence and flawless worship to the Supreme Lord the pure brahmanas the authentic spiritual master and highly elevated wise superiors.
            Maintaining immaculate external cleanliness of the biological vessel (Shaucha) and executing unadulterated simplicity and absolute straightforwardness (Arjavam) in all physical behavior without any toxic hypocrisy.
            Aggressively practicing strict celibacy (Brahmacharya) to conserve vital biological energy and observing total nonviolence (Ahimsa) ensuring absolutely no physical harm is inflicted upon any living entity.
            All these highly disciplined exceptionally pure and incredibly rigorous biological practices are officially together categorized as the absolute austerity of the body (Shariram Tapa).
            When ignorant mortals hear the heavy term 'Austerity' they foolishly hallucinate standing barefoot on freezing Himalayan glaciers but the Supreme Lord violently shatters this toxic misconception here.
            The Lord mathematically clarifies that genuine austerity is absolutely NOT about needlessly torturing biological flesh; it is about aggressively upgrading the body into a 'Flawless Tool' serving society and God.
            Forcefully bending your toxic false ego before elevated masters and superiors is the absolute greatest biological training heavily fortifying a human's internal psychological resilience.
            Brahmacharya explicitly demands that a human completely stop leaking his precious vital energy into filthy cheap lust actively redirecting that massive explosive power straight toward cosmic realization.
            And practicing strict nonviolence mathematically proves that your physical brute strength is engineered to aggressively protect the innocent universe absolutely not to terrorize it.
            This is the ultimate authentic definition of true 'Physical Fitness' and biological discipline that effortlessly elevates an ordinary mortal into the ranks of the most elite cosmic yogis.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            अनुद्वेगकरं वाक्यं सत्यं प्रियहितं च यत् |
            स्वाध्यायाभ्यसनं चैव वाङ्मयं तप उच्यते || १५ ||
        """.trimIndent(),
        hindi = """
            वह शब्द या वाणी जो किसी दूसरे इंसान के मन में ज़रा सा भी उद्वेग, घबराहट या दुःख पैदा न करे बल्कि उसे पूरी तरह से शांति प्रदान करे।
            जो बात 100% सत्य और सच्ची हो, लेकिन उसे बोलने का तरीका इतना मीठा (प्रिय) और दूसरों का भला (हित) करने वाला हो कि वह किसी को चुभे नहीं।
            और अपने मुख से नियमित रूप से पवित्र वेदों और शास्त्रों का निरंतर पाठ करना तथा भगवान के नामों का अभ्यास करते रहना।
            वाणी के इस अत्यंत कठोर लेकिन मीठे और संतुलित अनुशासन को ही वास्तव में वाणी संबंधी यानी 'वाचिक तपस्या' (वाङ्मयं तप) कहा जाता है।
            यह श्लोक 'द आर्ट ऑफ कम्युनिकेशन' (The Art of Communication) का दुनिया का सबसे परफेक्ट और सबसे शक्तिशाली मास्टर-क्लास है।
            इंसान की जीभ में इतनी भयंकर ताकत होती है कि वह अपने एक गलत शब्द से दुनिया में आग लगा सकता है और एक मीठे शब्द से किसी की जान बचा सकता है।
            भगवान कहते हैं कि सच बोलना बहुत ज़रूरी है, लेकिन अगर तुम्हारा सच किसी को भयंकर चोट पहुँचा रहा है, तो वह सच एक हथियार बन जाता है।
            इसलिए एक ज्ञानी इंसान अपने शब्दों को किसी फिल्टर (Filter) की तरह इस्तेमाल करता है; वह केवल वही बोलता है जो 'सच्चा' भी हो, 'मीठा' भी हो और 'फायदेमंद' भी हो।
            और जब वह दुनिया से बात नहीं कर रहा होता, तो वह अपनी जीभ का इस्तेमाल फालतू की गॉसिप (Gossip) करने के बजाय केवल ईश्वर के पवित्र मंत्र पढ़ने में करता है।
            अपनी ज़ुबान पर ऐसा मिलिट्री-ग्रेड (Military-grade) कंट्रोल रखना ही दुनिया की सबसे बड़ी और सबसे मुश्किल तपस्या मानी गई है।
        """.trimIndent(),
        english = """
            Speaking words that are exceptionally truthful highly pleasing extremely beneficial and that absolutely never cause any microscopic distress agitation or terrifying anxiety to the minds of others.
            And regularly meticulously engaging in the continuous daily recitation of the authorized Vedic literature and fiercely chanting the holy names of the Supreme Lord.
            This incredibly strict yet profoundly beautiful and highly balanced regulation of the vocal cords is officially declared by the Lord to be the absolute austerity of speech (Vangmayam Tapa).
            This spectacular verse functions as the absolute ultimate 'Master-Class' in the high-level psychological 'Art of Communication' delivering the perfect blueprint for vocal discipline.
            A human's biological tongue possesses the terrifying catastrophic power to either violently ignite a global war with a single toxic insult or literally save a suicidal soul with a soothing word.
            The Lord aggressively mandates that speaking the unadulterated truth is non-negotiable but if your brutal truth violently crushes another human's heart it tragically mutates into a lethal biological weapon.
            Therefore an elite wise sage forcefully operates his vocal cords through a strict triple-filter: he ensures his words are mathematically 'True' beautifully 'Sweet' and exceptionally 'Beneficial' simultaneously.
            And whenever he is not actively communicating with the matrix he absolutely refuses to waste his precious biological breath on cheap toxic gossip exclusively utilizing it to chant sacred cosmic mantras.
            Executing this flawless titanium-grade lockdown on one's own wildly unpredictable tongue is officially recognized as one of the absolute most difficult and supreme austerities in the entire multiverse.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            मनः प्रसादः सौम्यत्वं मौनमात्मविनिग्रहः |
            भावसंशुद्धिरित्येतत्तपो मानसमुच्यते || १६ ||
        """.trimIndent(),
        hindi = """
            अपने मन को हमेशा अत्यंत शांत, प्रसन्न और हर प्रकार की फालतू की चिंताओं से पूरी तरह मुक्त (प्रसाद) रखना एक ज्ञानी का लक्षण है।
            दूसरों के प्रति स्वभाव में गहरी कोमलता (सौम्यत्व) बनाए रखना और मन को हमेशा चुप (मौन) रखकर उसे फालतू के ख्यालों से बचाना।
            अपनी इच्छाओं और विचारों पर एक आर्मी-कमांडो की तरह बहुत कड़ा और मजबूत नियंत्रण (आत्मविनिग्रह) स्थापित करना।
            और अपने हृदय के सभी भावों को किसी भी प्रकार के कपट और स्वार्थ से पूरी तरह साफ और पवित्र (भावसंशुद्धि) रखना।
            मन की इन सभी अत्यंत उच्च और शक्तिशाली अवस्थाओं को ही वास्तव में मन संबंधी यानी 'मानसिक तपस्या' (मानसं तप) कहा जाता है।
            शारीरिक और वाचिक तपस्या से भी करोड़ों गुना ज्यादा मुश्किल यह 'दिमाग की तपस्या' है क्योंकि मन हवा से भी ज्यादा चंचल और खतरनाक है।
            हम बाहर से तो चुप रह सकते हैं लेकिन हमारे दिमाग के अंदर 24 घंटे एक भयंकर शोर और विचारों का युद्ध चलता रहता है जिसे शांत करना सबसे ज़रूरी है।
            इसलिए भगवान कहते हैं कि असली 'मौन' वो है जब आपके दिमाग के अंदर भी कोई फालतू विचार या लालच की आवाज़ न गूंजे।
            जब इंसान का मन एक ठहरे हुए साफ तालाब की तरह बिल्कुल शांत और पवित्र हो जाता है, तभी उसे ईश्वर की असली झलक दिखाई देती है।
            अपने ही दिमाग को हैक (Hack) करके उसे अपना सबसे बड़ा दोस्त बना लेना ही दुनिया की सबसे महान और अंतिम तपस्या मानी गई है।
        """.trimIndent(),
        english = """
            Maintaining profound unshakeable satisfaction extreme simplicity and a deeply calming serenity of the mind (Prasadah) remaining completely free from all toxic psychological anxieties.
            Fostering a gentle nature strictly maintaining absolute internal gravity and silence (Mauna) to forcefully protect the brain from absorbing any useless external garbage or toxic thoughts.
            Executing a brutal military-grade lockdown and absolute titanium self-control over one's erratic desires ensuring the mind operates completely under the strict command of the intellect (Atma-vinigrahah).
            And achieving the flawless complete purification of one's entire existence keeping all internal emotions totally devoid of any selfish agenda or microscopic deception (Bhava-samshuddhir).
            This spectacular highly elevated and completely regulated state of consciousness is officially universally declared to be the absolute austerity of the mind (Manasam Tapa).
            This specific 'Mental Austerity' is mathematically billions of times more terrifyingly difficult to execute than mere physical discipline because the biological mind is infinitely more volatile and dangerous than a hurricane.
            We can easily forcefully shut our physical mouths but deep inside our skulls a violent deafening war of millions of toxic thoughts aggressively rages 24/7 which must be violently silenced.
            Therefore the Lord drops a profound truth: Authentic 'Silence' (Mauna) is achieved strictly when the internal dialogue of greed and lust completely flatlines within your brain resulting in zero background noise.
            Only when the human mind becomes as flawlessly still and transparent as a perfectly frozen crystal lake does the soul finally catch the unadulterated blinding reflection of the Supreme Godhead.
            Successfully hacking your own rogue psychological software and forcefully upgrading your brain into your absolute best friend is universally recognized as the ultimate supreme austerity of existence.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            श्रद्धया परया तप्तं तपस्तत्त्रिविधं नरैः |
            अफलाकाङ्क्षिभिर्युक्तैः सात्त्विकं परिचक्षते || १७ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 17 से 19 तक इन तपस्याओं का तीन गुणों में विभाजन बताया गया है)
            जब शरीर, वाणी और मन की यह तीनों प्रकार की तपस्याएं किसी मनुष्य द्वारा अत्यंत गहरी और परम 'श्रद्धा' के साथ की जाती हैं।
            और उन तपस्याओं को करने वाले योगियों के मन में भविष्य के किसी भी भौतिक फल या स्वार्थी फायदे की रत्ती भर भी कोई इच्छा नहीं होती है।
            वे अपने मन को पूरी तरह से ईश्वर में एकाग्र करके (युक्त) केवल अपने कर्तव्य और आत्म-शुद्धि के लिए ही इस कठोर तप को सहते हैं।
            तो इस प्रकार की 100% शुद्ध और बिना किसी लालच के की गई महान तपस्या को ही सभी ज्ञानी लोग 'सात्त्विक तपस्या' कहकर पुकारते हैं।
            भगवान यहाँ बता रहे हैं कि केवल तपस्या करना काफी नहीं है; उस तपस्या के पीछे आपकी 'नीयत' (Intention) कैसी है, वह सबसे ज्यादा मायने रखती है।
            अगर कोई इंसान समाज की भलाई के लिए बहुत मेहनत कर रहा है, लेकिन अंदर से वह सोचता है कि "मुझे इसके बदले बड़ा अवार्ड मिलेगा," तो वह तपस्या सात्त्विक नहीं है।
            सात्त्विक इंसान की साइकोलॉजी (Psychology) बहुत साफ होती है: वह तपस्या इसलिए करता है क्योंकि उसे भगवान से प्यार है और वह खुद को बेहतर बनाना चाहता है।
            वह अपनी सारी मेहनत का फल एक गिफ्ट (Gift) की तरह भगवान के चरणों में बिना किसी शर्त के रख देता है और पूरी तरह टेंशन-फ्री हो जाता है।
            इस प्रकार का सात्त्विक तप इंसान के अहंकार को पूरी तरह से जलाकर राख कर देता है और उसे ईश्वरीय आनंद की सबसे ऊँची चोटी पर ले जाता है।
            यही वह असली तपस्या है जो आत्मा को सीधे उस परमेश्वर से कनेक्ट (Connect) करने का काम करती है।
        """.trimIndent(),
        english = """
            (Verses 17 through 19 meticulously categorize these austerities according to the three specific modes of nature)
            When this highly rigorous threefold austerity of the body mind and speech is fiercely executed by a human being with absolute supreme and titanium faith.
            And those elite yogis performing these severe disciplines harbor absolutely zero microscopic drops of toxic selfish desire for any future material reward or cheap physical benefit.
            They aggressively lock their focused consciousness entirely onto the Supreme Lord undergoing these brutal penances purely for their own internal purification and out of a supreme sense of duty.
            This incredibly pure unmotivated and heavily disciplined execution of extreme penance is officially universally categorized by wise sages as austerity in the absolute mode of goodness (Sattvic).
            The Lord is explicitly demonstrating that merely executing severe mechanical torture is completely irrelevant; the absolute core 'Intention' driving your psychology behind the austerity is what God meticulously audits.
            If a human sweats blood executing massive social welfare but secretly aggressively hallucinates inside his brain "I will legally extract a massive global award for this," his austerity is instantly disqualified from being Sattvic.
            The pristine psychology of a Sattvic human is flawlessly clear: he embraces severe brutal discipline solely because he possesses explosive love for God and deeply desires to upgrade his own eternal character.
            He flawlessly takes the entire massive result of his grueling hard work and unconditionally drops it exactly like a beautiful wrapped gift directly at the lotus feet of the Lord becoming completely anxiety-free.
            This specific high-level Sattvic austerity operates exactly like a raging cosmic fire violently incinerating the human's bloated false ego into ash and launching him to the supreme peak of divine ecstasy.
            This is the absolute only authentic form of austerity mathematically guaranteed to establish a direct unbreakable high-speed fiber-optic connection between the tiny soul and the Supreme Creator.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            सत्कारमानपूजार्थं तपो दम्भेन चैव यत् |
            क्रियते तदिह प्रोक्तं राजसं चलमध्रुवम् || १८ ||
        """.trimIndent(),
        hindi = """
            जो तपस्या केवल समाज में अपना बहुत बड़ा सत्कार (सम्मान) करवाने, लोगों से अपनी पूजा करवाने और झूठा नाम कमाने के घोर स्वार्थ के लिए की जाती है।
            और जिसे करने के पीछे इंसान के दिल में कोई सच्ची श्रद्धा नहीं होती बल्कि वह केवल एक पाखंड (दम्भ) और एक बहुत बड़े दिखावे के रूप में की जाती है।
            तुम यह पक्का समझ लो कि इस प्रकार की अत्यधिक स्वार्थी और घमंड से भरी हुई तपस्या को ही शास्त्रों में 'राजसिक तपस्या' कहा गया है।
            ऐसी तपस्या का जो फल या रिज़ल्ट होता है वह बहुत ही अस्थिर (चल) होता है और उसका असर बहुत ही कम समय के लिए (अध्रुवम्) टिकता है।
            यह श्लोक आज के युग के उन 'फेक गुरुओं' (Fake Gurus) और नेताओं का सबसे बड़ा एक्स-रे है जो कैमरे के सामने समाज सेवा या तपस्या का नाटक करते हैं।
            वे लोग भूख हड़ताल करते हैं या बहुत बड़े-बड़े यज्ञ करते हैं, लेकिन उनका असली टारगेट (Target) भगवान नहीं, बल्कि न्यूज़-चैनल और लोगों की तालियां बटोरना होता है।
            उनके मन में 24 घंटे यही कैलकुलेशन चलती है कि "इस काम से मेरी फैन-फॉलोइंग (Fan-following) कितनी बढ़ेगी और मैं दुनिया का कितना बड़ा वीआईपी (VIP) बनूंगा।"
            भगवान कहते हैं कि यह कोई आध्यात्मिक काम नहीं है, बल्कि यह एक बहुत ही घटिया दर्जे का 'पीआर स्टंट' (PR Stunt) है जिसकी आध्यात्मिक दुनिया में कीमत ज़ीरो है।
            ऐसी राजसिक तपस्या से इंसान को कुछ समय के लिए दुनिया का झूठा सम्मान तो मिल सकता है, लेकिन मौत के समय यह सारा दिखावा ताश के पत्तों की तरह ढह जाता है।
            जहाँ अहंकार और दिखावे की एंट्री होती है, वहाँ से ईश्वर और शांति तुरंत बाहर निकल जाते हैं; यह ब्रह्मांड का सबसे पक्का नियम है।
        """.trimIndent(),
        english = """
            That specific austerity which is aggressively and selfishly performed strictly for the sake of extracting massive worldly respect extracting fake honor and demanding blind worship from the ignorant masses.
            And which is entirely executed with severe theatrical hypocrisy (Dambha) completely devoid of even a microscopic drop of genuine faith purely to falsely showcase oneself as an elite saint.
            You must definitively understand and clinically conclude that this highly corrupted ego-driven exhibition of fake discipline is officially declared to be austerity strictly in the mode of passion (Rajasic).
            The ultimate cosmic results and temporary material rewards generated by this toxic passionate austerity are extremely unstable (Chalam) flickering and absolutely mathematically nonpermanent (Adhruvam).
            This spectacular verse violently rips the mask off the modern 'Fake Gurus' and corrupt politicians who aggressively orchestrate massive theatrical stunts of public service or fasting strictly for rolling cameras.
            They willingly undergo severe hunger strikes or heavily fund billion-dollar sacrifices but their actual internal target is absolutely not the Supreme God; it is aggressively hoarding newspaper headlines and massive public applause.
            Their overheated brains are continuously running a pathetic calculation desperate to figure out exactly how much their social media fan-following will exponentially multiply transforming them into global VIPs.
            The Lord explicitly declares that this is absolutely not authentic spiritual work; it is literally nothing but a remarkably degraded highly toxic 'PR Stunt' possessing mathematically zero value in the spiritual dimension.
            Through this Rajasic austerity a human might successfully scam society into handing him temporary fake prestige but at the exact microsecond of his death this entire illusion violently collapses like a pathetic house of cards.
            The exact microsecond toxic arrogance and theatrical showmanship enter a human's biological heart the Supreme Lord and absolute peace instantly exit; this is an unbreakable unyielding cosmic law.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            मूढग्राहेणात्मनो यत्पीडया क्रियते तपः |
            परस्योत्सादनार्थं वा तत्तामसमुदाहृतम् || १९ ||
        """.trimIndent(),
        hindi = """
            जो तपस्या अत्यंत मूर्खतापूर्ण और अंधी ज़िद (मूढग्राहेण) के कारण बिना किसी शास्त्र के नियम को जाने केवल अपने अज्ञान के आधार पर की जाती है।
            जिस तपस्या में मनुष्य अपने ही शरीर और आत्मा को भयंकर और जानलेवा पीड़ा (कष्ट) देकर खुद को अकारण टॉर्चर करता है।
            या फिर जो तपस्या केवल दूसरों को बर्बाद करने, उनका विनाश करने (उत्सादनार्थं) या किसी को भयंकर नुकसान पहुँचाने के काले उद्देश्य से की जाती है।
            इस प्रकार की अत्यंत क्रूर, भयानक और विनाशकारी तपस्या को ही वास्तव में 'तामसिक तपस्या' कहा जाता है।
            यह श्लोक काले जादू (Black Magic), आतंकवाद और उन खौफनाक प्रथाओं का पर्दाफाश करता है जहाँ इंसान अपने दिमाग का संतुलन पूरी तरह खो चुका होता है।
            राक्षस जैसे रावण या हिरण्यकशिपु ने भी बहुत भयंकर तपस्या की थी, लेकिन उनकी तपस्या भगवान से प्यार के लिए नहीं, बल्कि दुनिया पर कब्ज़ा करने और दूसरों को मारने के लिए थी।
            कुछ मूर्ख लोग भगवान को खुश करने के नाम पर अपने अंगों को काटते हैं या जानवरों की बलि देते हैं, जो कि भगवान की नजर में एक बहुत बड़ा और घिनौना अपराध है।
            भगवान स्पष्ट करते हैं कि जो तपस्या हिंसा (Violence) से पैदा हुई है और जिसका मकसद ही दूसरों का खून बहाना है, वह सीधे नर्क का दरवाज़ा खोलती है।
            ऐसी तामसिक तपस्या करने वाला व्यक्ति अपने भीतर के इंसान को पूरी तरह से मार देता है और एक खूंखार राक्षस की तरह व्यवहार करने लगता है।
            ईश्वर ऐसी अंधी और क्रूर तपस्या को कभी स्वीकार नहीं करते, बल्कि ऐसे लोगों को प्रकृति के सबसे कठोर नियमों के तहत भयंकर सज़ा दी जाती है।
        """.trimIndent(),
        english = """
            That specific horrifying austerity which is executed out of extreme sheer foolishness and blind toxic stubbornness (Mudha-grahena) completely defying all rational scriptural logic and basic common sense.
            In which a deeply deluded human intentionally inflicts severe life-threatening torture and brutal agonizing pain upon his own biological body and soul strictly through his own massive ignorance.
            Or that highly lethal penance which is aggressively performed with the singular dark and catastrophic objective of violently destroying causing massive harm or brutally annihilating others (Utsadanartham).
            This specific extremely cruel terrifying and highly destructive type of demonic penance is officially and universally categorized as austerity in the darkest mode of ignorance (Tamasic).
            This spectacular verse violently exposes the absolute darkest corners of black magic terrorism and horrific cult rituals where a human's psychological software has completely and violently crashed into absolute madness.
            Legendary cosmic terrorists like Ravana and Hiranyakashipu executed unimaginably severe austerities but their brutal penance was absolutely not fueled by pure love for God; it was engineered explicitly to conquer the multiverse and slaughter the innocent.
            Some pathetically foolish mortals actively mutilate their own biological organs or ruthlessly slaughter innocent animals falsely hallucinating they are pleasing God which the Supreme Creator officially registers as an abominable cosmic crime.
            The Lord explicitly clarifies that any austerity mathematically rooted in extreme 'Violence' and heavily designed strictly to shed the blood of others instantly violently rips open the absolute darkest gates of hell.
            An entity executing such Tamasic torture completely permanently assassinates the remaining traces of his own humanity mutating entirely into a bloodthirsty apex predator completely devoid of any spiritual light.
            The Supreme Godhead absolutely never accepts such blind cruel torture; instead these toxic entities are ruthlessly processed by the universe's most brutal natural laws and handed terrifying apocalyptic punishments.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            दातव्यमिति यद्दानं दीयतेऽनुपकारिणे |
            देशे काले च पात्रे च तद्दानं सात्त्विकं स्मृतम् || २० ||
        """.trimIndent(),
        hindi = """
            (श्लोक 20 से 22 तक दान के तीन प्रकार बताए गए हैं)
            "दान देना मेरा परम कर्तव्य है"—केवल इसी अत्यंत शुद्ध और निस्वार्थ भावना से जो दान बिना किसी उपकार की वापसी की उम्मीद के दिया जाता है (अनुपकारिणे)।
            और जो दान बिल्कुल सही और पवित्र स्थान (देशे) पर, बिल्कुल सही और शुभ समय (काले) पर, और एक अत्यंत योग्य तथा ज़रूरतमंद व्यक्ति (पात्रे) को दिया जाता है।
            उस प्रकार के 100% शुद्ध और बिना किसी स्वार्थ या लालच के किए गए महान दान को ही वास्तव में 'सात्त्विक दान' माना गया है।
            भगवान श्रीकृष्ण यहाँ चैरिटी (Charity) या दान करने का सबसे साइंटिफिक और 'गोल्ड स्टैंडर्ड' (Gold Standard) फॉर्मूला दुनिया को दे रहे हैं।
            सात्त्विक इंसान जब किसी गरीब की मदद करता है तो वह कोई बिज़नेस डील (Business Deal) नहीं कर रहा होता; उसे बदले में 'थैंक्यू' (Thank You) या कोई फेवर (Favor) नहीं चाहिए होता।
            वह इसे अपना एक धर्म मानता है और दान देने के बाद उसे पूरी तरह से भूल जाता है, वह उसका कोई अहंकार या घमंड नहीं पालता।
            लेकिन भगवान एक बहुत बड़ी शर्त लगाते हैं: दान अंधा होकर नहीं देना चाहिए! आपको 'देश, काल और पात्र' का कड़ा कैलकुलेशन (Calculation) करना ही होगा।
            सही समय पर, सही जगह पर, और उसी इंसान को दान देना चाहिए जो वास्तव में भूखा है या जो उस पैसे का इस्तेमाल अच्छे काम (जैसे शिक्षा या इलाज) में करेगा।
            अगर आप किसी शराबी को पैसा देते हैं जो उस पैसे से शराब पीकर हिंसा करेगा, तो आपका वह दान सात्त्विक नहीं बल्कि पाप बन जाता है।
            सही नीयत और सही रिसर्च (Research) के साथ किया गया सात्त्विक दान ही इंसान के कर्मों को धोकर उसे ईश्वर के सबसे करीब ले जाता है।
        """.trimIndent(),
        english = """
            (Verses 20 through 22 flawlessly categorize the three specific modes of Charity)
            That exact charity which is distributed purely out of an absolute titanium conviction that "It is my mandatory duty to give" completely totally devoid of any toxic expectation of receiving anything in return (Anupakarine).
            And which is meticulously handed over at a perfectly sanctified and proper place (Deshe) at an exact highly auspicious and appropriate time (Kale) and given strictly to a highly qualified and genuinely needy recipient (Patre).
            That specific 100% unadulterated unmotivated and brilliantly calculated execution of massive philanthropy is officially universally remembered and categorized as charity in the mode of goodness (Sattvic).
            Lord Sri Krishna is downloading the absolute ultimate highly scientific 'Gold Standard' formula for executing flawless cosmic philanthropy directly into human consciousness here.
            When an elite Sattvic human aggressively helps a starving beggar he is absolutely not executing a cheap corporate 'Business Deal'; he demands zero "Thank You" cards and expects absolutely zero future favors in return.
            He scientifically recognizes this act as his fundamental cosmic duty and the exact microsecond the transaction is complete he completely deletes it from his memory refusing to nourish any bloated false ego.
            But the Supreme Lord attaches a massive iron-clad condition: Charity must absolutely NEVER be distributed blindly! A human must aggressively execute a strict, rigorous calculation auditing the 'Place, Time, and Recipient'.
            Wealth must be transferred strictly at the right moment in the right environment exclusively to an entity who is genuinely starving or who will utilize the funds strictly for noble purposes like high-level education or medical survival.
            If you foolishly hand over cash to a heavily intoxicated addict who subsequently utilizes those funds to purchase more poison and commit violence your blind charity instantly mutates into a horrific cosmic sin.
            Only Sattvic charity heavily backed by a pure intention and razor-sharp meticulous research successfully incinerates a human's toxic karma seamlessly elevating his consciousness into the absolute proximity of the Divine.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            यत्तु प्रत्युपकारार्थं फलमुद्दिश्य वा पुनः |
            दीयते च परिक्लिष्टं तद्दानं राजसं स्मृतम् || २१ ||
        """.trimIndent(),
        hindi = """
            परंतु जो दान किसी पुराने एहसान का बदला चुकाने के लिए या भविष्य में उस व्यक्ति से कोई बड़ा काम निकलवाने (प्रत्युपकारार्थं) की स्वार्थी नीयत से दिया जाता है।
            या फिर जो दान किसी बहुत बड़े भौतिक फल (जैसे स्वर्ग, नाम, या भारी मुनाफे) की लालसा को अपने मन में रखकर बहुत ही कैलकुलेटिव तरीके से दिया जाता है।
            और जिस दान को देते समय इंसान के दिल में बहुत ही कंजूसी हो और वह पैसा देते हुए अंदर ही अंदर बहुत अधिक दुखी या रो रहा हो (परिक्लिष्टं)।
            तुम यह पक्का समझ लो कि इस प्रकार के स्वार्थ, व्यापार और भारी दिल से किए गए दान को ही शास्त्रों में 'राजसिक दान' कहा गया है।
            यह श्लोक आज के कॉर्पोरेट वर्ल्ड (Corporate World) और राजनीति के उस 'फेक चैरिटी' (Fake Charity) मॉडल का बिल्कुल सीधा और कड़वा पर्दाफाश है।
            यहाँ इंसान दान नहीं दे रहा है, बल्कि वह एक 'इन्वेस्टमेंट' (Investment) कर रहा है; वह 100 रुपए देकर भगवान या समाज से 1000 रुपए वापस खींचने की उम्मीद लगा कर बैठा है।
            वह मंदिर में या किसी एनजीओ (NGO) को भारी डोनेशन (Donation) देता है ताकि उसे टैक्स (Tax) में छूट मिल सके या उसका कोई गैरकानूनी काम आसानी से पास हो जाए।
            और जब उसे वह पैसा अपनी जेब से निकालना पड़ता है, तो वह खुशी से नहीं देता, बल्कि उसका दिल दर्द से रो रहा होता है कि "मेरा इतना पैसा बर्बाद हो गया।"
            भगवान कहते हैं कि जिस दान के पीछे इतना भयंकर लालच, स्वार्थ और दर्द छिपा हो, वह दान कभी भी पवित्र या ईश्वरीय नहीं हो सकता।
            ऐसी राजसिक चैरिटी से इंसान का अहंकार और स्ट्रेस (Stress) ही बढ़ता है; इससे न तो समाज का कोई असली भला होता है और न ही इंसान को आध्यात्मिक शांति मिलती है।
        """.trimIndent(),
        english = """
            But that specific charity which is highly aggressively distributed strictly with the toxic expectation of receiving a massive return favor or a strategic future benefit in exchange (Pratyupakarartham).
            Or which is heavily funded and meticulously calculated purely with a desperate burning desire to extract some massive fruitive material result like heavenly elevation or extreme social clout (Phalam uddishya).
            And which is given very grudgingly with a tight fist where the arrogant donor violently internally suffers and cries in deep agonizing pain while parting with his precious cash (Pariklishtam).
            You must definitively understand and conclude that this highly corrupted corporate and ego-driven type of philanthropy is officially known as charity in the mode of passion (Rajasic).
            This spectacular verse brutally rips the mask off the modern toxic 'Fake Charity' business model heavily utilized by greedy politicians and arrogant corporate elites.
            The human operating in this mode is absolutely not executing genuine charity; he is strictly executing a highly calculated 'Financial Investment', throwing a hundred dollars purely to mathematically extract a thousand dollars back from God or society.
            He actively aggressively pumps massive billion-dollar donations into NGOs or temples strictly to legally bypass heavy government taxation or to rapidly lubricate the approval of his illegal offshore projects.
            And the exact microsecond he is physically forced to transfer that wealth his greedy heart does not rejoice; instead it violently bleeds and cries in sheer biological agony screaming "My precious money is wasted!"
            The Supreme Lord explicitly decrees that any charity heavily polluted with such an extreme density of toxic greed selfishness and internal agony can absolutely never be classified as holy or divine.
            This pathetic Rajasic philanthropy mathematically fails to grant the human any authentic spiritual peace; it merely exponentially inflates his bloated ego and violently tangles him deeper into the stressful matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            अदेशकाले यद्दानमपात्रेभ्यश्च दीयते |
            असत्कृतमवज्ञातं तत्तामसमुदाहृतम् || २२ ||
        """.trimIndent(),
        hindi = """
            जो दान बिल्कुल ही अपवित्र और गलत स्थान (अदेश) पर, बहुत ही गलत और अशुभ समय (अकाले) पर, और ऐसे लोगों को दिया जाता है जो उस दान के बिल्कुल भी योग्य नहीं होते (अपात्रेभ्यः)।
            और जिस दान को देते समय लेने वाले का कोई भी सत्कार (सम्मान) नहीं किया जाता, बल्कि बहुत ही तिरस्कार, घमंड और बेइज़्जती (अवज्ञातं) के साथ उसे पैसा फेंक कर दिया जाता है।
            इस प्रकार के अत्यंत घिनौने, बिना किसी सोच-समझ के और अपमानजनक तरीके से किए गए दान को ही 'तामसिक दान' (Tamasic Charity) कहा गया है।
            भगवान यहाँ दान के उस सबसे निचले और सड़े हुए स्तर का वर्णन कर रहे हैं जो पुण्य के बजाय इंसान के लिए भयंकर पाप का कारण बन जाता है।
            अगर कोई इंसान किसी जुआघर या शराब के ठेके (गलत स्थान) पर जाकर अपना पैसा लुटाता है, तो वह कोई दान नहीं बल्कि अपनी ही बर्बादी कर रहा है।
            अगर आप किसी अपराधी, शराबी या आतंकवादी (अपात्र) को पैसे या मदद देते हैं, तो उसके द्वारा किए गए हर जुर्म और पाप के आप भी सीधे तौर पर हिस्सेदार बन जाते हैं।
            और सबसे बड़ी बात, अगर आप किसी भूखे या गरीब को खाना देते हैं लेकिन उसे गालियां देकर या उसका मज़ाक उड़ाकर ज़मीन पर खाना फेंकते हैं, तो वह दान ज़हर के समान है।
            दान का मतलब केवल पैसा देना नहीं है, बल्कि सामने वाले इंसान की इज़्ज़त और उसकी आत्मा का पूरा सम्मान करना दान की पहली शर्त है।
            ईश्वर ऐसे तामसिक दान को 100% रिजेक्ट कर देते हैं क्योंकि इसमें इंसान की अंधी मूर्खता और उसका राक्षसी अहंकार साफ दिखाई देता है।
            जो व्यक्ति बिना अपनी बुद्धि का इस्तेमाल किए इस तरह का गंदा दान करता है, वह मोक्ष की बजाय सीधे नर्क के सबसे गहरे और अंधेरे हिस्से की ओर जाता है।
        """.trimIndent(),
        english = """
            That specific charity which is blindly and idiotically distributed at a completely impure horrific and unauthorized place (Adesha) at a highly inauspicious and totally wrong time (Akale).
            And which is heavily funded directly into the hands of utterly unworthy toxic and dangerous persons who have absolutely zero qualification to receive such wealth (Apatrebhyah).
            And which is arrogantly given without paying even a microscopic drop of respect or proper attention to the receiver but is instead aggressively thrown at them with extreme contempt and brutal insult (Avajnatam).
            This incredibly disgusting completely brainless and highly offensive type of philanthropy is officially and universally categorized as charity in the darkest mode of ignorance (Tamasic).
            The Lord is clinically exposing the absolute lowest most rotting and degraded level of human charity which mathematically generates massive horrific sin instead of any pious merit.
            If a human blindly squanders his wealth inside a toxic casino or a filthy bar (the wrong place) he is absolutely not executing philanthropy; he is actively aggressively financing his own catastrophic ruin.
            If you foolishly hand over heavy cash or biological resources to a violent criminal a severe addict or a cosmic terrorist (unworthy recipient) you automatically legally become a direct co-conspirator in every single horrific crime they subsequently execute.
            And most critically if you throw food at a starving beggar but simultaneously hurl toxic verbal abuse and violently crush his human dignity that so-called charity instantly mutates into lethal biological poison.
            Authentic charity is absolutely not merely the mechanical transfer of paper money; the absolute primary prerequisite is treating the receiving soul with profound unshakeable cosmic respect and deep honor.
            The Supreme Godhead mathematically rejects 100% of such Tamasic charity assigning it absolute zero value because it explicitly showcases the human's blinding idiocy and terrifying demonic arrogance.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            ॐ तत्सदिति निर्देशो ब्रह्मणस्त्रिविधः स्मृतः |
            ब्राह्मणास्तेन वेदाश्च यज्ञाश्च विहिताः पुरा || २३ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 23 से 28 तक 'ॐ तत् सत्' के परम रहस्य का वर्णन है)
            'ॐ', 'तत्', और 'सत्'—ये तीन अत्यंत पवित्र शब्द उस सर्वोच्च और निराकार परब्रह्म (परमेश्वर) को पुकारने और उसे याद करने के सबसे मुख्य नाम या संकेत (निर्देश) माने गए हैं।
            सृष्टि की शुरुआत में (पुरा) इन्हीं तीनों महान शब्दों के उच्चारण के द्वारा ही सच्चे ब्राह्मणों, चारों वेदों और सभी प्रकार के बड़े-बड़े यज्ञों का निर्माण (विहिताः) किया गया था।
            भगवान श्रीकृष्ण यहाँ ब्रह्मांड के सबसे शक्तिशाली और सबसे पुराने 'पासवर्ड' (Master Password) या 'सीक्रेट कोड' (Secret Code) का पर्दाफाश कर रहे हैं!
            जब कोई इंसान सात्त्विक तरीके से कोई पूजा या दान करता है, तो भी इंसान होने के नाते उससे कोई न कोई छोटी-मोटी गलती या कमी रह ही जाती है।
            उस कमी को 100% परफेक्ट (Perfect) बनाने और उसे सीधे भगवान के सर्वर (Server) तक पहुँचाने के लिए इस 'ॐ तत् सत्' मंत्र का इस्तेमाल किया जाता है।
            यह कोई साधारण शब्द नहीं है; यह ब्रह्मांड के क्रिएशन (Creation) का 'सोर्स कोड' (Source Code) है, जिससे पूरी दुनिया और ज्ञान (वेद) बाहर निकले हैं।
            'ॐ' भगवान का सुप्रीम और यूनिवर्सल (Universal) साउंड है। 'तत्' का मतलब है 'वह' (यानी सब कुछ ईश्वर का है, मेरा नहीं)। और 'सत्' का मतलब है 'सच्चाई' (यानी जो हमेशा रहने वाला है)।
            जब इन तीनों शब्दों को मिला दिया जाता है, तो यह एक ऐसा भयंकर शक्तिशाली मंत्र बन जाता है जो किसी भी अधूरे या टूटे हुए काम को पूरी तरह से ईश्वरीय और शुद्ध बना देता है।
            भगवान अर्जुन को समझा रहे हैं कि बिना इस ईश्वरीय मोहर (Stamp) के दुनिया का कोई भी धार्मिक काम या तपस्या कभी भी पूरी नहीं मानी जा सकती।
            इस मंत्र का सही इस्तेमाल ही इंसान को माया के मैट्रिक्स (Matrix) से निकालकर सीधा उस 'परम ब्रह्म' (The Ultimate Truth) से जोड़ देता है।
        """.trimIndent(),
        english = """
            (Verses 23 through 28 explicitly decode the ultimate supreme mystery of 'Om Tat Sat')
            The three highly sacred transcendental syllables 'Om', 'Tat', and 'Sat' are officially and universally remembered as the supreme symbolic representation and the absolute names of the Supreme Absolute Truth (Brahman).
            At the exact dawn of cosmic creation in the ancient past (Pura) these exact three terrifyingly powerful words were utilized by the Supreme to flawlessly engineer the brahmanas the massive Vedas and all major sacrifices.
            Lord Sri Krishna is actively declassifying and exposing the universe's absolute most terrifyingly powerful and ancient 'Master Password' or 'Cosmic Source Code' right here!
            When a human attempts to execute a flawlessly pure Sattvic ritual or charity his fragile biological nature guarantees that some microscopic flaw or tiny mistake will inevitably occur during the process.
            To scientifically patch that flaw rendering the ritual 100% mathematically perfect and ensuring it securely uploads directly into God's ultimate server the seeker must deploy this specific 'Om Tat Sat' mantra.
            This is absolutely not a set of ordinary random earthly syllables; it is the literal acoustic 'Source Code' of cosmic genesis from which the entire physical multiverse and all advanced knowledge (Vedas) violently exploded.
            'Om' is the absolute supreme universal sound vibration of God. 'Tat' translates to 'That' (signifying that absolutely everything belongs to God not my toxic ego). And 'Sat' translates to 'Truth' (the indestructible eternal reality).
            When these three highly reactive syllables are fused together they form an exponentially powerful sonic weapon that instantly purifies and heavily sanctifies any incomplete or broken human endeavor.
            The Lord is rigorously explaining to Arjuna that without aggressively stamping this specific divine cosmic seal upon an action absolutely no religious duty or severe austerity can ever be officially validated.
            The correct flawless deployment of this specific mantra acts as the ultimate fiber-optic cable instantly bypassing the material matrix and plugging the tiny soul directly into the 'Param Brahman' (The Absolute Truth).
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            तस्मादोमित्युदाहृत्य यज्ञदानतपःक्रियाः |
            प्रवर्तन्ते विधानोक्ताः सततं ब्रह्मवादिनाम् || २४ ||
        """.trimIndent(),
        hindi = """
            इसलिए जो लोग वेदों को जानने वाले और परमेश्वर को चाहने वाले महान साधक (ब्रह्मवादिनाम्) होते हैं, वे अपने जीवन का कोई भी पवित्र काम कभी भी सीधे शुरू नहीं करते।
            वे हमेशा सबसे पहले 'ॐ' (OM) इस परम शक्तिशाली शब्द का ज़ोर से उच्चारण करके ही (ओमित्युदाहृत्य) शास्त्रों में बताए गए यज्ञ, दान और तपस्या जैसे सभी कार्यों की शुरुआत (प्रवर्तन्ते) करते हैं।
            भगवान यहाँ 'ॐ' (OM) शब्द के प्रैक्टिकल इस्तेमाल (Practical Application) का सबसे सटीक और साइंटिफिक तरीका बता रहे हैं।
            'ॐ' इस पूरे ब्रह्मांड का 'स्टार्टिंग इग्निशन' (Starting Ignition / चाबी) है। जैसे किसी सुपरकार (Supercar) को चलाने से पहले इंजन को स्टार्ट करना पड़ता है, वैसे ही किसी भी आध्यात्मिक काम का इंजन 'ॐ' है।
            जब कोई ज्ञानी इंसान कोई बड़ा दान देने जाता है या कोई बहुत कठिन तपस्या शुरू करता है, तो उसका ईगो (Ego) उसे भटका सकता है कि "मैं यह महान काम कर रहा हूँ।"
            लेकिन जैसे ही वह अपने होंठों से 'ॐ' का उच्चारण करता है, उसका दिमाग तुरंत ईश्वर के सर्वर से कनेक्ट (Connect) हो जाता है और उसका सारा अहंकार ज़ीरो हो जाता है।
            'ॐ' बोलने का मतलब है ब्रह्मांड के उस सुप्रीम बॉस को याद करना और उसे यह बताना कि "हे प्रभु! मैं यह जो भी काम शुरू कर रहा हूँ, यह केवल आपकी शक्ति और आपकी ही मर्ज़ी से हो रहा है।"
            यह केवल एक ध्वनि (Sound) नहीं है, यह एक ऐसा 'प्रोटेक्टिव शील्ड' (Protective Shield) है जो आपके द्वारा किए गए यज्ञ या दान को राक्षसी (रजोगुण या तमोगुण) शक्तियों के हमले से पूरी तरह सुरक्षित रखता है।
            इसलिए सनातन धर्म में हर मंत्र और हर पूजा की शुरुआत अनिवार्य रूप से 'ॐ' लगाकर ही की जाती है क्योंकि इसके बिना कोई भी काम एक्टिवेट (Activate) नहीं होता।
            भगवान अर्जुन को यह अनुशासन सिखा रहे हैं कि जीवन का हर काम उस परम शक्ति के नाम की मोहर लगाकर ही किया जाना चाहिए।
        """.trimIndent(),
        english = """
            Therefore the highly elevated transcendentalists and the elite knowers of the Supreme Brahman (Brahma-vadinam) absolutely never randomly initiate any sacred activity without proper protocol.
            They always meticulously and loudly chant the supreme transcendental syllable 'Om' first (Om ity udahritya) before aggressively initiating and performing any scripturally authorized sacrifices charities or severe austerities.
            The Lord is explicitly delivering the absolute most precise and scientific methodology for the 'Practical Application' of the terrifyingly powerful syllable 'Om'.
            'Om' serves as the absolute 'Starting Ignition' (the universal key) for the entire cosmic matrix. Just as a driver must violently ignite the engine before launching a hypercar 'Om' is the required ignition for any spiritual endeavor.
            When an elite sage attempts to distribute massive charity or undergo brutal physical penance his biological false ego might aggressively attempt to hijack his brain whispering "I am executing this greatness."
            But the exact microsecond he vibrates the syllable 'Om' through his vocal cords his internal psychological software instantly connects to God's massive server violently crashing and resetting his toxic ego back to zero.
            Chanting 'Om' is a strict official declaration to the Supreme Boss of the universe acknowledging "O Lord! Every single physical action I am about to launch is heavily powered entirely by Your energy and Your direct sanction."
            This is absolutely not merely a basic acoustic sound; it operates exactly like a high-tech 'Protective Titanium Shield' that flawlessly defends the ongoing sacrifice or charity from being violently hacked by demonic (Rajasic or Tamasic) forces.
            This is exactly why in the eternal Sanatana Dharma every single complex mantra and massive ritual is mandatorily initiated strictly with 'Om', because without this specific sonic trigger the cosmic software simply refuses to activate.
            The Lord is aggressively training Arjuna in the ultimate spiritual discipline demanding that every single action in a human's timeline must be officially stamped and authorized by the name of the Supreme Power.
        """.trimIndent()
    ),
    Shloka(
        id = 25,
        sanskrit = """
            तदित्यनभिसन्धाय फलं यज्ञतपःक्रियाः |
            दानक्रियाश्च विविधाः क्रियन्ते मोक्षकाङ्क्षिभिः || २५ ||
        """.trimIndent(),
        hindi = """
            इसके बाद 'तत्' (TAT) इस परम शब्द का उच्चारण किया जाता है। मोक्ष की गहरी इच्छा रखने वाले (मोक्षकाङ्क्षिभिः) और सांसारिक बंधनों से छूटने की चाहत रखने वाले महापुरुष इसी शब्द का प्रयोग करते हैं।
            वे लोग भविष्य में मिलने वाले किसी भी प्रकार के फल (जैसे स्वर्ग या पैसा) की रत्ती भर भी इच्छा या लालच रखे बिना (अनभिसन्धाय फलम्) इस शब्द को बोलते हैं।
            और इस 'तत्' शब्द के साथ ही वे विभिन्न प्रकार के बड़े-बड़े यज्ञ, कठोर तपस्याएं और कई प्रकार के महान दान (दानक्रियाश्च विविधाः) जैसे पवित्र कार्य करते हैं।
            भगवान अब 'तत्' (TAT) शब्द का रहस्य खोल रहे हैं जो मोक्ष पाने वालों का सबसे बड़ा और गुप्त हथियार है।
            'तत्' का सीधा सा मतलब है 'वह' (That) यानी 'यह सब कुछ उस परमेश्वर का ही है, इसमें मेरा कुछ भी नहीं है।'
            जब इंसान कोई बहुत बड़ा और महान काम (यज्ञ या दान) कर लेता है, तो उसके दिल में एक बहुत ही सूक्ष्म और खतरनाक ईगो (Ego) आ सकता है कि "मैंने इतना पैसा दान में दिया।"
            यह ईगो उस इंसान को वापस इसी दुनिया में खींच लाएगा। लेकिन जैसे ही वह 'तत्' बोलता है, वह अपने दिमाग को एक ज़बरदस्त 'रिमाइंडर' (Reminder) देता है।
            वह कहता है: "मैंने यह जो भी करोड़ों का दान दिया है या जो भी तपस्या की है, मुझे इसके बदले न तो समाज से कोई नाम चाहिए और न ही भगवान से स्वर्ग चाहिए; यह सब 'तत्' (ईश्वर) के लिए है।"
            यह 'तत्' शब्द इंसान के द्वारा किए गए सारे अच्छे कर्मों के भारी 'क्रेडिट' (Credit) को इंसान के अकाउंट (Account) से हटाकर सीधा भगवान के अकाउंट में ट्रांसफर (Transfer) कर देता है।
            और जब इंसान का अपना कर्मा-अकाउंट (Karma-account) पूरी तरह ज़ीरो (Zero) हो जाता है, तभी उसे इस 3D मैट्रिक्स से हमेशा के लिए असली आज़ादी यानी 'मोक्ष' प्राप्त होता है।
        """.trimIndent(),
        english = """
            Following this the highly elevated transcendentalists strictly vibrate the supreme syllable 'Tat'. This specific sound is aggressively utilized exclusively by those elite entities who desperately hunger for ultimate liberation (Moksha-kankshibhih) from material entanglement.
            They meticulously utter this exact word while completely and violently renouncing even a microscopic drop of toxic desire or greedy expectation for any future fruitive results or cheap heavenly rewards (Anabhisandhaya phalam).
            And heavily armed with the power of this 'Tat' syllable they flawlessly execute various kinds of massively complex sacrifices brutal austerities and diverse forms of highly extensive charity (Dana-kriyash cha vividhah).
            The Lord is now explicitly declassifying the terrifying secret behind the syllable 'Tat' which acts as the absolute greatest stealth weapon for those targeting complete cosmic liberation.
            The term 'Tat' translates directly to 'That' (the Supreme) profoundly symbolizing the titanium conviction that "Absolutely everything in this matrix belongs exclusively to God; my pathetic biological ego owns mathematically nothing."
            When a human successfully completes a staggeringly massive and glorious task (like a billion-dollar charity) a highly toxic and invisible virus of 'Ego' can easily infect his brain whispering "I am the great savior who donated this."
            This specific toxic ego will mathematically drag his soul right back down into the earthly matrix. But the exact microsecond he vibrates 'Tat', he delivers a brutal psychological 'Reminder' to his own consciousness.
            He officially declares: "For this massive charity or brutal austerity I have executed I demand absolutely zero public applause and zero tickets to Heaven; I am dedicating 100% of this strictly to 'Tat' (The Supreme Creator)."
            This magical syllable 'Tat' flawlessly intercepts the massive 'Karmic Credit' generated by the good deeds instantly transferring it out of the human's personal account directly into God's infinite cosmic bank account.
            And it is only when a human's personal karmic balance sheet hits absolute 'Zero' that he successfully bypasses the 3D reincarnation matrix and is permanently granted authentic eternal freedom (Moksha).
        """.trimIndent()
    ),
    Shloka(
        id = 26,
        sanskrit = """
            सद्भावे साधुभावे च सदित्येतत्प्रयुज्यते |
            प्रशस्ते कर्मणि तथा सच्छब्दः पार्थ युज्यते || २६ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 26 और 27 'सत्' शब्द के अर्थ को पूरा करते हैं)
            हे पार्थ (अर्जुन)! इस 'सत्' (SAT) शब्द का प्रयोग मुख्य रूप से परम सत्य (सद्भावे) को दर्शाने के लिए और श्रेष्ठ एवं पवित्र भाव (साधुभावे) को प्रकट करने के लिए किया जाता है।
            तथा इस दुनिया में जो भी अत्यंत शुभ, श्रेष्ठ, कल्याणकारी और पवित्र कर्म (प्रशस्ते कर्मणि) किए जाते हैं, उन सभी उत्तम कार्यों के साथ भी यह 'सत्' शब्द (सच्छब्दः) बहुत गहराई से जोड़ा जाता है।
            अब भगवान इस सीक्रेट-कोड (Secret-code) के तीसरे और आखिरी हिस्से 'सत्' (SAT) का सबसे गहरा अर्थ अर्जुन को समझा रहे हैं।
            'सत्' का सबसे बेसिक (Basic) अर्थ है 'सच्चाई' (Truth) या 'वह जो हमेशा परमानेंट (Permanent) और अविनाशी है', यानी साक्षात् भगवान।
            जब हम दुनिया में किसी बहुत ही महान, ईमानदार और पवित्र इंसान को देखते हैं, तो हम उसे 'साधु' या 'सज्जन' (सत्+जन) कहते हैं, क्योंकि उसके अंदर उसी 'सत्' (ईश्वर) की झलक होती है।
            भगवान कहते हैं कि अगर दुनिया में कोई बहुत ही शानदार और भलाई का काम हो रहा है (जैसे किसी की जान बचाना या भूखों को खाना खिलाना), तो वह काम कोई आम काम नहीं है, वह 'सत् कर्म' है।
            और ऐसे हर प्रशस्त (Praiseworthy / महान) काम के साथ यह 'सत्' शब्द एक ठप्पे (Stamp) की तरह लगाया जाता है जो यह प्रमाणित करता है कि यह काम 100% ईश्वरीय है।
            'सत्' का प्रयोग उन चीज़ों को एक साथ बांधने के लिए होता है जो अच्छी हैं, सच्ची हैं और जो इंसान को सीधा भगवान की तरफ ले जाने का रास्ता बनाती हैं।
            यह श्लोक साबित करता है कि ब्रह्मांड में जो कुछ भी पॉजिटिव (Positive), प्योर (Pure) और परमानेंट है, वह सब कुछ इसी 'सत्' शब्द की ही एक छोटी सी परछाई है।
            इसलिए इंसान को अपने कैरेक्टर (Character) और अपने हर एक एक्शन (Action) को इतना साफ और पवित्र बनाना चाहिए कि वह भी 'सत्' कहलाने के लायक बन सके।
        """.trimIndent(),
        english = """
            (Verses 26 and 27 seamlessly complete the profound explanation of the syllable 'Sat')
            O son of Pritha (Partha)! The Absolute syllable 'Sat' is primarily and aggressively utilized to explicitly indicate the Supreme Eternal Truth (Sad-bhave) and to highlight the absolute highest flawless purity of character (Sadhu-bhave).
            Furthermore whenever any exceptionally auspicious highly elevated praise-worthy and supremely beneficial activity is executed in this world (Prashaste karmani) the sacred word 'Sat' is deeply and formally attached to it (Sach-chabdah yujyate).
            The Lord is now meticulously decoding the third and absolute final component of this cosmic secret-code 'Sat' revealing its staggering depth to Arjuna's highly analytical brain.
            The fundamental absolute translation of 'Sat' is 'Truth' or 'That which is mathematically permanent and indestructible' explicitly pointing directly to the Supreme Godhead Himself.
            When we visually encounter a human being operating with incredibly flawless honesty and radiant cosmic purity we officially categorize him as a 'Sadhu' or 'Sajjan' (Sat+Jan) because he physically reflects that exact 'Sat' (God).
            The Lord emphatically declares that whenever a phenomenally magnificent and highly benevolent action is executed in the matrix (like rescuing a dying soul or feeding millions) it is absolutely not an ordinary event; it is a 'Sat Karma'.
            And onto every single one of these elite highly praiseworthy (Prashaste) cosmic actions the syllable 'Sat' is officially stamped exactly like a titanium seal of approval mathematically certifying the act as 100% divine.
            The syllable 'Sat' acts as a powerful cosmic glue aggressively binding together absolutely everything that is authentic pure and effectively engineers a direct high-speed highway straight to the Supreme Creator.
            This spectacular verse absolutely proves that whatever is highly positive brilliantly pure and structurally permanent in this entire multiverse is merely a microscopic shadow radiating from this exact syllable 'Sat'.
            Therefore a human must urgently and aggressively upgrade his internal character and every single physical action to such an extreme level of immaculate purity that his entire biological existence legally qualifies to be labeled as 'Sat'.
        """.trimIndent()
    ),
    Shloka(
        id = 27,
        sanskrit = """
            यज्ञे तपसि दाने च स्थितिः सदिति चोच्यते |
            कर्म चैव तदर्थीयं सदित्येवाभिधीयते || २७ ||
        """.trimIndent(),
        hindi = """
            यज्ञ (भगवान की पूजा), तपस्या (कठोर आत्म-अनुशासन) और दान (निस्वार्थ भाव से देना) में जो अत्यंत दृढ़ और अटल स्थिति (पक्का विश्वास / स्थितिः) होती है, उसे भी 'सत्' (SAT) ही कहा जाता है (सदिति चोच्यते)।
            और उस परमात्मा (या उस परम सत्य) को प्रसन्न करने के उद्देश्य से (तदर्थीयं) जो भी निस्वार्थ कर्म या एक्शन (Action) किया जाता है, उसे भी निश्चित रूप से 'सत्' (सदित्येव) ही कहकर पुकारा जाता है (अभिधीयते)।
            यहाँ भगवान 'सत्' (SAT) शब्द की सबसे बड़ी और सबसे प्रैक्टिकल (Practical) परिभाषा (Definition) दे रहे हैं जिसे कोई भी इंसान अपनी ज़िंदगी में उतार सकता है।
            इंसान जब कोई अच्छा काम (यज्ञ, दान या तप) शुरू करता है, तो बीच में कई मुश्किलें आती हैं, उसका मन भटकता है या दुनिया उसे ताने मारती है।
            लेकिन जो इंसान बिना डरे, एक पहाड़ की तरह अपने उस अच्छे काम पर 'अडिग' (Firm / स्थितिः) रहता है और उसे बीच में नहीं छोड़ता, उसकी उस अजेय 'ज़िद' (Determination) को ही भगवान 'सत्' कहते हैं।
            यानी केवल काम शुरू करना बड़ी बात नहीं है; उस काम में टिके रहना (Consistency) ही असली 'सत्' है।
            और दूसरी सबसे बड़ी बात: "तदर्थीयं कर्म"—अगर आप कोई ऐसा काम कर रहे हैं जिसका मकसद अपनी जेब भरना या अपना नाम चमकाना नहीं है, बल्कि वह काम केवल और केवल 'ईश्वर' (तत्) को खुश करने के लिए किया जा रहा है।
            तो भगवान स्टैम्प (Stamp) लगा देते हैं कि वह साधारण सा दिखने वाला काम भी 'सत्' (परम पवित्र और ईश्वरीय) बन जाता है।
            चाहे आप मंदिर में झाड़ू लगा रहे हों या किसी गरीब बच्चे को पढ़ा रहे हों; अगर आपका इरादा (Intention) भगवान को खुश करना है, तो आपका वह कर्म सीधा वैकुंठ (Spiritual World) के अकाउंट में डिपॉजिट (Deposit) हो जाता है।
            'ॐ तत् सत्' का यह पूरा विज्ञान इंसान के हर छोटे-बड़े काम को दुनिया की गंदगी से निकालकर उसे एक 'डिवाइन मास्टरपीस' (Divine Masterpiece) में बदल देता है।
        """.trimIndent(),
        english = """
            The absolute unshakeable firmness and titanium-like steady fixation (Sthitih) in executing sacrifices performing brutal austerities and distributing selfless charity is also officially designated by the word 'Sat' (Sad iti chochyate).
            And furthermore absolutely any selfless physical action or endeavor that is executed purely with the singular target of pleasing that Supreme Absolute Truth (Tad-arthiyam karma) is definitively and officially termed as 'Sat' (Sad ity evabhidhiyate).
            Here the Supreme Lord is aggressively delivering the absolute most practical and highly applicable definition of the syllable 'Sat' which any mortal can instantly install into his daily biological routine.
            When a human initiates a massive noble endeavor (like a heavy sacrifice charity or severe penance) the toxic matrix throws endless horrific obstacles at him his rogue mind flickers and arrogant society hurls brutal insults.
            But the elite human who completely ignores the chaos and remains anchored exactly like an invincible titanium mountain remaining absolutely 'Firm' (Sthitih) in his noble mission without quitting is officially defined by God as 'Sat'.
            This means simply launching a good project is not the ultimate achievement; maintaining a terrifyingly unyielding 'Consistency' against all odds is the true manifestation of 'Sat'.
            And the absolute ultimate cosmic twist: "Tad-arthiyam karma"—If you are executing a physical action where your underlying psychological software possesses absolutely zero toxic greed to inflate your own bank account or boost your fake social clout.
            But instead that specific action is being relentlessly ground out strictly and exclusively for the ultimate pleasure of the 'Supreme Lord' (Tat), the Creator officially stamps that seemingly ordinary biological action as 'Sat' (Supreme and Divine).
            Whether you are silently sweeping the dirty floors of a hospital or aggressively teaching a starving child; if your core intention is strictly to satisfy God that physical labor is instantly deposited directly into the eternal servers of Vaikuntha.
            The complete scientific mastery of this 'Om Tat Sat' formula successfully upgrades every single microscopic mundane human action violently extracting it from the filthy material matrix and transforming it into a flawless 'Divine Masterpiece'.
        """.trimIndent()
    ),
    Shloka(
        id = 28,
        sanskrit = """
            अश्रद्धया हुतं दत्तं तपस्तप्तं कृतं च यत् |
            असदित्युच्यते पार्थ न च तत्प्रेत्य नो इह || २८ ||
        """.trimIndent(),
        hindi = """
            हे पार्थ (अर्जुन)! बिना किसी सच्ची श्रद्धा और विश्वास के (अश्रद्धया) जो कुछ भी आहुति (यज्ञ) दी जाती है, जो भी भारी दान दिया जाता है, और जो भी अत्यंत कठोर तपस्या की जाती है (तपस्तप्तं)।
            या इसके अलावा भी जो कोई भी कर्म बिना श्रद्धा के किया जाता है (कृतं च यत्), वह सब कुछ पूरी तरह से 'असत्' (झूठा, व्यर्थ और कचरा) ही कहा जाता है (असदित्युच्यते)।
            ऐसा बिना श्रद्धा के किया गया वह 'असत्' काम न तो इस दुनिया (इह) में किसी फायदे का होता है, और न ही मरने के बाद (प्रेत्य) अगली दुनिया में इंसान को कोई सुख या मोक्ष दे पाता है।
            यह सत्रहवें अध्याय का अत्यंत ही खौफनाक और इंसान के अहंकार को चकनाचूर करने वाला 'ग्रैंड फिनाले' (Grand Finale) श्लोक है!
            भगवान श्रीकृष्ण ने पूरे अध्याय में यज्ञ, तप और दान की महिमा बताई, लेकिन अब वे सबसे बड़ा 'चेतावनी बोर्ड' (Warning Sign) लगा रहे हैं।
            वे कहते हैं कि तुम चाहे करोड़ों रुपयों का दान कर दो, दुनिया का सबसे बड़ा हवन (यज्ञ) कर लो, या हिमालय पर जाकर 50 साल तक भूखे रहकर तपस्या कर लो...
            अगर उस काम के पीछे तुम्हारे दिल में 'सच्ची श्रद्धा' (Faith / भगवान के प्रति गहरा विश्वास और प्यार) नहीं है, और तुम वह काम केवल दिखावे, डर या किसी दबाव में कर रहे हो।
            तो भगवान की नज़र में वह तुम्हारा सारा पैसा और तुम्हारी सारी मेहनत 100% 'असत्' (Absolute Zero / कचरा) है! उसका आध्यात्मिक अकाउंट (Spiritual Account) में कोई रिकॉर्ड नहीं होता।
            वह 'असत्' काम तुम्हें इस दुनिया में भी केवल स्ट्रेस (Stress) और थकावट ही देगा, और मरने के बाद भी तुम्हें नर्क या पुनर्जन्म के चक्कर में ही धकेल देगा, उससे तुम्हें कोई स्वर्ग या भगवान नहीं मिलने वाले।
            यहाँ यह अध्याय यह बहुत बड़ा संदेश देकर पूरा होता है कि ईश्वर को आपकी दौलत या फिजिकल मेहनत (Physical hard work) की भूख नहीं है; ईश्वर की करेंसी (Currency) केवल और केवल आपकी 'शुद्ध श्रद्धा' (Pure Faith) है!
        """.trimIndent(),
        english = """
            O son of Pritha (Partha)! Absolutely any massive sacrifice offered into the fire any heavily funded charity distributed and any brutally severe austerity performed completely devoid of supreme genuine faith (Ashraddhaya).
            Or absolutely any other massive physical endeavor executed without this core titanium belief (Kritam cha yat) is officially and universally condemned as 'Asat' (Fake useless and absolute garbage).
            Such a deeply corrupted faithless and hollow action yields mathematically zero beneficial results for the doer neither in this current biological timeline (Iha) nor in the eternal afterlife after physical death (Pretya).
            This is the incredibly terrifying aggressively blunt and ego-shattering 'Grand Finale' verse officially concluding the spectacular Seventeenth Chapter!
            Throughout this entire chapter Lord Sri Krishna beautifully glorified the immense power of sacrifice austerity and charity but now He erects the absolute most critical cosmic 'Warning Sign'.
            He aggressively declares: You can casually donate billions of dollars to global NGOs organize the absolute largest fire-sacrifices in human history or violently starve your biological body in the freezing Himalayas for half a century...
            If the psychological engine driving that massive action completely lacks 'True Shraddha' (Unadulterated Faith and explosive pure love for God) and you are executing it merely out of fake theatrical showmanship social terror or toxic peer pressure.
            Then in the ultimate Supreme Court of God absolutely 100% of your massive billion-dollar wealth and bone-crushing physical labor is officially stamped as 'Asat' (Absolute Zero / Cosmic Trash)! It registers mathematically zero value in your spiritual bank account.
            That fake 'Asat' action will mathematically generate nothing but severe biological stress and brutal exhaustion in this current matrix and upon expiration it will forcefully boot you right back into the horrific reincarnation loop completely denying you any heavenly or divine access.
            This chapter flawlessly concludes by transmitting the ultimate absolute universal truth: The Supreme Creator is absolutely not hungry for your cheap paper wealth or your brutal physical gymnastics; the absolute ONLY valid currency accepted in God's kingdom is your 'Pure Unconditional Faith'!
        """.trimIndent()
    )
)