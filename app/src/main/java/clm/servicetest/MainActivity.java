package clm.servicetest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    SharedPreferences.Editor editor;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();



        tv=(TextView) findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,GetHtml.class);
                startService(intent);

                String text=""+sp.getFloat("ILS",0);

                tv.setText(text);

            }
        });*/




    }
}
