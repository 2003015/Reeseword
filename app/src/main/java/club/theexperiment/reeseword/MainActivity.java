package club.theexperiment.reeseword;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    boolean capitalSwitchStatus;
    boolean lowerSwitchStatus;
    boolean numberSwitchStatus;
    boolean symbolSwitchStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch capitalSwitch = findViewById(R.id.capitalSwitch);
        final Switch lowerSwitch = findViewById(R.id.lowerSwitch);
        final Switch numberSwitch = findViewById(R.id.numberSwitch);
        final Switch symbolSwitch = findViewById(R.id.symbolSwitch);
        Button button = findViewById(R.id.button);
        final String numRollsString = ((EditText) findViewById(R.id.editText)).getText().toString();

        capitalSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    capitalSwitchStatus = true;
                } else {
                    capitalSwitchStatus = false;
                }
            }
        });

        lowerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    lowerSwitchStatus = true;
                } else {
                    lowerSwitchStatus = false;
                }
            }
        });

        numberSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    numberSwitchStatus = true;
                } else {
                    numberSwitchStatus = false;
                }
            }
        });

        symbolSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    symbolSwitchStatus = true;
                } else {
                    symbolSwitchStatus = false;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numRolls = Integer.parseInt(numRollsString);
            }

        });
    }
}
