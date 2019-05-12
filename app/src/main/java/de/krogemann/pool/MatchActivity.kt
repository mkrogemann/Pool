package de.krogemann.pool

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.krogemann.pool.match.Match
import kotlinx.android.synthetic.main.activity_match.*

class MatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        var match = intent.extras.getParcelable<Match>("MATCH")
        initializeDisplayState(match)

        team_one_wins.setOnClickListener {
            match = nextMatchState(match, teamOneWins = true)
        }

        team_two_wins.setOnClickListener {
            match = nextMatchState(match, teamOneWins = false)
        }
    }

    private fun nextMatchState(match: Match, teamOneWins: Boolean): Match {
        return if (teamOneWins) {
            val nextMatchState = match.copy(
                teamOneWins = match.teamOneWins + 1, teamTwoWins = match.teamTwoWins,
                nextBreak = if (match.winnerBreak) "?" else match.currentBreak,
                currentBreak = if (match.winnerBreak) match.teamOne else match.nextBreak)
            updateDisploayState(nextMatchState)
            nextMatchState
        } else {
            val nextMatchState = match.copy(
                teamOneWins = match.teamOneWins, teamTwoWins = match.teamTwoWins + 1,
                nextBreak = if (match.winnerBreak) "?" else match.currentBreak,
                currentBreak = if (match.winnerBreak) match.teamTwo else match.nextBreak)
            updateDisploayState(nextMatchState)
            nextMatchState
        }
    }

    private fun updateDisploayState(nextMatchState: Match) {
        rack_counter.text = (nextMatchState.teamOneWins + nextMatchState.teamTwoWins + 1).toString()
        team_one_score.text = nextMatchState.teamOneWins.toString()
        team_two_score.text = nextMatchState.teamTwoWins.toString()
        current_break_name.setText(nextMatchState.currentBreak)
    }

    private fun initializeDisplayState(match: Match) {
        val teamOneWinsString = getString(R.string.team_wins, match.teamOne)
        val teamTwoWinsString = getString(R.string.team_wins, match.teamTwo)
        team_one_wins.text = teamOneWinsString
        team_two_wins.text = teamTwoWinsString
        current_break_name.setText(match.teamOne)
        team_one_score.text = "0"
        team_two_score.text = "0"
        rack_counter.text = "1"
    }
}