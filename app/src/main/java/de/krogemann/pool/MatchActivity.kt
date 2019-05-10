package de.krogemann.pool

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.krogemann.pool.match.Match
import kotlinx.android.synthetic.main.activity_match.*

class MatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        val match = intent.extras.getParcelable<Match>("MATCH")
        initializeDisplayState(match)
    }

    private fun initializeDisplayState(match: Match) {
        team_one_wins.setText(match.teamOne + " wins")
        team_two_wins.setText(match.teamTwo + " wins")
        first_break_name.setText(match.teamOne)
        current_break_name.setText(match.teamOne)
        next_break_name.setText(match.teamTwo)
    }
}