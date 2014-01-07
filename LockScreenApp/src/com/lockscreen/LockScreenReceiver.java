package com.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LockScreenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        boolean launch = false;

        if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            launch = true;
        } else if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            context.startService(new Intent(context, ScreenService.class));
            launch = true;
        }

        if (launch) {
            Intent goHome = new Intent(Intent.ACTION_MAIN);
            goHome.addCategory(Intent.CATEGORY_HOME);
            goHome.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(goHome);
        }

    }


}
