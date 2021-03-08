package fi.arcada.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SharedPreferences prefs;

    TextView textSetting;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        /*SharedPreferences.Editor prefsEditor = prefs.edit();

        prefsEditor.putString("myText", "Hej!");
        prefsEditor.apply();*/

        myText = findViewById(R.id.editTextView);
        textSetting = findViewById(R.id.textSetting);

        myText.setText(prefs.getString("myOtherText", "Morjens"));

        textSetting.setText(prefs.getString("textSetting", "def val"));
    }

    public void buttonClick(View view){

        if(view.getId() == R.id.buttonSave){
            SharedPreferences.Editor prefsEditor = prefs.edit();

            prefsEditor.putString("myOtherText", myText.getText().toString());
            prefsEditor.apply();
        } else if(view.getId() == R.id.buttonOtherActivity){
            Intent intent = new Intent(this, OtherActivity.class);
            startActivity(intent);
        } else if(view.getId() == R.id.buttonSettings){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

    }
}