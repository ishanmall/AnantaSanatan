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

class AmritaNadaUpanishad {

    // Data Model
    data class AmritaNadaShloka(
        val id: Int,
        val sanskrit: String,
        val hindi: String,
        val english: String
    )

    companion object {
        val amritanadaShlokasList = listOf(
            AmritaNadaShloka(
                id = 1,
                sanskrit = "ॐकारं रथममारुह्य विष्णुं कृत्वाथ सारथिम् । ब्रह्मलोकपदान्वेषी रुद्राराधनतत्परः ॥ १॥",
                hindi = """
                    (ॐकार का खौफनाक रथ): "उपनिषद सबसे प्रलयंकारी और क्रूर आध्यात्मिक युद्ध की शुरुआत करता है।"
                    "योगी किसी साधारण सवारी पर नहीं, बल्कि 'ॐकार' (OM) रुपी अजेय और खौफनाक ब्रह्मांडीय 'रथ' (Chariot) पर सवार होता है!"
                    "इस प्रलयंकारी रथ का सारथी (Driver) कोई इंसान नहीं, साक्षात 'भगवान विष्णु' को बनाया जाता है।"
                    "यह यात्रा दुनिया के किसी सुख को पाने के लिए नहीं है; यह 'ब्रह्मलोक' (The Absolute Supreme Dimension) पर कब्ज़ा करने का सीधा हमला है।"
                    "इस रथ पर बैठकर योगी साक्षात मृत्यु के देवता 'रुद्र' (शिव) की आराधना में पूरी तरह खूँखार होकर लीन हो जाता है।"
                    "वह जानता है कि जब तक रुद्र का प्रलयंकारी रूप नहीं जागेगा, तब तक इस माया (Matrix) की जेल को तोड़ा नहीं जा सकता।"
                    "यह शरीर ही कुरुक्षेत्र है, ॐकार का मंत्र ही वह रथ है जो इंसान को समय और मौत के पार ले जाता है।"
                    "जो इस रथ पर नहीं बैठता, वह कीड़ों की तरह इस दुनिया के कीचड़ में पैदा होता है और कुचला जाता है।"
                    "लेकिन जो इस रथ पर सवार हो गया, उसके रास्ते से ब्रह्मांड की हर ताक़त घबराकर हट जाती है।"
                    "यह इंसानियत की हदों को चीरकर सीधा परमेश्वर से युद्ध करने और उसे जीत लेने की पहली ललकार है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Chariot of OM): "The Upanishad initiates the most apocalyptic and ruthless spiritual warfare in existence."
                    "The Yogi absolutely does not mount a pathetic earthly vehicle; he violently mounts the invincible, terrifying cosmic 'Chariot' of 'OM'!"
                    "The designated driver (Sarathi) of this apocalyptic chariot is absolutely no mortal, but explicitly 'Lord Vishnu' Himself."
                    "This crusade is not to achieve pathetic worldly pleasures; it is a direct, brutal invasion to conquer 'Brahmaloka' (The Absolute Supreme Dimension)."
                    "Mounted on this chariot, the Yogi becomes ferociously absorbed in the worship of 'Rudra' (Shiva), the literal God of cosmic annihilation."
                    "He knows flawlessly that unless Rudra's apocalyptic energy awakens, the titanium prison of Maya (Matrix) can never be shattered."
                    "This biological body is the battlefield, and the mantra OM is the explicit chariot that catapults a human beyond Time and Death."
                    "He who refuses to mount this chariot breeds and is crushed exactly like a pathetic insect in the mud of this world."
                    "But he who violently mounts it forces every single power in the cosmos to retreat in sheer absolute terror."
                    "This is the first cosmic roar to violently tear through the boundaries of humanity, wage war against the cosmos, and conquer God Himself!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 2,
                sanskrit = "तावद्रथेन गन्तव्यं यावद्रथपथि स्थितः । स्थावित्वा रथपन्थानं रथमृत्सृज्य गच्छति ॥ २॥",
                hindi = """
                    (रथ का विनाश और शून्यता में छलांग): "अध्यात्म का सबसे क्रूर और निर्दयी नियम यह है कि तुम्हें अपने ही हथियारों को अंत में जलाना पड़ता है।"
                    "उपनिषद हुक्म देता है: इस ॐकार रुपी रथ पर केवल तब तक सफर करो (तावद्रथेन गन्तव्यं), जब तक रास्ते (रथपथि) की सीमा है!"
                    "जैसे ही तुम उस 'परम शून्यता' (Absolute Void) के बॉर्डर पर पहुँचते हो, जहाँ से आगे कोई रास्ता या विचार नहीं जाता..."
                    "वहीं पर इस रथ (ॐकार के मंत्र और आवाज़) को बेरहमी से लात मारकर हमेशा के लिए छोड़ दो (रथमृत्सृज्य)!"
                    "जो मूर्ख उस रथ (शब्दों) से ही चिपका रह गया, वह कभी उस परम सन्नाटे में प्रवेश नहीं कर पाएगा।"
                    "शब्द केवल एक सीढ़ी है; जब तुम छत पर पहुँच जाओ, तो उस सीढ़ी को खाई में गिरा देना चाहिए।"
                    "ध्यान की चरम अवस्था में ॐकार की आवाज़ भी इंसान के लिए एक शोर (Noise) बन जाती है, जिसे मारना पड़ता है।"
                    "योगी ॐ को छोड़कर सीधे उस खौफनाक और असीम 'निःशब्द' (Silence) में छलांग लगा देता है।"
                    "यहीं पर साधन (Tool) की मौत होती है और साध्य (Target) का जन्म होता है।"
                    "यह इंसान के मन की वह सबसे खौफनाक और आत्मघाती छलांग है जहाँ वह अपना सब कुछ मिटा देता है!"
                """.trimIndent(),
                english = """
                    (The Annihilation of the Chariot and the Leap into the Void): "The most ruthless, cold-blooded law of spirituality is that you must ultimately incinerate your own weapons."
                    "The Upanishad commands: Travel on this Chariot of OM strictly and exclusively as long as the path exists (Tavadrathena gantavyam)!"
                    "The exact microsecond you reach the border of that 'Absolute Void' where absolutely no path or thought exists..."
                    "Right there, ruthlessly kick away and permanently abandon that exact Chariot (The mantra and sound of OM) (Rathamritsrijya)!"
                    "The pathetic fool who clings to the chariot (words) can absolutely never penetrate that Supreme, Deafening Silence."
                    "Words are merely a pathetic ladder; once you reach the cosmic roof, you must violently push the ladder into the abyss."
                    "In the absolute climax of meditation, even the sacred sound of OM mutates into 'Noise' that must be brutally slaughtered."
                    "The Yogi abandons OM and executes a terrifying, suicidal leap directly into that infinite, horrific 'Nishabda' (Silence)."
                    "Right here, the Tool suffers a violent death, and the Ultimate Target is flawlessly born."
                    "This is the human mind's most terrifying, apocalyptic leap where he completely and permanently erases his own existence!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 3,
                sanskrit = "मात्रालिङ्गपदं त्यक्त्वा शब्दव्यञ्जनवर्जितम् । अस्वरेण मकारेण पदं सूक्ष्मं च गच्छति ॥ ३॥",
                hindi = """
                    (शब्दों का कत्ल और सूक्ष्म सन्नाटा): "जब रथ छूट जाता है, तो योगी ॐ के भौतिक शब्दों (अ, उ) का पूरी तरह कत्ल कर देता है।"
                    "वह मात्रा, लिंग और पदों की भौतिक दुनिया को हमेशा के लिए त्याग देता है (मात्रालिङ्गपदं त्यक्त्वा)।"
                    "वह उस खौफनाक डायमेंशन में घुसता है जो पूरी तरह से 'शब्दव्यञ्जनवर्जितम्' है— जहाँ न कोई स्वर है, न कोई व्यंजन, और न ही कोई आवाज़!"
                    "वहाँ केवल एक असीम और 'स्वर-रहित मकार' (अस्वरेण मकारेण) यानी एक गहरा, सुन्न कर देने वाला सन्नाटा गूँज रहा होता है।"
                    "यह सन्नाटा मौत से भी ज़्यादा भारी है, क्योंकि यह इंसान के 'मैं' को कुचल देता है।"
                    "योगी इस सन्नाटे के ज़रिए उस 'परम सूक्ष्म पद' (The Ultimate Micro-Dimension) में प्रवेश कर जाता है।"
                    "यह वह अवस्था है जहाँ दिमाग के न्यूरॉन्स (Neurons) काम करना बंद कर देते हैं और केवल शुद्ध चेतना धड़कती है।"
                    "जो आवाज़ों और शब्दों में भगवान को खोज रहे हैं, वे केवल भ्रम में जी रहे हैं।"
                    "परमेश्वर चीखने में नहीं, बल्कि मन के इस सबसे खौफनाक और सड़े हुए शोर के मरने के बाद मिलता है।"
                    "यह वो ब्रह्मांडीय हैकिंग है जहाँ योगी बिना आवाज़ के पूरे ब्रह्मांड को अपने भीतर खींच लेता है।"
                """.trimIndent(),
                english = """
                    (The Slaughter of Words and the Micro-Silence): "When the chariot is abandoned, the Yogi violently slaughters the physical syllables (A, U) of OM."
                    "He permanently and ruthlessly discards the physical world of letters, genders, and pathetic grammar (Matralingapadam tyaktva)."
                    "He violently breaches that terrifying dimension which is entirely 'Shabdavyanjanavarjitam'—possessing zero vowels, zero consonants, and absolute zero sound!"
                    "There, strictly an infinite, 'Vowelless Makara' (Asvarena makarena) echoes—a profound, paralyzing, deafening silence."
                    "This explicit silence is infinitely heavier than literal death, because it brutally crushes the human 'I' to dust."
                    "Through this radioactive silence, the Yogi penetrates directly into that 'Parama Sukshma Pada' (The Ultimate Micro-Dimension)."
                    "This is the exact coordinate where the biological neurons of the brain completely shut down, leaving strictly pure Consciousness to pulsate."
                    "Those pathetic mortals hunting for God in words and chants are rotting in pure hallucination."
                    "The Supreme God is absolutely not found in screaming, but strictly detonates after this rotting noise of the mind dies a brutal death."
                    "This is the cosmic hack where the Yogi, without generating a micro-drop of sound, violently sucks the entire universe into his core."
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 4,
                sanskrit = "शब्दादिभिर्विहीनाभिः पञ्चभिर्मानसीभिश्च । इन्द्रियैर्निग्रहं कृत्वा प्रत्याहारः स उच्यते ॥ ४॥",
                hindi = """
                    (पाँचों इंद्रियों का निर्मम गला घोंटना): "सूक्ष्म अवस्था में जाने के लिए इंसान को अपने ही शरीर पर एक क्रूर हमला करना पड़ता है।"
                    "इंसान की पाँचों इंद्रियां— आँखें (रूप), कान (शब्द), नाक (गंध), जीभ (स्वाद) और त्वचा (स्पर्श)— उसे बाहर घसीटती हैं।"
                    "उपनिषद का खूँखार आदेश है: इन पाँचों को उनके बाहरी विषयों (शब्दादिभिर्विहीनाभिः) से पूरी तरह काट कर अंधा, बहरा और सुन्न कर दो!"
                    "मन के चाबुक (मानसीभिश्च) का इस्तेमाल करके इन पाँचों जंगली कुत्तों (इंद्रियों) की गर्दन पर ज़ंजीर डाल दो और उन्हें कुचल दो (निग्रहं कृत्वा)!"
                    "तुम्हें ज़िंदा रहते हुए खुद को एक ऐसी लाश में बदलना होगा जिसे दुनिया की कोई आवाज़ और कोई खूबसूरत चीज़ हिला न सके।"
                    "जब तक तुम्हारी इंद्रियां खुली हैं, तुम इस माया की जेल के सबसे कमज़ोर कैदी हो।"
                    "जैसे कछुआ अपने अंगों को कठोर खोल में खींच लेता है, वैसे ही योगी अपनी चेतना को बाहर से नोच कर अंदर खींच लेता है।"
                    "यह कोई सामान्य ध्यान नहीं; यह अपने ही बायोलॉजिकल सिस्टम (Biological System) का शटडाउन (Shutdown) है।"
                    "इंद्रियों का यह खौफनाक दमन ही उस परम आग को जन्म देता है जो अज्ञान को राख करती है।"
                    "जो अपनी आँखें और कान बंद नहीं कर सकता, वह ब्रह्मांड का सबसे बड़ा अंधा और बहरा है।"
                """.trimIndent(),
                english = """
                    (The Ruthless Strangling of the Five Senses): "To breach the micro-dimension, a human must launch a brutal, catastrophic assault upon his own physical body."
                    "The five biological senses—eyes (form), ears (sound), nose (smell), tongue (taste), and skin (touch)—violently drag him outward."
                    "The Upanishad issues a ferocious command: Ruthlessly sever these five from their external targets (Shabdadibhirvihinabhih), rendering them totally blind, deaf, and dead!"
                    "Weaponize the bullwhip of your Mind (Manasibhishcha) to throw titanium chains around the necks of these five wild dogs (senses) and completely crush them (Nigraham kritva)!"
                    "While still breathing, you must forcibly mutate yourself into a literal corpse that absolutely no worldly sound or beauty can ever flinch."
                    "As long as your senses remain open, you are the weakest, most pathetic prisoner in this Matrix of Maya."
                    "Exactly like a turtle violently retracting its limbs into an impenetrable shell, the Yogi violently claws his consciousness inward."
                    "This is absolutely no ordinary meditation; it is the forced, tyrannical Shutdown of your own biological system."
                    "This horrific suppression of the senses is exactly what spawns that radioactive fire which incinerates cosmic ignorance."
                    "He who cannot brutally shut his physical eyes and ears is the greatest blind and deaf entity in the cosmos."
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 5,
                sanskrit = "प्रत्याहारस्तथा ध्यानं प्राणायामोऽथ धारणा । तर्कश्चैव समाधिश्च षडङ्गो योग उच्यते ॥ ५॥",
                hindi = """
                    (प्रलयंकारी षडंग योग का महा-ऐलान): "अब यह उपनिषद ब्रह्मांड को जीतने के उस असली और खूनी ब्लूप्रिंट (Blueprint) की घोषणा करता है।"
                    "मोक्ष कोई खैरात नहीं है, यह छह खौफनाक सीढ़ियों का एक युद्ध है जिसे 'षडंग योग' (Six-limbed Yoga) कहा जाता है!"
                    "पहली सीढ़ी है 'प्रत्याहार' (अपनी इंद्रियों को नोच कर अंदर लाना)।"
                    "दूसरी है 'ध्यान' (मन के हर फालतू विचार का कत्ल करके केवल एक लक्ष्य पर लेज़र बीम की तरह फोकस करना)।"
                    "तीसरी है 'प्राणायाम' (अपनी साँसों को गुलाम बनाकर शरीर की बैटरी को हैक करना)।"
                    "चौथी है 'धारणा' (अपनी चेतना को शरीर के एक ही बिंदु पर हथौड़े की तरह गाड़ देना)।"
                    "पाँचवीं है 'तर्क' (सच्चाई और झूठ के बीच की दीवार को अपनी शुद्ध बुद्धि से काट डालना)।"
                    "और छठी सबसे खौफनाक अवस्था है 'समाधि'— जहाँ इंसान का दिमाग 100% फटकर शून्य हो जाता है और वह साक्षात ईश्वर बन जाता है!"
                    "सनातन धर्म का यह योग कोई स्ट्रेचिंग (Stretching) या पोज़ (Pose) नहीं है; यह एक बायोलॉजिकल इंसान को भगवान में अपग्रेड करने का क्रूर विज्ञान है।"
                    "जो इन छह सीढ़ियों पर खून पसीना बहाता है, वह साक्षात शिव के तख़्त का वारिस बन जाता है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Declaration of Shadanga Yoga): "Now this Upanishad violently announces the authentic, bloody Blueprint required to literally conquer the cosmos."
                    "Moksha is absolutely no pathetic charity; it is a brutal warfare of six terrifying steps, explicitly defined as 'Shadanga Yoga' (The Six-limbed Yoga)!"
                    "The first dimension is 'Pratyahara' (Violently clawing and dragging your senses inward)."
                    "The second is 'Dhyana' (Slaughtering every microscopic stray thought to focus like a concentrated, radioactive laser beam)."
                    "The third is 'Pranayama' (Enslaving your biological breath to physically hack the body's energy battery)."
                    "The fourth is 'Dharana' (Hammering your raw consciousness like a titanium nail directly into a single coordinate)."
                    "The fifth is 'Tarka' (Brutally slashing the wall between Truth and Illusion using the sword of pure intellect)."
                    "And the sixth, most horrific climax is 'Samadhi'—where the human brain 100% detonates into absolute zero, mutating him explicitly into God!"
                    "This Yoga of Sanatana Dharma is absolutely no pathetic stretching or posing; it is the ruthless biological science of upgrading a mortal into the Supreme Dictator."
                    "He who bleeds and sweats on these six ladders instantaneously becomes the sole, undisputed heir to the throne of Shiva!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 6,
                sanskrit = "यथा पर्वधातूनां दह्यन्ते ध्मायता मलाः । तथेन्द्रियकृता दोषा दह्यन्ते प्राणनिग्रहात् ॥ ६॥",
                hindi = """
                    (प्राणायाम: शरीर के कचरे को जलाने वाली आग): "प्राणायाम केवल हवा अंदर-बाहर करना नहीं है; यह शरीर के भीतर एक 'भट्ठी' (Furnace) जलाना है!"
                    "उपनिषद एक खौफनाक उदाहरण देता है: 'यथा पर्वधातूनां दह्यन्ते ध्मायता मलाः'—"
                    "जैसे सोने या लोहे को भट्टी में डालकर भयानक आग से तपाया जाता है, तो उसके भीतर का सारा कचरा और ज़ंग जलकर राख हो जाता है..."
                    "ठीक उसी क्रूर और हिंसक तरीके से, जब योगी 'प्राणनिग्रहात्' (अपनी साँसों को रोककर उसका गला घोंटता है)..."
                    "तो उसके शरीर में एक ब्रह्मांडीय गर्मी (Heat) पैदा होती है जो उसकी इंद्रियों के करोड़ों जन्मों के 'दोषों' (Sins/Toxins) को भस्म कर देती है!"
                    "तुम्हारे फेफड़ों में रुकने वाली साँस कोई ऑक्सीजन नहीं; वह एक न्यूक्लियर ऊर्जा है जो तुम्हारी हर बीमारी और वासना को जला डालती है।"
                    "साँस पर कंट्रोल करने का मतलब है सीधे अपने 'नर्वस सिस्टम' (Nervous System) को हाईजैक (Hijack) कर लेना।"
                    "जो अपनी साँसों को अपना गुलाम नहीं बना सकता, वह मौत का गुलाम बनने के लिए मजबूर है।"
                    "प्राणायाम वह खौफनाक प्रहार है जिससे इंसान का भौतिक शरीर एक 'दिव्य मशीन' (Divine Machine) में अपग्रेड हो जाता है।"
                    "इस आग में जलने के बाद ही इंसान की चेतना उस परम शून्यता में प्रवेश करने लायक बनती है!"
                """.trimIndent(),
                english = """
                    (Pranayama: The Radioactive Furnace Incinerating Biological Garbage): "Pranayama is absolutely not the pathetic act of breathing air in and out; it is detonating a literal 'Furnace' directly inside your flesh!"
                    "The Upanishad strikes with a terrifying metaphor: 'Yatha parvadhatunam dahyante dhmayata malah'—"
                    "Just as raw gold or iron is thrown into a blazing forge and heated mercilessly until every micro-ounce of slag and rust is incinerated to ash..."
                    "In the exact same brutal, violent mechanism, when the Yogi executes 'Prananigrahat' (ruthlessly strangling and holding his breath hostage)..."
                    "He generates an apocalyptic cosmic heat inside his biology that completely incinerates billions of lifetimes of sensory 'Sins and Toxins' (Doshas) into absolute dust!"
                    "The breath held captive in your lungs is absolutely not oxygen; it is radioactive nuclear energy burning every pathetic disease and lust within you."
                    "Exerting tyrannical control over your breath literally means executing a complete Hijack of your biological Nervous System."
                    "He who cannot enslave his own breath is permanently condemned to remain a pathetic slave to Death."
                    "Pranayama is the horrific strike that violently upgrades a rotting physical body into an indestructible 'Divine Machine'."
                    "Strictly only after burning in this furnace does human consciousness attain the terrifying caliber to penetrate the Supreme Void!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 7,
                sanskrit = "प्राणायामैर्दहेद्दोषान् धारणाभिश्च किल्बिषान् । प्रत्याहारेण संसर्गान् ध्यानेनानीश्वरान् गुणान् ॥ ७॥",
                hindi = """
                    (पापों का विनाश करने वाला ब्रह्मांडीय लेज़र): "यह श्लोक योग के हथियारों का सबसे क्रूर और सटीक इस्तेमाल (Targeting) सिखाता है।"
                    "उपनिषद चीख कर कहता है: 'प्राणायामैर्दहेद्दोषान्'— प्राणायाम की धधकती आग से अपने शरीर और मन के सारे 'दोषों' (Toxins/Impurities) को जलाकर राख कर दो!"
                    "'धारणाभिश्च किल्बिषान्'— अपनी चेतना को एक बिंदु पर ठोककर (धारणा), अपने पिछले करोड़ों जन्मों के 'महापापों' (किल्बिष) का बेरहमी से वध कर दो!"
                    "'प्रत्याहारेण संसर्गान्'— अपनी इंद्रियों को नोच कर अंदर खींचने (प्रत्याहार) वाले हथियार से दुनिया के सारे झूठे 'रिश्तों और लगावों' (Attachments) का कत्ल कर दो!"
                    "और 'ध्यानेनानीश्वरान् गुणान्'— ध्यान के लेज़र बीम से अपने भीतर के उन सभी सड़े हुए 'गुणों' (क्रोध, लोभ, अहंकार) को उड़ा दो जो तुम्हें भगवान बनने से रोकते हैं!"
                    "योग कोई शांति का संदेश नहीं है; यह अपने ही भीतर के राक्षसों पर किया गया एक खूनी सर्जिकल स्ट्राइक (Surgical Strike) है।"
                    "हर एक टूल (Tool) का इस्तेमाल अज्ञान की एक विशेष परत को फाड़ने के लिए किया जाता है।"
                    "जब तुम इन चारों हथियारों को एक साथ फायर (Fire) करते हो, तो इंसानियत का अस्तित्व मिट जाता है।"
                    "कोई भी कर्मकांड तुम्हें वह नहीं दे सकता जो खुद की आत्मा पर किया गया यह हिंसक हमला देता है।"
                    "पापों को धोने के लिए नदियों में मत नहाओ; योग की इस प्रलयंकारी आग में कूद जाओ!"
                """.trimIndent(),
                english = """
                    (The Cosmic Laser Annihilating Sins): "This Shloka dictates the most brutal, calculated targeting of Yoga's apocalyptic weapons."
                    "The Upanishad screams: 'Pranayamairdahaddoshan'—Weaponize the blazing inferno of Pranayama to incinerate every single 'Toxin and Defect' (Dosha) in your body and mind to ash!"
                    "'Dharanabhishcha kilbishan'—Hammer your consciousness like a titanium nail into a single coordinate (Dharana) to ruthlessly slaughter your billions of past 'Catastrophic Sins' (Kilbisha)!"
                    "'Pratyaharena samsargan'—Deploy the weapon of violently ripping your senses inward (Pratyahara) to execute the absolute murder of all worldly 'Attachments and Ties' (Samsarga)!"
                    "And 'Dhyanenanishvaran gunan'—Fire the concentrated laser beam of Meditation (Dhyana) to blow up every single rotting 'Trait' (Anger, Greed, Ego) preventing your mutation into God!"
                    "Yoga is absolutely no pathetic message of peace; it is a bloody, ruthless Surgical Strike launched directly against the demons living inside your own skull."
                    "Every single weapon is engineered specifically to violently shred a distinct layer of cosmic ignorance."
                    "When you simultaneously detonate all four of these nuclear weapons, the pathetic existence of humanity is completely erased."
                    "Absolutely zero external rituals can grant you what this violently catastrophic internal assault delivers."
                    "Stop bathing in pathetic rivers to wash your sins; violently plunge yourself directly into this apocalyptic fire of Yoga!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 8,
                sanskrit = "रुचिरं रेचकं चैव गच्छन्तीमूर्ध्वमारुताम् । यदाकर्षति निःश्वासं स पूरक इति स्मृतः ॥ ८॥",
                hindi = """
                    (रेचक और पूरक की खौफनाक हैकिंग): "अब उपनिषद साँसों के उस रहस्य को खोलता है जिससे तुम अपने शरीर के सिस्टम (System) को ओवरराइड (Override) कर सकते हो।"
                    "जब तुम अपने भीतर की दूषित हवा को पूरी ताक़त से बाहर की ओर (ऊर्ध्वमारुताम्) फेंकते हो, तो वह सामान्य साँस छोड़ना नहीं है।"
                    "वह 'रेचक' है! यह ऐसा है जैसे तुम अपने शरीर की चिमनी से करोड़ों जन्मों का ज़हर और अंधकार बाहर निकाल कर फेंक रहे हो।"
                    "और जब तुम बाहर की असीम ब्रह्मांडीय ऊर्जा को एक प्रचंड ताक़त के साथ अंदर की तरफ खींचते हो (आकर्षति निःश्वासं)..."
                    "तो उसे 'पूरक' कहते हैं! यह ऑक्सीजन नहीं है; यह सीधे उस परमेश्वर की ऊर्जा (Prana) को अपने फेफड़ों में ठूंसना है।"
                    "रेचक और पूरक केवल फेफड़ों की कसरत नहीं हैं; यह अपने नर्वस सिस्टम (Nervous System) की कोडिंग (Coding) को बदलने का विज्ञान है।"
                    "जब योगी इन दोनों पर अपना तानाशाह वाला कंट्रोल कर लेता है, तो उसकी बायोलॉजिकल घड़ी (Biological Clock) हैक हो जाती है।"
                    "वह तय करता है कि उसके शरीर का कौन सा हिस्सा कब तक ज़िंदा रहेगा।"
                    "साँसें इंसान को मौत की तरफ ले जाती हैं, लेकिन प्राणायाम उन साँसों को वापस उल्टा (Reverse) घुमाकर इंसान को अमरता की तरफ ले जाता है।"
                    "जो अपनी साँसों का राजा बन गया, वही ब्रह्मांड के समय (Time) का राजा बन जाता है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Hacking via Rechaka and Puraka): "Now the Upanishad violently rips open the exact respiratory secret to completely Override your biological system."
                    "When you execute the violent expulsion of toxic air upward and outward from your core (Urdhvamarutam), it is absolutely no normal exhalation."
                    "That is 'Rechaka'! It is exactly like vomiting out billions of lifetimes of literal venom, darkness, and karma through the biological chimney of your flesh."
                    "And when you ferociously inhale and drag the infinite cosmic energy of the universe directly into your system (Akarshati nishvasam)..."
                    "That is explicitly defined as 'Puraka'! This is absolutely not pathetic oxygen; it is violently cramming the raw radioactive energy of God (Prana) into your lungs."
                    "Rechaka and Puraka are absolutely no lung gymnastics; it is the brutal science of completely rewriting the Coding of your entire Nervous System."
                    "When the Yogi asserts dictatorial, tyrannical control over both, his Biological Clock is instantaneously Hacked."
                    "He explicitly dictates exactly which part of his biology remains alive and for how long."
                    "Normal breathing violently drags a mortal toward Death, but Pranayama brutally Reverses those breaths, launching the human directly into Immortality."
                    "He who successfully mutates into the absolute King of his breaths simultaneously becomes the undisputed Dictator of Cosmic Time!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 9,
                sanskrit = "न चोच्छ्वसिति निःश्वासं न च गात्राणि चालयेत् । एवं भावमुपागम्य कुम्भकः स विधीयते ॥ ९॥",
                hindi = """
                    (कुम्भक: साँसों की मौत और समय का रुकना): "रेचक और पूरक के बाद योग का सबसे खौफनाक और प्रलयंकारी हथियार आता है— 'कुम्भक'!"
                    "उपनिषद का क्रूर आदेश है: 'न चोच्छ्वसिति निःश्वासं'— न तो अंदर की साँस बाहर जानी चाहिए, और न ही बाहर की साँस अंदर आनी चाहिए!"
                    "साँसों के इस बहाव को एक झटके में पत्थर की तरह पूरी तरह से 'रोक' (Lock) दो!"
                    "'न च गात्राणि चालयेत्'— तुम्हारे शरीर का एक मिलीमीटर हिस्सा भी हिलना नहीं चाहिए; तुम साक्षात एक मुर्दे या पत्थर की मूर्ति में बदल जाओ।"
                    "जब तुम इस खौफनाक 'भाव' (अवस्था) में पूरी तरह जम जाते हो, तो उसे ब्रह्मांडीय 'कुम्भक' कहा जाता है।"
                    "कुम्भक कोई मज़ाक नहीं है; यह जानबूझकर अपनी मौत को अनुभव करने की प्रक्रिया है।"
                    "जब साँसें रुक जाती हैं, तो तुम्हारे दिमाग का सोचने वाला सॉफ्टवेयर (Mind) ऑक्सीजन की कमी से तड़पने लगता है और क्रैश (Crash) हो जाता है।"
                    "जिस पल दिमाग सोचना बंद करता है, उसी सेकंड 'समय' (Time) का पहिया रुक जाता है।"
                    "कुम्भक के दौरान योगी समय और अंतरिक्ष (Space) के उस पार निकल जाता है जहाँ कोई उम्र नहीं बढ़ती और कोई मौत नहीं होती।"
                    "साँसों का रुकना ही अज्ञान की मौत और परम शून्यता (God) का जन्म है!"
                """.trimIndent(),
                english = """
                    (Kumbhaka: The Assassination of Breath and the Freezing of Time): "After Rechaka and Puraka arrives the most terrifying, apocalyptic weapon in the arsenal of Yoga—'Kumbhaka'!"
                    "The Upanishad issues a draconian command: 'Na chocchvasiti nishvasam'—Absolutely zero internal breath must escape, and absolutely zero external breath must enter!"
                    "Violently and completely 'Lock' the entire biological flow of respiration into a dead, stone-like halt!"
                    "'Na cha gatrani chalayet'—Not a single micro-millimeter of your flesh is allowed to twitch; you must instantaneously mutate into a literal rotting corpse or a stone idol."
                    "When you permanently freeze into this horrific 'Bhava' (Dimension), it is explicitly defined as the cosmic 'Kumbhaka'."
                    "Kumbhaka is absolutely no joke; it is the deliberate, cold-blooded process of physically simulating and experiencing your own Death."
                    "When the breath is brutally assassinated, the thought-generating software of your brain suffocates, panics, and totally Crashes."
                    "The exact microsecond the brain terminates all thoughts, the very wheel of 'Time' comes to a violent, grinding halt."
                    "During Kumbhaka, the Yogi rockets beyond Time and Space into a dimension where biological aging and Death completely cease to exist."
                    "The absolute freezing of breath is the explicit death of ignorance and the violent birth of the Supreme Void (God)!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 10,
                sanskrit = "अन्धः पश्यति यद्रूपं बधिरः शृणुते ध्वनिम् । एतल्लक्षणमासाद्य कुम्भकं तु समभ्यसेत् ॥ १०॥",
                hindi = """
                    (कुम्भक की अलौकिक सिद्धि: अंधे का देखना, बहरे का सुनना): "जब कुम्भक की आग योगी के भीतर धधकती है, तो उसके शरीर के बायोलॉजिकल नियम (Biological laws) जलकर राख हो जाते हैं।"
                    "उपनिषद उस खौफनाक सिद्धि (Superpower) का वर्णन करता है जो कुम्भक से पैदा होती है: 'अन्धः पश्यति यद्रूपं'!"
                    "यानी, बिना आँखों के, बंद आँखों के भी वह योगी ब्रह्मांड के उस गुप्त 'रूप' को साक्षात 'देखने' लगता है जो किसी इंसान को दिखाई नहीं देता!"
                    "'बधिरः शृणुते ध्वनिम्'— बाहरी कानों के सुन्न (बहरा) हो जाने पर भी, वह योगी अपने भीतर गूँजने वाले उस ब्रह्मांडीय 'नाद' (Cosmic Roar) को 'सुनने' लगता है!"
                    "इंसान की चमड़े की आँखें और कान बहुत कमज़ोर हैं; असली ब्रह्मांड को देखने और सुनने के लिए इन इंद्रियों को अंधा और बहरा करना ही पड़ता है।"
                    "जब शरीर के बाहरी कैमरे (Senses) शटडाउन हो जाते हैं, तब आत्मा का असली रडार (Radar) ऑन (On) होता है।"
                    "उपनिषद कहता है: जब तुम्हें ये खौफनाक लक्षण (लक्षणमासाद्य) महसूस होने लगें, तब समझो कि तुम्हारा कुम्भक सफल हो रहा है।"
                    "तुम्हें इसी भयंकर अवस्था का लगातार और क्रूरता से अभ्यास (समभ्यसेत्) करना है।"
                    "यह शरीर को हैक (Hack) करके सीधे परमेश्वर की फ्रीक्वेंसी (Frequency) पकड़ने का अचूक विज्ञान है।"
                    "कुम्भक इंसान को एक म्यूटेंट (Mutant/God) बना देता है जिसके लिए भौतिक विज्ञान के सारे नियम कचरा हैं!"
                """.trimIndent(),
                english = """
                    (The Supernatural Siddhi of Kumbhaka: The Blind Sees, the Deaf Hears): "When the radioactive fire of Kumbhaka blazes inside the Yogi, every single biological law governing his body burns to absolute ashes."
                    "The Upanishad describes the terrifying 'Superpower' (Siddhi) spawned by Kumbhaka: 'Andhah pashyati yadrupam'!"
                    "Meaning, even without physical eyeballs, with his eyes brutally shut, the Yogi begins to explicitly 'See' the classified 'Form' of the cosmos invisible to mortals!"
                    "'Badhirah shrinute dhvanim'—Even with his external ears completely numb and paralyzed (deaf), he distinctly 'Hears' the apocalyptic 'Nada' (Cosmic Roar) vibrating inside his core!"
                    "Humanity's leather eyes and ears are pathetically weak; to perceive the authentic cosmos, these physical senses must be violently rendered blind and deaf."
                    "When the external biological cameras (Senses) are totally Shut Down, the true Radar of the Soul is violently switched On."
                    "The Upanishad commands: When you begin to explicitly experience these terrifying symptoms (Lakshanamasadya), realize your Kumbhaka is achieving absolute detonation."
                    "You must relentlessly and ruthlessly practice (Samabhyaset) this exact horrific dimension."
                    "This is the flawless science of Hacking the biological body to directly intercept the exact Frequency of the Supreme God."
                    "Kumbhaka literally mutates a human into a Titan/God for whom every pathetic law of physics is reduced to rotting garbage!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 11,
                sanskrit = "स्वेदात्सञ्जायते व्याधिः क्षयं गच्छति कम्पनात् । उत्थानात् खेचरत्वं स्यात् प्राणायामेन तत्सर्वम् ॥ ११॥",
                hindi = """
                    (प्राणायाम के झटके और पसीने का विज्ञान): "जब प्राणायाम की ब्रह्मांडीय ऊर्जा शरीर के तारों (Nerves) में दौड़ती है, तो शरीर तड़प उठता है।"
                    "शुरुआती अभ्यास में योगी के शरीर से भयंकर 'पसीना' (स्वेद) छूटने लगता है; यह कोई आम पसीना नहीं, यह जन्मों की बीमारियों (व्याधि) का बाहर निकलना है।"
                    "जब वह ऊर्जा और तेज़ होती है, तो योगी का शरीर भूकंप की तरह 'काँपने' लगता है; यह नर्वस सिस्टम का ओवरलोड (Overload) है।"
                    "और जब वह कुम्भक अपनी सबसे खौफनाक चरम सीमा पर पहुँचता है, तो योगी का शरीर धरती छोड़कर हवा में 'उठने' (Levitate/खेचरत्वं) लगता है!"
                    "यह कोई जादू नहीं है; यह प्राणायाम के प्रलयंकारी प्रभाव से गुरुत्वाकर्षण (Gravity) के नियम को पूरी तरह से कुचल देना है (प्राणायामेन तत्सर्वम्)।"
                    "योगी की साँसें उसके शरीर के हर ज़हर, हर बीमारी और हर कर्म को जलाकर राख कर देती हैं।"
                    "उसका शरीर अब एक बायोलॉजिकल ढांचा नहीं रहता, बल्कि वह एक 'लाइट-बॉडी' (Light Body / ऊर्जा का शरीर) में अपग्रेड हो जाता है।"
                    "जो इंसान पसीने और दर्द से डरकर योग छोड़ देता है, वह उसी कीचड़ में वापस गिरता है।"
                    "लेकिन जो इस दर्द की भट्टी में खुद को जलाता है, उसका शरीर साक्षात वज्र (Titanium) का बन जाता है।"
                    "यह मौत की सीमाओं को पार करके सुपर-ह्यूमन (Super-human) बनने की सबसे दर्दनाक और सच प्रक्रिया है!"
                """.trimIndent(),
                english = """
                    (The Shocks of Pranayama and the Science of Sweat): "When the cosmic, radioactive energy of Pranayama surges violently through the biological nerves, the physical shell writhes in agony."
                    "In the initial brutal practice, horrific 'Sweat' (Sveda) erupts from the Yogi's pores; this is no ordinary sweat, it is the violent expulsion of lifetimes of 'Diseases' (Vyadhi)."
                    "As that volatile energy intensifies, the Yogi's body begins to 'Tremble and Convulse' exactly like an earthquake; this is a literal overload of the nervous system."
                    "And when that Kumbhaka skyrockets to its most terrifying, apocalyptic climax, the Yogi's physical body literally disconnects from the earth and begins to 'Levitate' (Khecharatvam)!"
                    "This is absolutely no pathetic magic trick; it is the catastrophic impact of Pranayama violently crushing the absolute law of Gravity (Pranayamena tatsarvam)."
                    "The Yogi's breath incinerates every micro-drop of venom, every disease, and every biological karma into absolute ash."
                    "His body completely ceases to be a biological framework, violently Upgrading into an indestructible 'Light Body' of pure energy."
                    "The human who cowers from this sweat and agony and abandons Yoga plummets straight back into the rotting mud."
                    "But he who ruthlessly burns himself in this furnace of pain mutates his flesh into literal indestructible Titanium."
                    "This is the most agonizing, absolute factual process of tearing through the limits of Death to mutate into a Super-human!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 12,
                sanskrit = "द्वादशमात्रा योगः स्यात् द्वाविंशतिस्तु धारणा । एकविंशतिरित्याहुः प्रणायामस्य निश्चयः ॥ १२॥",
                hindi = """
                    (बारह मात्राओं का रहस्य और धारणा की ताक़त): "अब उपनिषद समय और चेतना को मापने का सबसे सूक्ष्म (Micro) फॉर्मूला देता है।"
                    "तुम्हारी आँख पलक झपकाने में जितना समय लेती है, वह एक 'मात्रा' (Matra) है; और ऐसे 'बारह मात्राओं' (द्वादशमात्रा) का समय ध्यान का पहला गियर (Gear) है।"
                    "जब तुम अपनी साँसों को इन बारह मात्राओं तक पूरी तरह रोककर (कुम्भक) मन को एक जगह ठोक देते हो, तो उसे एक 'योग' कहते हैं।"
                    "जब तुम इस अवधि को और बढ़ा देते हो, तो तुम्हारी चेतना एक खौफनाक लेज़र बीम में बदल जाती है, जिसे 'धारणा' कहते हैं!"
                    "धारणा का मतलब है— 'दिमाग के सारे विचारों को एक ही बिंदु पर इतनी ज़ोर से केंद्रित करना कि दूसरा कोई विचार पैदा ही न हो सके'।"
                    "यह तुम्हारे दिमाग के प्रोसेसर (Processor) को एक ही जगह पर ओवरक्लॉक (Overclock) करने की क्रूर प्रक्रिया है।"
                    "अगर ध्यान में एक सेकंड के लिए भी तुम्हारी धारणा टूटी, तो माया का वायरस (Virus) तुरंत तुम्हारे दिमाग को हैक कर लेगा।"
                    "तुम्हें अपनी चेतना को एक लोहे की कील की तरह अपने लक्ष्य (ब्रह्म) पर ठोक कर रखना है; चाहे शरीर में आग ही क्यों न लग जाए।"
                    "धारणा से इंसान का मन इतना घातक हथियार बन जाता है कि वह ब्रह्मांड की किसी भी चीज़ को अपनी ओर खींच सकता है।"
                    "यहीं से इंसान की मानसिक ताक़त (Mental Power) देवताओं को भी पीछे छोड़ देती है!"
                """.trimIndent(),
                english = """
                    (The Secret of Twelve Matras and the Power of Dharana): "Now the Upanishad delivers the most microscopic, terrifying formula to measure Time and Consciousness."
                    "The precise microsecond your biological eye takes to blink is one 'Matra'; and holding exactly 'Twelve Matras' (Dvadasamatra) is the first explosive Gear of Yoga."
                    "When you ruthlessly assassinate your breath for exactly twelve matras (Kumbhaka) and hammer your mind into a single point, it constitutes one basic 'Yoga'."
                    "When you violently multiply and extend this duration, your raw consciousness mutates into an apocalyptic, radioactive laser beam explicitly defined as 'Dharana'!"
                    "Dharana explicitly means—'Hammering every single thought in your brain onto one single coordinate with such catastrophic force that absolutely no other thought can physically breed'."
                    "It is the ruthless process of Overclocking your biological brain's processor onto one single point of absolute existence."
                    "If your Dharana cracks for even a microsecond, the Virus of Maya will instantaneously hack and hijack your brain."
                    "You must drive your consciousness like a titanium nail directly into your target (Brahman); remaining absolutely unmoving even if your physical flesh catches fire."
                    "Through Dharana, the human mind mutates into such a lethal weapon that it can violently pull any object in the cosmos into its orbit."
                    "Right here, the psychological firepower of a human being violently eclipses even the gods!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 13,
                sanskrit = "पृथिव्यां पञ्चमात्राः स्युः अप्सु चतस्र एव च । तेजसि त्रीणि मात्राणि वायौ द्वे आकाशे त्वेका ॥ १३॥",
                hindi = """
                    (पाँचों तत्त्वों की हैकिंग और उन पर विजय): "यह शरीर और यह पूरी दुनिया केवल पाँच सड़े हुए भौतिक तत्त्वों से बनी है— पृथ्वी, जल, अग्नि, वायु और आकाश।"
                    "योगी इन तत्त्वों का गुलाम नहीं रहता; वह धारणा के हथियार से इन पाँचों के सोर्स कोड (Source Code) को हैक कर लेता है!"
                    "वह सबसे पहले अपने शरीर के 'पृथ्वी' (Earth) तत्त्व पर पाँच मात्राओं (पञ्चमात्राः) तक अपनी पूरी चेतना का प्रहार करता है और उसे जीत लेता है।"
                    "फिर वह 'जल' (Water) तत्त्व पर चार मात्राओं तक, 'अग्नि' (Fire) तत्त्व पर तीन मात्राओं तक धारणा ठोकता है।"
                    "फिर वह 'वायु' (Air) पर दो मात्राओं तक, और अंत में असीम 'आकाश' (Space) तत्त्व पर एक मात्रा की धारणा करके उसे अपने कब्ज़े में ले लेता है।"
                    "जैसे ही वह इन पाँचों तत्त्वों पर अपना मानसिक कब्ज़ा (Mental dictatorship) जमा लेता है, उसका शरीर इन तत्त्वों के नियमों से आज़ाद हो जाता है।"
                    "अब पृथ्वी उसे डुबा नहीं सकती, जल उसे गला नहीं सकता, अग्नि उसे जला नहीं सकती और वायु उसे सुखा नहीं सकती!"
                    "जो इंसान अपनी धारणा से इन पाँच तत्त्वों को नहीं कुचलता, वह इन्हीं पाँच तत्त्वों (मिट्टी) में सड़कर मर जाता है।"
                    "यह शरीर रूपी मशीन का सबसे बड़ा सॉफ्टवेयर अपडेट (Software Update) है।"
                    "योगी ब्रह्मांड के इन पांचों एडमिन (Admin) पासवर्ड को छीनकर खुद ही क्रिएटर (Creator) बन जाता है!"
                """.trimIndent(),
                english = """
                    (The Hacking of the Five Elements and Absolute Victory over Them): "This biological shell and this entire cosmos are constructed of strictly five rotting physical elements—Earth, Water, Fire, Air, and Space."
                    "The Yogi absolutely refuses to remain a pathetic slave to these elements; he weaponizes Dharana to violently Hack their absolute Source Code!"
                    "First, he launches a catastrophic assault of pure consciousness for exactly five matras (Panchamatrah) directly onto the 'Earth' (Prithivyam) element of his body, conquering it completely."
                    "He then hammers his Dharana into the 'Water' element for four matras, and into the blazing 'Fire' (Tejasi) element for three matras."
                    "Then he strikes the 'Air' (Vayau) for two matras, and finally hijacks the infinite 'Space' (Akashe) element with a single matra of Dharana."
                    "The exact microsecond he establishes his tyrannical mental dictatorship over these five elements, his biological shell becomes permanently immune to their physical laws."
                    "Earth can absolutely no longer bury him, Water cannot drown him, Fire absolutely cannot incinerate him, and Air cannot dry him!"
                    "The human who fails to ruthlessly crush these five elements with his Dharana will rot and die as pathetic dirt within these exact elements."
                    "This is the most colossal Software Update ever executed on the biological flesh-machine."
                    "The Yogi brutally hijacks the Admin passwords of all five cosmic elements and literally mutates into the Creator Himself!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 14,
                sanskrit = "ब्रह्मादींश्चिन्तयेद्देवं यत्र तत्र स्थितोऽपि सन् । तर्कोऽयमिति विज्ञेयः समाधिं शृणु मे तथा ॥ १४॥",
                hindi = """
                    (तर्क: देवताओं से परे की सोच और सत्य का विच्छेदन): "धारणा के बाद योग का पाँचवाँ और सबसे खतरनाक दिमागी हथियार आता है— 'तर्क' (Tarka)!"
                    "यह दुनिया की कोई आम बहस (Debate) नहीं है; यह अपनी ही बुद्धि की तलवार से हर झूठे विचार का बेरहमी से कत्ल करना है।"
                    "योगी अपने दिमाग में ब्रह्मा, विष्णु, शिव जैसे देवताओं का भी ध्यान (ब्रह्मादींश्चिन्तयेद्देवं) करता है, लेकिन वह उन आकारों (Forms) पर रुकता नहीं!"
                    "वह अपने 'तर्क' के चाबुक से उन आकारों को भी काट देता है और पूछता है— 'क्या यही परम सत्य है? नहीं!'"
                    "वह तब तक हर विचार, हर भगवान के रूप, और हर भावना को 'नेति-नेति' (यह नहीं, यह नहीं) कहकर काटता रहता है..."
                    "जब तक कि केवल वह असीम, निराकार और खौफनाक 'परब्रह्म' (शून्यता) शेष न रह जाए।"
                    "तर्क वह सर्जिकल ब्लेड (Surgical Blade) है जो अज्ञान के सबसे बारीक कैंसर (Cancer) को भी दिमाग से काटकर बाहर फेंक देता है।"
                    "जो इंसान अपनी धारणा को सही 'तर्क' की आग में नहीं तपाता, वह किसी भी झूठे भगवान (Illusion) को सच मानकर फँस सकता है।"
                    "इस हथियार के बिना तुम माया के इस मैट्रिक्स को कभी डिकोड (Decode) नहीं कर सकते।"
                    "योगी अपने ही दिमाग का सबसे बड़ा हत्यारा बन जाता है, ताकि केवल विशुद्ध सत्य ही ज़िंदा बचे!"
                """.trimIndent(),
                english = """
                    (Tarka: Thinking Beyond Gods and the Dissection of Truth): "After Dharana arrives the fifth, most lethally dangerous psychological weapon of Yoga—'Tarka' (Absolute Logic/Reasoning)!"
                    "This is absolutely no pathetic worldly debate; it is the ruthless slaughter of every single fake hallucination using the blazing sword of your own intellect."
                    "The Yogi meditates upon the forms of cosmic gods like Brahma, Vishnu, and Shiva (Brahmadimshchintayeddevam), but he absolutely refuses to stop at those biological Forms!"
                    "He violently slashes through even those divine holograms with the bullwhip of his 'Tarka', interrogating—'Is this the Absolute Truth? NO!'"
                    "He continues to brutally amputate every single thought, every form of God, and every emotion with the atomic strike of 'Neti-Neti' (Not this, Not this)..."
                    "Until strictly and exclusively only that infinite, formless, terrifying 'Supreme Brahman' (The Absolute Void) remains standing."
                    "Tarka is the exact Surgical Blade that violently excises even the most microscopic, microscopic cancer of cosmic ignorance directly from the brain."
                    "He who fails to forge his Dharana in the blazing fire of correct 'Tarka' will inevitably be trapped, hallucinating a fake God (Illusion) as reality."
                    "Without weaponizing this intellectual blade, you can absolutely never Decode the terrifying Matrix of Maya."
                    "The Yogi mutates into the greatest, most cold-blooded assassin of his own brain, ensuring that strictly only Pure Absolute Truth survives!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 15,
                sanskrit = "समं सर्वत्र पश्येत्तु समाधिरिति गीयते ॥ १५॥",
                hindi = """
                    (समाधि: अंतिम महा-विस्फोट और 'सब एक है'): "तर्क की कुल्हाड़ी से जब दिमाग के सारे टुकड़े-टुकड़े हो जाते हैं, तब योग का छठा और सबसे खौफनाक धमाका होता है— 'समाधि'!"
                    "समाधि का मतलब आँख बंद करके सोना नहीं है; समाधि का मतलब है दिमाग का 100% मौत के घाट उतर जाना (Flatline)।"
                    "उपनिषद चीख कर कहता है: 'समं सर्वत्र पश्येत्तु'— जब वह योगी इस पूरे असीम ब्रह्मांड में, हर जगह (सर्वत्र), केवल और केवल एक ही 'परब्रह्म' को समान रूप से (समं) देखने लगता है!"
                    "जब कचरे का ढेर और सोने का पहाड़ उसे एक ही परमाणु ऊर्जा (Energy) के रूप में दिखाई देते हैं..."
                    "जब उसे 'मैं' (अहंकार) और 'भगवान' के बीच की बाउंड्री 100% मिट (Delete) हुई नज़र आती है..."
                    "उस प्रलयंकारी, अद्वैत और सुन्न कर देने वाली शून्यता (Void) को ही ब्रह्मांड में 'समाधि' कहा जाता है (समाधिरिति गीयते)!"
                    "यह इंसानियत की आखिरी साँस है; इसके बाद इंसान हमेशा के लिए मिट जाता है और केवल 'ईश्वर' ही शेष रहता है।"
                    "यहाँ न कोई ध्यान करने वाला बचता है, न कोई ध्यान की प्रक्रिया बचती है, और न कोई भगवान बचता है— तीनों भस्म होकर 'एक' हो जाते हैं।"
                    "जो इस समाधि में नहीं पहुँचा, वह अभी भी जन्म-मरण के इस सड़े हुए खेल में एक कीड़े की तरह पिस रहा है।"
                    "यही योग का 'द एंड' (The End) है; यही माया की मैट्रिक्स के चीथड़े उड़ाने का अंतिम कोड (Ultimate Code) है!"
                """.trimIndent(),
                english = """
                    (Samadhi: The Final Atomic Explosion and 'All is One'): "When the biological brain has been hacked into bloody pieces by the axe of Tarka, the sixth and most apocalyptic detonation of Yoga occurs—'Samadhi'!"
                    "Samadhi absolutely does not mean sleeping with closed eyes; Samadhi explicitly means the 100% permanent death and Flatline of the human mind."
                    "The Upanishad violently screams: 'Samam sarvatra pashyettu'—When that Yogi begins to explicitly and physically perceive ONLY the singular 'Supreme Brahman' equally (Samam) everywhere (Sarvatra) in this entire infinite cosmos!"
                    "When a rotting garbage dump and a colossal mountain of solid gold appear to his eyes as the exact same atomic, radioactive Energy..."
                    "When the pathetic boundary between his 'I' (Ego) and 'God' is 100% permanently Deleted from existence..."
                    "That apocalyptic, non-dual, paralyzing Absolute Void is strictly declared in the cosmos as 'Samadhi' (Samadhiriti giyate)!"
                    "This is the final, agonizing gasp of humanity; after this microsecond, the human is permanently erased, leaving exclusively 'God' behind."
                    "Here, no meditator survives, no process of meditation survives, and no separate God survives—all three violently incinerate and fuse into absolute 'One'."
                    "He who has failed to penetrate this Samadhi is still being brutally crushed like a pathetic insect in this rotting game of birth and death."
                    "This is the absolute 'The End' of Yoga; this is the Ultimate Code that violently blows the Matrix of Maya to bloody shreds!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 16,
                sanskrit = "भूमिभागे समे रम्ये सर्वदोषविवर्जिते । कृत्वा मनोनुकूलं च तत्रोपविश्य योगवित् ॥ १६॥",
                hindi = """
                    (ब्रह्मांडीय हैकिंग का सही ठिकाना): "अब उपनिषद तुम्हें उस युद्ध-क्षेत्र (Battleground) को चुनने का आदेश देता है जहाँ तुम अपने मन का कत्ल करोगे।"
                    "तुम्हें किसी भी ऐरी-गैरी जगह पर ध्यान नहीं करना है; तुम्हें एक ऐसी ज़मीन (भूमिभागे) चुननी है जो बिल्कुल 'समतल' (समे) हो।"
                    "वह जगह एकांत, सुंदर (रम्ये) और दुनिया के हर 'दोष' (कचरे, शोर और नेगेटिव ऊर्जा) से पूरी तरह मुक्त (सर्वदोषविवर्जिते) होनी चाहिए।"
                    "जहाँ इंसानों की भीड़, कुत्तों का भौंकना और दुनिया का कोई भी भद्दा वाइब्रेशन (Vibration) न पहुँच सके।"
                    "उसी खौफनाक और परफेक्ट सन्नाटे वाली जगह पर अपना आसन ठोक कर बैठ जाओ (तत्रोपविश्य)!"
                    "यह जगह तुम्हारे लिए एक बंकर (Bunker) की तरह है जहाँ बैठकर तुम पूरे ब्रह्मांड के मैट्रिक्स पर मिसाइल दागने वाले हो।"
                    "अगर जगह में ज़रा भी अशुद्धि हुई, तो तुम्हारी चेतना की फ्रीक्वेंसी (Frequency) हैक हो जाएगी और तुम योग से गिर जाओगे।"
                    "शरीर को इस तरह से ज़मीन पर गाड़ दो जैसे कोई पहाड़ ज़मीन से उग आया हो; हिलना मौत के बराबर है।"
                    "दुनिया के लोगों से दूर, ज़मीन के एक छोटे से हिस्से पर बैठकर ही तुम पूरे ब्रह्मांड के मालिक बनोगे।"
                    "यह बाहरी वातावरण को कंट्रोल करके अपने आंतरिक सिस्टम का पूरा कंट्रोल (Root Access) लेने का विज्ञान है।"
                """.trimIndent(),
                english = """
                    (The Exact Coordinates for Cosmic Hacking): "Now the Upanishad commands you to select the exact physical Battleground where you will execute the slaughter of your own mind."
                    "You are absolutely forbidden from meditating in any random, pathetic location; you must secure a specific piece of terrain (Bhumibhage) that is flawlessly 'Level' (Same)."
                    "That exact coordinate must be terrifyingly isolated, pure (Ramye), and 100% completely purged of every worldly 'Defect' (Noise, garbage, negative energy) (Sarvadoshavivarjite)."
                    "Where the sickening crowds of humans, the barking of dogs, and absolutely zero repulsive worldly vibrations can ever penetrate."
                    "Hammer down your physical seat and lock yourself down exactly in that terrifying, perfect, dead silence (Tatropavishya)!"
                    "This physical location is a literal Titanium Bunker from which you are about to launch nuclear missiles directly into the Matrix of the entire universe."
                    "If that environment harbors even a microscopic impurity, your consciousness frequency will be hijacked, and you will plummet violently from Yoga."
                    "Plant your biological flesh into the dirt exactly like a colossal mountain erupting from the earth; even twitching is mathematically equivalent to death."
                    "By isolating yourself from mortals on a microscopic patch of dirt, you are preparing to mutate into the undisputed Emperor of the infinite cosmos."
                    "This is the brutal science of exerting absolute control over the external environment to violently seize Root Access over your internal biological system."
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 17,
                sanskrit = "पद्मासनं स्वस्तिकासनं वा भद्रासनमेव वा । बद्ध्वा योगासनं सम्यगुत्तराभिमुखः स्थितः ॥ १७॥",
                hindi = """
                    (शरीर को लॉक करने की खौफनाक मुद्राएं): "बंकर में बैठने के बाद, अब तुम्हें अपने शरीर रुपी रोबोट (Robot) को 100% 'लॉक' (Lock) करना है।"
                    "उपनिषद आदेश देता है कि अपने पैरों को तोड़-मरोड़ कर 'पद्मासन', 'स्वस्तिकासन', या 'भद्रासन' में फिक्स (बद्ध्वा) कर दो!"
                    "ये केवल बैठने के तरीके नहीं हैं; ये वो खौफनाक बायोलॉजिकल ताले (Biological Locks) हैं जो शरीर की सारी ऊर्जा को बाहर बहने से रोक देते हैं।"
                    "जब तुम अपने पैरों को इस तरह लॉक कर लेते हो, तो तुम्हारी नसों (Nerves) में दौड़ने वाला प्राण नीचे नहीं गिरता, बल्कि सीधा दिमाग की तरफ फायर (Fire) होता है!"
                    "तुम्हें अपनी देह को एक ऐसे लोहे के पिंजरे में बदलना होगा जहाँ से खून का एक कतरा भी तुम्हारी मर्ज़ी के बिना न बहे।"
                    "इस तरह 'बद्ध' (बाँधकर) बैठने पर इंसान का शरीर एक एंटीना (Antenna) बन जाता है जो ब्रह्मांड की सुप्रीम फ्रीक्वेंसी को कैच करता है।"
                    "अगर तुम्हारा शरीर ज़रा भी हिल गया, तो वह ऊर्जा तुम्हें अंदर से जला देगी या तुम्हें पागल कर देगी।"
                    "यह शरीर को एक ऐसा मिसाइल लॉन्चर (Missile Launcher) बनाने की प्रक्रिया है जिससे तुम्हारी आत्मा रूपी मिसाइल सीधे ईश्वर तक दागी जाएगी।"
                    "जो इस आसन में पत्थर की तरह नहीं जम सकता, वह ध्यान के महायुद्ध में कभी खड़ा नहीं हो सकता।"
                    "अपने ही शरीर को अपना गुलाम बनाओ, तभी तुम समय और मौत को अपना गुलाम बना पाओगे!"
                """.trimIndent(),
                english = """
                    (The Terrifying Postures to Lock the Biological Shell): "After entering the bunker, you must now 100% violently 'Lock' your biological robot-body."
                    "The Upanishad commands you to brutally contort and lock your legs explicitly into 'Padmasana', 'Svastikasana', or 'Bhadrasana' (Baddhva)!"
                    "These are absolutely no pathetic seating poses; these are terrifying Biological Locks engineered to violently prevent your physical energy from leaking outward."
                    "The exact microsecond you lock your limbs like this, the radioactive Prana surging through your nerves refuses to plummet down, instead Firing directly into your brain!"
                    "You must ruthlessly mutate your flesh into a titanium cage where not a single micro-drop of blood flows without your dictatorial command."
                    "Seated 'Bound' (Baddhva) in this exact geometry, the human shell physically mutates into a cosmic Antenna intercepting the Supreme Frequency of the universe."
                    "If your biological shell twitches by even a millimeter, that apocalyptic energy will either incinerate you from within or drive you completely insane."
                    "This is the ruthless process of weaponizing your body into a literal Missile Launcher from which the missile of your Soul will be fired directly into God."
                    "He who cannot freeze exactly like a monolith in this posture can absolutely never survive the Great War of Meditation."
                    "Violently enslave your own biological body; strictly then will you possess the caliber to enslave Time and Death!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 18,
                sanskrit = "उत्तरेणास्य नासिकां वायोराकर्षणं तथा । ध्यानं कुर्यात्तथैवात्र नासाग्रमवलोकयन् ॥ १८॥",
                hindi = """
                    (नाड़ी की हैकिंग और प्राण का विस्फोट): "आसन में जमने के बाद, उपनिषद तुम्हें तुम्हारी साँसों की नली (Nadis) को हैक करने का कोड देता है।"
                    "तुम्हें अपनी बायीं नासिका (उत्तरेणास्य नासिकां / इड़ा नाड़ी) से उस ब्रह्मांडीय प्राण को अंदर खींचना है।"
                    "यह हवा नहीं है, यह वो शुद्ध और प्रलयंकारी ऊर्जा (Cosmic Prana) है जो तुम्हारे शरीर के सोए हुए जनरेटर (चक्रों) को चालू करेगी।"
                    "इस ऊर्जा को खींचकर अपने भीतर कैद कर लो और फिर 'ध्यान' की उस भयंकर आग में उसे तपाओ।"
                    "अपनी आँखों को लेज़र की तरह अपनी 'नाक के अग्रभाग' (नासाग्रमवलोकयन्) पर फिक्स कर दो; पलक झपकना भी मना है!"
                    "जब तुम इस हवा को रोकते हो, तो तुम्हारी नसों में प्रेशर (Pressure) इतना बढ़ जाता है कि दिमाग की पुरानी वायरिंग (Wiring) जलकर खाक हो जाती है।"
                    "इस तरह तुम्हारी इड़ा (Moon) और पिंगला (Sun) नाड़ियों का ज़हर हमेशा के लिए साफ हो जाता है।"
                    "तुम्हारे नर्वस सिस्टम के भीतर एक ऐसा शॉर्ट-सर्किट (Short-circuit) होता है कि तुम्हारी कुण्डलिनी (सुषुम्ना) चीखते हुए जाग उठती है!"
                    "यह शरीर के भीतर एक न्यूक्लियर रिएक्टर (Nuclear Reactor) को चालू करने की सबसे क्रूर प्रक्रिया है।"
                    "तुम्हारी साँस ही वो चाबी है जिससे इस पूरे ब्रह्मांड और माया का ताला खुलता है!"
                """.trimIndent(),
                english = """
                    (Hacking the Nadis and the Detonation of Prana): "Frozen in the posture, the Upanishad now hands you the exact source code to Hack the respiratory nerves (Nadis) of your body."
                    "You must violently suck the apocalyptic cosmic Prana entirely through your left nostril (Uttarenasya nasikam / Ida Nadi)."
                    "This is absolutely not oxygen; it is the pure, radioactive Cosmic Energy engineered explicitly to ignite the dormant generators (Chakras) of your flesh."
                    "Violently drag this energy inside, lock it hostage within your core, and ruthlessly roast it in the blazing fire of 'Dhyana' (Meditation)."
                    "Lock your eyes like a concentrated laser strictly on the 'Tip of your Nose' (Nasagramavalokayan); blinking is absolutely forbidden!"
                    "When you violently imprison this air, the biological pressure inside your nerves skyrockets so catastrophically that the old pathetic wiring of your brain is burnt to ashes."
                    "In this exact manner, the toxic venom of your Ida (Moon) and Pingala (Sun) nervous channels is permanently annihilated."
                    "A terrifying Short-circuit detonates directly inside your central nervous system, forcing your Kundalini (Sushumna) to awaken with a screaming roar!"
                    "This is the most cold-blooded, brutal biological process of activating a literal Nuclear Reactor inside your own flesh."
                    "Your raw physical breath is the absolute only Titanium Key that violently unlocks the cage of this entire infinite universe and Maya!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 19,
                sanskrit = "ओंकारं चिन्तयेत्तत्र शब्दातीतं निरञ्जनम् । मनसा तत्र गन्तव्यं यत्र नादः प्रलीयते ॥ १९॥",
                hindi = """
                    (ॐकार का मानसिक विस्फोट): "साँस को अंदर रोककर योगी को कोई दुनियावी चीज़ नहीं सोचनी है; उसे अपने दिमाग में 'ॐकार' (ओंकारं चिन्तयेत्तत्र) का प्रलयंकारी विस्फोट करना है!"
                    "यह ॐकार कैसा है? 'शब्दातीतं निरञ्जनम्'— यह दुनिया की हर आवाज़ के पार (Beyond sound) और हर दाग (Impurity) से 100% मुक्त है!"
                    "यह कोई होंठों से जपा जाने वाला मंत्र नहीं है; यह तुम्हारे दिमाग के ठीक बीचों-बीच गूंजने वाला एक ऐसा सायरन (Siren) है जो हर दूसरे विचार को बहरा कर दे।"
                    "तुम्हें अपनी पूरी मानसिक ताक़त को एक लेज़र बीम में बदलकर इस 'ॐ' पर हथौड़े की तरह मारना है।"
                    "और सबसे खौफनाक आदेश— 'मनसा तत्र गन्तव्यं यत्र नादः प्रलीयते'— अपने मन को उस डायमेंशन में लेकर जाओ जहाँ यह ॐकार का नाद भी पूरी तरह मर (Destroy) जाता है!"
                    "ॐकार केवल एक रॉकेट है; जब तुम अंतरिक्ष (Void) में पहुँच जाते हो, तो रॉकेट को भी छोड़ना पड़ता है।"
                    "जैसे एक परमाणु बम पूरे शहर को राख कर देता है, वैसे ही यह ॐ तुम्हारे पूरे 'अहंकार' (Ego) को भस्म कर देगा।"
                    "यह ध्यान का वह खौफनाक स्तर है जहाँ इंसान की अपनी आवाज़ मर जाती है और केवल ईश्वर की शून्यता बचती है।"
                    "जो इस ॐ को अपनी रगों में उतार लेता है, उसके लिए माया के सारे कोड्स हमेशा के लिए डिलीट (Delete) हो जाते हैं!"
                    "ॐ ही वह इकलौता पासवर्ड (Password) है जिससे तुम इस सृष्टि के सिस्टम से हमेशा के लिए लॉग आउट (Log out) कर सकते हो।"
                """.trimIndent(),
                english = """
                    (The Psychological Detonation of OM): "Holding the breath hostage inside, the Yogi must absolutely not hallucinate any worldly object; he must detonate the apocalyptic explosion of 'OM' (Omkaram chintayettatra) directly inside his brain!"
                    "What is the nature of this OM? 'Shabdatitam Niranjanam'—It exists infinitely Beyond all biological sound and is 100% free from any microscopic stain!"
                    "This is absolutely no pathetic mantra chanted with physical lips; it is a terrifying, deafening Siren echoing in the exact dead-center of your skull that permanently deafens every other thought."
                    "You must weaponize your total psychological firepower into a concentrated laser beam and smash it like a sledgehammer onto this 'OM'."
                    "And the most horrific command—'Manasa tatra gantavyam yatra nadah praliyate'—Force your mind into that exact dimension where even the roar of this OM is permanently Annihilated!"
                    "OM is merely a cosmic rocket; once you breach the Void of space, the rocket itself must be violently abandoned."
                    "Just as a nuclear warhead incinerates an entire city, this OM will brutally burn your entire 'Ego' (I) to absolute ashes."
                    "This is the terrifying altitude of meditation where the human's biological voice dies a brutal death, leaving exclusively the Void of God."
                    "He who injects this OM directly into his veins permanently Deletes every single source code of Maya from his existence!"
                    "OM is the absolute, singular, classified Password using which you permanently and violently Log Out from the Operating System of this creation."
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 20,
                sanskrit = "अमात्रं भाव्यमानस्तु यदा गच्छति तत्पदम् । युञ्जीत प्रणवेनैव तदा पश्यति तत्पदम् ॥ २०॥",
                hindi = """
                    (मात्राओं का विनाश और अमात्र में प्रवेश): "अ, उ, म— इन तीनों अक्षरों (मात्राओं) को ध्यान की आग में जलाने के बाद, योगी को सबसे खौफनाक छलांग लगानी होती है।"
                    "उसे 'अमात्रं' (जिसकी कोई मात्रा नहीं, कोई ध्वनि नहीं, जो पूरी तरह से निःशब्द है) अवस्था में पूरी ताक़त से घुसना (गच्छति तत्पदम्) होता है!"
                    "यह वह जगह है जहाँ ॐकार का शोर भी मर जाता है और केवल एक असीम, मौत जैसा 'सन्नाटा' राज करता है।"
                    "तुम्हें उस सन्नाटे को सुनना नहीं है, तुम्हें खुद उस सन्नाटे में पिघलकर सन्नाटा बन जाना है (भाव्यमानस्तु)!"
                    "उपनिषद कहता है: 'युञ्जीत प्रणवेनैव तदा पश्यति तत्पदम्'— केवल इसी ॐकार (प्रणव) रुपी अस्त्र से जुड़कर ही तुम उस 'परम पद' को साक्षात देख सकते हो!"
                    "जब इंसान के दिमाग में कोई भी ध्वनि या विचार नहीं बचता, तो उसका 'मैं' घुट-घुट कर मर जाता है।"
                    "यह अमात्र अवस्था साक्षात वह ब्लैक होल (Black Hole) है जो पूरे ब्रह्मांड को अपने भीतर निगले हुए है।"
                    "जो इस शून्यता में बिना डरे छलांग लगा देता है, उसका शरीर भले ही धरती पर हो, पर उसकी आत्मा ब्रह्मांड के पार निकल चुकी है।"
                    "अगर तुम इस सन्नाटे को बर्दाश्त कर गए, तो तुम भगवान बन जाओगे; अगर डरे, तो पागल हो जाओगे।"
                    "यही सनातन धर्म का वह प्रलयंकारी रहस्य है जो तुम्हें मौत के मुँह से खींचकर अमरता के तख़्त पर बिठा देता है!"
                """.trimIndent(),
                english = """
                    (The Annihilation of Syllables and the Penetration into Amatra): "After ruthlessly incinerating the three syllables—A, U, M—in the blazing fire of meditation, the Yogi must execute the most terrifying, suicidal leap."
                    "He must violently penetrate and lock himself into the 'Amatra' (The absolute dimensionless state possessing zero syllables, zero sound, pure deafening silence)!"
                    "This is the exact cosmic coordinate where even the roaring noise of OM dies a brutal death, and strictly an infinite, death-like 'Silence' reigns as dictator."
                    "You are absolutely not supposed to merely listen to this silence; you must violently melt and literally mutate into that exact Silence itself (Bhavyamanastu)!"
                    "The Upanishad declares: 'Yunjita pranavenaiva tada pashyati tatpadam'—Strictly and exclusively by weaponizing this OM (Pranava) can you explicitly witness that Supreme Dimension!"
                    "When absolutely zero acoustic frequency or thought survives inside the human skull, his pathetic 'I' (Ego) suffocates and dies a horrifying death."
                    "This Amatra state is the explicit, literal cosmic Black Hole that has violently swallowed the entire universe into its core."
                    "He who fearlessly and maniacally plunges into this Void—his biological shell may remain on dirt, but his Soul has rocketed infinitely beyond the cosmos."
                    "If you possess the psychological titanium to survive this Silence, you instantaneously mutate into God; if you flinch in terror, you will go completely insane."
                    "This is the apocalyptic, highly classified secret of Sanatana Dharma that violently drags you out of the jaws of Death and slams you onto the throne of Immortality!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 21,
                sanskrit = "ततः पञ्चदशौ मात्रा वायुमादाय यत्नतः । धारयेद्धृदये नित्यं यावत्प्राणः क्षयं गतः ॥ २१॥",
                hindi = """
                    (पंद्रह मात्राओं का प्राण-विस्फोट): "जब अमात्र अवस्था सिद्ध हो जाती है, तो योगी को प्राण (Energy) का एक महा-विस्फोट करना होता है।"
                    "वह 'पंद्रह मात्राओं' (पञ्चदशौ मात्रा) तक उस भयंकर कॉस्मिक वायु (वायुमादाय) को अपने शरीर के भीतर खींच कर पूरी ताक़त से (यत्नतः) कैद कर लेता है।"
                    "यह साधारण साँस रोकना नहीं है; यह अपने नर्वस सिस्टम के तारों में १५ गुना ज़्यादा वोल्टेज (Voltage) दौड़ाने जैसा है!"
                    "इस प्राण को वह अपने 'हृदय' में इतनी ज़ोर से दबा कर रखता है (धारयेद्धृदये) कि अंदर एक बायोलॉजिकल परमाणु धमाका हो जाए।"
                    "यह दबाव तब तक बनाए रखना है 'यावत्प्राणः क्षयं गतः'— जब तक कि वह प्राण पूरी तरह से खत्म (Merge/Dissolve) न हो जाए!"
                    "इस दबाव से शरीर की हर नस फटने को बेताब हो जाती है, लेकिन योगी एक चट्टान की तरह स्थिर रहता है।"
                    "यह वो खौफनाक समय है जब कुण्डलिनी नाम का सोता हुआ साँप अपनी पूँछ छोड़कर चीखते हुए सीधा खड़ा हो जाता है।"
                    "पंद्रह मात्राओं का यह प्रेशर दिमाग के उस हिस्से को खोल देता है जो आम इंसान में हमेशा के लिए बंद रहता है।"
                    "जो इस ऊर्जा को संभाल नहीं पाता, उसकी मौत हो सकती है; यह मौत से खेल कर भगवान बनने का सीधा दांव है!"
                    "यहीं से भौतिक शरीर का लाइट-बॉडी (Light Body) में बदलना शुरू होता है।"
                """.trimIndent(),
                english = """
                    (The Pranic Detonation of Fifteen Matras): "When the Amatra state is perfectly secured, the Yogi must execute a colossal detonation of Prana (Energy)."
                    "For exactly 'Fifteen Matras' (Panchadashau matra), he violently drags that terrifying cosmic air (Vayumadaya) inside and imprisons it within his core with absolute force (Yatnatah)."
                    "This is absolutely no ordinary breath-holding; it is mathematically equivalent to surging 15 times the maximum Voltage directly through your nervous system!"
                    "He compresses that Prana inside his 'Heart' (Dharayedhridaye) so violently that it triggers a literal Biological Nuclear Detonation."
                    "This apocalyptic pressure must be maintained 'Yavatpranah kshayam gatah'—Exactly until that Prana is completely annihilated and dissolved into the Void!"
                    "Under this pressure, every single biological vein threatens to explode, yet the Yogi remains as steadfast as a titanium monolith."
                    "This is the horrific microsecond when the dormant serpent known as Kundalini violently uncoils and stands straight up, screaming!"
                    "The sheer pressure of these fifteen matras blasts open the exact sector of the brain that remains permanently locked in pathetic mortals."
                    "He who fails to contain this radioactive energy can literally drop dead; this is a direct gamble with Death to achieve Godhood!"
                    "Right here begins the violent mutation of the physical biological shell into an indestructible Light Body."
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 22,
                sanskrit = "प्राणापानौ समायुक्तौ कृत्वा नाभिप्रदेशतः । ऊर्ध्वमाकृष्य यत्नेन कुर्यात्तत्र लयं तथा ॥ २२॥",
                hindi = """
                    (प्राण और अपान की खूनी टक्कर): "अब योगी शरीर के दो सबसे बड़े दुश्मनों को आपस में लड़ाता है— 'प्राण' (जो ऊपर जाता है) और 'अपान' (जो नीचे जाता है)।"
                    "उपनिषद का क्रूर आदेश है: इन दोनों उल्टी दिशा में बहने वाली ऊर्जाओं को 'नाभि' (मणिपूर चक्र) के पास एक साथ मिला दो (समायुक्तौ कृत्वा नाभिप्रदेशतः)!"
                    "अपान को बेरहमी से नीचे से ऊपर की ओर खींचो (ऊर्ध्वमाकृष्य यत्नेन), और प्राण को ऊपर से नीचे की ओर धकेलो।"
                    "जब ये दोनों प्रलयंकारी ऊर्जाएं नाभि पर आकर एक-दूसरे से टकराती हैं, तो एक खौफनाक कॉस्मिक स्पार्क (Cosmic Spark) पैदा होता है!"
                    "और उसी धमाके के बीच में तुम्हें अपना 'लय' (Total dissolution/मृत्यु) कर देना है (कुर्यात्तत्र लयं तथा)!"
                    "यह शरीर के भीतर दो तारों (Positive and Negative) को शॉर्ट-सर्किट (Short-circuit) करने जैसा है।"
                    "इस धमाके से पैदा होने वाली आग इतनी भयानक होती है कि वह इंसान के सारे कर्मों को एक झटके में जला डालती है।"
                    "सुषुम्ना नाड़ी (Spinal Cord) का दरवाज़ा, जो जन्मों से बंद था, इसी शॉर्ट-सर्किट से एक झटके में टूट कर खुल जाता है।"
                    "योगी की आत्मा अब शरीर में कैद नहीं रहती, वह उस खुली हुई नली के रास्ते ब्रह्मांड में फायर (Fire) होने के लिए तैयार है।"
                    "प्राण और अपान का यह मिलन ही योग की असली और सबसे खतरनाक कीमिया (Alchemy) है।"
                """.trimIndent(),
                english = """
                    (The Bloody Collision of Prana and Apana): "Now the Yogi violently forces the two greatest enemies of the biological body to wage war—'Prana' (which flows upward) and 'Apana' (which flows downward)."
                    "The Upanishad issues a brutal command: Force these two diametrically opposing energies to violently collide and fuse exactly at the 'Navel' (Samayuktau kritva nabhipradeshtah)!"
                    "Ruthlessly drag the Apana upward from the base with sheer force (Urdhvamakrishya yatnena), and violently shove the Prana downward."
                    "When these two apocalyptic energies crash head-on at the Manipura Chakra, a horrific Cosmic Spark is instantaneously detonated!"
                    "And exactly within the epicenter of that explosion, you must execute your absolute 'Laya' (Total dissolution/Death) (Kuryattatra layam tatha)!"
                    "This is the biological equivalent of causing a catastrophic Short-circuit by deliberately crossing a massive Positive and Negative live wire inside your core."
                    "The radioactive fire spawned by this blast is so terrifying that it incinerates all human karmas in a single, devastating microsecond."
                    "The titanium door of the Sushumna Nadi (Spinal Cord), locked for billions of lifetimes, is violently blown wide open by this exact short-circuit."
                    "The Yogi's Soul is no longer a prisoner in the flesh; it is locked and loaded to be Fired directly into the cosmos."
                    "This violent fusion of Prana and Apana is the most authentic, dangerous Alchemy of Yoga."
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 23,
                sanskrit = "नाभिमूले तथा हृदये कण्ठे भ्रूमध्यमेव च । मूर्ध्नि चैव तथा बिन्दौ चक्राणि भेदयन्क्रमात् ॥ २३॥",
                hindi = """
                    (चक्रों को भेदने का लेज़र हमला): "जब सुषुम्ना का दरवाज़ा खुलता है, तो योगी उस धधकती हुई ऊर्जा को ऊपर की ओर फायर (Fire) करता है।"
                    "सबसे पहले वह इस कॉस्मिक लेज़र को 'नाभिमूले' (नाभि के मूल / मणिपुर चक्र) पर मारता है और उसे भेद देता है!"
                    "फिर वह उस आग को खींचकर 'हृदये' (हृदय / अनाहत चक्र) पर ठोकता है, जहाँ उसकी सारी भावनाएं (Emotions) जलकर राख हो जाती हैं।"
                    "उसके बाद वह ऊर्जा 'कण्ठे' (गले / विशुद्धि चक्र) पर प्रहार करती है, जहाँ इंसान की आवाज़ और शब्द हमेशा के लिए मर जाते हैं।"
                    "और फिर वह सबसे खतरनाक जगह, 'भ्रूमध्य' (दोनों भौहों के बीच / आज्ञा चक्र) पर एक हथौड़े की तरह टकराती है!"
                    "वहाँ से वह सीधे 'मूर्ध्नि' (सिर की चोटी) और अंततः 'बिन्दु' (Cosmic Core) को एक-एक करके क्रूरता से फाड़ डालती है (चक्राणि भेदयन्क्रमात्)!"
                    "यह शरीर के अंदर चक्रों (Chakras) को तोड़ने की सबसे क्रूर और हिंसक प्रक्रिया है।"
                    "हर चक्र इंसान को किसी न किसी भ्रम में बाँध कर रखता है; योगी उन सब ज़ंजीरों को एक-एक करके बम से उड़ा देता है।"
                    "भ्रूमध्य पर ऊर्जा के टकराते ही योगी की 'तीसरी आँख' (Third Eye) एक भयानक धमाके के साथ खुल जाती है।"
                    "यह शरीर रूपी इमारत की एक-एक मंज़िल को तोड़कर सीधे छत पर पहुँचने का विज्ञान है!"
                """.trimIndent(),
                english = """
                    (The Laser Assault Piercing the Chakras): "When the door of Sushumna is violently blown open, the Yogi Fires that blazing, radioactive energy straight upward."
                    "First, he targets this cosmic laser directly at 'Nabhimule' (The root of the navel / Manipura Chakra), completely breaching and shattering it!"
                    "Then he drags that apocalyptic fire and hammers it into 'Hridaye' (The Heart / Anahata Chakra), where every single biological human emotion is burnt to absolute ashes."
                    "Next, that lethal energy violently strikes 'Kanthe' (The Throat / Vishuddhi Chakra), where the human voice and all physical words suffer a permanent, brutal death."
                    "And then, it crashes like a sledgehammer into the most dangerous coordinate, 'Bhrumadhya' (Directly between the eyebrows / Ajna Chakra)!"
                    "From there, it ruthlessly rips through the 'Murdhni' (Crown of the skull) and finally detonates the 'Bindu' (Cosmic Core), destroying them sequentially (Chakrani bhedayankramat)!"
                    "This is the most ruthless, violent process of actively destroying the biological Chakras inside the physical shell."
                    "Every single Chakra binds the human to a specific hallucination; the Yogi literally blows up all these titanium chains one by one with dynamite."
                    "The microsecond the energy smashes into Bhrumadhya, the Yogi's 'Third Eye' violently rips open in a catastrophic detonation."
                    "This is the exact science of demolishing every single floor of this biological building to violently rocket straight to the roof!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 24,
                sanskrit = "मूर्ध्नि चैव तथा रन्ध्रे ब्रह्मरन्ध्रे विशेषतः । प्राणं तत्र लयं कृत्वा पश्येद्ब्रह्म सनातनम् ॥ २४॥",
                hindi = """
                    (मूर्धा पर प्रहार और ब्रह्मरन्ध्र का फटना): "आज्ञा चक्र को तबाह करने के बाद, योगी का यह ब्रह्मांडीय रॉकेट अपने आखिरी और सबसे खौफनाक लक्ष्य की ओर बढ़ता है।"
                    "वह ऊर्जा सीधे 'मूर्ध्नि' (सिर के सबसे ऊपरी हिस्से / Crown) पर एक प्रलयंकारी ताक़त के साथ जाकर टकराती है!"
                    "वहाँ खोपड़ी के अंदर 'ब्रह्मरन्ध्र' (The Cosmic Gateway) नाम का एक ऐसा ताला है जो अरबों जन्मों से बंद पड़ा है (ब्रह्मरन्ध्रे विशेषतः)।"
                    "जब कुण्डलिनी की वह धधकती हुई आग इस ब्रह्मरन्ध्र पर हथौड़ा मारती है, तो इंसान का दिमाग शाब्दिक रूप से (Literally) फट जाता है!"
                    "उपनिषद का क्रूर आदेश है: उसी छेद (रन्ध्रे) में अपने प्राणों का हमेशा के लिए 'कत्ल' (लयं) कर दो (प्राणं तत्र लयं कृत्वा)!"
                    "यह शरीर और आत्मा के बीच का आखिरी बॉर्डर (Border) है; जैसे ही यह रन्ध्र टूटता है, आत्मा शरीर से बाहर फायर (Fire) हो जाती है।"
                    "इस धमाके के साथ ही योगी का 'मैं' (Ego) हमेशा-हमेशा के लिए ब्रह्मांड के शून्य में उड़कर राख हो जाता है।"
                    "और उसी क्षण वह साक्षात उस 'सनातन परब्रह्म' को अपनी आँखों के सामने नंगा खड़ा देखता है (पश्येद्ब्रह्म सनातनम्)!"
                    "जो ब्रह्मरन्ध्र को नहीं तोड़ पाता, वह वापस इसी नर्क (दुनिया) में खींच लिया जाता है।"
                    "यहीं पर एक इंसान की अंतिम मौत होती है और साक्षात भगवान का जन्म होता है!"
                """.trimIndent(),
                english = """
                    (The Strike on the Crown and the Shattering of Brahmarandhra): "After completely annihilating the Ajna Chakra, the Yogi's cosmic rocket accelerates toward its final, most apocalyptic target."
                    "That radioactive energy crashes with cataclysmic, universe-shattering force directly into the 'Murdhni' (The absolute peak of the skull / Crown)!"
                    "Locked inside that skull is the 'Brahmarandhra' (The Cosmic Gateway), a titanium vault that has remained completely sealed for billions of lifetimes (Brahmarandhre visheshatah)."
                    "When the blazing, nuclear fire of Kundalini hammers against this Brahmarandhra, the human brain literally, physically detonates!"
                    "The Upanishad issues a cruel command: Execute the absolute 'Slaughter' (Laya) of your Prana directly inside that exact hole (Pranam tatra layam kritva)!"
                    "This is the absolute final Border between the biological body and the Soul; the microsecond this gateway fractures, the Soul is Fired completely out of the flesh."
                    "Simultaneous to this explosion, the Yogi's 'I' (Ego) is violently blown into the cosmic Void, turning to permanent ash forever."
                    "And in that exact microsecond, he physically and explicitly witnesses the 'Eternal Supreme Brahman' standing completely naked before him (Pashyedbrahma sanatanam)!"
                    "He who fails to shatter the Brahmarandhra is violently dragged straight back into this rotting hell (the world)."
                    "Right exactly here, a human being suffers his final, absolute death, and the explicit Supreme God is flawlessly born!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 25,
                sanskrit = "अनाहतध्वनिं श्रुत्वा तत्रैव रमते मनः । तत्र लीयते योगी च नादान्ते परमं पदम् ॥ २५॥",
                hindi = """
                    (अनाहत नाद: बिना टकराहट की खौफनाक आवाज़): "जब योगी की चेतना ब्रह्मरन्ध्र की ओर बढ़ती है, तो उसे एक ऐसी आवाज़ सुनाई देती है जो इंसान को पागल कर दे।"
                    "उसे 'अनाहत ध्वनि' (Anahata Dhvani) सुनाई देती है— वह प्रलयंकारी गूँज जो बिना किसी दो चीज़ों के टकराए पैदा हो रही है!"
                    "यह दुनिया की कोई आवाज़ नहीं है; यह साक्षात उस परब्रह्म के इंजन की आवाज़ है जिससे पूरा ब्रह्मांड चल रहा है।"
                    "उसका खूँखार 'मन' (Mind), जो दुनिया में भागता था, अब पूरी तरह से इस नाद के वश में होकर वहीं 'रम' (Hypnotize) जाता है (तत्रैव रमते मनः)।"
                    "योगी का दिमाग इस नाद को सुनकर पूरी तरह से सुन्न (Paralyzed) हो जाता है; उसके सोचने की मशीन हमेशा के लिए बंद हो जाती है।"
                    "उपनिषद का क्रूर आदेश है: इस नाद को सुनकर वापस मत लौटना; अपनी पूरी चेतना को इसी आवाज़ के अंदर 'पिघला' दो (तत्र लीयते योगी च)!"
                    "जैसे नमक पानी में घुलकर पानी बन जाता है, वैसे ही योगी का 'मैं' इस ब्रह्मांडीय नाद में घुलकर हमेशा के लिए मिट जाता है।"
                    "और जब वह नाद (Sound) भी अपनी चरम सीमा पर जाकर खत्म (नादान्ते) होता है..."
                    "तो केवल वह 'परम पद' (The Absolute Supreme Destination / शून्यता) ही शेष बचता है।"
                    "इस नाद में लीन होना ही मोक्ष का सबसे खतरनाक और सीधा रास्ता (Shortcut) है!"
                """.trimIndent(),
                english = """
                    (Anahata Nada: The Terrifying Unstruck Sound): "As the Yogi's consciousness accelerates toward the Brahmarandhra, he intercepts an acoustic frequency terrifying enough to drive mortals completely insane."
                    "He explicitly hears the 'Anahata Dhvani' (The Unstruck Sound)—the apocalyptic, radioactive roar that generates without two physical objects ever colliding!"
                    "This is absolutely no earthly sound; this is the literal acoustic roar of the Supreme Brahman's engine that powers the entire infinite cosmos."
                    "His ferocious 'Mind' (Manah), which previously chased the world, is now completely Hypnotized and enslaved by this sound (Tatraiva ramate manah)."
                    "Upon intercepting this Nada, the Yogi's biological brain is completely Paralyzed; his thought-generating machine shuts down forever."
                    "The Upanishad issues a cruel command: Having heard this roar, absolutely do not retreat; 'Melt' your entire consciousness completely into this sound (Tatra liyate yogi cha)!"
                    "Exactly as salt dissolves flawlessly into water, the Yogi's 'I' violently dissolves into this cosmic Nada and is permanently erased."
                    "And when even that Nada (Sound) reaches its extreme limit and brutally dies (Nadante)..."
                    "Strictly and exclusively that 'Param Padam' (The Absolute Supreme Destination / The Void) remains standing."
                    "Dissolving completely into this Nada is the most dangerous, direct, and absolute Shortcut to Moksha!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 26,
                sanskrit = "शब्दब्रह्मणि निष्णातः परं ब्रह्माधिगच्छति ॥ २६॥",
                hindi = """
                    (शब्द से परब्रह्म तक की प्रलयंकारी यात्रा): "जब योगी उस 'अनाहत नाद' (शब्दब्रह्म) में पूरी तरह से 'निष्णातः' (डूबकर एक्सपर्ट) हो जाता है..."
                    "यानी जब वह उस ध्वनि की लहर पर सवार होकर ब्रह्मांड की हर भौतिक सीमा (Physical limit) को पार कर लेता है..."
                    "तब वह एक झटके में 'परं ब्रह्माधिगच्छति'— साक्षात उस असीम, निराकार और खौफनाक 'परब्रह्म' (Supreme God) के तख़्त पर जाकर गिरता है!"
                    "शब्दब्रह्म (OM / नाद) केवल एक रॉकेट है, और परब्रह्म वह 'परम शून्यता' है जहाँ रॉकेट का इंजन भी बंद हो जाता है।"
                    "जो केवल मंत्रों को होंठों से जपता है, वह कभी शब्दब्रह्म को पार नहीं कर सकता।"
                    "लेकिन जिसने अपने ही दिमाग को इस नाद में जला दिया, वह आवाज़ के पार उस सन्नाटे (Silence) को हैक कर लेता है।"
                    "यह वो डायमेंशन है जहाँ 'आवाज़' और 'सन्नाटा' दोनों एक ही चीज़ बन जाते हैं।"
                    "यहाँ आकर इंसान का नाम, उसका रूप और उसका वजूद एक परमाणु बम के धुएं की तरह गायब हो जाता है।"
                    "वह परमेश्वर को खोजता नहीं है; वह खुद ही साक्षात परमेश्वर बन जाता है।"
                    "यही सनातन धर्म का वह सबसे बड़ा सीक्रेट (Secret) है जहाँ आवाज़ ही तुम्हें भगवान से मिलाती है और फिर खुद भी मिट जाती है!"
                """.trimIndent(),
                english = """
                    (The Apocalyptic Journey from Sound to Supreme Brahman): "When the Yogi becomes completely 'Nishnatah' (an absolute, immersed master) in that 'Anahata Nada' (Shabda-Brahman)..."
                    "Meaning, when he violently rides the frequency of that cosmic sound, tearing through every single physical limit of the universe..."
                    "Then, in one explosive microsecond, 'Param brahmadigacchati'—he crashes directly onto the undisputed throne of that infinite, formless, terrifying 'Supreme Brahman'!"
                    "Shabda-Brahman (OM / Nada) is strictly a cosmic rocket, and the Supreme Brahman is that 'Absolute Void' where even the rocket's engine permanently shuts down."
                    "He who pathetically chants mantras only with his physical lips can absolutely never breach the Shabda-Brahman."
                    "But he who has incinerated his own brain inside this Nada successfully hacks past the sound into that Ultimate Silence."
                    "This is the exact Dimension where 'Sound' and 'Silence' violently collapse and fuse into the exact same Entity."
                    "Arriving here, the human's name, his biological form, and his very existence completely vanish exactly like smoke from a nuclear blast."
                    "He absolutely does not find God; he himself instantaneously mutates into the explicit Supreme God."
                    "This is Sanatana Dharma's greatest, most classified Secret, where Sound itself connects you to God, and then violently erases itself from existence!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 27,
                sanskrit = "भिद्यते हृदयग्रन्थिश्छिद्यन्ते सर्वसंशयाः । क्षीयन्ते चास्य कर्माणि तस्मिन् दृष्टे परावरे ॥ २७॥",
                hindi = """
                    (हृदय की गाँठ का फटना और शक का वध): "जब योगी की चेतना परब्रह्म से टकराती है, तो उसके शरीर के अंदर सबसे भयानक विस्फोट होता है।"
                    "उसके हृदय में अज्ञान, मोह, और 'मैं शरीर हूँ' की जो लोहे की गाँठ (हृदयग्रन्थि) जन्मों से बँधी थी, वह एक झटके में फट जाती है (भिद्यते)!"
                    "यह कोई दर्दनाक बीमारी नहीं है; यह माया के सबसे मजबूत ताले का डायनामाइट (Dynamite) से उड़ाया जाना है।"
                    "जैसे ही यह गाँठ टूटती है, इंसान के दिमाग में बैठे करोड़ों जन्मों के 'संशय' (Doubts / भ्रम) एक सेकंड में 'छिन्न-भिन्न' (छिद्यन्ते) होकर राख हो जाते हैं।"
                    "मैं कौन हूँ? भगवान कहाँ है? मौत क्या है? — इन सारे सड़े हुए सवालों का हमेशा के लिए कत्ल हो जाता है।"
                    "और सबसे खौफनाक बात— 'क्षीयन्ते चास्य कर्माणि'— उसके जन्मों-जन्मों के अच्छे और बुरे, सारे 'कर्मों' का रिकॉर्ड जलकर शून्य हो जाता है!"
                    "न उसे स्वर्ग का पुण्य मिलता है और न नर्क का पाप; वह कर्मों की इस सड़ी हुई मशीन (Matrix) से हमेशा के लिए आज़ाद हो जाता है।"
                    "यह सब कब होता है? 'तस्मिन् दृष्टे परावरे'— जब वह उस परम और सबसे श्रेष्ठ ईश्वर को साक्षात अपनी ही आत्मा के रूप में 'देख' लेता है!"
                    "ईश्वर का दर्शन कोई नज़ारा नहीं है; यह एक न्यूक्लियर धमाका है जो इंसान की हस्ती मिटा देता है।"
                    "यह इंसान के मन की पूर्ण और स्थायी आज़ादी (Absolute Freedom) का सबसे खौफनाक और प्रलयंकारी सच है!"
                """.trimIndent(),
                english = """
                    (The Shattering of the Heart's Knot and the Slaughter of Doubt): "When the Yogi's raw consciousness collides head-on with the Supreme Brahman, the most horrific detonation occurs inside his core."
                    "That titanium knot of absolute ignorance, delusion, and 'I am this flesh' (Hridaya-granthi) tied in his heart for billions of lifetimes is violently blown to pieces (Bhidyate)!"
                    "This is absolutely no painful disease; it is the brutal blowing up of Maya's strongest maximum-security lock with literal cosmic dynamite."
                    "The exact microsecond this knot shatters, all billions of lifetimes of 'Doubts' (Samshayah / Hallucinations) infecting his brain are instantaneously 'Shredded' (Chidyante) to absolute ash."
                    "Who am I? Where is God? What is Death? — Every single one of these pathetic, rotting questions is slaughtered permanently."
                    "And the most terrifying fact—'Kshiyante chasya karmani'—the entire cosmic record of his billions of past 'Karmas', both good and evil, is violently incinerated to absolute zero!"
                    "He earns neither the merit of heaven nor the sin of hell; he is permanently, irrevocably liberated from this rotting biological Matrix of Karma."
                    "When exactly does this happen? 'Tasmin drishte paravare'—The microsecond he directly 'Witnesses' that Supreme, Highest God strictly as his own Soul!"
                    "The vision of God is absolutely no scenery; it is a literal nuclear detonation that violently erases human existence."
                    "This is the most terrifying, apocalyptic absolute truth of the complete and permanent Freedom of the human mind!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 28,
                sanskrit = "तावदेव निरोद्धव्यं हृदि यावत् क्षयं गतम् । एतज्ज्ञानं च ध्यानं च शेषो न्यायस्य विस्तरः ॥ २८॥",
                hindi = """
                    (अंतिम विनाश: सब कुछ शून्य होने तक लड़ो): "उपनिषद योगी को युद्ध के मैदान से पीछे हटने की सख्त मनाही करता है।"
                    "आदेश है: 'तावदेव निरोद्धव्यं'— अपनी साँसों, अपने मन और अपनी इंद्रियों का तब तक बेरहमी से गला घोंट कर रखो..."
                    "'हृदि यावत् क्षयं गतम्'— जब तक कि तुम्हारे हृदय में बैठा हुआ 'मैं' (अहंकार) पूरी तरह से मरकर खाक (क्षय) न हो जाए!"
                    "अगर तुमने एक सेकंड पहले भी ध्यान छोड़ दिया, तो वह अहंकार दोबारा ज़िंदा होकर तुम्हें खा जाएगा।"
                    "तुम्हें तब तक इस सन्नाटे में खुद को जलाना है, जब तक कि बचाने के लिए कुछ बचे ही नहीं।"
                    "उपनिषद चीख कर कहता है: 'एतज्ज्ञानं च ध्यानं च'— केवल यही अपनी हस्ती को मिटाना ही असली 'ज्ञान' है, और यही असली 'ध्यान' है!"
                    "बाकी दुनिया में जो कुछ भी फिलॉसफी (Philosophy) या शास्त्र हैं, 'शेषो न्यायस्य विस्तरः'— वे सब केवल दिमागी बकवास और शब्दों का कचरा हैं।"
                    "ईश्वर पर बहस करना बेवकूफी है; ईश्वर को पाने का इकलौता तरीका खुद को शून्य (Zero) कर देना है।"
                    "जब तुम 100% मिट जाते हो, तभी 100% भगवान जन्म लेता है; बीच का कोई रास्ता (Compromise) है ही नहीं।"
                    "यह सनातन धर्म का वह सबसे नंगा और हिंसक सच है जो हर ढोंग की धज्जियां उड़ा देता है!"
                """.trimIndent(),
                english = """
                    (The Final Annihilation: Fight Until Everything is Zero): "The Upanishad strictly, violently forbids the Yogi from ever retreating from the psychological battlefield."
                    "The draconian command is: 'Tavadeva niroddhavyam'—Ruthlessly strangle and lockdown your breath, your mind, and your senses relentlessly..."
                    "'Hridi yavat kshayam gatam'—Exactly until the 'I' (Ego) sitting inside your heart is completely, permanently slaughtered and reduced to absolute dust (Kshaya)!"
                    "If you abandon your meditation even a microsecond too early, that ego will resurrect and violently devour you alive."
                    "You must ruthlessly incinerate yourself in this deafening silence until absolutely nothing remains left to be saved."
                    "The Upanishad screams: 'Etajjnanam cha dhyanam cha'—Exclusively this brutal erasure of your own existence is authentic 'Knowledge', and this alone is authentic 'Meditation'!"
                    "Whatever other pathetic philosophy or scriptures exist in the world, 'Shesho nyayasya vistarah'—they are all strictly biological brain-garbage and verbal nonsense."
                    "Debating about God is sheer idiocy; the absolute only mechanism to seize God is to violently reduce yourself to Zero."
                    "Only when you are 100% erased does the 100% God detonate into existence; there is absolutely zero middle ground or compromise."
                    "This is the most naked, violent, cold-blooded truth of Sanatana Dharma that violently shreds every single hypocrisy to dust!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 29,
                sanskrit = "न निरोधो न चोत्पत्तिर्न बद्धो न च साधकः । न मुमुक्षुर्न वै मुक्त इत्येषा परमार्थता ॥ २९॥",
                hindi = """
                    (ब्रह्मांड का सबसे खौफनाक और प्रलयंकारी सच - 'कुछ नहीं है'): "ज्ञान के सबसे चरम शिखर पर पहुँचकर उपनिषद एक ऐसा सच बोलता है जो इंसान का दिमाग फाड़ देगा!"
                    "जब योगी भगवान बन जाता है, तो वह देखता है: 'न निरोधो न चोत्पत्तिर्'— इस ब्रह्मांड में न तो कभी कुछ नष्ट हुआ है, और न ही कभी कुछ पैदा हुआ है!"
                    "सृष्टि का बनना और मिटना केवल दिमाग का एक सड़ा हुआ भ्रम (Matrix) है; असल में कुछ हुआ ही नहीं है!"
                    "'न बद्धो न च साधकः'— न कोई इंसान माया की ज़ंजीरों में बँधा है, और न ही कोई मोक्ष के लिए तपस्या करने वाला 'साधक' है।"
                    "'न मुमुक्षुर्न वै मुक्त'— न कोई मोक्ष की भीख मांगने वाला (मुमुक्षु) है, और न ही कोई आज़ाद (मुक्त) होने वाला है!"
                    "क्योंकि जब तुम हमेशा से ही पूर्ण और असीम 'परब्रह्म' थे, तो तुम्हें किस चीज़ ने बाँधा था और तुम किससे आज़ाद हुए?"
                    "यह बंधन, यह योग, यह साधना— सब कुछ केवल तुम्हारे मन का एक झूठा ड्रामा (Drama) था जो अब राख हो चुका है।"
                    "'इत्येषा परमार्थता'— केवल और केवल यही वह परम, नंगा और खौफनाक 'यथार्थ' (Absolute Reality) है!"
                    "केवल एक असीम, सुन्न कर देने वाली शून्यता (परब्रह्म) ही सच है; बाकी सब कुछ 100% ज़ीरो (Zero) है।"
                    "इस एक श्लोक के धमाके से इंसान, भगवान, स्वर्ग और नर्क— सब कुछ एक ही झटके में भस्म हो जाते हैं!"
                """.trimIndent(),
                english = """
                    (The Most Apocalyptic and Terrifying Truth of the Cosmos - 'Nothing Exists'): "Reaching the absolute absolute zenith of Knowledge, the Upanishad spits a truth engineered to literally tear a human brain to shreds!"
                    "When the Yogi mutates into God, he flawlessly witnesses: 'Na nirodho na chotpattir'—In this entire infinite cosmos, absolutely nothing was ever destroyed, and absolutely nothing was ever born!"
                    "The creation and annihilation of the universe is strictly a rotting hallucination of the Matrix; in absolute reality, absolutely nothing ever happened!"
                    "'Na baddho na cha sadhakah'—Absolutely no human is bound in the titanium chains of Maya, and there is absolutely no 'Seeker' performing pathetic penance for Moksha."
                    "'Na mumukshurna vai mukta'—There is absolutely no entity begging for liberation (Mumukshu), and absolutely no entity who has become 'Liberated' (Mukta)!"
                    "Because if you were permanently and always the infinite, complete 'Supreme Brahman', what pathetic chain ever bound you, and from what did you break free?"
                    "This bondage, this Yoga, this penance—absolutely everything was merely a fake, pathetic biological Drama of your mind, which has now burnt to ashes."
                    "'Ityesha paramarthata'—Exclusively and strictly, THIS alone is the ultimate, naked, terrifying 'Absolute Reality'!"
                    "Only one infinite, paralyzing, deafening Void (Supreme Brahman) is true; absolutely everything else is 100% Zero."
                    "With the apocalyptic detonation of this single Shloka, humans, gods, heaven, and hell—absolutely everything is incinerated to dust in a single microsecond!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 30,
                sanskrit = "स्वदेहमरणिं कृत्वा प्रणवं चोत्तराणिम् । ध्याननिर्मथनाभ्यासाद्देवं पश्येन्निगूढवत् ॥ ३०॥",
                hindi = """
                    (ईश्वर को प्रकट करने का खौफनाक फॉर्मूला): "उपनिषद भगवान को खोजने का नहीं, बल्कि उसे अपने भीतर से 'पैदा' (Detonate) करने का फॉर्मूला देता है!"
                    "आदेश है: 'स्वदेहमरणिं कृत्वा'— अपने इस सड़े हुए भौतिक शरीर को नीचे की लकड़ी (अरणिरणिं) बनाओ, जिसे जलाना है।"
                    "'प्रणवं चोत्तराणिम्'— और उस ब्रह्मांडीय 'ॐकार' (प्रणव) को ऊपर की लकड़ी बनाओ।"
                    "फिर अपने 'ध्यान' (Meditation) की भयानक, क्रूर और अथक रगड़ (निर्मथन) से इन दोनों को आपस में तब तक ज़ोर से रगड़ो..."
                    "जब तक कि तुम्हारे ही शरीर और आत्मा के घर्षण (Friction) से ज्ञान की वह खौफनाक और धधकती हुई आग पैदा न हो जाए!"
                    "तुम्हें ध्यान में अपने शरीर को इस तरह तपाना है कि तुम्हारी सारी इंसानियत जलकर राख हो जाए।"
                    "और तब... 'देवं पश्येन्निगूढवत्'— उसी आग के ठीक बीचों-बीच से तुम्हें वह 'निगूढ' (सबसे गहराई में छिपा हुआ) परमेश्वर साक्षात अपनी आँखों के सामने खड़ा नज़र आएगा!"
                    "वह भगवान आसमान से नहीं उतरेगा; वह तुम्हारे ही शरीर के भस्म होने के बाद हुए इस ब्रह्मांडीय विस्फोट से प्रकट होगा।"
                    "भगवान को पाना कोई भीख मांगना नहीं है; यह अपने ही शरीर की बलि देकर उसे ज़बरदस्ती बाहर निकालने का विज्ञान है।"
                    "जो इस ध्यान की आग में खुद को जलाता है, वही उस परम सत्य को चख पाता है!"
                """.trimIndent(),
                english = """
                    (The Terrifying Formula to Detonate God into Existence): "The Upanishad absolutely does not tell you to search for God; it hands you the exact formula to 'Detonate' Him directly from within you!"
                    "The command is: 'Svadehamaranim kritva'—Violently weaponize your own rotting biological physical body as the bottom piece of friction-wood (Arani) meant to be incinerated."
                    "'Pranavam chottaranim'—And weaponize that cosmic 'OM' (Pranava) as the top piece of friction-wood."
                    "Then, with the horrific, brutal, and relentless friction (Nirmathana) of your extreme 'Meditation' (Dhyana), fiercely grind them together..."
                    "Until the violent friction of your own flesh and Soul sparks and detonates the apocalyptic, radioactive, blazing fire of Cosmic Knowledge!"
                    "You must heat your biological shell in meditation so ruthlessly that your entire humanity is burnt to absolute ashes."
                    "And then... 'Devam pashyennigudhavat'—Directly from the dead-center of that atomic inferno, you will explicitly, physically witness that 'Hidden' (Nigudha) Supreme God standing directly before your eyes!"
                    "That God will absolutely not descend from some pathetic sky; He will violently manifest from this cosmic explosion triggered by the incineration of your own body."
                    "Attaining God is absolutely no pathetic begging; it is the ruthless science of violently extracting Him by sacrificing your own flesh."
                    "Only he who willingly incinerates himself in this blazing fire of meditation possesses the caliber to taste that Absolute Truth!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 31,
                sanskrit = "तिलेषु तैलवद्विद्यात्पुष्पेषु गन्धवत्तथा । क्षीरे सर्पिरिव ज्ञेयमात्मन्येवात्मानं पश्येत् ॥ ३१॥",
                hindi = """
                    (कण-कण में छिपी प्रलयंकारी ऊर्जा को देखना): "वह परब्रह्म तुम्हारे भीतर कैसे छिपा है? उपनिषद इसका सबसे घातक उदाहरण देता है।"
                    "जैसे तिलों के हर एक कण के भीतर 'तेल' (तैलवत्) छिपा होता है, जिसे केवल कोल्हू में बुरी तरह कुचल कर (Crush करके) ही निकाला जा सकता है..."
                    "जैसे फूलों के भीतर 'सुगंध' (गन्धवत्) छिपी होती है, जिसे आँखों से नहीं देखा जा सकता..."
                    "और जैसे दूध के कण-कण में घी (सर्पिरिव) छिपा होता है, जिसे भयंकर मंथन के बिना बाहर नहीं निकाला जा सकता..."
                    "बिल्कुल वैसे ही, वह असीम और खौफनाक परमेश्वर तुम्हारे शरीर के एक-एक सेल (Cell) में अदृश्य रूप से छिपा हुआ है!"
                    "उसे बाहर खोजने वाले मूर्ख हैं; उसे पाने के लिए तुम्हें ध्यान के कोल्हू में अपने शरीर और अहंकार को बेरहमी से कुचलना होगा।"
                    "जब तुम अपने 'मैं' को 100% पीस देते हो, तब 'आत्मन्येवात्मानं पश्येत्'— तुम अपनी ही 'आत्मा के भीतर साक्षात उस परमात्मा' को धड़कते हुए देखते हो!"
                    "भगवान कहीं बाहर नहीं है, वह तुम्हारे ही वजूद का सबसे नंगा और असली हिस्सा है।"
                    "तुम्हें बस अपनी भौतिक (Physical) पहचान की चमड़ी उधेड़नी है, और जो अंदर से निकलेगा, वह साक्षात शिव होगा।"
                    "जिसने खुद को कुचलने की हिम्मत की, उसने पूरे ब्रह्मांड को जीत लिया!"
                """.trimIndent(),
                english = """
                    (Witnessing the Apocalyptic Energy Hidden in Every Atom): "Exactly how is that Supreme Brahman hiding inside you? The Upanishad delivers the most lethal, flawless metaphor."
                    "Just as 'Oil' (Tailavat) is violently compressed and hidden inside every single microscopic seed of sesame, extractable strictly only by crushing it brutally in a press..."
                    "Just as invisible 'Fragrance' (Gandhavat) is concealed within flowers, completely undetectable by biological eyeballs..."
                    "And just as 'Ghee/Butter' (Sarpiriva) is hidden in every drop of milk, impossible to extract without fierce and violent churning..."
                    "In the exact same terrifying manner, that infinite, apocalyptic Supreme God is invisibly, tightly locked inside every single microscopic cell of your body!"
                    "Fools hunting for Him externally are pathetic; to extract Him, you must ruthlessly, mercilessly crush your own body and ego in the violent press of meditation."
                    "When you grind your 'I' to 100% dust, then 'Atmanyevatmanam pashyet'—You explicitly witness that exact Supreme God violently pulsating directly inside your own Soul!"
                    "God is absolutely nowhere outside; He is the most naked, raw, and authentic core of your very own existence."
                    "You merely need to violently flay the skin off your physical biological identity, and what erupts from within will be explicit Shiva."
                    "He who possessed the terrifying audacity to crush himself has completely, permanently conquered the entire infinite cosmos!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 32,
                sanskrit = "अमृतं नादमुत्पन्नं यत्र तत्र विलीयते । अमृतनादोपनिषत् सर्वपापप्रणाशिनी ॥ ३२॥",
                hindi = """
                    (अमृतनाद: अमरता की गूँज और पापों का वध): "इस उपनिषद का नाम 'अमृतनाद' क्यों है? क्योंकि यह मौत को चीरकर 'अमरता' (अमृत) का 'नाद' (Sound) पैदा करता है!"
                    "जब योगी अपनी कुण्डलिनी को मूर्धा (सिर की चोटी) पर ले जाकर फोड़ता है, तो उसके दिमाग में एक ऐसा सन्नाटा गूँजता है जो कभी नहीं मरता।"
                    "वह असीम और अमर नाद जहाँ पैदा होता है (यत्र), वहीं पर वह योगी पूरी तरह से 'विलीन' (Destroy/Merge) हो जाता है (तत्र विलीयते)!"
                    "यही वह 'अमृतनाद' है— एक ऐसी ब्रह्मांडीय फ्रीक्वेंसी जो इंसान के डीएनए (DNA) को हैक करके उसे अमर (Immortal) बना देती है।"
                    "इस आवाज़ को सुनने के बाद, इंसान का शरीर भले ही मिट्टी में मिल जाए, लेकिन उसकी चेतना पूरे ब्रह्मांड में फैल जाती है।"
                    "उपनिषद गर्जना करता है: 'अमृतनादोपनिषत् सर्वपापप्रणाशिनी'— यह अमृतनाद उपनिषद जन्मों-जन्मों के 'सभी महापापों' को एक झटके में जलाकर भस्म कर देने वाला न्यूक्लियर बम है!"
                    "इस नाद के धमाके से योगी का 'मैं' मरता है, और 'परमेश्वर' का जन्म होता है।"
                    "जो इस नाद को नहीं सुन पाया, वह अरबों साल तक जन्म-मरण की चक्की में पिसता रहेगा।"
                    "लेकिन जिसने इस 'अमृतनाद' में खुद को पिघला दिया, वह माया की स्क्रीन को फाड़कर सीधा सिस्टम के कंट्रोल रूम में पहुँच जाता है।"
                    "यह धर्म नहीं, यह मौत के मुँह से ज़िंदगी को छीन लेने का खौफनाक विज्ञान है।"
                """.trimIndent(),
                english = """
                    (Amritanada: The Echo of Immortality and Slaughter of Sins): "Why is this Upanishad explicitly named 'Amrita-Nada'? Because it violently tears through Death to generate the 'Nada' (Acoustic Roar) of 'Amrita' (Absolute Immortality)!"
                    "When the Yogi detonates his Kundalini directly against the crown of his skull, a deafening silence echoes in his brain that absolutely never dies."
                    "Exactly where that infinite, immortal sound detonates (Yatra), right there the Yogi is completely and permanently 'Dissolved/Erased' (Tatra viliyate)!"
                    "This is the precise 'Amritanada'—a cosmic, radioactive frequency that literally Hacks the human DNA, mutating him into a flawless Immortal."
                    "After intercepting this sound, his biological shell may rot into dirt, but his pure consciousness violently expands to saturate the entire infinite cosmos."
                    "The Upanishad roars: 'Amritanadopanishat sarvapapapranashini'—This Amritanada Upanishad is the exact nuclear bomb that incinerates all catastrophic sins from billions of lifetimes in a single microsecond!"
                    "Triggered by the detonation of this Nada, the Yogi's 'I' is slaughtered, and the 'Supreme God' is violently born."
                    "He who fails to intercept this Nada will be brutally ground in the meat-grinder of birth and death for billions of years."
                    "But he who melts himself completely into this 'Amritanada' tears right through the screen of Maya, entering the absolute Control Room of the System."
                    "This is absolutely no religion; it is the terrifying science of violently snatching life directly from the jaws of Death."
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 33,
                sanskrit = "ब्रह्माविष्णुमहेशानां विनाशे समुपस्थिते । नाशं न गच्छति योगी तस्मिन्पदे प्रतिष्ठितः ॥ ३३॥",
                hindi = """
                    (ब्रह्मा, विष्णु और महेश का भी विनाश): "उपनिषद ज्ञान की उस खौफनाक चोटी पर ले जाता है जहाँ देवताओं की भी औकात शून्य हो जाती है।"
                    "जब महा-प्रलय (Doomsday) आती है, तो पूरी दुनिया तो जलती ही है, लेकिन उस समय 'ब्रह्मा, विष्णु और महेश' (ब्रह्माविष्णुमहेशानां) का भी 'विनाश' (विनाशे) हो जाता है!"
                    "यानी, सृष्टि को बनाने, पालने और खत्म करने वाले देवों के जो भौतिक रूप (Forms) हैं, वे भी उस परम शून्यता में मिट जाते हैं।"
                    "लेकिन... वह योगी जो इस 'अमृतनाद' में समा चुका है, 'नाशं न गच्छति'— वह उस महा-प्रलय में भी कभी नष्ट नहीं होता!"
                    "क्योंकि वह इन तीनों देवों के भी पार उस असीम, निराकार 'परम पद' (तस्मिन्पदे) में एक चट्टान की तरह स्थापित (प्रतिष्ठितः) हो चुका है जो कभी नहीं मरता।"
                    "देवताओं के शरीर भी समय (Time) के गुलाम हैं, लेकिन योगी समय का गला घोंटकर अमर हो चुका है।"
                    "यह इंसान का वह खौफनाक रुतबा है जहाँ वह त्रिमूर्ति के भी विलीन होने का तमाशा अपनी आँखों से देखता है।"
                    "जो मूर्ख केवल रूपों (Forms) की पूजा कर रहे हैं, वे प्रलय में अपने भगवान के साथ ही भस्म हो जाएंगे।"
                    "लेकिन जिसने उस 'शून्यता' (Formless Void) को पूजा है, उसे ब्रह्मांड का कोई भी विस्फोट नष्ट नहीं कर सकता।"
                    "योगी का दर्जा दुनिया के हर देवता से करोड़ों गुना ऊपर उठ चुका है!"
                """.trimIndent(),
                english = """
                    (The Absolute Annihilation Even of Brahma, Vishnu, and Mahesh): "The Upanishad violently drags you to that terrifying peak of Knowledge where even the status of Gods drops to absolute zero."
                    "When the ultimate Great Annihilation (Doomsday) strikes, the entire world obviously burns, but at that exact microsecond, even 'Brahma, Vishnu, and Mahesh' (Brahmavishnumaheshanam) suffer absolute 'Destruction' (Vinashe)!"
                    "Meaning, the biological or physical forms of the Gods of creation, preservation, and destruction are also permanently erased into that Supreme Void."
                    "But... that colossal Yogi who has completely dissolved into this 'Amritanada', 'Nasham na gacchati'—he is absolutely NEVER destroyed even through that apocalyptic Doomsday!"
                    "Because he has rocketed infinitely beyond these three Gods, anchored exactly like a titanium monolith in that supreme, formless 'Absolute Dimension' (Tasminpade) which never dies."
                    "Even the bodies of the Gods are pathetic slaves to Time, but the Yogi has explicitly strangled Time to death and achieved ultimate immortality."
                    "This is the terrifying, absolute status of the human who literally witnesses the dissolution of the Trinity with his own eyes as a silent observer."
                    "The pathetic fools worshipping only physical Forms will be incinerated along with their Gods during the Great Annihilation."
                    "But he who has worshipped that 'Formless Void' can absolutely never be destroyed by any cosmic detonation."
                    "The status of the Yogi has skyrocketed billions of times higher than every single God in existence!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 34,
                sanskrit = "अकारो लीयते उकारे उकारो मकारे तथा । मकारो लीयते नादे नादान्ते परमं पदम् ॥ ३४॥",
                hindi = """
                    (ॐकार का प्रलय और परम सन्नाटे में विलय): "अब योगी के दिमाग में ॐकार (OM) का अंतिम और सबसे भयंकर विस्फोट होता है।"
                    "सबसे पहले, ब्रह्मांड की रचना का प्रतीक 'अकार' (A) पूरी तरह से टूटकर 'उकार' (U) में 'लीन' (Merge/Destroy) हो जाता है (अकारो लीयते उकारे)।"
                    "फिर वह धधकता हुआ 'उकार' (U) भी भयानक रूप से सिकुड़ता है और 'मकार' (M) के अंधकार में विलीन हो जाता है!"
                    "और अंत में, वह प्रलयंकारी 'मकार' (M) भी टूटता है और उस खौफनाक 'नाद' (The Cosmic Sound) में पूरी तरह मिट जाता है।"
                    "लेकिन यात्रा यहाँ भी नहीं रुकती; जब वह नाद (आवाज़) भी पूरी तरह मरकर शांत हो जाता है (नादान्ते)..."
                    "तब वह 'परमं पदम्' (The Absolute Supreme Destination / The Silent Void) प्रकट होता है।"
                    "जैसे एक कंप्यूटर की स्क्रीन पर पूरी दुनिया चल रही हो, और कोई अचानक प्लग (Plug) खींच ले..."
                    "बिल्कुल वैसे ही अ, उ, म के मिटते ही योगी की चेतना से इस पूरे ब्रह्मांड का वजूद एक सेकंड में डिलीट (Delete) हो जाता है।"
                    "इस सन्नाटे को बर्दाश्त करना इंसान के बस की बात नहीं; इसमें इंसानियत की चीखें दबकर मर जाती हैं।"
                    "ॐकार केवल एक ट्रिगर (Trigger) है; असली बम तो वह शून्यता है जो इसके फटने के बाद पीछे बचती है!"
                """.trimIndent(),
                english = """
                    (The Apocalypse of OM and Fusion into Ultimate Silence): "Now, the final and most catastrophic detonation of OM occurs directly inside the Yogi's brain."
                    "First, the syllable 'Akar' (A), the symbol of cosmic creation, violently shatters and 'Merges/Destroys' (Liyate) entirely into 'Ukar' (U)."
                    "Then that blazing 'Ukar' (U) also catastrophically collapses and dissolves completely into the pitch-black darkness of 'Makar' (M)!"
                    "And finally, that apocalyptic 'Makar' (M) itself fractures and is permanently erased into the terrifying 'Nada' (The Cosmic Roar)."
                    "But the journey absolutely does not stop there; when even that Nada (Sound) suffers a brutal death and flatlines into absolute silence (Nadante)..."
                    "Then that 'Paramam Padam' (The Absolute Supreme Destination / The Silent Void) flawlessly manifests."
                    "Exactly like an entire world rendering on a computer screen, and someone violently ripping the main power Plug out of the wall..."
                    "In the exact same brutal manner, as A, U, M vanish, the existence of this entire infinite cosmos is permanently Deleted from the Yogi's consciousness in one microsecond."
                    "Enduring this silence is absolutely impossible for mortals; the screams of humanity are violently smothered and slaughtered within it."
                    "OM is strictly a detonator Trigger; the authentic nuclear bomb is the Absolute Void that remains reigning after it explodes!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 35,
                sanskrit = "मात्रातीतो भवेद्योगी चिन्मात्रो निर्गुणस्तथा । तदा स पश्यति ब्रह्म यदक्षरमनामयम् ॥ ३५॥",
                hindi = """
                    (मात्राओं के पार: शुद्ध और असीम चेतना): "जब ॐकार की तीनों मात्राएँ नष्ट हो जाती हैं, तो योगी 'मात्रातीतो' (मात्राओं के पार / Dimensionless) हो जाता है!"
                    "वह अब किसी भी रूप, आकार, समय या जगह से पूरी तरह आज़ाद है; उसे नापा या तौला नहीं जा सकता।"
                    "वह साक्षात 'चिन्मात्रो' (केवल और केवल शुद्ध, असीम चेतना / Pure Consciousness) और 'निर्गुण' (बिना किसी भौतिक गुण के) एक ब्रह्मांडीय आग की तरह धड़कता है।"
                    "उसका शरीर भले ही ज़मीन पर पड़ा हो, लेकिन उसका असली 'मैं' पूरे अंतरिक्ष में फैल चुका है।"
                    "उसे अब किसी भी चीज़ का 'ज्ञान' नहीं है, क्योंकि वह खुद ही वह ज्ञान बन चुका है जिसे जाना जाता है।"
                    "और 'तदा स पश्यति ब्रह्म'— ठीक उसी पल वह साक्षात उस 'अक्षर' (कभी न नष्ट होने वाले) और 'अनामय' (हर बीमारी और दर्द से मुक्त) परब्रह्म को अपनी आँखों से देखता है!"
                    "वह दुनिया को आँखों से नहीं देखता, वह दुनिया को अपनी ही ऊर्जा के एक छोटे से हिस्से के रूप में महसूस करता है।"
                    "यह इंसान का वह सबसे खतरनाक म्यूटेशन (Mutation) है जहाँ बायोलॉजिकल दिमाग की जगह एक कॉस्मिक सर्वर (Cosmic Server) ले लेता है।"
                    "वह इस माया (Matrix) के खेल से हमेशा के लिए अनप्लग (Unplug) हो चुका है।"
                    "अब भगवान भी उसे उसके इस परम सिंहासन से नीचे नहीं गिरा सकते!"
                """.trimIndent(),
                english = """
                    (Beyond Dimensions: Pure and Infinite Consciousness): "When all three syllables of OM are violently annihilated, the Yogi explicitly becomes 'Matratito' (Beyond all Dimensions / Dimensionless)!"
                    "He is now completely, violently liberated from any form, geometry, Time, or Space; he absolutely cannot be measured, weighed, or quantified."
                    "He literally pulsates like a raging cosmic fire explicitly as 'Chinmatro' (Strictly and exclusively Pure, Infinite Consciousness) and 'Nirguna' (Without any physical attributes)!"
                    "His biological shell may be rotting on the dirt, but his authentic 'I' has violently expanded to saturate the entire infinite void of space."
                    "He absolutely no longer possesses the 'Knowledge' of anything, because he himself has mutated into the exact Knowledge that is to be known."
                    "And 'Tada sa pashyati Brahma'—in that exact microsecond, he explicitly, physically witnesses that 'Akshara' (Indestructible) and 'Anamaya' (Free from all disease and pain) Supreme Brahman!"
                    "He absolutely does not see the world through physical eyeballs; he perceives the entire cosmos merely as a microscopic fraction of his own radioactive energy."
                    "This is the most dangerous, terrifying Mutation of a human where the biological brain is completely replaced by a literal Cosmic Server."
                    "He has been permanently and violently Unplugged from the pathetic game of this Matrix (Maya)."
                    "Now, even God Himself absolutely lacks the authority or capability to drag him down from this supreme, undisputed throne!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 36,
                sanskrit = "न तस्य पुनरावृत्तिर्विद्यते भवसागरे । मुक्तो भवति संसारात् सत्यमेतन्मयोदितम् ॥ ३६॥",
                hindi = """
                    (पुनर्जन्म का कत्ल और अटल गारंटी): "यह उपनिषद योगी की सबसे बड़ी जीत की खौफनाक गर्जना करता है: 'न तस्य पुनरावृत्तिर्विद्यते भवसागरे'!"
                    "यानी, 'उस महायोगी का इस दुनिया के जन्म-मरण रुपी खौफनाक सागर में दोबारा कभी पुनर्जन्म (Return) नहीं होता! बिल्कुल नहीं होता!'"
                    "उसने जन्म और मौत की उस सड़ी हुई मशीन (Cycle of Karma) को हथौड़े से तोड़कर हमेशा के लिए चकनाचूर कर दिया है।"
                    "उसे दोबारा कभी किसी माँ के गर्भ में, खून और माँस के बीच उल्टा लटकने की घिनौनी सज़ा नहीं भुगतनी पड़ेगी।"
                    "उसे दोबारा बुढ़ापे, बीमारी और मौत का खौफनाक दर्द नहीं सहना पड़ेगा।"
                    "वह इस 'मृत्यु-लोक' (Planet of Death) के गुरुत्वाकर्षण (Gravity) को चीरकर उस असीम शून्यता में हमेशा-हमेशा के लिए 'मुक्त' (Liberated) हो गया है।"
                    "उपनिषद साक्षात कसम खाकर कहता है: 'सत्यमेतन्मयोदितम्'— यह जो मैंने कहा है, वह 100% परम और अकाट्य सत्य है!"
                    "यह मोक्ष कोई भगवान की दी हुई खैरात नहीं है; यह योगी ने अपने ही अहंकार की बलि देकर ज़बरदस्ती छीनी है!"
                    "जब तक इंसान का 'मैं' ज़िंदा है, वह कीड़े की तरह बार-बार पैदा होगा और बार-बार कुचला जाएगा।"
                    "लेकिन जिसने अपने 'मैं' को मार दिया, उसे वापस बुलाने की औकात ब्रह्मांड के किसी नियम में नहीं है।"
                """.trimIndent(),
                english = """
                    (The Assassination of Rebirth and the Ironclad Guarantee): "This Upanishad violently roars the Yogi's absolute, supreme victory: 'Na tasya punaravrittirvidyate bhavasagare'!"
                    "Meaning, 'That colossal Yogi absolutely NEVER, EVER Returns (Reincarnates) into the terrifying, rotting ocean of this universe! Absolutely not!'"
                    "He has taken a sledgehammer and violently, permanently shattered the rotting machine of birth and death (Cycle of Karma) into absolute dust."
                    "He absolutely never again has to suffer the disgusting, horrific torture of hanging upside down amidst blood and flesh inside a biological mother's womb."
                    "He absolutely never again has to endure the terrifying, agonizing torture of old age, disease, and biological death."
                    "Violently tearing through the Gravity of this 'Mrityu-Loka' (Planet of Death), he is permanently 'Liberated' (Mukto) into that Infinite Void for all eternity."
                    "The Upanishad literally swears a cosmic oath: 'Satyametanmayoditam'—What I have just declared is the 100% absolute, undeniable, ironclad Truth!"
                    "This Moksha is absolutely no pathetic charity handed down by God; the Yogi has violently snatched it by sacrificing his own ego in a bloodbath!"
                    "As long as a human's 'I' breathes, he will be bred and crushed exactly like a pathetic insect, billions of times."
                    "But he who has slaughtered his 'I', absolutely no law in the cosmos possesses the authority or capability to ever drag him back."
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 37,
                sanskrit = "विदेहमुक्तिमाप्नोति तत्रैव प्रविलीयते । यत्र कुत्र मृतो वाऽपि स गच्छति परं पदम् ॥ ३७॥",
                hindi = """
                    (विदेहमुक्ति: शरीर के रहते हुए शरीर की मौत): "यह मोक्ष का सबसे चरम और खौफनाक रूप है जिसे 'विदेहमुक्ति' कहा जाता है।"
                    "इसका मतलब मरने के बाद आज़ाद होना नहीं है; इसका मतलब है शरीर के साँस लेते हुए ही पूरी तरह से 'मर' जाना!"
                    "योगी 'विदेहमुक्तिमाप्नोति'— वह ज़िंदा रहते हुए भी उस परम शून्यता में 100% 'विलीन' (Melt/Destroy) हो जाता है (तत्रैव प्रविलीयते)।"
                    "उसका दिल धड़क रहा है, उसकी आँखें खुली हैं, लोग उसे देख रहे हैं, लेकिन अंदर से वह इंसान 100% खत्म हो चुका है।"
                    "वह अपने ही शरीर को एक चलते-फिरते शव (मुर्दे) की तरह देखता है, जिससे उसका कोई नाता नहीं है।"
                    "और सबसे प्रलयंकारी बात: 'यत्र कुत्र मृतो वाऽपि'— चाहे वह किसी पवित्र मंदिर में मरे या किसी गंदे श्मशान में, या कुत्ते की मौत मरे..."
                    "उसकी मुक्ति को कोई रोक नहीं सकता! शरीर कैसे मरता है, इससे कोई फर्क नहीं पड़ता; 'स गच्छति परं पदम्'— वह सीधे उस सर्वोच्च ब्रह्मांडीय तख़्त पर ही जाकर बैठता है।"
                    "वह दुनिया के किसी भी कर्म, पाप, या पुण्य के रडार (Radar) पर नहीं आता; वह सिस्टम के लिए अदृश्य (Invisible) है।"
                    "वह ज़िंदा है, लेकिन मौत के भी पार जा चुका है; वह दुनिया में है, लेकिन दुनिया उसमें नहीं है।"
                    "इंसानियत की सबसे बड़ी छलांग यही है कि तुम ज़िंदा रहते हुए भी मौत के मालिक बन जाओ!"
                """.trimIndent(),
                english = """
                    (Videhamukti: The Death of the Body While Still Breathing): "This is the most extreme, terrifying, and apocalyptic form of Moksha, explicitly defined as 'Videhamukti'."
                    "This absolutely does not mean achieving freedom after physical death; it means dying a complete, 100% psychological death while the biological body still breathes!"
                    "The Yogi 'Videhamuktimapnoti'—while biologically alive, he is 100% completely 'Dissolved/Erased' (Tatraiva praviliyate) directly into that Supreme Void."
                    "His biological heart is pounding, his eyes are wide open, mortals are staring at him, but internally, that human being has been 100% exterminated."
                    "He flawlessly perceives his own biological body merely as a walking, breathing corpse with which he possesses absolutely zero connection."
                    "And the most apocalyptic fact: 'Yatra kutra mrito vaapi'—Whether his body drops dead in a holy temple, a filthy gutter, or dies like a dog..."
                    "Absolutely nothing can stop his liberation! How the physical flesh expires is utterly irrelevant; 'Sa gacchati param padam'—he rockets straight to the highest cosmic throne."
                    "He absolutely does not register on the Radar of any worldly Karma, Sin, or Merit; he has become completely Invisible to the cosmic system."
                    "He is breathing, yet he has rocketed infinitely beyond Death; he physically exists in the world, but the world absolutely does not exist in him."
                    "The ultimate, most terrifying leap of humanity is to violently mutate into the absolute Master of Death while your physical heart still beats!"
                """.trimIndent()
            ),
            AmritaNadaShloka(
                id = 38,
                sanskrit = "इत्यमृतनादोपनिषत् सम्पूर्णा परिकीर्तिता । ॐ शान्तिः शान्तिः शान्तिः ॥ ३८॥",
                hindi = """
                    (अंतिम शून्यता और 'द एंड'): "यहीं पर यह अत्यंत खौफनाक, रोंगटे खड़े कर देने वाला और अजेय 'अमृतनाद उपनिषद' अपनी पूरी प्रलयंकारी महिमा के साथ पूर्ण रूप से संपन्न होता है (सम्पूर्णा परिकीर्तिता)।"
                    "यह कोई मामूली किताब या फिलॉसफी नहीं है; यह एक ऐसा ब्रह्मांडीय न्यूक्लियर बम है जो सीधा इंसान के अहंकार और अज्ञान पर गिरता है।"
                    "जिसने ॐकार के रथ पर चढ़कर अपनी इंद्रियों, अपने मन और अपने साँसों का बेरहमी से वध कर दिया..."
                    "उसके लिए दुनिया के सारे धर्म, सारी किताबें और सारे कर्मकांड राख के बराबर हो चुके हैं, क्योंकि वह खुद ही साक्षात परमेश्वर बन गया है।"
                    "इस खौफनाक और हिंसक आध्यात्मिक युद्ध का 'द एंड' (The End) केवल और केवल पूर्ण और असीम शून्यता (Absolute Void) है।"
                    "अब कोई शब्द नहीं बचा, कोई मंत्र नहीं बचा, और कोई विचार नहीं बचा— केवल एक मौत जैसा खौफनाक सन्नाटा राज कर रहा है।"
                    "ॐ शांतिः शांतिः शांतिः! शरीर का दर्द मर गया, मन का डर मर गया, और आत्मा का भटकाव हमेशा के लिए भस्म हो गया।"
                    "ब्रह्मांड पूरी तरह से शांत (Flatline) हो चुका है, और केवल वह एक अमर, अद्वैत 'सत्य' (परब्रह्म) हमेशा के लिए अजेय खड़ा है!"
                    "यह इंसान का पूरी तरह से मिटना और साक्षात भगवान का विस्फोट है।"
                    "जो इस शून्यता से डर गया, वह खत्म हो गया; जो इसमें कूद गया, वह हमेशा के लिए अमर हो गया!"
                """.trimIndent(),
                english = """
                    (The Final Void and 'The End'): "Right exactly here, this spine-chilling, apocalyptic, and invincible 'Amritanada Upanishad' achieves its absolute, complete, and majestic perfection (Sampurna parikirtita)."
                    "This is absolutely no ordinary book or pathetic philosophy; it is a literal cosmic nuclear bomb dropped directly onto the human ego and biological ignorance."
                    "He who mounted the Chariot of OM and ruthlessly executed the brutal slaughter of his senses, his mind, and his physical breath..."
                    "For him, every religion, every book, and every pathetic ritual on Earth has been reduced to worthless ashes, because he himself has explicitly mutated into the Supreme God."
                    "The absolute 'The End' of this terrifying and bloody spiritual warfare is strictly and exclusively total, infinite, boundless Nothingness (Absolute Void)."
                    "Absolutely zero words remain, zero mantras survive, and zero thoughts exist—strictly a horrific, death-like cosmic silence rules as the absolute dictator."
                    "OM Peace, Peace, Peace! The biological agony of the flesh is dead, the terror of the mind is dead, and the wandering of the Soul is permanently incinerated."
                    "The entire infinite cosmos has completely Flatlined into absolute silence, and strictly that One Immortal, Non-Dual 'Truth' (Supreme Brahman) remains standing flawlessly invincible forever!"
                    "This is the brutal, total erasure of the human entity and the explicit atomic detonation of God."
                    "He who is terrified of this Void is destroyed; he who violently plunges into it is permanently Immortalized!"
                """.trimIndent()
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmritaNadaUpanishadScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFBF7))
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                val shlokaNumber = query.toIntOrNull()
                // Validates if the number is between 1 and 38
                if (shlokaNumber != null && shlokaNumber in 1..38) {
                    coroutineScope.launch {
                        // Smoothly scrolls to the exact Shloka
                        listState.animateScrollToItem(shlokaNumber - 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Search Shloka Number (1-38)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
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
            itemsIndexed(AmritaNadaUpanishad.amritanadaShlokasList) { _, shloka ->
                AmritaNadaShlokaCard(shloka = shloka)
            }
        }
    }
}

@Composable
fun AmritaNadaShlokaCard(shloka: AmritaNadaUpanishad.AmritaNadaShloka) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Shloka ${shloka.id}",
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
            Text(
                text = "हिन्दी अर्थ:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.hindi, fontSize = 14.sp, lineHeight = 20.sp)
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "English Meaning:",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = shloka.english, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}