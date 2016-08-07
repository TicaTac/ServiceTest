package clm.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.TimerTask;



public class GetHtml extends IntentService {

    mTimer timer;
    public GetHtml() {
        super("GetHtml");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String doc = null;
        try {

            doc = Jsoup.connect("http://api.fixer.io/latest").ignoreContentType(true).execute().body();
            JSONObject obj=new JSONObject(doc);
            JSONObject rates=obj.getJSONObject("rates");
            double ils = rates.getDouble("ILS");

            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sp.edit();

            editor.putFloat("ILS",(float) ils);
            editor.commit();

            if (timer==null) {
                timer = new mTimer();
            }
            else {
                //timer.
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public class mTimer extends TimerTask    {
        private Handler handler=new Handler();

        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(GetHtml.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            });

        }
    }

}