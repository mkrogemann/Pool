package de.krogemann.pool.match

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match(
    val teamOne: String,
    val teamTwo: String,
    val raceTo: Int?,
    val winnerBreak: Boolean,
    val teamOneWins: Int = 0,
    val teamTwoWins: Int = 0,
    val firstBreak: String = teamOne,
    val currentBreak: String = teamOne,
    val nextBreak: String = if (winnerBreak) "?" else teamTwo,
    val finished: Boolean = false
) : Parcelable {

    fun isRace(): Boolean = raceTo != null
}
