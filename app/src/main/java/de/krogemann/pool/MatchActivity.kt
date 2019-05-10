package de.krogemann.pool

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.krogemann.pool.match.Match
import kotlinx.android.synthetic.main.activity_match.*

class MatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        val parcelable = intent.extras.getParcelable<Match>("MATCH")
        val (teamOne, teamTwo, _, _, _, _, _) = parcelable
        team_one_wins.text = "$teamOne wins"
        team_two_wins.text = "$teamTwo wins"
    }
}