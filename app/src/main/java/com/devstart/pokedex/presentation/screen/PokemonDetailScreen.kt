package com.devstart.pokedex.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.devstart.pokedex.R
import com.devstart.pokedex.presentation.dataui.StatsDataUi
import com.devstart.pokedex.presentation.dataui.TypeDataUi
import com.devstart.pokedex.presentation.state.PokemonDetailState
import com.devstart.pokedex.ui.components.AppGradientBackgroundPokemonCard
import com.devstart.pokedex.ui.components.AppLoadingPokeBall
import com.devstart.pokedex.ui.components.AppStatsCard
import com.devstart.pokedex.ui.theme.ATTACK_BAR_COLOR
import com.devstart.pokedex.ui.theme.DEFENSE_BAR_COLOR
import com.devstart.pokedex.ui.theme.HP_BAR_COLOR
import com.devstart.pokedex.ui.theme.PokeDexTheme
import com.devstart.pokedex.ui.theme.SPEED_BAR_COLOR
import com.devstart.pokedex.ui.theme.TAB_ROW_COLOR

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    pokemonDetailState: PokemonDetailState,
    type: TypeDataUi,
    onPokemonEvolutionClick: (String) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {

        if (pokemonDetailState.loading) {
            PokemonDetailLoading()
        }

        if (pokemonDetailState.loading.not() && pokemonDetailState.error == null) {
            PokemonDetailContent(
                pokemonDetailState = pokemonDetailState,
                type = type,
                onPokemonEvolutionClick = onPokemonEvolutionClick
            )
        }
    }
}

@Composable
fun PokemonDetailLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AppLoadingPokeBall(modifier = Modifier.size(64.dp))
    }
}

@Composable
fun PokemonDetailContent(
    pokemonDetailState: PokemonDetailState,
    type: TypeDataUi,
    onPokemonEvolutionClick: (String) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
    ) {
        val (spacer, image, content) = createRefs()

        PokemonDetailImage(
            modifier = Modifier.constrainAs(image) {
                top.linkTo(parent.top, 40.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            imageUrl = pokemonDetailState.pokemon?.imageUrl
        )

        Spacer(
            modifier = Modifier
                .constrainAs(spacer) {
                    top.linkTo(parent.top)
                    bottom.linkTo(content.top)
                }
                .height(160.dp)
        )
        AppGradientBackgroundPokemonCard(
            modifier = Modifier
                .constrainAs(content) {
                    top.linkTo(spacer.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                },
            backgroundColor = type.backgroundColor,
            cardShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        ) {
            PokemonDetailCard(
                pokemonDetailState = pokemonDetailState,
                onPokemonEvolutionClick = onPokemonEvolutionClick
            )
        }
    }
}

@Composable
fun PokemonDetailImage(
    modifier: Modifier = Modifier.size(200.dp),
    imageUrl: String?
) {
    val isPreview = LocalInspectionMode.current

    AsyncImage(
        modifier = modifier,
        model = imageUrl,
        contentScale = ContentScale.Crop,
        contentDescription = null,
        placeholder = if (isPreview) painterResource(id = R.drawable.preview_pokemon) else null
    )
}

@Composable
fun PokemonDetailCard(
    pokemonDetailState: PokemonDetailState,
    onPokemonEvolutionClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                top = 100.dp,
                start = 16.dp,
                bottom = 16.dp,
                end = 16.dp
            )
            .fillMaxSize(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(
                alpha = 0.5f
            )
        )
    ) {
        PokemonDetailCardContent(pokemonDetailState, onPokemonEvolutionClick)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonDetailCardContent(
    pokemonDetailState: PokemonDetailState,
    onPokemonEvolutionClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
            .padding(bottom = 16.dp)
    ) {
        pokemonDetailState.pokemon?.stats?.let {
            var state by remember { mutableStateOf(0) }
            val tabTransition = updateTransition(state, label = "")
            val tabOffset by tabTransition.animateDp(
                transitionSpec = {
                    spring(stiffness = Spring.StiffnessLow)
                },
                targetValueByState = { index ->
                    80.dp
                }
            )

            TabRow(
                selectedTabIndex = state,
                containerColor = Color.Transparent,
                modifier = Modifier.fillMaxWidth(),
                divider = {},
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[state]),
                        color = TAB_ROW_COLOR
                    )
                }
            ) {
                Tab(
                    selected = state == 0,
                    onClick = { state = 0 },
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    text = {
                        Text(
                            text = "Stats",
                            color = if (state == 0) TAB_ROW_COLOR else Color.Gray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                        )
                    }
                )
                Tab(
                    selected = state == 1,
                    onClick = {
                        state = 1
                    },
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 16.dp),
                    text = {
                        Text(
                            text = "Evolution",
                            color = if (state == 1) TAB_ROW_COLOR else Color.Gray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                        )
                    }
                )
            }
            if (state == 0) {
                PokemonDetailStats(it)
            }

            if (state == 1) {
                val evolutions =
                    pokemonDetailState.pokemon?.evolutionChain?.sortedBy { pokemonEvolution ->
                        pokemonEvolution.id
                    }
                        ?.filter {
                            it.id != pokemonDetailState.pokemon?.id
                        }
                evolutions?.let {
                    CompositionLocalProvider(
                        LocalOverscrollConfiguration provides null
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 16.dp)
                                .verticalScroll(rememberScrollState())
                        ) {
                            it.forEach { pokemonEvolution ->
                                Row(
                                    modifier = Modifier.clickable {
                                        onPokemonEvolutionClick(pokemonEvolution.name)
                                    },
                                    verticalAlignment = CenterVertically
                                ) {
                                    PokemonDetailImage(
                                        modifier = Modifier.size(100.dp),
                                        imageUrl = pokemonEvolution.imageUrl
                                    )
                                    Text(
                                        modifier = Modifier
                                            .padding(start = 4.dp)
                                            .weight(1f)
                                            .fillMaxWidth(),
                                        text = pokemonEvolution.name.capitalize(Locale.current),
                                        textAlign = TextAlign.Center,
                                        color = if (state == 1) TAB_ROW_COLOR else Color.Gray,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PokemonDetailStats(statsDataUi: StatsDataUi) {
    AppStatsCard(
        modifier = Modifier.padding(top = 16.dp),
        statPercentage = statsDataUi.getHpPercentage(),
        barColor = HP_BAR_COLOR,
        statValue = statsDataUi.hp.toString(),
        stat = "Hp"
    )
    AppStatsCard(
        modifier = Modifier.padding(top = 16.dp),
        statPercentage = statsDataUi.getAttackPercentage(),
        barColor = ATTACK_BAR_COLOR,
        statValue = statsDataUi.attack.toString(),
        stat = "Attack"
    )
    AppStatsCard(
        modifier = Modifier.padding(top = 16.dp),
        statPercentage = statsDataUi.getDefensePercentage(),
        barColor = DEFENSE_BAR_COLOR,
        statValue = statsDataUi.defense.toString(),
        stat = "Speed"
    )
    AppStatsCard(
        modifier = Modifier.padding(top = 16.dp),
        statPercentage = statsDataUi.getSpeedPercentage(),
        barColor = SPEED_BAR_COLOR,
        statValue = statsDataUi.speed.toString(),
        stat = "Defense"
    )
}

@Composable
@Preview
fun PokemonDetailScreenPreview() {
    PokeDexTheme {
        PokemonDetailScreen(
            pokemonDetailState = previewPokemonDetailState,
            type = TypeDataUi.GRASS,
            onPokemonEvolutionClick = {}
        )
    }
}