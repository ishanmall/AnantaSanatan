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
fun AdhyayaSixteen() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun performSearch() {
        val shlokaNum = searchQuery.toIntOrNull()
        if (shlokaNum != null) {
            val targetIndex = adhyayaSixteenShlokas.indexOfFirst { it.id == shlokaNum }
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
            label = { Text("Search Shloka Number (1 - 24)") },
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
            itemsIndexed(adhyayaSixteenShlokas) { _, shloka ->
                ShlokaCard(shloka)
            }
        }
    }
}

val adhyayaSixteenShlokas = listOf(
    Shloka(
        id = 1,
        sanskrit = """
            श्रीभगवानुवाच |
            अभयं सत्त्वसंशुद्धिर्ज्ञानयोगव्यवस्थितिः |
            दानं दमश्च यज्ञश्च स्वाध्यायस्तप आर्जवम् || १ ||
        """.trimIndent(),
        hindi = """
            भगवान श्रीकृष्ण इस सोलहवें अध्याय की शुरुआत अत्यंत दैवीय और ईश्वरीय गुणों की एक शानदार सूची के साथ करते हैं।
            वे सबसे पहले अभय यानी पूर्ण निडरता का उल्लेख करते हैं जो एक आध्यात्मिक साधक का सबसे पहला और अनिवार्य आभूषण है।
            इसके बाद अंतःकरण की पूर्ण शुद्धि और ज्ञान-योग में निरंतर ध्यान लगाए रखने की दृढ़ स्थिति का अत्यंत गहरा महत्व बताया गया है।
            पवित्र मन से किया गया सात्त्विक दान इंसान को भौतिक आसक्तियों से पूरी तरह मुक्त करके उसे उदार और विशाल बनाता है।
            अपनी इन्द्रियों पर कड़ा नियंत्रण यानी दम एक सच्चे योगी को सांसारिक वासनाओं के भयंकर जाल से हमेशा सुरक्षित रखता है।
            ईश्वर के निमित्त किए जाने वाले यज्ञ और धार्मिक कर्मकांड मनुष्य के भीतर समर्पण की अत्यंत गहरी भावना पैदा करते हैं।
            पवित्र शास्त्रों का नियमित और गहरा अध्ययन यानी स्वाध्याय अज्ञान के अंधेरे को काटकर आत्मा को पूरी तरह प्रकाशित करता है।
            कठोर तपस्या के द्वारा शरीर और मन को शुद्ध करना आध्यात्मिक यात्रा में इंसान को अत्यंत मजबूत और शक्तिशाली बनाता है।
            और अंत में आर्जव यानी मन, वाणी और शरीर की पूर्ण सरलता मनुष्य के भीतर कपट और चालाकी को जड़ से मिटा देती है।
            ये सभी नौ गुण उस ईश्वरीय खजाने का हिस्सा हैं जो सीधे तौर पर एक आत्मा को परमात्मा के निकट ले जाने का मार्ग प्रशस्त करते हैं।
        """.trimIndent(),
        english = """
            Lord Sri Krishna initiates this magnificent sixteenth chapter by unfolding a spectacular inventory of absolute divine qualities.
            He first and foremost emphasizes absolute fearlessness, establishing it as the primary and mandatory psychological ornament of a true spiritual seeker.
            This is followed by the complete, surgical purification of one's existence and the unwavering, titanium focus on cultivating transcendental knowledge.
            Executing pure, unmotivated charity effectively severs a human's toxic material attachments and radically expands his compassionate spiritual heart.
            The brutal, uncompromising control of the biological senses acts as a highly advanced shield against the terrifying, sticky traps of material lust.
            Performing sacred sacrifices and dedicating all physical actions to the Supreme seamlessly cultivates a profound attitude of unconditional cosmic surrender.
            The aggressive and consistent study of the authorized Vedic scriptures completely incinerates the dense, paralyzing darkness of human ignorance.
            Undergoing severe austerities physically and mentally purifies the biological vessel, rendering the practitioner exceptionally strong and highly resilient.
            And finally, absolute simplicity and straightforwardness in thought, word, and deed completely and permanently eradicate all toxic hypocrisy and deceit.
            These majestic qualities collectively constitute the divine cosmic wealth that officially guarantees the soul a direct flight to the Supreme Godhead.
        """.trimIndent()
    ),
    Shloka(
        id = 2,
        sanskrit = """
            अहिंसा सत्यमक्रोधस्त्यागः शान्तिरपैशुनम् |
            दया भूतेष्वलोलुप्त्वं मार्दवं ह्रीरचापलम् || २ ||
        """.trimIndent(),
        hindi = """
            दैवीय संपदा की इस महान सूची को आगे बढ़ाते हुए भगवान दस और अत्यंत सुंदर और शक्तिशाली मानवीय गुणों का वर्णन करते हैं।
            सबसे पहले अहिंसा का उल्लेख है जिसका अर्थ है किसी भी प्राणी को मन, वचन या कर्म से कभी भी ज़रा सा भी दुःख न पहुँचाना।
            सत्य का पालन करना और बिना किसी स्वार्थ के हमेशा सच बोलना एक निर्मल और पवित्र चरित्र की सबसे बड़ी पहचान होती है।
            अक्रोध यानी भयंकर उकसावे के बावजूद अपने गुस्से को पूरी तरह से पी जाना एक योगी की सबसे बड़ी और अजेय मनोवैज्ञानिक शक्ति है।
            त्याग की भावना मनुष्य को स्वार्थी लालच से बचाती है और शांति उसके बेचैन मन को एक गहरे और स्थिर तालाब की तरह शांत कर देती है।
            अपैशुनम् का अर्थ है किसी की पीठ पीछे चुगली या निंदा न करना जो इंसान को समाज की गंदी राजनीति और नकारात्मकता से दूर रखता है।
            सभी जीवों पर बिना किसी स्वार्थ के दया करना और सांसारिक सुखों को देखकर भी मन में लालच न लाना एक सच्चे महात्मा का लक्षण है।
            मार्दवम् यानी स्वभाव में कोमलता और ह्रीर यानी बुरे काम करने में शर्म या संकोच महसूस करना इंसान को गलत रास्ते पर जाने से रोकते हैं।
            अचापलम् का अर्थ है बिना वजह शरीर या मन को चंचल न रखना और हर काम को अत्यंत फोकस और गहरी स्थिरता के साथ पूरा करना।
            ये सभी गुण मनुष्य को जानवरों की श्रेणी से उठाकर साक्षात् ईश्वर के स्वरूप के अत्यंत करीब लाकर खड़ा कर देते हैं।
        """.trimIndent(),
        english = """
            Continuing this magnificent inventory of divine wealth, the Lord meticulously details ten more exceptionally beautiful and highly powerful human qualities.
            He highlights nonviolence, which fundamentally dictates that a human must absolutely never inflict even microscopic pain upon any living entity through thought, word, or deed.
            Practicing absolute truthfulness and aggressively speaking the unadulterated truth without selfish motives is the ultimate hallmark of a flawlessly pure character.
            Freedom from anger, even under the most brutal and intense provocation, is officially recognized as the absolute greatest psychological superpower of an elite yogi.
            The spirit of renunciation violently detaches a human from toxic greed, while profound tranquility completely pacifies his restless brain like a perfectly still lake.
            Aversion to fault-finding ensures that a sage absolutely refuses to participate in toxic social gossip or backbiting, keeping his spiritual aura entirely unpolluted.
            Fierce compassion for all living beings and remaining entirely immune to greed even when surrounded by massive sensory temptations are the literal traits of a Mahatma.
            Extreme gentleness in behavior and maintaining a deep, healthy sense of shame towards executing sinful acts permanently block a human from straying into darkness.
            Steadfast determination demands that a human eradicate all useless physical and mental restlessness, operating his biological machine with laser-sharp focus and total stability.
            Successfully installing these specific divine traits permanently upgrades a mortal from a primitive animalistic state to an incredibly elevated, God-like spiritual existence.
        """.trimIndent()
    ),
    Shloka(
        id = 3,
        sanskrit = """
            तेजः क्षमा धृतिः शौचमद्रोहो नातिमानिता |
            भवन्ति सम्पदं दैवीमभिजातस्य भारत || ३ ||
        """.trimIndent(),
        hindi = """
            भगवान इस श्लोक में दैवीय संपदा के अंतिम छह महान गुणों को बताकर इस ईश्वरीय सूची को अत्यंत भव्यता के साथ पूरा करते हैं।
            तेज का अर्थ है वह आध्यात्मिक चमक और आत्मविश्वास जो एक सच्चे साधक को दुनिया के सामने बिना किसी डर के खड़ा करता है।
            क्षमा वह अत्यंत शक्तिशाली गुण है जिसके तहत इंसान अपने सबसे बड़े दुश्मन को भी सजा देने की ताकत रखते हुए प्यार से माफ़ कर देता है।
            धृति यानी भयंकर विपत्तियों और दुखों के बीच भी अपने धैर्य को एक विशाल चट्टान की तरह टूटने से बचाए रखना एक ईश्वरीय खूबी है।
            शौचम का अर्थ शरीर को बाहर से साफ़ रखना और मन को गंदे विचारों से अंदर से पूरी तरह शुद्ध रखना है जो भक्ति के लिए अनिवार्य है।
            अद्रोह का मतलब है दुनिया के किसी भी प्राणी के प्रति अपने दिल में ज़रा सी भी दुश्मनी या नफरत का भयंकर ज़हर न पालना।
            और नातिमानिता का अर्थ है अपने भीतर किसी भी प्रकार के झूठे घमंड या सम्मान पाने की लालसा को जड़ से पूरी तरह मिटा देना।
            हे भारत! ये कुल छब्बीस गुण उस भाग्यशाली मनुष्य की साक्षात् पहचान हैं जो इस धरती पर दैवीय प्रवृत्तियों के साथ जन्म लेता है।
            जो व्यक्ति अपने जीवन में इन ईश्वरीय गुणों का अभ्यास करता है, वह भौतिक दुनिया की हर माया और बुराई से अछूता रहता है।
            ईश्वर यह स्पष्ट करते हैं कि यही वह एकमात्र मनोवैज्ञानिक और आध्यात्मिक रोडमैप है जो सीधे मोक्ष के परम द्वार तक जाता है।
        """.trimIndent(),
        english = """
            The Lord spectacularly finalizes this magnificent cosmic inventory of divine wealth by listing the absolute final six transcendental qualities required for liberation.
            Vigor refers to that blinding, radioactive spiritual aura and extreme self-confidence that empowers a true seeker to stand fearlessly against the entire matrix.
            Absolute forgiveness is that terrifyingly powerful trait where a human possesses the full capability to brutally punish his enemy, yet gracefully chooses to pardon him.
            Fortitude is the titanium, unyielding strength that prevents a human's patience from shattering even when crushed under catastrophic tragedies and massive worldly disasters.
            Cleanliness strictly demands maintaining both an immaculate exterior physical hygiene and executing a brutal, clinical purification of the internal mind from all toxic thoughts.
            Freedom from envy completely dictates that a human must mathematically harbor absolute zero toxic poison, malice, or hatred toward any living entity in the multiverse.
            And the total absence of the passion for honor requires a seeker to violently assassinate his false ego and completely eradicate his pathetic craving for cheap social validation.
            O son of Bharata! These twenty-six specific, elite qualities are the undeniable, physical fingerprints of a fortunate human born fully endowed with a divine, transcendental nature.
            Any human who actively and aggressively practices these godly traits remains completely immune and untouched by the suffocating illusions and horrific evils of the material world.
            The Supreme Creator explicitly establishes that upgrading your character with these exact traits is the only authorized psychological roadmap leading directly to the ultimate gates of Moksha.
        """.trimIndent()
    ),
    Shloka(
        id = 4,
        sanskrit = """
            दम्भो दर्पोऽभिमानश्च क्रोधः पारुष्यमेव च |
            अज्ञानं चाभिजातस्य पार्थ सम्पदमासुरीम् || ४ ||
        """.trimIndent(),
        hindi = """
            भगवान अब उन भयंकर और आसुरी प्रवृत्तियों का वर्णन करते हैं जो इंसान को सीधे पतन और नर्क के अंधेरे की ओर ले जाती हैं।
            सबसे पहला दुर्गुण दम्भ है जहाँ मनुष्य समाज में अपने धर्म, अच्छाई और महानता का केवल झूठा और पाखंडी दिखावा करता है।
            दूसरा भयंकर दोष दर्प यानी घमंड है जिसमें धन, ज्ञान और शक्ति के नशे में अंधा होकर इंसान दूसरों को कीड़े-मकोड़े समझने लगता है।
            तीसरा दोष अभिमान है जो इंसान के भीतर यह खतरनाक भ्रम पैदा करता है कि वह दुनिया का सबसे श्रेष्ठ और महत्वपूर्ण व्यक्ति है।
            चौथा लक्षण क्रोध है जो किसी भी छोटी सी बात पर भड़क उठता है और सोचने-समझने की सारी लॉजिकल क्षमता को पूरी तरह जला देता है।
            पाँचवाँ दोष पारुष्य यानी कठोरता है जहाँ मनुष्य की वाणी और उसके शारीरिक व्यवहार में दया या कोमलता का लेशमात्र भी नहीं होता।
            छठा और सबसे खतरनाक दोष अज्ञान है जो सत्य और असत्य के बीच के अंतर को पूरी तरह से मिटाकर इंसान को मानसिक रूप से अंधा कर देता है।
            ये छह आसुरी संपदाएं एक ऐसे ज़हरीले सॉफ्टवेयर की तरह हैं जो इंसान की चेतना को पूरी तरह से हैक करके उसे जानवर बना देती हैं।
            जो मनुष्य इन भयानक आसुरी प्रवृत्तियों के साथ जन्म लेता है वह जीवन भर केवल विनाश, तनाव और दुखों की ही खेती करता है।
            ईश्वर हमें चेतावनी देते हैं कि इन दानवी गुणों को पहचानकर हमें तुरंत इन्हें अपने भीतर से उखाड़ फेंकने का आक्रामक प्रयास करना चाहिए।
        """.trimIndent(),
        english = """
            The Lord now explicitly details the terrifying and demoniac qualities that aggressively drag a human being directly toward ultimate cosmic downfall and hellish darkness.
            The absolute first toxic trait is hypocrisy, where a mortal actively orchestrates a completely fake, theatrical show of his own religious piety and moral greatness.
            The second horrific defect is arrogance, wherein a human completely blinded by extreme wealth, fake knowledge, and temporary power treats other living entities like worthless insects.
            The third fatal flaw is massive false prestige, a psychological disease forcing a person to blindly hallucinate that he is the absolute greatest and most important entity on earth.
            The fourth terrifying symptom is violent anger, which explosively triggers over the tiniest provocations and brutally incinerates all rational cognitive functions and basic logic.
            The fifth devastating defect is sheer harshness, dictating that a human's spoken words and physical behavior remain utterly devoid of even a microscopic drop of compassion or gentleness.
            The sixth and absolute most dangerous flaw is deep, paralyzing ignorance, completely obliterating a person's biological ability to distinguish between eternal cosmic truth and toxic material illusion.
            These six demoniac qualities operate exactly like a highly lethal, radioactive software virus that completely hijacks, corrupts, and degrades the human consciousness back into a primitive animal.
            A human entity born heavily infected with these monstrous, toxic tendencies effortlessly spends his entire biological timeline cultivating absolutely nothing but catastrophic chaos, endless stress, and pure misery.
            The Supreme Lord issues a brutal, life-saving warning to scientifically identify these demonic traits and aggressively eradicate them from our internal hard drives without a second of delay.
        """.trimIndent()
    ),
    Shloka(
        id = 5,
        sanskrit = """
            दैवी सम्पद्विमोक्षाय निबन्धायासुरी मता |
            मा शुचः सम्पदं दैवीमभिजातोऽसि पाण्डव || ५ ||
        """.trimIndent(),
        hindi = """
            भगवान स्पष्ट रूप से बताते हैं कि जो छब्बीस दैवीय गुण पहले बताए गए हैं वे मनुष्य को इस जन्म-मरण के संसार से पूरी तरह मुक्त करते हैं।
            दैवीय संपदा आत्मा के लिए एक पावरफुल रॉकेट की तरह काम करती है जो उसे माया के गुरुत्वाकर्षण से बाहर निकालकर सीधे मोक्ष तक ले जाती है।
            इसके विपरीत जो छह आसुरी या दानवी गुण बताए गए हैं वे मनुष्य को इस भौतिक दुनिया के दुखों और जन्मों के भयंकर जाल में मजबूती से बाँधते हैं।
            आसुरी संपदा लोहे की उन भारी जंजीरों के समान है जो आत्मा को पाताल और नर्क की अंधेरी खाइयों में हमेशा के लिए जकड़ कर रखती है।
            अर्जुन इन भयानक आसुरी गुणों के बारे में सुनकर यह सोचकर अत्यंत डरा हुआ महसूस करने लगा कि कहीं उसके भीतर भी तो ये दानवी गुण नहीं हैं।
            एक सच्चा और विनम्र साधक हमेशा अपनी कमियों को लेकर सचेत रहता है और उसे डर लगता है कि कहीं उसका अहंकार उसे भटका न दे।
            भगवान अर्जुन के इस मानसिक तनाव और डर को तुरंत भांप लेते हैं और एक अत्यंत दयालु पिता की तरह उसे गहरी सांत्वना और हिम्मत देते हैं।
            वे कहते हैं कि हे पाण्डव अर्जुन! तुम बिल्कुल भी शोक मत करो या डरो मत क्योंकि तुम जन्म से ही अत्यंत पवित्र और दैवीय संपदा लेकर पैदा हुए हो।
            यह श्लोक प्रमाणित करता है कि भगवान अपने शुद्ध भक्तों के चरित्र की पूरी गारंटी लेते हैं और उन्हें अज्ञान के किसी भी डर से हमेशा बचाते हैं।
            हमें भी अपने भीतर दैवीय गुणों को लगातार बढ़ाना चाहिए ताकि हम भगवान से यह आश्वासन पाने के योग्य बन सकें कि हम सही रास्ते पर हैं।
        """.trimIndent(),
        english = """
            The Lord categorically establishes that the previously detailed twenty-six divine qualities function exclusively to completely liberate a human from the miserable cycle of repeated birth and death.
            This transcendental divine wealth operates exactly like a staggeringly powerful cosmic rocket, effortlessly propelling the soul completely out of Maya's heavy gravitational pull directly toward eternal Moksha.
            Conversely, the six terrifyingly toxic demoniac qualities are explicitly engineered to heavily bind and violently entangle a human within the agonizing, inescapable traps of the material universe.
            This demoniac wealth acts precisely like massive, rusted iron chains that ruthlessly drag the eternal soul downward, permanently locking it into the darkest, most terrifying hellish dimensions.
            Upon hearing the horrifying descriptions of these demonic traits, Arjuna instantly experienced a massive panic attack, terrifyingly wondering if his own brain was secretly infected with these toxic viruses.
            A genuinely pure and humble spiritual seeker constantly audits his own internal software, maintaining a healthy, hyper-vigilant fear that his false ego might secretly sabotage his spiritual evolution.
            The Supreme Lord instantaneously detects Arjuna's skyrocketing biological anxiety and, acting exactly like an unimaginably compassionate father, rushes to actively comfort and deeply reassure His terrified devotee.
            He emphatically declares, "O son of Pandu, Arjuna! Do not lament or suffer from panic, for I mathematically guarantee that you are biologically and spiritually born heavily endowed with the absolute divine qualities."
            This spectacular verse proves that the Supreme Godhead takes full, titanium-clad responsibility for His pure devotees' character, flawlessly protecting them from the paralyzing paranoia generated by material ignorance.
            We must aggressively and continuously upgrade our own internal character with these divine traits so we too can become eligible to receive this ultimate, comforting cosmic assurance from God.
        """.trimIndent()
    ),
    Shloka(
        id = 6,
        sanskrit = """
            द्वौ भूतसर्गौ लोकेऽस्मिन्दैव आसुर एव च |
            दैवो विस्तरशः प्रोक्त आसुरं पार्थ मे शृणु || ६ ||
        """.trimIndent(),
        hindi = """
            हे पृथापुत्र अर्जुन! इस पूरे भौतिक संसार में मुख्य रूप से केवल दो ही प्रकार के स्वभाव वाले जीवों की रचना या सृष्टि की गई है।
            एक प्रकार के जीव वे हैं जो दैवीय स्वभाव वाले होते हैं और दूसरे प्रकार के जीव वे हैं जिनका स्वभाव पूरी तरह से आसुरी या दानवी होता है।
            भगवान यहाँ पूरी मानव जाति को उनके कर्मों और सोच के आधार पर केवल दो बहुत ही स्पष्ट और विरोधी श्रेणियों में विभाजित कर रहे हैं।
            दैवीय स्वभाव वाले लोग हमेशा प्रकाश, ज्ञान और ईश्वर की ओर भागते हैं जबकि आसुरी स्वभाव वाले लोग अंधेरे, लालच और अहंकार में डूबे रहते हैं।
            भगवान कहते हैं कि मैंने दैवीय गुणों वाले श्रेष्ठ मनुष्यों का विस्तार से वर्णन तो तुम्हें पहले ही बहुत अच्छी तरह से समझा दिया है।
            अब मैं तुम्हें उन आसुरी और दुष्ट प्रवृत्ति वाले लोगों के बारे में विस्तार से बताऊँगा ताकि तुम उनके खतरनाक माइंडसेट को पूरी तरह समझ सको।
            आसुरी स्वभाव को गहराई से समझना इसलिए ज़रूरी है ताकि एक साधक समाज में फैले हुए इन ज़हरीले इंसानों को पहचान कर उनसे खुद को बचा सके।
            जब तक हमें बीमारी के भयंकर लक्षणों का सही ज्ञान नहीं होगा तब तक हम अपने भीतर और बाहर उस बीमारी से बचने का सही इलाज नहीं कर सकते।
            यह श्लोक आगे आने वाले उस अत्यंत कड़वे और मनोवैज्ञानिक विश्लेषण की भूमिका बनाता है जहाँ भगवान राक्षसी सोच का पूरा पर्दाफाश करेंगे।
            अर्जुन को अब पूरी एकाग्रता के साथ उन दुष्ट लोगों की मानसिकता को सुनने का आदेश दिया गया है जो इस दुनिया के विनाश का कारण बनते हैं।
        """.trimIndent(),
        english = """
            O son of Pritha, Arjuna! In this entire material multiverse, there are fundamentally created only two distinct and opposing classes of living entities based entirely on their intrinsic nature.
            One specific class of beings is biologically and spiritually heavily endowed with the divine nature, while the other class is completely corrupted and operates exclusively on a demoniac nature.
            The Lord is officially executing a massive, binary classification of the entire human race, dividing them strictly into two absolute categories based purely on their psychological algorithms and daily karma.
            Those possessing the divine nature constantly and aggressively sprint toward absolute light, transcendental knowledge, and God, whereas the demoniac remain violently submerged in toxic darkness, immense greed, and inflated ego.
            The Lord explicitly states that He has already thoroughly and extensively downloaded the comprehensive data regarding the elite humans possessing these magnificent divine qualities directly into Arjuna's brain.
            Now, He commands Arjuna to prepare himself as He initiates a brutal, exhaustive, and highly detailed expose unmasking the exact terrifying psychology and toxic mindset of the demoniac entities.
            Profoundly understanding this demoniac nature is a matter of absolute spiritual survival; an elite seeker must possess the ability to scientifically identify these toxic humans in society and aggressively avoid their lethal association.
            Until a human accurately comprehends the horrifying symptoms of a deadly biological virus, it is mathematically impossible to implement the correct defensive protocols to protect himself from a catastrophic infection.
            This spectacular verse officially sets the stage for the incredibly bitter, hyper-clinical psychological analysis where the Supreme Lord will brutally dismantle and expose the entire architecture of demonic thinking.
            Arjuna is firmly ordered to focus 100% of his cognitive bandwidth to listen and decode the exact toxic mentality of these evil entities who serve as the primary architects of global destruction.
        """.trimIndent()
    ),
    Shloka(
        id = 7,
        sanskrit = """
            प्रवृत्तिं च निवृत्तिं च जना न विदुरासुराः |
            न शौचं नापि चाचारो न सत्यं तेषु विद्यते || ७ ||
        """.trimIndent(),
        hindi = """
            आसुरी स्वभाव वाले दुष्ट मनुष्य यह बिल्कुल भी नहीं जानते कि उन्हें जीवन में कौन से सही काम करने चाहिए (प्रवृत्ति) और किन गलत कामों से दूर रहना चाहिए (निवृत्ति)।
            उनका नैतिक और आध्यात्मिक कंपास पूरी तरह से टूट चुका होता है जिससे वे धर्म और अधर्म के बीच का बुनियादी फर्क समझने में पूरी तरह अंधे हो जाते हैं।
            ऐसे दानवी मानसिकता वाले लोगों के भीतर न तो शरीर और मन की कोई बाहरी या भीतरी पवित्रता (शौच) ही कभी पाई जाती है।
            वे नहाने या साफ़ कपड़े पहनने के बावजूद अंदर से इतने गंदे होते हैं कि उनके दिमाग में हमेशा दूसरों को लूटने और धोखा देने के ही विचार चलते रहते हैं।
            उनमें किसी भी प्रकार का कोई सही आचरण या शिष्टाचार (आचार) नहीं होता क्योंकि वे समाज के सभी अच्छे नियमों और मर्यादाओं को पैरों तले रौंद देते हैं।
            सत्य नामक गुण तो उनके भीतर दूर-दूर तक मौजूद नहीं होता; उनका पूरा जीवन, उनका व्यापार और उनके रिश्ते केवल झूठ की एक बहुत गहरी नींव पर टिके होते हैं।
            वे अपनी स्वार्थी इच्छाओं को पूरा करने के लिए किसी भी हद तक गिर सकते हैं और बिना किसी शर्म के दिन-दहाड़े सफ़ेद झूठ बोलते हैं।
            भगवान यहाँ राक्षसी लोगों का सबसे पहला और सटीक मनोवैज्ञानिक एक्स-रे कर रहे हैं जो साबित करता है कि वे अंदर से कितने खोखले होते हैं।
            ऐसे लोग बाहर से बहुत अमीर या पढ़े-लिखे दिख सकते हैं लेकिन उनके कैरेक्टर का सॉफ्टवेयर पूरी तरह से वायरस से भरा और करप्ट होता है।
            सच्चाई, सफाई और सही व्यवहार के बिना इंसान वास्तव में इंसान कहलाने के लायक ही नहीं है, वह केवल एक दो पैरों वाला बुद्धिमान जानवर है।
        """.trimIndent(),
        english = """
            Those toxic humans deeply infected with the demoniac nature possess absolutely zero comprehension regarding what exact actions they should perform and which horrific actions they must violently avoid.
            Their internal moral and spiritual compass is completely shattered into microscopic dust, rendering them totally blind to the fundamental, biological difference between cosmic righteousness and catastrophic sin.
            Within such entities suffering from this demonic mentality, there is mathematically zero existence of any external bodily cleanliness or internal psychological purity (Shaucham).
            Despite wearing highly expensive luxury clothes and taking external showers, their internal hard drives are so heavily polluted that they constantly calculate toxic plots to deceive and violently exploit others.
            They exhibit absolutely no trace of proper civilized behavior or respectful etiquette (Achara), as they aggressively trample and ruthlessly crush every single noble rule and sacred boundary established by human society.
            The majestic quality of absolute truthfulness does not exist even in the most microscopic fraction within their corrupted souls; their entire biological existence, corporate empires, and personal relationships are built entirely on a foundation of massive lies.
            They will effortlessly stoop to the absolute lowest, most degraded depths simply to gratify their toxic selfish lusts, aggressively spitting blatant, bold-faced lies without experiencing a single microsecond of biological shame.
            The Supreme Lord is executing the absolute first, highly clinical psychological X-Ray of these demonic entities here, brutally proving exactly how pathetically hollow and rotting they are on the inside.
            These specific humans might externally appear as massively wealthy billionaires or elite university scholars, but their internal character software is 100% corrupted, heavily infested with the most lethal cosmic viruses.
            Without the foundational pillars of unadulterated truth, immaculate purity, and flawless righteous behavior, a human completely forfeits his right to be classified as human; he is officially downgraded to merely a highly intelligent, two-legged apex predator.
        """.trimIndent()
    ),
    Shloka(
        id = 8,
        sanskrit = """
            असत्यमप्रतिष्ठं ते जगदाहुरनीश्वरम् |
            अपरस्परसम्भूतं किमन्यत्कामहैतुकम् || ८ ||
        """.trimIndent(),
        hindi = """
            आसुरी प्रवृत्ति वाले लोग इस पूरी दुनिया को पूरी तरह से असत्य, बिना किसी ठोस आधार वाला और किसी भी ईश्वर या परम शक्ति से खाली मानते हैं।
            उनका यह भयंकर और मूर्खतापूर्ण दावा होता है कि इस ब्रह्मांड को बनाने वाला और इसे कंट्रोल करने वाला कोई सुप्रीम बॉस या भगवान मौजूद ही नहीं है।
            वे कहते हैं कि यह दुनिया किसी ईश्वरीय योजना से नहीं बल्कि केवल नर और मादा के आपस में मिलने और यौन इच्छाओं (काम) के कारण ही पैदा हुई है।
            उनकी सीमित और अंधी वैज्ञानिक सोच के अनुसार यह पूरी सृष्टि केवल रसायनों के एक रैंडम एक्सीडेंट या एक्सीडेंटल धमाके का ही नतीजा है।
            वे इस बात को मानने से साफ़ इंकार कर देते हैं कि इस अत्यंत जटिल और परफ़ेक्ट दुनिया के पीछे कोई बहुत बड़ी सुपर इंटेलिजेंस काम कर रही है।
            ऐसे नास्तिक लोग ब्रह्मांड के हर रहस्य को केवल अपनी वासना और भौतिक नियमों के चश्मे से ही देखते हैं और आध्यात्मिक ज्ञान का खुलेआम मज़ाक उड़ाते हैं।
            जब इंसान यह मान लेता है कि दुनिया का कोई ईश्वर नहीं है और कोई सज़ा देने वाला नहीं है, तो वह हर प्रकार के घिनौने पाप करने के लिए आज़ाद महसूस करता है।
            उनकी इस खतरनाक फिलॉसफी का एकमात्र उद्देश्य अपनी असीमित वासनाओं और गंदी इच्छाओं को सही साबित करने के लिए एक झूठा तर्क तैयार करना होता है।
            भगवान अर्जुन को समझा रहे हैं कि यह नास्तिकता कोई लॉजिक नहीं है बल्कि यह इंसान के घमंड और उसकी राक्षसी प्रकृति का सबसे बड़ा प्रमाण है।
            जो व्यक्ति इस अंधी और विनाशकारी सोच को पकड़ लेता है, वह खुद भी बर्बाद होता है और अपने आस-पास के समाज को भी नर्क बना देता है।
        """.trimIndent(),
        english = """
            Those individuals violently infected with the demoniac nature aggressively declare that this entire universe is completely unreal, devoid of any foundational basis, and entirely devoid of any Supreme God in control.
            They make the horrific and monumentally idiotic claim that there is absolutely no Supreme Boss, no intelligent designer, and no ultimate Creator engineering or managing this colossal cosmic simulation.
            They arrogantly theorize that this unimaginably complex multiverse was absolutely not produced by any divine master-plan, but arose entirely from random biological sexual union and blind, animalistic lust.
            According to their highly restricted, pitifully blind atheistic scientific models, this staggering creation is merely the accidental result of random chemical collisions and meaningless, spontaneous quantum explosions.
            They stubbornly and violently refuse to accept the obvious, mathematical reality that a massive, terrifyingly brilliant Super-Intelligence is actively operating behind the flawless perfection of this cosmic architecture.
            Such toxic atheists insist on viewing every profound mystery of the universe strictly through the narrow, dirty lens of their own biological lust and crude physics, aggressively mocking any advanced transcendental knowledge.
            The exact microsecond a human convinces himself that there is no Supreme Judge monitoring the system, he instantly feels a toxic, dangerous freedom to execute the most horrific, blood-curdling sins without fear of cosmic punishment.
            The absolute sole purpose behind inventing this dangerous, fake philosophical narrative is merely to artificially justify their own unlimited, filthy desires and to validate their ruthless, unrestricted hedonism.
            The Supreme Lord is explicitly explaining to Arjuna that this aggressive atheism is absolutely NOT high-level logic; it is the ultimate, undeniable proof of a human's bloated arrogance and deeply demonic internal software.
            Any person who passionately embraces this blind, destructive mindset mathematically guarantees his own catastrophic ruin while simultaneously transforming the surrounding human society into a literal, chaotic hellscape.
        """.trimIndent()
    ),
    Shloka(
        id = 9,
        sanskrit = """
            एतां दृष्टिमवष्टभ्य नष्टात्मानोऽल्पबुद्धयः |
            प्रभवन्त्युग्रकर्माणः क्षयाय जगतोऽहिताः || ९ ||
        """.trimIndent(),
        hindi = """
            इस प्रकार की नास्तिक और अंधी सोच का मजबूती से सहारा लेकर ये आसुरी लोग अपनी ही आत्मा का पूरी तरह से विनाश कर लेते हैं।
            भगवान इन्हें बहुत ही साफ शब्दों में 'अल्पबुद्धयः' यानी अत्यंत छोटी और नीच बुद्धि वाले मूर्ख इंसान कहकर पुकारते हैं जिनका दिमाग करप्ट हो चुका है।
            अपनी आत्मा को भूलकर ये लोग हमेशा अत्यंत उग्र, भयंकर और क्रूर कर्म करने में ही अपनी पूरी ताकत और समय बर्बाद करते रहते हैं।
            इनके द्वारा बनाए गए बड़े-बड़े कारखाने, हथियार और स्वार्थी प्रोजेक्ट्स केवल इस खूबसूरत दुनिया को तबाह करने के लिए ही काम आते हैं।
            ये लोग समाज के सबसे बड़े दुश्मन और दुनिया के लिए एक भयंकर कैंसर के समान पैदा होते हैं जिनका एकमात्र काम तबाही मचाना होता है।
            इनका सारा विज्ञान और इनकी सारी तरक्की प्रकृति को लूटने और अन्य कमज़ोर जीवों को कुचलकर अपना बैंक बैलेंस बढ़ाने में ही लगती है।
            जब इंसान के दिल से ईश्वर का डर और प्रेम निकल जाता है, तो वह एक ऐसा खूंखार जानवर बन जाता है जिसके हाथ में टेक्नोलॉजी की ताकत आ जाती है।
            ये लोग अपनी तथाकथित आधुनिक सफलता पर बहुत घमंड करते हैं लेकिन असल में वे पूरी मानव जाति को एक भयानक प्रलय की ओर धकेल रहे होते हैं।
            भगवान चेतावनी दे रहे हैं कि जिन लोगों का विज़न ही गलत और ज़हरीला हो गया है, उनके हर एक काम का रिज़ल्ट दुनिया के लिए सिर्फ नुकसानदायक ही होगा।
            ऐसे राक्षसी प्रवृत्ति वाले लोगों का अंत हमेशा बहुत ही दर्दनाक होता है क्योंकि वे ब्रह्मांड के प्राकृतिक संतुलन को तोड़ने की जुर्रत करते हैं।
        """.trimIndent(),
        english = """
            By firmly anchoring themselves to such a toxic, atheistic, and blind worldview, these demonic individuals completely and violently annihilate their own eternal souls.
            The Supreme Lord brutally and clinically brands them as 'Alpa-buddhayah'—pathetic, microscopic-brained fools whose entire psychological hardware has been deeply corrupted and fundamentally shattered.
            Having totally forgotten their divine spiritual identity, these entities continuously exhaust their entire biological timeline violently engaging in fierce, cruel, and highly aggressive, destructive activities.
            The massive industrial factories, apocalyptic nuclear weapons, and hyper-selfish corporate empires they fiercely build serve absolutely no purpose other than to violently annihilate this beautiful planetary ecosystem.
            These humans spawn into the matrix functioning exactly like a malignant, highly aggressive cosmic cancer, acting as the absolute greatest enemies of civilized society whose sole biological function is generating pure catastrophe.
            One hundred percent of their highly advanced science and technological progress is aggressively weaponized strictly to violently rape Mother Nature, brutally crush weaker entities, and exponentially inflate their own bloody bank accounts.
            When the paralyzing fear and profound love of God are permanently deleted from a human heart, that entity instantly mutates into a bloodthirsty apex predator terrifyingly armed with high-tech weapons of mass destruction.
            They arrogantly gloat over their so-called modern progress and elite economic successes, while in absolute reality, they are ruthlessly shoving the entire human race directly into a catastrophic, apocalyptic doomsday.
            The Lord issues a stern, mathematical warning: When an individual's core vision is heavily poisoned and fundamentally flawed, absolutely every single physical action they execute will inevitably generate massive collateral damage for the entire world.
            The ultimate destiny of such demonic, hyper-destructive entities is always mathematically guaranteed to be horrifically agonizing, simply because they arrogantly dared to violently violate the flawless, natural equilibrium of the cosmic matrix.
        """.trimIndent()
    ),
    Shloka(
        id = 10,
        sanskrit = """
            काममाश्रित्य दुष्पूरं दम्भमानमदान्विताः |
            मोहाद्गृहीत्वासद्ग्राहान्प्रवर्तन्तेऽशुचिव्रताः || १० ||
        """.trimIndent(),
        hindi = """
            ये आसुरी स्वभाव वाले लोग ऐसी भयंकर और कभी न बुझने वाली वासनाओं (काम) का आश्रय लेते हैं जिन्हें पूरा कर पाना कभी भी संभव ही नहीं है।
            वे अपने भीतर पाखंड (दम्भ), झूठे सम्मान की भूख (मान) और धन-दौलत के घमंड (मद) से हर समय बहुत बुरी तरह भरे रहते हैं।
            उनका दिमाग मोह और भ्रम में इतना अंधा हो चुका होता है कि वे हमेशा झूठे और विनाशकारी सिद्धांतों को ही सही मानकर कसकर पकड़ लेते हैं।
            वे कभी न खत्म होने वाली इच्छाओं को पूरा करने के लिए अत्यंत अपवित्र, गंदे और भ्रष्ट नियमों (अशुचिव्रताः) का पालन करते हुए काम करते हैं।
            उनके जीवन का कोई भी काम ईमानदारी से नहीं होता; वे सफलता पाने के लिए धोखा, भ्रष्टाचार और किसी भी प्रकार की नीचता करने से नहीं हिचकिचाते।
            उनका अहंकार इतना बड़ा होता है कि वे सोचते हैं कि उनके पैसे और पावर के आगे दुनिया की कोई भी ताकत और यहाँ तक कि भगवान भी कुछ नहीं है।
            वे आग में घी डालने की तरह अपनी वासनाओं को और भड़काते जाते हैं और एक ऐसी दौड़ में भागते हैं जिसका अंत केवल भयंकर डिप्रेशन और मौत है।
            उनके सारे संकल्प और व्रत केवल दूसरों को नुकसान पहुँचाने या अपना स्वार्थ सिद्ध करने के लिए ही होते हैं, उनमें कोई भी ईश्वरीय पवित्रता नहीं होती।
            यह श्लोक आज के भौतिकवादी समाज की उस अंधी दौड़ का परफेक्ट एक्स-रे है जहाँ इंसान अपनी शांति बेचकर केवल कचरा इकट्ठा करने में लगा हुआ है।
            भगवान कहते हैं कि जब इंसान की नींव ही अशुद्ध और झूठी हो, तो उस पर बनी हुई सफलता की पूरी इमारत एक न एक दिन भरभरा कर गिर ही जाती है।
        """.trimIndent(),
        english = """
            These demonic individuals actively seek shelter in horrific, insatiable, and violently burning lusts that are mathematically absolutely impossible to ever completely satisfy.
            Their entire psychological operating system is constantly overflowing and heavily bloated with toxic hypocrisy, a pathetic hunger for false prestige, and the blinding arrogance of massive wealth.
            Their brains are so severely paralyzed by deep delusion and blinding illusion that they aggressively grasp onto completely fake, destructive, and toxic ideologies, falsely parading them as ultimate truths.
            Desperately driven to fulfill these never-ending, highly toxic cravings, they continuously engage in profoundly impure, filthy, and highly corrupted vows and unholy practices.
            Absolutely nothing they execute in their biological lifespan is grounded in genuine honesty; they eagerly deploy fraud, massive corruption, and the lowest forms of deceit without a microsecond of hesitation just to achieve cheap success.
            Their false ego is so colossally inflated that they arrogantly hallucinate their puny bank accounts and political power can effortlessly crush any opposing force in the universe, including God Himself.
            They perpetually pour gallons of highly flammable gasoline onto the raging fire of their own lust, aggressively sprinting in a pathetic rat race that mathematically ends only in severe clinical depression and brutal death.
            Every single intense resolution and strict vow they undertake is explicitly engineered solely to inflict massive damage on others or aggressively secure their own selfish agendas, possessing zero traces of divine purity.
            This spectacular verse acts as a flawless, high-definition X-Ray deeply exposing the blind, frantic hustle of modern materialistic society, where humans literally auction off their permanent mental peace just to hoard temporary garbage.
            The Lord declares an iron-clad cosmic rule: When the very foundation of a human's existence is highly impure, toxic, and built on lies, the entire towering skyscraper of his fake success is mathematically guaranteed to violently collapse into dust.
        """.trimIndent()
    ),
    Shloka(
        id = 11,
        sanskrit = """
            चिन्तामपरिमेयां च प्रलयान्तामुपाश्रिताः |
            कामोपभोगपरमा एतावदिति निश्चिताः || ११ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 11 और 12 एक ही आसुरी मानसिकता का हिस्सा हैं)
            ये आसुरी लोग अपने मन में ऐसी असीमित और भयंकर चिंताओं का आश्रय लेते हैं जो उनके मरने (प्रलय) के दिन तक भी कभी खत्म नहीं होती हैं।
            उनका दिमाग 24 घंटे केवल पैसे कमाने, अपनी गद्दी बचाने और अपनी वासनाओं को पूरा करने के भयानक स्ट्रेस और ओवरथिंकिंग में जला करता है।
            उन्होंने अपने जीवन का यह पक्का और अटल सिद्धांत बना लिया होता है कि इन्द्रियों को भोगना और मजे करना ही मनुष्य जीवन का सबसे बड़ा और आखिरी लक्ष्य है।
            उनके अनुसार इस भौतिक सुख के अलावा इस दुनिया में और कुछ भी सत्य नहीं है और अध्यात्म या भगवान जैसी बातें केवल बेवकूफों के लिए हैं।
            वे सोचते हैं कि 'खाओ, पिओ और ऐश करो क्योंकि कल किसने देखा है', और इसी गंदी फिलॉसफी के कारण वे जीवन भर एक मशीन की तरह गधों वाली मेहनत करते हैं।
            उनका सारा पैसा और पावर भी उनके दिमाग की इस अपार चिंता (एंग्ज़ायटी) को एक पल के लिए भी शांत नहीं कर पाता, वे हमेशा एक खौफ में जीते हैं।
            वे अपनी ही बनाई हुई इन इच्छाओं की जेल में इतने बुरी तरह फँस जाते हैं कि उन्हें अपनी सांसों के खत्म होने तक भी एक अच्छी और सुकून की नींद नसीब नहीं होती।
            भगवान यहाँ बता रहे हैं कि जो इंसान केवल भौतिक सुखों को अपना भगवान बना लेता है, उसे असल में कभी सुख नहीं मिलता, बल्कि उसे केवल भयंकर चिंताएं ही मिलती हैं।
            यह श्लोक साबित करता है कि आसुरी लोगों का जीवन बाहर से चाहे कितना भी लग्जरी और शानदार क्यों न दिखे, अंदर से वह एक जलता हुआ नर्क ही होता है।
            जीवन का असली उद्देश्य आनंद है, लेकिन वे इस आनंद को गलत जगह ढूँढते हैं और अंत में मौत उनके सारे झूठे सुखों को एक झटके में छीन लेती है।
        """.trimIndent(),
        english = """
            (Verses 11 and 12 form a continuous description of the demonic psychology)
            These demonic entities actively take shelter in an unimaginably massive, infinite ocean of paralyzing anxieties that absolutely never cease until the exact microsecond of their death.
            Their overheated brains violently burn 24/7 in a horrific state of chronic stress and toxic overthinking, desperately calculating how to hoard more billions, violently protect their thrones, and fulfill their filthy lusts.
            They have permanently hardwired their psychological software with the absolute, unshakeable conviction that aggressively gratifying the physical senses and enjoying material pleasure is the supreme and final goal of human existence.
            According to their highly degraded, pathetic philosophy, absolutely nothing exists in reality beyond this cheap physical pleasure, and concepts like spirituality or God are merely pathetic fairy tales invented for fools.
            They rigorously operate on the toxic biological slogan "Eat, drink, and violently party, for tomorrow we die," and driven by this filthy ideology, they brutally slave away exactly like mindless machines for their entire lives.
            Even their massive, billion-dollar bank accounts and supreme political power mathematically fail to pacify their roaring internal anxiety for even a single microsecond; they perpetually live in a state of sheer, paralyzing paranoia.
            They become so hopelessly and violently trapped inside the suffocating prison of their own manufactured desires that they are brutally denied even a single night of genuine, peaceful sleep until their very last breath expires.
            The Lord is explicitly demonstrating that any human who elevates cheap biological pleasure to the status of God absolutely never actually achieves happiness; he strictly receives a guaranteed, crushing avalanche of severe anxiety.
            This spectacular verse mathematically proves that regardless of how outrageously luxurious and glamorous a demon's external lifestyle appears on social media, internally, his brain is a violently burning, agonizing hellscape.
            The true biological purpose of existence is ultimate bliss, but because they desperately hunt for it in the wrong, toxic dimensions, Death eventually arrives like a brutal assassin, violently confiscating all their fake joys in one stroke.
        """.trimIndent()
    ),
    Shloka(
        id = 12,
        sanskrit = """
            आशापाशशतैर्बद्धाः कामक्रोधपरायणाः |
            ईहन्ते कामभोगार्थमन्यायेनार्थसञ्चयान् || १२ ||
        """.trimIndent(),
        hindi = """
            ये आसुरी लोग सैंकड़ों और हज़ारों कभी पूरी न होने वाली आशाओं और उम्मीदों के मजबूत जालों (पाश) में बहुत ही बुरी तरह से बंधे और जकड़े रहते हैं।
            वे 24 घंटे केवल काम (वासना) और क्रोध (गुस्सा) के ही पूरी तरह से गुलाम बनकर अपना पूरा जीवन इन्हीं घटिया भावनाओं में जीते हैं।
            अपनी इन गंदी और स्वार्थी इन्द्रिय-वासनाओं को किसी भी कीमत पर पूरा करने के लिए वे पागलों की तरह हर समय छटपटाते रहते हैं।
            और इन्हीं भोगों का मज़ा लूटने के लिए वे अन्याय, बेईमानी और धोखे के रास्तों से बहुत सारा काला धन और संपत्ति इकट्ठा करने की जी-तोड़ कोशिश करते हैं।
            उन्हें इस बात से कोई फर्क नहीं पड़ता कि उनका बैंक बैलेंस भरने से कितने गरीबों का नुकसान हो रहा है या समाज कितना बर्बाद हो रहा है।
            वे रिश्वत, चोरी, करप्शन और हर प्रकार के क्राइम को अपना जन्मसिद्ध अधिकार मानते हैं क्योंकि उनका अंतिम लक्ष्य केवल अपना पेट और खजाना भरना होता है।
            इनकी इच्छाएं कभी खत्म नहीं होतीं; अगर इन्हें दुनिया का सारा पैसा भी दे दिया जाए, तो भी अगले दिन ये कुछ और पाने के लिए फिर से किसी को धोखा देंगे।
            आशाओं का यह जाल मकड़ी के उस जाले की तरह है जिसमें यह इंसान खुद ही फँसता चला जाता है और अंत में उसी में घुटकर मर जाता है।
            भगवान अर्जुन को समझा रहे हैं कि जहाँ काम और क्रोध होता है, वहाँ इंसान की बुद्धि मर जाती है और वह अन्याय के रास्ते पर चलने के लिए मजबूर हो जाता है।
            यह श्लोक आज के करप्ट सिस्टम और लालची अपराधियों की मानसिकता का एक बहुत ही परफेक्ट और सटीक मनोवैज्ञानिक विश्लेषण प्रस्तुत करता है।
        """.trimIndent(),
        english = """
            These demonic individuals are violently and hopelessly bound by a suffocating network containing hundreds of thousands of unbreakable, toxic ropes of insatiable hopes and endless expectations.
            They operate their entire biological timelines existing strictly as pathetic, heavily chained slaves completely dominated by roaring lust (Kama) and explosive anger (Krodha) 24/7.
            In order to violently gratify these filthy, selfish, and aggressive sensory desires at absolutely any cost, they constantly writhe in a state of frantic, manic desperation.
            And purely to fund and finance this horrific sensory enjoyment, they aggressively endeavor to hoard massive mountains of illegal wealth strictly through brutally unjust, dishonest, and highly corrupt means.
            Their cold, dead hearts mathematically register zero empathy regarding how many innocent lives are brutally crushed or how much society is severely damaged just to artificially inflate their offshore bank accounts.
            They arrogantly embrace massive bribery, corporate theft, deep corruption, and hardcore crime as their fundamental birthright, simply because their absolute sole objective is stuffing their bellies and expanding their treasuries.
            Their biological desires possess absolutely zero limits; even if you handed them the entire physical wealth of the multiverse today, they would instantly plot to ruthlessly scam someone else tomorrow for more.
            This massive, terrifying network of hopes operates exactly like a giant, sticky spiderweb; the human actively spins it, violently entangles himself in it, and eventually suffocates to a pathetic death right inside it.
            The Lord is explicitly teaching Arjuna that wherever toxic lust and explosive anger aggressively dominate, human intelligence is instantly assassinated, violently forcing the entity to sprint down the dark highway of sheer injustice.
            This spectacular verse delivers an absolutely flawless, hyper-accurate psychological X-Ray perfectly exposing the deeply corrupted mindset of modern greedy criminals and highly toxic, exploitative systems.
        """.trimIndent()
    ),
    Shloka(
        id = 13,
        sanskrit = """
            इदमद्य मया लब्धमिमं प्राप्स्ये मनोरथम् |
            इदमस्तीदमपि मे भविष्यति पुनर्धनम् || १३ ||
        """.trimIndent(),
        hindi = """
            (श्लोक 13 से 15 तक एक आसुरी व्यक्ति की आंतरिक सोच और उसके डायलॉग्स का सजीव वर्णन है)
            वह आसुरी और लालची इंसान अपने मन ही मन अहंकार में सोचता है कि "आज मैंने यह इतनी बड़ी संपत्ति और सफलता हासिल कर ली है।"
            "और अब मैं अपनी इस फलां बड़ी इच्छा या अपने अगले बड़े टारगेट को भी अपनी इसी ताकत और चालाकी से बहुत जल्द ही प्राप्त कर लूँगा।"
            "मेरे पास अभी इतना सारा पैसा, बैंक बैलेंस और प्रॉपर्टी पहले से ही मौजूद है जिसे दुनिया में कोई भी मुझसे छीन नहीं सकता।"
            "और भविष्य में मेरे इन चालाक प्रोजेक्ट्स से यह धन और भी ज्यादा बढ़ जाएगा तथा मैं दुनिया का सबसे अमीर इंसान बन जाऊंगा।"
            यह श्लोक एक ऐसे घमंडी इंसान का 'माइंड-रीडिंग' (Mind-reading) है जो केवल 'मैं' और 'मेरा' की भयंकर बीमारी से बुरी तरह पीड़ित है।
            वह अपनी हर सफलता का पूरा क्रेडिट केवल और केवल अपनी मेहनत और अपने शातिर दिमाग को देता है, भगवान की कृपा को वह पूरी तरह खारिज कर देता है।
            उसके दिमाग का सॉफ्टवेयर हमेशा एक कैलकुलेटर की तरह काम करता है जो 24 घंटे केवल प्रॉफिट, ग्रोथ और बैंक बैलेंस के आंकड़े गिनता रहता है।
            वह कभी इस बात पर विचार नहीं करता कि यह सारा पैसा और सफलता मौत के दिन यहीं इस मिट्टी में पड़ी रह जाएगी।
            उसे लगता है कि वह इस दुनिया का परमानेंट निवासी है और उसका साम्राज्य कभी खत्म नहीं होगा, जो कि उसका सबसे बड़ा और बेवकूफी भरा भ्रम है।
            ईश्वर इंसान की इस 'मैं कर रहा हूँ' वाली सोच पर हँसते हैं क्योंकि इंसान अगले पल की साँस भी खुद अपनी मर्जी से नहीं ले सकता।
        """.trimIndent(),
        english = """
            (Verses 13 through 15 vividly broadcast the exact, highly toxic internal monologues and arrogant psychology of a demonic entity)
            The demonic, fiercely greedy human arrogantly calculates within his severely bloated ego, thinking, "Today, I have successfully acquired this massive amount of wealth and achieved this staggering milestone."
            "And utilizing my sheer, unbeatable brilliance and cunning strategy, I shall aggressively conquer my next massive target and fulfill this specific desire very soon."
            "I currently possess this enormous, untouchable mountain of cash, massive bank balances, and prime real estate that absolutely no force on earth can ever take away from me."
            "And in the near future, my highly aggressive corporate investments will exponentially multiply this wealth even further, mathematically guaranteeing my status as the richest entity alive."
            This spectacular verse acts as a flawless, high-definition 'Mind-Reading' scan of an arrogant mortal violently infected with the terminal, psychological cancer of "I" and "Mine".
            He ruthlessly claims 100% of the absolute credit for every single success, attributing it entirely to his own brutal hustle and genius brain, completely and aggressively denying any involvement of God's mercy.
            His corrupted psychological software functions exactly like a frantic, overheated calculator, running 24/7 strictly to process profit margins, compound growth, and digital bank balances.
            He is biologically incapable of pausing to realize the terrifying mathematical fact that 100% of this hoarded cash and empire will be violently abandoned in the dirt on the exact day his heartbeat flatlines.
            He pathetically hallucinates that he is a permanent, immortal resident of this physical matrix and that his corporate empire will reign eternally, which is the absolute peak of biological stupidity and delusion.
            The Supreme Creator silently laughs at this pathetic mortal screaming "I am the doer," knowing perfectly well that the arrogant human cannot even guarantee his very next biological breath without cosmic permission.
        """.trimIndent()
    ),
    Shloka(
        id = 14,
        sanskrit = """
            असौ मया हतः शत्रुर्हनिष्ये चापरानपि |
            ईश्वरोऽहमहं भोगी सिद्धोऽहं बलवान्सुखी || १४ ||
        """.trimIndent(),
        hindi = """
            वह आसुरी इंसान अपने खौफनाक अहंकार में डूबकर सोचता है कि "मैंने अपने उस फलां बड़े शत्रु (दुश्मन) को तो पूरी तरह से मार कर खत्म कर दिया है।"
            "और जो बाकी बचे हुए मेरे विरोधी या दुश्मन हैं, उन्हें भी मैं अपनी इस असीम ताकत और पावर के बल पर बहुत जल्द ही कुचल कर मार डालूँगा।"
            "मैं ही इस पूरी दुनिया का सबसे बड़ा बॉस और साक्षात् ईश्वर हूँ; यह सब कुछ मेरे ही इशारों पर चलता है और मैं ही सब सुखों को भोगने वाला हूँ।"
            "मैं अपने आप में पूरी तरह से परफेक्ट (सिद्ध) हूँ, मेरे पास दुनिया की सबसे बड़ी ताकत है और मैं ही इस ब्रह्मांड का सबसे सुखी इंसान हूँ।"
            यहाँ भगवान एक डिक्टेटर (Dictator) या एक खूंखार क्रिमिनल की साइकोलॉजी (Psychology) का बिल्कुल सीधा और पारदर्शी एक्स-रे दुनिया के सामने रख रहे हैं।
            जब इंसान के पास बहुत ज़्यादा पैसा और पावर आ जाती है तो उसका दिमाग खराब हो जाता है और वह खुद को भगवान (ईश्वरोऽहम्) समझने लगता है।
            वह सोचता है कि वह पैसे के दम पर कानून खरीद सकता है, किसी को भी रास्ते से हटा सकता है और दुनिया की हर चीज़ को अपने पैरों तले दबा सकता है।
            उसका यह घमंड ("सिद्धोऽहं बलवान्सुखी") एक ऐसे गुब्बारे की तरह है जिसमें अज्ञानता की गैस भरी है, जिसे मौत की एक छोटी सी सुई पल भर में फोड़ देती है।
            रावण, कंस और हिरण्यकशिपु जैसे बड़े-बड़े राक्षसों का डायलॉग भी बिल्कुल यही था कि "मेरे सिवा दुनिया में कोई और ईश्वर है ही नहीं।"
            लेकिन इतिहास गवाह है कि जब भगवान का थप्पड़ पड़ता है तो ऐसे लोगों की सारी ताकत, उनका सारा घमंड और उनका शरीर मिट्टी में मिल कर राख हो जाता है।
        """.trimIndent(),
        english = """
            The demonic human, completely drowning in his terrifyingly toxic arrogance, aggressively thinks, "I have already successfully crushed and violently assassinated that specific massive enemy of mine."
            "And as for any remaining rivals or competitors who dare to stand in my way, I shall effortlessly slaughter and annihilate them very soon using my limitless, unstoppable power."
            "I am the absolute, undisputed Supreme Boss and the literal Lord of this entire world; absolutely everything operates strictly on my commands, and I am the ultimate enjoyer of all pleasures."
            "I am completely flawless and perfectly successful (Siddha) in every endeavor, I possess the most terrifying physical strength on earth, and I am the absolute happiest man alive."
            Here, the Supreme Lord exposes the exact, transparent, and terrifying psychological X-Ray of a ruthless, bloodthirsty Dictator or a highly dangerous, arrogant mafia boss.
            When an ignorant mortal accidentally acquires a massive overdose of cheap paper money and political power, his fragile brain violently crashes, forcing him to hallucinate that he is literally God ("Ishvaro 'ham").
            He arrogantly operates under the toxic delusion that he can effortlessly purchase the legal system, physically eliminate any opposition, and brutally crush the entire planet under his expensive shoes.
            His staggering, bloated pride ("Siddho 'ham balavan sukhi") functions exactly like a massive balloon heavily inflated with the toxic gas of pure ignorance, which the tiny, sharp needle of Death will violently pop in a microsecond.
            Legendary, apocalyptic cosmic terrorists like Ravana, Kamsa, and Hiranyakashipu aggressively screamed this exact same pathetic dialogue, fiercely demanding, "There is absolutely no God in existence other than ME!"
            But objective cosmic history stands as the ultimate, brutal witness: when the Supreme Lord finally delivers His invisible, apocalyptic slap, all their terrifying power, bloated arrogance, and biological bodies are instantaneously reduced to worthless ash.
        """.trimIndent()
    ),
    Shloka(
        id = 15,
        sanskrit = """
            आढ्योऽभिजनवानस्मि कोऽन्योऽस्ति सदृशो मया |
            यक्ष्ये दास्यामि मोदिष्य इत्यज्ञानविमोहिताः || १५ ||
        """.trimIndent(),
        hindi = """
            वह घमंडी और आसुरी व्यक्ति सोचता है कि "मैं दुनिया का सबसे अमीर इंसान हूँ और मेरा जन्म एक बहुत ही बड़े, रसूखदार और वीआईपी खानदान में हुआ है।"
            "इस पूरी दुनिया में मेरे बराबर का महान, शक्तिशाली और अमीर आदमी दूसरा और कौन हो सकता है? मेरी किसी से कोई तुलना ही नहीं है!"
            "मैं अपने नाम और शोहरत को और चमकाने के लिए बहुत बड़े-बड़े यज्ञ (इवेंट्स) करूँगा, लोगों को खूब दान दूँगा और जीवन के खूब मज़े लूटूँगा।"
            इस प्रकार वे लोग पूरी तरह से अज्ञानता के भयंकर अंधेरे और मोह के जाल में बहुत ही बुरी तरह से फँसे और भटके हुए रहते हैं (अज्ञानविमोहिताः)।
            यह श्लोक 'दिखावे की चैरिटी' (Fake Charity) और 'ईगो-ड्रिवेन इवेंट्स' (Ego-driven Events) का सबसे बड़ा और कड़वा सच दुनिया के सामने खोलता है।
            आजकल के कई अरबपति और नेता लोग जो करोड़ों का दान देते हैं या मंदिर बनाते हैं, वे यह सब भगवान को खुश करने के लिए बिल्कुल नहीं करते।
            वे यह सब केवल अपना 'पीआर' (PR) चमकाने, न्यूज़पेपर में अपनी फोटो छपवाने और दुनिया को यह दिखाने के लिए करते हैं कि "मुझसे बड़ा दानी कोई नहीं है।"
            उनका वह दान और पूजा (यक्ष्ये दास्यामि) भी केवल उनके घमंड का एक बहुत बड़ा और भद्दा 'शो-ऑफ' (Show-off) होता है जिसमें कोई ईश्वरीय पवित्रता नहीं होती।
            वे अज्ञानता में यह भूल जाते हैं कि जिस पैसे का वे घमंड कर रहे हैं, वह पैसा भी प्रकृति ने ही उन्हें कुछ समय के लिए उधार दिया है।
            भगवान श्रीकृष्ण ऐसे लोगों के सारे पुण्य और दान को 'जीरो' (Zero) करार देते हैं क्योंकि जहाँ स्वार्थ और अहंकार होता है, वहाँ भगवान कभी नहीं टिकते।
        """.trimIndent(),
        english = """
            The insanely arrogant, demonic entity thinks to himself, "I am the absolute wealthiest multi-billionaire alive, and I was biologically born into a highly prestigious, elite, and VIP aristocratic bloodline."
            "Who else in this entire multiverse could possibly even mathematically attempt to match my staggering greatness, limitless power, and infinite wealth? I am completely beyond comparison!"
            "I shall actively host massive, mega-expensive sacrifices (events), I shall aggressively throw millions in charity to the poor, and thereby I shall violently rejoice and inflate my glorious legacy."
            In this exact, pathetic manner, such highly toxic individuals remain completely and hopelessly deluded, violently paralyzed by the dense, blinding darkness of sheer ignorance (Ajnana-vimohitah).
            This spectacular verse violently rips the mask off the absolute biggest, most bitter reality regarding 'Fake Charity' and massive 'Ego-Driven Corporate Philanthropy'.
            Many modern, toxic billionaires and corrupt politicians who aggressively donate millions or build massive religious temples absolutely do NOT execute these actions to genuinely please God.
            They execute these massive financial stunts strictly to aggressively polish their public relations (PR) image, plaster their arrogant faces on global magazine covers, and ruthlessly scream to the matrix, "Absolutely no one is a greater savior than ME."
            Their so-called massive charity and religious rituals ('Yakshye Dasyami') are literally nothing more than a vulgar, highly toxic 'Show-Off' of their bloated ego, containing mathematically zero drops of divine purity.
            In their blinding ignorance, they tragically forget that the specific cash they are arrogantly flaunting is merely a highly temporary cosmic loan issued strictly by Mother Nature, destined to be repossessed at death.
            Lord Sri Krishna brutally and officially categorizes all their massive pious acts and billion-dollar donations as absolute 'Zero', because wherever toxic selfishness and bloated ego exist, the Supreme Lord absolutely refuses to be present.
        """.trimIndent()
    ),
    Shloka(
        id = 16,
        sanskrit = """
            अनेकचित्तविभ्रान्ता मोहजालसमावृताः |
            प्रसक्ताः कामभोगेषु पतन्ति नरकेऽशुचौ || १६ ||
        """.trimIndent(),
        hindi = """
            इस प्रकार अनेक प्रकार की भयंकर चिंताओं और ख्यालों में बहुत बुरी तरह से भटके हुए और मोह (इल्यूज़न) के घने जाल में पूरी तरह से जकड़े हुए।
            अपनी इन्द्रियों की कभी न बुझने वाली वासनाओं और सांसारिक सुखों को भोगने में अत्यंत गहराई और पागलपन से डूबे हुए वे आसुरी लोग...
            अंततः मृत्यु के बाद अत्यंत अपवित्र, गंदे और भयंकर दुखों से भरे हुए नर्कों (नरकेऽशुचौ) में सीधे जाकर गिर पड़ते हैं।
            यह श्लोक उन घमंडी और लालची लोगों (जिनका वर्णन पिछले श्लोकों में था) का 'फाइनल डेस्टिनेशन' (Final Destination / अंतिम परिणाम) घोषित करता है।
            वे सोचते थे कि वे दुनिया के बॉस हैं, लेकिन असल में उनका मन ('अनेकचित्त') एक सेकंड के लिए भी शांत नहीं था, वह हमेशा हज़ारों लालच और डरों में भटकता रहता था।
            मोह का जाल (मोहजाल) एक ऐसे मकड़ी के जाले की तरह होता है जिसमें इंसान जितना ज्यादा फड़फड़ाता है और पैसे कमाता है, वह उतना ही ज्यादा उसमें फँसता चला जाता है।
            वे अपनी पूरी ज़िंदगी केवल अपनी स्किन (Skin) और जीभ के सुखों ('कामभोगेषु') को शांत करने की एक अंधी और बेवकूफी भरी रेस में बर्बाद कर देते हैं।
            लेकिन ब्रह्मांड का न्याय सिस्टम (Justice System) अंधा नहीं है; मौत के बाद ऐसे लोगों को किसी वीआईपी लाउंज में नहीं बल्कि सीधे एक सड़े हुए गंदे नर्क में धकेल दिया जाता है।
            यह नर्क कोई काल्पनिक जगह नहीं है, यह ब्रह्मांड का वह डस्टबिन (Dustbin) है जहाँ उन आत्माओं को रिसाइकिल (Recycle) होने के लिए डाला जाता है जो इंसान कहलाने के लायक नहीं रहीं।
            भगवान की यह चेतावनी इंसान के अहंकार को चकनाचूर करने के लिए काफी है कि तुम्हारे पैसों का साम्राज्य तुम्हें मौत के बाद की सजा से कभी नहीं बचा सकता।
        """.trimIndent(),
        english = """
            Thus continuously violently perplexed by hundreds of thousands of terrifying anxieties and completely enveloped by the dense, suffocating network of material illusion.
            And remaining insanely, hopelessly, and aggressively addicted to the relentless pursuit of sensory gratification and toxic biological lusts, these demonic individuals...
            ultimately violently plummet and crash directly into the most foul, highly impure, and agonizing hellish dimensions (Narake 'shuchau) immediately following their physical death.
            This spectacular verse officially broadcasts the absolute, terrifying 'Final Destination' and ultimate cosmic consequence awaiting those arrogant, greedy titans described in the previous verses.
            They arrogantly hallucinated they were the supreme bosses of earth, but in brutal reality, their fractured minds ('Aneka-chitta') lacked even a microsecond of peace, perpetually violently vibrating with thousands of toxic cravings and deep paranoia.
            The dense network of illusion (Moha-jala) operates exactly like a terrifying, cosmic spiderweb; the more aggressively the arrogant human struggles and hoards cash, the more violently and hopelessly entangled he becomes in its sticky threads.
            They pathetically exhaust their entire precious biological timeline desperately sprinting in a blind, idiotic rat race solely to pacify the screaming demands of their physical skin and tongues ('Kama-bhogeshu').
            But the universe's ultimate Justice System is absolutely not blind; upon biological expiration, these toxic entities are strictly denied VIP celestial lounges and are ruthlessly kicked straight down into a rotting, foul, and terrifying hellscape.
            This hell is absolutely not a mythical fairy tale; it is the official, terrifying cosmic 'Dustbin' where severely degraded, toxic souls are brutally dumped to be forcefully recycled back into the lowest animalistic species.
            The Supreme Lord's chilling warning serves as a titanium hammer to smash human arrogance, proving mathematically that your billion-dollar earthly empire possesses zero jurisdiction to save you from brutal cosmic punishment after your heartbeat stops.
        """.trimIndent()
    ),
    Shloka(
        id = 17,
        sanskrit = """
            आत्मसम्भाविताः स्तब्धा धनमानमदान्विताः |
            यजन्ते नामयज्ञैस्ते दम्भेनाविधिपूर्वकम् || १७ ||
        """.trimIndent(),
        hindi = """
            वे आसुरी लोग अपने आप को ही सबसे श्रेष्ठ और महान मानते हैं (आत्मसम्भाविताः), वे अत्यंत घमंडी और किसी के आगे न झुकने वाले (स्तब्धा) होते हैं।
            वे हमेशा धन-दौलत के नशे और झूठे मान-सम्मान के अहंकार में पूरी तरह से अंधे होकर पागल रहते हैं (धनमानमदान्विताः)।
            ऐसे लोग केवल अपना नाम चमकाने और दुनिया को दिखाने के लिए तथाकथित 'नाम-मात्र के यज्ञ' (नामयज्ञैः) बहुत ही पाखंड (दम्भ) के साथ करते हैं।
            और वे इन यज्ञों को शास्त्रों में बताए गए सही नियमों और विधियों को पूरी तरह से लात मारकर बिना किसी नियम के (अविधिपूर्वकम्) करते हैं।
            भगवान यहाँ 'करप्ट स्पिरिचुअलिटी' (Corrupt Spirituality / दिखावे की धार्मिकता) का सबसे कड़वा और नंगा सच दुनिया के सामने ला रहे हैं।
            कई अमीर लोग भगवान की पूजा इसलिए नहीं करते कि वे भगवान से प्यार करते हैं, बल्कि इसलिए करते हैं ताकि समाज में उनका स्टेटस (Status) और रुतबा बढ़ सके।
            उनके यज्ञ और दान केवल एक 'पीआर स्टंट' (PR Stunt) होते हैं, जिनमें करोड़ों रुपए खर्च किए जाते हैं लेकिन अंदर रत्ती भर भी श्रद्धा या प्यार नहीं होता।
            वे शास्त्रों के नियमों (विधियों) को मानने से साफ़ इंकार कर देते हैं क्योंकि उनका अहंकार उन्हें किसी नियम के आगे झुकने की इजाज़त ही नहीं देता।
            वे भगवान को भी अपने पैसों से खरीदने और रिश्वत देने की कोशिश करते हैं, जो कि इंसान के अज्ञान की सबसे निचली और घटिया सीमा है।
            ईश्वर ऐसे पाखंडी और घमंडी अनुष्ठानों को सीधे तौर पर 'अवैध' (Invalid) और ज़ीरो (Zero) घोषित करते हैं, क्योंकि भगवान केवल सच्चे भाव के भूखे हैं, तुम्हारे पैसों के नहीं।
        """.trimIndent(),
        english = """
            These demonic individuals are entirely self-complacent, fiercely overestimating their own greatness (Atma-sambhavitah), and remain stiff, arrogant, and utterly unbowing (Stabdha).
            They are perpetually blinded, heavily intoxicated, and violently mad with the massive delusion generated by immense wealth and toxic false prestige (Dhana-mana-madanvitah).
            Such toxic humans aggressively perform so-called massive sacrifices merely in name only (Nama-yajnaih), executing them with extreme hypocrisy and purely for show (Dambhena).
            And they execute these massively expensive rituals by aggressively kicking aside and completely ignoring all the proper rules, regulations, and exact procedures strictly enjoined by the authentic scriptures (Avidhi-purvakam).
            The Lord is brutally ripping the mask off the absolute ugliest, naked truth regarding 'Corrupt Spirituality' and highly toxic, theatrical religious hypocrisy here.
            Many arrogant billionaires and corrupt elites absolutely do not worship God out of genuine, unadulterated love; they execute massive religious events strictly to exponentially inflate their social status and political clout.
            Their billion-dollar sacrifices and massive charity stunts are literally nothing but heavily funded, ego-driven 'PR Stunts', packed with expensive decorations but containing mathematically zero drops of pure devotion or authentic faith.
            They violently and stubbornly refuse to submit to the authorized, strict protocols (Vidhi) mapped out in the scriptures because their bloated, toxic egos biologically prevent them from bowing down to any higher systemic authority.
            They pathetically attempt to bribe, purchase, and manipulate the Supreme Creator Himself using their cheap earthly cash, which represents the absolute lowest, most degraded benchmark of human stupidity and ignorance.
            The Supreme Godhead officially and aggressively invalidates all such hypocritical, arrogant rituals, categorizing them as absolute 'Zero', proving that the Lord strictly hungers exclusively for pure, unadulterated love, absolutely never for your pathetic paper wealth.
        """.trimIndent()
    ),
    Shloka(
        id = 18,
        sanskrit = """
            अहङ्कारं बलं दर्पं कामं क्रोधं च संश्रिताः |
            मामात्मपरदेहेषु प्रद्विषन्तोऽभ्यसूयकाः || १८ ||
        """.trimIndent(),
        hindi = """
            वे आसुरी स्वभाव वाले लोग अपने झूठे अहंकार, अपनी शारीरिक और पैसे की ताकत (बल), अपने घमंड (दर्प), अपनी वासना (काम) और अपने भयंकर गुस्से (क्रोध) का पूरी तरह आश्रय लिए रहते हैं।
            इन भयंकर बीमारियों से ग्रस्त होकर वे दूसरों में हमेशा कमियां और दोष ही ढूँढते रहते हैं (अभ्यसूयकाः)।
            और इसी अज्ञान के कारण वे अपने स्वयं के शरीर में और दूसरों के शरीरों में भी स्थित 'मुझ परमात्मा' से भयंकर नफरत और द्वेष (प्रद्विषन्तो) करने लगते हैं।
            यह श्लोक 'नास्तिकता और हिंसा' (Atheism and Violence) की असली मनोवैज्ञानिक जड़ (Psychological Root) को पूरी तरह से डिकोड करता है।
            जब इंसान के अंदर ईगो (Ego), पावर और लस्ट (Lust) बहुत ज्यादा बढ़ जाती है, तो उसे यह बर्दाश्त नहीं होता कि इस दुनिया में उससे भी बड़ा कोई 'सुप्रीम गॉड' (Supreme God) मौजूद है।
            इसलिए वह भगवान की सत्ता को चुनौती देने लगता है और ईश्वर से ही जलने और नफरत करने लगता है (जैसे हिरण्यकशिपु ने किया था)।
            भगवान बहुत गहरी बात कहते हैं कि जब तुम किसी दूसरे इंसान को मारते हो या उसे बिना वजह दुःख देते हो, तो तुम उस इंसान को नहीं मार रहे होते।
            तुम वास्तव में उस इंसान के दिल में बैठे हुए 'मुझ साक्षात् परमेश्वर' से ही दुश्मनी मोल ले रहे हो और मेरा ही अपमान कर रहे हो।
            जो इंसान खुद को शराब या गंदे व्यसनों से बर्बाद करता है, वह भी अपने शरीर में बैठे भगवान से नफरत ही कर रहा होता है।
            इसलिए दुनिया के हर जीव का सम्मान करना ही ईश्वर की सबसे बड़ी और सच्ची पूजा है, और दूसरों को सताना ईश्वर से सीधा युद्ध करने के बराबर है।
        """.trimIndent(),
        english = """
            These demonic entities take complete, toxic shelter of their massive false ego, their brutal physical and financial strength (Balam), their blinding arrogance (Darpam), their insatiable lust (Kamam), and their explosive anger (Krodham).
            Heavily infected by these psychological diseases, they constantly and aggressively seek out faults in others, operating with extreme malice and deep-seated envy (Abhyasuyakah).
            And heavily blinded by this toxic ignorance, they violently resent, despise, and actively hate Me (Pradvishanto), the Supreme Personality of Godhead, who resides flawlessly both within their own physical bodies and within the bodies of all others.
            This spectacular verse flawlessly and surgically decodes the absolute, precise 'Psychological Root' generating hardcore atheism and extreme physical violence in the matrix.
            When a human's biological hardware becomes violently overloaded with toxic Ego, crude Power, and blinding Lust, his fragile brain mathematically cannot tolerate the existence of an 'Absolute Supreme God' positioned above his own authority.
            Therefore, driven by pure madness, he aggressively challenges the cosmic hierarchy and begins to violently hate and envy the Supreme Creator Himself (exactly replicating the terrifying behavior of ancient cosmic terrorists like Hiranyakashipu).
            The Lord drops a profoundly heavy, paradigm-shifting truth: When you brutally assault, cheat, or inflict unjustified pain upon another living entity, you are absolutely not just hurting biological flesh.
            You are officially, directly declaring open warfare against, and inflicting horrific insults upon, "ME, the Supreme Lord," who is physically and spiritually seated directly within the core of that victim's heart.
            Even a human who ruthlessly destroys his own biological body through extreme, toxic addictions is fundamentally executing an act of violent hatred against the God residing within his own vessel.
            Therefore, treating every single living entity with absolute, flawless respect is the highest form of worship, and torturing others is mathematically equivalent to declaring a suicidal, direct war against God.
        """.trimIndent()
    ),
    Shloka(
        id = 19,
        sanskrit = """
            तानहं द्विषतः क्रूरान्संसारेषु नराधमान् |
            क्षिपाम्यजस्रमशुभानासुरीष्वेव योनिषु || १९ ||
        """.trimIndent(),
        hindi = """
            मुझसे और दूसरों से भयंकर नफरत करने वाले (द्विषतः), अत्यंत क्रूर और हिंसक (क्रूरान्), और मनुष्यों में सबसे नीच और गिरे हुए (नराधमान्) ऐसे पापी लोगों को...
            मैं (परमेश्वर) इस संसार के जन्म-मरण के चक्र में (संसारेषु) लगातार और बार-बार (अजस्रम्) केवल अत्यंत अशुभ और आसुरी (राक्षसी और नीच) योनियों में ही फेंक देता हूँ (क्षिपामि)।
            यहाँ भगवान श्रीकृष्ण का अत्यंत उग्र और 'सुप्रीम जज' (Supreme Judge / न्यायधीश) वाला कठोर रूप दुनिया के सामने आता है!
            भगवान स्पष्ट करते हैं कि ब्रह्मांड का सिस्टम (System) अंधा नहीं है; जो लोग अपनी पावर का इस्तेमाल दूसरों का खून चूसने और निर्दोषों को सताने (क्रूर) में करते हैं।
            उन नराधमों (Worst of humans / इंसानों के नाम पर कलंक) को भगवान किसी भी प्रकार की कोई माफी या वीआईपी ट्रीटमेंट (VIP Treatment) नहीं देते।
            भगवान कहते हैं, "मैं खुद अपने हाथों से ऐसे दुष्टों को पकड़कर जन्म-मरण के इस खौफनाक लूप (Loop) में बहुत ज़ोर से नीचे की तरफ फेंक देता हूँ!"
            उन्हें अगला जन्म किसी राजा या इंसान का नहीं मिलता, बल्कि उन्हें बार-बार सुअर, कीड़े, सांप या ऐसे खतरनाक जानवरों (आसुरी योनियों) के शरीर में जबरदस्ती डाल दिया जाता है जहाँ वे केवल कष्ट ही भोगते हैं।
            ईश्वर की यह भयानक सज़ा किसी बदले की भावना से नहीं, बल्कि ब्रह्मांड के 'लॉ ऑफ कर्मा' (Law of Karma) को बैलेंस (Balance) करने के लिए दी जाती है।
            यह श्लोक उन सारे अत्याचारियों के लिए एक मौत का वारंट है जो सोचते हैं कि उनके पैसों और पावर से वे अपने पापों की सज़ा से बच निकलेंगे।
            कर्मों का फल हर हाल में भुगतना ही पड़ता है, और प्रकृति का यह न्याय इंसान के बनाए हुए किसी भी कोर्ट से करोड़ों गुना ज्यादा क्रूर और सटीक होता है।
        """.trimIndent(),
        english = """
            Those toxic individuals who are deeply envious and hateful of Me (Dvishatah), who are violently cruel and heavily malicious (Kruran), and who officially rank as the absolute lowest, most degraded among all mankind (Naradhaman)...
            I, the Supreme Lord, ruthlessly and perpetually (Ajasram) cast them down into the terrifying ocean of material existence (Samsareshu), forcefully throwing them strictly into various inauspicious, horrific, and demonic species of life (Asurishv eva yonishu).
            Here, Lord Sri Krishna violently unleashes His deeply terrifying, uncompromising, and cold-blooded aspect as the absolute 'Supreme Cosmic Judge'!
            The Lord explicitly clarifies that the universal operating system is absolutely NOT blind; humans who arrogantly weaponize their power to ruthlessly exploit, torture, and execute extreme cruelty upon the innocent are being meticulously audited.
            For these 'Naradhamas' (The absolute worst, lowest scum of the human race who are a biological disgrace to humanity), the Supreme Lord provides mathematically zero forgiveness and absolutely no VIP treatment.
            The Lord fiercely roars, "I MYSELF, with My own hands, violently grab these toxic criminals and ruthlessly Hurl them relentlessly down into the most horrifying, terrifying loop of the reincarnation matrix!"
            They are aggressively denied the privilege of returning as humans or kings; they are forcefully downloaded into the rotting biological wombs of pigs, venomous snakes, cockroaches, or aggressive predators (Asuri-yonis), where they suffer unimaginable agony.
            This terrifying, apocalyptic cosmic punishment is absolutely not an act of petty divine revenge, but rather the flawless, clinical execution of the 'Law of Karma' actively re-establishing absolute equilibrium in the multiverse.
            This spectacular verse acts as a direct, unstoppable cosmic death warrant targeted at all arrogant tyrants who foolishly hallucinate that their massive wealth can legally bribe their way out of karmic retribution.
            Karmic reactions are inescapable, and Mother Nature's brutal justice system operates with a terrifying, mathematical precision that is billions of times more lethal and accurate than any man-made earthly court.
        """.trimIndent()
    ),
    Shloka(
        id = 20,
        sanskrit = """
            आसुरीं योनिमापन्ना मूढा जन्मनि जन्मनि |
            मामाप्राप्यैव कौन्तेय ततो यान्त्यधमां गतिम् || २० ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र अर्जुन! वे महामूर्ख लोग (मूढाः) जो जन्म-दर-जन्म (जन्मनि जन्मनि) लगातार इसी प्रकार की नीच और आसुरी योनियों को ही प्राप्त करते रहते हैं।
            वे मुझे (ईश्वर को) कभी भी प्राप्त नहीं कर पाते (मामाप्राप्यैव), और अंततः वे उससे भी अत्यंत नीची और भयंकर गति (अधमां गतिम् / सबसे गहरे नर्क) को ही प्राप्त होते हैं।
            यह श्लोक आसुरी और बुरे कर्मों में फँसे इंसान के 'कम्प्लीट डाउनफॉल' (Complete Downfall / पूर्ण पतन) का आखिरी और सबसे डरावना स्टेज (Stage) बताता है।
            जब इंसान बार-बार जानवरों या राक्षसों जैसी योनि में जन्म लेता है, तो उसकी बुद्धि का विकास पूरी तरह से रुक जाता है और वह एक 'मूढ़' (Brainless entity) बन जाता है।
            उसे ईश्वर के पास पहुँचने या अपने पापों से माफ़ी मांगने का कोई भी मौका या दिमाग (Consciousness) नहीं मिलता।
            उसका पतन रुकता नहीं है, बल्कि वह एक ब्लैक-होल (Black-hole) की तरह लगातार और नीचे, और नीचे गिरता ही चला जाता है।
            अंत में वह इंसान 'अधमां गतिम्' यानी ब्रह्मांड की सबसे निचली, सबसे डार्क (Dark) और सबसे दर्दनाक अवस्था (जैसे पेड़-पौधे या पत्थर बन जाना) में पहुँच कर हमेशा के लिए अटक जाता है।
            यह कोई ईश्वर का श्राप नहीं है, बल्कि यह उस इंसान की अपनी चॉइस (Choice) का ही एक कड़वा और साइंटिफिक रिज़ल्ट (Scientific Result) है।
            भगवान अर्जुन को समझा रहे हैं कि अगर कोई इंसान जानबूझकर अँधेरे की तरफ दौड़ रहा है, तो ईश्वर भी उसके उस स्वतंत्र फैसले (Free-will) में दखलंदाजी नहीं करते।
            इसलिए मनुष्य योनि में रहते हुए ही इंसान को जाग जाना चाहिए, क्योंकि एक बार पतन का यह गियर (Gear) लग गया, तो फिर वापस ऊपर आना लगभग नामुमकिन हो जाता है।
        """.trimIndent(),
        english = """
            O son of Kunti! These heavily degraded, pathetic fools (Mudhah), repeatedly taking birth after birth strictly among the lowest, demonic species of life (Asurim yonim apanna janmani janmani).
            They absolutely never, ever approach or successfully attain Me (Mam aprapyaiva), and from that point, they violently sink down to the absolute most abominable, lowest, and terrifying type of existence (Tato yanty adhamam gatim).
            This spectacular verse officially broadcasts the absolute final, most terrifying, and irreversible stage of a 'Complete Cosmic Downfall' for an entity trapped in demonic actions.
            When a human soul is continuously and forcefully recycled into the degraded biological vessels of animals or predators lifetime after lifetime, its advanced cognitive evolution permanently flatlines, reducing it to a 'Mudha' (a completely brainless, primitive entity).
            Confined to these pathetic animalistic bodies, the soul is mathematically denied any required mental bandwidth or consciousness to even attempt praying to God or seeking spiritual redemption.
            His catastrophic freefall does not magically stop; exactly like a soul being sucked into an inescapable supermassive black hole, he continues to plunge deeper and violently lower into the abyss.
            Ultimately, he aggressively hits 'Adhamam gatim'—the absolute lowest, darkest, and most agonizing rock-bottom dimension of the entire multiverse (such as being locked into the dormant consciousness of a tree or a stone) for millions of years.
            This is absolutely NOT a vindictive, angry curse from a jealous God; it is strictly the cold, mathematical, and highly scientific result of the entity's own toxic, persistent free-will choices.
            The Lord is explicitly explaining to Arjuna that if an entity willfully and aggressively sprints toward ultimate darkness, the Supreme Creator honors that toxic free-will and absolutely does not forcibly intervene to stop him.
            Therefore, a human must urgently and violently wake up while he still possesses this rare, advanced human brain, because once this terrifying downward gear is engaged, climbing back up the cosmic ladder is practically biologically impossible.
        """.trimIndent()
    ),
    Shloka(
        id = 21,
        sanskrit = """
            त्रिविधं नरकस्येदं द्वारं नाशनमात्मनः |
            कामः क्रोधस्तथा लोभस्तस्मादेतत्त्रयं त्यजेत् || २१ ||
        """.trimIndent(),
        hindi = """
            यह काम (वासना/लस्ट), क्रोध (गुस्सा), और लोभ (लालच)—ये तीन ही इस भयंकर नर्क की ओर ले जाने वाले मुख्य द्वार (दरवाज़े) हैं जो मनुष्य की अपनी आत्मा का पूरी तरह से विनाश (पतन) कर देते हैं।
            इसलिए, अपने खुद के कल्याण चाहने वाले प्रत्येक समझदार मनुष्य को चाहिए कि वह इन तीनों (काम, क्रोध और लोभ) का तुरंत और पूरी तरह से त्याग कर दे (तस्मादेतत्त्रयं त्यजेत्)।
            यह पूरी भगवद्गीता के सबसे मशहूर, सबसे ज़रूरी और 'सेल्फ-हेल्प' (Self-help) के सबसे बड़े मास्टर-सूत्रों में से एक है!
            भगवान श्रीकृष्ण यहाँ किसी भी इंसान के पतन (Downfall) के तीन सबसे बड़े और खौफनाक 'हैकर्स' (Hackers / वायरस) की पहचान दुनिया को बता रहे हैं।
            पहला है 'काम' (Lust/वासना)—जो इंसान को अपनी अनियंत्रित इच्छाओं का अंधा गुलाम बना देती है और उसे गलत काम करने पर मजबूर करती है।
            दूसरा है 'क्रोध' (Anger)—जब वह वासना पूरी नहीं होती, तो दिमाग में भयंकर गुस्सा पैदा होता है जो इंसान के सारे लॉजिक (Logic) और रिश्तों को जलाकर राख कर देता है।
            तीसरा है 'लोभ' (Greed)—यह पैसे और पावर की वह अंधी भूख है जिसका पेट कभी नहीं भरता और जो इंसान को करप्शन और अपराध के गटर में गिरा देती है।
            भगवान इन्हें 'नर्क के तीन दरवाज़े' (Gates of Hell) कहते हैं, क्योंकि जो इंसान इन तीन दरवाजों में से किसी एक से भी अंदर घुस गया, उसकी आत्मा का पतन निश्चित है।
            इसलिए भगवान एक बहुत ही कड़ा 'आदेश' (Command) देते हैं कि अगर तुम सच में खुद से प्यार करते हो और अपनी ज़िंदगी बचाना चाहते हो, तो तुरंत इन तीनों ज़हरीले वायरसों को अपने दिमाग से डिलीट (Delete) कर दो!
            इन तीन शत्रुओं को मारे बिना दुनिया का कोई भी ज्ञान या पूजा इंसान को मोक्ष या सच्ची शांति कभी नहीं दिला सकती।
        """.trimIndent(),
        english = """
            There are exactly three specific, terrifying gates leading directly to this hellish degradation, which completely cause the absolute destruction and ruin of the soul: they are lust (Kama), anger (Krodha), and greed (Lobha).
            Therefore, absolutely every single sane and intelligent human being who desires his own ultimate welfare must forcefully, permanently, and completely abandon these three specific traits (Tasmat etat trayam tyajet).
            This is universally celebrated as one of the absolute most famous, hyper-critical, and ultimate 'Master-Codes' of self-help and psychological survival in the entire Bhagavad Gita!
            Lord Sri Krishna is surgically identifying and explicitly exposing the three absolute most terrifying, lethal psychological 'Hackers' (Viruses) mathematically guaranteed to trigger a human's total cosmic downfall.
            The first is 'Kama' (Toxic Lust)—a blinding biological drive that aggressively hijacks a human's brain, transforming him into a pathetic, mindless slave willing to execute horrific, filthy actions just to gratify his senses.
            The second is 'Krodha' (Explosive Anger)—when this toxic lust is inevitably frustrated, it instantaneously mutates into a violent, roaring rage that completely incinerates all logical reasoning, basic common sense, and precious relationships into ash.
            The third is 'Lobha' (Insatiable Greed)—a terrifying, unquenchable hunger for endless billions and massive power that ruthlessly drags a human into the filthy gutters of extreme corruption and hardcore crime.
            The Lord officially categorizes these three as the literal 'Gates of Hell', because any human who foolishly steps through even one of these doors mathematically guarantees the catastrophic assassination of his own spiritual evolution.
            Therefore, the Supreme Lord issues an unyielding, military-grade 'Command': If you genuinely care about your own ultimate survival, you must immediately, violently, and permanently DELETE these three toxic viruses from your mental hard drive!
            Without aggressively slaughtering these three internal enemies, absolutely no amount of massive academic knowledge or expensive religious rituals can ever successfully grant a human true peace or eternal Moksha.
        """.trimIndent()
    ),
    Shloka(
        id = 22,
        sanskrit = """
            एतैर्विमुक्तः कौन्तेय तमोद्वारैस्त्रिभिर्नरः |
            आचरत्यात्मनः श्रेयस्ततो याति परां गतिम् || २२ ||
        """.trimIndent(),
        hindi = """
            हे कुन्तीपुत्र (कौन्तेय)! जो मनुष्य नर्क और अंधकार की ओर ले जाने वाले इन तीनों दरवाजों (काम, क्रोध और लोभ) से पूरी तरह मुक्त हो जाता है (एतैर्विमुक्तः)।
            वह मनुष्य फिर केवल वही आचरण (काम) करता है जो उसकी आत्मा के लिए सबसे ज्यादा कल्याणकारी और श्रेष्ठ (आत्मनः श्रेयः) होता है।
            और अपने लिए ऐसा श्रेष्ठ काम करते हुए वह मनुष्य धीरे-धीरे उस 'परम गति' (सबसे ऊँची मंज़िल यानी मोक्ष या ईश्वर) को निश्चित रूप से प्राप्त कर लेता है (ततो याति परां गतिम्)।
            यह श्लोक 'डिजिटल डिटॉक्स' (Digital Detox) की तरह ही इंसान के 'मेंटल डिटॉक्स' (Mental Detox) का सबसे बड़ा और शानदार रिज़ल्ट (Result) बता रहा है।
            जब तक इंसान का दिमाग काम, क्रोध और लोभ के वायरसों से हैक रहता है, वह जो भी फैसला लेता है, वह फैसला हमेशा गलत होता है और उसे नर्क की तरफ ही ले जाता है।
            लेकिन जैसे ही कोई बहादुर इंसान अपने दिमाग से इन तीनों 'तमोद्वारैः' (अंधेरे के दरवाजों) को तोड़कर हमेशा के लिए बंद कर देता है, तो चमत्कार होता है!
            उसकी बुद्धि का 'जीपीएस' (GPS) एकदम सही काम करने लगता है और उसे बिल्कुल क्लियर (Clear) दिखाई देने लगता है कि उसके लिए असली 'फायदा' (श्रेय) किस चीज़ में है।
            तब वह पैसे या वासना के पीछे भागने के बजाय ध्यान, योग, भक्ति और समाज की निस्वार्थ सेवा जैसे महान काम (आचरण) करना शुरू कर देता है।
            और जब इंसान का 'रूट' (Route / रास्ता) सही हो जाता है, तो भगवान गारंटी देते हैं कि वह अपनी आखिरी और सबसे शानदार मंज़िल (परम गति / Supreme Destination) तक 100% पहुँच ही जाएगा।
            बुराइयों को छोड़ना ही अच्छाई की शुरुआत है, और यही मोक्ष का सबसे सीधा, साफ और साइंटिफिक फॉर्मूला है।
        """.trimIndent(),
        english = """
            O son of Kunti (Kaunteya)! The man who has successfully escaped and become entirely liberated from these three specific, dark gates of hell (Etair vimuktah tamo-dvarais tribhir narah).
            He naturally and flawlessly begins to perform only those highly elevated acts which are exceptionally conducive to his own ultimate self-realization and supreme welfare (Acharaty atmanah shreyas).
            And by strictly executing such highly auspicious activities, he gradually and mathematically inevitably attains the absolute supreme destination (Tato yati param gatim).
            This spectacular verse reveals the absolute, explosive 'Result' of successfully executing the ultimate 'Mental Detox', operating exactly like curing a heavily infected computer.
            As long as a human brain remains heavily hijacked and corrupted by the toxic viruses of lust, anger, and greed, absolutely every single decision it calculates is mathematically flawed, driving the entity straight toward a hellish crash.
            But the exact microsecond a brave, highly intelligent human violently shatters and permanently locks shut these three 'Gates of Darkness' (Tamo-dvaraih), a profound cosmic miracle instantaneously occurs!
            His internal spiritual 'GPS' successfully reboots to 100% pristine clarity, allowing him to effortlessly and precisely calculate exactly what actions generate true, eternal 'Benefit' (Shreyas) for his soul.
            Instead of frantically sprinting after cheap, temporary cash or toxic lust, he immediately redirects his massive energy toward executing elite activities like deep meditation, yoga, pure devotion, and selfless global service.
            And once the human's psychological 'Route' is flawlessly corrected, the Supreme Lord officially guarantees that he will 100% successfully navigate the matrix and arrive directly at the 'Param Gatim' (The Absolute Supreme Destination).
            Violently amputating your toxic flaws is the mandatory first step to activating your divine potential; this is the absolute most straightforward, scientific, and foolproof formula for achieving eternal Moksha.
        """.trimIndent()
    ),
    Shloka(
        id = 23,
        sanskrit = """
            यः शास्त्रविधिमुत्सृज्य वर्तते कामकारतः |
            न स सिद्धिमवाप्नोति न सुखं न परां गतिम् || २३ ||
        """.trimIndent(),
        hindi = """
            जो मनुष्य शास्त्रों में बताए गए नियमों और विधियों को पूरी तरह से त्याग कर (उत्सृज्य), केवल अपनी इच्छाओं और वासनाओं के अनुसार ही मनमाना आचरण करता है (वर्तते कामकारतः)।
            वह इंसान अपने जीवन में न तो कभी किसी काम में 'सिद्धि' (सफलता/Perfection) को प्राप्त कर पाता है, न ही उसे कभी सच्चा 'सुख' मिलता है, और न ही वह कभी 'परम गति' (मोक्ष) को पा सकता है।
            यह श्लोक उन लोगों के लिए सबसे बड़ी चेतावनी है जो कहते हैं कि "मैं अपनी मर्जी का मालिक हूँ, मुझे जो अच्छा लगेगा मैं वही करूँगा" (My life, my rules)।
            भगवान स्पष्ट रूप से कहते हैं कि यह ब्रह्मांड एक बहुत बड़ी मशीन है, और वेद या शास्त्र (Scriptures) उस मशीन को सही तरीके से चलाने का 'यूज़र मैनुअल' (User Manual) हैं।
            अगर आप किसी महंगी मशीन को मैनुअल पढ़े बिना अपनी मर्जी से चलाएंगे, तो मशीन 100% टूट जाएगी और आपका ही नुकसान होगा।
            उसी तरह, जो इंसान शास्त्रों (धर्म) के नियमों को कूड़े में फेंक कर केवल अपनी 'हवस और लालच' (कामकारतः) के इशारों पर नाचता है, भगवान उसका पूरा जीवन तीन जगह से 'ब्लॉक' (Block) कर देते हैं।
            पहला: "न सिद्धि"—उसे कभी भी किसी भी काम में परफेक्शन (Perfection) या परमानेंट सक्सेस नहीं मिलेगी।
            दूसरा: "न सुखं"—उसके पास चाहे करोड़ों आ जाएं, लेकिन उसके दिमाग में कभी शांति या असली 'सुख' नहीं आएगा।
            तीसरा: "न परां गतिम्"—और मरने के बाद उसे कभी भी ईश्वर या मोक्ष की प्राप्ति नहीं होगी, वह हमेशा नर्क या चौरासी लाख योनियों में धक्के खाएगा।
            यह श्लोक साबित करता है कि असली आज़ादी नियमों को तोड़ने में नहीं, बल्कि सही (ईश्वरीय) नियमों के अनुशासन में रहकर जीवन जीने में ही है।
        """.trimIndent(),
        english = """
            He who completely and arrogantly discards the strict injunctions and regulations established by the scriptures, choosing to act whimsically according to the blind dictates of his own lust (Yah shastra-vidhim utsrijya vartate kama-karatah).
            Such a foolish person absolutely never attains true perfection (Na sa siddhim avapnoti), he mathematically never achieves genuine happiness (Na sukham), nor can he ever possibly attain the supreme destination (Na param gatim).
            This spectacular verse acts as the ultimate, brutal warning siren directed explicitly at arrogant modern humans who aggressively flaunt the toxic philosophy of "My life, my rules; I will do whatever I feel like."
            The Lord explicitly clarifies that this colossal multiverse operates strictly as an infinitely complex, highly regulated machine, and the authorized Vedic 'Shastras' (Scriptures) serve as its official, indispensable 'User Manual'.
            If you arrogantly attempt to operate a highly sophisticated, multi-million-dollar machine while violently ignoring its instruction manual, the machine is mathematically guaranteed to explode, causing catastrophic damage to yourself.
            Similarly, a human who violently throws the sacred regulations of Dharma into the trash, blindly dancing like a pathetic puppet to the tunes of his own toxic 'Lust and Greed' (Kama-karatah), gets his entire existence blocked by God on exactly three fronts.
            First: "Na Siddhim"—He is permanently barred from ever achieving flawless perfection, true stability, or permanent success in absolutely any endeavor.
            Second: "Na Sukham"—Even if he successfully hoards billions of dollars, his brain will absolutely never, ever experience a single microsecond of genuine peace or authentic 'Happiness'.
            Third: "Na Param Gatim"—And upon biological expiration, he is brutally denied entry into the spiritual sky, forcefully thrown back into the miserable, grinding cycle of earthly reincarnation and hellish dimensions.
            This profound verse mathematically proves that true cosmic freedom does not come from violently breaking the rules, but rather from strictly aligning your life with the flawless discipline of divine law.
        """.trimIndent()
    ),
    Shloka(
        id = 24,
        sanskrit = """
            तस्माच्छास्त्रं प्रमाणं ते कार्याकार्यव्यवस्थितौ |
            ज्ञात्वा शास्त्रविधानोक्तं कर्म कर्तुमिहार्हसि || २४ ||
        """.trimIndent(),
        hindi = """
            इसलिए हे अर्जुन! तुम्हारे लिए क्या करना सही है (कर्तव्य / कार्य) और क्या करना गलत है (अकर्तव्य / अकार्य), इसका निर्णय करने के लिए केवल 'शास्त्र' (वेद/गीता आदि) ही एकमात्र पक्का प्रमाण (Standard/Proof) हैं।
            इस बात को अच्छी तरह जानकर, तुम्हें इस दुनिया में केवल वही कर्म करने चाहिए जो शास्त्रों के नियमों और विधानों (शास्त्रविधानोक्तं) के बिल्कुल अनुकूल हों।
            यह सोलहवें अध्याय (दैवासुर संपद्विभाग योग) का बहुत ही शानदार और 'रूल-मेकिंग' (Rule-making) ग्रैंड-फिनाले (Grand Finale) श्लोक है!
            इंसान हमेशा इस भारी कंफ्यूजन (Confusion) में रहता है कि "मैं जो कर रहा हूँ वो सही है या गलत? मैं अपने दिल की सुनूँ या दिमाग की?"
            भगवान श्रीकृष्ण इंसान की इस सबसे बड़ी प्रॉब्लम का एक 'यूनिवर्सल सलूशन' (Universal Solution) दे देते हैं: "अपने मन की मत सुनो, क्योंकि मन बहुत बड़ा धोखेबाज़ है और वो तुम्हें वासनाओं की तरफ धकेलेगा।"
            तुम्हारे लिए अल्टीमेट जज (Ultimate Judge) और सुप्रीम गाइडेंस (Supreme Guidance) केवल 'शास्त्र' (Scriptures) हैं। जब भी जीवन में कोई धर्म-संकट आए, तो शास्त्रों के पन्नों में लिखे हुए नियमों को अपना 'जीपीएस' (GPS) बनाओ।
            भगवान अर्जुन से कहते हैं कि तुम्हें अपनी भावनाओं (Emotions) के आधार पर युद्ध छोड़ने का फैसला नहीं लेना चाहिए, बल्कि एक क्षत्रिय के रूप में शास्त्रों में जो तुम्हारी 'ड्यूटी' (Duty) बताई गई है, उसे पूरा करना चाहिए।
            जो इंसान अपनी पूरी ज़िंदगी को शास्त्रों की इस मजबूत पटरी पर चलाता है, उसकी गाड़ी कभी भी एक्सीडेंट (Accident) का शिकार नहीं होती।
            यहीं पर भगवान अर्जुन को 100% क्लैरिटी (Clarity) दे देते हैं कि असली 'दैवीय संपदा' (Divine Nature) अपनी मर्जी चलाने में नहीं, बल्कि ईश्वर के बनाए हुए नियमों के आगे सिर झुकाकर काम करने में है।
        """.trimIndent(),
        english = """
            Therefore, the authorized scriptures strictly serve as the absolute, infallible standard and evidence (Pramanam) for you to determine exactly what must be done and what must not be done (Karya-akarya-vyavasthitau).
            Having properly and deeply understood the strict rules and regulations laid out in the scriptures (Jnatva shastra-vidhanoktam), you should act and perform your duties in this world accordingly (Karma kartum iharhasi).
            This is the incredibly spectacular, definitive, and ultimate 'Rule-Making' Grand Finale verse of the Sixteenth Chapter (The Divine and Demoniac Natures)!
            Humans perpetually suffer from a massive, crippling psychological dilemma, constantly questioning: "Is my current action morally right or tragically wrong? Should I blindly follow my heart or calculate with my brain?"
            Lord Sri Krishna violently eliminates this massive confusion by dropping the absolute 'Universal Solution': "Absolutely do not blindly trust your own mind, because your biological mind is a highly deceptive hacker programmed to aggressively drag you toward toxic lust."
            Your absolute, ultimate Supreme Judge and flawless guiding 'Standard' (Pramanam) must strictly be the authorized 'Shastras' (Vedic Scriptures). Whenever a massive moral crisis crashes into your life, you must rigorously consult the cosmic laws codified in the scriptures to act as your flawless spiritual GPS.
            The Lord explicitly orders Arjuna that he absolutely must not make the catastrophic decision to abandon the war based on his weak, temporary biological emotions; instead, he must ruthlessly execute his exact 'Duty' as rigidly mandated by the scriptures for a warrior.
            Any human who flawlessly aligns and drives the train of his life squarely upon the solid, titanium tracks of scriptural injunctions mathematically guarantees that his consciousness will never suffer a catastrophic derailment.
            This perfectly finalizes the chapter, officially cementing the profound truth that authentic 'Divine Nature' is absolutely not about arrogantly exercising your whimsical free will, but about humbly surrendering your actions to the supreme, flawless discipline of God's universal laws.
        """.trimIndent()
    )
)