package club.theexperiment.reeseword;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean capitalSwitchStatus;
    boolean lowerSwitchStatus;
    boolean numberSwitchStatus;
    boolean symbolSwitchStatus;
    String password;

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
        final Die capital = new dCapital();
        final Die lower = new dLower();
        final Die number = new dNumber();
        final Die symbol = new dSymbol();
        final TextView text = findViewById(R.id.textView);


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
                password = "";

                int numRolls = Integer.parseInt(numRollsString);

                int checked = 0;

                if (symbolSwitchStatus) checked++;
                if (numberSwitchStatus) checked++;
                if (capitalSwitchStatus) checked++;
                if (lowerSwitchStatus) checked++;

                int eachNum = numRolls / checked;

                int extra = 0;

                while (eachNum * checked < numRolls) {
                    extra++;
                }

                if (lowerSwitchStatus) { lower.roll(eachNum+extra); password+=lower.getWord(); }
                if (capitalSwitchStatus) { capital.roll(eachNum); password+=capital.getWord(); }
                if (numberSwitchStatus) { number.roll(eachNum); password+=number.getWord(); }
                if (symbolSwitchStatus) { symbol.roll(eachNum); password+=symbol.getWord(); }

                text.setText(password);

            }

        });
    }
}
