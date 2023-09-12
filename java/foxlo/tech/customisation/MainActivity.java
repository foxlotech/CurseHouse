package foxlo.tech.customisation;

import static com.google.android.material.navigation.NavigationBarView.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import foxlo.tech.customisation.pages.HomePage;
import foxlo.tech.customisation.pages.SettingsPage;
import foxlo.tech.customisation.pages.Wallpaper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFragment(HomePage.newInstance("", ""));
        BottomNavigationView btm = findViewById(R.id.bottom_navigation);
        btm.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (item.getTitle().toString().equals("Home")) {
                    openFragment(HomePage.newInstance("", ""));
                } else if (item.getTitle().toString().equals("Wallpaper")) {
                    openFragment(Wallpaper.newInstance("", ""));
                } else if (item.getTitle().toString().equals("Settings")) {
                    openFragment(SettingsPage.newInstance("", ""));
                }

                return true;
            }
        });

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}