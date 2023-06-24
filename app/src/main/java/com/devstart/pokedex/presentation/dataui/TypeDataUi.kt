package com.devstart.pokedex.presentation.dataui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.devstart.pokedex.R
import com.devstart.pokedex.ui.theme.BUG_COLOR
import com.devstart.pokedex.ui.theme.DARK_COLOR
import com.devstart.pokedex.ui.theme.DRAGON_COLOR
import com.devstart.pokedex.ui.theme.ELECTRIC_COLOR
import com.devstart.pokedex.ui.theme.FAIRY_COLOR
import com.devstart.pokedex.ui.theme.FIGHTING_COLOR
import com.devstart.pokedex.ui.theme.FIRE_COLOR
import com.devstart.pokedex.ui.theme.FLYING_COLOR
import com.devstart.pokedex.ui.theme.GHOST_COLOR
import com.devstart.pokedex.ui.theme.GRASS_COLOR
import com.devstart.pokedex.ui.theme.GROUND_COLOR
import com.devstart.pokedex.ui.theme.ICE_COLOR
import com.devstart.pokedex.ui.theme.NORMAL_COLOR
import com.devstart.pokedex.ui.theme.POISON_COLOR
import com.devstart.pokedex.ui.theme.PSYCHIC_COLOR
import com.devstart.pokedex.ui.theme.ROCK_COLOR
import com.devstart.pokedex.ui.theme.SHADOW_COLOR
import com.devstart.pokedex.ui.theme.STEEL_COLOR
import com.devstart.pokedex.ui.theme.UNKNOWN_COLOR
import com.devstart.pokedex.ui.theme.WATER_COLOR

enum class TypeDataUi(
    val typeName: String,
    @DrawableRes val typeIcon: Int,
    val backgroundColor: Color
) {
    NORMAL(typeName = "Normal", typeIcon = R.drawable.normal, backgroundColor = NORMAL_COLOR),
    FIGHTING(typeName = "Fighting", typeIcon = R.drawable.fighting, backgroundColor = FIGHTING_COLOR),
    FLYING(typeName = "Flying", typeIcon = R.drawable.flying, backgroundColor = FLYING_COLOR),
    POISON(typeName = "Poison", typeIcon = R.drawable.poison, backgroundColor = POISON_COLOR),
    GROUND(typeName = "Ground", typeIcon = R.drawable.ground, backgroundColor = GROUND_COLOR),
    ROCK(typeName = "Rock", typeIcon = R.drawable.rock, backgroundColor = ROCK_COLOR),
    BUG(typeName = "Bug", typeIcon = R.drawable.bug, backgroundColor = BUG_COLOR),
    GHOST(typeName = "Ghost", typeIcon = R.drawable.ghost, backgroundColor = GHOST_COLOR),
    STEEL(typeName = "Steel", typeIcon = R.drawable.steel, backgroundColor = STEEL_COLOR),
    FIRE(typeName = "Fire", typeIcon = R.drawable.fire, backgroundColor = FIRE_COLOR),
    WATER(typeName = "Water", typeIcon = R.drawable.water, backgroundColor = WATER_COLOR),
    GRASS(typeName = "Grass", typeIcon = R.drawable.grass, backgroundColor = GRASS_COLOR),
    ELECTRIC(typeName = "Electric", typeIcon = R.drawable.electric, backgroundColor = ELECTRIC_COLOR),
    PSYCHIC(typeName = "Psychic", typeIcon = R.drawable.psychic, backgroundColor = PSYCHIC_COLOR),
    ICE(typeName = "Ice", typeIcon = R.drawable.ice, backgroundColor = ICE_COLOR),
    DRAGON(typeName = "Dragon", typeIcon = R.drawable.dragon, backgroundColor = DRAGON_COLOR),
    DARK(typeName = "Dark", typeIcon = R.drawable.dark, backgroundColor = DARK_COLOR),
    FAIRY(typeName = "Fairy", typeIcon = R.drawable.fairy, backgroundColor = FAIRY_COLOR),
    UNKNOWN(typeName = "Unknown", typeIcon = 0, backgroundColor = UNKNOWN_COLOR),
    SHADOW(typeName = "Shadow", typeIcon = 0, backgroundColor = SHADOW_COLOR),
}
