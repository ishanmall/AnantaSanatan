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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SargaFourScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredVerses = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            sargaFourVerses
        } else {
            sargaFourVerses.filter {
                it.id.toString().contains(searchQuery) ||
                        it.sanskrit.contains(searchQuery, ignoreCase = true) ||
                        it.hindiCommentary.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(Color.White)) {
                CenterAlignedTopAppBar(
                    title = {
                        Text("चतुर्थ सर्ग - कुश-लव गान", fontWeight = FontWeight.ExtraBold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFE0B2)
                    )
                )
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = { Text("श्लोक संख्या या शब्द खोजें...") },
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
                // Ensure RamayanDetailCard is defined in your common components file
                RamayanDetailCard(verse)
            }

            if (filteredVerses.isEmpty()) {
                item {
                    Text(
                        "कोई परिणाम नहीं मिला।",
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

val sargaFourVerses = listOf(
    RamayanVerse(
        id = 1,
        sanskrit = "प्राप्तराज्यस्य रामस्य वाल्मीकिर्भगवानृषिः ।\nचकार चरितं कृत्स्नं विचित्रपदलक्षणम् ॥ १ ॥",
        hindiCommentary = """
            जब श्री राम ने अपना राज्य प्राप्त कर लिया, तब भगवान वाल्मीकि ने उनके संपूर्ण चरित्र की रचना की।
            यह काव्य 'विचित्रपदलक्षणम्' था, अर्थात इसमें शब्दों और लक्षणों का अत्यंत सुंदर व अद्भुत प्रयोग किया गया था।
            मुनि ने राम के राजा बनने के बाद उनके पिछले संघर्षों और भावी महिमा को एक सूत्र में पिरो दिया।
            यह रचना केवल एक कहानी नहीं थी, बल्कि एक दिव्य ऐतिहासिक दस्तावेज था जो मर्यादा की रक्षा के लिए लिखा गया।
            'भगवान' विशेषण वाल्मीकि की उस उच्च आध्यात्मिक अवस्था को दर्शाता है जहाँ वे स्वयं ईश्वरतुल्य हो चुके थे।
            उन्होंने राम के जीवन के हर सूक्ष्म मोड़ को अपनी लेखनी के माध्यम से अमर बना दिया।
            अयोध्या के सिंहासन पर राम के बैठने के साथ ही एक नए युग की शुरुआत हुई, और वाल्मीकि ने उसी का गान किया।
            शब्दों का चयन इतना सटीक था कि पाठक के हृदय में साक्षात् दृश्य उत्पन्न हो जाते थे।
            यह श्लोक रामायण के विधिवत लेखन कार्य के संपन्न होने की घोषणा करता है।
            मुनि का उद्देश्य था कि आने वाली पीढ़ियाँ राम के आदर्शों को केवल सुनें नहीं, बल्कि उन्हें जी सकें।
            इस प्रकार, विश्व के प्रथम महाकाव्य का निर्माण अयोध्या के स्वर्ण युग में पूरा हुआ।
        """.trimIndent(),
        englishCommentary = """
            After Lord Rama had regained His kingdom, the venerable Sage Valmiki composed His entire life story.
            The composition was characterized by 'Vichitrapadalakshanam'—extraordinary beauty in diction and syntax.
            The sage wove Rama's past struggles and His future glory into a seamless, divine narrative.
            This work was not merely a tale but a sacred historical record written to preserve the code of righteousness.
            The epithet 'Bhagavan' denotes Valmiki's high spiritual state, where he was equal to the Divine in wisdom.
            He immortalized every subtle turn of Rama’s life through the unprecedented power of his poetic pen.
            With Rama on the throne of Ayodhya, a new era dawned, and Valmiki became its foremost chronicler.
            The choice of words was so precise that it evoked vivid imagery directly within the reader's heart.
            This verse announces the formal completion of the transcription of the Ramayana.
            The sage’s objective was to ensure that future generations could not only hear but live Rama's ideals.
            Thus, the world's first epic reached its completion during the golden age of Ayodhya's restoration.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 2,
        sanskrit = "चतुर्विंशत्सहस्राणि श्लोकानामुक्तवानृषिः ।\nतथा सर्गशतान् पञ्च षट् काण्डानि तथोत्तरम् ॥ २ ॥",
        hindiCommentary = """
            मुनि वाल्मीकि ने इस महाकाव्य में कुल चौबीस हजार (२४,०००) श्लोकों की रचना की।
            इसमें पाँच सौ (५००) सर्ग और उत्तर काण्ड सहित कुल सात काण्डों का समावेश किया गया।
            २४,००० की यह संख्या गायत्री मंत्र के २४ अक्षरों का प्रतिनिधित्व करती है, जो इसकी पवित्रता का प्रमाण है।
            सर्गों का विभाजन कथा के प्रवाह को सुगम और समझने में आसान बनाने के लिए किया गया था।
            षट् काण्ड (बाल, अयोध्या, अरण्य, किष्किन्धा, सुन्दर, युद्ध) राम की यात्रा के मुख्य पड़ाव हैं।
            उत्तर काण्ड में राम के राज्य संचालन और बाद की महत्वपूर्ण घटनाओं का विस्तार से वर्णन है।
            यह संरचना रामायण को एक विशाल और सुव्यवस्थित ग्रंथ के रूप में प्रतिष्ठित करती है।
            मुनि ने सुनिश्चित किया कि कथा का कोई भी कोना अधूरा न रहे और सत्य पूरी तरह प्रकट हो।
            इतनी विशाल रचना को एक ही लय और छंद में लिखना वाल्मीकि की महान प्रतिभा का परिचायक है।
            यह श्लोक रामायण के 'सांख्यिकीय' (Statistical) और संरचनात्मक गौरव को स्पष्ट करता है।
            आज भी यह ग्रंथ अपनी इसी विशालता और गहराई के कारण विश्व भर में अद्वितीय माना जाता है।
        """.trimIndent(),
        englishCommentary = """
            The sage composed twenty-four thousand (24,000) verses in this magnificent epic.
            It was structured into five hundred (500) chapters (Sargas) and six major books, including the final Utatara Kanda.
            The number 24,000 corresponds to the 24 syllables of the sacred Gayatri Mantra, proving its sanctity.
            The division into Sargas was designed to make the flow of the narrative smooth and easy to comprehend.
            The six Kandas (Baal, Ayodhya, Aranya, Kishkindha, Sundara, Yuddha) represent the main phases of Rama’s odyssey.
            The Uttara Kanda details Rama's governance and the significant events that followed His coronation.
            This architecture established the Ramayana as a vast and meticulously organized scripture.
            The sage ensured that no aspect of the narrative remained incomplete and that the Truth was fully revealed.
            Writing such a massive work in a consistent meter and rhythm reflects Valmiki's phenomenal genius.
            This verse clarifies the 'statistical' and structural majesty of the original Ramayana.
            Even today, this text remains unique globally due to its immense scale and philosophical depth.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 3,
        sanskrit = "कृत्वा तु तन्महाप्राज्ञः सभविष्यं सहोत्तरम् ।\nचिन्तयामास को न्वेतत्प्रयुञ्जीयादिति प्रभुः ॥ ३ ॥",
        hindiCommentary = """
            भविष्य के वृत्तांत और उत्तर काण्ड सहित रामायण की रचना कर, महाप्राज्ञ वाल्मीकि सोच में पड़ गए।
            मुनि यह विचार करने लगे कि—"इस पावन काव्य का गान और प्रचार वास्तव में कौन कर सकता है?"
            सृजन तो पूरा हो चुका था, पर अब उसे जन-जन तक पहुँचाने के लिए योग्य माध्यम की आवश्यकता थी।
            मुनि जानते थे कि यह कथा केवल पढ़ी नहीं जानी चाहिए, बल्कि इसे स्वर और भाव के साथ गाया जाना चाहिए।
            'सभविष्यं' शब्द यह संकेत देता है कि मुनि ने राम के आने वाले समय को भी अपनी दिव्य दृष्टि से देख लिया था।
            एक महान कलाकार के लिए उसकी रचना का सही प्रदर्शन ही उसकी सबसे बड़ी चिंता और संतोष होता है।
            वाल्मीकि जी एक ऐसे गायक की खोज में थे जिसके पास शुद्ध वाणी, भक्ति और संगीत का ज्ञान हो।
            उन्हें ऐसे शिष्यों की तलाश थी जो राम के आदर्शों को बिना किसी त्रुटि के समाज के सामने रख सकें।
            यह श्लोक ज्ञान के 'प्रसार' (Dissemination) के महत्व को बहुत गहराई से उजागर करता है।
            मुनि की यह चिंता दर्शाती है कि श्रेष्ठ विद्या हमेशा श्रेष्ठ पात्रों के ही अधीन होनी चाहिए।
            यहीं से कुश और लव के चुनाव की दिव्य पृष्ठभूमि तैयार होना शुरू होती है।
        """.trimIndent(),
        englishCommentary = """
            Having completed the Ramayana, including the future events and the Uttara Kanda, the wise Valmiki fell into thought.
            The sage began to contemplate: "Who indeed is capable of performing and propagating this sacred poetry?"
            The creation was finished, but a suitable medium was now required to transmit it to the masses.
            The sage realized that this epic was not meant to be merely read; it was meant to be sung with emotion and melody.
            The term 'Sabhavishyam' indicates that the sage had perceived even the future of Rama through his divine vision.
            For a great artist, the correct presentation of his work is his greatest concern and eventual satisfaction.
            Valmiki was in search of singers who possessed pure speech, devotion, and thorough knowledge of music.
            He sought disciples who could present Rama's ideals to society without even a single phonetic error.
            This verse highlights the immense importance of the dissemination and propagation of sacred knowledge.
            The sage’s concern demonstrates that superior wisdom must always be entrusted to superior vessels.
            This moment sets the divine stage for the selection of the young Lava and Kusha as the messengers.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 4,
        sanskrit = "तस्य चिन्तयमानस्य महर्षेर्भावितात्मनः ।\nअजगृहुः ततः पादौ मुनिवेषौ कुशीलवौ ॥ ४ ॥",
        hindiCommentary = """
            जब मुनि इस विषय में गहन चिंतन कर रहे थे, तभी मुनि-वेषधारी 'कुश' और 'लव' ने उनके पैर छुए।
            वे दोनों राजकुमार, जो मुनि के आश्रम में ही तपस्वियों की तरह रह रहे थे, उनके पास आए।
            कुश और लव का मुनि-वेष में होना उनकी सादगी और उनके द्वारा प्राप्त संस्कारों का प्रतीक था।
            वाल्मीकि जी ने उन्हें देखते ही पहचान लिया कि यही वे 'पात्र' हैं जिनकी उन्हें प्रतीक्षा थी।
            'भावितात्मनः' शब्द वाल्मीकि की उस पवित्र चेतना को दर्शाता है जो हमेशा सत्य में रमी रहती थी।
            बच्चों द्वारा पैर छूना सम्मान और गुरु के प्रति पूर्ण समर्पण का परिचायक था।
            इन दोनों बालकों की वाणी में सरस्वती का वास था और मुख पर साक्षात् राम का तेज झलकता था।
            वे दोनों न केवल गायक थे, बल्कि राम के ही अंश थे, जो इस कथा के सबसे योग्य अधिकारी थे।
            मुनि के चिंतन का उत्तर प्रकृति ने स्वयं उनके शिष्यों के रूप में उनके सामने खड़ा कर दिया था।
            यह श्लोक रामायण के प्रथम गायकों के औपचारिक परिचय का एक बहुत ही गौरवमयी क्षण है।
            अब वाल्मीकि जी को विश्वास हो गया था कि उनका महाकाव्य सुरक्षित और प्रभावशाली हाथों में है।
        """.trimIndent(),
        englishCommentary = """
            As the sage was deeply contemplating, the young Kusha and Lava, clad in ascetic robes, touched his feet.
            These two princes, who were living like hermits in the sage’s ashram, approached him with reverence.
            Their appearance in 'Munivesha' (hermit’s attire) symbolized their simplicity and the values they had imbibed.
            Upon seeing them, Valmiki instantly recognized that these were the 'vessels' he had been waiting for.
            The word 'Bhavitatmanah' describes Valmiki’s holy consciousness, which was eternally anchored in Truth.
            The act of touching his feet signified their profound respect and total surrender to their Guru.
            Goddess Saraswati resided in their speech, and the radiance of Rama was visible upon their youthful faces.
            The two were not just singers; they were part of Rama Himself, making them the most deserving heirs to this epic.
            Nature had presented the answer to the sage’s contemplation in the form of these two exceptional disciples.
            This verse represents a glorious moment—the formal introduction of the first reciters of the Ramayana.
            Valmiki was now certain that his monumental epic was in safe, talented, and highly effective hands.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 5,
        sanskrit = "कुशीलवौ तु धर्मज्ञौ राजपुत्रौ यशस्विनौ ।\nभ्रातरौ स्वरसम्पन्नौ ददर्शाम्रमतः स्थितौ ॥ ५ ॥",
        hindiCommentary = """
            मुनि ने देखा कि कुश और लव धर्म के ज्ञाता (धर्मज्ञौ), यशस्वी और राजसी गुणों वाले बालक हैं।
            वे दोनों भाई मधुर स्वर (स्वरसम्पन्नौ) से युक्त थे और आश्रम में ही निवास कर रहे थे।
            उनका स्वर इतना दिव्य था कि वह देवताओं के संगीत को भी मात दे सकता था।
            राजपुत्र होने के बावजूद उनमें रत्ती भर भी अहंकार नहीं था, केवल विनम्रता और सीखने की ललक थी।
            यशस्वी होना यह बताता है कि छोटी आयु में ही उन्होंने अपने गुणों से सबको प्रभावित कर लिया था।
            दोनों का एक साथ होना शक्ति और माधुर्य के सुंदर समन्वय का प्रतीक था।
            वाल्मीकि जी ने उनके शारीरिक लक्षणों में भी श्री राम की साक्षात् छवि को स्पष्ट रूप से देखा।
            उनकी एकाग्रता और उनका अनुशासन उन्हें अन्य शिष्यों से अलग और श्रेष्ठ बनाता था।
            वे दोनों गान-विद्या और शस्त्र-विद्या—दोनों में ही पारंगत होने की क्षमता रखते थे।
            मुनि ने महसूस किया कि रामायण की करुणा और वीर रस इन दोनों के कंठ में पूरी तरह सुरक्षित रहेंगे।
            यह श्लोक कुश और लव की उन विशेषताओं का गान करता है जो उन्हें विश्व का प्रथम गायक बनाती हैं।
        """.trimIndent(),
        englishCommentary = """
            The sage observed that Kusha and Lava were knowers of Dharma, illustrious, and possessed of royal traits.
            The two brothers were endowed with melodic voices (Svarasampannau) and were residents of the hermitage.
            Their voices were so divine that they could easily rival the celestial music of the Gandharvas.
            Despite being princes, they harbored no ego, exhibiting only humility and a thirst for spiritual learning.
            Being 'Yashasvinau' suggests that even at a tender age, they had impressed everyone with their virtues.
            Their being together symbolized a beautiful harmony of power and sweet melodic grace.
            Valmiki clearly perceived the direct reflection of Sri Rama in their physical features and aura.
            Their concentration and discipline set them apart as superior among the other disciples of the ashram.
            The two possessed the inherent potential to master both the arts of music and the science of weaponry.
            The sage felt that the pathos and heroism of the Ramayana would be perfectly preserved in their throats.
            This verse celebrates the unique qualities of Kusha and Lava that qualify them as the world's first bards.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 6,
        sanskrit = "स तु मेधाविनौ दृष्ट्वा वेदेषु परिनिष्ठितौ ।\nवेदोपबृंहणार्थाय तावग्राहयत प्रभुः ॥ ६ ॥",
        hindiCommentary = """
            उन दोनों को अत्यंत बुद्धिमान (मेधाविनौ) और वेदों में निष्णात देखकर समर्थ मुनि प्रसन्न हुए।
            वेदों के अर्थ को और अधिक विस्तार (वेदोपबृंहणार्थाय) देने के लिए मुनि ने उन्हें रामायण सिखाई।
            वेदोपबृंहण का अर्थ है—वेदों के गूढ़ ज्ञान को कथाओं के माध्यम से सरल और व्यापक बनाना।
            वाल्मीकि जी जानते थे कि रामायण वास्तव में वेदों का ही सार है जो काव्य के रूप में प्रकट हुआ है।
            कुश और लव की मेधा (बुद्धि) इतनी तीव्र थी कि वे एक बार सुनकर ही सब कुछ याद कर लेते थे।
            मुनि ने उन्हें न केवल श्लोक रटाए, बल्कि उनके पीछे छिपे आध्यात्मिक दर्शन को भी समझाया।
            प्रभु वाल्मीकि ने उन्हें इस महान कार्य के लिए अपना साक्षात् उत्तराधिकारी मान लिया था।
            वेदों का ज्ञान होने के कारण वे छंदों की शुद्धता और उच्चारण के महत्व को भली-भांति समझते थे।
            यह शिक्षण प्रक्रिया केवल शिक्षा नहीं, बल्कि एक दिव्य दीक्षा थी जिसने उन्हें 'कुशीलव' बनाया।
            मुनि का उद्देश्य था कि समाज वेदों के कठिन ज्ञान को राम-कथा के माध्यम से सहजता से प्राप्त कर सके।
            यह श्लोक रामायण को वेदों के पूरक और विस्तारक ग्रंथ के रूप में आधिकारिक रूप से स्थापित करता है।
        """.trimIndent(),
        englishCommentary = """
            Observing them to be highly intelligent (Medhavinau) and well-versed in the Vedas, the capable sage was pleased.
            To provide a broader explanation and expansion (Vedopabrimhanarthaya) of the Vedas, he taught them the Ramayana.
            'Vedopabrimhana' means making the cryptic wisdom of the Vedas accessible and expansive through narratives.
            Valmiki realized that the Ramayana was essentially the essence of the Vedas manifested in poetic form.
            The intellect of Kusha and Lava was so sharp that they could memorize everything after hearing it once.
            The sage did not just make them rote-learn the verses but explained the deep spiritual philosophy behind them.
            Lord Valmiki accepted them as His direct spiritual heirs for this monumental and sacred task.
            Because of their Vedic training, they fully understood the importance of phonetic purity and meter.
            This teaching process was not mere education; it was a divine initiation that forged them into master bards.
            The sage’s goal was to enable society to easily grasp Vedic wisdom through the medium of Rama's story.
            This verse officially establishes the Ramayana as a text that complements and expands upon the eternal Vedas.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 7,
        sanskrit = "काव्यं रामायणं कृत्स्नं सीतायाश्चरितं महत् ।\nपौलस्त्यवधमित्येवं चकार चरितं मुनिः ॥ ७ ॥",
        hindiCommentary = """
            मुनि ने इसे 'रामायण', 'सीता का महान चरित्र' और 'रावण वध'—इन तीन नामों से पुकारा।
            उन्होंने इन शीर्षकों के माध्यम से कथा के तीन मुख्य आयामों को दुनिया के सामने रखा।
            'रामायण' का अर्थ है—राम की यात्रा; 'सीतायाश्चरितं' का अर्थ है—त्याग और पवित्रता की महिमा।
            'पौलस्त्यवध' (रावण वध) अधर्म के विनाश और न्याय की अंतिम विजय का प्रतीक था।
            यह ग्रंथ केवल एक व्यक्ति का नहीं, बल्कि संपूर्ण मानवता के उत्थान का काव्य था।
            मुनि ने देखा कि सीता का चरित्र राम के चरित्र के बिना अपूर्ण है, इसलिए उसे 'महत्' (महान) कहा।
            रावण का अंत वह बिंदु था जहाँ संसार को राक्षसी प्रवृत्तियों से मुक्ति प्राप्त हुई थी।
            इन तीन नामों में रामायण का पूरा दर्शन—भक्ति, शक्ति और मुक्ति—समाहित है।
            वाल्मीकि जी ने इस काव्य को एक ऐसी संरचना दी जो हर युग के पाठक को कुछ न कुछ नया सिखाती है।
            यह श्लोक ग्रंथ के आधिकारिक नामकरण और उसके विषय की व्यापकता को स्पष्ट करता है।
            पूरी दुनिया आज भी इसे इन्हीं महान शीर्षकों और उनके गहरे भावों के कारण पूजती है।
        """.trimIndent(),
        englishCommentary = """
            The sage designated the work as 'Ramayana,' 'The Great Life of Sita,' and 'The Slaying of Ravana.'
            Through these titles, he presented the three primary dimensions of the narrative to the world.
            'Ramayana' means Rama’s odyssey; 'Sitayashcharitam' signifies the glory of sacrifice and purity.
            'Paulastyavadha' (the slaying of Ravana) symbolized the destruction of evil and the ultimate triumph of Justice.
            This scripture was not just about one individual but was an epic for the upliftment of all humanity.
            The sage realized that Sita's character was inseparable from Rama’s, thus describing it as 'Mahat' (Great).
            Ravana's demise was the pivotal point where the world was liberated from demonic oppression.
            In these three names, the entire philosophy of the epic—devotion, power, and liberation—is contained.
            Valmiki gave the poem a structure that teaches something new to every reader in every era.
            This verse clarifies the formal naming of the scripture and the vastness of its central themes.
            The entire world still reveres this work today for these majestic titles and the profound emotions they evoke.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 8,
        sanskrit = "पाठ्ये गेये च मधुरं प्रमाणैस्त्रिभिरन्वितम् ।\nजातिभिः सप्तभिर्बद्धं तन्त्रीलयसमन्वितम् ॥ ८ ॥",
        hindiCommentary = """
            यह काव्य पढ़ने (पाठ्ये) और गाने (गेये) में अत्यंत मधुर है और तीन प्रमाणों से युक्त है।
            यह सात जातियों (रागों) में बंधा हुआ है और वीणा की लय (तन्त्रीलय) के साथ पूरी तरह तालबद्ध है।
            तीन प्रमाण (द्रुत, मध्य, विलम्बित) संगीत की उन गतियों को दर्शाते हैं जो गान को प्रभावशाली बनाती हैं।
            सात जातियों का प्रयोग यह सिद्ध करता है कि वाल्मीकि जी संगीत शास्त्र के भी प्रकाण्ड पंडित थे।
            जब कुश और लव इसे गाते थे, तो सुनने वाले को ऐसा लगता था जैसे साक्षात् गंधर्व गान कर रहे हों।
            राग और ताल का यह मेल पाठक और श्रोता के मन को सीधा ईश्वर से जोड़ देता था।
            काव्य की मधुरता शब्दों के अलंकार और भावों की शुद्धता—दोनों से मिलकर बनी थी।
            तन्त्रीलय समन्वित होने का अर्थ है कि इसे वाद्य यंत्रों के साथ भी पूर्णता से प्रस्तुत किया जा सकता है।
            यह श्लोक रामायण के 'संगीतात्मक' (Musical) पक्ष की तकनीकी श्रेष्ठता का वर्णन करता है।
            वाल्मीकि ने एक ऐसी रचना दी जो कान को प्रिय, बुद्धि को प्रखर और आत्मा को शांत करती है।
            संगीत के माध्यम से धर्म का प्रचार करना भारतीय संस्कृति की एक अत्यंत प्राचीन और प्रभावशाली पद्धति है।
        """.trimIndent(),
        englishCommentary = """
            This epic is extremely sweet both for recitation (Pathye) and for singing (Geye), endowed with three scales.
            It is composed in seven musical notes (Jatis) and is perfectly synchronized with the rhythm of the lute.
            The three scales (Druta, Madhya, Vilambita) refer to the tempos that make the singing profoundly effective.
            The use of seven Jatis proves that Valmiki was also a profound scholar of the science of music.
            When Kusha and Lava sang it, the listeners felt as if the celestial Gandharvas themselves were performing.
            This fusion of melody and rhythm connected the hearts of the audience directly with the Divine.
            The sweetness of the poetry was derived from both the linguistic ornaments and the purity of sentiment.
            Being 'Tantrilaya-samanvitam' implies it can be perfectly performed alongside stringed instruments.
            This verse describes the technical excellence of the 'Musical' aspect of the Ramayana.
            Valmiki provided a creation that is pleasing to the ear, sharpens the intellect, and pacifies the soul.
            Propagating Dharma through the medium of music is an ancient and powerful method of Indian culture.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 9,
        sanskrit = "रसैः शृङ्गारकरुणहास्यरौद्रभयानकैः ।\nवीरादिभी रसैर्युक्तं काव्यमेतदगायताम् ॥ ९ ॥",
        hindiCommentary = """
            यह काव्य शृङ्गार, करुण, हास्य, रौद्र, भयानक और वीर आदि सभी नौ रसों से परिपूर्ण है।
            कुश और लव ने इन सभी रसों के भावों को अपने कंठ के माध्यम से अत्यंत जीवंत रूप में प्रस्तुत किया।
            शृङ्गार में राम-सीता का प्रेम, करुण में उनका विरह और वीर रस में युद्ध का अद्भुत वर्णन है।
            हास्य और रौद्र रस मानवीय भावनाओं के उन पहलुओं को छूते हैं जो कथा को संतुलित बनाते हैं।
            भयानक रस राक्षसों के आतंक को और उनके विनाश के भय को प्रभावशाली ढंग से दर्शाता है।
            वाल्मीकि जी ने इन रसों का ऐसा मिश्रण किया कि पाठक हर पल एक नई मानसिक अवस्था का अनुभव करता है।
            कुश और लव का गान केवल सुरों का मेल नहीं था, बल्कि रसों का साक्षात् प्रकटीकरण था।
            जिस रस की कथा होती थी, उनके मुखमण्डल पर वही भाव साक्षात् उभर कर आ जाता था।
            यह श्लोक रामायण की 'भावनात्मक' (Emotional) विविधता और उसके मनोवैज्ञानिक विस्तार को दिखाता है।
            कोई भी काव्य तब तक अमर नहीं होता जब तक वह मानवीय संवेदनाओं के हर रंग को न समेट ले।
            रामायण का प्रत्येक रस श्रोता के भीतर एक गहरा आध्यात्मिक और नैतिक परिवर्तन लेकर आता है।
        """.trimIndent(),
        englishCommentary = """
            This epic is saturated with all the aesthetic sentiments—Shringara, Karuna, Hasya, Raudra, Bhayanaka, and Vira.
            Kusha and Lava presented the essence of all these 'Rasas' (emotions) vividly through their powerful singing.
            'Shringara' captures the love of Rama and Sita, 'Karuna' their separation, and 'Vira' their heroic exploits.
            'Hasya' (humor) and 'Raudra' (fury) touch upon human aspects that make the narrative balanced and real.
            'Bhayanaka' (terror) effectively portrays the demonic oppression and the dread of their eventual end.
            Valmiki mixed these sentiments such that the reader experiences a new mental state at every turn.
            The singing of Kusha and Lava was not just a sequence of notes but a direct manifestation of these emotions.
            Whatever 'Rasa' was being narrated, the corresponding expression appeared vividly upon their young faces.
            This verse illustrates the 'Emotional' diversity and the psychological depth of the Ramayana.
            No poetry becomes immortal unless it captures every shade and nuance of human sensitivity and experience.
            Every 'Rasa' in the Ramayana brings about a profound spiritual and ethical transformation within the listener.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 10,
        sanskrit = "तौ तु गान्धर्वतत्त्वज्ञौ स्थानमूर्च्छनकोविदौ ।\nभ्रातरौ स्वरसम्पन्नौ गन्धर्वा इव रूपिणौ ॥ १० ॥",
        hindiCommentary = """
            वे दोनों भाई संगीत के रहस्यों (गान्धर्वतत्त्वज्ञौ) के ज्ञाता थे और स्वर व मूर्च्छना में अत्यंत निपुण थे।
            वे दिखने में साक्षात् रूपवान गन्धर्वों के समान थे और उनका स्वर अत्यंत दिव्य व प्रभावशाली था।
            मूर्च्छना का ज्ञान संगीत की उन सूक्ष्मताओं को दर्शाता है जो केवल उच्च कोटि के कलाकार जानते हैं।
            उनका रूप और उनका गुण—दोनों ही राम की छवि का प्रतिबिंब थे, जो सबको अपनी ओर आकर्षित करते थे।
            वानर और ऋषियों के बीच रहते हुए भी उन्होंने इस कला को अपने भीतर पूरी तरह आत्मसात कर लिया था।
            गन्धर्वों जैसी उपमा उनकी अलौकिक प्रतिभा और उनके स्वर्गीय गायन शैली की ओर संकेत करती है।
            भाई होने के नाते उनके स्वरों का मिलन (Harmony) इतना सटीक था कि वह एक ही आत्मा की दो आवाज़ें लगती थीं।
            वाल्मीकि जी ने उन्हें संगीत की बारीकियों के साथ-साथ कथा की पवित्रता का भी बोध कराया था।
            जब वे गान शुरू करते थे, तो वन के पशु और पक्षी भी अपनी सुध-बुध खोकर उन्हें सुनने लगते थे।
            यह श्लोक कुश और लव के व्यक्तित्व के उस 'सौंदर्य' और 'कलात्मक' पक्ष को उजागर करता है जो अद्वितीय है।
            उनकी निपुणता ने सिद्ध कर दिया कि वे केवल छात्र नहीं, बल्कि संगीत के साक्षात् आचार्य बन चुके थे।
        """.trimIndent(),
        englishCommentary = """
            The two brothers were masters of the secrets of music (Gandharvatattvajñau) and experts in scales and modulations.
            They appeared like incarnate Gandharvas and were endowed with voices that were both divine and magnetic.
            Mastery over 'Murchana' indicates a profound knowledge of the subtleties known only to elite musicians.
            Both their physical form and their talent were reflections of Rama, drawing everyone toward them effortlessly.
            Even while living among monkeys and ascetics, they had fully internalized this sophisticated art within themselves.
            The comparison to Gandharvas points toward their supernatural talent and their celestial style of singing.
            As brothers, the harmony of their voices was so precise that they seemed like two voices emerging from one soul.
            Valmiki had educated them in the technicalities of music along with the sanctity of the narrative itself.
            When they began their performance, even the animals and birds of the forest would listen, enchanted and still.
            This verse highlights the 'Aesthetic' and 'Artistic' dimensions of Kusha and Lava’s peerless personalities.
            Their proficiency proved that they were not merely students but had become living masters of the musical science.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 11,
        sanskrit = "रूपलक्षणसम्पन्नौ सुस्वरौ च कुशीलवौ ।\nबिम्बादिवोत्थितौ बिम्बौ रामदेहात् तथापरौ ॥ ११ ॥",
        hindiCommentary = """
            कुश और लव सुंदर रूप और शुभ लक्षणों से संपन्न थे और उनकी आवाज़ अत्यंत सुरीली (सुस्वरौ) थी।
            वे श्री राम के शरीर से निकले हुए दो बिम्बों (प्रतिबिम्बों) के समान साक्षात् राम के ही दूसरे रूप लग रहे थे।
            'बिम्बादिवोत्थितौ' उपमा यह स्पष्ट करती है कि उनकी शारीरिक बनावट और तेज बिल्कुल राम जैसा ही था।
            देखने वाले को यह भ्रम हो जाता था कि कहीं साक्षात् राम ही बचपन के रूप में फिर से तो नहीं आ गए?
            उनके शुभ लक्षण उनके उच्च कुल और उनके महान भविष्य की ओर संकेत कर रहे थे।
            आवाज़ की सुरीली गूँज उनके आंतरिक चरित्र की शुद्धता और उनकी साधना का परिणाम थी।
            राम के देह से तुलना उनकी पितृ-परंपरा और उनके रक्त के संबंध को भी मूक रूप से सिद्ध करती है।
            वे दोनों केवल गायक नहीं थे, बल्कि राम की मर्यादा के जीवित और चलते-फिरते प्रतीक बन गए थे।
            मुनि वाल्मीकि ने उन्हें इस तरह तराशा था कि वे राम-कथा के साथ राम की छवि को भी दुनिया तक पहुँचा सकें।
            यह श्लोक पाठक के मन में उन दोनों बालकों की एक अत्यंत भव्य और अलौकिक छवि अंकित कर देता है।
            उनकी उपस्थिति मात्र से ही वातावरण में एक राजसी और पवित्र ऊर्जा का संचार होने लगता था।
        """.trimIndent(),
        englishCommentary = """
            Kusha and Lava were endowed with handsome forms and auspicious marks, possessing voices of great melody.
            They appeared like two reflections (Bimbas) emerged from the body of Rama, looking like His own replicas.
            The metaphor 'Bimbadivotthitau' clarifies that their physical structure and radiance were identical to Rama’s.
            Observers were often deluded into thinking that Rama Himself had reappeared in His childhood form.
            Their auspicious marks pointed toward their noble lineage and their destined, magnificent future.
            The melodic resonance of their voices was a result of their internal purity and dedicated practice.
            The comparison to Rama’s body also silently confirms their paternal heritage and blood connection to Him.
            The two were not just singers; they became living, breathing symbols of Rama’s code of conduct (Maryada).
            Sage Valmiki had polished them such that they carried Rama’s image along with His story to the world.
            This verse etches a magnificent and supernatural image of the two boys in the mind of the reader.
            Their mere presence infused the environment with a regal and holy energy that was unmistakable.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 12,
        sanskrit = "कौमारौ तु द्विजैर्दिष्टौ तौ दृष्ट्वा समलङ्कृतौ ।\nअगायेतां तदा तत्र रामायणमनिन्दितम् ॥ १२ ॥",
        hindiCommentary = """
            उन दोनों कुमारों ने ऋषियों (द्विजैः) द्वारा निर्देशित किए जाने पर रामायण का पावन गान आरंभ किया।
            वे अपनी स्वाभाविक सुंदरता और गुणों से सुसज्जित (समलङ्कृतौ) थे और उनका गान 'अनिन्दित' (दोषरहित) था।
            अनिन्दित गान का अर्थ है—स्वर, ताल और भाव में कहीं भी कोई छोटी सी भी त्रुटि नहीं थी।
            ऋषियों की सभा में गान करना एक बहुत बड़ी परीक्षा थी, जिसे उन्होंने अपनी योग्यता से सफल बनाया।
            द्विज (ब्राह्मण/ऋषि) उनके गान को सुनकर मंत्रमुग्ध थे और उन्हें अपना आशीर्वाद दे रहे थे।
            यहाँ 'कौमारौ' शब्द उनकी कोमल आयु और उनकी महान परिपक्वता के बीच के अद्भुत संतुलन को दिखाता है।
            उनका गान सुनकर ऐसा लगता था जैसे साक्षात् सरस्वती उनके कंठ में बैठकर कथा कह रही हों।
            मुनि वाल्मीकि के आश्रम का वह वातावरण अब राम-कथा की मधुर ध्वनियों से पूरी तरह गूँज उठा था।
            वे दोनों बालक इस बात से अनभिज्ञ थे कि वे जिस पिता की कथा गा रहे हैं, वे उन्हीं के पुत्र हैं।
            यह श्लोक रामायण के प्रथम 'सार्वजनिक प्रदर्शन' (Public Performance) की पवित्र शुरुआत का वर्णन है।
            ऋषियों का निर्देश यह सिद्ध करता है कि यह गान केवल मनोरंजन नहीं, बल्कि एक आध्यात्मिक अनुष्ठान था।
        """.trimIndent(),
        englishCommentary = """
            Directed by the sages (Dvijaih), the two young princes commenced the sacred singing of the Ramayana.
            They were adorned (Samalankritau) by their natural beauty and virtues, and their singing was 'Aninditam' (faultless).
            'Anindita' singing implies that there was not even a minute error in melody, rhythm, or emotional expression.
            Performing in an assembly of sages was a massive test, which they successfully cleared with their merit.
            The sages (Dvijas) were spellbound by their singing and bestowed upon them their heartiest blessings.
            The word 'Kaumarau' highlights the marvelous balance between their tender age and their immense maturity.
            Listening to them, it felt as if Goddess Saraswati herself was narrating the tale through their throats.
            The atmosphere of Valmiki’s ashram was now fully resonating with the sweet sounds of Rama's story.
            The two boys were unaware that they were singing the story of the very father to whom they belonged.
            This verse describes the holy beginning of the first 'Public Performance' of the monumental Ramayana.
            The direction of the sages proves that this singing was not mere entertainment but a spiritual ritual.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 13,
        sanskrit = "तौ तु संसदि संसक्ताः शुश्रावाभ्यागतान्मुनीन् ।\nवीणावादनतत्त्वज्ञौ स्वरस्थानविशारदौ ॥ १३ ॥",
        hindiCommentary = """
            वे दोनों वीणा वादन के रहस्यों (तत्त्वज्ञौ) और स्वरों के स्थानों (Pitch) में पूर्णतः निपुण थे।
            आश्रम में आए हुए सभी मुनियों ने बड़ी एकाग्रता के साथ उन दोनों का यह दिव्य गान सुना।
            'संसदि संसक्ताः' का अर्थ है कि सभा में बैठे हुए लोग पूरी तरह से उस गान में लीन और मुग्ध हो गए थे।
            स्वरों के स्थान (स्वरस्थान) का ज्ञान यह बताता है कि उनका शास्त्रीय संगीत का आधार अत्यंत मजबूत था।
            मुनिगण जो स्वयं वेदों के ज्ञाता थे, इन बालकों की संगीत कुशलता को देखकर आश्चर्यचकित रह गए।
            वीणा की झंकार और उनकी आवाज़ का मेल हृदय के गहरे तारों को झंकृत कर देने वाला था।
            वाल्मीकि जी ने उन्हें एक ऐसी कला दी थी जो सत्य को सीधे आत्मा तक पहुँचाने का सामर्थ्य रखती थी।
            पूरा वातावरण एक ऐसे ध्यान (Meditation) में बदल गया था जहाँ केवल राम का चरित्र ही शेष था।
            मुनियों का सुनना यह सिद्ध करता है कि ज्ञान जब कला के साथ मिलता है, तो वह और भी अधिक पूजनीय हो जाता है।
            कुश और लव ने सिद्ध किया कि वे केवल अच्छे गायक ही नहीं, बल्कि संगीत के सूक्ष्म ज्ञाता भी हैं।
            यह श्लोक श्रोताओं की तन्मयता और गायकों की तकनीकी श्रेष्ठता का एक बहुत ही सुंदर वर्णन है।
        """.trimIndent(),
        englishCommentary = """
            The two were thoroughly skilled in the secrets of playing the lute (Tattvajñau) and experts in vocal pitches.
            All the sages who had arrived at the hermitage listened to their divine singing with absolute focus.
            'Samsadi Samsaktah' implies that everyone in the assembly was completely absorbed and enchanted by the performance.
            Knowledge of vocal pitches (Svarasthana) indicates that their foundation in classical music was incredibly strong.
            The seers, who were themselves scholars of the Vedas, were astonished by the musical prowess of these boys.
            The resonance of the lute combined with their voices was capable of vibrating the deepest chords of the heart.
            Valmiki had gifted them an art that possessed the power to transmit Truth directly into the soul.
            The entire environment transformed into a state of meditation where only Rama’s character existed.
            The sages listening proves that when wisdom merges with art, it becomes even more venerable and potent.
            Kusha and Lava demonstrated that they were not just good singers but subtle scholars of musical science.
            This verse is a beautiful account of the audience's absorption and the performers' technical superiority.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 14,
        sanskrit = "तयोस्तद्गायतोः सर्वं सान्द्रं हर्षमवाप्नुवन् ।\nमुनयः साधु साध्विति तत्रैवाब्रुवन्मुदा ॥ १४ ॥",
        hindiCommentary = """
            उन दोनों का गान सुनकर सभी उपस्थित लोग अत्यंत गहरे और घनीभूत हर्ष (सान्द्रं हर्षम्) को प्राप्त हुए।
            वहाँ उपस्थित मुनिगण प्रसन्न होकर बार-बार "साधु! साधु!" (बहुत सुंदर! श्रेष्ठ!) कहने लगे।
            'सान्द्रं' शब्द यह बताता है कि वह आनंद इतना गहरा था कि उसे शब्दों में व्यक्त करना कठिन था।
            मुनियों की यह 'मुदा' (प्रसन्नता) उनके हृदय की तृप्ति का साक्षात् प्रमाण थी।
            "साधु! साधु!" कहना प्राचीन काल में किसी श्रेष्ठ कार्य के प्रति दी जाने वाली सर्वोच्च प्रशंसा थी।
            राम-कथा की मिठास और उन बालकों की मासूमियत ने सबके मन को पूरी तरह मोह लिया था।
            वाल्मीकि जी दूर खड़े होकर अपने शिष्यों की इस सफलता को देख रहे थे और अत्यंत गौरव महसूस कर रहे थे।
            यह दृश्य सिद्ध करता है कि जब सत्य को भक्ति और कला के साथ प्रस्तुत किया जाता है, तो वह सबको जीत लेता है।
            मुनियों के चेहरे पर छाई वह मुस्कान यह बता रही थी कि उन्हें अब अपना आदर्श मिल चुका है।
            यह गान केवल कानों के लिए सुखद नहीं था, बल्कि वह अंतरात्मा को झकझोरने वाला और पवित्र करने वाला था।
            यह श्लोक रामायण के प्रथम गान की उस अभूतपूर्व सफलता और सार्वजनिक स्वीकृति का वर्णन करता है।
        """.trimIndent(),
        englishCommentary = """
            Listening to the two sing, everyone present experienced a dense and intense joy (Sandram Harsham).
            The assembled sages, filled with delight, repeatedly exclaimed "Sadhu! Sadhu!" (Excellent! Well done!).
            The word 'Sandram' indicates that the bliss was so thick and profound that it was difficult to put into words.
            The 'Muda' (happiness) of the sages was a direct testimony to the satisfaction of their very souls.
            Exclaiming "Sadhu! Sadhu!" was the highest form of appreciation for a superior feat in ancient times.
            The sweetness of Rama’s story and the innocence of the boys completely captivated every mind present.
            Sage Valmiki stood at a distance, watching the success of His disciples and feeling a sense of immense pride.
            This scene proves that when Truth is presented with devotion and art, it conquers every heart effortlessly.
            The smiles upon the faces of the seers suggested that they had finally found their moral and spiritual ideal.
            The singing was not just pleasing to the ears but was soul-stirring and profoundly purifying for all.
            This verse describes the unprecedented success and the public validation of the first singing of the Ramayana.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 15,
        sanskrit = "प्रीताः प्रहृष्टा मुनयः धर्मज्ञास्ते महर्षयः ।\nप्रशंसन्ति च तौ वीराव् अगायतां महाबलाव् ॥ १५ ॥",
        hindiCommentary = """
            धर्म के ज्ञाता वे सभी महर्षि अत्यंत प्रसन्न (प्रीताः) और हर्षित (प्रहृष्टा) होकर उन दोनों की प्रशंसा करने लगे।
            उन्होंने उन दोनों 'वीरों' और 'महाबली' बालकों के गान की मुक्त कंठ से सराहना की।
            यहाँ 'वीर' और 'महाबल' विशेषण यह संकेत देते हैं कि उनका गान केवल कोमल नहीं, बल्कि ओजस्वी और शक्तिशाली भी था।
            एक महान मुनि द्वारा प्रशंसा मिलना किसी भी शिष्य के लिए उसके जीवन की सबसे बड़ी सिद्धि होती है।
            महर्षियों ने अनुभव किया कि इन बालकों ने राम के पराक्रम को शब्दों में पूरी तरह जीवंत कर दिया है।
            प्रसन्नता का वह माहौल यह बताता है कि राम-कथा ने सबको एक दिव्य एकता के सूत्र में बांध दिया था।
            वे दोनों बालक अपनी प्रशंसा सुनकर और भी अधिक विनम्र भाव से अपने गुरु की ओर देख रहे थे।
            यह प्रशंसा केवल उनकी कला की नहीं, बल्कि उनके द्वारा प्रस्तुत किए गए सत्य की भी थी।
            मुनिगण देख रहे थे कि कैसे इन छोटे बालकों ने महाकाव्य के कठिन छंदों को सहजता से आत्मसात किया है।
            यह श्लोक रामायण के गायकों के प्रति समाज के श्रेष्ठतम वर्ग के उस सम्मान और आदर को दर्शाता है।
            उनकी वीरता उनके संगीत में झलक रही थी, जो अधर्म के विरुद्ध एक गूँज जैसी प्रतीत होती थी।
        """.trimIndent(),
        englishCommentary = """
            The great seers, experts in Dharma, became exceedingly pleased (Pritah) and delighted (Prahrishtah), praising them.
            They lauded the singing of those two 'heroic' and 'mighty-souled' boys with open hearts and profound respect.
            The epithets 'Vira' and 'Mahabala' suggest that their singing was not just gentle but vigorous and powerful.
            To be praised by eminent sages is the greatest possible achievement and validation for any disciple.
            The maharishis felt that these boys had made Rama’s prowess come completely alive through their words.
            The joyful atmosphere indicated that the story of Rama had unified everyone in a single, divine thread.
            Hearing the praise, the two boys looked toward their Guru with even greater humility and reverence.
            The appreciation was not just for their art but for the absolute Truth they were so effectively presenting.
            The sages observed how these young boys had effortlessly internalized the difficult meters of the epic.
            This verse depicts the immense respect and honor shown by the highest class of society toward the bards.
            Their heroism was audible in their music, which sounded like a resonant echo against all unrighteousness.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 16,
        sanskrit = "अहो गीतस्य माधुर्यं श्लोकानां च विशेषतः ।\nचरितं तदिदं कृत्स्नं रामस्य प्रतिबोधितम् ॥ १६ ॥",
        hindiCommentary = """
            मुनिगण विस्मित होकर बोले—"अहो! इस गीत का माधुर्य और इन श्लोकों की रचना कितनी विशेष और अद्भुत है!"
            "इसमें श्री राम का संपूर्ण (कृत्स्नं) चरित्र कितनी स्पष्टता और गहराई के साथ समझाया (प्रतिबोधितम्) गया है।"
            'अहो' शब्द उनके उस विस्मय और आश्चर्य को व्यक्त करता है जिसे वे दबा नहीं पा रहे थे।
            गीत की मिठास और श्लोकों की शास्त्रीय शुद्धता ने उन्हें एक नया साहित्यिक अनुभव प्रदान किया था।
            वे देख रहे थे कि कैसे एक-एक घटना को इतनी बारीकी से पिरोया गया है कि कुछ भी शेष नहीं रहा।
            'प्रतिबोधितम्' का अर्थ है—ज्ञान का ऐसा उदय होना जिससे अज्ञान का अंधकार पूरी तरह मिट जाए।
            राम का जीवन अब उनके लिए केवल एक पुरानी याद नहीं, बल्कि एक वर्तमान और जीवंत सत्य बन चुका था।
            वाल्मीकि की इस मौलिक रचना ने संस्कृत साहित्य में एक नया और अनूठा मानदंड स्थापित कर दिया था।
            मुनियों ने महसूस किया कि यह काव्य आने वाले अनंत काल तक मनुष्यों का मार्गदर्शन करने में सक्षम है।
            यह श्लोक रामायण की 'विषय-वस्तु' (Content) और उसकी 'शैली' (Style) की श्रेष्ठता की सामूहिक स्वीकृति है।
            राम के चरित्र की संपूर्णता ने उन्हें यह विश्वास दिलाया कि यही वह ग्रंथ है जिसकी संसार को प्रतीक्षा थी।
        """.trimIndent(),
        englishCommentary = """
            The sages exclaimed in wonder: "Aho! The sweetness of this song and the composition of these verses are extraordinary!"
            "In this, the entire (Kritsnam) life-story of Sri Rama has been explained (Pratibodhitam) with such clarity and depth."
            The exclamation 'Aho' reflects their irrepressible awe and profound amazement at the performance.
            The sweetness of the melody and the classical purity of the verses provided them with a novel literary experience.
            They observed how every single event was woven so meticulously that nothing was left incomplete or vague.
            'Pratibodhitam' implies an awakening of knowledge that completely dispels the darkness of ignorance.
            Rama's life was no longer just an old memory for them but had become a present and vibrant reality.
            This original work of Valmiki had set a new and unique standard in the annals of Sanskrit literature.
            The sages realized that this poetry was capable of guiding humanity for an infinite time to come.
            This verse is the collective validation of the 'Content' and 'Style' of the Ramayana by the scholarly elite.
            The completeness of Rama’s character in the epic convinced them that this was the text the world awaited.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 17,
        sanskrit = "तौ तु संश्राव्य तत्रैव ततः प्रस्थितौ ।\nअगायेतां च राजमार्गेषु ऋषिवाटेषु च ॥ १७ ॥",
        hindiCommentary = """
            वहाँ ऋषियों को सुनाने के बाद, वे दोनों बालक (कुश और लव) आगे की यात्रा के लिए प्रस्थान कर गए।
            उन्होंने अयोध्या के राजमार्गों (राजमार्गेषु) और ऋषियों के आश्रमों व वाटिकाओं (ऋषिवाटेषु) में भी गान किया।
            उनका गान अब केवल आश्रम तक सीमित नहीं रहा, बल्कि वह पूरे समाज के बीच पहुँचने लगा था।
            राजमार्गों पर गान करना यह दर्शाता है कि यह कथा सामान्य जनता के लिए भी उतनी ही सुलभ और प्रिय थी।
            ऋषिवाटिकाओं में गान करने से विद्वान समाज में इस महाकाव्य की प्रतिष्ठा और अधिक बढ़ गई।
            वे जहाँ भी जाते, लोग अपना सारा काम छोड़कर उनके चारों ओर एकत्र हो जाते थे।
            उन बालकों की सरलता और उनके गायन का प्रभाव ऐसा था कि वह हर हृदय को पवित्र कर देता था।
            वाल्मीकि जी ने उन्हें आदेश दिया था कि वे बिना किसी लोभ के इस कथा का चारों ओर प्रचार करें।
            अयोध्या की सड़कों पर पहली बार राम के गुणों की ऐसी गूँज सुनाई दे रही थी जो पहले कभी नहीं सुनी गई।
            यह श्लोक रामायण के 'वैश्विक प्रसार' (Global Propagation) की एक बहुत ही सक्रिय और सुंदर शुरुआत है।
            कुश और लव अब साक्षात् 'धर्म-दूत' बनकर समाज के हर वर्ग तक राम का संदेश पहुँचा रहे थे।
        """.trimIndent(),
        englishCommentary = """
            After reciting before the sages there, the two boys (Kusha and Lava) set out on their further journey.
            They sang on the highways of Ayodhya (Rajamargeshu) and in the dwellings and groves of seers (Rishivateshu).
            Their singing was no longer confined to the ashram; it began to reach the very heart of the wider society.
            Singing on the highways indicates that this narrative was equally accessible and beloved by the common people.
            Reciting in the groves of the rishis further enhanced the prestige of this epic among the scholarly class.
            Wherever they went, people would abandon their work and gather in large numbers to listen to them.
            The simplicity of the boys and the impact of their singing were such that they purified every heart.
            Sage Valmiki had instructed them to propagate this story far and wide without any greed or selfishness.
            For the first time, the streets of Ayodhya resonated with a glorification of Rama that had never been heard before.
            This verse depicts the very active and beautiful commencement of the 'Global Propagation' of the Ramayana.
            Kusha and Lava were now acting as incarnate 'Messengers of Dharma,' taking Rama’s message to every social class.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 18,
        sanskrit = "तं दृष्ट्वा स च रामोऽपि गानं तत्र समाश्रितः ।\nअहूतं च ततः सर्वं विरराम च राघवः ॥ १८ ॥",
        hindiCommentary = """
            स्वयं श्री राम ने भी उन दोनों के गान को सुना और वे उसकी मधुरता के पूरी तरह वश में (समाश्रितः) हो गए।
            राम ने उन्हें अपने दरबार में आमंत्रित किया (अहूतं) और स्वयं राघव (राम) ने अपना सारा कार्य रोक दिया (विरराम)।
            यह दृश्य अत्यंत अद्भुत था—जिस नायक की कथा गाई जा रही थी, वह स्वयं उसका श्रोता बन गया था।
            राम ने देखा कि वे दोनों बालक कोई साधारण गायक नहीं हैं, बल्कि उनमें एक दैवीय तेज छिपा हुआ है।
            राजकीय कार्यों को रोक देना यह सिद्ध करता है कि राम के लिए यह कथा किसी भी अन्य कर्तव्य से अधिक महत्वपूर्ण थी।
            राम का हृदय उन बालकों को देखकर अनायास ही वात्सल्य और प्रेम से भर गया था।
            उन्होंने अपने भाइयों और मंत्रियों को भी साथ बिठाया ताकि वे इस अलौकिक गान का रसास्वादन कर सकें।
            भगवान राम यह नहीं जानते थे कि वे अपनी ही जीवन-गाथा अपने ही पुत्रों के मुख से सुनने जा रहे हैं।
            'विरराम' शब्द राम के उस 'आत्म-विश्राम' को दर्शाता है जो उन्हें अपने ही गुणों के गान को सुनकर प्राप्त हुआ।
            यह श्लोक कथा के 'नायक' और 'गायकों' के बीच होने वाले उस ऐतिहासिक मिलन की प्रारंभिक भूमिका है।
            अयोध्या का राजदरबार अब एक पवित्र मंदिर में बदल गया था जहाँ भक्ति की अविरल धारा बहने वाली थी।
        """.trimIndent(),
        englishCommentary = """
            Sri Rama Himself also heard their singing and became completely captivated (Samashritah) by its sweetness.
            Rama summoned them (Ahutam) to His court, and Raghava (Rama) Himself suspended (Virarama) all His official work.
            The scene was extraordinary—the very Hero whose story was being sung had now become the audience of His own tale.
            Rama perceived that the two boys were no ordinary singers but possessed a hidden, divine radiance.
            Suspending His royal duties proves that for Rama, this narrative was more significant than any other administrative task.
            Rama’s heart was spontaneously filled with paternal affection and love upon beholding the young boys.
            He seated His brothers and ministers alongside Him to relish the experience of this supernatural singing.
            Lord Rama was unaware that He was about to hear His own life-story from the lips of His very own sons.
            The word 'Virarama' signifies the deep 'Self-rest' Rama attained by listening to the glorification of His own virtues.
            This verse acts as the introductory prelude to the historic meeting between the 'Hero' and the 'Singers.'
            The royal court of Ayodhya transformed into a sacred temple where an unceasing stream of devotion was to flow.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 19,
        sanskrit = "स च तत्र सभां सर्वां सुमहतीं तदा ।\nअगायतां च तौ तत्र रामस्याग्रतो नृप ॥ १९ ॥",
        hindiCommentary = """
            हे नृप! उन दोनों ने राजा राम के सामने उस अत्यंत विशाल और भव्य सभा (सुमहतीं सभां) में गान किया।
            वह सभा अयोध्या के श्रेष्ठ नागरिकों, ऋषियों और वीरों से खचाखच भरी हुई थी।
            'रामस्याग्रतो' (राम के सामने) गान करना उनके जीवन का सबसे बड़ा और गौरवशाली क्षण था।
            उनकी आवाज़ में वह आत्मविश्वास था जो केवल सत्य और ब्रह्मचर्य की शक्ति से ही प्राप्त हो सकता है।
            राम ने बड़ी उत्सुकता और आदर के साथ उन बालकों को ऊंचे आसन पर बिठाया और सुनने को तैयार हुए।
            पूरी सभा में सन्नाटा छा गया था, क्योंकि हर कोई उस दिव्य गान की पहली ध्वनि की प्रतीक्षा कर रहा था।
            कुश और लव ने अपनी वीणा के तारों को छेड़ा और राम के जन्म की कथा से अपना गायन प्रारंभ किया।
            यह क्षण काल के चक्र में एक ऐसा बिंदु था जहाँ अतीत और वर्तमान एक-दूसरे के आमने-सामने खड़े थे।
            वाल्मीकि जी की तपस्या अब राम के दरबार में साक्षात् संगीत के रूप में फलित हो रही थी।
            यह श्लोक उस महान आयोजन की गरिमा और उसके 'सार्वजनिक' स्वरूप का साक्षात् चित्रण करता है।
            राजा और प्रजा के बीच की दूरी समाप्त हो गई थी, क्योंकि राम-कथा ने सबको एक समान धरातल पर ला दिया था।
        """.trimIndent(),
        englishCommentary = """
            O King! The two boys sang in that immensely vast and majestic assembly (Sumahatim Sabham) before King Rama.
            That assembly was packed with the elite citizens of Ayodhya, eminent sages, and heroic warriors.
            Singing 'Ramasyagrato' (before Rama) was the greatest and most glorious moment of their young lives.
            Their voices carried a confidence that could only be attained through the power of Truth and celibacy.
            Rama, with great curiosity and respect, seated the boys on a high pedestal and prepared to listen.
            A profound silence descended upon the entire hall as everyone awaited the first note of that divine singing.
            Kusha and Lava struck the strings of their lutes and commenced their recitation starting from Rama’s birth.
            This moment was a point in the wheel of time where the past and the present stood face-to-face.
            Valmiki’s long penance was now blossoming in Rama’s court as direct, transcendental music.
            This verse vividly depicts the dignity of that grand event and its 'public' and inclusive nature.
            The distance between the King and His subjects vanished as the story of Rama brought everyone to a shared plane.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 20,
        sanskrit = "तयोस्तु तद्गायनं सान्द्रं हर्षमवाप्नुवन् ।\nरामस्य च सभां तत्र मुनयः साधु साध्विति ॥ २० ॥",
        hindiCommentary = """
            राम की उस सभा में उपस्थित सभी मुनिगण उनके गान को सुनकर अत्यंत गहरे हर्ष (सान्द्रं हर्षम्) में डूब गए।
            वे सभी मुनि फिर से प्रसन्न होकर "साधु! साधु!" (बहुत सुंदर! धन्य!) की ध्वनि से सभा को गुंजायमान करने लगे।
            राम स्वयं भी उस गान के प्रभाव से चकित थे, क्योंकि उन्होंने अपने चरित्र का ऐसा वर्णन पहले कभी नहीं सुना था।
            मुनियों का बार-बार "साधु" कहना यह सिद्ध करता था कि गान में रत्ती भर भी कोई शास्त्रीय या नैतिक दोष नहीं था।
            वह आनंद 'सान्द्र' था, जिसका अर्थ है कि वह अत्यंत सघन और हृदय को पूरी तरह से भर देने वाला था।
            राम के दरबार में ऋषियों की यह प्रतिक्रिया उन बालकों के लिए सबसे बड़ा प्रमाणपत्र (Certificate) थी।
            सबको ऐसा महसूस हो रहा था जैसे वे अयोध्या में नहीं, बल्कि सीधे वैकुण्ठ या स्वर्ग के किसी उत्सव में हों।
            मुनि देख रहे थे कि कैसे इन बालकों ने राम के एक-एक गुण को स्वर के साथ साक्षात् कर दिया है।
            यह दृश्य सिद्ध करता है कि कला जब ईश्वर के चरणों में समर्पित होती है, तो वह सर्वोच्च वंदनीय बन जाती है।
            यह श्लोक दरबार में उस गान की सफलता और श्रोताओं की भावुक प्रतिक्रिया का अत्यंत सजीव वर्णन है।
            राम की सभा का प्रत्येक सदस्य उस पल केवल एक भक्त और एक प्रेमी श्रोता बन चुका था।
        """.trimIndent(),
        englishCommentary = """
            In Rama's assembly, all the sages who heard their singing were submerged in a deep and intense joy (Sandram Harsham).
            Those sages, filled with delight, once again made the hall resonate with the sounds of "Sadhu! Sadhu!" (Excellent!).
            Rama Himself was astonished by the impact of the singing, for He had never heard His own story narrated so.
            The repeated exclamations of the sages proved that the performance was devoid of any technical or moral flaw.
            The joy was 'Sandra,' meaning it was concentrated and capable of completely saturating the heart.
            This reaction of the seers in Rama’s court was the ultimate validation and certificate for the young bards.
            Everyone felt as if they were not in Ayodhya but were attending a divine festival in Vaikuntha or Heaven.
            The sages observed how these boys had made every attribute of Rama manifest through their melodic voices.
            This scene proves that when art is surrendered at the feet of God, it becomes worthiest of supreme worship.
            This verse provides a very vivid account of the singing's success in the court and the audience's emotional response.
            Every member of Rama's assembly had, at that moment, become merely a devotee and a loving listener.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 21,
        sanskrit = "श्रुत्वा तदेतद्गायनं सान्द्रं हर्षमवाप्नुवन् ।\nरामस्य च सभां तत्र मुनयः साधु साध्विति ॥ २१ ॥",
        hindiCommentary = """
            राम की उस सभा में उपस्थित सभी मुनिगण गान सुनकर अत्यंत गहरे हर्ष (सान्द्रं हर्षम्) में डूब गए।
            वे सभी मुनि फिर से प्रसन्न होकर "साधु! साधु!" (बहुत सुंदर! धन्य!) की ध्वनि करने लगे।
            राम स्वयं भी उस गान के प्रभाव से चकित थे, क्योंकि उन्होंने अपना ऐसा वर्णन पहले कभी नहीं सुना था।
            मुनियों का बार-बार "साधु" कहना यह सिद्ध करता था कि गान में कोई भी शास्त्रीय दोष नहीं था।
            वह आनंद 'सान्द्र' था, जिसका अर्थ है कि वह अत्यंत सघन और हृदय को पूरी तरह भर देने वाला था।
            राम के दरबार में ऋषियों की यह प्रतिक्रिया उन बालकों के लिए सबसे बड़ा आशीर्वाद और प्रमाणपत्र थी।
            सबको ऐसा महसूस हो रहा था जैसे वे अयोध्या में नहीं, बल्कि वैकुण्ठ के किसी उत्सव में उपस्थित हों।
            मुनि देख रहे थे कि कैसे इन बालकों ने राम के एक-एक गुण को स्वर के साथ साक्षात् कर दिया है।
            यह दृश्य सिद्ध करता है कि कला जब ईश्वर के चरणों में समर्पित होती है, तो वह सर्वोच्च वंदनीय बन जाती है।
            राम की सभा का प्रत्येक सदस्य उस पल केवल एक भक्त और एक प्रेमी श्रोता बन चुका था।
            संगीत की शक्ति यहाँ धर्म के प्रचार का सबसे सशक्त माध्यम बनकर उभरी थी।
        """.trimIndent(),
        englishCommentary = """
            In Rama's assembly, all the sages who heard their singing were submerged in a deep and intense joy.
            Those sages, filled with delight, once again made the hall resonate with the sounds of "Sadhu! Sadhu!".
            Rama Himself was astonished by the impact of the singing, for He had never heard His own story narrated so.
            The repeated exclamations of the sages proved that the performance was devoid of any technical or moral flaw.
            The joy was 'Sandra,' meaning it was concentrated and capable of completely saturating the human heart.
            This reaction of the seers in Rama’s court was the ultimate validation and certificate for the young bards.
            Everyone felt as if they were not in Ayodhya but were attending a divine festival in Vaikuntha or Heaven.
            The sages observed how these boys had made every attribute of Rama manifest through their melodic voices.
            This scene proves that when art is surrendered at the feet of God, it becomes worthiest of supreme worship.
            Every member of Rama's assembly had, at that moment, become merely a devotee and a loving listener.
            The power of music emerged here as the most potent medium for the propagation of Dharma.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 22,
        sanskrit = "अष्टादश सहस्राणि सुवर्णस्य महात्मनाम् ।\nदापयमास शत्रूघ्नं रामः कुशीलवौ तदा ॥ २२ ॥",
        hindiCommentary = """
            गान से प्रसन्न होकर श्री राम ने शत्रुघ्न को आदेश दिया कि इन महात्मा बालकों को स्वर्ण मुद्राएं दी जाएं।
            उन्होंने उन दोनों (कुश-लव) को अठारह हजार (१८,०००) स्वर्ण मुद्राएं उपहार स्वरूप प्रदान करने का निर्देश दिया।
            राम की यह उदारता उनके 'राजा' होने के कर्तव्य और एक गुणग्राही श्रोता होने के नाते थी।
            वे चाहते थे कि इन दिव्य गायकों का उचित सत्कार हो और इन्हें भविष्य के लिए कोई अभाव न रहे।
            शत्रुघ्न जी ने तुरंत आज्ञा का पालन करते हुए सोने के ढेर उन बालकों के सामने रख दिए।
            यह दृश्य राजसी वैभव और कलाकारों के प्रति सम्मान की भारतीय परंपरा का एक ज्वलंत उदाहरण है।
            राम जानते थे कि विद्या का मूल्य धन से नहीं चुकाया जा सकता, फिर भी यह केवल एक शिष्टाचार था।
            दरबार में उपस्थित लोग राम की इस महानता और उनके दानी स्वभाव की प्रशंसा करने लगे।
            सोने की चमक उन बालकों के चेहरे के तेज के सामने फीकी लग रही थी, जो मुनि ने ध्यान में देखा था।
            यह श्लोक राम के नेतृत्व में अयोध्या की आर्थिक समृद्धि और कलाकारों के उच्च स्थान को दर्शाता है।
            परन्तु, इन बालकों का उत्तर इससे भी कहीं अधिक आश्चर्यजनक और शिक्षाप्रद होने वाला था।
        """.trimIndent(),
        englishCommentary = """
            Pleased by the performance, Sri Rama directed Shatrughna to provide gold coins to these great souls.
            He instructed that eighteen thousand (18,000) gold pieces be presented to Kusha and Lava as a gift.
            Rama's generosity stemmed from His duty as a King and His appreciation as a discerning listener.
            He desired that these divine singers be properly honored so they would face no lack in the future.
            Shatrughna immediately obeyed the command and placed the heaps of gold before the young boys.
            This scene is a vivid example of the Indian tradition of showing immense respect toward artists.
            Rama realized that the value of wisdom cannot be paid in gold, yet this was a gesture of royal grace.
            The people in the court marveled at Rama's magnanimity and His naturally charitable disposition.
            The glitter of the gold seemed dim compared to the spiritual radiance on the faces of the two boys.
            This verse illustrates the economic prosperity of Ayodhya and the high status accorded to scholars.
            However, the response from the young bards was destined to be even more astonishing and educational.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 23,
        sanskrit = "दीनारान् बहुसाहस्रं ताभ्यां दत्त्वा च राघवः ।\nकिमेतदिति तौ प्राहुरन्वीक्षन्तौ कुशीलवौ ॥ २३ ॥",
        hindiCommentary = """
            जब राघव (राम) ने उन्हें हजारों स्वर्ण दीनार (मुद्राएं) दिए, तो कुश और लव ने उसे देखकर आश्चर्य किया।
            वे दोनों बालक उन मुद्राओं की ओर देखते हुए बोले—"हे राजन्! यह सब क्या है और हम इसका क्या करेंगे?"
            उनकी इस प्रतिक्रिया ने पूरी सभा को स्तब्ध कर दिया, क्योंकि कोई भी धन को ठुकराता नहीं है।
            कुश और लव ने सिद्ध किया कि वे केवल राम की कथा गाने आए थे, धन बटोरने के लिए नहीं।
            उनका यह वैराग्य उनके गुरु वाल्मीकि के संस्कारों और उनकी तपोमयी जीवनशैली का परिणाम था।
            वे जानते थे कि एक तपस्वी के लिए सोना और पत्थर एक समान होते हैं, विशेषकर जब वे भगवान के पास हों।
            'किमेतदिति' (यह क्या है) का प्रश्न उनकी मासूमियत और उनके उच्च चरित्र की ओर संकेत करता है।
            उन्होंने धन की ओर ऐसे देखा जैसे वह उनके किसी काम की वस्तु न हो, जो विरले ही देखा जाता है।
            यह क्षण सिखाता है कि जो ज्ञान का सच्चा उपासक है, उसे भौतिक प्रलोभन कभी विचलित नहीं कर सकते।
            राम ने उन बालकों की आँखों में वह संतोष देखा जो बड़े-बड़े सम्राटों के पास भी नहीं होता था।
            यह श्लोक त्याग और निष्काम सेवा के उस आदर्श को प्रस्तुत करता है जो रामायण का प्राण है।
        """.trimIndent(),
        englishCommentary = """
            When Rama (Raghava) offered them thousands of gold dinars, Kusha and Lava looked at them with surprise.
            Observing the coins, the two boys asked: "O King! What is this, and what use do we have for it?".
            Their reaction stunned the entire assembly, as it is rare for anyone to refuse such immense wealth.
            Kusha and Lava proved that they had come only to sing the story, not to accumulate riches.
            Their detachment was a result of the values instilled by Valmiki and their ascetic lifestyle.
            They realized that for a hermit, gold and stone are equal, especially in the presence of the Divine.
            The question "What is this?" points toward their pure innocence and their superior moral character.
            They looked at the wealth as if it were an object of no utility, a sight seldom witnessed in royal courts.
            This moment teaches that a true seeker of wisdom can never be distracted by material temptations.
            Rama perceived in their eyes a level of contentment that even great emperors often failed to possess.
            This verse presents the ideal of renunciation and selfless service that is the soul of the epic.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 24,
        sanskrit = "वन्येन फलमूलेन निवसतौ वने सदा ।\nसुवर्णेन च किं कार्यं नः स्वयमागतं वने ॥ २४ ॥",
        hindiCommentary = """
            बालकों ने कहा—"हम सदा वन में रहने वाले हैं और कंद-मूल व फलों के आहार पर ही जीवित रहते हैं।"
            "हमें इस सोने (सुवर्णेन) का क्या कार्य है? वन में हमारे लिए इसकी कोई उपयोगिता नहीं है।"
            यह उत्तर उनके 'संतोष' की पराकाष्ठा था, जो यह बताता है कि आवश्यकताएं जितनी कम हों, व्यक्ति उतना ही स्वतंत्र होता है।
            उन्होंने स्पष्ट कर दिया कि वे प्रकृति के सान्निध्य में पूरी तरह सुखी और तृप्त हैं।
            सोने को व्यर्थ बताना यह सिद्ध करता है कि उन्होंने सत्य के उस स्वरूप को जान लिया था जो नाशवान नहीं है।
            राजमहल के लोग उनकी इस निर्भीकता और सादगी को देखकर दांतों तले उंगली दबा रहे थे।
            उनका 'वन्य' जीवन उनके लिए किसी भी साम्राज्य के वैभव से कहीं अधिक गौरवमयी और शांतिपूर्ण था।
            यहाँ 'नः' (हमें) शब्द उन दोनों के बीच की एकता और उनके साझा जीवन-दर्शन को प्रकट करता है।
            राम ने महसूस किया कि ये बालक वास्तव में उच्च कोटि के ऋषि हैं, जो केवल बच्चों के रूप में दिख रहे हैं।
            यह श्लोक उपभोक्तावाद (Consumerism) के विरुद्ध अध्यात्म की एक बहुत बड़ी और शाश्वत विजय है।
            उनकी इस बात ने राम के हृदय में उनके प्रति सम्मान को और भी अधिक गहरा और दृढ़ बना दिया।
        """.trimIndent(),
        englishCommentary = """
            The boys said: "We are forest-dwellers who subsist eternally on wild fruits and edible roots."
            "What business do we have with gold? It serves no purpose for us in our life within the woods."
            This response was the peak of 'Santosh' (contentment), showing that the fewer one's needs, the freer one is.
            They clarified that they were perfectly happy and satisfied in the intimate companionship of nature.
            Labeling gold as useless proved that they had realized the eternal Truth that is never subject to decay.
            The courtiers were speechless, witnessing such boldness and simplicity from two young children.
            Their 'Vanya' (forest) life was more dignified and peaceful to them than the opulence of any empire.
            The use of the word 'Nah' (to us) reveals the unity between the two and their shared philosophy of life.
            Rama sensed that these boys were actually high-level sages merely appearing in the form of children.
            This verse represents a monumental and timeless victory of spirituality over the greed of materialism.
            Their statement deepened Rama's respect for them, making it even more profound and unwavering.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 25,
        sanskrit = "तयोस्तद्वचनं श्रुत्वा विस्मितः स च राघवः ।\nपृच्छति स्म मुनीन् सर्वान् कौतूहलसमन्वितः ॥ २५ ॥",
        hindiCommentary = """
            उन बालकों के ऐसे विरक्तिपूर्ण वचनों को सुनकर राघव (राम) अत्यंत विस्मित (आश्चर्यचकित) हो गए।
            वे 'कौतूहल' (उत्सुकता) से भर गए और सभा में उपस्थित सभी मुनियों से इनके बारे में पूछने लगे।
            राम यह जानना चाहते थे कि इन अद्भुत बालकों का गुरु कौन है और इन्होंने यह शिक्षा कहाँ से पाई?
            एक राजा के लिए यह देखना विरल था कि कोई उसकी दी हुई इतनी बड़ी राशि को ठुकरा दे।
            राम की जिज्ञासा अब केवल गान तक सीमित नहीं थी, बल्कि वे इन बालकों के मूल को जानना चाहते थे।
            'विस्मित' होना यह दर्शाता है कि राम भी मानवीय लीला में इन बालकों के तेज से प्रभावित थे।
            उन्होंने महसूस किया कि इन बालकों के पीछे किसी बहुत बड़ी तपस्वी शक्ति का हाथ और आशीर्वाद है।
            सभा में बैठे मुनिगण भी एक-दूसरे की ओर देखने लगे, क्योंकि वे भी इन बालकों के रहस्य से अनभिज्ञ थे।
            यह श्लोक कथा में एक नया 'सस्पेंस' और जिज्ञासा का भाव पैदा करता है जो पाठक को बांधे रखता है।
            राम ने बड़े आदर के साथ मुनियों से आग्रह किया कि वे इन तेजस्वी बालकों का परिचय दें।
            जिज्ञासा ही ज्ञान का द्वार है, और राम की यह उत्सुकता रामायण के रचयिता के प्रकटीकरण का मार्ग बनी।
        """.trimIndent(),
        englishCommentary = """
            Upon hearing such detached and noble words from the boys, Rama (Raghava) was utterly amazed.
            He was filled with 'Kautuhala' (curiosity) and began inquiring of all the sages present in the assembly.
            Rama desired to know who the Guru of these extraordinary children was and where they had studied.
            It was rare for a monarch to see someone reject such a massive amount of royal wealth so casually.
            Rama’s curiosity now transcended the music; He yearned to discover the very roots of these bards.
            Being 'Vismitah' (surprised) shows that even in His human play, Rama was struck by their spiritual aura.
            He sensed that behind these children stood the immense power and blessings of a great ascetic.
            The sages in the assembly exchanged glances, for they too were unaware of the boys' mysterious identity.
            This verse creates a new sense of 'suspense' and inquiry that keeps the reader deeply engaged.
            Rama respectfully urged the seers to provide whatever information they held about these radiant boys.
            Curiosity is the gateway to wisdom, and Rama’s eagerness paved the way for the revelation of the author.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 26,
        sanskrit = "किं प्रमाणमिदं काव्यं का कर्ता क्व च स मुनिः ।\nयस्येयं कृतिरुत्तमा यं च शंसति राघवः ॥ २६ ॥",
        hindiCommentary = """
            राम ने पूछा—"इस काव्य का प्रमाण (विस्तार) क्या है? इसके रचयिता (कर्ता) कौन हैं और वे मुनि कहाँ हैं?"
            "जिनकी यह 'उत्तम कृति' है, जिसकी प्रशंसा स्वयं राघव (मैं) कर रहा हूँ, उनका परिचय दें।"
            राम ने स्वीकार किया कि यह रचना 'उत्तम' है, जो किसी साधारण मस्तिष्क की उपज नहीं हो सकती।
            'प्रमाण' पूछने का अर्थ था—वे इस ग्रंथ की गहराई, श्लोकों की संख्या और इसकी संरचना जानना चाहते थे।
            उन्होंने रचयिता के प्रति अपनी अगाध श्रद्धा व्यक्त की, क्योंकि केवल एक सिद्ध मुनि ही ऐसा लिख सकते थे।
            राम को लगा कि यह काव्य उनके जीवन का वह आइना है जो उन्हें स्वयं से मिला रहा है।
            वे उस महान आत्मा के दर्शन के लिए व्याकुल थे जिसने उनके चरित्र को इतनी पवित्रता से समझा था।
            यह प्रश्न राजा की ओर से एक 'समीक्षक' (Critic) और एक 'भक्त' के मिले-जुले भावों से निकला था।
            मुनि का स्थान (क्व च स मुनिः) पूछना यह बताता है कि राम स्वयं उनके पास जाकर आभार व्यक्त करना चाहते थे।
            यह श्लोक रामायण के 'साहित्यिक गौरव' को नायक के मुख से ही प्रमाणित करवाता है।
            राम की यह व्याकुलता सिद्ध करती है कि सत्य जब कला के रूप में आता है, तो वह सबको झुका देता है।
        """.trimIndent(),
        englishCommentary = """
            Rama asked: "What is the extent of this poem? Who is the author (Karta), and where does that sage reside?"
            "Provide the details of the one whose 'Utatama Kriti' (excellent work) this is, which even I am praising."
            Rama acknowledged that the composition was supreme, suggesting it could not be the product of an ordinary mind.
            Inquiring about the 'Pramana' meant He wished to know the depth, syllable count, and structure of the text.
            He expressed profound reverence for the author, realizing only a perfected seer could produce such work.
            Rama felt that this poetry was a mirror of His own life, reuniting Him with His own transcendental self.
            He was eager to behold the great soul who had understood His character with such unparalleled sanctity.
            This query emerged from the combined sentiments of a 'royal critic' and a 'devoted seeker.'
            Asking for the sage’s location indicates that Rama intended to visit him personally to express His gratitude.
            This verse validates the 'Literary Grandeur' of the Ramayana through the very lips of its protagonist.
            Rama’s eagerness proves that when Truth manifests as Art, it compels even the highest beings to bow.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 27,
        sanskrit = "चतुर्विंशत्सहस्राणि श्लोकानामुक्तवानृषिः ।\nतथा सर्गशतान् पञ्च षट् काण्डानि तथोत्तरम् ॥ २७ ॥",
        hindiCommentary = """
            मुनियों ने उत्तर दिया—"ऋषि वाल्मीकि ने इसमें चौबीस हजार (२४,०००) श्लोकों की रचना की है।"
            "इसमें पाँच सौ (५००) सर्ग और उत्तर काण्ड सहित कुल सात काण्डों का अद्भुत संकलन है।"
            यह श्लोक ग्रंथ के 'विराट स्वरूप' का आधिकारिक विवरण प्रदान करता है जो राम को बताया गया।
            २४,००० श्लोकों की विशालता यह सिद्ध करती है कि यह मानवीय इतिहास का सबसे बड़ा महाकाव्य बनने वाला था।
            पाँच सौ सर्गों का विभाजन कथा को अत्यंत सुव्यवस्थित और पठनीय बनाता है।
            मुनियों ने राम को बताया कि यह केवल एक कहानी नहीं, बल्कि वेदों के समान एक विस्तृत संहिता है।
            'उत्तराम' का उल्लेख यह बताता है कि कथा केवल रावण वध तक नहीं, बल्कि उसके बाद के आदर्शों तक जाती है।
            राम यह सुनकर विस्मित थे कि उनके जीवन की इतनी छोटी-छोटी बातें भी मुनि ने लिपिबद्ध की हैं।
            यह संख्यात्मक विवरण ग्रंथ की प्रामाणिकता और उसकी व्यापकता की पुष्टि करता है।
            मुनि वाल्मीकि की इस साधना ने साहित्य को एक ऐसा सागर दिया जिसकी गहराई को नापना असंभव था।
            यहीं से राम को समझ आया कि यह ग्रंथ उनके कुल और उनके धर्म को युगों-युगों तक जीवित रखेगा।
        """.trimIndent(),
        englishCommentary = """
            The sages replied: "Sage Valmiki has composed twenty-four thousand (24,000) verses in this work."
            "It consists of five hundred (500) chapters and seven sections, including the extensive Uttara Kanda."
            This verse provides the official description of the 'Vast Form' of the scripture as presented to Rama.
            The magnitude of 24,000 verses proved that this was destined to be the greatest epic in human history.
            The division into five hundred Sargas rendered the narrative extremely organized and readable.
            The sages informed Rama that this was not merely a story but a comprehensive code equal to the Vedas.
            The mention of 'Uttara' signifies that the tale goes beyond the slaying of Ravana to future ideals.
            Rama was astonished to learn that even the minutest details of His life had been chronicled by the sage.
            This numerical account confirms the authenticity and the exhaustive scope of the monumental text.
            Sage Valmiki’s dedicated practice gifted literature an ocean whose depth was impossible to measure.
            From this point, Rama realized that this scripture would keep His lineage and Dharma alive for eons.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 28,
        sanskrit = "इत्युक्त्वा तौ कुमारौ तु विरराम च राघवः ।\nकौतूहलात् स च रामो भूयः श्रोतुं प्रचक्रमे ॥ २८ ॥",
        hindiCommentary = """
            ऐसा कहकर उन दोनों कुमारों ने अपना गान समाप्त किया और राघव (राम) भी मौन हो गए।
            परन्तु राम के मन में और अधिक सुनने की इतनी तीव्र उत्सुकता (कौतूहलात्) थी कि वे फिर से सुनने को तैयार हुए।
            'विरराम' शब्द यहाँ उस क्षणिक विश्राम को दर्शाता है जहाँ पूरी सभा उस गान के जादू में डूबी हुई थी।
            राम को लग रहा था जैसे वे अपनी ही आत्मा की आवाज़ सुन रहे हैं, जिसे वे छोड़ना नहीं चाहते थे।
            उन्होंने महसूस किया कि यह कथा उनके हृदय के घावों को भरने और उन्हें शांति देने वाली है।
            'भूयः श्रोतुं' (फिर से सुनने के लिए) उनकी यह इच्छा दर्शाती है कि राम-कथा कभी पुरानी नहीं पड़ती।
            एक महान सम्राट होकर भी वे इन छोटे बालकों के सामने एक विनम्र श्रोता की तरह बैठे थे।
            अयोध्या का राजदरबार अब एक पवित्र सत्संग में बदल चुका था जहाँ समय रुक गया था।
            मुनि वाल्मीकि की योग-शक्ति ने राम के भीतर उस सत्य के प्रति ऐसी भूख जगा दी थी जो मिटने वाली नहीं थी।
            यह श्लोक ग्रंथ के 'आकर्षण' और उसकी 'अमृता' (Nectar-like quality) का साक्षात् प्रमाण है।
            अब राम ने उन बालकों से आग्रह किया कि वे इस महान गाथा को विस्तार से निरंतर सुनाते रहें।
        """.trimIndent(),
        englishCommentary = """
            Having spoken thus, the two young princes concluded their singing, and Rama (Raghava) also fell silent.
            However, such was the intense curiosity (Kautuhalat) in His mind that He prepared to listen further.
            The word 'Virarama' signifies a momentary pause where the entire assembly remained under the song's spell.
            Rama felt as if He were listening to the very voice of His own soul, which He was unwilling to let go.
            He realized that this narrative was healing the wounds of His heart and providing ultimate peace.
            His desire 'Bhuyah Shrotum' (to hear again) demonstrates that the story of Rama never becomes stale.
            Despite being a mighty sovereign, He sat before those small boys like a humble and attentive listener.
            The royal court of Ayodhya had transformed into a sacred gathering where time seemed to stand still.
            Valmiki's yogic power had awakened such a hunger for Truth within Rama that it was insatiable.
            This verse is direct evidence of the 'Attraction' and the 'Nectar-like' quality of the Ramayana.
            Rama now urged the boys to continue narrating this grand saga in detail without any further interruption.
        """.trimIndent()
    ),
    RamayanVerse(
        id = 29,
        sanskrit = "इति वाल्मीकिरामायणे बालकाण्डे चतुर्थः सर्गः ॥ २९ ॥",
        hindiCommentary = """
            इस प्रकार वाल्मीकि रामायण के बालकाण्ड का यह 'चतुर्थ सर्ग' यहाँ पूर्णता को प्राप्त होता है।
            यह सर्ग रामायण के प्रथम सार्वजनिक गान और कुश-लव की महान कलात्मक विजय का गवाह बना।
            यहाँ हमने देखा कि कैसे मुनि वाल्मीकि ने अपनी विद्या को योग्य शिष्यों को सौंपकर उसे अमर कर दिया।
            राम के दरबार में राम की ही कथा का गान होना भारतीय इतिहास का सबसे मर्मस्पर्शी और गौरवशाली दृश्य है।
            यह अध्याय हमें सिखाता है कि महान रचनाओं का असली उद्देश्य समाज में नैतिकता और भक्ति का संचार करना है।
            कुश और लव ने सिद्ध किया कि श्रद्धा और अभ्यास से किसी भी महान ज्ञान को आत्मसात किया जा सकता है।
            इस सर्ग के समापन के साथ ही रामायण की विस्तृत कथा के प्रारंभ होने की आधिकारिक भूमिका समाप्त होती है।
            अब पाठक उस विराट यात्रा पर निकलने के लिए तैयार है जिसे वाल्मीकि ने २४,००० श्लोकों में देखा था।
            यह सर्ग सिद्ध करता है कि रामायण केवल पढ़ने के लिए नहीं, बल्कि गाने और अनुभव करने के लिए है।
            ब्रह्मा की इच्छा और वाल्मीकि की तपस्या का फल अब कुश-लव के रूप में पूरी दुनिया के सामने था।
            ॥ चतुर्थ सर्ग सम्पूर्ण हुआ। जय श्री राम ॥
        """.trimIndent(),
        englishCommentary = """
            Thus, the 'Fourth Sarga' of the Baal Kand in the Valmiki Ramayana reaches its glorious conclusion.
            This chapter bore witness to the first public singing of the epic and the grand artistic victory of Kusha and Lava.
            We saw how Sage Valmiki immortalized His wisdom by handing it over to truly deserving and talented disciples.
            The singing of Rama’s story in Rama’s own court remains the most touching and glorious scene in Indian history.
            This chapter teaches us that the true purpose of great creations is to infuse morality and devotion into society.
            Kusha and Lava proved that with faith and practice, even the most profound knowledge can be fully internalized.
            With the conclusion of this Sarga, the formal and official introduction to the expansive narrative of the epic ends.
            The reader is now ready to embark upon the colossal journey that Valmiki perceived in 24,000 verses.
            This chapter proves that the Ramayana is not merely for reading but for singing and profound experiencing.
            The fruit of Brahma’s will and Valmiki’s penance was now manifest before the world in the form of Kusha-Lava.
            || Thus ends the Fourth Sarga. Jai Shri Ram ||
        """.trimIndent()
    )

)