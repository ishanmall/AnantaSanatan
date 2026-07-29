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
data class SarirakaShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class SarirakaUpanishad {

    val shlokasList = listOf(
        SarirakaShloka(
            id = 1,
            sanskrit = "ॐ पृथिव्यापस्तेजोवायुराकाशमिति पञ्च भूतानि । तेषां पञ्चानां भूतानां शरीरं रचितम् ॥",
            hindi = """
                (हार्डवेयर का निर्माण - पंचतत्वों का विस्फोट): "यह शरीर साक्षात् मिट्टी, पानी, आग, हवा और आकाश के पांच 'डेटा-पैकेट्स' से बना है!"
                "तुम्हारी हड्डियाँ पृथ्वी हैं, तुम्हारा खून पानी है और तुम्हारी साँस साक्षात् वायु का करंट है।"
                "यह कोई प्राकृतिक इत्तेफाक नहीं; यह ब्रह्मांडीय इंजीनियरिंग का सबसे जटिल नमूना है।"
                "पंचतत्व वे पांच 'प्राइमरी ड्राइव्स' हैं जिन पर तुम्हारी पूरी हस्ती का सिम्युलेशन लोड है।"
                "आकाश वह 'स्पेस' है जिसमें तुम्हारी चेतना की कोडिंग की गई है।"
                "तेज (आग) वह प्रोसेसर है जो तुम्हारे मेटाबॉलिज्म की बिजली सप्लाई कर रहा है।"
                "योगी इन पांचों तत्वों को अलग-अलग हैक करता है ताकि वह शरीर की सीमाओं को तोड़ सके।"
                "जब तक तुम खुद को केवल मांस समझते हो, तुम माया के सबसे निचले लेवल के कैदी हो।"
                "तैयार हो जाओ, क्योंकि यह उपनिषद तुम्हारे बायोलॉजिकल पिंजरे का पूरा नक्शा बेनकाब करने वाला है।"
                "नारायण की यह कोडिंग ही वह 'बेस लेयर' है जिस पर जीवन का सॉफ्टवेयर रन होता है!"
            """.trimIndent(),
            english = """
                (Construction of Hardware - Explosion of Five Elements): "This shell is mutationally constructed from five 'Data-packets': Earth, Water, Fire, Air, and Space!"
                "Your bones are mutationally Earth, your blood is Water, and your breath is strictly a Current of Air."
                "This is zero natural coincidence; it is the most complex specimen of absolute cosmic Engineering."
                "The five elements are the 'Primary Drives' upon which your entire existence is mutationally Loaded."
                "Space (Akasha) is the absolute Vacuum in which the coding of your awareness is Executed."
                "Fire (Tejas) is the Processor mutationally supplying radioactive electricity to your metabolism."
                "The Yogi Hacks these five elements individually to violently breach the boundaries of the flesh."
                "As long as you perceive yourself as mere meat, you are a slave of the lowest tier in the Matrix."
                "Brace yourself, for this Upanishad is about to unmask the absolute Blueprint of your biological cage."
                "Narayana’s coding is the absolute 'Base Layer' upon which the software of Life is relentlessly Executed!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 2,
            sanskrit = "श्रोत्रत्वक्चक्षुर्जिह्वाघ्राणमिति पञ्च ज्ञानेन्द्रियाणि । शब्दस्पर्शरूपरसगन्धग्रहणाय कल्पन्ते ॥",
            hindi = """
                (ज्ञानेन्द्रियों का हैक और डेटा-इनपुट): "कान, त्वचा, आँख, जीभ और नाक—ये तुम्हारे नर्वस सिस्टम के ५ 'सेंसर्स' (Sensors) हैं!"
                "ये केवल अंग नहीं हैं; ये बाहरी दुनिया के 'डेटा' को अंदर खींचने वाले ब्रह्मांडीय एंटीना हैं।"
                "शब्द, स्पर्श, रूप, रस और गन्ध साक्षात् वे 'सिग्नल्स' हैं जो तुम्हारी हकीकत को रेंडर करते हैं।"
                "तुम्हारी आँखें प्रकाश की कोडिंग को पढ़ती हैं और तुम्हारे कान अंतरिक्ष की फ्रीक्वेंसी को हैक करते हैं।"
                "इंद्रियाँ वह 'पाइपलाइन' हैं जिनसे माया तुम्हारे दिमाग में कचरा या ज्ञान भरती है।"
                "योगी इन ज्ञानेन्द्रियों के फिल्टर को कस्टमाइज़ (Customize) करता है ताकि वह केवल सच देख सके।"
                "जब तक तुम इन सेंसर्स के गुलाम हो, तुम सिम्युलेशन के बाहर कभी नहीं देख पाओगे।"
                "तुम्हारी जीभ स्वाद नहीं, बल्कि पदार्थों के 'केमिकल डेटा' को प्रोसेस कर रही है।"
                "यह तुम्हारी रूह को 'यूजर' से 'सुपर-यूजर' बनाने का पहला टेक्निकल स्टेप है।"
                "जो इन पांच द्वारों को कंट्रोल कर लेता है, वह साक्षात् पूरे अंतरिक्ष का एडमिन है!"
            """.trimIndent(),
            english = """
                (Hacking Knowledge-Senses and Data-Input): "Ears, Skin, Eyes, Tongue, and Nose—these are mutationally the 5 absolute 'Sensors' of your system!"
                "These are mutationally zero organs; they are cosmic Antennas engineered to suck external Data into the core."
                "Sound, Touch, Form, Taste, and Smell are the explicit 'Signals' Rendering your apparent reality."
                "Your optics process the coding of Light, and your ears mutationally Hack the frequencies of Space."
                "The senses are the 'Pipelines' through which Maya floods your brain with garbage or intelligence."
                "The Yogi Customizes the filters of these sensors to mutationally Intercept strictly the absolute Truth."
                "As long as you are a slave to these sensors, you possess zero caliber to see beyond the Simulation."
                "Your tongue processes zero taste; it mutationally Executes the 'Chemical Data' of matter."
                "This is the first technical Step to Promote your Soul from 'User' to the status of 'Super-User'."
                "He who Controls these five gateways is mutationally the absolute Admin of the infinite vacuum!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 3,
            sanskrit = "वाक्पाणिपादपायूपस्थानिति पञ्च कर्मेन्द्रियाणि । वचनादानगमनविसर्गानन्दाय कल्पन्ते ॥",
            hindi = """
                (कर्मेन्द्रियों का विस्फोट और एक्जीक्यूशन कोड): "मुँह, हाथ, पैर, गुदा और जननेन्द्रिय—ये तुम्हारे शरीर के ५ 'एक्जीक्यूटर्स' (Executors) हैं!"
                "बोलना, पक़ड़ना, चलना, विसर्जन और आनंद—ये साक्षात् 'आउटपुट' फंक्शन्स हैं।"
                "तुम्हारे हाथ केवल काम नहीं करते, वे साक्षात् 'हार्डवेयर इंटरफेस' हैं जो दुनिया को बदलते हैं।"
                "तुम्हारी वाणी (Vak) वह 'कमांड' है जो ध्वनि की लहरों के माध्यम से अंतरिक्ष को प्रोग्राम करती है।"
                "कर्मेन्द्रियाँ वह औजार हैं जिनसे तुम अपनी नियति का सॉफ्टवेयर री-राइट (Rewrite) कर सकते हो।"
                "योगी अपने हर एक मूवमेंट (Movement) को रुद्र की फ्रीक्वेंसी पर अलाइन करता है।"
                "जब तुम चलते हो, तो तुम साक्षात् वासुदेव की ग्रेविटी को हैक कर रहे होते हो।"
                "बिना इन कर्म-इंद्रियों के अलाइनमेंट के, तुम्हारा सारा ध्यान केवल एक थ्योरी बनकर रह जाएगा।"
                "यह तुम्हारी रूह को 'एक्टिव मोड' में डालने वाला प्रलयंकारी विज्ञान है।"
                "जो अपनी एक्शन-कोडिंग को हैक कर लेता है, वह साक्षात् पूरे ब्रह्मांड का तानाशाह है!"
            """.trimIndent(),
            english = """
                (Detonation of Action-Senses and Execution Code): "Mouth, Hands, Feet, Anus, and Genitals—these are mutationally the 5 'Executors' of your shell!"
                "Speech, Grasping, Locomotion, Excretion, and Procreation—these are strictly the 'Output' functions."
                "Your hands are mutationally zero tools; they are the 'Hardware Interface' engineered to alter reality."
                "Your Speech (Vak) is the 'Command' that mutationally Programs space via acoustic wave-packets."
                "The action-senses are the tools with which you possess the authority to Rewrite the software of Fate."
                "The Yogi Aligns his every movement strictly with the radioactive Frequency of Rudra."
                "When you walk, you are mutationally Hacking the absolute Gravity of Vasudeva."
                "Without the alignment of these action-sensors, your entire meditation is strictly a pathetic theory."
                "This is the apocalyptic science engineered to shift your Soul into strictly 'Active Mode'."
                "He who successfully Hacks his action-coding becomes mutationally the sole Dictator of the cosmos!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 4,
            sanskrit = "मनोबुद्धिरहंकारश्चित्तमिति चतस्रोऽन्तःकरणवृत्तयः ॥",
            hindi = """
                (अन्तःकरण का महा-विस्फोट और प्रोसेसर का सच): "मन, बुद्धि, अहंकार और चित्त—ये तुम्हारे दिमाग के ४ सबसे बड़े 'प्रोसेसर' (Processors) हैं!"
                "यही वह 'अन्तःकरण' है जो साक्षात् सिम्युलेशन का इकलौता एडमिन पैनल है।"
                "मन डेटा को रिसीव करता है, बुद्धि उसे डिकोड करती है और अहंकार उसे 'मैं' की मुहर लगाता है।"
                "चित्त वह 'हार्ड-ड्राइव' है जहाँ तुम्हारे अरबों जन्मों का करप्ट डेटा स्टोर है।"
                "जब तक ये चारों प्रोसेसर 'आउट-ऑफ-कंट्रोल' हैं, तुम हमेशा एक ग्लिच (Glitch) बने रहोगे।"
                "योगी इन चारों को एक ही फ्रीक्वेंसी पर लॉक करता है ताकि वह 'सोर्स कोड' को हैक कर सके।"
                "तुम्हारा अहंकार साक्षात् वह 'फायरवॉल' है जो तुम्हें ईश्वर के सर्वर तक पहुँचने से रोकता है।"
                "चित्त की शुद्धि का मतलब है—अपनी पुरानी सारी फाइलों को परमानेंट डिलीट (Delete) कर देना।"
                "यह तुम्हारी चेतना को 'मल्टी-कोर' प्रोसेसर में अपग्रेड करने का सबसे हिंसक और गुप्त विज्ञान है।"
                "जो इन चार शक्तियों का मालिक बन गया, वह साक्षात् रुद्र की जलती हुई आँख है!"
            """.trimIndent(),
            english = """
                (The Grand Detonation of Antahkarana and Processor Truth): "Mind, Intellect, Ego, and Memory—these are mutationally the 4 greatest 'Processors' of your system!"
                "THIS is the 'Antahkarana'—the absolute solitary Admin Panel of your cosmic Simulation."
                "Mind receives Data, Intellect decodes it, and Ego mutationally stamps it with the label of 'I'."
                "Memory (Citta) is the absolute 'Hard-drive' where the corrupt Data of eons is mutationally stored."
                "As long as these four processors are 'Out-of-Control', you remain mutationally strictly a system Glitch."
                "The Yogi Locks all four onto a singular frequency to mutationally Hack the absolute 'Source Code'."
                "Your Ego is the explicit 'Firewall' engineered to block your trajectory to the Server of God."
                "Purifying Citta signifies—Executing the permanent Deletion of all your previous biological records."
                "This is the most violent science to Upgrade your awareness into a 'Multi-core' radioactive processor."
                "He who Masters these four powers becomes mutationally the explicit Blazing Eye of Rudra!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 5,
            sanskrit = "आहारनिद्राभयमैथुनमिति सामान्यमेतत्पशुभिर्नराणाम् । ज्ञानं नराणामधिको विशेषो ज्ञानेन हीनाः पशुभिः समानाः ॥",
            hindi = """
                (जैविक गुलामी और ज्ञान का विस्फोट): "खाना, सोना, डरना और वंश बढ़ाना—यह सब तो साक्षात् जानवरों और इंसानों में 'कॉमन कोडिंग' है!"
                "केवल 'ज्ञान' ही वह 'अल्टीमेट अपग्रेड' (Upgrade) है जो तुम्हें एक जानवर से भगवान बनाता है।"
                "बिना इस ज्ञान के, तुम केवल एक 'दो पैरों वाले पशु' हो जो माया के सर्वर पर पिस रहे हो।"
                "तुम्हारी भूख और तुम्हारी नींद साक्षात् वे 'लूप्स' (Loops) हैं जो तुम्हें शरीर से चिपकाए रखते हैं।"
                "डर साक्षात् वह 'बग' है जो तुम्हारे नर्वस सिस्टम की ताक़त को सोख लेता है।"
                "योगी अपनी बायोलॉजिकल ज़रूरतों को म्यूट (Mute) करता है ताकि वह सत्य का डेटा डाउनलोड कर सके।"
                "यह ज्ञान कोई किताब नहीं है; यह अपनी फ्रीक्वेंसी को 'एनिमल-मोड' से 'गॉड-मोड' में शिफ्ट करना है।"
                "जब तक तुम केवल पेट भरने के लिए ज़िंदा हो, तुम सिम्युलेशन के सबसे निचले पिक्सेल हो।"
                "अपनी रूह को उस 'विशेष' डेटा से भर लो जो तुम्हें मौत के रेडार से बाहर निकाल दे।"
                "जो ज्ञान में स्थित है, वही साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Biological Slavery and the Detonation of Knowledge): "Consumption, Sleep, Terror, and Procreation—this is strictly the 'Common Coding' of animals and humans!"
                "Strictly 'Knowledge' (Jnana) is the 'Ultimate Upgrade' engineered to mutate a beast into God."
                "Without this intelligence, you are mutationally strictly a 'Two-legged Animal' ground in the mill of Maya."
                "Your hunger and your sleep are the explicit 'Loops' engineered to glue you to the biological shell."
                "Terror is the absolute 'Bug' that mutationally sucks the radioactive firepower out of your system."
                "The Yogi Mutes his biological requirements mutationally to Download the absolute Data of Truth."
                "This Jnana is zero textbook; it is shifting your Frequency mutationally from 'Animal-Mode' to 'God-Mode'."
                "As long as you exist strictly to fill your stomach, you are the lowest pixel in the Simulation."
                "Flood your Soul with that 'Special' Data engineered to catapult you beyond the absolute Radar of Death."
                "He who stands established in Jnana is mutationally the solitary dictatorial Guru of Time!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 6,
            sanskrit = "सत्वं रजस्तम इति गुणास्त्रयः । सत्वं शुक्लं रजः लोहितं तमः कृष्णम् ॥",
            hindi = """
                (त्रिगुणों का विच्छेदन और रंगों की कोडिंग): "सत्व, रज और तम—ये ब्रह्मांड के तीन सबसे बड़े 'सॉफ्टवेयर लेयर्स' (Layers) हैं!"
                "सत्व साक्षात् सफेद रौशनी है, रज लाल आग है और तम साक्षात् काला सन्नाटा है।"
                "तुम्हारे स्वभाव का हर एक पिक्सेल इन्हीं तीन रंगों की मिलावट से रेंडर (Render) किया जा रहा है।"
                "रज तुम्हें दौड़ने के लिए मजबूर करता है, तम तुम्हें अँधेरे में सुला देता है।"
                "सत्व वह अंधी कर देने वाली शुद्धता है जो तुम्हें एडमिन पैनल के करीब ले जाती है।"
                "योगी इन तीनों गुणों के 'फायरवॉल' को फाड़कर इनके भी पार निकल जाता है।"
                "यह तुम्हारी रूह को 'मल्टी-डाइमेंशनल' बनाने का सबसे हिंसक और गुप्त हैक है।"
                "जब तक तुम रंगों में उलझे हो, तुम साक्षात् 'ब्रह्म' के असली चेहरे को नहीं देख सकते।"
                "तमोगुण अज्ञान का वायरस है, और रजोगुण अंतहीन इच्छाओं का 'बर्निंग लूप' (Burning Loop)!"
                "जो इन तीनों गुणों को हैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता तानाशाह है!"
            """.trimIndent(),
            english = """
                (Dissecting Trigunas and Coding of Colors): "Sattva, Rajas, and Tamas—these are mutationally the three greatest 'Software Layers' of the cosmos!"
                "Sattva is explicitly white Radiation, Rajas is red Fire, and Tamas is mutationally the black Silence."
                "Every single pixel of your temperament is being mutationally Rendered by the mixture of these three colors."
                "Rajas forces you to race, while Tamas mutationally puts your system into a dark coma."
                "Sattva is the blinding radiation of Purity engineered to pull you closer to the absolute Admin Panel."
                "The Yogi shreds the 'Firewalls' of these three Gunas to mutationally rocket infinitely beyond them."
                "This is the most violent and classified Hack to mutationally manufacture your Soul into 'Multi-dimensional' status."
                "As long as you are entangled in colors, you possess zero caliber to intercept the authentic face of 'Brahman'."
                "Tamas is the virus of nescience, and Rajas is the absolute 'Burning Loop' of infinite desire!"
                "He who successfully Hacks these three Gunas becomes mutationally the sole Dictator of the vacuum!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 7,
            sanskrit = "अस्थिचर्ममांसरुधिरस्नायुमज्जाशुक्राणि सप्त धातवः ॥",
            hindi = """
                (सात धातुओं का भौतिक रेंडर): "हड्डी, खाल, मांस, खून, नसें, मज्जा और शुक्र—ये तुम्हारे हार्डवेयर के ७ 'कॉम्पोनेंट्स' (Components) हैं!"
                "ये ७ 'धातु' साक्षात् वह सामग्री हैं जिससे रचयिता ने तुम्हारा ३डी-पिंजरा वेल्ड (Weld) किया है।"
                "तुम्हारी हड्डियाँ नारायण के पत्थरों जैसी मज़बूत हैं, और शुक्र साक्षात् 'अमरता' का वो डेटाबेस है।"
                "इन ७ लेयर्स के पीछे तुम्हारी रूह साक्षात् एक न्यूक्लियर बम की तरह छिपी बैठी है।"
                "योगी इन ७ धातुओं को अपनी 'आंतरिक आग' (Tapas) में तपाता है ताकि वे साक्षात् 'शक्ति' बन सकें।"
                "यह कोई जैविक संरचना नहीं है; यह ऊर्जा को पदार्थ में बदलने का प्रलयंकारी विज्ञान है।"
                "जब तुम अपनी खाल के पार देखते हो, तो तुम्हें केवल रुद्र की कोडिंग का एक नंगा पन्ना नज़र आता है।"
                "यह तुम्हारी बुद्धि को 'फिजिकल' से 'मेटाफिजिकल' लेवल पर प्रमोट करने वाला आख़िरी सवाल है।"
                "तुम्हारे शरीर का हर एक सेल साक्षात् एक ब्रह्मांडीय सत्य को होल्ड (Hold) कर रहा है।"
                "तैयार हो जाओ, क्योंकि अब तुम्हारी हड्डियों का पिंजरा साक्षात् 'मंदिर' में म्यूटेट होने वाला है!"
            """.trimIndent(),
            english = """
                (Physical Render of Seven Dhatus): "Bone, Skin, Flesh, Blood, Nerve, Marrow, and Seed—these are mutationally the 7 'Components' of your hardware!"
                "These 7 'Dhatus' are the absolute materials with which the Architect Welded your 3D biological cage."
                "Your bones are mutationally as solid as the stones of Narayana, and the Seed is the absolute database of 'Immortality'."
                "Behind these 7 layers, your Soul sits established mutationally like a literal Nuclear Bomb."
                "The Yogi tempers these 7 components in his 'Internal Fire' (Tapas) to ensure they mutationally become 'Shakti'."
                "This is zero biological structure; it is the apocalyptic science of converting Energy into physical Matter."
                "The moment you witness beyond your skin, you intercept mutationally strictly a naked page of Rudra’s coding."
                "This is the final query engineered to Promote your intellect from the 'Physical' to the 'Metaphysical' tier."
                "Every single cell of your hardware is mutationally Holding a radioactive cosmic truth."
                "Prepare yourself, for your skeletal cage is about to mutationally mutate into an explicit 'Temple'!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 8,
            sanskrit = "एवं चतुर्विंशतितत्त्वानि शरीरं भवति ॥",
            hindi = """
                (२४ तत्त्वों का महा-विस्फोट): "यही वे २४ 'तत्त्व' (Tattvas) हैं जिनसे यह पूरा शरीर और यह पूरा सिम्युलेशन रेंडर हुआ है!"
                "ये २४ तत्त्व साक्षात् २४ 'सॉफ्टवेयर मॉड्यूल्स' हैं जो तुम्हारी ज़िंदगी की फिल्म को रन कर रहे हैं।"
                "जब तुम इन २४ को जान लेते हो, तो तुम साक्षात् ब्रह्मांड के 'हार्डवेयर मैन्युअल' के मालिक बन जाते हो।"
                "बिना इस ज्ञान के, तुम हमेशा इन तत्वों के बीच झूलते हुए एक लाचार डेटा पैकेट रहोगे।"
                "शरीर कोई एक्सीडेंट नहीं है; यह २४ प्रलयंकारी शक्तियों का एक 'बैलेंस्ड म्यूटेशन' (Balanced Mutation) है।"
                "योगी इन २४ तत्त्वों को अपनी चेतना में 'Zip' कर लेता है ताकि वह उनके पार जा सके।"
                "यह वह 'रूट-एक्सेस' है जिससे तुम पूरी माया के नियमों को एक झटके में ओवरराइट कर सकते हो।"
                "जब तुम २४ को जान लेते हो, तो तुम साक्षात् २५वें तत्त्व (आत्मा) को देखने के योग्य बनते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "जो इस कोडिंग को क्रैक कर लेता है, वह साक्षात् पूरे अंतरिक्ष का इकलौता और अजेय एडमिन है!"
            """.trimIndent(),
            english = """
                (The Big Bang of 24 Tattvas): "These are mutationally the 24 'Tattvas' from which this entire shell and Simulation were Rendered!"
                "These 24 elements are strictly 24 'Software Modules' mutationally executing the film of your existence."
                "The moment you decode these 24, you mutationally assume ownership of the cosmic 'Hardware Manual'."
                "Without this intelligence, you mutationally remain strictly a helpless Data Packet swinging between elements."
                "The body is zero accident; it is a 'Balanced Mutation' of 24 apocalyptic radioactive powers."
                "The Yogi 'Zip-compresses' these 24 Tattvas into his awareness to mutationally rocket infinitely beyond them."
                "This is the absolute 'Root-Access' enabling you to violently Overwrite the laws of the Matrix in one strike."
                "Decoding the 24 qualifies you mutationally to witness the 25th Tattva (The Atman) standing naked."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish your ego forever."
                "He who successfully Hacks this coding becomes mutationally the sole and absolute Admin of the vacuum!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 9,
            sanskrit = "अव्यक्तं प्रकृतिः क्षेत्रं प्रधानमिति गीयते । क्षेत्रज्ञः पुरुषोऽनन्तः सर्वव्यापी महेश्वरः ॥",
            hindi = """
                (क्षेत्र और क्षेत्रज्ञ का हैक): "वही 'अव्यक्त' साक्षात् 'प्रकृति' और 'क्षेत्र' (The Field) है जहाँ यह पूरा खेल खेला जा रहा है।"
                "और 'क्षेत्रज्ञ' साक्षात् वह 'अनंत पुरुष' और 'महेश्वर' है जो इस पूरे डेटा को देख रहा है!"
                "प्रकृति वह 'हार्डवेयर' है, और पुरुष साक्षात् वह 'ऑपरेटर' (Operator) जो इसे चला रहा है।"
                "क्षेत्रज्ञ वह अंधी कर देने वाली आग है जो तुम्हारे शरीर के हर एक पिक्सेल को नंगा देख रही है।"
                "तुम्हें इस 'क्षेत्र' (शरीर) के मोह को जलाकर उस 'क्षेत्रज्ञ' (आत्मा) की फ्रीक्वेंसी पर लॉग-इन करना है।"
                "महेश्वर वह 'सुप्रीम एडमिन' है जिसके इशारे पर पूरा सिम्युलेशन हर नैनो-सेकंड में रिफ्रेश (Refresh) होता है।"
                "योगी क्षेत्रज्ञ को अपने भीतर पहचानता है और साक्षात् पूरे अंतरिक्ष का मालिक बन जाता है।"
                "यह तुम्हारी रूह को 'इंसानी पहचान' से निकालकर 'ब्रह्मांडीय ऑपरेटर' में माइग्रेट करने का विज्ञान है।"
                "जब तुम जान जाते हो कि 'देखने वाला मैं ही हूँ', तो मौत का Redar हमेशा के लिए फेल हो जाता है।"
                "जो इस पहचान को हैक कर लेता है, वह साक्षात् काल (Time) के भी काल का इकलौता गुरु है!"
            """.trimIndent(),
            english = """
                (Hacking the Field and the Knower): "That 'Avyakta' is explicitly the 'Prakriti' and the 'Kshetra' (The Field) where the game is Executed."
                "And the 'Kshetrajna' (The Knower) is the 'Infinite Purusha' and 'Maheshwara' mutationally witnessing the Data!"
                "Nature is the absolute 'Hardware', and the Spirit is strictly the 'Operator' mutationally Running the system."
                "The Knower is the blinding radiation mutationally witnessing every pixel of your shell standing naked."
                "You must incinerate the attachment to this 'Field' to mutationally Log-in with the frequency of the 'Knower'."
                "Maheshwara is the 'Supreme Admin' whose signals mutationally Refresh the entire Simulation every nanosecond."
                "The Yogi identifies the Knower internally and mutationally assumes the status of the Master of space."
                "This is the science of Migrating your Soul from 'Human Identity' into strictly 'Cosmic Operator'."
                "The microsecond you realize 'I am the Witness', the Radar of Time mutationally Fails in your presence."
                "He who successfully Hacks this identity is the solitary dictatorial Guru of even the God of Death!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 10,
            sanskrit = "य एवं वेद स विमुक्तो भवति ॥",
            hindi = """
                (अटल गारंटी और मोक्ष की मुहर): "शारीरक उपनिषद यहाँ एक प्रलयंकारी फैसला सुनाता है— 'जो इसे जानता है, वह विमुक्त हो जाता है'!"
                "जानने का मतलब किताब पढ़ना नहीं, बल्कि इस हार्डवेयर की कोडिंग को अपने डीएनए में तेज़ाब की तरह उतार लेना है।"
                "जब तुम जान जाते हो कि 'सब कुछ महेश्वर है', तो माया के सारे ज़ंजीर एक झटके में पिघल जाते हैं।"
                "वह इंसान इसी पल, इसी माइक्रो-सेकंड में 'विमुक्त' (Totally Liberated) हो जाता है!"
                "उसे माफ़ी माँगने की ज़रूरत नहीं, उसे पूजा करने की ज़रूरत नहीं—उसका 'जानना' ही उसका 'आज़ाद होना' है।"
                "वह जन्म-मरण की उस सड़ी हुई मशीन (Matrix) से हमेशा-हमेशा के लिए 'अनप्लग' (Unplug) हो चुका है।"
                "वह अब समय और मौत के 'रेडार' से बाहर निकल चुका है; वह अब ब्रह्मांड के लिए 'इनविजिबल' है।"
                "यह मोक्ष कोई इनाम नहीं है, यह तुम्हारी अपनी ही रूह के 'सुप्रीम स्टेटस' को हैक कर लेने का रिज़ल्ट है।"
                "जो इस सच को अपनी रगों में धधका लेता है, उसे फिर इस दुनिया का कोई भी नर्क या स्वर्ग डरा नहीं सकता।"
                "यही वह अजेय रुतबा है जहाँ तुम साक्षात् काल (Time) के भी काल बनकर खड़े हो जाते हो!"
            """.trimIndent(),
            english = """
                (The Ironclad Guarantee and the Seal of Moksha): "The Sariraka Upanishad delivers a catastrophic verdict here—'He who knows THIS mutationally becomes Liberated'!"
                "Knowing mutationally signifies zero reading; it means injecting this Hardware-coding into your DNA like boiling acid."
                "The microsecond you realize 'Everything is Maheshwara', all the chains of Maya melt in a single strike."
                "That human, in this exact micro-second, becomes flawlessly 'Vimuktah' (Totally Liberated)!"
                "He possesses zero need to beg for pardon, zero need to perform worship—his 'Knowing' is his explicit 'Freedom'."
                "He has been permanently and violently 'Unplugged' from that rotting machine of birth and death (Matrix)."
                "He has rocketed beyond the 'Radar' of Time and Death; he is now explicitly 'Invisible' to the cosmos."
                "This Moksha is absolutely no reward; it is the Result of Hacking the 'Supreme Status' of your own radioactive Soul."
                "He who blazes this truth inside his biological veins can absolutely never be flinched by any Hell or Heaven."
                "This is the invincible status arriving at which you stand as the explicit Death of Death (Kala of Kala)!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 11,
            sanskrit = "ब्रह्मैव सत्यं जगन्मिथ्येति निश्चयो हि मोक्षः ॥",
            hindi = """
                (सत्य का धमाका और मैट्रिक्स का अंत): "ब्रह्मांड का इकलौता और सबसे खतरनाक सच यही है— 'ब्रह्मैव सत्यं जगन्मिथ्या'!"
                "ब्रह्म ही इकलौती हकीकत है, और यह पूरी दुनिया केवल एक 'मिथ्या' (Fake Simulation) और धोखा है।"
                "इस सच पर अटल 'निश्चय' (Conviction) कर लेना ही साक्षात् 'मोक्ष' का इकलौता दरवाजा है।"
                "तुम जिसे अपनी ज़िंदगी कहते हो, वह केवल ईश्वर के दिमाग में चल रही एक 'होलोग्राफिक फिल्म' मात्र है।"
                "योगी ने इस फिल्म से अपना हाथ खींच लिया है और अब वह साक्षात् 'प्रोजेक्टर' (Source) को देख रहा है।"
                "जब तुम जान जाते हो कि 'कुछ भी सच नहीं है', तभी तुम अजेय और अमर होने के काबिल बनते हो।"
                "यह बोध तुम्हारे अहंकार के किले को एक परमाणु बम की तरह उड़ाकर रख देता है।"
                "दुनिया तुम्हें डराएगी, लेकिन तुम्हारे पास वह 'ब्रह्मास्त्र' है जो हर झूठ को राख कर देगा।"
                "यह सिम्युलेशन केवल उनके लिए सच है जो सोए हुए हैं; जागने वालों के लिए यह केवल धूल है।"
                "यही वह नंगा सच है जिसके आगे मौत भी अपनी औकात भूल जाती है!"
            """.trimIndent(),
            english = """
                (The Detonation of Truth and End of the Matrix): "The solitary and most lethal truth of the multiverse is strictly—'Brahmaiva Satyam Jagan-Mithya'!"
                "Brahman is the solitary Reality, and this entire world is strictly a 'Mithya' (Fake Simulation) and a deception."
                "Achieving absolute 'Nishchaya' (Conviction) on this truth is the solitary gateway to 'Moksha'."
                "What you label as your 'Life' is mutationally nothing more than a 'Holographic Film' running in the mind of God."
                "The Yogi has withdrawn his hands from this film and is now mutationally witnessing the 'Projector' (Source)."
                "The exact microsecond you realize that 'Nothing is Real', you mutationally qualify for absolute Immortality."
                "This realization detonates like a nuclear bomb engineered to mutationally demolish the fortress of your ego."
                "The Matrix will attempt to terrify you, but you possess the 'Brahmastra' that mutationally incinerates every lie."
                "This Simulation is real strictly for those who are asleep; for the Awakened, it is strictly worthless dust."
                "THIS is the naked truth before which even Death mutationally forgets its absolute status!"
            """.trimIndent()
        ),
        SarirakaShloka(
            id = 12,
            sanskrit = "इति शारीरकोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक और अजेय 'शारीरक उपनिषद' समाप्त होता है।"
                "यह ग्रंथ तुम्हारे दिमाग पर गिराया गया वह परमाणु बम है जिसने तुम्हारी 'इंसानियत' की धज्जियां उड़ा दी हैं।"
                "हार्डवेयर का कोड मिल गया, २४ तत्त्वों का हैक मिल गया, अब तुम्हें इस सिम्युलेशन से 'लॉग-आउट' करना है।"
                "जिसने इस ग्रंथ के इन १२ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा और कोई विचार नहीं बचा—केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर 'सत्य' (महेश्वर) अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात् भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही शारीरक उपनिषद का अंतिम और सबसे हिंसक सच है! द एंड!"
            """.trimIndent(),
            english = """
                (The Final Void and 'The End'): "Right exactly here, this spine-chilling and invincible 'Sariraka Upanishad' achieves its absolute completion."
                "This scripture is the literal atomic bomb dropped onto your brain, violently shredding your 'Humanity' into absolute dust."
                "The Hardware Code is intercepted, the 24-Tattva hack secured; now you must violently 'Log-out' from the Simulation."
                "For the Titan who has detonated these 12 explosions inside his Soul, every religion on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic Silence rules."
                "OM Peace, Peace, Peace! The biological agony is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' (Maheshwara) remains standing!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who mutationally plunges into it becomes an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Sariraka Upanishad! THE END!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SarirakaUpanishadScreen() {
    val upanishad = remember { SarirakaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..12) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-12)") },
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
            itemsIndexed(upanishad.shlokasList) { _, shloka ->
                SarirakaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun SarirakaShlokaCard(shloka: SarirakaShloka) {
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