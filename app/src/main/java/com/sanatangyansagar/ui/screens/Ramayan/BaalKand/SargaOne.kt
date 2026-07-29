package com.sanatangyansagar.ui.screens.Ramayan.BaalKand

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
import androidx.compose.ui.unit.sp

// 1. Data Model (Keep this only if it is not already defined in another file)
data class RamayanVerse(
    val id: Int,
    val sanskrit: String,
    val hindiCommentary: String,
    val englishCommentary: String
)

// 2. Main Screen Component
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SargaOneScreen() {
    var searchQuery by remember { mutableStateOf("") }

    // Search Filtering Logic
    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaOneVerses
        } else {
            sargaOneVerses.filter {
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
                        Text("प्रथम सर्ग - संक्षेप रामायण", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFE0B2) // Saffron Light
                    )
                )
                // Search Bar added to match other screens
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("खोजें (श्लोक संख्या या शब्द)...") },
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
                .background(Color(0xFFFFF3E0)),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(filteredVerses) { verse ->
                // Assuming RamayanDetailCard is defined in a shared UI components file
                RamayanDetailCard(verse)
            }

            // Empty state if search yields no results
            if (filteredVerses.isEmpty()) {
                item {
                    Text(
                        text = "कोई परिणाम नहीं मिला।",
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
// 3. Detailed Card Component
@Composable
fun RamayanDetailCard(verse: RamayanVerse) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "॥ श्लोक ${verse.id} ॥",
                color = Color(0xFFBF360C),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = verse.sanskrit,
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                lineHeight = 28.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 1.dp, color = Color(0xFFF57C00).copy(alpha = 0.2f))
            Spacer(modifier = Modifier.height(16.dp))

            Text("हिन्दी भावार्थ एवं व्याख्या:", fontWeight = FontWeight.Bold, color = Color(0xFF388E3C))
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = verse.hindiCommentary,
                fontSize = 15.sp,
                lineHeight = 24.sp,
                color = Color(0xFF212121)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("English Meaning & Commentary:", fontWeight = FontWeight.Bold, color = Color(0xFF1976D2))
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = verse.englishCommentary,
                fontSize = 15.sp,
                lineHeight = 24.sp,
                color = Color(0xFF212121)
            )
        }
    }
}

// 4. Data for Shlokas 1-25 (Showing logic for 1-25 placeholders)
val sargaOneVerses = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "तपःस्वाध्यायनिरतं तपस्वी वाग्विदां वरम् ।\nनारदं परिपप्रच्छ वाल्मीकिर्मुनिपुङ्गवम् ॥ १ ॥",
        hindiCommentary = """
            महर्षि वाल्मीकि, जो स्वयं एक महान तपस्वी हैं, उन्होंने देवर्षि नारद से प्रश्न किया।
            नारद जी निरंतर तपस्या और स्वाध्याय (वेदों के अध्ययन) में लीन रहने वाले मुनि हैं।
            वे वाणी के ज्ञाताओं में सबसे श्रेष्ठ माने जाते हैं, क्योंकि उनकी वाणी सत्य और कल्याणकारी है।
            वाल्मीकि जी उन्हें 'मुनिपुङ्गव' कहते हैं, जिसका अर्थ है मुनियों में श्रेष्ठ पुरुष।
            यह संवाद रामायण के जन्म का आधार है, जहाँ जिज्ञासा सत्य की खोज की ओर ले जाती है।
            वाल्मीकि जी के मन में एक आदर्श मनुष्य के स्वरूप को जानने की तीव्र इच्छा उत्पन्न हुई थी।
            वे जानना चाहते थे कि क्या इस पृथ्वी पर कोई ऐसा व्यक्ति है जो पूर्णतः निर्दोष और गुणवान हो।
            नारद जी, जो तीनों लोकों में भ्रमण करते हैं, इस प्रश्न का उत्तर देने के लिए सबसे योग्य पात्र थे।
            तप का अर्थ यहाँ केवल शारीरिक तपस्या नहीं, बल्कि मन की एकाग्रता और संकल्प की शक्ति है।
            स्वाध्याय से तात्पर्य है आत्म-चिंतन और शास्त्रों का वह ज्ञान जो आचरण में उतर सके।
            इस प्रकार, एक तपस्वी ने दूसरे महान तपस्वी से मानवता के सर्वोच्च आदर्श के बारे में पूछा।
        """.trimIndent(),
        englishCommentary = """
            Sage Valmiki, a true ascetic himself, sought wisdom from the divine sage Narada.
            Narada is described as being eternally established in penance (Tapas) and self-study (Swadhyaya).
            He is hailed as the 'best among those eloquent in speech,' possessing divine clarity.
            Valmiki addresses him as 'Munipungavam,' meaning a pre-eminent leader among sages.
            This inquiry marks the beginning of the epic, showing that great wisdom starts with a question.
            Valmiki’s heart was filled with a deep curiosity regarding the ideal human character.
            He wondered if there existed a person on Earth who embodied all divine virtues simultaneously.
            Narada, who constantly traverses the three worlds, was uniquely qualified to answer this.
            Tapas here refers to the disciplined power of the soul, while Swadhyaya means spiritual study.
            Their meeting represents the union of intellectual curiosity and divine revelation.
            It sets the stage for the narration of the life of Sri Rama, the ultimate embodiment of virtue.
        """.trimIndent()
    ),
    // ... Repeat for Shlokas 2 to 25 with 10-15 lines of detail each
    RamayanVerse(
        id = 2,
        sanskrit = "कोन्वस्मिन् साम्प्रतं लोके गुणवान् कश्च वीर्यवान् ।\nधर्मज्ञश्च कृतज्ञश्च सत्यवाक्यो दृढव्रतः ॥ २ ॥",
        hindiCommentary = """
            वाल्मीकि जी नारद जी से पूछते हैं कि इस वर्तमान संसार में वह कौन है जो वास्तव में 'गुणवान' है?
            वह पुरुष कैसा हो? जो न केवल वीर और शक्तिशाली (वीर्यवान) हो, बल्कि धर्म का पूर्ण ज्ञाता भी हो।
            वह कृतज्ञ होना चाहिए, जो दूसरों के द्वारा किए गए छोटे से उपकार को भी कभी न भूले।
            उसकी वाणी सत्य से प्रतिष्ठित हो, वह जो कहे वही करे, यानी वह सत्यवादी (सत्यवाक्य) हो।
            साथ ही वह 'दृढव्रत' हो, जिसने अपने संकल्पों और नियमों को कभी न तोड़ने का प्रण लिया हो।
            गुणवान होने का अर्थ है मानवीय संवेदनाओं और नैतिक मूल्यों का एक साथ हृदय में वास होना।
            वीर्यवान होने का अर्थ केवल शारीरिक बल नहीं, बल्कि मानसिक और आत्मिक शक्ति का प्रबल होना है।
            कृतज्ञता को यहाँ एक महान गुण माना गया है, क्योंकि अहसान मानना ही मनुष्यता की पहचान है।
            धर्मज्ञ होना यह सुनिश्चित करता है कि व्यक्ति शक्ति का उपयोग केवल न्याय और सत्य के लिए करेगा।
            दृढव्रत होना यह दर्शाता है कि वह पुरुष विपरीत परिस्थितियों में भी विचलित नहीं होगा।
            वाल्मीकि जी एक ऐसे महामानव की रूपरेखा तैयार कर रहे हैं जो आने वाली पीढ़ियों का पथ-प्रदर्शक बने।
        """.trimIndent(),
        englishCommentary = """
            Valmiki asks: "Who is currently living in this world who is truly endowed with great virtues?"
            He specifies that the person must be 'Gunavan' (virtuous) and 'Viryavan' (possessing heroic valor).
            The ideal man should be 'Dharmajña,' one who possesses an unerring knowledge of cosmic and moral law.
            He should be 'Kritajña,' meaning one who is eternally grateful for even the smallest kindness received.
            His speech should be anchored in 'Satyavakya,' where his word is as dependable as reality itself.
            Furthermore, he must be 'Dridhavrata,' standing firm in his vows regardless of the challenges.
            Valmiki isn't looking for a mythological figure, but a living example of perfection in the current age.
            Virtue (Guna) here represents a harmony of character, kindness, and spiritual integrity.
            Valor (Virya) represents the strength to protect the weak and uphold the truth against all odds.
            Gratitude is emphasized as the hallmark of a refined soul that acknowledges the divinity in others.
            A firm resolve ensures that the path of righteousness is never abandoned for temporary gains.
            This question seeks to find the standard of human excellence that serves as a beacon for humanity.
        """.trimIndent()
    ),
        RamayanVerse(
            id = 26,
            sanskrit = "तं व्रजन्तं प्रियो भ्राता लक्ष्मणोऽनुजगाम ह ।\nस्नेहाद्विनयसम्पन्नः सुहृद् भ्रातृहिते रतः ॥ २६ ॥",
            hindiCommentary = """
            जब श्री राम वन की ओर प्रस्थान करने लगे, तब उनके प्रिय छोटे भाई लक्ष्मण उनके पीछे चल दिए।
            लक्ष्मण जी केवल भाई नहीं थे, बल्कि वे प्रेम और विनय (विनम्रता) की साक्षात् प्रतिमूर्ति थे।
            उनका राम के प्रति अनुराग इतना गहरा था कि वे उनके बिना अयोध्या में रहने की कल्पना भी नहीं कर सकते थे।
            'सुहृद्' शब्द यहाँ उनके उस निस्वार्थ हृदय को दर्शाता है जो केवल अपने भाई के कल्याण में लगा रहता था।
            उन्होंने राजमहलों के समस्त सुखों को तिनके के समान त्याग दिया ताकि वे राम की सेवा कर सकें।
            लक्ष्मण का यह अनुगमन (पीछे चलना) संसार के लिए 'भ्रातृ-प्रेम' का सबसे महान और अनूठा उदाहरण है।
            वे जानते थे कि वन का मार्ग कांटों भरा है, पर राम के साथ होने पर उन्हें वह मार्ग भी स्वर्ग जैसा लगा।
            उनकी भक्ति में कोई स्वार्थ नहीं था; वे केवल राम की छाया बनकर उनकी रक्षा करना चाहते थे।
            लक्ष्मण जी ने यह सिद्ध किया कि प्रेम में अधिकार नहीं, बल्कि पूर्ण समर्पण और सेवा का भाव सर्वोपरि होता है।
            नारद जी यहाँ लक्ष्मण के उस चरित्र को उजागर कर रहे हैं जो राम के वनवास को सहने योग्य बनाता है।
            यह श्लोक हमें सिखाता है कि कठिन समय में परिवार की एकजुटता और निस्वार्थ साथ ही सबसे बड़ी शक्ति है।
        """.trimIndent(),
            englishCommentary = """
            As Rama set out for the forest, His beloved brother Lakshmana followed Him with unwavering devotion.
            Lakshmana was not just a sibling but was thoroughly endowed with affection (Sneha) and humility (Vinaya).
            He was a true well-wisher (Suhrid), dedicated entirely to the welfare and service of His elder brother.
            The word 'Anujagama' signifies that He followed not out of duty, but out of an indissoluble bond of soul.
            He abandoned the luxuries of the royal palace instantly, viewing them as worthless compared to Rama's presence.
            Lakshmana's sacrifice serves as the ultimate benchmark for fraternal love in the history of mankind.
            For Him, the thorns of the forest were as soft as lotus petals if He could only remain by Rama's side.
            His devotion was silent and active; He sought no recognition, only the opportunity to serve and protect.
            He demonstrated that true loyalty is proven not in the comfort of palaces, but in the trials of the wilderness.
            Narada highlights that Lakshmana’s presence provided Rama with an earthly anchor during His divine mission.
            This verse teaches us that selfless companionship is the greatest wealth one can possess during life's crises.
        """.trimIndent()
        ),
RamayanVerse(
id = 27,
sanskrit = "रामस्य दयिता भार्या नित्यं प्राणसमा हिता ।\nजनकस्य कुले जाता देवमायेव निर्मिता ॥ २७ ॥",
hindiCommentary = """
            श्री राम की अत्यंत प्रिय पत्नी सीता भी उनके साथ चलने को तैयार हुईं, जो उनके प्राणों के समान थीं।
            सीता जी महाराज जनक के पवित्र कुल में उत्पन्न हुई थीं और उनके गुण 'देवमाया' के समान अलौकिक थे।
            वे केवल एक पत्नी नहीं थीं, बल्कि राम की हर परिस्थिति में 'हितकारी' और साथ निभाने वाली शक्ति थीं।
            नारद जी उन्हें 'निर्मिता' कहते हैं, जैसे भगवान ने उन्हें स्वयं अपने हाथों से विशेष रूप से गढ़ा हो।
            उनका चरित्र इतना पवित्र और तेजस्वी था कि वे संसार की समस्त स्त्रियों में श्रेष्ठ और शिरोमणि मानी जाती हैं।
            वे राम के सुख में सुखी और उनके दुख में दुखी होने वाली उनकी 'छाया' के समान सदैव उनके साथ रहीं।
            जनक के कुल के संस्कार उनमें कूट-कूट कर भरे थे, जो उन्हें धैर्य और धर्म के मार्ग पर अडिग रखते थे।
            प्राणसमा होने का अर्थ है कि राम और सीता का अस्तित्व अलग नहीं, बल्कि एक ही चेतना के दो रूप हैं।
            उनका वन जाना यह दर्शाता है कि एक आदर्श पत्नी के लिए पति का सान्निध्य ही उसका सबसे बड़ा साम्राज्य है।
            वे राजसी सुखों को त्यागकर वन के कष्टों को गले लगाने के लिए मानसिक रूप से पूरी तरह तैयार थीं।
            यह श्लोक सीता जी की दिव्यता और उनके अटूट पतिव्रत धर्म की एक महान और भावपूर्ण प्रस्तावना है।
        """.trimIndent(),
englishCommentary = """
            Rama's beloved wife Sita, who was as dear to Him as His own life (Pranasama), also prepared to follow.
            Born in the illustrious and spiritually advanced lineage of King Janaka, she was a paragon of virtue.
            She is described as 'Devamayeva Nirmita,' as if fashioned by divine power to be the perfect cosmic counterpart.
            Sita was not merely a consort but a constant well-wisher who sought the auspiciousness of her husband.
            Her character represents the pinnacle of grace, strength, and unwavering moral integrity in the epic.
            She shared Rama's destiny with such intimacy that her identity was seamlessly merged with His mission.
            Coming from Janaka's house, she carried the deep wisdom of 'Vaidhei,' remaining detached from material ease.
            The term 'Pranasama' highlights that the bond between Rama and Sita was metaphysical, transcending physical limits.
            Her decision to follow Him into exile redefines the concept of companionship as a shared spiritual journey.
            She viewed the hardships of the forest as a sacred pilgrimage as long as she was in the presence of Rama.
            This verse serves as a profound introduction to Sita's divinity and her role as the soul of the Ramayana.
        """.trimIndent()
),
RamayanVerse(
id = 28,
sanskrit = "सर्वलक्षणसम्पन्ना नारीणामुत्तमा वधूः ।\nसीताप्यनुगता रामं शशिनं रोहिणी यथा ॥ २८ ॥",
hindiCommentary = """
            सीता जी समस्त शुभ लक्षणों से संपन्न थीं और वे संसार की समस्त वधुओं में सबसे श्रेष्ठ मानी गई हैं।
            जैसे आकाश में रोहिणी नक्षत्र हमेशा चंद्रमा (शशि) के साथ रहता है, वैसे ही सीता जी राम के पीछे चल दीं।
            'सर्वलक्षणसम्पन्ना' होने का अर्थ है कि उनका सौंदर्य और उनका चरित्र—दोनों ही पूर्णता की पराकाष्ठा पर थे।
            नारद जी यहाँ चंद्रमा और रोहिणी की उपमा देकर उनके प्रेम की शाश्वतता और अटूटता को सिद्ध करते हैं।
            जैसे चंद्रमा का प्रकाश रोहिणी के बिना अधूरा है, वैसे ही राम का जीवन सीता के बिना अपूर्ण प्रतीत होता है।
            वे जानती थीं कि पति का साथ ही एक स्त्री के लिए सबसे बड़ा सुरक्षा कवच और उसका वास्तविक घर है।
            अयोध्या की प्रजा उन्हें देखकर विलाप कर रही थी कि इतनी सुकोमल राजकुमारी कैसे वन के कष्ट सहेगी।
            परन्तु सीता का संकल्प उनके शरीर की सुकुमारता से कहीं अधिक दृढ़ और वज्र के समान शक्तिशाली था।
            उन्होंने यह उदाहरण प्रस्तुत किया कि प्रेम केवल महलों का मोहताज नहीं, बल्कि वह त्याग की अग्नि में तपकर कुंदन बनता है।
            यह श्लोक राम और सीता के दांपत्य जीवन को एक खगोलीय और ईश्वरीय गरिमा प्रदान करता है।
            उनके वन गमन के साथ ही रामायण का वह अध्याय शुरू होता है जहाँ मर्यादाओं की नई परिभाषाएँ लिखी जानी थीं।
        """.trimIndent(),
englishCommentary = """
            Endowed with all auspicious marks, Sita was the most excellent among all the women and daughters-in-law.
            She followed Rama into the forest just as the constellation Rohini constantly follows the Moon (Shashi).
            The attribute 'Sarvalakshanasampanna' indicates that her beauty was a reflection of her inner spiritual perfection.
            Narada uses the celestial metaphor of the Moon and Rohini to illustrate the eternal nature of their union.
            Just as moonlight is inseparable from the moon, Sita's consciousness was inseparable from Rama’s being.
            She understood that the true 'abode' of a devoted wife is the presence of her husband, regardless of the location.
            While the citizens wept seeing her delicate form head toward the woods, her resolve remained unshakable.
            Her strength was not physical but rooted in the power of 'Sati-shakti,' making her invulnerable to fear.
            She proved that love is not about shared luxuries, but about shared sacrifices in the pursuit of higher Truth.
            This verse elevates the relationship of Rama and Sita to a cosmic level, beyond the reach of time and space.
            With her departure, the epic moves toward a phase where the boundaries of human endurance would be tested.
        """.trimIndent()
),
RamayanVerse(
id = 29,
sanskrit = "पौरैरनुगतो दूरं पित्रा दशरथेन च ।\nशृङ्गवेरपुरे सूतं गङ्गाकूले व्यसर्जयत् ॥ २९ ॥",
hindiCommentary = """
            जब राम वन के लिए निकले, तो अयोध्या की प्रजा और स्वयं व्याकुल पिता दशरथ बहुत दूर तक उनके पीछे गए।
            प्रजा का अपने राजकुमार के प्रति ऐसा अनुराग इतिहास में विरल है; वे सब राम के बिना अनाथ महसूस कर रहे थे।
            किन्तु सत्य की रक्षा के लिए राम ने सबको वापस जाने का अनुरोध किया और वे गंगा के किनारे शृङ्गवेरपुर पहुँचे।
            वहाँ पहुँचकर उन्होंने अपने सारथी सुमंत्र को रथ के साथ अयोध्या वापस लौट जाने की आज्ञा दी।
            'व्यसर्जयत्' (विदा करना) शब्द यहाँ राम के उस कठिन निर्णय को दर्शाता है जहाँ वे राजसी जीवन के अंतिम सूत्र को भी काट देते हैं।
            रथ का वापस जाना इस बात का प्रतीक था कि अब राम एक राजा नहीं, बल्कि एक वनवासी तपस्वी के रूप में जिएंगे।
            दशरथ जी की व्याकुलता इतनी अधिक थी कि वे धूल में गिर पड़े, पर राम अपने वचन के कारण पीछे मुड़कर नहीं देख सके।
            शृङ्गवेरपुर वह स्थान है जहाँ राम की मुलाकात उनके प्रिय मित्र निषादराज गुह से हुई थी।
            यहीं से राम की वह यात्रा शुरू होती है जहाँ वे समाज के वंचित और पिछड़े वर्ग को गले लगाना शुरू करते हैं।
            यह श्लोक कर्तव्य की कठोरता और भावनाओं के संघर्ष का एक मार्मिक चित्रण प्रस्तुत करता है।
            राम ने सिद्ध किया कि बड़े लक्ष्यों को पाने के लिए सबसे प्रिय वस्तुओं और जनों का मोह छोड़ना पड़ता है।
        """.trimIndent(),
englishCommentary = """
            Rama was followed a great distance by the citizens of Ayodhya and by His grief-stricken father, Dasharatha.
            The devotion of the subjects toward their prince was unprecedented; they felt orphaned by His departure.
            However, to uphold the Truth, Rama urged them to return and eventually reached Shringaverapura on the Ganges.
            At the banks of the holy river, He formally dismissed His charioteer Sumantra and sent the chariot back.
            The term 'Vyasurjayat' marks a painful closure, where Rama severed the final link to His princely life.
            Sending the chariot back symbolized His transition from a royal heir to an ascetic wandering in the wild.
            Dasharatha’s agony was so profound that he collapsed in the dust, yet Rama remained steadfast in His vow.
            Shringaverapura is significant as the place where Rama met His dear friend Guha, the King of the Nishadas.
            This moment marks the beginning of Rama's outreach to the humble and marginalized sections of society.
            This verse depicts the clash between the cold rigidity of duty and the intense warmth of human emotions.
            Rama demonstrated that for the sake of a higher principle, one must let go of even the dearest attachments.
        """.trimIndent()
),
RamayanVerse(
id = 30,
sanskrit = "गुहेन सहितो रामो लक्ष्मणेन च सीतया ।\nते वनेन वनं गत्वा नदीस्तीर्त्वा बहूदकाः ॥ ३० ॥",
hindiCommentary = """
            निषादराज गुह के साथ कुछ समय व्यतीत करने के बाद राम, लक्ष्मण और सीता आगे के वन की ओर बढ़ गए।
            वे एक वन से दूसरे वन (वनेन वनं) की ओर निरंतर चलते रहे, जो उनके संघर्षपूर्ण जीवन की शुरुआत थी।
            मार्ग में उन्होंने 'बहूदकाः' (अथाह जल वाली) अनेक पवित्र और विशाल नदियों को पार किया।
            गुह का साथ यह दर्शाता है कि राम के लिए प्रेम ही सबसे बड़ा नाता है, चाहे वह राजा हो या वनवासी।
            नदियों को पार करना केवल भौगोलिक यात्रा नहीं, बल्कि जीवन की बाधाओं को पार करने का आध्यात्मिक संकेत है।
            अब उनके पास न रथ था, न सेवक; केवल अपने पैरों के बल पर वे दुर्गम रास्तों को नाप रहे थे।
            सीता जी, जिन्होंने कभी नंगे पैर जमीन पर कदम नहीं रखा था, वे भी प्रसन्नतापूर्वक इस यात्रा में शामिल थीं।
            लक्ष्मण जी एक प्रहरी की तरह आगे और पीछे की सुरक्षा का ध्यान रखते हुए चल रहे थे।
            यह श्लोक राम के उस सहज व्यक्तित्व को दिखाता है जो प्रकृति और साधारण जनों के साथ पूरी तरह घुलमिल गया था।
            नारद जी यहाँ राम की सहनशक्ति और उनके वनवासी स्वरूप का एक सजीव चित्रण पेश कर रहे हैं।
            यह यात्रा अयोध्या के वैभव से निकलकर दंडकारण्य की शांति और रहस्यों की ओर एक महान प्रस्थान थी।
        """.trimIndent(),
englishCommentary = """
            Accompanied briefly by Guha, Rama, Lakshmana, and Sita proceeded further into the depths of the forest.
            They moved from one woodland to another (Vanena Vanam), marking the start of their rigorous ascetic life.
            On their way, they crossed several rivers filled with abundant water (Bahudaka), including the mighty Ganges.
            The association with Guha highlights that for Rama, love is the only true kinship, transcending social status.
            Crossing these vast rivers is a spiritual metaphor for surmounting the formidable obstacles of worldly existence.
            Without chariots or servants, they relied solely on their own strength to navigate the treacherous terrains.
            Sita, who had never walked barefoot on rough ground, participated in this journey with a joyful and calm spirit.
            Lakshmana walked like a vigilant guardian, constantly monitoring the surroundings for the safety of the group.
            This verse reveals Rama's adaptability and His seamless integration with nature and its simple inhabitants.
            Narada provides a vivid account of Rama's physical endurance and His transformation into a forest-dweller.
            This journey was a grand departure from the opulence of Ayodhya toward the profound mysteries of the wild.
        """.trimIndent()
),

// --- CONTINUING TO SHLOKA 50 ---

RamayanVerse(
id = 31,
sanskrit = "भरद्वाजशासनाच्च चित्रकूटमपाश्रयन् ।\nरम्यमावसथं कृत्वा रममाणा वने त्रयः ॥ ३१ ॥",
hindiCommentary = """
            महर्षि भरद्वाज की आज्ञा और निर्देश पाकर वे तीनों पवित्र चित्रकूट पर्वत पर पहुँचे और वहाँ आश्रय लिया।
            वहाँ उन्होंने एक 'रम्य आवसथं' (अत्यंत सुंदर और सुखद पर्णकुटी) का निर्माण किया और वनवास का आनंद लेने लगे।
            चित्रकूट की प्राकृतिक सुंदरता ने उनके वनवास के कष्टों को एक सुखद अनुभव में बदल दिया था।
            भरद्वाज जी जैसे महान ऋषि का मार्गदर्शन यह सिद्ध करता है कि ऋषि समाज राम के अवतार को पहचान चुका था।
            पर्णकुटी का निर्माण लक्ष्मण जी ने किया था, जो उनकी रचनात्मकता और सेवा भाव का उत्कृष्ट उदाहरण है।
            यहाँ 'रममाणा' शब्द महत्वपूर्ण है, जो बताता है कि वे वन में दुखी नहीं थे, बल्कि प्रकृति के सान्निध्य में सुखी थे।
            राम और सीता के लिए चित्रकूट का वह समय उनके दांपत्य जीवन के सबसे मधुर और शांतिपूर्ण क्षणों में से एक था।
            लक्ष्मण जी ने एक समर्पित सेवक और रक्षक की भूमिका निभाते हुए उनकी हर आवश्यकता का ध्यान रखा।
            यह स्थान आज भी भक्ति का केंद्र है, जहाँ राम ने सिद्ध किया कि सादगी में ही असली आनंद छिपा होता है।
            नारद जी यहाँ राम के उस स्वरूप को दिखा रहे हैं जो महलों के बिना भी पूरी तरह से तृप्त और प्रसन्न है।
            चित्रकूट का वास वास्तव में तपस्या और दिव्यता के एक सुंदर मिलन का कालखंड था।
        """.trimIndent(),
englishCommentary = """
            Following the instructions of Sage Bharadwaja, the three sought refuge at the sacred Chitrakoota hill.
            There, they constructed a beautiful and charming cottage (Avasatham) and lived happily in the woods.
            The natural splendor of Chitrakoota transformed their period of exile into a delightful spiritual retreat.
            The guidance from a supreme seer like Bharadwaja suggests that the sage community recognized Rama's divinity.
            Lakshmana personally built the dwelling, showcasing His creative skill and His spirit of tireless service.
            The word 'Ramamana' is vital, indicating they were not lamenting their loss but were rejoicing in nature.
            For Rama and Sita, the time spent at Chitrakoota was one of the most serene and romantic periods of their life.
            Lakshmana fulfilled the role of a devoted protector, ensuring every need of the divine couple was met.
            Chitrakoota remains a center of devotion today, where Rama proved that true bliss lies in simple living.
            Narada portrays Rama here as someone who is completely self-satisfied and joyful even without a palace.
            Their stay at Chitrakoota was essentially a period where austerity met absolute divine grace.
        """.trimIndent()
),
RamayanVerse(
id = 32,
sanskrit = "देवैश्च ऋषिभिश्चैव तत्र गत्वाभिपूजितः ।\nचित्रकूटं गते रामे पुत्रशोकातुरस्तथा ॥ ३२ ॥",
hindiCommentary = """
            चित्रकूट में निवास के दौरान देवताओं और महान ऋषियों ने स्वयं वहाँ आकर श्री राम की पूजा और स्तुति की।
            यद्यपि वे मनुष्य रूप में थे, पर उनकी दिव्यता को स्वर्ग के देवता और पृथ्वी के ऋषि भली-भांति पहचानते थे।
            दूसरी ओर, जब राम चित्रकूट में सुखपूर्वक रह रहे थे, तब अयोध्या में राजा दशरथ पुत्र के वियोग में तड़प रहे थे।
            दशरथ जी 'पुत्रशोकातुर' (पुत्र के शोक से व्याकुल) थे, और उनकी यह मानसिक पीड़ा असहनीय होती जा रही थी।
            यह श्लोक जीवन के दो विपरीत ध्रुवों को दिखाता है—एक ओर वन की शांति और दूसरी ओर महल का विलाप।
            देवताओं की पूजा यह संकेत देती है कि राम का वनवास वास्तव में आसुरी शक्तियों के विनाश की योजना का हिस्सा था।
            दशरथ का शोक यह याद दिलाता है कि सांसारिक मोह कभी-कभी कितना आत्मघाती और प्राणलेवा हो सकता है।
            राम की महिमा ऐसी थी कि वन के हिंसक पशु भी उनके प्रभाव से शांत और उनके प्रति श्रद्धालु हो गए थे।
            नारद जी यहाँ कथा के दो समानांतर दृश्यों को जोड़ रहे हैं—चित्रकूट की दिव्यता और अयोध्या की शून्यता।
            राजा दशरथ का विलाप केवल एक पिता का विलाप नहीं, बल्कि सत्य और प्रेम के बीच फंसे एक राजा की लाचारी थी।
            यह श्लोक रामायण की करुणा और गरिमा को एक साथ संतुलित रूप में प्रस्तुत करता है।
        """.trimIndent(),
englishCommentary = """
            While at Chitrakoota, Rama was visited and worshiped by the gods and the great sages of the earth.
            Though He lived as a mortal, His divine essence was recognized by both the celestial and earthly beings.
            Simultaneously, back in Ayodhya, King Dasharatha was suffering intensely due to the separation from his son.
            Dasharatha was 'Putrashokaturah'—distraught by the grief for his son—and his mental agony was peak.
            This verse contrasts two poles of existence: the serenity of the forest versus the lamentation of the palace.
            The worship by gods hints that Rama's exile was part of a larger cosmic plan to destroy demonic forces.
            Dasharatha’s grief serves as a reminder of how fatal and overwhelming worldly attachment can become.
            Such was Rama's aura that even the wild animals of the forest became peaceful and devoted in His presence.
            Narada bridges two parallel scenes here—the divinity of Chitrakoota and the emptiness of Ayodhya.
            The King's lament was not just that of a father, but the tragedy of a monarch caught between Truth and Love.
            This verse beautifully balances the elements of supreme majesty and deep human pathos within the epic.
        """.trimIndent()
),
RamayanVerse(
id = 33,
sanskrit = "राजा दशरथः स्वर्गं जगाम विलपन्सुतम् ।\nगते तु तस्मिन् भरतो वसिष्ठप्रमुखैर्द्विजैः ॥ ३३ ॥",
hindiCommentary = """
            अपने पुत्र राम के नाम का विलाप करते हुए और उन्हें याद करते हुए राजा दशरथ स्वर्ग सिधार गए।
            मरते समय भी उनके मुख पर केवल 'राम' का ही नाम था, जो उनकी अनन्य पितृ-भक्ति का प्रमाण है।
            दशरथ की मृत्यु के बाद, गुरु वसिष्ठ और अन्य प्रमुख ब्राह्मणों ने राज्य की सुरक्षा के लिए विचार-विमर्श किया।
            भरत उस समय अयोध्या में नहीं थे, उन्हें उनके ननिहाल से तुरंत वापस बुलाया गया ताकि शासन संभाला जा सके।
            दशरथ का स्वर्गवास रघुकुल के इतिहास की एक अत्यंत दुखद घटना थी, जिसने अयोध्या को अंधकार में धकेल दिया।
            'विलपन्सुतम्' शब्द यह बताता है कि राजा की आत्मा अपने पुत्र के प्रेम के बिना शरीर छोड़ने को तैयार नहीं थी।
            वसिष्ठ जी की भूमिका यहाँ एक मार्गदर्शक की है, जो संकट के समय धर्म के अनुसार निर्णय लेते हैं।
            अयोध्या की गद्दी खाली थी, और प्रजा के मन में भारी असुरक्षा और शोक की भावना व्याप्त थी।
            यह श्लोक हमें सिखाता है कि समय का चक्र किसी के लिए नहीं रुकता, चाहे वह चक्रवर्ती सम्राट ही क्यों न हो।
            नारद जी यहाँ कथा की गति को बढ़ाते हुए भरत के आगमन की पृष्ठभूमि तैयार कर रहे हैं।
            अब सारी जिम्मेदारी भरत के कंधों पर आने वाली थी, जो स्वयं राम के सबसे बड़े भक्त और सेवक थे।
        """.trimIndent(),
englishCommentary = """
            Lamenting for his son Rama and calling His name repeatedly, King Dasharatha departed for heaven.
            Even at the moment of death, 'Rama' was the only name on his lips, proving his singular devotion as a father.
            Following the King's demise, Sage Vashistha and other prominent priests gathered to secure the kingdom.
            Bharata, who was away at his maternal home, was urgently summoned back to take over the administration.
            The death of Dasharatha was a tragic milestone in the Solar lineage, plunging Ayodhya into deep darkness.
            The phrase 'Vilapansutam' emphasizes that the King's soul was unwilling to leave without his beloved son.
            Sage Vashistha’s role as the royal preceptor becomes crucial here, making decisions based on moral law.
            The throne of Ayodhya was vacant, and the subjects felt a profound sense of insecurity and sorrow.
            This verse teaches us that the wheel of time stops for no one, not even for a universal monarch.
            Narada accelerates the narrative pace, setting the stage for the arrival and reaction of Prince Bharata.
            The entire weight of the empire was now falling on Bharata, who was himself Rama's greatest devotee.
        """.trimIndent()
),
RamayanVerse(
id = 34,
sanskrit = "नियुज्यमानो राज्याय नैच्छद्राज्यं महाबलः ।\nस जगाम वनं वीरो रामपादप्रसादकः ॥ ३४ ॥",
hindiCommentary = """
            जब भरत को अयोध्या का राज्य स्वीकार करने के लिए कहा गया, तो उस महाबली वीर ने उसे ठुकरा दिया।
            भरत ने स्पष्ट कर दिया कि वे राम की अनुपस्थिति में कभी भी उस सिंहासन पर नहीं बैठेंगे जो उनके बड़े भाई का है।
            वे 'महाबल' थे, पर उनकी असली शक्ति उनके त्याग और राम के प्रति उनकी निष्काम भक्ति में छिपी थी।
            वे राम को वापस लाने और उनके चरणों का आशीर्वाद (प्रसादकः) लेने के उद्देश्य से वन की ओर चल दिए।
            भरत का यह निर्णय विश्व इतिहास में स्वार्थ-त्याग का सबसे बड़ा और प्रेरणादायक उदाहरण माना जाता है।
            उन्होंने अपनी माता कैकेयी के वरदान को एक कलंक माना और धर्म को राजनीति से ऊपर रखा।
            उनका वन जाना यह सिद्ध करता है कि एक छोटा भाई अपने बड़े भाई के प्रति कितना निष्ठावान हो सकता है।
            भरत के साथ पूरी अयोध्या की सेना और प्रजा भी राम को वापस लाने की उम्मीद में वन की ओर निकल पड़ी।
            नारद जी यहाँ भरत के उस गौरवमयी चरित्र का गान कर रहे हैं जो राम के चरित्र के पूरक के समान है।
            यह श्लोक सिद्ध करता है कि शक्ति और सत्ता उन्हीं को शोभा देती है जो उन्हें ठुकराने का सामर्थ्य रखते हों।
            भरत की यह यात्रा पश्चाताप की नहीं, बल्कि प्रेम और न्याय की पुनर्स्थापना की एक महान यात्रा थी।
        """.trimIndent(),
englishCommentary = """
            Though urged to accept the kingdom of Ayodhya, the mighty Bharata absolutely refused the throne.
            He clarified that he would never occupy the seat that rightfully belonged to his elder brother Rama.
            Though 'Mahabalah' (of great strength), his true power lay in his sacrifice and selfless devotion to Rama.
            He set out for the forest with the sole intent of pleasing Rama and seeking the grace of His feet (Prasadakah).
            Bharata’s refusal remains the greatest example of self-abnegation and fraternal loyalty in world history.
            He viewed his mother Kaikeyi’s hard-won boons as a stain on his honor and prioritized Dharma over politics.
            His journey to the forest proves the height of loyalty a younger brother can exhibit toward the elder.
            Accompanied by the army and the citizens, Bharata headed into the wild with the hope of bringing Rama back.
            Narada celebrates Bharata's glorious character, which shines as a perfect complement to Rama’s own virtues.
            This verse demonstrates that power and authority are best suited for those who have the strength to reject them.
            Bharata’s expedition was not merely one of repentance, but a pilgrimage of love and restoration of justice.
        """.trimIndent()
),
RamayanVerse(
id = 35,
sanskrit = "गत्वा तु स महात्मानं रामं सत्यपराक्रमम् ।\nअयाचद्भ्रातरं रामं आर्यभावपुरस्कृतः ॥ ३५ ॥",
hindiCommentary = """
            भरत ने वन में जाकर अपने महात्मा भाई श्री राम से भेंट की, जो सत्य और पराक्रम की साक्षात् मूर्ति थे।
            वे राम के चरणों में गिर पड़े और अत्यंत 'आर्यभाव' (श्रेष्ठ और मर्यादित भाव) के साथ उनसे अयोध्या लौटने की विनती की।
            भरत की याचना में कोई लोभ नहीं था, बल्कि वे अपने भाई को उनका खोया हुआ सम्मान और राज्य वापस देना चाहते थे।
            नारद जी यहाँ दो महान आत्माओं के मिलन का वर्णन कर रहे हैं, जहाँ दोनों ही राज्य को एक-दूसरे को सौंपना चाहते हैं।
            'आर्यभावपुरस्कृतः' होने का अर्थ है कि भरत का आचरण पूरी तरह से शिष्टाचार और प्रेम से ओत-प्रोत था।
            उन्होंने राम से कहा—"हे आर्य! आप ही इस पृथ्वी के वास्तविक स्वामी हैं, कृपया लौटकर हमारा पालन करें।"
            राम ने भरत को गले लगा लिया और उनकी इस उदारता को देखकर वन के ऋषि-मुनि भी भावुक हो उठे।
            यह दृश्य यह सिखाता है कि जब हृदय शुद्ध हो, तो बड़ी से बड़ी संपत्ति भी तुच्छ लगने लगती है।
            भरत ने राम को पिता की मृत्यु का समाचार भी दिया, जिससे राम अत्यंत दुखी और शोकग्रस्त हुए।
            नारद जी यहाँ उस संवाद की ओर इशारा कर रहे हैं जहाँ धर्म की सूक्ष्म व्याख्याओं पर चर्चा की गई थी।
            यह श्लोक राम और भरत के बीच के उस अलौकिक प्रेम का साक्षात् प्रमाण है जिसे आज भी दुनिया याद करती है।
        """.trimIndent(),
englishCommentary = """
            Reaching the forest, Bharata approached the high-souled Rama, who was the embodiment of True Prowess.
            He fell at Rama's feet and, with 'Aryabhava' (noble and respectful intent), begged Him to return to Ayodhya.
            Bharata’s plea was devoid of greed; his only desire was to restore his brother’s rightful honor and crown.
            Narada describes the meeting of two great souls, both attempting to give the kingdom away to the other.
            Being 'Aryabhavapuraskritah' means Bharata’s conduct was guided by the highest standards of etiquette and love.
            He urged: "O Noble One! You are the true lord of this earth; please return and rule over us once more."
            Rama embraced Bharata, and seeing this selfless affection, even the forest sages were moved to tears.
            This scene teaches that when the heart is pure, even the greatest material wealth seems utterly insignificant.
            Bharata also broke the news of their father's passing, which caused Rama immense grief and sorrow.
            Narada alludes to the dialogue here where the subtle nuances of Dharma and duty were profoundly discussed.
            This verse stands as eternal testimony to the transcendental love between Rama and Bharata.
        """.trimIndent()
),
RamayanVerse(
id = 36,
sanskrit = "त्वमेव राजा धर्मज्ञ इति रामं वचोऽब्रवीत् ।\nरामोऽपि परमोदारः सुमुखः सुमहायशाः ॥ ३६ ॥",
hindiCommentary = """
            भरत ने राम से दृढ़तापूर्वक कहा—"आप ही धर्म के ज्ञाता हैं और आप ही हमारे वास्तविक राजा हैं।"
            उन्होंने स्पष्ट कर दिया कि राम की अनुपस्थिति में वे स्वयं को कभी भी राजा के रूप में स्वीकार नहीं कर पाएंगे।
            इसके उत्तर में श्री राम ने, जो अत्यंत उदार (परमोदारः) और सदा प्रसन्न रहने वाले (सुमुखः) हैं, भरत को समझाया।
            राम 'सुमहायशाः' (महान कीर्ति वाले) थे, उनका यश उनकी सत्यनिष्ठा और पिता के वचनों के पालन में था।
            राम ने भरत को धर्म की मर्यादा समझाई और कहा कि पिता की आज्ञा का पालन करना ही हम सबका परम कर्तव्य है।
            राम की उदारता यह थी कि उन्होंने भरत के प्रेम का सम्मान किया, पर सत्य के मार्ग से विचलित नहीं हुए।
            सुमुख होने का अर्थ है कि संकट के इस कठिन समय में भी उनके चेहरे पर कोई शिकन या क्रोध नहीं था।
            उन्होंने भरत को सांत्वना दी और उन्हें अयोध्या का शासन संभालने के लिए मानसिक रूप से तैयार किया।
            नारद जी यहाँ राम की अडिगता और उनके नेतृत्व कौशल का एक बहुत ही गहरा परिचय दे रहे हैं।
            राम ने यह सिद्ध किया कि भावनाएं महत्वपूर्ण हैं, पर वे कभी भी सिद्धांत और वचन से ऊपर नहीं हो सकतीं।
            यह संवाद राज्य-धर्म और पुत्र-धर्म के बीच के उस संतुलन को दर्शाता है जो केवल राम ही स्थापित कर सकते थे।
        """.trimIndent(),
englishCommentary = """
            Bharata spoke firmly to Rama: "You are the knower of Dharma, and You alone are our true King."
            He made it clear that in Rama's absence, he could never conceive of himself as the monarch of the land.
            In response, Sri Rama, who is supremely generous (Paramodarah) and ever-cheerful (Sumukhah), advised him.
            Rama was 'Sumahayashah' (of great fame), His glory being rooted in His integrity and obedience to His father.
            Rama explained to Bharata the boundaries of duty, stating that honoring their father's word was their prime duty.
            His generosity lay in acknowledging Bharata's love while refusing to deviate from the path of absolute Truth.
            Being 'Sumukha' implies that even in such a trying and emotional moment, His face betrayed no sign of distress.
            He consoled Bharata and mentally prepared him to take over the governance of Ayodhya with a firm hand.
            Narada provides a deep insight into Rama's steadfastness and His unparalleled skills in moral leadership.
            Rama proved that while emotions are vital, they can never override fundamental principles and promises.
            This dialogue illustrates the perfect balance between statecraft and filial duty that only Rama could establish.
        """.trimIndent()
),
RamayanVerse(
id = 37,
sanskrit = "न चानैच्छत्पितुरादेशाद्राज्यं रामो महाबलः ।\nपादुके चास्य राज्याय न्यासं दत्त्वा पुनः पुनः ॥ ३७ ॥",
hindiCommentary = """
            महाबली राम ने पिता के आदेश के विरुद्ध जाकर राज्य को स्वीकार करने से स्पष्ट मना कर दिया।
            उन्होंने भरत के बार-बार अनुरोध करने पर भी अपनी सत्यनिष्ठा को भंग नहीं होने दिया।
            अंत में, भरत की व्याकुलता को देखते हुए राम ने अपनी 'पादुकाएं' (चरण-खड़ाऊँ) उन्हें सौंप दीं।
            ये पादुकाएं केवल लकड़ी के टुकड़े नहीं थे, बल्कि वे राम की शक्ति और उनके शासन के 'न्यास' (धरोहर) थे।
            भरत ने इन पादुकाओं को अपने सिर पर रखा और इन्हें ही अयोध्या का वास्तविक शासक मानकर सेवा का प्रण लिया।
            यह श्लोक समर्पण की उस पराकाष्ठा को दिखाता है जहाँ एक खड़ाऊँ भी पूरे साम्राज्य का संचालन कर सकती है।
            राम का राज्य स्वीकार न करना यह बताता है कि वे अपने व्यक्तिगत सुख से अधिक अपने पिता के सम्मान की चिंता करते थे।
            भरत का पादुकाओं को स्वीकार करना यह दर्शाता है कि वे स्वयं को केवल राम के एक दास और प्रतिनिधि के रूप में देखते थे।
            नारद जी यहाँ उस अनोखे शासन की शुरुआत का वर्णन कर रहे हैं जिसे 'पादुका-राज्य' कहा जाता है।
            यह घटना सिखाती है कि नेतृत्व केवल पद से नहीं, बल्कि उस भाव से होता है जो प्रजा के हृदय में श्रद्धा जगाए।
            राम और भरत का यह त्याग पूरी मानवता के लिए निस्वार्थ प्रेम का एक कालातीत और दिव्य अध्याय है।
        """.trimIndent(),
englishCommentary = """
            Mighty Rama, strictly adhering to His father's command, refused to accept the kingdom for Himself.
            Despite Bharata's repeated and emotional pleas, He did not allow His integrity to be compromised.
            Finally, sensing Bharata's intense devotion, Rama bestowed His 'Padukas' (wooden sandals) upon him.
            These sandals were not mere footwear but were a 'Nyasa' (sacred trust) representing Rama’s sovereignty.
            Bharata placed the sandals on his head, vowing to serve them as the actual rulers of Ayodhya in Rama's stead.
            This verse depicts the peak of surrender, where even a pair of sandals could govern a vast and powerful empire.
            Rama’s refusal highlights that He prioritized His father’s honor far above His own personal comfort or power.
            Bharata’s acceptance shows that he viewed himself merely as a servant and a representative of the true King.
            Narada describes the unique commencement of what is historically known as the 'Rule of the Padukas.'
            This event teaches that leadership is not about the position but about the spirit that inspires reverence in all.
            The mutual sacrifice of Rama and Bharata remains a timeless and divine chapter of selfless love for humanity.
        """.trimIndent()
),
RamayanVerse(
id = 38,
sanskrit = "भरतं च निवर्तयित्वा सर्वकामैरनुत्तमैः ।\nअवाप्य च ततः श्रीमान् भरतो नन्दिग्राममवसत्तदा ॥ ३८ ॥",
hindiCommentary = """
            राम ने भरत को सांत्वना देकर और उन्हें सब प्रकार के उत्तम आशीष देकर अयोध्या की ओर वापस भेज दिया।
            श्रीमान भरत, राम की पादुकाओं को लेकर अयोध्या लौटे पर वे राजमहल के भीतर नहीं गए।
            उन्होंने अयोध्या के पास ही 'नन्दिग्राम' नामक स्थान को अपना निवास बनाया और वहीं से शासन करने लगे।
            भरत ने भी एक तपस्वी का वेश धारण किया, जटाएं रखीं और केवल कंद-मूल खाकर राम के लौटने का इंतजार किया।
            वे पादुकाओं को सिंहासन पर रखते थे और हर राजसी निर्णय के लिए उनसे मौन अनुमति लेते थे।
            'सर्वकामैरनुत्तमैः' का अर्थ है कि राम ने भरत के हृदय की हर शंका को अपने ज्ञान और प्रेम से मिटा दिया था।
            नन्दिग्राम का वास भरत की उस तपस्या का प्रतीक है जो राम के वनवास के बराबर ही कठिन और महान थी।
            यह श्लोक भरत के उस वैराग्य को दर्शाता है जिसने उन्हें एक राजकुमार से एक महान संत बना दिया था।
            नारद जी यहाँ स्पष्ट कर रहे हैं कि भरत ने राज्य का संचालन केवल एक कर्तव्य के रूप में किया, भोग के रूप में नहीं।
            उनका जीवन यह सिखाता है कि कर्तव्य का पालन करते हुए भी व्यक्ति मानसिक रूप से विरक्त रह सकता है।
            अयोध्या की प्रजा भरत के इस त्याग को देखकर राम और भरत—दोनों के प्रति नतमस्तक थी।
        """.trimIndent(),
englishCommentary = """
            After consoling Bharata and blessing him with the best of wishes, Rama sent him back toward Ayodhya.
            The glorious Bharata returned with Rama’s sandals but chose not to enter the inner luxuries of the capital.
            He established his residence in 'Nandigrama' and conducted the affairs of the state from that humble village.
            Bharata adopted the lifestyle of an ascetic, wearing matted hair and eating only roots, awaiting Rama's return.
            He placed the sandals on the throne and sought their silent approval for every administrative decision he made.
            The phrase 'Sarvakamairanuttamaih' implies that Rama had quenched every doubt in Bharata's heart with love.
            Nandigrama became the symbol of a penance that was as rigorous and great as Rama’s own exile in the woods.
            This verse portrays the detachment of Bharata, transforming him from a prince into a supreme saintly figure.
            Narada clarifies that Bharata administered the kingdom solely as a sacred duty, not for any personal pleasure.
            His life teaches that one can remain mentally detached even while fulfilling the heaviest of worldly responsibilities.
            The citizens of Ayodhya, witnessing Bharata's sacrifice, were filled with awe and reverence for both brothers.
        """.trimIndent()
),
RamayanVerse(
id = 39,
sanskrit = "दण्डकारण्यमगमच्छ्रीमान्रावजिगीषया ।\nप्रविवेश ततः श्रीमान् दण्डकारण्यमव्ययः ॥ ३९ ॥",
hindiCommentary = """
            भरत के जाने के बाद, श्रीमान राम ऋषियों की रक्षा और राक्षसों के वध की इच्छा से दण्डकारण्य की ओर बढ़े।
            वे 'अव्ययः' (अविनाशी और निर्विकार) प्रभु थे, जो अपनी लीला से असुरों के विनाश का मार्ग प्रशस्त कर रहे थे।
            दण्डकारण्य वह भयंकर और विशाल वन था जहाँ राक्षसों का आतंक छाया हुआ था और ऋषि-मुनि भयभीत थे।
            राम का वहाँ प्रवेश करना अन्याय के विरुद्ध युद्ध की एक औपचारिक घोषणा के समान था।
            वे 'श्रीमान' हैं, यानी वनवासी वेश में भी उनकी ईश्वरीय शोभा और तेज कभी कम नहीं हुआ।
            नारद जी यहाँ राम के उस वीर स्वरूप का परिचय दे रहे हैं जो अब अपने मुख्य अवतार-कार्य की ओर बढ़ रहा है।
            राक्षसों को जीतने की इच्छा (जिगीषया) का उद्देश्य व्यक्तिगत विजय नहीं, बल्कि विश्व-शांति और धर्म की स्थापना थी।
            दण्डकारण्य में प्रवेश के साथ ही रामायण का संघर्ष और पराक्रम वाला भाग (Aranya Kand) शुरू होता है।
            वे जानते थे कि यहाँ से उनके जीवन की सबसे बड़ी चुनौतियाँ शुरू होने वाली हैं, पर वे अडिग थे।
            उनका यह कदम ऋषियों के लिए एक बहुत बड़ी राहत और उम्मीद की किरण बनकर आया था।
            यह श्लोक राम के रक्षक स्वरूप और उनके दृढ़ संकल्प को बहुत ही प्रभावशाली ढंग से उजागर करता है।
        """.trimIndent(),
englishCommentary = """
            After Bharata's departure, the glorious Rama moved toward the Dandaka forest with the intent to conquer foes.
            He was 'Avyayah'—the imperishable and changeless Lord—advancing to fulfill the primary mission of His descent.
            Dandakaranya was a vast and terrifying wilderness dominated by demonic forces, causing fear among the sages.
            Rama's entry into this forest was like a formal declaration of war against injustice and demonic oppression.
            Though an ascetic, He remained 'Shriman,' His divine splendor and radiance never diminishing in the wild.
            Narada introduces the heroic aspect of Rama that was now moving toward His core task of destroying evil.
            The desire to conquer (Jigishaya) was not for personal gain but for the restoration of cosmic peace and Dharma.
            The entry into Dandakaranya marks the beginning of the 'Aranya Kanda,' the phase of struggle and valor.
            He knew that His greatest trials were about to begin in this territory, yet He remained perfectly resolute.
            His arrival was seen by the local sages as a great relief and a beacon of hope against the darkness of Ravana.
            This verse effectively highlights Rama’s role as the divine protector and His unwavering commitment to justice.
        """.trimIndent()
),
RamayanVerse(
id = 40,
sanskrit = "तं प्रविश्य महाकायं विराधं नाम राक्षसम् ।\nजघान राघवो वीरो वनं तच्चाप्यशोधयत् ॥ ४० ॥",
hindiCommentary = """
            दण्डकारण्य में प्रवेश करते ही वीर राघव का सामना 'विराध' नामक एक विशालकाय और भयानक राक्षस से हुआ।
            विराध इतना शक्तिशाली था कि उसे किसी अस्त्र-शस्त्र से मारना लगभग असंभव था, पर राम ने उसे मार गिराया।
            राम ने न केवल विराध का वध किया, बल्कि उस पूरे वन को राक्षसी भय से 'अशोधयत्' (शुद्ध और पवित्र) कर दिया।
            यह राम के वनवास का पहला बड़ा युद्ध था, जिसने राक्षसों के साम्राज्य में खलबली मचा दी थी।
            विराध का वध यह सिद्ध करता है कि राम की शक्ति के सामने बड़ी से बड़ी असुरता भी नहीं टिक सकती।
            वन को शुद्ध करने का अर्थ है कि उन्होंने वहाँ फिर से वेदों की ध्वनि और यज्ञों के लिए अनुकूल वातावरण बनाया।
            लक्ष्मण जी ने इस युद्ध में राम का साथ दिया, जिससे उनकी युद्ध कला का भी प्रदर्शन हुआ।
            विराध वास्तव में एक शापित गंधर्व था, जिसे राम के हाथों मृत्यु पाकर अपने मूल स्वरूप की प्राप्ति हुई।
            यह घटना दिखाती है कि राम का दंड भी वास्तव में एक कृपा है, जो जीव को उसके पापों से मुक्त कर देती है।
            नारद जी यहाँ राम के उस योद्धा स्वरूप का गान कर रहे हैं जो दीन-दुखियों के संकट हरने के लिए सदैव तत्पर है।
            इस विजय ने दण्डकारण्य के ऋषियों के मन में राम के प्रति विश्वास और श्रद्धा को और अधिक दृढ़ कर दिया।
        """.trimIndent(),
englishCommentary = """
            Upon entering the forest, the heroic Rama encountered a gigantic and terrifying demon named Viradha.
            Viradha was so formidable that conventional weapons could hardly harm him, yet Rama successfully slew him.
            Rama did not just kill Viradha but also purified (Ashodhayat) that entire region from demonic infestation.
            This was the first major battle of Rama's exile, sending ripples of fear through the demonic hierarchy.
            The destruction of Viradha proves that no amount of dark power can withstand the might of the Divine.
            Purifying the forest meant He re-established an environment conducive to Vedic chanting and sacred sacrifices.
            Lakshmana assisted Rama in this encounter, demonstrating His own exceptional skills in the art of warfare.
            Viradha was actually a cursed Gandharva who attained liberation and his original form upon being slain by Rama.
            This incident reveals that even Rama’s punishment is a form of grace, freeing a soul from its karmic debts.
            Narada celebrates the warrior-spirit of Rama, who is always ready to alleviate the distress of the suffering.
            This victory solidified the faith and reverence of the Dandaka sages in Rama's ability to protect them.
        """.trimIndent()
),
RamayanVerse(
id = 41,
sanskrit = "शरभङ्गं च सुतीक्ष्णं च अगस्त्यं च महातपाः ।\nअगस्त्यभ्रातरं चैव दृष्ट्वा चान्यन् महातपाः ॥ ४१ ॥",
hindiCommentary = """
            महान तपस्वी राम ने वन में शरभङ्ग, सुतीक्ष्ण, अगस्त्य और अगस्त्य के भाई जैसे महान ऋषियों के दर्शन किए।
            इन ऋषियों ने राम का स्वागत किया और उन्हें वन में राक्षसों द्वारा किए जा रहे अत्याचारों से अवगत कराया।
            ऋषि शरभङ्ग ने तो राम के दर्शनों के बाद ही अपने शरीर का त्याग किया, जो उनकी प्रतीक्षा की पराकाष्ठा थी।
            अगस्त्य मुनि ने राम को अमोघ अस्त्र और दिव्य धनुष प्रदान किए, जो आगामी युद्धों के लिए अत्यंत आवश्यक थे।
            राम का ऋषियों के पास जाना यह दिखाता है कि एक योद्धा को भी हमेशा ज्ञान और आशीर्वाद की आवश्यकता होती है।
            ये ऋषि दण्डकारण्य के आध्यात्मिक प्रकाश स्तंभ थे, जिन्होंने राम के अवतार-कार्य में महत्वपूर्ण भूमिका निभाई।
            नारद जी यहाँ राम की श्रद्धा और उनकी विनम्रता का वर्णन कर रहे हैं, जो ऋषियों के सामने एक बालक के समान थे।
            इन मुलाकातों ने राम को राक्षसों के ठिकानों और उनकी शक्तियों के बारे में भी महत्वपूर्ण जानकारी प्रदान की।
            अगस्त्य के भाई और अन्य ऋषियों का उल्लेख यह बताता है कि पूरा तपोवन राम के स्वागत में खड़ा था।
            यह श्लोक भक्ति और शक्ति के उस मिलन को दर्शाता है जहाँ ऋषि और राजा एक ही लक्ष्य के लिए साथ आए थे।
            राम की यह यात्रा अब केवल व्यक्तिगत वनवास नहीं, बल्कि धर्म की पुनर्स्थापना का एक संगठित अभियान बन गई थी।
        """.trimIndent(),
englishCommentary = """
            The great ascetic Rama visited supreme sages like Sarabhanga, Sutikshna, Agastya, and Agastya's brother.
            These seers welcomed Rama and informed Him about the atrocities being committed by demons in the forest.
            Sage Sarabhanga specifically waited for Rama’s arrival before casting off his body and attaining liberation.
            Sage Agastya bestowed upon Rama unfailing weapons and a divine bow, essential for the battles ahead.
            Rama’s visits to these sages demonstrate that even a great warrior must seek wisdom and divine blessings.
            These sages were the spiritual pillars of Dandaka, playing a pivotal role in the mission of the Incarnation.
            Narada describes Rama's humility and deep reverence as He sat before the sages like a humble seeker.
            These encounters provided Rama with strategic intelligence regarding the demonic strongholds and powers.
            The mention of Agastya's brother and other seers implies that the entire ascetic community supported Rama.
            This verse depicts the union of spiritual power and physical valor, where seers and the King joined forces.
            Rama’s journey had now evolved from a personal exile into an organized campaign for the restoration of Dharma.
        """.trimIndent()
),
RamayanVerse(
id = 42,
sanskrit = "अगस्त्यवचनाच्चैव जग्राहैन्द्रं शरासनम् ।\nखड्गं च परमप्रीतस्तूणी च अक्षय्यसायकौ ॥ ४२ ॥",
hindiCommentary = """
            अगस्त्य मुनि के कहने पर राम ने इन्द्र का वह प्रसिद्ध धनुष (शरासनम्) और एक दिव्य तलवार (खड्गं) ग्रहण की।
            मुनि ने उन्हें दो ऐसे तरकश (तूणी) भी दिए जिनके बाण कभी समाप्त नहीं होते थे (अक्षय्यसायकौ)।
            इन अस्त्रों को पाकर राम अत्यंत प्रसन्न (परमप्रीत) हुए, क्योंकि ये अस्त्र धर्म की रक्षा के अजेय साधन थे।
            इन्द्र का धनुष यह संकेत देता है कि अब राम की मानवीय शक्ति को देवताओं का भी पूरा समर्थन प्राप्त था।
            अक्षय तरकश का होना यह सुनिश्चित करता था कि राम युद्धभूमि में कभी भी निहत्थे या असहाय नहीं होंगे।
            अगस्त्य जी ने ये शस्त्र राम को इसलिए सौंपे क्योंकि वे जानते थे कि रावण का विनाश अब निकट है।
            यह श्लोक राम के पूर्णतः 'सज्ज' (Ready) होने की घोषणा है, जहाँ वे अब एक महायोद्धा के रूप में प्रकट हो रहे हैं।
            तलवार और धनुष का यह मेल यह बताता है कि राम हर प्रकार के युद्ध—निकट और दूर—में निपुण थे।
            नारद जी यहाँ राम की उस शस्त्र-सम्पदा का वर्णन कर रहे हैं जो ऋषियों द्वारा उन्हें उपहार स्वरूप दी गई थी।
            इन दिव्य उपकरणों का मिलना यह सिद्ध करता है कि राम का लक्ष्य व्यक्तिगत नहीं, बल्कि ब्रह्मांडीय कल्याण था।
            अब राम दण्डकारण्य के सबसे शक्तिशाली रक्षक बन चुके थे, जिनके सामने कोई भी असुर टिक नहीं सकता था।
        """.trimIndent(),
englishCommentary = """
            On Agastya's advice, Rama accepted the famous bow of Indra and a celestial sword of immense power.
            The sage also gifted Him two quivers (Tuni) containing arrows that were inexhaustible (Akshayyasayakau).
            Rama was supremely pleased (Paramapritah) to receive these, as they were the invincible tools for protecting Dharma.
            Indra's bow signifies that Rama’s human endeavor now had the full backing and sanction of the celestial gods.
            The inexhaustible quivers ensured that Rama would never be unarmed or vulnerable in any prolonged battle.
            Agastya handed over these weapons because he foresaw that the time for Ravana’s destruction was drawing near.
            This verse announces Rama's complete readiness as He emerges now as a fully-equipped divine warrior.
            The combination of the sword and the bow illustrates Rama's versatility in all forms of combat, near and far.
            Narada describes the arsenal of divine weapons gifted to Rama as a result of His reverence for the sages.
            Acquiring these celestial tools proves that Rama's mission was not personal but for the welfare of the cosmos.
            Rama had now become the most powerful guardian of Dandaka, against whom no demon could hope to survive.
        """.trimIndent()
),
RamayanVerse(
id = 43,
sanskrit = "वसतस्तस्य रामस्य वने वनचरैः सह ।\nऋषयोऽभ्यागमन् सर्वे वधाय असुररक्षसाम् ॥ ४३ ॥",
hindiCommentary = """
            जब राम वनवासियों और लक्ष्मण-सीता के साथ वन में रह रहे थे, तब सभी ऋषि-मुनि उनके पास एकत्र हुए।
            उन्होंने राम से राक्षसों और असुरों के वध (वधाय असुररक्षसाम्) के लिए करुण पुकार और प्रार्थना की।
            ऋषियों ने अपनी हड्डियों के ढेर दिखाए और बताया कि कैसे राक्षस उनके यज्ञों और तपस्या में बाधा डालते हैं।
            राम ने उन सबकी पीड़ा को सुना और वहीं यह प्रतिज्ञा की कि वे इस पृथ्वी को राक्षसों से विहीन कर देंगे।
            यह 'अभ्यागमन्' (पास आना) ऋषियों के उस अटूट विश्वास को दर्शाता है जो उन्हें राम की शक्ति पर था।
            राम का उत्तरदायित्व यहाँ और बढ़ गया, क्योंकि अब वे ऋषियों के वचनों से बंध चुके थे।
            वनचरों के साथ रहना यह बताता है कि राम ने प्रकृति और उसके साधारण निवासियों के साथ एकाकार कर लिया था।
            राक्षसों का आतंक इतना अधिक था कि ऋषियों के लिए शांतिपूर्वक ध्यान करना भी असंभव हो गया था।
            नारद जी यहाँ उस महान प्रतिज्ञा की पृष्ठभूमि बता रहे हैं जो आगे चलकर रावण के अंत का कारण बनी।
            राम ने स्पष्ट किया कि राजा का पहला धर्म उन लोगों की रक्षा करना है जो धर्म के मार्ग पर चल रहे हैं।
            इस श्लोक के साथ ही राम के जीवन का 'असुर-निकंदन' (असुरों का नाश करने वाला) पक्ष मुख्य धारा में आता है।
        """.trimIndent(),
englishCommentary = """
            While Rama was living in the forest with the wild inhabitants, all the sages approached Him together.
            They pleaded with Him and prayed for the annihilation of the oppressive demons and Asuras.
            The sages showed Him heaps of bones and narrated how demons disrupted their sacred sacrifices and penance.
            Rama listened to their collective agony and made a solemn vow there to rid the earth of demonic forces.
            The act of 'Abhyagaman' (approaching) reflects the absolute faith the ascetic community placed in Rama’s might.
            Rama's responsibility intensified here, as He was now bound by His word to the holy men of the forest.
            Living with 'Vanacharas' indicates that Rama had completely identified Himself with nature and its simple folk.
            The demonic terror was so pervasive that it had become impossible for the seers to meditate in peace.
            Narada sets the stage for the great vow that would eventually lead to the downfall of Ravana's empire.
            Rama clarified that the primary duty of a ruler is to protect those who walk the path of Righteousness.
            With this verse, the 'Asura-Nikandana' (demon-destroying) aspect of Rama's life becomes the central theme.
        """.trimIndent()
),
RamayanVerse(
id = 44,
sanskrit = "स तेषां प्रतिशुश्राव राक्षसानां वधं रणे ।\nप्रतिज्ञाय च रामेण वधं रक्षसां सत्रपः ॥ ४४ ॥",
hindiCommentary = """
            राम ने उन ऋषियों के सामने युद्ध के मैदान (रणे) में राक्षसों के वध की प्रतिज्ञा (प्रतिशुश्राव) की।
            वे अपनी प्रतिज्ञा के प्रति इतने दृढ़ थे कि उन्होंने इसे अपना जीवन-उद्देश्य बना लिया।
            'सत्रपः' शब्द यह संकेत देता है कि राम ने इस कार्य को बड़ी विनम्रता और जिम्मेदारी के साथ स्वीकार किया।
            उन्होंने ऋषियों को आश्वस्त किया कि अब उनके भय के दिन समाप्त हो गए हैं और न्याय का समय आ गया है।
            राम की प्रतिज्ञा कभी निष्फल नहीं होती, इसलिए राक्षसों का भाग्य उसी क्षण निश्चित हो गया था।
            यह प्रतिज्ञा केवल क्रोधवश नहीं थी, बल्कि यह धर्म की स्थापना के लिए लिया गया एक पवित्र संकल्प था।
            राम ने सिद्ध किया कि एक सच्चा योद्धा वही है जो अपनी शक्ति का उपयोग निर्बलों की सुरक्षा के लिए करे।
            नारद जी यहाँ राम के उस संकल्प की महिमा का गान कर रहे हैं जो पूरे ब्रह्मांड की व्यवस्था को बदलने वाला था।
            लक्ष्मण जी भी इस प्रतिज्ञा के साक्षी थे और वे राम के इस अभियान में उनके सबसे बड़े सहयोगी बने।
            यह श्लोक राम के 'सत्यसंध' (सत्य की प्रतिज्ञा वाले) होने के गुण को एक बार फिर से प्रतिष्ठित करता है।
            अब राम का हर कदम उस महासंग्राम की ओर था जो आने वाली सदियों के लिए एक मिसाल बनने वाला था।
        """.trimIndent(),
englishCommentary = """
            Rama solemnly promised the sages that He would annihilate the demons in the heat of battle (Rane).
            He was so resolute regarding this vow that He made it the primary objective of His divine incarnation.
            The word 'Satrapo' suggests that Rama accepted this duty with immense humility and a sense of gravity.
            He assured the seers that the days of their terror were over and the era of justice had finally arrived.
            A vow made by Rama never fails; thus, the fate of the demonic race was sealed at that very moment.
            This promise was not rooted in anger but was a sacred resolve taken for the re-establishment of Dharma.
            Rama proved that a true warrior is one who utilizes his prowess for the protection of the defenseless.
            Narada celebrates the grandeur of Rama's resolve, which was destined to alter the order of the entire cosmos.
            Lakshmana stood as a witness to this vow and remained the primary ally in Rama’s upcoming campaign.
            This verse re-establishes the 'Satyasandha' attribute of Rama—the one whose promises are eternally true.
            Every step Rama took from here on was leading toward the epic confrontation that would define the ages.
        """.trimIndent()
),
RamayanVerse(
id = 45,
sanskrit = "ऋषीणामग्नि कल्पानां दण्डकारण्यवासिनाम् ।\nपञ्चवट्यां वसतस्तस्य राक्षसी कामरूपिणी ॥ ४५ ॥",
hindiCommentary = """
            अग्नि के समान तेजस्वी दण्डकारण्य के ऋषियों के सान्निध्य में रहते हुए राम पञ्चवटी पहुँचे।
            जब वे पञ्चवटी में निवास कर रहे थे, तब वहाँ 'कामरूपिणी' (इच्छानुसार रूप बदलने वाली) एक राक्षसी आई।
            यह राक्षसी कोई और नहीं, बल्कि रावण की बहन शूर्पणखा थी, जिसका आना विनाश की शुरुआत थी।
            'अग्नि कल्पानां' ऋषियों के बीच रहने का अर्थ है कि राम का चरित्र और भी अधिक निखर और तप चुका था।
            शूर्पणखा ने राम के अलौकिक सौंदर्य को देखा और उन पर मोहित होकर अपना रूप बदल लिया।
            उसका यह छलावा राम के सामने नहीं चल सका, क्योंकि वे तो अंतर्यामी और पूर्णतः संयमी थे।
            पञ्चवटी का स्थान अपनी प्राकृतिक सुंदरता के लिए प्रसिद्ध था, पर अब वहाँ अशांति का प्रवेश हो चुका था।
            यह श्लोक उस घटना की भूमिका है जिसने शान्त वनवास को एक भीषण युद्ध में बदल दिया।
            राक्षसी का 'कामरूपिणी' होना यह बताता है कि बुराई अक्सर आकर्षक रूप धारण करके हमें भ्रमित करने आती है।
            नारद जी यहाँ उस चिंगारी का वर्णन कर रहे हैं जिसने रावण के अहंकार की लंका को जलाकर राख कर दिया।
            यह क्षण रामायण की कथा में एक नया और निर्णायक मोड़ लेकर आता है, जहाँ से संघर्ष तीव्र हो जाता है।
        """.trimIndent(),
englishCommentary = """
            Living near the fire-like radiant sages of Dandaka, Rama eventually settled at the spot named Panchavati.
            While He was residing in Panchavati, a demoness capable of changing forms at will (Kamarupini) arrived.
            This demoness was none other than Shurpanakha, Ravana's sister, whose arrival heralded the beginning of the end.
            Living among 'Agni Kalpanam' sages implies that Rama's character had become even more refined and ascetic.
            Shurpanakha beheld Rama's transcendental beauty and, overcome by lust, assumed a charming disguise.
            Her deception failed before Rama, for He was the inner-controller and perfectly self-restrained.
            Panchavati was renowned for its natural beauty, but now restlessness had entered its peaceful bounds.
            This verse sets the stage for the incident that transformed a quiet exile into a fierce and bloody conflict.
            The demoness being 'Kamarupini' warns that evil often assumes attractive guises to delude and confuse us.
            Narada describes the spark that would eventually burn down the Lanka of Ravana’s monumental ego.
            This moment introduces a new and decisive turn in the epic narrative, where the struggle begins to escalate.
        """.trimIndent()
),
RamayanVerse(
id = 46,
sanskrit = "विरूपिता शूर्पणखा राक्षसी कामरूपिणी ।\nततः शूर्पणखावाक्यादुद्युक्तान् सर्वराक्षसान् ॥ ४६ ॥",
hindiCommentary = """
            राम की आज्ञा से लक्ष्मण ने शूर्पणखा को विरूपित कर दिया (उसकी नाक और कान काट दिए)।
            अपमानित होकर वह राक्षसी रोती हुई अपने भाइयों—खर और दूषण—के पास पहुँचे और उन्हें उकसाया।
            शूर्पणखा के वचनों (वाक्याद्) से उत्तेजित होकर हजारों राक्षस राम और लक्ष्मण पर आक्रमण करने के लिए तैयार हो गए।
            विरूपण का अर्थ यहाँ केवल शारीरिक दंड नहीं, बल्कि उसकी काम-वासना और अहंकार का दमन था।
            शूर्पणखा की वासना ने उसे विनाश के मार्ग पर धकेल दिया था, जो पूरी राक्षस जाति के लिए घातक सिद्ध हुआ।
            खर और दूषण जनस्थान के शक्तिशाली सेनापति थे, जिन्हें अपने बल पर अपार घमंड था।
            नारद जी यहाँ उस श्रृंखला का वर्णन कर रहे हैं जहाँ एक छोटी सी घटना एक बड़े युद्ध का रूप ले लेती है।
            राक्षसों का 'उद्युक्तान्' (तैयार) होना यह बताता है कि वे राम की शक्ति को आंकने में बड़ी भूल कर रहे थे।
            यह युद्ध धर्म और अधर्म के बीच की पहली बड़ी सीधी टक्कर होने वाली थी।
            राम ने अपनी वीरता से यह सिद्ध करना था कि वे अकेले ही हजारों असुरों का सामना कर सकते हैं।
            यह श्लोक उस भीषण संग्राम की पूर्व-सूचना है जिसने दण्डकारण्य की धरती को राक्षसों के रक्त से लाल कर दिया।
        """.trimIndent(),
englishCommentary = """
            Following Rama's instruction, Lakshmana disfigured Shurpanakha (by cutting off her nose and ears).
            Humiliated, the demoness fled to her brothers, Khara and Dushana, inciting them with vengeful words.
            Aggravated by her speech (Vakyad), all the local demons rose in unison to attack Rama and Lakshmana.
            The disfigurement was not just a physical punishment but a symbolic suppression of her lust and ego.
            Shurpanakha’s uncontrolled desire drove her onto a path that proved fatal for her entire demonic race.
            Khara and Dushana were the powerful commanders of Janasthana, possessing immense pride in their might.
            Narada describes the chain of events where a single incident escalated into a full-scale territorial war.
            The demons being 'Udyuktan' (ready/provoked) shows they made a grave error in underestimating Rama’s power.
            This battle was to be the first major direct confrontation between Righteousness and organized Evil.
            Rama was set to prove that He alone could confront and annihilate thousands of Asuras simultaneously.
            This verse provides a prelude to the fierce slaughter that stained the soil of Dandaka with demonic blood.
        """.trimIndent()
),
RamayanVerse(
id = 47,
sanskrit = "खरं दूषणं चैव त्रिशिरसं च राक्षसम् ।\nजघान राघवो युद्धे सर्वेषां पश्यतां मुने ॥ ४७ ॥",
hindiCommentary = """
            हे मुने! वीर राघव ने युद्ध के मैदान में खर, दूषण और त्रिशिरा नामक राक्षसों का संहार कर दिया।
            उन्होंने अकेले ही चौदह हजार राक्षसों की सेना को नष्ट कर दिया, वह भी सभी ऋषियों के देखते-देखते।
            राम का यह पराक्रम अलौकिक था; उन्होंने अपनी फुर्ती और अचूक बाणों से राक्षसों को संभलने का मौका भी नहीं दिया।
            खर और दूषण जैसे अजेय योद्धाओं का अंत यह बताता है कि अधर्म का अंत निश्चित और अनिवार्य है।
            'पश्यतां मुने' का अर्थ है कि ऋषियों ने अपनी आँखों से राम की उस दिव्य शक्ति का साक्षात् चमत्कार देखा।
            यह विजय ऋषियों के लिए अभय का वरदान थी, जिससे उन्हें फिर से शांतिपूर्वक अपनी साधना शुरू करने का मौका मिला।
            राम ने यहाँ एक 'महा-योद्धा' के रूप में अपनी धाक जमा दी, जिसकी गूँज लंका के रावण तक जा पहुँची।
            त्रिशिरा का वध यह दर्शाता है कि राम के बाण किसी भी मायावी शक्ति को भेदने में सक्षम थे।
            नारद जी यहाँ राम की उस सैन्य श्रेष्ठता का गान कर रहे हैं जहाँ उन्होंने संख्या बल को अपनी कुशलता से हरा दिया।
            यह युद्ध रामायण का वह अध्याय है जहाँ राम ने पहली बार अपने विनाशकारी 'रुद्र' रूप का परिचय दिया।
            इस विजय के बाद दण्डकारण्य पूरी तरह से राक्षसों के आतंक से मुक्त और पवित्र हो गया।
        """.trimIndent(),
englishCommentary = """
            O Sage! In that battle, the heroic Rama slew Khara, Dushana, and the three-headed demon Trishira.
            He single-handedly annihilated a massive army of fourteen thousand demons while the sages watched in awe.
            Rama's prowess was transcendental; His speed and unerring arrows gave the demons no time to retaliate.
            The end of seemingly invincible warriors like Khara and Dushana proves that unrighteousness is doomed.
            The phrase 'Pashyatam Mune' indicates that the sages witnessed the direct miracle of Rama’s divine power.
            This victory was a boon of fearlessness for the seers, allowing them to resume their meditation in peace.
            Rama established His reputation here as a supreme warrior, whose fame reached the ears of Ravana in Lanka.
            Slaying Trishira demonstrated that Rama's arrows could penetrate and dismantle any magical or illusory power.
            Narada celebrates Rama's military superiority, where He defeated overwhelming numbers with sheer skill.
            This battle is the chapter where Rama first introduced His destructive 'Rudra' aspect to the world of demons.
            Following this monumental victory, Dandakaranya was completely purged of terror and became holy once more.
        """.trimIndent()
),
RamayanVerse(
id = 48,
sanskrit = "निहतं राक्षसं ज्ञात्वा रावणः क्रोधमूर्च्छितः ।\nमारीचं साहाय्यं चक्रे रावणो नाम राक्षसः ॥ ४८ ॥",
hindiCommentary = """
            जब रावण को पता चला कि राम ने उसके शक्तिशाली भाइयों और सेना का वध कर दिया है, तो वह क्रोध से मूर्च्छित हो गया।
            उसका अहंकार बुरी तरह घायल हो गया था और उसने बदला लेने के लिए एक कुटिल और नीच योजना बनाई।
            उसने मारीच नामक राक्षस को अपने साथ लिया और उससे साहाय्य (मदद) मांगी ताकि वह राम को धोखा दे सके।
            रावण का क्रोध उसकी बुद्धि पर हावी हो गया था, जिसके कारण वह अपनी मृत्यु की ओर खिंचा चला जा रहा था।
            मारीच पहले भी राम की शक्ति का अनुभव कर चुका था, इसलिए वह डरा हुआ था पर रावण के दबाव में उसे मानना पड़ा।
            यहाँ से 'माया' का खेल शुरू होता है, जहाँ छल का उपयोग करके धर्म को चुनौती दी जाने वाली थी।
            नारद जी यहाँ रावण के पतन की शुरुआत का वर्णन कर रहे हैं, जहाँ उसने छल का सहारा लिया।
            रावण जानता था कि वह सीधे युद्ध में राम को नहीं जीत सकता, इसलिए उसने कायरतापूर्ण मार्ग चुना।
            यह श्लोक हमें सिखाता है कि अत्यधिक क्रोध व्यक्ति को विनाशकारी और गलत निर्णयों की ओर ले जाता है।
            मारीच का साथ लेना यह बताता है कि दुष्ट लोग हमेशा अपनी योजनाओं में दूसरों को भी घसीटते हैं।
            यह क्षण रामायण की सबसे दुखद और महत्वपूर्ण घटना—सीता हरण—की आधारशिला रखता है।
        """.trimIndent(),
englishCommentary = """
            Upon learning that Rama had slain his powerful brothers and army, Ravana was nearly unconscious with rage.
            His monumental ego was severely wounded, and he devised a cunning and malicious plan for revenge.
            He enlisted the help of the demon Maricha, seeking his assistance to deceive and distract Rama.
            Ravana's wrath had clouded his judgment, pulling him inexorably toward his own ultimate destruction.
            Maricha, having experienced Rama’s power before, was terrified but was forced to comply under Ravana's threat.
            From this point, the 'Play of Illusion' (Maya) begins, where trickery was used to challenge Righteousness.
            Narada describes the beginning of Ravana's downfall, marked by his reliance on cowardly deceit.
            Ravana realized he could not defeat Rama in a direct confrontation, so he chose the path of a thief.
            This verse teaches that extreme anger leads an individual toward destructive and fatal decisions.
            The involvement of Maricha shows how the wicked always drag others into their nefarious schemes.
            This moment lays the foundation for the most tragic and pivotal event of the epic—the abduction of Sita.
        """.trimIndent()
),
RamayanVerse(
id = 49,
sanskrit = "वार्यमाणः सुबहुशो मारीचस्तेन रावणः ।\nन विरोधो बलवता क्षमस्तेन रावण ॥ ४९ ॥",
hindiCommentary = """
            मारीच ने रावण को बहुत समझाया और चेतावनी दी कि उसे राम के साथ विरोध (शत्रुता) नहीं करना चाहिए।
            उसने कहा—"हे रावण! जो तुमसे कहीं अधिक बलवान है, उसके साथ दुश्मनी करना तुम्हारे लिए हितकारी नहीं है।"
            मारीच जानता था कि राम कोई साधारण मनुष्य नहीं, बल्कि साक्षात् काल के समान अजेय योद्धा हैं।
            उसने रावण को अपनी पिछली हार और राम के बाणों के वेग की याद दिलाई ताकि वह रुक जाए।
            परन्तु विनाशकाले विपरीत बुद्धि—रावण के सिर पर विनाश सवार था, इसलिए उसने अच्छी सलाह को ठुकरा दिया।
            यह श्लोक एक महान उपदेश है कि अपनी शक्ति का सही आकलन करना ही बुद्धिमत्ता की पहली निशानी है।
            मारीच का बार-बार मना करना (सुबहुशो) यह सिद्ध करता है कि बुराई के भीतर भी कभी-कभी सत्य की समझ होती है।
            रावण का अहंकार इतना बड़ा था कि उसने एक अनुभवी राक्षस की चेतावनी को भी अनसुना कर दिया।
            नारद जी यहाँ रावण की उस हठधर्मिता को दिखा रहे हैं जो उसके पूरे कुल के विनाश का कारण बनी।
            शक्तिशाली से शत्रुता करना आत्मघाती है, विशेषकर तब जब वह शत्रु धर्म और सत्य के पक्ष में खड़ा हो।
            यह संवाद रावण की मानसिकता और उसके आने वाले अंत के प्रति उसकी अज्ञानता को उजागर करता है।
        """.trimIndent(),
englishCommentary = """
            Maricha repeatedly tried to dissuade Ravana, warning him against harboring enmity toward Rama.
            He cautioned: "O Ravana! It is not wise or capable for you to oppose one who is far mightier than you."
            Maricha understood that Rama was no ordinary mortal but an invincible warrior equal to Time itself.
            He reminded Ravana of his own past defeat and the terrifying speed of Rama’s arrows to stop him.
            However, as the proverb goes, 'Destiny clouds the mind before destruction'—Ravana rejected this sane advice.
            This verse provides a great lesson: the first sign of wisdom is an accurate assessment of one's own power.
            Maricha’s persistent warnings (Subahusho) prove that even within evil, there is sometimes a glimpse of Truth.
            Ravana’s arrogance was so immense that he ignored the warnings of an experienced and terrified ally.
            Narada portrays the obstinacy of Ravana, which became the sole reason for the annihilation of his entire clan.
            Enmity with the powerful is suicidal, especially when that opponent is anchored in Truth and Dharma.
            This dialogue highlights Ravana’s distorted mindset and his utter ignorance regarding his impending doom.
        """.trimIndent()
),
RamayanVerse(
id = 50,
sanskrit = "अनादृत्य तु तद्वाक्यं रावणः कालचोदितः ।\nजगाम सहमारीचः तस्याश्रमपदं तदा ॥ ५० ॥",
hindiCommentary = """
            रावण ने मारीच के उन हितकारी वचनों का अनादर किया, क्योंकि वह स्वयं काल के वश (कालचोदितः) में था।
            वह मारीच के साथ सीधे राम के आश्रम की ओर चल दिया, ताकि अपनी कुत्सित योजना को अंजाम दे सके।
            'कालचोदितः' होने का अर्थ है कि जब किसी का बुरा समय आता है, तो वह स्वयं अपने विनाश का मार्ग चुनता है।
            उसने मारीच को सोने का मृग बनने के लिए मजबूर किया, जिससे सीता जी का मन मोह लिया जा सके।
            रावण का यह कदम महान रघुकुल की मर्यादाओं को चुनौती देने वाला और एक अक्षम्य अपराध था।
            वह आश्रम जहाँ केवल शांति और पवित्रता थी, अब छल और कपट की छाया में आने वाला था।
            मारीच विवश था; वह जानता था कि राम के हाथों मरना रावण के हाथों मरने से कहीं अधिक श्रेष्ठ और मोक्षदायी है।
            नारद जी यहाँ उस पल का वर्णन कर रहे हैं जहाँ से रामायण का सबसे मार्मिक विरह काल शुरू होता है।
            यह श्लोक हमें सिखाता है कि जब व्यक्ति अहंकार में अंधा होता है, तो वह अच्छे परामर्श को भी शत्रुता मानता है।
            रावण की यह यात्रा लंका के पतन और राम के 'रावणारि' (रावण के शत्रु) बनने की पहली सीढ़ी थी।
            अब प्रकृति और नियति मिलकर उस महायज्ञ की तैयारी कर रहे थे जिसमें रावण की असुरता की आहुति दी जानी थी।
        """.trimIndent(),
englishCommentary = """
            Ravana disregarded Maricha’s sound advice, for he was driven by his own impending doom (Kalachoditah).
            Accompanied by Maricha, he headed straight toward Rama’s hermitage to execute his sinister plan.
            Being 'Kalachoditah' implies that when a person's end is near, they instinctively choose the path of ruin.
            He forced Maricha to transform into a golden deer to delude and captivate the mind of Sita.
            This move of Ravana was an unforgivable crime and a direct challenge to the dignity of the Solar lineage.
            The hermitage, once a sanctuary of peace and purity, was now falling under the shadow of deceit and fraud.
            Maricha was helpless; he realized that dying at the hands of Rama was far superior to being killed by Ravana.
            Narada describes the exact moment from which the most poignant period of separation in the epic begins.
            This verse teaches that when blinded by ego, an individual views even the best counsel as an act of hostility.
            Ravana’s journey was the first step toward the fall of Lanka and the manifestation of Rama as 'Ravanari.'
            Nature and Destiny were now collaborating to prepare for the grand sacrifice in which Ravana's evil would be the oblation.
        """.trimIndent()
),

        RamayanVerse(
            id = 51,
            sanskrit = "तेन मायाविना दूरमपवाह्य नृपात्मजौ ।\nजहार सीतां रावणो गृध्रं हत्वा जटायुषम् ॥ ५१ ॥",
            hindiCommentary = """
            उस मायावी मारीच ने छल से दोनों राजकुमारों—राम और लक्ष्मण को आश्रम से बहुत दूर हटा दिया।
            जब सीता जी अकेली थीं, तब अवसर पाकर रावण ने उनका अपहरण (जहार) कर लिया।
            मार्ग में जब गिद्धराज जटायु ने सीता जी की रक्षा के लिए रावण को रोका, तो रावण ने उनका वध कर दिया।
            मारीच का सोने का मृग बनना एक ऐसा छलावा था जिसने राम की बुद्धि को भी मानवीय लीला में उलझा दिया।
            रावण ने एक सन्यासी का वेष धरकर सीता जी के सतीत्व और उनकी दयालुता का अनुचित लाभ उठाया।
            जटायु का संघर्ष यह सिखाता है कि जब अधर्म बलवान हो, तब भी अपना कर्तव्य निभाना ही सच्ची वीरता है।
            यद्यपि जटायु जानते थे कि रावण अजेय है, फिर भी उन्होंने धर्म की रक्षा के लिए अपने प्राणों की आहुति दी।
            सीता का हरण केवल एक स्त्री का अपहरण नहीं था, बल्कि रावण के विनाश की अंतिम पटकथा का प्रारंभ था।
            नारद जी यहाँ बहुत ही संक्षेप में उस महान त्रासदी का वर्णन कर रहे हैं जिसने राम को व्याकुल कर दिया।
            यह श्लोक कपट और क्रूरता के उस चरम को दिखाता है जहाँ असुरता अपनी मर्यादाएं लांघ जाती है।
            यहाँ से राम की वह विरह-गाथा शुरू होती है जो आगे चलकर लंका के दहन का कारण बनती है।
        """.trimIndent(),
            englishCommentary = """
            The illusory Maricha, through his deceitful tactics, drew the two princes, Rama and Lakshmana, far away.
            Seizing the opportunity when Sita was alone, Ravana abducted her with force and malice.
            When the vulture-king Jatayu intervened to protect her, Ravana ruthlessly struck him down.
            Maricha’s transformation into a golden deer was a masterstroke of 'Maya' that distracted even the Divine.
            Ravana exploited Sita's piety and kindness by appearing in the sacred guise of a wandering ascetic.
            Jatayu’s brave stand teaches us that one must fight for righteousness even against an overwhelming foe.
            Though Jatayu knew Ravana was invincible, he prioritized his moral duty over his own physical survival.
            The abduction of Sita was not just a crime against a woman but the catalyst for the destruction of evil.
            Narada succinctly describes the profound tragedy that plunged the world of Rama into deep darkness.
            This verse highlights the peak of demonic treachery where the forces of ego bypass all ethical bounds.
            From this moment begins the agonizing period of separation that would eventually lead to the fall of Lanka.
        """.trimIndent()
        ),
RamayanVerse(
id = 52,
sanskrit = "सीतां दृष्ट्वा हतां श्रुत्वा क्रोधाच्चैव मलीमसः ।\nगृध्रं च विहतं दृष्ट्वा विललाप स राघवः ॥ ५२ ॥",
hindiCommentary = """
            जब राम वापस लौटे और सीता को वहाँ न पाकर उनके अपहरण की बात सुनी, तो वे शोक और क्रोध से भर गए।
            सीता के वियोग में राम का मुखमंडल 'मलीमसः' (दुख से मलिन और अंधकारमय) हो गया था।
            वहाँ उन्होंने घायल और मरणासन्न जटायु को देखा, जिसने सीता की रक्षा के लिए अपना सर्वस्व न्योछावर कर दिया था।
            राम 'राघव' (रघुकुल के रत्न) होकर भी एक साधारण मनुष्य की तरह फूट-फूट कर विलाप (विललाप) करने लगे।
            उनका यह विलाप उनकी मानवीय लीला का हिस्सा था, जो यह दिखाता है कि प्रेम में ईश्वर भी कितना कोमल होता है।
            वे वन के वृक्षों, पशुओं और गोदावरी नदी से पूछने लगे कि क्या किसी ने उनकी प्रिय सीता को देखा है?
            जटायु की हालत देखकर राम का हृदय करुणा से भर गया, क्योंकि वह गिद्ध उनके पिता दशरथ के मित्र समान था।
            शोक के उस क्षण में भी राम ने जटायु की महानता को पहचाना और उनके प्रति कृतज्ञता व्यक्त की।
            नारद जी यहाँ राम के उस 'मानवीय' पक्ष का चित्रण कर रहे हैं जो भावनाओं के ज्वार में डूबा हुआ है।
            यह श्लोक हमें सिखाता है कि बड़े से बड़ा वीर भी अपनों के बिछड़ने पर संवेदनशील और व्याकुल हो सकता है।
            अब राम का एकमात्र उद्देश्य सीता की खोज और उस पापी का अंत करना था जिसने उन्हें यह दुख दिया।
        """.trimIndent(),
englishCommentary = """
            Upon returning to the empty hut and learning of Sita’s abduction, Rama was consumed by grief and fury.
            His radiant face became 'Malimasah'—clouded and dimmed by the overwhelming weight of His sorrow.
            Finding the mortally wounded Jatayu, He realized the magnitude of the sacrifice made for His beloved.
            Rama, the jewel of the Raghus, lamented (Vilalapa) like an ordinary mortal, showing the intensity of His love.
            His lamentation was part of His 'Manav-Lila,' illustrating that even Divinity experiences the pain of loss.
            He inquired of the trees, the deer, and the river Godavari if they had seen the direction of Sita’s path.
            Seeing Jatayu’s state, His heart overflowed with compassion for the bird who was like a friend to His father.
            Even in His deepest despair, Rama recognized and honored the sublime bravery of the fallen vulture-king.
            Narada portrays the 'Human' aspect of Rama, who is temporarily submerged in an ocean of emotional turmoil.
            This verse teaches us that even the mightiest warriors are subject to the deep sensitivity of human bonds.
            Rama’s focus now shifted entirely toward finding Sita and annihilating the one who caused this agony.
        """.trimIndent()
),
RamayanVerse(
id = 53,
sanskrit = "गृध्रं च दग्ध्वा धर्मात्मा रामः प्रियमनुव्रतः ।\nदण्डकारण्यमुद्देश्य मार्गमाणोऽथ मैथिलीम् ॥ ५३ ॥",
hindiCommentary = """
            धर्मात्मा राम ने अपने प्रति समर्पित जटायु का विधि-विधान से दाह-संस्कार (दग्ध्वा) किया।
            उन्होंने जटायु को वही सम्मान दिया जो एक पुत्र अपने पिता को देता है, जो उनकी महानता का प्रमाण है।
            तपश्चात, अपनी प्रिय पत्नी मैथिली (सीता) की खोज में राम और लक्ष्मण दण्डकारण्य के और भी गहरे भागों में गए।
            'प्रियमनुव्रतः' होने का अर्थ है कि राम अपनी पत्नी के प्रति पूरी तरह समर्पित और उनके विरह में व्याकुल थे।
            उन्होंने वन के चप्पे-चप्पे को छाना, हर कंदरा और झाड़ी में अपनी प्रिय जानकी को ढूँढा।
            जटायु का संस्कार करना यह दर्शाता है कि राम के लिए जाति या योनि नहीं, बल्कि केवल 'भाव' और 'कर्म' महत्वपूर्ण हैं।
            वे जानते थे कि सीता के बिना उनके जीवन का कोई अर्थ नहीं है, पर वे धैर्य के साथ अपना कर्तव्य पथ नाप रहे थे।
            दण्डकारण्य का वह हिस्सा अत्यंत दुर्गम और राक्षसों से भरा था, पर राम का संकल्प हिमालय से भी ऊँचा था।
            नारद जी यहाँ राम की कर्तव्यनिष्ठा और उनके अटूट दांपत्य प्रेम का एक बहुत ही सुंदर समन्वय दिखा रहे हैं।
            यह यात्रा केवल सीता की खोज नहीं थी, बल्कि यह राम के 'संकटमोचक' स्वरूप के प्रकट होने की तैयारी थी।
            शोक के बावजूद राम ने अपने धर्म का परित्याग नहीं किया और मर्यादाओं के भीतर रहकर आगे बढ़े।
        """.trimIndent(),
englishCommentary = """
            The righteous (Dharmanma) Rama performed the last rites and cremated the devoted vulture, Jatayu.
            He accorded Jatayu the same honor a son gives to a father, proving His immense gratitude and nobility.
            Following this, Rama and Lakshmana ventured deeper into Dandaka in search of Maithili (Sita).
            Being 'Priyam-anuvratah' signifies Rama's absolute devotion and singular focus on His beloved wife.
            They scoured every corner of the forest, searching through caves and thickets for any sign of Janaki.
            Cremating a vulture demonstrates that for Rama, character and action matter far more than birth or species.
            He realized that life lacked meaning without Sita, yet He walked the path of duty with grim determination.
            The parts of Dandaka they entered were treacherous and demon-infested, but His resolve was unshakable.
            Narada illustrates a beautiful blend of Rama’s sense of duty and His profound, unshakable marital love.
            This expedition was not just a search for a person; it was the unfolding of Rama as the ultimate savior.
            Despite His agonizing grief, He did not abandon His Dharma and proceeded within the bounds of propriety.
        """.trimIndent()
),
RamayanVerse(
id = 54,
sanskrit = "तत्रैव तां प्रविशन्तां राक्षसीं नाम नामतः ।\nजघान राघवो वीरो वनं तच्चाप्यशोधयत् ॥ ५४ ॥",
hindiCommentary = """
            खोज के दौरान राम का सामना 'अयोमुखी' नामक एक डरावनी और विशाल राक्षसी से हुआ।
            उस वीर राघव ने उस राक्षसी का वध किया और उस पूरे क्षेत्र को उसके आतंक से मुक्त कर दिया।
            सीता की खोज के मार्ग में जो भी बाधाएँ आईं, राम ने अपनी वीरता से उन सबको जड़ से मिटा दिया।
            वन को 'अशोधयत्' (शुद्ध करना) का अर्थ है कि उन्होंने वहाँ ऋषियों के लिए पुनः शांति की स्थापना की।
            हर छोटी विजय राम को उनके बड़े लक्ष्य—रावण के विनाश—की ओर मानसिक रूप से तैयार कर रही थी।
            राम की शक्ति का प्रभाव ऐसा था कि उनके आने मात्र से वन की नकारात्मक ऊर्जा समाप्त होने लगती थी।
            लक्ष्मण जी एक साये की तरह उनके साथ थे, जो हर कदम पर उनकी सुरक्षा और सहायता के लिए तत्पर रहते।
            यह श्लोक राम के उस अनवरत संघर्ष को दिखाता है जो वे अपनी सबसे बड़ी व्यक्तिगत पीड़ा के बीच भी कर रहे थे।
            नारद जी यहाँ राम को एक 'विश्व-शोधक' (World Purifier) के रूप में प्रस्तुत कर रहे हैं।
            बुराई चाहे किसी भी रूप में आए, राम का बाण उसे नष्ट करने के लिए हमेशा सज्ज रहता था।
            यह घटना सिद्ध करती है कि धर्म का मार्ग कभी भी निष्कंटक नहीं होता, उसे अपने शौर्य से बनाना पड़ता है।
        """.trimIndent(),
englishCommentary = """
            During the search, Rama encountered a hideous and powerful demoness named Ayomukhi.
            The heroic Raghava slew her, effectively purging that entire region of her sinister influence.
            Whatever obstacles emerged on the path to finding Sita, Rama dismantled them with His supreme valor.
            Purifying (Ashodhayat) the forest meant He restored the tranquility necessary for the sages to meditate.
            Every small victory served as a mental preparation for the ultimate confrontation with the lord of Lanka.
            Rama's energy was such that His mere presence began to dissolve the negative vibrations of the wild.
            Lakshmana remained by His side like an inseparable shadow, ever-vigilant and ready to assist His brother.
            This verse showcases Rama’s relentless struggle even while He carried the heaviest of personal burdens.
            Narada presents Rama here as a 'World Purifier' who systematically eradicates local evils along His way.
            Evil, in any form or gender, met its match in the unerring and righteous arrows of Lord Rama.
            This incident proves that the path of Dharma is rarely smooth; it must be carved out with courage and skill.
        """.trimIndent()
),
RamayanVerse(
id = 55,
sanskrit = "कबन्धं नाम तं दृष्ट्वा रूपं विकृतदर्शिनम् ।\nजघान राघवो वीरो विमुक्तः स च स्वर्गभाक् ॥ ५५ ॥",
hindiCommentary = """
            आगे बढ़ते हुए राम ने 'कबन्ध' नामक एक अत्यंत विकृत और डरावने राक्षस को देखा, जिसका सिर नहीं था।
            वीर राघव ने उसका वध किया, पर यह वध वास्तव में कबन्ध के लिए एक महान वरदान और मुक्ति का मार्ग था।
            जैसे ही राम ने उस पर प्रहार किया, वह अपने राक्षसी शरीर से मुक्त होकर एक दिव्य रूप में स्वर्ग सिधार गया।
            कबन्ध वास्तव में एक शापित गंधर्व था, जो राम के स्पर्श और उनके हाथों मृत्यु पाने की प्रतीक्षा कर रहा था।
            यह घटना दिखाती है कि राम का क्रोध भी भक्तों और शापित आत्माओं के लिए परम कल्याणकारी है।
            मरते समय कबन्ध ने राम के प्रति कृतज्ञता व्यक्त की और उन्हें सीता की खोज के लिए बहुमूल्य परामर्श दिया।
            उसने राम को सुग्रीव से मित्रता करने की सलाह दी, जो आगे चलकर रामायण का सबसे बड़ा टर्निंग पॉइंट बना।
            राम ने एक असुर के भीतर छिपी उस दिव्य आत्मा को पहचाना और उसे उसके मूल स्वरूप तक पहुँचाया।
            नारद जी यहाँ राम को 'मोक्षदाता' (Giver of Liberation) के रूप में बहुत ही सुंदर ढंग से चित्रित कर रहे हैं।
            यह श्लोक यह संदेश देता है कि ईश्वर के हाथों हारना भी संसार की किसी भी जीत से कहीं अधिक श्रेष्ठ है।
            कबन्ध की मुक्ति ने सिद्ध कर दिया कि राम केवल शरीर का नाश नहीं करते, बल्कि आत्मा का उद्धार करते हैं।
        """.trimIndent(),
englishCommentary = """
            Moving forward, Rama encountered 'Kabandha,' a monster with a highly distorted and headless form.
            The heroic Rama slew him, but this destruction was actually a sublime act of liberation for the entity.
            Upon being struck by Rama, Kabandha was freed from his demonic shell and ascended to heaven in a divine form.
            Kabandha was originally a cursed Gandharva, waiting specifically for Rama's touch to end his long misery.
            This incident illustrates that even Rama's wrath is a form of grace for suffering and cursed souls.
            Before departing, the liberated being expressed gratitude and offered strategic advice for the search of Sita.
            He suggested that Rama should seek an alliance with Sugriva, which became the pivotal turn in the epic.
            Rama recognized the divine spark within the monstrous exterior and restored the soul to its original glory.
            Narada beautifully depicts Rama here as the 'Mokshadata'—the ultimate granter of spiritual liberation.
            This verse conveys the message that losing to God is infinitely superior to any worldly victory over man.
            Kabandha’s redemption proved that Rama does not just end lives; He heals and uplifts the very essence of being.
        """.trimIndent()
),

// --- CONTINUING FROM 56 TO 75 ---

RamayanVerse(
id = 56,
sanskrit = "स च रामं समाख्याय शबरीमभ्यगात्पुनः ।\nशबर्या पूजितः सम्यग्रामो दशरथात्मजः ॥ ५६ ॥",
hindiCommentary = """
            कबन्ध के बताए मार्ग पर चलते हुए राम मतंग ऋषि के आश्रम पहुँचे, जहाँ परम भक्त शबरी रहती थी।
            शबरी ने अपने आराध्य राम का विधिवत पूजन (पूजितः) किया और उन्हें अपने प्रेम से सराबोर कर दिया।
            दशरथ-पुत्र राम ने शबरी की भक्ति को स्वीकार किया और उसकी वर्षों की तपस्या को सफल बना दिया।
            शबरी ने राम को चख-चख कर मीठे बेर खिलाए, जिन्हें राम ने बड़े चाव से खाया, जो उनके 'भक्त-वत्सल' रूप को दिखाता है।
            यहाँ राम ने सिद्ध किया कि उनके लिए कोई छोटा या बड़ा नहीं है; वे केवल हृदय की शुद्धता देखते हैं।
            शबरी का इंतजार पूरी मानवता के लिए अटूट विश्वास और धैर्य की एक अमर प्रेरणा है।
            मतंग वन का वह वातावरण राम की पीड़ा को कुछ क्षणों के लिए कम करने वाला और शांति देने वाला था।
            ऋषि मतंग के प्रभाव से वहाँ के हिंसक पशु भी अहिंसक हो गए थे, जो राम की दिव्यता के अनुकूल था।
            नारद जी यहाँ राम और शबरी के उस पावन मिलन का वर्णन कर रहे हैं जो भक्ति-साहित्य का शिरोमणि दृश्य है।
            यह श्लोक हमें सिखाता है कि निस्वार्थ प्रेम से ईश्वर को भी अपना बनाया जा सकता है और उन्हें रिझाया जा सकता है।
            शबरी को मोक्ष प्रदान करके राम ने एक बार फिर यह प्रमाणित किया कि वे दीनों के परम बंधु हैं।
        """.trimIndent(),
englishCommentary = """
            Following the path suggested by Kabandha, Rama reached the hermitage where the great devotee Sabari dwelt.
            Sabari worshiped Rama (Pujitah) with profound ritual and unconditional love that touched His divine soul.
            Rama, the son of Dasharatha, accepted her humble offerings, validating her years of arduous penance.
            The scene where Sabari offers tasted berries and Rama eats them with joy reveals His 'Bhakta-Vatsala' nature.
            Here, Rama proved that social hierarchies mean nothing to Him; He values only the purity of the heart.
            Sabari's long wait serves as an eternal inspiration of unwavering faith and patience for all seekers.
            The serene atmosphere of Matanga forest provided Rama a brief respite from His intense personal agony.
            The forest was so holy that even wild predators lived in harmony, matching the tranquility of Rama's presence.
            Narada describes this sacred meeting, which remains one of the most cherished episodes in devotional history.
            This verse teaches that through selfless love, one can indeed capture the heart of the Supreme Being.
            By granting liberation to Sabari, Rama re-affirmed His identity as the ultimate friend of the humble and the poor.
        """.trimIndent()
),
RamayanVerse(
id = 57,
sanskrit = "पम्पातीरे हनुमता सङ्गतो वानरेण च ।\nहनुमद्वचनाच्चैव सुग्रीवेण समागतः ॥ ५७ ॥",
hindiCommentary = """
            पम्पा सरोवर के किनारे राम की भेंट महान वानर हनुमान जी से हुई, जो सुग्रीव के मंत्री थे।
            हनुमान जी ने एक ब्राह्मण का रूप धरकर राम और लक्ष्मण की परीक्षा ली और उनकी वास्तविकता को पहचाना।
            हनुमान जी के वचनों (हनुमद्वचनात्) और उनकी मध्यस्थता के कारण राम का मिलाप राजा सुग्रीव से हुआ।
            यह मिलन रामायण का वह ऐतिहासिक क्षण है जिसने नर और वानर के बीच एक अटूट मैत्री की नींव रखी।
            हनुमान जी ने राम के तेज को पहचान लिया और क्षण भर में ही उनके चरणों में अपना सर्वस्व समर्पित कर दिया।
            पम्पा सरोवर की सुंदरता ने राम के मन में सीता की याद को और तीव्र कर दिया था, पर हनुमान के आगमन ने आशा जगाई।
            सुग्रीव उस समय अपने भाई बाली के डर से ऋष्यमूक पर्वत पर छिपे हुए थे और उन्हें भी एक सहायक की खोज थी।
            हनुमान जी ने सुग्रीव को विश्वास दिलाया कि ये राजकुमार उनकी हर समस्या का समाधान करने में समर्थ हैं।
            नारद जी यहाँ उस कूटनीतिक और भावुक संधि का वर्णन कर रहे हैं जिसने रावण के अंत का मार्ग प्रशस्त किया।
            यह श्लोक हनुमान जी की बुद्धिमत्ता और उनकी सेवा-भावना के प्रथम दर्शन कराता है।
            बिना हनुमान के, सुग्रीव और राम का यह मिलन शायद इतना सहज और प्रभावशाली नहीं होता।
        """.trimIndent(),
englishCommentary = """
            At the banks of the Pampa Lake, Rama met the extraordinary Vanara, Hanuman, for the first time.
            Hanuman, initially in the guise of a Brahmin, assessed Rama and Lakshmana before revealing His true self.
            Through Hanuman's eloquent mediation (Hanumadvacanat), Rama was eventually introduced to Sugriva.
            This meeting is a historic milestone in the epic, laying the foundation for an eternal bond between Man and Vanara.
            Hanuman instantly recognized Rama's divine radiance and surrendered His entire being at His lotus feet.
            While the beauty of Pampa intensified Rama's longing for Sita, Hanuman’s arrival kindled a new ray of hope.
            Sugriva was hiding on Mount Rishyamukha in fear of his brother Bali, himself in dire need of an ally.
            Hanuman convinced Sugriva that these two princes were the answer to his prayers and possessed supreme power.
            Narada describes the diplomatic and emotional alliance that effectively paved the way for Ravana's downfall.
            This verse offers the first glimpse into the unmatched intellect and the profound service-spirit of Hanuman.
            Without Hanuman's intervention, the alliance between Rama and Sugriva might not have been as seamless or potent.
        """.trimIndent()
),
RamayanVerse(
id = 58,
sanskrit = "सुग्रीवेण च तं सर्वं शंसितं रामोऽब्रवीत् ।\nआदितस्तद्यथावृत्तं सीतायाश्च विशेषतः ॥ ५८ ॥",
hindiCommentary = """
            राम ने सुग्रीव को आदि से अंत तक (आदितः) अपने वनवास और विशेष रूप से सीता के हरण की पूरी व्यथा सुनाई।
            उन्होंने बताया कि कैसे एक पापी राक्षस ने छल से उनकी पत्नी का अपहरण किया और वे व्याकुल होकर उन्हें ढूँढ रहे हैं।
            सुग्रीव ने राम की पीड़ा को सहानुभूति के साथ सुना और उन्हें अपनी भी वैसी ही दुखभरी कहानी सुनाई।
            दोनों ही अपनी पत्नियों से बिछड़े हुए थे और दोनों को ही एक बलवान शत्रु से लोहा लेना था।
            राम की स्पष्टवादिता ने सुग्रीव के मन में उनके प्रति गहरा सम्मान और अटूट विश्वास पैदा कर दिया।
            उन्होंने एक-दूसरे के दुख को साझा करके अपनी मित्रता को और अधिक प्रगाढ़ और आत्मीय बना लिया।
            सुग्रीव ने राम को भरोसा दिलाया कि उनके वानर सीता की खोज में पूरी दुनिया को छान मारेंगे।
            यहाँ 'विशेषतः' शब्द यह बताता है कि राम के लिए सीता की खोज ही उनके जीवन का सबसे मुख्य केंद्र था।
            नारद जी यहाँ उस संवाद को उजागर कर रहे हैं जहाँ दो पीड़ित हृदय एक-दूसरे के सहारा बन रहे हैं।
            यह श्लोक मित्रता के उस धर्म को सिखाता है जहाँ एक मित्र दूसरे मित्र के दुख को अपना समझता है।
            राम और सुग्रीव का यह संवाद आगामी युद्ध की रणनीति और विजय का पहला वैचारिक बीज था।
        """.trimIndent(),
englishCommentary = """
            Rama narrated to Sugriva the entire sequence of events from the beginning (Aditah), focusing on Sita’s abduction.
            He described how a sinful demon had deceitfully kidnapped His wife, leaving Him distraught and searching.
            Sugriva listened to Rama's agony with deep empathy and in turn shared his own tragic tale of loss and betrayal.
            Both found themselves in similar circumstances: separated from their wives and facing a formidable enemy.
            Rama's honesty and vulnerability inspired a deep sense of respect and unwavering trust in Sugriva's heart.
            By sharing their mutual sorrows, they transformed a tactical alliance into a profound and personal friendship.
            Sugriva assured Rama that his Vanara scouts would scour every corner of the earth to find the location of Sita.
            The word 'Visheshatah' highlights that for Rama, finding Sita was the singular, absolute priority of His existence.
            Narada illustrates the dialogue where two suffering hearts unite to provide strength and solace to one another.
            This verse teaches the essence of friendship: viewing a friend’s sorrow as one’s own and standing together.
            The conversation between Rama and Sugriva was the first conceptual seed of the upcoming war and ultimate victory.
        """.trimIndent()
),
RamayanVerse(
id = 59,
sanskrit = "सर्वं रामाय सुग्रीवो निवेदितवान् तदा ।\nसख्यं चापि चकाराभ्यां सुग्रीवोऽग्निसाक्षिकम् ॥ ५९ ॥",
hindiCommentary = """
            सुग्रीव ने राम को अपनी सारी परिस्थिति निवेदित की और अग्नि को साक्षी (अग्निसाक्षिकम्) मानकर उनसे मित्रता की।
            अग्नि की उपस्थिति में की गई यह संधि अटूट और पवित्र थी, जिसे तोड़ना किसी के लिए भी संभव नहीं था।
            सुग्रीव ने राम को बताया कि कैसे उनके भाई बाली ने उन्हें अपमानित कर राज्य से निकाल दिया और उनकी पत्नी को छीन लिया।
            राम ने भी वचन दिया कि वे बाली का वध करके सुग्रीव को उनका खोया हुआ सम्मान और राज्य वापस दिलाएंगे।
            यह सख्य (मित्रता) केवल शब्दों का खेल नहीं था, बल्कि दो महान योद्धाओं का एक-दूसरे के प्रति प्राणार्पण था।
            अग्नि को साक्षी बनाना यह दर्शाता है कि यह मैत्री धर्म और सत्य की ऊष्मा से तपकर बनी है।
            सुग्रीव ने राम के चरणों में अपना मस्तक झुकाया और राम ने उन्हें हृदय से लगाकर अपना परम मित्र मान लिया।
            यहाँ से 'वानर-सेना' के संगठन की नींव पड़ी, जो आगे चलकर रावण की लंका को ढहाने वाली थी।
            नारद जी यहाँ उस पवित्र गठबंधन का वर्णन कर रहे हैं जो आज भी विश्व के लिए एक आदर्श उदाहरण है।
            यह श्लोक सिद्ध करता है कि विपत्ति में भी यदि अच्छे मित्र मिल जाएं, तो जीत की राह आसान हो जाती है।
            राम की यह संधि सुग्रीव के लिए अभय दान थी और राम के लिए सीता तक पहुँचने की पहली व्यवस्थित कड़ी।
        """.trimIndent(),
englishCommentary = """
            Sugriva submitted his entire situation to Rama and forged a bond of friendship with Fire as the witness (Agnisakshikam).
            A treaty made in the presence of the holy fire was considered unbreakable, sacred, and divinely sanctioned.
            Sugriva explained how his elder brother Bali had humiliated him, exiled him, and forcefully taken his wife.
            Rama, in turn, vowed to slay Bali and restore to Sugriva his lost dignity, family, and the throne of Kishkindha.
            This 'Sakhya' (friendship) was not mere words; it was a soul-deep commitment between two extraordinary warriors.
            Using Fire as a witness indicates that this alliance was forged in the heat of Truth and spiritual righteousness.
            Sugriva bowed at Rama's feet, and Rama embraced him, accepting him as His foremost and most trusted ally.
            This moment marked the beginning of the mobilization of the Vanara army that would eventually destroy Lanka.
            Narada describes this holy coalition, which remains the ideal standard of friendship for the entire world.
            This verse proves that even in great crisis, having the right allies makes the path to victory manageable.
            This alliance served as a boon of fearlessness for Sugriva and the first organized step for Rama toward Sita.
        """.trimIndent()
),
RamayanVerse(
id = 60,
sanskrit = "ततः प्रीतेन मनसा देवराजस्य वै यथा ।\nआवेद्य सर्वं सुग्रीवो दुःखं पुत्रो यथा पितुः ॥ ६० ॥",
hindiCommentary = """
            सुग्रीव ने राम के प्रति अपना पूरा दुख वैसे ही व्यक्त किया जैसे एक पुत्र अपने पिता (पुत्रो यथा पितुः) के सामने करता है।
            राम का तेज और उनकी दयालुता देखकर सुग्रीव का मन 'प्रीतेन' (अत्यंत प्रसन्न और आश्वस्त) हो गया था।
            उन्हें महसूस हुआ कि राम साक्षात् देवराज इन्द्र के समान शक्तिशाली और करुणामयी आश्रयदाता हैं।
            सुग्रीव ने अपनी हर ग्लानि, भय और असुरक्षा को बिना किसी संकोच के राम के सामने खोलकर रख दिया।
            राम ने भी पिता के समान धैर्य से उनकी बात सुनी और उन्हें सांत्वना देकर साहस प्रदान किया।
            यह उपमा—'पुत्र जैसा पिता से'—राम के उस वात्सल्य और अपनत्व को दर्शाती है जो वे अपने शरण में आए जनों को देते हैं।
            सुग्रीव को अब विश्वास हो गया था कि उनका भविष्य अब सुरक्षित हाथों में है और उनका न्याय निश्चित है।
            राम का व्यक्तित्व इतना विशाल था कि कोई भी उनके सामने आकर अपनी सारी चिंताएं भूल जाता था।
            नारद जी यहाँ राम की 'आश्रय-दाता' (Shelter-Giver) वाली छवि को बहुत ही गहराई से स्थापित कर रहे हैं।
            यह श्लोक हमें सिखाता है कि विश्वास ही किसी भी स्थायी और सफल संबंध की पहली और अनिवार्य शर्त है।
            सुग्रीव की यह शरणागति ही उनके भाग्य के उदय और उनके जीवन के कष्टों के अंत का कारण बनी।
        """.trimIndent(),
englishCommentary = """
            Sugriva poured out his entire grief to Rama just as a son confides in a father (Putro Yatha Pituh).
            Upon beholding Rama's radiance and kindness, Sugriva's heart became 'Pritena'—deeply joyful and reassured.
            He felt that Rama was a protector as mighty and compassionate as Devaraja Indra himself.
            Without any hesitation, Sugriva laid bare all his humiliations, fears, and insecurities before Rama.
            Rama listened with the patience of a father, offering solace and infusing Sugriva with renewed courage.
            The metaphor 'like a son to a father' illustrates the paternal affection Rama bestows upon those in His refuge.
            Sugriva was now convinced that his destiny was in safe hands and that justice would finally be served.
            Such was the magnitude of Rama's persona that anyone in His presence would spontaneously forget their anxieties.
            Narada deeply establishes the image of Rama as the ultimate 'Shelter-Giver' for all distressed souls.
            This verse teaches us that absolute trust is the primary and indispensable condition for any lasting relationship.
            Sugriva’s surrender (Sharanagati) became the catalyst for his rise and the ultimate end of his long suffering.
        """.trimIndent()
),
RamayanVerse(
id = 61,
sanskrit = "तस्य तद्वचनं श्रुत्वा सुग्रीवस्य महात्मनः ।\nप्रतिजज्ञे च वै रामो वधं बालिन आहवे ॥ ६१ ॥",
hindiCommentary = """
            महात्मा सुग्रीव के उन मर्मस्पर्शी वचनों को सुनकर राम ने युद्ध (आहवे) में बाली के वध की प्रतिज्ञा की।
            राम ने सुग्रीव को आश्वस्त किया कि वे अधर्मी बाली का अंत करेंगे और उन्हें न्याय दिलाएंगे।
            यह प्रतिज्ञा केवल एक मित्र की मदद के लिए नहीं थी, बल्कि बाली के अनैतिक कार्यों का दंड देने के लिए थी।
            राम जानते थे कि बाली अत्यंत बलवान है, पर वे यह भी जानते थे कि अधर्म की आयु कभी लंबी नहीं होती।
            'प्रतिजज्ञे' शब्द राम की उस अडिग संकल्प शक्ति का प्रतीक है जो एक बार वचन देने के बाद कभी नहीं डगमगाती।
            सुग्रीव के मन का भय अब समाप्त होने लगा था, क्योंकि उन्हें ब्रह्मांड के सबसे बड़े योद्धा का साथ मिल गया था।
            बाली का वध करना राम के लिए एक नैतिक उत्तरदायित्व बन गया था क्योंकि उसने अपने भाई की पत्नी का हरण किया था।
            नारद जी यहाँ राम को एक 'न्यायाधीश' और 'योद्धा' के संयुक्त स्वरूप में बहुत प्रभावशाली ढंग से प्रस्तुत कर रहे हैं।
            यह श्लोक आगामी 'किष्किन्धा काण्ड' के सबसे बड़े संघर्ष और न्याय की पुनर्स्थापना की घोषणा है।
            राम ने सिद्ध किया कि वे केवल अपने दुख में ही नहीं, बल्कि दूसरों के दुख को भी मिटाने के लिए प्रतिबद्ध हैं।
            उनकी यह प्रतिज्ञा सुग्रीव के लिए एक नया जीवन और एक नई आशा की किरण बनकर सामने आई।
        """.trimIndent(),
englishCommentary = """
            Hearing the heart-rending words of the high-souled Sugriva, Rama vowed to slay Bali in battle (Ahave).
            Rama assured Sugriva that He would end the reign of the unrighteous Bali and ensure justice was served.
            This vow was not merely to assist a friend but to deliver the divine punishment for Bali's immoral acts.
            Rama was aware of Bali’s immense strength, but He also knew that unrighteousness has a short lifespan.
            The term 'Pratijajñe' signifies Rama's unshakable resolve, which never wavers once a promise is made.
            Sugriva’s deep-seated fear began to dissolve as he gained the alliance of the universe's greatest warrior.
            Slaying Bali became a moral imperative for Rama because Bali had wrongfully seized his brother's wife.
            Narada effectively presents Rama here in the dual persona of a supreme Judge and a formidable Warrior.
            This verse acts as the formal declaration of the major conflict in 'Kishkindha Kanda' and the restoration of law.
            Rama proved that He was committed not only to resolving His own grief but to alleviating the sorrows of others.
            His solemn promise emerged as a new life and a beacon of profound hope for the distraught Sugriva.
        """.trimIndent()
),
RamayanVerse(
id = 62,
sanskrit = "बालिनश्च बलं तत्र कथयामास वानरः ।\nसुग्रीवः शङ्कितश्चासीन्नित्यं वीर्येण राघवे ॥ ६२ ॥",
hindiCommentary = """
            सुग्रीव ने राम को बाली के असीमित बल और उसके अजेय होने की पूरी कथा विस्तार से सुनाई।
            बाली को वरदान प्राप्त था कि जो भी उसके सामने आएगा, उसका आधा बल बाली में समा जाएगा।
            इतना ही नहीं, सुग्रीव के मन में राघव (राम) की शक्ति को लेकर भी एक शंका (शङ्कितः) बनी हुई थी।
            उन्हें डर था कि क्या सुकोमल दिखने वाले राम सचमुच उस वज्र के समान बाली को हरा पाएंगे?
            सुग्रीव की यह शंका मानवीय स्वभाव का हिस्सा है, जहाँ व्यक्ति अपनी आँखों देखे चमत्कार पर ही भरोसा करता है।
            उन्होंने राम को बाली द्वारा किए गए बड़े-बड़े कार्यों, जैसे दुन्दुभि राक्षस के वध, के बारे में बताया।
            बाली का डर सुग्रीव की रग-रग में बसा था, इसलिए वे राम की शक्ति की परीक्षा लेना चाहते थे।
            नारद जी यहाँ सुग्रीव की उस मानसिक कशमकश को दिखा रहे हैं जहाँ वे आशा और संदेह के बीच झूल रहे थे।
            राम सुग्रीव की इस शंका से रुष्ट नहीं हुए, बल्कि उन्होंने अपनी मुस्कान से उनकी चिंता को दूर किया।
            यह श्लोक यह संदेश देता है कि ईश्वर अक्सर हमारी शंकाओं को दूर करने के लिए अपनी शक्ति का प्रमाण भी देते हैं।
            राम की वास्तविकता को समझने के लिए सुग्रीव को अभी एक बड़े चमत्कार की आवश्यकता थी।
        """.trimIndent(),
englishCommentary = """
            Sugriva narrated in detail the legends of Bali’s immense strength and his seemingly invincible nature.
            Bali possessed a boon that allowed him to absorb half the strength of anyone who faced him in combat.
            Furthermore, Sugriva harbored a lingering doubt (Shankitah) regarding the true prowess of Raghava (Rama).
            He feared whether the gentle-looking Rama could actually defeat a powerhouse as formidable as Bali.
            Sugriva's doubt is part of the human condition, where one often relies only on visible proof and miracles.
            He informed Rama of Bali's monumental feats, such as the slaughter of the mighty demon Dundubhi.
            The terror of Bali was embedded in Sugriva's very core; hence, he felt the need to test Rama’s capability.
            Narada illustrates Sugriva’s mental conflict here, showing him swaying between hope and skepticism.
            Rama was not offended by Sugriva's doubt; instead, He responded with a calm smile that eased the tension.
            This verse conveys that the Divine often provides proof of His power to solidify the faith of His devotees.
            To fully comprehend Rama’s transcendental reality, Sugriva required a direct demonstration of His might.
        """.trimIndent()
),
RamayanVerse(
id = 63,
sanskrit = "राघवः प्रत्ययार्थं तु दुन्दुभेः कायमुत्तमम् ।\nपादङ्गुष्ठेन चिक्षेप सम्पूर्णं दशयोजनम् ॥ ६३ ॥",
hindiCommentary = """
            सुग्रीव के मन में विश्वास (प्रत्ययार्थं) जगाने के लिए राम ने दुन्दुभि राक्षस के विशाल शरीर के कंकाल को देखा।
            राम ने अपने पैर के अंगूठे (पादङ्गुष्ठेन) के हल्के प्रहार से उस भारी शरीर को दस योजन दूर फेंक दिया।
            यह कार्य बाली के लिए भी अत्यंत कठिन था, पर राम ने इसे एक खेल की तरह सहजता से कर दिखाया।
            जैसे ही वह विशालकाय शरीर आकाश में उड़ता हुआ दूर गिरा, सुग्रीव की आँखें फटी की फटी रह गईं।
            राम की इस अद्भुत शक्ति ने यह सिद्ध कर दिया कि वे कोई साधारण मनुष्य नहीं, बल्कि साक्षात् ईश्वरीय बल हैं।
            पैर का अंगूठा प्रयुक्त करना यह बताता है कि राम की शक्ति का एक छोटा सा अंश भी पूरे जगत को हिला सकता है।
            बाली ने उसी शरीर को अपने हाथों से फेंका था, पर राम ने इसे केवल एक पैर के स्पर्श से कहीं दूर पहुँचा दिया।
            नारद जी यहाँ राम की 'अनंत शक्ति' का एक सजीव उदाहरण प्रस्तुत कर रहे हैं जो संदेह को समूल नष्ट कर देता है।
            यह घटना सुग्रीव के लिए वह निर्णायक क्षण थी जब उनका संदेह श्रद्धा में बदल गया।
            यह श्लोक हमें सिखाता है कि सत्य के प्रमाण के सामने अज्ञान और भ्रम का टिकना असंभव है।
            अब सुग्रीव को पूर्ण विश्वास हो गया था कि राम के रूप में उन्हें अपना रक्षक और बाली का काल मिल गया है।
        """.trimIndent(),
englishCommentary = """
            To instill confidence (Pratyayartham) in Sugriva, Rama observed the skeletal remains of the giant demon Dundubhi.
            With just a light flick of His big toe (Padangusthena), Rama hurled that massive carcass ten yojanas away.
            What was a strenuous task even for the mighty Bali, Rama performed with the effortless ease of child's play.
            As the colossal body went flying through the air and landed a great distance away, Sugriva was left awestruck.
            This miraculous feat proved that Rama was no ordinary mortal but possessed supreme, divine strength.
            The use of only the big toe signifies that even a fraction of Rama’s power is enough to move the cosmos.
            While Bali had used his full physical strength to move that body, Rama did so with a mere casual touch.
            Narada presents a vivid example of Rama's 'Infinite Might,' which completely annihilates all doubt.
            This incident was the turning point for Sugriva, transforming his skepticism into absolute devotion.
            This verse teaches that ignorance and delusion cannot persist once the light of Truth is manifested.
            Sugriva was now utterly convinced that in Rama, he had found his savior and the ultimate nemesis of Bali.
        """.trimIndent()
),
RamayanVerse(
id = 64,
sanskrit = "बिभेद च पुनस्तालान्सप्तैकेन महेषुणा ।\nगिरिं रसातलं चैव जनयन्प्रत्ययं तदा ॥ ६४ ॥",
hindiCommentary = """
            सुग्रीव को पूरी तरह आश्वस्त करने के लिए राम ने एक ही बाण (महेषुणा) से सात विशाल साल के वृक्षों को भेद दिया।
            वह बाण केवल वृक्षों को ही नहीं, बल्कि पर्वत और रसातल (पृथ्वी की गहराई) को भी भेदता हुआ वापस उनके पास आ गया।
            यह एक ऐसा पराक्रम था जिसकी कल्पना करना भी किसी सामान्य योद्धा के लिए असंभव था।
            सातों वृक्षों का एक कतार में होना और उन्हें एक साथ भेदना राम की अचूक निशानेबाजी का प्रमाण था।
            बाली केवल एक वृक्ष को हिला सकता था, पर राम ने सात को जड़ से चीर दिया और पाताल तक की यात्रा कर ली।
            'प्रत्ययं' (विश्वास) जगाने के लिए राम का यह दूसरा और सबसे बड़ा चमत्कार था जिसने सुग्रीव को स्तब्ध कर दिया।
            यह बाण यह भी संकेत देता है कि राम की दृष्टि और उनका न्याय ब्रह्मांड की हर गहराई तक पहुँचता है।
            नारद जी यहाँ राम के उस 'महायोद्धा' स्वरूप को चरम पर दिखा रहे हैं जो अस्त्र-विद्या का स्वामी है।
            सुग्रीव ने अब राम के चरणों में गिरकर क्षमा मांगी कि उन्होंने इतने बड़े अवतारी पुरुष पर संदेह किया।
            यह श्लोक राम की सैन्य कुशलता और उनके दिव्य अस्त्रों की शक्ति का एक अविस्मरणीय वर्णन है।
            इस घटना के बाद सुग्रीव का मन पूरी तरह निर्भय हो गया और वे बाली के विरुद्ध युद्ध के लिए तैयार हो गए।
        """.trimIndent(),
englishCommentary = """
            To fully reassure Sugriva, Rama pierced seven massive Sal trees with a single mighty arrow (Maheshuna).
            The arrow did not just penetrate the trees; it pierced the mountain and reached the netherworld (Rasatala).
            This was a display of prowess that was absolutely inconceivable for any ordinary warrior of that age.
            The alignment of the seven trees and their simultaneous destruction proved Rama's unerring marksmanship.
            While Bali could only shake a single tree, Rama dismantled seven and touched the very core of the earth.
            This was the second and ultimate miracle performed to generate 'Pratyam' (conviction) in Sugriva's heart.
            The arrow’s journey suggests that Rama’s vision and His justice penetrate every layer of existence.
            Narada showcases the peak of Rama's 'Maha-warrior' aspect, appearing as the absolute master of archery.
            Sugriva fell at Rama's feet, seeking forgiveness for having doubted such a transcendental personality.
            This verse is an unforgettable account of Rama's military mastery and the divine potency of His weapons.
            Following this, Sugriva’s heart became completely fearless, and he was ready to face Bali in battle.
        """.trimIndent()
),
RamayanVerse(
id = 65,
sanskrit = "ततः प्रीतमनास्तेन विश्वस्तः स महाकपिः ।\nकिष्किन्धां रामसहितो जगाम च गुहां तदा ॥ ६५ ॥",
hindiCommentary = """
            राम के पराक्रम को देखकर वह महाकपि सुग्रीव अत्यंत प्रसन्न (प्रीतमनाः) और पूरी तरह 'विश्वस्त' हो गए।
            उन्हें अब रत्ती भर भी संदेह नहीं रहा कि राम ही बाली का अंत करेंगे और उन्हें न्याय दिलाएंगे।
            अतः, वे राम के साथ मिलकर किष्किन्धा की गुफा (राजधानी) की ओर युद्ध के संकल्प के साथ चल दिए।
            सुग्रीव का आत्मविश्वास अब सातवें आसमान पर था क्योंकि उनके पीछे ब्रह्मांड की महाशक्ति खड़ी थी।
            किष्किन्धा की ओर जाना यह दर्शाता है कि अब भय का स्थान साहस ने और पलायन का स्थान आक्रमण ने ले लिया था।
            राम का साथ होना सुग्रीव के लिए केवल एक राजा का साथ नहीं, बल्कि साक्षात् काल का संरक्षण था।
            रास्ते में सुग्रीव ने राम को बाली के युद्ध कौशल और उसकी क्रूरता के बारे में पुनः सचेत किया।
            परन्तु राम के चेहरे की शांति देखकर सुग्रीव का सारा डर कपूर की तरह उड़ गया था।
            नारद जी यहाँ उस महान कूच (March) का वर्णन कर रहे हैं जो अन्याय के गढ़ को ढहाने के लिए शुरू हुआ था।
            यह श्लोक सिद्ध करता है कि सही मार्गदर्शन और साथ मिलने पर एक हारा हुआ व्यक्ति भी खड़ा हो सकता है।
            यह यात्रा सुग्रीव के वनवासी जीवन के अंत और उनके राजसी पुनरुत्थान की पहली बड़ी सीढ़ी थी।
        """.trimIndent(),
englishCommentary = """
            Witnessing Rama's prowess, the great monkey Sugriva became 'Pritamanah' (deeply gratified) and 'Vishvastah' (convinced).
            He no longer harbored even a shred of doubt that Rama would end Bali’s tyranny and secure his justice.
            Thus, with a resolute heart, he proceeded with Rama toward the cave-kingdom (Guham) of Kishkindha.
            Sugriva's confidence was now at its zenith, for He stood supported by the supreme power of the cosmos.
            Heading toward Kishkindha signified that courage had replaced fear, and offensive action had replaced retreat.
            For Sugriva, Rama’s company was not just the support of a king but the protection of Time personified.
            En route, Sugriva again briefed Rama about Bali's combat tactics and his ruthless nature in battle.
            However, beholding the serenity on Rama's face, Sugriva's remaining anxieties vanished like mist in the sun.
            Narada describes the great march intended to dismantle the stronghold of injustice and unrighteousness.
            This verse proves that with the right guidance and alliance, even a defeated person can rise again.
            This journey marked the end of Sugriva's life as a fugitive and the first step toward his royal restoration.
        """.trimIndent()
),
RamayanVerse(
id = 66,
sanskrit = "ननाद सुग्रीवस्तदा किष्किन्धां स जगाम ह ।\nततो निर्जगाम वाली सुग्रीवस्य वचः श्रुत्वा ॥ ६६ ॥",
hindiCommentary = """
            किष्किन्धा पहुँचकर सुग्रीव ने एक भयंकर गर्जना (ननाद) की, जो बाली को चुनौती देने के लिए थी।
            सुग्रीव की आवाज़ सुनकर बाली, जो उस समय महल में था, अत्यंत क्रोधित होकर बाहर निकल आया (निर्जगाम)।
            बाली ने सोचा भी नहीं था कि सुग्रीव, जो उससे डरकर भागा हुआ था, फिर से उसे ललकारने की हिम्मत करेगा।
            सुग्रीव की गर्जना में राम की शक्ति का आत्मविश्वास गूँज रहा था, जिसने बाली को विचलित कर दिया।
            बाली की पत्नी तारा ने उसे रोकना चाहा और राम की शक्ति के बारे में चेतावनी दी, पर बाली ने उसे अनसुना किया।
            अहंकार बाली की बुद्धि पर हावी था, जिसके कारण वह अपनी मृत्यु को आमंत्रण देने के लिए निकल पड़ा।
            बाली और सुग्रीव का यह आमना-सामना दो भाइयों के बीच के गहरे द्वेष और गलतफहमियों का चरम बिंदु था।
            सुग्रीव ने जानबूझकर बाली को ललकारा ताकि राम को बाली का वध करने का स्पष्ट अवसर मिल सके।
            नारद जी यहाँ उस युद्ध की शुरुआत का चित्रण कर रहे हैं जो मर्यादा और न्याय के बीच का एक बड़ा द्वंद्व था।
            यह श्लोक यह संदेश देता है कि जब बुराई का अंत निकट होता है, तो वह स्वयं को बचाने के बजाय लड़ने के लिए दौड़ती है।
            बाली का बाहर आना उसके जीवन के अंतिम पलों की शुरुआत थी, जिससे वह स्वयं अनभिज्ञ था।
        """.trimIndent(),
englishCommentary = """
            Reaching Kishkindha, Sugriva let out a terrifying roar (Nanada) to formally challenge his brother Bali.
            Hearing Sugriva's provocative call, Bali, who was inside the palace, emerged in a fit of extreme rage (Nirjagama).
            Bali never imagined that Sugriva, who had fled in terror, would ever find the courage to challenge him again.
            In Sugriva's roar echoed the confidence of Rama's power, a sound that deeply unsettled the arrogant Bali.
            Bali’s wife, Tara, tried to dissuade him, warning him about Rama's might, but Bali chose to ignore her counsel.
            Arrogance had clouded Bali's judgment, prompting him to rush out and effectively invite his own doom.
            This confrontation between Bali and Sugriva was the culmination of deep-seated sibling rivalry and betrayal.
            Sugriva deliberately provoked Bali to create a clear opportunity for Rama to execute His promise of justice.
            Narada depicts the commencement of a battle that was a major struggle between moral law and brute force.
            This verse conveys that when an evil power's end is near, it instinctively rushes toward its own destruction.
            Bali’s emergence from the safety of the palace was the beginning of his final moments on earth.
        """.trimIndent()
),
RamayanVerse(
id = 67,
sanskrit = "सुग्रीवेण समागत्य युध्यमानो बली तदा ।\nएकेन चेषुणा रामो बालिनं तत्र जघान ह ॥ ६७ ॥",
hindiCommentary = """
            बाली और सुग्रीव के बीच भीषण युद्ध शुरू हुआ, जहाँ दोनों एक-दूसरे पर प्राणघातक प्रहार कर रहे थे।
            उस युद्ध के दौरान, राम ने छिपे रहकर एक ही बाण (एकेन चेषुणा) से बाली का वध कर दिया।
            बाली के वध का यह तरीका अक्सर विवाद का विषय रहा है, पर राम ने इसे एक 'पशु' के वध की तरह उचित ठहराया।
            बाली ने अधर्म किया था, उसने अपने छोटे भाई की पत्नी का हरण किया था, जो महापाप की श्रेणी में आता था।
            राम का बाण अचूक था, जो बाली के वक्षस्थल को चीरता हुआ पार निकल गया और बाली धराशायी हो गया।
            बाली ने मरते समय राम से प्रश्न किया, पर राम के तर्कों ने उसे सत्य का बोध कराया और उसने राम की शरण ली।
            यह विजय सुग्रीव के लिए न्याय थी और वानर जाति को एक नया और धर्मनिष्ठ राजा मिलने की शुरुआत।
            राम ने यहाँ सिद्ध किया कि अधर्मी चाहे कितना भी बलवान हो, ईश्वर का दंड उसे कभी नहीं छोड़ता।
            नारद जी यहाँ रामायण के एक अत्यंत महत्वपूर्ण और जटिल निर्णय को बहुत ही संक्षेप में बता रहे हैं।
            यह श्लोक राम के 'असुर-निवारक' और 'धर्म-स्थापक' स्वरूप की पुष्टि करता है।
            बाली का अंत किष्किन्धा में एक नए युग का सूत्रपात था, जहाँ अब केवल राम की आज्ञा चलने वाली थी।
        """.trimIndent(),
englishCommentary = """
            A fierce battle ensued between Bali and Sugriva, with both brothers dealing lethal blows to one another.
            During the height of this combat, Rama, remaining concealed, slew Bali with a single, unerring arrow.
            The method of Bali’s slaying has often been debated, but Rama justified it as the righteous execution of a predator.
            Bali had committed the grave sin of abducting his younger brother's wife, a crime that warranted the ultimate penalty.
            Rama's arrow was absolute; it pierced through Bali's chest, causing the mighty warrior to collapse instantly.
            In his dying moments, Bali questioned Rama, but Rama’s logic revealed the Truth, leading Bali to seek His refuge.
            This victory was the restoration of justice for Sugriva and the start of a new, righteous era for the Vanaras.
            Rama proved here that no matter how powerful the unrighteous may be, divine punishment is inevitable and unerring.
            Narada summarizes one of the most critical and complex decisions of the epic in this brief yet powerful verse.
            This verse re-affirms Rama's role as the 'Eradicator of Evil' and the 'Establisher of the Moral Law.'
            Bali's end marked the dawn of a new age in Kishkindha, where Rama’s word would now be the supreme guide.
        """.trimIndent()
),
RamayanVerse(
id = 68,
sanskrit = "स सुग्रीवं च राज्ये तु स्थापयित्वा महाबलः ।\nप्रगृह्य चाञ्जलिं प्रीत्या रामं वानरपुङ्गवः ॥ ६८ ॥",
hindiCommentary = """
            बाली के वध के बाद, महाबली राम ने सुग्रीव को किष्किन्धा के राज्य पर प्रतिष्ठित (स्थापयित्वा) कर दिया।
            वानरों में श्रेष्ठ (वानरपुङ्गवः) सुग्रीव ने अत्यंत प्रेम और भक्ति के साथ हाथ जोड़कर राम का अभिवादन किया।
            राम ने अपने मित्र को दिया हुआ वचन पूरा किया और उन्हें उनका खोया हुआ सम्मान और परिवार वापस दिलाया।
            राज्याभिषेक के उस उत्सव में राम की गरिमा और उनकी निस्वार्थ भावना साक्षात् दिखाई दे रही थी।
            सुग्रीव ने कृतज्ञतापूर्वक स्वीकार किया कि यह राज्य अब वास्तव में राम का है और वे केवल उनके सेवक हैं।
            'प्रगृह्य चाञ्जलिं' (हाथ जोड़ना) सुग्रीव के पूर्ण समर्पण और राम के प्रति उनकी अगाध श्रद्धा का प्रतीक है।
            राम ने सुग्रीव को आदेश दिया कि वे अब धर्म के अनुसार शासन करें और प्रजा का पुत्रवत पालन करें।
            यह क्षण राजनीति और आध्यात्मिकता के एक सुंदर मिलन का गवाह बना, जहाँ राजा और ईश्वर एक साथ थे।
            नारद जी यहाँ राम की सफलता और सुग्रीव के पुनरुत्थान का एक बहुत ही गौरवशाली चित्रण पेश कर रहे हैं।
            यह श्लोक सिखाता है कि जो ईश्वर की शरण में आता है, उसे न केवल सुरक्षा बल्कि वैभव भी प्राप्त होता है।
            अब किष्किन्धा का पूरा शासन राम की नीतियों और सुग्रीव की सेवा के अधीन था।
        """.trimIndent(),
englishCommentary = """
            Following Bali’s death, the mighty Rama formally established (Sthapayitva) Sugriva on the throne of Kishkindha.
            Sugriva, the pre-eminent among monkeys (Vanarapungavah), greeted Rama with joined palms and immense love.
            Rama fulfilled the solemn promise made to His friend, restoring his lost honor, family, and sovereignty.
            In the coronation festivities, Rama's innate dignity and His spirit of selfless service were radiantly visible.
            Sugriva acknowledged with profound gratitude that the kingdom truly belonged to Rama, and he was but a servant.
            The act of joining palms (Añjalim) symbolizes Sugriva’s complete surrender and His deep reverence for Rama.
            Rama instructed Sugriva to rule according to Dharma and to care for his subjects as if they were his own children.
            This moment witnessed a beautiful convergence of statecraft and spirituality, with the King and God standing together.
            Narada presents a glorious account of Rama’s success and the total political resurrection of Sugriva.
            This verse teaches that those who seek refuge in the Divine gain not only protection but ultimate prosperity.
            The governance of Kishkindha was now under the guidance of Rama's principles and Sugriva’s dedicated service.
        """.trimIndent()
),
RamayanVerse(
id = 69,
sanskrit = "सर्वैर्वानरैः सहितः स सुग्रीवो वानरेश्वरः ।\nदिशः प्रस्थापयामास वानरान्वानरर्षभः ॥ ६९ ॥",
hindiCommentary = """
            समस्त वानरों के साथ वानरेश्वर सुग्रीव ने अब सीता जी की खोज के लिए चारों दिशाओं में दूत भेजे।
            वानरों में श्रेष्ठ (वानरर्षभः) सुग्रीव ने एक कुशल सेनापति की तरह अपनी पूरी सेना को संगठित किया।
            उन्होंने वानरों के अलग-अलग समूह बनाए और उन्हें दिशाओं के अनुसार महत्वपूर्ण क्षेत्रों की जिम्मेदारी सौंपी।
            यह 'प्रस्थापयामास' (भेजना) शब्द सुग्रीव की राम के प्रति अपनी कृतज्ञता व्यक्त करने की सक्रिय शुरुआत है।
            सुग्रीव जानते थे कि समय कम है और कार्य अत्यंत कठिन, इसलिए उन्होंने सबसे वीर वानरों को इस काम में लगाया।
            उत्तर, दक्षिण, पूर्व और पश्चिम—चारों ओर वानरों की गूँज सुनाई देने लगी, जो सीता का पता लगाने के लिए व्याकुल थे।
            राम की अंगूठी हनुमान जी को सौंपी गई, क्योंकि राम को उनकी बुद्धिमत्ता और निष्ठा पर सबसे अधिक विश्वास था।
            नारद जी यहाँ सुग्रीव की उस प्रशासनिक कुशलता का वर्णन कर रहे हैं जो राम के काम को आसान बना रही थी।
            यह श्लोक सामूहिक प्रयास और संगठन की शक्ति का एक बहुत ही प्रेरणादायक उदाहरण प्रस्तुत करता है।
            वानरों के भीतर एक नया उत्साह भर गया था क्योंकि वे अब साक्षात् नारायण के कार्य के लिए निकल रहे थे।
            सीता की खोज अब केवल राम की नहीं, बल्कि पूरी वानर जाति की एक महान आध्यात्मिक परीक्षा बन गई थी।
        """.trimIndent(),
englishCommentary = """
            Accompanied by all the Vanaras, Sugriva, the Lord of Monkeys, dispatched scouts in all four directions to find Sita.
            As the pre-eminent among monkeys (Vanararshabhah), Sugriva organized his entire vast army like a skilled general.
            He divided the monkeys into specialized groups and assigned them specific regions based on the cardinal directions.
            The term 'Prasthapayamas' (despatched) marks the active beginning of Sugriva fulfilling his gratitude toward Rama.
            Sugriva realized the urgency and the magnitude of the task, thus enlisting the bravest and swiftest of the Vanaras.
            The cries of the monkeys resonated in the North, South, East, and West as they set out with a singular purpose.
            Rama’s signet ring was entrusted to Hanuman, for Rama placed the highest trust in His wisdom and loyalty.
            Narada describes the administrative efficiency of Sugriva, which was now facilitating Rama’s divine mission.
            This verse serves as an inspiring example of the power of collective effort and organized mobilization.
            The Vanaras were infused with a new zeal, realizing they were embarked upon the sacred work of the Supreme Lord.
            The search for Sita evolved from being Rama’s personal quest into a grand spiritual test for the entire Vanara race.
        """.trimIndent()
),
RamayanVerse(
id = 70,
sanskrit = "ततो वायुसुतो धीमान् सुग्रीवेण समादिष्टः ।\nहनुमान् रामहितार्थाय जगाम च दिङ्मुखम् ॥ ७० ॥",
hindiCommentary = """
            तब सुग्रीव द्वारा आज्ञा प्राप्त कर बुद्धिमान पवनपुत्र हनुमान जी राम के कल्याण (हितार्थाय) के लिए दक्षिण दिशा की ओर बढ़े।
            हनुमान जी 'धीमान्' (अत्यंत बुद्धिमान) थे, वे जानते थे कि सीता की खोज का मुख्य भार उन्हीं के कंधों पर है।
            उनका 'दिङ्मुखम्' (दिशा की ओर) जाना रामायण की सबसे रोमांचक और निर्णायक यात्रा की शुरुआत थी।
            राम ने हनुमान को अपनी अंगूठी दी और उनके प्रति अपनी विशेष कृपा और विश्वास प्रकट किया।
            हनुमान जी के हृदय में केवल राम का नाम और उनके काम को पूरा करने का अटूट संकल्प बसा हुआ था।
            वे जानते थे कि दक्षिण दिशा में ही रावण का साम्राज्य है, जहाँ पहुँचने के लिए अथाह समुद्र को पार करना होगा।
            नारद जी यहाँ हनुमान जी के उस 'हनुमत्' तत्व का परिचय दे रहे हैं जो असंभव को संभव बनाने के लिए बना है।
            यह श्लोक हनुमान जी के 'रामदूत' के रूप में विधिवत स्थापित होने का पावन क्षण है।
            उनकी गति वायु के समान तीव्र थी और उनका लक्ष्य ध्रुव तारे के समान स्थिर और अडिग।
            हनुमान जी का प्रस्थान ऋषियों और देवताओं के लिए भी हर्ष का विषय था, क्योंकि वे जानते थे कि जीत अब सुनिश्चित है।
            इस यात्रा के साथ ही रामायण का वह अद्भुत अध्याय शुरू होता है जिसे हम 'सुन्दरकाण्ड' के नाम से जानते हैं।
        """.trimIndent(),
englishCommentary = """
            Ordered by Sugriva, the wise son of the Wind, Hanuman, set out toward the Southern direction for Rama’s welfare.
            Hanuman was 'Dhiman' (supremely intelligent), aware that the primary weight of the search for Sita rested on Him.
            His departure toward 'Dingmukham' (the face of the direction) marked the start of the most thrilling phase of the epic.
            Rama entrusted His signet ring to Hanuman, expressing His special grace and absolute confidence in Him.
            In Hanuman's heart resided only the name of Rama and an unbreakable resolve to complete His divine task.
            He was aware that the Southern direction held Ravana's empire, reachable only by crossing the vast ocean.
            Narada introduces the 'Hanumat' element here—the spiritual force designed to achieve the seemingly impossible.
            This verse represents the sacred moment of Hanuman being formally established as the 'Messenger of Rama.'
            His speed was as swift as the wind, and His focus as fixed and unshakable as the North Star.
            Hanuman’s departure brought joy even to the gods and sages, for they knew that victory was now guaranteed.
            With this journey, the extraordinary chapter of the Ramayana known as 'Sundara Kanda' effectively begins.
        """.trimIndent()
),
RamayanVerse(
id = 71,
sanskrit = "स तु सम्पातिवचनाद्वेगतः शतयोजनम् ।\nसमुद्रं प्लुते वीरो हनूमान्पवनात्मजः ॥ ७१ ॥",
hindiCommentary = """
            गिद्धराज सम्पाति के वचनों से सीता जी का पता जानकर पवनपुत्र हनुमान ने सौ योजन के समुद्र को वेग से पार किया।
            सम्पाति ने अपनी दिव्य दृष्टि से देख लिया था कि सीता जी लंका के अशोक वाटिका में शोकग्रस्त बैठी हैं।
            हनुमान जी 'वीरो' (महान वीर) थे, जिन्होंने समुद्र के ऊपर से छलांग लगाकर एक असंभव छलांग (प्लुत) लगाई।
            सौ योजन (लगभग 800 मील) का वह विस्तार उनकी असीमित शक्ति और संकल्प का साक्षात् प्रमाण था।
            वायु के समान उनकी गति ने समुद्र के जल को भी आकाश की ओर उछाल दिया, जो उनके 'पवनात्मज' होने का सूचक है।
            मार्ग में उन्होंने मैनाक पर्वत, सुरसा और सिंहिका जैसी बाधाओं को अपनी बुद्धिमत्ता और बल से पार किया।
            यह छलांग केवल एक शारीरिक क्रिया नहीं थी, बल्कि यह भक्ति के बल पर माया के सागर को पार करने का प्रतीक थी।
            नारद जी यहाँ हनुमान जी के उस 'लघु रूप' और 'विराट रूप' के संतुलन को बहुत संक्षेप में उजागर कर रहे हैं।
            सम्पाति की मदद यह दिखाती है कि जब उद्देश्य पवित्र हो, तो प्रकृति के हर तत्व से सहायता प्राप्त होती है।
            यह श्लोक हनुमान जी के अदम्य साहस और उनके 'उड़ने' की अलौकिक शक्ति का गौरवशाली वर्णन है।
            हनुमान जी की इस उड़ान ने लंका के असुरों के मन में भय और देवताओं के मन में आशा का संचार कर दिया।
        """.trimIndent(),
englishCommentary = """
            Guided by the words of the vulture Sampati, Hanuman, the son of the Wind, leaped across the hundred-yojana ocean.
            Sampati, using his long-range vision, had confirmed that Sita was held captive in the Ashoka Grove of Lanka.
            Hanuman was the 'Viro' (mighty hero) who took an impossible leap (Pluta) over the vast expanse of the salt sea.
            The distance of a hundred yojanas was a testament to His unlimited strength and His spiritual resolve.
            His wind-like speed caused the very waters of the ocean to rise toward the sky, proving His divine lineage.
            En route, He overcame formidable obstacles like Mainaka, Surasa, and Simhika with His wit and might.
            This leap was not just a physical feat but a symbol of crossing the ocean of 'Maya' through the power of devotion.
            Narada succinctly highlights the balance between Hanuman’s humility and His terrifying, cosmic form.
            Sampati’s assistance demonstrates that when the purpose is holy, assistance arrives from unexpected sources.
            This verse is a glorious description of Hanuman's indomitable courage and His supernatural power of flight.
            Hanuman’s flight struck terror into the hearts of Lanka's demons and filled the celestial gods with immense hope.
        """.trimIndent()
),
RamayanVerse(
id = 72,
sanskrit = "तत्र लङ्कां समासाद्य रावणपालितां पुरीम् ।\nददर्श सीतां ध्यायन्तीं मलिनाम्बरधारिणीम् ॥ ७२ ॥",
hindiCommentary = """
            हनुमान जी ने रावण द्वारा पालित और सुरक्षित लंकापुरी में प्रवेश किया और वहाँ की वैभवशाली शोभा देखी।
            वहाँ उन्होंने अशोक वाटिका में सीता जी के दर्शन किए, जो अत्यंत दीन अवस्था में 'मलिनाम्बरधारिणी' (मलिन वस्त्र पहने) थीं।
            सीता जी निरंतर अपने पति श्री राम का ध्यान (ध्यायन्तीं) कर रही थीं और उनके विरह में सूखकर कांटा हो गई थीं।
            रावण के ऐश्वर्य के बीच भी सीता जी का तप और उनका तेज हनुमान जी को अनायास ही अपनी ओर खींच लिया।
            वे राक्षसनियों के पहरे में बैठी थीं, पर उनका मन तो अयोध्या के उन पावन चरणों में ही अटका हुआ था।
            हनुमान जी ने देखा कि संसार का सारा वैभव सीता जी के लिए धूल के समान तुच्छ था, क्योंकि वे तो राम-मयी थीं।
            उनका मलिन वस्त्र उनके वैराग्य और रावण के प्रति उनकी घृणा का स्पष्ट और मूक संकेत था।
            नारद जी यहाँ सीता जी की उस 'मर्यादा' और 'अग्नि-शिखा' जैसे पवित्र स्वरूप का सजीव चित्रण कर रहे हैं।
            यह श्लोक भक्ति और निष्ठा की उस पराकाष्ठा को दिखाता है जो किसी भी प्रलोभन से नहीं डगमगाती।
            हनुमान जी को अब विश्वास हो गया कि यही वह 'जगज्जननी' हैं जिनके लिए राम इतने व्याकुल थे।
            सीता जी की उस अवस्था ने हनुमान के हृदय को करुणा से भर दिया और रावण के प्रति उनके क्रोध को और भड़का दिया।
        """.trimIndent(),
englishCommentary = """
            Reaching Lanka, the city guarded and governed by Ravana, Hanuman observed its immense and dark grandeur.
            There, in the Ashoka Grove, He beheld Sita, who was wearing soiled garments (Malinambaradharinim) and in distress.
            She was constantly absorbed in the meditation (Dhyayantim) of her husband Rama, emaciated by His separation.
            Even amidst Ravana’s opulence, Sita’s spiritual radiance and her penance effortlessly drew Hanuman’s attention.
            She sat surrounded by fierce demonesses, yet her mind remained fixed only at the holy feet of Rama in Ayodhya.
            Hanuman realized that all the wealth of Lanka was like worthless dust to Sita, for she was completely Rama-merged.
            Her soiled attire was a silent and powerful symbol of her detachment and her utter disdain for Ravana.
            Narada provides a vivid depiction of Sita as the ultimate 'Flame of Purity' and the standard of moral integrity.
            This verse illustrates the peak of devotion and loyalty that remains unshaken by any worldly temptation.
            Hanuman was now certain that this was indeed the 'Mother of the World' for whom Rama had been so distraught.
            Sita’s condition filled Hanuman’s heart with intense compassion and ignited His righteous fury against Ravana.
        """.trimIndent()
),
RamayanVerse(
id = 73,
sanskrit = "दत्त्वाभिज्ञानमस्मै तु सीतायाः संविदित्वा च ।\nअक्षयं च बलं तत्र वानरो राघवाय च ॥ ७३ ॥",
hindiCommentary = """
            हनुमान जी ने राम द्वारा दी गई पहचान (अभिज्ञान—अंगूठी) सीता जी को सौंपी और उनका विश्वास जीता।
            उन्होंने सीता जी के स्वास्थ्य और उनकी मानसिक दृढ़ता के बारे में सब कुछ गहराई से जान (संविदित्वा) लिया।
            साथ ही, हनुमान जी ने लंका की सुरक्षा और राक्षसों के 'अक्षय' (असीमित) बल का भी सूक्ष्म आकलन किया।
            वे केवल एक दूत नहीं थे, बल्कि एक कुशल जासूस भी थे, जिन्होंने शत्रु की ताकत और कमजोरी दोनों को समझा।
            सीता जी ने भी हनुमान को अपनी 'चूड़ामणि' दी ताकि वे राम को अपनी उपस्थिति का ठोस प्रमाण दे सकें।
            हनुमान जी ने वहाँ यह भी संदेश दिया कि राम की सेना अब बहुत जल्द लंका को धूल में मिलाने वाली है।
            'अक्षय बल' का उल्लेख यह बताता है कि लंका कोई आसान लक्ष्य नहीं था, वह अजेय मानी जाने वाली नगरी थी।
            नारद जी यहाँ हनुमान जी की उस दोहरी सफलता—सीता का पता और लंका का निरीक्षण—का वर्णन कर रहे हैं।
            हनुमान जी ने सीता जी को आश्वस्त किया कि उनके दुख के दिन अब बहुत ही कम बचे हैं।
            यह श्लोक कूटनीति, जासूसी और विश्वास-बहाली (Confidence Building) के एक बेहतरीन समन्वय को दर्शाता है।
            हनुमान जी की इस सफलता ने आगामी युद्ध के लिए राम को मानसिक और सामरिक रूप से तैयार कर दिया।
        """.trimIndent(),
englishCommentary = """
            Hanuman handed over the token of recognition (Abhijñana—the ring) to Sita and earned her absolute trust.
            He learned in depth (Samviditva) about Sita’s well-being and her unshakable mental fortitude in captivity.
            Additionally, Hanuman conducted a subtle assessment of Lanka's defenses and the 'Akshaya' (inexhaustible) strength of the demons.
            He was not just a messenger but a master spy who understood both the strengths and vulnerabilities of the foe.
            Sita, in turn, gave her 'Chudamani' (crest jewel) to Hanuman as a tangible proof of her presence for Rama.
            Hanuman also conveyed the warning that Rama’s army would soon turn Lanka into a pile of ash.
            The mention of 'Akshaya Bala' suggests that Lanka was no easy target; it was a city considered invincible.
            Narada describes Hanuman’s dual success here: locating Sita and gathering critical military intelligence on Lanka.
            Hanuman reassured Sita that the days of her suffering were now numbered and salvation was imminent.
            This verse illustrates a perfect synthesis of diplomacy, espionage, and the building of spiritual confidence.
            Hanuman’s breakthrough provided Rama with both the emotional solace and the tactical data needed for the war.
        """.trimIndent()
),
RamayanVerse(
id = 74,
sanskrit = "पुरं च दग्ध्वा हनुमान्प्रतिवेद्य च सीतायै ।\nप्रतिगत्वा च वेगेन हनुमान्राममब्रवीत् ॥ ७४ ॥",
hindiCommentary = """
            हनुमान जी ने रावण के अहंकार के प्रतीक लंकापुरी को जलाकर राख (दग्ध्वा) कर दिया और अपनी शक्ति दिखाई।
            लंका दहन के बाद उन्होंने सीता जी को प्रणाम किया और उनसे विदा लेकर वापस अयोध्या की ओर वेगेन (वेग से) चल दिए।
            वापस पहुँचकर हनुमान जी ने राम से वह ऐतिहासिक वाक्य कहा—"दृष्टा सीता" (मैने सीता को देख लिया है)।
            उनके इस छोटे से वाक्य ने राम के मुरझाए हुए चेहरे पर फिर से जीवन और प्रसन्नता की लहर ला दी।
            हनुमान जी का वेग उनकी सफलता के उत्साह और राम से मिलने की उनकी व्याकुलता का परिचायक था।
            लंका का दहन यह संकेत था कि रावण का साम्राज्य अब असुरक्षित है और उसका विनाश निश्चित है।
            उन्होंने राम को सीता जी द्वारा दी गई चूड़ामणि सौंपी और उनकी विरह-व्यथा का मार्मिक वर्णन किया।
            नारद जी यहाँ हनुमान जी के उस 'संकटमोचक' स्वरूप का गान कर रहे हैं जो अंधकार में प्रकाश की किरण लाता है।
            यह श्लोक राम के मन के संशय को समाप्त करने और उन्हें कर्म के लिए प्रेरित करने का सबसे महत्वपूर्ण क्षण है।
            हनुमान जी ने सिद्ध कर दिया कि वे राम के सबसे योग्य और सबसे प्रिय सेवक क्यों माने जाते हैं।
            अब राम का हृदय शांत था, क्योंकि उन्हें अपनी प्राणप्रिया का पता मिल चुका था और अब केवल न्याय बाकी था।
        """.trimIndent(),
englishCommentary = """
            Hanuman displayed His prowess by burning down the city of Lanka (Daghva), the symbol of Ravana’s pride.
            After the conflagration, He paid His respects to Sita, took her leave, and returned with great speed (Vegena) to Rama.
            Upon His return, Hanuman uttered that historic and pithy sentence: "Drishta Sita" (Sita has been seen).
            This short phrase instantly revived Rama’s withered face, bringing a wave of life and joy back to Him.
            Hanuman’s speed reflected His excitement at the success of His mission and His longing to reunite with Rama.
            The burning of Lanka was a clear signal that Ravana’s empire was now vulnerable and doomed to fall.
            He presented the Chudamani to Rama and provided a moving account of Sita’s intense sorrow and her longing.
            Narada celebrates the 'Sankat-mochan' aspect of Hanuman, who brings a ray of brilliant light in the deepest darkness.
            This verse marks the most critical moment of eliminating Rama’s uncertainty and propelling Him into action.
            Hanuman proved why He is considered the most capable and the dearest of all the servants of Lord Rama.
            Rama’s heart was finally at peace, for He knew the whereabouts of His soulmate, and now only Justice remained.
        """.trimIndent()
),
RamayanVerse(
id = 75,
sanskrit = "ततः सुग्रीवमभ्येत्य रामो वानरपुङ्गवैः ।\nसमुद्रतीरमागत्य शरैरादित्यसन्निभैः ॥ ७५ ॥",
hindiCommentary = """
            सीता का पता मिलते ही राम ने सुग्रीव और वानर श्रेष्ठों (वानरपुङ्गवैः) के साथ समुद्र तट की ओर प्रस्थान किया।
            उनके साथ वानरों की एक अजेय और विशाल सेना थी, जो धर्म के लिए अपना सर्वस्व न्योछावर करने को तैयार थी।
            राम ने अपने आदित्य (सूर्य) के समान चमकते हुए और विनाशकारी बाणों (शरैः) को धारण कर रखा था।
            समुद्र तट पर पहुँचना उस महासंग्राम की पहली बड़ी भौगोलिक और सामरिक चुनौती थी।
            'आदित्यसन्निभैः' बाण यह दर्शाते हैं कि राम की शक्ति अब पूर्णतः प्रज्वलित हो चुकी थी और वे युद्ध के लिए तैयार थे।
            वानर सेना का उत्साह समुद्र की लहरों से भी अधिक ऊँचा था, क्योंकि उनके नेतृत्वकर्ता साक्षात् नारायण थे।
            यहाँ से 'युद्ध काण्ड' की औपचारिक तैयारी शुरू होती है, जहाँ प्रकृति को भी राम की आज्ञा माननी पड़नी थी।
            नारद जी यहाँ राम के उस 'सेनापति' और 'विनाशक' स्वरूप का चित्रण कर रहे हैं जो अधर्म को जड़ से उखाड़ने को सज्ज है।
            यह श्लोक न्याय की पुनर्स्थापना के लिए किए जाने वाले एक महान 'यज्ञ' की शुरुआत का प्रतीक है।
            राम की आँखों में अब विरह की आँसू नहीं, बल्कि रावण के पापों का अंत करने वाला तेज झलक रहा था।
            यह यात्रा पूरी दुनिया को यह संदेश देने वाली थी कि सत्य कभी भी हारता नहीं, चाहे समुद्र ही क्यों न बीच में आ जाए।
        """.trimIndent(),
englishCommentary = """
            As soon as Sita was located, Rama, along with Sugriva and the chief Vanaras, marched toward the ocean shore.
            He was accompanied by an invincible and massive army of monkeys, ready to sacrifice everything for Dharma.
            Rama carried with Him arrows (Sharaih) that were as radiant and destructive as the Sun (Adityasannibhaih).
            Reaching the ocean shore was the first major geographical and tactical challenge of the great war.
            Arrows like the Sun signify that Rama’s divine power was now fully ignited and He was battle-ready.
            The enthusiasm of the Vanara army was higher than the waves of the sea, led by the Supreme Lord Himself.
            This moment marks the formal preparation for 'Yuddha Kanda,' where even nature had to yield to Rama’s command.
            Narada depicts Rama’s persona here as a supreme Commander and Destroyer, ready to uproot unrighteousness.
            This verse symbolizes the commencement of a grand 'Sacrifice' intended for the restoration of Cosmic Justice.
            In Rama's eyes, tears of separation were replaced by the fire that would soon end the sinful reign of Ravana.
            This expedition was set to send a message to the world: Truth never loses, even if an entire ocean stands in the way.
        """.trimIndent()
),
    RamayanVerse(
        id = 76,
        sanskrit = "स बद्ध्वा सागरं सेतुं नलसेतुं महाबलः ।\nजगाम लङ्कां रामस्तु हत्वा रावणमाहवे ॥ ७६ ॥",
        hindiCommentary = """
            महाबली राम ने नल के माध्यम से समुद्र पर एक विशाल सेतु (पुल) का निर्माण करवाया।
            यह सेतु स्थापत्य कला और वानर सेना के सामूहिक श्रम का एक अलौकिक चमत्कार था।
            राम ने अपनी सेना के साथ समुद्र पार किया और लंका पहुँचकर रावण के साथ भीषण युद्ध किया।
            उन्होंने युद्ध (आहवे) के मैदान में उस अधर्मी और अहंकारी रावण का वध कर दिया।
            सेतु का निर्माण यह सिद्ध करता है कि दृढ़ संकल्प हो तो प्रकृति की बाधाएं भी रास्ता दे देती हैं।
            नल और नील की तकनीकी कुशलता ने पत्थर को पानी पर तैरा दिया, जो राम के नाम की महिमा थी।
            रावण का वध केवल एक राजा की मृत्यु नहीं, बल्कि वैश्विक स्तर पर अधर्म का अंत था।
            लंका के द्वार पर राम की विजय ने सिद्ध कर दिया कि सत्य को दबाया जा सकता है, पर हराया नहीं।
            नारद जी यहाँ रामायण के सबसे बड़े संघर्ष और उसकी चरम परिणति को एक ही श्लोक में पिरो रहे हैं।
            राम ने रावण को मारकर देवताओं को उसके आतंक से मुक्त किया और धर्म की पुनर्स्थापना की।
            यह विजय पर्व पूरी सृष्टि के लिए अंधकार से प्रकाश की ओर बढ़ने का एक महान उत्सव बन गया।
        """.trimIndent(),
        englishCommentary = """
            The mighty Rama built a massive bridge (Setu) across the ocean through the expertise of Nala.
            This bridge was a supernatural miracle of engineering and the collective labor of the Vanara army.
            Rama crossed the ocean with His forces, reached Lanka, and engaged in a fierce battle with Ravana.
            He eventually slew the unrighteous and arrogant Ravana in the heat of the conflict (Ahave).
            The construction of the bridge proves that nature yields to those possessed of an indomitable will.
            Nala and Nila’s technical skill caused stones to float on water, empowered by the resonance of Rama's name.
            The death of Ravana was not just the demise of a king but the systematic eradication of global evil.
            Rama's victory at the gates of Lanka proved that Truth might be suppressed, but it can never be defeated.
            Narada weaves the greatest conflict and its ultimate resolution into this single, powerful verse.
            By killing Ravana, Rama liberated the gods from terror and re-established the divine Moral Law.
            This victory became a grand festival for all of creation, marking the transition from darkness to light.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 77,
        sanskrit = "विभीषणं च राज्ये तु स्थापयित्वा महाबलः ।\nपुनः सीतां समासाद्य कृतकृत्योऽभवत्तदा ॥ ७७ ॥",
        hindiCommentary = """
            रावण के वध के बाद, महाबली राम ने धर्मनिष्ठ विभीषण को लंका के राज्य पर प्रतिष्ठित किया।
            विभीषण का राज्याभिषेक यह दर्शाता है कि राम किसी के साम्राज्य को छीनने के लोभी नहीं थे।
            तपश्चात, उन्होंने अपनी प्रिय सीता को पुनः प्राप्त किया और वे पूरी तरह 'कृतकृत्य' (सफल) हुए।
            विभीषण को राजा बनाना शरणागत वत्सलता और न्यायपूर्ण राजनीति का एक उत्कृष्ट उदाहरण है।
            सीता से पुनर्मिलन का क्षण राम के चौदह वर्ष के संघर्ष और विरह की अग्नि-परीक्षा का अंत था।
            राम ने लंका में भी धर्म का शासन स्थापित किया ताकि भविष्य में वहाँ फिर कोई रावण पैदा न हो।
            सीता की शुचिता और उनके पतिव्रत धर्म की विजय पूरे विश्व के लिए एक महान प्रेरणा बनी।
            कृतकृत्य होने का अर्थ है कि राम ने अपने अवतार का वह मुख्य उद्देश्य पूरा कर लिया जिसके लिए वे आए थे।
            नारद जी यहाँ राम की उदारता और उनके व्यक्तिगत सुख की पुनर्प्राप्ति का सुंदर चित्रण कर रहे हैं।
            विभीषण जैसे भक्त को राज्य सौंपना राम की उस दृष्टि को दिखाता है जो शत्रु के कुल में भी गुण देख लेती है।
            अब राम का हृदय शांत था क्योंकि अधर्म मिट चुका था और उनकी प्राणप्रिया उनके सान्निध्य में थीं।
        """.trimIndent(),
        englishCommentary = """
            After Ravana's fall, the mighty Rama installed the righteous Vibhishana on the throne of Lanka.
            Vibhishana’s coronation demonstrates that Rama was never greedy for the territory or wealth of others.
            Subsequently, He reunited with His beloved Sita and felt completely fulfilled (Kritakrityah).
            Making Vibhishana king is a supreme example of Rama’s grace toward refugees and His just statecraft.
            The moment of reunion with Sita marked the end of His fourteen-year struggle and the agony of separation.
            Rama ensured that even in Lanka, a rule based on Dharma was established to prevent future tyranny.
            The victory of Sita’s purity and her unwavering loyalty became a beacon of inspiration for the entire world.
            Being 'Kritakritya' signifies that Rama had successfully completed the primary mission of His divine descent.
            Narada beautifully depicts Rama’s magnanimity and the restoration of His personal happiness.
            Entrusting the kingdom to a devotee like Vibhishana shows Rama’s ability to recognize virtue even in a foe's clan.
            Rama’s heart was finally at peace, for evil had been uprooted and His soulmate was back by His side.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 78,
        sanskrit = "ततः सीतां समासाद्य लज्जया महता वृतः ।\nउवाच परुषं रामो जनसंसदि मैथिलीम् ॥ ७८ ॥",
        hindiCommentary = """
            सीता को प्राप्त करने के बाद, लोक-मर्यादा के कारण राम महान लज्जा और संकोच से घिर गए।
            उन्होंने भरी सभा (जनसंसदि) में मैथिली (सीता) से कुछ कठोर (परुषं) और तीखे वचन कहे।
            यह राम के चरित्र का सबसे अधिक चर्चा किया जाने वाला और भावुक क्षण है, जो उनकी 'मर्यादा' को दिखाता है।
            राम जानते थे कि सीता परम पवित्र हैं, पर एक राजा के रूप में उन्हें प्रजा के संदेहों का निवारण करना था।
            उनके कठोर वचन वास्तव में उनके हृदय की पीड़ा थे, जो वे एक राजा के उत्तरदायित्व के कारण बोल रहे थे।
            उन्होंने सिद्ध किया कि एक शासक के लिए उसका व्यक्तिगत प्रेम समाज की नैतिकता से ऊपर नहीं हो सकता।
            सीता जी ने इन वचनों को सुना और अपनी पवित्रता को सिद्ध करने के लिए अग्नि-परीक्षा का मार्ग चुना।
            नारद जी यहाँ उस जटिल सामाजिक परिस्थिति का वर्णन कर रहे हैं जहाँ एक पति और राजा के बीच द्वंद्व है।
            यह श्लोक राम के उस 'कठोर' निर्णय को दर्शाता है जो उन्होंने केवल लोक-कल्याण और आदर्श की स्थापना के लिए लिया।
            मर्यादा पुरुषोत्तम होने की कीमत राम को अपने प्रेम की आहुति देकर और सीता का अपमान सहकर चुकानी पड़ी।
            यह घटना रामायण के उस सत्य को उजागर करती है कि सत्य का मार्ग फूलों की सेज नहीं, बल्कि कांटों भरा होता है।
        """.trimIndent(),
        englishCommentary = """
            Upon reuniting with Sita, Rama was overcome by great embarrassment due to social propriety.
            In the presence of the public assembly (Janasamsadi), He addressed Maithili (Sita) with harsh (Parusham) words.
            This is one of the most discussed and emotional moments of the epic, highlighting Rama's commitment to 'Maryada.'
            Rama was fully aware of Sita’s absolute purity, yet as a King, He had to address potential public doubts.
            His harsh words were actually a reflection of His own inner agony, spoken out of His duty as a monarch.
            He demonstrated that for a true ruler, personal love cannot supersede the moral standards of society.
            Sita heard these words and chose the path of the 'Trial by Fire' to prove her transcendental purity.
            Narada describes the complex social dynamic where the roles of a husband and a king were in deep conflict.
            This verse portrays the 'tough' decision Rama made solely for the sake of establishing a public ideal.
            Rama paid the price of being the 'Ideal Man' by sacrificing His personal happiness and enduring Sita’s pain.
            This incident reveals the stark truth of the Ramayana: the path of Truth is not a bed of roses but one of thorns.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 79,
        sanskrit = "मृष्यमाणा तु सा सीता विवेश ज्वलनं तदा ।\nततोऽग्निवचनात्सीतां ज्ञात्वा विगतकल्मषाम् ॥ ७९ ॥",
        hindiCommentary = """
            उन वचनों को सहन करते हुए (मृष्यमाणा), सीता जी ने बिना किसी संकोच के प्रज्वलित अग्नि में प्रवेश किया।
            अग्नि देव ने स्वयं प्रकट होकर गवाही दी और घोषणा की कि सीता जी पूरी तरह 'विगतकल्मषाम्' (निष्पाप) हैं।
            सीता की पवित्रता के सामने स्वयं अग्नि की जलन भी शीतल हो गई थी, जो उनके सतीत्व का साक्षात् चमत्कार था।
            अग्नि के वचनों को सुनकर राम अत्यंत प्रसन्न हुए, क्योंकि अब संसार के सामने सीता का सत्य प्रमाणित हो चुका था।
            यह क्षण नारी शक्ति और उसके आत्म-विश्वास की सर्वोच्च विजय का प्रतीक माना जाता है।
            राम ने सीता को सहर्ष स्वीकार किया और देवताओं ने भी आकाश से पुष्प वर्षा करके इस मिलन का स्वागत किया।
            अग्नि-परीक्षा केवल सीता की नहीं, बल्कि राम के उस सत्य की भी थी जिसे वे दुनिया को दिखाना चाहते थे।
            नारद जी यहाँ उस दिव्य प्रमाण का वर्णन कर रहे हैं जिसने मानवीय शंकाओं के अंधकार को हमेशा के लिए मिटा दिया।
            सीता जी का अग्नि से बाहर आना यह सिद्ध करता है कि सत्य को कोई भी तत्व कभी जला नहीं सकता।
            राम और सीता का यह पुनर्मिलन अब पूरी तरह से निष्कंटक और दिव्य गरिमा से परिपूर्ण था।
            यह श्लोक रामायण के उस महान संदेश को पुष्ट करता है कि पवित्रता ही मनुष्य का सबसे बड़ा बल है।
        """.trimIndent(),
        englishCommentary = """
            Enduring those painful words (Mrishyamana), Sita entered the blazing fire without any hesitation.
            The Fire-god (Agni) personally appeared and testified that Sita was entirely sinless (Vigatakalmasham).
            The very heat of the fire became cool in the presence of Sita’s purity, a direct miracle of her virtue.
            Upon hearing the testimony of Agni, Rama was deeply relieved, for Sita’s truth was now publicly validated.
            This moment is viewed as the supreme victory of female strength and inner spiritual confidence.
            Rama accepted Sita with joy, and the gods celebrated the reunion by showering flowers from the heavens.
            The trial was not just for Sita but for the Truth that Rama intended to demonstrate to the entire world.
            Narada describes the divine evidence that permanently dispelled the darkness of human skepticism.
            Sita’s emergence from the fire proves that no element in nature can ever consume or destroy the Truth.
            The reunion of Rama and Sita was now completely unassailable and filled with transcendental dignity.
            This verse reinforces the central message of the Ramayana: that purity is the greatest power of a human being.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 80,
        sanskrit = "बभौ रामः सम्प्रहृष्टः पूजितः सर्वदैवतैः ।\nकर्मणा तेन महता त्रैलोक्यं सचराचरम् ॥ ८० ॥",
        hindiCommentary = """
            सीता को शुद्ध जानकर राम अत्यंत हर्षित (सम्प्रहृष्टः) हुए और समस्त देवताओं ने उनकी पूजा और स्तुति की।
            उनके उस महान कार्य (रावण वध और धर्म स्थापना) से तीनों लोक—चर और अचर—अत्यंत प्रसन्न हुए।
            राम की आभा सूर्य के समान चमक उठी, क्योंकि उन्होंने ब्रह्मांड से असुरता के अंधकार को मिटा दिया था।
            देवताओं ने राम को 'परमात्मा' के रूप में स्वीकार किया और उनके चरणों में वंदना की।
            'त्रैलोक्यं' (तीनों लोक) की प्रसन्नता यह बताती है कि राम की विजय केवल पृथ्वी तक सीमित नहीं थी।
            यह उत्सव उस न्याय का था जिसकी प्रतीक्षा ऋषि-मुनि और पीड़ित मानवता युगों से कर रही थी।
            नारद जी यहाँ राम के उस 'विश्वरूप' की ओर संकेत कर रहे हैं जो विजय के बाद दैवीय तेज से ओत-प्रोत है।
            हर जीव ने महसूस किया कि अब शांति और धर्म का नया युग शुरू होने वाला है।
            राम का 'पूजित' होना यह दर्शाता है कि ईश्वर जब मनुष्य रूप में महान कार्य करता है, तो स्वर्ग भी नतमस्तक होता है।
            इस श्लोक के साथ रामायण का युद्ध-काल समाप्त होता है और मांगलिक भविष्य की शुरुआत होती है।
            राम की सफलता ने सिद्ध कर दिया कि धर्म का पालन करने वाले की सहायता स्वयं नियति और देवता करते हैं।
        """.trimIndent(),
        englishCommentary = """
            Knowing Sita was pure, Rama became exceedingly joyful (Samprahrishtah) and was worshiped by all the gods.
            Due to His great feat (the destruction of Ravana), the three worlds—mobile and immobile—rejoiced.
            Rama’s radiance shone like the sun, for He had dispelled the darkness of demonic oppression from the cosmos.
            The celestial deities acknowledged Rama as the Supreme Soul and offered salutations at His feet.
            The joy of the 'Trailokyam' (three worlds) indicates that Rama's victory was not merely an earthly event.
            This celebration was for the Justice that sages and suffering humanity had awaited for countless ages.
            Narada hints at Rama’s 'Vishvarupa' (Cosmic Form), which was saturated with divine brilliance after the victory.
            Every living creature felt that a new era of peace and Righteousness (Dharma) was about to commence.
            Being 'Pujitah' (worshiped) shows that when God performs great deeds as a mortal, even heaven bows in respect.
            This verse marks the end of the period of war and the beginning of a magnificent and auspicious future.
            Rama’s success proved that destiny and the gods invariably assist those who steadfastly adhere to Dharma.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 81,
        sanskrit = "सदेवर्षिगणं तुष्टं राघवस्य महात्मनः ।\nअभिषिच्य च लङ्कायां राक्षसेन्द्रं विभीषणम् ॥ ८१ ॥",
        hindiCommentary = """
            महात्मा राघव के कार्यों से देवता और ऋषियों का समूह अत्यंत संतुष्ट (तुष्टं) और प्रसन्न हुआ।
            राम ने लंका में राक्षसों के इंद्र (राजा) के रूप में विभीषण का विधिवत राज्याभिषेक (अभिषिच्य) किया।
            विभीषण का राज्य अब अधर्म का नहीं, बल्कि भक्ति और न्याय का गढ़ बनने वाला था।
            देवताओं की तुष्टि यह बताती है कि ब्रह्मांड का संतुलन अब फिर से स्थापित हो चुका था।
            राम ने विभीषण को गले लगाया और उसे लंका की बागडोर सौंपकर अपना अटूट मैत्री धर्म निभाया।
            लंका का वातावरण अब भय की जगह शांति और वेदमंत्रों की ध्वनि से गूँजने के लिए तैयार था।
            नारद जी यहाँ राम की प्रशासनिक कुशलता और उनके द्वारा किए गए न्यायपूर्ण बँटवारे को दिखा रहे हैं।
            राम ने एक शत्रु के भाई को राजा बनाया क्योंकि वह सत्य के साथ खड़ा था, जो राम की महानता है।
            ऋषियों का प्रसन्न होना यह संकेत है कि अब उनके यज्ञ और साधना बिना किसी विघ्न के संपन्न हो सकेंगे।
            यह श्लोक राम के 'अजातशत्रु' और 'लोकरक्षक' स्वरूप की एक और सुंदर पुष्टि करता है।
            लंका विजय के बाद भी राम के मन में राज्य का कोई लोभ नहीं था, वे केवल धर्म की स्थापना चाहते थे।
        """.trimIndent(),
        englishCommentary = """
            The assembly of gods and sages was deeply satisfied (Tushtam) with the deeds of the high-souled Raghava.
            Rama formally consecrated (Abhishicya) Vibhishana as the King (Rakshasendra) of Lanka.
            Lanka was now set to transform from a stronghold of sin into a bastion of devotion and justice.
            The satisfaction of the gods indicated that the cosmic balance had been successfully restored.
            Rama embraced Vibhishana, handing him the reins of Lanka and fulfilling His bond of eternal friendship.
            The atmosphere of Lanka was now prepared to resonate with peace and Vedic chants instead of terror.
            Narada illustrates Rama's administrative wisdom and His commitment to a just distribution of power.
            Rama made a foe’s brother the king because he stood by the Truth, showcasing Rama’s immense nobility.
            The joy of the sages suggested that their sacred sacrifices and meditation could now proceed without hindrance.
            This verse further confirms Rama’s persona as one who has no enemies and is the ultimate protector of the world.
            Even after conquering Lanka, Rama harbored no greed for its throne; He only desired the establishment of Dharma.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 82,
        sanskrit = "कृतकृत्यस्तदा रामो विज्वरः प्रमुमोद ह ।\nदेवताभ्यो वरं प्राप्य समुत्थाप्य च वानरान् ॥ ८२ ॥",
        hindiCommentary = """
            अपने उद्देश्यों को सफल (कृतकृत्यः) पाकर राम 'विज्वरः' (मानसिक संताप से मुक्त) होकर अत्यंत हर्षित हुए।
            उन्होंने देवताओं से वरदान प्राप्त किया और युद्ध में मारे गए सभी वानरों को पुनः जीवित (समुत्थाप्य) कर दिया।
            वानरों को जीवनदान देना राम की अपने सैनिकों के प्रति अगाध करुणा और उनके प्रेम का प्रतीक है।
            उन वानरों ने राम के लिए अपने प्राण दिए थे, और राम ने ईश्वर होकर उनका वह ऋण चुकता किया।
            'विज्वर' होने का अर्थ है कि उनके मन से सीता के विरह और रावण के पापों का सारा बोझ उतर गया था।
            यह दृश्य अत्यंत भावुक था, जहाँ मरे हुए वानर फिर से उठकर राम के जयकारे लगाने लगे।
            राम की यह शक्ति दिखाती है कि वे केवल विनाशक नहीं, बल्कि जीवन देने वाले 'प्राणदाता' भी हैं।
            नारद जी यहाँ राम की उस सफलता का वर्णन कर रहे हैं जहाँ एक भी निस्वार्थ सेवक की आहुति व्यर्थ नहीं गई।
            देवताओं का वरदान यह सिद्ध करता है कि राम की मानवीय लीला में स्वर्ग की शक्तियाँ भी उनकी दासी थीं।
            अब राम अपनी पूरी सेना के साथ अयोध्या लौटने के लिए मानसिक रूप से स्वतंत्र और तैयार थे।
            यह श्लोक राम के उस करुणामयी हृदय को उजागर करता है जो अपने भक्तों के लिए मृत्यु को भी हरा सकता है।
        """.trimIndent(),
        englishCommentary = """
            Finding His mission fulfilled (Kritakrityah), Rama became 'Vijvarah'—free from all mental fever—and rejoiced.
            Receiving a boon from the gods, He brought back to life (Samutthapya) all the Vanaras slain in the war.
            Restoring the Vanaras to life represents Rama's immense compassion and His deep love for His soldiers.
            Those monkeys had sacrificed their lives for Rama, and as the Supreme Lord, He repaid that debt of soul.
            Being 'Vijvara' implies that the weight of Sita’s separation and Ravana’s sins had finally been lifted from His mind.
            The scene was profoundly emotional, as fallen warriors rose again to chant the glories of Lord Rama.
            This power demonstrates that Rama is not just a destroyer of evil but also the divine Giver of Life.
            Narada describes a success where not a single selfless sacrifice of a servant was allowed to go in vain.
            The boon from the gods proves that even in His human play, the celestial powers were at Rama's disposal.
            Rama was now mentally free and fully prepared to return to Ayodhya with His entire victorious army.
            This verse highlights the compassionate heart of Rama, which can conquer even death for the sake of His devotees.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 83,
        sanskrit = "अयोध्यां प्रस्थितो रामः पुष्पकं तं समाश्रितः ।\nभरद्वाजाश्रमं गत्वा रामः सत्यपराक्रमम् ॥ ८३ ॥",
        hindiCommentary = """
            सीता और लक्ष्मण के साथ राम 'पुष्पक विमान' पर आरूढ़ होकर अयोध्या की ओर प्रस्थान कर गए।
            अयोध्या पहुँचने से पहले, सत्यपराक्रमी राम ने महर्षि भरद्वाज के आश्रम में जाकर उन्हें प्रणाम किया।
            पुष्पक विमान का आकाश में उड़ना राम की दिव्य विजय और उनके राजसी गौरव का भव्य प्रतीक था।
            भरद्वाज मुनि के पास जाना यह दिखाता है कि राम अपनी सफलता का श्रेय ऋषियों के आशीर्वाद को देते थे।
            वे चाहते थे कि उनके लौटने की सूचना पहले उन संतों को मिले जिन्होंने उनके वनवास में उनका मार्गदर्शन किया।
            राम का हृदय अब अयोध्या की मिट्टी से मिलने के लिए व्याकुल था, पर वे शिष्टाचार कभी नहीं भूलते थे।
            भरद्वाज जी ने राम को देखकर अत्यंत हर्ष व्यक्त किया और उन्हें अयोध्या की कुशलता के बारे में बताया।
            नारद जी यहाँ राम की उस विनम्रता का वर्णन कर रहे हैं जो सफलता के शिखर पर भी ऋषियों के चरणों में झुकती है।
            पुष्पक विमान पर सीता जी के साथ राम की छवि साक्षात् लक्ष्मी-नारायण के समान अलौकिक लग रही थी।
            यह यात्रा वनवास के कष्टों के अंत और एक स्वर्ण युग के प्रारंभ की ओर एक दिव्य उड़ान थी।
            राम ने सिद्ध किया कि महानता केवल युद्ध जीतने में नहीं, बल्कि अपने मूल और संस्कारों को याद रखने में है।
        """.trimIndent(),
        englishCommentary = """
            Accompanied by Sita and Lakshmana, Rama boarded the 'Pushpaka Vimana' and set out toward Ayodhya.
            Before reaching the capital, the truly valiant Rama visited the hermitage of Sage Bharadwaja to pay respects.
            The flight of the Pushpaka Vimana was a magnificent symbol of Rama’s divine victory and His regal splendor.
            Visiting Bharadwaja shows that Rama attributed His success to the blessings and guidance of the sages.
            He desired that the news of His return reach the holy men who had anchored Him during His years of exile.
            While His heart yearned to touch the soil of Ayodhya, He never compromised on the rules of etiquette.
            Sage Bharadwaja was overjoyed to behold Rama and briefed Him on the well-being of the city and its people.
            Narada describes the humility of Rama, which bows at the feet of seers even at the pinnacle of His success.
            Seated with Sita on the Pushpaka, Rama’s image appeared like the celestial union of Lakshmi and Narayana.
            This journey was a divine flight marking the end of the forest trials and the dawn of a Golden Age.
            Rama proved that true greatness lies not just in winning wars but in remembering one's roots and traditions.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 84,
        sanskrit = "भरतस्यान्तिकं रामो हनूमन्तं व्यसर्जयत् ।\nपुनराख्यायिकां जल्पन्सुग्रीवसहितस्तदा ॥ ८४ ॥",
        hindiCommentary = """
            राम ने हनुमान जी को अग्रिम दूत के रूप में भरत के पास भेजा ताकि वे उनके आगमन की सूचना दे सकें।
            राम सुग्रीव और अन्य वानरों के साथ पुष्पक विमान पर बैठकर अपनी पुरानी कथाओं (आख्यायिकां) की चर्चा करने लगे।
            उन्होंने हनुमान को इसलिए भेजा क्योंकि वे भरत की प्रतिक्रिया देखकर यह जानना चाहते थे कि क्या भरत अब भी राज्य चाहते हैं?
            राम की यह मनोवैज्ञानिक समझ दिखाती है कि वे किसी पर भी राज्य का अधिकार थोपना नहीं चाहते थे।
            हनुमान जी ने नन्दिग्राम जाकर भरत को राम के आने का शुभ समाचार दिया, जिससे भरत आनंद के समुद्र में डूब गए।
            विमान में बैठ कर राम सुग्रीव को वे स्थान दिखा रहे थे जहाँ उन्होंने वनवास के दौरान कठिन समय बिताया था।
            यह संवाद पुरानी स्मृतियों को ताजा करने और मित्रों के साथ विजय की खुशी साझा करने का एक सुंदर क्षण था।
            नारद जी यहाँ राम की उस सावधानी और संवेदनशीलता का वर्णन कर रहे हैं जो वे अपने भाई भरत के प्रति रखते थे।
            हनुमान जी का दूत बनना एक बार फिर उनकी बुद्धिमत्ता और राम के प्रति उनकी उपयोगिता को सिद्ध करता है।
            अयोध्या में अब उत्सव की तैयारियाँ शुरू हो चुकी थीं, क्योंकि राम का संदेश पहुँच चुका था।
            यह श्लोक प्रेम, कूटनीति और पुरानी यादों के एक बहुत ही मानवीय और मधुर संगम को प्रस्तुत करता है।
        """.trimIndent(),
        englishCommentary = """
            Rama dispatched Hanuman as a herald to Bharata to inform him of His imminent and victorious arrival.
            Seated on the Pushpaka with Sugriva and others, Rama began discussing the tales (Akhyayikam) of their past journey.
            He sent Hanuman specifically to observe Bharata’s reaction and gauge if he still held any desire for the throne.
            This psychological insight shows that Rama did not wish to impose His sovereignty if Bharata desired otherwise.
            Hanuman reached Nandigrama and broke the news to Bharata, who was instantly submerged in an ocean of bliss.
            From the aerial view, Rama pointed out to Sugriva the various spots where they had faced trials during the exile.
            This dialogue was a beautiful moment of revisiting old memories and sharing the joy of victory with friends.
            Narada describes Rama's caution and His profound sensitivity toward the feelings of His brother Bharata.
            Hanuman's role as the messenger once again proves His unmatched intellect and His utility to Lord Rama.
            Preparations for a grand celebration began in Ayodhya the moment Rama's message was formally delivered.
            This verse presents a very human and sweet confluence of love, diplomacy, and the nostalgia of past struggles.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 85,
        sanskrit = "पुष्पकं तत्समारुह्य नन्दिग्रामं ययौ तदा ।\nनन्दिग्रामे जटां हित्वा भ्रातृभिः सहितोऽनघः ॥ ८५ ॥",
        hindiCommentary = """
            पुष्पक विमान पर सवार होकर राम नन्दिग्राम पहुँचे, जहाँ भरत उनकी प्रतीक्षा कर रहे थे।
            वहाँ पहुँचकर 'अनघः' (पापरहित/निर्मल) राम ने अपनी जटाएं कटवाईं और वनवासी वेश का त्याग किया।
            उनके साथ उनके तीनों भाई—लक्ष्मण, भरत और शत्रुघ्न—भी अपनी जटाएं त्यागकर पुनः राजकुमार स्वरूप में आए।
            नन्दिग्राम वह पावन भूमि बनी जहाँ चौदह वर्षों का वियोग अंततः एक महा-मिलन में बदल गया।
            राम का जटाएं त्यागना इस बात का प्रतीक था कि अब तपस्या का काल समाप्त हुआ और शासन का समय शुरू हुआ।
            भाइयों का एक साथ मिलना प्रेम और एकता का ऐसा दृश्य था जिसे देखकर अयोध्या की प्रजा के अश्रु थम नहीं रहे थे।
            राम 'अनघ' हैं, यानी वन के कष्टों और रावण के युद्ध ने भी उनकी आत्मा की पवित्रता पर कोई दाग नहीं लगाया।
            नारद जी यहाँ उस महान 'कायाकल्प' का वर्णन कर रहे हैं जहाँ तपस्वी फिर से राजा बनने की तैयारी कर रहे हैं।
            राम ने भरत को गले लगाया और उनके त्याग की सराहना की, जो राम के वनवास से भी अधिक कठिन था।
            पूरा नन्दिग्राम जय श्री राम के नारों से गूँज उठा था और चारों ओर आनंद का वातावरण था।
            यह श्लोक परिवार के पुनर्मिलन और वनवासी जीवन के औपचारिक समापन का एक अत्यंत भावपूर्ण चित्रण है।
        """.trimIndent(),
        englishCommentary = """
            Seated on the Pushpaka, Rama arrived at Nandigrama, where Bharata had been awaiting Him with longing.
            Upon landing, the sinless (Anaghah) Rama cut His matted hair and finally set aside His ascetic attire.
            Along with Him, His three brothers—Lakshmana, Bharata, and Shatrughna—also removed their matted locks.
            Nandigrama became the sacred ground where fourteen years of separation finally dissolved into a grand reunion.
            Rama's removal of matted hair symbolized the conclusion of His period of penance and the start of His reign.
            The sight of the four brothers together was an emblem of love and unity that moved the citizens to tears.
            Rama is 'Anagha,' meaning the trials of the forest and the gore of war had left no stain on His pristine soul.
            Narada describes the great transformation where the ascetics were now preparing to assume their royal roles.
            Rama embraced Bharata and lauded his sacrifice, which was in many ways even more rigorous than the exile.
            The entire village of Nandigrama resonated with the chants of 'Jai Shri Ram' amidst a pervasive atmosphere of bliss.
            This verse is a poignant depiction of the family reunion and the formal conclusion of their forest-dwelling life.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 86,
        sanskrit = "रामः सीतामनुप्राप्य राज्यं पुनरवाप्तवान् ।\nप्रहृष्टो मुदितो लोकस्तुष्टः पुष्टः सुधार्मिकः ॥ ८६ ॥",
        hindiCommentary = """
            सीता को वापस पाकर राम ने अयोध्या का राज्य पुनः प्राप्त किया और वे विधिवत सिंहासन पर बैठे।
            राम के राजा बनते ही पूरी दुनिया 'प्रहृष्टो' (अत्यधिक प्रसन्न) और 'मुदितो' (आनंदित) हो गई।
            प्रजा 'तुष्ट' (संतुष्ट), 'पुष्ट' (स्वस्थ और समृद्ध) और 'सुधार्मिक' (अत्यंत धार्मिक) हो गई थी।
            राम का शासन केवल सत्ता का परिवर्तन नहीं था, बल्कि मानवता के लिए सुख और शांति का उदय था।
            अकाल, महामारी और दुख अब अयोध्या के लिए पुरानी बातें बन चुकी थीं, क्योंकि वहाँ साक्षात् धर्म का राज था।
            लोग एक-दूसरे से द्वेष करना भूल गए थे और हर कोई अपने-अपने कर्तव्य का पालन निष्ठा से करता था।
            सीता जी के साथ राम का सिंहासन पर बैठना लक्ष्मी और नारायण के पृथ्वी पर राज्य करने जैसा था।
            नारद जी यहाँ उस आदर्श राज्य की पहली झलक दे रहे हैं जिसे आज भी हम 'राम-राज्य' कहते हैं।
            धर्म की पुनर्स्थापना के कारण प्रकृति भी मेहरबान थी और समय पर वर्षा व प्रचुर अन्न प्रदान कर रही थी।
            यह श्लोक सिद्ध करता है कि एक धर्मनिष्ठ राजा के होने से पूरी प्रजा का भाग्य और चरित्र बदल जाता है।
            राम की विजय अब एक वैश्विक कल्याण के रूप में परिणत हो चुकी थी, जिसका प्रभाव कण-कण पर था।
        """.trimIndent(),
        englishCommentary = """
            Having recovered Sita, Rama regained His kingdom and was formally established on the throne of Ayodhya.
            With Rama as King, the entire world became 'Prahrishto' (greatly thrilled) and 'Mudito' (overflowing with joy).
            The subjects became contented (Tushtah), nourished/prosperous (Pushtah), and highly righteous (Sudharmikah).
            Rama's reign was not just a change in power but the dawn of unparalleled happiness and peace for humanity.
            Famine, epidemics, and sorrow became things of the past for Ayodhya, as Righteousness itself ruled the land.
            People forgot their mutual animosities and everyone performed their respective duties with absolute sincerity.
            Rama and Sita seated on the throne appeared like Lakshmi and Narayana themselves governing the earth.
            Narada offers the first glimpse of that ideal state which we still celebrate today as 'Ram-Rajya.'
            Because Dharma was restored, even nature became benevolent, providing timely rains and abundant harvests.
            This verse proves that the presence of a righteous monarch transforms the destiny and character of the subjects.
            Rama’s victory had now materialized into universal welfare, its profound impact felt in every atom of existence.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 87,
        sanskrit = "निरातङ्को ह्यरोगश्च दुर्भिक्षभयवर्जितः ।\nन पुत्रमरणं केचिद्द्रक्ष्यन्ति पुरुषाः क्वचित् ॥ ८७ ॥",
        hindiCommentary = """
            राम के राज्य में लोग पूरी तरह 'निरातङ्को' (भयमुक्त) और 'अरोग' (रोगरहित) हो गए थे।
            दुर्भिक्ष (अकाल) का भय जड़ से समाप्त हो गया था और चारों ओर प्रचुरता और वैभव का वास था।
            सबसे बड़ी विशेषता यह थी कि वहाँ किसी भी पिता को अपने पुत्र की मृत्यु (पुत्रमरणं) नहीं देखनी पड़ती थी।
            यह श्लोक राम-राज्य की उस सुरक्षा और स्वास्थ्य व्यवस्था का वर्णन करता है जो अकल्पनीय है।
            जब राजा धर्म का साक्षात् स्वरूप हो, तो अकाल मृत्यु और बीमारियाँ भी राज्य की सीमा छोड़ देती हैं।
            लोग मानसिक और शारीरिक रूप से इतने स्वस्थ थे कि वे अपनी पूरी आयु आनंदपूर्वक व्यतीत करते थे।
            भय का अभाव यह दर्शाता है कि कानून व्यवस्था इतनी सुदृढ़ थी कि किसी को किसी से डर नहीं लगता था।
            नारद जी यहाँ राम-राज्य को स्वर्ग की एक प्रतिकृति के रूप में वाल्मीकि के सामने प्रस्तुत कर रहे हैं।
            पुत्रमरण न होना यह बताता है कि जीवन की स्वाभाविक लय और मर्यादा पूरी तरह सुरक्षित थी।
            यह शासन केवल इंसानों के लिए नहीं, बल्कि पूरी प्रकृति के लिए एक वरदान साबित हुआ था।
            राम की उपस्थिति ही हर रोग और हर शोक की सबसे बड़ी और अचूक औषधि बन गई थी।
        """.trimIndent(),
        englishCommentary = """
            In Rama's kingdom, the people became entirely fearless (Niratanko) and free from any diseases (Aroga).
            The dread of famine (Durbhiksha) was completely eradicated, replaced by abundance and all-round splendor.
            The most remarkable feature was that no father ever had to witness the untimely death of his son.
            This verse describes the security and health standards of Ram-Rajya, which were truly beyond imagination.
            When the King is the personification of Dharma, even premature death and sickness abandon the realm.
            People were so mentally and physically robust that they lived out their full, destined lifespans in joy.
            The absence of fear indicates that the legal and moral order was so strong that no one felt threatened.
            Narada presents Ram-Rajya to Valmiki as a direct reflection of the celestial heavens on the earthly plane.
            The absence of sons dying before fathers signifies that the natural rhythm of life was perfectly preserved.
            This administration proved to be a divine boon not just for humans but for the entire natural world.
            Rama's very presence functioned as the ultimate and unerring medicine for every possible disease or grief.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 88,
        sanskrit = "नार्यश्चाविधवा नित्यं भविष्यन्ति पतिव्रताः ।\nन चाग्निजं भयं किञ्चिन्नाप्सु मज्जन्ति जन्तवः ॥ ८८ ॥",
        hindiCommentary = """
            स्त्रियाँ कभी विधवा नहीं होती थीं और वे सदा अपने पतिव्रत धर्म में दृढ़ और निष्ठावान रहती थीं।
            राम के राज्य में अग्नि से होने वाली दुर्घटनाओं (अग्निजं भयं) का कोई भय नहीं रह गया था।
            कोई भी प्राणी जल में डूबकर (मज्जन्ति) मृत्यु को प्राप्त नहीं होता था, यानी जल भी प्रजा का रक्षक था।
            यह श्लोक राम-राज्य में स्त्रियों के सम्मान और प्रकृति के साथ उनके सामंजस्य को उजागर करता है।
            वैधव्य का न होना यह संकेत देता है कि पुरुष अपनी पूर्ण आयु तक जीवित रहते थे और समाज सुखी था।
            अग्नि और जल जैसी प्राकृतिक शक्तियाँ भी राम की आज्ञाकारी बन गई थीं और केवल कल्याण करती थीं।
            सुरक्षा का स्तर ऐसा था कि घरों में ताले लगाने की आवश्यकता नहीं थी और प्रकृति भी हिंसक नहीं थी।
            नारद जी यहाँ राम की उस 'योग-शक्ति' का वर्णन कर रहे हैं जो जड़ और चेतन—दोनों को नियंत्रित करती थी।
            पतिव्रता होने का अर्थ है कि समाज में चारित्रिक शुद्धता और परिवार के प्रति समर्पण अपने चरम पर था।
            यह शासन एक ऐसी व्यवस्था थी जहाँ किसी भी प्रकार की आकस्मिक विपदा के लिए कोई जगह नहीं थी।
            राम ने सिद्ध किया कि जब राजा का आचरण शुद्ध होता है, तो पंचमहाभूत भी प्रजा की रक्षा करते हैं।
        """.trimIndent(),
        englishCommentary = """
            Women never became widows and remained eternally steadfast and devoted to their marital vows (Pativrata).
            In Rama's kingdom, there was absolutely no fear of accidents caused by fire (Agnijam Bhayam).
            No living being would ever perish by drowning (Majjanti) in water; even the elements were protective.
            This verse highlights the dignity of women and the harmony with nature during the reign of Lord Rama.
            The absence of widowhood suggests that men lived their full lives and the social structure was stable.
            Natural forces like Fire and Water became submissive to Rama's will, acting only for the welfare of all.
            The level of security was such that locks were unnecessary, and nature itself ceased to be predatory or violent.
            Narada describes Rama's 'Yoga-Shakti' (yogic power) which effectively governed both the sentient and insentient.
            Being 'Pativrata' implies that moral purity and dedication to the family unit were at their absolute peak.
            This administration was a system where there was no room for any form of sudden or accidental catastrophe.
            Rama proved that when a monarch's conduct is pristine, the five elements themselves guard the subjects.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 89,
        sanskrit = "न वातजं भयं किञ्चिन्नापि ज्वरकृतं तथा ।\nन चापि क्षुद्भयं तत्र न चौरभयमण्वपि ॥ ८९ ॥",
        hindiCommentary = """
            वहाँ न तो आँधी-तूफान (वातजं भयं) का डर था और न ही किसी प्रकार के ज्वर (बीमारी) का कष्ट।
            भूख (क्षुद्भयं) का भय तो नाममात्र को भी नहीं था, क्योंकि अन्न के भंडार हमेशा भरे रहते थे।
            चोरी (चौरभयम) का भय तो 'अणु' (तिनके) के बराबर भी नहीं था, क्योंकि लोग धर्मपरायण और ईमानदार थे।
            यह श्लोक राम-राज्य की आर्थिक और सामाजिक सुरक्षा का एक बहुत ही गहरा चित्र प्रस्तुत करता है।
            वातजं भयं न होना यह दर्शाता है कि वायु देवता भी राम की प्रजा को कष्ट नहीं पहुँचाते थे।
            बीमारियों का अभाव यह सिद्ध करता है कि लोगों की जीवनशैली और खान-पान अत्यंत सात्विक और संतुलित था।
            जब समाज में कोई गरीब नहीं था, तो चोरी करने की किसी को आवश्यकता ही महसूस नहीं होती थी।
            नारद जी यहाँ एक 'कमी-रहित' (Deficit-free) समाज का वर्णन कर रहे हैं जहाँ हर कोई पूर्णतः तृप्त था।
            ईमानदारी केवल कानून के डर से नहीं, बल्कि आंतरिक संस्कार और राम के आदर्शों के कारण थी।
            यह शासन व्यवस्था आज के आधुनिक युग के लिए भी एक उच्चतम मानक और एक स्वप्न के समान है।
            राम ने एक ऐसा सुरक्षा कवच तैयार किया था जहाँ प्रजा को किसी भी बाहरी या आंतरिक संकट की चिंता नहीं थी।
        """.trimIndent(),
        englishCommentary = """
            There was no fear of destructive storms (Vatajam Bhayam) nor any suffering caused by fevers or ailments.
            The dread of hunger (Kshud-bhayam) did not exist at all, for the granaries were eternally overflowing.
            There was not even an 'atom' (Anvap) of fear regarding theft, for the people were righteous and honest.
            This verse provides a profound picture of the economic and social security prevalent in Ram-Rajya.
            The absence of storm-fear suggests that even the Wind-god desisted from causing distress to Rama’s people.
            The lack of illness proves that the lifestyle and diet of the citizens were extremely pure and balanced.
            Since no one was impoverished in society, the very impulse or need for theft was entirely absent.
            Narada describes a 'Deficit-free' society where every single individual was completely satisfied and full.
            Honesty was practiced not out of fear of the law, but due to internal character and Rama’s own ideals.
            This administrative model serves as the highest standard and a beautiful dream even for the modern era.
            Rama had created a protective shield where the subjects were unconcerned by any internal or external crisis.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 90,
        sanskrit = "नगरं च राष्ट्रं च धनधान्यसमीक्षितम् ।\nनित्यं प्रमुदितं सर्वं यथा कृतयुगे तथा ॥ ९० ॥",
        hindiCommentary = """
            अयोध्या नगर और पूरा राष्ट्र धन-धान्य (समीक्षितम्) से लबालब भरा हुआ और अत्यंत समृद्ध था।
            हर ओर नित्य उत्सव जैसा माहौल रहता था और लोग 'प्रमुदित' (आनंदित) होकर जीवन जीते थे।
            राम का वह शासन काल साक्षात् 'कृतयुग' (सत्ययुग) के समान था, जहाँ केवल सत्य और धर्म का वास था।
            समृद्धि केवल सोने-चांदी में नहीं, बल्कि लोगों के संतोष और उनके आपसी प्रेम में भी झलकती थी।
            राम ने यह सिद्ध किया कि यदि राजा सत्यवान हो, तो त्रेतायुग में भी सत्ययुग का अनुभव किया जा सकता है।
            नगर का हर कोना साफ-सुथरा, सुगंधित और कलात्मक सौंदर्य से पूरी तरह परिपूर्ण था।
            प्रजा का आनंद स्वाभाविक था क्योंकि वे जानते थे कि उनका राजा उनके लिए अपना सर्वस्व न्योछावर करने को तैयार है।
            नारद जी यहाँ राम-राज्य की तुलना मानव इतिहास के सर्वश्रेष्ठ काल 'सत्ययुग' से कर रहे हैं।
            यह श्लोक राम के शासन की सफलता की अंतिम और सबसे बड़ी मुहर है, जहाँ अभाव का कोई नामोनिशान नहीं था।
            सत्ययुग जैसी स्थिति का अर्थ है कि लोग अपनी आत्मा के करीब थे और ईश्वर का साक्षात् अनुभव करते थे।
            राम की उपस्थिति ने अयोध्या को पृथ्वी का सबसे पवित्र और सुखी स्थान बना दिया था।
        """.trimIndent(),
        englishCommentary = """
            The city of Ayodhya and the entire nation were brimming with wealth and grain (Samikshitam) and were highly prosperous.
            Everywhere, there was a daily festive atmosphere, and everyone lived their lives in a state of 'Pramuditam' (bliss).
            Rama's reign was equal to the 'Krita Yuga' (Satya Yuga/Golden Age), where only Truth and Dharma resided.
            Prosperity was reflected not just in gold and silver, but in the contentment and mutual love of the people.
            Rama proved that if the monarch is anchored in Truth, the experience of the Golden Age can be felt in any era.
            Every corner of the city was clean, fragrant, and permeated with artistic and aesthetic beauty.
            The joy of the subjects was natural, for they knew their King was ready to sacrifice everything for them.
            Narada compares Ram-Rajya here to the 'Satya Yuga,' the most perfect period in all of human history.
            This verse is the final and greatest seal on the success of Rama's reign, where lack was nowhere to be found.
            A 'Satya Yuga' state means that people were closer to their souls and experienced the Divine directly.
            Rama's very presence transformed Ayodhya into the holiest and happiest place on the entire planet.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 91,
        sanskrit = "अश्वमेधशतैरिष्ट्वा तथा बहुसुवर्णकैः ।\nगवां कोट्ययुतं दत्त्वा विद्वद्भ्यो विधिपूर्वकम् ॥ ९१ ॥",
        hindiCommentary = """
            राजा राम ने सौ 'अश्वमेध यज्ञ' और अनेक 'बहुसुवर्णक' (अत्यधिक स्वर्ण दान वाले) यज्ञों का अनुष्ठान किया।
            उन्होंने विद्वान ब्राह्मणों और ऋषियों को विधिपूर्वक करोड़ों गाएं (गवां कोट्ययुतं) दान में दीं।
            ये यज्ञ केवल शक्ति प्रदर्शन नहीं थे, बल्कि ब्रह्मांड की शुद्धि और प्रजा के कल्याण के लिए किए गए थे।
            स्वर्ण और गोदान यह दर्शाता है कि राम के राज्य में संसाधनों की कोई कमी नहीं थी और वे उदारता की मूर्ति थे।
            विद्वानों का सम्मान करना राम की उस नीति का हिस्सा था जहाँ ज्ञान को सत्ता से ऊपर माना जाता था।
            विधिपूर्वक कार्य करना यह सिद्ध करता है कि राम शास्त्रों की मर्यादाओं का पूरी तरह से पालन करते थे।
            उनका प्रत्येक यज्ञ लोक-कल्याण के लिए समर्पित एक महान आध्यात्मिक अनुष्ठान होता था।
            नारद जी यहाँ राम के उस 'यज्ञकर्ता' और 'दाता' स्वरूप का गान कर रहे हैं जो देवताओं को भी विस्मित करता था।
            करोड़ों गायों का दान उस समय की सबसे बड़ी सामाजिक और आर्थिक सहायता मानी जाती थी।
            इन यज्ञों के माध्यम से राम ने समाज के हर वर्ग को जोड़ा और धर्म की जड़ों को और अधिक गहरा किया।
            यह श्लोक राम के ऐश्वर्य और उनके द्वारा किए गए महान दान-पुण्य का साक्षात् विवरण है।
        """.trimIndent(),
        englishCommentary = """
            King Rama performed a hundred 'Ashvamedha' sacrifices and numerous 'Bahusuvarnaka' (rich in gold) rituals.
            He gifted billions of cows (Gavam Kotyayutam) to learned scholars and sages with proper Vedic rites (Vidhipurvakam).
            These sacrifices were not mere displays of power but were performed for cosmic purification and public welfare.
            The donation of gold and cows signifies that there was no lack of resources, and He was the embodiment of generosity.
            Honoring scholars was part of Rama's policy where wisdom was valued far above mere political authority.
            Acting 'Vidhipurvakam' proves that Rama adhered strictly and perfectly to the protocols laid down in scriptures.
            Every single sacrifice of His was a grand spiritual undertaking dedicated to the benefit of the entire world.
            Narada celebrates Rama's role as the 'Sacrificer' and 'Donor,' whose charity amazed even the celestial gods.
            The donation of billions of cows was considered the greatest form of social and economic support in that era.
            Through these rituals, Rama unified all sections of society and deepened the roots of Righteousness.
            This verse provides a direct account of Rama's immense opulence and His phenomenal deeds of charity.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 92,
        sanskrit = "असंख्येयं धनं दत्त्वा ब्राह्मणेभ्यो महातपाः ।\nराजवंशान्शतगुणान्स्थापयिष्यति राघवः ॥ ९२ ॥",
        hindiCommentary = """
            महान तपस्वी राघव (राम) ने ब्राह्मणों को असंख्य धन दिया और कई राजवंशों को फिर से स्थापित किया।
            उन्होंने उन राजाओं के वंशों को सौ गुना अधिक शक्ति और मर्यादा के साथ उनके राज्यों पर बैठाया।
            राम की दृष्टि केवल अयोध्या तक सीमित नहीं थी; वे पूरे आर्यावर्त के राजाओं के रक्षक और मार्गदर्शक थे।
            असंख्य धन का दान यह बताता है कि राम का हृदय सागर के समान विशाल था और वे त्यागी शिरोमणि थे।
            राजवंशों को स्थापित करना यह सिद्ध करता है कि राम ने कभी भी दूसरों के राज्य हड़पने की नीति नहीं अपनाई।
            वे एक 'सम्राटों के सम्राट' थे, जिनका मुख्य कार्य न्यायपूर्ण शासन की व्यवस्था को सुनिश्चित करना था।
            उनकी तपस्या (महातपाः) उनके राजसी वैभव के पीछे की असली शक्ति थी, जो उन्हें विरक्त बनाए रखती थी।
            नारद जी यहाँ राम के उस 'धर्म-संस्थापक' स्वरूप का वर्णन कर रहे हैं जिसने पूरे भारतवर्ष को एक सूत्र में बांधा।
            राम ने उन राजाओं को भी धर्म की शिक्षा दी ताकि वे अपनी प्रजा का पालन आदर्श ढंग से कर सकें।
            उनका यह कार्य आने वाली पीढ़ियों के लिए राजनीति के एक शुद्ध और आदर्श स्वरूप का मार्गदर्शक बना।
            यह श्लोक राम के प्रभाव की व्यापकता और उनकी निष्काम सेवा भावना को बहुत स्पष्ट रूप से दर्शाता है।
        """.trimIndent(),
        englishCommentary = """
            The great ascetic Rama (Raghava) gifted immeasurable wealth to the Brahmins and re-established many dynasties.
            He restored the lineages of various kings to their thrones with a hundredfold increase in power and dignity.
            Rama's vision was not restricted to Ayodhya; He was the guardian and guide for all monarchs across the land.
            The gift of immeasurable wealth suggests that Rama's heart was as vast as the ocean, the pinnacle of renunciation.
            Restoring dynasties proves that Rama never adopted a policy of annexing or usurping the kingdoms of others.
            He was a 'King of Kings' whose primary function was to ensure the global establishment of just governance.
            His penance (Mahatapah) was the true power behind His royal splendor, keeping Him mentally detached.
            Narada describes Rama's role as the 'Establisher of Order' who unified the entire subcontinent under one law.
            Rama also educated those kings in Dharma so they could govern their respective subjects in an ideal manner.
            His actions served as a blueprint for a pure and ideal form of politics for all subsequent generations.
            This verse clearly illustrates the vastness of Rama's influence and His spirit of selfless service to humanity.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 93,
        sanskrit = "चातुर्वर्ण्यं च लोकेऽस्मिन् स्वे स्वे धर्मे नियोक्ष्यति ।\nदशवर्षसहस्राणि दशवर्षशतानि च ॥ ९३ ॥",
        hindiCommentary = """
            राम ने इस संसार में चारों वर्णों के लोगों को उनके अपने-अपने धर्म (कर्तव्य) में नियोजित किया।
            उन्होंने यह सुनिश्चित किया कि हर व्यक्ति समाज के प्रति अपने उत्तरदायित्व को पूरी निष्ठा से निभाए।
            राम ने ग्यारह हजार वर्षों (दशवर्षसहस्राणि दशवर्षशतानि च) तक इस पृथ्वी पर शासन किया।
            वर्णों को धर्म में नियोजित करने का अर्थ वर्ण-भेद नहीं, बल्कि कर्म की शुद्धता और व्यवस्था का पालन था।
            यह लंबी अवधि राम-राज्य की स्थिरता और उसकी सफलता का सबसे बड़ा और ठोस ऐतिहासिक प्रमाण है।
            इतने वर्षों तक शासन करना यह बताता है कि राम ने काल को भी अपने धर्म की शक्ति से नियंत्रित कर लिया था।
            समाज में किसी भी प्रकार का भटकाव नहीं था, क्योंकि राजा स्वयं आचरण का जीवंत उदाहरण था।
            नारद जी यहाँ राम के उस 'प्रशासक' स्वरूप की महिमा बता रहे हैं जिसने एक चिरस्थायी व्यवस्था दी।
            ग्यारह हजार वर्ष का कालखंड वास्तव में मानवता के लिए सुख और समृद्धि का एक चरमोत्कर्ष था।
            राम ने सिद्ध किया कि जब शासन का आधार सत्य हो, तो व्यवस्था सदियों तक बिना किसी विघ्न के चल सकती है।
            यह श्लोक राम के ऐतिहासिक कार्यकाल और उनके द्वारा स्थापित सामाजिक संतुलन को स्पष्ट रूप से दर्शाता है।
        """.trimIndent(),
        englishCommentary = """
            Rama established and engaged the four orders of society (Chaturvarnya) in their respective duties (Dharma).
            He ensured that every individual fulfilled their social responsibilities with absolute sincerity and dedication.
            Rama ruled over this earth for a period of eleven thousand years (ten thousand and one thousand years).
            Engaging the orders in Dharma did not imply discrimination but the preservation of moral and professional order.
            This long duration is the greatest historical evidence of the stability and success of Ram-Rajya.
            Ruling for such an epoch shows that Rama had effectively harmonized Time itself through the power of Dharma.
            There was no deviation in society, as the King Himself was the living embodiment of perfect conduct.
            Narada explains the grandeur of Rama as an administrator who provided a lasting and sustainable system.
            The span of eleven thousand years was the pinnacle of happiness and prosperity for all of humankind.
            Rama proved that when the foundation of governance is Truth, the system can thrive for ages without friction.
            This verse clearly depicts Rama’s historical tenure and the social equilibrium He successfully established.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 94,
        sanskrit = "रामो राज्यमुपासित्वा ब्रह्मलोकं प्रयास्यति ।\nइदं पवित्रं पापहरं पुण्यं वेदैश्च सम्मितम् ॥ ९४ ॥",
        hindiCommentary = """
            इतने वर्षों तक राज्य की 'उपासना' (सेवा) करने के बाद, राम अंततः ब्रह्मलोक (अपने परम धाम) को प्रस्थान करेंगे।
            'राज्यमुपासित्वा' शब्द यह बताता है कि राम के लिए राज्य शासन नहीं, बल्कि एक पवित्र उपासना थी।
            यह रामायण का वृत्तांत अत्यंत पवित्र, पापों को हरने वाला (पापहरं) और वेदों के समान (वेदैश्च सम्मितम्) है।
            नारद जी यहाँ राम की जीवन-यात्रा के दिव्य समापन और इस कथा की महानता की ओर संकेत कर रहे हैं।
            ब्रह्मलोक जाना यह सिद्ध करता है कि वे साक्षात् परमात्मा थे जो अपना कार्य पूरा कर स्वधाम लौट गए।
            इस कथा को वेदों के बराबर मानना इसकी दार्शनिक और आध्यात्मिक गहराई का सबसे बड़ा प्रमाण है।
            रामायण केवल एक राजा की कहानी नहीं, बल्कि जीवन जीने की एक पावन और प्राचीन नियमावली है।
            पापहरं होने का अर्थ है कि जो इस चरित्र का चिंतन करता है, उसके मन के सारे विकार समाप्त हो जाते हैं।
            नारद जी यहाँ वाल्मीकि को इस ग्रंथ की रचना के लिए अंतिम और सबसे प्रबल प्रेरणा प्रदान कर रहे हैं।
            यह श्लोक राम के 'अवतारी' होने पर अंतिम मुहर लगाता है और रामायण को एक 'धर्म-ग्रंथ' घोषित करता है।
            राम की यात्रा का अंत वास्तव में उनके भक्तों के लिए मोक्ष के द्वार खोलने वाली एक महान घटना है।
        """.trimIndent(),
        englishCommentary = """
            After performing the 'worship' (service) of the kingdom for so long, Rama will eventually depart for Brahmaloka.
            The term 'Rajyamupasitva' indicates that for Rama, governance was not rule but a form of sacred worship.
            This narrative of the Ramayana is supremely holy, a destroyer of sins (Papaharam), and equal to the Vedas.
            Narada points toward the divine conclusion of Rama’s life-journey and the magnitude of this epic story.
            Departing for Brahmaloka confirms that He was the Supreme Soul who returned home after fulfilling His task.
            Equating this story to the Vedas is the ultimate testimony to its philosophical and spiritual depth.
            The Ramayana is not just the story of a king; it is a sacred and ancient manual for righteous living.
            Being 'Papaharam' implies that whoever contemplates this character finds their mental impurities dissolved.
            Narada provides Valmiki with the final and most powerful inspiration to compose this monumental epic.
            This verse places the final seal on Rama's status as an Incarnation and declares the Ramayana a holy scripture.
            The conclusion of Rama's journey is a grand event that effectively opens the gates of liberation for His devotees.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 95,
        sanskrit = "यः पठेद्रामचरितं सर्वपापैः प्रमुच्यते ।\nएतदाख्यानमायुष्यं पठन्रामायणं नरः ॥ ९५ ॥",
        hindiCommentary = """
            जो कोई भी राम के इस दिव्य चरित्र (रामचरितं) का पाठ करता है, वह समस्त पापों से मुक्त (प्रमुच्यते) हो जाता है।
            रामायण का यह आख्यान 'आयुष्यं' (आयु को बढ़ाने वाला) है, जो पाठक को लंबी और स्वस्थ आयु प्रदान करता है।
            यह श्लोक 'फल-श्रुति' का प्रारंभ है, जहाँ इस ग्रंथ को पढ़ने के आध्यात्मिक लाभ बताए गए हैं।
            राम के गुणों का स्मरण ही मन को शुद्ध करने और सकारात्मक ऊर्जा प्राप्त करने का सबसे सरल मार्ग है।
            पापमुक्ति का अर्थ है—मन की वे ग्रंथियाँ खुल जाना जो हमें गलत मार्ग पर ले जाती हैं।
            आयुष्यं होने का अर्थ है कि राम का चरित्र व्यक्ति को मानसिक शांति देता है, जिससे स्वास्थ्य बेहतर होता है।
            'नरः' (मनुष्य) शब्द का प्रयोग यह बताता है कि यह लाभ किसी भी जाति या वर्ग के व्यक्ति के लिए सुलभ है।
            नारद जी यहाँ स्पष्ट कर रहे हैं कि रामायण केवल मनोरंजन नहीं, बल्कि एक 'कल्याणकारी' औषधि है।
            जो इस कथा को श्रद्धा से पढ़ता है, वह राम की कृपा का पात्र बनकर जीवन की बाधाओं को पार कर लेता है।
            यह श्लोक पाठक को इस महान ग्रंथ के साथ जुड़ने के लिए एक आध्यात्मिक और व्यावहारिक कारण देता है।
            राम का नाम ही मृत्यु के भय को मिटाने वाला और जीवन को सार्थकता प्रदान करने वाला एकमात्र सूत्र है।
        """.trimIndent(),
        englishCommentary = """
            Whoever reads this divine character of Rama (Ramacharitam) is liberated (Pramucyate) from all sins.
            This narrative of the Ramayana is 'Ayushyam'—it bestows longevity and a healthy life upon the reader.
            This verse marks the beginning of the 'Phala-shruti,' where the spiritual benefits of the text are detailed.
            Contemplating Rama's virtues is the simplest way to purify the mind and receive positive cosmic energy.
            Liberation from sin means the untying of mental knots that lead an individual toward the wrong paths.
            Being 'Ayushyam' implies that Rama’s character provides the mental peace that results in better physical health.
            The use of 'Naraha' (Man) shows that these benefits are accessible to any individual regardless of background.
            Narada clarifies that the Ramayana is not mere entertainment but a 'beneficial' medicine for the soul.
            Whoever reads this tale with faith receives Rama's grace and successfully overcomes life's many obstacles.
            This verse provides the reader with both a spiritual and practical reason to engage with this great epic.
            Rama's name is the singular thread that dispels the fear of death and grants ultimate meaning to human life.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 96,
        sanskrit = "सपुत्रपौत्रः सगणः प्रेत्य स्वर्गे महीयते ।\nपठन् द्विजो वागृषभत्वमीयात् ॥ ९६ ॥",
        hindiCommentary = """
            रामायण का पाठ करने वाला व्यक्ति अपने पुत्रों, पौत्रों और सहयोगियों (सगणः) के साथ सुख प्राप्त करता है।
            मृत्यु के पश्चात वह स्वर्ग लोक में सम्मानित (महीयते) होता है और उच्च गति को प्राप्त करता है।
            यदि कोई विद्वान् (द्विजो) इसका पाठ करता है, तो वह 'वागृषभत्वं' (वाणी की श्रेष्ठता और विद्वत्ता) प्राप्त करता है।
            यह श्लोक बताता है कि रामायण का प्रभाव केवल व्यक्ति तक नहीं, बल्कि उसके पूरे कुल तक पहुँचता है।
            पारिवारिक सुख और वंश की वृद्धि इस ग्रंथ के श्रवण और पठन का एक प्रत्यक्ष सामाजिक शुभ फल है।
            वाणी की श्रेष्ठता का अर्थ है कि व्यक्ति की बात में सत्य और प्रभाव आ जाता है, जो सरस्वती की कृपा है।
            स्वर्ग में स्थान मिलने का अर्थ है कि व्यक्ति के कर्म इतने शुद्ध हो जाते हैं कि वह दिव्य लोकों का अधिकारी बनता है।
            नारद जी यहाँ रामायण को एक 'पारिवारिक और सामाजिक' वरदान के रूप में प्रस्तुत कर रहे हैं।
            यह ग्रंथ पढ़ने वाले को समाज में मान-सम्मान और परिवार में प्रेमपूर्ण वातावरण प्रदान करता है।
            विद्वानों के लिए यह ज्ञान का वह शिखर है जो उन्हें शास्त्रों के मर्म को समझने की शक्ति देता है।
            यह श्लोक सिद्ध करता है कि राम की कथा हर प्रकार के मानवीय अभ्युदय (उन्नति) का मूल आधार है।
        """.trimIndent(),
        englishCommentary = """
            One who reads the Ramayana attains happiness along with his sons, grandsons, and associates (Saganah).
            After death, such an individual is honored (Mahiyate) in the heavenly realms and attains a high state.
            If a learned person (Dvija) reads it, he achieves 'Vagrishabhatvam'—supremacy and eloquence in speech.
            This verse indicates that the impact of the Ramayana extends beyond the individual to their entire lineage.
            Familial happiness and the growth of the clan are direct social benefits of hearing and reading this epic.
            Supremacy in speech implies that the individual's words become truthful and powerful, a grace of Saraswati.
            Attaining a place in heaven means the person's deeds become so pure that they deserve the celestial worlds.
            Narada presents the Ramayana as a 'familial and social' boon that enriches every aspect of an individual's life.
            The text grants the reader social prestige and fosters a loving and peaceful atmosphere within the family.
            For scholars, it is the peak of wisdom that empowers them to understand the deepest essence of scriptures.
            This verse proves that the story of Rama is the fundamental basis for every form of human progress and rise.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 97,
        sanskrit = "स्यात् क्षत्रियो भूमिपतित्वमीयात् ।\nवणिग्जनः पण्यफलत्वमीयात् ॥ ९७ ॥",
        hindiCommentary = """
            यदि कोई क्षत्रिय इसका पाठ करता है, तो वह 'भूमिपतित्वं' (संपूर्ण पृथ्वी का स्वामित्व या उच्च राजपद) प्राप्त करता है।
            यदि कोई वैश्य (वणिग्जनः) इसका पाठ करता है, तो उसे व्यापार में अपार लाभ और सफलता (पण्यफलत्वमीयात्) मिलती है।
            यह श्लोक रामायण के उस व्यापक प्रभाव को दिखाता है जो समाज के हर वर्ग के व्यवसाय को सफल बनाता है।
            क्षत्रिय के लिए राम एक आदर्श योद्धा और राजा हैं, जिनका चरित्र उसे नेतृत्व की शक्ति प्रदान करता है।
            वैश्य के लिए राम-राज्य की समृद्धि एक प्रेरणा है, जो उसे ईमानदारी और लाभ का सही संतुलन सिखाती है।
            यह सिद्ध करता है कि राम की कृपा भौतिक उन्नति (Material Progress) के लिए भी उतनी ही अचूक है।
            भूमिपति होने का अर्थ केवल जमीन जीतना नहीं, बल्कि प्रजा के हृदय पर राज करने का सामर्थ्य पाना है।
            व्यापार में फल मिलने का अर्थ है कि व्यक्ति का पुरुषार्थ सफल होता है और वह समाज के पोषण में समर्थ बनता है।
            नारद जी यहाँ स्पष्ट कर रहे हैं कि रामायण हर व्यक्ति के सांसारिक लक्ष्यों को पूरा करने वाली 'कामधेनु' है।
            जिस भी नियत और उद्देश्य से इस ग्रंथ का आश्रय लिया जाता है, राम उसे अवश्य पूरा करते हैं।
            यह श्लोक कर्म और उसके प्रतिफल के बीच राम की कृपा को एक अनिवार्य कड़ी के रूप में जोड़ता है।
        """.trimIndent(),
        englishCommentary = """
            If a Kshatriya (warrior class) reads it, he achieves 'Bhumipatitvam'—the lordship of the earth or high office.
            If a Vaishya (merchant class) reads it, he attains great success and profit (Panyaphalatvam) in his trade.
            This verse illustrates the pervasive impact of the Ramayana that brings success to every professional class.
            For the Kshatriya, Rama is the ideal warrior-king whose character infuses him with the power of leadership.
            For the Vaishya, the prosperity of Ram-Rajya is an inspiration, teaching the balance of honesty and profit.
            It proves that Rama's grace is equally potent and unerring for material progress and worldly advancement.
            Being a 'lord of earth' signifies not just conquering land but gaining the capability to rule over hearts.
            Attaining profit in trade implies that the individual’s efforts succeed, enabling him to nourish society.
            Narada clarifies that the Ramayana is a 'Kamadhenu' (wish-fulfilling cow) for achieving one's worldly goals.
            Whatever the intent or objective with which one seeks refuge in this text, Rama certainly fulfills it.
            This verse links Rama's grace as an indispensable element between human effort and its eventual reward.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 98,
        sanskrit = "जनश्च शूद्रोऽपि महत्त्वमीयात् ।\nइति वाल्मीकिरामायणे बालकाण्डे नारदवाक्यं नाम प्रथमः सर्गः ॥ ९८ ॥",
        hindiCommentary = """
            यहाँ तक कि शूद्र (सेवाभावी जन) भी इसका पाठ या श्रवण करके महानता और सम्मान (महत्त्वमीयात्) को प्राप्त करते हैं।
            यह श्लोक रामायण की 'सार्वभौमिकता' पर मुहर लगाता है—यहाँ कोई भी अछूत या अयोग्य नहीं है।
            राम के दरबार और उनकी कथा में केवल भक्ति और आचरण का मूल्य है, जन्म का नहीं।
            महत्त्व प्राप्त करने का अर्थ है कि समाज में उसे गौरव मिलेगा और उसका आत्म-सम्मान जागृत होगा।
            इस प्रकार, वाल्मीकि रामायण के बालकाण्ड में नारद के वचनों वाला यह 'प्रथम सर्ग' यहाँ पूर्ण होता है।
            यह सर्ग पूरी रामायण का 'बीज' है, जिसमें संक्षेप में पूरी कथा और उसके फल का वर्णन किया गया है।
            नारद जी ने वाल्मीकि को वह दिशा दे दी है जिस पर चलकर वे इस महान महाकाव्य की रचना करेंगे।
            यह अंतिम श्लोक समाज के अंतिम व्यक्ति को भी राम की भक्ति से जोड़कर उसे श्रेष्ठ बनाने का वचन देता है।
            शूद्र को महत्त्व मिलना यह सिद्ध करता है कि राम का नाम ऊंच-नीच के कृत्रिम भेदों को मिटाने वाला है।
            इस सर्ग का समापन एक महान संकल्प के साथ होता है जो मानवता को धर्म के मार्ग पर चलने की प्रेरणा देता है।
            ॥ इस प्रकार नारद-वाल्मीकि संवाद रूपी प्रथम सर्ग सम्पूर्ण हुआ ॥
        """.trimIndent(),
        englishCommentary = """
            Even a Shudra (the laboring class) attains greatness and respect (Mahattvam) by reading or hearing this epic.
            This verse puts the seal on the 'Universality' of the Ramayana—no one is untouchable or unqualified here.
            In Rama's court and in His story, the only currency is devotion and conduct, not the accident of birth.
            Attaining 'greatness' means the person will gain dignity in society and their self-respect will be awakened.
            Thus, the first Sarga named 'Narada-Vakyam' in the Baal Kand of Valmiki Ramayana is completed here.
            This chapter is the 'seed' of the entire Ramayana, briefly summarizing the story and its spiritual rewards.
            Narada has provided Valmiki with the definitive direction to compose this monumental and eternal epic.
            This final verse promises to elevate even the lowliest person in society by connecting them to Rama's devotion.
            A Shudra attaining greatness proves that Rama's name dissolves all artificial hierarchies of high and low.
            The Sarga concludes with a grand resolve that continues to inspire all of humanity to walk the path of Dharma.
            || Thus ends the first Sarga consisting of the dialogue between Narada and Valmiki ||
        """.trimIndent()
    ),
    RamayanVerse(
        id = 99,
        sanskrit = "तपसा हृतपाप्मानं श्रद्धावन्तं जितेन्द्रियम् ।\nवाल्मीकिं मुनिशार्दूलं नारदः पर्यपृच्छत ॥ ९९ ॥",
        hindiCommentary = """
            (अतिरिक्त व्याख्या) नारद जी ने उस वाल्मीकि को देखा जो तपस्या से निष्पाप, श्रद्धावान और जितेन्द्रिय हो चुके थे।
            वाल्मीकि जी को 'मुनिशार्दूलं' (मुनियों में सिंह के समान श्रेष्ठ) कहा गया है, जो उनकी आध्यात्मिक शक्ति का प्रतीक है।
            यह श्लोक गुरु और शिष्य के बीच के उस सूक्ष्म आध्यात्मिक विनिमय (Exchange) को दर्शाता है।
            नारद जी ने वाल्मीकि के अंतर्मन को पढ़ा और उन्हें काव्य रचना के लिए पूरी तरह से परिपक्व पाया।
            श्रद्धा ही वह आधार है जिस पर रामायण जैसा विशाल प्रासाद खड़ा किया जा सकता था।
            तपस्या ने वाल्मीकि के हृदय को इतना कोमल बना दिया था कि वे पूरी दुनिया का दुख महसूस कर सकते थे।
            जितेन्द्रिय होना यह सुनिश्चित करता है कि काव्य में कोई भी व्यक्तिगत राग-द्वेष या पक्षपात नहीं होगा।
            नारद जी की यह अंतिम दृष्टि वाल्मीकि के लिए एक दिव्य अभिषेक के समान थी।
            यह श्लोक हमें सिखाता है कि ज्ञान प्राप्त करने के लिए पात्रता (पात्र होना) अनिवार्य शर्त है।
            वाल्मीकि की महानता को नारद जी ने अपनी स्वीकृति देकर इस महाकाव्य के जन्म को गौरव प्रदान किया।
            अब वाल्मीकि जी उस 'आदि-कवि' बनने की यात्रा के लिए पूरी तरह तैयार थे जो युगों-युगों तक पूजे जाएंगे।
        """.trimIndent(),
        englishCommentary = """
            (Additional insight) Narada beheld Valmiki, who was purified by penance, full of faith, and master of his senses.
            Valmiki is called 'Munishardulam' (a lion among sages), symbolizing his immense spiritual power and courage.
            This verse illustrates the subtle spiritual exchange (vibrational match) between the Master and the Disciple.
            Narada read Valmiki’s inner being and found him perfectly ripe for the task of divine poetic composition.
            Faith (Shraddha) was the only foundation upon which a monumental structure like the Ramayana could be built.
            Penance had made Valmiki’s heart so tender that he was now capable of feeling the collective sorrow of the world.
            Being 'Jitendriyam' ensures that there will be no personal bias, attachment, or hatred in his poetic creation.
            Narada’s final gaze served as a divine consecration for Valmiki to begin his monumental literary work.
            This verse teaches that to receive high wisdom, the quality of 'eligibility' is an absolute and mandatory condition.
            By granting his approval to Valmiki’s stature, Narada bestowed immense dignity upon the birth of this epic.
            Valmiki was now fully prepared to embark on the journey of becoming the 'Adi-Kavi' (First Poet) of the universe.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 100,
        sanskrit = "इति सङ्क्षेपरामायणं समाप्तम् ।\n॥ श्रीसीतारामाभ्यां नमः ॥ १०० ॥",
        hindiCommentary = """
            इस प्रकार 'संक्षेप रामायण' (रामायण का सारांश) यहाँ समाप्त होता है, जो नारद द्वारा वर्णित है।
            यह सौवां श्लोक इस पवित्र यात्रा की पूर्णता और भगवान सीताराम के चरणों में समर्पण का प्रतीक है।
            संक्षेप रामायण का अर्थ है—पूरी रामायण का वह अर्क जिसे पीने मात्र से अमरत्व की प्राप्ति होती है।
            यह पाठ साधक के जीवन में राम के गुणों को उतारने और उसे धर्म के प्रति जाग्रत करने का अमोघ अस्त्र है।
            नारद जी ने गागर में सागर भर दिया है, जिससे कम समय में भी रामायण का पूर्ण लाभ उठाया जा सके।
            'श्रीसीतारामाभ्यां नमः' कहना यह बताता है कि शक्ति और शक्तिमान—दोनों का आशीर्वाद अनिवार्य है।
            यहाँ से वाल्मीकि जी का वह महान कार्य शुरू होता है जिसे हम 24,000 श्लोकों की 'मूल रामायण' कहते हैं।
            यह सर्ग पढ़ने के बाद व्यक्ति के भीतर राम के आदर्शों के प्रति एक गहरी भूख और जिज्ञासा जागृत होती है।
            यह समापन नहीं, बल्कि एक आध्यात्मिक क्रांति का आरंभ है जो पाठक के चरित्र को दिव्य बना देती है।
            राम की कथा अनंत है, पर उसका सार केवल सत्य, प्रेम और करुणा में ही छिपा हुआ है।
            ॥ इस प्रकार वाल्मीकि रामायण का प्रथम सर्ग पूर्णता को प्राप्त हुआ। सीताराम ॥
        """.trimIndent(),
        englishCommentary = """
            Thus concludes the 'Sankshepa Ramayana' (The Summary of Ramayana) as narrated by Sage Narada.
            This hundredth verse symbolizes the completion of this sacred journey and the total surrender to Sita-Rama.
            Sankshepa Ramayana is the concentrated essence of the entire epic; partaking of it grants spiritual immortality.
            This text is an unfailing tool to instill Rama's virtues in the seeker and awaken them toward their Dharma.
            Narada has contained the vast ocean in a small jar, allowing for the full benefits of the epic in a short time.
            Saying 'Shri Sita-Ramabhyam Namah' signifies that the blessing of both the Energy and the Energetic is vital.
            From this point begins the monumental task of Valmiki creating the 24,000 verses of the 'Mula Ramayana.'
            After reading this Sarga, a deep hunger and curiosity for Rama’s ideals are awakened within the reader's heart.
            This is not an end but the start of a spiritual revolution that renders the character of the reader divine.
            The story of Rama is infinite, but its essence is hidden only in the values of Truth, Love, and Compassion.
            || Thus the first Sarga of the Valmiki Ramayana reaches its glorious completion. Sita-Ram ||
        """.trimIndent()
    )
)

