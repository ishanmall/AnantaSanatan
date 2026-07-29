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
fun ShreeDurgaChalisaScreen() {
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
                    text = "श्री दुर्गा चालीसा",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = Color(0xFFD84315),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // 1. Original Chalisa Text
                Text(
                    text = "नमो नमो दुर्गे सुख करनी । नमो नमो अम्बे दुःख हरनी ॥\n" +
                            "निराकार है ज्योति तुम्हारी । तिहूँ लोक फैली उजियारी ॥\n\n" +
                            "शशि ललाट मुख महाविशाला । नेत्र लाल भृकुटि विकराला ॥\n" +
                            "रूप मातु को अधिक सुहावे । दरश करत जन अति सुख पावे ॥\n\n" +
                            "तुम संसार शक्ति लय कीना । पालन हेतु अन्न धन दीना ॥\n" +
                            "अन्नपूर्णा हुई जग पाला । तुम ही आदि सुन्दरी बाला ॥\n\n" +
                            "प्रलयकाल सब नाशन हारी । तुम गौरी शिवशंकर प्यारी ॥\n" +
                            "शिव योगी तुम्हरे गुण गावें । ब्रह्मा विष्णु तुम्हें नित ध्यावें ॥\n\n" +
                            "रूप सरस्वती को तुम धारा । दे सुबुद्धि ऋषि-मुनिन उबारा ॥\n" +
                            "धरयो रूप नरसिंह को अम्बा । परगट भई फाड़कर खम्बा ॥\n\n" +
                            "रक्षा करि प्रह्लाद बचायो । हिरण्याक्ष को स्वर्ग पठायो ॥\n" +
                            "लक्ष्मी रूप धरो जग माहीं । श्री नारायण अंग समाहीं ॥\n\n" +
                            "क्षीरसिन्धु में करत विलासा । दयासिन्धु दीजै मन आसा ॥\n" +
                            "हिंगलाज में तुम्हीं भवानी । महिमा अमित न जात बखानी ॥\n\n" +
                            "मातंगी अरु धूमावति माता । भुवनेश्वरी बगला सुख दाता ॥\n" +
                            "श्री भैरव तारा जग तारिणी । छिन्न भाल भव दुःख निवारिणी ॥\n\n" +
                            "केहरि वाहन सोह भवानी । लांगुर वीर चलत अगवानी ॥\n" +
                            "कर में खप्पर खड्ग विराजै । जाको देख काल डर भाजै ॥\n\n" +
                            "सोहै अस्त्र और त्रिशूला । जाते उठत शत्रु हिय शूला ॥\n" +
                            "नगरकोट में तुम्हीं विराजत । तिहुँलोक में डंका बाजत ॥\n\n" +
                            "शुम्भ निशुम्भ दानव तुम मारे । रक्तबीज शंखन संहारे ॥\n" +
                            "महिषासुर नृप अति अभिमानी । जेहि अघ भार मही अकुलानी ॥\n\n" +
                            "रूप कराल कालिका धारा । सेन सहित तुम तिहि संहारा ॥\n" +
                            "परी गाढ़ संतन पर जब-जब । भई सहाय मातु तुम तब-तब ॥\n\n" +
                            "अमरपुरी अरु बासव लोका । तब महिमा सब रहें अशोका ॥\n" +
                            "ज्वाला में है ज्योति तुम्हारी । तुम्हें सदा पूजें नर-नारी ॥\n\n" +
                            "प्रेम भक्ति से जो यश गावें । दुःख दारिद्र निकट नहिं आवें ॥\n" +
                            "ध्यावे तुम्हें जो नर मन लाई । जन्म-मरण ताकौ छुटि जाई ॥\n\n" +
                            "जोगी सुर मुनि कहत पुकारी । योग न हो बिन शक्ति तुम्हारी ॥\n" +
                            "शंकर आचारज तप कीनो । काम अक्रोध जीति सब लीनो ॥\n\n" +
                            "निशिदिन ध्यान धरो शंकर को । काहु काल नहिं सुमिरो तुमको ॥\n" +
                            "शक्ति रूप का मरम न पायो । शक्ति गई तब मन पछतायो ॥\n\n" +
                            "शरणागत हुई कीर्ति बखानी । जय जय जय जगदम्ब भवानी ॥\n" +
                            "भई प्रसन्न आदि जगदम्बा । दई शक्ति नहिं कीन विलम्बा ॥\n\n" +
                            "मोको मातु कष्ट अति घेरो । तुम बिन कौन हरै दुःख मेरो ॥\n" +
                            "आशा तृष्णा निपट सतावें । मोह मदादिक सब बिनशावें ॥\n\n" +
                            "शत्रु नाश कीजै महारानी । सुमिरौं इकचित तुम्हें भवानी ॥\n" +
                            "करो कृपा हे मातु दयाला । ऋद्धि-सिद्धि दै करहु निहाला ॥\n\n" +
                            "जब लगि जिऊँ दया फल पाऊँ । तुम्हरो यश मैं सदा सुनाऊँ ॥\n" +
                            "दुर्गा चालीसा जो कोई गावै । सब सुख भोग परमपद पावै ॥\n\n" +
                            "देवीदास शरण निज जानी । करहु कृपा जगदम्ब भवानी ॥",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    lineHeight = 28.sp
                )

                HorizontalDivider(color = Color.LightGray)

                // 2. Hindi Summary Paragraph
                Text(
                    text = "हिन्दी सारांश:",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color(0xFF1565C0)
                )

                Text(
                    text = "हे सुख प्रदान करने वाली माता दुर्गा और दुख हरने वाली माता अम्बे! आपको बारंबार प्रणाम है। आपका ईश्वरीय तेज निराकार है और इसकी दिव्य ज्योति तीनों लोकों में फैली हुई है। मस्तक पर चंद्रमा, लाल नेत्र और भयंकर भृकुटि होने के बावजूद आपका रूप अत्यंत मनमोहक है। आप ही इस संसार की मूल शक्ति हैं और प्राणियों के पालन-पोषण के लिए आपने ही अन्न और धन प्रदान किया है।\n\n" +
                            "आपने ही माता सरस्वती का रूप धारण कर ऋषियों को सुबुद्धि दी, भगवान नरसिंह के रूप में प्रकट होकर भक्त प्रह्लाद की रक्षा की, और माता लक्ष्मी के रूप में क्षीरसागर में भगवान नारायण के साथ निवास किया। आपने ही अपने सिंह (वाहन) पर सवार होकर और हाथों में खड्ग-त्रिशूल धारण कर शुम्भ, निशुम्भ, रक्तबीज और घमंडी महिषासुर जैसे भयंकर दानवों का वध किया था। जब-जब देवताओं और संतों पर घोर संकट आया, तब-तब आपने ही स्वयं प्रकट होकर उनकी सहायता की।\n\n" +
                            "जो भी भक्त सच्चे मन और प्रेम-भक्ति से आपका यश गाता है, उसके आस-पास दुख और दरिद्रता कभी फटक भी नहीं सकते। हे दयालु महारानी! मेरे भीतर बैठे काम, क्रोध, मोह, लोभ और तृष्णा रूपी शत्रुओं का पूरी तरह नाश करें। मुझे ऋद्धि-सिद्धि प्रदान कर निहाल करें। जो भी मनुष्य इस श्री दुर्गा चालीसा का नित्य गान करेगा, वह इस जीवन के सभी सुखों को भोगकर अंत में परम पद (मोक्ष) को प्राप्त करेगा।",
                    fontSize = 16.sp,
                    color = Color(0xFF424242),
                    lineHeight = 24.sp
                )

                HorizontalDivider(color = Color.LightGray)

                // 3. Line-by-Line English Translation
                Text(
                    text = "English Line-by-Line Meaning:",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = Color(0xFF2E7D32)
                )

                Text(
                    text = "Namo Namo Durge Sukh karani | Namo Namo Ambe Dukh harani ||\n" +
                            "Salutations to You, O Durga, the bestower of absolute happiness! Salutations to You, O Ambe, the ultimate destroyer of sorrows!\n\n" +
                            "Nirakar hai jyoti tumhari | Tihun lok phaili ujiyari ||\n" +
                            "Your divine cosmic light is completely formless, and its brilliant radiance illuminates all the three worlds.\n\n" +
                            "Shashi lalat mukh maha vishala | Netra lal bhrikuti vikarala ||\n" +
                            "A crescent moon adorns Your forehead, and Your face is magnificent. Your eyes are fiercely red, and Your frown is terrifying.\n\n" +
                            "Roop Matu ko adhik suhave | Darash karat jan ati sukh pave ||\n" +
                            "Yet, this form of Yours, O Mother, is exceedingly enchanting. Your devotees attain immense joy merely by beholding You.\n\n" +
                            "Tum sansar shakti laya kina | Palan hetu ann dhan dina ||\n" +
                            "You are the supreme cosmic energy that sustains the entire world. You have provided food and wealth for the nourishment of all beings.\n\n" +
                            "Annapurna hui jag pala | Tum hi aadi sundari Bala ||\n" +
                            "You lovingly protect the world in the form of Mother Annapurna. You are the primordial, ever-youthful, and original beauty (Bala).\n\n" +
                            "Pralaykal sab nashan haari | Tum Gauri Shivshankar pyari ||\n" +
                            "During cosmic dissolution, You are the absolute destroyer of everything. You are Goddess Gauri, the beloved of Lord Shiva.\n\n" +
                            "Shiv yogi tumhre gun gavein | Brahma Vishnu tumhein nit dhyavein ||\n" +
                            "Lord Shiva and all great yogis constantly sing Your praises. Lord Brahma and Lord Vishnu meditate upon You every single day.\n\n" +
                            "Roop Saraswati ko tum dhara | De subuddhi rishi-munin ubara ||\n" +
                            "You assumed the serene form of Goddess Saraswati, granting pure wisdom and rescuing the great sages from ignorance.\n\n" +
                            "Dharyo roop Narsingh ko Amba | Pargat bhayi phaadkar khamba ||\n" +
                            "O Mother! You assumed the fierce form of Lord Narasimha, manifesting dynamically by tearing apart the iron pillar.\n\n" +
                            "Raksha kari Prahlad bachayo | Hiranyaksh ko swarg pathayo ||\n" +
                            "You protected and saved the great devotee Prahlad, and You liberated the demon Hiranyakashipu (sending him to heaven).\n\n" +
                            "Lakshmi roop dharo jag mahin | Shree Narayan ang samahin ||\n" +
                            "You incarnated as Goddess Lakshmi in this physical world, residing blissfully alongside Lord Sri Narayana.\n\n" +
                            "Kshirsindhu mein karat vilasa | Dayasindhu deejay man aasa ||\n" +
                            "You revel joyfully in the cosmic Ocean of Milk. O Ocean of Compassion, please fulfill the pure hopes of my mind.\n\n" +
                            "Hingalaj mein tumhin Bhavani | Mahima amit na jaat bakhani ||\n" +
                            "You reside in the sacred shrine of Hinglaj as Goddess Bhavani. Your magnificent glory is infinite and cannot be fully described.\n\n" +
                            "Matangi aru Dhumavati Mata | Bhuvaneshwari Bagala sukh data ||\n" +
                            "You are Matangi, Mother Dhumavati, Bhuvaneshwari, and Bagalamukhi—the supreme bestowers of joy and comfort.\n\n" +
                            "Shree Bhairav Tara jag tarini | Chhinna Bhal bhav dukh nivarini ||\n" +
                            "You are Bhairavi and Tara, the ultimate saviors of the world. As Chhinnamasta, You eradicate all the miseries of material existence.\n\n" +
                            "Kehari vahan soha Bhavani | Langur veer chalat agvani ||\n" +
                            "You look supremely magnificent riding Your fierce lion vehicle, O Bhavani! The brave Langur (Lord Hanuman) fiercely marches ahead of You.\n\n" +
                            "Kar mein khappar khadga viraje | Jako dekh kaal dar bhaje ||\n" +
                            "A skull-bowl and a terrifying sword beautifully adorn Your hands. Seeing them, even Time (Death) runs away in absolute terror.\n\n" +
                            "Sohe astra aur trishula | Jate uthat shatru hiya shula ||\n" +
                            "Various divine weapons and the mighty trident grace You, the very sight of which strikes agonizing fear into the hearts of Your enemies.\n\n" +
                            "Nagarkot mein tumhin virajat | Tihun lok mein danka bajat ||\n" +
                            "You are the presiding Supreme Deity in Nagarkot. The drum of Your absolute cosmic glory beats loudly across all three worlds.\n\n" +
                            "Shumbh Nishumbh danav tum mare | Raktabeej shankhan samhare ||\n" +
                            "You brutally slaughtered the terrifying demons Shumbha and Nishumbha. You completely annihilated Raktabija and Shankhasura.\n\n" +
                            "Mahishasur nrip ati abhimani | Jehi agh bhar mahi akulani ||\n" +
                            "Mahishasura was an exceptionally arrogant demon king, under the heavy burden of whose horrific sins the Earth suffered terribly.\n\n" +
                            "Roop karal Kalika dhara | Sen sahit tum tihi samhara ||\n" +
                            "You assumed the fiercely terrifying and dark form of Goddess Kalika, and You ruthlessly slaughtered him along with his entire massive army.\n\n" +
                            "Pari gaarh santan par jab jab | Bhayi sahay Matu tum tab tab ||\n" +
                            "Whenever Your devoted saints and innocent beings faced terrible crises, O Mother, You immediately manifested to rescue and assist them.\n\n" +
                            "Amarpuri aru basav loka | Tab mahima sab rahein ashoka ||\n" +
                            "Strictly by Your grace, all the celestial realms and Amarpuri (Heaven) remain eternally sorrowless and perfectly safe.\n\n" +
                            "Jwala mein hai jyoti tumhari | Tumhein sada pujein nar nari ||\n" +
                            "Your divine, blazing light shines in the sacred flames of Jwalaji. Men and women perpetually worship You there with deep faith.\n\n" +
                            "Prem bhakti se jo yash gave | Dukh daridra nikat nahin ave ||\n" +
                            "Whosoever sings Your divine glory with pure love and devotion, sorrow and poverty can absolutely never come near them.\n\n" +
                            "Dhyave tumhein jo nar man lai | Janma maran takou chhuti jai ||\n" +
                            "The human being who meditates upon You with absolute, single-minded concentration is permanently freed from the agonizing cycle of birth and death.\n\n" +
                            "Jogi sur muni kehat pukari | Yog na ho bin shakti tumhari ||\n" +
                            "Great yogis, gods, and sages openly and loudly declare that without Your cosmic energy (Shakti), no yoga or penance can ever be successful.\n\n" +
                            "Shankar Acharaj tap kino | Kaam krodh jeeti sab lino ||\n" +
                            "Adi Shankaracharya performed incredibly intense penance, and through it, he conquered lust and anger entirely.\n\n" +
                            "Nishidin dhyan dharo Shankar ko | Kahu kaal nahin sumiro tumko ||\n" +
                            "Once, he meditated exclusively on Lord Shiva day and night, but neglected to remember and invoke You (The Divine Mother).\n\n" +
                            "Shakti roop ko maram na payo | Shakti gayi tab man pachhtayo ||\n" +
                            "He did not initially grasp the profound mystery of Your 'Shakti' form. But when his strength completely vanished, his mind deeply repented.\n\n" +
                            "Sharnagat hui kirti bakhani | Jai Jai Jai Jagadamb Bhavani ||\n" +
                            "Taking complete refuge at Your feet, he then sang Your magnificent glory, chanting 'Victory, Victory, Victory to Mother Jagadamba Bhavani!'\n\n" +
                            "Bhayi prasann Aadi Jagadamba | Dayi shakti nahin kin vilamba ||\n" +
                            "The primordial Mother Jagadamba was instantly pleased. She fully restored his power without a single moment's delay.\n\n" +
                            "Moko Matu kasht ati ghero | Tum bin kaun harai dukh mero ||\n" +
                            "O Mother! I am currently surrounded by extreme, suffocating hardships. Other than You, who else can possibly remove my sorrows?\n\n" +
                            "Asha trishna nipat satavein | Moh madadik sab binshavein ||\n" +
                            "Vain hopes and worldly desires constantly torment me. Please completely destroy my deep delusion, ego, and greed.\n\n" +
                            "Shatru nash kije Maharani | Sumiron ikchit tumhein Bhavani ||\n" +
                            "O Great Queen! Please annihilate all my inner and outer enemies. Let me remember You, O Bhavani, with absolute, undivided devotion.\n\n" +
                            "Karo kripa hey Matu dayala | Riddhi-siddhi dai karahu nihala ||\n" +
                            "O compassionate Mother, bestow Your grace! Bless me with ultimate prosperity and spiritual perfection, making my life totally fulfilled.\n\n" +
                            "Jab lagi jiun daya phal paun | Tumhro yash main sada sunaun ||\n" +
                            "As long as I live, may I continuously receive the fruits of Your mercy. May I always recite and spread Your magnificent glory.\n\n" +
                            "Durga Chalisa jo koi gave | Sab sukh bhog parampad pave ||\n" +
                            "Whosoever chants this sacred Durga Chalisa shall enjoy all the supreme comforts of this life and ultimately attain the highest state of liberation (Moksha).\n\n" +
                            "Devidas sharan nij jaani | Karahu kripa Jagadamb Bhavani ||\n" +
                            "Knowing Devidas (the author/devotee) to be securely under Your shelter, please shower Your endless grace upon me, O Mother Jagadamba Bhavani!",
                    fontSize = 15.sp,
                    color = Color(0xFF424242),
                    lineHeight = 22.sp
                )
            }
        }
    }
}