package com.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LockScreenReceiver extends BroadcastReceiver {
    public static boolean wasScreenOn = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        boolean launch = false;

        if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            wasScreenOn = false;
            launch = true;
        } else if (action.equals(Intent.ACTION_SCREEN_ON)) {
            wasScreenOn = true;
        } else if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            launch = true;
        }

        if (launch) {
            Intent intent11 = new Intent(context, LockScreenAppActivity.class);
            intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent11);
        }

    }


}
