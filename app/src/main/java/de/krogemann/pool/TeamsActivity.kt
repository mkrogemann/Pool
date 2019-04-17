package de.krogemann.pool

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_teams.*

class TeamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        start_match_button.setOnClickListener {
            // create match and switch to match activity
            startActivity(Intent(this, MatchActivity::class.java))
        }
    }
}