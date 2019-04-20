package de.krogemann.pool.match

import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Test

class MatchTest {

    @Test
    fun constructs_with_sensible_defaults() {
        val match = Match(teamOne = "tean_one", teamTwo = "team_two",
            raceTo = null, winnerBreak = false)

        assertThat(match.teamOne, `is`("tean_one"))
        assertThat(match.teamTwo, `is`("team_two"))
        assertThat(match.teamOneWins, `is`(0))
        assertThat(match.teamTwoWins, `is`(0))
        assertThat(match.winnerBreak, `is`(false))
        assertThat(match.finished, `is`(false))
        assertThat(match.isRace(), `is`(false))
    }
}