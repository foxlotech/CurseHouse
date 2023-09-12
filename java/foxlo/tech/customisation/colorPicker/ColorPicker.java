package foxlo.tech.customisation.colorPicker;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.json.JSONException;
import org.json.JSONObject;
import foxlo.tech.customisation.R;

public class ColorPicker {
    Dialog dialog;

    @SuppressLint("ResourceType")
    public void showDialog(Activity activity, String msg) {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.color_picker);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);


        FloatingActionButton red = dialog.findViewById(R.id.red);
        FloatingActionButton pink = dialog.findViewById(R.id.pink);
        FloatingActionButton purple = dialog.findViewById(R.id.purple);
        FloatingActionButton deeppurple = dialog.findViewById(R.id.deeppurple);
        FloatingActionButton indigo = dialog.findViewById(R.id.indigo);
        FloatingActionButton blue = dialog.findViewById(R.id.blue);
        FloatingActionButton lightbue = dialog.findViewById(R.id.lightblue);
        FloatingActionButton cyan = dialog.findViewById(R.id.cyan);
        FloatingActionButton teal = dialog.findViewById(R.id.teal);
        FloatingActionButton green = dialog.findViewById(R.id.green);
        FloatingActionButton lightgreen = dialog.findViewById(R.id.lightgreen);
        FloatingActionButton lime = dialog.findViewById(R.id.lime);
        FloatingActionButton yellow = dialog.findViewById(R.id.yellow);
        FloatingActionButton amber = dialog.findViewById(R.id.amber);
        FloatingActionButton orange = dialog.findViewById(R.id.orange);
        FloatingActionButton deeporange = dialog.findViewById(R.id.deeporange);
        FloatingActionButton brown = dialog.findViewById(R.id.brown);
        FloatingActionButton grey = dialog.findViewById(R.id.grey);
        FloatingActionButton bluegrey = dialog.findViewById(R.id.bluegree);


        red.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.red).replace("#", ""), activity);
        });
        blue.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.blue).replace("#", ""), activity);
        });
        pink.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.pink).replace("#", ""), activity);
        });
        purple.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.purple).replace("#", ""), activity);
        });
        deeppurple.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.deeppurple).replace("#", ""), activity);
        });
        indigo.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.indigo).replace("#", ""), activity);
        });
        lightbue.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.lightbue).replace("#", ""), activity);
        });
        cyan.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.cyan).replace("#", ""), activity);
        });
        teal.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.teal).replace("#", ""), activity);
        });
        green.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.green).replace("#", ""), activity);
        });
        lightgreen.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.lightgreen).replace("#", ""), activity);
        });
        lime.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.lime).replace("#", ""), activity);
        });
        yellow.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.yellow).replace("#", ""), activity);
        });
        amber.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.amber).replace("#", ""), activity);
        });
        orange.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.yellow).replace("#", ""), activity);
        });
        deeporange.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.amber).replace("#", ""), activity);
        });
        brown.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.brown).replace("#", ""), activity);
        });
        grey.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.grey).replace("#", ""), activity);
        });
        bluegrey.setOnClickListener((r) -> {
            applyColor(activity.getString(R.color.bluegrey).replace("#", ""), activity);
        });


        dialog.show();

    }

    public void applyColor(String c, Activity activity) {
        Log.d("TAG", "applyColor: " + c.toUpperCase());
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject("{}");
            jSONObject.putOpt("android.theme.customization.color_index", 1);
            jSONObject.putOpt("android.theme.customization.color_source", "preset");
            jSONObject.putOpt("android.theme.customization.system_palette", c.toUpperCase());
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
        dialog.dismiss();
        Settings.Secure.putString(activity.getContentResolver(), "theme_customization_overlay_packages", jSONObject.toString());

    }


}