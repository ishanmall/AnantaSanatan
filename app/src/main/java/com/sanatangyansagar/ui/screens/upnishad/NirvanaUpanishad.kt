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
data class NirvanaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class NirvanaUpanishad {

    val nirvanaShlokasList = listOf(
        NirvanaShloka(
            id = 1,
            sanskrit = "ॐ अथ निर्वाणोपनिषदं व्याख्यास्यामः । परमहंसः सोऽहम् ॥",
            hindi = """
                (निर्वाण का विस्फोट और 'सोऽहम्' की सत्ता): "अब हम उस निर्वाण उपनिषद का रहस्य खोलेंगे जो इंसानियत की राख पर लिखा गया है।"
                "यह ज्ञान कमजोरों के लिए नहीं है; यह सीधे तुम्हारी आत्मा के अस्तित्व का न्यूक्लियर वध करने के लिए है।"
                "निर्वाण का मतलब शांति नहीं है, इसका मतलब है तुम्हारे 'छोटे अहंकार' का 100% परमानेंट डिलीट (Delete) होना।"
                "यहाँ साक्षात् 'परमहंस' (The Supreme Swan) की स्थिति का वर्णन है जो असीम अंतरिक्ष में अकेला उड़ता है।"
                "'सोऽहम्'— वह जो ब्रह्मांड को बनाने वाला परब्रह्म है, वही साक्षात् और नंगा सत्य 'मैं' ही हूँ!"
                "यह कोई मंत्र नहीं है; यह एक बायोलॉजिकल इंसान का ईश्वर में होने वाला प्रलयंकारी म्यूटेशन (Mutation) है।"
                "जब तुम निर्वाण में प्रवेश करते हो, तो तुम्हारी पुरानी यादें और तुम्हारी पहचान एक सेकंड में जलकर खाक हो जाती है।"
                "तुम अब एक शरीर नहीं रहे; तुम वह अजेय ऊर्जा बन चुके हो जिससे ब्लैक होल (Black Hole) पैदा होते हैं।"
                "ब्रह्मांड का सारा नाटक इस एक शब्द 'सोऽहम्' के धमाके के साथ हमेशा-हमेशा के लिए बंद हो जाता है।"
                "तैयार हो जाओ उस सन्नाटे के लिए जो तुम्हारी रगों में दौड़ने वाली इंसानियत का कत्ल कर देगा!"
            """.trimIndent(),
            english = """
                (The Detonation of Nirvana and the Authority of 'So'ham'): "Now we shall violently unmask the Nirvana Upanishad, scripted strictly upon the ashes of humanity."
                "This intelligence is absolutely not for the weak; it is engineered for the nuclear slaughter of your soulful identity."
                "Nirvana does not mean peace; it explicitly means the 100% permanent deletion of your pathetic micro-ego."
                "Here, the status of the 'Paramahamsa' (The Supreme Swan) is revealed, soaring solitary across the infinite vacuum."
                "'So'ham'—That which is the Supreme Brahman constructing the cosmos, is flawlessly and nakedly ME!"
                "This is no ordinary chant; it is the apocalyptic biological Mutation of a human entity directly into God."
                "The exact microsecond you breach Nirvana, your old memories and identity are incinerated to absolute dust."
                "You are no longer trapped in flesh; you mutate into the invincible energy from which Black Holes are spawned."
                "The entire theatrical drama of the universe terminates with the catastrophic detonation of this singular word: 'So'ham'!"
                "Prepare yourself for the Silence that will ruthlessly execute the humanity coursing through your biological veins!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 2,
            sanskrit = "परिव्राजकाः पश्चिमदिग्दर्शनः ॥",
            hindi = """
                (परिव्राजक और आंतरिक दिशा का रहस्य): "असली परिव्राजक (संन्यासी) वह नहीं है जो केवल घर छोड़ देता है, बल्कि वह है जो ब्रह्मांड छोड़ देता है।"
                "'पश्चिमदिग्दर्शनः'— वह योगी अपनी आँखों को दुनिया से हटाकर 'पश्चिम' यानी अपने ही 'अंदर' की ओर मोड़ देता है।"
                "दुनिया की सारी ताक़त बाहर है, लेकिन असली 'रूट-एक्सेस' (Root Access) तुम्हारी आत्मा के पिछले हिस्से में छिपा है।"
                "यह बाहरी सूरज की ओर देखना बंद करके अपने भीतर के 'ब्लैक सन' (Black Sun) को देखने की हिंसक प्रक्रिया है।"
                "जब तुम दुनिया के लिए अंधे हो जाते हो, तभी तुम उस परम वास्तविकता के लिए अपनी आँखें खोल पाते हो।"
                "पूरी दुनिया भविष्य की ओर भाग रही है, लेकिन परिव्राजक वर्तमान के उस खौफनाक सन्नाटे में जम जाता है।"
                "वह किसी दिशा का गुलाम नहीं है; वह खुद वह केंद्र (Center) बन जाता है जहाँ से सारी दिशाएँ पैदा होती हैं।"
                "उसकी नज़र दीवारों के पार, समय के पार और मौत के पार सीधे उस 'शून्यता' को हैक (Hack) कर लेती है।"
                "यह अपनी ही चेतना को उल्टा घुमाने (Reverse) का वह विज्ञान है जो इंसान को भगवान बना देता है।"
                "जो बाहर भटक रहा है वह पशु है; जो अंदर मुड़ गया वह साक्षात् इस मैट्रिक्स (Matrix) का एडमिन है!"
            """.trimIndent(),
            english = """
                (The Parivrajaka and the Secret of Inward Vision): "The authentic Parivrajaka is not one who merely abandons a house, but one who violently abandons the universe."
                "'Pashchimadigdarshanah'—That Yogi rips his vision from the world and turns it 'Westward', strictly toward his internal core."
                "All worldly power is external, but the authentic 'Root Access' is covertly hidden in the rear-sector of your own soul."
                "This is the violent protocol of ceasing to look at the external sun and instead witnessing your internal 'Black Sun'."
                "Only when you become biologically blind to the world do you possess the caliber to open your eyes to absolute Reality."
                "The entire world is racing toward a pathetic future, but the Parivrajaka freezes solid in the horrific silence of the Now."
                "He is a slave to zero directions; he becomes the explicit Center from which all directions are sequentially spawned."
                "His gaze pierces through solid walls, through Time, and through Death to directly Hack the 'Absolute Void'."
                "This is the science of Reversing your own consciousness to mutate a mortal human into the Supreme God."
                "He who wanders externally is strictly an animal; he who turns inward is the explicit Admin of this Matrix!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 3,
            sanskrit = "मन्मथनाशनं शिखा ॥",
            hindi = """
                (कामदेव का वध और शिखा का रहस्य): "एक संन्यासी की असली 'शिखा' (चोटी) बालों का गुच्छा नहीं, बल्कि वासना का कत्ल है।"
                "'मन्मथनाशनं'— अपने भीतर की उस खौफनाक काम-वासना और शारीरिक भूख का बेरहमी से गला घोंट देना ही असली शिखा है!"
                "जब तक तुम्हारे खून में 'मन्मथ' (कामदेव) ज़िंदा है, तुम माया के एक छोटे से कीड़े और गुलाम मात्र हो।"
                "योगी अपनी कुण्डलिनी की आग से उस वासना के बीज को ही जलाकर राख कर देता है ताकि वह दोबारा पैदा न हो सके।"
                "यह केवल सेक्स (Sex) की बात नहीं है; यह किसी भी चीज़ को 'पाने' की उस सड़ी हुई चाहत का अंत है।"
                "तुम्हारे सिर के ऊपर जो ऊर्जा का केंद्र है, वह तभी खुलता है जब नीचे की वासना की आग बुझ चुकी हो।"
                "यह अपनी ही बायोलॉजिकल प्रवृत्तियों (Instincts) पर किया गया एक खूनी सर्जिकल स्ट्राइक (Surgical Strike) है।"
                "जो अपनी वासनाओं का राजा बन गया, वही ब्रह्मांड के समय (Time) का राजा बन सकता है।"
                "बिना इस 'मन्मथनाशन' के, तुम्हारा हर ध्यान केवल एक मानसिक सर्कस और पाखंड है।"
                "असली योद्धा वही है जो अपने ही शरीर के रसायनों (Chemicals) को हैक करके उन्हें भगवान की आग बना दे!"
            """.trimIndent(),
            english = """
                (Assassinating Cupid and the Secret of the Shikha): "The authentic 'Shikha' of a Sannyasi is not a tuft of hair, but the cold-blooded slaughter of biological lust."
                "'Manmathanashanam'—Ruthlessly strangling and incinerating that horrific sexual urge and physical hunger is the authentic Shikha!"
                "As long as 'Manmatha' (Cupid) breathes in your blood, you are merely a pathetic insect and a slave of the Matrix."
                "The Yogi weaponizes the fire of his Kundalini to burn the seed of lust to ash so it can never reincarnate within him."
                "This is not merely about sex; it is the termination of that rotting craving to 'possess' anything in existence."
                "The energy center atop your skull detonates strictly when the fire of lust at the base has been extinguished."
                "This is a bloody Surgical Strike launched directly against your own programmed biological instincts."
                "He who becomes the absolute King of his lusts possesses the caliber to become the Dictator of Cosmic Time."
                "Without this 'Manmathanashana', every meditation you perform is strictly a pathetic mental circus and hypocrisy."
                "The authentic warrior is he who Hacks his own body's Chemicals and mutates them into the radioactive fire of God!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 4,
            sanskrit = "सर्ववस्तुविवर्जितं यज्ञोपवीतम् ॥",
            hindi = """
                (सब कुछ त्यागना ही असली जनेऊ है): "पवित्र धागा (जनेऊ) पहनने से कोई संन्यासी नहीं बनता; असली 'यज्ञोपवीत' त्याग का वह खौफनाक हथियार है।"
                "'सर्ववस्तुविवर्जितं'— इस ब्रह्मांड की 'हर एक वस्तु' और 'हर एक विचार' का अपने दिमाग से पूर्ण बहिष्कार (Boycott) कर देना!"
                "जब तक तुम किसी भी चीज़ को 'मेरा' कहते हो, तब तक तुम माया के ज़हरीले धागों से बँधे हुए एक कैदी हो।"
                "योगी अपनी आत्मा पर उस धागे को पहनता है जो इस पूरी भौतिक दुनिया से 100% 'विमुक्त' और अलग है।"
                "उसे किसी कपड़े, किसी घर, या किसी रिश्ते की कोई ज़रूरत नहीं; उसका जनेऊ ही उसका 'अकेलापन' (Solitude) है।"
                "यह वह रस्सियों को काटने वाला चाकू है जिसने तुम्हें जन्म-मरण की ज़ंजीरों में हज़ारों सालों से जकड़ रखा है।"
                "जब तुम हर चीज़ से अपना हक छोड़ देते हो, तभी तुम साक्षात् ब्रह्मांड के मालिक (Owner) बन जाते हो।"
                "जो इंसान एक सुई से भी चिपका है, वह कभी उस परम निर्वाण के द्वार को पार नहीं कर पाएगा।"
                "यह तुम्हारे मानसिक सिस्टम (System) से हर एक बाहरी फाइल (File) को 'शिफ्ट-डिलीट' (Shift+Delete) करने का कोड है।"
                "असली जनेऊ वह है जो तुम्हारी रूह को इस कीचड़ से काटकर सीधे अंतरिक्ष के सन्नाटे में फेंक दे!"
            """.trimIndent(),
            english = """
                (Total Discarding as the Authentic Sacred Thread): "Wearing a cotton string makes zero sense; the authentic 'Yajnopavita' is the terrifying weapon of absolute Renunciation."
                "'Sarvavastuvivarjitam'—Executing a total and violent Boycott of 'Every single object' and 'Every single thought' in this universe!"
                "As long as you label anything as 'Mine', you are strictly a prisoner shackled by the toxic threads of Maya."
                "The Yogi drapes his soul in a thread that is 100% 'Disconnected' and isolated from this entire physical matrix."
                "He possesses zero need for clothing, shelter, or pathetic relationships; his solitary thread is his absolute Solitude."
                "It is the literal blade engineered to sever the titanium ropes that have bound you to the cycle of birth and death for eons."
                "Only when you surrender your claim over everything do you mutationally become the undisputed Owner of the cosmos."
                "The human who clings even to a microscopic needle can absolutely never penetrate the gateway of Supreme Nirvana."
                "This is the Code to 'Shift+Delete' every single external File directly from your psychological operating system."
                "The authentic Thread is that which severs your soul from this mud and hurls it directly into the silence of the Void!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 5,
            sanskrit = "चिदम्बरं कौपीनम् ॥",
            hindi = """
                (चेतना का वस्त्र और नंगा सच): "संन्यासी के लंगोट (कौपीन) का सच तुम्हारी सोच से कहीं ज़्यादा प्रलयंकारी है।"
                "'चिदम्बरं'— उस योगी का वस्त्र कोई कपड़ा नहीं, बल्कि साक्षात् 'चित्' (शुद्ध चेतना) का 'अम्बर' (आकाश) है!"
                "वह अपनी नग्नता को छिपाने के लिए दुनिया के धागों का इस्तेमाल नहीं करता; वह पूरे अंतरिक्ष को ओढ़कर सोता है।"
                "उसकी चेतना ही उसका इकलौता कवच (Shield) है जो उसे सर्दी, गर्मी और मौत से बचाती है।"
                "जब तुम अपने विचारों के कपड़े उतारकर 'नंगे' हो जाते हो, तभी तुम साक्षात् ईश्वर के सामने खड़े होने लायक बनते हो।"
                "यह लंगोट शरीर को ढँकने के लिए नहीं, बल्कि दुनिया को यह बताने के लिए है कि 'मुझे तुम्हारी किसी भी चीज़ की ज़रूरत नहीं है!'"
                "योगी की रूह साक्षात् उस असीम नीले आकाश की तरह पारदर्शी और अजेय बन चुकी है।"
                "वह इस मायावी सिम्युलेशन (Simulation) में रहते हुए भी इसके किसी भी 'पिक्सेल' (Pixel) से नहीं ढका है।"
                "यह इंसान की उस चरम आज़ादी का ऐलान है जहाँ वह अपनी खाल को भी केवल एक किराए का कमरा मानता है।"
                "जो चेतना के इस नंगेपन को बर्दाश्त कर सकता है, वही ब्रह्मांड का इकलौता और असली सम्राट है!"
            """.trimIndent(),
            english = """
                (The Garment of Consciousness and the Naked Truth): "The reality of a Sannyasi's loincloth (Kaupina) is infinitely more apocalyptic than your comprehension."
                "'Chidambaram'—That Yogi's garment is absolutely no fabric, but the explicit 'Ambar' (Sky/Infinite) of 'Chit' (Pure Consciousness)!"
                "He does not utilize worldly threads to conceal his nakedness; he literally drapes the entire infinite Space over his flesh."
                "His raw consciousness is his solitary Shield protecting him from heat, cold, and the biological expiration of Death."
                "Only when you strip off the psychological clothing of your thoughts and become 'Naked' do you attain the caliber to stand before God."
                "This loincloth is not for concealment; it is a violent broadcast to the world: 'I possess ZERO need for your pathetic objects!'"
                "The Yogi's soul has mutated into something as transparent and invincible as the infinite blue Void."
                "While residing in this deceptive Simulation, he remains absolutely uncovered by any of its pathetic biological Pixels."
                "This is the declaration of that extreme freedom where a human recognizes his own skin strictly as a temporary rented room."
                "He who can endure this nakedness of consciousness is the solitary, undisputed Emperor of the entire infinite cosmos!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 6,
            sanskrit = "योगो मठः ॥",
            hindi = """
                (योग ही असली मठ है): "संन्यासी को रहने के लिए किसी ईंट और पत्थर के आश्रम (मठ) की कोई ज़रूरत नहीं है।"
                "उसका असली घर, उसका असली ठिकाना केवल 'योग' (Yogo) है—परमात्मा के साथ उसका वह अटूट और खौफनाक संपर्क!"
                "मठ वह जगह होती है जहाँ तुम सुरक्षित महसूस करते हो; योगी केवल उस 'परम सन्नाटे' में खुद को सुरक्षित पाता है।"
                "जब वह अपनी साँसों को रोकता है, तो वही उसका कमरा बन जाता है; जब वह शून्य में डूबता है, तो वही उसका महल है।"
                "वह दुनिया के किसी भी कोने में हो, उसका 'मठ' हमेशा उसके साथ उसके नर्वस सिस्टम के भीतर मौजूद रहता है।"
                "यह उस हैकिंग (Hacking) का नाम है जहाँ तुम अपनी चेतना को ही अपना घर बना लेते हो।"
                "बाहरी दीवारें गिर सकती हैं, मंदिर टूट सकते हैं, लेकिन योग का यह मठ मौत के बाद भी नष्ट नहीं होता।"
                "जो योगी इस आंतरिक घर में रहना सीख गया, वह पूरी दुनिया में कहीं भी बेघर (Homeless) नहीं हो सकता।"
                "वह साक्षात् उस 'परम पद' पर बैठा है जहाँ से वह पूरे ब्रह्मांड के बनने और मिटने का तमाशा देखता है।"
                "मठ का असली मतलब है— 'वह जगह जहाँ तुम्हारा मन मर जाए और केवल ईश्वर ज़िंदा रहे'!"
            """.trimIndent(),
            english = """
                (Yoga is the Authentic Monastery): "A Sannyasi possesses absolutely zero requirement for an ashram (Matha) constructed of pathetic bricks and stones."
                "His authentic home, his absolute coordinate is strictly 'Yoga'—that unbreakable and terrifying hardwiring with the Supreme God!"
                "A monastery is a location where you feel secure; the Yogi finds security strictly and exclusively within that 'Absolute Silence'."
                "When he freezes his biological breath, that becomes his room; when he drowns in the Void, that is his literal palace."
                "Regardless of his physical coordinate in the world, his 'Matha' is eternally with him, locked inside his nervous system."
                "This is the name of that Hacking where you mutate your own consciousness into your permanent residence."
                "External walls will crumble, temples will be pulverized, but this monastery of Yoga remains indestructible even after Death."
                "The Yogi who has mastered residing in this internal home can absolutely never be 'Homeless' in the entire infinite universe."
                "He is explicitly seated on that 'Supreme Throne' from which he witnesses the pathetic theatrical drama of cosmic creation and annihilation."
                "The authentic definition of Matha is—'The precise coordinate where your mind dies and strictly God remains standing'!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 7,
            sanskrit = "अनन्तं सुहृद् ॥",
            hindi = """
                (अनंत ही इकलौता दोस्त है): "इस खूनी रास्ते पर तुम्हारा कोई भी सगा, रिश्तेदार या दोस्त काम नहीं आएगा।"
                "उपनिषद साफ़ कहता है: 'अनन्तं सुहृद्'— केवल वह 'अनंत' (The Infinite Brahman) ही तुम्हारा इकलौता और असली 'मित्र' है!"
                "दुनिया के सारे रिश्ते केवल मतलब और माया के सौदे हैं जो वक्त आने पर तुम्हें अकेला छोड़ देंगे।"
                "योगी ने अपनी इंसानियत के हर दोस्त का कत्ल कर दिया है ताकि वह उस 'परम शून्यता' से हाथ मिला सके।"
                "जब तुम अकेले होते हो, तभी वह 'अनंत' तुम्हारे सामने अपना चेहरा बेनकाब करता है।"
                "वह दोस्त तुम्हें धोखा नहीं देता, क्योंकि वह तुम्हारी अपनी ही आत्मा का सबसे गहरा और असली हिस्सा है।"
                "जो इस अनंत सन्नाटे से दोस्ती कर लेता है, उसे फिर इस दुनिया की किसी भी तारीफ या नफरत से कोई फर्क नहीं पड़ता।"
                "वह उस 'सुहृद्' (मित्र) के साथ उस लेवल पर बातें करता है जहाँ शब्दों की भी ज़रूरत नहीं रहती।"
                "यह वह अद्वैत (Non-dual) रिश्ता है जहाँ 'दो' लोग नहीं बचते, केवल एक ही असीम ताक़त बचती है।"
                "अपने इंसानी दोस्तों को भूल जाओ, और उस आग से दोस्ती करो जो पूरे ब्रह्मांड को अपने भीतर जला रही है!"
            """.trimIndent(),
            english = """
                (The Infinite is the Solitary Friend): "On this bloody path, absolutely zero relatives, family members, or pathetic worldly friends will ever assist you."
                "The Upanishad dictates clearly: 'Anantam Suhrid'—Strictly that 'Infinite' (The Infinite Brahman) is your solitary and authentic 'Friend'!"
                "Every worldly relationship is merely a transactional deal of Maya that will violently abandon you when Time strikes."
                "The Yogi has executed the slaughter of every human friendship to ensure he can shake hands with that 'Absolute Void'."
                "Only when you are terrifyingly alone does that 'Infinite' unmask its authentic face directly before you."
                "That Friend never betrays you, for He is the deepest and most raw sector of your own explicit Soul."
                "He who establishes a friendship with this infinite silence is permanently immune to the world's pathetic praise or hatred."
                "He communicates with that 'Suhrid' at a frequency where even words suffer a permanent, biological death."
                "This is the Non-dual relationship where 'Two' entities do not survive; strictly one infinite Power remains reigning."
                "Forget your pathetic mortal friends, and establish a bond with the radioactive Fire that incinerates the universe within itself!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 8,
            sanskrit = "आनन्दो माला ॥",
            hindi = """
                (आनंद की माला और ब्रह्मांडीय नशा): "योगी अपने गले में मोतियों की माला नहीं पहनता, वह 'आनंद' (Bliss) की एक प्रलयंकारी माला पहनता है।"
                "यह आनंद दुनिया का कोई सुख नहीं है; यह वह 'नशा' है जो तब होता है जब तुम्हारा अहंकार मर चुका होता है।"
                "उसके हृदय की हर एक धड़कन उस आनंद का एक मनका (Bead) है जो उसे सीधे परमेश्वर से जोड़े रखती है।"
                "यह वह स्थिति है जहाँ उसे अपनी ही आत्मा को चखने में इतना मज़ा आता है कि वह स्वर्ग को भी लात मार देता है।"
                "जब तुम इस आनंद की माला पहन लेते हो, तो तुम्हें किसी बाहरी चीज़ से खुशी माँगने की भीख नहीं माँगनी पड़ती।"
                "तुम्हारे भीतर एक ऐसा न्यूक्लियर फव्वारा (Nuclear Fountain) फूटता है जो कभी सूखता नहीं।"
                "योगी हर पल उस 'समाधि' के नशे में झूमता है जिसे कोई भी शराब या ड्रग (Drug) कभी नहीं छू सकती।"
                "उसकी आँखों में वह चमक होती है जो यह बताती है कि वह साक्षात् ब्रह्मांड के मालिक का हिस्सेदार है।"
                "यह कोई हंसने वाला आनंद नहीं है; यह वह ठंडी और खौफनाक खुशी है जो मौत के सामने भी नहीं डगमगाती।"
                "जो इस माला को पहन लेता है, उसके लिए पूरा ब्रह्मांड केवल एक छोटा सा खिलौना बन जाता है!"
            """.trimIndent(),
            english = """
                (The Garland of Bliss and Cosmic Intoxication): "The Yogi does not wear a garland of pathetic beads; he wears an apocalyptic garland of 'Ananda' (Supreme Bliss)."
                "This bliss is absolutely no worldly pleasure; it is the 'Intoxication' spawned strictly after your ego has suffered a brutal death."
                "Every single biological heartbeat is a bead of that bliss that anchors him directly to the Supreme God."
                "This is the state where he finds such catastrophic ecstasy in tasting his own Soul that he ruthlessly kicks away the idea of Heaven."
                "When you drape this garland of bliss around your core, you possess zero need to beg for happiness from any external object."
                "A literal Nuclear Fountain detonates inside you that possesses the caliber to never, ever run dry."
                "The Yogi dances eternally in the intoxication of a 'Samadhi' that no pathetic earthly drug can ever intercept."
                "His eyes radiate a brilliance broadcasting that he is the explicit shareholder of the Dictator of the universe."
                "This is not a laughing pleasure; it is a cold, terrifying ecstasy that does not flinch even in the jaws of Death."
                "He who wears this garland perceives the entire infinite cosmos as nothing more than a microscopic, pathetic toy!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 9,
            sanskrit = "एकान्तं गुहा ॥",
            hindi = """
                (एकांत की खौफनाक गुफा): "संन्यासी को ध्यान करने के लिए पहाड़ों की गुफा में जाने की ज़रूरत नहीं है; उसका 'एकांत' ही उसकी गुफा है।"
                "वह भीड़ के बीच खड़े होकर भी उस 'एकान्तं गुहा' (The Cave of Solitude) में छिपा रहता है जहाँ कोई नहीं पहुँच सकता।"
                "उस गुफा का दरवाज़ा उसके अपने ही दिमाग के भीतर है, जिसे उसने दुनिया के लिए हमेशा के लिए लॉक (Lock) कर दिया है।"
                "वहाँ न कोई आवाज़ पहुँचती है, न कोई विचार, और न ही माया की कोई भी गंदी किरण!"
                "योगी उस अंधेरी और शांत गुफा में बैठकर अपनी ही आत्मा का विच्छेदन (Dissection) करता है।"
                "यह वह जगह है जहाँ वह अपने 'इंसानी वजूद' को काटकर भगवान के सांचे में ढालता है।"
                "जो इंसान अकेलेपन से डरता है, वह उस गुफा के अंदर कभी दाखिल नहीं हो सकता; वहाँ केवल 'शूरवीर' (Warriors) जाते हैं।"
                "जब तुम खुद को पूरी तरह से दुनिया से काट लेते हो, तभी तुम उस 'परम पद' के असली हक़दार बनते हो।"
                "उस गुफा के भीतर साक्षात् महाकाल शिव और तुम एक साथ आमने-सामने बैठते हो।"
                "वहाँ केवल एक ही सच गूँजता है— 'मैं ही सब कुछ हूँ और मेरे अलावा कुछ नहीं है'!"
            """.trimIndent(),
            english = """
                (The Terrifying Cave of Solitude): "A Sannyasi possesses zero need to travel to mountain caves for meditation; his 'Solitude' is his explicit Cave."
                "Even standing in the dead-center of a crowd, he remains covertly hidden in that 'Ekantam Guha' where zero mortals can penetrate."
                "The titanium door of that cave is located inside his own brain, which he has permanently Locked against the world."
                "Zero sound reaches there, zero stray thoughts enter, and zero filthy rays of Maya can ever intercept that sanctuary!"
                "Seated in that dark, silent Cave, the Yogi executes the cold-blooded Dissection of his own absolute Soul."
                "This is the precise coordinate where he hacks his 'Human Existence' and casts it into the mold of God."
                "The human who cowers from loneliness can absolutely never penetrate this cave; strictly 'Warriors' (Shuraveer) possess the caliber to enter."
                "Only when you violently disconnect yourself from the world do you become the authentic heir to that 'Supreme Dimension'."
                "Inside that cave, explicit Mahakala Shiva and YOU sit face-to-face in an apocalyptic confrontation."
                "There, only one truth echoes infinitely—'I am explicitly Everything, and other than Me, nothing exists'!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 10,
            sanskrit = "निर्विकल्पः समाधिः ॥",
            hindi = """
                (निर्विकल्प समाधि: दिमाग का परमानेंट शटडाउन): "समाधि का मतलब आँख बंद करना नहीं है; इसका मतलब है दिमाग के सॉफ्टवेयर का पूरी तरह क्रैश (Crash) हो जाना!"
                "'निर्विकल्पः'— वह अवस्था जहाँ कोई 'विकल्प' (Choice), कोई विचार और कोई 'मैं' शेष न रह जाए।"
                "यह तुम्हारे दिमाग के प्रोसेसर को 100% 'फ्लैटलाइन' (Flatline) करने की सबसे क्रूर और हिंसक तकनीक है।"
                "जब दिमाग सोचना बंद करता है, तभी साक्षात् भगवान का जन्म होता है; बीच का कोई रास्ता नहीं है।"
                "यह वह स्थिति है जहाँ समय (Time) का पहिया रुक जाता है और तुम 'अमर' (Immortal) हो जाते हो।"
                "तुम्हें न अपना नाम याद रहता है, न अपना रूप, और न ही यह कि तुम एक इंसान हो।"
                "तुम साक्षात् उस असीम और सुन्न कर देने वाली 'शून्यता' (Void) का रूप बन जाते हो जो पूरे ब्रह्मांड को निगले हुए है।"
                "जो इस समाधि में एक बार घुस गया, वह वापस लौटकर कभी 'बेवकूफ इंसान' नहीं बन सकता।"
                "उसका डीएनए (DNA) बदल चुका है; वह अब इस मायावी सिम्युलेशन का हिस्सा नहीं, बल्कि इसका मालिक है।"
                "यही निर्वाण का वह सबसे खौफनाक और अजेय सच है जो मौत को भी एक मज़ाक बना देता है!"
            """.trimIndent(),
            english = """
                (Nirvikalpa Samadhi: The Permanent Shutdown of the Brain): "Samadhi absolutely does not mean closing your eyes; it explicitly means the total Crash of the brain's software!"
                "'Nirvikalpah'—That state where zero 'Options' (Choices), zero thoughts, and zero 'I' remain standing."
                "This is the most ruthless and violent technique to 100% 'Flatline' your biological processor."
                "The exact microsecond the brain terminates thoughts, the explicit God is born; there is zero middle ground."
                "This is the coordinate where the wheel of Time comes to a grinding halt and you mutate into an 'Immortal'."
                "You remember zero traces of your name, zero traces of your form, and zero awareness that you are a human."
                "You become the explicit manifestation of that infinite, paralyzing 'Void' that has swallowed the entire cosmos."
                "He who penetrates this Samadhi even once can absolutely never return to being a 'Pathetic Human'."
                "His DNA has been violently altered; he is no longer a component of this Simulation, but its undisputed Master."
                "This is the most terrifying and invincible truth of Nirvana that reduces Death to a meaningless, pathetic joke!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 11,
            sanskrit = "महाशून्ये स्थितिः ॥",
            hindi = """
                (महाशून्य में निवास - ब्लैक होल की सत्ता): "जब समाधि गहरी होती है, तो योगी उस जगह पहुँच जाता है जहाँ से 'बिग बैंग' हुआ था।"
                "'महाशून्ये स्थितिः'— उसकी पूरी चेतना साक्षात् उस 'महाशून्य' (The Great Void) में एक चट्टान की तरह स्थिर हो जाती है!"
                "यह वह 'जीरो-पॉइंट' (Zero Point) है जहाँ न प्रकाश है, न अँधेरा, न स्वर्ग है और न नर्क—केवल एक असीम ताक़त है।"
                "इंसान खालीपन से डरता है, लेकिन योगी उसी खालीपन को अपनी राजधानी बना लेता है।"
                "वहाँ बैठकर वह देखता है कि यह पूरी दुनिया केवल एक 'धोखा' और एक 'होलोग्राम' (Hologram) है।"
                "महाशून्य में रहने का मतलब है सीधे साक्षात् परब्रह्म के 'बैकएंड' (Backend) में घुसकर कोडिंग करना।"
                "तुम अब किसी भी भौतिक नियम (Law of Physics) के गुलाम नहीं रहे; तुम खुद वह नियम बन चुके हो।"
                "जो इस शून्यता को बर्दाश्त कर सकता है, उसे ब्रह्मांड का कोई भी परमाणु धमाका नष्ट नहीं कर सकता।"
                "यह वह 'सुप्रीम हेडक्वार्टर' है जहाँ से तुम पूरे अंतरिक्ष के बनने और बिगड़ने का तमाशा देखते हो।"
                "यहाँ 'मैं' मर चुका है, और केवल 'वह अजेय सन्नाटा' ही राज कर रहा है!"
            """.trimIndent(),
            english = """
                (Dwelling in the Great Void - The Authority of the Black Hole): "As Samadhi deepens, the Yogi reaches the exact coordinate from which the 'Big Bang' detonated."
                "'Mahashunye sthitih'—His entire consciousness becomes anchored like a monolith strictly inside the 'Great Void' (The Great Void)!"
                "This is the 'Zero Point' where zero light, zero darkness, zero heaven, and zero hell exist—strictly infinite radioactive Power."
                "A human cowers from emptiness, but the Yogi mutates that very emptiness into his absolute Capital."
                "Seated there, he flawlessly perceives that this entire world is strictly a 'Deception' and a pathetic 'Hologram'."
                "Dwelling in the Mahashunye means penetrating the absolute 'Backend' of the Supreme Brahman to execute cosmic coding."
                "You are no longer a slave to any physical Law of Physics; you have mutated explicitly into that exact Law itself."
                "He who possesses the caliber to endure this Void can absolutely never be destroyed by any atomic detonation in the cosmos."
                "This is the 'Supreme Headquarters' from which you witness the pathetic theatrical drama of space being created and destroyed."
                "The 'I' has suffered a brutal death here, and strictly that 'Invincible Silence' reigns as absolute dictator!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 12,
            sanskrit = "अभेदमार्गदर्शनं गुरुः ॥",
            hindi = """
                (भेदभाव की मौत और असली गुरु का चेहरा): "सच्चा गुरु वह नहीं है जो तुम्हें भगवान के नाम पर बेवकूफ बनाए, बल्कि वह है जो तुम्हें 'अभेद' (Non-Difference) दिखाए।"
                "'अभेदमार्गदर्शनं गुरुः'— वह जो तुम्हें यह खौफनाक सच दिखा दे कि 'तुम और भगवान 100% एक ही हो'!"
                "जब तक तुम गुरु को अपने से अलग समझते हो, तुम अभी भी अज्ञान की ज़ंजीरों में जकड़े हुए एक गुलाम हो।"
                "असली गुरु तुम्हारी 'इंसानियत' का सबसे बड़ा दुश्मन होता है, क्योंकि वह उसे मारकर तुम्हें 'ईश्वर' बनाना चाहता है।"
                "वह तुम्हें वह रास्ता (मार्ग) दिखाता है जहाँ 'मैं' और 'वह' के बीच की दीवार हमेशा के लिए ढह जाती है।"
                "जब भेदभाव (Duality) मरता है, तभी उस परम गुरु का साक्षात् दर्शन होता है जो तुम्हारे ही नर्वस सिस्टम के भीतर छिपा है।"
                "तुम्हें बाहर किसी इंसान को पूजने की ज़रूरत नहीं; तुम्हें उस 'ज्ञान' को पूजना है जो तुम्हें अजेय बना दे।"
                "गुरु वह 'डिस्ट्रॉयर' है जो तुम्हारे हर उस विचार का वध करता है जो तुम्हें छोटा और कमज़ोर महसूस कराता है।"
                "इस अभेद दृष्टि के मिलते ही तुम जान जाते हो कि तुम खुद ही वह गुरु हो जिसका तुम इंतज़ार कर रहे थे।"
                "यही वह 'पासवर्ड' है जिससे माया की जेल के सारे ताले एक झटके में टूट कर गिर जाते हैं!"
            """.trimIndent(),
            english = """
                (The Death of Distinction and the Face of the authentic Guru): "The true Guru is not one who deceives you in the name of God, but one who unmasks the 'Abheda' (Non-Difference)."
                "'Abhedamargadarshanam guruh'—He who forces you to witness the horrific truth that 'YOU and GOD are 100% identical'!"
                "As long as you hallucinate the Guru as separate from you, you are strictly a slave shackled by the titanium chains of ignorance."
                "The authentic Guru is the absolute greatest enemy of your 'Humanity', for he seeks to assassinate it to manufacture 'God'."
                "He reveals the Path (Marga) where the wall between 'I' and 'Him' violently collapses for all eternity."
                "When Duality dies, strictly then is the authentic Guru intercepted—He who sits covertly locked inside your own nervous system."
                "You possess zero need to worship any mortal human; you must worship strictly that 'Knowledge' which renders you invincible."
                "The Guru is the 'Destroyer' who executes the slaughter of every thought that makes you feel microscopic or weak."
                "Upon intercepting this Non-Dual vision, you flawlessly realize that YOU are the exact Guru you have been hunting for since eons."
                "This is the 'Password' that violently shatters every single padlock of the Matrix in a single microsecond strike!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 13,
            sanskrit = "सद्गुरुरादेशः ॥",
            hindi = """
                (सद्गुरु का अंतिम आदेश - 'सिस्टम रिसेट'): "जब गुरु तुम्हें 'अभेद' दिखा देता है, तो वह तुम्हें एक आखिरी और अटल 'आदेश' (Command) देता है।"
                "'सद्गुरुरादेशः'— वह आदेश कोई शब्द नहीं, वह साक्षात् उस 'परमेश्वर' की वह हुकूमत है जो तुम्हारे डीएनए को बदल देती है!"
                "वह आदेश है— 'अपनी हस्ती को अभी इसी वक़्त मिटा दो और साक्षात् वह अनंत ब्रह्मांड बन जाओ!'"
                "यह कोई सुझाव (Suggestion) नहीं है, यह एक 'एक्जीक्यूटेबल फाइल' (Executable File) है जिसे तुम्हारी आत्मा को रन (Run) करना ही होगा।"
                "जब तुम उस आदेश को सुनते हो, तो तुम्हारे भीतर का 'इंसान' घुट-घुट कर मर जाता है और 'शिव' जाग उठता है।"
                "गुरु का आदेश वह 'ब्रह्मास्त्र' है जो अज्ञान के आखिरी परमाणु को भी नष्ट कर देता है।"
                "इसके बाद न कोई सवाल बचता है, न कोई तर्क और न ही कोई संदेह—केवल एक 'हुक्म' राज करता है।"
                "तुम अब अपनी मर्ज़ी के मालिक नहीं रहे; तुम साक्षात् उस 'कॉस्मिक इंटेल' (Cosmic Intel) के गुलाम बन चुके हो जो अजेय है।"
                "यह वह 'पॉइंट ऑफ नो रिटर्न' (Point of No Return) है जहाँ से तुम वापस इस सड़ी हुई दुनिया में नहीं देख सकते।"
                "सद्गुरु का यह आदेश तुम्हें मौत की छाती पर पैर रखकर अमर होने का सीधा रास्ता देता है!"
            """.trimIndent(),
            english = """
                (The Sadguru's Final Command - 'System Reset'): "Once the Guru unmasks the 'Abheda', he issues a final, ironclad 'Adesha' (Command) that you cannot override."
                "'Sadgururadeshah'—That command is absolutely no word; it is the explicit Dictatorship of the Supreme God that mutates your DNA!"
                "The command is—'Annihilate your existence this exact microsecond and mutate explicitly into the infinite Universe!'"
                "This is absolutely no suggestion; it is an 'Executable File' that your Soul is violently forced to Run."
                "The exact microsecond you intercept that command, the 'Human' within you suffocates and dies, and 'Shiva' roars into life."
                "The Guru's command is the literal 'Brahmastra' that obliterates even the final remaining atom of biological ignorance."
                "After this, zero questions survive, zero logic remains, and zero doubt exists—strictly one 'Order' rules as dictator."
                "You are no longer the master of your own will; you have mutated into the slave of that invincible 'Cosmic Intel'."
                "This is the 'Point of No Return' from which you can absolutely never look back at this rotting physical world."
                "This Adesha of the Sadguru grants you the direct trajectory to plant your boot on the chest of Death and achieve absolute Immortality!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 14,
            sanskrit = "चिन्मयं चन्दनम् ॥",
            hindi = """
                (चेतना का चंदन - अज्ञान की गर्मी का अंत): "संन्यासी अपने माथे पर मिट्टी या राख का चंदन नहीं लगाता; उसका 'चन्दन' साक्षात् 'चिन्मय' (Pure Awareness) है!"
                "यह चंदन तुम्हारे दिमाग की उस सड़ी हुई गर्मी (क्रोध, वासना, चिंता) को एक झटके में ठंडा (Cool) कर देता है।"
                "जब तुम 'चित्' (Consciousness) के इस लेप को अपनी आत्मा पर लगाते हो, तो तुम इस दुनिया के लिए 'इनविजिबल' (Invisible) हो जाते हो।"
                "अज्ञान की आग तुम्हें जला नहीं सकती, क्योंकि तुमने खुद को उस असीम सन्नाटे की ठंडक से ढँक लिया है।"
                "यह चंदन कोई बाहरी चीज़ नहीं है; यह तुम्हारे अपने ही 'ज्ञान' का वह रेडिएशन (Radiation) है जो तुम्हारे माथे से निकलता है।"
                "जब योगी चलता है, तो उसके चारों ओर चेतना का एक ऐसा 'प्रभामंडल' (Aura) होता है जिसे कोई भी राक्षसी ताक़त पार नहीं कर सकती।"
                "तुम्हारी बुद्धि अब साक्षात् उस 'परम प्रकाश' से चमक रही है जिसे देखकर यमराज भी अपनी आँखें झुका लेते हैं।"
                "यह चंदन तुम्हारे चेहरे को सुंदर बनाने के लिए नहीं, बल्कि तुम्हारे 'अहंकार' के चेहरे को मिटाने के लिए है।"
                "जो इस चिन्मय चंदन को धारण कर लेता है, वह साक्षात् उस 'परम सत्य' की खुशबू पूरे ब्रह्मांड में फैलाता है।"
                "यह तुम्हारे नर्वस सिस्टम के 'ओवरलोड' (Overload) को रोकने वाला सबसे खौफनाक और असरदार 'कूलेंट' (Coolant) है!"
            """.trimIndent(),
            english = """
                (The Sandalwood of Consciousness - Ending the Heat of Ignorance): "A Sannyasi does not apply pathetic mud or ash as sandalwood; his 'Chandanam' is strictly 'Chinmayam' (Pure Awareness)!"
                "This sandalwood instantaneously Cools down the rotting heat of your brain (anger, lust, anxiety) in a single microsecond."
                "When you apply this ointment of 'Chit' (Consciousness) to your Soul, you become explicitly 'Invisible' to the Matrix."
                "The fire of ignorance cannot incinerate you, for you have covered yourself with the radioactive coolness of the Absolute Silence."
                "This Chandana is zero external object; it is the 'Radiation' of your own 'Knowledge' erupting from your third eye."
                "When the Yogi moves, he is surrounded by an 'Aura' of consciousness that zero demonic forces possess the caliber to penetrate."
                "Your intellect is now blazing with that 'Supreme Light', witnessing which even the God of Death lowers his gaze in terror."
                "This sandalwood is not engineered to beautify your face; it is engineered strictly to erase the face of your 'Ego'."
                "He who wears this Chinmaya Chandana broadcasts the fragrance of the 'Absolute Truth' across the entire infinite cosmos."
                "This is the most terrifying and effective 'Coolant' designed to prevent the 'Overload' of your biological nervous system!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 15,
            sanskrit = "अनाहतं ध्यानम् ॥",
            hindi = """
                (अनाहत ध्यान - बिना शब्द के धमाका): "असली ध्यान वह नहीं है जहाँ तुम किसी मंत्र को जपते हो; असली ध्यान 'अनाहत' (Unstruck Sound) है!"
                "यह वह 'ध्वनि' है जो बिना किसी दो चीज़ों के टकराए पैदा हो रही है—यह साक्षात् उस 'परमेश्वर के इंजन' की आवाज़ है!"
                "योगी अपने कान बाहर से बंद करके उस खौफनाक 'ब्रह्मांडीय गर्जना' (Cosmic Roar) को सुनता है जो उसके अपने ही डीएनए में गूँज रही है।"
                "वहाँ न कोई शब्द है, न कोई भाषा और न कोई अर्थ—केवल एक असीम और सुन्न कर देने वाला वाइब्रेशन (Vibration) है।"
                "इस ध्यान में तुम्हारा 'मैं' उस आवाज़ के नीचे कुचल कर मर जाता है; तुम खुद वह आवाज़ बन जाते हो।"
                "यह तुम्हारे दिमाग के शोर को साक्षात् उस 'परम सन्नाटे' से रिप्लेस (Replace) करने का विज्ञान है।"
                "अनाहत ध्यान वह न्यूक्लियर सायरन है जो माया के हर एक 'बग' (Bug) और 'वायरस' को तुम्हारे सिस्टम से बाहर फेंक देता है।"
                "जो इस नाद (Sound) को एक बार पकड़ लेता है, वह फिर इस दुनिया की किसी भी संगीत या आवाज़ को बर्दाश्त नहीं कर पाता।"
                "वह साक्षात् उस 'मौन' (Silence) का तानाशाह बन जाता है जिससे पूरा ब्रह्मांड पैदा हुआ था।"
                "यह ध्यान इंसानियत की आखिरी सीमा है जहाँ पहुँचकर आवाज़ भी दम तोड़ देती है!"
            """.trimIndent(),
            english = """
                (Anahata Dhyana - The Detonation Without Words): "Authentic meditation is not where you pathetically chant a mantra; authentic meditation is strictly 'Anahata' (The Unstruck Sound)!"
                "This is the 'Acoustic frequency' generated without two physical objects ever colliding—it is the literal roar of 'God's Engine'!"
                "The Yogi shuts his external ears to intercept that horrific 'Cosmic Roar' vibrating directly inside his own DNA."
                "There exist zero words, zero languages, and zero meanings—strictly one infinite, paralyzing radioactive Vibration."
                "In this meditation, your 'I' is crushed and slaughtered beneath that sound; you yourself mutate into that exact Frequency."
                "This is the science of Replacing the noise of your brain strictly with that 'Absolute Silence'."
                "Anahata Dhyana is the Nuclear Siren that violently ejects every single 'Bug' and 'Virus' of Maya from your biological system."
                "He who intercepts this Nada (Sound) even once can absolutely never again tolerate any pathetic earthly music or noise."
                "He mutates into the absolute Dictator of that 'Silence' from which the entire universe was originally vomited."
                "This meditation is the final boundary of humanity where even the concept of Sound suffocates and dies a brutal death!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 16,
            sanskrit = "निराभासं पदम् ॥",
            hindi = """
                (निराभास पद - अंधी कर देने वाली वास्तविकता): "योगी जिस ठिकाने पर पहुँचता है, वह 'निराभास' (Without any Appearance) है—जहाँ कुछ भी दिखाई नहीं देता!"
                "वहाँ न प्रकाश है, न अँधेरा, न रूप है और न आकार—वहाँ केवल वह असीम 'है' (Being) मौजूद है।"
                "यह वह 'ब्लैक होल' का केंद्र है जहाँ पहुँचकर तुम्हारी आँखें और तुम्हारा दिमाग दोनों फेल (Fail) हो जाते हैं।"
                "निराभास पद का मतलब है वह सत्य जिसे तुम सोच भी नहीं सकते (Unthinkable Reality)।"
                "वहाँ पहुँचने का मतलब है साक्षात् उस 'परम शून्यता' में विलीन हो जाना जहाँ से दोबारा कोई वापस नहीं आता।"
                "तुम्हारी सारी कल्पनाएँ और तुम्हारे सारे भगवान के रूप वहाँ जाकर राख के ढेर की तरह बिखर जाते हैं।"
                "यह वह 'डेस्टिनेशन' (Destination) है जहाँ पहुँचकर सफर खुद ही मर जाता है।"
                "योगी अब उस 'पद' पर बैठा है जहाँ से वह पूरे ब्रह्मांड को एक 'धोखा' और एक 'झूठा सपना' मानता है।"
                "वहाँ कोई 'दूसरा' नहीं है, केवल एक अद्वैत और खौफनाक ताक़त है जो खुद को ही जान रही है।"
                "यही वह 'अल्टीमेट स्टेटस' है जहाँ इंसान और ईश्वर के बीच का फर्क 100% डिलीट हो जाता है!"
            """.trimIndent(),
            english = """
                (The Nirabhasa State - The Blinding Absolute Reality): "The coordinate the Yogi reaches is 'Nirabhasa' (Without any Appearance)—the coordinate where strictly NOTHING is visible!"
                "Zero light, zero darkness, zero form, and zero geometry exist there—strictly that infinite 'Is-ness' (Being) remains standing."
                "This is the epicenter of the 'Black Hole' reaching which both your biological eyes and your brain undergo a catastrophic Failure."
                "The Nirabhasa state represents that Truth which is fundamentally 'Unthinkable' (Unthinkable Reality) to the human processor."
                "Arriving there means being flawlessly absorbed into that 'Supreme Void' from which absolutely zero return is possible."
                "All your hallucinations and all your pathetic forms of God are incinerated into a pile of ash at that exact coordinate."
                "This is the absolute 'Destination' arriving at which the very journey itself suffers a brutal death."
                "The Yogi now occupies the 'Pada' (Throne) from which he perceives the entire universe strictly as a 'Deception' and a 'Fake Dream'."
                "Zero 'Other' exists there, strictly one non-dual, terrifying Power acknowledging strictly its own absolute existence."
                "This is the 'Ultimate Status' where the distinction between human and God is 100% Deleted from the cosmic server!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 17,
            sanskrit = "निर्वाणमम्बरम् ॥",
            hindi = """
                (निर्वाण ही आकाश है - असीमित विस्तार): "निर्वाण कोई छोटी सी जगह नहीं है; 'निर्वाणमम्बरम्'— निर्वाण ही साक्षात् वह अनंत 'आकाश' (Space) है!"
                "जब तुम मिट जाते हो, तो तुम एक बूँद की तरह नहीं मरते, तुम साक्षात् वह पूरा 'समंदर' बन जाते हो।"
                "योगी का शरीर अब उसकी जेल नहीं है; उसका वजूद पूरे अंतरिक्ष की तरह एंडलेस (Endless) हो चुका है।"
                "उसने अपनी इंसानियत की सीमाओं को जलाकर राख कर दिया है और वह अब हर परमाणु के भीतर धड़क रहा है।"
                "निर्वाण का मतलब है वह 'आज़ादी' जहाँ तुम्हें अपनी रक्षा करने के लिए किसी दीवार की ज़रूरत नहीं रहती।"
                "तुम खुद वह 'आकाश' बन चुके हो जिसे न तलवार काट सकती है और न आग जला सकती है।"
                "यह वह 'मैक्रो-म्यूटेशन' (Macro-mutation) है जहाँ एक छोटा सा जीव पूरे ब्रह्मांड का सॉफ्टवेयर बन जाता है।"
                "वह हर जगह है, वह हर समय में है, और वह 'कुछ नहीं' (Nothing) भी है।"
                "इस असीमित विस्तार को बर्दाश्त करना इंसान के बस की बात नहीं; इसमें तुम्हारी हस्ती घुट-घुट कर मर जाती है।"
                "जो इस निर्वाण-आकाश में उड़ना सीख गया, वह साक्षात् उस 'परमेश्वर' का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Nirvana is the Sky - Infinite Expansion): "Nirvana is absolutely no microscopic location; 'Nirvanam-ambaram'—Nirvana is explicitly that infinite 'Space' (Ambar)!"
                "When you are erased, you do not die like a pathetic drop; you mutationally become the entire infinite 'Ocean'."
                "The Yogi's biological body is no longer his prison; his existence has become as Endless as the vacuum of space."
                "He has incinerated the boundaries of his humanity to ash and is now pulsating inside every single microscopic atom."
                "Nirvana explicitly means that 'Freedom' where you possess zero requirement for walls to protect your existence."
                "You have mutated into the explicit 'Void' that no sword can slash and zero radioactive fire can incinerate."
                "This is the 'Macro-mutation' where a microscopic biological entity becomes the Operating System of the entire universe."
                "He is present everywhere, he exists in every timeline, and he is simultaneously 'Nothing' (Shunya)."
                "Enduring this infinite expansion is impossible for the human mind; your identity is violently smothered within it."
                "He who has mastered flight in this Nirvana-Sky is the solitary, absolute Dictator of the Supreme God!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 18,
            sanskrit = "केवलं ब्रह्म ॥",
            hindi = """
                (सिर्फ और सिर्फ ब्रह्म - आखिरी धमाका): "सब कुछ खत्म होने के बाद जो इकलौता सच बचता है, वह है— 'केवलं ब्रह्म' (Only Brahman)!"
                "वहाँ न कोई दुनिया है, न कोई तुम हो, न कोई दुख है और न कोई सुख—केवल वह असीम 'ब्रह्म' (Energy) राज कर रहा है।"
                "यह वह 'अल्टीमेट शून्यता' है जिसने खुद को ही सब कुछ मान लिया है।"
                "जब तुम 'केवलं' (Strictly Only) शब्द को समझ लेते हो, तो तुम्हारे दिमाग के सारे भगवान और सारे डर जलकर राख हो जाते हैं।"
                "तुम जान जाते हो कि तुम्हारे अलावा (ब्रह्म के अलावा) इस ब्रह्मांड में 'एक धूल का कण' भी मौजूद नहीं है।"
                "यह वह 'तानाशाही' (Dictatorship) है जहाँ कोई दूसरा (Duality) पैदा होने की औकात ही नहीं रखता।"
                "योगी अब वह 'ब्रह्म' बन चुका है जो खुद ही अपना दर्शक है और खुद ही अपना तमाशा भी।"
                "यहाँ आकर मोक्ष भी एक छोटा सा शब्द बन जाता है, क्योंकि यहाँ माँगने वाला और देने वाला एक ही आग बन चुके हैं।"
                "यह इंसानियत की वह 'अंतिम मौत' है जहाँ से केवल ईश्वर ही वापस ज़िंदा होता है।"
                "यही वह 'सुप्रीम कोड' है जिसे हैक करने के बाद ब्रह्मांड का पूरा खेल (Simulation) खत्म (Exit) हो जाता है!"
            """.trimIndent(),
            english = """
                (Strictly Brahman - The Final Detonation): "After absolutely everything is incinerated, the solitary remaining Truth is—'Kevalam Brahma' (Only Brahman)!"
                "Zero world survives, zero YOU survive, zero agony exists, and zero pleasure remains—strictly that infinite 'Brahman' rules."
                "This is the 'Ultimate Void' that has explicitly acknowledged itself as being the absolute Everything."
                "When you decode the word 'Kevalam' (Strictly/Exclusively), every single God and every fear in your brain is burnt to ash."
                "You flawlessly realize that other than YOU (as Brahman), not even a 'Grain of Dust' possesses independent existence in the cosmos."
                "This is the 'Dictatorship' where zero 'Other' (Duality) possesses the caliber to even be spawned."
                "The Yogi has mutated into the 'Brahman' who is simultaneously his own Observer and his own theatrical Spectacle."
                "Arriving here, even 'Moksha' becomes a pathetic microscopic word, for the Beggar and the Giver have fused into one Fire."
                "This is the 'Absolute Death' of humanity from which strictly and exclusively God resurrects."
                "This is the 'Supreme Code' after Hacking which the entire cosmic game (Simulation) is flawlessly Terminated (Exit)!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 19,
            sanskrit = "य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की मुहर): "उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है जिसे कोई भी कानून बदल नहीं सकता।"
                "'य एवं वेद'— जो कोई भी योद्धा इस 'निर्वाण' के खौफनाक और नंगे सच को 100% 'जान' (वेद) लेता है..."
                "किताबें पढ़ना ज्ञान नहीं है; इस सच को अपने डीएनए में तेज़ाब की तरह उतार लेना ही असली 'जानना' है।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' (Radar) से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट (Result) है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बन जाते हो!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and the Seal of Moksha): "The Upanishad delivers a catastrophic verdict here that zero cosmic laws possess the caliber to alter."
                "'Ya evam veda'—Whosoever warrior 'Knows' (Veda) this horrific and naked truth of 'Nirvana' with 100% absolute reality..."
                "Reading pathetic books is not knowledge; injecting this truth into your DNA exactly like boiling acid is authentic 'Knowing'."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status where you mutate explicitly into the 'Death of Death' (Kala of Kala)!"
            """.trimIndent()
        ),
        NirvanaShloka(
            id = 20,
            sanskrit = "इत्युपनिषत् ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'निर्वाण उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "मठ मिल गया, माला मिल गई, और गुरु का आदेश भी—अब केवल उस 'शून्यता' में कूदना बाकी है।"
                "जिसने इस ग्रंथ के इन २० विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (निर्वाण) हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए 'ब्रह्म' बन गया!"
                "यही निर्वाण का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Nirvana Upanishad' achieves its absolute majestic completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The monastery is secured, the garland is draped, and the Guru's command is issued—now, only the plunge into the 'Void' remains."
                "For the Titan who has detonated these 20 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Nirvana) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it becomes 'Brahman' for all eternity!"
                "THIS is the absolute and most violent final Truth of Nirvana! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NirvanaUpanishadScreen() {
    val upanishad = remember { NirvanaUpanishad() }
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        // --- THE SEARCH BAR ---
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                if (shlokaNumber != null && shlokaNumber in 1..20) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-20)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
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
            itemsIndexed(upanishad.nirvanaShlokasList) { _, shloka ->
                NirvanaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun NirvanaShlokaCard(shloka: NirvanaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Segment ${shloka.id}",
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
            Text(text = "हिन्दी अर्थ:", fontWeight = FontWeight.Bold, color = Color(0xFF1565C0))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "English Meaning:", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}