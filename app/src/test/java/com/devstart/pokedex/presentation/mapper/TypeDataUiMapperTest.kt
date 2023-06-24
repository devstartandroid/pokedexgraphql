package com.devstart.pokedex.presentation.mapper

import com.devstart.pokedex.domain.model.Type
import com.devstart.pokedex.presentation.dataui.TypeDataUi
import com.google.common.truth.Truth
import org.junit.Test

class TypeDataUiMapperTest {

    val subjectMapper = TypeDataUiMapper()

    @Test
    fun `when toItem is called SHOULD map correctly`() {
        // When
        val resultNormal = subjectMapper.toItem(Type.NORMAL)
        val fightingNormal = subjectMapper.toItem(Type.FIGHTING)
        val resultFlying = subjectMapper.toItem(Type.FLYING)
        val resultPoison = subjectMapper.toItem(Type.POISON)
        val resultGround = subjectMapper.toItem(Type.GROUND)
        val resultROck = subjectMapper.toItem(Type.ROCK)
        val resultBug = subjectMapper.toItem(Type.BUG)
        val resultGhost = subjectMapper.toItem(Type.GHOST)
        val resultSteel = subjectMapper.toItem(Type.STEEL)
        val resultFire = subjectMapper.toItem(Type.FIRE)
        val resultGrass = subjectMapper.toItem(Type.GRASS)
        val resultElectric = subjectMapper.toItem(Type.ELECTRIC)
        val resultPsychic = subjectMapper.toItem(Type.PSYCHIC)
        val resultIce = subjectMapper.toItem(Type.ICE)
        val resultDragon = subjectMapper.toItem(Type.DRAGON)
        val resultDark = subjectMapper.toItem(Type.DARK)
        val resultFairy = subjectMapper.toItem(Type.FAIRY)
        val resultUnknown = subjectMapper.toItem(Type.UNKNOWN)
        val resultShadow = subjectMapper.toItem(Type.SHADOW)

        // Then
        Truth.assertThat(resultNormal).isEqualTo(TypeDataUi.NORMAL)
        Truth.assertThat(fightingNormal).isEqualTo(TypeDataUi.FIGHTING)
        Truth.assertThat(resultFlying).isEqualTo(TypeDataUi.FLYING)
        Truth.assertThat(resultPoison).isEqualTo(TypeDataUi.POISON)
        Truth.assertThat(resultGround).isEqualTo(TypeDataUi.GROUND)
        Truth.assertThat(resultROck).isEqualTo(TypeDataUi.ROCK)
        Truth.assertThat(resultBug).isEqualTo(TypeDataUi.BUG)
        Truth.assertThat(resultGhost).isEqualTo(TypeDataUi.GHOST)
        Truth.assertThat(resultSteel).isEqualTo(TypeDataUi.STEEL)
        Truth.assertThat(resultFire).isEqualTo(TypeDataUi.FIRE)
        Truth.assertThat(resultGrass).isEqualTo(TypeDataUi.GRASS)
        Truth.assertThat(resultElectric).isEqualTo(TypeDataUi.ELECTRIC)
        Truth.assertThat(resultPsychic).isEqualTo(TypeDataUi.PSYCHIC)
        Truth.assertThat(resultIce).isEqualTo(TypeDataUi.ICE)
        Truth.assertThat(resultDragon).isEqualTo(TypeDataUi.DRAGON)
        Truth.assertThat(resultDark).isEqualTo(TypeDataUi.DARK)
        Truth.assertThat(resultFairy).isEqualTo(TypeDataUi.FAIRY)
        Truth.assertThat(resultUnknown).isEqualTo(TypeDataUi.UNKNOWN)
        Truth.assertThat(resultShadow).isEqualTo(TypeDataUi.SHADOW)
    }
}