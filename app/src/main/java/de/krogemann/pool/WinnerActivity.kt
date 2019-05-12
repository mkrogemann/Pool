package de.krogemann.pool

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.krogemann.pool.match.Match
import kotlinx.android.synthetic.main.activity_winner.*

class WinnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        val match = intent.extras.getParcelable<Match>("MATCH")
        val winner = if (match.teamOneWins == match.raceTo) match.teamOne else match.teamTwo
        val congratulationText = getString(R.string.congratulations_you_win_final_score, winner, match.teamOne, match.teamOneWins, match.teamTwo, match.teamTwoWins)

        congrats_label.text = congratulationText
    }
}