package kg.unicapp.frtofr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), FragmentAListener, FragmentBListener {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.myDrawer)
        navigationView = findViewById(R.id.navView)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_settings ->  Toast.makeText(this, "Нечего настраивать", Toast.LENGTH_SHORT).show()
                R.id.about_app -> Toast.makeText(this, "Это мое приложение", Toast.LENGTH_SHORT).show()
                R.id.add_something -> Toast.makeText(this, "Позже добавите", Toast.LENGTH_SHORT).show()
                R.id.close_app -> finish()
            }
            true
        }


        setup()

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            true
        }

        return super.onOptionsItemSelected(item)
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