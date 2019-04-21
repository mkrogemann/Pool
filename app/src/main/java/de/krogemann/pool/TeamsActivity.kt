package de.krogemann.pool

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import de.krogemann.pool.match.Match
import kotlinx.android.synthetic.main.activity_teams.*

class TeamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        race_checkbox.setOnClickListener {
            setRaceVisibility()
        }

        start_match_button.setOnClickListener {
            val bundle = Bundle()
            val intent = Intent(this, MatchActivity::class.java)
            val match = setupMatch()
            bundle.putParcelable("MATCH", match)
            intent.putExtras(bundle)

            startActivity(intent)
        }
    }

    private fun setRaceVisibility() {
        if (race_checkbox.isChecked) {
            race_to.visibility = View.VISIBLE
            race_to_label.visibility = View.VISIBLE
        } else {
            race_to.visibility = View.INVISIBLE
            race_to_label.visibility = View.INVISIBLE
        }
    }

    private fun setupMatch(): Match {
        val match = Match(
            teamOne = team_one.text.toString(),
            teamTwo = team_two.text.toString(),
            raceTo = if (race_checkbox.isChecked) {
                race_to.text.toString().toInt()
            } else {
                null
            },
            winnerBreak = winner_break.isChecked
        )
        return match
    }
}