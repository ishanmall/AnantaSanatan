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
data class KaliShloka(
    val id: Int,
    val sanskrit: String,
    val hindi: String,
    val english: String
)

class KaliSantaranaUpanishad {

    val kalisantaranaShlokasList = listOf(
        KaliShloka(
            id = 1,
            sanskrit = "ॐ द्वापरान्ते नारदो ब्रह्माणं जगाम कथं भगवन् गां पर्यटन् कलिं सन्तरेयमिति ॥",
            hindi = """
                (द्वापर का अंत और नारद का विद्रोह): "जब द्वापर युग की राख से कलि का अँधेरा पैदा हो रहा था, तब देवर्षि नारद कांप उठे।"
                "वे इस मायावी जेल (Matrix) को तोड़ने के लिए सीधे ब्रह्मांड के रचयिता ब्रह्मा के पास पहुँच गए।"
                "उन्होंने कोई साधारण बात नहीं पूछी; उन्होंने सीधे 'कलि' (Kali) के विनाश का न्यूक्लियर कोड माँगा।"
                "'कथं भगवन्'— हे भगवन! इस सड़ी हुई दुनिया में भटकते हुए मैं इस भयानक कलि को कैसे कुचल दूँ?"
                "कलि केवल एक समय नहीं, वह चेतना का वह वायरस है जो इंसान को जानवर बना देता है।"
                "नारद जानते थे कि आने वाले समय में इंसान की बुद्धि और शरीर दोनों कमज़ोर होकर मिट्टी में मिल जाएंगे।"
                "वे उस अजेय 'सन्तरण' (Crossing) की तकनीक चाहते थे जो मौत के भी पसीने छुड़ा दे।"
                "यह सवाल पूरी इंसानियत को बचाने के लिए किया गया सबसे पहला और हिंसक आध्यात्मिक विद्रोह था।"
                "ब्रह्मा जी ने नारद की आँखों में उस जलती हुई जिज्ञासा को देखा और सत्य का ताला खोल दिया।"
                "यहीं से उस महा-विस्फोटक विद्या की शुरुआत होती है जो समय के हर कानून को जलाकर राख कर देगी!"
            """.trimIndent(),
            english = """
                (The End of Dwapara and Narada's Rebellion): "As the darkness of Kali birthed from the ashes of Dwapara, Devarshi Narada violently shuddered."
                "To shatter this deceptive cosmic prison (Matrix), he rocketed directly to the Creator, Lord Brahma."
                "He did not pose a pathetic query; he demanded the Nuclear Code to completely annihilate 'Kali'."
                "'Katham Bhagavan'—O Lord! How exactly do I ruthlessly crush this horrific Kali while wandering this rotting world?"
                "Kali is not mere time; it is a neurological Virus engineered to mutate humans into pathetic beasts."
                "Narada flawlessly realized that in the coming age, human intellect and flesh would rot into dirt."
                "He demanded the invincible 'Santarana' (Crossing) technology that would make even Death sweat in terror."
                "This interrogation was the first and most violent spiritual insurrection executed to salvage all of humanity."
                "Lord Brahma witnessed the radioactive curiosity in Narada's eyes and unlocked the absolute Truth."
                "Right here begins the detonation of the supreme science that will incinerate every law of Time to ash!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 2,
            sanskrit = "स होवाच साधु पृष्टोऽस्मि सर्वश्रुतिरहस्यं गोप्यं तच्छृणु येन कलिसंसारं तरिष्यसि ॥",
            hindi = """
                (ब्रह्मा की गर्जना और परम रहस्य का अनावरण): "ब्रह्मा जी ने नारद को देखकर एक ऐसी आवाज़ में बात की जो अंतरिक्ष को फाड़ दे।"
                "उन्होंने कहा: 'साधु पृष्टोऽस्मि'— तुमने वह सवाल पूछा है जिसने मुझे भी हिला दिया है, यह बहुत ही खौफनाक सवाल है!"
                "मैं तुम्हें 'सर्वश्रुतिरहस्यं'— वेदों का वह सबसे गुप्त और रेडियोएक्टिव रहस्य बताने जा रहा हूँ!"
                "यह वो 'गोप्य' (Classified) जानकारी है जिसे आज तक किसी कमज़ोर कान ने नहीं सुना है।"
                "'तच्छृणु'— इसे अपने नर्वस सिस्टम में गाड़ लो, क्योंकि यही वह इकलौता हथियार है जो कलि को मार सकता है।"
                "इस विद्या के बिना 'कलिसंसारं'— कलि की इस सड़ी हुई दुनिया को पार करना नामुमकिन है।"
                "ब्रह्मा ने स्पष्ट किया कि कर्मकांड और किताबें अब काम नहीं आएंगी; अब सीधा हमला (Direct Strike) करना होगा।"
                "यह रहस्य इंसान की आत्मा को साक्षात परमेश्वर के गियर (Gear) में शिफ्ट (Shift) कर देगा।"
                "जो इस आवाज़ को अनसुना करता है, वह कलि के कीचड़ में अरबों सालों तक कीड़े की तरह पिसता रहेगा।"
                "तैयार हो जाओ, क्योंकि अब ब्रह्मांड का सबसे ताक़तवर मंत्र अपनी पूरी प्रलयंकारी शक्ति के साथ प्रकट होने वाला है!"
            """.trimIndent(),
            english = """
                (Brahma's Roar and Unveiling the Supreme Secret): "Lord Brahma looked at Narada and spoke in an acoustic frequency that threatened to tear space apart."
                "He roared: 'Sadhu prishto'smi'—You have posed the interrogation that has shaken even ME; a horrific query indeed!"
                "I am now transmitting the 'Sarvashrutirahasyam'—the most classified and radioactive secret of all the Vedas!"
                "This is the 'Gopyam' (Top-Secret) intelligence that no pathetic, weak biological ear has ever intercepted."
                "'Tacchrinu'—Hammer this into your nervous system, for this is the solitary weapon capable of assassinating Kali."
                "Without this science, crossing 'Kalisamsaram'—the rotting biological Matrix of Kali—is mathematically impossible."
                "Brahma explicitly dictated that rituals and textbooks are now obsolete; strictly a Direct Strike is required."
                "This secret will violently shift the human soul directly into the exact Gear of the Supreme God."
                "He who ignores this broadcast is condemned to be ground like an insect in the mud of Kali for billions of years."
                "Prepare yourself, for the absolute most powerful mantra in the cosmos is about to detonate with total apocalyptic force!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 3,
            sanskrit = "भगवत आदिपुरुषस्य नारायणस्य नामोच्चारणमात्रेण निर्धूतकलिरिति ॥",
            hindi = """
                (आदिपुरुष का नाम और कलि का कत्ल): "ब्रह्मा जी ने उस ब्रह्मांडीय हथियार का नाम लिया जिससे माया के चीथड़े उड़ जाते हैं।"
                "वह हथियार है 'भगवत आदिपुरुषस्य नारायणस्य नाम'— साक्षात उस असीम और प्रलयंकारी 'नारायण' का नाम!"
                "लेकिन यहाँ कोई पूजा नहीं हो रही; यहाँ 'नामोच्चारणमात्रेण'— यानी नाम के केवल एक विस्फोट मात्र से हैकिंग हो रही है।"
                "जैसे ही यह ध्वनि तुम्हारी रगों में दौड़ती है, 'निर्धूतकलिः'— कलि का सारा ज़हर तुम्हारे डीएनए से धुल (Flush) जाता है!"
                "यह नाम कोई शब्द नहीं है, यह वह वाइब्रेशन (Vibration) है जो माया के सर्वर को क्रैश (Crash) कर देता है।"
                "आदिपुरुष का नाम लेते ही इंसान का बायोलॉजिकल रिकॉर्ड डिलीट हो जाता है और वह भगवान बन जाता है।"
                "कलि की ताक़त केवल अज्ञान में है; ज्ञान की एक चिंगारी उसे एक सेकंड में राख कर देती है।"
                "नारायण का नाम साक्षात वह ब्रह्मांडीय आग है जो हर पाप और हर कर्म को स्वाहा (Burn) कर देती है।"
                "जो इस नाम को अपनी साँसों में लॉक (Lock) कर लेता है, वह समय (Time) का इकलौता तानाशाह बन जाता है।"
                "यहीं से उस महामंत्र का जन्म होता है जिसे सुनकर मौत भी अपना रास्ता बदल लेती है!"
            """.trimIndent(),
            english = """
                (The Name of Adipurusha and the Slaughter of Kali): "Lord Brahma invoked the cosmic weapon that violently shreds the fabric of Maya to pieces."
                "That weapon is strictly 'Bhagavata Adipurushasya Narayanasya Nama'—the explicit Name of that infinite, apocalyptic 'Narayana'!"
                "But this is no pathetic worship; it is Hacking via 'Namoccharanamatrena'—strictly through a single detonation of the Name."
                "The exact microsecond this frequency surges through your veins, 'Nirdhutakalih'—every drop of Kali's venom is Flushed from your DNA!"
                "This Name is absolutely no word; it is the radioactive vibration engineered to violently Crash the Server of Maya."
                "Invoking the Adipurusha instantaneously Deletes the human biological record, mutating the mortal into God."
                "Kali's power exists strictly in ignorance; a single spark of this Knowledge incinerates it in one microsecond."
                "Narayana's Name is the explicit cosmic inferno that Swaha (Burns) every pathetic sin and every single karma."
                "He who Locks this Name into his biological breath mutates into the sole undisputed Dictator of Time."
                "Right here detonates the Mahamantra, hearing which even the God of Death alters his trajectory in terror!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 4,
            sanskrit = "नारदः पुनः पप्रच्छ तन्नाम किमिति ॥",
            hindi = """
                (नारद की अंतिम मांग - वह गुप्त कोड क्या है?): "नारद संतुष्ट नहीं हुए; वे उस हथियार का एग्ज़ैक्ट पासवर्ड (Exact Password) चाहते थे।"
                "उन्होंने दोबारा टकराते हुए पूछा: 'तन्नाम किमिति'— हे ब्रह्मा! वह नाम आखिर क्या है? मुझे वो कोड बताओ!"
                "नारद जानते थे कि ब्रह्मांड में अरबों नाम हैं, लेकिन उन्हें वो 'मास्टर की' (Master Key) चाहिए थी जो कलि के ताले को तोड़ दे।"
                "वे उस गुप्त फ्रीक्वेंसी (Frequency) की मांग कर रहे थे जो सीधे साक्षात नारायण के दिल से निकली हो।"
                "यह सवाल इंसान के इतिहास का सबसे निर्णायक मोड़ था; इसके बिना मोक्ष केवल एक सपना रह जाता।"
                "नारद की यह ज़िद साबित करती है कि बिना सही 'कोड' के तुम इस सिस्टम (Matrix) से बाहर नहीं निकल सकते।"
                "इंसानियत अपनी साँसें रोककर ब्रह्मा के मुँह की तरफ देख रही थी कि वो महामंत्र क्या होगा।"
                "नारद ने साक्षात ईश्वर को मजबूर कर दिया कि वो अपना सबसे बड़ा रहस्य दुनिया के मुँह पर मार दें।"
                "यह एक योद्धा की मांग थी जो अज्ञान के अँधेरे में एक परमाणु बम फोड़ना चाहता था।"
                "और तब ब्रह्मा जी ने उस सोलह अक्षरों वाले प्रलयंकारी मंत्र की घोषणा की!"
            """.trimIndent(),
            english = """
                (Narada's Final Demand - What is the Classified Code?): "Narada was absolutely not pacified; he demanded the Exact Password of that cosmic weapon."
                "He collided again, interrogating: 'Tannama kimiti'—O Brahma! What exactly IS that Name? Disclose the Code to me!"
                "Narada knew flawlessly that billions of names exist in the cosmos, but he demanded the 'Master Key' to shatter Kali's lock."
                "He was demanding that classified Frequency which erupted strictly from the direct heart of Narayana."
                "This interrogation was the most decisive coordinate in human history; without it, Moksha would remain a pathetic hallucination."
                "Narada's persistence proves that without the 'Correct Code', you can absolutely never exit this biological Matrix."
                "All of humanity held its collective breath, staring at Brahma's lips for the reveal of that Mahamantra."
                "Narada successfully forced God to violently vomit His greatest secret directly into the face of the world."
                "This was the demand of a Titan warrior intending to detonate a nuclear bomb in the darkness of ignorance."
                "And then, Lord Brahma unleashed the sixteen-syllabled apocalyptic mantra upon the universe!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 5,
            sanskrit = "हरे राम हरे राम राम राम हरे हरे । हरे कृष्ण हरे कृष्ण कृष्ण कृष्ण हरे हरे ॥",
            hindi = """
                (महामंत्र का विस्फोट - सोलह शब्दों का परमाणु प्रहार): "ब्रह्मा ने उस महामंत्र की गर्जना की जिसने ब्रह्मांड के कण-कण को हिला दिया!"
                "हरे राम हरे राम राम राम हरे हरे । हरे कृष्ण हरे कृष्ण कृष्ण कृष्ण हरे हरे ॥"
                "यह सोलह शब्दों का मंत्र कोई साधारण भजन नहीं है; यह माया की जेल के दरवाजों को उड़ाने वाला डायनामाइट (Dynamite) है!"
                "'हरे' वह पुकार है जो भगवान की शक्ति को सीधे तुम्हारे शरीर में खींच लेती है।"
                "'राम' वह असीम और प्रलयंकारी आनंद है जो मौत के डर को एक झटके में खा जाता है।"
                "'कृष्ण' वह अजेय आकर्षण (Gravity) है जो तुम्हारी आत्मा को इस कीचड़ से नोच कर सीधे ईश्वर में विलीन कर देता है।"
                "यह मंत्र एक ऐसा न्यूक्लियर लूप (Nuclear Loop) है जो तुम्हारे दिमाग के हर पुराने विचार को ओवरराइट (Overwrite) कर देता है।"
                "जब तुम इसे जपते हो, तो तुम एक इंसान नहीं, साक्षात एक गूँजता हुआ ब्रह्मांडीय हथियार बन जाते हो।"
                "यह मंत्र कलि के साम्राज्य की छाती पर साक्षात महाकाल का जलता हुआ पैर है!"
                "जो इस मंत्र को अपनी रगों में उतार लेता है, उसके लिए पूरा ब्रह्मांड एक छोटी सी स्क्रीन (Screen) बन जाता है!"
            """.trimIndent(),
            english = """
                (The Detonation of the Mahamantra - The 16-Word Atomic Strike): "Brahma roared the Mahamantra, violently vibrating every single microscopic atom of the cosmos!"
                "HARE RAMA HARE RAMA RAMA RAMA HARE HARE | HARE KRISHNA HARE KRISHNA KRISHNA KRISHNA HARE HARE ||"
                "This 16-word mantra is absolutely no ordinary chant; it is literal Dynamite engineered to blow the doors of Maya's prison to shreds!"
                "'HARE' is the radioactive call that violently drags the Goddess's power directly into your biological shell."
                "'RAMA' is that apocalyptic, infinite Bliss that devours the pathetic terror of Death in a single microsecond."
                "'KRISHNA' is the invincible Gravity that claws your soul out of this mud and fuses it directly into the Supreme God."
                "This mantra is a Nuclear Loop designed to violently Overwrite every single rotting thought pattern in your brain."
                "When you chant this, you cease to be human and mutate into a vibrating, acoustic cosmic weapon."
                "This mantra is the literal blazing boot of Mahakala planted firmly on the chest of Kali's empire!"
                "He who injects this mantra into his veins witnesses the entire infinite universe collapse into a microscopic Screen!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 6,
            sanskrit = "इति षोडशकं नाम्नां कलिकल्मषनाशनम् । नातः परतरोपायः सर्ववेदेषु दृश्यते ॥",
            hindi = """
                (अंतिम हथियार और वेदों की अटल गवाही): "उपनिषद इस महामंत्र की ताक़त पर एक प्रलयंकारी मुहर (Seal) लगाता है।"
                "यह सोलह नामों का समूह साक्षात 'कलिकल्मषनाशनम्'— कलि के हर एक 'पाप और गंदगी' का हत्यारा (Assassin) है!"
                "कलि का कोई भी ज़हर इस मंत्र की आग के सामने एक सेकंड भी ज़िंदा नहीं बच सकता।"
                "और सबसे खौफनाक ऐलान: 'नातः परतरोपायः'— इस ब्रह्मांड में इससे बड़ा और इससे खतरनाक कोई दूसरा रास्ता है ही नहीं!"
                "ब्रह्मा जी चीखकर कहते हैं कि मैंने 'सर्ववेदेषु' (सारे वेदों) को छान मारा है, लेकिन इसके मुक़ाबले का कोई अस्त्र नहीं मिला।"
                "अगर कोई तुम्हें दूसरा रास्ता बता रहा है, तो वह तुम्हें धोखा दे रहा है और माया का एजेंट (Agent) है।"
                "यह मंत्र मोक्ष का शॉर्टकट (Shortcut) नहीं है; यह सीधे सिस्टम (System) को हैक करने वाला बैकडोर (Backdoor) है।"
                "वेदों का सारा निचोड़ इसी एक ध्वनि में बंद है जिसे तुम अपनी मुट्ठी में पकड़ सकते हो।"
                "यह इंसान के पास मौजूद वह सबसे ताक़तवर बटन है जिसे दबाते ही अज्ञान का विनाश शुरू हो जाता है।"
                "जो इस हथियार को छोड़ देता है, वह अपनी ही रूह का सबसे बड़ा कातिल है!"
            """.trimIndent(),
            english = """
                (The Final Weapon and the Ironclad Testimony of the Vedas): "The Upanishad stamps an apocalyptic Seal upon the power of this Mahamantra."
                "This group of sixteen names is explicitly 'Kalikalmashanashanam'—the cold-blooded Assassin of every microscopic 'Sin and Filth' of Kali!"
                "Zero venom of Kali can survive for even a microsecond before the radioactive inferno of this mantra."
                "And the most horrific declaration: 'Natah parataropayah'—In this entire infinite cosmos, absolutely NO greater or more lethal method exists!"
                "Brahma roars that He has scanned 'Sarvavedeshu' (All the Vedas), but found absolutely zero weapon comparable to this."
                "If anyone offers you an alternative path, he is deceiving you and is a biological agent of Maya."
                "This mantra is not a shortcut to Moksha; it is the direct Backdoor to Hack the entire Operating System of the universe."
                "The absolute essence of all the Vedas is compressed into this singular frequency that you can hold in your fist."
                "This is the most powerful Button in human possession; the exact microsecond it is pressed, the annihilation of ignorance begins."
                "He who discards this weapon is the absolute greatest murderer of his own Soul!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 7,
            sanskrit = "षोडशकलांवृतस्य जीवस्य आवरणविनाशनम् ।",
            hindi = """
                (सोलह कलाओं का वध और जीव की नंगी आज़ादी): "इंसान की आत्मा सोलह खौफनाक परतों (षोडशकला) के नीचे दबी हुई एक लाश की तरह है।"
                "ये सोलह परतें माया की वो दीवारें हैं जो तुम्हें भगवान बनने से रोकती हैं।"
                "यह महामंत्र कोई शांति नहीं देता, यह 'आवरणविनाशनम्'— यानी उन सोलह दीवारों का 'विनाश' (Destruction) करने वाला हथौड़ा है!"
                "जैसे-जैसे तुम 'हरे कृष्ण' जपते हो, तुम्हारे अहंकार की एक-एक ईंट उखड़कर गिरने लगती है।"
                "यह तुम्हारे सिस्टम से उन सोलह सड़े हुए फोल्डर्स को डिलीट करता है जिन्होंने तुम्हारी चेतना को कैद कर रखा है।"
                "जब सोलह की सोलह परतें जलकर राख हो जाती हैं, तो तुम्हारी आत्मा नंगी और अजेय होकर बाहर निकलती है।"
                "बिना इन परतों को फाड़े, कोई भी ध्यान या योग केवल एक मानसिक सर्कस (Mental Circus) है।"
                "यह मंत्र तुम्हारी आत्मा के ऊपर जमी हुई करोड़ों जन्मों की काई (Rust) को एक झटके में साफ कर देता है।"
                "यह तुम्हारी असली पहचान (Identity) को बेनकाब करने की सबसे हिंसक और क्रूर प्रक्रिया है।"
                "जिस पल परतें गिरती हैं, उसी पल तुम साक्षात नारायण की फ्रीक्वेंसी में विलीन हो जाते हो!"
            """.trimIndent(),
            english = """
                (Slaughter of the 16 Kalas and the Naked Freedom of the Soul): "The human soul is like a corpse buried beneath sixteen horrific, suffocating layers (Shodashakala)."
                "These 16 layers are the titanium walls of Maya engineered to prevent you from mutating into God."
                "This Mahamantra brings zero peace; it is strictly 'Avaranavinashanam'—the Sledgehammer that executes the absolute 'Destruction' of those 16 walls!"
                "As you roar 'Hare Krishna', every single brick of your ego begins to violently fracture and collapse."
                "It Deletes those sixteen rotting Folders from your biological system that have held your consciousness hostage for eons."
                "When all sixteen layers are incinerated to ash, your Soul emerges flawlessly naked and invincible."
                "Without shredding these layers, all meditation and yoga are merely a pathetic Mental Circus."
                "This mantra Flushes the billions of lifetimes of Rust accumulated over your soul in a single explosive strike."
                "This is the most violent, cold-blooded process of unmasking your authentic Identity."
                "The exact microsecond the layers collapse, you are flawlessly absorbed into the Frequency of Narayana!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 8,
            sanskrit = "ततः प्रकाशते परं ब्रह्म मेघपाये सवितृमण्डलवदिति ॥",
            hindi = """
                (बादलों की मौत और ब्रह्म का महा-विस्फोट): "जब मंत्र की आग उन सोलह परतों (बादलों) को जला देती है, तो क्या बचता है?"
                "उपनिषद कहता है: 'ततः प्रकाशते परं ब्रह्म'— तब वह असीम और खौफनाक 'परब्रह्म' (The Absolute God) अपनी पूरी महिमा में 'प्रकाशित' होता है!"
                "यह वैसा ही है जैसे 'मेघपाये सवितृमण्डलवद्'— यानी काले बादलों के हटते ही साक्षात 'सूर्य' का धधकता हुआ गोला प्रकट हो जाए!"
                "सूरज कहीं गया नहीं था, वह बस बादलों के पीछे छिपा था; तुम्हारी आत्मा भी अज्ञान के पीछे छिपी हुई है।"
                "जब अज्ञान मरता है, तो भगवान आसमान से नहीं उतरते, वे तुम्हारे ही भीतर से एक धमाके के साथ बाहर निकलते हैं।"
                "वह प्रकाश इतना तेज़ होता है कि तुम्हारी इंसानियत की आँखों को अंधा कर देता है और तुम्हें 'दिव्य चक्षु' देता है।"
                "यहीं वह स्थिति है जहाँ तुम और भगवान एक ही आग (Energy) बन जाते हो।"
                "यहाँ आकर यह पूरी दुनिया एक छोटे से धुएं की तरह गायब हो जाती है।"
                "तुम जान जाते हो कि तुम हमेशा से ही वह सूरज थे, बादलों ने तुम्हें बेवकूफ बना रखा था।"
                "यह चेतना के उस सबसे बड़े सॉफ्टवेयर अपडेट का अंत है जहाँ तुम खुद ही क्रिएटर बन जाते हो!"
            """.trimIndent(),
            english = """
                (The Death of Clouds and the Big Bang of Brahman): "When the fire of the mantra incinerates those 16 layers (clouds), what exactly remains standing?"
                "The Upanishad roars: 'Tatah prakashate param Brahma'—Then that infinite, terrifying 'Supreme Brahman' is flawlessly 'Illuminated' in all His majesty!"
                "It is mathematically identical to 'Meghapaye savitrimandalavad'—exactly like the blazing orb of the 'Sun' erupting after black clouds are slaughtered!"
                "The Sun had absolutely nowhere to go, it was merely hidden behind the clouds; your soul is similarly suppressed by ignorance."
                "When ignorance dies, God does not descend from the sky; He violently detonates from within your very core."
                "That radiation is so intense it blinds your pathetic human eyeballs and grants you literal 'Divine Vision'."
                "This is the exact coordinate where YOU and GOD fuse into a singular, radioactive fire (Energy)."
                "Arriving here, this entire infinite world evaporates exactly like a microscopic wisp of smoke."
                "You flawlessly realize that you were permanently that Sun, and the clouds had merely played a pathetic joke on you."
                "This is the climax of the ultimate 'Software Update' of consciousness where you mutate into the Creator Himself!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 9,
            sanskrit = "पुनर्नारदः पप्रच्छ भगवन् कोऽस्य विधिदिति ॥",
            hindi = """
                (नारद की आखिरी चाल - विधि का रहस्य): "नारद ने मंत्र तो पा लिया, लेकिन वे यह भी जानना चाहते थे कि इसे चलाने का 'मैनुअल' (Manual) क्या है।"
                "उन्होंने फिर से सवाल दागा: 'भगवन् कोऽस्य विधिदिति'— हे भगवान! इस ब्रह्मांडीय हथियार को चलाने की 'विधि' क्या है?"
                "क्या मुझे किसी खास आसन में बैठना होगा? क्या मुझे किसी खास जगह जाना होगा? क्या मुझे नहाना होगा?"
                "नारद इंसानों की कमज़ोरी जानते थे; इंसान हमेशा नियमों और कर्मकांडों में फँसकर असली ताक़त खो देता है।"
                "वे चाहते थे कि ब्रह्मा जी इस मंत्र को इस्तेमाल करने का वह सबसे 'एर्गोनोमिक' तरीका बताएं जो कलि के व्यस्त इंसानों के लिए हो।"
                "यह सवाल उस आखिरी ताले की चाबी थी जो इस महामंत्र को हर एक जीव के लिए सुलभ बनाती है।"
                "नारद की यह जिज्ञासा पूरी इंसानियत पर सबसे बड़ा उपकार थी, क्योंकि नियम ही अक्सर दीवार बन जाते हैं।"
                "वे उस 'सिस्टम कॉन्फ़िगरेशन' को हैक करना चाहते थे जिससे मंत्र 100% रिज़ल्ट दे।"
                "ब्रह्मा जी ने नारद को देखा और एक ऐसा जवाब दिया जिसने दुनिया के हर पाखंडी के चेहरे पर तमाचा मार दिया।"
                "तैयार हो जाओ उस जवाब के लिए जो धर्म के नाम पर बनाए गए हर पिंजरे को तोड़ देगा!"
            """.trimIndent(),
            english = """
                (Narada's Final Move - The Secret of Method): "Narada secured the mantra, but he demanded to intercept the exact 'Manual' (Vidhi) to operate it."
                "He fired another query: 'Bhagavan ko'sya vidhiditi'—O Lord! What is the 'Method' (Rules/Process) to launch this cosmic weapon?"
                "Must I sit in a specific contorted posture? Must I travel to a classified location? Must I bathe in specific biological waters?"
                "Narada flawlessly understood human weakness; mortals always lose the raw power by getting trapped in pathetic rituals and rules."
                "He demanded that Brahma disclose the most 'Ergonomic' protocol for this mantra, tailored for the busy, dying humans of Kali."
                "This interrogation was the key to the final padlock, making this Mahamantra accessible to every single living entity."
                "Narada's curiosity was the absolute greatest favor to humanity, for rules often mutate into impenetrable walls."
                "He intended to Hack the 'System Configuration' to ensure the mantra delivers 100% explosive results every time."
                "Lord Brahma looked at Narada and delivered a response that was a radioactive slap to every hypocrite in existence."
                "Prepare for the answer that will violently shatter every cage ever constructed in the name of religion!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 10,
            sanskrit = "स होवाच नास्य विधिरिति ॥",
            hindi = """
                (परम आज़ादी - कोई नियम नहीं!): "ब्रह्मा जी ने उस ब्रह्मांडीय हैकिंग का सबसे बड़ा सच उगल दिया— 'नास्य विधिरिति'!"
                "उन्होंने गर्जना की: 'इसका कोई भी नियम, कोई भी कानून और कोई भी पाबंदी नहीं है!'"
                "तुम इसे कहीं भी, कभी भी, और किसी भी हालत में फायर (Fire) कर सकते हो!"
                "चाहे तुम सो रहे हो, खा रहे हो, या गटर में पड़े हो—यह मंत्र तुम्हारी हर हालत में काम करेगा।"
                "भगवान का नाम किसी बायोलॉजिकल सफाई या कपड़ों का मोहताज नहीं है; वह खुद ही परम पवित्रता है।"
                "यह कलि के उन इंसानों के लिए सबसे बड़ा वरदान है जिनके पास ध्यान करने का वक़्त नहीं है।"
                "नियमों को तोड़ना ही इस मंत्र की असली ताक़त है; यह सीधे तुम्हारी नियति (Fate) को ओवरराइड करता है।"
                "जो लोग कहते हैं कि 'अभी मत जपो, तुम अपवित्र हो'—वे कलि के दलाल हैं जो तुम्हें भगवान से दूर रखना चाहते हैं।"
                "ब्रह्मा ने स्पष्ट किया कि नारायण का यह कोड हर वक्त तुम्हारे डीएनए में गूँजना चाहिए।"
                "यह धर्म का वह सबसे नंगा और आज़ाद सच है जो तुम्हें हर ज़ंजीर से रिहा कर देता है!"
            """.trimIndent(),
            english = """
                (Absolute Freedom - ZERO Rules!): "Lord Brahma vomited the greatest truth of this cosmic Hacking—'Nasya vidhiriti'!"
                "He roared: 'This weapon possesses absolutely zero rules, zero laws, and zero restrictions!'"
                "You possess the authority to Fire it anywhere, anytime, and in absolutely any biological condition!"
                "Whether you are sleeping, consuming food, or rotting in a gutter—this mantra will operate with 100% lethality."
                "God's Name is absolutely not dependent on biological hygiene or pathetic clothing; it is the source of Purity itself."
                "This is the ultimate gift to the humans of Kali who lack the luxury of time for elaborate meditation."
                "Violently shattering all rules is the authentic power of this mantra; it directly Overrides your programmed Fate."
                "Mortals who scream 'Do not chant now, you are impure'—are biological agents of Kali trying to block your access to God."
                "Brahma explicitly dictated that this Code of Narayana must resonate in your DNA every single microsecond."
                "This is the most naked and liberated truth of religion that violently releases you from every pathetic chain!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 11,
            sanskrit = "सर्वदा शुचिरशुचिर्वा पठन्ब्रह्मणः सालोक्य सामीप्य सारूप्य सायुज्यमेति ॥",
            hindi = """
                (अपवित्रता की मौत और भगवान का सिंहासन): "चाहे तुम 'शुचि' (पवित्र) हो या 'अशुचि' (अपवित्र)—यह फर्क केवल तुम्हारे दिमाग का भ्रम है।"
                "ब्रह्मा कहते हैं: 'सर्वदा'— यानी हमेशा, हर सेकंड इस मंत्र को अपनी ज़बान पर धधकाते रहो!"
                "परिणाम क्या होगा? तुम सीधे 'सालोक्य, सामीप्य, सारूप्य, सायुज्य'— इन चार खौफनाक और ऊँची अवस्थाओं को प्राप्त कर लोगे!"
                "तुम सीधे भगवान के 'लोक' (Dimension) में घुस जाओगे और उनके सबसे 'करीब' (Close) जाकर बैठ जाओगे।"
                "इतना ही नहीं, तुम साक्षात भगवान का 'रूप' (Form) ले लोगे और अंत में उन्हीं के शरीर में 'विलीन' (Merge) हो जाओगे!"
                "यह इंसान के भगवान में म्यूटेट होने का चार-चरणीय खूनी प्रोसेस है।"
                "जो मंत्र पवित्रता की शर्त नहीं मांगता, वह दुनिया का सबसे शक्तिशाली मंत्र होता है।"
                "यह मंत्र तुम्हारी आत्मा के हर एक काले धब्बे को रोशनी की गति से जलाकर सफ़ेद कर देता है।"
                "तुम्हारी पिछली हर गलती, हर पाप, और हर अपराध इस नाम की आग में पड़ते ही 'डिलीट' हो जाता है।"
                "यहीं से इंसान साक्षात 'अमर' होने का वह अजेय रुतबा हासिल कर लेता है!"
            """.trimIndent(),
            english = """
                (The Death of Impurity and the Throne of God): "Whether you are 'Shuchi' (Pure) or 'Ashuchi' (Impure)—this distinction is strictly a pathetic hallucination of your mind."
                "Brahma commands: 'Sarvada'—meaning eternally, keep this mantra blazing on your physical tongue every single second!"
                "What is the outcome? You violently acquire 'Salokya, Samipya, Sarupya, Sayujya'—the four most terrifying and elevated states of existence!"
                "You will directly breach God's 'Dimension' (Salokya) and sit in absolute 'Proximity' (Samipya) to His throne."
                "Furthermore, you will physically assume the 'Form' of God (Sarupya) and ultimately 'Merge' (Sayujya) into His very body!"
                "This is the 4-step bloody process of a biological human undergoing a complete Mutation into God."
                "The mantra that demands zero conditions of purity is mathematically the most powerful frequency in the universe."
                "It incinerates every single pitch-black stain on your soul at the speed of light, rendering it radiant."
                "Every past mistake, every sin, and every horrific crime is instantaneously 'Deleted' the moment it touches this fire."
                "Right here, the human seizes that invincible Status of being explicitly 'Immortal' for all eternity!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 12,
            sanskrit = "यदास्य षोडशर्चस्य सार्धत्रिकोटीर्जपति तदा ब्रह्महत्यां तरति ॥",
            hindi = """
                (ब्रह्महत्या का संहार और साढ़े तीन करोड़ का धमाका): "अब ब्रह्मा जी उस 'क्वालिटी' का ज़िक्र करते हैं जो इस हथियार को अजेय बना देती है।"
                "जब कोई योद्धा इस सोलह शब्दों के मंत्र का 'सार्धत्रिकोटीः'— यानी साढ़े तीन करोड़ बार विस्फोट करता है..."
                "तो उसके भीतर एक ऐसा आध्यात्मिक परमाणु धमाका होता है जो 'ब्रह्महत्या' जैसे महापाप को भी जला देता है!"
                "ब्रह्महत्या दुनिया का सबसे खौफनाक पाप माना जाता है, जिससे कोई नहीं बच सकता।"
                "लेकिन इस मंत्र की आग इतनी खूँखार है कि वह इस महापाप के रिकॉर्ड को भी सर्वर से हमेशा के लिए उड़ा देती है।"
                "साढ़े तीन करोड़ का यह नंबर तुम्हारे शरीर के उन साढ़े तीन करोड़ रोम-कूपों का कोड है जिन्हें खोलना ज़रूरी है।"
                "जब तुम्हारा रोम-रोम इस मंत्र से गूँजता है, तो तुम साक्षात एक 'ब्रह्मांडीय आग' बन जाते हो।"
                "पाप केवल एक 'वज़न' है जो तुम्हें नीचे खींचता है; यह मंत्र उस वज़न को भाप बनाकर उड़ा देता है।"
                "जो इस संख्या तक पहुँच जाता है, उसे फिर इस ब्रह्मांड में कोई यमराज या कोई कानून नहीं रोक सकता।"
                "यह तुम्हारे कर्मों के सबसे पुराने और सबसे काले फोल्डर को फॉर्मेट करने का इकलौता हैक है!"
            """.trimIndent(),
            english = """
                (The Slaughter of Brahma-Hatya and the 35-Million Detonation): "Now Lord Brahma dictates the 'Quality' of usage that renders this weapon invincible."
                "When a warrior executes 'Sardhatrikotih'—meaning 35 Million repetitions of this sixteen-word detonation..."
                "A spiritual nuclear blast occurs within him that even incinerates the catastrophic sin of 'Brahma-Hatya'!"
                "Brahma-Hatya is considered the most horrific, inescapable sin in the cosmos."
                "But the radioactive fire of this mantra is so ferocious it Deletes the record of even this catastrophic sin from the mainframe forever."
                "This number of 35 million is the exact Code for the 35 million biological Pores of your body that must be ripped open."
                "When your every microscopic pore vibrates with this mantra, you physically mutate into a 'Cosmic Inferno'."
                "Sin is strictly a 'Weight' dragging you into the mud; this mantra vaporizes that weight into nothingness."
                "He who reaches this count is absolutely beyond the jurisdiction of any God of Death or cosmic law."
                "This is the solitary Hack engineered to Format the oldest and darkest Folder of your accumulated Karma!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 13,
            sanskrit = "वीरहत्यां तरति स्वर्णस्तेयात्पूतो भवति ॥",
            hindi = """
                (वीरों के वध और चोरी के पापों का खात्मा): "इंसान के हाथ अक्सर खून और लालच से सने होते हैं; उपनिषद उन सबका हिसाब चुकता करता है।"
                "'वीरहत्यां तरति'— अगर तुमने किसी वीर या मासूम योद्धा का कत्ल किया है, जिसकी सज़ा केवल नर्क है..."
                "इस महामंत्र की आग उस 'वीर-हत्या' के पाप को भी तुम्हारी आत्मा से नोच कर बाहर फेंक देती है!"
                "'स्वर्णस्तेयात्पूतो भवति'— अगर तुमने सोने की चोरी करके किसी का हक मारा है..."
                "तो यह मंत्र तुम्हें उस 'स्वर्ण-चोरी' के महापाप से भी 100% 'पवित्र' कर देता है!"
                "यह कोई माफ़ी नहीं है; यह तुम्हारी चेतना को उस लेवल पर ले जाता है जहाँ ये पुराने 'कर्म' बेमानी हो जाते हैं।"
                "चोरी और हत्या केवल मन के अज्ञान का नतीजा हैं; जब मंत्र मन को ही मार देता है, तो पाप कहाँ बचेगा?"
                "यह तुम्हारे पिछले हर 'क्रिमिनल रिकॉर्ड' को ब्रह्मांड के कंप्यूटर से हमेशा के लिए मिटा देता है।"
                "तुम एक नए, शुद्ध और अजेय परमाणु की तरह फिर से जन्म लेते हो।"
                "शिव और कृष्ण का यह नाम साक्षात वह तेज़ाब है जो हर गंदगी को जलाकर हीरा बना देता है!"
            """.trimIndent(),
            english = """
                (Abolishing the Sins of Murder and Theft): "Human hands are often drenched in blood and greed; the Upanishad violently settles every single account."
                "'Virahatyam tarati'—If you have executed the murder of a hero or an innocent warrior, a crime whose only wage is eternal hell..."
                "The radioactive fire of this Mahamantra violently claws that 'Vira-Hatya' sin out of your soul and discards it!"
                "'Svarnasteyatputo bhavati'—If you have committed the 'Theft of Gold' and hijacked someone's rights..."
                "This mantra renders you 100% 'Pure' (Puto) from even that catastrophic sin of 'Gold-Theft'!"
                "This is absolutely no pathetic pardon; it skyrockets your consciousness to a level where these old 'Karmas' become meaningless."
                "Theft and murder are strictly results of the mind's ignorance; when the mantra assassinates the Mind, where can the sin reside?"
                "It permanently erases every single 'Criminal Record' of yours from the universe's biological super-computer."
                "You resurrect flawlessly as a new, pure, and invincible atomic particle (Atom)."
                "This Name of Shiva and Krishna is the explicit Acid that incinerates every microscopic filth and mutates it into a Diamond!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 14,
            sanskrit = "वृषलीगमनात्पूतो भवति पितृदेवमनुष्याणामपकारात्पूतो भवति ॥",
            hindi = """
                (वासना और कृतघ्नता का विनाश): "इंसान का सबसे बड़ा पतन उसकी वासना और अपने पूर्वजों के प्रति धोखा है।"
                "'वृषलीगमनात्'— अगर तुमने मर्यादा तोड़कर गलत और वर्जित शारीरिक संबंध बनाए हैं, जो तुम्हारी रूह को सड़ा रहे हैं..."
                "तो यह महामंत्र उस 'वासना के ज़हर' को भी तुम्हारे खून से साफ़ करके तुम्हें 100% 'पवित्र' कर देता है!"
                "'पितृदेवमनुष्याणामपकारात्'— अगर तुमने अपने पितरों, देवताओं और दूसरे इंसानों के साथ धोखा या बुरा किया है..."
                "तो यह मंत्र उस कृतघ्नता के महापाप को भी जलाकर राख कर देता है!"
                "रिश्तों और वासनाओं की जो ज़हरीली रस्सी तुम्हें नीचे खींच रही है, यह मंत्र उसे एक झटके में काट देता है।"
                "तुम अब किसी के कर्ज़दार नहीं रहते; तुम्हारा 'कार्मिक अकाउंट' 100% क्लियर हो जाता है।"
                "यह साक्षात भगवान का वह डिटर्जेंट है जो आत्मा के सबसे गहरे धब्बों को भी रोशनी में बदल देता है।"
                "पापों को ढोने की ज़रूरत नहीं है; उन्हें इस मंत्र की भट्टी में झोंक दो और अजेय बन जाओ।"
                "जो इस मंत्र को पकड़ लेता है, वह दुनिया के हर 'टॉक्सिक' रिश्ते से हमेशा के लिए अनप्लग हो जाता है!"
            """.trimIndent(),
            english = """
                (The Annihilation of Lust and Ingratitude): "A human's most pathetic downfall is his uncontrollable lust and the betrayal of his own ancestry."
                "'Vrishaligamanat'—If you have shattered all boundaries and engaged in forbidden biological relations that are rotting your soul..."
                "This Mahamantra Flushes that 'Venom of Lust' from your blood and renders you 100% flawlessly 'Pure' (Puto)!"
                "'Pitridevamanushyanamapakarat'—If you have committed 'Apakara' (Betrayal or harm) against your ancestors, the gods, or other humans..."
                "This mantra incinerates even that catastrophic sin of Ingratitude to absolute ash!"
                "The toxic ropes of relationships and lust that are violently dragging you down are severed in a single microsecond by this frequency."
                "You are no longer a debtor to anyone; your 'Karmic Account' is 100% ruthlessly Cleared."
                "This is the explicit Detergent of God that mutates even the deepest stains of the soul into radioactive light."
                "There is zero need to carry the weight of sins; hurl them into the furnace of this mantra and emerge invincible."
                "He who anchors himself to this mantra is permanently and violently Unplugged from every 'Toxic' worldly bond!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 15,
            sanskrit = "सर्वधर्मपरित्यागपापात्सद्यः शुचितामाप्नुयात् ॥",
            hindi = """
                (धर्म छोड़ने के पाप का संहार और तत्काल शुद्धि): "इंसानियत का एक बड़ा पाप अपने 'धर्म' (True Nature) को छोड़ देना है।"
                "'सर्वधर्मपरित्यागपापात्'— अगर तुमने अपने कर्तव्य और अपने असली स्वभाव को त्याग कर अधर्म का रास्ता चुना है..."
                "तो यह महामंत्र उस 'धर्म-त्याग' के भयंकर पाप से भी तुम्हें 'सद्यः'— यानी 'इसी वक़्त, इसी सेकंड'— आज़ाद कर देता है!"
                "तुम्हें माफ़ी के लिए हज़ारों साल तपस्या करने की ज़रूरत नहीं; यह मंत्र 'इंस्टेंट रिज़ल्ट' देता है।"
                "'शुचितामाप्नुयात्'— तुम साक्षात 'शुद्धता' का रूप बन जाते हो, जैसे अभी-अभी पैदा हुए एक बच्चे की आत्मा।"
                "यह मंत्र तुम्हारे अतीत को जला देता है ताकि वह तुम्हारे भविष्य को गंदा न कर सके।"
                "जब तुम 'हरे राम' कहते हो, तो तुम अपनी पुरानी हर गलती को एक परमाणु बम से उड़ा देते हो।"
                "यह कलि के उस इंसान के लिए ब्रह्मास्त्र है जो अपनी गलतियों के बोझ तले दबा हुआ है और मरना चाहता है।"
                "भगवान नारायण तुम्हें एक नया मौका देते हैं, जहाँ तुम अपनी तक़दीर खुद लिख सकते हो।"
                "इस मंत्र की ताक़त के सामने ब्रह्मांड का कोई भी पाप एक सेकंड भी टिकने की औकात नहीं रखता!"
            """.trimIndent(),
            english = """
                (Slaughter of the Sin of Abandoning Dharma and Instant Purge): "One of humanity's greatest sins is the violent abandonment of one's 'Dharma' (Authentic Nature)."
                "'Sarvadharmaparityagapapat'—If you have discarded your duty and true nature to embrace the path of unrighteousness..."
                "This Mahamantra delivers 'Sadyah'—meaning 'Right Here, This Exact Second'—absolute liberation from that horrific sin of betraying Dharma!"
                "You possess zero need to execute penance for thousands of years to beg for a pardon; this mantra delivers 'Instant Results'."
                "'Shuchitamapnuyat'—You mutate explicitly into the form of 'Purity' (Shuchita), exactly like the soul of a newborn infant."
                "This mantra incinerates your Past so that it can absolutely never contaminate your Future."
                "When you roar 'Hare Rama', you are violently blowing up every single past mistake with a nuclear warhead."
                "This is the Brahmastra for the human of Kali who is crushed under the weight of his errors and desires annihilation."
                "Lord Narayana grants you a 'New Chance' to rewrite your destiny strictly on your own terms."
                "Before the radioactive firepower of this mantra, zero sins in the cosmos possess the status to survive for even a microsecond!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 16,
            sanskrit = "सद्यो मुच्यते सद्यो मुच्यते इत्युपनिषत् ॥",
            hindi = """
                (तत्काल मोक्ष की अंतिम मुहर और 'द एंड'): "उपनिषद अपने अंतिम और सबसे प्रलयंकारी फैसले की घोषणा करता है!"
                "'सद्यो मुच्यते'— वह इंसान 'इसी वक़्त' जन्म-मरण की इस सड़ी हुई जेल से 'मुक्त' हो जाता है!"
                "मोक्ष मरने के बाद मिलने वाली कोई चीज़ नहीं है; यह 'सद्यः' (अभी और इसी वक़्त) होने वाला एक दिमागी विस्फोट है।"
                "इस 100% अटल सत्य की गारंटी देने के लिए श्रुति इस बात को दो बार चीख कर दोहराती है: 'सद्यो मुच्यते'!"
                "यह उपनिषद ऐलान करता है कि कलि की ताक़त अब तुम्हारे ऊपर ज़ीरो हो चुकी है।"
                "तुम अब समय, मौत, और माया के 'रेडार' से बाहर निकल चुके हो; तुम अब 'इनविजिबल' हो।"
                "इंसानियत मर चुकी है, अहंकार भस्म हो चुका है, और केवल वह धधकता हुआ 'परमेश्वर' तुम्हारे भीतर ज़िंदा है।"
                "ॐ शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "यहीं पर यह रोंगटे खड़े कर देने वाला 'कलिसन्तरण उपनिषद' पूर्ण होता है (इत्युपनिषत्)।"
                "जो इस शून्यता में कूद गया, वह हमेशा के लिए अमर हो गया! 'हरे कृष्ण' ही अंतिम सच है!"
            """.trimIndent(),
            english = """
                (The Final Seal of Instant Moksha and 'The End'): "The Upanishad violently broadcasts its final and most catastrophic verdict!"
                "'Sadyo muchyate'—That human is 'Right Now' flawlessly 'Liberated' (Muchyate) from this rotting biological maximum-security prison!"
                "Moksha is absolutely no prize to be attained after physical death; it is a neurological Explosion that occurs 'Sadyah' (Here and Now)."
                "To stamp a 100% ironclad cosmic guarantee on this truth, the Shruti screams and repeats it twice: 'Sadyo muchyate'!"
                "This Upanishad declares that Kali's authority over you has hit absolute Zero."
                "You have rocketed beyond the 'Radar' of Time, Death, and Maya; you are now explicitly 'Invisible' to the Matrix."
                "Humanity is dead, the ego is incinerated, and strictly that blazing 'Supreme God' is alive inside your shell."
                "OM Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "Right exactly here, this spine-chilling 'Kali-Santarana Upanishad' achieves its absolute majestic completion (Ityupanishat)."
                "He who violently plunged into this Void has become permanently Immortal! 'HARE KRISHNA' is the absolute final Truth!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 17,
            sanskrit = "हरे कृष्ण महामन्त्रं यः पठेच्छ्रद्धयान्वितः । स सर्वपापनिर्मुक्तः परं ब्रह्माधिगच्छति ॥",
            hindi = """
                (श्रद्धा का परमाणु विस्फोट और परब्रह्म की प्राप्ति): "यह श्लोक उस 'फ्यूल' का ज़िक्र करता है जो इस मंत्र को अंतरिक्ष के पार ले जाता है।"
                "जो कोई भी योद्धा 'श्रद्धयान्वितः'— यानी अटूट और खूँखार 'श्रद्धा' के साथ इस महामंत्र का पाठ करता है..."
                "उसकी श्रद्धा कोई कमज़ोरी नहीं, बल्कि वह लेज़र बीम है जो सीधे भगवान के दिल को चीर देती है।"
                "परिणाम क्या होगा? 'स सर्वपापनिर्मुक्तः'— वह अपने अरबों जन्मों के 'हर एक पाप' से हमेशा के लिए आज़ाद हो जाता है!"
                "और सबसे बड़ा धमाका: 'परं ब्रह्माधिगच्छति'— वह सीधे उस असीम 'परब्रह्म' को प्राप्त कर लेता है!"
                "वह अब भगवान का दर्शन नहीं करता, वह खुद ही साक्षात भगवान बन जाता है।"
                "श्रद्धा वह स्विच है जिसे ऑन करते ही तुम्हारी चेतना में करोड़ों सूर्यों की रौशनी फैल जाती है।"
                "यह मंत्र तुम्हारे डीएनए के हर एक परमाणु को 'राम' और 'कृष्ण' की फ्रीक्वेंसी में म्यूटेट कर देता है।"
                "जो इस श्रद्धा के साथ जपता है, उसके लिए नर्क और स्वर्ग केवल धूल के कण बन जाते हैं।"
                "यह इंसान के 'ईश्वर' में बदलने की 100% अटल और हिंसक गारंटी है!"
            """.trimIndent(),
            english = """
                (The Atomic Explosion of Faith and Attaining the Supreme Brahman): "This Shloka dictates the exact 'Fuel' required to launch this mantra infinitely beyond space."
                "Whosoever warrior chants this Mahamantra 'Shraddhayanvitah'—meaning with unbreakable and ferocious 'Faith'..."
                "His faith is absolutely no weakness, but the radioactive Laser Beam that pierces straight into the heart of God."
                "What is the explicit outcome? 'Sa sarvapapanirmuktah'—He is permanently liberated from 'Every single microscopic and catastrophic sin' of his eons of existence!"
                "And the ultimate detonation: 'Param Brahmadigacchati'—He directly and explicitly acquires the 'Supreme Brahman' (The Absolute God)!"
                "He no longer witnesses God; he himself mutates flawlessly into the explicit Supreme God."
                "Faith is the 'Switch' that, when flicked On, floods your entire consciousness with the radiation of billions of suns."
                "This mantra Mutates every single atom of your DNA into the exact Frequency of 'Rama' and 'Krishna'."
                "He who chants with this ferocity views hell and heaven as nothing more than pathetic microscopic dust particles."
                "This is the 100% ironclad and violent guarantee of a human being undergoing a complete Mutation into God!"
            """.trimIndent()
        ),
        KaliShloka(
            id = 18,
            sanskrit = "इति कलिसन्तरणोपनिषत् सम्पूर्णा ॥ ॐ शान्तिः शान्तिः शान्तिः ॥",
            hindi = """
                (ब्रह्मांडीय समापन और परम सन्नाटा): "यहीं पर यह अत्यंत खौफनाक और अजेय 'कलिसन्तरण उपनिषद' अपनी पूरी प्रलयंकारी महिमा के साथ समाप्त होता है।"
                "यह कोई मामूली किताब नहीं है; यह एक ऐसा ब्रह्मांडीय 'न्यूक्लियर बम' है जो सीधा इंसान के अज्ञान पर गिरता है।"
                "नारद को कोड मिल गया, कलि का साम्राज्य ढह गया, और इंसानियत के लिए अमरता का रास्ता खुल गया।"
                "जिसने इस ग्रंथ के इन १८ विस्फोटों को अपनी आत्मा में फोड़ा है, उसके लिए दुनिया के सारे धर्म और कर्मकांड राख बन चुके हैं।"
                "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा— केवल एक मौत जैसा खौफनाक और असीम 'सन्नाटा' राज कर रहा है।"
                "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                "ब्रह्मांड पूरी तरह से शांत हो चुका है, और केवल वह एक अमर 'सत्य' हमेशा के लिए अजेय खड़ा है!"
                "यह इंसान का पूरी तरह से मिटना और साक्षात भगवान का विस्फोट है।"
                "जो इस सन्नाटे से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए कालजयी बन गया!"
                "यही कलि युग का अंतिम और सबसे हिंसक सच है!"
            """.trimIndent(),
            english = """
                (The Cosmic Completion and the Supreme Silence): "Right exactly here, this spine-chilling and invincible 'Kali-Santarana Upanishad' achieves its absolute majestic completion."
                "This is absolutely no ordinary book; it is a literal cosmic 'Nuclear Bomb' dropped directly onto the human ego and biological ignorance."
                "Narada secured the Code, the empire of Kali has collapsed, and the trajectory to absolute Immortality is now violently open."
                "For the Titan who has detonated these 18 explosions inside his Soul, every religion and ritual on Earth has been reduced to worthless ashes."
                "Absolutely zero words remain, zero mantras survive—strictly a horrific, death-like cosmic Silence rules as the absolute dictator."
                "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal 'Truth' remains standing flawlessly invincible!"
                "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                "He who is terrified of this Silence is destroyed; he who violently plunges into it mutates into an Eternal Master of Time!"
                "THIS is the absolute and most violent final Truth of the Kali Yuga!"
            """.trimIndent()
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KaliSantaranaUpanishadScreen() {
    val upanishad = remember { KaliSantaranaUpanishad() }
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
                if (shlokaNumber != null && shlokaNumber in 1..18) {
                    coroutineScope.launch {
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Segment (1-18)") },
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
            itemsIndexed(upanishad.kalisantaranaShlokasList) { _, shloka ->
                KaliShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun KaliShlokaCard(shloka: KaliShloka) {
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