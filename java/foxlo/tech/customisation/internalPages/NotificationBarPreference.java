package foxlo.tech.customisation.internalPages;

import static com.android.internal.util.fox.ThemeUtils.ICON_SHAPE_KEY;
import static foxlo.tech.customisation.others.Colors.material_colors;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.android.internal.util.fox.ThemeUtils;
import com.google.android.material.appbar.AppBarLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

import foxlo.tech.customisation.R;
import foxlo.tech.customisation.colorPicker.ColorPicker;

public class NotificationBarPreference extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    private ThemeUtils mThemeUtils;
    private List<String> mPkgs;
    private String mCategory = ICON_SHAPE_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        AppBarLayout abl = findViewById(R.id.notification_pref_topbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        try {
            JSONObject jObject = new JSONObject(material_colors);
            JSONObject r = jObject.getJSONObject("red");


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        mThemeUtils = new ThemeUtils(this);
        mPkgs = mThemeUtils.getOverlayPackagesForCategory(mCategory, "android");
        Collections.sort(mPkgs);
        Log.d("TAG", "onCreate: "+mPkgs);
//        mThemeUtils.setOverlayEnabled(mCategory, mPkgs.get(position));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String s) {

    }


    public static class SettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            Preference myPref = (Preference) findPreference("monet_select");
            Preference vibrant = (Preference) findPreference("vibrant_select");
            myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    ColorPicker alert = new ColorPicker();
                    alert.showDialog(getActivity(), "Beta Phase");
                    return true;
                }
            });
            vibrant.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {


                    return true;
                }
            });
        }
    }
}