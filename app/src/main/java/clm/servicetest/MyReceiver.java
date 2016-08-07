package clm.servicetest;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
        try {
            wallpaperManager.setResource(R.drawable.android);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
