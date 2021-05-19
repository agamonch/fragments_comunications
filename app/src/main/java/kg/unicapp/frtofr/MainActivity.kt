package kg.unicapp.frtofr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(), FragmentAListener, FragmentBListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()

    }

    private fun setup() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, FragmentA(), FragmentA.TAG)
            .add(R.id.container2, FragmentB(), FragmentB.TAG)
            .commit()
    }

    override fun setTextToFragmentB(text: String) {
        (supportFragmentManager.findFragmentByTag(FragmentB.TAG) as FragmentB).setNewText(text)

    }
    override fun setTextToFragmentA(text: String) {
        (supportFragmentManager.findFragmentByTag(FragmentA.TAG) as FragmentA).setNewText(text)

    }
}