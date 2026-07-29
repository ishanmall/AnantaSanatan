package com.sanatangyansagar.ui.screens.DurgaMaa

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShreeAmbaJiKIAartiScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header
                Text(
                    text = "श्री अम्बे जी की आरती",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = Color(0xFFD84315),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // 1. Sanskrit / Hindi Aarti Text
                Text(
                    text = "जय अम्बे गौरी, मैया जय श्यामा गौरी ।\nतुमको निशदिन ध्यावत, हरि ब्रह्मा शिवरी ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "मांग सिंदूर बिराजत, टीको मृगमद को ।\nउज्ज्वल से दोउ नैना, चंद्रबदन नीको ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "कनक समान कलेवर, रक्ताम्बर राजै ।\nरक्तपुष्प गल माला, कंठन पर साजै ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "केहरि वाहन राजत, खड्ग खप्पर धारी ।\nसुर-नर मुनिजन सेवत, तिनके दुखहारी ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "कानन कुण्डल शोभित, नासाग्रे मोती ।\nकोटिक चंद्र दिवाकर, सम राजत ज्योती ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "शुम्भ-निशुम्भ बिदारे, महिषासुर घाती ।\nधूम्र विलोचन नैना, निशदिन मदमाती ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "चण्ड-मुण्ड संहारे, शोणित बीज हरे ।\nमधु-कैटभ दोउ मारे, सुर भयहीन करे ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "ब्रह्माणी, रुद्राणी, तुम कमला रानी ।\nआगम निगम बखानी, तुम शिव पटरानी ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "चौंसठ योगिनी मंगल गावत, नृत्य करत भैरू ।\nबाजत ताल मृदंगा, अरु बाजत डमरू ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "तुम ही जग की माता, तुम ही हो भर्ता ।\nभक्तन की दुख हर्ता, सुख संपति कर्ता ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "भुजा चार अति शोभित, वरमुद्रा धारी ।\nमनवांछित फल पावत, सेवत नर नारी ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "कंचन थाल विराजत, अगर कपूर बाती ।\nश्रीमालकेतु में राजत, कोटि रतन ज्योती ॥ ॐ जय अम्बे गौरी ॥\n\n" +
                            "श्री अम्बेजी की आरती, जो कोई नर गावे ।\nकहत शिवानंद स्वामी, सुख-सम्पत्ति पावे ॥ ॐ जय अम्बे गौरी ॥",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    lineHeight = 28.sp
                )

                HorizontalDivider(color = Color.LightGray)

                // 2. Hindi Meaning Paragraphs
                Text(
                    text = "हिन्दी अर्थ:",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color(0xFF1565C0)
                )

                Text(
                    text = "हे माता अम्बे गौरी! हे श्यामा गौरी! आपकी हमेशा जय हो। भगवान विष्णु (हरि), ब्रह्मा जी और भगवान शिव (शिवरी) रात-दिन केवल आपका ही ध्यान करते हैं। हे ब्रह्मांड की आदि-शक्ति माता अम्बे, आपकी जय हो!\n\n" +
                            "हे माता! आपकी मांग में पवित्र सिंदूर सजा हुआ है और माथे पर कस्तूरी का अत्यंत सुंदर टीका सुशोभित है। आपके दोनों नेत्र अत्यंत उज्ज्वल हैं और आपका मुख चंद्रमा के समान अत्यंत सुंदर है।\n\n" +
                            "आपका शरीर शुद्ध सोने के समान चमकता है, और आप लाल रंग के वस्त्रों में अत्यंत सुशोभित हो रही हैं। आपके गले में लाल फूलों की माला अत्यंत भव्य लग रही है।\n\n" +
                            "आप सिंह को अपना वाहन बनाकर विराजमान हैं और हाथों में खड्ग (तलवार) तथा खप्पर (खोपड़ी का पात्र) धारण करती हैं। सभी देवता, मनुष्य और मुनिगण हमेशा आपकी सेवा करते हैं, और आप उन सबके दुखों को हरने वाली हैं।\n\n" +
                            "हे माता! आपके कानों में कुंडल सुशोभित हैं और नासिका के आगे वाले भाग पर मोती चमक रहा है। आपके दिव्य स्वरूप की चमक करोड़ों चंद्रमा और सूर्य के प्रकाश के समान एक साथ चमक रही है।\n\n" +
                            "हे माता! आपने ही शुम्भ और निशुम्भ नामक असुरों को चीर डाला और आप ही महिषासुर का वध करने वाली हैं। आपने ही धूम्रविलोचन जैसे राक्षस का संहार किया; आप अपनी ईश्वरीय शक्ति के आनंद में रात-दिन मग्न रहती हैं।\n\n" +
                            "आपने ही चण्ड और मुण्ड का संहार किया और रक्तबीज जैसे राक्षस का विनाश किया। आपने ही मधु और कैटभ दोनों दानवों को मारकर सभी देवताओं को उनके भय से मुक्त किया।\n\n" +
                            "हे माता! आप ही ब्रह्माणी (सरस्वती), आप ही रुद्राणी (पार्वती) और आप ही कमला रानी (महालक्ष्मी) हैं। सभी वेद और तंत्र-शास्त्र आपकी ही महिमा का बखान करते हैं; आप ही भगवान शिव की परम पटरानी हैं।\n\n" +
                            "आपकी आरती और स्तुति के समय चौंसठ योगिनियां मंगल गीत गा रही हैं और भगवान भैरव प्रसन्न होकर नृत्य कर रहे हैं। आपके दिव्य दरबार में ताल, मृदंग और डमरू अत्यंत मधुर ध्वनि में बज रहे हैं।\n\n" +
                            "हे देवी! आप ही इस संपूर्ण जगत की असली माता हैं और आप ही सबका भरण-पोषण करने वाली हैं। आप ही अपने भक्तों के सभी प्रकार के दुखों का नाश करने वाली और उन्हें सुख-संपत्ति प्रदान करने वाली हैं।\n\n" +
                            "आपकी चार भुजाएं अत्यंत सुशोभित हैं और आप अपने भक्तों को अभय तथा वरदान देने वाली मुद्रा धारण करती हैं। जो भी नर और नारी सच्चे मन से आपकी सेवा और पूजा करते हैं, वे अपना मनचाहा फल निश्चित रूप से प्राप्त करते हैं।\n\n" +
                            "सोने के थाल में अगरबत्ती और कपूर की बाती जलकर आपकी आरती उतार रही है। आपके मंदिर के शिखर में करोड़ों रत्नों की चमक के समान दिव्य ज्योति प्रकाशमान हो रही है।\n\n" +
                            "(आरती का समापन): स्वामी शिवानंद जी कहते हैं कि जो भी मनुष्य पूरी श्रद्धा और प्रेम के साथ श्री अम्बे माता की इस आरती को गाता है, वह अपने जीवन में पूर्ण सुख, अपार संपत्ति और माता की परम कृपा को अवश्य प्राप्त करता है।",
                    fontSize = 16.sp,
                    color = Color(0xFF424242),
                    lineHeight = 24.sp
                )

                HorizontalDivider(color = Color.LightGray)

                // 3. English Meaning Paragraphs
                Text(
                    text = "English Meaning:",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color(0xFF2E7D32)
                )

                Text(
                    text = "O Mother Ambe Gauri! O Shyama Gauri! Ultimate victory to You. Lord Vishnu (Hari), Lord Brahma, and Lord Shiva meditate upon You flawlessly day and night. Om, absolute victory to You, Mother Ambe!\n\n" +
                            "Sacred vermilion gorgeously adorns the parting of Your hair, and a mark of pure musk beautifies Your forehead. Both Your eyes are brightly radiant, and Your divine face is flawlessly beautiful like the glowing moon.\n\n" +
                            "Your physical body radiates brilliantly exactly like pure gold, and You are majestically adorned in red garments. A beautiful garland woven with blood-red flowers elegantly graces Your divine neck.\n\n" +
                            "You majestically ride a fearsome lion as Your vehicle, wielding a fierce sword and a skull-bowl in Your hands. Gods, humans, and sages constantly serve You, and You are the absolute destroyer of all their sorrows.\n\n" +
                            "Exquisite earrings adorn Your ears, and a beautiful glowing pearl shines perfectly at the tip of Your nose. The absolute radiance of Your divine form shines as brightly as millions of moons and suns combined.\n\n" +
                            "O Mother! You ruthlessly tore apart the massive demons Shumbha and Nishumbha, and You are the supreme slayer of Mahishasura. You annihilated the demon Dhumralochana, and You remain constantly intoxicated in the absolute bliss of Your own divine power day and night.\n\n" +
                            "You completely slaughtered the ferocious demons Chanda and Munda, and eradicated the terrifying Raktabija. You annihilated both demons Madhu and Kaitabha, flawlessly rendering the gods completely fearless.\n\n" +
                            "O Mother! You Yourself are Brahmani (Saraswati), Rudrani (Parvati), and Kamala Rani (Mahalakshmi). All the scriptures and Vedas constantly sing Your absolute glory; You are the supreme Queen of Lord Shiva.\n\n" +
                            "Sixty-four Yoginis sing highly auspicious songs for You, and Lord Bhairava dances in sheer cosmic ecstasy. Cymbals, drums, and Damarus resound gloriously and melodiously in Your divine court.\n\n" +
                            "O Goddess! You alone are the true Mother of this entire universe, and You alone are its ultimate Sustainer. You are the absolute destroyer of Your devotees' sorrows and the supreme bestower of immense joy and wealth.\n\n" +
                            "Your four arms are exceptionally beautiful, and You elegantly hold the mudra of granting boons. Whichever men and women serve and worship You with absolute devotion flawlessly attain their desired fruits.\n\n" +
                            "In a pure golden plate, incense and camphor wicks are brightly burning to perform Your Aarti. In Your magnificent temple peak, a divine light absolutely equivalent to millions of glowing gems is brilliantly shining.\n\n" +
                            "(Conclusion): Swami Shivananda declares that whosoever human being sings this highly sacred Aarti of Mother Ambe with deep devotion, undoubtedly and certainly attains complete happiness, boundless wealth, and the supreme grace of the Mother in life.",
                    fontSize = 16.sp,
                    color = Color(0xFF424242),
                    lineHeight = 24.sp
                )
            }
        }
    }
}