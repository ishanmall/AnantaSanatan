package com.sanatangyansagar.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

// --- CORE & HOME IMPORTS ---
import com.sanatangyansagar.ui.screens.home.HomeScreen
import com.sanatangyansagar.ui.screens.Bhagwan.GodDetailScreen

// --- BHAGAVAD GITA IMPORTS ---
import com.sanatangyansagar.ui.screens.gita.*

// --- DURGA MAA & SUKTAM IMPORTS ---
import com.sanatangyansagar.ui.screens.DurgaMaa.*

// --- DURGA SAPTSHATI ADHYAYAS ---
import com.sanatangyansagar.ui.screens.DurgaSaptshati.DurgaSapshati as DurgaShapshatiMenuScreen
import com.sanatangyansagar.ui.screens.DurgaSaptshati.*

// --- RAMAYAN (BAAL KAND) IMPORTS ---
import com.sanatangyansagar.ui.screens.Ramayan.Ramayan
import com.sanatangyansagar.ui.screens.Ramayan.BaalKand.*

// --- UPANISHAD IMPORTS ---
import com.sanatangyansagar.ui.screens.upnishad.*

// --- SAMVEDA IMPORTS ---
import com.sanatangyansagar.ui.screens.veda.samveda.SamvedaHubScreen
import com.sanatangyansagar.ui.screens.veda.samveda.PurvarchikaSamVeda.*
import com.sanatangyansagar.ui.screens.veda.samveda.UttararchikaSamveda.*

@Serializable
sealed class Screens {
    val route: Screens get() = this
    // --- HOME & CORE ---
    @Serializable object Home : Screens()
    @Serializable object GeetaMenu : Screens()
    @Serializable object UpanishadDashboard : Screens()
    @Serializable object GodDetail : Screens()

    // --- DURGA MAA (AARTIES, STOTRAMS & SUKTAMS) ---
    @Serializable object DurgaMaaMenu : Screens()
    @Serializable object ShreeDurgaChalisa : Screens()
    @Serializable object ShreeAmbaJiKIAarti : Screens()
    @Serializable object ShreeDeviJiKiAarti : Screens()
    @Serializable object ArgalaStrotam : Screens()
    @Serializable object KilakStrotam : Screens()
    @Serializable object AthDevaKvacham : Screens()
    @Serializable object BrahmadiShapVimochanam : Screens()
    @Serializable object ShaptSatiNyashah : Screens()

    // Fixed Suktams
    @Serializable object RigVedoktamRatriSuktam : Screens()
    @Serializable object TantroktamRatriSuktam : Screens()
    @Serializable object RigVedoktamDeviSuktam : Screens()
    @Serializable object TantroktamDeviSuktam : Screens()

    @Serializable object SHREEDURGAASTOTTARSATNAAMSTOTRAM : Screens()
    @Serializable object SchamaPrathna : Screens()

    // --- DURGA SAPTSHATI (ADHYAYAS) ---
    @Serializable object DurgaShapshatiMenu : Screens()
    @Serializable object DurgaShapshatiAdhyayaOne : Screens()
    @Serializable object DurgaShapshatiAdhyayaTwo : Screens()
    @Serializable object DurgaShapshatiAdhyayaThree : Screens()
    @Serializable object DurgaShapshatiAdhyayaFour : Screens()
    @Serializable object DurgaShapshatiAdhyayaFive : Screens()
    @Serializable object DurgaShapshatiAdhyayaSix : Screens()
    @Serializable object DurgaShapshatiAdhyayaSeven : Screens()
    @Serializable object DurgaShapshatiAdhyayaEight : Screens()
    @Serializable object DurgaShapshatiAdhyayaNine : Screens()
    @Serializable object DurgaShapshatiAdhyayaTen : Screens()
    @Serializable object DurgaShapshatiAdhyayaEleven : Screens()
    @Serializable object DurgaShapshatiAdhyayaTwelve : Screens()
    @Serializable object DurgaShapshatiAdhyayaThirteen : Screens()

    // --- BHAGAVAD GITA (ADHYAYA 1 TO 18) ---
    @Serializable object AdhyayaOne : Screens()
    @Serializable object AdhyayaTwo : Screens()
    @Serializable object AdhyayaThree : Screens()
    @Serializable object AdhyayaFour : Screens()
    @Serializable object AdhyayaFive : Screens()
    @Serializable object AdhyayaSix : Screens()
    @Serializable object AdhyayaSeven : Screens()
    @Serializable object AdhyayaEight : Screens()
    @Serializable object AdhyayaNine : Screens()
    @Serializable object AdhyayaTen : Screens()
    @Serializable object AdhyayaEleven : Screens()
    @Serializable object AdhyayaTwelve : Screens()
    @Serializable object AdhyayaThirteen : Screens()
    @Serializable object AdhyayaFourteen : Screens()
    @Serializable object AdhyayaFifteen : Screens()
    @Serializable object AdhyayaSixteen : Screens()
    @Serializable object AdhyayaSeventeen : Screens()
    @Serializable object AdhyayaEighteen : Screens()

    // --- RAMAYAN (BAAL KAND) ---
    @Serializable object RamayanMenu : Screens()
    @Serializable object BaalKandMenu : Screens()
    @Serializable object BaalKandSargaOne : Screens()
    @Serializable object BaalKandSargaTwo : Screens()
    @Serializable object BaalKandSargaThree : Screens()
    @Serializable object BaalKandSargaFour : Screens()
    @Serializable object BaalKandSargaFive : Screens()
    @Serializable object BaalKandSargaSix : Screens()
    @Serializable object PranagnihotraUpanishad : Screens()
    @Serializable object BaalKandSargaSeven : Screens()
    @Serializable object BaalKandSargaEight : Screens()
    @Serializable object ParabrahmaUpanishad : Screens()
    @Serializable object ShukarahasyaUpanishad : Screens()
    @Serializable object BaalKandSargaNine : Screens()
    @Serializable object BaalKandSargaTen : Screens()
    @Serializable object BaalKandSargaEleven : Screens()

    // --- UPANISHADS ---
    @Serializable object AdhyatmaUpanishad : Screens()
    @Serializable object AdvaitaUpanishad : Screens()
    @Serializable object AdwayatarakaUpanishad : Screens()
    @Serializable object AitareyaUpanishad : Screens()
    @Serializable object AkshiUpanishad : Screens()
    @Serializable object AmritabinduUpanishad : Screens()
    @Serializable object AmritaNadaUpanishad : Screens()
    @Serializable object AnnapurnaUpanishad : Screens()
    @Serializable object AruniUpanishad : Screens()
    @Serializable object AtharvashikhaUpanishad : Screens()
    @Serializable object AtharvashirasUpanishad : Screens()

    @Serializable object BahvrichaUpanishad : Screens()
    @Serializable object DeviUpanishad : Screens()
    @Serializable object MahaUpanishad : Screens()
    @Serializable object PanchabrahmaUpanishad : Screens()
    @Serializable object ShatyayaniyaUpanishad : Screens()
    @Serializable object AtmaprabodhaUpanishad : Screens()
    @Serializable object AtmaUpanishad : Screens()
    @Serializable object AvadhutaUpanishad : Screens()
    @Serializable object AvyaktaUpanishad : Screens()
    @Serializable object BhikshukaUpanishad : Screens()
    @Serializable object BrahmabinduUpanishad : Screens()
    @Serializable object BrahmaUpanishad : Screens()
    @Serializable object Brahmopanishad : Screens()
    @Serializable object BrihadJabalaUpanishad : Screens()
    @Serializable object DakshinamurtiUpanishad : Screens()
    @Serializable object DattatreyaUpanishad : Screens()
    @Serializable object DhyanabinduUpanishad : Screens()
    @Serializable object DhyanaUpanishad : Screens()
    @Serializable object EkaksharaUpanishad : Screens()
    @Serializable object GanapatiAtharvashirsha : Screens()
    @Serializable object GaneshaUpanishad : Screens()
    @Serializable object GarbhaUpanishad : Screens()
    @Serializable object GarudaUpanishad : Screens()
    @Serializable object GayatriUpanishad : Screens()
    @Serializable object HamsaUpanishad : Screens()
    @Serializable object HayagrivaUpanishad : Screens()
    @Serializable object IshaUpanishad : Screens()
    @Serializable object JabalaUpanishad : Screens()
    @Serializable object KaivalyaUpanishad : Screens()
    @Serializable object KalagnirudraUpanishad : Screens()
    @Serializable object KaliSantaranaUpanishad : Screens()
    @Serializable object KathaUpanishad : Screens()
    @Serializable object KenaUpanishad : Screens()
    @Serializable object KrishnaUpanishad : Screens()
    @Serializable object KundikaUpanishad : Screens()
    @Serializable object MahavakyaUpanishad : Screens()
    @Serializable object MaitreyaUpanishad : Screens()
    @Serializable object MaitreyiUpanishad : Screens()
    @Serializable object MandukyaUpanishad : Screens()
    @Serializable object YogashikhaUpanishad : Screens()

    @Serializable object MudgalaUpanishad : Screens()
    @Serializable object MundakaUpanishad : Screens()
    @Serializable object NadabinduUpanishad : Screens()
    @Serializable object NarayanUpanishad : Screens()
    @Serializable object NiralambaUpanishad : Screens()
    @Serializable object NirvanaUpanishad : Screens()
    @Serializable object PaingalaUpanishad : Screens()
    @Serializable object ParamahamsaUpanishad : Screens()
    @Serializable object PashupataUpanishad : Screens()
    @Serializable object PrashnaUpanishad : Screens()
    @Serializable object RamRahasyaUpanishad : Screens()
    @Serializable object RudraHridayaUpanishad : Screens()
    @Serializable object RudrakshaJabalaUpanishad : Screens()
    @Serializable object SannyasaUpanishad : Screens()
    @Serializable object SarirakaUpanishad : Screens()
    @Serializable object SarvasaraUpanishad : Screens()
    @Serializable object SaubhagyaLakshmiUpanishad : Screens()
    @Serializable object SavitriUpanishad : Screens()
    @Serializable object SharabhaUpanishad : Screens()
    @Serializable object ShvetashvataraUpanishad : Screens()
    @Serializable object SitaUpanishad : Screens()
    @Serializable object SkandaUpanishad : Screens()
    @Serializable object SubalaUpanishad : Screens()
    @Serializable object SuryaUpanishad : Screens()
    @Serializable object TaittiriyaUpanishad : Screens()
    @Serializable object TarasaraUpanishad : Screens()
    @Serializable object TejobinduUpanishad : Screens()
    @Serializable object TripuratapiniUpanishad : Screens()
    @Serializable object TripuraUpanishad : Screens()
    @Serializable object TuriyatitaUpanishad : Screens()
    @Serializable object VajrasuchiUpanishad : Screens()
    @Serializable object VasudevaUpanishad : Screens()

    // --- SAMVEDA HUB ---
    @Serializable object SamvedaHub : Screens()

    // --- SAMVEDA PURVARCHIKA ---
    @Serializable object Purvarchika : Screens()
    @Serializable object PurvarchikaAdhyayaOne : Screens()
    @Serializable object PurvarchikaAdhyayaTwo : Screens()
    @Serializable object PurvarchikaAdhyayaThree : Screens()
    @Serializable object PurvarchikaAdhyayaFour : Screens()
    @Serializable object PurvarchikaAdhyayaFive : Screens()
    @Serializable object PurvarchikaAdhyayaSix : Screens()

    // --- SAMVEDA UTTARARCHIKA ---
    @Serializable object Uttararchika : Screens()
    @Serializable object UttararchikaAdhyayaOne : Screens()
    @Serializable object UttararchikaAdhyayaTwo : Screens()
    @Serializable object UttararchikaAdhyayaThree : Screens()
    @Serializable object UttararchikaAdhyayaFour : Screens()
    @Serializable object UttararchikaAdhyayaFive : Screens()
    @Serializable object UttararchikaAdhyayaSix : Screens()
    @Serializable object UttararchikaAdhyayaSeven : Screens()
    @Serializable object UttararchikaAdhyayaEight : Screens()
    @Serializable object UttararchikaAdhyayaNine : Screens()

}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home
    ) {
        // --- 1. HOME & CORE ---
        composable<Screens.Home> { HomeScreen(navController = navController) }
        composable<Screens.GodDetail> { GodDetailScreen() }

        // --- 2. BHAGAVAD GITA (Adhyaya 1 to 18) ---
        composable<Screens.GeetaMenu> { Geeta(navController = navController) }
        composable<Screens.AdhyayaOne> { AdhyayaOne() }
        composable<Screens.AdhyayaTwo> { AdhyayaTwo() }
        composable<Screens.AdhyayaThree> { AdhyayaThree() }
        composable<Screens.AdhyayaFour> { AdhyayaFour() }
        composable<Screens.AdhyayaFive> { AdhyayaFive() }
        composable<Screens.AdhyayaSix> { AdhyayaSix() }
        composable<Screens.AdhyayaSeven> { AdhyayaSeven() }
        composable<Screens.AdhyayaEight> { AdhyayaEight() }
        composable<Screens.AdhyayaNine> { AdhyayaNine() }
        composable<Screens.AdhyayaTen> { AdhyayaTen() }
        composable<Screens.AdhyayaEleven> { AdhyayaEleven() }
        composable<Screens.AdhyayaTwelve> { AdhyayaTwelve() }
        composable<Screens.AdhyayaThirteen> { AdhyayaThirteen() }
        composable<Screens.AdhyayaFourteen> { AdhyayaFourteen() }
        composable<Screens.AdhyayaFifteen> { AdhyayaFifteen() }
        composable<Screens.AdhyayaSixteen> { AdhyayaSixteen() }
        composable<Screens.AdhyayaSeventeen> { AdhyayaSeventeen() }
        composable<Screens.AdhyayaEighteen> { AdhyayaEighteen() }

        // --- 3. DURGA MAA (Bhakti Content) ---
        composable<Screens.ShreeDurgaChalisa> { ShreeDurgaChalisaScreen() }
        composable<Screens.ShreeAmbaJiKIAarti> { ShreeAmbaJiKIAartiScreen() }
        composable<Screens.ShreeDeviJiKiAarti> { ShreeDeviJiKiAartiScreen() }
        composable<Screens.ArgalaStrotam> { ArgalaStrotamScreen() }
        composable<Screens.KilakStrotam> { KilakStrotamScreen() }
        composable<Screens.AthDevaKvacham> { AthDevaKvachamScreen() }
        composable<Screens.BrahmadiShapVimochanam> { BrahmadiShapVimochanamScreen() }
        composable<Screens.ShaptSatiNyashah> { ShaptSatiNyashahScreen() }
        composable<Screens.RigVedoktamRatriSuktam> { RigVedoktamRatriSuktamScreen() }
        composable<Screens.TantroktamRatriSuktam> { TantroktamRatriSuktamScreen() }
        composable<Screens.RigVedoktamDeviSuktam> { RigVedoktamDeviSuktamScreen() }
        composable<Screens.TantroktamDeviSuktam> { TantroktamDeviSuktamScreen() }
        composable<Screens.SHREEDURGAASTOTTARSATNAAMSTOTRAM> { SHREEDURGAASTOTTARSATNAAMSTOTRAMScreen() }
        composable<Screens.SchamaPrathna> { SchamaPrathnaScreen() }

        // --- 4. DURGA SAPTSHATI ADHYAYAS ---
        composable<Screens.DurgaShapshatiMenu> { DurgaShapshatiMenuScreen(navController = navController) }
        composable<Screens.DurgaShapshatiAdhyayaOne> { AdhyayaOneScreen() }
        composable<Screens.DurgaShapshatiAdhyayaTwo> { AdhyayaTwoScreen() }
        composable<Screens.DurgaShapshatiAdhyayaThree> { AdhyayaThreeScreen() }
        composable<Screens.DurgaShapshatiAdhyayaFour> { AdhyayaFourScreen() }
        composable<Screens.DurgaShapshatiAdhyayaFive> { AdhyayaFiveScreen() }
        composable<Screens.DurgaShapshatiAdhyayaSix> { AdhyayaSixScreen() }
        composable<Screens.DurgaShapshatiAdhyayaSeven> { AdhyayaSevenScreen() }
        composable<Screens.DurgaShapshatiAdhyayaEight> { AdhyayaEightScreen() }
        composable<Screens.DurgaShapshatiAdhyayaNine> { AdhyayaNineScreen() }
        composable<Screens.DurgaShapshatiAdhyayaTen> { AdhyayaTenScreen() }
        composable<Screens.DurgaShapshatiAdhyayaEleven> { AdhyayaElevenScreen() }
        composable<Screens.DurgaShapshatiAdhyayaTwelve> { AdhyayaTwelveScreen() }
        composable<Screens.DurgaShapshatiAdhyayaThirteen> { AdhyayaThirteenScreen() }

        // --- 5. UPANISHADS ---
        composable<Screens.UpanishadDashboard> { UpanishadScreen(navController = navController) }
        composable<Screens.AdhyatmaUpanishad> { AdhyatmaUpanishadScreen() }
        composable<Screens.AdvaitaUpanishad> { AdvaitaUpanishadScreen() }
        composable<Screens.AdwayatarakaUpanishad> { AdwayatarakaUpanishadScreen() }
        composable<Screens.AitareyaUpanishad> { AitareyaUpanishadScreen() }
        composable<Screens.AkshiUpanishad> { AkshiUpanishadScreen() }
        composable<Screens.AmritabinduUpanishad> { AmritabinduUpanishadScreen() }
        composable<Screens.AmritaNadaUpanishad> { AmritaNadaUpanishadScreen() }
        composable<Screens.AnnapurnaUpanishad> { AnnapurnaUpanishadScreen() }
        composable<Screens.AruniUpanishad> { AruniUpanishadScreen() }
        composable<Screens.AtharvashikhaUpanishad> { AtharvashikhaUpanishadScreen() }
        composable<Screens.AtharvashirasUpanishad> { AtharvashirasUpanishadScreen() }
        composable<Screens.AtmaprabodhaUpanishad> { AtmaprabodhaUpanishadScreen() }
        composable<Screens.AtmaUpanishad> { AtmaUpanishadScreen() }
        composable<Screens.AvadhutaUpanishad> { AvadhutaUpanishadScreen() }
        composable<Screens.AvyaktaUpanishad> { AvyaktaUpanishadScreen() }
        composable<Screens.BhikshukaUpanishad> { BhikshukaUpanishadScreen() }
        composable<Screens.BrahmabinduUpanishad> { BrahmabinduUpanishadScreen() }
        composable<Screens.BrahmaUpanishad> { BrahmaUpanishadScreen() }
        composable<Screens.Brahmopanishad> { BrahmopanishadScreen() }
        composable<Screens.BrihadJabalaUpanishad> { BrihadJabalaUpanishadScreen() }
        composable<Screens.DakshinamurtiUpanishad> { DakshinamurtiUpanishadScreen() }
        composable<Screens.DattatreyaUpanishad> { DattatreyaUpanishadScreen() }
        composable<Screens.DhyanabinduUpanishad> { DhyanabinduUpanishadScreen() }
        composable<Screens.DhyanaUpanishad> { DhyanaUpanishadScreen() }
        composable<Screens.EkaksharaUpanishad> { EkaksharaUpanishadScreen() }
        composable<Screens.GanapatiAtharvashirsha> { GanapatiAtharvashirshaScreen() }
        composable<Screens.GaneshaUpanishad> { GaneshaUpanishadScreen() }
        composable<Screens.GarbhaUpanishad> { GarbhaUpanishadScreen() }
        composable<Screens.GarudaUpanishad> { GarudaUpanishadScreen() }
        composable<Screens.GayatriUpanishad> { GayatriUpanishadScreen() }
        composable<Screens.HamsaUpanishad> { HamsaUpanishadScreen() }
        composable<Screens.HayagrivaUpanishad> { HayagrivaUpanishadScreen() }
        composable<Screens.IshaUpanishad> { IshaUpanishadScreen() }
        composable<Screens.JabalaUpanishad> { JabalaUpanishadScreen() }
        composable<Screens.KaivalyaUpanishad> { KaivalyaUpanishadScreen() }
        composable<Screens.KalagnirudraUpanishad> { KalagnirudraUpanishadScreen() }
        composable<Screens.KaliSantaranaUpanishad> { KaliSantaranaUpanishadScreen() }
        composable<Screens.MahaUpanishad> { MahaUpanishadScreen() }
        composable<Screens.PanchabrahmaUpanishad> { PanchabrahmaUpanishadScreen() }
        composable<Screens.ShatyayaniyaUpanishad> { ShatyayaniyaUpanishadScreen() }
        composable<Screens.KathaUpanishad> { KathaUpanishadScreen() }
        composable<Screens.KenaUpanishad> { KenaUpanishadScreen() }
        composable<Screens.KrishnaUpanishad> { KrishnaUpanishadScreen() }
        composable<Screens.KundikaUpanishad> { KundikaUpanishadScreen() }
        composable<Screens.MahavakyaUpanishad> { MahavakyaUpanishadScreen() }
        composable<Screens.MaitreyaUpanishad> { MaitreyaUpanishadScreen() }
        composable<Screens.MaitreyiUpanishad> { MaitreyiUpanishadScreen() }
        composable<Screens.MandukyaUpanishad> { MandukyaUpanishadScreen() }
        composable<Screens.MudgalaUpanishad> { MudgalaUpanishadScreen() }
        composable<Screens.MundakaUpanishad> { MundakaUpanishadScreen() }
        composable<Screens.NadabinduUpanishad> { NadabinduUpanishadScreen() }
        composable<Screens.NarayanUpanishad> { NarayanUpanishadScreen() }
        composable<Screens.NiralambaUpanishad> { NiralambaUpanishadScreen() }
        composable<Screens.NirvanaUpanishad> { NirvanaUpanishadScreen() }
        composable<Screens.PaingalaUpanishad> { PaingalaUpanishadScreen() }
        composable<Screens.ParamahamsaUpanishad> { ParamahamsaUpanishadScreen() }
        composable<Screens.PashupataUpanishad> { PashupataUpanishadScreen() }
        composable<Screens.PrashnaUpanishad> { PrashnaUpanishadScreen() }
        composable<Screens.RamRahasyaUpanishad> { RamRahasyaUpanishadScreen() }
        composable<Screens.RudraHridayaUpanishad> { RudraHridayaUpanishadScreen() }
        composable<Screens.RudrakshaJabalaUpanishad> { RudrakshaJabalaUpanishadScreen() }
        composable<Screens.PranagnihotraUpanishad> { PranagnihotraUpanishadScreen() }
        composable<Screens.UpanishadDashboard> { UpanishadScreen(navController = navController) }
        composable<Screens.BahvrichaUpanishad> { BahvrichaUpanishadScreen() }
        composable<Screens.DeviUpanishad> { DeviUpanishadScreen() }
        composable<Screens.SannyasaUpanishad> { SannyasaUpanishadScreen() }
        composable<Screens.SarirakaUpanishad> { SarirakaUpanishadScreen() }
        composable<Screens.SarvasaraUpanishad> { SarvasaraUpanishadScreen() }
        composable<Screens.SaubhagyaLakshmiUpanishad> { SaubhagyaLakshmiUpanishadScreen() }
        composable<Screens.SavitriUpanishad> { SavitriUpanishadScreen() }
        composable<Screens.SharabhaUpanishad> { SharabhaUpanishadScreen() }
        composable<Screens.ShvetashvataraUpanishad> { ShvetashvataraUpanishadScreen() }
        composable<Screens.ParabrahmaUpanishad> { ParabrahmaUpanishadScreen() }
        composable<Screens.ShukarahasyaUpanishad> { ShukarahasyaUpanishadScreen() }
        composable<Screens.SitaUpanishad> { SitaUpanishadScreen() }
        composable<Screens.SkandaUpanishad> { SkandaUpanishadScreen() }
        composable<Screens.SubalaUpanishad> { SubalaUpanishadScreen() }
        composable<Screens.SuryaUpanishad> { SuryaUpanishadScreen() }
        composable<Screens.TaittiriyaUpanishad> { TaittiriyaUpanishadScreen() }
        composable<Screens.TarasaraUpanishad> { TarasaraUpanishadScreen() }
        composable<Screens.TejobinduUpanishad> { TejobinduUpanishadScreen() }
        composable<Screens.TripuratapiniUpanishad> { TripuratapiniUpanishadScreen() }
        composable<Screens.TripuraUpanishad> { TripuraUpanishadScreen() }
        composable<Screens.TuriyatitaUpanishad> { TuriyatitaUpanishadScreen() }
        composable<Screens.VajrasuchiUpanishad> { VajrasuchiUpanishadScreen() }
        composable<Screens.VasudevaUpanishad> { VasudevaUpanishadScreen() }
        composable<Screens.YogashikhaUpanishad> { YogashikhaUpanishadScreen() }

        // --- 6. RAMAYAN ---
        composable<Screens.RamayanMenu> { Ramayan(navController = navController) }
        composable<Screens.BaalKandMenu> { BaalKand(navController = navController) }
        composable<Screens.BaalKandSargaOne> { SargaOneScreen() }
        composable<Screens.BaalKandSargaTwo> { SargaTwoScreen() }
        composable<Screens.BaalKandSargaThree> { SargaThreeScreen() }
        composable<Screens.BaalKandSargaFour> { SargaFourScreen() }
        composable<Screens.BaalKandSargaFive> { SargaFive() }
        composable<Screens.BaalKandSargaSix> { SargaSixScreen() }
        composable<Screens.BaalKandSargaSeven> { SargaSevenScreen() }
        composable<Screens.BaalKandSargaEight> { SargaEight() }
        composable<Screens.BaalKandSargaNine> { SargaNineScreen() }
        composable<Screens.BaalKandSargaTen> { SargaTenScreen() }
        composable<Screens.BaalKandSargaEleven> { SargaElevenScreen() }

        // --- 7. SAMVEDA ---

        // Main Hub
        composable<Screens.SamvedaHub> {
            SamvedaHubScreen(
                onPurvarchikaClick = { navController.navigate(Screens.Purvarchika) },
                onUttararchikaClick = { navController.navigate(Screens.Uttararchika) }
            )
        }

        // Purvarchika
        composable<Screens.Purvarchika> { Purvarchika(navController = navController) }
        composable<Screens.PurvarchikaAdhyayaOne> { PurvarchikaAdhyayaOneScreen() }
        composable<Screens.PurvarchikaAdhyayaTwo> { PurvarchikaAdhyayaTwoScreen() }
        composable<Screens.PurvarchikaAdhyayaThree> { PurvarchikaAdhyayaThreeScreen() }
        composable<Screens.PurvarchikaAdhyayaFour> { PurvarchikaAdhyayaFourScreen() }
        composable<Screens.PurvarchikaAdhyayaFive> { PurvarchikaAdhyayaFiveScreen() }
        composable<Screens.PurvarchikaAdhyayaSix> { PurvarchikaAdhyayaSixScreen() }

        // Uttararchika
        composable<Screens.Uttararchika> {
            UttararchikaScreen(onAdhyayaClick = { id ->
                when (id) {
                    1 -> navController.navigate(Screens.UttararchikaAdhyayaOne)
                    2 -> navController.navigate(Screens.UttararchikaAdhyayaTwo)
                    3 -> navController.navigate(Screens.UttararchikaAdhyayaThree)
                    4 -> navController.navigate(Screens.UttararchikaAdhyayaFour)
                    5 -> navController.navigate(Screens.UttararchikaAdhyayaFive)
                    6 -> navController.navigate(Screens.UttararchikaAdhyayaSix)
                    7 -> navController.navigate(Screens.UttararchikaAdhyayaSeven)
                    8 -> navController.navigate(Screens.UttararchikaAdhyayaEight)
                    9 -> navController.navigate(Screens.UttararchikaAdhyayaNine)
                }
            })
        }
        composable<Screens.UttararchikaAdhyayaOne> { UttararchikaAdhyayaOneScreen() }
        composable<Screens.UttararchikaAdhyayaTwo> { UttararchikaAdhyayaTwoScreen() }
        composable<Screens.UttararchikaAdhyayaThree> { UttararchikaAdhyayaThreeScreen() }
        composable<Screens.UttararchikaAdhyayaFour> { UttararchikaAdhyayaFourScreen() }
        composable<Screens.UttararchikaAdhyayaFive> { UttararchikaAdhyayaFiveScreen() }
        composable<Screens.UttararchikaAdhyayaSix> { UttararchikaAdhyayaSixScreen() }
        composable<Screens.UttararchikaAdhyayaSeven> { UttararchikaAdhyayaSevenScreen() }
        composable<Screens.UttararchikaAdhyayaEight> { UttararchikaAdhyayaEightScreen() }
        composable<Screens.UttararchikaAdhyayaNine> { UttararchikaAdhyayaNineScreen() }
    }
}