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
        val teamOneName = valueOrDefault(team_one.text.toString(), "Team 1")
        val teamTwoName = valueOrDefault(team_two.text.toString(), "Team 2")
        val match = Match(
            teamOne = teamOneName,
            teamTwo = teamTwoName,
            raceTo = if (race_checkbox.isChecked) {
                valueOrDefault(race_to.text.toString(), "5").toInt()
            } else {
                null
            },
            winnerBreak = winner_break.isChecked
        )
        return match
    }

    private fun valueOrDefault(value: String, default: String): String {
        if (value.isBlank()) {
            return default
        }
        return value
    }
}