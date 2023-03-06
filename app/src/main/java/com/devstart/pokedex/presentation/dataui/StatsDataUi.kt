package com.devstart.pokedex.presentation.dataui

data class StatsDataUi(
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int
) {
    fun getHpPercentage(): Float {
        val maxStat = maxOf(hp, attack, defense, speed)
        return hp.toFloat() / maxStat.toFloat()
    }

    fun getAttackPercentage(): Float {
        val maxStat = maxOf(hp, attack, defense, speed)
        return attack.toFloat() / maxStat.toFloat()
    }

    fun getDefensePercentage(): Float {
        val maxStat = maxOf(hp, attack, defense, speed)
        return defense.toFloat() / maxStat.toFloat()
    }

    fun getSpeedPercentage(): Float {
        val maxStat = maxOf(hp, attack, defense, speed)
        return speed.toFloat() / maxStat.toFloat()
    }
}
