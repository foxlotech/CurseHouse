package foxlo.tech.customisation.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

import foxlo.tech.customisation.R;
import foxlo.tech.customisation.internalPages.NotificationBarPreference;

public class HomePage extends Fragment {
    String cnv = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);
        GridLayout gridview = (GridLayout) view.findViewById(R.id.gridview);
        MaterialCardView notification_shade = (MaterialCardView) view.findViewById(R.id.notification_pref);
        notification_shade.setOnClickListener((e)->{
            Intent myIntent = new Intent(this.getContext(), NotificationBarPreference.class);
            startActivity(myIntent);
        });

        return view;

    }


    public static HomePage newInstance(String param1, String param2) {
        HomePage fragment = new HomePage();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


}
